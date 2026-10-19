            }  
        Comparable<AlreadyExistsException> {
    @Override
        private final java.lang.String _fieldName;  
        return this;  
    }  
    }
    public @org.apache.thrift.annotation.Nullable java.lang.String message; // required
    }
                oprot.writeFieldBegin(MESSAGE_FIELD_DESC);  
    @org.apache.thrift.annotation.Nullable  
        public AlreadyExistsExceptionTupleScheme getScheme() {  
         * Find the _Fields constant that matches fieldId, throwing an exception  
public class AlreadyExistsException extends org.apache.thrift.TException  
        java.lang.StringBuilder sb = new java.lang.StringBuilder("AlreadyExistsException(");  
            this.message = null;
            if (struct.isSetMessage()) {
        this.message = message;
    public int compareTo(AlreadyExistsException other) {
            return new AlreadyExistsExceptionTupleScheme();
        }  
        }
        first = false;  
    }
                prot.decrementRecursionDepth();
                org.apache.thrift.protocol.TField schemeField;  
        }
    }
            return lastComparison;
            if (!(this_present_message && that_present_message)) return false;
        }  
    }  
        if (lastComparison != 0) {  
    }
        public void write(org.apache.thrift.protocol.TProtocol oprot, AlreadyExistsException struct) throws org.apache.thrift.TException {
        } catch (org.apache.thrift.TException te) {
    }
    );  
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {  
                    unsetMessage();
         * if it is not found.
    private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
            java.util.BitSet optionals = new java.util.BitSet();
    public void clear() {
 *
                struct.validate();  
                oprot.writeFieldEnd();
            if (lastComparison != 0) {
                return lastComparison;  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            _Fields.MESSAGE,
            return _thriftId;  
        static {
        scheme(iprot).read(iprot, this);
                }
    public AlreadyExistsException setMessage(@org.apache.thrift.annotation.Nullable java.lang.String message) {
        boolean this_present_message = true && this.isSetMessage();
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        @Override  
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            this.message = other.message;  
        // check for sub-struct validity
        hashCode = hashCode * 8191 + ((isSetMessage()) ? 131071 : 524287);  
    }  
    public AlreadyExistsException(AlreadyExistsException other) {
                        default:
        @Override
        int lastComparison = 0;  
            if (!this.message.equals(that.message)) return false;
    }
    private static class AlreadyExistsExceptionStandardScheme extends org.apache.thrift.scheme.StandardScheme<AlreadyExistsException> {  
package org.opensearch.plugin.hive.metastore;  
                oprot.writeString(struct.message);
                case 1: // MESSAGE
            )  
                iprot.readStructBegin();
        @org.apache.thrift.annotation.Nullable
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
    @org.apache.thrift.annotation.Nullable
        } else {  
    public AlreadyExistsException deepCopy() {
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
                    return null;
            prot.incrementRecursionDepth();
        (short) 1
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
            oprot.writeStructEnd();
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        throw new java.lang.IllegalStateException();  
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            switch (fieldId) {  
        return false;  
        public void write(org.apache.thrift.protocol.TProtocol prot, AlreadyExistsException struct) throws org.apache.thrift.TException {
     * Performs a deep copy on <i>other</i>.
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            _thriftId = thriftId;  
        if (isSetMessage()) hashCode = hashCode * 8191 + message.hashCode();
        sb.append(")");
            case MESSAGE:  
        return _Fields.findByThriftId(fieldId);  
        private final short _thriftId;
            return byName.get(name);
            if (struct.isSetMessage()) {  
        return new AlreadyExistsException(this);  
        return sb.toString();
    public int hashCode() {  
            _fieldName = fieldName;
        if (this_present_message || that_present_message) {  
        boolean that_present_message = true && that.isSetMessage();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        /**
         * Find the _Fields constant that matches fieldId, or null if its not found.
        } catch (org.apache.thrift.TException te) {  
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return hashCode;  
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new AlreadyExistsExceptionStandardSchemeFactory();
        @Override  
            }
        if (that == null) return false;
                if (incoming.get(0)) {
    }
    @Override  
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
    }
        }  
        public short getThriftFieldId() {
            return _fieldName;
            throw new java.io.IOException(te);
                if (value == null) {
                default:  
    }
    }
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AlreadyExistsException");  
    static {
        if (!getClass().equals(other.getClass())) {
    public java.lang.String getMessage() {  
    }
                } else {  
    /**
        @Override
                oprot.writeString(struct.message);
    }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        public static _Fields findByName(java.lang.String name) {
                return isSetMessage();
    }  
            try {
                    }  
    public void setMessageIsSet(boolean value) {  
    @Override  
        tmpMap.put(  
        }  
        }  
         * Find the _Fields constant that matches name, or null if its not found.
    @Override  
                iprot.readStructEnd();  
                break;  
    public boolean isSet(_Fields field) {  
            return new AlreadyExistsExceptionStandardScheme();
        public void read(org.apache.thrift.protocol.TProtocol iprot, AlreadyExistsException struct) throws org.apache.thrift.TException {  
    implements
                // check for required fields of primitive type, which can't be checked in the validate method
    @Override  
    @Override
            return getClass().getName().compareTo(other.getClass().getName());  
        if (isSetMessage()) {  
            }
    public AlreadyExistsException(java.lang.String message) {
         */  
    public boolean equals(java.lang.Object that) {
        sb.append("message:");  
            _Fields,
        if (other.isSetMessage()) {
            oprot.writeBitSet(optionals, 1);
}
            if (struct.message != null) {
    }
        @org.apache.thrift.annotation.Nullable  
        switch (field) {
    }
    @Override
            .getScheme();
        /**  
    public java.lang.String toString() {
                    return MESSAGE;
                            break;  
                    }  
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
 *  @generated
            } finally {
            }  
    public void unsetMessage() {  
            case MESSAGE:  
    public AlreadyExistsException() {}  
                return getMessage();
        java.io.Serializable,  
        }  
            return fields;  
        throw new java.lang.IllegalStateException();
    @Override
    public boolean isSetMessage() {
         */
            try {
    public _Fields fieldForId(int fieldId) {
/**  
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        org.apache.thrift.TBase<AlreadyExistsException, AlreadyExistsException._Fields>,
         */
        }
                    struct.message = iprot.readString();  
    }  
                        case 1: // MESSAGE
        public java.lang.String getFieldName() {
        @Override  
                java.util.BitSet incoming = iprot.readBitSet(1);
            struct.validate();
                            }
        MESSAGE((short) 1, "message");  
    public void validate() throws org.apache.thrift.TException {
 */
        }
    }
        switch (field) {
        org.apache.thrift.protocol.TType.STRING,
    @org.apache.thrift.annotation.Nullable
    }  
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    }  
        // check for required fields  
            }
        );
        @Override
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
        }
        }
        }  
            sb.append("null");
    @Override  
        }  
            throw new java.lang.IllegalArgumentException();
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
        /**
 * Autogenerated by Thrift Compiler (0.23.0)
        if (that instanceof AlreadyExistsException) return this.equals((AlreadyExistsException) that);
    }
            new org.apache.thrift.meta_data.FieldMetaData(
                while (true) {
    public java.lang.Object getFieldValue(_Fields field) {
        @Override
                "message",  
    @Override
        if (!value) {
    private static class AlreadyExistsExceptionTupleScheme extends org.apache.thrift.scheme.TupleScheme<AlreadyExistsException> {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }  
                    switch (schemeField.id) {
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new AlreadyExistsExceptionTupleSchemeFactory();  
        }
                                struct.message = iprot.readString();
            throw new java.io.IOException(te);
                byName.put(field.getFieldName(), field);  
                }
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            }
    }
    }
                    setMessage((java.lang.String) value);
        "message",  
        int hashCode = 1;
    public boolean equals(AlreadyExistsException that) {  
        return 0;  
     */  
                iprot.decrementRecursionDepth();
            oprot.writeStructBegin(STRUCT_DESC);
        return this.message;
        }
            oprot.writeFieldStop();
    }
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {  
                }
        @Override
    }  
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
                optionals.set(0);  
                    schemeField = iprot.readFieldBegin();  
        this.message = message;
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        }  
        _Fields(short thriftId, java.lang.String fieldName) {
        if (this.message == null) {
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
    @Override  
        }
    @Override
            sb.append(this.message);
        if (this == that) return true;
        boolean first = true;
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                        break;
        try {
        public void read(org.apache.thrift.protocol.TProtocol prot, AlreadyExistsException struct) throws org.apache.thrift.TException {  
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        }
        lastComparison = java.lang.Boolean.compare(isSetMessage(), other.isSetMessage());
            } finally {  
    /** Returns true if field message is set (has been assigned a value) and false otherwise */
    private static class AlreadyExistsExceptionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        return this.message != null;  
        return true;
                    iprot.readFieldEnd();
        this();  
                            } else {  
        this.message = null;
                                struct.setMessageIsSet(true);
                    struct.setMessageIsSet(true);
        try {
    // isset id assignments  
        }
        if (field == null) {
        }
        }  
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
            case MESSAGE:  
            _Fields fields = findByThriftId(fieldId);
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        switch (field) {
        public static _Fields findByThriftId(int fieldId) {
            }
            }
    }
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
        Cloneable,
    private static class AlreadyExistsExceptionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        scheme(oprot).write(oprot, this);
        }
    }
        public AlreadyExistsExceptionStandardScheme getScheme() {
        this.message = null;
        }  
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AlreadyExistsException.class, metaDataMap);  
            iprot.incrementRecursionDepth();
