        Float2Vector vec = (Float2Vector) vsr.getVector("val");
        ShortParquetField field = new ShortParquetField();
 * The OpenSearch Contributors require contributions made to
        Schema schema = new Schema(List.of(new Field(fieldName, pf.getFieldType(), null)));
    }
        HalfFloatParquetField field = new HalfFloatParquetField();
import org.apache.arrow.vector.types.pojo.Schema;
}
    }
 */
        assertEquals(-2.5f, Float16.toFloat(vec.get(0)), 0.0f);
        field.createField(ft, vsr, 1.5);
    private void cleanupVSR(ManagedVSR vsr) {
    }
        IntVector vec = (IntVector) vsr.getVector("val");
        ManagedVSR vsr = createVSR("double-test", field, "val");
        assertEquals(3, ((TinyIntVector) vsr.getVector("val")).get(0));
import java.util.List;
import org.apache.arrow.memory.RootAllocator;
    public void testTokenCountFieldArrowType() {
    }
    public void testFloatFieldAddToGroup() {
        field.createField(ft, vsr, 2.718);
    public void testLongFieldArrowType() {
    }
    public void testByteFieldAddToGroup() {
        field.createField(ft, vsr, (short) 7);
import org.apache.arrow.vector.Float2Vector;
        vsr.setRowCount(1);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.SHORT);
        vsr.setRowCount(1);
    @Override
        cleanupVSR(vsr);
        assertEquals(FloatingPointPrecision.HALF, type.getPrecision());
 * compatible open source license.
        assertEquals(16, type.getBitWidth());
        cleanupVSR(vsr);
    }
        assertTrue(field.getFieldType().isNullable());
        cleanupVSR(vsr);
    }
        BufferAllocator child = allocator.newChildAllocator(id, 0, Long.MAX_VALUE);
        ArrowType.FloatingPoint type = (ArrowType.FloatingPoint) field.getArrowType();
        cleanupVSR(vsr);
        ByteParquetField field = new ByteParquetField();
        allocator = new RootAllocator();
    }
    @Override
        HalfFloatParquetField field = new HalfFloatParquetField();
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.FLOAT);
        vsr.setRowCount(1);
        LongParquetField field = new LongParquetField();
    public void testShortFieldArrowType() {
        ManagedVSR vsr = createVSR("half-float-zero-test", field, "val");
        DoubleParquetField field = new DoubleParquetField();
import org.opensearch.test.OpenSearchTestCase;
        // not stay at the integer 7 (the pre-fix bug) and not collapse to a tiny subnormal.
        assertEquals(32, type.getBitWidth());
import org.apache.arrow.memory.util.Float16;
        assertEquals(64, type.getBitWidth());
    }
    public void testByteFieldArrowType() {
        ShortParquetField field = new ShortParquetField();
import org.apache.arrow.vector.BigIntVector;
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.HALF_FLOAT);
        super.setUp();
        // 7.3 → fp16 → fp32 round-trip should land within fp16 precision (~3 decimal digits).
        cleanupVSR(vsr);
        ManagedVSR vsr = createVSR("half-float-fractional-test", field, "val");
        vsr.setRowCount(1);
        cleanupVSR(vsr);
        ManagedVSR vsr = createVSR("half-float-test", field, "val");
        assertEquals(7, ((SmallIntVector) vsr.getVector("val")).get(0));
        ManagedVSR vsr = createVSR("int-test", field, "val");
        assertTrue(type.getIsSigned());
        assertTrue(type.getIsSigned());
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
        allocator.close();
    public void testHalfFloatFieldAddToGroupZero() {
        vsr.close();
import org.apache.arrow.vector.IntVector;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.BYTE);
    public void testIntegerFieldArrowType() {
    }
import org.apache.arrow.memory.BufferAllocator;
import org.apache.arrow.vector.Float8Vector;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.HALF_FLOAT);
        assertEquals(7.3f, Float16.toFloat(vec.get(0)), 0.005f);
        field.createField(ft, vsr, 7.3);
        FloatParquetField field = new FloatParquetField();
    public void testDoubleFieldAddToGroup() {
    }
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
    public void testHalfFloatFieldArrowType() {
        field.createField(ft, vsr, 0.0);
 * this file be licensed under the Apache-2.0 license or a
    private ManagedVSR createVSR(String id, ParquetField pf, String fieldName) {
    }
    }
import org.opensearch.parquet.vsr.ManagedVSR;
    public void testHalfFloatFieldAddToGroupNegative() {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.HALF_FLOAT);
        assertTrue(type.getIsSigned());
        DoubleParquetField field = new DoubleParquetField();
        UnsignedLongParquetField field = new UnsignedLongParquetField();
        cleanupVSR(vsr);
        assertEquals(8, type.getBitWidth());
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.LONG);
        ByteParquetField field = new ByteParquetField();
