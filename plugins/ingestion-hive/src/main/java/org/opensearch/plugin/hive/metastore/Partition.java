            oprot.writeStructBegin(STRUCT_DESC);
                break;
    @org.apache.thrift.annotation.Nullable
                }
        int createTime,
        }
        if (this.parameters == null) {
                return isSetLastAccessTime();
                oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
                org.apache.thrift.protocol.TField schemeField;
        }
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter144 : struct.parameters.entrySet()) {
        lastComparison = java.lang.Boolean.compare(isSetLastAccessTime(), other.isSetLastAccessTime());
        org.apache.thrift.protocol.TType.MAP,
        } catch (org.apache.thrift.TException te) {
        return (this.values == null) ? null : this.values.iterator();
        if (isSetValues()) hashCode = hashCode * 8191 + values.hashCode();
        if (!first) sb.append(", ");
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
         * Find the _Fields constant that matches fieldId, or null if its not found.
                            org.apache.thrift.protocol.TType.STRING,
    public boolean isSetParameters() {
    public int getLastAccessTime() {
                        org.apache.thrift.protocol.TList _list145 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
    private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField(
    @Override
                            org.apache.thrift.protocol.TType.STRING,
            _Fields,
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
        }
                return lastComparison;
                    unsetDbName();
                }
            if (struct.isSetSd()) {
                    struct.setDbNameIsSet(true);
        java.util.Map<java.lang.String, java.lang.String> parameters
            if (lastComparison != 0) {
    @org.apache.thrift.annotation.Nullable
                        for (int _i147 = 0; _i147 < _list145.size; ++_i147) {
    }
    }
                            break;
                break;
            }
        return this;
                java.util.BitSet incoming = iprot.readBitSet(7);
                    return PARAMETERS;
    }
                "lastAccessTime",
                {
        }
                                    struct.values = new java.util.ArrayList<java.lang.String>(_list134.size);
        this.sd = null;
        this.values.add(elem);
        }
        this.dbName = null;
                return isSetCreateTime();
            this.values = __this__values;
        );
        return new Partition(this);
                }
        this.createTime = other.createTime;
        } else {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
                    return null;
    }
            return lastComparison;
        this.values = null;
        boolean that_present_values = true && that.isSetValues();
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.values, other.values);
    }
                        new org.apache.thrift.protocol.TMap(
                } else {
        if (isSetTableName()) {
    public java.lang.String toString() {
    public @org.apache.thrift.annotation.Nullable java.lang.String dbName; // required
    }
        }
        return true;
    /** Returns true if field parameters is set (has been assigned a value) and false otherwise */
                oprot.writeI32(struct.createTime);
                struct.sd.write(oprot);
            oprot.writeI32(struct.createTime);
    }
    public int getValuesSize() {
                        oprot.writeString(_iter143);
        this.tableName = tableName;
        VALUES((short) 1, "values"),
                }
        return false;
                    org.apache.thrift.protocol.TType.MAP,
        if (!first) sb.append(", ");
    public int lastAccessTime; // required
                                    for (int _i140 = 0; _i140 < _map137.size; ++_i140) {
            }
                    schemeField = iprot.readFieldBegin();
        hashCode = hashCode * 8191 + ((isSetDbName()) ? 131071 : 524287);
 */
    @Override
        }
    }
            oprot.writeFieldBegin(LAST_ACCESS_TIME_FIELD_DESC);
    public int compareTo(Partition other) {
    }
                }
            return _fieldName;
            _fieldName = fieldName;
        @Override
        lastComparison = java.lang.Boolean.compare(isSetValues(), other.isSetValues());
    );
        Comparable<Partition> {
            new org.apache.thrift.meta_data.FieldMetaData(
            try {
    public Partition setSd(@org.apache.thrift.annotation.Nullable StorageDescriptor sd) {
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    public int createTime; // required
                return isSetParameters();
        boolean this_present_createTime = true;
        }
        }
        sb.append("dbName:");
            switch (fieldId) {
                            } else {
        }
                if (value == null) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);
        sb.append(this.lastAccessTime);
                                    }
            sb.append("null");
        this.createTime = createTime;
            case TABLE_NAME:
        return 0;
        return this.lastAccessTime;
            if (struct.isSetValues()) {
        this.parameters.put(key, val);
        if (isSetLastAccessTime()) {
    public void unsetSd() {
                    struct.tableName = iprot.readString();
            this.dbName = other.dbName;
                if (incoming.get(1)) {
public class Partition
    }
                                }
    );
        }
        if (other.isSetSd()) {
                                {
            if (struct.dbName != null) {
    public void validate() throws org.apache.thrift.TException {
                        }
                        new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.values.size())
    private static class PartitionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                return isSetTableName();
        CREATE_TIME((short) 4, "createTime"),
        if (!first) sb.append(", ");
                java.lang.String,
                                        _elem135 = iprot.readString();
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
         */
        boolean this_present_lastAccessTime = true;
        public void read(org.apache.thrift.protocol.TProtocol prot, Partition struct) throws org.apache.thrift.TException {
            if (struct.values != null) {
            }
        if (lastComparison != 0) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        if (this_present_values || that_present_values) {
                        oprot.writeString(_iter144.getValue());
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        }
            }
    }
                        struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map148.size);
            java.util.List<java.lang.String> __this__values = new java.util.ArrayList<java.lang.String>(other.values);
        this.lastAccessTime = other.lastAccessTime;
        if (this_present_dbName || that_present_dbName) {
        }
                            _key149 = iprot.readString();
    public Partition() {}
    public void unsetCreateTime() {
        } else {
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            }
                                struct.setValuesIsSet(true);
                }
    }
        }
                                    iprot.readListEnd();
                "values",
            if (lastComparison != 0) {
                }
    public void clear() {
        if (lastComparison != 0) {
    public boolean isSet(_Fields field) {
    );
                        @org.apache.thrift.annotation.Nullable
            sd.validate();
            if (struct.isSetDbName()) {
                            } else {
            case TABLE_NAME:
                    {
            new org.apache.thrift.meta_data.FieldMetaData(
            return new PartitionTupleScheme();
    public boolean equals(java.lang.Object that) {
    private static class PartitionStandardScheme extends org.apache.thrift.scheme.StandardScheme<Partition> {
            }
            return fields;
        if (this_present_createTime || that_present_createTime) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        oprot.writeString(_iter141);
                        org.apache.thrift.protocol.TMap _map148 = iprot.readMapBegin(
                                struct.sd.read(iprot);
    private static final org.apache.thrift.protocol.TField SD_FIELD_DESC = new org.apache.thrift.protocol.TField(
        if (isSetValues()) {
                                }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        setLastAccessTimeIsSet(true);
                prot.decrementRecursionDepth();
    public void unsetValues() {
    public java.lang.String getDbName() {
        first = false;
                return getLastAccessTime();
                        );
        }
        @Override
                                    struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map137.size);
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PartitionTupleSchemeFactory();
            }
            this.parameters = null;
            case PARAMETERS:
            throw new java.lang.IllegalArgumentException();
        if (this == that) return true;
            sb.append("null");
            sb.append(this.values);
            }
            }
        return this.dbName != null;
        return this.tableName;
    public Partition setTableName(@org.apache.thrift.annotation.Nullable java.lang.String tableName) {
        this.parameters = null;
    public void setCreateTimeIsSet(boolean value) {
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        "parameters",
        this.parameters = null;
         * Find the _Fields constant that matches name, or null if its not found.
        if (!value) {
    }
                return getDbName();
            )
        if (this_present_tableName || that_present_tableName) {
        this.createTime = createTime;
        }
                if (incoming.get(0)) {
                if (value == null) {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        (short) 1
        this.parameters = parameters;
    );
            }
 *  @generated
        }
            }
                                struct.sd = new StorageDescriptor();
        tmpMap.put(
    }
                    );
                case 3: // TABLE_NAME
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                } else {
    public void addToValues(java.lang.String elem) {
    implements
    /** Returns true if field sd is set (has been assigned a value) and false otherwise */
        this.lastAccessTime = lastAccessTime;
                        java.lang.String _elem146;
                                struct.setParametersIsSet(true);
        setCreateTimeIsSet(false);
        java.io.Serializable,
            sb.append(this.sd);
        boolean that_present_sd = true && that.isSetSd();
        boolean first = true;
    @Override
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CREATETIME_ISSET_ID);
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
 * Autogenerated by Thrift Compiler (0.23.0)
        "createTime",
                        break;
        );
            }
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                    return CREATE_TIME;
        return this.tableName != null;
            if (struct.tableName != null) {
            if (struct.isSetParameters()) {
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters; // required
        hashCode = hashCode * 8191 + lastAccessTime;
        return (this.parameters == null) ? 0 : this.parameters.size();
                while (true) {
                    struct.sd.read(iprot);
    @Override
                oprot.writeString(struct.dbName);
        if (lastComparison != 0) {
        // check for required fields
            }
    }
    public Partition(Partition other) {
                                struct.dbName = iprot.readString();
        org.apache.thrift.protocol.TType.STRING,
                    setParameters((java.util.Map<java.lang.String, java.lang.String>) value);
                    }
                    }
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CREATETIME_ISSET_ID);
        if (other.isSetTableName()) {
            }
    public void unsetParameters() {
        }
        public static _Fields findByThriftId(int fieldId) {
        @Override
                return lastComparison;
                "parameters",
                if (value == null) {
                    setDbName((java.lang.String) value);
                } else {
        DB_NAME((short) 2, "dbName"),
            )
                optionals.set(0);
            this.tableName = other.tableName;
        }
            oprot.writeStructEnd();
        }
            sb.append("null");
            _Fields.PARAMETERS,
        public short getThriftFieldId() {
                            struct.parameters.size()
                    iprot.readFieldEnd();
        }
         */
            if (lastComparison != 0) {
            .getScheme();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        }
    public boolean isSetDbName() {
    public boolean equals(Partition that) {
                                    java.lang.String _elem135;
            )
    public @org.apache.thrift.annotation.Nullable StorageDescriptor sd; // required
        lastComparison = java.lang.Boolean.compare(isSetTableName(), other.isSetTableName());
        tmpMap.put(
            iprot.incrementRecursionDepth();
        boolean this_present_sd = true && this.isSetSd();
    }
                "createTime",
        this.lastAccessTime = 0;
    }
                    struct.sd = new StorageDescriptor();
    }
        );
        }
        if (!value) {
    @org.apache.thrift.annotation.Nullable
            throw new java.io.IOException(te);
        this.tableName = null;
        }
        (short) 7
        this.tableName = tableName;
            new org.apache.thrift.meta_data.FieldMetaData(
                        case 3: // TABLE_NAME
    // isset id assignments
        public static _Fields findByName(java.lang.String name) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);
        if (isSetSd()) {
                    for (java.lang.String _iter141 : struct.values) {
        static {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Partition");
        if (isSetDbName()) {
    }
    public boolean isSetCreateTime() {
    public void setValuesIsSet(boolean value) {
        }
    }
    @Override
        } catch (org.apache.thrift.TException te) {
        hashCode = hashCode * 8191 + ((isSetParameters()) ? 131071 : 524287);
            oprot.writeFieldStop();
        if (sd != null) {
        if (that instanceof Partition) return this.equals((Partition) that);
                    oprot.writeMapEnd();
        java.lang.String tableName,
        );
        this.dbName = dbName;
                            }
    public java.util.List<java.lang.String> getValues() {
        }
                break;
        boolean that_present_dbName = true && that.isSetDbName();
                        case 2: // DB_NAME
                        oprot.writeString(_iter142.getKey());
    /** Returns true if field createTime is set (has been assigned a value) and false otherwise */
        org.apache.thrift.protocol.TType.STRING,
        boolean this_present_dbName = true && this.isSetDbName();
        return this.createTime;
    @Override
            case LAST_ACCESS_TIME:
        (short) 4
        setCreateTimeIsSet(true);
        if (this.values == null) {
    }
     * Performs a deep copy on <i>other</i>.
        this();
                        struct.values = new java.util.ArrayList<java.lang.String>(_list145.size);
                            } else {
                optionals.set(2);
            _Fields.DB_NAME,
            if (struct.isSetLastAccessTime()) {
            }
                    }
                    oprot.writeI32(struct.parameters.size());
                                struct.setDbNameIsSet(true);
                        case 6: // SD
        @Override
        sb.append("lastAccessTime:");
    public boolean isSetSd() {
            if (lastComparison != 0) {
            case SD:
        "tableName",
                    return VALUES;
        try {
            case VALUES:
                        @org.apache.thrift.annotation.Nullable
        first = false;
                    org.apache.thrift.protocol.TType.LIST,
            if (!(this_present_values && that_present_values)) return false;
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    public void setParametersIsSet(boolean value) {
                return getSd();
                                {
        @Override
            if (struct.isSetDbName()) {
                java.lang.String>(other.parameters);
            if (!this.tableName.equals(that.tableName)) return false;
                    }
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PartitionStandardSchemeFactory();
            struct.validate();
            try {
        }
        sb.append("createTime:");
                                struct.setTableNameIsSet(true);
    }
        setLastAccessTimeIsSet(true);
                    setLastAccessTime((java.lang.Integer) value);
                )
            _Fields.SD,
                                    iprot.readMapEnd();
            return byName.get(name);
            if (!(this_present_tableName && that_present_tableName)) return false;
                break;
        return (this.values == null) ? 0 : this.values.size();
    }
            prot.incrementRecursionDepth();
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastAccessTime, other.lastAccessTime);
        }
    }
            this.values = new java.util.ArrayList<java.lang.String>();
                return isSetDbName();
                case 6: // SD
    }
        boolean that_present_parameters = true && that.isSetParameters();
        }
 *
        sb.append("values:");
                optionals.set(4);
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            throw new java.io.IOException(te);
            return _thriftId;
            case LAST_ACCESS_TIME:
                            struct.parameters.put(_key149, _val150);
                            }
        // check for sub-struct validity
                                        struct.parameters.put(_key138, _val139);
            case CREATE_TIME:
        return this;
                return isSetSd();
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID, value);
                if (incoming.get(6)) {
            oprot.writeFieldEnd();
        this.values = values;
        if (lastComparison != 0) {
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        sb.append(this.createTime);
            sb.append(this.dbName);
                                    @org.apache.thrift.annotation.Nullable
            this.sd = new StorageDescriptor(other.sd);
        "sd",
            if (struct.isSetSd()) {
        } else {
            case PARAMETERS:
                    setSd((StorageDescriptor) value);
        return this.values != null;
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            if (!this.parameters.equals(that.parameters)) return false;
            }
                    unsetSd();
        boolean that_present_tableName = true && that.isSetTableName();
                }
        public java.lang.String getFieldName() {
        }
    public int getCreateTime() {
                            }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        (short) 5
                            org.apache.thrift.protocol.TType.STRING
                "dbName",
        }
        int lastComparison = 0;
            if (!this.sd.equals(that.sd)) return false;
                        for (int _i151 = 0; _i151 < _map148.size; ++_i151) {
            }
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID);
    public int getParametersSize() {
                return lastComparison;
        return this;
    @org.apache.thrift.annotation.Nullable
        scheme(iprot).read(iprot, this);
                                struct.tableName = iprot.readString();
        public void write(org.apache.thrift.protocol.TProtocol oprot, Partition struct) throws org.apache.thrift.TException {
        }
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        "values",
        this.values = null;
    public void setDbNameIsSet(boolean value) {
                {
        boolean this_present_values = true && this.isSetValues();
            if (struct.isSetValues()) {
        public static _Fields findByThriftIdOrThrow(int fieldId) {
    }
    }
    public java.lang.Object getFieldValue(_Fields field) {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
            }
        }
        );
    /** Returns true if field values is set (has been assigned a value) and false otherwise */
        sb.append("parameters:");
        }
        if (this.dbName == null) {
                            } else {
        return this.parameters != null;
            case SD:
        return this.values;
                iprot.decrementRecursionDepth();
    }
                oprot.writeString(struct.tableName);
            oprot.writeFieldEnd();
        }
                }
                }
            _Fields.TABLE_NAME,
    }
                    return DB_NAME;
        if (!first) sb.append(", ");
                break;
            case SD:
                }
            }
        first = false;
        scheme(oprot).write(oprot, this);
