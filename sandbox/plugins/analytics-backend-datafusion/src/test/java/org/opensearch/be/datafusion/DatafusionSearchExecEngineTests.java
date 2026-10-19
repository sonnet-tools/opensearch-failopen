import org.opensearch.analytics.backend.EngineResultStream;
            RootAllocator alloc = new RootAllocator(Long.MAX_VALUE);
    }
    }
        );
            ShardScanExecutionContext execCtx = createExecutionContext("test_table", substrait, context);
        DatafusionContext context = new DatafusionContext(null, reader, runtimeHandle);
            runtimeHandle.get()
    }
import java.util.List;
        }
            execCtx.setImportStagingAllocator(staging);
/**
        Path spillDir = createTempDir("datafusion-spill");
            execCtx.setImportStagingAllocator(staging);
        );
                assertEquals(4L, rows.get(1)[1]);
import org.apache.arrow.memory.BufferAllocator;
    }
    public void setUp() throws Exception {
    @Override
            configSegment.address(),
        dfContext.setSessionContextHandle(sessionCtxHandle);
        );
            readerHandle.getPointer(),
/*
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
public class DatafusionSearchExecEngineTests extends OpenSearchTestCase {
                assertEquals(1, rows.size());
 */
            BufferAllocator staging = alloc.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
    public void testEngineExecuteSelectAll() throws Exception {
            execCtx.setAllocator(alloc);
            try {
            "test_table",
package org.opensearch.be.datafusion;
            ShardScanExecutionContext execCtx = createExecutionContext("test_table", substrait, context);
        DatafusionContext context = new DatafusionContext(null, reader, runtimeHandle);
            List.of()
import java.nio.file.Files;
                assertEquals(1, rows.size());
        }
 * Tests the plugin-level execution chain:
        // Create a real TieredObjectStore (local-only) and wrap in NativeStoreHandle
                assertEquals(3L, rows.get(0)[0]);
import org.opensearch.analytics.backend.ShardScanExecutionContext;
            try (EngineResultStream stream = engine.execute(execCtx)) {
            "test_table",
            }
            runtimeHandle.get()
    }
            tableName,
                    Object[] row = new Object[cols];
        NativeStoreTestHelper.destroyTieredObjectStore(tieredStorePtr);
            }
            EngineResultBatch batch = it.next();
            "SELECT message, message2 FROM test_table",
        );
    }
