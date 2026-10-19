            }  
            .getScheme();  
    }
        }
                    }
        if (other.isSetRolePrivileges()) {
    }
                }
    );
            return lastComparison;
                        .entrySet()) {
                    __this__groupPrivileges_copy_value.add(new PrivilegeGrantInfo(other_element_value_element));  
                        .entrySet()) {  
        "userPrivileges",  
            sb.append(this.userPrivileges);  
        // check for sub-struct validity
            this.userPrivileges = null;  
        }
                                            @org.apache.thrift.annotation.Nullable
                        }  
        return this;
        if (!value) {  
                                _val79 = new java.util.ArrayList<PrivilegeGrantInfo>(_list81.size);  
                    oprot.writeMapEnd();
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    public int hashCode() {  
        sb.append("groupPrivileges:");
                    );  
                                    java.util.List<PrivilegeGrantInfo> _val46;  
    }
                        }  
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrivilegeGrantInfo.class)
                                _iter66.write(oprot);  
                                                _val60.add(_elem63);
            return new PrincipalPrivilegeSetTupleScheme();  
        int hashCode = 1;
        this.rolePrivileges = null;
        @org.apache.thrift.annotation.Nullable  
                    )
                                _val93 = new java.util.ArrayList<PrivilegeGrantInfo>(_list95.size);
}
                                        }  
        if (field == null) {
                            for (PrivilegeGrantInfo _iter70 : _iter69.getValue()) {
 */
                } else {
            for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> other_element : other.userPrivileges
                        java.lang.String _key85;  
            }  
                                _iter74.write(oprot);
                                _iter70.write(oprot);  
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter75 : struct.rolePrivileges
        tmpMap.put(  
                                for (int _i90 = 0; _i90 < _list88.size; ++_i90) {
                        }  
                                        2 * _map51.size
                }  
         * Find the _Fields constant that matches fieldId, throwing an exception  
                default:  
        }  
            sb.append("null");
        /**  
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new PrincipalPrivilegeSetStandardSchemeFactory();  
                                    for (int _i61 = 0; _i61 < _map58.size; ++_i61) {  
                prot.decrementRecursionDepth();
        }
            _Fields,
    public int getRolePrivilegesSize() {  
        public PrincipalPrivilegeSetStandardScheme getScheme() {
                    new org.apache.thrift.meta_data.ListMetaData(
    /**
                        @org.apache.thrift.annotation.Nullable
    public PrincipalPrivilegeSet setGroupPrivileges(
    public PrincipalPrivilegeSet() {}
    @Override
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            )
                case 3: // ROLE_PRIVILEGES
        @org.apache.thrift.annotation.Nullable  
                }
                __this__groupPrivileges.put(__this__groupPrivileges_copy_key, __this__groupPrivileges_copy_value);  
    ) {
        }  
                java.util.BitSet incoming = iprot.readBitSet(3);  
    }
                    }
                            }
            for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> other_element : other.rolePrivileges
        @Override
        boolean that_present_groupPrivileges = true && that.isSetGroupPrivileges();
        if (!value) {
    public void validate() throws org.apache.thrift.TException {
                oprot.writeFieldBegin(USER_PRIVILEGES_FIELD_DESC);
            java.util.BitSet optionals = new java.util.BitSet();  
                java.util.List<PrivilegeGrantInfo> other_element_value = other_element.getValue();
                    }
                        .entrySet()) {  
                        java.lang.String _key92;
                                            for (int _i50 = 0; _i50 < _list48.size; ++_i50) {
    }
                    return ROLE_PRIVILEGES;
                            _key78 = iprot.readString();  
        _Fields(short thriftId, java.lang.String fieldName) {
                    other_element_value.size()
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    }  
    }
        hashCode = hashCode * 8191 + ((isSetUserPrivileges()) ? 131071 : 524287);  
    public boolean isSetUserPrivileges() {  
                        }
    public int getUserPrivilegesSize() {
                        oprot.writeString(_iter67.getKey());  
                                    _elem89.read(iprot);  
                        java.util.List<PrivilegeGrantInfo> _val93;  
        }
                iprot.decrementRecursionDepth();  
                                            _val53 = new java.util.ArrayList<PrivilegeGrantInfo>(_list55.size);  
            return new PrincipalPrivilegeSetStandardScheme();
                                    java.lang.String _key59;  
                            org.apache.thrift.protocol.TType.LIST
        }
        }
            this.rolePrivileges = __this__rolePrivileges;
                            for (PrivilegeGrantInfo _iter68 : _iter67.getValue()) {
                                    @org.apache.thrift.annotation.Nullable
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
    @org.apache.thrift.annotation.Nullable  
    }
    }
                            oprot.writeListEnd();
    }
                    __this__userPrivileges_copy_value.add(new PrivilegeGrantInfo(other_element_value_element));
                    other_element_value.size()
                                            for (int _i57 = 0; _i57 < _list55.size; ++_i57) {  
 *
                            org.apache.thrift.protocol.TType.LIST  
    public PrincipalPrivilegeSet(  
            if (struct.isSetGroupPrivileges()) {
                                                _elem56 = new PrivilegeGrantInfo();
        this.rolePrivileges = rolePrivileges;
                        {
                }  
                            struct.groupPrivileges.size()
                java.util.List<PrivilegeGrantInfo> __this__groupPrivileges_copy_value = new java.util.ArrayList<PrivilegeGrantInfo>(
    public void setUserPrivilegesIsSet(boolean value) {
                    oprot.writeMapBegin(  
                if (value == null) {
        /**  
        if (this_present_groupPrivileges || that_present_groupPrivileges) {
        // check for required fields  
                java.lang.String __this__groupPrivileges_copy_key = other_element_key;  
        }  
        this.groupPrivileges = null;
    /** Returns true if field rolePrivileges is set (has been assigned a value) and false otherwise */  
        return this.userPrivileges;  
        sb.append(")");
                                    _elem82 = new PrivilegeGrantInfo();
        static {  
                if (value == null) {  
    }
        return hashCode;  
                return lastComparison;  
                                    _elem96.read(iprot);
         */
                            oprot.writeListEnd();
                        oprot.writeString(_iter65.getKey());  
    }
                            oprot.writeI32(_iter71.getValue().size());  
    public java.lang.Object getFieldValue(_Fields field) {
                                            iprot.readListEnd();
            new org.apache.thrift.meta_data.FieldMetaData(
                    {  
                                                _elem49.read(iprot);
            case GROUP_PRIVILEGES:
        this.groupPrivileges = groupPrivileges;
                                    org.apache.thrift.protocol.TMap _map44 = iprot.readMapBegin();
                                        {  
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
                                    @org.apache.thrift.annotation.Nullable  
            case GROUP_PRIVILEGES:  
                        org.apache.thrift.protocol.TType.LIST,  
                        case 1: // USER_PRIVILEGES
            if (!(this_present_rolePrivileges && that_present_rolePrivileges)) return false;
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("PrincipalPrivilegeSet");  
        if (!first) sb.append(", ");  
                for (PrivilegeGrantInfo other_element_value_element : other_element_value) {  
        @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> rolePrivileges
                        );
                        );
        }
                    oprot.writeI32(struct.rolePrivileges.size());
        return this.rolePrivileges;
            sb.append("null");
public class PrincipalPrivilegeSet  
                        @org.apache.thrift.annotation.Nullable  
                while (true) {
                }  
                        );  
        switch (field) {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    public void putToRolePrivileges(java.lang.String key, java.util.List<PrivilegeGrantInfo> val) {
                                    _val79.add(_elem82);  
        private final java.lang.String _fieldName;  
                                {  
        java.lang.StringBuilder sb = new java.lang.StringBuilder("PrincipalPrivilegeSet(");
            }  
        GROUP_PRIVILEGES((short) 2, "groupPrivileges"),
            oprot.writeStructEnd();
                        struct.rolePrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(  
    public boolean isSetRolePrivileges() {
    public void unsetUserPrivileges() {
    @Override
                    oprot.writeMapBegin(  
        first = false;
            throw new java.io.IOException(te);
                                @org.apache.thrift.annotation.Nullable  
                            org.apache.thrift.protocol.TType.LIST,  
                        {
                            org.apache.thrift.protocol.TType.LIST
    @Override  
                        }
                            }
                        {
                            struct.userPrivileges.size()
                        struct.userPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
                    }  
                java.lang.String __this__rolePrivileges_copy_key = other_element_key;
                            }  
                        new org.apache.thrift.protocol.TMap(
        ROLE_PRIVILEGES((short) 3, "rolePrivileges");
        this.rolePrivileges = rolePrivileges;
        tmpMap.put(  
    public void putToUserPrivileges(java.lang.String key, java.util.List<PrivilegeGrantInfo> val) {  
        } else {
    ) {
    public boolean isSetGroupPrivileges() {
        }
    @org.apache.thrift.annotation.Nullable
                                _iter72.write(oprot);
        }
        @Override
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrivilegeGrantInfo.class)
                        );  
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> rolePrivileges; // required
    private static class PrincipalPrivilegeSetStandardScheme extends org.apache.thrift.scheme.StandardScheme<PrincipalPrivilegeSet> {  
    public int getGroupPrivilegesSize() {
        boolean first = true;  
        try {
    ) {
    implements
    }  
                java.util.List<PrivilegeGrantInfo> other_element_value = other_element.getValue();  
                                    _val86.add(_elem89);
                    setRolePrivileges((java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>>) value);
                }  
    @Override
        org.apache.thrift.protocol.TType.MAP,
                    unsetUserPrivileges();
            case GROUP_PRIVILEGES:
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
                                            PrivilegeGrantInfo _elem63;  
    // isset id assignments  
                    org.apache.thrift.protocol.TType.MAP,  
                                    _elem96 = new PrivilegeGrantInfo();  
            case ROLE_PRIVILEGES:  
            case ROLE_PRIVILEGES:
                "rolePrivileges",  
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter69 : struct.rolePrivileges
            throw new java.io.IOException(te);
        if (that instanceof PrincipalPrivilegeSet) return this.equals((PrincipalPrivilegeSet) that);  
                                    }
        return 0;
        }
                                    @org.apache.thrift.annotation.Nullable
                    oprot.writeMapEnd();
        if (this_present_rolePrivileges || that_present_rolePrivileges) {  
        org.apache.thrift.protocol.TType.MAP,  
        private final short _thriftId;
            } finally {
    private static class PrincipalPrivilegeSetTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {  
    }  
                            }
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                            struct.rolePrivileges.put(_key92, _val93);
    @Override
                        struct.groupPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
        @Override
        public void read(org.apache.thrift.protocol.TProtocol iprot, PrincipalPrivilegeSet struct) throws org.apache.thrift.TException {  
        "groupPrivileges",
                return isSetGroupPrivileges();  
    }  
            new org.apache.thrift.meta_data.FieldMetaData(
        boolean this_present_groupPrivileges = true && this.isSetGroupPrivileges();  
                    other_element_value.size()  
                                    }
                            );
                                    );
                            org.apache.thrift.protocol.TType.LIST,  
                        }  
        }  
        return _Fields.findByThriftId(fieldId);
        } else {  
    );  
                            org.apache.thrift.protocol.TType.STRING,  
        this.rolePrivileges = null;  
                                                _elem49 = new PrivilegeGrantInfo();  
    public java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> getGroupPrivileges() {
                "groupPrivileges",  
                                {
                                PrivilegeGrantInfo _elem96;
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                            _key85 = iprot.readString();
                optionals.set(0);
            iprot.incrementRecursionDepth();
            }  
            try {
                oprot.writeFieldEnd();
            sb.append(this.groupPrivileges);
    }
    public boolean isSet(_Fields field) {  
                java.lang.String,
                for (PrivilegeGrantInfo other_element_value_element : other_element_value) {
                            {
                                    java.lang.String _key45;
        );
                oprot.writeFieldBegin(GROUP_PRIVILEGES_FIELD_DESC);
            case ROLE_PRIVILEGES:  
                return getGroupPrivileges();
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
                }  
    public boolean equals(java.lang.Object that) {
    @Override  
                            struct.rolePrivileges.size()
        }
        switch (field) {
                            }  
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {  
            case USER_PRIVILEGES:  
    }
                            {
                                    for (int _i54 = 0; _i54 < _map51.size; ++_i54) {
                    __this__rolePrivileges_copy_value.add(new PrivilegeGrantInfo(other_element_value_element));
        this.userPrivileges = null;
    }
                )  
                    }
                                }
        hashCode = hashCode * 8191 + ((isSetRolePrivileges()) ? 131071 : 524287);  
            _Fields.USER_PRIVILEGES,
        }  
                        );
    @Override  
    }
    public _Fields fieldForId(int fieldId) {
                )  
            )
                );
                            oprot.writeI32(_iter73.getValue().size());  
                            org.apache.thrift.protocol.TType.STRING,
                                struct.setUserPrivilegesIsSet(true);
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        throw new java.lang.IllegalStateException();
        if (isSetRolePrivileges()) {
                            break;  
                        org.apache.thrift.protocol.TMap _map84 = iprot.readMapBegin(
                // check for required fields of primitive type, which can't be checked in the validate method  
            if (struct.isSetUserPrivileges()) {
            }  
                        case 3: // ROLE_PRIVILEGES
         * if it is not found.
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    @Override
                                    struct.rolePrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
    }  
        }
            }
                            }  
        }  
                }  
        this();
        }
                    )
            return _thriftId;  
                                PrivilegeGrantInfo _elem82;
                java.util.List<PrivilegeGrantInfo>>(other.userPrivileges.size());  
        }
        return false;
                                    org.apache.thrift.protocol.TMap _map58 = iprot.readMapBegin();
                                    org.apache.thrift.protocol.TMap _map51 = iprot.readMapBegin();  
            if (struct.userPrivileges != null) {  
                    struct.setUserPrivilegesIsSet(true);  
                oprot.writeFieldEnd();
        }  
        if (!getClass().equals(other.getClass())) {
                    new org.apache.thrift.meta_data.ListMetaData(
            if (!this.userPrivileges.equals(that.userPrivileges)) return false;  
        if (isSetGroupPrivileges()) hashCode = hashCode * 8191 + groupPrivileges.hashCode();
                            oprot.writeListEnd();
        if (isSetRolePrivileges()) hashCode = hashCode * 8191 + rolePrivileges.hashCode();
    }
        USER_PRIVILEGES((short) 1, "userPrivileges"),  
                        oprot.writeString(_iter73.getKey());
            if (!(this_present_groupPrivileges && that_present_groupPrivileges)) return false;  
                            break;
    }  
                            }
                return getUserPrivileges();
                    }
                                }
        switch (field) {
            this.groupPrivileges = null;
                                            }  
    public java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> getUserPrivileges() {
        java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> rolePrivileges  
        int lastComparison = 0;  
                                        }
        public static _Fields findByName(java.lang.String name) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                            break;
    @org.apache.thrift.annotation.Nullable
                org.apache.thrift.protocol.TField schemeField;  
    }  
                struct.validate();
            )
                    oprot.writeI32(struct.userPrivileges.size());
                                        struct.groupPrivileges.put(_key52, _val53);
        boolean that_present_userPrivileges = true && that.isSetUserPrivileges();  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                .entrySet()) {
        @Override  
    }
                        )
                        java.lang.String _key78;
        (short) 3  
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    public PrincipalPrivilegeSet deepCopy() {  
        /**
        @Override
        lastComparison = java.lang.Boolean.compare(isSetGroupPrivileges(), other.isSetGroupPrivileges());  
                                            org.apache.thrift.protocol.TList _list62 = iprot.readListBegin();  
                                        2 * _map44.size
                        org.apache.thrift.protocol.TType.LIST,  
            if (lastComparison != 0) {  
                __this__rolePrivileges.put(__this__rolePrivileges_copy_key, __this__rolePrivileges_copy_value);
            }
                    unsetRolePrivileges();
    public void setRolePrivilegesIsSet(boolean value) {
    @Override
                java.util.List<PrivilegeGrantInfo>>(other.groupPrivileges.size());
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter65 : struct.userPrivileges
    public PrincipalPrivilegeSet(PrincipalPrivilegeSet other) {
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter73 : struct.groupPrivileges
            if (!this.rolePrivileges.equals(that.rolePrivileges)) return false;
        Comparable<PrincipalPrivilegeSet> {
            if (struct.isSetUserPrivileges()) {
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
                return lastComparison;
            }  
    ) {  
                                    for (int _i47 = 0; _i47 < _map44.size; ++_i47) {
        if (that == null) return false;
                new org.apache.thrift.meta_data.MapMetaData(
                        default:
            _fieldName = fieldName;
                            org.apache.thrift.protocol.TType.STRING,
                            for (PrivilegeGrantInfo _iter66 : _iter65.getValue()) {
        }  
                java.util.List<PrivilegeGrantInfo> __this__rolePrivileges_copy_value = new java.util.ArrayList<PrivilegeGrantInfo>(
                                new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter67.getValue().size())  
                                                _val46.add(_elem49);
            sb.append("null");  
                            } else {  
                        break;
                    struct.setRolePrivilegesIsSet(true);
        lastComparison = java.lang.Boolean.compare(isSetRolePrivileges(), other.isSetRolePrivileges());
        @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> groupPrivileges  
        (short) 2
    public java.lang.String toString() {
            oprot.writeBitSet(optionals, 3);
                                            @org.apache.thrift.annotation.Nullable
        try {
                java.util.List<PrivilegeGrantInfo> other_element_value = other_element.getValue();
                                    iprot.readMapEnd();  
                .entrySet()) {  
    }  
    }
        if (isSetUserPrivileges()) hashCode = hashCode * 8191 + userPrivileges.hashCode();
                                    }  
                                    @org.apache.thrift.annotation.Nullable
            oprot.writeStructBegin(STRUCT_DESC);
        }
        boolean this_present_rolePrivileges = true && this.isSetRolePrivileges();
        return this.groupPrivileges != null;  
        @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> userPrivileges
                                org.apache.thrift.protocol.TList _list95 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
                        @org.apache.thrift.annotation.Nullable
        @Override  
    private static class PrincipalPrivilegeSetTupleScheme extends org.apache.thrift.scheme.TupleScheme<PrincipalPrivilegeSet> {
    private static class PrincipalPrivilegeSetStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                            oprot.writeI32(_iter75.getValue().size());  
                        oprot.writeString(_iter71.getKey());
                java.lang.String __this__userPrivileges_copy_key = other_element_key;
        sb.append("userPrivileges:");
                oprot.writeFieldBegin(ROLE_PRIVILEGES_FIELD_DESC);
        return this;
        return this;  
                        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrivilegeGrantInfo.class)
                    org.apache.thrift.protocol.TType.MAP,  
        if (lastComparison != 0) {  
        if (isSetGroupPrivileges()) {
        }  
                            {  
    }
                    oprot.writeI32(struct.groupPrivileges.size());
        hashCode = hashCode * 8191 + ((isSetGroupPrivileges()) ? 131071 : 524287);  
        java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> groupPrivileges,
                new org.apache.thrift.meta_data.MapMetaData(
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                        .entrySet()) {
                                    @org.apache.thrift.annotation.Nullable
         */
        if (isSetUserPrivileges()) {  
                                    @org.apache.thrift.annotation.Nullable  
                                        }
                                }  
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
                    schemeField = iprot.readFieldBegin();  
    }
            _thriftId = thriftId;  
            }
     * Performs a deep copy on <i>other</i>.  
        if (this == that) return true;  
    }
    public void unsetGroupPrivileges() {  
                        }
                                        _key52 = iprot.readString();  
            }
                            }
                            }
                            oprot.writeListBegin(
        }
    }  
                        .entrySet()) {  
                .entrySet()) {
    }
                        .entrySet()) {
            _Fields.GROUP_PRIVILEGES,
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> groupPrivileges; // required
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.groupPrivileges, other.groupPrivileges);
                                            org.apache.thrift.protocol.TList _list48 = iprot.readListBegin();
                                }  
