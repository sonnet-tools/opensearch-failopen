            _Fields.SD,
                "owner",
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TEMPORARY_ISSET_ID, value);
            case DB_NAME:
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ownerType, other.ownerType);
            sb.append(this.sd);  
            }  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.viewOriginalText, other.viewOriginalText);  
    public void putToParameters(java.lang.String key, java.lang.String val) {  
            sb.append("null");
        tmpMap.put(  
                            _elem128.read(iprot);
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __REWRITEENABLED_ISSET_ID);
         * @see PrincipalType  
            if (struct.isSetViewOriginalText()) {
            if (!this.ownerType.equals(that.ownerType)) return false;  
                "privileges",
        @Override
        return this.catName != null;  
            creationMetadata.validate();
                if (value == null) {  
                if (value == null) {  
                    }
                }
        tmpMap.put(
                                    @org.apache.thrift.annotation.Nullable
        sb.append("tableType:");  
        if (this_present_viewOriginalText || that_present_viewOriginalText) {
        if (this_present_creationMetadata || that_present_creationMetadata) {
                                struct.setViewOriginalTextIsSet(true);  
        if (isSetPrivileges()) {
    }
            }
            case CREATE_TIME:
    /** Returns true if field rewriteEnabled is set (has been assigned a value) and false otherwise */
                return getOwnerType();  
        "parameters",
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
            return getClass().getName().compareTo(other.getClass().getName());
                    }  
    @org.apache.thrift.annotation.Nullable
    public java.lang.Object getFieldValue(_Fields field) {  
        this.dbName = null;
        org.apache.thrift.protocol.TType.I32,
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CREATETIME_ISSET_ID, value);
    @org.apache.thrift.annotation.Nullable
    /** Returns true if field privileges is set (has been assigned a value) and false otherwise */
        return this.writeId;
    public java.lang.String getTableType() {
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            oprot.writeFieldEnd();
        setCreateTimeIsSet(true);
            _Fields.TEMPORARY,
        this.retention = other.retention;  
    @Override
        if (this_present_viewExpandedText || that_present_viewExpandedText) {  
    @org.apache.thrift.annotation.Nullable
        setRetentionIsSet(true);  
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter126 : struct.parameters.entrySet()) {
                    oprot.writeFieldBegin(PRIVILEGES_FIELD_DESC);
        org.apache.thrift.protocol.TType.LIST,
                oprot.writeFieldEnd();
                optionals.set(7);
                return isSetDbName();
        return false;
        if (isSetPartitionKeys()) {  
         */
    }
        org.apache.thrift.protocol.TType.BOOL,
        "viewExpandedText",  
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
                            _val132 = iprot.readString();
                    unsetWriteId();
        this.ownerType = null;
        "viewOriginalText",
                    return OWNER;  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.privileges, other.privileges);  
        @Override  
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                sb.append("null");  
        if (!getClass().equals(other.getClass())) {
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.  
                    return CREATE_TIME;
                optionals.set(1);
    public Table(Table other) {
            this.tableName = null;
    }
                            }
            return lastComparison;
            sb.append("null");
                                    FieldSchema _elem117;
        if (this.partitionKeys == null) {
                struct.validate();  
                if (incoming.get(12)) {
        if (other.isSetTableType()) {
            if (struct.isSetTemporary()) {  
    private static final int __CREATETIME_ISSET_ID = 0;
    public boolean isRewriteEnabled() {
                break;
                    unsetTableName();
        setTemporaryIsSet(true);  
    }
        org.apache.thrift.protocol.TType.STRING,
    }
                    struct.setViewExpandedTextIsSet(true);
    private static final org.apache.thrift.protocol.TField SD_FIELD_DESC = new org.apache.thrift.protocol.TField(  
        }
                    return WRITE_ID;
                    unsetRetention();
        this.sd = sd;
                            break;
            return lastComparison;
            }
    @org.apache.thrift.annotation.Nullable
                            } else {
    }
                            }
                            }
        return this.partitionKeys;  
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        this.temporary = temporary;
            if (lastComparison != 0) {  
            }
        sb.append("partitionKeys:");
                if (value == null) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
            }
                                    @org.apache.thrift.annotation.Nullable
                sb.append(this.creationMetadata);
                        for (int _i129 = 0; _i129 < _list127.size; ++_i129) {
    }
                oprot.writeFieldEnd();
            }
        this.privileges = null;
        return this.tableType != null;
        }
    }
                if (incoming.get(2)) {
                        oprot.writeString(_iter124.getValue());
        boolean first = true;  
    }
            case CREATION_METADATA:
            }  
                        oprot.writeString(_iter126.getValue());  
        }
        }  
        if (isSetCreationMetadata()) hashCode = hashCode * 8191 + creationMetadata.hashCode();  
        }
                oprot.writeBool(struct.rewriteEnabled);
                return getViewOriginalText();  
        if (!value) {
        lastComparison = java.lang.Boolean.compare(isSetCatName(), other.isSetCatName());
                return isSetPartitionKeys();
                return isTemporary();  
                    setSd((StorageDescriptor) value);  
    public int lastAccessTime; // required
                    oprot.writeFieldBegin(OWNER_TYPE_FIELD_DESC);
                    switch (schemeField.id) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                org.apache.thrift.TFieldRequirementType.DEFAULT,  
        );
    }  
        }
                optionals.set(0);
                case 1: // TABLE_NAME
         */
        _Fields.TEMPORARY,
                    setTemporary((java.lang.Boolean) value);
                                struct.creationMetadata = new CreationMetadata();  
    private static final org.apache.thrift.protocol.TField DB_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                }
                return lastComparison;
            case TABLE_NAME:
            new org.apache.thrift.meta_data.FieldMetaData(
        }
            throw new java.io.IOException(te);
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
        lastComparison = java.lang.Boolean.compare(isSetViewOriginalText(), other.isSetViewOriginalText());
                    return CREATION_METADATA;
