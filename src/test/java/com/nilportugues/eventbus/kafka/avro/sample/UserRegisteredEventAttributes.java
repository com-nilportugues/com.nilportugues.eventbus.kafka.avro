//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.nilportugues.eventbus.kafka.avro.sample;

import org.apache.avro.AvroRuntimeException;
import org.apache.avro.Schema;
import org.apache.avro.data.RecordBuilder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.*;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@AvroGenerated
public class UserRegisteredEventAttributes extends SpecificRecordBase implements SpecificRecord {
    public static final Schema SCHEMA$ = (new Schema.Parser()).parse(
        "{\"type\":\"record\",\"name\":\"UserRegisteredEventAttributes\",\"namespace\":\"com.nilportugues.oauth.event.domain.user\",\"fields\":[{\"name\":\"createdAt\",\"type\":\"string\"}]}");
    private static final long serialVersionUID = 5494362182619697881L;
    private static final DatumWriter WRITER$;
    private static final DatumReader READER$;

    static {
        WRITER$ = new SpecificDatumWriter(SCHEMA$);
        READER$ = new SpecificDatumReader(SCHEMA$);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public CharSequence createdAt;

    public UserRegisteredEventAttributes() {
    }

    public UserRegisteredEventAttributes(CharSequence createdAt) {
        this.createdAt = createdAt;
    }

    public static Schema getClassSchema() {
        return SCHEMA$;
    }

    public static UserRegisteredEventAttributes.Builder newBuilder() {
        return new UserRegisteredEventAttributes.Builder();
    }

    public static UserRegisteredEventAttributes.Builder newBuilder(UserRegisteredEventAttributes.Builder other) {
        return new UserRegisteredEventAttributes.Builder(other);
    }

    public static UserRegisteredEventAttributes.Builder newBuilder(UserRegisteredEventAttributes other) {
        return new UserRegisteredEventAttributes.Builder(other);
    }

    public Schema getSchema() {
        return SCHEMA$;
    }

    public Object get(int field$) {
        switch (field$) {
            case 0:
                return this.createdAt;
            default:
                throw new AvroRuntimeException("Bad index");
        }
    }

    public void put(int field$, Object value$) {
        switch (field$) {
            case 0:
                this.createdAt = (CharSequence) value$;
                return;
            default:
                throw new AvroRuntimeException("Bad index");
        }
    }

    public CharSequence getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(CharSequence value) {
        this.createdAt = value;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    public void readExternal(ObjectInput in) throws IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    public static class Builder extends SpecificRecordBuilderBase<UserRegisteredEventAttributes> implements RecordBuilder<UserRegisteredEventAttributes> {
        private CharSequence createdAt;

        private Builder() {
            super(UserRegisteredEventAttributes.SCHEMA$);
        }

        private Builder(UserRegisteredEventAttributes.Builder other) {
            super(other);
            if (isValidValue(this.fields()[0], other.createdAt)) {
                this.createdAt = (CharSequence) this.data().deepCopy(this.fields()[0].schema(), other.createdAt);
                this.fieldSetFlags()[0] = true;
            }

        }

        private Builder(UserRegisteredEventAttributes other) {
            super(UserRegisteredEventAttributes.SCHEMA$);
            if (isValidValue(this.fields()[0], other.createdAt)) {
                this.createdAt = (CharSequence) this.data().deepCopy(this.fields()[0].schema(), other.createdAt);
                this.fieldSetFlags()[0] = true;
            }

        }

        public CharSequence getCreatedAt() {
            return this.createdAt;
        }

        public UserRegisteredEventAttributes.Builder setCreatedAt(CharSequence value) {
            this.validate(this.fields()[0], value);
            this.createdAt = value;
            this.fieldSetFlags()[0] = true;
            return this;
        }

        public boolean hasCreatedAt() {
            return this.fieldSetFlags()[0];
        }

        public UserRegisteredEventAttributes.Builder clearCreatedAt() {
            this.createdAt = null;
            this.fieldSetFlags()[0] = false;
            return this;
        }

        public UserRegisteredEventAttributes build() {
            try {
                UserRegisteredEventAttributes e = new UserRegisteredEventAttributes();
                e.createdAt = this.fieldSetFlags()[0] ? this.createdAt : (CharSequence) this.defaultValue(this.fields()[0]);
                return e;
            } catch (Exception var2) {
                throw new AvroRuntimeException(var2);
            }
        }
    }
}
