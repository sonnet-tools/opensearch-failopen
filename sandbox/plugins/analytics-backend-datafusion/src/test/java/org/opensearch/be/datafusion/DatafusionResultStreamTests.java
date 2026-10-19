            readerHandle.getPointer(),  
        NativeBridge.executeQueryAsync(
            "SELECT message FROM test_table",  
        testRootAllocator.close();
        assertEquals("root allocator not fully drained after import + consume + close", 0L, testRootAllocator.getAllocatedMemory());  
            try {
            try {  
                @Override
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
        // Caller owns child allocators now (see DatafusionResultStream.close javadoc).  
        );
        Exception ex = expectThrows(Exception.class, it::hasNext);
        allocatorsToClose.add(childAllocator);  
        assertNotNull("Native error should propagate", ex.getCause());
        long streamPtr = future.join();
    /**
    public void setUp() throws Exception {
 * The OpenSearch Contributors require contributions made to  
        );  
    }
        }
     * End-to-end smoke test: a real native stream consumed through {@link DatafusionResultStream} under a
                EngineResultBatch batch = it.next();
    }
                try {
        // Calling next() directly should work (it calls hasNext internally)
        }  
    private ReaderHandle readerHandle;
                    future.completeExceptionally(e);  
        }
    public void testDoubleCloseIsHarmless() throws Exception {  
                assertEquals(2, batch.getFieldNames().size());
            0L,
import java.lang.foreign.MemorySegment;  
                public void onResponse(Long ptr) {
        long streamPtr = executeQueryForStream(sql);
        }
                assertEquals(0, batch.getRowCount());  
        );
                batch.getArrowRoot().close();  
    public void tearDown() throws Exception {
            while (it.hasNext()) {  
        );
    }  
            queryConfigPtr,
    private long executeQueryForStream(String sql) {
                @Override  
        BufferAllocator childAllocator = testRootAllocator.newChildAllocator("test-stream-bounded", 0, limitBytes);
import java.nio.file.Files;
    private long queryConfigPtr;  
                assertTrue(batch.getFieldNames().contains("message"));
        stream.close();
        storeHandle.close();
            Iterator<EngineResultBatch> it = stream.iterator();  
            runtimeHandle.get(),
                assertTrue(batch.getRowCount() > 0);
        testRootAllocator = new RootAllocator(Long.MAX_VALUE);
            assertSame(it1, it2);  
        return new DatafusionResultStream(
        configArena = Arena.ofConfined();
    }
import java.util.Locale;
                }
                    future.complete(ptr);  
        // Create a valid stream, close the runtime handle to force streamNext failure,  
            failureAlloc,
                expectThrows(IllegalArgumentException.class, () -> batch.getFieldValue("nonexistent", 0));
            queryConfigPtr,
            substrait,
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {  
            dataDir.toString(),  
    public void testCloseWithoutIterating() throws Exception {  
public class DatafusionResultStreamTests extends OpenSearchTestCase {  
            }
            EngineResultBatch batch = it.next();
    public void testCloseAfterNativeStreamNextFailure() throws Exception {
            EngineResultBatch batch = it.next();
            Iterator<EngineResultBatch> it = stream.iterator();
        runtimeHandle.close();
                @Override
        Iterator<EngineResultBatch> it = stream.iterator();  
        NativeBridge.executeQueryAsync(  
/**  
            "test_table",
    public void testEmptyResultYieldsOneZeroRowBatchWithSchema() throws Exception {
            0L,
            EngineResultBatch batch = it.next();
                }  
        // Create a real TieredObjectStore (local-only) and wrap in NativeStoreHandle  
        NativeBridge.initTokioRuntimeManager(2);
    }
        return new DatafusionResultStream(
import org.opensearch.core.action.ActionListener;  
                    totalRows += batch.getRowCount();  
    private final java.util.List<BufferAllocator> allocatorsToClose = new java.util.ArrayList<>();
        assertTrue(  
    @Override
            try {
            new ActionListener<>() {
        DatafusionResultStream stream = createStream("SELECT message FROM test_table");
            } finally {
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
                }
import java.util.Iterator;  
            readerHandle.getPointer(),
            ex.getCause().getMessage().toLowerCase(Locale.ROOT).contains("substrait")
        }
            assertTrue(it.hasNext());
                batch.getArrowRoot().close();
        byte[] substrait = NativeBridge.sqlToSubstrait(  
            new org.opensearch.be.datafusion.nativelib.StreamHandle(streamPtr, runtimeHandle),
import org.opensearch.test.OpenSearchTestCase;  
                public void onFailure(Exception e) {
            childAllocator,  
            EngineResultBatch batch = it.next();
        configArena.close();  
            assertFalse("after consuming the schema batch the stream is empty", it.hasNext());
 */
            }  
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table WHERE message > 999")) {
                batch.getArrowRoot().close();
            Iterator<EngineResultBatch> it = stream.iterator();  
        // Iterate one batch then close — remaining native resources must be freed  
            List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),
            stagingAllocator
}
        readerHandle = new ReaderHandle(
            Iterator<EngineResultBatch> it = stream.iterator();
                    future.complete(p);
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());  
        byte[] substrait = NativeBridge.sqlToSubstrait(readerHandle.getPointer(), "test_table", sql, runtimeHandle.get());  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(  
            runtimeHandle.get()
 * SPDX-License-Identifier: Apache-2.0
                @Override  
    public void testNextWithoutHasNextWorks() throws Exception {  
        }
            } finally {
            new org.opensearch.be.datafusion.nativelib.StreamHandle(streamPtr, tempRuntime),
        super.setUp();  
            while (it.hasNext()) {
            storeHandle,
        }
            runtimeHandle.get(),  
        long streamPtr = executeQueryForStream(sql);
import java.nio.file.Path;
            }
     * that a normal small batch is fully released.
            }  
        );
        return future.join();  
                EngineResultBatch batch = it.next();
            expectThrows(NoSuchElementException.class, it::next);  
    }
            }
            Iterator<EngineResultBatch> it2 = stream.iterator();
    }  
        super.tearDown();  
            readerHandle.getPointer(),
            List.of(),  
        // Close runtime — streamNext should now fail with IllegalStateException from NativeRuntimeHandle.get()  
     *
    public void testCloseAfterPartialIteration() throws Exception {
        queryConfigPtr = configSegment.address();
            "Error should mention substrait/decode failure, got: " + ex.getCause().getMessage(),
        CompletableFuture<Long> future = new CompletableFuture<>();  
    private RootAllocator testRootAllocator;
                assertEquals(java.util.List.of("message"), batch.getFieldNames());
package org.opensearch.be.datafusion;
    }  
            assertTrue(it.hasNext());  
        long boxPtr = NativeStoreTestHelper.getObjectStoreBoxPtr(tieredStorePtr);
        NativeStoreTestHelper.destroyTieredObjectStore(tieredStorePtr);  
        Exception ex = expectThrows(Exception.class, future::join);
                public void onFailure(Exception e) {  
                assertNotNull(batch.getFieldValue("message", 0));
import org.apache.arrow.memory.RootAllocator;
        stagingAllocator = testRootAllocator.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);  
        // Streaming Flight requires ≥1 schema-bearing frame before completeStream; empty
    @Override
                    batch.getArrowRoot().close();
    }
    }  
        );
            substrait,
            } finally {
            new ActionListener<>() {  
    }
        // native streams synthesise a zero-row batch carrying the schema.  
        // Invalid substrait bytes should cause native failure — verify error propagates and no leak
    private NativeStoreHandle storeHandle;
            readerHandle.getPointer(),
import java.util.concurrent.CompletableFuture;
        }
                || ex.getCause().getMessage().toLowerCase(Locale.ROOT).contains("decode")  
        // Should fail because runtime handle is closed — get() throws IllegalStateException
        for (int i = allocatorsToClose.size() - 1; i >= 0; i--) {
            Iterator<EngineResultBatch> it = stream.iterator();
    private NativeRuntimeHandle runtimeHandle;  
                public void onResponse(Long ptr) {  
            childAllocator,  
        // Second close should not throw (NativeHandle uses AtomicBoolean)  
            } finally {  
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {  
        }
                } finally {
 * Tests for DatafusionResultStream — resource lifecycle, leak detection, edge cases.
            "test_table",  
            assertTrue(it.hasNext());
            }
        // then verify the stream still closes cleanly
        // Stream created but never iterated — close must not leak
    }
    private Arena configArena;
                batch.getArrowRoot().close();
