package com.nilportugues.eventbus.kafka.avro;

import com.nilportugues.eventbus.*;
import com.nilportugues.eventbus.kafka.avro.sample.UserRegisteredEvent;
import com.nilportugues.eventbus.kafka.avro.sample.UserRegisteredEventAttributes;
import com.nilportugues.eventbus.kafka.avro.sample.UserRegisteredEventPayload;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;


public class KafkaAvroEventBusTest {

    private static EventBus eventBus;
    private static SpyKafkaAvroEventConsumer eventConsumer;
    private static SpyKafkaAvroEventPublisher eventPublisher;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @BeforeClass
    public static void setUp() {
        String topic = "test_topic_" + ZonedDateTime.now().getNano();

        // Create Produces and its dependencies
        final Properties producerProps = KafkaTestConfig.buildProducerProps();
        final KafkaProducerFactory producerFactory = new KafkaProducerFactory(producerProps);
        eventPublisher = new SpyKafkaAvroEventPublisher<>(producerFactory, topic);

        // Create Consumer and its dependencies
        final ClassResolverImpl classResolver = new ClassResolverImpl();
        final TestBeanProvider beanProvider = new TestBeanProvider();
        final Properties consumerProps = KafkaTestConfig.buildConsumerProps();
        consumerProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, UserRegisteredAvroDeserializer.class);

        final EventSubscriber eventSubscriber = new EventSubscriber(beanProvider, classResolver);
        final EventHandlerDispatcherImpl eventDispatcher = new EventHandlerDispatcherImpl(eventSubscriber, classResolver);
        final KafkaConsumerFactory consumerFactory = new KafkaConsumerFactory(consumerProps);
        eventConsumer = new SpyKafkaAvroEventConsumer(eventDispatcher, consumerFactory, topic);

        // Create Event bus
        eventBus = new EventBus(eventPublisher);

        // Register Event Handlers
        eventSubscriber.subscribe(UserRegisteredEvent.class, "EventHandler");
    }

    public static class UserRegisteredAvroDeserializer extends AvroDeserializer<UserRegisteredEvent> {

        public UserRegisteredAvroDeserializer() {
            super(UserRegisteredEvent.class);
        }
    }

    @Test
    public void testItCanProduceAndConsume() throws Exception {

        final UserRegisteredEventAttributes attributes = new UserRegisteredEventAttributes();
        attributes.setCreatedAt(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));

        final UserRegisteredEventPayload payload = new UserRegisteredEventPayload();
        payload.setId("0002");
        payload.setType("user");
        payload.setAttributes(attributes);

        final UserRegisteredEvent event = new UserRegisteredEvent();
        event.setOccurredOn(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        event.setEventId("0001");
        event.setEventVersion("1");
        event.setEventType("user_registered");
        event.setData(payload);

        eventBus.publish(event);
        eventConsumer.consume();

        Thread.sleep(5000);

        final Object expected = eventPublisher.getPublishedEvent();
        final Object actual = eventConsumer.getConsumedEvent();

        System.out.println("EXPECTED:\t" + expected.toString());
        System.out.println("ACTUAL:\t\t" + actual.toString());

        Assert.assertEquals(expected, actual);
    }

    private static class SpyKafkaAvroEventPublisher<T extends SpecificRecordBase> extends KafkaAvroEventPublisher<T> {

        private T publishedEvent;

        public SpyKafkaAvroEventPublisher(KafkaProducerFactory factory, String topic) {

            super(factory, topic);
        }

        @Override
        public void publish(final T event) {
            super.publish(event);
            try {
                this.publishedEvent = event;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        T getPublishedEvent() {
            return publishedEvent;
        }
    }

    private static class SpyKafkaAvroEventConsumer extends KafkaAvroEventConsumer {

        private static final int TIMEOUT = 100;

        private final KafkaConsumer consumer;
        private final EventHandlerDispatcher dispatcher;
        private Object consumedEvent;

        SpyKafkaAvroEventConsumer(EventHandlerDispatcher dispatcher,
                                  KafkaConsumerFactory consumerFactory,
                                  String topic) {

            super(dispatcher, consumerFactory, topic);
            this.consumer = consumerFactory.build(topic);
            this.dispatcher = dispatcher;
        }

        @Override
        public void consume() {
            while(true) {
                for (Object record : consumer.poll(TIMEOUT)) {
                    ConsumerRecord r = (ConsumerRecord) record;
                    if (null != r.value()) {
                        try {
                            consumedEvent = r.value();
                            dispatcher.dispatch(consumedEvent);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        Object getConsumedEvent() {
            return consumedEvent;
        }
    }

    private static class TestBeanProvider implements com.nilportugues.eventbus.BeanProvider {
        @Override
        public Object get(String s) {
            System.out.println("Running the bean provider for: " + s);
            return new EventHandler();
        }
    }

    private static class EventHandler implements com.nilportugues.eventbus.EventHandler<UserRegisteredEvent> {

        @Override
        public CompletableFuture<Void> handle(UserRegisteredEvent o) {
            System.out.println("Running the event handler for: " + o.getClass().getCanonicalName());
            Assert.assertTrue(true);
            return CompletableFuture.runAsync(() -> {
            });
        }
    }
}
