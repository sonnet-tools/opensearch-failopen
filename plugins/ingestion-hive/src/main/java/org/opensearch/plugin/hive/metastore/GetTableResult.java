        return 0;  
        @Override
            oprot.writeStructEnd();  
/**  
    public void unsetTable() {  
        private final java.lang.String _fieldName;  
        public GetTableResultStandardScheme getScheme() {
        TABLE((short) 1, "table");  
        }  
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new GetTableResultStandardSchemeFactory();
                "table",  
            if (struct.table != null) {  
        if (that instanceof GetTableResult) return this.equals((GetTableResult) that);
    private static class GetTableResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            _fieldName = fieldName;
    @Override
    }
    }  
    }
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'table' was not present! Struct: " + toString());
        public static _Fields findByName(java.lang.String name) {
        return new GetTableResult(this);  
        boolean first = true;
        lastComparison = java.lang.Boolean.compare(isSetTable(), other.isSetTable());
        }  
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        return false;  
    @Override
    }  
                // check for required fields of primitive type, which can't be checked in the validate method  
        org.apache.thrift.TBase<GetTableResult, GetTableResult._Fields>,
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        @Override
            }
    @Override
                                struct.table = new Table();
        }
                default:  
        } catch (org.apache.thrift.TException te) {
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        if (other.isSetTable()) {
            this.table = null;
        }
            _Fields,
    }
        }
        public void write(org.apache.thrift.protocol.TProtocol prot, GetTableResult struct) throws org.apache.thrift.TException {  
        if (!getClass().equals(other.getClass())) {
        this();  
                    schemeField = iprot.readFieldBegin();  
        boolean that_present_table = true && that.isSetTable();
    public GetTableResult deepCopy() {
            } finally {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("GetTableResult(");  
    @Override
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                case 1: // TABLE
                } else {  
        boolean this_present_table = true && this.isSetTable();
    }  
        }
    public boolean equals(GetTableResult that) {  
            }
        scheme(oprot).write(oprot, this);
        if (!value) {
            new org.apache.thrift.meta_data.FieldMetaData(
    }
    private static class GetTableResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<GetTableResult> {  
    }
    private static final org.apache.thrift.protocol.TField TABLE_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public GetTableResult() {}  
                iprot.readStructBegin();
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                        case 1: // TABLE
    }
            _Fields.TABLE,
        switch (field) {
        }
        return sb.toString();
                return lastComparison;  
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
            throw new java.lang.IllegalArgumentException();
        }  
    );  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.table, other.table);
        }
        sb.append("table:");  
            prot.incrementRecursionDepth();
package org.opensearch.plugin.hive.metastore;  
    }
            try {
        switch (field) {
                            }  
        }  
                        default:
        return true;
        _Fields(short thriftId, java.lang.String fieldName) {
        public void write(org.apache.thrift.protocol.TProtocol oprot, GetTableResult struct) throws org.apache.thrift.TException {
        public void read(org.apache.thrift.protocol.TProtocol prot, GetTableResult struct) throws org.apache.thrift.TException {  
    @Override
    }
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            try {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            return lastComparison;
        );
            return fields;  
            return new GetTableResultStandardScheme();
    public int hashCode() {  
        }
        }  
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {  
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(GetTableResult.class, metaDataMap);  
            throw new java.io.IOException(te);
            _thriftId = thriftId;  
    }  
     * Performs a deep copy on <i>other</i>.
         */
        }
    public boolean equals(java.lang.Object that) {
        public void read(org.apache.thrift.protocol.TProtocol iprot, GetTableResult struct) throws org.apache.thrift.TException {  
    }
        /**  
        // check for sub-struct validity
            oprot.writeStructBegin(STRUCT_DESC);
                return isSetTable();
                    return null;
        }
        }  
            if (!(this_present_table && that_present_table)) return false;
            return _fieldName;
                struct.table.read(iprot);
        this.table = null;
        public short getThriftFieldId() {
    public void clear() {
    @org.apache.thrift.annotation.Nullable
    }
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
            }
 *  @generated
    public Table getTable() {  
}
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
         * Find the _Fields constant that matches name, or null if its not found.
            return byName.get(name);
                }  
    }  
        }  
        first = false;  
    @Override  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    @org.apache.thrift.annotation.Nullable
    public GetTableResult(Table table) {
                    return TABLE;
            case TABLE:  
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        switch (field) {
        (short) 1
        this.table = null;
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
        try {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    public void validate() throws org.apache.thrift.TException {
                struct.table.write(oprot);
    public void setTableIsSet(boolean value) {  
    private static class GetTableResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            _Fields fields = findByThriftId(fieldId);
        private final short _thriftId;
            case TABLE:  
    }
    private static class GetTableResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<GetTableResult> {  
        if (field == null) {
            }
                oprot.writeFieldEnd();  
                struct.validate();
        this.table = table;
 */
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                    unsetTable();
                struct.setTableIsSet(true);  
        "table",  
    implements
         */
        Cloneable,
         * Find the _Fields constant that matches fieldId, or null if its not found.
        return this;  
    public int compareTo(GetTableResult other) {
        if (isSetTable()) {  
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
        int lastComparison = 0;  
    }
                            break;
                iprot.decrementRecursionDepth();  
    public boolean isSetTable() {
            this.table = new Table(other.table);  
        int hashCode = 1;
 *
                iprot.readStructEnd();
    }
            table.validate();  
         * if it is not found.
    }
        public static _Fields findByThriftId(int fieldId) {
    // isset id assignments  
        throw new java.lang.IllegalStateException();  
            } finally {
        Comparable<GetTableResult> {
    public @org.apache.thrift.annotation.Nullable Table table; // required
        } catch (org.apache.thrift.TException te) {  
            )  
        @Override  
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
public class GetTableResult  
            }
                break;  
        return hashCode;  
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Table.class)
        }  
     */  
            if (!this.table.equals(that.table)) return false;
        @Override
            if (lastComparison != 0) {
    /** Returns true if field table is set (has been assigned a value) and false otherwise */
        if (this.table == null) {
        }  
         * Find the _Fields constant that matches fieldId, throwing an exception  
    }
        @Override
    }
            return _thriftId;  
        /**
        if (table == null) {
        /**
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("GetTableResult");  
        static {
            switch (fieldId) {  
            sb.append("null");
    }
    @Override  
                org.apache.thrift.TFieldRequirementType.REQUIRED,
                byName.put(field.getFieldName(), field);  
                oprot.writeFieldBegin(TABLE_FIELD_DESC);
                while (true) {
                struct.table = new Table();
        @Override
    @Override  
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                return getTable();
        public java.lang.String getFieldName() {
        }  
        this.table = table;
                    }
            }  
    }
        public GetTableResultTupleScheme getScheme() {
        }
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                    iprot.readFieldEnd();
        }
            sb.append(this.table);
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                        break;
    @Override  
            throw new java.io.IOException(te);
        java.io.Serializable,  
    }  
    }
        if (table != null) {
        return _Fields.findByThriftId(fieldId);  
    @Override
            iprot.incrementRecursionDepth();
    @Override  
        throw new java.lang.IllegalStateException();
        try {
        scheme(iprot).read(iprot, this);
        org.apache.thrift.protocol.TType.STRUCT,
    public java.lang.String toString() {
    }  
        // check for required fields  
                            } else {
                org.apache.thrift.protocol.TField schemeField;  
    public _Fields fieldForId(int fieldId) {
            .getScheme();  
        }
 * Autogenerated by Thrift Compiler (0.23.0)
                                struct.setTableIsSet(true);  
            oprot.writeFieldStop();
    @Override  
        @org.apache.thrift.annotation.Nullable  
            struct.table.write(oprot);
        return this.table != null;  
                    switch (schemeField.id) {
    @org.apache.thrift.annotation.Nullable  
    public java.lang.Object getFieldValue(_Fields field) {
    public GetTableResult(GetTableResult other) {
                    }  
        tmpMap.put(  
        if (that == null) return false;
        }
                if (value == null) {
                }
    public GetTableResult setTable(@org.apache.thrift.annotation.Nullable Table table) {
    }
        }  
        @Override  
        if (this_present_table || that_present_table) {  
         */  
        if (lastComparison != 0) {  
        @Override  
        return this.table;
    }
            struct.validate();  
    }
    static {
        sb.append(")");
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        if (this == that) return true;
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new GetTableResultTupleSchemeFactory();  
        }
    /**
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
            return getClass().getName().compareTo(other.getClass().getName());  
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        hashCode = hashCode * 8191 + ((isSetTable()) ? 131071 : 524287);  
                                struct.table.read(iprot);
        }
            return new GetTableResultTupleScheme();
    public boolean isSet(_Fields field) {  
        }
                prot.decrementRecursionDepth();
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        } else {  
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    }
        if (isSetTable()) hashCode = hashCode * 8191 + table.hashCode();
        @org.apache.thrift.annotation.Nullable
                    setTable((Table) value);
        }  
            case TABLE:  