import org.opensearch.parquet.fields.ParquetField;
        // Value should round-trip to the closest fp16 representation of 7.3 (≈ 7.296875),
        assertEquals(1.5f, Float16.toFloat(vec.get(0)), 0.0f);
        field.createField(ft, vsr, (byte) 3);
        HalfFloatParquetField field = new HalfFloatParquetField();
        vsr.setRowCount(1);
 *
    }
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.HALF_FLOAT);
        ArrowType.FloatingPoint type = (ArrowType.FloatingPoint) field.getArrowType();
    public void testUnsignedLongFieldArrowType() {
    }
import org.apache.arrow.vector.types.pojo.Field;
    public void testIntegerFieldAddToGroup() {
        // Sign and magnitude both preserved.
        TokenCountParquetField field = new TokenCountParquetField();
import org.opensearch.index.mapper.NumberFieldMapper;
        Float2Vector vec = (Float2Vector) vsr.getVector("val");
        field.createField(ft, vsr, 123456789L);
        cleanupVSR(vsr);
        LongParquetField field = new LongParquetField();
        assertTrue(type.getIsSigned());
        assertEquals(2.718, ((Float8Vector) vsr.getVector("val")).get(0), 0.001);
        ManagedVSR vsr = createVSR("float-test", field, "val");
        ManagedVSR vsr = createVSR("half-float-negative-test", field, "val");
    }
        cleanupVSR(vsr);
        assertEquals(FloatingPointPrecision.SINGLE, type.getPrecision());
    public void testLongFieldAddToGroup() {
        field.createField(ft, vsr, -2.5);
 * SPDX-License-Identifier: Apache-2.0
    public void testDoubleFieldArrowType() {
        vsr.moveToFrozen();
import org.apache.arrow.vector.SmallIntVector;
import org.apache.arrow.vector.TinyIntVector;
    private BufferAllocator allocator;
        super.tearDown();
        ManagedVSR vsr = createVSR("byte-test", field, "val");
        vsr.setRowCount(1);
public class NumberParquetFieldTests extends OpenSearchTestCase {
import org.opensearch.index.mapper.MappedFieldType;
        vsr.setRowCount(1);
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
import org.apache.arrow.vector.types.pojo.ArrowType;
        HalfFloatParquetField field = new HalfFloatParquetField();
        ArrowType.FloatingPoint type = (ArrowType.FloatingPoint) field.getArrowType();
        assertFalse(type.getIsSigned());
    public void testShortFieldAddToGroup() {
        vsr.setRowCount(1);
        assertEquals(42, vec.get(0));
        HalfFloatParquetField field = new HalfFloatParquetField();
        field.createField(ft, vsr, 42);
        assertEquals(32, type.getBitWidth());
        ManagedVSR vsr = createVSR("long-test", field, "val");
    }
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.DOUBLE);
    }
    }
    public void testHalfFloatFieldAddToGroup() {
/*
    public void testFloatFieldArrowType() {
        Float2Vector vec = (Float2Vector) vsr.getVector("val");
        assertEquals(0.0f, Float16.toFloat(vec.get(0)), 0.0f);
        cleanupVSR(vsr);
        return new ManagedVSR(id, schema, child);
package org.opensearch.parquet.fields.core.data.number;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        IntegerParquetField field = new IntegerParquetField();
        assertEquals(FloatingPointPrecision.DOUBLE, type.getPrecision());
        IntegerParquetField field = new IntegerParquetField();
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
        vsr.setRowCount(1);
        FloatParquetField field = new FloatParquetField();
    public void tearDown() throws Exception {
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
import org.apache.arrow.vector.types.FloatingPointPrecision;
        Float2Vector vec = (Float2Vector) vsr.getVector("val");
        // 1.5 is exactly representable in fp16, so this round-trips with zero error.
    }
        vsr.setRowCount(1);
        assertEquals(123456789L, ((BigIntVector) vsr.getVector("val")).get(0));
    public void testHalfFloatFieldAddToGroupPreservesFractional() {
        assertEquals(64, type.getBitWidth());
    }
        ManagedVSR vsr = createVSR("short-test", field, "val");
    }
        assertEquals(3.14f, ((Float4Vector) vsr.getVector("val")).get(0), 0.001f);
        field.createField(ft, vsr, 3.14f);
    public void setUp() throws Exception {
    }
import org.apache.arrow.vector.Float4Vector;
        assertTrue(type.getIsSigned());