/**  
            this.owner = null;
                                struct.setCatNameIsSet(true);
            sb.append("null");
    }
        java.lang.String viewExpandedText,
    );
        try {
                if (value == null) {
                    return PARAMETERS;  
                            }
        boolean that_present_sd = true && that.isSetSd();
        this.viewOriginalText = viewOriginalText;  
                optionals.set(11);
    public boolean rewriteEnabled; // optional
        this.viewExpandedText = viewExpandedText;  
            return lastComparison;
            )  
                    oprot.writeFieldEnd();  
        hashCode = hashCode * 8191 + ((isSetParameters()) ? 131071 : 524287);
                    unsetLastAccessTime();  
    }  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)  
                case 10: // VIEW_ORIGINAL_TEXT
    }
                            break;  
            if (this.ownerType == null) {
                return isSetCatName();
                return lastComparison;
                return lastComparison;
        );  
                return getRetention();  
            }
        );
                        oprot.writeString(_iter124.getKey());
    /** Returns true if field parameters is set (has been assigned a value) and false otherwise */  
                case 5: // LAST_ACCESS_TIME  
        }
            if (!(this_present_createTime && that_present_createTime)) return false;  
                            } else {
            oprot.writeFieldEnd();
        if (this.owner == null) {
                prot.decrementRecursionDepth();  
            }  
        setCreateTimeIsSet(false);
                }
                break;
    }
                    return DB_NAME;
                            } else {  
                    }  
            }  
                                    @org.apache.thrift.annotation.Nullable
                return getTableName();  
                                struct.temporary = iprot.readBool();
                optionals.set(6);
        boolean that_present_partitionKeys = true && that.isSetPartitionKeys();
    @Override
        @org.apache.thrift.annotation.Nullable  
                default:  
            this.tableType = other.tableType;  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)  
            if (struct.isSetPartitionKeys()) {
        }  
                "viewOriginalText",
        this.partitionKeys = null;  
        }  
    public Table setPrivileges(@org.apache.thrift.annotation.Nullable PrincipalPrivilegeSet privileges) {
            }  
        if (isSetParameters()) {
    }
                    oprot.writeListBegin(
        this.temporary = other.temporary;
    public void setSdIsSet(boolean value) {  
            )
        return true;
        org.apache.thrift.protocol.TType.I32,
        }  
        return this.ownerType;  
            if (!(this_present_catName && that_present_catName)) return false;
            if (!(this_present_viewExpandedText && that_present_viewExpandedText)) return false;
        (short) 7  
    }  
    @org.apache.thrift.annotation.Nullable  
                    struct.catName = iprot.readString();  
    public @org.apache.thrift.annotation.Nullable java.lang.String dbName; // required
                    setTableType((java.lang.String) value);
        if (lastComparison != 0) {
            sb.append(this.partitionKeys);
        }
                )
                oprot.writeString(struct.owner);  
                optionals.set(2);
                optionals.set(18);
                    struct.setCreateTimeIsSet(true);
                            }
        (short) 14
        boolean that_present_lastAccessTime = true;
        this.owner = null;  
            this.sd = new StorageDescriptor(other.sd);
                break;
         */
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        }
            _Fields.PARAMETERS,
        if (!first) sb.append(", ");
        return this;  
        first = false;
        hashCode = hashCode * 8191 + ((isSetWriteId()) ? 131071 : 524287);
        boolean this_present_tableType = true && this.isSetTableType();
            return lastComparison;  
                break;  
                    return VIEW_ORIGINAL_TEXT;
    }
        }
        if (isSetViewExpandedText()) {  
    }
        }  
                "temporary",  
        if (!first) sb.append(", ");  
            sb.append("null");  
            case TABLE_NAME:
                optionals.set(8);
        // check for required fields
            if (struct.isSetLastAccessTime()) {
                    for (FieldSchema _iter123 : struct.partitionKeys) {
                    struct.retention = iprot.readI32();  
        lastComparison = java.lang.Boolean.compare(isSetTableType(), other.isSetTableType());  
        return this.viewOriginalText != null;  
        (short) 16  
        }
                    struct.createTime = iprot.readI32();
    public void unsetOwner() {
        tmpMap.put(
                    unsetCatName();  
        if (!value) {  
                struct.privileges.write(oprot);
    public boolean isSetCatName() {
                if (value == null) {
        this();
            if (this.writeId != that.writeId) return false;
                    setOwner((java.lang.String) value);
                    unsetOwnerType();
        );
                    struct.creationMetadata = new CreationMetadata();
            }  
            }
                }
        }
                case 4: // CREATE_TIME
                return isSetParameters();
                            } else {  
    public java.util.List<FieldSchema> getPartitionKeys() {
        org.apache.thrift.protocol.TType.I32,  
    public Table setCreateTime(int createTime) {  
        first = false;  
        }
        "lastAccessTime",  
            case OWNER:  
        }
        tmpMap.put(
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __REWRITEENABLED_ISSET_ID, value);
            case TEMPORARY:
        "sd",
    @org.apache.thrift.annotation.Nullable
                "createTime",  
        } else {  
        VIEW_EXPANDED_TEXT((short) 11, "viewExpandedText"),  
                                struct.setRewriteEnabledIsSet(true);
                    setPartitionKeys((java.util.List<FieldSchema>) value);
            case OWNER_TYPE:  
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FieldSchema.class)  
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                return lastComparison;  
        if (lastComparison != 0) {
        _Fields.CAT_NAME,
        @Override  
        if (isSetOwnerType()) {
        if (this_present_ownerType || that_present_ownerType) {
    }
    public Table setRetention(int retention) {
                    iprot.readFieldEnd();
    public _Fields fieldForId(int fieldId) {
    public @org.apache.thrift.annotation.Nullable java.lang.String viewExpandedText; // required
    }
        if (!value) {
        boolean this_present_rewriteEnabled = true && this.isSetRewriteEnabled();
                {  
    }
        if (this.dbName == null) {
                sb.append(this.privileges);
    }
                return lastComparison;  
        java.lang.String viewOriginalText,
        boolean this_present_parameters = true && this.isSetParameters();
    }
        tmpMap.put(
            if (lastComparison != 0) {
            if (lastComparison != 0) {  
            sb.append("creationMetadata:");
            )  
                            break;
        setRetentionIsSet(true);
            _Fields.RETENTION,
        hashCode = hashCode * 8191 + ((isSetPartitionKeys()) ? 131071 : 524287);
        if (that instanceof Table) return this.equals((Table) that);
    }
        CREATE_TIME((short) 4, "createTime"),
            }
            if (struct.isSetTableType()) {
        );  
    public void unsetTemporary() {
     */  
        }
            case VIEW_EXPANDED_TEXT:
            sb.append(this.owner);
            _Fields.CAT_NAME,
            }  
        }  
        }
        if (isSetOwnerType()) hashCode = hashCode * 8191 + ownerType.getValue();  
                java.lang.String,
            case TABLE_TYPE:  
        if (isSetWriteId()) {
        return this.tableName != null;  
                break;
                            } else {
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, CreationMetadata.class)  
            }  
        return this;  
        }  
                            } else {  
    private static final org.apache.thrift.protocol.TField OWNER_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField(
            case DB_NAME:
            }  
        "retention",
    /** Returns true if field creationMetadata is set (has been assigned a value) and false otherwise */  
        }
            if (lastComparison != 0) {
            )
                return lastComparison;
    }
        }
    public @org.apache.thrift.annotation.Nullable java.lang.String owner; // required
    @Override  
                oprot.writeFieldBegin(SD_FIELD_DESC);  
                }
        }  
                }  
            }
        sb.append("lastAccessTime:");  
    private static final org.apache.thrift.protocol.TField CAT_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }  
    public boolean isSetRetention() {  
    public Table setTemporary(boolean temporary) {
        int hashCode = 1;  
            }
    @org.apache.thrift.annotation.Nullable
                return lastComparison;
                oprot.writeFieldEnd();
    @org.apache.thrift.annotation.Nullable
         * Find the _Fields constant that matches fieldId, throwing an exception  
    }
    public void setViewExpandedTextIsSet(boolean value) {
        hashCode = hashCode * 8191 + createTime;
    public boolean isSetParameters() {
        try {  
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
        return this.owner != null;
        );
        /**
    }  
    );  
                }
        }
                    struct.setOwnerIsSet(true);
            new org.apache.thrift.meta_data.FieldMetaData(
                return getViewExpandedText();  
        this.partitionKeys = null;  
            }  
                if (value == null) {
                    oprot.writeFieldEnd();
        }
                return isSetRewriteEnabled();
                            } else {
                    struct.creationMetadata.write(oprot);
                org.apache.thrift.TFieldRequirementType.DEFAULT,  
    public void unsetPartitionKeys() {
                        default:
 * Autogenerated by Thrift Compiler (0.23.0)
            return lastComparison;
        this.viewOriginalText = null;
        if (creationMetadata != null) {  
                            }  
                    setRetention((java.lang.Integer) value);
        (short) 17
        sb.append("dbName:");
        return this;  
            if (struct.viewExpandedText != null) {
        setWriteIdIsSet(true);  
            oprot.writeFieldBegin(LAST_ACCESS_TIME_FIELD_DESC);
            case VIEW_ORIGINAL_TEXT:
            }  
     */  
                    struct.privileges.write(oprot);
                                struct.lastAccessTime = iprot.readI32();  
        (short) 3
                        case 12: // TABLE_TYPE
            if (struct.isSetWriteId()) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __RETENTION_ISSET_ID, value);
                new org.apache.thrift.meta_data.MapMetaData(  
        if (other.isSetViewOriginalText()) {
                if (incoming.get(13)) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TEMPORARY_ISSET_ID);
    public void validate() throws org.apache.thrift.TException {  
                            break;
        "privileges",
            if (!this.viewExpandedText.equals(that.viewExpandedText)) return false;
            if (!this.dbName.equals(that.dbName)) return false;
        this.tableType = tableType;
            case SD:
        return hashCode;
            oprot.writeBitSet(optionals, 19);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            case OWNER:
        first = false;
        }  
            oprot.writeI32(struct.lastAccessTime);  
            new org.apache.thrift.meta_data.FieldMetaData(
            sd.validate();
                return isSetLastAccessTime();
            if (struct.isSetRetention()) {
    public void unsetCreationMetadata() {
        org.apache.thrift.protocol.TType.STRUCT,
    public Table deepCopy() {
            if (struct.isSetWriteId()) {
        }
        this.catName = null;
        boolean that_present_retention = true;  
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __RETENTION_ISSET_ID);
        "temporary",  
            _Fields.DB_NAME,  
    @org.apache.thrift.annotation.Nullable
    }
        (short) 19  
        if (lastComparison != 0) {  
                oprot.writeBool(struct.temporary);
        this.lastAccessTime = other.lastAccessTime;
                    struct.setParametersIsSet(true);  
        boolean this_present_catName = true && this.isSetCatName();
    public java.util.Map<java.lang.String, java.lang.String> getParameters() {
    public void unsetTableType() {
            case TEMPORARY:
    public Table setViewOriginalText(@org.apache.thrift.annotation.Nullable java.lang.String viewOriginalText) {
    public java.lang.String toString() {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Table");
                if (struct.isSetCreationMetadata()) {
            if (!first) sb.append(", ");
        hashCode = hashCode * 8191 + ((isSetTemporary()) ? 131071 : 524287);
        this.sd = null;
                                    org.apache.thrift.protocol.TMap _map119 = iprot.readMapBegin();  
        "catName",  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
                    unsetRewriteEnabled();
                }
            }
            this.viewExpandedText = null;  
        (short) 15
            throw new java.lang.IllegalArgumentException();
            if (!(this_present_dbName && that_present_dbName)) return false;
    }
        lastComparison = java.lang.Boolean.compare(isSetTableName(), other.isSetTableName());
        }
                            break;
        return this.owner;  
    public boolean isSetTableName() {
    public void setDbNameIsSet(boolean value) {
                        oprot.writeString(_iter126.getKey());
        }  
        hashCode = hashCode * 8191 + ((isSetTableName()) ? 131071 : 524287);
    @Override
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
            new org.apache.thrift.meta_data.FieldMetaData(  
    }
            _thriftId = thriftId;  
         *
            if (struct.isSetRewriteEnabled()) {
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
    // isset id assignments  
        }
            _Fields.OWNER,
        if (this_present_partitionKeys || that_present_partitionKeys) {  
    }  
        if (isSetDbName()) {  
        setRewriteEnabledIsSet(true);
            sb.append("ownerType:");  
        if (this_present_privileges || that_present_privileges) {
                            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
    }
        org.apache.thrift.protocol.TType.BOOL,  
            if (struct.isSetCreateTime()) {
                iprot.readStructBegin();
        int createTime,
        return this.ownerType != null;  
        if (lastComparison != 0) {
            java.util.List<FieldSchema> __this__partitionKeys = new java.util.ArrayList<FieldSchema>(other.partitionKeys.size());
    );  
            return lastComparison;
    /**  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {  
        }
    }  
        boolean that_present_owner = true && that.isSetOwner();  
                        @org.apache.thrift.annotation.Nullable
                    oprot.writeMapEnd();
        return this.privileges != null;  
            if (!first) sb.append(", ");  
    }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
        this.temporary = false;
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                                struct.sd = new StorageDescriptor();
                    struct.privileges = new PrincipalPrivilegeSet();  
    private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField(
            case PARTITION_KEYS:
        if (lastComparison != 0) {
    @org.apache.thrift.annotation.Nullable
    @Override
                    {  
        VIEW_ORIGINAL_TEXT((short) 10, "viewOriginalText"),
        __isset_bitfield = other.__isset_bitfield;  
            }  
        boolean this_present_createTime = true;  
                    struct.setRewriteEnabledIsSet(true);
    /** Returns true if field tableType is set (has been assigned a value) and false otherwise */  
            if (lastComparison != 0) {
            if (struct.parameters != null) {
            }  
        hashCode = hashCode * 8191 + ((isSetOwner()) ? 131071 : 524287);
        int lastComparison = 0;
                if (value == null) {
                    unsetOwner();
    }
        TEMPORARY((short) 14, "temporary"),  
        this.lastAccessTime = lastAccessTime;
                case 14: // TEMPORARY  
                                struct.setPartitionKeysIsSet(true);
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        return (this.partitionKeys == null) ? 0 : this.partitionKeys.size();
            for (FieldSchema other_element : other.partitionKeys) {  
                optionals.set(5);
        }  
    }
                            break;
        if (this.viewOriginalText == null) {  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);
        (short) 6
            case VIEW_ORIGINAL_TEXT:
        }  
            oprot.writeStructBegin(STRUCT_DESC);
    public boolean isTemporary() {  
                            }
                oprot.writeString(struct.dbName);  
    }
        }  
                            break;
            case VIEW_EXPANDED_TEXT:
        if (other.isSetTableName()) {
        first = false;
        TABLE_TYPE((short) 12, "tableType"),
        return this.sd != null;  
    public Table setParameters(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters) {  
            }
    }
                    return PARTITION_KEYS;
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)
    public int getParametersSize() {
                struct.sd.write(oprot);
    /** Returns true if field writeId is set (has been assigned a value) and false otherwise */
                    struct.sd = new StorageDescriptor();
        }
    public void setWriteIdIsSet(boolean value) {
            new org.apache.thrift.meta_data.FieldMetaData(  
            new org.apache.thrift.meta_data.FieldMetaData(  
            if (!(this_present_ownerType && that_present_ownerType)) return false;
            new org.apache.thrift.meta_data.FieldMetaData(
        }
        if (this_present_temporary || that_present_temporary) {  
    public void unsetRetention() {
                }
    }
        if (this.partitionKeys == null) {
            )
        return this;
                java.lang.String>(other.parameters);
        }  
        sb.append("viewOriginalText:");
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {  
                optionals.set(12);
                            }  
        if (isSetParameters()) hashCode = hashCode * 8191 + parameters.hashCode();  
        if (!first) sb.append(", ");  
        org.apache.thrift.protocol.TType.STRING,  
                org.apache.thrift.TFieldRequirementType.DEFAULT,
package org.opensearch.plugin.hive.metastore;  
                                struct.setRetentionIsSet(true);  
                                struct.privileges.read(iprot);  
        if (this.sd == null) {  
                {  
        return new Table(this);  
            this.ownerType = other.ownerType;
                    struct.setTemporaryIsSet(true);  
        }
        org.apache.thrift.protocol.TType.STRING,
        }
            }  
                                    struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map119.size);
        RETENTION((short) 6, "retention"),
    }
            }
            case PRIVILEGES:
    );
                        case 19: // WRITE_ID
        }
            )
        boolean that_present_creationMetadata = true && that.isSetCreationMetadata();
                    oprot.writeFieldEnd();
            if (struct.partitionKeys != null) {
        );
        return this.privileges;
                oprot.writeFieldEnd();
            sb.append("privileges:");  
            }  
                "parameters",
        if (isSetTableName()) {
                            _elem128 = new FieldSchema();  
        return this.dbName != null;
        org.apache.thrift.protocol.TType.I32,  
            return lastComparison;
            if (lastComparison != 0) {
                oprot.writeFieldBegin(WRITE_ID_FIELD_DESC);
        }
    public void setParametersIsSet(boolean value) {
            if (struct.isSetTemporary()) {
                } else {
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */  
                } else {
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        scheme(iprot).read(iprot, this);
        throw new java.lang.IllegalStateException();  
                oprot.writeString(struct.tableType);
        this.tableName = tableName;  
                oprot.writeFieldBegin(VIEW_ORIGINAL_TEXT_FIELD_DESC);  
                oprot.writeString(struct.dbName);  
        if (that == null) return false;  
    /**
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.temporary, other.temporary);
    public @org.apache.thrift.annotation.Nullable CreationMetadata creationMetadata; // optional  
            .getScheme();
                case 13: // PRIVILEGES
        _Fields.REWRITE_ENABLED,
        if (this_present_catName || that_present_catName) {  
            )
                }
    }  
    public PrincipalType getOwnerType() {
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
        );  
            }  
    public void addToPartitionKeys(FieldSchema elem) {  
            return byName.get(name);
                                struct.tableType = iprot.readString();  
        public static _Fields findByThriftId(int fieldId) {
                return getCreationMetadata();  
    public void setViewOriginalTextIsSet(boolean value) {  
        boolean this_present_sd = true && this.isSetSd();  
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)  
            first = false;  
                if (incoming.get(8)) {
        this.dbName = dbName;
        tmpMap.put(  
    );  
            )
    public Table setDbName(@org.apache.thrift.annotation.Nullable java.lang.String dbName) {
         * if it is not found.
            if (struct.isSetLastAccessTime()) {
    public @org.apache.thrift.annotation.Nullable java.lang.String catName; // optional
            sb.append("rewriteEnabled:");
                break;
    }  
        first = false;
                return isSetCreationMetadata();  
        boolean this_present_writeId = true && this.isSetWriteId();  
            }
        if (this.parameters == null) {
            }  
                case 7: // SD
        this.ownerType = ownerType;
            if (struct.dbName != null) {
                    return SD;
    @Override
                return getCreateTime();  
                    oprot.writeI32(struct.parameters.size());  
            }  
                    struct.ownerType = org.opensearch.plugin.hive.metastore.PrincipalType.findByValue(iprot.readI32());
                return isRewriteEnabled();  
                    oprot.writeListEnd();
        (short) 10  
            if (!(this_present_owner && that_present_owner)) return false;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        lastComparison = java.lang.Boolean.compare(isSetRewriteEnabled(), other.isSetRewriteEnabled());  
        }
            return new TableStandardScheme();
            if (struct.isSetDbName()) {
        if (lastComparison != 0) {  
        org.apache.thrift.protocol.TType.STRING,  
        DB_NAME((short) 2, "dbName"),  
                }
                    schemeField = iprot.readFieldBegin();  
        hashCode = hashCode * 8191 + ((isSetCatName()) ? 131071 : 524287);
            case WRITE_ID:
    public boolean isSetWriteId() {  
            _Fields.VIEW_ORIGINAL_TEXT,
                }  
        if (this.tableType == null) {
        }
        if (lastComparison != 0) {  
                return lastComparison;
    }
        this.viewOriginalText = null;
        java.lang.String tableType  
        if (isSetTemporary()) hashCode = hashCode * 8191 + ((temporary) ? 131071 : 524287);  
        } else {
        TABLE_NAME((short) 1, "tableName"),
    /**  
            return lastComparison;
                }
    private static final org.apache.thrift.protocol.TField LAST_ACCESS_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                            }
                oprot.writeBool(struct.rewriteEnabled);
        public TableTupleScheme getScheme() {
                if (value == null) {  
    public void unsetDbName() {
            if (this.rewriteEnabled != that.rewriteEnabled) return false;  
                                struct.creationMetadata.read(iprot);
        "creationMetadata",
        boolean this_present_temporary = true && this.isSetTemporary();
                    return TABLE_NAME;
    }
        }  
            case CREATION_METADATA:
        }  
                    unsetCreationMetadata();
                    }
    ) {
                iprot.readStructEnd();  
                oprot.writeFieldBegin(DB_NAME_FIELD_DESC);
    }  
    private static final org.apache.thrift.protocol.TField VIEW_ORIGINAL_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField(  
    }
    public long getWriteId() {  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
}  
     */
                return lastComparison;  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.owner, other.owner);
        if (other.isSetCatName()) {
                    return OWNER_TYPE;  
            this.sd = null;
        if (this_present_sd || that_present_sd) {
            }  
    /** Returns true if field createTime is set (has been assigned a value) and false otherwise */
    public Table setCatName(@org.apache.thrift.annotation.Nullable java.lang.String catName) {
        return this.creationMetadata != null;
                }
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __WRITEID_ISSET_ID);
    private static class TableTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
    }  
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID, value);  
            switch (fieldId) {  
                break;  
        if (this_present_retention || that_present_retention) {
                                struct.setTableTypeIsSet(true);
        if (other.isSetParameters()) {
        if (isSetRewriteEnabled()) hashCode = hashCode * 8191 + ((rewriteEnabled) ? 131071 : 524287);  
            case PRIVILEGES:
    public void clear() {
            }
                break;
        if (lastComparison != 0) {
        );  
        this.dbName = dbName;  
                if (value == null) {  
    public boolean isSetCreateTime() {
    private static final int __WRITEID_ISSET_ID = 5;  
    private static final org.apache.thrift.protocol.TField PARTITION_KEYS_FIELD_DESC = new org.apache.thrift.protocol.TField(
    private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            return new TableTupleScheme();  
            if (!(this_present_writeId && that_present_writeId)) return false;  
    );
            if (lastComparison != 0) {  
                if (incoming.get(5)) {
            case PARAMETERS:  
        this.owner = null;
    public void setCreateTimeIsSet(boolean value) {  
            first = false;  
        lastComparison = java.lang.Boolean.compare(isSetViewExpandedText(), other.isSetViewExpandedText());
        this.retention = 0;
        if (!first) sb.append(", ");  
                case 3: // OWNER
        }
                    }  
            }
                }  
                            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {  
        first = false;  
            )
                    struct.setViewOriginalTextIsSet(true);
                            } else {  
        return this.partitionKeys != null;
        first = false;  
        this.creationMetadata = creationMetadata;
            case CREATE_TIME:
        }
    }
        this.tableName = tableName;
            _Fields.WRITE_ID,
        this.viewExpandedText = null;  
    public Table setTableName(@org.apache.thrift.annotation.Nullable java.lang.String tableName) {
        tmpMap.put(
            if (!(this_present_temporary && that_present_temporary)) return false;
    public Table setTableType(@org.apache.thrift.annotation.Nullable java.lang.String tableType) {  
                break;
                    struct.setCatNameIsSet(true);
        "dbName",  
            sb.append(this.tableName);  
        }
    }
            case TABLE_TYPE:
                        for (int _i133 = 0; _i133 < _map130.size; ++_i133) {  
    }
        this.tableType = null;  
                    struct.writeId = iprot.readI64();
    public boolean isSetSd() {
        lastComparison = java.lang.Boolean.compare(isSetPartitionKeys(), other.isSetPartitionKeys());
                optionals.set(10);
                if (incoming.get(11)) {
        this.tableType = null;
            _Fields.VIEW_EXPANDED_TEXT,
        boolean that_present_tableName = true && that.isSetTableName();
        }
    }
                                    }
                break;
                                struct.sd.read(iprot);
            sb.append(this.rewriteEnabled);
                    struct.viewOriginalText = iprot.readString();  
        );
            this.creationMetadata = null;
        return 0;
    public PrincipalPrivilegeSet getPrivileges() {  
            _Fields.OWNER_TYPE,  
            )
                if (value == null) {
    }
        }
                            org.apache.thrift.protocol.TType.STRING,
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        boolean that_present_rewriteEnabled = true && that.isSetRewriteEnabled();  
        );
                "tableName",  
            }
        }  
        org.apache.thrift.protocol.TType.STRING,
                        org.apache.thrift.protocol.TMap _map130 = iprot.readMapBegin(  
    }  
        lastComparison = java.lang.Boolean.compare(isSetCreationMetadata(), other.isSetCreationMetadata());
    public @org.apache.thrift.annotation.Nullable PrincipalType ownerType; // optional  
                            } else {  
    private static final org.apache.thrift.protocol.TField TABLE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(  
    }
    /** Returns true if field ownerType is set (has been assigned a value) and false otherwise */
    }
    }
            if (struct.isSetTableName()) {
                if (incoming.get(7)) {
            oprot.writeFieldEnd();
            )
                        case 4: // CREATE_TIME
                optionals.set(16);
        boolean this_present_privileges = true && this.isSetPrivileges();  
                oprot.writeFieldEnd();  
        boolean this_present_owner = true && this.isSetOwner();
        }
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TableStandardSchemeFactory();  
                case 17: // CAT_NAME  
        return sb.toString();  
        }
            if (this.catName == null) {  
    /** Returns true if field viewExpandedText is set (has been assigned a value) and false otherwise */
            this.catName = null;
    public boolean isSetRewriteEnabled() {
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                return isSetOwner();
            if (!this.parameters.equals(that.parameters)) return false;  
        if (isSetOwner()) {
        public void write(org.apache.thrift.protocol.TProtocol prot, Table struct) throws org.apache.thrift.TException {
        }
                if (value == null) {
        }
        }  
        _Fields.WRITE_ID };  
    public java.lang.String getViewOriginalText() {  
            new org.apache.thrift.meta_data.FieldMetaData(
        hashCode = hashCode * 8191 + lastAccessTime;
    );
        boolean that_present_catName = true && that.isSetCatName();
                if (incoming.get(9)) {
        this.parameters = parameters;
public class Table implements org.apache.thrift.TBase<Table, Table._Fields>, java.io.Serializable, Cloneable, Comparable<Table> {  
        lastComparison = java.lang.Boolean.compare(isSetOwnerType(), other.isSetOwnerType());  
            case WRITE_ID:
        if (isSetPrivileges()) {
            )
            }  
    public boolean isSetTemporary() {  
    public java.lang.String getCatName() {  
                                struct.setCreateTimeIsSet(true);
            if (!(this_present_tableName && that_present_tableName)) return false;  
        boolean this_present_viewOriginalText = true && this.isSetViewOriginalText();  
            if (struct.isSetCreationMetadata()) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Table(");
                oprot.writeString(struct.tableName);
         * Find the _Fields constant that matches name, or null if its not found.
                                    }
                                struct.setParametersIsSet(true);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    unsetViewExpandedText();  
                struct.sd.write(oprot);  
    }  
                return isSetViewExpandedText();
        if (isSetCreationMetadata()) {
        boolean that_present_dbName = true && that.isSetDbName();
    );
            }  
    /** Returns true if field tableName is set (has been assigned a value) and false otherwise */
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.dbName, other.dbName);
     * @see PrincipalType
                if (value == null) {
        return this;
        if (isSetWriteId()) {
            if (struct.isSetViewExpandedText()) {
                )
    }  
                    setRewriteEnabled((java.lang.Boolean) value);
        org.apache.thrift.protocol.TType.I64,
    public void setPartitionKeysIsSet(boolean value) {
                    setParameters((java.util.Map<java.lang.String, java.lang.String>) value);
        if (lastComparison != 0) {  
        sb.append("viewExpandedText:");
                    unsetDbName();  
                }
            if (struct.viewOriginalText != null) {
        lastComparison = java.lang.Boolean.compare(isSetWriteId(), other.isSetWriteId());
                if (value == null) {
                    return LAST_ACCESS_TIME;
    }
                        case 15: // REWRITE_ENABLED
                            org.apache.thrift.protocol.TType.STRING,
        @Override  
        "writeId",
    public CreationMetadata getCreationMetadata() {
                            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {  
                    struct.setDbNameIsSet(true);  
        if (lastComparison != 0) {
                                struct.setTemporaryIsSet(true);  
                optionals.set(15);
        }  
    public Table setWriteId(long writeId) {
                        }
            _fieldName = fieldName;
        PARAMETERS((short) 9, "parameters"),
                }  
    }
        }
    }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
                }  
                }  
                        case 1: // TABLE_NAME
        if (!value) {  
    }
            sb.append("null");  
        sb.append("tableName:");
        boolean this_present_creationMetadata = true && this.isSetCreationMetadata();  
        }
        this.tableName = null;
        }
                    struct.rewriteEnabled = iprot.readBool();  
    public void setRewriteEnabledIsSet(boolean value) {  
    public void unsetViewExpandedText() {
    }  
            sb.append(this.viewOriginalText);  
        return this.rewriteEnabled;  
            }  
        this.owner = owner;
                }
            } else {  
        if (isSetPartitionKeys()) hashCode = hashCode * 8191 + partitionKeys.hashCode();  
        return this.catName;
                        case 17: // CAT_NAME
         */  
            __isset_bitfield = 0;
                }  
        java.util.Map<java.lang.String, java.lang.String> parameters,  
                        );  
            if (!first) sb.append(", ");
            }  
                // check for required fields of primitive type, which can't be checked in the validate method
                                struct.setPrivilegesIsSet(true);
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                }
        }
                struct.creationMetadata.write(oprot);
            )  
                                struct.tableName = iprot.readString();
        if (other.isSetCreationMetadata()) {
        if (this.tableName == null) {  
        org.apache.thrift.protocol.TType.MAP,  
        boolean that_present_viewExpandedText = true && that.isSetViewExpandedText();
            if (!this.viewOriginalText.equals(that.viewOriginalText)) return false;
        return (this.parameters == null) ? 0 : this.parameters.size();  
        _Fields.PRIVILEGES,  
        if (this_present_writeId || that_present_writeId) {
                    unsetPartitionKeys();  
                return isSetWriteId();  
        }  
    );
        }  
    );  
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            _Fields.TABLE_NAME,
            java.util.Map<java.lang.String, java.lang.String> __this__parameters = new java.util.HashMap<  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.retention, other.retention);
        sb.append(this.retention);
            this.privileges = null;
        }  
                                struct.setLastAccessTimeIsSet(true);
            _Fields.LAST_ACCESS_TIME,  
        this.catName = catName;
                    setViewOriginalText((java.lang.String) value);  
    public java.lang.String getViewExpandedText() {
        this.partitionKeys = partitionKeys;
                    setLastAccessTime((java.lang.Integer) value);
                        case 2: // DB_NAME
                    struct.creationMetadata.read(iprot);
    }  
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrincipalPrivilegeSet.class)  
    }
                "partitionKeys",
                return isSetViewOriginalText();  
            if (struct.isSetRewriteEnabled()) {
            if (struct.isSetSd()) {
        if (isSetLastAccessTime()) {  
                sb.append(this.catName);  
                        FieldSchema _elem128;
        } else {
    private static final int __REWRITEENABLED_ISSET_ID = 4;
            oprot.writeFieldBegin(RETENTION_FIELD_DESC);
        "partitionKeys",  
                break;
                case 8: // PARTITION_KEYS  
                                        _elem117 = new FieldSchema();
                    struct.setPrivilegesIsSet(true);
            new org.apache.thrift.meta_data.FieldMetaData(
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableType, other.tableType);
    public java.lang.String getDbName() {
        return this;  
                oprot.writeBool(struct.temporary);
            if (struct.owner != null) {  
                oprot.writeString(struct.catName);
        if (isSetRetention()) {
                return lastComparison;
        }
    private static class TableStandardScheme extends org.apache.thrift.scheme.StandardScheme<Table> {  
        }  
    }
        this.viewExpandedText = null;
                } else {
                oprot.writeI64(struct.writeId);
        return this.viewExpandedText;
            if (lastComparison != 0) {
        boolean that_present_writeId = true && that.isSetWriteId();
        }  
        private final short _thriftId;
            first = false;  
        WRITE_ID((short) 19, "writeId");  
    public boolean isSetPrivileges() {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CREATETIME_ISSET_ID);
        );  
                    return RETENTION;  
            if (lastComparison != 0) {
        setRewriteEnabledIsSet(false);
                case 19: // WRITE_ID
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)  
        }  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        this.catName = null;
                            } else {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CREATETIME_ISSET_ID);  
        sb.append(this.lastAccessTime);
            if (struct.isSetParameters()) {
                if (value == null) {
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
        SD((short) 7, "sd"),
        hashCode = hashCode * 8191 + ((isSetViewExpandedText()) ? 131071 : 524287);
    }
        this.createTime = other.createTime;
        if (isSetRewriteEnabled()) {
                            break;  
    public void setRetentionIsSet(boolean value) {
        }  
            }
                    );
            }
            if (!(this_present_parameters && that_present_parameters)) return false;
        return this;
                } else {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
                oprot.writeFieldBegin(PARTITION_KEYS_FIELD_DESC);
    private static final org.apache.thrift.protocol.TField TABLE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField(
    }
            }  
        (short) 1  
            case REWRITE_ENABLED:
                                {
    public void setTableNameIsSet(boolean value) {  
                    struct.temporary = iprot.readBool();
            if (struct.privileges != null) {
                            } else {
                            struct.parameters.put(_key131, _val132);  
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
        "rewriteEnabled",
            if (struct.isSetViewOriginalText()) {
            first = false;
        org.apache.thrift.protocol.TType.STRING,
            }  
        boolean this_present_lastAccessTime = true;
        this.viewOriginalText = viewOriginalText;
    );
                    struct.setTableNameIsSet(true);
        this.rewriteEnabled = other.rewriteEnabled;  
        }  
        lastComparison = java.lang.Boolean.compare(isSetParameters(), other.isSetParameters());  
            if (lastComparison != 0) {
                }  
        boolean this_present_partitionKeys = true && this.isSetPartitionKeys();
                case 16: // CREATION_METADATA
                                        struct.parameters.put(_key120, _val121);  
                    struct.setTableTypeIsSet(true);  
        first = false;  
            sb.append(this.writeId);
                break;
        java.lang.String dbName,
                    unsetParameters();
         * Find the _Fields constant that matches fieldId, or null if its not found.
                            }  
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TableTupleSchemeFactory();
            } else {  
    private static final org.apache.thrift.protocol.TField VIEW_EXPANDED_TEXT_FIELD_DESC = new org.apache.thrift.protocol.TField(
            if (lastComparison != 0) {
        if (lastComparison != 0) {  
        tmpMap.put(
                    );  
                    setPrivileges((PrincipalPrivilegeSet) value);  
                } else {  
        setRetentionIsSet(false);  
        this.tableName = null;
                            break;
            if (!(this_present_rewriteEnabled && that_present_rewriteEnabled)) return false;
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
        return this.tableType;  
        if (other.isSetOwner()) {
        if (this_present_createTime || that_present_createTime) {
        java.lang.String owner,  
            case TABLE_NAME:
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        int lastAccessTime,
    public void setOwnerIsSet(boolean value) {
                    struct.owner = iprot.readString();  
        );
                    struct.setRetentionIsSet(true);
        }  
        }
    public boolean isSetTableType() {
            return lastComparison;  
        setTemporaryIsSet(false);  
    @org.apache.thrift.annotation.Nullable
    private static final org.apache.thrift.protocol.TField REWRITE_ENABLED_FIELD_DESC = new org.apache.thrift.protocol.TField(
            if (struct.isSetViewExpandedText()) {
        this.tableType = tableType;
        java.util.List<FieldSchema> partitionKeys,
        return this;
        }  
    /** Returns true if field partitionKeys is set (has been assigned a value) and false otherwise */  
                "creationMetadata",
                    }
                org.apache.thrift.TFieldRequirementType.DEFAULT,  
        tmpMap.put(
    }  
    );
                            } else {
        }
                return lastComparison;
            if (struct.isSetOwner()) {
     */
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        if (!value) {  
            sb.append("catName:");
    public int getRetention() {  
    }  
        );
            _Fields.CREATE_TIME,
        }
    }  
    public boolean equals(java.lang.Object that) {  
            case PARTITION_KEYS:
        return this.lastAccessTime;
                "retention",
            this.dbName = null;  
    }  
            this.partitionKeys = __this__partitionKeys;  
            }
        this.partitionKeys.add(elem);
            if (!this.tableType.equals(that.tableType)) return false;  
     *
                        _iter123.write(oprot);
    }
    @org.apache.thrift.annotation.Nullable  
                break;  
                } else {
    );
                        case 5: // LAST_ACCESS_TIME
                oprot.writeFieldBegin(REWRITE_ENABLED_FIELD_DESC);  
    public boolean isSetViewExpandedText() {  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.viewExpandedText, other.viewExpandedText);
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter124 : struct.parameters.entrySet()) {  
                }
                            break;
        int retention,  
            new org.apache.thrift.meta_data.FieldMetaData(
                } else {  
                sb.append(this.ownerType);
                if (value == null) {  
        boolean this_present_retention = true;
                }
            case RETENTION:
            this.parameters = null;
        if (isSetCreationMetadata()) {
            case PARAMETERS:
            if (lastComparison != 0) {
        return this;
        return this;
                case 12: // TABLE_TYPE
            if (!first) sb.append(", ");  
                    struct.setWriteIdIsSet(true);  
                    setDbName((java.lang.String) value);
                        )
                }
                            } else {
            this.creationMetadata = new CreationMetadata(other.creationMetadata);
            }
            case RETENTION:  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        OWNER((short) 3, "owner"),
                if (value == null) {  
                    return CAT_NAME;
            if (struct.isSetTableName()) {
            if (struct.tableName != null) {
    }
        if (other.isSetOwnerType()) {
        if (!value) {  
                                struct.setOwnerIsSet(true);  
        (short) 5
                "lastAccessTime",
        this.rewriteEnabled = rewriteEnabled;
    }
                return getSd();  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            if (struct.isSetOwnerType()) {
                            break;
            sb.append("null");  
        }  
                if (incoming.get(14)) {
            try {  
        boolean this_present_dbName = true && this.isSetDbName();
                        case 18: // OWNER_TYPE  
        if (this.viewExpandedText == null) {
                    setCreationMetadata((CreationMetadata) value);  
    }
            if (lastComparison != 0) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.creationMetadata, other.creationMetadata);  
            case VIEW_ORIGINAL_TEXT:
        setLastAccessTimeIsSet(true);
    public @org.apache.thrift.annotation.Nullable java.util.List<FieldSchema> partitionKeys; // required
        sb.append(")");
        this.rewriteEnabled = false;  
                oprot.writeFieldEnd();
                if (incoming.get(3)) {  
        if (!first) sb.append(", ");  
                    {
        lastComparison = java.lang.Boolean.compare(isSetLastAccessTime(), other.isSetLastAccessTime());
    public void unsetTableName() {  
            sb.append(this.parameters);
            }
        if (isSetTableName()) hashCode = hashCode * 8191 + tableName.hashCode();  
     * @see PrincipalType
                java.util.BitSet incoming = iprot.readBitSet(19);
        }
                    struct.privileges.read(iprot);
    @Override
            if (!this.sd.equals(that.sd)) return false;
            if (struct.isSetTableType()) {
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        (short) 9
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        throw new java.lang.IllegalStateException();
    }
        if (!first) sb.append(", ");
                org.apache.thrift.TFieldRequirementType.OPTIONAL,
                                struct.retention = iprot.readI32();
        if (this.parameters == null) {
    }
                return lastComparison;
        } else {  
        "owner",
    public boolean isSetOwnerType() {
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
            }  
        }
    }  
            if (!(this_present_viewOriginalText && that_present_viewOriginalText)) return false;  
        if (isSetViewOriginalText()) {
            if (struct.isSetParameters()) {
            case LAST_ACCESS_TIME:
                } else {
        return this.viewOriginalText;
                optionals.set(14);
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID);  
        (short) 18
    }
                                        _key120 = iprot.readString();
            _Fields.PARTITION_KEYS,  
    @Override
                    unsetCreateTime();
    }
        sb.append("createTime:");
            if (struct.isSetOwnerType()) {
                }
    private static final _Fields[] optionals = {
                if (incoming.get(15)) {  
            )  
        if (isSetWriteId()) hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(writeId);  
        "tableType",
        hashCode = hashCode * 8191 + ((isSetDbName()) ? 131071 : 524287);
                oprot.writeFieldBegin(TABLE_NAME_FIELD_DESC);  
                oprot.writeI64(struct.writeId);  
            }  
    public void setTableTypeIsSet(boolean value) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sd, other.sd);  
            }  
            if (this.temporary != that.temporary) return false;
                optionals.set(4);
                            }
                }
        if (isSetSd()) {
        private final java.lang.String _fieldName;  
                if (incoming.get(16)) {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)  
        (short) 2
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                }  
            if (!(this_present_lastAccessTime && that_present_lastAccessTime)) return false;
        if (this_present_parameters || that_present_parameters) {
        return this;
    public int compareTo(Table other) {  
            if (lastComparison != 0) {  
            this.viewOriginalText = other.viewOriginalText;  
        setCreateTimeIsSet(true);
        this.parameters = null;
    public void setCatNameIsSet(boolean value) {  
        java.lang.String tableName,
        }  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
        }
                } else {  
        if (isSetRewriteEnabled()) {
                return lastComparison;  
                oprot.writeString(struct.tableName);  
                    return PRIVILEGES;
            this.viewOriginalText = null;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
    }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rewriteEnabled, other.rewriteEnabled);
    }
        if (privileges != null) {  
                oprot.writeFieldEnd();
            java.util.BitSet optionals = new java.util.BitSet();  
                    oprot.writeI32(struct.ownerType.getValue());  
                        case 13: // PRIVILEGES  
        hashCode = hashCode * 8191 + ((isSetRewriteEnabled()) ? 131071 : 524287);
    public int getPartitionKeysSize() {  
                }
        return this.parameters != null;
    }
        "ownerType",
            if (lastComparison != 0) {
                if (incoming.get(18)) {
        _Fields.OWNER_TYPE,
                            org.apache.thrift.protocol.TType.STRING,
                return getOwner();  
                                    java.lang.String _key120;  
            sb.append(this.dbName);
                        new org.apache.thrift.protocol.TMap(  
        }  
        if (other.isSetPrivileges()) {
        @Override  
                            }  
        }
                case 11: // VIEW_EXPANDED_TEXT  
                oprot.writeFieldBegin(VIEW_EXPANDED_TEXT_FIELD_DESC);
    }
            if (struct.isSetOwner()) {
            } finally {
            if (lastComparison != 0) {
    @Override  
            return _fieldName;
                }
        org.apache.thrift.protocol.TType.STRUCT,
    );
        this.sd = sd;  
            }  
        }
                        case 7: // SD
        if (isSetDbName()) hashCode = hashCode * 8191 + dbName.hashCode();  
            return lastComparison;  
                            } else {
                                struct.setTableNameIsSet(true);
                        }  
    }
    /** Returns true if field temporary is set (has been assigned a value) and false otherwise */
        }
                oprot.writeFieldEnd();  
            return lastComparison;  
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                if (incoming.get(0)) {  
     * @see PrincipalType
    }
                            } else {
                                    java.lang.String _val121;
                            break;
        );  
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Table.class, metaDataMap);
                    setTableName((java.lang.String) value);  
                } else {
        (short) 11
            if (struct.isSetPrivileges()) {
        if (lastComparison != 0) {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            if (struct.creationMetadata != null) {
                            struct.partitionKeys.add(_elem128);
        @Override
    public void unsetCatName() {  
                "ownerType",
                        case 11: // VIEW_EXPANDED_TEXT
                org.apache.thrift.TFieldRequirementType.DEFAULT,  
    }  
            new org.apache.thrift.meta_data.FieldMetaData(
        sb.append("retention:");
            if (this.lastAccessTime != that.lastAccessTime) return false;
                "writeId",
    }  
                return isSetSd();  
                break;
        hashCode = hashCode * 8191 + retention;  
                }
    /** Returns true if field catName is set (has been assigned a value) and false otherwise */
        this.parameters = parameters;
                            }
    );  
            if (struct.isSetCreateTime()) {
                }
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __WRITEID_ISSET_ID);
                                struct.privileges = new PrincipalPrivilegeSet();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                            } else {
        }
            }
            new org.apache.thrift.meta_data.FieldMetaData(  
                }
                return getCatName();  
        org.apache.thrift.protocol.TType.STRUCT,
                                        _val121 = iprot.readString();
        this.parameters.put(key, val);
        if (!value) {
                            }
            new org.apache.thrift.meta_data.FieldMetaData(
            if (this.creationMetadata == null) {
    static {
            return lastComparison;
        if (this_present_tableName || that_present_tableName) {
                sb.append("null");
        );  
        if (!first) sb.append(", ");
            sb.append(this.tableType);
                    struct.lastAccessTime = iprot.readI32();
        boolean that_present_createTime = true;
    public boolean temporary; // optional
                if (incoming.get(1)) {
                if (struct.isSetCatName()) {  
    }  
                oprot.writeString(struct.owner);
                oprot.writeI32(struct.retention);  
        }
            sb.append("temporary:");
                    org.apache.thrift.protocol.TType.MAP,
                optionals.set(9);
                                }  
            if (this.privileges == null) {
        if (other.isSetPartitionKeys()) {
        hashCode = hashCode * 8191 + ((isSetViewOriginalText()) ? 131071 : 524287);
                    oprot.writeMapBegin(
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
            this.tableType = null;
        if (isSetOwnerType()) {
        }
        _Fields(short thriftId, java.lang.String fieldName) {
    }
        lastComparison = java.lang.Boolean.compare(isSetDbName(), other.isSetDbName());
    }
            this.partitionKeys = null;
    public @org.apache.thrift.annotation.Nullable java.lang.String viewOriginalText; // required  
                    setOwnerType((PrincipalType) value);
            return lastComparison;
            prot.incrementRecursionDepth();
            this.parameters = new java.util.HashMap<java.lang.String, java.lang.String>();
        return this;
        this.owner = owner;
            sb.append(this.temporary);
        tmpMap.put(
            first = false;  
            return fields;  
        if (lastComparison != 0) {
                optionals.set(13);
            sb.append("null");
        }
        }
            if (!this.privileges.equals(that.privileges)) return false;
                        @org.apache.thrift.annotation.Nullable
                                struct.writeId = iprot.readI64();
    private static final org.apache.thrift.protocol.TField RETENTION_FIELD_DESC = new org.apache.thrift.protocol.TField(
                }
        first = false;
            case RETENTION:  
            case SD:
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            this.viewExpandedText = other.viewExpandedText;  
    );
        CAT_NAME((short) 17, "catName"),  
            if (!(this_present_partitionKeys && that_present_partitionKeys)) return false;
    }
        tmpMap.put(  
            if (struct.isSetRetention()) {
    }  
        }  
                oprot.writeFieldBegin(TABLE_TYPE_FIELD_DESC);
            if (struct.isSetRewriteEnabled()) {
        hashCode = hashCode * 8191 + ((isSetOwnerType()) ? 131071 : 524287);
        this.sd = null;
        "tableName",
        this.creationMetadata = null;
        if (this_present_owner || that_present_owner) {
            case REWRITE_ENABLED:  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partitionKeys, other.partitionKeys);
    @Override
        boolean that_present_viewOriginalText = true && that.isSetViewOriginalText();
        }  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.catName, other.catName);
                                struct.setOwnerTypeIsSet(true);  
            }
        return this.viewExpandedText != null;
        );
                    for (FieldSchema _iter125 : struct.partitionKeys) {
            }
    /** Returns true if field lastAccessTime is set (has been assigned a value) and false otherwise */  
    }  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
            case TABLE_TYPE:  
                byName.put(field.getFieldName(), field);  
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        first = false;
                                    struct.partitionKeys = new java.util.ArrayList<FieldSchema>(_list116.size);  
    private static final org.apache.thrift.protocol.TField WRITE_ID_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTime, other.createTime);  
    }  
        PARTITION_KEYS((short) 8, "partitionKeys"),  
    /** Returns true if field sd is set (has been assigned a value) and false otherwise */
            }  
            }  
    public void unsetPrivileges() {  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.tableName, other.tableName);  
                        struct.partitionKeys = new java.util.ArrayList<FieldSchema>(_list127.size);
            this.privileges = new PrincipalPrivilegeSet(other.privileges);  
                        java.lang.String _val132;
        this.lastAccessTime = 0;
        }
        } else {
        this.writeId = writeId;
                return isSetTemporary();
                "tableType",
            )  
                    return REWRITE_ENABLED;  
        }
                iprot.decrementRecursionDepth();
            }  
            this.partitionKeys = new java.util.ArrayList<FieldSchema>();
        tmpMap.put(
        boolean that_present_temporary = true && that.isSetTemporary();
        first = false;
        if (!value) {
    public void unsetParameters() {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
        }
        lastComparison = java.lang.Boolean.compare(isSetPrivileges(), other.isSetPrivileges());
        if (!value) {
        this.partitionKeys = partitionKeys;
        (short) 4  
            if (lastComparison != 0) {  
            }  
        this.viewExpandedText = viewExpandedText;
            iprot.incrementRecursionDepth();
        setLastAccessTimeIsSet(true);  
                            break;
                        org.apache.thrift.protocol.TList _list127 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
    public void unsetViewOriginalText() {  
                                {
                    unsetPrivileges();
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __LASTACCESSTIME_ISSET_ID);
            oprot.writeStructEnd();
        lastComparison = java.lang.Boolean.compare(isSetCreateTime(), other.isSetCreateTime());
        } else {
            new org.apache.thrift.meta_data.FieldMetaData(
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    /** Returns true if field viewOriginalText is set (has been assigned a value) and false otherwise */
                            break;  
                }
                                struct.setCreationMetadataIsSet(true);
            if (!(this_present_retention && that_present_retention)) return false;
        } else {
    public boolean isSetDbName() {  
            if (struct.ownerType != null) {  
                oprot.writeString(struct.viewOriginalText);
        sb.append("sd:");
                    setViewExpandedText((java.lang.String) value);
        hashCode = hashCode * 8191 + ((isSetTableType()) ? 131071 : 524287);
        lastComparison = java.lang.Boolean.compare(isSetTemporary(), other.isSetTemporary());
        if (isSetCatName()) {  
                    return null;
            case LAST_ACCESS_TIME:
        @Override  
                                struct.owner = iprot.readString();
            _Fields.CREATION_METADATA,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)
                        @org.apache.thrift.annotation.Nullable  
        static {
        }  
                } else {
            if (struct.isSetCatName()) {
    }
        }
            if (struct.tableType != null) {  
                oprot.writeFieldBegin(TEMPORARY_FIELD_DESC);
        if (isSetCatName()) hashCode = hashCode * 8191 + catName.hashCode();  
                    unsetTableType();
            if (struct.isSetCatName()) {
            if (!(this_present_tableType && that_present_tableType)) return false;
                            }  
    public int getCreateTime() {
                break;  
    }
            return lastComparison;
        return this;  
                return getParameters();  
        return this.creationMetadata;  
                oprot.writeString(struct.tableType);
    private static final org.apache.thrift.protocol.TField CREATION_METADATA_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            case CREATE_TIME:
    public boolean isSetViewOriginalText() {
                } else {  
        sb.append(this.createTime);  
        this.privileges = null;
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        tmpMap.put(
                return getWriteId();  
    }
            }
            struct.validate();
            case CREATION_METADATA:
                                struct.dbName = iprot.readString();  
            case DB_NAME:
        boolean that_present_privileges = true && that.isSetPrivileges();
                } else {  
                        case 16: // CREATION_METADATA
            } finally {
            _Fields fields = findByThriftId(fieldId);
        this.writeId = 0;
        scheme(oprot).write(oprot, this);  
 */
        boolean this_present_ownerType = true && this.isSetOwnerType();
    @org.apache.thrift.annotation.Nullable
        public static _Fields findByName(java.lang.String name) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __WRITEID_ISSET_ID, value);
    public int createTime; // required  
    }  
    }
    public @org.apache.thrift.annotation.Nullable java.lang.String tableType; // required
        if (isSetPrivileges()) hashCode = hashCode * 8191 + privileges.hashCode();  
        this.creationMetadata = null;  
                break;
        (short) 8
        }
        if (!first) sb.append(", ");
            this.tableName = other.tableName;
    private static final int __LASTACCESSTIME_ISSET_ID = 1;
            }
    }
        }
            case OWNER_TYPE:
        if (!value) {
    /** Returns true if field owner is set (has been assigned a value) and false otherwise */  
                            org.apache.thrift.protocol.TType.STRING
            _Fields,
        /**
    /**
            _Fields.REWRITE_ENABLED,  
            sb.append("null");
                    struct.setPartitionKeysIsSet(true);
            if (lastComparison != 0) {
    /** Returns true if field dbName is set (has been assigned a value) and false otherwise */
            return lastComparison;  
    }  
            return lastComparison;  
        if (isSetOwner()) hashCode = hashCode * 8191 + owner.hashCode();  
        }  
                }  
                            } else {
        }
        return this;  
        if (!first) sb.append(", ");
            }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                sb.append("null");
        boolean that_present_parameters = true && that.isSetParameters();  
                                    iprot.readMapEnd();
                {
                    org.apache.thrift.protocol.TType.LIST,
                    struct.sd.read(iprot);
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters; // required
        if (lastComparison != 0) {
        setLastAccessTimeIsSet(false);
        if (this_present_rewriteEnabled || that_present_rewriteEnabled) {
    @Override
                case 6: // RETENTION
            this.dbName = other.dbName;
            }  
            }  
        }
                if (incoming.get(17)) {  
            } else {
            if (this.createTime != that.createTime) return false;
            }
    }
                        case 14: // TEMPORARY  
    public boolean isSetLastAccessTime() {
        if (isSetSd()) hashCode = hashCode * 8191 + sd.hashCode();  
            }  
    public long writeId; // optional
            if (struct.isSetCreationMetadata()) {
        sb.append("parameters:");  
            case CAT_NAME:
                        java.lang.String _key131;  
                oprot.writeFieldEnd();  
     *
            sb.append("writeId:");
    public boolean isSetOwner() {
        hashCode = hashCode * 8191 + ((isSetPrivileges()) ? 131071 : 524287);
        public java.lang.String getFieldName() {
            if (!(this_present_creationMetadata && that_present_creationMetadata)) return false;  
                            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {  
            oprot.writeI32(struct.retention);  
            sb.append("null");
            case REWRITE_ENABLED:  
                            break;  
        if (lastComparison != 0) {  
                                struct.rewriteEnabled = iprot.readBool();
                }
                oprot.writeFieldEnd();  
                return isSetOwnerType();
            }
            if (!this.creationMetadata.equals(that.creationMetadata)) return false;
 *
                case 2: // DB_NAME  
    }
        tmpMap.put(  
                while (true) {
                return isSetTableType();
                if (value == null) {
        }
        /**  
            if (struct.isSetSd()) {
            }  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        if (isSetViewExpandedText()) hashCode = hashCode * 8191 + viewExpandedText.hashCode();  
                } else {
        return this.tableName;
                org.apache.thrift.protocol.TField schemeField;  
            }
                                }  
                            break;  
            }
    }  
                return isSetPrivileges();  
        boolean this_present_tableName = true && this.isSetTableName();  
                optionals.set(17);
            this.ownerType = null;
        sb.append("owner:");  
    public StorageDescriptor getSd() {  
                sb.append("null");
        if (!first) sb.append(", ");
    public void unsetRewriteEnabled() {  
            )
                "catName",  
                    return TABLE_TYPE;  
    }
    }  
    public boolean isSetPartitionKeys() {
        }
    public void setOwnerTypeIsSet(boolean value) {  
                return lastComparison;  
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {  
        public TableStandardScheme getScheme() {
        if (isSetCatName()) {  
        if (this_present_dbName || that_present_dbName) {  
            )
                return lastComparison;  
            this.catName = other.catName;
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TEMPORARY_ISSET_ID);
            if (!(this_present_privileges && that_present_privileges)) return false;  
                    return VIEW_EXPANDED_TEXT;
            this.parameters = __this__parameters;  
                    setWriteId((java.lang.Long) value);  
    public void unsetOwnerType() {  
                        break;
    }  
                }  
                    setCatName((java.lang.String) value);
                __this__partitionKeys.add(new FieldSchema(other_element));
    }
            _Fields.PRIVILEGES,
            }
                if (value == null) {  
                            }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            case CAT_NAME:
            case SD:
            new org.apache.thrift.meta_data.FieldMetaData(  
        public void read(org.apache.thrift.protocol.TProtocol iprot, Table struct) throws org.apache.thrift.TException {  
            }  
        return this;
            if (lastComparison != 0) {  
    }  
            if (struct.sd != null) {
                return lastComparison;
                return lastComparison;
        this.ownerType = null;  
            return _thriftId;  
                return getDbName();  
            if (struct.isSetDbName()) {
    public @org.apache.thrift.annotation.Nullable StorageDescriptor sd; // required  
            if (!this.partitionKeys.equals(that.partitionKeys)) return false;
            this.owner = other.owner;
                        struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map130.size);
                if (incoming.get(10)) {  
                                    org.apache.thrift.protocol.TList _list116 = iprot.readListBegin();
                    return TEMPORARY;
            if (!this.tableName.equals(that.tableName)) return false;
            if (!first) sb.append(", ");
        if (isSetCreateTime()) {
    }  
    public @org.apache.thrift.annotation.Nullable PrincipalPrivilegeSet privileges; // optional  
                return lastComparison;
                                struct.setSdIsSet(true);  
            new org.apache.thrift.meta_data.FieldMetaData(  
                }
    private static class TableStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                    struct.setOwnerTypeIsSet(true);
        );
        public void read(org.apache.thrift.protocol.TProtocol prot, Table struct) throws org.apache.thrift.TException {
        }  
    @org.apache.thrift.annotation.Nullable
        setWriteIdIsSet(false);
    }
        if (isSetTableType()) {
            if (!(this_present_sd && that_present_sd)) return false;  
                return isSetTableName();  
            return lastComparison;
    public int hashCode() {
    }
                                struct.ownerType = org.opensearch.plugin.hive.metastore.PrincipalType.findByValue(iprot.readI32());
            if (!first) sb.append(", ");  
        if (!first) sb.append(", ");
    private static final org.apache.thrift.protocol.TField TEMPORARY_FIELD_DESC = new org.apache.thrift.protocol.TField(
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        first = false;
    public java.lang.String getOwner() {
        }  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)  
                return isSetRetention();
                return isSetCreateTime();  
    public boolean isSetCreationMetadata() {
        }
            throw new java.io.IOException(te);  
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __RETENTION_ISSET_ID);
        // check for sub-struct validity
        } else {
            _Fields.TABLE_TYPE,  
            if (!this.owner.equals(that.owner)) return false;  
                                struct.setDbNameIsSet(true);
        this.createTime = createTime;
    }  
     * Performs a deep copy on <i>other</i>.  
                    unsetViewOriginalText();
    }
        }
        StorageDescriptor sd,
        return this;  
                                    for (int _i118 = 0; _i118 < _list116.size; ++_i118) {  
                        _iter125.write(oprot);  
    }  
        public short getThriftFieldId() {
        }
        }
            } else {
        }
     *  
                org.apache.thrift.TFieldRequirementType.OPTIONAL,  
                case 15: // REWRITE_ENABLED
    @org.apache.thrift.annotation.Nullable
        LAST_ACCESS_TIME((short) 5, "lastAccessTime"),  
        switch (field) {
                "sd",  
                case 18: // OWNER_TYPE
                    oprot.writeString(struct.catName);
    public void unsetWriteId() {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                        case 6: // RETENTION  
                oprot.writeI32(struct.lastAccessTime);  
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */  
                }  
        PRIVILEGES((short) 13, "privileges"),
                        case 9: // PARAMETERS  
                            break;
                if (value == null) {
                oprot.writeFieldBegin(OWNER_FIELD_DESC);
        this.writeId = other.writeId;
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
        "createTime",
                optionals.set(3);
        this.dbName = null;  
        return _Fields.findByThriftId(fieldId);
                    struct.tableName = iprot.readString();
    }
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                    struct.setLastAccessTimeIsSet(true);  
            case PARAMETERS:  
        boolean that_present_ownerType = true && that.isSetOwnerType();  
                            }  
        this.privileges = privileges;
                oprot.writeI32(struct.createTime);  
        } catch (org.apache.thrift.TException te) {  
    );
    }  
    public Table setLastAccessTime(int lastAccessTime) {
            }  
            case LAST_ACCESS_TIME:
                } else {
            case PRIVILEGES:
        if (this_present_tableType || that_present_tableType) {
            case PARTITION_KEYS:
        if (field == null) {  
                    }
                        case 3: // OWNER  
            }  
    public void setPrivilegesIsSet(boolean value) {  
                            break;
    public void setTemporaryIsSet(boolean value) {
            new org.apache.thrift.meta_data.FieldMetaData(
        if (!value) {
                return lastComparison;
        org.apache.thrift.protocol.TType.STRING,
    public java.lang.String getTableName() {  
            oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);
                "viewExpandedText",  
        }  
            if (struct.isSetTemporary()) {
            case WRITE_ID:
            }  
                                        struct.partitionKeys.add(_elem117);  
                    struct.tableType = iprot.readString();
        /**
            case TEMPORARY:
    private static final org.apache.thrift.protocol.TField PRIVILEGES_FIELD_DESC = new org.apache.thrift.protocol.TField(  
    private static final int __RETENTION_ISSET_ID = 2;  
                    oprot.writeI32(struct.partitionKeys.size());
            if (this.retention != that.retention) return false;  
                    oprot.writeFieldBegin(CREATION_METADATA_FIELD_DESC);  
                return getTableType();  
        this.retention = retention;
                            _key131 = iprot.readString();
                                    iprot.readListEnd();
    public boolean equals(Table that) {
                        case 8: // PARTITION_KEYS
                oprot.writeFieldEnd();
                oprot.writeI32(struct.ownerType.getValue());
        hashCode = hashCode * 8191 + ((isSetCreationMetadata()) ? 131071 : 524287);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.writeId, other.writeId);  
            )
        tmpMap.put(
                }
            }  
        return this.sd;
    public Table setCreationMetadata(@org.apache.thrift.annotation.Nullable CreationMetadata creationMetadata) {  
            new org.apache.thrift.meta_data.FieldMetaData(
                break;  
                    }  
                                struct.viewOriginalText = iprot.readString();
                                    for (int _i122 = 0; _i122 < _map119.size; ++_i122) {  
        if (isSetTemporary()) {  
        if (sd != null) {  
                break;  
        tmpMap.put(  
    }  
    public int retention; // required
            oprot.writeFieldStop();  
        (short) 12
        boolean this_present_viewExpandedText = true && this.isSetViewExpandedText();
                    setCreateTime((java.lang.Integer) value);  
                } else {
                    oprot.writeFieldEnd();  
        CREATION_METADATA((short) 16, "creationMetadata"),
    }
        if (isSetTemporary()) {
                    unsetSd();
        }
            }  
    public Table(  
            try {
    public Table setViewExpandedText(@org.apache.thrift.annotation.Nullable java.lang.String viewExpandedText) {
            }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lastAccessTime, other.lastAccessTime);
        );
        if (!value) {
        REWRITE_ENABLED((short) 15, "rewriteEnabled"),
        } else {  
        if (isSetTableType()) hashCode = hashCode * 8191 + tableType.hashCode();  
        if (other.isSetSd()) {
        }
        this.parameters = null;  
                }
                                struct.setWriteIdIsSet(true);
                new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PrincipalType.class)
        hashCode = hashCode * 8191 + ((isSetSd()) ? 131071 : 524287);
        this.createTime = createTime;  
        }  
        } catch (org.apache.thrift.TException te) {
                    struct.viewExpandedText = iprot.readString();
                {
    public Table setSd(@org.apache.thrift.annotation.Nullable StorageDescriptor sd) {
    );
        if (this == that) return true;
                case 9: // PARAMETERS
            case CAT_NAME:
        return this.createTime;  
    public void unsetCreateTime() {  
        this.createTime = 0;  
        return (this.partitionKeys == null) ? null : this.partitionKeys.iterator();  
                                        _elem117.read(iprot);
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
    public boolean isSet(_Fields field) {
    public void setCreationMetadataIsSet(boolean value) {
        tmpMap.put(
        if (other.isSetViewExpandedText()) {
                        case 10: // VIEW_ORIGINAL_TEXT  
        if (other.isSetDbName()) {
                }  
        if (lastComparison != 0) {
                    struct.setSdIsSet(true);  
            sb.append(this.viewExpandedText);
        if (lastComparison != 0) {
        }  
                oprot.writeString(struct.viewExpandedText);
    public void setLastAccessTimeIsSet(boolean value) {
            if (struct.isSetPartitionKeys()) {
    @org.apache.thrift.annotation.Nullable
    public void unsetSd() {  
    }
            )  
                if (struct.isSetPrivileges()) {  
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
                            }
                new org.apache.thrift.meta_data.ListMetaData(
                if (incoming.get(6)) {  
    private static class TableTupleScheme extends org.apache.thrift.scheme.TupleScheme<Table> {
            if (!this.catName.equals(that.catName)) return false;
        if (isSetViewOriginalText()) hashCode = hashCode * 8191 + viewOriginalText.hashCode();  
                    struct.setCreationMetadataIsSet(true);  
                    struct.dbName = iprot.readString();
    /** Returns true if field retention is set (has been assigned a value) and false otherwise */
        if (this_present_lastAccessTime || that_present_lastAccessTime) {  
                }
                                struct.setViewExpandedTextIsSet(true);
    public Table setRewriteEnabled(boolean rewriteEnabled) {  
                            struct.parameters.size()  
                oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);  
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {  
        switch (field) {
        return this;
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __REWRITEENABLED_ISSET_ID);  
        }  
                }
            if (struct.isSetWriteId()) {
        return this;
            if (struct.isSetPrivileges()) {
    private byte __isset_bitfield = 0;
            case OWNER_TYPE:  
        }
                return getPrivileges();  
        tmpMap.put(
                } else {
        this.lastAccessTime = lastAccessTime;  
        boolean that_present_tableType = true && that.isSetTableType();  
        tmpMap.put(  
        @Override
    public @org.apache.thrift.annotation.Nullable java.lang.String tableName; // required  
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
        lastComparison = java.lang.Boolean.compare(isSetRetention(), other.isSetRetention());  
    public Table() {}
    );  
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, StorageDescriptor.class)
                } else {  
        if (lastComparison != 0) {
    }
        }
    public void unsetLastAccessTime() {
        return this.parameters;  
            first = false;  
                    unsetTemporary();  
        @org.apache.thrift.annotation.Nullable
            if (struct.catName != null) {
                } else {
            new org.apache.thrift.meta_data.FieldMetaData(  
                            }
        (short) 13  
        return this.dbName;
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            }
            case OWNER:  
                        new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.partitionKeys.size())
                            break;  
                break;
                oprot.writeString(struct.viewExpandedText);  
 *  @generated
    public int getLastAccessTime() {
                    oprot.writeFieldBegin(CAT_NAME_FIELD_DESC);
        OWNER_TYPE((short) 18, "ownerType"),
        _Fields.CREATION_METADATA,  
                if (struct.isSetOwnerType()) {
        return this;  
                            } else {  
            if (!first) sb.append(", ");  
                "rewriteEnabled",
            }
                return getLastAccessTime();  
                return getPartitionKeys();  
        public void write(org.apache.thrift.protocol.TProtocol oprot, Table struct) throws org.apache.thrift.TException {
    public Table setOwnerType(@org.apache.thrift.annotation.Nullable PrincipalType ownerType) {
                            } else {
                                struct.viewExpandedText = iprot.readString();
                                struct.catName = iprot.readString();  
        lastComparison = java.lang.Boolean.compare(isSetOwner(), other.isSetOwner());  
        if (!value) {  
        lastComparison = java.lang.Boolean.compare(isSetSd(), other.isSetSd());
    @Override  
    public Table setOwner(@org.apache.thrift.annotation.Nullable java.lang.String owner) {  
                                struct.createTime = iprot.readI32();
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    }  
        this.retention = retention;
    public Table setPartitionKeys(@org.apache.thrift.annotation.Nullable java.util.List<FieldSchema> partitionKeys) {  
            return lastComparison;
                if (incoming.get(4)) {
        switch (field) {
            }
                }
        }
    public java.util.Iterator<FieldSchema> getPartitionKeysIterator() {
                org.apache.thrift.TFieldRequirementType.OPTIONAL,  
        return this.retention;
            case VIEW_EXPANDED_TEXT:
            oprot.writeI32(struct.createTime);  
    private static final int __TEMPORARY_ISSET_ID = 3;
            }  
        return this.temporary;
            privileges.validate();
            return lastComparison;  
        if (lastComparison != 0) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                "dbName",
    }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
    private static final org.apache.thrift.protocol.TField OWNER_FIELD_DESC = new org.apache.thrift.protocol.TField(
            first = false;
                oprot.writeString(struct.viewOriginalText);
                oprot.writeFieldEnd();  
