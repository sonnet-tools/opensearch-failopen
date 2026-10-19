                    batchIdx++;
            // Simulate a null-payload shard response: zero-column root from a fresh Schema.
import org.apache.arrow.vector.ipc.ArrowStreamReader;
    }
                    reader.getVectorSchemaRoot().getSchema().getFields()
import org.apache.arrow.vector.BigIntVector;
        }
    /**
                );
            sink.close();
                    ee.getCause() instanceof BroadcastSizeExceededException
import org.apache.arrow.vector.VectorSchemaRoot;
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
        BigIntVector v = (BigIntVector) root.getVector("x");
 * compatible open source license.
    public void testFeedThenCloseProducesIpcBytes() throws Exception {
            sink.close();
            } catch (java.util.concurrent.ExecutionException ee) {
            assertTrue("empty-capture stream should still have IPC header", bytes.length > 0);
                assertFalse(reader.loadNextBatch());
                assertFalse("empty-capture stream must have zero batches", reader.loadNextBatch());
                );
    /**
    }
    /**
     */
     */
    }
import org.opensearch.analytics.spi.BroadcastSizeExceededException;
                }
        return root;
        }
                    longSchema().getFields(),
/*
                    longSchema().getFields(),
            }
}
        }
            sink.feed(emptyRoot);
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
import java.io.ByteArrayInputStream;
    private static Schema longSchema() {
            try (
     * shard payload, the fallback schema wins. The IPC header carries the real build schema
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
     * Regression: when the build stage emits no real batches at all, the sink
            sink.feed(empty2);
import org.apache.arrow.memory.RootAllocator;
    }
                    longSchema().getFields(),
            }
     * Regression: when the first fed batch is a zero-column {@link VectorSchemaRoot}
                    "roundtripped schema must be the long schema, not empty",
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 1L, 2L, 3L }));
     */
            // Second shard has real data.
            }
    /**
 */
                assertEquals(2, v.getValueCount());
     * and zero record batches are emitted — same correct behavior as the all-empty case.
        }
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
            VectorSchemaRoot empty2 = VectorSchemaRoot.create(new Schema(List.of()), alloc);
            assertTrue("IPC bytes must be non-empty", bytes.length > 0);
     * payloads), the sink produces a header-only stream with an empty schema. The broadcast
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
        VectorSchemaRoot root = VectorSchemaRoot.create(schema, alloc);
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 42L }));
        }
import org.apache.arrow.vector.types.pojo.FieldType;
        root.setRowCount(vals.length);
                    "fallback schema must override the phantom-batch's empty schema",
            ) {
            }
    /**
                    VectorSchemaRoot root = reader.getVectorSchemaRoot();
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            // Roundtrip — decode the IPC stream and confirm we get two batches with the expected values.
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
            }
                    }
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 4L, 5L }));
                );
            assertEquals(List.of(1L, 2L, 3L, 4L, 5L), observed);
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
                    reader.getVectorSchemaRoot().getSchema().getFields()
            emptyRoot.setRowCount(0);
            VectorSchemaRoot empty1 = VectorSchemaRoot.create(new Schema(List.of()), alloc);
    }
            try (
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
     */
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
            expectThrows(IllegalStateException.class, () -> sink.feed(makeBatch(alloc, longSchema(), new long[] { 1L })));
 */
