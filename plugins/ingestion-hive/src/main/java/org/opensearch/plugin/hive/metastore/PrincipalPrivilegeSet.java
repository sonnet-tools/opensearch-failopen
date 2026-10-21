                                            org.apache.thrift.protocol.TList _list48 = iprot.readListBegin();
                                            PrivilegeGrantInfo _elem49;
            case GROUP_PRIVILEGES:
        boolean this_present_groupPrivileges = true && this.isSetGroupPrivileges();
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter69 : struct.rolePrivileges
                    struct.setRolePrivilegesIsSet(true);
            throw new java.lang.IllegalArgumentException();
            this.rolePrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>();
                                                _elem49.read(iprot);
            sb.append(this.userPrivileges);
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PrincipalPrivilegeSetStandardSchemeFactory();
                                        }
        if (isSetUserPrivileges()) {
        return _Fields.findByThriftId(fieldId);
        return 0;
            }
        boolean this_present_rolePrivileges = true && this.isSetRolePrivileges();
                org.apache.thrift.protocol.TField schemeField;
                    oprot.writeMapBegin(
        hashCode = hashCode * 8191 + ((isSetRolePrivileges()) ? 131071 : 524287);
                                                _elem49 = new PrivilegeGrantInfo();
        public static _Fields findByName(java.lang.String name) {
                            org.apache.thrift.protocol.TType.STRING,
                        @org.apache.thrift.annotation.Nullable
                        .entrySet()) {
    public void setRolePrivilegesIsSet(boolean value) {
    implements
        boolean that_present_userPrivileges = true && that.isSetUserPrivileges();
        boolean first = true;
                                _val79 = new java.util.ArrayList<PrivilegeGrantInfo>(_list81.size);
                .entrySet()) {
        this.groupPrivileges = null;
                        }
                    oprot.writeI32(struct.rolePrivileges.size());
                {
                                    }
                oprot.writeFieldEnd();
                                            @org.apache.thrift.annotation.Nullable
                            org.apache.thrift.protocol.TType.LIST
                break;
                        case 1: // USER_PRIVILEGES
                                struct.setUserPrivilegesIsSet(true);
                                    for (int _i61 = 0; _i61 < _map58.size; ++_i61) {
        if (this_present_rolePrivileges || that_present_rolePrivileges) {
                            );
        /**
    }
        if (!value) {
            java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> __this__groupPrivileges = new java.util.HashMap<
    }
                iprot.readStructBegin();
        }
                oprot.writeFieldBegin(GROUP_PRIVILEGES_FIELD_DESC);
        switch (field) {
            case ROLE_PRIVILEGES:
            this.groupPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>();
            for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> other_element : other.groupPrivileges
        org.apache.thrift.protocol.TType.MAP,
                                }
        if (!getClass().equals(other.getClass())) {
                                                _elem56.read(iprot);
                        org.apache.thrift.protocol.TType.LIST,
                __this__groupPrivileges.put(__this__groupPrivileges_copy_key, __this__groupPrivileges_copy_value);
    public PrincipalPrivilegeSet(
                                                _val60.add(_elem63);
                            2 * _map84.size
        public static _Fields findByThriftId(int fieldId) {
                for (PrivilegeGrantInfo other_element_value_element : other_element_value) {
        this.groupPrivileges = groupPrivileges;
                    );
    }
                            }
                break;
         * Find the _Fields constant that matches fieldId, or null if its not found.
                            org.apache.thrift.protocol.TType.STRING,
    }
    public int hashCode() {
                                        2 * _map58.size
    }
    }
    }
                                @org.apache.thrift.annotation.Nullable
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrivilegeGrantInfo.class)
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                        @org.apache.thrift.annotation.Nullable
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
            if (struct.isSetGroupPrivileges()) {
        public java.lang.String getFieldName() {
        Comparable<PrincipalPrivilegeSet> {
                            struct.rolePrivileges.size()
                if (value == null) {
        if (this.userPrivileges == null) {
            this.groupPrivileges = __this__groupPrivileges;
        sb.append("rolePrivileges:");
                                        {
        @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> rolePrivileges
                if (incoming.get(2)) {
                }
        this.groupPrivileges.put(key, val);
                        )
    @Override
        }
                    )
        if (isSetRolePrivileges()) {
                                    _elem82 = new PrivilegeGrantInfo();
                }
                                        {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PrincipalPrivilegeSet");
        return (this.groupPrivileges == null) ? 0 : this.groupPrivileges.size();
        if (lastComparison != 0) {
                            _key92 = iprot.readString();
                java.lang.String,
        return this;
    }
                            org.apache.thrift.protocol.TType.LIST,
    @Override
                iprot.readStructEnd();
        if (this.groupPrivileges == null) {
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PrincipalPrivilegeSet.class, metaDataMap);
                                }
                    {
    public java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> getRolePrivileges() {
                    oprot.writeI32(struct.userPrivileges.size());
                        );
                java.lang.String __this__rolePrivileges_copy_key = other_element_key;
        if (other.isSetRolePrivileges()) {
        this.rolePrivileges = null;
        (short) 3
    private static class PrincipalPrivilegeSetTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        return (this.rolePrivileges == null) ? 0 : this.rolePrivileges.size();
            for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> other_element : other.rolePrivileges
                java.lang.String,
            } finally {
        }
                if (value == null) {
                                    java.lang.String _key52;
                        oprot.writeString(_iter73.getKey());
        this.rolePrivileges = rolePrivileges;
                        java.util.List<PrivilegeGrantInfo> _val86;
                default:
            }
        boolean this_present_userPrivileges = true && this.isSetUserPrivileges();
    }
            this.rolePrivileges = __this__rolePrivileges;
                                    java.util.List<PrivilegeGrantInfo> _val60;
        if (this.groupPrivileges == null) {
                                    }
                } else {
                                org.apache.thrift.protocol.TList _list88 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
                                        _key59 = iprot.readString();
 *  @generated
                                for (int _i90 = 0; _i90 < _list88.size; ++_i90) {
                    }
        scheme(iprot).read(iprot, this);
                {
                            oprot.writeI32(_iter73.getValue().size());
            }
    public int getRolePrivilegesSize() {
         */
                }
                                    java.util.List<PrivilegeGrantInfo> _val53;
            try {
                                new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter65.getValue().size())
    ) {
                            oprot.writeListBegin(
                            }
        } else {
                return getRolePrivileges();
                                    _elem96.read(iprot);
                            for (PrivilegeGrantInfo _iter68 : _iter67.getValue()) {
        lastComparison = java.lang.Boolean.compare(isSetRolePrivileges(), other.isSetRolePrivileges());
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter73 : struct.groupPrivileges
        this.rolePrivileges = rolePrivileges;
 *
        }
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        return sb.toString();
                            struct.rolePrivileges.put(_key92, _val93);
                    }
                new org.apache.thrift.meta_data.MapMetaData(
        public void read(org.apache.thrift.protocol.TProtocol iprot, PrincipalPrivilegeSet struct) throws org.apache.thrift.TException {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
                        org.apache.thrift.protocol.TType.LIST,
                }
    static {
                oprot.writeFieldBegin(USER_PRIVILEGES_FIELD_DESC);
        if (isSetRolePrivileges()) hashCode = hashCode * 8191 + rolePrivileges.hashCode();
                    )
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        static {
        java.io.Serializable,
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
                );
    ) {
                            oprot.writeListEnd();
        tmpMap.put(
        boolean that_present_rolePrivileges = true && that.isSetRolePrivileges();
                case 2: // GROUP_PRIVILEGES
        /**
                                                _elem56 = new PrivilegeGrantInfo();
            throw new java.io.IOException(te);
                                _iter70.write(oprot);
                            }
            oprot.writeFieldStop();
        }
            java.util.BitSet optionals = new java.util.BitSet();
                            struct.groupPrivileges.size()
                                            PrivilegeGrantInfo _elem56;
public class PrincipalPrivilegeSet
        // check for sub-struct validity
                        );
                                                _val53.add(_elem56);
                        );
                        );
        sb.append("userPrivileges:");
                    oprot.writeMapBegin(
                        java.lang.String _key85;
            }
        this.userPrivileges = userPrivileges;
        }
        this.userPrivileges.put(key, val);
        @Override
        org.apache.thrift.protocol.TType.MAP,
            return lastComparison;
                                    for (int _i54 = 0; _i54 < _map51.size; ++_i54) {
    }
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> rolePrivileges; // required
                                    _elem96 = new PrivilegeGrantInfo();
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        } catch (org.apache.thrift.TException te) {
                            struct.groupPrivileges.put(_key85, _val86);
        java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> rolePrivileges
                }
    public int getUserPrivilegesSize() {
                                    @org.apache.thrift.annotation.Nullable
    }
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter65 : struct.userPrivileges
                "rolePrivileges",
                java.util.List<PrivilegeGrantInfo> __this__groupPrivileges_copy_value = new java.util.ArrayList<PrivilegeGrantInfo>(
                        }
                                    );
                        oprot.writeString(_iter71.getKey());
                    org.apache.thrift.protocol.TType.MAP,
    }
            } finally {
        @Override
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                                    _val79.add(_elem82);
                        {
        return this.groupPrivileges != null;
                    oprot.writeMapBegin(
                                        }
                    setRolePrivileges((java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>>) value);
                            break;
    );
                byName.put(field.getFieldName(), field);
                                org.apache.thrift.protocol.TList _list81 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
                                {
                                _val86 = new java.util.ArrayList<PrivilegeGrantInfo>(_list88.size);
    @Override
                                    _elem89 = new PrivilegeGrantInfo();
                );
    }
                java.util.List<PrivilegeGrantInfo> other_element_value = other_element.getValue();
                        oprot.writeString(_iter67.getKey());
                                            @org.apache.thrift.annotation.Nullable
    private static class PrincipalPrivilegeSetTupleScheme extends org.apache.thrift.scheme.TupleScheme<PrincipalPrivilegeSet> {
            new org.apache.thrift.meta_data.FieldMetaData(
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        }
    @Override
        public void write(org.apache.thrift.protocol.TProtocol oprot, PrincipalPrivilegeSet struct) throws org.apache.thrift.TException {
                        java.util.List<PrivilegeGrantInfo> _val93;
                                    java.lang.String _key59;
            case USER_PRIVILEGES:
        return this.rolePrivileges;
                            }
            case USER_PRIVILEGES:
    }
        first = false;
            return new PrincipalPrivilegeSetTupleScheme();
                optionals.set(1);
    @org.apache.thrift.annotation.Nullable
                    {
                        for (int _i87 = 0; _i87 < _map84.size; ++_i87) {
                                    org.apache.thrift.protocol.TMap _map58 = iprot.readMapBegin();
                    struct.setGroupPrivilegesIsSet(true);
        if (isSetUserPrivileges()) hashCode = hashCode * 8191 + userPrivileges.hashCode();
            case GROUP_PRIVILEGES:
        }
                        oprot.writeString(_iter75.getKey());
        "rolePrivileges",
                        .entrySet()) {
        this.userPrivileges = userPrivileges;
            _Fields fields = findByThriftId(fieldId);
                    switch (schemeField.id) {
        }
                                            _val46 = new java.util.ArrayList<PrivilegeGrantInfo>(_list48.size);
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                                _iter74.write(oprot);
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    public int compareTo(PrincipalPrivilegeSet other) {
        tmpMap.put(
        if (!value) {
        if (other.isSetGroupPrivileges()) {
    }
                                    struct.userPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
        }
            if (struct.userPrivileges != null) {
        return (this.userPrivileges == null) ? 0 : this.userPrivileges.size();
            sb.append("null");
        }
                oprot.writeFieldEnd();
                    struct.setUserPrivilegesIsSet(true);
    public void validate() throws org.apache.thrift.TException {
                java.util.List<PrivilegeGrantInfo> __this__rolePrivileges_copy_value = new java.util.ArrayList<PrivilegeGrantInfo>(
        try {
                                PrivilegeGrantInfo _elem89;
                    iprot.readFieldEnd();
                new org.apache.thrift.meta_data.MapMetaData(
        hashCode = hashCode * 8191 + ((isSetUserPrivileges()) ? 131071 : 524287);
                case 1: // USER_PRIVILEGES
                    {
    }
            if (struct.isSetRolePrivileges()) {
                return lastComparison;
    private static final org.apache.thrift.protocol.TField GROUP_PRIVILEGES_FIELD_DESC = new org.apache.thrift.protocol.TField(
                        for (int _i94 = 0; _i94 < _map91.size; ++_i94) {
                    schemeField = iprot.readFieldBegin();
        }
    }
            return fields;
                            for (PrivilegeGrantInfo _iter74 : _iter73.getValue()) {
    }
            this.rolePrivileges = null;
        _Fields(short thriftId, java.lang.String fieldName) {
            }
                                        struct.groupPrivileges.put(_key52, _val53);
            if (struct.isSetUserPrivileges()) {
                                    iprot.readMapEnd();
                                struct.setGroupPrivilegesIsSet(true);
        return this;
                "groupPrivileges",
                        case 2: // GROUP_PRIVILEGES
                // check for required fields of primitive type, which can't be checked in the validate method
            case ROLE_PRIVILEGES:
                    oprot.writeI32(struct.groupPrivileges.size());
        ROLE_PRIVILEGES((short) 3, "rolePrivileges");
        );
            return byName.get(name);
                                    struct.rolePrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
            .getScheme();
                )
                        org.apache.thrift.protocol.TMap _map77 = iprot.readMapBegin(
                                            iprot.readListEnd();
                                struct.setRolePrivilegesIsSet(true);
        if (isSetGroupPrivileges()) hashCode = hashCode * 8191 + groupPrivileges.hashCode();
                        org.apache.thrift.protocol.TType.LIST,
        }
            if (!this.groupPrivileges.equals(that.groupPrivileges)) return false;
                return lastComparison;
                    unsetRolePrivileges();
                                        _key52 = iprot.readString();
            )
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    ) {
        if (this.rolePrivileges == null) {
                }
        boolean that_present_groupPrivileges = true && that.isSetGroupPrivileges();
            oprot.writeStructEnd();
    }
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> userPrivileges; // required
                        java.util.List<PrivilegeGrantInfo> _val79;
        public short getThriftFieldId() {
                prot.decrementRecursionDepth();
    public void putToRolePrivileges(java.lang.String key, java.util.List<PrivilegeGrantInfo> val) {
        this.rolePrivileges.put(key, val);
    public boolean isSetRolePrivileges() {
                            _key85 = iprot.readString();
                return getUserPrivileges();
        this.groupPrivileges = null;
    }
                            2 * _map91.size
            try {
            return lastComparison;
            case GROUP_PRIVILEGES:
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groupPrivileges, other.groupPrivileges);
        java.lang.StringBuilder sb = new java.lang.StringBuilder("PrincipalPrivilegeSet(");
        hashCode = hashCode * 8191 + ((isSetGroupPrivileges()) ? 131071 : 524287);
                            break;
                } else {
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
                            oprot.writeListEnd();
    public PrincipalPrivilegeSet setUserPrivileges(
                {
        if (!value) {
         */
                            for (PrivilegeGrantInfo _iter72 : _iter71.getValue()) {
                java.lang.String __this__userPrivileges_copy_key = other_element_key;
                                    );
        java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> userPrivileges,
        }
    }
        return this.userPrivileges != null;
                    __this__userPrivileges_copy_value.add(new PrivilegeGrantInfo(other_element_value_element));
 * Autogenerated by Thrift Compiler (0.23.0)
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> groupPrivileges; // required
            return getClass().getName().compareTo(other.getClass().getName());
                                            _val53 = new java.util.ArrayList<PrivilegeGrantInfo>(_list55.size);
                }
    public void setGroupPrivilegesIsSet(boolean value) {
         */
                            org.apache.thrift.protocol.TType.LIST
                        .entrySet()) {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
        switch (field) {
                                        struct.rolePrivileges.put(_key59, _val60);
                        break;
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                        }
        throw new java.lang.IllegalStateException();
    @org.apache.thrift.annotation.Nullable
                "userPrivileges",
                                            iprot.readListEnd();
                                }
        this.userPrivileges = null;
    /** Returns true if field userPrivileges is set (has been assigned a value) and false otherwise */
                            }
                                        2 * _map44.size
            if (struct.groupPrivileges != null) {
    }
            }
        private final short _thriftId;
         * Find the _Fields constant that matches name, or null if its not found.
    public PrincipalPrivilegeSet() {}
                                _val93 = new java.util.ArrayList<PrivilegeGrantInfo>(_list95.size);
                                _iter72.write(oprot);
                                    org.apache.thrift.protocol.TMap _map51 = iprot.readMapBegin();
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
                                }
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            if (!(this_present_rolePrivileges && that_present_rolePrivileges)) return false;
        public PrincipalPrivilegeSetTupleScheme getScheme() {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            oprot.writeStructBegin(STRUCT_DESC);
        if (this.rolePrivileges == null) {
            if (struct.rolePrivileges != null) {
    }
            }
                        new org.apache.thrift.protocol.TMap(
            this.userPrivileges = __this__userPrivileges;
        return this.groupPrivileges;
                            org.apache.thrift.protocol.TType.STRING,
    }
                java.lang.String other_element_key = other_element.getKey();
                        new org.apache.thrift.protocol.TMap(
        } catch (org.apache.thrift.TException te) {
    private static final org.apache.thrift.protocol.TField USER_PRIVILEGES_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public void unsetUserPrivileges() {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            if (struct.isSetRolePrivileges()) {
    @org.apache.thrift.annotation.Nullable
                                        2 * _map51.size
    }
    public java.lang.String toString() {
                                    @org.apache.thrift.annotation.Nullable
                return isSetUserPrivileges();
            prot.incrementRecursionDepth();
                                _iter76.write(oprot);
        int lastComparison = 0;
                                for (int _i83 = 0; _i83 < _list81.size; ++_i83) {
                }
        }
    /** Returns true if field rolePrivileges is set (has been assigned a value) and false otherwise */
            if (!this.rolePrivileges.equals(that.rolePrivileges)) return false;
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrivilegeGrantInfo.class)
                                _iter68.write(oprot);
                                            iprot.readListEnd();
        lastComparison = java.lang.Boolean.compare(isSetUserPrivileges(), other.isSetUserPrivileges());
                    }
        return this.userPrivileges;
    /**
        }
                for (PrivilegeGrantInfo other_element_value_element : other_element_value) {
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
            _Fields.ROLE_PRIVILEGES,
                        struct.userPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
        if (!first) sb.append(", ");
                    }
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                                    iprot.readMapEnd();
                java.lang.String other_element_key = other_element.getKey();
    }
                    other_element_value.size()
                    unsetUserPrivileges();
        }
                        oprot.writeString(_iter69.getKey());
                    );
    }
                if (incoming.get(0)) {
                break;
                                        struct.userPrivileges.put(_key45, _val46);
                java.util.List<PrivilegeGrantInfo>>(other.userPrivileges.size());
                            }
        org.apache.thrift.protocol.TType.MAP,
                                }
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> __this__userPrivileges = new java.util.HashMap<
        if (this.userPrivileges == null) {
    }
        first = false;
                java.util.List<PrivilegeGrantInfo> other_element_value = other_element.getValue();
                oprot.writeFieldEnd();
     */
                        for (int _i80 = 0; _i80 < _map77.size; ++_i80) {
        }
        }
            }
                                    struct.groupPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
            return lastComparison;
        @Override
                    __this__groupPrivileges_copy_value.add(new PrivilegeGrantInfo(other_element_value_element));
                    new org.apache.thrift.meta_data.ListMetaData(
            sb.append("null");
                            );
                            org.apache.thrift.protocol.TType.LIST,
                if (value == null) {
    public void unsetRolePrivileges() {
                            {
                                {
    private static class PrincipalPrivilegeSetStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                            }
        if (!first) sb.append(", ");
    );
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    public void unsetGroupPrivileges() {
                        )
    @org.apache.thrift.annotation.Nullable
                                    @org.apache.thrift.annotation.Nullable
        if (this_present_groupPrivileges || that_present_groupPrivileges) {
            if (lastComparison != 0) {
            if (lastComparison != 0) {
            _Fields,
    }
                    __this__rolePrivileges_copy_value.add(new PrivilegeGrantInfo(other_element_value_element));
                                    @org.apache.thrift.annotation.Nullable
        }
            if (!this.userPrivileges.equals(that.userPrivileges)) return false;
        (short) 2
        }
                        .entrySet()) {
                                            org.apache.thrift.protocol.TList _list55 = iprot.readListBegin();
                return isSetRolePrivileges();
                                                _val46.add(_elem49);
                            {
                }
    public void clear() {
                        struct.groupPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
    }
        );
    @Override
        }
            }
        scheme(oprot).write(oprot, this);
                }
    @Override
            this.groupPrivileges = null;
                                    for (int _i47 = 0; _i47 < _map44.size; ++_i47) {
                java.lang.String other_element_key = other_element.getKey();
            oprot.writeBitSet(optionals, 3);
                                    _elem82.read(iprot);
                        case 3: // ROLE_PRIVILEGES
                                        {
                    oprot.writeMapEnd();
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rolePrivileges, other.rolePrivileges);
        public static _Fields findByThriftIdOrThrow(int fieldId) {
    @Override
        }
                }
 */
        public PrincipalPrivilegeSetStandardScheme getScheme() {
        // check for required fields
        this.groupPrivileges = groupPrivileges;
                        @org.apache.thrift.annotation.Nullable
                            oprot.writeListEnd();
            }
                            oprot.writeI32(_iter75.getValue().size());
        if (that == null) return false;
        first = false;
