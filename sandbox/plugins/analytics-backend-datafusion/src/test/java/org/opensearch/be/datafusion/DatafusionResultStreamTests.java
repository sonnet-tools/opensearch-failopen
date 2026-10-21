import java.util.Iterator;
                }
            Iterator<EngineResultBatch> it = stream.iterator();
    @Override
                @Override
        super.setUp();
            "Expected IllegalStateException from closed runtime handle, got: " + ex.getMessage(),
                batch.getArrowRoot().close();
                }
                public void onResponse(Long p) {
import org.opensearch.analytics.backend.EngineResultBatch;
                assertEquals(0, batch.getRowCount());
                    future.complete(p);
            }
        NativeBridge.executeQueryAsync(
        byte[] substrait = NativeBridge.sqlToSubstrait(readerHandle.getPointer(), "test_table", sql, runtimeHandle.get());
            assertTrue(it.hasNext());
        stream.close();
        assertEquals("root allocator not fully drained after import + consume + close", 0L, testRootAllocator.getAllocatedMemory());
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
            try {
        // Should fail because runtime handle is closed — get() throws IllegalStateException
            try {
import org.apache.arrow.memory.RootAllocator;
                EngineResultBatch batch = it.next();
            stagingAllocator
import org.opensearch.be.datafusion.nativelib.NativeBridge;
    }
import java.lang.foreign.Arena;
            Iterator<EngineResultBatch> it = stream.iterator();
    public void testCloseAfterNativeStreamNextFailure() throws Exception {
            while (it.hasNext()) {
 * Tests for DatafusionResultStream — resource lifecycle, leak detection, edge cases.
            } finally {
            Iterator<EngineResultBatch> it = stream.iterator();
        );
        // native streams synthesise a zero-row batch carrying the schema.
            Iterator<EngineResultBatch> it = stream.iterator();
    }
            "test_table",
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
    }
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
                    future.complete(ptr);
    private NativeRuntimeHandle runtimeHandle;
                assertNotNull(batch.getFieldValue("message", 0));
        MemorySegment configSegment = configArena.allocate(WireConfigSnapshot.BYTE_SIZE);
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
                @Override
            // close without exhausting the stream
                assertEquals(java.util.List.of("message"), batch.getFieldNames());
    public void testCloseAfterFullIteration() throws Exception {
            assertTrue(it.hasNext());
    }
        configArena = Arena.ofConfined();
        }
            new org.opensearch.be.datafusion.nativelib.StreamHandle(streamPtr, runtimeHandle),
                }
            try {
            } finally {
        // Stream created but never iterated — close must not leak
            childAllocator,
        // Create a real TieredObjectStore (local-only) and wrap in NativeStoreHandle
        allocatorsToClose.add(stagingAllocator);
        assertTrue(
    public void testHasNextIsIdempotent() throws Exception {
                    future.complete(ptr);
                @Override
            0L,
            assertTrue("empty stream must yield exactly one zero-row schema batch", it.hasNext());
        CompletableFuture<Long> future = new CompletableFuture<>();
        BufferAllocator failureAlloc = testRootAllocator.newChildAllocator("test-failure", 0, Long.MAX_VALUE);
            EngineResultBatch batch = it.next();
            runtimeHandle.get(),
        return new DatafusionResultStream(
        assertNotNull("Native error should propagate", ex.getCause());
            int totalRows = 0;
        Exception ex = expectThrows(Exception.class, it::hasNext);
        );
import java.lang.foreign.MemorySegment;
                }
        Exception ex = expectThrows(Exception.class, future::join);
                public void onResponse(Long ptr) {
            new org.opensearch.be.datafusion.nativelib.StreamHandle(streamPtr, tempRuntime),
     * End-to-end smoke test: a real native stream consumed through {@link DatafusionResultStream} under a
            // Multiple hasNext calls should not advance the stream
                assertTrue(batch.getFieldNames().contains("message2"));
    public void testNextWithoutHasNextWorks() throws Exception {
                    future.completeExceptionally(e);
        NativeBridge.executeQueryAsync(
        Path spillDir = createTempDir("spill");
            EngineResultBatch batch = it.next();
    }
            readerHandle.getPointer(),
            new ActionListener<>() {
        long ptr = NativeBridge.createGlobalRuntime(128 * 1024 * 1024, 0L, spillDir.toString(), 64 * 1024 * 1024);
                batch.getArrowRoot().close();
            readerHandle.getPointer(),
        );
            Iterator<EngineResultBatch> it = stream.iterator();
            EngineResultBatch batch = it.next();
            assertTrue(it.hasNext());
            Iterator<EngineResultBatch> it = stream.iterator();
import java.util.concurrent.CompletableFuture;
    }
                || ex.getCause().getMessage().toLowerCase(Locale.ROOT).contains("failed")
        super.tearDown();
            while (it.hasNext()) {
        Path dataDir = createTempDir("data");
                    totalRows += batch.getRowCount();
            }
        }
        }
            }
            "test_table",
        WireConfigSnapshot.builder().build().writeTo(configSegment);
        allocatorsToClose.add(childAllocator);
        CompletableFuture<Long> future = new CompletableFuture<>();
            "Error should mention substrait/decode failure, got: " + ex.getCause().getMessage(),
     * {@link DatafusionImportLeakTests}; this test's fixture ({@code test.parquet}) is tiny, so it does not
        );
        BufferAllocator childAllocator = testRootAllocator.newChildAllocator("test-stream", 0, Long.MAX_VALUE);
