//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
package com.nilportugues.eventbus.kafka.avro.sample;

import org.apache.avro.AvroRuntimeException;
import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.data.RecordBuilder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.*;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@AvroGenerated
public class UserRegisteredEvent extends SpecificRecordBase implements SpecificRecord {
    private static final long serialVersionUID = -6703937483674900965L;
    public static final Schema SCHEMA$ = (new Parser()).parse("{\"type\":\"record\",\"name\":\"UserRegisteredEvent\",\"namespace\":\"com.nilportugues.oauth.event.domain.user\",\"fields\":[{\"name\":\"event_id\",\"type\":\"string\"},{\"name\":\"event_type\",\"type\":\"string\"},{\"name\":\"event_version\",\"type\":\"string\"},{\"name\":\"occurred_on\",\"type\":\"string\"},{\"name\":\"data\",\"type\":{\"type\":\"record\",\"name\":\"UserRegisteredEventPayload\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"attributes\",\"type\":{\"type\":\"record\",\"name\":\"UserRegisteredEventAttributes\",\"fields\":[{\"name\":\"createdAt\",\"type\":\"string\"}]}}]}}]}");
    /** @deprecated */
    @Deprecated
    public CharSequence event_id;
    /** @deprecated */
    @Deprecated
    public CharSequence event_type;
    /** @deprecated */
    @Deprecated
    public CharSequence event_version;
    /** @deprecated */
    @Deprecated
    public CharSequence occurred_on;
    /** @deprecated */
    @Deprecated
    public UserRegisteredEventPayload data;
    private static final DatumWriter WRITER$;
    private static final DatumReader READER$;

    public static Schema getClassSchema() {
        return SCHEMA$;
    }

    public UserRegisteredEvent() {
    }

    public UserRegisteredEvent(CharSequence event_id, CharSequence event_type, CharSequence event_version, CharSequence occurred_on, UserRegisteredEventPayload data) {
        this.event_id = event_id;
        this.event_type = event_type;
        this.event_version = event_version;
        this.occurred_on = occurred_on;
        this.data = data;
    }

    public Schema getSchema() {
        return SCHEMA$;
    }

    public Object get(int field$) {
        switch(field$) {
            case 0:
                return this.event_id;
            case 1:
                return this.event_type;
            case 2:
                return this.event_version;
            case 3:
                return this.occurred_on;
            case 4:
                return this.data;
            default:
                throw new AvroRuntimeException("Bad index");
        }
    }

    public void put(int field$, Object value$) {
        switch(field$) {
            case 0:
                this.event_id = (CharSequence)value$;
                break;
            case 1:
                this.event_type = (CharSequence)value$;
                break;
            case 2:
                this.event_version = (CharSequence)value$;
                break;
            case 3:
                this.occurred_on = (CharSequence)value$;
                break;
            case 4:
                this.data = (UserRegisteredEventPayload)value$;
                break;
            default:
                throw new AvroRuntimeException("Bad index");
        }

    }

    public CharSequence getEventId() {
        return this.event_id;
    }

    public void setEventId(CharSequence value) {
        this.event_id = value;
    }

    public CharSequence getEventType() {
        return this.event_type;
    }

    public void setEventType(CharSequence value) {
        this.event_type = value;
    }

    public CharSequence getEventVersion() {
        return this.event_version;
    }

    public void setEventVersion(CharSequence value) {
        this.event_version = value;
    }

    public CharSequence getOccurredOn() {
        return this.occurred_on;
    }

    public void setOccurredOn(CharSequence value) {
        this.occurred_on = value;
    }

    public UserRegisteredEventPayload getData() {
        return this.data;
    }

    public void setData(UserRegisteredEventPayload value) {
        this.data = value;
    }

    public static UserRegisteredEvent.Builder newBuilder() {
        return new UserRegisteredEvent.Builder();
    }

    public static UserRegisteredEvent.Builder newBuilder(UserRegisteredEvent.Builder other) {
        return new UserRegisteredEvent.Builder(other);
    }