package org.opensearch.plugin.hive.metastore;  
                                _val86 = new java.util.ArrayList<PrivilegeGrantInfo>(_list88.size);
            }
                            struct.userPrivileges.put(_key78, _val79);  
        tmpMap.put(  
                    org.apache.thrift.protocol.TType.MAP,  
        } catch (org.apache.thrift.TException te) {
            if (struct.isSetRolePrivileges()) {
                                        struct.rolePrivileges.put(_key59, _val60);
                                org.apache.thrift.protocol.TList _list81 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        }
                )  
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
        public short getThriftFieldId() {
        if (!value) {
                        @org.apache.thrift.annotation.Nullable  
                                    struct.userPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(  
            return lastComparison;  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userPrivileges, other.userPrivileges);
        @Override
            if (struct.isSetGroupPrivileges()) {
                        oprot.writeString(_iter69.getKey());  
                return isSetRolePrivileges();
                                            iprot.readListEnd();  
            }  
                                new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter65.getValue().size())  
                    }
                                        struct.userPrivileges.put(_key45, _val46);  
            java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> __this__userPrivileges = new java.util.HashMap<
                break;
    private static final org.apache.thrift.protocol.TField USER_PRIVILEGES_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
        java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> userPrivileges,
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
                            _key92 = iprot.readString();
        );
        this.groupPrivileges = null;
                    {
    }  
            prot.incrementRecursionDepth();  
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    }
        }  
            oprot.writeFieldStop();  
                java.util.List<PrivilegeGrantInfo>>(other.rolePrivileges.size());
            this.userPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>();
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter67 : struct.groupPrivileges
                                for (int _i83 = 0; _i83 < _list81.size; ++_i83) {  
 * Autogenerated by Thrift Compiler (0.23.0)
                    struct.setGroupPrivilegesIsSet(true);
            return getClass().getName().compareTo(other.getClass().getName());  
            case USER_PRIVILEGES:
                {
                                @org.apache.thrift.annotation.Nullable
                );  
                                    _elem82.read(iprot);
        sb.append("rolePrivileges:");  
                    );  
                                                _elem63 = new PrivilegeGrantInfo();
        }  
                        {
    static {
        this.userPrivileges = null;  
    }
                            for (PrivilegeGrantInfo _iter72 : _iter71.getValue()) {
        this.userPrivileges = userPrivileges;  
        boolean this_present_userPrivileges = true && this.isSetUserPrivileges();
                }
        this.groupPrivileges = groupPrivileges;
                        )
            _Fields.ROLE_PRIVILEGES,
    public void unsetRolePrivileges() {
        public void write(org.apache.thrift.protocol.TProtocol oprot, PrincipalPrivilegeSet struct) throws org.apache.thrift.TException {
                {
                                }
        }  
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
                                struct.setRolePrivilegesIsSet(true);  
        }
                        for (int _i94 = 0; _i94 < _map91.size; ++_i94) {
                            }  
        if (!first) sb.append(", ");
    private static final org.apache.thrift.protocol.TField GROUP_PRIVILEGES_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    iprot.readFieldEnd();
        Cloneable,
        first = false;
        }
    }  
                                    java.lang.String _key52;
                                                _elem63.read(iprot);  
                        new org.apache.thrift.protocol.TMap(
            if (!this.groupPrivileges.equals(that.groupPrivileges)) return false;
                return isSetUserPrivileges();
                }  
            } finally {
                                    iprot.readMapEnd();
                    return GROUP_PRIVILEGES;  
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
                                    java.util.List<PrivilegeGrantInfo> _val53;
        this.rolePrivileges.put(key, val);
                {  
    }  
    public int compareTo(PrincipalPrivilegeSet other) {
                                                _elem56.read(iprot);
                    for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> _iter71 : struct.userPrivileges
        public void write(org.apache.thrift.protocol.TProtocol prot, PrincipalPrivilegeSet struct) throws org.apache.thrift.TException {
            }
                                _iter68.write(oprot);  
                    }
                "userPrivileges",  
            case USER_PRIVILEGES:  
                        {
                java.lang.String other_element_key = other_element.getKey();
        if (other.isSetUserPrivileges()) {  
    @Override  
                        @org.apache.thrift.annotation.Nullable
            if (struct.groupPrivileges != null) {  
            }
            new org.apache.thrift.meta_data.FieldMetaData(
                java.util.List<PrivilegeGrantInfo> __this__userPrivileges_copy_value = new java.util.ArrayList<PrivilegeGrantInfo>(  
                for (PrivilegeGrantInfo other_element_value_element : other_element_value) {
                }
        if (this.userPrivileges == null) {
                        case 2: // GROUP_PRIVILEGES  
                            );
        this.userPrivileges.put(key, val);
            _Fields fields = findByThriftId(fieldId);
            struct.validate();  
        return (this.groupPrivileges == null) ? 0 : this.groupPrivileges.size();
            if (lastComparison != 0) {
    }
    /** Returns true if field userPrivileges is set (has been assigned a value) and false otherwise */
                case 1: // USER_PRIVILEGES  
                        );
    public boolean equals(PrincipalPrivilegeSet that) {
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                optionals.set(1);
                            2 * _map91.size
    public java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> getRolePrivileges() {  
        return true;
                            } else {
                                            @org.apache.thrift.annotation.Nullable  
            try {
            }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rolePrivileges, other.rolePrivileges);  
                if (incoming.get(2)) {  
                                            iprot.readListEnd();
            return lastComparison;
                if (value == null) {
    }  
        @Override  
         * Find the _Fields constant that matches fieldId, or null if its not found.
                        @org.apache.thrift.annotation.Nullable
        if (this.rolePrivileges == null) {
        );
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
            return _fieldName;
                if (incoming.get(1)) {
                                org.apache.thrift.protocol.TList _list88 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);  
                }
        return this.rolePrivileges != null;
                case 2: // GROUP_PRIVILEGES
        public java.lang.String getFieldName() {
            java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> __this__groupPrivileges = new java.util.HashMap<  
    }
                            org.apache.thrift.protocol.TType.STRING,
                        org.apache.thrift.protocol.TMap _map77 = iprot.readMapBegin(  
        scheme(oprot).write(oprot, this);  
                                    struct.groupPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>(
                byName.put(field.getFieldName(), field);
                    setGroupPrivileges((java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>>) value);
                    return USER_PRIVILEGES;
    }
                        org.apache.thrift.protocol.TMap _map91 = iprot.readMapBegin(
        }
    public void clear() {
                );
            if (struct.isSetRolePrivileges()) {
        org.apache.thrift.protocol.TType.MAP,
/**  
                                        {
            return byName.get(name);
        this.userPrivileges = userPrivileges;  
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {  
        if (this_present_userPrivileges || that_present_userPrivileges) {
                            }  
                optionals.set(2);
    @Override
        }  
                            org.apache.thrift.protocol.TType.STRING,
                return getRolePrivileges();
                        java.util.List<PrivilegeGrantInfo> _val86;
                                }
        return (this.userPrivileges == null) ? 0 : this.userPrivileges.size();  
                        org.apache.thrift.protocol.TType.LIST,  
                                        _key45 = iprot.readString();
            if (struct.rolePrivileges != null) {  
                                        2 * _map58.size  
        return sb.toString();
        }
            if (lastComparison != 0) {
            this.groupPrivileges = __this__groupPrivileges;
                            struct.groupPrivileges.put(_key85, _val86);
                                for (int _i97 = 0; _i97 < _list95.size; ++_i97) {
                {  
                                _iter76.write(oprot);
                            oprot.writeListBegin(
    public void setGroupPrivilegesIsSet(boolean value) {  
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        }  
            java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> __this__rolePrivileges = new java.util.HashMap<
        } catch (org.apache.thrift.TException te) {  
                new org.apache.thrift.meta_data.MapMetaData(
                                    iprot.readMapEnd();
                    oprot.writeMapEnd();
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
            this.rolePrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>();  
                                    );
                                            _val46 = new java.util.ArrayList<PrivilegeGrantInfo>(_list48.size);
                                    );  
                        for (int _i80 = 0; _i80 < _map77.size; ++_i80) {
                java.lang.String other_element_key = other_element.getKey();
                {  
                }  
                        for (int _i87 = 0; _i87 < _map84.size; ++_i87) {  
        public void read(org.apache.thrift.protocol.TProtocol prot, PrincipalPrivilegeSet struct) throws org.apache.thrift.TException {
                                        {
                        java.util.List<PrivilegeGrantInfo> _val79;
                                            _val60 = new java.util.ArrayList<PrivilegeGrantInfo>(_list62.size);
                            );
    );
                                    _val93.add(_elem96);
                    }  
        throw new java.lang.IllegalStateException();
            throw new java.lang.IllegalArgumentException();
                            oprot.writeListBegin(
    public PrincipalPrivilegeSet setUserPrivileges(  
                            } else {
        }
                if (incoming.get(0)) {
        return this.groupPrivileges;
        }  
        if (other.isSetGroupPrivileges()) {
                        oprot.writeString(_iter75.getKey());
                                            PrivilegeGrantInfo _elem56;
                    oprot.writeMapBegin(  
                    );  
                                    java.util.List<PrivilegeGrantInfo> _val60;
    public PrincipalPrivilegeSet setRolePrivileges(
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);  
                }  
    }
    @org.apache.thrift.annotation.Nullable
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            if (!(this_present_userPrivileges && that_present_userPrivileges)) return false;
                java.lang.String other_element_key = other_element.getKey();  
                        )
 *  @generated
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {  
                    setUserPrivileges((java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>>) value);  
    }  
                    }
        return (this.rolePrivileges == null) ? 0 : this.rolePrivileges.size();
                            2 * _map77.size
                } else {  
                        {
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        boolean that_present_rolePrivileges = true && that.isSetRolePrivileges();
                                struct.setGroupPrivilegesIsSet(true);
        scheme(iprot).read(iprot, this);
         * Find the _Fields constant that matches name, or null if its not found.
    @Override
                    return null;
                    unsetGroupPrivileges();  
            sb.append(this.rolePrivileges);
            }
        if (this.groupPrivileges == null) {
        }
            }
                } else {
    }
        return new PrincipalPrivilegeSet(this);
                iprot.readStructBegin();
            }
        return this.userPrivileges != null;
                    )
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
                java.lang.String,  
                                            }
    /** Returns true if field groupPrivileges is set (has been assigned a value) and false otherwise */
                    new org.apache.thrift.meta_data.ListMetaData(
        }
                return lastComparison;
                iprot.readStructEnd();
        first = false;  
        if (this.rolePrivileges == null) {
            }
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
            this.groupPrivileges = new java.util.HashMap<java.lang.String, java.util.List<PrivilegeGrantInfo>>();
    @org.apache.thrift.annotation.Nullable
            return fields;  
                                            PrivilegeGrantInfo _elem49;
        if (lastComparison != 0) {
                            for (PrivilegeGrantInfo _iter74 : _iter73.getValue()) {
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
     */
        if (this.userPrivileges == null) {  
                }  
                java.lang.String,
        } else {
    }  
                            2 * _map84.size  
                        new org.apache.thrift.protocol.TMap(
    }
    }  
            this.rolePrivileges = null;
         */
                {
    private static final org.apache.thrift.protocol.TField ROLE_PRIVILEGES_FIELD_DESC = new org.apache.thrift.protocol.TField(  
                    }
            switch (fieldId) {
        "rolePrivileges",
        (short) 1
                break;
                                    _elem89 = new PrivilegeGrantInfo();
                    {
                                            for (int _i64 = 0; _i64 < _list62.size; ++_i64) {
                                @org.apache.thrift.annotation.Nullable
        public static _Fields findByThriftId(int fieldId) {
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(PrincipalPrivilegeSet.class, metaDataMap);
        lastComparison = java.lang.Boolean.compare(isSetUserPrivileges(), other.isSetUserPrivileges());
        this.groupPrivileges.put(key, val);  
                            org.apache.thrift.protocol.TType.LIST,  
                    switch (schemeField.id) {
                oprot.writeFieldEnd();
                }
        org.apache.thrift.TBase<PrincipalPrivilegeSet, PrincipalPrivilegeSet._Fields>,
                break;  
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new PrincipalPrivilegeSetTupleSchemeFactory();
                        }
            this.userPrivileges = __this__userPrivileges;  
                                        _key59 = iprot.readString();
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.util.List<PrivilegeGrantInfo>> userPrivileges; // required  
                            for (PrivilegeGrantInfo _iter76 : _iter75.getValue()) {
                        }
                                            }
                                new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, _iter69.getValue().size())  
                __this__userPrivileges.put(__this__userPrivileges_copy_key, __this__userPrivileges_copy_value);
            for (java.util.Map.Entry<java.lang.String, java.util.List<PrivilegeGrantInfo>> other_element : other.groupPrivileges  
                            org.apache.thrift.protocol.TType.STRING,
    public void putToGroupPrivileges(java.lang.String key, java.util.List<PrivilegeGrantInfo> val) {
        if (lastComparison != 0) {
                                            org.apache.thrift.protocol.TList _list55 = iprot.readListBegin();
                                PrivilegeGrantInfo _elem89;  
                                                _val53.add(_elem56);  
        java.io.Serializable,  
                            }
        if (this.groupPrivileges == null) {  
                                {
        public PrincipalPrivilegeSetTupleScheme getScheme() {
        }
