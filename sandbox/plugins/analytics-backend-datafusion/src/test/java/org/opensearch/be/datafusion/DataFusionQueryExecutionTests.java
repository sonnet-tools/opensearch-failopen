 *
        );
            List.of(),
        storeHandle.close();
            return rows;
    private long queryConfigPtr;
            listener -> NativeBridge.executeQueryAsync(
        assertEquals(5L, rows.get(0)[0]); // 2 + 3
    private ReaderHandle readerHandle;
            List<Object[]> rows = new ArrayList<>();
import org.apache.arrow.c.Data;
            storeHandle,
    @Override
        Path spillDir = createTempDir("datafusion-spill");
import org.opensearch.plugins.NativeStoreHandle;
            dataDir.toString(),
 * compatible open source license.
        });
    public void testAggregationQuery() throws Exception {
            root.close();
}
        assertEquals(4L, rows.get(0)[2]);
        // Step 2: executeQueryAsync (production path)
        // Step 1: SQL → Substrait (test helper)
        storeHandle = new NativeStoreHandle(boxPtr, NativeStoreTestHelper::destroyObjectStoreBoxPtr);
                    rows.add(row);
    public void testSelectAllQuery() throws Exception {
            Schema schema = new Schema(importField(allocator, ArrowSchema.wrap(schemaAddr), dictProvider).getChildren(), null);
            }
import java.nio.file.Files;
        assertEquals(2L, rows.get(0)[1]);
            while (true) {
        Path dataDir = createTempDir("datafusion-data");
    }
    }
    public void setUp() throws Exception {
            }
                }
    private List<Object[]> executeQuery(String sql) {
            List.of()
    }
/*
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
        assertEquals(3L, rows.get(0)[1]);
                readerHandle.getPointer(),
                0L,
            @Override
import java.util.concurrent.CompletableFuture;
import org.apache.arrow.memory.RootAllocator;
        NativeBridge.shutdownTokioRuntimeManager();
        byte[] substraitBytes = NativeBridge.sqlToSubstrait(readerHandle.getPointer(), "test_table", sql, runtimeHandle.get());
        configArena.close();
        assertNotNull(substraitBytes);
                    for (int c = 0; c < cols; c++) {
        List<Object[]> rows = executeQuery("SELECT SUM(message) as total, COUNT(*) as cnt FROM test_table");
        assertEquals(3L, rows.get(1)[0]);
    private NativeRuntimeHandle runtimeHandle;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
    @Override
        assertEquals(3L, rows.get(0)[0]);
                int cols = root.getFieldVectors().size();
                for (int r = 0; r < root.getRowCount(); r++) {
    }
        assertEquals(1, rows.size());
                        row[c] = root.getFieldVectors().get(c).getObject(r);
 */
            @Override
 * SPDX-License-Identifier: Apache-2.0
 * Tests use sqlToSubstrait to generate plan bytes, then feed them through
import org.opensearch.test.OpenSearchTestCase;
     * and collects all result rows.
import org.apache.arrow.c.ArrowSchema;
        long streamPtr = asyncCall(
        assertEquals(2L, rows.get(0)[0]);
import org.opensearch.core.action.ActionListener;
        // row 0: message=2, message2=3, message3=4
        NativeStoreTestHelper.destroyTieredObjectStore(tieredStorePtr);
        );
        List<Object[]> rows = executeQuery("SELECT message, message2, message3 FROM test_table");
            RootAllocator allocator = new RootAllocator(Long.MAX_VALUE);
                queryConfigPtr,
            }
        // row 1: message=3, message2=4, message3=5
        List<Object[]> rows = executeQuery("SELECT message FROM test_table WHERE message > 2");
    }
                listener
    public void tearDown() throws Exception {
    private NativeStoreHandle storeHandle;
        assertTrue(streamPtr != 0);
    private long asyncCall(java.util.function.Consumer<ActionListener<Long>> call) {
        try (
            List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),
            public void onFailure(Exception e) {
                substraitBytes,
        NativeBridge.initTokioRuntimeManager(2);
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
            StreamHandle streamHandle = new StreamHandle(streamPtr, runtimeHandle);
        WireConfigSnapshot.builder().build().writeTo(configSegment);
 * End-to-end test: SQL → Substrait → executeQueryAsync → Arrow C Data → Java.
        CompletableFuture<Long> future = new CompletableFuture<>();
    }
        assertTrue(substraitBytes.length > 0);
import org.opensearch.be.datafusion.nativelib.StreamHandle;
/**
import java.util.ArrayList;
import org.opensearch.index.engine.exec.MonoFileWriterSet;
import java.util.List;
package org.opensearch.be.datafusion;
        queryConfigPtr = configSegment.address();
     */
        super.setUp();
        call.accept(new ActionListener<>() {
        );
import org.apache.arrow.vector.VectorSchemaRoot;
            NativeBridge.createGlobalRuntime(128 * 1024 * 1024, 0L, spillDir.toString(), 64 * 1024 * 1024)
                Data.importIntoVectorSchemaRoot(allocator, ArrowArray.wrap(arrayAddr), root, dictProvider);
import java.nio.file.Path;
    }
 */
import org.apache.arrow.c.CDataDictionaryProvider;
        assertEquals(1, rows.size());
    private Arena configArena;
        MemorySegment configSegment = configArena.allocate(WireConfigSnapshot.BYTE_SIZE);
        }
            public void onResponse(Long v) {
        return future.join();
                long arrayAddr = asyncCall(listener -> NativeBridge.streamNext(runtimeHandle.get(), streamHandle.getPointer(), listener));
                    }
        readerHandle.close();
import java.lang.foreign.MemorySegment;
import org.apache.arrow.c.ArrowArray;
import static org.apache.arrow.c.Data.importField;
                future.completeExceptionally(e);
import org.apache.arrow.vector.types.pojo.Schema;
                if (arrayAddr == 0) break;
import java.lang.foreign.Arena;
     * Converts SQL → substrait bytes, then executes via the real executeQueryAsync path,
 * the same executeQueryAsync path used in production.
            )
import org.opensearch.be.datafusion.nativelib.NativeBridge;
                    Object[] row = new Object[cols];
                "test_table",
    private long tieredStorePtr;
                runtimeHandle.get(),
                future.complete(v);
            VectorSchemaRoot root = VectorSchemaRoot.create(schema, allocator);
        // Step 3: Read results via Arrow C Data
        tieredStorePtr = NativeStoreTestHelper.createTieredObjectStore(0L, 0L);
        super.tearDown();
        configArena = Arena.ofConfined();
        runtimeHandle.close();
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
        readerHandle = new ReaderHandle(
        long boxPtr = NativeStoreTestHelper.getObjectStoreBoxPtr(tieredStorePtr);
        // Create a real TieredObjectStore (local-only) and wrap in NativeStoreHandle
        runtimeHandle = new NativeRuntimeHandle(
    public void testFilterQuery() throws Exception {
        assertEquals(2, rows.size());
    /**
            CDataDictionaryProvider dictProvider = new CDataDictionaryProvider()
public class DataFusionQueryExecutionTests extends OpenSearchTestCase {
        ) {
            long schemaAddr = asyncCall(listener -> NativeBridge.streamGetSchema(streamHandle.getPointer(), listener));
