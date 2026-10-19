    // ── the happy path ───────────────────────────────────────────────────
            vector.setValueCount(1);
import org.apache.arrow.vector.FieldVector;
public class TopNGateFeedTests extends OpenSearchTestCase {  
    }  
        VectorSchemaRoot root = VectorSchemaRoot.create(schema(COLUMN, MILLIS), allocator);
        }  
        TimeStampMilliVector vector = (TimeStampMilliVector) root.getVector(0);
        allocator = new RootAllocator();
        }
    public void testEmptyBatchIsSkippedWithoutResolvingTheColumn() {
    private static Schema schema(String column, ArrowType type) {
    public void testAbsentColumnDisablesTheGate() {
    private static final ArrowType MILLIS = new ArrowType.Timestamp(TimeUnit.MILLISECOND, null);
import org.apache.arrow.vector.types.pojo.Schema;
    @Override
import org.apache.arrow.vector.BigIntVector;  
     * nothing — fail-open, without retiring.  
            nanos.setSafe(index, value);
import org.apache.arrow.vector.types.pojo.ArrowType;
            millis.setSafe(index, value);
        vector.setNull(1);
            gate.feed(first);  
    }  
/**
 * checks that retire the gate. Separate from {@link TopNGateTests}, which drives {@code offer} directly.
        vector.setValueCount(2);
    private static final String COLUMN = "@timestamp";
        }
            gate.feed(second);
    }  
        return root;
        TopNGate gate = new TopNGate(1, true, COLUMN);
    /** Every supported type is read as a raw long: both timestamp units and {@code Int64}/{@code Int32}. */  
import org.apache.arrow.vector.VarCharVector;
 *
            TimeStampMilliVector vector = (TimeStampMilliVector) root.getVector(0);
        return root;
        assertEquals(7L, gate.bottom());  
        }
            gate.feed(withNull);
    private static final ArrowType INT32 = new ArrowType.Int(32, true);
        }
        TopNGate gate = new TopNGate(3, true, COLUMN);  
        TopNGate gate = new TopNGate(1, true, COLUMN);
    /**
package org.opensearch.analytics.exec.canmatch;
            vector.setSafe(0, 42L);  
        assertTrue("all four keys observed, so the heap is full", gate.isArmed());
/*  
    /** One real key and one null — the shape that retires the gate. */
import org.apache.arrow.vector.IntVector;
            gate.feed(empty);
    // ── the checks that protect correctness ──────────────────────────────
    }
    }
    public void testNullsInTheDataDisableTheGateForGood() {  
            root.setRowCount(1);
            ints.setSafe(index, (int) value);
        assertTrue(gate.isArmed());
     */
        TopNGate gate = new TopNGate(1, true, COLUMN);
     * A null in the data contradicts the bounds' no-nulls claim, which elimination relies on  
    }  
        FieldVector vector = root.getVector(0);
            assertTrue("nulls the bounds did not report disable the gate", gate.isDisabled());
    }
    /** A single-column {@code @timestamp} batch of {@code type}. */
        super.tearDown();
        return new Schema(List.of(new Field(column, FieldType.nullable(type), null)));
    private BufferAllocator allocator;  