/*  
    }
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
        BufferAllocator childAllocator = testRootAllocator.newChildAllocator("test-stream", 0, Long.MAX_VALUE);
                assertTrue(batch.getFieldNames().contains("message2"));  
            new org.opensearch.be.datafusion.nativelib.StreamHandle(streamPtr, runtimeHandle),
            0L,  
            Iterator<EngineResultBatch> it1 = stream.iterator();
    }
        stream.close();  
            assertTrue(it.hasNext());  
import java.util.List;
    private DatafusionResultStream createStream(String sql) {  
        allocatorsToClose.add(childAllocator);  
 *
    public void testNativeQueryFailureDoesNotLeak() {  
        NativeBridge.shutdownTokioRuntimeManager();
                }
                @Override
            EngineResultBatch batch = it.next();
    public void testIteratorReturnsSameInstance() throws Exception {
import java.util.NoSuchElementException;  
        );
    private DatafusionResultStream createStreamWithLimit(String sql, long limitBytes) {  
                batch.getArrowRoot().close();  
            }
            queryConfigPtr,  
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
        allocatorsToClose.add(stagingAllocator);
        NativeRuntimeHandle tempRuntime = new NativeRuntimeHandle(ptr2);
                    future.completeExceptionally(e);
        );  
                }  
            try {
     * {@link DatafusionImportLeakTests}; this test's fixture ({@code test.parquet}) is tiny, so it does not  
 * compatible open source license.
            int totalRows = 0;
            "test_table",
            new byte[] { 0, 1, 2 },  
        try (DatafusionResultStream stream = createStream("SELECT message FROM test_table")) {
    public void testStreamConsumeAndCloseDrainsAllocator() throws Exception {
        readerHandle.close();
                }
import org.opensearch.analytics.backend.EngineResultBatch;  
    private long tieredStorePtr;
        NativeBridge.executeQueryAsync(
        Path spillDir2 = createTempDir("spill2");
            stagingAllocator  
            // Multiple hasNext calls should not advance the stream
        CompletableFuture<Long> future = new CompletableFuture<>();
            } finally {
                    future.complete(ptr);
 */  
            assertEquals(2, totalRows);
     * itself force a mid-import OOM — it verifies the staging import path is wired correctly end-to-end and
    /** Stands in for the node-scoped staging allocator AnalyticsSearchService hands to every stream. */  
