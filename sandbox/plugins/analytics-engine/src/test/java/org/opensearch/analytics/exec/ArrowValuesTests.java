            v.setValueCount(1);  
        try (VarCharVector v = new VarCharVector("x", allocator)) {  
        try (DateDayVector v = new DateDayVector("d", allocator)) {  
    public void testDateDayFormatsIsoDate() {
        VarCharVector name = new VarCharVector("name", allocator);
        }
    public void testTimestampSecondSpaceSeparator() {
import static org.mockito.Mockito.mock;
    public void testTimeMilliFormat() {
        when(vec.getField()).thenReturn(Field.nullable("ts", new ArrowType.Timestamp(unit, null)));
            v.set(0, 27_605_000);
        try (TimeSecVector v = new TimeSecVector("t", allocator)) {  
            w.setValueCount(1);
        return ArrowValues.toSourceValue(vec, 0);  
        }
            assertEquals("2026-06-06 07:40:05", ArrowValues.toJavaValue(v, 0));
            UnionListWriter w = v.getWriter();  
            assertEquals("2026-06-06T07:40:05", ArrowValues.toSourceValue(v, 0));  
            v.setNull(0);
    public void testTimeNanoNoEpochPrefix() {
        }
    public void setUp() throws Exception {
        when(vec.getObject(0)).thenReturn(raw);
            assertNull(ArrowValues.toSourceValue(v, 0));
        }
    }
    public void testToSourceValueFloatingPointAsDouble() {  
        }
        }  
    }
        }
        }
import org.apache.arrow.vector.VectorSchemaRoot;
            v.set(0, 27_605_000_000_000L);
        try (VectorSchemaRoot root = VectorSchemaRoot.of(name, age, missing)) {
            v.set(0, 20_610L * 86_400_000L);
        VarCharVector missing = new VarCharVector("missing", allocator);  
        }
        }
            w.timeStampMicro().writeTimeStampMicro(1_780_731_605_000_000L);
 */  
    public void testTimestampMilliSpaceSeparator() {
        try (TimeStampMicroVector v = new TimeStampMicroVector("ts", allocator)) {  
        }  
    public void testToSourceValueListPreservesOrderDuplicatesAndNulls() {
            assertEquals("2026-06-06", ArrowValues.toJavaValue(v, 0));
import org.apache.arrow.vector.types.pojo.FieldType;
            v.allocateNew(1);
import org.apache.arrow.vector.DateMilliVector;  
        }
import org.apache.arrow.vector.FieldVector;
            v.allocateNew(1);
    }  
            v.setValueCount(1);
import org.apache.arrow.vector.DateDayVector;
        }
            assertNull(ArrowValues.toJavaValue(v, 0));  
            v.set(0, 1_780_731_605_000L);
            v.set(0, 1_780_731_605_123_456L);
            w.timeMicro().writeTimeMicro(27_605_000_000L);
            v.setValueCount(1);  
        super.tearDown();
            UnionListWriter w = v.getWriter();
import org.apache.arrow.vector.Float8Vector;
            assertEquals("2026-06-06 07:40:05.123456789", ArrowValues.toJavaValue(v, 0));
        try (TimeMicroVector v = new TimeMicroVector("t", allocator)) {  
            assertEquals("2026-06-06 07:40:05.123456", ArrowValues.toJavaValue(v, 0));
        assertEquals("2026-06-06T07:40:05Z", numericTimestampSource(1_780_731_605L, TimeUnit.SECOND));  
            v.set(0, 20610);
        }
