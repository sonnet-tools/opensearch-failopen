                substraitBytes,
            public void onResponse(Long v) {
                long arrayAddr = asyncCall(listener -> NativeBridge.streamNext(runtimeHandle.get(), streamHandle.getPointer(), listener));
            }  
import org.apache.arrow.c.ArrowSchema;
/*  
        assertEquals(5L, rows.get(0)[0]); // 2 + 3  
            List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),
import java.lang.foreign.Arena;
        Path dataDir = createTempDir("datafusion-data");  
            @Override  
            while (true) {
import static org.apache.arrow.c.Data.importField;  
    public void tearDown() throws Exception {  
                    for (int c = 0; c < cols; c++) {
        queryConfigPtr = configSegment.address();
            public void onFailure(Exception e) {
import org.opensearch.index.engine.exec.MonoFileWriterSet;  
    /**
     */
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
        NativeBridge.shutdownTokioRuntimeManager();  
    }
/**
        runtimeHandle.close();
                future.complete(v);  
    public void testAggregationQuery() throws Exception {  
    private NativeStoreHandle storeHandle;
 * the same executeQueryAsync path used in production.
            long schemaAddr = asyncCall(listener -> NativeBridge.streamGetSchema(streamHandle.getPointer(), listener));
        super.tearDown();
        readerHandle.close();
    private List<Object[]> executeQuery(String sql) {
    }
        assertEquals(1, rows.size());
        assertEquals(2L, rows.get(0)[0]);
        List<Object[]> rows = executeQuery("SELECT message, message2, message3 FROM test_table");
        // Create a real TieredObjectStore (local-only) and wrap in NativeStoreHandle
                    Object[] row = new Object[cols];
        );
        super.setUp();  
            }
                listener
 */  
import org.opensearch.core.action.ActionListener;
            List.of(),
     * Converts SQL → substrait bytes, then executes via the real executeQueryAsync path,
    }
        WireConfigSnapshot.builder().build().writeTo(configSegment);
    public void setUp() throws Exception {
    }  
        // Step 3: Read results via Arrow C Data
                readerHandle.getPointer(),
            NativeBridge.createGlobalRuntime(128 * 1024 * 1024, 0L, spillDir.toString(), 64 * 1024 * 1024)
import org.opensearch.plugins.NativeStoreHandle;
package org.opensearch.be.datafusion;
                int cols = root.getFieldVectors().size();
    @Override
        NativeBridge.initTokioRuntimeManager(2);
            CDataDictionaryProvider dictProvider = new CDataDictionaryProvider()
                future.completeExceptionally(e);
                if (arrayAddr == 0) break;  
 * The OpenSearch Contributors require contributions made to  
        long streamPtr = asyncCall(  
        );
import java.util.ArrayList;
        List<Object[]> rows = executeQuery("SELECT SUM(message) as total, COUNT(*) as cnt FROM test_table");
        assertEquals(3L, rows.get(1)[0]);  
import java.nio.file.Path;
        storeHandle = new NativeStoreHandle(boxPtr, NativeStoreTestHelper::destroyObjectStoreBoxPtr);
            Schema schema = new Schema(importField(allocator, ArrowSchema.wrap(schemaAddr), dictProvider).getChildren(), null);  
        // Step 1: SQL → Substrait (test helper)  
        );  
            List.of()
        // Step 2: executeQueryAsync (production path)
 * End-to-end test: SQL → Substrait → executeQueryAsync → Arrow C Data → Java.  
                runtimeHandle.get(),
import org.opensearch.be.datafusion.nativelib.NativeBridge;
import java.lang.foreign.MemorySegment;
                }  
        byte[] substraitBytes = NativeBridge.sqlToSubstrait(readerHandle.getPointer(), "test_table", sql, runtimeHandle.get());
        assertEquals(4L, rows.get(0)[2]);
        assertEquals(1, rows.size());
    private ReaderHandle readerHandle;
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.CompletableFuture;
        CompletableFuture<Long> future = new CompletableFuture<>();
            List<Object[]> rows = new ArrayList<>();
    }
            return rows;  
            storeHandle,  
    }  
 */  
        assertEquals(2L, rows.get(0)[1]);
        assertTrue(streamPtr != 0);
            listener -> NativeBridge.executeQueryAsync(
        });
        List<Object[]> rows = executeQuery("SELECT message FROM test_table WHERE message > 2");
import org.apache.arrow.c.Data;
        try (
        Path spillDir = createTempDir("datafusion-spill");
import java.util.List;  
            VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
            StreamHandle streamHandle = new StreamHandle(streamPtr, runtimeHandle);  
 *
            }
    @Override
            root.close();
                Data.importIntoVectorSchemaRoot(allocator, ArrowArray.wrap(arrayAddr), root, dictProvider);
    }
 * Tests use sqlToSubstrait to generate plan bytes, then feed them through
            RootAllocator allocator = new RootAllocator(Long.MAX_VALUE);
 * compatible open source license.
import org.opensearch.be.datafusion.nativelib.StreamHandle;
                        row[c] = root.getFieldVectors().get(c).getObject(r);  
        assertEquals(2, rows.size());  
import org.apache.arrow.vector.types.pojo.Schema;
import java.nio.file.Files;  
import org.apache.arrow.c.ArrowArray;
        storeHandle.close();  
    private long tieredStorePtr;
    public void testSelectAllQuery() throws Exception {
        assertTrue(substraitBytes.length > 0);  
                0L,  
                    rows.add(row);
                    }
}
        ) {  
            )  
        readerHandle = new ReaderHandle(  
    private Arena configArena;
        long boxPtr = NativeStoreTestHelper.getObjectStoreBoxPtr(tieredStorePtr);  
    private NativeRuntimeHandle runtimeHandle;  
        NativeStoreTestHelper.destroyTieredObjectStore(tieredStorePtr);
                for (int r = 0; r < root.getRowCount(); r++) {  
        return future.join();
public class DataFusionQueryExecutionTests extends OpenSearchTestCase {
import org.apache.arrow.c.CDataDictionaryProvider;  
        call.accept(new ActionListener<>() {  
        // row 0: message=2, message2=3, message3=4
        configArena = Arena.ofConfined();
            dataDir.toString(),
        // row 1: message=3, message2=4, message3=5
                queryConfigPtr,
        }
        assertNotNull(substraitBytes);
        runtimeHandle = new NativeRuntimeHandle(  
import org.apache.arrow.memory.RootAllocator;
 * SPDX-License-Identifier: Apache-2.0
    private long queryConfigPtr;  
import org.apache.arrow.vector.VectorSchemaRoot;  
                "test_table",  
    private long asyncCall(java.util.function.Consumer<ActionListener<Long>> call) {
import org.opensearch.be.datafusion.nativelib.ReaderHandle;  
        tieredStorePtr = NativeStoreTestHelper.createTieredObjectStore(0L, 0L);
import org.opensearch.test.OpenSearchTestCase;
        configArena.close();
            @Override
     * and collects all result rows.  
        assertEquals(3L, rows.get(0)[1]);  
    public void testFilterQuery() throws Exception {  
        MemorySegment configSegment = configArena.allocate(WireConfigSnapshot.BYTE_SIZE);  
        assertEquals(3L, rows.get(0)[0]);  
