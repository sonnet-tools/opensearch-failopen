         */
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
            oprot.writeStructBegin(STRUCT_DESC);
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    public java.lang.Object getFieldValue(_Fields field) {
        first = false;  
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
        switch (field) {
        try {
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MetaExceptionStandardSchemeFactory();
        java.io.Serializable,  
        }  
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MetaExceptionTupleSchemeFactory();  
    public void unsetMessage() {  
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MetaException");  
            return new MetaExceptionTupleScheme();
    }
        lastComparison = java.lang.Boolean.compare(isSetMessage(), other.isSetMessage());
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {  
    }
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {  
        @Override
            } finally {  
        public short getThriftFieldId() {
        static {
            return getClass().getName().compareTo(other.getClass().getName());  
        Comparable<MetaException> {
                }
                                struct.setMessageIsSet(true);
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    @Override
        }
         * Find the _Fields constant that matches fieldId, throwing an exception  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        }  
    @Override  
        private final short _thriftId;
                    struct.message = iprot.readString();  
package org.opensearch.plugin.hive.metastore;  
        }
                return getMessage();
                    iprot.readFieldEnd();
    @Override  
        if (this.message == null) {
            }
                oprot.writeString(struct.message);
    public MetaException() {}  
        try {
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            case MESSAGE:  
            _Fields fields = findByThriftId(fieldId);
    /**
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    }  
            try {
            _Fields,
            this.message = null;
        /**
                iprot.readStructBegin();
    }  
                oprot.writeFieldBegin(MESSAGE_FIELD_DESC);  
    }
        if (lastComparison != 0) {  
        }  
        }
                    struct.setMessageIsSet(true);
    private static class MetaExceptionTupleScheme extends org.apache.thrift.scheme.TupleScheme<MetaException> {
            sb.append(this.message);
            oprot.writeStructEnd();
        Cloneable,
    public @org.apache.thrift.annotation.Nullable java.lang.String message; // required
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
            throw new java.io.IOException(te);
        int hashCode = 1;
                oprot.writeFieldEnd();
        @org.apache.thrift.annotation.Nullable  
            sb.append("null");
        sb.append("message:");  
            }
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        sb.append(")");
            } finally {
        hashCode = hashCode * 8191 + ((isSetMessage()) ? 131071 : 524287);  
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            oprot.writeFieldStop();
        if (that == null) return false;
    public void setMessageIsSet(boolean value) {  
        private final java.lang.String _fieldName;  
                    return MESSAGE;
        }  
        public static _Fields findByThriftId(int fieldId) {
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            switch (fieldId) {  
                struct.validate();  
            throw new java.io.IOException(te);
    private static final org.apache.thrift.protocol.TField MESSAGE_FIELD_DESC = new org.apache.thrift.protocol.TField(
            oprot.writeBitSet(optionals, 1);
        return sb.toString();
    public _Fields fieldForId(int fieldId) {
    private static class MetaExceptionStandardScheme extends org.apache.thrift.scheme.StandardScheme<MetaException> {  
        @Override
    }
        return this.message;
        @Override  
        return this;  
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
    }
            }
        this();  
         */
                                struct.message = iprot.readString();
            try {
                    schemeField = iprot.readFieldBegin();  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    // isset id assignments  
            return byName.get(name);
    @Override  
    }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.message, other.message);
        public void read(org.apache.thrift.protocol.TProtocol iprot, MetaException struct) throws org.apache.thrift.TException {  
        }  
    @org.apache.thrift.annotation.Nullable
            _Fields.MESSAGE,
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            _thriftId = thriftId;  
    }
    public boolean equals(java.lang.Object that) {
                    setMessage((java.lang.String) value);
    }  
            prot.incrementRecursionDepth();
            if (!(this_present_message && that_present_message)) return false;
     * Performs a deep copy on <i>other</i>.
        public MetaExceptionTupleScheme getScheme() {  
        org.apache.thrift.protocol.TType.STRING,
    @Override
        scheme(oprot).write(oprot, this);
            return _fieldName;
         * Find the _Fields constant that matches name, or null if its not found.
        public java.lang.String getFieldName() {
            if (!this.message.equals(that.message)) return false;
        "message",  
    public java.lang.String getMessage() {  
            return new MetaExceptionStandardScheme();
                case 1: // MESSAGE
    @org.apache.thrift.annotation.Nullable  
            struct.validate();
                oprot.writeString(struct.message);
                }
    public void clear() {
    }
    implements
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            if (struct.isSetMessage()) {  
        }
        public void read(org.apache.thrift.protocol.TProtocol prot, MetaException struct) throws org.apache.thrift.TException {  
                optionals.set(0);  
            iprot.incrementRecursionDepth();
    }
    public MetaException setMessage(@org.apache.thrift.annotation.Nullable java.lang.String message) {
            _fieldName = fieldName;
    public int hashCode() {  
                            }
            this.message = other.message;  
                    }  
        return _Fields.findByThriftId(fieldId);  
        );
        }  
                iprot.decrementRecursionDepth();
        @Override
                    switch (schemeField.id) {
 * Autogenerated by Thrift Compiler (0.23.0)
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
            }
            }
        }  
    @Override  
        this.message = message;
}
        // check for required fields  
    );  
        this.message = null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("MetaException(");  
        }  
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
    public boolean isSet(_Fields field) {  
            if (lastComparison != 0) {
    }
    }
    private static class MetaExceptionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            case MESSAGE:  
            )  
            new org.apache.thrift.meta_data.FieldMetaData(
        }  
        (short) 1
        _Fields(short thriftId, java.lang.String fieldName) {
    @Override
                while (true) {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    }
        org.apache.thrift.TBase<MetaException, MetaException._Fields>,
        @Override
        }
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                default:  
        }  
        if (isSetMessage()) hashCode = hashCode * 8191 + message.hashCode();
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MetaException.class, metaDataMap);  
        } else {  
         * if it is not found.
        @Override
    @org.apache.thrift.annotation.Nullable
        /**
                "message",  
        public void write(org.apache.thrift.protocol.TProtocol oprot, MetaException struct) throws org.apache.thrift.TException {
        boolean this_present_message = true && this.isSetMessage();
                if (value == null) {
                byName.put(field.getFieldName(), field);  
                            break;  
    }
        return true;
                        default:
        return hashCode;  
    }
        throw new java.lang.IllegalStateException();  
    }
        }
    public boolean equals(MetaException that) {  
    }
                return isSetMessage();
                prot.decrementRecursionDepth();
        return 0;  
                }
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
                iprot.readStructEnd();  
    }  
    @Override  
    @Override
        return false;  
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        scheme(iprot).read(iprot, this);
    }
 */
        }  
            }  
    static {
        int lastComparison = 0;  
    @Override
                org.apache.thrift.protocol.TField schemeField;  
    }
        return new MetaException(this);  
        if (field == null) {
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                            } else {  
        switch (field) {
    @Override  
            return _thriftId;  
        this.message = message;
        }
    public java.lang.String toString() {
                break;  
    private static class MetaExceptionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        this.message = null;
            if (struct.isSetMessage()) {
        @org.apache.thrift.annotation.Nullable
         * Find the _Fields constant that matches fieldId, or null if its not found.
        }
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
                    unsetMessage();
            case MESSAGE:  
    /** Returns true if field message is set (has been assigned a value) and false otherwise */
        switch (field) {
        }
/**  
                    return null;
            if (struct.message != null) {
        if (isSetMessage()) {  
    }  
 *
    public void validate() throws org.apache.thrift.TException {
            }  
            java.util.BitSet optionals = new java.util.BitSet();
    public int compareTo(MetaException other) {
     */  
 *  @generated
    public MetaException(MetaException other) {
    public MetaException(java.lang.String message) {
        }
public class MetaException extends org.apache.thrift.TException  
            .getScheme();
        }
        }  
                        case 1: // MESSAGE
                return lastComparison;  
        boolean first = true;
    }
        if (!value) {
        if (other.isSetMessage()) {
        if (this == that) return true;
        }
        if (!getClass().equals(other.getClass())) {
        if (this_present_message || that_present_message) {  
    }
    public boolean isSetMessage() {
        } catch (org.apache.thrift.TException te) {
    }
        public MetaExceptionStandardScheme getScheme() {
        public void write(org.apache.thrift.protocol.TProtocol prot, MetaException struct) throws org.apache.thrift.TException {
        MESSAGE((short) 1, "message");  
        throw new java.lang.IllegalStateException();
        // check for sub-struct validity
    public MetaException deepCopy() {
        @Override  
         */  
        @Override  
                        break;
            throw new java.lang.IllegalArgumentException();
    @Override
        if (that instanceof MetaException) return this.equals((MetaException) that);
            return fields;  
                    }  
            }
        tmpMap.put(  
    }
    }  
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                if (incoming.get(0)) {
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        boolean that_present_message = true && that.isSetMessage();
        /**  
        } catch (org.apache.thrift.TException te) {  
        }
                } else {  
                // check for required fields of primitive type, which can't be checked in the validate method
                java.util.BitSet incoming = iprot.readBitSet(1);
    }  
        return this.message != null;  
        public static _Fields findByName(java.lang.String name) {
            return lastComparison;
    }  