import org.opensearch.index.engine.exec.MonoFileWriterSet;
import org.opensearch.plugins.NativeStoreHandle;
            assertTrue("empty stream must yield exactly one zero-row schema batch", it.hasNext());  
    }
            try {  
    }  
     * <p>Note: the deterministic regression for the mid-import-OOM native leak lives in
        try (DatafusionResultStream stream = createStream("SELECT message, message2 FROM test_table")) {
        // Close them in reverse registration order so child-before-parent invariants hold.
        long ptr2 = NativeBridge.createGlobalRuntime(128 * 1024 * 1024, 0L, spillDir2.toString(), 64 * 1024 * 1024);  
            // close without exhausting the stream
                    future.completeExceptionally(e);
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
        tieredStorePtr = NativeStoreTestHelper.createTieredObjectStore(0L, 0L);
    public void testCloseAfterFullIteration() throws Exception {
        stream.close();
        WireConfigSnapshot.builder().build().writeTo(configSegment);  
     */  
    public void testHasNextIsIdempotent() throws Exception {
            List.of()
            // deliberately don't call iterator()
        // Stream close should still work even after the failure
        tempRuntime.close();
            "test_table",
                public void onFailure(Exception e) {
        runtimeHandle = new NativeRuntimeHandle(ptr);
                }  
            assertTrue(it.hasNext());
                assertTrue(batch.getRowCount() > 0);  
        MemorySegment configSegment = configArena.allocate(WireConfigSnapshot.BYTE_SIZE);
                || ex.getCause().getMessage().toLowerCase(Locale.ROOT).contains("failed")
            }
            tempRuntime.get(),
                assertTrue(batch.getRowCount() > 0);  
                batch.getArrowRoot().close();  
        long ptr = NativeBridge.createGlobalRuntime(128 * 1024 * 1024, 0L, spillDir.toString(), 64 * 1024 * 1024);  
            stagingAllocator
        }  
                @Override
        CompletableFuture<Long> future = new CompletableFuture<>();
            allocatorsToClose.get(i).close();  
import org.apache.arrow.memory.BufferAllocator;
            new ActionListener<>() {
     * small caller allocator imports and releases cleanly, leaving the shared root allocator drained.  
        );
            assertNotNull(stream);  
            }  
            Iterator<EngineResultBatch> it = stream.iterator();  
        );
            Iterator<EngineResultBatch> it = stream.iterator();  
            "Expected IllegalStateException from closed runtime handle, got: " + ex.getMessage(),
    private BufferAllocator stagingAllocator;
        allocatorsToClose.add(failureAlloc);
    }  
            ex.getCause() instanceof IllegalStateException || ex instanceof IllegalStateException
        Path dataDir = createTempDir("data");
import java.lang.foreign.Arena;
        Path spillDir = createTempDir("spill");
    public void testBatchFieldAccess() throws Exception {
        DatafusionResultStream stream = new DatafusionResultStream(  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        try (DatafusionResultStream stream = createStreamWithLimit("SELECT message, message2 FROM test_table", 1024)) {
            }
        BufferAllocator failureAlloc = testRootAllocator.newChildAllocator("test-failure", 0, Long.MAX_VALUE);
        storeHandle = new NativeStoreHandle(boxPtr, NativeStoreTestHelper::destroyObjectStoreBoxPtr);  
                public void onResponse(Long p) {
