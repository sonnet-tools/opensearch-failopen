        RowProducingSink sink = new RowProducingSink();
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, allocator);
        VectorSchemaRoot poison = makeVsr(List.of("id"), new Object[][] { { "1" } });
        assertFalse("over-limit batches are not buffered", it.hasNext());
import org.apache.arrow.memory.ArrowBuf;
        RowProducingSink sink = new RowProducingSink();
        assertEquals("close() must release every batch despite the mid-loop throw", 0, allocator.getAllocatedMemory());
        RowProducingSink sink = new RowProducingSink();
 *
        assertSame(r1, it.next());
        // Field names should come from the second batch
package org.opensearch.analytics.exec;
     * Once {@code totalRows} reaches {@code maxRows}, further batches are dropped (and closed)
    public void testUnlimitedSinkRetainsAllBatches() {
/*
    @Override
        VectorSchemaRoot r2 = makeVsr(List.of("id"), new Object[][] { { "3" } });
    }
    }
        assertEquals("result is capped at maxRows", 2, sink.getRowCount());
        RowProducingSink sink = new RowProducingSink();
        VectorSchemaRoot late = makeVsr(List.of("id"), new Object[][] { { "1" } });
    }
        assertEquals(2, sink.getRowCount());
        sink.feed(batch);
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();
        assertEquals("hello", sink.getValueAt("col1", 0).toString());
        assertFalse(it.hasNext());
import org.apache.arrow.memory.RootAllocator;
        VectorSchemaRoot batch = makeVsr(List.of("col1"), new Object[][] { { "only_row" } });
        assertFalse(it.hasNext());
        sink.close(); // must not propagate; must release the tail
        assertFalse("no batches retained after close", sink.readResult().iterator().hasNext());
    // ─── Helpers ────────────────────────────────────────────────────────
            for (int r = 0; r < rowCount; r++) {
    }
        // First batch has no fields (empty schema)
     * exceeding the limit returns a capped result rather than failing the whole request.
        assertEquals("late batch must not count toward rows", 0, sink.getRowCount());
import java.nio.charset.StandardCharsets;
    public void testFeedSingleBatch() {
        List<Field> fields = fieldNames.stream().map(name -> new Field(name, FieldType.nullable(ArrowType.Utf8.INSTANCE), null)).toList();
        sink.close();
        RowProducingSink sink = new RowProducingSink(2);
        sink.feed(batch);
import org.apache.arrow.memory.BufferAllocator;
        RowProducingSink sink = new RowProducingSink();
    /**
     * throw and must leave the allocator at zero. Guards the terminal-path double-close.
        RowProducingSink sink = new RowProducingSink();
        VectorSchemaRoot r2 = makeVsr(List.of("id"), new Object[][] { { "2" } });
    public void testGetValueAtValidColumnAndRow() {
        // negative" mid-loop — the exact throw that used to strand b2 and b3.
        assertEquals(0, allocator.getAllocatedMemory());
import org.apache.arrow.vector.types.pojo.Schema;
        for (ArrowBuf buf : v.getBuffers(false)) {
        VectorSchemaRoot r1 = makeVsr(List.of("id"), new Object[][] { { "1" } });
        sink.feed(withFields);
        sink.feed(late);
        VectorSchemaRoot r3 = makeVsr(List.of("id"), new Object[][] { { "4" } });
     * (close already cleared the list and will not run again, so a buffered batch would leak).
        // Second batch has field names
        assertEquals("y", sink.getValueAt("col_a", 0).toString());
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();
        assertEquals("late batch must be closed, not buffered", 0, allocator.getAllocatedMemory());
        assertTrue("b2/b3 (and the poison's remaining bufs) hold memory before sink close", before > 0);
        VectorSchemaRoot batch = makeVsr(List.of("col1", "col2"), new Object[][] { { "hello", "42" } });
     * limit", evaluated before each batch) — but the next batch is then dropped. This pins the
        RowProducingSink sink = new RowProducingSink();
        sink.close();
        VectorSchemaRoot r1 = makeVsr(List.of("id"), new Object[][] { { "1" }, { "2" } });
    public void testEmptySinkReturnsEmptyResult() {
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(2, sink.getRowCount());
     * after it, stranding their off-heap buffers on the long-lived coordinator allocator (the
        assertFalse(it.hasNext());
        sink.close();
        RowProducingSink sink = new RowProducingSink();
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to
        RowProducingSink sink = new RowProducingSink();
    // ─── Row-limit truncation (PR 6) ─────────────────────────────────────
     * rather than rejected — the sink truncates the result set instead of throwing, so a query
 * compatible open source license.
        assertEquals("the crossing batch is accepted in full", 3, sink.getRowCount());
    }
        sink.feed(batch);
        VectorSchemaRoot emptyBatch = VectorSchemaRoot.create(new Schema(List.of()), allocator);
                }
        super.tearDown();
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();
import org.apache.arrow.vector.VectorSchemaRoot;
        Schema schema = new Schema(fields);
    /**
        VectorSchemaRoot r2 = makeVsr(List.of("id"), new Object[][] { { "4" } });
 */
        long before = allocator.getAllocatedMemory();
import org.apache.arrow.vector.VarCharVector;
        assertNull(sink.getValueAt("col1", 5));
            buf.getReferenceManager().release();
import org.apache.arrow.vector.types.pojo.FieldType;
    public void testFieldNamesCapturedFromFirstNonEmptyBatch() {
import org.apache.arrow.vector.types.pojo.ArrowType;
     * exact boundary semantics so a future refactor can't silently change them.
        sink.close();
        VectorSchemaRoot r3 = makeVsr(List.of("id"), new Object[][] { { "3" } });
    public void testGetValueAtOutOfRangeRowReturnsNull() {
        VectorSchemaRoot r1 = makeVsr(List.of("id"), new Object[][] { { "1" } });
        return vsr;
    }
        super.setUp();
    /**
        assertFalse("nothing retained from a post-close feed", sink.readResult().iterator().hasNext());
        sink.feed(r2);
     * Regression for the coordinator-allocator leak: {@code close()} must free EVERY buffered
        sink.close();
        emptyBatch.setRowCount(0);
    }
    }
        assertSame("only the pre-limit batch is retained", r1, it.next());
        sink.feed(r1); // totalRows was 0 (< 2) → accepted whole, totalRows = 3 (overshoots)
/**
        allocator.close();
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();
    public void testFeedTruncatesAtMaxRowsInsteadOfThrowing() {
        vsr.allocateNew();
     * already released by, another close path (e.g. the ordinal-appending sink shares field vectors
        sink.feed(makeVsr(List.of("id"), new Object[][] { { "1" } }));
    /**
            VarCharVector vec = (VarCharVector) vsr.getVector(col);
        vsr.setRowCount(rowCount);
    @Override
        sink.close(); // must not throw
    // ─── close() releases the whole set even when a batch throws (coordinator leak fix) ──
        int rowCount = rows.length;
        sink.feed(r1);
    public void testGetValueAtUnknownColumnReturnsNull() {
    }
     * "query pool never goes down" symptom). Here the FIRST buffered batch is rigged to throw on
        assertSame(r3, it.next());
import org.apache.arrow.vector.types.pojo.Field;
        // Over-release the first batch's data buffer so its close() throws "RefCnt has gone
        assertTrue("batch holds buffers before the late feed", allocator.getAllocatedMemory() > 0);
        VectorSchemaRoot r2 = makeVsr(List.of("id"), new Object[][] { { "2" } });
        VectorSchemaRoot batch = makeVsr(List.of("name", "age"), new Object[][] { { "alice", "30" }, { "bob", "25" } });
        assertEquals(0, allocator.getAllocatedMemory());
    public void setUp() throws Exception {
public class RowProducingSinkTests extends OpenSearchTestCase {
    }
                Object value = rows[r][col];
        assertTrue(it.hasNext());
    // ─── Feed racing close (leak fix) ────────────────────────────────────
    }
     */
        assertSame(r1, it.next());
        sink.close();
     * over-released — the real production condition where a batch's vectors were shared with, and
                } else {
        sink.close();
        sink.close();
        assertEquals(3, sink.getRowCount());
        sink.feed(b3);
     */
        VectorSchemaRoot r1 = makeVsr(List.of("id"), new Object[][] { { "1" }, { "2" }, { "3" } });
        assertFalse(it.hasNext());
        sink.feed(r2); // totalRows 3 >= 2 → dropped
    }
        sink.close();
        sink.feed(emptyBatch);
import java.util.Iterator;
     * by reference). The pre-fix loop aborted on the first such throw and abandoned every batch
    public void tearDown() throws Exception {
        }
     * The accepting batch may overshoot {@code maxRows} (the check is "stop once at/over the
    public void testFeedMultipleBatchesPreservesOrder() {
import java.util.List;
        sink.feed(r2); // totalRows >= maxRows → dropped + closed, no throw
        sink.feed(r1);
        RowProducingSink sink = new RowProducingSink(Long.MAX_VALUE);
        sink.close();
        for (int col = 0; col < fieldNames.size(); col++) {
     */
        VectorSchemaRoot withFields = makeVsr(List.of("col_a"), new Object[][] { { "y" } });
        assertEquals("42", sink.getValueAt("col2", 0).toString());
    /**
        sink.feed(batch);
        sink.feed(poison);
        RowProducingSink sink = new RowProducingSink(2);
        assertSame(batch, it.next());
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();
     * A {@code feed} after {@code close} must free the batch immediately rather than buffer it
                    vec.setSafe(r, value.toString().getBytes(StandardCharsets.UTF_8));
     */
import org.apache.arrow.vector.FieldVector;
        assertSame(r2, it.next());
        RowProducingSink sink = new RowProducingSink();
        allocator = new RootAllocator();
    public void testFeedAcceptsBatchThatCrossesLimitThenStops() {
     * {@code maxRows = Long.MAX_VALUE} disables the cap — every batch is retained.
        VectorSchemaRoot b2 = makeVsr(List.of("id"), new Object[][] { { "2" } });
    public void testCloseReleasesAllBatchesWhenOneThrows() {
 */
     */
            }
        sink.close();
    }
        sink.feed(r3);
        sink.feed(b2);
                    vec.setNull(r);
    }
     * {@code close()} is idempotent: a second call after the batches are already freed must not
        sink.feed(r1); // totalRows = 2, reaches the limit
        assertEquals(0, sink.getRowCount());
        sink.feed(r3); // dropped + closed
     * batch even if one batch's {@code close()} throws. Arrow throws
        sink.feed(r2);
    }
    private VectorSchemaRoot makeVsr(List<String> fieldNames, Object[][] rows) {
        VectorSchemaRoot batch = makeVsr(List.of("col1"), new Object[][] { { "data" } });
     * close; the two after it must still be released.
    public void testFeedAfterCloseClosesBatchAndDoesNotBuffer() {
 * SPDX-License-Identifier: Apache-2.0
            vec.setValueCount(rowCount);
        }
        FieldVector v = poison.getVector(0);
    /**
                if (value == null) {
        VectorSchemaRoot b3 = makeVsr(List.of("id"), new Object[][] { { "3" } });
        assertNull(sink.getValueAt("nonexistent", 0));
    private BufferAllocator allocator;
}
     * {@code IllegalStateException("RefCnt has gone negative")} when a batch's underlying buffer was
    public void testCloseIsIdempotent() {
        sink.close();
 * Tests for {@link RowProducingSink}.
    }
     */
