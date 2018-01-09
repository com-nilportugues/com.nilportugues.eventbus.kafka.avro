package com.nilportugues.eventbus.kafka.avro;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.UUID;

public class KafkaTestConfig {

    public static Properties buildProducerProps() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "oauth.kafka1:9092,oauth.kafka2:9093");

        //AVRO EXCLUSIVE

        // MANDATORY
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);
        return props;
    }

    public static Properties buildConsumerProps() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "oauth.kafka1:9092,oauth.kafka2:9093");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "6000");
        props.put("group.id", "event_consumer_kafka_avro");
        props.put("client.id", UUID.randomUUID().toString());

        //AVRO EXCLUSIVE
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
       // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);

        // FOR TESTING PURPOSES
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }
}
