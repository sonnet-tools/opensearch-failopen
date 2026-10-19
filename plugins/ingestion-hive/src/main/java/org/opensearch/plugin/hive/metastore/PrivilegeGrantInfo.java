                }
        }  
        if (lastComparison != 0) {
        first = false;
                                struct.grantor = iprot.readString();
        public PrivilegeGrantInfoTupleScheme getScheme() {  
        }
            oprot.writeStructEnd();
        boolean that_present_privilege = true && that.isSetPrivilege();  
        sb.append(")");
        return this;
                optionals.set(0);  
            return fields;
            try {
            }
        }  
     *
        return new PrivilegeGrantInfo(this);
        lastComparison = java.lang.Boolean.compare(isSetGrantor(), other.isSetGrantor());
    public void setGrantorTypeIsSet(boolean value) {
        CREATE_TIME((short) 2, "createTime"),
    }
                            break;
            throw new java.lang.IllegalArgumentException();
    }
        throw new java.lang.IllegalStateException();
            return new PrivilegeGrantInfoStandardScheme();
    public PrivilegeGrantInfo setPrivilege(@org.apache.thrift.annotation.Nullable java.lang.String privilege) {
                if (incoming.get(2)) {
    }
        }
    public java.lang.Object getFieldValue(_Fields field) {  
        this.privilege = privilege;
    );
        return true;
                } else {
                if (value == null) {
                return getPrivilege();  
        boolean that_present_grantor = true && that.isSetGrantor();
        return this;
            if (struct.isSetCreateTime()) {  
            new org.apache.thrift.meta_data.FieldMetaData(
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;  
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __GRANTOPTION_ISSET_ID, value);  
 *  @generated
        return hashCode;  
            if (this.grantOption != that.grantOption) return false;
     *
            }
                "createTime",
            }
                return lastComparison;
        setGrantOptionIsSet(true);
        }
            case GRANTOR:  
            this.privilege = other.privilege;
            case GRANTOR:
        java.lang.String privilege,
        }
                if (incoming.get(4)) {  
            sb.append(this.privilege);
    }  
                }
    }  
        this.privilege = null;  
    @Override
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
        if (this_present_grantor || that_present_grantor) {  
        public PrivilegeGrantInfoStandardScheme getScheme() {
    }
        public void write(org.apache.thrift.protocol.TProtocol oprot, PrivilegeGrantInfo struct) throws org.apache.thrift.TException {  
        // check for required fields
                default:
                }
    }  
    public java.lang.String getGrantor() {
        hashCode = hashCode * 8191 + ((isSetGrantor()) ? 131071 : 524287);
                }  
        boolean that_present_grantOption = true;
    public void setGrantOptionIsSet(boolean value) {
            if (struct.isSetGrantOption()) {  
        this.grantor = grantor;  
            if (struct.isSetGrantOption()) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    );  
        @org.apache.thrift.annotation.Nullable
    }  
                byName.put(field.getFieldName(), field);  
        }  
                }
                                struct.createTime = iprot.readI32();  
    public boolean isSetCreateTime() {
            if (struct.grantorType != null) {
            case CREATE_TIME:
        tmpMap.put(
    private static final int __GRANTOPTION_ISSET_ID = 1;
    }  
        (short) 5
                    return CREATE_TIME;
    public boolean isSetGrantOption() {
        }
                return isSetPrivilege();  
        } catch (org.apache.thrift.TException te) {  
        boolean that_present_grantorType = true && that.isSetGrantorType();  
    public PrivilegeGrantInfo setGrantorType(@org.apache.thrift.annotation.Nullable PrincipalType grantorType) {
        if (lastComparison != 0) {  
                break;
    }
            }
            )
        );
        this.grantorType = grantorType;  
    public PrivilegeGrantInfo(PrivilegeGrantInfo other) {
    }
                }
                }  
            if (struct.isSetPrivilege()) {
                    return PRIVILEGE;
            return _fieldName;
                    return null;  
        setCreateTimeIsSet(true);
                struct.validate();
    public int compareTo(PrivilegeGrantInfo other) {
                oprot.writeFieldBegin(GRANTOR_TYPE_FIELD_DESC);  
                    struct.setGrantOptionIsSet(true);
        if (isSetGrantor()) hashCode = hashCode * 8191 + grantor.hashCode();
        org.apache.thrift.protocol.TType.STRING,
            case GRANT_OPTION:
        (short) 3  
            this.grantorType = other.grantorType;  
                }
                return getCreateTime();  
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __CREATETIME_ISSET_ID);
        }
        lastComparison = java.lang.Boolean.compare(isSetGrantOption(), other.isSetGrantOption());  
                            }
                optionals.set(4);  
        }
        lastComparison = java.lang.Boolean.compare(isSetGrantorType(), other.isSetGrantorType());
        (short) 2
        return this;
    private static final org.apache.thrift.protocol.TField GRANT_OPTION_FIELD_DESC = new org.apache.thrift.protocol.TField(
                "grantor",  
                break;  
                oprot.writeFieldEnd();
            __isset_bitfield = 0;
            }  
        /**
        }
        throw new java.lang.IllegalStateException();  
        @Override
     * @see PrincipalType  
                    return GRANTOR_TYPE;
            try {
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __CREATETIME_ISSET_ID);  
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        this.grantor = null;
                if (incoming.get(1)) {  
            return lastComparison;
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __GRANTOPTION_ISSET_ID);  
        boolean this_present_privilege = true && this.isSetPrivilege();
        (short) 1
        );  
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        }
        setCreateTimeIsSet(false);
    }
        _Fields(short thriftId, java.lang.String fieldName) {
        public void write(org.apache.thrift.protocol.TProtocol prot, PrivilegeGrantInfo struct) throws org.apache.thrift.TException {
        this.createTime = createTime;  
        return this.grantorType;
            case PRIVILEGE:  
            if (struct.isSetCreateTime()) {
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    public boolean equals(java.lang.Object that) {
            oprot.writeFieldBegin(CREATE_TIME_FIELD_DESC);  
        setGrantOptionIsSet(false);
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        hashCode = hashCode * 8191 + ((grantOption) ? 131071 : 524287);
        }
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            )  
    @org.apache.thrift.annotation.Nullable
        boolean this_present_grantOption = true;  
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                                struct.grantorType = org.opensearch.plugin.hive.metastore.PrincipalType.findByValue(iprot.readI32());
        }
    }
        "createTime",
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __GRANTOPTION_ISSET_ID);
    );
            }
        first = false;  
    public PrivilegeGrantInfo() {}
        PRIVILEGE((short) 1, "privilege"),
        }
        int createTime,
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PrivilegeGrantInfo");  
                return lastComparison;
            }
            this.grantorType = null;  
        switch (field) {
                            }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grantorType, other.grantorType);
    public PrivilegeGrantInfo setCreateTime(int createTime) {
            if (struct.isSetGrantor()) {
        if (!value) {
            if (lastComparison != 0) {
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
        }
        this.createTime = createTime;  
            throw new java.io.IOException(te);  
    );  
        @Override
        setCreateTimeIsSet(true);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
        Comparable<PrivilegeGrantInfo> {
            sb.append("null");
                    switch (schemeField.id) {
                case 5: // GRANT_OPTION  
    public void setCreateTimeIsSet(boolean value) {
        this.grantorType = null;
                        case 2: // CREATE_TIME
    }
        boolean first = true;
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
    }  
        java.lang.String grantor,  
        tmpMap.put(  
        "grantorType",  
                // check for required fields of primitive type, which can't be checked in the validate method
        return false;
        this();
     *
    public boolean isSetGrantorType() {  
        return this.grantor;
        @Override
                optionals.set(1);  
        tmpMap.put(
                optionals.set(2);  
            oprot.writeI32(struct.createTime);
            }
    }
        }
            sb.append("null");  
            sb.append(this.grantor);
        if (field == null) {  
            new org.apache.thrift.meta_data.FieldMetaData(  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grantOption, other.grantOption);
    @Override
            }
                            break;  
        this.grantor = null;  
            }
                            } else {
                iprot.readStructBegin();
    public int hashCode() {
                    return GRANTOR;  
                    struct.createTime = iprot.readI32();
        if (other.isSetPrivilege()) {
            case GRANT_OPTION:
            sb.append("null");  
                    unsetGrantor();  
    }
    @org.apache.thrift.annotation.Nullable
            _Fields.GRANTOR,
        }  
                oprot.writeFieldBegin(PRIVILEGE_FIELD_DESC);
        if (!first) sb.append(", ");
        public short getThriftFieldId() {
        switch (field) {
            this.grantor = other.grantor;  
                return isSetGrantor();
            if (struct.isSetPrivilege()) {  
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    private static final org.apache.thrift.protocol.TField GRANTOR_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField(
    }
        }  
            struct.validate();
    @Override
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {  
        sb.append("privilege:");
         */
    }
                return isGrantOption();  
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                        default:  
        @Override
        public java.lang.String getFieldName() {  
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    }  
        }
        if (this_present_grantorType || that_present_grantorType) {
            _Fields.GRANT_OPTION,
                oprot.writeString(struct.grantor);
    static {
        }  
        if (isSetGrantOption()) {
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PrivilegeGrantInfo.class, metaDataMap);
    }
            case GRANTOR:
    // isset id assignments
