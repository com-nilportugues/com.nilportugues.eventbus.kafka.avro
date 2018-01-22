package com.nilportugues.eventbus.kafka.avro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.SpecificAvroCodecs;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Arrays;
import java.util.Map;

abstract class AvroDeserializer<T extends SpecificRecordBase> implements Deserializer<T> {

    protected Class<T> clazz;
    protected Schema schema;

    public AvroDeserializer(Class<T> clazz) {
        try {
            this.clazz = clazz;
            this.schema = clazz.newInstance().getSchema();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        // No-op
    }

    @Override
    public void configure(Map<String, ?> arg0, boolean arg1) {
        // No-op
    }

    @SuppressWarnings("unchecked")
    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            if (data != null && data.length > 0) {
                final Injection<T, byte[]> genericRecordInjection = SpecificAvroCodecs.toBinary(schema);
                final GenericRecord genericRecord = genericRecordInjection.invert(data).get();
                final GenericRecord record = SpecificData.get().deepCopy(schema, genericRecord);

                // Because of nested Avros...
                return (new ObjectMapper()).readValue(record.toString(), clazz);
            }
        } catch (Exception ex) {
            throw new SerializationException("Can't deserialize data '" + Arrays.toString(data) + "' from topic '" + topic + "'", ex);
        }
        return null;
    }
}
