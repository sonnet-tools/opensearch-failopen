 * SPDX-License-Identifier: Apache-2.0
    }
    }
import org.apache.arrow.vector.Float2Vector;
        field.createField(ft, vsr, 3.14f);
        Schema schema = new Schema(List.of(new Field(fieldName, pf.getFieldType(), null)));
        TokenCountParquetField field = new TokenCountParquetField();  
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.SmallIntVector;  
    private void cleanupVSR(ManagedVSR vsr) {  
    public void testHalfFloatFieldAddToGroupPreservesFractional() {
        IntegerParquetField field = new IntegerParquetField();
    }
        assertEquals(FloatingPointPrecision.HALF, type.getPrecision());
        ManagedVSR vsr = createVSR("float-test", field, "val");  
        cleanupVSR(vsr);
    }
    private BufferAllocator allocator;
import org.apache.arrow.vector.IntVector;
        super.tearDown();  
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.INTEGER);
        Float2Vector vec = (Float2Vector) vsr.getVector("val");
    }
        assertTrue(type.getIsSigned());  
import org.opensearch.parquet.fields.ParquetField;
    }  
        ManagedVSR vsr = createVSR("byte-test", field, "val");  
    public void testShortFieldArrowType() {  
    }  
        ManagedVSR vsr = createVSR("half-float-negative-test", field, "val");
        assertEquals(FloatingPointPrecision.SINGLE, type.getPrecision());  
        cleanupVSR(vsr);
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
        ManagedVSR vsr = createVSR("double-test", field, "val");
        cleanupVSR(vsr);  
    public void testShortFieldAddToGroup() {
        assertFalse(type.getIsSigned());
package org.opensearch.parquet.fields.core.data.number;
        assertEquals(7, ((SmallIntVector) vsr.getVector("val")).get(0));
        ArrowType.FloatingPoint type = (ArrowType.FloatingPoint) field.getArrowType();
        cleanupVSR(vsr);
        cleanupVSR(vsr);
        ManagedVSR vsr = createVSR("long-test", field, "val");
        ManagedVSR vsr = createVSR("short-test", field, "val");
        assertEquals(42, vec.get(0));  
    public void testHalfFloatFieldArrowType() {
        assertEquals(7.3f, Float16.toFloat(vec.get(0)), 0.005f);  
        field.createField(ft, vsr, (byte) 3);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.LONG);
        assertTrue(field.getFieldType().isNullable());
    @Override  
}
        HalfFloatParquetField field = new HalfFloatParquetField();  
        vsr.setRowCount(1);
    }
        vsr.setRowCount(1);  
        HalfFloatParquetField field = new HalfFloatParquetField();
        assertEquals(0.0f, Float16.toFloat(vec.get(0)), 0.0f);
    public void setUp() throws Exception {
        assertTrue(type.getIsSigned());  
        // Sign and magnitude both preserved.
        field.createField(ft, vsr, 2.718);
    }
import java.util.List;  
        cleanupVSR(vsr);
import org.apache.arrow.vector.types.FloatingPointPrecision;
        allocator.close();
    }
    public void testTokenCountFieldArrowType() {
        ShortParquetField field = new ShortParquetField();
        ManagedVSR vsr = createVSR("half-float-fractional-test", field, "val");
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.SHORT);  
        cleanupVSR(vsr);  
        LongParquetField field = new LongParquetField();
        BufferAllocator child = allocator.newChildAllocator(id, 0, Long.MAX_VALUE);
    public void testFloatFieldAddToGroup() {  
    }
    public void testFloatFieldArrowType() {  
        return new ManagedVSR(id, schema, child);  
    }
        DoubleParquetField field = new DoubleParquetField();
import org.apache.arrow.vector.BigIntVector;
        ArrowType.FloatingPoint type = (ArrowType.FloatingPoint) field.getArrowType();
        cleanupVSR(vsr);
        assertEquals(123456789L, ((BigIntVector) vsr.getVector("val")).get(0));
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();  
        // not stay at the integer 7 (the pre-fix bug) and not collapse to a tiny subnormal.
        assertEquals(8, type.getBitWidth());
    }