import org.apache.arrow.memory.RootAllocator;
        vector.setSafe(0, 1L);  
    public void testUnreadableVectorTypeIsSilentlyIgnored() {
            assertEquals(type + " read the raw value", 5L, gate.bottom());  
    // ── helpers ──────────────────────────────────────────────────────────
    public void testReadsEverySupportedVectorType() {
        root.setRowCount(2);  
            TopNGate gate = new TopNGate(1, true, COLUMN);  
    /** Arrow has no shared long-valued setter, so dispatch on the concrete class as {@code readInto} does. */
        try (VectorSchemaRoot root = batch(MILLIS, 5L)) {
import org.apache.arrow.vector.TimeStampNanoVector;
            VarCharVector strings = (VarCharVector) root.getVector(0);  
    public void tearDown() throws Exception {  
import java.nio.charset.StandardCharsets;
        TopNGate gate = new TopNGate(1, true, COLUMN);  
            assertFalse("and no key from that batch was admitted", gate.isArmed());  
        TopNGate gate = new TopNGate(1, true, COLUMN);
    }  
        assertEquals("bar is the 3rd-best of {100,98,95,12}", 95L, gate.bottom());  
            assertTrue("still disabled", gate.isDisabled());  
import org.opensearch.test.OpenSearchTestCase;  
        } else {  
    /** The sort column is projected away: with nothing to observe, retire the gate rather than arm on partial data. */  
}  
            strings.setSafe(0, "not a timestamp".getBytes(StandardCharsets.UTF_8));
        assertFalse("but nothing was observed, so the gate cannot arm", gate.isArmed());
 * {@link TopNGate#feed} — reading a shard stream's Arrow batches into the heap, and the data-only  
     * A type {@code readInto} can't read contributes nothing, so the gate stays unarmed and eliminates
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema(COLUMN, new ArrowType.Utf8()), allocator)) {
            longs.setSafe(index, value);  
    /** An empty batch is not a schema to resolve against — it must not disable the gate. */  
import org.apache.arrow.vector.types.pojo.FieldType;
    private static void setLong(FieldVector vector, int index, long value) {  
        super.setUp();
    public void setUp() throws Exception {  
            assertFalse("two keys is not yet K", gate.isArmed());
        gate.disable();
            assertFalse(type + " must be readable", gate.isDisabled());
     * ({@code DESC} is {@code NULLS FIRST}). That retires the gate for good — no later batch undoes it.
            gate.feed(real);
 * The OpenSearch Contributors require contributions made to  
            assertFalse("nothing observed yet", gate.isArmed());  
import java.util.List;  
        VectorSchemaRoot root = VectorSchemaRoot.create(schema(COLUMN, type), allocator);
            try (VectorSchemaRoot root = batch(type, 5L)) {
        }  
 */
            strings.setValueCount(1);
            assertFalse("feed() is a no-op once retired, so nothing armed", gate.isArmed());
    public void testDisabledGateStopsReading() {  
    /** Every row of every batch reaches the gate, so the bar is the K-th best across all of them. */
    private static final ArrowType INT64 = new ArrowType.Int(64, true);  
 */  
        assertFalse("an unreadable type is not a reason to retire the gate", gate.isDisabled());
        try (VectorSchemaRoot withNull = millisBatchWithNull(); VectorSchemaRoot clean = batch(MILLIS, 2L)) {  
 * SPDX-License-Identifier: Apache-2.0
        }
 * compatible open source license.
        assertFalse("a disabled gate admits nothing", gate.isArmed());
        }  
            gate.feed(root);
    }  
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema("something_else", MILLIS), allocator)) {
            }  
    private VectorSchemaRoot millisBatchWithNull() {  
        } else if (vector instanceof TimeStampNanoVector nanos) {  
            gate.feed(root);
        try (VectorSchemaRoot empty = batch(MILLIS); VectorSchemaRoot real = batch(MILLIS, 7L)) {
            assertTrue(type + " must arm the gate", gate.isArmed());
        allocator.close();
        for (int i = 0; i < values.length; i++) {  
        vector.setValueCount(values.length);  
        try (VectorSchemaRoot first = batch(MILLIS, 100L, 98L); VectorSchemaRoot second = batch(MILLIS, 95L, 12L)) {
    @Override
    public void testFeedsEveryRowAcrossBatches() {
        assertTrue("a missing sort column disables the gate", gate.isDisabled());  
import org.apache.arrow.vector.TimeStampMilliVector;  
     */
        } else if (vector instanceof IntVector ints) {
    }
    private VectorSchemaRoot batch(ArrowType type, long... values) {  
import org.apache.arrow.vector.types.TimeUnit;
import org.apache.arrow.memory.BufferAllocator;
        } else if (vector instanceof BigIntVector longs) {
    private static final ArrowType NANOS = new ArrowType.Timestamp(TimeUnit.NANOSECOND, null);
            gate.feed(clean);
        if (vector instanceof TimeStampMilliVector millis) {
import org.apache.arrow.vector.VectorSchemaRoot;  
        for (ArrowType type : List.of(MILLIS, NANOS, INT64, INT32)) {
            throw new AssertionError("no setter wired for " + vector.getClass().getSimpleName());
            root.setRowCount(1);  
            assertFalse("an empty batch is not a disagreement", gate.isDisabled());
        }
    /**
            gate.feed(root);  
    }  
    /** A gate disabled by one stream's batch stops reading for every other stream too. */
        assertFalse("and nothing was observed", gate.isArmed());
 * this file be licensed under the Apache-2.0 license or a
    }  
            setLong(vector, i, values[i]);
                gate.feed(root);
        root.setRowCount(values.length);
import org.apache.arrow.vector.types.pojo.Field;  
    }
