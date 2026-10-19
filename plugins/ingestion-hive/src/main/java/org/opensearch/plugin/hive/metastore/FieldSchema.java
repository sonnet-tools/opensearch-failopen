        }
            return new FieldSchemaStandardScheme();
    }
                }
        return this.type != null;  
                    unsetComment();
    @Override
    }
                                struct.name = iprot.readString();  
        hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
}
            }
                    unsetType();
        (short) 1
                return lastComparison;
    }
                optionals.set(1);
    }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
    public int compareTo(FieldSchema other) {  
        }
        }  
        try {  
    // isset id assignments  
        public FieldSchemaTupleScheme getScheme() {
                        case 3: // COMMENT
    }
        return this;  
                    setComment((java.lang.String) value);  
        if (!value) {
    }
        org.apache.thrift.TBase<FieldSchema, FieldSchema._Fields>,
        if (that instanceof FieldSchema) return this.equals((FieldSchema) that);
     * Performs a deep copy on <i>other</i>.
        }  
        }
    public void clear() {
    public FieldSchema(FieldSchema other) {
            oprot.writeStructEnd();  
         * Find the _Fields constant that matches name, or null if its not found.
                    return TYPE;  
        if (other.isSetComment()) {
        this.type = type;
                if (incoming.get(2)) {
        }
    private static class FieldSchemaStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                                struct.type = iprot.readString();
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FieldSchema");  
                    struct.setTypeIsSet(true);  
                } else {
         */
        return _Fields.findByThriftId(fieldId);
    }  
        public void read(org.apache.thrift.protocol.TProtocol prot, FieldSchema struct) throws org.apache.thrift.TException {
        public void read(org.apache.thrift.protocol.TProtocol iprot, FieldSchema struct) throws org.apache.thrift.TException {
            if (struct.isSetName()) {
    }
        @Override
        return this.name;  
    public @org.apache.thrift.annotation.Nullable java.lang.String comment; // required
    @org.apache.thrift.annotation.Nullable
                oprot.writeFieldBegin(TYPE_FIELD_DESC);
            new org.apache.thrift.meta_data.FieldMetaData(
        boolean first = true;
    private static class FieldSchemaTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        TYPE((short) 2, "type"),
 * Uses Hive 3 method names which remain supported by Hive 4 Metastore.  
        return hashCode;
            }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.comment, other.comment);
    private static class FieldSchemaStandardScheme extends org.apache.thrift.scheme.StandardScheme<FieldSchema> {
            try {  
    }
    public @org.apache.thrift.annotation.Nullable java.lang.String name; // required  
        public static _Fields findByName(java.lang.String name) {
                    switch (schemeField.id) {  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        }
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {  
    }  
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */  
    }
                break;  
            sb.append(this.type);
    /**
        );
        first = false;
            return _thriftId;  
                    setName((java.lang.String) value);
                return getType();  
    }
        lastComparison = java.lang.Boolean.compare(isSetName(), other.isSetName());
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    public int hashCode() {
            if (!(this_present_type && that_present_type)) return false;
                }  
        }
    );  
            return lastComparison;  
            }  
    @Override
            _thriftId = thriftId;  
        @Override
            }
    );
         */
            return fields;  
    public FieldSchema setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {  
            )
    }
        if (this_present_name || that_present_name) {  
        this.type = null;
    }  
                if (value == null) {
                    }  
                    struct.setCommentIsSet(true);
        if (this_present_type || that_present_type) {
        boolean that_present_type = true && that.isSetType();  
            return getClass().getName().compareTo(other.getClass().getName());
            }
        org.apache.thrift.protocol.TType.STRING,  
            try {
        if (this == that) return true;
            case COMMENT:
        }
                oprot.writeFieldBegin(NAME_FIELD_DESC);  
        hashCode = hashCode * 8191 + ((isSetComment()) ? 131071 : 524287);
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                oprot.writeString(struct.name);
            _Fields,
        /**  
        } catch (org.apache.thrift.TException te) {  
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
        }
        @Override  
                return isSetName();  
            prot.incrementRecursionDepth();
        if (isSetComment()) {
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                case 3: // COMMENT
        if (lastComparison != 0) {
    public boolean equals(java.lang.Object that) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    public java.lang.String getType() {  
            this.comment = null;  
    /** Returns true if field type is set (has been assigned a value) and false otherwise */
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
    }
            if (lastComparison != 0) {  
                if (incoming.get(1)) {
        );
    }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        boolean that_present_comment = true && that.isSetComment();
    public boolean isSetName() {
    }
    @Override  
        }
        (short) 3  
        return this;
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FieldSchema.class, metaDataMap);
            throw new java.lang.IllegalArgumentException();
    public void setCommentIsSet(boolean value) {
                java.util.BitSet incoming = iprot.readBitSet(3);
        if (lastComparison != 0) {  
        if (this.name == null) {
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
 */
            oprot.writeBitSet(optionals, 3);  
    public @org.apache.thrift.annotation.Nullable java.lang.String type; // required
    }  
            sb.append(this.name);
        lastComparison = java.lang.Boolean.compare(isSetComment(), other.isSetComment());  
    }  
    }
        if (!first) sb.append(", ");
                optionals.set(0);
                oprot.writeFieldBegin(COMMENT_FIELD_DESC);
        sb.append("comment:");
                            } else {
            if (!(this_present_name && that_present_name)) return false;
            sb.append(this.comment);  
            if (struct.isSetType()) {  
        }
            if (struct.isSetComment()) {  
    }  
            oprot.writeFieldStop();
        this.comment = null;
        try {
                    return null;
 * Contains only the types and methods used by HiveShardConsumer.
            if (lastComparison != 0) {
        @Override  
            )
                struct.validate();  
        this.name = name;
                            break;
        /**
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
            if (!this.type.equals(that.type)) return false;  
            switch (fieldId) {
            }  
        /**  
    public boolean isSet(_Fields field) {
    implements
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        @org.apache.thrift.annotation.Nullable  
                iprot.readStructBegin();  
                byName.put(field.getFieldName(), field);
                return lastComparison;  
        }
    }
                return getName();  
    }  
        org.apache.thrift.protocol.TType.STRING,
                    struct.name = iprot.readString();
        lastComparison = java.lang.Boolean.compare(isSetType(), other.isSetType());
                if (incoming.get(0)) {  
            sb.append("null");
        if (lastComparison != 0) {
    }  
            oprot.writeStructBegin(STRUCT_DESC);
        tmpMap.put(
        } catch (org.apache.thrift.TException te) {
    public FieldSchema setComment(@org.apache.thrift.annotation.Nullable java.lang.String comment) {
                return isSetComment();
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                iprot.decrementRecursionDepth();
                            } else {  
        // check for sub-struct validity  
                            }
        this.comment = comment;  
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {  
                }
    @Override
                } else {  
            this.type = other.type;  
                "type",
    }
            case COMMENT:
            }
        public void write(org.apache.thrift.protocol.TProtocol oprot, FieldSchema struct) throws org.apache.thrift.TException {
            }
        public FieldSchemaStandardScheme getScheme() {  
        public static _Fields findByThriftId(int fieldId) {
        @Override  
        }  
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        return new FieldSchema(this);  
            _Fields fields = findByThriftId(fieldId);
        if (!value) {  
        this.comment = null;
    public boolean isSetComment() {  
        }
                oprot.writeString(struct.comment);
    public void unsetName() {
    }
        }
        }  
        );  
            throw new java.io.IOException(te);
                return getComment();  
                iprot.readStructEnd();  
    public java.lang.String toString() {  
    public FieldSchema(java.lang.String name, java.lang.String type, java.lang.String comment) {  
        java.lang.StringBuilder sb = new java.lang.StringBuilder("FieldSchema(");
        return this.name != null;
        if (!value) {
        Cloneable,
    private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
        if (!first) sb.append(", ");
        public short getThriftFieldId() {
        }
                org.apache.thrift.protocol.TField schemeField;
        this.type = type;  
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        boolean that_present_name = true && that.isSetName();
    static {
        if (isSetName()) hashCode = hashCode * 8191 + name.hashCode();  
                        case 1: // NAME
                            break;
                } else {
        COMMENT((short) 3, "comment");
            if (lastComparison != 0) {
    @Override  
            }  
 * Field numbers match Apache Hive's hive_metastore.thrift (Apache-2.0).
        java.io.Serializable,  
            case NAME:
                if (value == null) {
        static {  
        "type",
            }  
        if (this_present_comment || that_present_comment) {
        "comment",
            _Fields.NAME,
                                struct.setNameIsSet(true);
        if (this.type == null) {
    @Override
                            } else {
                case 2: // TYPE
                org.apache.thrift.TFieldRequirementType.DEFAULT,  
    public java.lang.String getComment() {
        this.name = name;
                oprot.writeFieldEnd();  
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        return this.comment;
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)  
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            this.name = other.name;  
            }
            sb.append("null");
        if (field == null) {  
                "name",  
        }
        if (isSetType()) {  
            case TYPE:  
                oprot.writeString(struct.type);  
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                    struct.setNameIsSet(true);
        return this;
                oprot.writeString(struct.comment);
    @org.apache.thrift.annotation.Nullable
        boolean this_present_comment = true && this.isSetComment();  
        (short) 2
        } else {
        }
    public java.lang.String getName() {
    public boolean equals(FieldSchema that) {  
    }
    }
            if (struct.type != null) {
        return this.type;
    private static class FieldSchemaTupleScheme extends org.apache.thrift.scheme.TupleScheme<FieldSchema> {  
                oprot.writeString(struct.name);
        }  
        private final java.lang.String _fieldName;  
            if (struct.isSetComment()) {
         * Find the _Fields constant that matches fieldId, or null if its not found.
/**  
                                struct.setCommentIsSet(true);
                }
        this.comment = comment;
        return sb.toString();
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
                    setType((java.lang.String) value);
            } finally {  
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    public void setTypeIsSet(boolean value) {  
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                oprot.writeString(struct.type);
    @org.apache.thrift.annotation.Nullable
            if (struct.isSetName()) {  
                if (value == null) {  
            new org.apache.thrift.meta_data.FieldMetaData(  
         * Find the _Fields constant that matches fieldId, throwing an exception  
        switch (field) {
        Comparable<FieldSchema> {
                    iprot.readFieldEnd();
        first = false;  
    }
    @org.apache.thrift.annotation.Nullable
    }  
                // check for required fields of primitive type, which can't be checked in the validate method
                            break;  
        }
                case 1: // NAME  
                            }
                }  
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        }
            if (!this.name.equals(that.name)) return false;
    }
 *  @generated
        switch (field) {
                }
                    return COMMENT;
            return lastComparison;
         */
            }  
                        default:
            sb.append("null");  
                    struct.comment = iprot.readString();  
    @Override
            }  
        throw new java.lang.IllegalStateException();  
            case NAME:
            new org.apache.thrift.meta_data.FieldMetaData(
    @Override
        "name",  
    }
            if (!(this_present_comment && that_present_comment)) return false;  
        sb.append(")");  
            case TYPE:
    }  
                }
                oprot.writeFieldEnd();
        } else {
        if (that == null) return false;
            } finally {
            struct.validate();
                    schemeField = iprot.readFieldBegin();
        boolean this_present_type = true && this.isSetType();
        tmpMap.put(  
        NAME((short) 1, "name"),  
                prot.decrementRecursionDepth();
        switch (field) {  
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            return _fieldName;
        this.name = null;  
        boolean this_present_name = true && this.isSetName();
        sb.append("name:");
            java.util.BitSet optionals = new java.util.BitSet();
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        @Override
        if (other.isSetName()) {
            _Fields.TYPE,  
                    return NAME;
        scheme(oprot).write(oprot, this);
    public void unsetComment() {
            this.type = null;
            return new FieldSchemaTupleScheme();
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
                        case 2: // TYPE  
        }
    }
    }  
        }  
        scheme(iprot).read(iprot, this);  
        this();
            .getScheme();
        org.apache.thrift.protocol.TType.STRING,
                return lastComparison;
        }
     */  
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    public FieldSchema() {}
         * if it is not found.
                                struct.comment = iprot.readString();
    }
        tmpMap.put(
        }  
                    struct.type = iprot.readString();
            _fieldName = fieldName;
    public void setNameIsSet(boolean value) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        if (isSetType()) hashCode = hashCode * 8191 + type.hashCode();  
        // check for required fields
        private final short _thriftId;
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);  
    @Override  
                        break;
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        }
        return false;  
        public void write(org.apache.thrift.protocol.TProtocol prot, FieldSchema struct) throws org.apache.thrift.TException {  
            return byName.get(name);
            if (struct.isSetType()) {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                                struct.setTypeIsSet(true);  
            this.comment = other.comment;  
        }
    /** Returns true if field comment is set (has been assigned a value) and false otherwise */
 * Minimal Hive Metastore Thrift IDL for the ingestion-hive plugin.  
        if (!getClass().equals(other.getClass())) {
            )  
    }
        this.type = null;  
            }
        this.name = null;
    public void unsetType() {  
                optionals.set(2);
    public FieldSchema deepCopy() {
            if (struct.comment != null) {  
    }
    @Override
            case TYPE:
    private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField(
public class FieldSchema  
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FieldSchemaTupleSchemeFactory();
        _Fields(short thriftId, java.lang.String fieldName) {
 */
        sb.append("type:");  
        return 0;
        }
 * Autogenerated by Thrift Compiler (0.23.0)
        }  
        }  
            if (struct.name != null) {
            return lastComparison;
                break;
        }
            case COMMENT:  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                            }  
        }
                break;
        return this.comment != null;
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        @Override
        int lastComparison = 0;
    private static final org.apache.thrift.protocol.TField COMMENT_FIELD_DESC = new org.apache.thrift.protocol.TField(  
 *
            throw new java.io.IOException(te);  
    );
                    }
        int hashCode = 1;  
    public boolean isSetType() {
    @Override
package org.opensearch.plugin.hive.metastore;  
                while (true) {
    public _Fields fieldForId(int fieldId) {  
        if (this.comment == null) {  
/**
                return isSetType();
        }
    @Override
                "comment",
            if (!this.comment.equals(that.comment)) return false;
    }
        public java.lang.String getFieldName() {
    public void validate() throws org.apache.thrift.TException {
        first = false;
        }
    @org.apache.thrift.annotation.Nullable  
                oprot.writeFieldEnd();
        @Override  
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {  
            this.name = null;
        if (other.isSetType()) {
    public java.lang.Object getFieldValue(_Fields field) {  
            case NAME:
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FieldSchemaStandardSchemeFactory();  
    }
        if (isSetComment()) hashCode = hashCode * 8191 + comment.hashCode();  
        if (isSetName()) {
        hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    /** Returns true if field name is set (has been assigned a value) and false otherwise */  
        }  
            }
        @org.apache.thrift.annotation.Nullable  
        throw new java.lang.IllegalStateException();  
                    unsetName();  
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        return true;
            }  
        } else {  
                default:  
            _Fields.COMMENT,
            iprot.incrementRecursionDepth();  
        }  
    public FieldSchema setType(@org.apache.thrift.annotation.Nullable java.lang.String type) {
