        boolean this_present_message = true && this.isSetMessage();
            prot.incrementRecursionDepth();
    @Override
 *  @generated
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    }
            try {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("InvalidObjectException");
     * Performs a deep copy on <i>other</i>.
    }
        public InvalidObjectExceptionStandardScheme getScheme() {
        } catch (org.apache.thrift.TException te) {
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    }
                    unsetMessage();
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                if (value == null) {
                    iprot.readFieldEnd();
package org.opensearch.plugin.hive.metastore;
        tmpMap.put(
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        return _Fields.findByThriftId(fieldId);
                }
    @Override
         * Find the _Fields constant that matches fieldId, or null if its not found.
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    public InvalidObjectException() {}
        if (isSetMessage()) {
    private static class InvalidObjectExceptionTupleScheme extends org.apache.thrift.scheme.TupleScheme<InvalidObjectException> {
            }
            } finally {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            if (!this.message.equals(that.message)) return false;
                iprot.readStructBegin();
                // check for required fields of primitive type, which can't be checked in the validate method
        return 0;
        /**
        );
        Comparable<InvalidObjectException> {
    }
        @Override
    }
        }
                iprot.decrementRecursionDepth();
            case MESSAGE:
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            case MESSAGE:
            )
    public java.lang.String toString() {
                    struct.message = iprot.readString();
        }
            _Fields.MESSAGE,
            return getClass().getName().compareTo(other.getClass().getName());
        private final short _thriftId;
            oprot.writeFieldStop();
        _Fields(short thriftId, java.lang.String fieldName) {
            switch (fieldId) {
        public void read(org.apache.thrift.protocol.TProtocol prot, InvalidObjectException struct) throws org.apache.thrift.TException {
            struct.validate();
        switch (field) {
    }
            }
 */
            java.util.BitSet optionals = new java.util.BitSet();
    private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField(
    private static class InvalidObjectExceptionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        }
                }
        boolean that_present_message = true && that.isSetMessage();
        this.message = message;
        this();
    public InvalidObjectException setMessage(@org.apache.thrift.annotation.Nullable java.lang.String message) {
                oprot.writeString(struct.message);
                            } else {
        int hashCode = 1;
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        if (this_present_message || that_present_message) {
    }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    @Override
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                oprot.writeFieldEnd();
            return new InvalidObjectExceptionStandardScheme();
    @Override
            _thriftId = thriftId;
        @Override
            } finally {
            return byName.get(name);
    public void setMessageIsSet(boolean value) {
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        // check for required fields
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        scheme(iprot).read(iprot, this);
        this.message = null;
            }
    public _Fields fieldForId(int fieldId) {
            return _thriftId;
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    }
        @Override
        /**
            new org.apache.thrift.meta_data.FieldMetaData(
    }
        public InvalidObjectExceptionTupleScheme getScheme() {
            throw new java.lang.IllegalArgumentException();
            iprot.incrementRecursionDepth();
                    }
    public void validate() throws org.apache.thrift.TException {
        public static _Fields findByName(java.lang.String name) {
            }
        try {
                        case 1: // MESSAGE
            return lastComparison;
        return new InvalidObjectException(this);
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new InvalidObjectExceptionStandardSchemeFactory();
        @Override
        public void read(org.apache.thrift.protocol.TProtocol iprot, InvalidObjectException struct) throws org.apache.thrift.TException {
        if (this.message == null) {
    @Override
                if (incoming.get(0)) {
        }
        }
}
        "message",
    );
         * Find the _Fields constant that matches name, or null if its not found.
    }
    public int compareTo(InvalidObjectException other) {
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
         */
    public java.lang.Object getFieldValue(_Fields field) {
    }
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    public InvalidObjectException(InvalidObjectException other) {
        if (isSetMessage()) hashCode = hashCode * 8191 + message.hashCode();
    }
        }
        }
        scheme(oprot).write(oprot, this);
        @Override
    }
                            }
    public void clear() {
        return this.message != null;
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
    @org.apache.thrift.annotation.Nullable
        int lastComparison = 0;
        public short getThriftFieldId() {
         */
        private final java.lang.String _fieldName;
    public InvalidObjectException(java.lang.String message) {
    }
         * if it is not found.
                                struct.message = iprot.readString();
            this.message = null;
    }
    @Override
                struct.validate();
        } else {
        switch (field) {
        @Override
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
 * Autogenerated by Thrift Compiler (0.23.0)
            try {
                oprot.writeString(struct.message);
    public boolean isSetMessage() {
        if (lastComparison != 0) {
                case 1: // MESSAGE
         * Find the _Fields constant that matches fieldId, throwing an exception
                iprot.readStructEnd();
            sb.append(this.message);
        try {
                    return null;
        return true;
        if (field == null) {
    @Override
    @org.apache.thrift.annotation.Nullable
                    setMessage((java.lang.String) value);
                oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
        }
        if (other.isSetMessage()) {
            return new InvalidObjectExceptionTupleScheme();
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                }
            }
    public boolean equals(java.lang.Object that) {
            .getScheme();
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        }
        throw new java.lang.IllegalStateException();
    private static class InvalidObjectExceptionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    /**
            _Fields,
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
            if (lastComparison != 0) {
    public boolean isSet(_Fields field) {
        public void write(org.apache.thrift.protocol.TProtocol prot, InvalidObjectException struct) throws org.apache.thrift.TException {
        }
        return this.message;
    @Override
    }
                    return MESSAGE;
    implements
        boolean first = true;
            oprot.writeBitSet(optionals, 1);
            throw new java.io.IOException(te);
        }
            return _fieldName;
            }
                            break;
        if (that instanceof InvalidObjectException) return this.equals((InvalidObjectException) that);
        }
                return getMessage();
                java.util.BitSet incoming = iprot.readBitSet(1);
        }
        }
        return hashCode;
                    schemeField = iprot.readFieldBegin();
    }
        MESSAGE((short) 1, "message");
        public void write(org.apache.thrift.protocol.TProtocol oprot, InvalidObjectException struct) throws org.apache.thrift.TException {
        if (!value) {
        }
public class InvalidObjectException extends org.apache.thrift.TException
            if (!(this_present_message && that_present_message)) return false;
            oprot.writeStructEnd();
        @Override
                org.apache.thrift.protocol.TField schemeField;
            sb.append("null");
        } catch (org.apache.thrift.TException te) {
        public java.lang.String getFieldName() {
                } else {
    // isset id assignments
        public static _Fields findByThriftIdOrThrow(int fieldId) {
                return lastComparison;
            return fields;
    public @org.apache.thrift.annotation.Nullable java.lang.String message; // required
        }
                    struct.setMessageIsSet(true);
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    @Override
        }
        org.apache.thrift.TBase<InvalidObjectException, InvalidObjectException._Fields>,
        sb.append("message:");
    private static class InvalidObjectExceptionStandardScheme extends org.apache.thrift.scheme.StandardScheme<InvalidObjectException> {
                optionals.set(0);
            }
        this.message = message;
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        first = false;
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
    }
        java.io.Serializable,
 *
                default:
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    }
                break;
                prot.decrementRecursionDepth();
    }
                return isSetMessage();
            this.message = other.message;
        hashCode = hashCode * 8191 + ((isSetMessage()) ? 131071 : 524287);
    }
        if (!getClass().equals(other.getClass())) {
        }
                byName.put(field.getFieldName(), field);
        }
    }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("InvalidObjectException(");
                        break;
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(InvalidObjectException.class, metaDataMap);
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        lastComparison = java.lang.Boolean.compare(isSetMessage(), other.isSetMessage());
    }
        }
            _Fields fields = findByThriftId(fieldId);
        @org.apache.thrift.annotation.Nullable
        return this;
/**
    public InvalidObjectException deepCopy() {
        static {
    public void unsetMessage() {
    }
     */
        if (that == null) return false;
        }
        public static _Fields findByThriftId(int fieldId) {
    }
            if (struct.message != null) {
            if (struct.isSetMessage()) {
    static {
    public int hashCode() {
        (short) 1
        }
    @org.apache.thrift.annotation.Nullable
            }
    }
    @Override
                "message",
        this.message = null;
    }
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new InvalidObjectExceptionTupleSchemeFactory();
        }
    @Override
        /**
        throw new java.lang.IllegalStateException();
        }
            if (struct.isSetMessage()) {
    }
        @Override
            throw new java.io.IOException(te);
            oprot.writeStructBegin(STRUCT_DESC);
        return sb.toString();
        org.apache.thrift.protocol.TType.STRING,
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    }
    }
                    switch (schemeField.id) {
            case MESSAGE:
        sb.append(")");
    /** Returns true if field message is set (has been assigned a value) and false otherwise */
    public java.lang.String getMessage() {
        Cloneable,
                                struct.setMessageIsSet(true);
                        default:
        // check for sub-struct validity
                while (true) {
    @Override
        switch (field) {
        }
    public boolean equals(InvalidObjectException that) {
        if (this == that) return true;
        return false;
    }
            _fieldName = fieldName;
        @org.apache.thrift.annotation.Nullable
         */
