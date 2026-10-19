            switch (fieldId) {
        }
                case 2: // TBL_NAME
        }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
}
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
        return this;
    }  
            oprot.writeString(struct.tblName);
            }  
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        }  
        }
        @Override  
        first = false;
            }  
                // check for required fields of primitive type, which can't be checked in the validate method
package org.opensearch.plugin.hive.metastore;  
        boolean this_present_tblName = true && this.isSetTblName();
                    setDbName((java.lang.String) value);  
        @Override  
                        default:
        if (that == null) return false;
        } else {
                    iprot.readFieldEnd();
 *  @generated
        }
            struct.validate();
            }
                if (value == null) {  
                "tblName",
            prot.incrementRecursionDepth();  
        }
                iprot.readStructEnd();  
        if (this_present_tblName || that_present_tblName) {
    }
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        sb.append("tblName:");
 */
    @org.apache.thrift.annotation.Nullable  
    }
            case DB_NAME:
                return lastComparison;
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {  
    }  
                } else {
        tmpMap.put(
        }  
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetTableRequest");  
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
            if (lastComparison != 0) {
            sb.append(this.dbName);  
     * Performs a deep copy on <i>other</i>.
public class GetTableRequest  
                oprot.writeFieldEnd();
        }
                    switch (schemeField.id) {
        } catch (org.apache.thrift.TException te) {
        return this.tblName;  
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'dbName' was not present! Struct: " + toString());  
        if (this.tblName == null) {
        }
        @Override
        if (!getClass().equals(other.getClass())) {  
        return 0;
    public void setDbNameIsSet(boolean value) {
            try {  
            }
    @Override  
                case 1: // DB_NAME
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                }
        "dbName",  
    }  
    private static class GetTableRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<GetTableRequest> {
            } finally {
    /**
    public @org.apache.thrift.annotation.Nullable java.lang.String tblName; // required
        private final java.lang.String _fieldName;  
    // isset id assignments  
        this.dbName = null;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                struct.setTblNameIsSet(true);  
            throw new java.lang.IllegalArgumentException();  
/**  
        boolean first = true;  
    @org.apache.thrift.annotation.Nullable  
    @org.apache.thrift.annotation.Nullable
                struct.validate();  
        @Override  
    public _Fields fieldForId(int fieldId) {
                default:  
                oprot.writeFieldBegin(TBL_NAME_FIELD_DESC);
                            } else {
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            _fieldName = fieldName;
    public boolean equals(java.lang.Object that) {
        this.tblName = tblName;
    public GetTableRequest deepCopy() {
        return true;  
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            )
    public boolean isSet(_Fields field) {
    @Override
            this.dbName = other.dbName;  
    @Override
        }
        @Override
    }  
    static {
    @org.apache.thrift.annotation.Nullable
         */
            return lastComparison;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        break;  
            if (!this.tblName.equals(that.tblName)) return false;  
        return this;
    public int compareTo(GetTableRequest other) {
        sb.append("dbName:");
         * Find the _Fields constant that matches name, or null if its not found.
            return fields;  
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        }
                iprot.decrementRecursionDepth();
                    return null;
                oprot.writeFieldBegin(DB_NAME_FIELD_DESC);  
        this.tblName = null;  
        if (lastComparison != 0) {
            )  
    }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        public java.lang.String getFieldName() {
        sb.append(")");
        @Override
        if (isSetDbName()) hashCode = hashCode * 8191 + dbName.hashCode();
        if (lastComparison != 0) {
    }
                            break;
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
        int hashCode = 1;
    public @org.apache.thrift.annotation.Nullable java.lang.String dbName; // required
        switch (field) {
    }  
        }
                                struct.dbName = iprot.readString();
    public java.lang.String getTblName() {
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
    public void unsetTblName() {
                return isSetDbName();
        }
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'tblName' was not present! Struct: " + toString());  
            }
        public GetTableRequestStandardScheme getScheme() {
            case TBL_NAME:
            } finally {
    );  
        }
    }
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
     */  
                struct.dbName = iprot.readString();  
        first = false;
                    }  
        @Override
            }
                oprot.writeString(struct.tblName);  
    private static class GetTableRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
        }
            return byName.get(name);
                break;
                                struct.setDbNameIsSet(true);  
    public void validate() throws org.apache.thrift.TException {  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {  
        if (other.isSetTblName()) {
        this.tblName = null;  
        }
    @Override
    public GetTableRequest setTblName(@org.apache.thrift.annotation.Nullable java.lang.String tblName) {  
    implements
    }
        public void read(org.apache.thrift.protocol.TProtocol iprot, GetTableRequest struct) throws org.apache.thrift.TException {
        );
        this.dbName = dbName;  
        public short getThriftFieldId() {
        public void read(org.apache.thrift.protocol.TProtocol prot, GetTableRequest struct) throws org.apache.thrift.TException {
                org.apache.thrift.TFieldRequirementType.REQUIRED,  
    @Override  
        if (isSetTblName()) hashCode = hashCode * 8191 + tblName.hashCode();
    }
    }
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetTableRequest.class, metaDataMap);
            iprot.incrementRecursionDepth();
            new org.apache.thrift.meta_data.FieldMetaData(
    }
    /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
        return hashCode;
    }
        }  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tblName, other.tblName);  
        tmpMap.put(  
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
        hashCode = hashCode * 8191 + ((isSetDbName()) ? 131071 : 524287);
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    }  
    public java.lang.String getDbName() {
        this.dbName = null;
            oprot.writeStructEnd();
                } else {
        }
        scheme(oprot).write(oprot, this);  
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new GetTableRequestTupleSchemeFactory();
    private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
        (short) 1
        Comparable<GetTableRequest> {
                break;
    }
    public void setTblNameIsSet(boolean value) {
        }  
        }
        int lastComparison = 0;
                oprot.writeString(struct.dbName);
    @Override
                    unsetTblName();  
            return _fieldName;
        (short) 2
            if (!(this_present_dbName && that_present_dbName)) return false;
            case DB_NAME:
    public GetTableRequest setDbName(@org.apache.thrift.annotation.Nullable java.lang.String dbName) {
    }  
                oprot.writeFieldEnd();
    public int hashCode() {
        throw new java.lang.IllegalStateException();  
        }  
        boolean that_present_tblName = true && that.isSetTblName();  
            _Fields fields = findByThriftId(fieldId);
            if (struct.tblName != null) {
    }
    @Override  
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));  
            oprot.writeFieldStop();  
                    unsetDbName();
            throw new java.io.IOException(te);  
                    return TBL_NAME;
        if (!first) sb.append(", ");  
        this.dbName = dbName;  
         * Find the _Fields constant that matches fieldId, throwing an exception  
        public void write(org.apache.thrift.protocol.TProtocol prot, GetTableRequest struct) throws org.apache.thrift.TException {
                org.apache.thrift.protocol.TField schemeField;
        }  
                prot.decrementRecursionDepth();
                byName.put(field.getFieldName(), field);
    public java.lang.Object getFieldValue(_Fields field) {
        // check for sub-struct validity
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                struct.setDbNameIsSet(true);
        /**
        }
            .getScheme();  
    @Override  
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new GetTableRequestStandardSchemeFactory();
        if (other.isSetDbName()) {
 * Autogenerated by Thrift Compiler (0.23.0)
        if (dbName == null) {
    public GetTableRequest(GetTableRequest other) {
    /** Returns true if field tblName is set (has been assigned a value) and false otherwise */  
    }
    }
                return getDbName();
        }  
                return getTblName();
                iprot.readStructBegin();
        // check for required fields
            case TBL_NAME:  
        this();
         * Find the _Fields constant that matches fieldId, or null if its not found.  
            sb.append("null");
        boolean that_present_dbName = true && that.isSetDbName();
            oprot.writeString(struct.dbName);  
        if (!value) {  
                struct.tblName = iprot.readString();
    private static class GetTableRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<GetTableRequest> {
 *
        return sb.toString();  
        org.apache.thrift.protocol.TType.STRING,  
        return this.tblName != null;
        if (field == null) {
         */
    public boolean isSetTblName() {
    private static class GetTableRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
    @Override
            return _thriftId;  
                    schemeField = iprot.readFieldBegin();
    private static final org.apache.thrift.protocol.TField TBL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                            }  
            sb.append(this.tblName);
            _thriftId = thriftId;  
                                struct.tblName = iprot.readString();
                    setTblName((java.lang.String) value);
                            break;  
        return this.dbName;
        if (isSetTblName()) {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    @Override
         * if it is not found.
        throw new java.lang.IllegalStateException();
    );
        /**  
                        case 1: // DB_NAME  
        return _Fields.findByThriftId(fieldId);
            this.dbName = null;  
                    }
    }
        switch (field) {  
                "dbName",  
            }  
        hashCode = hashCode * 8191 + ((isSetTblName()) ? 131071 : 524287);
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                return lastComparison;
                }
                    return DB_NAME;  
    }
        @org.apache.thrift.annotation.Nullable
        }  
    }
        if (!value) {
        try {
            if (lastComparison != 0) {  
                while (true) {  
    }
    }
        Cloneable,
        public static _Fields findByName(java.lang.String name) {
        );  
            }  
            new org.apache.thrift.meta_data.FieldMetaData(
        return false;  
            return new GetTableRequestStandardScheme();  
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        org.apache.thrift.TBase<GetTableRequest, GetTableRequest._Fields>,
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {  
        if (this.dbName == null) {  
        if (tblName == null) {
        lastComparison = java.lang.Boolean.compare(isSetDbName(), other.isSetDbName());  
        static {
        } catch (org.apache.thrift.TException te) {
    }
        this.tblName = tblName;
        }  
    }
        }
    public GetTableRequest(java.lang.String dbName, java.lang.String tblName) {
                        case 2: // TBL_NAME
        if (this_present_dbName || that_present_dbName) {  
            _Fields.DB_NAME,
            _Fields,
        }
        boolean this_present_dbName = true && this.isSetDbName();
    public boolean equals(GetTableRequest that) {  
         */
        }
    public void clear() {
        if (isSetDbName()) {
        }  
        org.apache.thrift.protocol.TType.STRING,
        }
                if (value == null) {
        try {  
    }  
        "tblName",
        public void write(org.apache.thrift.protocol.TProtocol oprot, GetTableRequest struct) throws org.apache.thrift.TException {
            return new GetTableRequestTupleScheme();  
            throw new java.io.IOException(te);
        TBL_NAME((short) 2, "tblName");
            this.tblName = null;
        @org.apache.thrift.annotation.Nullable  
        lastComparison = java.lang.Boolean.compare(isSetTblName(), other.isSetTblName());
    public GetTableRequest() {}
    }
                            }
    public boolean isSetDbName() {  
                return isSetTblName();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("GetTableRequest(");
            this.tblName = other.tblName;  
            sb.append("null");  
        switch (field) {  
        } else {
        _Fields(short thriftId, java.lang.String fieldName) {
    public void unsetDbName() {
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        if (this == that) return true;
        scheme(iprot).read(iprot, this);
        }
        private final short _thriftId;
    @Override  
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    }
        if (that instanceof GetTableRequest) return this.equals((GetTableRequest) that);
        return new GetTableRequest(this);  
    }
        public GetTableRequestTupleScheme getScheme() {
            return getClass().getName().compareTo(other.getClass().getName());
            case TBL_NAME:
                                struct.setTblNameIsSet(true);
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            return lastComparison;  
            if (struct.dbName != null) {
        }
        /**
    public java.lang.String toString() {
    @Override  
            _Fields.TBL_NAME,  
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();  
        @Override  
            oprot.writeStructBegin(STRUCT_DESC);
        return this.dbName != null;
            if (!(this_present_tblName && that_present_tblName)) return false;
    }
            case DB_NAME:
            try {
            if (!this.dbName.equals(that.dbName)) return false;
        java.io.Serializable,  
    }  
                            } else {  
                org.apache.thrift.TFieldRequirementType.REQUIRED,
        public static _Fields findByThriftId(int fieldId) {  
    }  
        DB_NAME((short) 1, "dbName"),  
                }  
