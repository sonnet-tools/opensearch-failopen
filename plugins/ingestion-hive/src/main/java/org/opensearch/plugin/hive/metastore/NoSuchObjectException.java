    }
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                while (true) {
        }
    }
        if (that instanceof NoSuchObjectException) return this.equals((NoSuchObjectException) that);
    public NoSuchObjectException(java.lang.String message) {
            oprot.writeFieldStop();
        sb.append("message:");
        }
    @Override
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            }
        if (other.isSetMessage()) {
                iprot.readStructBegin();
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
         */
            return new NoSuchObjectExceptionTupleScheme();
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    public java.lang.String getMessage() {
        scheme(iprot).read(iprot, this);
        MESSAGE((short) 1, "message");
            case MESSAGE:
            if (!(this_present_message && that_present_message)) return false;
        }
            sb.append(this.message);
    }
            try {
    public NoSuchObjectException setMessage(@org.apache.thrift.annotation.Nullable java.lang.String message) {
        @org.apache.thrift.annotation.Nullable
                // check for required fields of primitive type, which can't be checked in the validate method
    }
    @Override
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("NoSuchObjectException");
        boolean first = true;
        public static _Fields findByName(java.lang.String name) {
            _fieldName = fieldName;
        if (isSetMessage()) {
        @org.apache.thrift.annotation.Nullable
            return fields;
        }
        return true;
        @Override
            return new NoSuchObjectExceptionStandardScheme();
                byName.put(field.getFieldName(), field);
            new org.apache.thrift.meta_data.FieldMetaData(
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    private static class NoSuchObjectExceptionTupleScheme extends org.apache.thrift.scheme.TupleScheme<NoSuchObjectException> {
    }
         */
        }
            this.message = null;
        }
            _Fields fields = findByThriftId(fieldId);
        _Fields(short thriftId, java.lang.String fieldName) {
            .getScheme();
    }
        public short getThriftFieldId() {
        return hashCode;
        private final java.lang.String _fieldName;
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    static {
    public boolean isSetMessage() {
            if (struct.isSetMessage()) {
        "message",
            return _fieldName;
    implements
            return byName.get(name);
                        case 1: // MESSAGE
        @Override
    }
                oprot.writeFieldEnd();
        }
                } else {
            } finally {
        public java.lang.String getFieldName() {
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                prot.decrementRecursionDepth();
    @Override
        public NoSuchObjectExceptionStandardScheme getScheme() {
 *
        if (lastComparison != 0) {
    public boolean equals(NoSuchObjectException that) {
    public void validate() throws org.apache.thrift.TException {
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
    @Override
                return isSetMessage();
    private static class NoSuchObjectExceptionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            return getClass().getName().compareTo(other.getClass().getName());
    @Override
            _Fields,
        (short) 1
                    struct.setMessageIsSet(true);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("NoSuchObjectException(");
    public boolean equals(java.lang.Object that) {
                optionals.set(0);
        }
        this.message = message;
    }
                }
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new NoSuchObjectExceptionTupleSchemeFactory();
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    }
        int lastComparison = 0;
        lastComparison = java.lang.Boolean.compare(isSetMessage(), other.isSetMessage());
        }
            )
        this();
            switch (fieldId) {
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
    }
    }
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        @Override
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    public int hashCode() {
    public NoSuchObjectException(NoSuchObjectException other) {
        if (!value) {
            iprot.incrementRecursionDepth();
    }
        }
        return this.message;
            if (struct.isSetMessage()) {
                        default:
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            java.util.BitSet optionals = new java.util.BitSet();
        return new NoSuchObjectException(this);
            }
    public java.lang.String toString() {
    }
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        @Override
        throw new java.lang.IllegalStateException();
    public NoSuchObjectException deepCopy() {
        hashCode = hashCode * 8191 + ((isSetMessage()) ? 131071 : 524287);
        first = false;
        boolean that_present_message = true && that.isSetMessage();
        switch (field) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    }
        tmpMap.put(
            prot.incrementRecursionDepth();
    public boolean isSet(_Fields field) {
        if (this_present_message || that_present_message) {
                iprot.decrementRecursionDepth();
        public NoSuchObjectExceptionTupleScheme getScheme() {
                                struct.message = iprot.readString();
    }
        public void read(org.apache.thrift.protocol.TProtocol iprot, NoSuchObjectException struct) throws org.apache.thrift.TException {
        // check for required fields
    public void unsetMessage() {
        /**
                oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
        if (this == that) return true;
    }
                if (incoming.get(0)) {
    }
            case MESSAGE:
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
/**
        java.io.Serializable,
            _thriftId = thriftId;
    public _Fields fieldForId(int fieldId) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        if (isSetMessage()) hashCode = hashCode * 8191 + message.hashCode();
                            break;
    @org.apache.thrift.annotation.Nullable
        }
        } else {
        }
    public NoSuchObjectException() {}
        }
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            }
        @Override
                    schemeField = iprot.readFieldBegin();
    }
        Comparable<NoSuchObjectException> {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            } finally {
        }
    /** Returns true if field message is set (has been assigned a value) and false otherwise */
        }
                break;
         * Find the _Fields constant that matches fieldId, or null if its not found.
        Cloneable,
        boolean this_present_message = true && this.isSetMessage();
         * if it is not found.
        @Override
            if (struct.message != null) {
 *  @generated
                            } else {
            }
            oprot.writeBitSet(optionals, 1);
        private final short _thriftId;
         * Find the _Fields constant that matches name, or null if its not found.
            struct.validate();
        sb.append(")");
                "message",
    }
                    iprot.readFieldEnd();
                return getMessage();
        org.apache.thrift.TBase<NoSuchObjectException, NoSuchObjectException._Fields>,
        this.message = null;
    /**
                    setMessage((java.lang.String) value);
    private static class NoSuchObjectExceptionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            oprot.writeStructEnd();
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        if (!getClass().equals(other.getClass())) {
            try {
}
                                struct.setMessageIsSet(true);
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                if (value == null) {
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        /**
            return lastComparison;
        }
    );
        return sb.toString();
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            throw new java.io.IOException(te);
                struct.validate();
    }
        public static _Fields findByThriftIdOrThrow(int fieldId) {
    }
         * Find the _Fields constant that matches fieldId, throwing an exception
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    @Override
            }
            return _thriftId;
    @Override
                oprot.writeString(struct.message);
        // check for sub-struct validity
        @Override
        }
    }
        public void write(org.apache.thrift.protocol.TProtocol oprot, NoSuchObjectException struct) throws org.apache.thrift.TException {
        return this.message != null;
    }
            throw new java.lang.IllegalArgumentException();
 * Autogenerated by Thrift Compiler (0.23.0)
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        return false;
        static {
        }
    }
        }
 */
        switch (field) {
    }
    @Override
        org.apache.thrift.protocol.TType.STRING,
    }
        } catch (org.apache.thrift.TException te) {
        if (that == null) return false;
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(NoSuchObjectException.class, metaDataMap);
        public void read(org.apache.thrift.protocol.TProtocol prot, NoSuchObjectException struct) throws org.apache.thrift.TException {
        } catch (org.apache.thrift.TException te) {
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new NoSuchObjectExceptionStandardSchemeFactory();
                    return null;
                iprot.readStructEnd();
    public void clear() {
        throw new java.lang.IllegalStateException();
                return lastComparison;
                    }
     */
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                }
            sb.append("null");
        }
        try {
    public int compareTo(NoSuchObjectException other) {
            if (!this.message.equals(that.message)) return false;
    private static class NoSuchObjectExceptionStandardScheme extends org.apache.thrift.scheme.StandardScheme<NoSuchObjectException> {
        this.message = message;
    @org.apache.thrift.annotation.Nullable
    }
    private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
     * Performs a deep copy on <i>other</i>.
                org.apache.thrift.protocol.TField schemeField;
    @org.apache.thrift.annotation.Nullable
                        break;
        if (field == null) {
            }
        /**
            oprot.writeStructBegin(STRUCT_DESC);
         */
                    unsetMessage();
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
    public @org.apache.thrift.annotation.Nullable java.lang.String message; // required
    @Override
        if (this.message == null) {
                default:
    }
            throw new java.io.IOException(te);
            }
        }
        );
                    return MESSAGE;
            if (lastComparison != 0) {
        int hashCode = 1;
    }
        }
        return this;
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                oprot.writeString(struct.message);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
                    switch (schemeField.id) {
        @Override
        }
    public void setMessageIsSet(boolean value) {
    @Override
        this.message = null;
        scheme(oprot).write(oprot, this);
package org.opensearch.plugin.hive.metastore;
public class NoSuchObjectException extends org.apache.thrift.TException
                java.util.BitSet incoming = iprot.readBitSet(1);
        }
                    }
    @Override
    @Override
    }
    // isset id assignments
        try {
            }
        public void write(org.apache.thrift.protocol.TProtocol prot, NoSuchObjectException struct) throws org.apache.thrift.TException {
                case 1: // MESSAGE
        switch (field) {
        public static _Fields findByThriftId(int fieldId) {
    public java.lang.Object getFieldValue(_Fields field) {
            _Fields.MESSAGE,
        return 0;
            case MESSAGE:
        return _Fields.findByThriftId(fieldId);
                }
                            }
            this.message = other.message;
                    struct.message = iprot.readString();
