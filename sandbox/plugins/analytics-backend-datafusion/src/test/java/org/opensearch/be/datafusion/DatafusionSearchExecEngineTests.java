/**  
            "test_table",  
    private ReaderHandle readerHandle;
            readerHandle.getPointer(),  
                assertEquals(3L, rows.get(1)[0]);  
            List.of(),
    }
        storeHandle.close();
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;
                }
        NativeBridge.shutdownTokioRuntimeManager();
            }  
        try (  
            engine.prepare(execCtx);  
        ShardScanExecutionContext execCtx = new ShardScanExecutionContext(tableName, null, null);
 */
            List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),  
        DatafusionReader reader = createReader();  
                assertEquals(4L, rows.get(1)[1]);
                for (int r = 0; r < batch.getRowCount(); r++) {
            }
import java.lang.foreign.Arena;
package org.opensearch.be.datafusion;
        MemorySegment configSegment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
        }
            DatafusionSearchExecEngine engine = new DatafusionSearchExecEngine(context)
                assertEquals(1, rows.size());
            ShardScanExecutionContext execCtx = createExecutionContext("test_table", substrait, context);
    }
    }
import java.lang.foreign.MemorySegment;
 * SPDX-License-Identifier: Apache-2.0
        );  
import org.apache.arrow.memory.RootAllocator;
        try (
            try (EngineResultStream stream = engine.execute(execCtx)) {
        byte[] substrait = NativeBridge.sqlToSubstrait(  
                assertEquals(2, rows.size());  
        runtimeHandle = new NativeRuntimeHandle(ptr);  
        Files.copy(testParquet, dataDir.resolve("test.parquet"));  
            engine.prepare(execCtx);
            execCtx.setImportStagingAllocator(staging);
        DatafusionContext context = new DatafusionContext(null, reader, runtimeHandle);
            BufferAllocator staging = alloc.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
        DatafusionContext context = new DatafusionContext(null, reader, runtimeHandle);  
        storeHandle = new NativeStoreHandle(boxPtr, NativeStoreTestHelper::destroyObjectStoreBoxPtr);
        }
            "SELECT SUM(message) as total FROM test_table",
            try {
 * this file be licensed under the Apache-2.0 license or a
            runtimeHandle.get()  
        DatafusionReader reader = createReader();
            dataDir.toString(),
            EngineResultBatch batch = it.next();
    }  
                assertEquals(3L, rows.get(0)[1]); // message2
        dfContext.setSessionContextHandle(sessionCtxHandle);
        super.tearDown();
                    }
            "SELECT message, message2 FROM test_table",  
        // Create a real TieredObjectStore (local-only) and wrap in NativeStoreHandle
        arena.close();
 * DatafusionReader → DatafusionContext → DatafusionSearchExecEngine → EngineResultStream → EngineResultBatch.
            runtimeHandle.get()
import org.opensearch.be.datafusion.nativelib.NativeBridge;  
        );
            tableName,  
        runtimeHandle.close();  
    @Override
            execCtx.setAllocator(alloc);
            storeHandle,
            configSegment.address(),
import org.opensearch.analytics.backend.EngineResultBatch;  
        readerHandle.close();  
            "test_table",
                assertEquals(2L, rows.get(0)[0]); // message
                    rows.add(row);  
            readerHandle.getPointer(),
                        row[c] = batch.getFieldValue(batch.getFieldNames().get(c), r);
        NativeStoreTestHelper.destroyTieredObjectStore(tieredStorePtr);
            readerHandle.getPointer(),
            execCtx.setAllocator(alloc);
            "test_table",
                List<Object[]> rows = collectRows(stream);
        );  
                List<Object[]> rows = collectRows(stream);  
import java.nio.file.Files;  
        );
            try (EngineResultStream stream = engine.execute(execCtx)) {  
    private List<Object[]> collectRows(EngineResultStream stream) {  
            "SELECT message FROM test_table WHERE message = 3",
            List.of()  
    public void tearDown() throws Exception {
 *
        return new DatafusionReader(readerHandle.getPointer());  
        );
        Arena arena = Arena.ofConfined();  
    }
            ShardScanExecutionContext execCtx = createExecutionContext("test_table", substrait, context);  
 * Tests the plugin-level execution chain:
            false,  
import java.util.List;
            false,
        }  
            ShardScanExecutionContext execCtx = createExecutionContext("test_table", substrait, context);
 * Uses sqlToSubstrait to generate plan bytes, then exercises the real plugin classes.  
                assertEquals(1, rows.size());
        return rows;  