import java.nio.file.Files;
        }
        long streamPtr = future.join();
        configArena.close();
            substrait,
import org.opensearch.plugins.NativeStoreHandle;
    /**
        testRootAllocator.close();
            queryConfigPtr,
        for (int i = allocatorsToClose.size() - 1; i >= 0; i--) {
    }
        long ptr2 = NativeBridge.createGlobalRuntime(128 * 1024 * 1024, 0L, spillDir2.toString(), 64 * 1024 * 1024);
import java.util.NoSuchElementException;
    }
            "test_table",
            }
            new ActionListener<>() {
        testRootAllocator = new RootAllocator(Long.MAX_VALUE);
    }
                public void onFailure(Exception e) {
            readerHandle.getPointer(),
            "SELECT message FROM test_table",
            runtimeHandle.get(),
        );
    /** Stands in for the node-scoped staging allocator AnalyticsSearchService hands to every stream. */
    private Arena configArena;
        long streamPtr = executeQueryForStream(sql);
                batch.getArrowRoot().close();
                batch.getArrowRoot().close();
    private long executeQueryForStream(String sql) {
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
import org.opensearch.core.action.ActionListener;
        Iterator<EngineResultBatch> it = stream.iterator();
            } finally {
            EngineResultBatch batch = it.next();
                assertTrue(batch.getRowCount() > 0);
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
        try (DatafusionResultStream stream = createStream("SELECT message, message2 FROM test_table")) {
        byte[] substrait = NativeBridge.sqlToSubstrait(
    private ReaderHandle readerHandle;
        storeHandle = new NativeStoreHandle(boxPtr, NativeStoreTestHelper::destroyObjectStoreBoxPtr);
        runtimeHandle.close();
            readerHandle.getPointer(),
/*
            ex.getCause().getMessage().toLowerCase(Locale.ROOT).contains("substrait")
            runtimeHandle.get()
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
                }
 * The OpenSearch Contributors require contributions made to
        }
        // Create a valid stream, close the runtime handle to force streamNext failure,
            new byte[] { 0, 1, 2 },
            assertFalse("after consuming the schema batch the stream is empty", it.hasNext());
        // Calling next() directly should work (it calls hasNext internally)
            // deliberately don't call iterator()
                || ex.getCause().getMessage().toLowerCase(Locale.ROOT).contains("decode")
        return new DatafusionResultStream(
        NativeStoreTestHelper.destroyTieredObjectStore(tieredStorePtr);
                } finally {
    public void setUp() throws Exception {
    private long queryConfigPtr;
            storeHandle,
    public void testIteratorReturnsSameInstance() throws Exception {
        );
import java.nio.file.Path;
    public void testDoubleCloseIsHarmless() throws Exception {
        }
                public void onFailure(Exception e) {
        BufferAllocator childAllocator = testRootAllocator.newChildAllocator("test-stream-bounded", 0, limitBytes);
        try (DatafusionResultStream stream = createStreamWithLimit("SELECT message, message2 FROM test_table", 1024)) {
            try {
                @Override
        }
    @Override
                assertTrue(batch.getRowCount() > 0);
            assertTrue(it.hasNext());
            }
        NativeRuntimeHandle tempRuntime = new NativeRuntimeHandle(ptr2);
    public void testCloseAfterPartialIteration() throws Exception {
    }
                }
        // Invalid substrait bytes should cause native failure — verify error propagates and no leak
     * that a normal small batch is fully released.
        DatafusionResultStream stream = createStream("SELECT message FROM test_table");
        // Close runtime — streamNext should now fail with IllegalStateException from NativeRuntimeHandle.get()
    private DatafusionResultStream createStream(String sql) {
    private DatafusionResultStream createStreamWithLimit(String sql, long limitBytes) {
            assertNotNull(stream);
        CompletableFuture<Long> future = new CompletableFuture<>();
        readerHandle = new ReaderHandle(
            stagingAllocator
        long boxPtr = NativeStoreTestHelper.getObjectStoreBoxPtr(tieredStorePtr);
        queryConfigPtr = configSegment.address();
        runtimeHandle = new NativeRuntimeHandle(ptr);
import org.apache.arrow.memory.BufferAllocator;
        );
        stream.close();
    public void testEmptyResultYieldsOneZeroRowBatchWithSchema() throws Exception {
    }
        // Second close should not throw (NativeHandle uses AtomicBoolean)
     * itself force a mid-import OOM — it verifies the staging import path is wired correctly end-to-end and
            }
        );
            EngineResultBatch batch = it.next();
        allocatorsToClose.add(childAllocator);
            List.of()
 *
                assertTrue(batch.getFieldNames().contains("message"));
public class DatafusionResultStreamTests extends OpenSearchTestCase {
     */
            "test_table",
 */
            dataDir.toString(),
            }
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
    private RootAllocator testRootAllocator;
    public void tearDown() throws Exception {
            failureAlloc,
                EngineResultBatch batch = it.next();
        readerHandle.close();
 * this file be licensed under the Apache-2.0 license or a
        Path spillDir2 = createTempDir("spill2");
            Iterator<EngineResultBatch> it = stream.iterator();
            List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),
            }
            substrait,
            }
        tempRuntime.close();
                    batch.getArrowRoot().close();
    private final java.util.List<BufferAllocator> allocatorsToClose = new java.util.ArrayList<>();
            } finally {
    }
            assertTrue(it.hasNext());
                public void onFailure(Exception e) {
                @Override
import java.util.Locale;
        NativeBridge.executeQueryAsync(
            Iterator<EngineResultBatch> it2 = stream.iterator();
        NativeBridge.shutdownTokioRuntimeManager();
                }
                expectThrows(IllegalArgumentException.class, () -> batch.getFieldValue("nonexistent", 0));
    }
            0L,
                assertEquals(2, batch.getFieldNames().size());
        DatafusionResultStream stream = new DatafusionResultStream(
        }
            new org.opensearch.be.datafusion.nativelib.StreamHandle(streamPtr, runtimeHandle),
        stagingAllocator = testRootAllocator.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
            queryConfigPtr,
        return future.join();
            allocatorsToClose.get(i).close();
     *
                @Override
            assertSame(it1, it2);
        // then verify the stream still closes cleanly
        // Close them in reverse registration order so child-before-parent invariants hold.
            }
            Iterator<EngineResultBatch> it1 = stream.iterator();
        // Caller owns child allocators now (see DatafusionResultStream.close javadoc).
