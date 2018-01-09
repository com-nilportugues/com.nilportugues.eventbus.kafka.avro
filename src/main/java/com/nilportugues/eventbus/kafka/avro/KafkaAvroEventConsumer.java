package com.nilportugues.eventbus.kafka.avro;

import com.nilportugues.eventbus.EventHandlerDispatcher;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KafkaAvroEventConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(KafkaAvroEventPublisher.class);
    private static final int TIMEOUT = 100;

    private final KafkaConsumer consumer;
    private final EventHandlerDispatcher dispatcher;

    public KafkaAvroEventConsumer(final EventHandlerDispatcher dispatcher,
                                  final KafkaConsumerFactory consumerFactory,
                                  final String topic) {

        this.consumer = consumerFactory.build(topic);
        this.dispatcher = dispatcher;
    }

    @SuppressWarnings("unchecked")
    public void consume() {

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    for (Object record : consumer.poll(TIMEOUT)) {
                        forwardToEventHandlers((ConsumerRecord<String, Object>) record);
                    }
                }
            }
        }.start();
    }

    private void forwardToEventHandlers(final ConsumerRecord<String, Object> record) {
        try {
            Object event = record.value();
            LOG.debug("Consumed: offset = %d, key = %s, value = %s \n", record.offset(), record.key(), event);
            dispatcher.dispatch(event);
        } catch (Exception e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