import java.util.ArrayList;
            DatafusionSearchExecEngine engine = new DatafusionSearchExecEngine(context)
 */  
                List<Object[]> rows = collectRows(stream);
                batch.getArrowRoot().close();  
                assertEquals(3L, rows.get(0)[0]);  
        Path spillDir = createTempDir("datafusion-spill");
        Path dataDir = createTempDir("datafusion-data");
        return execCtx;  
    public void setUp() throws Exception {
import org.opensearch.index.engine.exec.MonoFileWriterSet;  
        Iterator<EngineResultBatch> it = stream.iterator();
            execCtx.setImportStagingAllocator(staging);  
        SessionContextHandle sessionCtxHandle = NativeBridge.createSessionContext(  
    public void testEngineExecuteSelectAll() throws Exception {
            engine.prepare(execCtx);
import org.opensearch.test.OpenSearchTestCase;
        try (
public class DatafusionSearchExecEngineTests extends OpenSearchTestCase {
            execCtx.setAllocator(alloc);  
            readerHandle.getPointer(),
            } finally {
    public void testEngineExecuteAggregation() throws Exception {  
            try (EngineResultStream stream = engine.execute(execCtx)) {
        byte[] substrait = NativeBridge.sqlToSubstrait(
        long boxPtr = NativeStoreTestHelper.getObjectStoreBoxPtr(tieredStorePtr);
            0L,
    private DatafusionReader createReader() {
        WireConfigSnapshot.builder().build().writeTo(configSegment);
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
            RootAllocator alloc = new RootAllocator(Long.MAX_VALUE);  
                int cols = batch.getFieldNames().size();  
import org.opensearch.plugins.NativeStoreHandle;
import org.apache.arrow.memory.BufferAllocator;
                assertEquals(5L, rows.get(0)[0]); // 2 + 3
        NativeBridge.initTokioRuntimeManager(2);  
import java.util.Iterator;  
            runtimeHandle.get()
    public void testEngineExecuteFilter() throws Exception {
        ) {  
        DatafusionReader reader = createReader();
            runtimeHandle.get(),
        while (it.hasNext()) {  
        readerHandle = new ReaderHandle(
        tieredStorePtr = NativeStoreTestHelper.createTieredObjectStore(0L, 0L);  
            BufferAllocator staging = alloc.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);  
    private long tieredStorePtr;  
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
            RootAllocator alloc = new RootAllocator(Long.MAX_VALUE);
}
import org.opensearch.analytics.backend.ShardScanExecutionContext;
 * The OpenSearch Contributors require contributions made to  
    }
            new byte[0]
        List<Object[]> rows = new ArrayList<>();
 * compatible open source license.
    private NativeRuntimeHandle runtimeHandle;
        }
    private NativeStoreHandle storeHandle;
    @Override  
        long ptr = NativeBridge.createGlobalRuntime(128 * 1024 * 1024, 0L, spillDir.toString(), 64 * 1024 * 1024);
        execCtx.setFragmentBytes(substrait);
import java.nio.file.Path;
        ) {
            }
            BufferAllocator staging = alloc.newChildAllocator("arrow-import-staging", 0, Long.MAX_VALUE);
        super.setUp();
        byte[] substrait = NativeBridge.sqlToSubstrait(
            DatafusionSearchExecEngine engine = new DatafusionSearchExecEngine(context)  
import org.opensearch.analytics.backend.EngineResultStream;
        ) {
    }  
    private ShardScanExecutionContext createExecutionContext(String tableName, byte[] substrait, DatafusionContext dfContext) {  
            }
        DatafusionContext context = new DatafusionContext(null, reader, runtimeHandle);
    }
            RootAllocator alloc = new RootAllocator(Long.MAX_VALUE);
                    Object[] row = new Object[cols];
            execCtx.setImportStagingAllocator(staging);
                    for (int c = 0; c < cols; c++) {  
/*  
