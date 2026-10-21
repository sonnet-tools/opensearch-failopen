    public void setGrantorTypeIsSet(boolean value) {
                optionals.set(3);
            )
                            }
            __isset_bitfield = 0;
            java.util.BitSet optionals = new java.util.BitSet();
    }
            }
    public PrivilegeGrantInfo setGrantOption(boolean grantOption) {
                                struct.createTime = iprot.readI32();
                if (value == null) {
            return fields;
        return false;
        @Override
            new org.apache.thrift.meta_data.FieldMetaData(
        tmpMap.put(
    public void unsetGrantor() {
        CREATE_TIME((short) 2, "createTime"),
                case 2: // CREATE_TIME
                    struct.setGrantorTypeIsSet(true);
    static {
                    struct.setGrantOptionIsSet(true);
    public PrivilegeGrantInfo setPrivilege(@org.apache.thrift.annotation.Nullable java.lang.String privilege) {
            oprot.writeStructEnd();
            sb.append(this.grantor);
            if (struct.isSetPrivilege()) {
        @Override
        );
        throw new java.lang.IllegalStateException();
                }
            case GRANTOR_TYPE:
    }
            }
    }
        first = false;
        (short) 5
            _Fields,
                optionals.set(4);
            if (struct.isSetGrantOption()) {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }
        this.grantorType = null;
                    struct.setGrantorIsSet(true);
        }
                return lastComparison;
        }
    }
            }
    implements
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PrivilegeGrantInfoStandardSchemeFactory();
                            }
            case CREATE_TIME:
                    struct.privilege = iprot.readString();
        if (this == that) return true;
            }
    public _Fields fieldForId(int fieldId) {
        lastComparison = java.lang.Boolean.compare(isSetPrivilege(), other.isSetPrivilege());
        }
     * @see PrincipalType
        return this.createTime;
        org.apache.thrift.TBase<PrivilegeGrantInfo, PrivilegeGrantInfo._Fields>,
            _Fields.GRANTOR,
        }
        boolean this_present_privilege = true && this.isSetPrivilege();
                "createTime",
        }
            if (!(this_present_grantorType && that_present_grantorType)) return false;
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
        "grantOption",
            if (struct.grantor != null) {
            oprot.writeBool(struct.grantOption);
            iprot.incrementRecursionDepth();
        }
    }
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CREATETIME_ISSET_ID);
                            } else {
        @org.apache.thrift.annotation.Nullable
    @org.apache.thrift.annotation.Nullable
        java.lang.String privilege,
            throw new java.lang.IllegalArgumentException();
        if (lastComparison != 0) {
                    iprot.readFieldEnd();
                java.util.BitSet incoming = iprot.readBitSet(5);
    /**
    @Override
    // isset id assignments
    );
         * Find the _Fields constant that matches name, or null if its not found.
    }
                return lastComparison;
        setGrantOptionIsSet(true);
            new org.apache.thrift.meta_data.FieldMetaData(
        if (this_present_grantOption || that_present_grantOption) {
        if (this_present_grantor || that_present_grantor) {
                return isGrantOption();
        int createTime,
            if (struct.isSetGrantor()) {
        if (other.isSetGrantor()) {
        hashCode = hashCode * 8191 + ((isSetGrantorType()) ? 131071 : 524287);
    }
        try {
            }
    public int createTime; // required
        if (this.privilege == null) {
            if (struct.isSetPrivilege()) {
    public boolean isSetGrantOption() {
                oprot.writeFieldBegin(PRIVILEGE_FIELD_DESC);
                } else {
            return lastComparison;
    @Override
                if (incoming.get(3)) {
    /** Returns true if field privilege is set (has been assigned a value) and false otherwise */
            if (lastComparison != 0) {
        if (lastComparison != 0) {
        } else {
        }
                if (incoming.get(4)) {
    public void setGrantOptionIsSet(boolean value) {
        /**
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)
            try {
                break;
        this();
         * if it is not found.
            case GRANT_OPTION:
            }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grantOption, other.grantOption);
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
        return this.grantOption;
                return isSetCreateTime();
        private final short _thriftId;
         * Find the _Fields constant that matches fieldId, throwing an exception
    }
                    }
        if (isSetGrantorType()) hashCode = hashCode * 8191 + grantorType.getValue();
            case GRANTOR:
        }
        public static _Fields findByName(java.lang.String name) {
                optionals.set(2);
    }
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
            )
        lastComparison = java.lang.Boolean.compare(isSetCreateTime(), other.isSetCreateTime());
        first = false;
        boolean grantOption
    }
        /**
 */
    @Override
            this.privilege = other.privilege;
    @Override
        @Override
                if (value == null) {
     *
            case PRIVILEGE:
                    unsetGrantorType();
    private static class PrivilegeGrantInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<PrivilegeGrantInfo> {
        }
        }
    }
        PRIVILEGE((short) 1, "privilege"),
        boolean that_present_grantorType = true && that.isSetGrantorType();
                oprot.writeFieldEnd();
    /** Returns true if field grantor is set (has been assigned a value) and false otherwise */
         * Find the _Fields constant that matches fieldId, or null if its not found.
    public java.lang.String toString() {
        }
 * Autogenerated by Thrift Compiler (0.23.0)
    }
            return lastComparison;
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __GRANTOPTION_ISSET_ID);
    }
        sb.append(")");
/**
            oprot.writeFieldBegin(GRANT_OPTION_FIELD_DESC);
                }
    }
        boolean this_present_createTime = true;
        return this;
        public void write(org.apache.thrift.protocol.TProtocol oprot, PrivilegeGrantInfo struct) throws org.apache.thrift.TException {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTime, other.createTime);
                    unsetPrivilege();
        boolean this_present_grantor = true && this.isSetGrantor();
    @Override
        setCreateTimeIsSet(true);
        public java.lang.String getFieldName() {
        first = false;
        sb.append("grantor:");
        tmpMap.put(
                if (value == null) {
        public PrivilegeGrantInfoTupleScheme getScheme() {
        sb.append("grantorType:");
        Comparable<PrivilegeGrantInfo> {
            if (!(this_present_grantor && that_present_grantor)) return false;
            }
                    }
        org.apache.thrift.protocol.TType.BOOL,
        sb.append("privilege:");
    }
                } else {
        return sb.toString();
                            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
    }
                "grantOption",
        java.lang.String grantor,
        this.grantorType = grantorType;
        GRANTOR((short) 3, "grantor"),
            }
            .getScheme();
        this.grantOption = false;
        this.grantorType = null;
                            break;
        "grantor",
    public boolean isSet(_Fields field) {
                            } else {
            oprot.writeStructBegin(STRUCT_DESC);
                    struct.grantor = iprot.readString();
    /** Returns true if field grantOption is set (has been assigned a value) and false otherwise */
            case GRANT_OPTION:
    @Override
        tmpMap.put(
        java.lang.StringBuilder sb = new java.lang.StringBuilder("PrivilegeGrantInfo(");
    }
            )
    public PrivilegeGrantInfo(PrivilegeGrantInfo other) {
        /**
        if (!first) sb.append(", ");
    @Override
        if (this_present_grantorType || that_present_grantorType) {
        );
        @Override
        boolean this_present_grantorType = true && this.isSetGrantorType();
        return this.privilege;
         *
                oprot.writeBool(struct.grantOption);
        lastComparison = java.lang.Boolean.compare(isSetGrantor(), other.isSetGrantor());
            if (struct.isSetCreateTime()) {
        if (that instanceof PrivilegeGrantInfo) return this.equals((PrivilegeGrantInfo) that);
                    struct.setPrivilegeIsSet(true);
            return lastComparison;
            if (lastComparison != 0) {
        }
        }
                break;
            _Fields.CREATE_TIME,
    @Override
        @Override
        switch (field) {
                break;
        }
    public void setPrivilegeIsSet(boolean value) {
    public PrivilegeGrantInfo setGrantorType(@org.apache.thrift.annotation.Nullable PrincipalType grantorType) {
                    schemeField = iprot.readFieldBegin();
        }
            return _thriftId;
    private static class PrivilegeGrantInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<PrivilegeGrantInfo> {
            if (!this.grantorType.equals(that.grantorType)) return false;
    public boolean isSetGrantor() {
        org.apache.thrift.protocol.TType.STRING,
        if (!first) sb.append(", ");
            _Fields.PRIVILEGE,
                    return GRANTOR;
            try {
            oprot.writeBitSet(optionals, 5);
    }
        tmpMap.put(
            if (struct.privilege != null) {
                        case 2: // CREATE_TIME
        if (isSetGrantorType()) {
            if (!this.grantor.equals(that.grantor)) return false;
        return true;
    public PrincipalType getGrantorType() {
    }
         */
    @org.apache.thrift.annotation.Nullable
        this.createTime = other.createTime;
         */
            this.privilege = null;
                    setGrantorType((PrincipalType) value);
    }
    public PrivilegeGrantInfo deepCopy() {
        this.grantOption = grantOption;
    }
            return lastComparison;
        }
            return new PrivilegeGrantInfoStandardScheme();
     * @see PrincipalType
            if (this.createTime != that.createTime) return false;
        setGrantOptionIsSet(false);
        boolean this_present_grantOption = true;
            return lastComparison;
        } else {
                return isSetGrantorType();
    );
    }
                    setCreateTime((java.lang.Integer) value);
                                struct.setPrivilegeIsSet(true);
    private static final org.apache.thrift.protocol.TField GRANT_OPTION_FIELD_DESC = new org.apache.thrift.protocol.TField(
                optionals.set(0);
                        case 5: // GRANT_OPTION
                break;
        }
    );
                new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PrincipalType.class)
    }
        }
        hashCode = hashCode * 8191 + ((isSetPrivilege()) ? 131071 : 524287);
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    );
            this.grantorType = null;
    public @org.apache.thrift.annotation.Nullable java.lang.String grantor; // required
        return this;
                }
                "grantor",
                    return null;
                    unsetCreateTime();
    public boolean grantOption; // required
        }
                oprot.writeI32(struct.grantorType.getValue());
        }
        try {
        }
            new org.apache.thrift.meta_data.FieldMetaData(
            if (!(this_present_grantOption && that_present_grantOption)) return false;
                break;
                return getGrantor();
            prot.incrementRecursionDepth();
    @org.apache.thrift.annotation.Nullable
                            } else {
                oprot.writeString(struct.grantor);
        setCreateTimeIsSet(false);
            }
        boolean that_present_createTime = true;
     */
    }
        public void read(org.apache.thrift.protocol.TProtocol iprot, PrivilegeGrantInfo struct) throws org.apache.thrift.TException {
     *
    public PrivilegeGrantInfo(
        this.privilege = privilege;
            oprot.writeFieldStop();
        return new PrivilegeGrantInfo(this);
        first = false;
                return lastComparison;
        @org.apache.thrift.annotation.Nullable
            return byName.get(name);
        if (field == null) {
        return this.privilege != null;
    private static final org.apache.thrift.protocol.TField GRANTOR_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
                    struct.setCreateTimeIsSet(true);
    );
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.privilege, other.privilege);
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    public boolean isSetPrivilege() {
        (short) 3
        this.createTime = createTime;
                    return PRIVILEGE;
                case 4: // GRANTOR_TYPE
        org.apache.thrift.protocol.TType.I32,
            throw new java.io.IOException(te);
    private static class PrivilegeGrantInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        this.createTime = createTime;
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                default:
                            }
            }
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        public PrivilegeGrantInfoStandardScheme getScheme() {
                return isSetGrantor();
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            )
        );
        this.grantor = grantor;
                    setPrivilege((java.lang.String) value);
    private static final int __CREATETIME_ISSET_ID = 0;
        if (!first) sb.append(", ");
        public static _Fields findByThriftId(int fieldId) {
        }
    }
                        break;
    }
        }
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
                case 1: // PRIVILEGE
            new org.apache.thrift.meta_data.FieldMetaData(
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                if (incoming.get(0)) {
        hashCode = hashCode * 8191 + ((grantOption) ? 131071 : 524287);
    }
                struct.validate();
        // check for sub-struct validity
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    public void unsetCreateTime() {
                            break;
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PrivilegeGrantInfo");
package org.opensearch.plugin.hive.metastore;
    public PrivilegeGrantInfo setGrantor(@org.apache.thrift.annotation.Nullable java.lang.String grantor) {
                            break;
                return getCreateTime();
    }
        if (lastComparison != 0) {
    public @org.apache.thrift.annotation.Nullable java.lang.String privilege; // required
                    setGrantOption((java.lang.Boolean) value);
                    struct.grantorType = org.opensearch.plugin.hive.metastore.PrincipalType.findByValue(iprot.readI32());
    public java.lang.String getPrivilege() {
                iprot.readStructBegin();
    public @org.apache.thrift.annotation.Nullable PrincipalType grantorType; // required
        if (!value) {
            sb.append("null");
        sb.append("createTime:");
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __GRANTOPTION_ISSET_ID, value);
            sb.append("null");
                                struct.setCreateTimeIsSet(true);
        this.grantOption = other.grantOption;
        this.grantorType = grantorType;
         */
        }
     * Performs a deep copy on <i>other</i>.
                oprot.writeFieldBegin(GRANTOR_FIELD_DESC);
                return isSetGrantOption();
    }
    @Override
    }
        "grantorType",
                        case 3: // GRANTOR
        (short) 1
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                } else {
                    switch (schemeField.id) {
                                struct.setGrantorIsSet(true);
        throw new java.lang.IllegalStateException();
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PrivilegeGrantInfo.class, metaDataMap);
        @Override
    public void unsetGrantorType() {
                if (value == null) {
    }
                oprot.writeFieldEnd();
        boolean that_present_privilege = true && that.isSetPrivilege();
        @Override
        }
            sb.append(this.grantorType);
            }
        public short getThriftFieldId() {
        return _Fields.findByThriftId(fieldId);
            _Fields.GRANT_OPTION,
            if (lastComparison != 0) {
     * @see PrincipalType
    public void setGrantorIsSet(boolean value) {
        this.grantOption = grantOption;
            oprot.writeFieldEnd();
                }
        if (isSetGrantor()) {
        if (other.isSetPrivilege()) {
            return getClass().getName().compareTo(other.getClass().getName());
                }
    }
        "createTime",
        static {
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
    /** Returns true if field grantorType is set (has been assigned a value) and false otherwise */
                iprot.decrementRecursionDepth();
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        int lastComparison = 0;
            _Fields fields = findByThriftId(fieldId);
    @Override
    }
    public PrivilegeGrantInfo() {}
        }
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
    }
            _thriftId = thriftId;
        return this.grantor;
    }
        Cloneable,
    public java.lang.String getGrantor() {
        return 0;
    }
                }
            }
                            } else {
    public void unsetPrivilege() {
                    return GRANTOR_TYPE;
        first = false;
            )
                                struct.setGrantorTypeIsSet(true);
            case PRIVILEGE:
        if (this_present_createTime || that_present_createTime) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
        }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                    unsetGrantOption();
        }
            switch (fieldId) {
                oprot.writeFieldBegin(GRANTOR_TYPE_FIELD_DESC);
        return this;
        __isset_bitfield = other.__isset_bitfield;
            sb.append("null");
            if (struct.isSetGrantorType()) {
            case CREATE_TIME:
                return lastComparison;
    public java.lang.Object getFieldValue(_Fields field) {
        org.apache.thrift.protocol.TType.I32,
        }
    private byte __isset_bitfield = 0;
                                struct.grantorType = org.opensearch.plugin.hive.metastore.PrincipalType.findByValue(iprot.readI32());
                    unsetGrantor();
        if (!first) sb.append(", ");
    }
            case GRANTOR_TYPE:
        if (isSetGrantor()) hashCode = hashCode * 8191 + grantor.hashCode();
    public boolean equals(java.lang.Object that) {
    @Override
 *  @generated
    }
            }
        scheme(oprot).write(oprot, this);
        tmpMap.put(
                }
            struct.validate();
        if (!value) {
        java.io.Serializable,
        this.privilege = null;
        if (this.grantor == null) {
            case PRIVILEGE:
            }
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PrivilegeGrantInfoTupleSchemeFactory();
            if (lastComparison != 0) {
            this.grantorType = other.grantorType;
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
            if (!(this_present_createTime && that_present_createTime)) return false;
                } else {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    public int compareTo(PrivilegeGrantInfo other) {
        }
        }
     */
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        if (isSetPrivilege()) {
            new org.apache.thrift.meta_data.FieldMetaData(
                                struct.privilege = iprot.readString();
            } finally {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        hashCode = hashCode * 8191 + ((isSetGrantor()) ? 131071 : 524287);
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        if (isSetPrivilege()) hashCode = hashCode * 8191 + privilege.hashCode();
        int hashCode = 1;
        if (other.isSetGrantorType()) {
                oprot.writeFieldEnd();
        return this;
     */
                return lastComparison;
            if (lastComparison != 0) {
                optionals.set(1);
        } catch (org.apache.thrift.TException te) {
                "privilege",
    public void setCreateTimeIsSet(boolean value) {
    public boolean isSetCreateTime() {
        );
            case GRANTOR_TYPE:
    }
                }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        if (!value) {
        hashCode = hashCode * 8191 + createTime;
}
            }
        PrincipalType grantorType,
        }
    public void clear() {
            }
            oprot.writeFieldEnd();
        sb.append("grantOption:");
                return isSetPrivilege();
        public void write(org.apache.thrift.protocol.TProtocol prot, PrivilegeGrantInfo struct) throws org.apache.thrift.TException {
                // check for required fields of primitive type, which can't be checked in the validate method
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grantorType, other.grantorType);
            if (struct.grantorType != null) {
    public boolean isSetGrantorType() {
    }
     *
     */
        }
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __GRANTOPTION_ISSET_ID);
        public static _Fields findByThriftIdOrThrow(int fieldId) {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
    private static final int __GRANTOPTION_ISSET_ID = 1;
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
        }
 *
        }
                if (incoming.get(1)) {
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CREATETIME_ISSET_ID);
        "privilege",
        boolean that_present_grantor = true && that.isSetGrantor();
            return _fieldName;
    @org.apache.thrift.annotation.Nullable
            return new PrivilegeGrantInfoTupleScheme();
        GRANTOR_TYPE((short) 4, "grantorType"),
    /**
            if (struct.isSetGrantorType()) {
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                }
    public void validate() throws org.apache.thrift.TException {
        }
    }
public class PrivilegeGrantInfo
        }
            oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);
        // check for required fields
                        default:
        org.apache.thrift.protocol.TType.STRING,
        if (lastComparison != 0) {
        switch (field) {
         * @see PrincipalType
                return getPrivilege();
                if (incoming.get(2)) {
                byName.put(field.getFieldName(), field);
        this.grantor = grantor;
    public PrivilegeGrantInfo setCreateTime(int createTime) {
                return getGrantorType();
                org.apache.thrift.protocol.TField schemeField;
    private static final org.apache.thrift.protocol.TField PRIVILEGE_FIELD_DESC = new org.apache.thrift.protocol.TField(
    /** Returns true if field createTime is set (has been assigned a value) and false otherwise */
    public void unsetGrantOption() {
        lastComparison = java.lang.Boolean.compare(isSetGrantorType(), other.isSetGrantorType());
    private static final org.apache.thrift.protocol.TField GRANTOR_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField(
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
    public int hashCode() {
        _Fields(short thriftId, java.lang.String fieldName) {
        lastComparison = java.lang.Boolean.compare(isSetGrantOption(), other.isSetGrantOption());
    public boolean isGrantOption() {
    }
    public boolean equals(PrivilegeGrantInfo that) {
            if (struct.isSetGrantor()) {
                oprot.writeString(struct.privilege);
        if (that == null) return false;
        if (this_present_privilege || that_present_privilege) {
    }
        return hashCode;
            oprot.writeI32(struct.createTime);
    }
    private static class PrivilegeGrantInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
            }
    }
                } else {
        } else {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
            case CREATE_TIME:
                    struct.grantOption = iprot.readBool();
            }
    }
        this.privilege = null;
        (short) 4
        sb.append(this.createTime);
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                    return GRANT_OPTION;
                            break;
        boolean first = true;
        if (this.grantorType == null) {
         */
                    struct.createTime = iprot.readI32();
        (short) 2
                            } else {
                "grantorType",
    public int getCreateTime() {
        }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            sb.append(this.privilege);
                                struct.setGrantOptionIsSet(true);
            case GRANTOR:
            if (struct.isSetGrantOption()) {
        setCreateTimeIsSet(true);
    }
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CREATETIME_ISSET_ID, value);
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                    setGrantor((java.lang.String) value);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        } catch (org.apache.thrift.TException te) {
        return this.grantorType;
            if (!(this_present_privilege && that_present_privilege)) return false;
        return this.grantorType != null;
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        if (!getClass().equals(other.getClass())) {
        }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            if (!this.privilege.equals(that.privilege)) return false;
                case 3: // GRANTOR
                                struct.grantOption = iprot.readBool();
        return this;
        switch (field) {
        private final java.lang.String _fieldName;
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            throw new java.io.IOException(te);
                if (value == null) {
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        sb.append(this.grantOption);
            _Fields.GRANTOR_TYPE,
        return this.grantor != null;
        }
            this.grantor = other.grantor;
            } finally {
    ) {
                oprot.writeI32(struct.grantorType.getValue());
                oprot.writeString(struct.grantor);
    }
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                case 5: // GRANT_OPTION
        if (isSetCreateTime()) {
                while (true) {
                        case 1: // PRIVILEGE
                    return CREATE_TIME;
        this.grantor = null;
            _fieldName = fieldName;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        case 4: // GRANTOR_TYPE
                            break;
    private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
                oprot.writeString(struct.privilege);
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        @Override
        this.privilege = privilege;
        /**
        this.grantor = null;
        scheme(iprot).read(iprot, this);
                            }
            case GRANTOR:
    /**
                iprot.readStructEnd();
            this.grantor = null;
        public void read(org.apache.thrift.protocol.TProtocol prot, PrivilegeGrantInfo struct) throws org.apache.thrift.TException {
    }
        if (lastComparison != 0) {
            case GRANT_OPTION:
                }
        }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grantor, other.grantor);
                            }
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
            }
        this.createTime = 0;
    }
            if (this.grantOption != that.grantOption) return false;
        boolean that_present_grantOption = true;
                                struct.grantor = iprot.readString();
        GRANT_OPTION((short) 5, "grantOption");
    @Override
        );
        }
                prot.decrementRecursionDepth();
            if (struct.isSetCreateTime()) {
        setGrantOptionIsSet(true);
                oprot.writeI32(struct.createTime);
    /**
        if (isSetGrantOption()) {
    @org.apache.thrift.annotation.Nullable
            }
