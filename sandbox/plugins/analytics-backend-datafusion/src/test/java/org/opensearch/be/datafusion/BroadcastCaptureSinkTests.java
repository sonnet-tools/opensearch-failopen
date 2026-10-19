            assertTrue("empty-capture stream should still have IPC header", bytes.length > 0);
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 4L, 5L }));  
    public void testEmptyFirstBatchDoesNotSnapEmptySchema() throws Exception {
            try (
                assertFalse("empty-capture stream must have zero batches", reader.loadNextBatch());
     * (produced for a null shard payload), the sink must NOT snap the empty schema as the
    /**  
import org.apache.arrow.vector.types.pojo.Field;  
            try (
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
            sink.feed(empty1);
            assertEquals(List.of(1L, 2L, 3L, 4L, 5L), observed);  
            try {  
    }  
    public void testByteCapPassesWhenUnderLimit() throws Exception {  
            }
package org.opensearch.be.datafusion;
            // Simulate a null-payload shard response: zero-column root from a fresh Schema.
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc, longSchema());
        }  
                    "fallback schema must override the phantom-batch's empty schema",  
            ) {
                );
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
        }
            } catch (java.util.concurrent.ExecutionException ee) {  
            try (  
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);  
                int batchIdx = 0;
public class BroadcastCaptureSinkTests extends OpenSearchTestCase {
                    longSchema().getFields(),  
    public void testFeedAfterCloseThrows() throws Exception {  
            assertNotNull(bytes);
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            sink.feed(empty2);
     * the real schema, and the empty batch is skipped during serialization.  
    }
                    reader.getVectorSchemaRoot().getSchema().getFields()
                    ee.getCause() instanceof BroadcastSizeExceededException  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
/*  
     * join's NamedScan binds correctly (yielding zero matches for INNER joins).  
        root.setRowCount(vals.length);
     * Regression: when the first fed batch is a zero-column {@link VectorSchemaRoot}  
            sink.feed(emptyRoot);
import java.util.concurrent.TimeUnit;  
            phantom.setRowCount(0);  
            v.setSafe(i, vals[i]);
import org.apache.arrow.vector.types.pojo.Schema;
            sink.close(); // no batches at all
    public void testFallbackSchemaUsedWhenAllPhantomBatches() throws Exception {
            ) {  
            VectorSchemaRoot empty1 = VectorSchemaRoot.create(new Schema(List.of()), alloc);  
                    }
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
     * failure through the terminal listener.  
            ) {  
    public void testFallbackSchemaUsedWhenNoRealBatches() throws Exception {
                assertFalse(reader.loadNextBatch());
            // Roundtrip — decode the IPC stream and confirm we get two batches with the expected values.
                assertEquals(2, v.getValueCount());
            sink.feed(phantom);
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
            // Generous cap.
            assertTrue(bytes.length > 0);  
    private static Schema longSchema() {
    private static VectorSchemaRoot makeBatch(RootAllocator alloc, Schema schema, long[] vals) {
                );  
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
        }  
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
     * and zero record batches are emitted — same correct behavior as the all-empty case.  
                assertFalse("all-empty feed must produce zero batches", reader.loadNextBatch());  
 */
            }
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
    public void testCloseWithoutFeedProducesHeaderOnlyStream() throws Exception {
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 1L, 2L, 3L }));
    public void testAllEmptyBatchesYieldsHeaderOnlyStream() throws Exception {  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
    /**  
     */
     * Regression: when the build stage emits no real batches at all, the sink  
    public void testFeedThenCloseProducesIpcBytes() throws Exception {
    }
        }
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
 *
                assertEquals(
     * Cap not exceeded: a tiny batch under the limit succeeds normally.
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
                );
 */  
                assertEquals("expected 2 roundtripped batches", 2, batchIdx);
                    BigIntVector v = (BigIntVector) root.getVector("x");
