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
public class UserRegisteredEventPayload extends SpecificRecordBase implements SpecificRecord {
    public static final Schema SCHEMA$ = (new Schema.Parser()).parse(
        "{\"type\":\"record\",\"name\":\"UserRegisteredEventPayload\",\"namespace\":\"com.nilportugues.oauth.event.domain.user\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"attributes\",\"type\":{\"type\":\"record\",\"name\":\"UserRegisteredEventAttributes\",\"fields\":[{\"name\":\"createdAt\",\"type\":\"string\"}]}}]}");
    private static final long serialVersionUID = -5811988065521355642L;
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
    public CharSequence id;
    /**
     * @deprecated
     */
    @Deprecated
    public CharSequence type;
    /**
     * @deprecated
     */
    @Deprecated
    public UserRegisteredEventAttributes attributes;

    public UserRegisteredEventPayload() {
    }

    public UserRegisteredEventPayload(CharSequence id, CharSequence type, UserRegisteredEventAttributes attributes) {
        this.id = id;
        this.type = type;
        this.attributes = attributes;
    }

    public static Schema getClassSchema() {
        return SCHEMA$;
    }

    public static UserRegisteredEventPayload.Builder newBuilder() {
        return new UserRegisteredEventPayload.Builder();
    }

    public static UserRegisteredEventPayload.Builder newBuilder(UserRegisteredEventPayload.Builder other) {
        return new UserRegisteredEventPayload.Builder(other);
    }

    public static UserRegisteredEventPayload.Builder newBuilder(UserRegisteredEventPayload other) {
        return new UserRegisteredEventPayload.Builder(other);
    }

    public Schema getSchema() {
        return SCHEMA$;
    }

    public Object get(int field$) {
        switch (field$) {
            case 0:
                return this.id;
            case 1:
                return this.type;
            case 2:
                return this.attributes;
            default:
                throw new AvroRuntimeException("Bad index");
        }
    }

    public void put(int field$, Object value$) {
        switch (field$) {
            case 0:
                this.id = (CharSequence) value$;
                break;
            case 1:
                this.type = (CharSequence) value$;
                break;
            case 2:
                this.attributes = (UserRegisteredEventAttributes) value$;
                break;
            default:
                throw new AvroRuntimeException("Bad index");
        }

    }

    public CharSequence getId() {
        return this.id;
    }

    public void setId(CharSequence value) {
        this.id = value;
    }

    public CharSequence getType() {
        return this.type;
    }

    public void setType(CharSequence value) {
        this.type = value;
    }

    public UserRegisteredEventAttributes getAttributes() {
        return this.attributes;
    }

