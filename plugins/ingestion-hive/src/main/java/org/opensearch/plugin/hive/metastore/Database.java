    @Override
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    public int getParametersSize() {
            struct.validate();
            iprot.incrementRecursionDepth();
    }
            if (struct.isSetLocationUri()) {
    public void setParametersIsSet(boolean value) {
        this.parameters.put(key, val);
    }
            this.description = other.description;
        /**
        tmpMap.put(
        if (isSetName()) hashCode = hashCode * 8191 + name.hashCode();
            if (struct.isSetLocationUri()) {
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
    }
        if (isSetParameters()) {
        }
            case LOCATION_URI:
        return 0;
                if (value == null) {
            return fields;
        }
                                    }
    public boolean isSet(_Fields field) {
        } else {
    public void putToParameters(java.lang.String key, java.lang.String val) {
        }
        return this;
        java.lang.String name,
    }
                        oprot.writeString(_iter111.getKey());
            case NAME:
        }
    }
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
            }
        } else {
        boolean that_present_locationUri = true && that.isSetLocationUri();
/**
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
    private static class DatabaseStandardScheme extends org.apache.thrift.scheme.StandardScheme<Database> {
        this.locationUri = null;
            if (!this.name.equals(that.name)) return false;
        }
    }
            _fieldName = fieldName;
        hashCode = hashCode * 8191 + ((isSetParameters()) ? 131071 : 524287);
                                struct.setParametersIsSet(true);
                                    for (int _i109 = 0; _i109 < _map106.size; ++_i109) {
    }
    public boolean isSetDescription() {
        if (other.isSetName()) {
        if (this_present_locationUri || that_present_locationUri) {
    @org.apache.thrift.annotation.Nullable
                    unsetName();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        public java.lang.String getFieldName() {
                            }
                            _key113 = iprot.readString();
        java.lang.String description,
        }
        lastComparison = java.lang.Boolean.compare(isSetParameters(), other.isSetParameters());
            }
                            org.apache.thrift.protocol.TType.STRING,
                oprot.writeString(struct.description);
        if (this_present_parameters || that_present_parameters) {
        public short getThriftFieldId() {
        /**
public class Database
            return _thriftId;
            case NAME:
                            }
                    iprot.readFieldEnd();
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters; // required
                                    @org.apache.thrift.annotation.Nullable
            case PARAMETERS:
    private static class DatabaseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        }
        }
                return lastComparison;
                "description",
        if (isSetDescription()) hashCode = hashCode * 8191 + description.hashCode();
        boolean first = true;
            java.util.BitSet optionals = new java.util.BitSet();
        sb.append("locationUri:");
    /** Returns true if field name is set (has been assigned a value) and false otherwise */
    /** Returns true if field description is set (has been assigned a value) and false otherwise */
    public void unsetName() {
            if (lastComparison != 0) {
        return this.locationUri;
                            _val114 = iprot.readString();
        Cloneable,
        if (other.isSetDescription()) {
                                struct.name = iprot.readString();
        return this.description != null;
    }
                )
    public java.lang.String toString() {
            if (struct.isSetDescription()) {
         */
        DESCRIPTION((short) 2, "description"),
    public int compareTo(Database other) {
                                        _val108 = iprot.readString();
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
                            struct.parameters.put(_key113, _val114);
                                        _key107 = iprot.readString();
                                }
        public static _Fields findByThriftId(int fieldId) {
                    return PARAMETERS;
                optionals.set(2);
            sb.append("null");
    /** Returns true if field locationUri is set (has been assigned a value) and false otherwise */
        if (field == null) {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        java.util.Map<java.lang.String, java.lang.String> parameters
        (short) 4
                return isSetLocationUri();
        );
        }
            sb.append("null");
    @Override
        }
                return isSetParameters();
            return lastComparison;
    }
        return false;
        public void write(org.apache.thrift.protocol.TProtocol oprot, Database struct) throws org.apache.thrift.TException {
        if (this.locationUri == null) {
                default:
        this.locationUri = locationUri;
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
        }
        @org.apache.thrift.annotation.Nullable
    }
                new org.apache.thrift.meta_data.MapMetaData(
                }
                                    struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map106.size);
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new DatabaseStandardSchemeFactory();
            }
         */
            }
            }
    }
            new org.apache.thrift.meta_data.FieldMetaData(
    }
    // isset id assignments
                        )
            return lastComparison;
                oprot.writeFieldEnd();
        if (this == that) return true;
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Database(");
    private static class DatabaseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                            }
                if (incoming.get(3)) {
                    oprot.writeMapBegin(
            if (lastComparison != 0) {
            return _fieldName;
    }
                    return LOCATION_URI;
                            } else {
    @org.apache.thrift.annotation.Nullable
    }
        if (this.name == null) {
package org.opensearch.plugin.hive.metastore;
                    }
    private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField(
    @Override
         * Find the _Fields constant that matches name, or null if its not found.
    @Override
            oprot.writeFieldStop();
    public java.lang.String getDescription() {
        if (that instanceof Database) return this.equals((Database) that);
                                    java.lang.String _val108;
    }
                oprot.writeString(struct.locationUri);
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
        );
                oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);
        return true;
    }
                    setParameters((java.util.Map<java.lang.String, java.lang.String>) value);
        if (!first) sb.append(", ");
        return this.name;
                            } else {
    @org.apache.thrift.annotation.Nullable
                }
        @Override
            sb.append("null");
            } finally {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
            case LOCATION_URI:
        if (other.isSetLocationUri()) {
                    setDescription((java.lang.String) value);
    }
        scheme(iprot).read(iprot, this);
        }
            sb.append(this.name);
        if (!first) sb.append(", ");
    public Database setDescription(@org.apache.thrift.annotation.Nullable java.lang.String description) {
            _Fields.LOCATION_URI,
        if (this.parameters == null) {
    public boolean isSetParameters() {
            new org.apache.thrift.meta_data.FieldMetaData(
        this.name = null;
            throw new java.io.IOException(te);
    }
        if (!first) sb.append(", ");
            }
        if (other.isSetParameters()) {
        }
                break;
            this.description = null;
                        oprot.writeString(_iter110.getValue());
                optionals.set(1);
            if (struct.name != null) {
        }
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
            return getClass().getName().compareTo(other.getClass().getName());
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
                if (incoming.get(0)) {
        hashCode = hashCode * 8191 + ((isSetDescription()) ? 131071 : 524287);
        hashCode = hashCode * 8191 + ((isSetLocationUri()) ? 131071 : 524287);
                        struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map112.size);
    @Override
                oprot.writeString(struct.locationUri);
        }
        @Override
        "locationUri",
    }
        }
            oprot.writeStructEnd();
            _Fields fields = findByThriftId(fieldId);
        }
    }
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
        boolean this_present_locationUri = true && this.isSetLocationUri();
    }
            }
        switch (field) {
        }
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter110 : struct.parameters.entrySet()) {
            if (struct.description != null) {
                        oprot.writeString(_iter111.getValue());
        tmpMap.put(
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    public Database(Database other) {
                    struct.setParametersIsSet(true);
                    }
    public @org.apache.thrift.annotation.Nullable java.lang.String description; // required
        }
            }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
            sb.append("null");
 * Autogenerated by Thrift Compiler (0.23.0)
        hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
        }
    }
        return this;
    }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                oprot.writeString(struct.name);
    }
                    struct.setNameIsSet(true);
                            } else {
        public void write(org.apache.thrift.protocol.TProtocol prot, Database struct) throws org.apache.thrift.TException {
                        java.lang.String _val114;
    }
        }
                java.util.BitSet incoming = iprot.readBitSet(4);
            case DESCRIPTION:
                        org.apache.thrift.protocol.TMap _map112 = iprot.readMapBegin(
        return this.parameters;
    static {
    @Override
        if (this.parameters == null) {
            sb.append(this.description);
        );
            if (!(this_present_name && that_present_name)) return false;
                return isSetDescription();
    }
    public java.lang.String getName() {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.description, other.description);
        this.description = description;
    public void unsetLocationUri() {
            }
 *
                case 3: // LOCATION_URI
                optionals.set(0);
    public @org.apache.thrift.annotation.Nullable java.lang.String name; // required
    /**
                }
                            org.apache.thrift.protocol.TType.STRING,
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        }
    }
        if (isSetParameters()) hashCode = hashCode * 8191 + parameters.hashCode();
        return this;
                    struct.setDescriptionIsSet(true);
                                struct.locationUri = iprot.readString();
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
                        default:
        /**
            }
            if (struct.locationUri != null) {
    @Override
        sb.append("name:");
        @Override
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        }
    @Override
        first = false;
        return (this.parameters == null) ? 0 : this.parameters.size();
    public boolean equals(java.lang.Object that) {
                oprot.writeFieldBegin(LOCATION_URI_FIELD_DESC);
            try {
            return lastComparison;
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Database");
    }
            return new DatabaseTupleScheme();
        return this.parameters != null;
        public static _Fields findByThriftIdOrThrow(int fieldId) {
    }
        );
        @Override
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
        boolean that_present_name = true && that.isSetName();
        return this.locationUri != null;
        public void read(org.apache.thrift.protocol.TProtocol prot, Database struct) throws org.apache.thrift.TException {
                java.lang.String,
                    switch (schemeField.id) {
    );
        if (this.description == null) {
    }
            this.locationUri = null;
                {
        public DatabaseStandardScheme getScheme() {
        if (isSetLocationUri()) {
            _thriftId = thriftId;
    public Database setName(@org.apache.thrift.annotation.Nullable java.lang.String name) {
                case 4: // PARAMETERS
         */
                case 2: // DESCRIPTION
    /** Returns true if field parameters is set (has been assigned a value) and false otherwise */
        private final short _thriftId;
        if (lastComparison != 0) {
            throw new java.lang.IllegalArgumentException();
            if (!(this_present_parameters && that_present_parameters)) return false;
                                struct.setLocationUriIsSet(true);
    }
                }
        @Override
                    return NAME;
        this.locationUri = null;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    public java.lang.Object getFieldValue(_Fields field) {
        if (!getClass().equals(other.getClass())) {
    private static final org.apache.thrift.protocol.TField DESCRIPTION_FIELD_DESC = new org.apache.thrift.protocol.TField(
                if (value == null) {
            case DESCRIPTION:
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            throw new java.io.IOException(te);
        boolean this_present_name = true && this.isSetName();
                        oprot.writeString(_iter110.getKey());
        int hashCode = 1;
                break;
    );
                    );
            }
        }
    public boolean isSetLocationUri() {
                    struct.locationUri = iprot.readString();
    private static final org.apache.thrift.protocol.TField LOCATION_URI_FIELD_DESC = new org.apache.thrift.protocol.TField(
                prot.decrementRecursionDepth();
            } finally {
        return _Fields.findByThriftId(fieldId);
            if (struct.isSetParameters()) {
         * Find the _Fields constant that matches fieldId, or null if its not found.
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        if (isSetDescription()) {
                oprot.writeFieldBegin(DESCRIPTION_FIELD_DESC);
        throw new java.lang.IllegalStateException();
                        new org.apache.thrift.protocol.TMap(
        first = false;
    @org.apache.thrift.annotation.Nullable
            if (!this.description.equals(that.description)) return false;
    ) {
        }
                }
            if (struct.parameters != null) {
    @Override
                return getName();
            if (struct.isSetParameters()) {
    }
                }
            if (!(this_present_description && that_present_description)) return false;
    @Override
        Comparable<Database> {
                } else {
        public DatabaseTupleScheme getScheme() {
    }
    @org.apache.thrift.annotation.Nullable
        if (lastComparison != 0) {
                            struct.parameters.size()
        return hashCode;
        }
        }
        }
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
                    unsetDescription();
    public java.lang.String getLocationUri() {
        return sb.toString();
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Database.class, metaDataMap);
        boolean that_present_description = true && that.isSetDescription();
        if (lastComparison != 0) {
                java.lang.String>(other.parameters);
                "name",
                                {
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            case DESCRIPTION:
        sb.append(")");
    public void setLocationUriIsSet(boolean value) {
                    struct.name = iprot.readString();
        LOCATION_URI((short) 3, "locationUri"),
        boolean this_present_parameters = true && this.isSetParameters();
        @Override
    }
                                    @org.apache.thrift.annotation.Nullable
            )
            new org.apache.thrift.meta_data.FieldMetaData(
        }
        first = false;
    public boolean equals(Database that) {
                iprot.readStructEnd();
        } catch (org.apache.thrift.TException te) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                        for (int _i115 = 0; _i115 < _map112.size; ++_i115) {
        }
                } else {
    public Database() {}
                } else {
                            }
    }
    public void validate() throws org.apache.thrift.TException {
            if (lastComparison != 0) {
                org.apache.thrift.protocol.TField schemeField;
    public @org.apache.thrift.annotation.Nullable java.lang.String locationUri; // required
    }
                return lastComparison;
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        java.io.Serializable,
    public void setDescriptionIsSet(boolean value) {
            case LOCATION_URI:
        if (this_present_description || that_present_description) {
    public int hashCode() {
            if (lastComparison != 0) {
                                    org.apache.thrift.protocol.TMap _map106 = iprot.readMapBegin();
         * if it is not found.
                    struct.setLocationUriIsSet(true);
                "locationUri",
    public void unsetParameters() {
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    public java.util.Map<java.lang.String, java.lang.String> getParameters() {
        }
            .getScheme();
    }
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
                    return DESCRIPTION;
            case PARAMETERS:
                    setName((java.lang.String) value);
        this.description = null;
                                    iprot.readMapEnd();
        org.apache.thrift.protocol.TType.MAP,
                break;
        tmpMap.put(
        }
        org.apache.thrift.protocol.TType.STRING,
    }
            this.locationUri = other.locationUri;
            if (struct.isSetDescription()) {
                struct.validate();
                    unsetParameters();
            this.name = other.name;
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                return lastComparison;
                            break;
        try {
        switch (field) {
                oprot.writeFieldEnd();
                            break;
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    }
                            break;
        }
        "description",
        this.parameters = null;
            prot.incrementRecursionDepth();
                    org.apache.thrift.protocol.TType.MAP,
        _Fields(short thriftId, java.lang.String fieldName) {
                                struct.setNameIsSet(true);
                        break;
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            org.apache.thrift.protocol.TType.STRING,
                return lastComparison;
        lastComparison = java.lang.Boolean.compare(isSetDescription(), other.isSetDescription());
        (short) 3
    @Override
                // check for required fields of primitive type, which can't be checked in the validate method
            sb.append(this.parameters);
            }
            )
        this.name = null;
                return getDescription();
        @org.apache.thrift.annotation.Nullable
        return this.description;
            }
        lastComparison = java.lang.Boolean.compare(isSetLocationUri(), other.isSetLocationUri());
        }
                iprot.readStructBegin();
        @Override
    }
    public Database(
        this.description = description;
                        java.lang.String _key113;
                return isSetName();
    @Override
        "parameters",
            return new DatabaseStandardScheme();
        return this;
                oprot.writeString(struct.description);
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        "name",
    public Database deepCopy() {
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                                    java.lang.String _key107;
            _Fields.NAME,
                        case 2: // DESCRIPTION
                        case 1: // NAME
            oprot.writeStructBegin(STRUCT_DESC);
                oprot.writeFieldBegin(NAME_FIELD_DESC);
    @org.apache.thrift.annotation.Nullable
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
                        case 4: // PARAMETERS
            new org.apache.thrift.meta_data.FieldMetaData(
        }
        } catch (org.apache.thrift.TException te) {
        org.apache.thrift.protocol.TType.STRING,
        this.parameters = parameters;
                }
 *  @generated
        this();
                                struct.setDescriptionIsSet(true);
        if (!value) {
                        @org.apache.thrift.annotation.Nullable
                                        struct.parameters.put(_key107, _val108);
        public static _Fields findByName(java.lang.String name) {
            if (!(this_present_locationUri && that_present_locationUri)) return false;
                }
    private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    unsetLocationUri();
    }
    public void unsetDescription() {
        switch (field) {
        int lastComparison = 0;
        }
                            org.apache.thrift.protocol.TType.STRING
            try {
                case 1: // NAME
    public void setNameIsSet(boolean value) {
        // check for required fields
    }
        this.description = null;
        boolean this_present_description = true && this.isSetDescription();
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
                            } else {
    }
        return this.name != null;
                if (incoming.get(2)) {
                oprot.writeString(struct.name);
            )
            java.util.Map<java.lang.String, java.lang.String> __this__parameters = new java.util.HashMap<
                    }
        }
                        );
        (short) 2
        PARAMETERS((short) 4, "parameters");
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.locationUri, other.locationUri);
            if (!this.locationUri.equals(that.locationUri)) return false;
                oprot.writeFieldEnd();
                byName.put(field.getFieldName(), field);
        } else {
                    oprot.writeMapEnd();
        this.locationUri = locationUri;
        if (!value) {
                }
            this.parameters = null;
        sb.append("parameters:");
            }
                    schemeField = iprot.readFieldBegin();
        this.name = name;
            if (!this.parameters.equals(that.parameters)) return false;
    }
                if (value == null) {
        if (isSetName()) {
    public boolean isSetName() {
            switch (fieldId) {
        @Override
            return byName.get(name);
        if (that == null) return false;
 */
                    oprot.writeI32(struct.parameters.size());
        // check for sub-struct validity
        try {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    public Database setParameters(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters) {
        if (this_present_name || that_present_name) {
}
                oprot.writeFieldEnd();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
            _Fields.DESCRIPTION,
        if (!value) {
                    }
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter111 : struct.parameters.entrySet()) {
            sb.append(this.locationUri);
        }
        } else {
        this.parameters = null;
                if (incoming.get(1)) {
        }
    public void clear() {
            if (struct.isSetName()) {
        if (!value) {
                }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);
                    setLocationUri((java.lang.String) value);
            }
                            break;
            case PARAMETERS:
            }
        }
        if (lastComparison != 0) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        boolean that_present_parameters = true && that.isSetParameters();
        lastComparison = java.lang.Boolean.compare(isSetName(), other.isSetName());
    );
                    {
                }
            return lastComparison;
                    }
        }
        if (isSetLocationUri()) hashCode = hashCode * 8191 + locationUri.hashCode();
        }
            }
        (short) 1
        return new Database(this);
                    return null;
        private final java.lang.String _fieldName;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
            case NAME:
        sb.append("description:");
        org.apache.thrift.protocol.TType.STRING,
            }
                return getParameters();
        }
    private static class DatabaseTupleScheme extends org.apache.thrift.scheme.TupleScheme<Database> {
    );
                {
                iprot.decrementRecursionDepth();
            _Fields.PARAMETERS,
                        @org.apache.thrift.annotation.Nullable
         * Find the _Fields constant that matches fieldId, throwing an exception
                if (value == null) {
            )
                optionals.set(3);
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
        static {
                        case 3: // LOCATION_URI
        java.lang.String locationUri,
        this.parameters = parameters;
     */
    }
        public void read(org.apache.thrift.protocol.TProtocol iprot, Database struct) throws org.apache.thrift.TException {
        this.name = name;
                "parameters",
                return getLocationUri();
        NAME((short) 1, "name"),
            }
     * Performs a deep copy on <i>other</i>.
                        }
            this.name = null;
        scheme(oprot).write(oprot, this);
        throw new java.lang.IllegalStateException();
        first = false;
            this.parameters = __this__parameters;
    public Database setLocationUri(@org.apache.thrift.annotation.Nullable java.lang.String locationUri) {
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new DatabaseTupleSchemeFactory();
                while (true) {
            }
            oprot.writeBitSet(optionals, 4);
    public _Fields fieldForId(int fieldId) {
            if (struct.isSetName()) {
            this.parameters = new java.util.HashMap<java.lang.String, java.lang.String>();
        tmpMap.put(
                } else {
        }
        org.apache.thrift.TBase<Database, Database._Fields>,
        }
                break;
                                struct.description = iprot.readString();
                    struct.description = iprot.readString();
            _Fields,
    implements
    }
