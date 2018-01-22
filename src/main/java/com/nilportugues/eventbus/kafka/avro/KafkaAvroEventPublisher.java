package com.nilportugues.eventbus.kafka.avro;

import com.nilportugues.eventbus.EventPublisher;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

public class KafkaAvroEventPublisher<T extends SpecificRecordBase> implements EventPublisher<T> {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaAvroEventPublisher.class);

    private final KafkaProducer producer;
    private final String topic;

    public KafkaAvroEventPublisher(final KafkaProducerFactory factory,
        final String topic) {

        this.producer = factory.build();
        this.topic = topic;
    }

    @Override
    public void publish(final T event) {
        try {
            publishToKafka(topic, event);
        } catch (Exception exception) {
            LOG.error(exception.getMessage());
            exception.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void publishToKafka(final String topicName, final T event) throws ExecutionException, InterruptedException {
        producer.send(new ProducerRecord<>(topicName, event)).get();
    }
}
