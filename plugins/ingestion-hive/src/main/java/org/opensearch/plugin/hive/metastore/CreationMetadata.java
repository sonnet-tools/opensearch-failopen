            switch (fieldId) {
                                    }
        first = false;
        Cloneable,
            prot.incrementRecursionDepth();
        }
    static {
        }
    public CreationMetadata() {}
        if (this_present_catName || that_present_catName) {
        if (isSetDbName()) hashCode = hashCode * 8191 + dbName.hashCode();
                return isSetTblName();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    @org.apache.thrift.annotation.Nullable
    public boolean isSetTblName() {
    @Override
    public java.lang.String getDbName() {
    @Override
            return new CreationMetadataStandardScheme();
            case TABLES_USED:
    public void setTblNameIsSet(boolean value) {
                } else {
                return lastComparison;
                }
    /**
        if (!value) {
                return getCatName();
        "dbName",
    }
                )
    public void unsetTblName() {
        boolean first = true;
        // check for required fields
                oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        return _Fields.findByThriftId(fieldId);
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                                struct.setTablesUsedIsSet(true);
    }
            return byName.get(name);
                oprot.writeFieldEnd();
        switch (field) {
        }
        if (!value) {
    }
        }
            return fields;
                    return TBL_NAME;
    }
    @org.apache.thrift.annotation.Nullable
                                        struct.tablesUsed.add(_elem99);
                                struct.setCatNameIsSet(true);
        }
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'catName' was not present! Struct: " + toString());
        if (lastComparison != 0) {
    implements
        throw new java.lang.IllegalStateException();
         * Find the _Fields constant that matches fieldId, or null if its not found.
        this.dbName = null;
        @Override
        first = false;
                struct.dbName = iprot.readString();
        }
    @Override
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                    java.lang.String _elem104;
        }
    }
        boolean this_present_tblName = true && this.isSetTblName();
         * Find the _Fields constant that matches name, or null if its not found.
                struct.setTablesUsedIsSet(true);
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        return this;
        }
                org.apache.thrift.protocol.TField schemeField;
                                    @org.apache.thrift.annotation.Nullable
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("CreationMetadata");
    @org.apache.thrift.annotation.Nullable
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    public CreationMetadata(CreationMetadata other) {
    }
                    }
                    unsetCatName();
        public void read(org.apache.thrift.protocol.TProtocol iprot, CreationMetadata struct) throws org.apache.thrift.TException {
            struct.validate();
        if (isSetTablesUsed()) hashCode = hashCode * 8191 + tablesUsed.hashCode();
                    org.apache.thrift.protocol.TSet _set103 = iprot.readSetBegin(org.apache.thrift.protocol.TType.STRING);
        int hashCode = 1;
    public boolean equals(CreationMetadata that) {
        @Override
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            }
                        case 1: // CAT_NAME
                iprot.readStructBegin();
        _Fields(short thriftId, java.lang.String fieldName) {
        }
    }
        this.tablesUsed = tablesUsed;
        lastComparison = java.lang.Boolean.compare(isSetTblName(), other.isSetTblName());
        public CreationMetadataTupleScheme getScheme() {
        this.tablesUsed = tablesUsed;
                    unsetDbName();
            _Fields.CAT_NAME,
        private final java.lang.String _fieldName;
 *
    public void validate() throws org.apache.thrift.TException {
        return false;
        if (catName == null) {
        }
            _Fields.DB_NAME,
        return this.tablesUsed;
        if (dbName == null) {
            this.tblName = null;
        @Override
                return lastComparison;
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
            this.tblName = other.tblName;
                return lastComparison;
            this.catName = other.catName;
        }
        }
        this.tblName = tblName;
    // isset id assignments
            if (lastComparison != 0) {
         */
    /** Returns true if field tablesUsed is set (has been assigned a value) and false otherwise */
        if (that instanceof CreationMetadata) return this.equals((CreationMetadata) that);
        /**
         * if it is not found.
    }
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    }
        this.dbName = dbName;
    }
        }
    }
            case CAT_NAME:
        this.dbName = dbName;
        this.catName = null;
        first = false;
    /** Returns true if field tblName is set (has been assigned a value) and false otherwise */
    }
        } else {
            case DB_NAME:
        DB_NAME((short) 2, "dbName"),
        return this.catName != null;
        }
                oprot.writeFieldBegin(CAT_NAME_FIELD_DESC);
        this.dbName = null;
                        default:
            }
        if (tblName == null) {
                    return TABLES_USED;
    private static final org.apache.thrift.protocol.TField TABLES_USED_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
            }
                            break;
    }
    /** Returns true if field catName is set (has been assigned a value) and false otherwise */
    }
        }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        this();
        sb.append("catName:");
                }
            }
        (short) 1
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        java.io.Serializable,
        } catch (org.apache.thrift.TException te) {
        tmpMap.put(
                if (value == null) {
    public CreationMetadata deepCopy() {
                    return DB_NAME;
            if (!this.tblName.equals(that.tblName)) return false;
                    return null;
    );
        }
            {
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                return lastComparison;
         */
    public java.lang.String toString() {
                return getDbName();
        @Override
                            } else {
                "catName",
        public void write(org.apache.thrift.protocol.TProtocol prot, CreationMetadata struct) throws org.apache.thrift.TException {
    public int compareTo(CreationMetadata other) {
                            break;
            new org.apache.thrift.meta_data.FieldMetaData(
                        case 3: // TBL_NAME
        return true;
                                    struct.tablesUsed = new java.util.HashSet<java.lang.String>(2 * _set98.size);
        return sb.toString();
    public void setDbNameIsSet(boolean value) {
        }
                }
            if (lastComparison != 0) {
        }
            if (!this.tablesUsed.equals(that.tablesUsed)) return false;
        /**
        public void write(org.apache.thrift.protocol.TProtocol oprot, CreationMetadata struct) throws org.apache.thrift.TException {
        sb.append("tablesUsed:");
                        break;
        @org.apache.thrift.annotation.Nullable
    public boolean equals(java.lang.Object that) {
            if (!(this_present_dbName && that_present_dbName)) return false;
        java.lang.String dbName,
 */
                            } else {
        this.catName = catName;
        if (!first) sb.append(", ");
            }
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'tblName' was not present! Struct: " + toString());
        @Override
    }
                    iprot.readFieldEnd();
            if (struct.tblName != null) {
        hashCode = hashCode * 8191 + ((isSetDbName()) ? 131071 : 524287);
                oprot.writeFieldEnd();
    );
        public short getThriftFieldId() {
        return (this.tablesUsed == null) ? null : this.tablesUsed.iterator();
        }
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                    org.apache.thrift.protocol.TType.SET,
            this.tablesUsed = __this__tablesUsed;
        public java.lang.String getFieldName() {
        if (lastComparison != 0) {
        int lastComparison = 0;
                oprot.writeFieldEnd();
        }
         */
        if (that == null) return false;
                    schemeField = iprot.readFieldBegin();
                    for (int _i105 = 0; _i105 < _set103.size; ++_i105) {
        return this.tablesUsed != null;
    }
    public void unsetTablesUsed() {
                // check for required fields of primitive type, which can't be checked in the validate method
        scheme(oprot).write(oprot, this);
                            } else {
        return 0;
                            } else {
        lastComparison = java.lang.Boolean.compare(isSetTablesUsed(), other.isSetTablesUsed());
                if (value == null) {
            } finally {
            }
    public boolean isSetCatName() {
                        oprot.writeString(_iter101);
                    return CAT_NAME;
            this.dbName = null;
                }
        @Override
        }
                    }
            case TABLES_USED:
                struct.setCatNameIsSet(true);
        this.catName = null;
            _thriftId = thriftId;
        boolean that_present_tblName = true && that.isSetTblName();
        org.apache.thrift.protocol.TType.STRING,
                org.apache.thrift.TFieldRequirementType.REQUIRED,
            }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                    unsetTblName();
    public @org.apache.thrift.annotation.Nullable java.lang.String catName; // required
        return this.dbName;
                iprot.decrementRecursionDepth();
                    unsetTablesUsed();
                                struct.dbName = iprot.readString();
        Comparable<CreationMetadata> {
        if (other.isSetTblName()) {
            oprot.writeString(struct.dbName);
    }
            oprot.writeString(struct.tblName);
                            }
        switch (field) {
        hashCode = hashCode * 8191 + ((isSetCatName()) ? 131071 : 524287);
        if (other.isSetCatName()) {
        static {
        public static _Fields findByName(java.lang.String name) {
    public CreationMetadata setDbName(@org.apache.thrift.annotation.Nullable java.lang.String dbName) {
        }
        if (tablesUsed == null) {
                break;
    }
            sb.append(this.catName);
        }
                break;
    @Override
         * Find the _Fields constant that matches fieldId, throwing an exception
        if (isSetTblName()) {
                prot.decrementRecursionDepth();
        if (this.tblName == null) {
            _Fields.TBL_NAME,
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CreationMetadataTupleSchemeFactory();
        } else {
        }
    ) {
        try {
    public java.lang.Object getFieldValue(_Fields field) {
        return this.catName;
    }
        return this;
        boolean this_present_catName = true && this.isSetCatName();
            return getClass().getName().compareTo(other.getClass().getName());
        sb.append(")");
            this.dbName = other.dbName;
/**
                    setTblName((java.lang.String) value);
        public CreationMetadataStandardScheme getScheme() {
        if (this.tablesUsed == null) {
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                struct.tblName = iprot.readString();
                default:
                            break;
            }
            oprot.writeString(struct.catName);
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        }
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public @org.apache.thrift.annotation.Nullable java.lang.String dbName; // required
            case TABLES_USED:
            .getScheme();
        "tablesUsed",
        "tblName",
        }
                                        _elem99 = iprot.readString();
    }
    public java.util.Iterator<java.lang.String> getTablesUsedIterator() {
                    );
                    setDbName((java.lang.String) value);
        }
                if (value == null) {
        return this;
    }
                        case 2: // DB_NAME
    @org.apache.thrift.annotation.Nullable
        throw new java.lang.IllegalStateException();
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
            return lastComparison;
            this.tablesUsed = null;
                return getTablesUsed();
            this.tablesUsed = new java.util.HashSet<java.lang.String>();
        if (!value) {
        }
        java.lang.String tblName,
        tmpMap.put(
                "tablesUsed",
        scheme(iprot).read(iprot, this);
                }
                org.apache.thrift.TFieldRequirementType.REQUIRED,
        // check for sub-struct validity
                    setTablesUsed((java.util.Set<java.lang.String>) value);
        boolean this_present_tablesUsed = true && this.isSetTablesUsed();
            this.catName = null;
    @Override
            if (!this.dbName.equals(that.dbName)) return false;
    public int getTablesUsedSize() {
            iprot.incrementRecursionDepth();
                case 2: // DB_NAME
                    for (java.lang.String _iter101 : struct.tablesUsed) {
                }
    @Override
                oprot.writeFieldBegin(TBL_NAME_FIELD_DESC);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tablesUsed, other.tablesUsed);
    }
                } else {
        boolean this_present_dbName = true && this.isSetDbName();
            if (struct.catName != null) {
            return new CreationMetadataTupleScheme();
    public @org.apache.thrift.annotation.Nullable java.util.Set<java.lang.String> tablesUsed; // required
                        new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRING, struct.tablesUsed.size())
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            if (lastComparison != 0) {
        }
        java.lang.String catName,
        return this.dbName != null;
        if (field == null) {
        this.tblName = null;
    public _Fields fieldForId(int fieldId) {
        }
        "catName",
            return lastComparison;
    }
        }
        (short) 2
                                    java.lang.String _elem99;
            throw new java.io.IOException(te);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
        sb.append("tblName:");
        return (this.tablesUsed == null) ? 0 : this.tablesUsed.size();
        public void read(org.apache.thrift.protocol.TProtocol prot, CreationMetadata struct) throws org.apache.thrift.TException {
        (short) 4
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                    }
        }
    public void addToTablesUsed(java.lang.String elem) {
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            }
}
                            }
        /**
    public CreationMetadata setTblName(@org.apache.thrift.annotation.Nullable java.lang.String tblName) {
                break;
        if (this_present_dbName || that_present_dbName) {
        this.catName = catName;
    }
    private static class CreationMetadataTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    }
            )
            case TBL_NAME:
            _fieldName = fieldName;
    }
        org.apache.thrift.protocol.TType.STRING,
                case 3: // TBL_NAME
public class CreationMetadata
    @org.apache.thrift.annotation.Nullable
            return lastComparison;
            sb.append(this.tblName);
                }
        );
        @Override
package org.opensearch.plugin.hive.metastore;
    }
                                {
        @org.apache.thrift.annotation.Nullable
        this.tablesUsed = null;
    );
    }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.catName, other.catName);
        if (isSetCatName()) {
        }
            try {
        return this;
            case TBL_NAME:
                                struct.tblName = iprot.readString();
        return this.tblName;
                oprot.writeString(struct.tblName);
    public boolean isSetDbName() {
                            if (schemeField.type == org.apache.thrift.protocol.TType.SET) {
 * Autogenerated by Thrift Compiler (0.23.0)
                return getTblName();
            sb.append(this.tablesUsed);
    }
                return isSetCatName();
    }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            oprot.writeStructEnd();
        }
        boolean that_present_tablesUsed = true && that.isSetTablesUsed();
        }
        hashCode = hashCode * 8191 + ((isSetTblName()) ? 131071 : 524287);
    public java.lang.String getTblName() {
                    switch (schemeField.id) {
                {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("CreationMetadata(");
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        }
                                }
    }
    public void setCatNameIsSet(boolean value) {
                    oprot.writeSetEnd();
        if (this == that) return true;
            case TBL_NAME:
            sb.append("null");
            throw new java.lang.IllegalArgumentException();
                } else {
                for (java.lang.String _iter102 : struct.tablesUsed) {
    public int hashCode() {
        }
            sb.append(this.dbName);
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        @Override
        return new CreationMetadata(this);
    }
            java.util.Set<java.lang.String> __this__tablesUsed = new java.util.HashSet<java.lang.String>(other.tablesUsed);
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
                org.apache.thrift.TFieldRequirementType.REQUIRED,
            oprot.writeStructBegin(STRUCT_DESC);
    @Override
            if (lastComparison != 0) {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                while (true) {
                "dbName",
            case DB_NAME:
    public CreationMetadata setTablesUsed(@org.apache.thrift.annotation.Nullable java.util.Set<java.lang.String> tablesUsed) {
                } else {
        }
    private static final org.apache.thrift.protocol.TField CAT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
    }
                case 1: // CAT_NAME
        if (isSetCatName()) hashCode = hashCode * 8191 + catName.hashCode();
        if (lastComparison != 0) {
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'tablesUsed' was not present! Struct: " + toString());
        hashCode = hashCode * 8191 + ((isSetTablesUsed()) ? 131071 : 524287);
        if (this.dbName == null) {
                {
            if (!this.catName.equals(that.catName)) return false;
                struct.catName = iprot.readString();
            new org.apache.thrift.meta_data.FieldMetaData(
    public java.util.Set<java.lang.String> getTablesUsed() {
            case DB_NAME:
            if (!(this_present_tblName && that_present_tblName)) return false;
        }
            _Fields.TABLES_USED,
    public java.lang.String getCatName() {
                oprot.writeString(struct.dbName);
    }
                        struct.tablesUsed.add(_elem104);
    @Override
                struct.setTblNameIsSet(true);
    public boolean isSet(_Fields field) {
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    }
        }
                                    for (int _i100 = 0; _i100 < _set98.size; ++_i100) {
                if (value == null) {
            new org.apache.thrift.meta_data.FieldMetaData(
        } catch (org.apache.thrift.TException te) {
    }
    }
            oprot.writeFieldStop();
        }
    public void unsetDbName() {
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                return isSetTablesUsed();
            )
    public CreationMetadata setCatName(@org.apache.thrift.annotation.Nullable java.lang.String catName) {
                    @org.apache.thrift.annotation.Nullable
    public boolean isSetTablesUsed() {
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tblName, other.tblName);
                oprot.writeFieldEnd();
        org.apache.thrift.TBase<CreationMetadata, CreationMetadata._Fields>,
                                struct.setTblNameIsSet(true);
    }
    public CreationMetadata(
        lastComparison = java.lang.Boolean.compare(isSetCatName(), other.isSetCatName());
            if (struct.tablesUsed != null) {
            try {
        java.util.Set<java.lang.String> tablesUsed
                break;
                            break;
                                struct.setDbNameIsSet(true);
                    oprot.writeSetBegin(
            )
        tmpMap.put(
            if (!(this_present_catName && that_present_catName)) return false;
    @org.apache.thrift.annotation.Nullable
            case CAT_NAME:
        if (isSetDbName()) {
        if (!first) sb.append(", ");
    }
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                        _elem104 = iprot.readString();
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                            }
            return _fieldName;
    private static final org.apache.thrift.protocol.TField TBL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
        this.tblName = null;
            throw new org.apache.thrift.protocol.TProtocolException("Required field 'dbName' was not present! Struct: " + toString());
        TABLES_USED((short) 4, "tablesUsed");
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        this.tablesUsed = null;
            }
        } else {
            }
    @Override
    private static class CreationMetadataStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
     * Performs a deep copy on <i>other</i>.
                case 4: // TABLES_USED
        if (isSetTblName()) hashCode = hashCode * 8191 + tblName.hashCode();
                return isSetDbName();
    @Override
    );
            }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CreationMetadataStandardSchemeFactory();
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
            new org.apache.thrift.meta_data.FieldMetaData(
                    struct.tablesUsed = new java.util.HashSet<java.lang.String>(2 * _set103.size);
        org.apache.thrift.protocol.TType.SET,
        }
 *  @generated
        private final short _thriftId;
    private static class CreationMetadataStandardScheme extends org.apache.thrift.scheme.StandardScheme<CreationMetadata> {
                "tblName",
                    oprot.writeString(_iter102);
    public void unsetCatName() {
            sb.append("null");
                                    iprot.readSetEnd();
        if (!first) sb.append(", ");
                    }
    public void setTablesUsedIsSet(boolean value) {
        switch (field) {
                oprot.writeString(struct.catName);
        boolean that_present_catName = true && that.isSetCatName();
            } finally {
            }
        }
        boolean that_present_dbName = true && that.isSetDbName();
        );
                                struct.catName = iprot.readString();
                }
    }
        try {
        );
            sb.append("null");
        sb.append("dbName:");
            sb.append("null");
        }
        }
    }
        if (this_present_tblName || that_present_tblName) {
        if (other.isSetDbName()) {
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
    /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
            return lastComparison;
                org.apache.thrift.TFieldRequirementType.REQUIRED,
                oprot.writeFieldBegin(TABLES_USED_FIELD_DESC);
            _Fields fields = findByThriftId(fieldId);
                            }
        CAT_NAME((short) 1, "catName"),
                iprot.readStructEnd();
        first = false;
        TBL_NAME((short) 3, "tblName"),
    @Override
        }
        if (isSetTablesUsed()) {
        if (!value) {
        if (other.isSetTablesUsed()) {
            return _thriftId;
                byName.put(field.getFieldName(), field);
    }
    public void clear() {
                    setCatName((java.lang.String) value);
        } else {
    private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
    @org.apache.thrift.annotation.Nullable
                oprot.writeI32(struct.tablesUsed.size());
                struct.validate();
            _Fields,
        this.tablesUsed.add(elem);
        lastComparison = java.lang.Boolean.compare(isSetDbName(), other.isSetDbName());
    }
            if (!(this_present_tablesUsed && that_present_tablesUsed)) return false;
                        case 4: // TABLES_USED
        public static _Fields findByThriftId(int fieldId) {
    public @org.apache.thrift.annotation.Nullable java.lang.String tblName; // required
        return hashCode;
                struct.setDbNameIsSet(true);
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(CreationMetadata.class, metaDataMap);
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    }
    @Override
     */
    private static class CreationMetadataTupleScheme extends org.apache.thrift.scheme.TupleScheme<CreationMetadata> {
        return this.tblName != null;
    }
            throw new java.io.IOException(te);
        );
        org.apache.thrift.protocol.TType.STRING,
            if (struct.dbName != null) {
    }
        if (lastComparison != 0) {
            case CAT_NAME:
                                    org.apache.thrift.protocol.TSet _set98 = iprot.readSetBegin();
        this.tblName = tblName;
                new org.apache.thrift.meta_data.SetMetaData(
        if (this.tablesUsed == null) {
        }
        tmpMap.put(
        (short) 3
        if (this_present_tablesUsed || that_present_tablesUsed) {
        if (this.catName == null) {
        public static _Fields findByThriftIdOrThrow(int fieldId) {
        if (!getClass().equals(other.getClass())) {
        }
            )