package org.opensearch.analytics.exec;
            assertEquals(Boolean.TRUE, ArrowValues.toSourceValue(v, 0));
    }
        age.setValueCount(1);  
        Field list = new Field("ts_list", FieldType.nullable(new ArrowType.List()), List.of(child));
            v.allocateNew();
        try (TimeStampMilliVector v = new TimeStampMilliVector("ts", allocator)) {  
        try (VarBinaryVector v = new VarBinaryVector("b", allocator)) {  
    public void testTimestampNanoPreservesNanoseconds() {
            assertEquals(42L, ArrowValues.toJavaValue(v, 0));  
        Field child = new Field("item", FieldType.nullable(new ArrowType.Time(TimeUnit.MICROSECOND, 64)), null);
            Object cell = ArrowValues.toJavaValue(v, 0);
            w.startList();
            assertEquals("alice", out.get("name"));
    public void testVarCharNonTemporalUnchanged() {
    public void testToSourceValueTimestampNumberRendersIsoUtc() {
import org.apache.arrow.memory.BufferAllocator;
            v.setValueCount(1);  
    }  
    public void testVarCharDecodedAsString() {
            v.allocateNew(1);
        try (IntVector v = new IntVector("n", allocator)) {
        }
 *
            v.setSafe(0, "hello".getBytes(java.nio.charset.StandardCharsets.UTF_8));
        try (TimeNanoVector v = new TimeNanoVector("t", allocator)) {  
            w.endList();
    private static Object numericTimestampSource(long raw, TimeUnit unit) {
    /** Standard timestamp vectors decode to LocalDateTime; toSourceValue renders that via toString() (ISO-8601, 'T' separator, no 'Z'). */  
    /** Builds a Timestamp-typed vector whose cell decodes to a raw Long, exercising the numeric ISO branch + toInstant. */  
            v.allocateNew(1);
            v.setValueCount(1);
            data.setSafe(start, "prod".getBytes(java.nio.charset.StandardCharsets.UTF_8));  
            assertNull(ArrowValues.toSourceValue(v, 0));
            v.setValueCount(1);
/*  
        try (Float8Vector v = new Float8Vector("d", allocator)) {
        Field list = new Field("t_list", FieldType.nullable(new ArrowType.List()), List.of(child));  
import org.apache.arrow.vector.TimeStampMilliVector;  
    public void testToSourceMapDropsNullsAndPreservesFieldOrder() {  
            w.endList();  
    }
            v.setValueCount(1);  
    @Override
            v.allocateNew(1);  
            v.setSafe(0, "2019-03-24T01:34:46.123456789".getBytes(java.nio.charset.StandardCharsets.UTF_8));
            v.setValueCount(1);  
            VarCharVector data = (VarCharVector) vector.getDataVector();
        try (ListVector v = (ListVector) list.createVector(allocator)) {
            int start = vector.startNewValue(0);
            v.set(0, 27_605);
    }  
}
            v.allocateNew(1);
import org.apache.arrow.vector.VarBinaryVector;  
            w.setValueCount(1);  
            v.setValueCount(1);
    public void testVarCharIsoTimestampGetsSpaceSeparator() {
        missing.setNull(0);
            v.setValueCount(1);
            assertEquals("hello T world", ArrowValues.toJavaValue(v, 0));
import org.apache.arrow.vector.TimeMilliVector;
            v.set(0, 1);  
            v.allocateNew();
        try (BigIntVector v = new BigIntVector("x", allocator)) {
        try (DateMilliVector v = new DateMilliVector("d", allocator)) {  
    }
import org.apache.arrow.vector.BigIntVector;  
    public void testToSourceValueUtf8AsString() {  
import org.apache.arrow.memory.RootAllocator;
            v.allocateNew(1);  
    }  
        try (TimeStampMilliVector v = new TimeStampMilliVector("ts", allocator)) {
            v.setValueCount(1);  
    }  
            v.setSafe(0, "hello".getBytes(java.nio.charset.StandardCharsets.UTF_8));  
    }
            data.setSafe(start + 2, "prod".getBytes(java.nio.charset.StandardCharsets.UTF_8));
import java.util.List;
        }  
            v.setSafe(0, "hello T world".getBytes(java.nio.charset.StandardCharsets.UTF_8));
import org.apache.arrow.vector.complex.ListVector;  
    /** DataFusion CAST(timestamp AS VARCHAR) emits ISO-T — swap to space. */
            v.allocateNew(1);
            v.setValueCount(1);  
            v.setValueCount(1);
            w.startList();  
        missing.allocateNew();
    }
        // VectorSchemaRoot.of takes ownership; closing root closes the child vectors.
    public void testListOfTimestampElementsFormatWithSpace() {
            v.allocateNew(1);  
            assertEquals(List.of("07:40:05"), cell);
            assertEquals(30L, out.get("age"));  
import org.apache.arrow.vector.types.TimeUnit;
            assertFalse(out.containsKey("missing"));
            data.setSafe(start + 3, "error".getBytes(java.nio.charset.StandardCharsets.UTF_8));  
    public void testListOfTimeElementsHasNoEpochPrefix() {
    public void tearDown() throws Exception {
        name.setValueCount(1);  
    /** When a Timestamp cell decodes to a raw Number, toSourceValue formats it as ISO-8601 UTC (with 'Z') across all units. */
    private BufferAllocator allocator;
        try (TimeMilliVector v = new TimeMilliVector("t", allocator)) {  
            assertEquals("2026-06-06", ArrowValues.toJavaValue(v, 0));
            v.allocateNew(1);
            assertEquals("2026-06-06 07:40:05", ArrowValues.toJavaValue(v, 0));
            v.set(0, 1_780_731_605L);
import org.apache.arrow.vector.types.pojo.ArrowType;  
 * this file be licensed under the Apache-2.0 license or a
    }
            v.allocateNew(1);
    public void testToSourceValueIntAsLong() {  
            assertEquals("07:40:05", ArrowValues.toJavaValue(v, 0));
            v.set(0, 42);  
        }
    }
        age.allocateNew(1);
            v.setValueCount(1);  
            vector.allocateNew();  
            v.setValueCount(1);  
import org.apache.arrow.vector.TimeStampSecVector;
    }  
    public void testTimestampMicroPreservesMicroseconds() {
            vector.endValue(0, 4);
import org.apache.arrow.vector.TimeStampMicroVector;
            v.allocateNew(1);
            assertEquals("07:40:05", ArrowValues.toJavaValue(v, 0));
/** Null, BigInt pass-through, VarChar, Date/Time/Timestamp formatting (scalar + list). */
import org.apache.arrow.vector.BitVector;
        age.set(0, 30);
            data.setValueCount(4);
    }
    }  
            v.setSafe(0, new byte[] { 1, 2, 3 });
import org.apache.arrow.vector.types.pojo.Field;
    }  
import java.util.Map;  
            v.allocateNew();
import org.apache.arrow.vector.complex.impl.UnionListWriter;
 * SPDX-License-Identifier: Apache-2.0
        allocator = new RootAllocator();
import org.apache.arrow.vector.TimeMicroVector;
            v.allocateNew(1);
 * The OpenSearch Contributors require contributions made to  
            v.allocateNew(1);
        name.setSafe(0, "alice".getBytes(java.nio.charset.StandardCharsets.UTF_8));
        missing.setValueCount(1);  
            v.set(0, 42L);
        }  
import org.apache.arrow.vector.TimeStampNanoVector;
            v.setValueCount(1);  
    public void testBigIntPassThroughUnchanged() {
        Field child = new Field("item", FieldType.nullable(new ArrowType.Timestamp(TimeUnit.MICROSECOND, null)), null);  
public class ArrowValuesTests extends OpenSearchTestCase {  
            v.set(0, 27_605_123_456L);
    }  
        try (ListVector vector = (ListVector) list.createVector(allocator)) {
            assertEquals(3.5d, (double) ArrowValues.toSourceValue(v, 0), 0.0d);
        FieldVector vec = mock(FieldVector.class);
        assertEquals("2026-06-06T07:40:05.123456Z", numericTimestampSource(1_780_731_605_123_456L, TimeUnit.MICROSECOND));
        super.setUp();  
            v.allocateNew(1);
            assertEquals(42L, ArrowValues.toSourceValue(v, 0));
        Field list = new Field("tags", FieldType.nullable(ArrowType.List.INSTANCE), List.of(child));
        }  
        allocator.close();  
        }
    public void testTimeMicroPreservesMicroseconds() {
        }
        try (VarCharVector v = new VarCharVector("x", allocator)) {  
        }
        }
import static org.mockito.Mockito.when;  
            v.setNull(0);
            v.set(0, 1_780_731_605_000L);
            assertEquals(java.util.Arrays.asList("prod", null, "prod", "error"), ArrowValues.toSourceValue(vector, 0));
        assertEquals("2026-06-06T07:40:05.123456789Z", numericTimestampSource(1_780_731_605_123_456_789L, TimeUnit.NANOSECOND));  
    public void testDateMilliFormatsIsoDate() {
    }  
            assertEquals("07:40:05.123456", ArrowValues.toJavaValue(v, 0));
            assertEquals(2, out.size());
import org.apache.arrow.vector.TimeNanoVector;  
        }
    }  
            assertEquals("07:40:05", ArrowValues.toJavaValue(v, 0));
    }
 * compatible open source license.
    }  
