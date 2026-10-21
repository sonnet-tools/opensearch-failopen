    /** An empty batch is not a schema to resolve against — it must not disable the gate. */
            ints.setSafe(index, (int) value);
    // ── the happy path ───────────────────────────────────────────────────
import org.opensearch.test.OpenSearchTestCase;
    /**
    private BufferAllocator allocator;
        allocator = new RootAllocator();
    /** Every supported type is read as a raw long: both timestamp units and {@code Int64}/{@code Int32}. */
        return new Schema(List.of(new Field(column, FieldType.nullable(type), null)));
    private static final ArrowType NANOS = new ArrowType.Timestamp(TimeUnit.NANOSECOND, null);
        super.setUp();
    public void testDisabledGateStopsReading() {
            assertFalse("two keys is not yet K", gate.isArmed());
            assertFalse(type + " must be readable", gate.isDisabled());
 * {@link TopNGate#feed} — reading a shard stream's Arrow batches into the heap, and the data-only
        assertFalse("and nothing was observed", gate.isArmed());
 * this file be licensed under the Apache-2.0 license or a
        }
    private VectorSchemaRoot millisBatchWithNull() {
        vector.setSafe(0, 1L);
        } else if (vector instanceof BigIntVector longs) {
        } else if (vector instanceof TimeStampNanoVector nanos) {
        vector.setNull(1);
            throw new AssertionError("no setter wired for " + vector.getClass().getSimpleName());
import org.apache.arrow.vector.VarCharVector;
        assertFalse("but nothing was observed, so the gate cannot arm", gate.isArmed());
            strings.setSafe(0, "not a timestamp".getBytes(StandardCharsets.UTF_8));
        }
        assertFalse("an unreadable type is not a reason to retire the gate", gate.isDisabled());
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema("something_else", MILLIS), allocator)) {
            TopNGate gate = new TopNGate(1, true, COLUMN);
import org.apache.arrow.memory.RootAllocator;
import org.apache.arrow.vector.types.pojo.Field;
import org.apache.arrow.memory.BufferAllocator;
/**
            assertFalse("an empty batch is not a disagreement", gate.isDisabled());
        assertTrue(gate.isArmed());
    }
import org.apache.arrow.vector.TimeStampNanoVector;
            gate.feed(empty);
        TopNGate gate = new TopNGate(1, true, COLUMN);
import org.apache.arrow.vector.types.TimeUnit;
            gate.feed(clean);
        for (ArrowType type : List.of(MILLIS, NANOS, INT64, INT32)) {
            setLong(vector, i, values[i]);
        TopNGate gate = new TopNGate(1, true, COLUMN);
            gate.feed(root);
    }
    }
        } else if (vector instanceof IntVector ints) {
import org.apache.arrow.vector.VectorSchemaRoot;
        TopNGate gate = new TopNGate(3, true, COLUMN);
        }
            vector.setSafe(0, 42L);
        assertTrue("all four keys observed, so the heap is full", gate.isArmed());
            gate.feed(root);
            VarCharVector strings = (VarCharVector) root.getVector(0);
        }
            gate.feed(root);
import org.apache.arrow.vector.types.pojo.Schema;
import org.apache.arrow.vector.types.pojo.FieldType;
 * compatible open source license.
            try (VectorSchemaRoot root = batch(type, 5L)) {
            TimeStampMilliVector vector = (TimeStampMilliVector) root.getVector(0);
    }
            vector.setValueCount(1);
    }
        root.setRowCount(values.length);
            root.setRowCount(1);
            assertEquals(type + " read the raw value", 5L, gate.bottom());
    }
        root.setRowCount(2);
            root.setRowCount(1);
        }
    public void testAbsentColumnDisablesTheGate() {
        try (VectorSchemaRoot first = batch(MILLIS, 100L, 98L); VectorSchemaRoot second = batch(MILLIS, 95L, 12L)) {
 * checks that retire the gate. Separate from {@link TopNGateTests}, which drives {@code offer} directly.
 */
    /** Arrow has no shared long-valued setter, so dispatch on the concrete class as {@code readInto} does. */
    /**
import org.apache.arrow.vector.TimeStampMilliVector;
        return root;
     * ({@code DESC} is {@code NULLS FIRST}). That retires the gate for good — no later batch undoes it.
import java.util.List;
}
        assertEquals("bar is the 3rd-best of {100,98,95,12}", 95L, gate.bottom());
/*
import java.nio.charset.StandardCharsets;
    /** Every row of every batch reaches the gate, so the bar is the K-th best across all of them. */
package org.opensearch.analytics.exec.canmatch;
            gate.feed(first);
    public void testEmptyBatchIsSkippedWithoutResolvingTheColumn() {
    /** A gate disabled by one stream's batch stops reading for every other stream too. */
        gate.disable();
            assertTrue("nulls the bounds did not report disable the gate", gate.isDisabled());
    }
 *
        try (VectorSchemaRoot root = VectorSchemaRoot.create(schema(COLUMN, new ArrowType.Utf8()), allocator)) {
     */
            gate.feed(withNull);
import org.apache.arrow.vector.types.pojo.ArrowType;
        try (VectorSchemaRoot withNull = millisBatchWithNull(); VectorSchemaRoot clean = batch(MILLIS, 2L)) {
            assertFalse("nothing observed yet", gate.isArmed());
            gate.feed(real);
        VectorSchemaRoot root = VectorSchemaRoot.create(schema(COLUMN, MILLIS), allocator);
            nanos.setSafe(index, value);
        vector.setValueCount(values.length);
        }
    private static final ArrowType INT32 = new ArrowType.Int(32, true);
    public void tearDown() throws Exception {
        } else {
    /** A single-column {@code @timestamp} batch of {@code type}. */
        }
                gate.feed(root);
            longs.setSafe(index, value);
    @Override
        FieldVector vector = root.getVector(0);
    /** One real key and one null — the shape that retires the gate. */
    /** The sort column is projected away: with nothing to observe, retire the gate rather than arm on partial data. */
    }
    private static final ArrowType INT64 = new ArrowType.Int(64, true);
        TopNGate gate = new TopNGate(1, true, COLUMN);
        for (int i = 0; i < values.length; i++) {
    private VectorSchemaRoot batch(ArrowType type, long... values) {
import org.apache.arrow.vector.IntVector;
            gate.feed(second);
import org.apache.arrow.vector.FieldVector;
    // ── the checks that protect correctness ──────────────────────────────
        vector.setValueCount(2);
            millis.setSafe(index, value);
    }
        return root;
     * nothing — fail-open, without retiring.
 */
     */
    public void testReadsEverySupportedVectorType() {
        try (VectorSchemaRoot empty = batch(MILLIS); VectorSchemaRoot real = batch(MILLIS, 7L)) {
        if (vector instanceof TimeStampMilliVector millis) {
            assertFalse("and no key from that batch was admitted", gate.isArmed());
        VectorSchemaRoot root = VectorSchemaRoot.create(schema(COLUMN, type), allocator);
        assertEquals(7L, gate.bottom());
    public void setUp() throws Exception {
    private static void setLong(FieldVector vector, int index, long value) {
     * A null in the data contradicts the bounds' no-nulls claim, which elimination relies on
     * A type {@code readInto} can't read contributes nothing, so the gate stays unarmed and eliminates
            assertTrue("still disabled", gate.isDisabled());
        TopNGate gate = new TopNGate(1, true, COLUMN);
    // ── helpers ──────────────────────────────────────────────────────────
    }
    private static Schema schema(String column, ArrowType type) {
            assertTrue(type + " must arm the gate", gate.isArmed());
        TimeStampMilliVector vector = (TimeStampMilliVector) root.getVector(0);
    public void testNullsInTheDataDisableTheGateForGood() {
        assertFalse("a disabled gate admits nothing", gate.isArmed());
        }
    @Override
        try (VectorSchemaRoot root = batch(MILLIS, 5L)) {
    private static final String COLUMN = "@timestamp";
    }
 * The OpenSearch Contributors require contributions made to
            strings.setValueCount(1);
        super.tearDown();
        assertTrue("a missing sort column disables the gate", gate.isDisabled());
        TopNGate gate = new TopNGate(1, true, COLUMN);
    private static final ArrowType MILLIS = new ArrowType.Timestamp(TimeUnit.MILLISECOND, null);
import org.apache.arrow.vector.BigIntVector;
public class TopNGateFeedTests extends OpenSearchTestCase {
            assertFalse("feed() is a no-op once retired, so nothing armed", gate.isArmed());
    }
    public void testUnreadableVectorTypeIsSilentlyIgnored() {
            }
        }
    }
        allocator.close();
 * SPDX-License-Identifier: Apache-2.0
    public void testFeedsEveryRowAcrossBatches() {
