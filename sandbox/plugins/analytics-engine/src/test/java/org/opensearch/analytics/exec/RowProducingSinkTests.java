    }
        // negative" mid-loop — the exact throw that used to strand b2 and b3.
        assertNull(sink.getValueAt("nonexistent", 0));  
    }
        sink.feed(r1); // totalRows was 0 (< 2) → accepted whole, totalRows = 3 (overshoots)  
        allocator = new RootAllocator();  
    // ─── Feed racing close (leak fix) ────────────────────────────────────  
            VarCharVector vec = (VarCharVector) vsr.getVector(col);  
        sink.feed(emptyBatch);  
        sink.feed(batch);
     * already released by, another close path (e.g. the ordinal-appending sink shares field vectors  
     * exceeding the limit returns a capped result rather than failing the whole request.
        assertFalse("no batches retained after close", sink.readResult().iterator().hasNext());
        for (ArrowBuf buf : v.getBuffers(false)) {
    public void testUnlimitedSinkRetainsAllBatches() {
import org.apache.arrow.memory.RootAllocator;  
        // Field names should come from the second batch  
        RowProducingSink sink = new RowProducingSink();  
        allocator.close();
        assertTrue(it.hasNext());
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();  
     */
        Schema schema = new Schema(fields);
        assertSame(r1, it.next());
        assertEquals("result is capped at maxRows", 2, sink.getRowCount());
        RowProducingSink sink = new RowProducingSink(2);
    }  
    /**
        VectorSchemaRoot r1 = makeVsr(List.of("id"), new Object[][] { { "1" } });  
            buf.getReferenceManager().release();
    }
        assertFalse(it.hasNext());
        VectorSchemaRoot batch = makeVsr(List.of("col1", "col2"), new Object[][] { { "hello", "42" } });  
        assertEquals("the crossing batch is accepted in full", 3, sink.getRowCount());  
        // Over-release the first batch's data buffer so its close() throws "RefCnt has gone
 * Tests for {@link RowProducingSink}.  
     * (close already cleared the list and will not run again, so a buffered batch would leak).
        vsr.allocateNew();  
        super.setUp();
        RowProducingSink sink = new RowProducingSink();
        RowProducingSink sink = new RowProducingSink();
        sink.close();
        sink.feed(late);
        sink.feed(b3);
import org.apache.arrow.memory.ArrowBuf;
    public void testFeedAfterCloseClosesBatchAndDoesNotBuffer() {  
        List<Field> fields = fieldNames.stream().map(name -> new Field(name, FieldType.nullable(ArrowType.Utf8.INSTANCE), null)).toList();  
    }  
import org.apache.arrow.vector.types.pojo.Field;
import java.nio.charset.StandardCharsets;
    }  
     * batch even if one batch's {@code close()} throws. Arrow throws  
    // ─── Helpers ────────────────────────────────────────────────────────  
        assertTrue("batch holds buffers before the late feed", allocator.getAllocatedMemory() > 0);
     */
     * by reference). The pre-fix loop aborted on the first such throw and abandoned every batch
        assertEquals(0, sink.getRowCount());
        VectorSchemaRoot r1 = makeVsr(List.of("id"), new Object[][] { { "1" } });
    private BufferAllocator allocator;
    }
        emptyBatch.setRowCount(0);
     * after it, stranding their off-heap buffers on the long-lived coordinator allocator (the
        assertSame("only the pre-limit batch is retained", r1, it.next());
    }
        RowProducingSink sink = new RowProducingSink();
        sink.close();  
        sink.feed(batch);
        VectorSchemaRoot r2 = makeVsr(List.of("id"), new Object[][] { { "2" } });  
        super.tearDown();  
        assertEquals("42", sink.getValueAt("col2", 0).toString());
        assertFalse("nothing retained from a post-close feed", sink.readResult().iterator().hasNext());
        VectorSchemaRoot r1 = makeVsr(List.of("id"), new Object[][] { { "1" }, { "2" }, { "3" } });  
        VectorSchemaRoot b3 = makeVsr(List.of("id"), new Object[][] { { "3" } });
        assertEquals(3, sink.getRowCount());
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, allocator);
import java.util.List;  
        assertEquals(0, allocator.getAllocatedMemory());  
        RowProducingSink sink = new RowProducingSink();
        sink.close(); // must not propagate; must release the tail
                if (value == null) {  
        VectorSchemaRoot r3 = makeVsr(List.of("id"), new Object[][] { { "3" } });
    public void tearDown() throws Exception {
        sink.feed(batch);  
                Object value = rows[r][col];
     * {@code close()} is idempotent: a second call after the batches are already freed must not
        VectorSchemaRoot r1 = makeVsr(List.of("id"), new Object[][] { { "1" }, { "2" } });  
     */
    public void testFeedSingleBatch() {  
        sink.close();  
        vsr.setRowCount(rowCount);
        VectorSchemaRoot batch = makeVsr(List.of("col1"), new Object[][] { { "data" } });  
        RowProducingSink sink = new RowProducingSink();
        assertEquals("hello", sink.getValueAt("col1", 0).toString());  
        VectorSchemaRoot r2 = makeVsr(List.of("id"), new Object[][] { { "3" } });
        assertEquals(2, sink.getRowCount());  
        assertEquals("y", sink.getValueAt("col_a", 0).toString());
     * A {@code feed} after {@code close} must free the batch immediately rather than buffer it  
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();
        assertEquals(2, sink.getRowCount());
        assertTrue("b2/b3 (and the poison's remaining bufs) hold memory before sink close", before > 0);
    public void testFeedMultipleBatchesPreservesOrder() {  
        VectorSchemaRoot late = makeVsr(List.of("id"), new Object[][] { { "1" } });
    public void testFieldNamesCapturedFromFirstNonEmptyBatch() {  
        RowProducingSink sink = new RowProducingSink();  
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();
        sink.feed(r2); // totalRows >= maxRows → dropped + closed, no throw
        sink.feed(b2);
                    vec.setNull(r);
import org.apache.arrow.vector.VarCharVector;
        sink.close();
     * The accepting batch may overshoot {@code maxRows} (the check is "stop once at/over the
        RowProducingSink sink = new RowProducingSink(Long.MAX_VALUE);  
        sink.feed(r1);
        assertFalse(it.hasNext());  
        sink.close();
        FieldVector v = poison.getVector(0);  
        VectorSchemaRoot batch = makeVsr(List.of("col1"), new Object[][] { { "only_row" } });
    public void testCloseReleasesAllBatchesWhenOneThrows() {  
        sink.feed(r2); // totalRows 3 >= 2 → dropped
    }
        VectorSchemaRoot r2 = makeVsr(List.of("id"), new Object[][] { { "4" } });
    }
import org.apache.arrow.memory.BufferAllocator;
    public void testFeedAcceptsBatchThatCrossesLimitThenStops() {  
        sink.feed(r2);
    }
    public void testGetValueAtUnknownColumnReturnsNull() {  
        sink.close();
        sink.close();  
        sink.feed(poison);  
        RowProducingSink sink = new RowProducingSink(2);
    }
     * "query pool never goes down" symptom). Here the FIRST buffered batch is rigged to throw on  
    public void testCloseIsIdempotent() {
 */
        sink.close();
        sink.close();  
        sink.feed(r3); // dropped + closed  
import org.apache.arrow.vector.types.pojo.FieldType;  
import org.apache.arrow.vector.types.pojo.ArrowType;
import java.util.Iterator;
        assertEquals(0, allocator.getAllocatedMemory());
        VectorSchemaRoot b2 = makeVsr(List.of("id"), new Object[][] { { "2" } });
    @Override  
        sink.feed(withFields);
        sink.close();
        // Second batch has field names
    // ─── close() releases the whole set even when a batch throws (coordinator leak fix) ──
        assertEquals("late batch must not count toward rows", 0, sink.getRowCount());
        sink.feed(batch);
        VectorSchemaRoot withFields = makeVsr(List.of("col_a"), new Object[][] { { "y" } });  
        sink.close();  
                    vec.setSafe(r, value.toString().getBytes(StandardCharsets.UTF_8));  
     */
    }
        assertSame(r1, it.next());
        assertSame(r2, it.next());
    /**
        VectorSchemaRoot batch = makeVsr(List.of("name", "age"), new Object[][] { { "alice", "30" }, { "bob", "25" } });  
        assertEquals("late batch must be closed, not buffered", 0, allocator.getAllocatedMemory());  
        sink.feed(r1);
 * this file be licensed under the Apache-2.0 license or a
 *
        sink.close(); // must not throw
 * compatible open source license.
    /**
/*  
        VectorSchemaRoot r3 = makeVsr(List.of("id"), new Object[][] { { "4" } });
    /**
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();  
     * rather than rejected — the sink truncates the result set instead of throwing, so a query  
            vec.setValueCount(rowCount);  
    private VectorSchemaRoot makeVsr(List<String> fieldNames, Object[][] rows) {
                }
     */
     * close; the two after it must still be released.
     * limit", evaluated before each batch) — but the next batch is then dropped. This pins the  
        sink.feed(r3);  
        }  
        assertSame(batch, it.next());  
public class RowProducingSinkTests extends OpenSearchTestCase {
        RowProducingSink sink = new RowProducingSink();
        long before = allocator.getAllocatedMemory();
package org.opensearch.analytics.exec;
    public void testGetValueAtValidColumnAndRow() {  
     * over-released — the real production condition where a batch's vectors were shared with, and
     * throw and must leave the allocator at zero. Guards the terminal-path double-close.  
     * {@code maxRows = Long.MAX_VALUE} disables the cap — every batch is retained.  
    }
import org.apache.arrow.vector.VectorSchemaRoot;  
}
    public void testFeedTruncatesAtMaxRowsInsteadOfThrowing() {  
        // First batch has no fields (empty schema)  
     * exact boundary semantics so a future refactor can't silently change them.
    /**
        RowProducingSink sink = new RowProducingSink();
        sink.feed(r1); // totalRows = 2, reaches the limit
        for (int col = 0; col < fieldNames.size(); col++) {
/**
        assertFalse(it.hasNext());
            for (int r = 0; r < rowCount; r++) {
     * Regression for the coordinator-allocator leak: {@code close()} must free EVERY buffered
    /**
        Iterator<VectorSchemaRoot> it = sink.readResult().iterator();
import org.apache.arrow.vector.FieldVector;
    public void testEmptySinkReturnsEmptyResult() {
     * {@code IllegalStateException("RefCnt has gone negative")} when a batch's underlying buffer was
    // ─── Row-limit truncation (PR 6) ─────────────────────────────────────
        assertNull(sink.getValueAt("col1", 5));
    public void testGetValueAtOutOfRangeRowReturnsNull() {
        assertEquals("close() must release every batch despite the mid-loop throw", 0, allocator.getAllocatedMemory());  
        sink.feed(makeVsr(List.of("id"), new Object[][] { { "1" } }));
    }  
import org.apache.arrow.vector.types.pojo.Schema;
        VectorSchemaRoot poison = makeVsr(List.of("id"), new Object[][] { { "1" } });  
        assertFalse(it.hasNext());  
    @Override  
    public void setUp() throws Exception {
 * The OpenSearch Contributors require contributions made to  
    }
                } else {
        VectorSchemaRoot r2 = makeVsr(List.of("id"), new Object[][] { { "2" } });
import org.opensearch.test.OpenSearchTestCase;
 * SPDX-License-Identifier: Apache-2.0
        assertSame(r3, it.next());  
     */
     * Once {@code totalRows} reaches {@code maxRows}, further batches are dropped (and closed)
        }
        sink.feed(r2);  
        return vsr;  
        VectorSchemaRoot emptyBatch = VectorSchemaRoot.create(new Schema(List.of()), allocator);
        sink.close();  
 */  
            }
        assertFalse("over-limit batches are not buffered", it.hasNext());
        int rowCount = rows.length;
        RowProducingSink sink = new RowProducingSink();