import org.apache.arrow.vector.VectorSchemaRoot;  
        }
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {  
     * future with {@link BroadcastSizeExceededException} so the dispatcher can route the
     */
            sink.close();
     */
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);  
            assertTrue("under-cap broadcast must produce IPC bytes", bytes.length > 0);
            sink.close();
 * compatible open source license.
    }
        }  
}  
            ) {  
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
     * payloads), the sink produces a header-only stream with an empty schema. The broadcast  
                    batchIdx++;
            sink.close();  
    }
            empty1.setRowCount(0);
                while (reader.loadNextBatch()) {
        }
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
/**
     * The probe-side handler then registers a memtable with the right column types and the
            try (
                sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
            }  
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
    /**
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);  
                fail("expected BroadcastSizeExceededException");
            ) {
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);  
                    VectorSchemaRoot root = reader.getVectorSchemaRoot();  
 * The OpenSearch Contributors require contributions made to  
                }  
        v.allocateNew(vals.length);
import org.apache.arrow.memory.RootAllocator;
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
 * SPDX-License-Identifier: Apache-2.0
    public void testCloseIsIdempotent() throws Exception {
    /**
import org.apache.arrow.vector.types.pojo.FieldType;
            // Second shard has real data.  
            sink.close();
                    longSchema().getFields(),
     */
                assertTrue(
            }
    }  
     */
            }
            sink.close();
            VectorSchemaRoot phantom = VectorSchemaRoot.create(new Schema(List.of()), alloc);
 * Tests for {@link BroadcastCaptureSink}. No native deps — pure Arrow IPC round-trip.  
            }
                    reader.getVectorSchemaRoot().getSchema().getFields()
                    "fallback schema must propagate to the IPC header",  
    }  
            try (  
import java.util.List;
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
    /**
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc, longSchema());
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, alloc);  
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 1L, 2L, 3L }));  
                        observed.add(v.get(i));  
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);  
            ) {
        v.setValueCount(vals.length);  
        }  
     * broadcast schema. A later non-empty batch from another shard upgrades the snapshot to
     */
    }
            try (  
                    "roundtripped schema must be the long schema, not empty",
            VectorSchemaRoot emptyRoot = VectorSchemaRoot.create(new Schema(List.of()), alloc);  
    }  
    public void testByteCapFailsFutureWhenExceeded() throws Exception {
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
            sink.close(); // no-op, must not throw
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
import org.apache.arrow.vector.types.pojo.ArrowType;
                );  
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 42L }));
import org.apache.arrow.vector.ipc.ArrowStreamReader;
                assertEquals(7L, v.get(0));  
                assertFalse("only one non-empty batch", reader.loadNextBatch());
                assertEquals(
    }
            // Roundtrip must see the real schema and the real batch.
            // Tiny cap: a single 3-row long batch (~24 bytes data + buffer overhead) easily exceeds it.
import org.opensearch.test.OpenSearchTestCase;
    }
        }
        }
                    for (int i = 0; i < v.getValueCount(); i++) {
     * shard payload, the fallback schema wins. The IPC header carries the real build schema
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)  
import java.util.ArrayList;
     * Regression: if every fed batch is empty-schema (the whole build side had null
import org.opensearch.analytics.spi.BroadcastSizeExceededException;  
     * must use the explicit fallback schema in the IPC header — not {@code Schema(List.of())}.
                assertTrue("first batch loads", reader.loadNextBatch());  
            emptyRoot.setRowCount(0);
                    "cause must be BroadcastSizeExceededException, was: " + ee.getCause(),
        return new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
     * Regression: even when every fed batch is a zero-column phantom from a null
        for (int i = 0; i < vals.length; i++) {  
import java.io.ByteArrayInputStream;  
            List<Long> observed = new ArrayList<>();
                assertFalse(reader.loadNextBatch());
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
            }
                assertEquals(8L, v.get(1));
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)  
            sink.close();
        return root;
            VectorSchemaRoot empty2 = VectorSchemaRoot.create(new Schema(List.of()), alloc);  
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 1L, 2L, 3L }));
                BigIntVector v = (BigIntVector) reader.getVectorSchemaRoot().getVector("x");
     * Runtime byte cap: when accumulated buffer size exceeds the limit, close() fails the
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc, longSchema(), /* maxBytes */ 1024L * 1024L);  
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc, longSchema(), /* maxBytes */ 8L);
        }
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);  
            sink.close();  
    }  
 * this file be licensed under the Apache-2.0 license or a
            sink.close();
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);  
                    reader.getVectorSchemaRoot().getSchema().getFields()
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
                    longSchema().getFields(),
     * memtable registered from this payload joins zero rows — correct semantics for INNER.
            expectThrows(IllegalStateException.class, () -> sink.feed(makeBatch(alloc, longSchema(), new long[] { 1L })));
        BigIntVector v = (BigIntVector) root.getVector("x");
    /**  
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
            assertTrue("IPC bytes must be non-empty", bytes.length > 0);
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 7L, 8L }));
            sink.close();  
            empty2.setRowCount(0);
                assertEquals(
            assertNotNull(bytes);  
import org.apache.arrow.vector.BigIntVector;
