                        @org.apache.thrift.annotation.Nullable
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<  
                    struct.setParametersIsSet(true);
    }  
            return new SerDeInfoStandardScheme();
    }  
        (short) 3  
        PARAMETERS((short) 3, "parameters");
                                    @org.apache.thrift.annotation.Nullable
                if (incoming.get(0)) {  
                        java.lang.String _key7;
    static {
                return lastComparison;
 *
    }  
        );  
        public static _Fields findByName(java.lang.String name) {
    }  
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING  
            return lastComparison;  
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {  
    }
        }
            new org.apache.thrift.meta_data.FieldMetaData(  
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
            sb.append("null");
                "name",  
    }  
        }  
        if (!value) {  
        sb.append(")");
            sb.append(this.parameters);
                        )
    private static class SerDeInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<SerDeInfo> {  
        if (lastComparison != 0) {
        } else {
            if (struct.isSetParameters()) {  
            }  
                    setName((java.lang.String) value);  
        // check for required fields  
                return isSetParameters();
                }
                java.lang.String>(other.parameters);
                    }  
            )
            if (lastComparison != 0) {  
            case PARAMETERS:  
            return _fieldName;
            sb.append(this.name);  
        sb.append("parameters:");  
                oprot.writeFieldBegin(SERIALIZATION_LIB_FIELD_DESC);
        }
            } finally {  
        );
                        struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map6.size);
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SerDeInfoStandardSchemeFactory();  
                        org.apache.thrift.protocol.TMap _map6 = iprot.readMapBegin(
    }  
        }  
                    struct.setNameIsSet(true);
        }
                    unsetName();
    }  
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }  
        this.parameters = parameters;
    }
        this.parameters = parameters;  
            new org.apache.thrift.meta_data.FieldMetaData(
        }
    }
            this.serializationLib = null;
        public void write(org.apache.thrift.protocol.TProtocol oprot, SerDeInfo struct) throws org.apache.thrift.TException {  
                            struct.parameters.put(_key7, _val8);
        SERIALIZATION_LIB((short) 2, "serializationLib"),
            this.name = other.name;
 *  @generated
        );  
                iprot.readStructBegin();
            return new SerDeInfoTupleScheme();
    }  
        return this;
            this.name = null;  
    public @org.apache.thrift.annotation.Nullable java.lang.String name; // required  
            oprot.writeStructBegin(STRUCT_DESC);  
                oprot.writeString(struct.name);  
            if (!(this_present_serializationLib && that_present_serializationLib)) return false;  
    /** Returns true if field name is set (has been assigned a value) and false otherwise */
    public void setSerializationLibIsSet(boolean value) {
                oprot.writeFieldEnd();
            if (struct.parameters != null) {
        tmpMap.put(
        _Fields(short thriftId, java.lang.String fieldName) {
    }
        return this.parameters;  
    public SerDeInfo deepCopy() {
        return true;
                }
            throw new java.io.IOException(te);
                            org.apache.thrift.protocol.TType.STRING,
            if (struct.serializationLib != null) {  
                            _val8 = iprot.readString();  
            }
    public java.lang.String toString() {
                                {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        }  
    }
                "serializationLib",
        if (!value) {
            }
        }  
                break;
                iprot.readStructEnd();
    ) {
                                struct.setParametersIsSet(true);
        if (isSetSerializationLib()) {
            if (struct.isSetParameters()) {
        public short getThriftFieldId() {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        hashCode = hashCode * 8191 + ((isSetParameters()) ? 131071 : 524287);  
        }
        return sb.toString();
        this.name = name;
    }
    @org.apache.thrift.annotation.Nullable
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
        java.lang.String name,
         */
                if (incoming.get(1)) {
                                    java.lang.String _val2;
                oprot.writeFieldBegin(NAME_FIELD_DESC);
    }
                {
        Comparable<SerDeInfo> {
        this();  
            _Fields.PARAMETERS,
    public java.lang.String getSerializationLib() {
    public SerDeInfo setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {  
        }
                            }
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SerDeInfoTupleSchemeFactory();
            if (!this.serializationLib.equals(that.serializationLib)) return false;
        scheme(iprot).read(iprot, this);
                return getName();
        public SerDeInfoStandardScheme getScheme() {
        sb.append("serializationLib:");
        }  
                oprot.writeString(struct.serializationLib);
                if (value == null) {
                    oprot.writeMapEnd();
        }
        return (this.parameters == null) ? 0 : this.parameters.size();  
}
        if (lastComparison != 0) {  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
    private static class SerDeInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        }
        if (that == null) return false;
    }  
                    org.apache.thrift.protocol.TType.MAP,
    }
                        oprot.writeString(_iter5.getValue());  
            case NAME:  
                                    struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map0.size);
            .getScheme();
        boolean this_present_parameters = true && this.isSetParameters();
                } else {  
                }
            return lastComparison;
                    return PARAMETERS;
            sb.append("null");  
    }
            }
                                }  
        java.io.Serializable,  
        }
        tmpMap.put(  
                                    @org.apache.thrift.annotation.Nullable
            throw new java.lang.IllegalArgumentException();
        public void read(org.apache.thrift.protocol.TProtocol prot, SerDeInfo struct) throws org.apache.thrift.TException {
        /**  
        throw new java.lang.IllegalStateException();
                            }
                            }
    }
        (short) 1
        }
        /**
        public java.lang.String getFieldName() {
        }  
        org.apache.thrift.protocol.TType.STRING,
        @Override
            }
        @Override
        sb.append("name:");
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
            if (struct.isSetName()) {  
                return getParameters();
    }
        }  
    public @org.apache.thrift.annotation.Nullable java.lang.String serializationLib; // required
                } else {
        first = false;  
    public boolean isSetParameters() {
    private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
            sb.append("null");
            oprot.writeBitSet(optionals, 3);  
    public SerDeInfo(
 * Autogenerated by Thrift Compiler (0.23.0)
        if (this_present_parameters || that_present_parameters) {  
                    }  
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        }
                    setSerializationLib((java.lang.String) value);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);  
        public SerDeInfoTupleScheme getScheme() {
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        public void write(org.apache.thrift.protocol.TProtocol prot, SerDeInfo struct) throws org.apache.thrift.TException {  
                                    for (int _i3 = 0; _i3 < _map0.size; ++_i3) {  
    @Override
    /**  
    }
            if (!this.parameters.equals(that.parameters)) return false;
        }  
        boolean first = true;  
                "parameters",
        }
    public void validate() throws org.apache.thrift.TException {
        throw new java.lang.IllegalStateException();
        } catch (org.apache.thrift.TException te) {  
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        switch (field) {
                iprot.decrementRecursionDepth();
        hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);  
            if (struct.isSetSerializationLib()) {
                        new org.apache.thrift.protocol.TMap(  
        boolean that_present_parameters = true && that.isSetParameters();
        }
        @Override  
        }  
    }
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        switch (field) {
    }
    private static final org.apache.thrift.protocol.TField SERIALIZATION_LIB_FIELD_DESC = new org.apache.thrift.protocol.TField(
        if (other.isSetSerializationLib()) {
    }  
    @Override
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter4 : struct.parameters.entrySet()) {  
            }
    }
    @Override
            oprot.writeStructEnd();  
        this.name = name;  
        org.apache.thrift.protocol.TType.MAP,
            this.serializationLib = other.serializationLib;
                prot.decrementRecursionDepth();
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SerDeInfo");  
    }
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
package org.opensearch.plugin.hive.metastore;  
                if (value == null) {  
            return byName.get(name);
                            org.apache.thrift.protocol.TType.STRING  
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            _Fields,
                oprot.writeString(struct.name);
/**  
            }
    private static class SerDeInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        if (isSetSerializationLib()) hashCode = hashCode * 8191 + serializationLib.hashCode();
                break;
        int lastComparison = 0;  
    );
    }
public class SerDeInfo  
                        oprot.writeString(_iter5.getKey());
            try {
        if (this_present_serializationLib || that_present_serializationLib) {
                        @org.apache.thrift.annotation.Nullable  
        if (!first) sb.append(", ");
                            break;
    }
        return this;
            )
        org.apache.thrift.TBase<SerDeInfo, SerDeInfo._Fields>,
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter5 : struct.parameters.entrySet()) {
            }  
     */
    @Override
            throw new java.io.IOException(te);
                                        _val2 = iprot.readString();
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    }
        }
        } else {
        if (isSetParameters()) {
         */
        if (lastComparison != 0) {
        return this.serializationLib != null;
                        case 3: // PARAMETERS  
        if (other.isSetName()) {
        hashCode = hashCode * 8191 + ((isSetSerializationLib()) ? 131071 : 524287);  
    public int getParametersSize() {
    public boolean isSetName() {  
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SerDeInfo.class, metaDataMap);
        public void read(org.apache.thrift.protocol.TProtocol iprot, SerDeInfo struct) throws org.apache.thrift.TException {  
    }
    public SerDeInfo setParameters(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters) {  
            case NAME:  
                default:  
                return isSetSerializationLib();  
        }  
                    oprot.writeI32(struct.parameters.size());  
                                struct.serializationLib = iprot.readString();  
    @Override  
        java.util.Map<java.lang.String, java.lang.String> parameters
    public void unsetParameters() {
                    unsetParameters();
                        oprot.writeString(_iter4.getKey());
    }
                optionals.set(2);
        private final java.lang.String _fieldName;  
    }  
        if (isSetParameters()) hashCode = hashCode * 8191 + parameters.hashCode();
            case SERIALIZATION_LIB:
        this.serializationLib = null;  
    @Override  
                            _key7 = iprot.readString();
                    {  
    public void setNameIsSet(boolean value) {
            if (!(this_present_name && that_present_name)) return false;
    );  
    @org.apache.thrift.annotation.Nullable  
        }  
        if (this_present_name || that_present_name) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,  
    public void clear() {  
        return new SerDeInfo(this);
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {  
                            break;  
    }
            case SERIALIZATION_LIB:
     * Performs a deep copy on <i>other</i>.
                    struct.serializationLib = iprot.readString();
                    setParameters((java.util.Map<java.lang.String, java.lang.String>) value);
    public void unsetName() {
    public SerDeInfo(SerDeInfo other) {  
        this.serializationLib = serializationLib;
                                struct.setSerializationLibIsSet(true);
        return 0;
                } else {
            this.parameters = __this__parameters;
            this.parameters = null;
        this.parameters = null;  
                    schemeField = iprot.readFieldBegin();  
                        for (int _i9 = 0; _i9 < _map6.size; ++_i9) {
        } else {  
        java.lang.String serializationLib,  
                                struct.setNameIsSet(true);
        first = false;
                return lastComparison;  
    }  
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)  
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {  
        static {  
                byName.put(field.getFieldName(), field);
                optionals.set(1);
        public static _Fields findByThriftId(int fieldId) {
         * Find the _Fields constant that matches fieldId, or null if its not found.
                }  
        @Override
                if (value == null) {
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        "serializationLib",
                                struct.name = iprot.readString();
        if (this.parameters == null) {
    public boolean equals(SerDeInfo that) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        return this.name;
    public SerDeInfo() {}
                struct.validate();
                }
    @org.apache.thrift.annotation.Nullable
                        }
    public void putToParameters(java.lang.String key, java.lang.String val) {  
            }
            sb.append(this.serializationLib);
        first = false;
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        return hashCode;  
            return fields;  
            return getClass().getName().compareTo(other.getClass().getName());  
    }  
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
         * Find the _Fields constant that matches fieldId, throwing an exception  
        @Override  
                return getSerializationLib();
        if (!getClass().equals(other.getClass())) {
        if (that instanceof SerDeInfo) return this.equals((SerDeInfo) that);  
        } catch (org.apache.thrift.TException te) {
                            } else {  
            if (lastComparison != 0) {
            if (struct.isSetName()) {
                            org.apache.thrift.protocol.TType.STRING,
                return lastComparison;
    @org.apache.thrift.annotation.Nullable
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {  
        if (this.parameters == null) {
                )
        @Override  
            struct.validate();
                    return null;
        }
            }
    @Override
    public boolean equals(java.lang.Object that) {
            }  
            return lastComparison;
        if (isSetName()) {  
                    struct.name = iprot.readString();
                    switch (schemeField.id) {
    /** Returns true if field serializationLib is set (has been assigned a value) and false otherwise */  
        }  
    public java.lang.Object getFieldValue(_Fields field) {
    @Override
                }
    @Override  
            java.util.Map<java.lang.String, java.lang.String> __this__parameters = new java.util.HashMap<
        }
        boolean this_present_serializationLib = true && this.isSetSerializationLib();  
        lastComparison = java.lang.Boolean.compare(isSetSerializationLib(), other.isSetSerializationLib());  
                case 2: // SERIALIZATION_LIB
            }  
            new org.apache.thrift.meta_data.FieldMetaData(
    implements
            _Fields.SERIALIZATION_LIB,  
    public boolean isSetSerializationLib() {
    // isset id assignments  
    public int hashCode() {  
         * if it is not found.
    @Override  
                }  
        (short) 2
                            break;
        boolean that_present_name = true && that.isSetName();  
        switch (field) {
            prot.incrementRecursionDepth();
            }  
        this.name = null;
            _Fields.NAME,
                    oprot.writeMapBegin(
        Cloneable,
        if (field == null) {
        }
        // check for sub-struct validity
        this.parameters.put(key, val);
        }  
        if (other.isSetParameters()) {
                    }
        return this;
                new org.apache.thrift.meta_data.MapMetaData(  
         * Find the _Fields constant that matches name, or null if its not found.
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                        case 2: // SERIALIZATION_LIB
            switch (fieldId) {
    }  
    private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField(  
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
            return _thriftId;  
        }
                                        struct.parameters.put(_key1, _val2);  
                oprot.writeFieldEnd();  
            if (struct.name != null) {
        return _Fields.findByThriftId(fieldId);
        try {
        this.serializationLib = serializationLib;
                        );
        if (this == that) return true;  
    }  
        @Override  
        }  
    private static class SerDeInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<SerDeInfo> {  
                while (true) {
                case 3: // PARAMETERS
            _thriftId = thriftId;  
            java.util.BitSet optionals = new java.util.BitSet();
        tmpMap.put(
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
    public void unsetSerializationLib() {
        lastComparison = java.lang.Boolean.compare(isSetName(), other.isSetName());
                oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);  
        return this.serializationLib;  
                        oprot.writeString(_iter4.getValue());
                if (incoming.get(2)) {
        }  
        scheme(oprot).write(oprot, this);  
        this.name = null;
                }
    public SerDeInfo setSerializationLib(@org.apache.thrift.annotation.Nullable java.lang.String serializationLib) {  
        org.apache.thrift.protocol.TType.STRING,  
            if (!(this_present_parameters && that_present_parameters)) return false;
                java.lang.String,  
        }
                        default:  
            _Fields fields = findByThriftId(fieldId);
            )  
        this.parameters = null;  
    );
                                    org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();  
    }  
    public int compareTo(SerDeInfo other) {
        }  
        private final short _thriftId;
        @org.apache.thrift.annotation.Nullable  
            if (lastComparison != 0) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        "parameters",
        return this.parameters != null;
        try {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));  
        if (isSetName()) hashCode = hashCode * 8191 + name.hashCode();
                    struct.setSerializationLibIsSet(true);  
        int hashCode = 1;
        lastComparison = java.lang.Boolean.compare(isSetParameters(), other.isSetParameters());
        return this.name != null;
                                    iprot.readMapEnd();
    }  
                    }  
                            struct.parameters.size()  
         */
    }  
        /**  
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        java.lang.StringBuilder sb = new java.lang.StringBuilder("SerDeInfo(");
            if (struct.isSetSerializationLib()) {  
                {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);  
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters; // required
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    public void setParametersIsSet(boolean value) {
                            } else {
    public java.lang.String getName() {
                org.apache.thrift.protocol.TField schemeField;  
 */
                                    java.lang.String _key1;  
                    return NAME;
    @Override  
            _fieldName = fieldName;
        @Override
        @org.apache.thrift.annotation.Nullable  
    public boolean isSet(_Fields field) {  
            try {  
                        java.lang.String _val8;  
        }  
        if (this.name == null) {  
    }
        public static _Fields findByThriftIdOrThrow(int fieldId) {  
                // check for required fields of primitive type, which can't be checked in the validate method
            }
    @Override
            case PARAMETERS:  
        }  
        this.serializationLib = null;
    }
        NAME((short) 1, "name"),  
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serializationLib, other.serializationLib);
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            }
        "name",  
                                    }
        }
        if (!value) {  
                java.util.BitSet incoming = iprot.readBitSet(3);
                optionals.set(0);
    @org.apache.thrift.annotation.Nullable
                    );
        boolean that_present_serializationLib = true && that.isSetSerializationLib();
            oprot.writeFieldStop();
            iprot.incrementRecursionDepth();
                    return SERIALIZATION_LIB;  
                            org.apache.thrift.protocol.TType.STRING,
        if (this.serializationLib == null) {
        if (!first) sb.append(", ");  
            case PARAMETERS:
            if (!this.name.equals(that.name)) return false;  
            case SERIALIZATION_LIB:  
            this.parameters = new java.util.HashMap<java.lang.String, java.lang.String>();
                    iprot.readFieldEnd();  
        boolean this_present_name = true && this.isSetName();
                    unsetSerializationLib();  
    public java.util.Map<java.lang.String, java.lang.String> getParameters() {
                case 1: // NAME  
                        case 1: // NAME
                                        _key1 = iprot.readString();
                oprot.writeFieldEnd();  
    /** Returns true if field parameters is set (has been assigned a value) and false otherwise */  
                            } else {
                break;  
                }
                        break;
                return isSetName();
            } finally {  
            case NAME:
        return false;
            }
                oprot.writeString(struct.serializationLib);
                    }
    public _Fields fieldForId(int fieldId) {