import org.apache.arrow.vector.Float8Vector;
        ManagedVSR vsr = createVSR("half-float-test", field, "val");  
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
 * this file be licensed under the Apache-2.0 license or a
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.HALF_FLOAT);  
import org.apache.arrow.vector.types.pojo.Field;
        ManagedVSR vsr = createVSR("half-float-zero-test", field, "val");
    public void testIntegerFieldArrowType() {  
        cleanupVSR(vsr);
        field.createField(ft, vsr, 42);  
        ArrowType.FloatingPoint type = (ArrowType.FloatingPoint) field.getArrowType();  
 * compatible open source license.
        assertEquals(FloatingPointPrecision.DOUBLE, type.getPrecision());
        field.createField(ft, vsr, -2.5);  
    public void testLongFieldArrowType() {
        assertEquals(64, type.getBitWidth());
        field.createField(ft, vsr, (short) 7);
    public void testHalfFloatFieldAddToGroup() {
    }
        assertTrue(type.getIsSigned());
        allocator = new RootAllocator();  
import org.apache.arrow.vector.types.pojo.Schema;
        assertEquals(1.5f, Float16.toFloat(vec.get(0)), 0.0f);  
        IntVector vec = (IntVector) vsr.getVector("val");
    }  
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
        field.createField(ft, vsr, 0.0);
        vsr.setRowCount(1);  
        field.createField(ft, vsr, 123456789L);  
    public void testDoubleFieldArrowType() {
        field.createField(ft, vsr, 7.3);
    }  
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.BYTE);
        Float2Vector vec = (Float2Vector) vsr.getVector("val");  
    public void tearDown() throws Exception {
import org.apache.arrow.vector.Float4Vector;  
    }  
        HalfFloatParquetField field = new HalfFloatParquetField();
        assertEquals(2.718, ((Float8Vector) vsr.getVector("val")).get(0), 0.001);
        IntegerParquetField field = new IntegerParquetField();  
        vsr.setRowCount(1);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.HALF_FLOAT);
    private ManagedVSR createVSR(String id, ParquetField pf, String fieldName) {  
import org.opensearch.index.mapper.MappedFieldType;  
 *
    @Override  
    public void testUnsignedLongFieldArrowType() {
        ShortParquetField field = new ShortParquetField();
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.DOUBLE);  
        vsr.moveToFrozen();
        ByteParquetField field = new ByteParquetField();  
        assertTrue(type.getIsSigned());
        assertEquals(64, type.getBitWidth());
        assertTrue(type.getIsSigned());
    public void testDoubleFieldAddToGroup() {
    }
        HalfFloatParquetField field = new HalfFloatParquetField();
        assertEquals(32, type.getBitWidth());  
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.HALF_FLOAT);  
        vsr.setRowCount(1);
        FloatParquetField field = new FloatParquetField();
        assertEquals(3.14f, ((Float4Vector) vsr.getVector("val")).get(0), 0.001f);  
        vsr.setRowCount(1);  
    public void testByteFieldArrowType() {
        ManagedVSR vsr = createVSR("int-test", field, "val");
        // 7.3 → fp16 → fp32 round-trip should land within fp16 precision (~3 decimal digits).  
 * The OpenSearch Contributors require contributions made to  
        FloatParquetField field = new FloatParquetField();
 */  
import org.apache.arrow.memory.util.Float16;  
        vsr.setRowCount(1);  
        field.createField(ft, vsr, 1.5);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.HALF_FLOAT);
    public void testByteFieldAddToGroup() {  
    public void testIntegerFieldAddToGroup() {
    }  
        assertEquals(16, type.getBitWidth());  
        DoubleParquetField field = new DoubleParquetField();
import org.apache.arrow.memory.BufferAllocator;
        assertEquals(32, type.getBitWidth());
import org.apache.arrow.vector.types.pojo.ArrowType;  
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("val", NumberFieldMapper.NumberType.FLOAT);
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();
import org.opensearch.test.OpenSearchTestCase;
        vsr.setRowCount(1);
    }
        // 1.5 is exactly representable in fp16, so this round-trips with zero error.
    public void testHalfFloatFieldAddToGroupNegative() {
    }
        assertEquals(-2.5f, Float16.toFloat(vec.get(0)), 0.0f);  
        super.setUp();
        vsr.setRowCount(1);
        UnsignedLongParquetField field = new UnsignedLongParquetField();
public class NumberParquetFieldTests extends OpenSearchTestCase {
        HalfFloatParquetField field = new HalfFloatParquetField();  
import org.apache.arrow.vector.TinyIntVector;
    }  
        cleanupVSR(vsr);
        // Value should round-trip to the closest fp16 representation of 7.3 (≈ 7.296875),
    }
/*  
        ByteParquetField field = new ByteParquetField();
import org.opensearch.index.mapper.NumberFieldMapper;
        Float2Vector vec = (Float2Vector) vsr.getVector("val");
        assertEquals(3, ((TinyIntVector) vsr.getVector("val")).get(0));  
        Float2Vector vec = (Float2Vector) vsr.getVector("val");
        LongParquetField field = new LongParquetField();  
import org.opensearch.parquet.vsr.ManagedVSR;  
    public void testHalfFloatFieldAddToGroupZero() {
        ArrowType.Int type = (ArrowType.Int) field.getArrowType();  
        vsr.close();
    public void testLongFieldAddToGroup() {
        vsr.setRowCount(1);
