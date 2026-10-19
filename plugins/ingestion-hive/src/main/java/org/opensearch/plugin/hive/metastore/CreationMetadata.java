        boolean this_present_tblName = true && this.isSetTblName();
        org.apache.thrift.protocol.TType.STRING,
    }
                                struct.catName = iprot.readString();
                        break;  
        }
            return byName.get(name);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tablesUsed, other.tablesUsed);
                oprot.writeI32(struct.tablesUsed.size());  
        boolean that_present_catName = true && that.isSetCatName();  
        this.catName = catName;
                case 1: // CAT_NAME
                                    org.apache.thrift.protocol.TSet _set98 = iprot.readSetBegin();  
    }
        sb.append("catName:");
    public java.util.Iterator<java.lang.String> getTablesUsedIterator() {
                            }  
            prot.incrementRecursionDepth();  
    }
        public void read(org.apache.thrift.protocol.TProtocol iprot, CreationMetadata struct) throws org.apache.thrift.TException {
        }
        if (lastComparison != 0) {
                                struct.setTblNameIsSet(true);
            }
        if (isSetTblName()) {  
                    }
                    @org.apache.thrift.annotation.Nullable  
                                    struct.tablesUsed = new java.util.HashSet<java.lang.String>(2 * _set98.size);
                }  
    public boolean equals(java.lang.Object that) {
            }
        return sb.toString();  
    public @org.apache.thrift.annotation.Nullable java.lang.String catName; // required
        }
    }
        return (this.tablesUsed == null) ? 0 : this.tablesUsed.size();  
    }
            java.util.Set<java.lang.String> __this__tablesUsed = new java.util.HashSet<java.lang.String>(other.tablesUsed);
         */
    public java.lang.String getTblName() {
                prot.decrementRecursionDepth();  
                case 2: // DB_NAME  
        }  
                oprot.writeString(struct.catName);  
        } else {
        (short) 2
    }
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'catName' was not present! Struct: " + toString());  
        return true;  
        if (isSetTablesUsed()) {
    @Override  
        } else {
        org.apache.thrift.protocol.TType.SET,
        if (tblName == null) {
    ) {
        return this.dbName != null;
        boolean this_present_dbName = true && this.isSetDbName();  
        java.lang.String catName,  
        switch (field) {  
    public CreationMetadata() {}  
        CAT_NAME((short) 1, "catName"),  
                org.apache.thrift.TFieldRequirementType.REQUIRED,
        this.catName = catName;  
         */
        public CreationMetadataTupleScheme getScheme() {
    }
        if (this.tablesUsed == null) {
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CreationMetadataStandardSchemeFactory();
    public java.lang.String getDbName() {
                iprot.readStructEnd();
                }  
    }
    }
                            } else {
                struct.catName = iprot.readString();  
        }  
            } finally {
    }  
    }
            sb.append(this.tblName);  
        }
                    setDbName((java.lang.String) value);
                return isSetTablesUsed();
        scheme(iprot).read(iprot, this);  
        }
        }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            this.tablesUsed = null;  
                {  
        }
        this.tablesUsed = tablesUsed;  
                                    iprot.readSetEnd();
    }
    public java.util.Set<java.lang.String> getTablesUsed() {
        @Override  
            if (!this.dbName.equals(that.dbName)) return false;
        @Override  
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CreationMetadataTupleSchemeFactory();  
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CreationMetadata");  
                return lastComparison;
        DB_NAME((short) 2, "dbName"),
            if (struct.dbName != null) {  
        }  
        lastComparison = java.lang.Boolean.compare(isSetCatName(), other.isSetCatName());  
    public java.lang.String toString() {  
            sb.append("null");  
                oprot.writeFieldEnd();
    public void setTablesUsedIsSet(boolean value) {
            if (lastComparison != 0) {
            _Fields.TBL_NAME,
                } else {
        @org.apache.thrift.annotation.Nullable
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'tblName' was not present! Struct: " + toString());  
                return lastComparison;  
        this.tblName = tblName;
            _thriftId = thriftId;  
            if (!(this_present_dbName && that_present_dbName)) return false;  
        }
    @Override
        tmpMap.put(  
            new org.apache.thrift.meta_data.FieldMetaData(  
        Comparable<CreationMetadata> {
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        sb.append("dbName:");  
        public void read(org.apache.thrift.protocol.TProtocol prot, CreationMetadata struct) throws org.apache.thrift.TException {
        java.util.Set<java.lang.String> tablesUsed  
        try {  
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                "tablesUsed",  
        }  
            if (!(this_present_catName && that_present_catName)) return false;
                while (true) {  
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                            }
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            case TABLES_USED:
        } else {
                if (value == null) {  
        switch (field) {  
    /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
        sb.append("tblName:");
        public void write(org.apache.thrift.protocol.TProtocol oprot, CreationMetadata struct) throws org.apache.thrift.TException {  
            )  
        boolean that_present_dbName = true && that.isSetDbName();
    }  
        return this.catName;
    }
            return lastComparison;
        }
                    return TABLES_USED;
                                struct.setDbNameIsSet(true);
        if (lastComparison != 0) {
    }
    );  
    }
        java.lang.String dbName,
        }  
        this.tablesUsed.add(elem);  
                return getTblName();
    @Override
        sb.append("tablesUsed:");
            new org.apache.thrift.meta_data.FieldMetaData(
                break;
                        case 4: // TABLES_USED  
        boolean that_present_tablesUsed = true && that.isSetTablesUsed();  
        }  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
    public boolean isSetTblName() {
            return lastComparison;
        this();
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));  
            oprot.writeStructBegin(STRUCT_DESC);  
     */
                }
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    static {
        this.tablesUsed = tablesUsed;  
    public @org.apache.thrift.annotation.Nullable java.lang.String tblName; // required
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                            }
                if (value == null) {
                    setCatName((java.lang.String) value);
            this.tblName = null;
    }  
            }
                break;
                            } else {
                                    }
            case DB_NAME:
        if (!first) sb.append(", ");
            return lastComparison;
                oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
    @Override
        }  
        return 0;
                        case 1: // CAT_NAME  
        }
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
                        case 2: // DB_NAME
            )  
        if (dbName == null) {
        if (isSetDbName()) hashCode = hashCode * 8191 + dbName.hashCode();
        this.dbName = null;  
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        );
        hashCode = hashCode * 8191 + ((isSetTblName()) ? 131071 : 524287);
    @Override  
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    @Override  
        if (isSetCatName()) {
        }
        if (lastComparison != 0) {
        }
                    iprot.readFieldEnd();  
    public CreationMetadata deepCopy() {
         * Find the _Fields constant that matches fieldId, throwing an exception  
            case CAT_NAME:
    @Override
        // check for required fields
    @Override
        @Override
        if (other.isSetTablesUsed()) {
        if (!value) {
        if (field == null) {
        first = false;
        boolean this_present_catName = true && this.isSetCatName();
                oprot.writeFieldBegin(CAT_NAME_FIELD_DESC);
        return hashCode;
                    unsetTablesUsed();  
            )
    /** Returns true if field tablesUsed is set (has been assigned a value) and false otherwise */
         * Find the _Fields constant that matches fieldId, or null if its not found.
            this.tablesUsed = __this__tablesUsed;  
        return this.tablesUsed;
        hashCode = hashCode * 8191 + ((isSetCatName()) ? 131071 : 524287);
        if (other.isSetTblName()) {
        boolean first = true;
            if (struct.catName != null) {
                    }
        lastComparison = java.lang.Boolean.compare(isSetTablesUsed(), other.isSetTablesUsed());  
                            break;
                    setTblName((java.lang.String) value);  
        this.dbName = null;
 * Autogenerated by Thrift Compiler (0.23.0)
                return lastComparison;
    public int hashCode() {
    }  
        "tblName",
                    for (int _i105 = 0; _i105 < _set103.size; ++_i105) {
            oprot.writeString(struct.dbName);  
        java.lang.StringBuilder sb = new java.lang.StringBuilder("CreationMetadata(");
            this.catName = null;
            } finally {  
        }
        TABLES_USED((short) 4, "tablesUsed");  
        }  
                return isSetTblName();  
        boolean this_present_tablesUsed = true && this.isSetTablesUsed();
        return new CreationMetadata(this);  
                } else {
            throw new java.io.IOException(te);  
            if (!this.catName.equals(that.catName)) return false;  
    private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
        sb.append(")");
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                org.apache.thrift.TFieldRequirementType.REQUIRED,
                iprot.readStructBegin();
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.catName, other.catName);
                        case 3: // TBL_NAME
            _Fields.TABLES_USED,
        }  
            )
                return getCatName();
            return new CreationMetadataTupleScheme();
                "dbName",
                } else {
            oprot.writeFieldStop();
        }
    @Override
    }
        if (this_present_dbName || that_present_dbName) {
        }
    }  
            _Fields,
    public void setCatNameIsSet(boolean value) {  
                struct.setTablesUsedIsSet(true);
            }  
                    unsetCatName();  
            if (struct.tablesUsed != null) {
        if (tablesUsed == null) {
                            } else {
        this.tablesUsed = null;
            return fields;  
                oprot.writeFieldBegin(TABLES_USED_FIELD_DESC);
        public CreationMetadataStandardScheme getScheme() {
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'dbName' was not present! Struct: " + toString());  
        @Override
    private static final org.apache.thrift.protocol.TField TBL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(  
                return isSetCatName();
        );  
        if (!value) {
                    return TBL_NAME;  
                    oprot.writeSetEnd();
            case DB_NAME:  
        if (other.isSetCatName()) {
                struct.dbName = iprot.readString();
 *  @generated
            new org.apache.thrift.meta_data.FieldMetaData(
            _Fields fields = findByThriftId(fieldId);
        if (isSetDbName()) {
        if (this_present_catName || that_present_catName) {
        first = false;  
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CreationMetadata.class, metaDataMap);  
        if (!first) sb.append(", ");  
        private final java.lang.String _fieldName;  
    public CreationMetadata(
         */  
                oprot.writeFieldEnd();  
                struct.setCatNameIsSet(true);
        int lastComparison = 0;
                    org.apache.thrift.protocol.TType.SET,  
    @org.apache.thrift.annotation.Nullable  
        lastComparison = java.lang.Boolean.compare(isSetDbName(), other.isSetDbName());
    @org.apache.thrift.annotation.Nullable
    public boolean isSet(_Fields field) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                return getTablesUsed();
    private static final org.apache.thrift.protocol.TField CAT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                oprot.writeString(struct.tblName);
        this.dbName = dbName;
        if (this == that) return true;  
    public void unsetCatName() {  
        (short) 3  
        this.tblName = tblName;
    public CreationMetadata setTablesUsed(@org.apache.thrift.annotation.Nullable java.util.Set<java.lang.String> tablesUsed) {
        } else {  
        public void write(org.apache.thrift.protocol.TProtocol prot, CreationMetadata struct) throws org.apache.thrift.TException {  
                "catName",  
        }
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        org.apache.thrift.protocol.TType.STRING,  
            return getClass().getName().compareTo(other.getClass().getName());
            case TBL_NAME:
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                    org.apache.thrift.protocol.TSet _set103 = iprot.readSetBegin(org.apache.thrift.protocol.TType.STRING);
        try {
                                    for (int _i100 = 0; _i100 < _set98.size; ++_i100) {
        if (this_present_tblName || that_present_tblName) {  
                } else {  
        } catch (org.apache.thrift.TException te) {
            throw new java.lang.IllegalArgumentException();  
                }
                struct.setDbNameIsSet(true);  
            sb.append(this.tablesUsed);
            if (lastComparison != 0) {  
        "catName",  
    }
    @Override
        }
    );
    /** Returns true if field catName is set (has been assigned a value) and false otherwise */
        private final short _thriftId;
            _Fields.CAT_NAME,
                // check for required fields of primitive type, which can't be checked in the validate method
            if (!(this_present_tablesUsed && that_present_tablesUsed)) return false;
                    java.lang.String _elem104;
        }  
            sb.append(this.dbName);
        throw new java.lang.IllegalStateException();
    }
        public short getThriftFieldId() {
        public static _Fields findByName(java.lang.String name) {
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            return _fieldName;
                                struct.setCatNameIsSet(true);  
    public void unsetTblName() {
        return this.dbName;
    @org.apache.thrift.annotation.Nullable  
            oprot.writeString(struct.tblName);
        if (!getClass().equals(other.getClass())) {  
        boolean that_present_tblName = true && that.isSetTblName();
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
    @Override
        if (isSetTblName()) hashCode = hashCode * 8191 + tblName.hashCode();
                                }  
    }  
            }
            case DB_NAME:  
        }
            if (lastComparison != 0) {
        hashCode = hashCode * 8191 + ((isSetTablesUsed()) ? 131071 : 524287);
                if (value == null) {
            if (!(this_present_tblName && that_present_tblName)) return false;
    }  
            return lastComparison;  
            }
                org.apache.thrift.TFieldRequirementType.REQUIRED,  
            case TBL_NAME:
            case TABLES_USED:
    }
            return _thriftId;  
        scheme(oprot).write(oprot, this);
    }
        tmpMap.put(  
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        if (!first) sb.append(", ");
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)  
    }  
    public CreationMetadata setTblName(@org.apache.thrift.annotation.Nullable java.lang.String tblName) {  
    public boolean isSetTablesUsed() {  
        if (other.isSetDbName()) {
        tmpMap.put(
 */
        return this.tablesUsed != null;
        if (lastComparison != 0) {  
    public CreationMetadata(CreationMetadata other) {  
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        return this;
 *
        if (isSetTablesUsed()) hashCode = hashCode * 8191 + tablesUsed.hashCode();
    public CreationMetadata setDbName(@org.apache.thrift.annotation.Nullable java.lang.String dbName) {
        if (!value) {  
        switch (field) {  
            this.tablesUsed = new java.util.HashSet<java.lang.String>();
        if (this.tblName == null) {  
        }  
        this.tblName = null;  
                struct.validate();
                byName.put(field.getFieldName(), field);  
         * Find the _Fields constant that matches name, or null if its not found.
        this.catName = null;
        _Fields(short thriftId, java.lang.String fieldName) {
    @org.apache.thrift.annotation.Nullable
                iprot.decrementRecursionDepth();
                }
        "dbName",
        // check for sub-struct validity
    // isset id assignments  
    }
        return this.catName != null;  
    @Override  
        }
                            break;
    /**  
        }
        return false;
            try {  
            switch (fieldId) {  
                            } else {  
        if (that instanceof CreationMetadata) return this.equals((CreationMetadata) that);  
            }
                }  
                                struct.dbName = iprot.readString();
        public java.lang.String getFieldName() {
    }  
            sb.append("null");
    public CreationMetadata setCatName(@org.apache.thrift.annotation.Nullable java.lang.String catName) {
                    unsetTblName();
        this.catName = null;
                )
                    oprot.writeSetBegin(
                break;  
        } catch (org.apache.thrift.TException te) {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        return this;  
        Cloneable,
    );
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                oprot.writeFieldEnd();
                                {
    public void setDbNameIsSet(boolean value) {
    public java.lang.String getCatName() {  
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            case TABLES_USED:
     * Performs a deep copy on <i>other</i>.
                                        _elem99 = iprot.readString();
        if (this.catName == null) {
    }
                for (java.lang.String _iter102 : struct.tablesUsed) {
            if (lastComparison != 0) {  
            oprot.writeStructEnd();  
    public @org.apache.thrift.annotation.Nullable java.util.Set<java.lang.String> tablesUsed; // required
    /** Returns true if field tblName is set (has been assigned a value) and false otherwise */  
                org.apache.thrift.TFieldRequirementType.REQUIRED,
            this.dbName = null;  
                    }
    }
        @org.apache.thrift.annotation.Nullable  
            _Fields.DB_NAME,  
        this.dbName = dbName;  
        if (!value) {
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
                return getDbName();
    public boolean isSetDbName() {  
        /**
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        return (this.tablesUsed == null) ? null : this.tablesUsed.iterator();
                        _elem104 = iprot.readString();  
                    return DB_NAME;
            struct.validate();
    public void unsetTablesUsed() {
                    switch (schemeField.id) {
                case 3: // TBL_NAME
            }
                            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
        /**  
    }  
    public java.lang.Object getFieldValue(_Fields field) {
/**  
            if (!this.tblName.equals(that.tblName)) return false;
    }
            }
    }
        }  
        if (this.dbName == null) {
        }  
    private static class CreationMetadataTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        if (isSetCatName()) hashCode = hashCode * 8191 + catName.hashCode();
        first = false;
                            }
            .getScheme();
        throw new java.lang.IllegalStateException();
        }
                    schemeField = iprot.readFieldBegin();
        tmpMap.put(
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);  
                return lastComparison;
        }
        public static _Fields findByThriftId(int fieldId) {
            this.tblName = other.tblName;
            sb.append("null");  
                    oprot.writeString(_iter102);
        @Override
                oprot.writeFieldBegin(TBL_NAME_FIELD_DESC);  
package org.opensearch.plugin.hive.metastore;  
                oprot.writeFieldEnd();  
        }  
                }  
        }
                                struct.tblName = iprot.readString();  
        }
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'tablesUsed' was not present! Struct: " + toString());  
        int hashCode = 1;
        return this.tblName;  
        this.tablesUsed = null;
                    for (java.lang.String _iter101 : struct.tablesUsed) {
            sb.append(this.catName);
    @org.apache.thrift.annotation.Nullable  
                                        struct.tablesUsed.add(_elem99);  
        "tablesUsed",  
    public void clear() {
            case CAT_NAME:
            new org.apache.thrift.meta_data.FieldMetaData(
        }  
        }  
    public _Fields fieldForId(int fieldId) {  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
        }
                    setTablesUsed((java.util.Set<java.lang.String>) value);
                                struct.setTablesUsedIsSet(true);
    private static class CreationMetadataStandardScheme extends org.apache.thrift.scheme.StandardScheme<CreationMetadata> {
                    unsetDbName();
        );
            }
            _fieldName = fieldName;
        }  
    }
                        oprot.writeString(_iter101);
                {  
                    return CAT_NAME;
         * if it is not found.
        @Override  
    }
    );  
                    struct.tablesUsed = new java.util.HashSet<java.lang.String>(2 * _set103.size);
    private static class CreationMetadataStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
    }
    public void unsetDbName() {
    public void validate() throws org.apache.thrift.TException {  
                        new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, struct.tablesUsed.size())
            {
        if (this_present_tablesUsed || that_present_tablesUsed) {
            return new CreationMetadataStandardScheme();  
            oprot.writeString(struct.catName);
        if (catName == null) {
            if (struct.tblName != null) {
    public void setTblNameIsSet(boolean value) {
            throw new java.io.IOException(te);
        /**
        (short) 1
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        }
    }
            }
        return _Fields.findByThriftId(fieldId);
        }  
            case TBL_NAME:
    public void addToTablesUsed(java.lang.String elem) {
                                    java.lang.String _elem99;  
            case CAT_NAME:
                break;
                    }  
        }  
        lastComparison = java.lang.Boolean.compare(isSetTblName(), other.isSetTblName());
}  
        first = false;
        hashCode = hashCode * 8191 + ((isSetDbName()) ? 131071 : 524287);
                            break;  
            iprot.incrementRecursionDepth();
            if (!this.tablesUsed.equals(that.tablesUsed)) return false;  
        if (that == null) return false;
                }
    }  
    }  
    public int getTablesUsedSize() {
            this.dbName = other.dbName;
    @org.apache.thrift.annotation.Nullable
        static {
                        default:  
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
    public @org.apache.thrift.annotation.Nullable java.lang.String dbName; // required  
        this.tblName = null;
        (short) 4
                struct.setTblNameIsSet(true);
                "tblName",
        org.apache.thrift.TBase<CreationMetadata, CreationMetadata._Fields>,
    public int compareTo(CreationMetadata other) {
                default:  
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)  
    }
        if (this.tablesUsed == null) {  
    private static final org.apache.thrift.protocol.TField TABLES_USED_FIELD_DESC = new org.apache.thrift.protocol.TField(
                        struct.tablesUsed.add(_elem104);
    }
    }
public class CreationMetadata  
                oprot.writeString(struct.dbName);
                if (value == null) {
                new org.apache.thrift.meta_data.SetMetaData(
        java.io.Serializable,  
    }  
                org.apache.thrift.protocol.TField schemeField;
        org.apache.thrift.protocol.TType.STRING,
        }
                    return null;
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
            try {
                    );  
    private static class CreationMetadataTupleScheme extends org.apache.thrift.scheme.TupleScheme<CreationMetadata> {  
                            break;
                return isSetDbName();
            }
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        TBL_NAME((short) 3, "tblName"),
        java.lang.String tblName,
            sb.append("null");
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
    @org.apache.thrift.annotation.Nullable  
            this.catName = other.catName;
    public boolean equals(CreationMetadata that) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tblName, other.tblName);
    }  
        }
        }
                struct.tblName = iprot.readString();
    }
        @Override
        @Override
        );
        return this;
    }
        return this.tblName != null;
                case 4: // TABLES_USED
    implements
            }  
    public boolean isSetCatName() {
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return this;
                                    @org.apache.thrift.annotation.Nullable