import java.util.concurrent.TimeUnit;
                int batchIdx = 0;
            sink.close();
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
                assertFalse("all-empty feed must produce zero batches", reader.loadNextBatch());
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc, longSchema());
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
            sink.close(); // no-op, must not throw
                assertTrue(
            phantom.setRowCount(0);
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
            sink.close();
            sink.feed(empty1);
import org.apache.arrow.vector.types.pojo.Field;
            // Generous cap.
            VectorSchemaRoot phantom = VectorSchemaRoot.create(new Schema(List.of()), alloc);
            sink.close();
    /**
 * The OpenSearch Contributors require contributions made to
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 1L, 2L, 3L }));
    }
            ) {
            sink.feed(phantom);
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 7L, 8L }));
            // Tiny cap: a single 3-row long batch (~24 bytes data + buffer overhead) easily exceeds it.
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
            List<Long> observed = new ArrayList<>();
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
     * The probe-side handler then registers a memtable with the right column types and the
            assertNotNull(bytes);
            sink.close();
    public void testFallbackSchemaUsedWhenAllPhantomBatches() throws Exception {
                assertFalse("only one non-empty batch", reader.loadNextBatch());
        }
     * must use the explicit fallback schema in the IPC header — not {@code Schema(List.of())}.
                fail("expected BroadcastSizeExceededException");
                assertFalse(reader.loadNextBatch());
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
    public void testFeedAfterCloseThrows() throws Exception {
                ArrowStreamReader reader = new ArrowStreamReader(new ByteArrayInputStream(bytes), readerAlloc)
                );
            try (
 * SPDX-License-Identifier: Apache-2.0
     * Cap not exceeded: a tiny batch under the limit succeeds normally.
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
     * (produced for a null shard payload), the sink must NOT snap the empty schema as the
            try (
    public void testEmptyFirstBatchDoesNotSnapEmptySchema() throws Exception {
            v.setSafe(i, vals[i]);
        }
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc, longSchema(), /* maxBytes */ 8L);
    public void testFallbackSchemaUsedWhenNoRealBatches() throws Exception {
    }
                sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
 * this file be licensed under the Apache-2.0 license or a
            sink.close();
            try (
     * Regression: even when every fed batch is a zero-column phantom from a null
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
            }
        v.allocateNew(vals.length);
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
    }
                    reader.getVectorSchemaRoot().getSchema().getFields()
                    for (int i = 0; i < v.getValueCount(); i++) {
            sink.close();
            sink.close(); // no batches at all
        return new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(64, true)), null)));
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
            empty1.setRowCount(0);
    private static VectorSchemaRoot makeBatch(RootAllocator alloc, Schema schema, long[] vals) {
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
     * join's NamedScan binds correctly (yielding zero matches for INNER joins).
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc, longSchema());
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
                assertEquals(8L, v.get(1));
                assertEquals(
            empty2.setRowCount(0);
            ) {
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
        }
    }
            }
import java.util.List;
        }
            sink.feed(makeBatch(alloc, longSchema(), new long[] { 1L, 2L, 3L }));
                while (reader.loadNextBatch()) {
            ) {
/**
                assertEquals(
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc);
 *
                assertEquals(
            assertNotNull(bytes);
            VectorSchemaRoot emptyRoot = VectorSchemaRoot.create(new Schema(List.of()), alloc);
        v.setValueCount(vals.length);
            try {
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
            // Roundtrip must see the real schema and the real batch.
import org.apache.arrow.vector.types.pojo.Schema;
    public void testByteCapPassesWhenUnderLimit() throws Exception {
package org.opensearch.be.datafusion;
     * Runtime byte cap: when accumulated buffer size exceeds the limit, close() fails the
                        observed.add(v.get(i));
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
 * Tests for {@link BroadcastCaptureSink}. No native deps — pure Arrow IPC round-trip.
                    BigIntVector v = (BigIntVector) root.getVector("x");
    }
                assertTrue("first batch loads", reader.loadNextBatch());
     */
            assertTrue("under-cap broadcast must produce IPC bytes", bytes.length > 0);
    }
            sink.close();
    public void testByteCapFailsFutureWhenExceeded() throws Exception {
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
            byte[] bytes = sink.ipcBytesFuture().get(5, TimeUnit.SECONDS);
            ) {
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
    public void testAllEmptyBatchesYieldsHeaderOnlyStream() throws Exception {
            try (
                BigIntVector v = (BigIntVector) reader.getVectorSchemaRoot().getVector("x");
     * Regression: if every fed batch is empty-schema (the whole build side had null
                assertEquals(7L, v.get(0));
                    "cause must be BroadcastSizeExceededException, was: " + ee.getCause(),
public class BroadcastCaptureSinkTests extends OpenSearchTestCase {
        try (RootAllocator alloc = new RootAllocator(Long.MAX_VALUE)) {
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
            assertTrue(bytes.length > 0);
                RootAllocator readerAlloc = new RootAllocator(Long.MAX_VALUE);
    public void testCloseWithoutFeedProducesHeaderOnlyStream() throws Exception {
     */
            ) {
                    "fallback schema must propagate to the IPC header",
     * broadcast schema. A later non-empty batch from another shard upgrades the snapshot to
import org.opensearch.test.OpenSearchTestCase;
     * memtable registered from this payload joins zero rows — correct semantics for INNER.
import org.apache.arrow.vector.types.pojo.ArrowType;
        for (int i = 0; i < vals.length; i++) {
import java.util.ArrayList;
            BroadcastCaptureSink sink = new BroadcastCaptureSink(alloc, longSchema(), /* maxBytes */ 1024L * 1024L);
    public void testCloseIsIdempotent() throws Exception {
     * future with {@link BroadcastSizeExceededException} so the dispatcher can route the
     * failure through the terminal listener.
        }
                assertEquals("expected 2 roundtripped batches", 2, batchIdx);
     * the real schema, and the empty batch is skipped during serialization.
    }
        }