import org.apache.arrow.vector.VarCharVector;
    public void testToSourceValueBoolAsBoolean() {  
    @Override
            Object cell = ArrowValues.toJavaValue(v, 0);
    public void testToSourceValueBinaryDropped() {
            v.allocateNew();
            v.allocateNew(1);
    }
        Field child = new Field("element", FieldType.nullable(ArrowType.Utf8.INSTANCE), null);  
        try (TimeStampNanoVector v = new TimeStampNanoVector("ts", allocator)) {  
            assertEquals("2019-03-24 01:34:46.123456789", ArrowValues.toJavaValue(v, 0));
import org.opensearch.test.OpenSearchTestCase;  
        try (ListVector v = (ListVector) list.createVector(allocator)) {
    public void testNullCellReturnsNull() {
    }  
        }  
            vector.setValueCount(1);  
        name.allocateNew();
            v.set(0, 1_780_731_605_123_456_789L);
            data.setNull(start + 1);
        try (VarCharVector v = new VarCharVector("x", allocator)) {
        try (BigIntVector v = new BigIntVector("x", allocator)) {  
            v.setValueCount(1);  
        try (BitVector v = new BitVector("flag", allocator)) {
        }
    public void testTimeSecFormat() {
        when(vec.isNull(0)).thenReturn(false);  
    }
    }  
        assertEquals("2026-06-06T07:40:05.123Z", numericTimestampSource(1_780_731_605_123L, TimeUnit.MILLISECOND));
            v.setValueCount(1);
    }
            v.set(0, 3.5d);  
    // ---- toSourceValue / toSourceMap (moved from GetService.NativeBridgeExecutor) ----  
        IntVector age = new IntVector("age", allocator);
            assertEquals("hello", ArrowValues.toJavaValue(v, 0));  
        try (TimeStampSecVector v = new TimeStampSecVector("ts", allocator)) {  
    public void testToSourceValueTimestampLocalDateTimeToString() {
            v.setValueCount(1);  
            v.setValueCount(1);  
        try (VarCharVector v = new VarCharVector("s", allocator)) {
            v.allocateNew(1);
            assertEquals("hello", ArrowValues.toSourceValue(v, 0));
    }
            v.setValueCount(1);  
        try (BigIntVector v = new BigIntVector("x", allocator)) {
import org.apache.arrow.vector.IntVector;  
            v.setValueCount(1);
    }  
            assertEquals(List.of("2026-06-06 07:40:05"), cell);  
            v.allocateNew();  
    public void testToSourceValueNullReturnsNull() {
            Map<String, Object> out = ArrowValues.toSourceMap(root, 0);  
import org.apache.arrow.vector.TimeSecVector;