import org.opensearch.plugins.NativeStoreHandle;
 * The OpenSearch Contributors require contributions made to
            new byte[0]
        storeHandle = new NativeStoreHandle(boxPtr, NativeStoreTestHelper::destroyObjectStoreBoxPtr);
        MemorySegment configSegment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
 * compatible open source license.
        DatafusionReader reader = createReader();
    }
        List<Object[]> rows = new ArrayList<>();
        try (
                assertEquals(3L, rows.get(1)[0]);
        tieredStorePtr = NativeStoreTestHelper.createTieredObjectStore(0L, 0L);
                for (int r = 0; r < batch.getRowCount(); r++) {
            execCtx.setAllocator(alloc);
        return execCtx;
            }
        runtimeHandle.close();
 * this file be licensed under the Apache-2.0 license or a
            } finally {
        WireConfigSnapshot.builder().build().writeTo(configSegment);
                List<Object[]> rows = collectRows(stream);
 * DatafusionReader → DatafusionContext → DatafusionSearchExecEngine → EngineResultStream → EngineResultBatch.
            DatafusionSearchExecEngine engine = new DatafusionSearchExecEngine(context)
            }
        long ptr = NativeBridge.createGlobalRuntime(128 * 1024 * 1024, 0L, spillDir.toString(), 64 * 1024 * 1024);
                }
    public void testEngineExecuteFilter() throws Exception {
            runtimeHandle.get()
        ) {
import org.opensearch.test.OpenSearchTestCase;
            execCtx.setImportStagingAllocator(staging);
            DatafusionSearchExecEngine engine = new DatafusionSearchExecEngine(context)
            engine.prepare(execCtx);
            "SELECT message FROM test_table WHERE message = 3",
}
        while (it.hasNext()) {
    private NativeRuntimeHandle runtimeHandle;
        DatafusionReader reader = createReader();
            try (EngineResultStream stream = engine.execute(execCtx)) {
        readerHandle.close();
                    rows.add(row);
            engine.prepare(execCtx);
            storeHandle,
        }
            "SELECT SUM(message) as total FROM test_table",
        return rows;
            BufferAllocator staging = alloc.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
        ) {
import java.util.Iterator;
            false,
                List<Object[]> rows = collectRows(stream);
    private NativeStoreHandle storeHandle;
        byte[] substrait = NativeBridge.sqlToSubstrait(
    private DatafusionReader createReader() {
        DatafusionContext context = new DatafusionContext(null, reader, runtimeHandle);
        ) {
        NativeBridge.shutdownTokioRuntimeManager();
            readerHandle.getPointer(),
            engine.prepare(execCtx);
        execCtx.setFragmentBytes(substrait);
import org.apache.arrow.memory.RootAllocator;
            List.of(),
        runtimeHandle = new NativeRuntimeHandle(ptr);
import java.lang.foreign.MemorySegment;
                List<Object[]> rows = collectRows(stream);
import java.nio.file.Path;
 * SPDX-License-Identifier: Apache-2.0
                int cols = batch.getFieldNames().size();
    private List<Object[]> collectRows(EngineResultStream stream) {
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        byte[] substrait = NativeBridge.sqlToSubstrait(
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
            RootAllocator alloc = new RootAllocator(Long.MAX_VALUE);
        return new DatafusionReader(readerHandle.getPointer());
            ShardScanExecutionContext execCtx = createExecutionContext("test_table", substrait, context);
            List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),
    }
        try (
            try (EngineResultStream stream = engine.execute(execCtx)) {
    @Override
        }
    public void tearDown() throws Exception {
            dataDir.toString(),
                        row[c] = batch.getFieldValue(batch.getFieldNames().get(c), r);
        Arena arena = Arena.ofConfined();
            readerHandle.getPointer(),
                assertEquals(2L, rows.get(0)[0]); // message
        super.tearDown();
            execCtx.setAllocator(alloc);
        ShardScanExecutionContext execCtx = new ShardScanExecutionContext(tableName, null, null);
import org.opensearch.index.engine.exec.MonoFileWriterSet;
 * Uses sqlToSubstrait to generate plan bytes, then exercises the real plugin classes.
        super.setUp();
        SessionContextHandle sessionCtxHandle = NativeBridge.createSessionContext(
            runtimeHandle.get(),
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;
import java.lang.foreign.Arena;
            false,
        Path dataDir = createTempDir("datafusion-data");
        readerHandle = new ReaderHandle(
        long boxPtr = NativeStoreTestHelper.getObjectStoreBoxPtr(tieredStorePtr);
        NativeBridge.initTokioRuntimeManager(2);
                assertEquals(2, rows.size());
        arena.close();
        );
    private ShardScanExecutionContext createExecutionContext(String tableName, byte[] substrait, DatafusionContext dfContext) {
        Iterator<EngineResultBatch> it = stream.iterator();
import org.opensearch.analytics.backend.EngineResultBatch;
 */
            "test_table",
                    for (int c = 0; c < cols; c++) {
        byte[] substrait = NativeBridge.sqlToSubstrait(
                assertEquals(3L, rows.get(0)[1]); // message2
 *
            BufferAllocator staging = alloc.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
        DatafusionReader reader = createReader();
import java.util.ArrayList;
    private long tieredStorePtr;
    private ReaderHandle readerHandle;
                batch.getArrowRoot().close();
        try (
            readerHandle.getPointer(),
            RootAllocator alloc = new RootAllocator(Long.MAX_VALUE);
            DatafusionSearchExecEngine engine = new DatafusionSearchExecEngine(context)
                assertEquals(5L, rows.get(0)[0]); // 2 + 3
        storeHandle.close();
            0L,
    public void testEngineExecuteAggregation() throws Exception {
                    }