/**
            try {
     * small caller allocator imports and releases cleanly, leaving the shared root allocator drained.
import java.util.List;
     * <p>Note: the deterministic regression for the mid-import-OOM native leak lives in
            0L,
        stream.close();
    }
package org.opensearch.be.datafusion;
            ex.getCause() instanceof IllegalStateException || ex instanceof IllegalStateException
    private NativeStoreHandle storeHandle;
                assertTrue(batch.getRowCount() > 0);
            assertEquals(2, totalRows);
    }
            stagingAllocator
            List.of(),
            } finally {
    public void testStreamConsumeAndCloseDrainsAllocator() throws Exception {
    }
                public void onResponse(Long ptr) {
        allocatorsToClose.add(failureAlloc);
        // Streaming Flight requires ≥1 schema-bearing frame before completeStream; empty
        );
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table WHERE message > 999")) {
    private long tieredStorePtr;
        // Iterate one batch then close — remaining native resources must be freed
    public void testBatchFieldAccess() throws Exception {
    public void testCloseWithoutIterating() throws Exception {
 * compatible open source license.
            expectThrows(NoSuchElementException.class, it::next);
        // Stream close should still work even after the failure
 */
                    future.completeExceptionally(e);
    }
        long streamPtr = executeQueryForStream(sql);
            queryConfigPtr,
            new ActionListener<>() {
import org.opensearch.index.engine.exec.MonoFileWriterSet;
        storeHandle.close();
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
}
    public void testNativeQueryFailureDoesNotLeak() {
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
                    future.completeExceptionally(e);
        assertTrue(
        NativeBridge.initTokioRuntimeManager(2);
                batch.getArrowRoot().close();
                try {
                batch.getArrowRoot().close();
        }
            childAllocator,
            tempRuntime.get(),
    private BufferAllocator stagingAllocator;
        }
        tieredStorePtr = NativeStoreTestHelper.createTieredObjectStore(0L, 0L);
        );