public class PrivilegeGrantInfo  
                } else {
    public boolean isSetPrivilege() {  
            case PRIVILEGE:
                "grantorType",
                return isSetGrantOption();
         */
        }  
            return getClass().getName().compareTo(other.getClass().getName());  
        );
                return getGrantorType();  
        if (this_present_grantOption || that_present_grantOption) {
    }  
                        break;
        if (that instanceof PrivilegeGrantInfo) return this.equals((PrivilegeGrantInfo) that);  
        }
            if (struct.isSetGrantorType()) {  
                                struct.privilege = iprot.readString();
        }
        }  
            _Fields,  
    }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        this.createTime = 0;
        public static _Fields findByThriftIdOrThrow(int fieldId) {
        /**
            case GRANT_OPTION:
                            } else {
         *
    /** Returns true if field grantorType is set (has been assigned a value) and false otherwise */
                    struct.setGrantorTypeIsSet(true);
        GRANTOR_TYPE((short) 4, "grantorType"),
            if (struct.isSetGrantor()) {  
    private static final int __CREATETIME_ISSET_ID = 0;  
        @Override
    }  
            return lastComparison;
            case GRANTOR_TYPE:
            case GRANTOR_TYPE:  
            )
                            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
        this.grantOption = other.grantOption;
        first = false;
    public PrivilegeGrantInfo(  
        "privilege",  
                org.apache.thrift.TFieldRequirementType.DEFAULT,  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            case GRANTOR_TYPE:
        return this.grantOption;
            }
            oprot.writeStructBegin(STRUCT_DESC);  
         * @see PrincipalType  
    }
                    }  
    private static class PrivilegeGrantInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<PrivilegeGrantInfo> {  
    @Override
        if (this.privilege == null) {
        }
            if (lastComparison != 0) {
            if (struct.isSetGrantorType()) {
}
                iprot.readStructEnd();
            return lastComparison;  
        private final short _thriftId;
            return _thriftId;
        }
                            break;
                } else {  
                case 4: // GRANTOR_TYPE
                new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PrincipalType.class)
            )
        boolean that_present_createTime = true;
     */
        sb.append("grantor:");
    }
        boolean grantOption
        this.grantOption = grantOption;
 */
        if (this == that) return true;  
        if (this.grantorType == null) {
        this.grantorType = null;
        );
                        case 1: // PRIVILEGE
         */
            if (!(this_present_grantorType && that_present_grantorType)) return false;
    @Override  
        sb.append(this.grantOption);  
            return lastComparison;
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.privilege, other.privilege);
                oprot.writeString(struct.privilege);
        }  
     * @see PrincipalType  
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PrivilegeGrantInfoTupleSchemeFactory();
        scheme(oprot).write(oprot, this);
                } else {
                return lastComparison;
    }
    public PrincipalType getGrantorType() {  
    public _Fields fieldForId(int fieldId) {  
        org.apache.thrift.protocol.TType.I32,  
            }
    }
        }
        this.privilege = null;
    );
        PrincipalType grantorType,
        org.apache.thrift.protocol.TType.STRING,
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PrivilegeGrantInfoStandardSchemeFactory();
    @Override  
            throw new java.io.IOException(te);
            if (!this.privilege.equals(that.privilege)) return false;  
    }
    public java.lang.String getPrivilege() {
                oprot.writeString(struct.privilege);  
        if (this.grantor == null) {
    }  
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
         */  
                oprot.writeString(struct.grantor);
                break;  
                            break;
                if (value == null) {  
     * @see PrincipalType  
    }  
            }
        boolean this_present_grantor = true && this.isSetGrantor();
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */  
 *
                return isSetGrantorType();  
                if (value == null) {  
        boolean this_present_grantorType = true && this.isSetGrantorType();
            _Fields fields = findByThriftId(fieldId);  
        if (isSetGrantorType()) {  
                                struct.setPrivilegeIsSet(true);
                }
    public PrivilegeGrantInfo setGrantOption(boolean grantOption) {
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                    unsetGrantOption();
        if (lastComparison != 0) {
                    setGrantor((java.lang.String) value);
        public static _Fields findByThriftId(int fieldId) {
 * Autogenerated by Thrift Compiler (0.23.0)
        hashCode = hashCode * 8191 + createTime;
                oprot.writeI32(struct.grantorType.getValue());
        sb.append(this.createTime);
        }
        }
    private static class PrivilegeGrantInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        java.io.Serializable,  
        Cloneable,
         * Find the _Fields constant that matches fieldId, or null if its not found.
        org.apache.thrift.protocol.TType.I32,
    @Override
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)  
                return lastComparison;  
                    struct.grantor = iprot.readString();
    /**
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;  
            if (this.createTime != that.createTime) return false;
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                    setGrantOption((java.lang.Boolean) value);  
    }
        );  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
    public PrivilegeGrantInfo setGrantor(@org.apache.thrift.annotation.Nullable java.lang.String grantor) {
    public boolean isSetGrantor() {  
                    struct.grantorType = org.opensearch.plugin.hive.metastore.PrincipalType.findByValue(iprot.readI32());  
        }  
        }  
            new org.apache.thrift.meta_data.FieldMetaData(  
            case CREATE_TIME:
                if (incoming.get(0)) {
                                struct.setGrantorIsSet(true);  
        return _Fields.findByThriftId(fieldId);
            if (!(this_present_privilege && that_present_privilege)) return false;
        return this.createTime;
     * Performs a deep copy on <i>other</i>.  
                break;
        tmpMap.put(
                    struct.grantOption = iprot.readBool();
        /**
                            }
                                struct.setGrantorTypeIsSet(true);
        }
    private byte __isset_bitfield = 0;
        if (!first) sb.append(", ");
        int hashCode = 1;  
        try {
            oprot.writeBitSet(optionals, 5);
        if (that == null) return false;
package org.opensearch.plugin.hive.metastore;  
    @org.apache.thrift.annotation.Nullable  
         * Find the _Fields constant that matches fieldId, throwing an exception
                if (incoming.get(3)) {
    }
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
    public boolean isSet(_Fields field) {
    public java.lang.String toString() {  
        @org.apache.thrift.annotation.Nullable
            if (!this.grantorType.equals(that.grantorType)) return false;  
            }
            }  
                while (true) {
    }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            oprot.writeFieldStop();
                    schemeField = iprot.readFieldBegin();  
    /** Returns true if field privilege is set (has been assigned a value) and false otherwise */
        public void read(org.apache.thrift.protocol.TProtocol prot, PrivilegeGrantInfo struct) throws org.apache.thrift.TException {  
    /** Returns true if field createTime is set (has been assigned a value) and false otherwise */  
                return isSetCreateTime();
        if (isSetPrivilege()) {  
        org.apache.thrift.TBase<PrivilegeGrantInfo, PrivilegeGrantInfo._Fields>,
        org.apache.thrift.protocol.TType.BOOL,  
                }
     */
                oprot.writeFieldBegin(GRANTOR_FIELD_DESC);
                if (value == null) {
    private static final org.apache.thrift.protocol.TField CREATE_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
                            }
        tmpMap.put(
    /**
                            } else {
                            break;  
        } catch (org.apache.thrift.TException te) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grantor, other.grantor);  
    /** Returns true if field grantOption is set (has been assigned a value) and false otherwise */  
        } else {
    }
        try {  
        return this;
            sb.append(this.grantorType);
    }
            _fieldName = fieldName;  
        this.grantor = grantor;
                case 2: // CREATE_TIME  
            java.util.BitSet optionals = new java.util.BitSet();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                oprot.writeI32(struct.grantorType.getValue());
    public void unsetCreateTime() {
            oprot.writeBool(struct.grantOption);
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    public int getCreateTime() {
        if (isSetGrantorType()) hashCode = hashCode * 8191 + grantorType.getValue();
        return sb.toString();  
     */
        if (other.isSetGrantorType()) {
    @org.apache.thrift.annotation.Nullable
    }
    /** Returns true if field grantor is set (has been assigned a value) and false otherwise */
        boolean this_present_createTime = true;  
                oprot.writeFieldEnd();  
            if (!(this_present_grantor && that_present_grantor)) return false;
        static {
            oprot.writeFieldEnd();
        sb.append("grantorType:");  
        } else {
        if (other.isSetGrantor()) {
            if (struct.privilege != null) {
        } else {  
        }
        public static _Fields findByName(java.lang.String name) {  
        // check for sub-struct validity
                    struct.setPrivilegeIsSet(true);
    }
                        case 3: // GRANTOR  
        if (isSetPrivilege()) hashCode = hashCode * 8191 + privilege.hashCode();  
            switch (fieldId) {  
            return lastComparison;
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    public @org.apache.thrift.annotation.Nullable PrincipalType grantorType; // required
                    setGrantorType((PrincipalType) value);
    }
        if (this_present_createTime || that_present_createTime) {
                case 3: // GRANTOR
                    setCreateTime((java.lang.Integer) value);  
        }
            }
                if (value == null) {
            )
            }  
        }  
                break;
            this.grantor = null;  
    }  
                oprot.writeBool(struct.grantOption);
                            }  
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.  
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        lastComparison = java.lang.Boolean.compare(isSetCreateTime(), other.isSetCreateTime());  
                    unsetPrivilege();
    }
                org.apache.thrift.protocol.TField schemeField;  
    @Override
            }
        if (lastComparison != 0) {
                }  
                iprot.decrementRecursionDepth();
                "privilege",
    }  
                oprot.writeI32(struct.createTime);
            new org.apache.thrift.meta_data.FieldMetaData(
            if (struct.grantor != null) {  
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.createTime, other.createTime);
                    struct.setGrantorIsSet(true);  
                return lastComparison;  
        }
                    }
                        case 5: // GRANT_OPTION
    private static final org.apache.thrift.protocol.TField PRIVILEGE_FIELD_DESC = new org.apache.thrift.protocol.TField(
                oprot.writeFieldEnd();
            oprot.writeFieldBegin(GRANT_OPTION_FIELD_DESC);
            if (!(this_present_grantOption && that_present_grantOption)) return false;  
        }
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
        switch (field) {
    public void setPrivilegeIsSet(boolean value) {
         * Find the _Fields constant that matches name, or null if its not found.  
    public boolean equals(PrivilegeGrantInfo that) {
        sb.append("grantOption:");
                    struct.privilege = iprot.readString();  
    public void unsetGrantor() {
            iprot.incrementRecursionDepth();
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        return this.privilege != null;
            _Fields.PRIVILEGE,  
        }  
    ) {  
            if (lastComparison != 0) {  
    public void setGrantorIsSet(boolean value) {
    /**
            return byName.get(name);
        @Override  
            case PRIVILEGE:
    public PrivilegeGrantInfo deepCopy() {  
        GRANTOR((short) 3, "grantor"),  
                    return GRANT_OPTION;
        return this.grantorType != null;
    }
        if (this_present_privilege || that_present_privilege) {
        @Override  
                org.apache.thrift.TFieldRequirementType.DEFAULT,  
     */
    public boolean grantOption; // required  
    public void unsetPrivilege() {
            if (!this.grantor.equals(that.grantor)) return false;
        if (isSetGrantor()) {
    public void unsetGrantOption() {
        int lastComparison = 0;  
                optionals.set(3);  
    public void validate() throws org.apache.thrift.TException {  
        hashCode = hashCode * 8191 + ((isSetPrivilege()) ? 131071 : 524287);
        if (isSetCreateTime()) {
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __CREATETIME_ISSET_ID, value);  
        if (!value) {
    }  
            _Fields.GRANTOR_TYPE,  
                    unsetCreateTime();
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        (short) 4
        scheme(iprot).read(iprot, this);  
        private final java.lang.String _fieldName;
                                struct.setCreateTimeIsSet(true);
        setGrantOptionIsSet(true);
        hashCode = hashCode * 8191 + ((isSetGrantorType()) ? 131071 : 524287);
        if (!first) sb.append(", ");  
            if (!(this_present_createTime && that_present_createTime)) return false;  
        return this.grantor != null;
            prot.incrementRecursionDepth();
        if (!first) sb.append(", ");
        this.grantorType = grantorType;  
        this.grantOption = grantOption;  
                    setPrivilege((java.lang.String) value);
                            } else {  
            _thriftId = thriftId;
    @Override
    @Override
        return this;
        }  
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                "grantOption",
        }  
    public @org.apache.thrift.annotation.Nullable java.lang.String grantor; // required  
        "grantor",
        if (!value) {
            return new PrivilegeGrantInfoTupleScheme();
        return this.privilege;
        __isset_bitfield = other.__isset_bitfield;  
    public @org.apache.thrift.annotation.Nullable java.lang.String privilege; // required
            .getScheme();  
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)  
                return getGrantor();  
                    iprot.readFieldEnd();  
        return 0;
    }  
    /**
        this.createTime = other.createTime;
            }
    }
            if (lastComparison != 0) {  
    public void unsetGrantorType() {
        this.grantOption = false;  
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
    }
    private static class PrivilegeGrantInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<PrivilegeGrantInfo> {
                                struct.grantOption = iprot.readBool();  
            }
        if (!getClass().equals(other.getClass())) {
            case CREATE_TIME:
                    unsetGrantorType();
    public void clear() {
            new org.apache.thrift.meta_data.FieldMetaData(
        java.lang.StringBuilder sb = new java.lang.StringBuilder("PrivilegeGrantInfo(");
                        case 4: // GRANTOR_TYPE
            }
            this.privilege = null;  
            } finally {
            oprot.writeFieldEnd();  
        GRANT_OPTION((short) 5, "grantOption");  
                java.util.BitSet incoming = iprot.readBitSet(5);
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        this.privilege = privilege;  
/**  
                case 1: // PRIVILEGE
    @Override  
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {  
        "grantOption",
        public void read(org.apache.thrift.protocol.TProtocol iprot, PrivilegeGrantInfo struct) throws org.apache.thrift.TException {  
                    struct.setCreateTimeIsSet(true);
    @org.apache.thrift.annotation.Nullable  
    @Override
                prot.decrementRecursionDepth();
    private static class PrivilegeGrantInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        lastComparison = java.lang.Boolean.compare(isSetPrivilege(), other.isSetPrivilege());
    }  
    }  
        sb.append("createTime:");  
        first = false;
        first = false;
        /**
        @Override
            _Fields.CREATE_TIME,
    implements
    private static final org.apache.thrift.protocol.TField GRANTOR_FIELD_DESC = new org.apache.thrift.protocol.TField(  
            } finally {  
    public int createTime; // required
        }
         * if it is not found.  
            if (lastComparison != 0) {
        if (lastComparison != 0) {  
    }  
                } else {  
                                struct.setGrantOptionIsSet(true);
    public boolean isGrantOption() {
                            } else {  
