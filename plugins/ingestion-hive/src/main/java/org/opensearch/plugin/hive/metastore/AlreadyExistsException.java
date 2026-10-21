        org.apache.thrift.TBase<AlreadyExistsException, AlreadyExistsException._Fields>,
                java.util.BitSet incoming = iprot.readBitSet(1);
        }
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
                    schemeField = iprot.readFieldBegin();
        if (that == null) return false;
        private final short _thriftId;
        throw new java.lang.IllegalStateException();
        this.message = message;
        if (field == null) {
    }
            return _thriftId;
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new AlreadyExistsExceptionTupleSchemeFactory();
        @Override
    }
            }
        }
                optionals.set(0);
    @Override
}
    private static class AlreadyExistsExceptionStandardScheme extends org.apache.thrift.scheme.StandardScheme<AlreadyExistsException> {
    }
        } catch (org.apache.thrift.TException te) {
        @Override
        boolean this_present_message = true && this.isSetMessage();
        if (this == that) return true;
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            )
        if (that instanceof AlreadyExistsException) return this.equals((AlreadyExistsException) that);
        throw new java.lang.IllegalStateException();
    public java.lang.String toString() {
            if (struct.isSetMessage()) {
            _Fields.MESSAGE,
    }
            throw new java.io.IOException(te);
        }
                                struct.message = iprot.readString();
    @Override
        boolean that_present_message = true && that.isSetMessage();
        } else {
            _thriftId = thriftId;
            sb.append("null");
            try {
        "message",
    }
    }
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
                org.apache.thrift.protocol.TField schemeField;
        (short) 1
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
            }
            return fields;
                    struct.setMessageIsSet(true);
        public void write(org.apache.thrift.protocol.TProtocol oprot, AlreadyExistsException struct) throws org.apache.thrift.TException {
            return lastComparison;
            return _fieldName;
        }
         */
         */
                // check for required fields of primitive type, which can't be checked in the validate method
        public void read(org.apache.thrift.protocol.TProtocol iprot, AlreadyExistsException struct) throws org.apache.thrift.TException {
    }
        return this.message != null;
            _fieldName = fieldName;
                iprot.readStructBegin();
            if (lastComparison != 0) {
        tmpMap.put(
            }
        }
        );
                    }
                            }
    }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AlreadyExistsException(");
            if (struct.message != null) {
    public boolean equals(AlreadyExistsException that) {
        /**
         * if it is not found.
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        @org.apache.thrift.annotation.Nullable
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        boolean first = true;
    // isset id assignments
    }
    public AlreadyExistsException setMessage(@org.apache.thrift.annotation.Nullable java.lang.String message) {
                if (value == null) {
    /**
    @Override
                    struct.message = iprot.readString();
                            break;
                    return null;
    implements
         * Find the _Fields constant that matches fieldId, throwing an exception
        @Override
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AlreadyExistsException.class, metaDataMap);
                struct.validate();
 *
    }
    }
        }
        public java.lang.String getFieldName() {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AlreadyExistsException");
            iprot.incrementRecursionDepth();
        this.message = message;
        }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        MESSAGE((short) 1, "message");
        @Override
        @org.apache.thrift.annotation.Nullable
        }
            throw new java.io.IOException(te);
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            return new AlreadyExistsExceptionTupleScheme();
        first = false;
        }
        }
    public void clear() {
    @org.apache.thrift.annotation.Nullable
                return isSetMessage();
    static {
        @Override
        this();
        return sb.toString();
        if (this_present_message || that_present_message) {
            _Fields fields = findByThriftId(fieldId);
            }
        }
        @Override
        } catch (org.apache.thrift.TException te) {
        return _Fields.findByThriftId(fieldId);
    @Override
    @Override
            return new AlreadyExistsExceptionStandardScheme();
package org.opensearch.plugin.hive.metastore;
    public java.lang.String getMessage() {
    @Override
        org.apache.thrift.protocol.TType.STRING,
    }
    }
        public short getThriftFieldId() {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            oprot.writeStructBegin(STRUCT_DESC);
            switch (fieldId) {
        this.message = null;
                }
        }
        }
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                    iprot.readFieldEnd();
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        }
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return 0;
    @org.apache.thrift.annotation.Nullable
        hashCode = hashCode * 8191 + ((isSetMessage()) ? 131071 : 524287);
    }
        int hashCode = 1;
        try {
                } else {
        if (lastComparison != 0) {
    }
    }
                }
public class AlreadyExistsException extends org.apache.thrift.TException
    /** Returns true if field message is set (has been assigned a value) and false otherwise */
    }
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                prot.decrementRecursionDepth();
            struct.validate();
        @Override
        // check for sub-struct validity
    public _Fields fieldForId(int fieldId) {
    public boolean isSet(_Fields field) {
        }
    private static class AlreadyExistsExceptionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    @Override
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        }
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
    public boolean isSetMessage() {
    @Override
                oprot.writeString(struct.message);
        java.io.Serializable,
            oprot.writeBitSet(optionals, 1);
        if (other.isSetMessage()) {
        sb.append(")");
    public int compareTo(AlreadyExistsException other) {
        }
            this.message = null;
        }
                    setMessage((java.lang.String) value);
    public int hashCode() {
        private final java.lang.String _fieldName;
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        // check for required fields
    }
    public AlreadyExistsException() {}
                default:
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        public AlreadyExistsExceptionTupleScheme getScheme() {
            if (!this.message.equals(that.message)) return false;
    @org.apache.thrift.annotation.Nullable
        /**
    public java.lang.Object getFieldValue(_Fields field) {
                iprot.readStructEnd();
            if (struct.isSetMessage()) {
        return true;
    }
            } finally {
        public AlreadyExistsExceptionStandardScheme getScheme() {
                    return MESSAGE;
        Comparable<AlreadyExistsException> {
         */
        public void read(org.apache.thrift.protocol.TProtocol prot, AlreadyExistsException struct) throws org.apache.thrift.TException {
                oprot.writeFieldBegin(MESSAGE_FIELD_DESC);
            oprot.writeFieldStop();
                    switch (schemeField.id) {
 * Autogenerated by Thrift Compiler (0.23.0)
 *  @generated
            new org.apache.thrift.meta_data.FieldMetaData(
        }
            .getScheme();
        if (isSetMessage()) hashCode = hashCode * 8191 + message.hashCode();
    private static class AlreadyExistsExceptionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        return new AlreadyExistsException(this);
        }
        return false;
            }
        }
            }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    public void unsetMessage() {
    }
         * Find the _Fields constant that matches fieldId, or null if its not found.
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
    }
        public static _Fields findByThriftIdOrThrow(int fieldId) {
    }
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            case MESSAGE:
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
                        case 1: // MESSAGE
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        _Fields(short thriftId, java.lang.String fieldName) {
        lastComparison = java.lang.Boolean.compare(isSetMessage(), other.isSetMessage());
        if (this.message == null) {
        @Override
    @Override
     */
                while (true) {
        switch (field) {
    public AlreadyExistsException(AlreadyExistsException other) {
        }
            java.util.BitSet optionals = new java.util.BitSet();
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
    }
                    unsetMessage();
                "message",
        this.message = null;
                        break;
                        default:
        }
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            prot.incrementRecursionDepth();
            _Fields,
        switch (field) {
        scheme(oprot).write(oprot, this);
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
 */
/**
         * Find the _Fields constant that matches name, or null if its not found.
        Cloneable,
            return byName.get(name);
            }
                iprot.decrementRecursionDepth();
                }
                oprot.writeFieldEnd();
        int lastComparison = 0;
        return hashCode;
            case MESSAGE:
    }
            return getClass().getName().compareTo(other.getClass().getName());
        public static _Fields findByThriftId(int fieldId) {
        static {
                                struct.setMessageIsSet(true);
                if (incoming.get(0)) {
                return lastComparison;
            this.message = other.message;
    }
            sb.append(this.message);
    }
            oprot.writeStructEnd();
        scheme(iprot).read(iprot, this);
        if (!getClass().equals(other.getClass())) {
    @Override
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        if (!value) {
        }
    }
    @Override
    }
                return getMessage();
        switch (field) {
        return this.message;
        if (isSetMessage()) {
        /**
            } finally {
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            try {
                oprot.writeString(struct.message);
                break;
            if (!(this_present_message && that_present_message)) return false;
        }
                byName.put(field.getFieldName(), field);
    private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField(
        public void write(org.apache.thrift.protocol.TProtocol prot, AlreadyExistsException struct) throws org.apache.thrift.TException {
    }
            }
    public void setMessageIsSet(boolean value) {
    public @org.apache.thrift.annotation.Nullable java.lang.String message; // required
        sb.append("message:");
    public AlreadyExistsException(java.lang.String message) {
        return this;
            case MESSAGE:
                            } else {
        public static _Fields findByName(java.lang.String name) {
    );
        }
     * Performs a deep copy on <i>other</i>.
    public void validate() throws org.apache.thrift.TException {
    public AlreadyExistsException deepCopy() {
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    @Override
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new AlreadyExistsExceptionStandardSchemeFactory();
    private static class AlreadyExistsExceptionTupleScheme extends org.apache.thrift.scheme.TupleScheme<AlreadyExistsException> {
            throw new java.lang.IllegalArgumentException();
                case 1: // MESSAGE
        try {
    }
    public boolean equals(java.lang.Object that) {