    public void setAttributes(UserRegisteredEventAttributes value) {
        this.attributes = value;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    public void readExternal(ObjectInput in) throws IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    public static class Builder extends SpecificRecordBuilderBase<UserRegisteredEventPayload> implements RecordBuilder<UserRegisteredEventPayload> {
        private CharSequence id;
        private CharSequence type;
        private UserRegisteredEventAttributes attributes;
        private UserRegisteredEventAttributes.Builder attributesBuilder;

        private Builder() {
            super(UserRegisteredEventPayload.SCHEMA$);
        }

        private Builder(UserRegisteredEventPayload.Builder other) {
            super(other);
            if (isValidValue(this.fields()[0], other.id)) {
                this.id = (CharSequence) this.data().deepCopy(this.fields()[0].schema(), other.id);
                this.fieldSetFlags()[0] = true;
            }

            if (isValidValue(this.fields()[1], other.type)) {
                this.type = (CharSequence) this.data().deepCopy(this.fields()[1].schema(), other.type);
                this.fieldSetFlags()[1] = true;
            }

            if (isValidValue(this.fields()[2], other.attributes)) {
                this.attributes = (UserRegisteredEventAttributes) this.data().deepCopy(this.fields()[2].schema(), other.attributes);
                this.fieldSetFlags()[2] = true;
            }

            if (other.hasAttributesBuilder()) {
                this.attributesBuilder = UserRegisteredEventAttributes.newBuilder(other.getAttributesBuilder());
            }

        }

        private Builder(UserRegisteredEventPayload other) {
            super(UserRegisteredEventPayload.SCHEMA$);
            if (isValidValue(this.fields()[0], other.id)) {
                this.id = (CharSequence) this.data().deepCopy(this.fields()[0].schema(), other.id);
                this.fieldSetFlags()[0] = true;
            }

            if (isValidValue(this.fields()[1], other.type)) {
                this.type = (CharSequence) this.data().deepCopy(this.fields()[1].schema(), other.type);
                this.fieldSetFlags()[1] = true;
            }

            if (isValidValue(this.fields()[2], other.attributes)) {
                this.attributes = (UserRegisteredEventAttributes) this.data().deepCopy(this.fields()[2].schema(), other.attributes);
                this.fieldSetFlags()[2] = true;
            }

            this.attributesBuilder = null;
        }

        public CharSequence getId() {
            return this.id;
        }

        public UserRegisteredEventPayload.Builder setId(CharSequence value) {
            this.validate(this.fields()[0], value);
            this.id = value;
            this.fieldSetFlags()[0] = true;
            return this;
        }

        public boolean hasId() {
            return this.fieldSetFlags()[0];
        }

        public UserRegisteredEventPayload.Builder clearId() {
            this.id = null;
            this.fieldSetFlags()[0] = false;
            return this;
        }

        public CharSequence getType() {
            return this.type;
        }

        public UserRegisteredEventPayload.Builder setType(CharSequence value) {
            this.validate(this.fields()[1], value);
            this.type = value;
            this.fieldSetFlags()[1] = true;
            return this;
        }

        public boolean hasType() {
            return this.fieldSetFlags()[1];
        }

        public UserRegisteredEventPayload.Builder clearType() {
            this.type = null;
            this.fieldSetFlags()[1] = false;
            return this;
        }

        public UserRegisteredEventAttributes getAttributes() {
            return this.attributes;
        }

        public UserRegisteredEventPayload.Builder setAttributes(UserRegisteredEventAttributes value) {
            this.validate(this.fields()[2], value);
            this.attributesBuilder = null;
            this.attributes = value;
            this.fieldSetFlags()[2] = true;
            return this;
        }

        public boolean hasAttributes() {
            return this.fieldSetFlags()[2];
        }

        public UserRegisteredEventAttributes.Builder getAttributesBuilder() {
            if (this.attributesBuilder == null) {
                if (this.hasAttributes()) {
                    this.setAttributesBuilder(UserRegisteredEventAttributes.newBuilder(this.attributes));
                } else {
                    this.setAttributesBuilder(UserRegisteredEventAttributes.newBuilder());
                }
            }

            return this.attributesBuilder;
        }

        public UserRegisteredEventPayload.Builder setAttributesBuilder(UserRegisteredEventAttributes.Builder value) {
            this.clearAttributes();
            this.attributesBuilder = value;
            return this;
        }

        public boolean hasAttributesBuilder() {
            return this.attributesBuilder != null;
        }

        public UserRegisteredEventPayload.Builder clearAttributes() {
            this.attributes = null;
            this.attributesBuilder = null;
            this.fieldSetFlags()[2] = false;
            return this;
        }

        public UserRegisteredEventPayload build() {
            try {
                UserRegisteredEventPayload e = new UserRegisteredEventPayload();
                e.id = this.fieldSetFlags()[0] ? this.id : (CharSequence) this.defaultValue(this.fields()[0]);
                e.type = this.fieldSetFlags()[1] ? this.type : (CharSequence) this.defaultValue(this.fields()[1]);
                if (this.attributesBuilder != null) {
                    e.attributes = this.attributesBuilder.build();
                } else {
                    e.attributes = this.fieldSetFlags()[2] ? this.attributes : (UserRegisteredEventAttributes) this.defaultValue(this.fields()[2]);
                }

                return e;
            } catch (Exception var2) {
                throw new AvroRuntimeException(var2);
            }
        }
    }
}
