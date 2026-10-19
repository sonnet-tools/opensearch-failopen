            }
    private static final int __REWRITEENABLED_ISSET_ID = 4;
    public @org.apache.thrift.annotation.Nullable CreationMetadata creationMetadata; // optional
            if (lastComparison != 0) {
                    struct.setViewOriginalTextIsSet(true);
    public boolean isSetWriteId() {
    public java.lang.String getTableType() {
            new org.apache.thrift.meta_data.FieldMetaData(
            )
                            struct.parameters.put(_key131, _val132);
    }
    /**
    }
        }
        }
        this.createTime = createTime;
        if (this.dbName == null) {
    public boolean isSetOwner() {
    public void setRetentionIsSet(boolean value) {
                        new org.apache.thrift.protocol.TMap(
                oprot.writeFieldEnd();
    }
            }
            )
        (short) 17
                return getCreateTime();
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                            break;
    @org.apache.thrift.annotation.Nullable
    }
    public void setCreateTimeIsSet(boolean value) {
}
        );
                optionals.set(16);
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                    unsetViewExpandedText();
            }
        boolean this_present_temporary = true && this.isSetTemporary();
    );
                    return RETENTION;
        boolean this_present_catName = true && this.isSetCatName();
            }
    public Table setCreationMetadata(@org.apache.thrift.annotation.Nullable CreationMetadata creationMetadata) {
                return isSetWriteId();
            oprot.writeFieldStop();
                if (value == null) {
                        case 4: // CREATE_TIME
        hashCode = hashCode * 8191 + ((isSetCreationMetadata()) ? 131071 : 524287);
        if (privileges != null) {
                return lastComparison;
            this.viewExpandedText = other.viewExpandedText;
            if (struct.viewOriginalText != null) {
            case CAT_NAME:
            if (struct.isSetWriteId()) {
        int createTime,
        hashCode = hashCode * 8191 + lastAccessTime;
        if (isSetCreationMetadata()) hashCode = hashCode * 8191 + creationMetadata.hashCode();
        PRIVILEGES((short) 13, "privileges"),
                            break;
        "parameters",
        setRetentionIsSet(true);
            case VIEW_EXPANDED_TEXT:
            }
        return 0;
                                struct.setRetentionIsSet(true);
        if (isSetViewOriginalText()) {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RETENTION_ISSET_ID);
                iprot.decrementRecursionDepth();
    }
                    struct.setParametersIsSet(true);
            case PARAMETERS:
            }
        }
                optionals.set(7);
                                struct.privileges.read(iprot);
        return this;
        if (!value) {
                        oprot.writeString(_iter124.getValue());
        }
            sb.append("creationMetadata:");
        if (isSetRetention()) {
    public Table setTableName(@org.apache.thrift.annotation.Nullable java.lang.String tableName) {
            return fields;
            if (this.rewriteEnabled != that.rewriteEnabled) return false;
            if (struct.isSetLastAccessTime()) {
        lastComparison = java.lang.Boolean.compare(isSetLastAccessTime(), other.isSetLastAccessTime());
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partitionKeys, other.partitionKeys);
            }
                            }
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                } else {
    public void unsetSd() {
                    struct.owner = iprot.readString();
        }
        if (this.viewOriginalText == null) {
        return this;
                return isRewriteEnabled();
            }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    @org.apache.thrift.annotation.Nullable
    }
        return this;
    public Table setDbName(@org.apache.thrift.annotation.Nullable java.lang.String dbName) {
    }
        if (isSetTemporary()) hashCode = hashCode * 8191 + ((temporary) ? 131071 : 524287);
                        case 17: // CAT_NAME
    public void unsetTableType() {
        }
        } else {
        first = false;
            if (struct.creationMetadata != null) {
                oprot.writeString(struct.tableName);
                oprot.writeI32(struct.lastAccessTime);
         * Find the _Fields constant that matches fieldId, throwing an exception
    }
            if (lastComparison != 0) {
                if (value == null) {
         */
        this.viewOriginalText = null;
    private static final org.apache.thrift.protocol.TField TABLE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField(
    private static final org.apache.thrift.protocol.TField VIEW_ORIGINAL_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField(
                        default:
        (short) 11
    }
                oprot.writeBool(struct.rewriteEnabled);
        return this.rewriteEnabled;
        if (isSetSd()) {
    public int getPartitionKeysSize() {
            if (lastComparison != 0) {
                                    struct.partitionKeys = new java.util.ArrayList<FieldSchema>(_list116.size);
                if (struct.isSetCatName()) {
    private static final org.apache.thrift.protocol.TField OWNER_FIELD_DESC = new org.apache.thrift.protocol.TField(
            if (struct.isSetOwnerType()) {
            if (!first) sb.append(", ");
        java.lang.String viewExpandedText,
            new org.apache.thrift.meta_data.FieldMetaData(
            this.parameters = __this__parameters;
                                    org.apache.thrift.protocol.TList _list116 = iprot.readListBegin();
                                    @org.apache.thrift.annotation.Nullable
            new org.apache.thrift.meta_data.FieldMetaData(
                    setLastAccessTime((java.lang.Integer) value);
    private static final int __TEMPORARY_ISSET_ID = 3;
        this.privileges = privileges;
            if (struct.isSetCreationMetadata()) {
        }
    }
        if (isSetCatName()) hashCode = hashCode * 8191 + catName.hashCode();
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        if (isSetOwnerType()) {
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        if (field == null) {
        lastComparison = java.lang.Boolean.compare(isSetRetention(), other.isSetRetention());
                            } else {
        }
        hashCode = hashCode * 8191 + ((isSetCatName()) ? 131071 : 524287);
    /** Returns true if field tableType is set (has been assigned a value) and false otherwise */
            first = false;
                if (incoming.get(17)) {
        tmpMap.put(
        if (!value) {
                            }
        }
    }
        java.util.List<FieldSchema> partitionKeys,
        lastComparison = java.lang.Boolean.compare(isSetPartitionKeys(), other.isSetPartitionKeys());
        }
        boolean this_present_writeId = true && this.isSetWriteId();
    private static final org.apache.thrift.protocol.TField RETENTION_FIELD_DESC = new org.apache.thrift.protocol.TField(
                if (value == null) {
        (short) 5
    @org.apache.thrift.annotation.Nullable
            if (struct.isSetDbName()) {
    );
                    struct.catName = iprot.readString();
                                struct.setPrivilegesIsSet(true);
                } else {
    public _Fields fieldForId(int fieldId) {
            if (struct.isSetCatName()) {
    }
        }
    /** Returns true if field sd is set (has been assigned a value) and false otherwise */
                }
    }
            sb.append("rewriteEnabled:");
            if (!(this_present_createTime && that_present_createTime)) return false;
    public void unsetOwnerType() {
                "rewriteEnabled",
        sb.append("sd:");
            _Fields.WRITE_ID,
            this.viewExpandedText = null;
        if (lastComparison != 0) {
            if (lastComparison != 0) {
    public void unsetWriteId() {
        this.tableName = null;
    public void unsetTemporary() {
            if (struct.isSetTableName()) {
        this.ownerType = null;
                    unsetCatName();
        sb.append("dbName:");
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            _thriftId = thriftId;
        return this.tableType != null;
                break;
            }
            if (struct.isSetCatName()) {
                {
    }
        this.sd = null;
        OWNER_TYPE((short) 18, "ownerType"),
    }
                oprot.writeFieldBegin(VIEW_EXPANDED_TEXT_FIELD_DESC);
        boolean this_present_viewExpandedText = true && this.isSetViewExpandedText();
        setRewriteEnabledIsSet(true);
        if (!first) sb.append(", ");
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            if (struct.viewExpandedText != null) {
 *
 * Autogenerated by Thrift Compiler (0.23.0)
                            break;
            this.privileges = new PrincipalPrivilegeSet(other.privileges);
    }
    @Override
    }
        this.writeId = writeId;
    }
            }
    }
        return this.tableName != null;
                        struct.partitionKeys = new java.util.ArrayList<FieldSchema>(_list127.size);
    }
                break;
        StorageDescriptor sd,
            if (lastComparison != 0) {
                "sd",
                    unsetOwner();
                oprot.writeString(struct.viewOriginalText);
            if (this.retention != that.retention) return false;
        return this;
            )
                }
                                struct.setTableTypeIsSet(true);
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                    setViewOriginalText((java.lang.String) value);
                    setPrivileges((PrincipalPrivilegeSet) value);
    }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                                struct.setPartitionKeysIsSet(true);
            new org.apache.thrift.meta_data.FieldMetaData(
        throw new java.lang.IllegalStateException();
            )
                    iprot.readFieldEnd();
    private static final org.apache.thrift.protocol.TField CAT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public void unsetViewExpandedText() {
                optionals.set(15);
                    return OWNER_TYPE;
        return this.tableName;
                    return null;
        this();
        }
                                    for (int _i122 = 0; _i122 < _map119.size; ++_i122) {
    public java.lang.String getDbName() {
        );
            }
        this.tableType = tableType;
        TABLE_TYPE((short) 12, "tableType"),
                                        _elem117 = new FieldSchema();
                } else {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                case 19: // WRITE_ID
            case WRITE_ID:
        public void read(org.apache.thrift.protocol.TProtocol prot, Table struct) throws org.apache.thrift.TException {
                return isSetViewExpandedText();
    private static final org.apache.thrift.protocol.TField CREATION_METADATA_FIELD_DESC = new org.apache.thrift.protocol.TField(
        _Fields.OWNER_TYPE,
        return this.partitionKeys;
            }
            if (struct.parameters != null) {
    }
        setTemporaryIsSet(true);
            }
    }
        if (lastComparison != 0) {
                {
            if (!(this_present_dbName && that_present_dbName)) return false;
            }
    );
                                    iprot.readMapEnd();
                    struct.sd = new StorageDescriptor();
                    for (FieldSchema _iter123 : struct.partitionKeys) {
                }
            new org.apache.thrift.meta_data.FieldMetaData(
                        case 5: // LAST_ACCESS_TIME
    private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField(
    }
        if (!first) sb.append(", ");
    public java.lang.String getCatName() {
    public void setWriteIdIsSet(boolean value) {
            }
        this.creationMetadata = null;
        if (isSetLastAccessTime()) {
            throw new java.io.IOException(te);
                return isSetPartitionKeys();
    }
        if (!value) {
        hashCode = hashCode * 8191 + ((isSetTemporary()) ? 131071 : 524287);
                                    }
        } else {
            if (lastComparison != 0) {
    public Table setLastAccessTime(int lastAccessTime) {
            sb.append(this.writeId);
                        new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.partitionKeys.size())
    public boolean equals(java.lang.Object that) {
                if (incoming.get(16)) {
        if (this_present_retention || that_present_retention) {
    );
                return lastComparison;
                            } else {
        (short) 19
    }
                "viewExpandedText",
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
            oprot.writeI32(struct.lastAccessTime);
        java.lang.String viewOriginalText,
                struct.sd.write(oprot);
                        for (int _i129 = 0; _i129 < _list127.size; ++_i129) {
        this.partitionKeys = partitionKeys;
                oprot.writeFieldEnd();
        this.writeId = other.writeId;
            }
                                    org.apache.thrift.protocol.TMap _map119 = iprot.readMapBegin();
            _Fields.VIEW_ORIGINAL_TEXT,
        return this.viewOriginalText;
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sd, other.sd);
            sb.append("null");
                if (value == null) {
        return this;
        CREATE_TIME((short) 4, "createTime"),
                oprot.writeString(struct.owner);
                oprot.writeFieldBegin(SD_FIELD_DESC);
        }
            case TABLE_TYPE:
                if (value == null) {
    }
            oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);
            sd.validate();
    }
        return this;
            case TEMPORARY:
    }
            return lastComparison;
        } else {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            if (lastComparison != 0) {
        tmpMap.put(
            sb.append("writeId:");
                            break;
            )
                prot.decrementRecursionDepth();
    }
    }
                                    iprot.readListEnd();
            if (lastComparison != 0) {
    public Table setPrivileges(@org.apache.thrift.annotation.Nullable PrincipalPrivilegeSet privileges) {
        @Override
                }
    public void setRewriteEnabledIsSet(boolean value) {
        boolean this_present_creationMetadata = true && this.isSetCreationMetadata();
                            } else {
                sb.append(this.privileges);
                            org.apache.thrift.protocol.TType.STRING,
                    struct.setRewriteEnabledIsSet(true);
        boolean that_present_dbName = true && that.isSetDbName();
    public void unsetLastAccessTime() {
            if (struct.isSetRewriteEnabled()) {
        boolean that_present_tableType = true && that.isSetTableType();
                        _iter125.write(oprot);
            )
            if (struct.sd != null) {
    }
        org.apache.thrift.protocol.TType.I32,
            first = false;
    }
                return isSetOwnerType();
        }
                    return CREATE_TIME;
            _Fields.TEMPORARY,
            _Fields.TABLE_NAME,
        @Override
                    org.apache.thrift.protocol.TType.MAP,
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    private static final _Fields[] optionals = {
        org.apache.thrift.protocol.TType.STRING,
        boolean that_present_viewOriginalText = true && that.isSetViewOriginalText();
            if (struct.isSetTableType()) {
        );
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ownerType, other.ownerType);
        }
        return this.creationMetadata;
        private final java.lang.String _fieldName;
                                        _key120 = iprot.readString();
            }
            if (struct.isSetCreateTime()) {
                "viewOriginalText",
        if (this == that) return true;
                }
                            } else {
            if (struct.isSetPartitionKeys()) {
        this.partitionKeys.add(elem);
                    struct.setTemporaryIsSet(true);
        tmpMap.put(
        hashCode = hashCode * 8191 + ((isSetOwner()) ? 131071 : 524287);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTime, other.createTime);
    }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
    }
        if (lastComparison != 0) {
        );
        _Fields.PRIVILEGES,
        "partitionKeys",
                } else {
                }
            case PRIVILEGES:
            if (struct.isSetRetention()) {
        if (lastComparison != 0) {
                }
                oprot.writeI32(struct.retention);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
            if (!(this_present_owner && that_present_owner)) return false;
        }
        DB_NAME((short) 2, "dbName"),
                            org.apache.thrift.protocol.TType.STRING,
        sb.append("parameters:");
                optionals.set(4);
            throw new java.lang.IllegalArgumentException();
    private static final org.apache.thrift.protocol.TField PARTITION_KEYS_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public @org.apache.thrift.annotation.Nullable java.lang.String catName; // optional
        return (this.parameters == null) ? 0 : this.parameters.size();
                    setOwnerType((PrincipalType) value);
                }
            this.tableType = null;
            if (lastComparison != 0) {
        return this.catName != null;
        org.apache.thrift.protocol.TType.STRING,
    public boolean isSetViewOriginalText() {
        PARTITION_KEYS((short) 8, "partitionKeys"),
            }
        return this.lastAccessTime;
                    struct.dbName = iprot.readString();
        }
         * Find the _Fields constant that matches name, or null if its not found.
        if (this_present_viewOriginalText || that_present_viewOriginalText) {
                oprot.writeBool(struct.rewriteEnabled);
        boolean this_present_parameters = true && this.isSetParameters();
    }
                optionals.set(12);
    public void unsetCreationMetadata() {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.temporary, other.temporary);
        return this.dbName;
                    setDbName((java.lang.String) value);
    public Table setViewOriginalText(@org.apache.thrift.annotation.Nullable java.lang.String viewOriginalText) {
                        oprot.writeString(_iter126.getKey());
    public void unsetPrivileges() {
                return isSetParameters();
            if (!this.tableType.equals(that.tableType)) return false;
    }
            oprot.writeStructBegin(STRUCT_DESC);
                    oprot.writeFieldEnd();
    private static final int __CREATETIME_ISSET_ID = 0;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        this.createTime = 0;
                oprot.writeString(struct.tableType);
        if (isSetCatName()) {
            sb.append("null");
            return new TableTupleScheme();
        this.tableType = null;
            sb.append(this.rewriteEnabled);
        this.creationMetadata = null;
                oprot.writeString(struct.catName);
            if (struct.isSetWriteId()) {
    /** Returns true if field parameters is set (has been assigned a value) and false otherwise */
            this.partitionKeys = new java.util.ArrayList<FieldSchema>();
                        case 18: // OWNER_TYPE
        }
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TEMPORARY_ISSET_ID);
                    }
    }
            case CAT_NAME:
    public boolean isSetTemporary() {
    }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.retention, other.retention);
                case 1: // TABLE_NAME
                oprot.writeFieldBegin(TABLE_TYPE_FIELD_DESC);
                            }
                optionals.set(9);
                                struct.setDbNameIsSet(true);
                if (incoming.get(11)) {
            case VIEW_EXPANDED_TEXT:
            case VIEW_ORIGINAL_TEXT:
            sb.append(this.tableName);
                    setCatName((java.lang.String) value);
            case DB_NAME:
    public @org.apache.thrift.annotation.Nullable java.lang.String dbName; // required
                            }
            if (!first) sb.append(", ");
        org.apache.thrift.protocol.TType.I32,
        sb.append("partitionKeys:");
            if (!this.viewOriginalText.equals(that.viewOriginalText)) return false;
                            }
            }
        );
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.viewOriginalText, other.viewOriginalText);
    @Override
                }
                oprot.writeFieldBegin(TEMPORARY_FIELD_DESC);
                if (incoming.get(0)) {
                    struct.setOwnerIsSet(true);
        lastComparison = java.lang.Boolean.compare(isSetRewriteEnabled(), other.isSetRewriteEnabled());
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
 *  @generated
         */
            return new TableStandardScheme();
        this.dbName = dbName;
                    }
    }
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, CreationMetadata.class)
    public java.lang.String getOwner() {
        org.apache.thrift.protocol.TType.I32,
            if (struct.isSetLastAccessTime()) {
    /** Returns true if field viewOriginalText is set (has been assigned a value) and false otherwise */
                return getTableName();
            if (struct.isSetViewExpandedText()) {
        this.creationMetadata = creationMetadata;
            }
                                }
                    struct.tableName = iprot.readString();
            if (!first) sb.append(", ");
    public java.lang.String getViewOriginalText() {
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Table.class, metaDataMap);
                oprot.writeFieldEnd();
        lastComparison = java.lang.Boolean.compare(isSetOwnerType(), other.isSetOwnerType());
        return this;
                case 18: // OWNER_TYPE
                break;
            return lastComparison;
    }
                return getViewOriginalText();
                }
                    struct.setPrivilegesIsSet(true);
                                        _val121 = iprot.readString();
        if (this_present_dbName || that_present_dbName) {
            new org.apache.thrift.meta_data.FieldMetaData(
                oprot.writeFieldEnd();
                oprot.writeFieldEnd();
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            )
            }
        "writeId",
                sb.append("null");
            case TEMPORARY:
                break;
            if (lastComparison != 0) {
        }
                    schemeField = iprot.readFieldBegin();
                break;
            new org.apache.thrift.meta_data.FieldMetaData(
        this.temporary = temporary;
                            } else {
                return lastComparison;
    public Table setTemporary(boolean temporary) {
                                struct.writeId = iprot.readI64();
            case VIEW_ORIGINAL_TEXT:
        if (lastComparison != 0) {
        "owner",
                        org.apache.thrift.protocol.TMap _map130 = iprot.readMapBegin(
    /** Returns true if field viewExpandedText is set (has been assigned a value) and false otherwise */
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Table(");
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.creationMetadata, other.creationMetadata);
            if (!(this_present_viewExpandedText && that_present_viewExpandedText)) return false;
        boolean that_present_ownerType = true && that.isSetOwnerType();
            if (lastComparison != 0) {
    public boolean isSetRewriteEnabled() {
                    setWriteId((java.lang.Long) value);
        }
        this.parameters = null;
            case LAST_ACCESS_TIME:
                return getDbName();
                                    java.lang.String _val121;
    );
                            }
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __WRITEID_ISSET_ID);
     * Performs a deep copy on <i>other</i>.
    private static class TableStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            case CREATION_METADATA:
                case 17: // CAT_NAME
            _Fields.REWRITE_ENABLED,
        if (!first) sb.append(", ");
    public @org.apache.thrift.annotation.Nullable java.lang.String owner; // required
        }
    public @org.apache.thrift.annotation.Nullable StorageDescriptor sd; // required
    public boolean isSetSd() {
                    }
        hashCode = hashCode * 8191 + ((isSetTableName()) ? 131071 : 524287);
            case DB_NAME:
        if (isSetPartitionKeys()) {
    }
                    return SD;
            this.parameters = null;
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID, value);
            if (!this.parameters.equals(that.parameters)) return false;
        lastComparison = java.lang.Boolean.compare(isSetTableType(), other.isSetTableType());
                }
        tmpMap.put(
        if (this_present_writeId || that_present_writeId) {
                org.apache.thrift.protocol.TField schemeField;
        org.apache.thrift.protocol.TType.STRING,
    public void unsetOwner() {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.catName, other.catName);
                if (incoming.get(5)) {
            new org.apache.thrift.meta_data.FieldMetaData(
        }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                    setTemporary((java.lang.Boolean) value);
        if (lastComparison != 0) {
        if (lastComparison != 0) {
                            break;
            }
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter124 : struct.parameters.entrySet()) {
    }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                            } else {
            _fieldName = fieldName;
        return this.partitionKeys != null;
        }
        boolean that_present_owner = true && that.isSetOwner();
                                    @org.apache.thrift.annotation.Nullable
                                struct.setSdIsSet(true);
                                struct.rewriteEnabled = iprot.readBool();
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            case SD:
package org.opensearch.plugin.hive.metastore;
    }
                while (true) {
                break;
        if (this_present_tableType || that_present_tableType) {
            if (struct.catName != null) {
    private static final int __LASTACCESSTIME_ISSET_ID = 1;
    }
    public Table setCreateTime(int createTime) {
                break;
                        org.apache.thrift.protocol.TList _list127 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
                struct.creationMetadata.write(oprot);
                }
        }
            this.catName = other.catName;
            }
        if (other.isSetSd()) {
        hashCode = hashCode * 8191 + ((isSetWriteId()) ? 131071 : 524287);
                    return TEMPORARY;
    }
                case 16: // CREATION_METADATA
                case 5: // LAST_ACCESS_TIME
                            } else {
                if (value == null) {
                {
        }
                case 9: // PARAMETERS
        this.tableType = tableType;
                        _iter123.write(oprot);
    public @org.apache.thrift.annotation.Nullable java.lang.String viewExpandedText; // required
        if (lastComparison != 0) {
        setLastAccessTimeIsSet(true);
            } finally {
    public Table setCatName(@org.apache.thrift.annotation.Nullable java.lang.String catName) {
                return isSetViewOriginalText();
                            org.apache.thrift.protocol.TType.STRING
            _Fields.OWNER_TYPE,
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    private static class TableTupleScheme extends org.apache.thrift.scheme.TupleScheme<Table> {
        org.apache.thrift.protocol.TType.STRING,
        this.dbName = null;
    public void unsetDbName() {
        }
        }
        @Override
        }
            if (!(this_present_sd && that_present_sd)) return false;
        (short) 10
            if (this.ownerType == null) {
        if (isSetPartitionKeys()) hashCode = hashCode * 8191 + partitionKeys.hashCode();
                            } else {
        }
            }
            if (!this.partitionKeys.equals(that.partitionKeys)) return false;
            this.dbName = other.dbName;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
    /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
            case RETENTION:
         * Find the _Fields constant that matches fieldId, or null if its not found.
                    return TABLE_TYPE;
        if (lastComparison != 0) {
        hashCode = hashCode * 8191 + ((isSetOwnerType()) ? 131071 : 524287);
        VIEW_ORIGINAL_TEXT((short) 10, "viewOriginalText"),
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        if (creationMetadata != null) {
        tmpMap.put(
    /** Returns true if field privileges is set (has been assigned a value) and false otherwise */
        sb.append(this.retention);
                if (struct.isSetPrivileges()) {
    public PrincipalType getOwnerType() {
                oprot.writeFieldEnd();
        int lastAccessTime,
        hashCode = hashCode * 8191 + retention;
                java.lang.String>(other.parameters);
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TEMPORARY_ISSET_ID);
                "privileges",
            if (struct.ownerType != null) {
        try {
        } else {
            }
            }
                "ownerType",
        if (this_present_lastAccessTime || that_present_lastAccessTime) {
            }
         */
                case 7: // SD
        first = false;
                if (incoming.get(12)) {
    );
        tmpMap.put(
        if (isSetOwnerType()) hashCode = hashCode * 8191 + ownerType.getValue();
/**
        sb.append("tableType:");
        lastComparison = java.lang.Boolean.compare(isSetCreateTime(), other.isSetCreateTime());
            )
                        case 19: // WRITE_ID
    }
    }
        }
    public java.util.Iterator<FieldSchema> getPartitionKeysIterator() {
            case SD:
                            break;
        if (lastComparison != 0) {
        if (!value) {
        if (sd != null) {
                            break;
        _Fields(short thriftId, java.lang.String fieldName) {
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
    }
            case TABLE_TYPE:
            if (this.createTime != that.createTime) return false;
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __REWRITEENABLED_ISSET_ID, value);
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                    struct.setSdIsSet(true);
    public Table setRewriteEnabled(boolean rewriteEnabled) {
        this.lastAccessTime = lastAccessTime;
                } else {
            }
                return lastComparison;
                        case 11: // VIEW_EXPANDED_TEXT
            }
    }
    public void setParametersIsSet(boolean value) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CREATETIME_ISSET_ID);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);
        }
                    unsetCreationMetadata();
        hashCode = hashCode * 8191 + ((isSetRewriteEnabled()) ? 131071 : 524287);
                            }
        return hashCode;
            if (struct.tableName != null) {
            _Fields.DB_NAME,
        lastComparison = java.lang.Boolean.compare(isSetPrivileges(), other.isSetPrivileges());
            java.util.List<FieldSchema> __this__partitionKeys = new java.util.ArrayList<FieldSchema>(other.partitionKeys.size());
            _Fields.CREATION_METADATA,
        return this.ownerType;
    private static final org.apache.thrift.protocol.TField REWRITE_ENABLED_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    unsetLastAccessTime();
     * @see PrincipalType
            privileges.validate();
            _Fields.VIEW_EXPANDED_TEXT,
            sb.append(this.sd);
    private static final org.apache.thrift.protocol.TField OWNER_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public Table deepCopy() {
                return getCreationMetadata();
        /**
            }
        tmpMap.put(
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                            }
    }
            sb.append(this.viewOriginalText);
                return lastComparison;
    /** Returns true if field owner is set (has been assigned a value) and false otherwise */
        org.apache.thrift.protocol.TType.STRUCT,
                break;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    @org.apache.thrift.annotation.Nullable
            sb.append(this.dbName);
        sb.append(this.createTime);
    public int lastAccessTime; // required
    }
        if (isSetCreationMetadata()) {
            if (struct.isSetParameters()) {
                                struct.setTemporaryIsSet(true);
        if (other.isSetDbName()) {
            case RETENTION:
    public void unsetRetention() {
                            } else {
            case CREATION_METADATA:
                    struct.setCreationMetadataIsSet(true);
                    struct.rewriteEnabled = iprot.readBool();
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
            )
                    );
        if (this.viewExpandedText == null) {
    private static class TableStandardScheme extends org.apache.thrift.scheme.StandardScheme<Table> {
                                struct.retention = iprot.readI32();
                }
            this.sd = new StorageDescriptor(other.sd);
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
    public boolean isSetCatName() {
            oprot.writeStructEnd();
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        lastComparison = java.lang.Boolean.compare(isSetParameters(), other.isSetParameters());
            if (struct.isSetDbName()) {
                return isTemporary();
        }
                oprot.writeI32(struct.createTime);
            return lastComparison;
        hashCode = hashCode * 8191 + ((isSetPartitionKeys()) ? 131071 : 524287);
                        case 3: // OWNER
                break;
                    unsetWriteId();
        org.apache.thrift.protocol.TType.STRING,
        first = false;
            __isset_bitfield = 0;
        this.ownerType = null;
            }
    }
            this.partitionKeys = null;
            new org.apache.thrift.meta_data.FieldMetaData(
                break;
        setRewriteEnabledIsSet(false);
        }
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RETENTION_ISSET_ID, value);
        if (isSetParameters()) hashCode = hashCode * 8191 + parameters.hashCode();
                            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
                return getCatName();
            return lastComparison;
                        )
        if (this.tableType == null) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        if (isSetOwner()) hashCode = hashCode * 8191 + owner.hashCode();
                                struct.setRewriteEnabledIsSet(true);
                    oprot.writeFieldEnd();
                if (incoming.get(4)) {
                return lastComparison;
        setWriteIdIsSet(true);
            }
        this.parameters = parameters;
    public Table(Table other) {
            if (!this.owner.equals(that.owner)) return false;
        if (!first) sb.append(", ");
    }
        );
        this.partitionKeys = null;
                                struct.setCreateTimeIsSet(true);
        first = false;
                }
    }
        }
            java.util.BitSet optionals = new java.util.BitSet();
        (short) 7
                return getParameters();
                }
                return lastComparison;
        boolean that_present_writeId = true && that.isSetWriteId();
                            }
            if (lastComparison != 0) {
        this.retention = retention;
                            } else {
                }
                )
            return _fieldName;
        }
    }
                break;
        if (isSetCreationMetadata()) {
    }
        this.retention = retention;
                case 14: // TEMPORARY
            return lastComparison;
        _Fields.WRITE_ID };
        REWRITE_ENABLED((short) 15, "rewriteEnabled"),
        }
            if (!this.sd.equals(that.sd)) return false;
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __REWRITEENABLED_ISSET_ID);
         *
    public java.util.Map<java.lang.String, java.lang.String> getParameters() {
                                struct.owner = iprot.readString();
            if (lastComparison != 0) {
            this.dbName = null;
        if (!first) sb.append(", ");
                    struct.viewOriginalText = iprot.readString();
                                    for (int _i118 = 0; _i118 < _list116.size; ++_i118) {
                sb.append(this.creationMetadata);
                    setRewriteEnabled((java.lang.Boolean) value);
                                struct.setOwnerIsSet(true);
                                struct.tableName = iprot.readString();
        this.viewExpandedText = viewExpandedText;
                                struct.creationMetadata = new CreationMetadata();
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TableStandardSchemeFactory();
            sb.append("null");
            case LAST_ACCESS_TIME:
        try {
                new org.apache.thrift.meta_data.MapMetaData(
    }
    @Override
            if (struct.tableType != null) {
        setLastAccessTimeIsSet(true);
    @org.apache.thrift.annotation.Nullable
        this.viewOriginalText = null;
        @Override
        }
                if (value == null) {
    @org.apache.thrift.annotation.Nullable
            return getClass().getName().compareTo(other.getClass().getName());
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public void unsetTableName() {
        public void write(org.apache.thrift.protocol.TProtocol oprot, Table struct) throws org.apache.thrift.TException {
    /** Returns true if field creationMetadata is set (has been assigned a value) and false otherwise */
        if (other.isSetCreationMetadata()) {
    public void unsetCreateTime() {
        if (isSetPrivileges()) hashCode = hashCode * 8191 + privileges.hashCode();
        if (isSetTemporary()) {
                            }
    }
        lastComparison = java.lang.Boolean.compare(isSetCatName(), other.isSetCatName());
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
    public void clear() {
                sb.append(this.catName);
        boolean this_present_partitionKeys = true && this.isSetPartitionKeys();
                if (value == null) {
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    public int hashCode() {
                } else {
                                struct.ownerType = org.opensearch.plugin.hive.metastore.PrincipalType.findByValue(iprot.readI32());
        }
                            break;
                oprot.writeFieldEnd();
        lastComparison = java.lang.Boolean.compare(isSetDbName(), other.isSetDbName());
            prot.incrementRecursionDepth();
        this.parameters = null;
                    oprot.writeFieldBegin(OWNER_TYPE_FIELD_DESC);
    public Table setParameters(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters) {
    /**
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
    private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
    public java.lang.Object getFieldValue(_Fields field) {
        return this.owner != null;
    @Override
        return this.parameters != null;
            sb.append("null");
        }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
                    return REWRITE_ENABLED;
        boolean that_present_lastAccessTime = true;
        if (isSetDbName()) {
        }
                    struct.retention = iprot.readI32();
            if (!(this_present_ownerType && that_present_ownerType)) return false;
        @Override
    public void putToParameters(java.lang.String key, java.lang.String val) {
                        }
        setRetentionIsSet(false);
            if (struct.isSetRewriteEnabled()) {
                if (incoming.get(8)) {
                oprot.writeFieldBegin(WRITE_ID_FIELD_DESC);
        }
            if (!(this_present_catName && that_present_catName)) return false;
            oprot.writeBitSet(optionals, 19);
            if (struct.isSetRewriteEnabled()) {
        boolean this_present_retention = true;
            case PARTITION_KEYS:
                return lastComparison;
            this.ownerType = null;
            this.sd = null;
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    }
        if (isSetRewriteEnabled()) {
    public @org.apache.thrift.annotation.Nullable java.util.List<FieldSchema> partitionKeys; // required
            )
    }
                            break;
        boolean that_present_privileges = true && that.isSetPrivileges();
                }
            if (!(this_present_lastAccessTime && that_present_lastAccessTime)) return false;
        org.apache.thrift.protocol.TType.MAP,
                return isSetTemporary();
                oprot.writeString(struct.viewExpandedText);
        "privileges",
        }
        LAST_ACCESS_TIME((short) 5, "lastAccessTime"),
        "lastAccessTime",
        (short) 14
                            } else {
        return false;
    public boolean equals(Table that) {
            case LAST_ACCESS_TIME:
        }
            }
        }
                    oprot.writeListEnd();
        tmpMap.put(
        return this.createTime;
    /** Returns true if field catName is set (has been assigned a value) and false otherwise */
        return this.parameters;
                optionals.set(1);
            if (!(this_present_creationMetadata && that_present_creationMetadata)) return false;
    }
                oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastAccessTime, other.lastAccessTime);
        // check for required fields
        this.viewExpandedText = null;
            case OWNER:
            }
                default:
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID);
        scheme(oprot).write(oprot, this);
        if (other.isSetOwner()) {
                }
                case 4: // CREATE_TIME
        return this.ownerType != null;
                }
                "owner",
        if (!value) {
                if (value == null) {
    public boolean isSetTableName() {
        if (isSetViewExpandedText()) {
            }
        }
                new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PrincipalType.class)
            _Fields.TABLE_TYPE,
                            _val132 = iprot.readString();
    public CreationMetadata getCreationMetadata() {
            _Fields.PRIVILEGES,
                if (incoming.get(9)) {
    }
         * @see PrincipalType
        }
    public void setTemporaryIsSet(boolean value) {
                    unsetParameters();
            }
        if (this.partitionKeys == null) {
    public boolean isSetLastAccessTime() {
                }
                            } else {
                if (incoming.get(1)) {
            }
            this.tableName = null;
        WRITE_ID((short) 19, "writeId");
                optionals.set(13);
        (short) 9
        boolean this_present_tableName = true && this.isSetTableName();
        if (lastComparison != 0) {
                    unsetSd();
        first = false;
                    setViewExpandedText((java.lang.String) value);
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    private static final org.apache.thrift.protocol.TField VIEW_EXPANDED_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField(
                java.util.BitSet incoming = iprot.readBitSet(19);
                    unsetOwnerType();
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            _Fields.CREATE_TIME,
        }
            }
        );
        lastComparison = java.lang.Boolean.compare(isSetWriteId(), other.isSetWriteId());
        first = false;
        (short) 12
                    return PRIVILEGES;
                            _elem128.read(iprot);
                case 12: // TABLE_TYPE
            }
        setWriteIdIsSet(false);
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TableTupleSchemeFactory();
    );
            case REWRITE_ENABLED:
            sb.append("null");
            this.creationMetadata = new CreationMetadata(other.creationMetadata);
        public static _Fields findByName(java.lang.String name) {
                    oprot.writeI32(struct.ownerType.getValue());
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        }
        } else {
    }
        if (!value) {
        static {
    private static final org.apache.thrift.protocol.TField WRITE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField(
    private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            case SD:
        if (other.isSetPartitionKeys()) {
        org.apache.thrift.protocol.TType.STRUCT,
        if (this.partitionKeys == null) {
                }
    public boolean isSetPrivileges() {
            )
            creationMetadata.validate();
            }
    }
            case OWNER_TYPE:
        boolean that_present_parameters = true && that.isSetParameters();
                oprot.writeFieldBegin(PARTITION_KEYS_FIELD_DESC);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        this.parameters = parameters;
    );
        }
        }
        } else {
        lastComparison = java.lang.Boolean.compare(isSetViewOriginalText(), other.isSetViewOriginalText());
                            break;
            new org.apache.thrift.meta_data.FieldMetaData(
                if (struct.isSetOwnerType()) {
    }
                sb.append("null");
        /**
    }
                return lastComparison;
    );
    private static final org.apache.thrift.protocol.TField PRIVILEGES_FIELD_DESC = new org.apache.thrift.protocol.TField(
        hashCode = hashCode * 8191 + ((isSetTableType()) ? 131071 : 524287);
    static {
    /** Returns true if field retention is set (has been assigned a value) and false otherwise */
                        case 10: // VIEW_ORIGINAL_TEXT
        }
        this.catName = null;
        (short) 4
        }
    }
                oprot.writeString(struct.dbName);
        if (isSetSd()) hashCode = hashCode * 8191 + sd.hashCode();
            case WRITE_ID:
        int retention,
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        OWNER((short) 3, "owner"),
        hashCode = hashCode * 8191 + createTime;
                            _elem128 = new FieldSchema();
        }
            sb.append("null");
        boolean this_present_privileges = true && this.isSetPrivileges();
        _Fields.CREATION_METADATA,
        );
                    oprot.writeI32(struct.partitionKeys.size());
            }
                            } else {
            new org.apache.thrift.meta_data.FieldMetaData(
    );
                sb.append(this.ownerType);
                    switch (schemeField.id) {
                optionals.set(17);
        }
                sb.append("null");
            if (struct.partitionKeys != null) {
                return isSetSd();
        this.viewExpandedText = null;
            sb.append(this.owner);
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        lastComparison = java.lang.Boolean.compare(isSetCreationMetadata(), other.isSetCreationMetadata());
            try {
        sb.append("createTime:");
    public Table setWriteId(long writeId) {
                                    struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map119.size);
    /**
            if (!(this_present_viewOriginalText && that_present_viewOriginalText)) return false;
        }
        );
    public boolean rewriteEnabled; // optional
    @org.apache.thrift.annotation.Nullable
            case VIEW_ORIGINAL_TEXT:
                        }
        this.sd = sd;
        if (lastComparison != 0) {
        sb.append("viewExpandedText:");
                            _key131 = iprot.readString();
            if (struct.isSetCreationMetadata()) {
    public void validate() throws org.apache.thrift.TException {
                        java.lang.String _key131;
                }
    @org.apache.thrift.annotation.Nullable
                } else {
        (short) 2
        if (other.isSetTableType()) {
            case PARTITION_KEYS:
        first = false;
    }
                        @org.apache.thrift.annotation.Nullable
        }
                case 6: // RETENTION
        if (this_present_createTime || that_present_createTime) {
        }
        }
        }
        }
            }
                return getWriteId();
                optionals.set(6);
        }
                case 10: // VIEW_ORIGINAL_TEXT
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.privileges, other.privileges);
        this.catName = null;
    public Table(
            oprot.writeFieldBegin(RETENTION_FIELD_DESC);
        "createTime",
    public boolean isSetParameters() {
                    struct.createTime = iprot.readI32();
        "catName",
            if (!(this_present_rewriteEnabled && that_present_rewriteEnabled)) return false;
            this.partitionKeys = __this__partitionKeys;
        }
                        case 13: // PRIVILEGES
                byName.put(field.getFieldName(), field);
                break;
        this.tableName = null;
            if (!this.catName.equals(that.catName)) return false;
    }
        if (isSetParameters()) {
    }
        }
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            if (!(this_present_parameters && that_present_parameters)) return false;
                __this__partitionKeys.add(new FieldSchema(other_element));
            }
        return this;
        tmpMap.put(
        );
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
            throw new java.io.IOException(te);
                if (incoming.get(15)) {
        }
        public void read(org.apache.thrift.protocol.TProtocol iprot, Table struct) throws org.apache.thrift.TException {
        }
                return isSetRewriteEnabled();
                return lastComparison;
            sb.append(this.temporary);
            if (struct.owner != null) {
        }
            return lastComparison;
                } else {
    /** Returns true if field createTime is set (has been assigned a value) and false otherwise */
            case PRIVILEGES:
                if (incoming.get(18)) {
        if (isSetRewriteEnabled()) {
                return isSetPrivileges();
            first = false;
        }
                                struct.catName = iprot.readString();
        if (isSetPrivileges()) {
        first = false;
    public int compareTo(Table other) {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            if (!(this_present_privileges && that_present_privileges)) return false;
            if (struct.isSetTemporary()) {
            oprot.writeFieldEnd();
        setTemporaryIsSet(false);
                }
        this.retention = other.retention;
        }
        if (!first) sb.append(", ");
            }
            }
        if (isSetViewOriginalText()) hashCode = hashCode * 8191 + viewOriginalText.hashCode();
        this.rewriteEnabled = other.rewriteEnabled;
                "tableName",
            if (this.writeId != that.writeId) return false;
                oprot.writeString(struct.viewExpandedText);
                            struct.parameters.size()
        throw new java.lang.IllegalStateException();
    }
                oprot.writeBool(struct.temporary);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
     * @see PrincipalType
        }
                                    java.lang.String _key120;
            sb.append("null");
                    setTableType((java.lang.String) value);
    }
        return this.dbName != null;
                // check for required fields of primitive type, which can't be checked in the validate method
                return getSd();
        sb.append("tableName:");
    );
        }
                oprot.writeFieldEnd();
                if (value == null) {
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        (short) 8
            if (!(this_present_writeId && that_present_writeId)) return false;
                        FieldSchema _elem128;
            return byName.get(name);
                                struct.setViewExpandedTextIsSet(true);
        if (!first) sb.append(", ");
        return (this.partitionKeys == null) ? null : this.partitionKeys.iterator();
        setLastAccessTimeIsSet(false);
            return lastComparison;
                } else {
        }
            if (lastComparison != 0) {
        this.parameters.put(key, val);
                return getViewExpandedText();
        if (!value) {
            case OWNER:
    }
        if (other.isSetPrivileges()) {
            return lastComparison;
            }
                }
            first = false;
            if (!this.dbName.equals(that.dbName)) return false;
        return true;
    /** Returns true if field rewriteEnabled is set (has been assigned a value) and false otherwise */
        sb.append("retention:");
    }
            if (struct.isSetTableType()) {
        first = false;
            case REWRITE_ENABLED:
    /** Returns true if field lastAccessTime is set (has been assigned a value) and false otherwise */
                        struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map130.size);
    }
            new org.apache.thrift.meta_data.FieldMetaData(
        (short) 15
    }
        hashCode = hashCode * 8191 + ((isSetSd()) ? 131071 : 524287);
        @Override
        hashCode = hashCode * 8191 + ((isSetPrivileges()) ? 131071 : 524287);
                "lastAccessTime",
    public void setOwnerTypeIsSet(boolean value) {
        public java.lang.String getFieldName() {
            sb.append(this.partitionKeys);
        this.owner = owner;
    public void setPartitionKeysIsSet(boolean value) {
        );
    public void unsetViewOriginalText() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __WRITEID_ISSET_ID);
        tmpMap.put(
    private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField(
        boolean this_present_owner = true && this.isSetOwner();
        }
            }
            } else {
                }
                if (value == null) {
                return isSetRetention();
                    oprot.writeFieldEnd();
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableType, other.tableType);
        this.sd = null;
        if (other.isSetTableName()) {
            if (struct.isSetViewOriginalText()) {
            if (struct.isSetTemporary()) {
                    struct.creationMetadata = new CreationMetadata();
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
    public void unsetRewriteEnabled() {
    }
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FieldSchema.class)
                } else {
                }
                "createTime",
            }
        }
            if (!this.creationMetadata.equals(that.creationMetadata)) return false;
        /**
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        this.owner = null;
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CREATETIME_ISSET_ID);
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)
        java.lang.String owner,
        }
                return getRetention();
                                    FieldSchema _elem117;
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    @Override
                if (incoming.get(7)) {
            return lastComparison;
                optionals.set(2);
                } else {
                            } else {
            }
                }
        if (this_present_viewExpandedText || that_present_viewExpandedText) {
        return this.temporary;
                    }
                optionals.set(8);
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)
        if (lastComparison != 0) {
            sb.append(this.tableType);
        boolean that_present_retention = true;
                        @org.apache.thrift.annotation.Nullable
        if (this_present_creationMetadata || that_present_creationMetadata) {
        this.temporary = false;
            }
    public boolean isSet(_Fields field) {
        boolean that_present_sd = true && that.isSetSd();
    public java.lang.String toString() {
        (short) 13
            _Fields.PARAMETERS,
                    setCreateTime((java.lang.Integer) value);
                    oprot.writeMapEnd();
                    return WRITE_ID;
        boolean this_present_lastAccessTime = true;
        }
    public @org.apache.thrift.annotation.Nullable java.lang.String tableType; // required
     */
        }
        // check for sub-struct validity
                    struct.creationMetadata.read(iprot);
     */
        if (lastComparison != 0) {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
            if (!(this_present_tableName && that_present_tableName)) return false;
        if (!value) {
        if (isSetTemporary()) {
            case PARAMETERS:
        }
        this.partitionKeys = null;
            if (struct.isSetSd()) {
                }
    public void setOwnerIsSet(boolean value) {
                    return PARTITION_KEYS;
        _Fields.CAT_NAME,
                    setParameters((java.util.Map<java.lang.String, java.lang.String>) value);
    }
            }
                oprot.writeFieldEnd();
    public boolean isSetViewExpandedText() {
    }
            return lastComparison;
     */
                break;
        RETENTION((short) 6, "retention"),
                    struct.setCatNameIsSet(true);
                    setOwner((java.lang.String) value);
        "viewExpandedText",
                oprot.writeFieldEnd();
        public void write(org.apache.thrift.protocol.TProtocol prot, Table struct) throws org.apache.thrift.TException {
                    struct.setTableNameIsSet(true);
    /** Returns true if field temporary is set (has been assigned a value) and false otherwise */
            if (!first) sb.append(", ");
                            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
    public boolean isSetCreateTime() {
    }
                            break;
        if (lastComparison != 0) {
                case 13: // PRIVILEGES
                }
                    setSd((StorageDescriptor) value);
            _Fields,
                oprot.writeString(struct.tableType);
        this.lastAccessTime = other.lastAccessTime;
        }
    }
            if (!(this_present_tableType && that_present_tableType)) return false;
                "retention",
        return this;
                if (struct.isSetCreationMetadata()) {
        return this;
        return this.owner;
                optionals.set(3);
        }
                    unsetPartitionKeys();
                return getTableType();
        if (this.owner == null) {
    public boolean isSetPartitionKeys() {
                return lastComparison;
    public void addToPartitionKeys(FieldSchema elem) {
                return getPartitionKeys();
                return isSetCreationMetadata();
        switch (field) {
            }
                }
                    );
        if (this_present_catName || that_present_catName) {
                    oprot.writeFieldBegin(CREATION_METADATA_FIELD_DESC);
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                            }
        SD((short) 7, "sd"),
            }
        java.lang.String tableType
            } else {
    }
    }
        } else {
                if (incoming.get(14)) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
    private static final int __WRITEID_ISSET_ID = 5;
                oprot.writeFieldEnd();
                java.lang.String,
    public void unsetParameters() {
        boolean this_present_tableType = true && this.isSetTableType();
            } else {
    public Table setPartitionKeys(@org.apache.thrift.annotation.Nullable java.util.List<FieldSchema> partitionKeys) {
                        break;
    public @org.apache.thrift.annotation.Nullable PrincipalType ownerType; // optional
    }
                struct.validate();
                }
        private final short _thriftId;
                                    }
            switch (fieldId) {
        TEMPORARY((short) 14, "temporary"),
        setRetentionIsSet(true);
        return this;
                "parameters",
        org.apache.thrift.protocol.TType.I64,
        hashCode = hashCode * 8191 + ((isSetViewExpandedText()) ? 131071 : 524287);
                "dbName",
                    setRetention((java.lang.Integer) value);
                return getOwnerType();
        }
    public java.util.List<FieldSchema> getPartitionKeys() {
    public boolean isSetTableType() {
        /**
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                } else {
        if (!value) {
            new org.apache.thrift.meta_data.FieldMetaData(
                    struct.ownerType = org.opensearch.plugin.hive.metastore.PrincipalType.findByValue(iprot.readI32());
        boolean that_present_creationMetadata = true && that.isSetCreationMetadata();
        if (this_present_tableName || that_present_tableName) {
        if (lastComparison != 0) {
    @Override
    }
            if (this.privileges == null) {
                                struct.viewExpandedText = iprot.readString();
                    unsetViewOriginalText();
        this.catName = catName;
    public StorageDescriptor getSd() {
            if (struct.isSetParameters()) {
                        case 1: // TABLE_NAME
        switch (field) {
            _Fields.OWNER,
                case 15: // REWRITE_ENABLED
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.owner, other.owner);
     *
                                struct.privileges = new PrincipalPrivilegeSet();
            _Fields.CAT_NAME,
                    setCreationMetadata((CreationMetadata) value);
                if (value == null) {
        sb.append("owner:");
                if (value == null) {
    /** Returns true if field writeId is set (has been assigned a value) and false otherwise */
            this.tableName = other.tableName;
        this.owner = owner;
                            }
                            break;
    }
        } else {
        java.util.Map<java.lang.String, java.lang.String> parameters,
                oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);
            if (struct.isSetOwner()) {
                return lastComparison;
                optionals.set(14);
    public void setTableTypeIsSet(boolean value) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        if (isSetCreateTime()) {
                }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rewriteEnabled, other.rewriteEnabled);
                    oprot.writeI32(struct.parameters.size());
            return lastComparison;
                    struct.privileges.write(oprot);
            case CAT_NAME:
        }
        (short) 1
                    oprot.writeFieldEnd();
            for (FieldSchema other_element : other.partitionKeys) {
        public short getThriftFieldId() {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        if (other.isSetParameters()) {
    @Override
    }
                                        struct.parameters.put(_key120, _val121);
        this.rewriteEnabled = rewriteEnabled;
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        tmpMap.put(
            if (struct.isSetTemporary()) {
                    return OWNER;
            }
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
    public long writeId; // optional
                optionals.set(11);
    }
        "retention",
    @Override
                        case 7: // SD
            }
        setCreateTimeIsSet(true);
        }
                    oprot.writeFieldBegin(PRIVILEGES_FIELD_DESC);
    );
        boolean first = true;
                        oprot.writeString(_iter124.getKey());
        if (that instanceof Table) return this.equals((Table) that);
                {
                if (value == null) {
    public int getRetention() {
            case PARTITION_KEYS:
        if (lastComparison != 0) {
        java.lang.String tableName,
                if (value == null) {
            try {
                break;
                                struct.setCreationMetadataIsSet(true);
        }
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    public @org.apache.thrift.annotation.Nullable java.lang.String viewOriginalText; // required
        }
        } catch (org.apache.thrift.TException te) {
                    return CREATION_METADATA;
        return this.viewExpandedText != null;
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                                struct.dbName = iprot.readString();
                                struct.setTableNameIsSet(true);
    }
            if (this.catName == null) {
    private static final int __RETENTION_ISSET_ID = 2;
        boolean this_present_createTime = true;
    @org.apache.thrift.annotation.Nullable
                } else {
            )
            if (struct.isSetPartitionKeys()) {
                    oprot.writeMapBegin(
            sb.append("null");
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                    struct.creationMetadata.write(oprot);
                oprot.writeI64(struct.writeId);
        TABLE_NAME((short) 1, "tableName"),
        this.writeId = 0;
        this.dbName = null;
                        oprot.writeString(_iter126.getValue());
                return isSetOwner();
            return lastComparison;
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                    return VIEW_EXPANDED_TEXT;
    public Table setTableType(@org.apache.thrift.annotation.Nullable java.lang.String tableType) {
                if (incoming.get(13)) {
                            } else {
        boolean that_present_createTime = true;
        );
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter126 : struct.parameters.entrySet()) {
        if (isSetOwner()) {
        setCreateTimeIsSet(true);
                optionals.set(18);
                    struct.sd.read(iprot);
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            if (!(this_present_partitionKeys && that_present_partitionKeys)) return false;
    @org.apache.thrift.annotation.Nullable
            struct.validate();
                }
        if (isSetTableType()) {
                "tableType",
            sb.append("privileges:");
            }
        return this;
        }
                            }
                "writeId",
            first = false;
        }
            )
                    struct.setRetentionIsSet(true);
        if (!getClass().equals(other.getClass())) {
        org.apache.thrift.protocol.TType.BOOL,
    }
    }
    @org.apache.thrift.annotation.Nullable
    public @org.apache.thrift.annotation.Nullable PrincipalPrivilegeSet privileges; // optional
            )
        if (isSetRewriteEnabled()) hashCode = hashCode * 8191 + ((rewriteEnabled) ? 131071 : 524287);
        if (!value) {
                oprot.writeFieldBegin(OWNER_FIELD_DESC);
        if (isSetTableType()) hashCode = hashCode * 8191 + tableType.hashCode();
                oprot.writeString(struct.owner);
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __REWRITEENABLED_ISSET_ID);
    public void setViewOriginalTextIsSet(boolean value) {
            } else {
        org.apache.thrift.protocol.TType.I32,
        );
            if (!this.ownerType.equals(that.ownerType)) return false;
                case 3: // OWNER
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
        return this;
    public boolean isSetCreationMetadata() {
                    struct.tableType = iprot.readString();
        this.owner = null;
                            break;
        }
                    oprot.writeString(struct.catName);
        first = false;
            if (!(this_present_temporary && that_present_temporary)) return false;
            if (!this.viewExpandedText.equals(that.viewExpandedText)) return false;
            case TEMPORARY:
        if (!value) {
                iprot.readStructEnd();
    @org.apache.thrift.annotation.Nullable
                            struct.partitionKeys.add(_elem128);
    }
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
        lastComparison = java.lang.Boolean.compare(isSetTemporary(), other.isSetTemporary());
            case DB_NAME:
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __WRITEID_ISSET_ID, value);
        }
                return lastComparison;
    public Table setSd(@org.apache.thrift.annotation.Nullable StorageDescriptor sd) {
        if (!value) {
                oprot.writeI32(struct.ownerType.getValue());
        }
        this.ownerType = ownerType;
            }
        this.tableName = tableName;
                    struct.lastAccessTime = iprot.readI32();
        if (!first) sb.append(", ");
        );
                                struct.setLastAccessTimeIsSet(true);
            }
        tmpMap.put(
        boolean this_present_viewOriginalText = true && this.isSetViewOriginalText();
                    struct.setWriteIdIsSet(true);
        return this;
            return lastComparison;
                if (value == null) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    @Override
                } else {
        lastComparison = java.lang.Boolean.compare(isSetViewExpandedText(), other.isSetViewExpandedText());
    @Override
                if (incoming.get(3)) {
                                struct.temporary = iprot.readBool();
        }
            if (struct.isSetWriteId()) {
                    struct.setDbNameIsSet(true);
        }
                                struct.sd = new StorageDescriptor();
                                struct.setViewOriginalTextIsSet(true);
    @org.apache.thrift.annotation.Nullable
                                struct.setOwnerTypeIsSet(true);
    }
        }
            if (!first) sb.append(", ");
                    }
        return this;
                    {
                            }
        @org.apache.thrift.annotation.Nullable
            }
        this.sd = sd;
                oprot.writeString(struct.viewOriginalText);
        this.createTime = other.createTime;
    }
        if (this.sd == null) {
            )
        (short) 16
            case TABLE_TYPE:
        "temporary",
                    unsetTableName();
            new org.apache.thrift.meta_data.FieldMetaData(
        return this.privileges;
            this.tableType = other.tableType;
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        sb.append("lastAccessTime:");
            if (struct.dbName != null) {
            if (this.temporary != that.temporary) return false;
        boolean that_present_catName = true && that.isSetCatName();
            if (lastComparison != 0) {
                            break;
        first = false;
                            break;
        boolean that_present_partitionKeys = true && that.isSetPartitionKeys();
        return this.sd != null;
        tmpMap.put(
        if (isSetWriteId()) {
            if (struct.isSetOwner()) {
        lastComparison = java.lang.Boolean.compare(isSetTableName(), other.isSetTableName());
                                struct.tableType = iprot.readString();
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrincipalPrivilegeSet.class)
        boolean this_present_dbName = true && this.isSetDbName();
        if (other.isSetOwnerType()) {
        CREATION_METADATA((short) 16, "creationMetadata"),
    public boolean isSetDbName() {
            this.privileges = null;
    }
     *
        if (other.isSetViewOriginalText()) {
     * @see PrincipalType
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TEMPORARY_ISSET_ID, value);
 */
        boolean this_present_sd = true && this.isSetSd();
                    struct.setOwnerTypeIsSet(true);
            case CREATE_TIME:
        return _Fields.findByThriftId(fieldId);
            java.util.Map<java.lang.String, java.lang.String> __this__parameters = new java.util.HashMap<
            }
    public @org.apache.thrift.annotation.Nullable java.lang.String tableName; // required
    public int getParametersSize() {
        tmpMap.put(
                iprot.readStructBegin();
            return lastComparison;
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        sb.append(this.lastAccessTime);
            }
        }
                    unsetTemporary();
                        case 15: // REWRITE_ENABLED
        org.apache.thrift.protocol.TType.STRING,
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CREATETIME_ISSET_ID, value);
                        case 14: // TEMPORARY
            )
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID);
    }
                            break;
                    unsetRetention();
        org.apache.thrift.protocol.TType.LIST,
            return lastComparison;
                        case 12: // TABLE_TYPE
    }
     */
    private static class TableTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            if (struct.isSetViewExpandedText()) {
    public void unsetPartitionKeys() {
        this.lastAccessTime = lastAccessTime;
    }
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RETENTION_ISSET_ID);
                            org.apache.thrift.protocol.TType.STRING,
                return getPrivileges();
        boolean that_present_viewExpandedText = true && that.isSetViewExpandedText();
                }
        }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
            case OWNER_TYPE:
    );
                                struct.creationMetadata.read(iprot);
            _Fields.PARTITION_KEYS,
            if (!first) sb.append(", ");
        if (lastComparison != 0) {
            }
            case CREATE_TIME:
        if (this_present_parameters || that_present_parameters) {
    private static final org.apache.thrift.protocol.TField LAST_ACCESS_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public void setCatNameIsSet(boolean value) {
    /**
    }
                    unsetPrivileges();
                if (value == null) {
            }
public class Table implements org.apache.thrift.TBase<Table, Table._Fields>, java.io.Serializable, Cloneable, Comparable<Table> {
            if (struct.isSetViewOriginalText()) {
        _Fields.REWRITE_ENABLED,
     *
        tmpMap.put(
                oprot.writeString(struct.tableName);
        this.tableName = tableName;
    public void setLastAccessTimeIsSet(boolean value) {
        return this.catName;
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, StorageDescriptor.class)
                optionals.set(5);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            case CREATE_TIME:
            }
                            } else {
            if (struct.isSetTableName()) {
                            break;
        return sb.toString();
            return lastComparison;
            case PRIVILEGES:
        org.apache.thrift.protocol.TType.BOOL,
            oprot.writeFieldBegin(LAST_ACCESS_TIME_FIELD_DESC);
                }
    public boolean isSetRetention() {
        if (isSetCatName()) {
            sb.append("temporary:");
            )
        }
                    unsetRewriteEnabled();
                if (value == null) {
    public Table setOwner(@org.apache.thrift.annotation.Nullable java.lang.String owner) {
            if (struct.isSetPrivileges()) {
    public void setTableNameIsSet(boolean value) {
            if (struct.privileges != null) {
                            } else {
            }
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        @Override
        "sd",
                                        struct.partitionKeys.add(_elem117);
                oprot.writeI64(struct.writeId);
                return lastComparison;
            if (this.lastAccessTime != that.lastAccessTime) return false;
        }
                optionals.set(10);
        first = false;
                    struct.writeId = iprot.readI64();
        }
        "tableName",
         * if it is not found.
        }
    );
         */
        "tableType",
    );
            return lastComparison;
        if (isSetViewExpandedText()) hashCode = hashCode * 8191 + viewExpandedText.hashCode();
        public TableTupleScheme getScheme() {
                                struct.setWriteIdIsSet(true);
            case REWRITE_ENABLED:
            _Fields.SD,
        org.apache.thrift.protocol.TType.STRING,
                "catName",
        return this.viewExpandedText;
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
                if (incoming.get(10)) {
        if (isSetTableName()) hashCode = hashCode * 8191 + tableName.hashCode();
    }
        if (isSetTableName()) {
    public int getLastAccessTime() {
    private static final org.apache.thrift.protocol.TField SD_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
            if (!(this_present_retention && that_present_retention)) return false;
        return this.tableType;
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                "temporary",
                optionals.set(0);
                    return CAT_NAME;
        if (other.isSetCatName()) {
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    struct.privileges.read(iprot);
                            }
        }
                    }
            case TABLE_NAME:
    public int retention; // required
            if (!first) sb.append(", ");
                break;
        return this.privileges != null;
            if (!this.tableName.equals(that.tableName)) return false;
        if (this_present_owner || that_present_owner) {
                }
    );
        this.dbName = dbName;
            }
            this.ownerType = other.ownerType;
            }
            }
    public void setDbNameIsSet(boolean value) {
            this.catName = null;
    public void unsetCatName() {
        scheme(iprot).read(iprot, this);
        tmpMap.put(
                            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
    );
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
                        @org.apache.thrift.annotation.Nullable
        int hashCode = 1;
    public boolean isRewriteEnabled() {
        );
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                    for (FieldSchema _iter125 : struct.partitionKeys) {
        this.rewriteEnabled = false;
    }
    public int getCreateTime() {
        setCreateTimeIsSet(false);
    @org.apache.thrift.annotation.Nullable
    public void setSdIsSet(boolean value) {
        public TableStandardScheme getScheme() {
                sb.append("null");
        lastComparison = java.lang.Boolean.compare(isSetSd(), other.isSetSd());
                            break;
    @Override
                }
                                }
        this.lastAccessTime = 0;
            first = false;
        if (!value) {
        }
        return this.retention;
                    org.apache.thrift.protocol.TType.LIST,
        }
            sb.append("ownerType:");
    }
            case TABLE_NAME:
    }
                }
        _Fields.TEMPORARY,
                }
            }
                } else {
            case PARAMETERS:
            } finally {
        "ownerType",
                        java.lang.String _val132;
            new org.apache.thrift.meta_data.FieldMetaData(
        }
            first = false;
    public Table() {}
                    oprot.writeListBegin(
    }
        }
                            break;
        (short) 6
        int lastComparison = 0;
            return _thriftId;
        return (this.partitionKeys == null) ? 0 : this.partitionKeys.size();
                            }
    public Table setOwnerType(@org.apache.thrift.annotation.Nullable PrincipalType ownerType) {
        }
            this.viewOriginalText = other.viewOriginalText;
    }
        if (isSetWriteId()) {
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters; // required
            }
            case OWNER_TYPE:
                                        _elem117.read(iprot);
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Table");
                                struct.setParametersIsSet(true);
                oprot.writeFieldEnd();
        VIEW_EXPANDED_TEXT((short) 11, "viewExpandedText"),
        @Override
    public Table setRetention(int retention) {
        );
                return lastComparison;
        );
                        case 2: // DB_NAME
    }
                }
                    struct.viewExpandedText = iprot.readString();
    @org.apache.thrift.annotation.Nullable
            new org.apache.thrift.meta_data.FieldMetaData(
        java.lang.String dbName,
                            }
            if (struct.isSetSd()) {
    }
                        );
    }
                    setTableName((java.lang.String) value);
                    struct.setCreateTimeIsSet(true);
        }
    }
    }
                "partitionKeys",
                return isSetTableName();
                                {
    public long getWriteId() {
        return this;
        return this;
                            } else {
        this.temporary = other.temporary;
    public void setCreationMetadataIsSet(boolean value) {
    ) {
        return this.creationMetadata != null;
            oprot.writeFieldEnd();
            }
        tmpMap.put(
        this.viewExpandedText = viewExpandedText;
                break;
            new org.apache.thrift.meta_data.FieldMetaData(
                case 8: // PARTITION_KEYS
                    return TABLE_NAME;
    public void setPrivilegesIsSet(boolean value) {
    @Override
            this.creationMetadata = null;
            }
        }
            }
            sb.append("null");
        } else {
            case RETENTION:
                        case 16: // CREATION_METADATA
        __isset_bitfield = other.__isset_bitfield;
        lastComparison = java.lang.Boolean.compare(isSetOwner(), other.isSetOwner());
                oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
                    return DB_NAME;
                    unsetDbName();
        PARAMETERS((short) 9, "parameters"),
    }
        @org.apache.thrift.annotation.Nullable
        }
            }
            if (struct.isSetPrivileges()) {
        if (isSetWriteId()) hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(writeId);
            oprot.writeI32(struct.retention);
                break;
            if (lastComparison != 0) {
        "creationMetadata",
                oprot.writeString(struct.dbName);
                    struct.setPartitionKeysIsSet(true);
                            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
            oprot.writeFieldEnd();
                return isSetCreateTime();
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                oprot.writeBool(struct.temporary);
        this.retention = 0;
    private static final org.apache.thrift.protocol.TField TEMPORARY_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
                            }
                    setPartitionKeys((java.util.List<FieldSchema>) value);
        hashCode = hashCode * 8191 + ((isSetViewOriginalText()) ? 131071 : 524287);
            )
    }
                }
                }
                } else {
                    oprot.writeFieldBegin(CAT_NAME_FIELD_DESC);
        }
        if (other.isSetViewExpandedText()) {
            case CREATION_METADATA:
                return lastComparison;
        } catch (org.apache.thrift.TException te) {
                if (value == null) {
        tmpMap.put(
        }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.writeId, other.writeId);
            oprot.writeI32(struct.createTime);
            case WRITE_ID:
    }
        sb.append(")");
    }
            new org.apache.thrift.meta_data.FieldMetaData(
        public static _Fields findByThriftId(int fieldId) {
    // isset id assignments
        if (this_present_temporary || that_present_temporary) {
        this.viewOriginalText = viewOriginalText;
                } else {
                }
            this.owner = null;
        }
    public boolean temporary; // optional
            }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, other.tableName);
        return new Table(this);
        boolean this_present_ownerType = true && this.isSetOwnerType();
    }
                break;
    }
            case OWNER:
                        case 9: // PARAMETERS
                case 2: // DB_NAME
            if (struct.isSetOwnerType()) {
                            }
    public java.lang.String getViewExpandedText() {
        if (!first) sb.append(", ");
        }
            }
        if (this_present_sd || that_present_sd) {
        }
            iprot.incrementRecursionDepth();
                struct.sd.write(oprot);
                    }
                                struct.lastAccessTime = iprot.readI32();
        (short) 3
            )
                                {
                return isSetTableType();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)
                return isSetCatName();
        this.privileges = null;
    public boolean isSetOwnerType() {
    /** Returns true if field partitionKeys is set (has been assigned a value) and false otherwise */
                    unsetCreateTime();
    private byte __isset_bitfield = 0;
                if (incoming.get(2)) {
        }
        if (this_present_privileges || that_present_privileges) {
                }
        }
    public Table setViewExpandedText(@org.apache.thrift.annotation.Nullable java.lang.String viewExpandedText) {
            return lastComparison;
                    struct.setLastAccessTimeIsSet(true);
    public boolean isTemporary() {
        if (this.parameters == null) {
        "rewriteEnabled",
        "viewOriginalText",
        if (isSetPrivileges()) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.viewExpandedText, other.viewExpandedText);
        this.createTime = createTime;
        this.privileges = null;
        return this;
        sb.append("viewOriginalText:");
    /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
                    {
            if (lastComparison != 0) {
        boolean that_present_temporary = true && that.isSetTemporary();
        org.apache.thrift.protocol.TType.STRUCT,
    }
        "dbName",
                return isSetDbName();
        this.partitionKeys = partitionKeys;
    /** Returns true if field ownerType is set (has been assigned a value) and false otherwise */
                } else {
        hashCode = hashCode * 8191 + ((isSetParameters()) ? 131071 : 524287);
        (short) 18
                }
                    }
            this.viewOriginalText = null;
        }
            }
    );
            .getScheme();
        switch (field) {
        if (isSetOwnerType()) {
            if (this.creationMetadata == null) {
            new org.apache.thrift.meta_data.FieldMetaData(
        if (!first) sb.append(", ");
                } else {
        tmpMap.put(
        }
        return this.writeId;
                        for (int _i133 = 0; _i133 < _map130.size; ++_i133) {
    }
        }
    }
                return lastComparison;
                    return VIEW_ORIGINAL_TEXT;
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        }
            if (!this.privileges.equals(that.privileges)) return false;
                }
                        case 8: // PARTITION_KEYS
        if (this_present_rewriteEnabled || that_present_rewriteEnabled) {
        this.viewOriginalText = viewOriginalText;
        );
        }
                oprot.writeFieldBegin(REWRITE_ENABLED_FIELD_DESC);
        if (!first) sb.append(", ");
        if (that == null) return false;
                                    @org.apache.thrift.annotation.Nullable
            _Fields.RETENTION,
            sb.append("catName:");
                oprot.writeFieldBegin(VIEW_ORIGINAL_TEXT_FIELD_DESC);
            case TABLE_NAME:
        return this.sd;
        this.tableType = null;
                        case 6: // RETENTION
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    public int createTime; // required
        if (lastComparison != 0) {
                return getOwner();
            sb.append(this.viewExpandedText);
                "creationMetadata",
                return isSetLastAccessTime();
                    struct.temporary = iprot.readBool();
            sb.append(this.parameters);
            _Fields.LAST_ACCESS_TIME,
                return lastComparison;
    }
            case VIEW_EXPANDED_TEXT:
            }
    public PrincipalPrivilegeSet getPrivileges() {
        if (isSetDbName()) hashCode = hashCode * 8191 + dbName.hashCode();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                case 11: // VIEW_EXPANDED_TEXT
                return getLastAccessTime();
            _Fields fields = findByThriftId(fieldId);
        return this;
            if (struct.isSetRetention()) {
        return this.viewOriginalText != null;
        hashCode = hashCode * 8191 + ((isSetDbName()) ? 131071 : 524287);
        }
            this.owner = other.owner;
                            } else {
            }
                                struct.setCatNameIsSet(true);
                                struct.viewOriginalText = iprot.readString();
            if (lastComparison != 0) {
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
                break;
                struct.privileges.write(oprot);
        );
        if (this.parameters == null) {
    @org.apache.thrift.annotation.Nullable
                if (incoming.get(6)) {
                return lastComparison;
                    return PARAMETERS;
            if (lastComparison != 0) {
            return lastComparison;
        boolean that_present_rewriteEnabled = true && that.isSetRewriteEnabled();
            if (struct.isSetCreateTime()) {
        if (this_present_partitionKeys || that_present_partitionKeys) {
        CAT_NAME((short) 17, "catName"),
                }
    }
    public void setViewExpandedTextIsSet(boolean value) {
                new org.apache.thrift.meta_data.ListMetaData(
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                    unsetTableType();
        boolean that_present_tableName = true && that.isSetTableName();
                    return LAST_ACCESS_TIME;
        if (this.tableName == null) {
                    struct.setTableTypeIsSet(true);
        if (this_present_ownerType || that_present_ownerType) {
        boolean this_present_rewriteEnabled = true && this.isSetRewriteEnabled();
                    struct.setViewExpandedTextIsSet(true);
                    struct.privileges = new PrincipalPrivilegeSet();
                                struct.createTime = iprot.readI32();
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
                                struct.sd.read(iprot);
                )
    }
    public java.lang.String getTableName() {
    );
            this.parameters = new java.util.HashMap<java.lang.String, java.lang.String>();