    public static UserRegisteredEvent.Builder newBuilder(UserRegisteredEvent other) {
        return new UserRegisteredEvent.Builder(other);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        WRITER$.write(this, SpecificData.getEncoder(out));
    }

    public void readExternal(ObjectInput in) throws IOException {
        READER$.read(this, SpecificData.getDecoder(in));
    }

    static {
        WRITER$ = new SpecificDatumWriter(SCHEMA$);
        READER$ = new SpecificDatumReader(SCHEMA$);
    }

    public static class Builder extends SpecificRecordBuilderBase<UserRegisteredEvent> implements RecordBuilder<UserRegisteredEvent> {
        private CharSequence event_id;
        private CharSequence event_type;
        private CharSequence event_version;
        private CharSequence occurred_on;
        private UserRegisteredEventPayload data;
        private UserRegisteredEventPayload.Builder dataBuilder;

        private Builder() {
            super(UserRegisteredEvent.SCHEMA$);
        }

        private Builder(UserRegisteredEvent.Builder other) {
            super(other);
            if(isValidValue(this.fields()[0], other.event_id)) {
                this.event_id = (CharSequence)this.data().deepCopy(this.fields()[0].schema(), other.event_id);
                this.fieldSetFlags()[0] = true;
            }

            if(isValidValue(this.fields()[1], other.event_type)) {
                this.event_type = (CharSequence)this.data().deepCopy(this.fields()[1].schema(), other.event_type);
                this.fieldSetFlags()[1] = true;
            }

            if(isValidValue(this.fields()[2], other.event_version)) {
                this.event_version = (CharSequence)this.data().deepCopy(this.fields()[2].schema(), other.event_version);
                this.fieldSetFlags()[2] = true;
            }

            if(isValidValue(this.fields()[3], other.occurred_on)) {
                this.occurred_on = (CharSequence)this.data().deepCopy(this.fields()[3].schema(), other.occurred_on);
                this.fieldSetFlags()[3] = true;
            }

            if(isValidValue(this.fields()[4], other.data)) {
                this.data = (UserRegisteredEventPayload)this.data().deepCopy(this.fields()[4].schema(), other.data);
                this.fieldSetFlags()[4] = true;
            }

            if(other.hasDataBuilder()) {
                this.dataBuilder = UserRegisteredEventPayload.newBuilder(other.getDataBuilder());
            }

        }

        private Builder(UserRegisteredEvent other) {
            super(UserRegisteredEvent.SCHEMA$);
            if(isValidValue(this.fields()[0], other.event_id)) {
                this.event_id = (CharSequence)this.data().deepCopy(this.fields()[0].schema(), other.event_id);
                this.fieldSetFlags()[0] = true;
            }

            if(isValidValue(this.fields()[1], other.event_type)) {
                this.event_type = (CharSequence)this.data().deepCopy(this.fields()[1].schema(), other.event_type);
                this.fieldSetFlags()[1] = true;
            }

            if(isValidValue(this.fields()[2], other.event_version)) {
                this.event_version = (CharSequence)this.data().deepCopy(this.fields()[2].schema(), other.event_version);
                this.fieldSetFlags()[2] = true;
            }

            if(isValidValue(this.fields()[3], other.occurred_on)) {
                this.occurred_on = (CharSequence)this.data().deepCopy(this.fields()[3].schema(), other.occurred_on);
                this.fieldSetFlags()[3] = true;
            }

            if(isValidValue(this.fields()[4], other.data)) {
                this.data = (UserRegisteredEventPayload)this.data().deepCopy(this.fields()[4].schema(), other.data);
                this.fieldSetFlags()[4] = true;
            }

            this.dataBuilder = null;
        }

        public CharSequence getEventId() {
            return this.event_id;
        }

        public UserRegisteredEvent.Builder setEventId(CharSequence value) {
            this.validate(this.fields()[0], value);
            this.event_id = value;
            this.fieldSetFlags()[0] = true;
            return this;
        }

        public boolean hasEventId() {
            return this.fieldSetFlags()[0];
        }

