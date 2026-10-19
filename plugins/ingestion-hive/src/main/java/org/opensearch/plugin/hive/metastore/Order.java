    }
            return fields;
         */
            new org.apache.thrift.meta_data.FieldMetaData(
    public Order deepCopy() {
            sb.append("null");
                oprot.writeI32(struct.order);
            throw new java.io.IOException(te);
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
    private static final org.apache.thrift.protocol.TField COL_FIELD_DESC = new org.apache.thrift.protocol.TField(
            case ORDER:
                    switch (schemeField.id) {
            try {
                if (value == null) {
    }
         * Find the _Fields constant that matches name, or null if its not found.
            // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        if (!value) {
        public java.lang.String getFieldName() {
    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    }
                    unsetOrder();
    private static final int __ORDER_ISSET_ID = 0;
        /**
    public Order(Order other) {
                } else {
            if (struct.col != null) {
                            } else {
    }
                iprot.decrementRecursionDepth();
            return _fieldName;
    @Override
        @Override
                byName.put(field.getFieldName(), field);
                case 2: // ORDER
    public boolean equals(Order that) {
        this.col = null;
    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
            _thriftId = thriftId;
                "col",
        }
    /** Returns true if field order is set (has been assigned a value) and false otherwise */
public class Order implements org.apache.thrift.TBase<Order, Order._Fields>, java.io.Serializable, Cloneable, Comparable<Order> {
    }
    @Override
                org.apache.thrift.TFieldRequirementType.DEFAULT,
        public OrderTupleScheme getScheme() {
            oprot.writeFieldBegin(ORDER_FIELD_DESC);
            if (struct.isSetCol()) {
                    struct.col = iprot.readString();
                if (incoming.get(0)) {
    }
            if (struct.isSetOrder()) {
        this();
        }
                oprot.writeFieldEnd();
            iprot.incrementRecursionDepth();
            switch (fieldId) {
    }
        tmpMap.put(
            this.col = null;
    public boolean isSetCol() {
        }
            }
        first = false;
        switch (field) {
    }
        if (this_present_col || that_present_col) {
        switch (field) {
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new OrderTupleSchemeFactory();
            if (struct.isSetOrder()) {
        @Override
            prot.incrementRecursionDepth();
            }
            }
        this.col = col;
    public Order setOrder(int order) {
    }
/**
 *
    // isset id assignments
    }
    }
    @Override
        private final short _thriftId;
        public void write(org.apache.thrift.protocol.TProtocol prot, Order struct) throws org.apache.thrift.TException {
        setOrderIsSet(true);
            .getScheme();
        throw new java.lang.IllegalStateException();
    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
            oprot.writeStructEnd();
            if (this.order != that.order) return false;
        this.order = order;
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.col, other.col);
        ORDER((short) 2, "order");
        this.order = other.order;
        boolean first = true;
        lastComparison = java.lang.Boolean.compare(isSetCol(), other.isSetCol());
        metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
            }
    private static class OrderStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
        }
        return this.order;
                    struct.setOrderIsSet(true);
        hashCode = hashCode * 8191 + ((isSetCol()) ? 131071 : 524287);
            for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
    @Override
    public _Fields fieldForId(int fieldId) {
                            } else {
    public void setColIsSet(boolean value) {
        sb.append(this.order);
            write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
        return _Fields.findByThriftId(fieldId);
            _Fields.COL,
        return this;
        public void read(org.apache.thrift.protocol.TProtocol iprot, Order struct) throws org.apache.thrift.TException {
        return sb.toString();
    public Order setCol(@org.apache.thrift.annotation.Nullable java.lang.String col) {
        } catch (org.apache.thrift.TException te) {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Order");
            __isset_bitfield = 0;
        first = false;
    private static final org.apache.thrift.protocol.TField ORDER_FIELD_DESC = new org.apache.thrift.protocol.TField(
        return this;
    }
        }
        boolean this_present_order = true;
            oprot.writeBitSet(optionals, 2);
    public Order(java.lang.String col, int order) {
    }
            throw new java.io.IOException(te);
            org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
            return new OrderStandardScheme();
@SuppressWarnings({ "cast", "rawtypes", "serial", "unchecked", "unused" })
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
                // check for required fields of primitive type, which can't be checked in the validate method
            )
    }
            return byName.get(name);
        public void read(org.apache.thrift.protocol.TProtocol prot, Order struct) throws org.apache.thrift.TException {
    public boolean equals(java.lang.Object that) {
        boolean that_present_order = true;
                case 1: // COL
        if (isSetCol()) {
        }
        }
                optionals.set(0);
    }
        static {
                    struct.setColIsSet(true);
                org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        }
        __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ORDER_ISSET_ID, value);
    public java.lang.String getCol() {
        sb.append("col:");
            )
            _Fields fields = findByThriftId(fieldId);
    @Override
        );
        int lastComparison = 0;
            return _thriftId;
        } catch (org.apache.thrift.TException te) {
                            }
        COL((short) 1, "col"),
        /**
        }
        }
        public OrderStandardScheme getScheme() {
                    schemeField = iprot.readFieldBegin();
        return this.col != null;
            return getClass().getName().compareTo(other.getClass().getName());
        (short) 1
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            _Fields.ORDER,
            case COL:
        }
    }
                break;
        switch (field) {
        @Override
    );
        if (this_present_order || that_present_order) {
    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new OrderStandardSchemeFactory();
    private static class OrderTupleScheme extends org.apache.thrift.scheme.TupleScheme<Order> {
        _Fields(short thriftId, java.lang.String fieldName) {
    /** Returns true if field col is set (has been assigned a value) and false otherwise */
    public void unsetOrder() {
        private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();
            if (struct.isSetCol()) {
    }
                }
                    setOrder((java.lang.Integer) value);
        }
        public static _Fields findByThriftId(int fieldId) {
        @org.apache.thrift.annotation.Nullable
            lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.order, other.order);
        }
        private final java.lang.String _fieldName;
        this.col = col;
    public int order; // required
        scheme(iprot).read(iprot, this);
         * Find the _Fields constant that matches fieldId, or null if its not found.
    }
            oprot.writeStructBegin(STRUCT_DESC);
                                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
    }
    public java.lang.Object getFieldValue(_Fields field) {
        }
        }
    }
    }
        }
        "col",
        if (lastComparison != 0) {
                return lastComparison;
        @Override
                        case 1: // COL
        }
        }
        org.apache.thrift.protocol.TType.I32,
            if (lastComparison != 0) {
            org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
    }
                        case 2: // ORDER
        java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<
            }
    @org.apache.thrift.annotation.Nullable
            case ORDER:
            oprot.writeI32(struct.order);
        int hashCode = 1;
        } else {
    @org.apache.thrift.annotation.Nullable
            return lastComparison;
    public void unsetCol() {
        @Override
        return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY)
            return new OrderTupleScheme();
            }
                    struct.order = iprot.readI32();
                    iprot.readFieldEnd();
    public boolean isSet(_Fields field) {
            }
    @Override
            if (!(this_present_order && that_present_order)) return false;
        }
                            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
 */
         */
    );
    }
        if (field == null) {
            throw new java.lang.IllegalArgumentException();
                return getOrder();
            oprot.writeFieldEnd();
                org.apache.thrift.TFieldRequirementType.DEFAULT,
            java.util.BitSet optionals = new java.util.BitSet();
    }
        if (!getClass().equals(other.getClass())) {
                return getCol();
        if (this == that) return true;
    public int hashCode() {
        }
                                struct.setOrderIsSet(true);
        scheme(oprot).write(oprot, this);
        tmpMap.put(
        // check for required fields
            case COL:
    @org.apache.thrift.annotation.Nullable
                        break;
            return lastComparison;
    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
        if (!first) sb.append(", ");
                        default:
        @Override
        if (that instanceof Order) return this.equals((Order) that);
                            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
            read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
 *  @generated
            new org.apache.thrift.meta_data.FieldMetaData(
        this.order = order;
        public void write(org.apache.thrift.protocol.TProtocol oprot, Order struct) throws org.apache.thrift.TException {
        }
        if (lastComparison != 0) {
                default:
         * if it is not found.
    static {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Order(");
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
        @Override
    }
        /**
            }
                return isSetCol();
    }
    public boolean isSetOrder() {
        setOrderIsSet(true);
                    setCol((java.lang.String) value);
    }
                    return COL;
                new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)
    public int getOrder() {
            if (lastComparison != 0) {
    @Override
                }
        }
    }
            this.col = other.col;
                iprot.readStructBegin();
        }
            }
    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
        }
        if (isSetOrder()) {
            case COL:
    @Override
     */
        boolean this_present_col = true && this.isSetCol();
    public java.lang.String toString() {
    private static class OrderTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
                            break;
         * Find the _Fields constant that matches fieldId, throwing an exception
        return false;
                    }
        }
                break;
        sb.append("order:");
                            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
                optionals.set(1);
                    unsetCol();
        return new Order(this);
        __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ORDER_ISSET_ID);
                                struct.col = iprot.readString();
    public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
        return hashCode;
        return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ORDER_ISSET_ID);
    /**
        this.col = null;
    @Override
                oprot.writeString(struct.col);
    public Order() {}
    @Override
        hashCode = hashCode * 8191 + order;
                } else {
    }
        if (this.col == null) {
        public short getThriftFieldId() {
        return true;
            if (!(this_present_col && that_present_col)) return false;
        public static _Fields findByName(java.lang.String name) {
            }
                iprot.readStructEnd();
                oprot.writeString(struct.col);
                    return ORDER;
         */
    }
        if (that == null) return false;
        setOrderIsSet(false);
                "order",
    private static class OrderStandardScheme extends org.apache.thrift.scheme.StandardScheme<Order> {
 * Autogenerated by Thrift Compiler (0.23.0)
            struct.validate();
        lastComparison = java.lang.Boolean.compare(isSetOrder(), other.isSetOrder());
    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    }
     * Performs a deep copy on <i>other</i>.
    public @org.apache.thrift.annotation.Nullable java.lang.String col; // required
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
        org.apache.thrift.protocol.TType.STRING,
    public void setOrderIsSet(boolean value) {
        throw new java.lang.IllegalStateException();
            } finally {
                            }
            oprot.writeFieldStop();
                return isSetOrder();
    public void clear() {
            sb.append(this.col);
        if (other.isSetCol()) {
                }
            if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
    }
                java.util.BitSet incoming = iprot.readBitSet(2);
                struct.validate();
            } finally {
        );
            _fieldName = fieldName;
        }
        }
            case ORDER:
        try {
                if (incoming.get(1)) {
            try {
package org.opensearch.plugin.hive.metastore;
                }
        __isset_bitfield = other.__isset_bitfield;
                return lastComparison;
        org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Order.class, metaDataMap);
    public void validate() throws org.apache.thrift.TException {
                if (value == null) {
        this.order = 0;
}
                prot.decrementRecursionDepth();
        }
            _Fields,
        (short) 2
            if (!this.col.equals(that.col)) return false;
    }
                    return null;
        if (isSetCol()) hashCode = hashCode * 8191 + col.hashCode();
                            break;
    @Override
        @Override
        }
                    }
                }
        public static _Fields findByThriftIdOrThrow(int fieldId) {
        // check for sub-struct validity
        try {
                                struct.setColIsSet(true);
                oprot.writeFieldBegin(COL_FIELD_DESC);
        boolean that_present_col = true && that.isSetCol();
            }
    }
    public int compareTo(Order other) {
        @org.apache.thrift.annotation.Nullable
                while (true) {
        return 0;
        return this.col;
    }
                org.apache.thrift.protocol.TField schemeField;
    private byte __isset_bitfield = 0;
        "order",
                    if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
                                struct.order = iprot.readI32();
        sb.append(")");
    @Override
