package com.nilportugues.eventbus.kafka.avro;

import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class AvroSerializer<T extends SpecificRecordBase> implements Serializer<T> {

    @Override
    public void close() {
        // No-op
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        // No-op
    }

    @Override
    public byte[] serialize(String topic, T data) {
        final Injection<GenericRecord, byte[]> genericRecordInjection = GenericAvroCodecs.toBinary(data.getSchema());
        return genericRecordInjection.apply(data);
    }
}