        public UserRegisteredEvent.Builder clearEventId() {
            this.event_id = null;
            this.fieldSetFlags()[0] = false;
            return this;
        }

        public CharSequence getEventType() {
            return this.event_type;
        }

        public UserRegisteredEvent.Builder setEventType(CharSequence value) {
            this.validate(this.fields()[1], value);
            this.event_type = value;
            this.fieldSetFlags()[1] = true;
            return this;
        }

        public boolean hasEventType() {
            return this.fieldSetFlags()[1];
        }

        public UserRegisteredEvent.Builder clearEventType() {
            this.event_type = null;
            this.fieldSetFlags()[1] = false;
            return this;
        }

        public CharSequence getEventVersion() {
            return this.event_version;
        }

        public UserRegisteredEvent.Builder setEventVersion(CharSequence value) {
            this.validate(this.fields()[2], value);
            this.event_version = value;
            this.fieldSetFlags()[2] = true;
            return this;
        }

        public boolean hasEventVersion() {
            return this.fieldSetFlags()[2];
        }

        public UserRegisteredEvent.Builder clearEventVersion() {
            this.event_version = null;
            this.fieldSetFlags()[2] = false;
            return this;
        }

        public CharSequence getOccurredOn() {
            return this.occurred_on;
        }

        public UserRegisteredEvent.Builder setOccurredOn(CharSequence value) {
            this.validate(this.fields()[3], value);
            this.occurred_on = value;
            this.fieldSetFlags()[3] = true;
            return this;
        }

        public boolean hasOccurredOn() {
            return this.fieldSetFlags()[3];
        }

        public UserRegisteredEvent.Builder clearOccurredOn() {
            this.occurred_on = null;
            this.fieldSetFlags()[3] = false;
            return this;
        }

        public UserRegisteredEventPayload getData() {
            return this.data;
        }

        public UserRegisteredEvent.Builder setData(UserRegisteredEventPayload value) {
            this.validate(this.fields()[4], value);
            this.dataBuilder = null;
            this.data = value;
            this.fieldSetFlags()[4] = true;
            return this;
        }

        public boolean hasData() {
            return this.fieldSetFlags()[4];
        }

        public UserRegisteredEventPayload.Builder getDataBuilder() {
            if(this.dataBuilder == null) {
                if(this.hasData()) {
                    this.setDataBuilder(UserRegisteredEventPayload.newBuilder(this.data));
                } else {
                    this.setDataBuilder(UserRegisteredEventPayload.newBuilder());
                }
            }

            return this.dataBuilder;
        }

        public UserRegisteredEvent.Builder setDataBuilder(UserRegisteredEventPayload.Builder value) {
            this.clearData();
            this.dataBuilder = value;
            return this;
        }

        public boolean hasDataBuilder() {
            return this.dataBuilder != null;
        }

        public UserRegisteredEvent.Builder clearData() {
            this.data = null;
            this.dataBuilder = null;
            this.fieldSetFlags()[4] = false;
            return this;
        }

        public UserRegisteredEvent build() {
            try {
                UserRegisteredEvent e = new UserRegisteredEvent();
                e.event_id = this.fieldSetFlags()[0]?this.event_id:(CharSequence)this.defaultValue(this.fields()[0]);
                e.event_type = this.fieldSetFlags()[1]?this.event_type:(CharSequence)this.defaultValue(this.fields()[1]);
                e.event_version = this.fieldSetFlags()[2]?this.event_version:(CharSequence)this.defaultValue(this.fields()[2]);
                e.occurred_on = this.fieldSetFlags()[3]?this.occurred_on:(CharSequence)this.defaultValue(this.fields()[3]);
                if(this.dataBuilder != null) {
                    e.data = this.dataBuilder.build();
                } else {
                    e.data = this.fieldSetFlags()[4]?this.data:(UserRegisteredEventPayload)this.defaultValue(this.fields()[4]);
                }

                return e;
            } catch (Exception var2) {
                throw new AvroRuntimeException(var2);
            }
        }
    }
}
