                            }
                } else {
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.location, other.location);
        if (isSetInputFormat()) {
            try {
            if (struct.isSetNumBuckets()) {
                optionals.set(2);
            case COMPRESSED:
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                return getCols();
        this.bucketCols = null;
        }
    private static final org.apache.thrift.protocol.TField COMPRESSED_FIELD_DESC = new org.apache.thrift.protocol.TField(
    }
                    unsetSortCols();
    @Override
        org.apache.thrift.protocol.TType.LIST,
        if (this.parameters == null) {
        if (other.isSetLocation()) {
            sb.append("null");
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                            } else {
            case PARAMETERS:
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.cols, other.cols);
    }
                if (value == null) {
/**
        return this.sortCols;
                    oprot.writeMapEnd();
                    struct.serdeInfo = new SerDeInfo();
        boolean that_present_outputFormat = true && that.isSetOutputFormat();
                            break;
        tmpMap.put(
                    setSortCols((java.util.List<Order>) value);
    }
    public int hashCode() {
    public java.lang.String getLocation() {
        return this;
                {
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
                } else {
                }
                if (value == null) {
                            break;
        }
            if (!this.sortCols.equals(that.sortCols)) return false;
                        _iter23.write(oprot);
                    struct.setBucketColsIsSet(true);
        this.sortCols = null;
    private static final org.apache.thrift.protocol.TField COLS_FIELD_DESC = new org.apache.thrift.protocol.TField(
                new org.apache.thrift.meta_data.ListMetaData(
                            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
            _Fields fields = findByThriftId(fieldId);
            }
    );
                                struct.inputFormat = iprot.readString();
        if (!value) {
                                struct.setBucketColsIsSet(true);
        this.inputFormat = inputFormat;
        if (!value) {
            }
        LOCATION((short) 2, "location"),
        java.lang.StringBuilder sb = new java.lang.StringBuilder("StorageDescriptor(");
        this.parameters = null;
            if (!(this_present_outputFormat && that_present_outputFormat)) return false;
        COMPRESSED((short) 5, "compressed"),
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sortCols, other.sortCols);
            if (!(this_present_cols && that_present_cols)) return false;
                }
    }
                        java.lang.String _key41;
                            org.apache.thrift.protocol.TType.STRING,
                    for (java.lang.String _iter28 : struct.bucketCols) {
                            struct.sortCols.add(_elem38);
        if (!first) sb.append(", ");
        this.inputFormat = null;
            )
    }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.bucketCols, other.bucketCols);
    }
                                struct.setSerdeInfoIsSet(true);
                }
            for (FieldSchema other_element : other.cols) {
        java.util.List<Order> sortCols,
                    setInputFormat((java.lang.String) value);
            case PARAMETERS:
        if (isSetBucketCols()) hashCode = hashCode * 8191 + bucketCols.hashCode();
        public short getThriftFieldId() {
                return lastComparison;
    }
        return this.outputFormat != null;
        "sortCols",
            }
        "serdeInfo",
                    oprot.writeListBegin(
                                    struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map19.size);
                        java.lang.String _elem35;
        boolean that_present_parameters = true && that.isSetParameters();
        }
                                {
                "numBuckets",
        public static _Fields findByThriftIdOrThrow(int fieldId) {
    }
        @Override
                return getSortCols();
package org.opensearch.plugin.hive.metastore;
        this.numBuckets = 0;
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            }
            sb.append("null");
                                    for (int _i15 = 0; _i15 < _list13.size; ++_i15) {
                }
                }
            new org.apache.thrift.meta_data.FieldMetaData(
    public java.util.Iterator<java.lang.String> getBucketColsIterator() {
            sb.append("null");
            case NUM_BUCKETS:
                                struct.setNumBucketsIsSet(true);
                return isSetOutputFormat();
            oprot.writeFieldBegin(COMPRESSED_FIELD_DESC);
                            struct.parameters.size()
    private static final org.apache.thrift.protocol.TField OUTPUT_FORMAT_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public void unsetNumBuckets() {
            this.sortCols = new java.util.ArrayList<Order>();
        }
        if (isSetLocation()) hashCode = hashCode * 8191 + location.hashCode();
                        _iter25.write(oprot);
        }
        this();
            }
        if (this.outputFormat == null) {
                struct.serdeInfo.write(oprot);
    /** Returns true if field location is set (has been assigned a value) and false otherwise */
        static {
                    unsetBucketCols();
                    unsetParameters();
            }
        if (isSetCompressed()) {
        return this.bucketCols;
            if (struct.isSetParameters()) {
        } else {
        }
    /** Returns true if field numBuckets is set (has been assigned a value) and false otherwise */
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __COMPRESSED_ISSET_ID, value);
        this.bucketCols.add(elem);
            return lastComparison;
                java.util.BitSet incoming = iprot.readBitSet(10);
                                struct.compressed = iprot.readBool();
                                    Order _elem17;
                if (value == null) {
        return this.serdeInfo != null;
        if (this_present_serdeInfo || that_present_serdeInfo) {
            new org.apache.thrift.meta_data.FieldMetaData(
    public void setSortColsIsSet(boolean value) {
                return lastComparison;
                            }
                    return null;
        return this;
    public StorageDescriptor deepCopy() {
            this.location = null;
                new org.apache.thrift.meta_data.ListMetaData(
    }
    /** Returns true if field parameters is set (has been assigned a value) and false otherwise */
                    schemeField = iprot.readFieldBegin();
    @Override
        this.serdeInfo = serdeInfo;
                            } else {
        }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
        }
    }
        setCompressedIsSet(false);
                if (value == null) {
    }
    }
                return lastComparison;
                case 8: // BUCKET_COLS
    public void addToSortCols(Order elem) {
        this.location = null;
        }
    @org.apache.thrift.annotation.Nullable
        this.sortCols = sortCols;
        if (this_present_compressed || that_present_compressed) {
 *  @generated
    private static final org.apache.thrift.protocol.TField NUM_BUCKETS_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
                    struct.location = iprot.readString();
                java.lang.String,
        if (isSetNumBuckets()) {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                oprot.writeFieldBegin(BUCKET_COLS_FIELD_DESC);
        if (!first) sb.append(", ");
    /** Returns true if field sortCols is set (has been assigned a value) and false otherwise */
        );
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            }
            this.inputFormat = null;
                    {
            if (lastComparison != 0) {
            }
            if (!(this_present_inputFormat && that_present_inputFormat)) return false;
        }
        this.location = location;
        return this.sortCols != null;
    @Override
    public int getNumBuckets() {
                if (incoming.get(8)) {
        hashCode = hashCode * 8191 + ((isSetBucketCols()) ? 131071 : 524287);
    @org.apache.thrift.annotation.Nullable
    @Override
        boolean this_present_bucketCols = true && this.isSetBucketCols();
    }
                oprot.writeString(struct.inputFormat);
                        for (int _i43 = 0; _i43 < _map40.size; ++_i43) {
    public StorageDescriptor(
                    return SORT_COLS;
                if (incoming.get(6)) {
            this.bucketCols = new java.util.ArrayList<java.lang.String>();
        if (this_present_sortCols || that_present_sortCols) {
    }
            _Fields.COMPRESSED,
                                        _elem17 = new Order();
        }
                case 1: // COLS
    @org.apache.thrift.annotation.Nullable
                        for (int _i39 = 0; _i39 < _list37.size; ++_i39) {
                                {
                        struct.bucketCols = new java.util.ArrayList<java.lang.String>(_list34.size);
                                struct.outputFormat = iprot.readString();
                                struct.setParametersIsSet(true);
                                }
    public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters; // required
                    }
        hashCode = hashCode * 8191 + numBuckets;
            }
    public boolean isCompressed() {
            oprot.writeFieldStop();
                        org.apache.thrift.protocol.TList _list34 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRING);
     * Performs a deep copy on <i>other</i>.
                        org.apache.thrift.protocol.TList _list31 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        this.cols = null;
                        oprot.writeString(_iter30.getKey());
        hashCode = hashCode * 8191 + ((isSetSerdeInfo()) ? 131071 : 524287);
                            _key41 = iprot.readString();
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        if (isSetCols()) {
                                        _key20 = iprot.readString();
                    setBucketCols((java.util.List<java.lang.String>) value);
                }
    // isset id assignments
                        @org.apache.thrift.annotation.Nullable
            case SERDE_INFO:
        } else {
    }
                oprot.writeFieldBegin(INPUT_FORMAT_FIELD_DESC);
            this.bucketCols = null;
        }
            case BUCKET_COLS:
        this.cols = cols;
                break;
        boolean that_present_sortCols = true && that.isSetSortCols();
        tmpMap.put(
        lastComparison = java.lang.Boolean.compare(isSetParameters(), other.isSetParameters());
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    /** Returns true if field cols is set (has been assigned a value) and false otherwise */
                            break;
                    }
        try {
    }
        this.location = location;
            if (!this.inputFormat.equals(that.inputFormat)) return false;
                        }
            case SORT_COLS:
        }
                                struct.setLocationIsSet(true);
                } else {
            _Fields.COLS,
     */
        (short) 8
        boolean this_present_outputFormat = true && this.isSetOutputFormat();
        }
            oprot.writeStructEnd();
    private static final int __COMPRESSED_ISSET_ID = 0;
                                    org.apache.thrift.protocol.TList _list10 = iprot.readListBegin();
        }
    public int getSortColsSize() {
    public @org.apache.thrift.annotation.Nullable java.lang.String location; // required
        );
 * Autogenerated by Thrift Compiler (0.23.0)
        lastComparison = java.lang.Boolean.compare(isSetLocation(), other.isSetLocation());
                } else {
    public void unsetSortCols() {
            }
                        case 3: // INPUT_FORMAT
                                    }
                        _iter27.write(oprot);
    public void putToParameters(java.lang.String key, java.lang.String val) {
    /** Returns true if field bucketCols is set (has been assigned a value) and false otherwise */
            oprot.writeStructBegin(STRUCT_DESC);
            if (lastComparison != 0) {
        setNumBucketsIsSet(true);
        first = false;
            if (!this.serdeInfo.equals(that.serdeInfo)) return false;
    ) {
                            _elem35 = iprot.readString();
    }
                            break;
        (short) 1
        if (this.location == null) {
        if (this.inputFormat == null) {
        setCompressedIsSet(true);
            sb.append(this.serdeInfo);
                    }
        if (other.isSetOutputFormat()) {
    /** Returns true if field inputFormat is set (has been assigned a value) and false otherwise */
    public boolean isSetLocation() {
                    {
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NUMBUCKETS_ISSET_ID, value);
        if (isSetParameters()) {
        this.cols = null;
                case 9: // SORT_COLS
        if (isSetInputFormat()) hashCode = hashCode * 8191 + inputFormat.hashCode();
        return this.numBuckets;
        return 0;
            case SORT_COLS:
                    oprot.writeListEnd();
                    return BUCKET_COLS;
            _thriftId = thriftId;
        if (isSetOutputFormat()) hashCode = hashCode * 8191 + outputFormat.hashCode();
                return getInputFormat();
                    }
            }
        this.bucketCols = bucketCols;
        return _Fields.findByThriftId(fieldId);
            this.cols = new java.util.ArrayList<FieldSchema>();
                                    java.lang.String _elem14;
                                    java.lang.String _key20;
        // check for required fields
            new org.apache.thrift.meta_data.FieldMetaData(
            case SORT_COLS:
                oprot.writeString(struct.location);
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        } catch (org.apache.thrift.TException te) {
                    org.apache.thrift.protocol.TType.MAP,
            oprot.writeI32(struct.numBuckets);
            return byName.get(name);
                new org.apache.thrift.meta_data.MapMetaData(
            java.util.Map<java.lang.String, java.lang.String> __this__parameters = new java.util.HashMap<
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
                        case 1: // COLS
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                }
                            } else {
                            } else {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            if (struct.isSetCompressed()) {
                "outputFormat",
        hashCode = hashCode * 8191 + ((isSetParameters()) ? 131071 : 524287);
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __COMPRESSED_ISSET_ID);
        }
            } finally {
        }
        public StorageDescriptorStandardScheme getScheme() {
            }
                    oprot.writeListEnd();
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        }
                } else {
                "bucketCols",
            }
            }
            return lastComparison;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        this.numBuckets = numBuckets;
                }
    );
    @org.apache.thrift.annotation.Nullable
                    );
    }
    public StorageDescriptor setSerdeInfo(@org.apache.thrift.annotation.Nullable SerDeInfo serdeInfo) {
                }
            }
            sb.append("null");
                        }
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
            )
            if (struct.isSetCols()) {
        if (!first) sb.append(", ");
                oprot.writeFieldEnd();
            return new StorageDescriptorStandardScheme();
            java.util.BitSet optionals = new java.util.BitSet();
        (short) 7
                                        struct.cols.add(_elem11);
                oprot.writeFieldEnd();
            case LOCATION:
        sb.append(")");
    }
            }
    private static final org.apache.thrift.protocol.TField LOCATION_FIELD_DESC = new org.apache.thrift.protocol.TField(
                if (value == null) {
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                        for (int _i33 = 0; _i33 < _list31.size; ++_i33) {
        this.numBuckets = numBuckets;
    public void addToBucketCols(java.lang.String elem) {
    public void setNumBucketsIsSet(boolean value) {
        lastComparison = java.lang.Boolean.compare(isSetSerdeInfo(), other.isSetSerdeInfo());
        }
            case COLS:
                break;
            }
                oprot.writeString(struct.location);
    public void setLocationIsSet(boolean value) {
            this.parameters = new java.util.HashMap<java.lang.String, java.lang.String>();
        }
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(StorageDescriptor.class, metaDataMap);
                            }
    }
            case LOCATION:
    @org.apache.thrift.annotation.Nullable
            if (struct.isSetSortCols()) {
    }
    public @org.apache.thrift.annotation.Nullable java.util.List<FieldSchema> cols; // required
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING),
        if (!first) sb.append(", ");
                return isSetCompressed();
        boolean compressed,
    implements
        }
    }
                return getParameters();
    @org.apache.thrift.annotation.Nullable
        return this.location != null;
            sb.append(this.cols);
        "cols",
            .getScheme();
                        );
        if (lastComparison != 0) {
            sb.append(this.parameters);
    );
                        @org.apache.thrift.annotation.Nullable
                    struct.setParametersIsSet(true);
        sb.append("outputFormat:");
    }
                if (value == null) {
        boolean this_present_numBuckets = true;
            oprot.writeFieldBegin(NUM_BUCKETS_FIELD_DESC);
        }
        );
        }
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        _Fields(short thriftId, java.lang.String fieldName) {
        __isset_bitfield = other.__isset_bitfield;
            this.serdeInfo = null;
        if (this.cols == null) {
                        }
            iprot.incrementRecursionDepth();
                        @org.apache.thrift.annotation.Nullable
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
                break;
        return (this.sortCols == null) ? 0 : this.sortCols.size();
                    return OUTPUT_FORMAT;
                                    for (int _i22 = 0; _i22 < _map19.size; ++_i22) {
        if (!value) {
                        break;
                org.apache.thrift.protocol.TField schemeField;
                                    FieldSchema _elem11;
                            org.apache.thrift.protocol.TType.STRING,
            case COLS:
        @Override
        if (other.isSetSerdeInfo()) {
    public boolean compressed; // required
                                struct.setColsIsSet(true);
                    return PARAMETERS;
    }
            if (struct.isSetLocation()) {
        this.compressed = compressed;
    @org.apache.thrift.annotation.Nullable
    @Override
                return isSetBucketCols();
        boolean that_present_inputFormat = true && that.isSetInputFormat();
        if (isSetCols()) hashCode = hashCode * 8191 + cols.hashCode();
                iprot.readStructEnd();
            if (!(this_present_numBuckets && that_present_numBuckets)) return false;
                if (incoming.get(2)) {
        lastComparison = java.lang.Boolean.compare(isSetSortCols(), other.isSetSortCols());
                    for (Order _iter29 : struct.sortCols) {
                struct.validate();
        throw new java.lang.IllegalStateException();
                case 4: // OUTPUT_FORMAT
                return lastComparison;
        return this.inputFormat;
            oprot.writeFieldEnd();
    private static final org.apache.thrift.protocol.TField BUCKET_COLS_FIELD_DESC = new org.apache.thrift.protocol.TField(
            this.inputFormat = other.inputFormat;
                    oprot.writeI32(struct.cols.size());
        if (this.parameters == null) {
        }
            if (struct.parameters != null) {
            if (lastComparison != 0) {
    public boolean isSetSortCols() {
    }
        public StorageDescriptorTupleScheme getScheme() {
    }
        "inputFormat",
            sb.append(this.outputFormat);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                    );
        private final short _thriftId;
                }
                    unsetNumBuckets();
            this.outputFormat = null;
    /** Returns true if field serdeInfo is set (has been assigned a value) and false otherwise */
            _Fields.SORT_COLS,
            struct.validate();
    public boolean isSetNumBuckets() {
    public SerDeInfo getSerdeInfo() {
        return this;
}
        java.util.Map<java.lang.String, java.lang.String> parameters
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
        if (lastComparison != 0) {
            }
        if (this.bucketCols == null) {
        if (!value) {
            _Fields.SERDE_INFO,
                                struct.numBuckets = iprot.readI32();
            case INPUT_FORMAT:
        }
                    oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.cols.size()));
                            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
         */
                    struct.setNumBucketsIsSet(true);
    }
    }
            case LOCATION:
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SerDeInfo.class)
            case COLS:
                oprot.writeString(struct.outputFormat);
            return getClass().getName().compareTo(other.getClass().getName());
        if (this.sortCols == null) {
            if (this.numBuckets != that.numBuckets) return false;
                    org.apache.thrift.protocol.TType.LIST,
    }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.serdeInfo, other.serdeInfo);
                        case 8: // BUCKET_COLS
        OUTPUT_FORMAT((short) 4, "outputFormat"),
                            } else {
            return _thriftId;
        tmpMap.put(
                        struct.cols = new java.util.ArrayList<FieldSchema>(_list31.size);
                    setParameters((java.util.Map<java.lang.String, java.lang.String>) value);
                optionals.set(6);
                            struct.parameters.put(_key41, _val42);
                            }
        if (isSetSortCols()) {
    public StorageDescriptor setOutputFormat(@org.apache.thrift.annotation.Nullable java.lang.String outputFormat) {
            case NUM_BUCKETS:
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameters, other.parameters);
                    new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    }
    );
                                    org.apache.thrift.protocol.TMap _map19 = iprot.readMapBegin();
                    struct.numBuckets = iprot.readI32();
            if (!(this_present_sortCols && that_present_sortCols)) return false;
    public @org.apache.thrift.annotation.Nullable java.lang.String outputFormat; // required
            case COMPRESSED:
    }
                oprot.writeI32(struct.numBuckets);
    private static class StorageDescriptorStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public void unsetLocation() {
    public java.util.List<java.lang.String> getBucketCols() {
    public @org.apache.thrift.annotation.Nullable java.util.List<Order> sortCols; // required
            }
        if (other.isSetCols()) {
        boolean this_present_sortCols = true && this.isSetSortCols();
                    oprot.writeI32(struct.parameters.size());
            sb.append("null");
            throw new java.lang.IllegalArgumentException();
                        oprot.writeString(_iter28);
        if (this_present_parameters || that_present_parameters) {
                        @org.apache.thrift.annotation.Nullable
        if (!first) sb.append(", ");
                {
    public java.util.Iterator<Order> getSortColsIterator() {
                        @org.apache.thrift.annotation.Nullable
    }
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new StorageDescriptorTupleSchemeFactory();
        first = false;
                    unsetOutputFormat();
        if (lastComparison != 0) {
    @Override
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                break;
    public void setOutputFormatIsSet(boolean value) {
                                        _elem14 = iprot.readString();
        return (this.cols == null) ? null : this.cols.iterator();
    public boolean equals(StorageDescriptor that) {
        }
                case 6: // NUM_BUCKETS
        return this;
            if (!(this_present_serdeInfo && that_present_serdeInfo)) return false;
                        new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.sortCols.size())
                }
            case PARAMETERS:
    }
                    struct.setCompressedIsSet(true);
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    public void setCompressedIsSet(boolean value) {
    public void unsetCols() {
            }
        hashCode = hashCode * 8191 + ((isSetLocation()) ? 131071 : 524287);
            sb.append(this.bucketCols);
                                    @org.apache.thrift.annotation.Nullable
                    oprot.writeI32(struct.sortCols.size());
            if (lastComparison != 0) {
                        new org.apache.thrift.protocol.TMap(
    @org.apache.thrift.annotation.Nullable
        if (this_present_inputFormat || that_present_inputFormat) {
        return this;
    }
                return lastComparison;
        lastComparison = java.lang.Boolean.compare(isSetOutputFormat(), other.isSetOutputFormat());
                "parameters",
        return (this.cols == null) ? 0 : this.cols.size();
        if (!first) sb.append(", ");
    public boolean isSetCompressed() {
    public void unsetBucketCols() {
        "location",
                            }
                __this__cols.add(new FieldSchema(other_element));
                                {
        );
                return isSetInputFormat();
            _Fields.LOCATION,
                                    struct.cols = new java.util.ArrayList<FieldSchema>(_list10.size);
            return lastComparison;
        hashCode = hashCode * 8191 + ((isSetSortCols()) ? 131071 : 524287);
        first = false;
                        struct.sortCols = new java.util.ArrayList<Order>(_list37.size);
                    oprot.writeI32(struct.bucketCols.size());
                }
                                        _elem17.read(iprot);
    }
        "outputFormat",
        @Override
        if (!first) sb.append(", ");
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    }
                        org.apache.thrift.protocol.TList _list37 = iprot.readListBegin(org.apache.thrift.protocol.TType.STRUCT);
        if (other.isSetBucketCols()) {
        java.lang.String location,
        if (this_present_numBuckets || that_present_numBuckets) {
        }
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("StorageDescriptor");
        } else {
        org.apache.thrift.protocol.TType.MAP,
    public boolean isSetBucketCols() {
            case BUCKET_COLS:
                java.lang.String>(other.parameters);
                {
    }
            }
                return isCompressed();
            if (struct.isSetOutputFormat()) {
        }
        throw new java.lang.IllegalStateException();
        /**
    public void clear() {
        boolean first = true;
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.BOOL)
        switch (field) {
                    for (Order _iter25 : struct.sortCols) {
            _Fields.OUTPUT_FORMAT,
        lastComparison = java.lang.Boolean.compare(isSetCompressed(), other.isSetCompressed());
            this.cols = null;
                return lastComparison;
                oprot.writeString(struct.inputFormat);
        } catch (org.apache.thrift.TException te) {
    public StorageDescriptor setCols(@org.apache.thrift.annotation.Nullable java.util.List<FieldSchema> cols) {
        tmpMap.put(
            if (lastComparison != 0) {
                            }
            }
        org.apache.thrift.protocol.TType.LIST,
            case COMPRESSED:
        if (!value) {
                            } else {
        org.apache.thrift.TBase<StorageDescriptor, StorageDescriptor._Fields>,
        if (other.isSetParameters()) {
        sb.append("location:");
            this.parameters = null;
                                struct.serdeInfo = new SerDeInfo();
                    org.apache.thrift.protocol.TType.LIST,
    }
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
        return this;
    }
            if (struct.isSetParameters()) {
        }
        tmpMap.put(
                new org.apache.thrift.meta_data.ListMetaData(
        COLS((short) 1, "cols"),
         * Find the _Fields constant that matches fieldId, throwing an exception
            return fields;
    public java.util.List<Order> getSortCols() {
        BUCKET_COLS((short) 8, "bucketCols"),
                            _val42 = iprot.readString();
    public int getBucketColsSize() {
        boolean that_present_compressed = true;
            )
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
            java.util.List<FieldSchema> __this__cols = new java.util.ArrayList<FieldSchema>(other.cols.size());
        }
            }
        }
                            org.apache.thrift.protocol.TType.STRING
    }
                            break;
        (short) 3
    }
                )
                }
        org.apache.thrift.protocol.TType.LIST,
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    public void setColsIsSet(boolean value) {
        return this.parameters != null;
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
                } else {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        public void read(org.apache.thrift.protocol.TProtocol prot, StorageDescriptor struct) throws org.apache.thrift.TException {
    }
        } else {
        public void read(org.apache.thrift.protocol.TProtocol iprot, StorageDescriptor struct) throws org.apache.thrift.TException {
        lastComparison = java.lang.Boolean.compare(isSetNumBuckets(), other.isSetNumBuckets());
        tmpMap.put(
        if (!first) sb.append(", ");
            throw new java.io.IOException(te);
                    oprot.writeMapBegin(
    }
                            _elem32 = new FieldSchema();
                return isSetParameters();
                }
                                        _val21 = iprot.readString();
        }
                return isSetSortCols();
            }
                return getLocation();
        }
                optionals.set(0);
    }
        /**
                }
        this.parameters = parameters;
                    return NUM_BUCKETS;
                case 7: // SERDE_INFO
        if (this.sortCols == null) {
        tmpMap.put(
    @Override
            if (lastComparison != 0) {
        this.compressed = false;
                    iprot.readFieldEnd();
                        case 5: // COMPRESSED
        setCompressedIsSet(true);
        if (isSetParameters()) hashCode = hashCode * 8191 + parameters.hashCode();
            case INPUT_FORMAT:
    public void unsetParameters() {
                    }
        boolean that_present_serdeInfo = true && that.isSetSerdeInfo();
        if (!first) sb.append(", ");
    private static class StorageDescriptorTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        if (lastComparison != 0) {
                    struct.compressed = iprot.readBool();
        }
    public void unsetSerdeInfo() {
                oprot.writeFieldBegin(PARAMETERS_FIELD_DESC);
    public void setSerdeInfoIsSet(boolean value) {
    private static class StorageDescriptorStandardScheme extends org.apache.thrift.scheme.StandardScheme<StorageDescriptor> {
                        org.apache.thrift.protocol.TMap _map40 = iprot.readMapBegin(
        );
                if (value == null) {
                    );
    );
                        oprot.writeString(_iter26.getValue());
        }
                optionals.set(3);
        first = false;
                                    }
                oprot.writeFieldEnd();
    }
        @Override
            _fieldName = fieldName;
    }
            if (struct.isSetSerdeInfo()) {
    public boolean isSetInputFormat() {
        }
            )
            if (!(this_present_parameters && that_present_parameters)) return false;
            case SERDE_INFO:
    public StorageDescriptor(StorageDescriptor other) {
                        java.lang.String _val42;
                oprot.writeFieldEnd();
            case BUCKET_COLS:
        hashCode = hashCode * 8191 + ((isSetCols()) ? 131071 : 524287);
                    struct.inputFormat = iprot.readString();
                        default:
        }
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter30 : struct.parameters.entrySet()) {
        org.apache.thrift.protocol.TType.STRING,
        first = false;
        sb.append("parameters:");
                            org.apache.thrift.protocol.TType.STRING,
    }
        }
                    struct.setLocationIsSet(true);
            if (lastComparison != 0) {
        SERDE_INFO((short) 7, "serdeInfo"),
        public static _Fields findByThriftId(int fieldId) {
    }
                            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
            )
                                    }
    }
                {
        sb.append("cols:");
                        }
    }
                }
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
                "cols",
    public void setParametersIsSet(boolean value) {
                        )
    public @org.apache.thrift.annotation.Nullable SerDeInfo serdeInfo; // required
        } else {
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
            java.util.List<Order> __this__sortCols = new java.util.ArrayList<Order>(other.sortCols.size());
    }
                case 10: // PARAMETERS
            if (struct.isSetSerdeInfo()) {
        this.cols = cols;
                                    iprot.readMapEnd();
    }
            if (!(this_present_bucketCols && that_present_bucketCols)) return false;
                )
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
                            }
            if (struct.isSetInputFormat()) {
        );
            sb.append(this.inputFormat);
    public java.util.List<FieldSchema> getCols() {
            if (struct.isSetBucketCols()) {
    static {
        return this.bucketCols != null;
 *
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
                                struct.setInputFormatIsSet(true);
    }
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.inputFormat, other.inputFormat);
            this.sortCols = null;
        public void write(org.apache.thrift.protocol.TProtocol oprot, StorageDescriptor struct) throws org.apache.thrift.TException {
        boolean this_present_serdeInfo = true && this.isSetSerdeInfo();
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.numBuckets, other.numBuckets);
        return (this.bucketCols == null) ? 0 : this.bucketCols.size();
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        }
            }
        @Override
            _Fields.BUCKET_COLS,
    }
        }
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __COMPRESSED_ISSET_ID);
 */
    }
                    }
            _Fields,
                }
        if (lastComparison != 0) {
                default:
        sb.append("inputFormat:");
        );
            sb.append("null");
            new org.apache.thrift.meta_data.FieldMetaData(
                // check for required fields of primitive type, which can't be checked in the validate method
        }
        if (isSetBucketCols()) {
                            break;
        if (isSetSerdeInfo()) hashCode = hashCode * 8191 + serdeInfo.hashCode();
            )
        if (lastComparison != 0) {
                oprot.writeFieldBegin(OUTPUT_FORMAT_FIELD_DESC);
        boolean this_present_location = true && this.isSetLocation();
                return lastComparison;
    }
        this.sortCols.add(elem);
        SORT_COLS((short) 9, "sortCols"),
    @org.apache.thrift.annotation.Nullable
        return new StorageDescriptor(this);
        return this.location;
                    return COMPRESSED;
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            case OUTPUT_FORMAT:
                    unsetLocation();
    }
    private static final int __NUMBUCKETS_ISSET_ID = 1;
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
                            }
        java.lang.String inputFormat,
            } finally {
            return new StorageDescriptorTupleScheme();
        org.apache.thrift.protocol.TType.STRING,
                oprot.writeFieldEnd();
        this.serdeInfo = null;
            if (!this.bucketCols.equals(that.bucketCols)) return false;
            new org.apache.thrift.meta_data.FieldMetaData(
            }
    @org.apache.thrift.annotation.Nullable
    public java.util.Map<java.lang.String, java.lang.String> getParameters() {
        }
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
    /** Returns true if field compressed is set (has been assigned a value) and false otherwise */
        "parameters",
        }
                    setCompressed((java.lang.Boolean) value);
                __this__sortCols.add(new Order(other_element));
            if (struct.sortCols != null) {
            oprot.writeBool(struct.compressed);
            sb.append(this.location);
        );
                                    @org.apache.thrift.annotation.Nullable
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        }
                oprot.writeFieldBegin(SORT_COLS_FIELD_DESC);
        first = false;
                                struct.location = iprot.readString();
        if (isSetSortCols()) hashCode = hashCode * 8191 + sortCols.hashCode();
    public StorageDescriptor setParameters(
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new StorageDescriptorStandardSchemeFactory();
        this.outputFormat = outputFormat;
        boolean that_present_location = true && that.isSetLocation();
            )
                break;
            try {
    }
            for (Order other_element : other.sortCols) {
    private static final org.apache.thrift.protocol.TField INPUT_FORMAT_FIELD_DESC = new org.apache.thrift.protocol.TField(
        }
        }
                                        _elem11 = new FieldSchema();
        if (that instanceof StorageDescriptor) return this.equals((StorageDescriptor) that);
    );
            return lastComparison;
         */
                return lastComparison;
                    }
        }
            }
    public java.lang.Object getFieldValue(_Fields field) {
                "location",
        java.util.List<FieldSchema> cols,
            if (lastComparison != 0) {
        (short) 5
                prot.decrementRecursionDepth();
        }
        (short) 4
                                        struct.parameters.put(_key20, _val21);
                    for (FieldSchema _iter23 : struct.cols) {
        hashCode = hashCode * 8191 + ((isSetInputFormat()) ? 131071 : 524287);
                            }
        int hashCode = 1;
        this.inputFormat = inputFormat;
                {
    public int compareTo(StorageDescriptor other) {
    }
        return false;
        this.bucketCols = null;
        if (other.isSetSortCols()) {
                    switch (schemeField.id) {
        } else {
                return getSerdeInfo();
        "compressed",
        NUM_BUCKETS((short) 6, "numBuckets"),
    }
        if (serdeInfo != null) {
    public boolean isSetParameters() {
        org.apache.thrift.protocol.TType.STRUCT,
            if (this.compressed != that.compressed) return false;
            if (struct.bucketCols != null) {
                        case 9: // SORT_COLS
                if (value == null) {
                case 3: // INPUT_FORMAT
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, Order.class)
                    setOutputFormat((java.lang.String) value);
                        for (int _i36 = 0; _i36 < _list34.size; ++_i36) {
            return lastComparison;
        /**
                                    org.apache.thrift.protocol.TList _list13 = iprot.readListBegin();
            __isset_bitfield = 0;
                    }
        first = false;
                }
        tmpMap.put(
        public void write(org.apache.thrift.protocol.TProtocol prot, StorageDescriptor struct) throws org.apache.thrift.TException {
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        org.apache.thrift.protocol.TType.BOOL,
    );
        sb.append(this.numBuckets);
                            } else {
            )
            this.sortCols = __this__sortCols;
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.compressed, other.compressed);
        if (this_present_outputFormat || that_present_outputFormat) {
    ) {
                if (incoming.get(3)) {
            case INPUT_FORMAT:
        this.sortCols = null;
        setNumBucketsIsSet(false);
                    return SERDE_INFO;
        java.lang.String outputFormat,
    }
            return lastComparison;
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    }
    }
                    struct.setSerdeInfoIsSet(true);
        }
                if (incoming.get(0)) {
                            } else {
                }
                if (incoming.get(7)) {
                                    }
    private static final org.apache.thrift.protocol.TField SERDE_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField(
    public int getColsSize() {
                                    for (int _i12 = 0; _i12 < _list10.size; ++_i12) {
                    struct.setColsIsSet(true);
    private byte __isset_bitfield = 0;
        sb.append("serdeInfo:");
    public StorageDescriptor setSortCols(@org.apache.thrift.annotation.Nullable java.util.List<Order> sortCols) {
            if (struct.isSetOutputFormat()) {
    public @org.apache.thrift.annotation.Nullable java.lang.String inputFormat; // required
        if (other.isSetInputFormat()) {
        this.parameters = parameters;
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            return _fieldName;
        if (this == that) return true;
                break;
        boolean this_present_inputFormat = true && this.isSetInputFormat();
            }
        @Override
                {
    private static final org.apache.thrift.protocol.TField SORT_COLS_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    setCols((java.util.List<FieldSchema>) value);
        this.outputFormat = outputFormat;
        if (isSetOutputFormat()) {
            }
                {
            this.parameters = __this__parameters;
    }
                optionals.set(5);
        }
                    return COLS;
    public boolean equals(java.lang.Object that) {
                oprot.writeBool(struct.compressed);
        return this.cols != null;
        this.compressed = other.compressed;
    private static class StorageDescriptorTupleScheme extends org.apache.thrift.scheme.TupleScheme<StorageDescriptor> {
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        boolean that_present_numBuckets = true;
                            }
            if (struct.location != null) {
        if (!value) {
                                    @org.apache.thrift.annotation.Nullable
        return hashCode;
        if (!value) {
                    struct.setOutputFormatIsSet(true);
            )
    public java.lang.String getInputFormat() {
                        case 7: // SERDE_INFO
        if (lastComparison != 0) {
        if (!getClass().equals(other.getClass())) {
        private final java.lang.String _fieldName;
                        oprot.writeString(_iter26.getKey());
                    unsetSerdeInfo();
        boolean that_present_bucketCols = true && that.isSetBucketCols();
            }
    public StorageDescriptor setCompressed(boolean compressed) {
                                        _elem11.read(iprot);
        boolean this_present_cols = true && this.isSetCols();
            if (struct.isSetCols()) {
                        case 2: // LOCATION
            if (!(this_present_compressed && that_present_compressed)) return false;
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                            break;
                    oprot.writeListEnd();
        if (isSetLocation()) {
                return getNumBuckets();
                }
            _Fields.PARAMETERS,
                            } else {
                            struct.bucketCols.add(_elem35);
        if (that == null) return false;
                )
            serdeInfo.validate();
        return (this.parameters == null) ? 0 : this.parameters.size();
            oprot.writeFieldEnd();
        sb.append("bucketCols:");
        }
                    }
        return this.outputFormat;
                return lastComparison;
                oprot.writeFieldBegin(COLS_FIELD_DESC);
                                    java.lang.String _val21;
        first = false;
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    public void addToCols(FieldSchema elem) {
        if (lastComparison != 0) {
                return isSetNumBuckets();
            case OUTPUT_FORMAT:
        }
            throw new java.io.IOException(te);
        hashCode = hashCode * 8191 + ((isSetOutputFormat()) ? 131071 : 524287);
    }
                org.apache.thrift.TFieldRequirementType.DEFAULT,
                    }
                    }
                case 2: // LOCATION
         * if it is not found.
                {
        first = false;
        }
            if (struct.isSetNumBuckets()) {
                    unsetInputFormat();
                            _elem32.read(iprot);
            if (struct.outputFormat != null) {
                org.apache.thrift.TFieldRequirementType.DEFAULT,
    );
                }
    /**
            case SERDE_INFO:
        return this;
                return isSetCols();
                        Order _elem38;
        this.outputFormat = null;
                } else {
    public StorageDescriptor setInputFormat(@org.apache.thrift.annotation.Nullable java.lang.String inputFormat) {
        }
            java.util.List<java.lang.String> __this__bucketCols = new java.util.ArrayList<java.lang.String>(other.bucketCols);
            case OUTPUT_FORMAT:
                oprot.writeFieldBegin(LOCATION_FIELD_DESC);
        @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String, java.lang.String> parameters
    public java.util.Iterator<FieldSchema> getColsIterator() {
        return this.inputFormat != null;
            if (!(this_present_location && that_present_location)) return false;
        if (isSetSerdeInfo()) {
                    {
                    struct.serdeInfo.read(iprot);
    }
                oprot.writeFieldEnd();
            return lastComparison;
    public StorageDescriptor setLocation(@org.apache.thrift.annotation.Nullable java.lang.String location) {
            _Fields.INPUT_FORMAT,
        if (this_present_location || that_present_location) {
    @org.apache.thrift.annotation.Nullable
                        _iter29.write(oprot);
        if (this.serdeInfo == null) {
    public void unsetOutputFormat() {
        this.sortCols = sortCols;
                if (incoming.get(1)) {
        tmpMap.put(
                                    iprot.readListEnd();
        hashCode = hashCode * 8191 + ((compressed) ? 131071 : 524287);
            }
        switch (field) {
        return this;
    }
                                struct.setSortColsIsSet(true);
            }
    }
                } else {
                optionals.set(1);
    @org.apache.thrift.annotation.Nullable
        this.bucketCols = bucketCols;
            if (struct.cols != null) {
                                struct.serdeInfo.read(iprot);
        }
        this.cols.add(elem);
            }
        this.serdeInfo = null;
        "bucketCols",
                            break;
                )
    }
            return lastComparison;
                optionals.set(8);
                if (incoming.get(4)) {
        lastComparison = java.lang.Boolean.compare(isSetInputFormat(), other.isSetInputFormat());
                        FieldSchema _elem32;
        }
    public boolean isSetSerdeInfo() {
                optionals.set(7);
                                struct.setOutputFormatIsSet(true);
            }
    }
            new org.apache.thrift.meta_data.FieldMetaData(
                return lastComparison;
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NUMBUCKETS_ISSET_ID);
                    }
        return (this.bucketCols == null) ? null : this.bucketCols.iterator();
                }
            new org.apache.thrift.meta_data.FieldMetaData(
        return this;
    }
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NUMBUCKETS_ISSET_ID);
    public void validate() throws org.apache.thrift.TException {
                }
        int numBuckets,
            if (!this.cols.equals(that.cols)) return false;
                            if (schemeField.type == org.apache.thrift.protocol.TType.BOOL) {
                        oprot.writeString(_iter30.getValue());
                    org.apache.thrift.protocol.TType.LIST,
    }
    @org.apache.thrift.annotation.Nullable
            return lastComparison;
            }
                break;
                                }
                            break;
    }
                            } else {
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                            _elem38 = new Order();
                break;
            return lastComparison;
        return (this.sortCols == null) ? null : this.sortCols.iterator();
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
        return this.parameters;
        int lastComparison = 0;
            }
                    for (java.lang.String _iter24 : struct.bucketCols) {
        sb.append("sortCols:");
    public StorageDescriptor setNumBuckets(int numBuckets) {
                "compressed",
    );
                            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
            this.serdeInfo = new SerDeInfo(other.serdeInfo);
                                    for (int _i18 = 0; _i18 < _list16.size; ++_i18) {
    public boolean isSet(_Fields field) {
                iprot.readStructBegin();
    public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> bucketCols; // required
         * Find the _Fields constant that matches fieldId, or null if its not found.
        );
                    unsetCols();
            this.location = other.location;
        first = false;
        sb.append("numBuckets:");
            if (!this.location.equals(that.location)) return false;
    }
        }
        sb.append(this.compressed);
        INPUT_FORMAT((short) 3, "inputFormat"),
            }
        }
            )
                    return LOCATION;
        public static _Fields findByName(java.lang.String name) {
            if (struct.isSetBucketCols()) {
                    oprot.writeListBegin(
                }
    /** Returns true if field outputFormat is set (has been assigned a value) and false otherwise */
        org.apache.thrift.protocol.TType.STRING,
        }
        this.serdeInfo = serdeInfo;
                    struct.setInputFormatIsSet(true);
        java.io.Serializable,
    public java.lang.String toString() {
                    }
                }
                oprot.writeFieldEnd();
                byName.put(field.getFieldName(), field);
        }
            if (!this.outputFormat.equals(that.outputFormat)) return false;
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
            if (lastComparison != 0) {
        @Override
        @org.apache.thrift.annotation.Nullable
        }
            case NUM_BUCKETS:
    public void setInputFormatIsSet(boolean value) {
                return isSetSerdeInfo();
        switch (field) {
        }
    }
                if (value == null) {
    }
    public StorageDescriptor() {}
        "numBuckets",
    public void setBucketColsIsSet(boolean value) {
    public _Fields fieldForId(int fieldId) {
        return this.cols;
                            struct.cols.add(_elem32);
        SerDeInfo serdeInfo,
    @Override
            new org.apache.thrift.meta_data.FieldMetaData(
            }
                                struct.setCompressedIsSet(true);
    }
        boolean this_present_parameters = true && this.isSetParameters();
        if (this.cols == null) {
                optionals.set(9);
        java.util.List<java.lang.String> bucketCols,
        sb.append("compressed:");
                }
                "serdeInfo",
            this.cols = __this__cols;
    public void unsetInputFormat() {
        @org.apache.thrift.annotation.Nullable
                    {
    public boolean isSetCols() {
        return sb.toString();
                if (value == null) {
        if (this.bucketCols == null) {
            sb.append("null");
        } else {
            if (!this.parameters.equals(that.parameters)) return false;
            }
                        new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRING, struct.bucketCols.size())
                    new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, FieldSchema.class)
        (short) 9
            }
        PARAMETERS((short) 10, "parameters");
                    setLocation((java.lang.String) value);
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                while (true) {
                        case 4: // OUTPUT_FORMAT
        return true;
    @Override
                    return INPUT_FORMAT;
                    struct.setSortColsIsSet(true);
                } else {
        this.inputFormat = null;
         */
                oprot.writeFieldEnd();
            _Fields.NUM_BUCKETS,
    private static final org.apache.thrift.protocol.TField PARAMETERS_FIELD_DESC = new org.apache.thrift.protocol.TField(
                    struct.outputFormat = iprot.readString();
    }
        }
                    for (java.util.Map.Entry<java.lang.String, java.lang.String> _iter26 : struct.parameters.entrySet()) {
            this.outputFormat = other.outputFormat;
        Comparable<StorageDescriptor> {
                return getBucketCols();
            switch (fieldId) {
        }
                        oprot.writeString(_iter24);
                                }
                case 5: // COMPRESSED
        @Override
                                }
                if (incoming.get(5)) {
            if (struct.isSetLocation()) {
    public boolean isSetOutputFormat() {
        return this;
                    for (FieldSchema _iter27 : struct.cols) {
            new org.apache.thrift.meta_data.FieldMetaData(
                break;
                } else {
                "inputFormat",
    }
    public StorageDescriptor setBucketCols(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.String> bucketCols) {
        }
        scheme(iprot).read(iprot, this);
        public java.lang.String getFieldName() {
    }
        (short) 2
                                    struct.bucketCols = new java.util.ArrayList<java.lang.String>(_list13.size);
            if (struct.inputFormat != null) {
                                    iprot.readListEnd();
         * Find the _Fields constant that matches name, or null if its not found.
                return getOutputFormat();
        }
        }
        return this.compressed;
    public java.lang.String getOutputFormat() {
            }
    }
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        this.location = null;
        lastComparison = java.lang.Boolean.compare(isSetBucketCols(), other.isSetBucketCols());
        if (this_present_cols || that_present_cols) {
                    setNumBuckets((java.lang.Integer) value);
                                    @org.apache.thrift.annotation.Nullable
    public int numBuckets; // required
            oprot.writeBitSet(optionals, 10);
        try {
                                    iprot.readListEnd();
                        case 6: // NUM_BUCKETS
                oprot.writeFieldBegin(SERDE_INFO_FIELD_DESC);
                        case 10: // PARAMETERS
        this.compressed = compressed;
        }
        }
                    unsetCompressed();
                return isSetLocation();
        (short) 10
    }
                                    struct.sortCols = new java.util.ArrayList<Order>(_list16.size);
                }
                    setSerdeInfo((SerDeInfo) value);
                "sortCols",
        boolean this_present_compressed = true;
        if (field == null) {
        this.parameters.put(key, val);
        tmpMap.put(
        }
        lastComparison = java.lang.Boolean.compare(isSetCols(), other.isSetCols());
                }
            this.bucketCols = __this__bucketCols;
        setNumBucketsIsSet(true);
                oprot.writeString(struct.outputFormat);
                iprot.decrementRecursionDepth();
    );
        (short) 6
        org.apache.thrift.protocol.TType.I32,
    }
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
    @Override
        } else {
    }
        scheme(oprot).write(oprot, this);
        this.parameters = null;
            new org.apache.thrift.meta_data.FieldMetaData(
        this.numBuckets = other.numBuckets;
                }
        }
        return this.serdeInfo;
        this.outputFormat = null;
            }
        );
                if (incoming.get(9)) {
        if (lastComparison != 0) {
            }
            sb.append("null");
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
        Cloneable,
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.outputFormat, other.outputFormat);
        // check for sub-struct validity
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    public void unsetCompressed() {
            if (lastComparison != 0) {
        if (this_present_bucketCols || that_present_bucketCols) {
        boolean that_present_cols = true && that.isSetCols();
                            _elem38.read(iprot);
    public int getParametersSize() {
        }
    @Override
            if (struct.serdeInfo != null) {
    }
    }
        }
            prot.incrementRecursionDepth();
                                        struct.sortCols.add(_elem17);
                                    @org.apache.thrift.annotation.Nullable
            if (struct.isSetCompressed()) {
                break;
            if (struct.isSetSortCols()) {
        }
            }
                struct.serdeInfo.write(oprot);
            if (struct.isSetInputFormat()) {
                                {
public class StorageDescriptor
            sb.append(this.sortCols);
                    }
    @Override
                                    org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
        }
                                        struct.bucketCols.add(_elem14);
        if (lastComparison != 0) {
        }
        if (!value) {
                            break;
                optionals.set(4);
                        struct.parameters = new java.util.HashMap<java.lang.String, java.lang.String>(2 * _map40.size);