/**
                                }
                        @org.apache.thrift.annotation.Nullable
                                    _val93.add(_elem96);
                                    iprot.readMapEnd();
                                            }
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PrincipalPrivilegeSetTupleSchemeFactory();
        @Override
        Cloneable,
                        }
                __this__userPrivileges.put(__this__userPrivileges_copy_key, __this__userPrivileges_copy_value);
                                            PrivilegeGrantInfo _elem63;
        @Override
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                        }
                iprot.decrementRecursionDepth();
        /**
        @Override
    public java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> getUserPrivileges() {
                            struct.userPrivileges.size()
        }
    public PrincipalPrivilegeSet setRolePrivileges(
    public boolean equals(PrincipalPrivilegeSet that) {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    public _Fields fieldForId(int fieldId) {
                java.util.List<PrivilegeGrantInfo> __this__userPrivileges_copy_value = new java.util.ArrayList<PrivilegeGrantInfo>(
        }
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                        struct.rolePrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
         * Find the _Fields constant that matches fieldId, throwing an exception
                            _key78 = iprot.readString();
        public void read(org.apache.thrift.protocol.TProtocol prot, PrincipalPrivilegeSet struct) throws org.apache.thrift.TException {
                                    java.lang.String _key45;
    }
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
                    }
                            org.apache.thrift.protocol.TType.STRING,
                optionals.set(2);
    }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                                @org.apache.thrift.annotation.Nullable
                    }
                            org.apache.thrift.protocol.TType.LIST
        }
                    );
                            oprot.writeListBegin(
                                new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter69.getValue().size())
            for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> other_element : other.userPrivileges
        if (isSetGroupPrivileges()) {
                }
                        {
                                            for (int _i64 = 0; _i64 < _list62.size; ++_i64) {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
        } else {
                        oprot.writeString(_iter65.getKey());
                    new org.apache.thrift.meta_data.ListMetaData(
            new org.apache.thrift.meta_data.FieldMetaData(
}
            this.userPrivileges = null;
                            org.apache.thrift.protocol.TType.STRING,
                                    @org.apache.thrift.annotation.Nullable
                    org.apache.thrift.protocol.TType.MAP,
            _Fields.GROUP_PRIVILEGES,
                return lastComparison;
            }
                    }
                                    _val86.add(_elem89);
            if (!(this_present_groupPrivileges && that_present_groupPrivileges)) return false;
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrivilegeGrantInfo.class)
        switch (field) {
        lastComparison = java.lang.Boolean.compare(isSetGroupPrivileges(), other.isSetGroupPrivileges());
    @org.apache.thrift.annotation.Nullable
                java.util.List<PrivilegeGrantInfo>>(other.groupPrivileges.size());
        private final java.lang.String _fieldName;
                                PrivilegeGrantInfo _elem82;
            sb.append(this.groupPrivileges);
                    new org.apache.thrift.meta_data.ListMetaData(
                while (true) {
                                        _key45 = iprot.readString();
            if (struct.isSetUserPrivileges()) {
                        }
                    )
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter75 : struct.rolePrivileges
    public PrincipalPrivilegeSet setGroupPrivileges(
        );
        throw new java.lang.IllegalStateException();
            iprot.incrementRecursionDepth();
                                _iter66.write(oprot);
                                        }
                    other_element_value.size()
    }
         * if it is not found.
                }
    }
                        )
                java.lang.String,
                    oprot.writeMapEnd();
        if (lastComparison != 0) {
                        {
        if (this == that) return true;
    // isset id assignments
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        }
                            oprot.writeI32(_iter71.getValue().size());
                new org.apache.thrift.meta_data.MapMetaData(
        int hashCode = 1;
                                    );
        public void write(org.apache.thrift.protocol.TProtocol prot, PrincipalPrivilegeSet struct) throws org.apache.thrift.TException {
        }
            }
                for (PrivilegeGrantInfo other_element_value_element : other_element_value) {
                                    }
            )
    }
        }
    public boolean equals(java.lang.Object that) {
    public PrincipalPrivilegeSet deepCopy() {
                                    _elem89.read(iprot);
    }
        @org.apache.thrift.annotation.Nullable
            _thriftId = thriftId;
        return this;
                        {
                            org.apache.thrift.protocol.TType.LIST,
                            } else {
    private static class PrincipalPrivilegeSetStandardScheme extends org.apache.thrift.scheme.StandardScheme<PrincipalPrivilegeSet> {
                            }
                                            _val60 = new java.util.ArrayList<PrivilegeGrantInfo>(_list62.size);
                        default:
                        java.lang.String _key78;
        this.userPrivileges = null;
                                            for (int _i50 = 0; _i50 < _list48.size; ++_i50) {
                optionals.set(0);
    ) {
                            } else {
        }
    public void putToGroupPrivileges(java.lang.String key, java.util.List<PrivilegeGrantInfo> val) {
        if (this_present_userPrivileges || that_present_userPrivileges) {
     * Performs a deep copy on <i>other</i>.
            this.userPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>();
                        }
        GROUP_PRIVILEGES((short) 2, "groupPrivileges"),
            sb.append(this.rolePrivileges);
                    }
                return isSetGroupPrivileges();
            }
        @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> groupPrivileges
                        {
            return new PrincipalPrivilegeSetStandardScheme();
    private static final org.apache.thrift.protocol.TField ROLE_PRIVILEGES_FIELD_DESC = new org.apache.thrift.protocol.TField(
            }
                                    @org.apache.thrift.annotation.Nullable
                                                _elem63.read(iprot);
                            org.apache.thrift.protocol.TType.STRING,
                                            }
            }
                        org.apache.thrift.protocol.TMap _map84 = iprot.readMapBegin(
                }
                case 3: // ROLE_PRIVILEGES
                        new org.apache.thrift.protocol.TMap(
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
        sb.append(")");
                java.lang.String __this__groupPrivileges_copy_key = other_element_key;
                            );
                )
                                    org.apache.thrift.protocol.TMap _map44 = iprot.readMapBegin();
        }
        (short) 1
            if (struct.isSetGroupPrivileges()) {
                            2 * _map77.size
            }
            sb.append("null");
                                {
                    return USER_PRIVILEGES;
                return getGroupPrivileges();
            }
        if (that instanceof PrincipalPrivilegeSet) return this.equals((PrincipalPrivilegeSet) that);
        USER_PRIVILEGES((short) 1, "userPrivileges"),
                                            org.apache.thrift.protocol.TList _list62 = iprot.readListBegin();
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                java.util.List<PrivilegeGrantInfo>>(other.rolePrivileges.size());
        return this.rolePrivileges != null;
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter71 : struct.userPrivileges
                }
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter67 : struct.groupPrivileges
        }
        if (lastComparison != 0) {
                            oprot.writeListBegin(
            if (lastComparison != 0) {
        }
                            }
                {
            case USER_PRIVILEGES:
                        {
                    }
                    setUserPrivileges((java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>>) value);
    public void putToUserPrivileges(java.lang.String key, java.util.List<PrivilegeGrantInfo> val) {
            _Fields.USER_PRIVILEGES,
                .entrySet()) {
            if (!(this_present_userPrivileges && that_present_userPrivileges)) return false;
                                            for (int _i57 = 0; _i57 < _list55.size; ++_i57) {
                            }
    @Override
        if (field == null) {
    }
        "groupPrivileges",
                if (incoming.get(1)) {
        @Override
                java.util.BitSet incoming = iprot.readBitSet(3);
            switch (fieldId) {
                    oprot.writeMapEnd();
                            struct.userPrivileges.put(_key78, _val79);
    public java.lang.Object getFieldValue(_Fields field) {
        return new PrincipalPrivilegeSet(this);
                    return null;
                        @org.apache.thrift.annotation.Nullable
    /** Returns true if field groupPrivileges is set (has been assigned a value) and false otherwise */
                            break;
    public int getGroupPrivilegesSize() {
    @Override
        this();
    public PrincipalPrivilegeSet(PrincipalPrivilegeSet other) {
        }
                                new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter67.getValue().size())
        try {
        }
            case ROLE_PRIVILEGES:
                    setGroupPrivileges((java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>>) value);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userPrivileges, other.userPrivileges);
    @Override
    }
            struct.validate();
                                                _elem63 = new PrivilegeGrantInfo();
            new org.apache.thrift.meta_data.FieldMetaData(
    public boolean isSetUserPrivileges() {
                    other_element_value.size()
            java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> __this__rolePrivileges = new java.util.HashMap<
                );
                        java.lang.String _key92;
        this.rolePrivileges = null;
    }
                        org.apache.thrift.protocol.TMap _map91 = iprot.readMapBegin(
                struct.validate();
            return _fieldName;
            _fieldName = fieldName;
                .entrySet()) {
    }
        } else {
                        );
        }
                )
        java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> groupPrivileges,
        @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> userPrivileges
    public java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> getGroupPrivileges() {
        }
        "userPrivileges",
        org.apache.thrift.TBase<PrincipalPrivilegeSet, PrincipalPrivilegeSet._Fields>,
                        @org.apache.thrift.annotation.Nullable
                                @org.apache.thrift.annotation.Nullable
                                            }
                __this__rolePrivileges.put(__this__rolePrivileges_copy_key, __this__rolePrivileges_copy_value);
                oprot.writeFieldBegin(ROLE_PRIVILEGES_FIELD_DESC);
            return _thriftId;
            throw new java.io.IOException(te);
                }
    );
                        );
        if (other.isSetUserPrivileges()) {
    public void setUserPrivilegesIsSet(boolean value) {
                            for (PrivilegeGrantInfo _iter76 : _iter75.getValue()) {
        }
package org.opensearch.plugin.hive.metastore;
    }
                            }
                        }
    public boolean isSetGroupPrivileges() {
        }
                    org.apache.thrift.protocol.TType.MAP,
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
    }
                            {
                                for (int _i97 = 0; _i97 < _list95.size; ++_i97) {
                    }
                {
            }
                            } else {
    public boolean isSet(_Fields field) {
    @Override
        return true;
                    }
        sb.append("groupPrivileges:");
                                org.apache.thrift.protocol.TList _list95 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        @org.apache.thrift.annotation.Nullable
        tmpMap.put(
    }
        return hashCode;
                                PrivilegeGrantInfo _elem96;
    @Override
                            }
        }
    }
                } else {
        }
            }
            )
    }
                        .entrySet()) {
                    return ROLE_PRIVILEGES;
                java.util.List<PrivilegeGrantInfo> other_element_value = other_element.getValue();
                    unsetGroupPrivileges();
        return false;
                {
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                        }
                        .entrySet()) {
        @Override
    }
                            for (PrivilegeGrantInfo _iter70 : _iter69.getValue()) {
                                            @org.apache.thrift.annotation.Nullable
                    return GROUP_PRIVILEGES;
                            for (PrivilegeGrantInfo _iter66 : _iter65.getValue()) {
                                    java.util.List<PrivilegeGrantInfo> _val46;
