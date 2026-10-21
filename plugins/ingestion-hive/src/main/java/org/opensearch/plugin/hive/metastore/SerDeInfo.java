            if (struct.isSetParameters()) {
 *  @generated
                oprot.writeFieldBegin(NAME_FIELD_DESC);
        sb.append("serializationLib:");
        public static _Fields findByName(java.lang.String name) {
        lastComparison = java.lang.Boolean.compare(isSetName(), other.isSetName());
        if (!value) {
    // isset id assignments
                    oprot.writeMapEnd();
        return false;
        );
            if (!(this_present_serializationLib && that_present_serializationLib)) return false;
                }
    /** Returns true if field parameters is set (has been assigned a value) and false otherwise */
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            return _thriftId;
        private final short _thriftId;
        org.apache.thrift.protocol.TType.STRING,
                    }
    public @org.apache.thrift.annotation.Nullable java.lang.String name; // required
                if (value == null) {
                                struct.setNameIsSet(true);
        if (isSetName()) hashCode = hashCode * 8191 + name.hashCode();
                java.lang.String,
        @Override
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    @Override
        (short) 1
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        switch (field) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        }
        scheme(iprot).read(iprot, this);
    }
            this.name = null;
    }
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
            java.util.Map<java.lang.String, java.lang.String> __this__parameters = new java.util.HashMap<
        "serializationLib",
    }
            if (struct.name != null) {
    @Override
        this.parameters = parameters;
                org.apache.thrift.protocol.TField schemeField;
        return this.serializationLib != null;
    private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField(
    }
            .getScheme();
    @Override
        }
    }
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
                    setName((java.lang.String) value);
        boolean this_present_parameters = true && this.isSetParameters();
            if (!this.name.equals(that.name)) return false;
                                        _val2 = iprot.readString();
                        oprot.writeString(_iter5.getValue());
        java.lang.String serializationLib,
        );
                }
     * Performs a deep copy on <i>other</i>.
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            }
        hashCode = hashCode * 8191 + ((isSetParameters()) ? 131071 : 524287);
    @Override
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        this.serializationLib = serializationLib;
        boolean that_present_parameters = true && that.isSetParameters();
        return this;
        if (isSetParameters()) hashCode = hashCode * 8191 + parameters.hashCode();
                iprot.readStructBegin();
        }
            this.name = other.name;
                            } else {
                oprot.writeString(struct.serializationLib);
                    return NAME;
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters; // required
        }
    private static class SerDeInfoTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                    }
        this.serializationLib = serializationLib;
                if (incoming.get(1)) {
                java.lang.String>(other.parameters);
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
                    oprot.writeMapBegin(
                                        _key1 = iprot.readString();
                    struct.name = iprot.readString();
        /**
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    }
    }
                )
        }
        switch (field) {
        public java.lang.String getFieldName() {
        }
            case NAME:
    @Override
            if (struct.isSetSerializationLib()) {
        public void read(org.apache.thrift.protocol.TProtocol prot, SerDeInfo struct) throws org.apache.thrift.TException {
            struct.validate();
        int hashCode = 1;
            return fields;
                                {
                oprot.writeFieldBegin(SERIALIZATION_LIB_FIELD_DESC);
                    setParameters((java.util.Map<java.lang.String, java.lang.String>) value);
                }
            if (struct.isSetParameters()) {
                new org.apache.thrift.meta_data.MapMetaData(
                    return PARAMETERS;
                        java.lang.String _val8;
        boolean this_present_name = true && this.isSetName();
    }
        }
    public void putToParameters(java.lang.String key, java.lang.String val) {
            if (struct.isSetName()) {
        return this;
                if (value == null) {
                    return SERIALIZATION_LIB;
        @Override
        this.parameters = null;
            switch (fieldId) {
    public SerDeInfo(
        @Override
        @org.apache.thrift.annotation.Nullable
                }
    public SerDeInfo deepCopy() {
            sb.append(this.serializationLib);
        }
            )
public class SerDeInfo
        @Override
            this.parameters = null;
    private static class SerDeInfoTupleScheme extends org.apache.thrift.scheme.TupleScheme<SerDeInfo> {
                                struct.name = iprot.readString();
         * if it is not found.
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
        lastComparison = java.lang.Boolean.compare(isSetSerializationLib(), other.isSetSerializationLib());
                                }
        if (lastComparison != 0) {
        return hashCode;
        (short) 3
            case NAME:
        "parameters",
                                    for (int _i3 = 0; _i3 < _map0.size; ++_i3) {
        public void write(org.apache.thrift.protocol.TProtocol oprot, SerDeInfo struct) throws org.apache.thrift.TException {
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(SerDeInfo.class, metaDataMap);
    }
    public void unsetName() {
        if (this.parameters == null) {
                oprot.writeString(struct.name);
    }
        org.apache.thrift.protocol.TType.MAP,
    }
            this.serializationLib = null;
                            }
                            org.apache.thrift.protocol.TType.STRING,
        this.name = null;
            return lastComparison;
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    );
                iprot.readStructEnd();
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serializationLib, other.serializationLib);
    }
        if (field == null) {
        this.name = name;
            _fieldName = fieldName;
        }
            }
    }
        tmpMap.put(
            return getClass().getName().compareTo(other.getClass().getName());
            if (struct.isSetName()) {
            return new SerDeInfoStandardScheme();
        java.lang.StringBuilder sb = new java.lang.StringBuilder("SerDeInfo(");
    public int getParametersSize() {
            if (struct.parameters != null) {
    @Override
        SERIALIZATION_LIB((short) 2, "serializationLib"),
        PARAMETERS((short) 3, "parameters");
        }
        }
    }
                if (value == null) {
        );
        Cloneable,
        }
                            break;
                "serializationLib",
        boolean first = true;
        if (other.isSetSerializationLib()) {
                iprot.decrementRecursionDepth();
        this.name = null;
        }
        if (other.isSetParameters()) {
        if (!first) sb.append(", ");
        }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);
            }
            if (lastComparison != 0) {
            }
}
    private static final org.apache.thrift.protocol.TField SERIALIZATION_LIB_FIELD_DESC = new org.apache.thrift.protocol.TField(
    }
                                        struct.parameters.put(_key1, _val2);
    public void clear() {
                optionals.set(1);
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new SerDeInfoStandardSchemeFactory();
                    oprot.writeI32(struct.parameters.size());
                break;
        @Override
    }
                case 1: // NAME
            oprot.writeStructBegin(STRUCT_DESC);
        return new SerDeInfo(this);
                if (incoming.get(0)) {
         * Find the _Fields constant that matches fieldId, throwing an exception
                "name",
        first = false;
    }
            throw new java.io.IOException(te);
    }
                while (true) {
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter5 : struct.parameters.entrySet()) {
        java.lang.String name,
    implements
            sb.append(this.parameters);
            new org.apache.thrift.meta_data.FieldMetaData(
                    schemeField = iprot.readFieldBegin();
                                    struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map0.size);
    public boolean isSetName() {
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        }
            _Fields.SERIALIZATION_LIB,
                optionals.set(2);
    @Override
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    public boolean isSetSerializationLib() {
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        "name",
                {
        }
                } else {
        return this.parameters;
    public @org.apache.thrift.annotation.Nullable java.lang.String serializationLib; // required
            _Fields.NAME,
        boolean this_present_serializationLib = true && this.isSetSerializationLib();
                        )
    @Override
            )
    }
            new org.apache.thrift.meta_data.FieldMetaData(
            sb.append(this.name);
                java.util.BitSet incoming = iprot.readBitSet(3);
    /** Returns true if field serializationLib is set (has been assigned a value) and false otherwise */
        if (that instanceof SerDeInfo) return this.equals((SerDeInfo) that);
            }
        }
                                    @org.apache.thrift.annotation.Nullable
        }
    @Override
    public java.lang.String getName() {
    public void setSerializationLibIsSet(boolean value) {
                return getParameters();
            _thriftId = thriftId;
            case PARAMETERS:
                return getName();
    @Override
            if (!(this_present_name && that_present_name)) return false;
            if (struct.serializationLib != null) {
                        oprot.writeString(_iter4.getKey());
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
        if (other.isSetName()) {
    }
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        }
            }
    public boolean isSet(_Fields field) {
                        oprot.writeString(_iter4.getValue());
                optionals.set(0);
        int lastComparison = 0;
            this.parameters = __this__parameters;
                oprot.writeFieldEnd();
         * Find the _Fields constant that matches fieldId, or null if its not found.
    public SerDeInfo(SerDeInfo other) {
    @Override
        public void write(org.apache.thrift.protocol.TProtocol prot, SerDeInfo struct) throws org.apache.thrift.TException {
                return getSerializationLib();
    @org.apache.thrift.annotation.Nullable
            new org.apache.thrift.meta_data.FieldMetaData(
    public SerDeInfo setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
                    struct.serializationLib = iprot.readString();
                        case 2: // SERIALIZATION_LIB
            this.parameters = new java.util.HashMap<java.lang.String, java.lang.String>();
        if (this_present_parameters || that_present_parameters) {
        }
        if (!value) {
        first = false;
                                    @org.apache.thrift.annotation.Nullable
        if (!getClass().equals(other.getClass())) {
                    unsetName();
            }
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                                    iprot.readMapEnd();
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
    public void validate() throws org.apache.thrift.TException {
            iprot.incrementRecursionDepth();
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
        java.io.Serializable,
            _Fields.PARAMETERS,
         * Find the _Fields constant that matches name, or null if its not found.
        }
    private static class SerDeInfoStandardScheme extends org.apache.thrift.scheme.StandardScheme<SerDeInfo> {
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
        if (isSetName()) {
            if (lastComparison != 0) {
                oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);
                break;
                        java.lang.String _key7;
        if (this_present_serializationLib || that_present_serializationLib) {
    public int compareTo(SerDeInfo other) {
            )
        }
                    iprot.readFieldEnd();
            oprot.writeBitSet(optionals, 3);
            prot.incrementRecursionDepth();
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    public java.lang.String getSerializationLib() {
    }
        } else {
        _Fields(short thriftId, java.lang.String fieldName) {
    public _Fields fieldForId(int fieldId) {
     */
                            } else {
        }
    @org.apache.thrift.annotation.Nullable
    public int hashCode() {
        // check for sub-struct validity
            }
                        struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map6.size);
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        if (that == null) return false;
                        @org.apache.thrift.annotation.Nullable
                            struct.parameters.size()
        try {
                break;
        } catch (org.apache.thrift.TException te) {
                {
        } catch (org.apache.thrift.TException te) {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    );
            }
    }
                                struct.serializationLib = iprot.readString();
        this();
    }
                                struct.setParametersIsSet(true);
                    struct.setParametersIsSet(true);
        }
    }
                }
                oprot.writeString(struct.serializationLib);
    @org.apache.thrift.annotation.Nullable
            this.serializationLib = other.serializationLib;
        throw new java.lang.IllegalStateException();
                    }
                case 2: // SERIALIZATION_LIB
            oprot.writeStructEnd();
                case 3: // PARAMETERS
                return lastComparison;
        }
        public SerDeInfoStandardScheme getScheme() {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
        if (lastComparison != 0) {
    }
 *
        if (lastComparison != 0) {
        public static _Fields findByThriftId(int fieldId) {
        } else {
        sb.append("parameters:");
        this.parameters.put(key, val);
    }
        public SerDeInfoTupleScheme getScheme() {
    static {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("SerDeInfo");
            sb.append("null");
            }
    public void setNameIsSet(boolean value) {
        }
    }
                struct.validate();
        if (isSetSerializationLib()) hashCode = hashCode * 8191 + serializationLib.hashCode();
         */
            case NAME:
        boolean that_present_name = true && that.isSetName();
                prot.decrementRecursionDepth();
        @Override
                            _val8 = iprot.readString();
            }
        return sb.toString();
                    unsetParameters();
        } else {
                    {
        /**
        this.name = name;
                } else {
        // check for required fields
        hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
            return new SerDeInfoTupleScheme();
            } finally {
    ) {
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
         */
            }
                            break;
                        @org.apache.thrift.annotation.Nullable
        if (!value) {
                "parameters",
    }
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                    }
                return isSetSerializationLib();
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        return 0;
                // check for required fields of primitive type, which can't be checked in the validate method
        scheme(oprot).write(oprot, this);
                        oprot.writeString(_iter5.getKey());
                return isSetName();
        }
            return lastComparison;
    public boolean equals(java.lang.Object that) {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    /** Returns true if field name is set (has been assigned a value) and false otherwise */
        sb.append("name:");
        this.serializationLib = null;
    public SerDeInfo() {}
        if (!first) sb.append(", ");
                return lastComparison;
    );
                    }
        throw new java.lang.IllegalStateException();
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
                        break;
    }
            throw new java.io.IOException(te);
        lastComparison = java.lang.Boolean.compare(isSetParameters(), other.isSetParameters());
        sb.append(")");
        java.util.Map<java.lang.String, java.lang.String> parameters
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
        @org.apache.thrift.annotation.Nullable
        }
        public static _Fields findByThriftIdOrThrow(int fieldId) {
            if (!this.serializationLib.equals(that.serializationLib)) return false;
        return this.name != null;
                        default:
                    org.apache.thrift.protocol.TType.MAP,
                            }
        }
                oprot.writeString(struct.name);
                            org.apache.thrift.protocol.TType.STRING,
    }
            try {
                oprot.writeFieldEnd();
    /**
        if (this_present_name || that_present_name) {
        }
        }
        }
            throw new java.lang.IllegalArgumentException();
    }
    }
                        case 1: // NAME
                            struct.parameters.put(_key7, _val8);
        }
    }
        boolean that_present_serializationLib = true && that.isSetSerializationLib();
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
        }
        return true;
                                    org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
        return this.name;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
/**
    public boolean isSetParameters() {
                            break;
                            org.apache.thrift.protocol.TType.STRING
                        case 3: // PARAMETERS
    public boolean equals(SerDeInfo that) {
        return this.serializationLib;
            java.util.BitSet optionals = new java.util.BitSet();
    }
    }
                }
                        for (int _i9 = 0; _i9 < _map6.size; ++_i9) {
        tmpMap.put(
        }
    public SerDeInfo setSerializationLib(@org.apache.thrift.annotation.Nullable java.lang.String serializationLib) {
    public void setParametersIsSet(boolean value) {
    }
            case SERIALIZATION_LIB:
                    setSerializationLib((java.lang.String) value);
        static {
            try {
        }
        this.serializationLib = null;
package org.opensearch.plugin.hive.metastore;
    public java.util.Map<java.lang.String, java.lang.String> getParameters() {
        NAME((short) 1, "name"),
        Comparable<SerDeInfo> {
         */
    @Override
        hashCode = hashCode * 8191 + ((isSetSerializationLib()) ? 131071 : 524287);
                            org.apache.thrift.protocol.TType.STRING,
    @org.apache.thrift.annotation.Nullable
    @org.apache.thrift.annotation.Nullable
        if (isSetParameters()) {
        if (this.serializationLib == null) {
        if (this.name == null) {
            if (!this.parameters.equals(that.parameters)) return false;
        public short getThriftFieldId() {
            return lastComparison;
        }
            if (struct.isSetSerializationLib()) {
                                    }
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
        @Override
        (short) 2
    }
        this.parameters = parameters;
                    struct.setNameIsSet(true);
            }
                                    java.lang.String _val2;
                        );
                            }
                    switch (schemeField.id) {
                    );
                            } else {
                } else {
            } finally {
                    unsetSerializationLib();
            case SERIALIZATION_LIB:
        }
                byName.put(field.getFieldName(), field);
    public void unsetParameters() {
                    return null;
                        }
        org.apache.thrift.protocol.TType.STRING,
        private final java.lang.String _fieldName;
                if (incoming.get(2)) {
    public java.lang.String toString() {
    }
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter4 : struct.parameters.entrySet()) {
            }
        first = false;
 * Autogenerated by Thrift Compiler (0.23.0)
            return byName.get(name);
                                    java.lang.String _key1;
            sb.append("null");
                return isSetParameters();
        try {
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new SerDeInfoTupleSchemeFactory();
        return this;
            case PARAMETERS:
                oprot.writeFieldEnd();
    public void unsetSerializationLib() {
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
        this.parameters = null;
            _Fields,
            if (!(this_present_parameters && that_present_parameters)) return false;
            if (lastComparison != 0) {
                }
                            _key7 = iprot.readString();
        /**
    private static class SerDeInfoStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                }
        if (isSetSerializationLib()) {
        if (this == that) return true;
        return _Fields.findByThriftId(fieldId);
        return this.parameters != null;
        return (this.parameters == null) ? 0 : this.parameters.size();
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            }
            sb.append("null");
                }
                                struct.setSerializationLibIsSet(true);
            case PARAMETERS:
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                return lastComparison;
    private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public java.lang.Object getFieldValue(_Fields field) {
 */
        org.apache.thrift.TBase<SerDeInfo, SerDeInfo._Fields>,
        @Override
    }
        tmpMap.put(
            case SERIALIZATION_LIB:
        switch (field) {
            return _fieldName;
                    struct.setSerializationLibIsSet(true);
        if (this.parameters == null) {
            oprot.writeFieldStop();
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            _Fields fields = findByThriftId(fieldId);
        }
    }
                        new org.apache.thrift.protocol.TMap(
    public SerDeInfo setParameters(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters) {
            }
        public void read(org.apache.thrift.protocol.TProtocol iprot, SerDeInfo struct) throws org.apache.thrift.TException {
                        org.apache.thrift.protocol.TMap _map6 = iprot.readMapBegin(
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                default:
