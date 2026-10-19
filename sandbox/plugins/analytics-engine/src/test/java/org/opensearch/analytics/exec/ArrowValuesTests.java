            w.setValueCount(1);
        Field child = new Field("element", FieldType.nullable(ArrowType.Utf8.INSTANCE), null);
        super.tearDown();
        try (IntVector v = new IntVector("n", allocator)) {
            v.setNull(0);
            v.setValueCount(1);
    /** When a Timestamp cell decodes to a raw Number, toSourceValue formats it as ISO-8601 UTC (with 'Z') across all units. */
        }
    public void testVarCharDecodedAsString() {
            Map<String, Object> out = ArrowValues.toSourceMap(root, 0);
            v.set(0, 1_780_731_605_000L);
import org.apache.arrow.vector.complex.impl.UnionListWriter;
            assertEquals("hello", ArrowValues.toSourceValue(v, 0));
            w.setValueCount(1);
            assertNull(ArrowValues.toSourceValue(v, 0));
    @Override
import org.apache.arrow.vector.BigIntVector;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.vector.VectorSchemaRoot;
/*
            assertEquals(List.of("07:40:05"), cell);
            assertEquals("2026-06-06", ArrowValues.toJavaValue(v, 0));
    public void testToSourceValueBoolAsBoolean() {
    public void testTimestampMilliSpaceSeparator() {
            v.setValueCount(1);
            v.set(0, 27_605_000);
            assertNull(ArrowValues.toJavaValue(v, 0));
import org.apache.arrow.vector.types.TimeUnit;
        }
            int start = vector.startNewValue(0);
            v.set(0, 20610);
    public void testDateMilliFormatsIsoDate() {
import org.apache.arrow.vector.TimeStampNanoVector;
    public void testToSourceMapDropsNullsAndPreservesFieldOrder() {
        missing.allocateNew();
        }
            v.setValueCount(1);
            v.allocateNew(1);
    }
 * The OpenSearch Contributors require contributions made to
import org.apache.arrow.vector.Float8Vector;
            v.set(0, 42L);
            data.setSafe(start + 3, "error".getBytes(java.nio.charset.StandardCharsets.UTF_8));
            v.set(0, 20_610L * 86_400_000L);
        }
        try (VarCharVector v = new VarCharVector("x", allocator)) {
            v.setValueCount(1);
        super.setUp();
        try (TimeMicroVector v = new TimeMicroVector("t", allocator)) {
            v.allocateNew();
            v.allocateNew(1);
            v.setSafe(0, new byte[] { 1, 2, 3 });
import java.util.List;
        assertEquals("2026-06-06T07:40:05Z", numericTimestampSource(1_780_731_605L, TimeUnit.SECOND));
        when(vec.getObject(0)).thenReturn(raw);
        assertEquals("2026-06-06T07:40:05.123456Z", numericTimestampSource(1_780_731_605_123_456L, TimeUnit.MICROSECOND));
            v.set(0, 42);
        }
    }
    public void testToSourceValueTimestampNumberRendersIsoUtc() {
    public void testToSourceValueBinaryDropped() {
        allocator.close();
        assertEquals("2026-06-06T07:40:05.123Z", numericTimestampSource(1_780_731_605_123L, TimeUnit.MILLISECOND));
    }
import org.apache.arrow.vector.TimeStampSecVector;
            v.set(0, 3.5d);
    }
            assertEquals("2026-06-06", ArrowValues.toJavaValue(v, 0));
    public void testTimestampNanoPreservesNanoseconds() {
import org.apache.arrow.vector.TimeStampMilliVector;
            v.set(0, 1_780_731_605_123_456L);
            v.allocateNew(1);
import org.apache.arrow.vector.TimeMilliVector;
    }
 *
            assertEquals("2026-06-06 07:40:05", ArrowValues.toJavaValue(v, 0));
            assertNull(ArrowValues.toSourceValue(v, 0));
        try (VectorSchemaRoot root = VectorSchemaRoot.of(name, age, missing)) {
            v.allocateNew(1);
            assertFalse(out.containsKey("missing"));
public class ArrowValuesTests extends OpenSearchTestCase {
        try (TimeStampMilliVector v = new TimeStampMilliVector("ts", allocator)) {
import org.apache.arrow.vector.FieldVector;
            vector.allocateNew();
            data.setNull(start + 1);
    public void testVarCharNonTemporalUnchanged() {
    }
    }
    }
        when(vec.getField()).thenReturn(Field.nullable("ts", new ArrowType.Timestamp(unit, null)));
            assertEquals("2026-06-06T07:40:05", ArrowValues.toSourceValue(v, 0));
            v.setValueCount(1);
            assertEquals("07:40:05", ArrowValues.toJavaValue(v, 0));
            v.setValueCount(1);
    public void testTimeMicroPreservesMicroseconds() {
        allocator = new RootAllocator();
            v.allocateNew(1);
    public void testTimeMilliFormat() {
            assertEquals("hello", ArrowValues.toJavaValue(v, 0));
            assertEquals(42L, ArrowValues.toSourceValue(v, 0));
        name.allocateNew();
import org.apache.arrow.vector.TimeSecVector;
        try (ListVector v = (ListVector) list.createVector(allocator)) {
        }
        }
    public void testTimestampSecondSpaceSeparator() {
    }
import static org.mockito.Mockito.when;
    public void tearDown() throws Exception {
        }
        VarCharVector name = new VarCharVector("name", allocator);
import org.apache.arrow.vector.complex.ListVector;
    private static Object numericTimestampSource(long raw, TimeUnit unit) {
    public void testTimeNanoNoEpochPrefix() {
        try (VarBinaryVector v = new VarBinaryVector("b", allocator)) {
        }
            v.setSafe(0, "2019-03-24T01:34:46.123456789".getBytes(java.nio.charset.StandardCharsets.UTF_8));
        try (VarCharVector v = new VarCharVector("x", allocator)) {
            w.endList();
            assertEquals(List.of("2026-06-06 07:40:05"), cell);
    public void testToSourceValueUtf8AsString() {
        try (BigIntVector v = new BigIntVector("x", allocator)) {
import org.apache.arrow.vector.types.pojo.ArrowType;
            Object cell = ArrowValues.toJavaValue(v, 0);
            vector.endValue(0, 4);
            v.allocateNew(1);
        }
        }
            v.allocateNew(1);
    }
            v.allocateNew();
        missing.setNull(0);
            v.allocateNew();
        try (VarCharVector v = new VarCharVector("x", allocator)) {
            v.allocateNew();
            VarCharVector data = (VarCharVector) vector.getDataVector();
        try (BitVector v = new BitVector("flag", allocator)) {
            Object cell = ArrowValues.toJavaValue(v, 0);
        try (Float8Vector v = new Float8Vector("d", allocator)) {
            v.setValueCount(1);
import org.apache.arrow.vector.VarBinaryVector;
        try (DateDayVector v = new DateDayVector("d", allocator)) {
        try (DateMilliVector v = new DateMilliVector("d", allocator)) {
            data.setSafe(start + 2, "prod".getBytes(java.nio.charset.StandardCharsets.UTF_8));
        }
            v.setValueCount(1);
            assertEquals("2026-06-06 07:40:05.123456789", ArrowValues.toJavaValue(v, 0));
        }
            v.setValueCount(1);
    public void testToSourceValueIntAsLong() {
            assertEquals(3.5d, (double) ArrowValues.toSourceValue(v, 0), 0.0d);
            UnionListWriter w = v.getWriter();
/** Null, BigInt pass-through, VarChar, Date/Time/Timestamp formatting (scalar + list). */
import static org.mockito.Mockito.mock;
    }
    public void testToSourceValueFloatingPointAsDouble() {
            v.set(0, 27_605_123_456L);
            v.allocateNew(1);
        try (ListVector v = (ListVector) list.createVector(allocator)) {
            v.set(0, 1_780_731_605_000L);
    }
 * compatible open source license.
        }
            assertEquals("07:40:05", ArrowValues.toJavaValue(v, 0));
    /** DataFusion CAST(timestamp AS VARCHAR) emits ISO-T — swap to space. */
            v.set(0, 1_780_731_605_123_456_789L);
import org.apache.arrow.memory.BufferAllocator;
            assertEquals(Boolean.TRUE, ArrowValues.toSourceValue(v, 0));
package org.opensearch.analytics.exec;
    /** Builds a Timestamp-typed vector whose cell decodes to a raw Long, exercising the numeric ISO branch + toInstant. */
import org.apache.arrow.vector.DateDayVector;
        Field child = new Field("item", FieldType.nullable(new ArrowType.Timestamp(TimeUnit.MICROSECOND, null)), null);
        try (BigIntVector v = new BigIntVector("x", allocator)) {
    }
            assertEquals("2019-03-24 01:34:46.123456789", ArrowValues.toJavaValue(v, 0));
    }
        name.setValueCount(1);
        }
    }
    public void testVarCharIsoTimestampGetsSpaceSeparator() {
        age.setValueCount(1);
            v.allocateNew(1);
    public void testListOfTimeElementsHasNoEpochPrefix() {
            assertEquals("alice", out.get("name"));
            vector.setValueCount(1);
import org.apache.arrow.vector.VarCharVector;
            v.setValueCount(1);
        }
import org.apache.arrow.vector.TimeStampMicroVector;
        }
            v.allocateNew(1);
    }
            assertEquals(java.util.Arrays.asList("prod", null, "prod", "error"), ArrowValues.toSourceValue(vector, 0));
    public void setUp() throws Exception {
        assertEquals("2026-06-06T07:40:05.123456789Z", numericTimestampSource(1_780_731_605_123_456_789L, TimeUnit.NANOSECOND));
    public void testTimeSecFormat() {
        try (ListVector vector = (ListVector) list.createVector(allocator)) {
    public void testToSourceValueListPreservesOrderDuplicatesAndNulls() {
            w.endList();
import org.apache.arrow.vector.DateMilliVector;
import org.apache.arrow.vector.TimeNanoVector;
            data.setValueCount(4);
        }
        }
    // ---- toSourceValue / toSourceMap (moved from GetService.NativeBridgeExecutor) ----
            assertEquals("07:40:05.123456", ArrowValues.toJavaValue(v, 0));
        when(vec.isNull(0)).thenReturn(false);
            v.setValueCount(1);
            v.set(0, 27_605_000_000_000L);
    }
            v.set(0, 1);
        age.set(0, 30);
            v.allocateNew(1);
        Field list = new Field("ts_list", FieldType.nullable(new ArrowType.List()), List.of(child));
            v.setNull(0);
            v.allocateNew(1);
        try (VarCharVector v = new VarCharVector("s", allocator)) {
            v.allocateNew(1);
    private BufferAllocator allocator;
            v.setValueCount(1);
        IntVector age = new IntVector("age", allocator);
        try (TimeMilliVector v = new TimeMilliVector("t", allocator)) {
        Field list = new Field("t_list", FieldType.nullable(new ArrowType.List()), List.of(child));
    }
            v.setValueCount(1);
            v.allocateNew(1);
            data.setSafe(start, "prod".getBytes(java.nio.charset.StandardCharsets.UTF_8));
            v.setValueCount(1);
    }
            v.setValueCount(1);
            v.setValueCount(1);
    }
    public void testToSourceValueNullReturnsNull() {
    }
    public void testTimestampMicroPreservesMicroseconds() {
        }
    }
        Field list = new Field("tags", FieldType.nullable(ArrowType.List.INSTANCE), List.of(child));
        try (TimeStampMicroVector v = new TimeStampMicroVector("ts", allocator)) {
        }
        // VectorSchemaRoot.of takes ownership; closing root closes the child vectors.
            v.setValueCount(1);
            assertEquals(42L, ArrowValues.toJavaValue(v, 0));
    public void testDateDayFormatsIsoDate() {
        }
}
            assertEquals("07:40:05", ArrowValues.toJavaValue(v, 0));
    public void testListOfTimestampElementsFormatWithSpace() {
            w.timeStampMicro().writeTimeStampMicro(1_780_731_605_000_000L);
        age.allocateNew(1);
        try (BigIntVector v = new BigIntVector("x", allocator)) {
            v.setValueCount(1);
    }
            w.startList();
            v.allocateNew(1);
        FieldVector vec = mock(FieldVector.class);
        }
            assertEquals(30L, out.get("age"));
        }
        try (TimeStampMilliVector v = new TimeStampMilliVector("ts", allocator)) {
            assertEquals(2, out.size());
            v.allocateNew();
    public void testBigIntPassThroughUnchanged() {
        missing.setValueCount(1);
            v.setValueCount(1);
import java.util.Map;
            v.setValueCount(1);
    }
            w.startList();
        try (TimeStampNanoVector v = new TimeStampNanoVector("ts", allocator)) {
import org.apache.arrow.vector.IntVector;
    }
    }
            assertEquals("2026-06-06 07:40:05.123456", ArrowValues.toJavaValue(v, 0));
    }
    /** Standard timestamp vectors decode to LocalDateTime; toSourceValue renders that via toString() (ISO-8601, 'T' separator, no 'Z'). */
    public void testNullCellReturnsNull() {
import org.opensearch.test.OpenSearchTestCase;
            UnionListWriter w = v.getWriter();
    }
import org.apache.arrow.vector.types.pojo.FieldType;
    @Override
 * SPDX-License-Identifier: Apache-2.0
        }
            assertEquals("2026-06-06 07:40:05", ArrowValues.toJavaValue(v, 0));
        try (TimeSecVector v = new TimeSecVector("t", allocator)) {
            v.setSafe(0, "hello T world".getBytes(java.nio.charset.StandardCharsets.UTF_8));
            v.allocateNew(1);
import org.apache.arrow.memory.RootAllocator;
        Field child = new Field("item", FieldType.nullable(new ArrowType.Time(TimeUnit.MICROSECOND, 64)), null);
        }
            v.setSafe(0, "hello".getBytes(java.nio.charset.StandardCharsets.UTF_8));
        VarCharVector missing = new VarCharVector("missing", allocator);
    public void testToSourceValueTimestampLocalDateTimeToString() {
    }
            v.setSafe(0, "hello".getBytes(java.nio.charset.StandardCharsets.UTF_8));
        return ArrowValues.toSourceValue(vec, 0);
            v.setValueCount(1);
        try (TimeStampSecVector v = new TimeStampSecVector("ts", allocator)) {
            v.set(0, 27_605);
            v.set(0, 1_780_731_605L);
    }
            v.setValueCount(1);
            assertEquals("hello T world", ArrowValues.toJavaValue(v, 0));
        name.setSafe(0, "alice".getBytes(java.nio.charset.StandardCharsets.UTF_8));
 */
import org.apache.arrow.vector.BitVector;
 * this file be licensed under the Apache-2.0 license or a
            w.timeMicro().writeTimeMicro(27_605_000_000L);
            v.allocateNew(1);
        try (TimeNanoVector v = new TimeNanoVector("t", allocator)) {
import org.apache.arrow.vector.TimeMicroVector;