package org.opensearch.plugin.hive.metastore;
                    setValues((java.util.List<java.lang.String>) value);
        public void read(org.apache.thrift.protocol.TProtocol iprot, Partition struct) throws org.apache.thrift.TException {
    }
                optionals.set(3);
    }
    /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
            sb.append(this.parameters);
                if (value == null) {
                    oprot.writeListBegin(
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
        /**
        return this;
                        )
        boolean that_present_createTime = true;
    private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public @org.apache.thrift.annotation.Nullable java.lang.String tableName; // required
    }
    @org.apache.thrift.annotation.Nullable
        if (!value) {
    }
        switch (field) {
        private final java.lang.String _fieldName;
                            }
            return lastComparison;
                    struct.setCreateTimeIsSet(true);
         */
                            }
                    struct.dbName = iprot.readString();
                iprot.readStructEnd();
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID);
                optionals.set(6);
        @Override
    private byte __isset_bitfield = 0;
                                        struct.values.add(_elem135);
    public Partition setDbName(@org.apache.thrift.annotation.Nullable java.lang.String dbName) {
            }
                {
        hashCode = hashCode * 8191 + ((isSetValues()) ? 131071 : 524287);
                oprot.writeString(struct.dbName);
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
    @Override
    }
    }
                oprot.writeFieldBegin(SD_FIELD_DESC);
            } finally {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            if (this.lastAccessTime != that.lastAccessTime) return false;
    /**
            java.util.BitSet optionals = new java.util.BitSet();
            if (lastComparison != 0) {
                }
    }
        }
        }
    }
        }
                }
    }
        first = false;
        return _Fields.findByThriftId(fieldId);
            case VALUES:
                if (incoming.get(4)) {
            this.tableName = null;
            if (!(this_present_lastAccessTime && that_present_lastAccessTime)) return false;
        if (isSetParameters()) {
                case 7: // PARAMETERS
                                    org.apache.thrift.protocol.TList _list134 = iprot.readListBegin();
    }
                oprot.writeString(struct.tableName);
                new org.apache.thrift.meta_data.MapMetaData(
        (short) 3
        if (isSetSd()) hashCode = hashCode * 8191 + sd.hashCode();
                    {
        tmpMap.put(
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter142 : struct.parameters.entrySet()) {
    }
                case 5: // LAST_ACCESS_TIME
        if (lastComparison != 0) {
                    unsetValues();
            __isset_bitfield = 0;
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CREATETIME_ISSET_ID, value);
                iprot.readStructBegin();
        }
                } else {
            case LAST_ACCESS_TIME:
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
                                        _val139 = iprot.readString();
    }
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                                    @org.apache.thrift.annotation.Nullable
    }
                return lastComparison;
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, StorageDescriptor.class)
    @org.apache.thrift.annotation.Nullable
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        }
                default:
    public Partition setParameters(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters) {
    public Partition setCreateTime(int createTime) {
                                struct.lastAccessTime = iprot.readI32();
                oprot.writeFieldEnd();
            }
            if (lastComparison != 0) {
                            } else {
        if (field == null) {
            }
    }
        this.sd = sd;
                {
        sb.append("sd:");
            } finally {
            )
        first = false;
            _Fields.CREATE_TIME,
        StorageDescriptor sd,
                    switch (schemeField.id) {
        _Fields(short thriftId, java.lang.String fieldName) {
        }
                case 1: // VALUES
                byName.put(field.getFieldName(), field);
        }
    }
    }
            case CREATE_TIME:
        this.sd = null;
                    struct.createTime = iprot.readI32();
    private static class PartitionTupleScheme extends org.apache.thrift.scheme.TupleScheme<Partition> {
                            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
    private static class PartitionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                oprot.writeFieldEnd();
        first = false;
        TABLE_NAME((short) 3, "tableName"),
                if (value == null) {
            if (struct.isSetCreateTime()) {
    }
            }
    public void setTableNameIsSet(boolean value) {
                            _val150 = iprot.readString();
                    struct.setLastAccessTimeIsSet(true);
    );
    }
        );
            return lastComparison;
        if (lastComparison != 0) {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
                        case 7: // PARAMETERS
            sb.append("null");
            new org.apache.thrift.meta_data.FieldMetaData(
            if (!(this_present_dbName && that_present_dbName)) return false;
                        @org.apache.thrift.annotation.Nullable
        int hashCode = 1;
                return getValues();
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        java.lang.String _key149;
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        try {
                } else {
    public java.util.Iterator<java.lang.String> getValuesIterator() {
                if (value == null) {
        if (isSetTableName()) hashCode = hashCode * 8191 + tableName.hashCode();
                    return SD;
            _thriftId = thriftId;
}
                            break;
                if (incoming.get(3)) {
        tmpMap.put(
        return this.sd != null;
            if (!(this_present_sd && that_present_sd)) return false;
    @Override
            _Fields.VALUES,
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                oprot.writeFieldEnd();
            this.parameters = new java.util.HashMap<java.lang.String, java.lang.String>();
    public void setLastAccessTimeIsSet(boolean value) {
                oprot.writeI32(struct.lastAccessTime);
            case CREATE_TIME:
                                struct.setCreateTimeIsSet(true);
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                break;
            if (!this.values.equals(that.values)) return false;
    }
        public PartitionTupleScheme getScheme() {
                return getTableName();
        tmpMap.put(
        @Override
                    for (java.lang.String _iter143 : struct.values) {
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                    oprot.writeI32(struct.values.size());
    public void unsetLastAccessTime() {
                    struct.setSdIsSet(true);
            _Fields.LAST_ACCESS_TIME,
    public boolean isSetTableName() {
        @org.apache.thrift.annotation.Nullable
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        Cloneable,
    }
        boolean that_present_lastAccessTime = true;
                if (incoming.get(2)) {
        return hashCode;
    @org.apache.thrift.annotation.Nullable
        public PartitionStandardScheme getScheme() {
                            _elem146 = iprot.readString();
        return this;
        } else {
                case 4: // CREATE_TIME
        } else {
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
            )
            }
                            } else {
        if (other.isSetValues()) {
            new org.apache.thrift.meta_data.FieldMetaData(
    public void unsetDbName() {
                            break;
        return this;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Partition(");
            }
                struct.sd.write(oprot);
    static {
        }
        }
                struct.validate();
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
        hashCode = hashCode * 8191 + ((isSetTableName()) ? 131071 : 524287);
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            if (struct.isSetTableName()) {
                                    java.lang.String _val139;
                        }
                    struct.lastAccessTime = iprot.readI32();
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            return lastComparison;
    public int hashCode() {
        if (other.isSetDbName()) {
            }
            if (struct.isSetLastAccessTime()) {
        (short) 2
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        }
                                struct.setLastAccessTimeIsSet(true);
    public StorageDescriptor getSd() {
        if (this_present_parameters || that_present_parameters) {
            }
    @Override
                                    java.lang.String _key138;
            )
        if (that == null) return false;
                                    }
            if (struct.isSetTableName()) {
                                struct.setSdIsSet(true);
                    unsetCreateTime();
    private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                            }
    }
        org.apache.thrift.protocol.TType.STRUCT,
        return sb.toString();
                // check for required fields of primitive type, which can't be checked in the validate method
        }
    }
    public boolean isSetLastAccessTime() {
        first = false;
        lastComparison = java.lang.Boolean.compare(isSetSd(), other.isSetSd());
        org.apache.thrift.TBase<Partition, Partition._Fields>,
    @org.apache.thrift.annotation.Nullable
        if (lastComparison != 0) {
        java.util.List<java.lang.String> values,
                        case 1: // VALUES
            }
        throw new java.lang.IllegalStateException();
                oprot.writeFieldEnd();
/**
            if (lastComparison != 0) {
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Partition.class, metaDataMap);
            new org.apache.thrift.meta_data.FieldMetaData(
        "lastAccessTime",
    public java.lang.String getTableName() {
            if (this.createTime != that.createTime) return false;
        }
     */
                            break;
    }
    }
            this.values = null;
                if (incoming.get(5)) {
            sb.append(this.tableName);
        if (!first) sb.append(", ");
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    }
                oprot.writeFieldBegin(VALUES_FIELD_DESC);
        org.apache.thrift.protocol.TType.LIST,
    }
                    struct.setParametersIsSet(true);
                                    org.apache.thrift.protocol.TMap _map137 = iprot.readMapBegin();
            new org.apache.thrift.meta_data.FieldMetaData(
        this.dbName = dbName;
        (short) 6
            return lastComparison;
        }
    private static final int __CREATETIME_ISSET_ID = 0;
                if (value == null) {
        org.apache.thrift.protocol.TType.I32,
                case 2: // DB_NAME
                    }
        sb.append(")");
                    oprot.writeMapBegin(
        /**
        setCreateTimeIsSet(true);
                    unsetTableName();
                    unsetParameters();
                    struct.setTableNameIsSet(true);
                }
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return this.dbName;
                        oprot.writeString(_iter144.getKey());
                }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    }
    @Override
        SD((short) 6, "sd"),
                return getParameters();
    }
        this.createTime = 0;
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTime, other.createTime);
                    }
        if (isSetDbName()) hashCode = hashCode * 8191 + dbName.hashCode();
        return this;
    public Partition(
    public Partition deepCopy() {
                            struct.values.add(_elem146);
    public boolean isSetValues() {
        hashCode = hashCode * 8191 + ((isSetSd()) ? 131071 : 524287);
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
                return lastComparison;
                                    for (int _i136 = 0; _i136 < _list134.size; ++_i136) {
            oprot.writeI32(struct.lastAccessTime);
            java.util.Map<java.lang.String, java.lang.String> __this__parameters = new java.util.HashMap<
                return getCreateTime();
        this.tableName = null;
        }
        switch (field) {
    @Override
    );
                } else {
                            } else {
        @org.apache.thrift.annotation.Nullable
        );
                        java.lang.String _val150;
        tmpMap.put(
            case DB_NAME:
            return lastComparison;
        if (!value) {
        if (!getClass().equals(other.getClass())) {
                new org.apache.thrift.meta_data.ListMetaData(
                return lastComparison;
            case VALUES:
        java.lang.String dbName,
        if (this_present_lastAccessTime || that_present_lastAccessTime) {
            return lastComparison;
        if (!first) sb.append(", ");
    }
    public Partition setValues(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> values) {
        if (!value) {
                                        _key138 = iprot.readString();
    }
            case DB_NAME:
        boolean this_present_tableName = true && this.isSetTableName();
    private static final int __LASTACCESSTIME_ISSET_ID = 1;
        setLastAccessTimeIsSet(false);
                            break;
                    return LAST_ACCESS_TIME;
            if (struct.parameters != null) {
                    oprot.writeListEnd();
            this.sd = null;
        }
        }
    }
        if (other.isSetParameters()) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        tmpMap.put(
    public _Fields fieldForId(int fieldId) {
                }
        @Override
        this.parameters = parameters;
                }
                    );
            if (!(this_present_parameters && that_present_parameters)) return false;
        }
        }
        }
    /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
        __isset_bitfield = other.__isset_bitfield;
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
    private static final org.apache.thrift.protocol.TField VALUES_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public void putToParameters(java.lang.String key, java.lang.String val) {
                                struct.createTime = iprot.readI32();
        }
                            org.apache.thrift.protocol.TType.STRING,
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
         * Find the _Fields constant that matches fieldId, throwing an exception
            case PARAMETERS:
            oprot.writeBitSet(optionals, 7);
        int lastAccessTime,
            if (struct.isSetCreateTime()) {
            return new PartitionStandardScheme();
        this.lastAccessTime = lastAccessTime;
                        case 5: // LAST_ACCESS_TIME
                oprot.writeFieldEnd();
        this.dbName = null;
                            break;
         * if it is not found.
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sd, other.sd);
                )
        lastComparison = java.lang.Boolean.compare(isSetCreateTime(), other.isSetCreateTime());
    );
                    }
        this.values = values;
                            break;
    public void setSdIsSet(boolean value) {
                    setTableName((java.lang.String) value);
    /** Returns true if field lastAccessTime is set (has been assigned a value) and false otherwise */
            this.dbName = null;
                    return TABLE_NAME;
                        default:
            case TABLE_NAME:
        if (this.parameters == null) {
        hashCode = hashCode * 8191 + createTime;
            if (struct.isSetParameters()) {
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
    }
                optionals.set(5);
        if (this.values == null) {
            }
        if (this.sd == null) {
        if (this.tableName == null) {
        if (isSetParameters()) hashCode = hashCode * 8191 + parameters.hashCode();
        LAST_ACCESS_TIME((short) 5, "lastAccessTime"),
    ) {
                                    @org.apache.thrift.annotation.Nullable
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, other.tableName);
    }
        if (this_present_sd || that_present_sd) {
    }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
    }
        }
            case DB_NAME:
    private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            if (!(this_present_createTime && that_present_createTime)) return false;
        throw new java.lang.IllegalStateException();
        lastComparison = java.lang.Boolean.compare(isSetParameters(), other.isSetParameters());
                optionals.set(1);
        return this.sd;
            if (!this.dbName.equals(that.dbName)) return false;
    public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> values; // required
                    struct.setValuesIsSet(true);
                        oprot.writeString(_iter142.getValue());
        lastComparison = java.lang.Boolean.compare(isSetDbName(), other.isSetDbName());
                        case 4: // CREATE_TIME
    }
    public void unsetTableName() {
        if (isSetCreateTime()) {
                break;
            this.parameters = __this__parameters;
                    unsetLastAccessTime();
    @Override
    }
        switch (field) {
                return lastComparison;
        "dbName",
                } else {
        boolean this_present_parameters = true && this.isSetParameters();
                "tableName",
                oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);
            return getClass().getName().compareTo(other.getClass().getName());
                return isSetValues();
            }
        return this.parameters;
                    setCreateTime((java.lang.Integer) value);
        }
        sb.append("tableName:");
        }
                }
    private static final org.apache.thrift.protocol.TField LAST_ACCESS_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public java.util.Map<java.lang.String, java.lang.String> getParameters() {
            _Fields fields = findByThriftId(fieldId);
            sb.append("null");
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        org.apache.thrift.protocol.TType.I32,
                "sd",
        private final short _thriftId;
        public void write(org.apache.thrift.protocol.TProtocol prot, Partition struct) throws org.apache.thrift.TException {
        /**
            if (struct.sd != null) {
        PARAMETERS((short) 7, "parameters");
            )
        this.sd = sd;
    public Partition setLastAccessTime(int lastAccessTime) {
