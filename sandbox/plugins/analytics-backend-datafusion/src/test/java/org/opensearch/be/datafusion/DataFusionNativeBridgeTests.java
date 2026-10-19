            lib.find("ts_get_object_store_box_ptr").orElseThrow(),  
            throw new RuntimeException("Failed to destroy object store box ptr", t);
        readerHandle.close();
        NativeBridge.closeGlobalRuntime(runtimePtr);
    // FFM helpers for TieredObjectStore (inline — avoids dependency on parquet-data-format)  
            java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG)
        Path spillDir = createTempDir("datafusion-spill");  
        byte[] substrait = NativeBridge.sqlToSubstrait(
            lib.find("ts_destroy_object_store_box_ptr").orElseThrow(),
            runtimeHandle.get(),
 */  
    private static void destroyObjectStoreBoxPtr(long ptr) {  
        // Wrap in NativeStoreHandle with proper cleanup
package org.opensearch.be.datafusion;
        readerHandle.close();
        assertTrue("Box pointer should be non-zero", boxPtr > 0);  
        } catch (Throwable t) {
        assertTrue("Runtime pointer should be non-zero", runtimePtr != 0);
            public void onFailure(Exception exception) {  
    }
        // Verify the pointer is no longer in the live registry and the wrapper rejects getPointer().
    // executor and other test classes (DatafusionSearchExecEngineTests, etc.) will fail
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
        NativeBridge.streamClose(streamPtr);  
        Path spillDir = createTempDir("datafusion-spill");  
        ReaderHandle readerHandle = new ReaderHandle(  
        long tieredStorePtr = NativeStoreTestHelper.createTieredObjectStore(0L, 0L);
        SessionContextHandle sessionCtx = NativeBridge.createSessionContext(  
            java.util.List.of()  
            public void onResponse(Long streamPtr) {
            throw new RuntimeException("Failed to get object store box ptr", t);
        );  
        try {  
    private static long getObjectStoreBoxPtr(long tieredStorePtr) {
        var linker = java.lang.foreign.Linker.nativeLinker();
     */  
        Path spillDir = createTempDir("datafusion-spill");  
        );
            runtimeHandle.get()  
        long boxPtr = NativeStoreTestHelper.getObjectStoreBoxPtr(tieredStorePtr);
        TS_DESTROY = linker.downcallHandle(
        long queryConfigPtr;  
            "SELECT message FROM test_table",
        // Create reader
            32 * 1024 * 1024 // 32MB spill
        }
        NativeBridge.closeGlobalRuntime(runtimePtr);  
    private static long createTieredObjectStore(long localPtr, long remotePtr) {  
            java.util.List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),  
            64 * 1024 * 1024, // 64MB
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);  
        // executeWithContextAsync marks the handle consumed (which closes the Java wrapper).
            readerHandle.getPointer(),
    }
    }
            "test_table",
        TS_GET_BOX_PTR = linker.downcallHandle(
        TS_CREATE = linker.downcallHandle(
        var lib = org.opensearch.nativebridge.spi.NativeLibraryLoader.symbolLookup();  
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
    }  
            }  
import java.util.concurrent.CompletableFuture;
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("Reader pointer should be non-zero", readerHandle.getPointer() != 0);
            }
            false,
        assertTrue("TieredObjectStore pointer should be non-zero", tieredStorePtr > 0);
        Path dataDir = createTempDir("datafusion-data");
    }  
        NativeBridge.initTokioRuntimeManager(2);
            List.of(MonoFileWriterSet.of(dataDir.toString(), 1L, "test.parquet", 0L)),  
                future.completeExceptionally(exception);
        try {
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
            lib.find("ts_destroy_tiered_object_store").orElseThrow(),
        // Create global runtime with small memory pool
 * SPDX-License-Identifier: Apache-2.0
    }
            dataDir.toString(),
import java.nio.file.Files;
    private static void destroyTieredObjectStore(long ptr) {
import java.util.List;
                java.lang.foreign.ValueLayout.JAVA_LONG,
// The Tokio runtime worker threads are process-lifetime singletons that persist after tests complete.
        // Create session context with table registered
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;  
 * Verifies native library loading, runtime creation, and reader lifecycle.  
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            0L,  
            org.opensearch.nativebridge.spi.NativeLibraryLoader.checkResult((long) TS_DESTROY_BOX_PTR.invokeExact(ptr));
        assertTrue("Stream pointer should be non-zero", streamPtr != 0);
        NativeBridge.closeGlobalRuntime(runtimePtr);
            spillDir.toString(),
// They cannot be shut down without breaking other test classes that share the same JVM.  
        runtimeHandle.close();
import org.opensearch.analytics.backend.jni.NativeHandle;  
        // (which closes the Java wrapper), so getPointer() would throw IllegalStateException.  
        // Capture the pointer value BEFORE execute — after execute the handle is marked consumed
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
import org.opensearch.index.engine.exec.MonoFileWriterSet;
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        );
            @Override  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
    public void testReaderWithRealNativeStoreHandle() throws Exception {
            org.opensearch.nativebridge.spi.NativeLibraryLoader.checkResult((long) TS_DESTROY.invokeExact(ptr));
            null,
    // with "Worker gone" if they run after this class.
        Path spillDir = createTempDir("datafusion-spill");
        // ts_create_tiered_object_store(0, 0) → default LocalFileSystem, no remote  
        long sessionCtxPtrBefore = sessionCtx.getPointer();
    }  
            @Override
        assertTrue("SessionContext pointer should be non-zero", sessionCtx.getPointer() != 0);
 * Smoke test for the DataFusion JNI bridge.
            List.of()  
            java.util.List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),
        try {
        // Clean up the per-test runtime only  
        Files.copy(testParquet, dataDir.resolve("test.parquet"));  
import org.opensearch.plugins.NativeStoreHandle;  
import org.opensearch.core.action.ActionListener;
        NativeBridge.initTokioRuntimeManager(2);  
    // ═══════════════════════════════════════════════════════════════
        // Execute a simple query to verify the session context is properly configured
        } catch (Throwable t) {  
        Files.copy(testParquet, dataDir.resolve("test.parquet"));  
        // Init tokio runtime (no-op if already initialized by another test class)
            storeHandle,
            return org.opensearch.nativebridge.spi.NativeLibraryLoader.checkResult((long) TS_CREATE.invokeExact(localPtr, remotePtr));
            java.lang.foreign.FunctionDescriptor.of(
        } catch (Throwable t) {  
        // Close reader  
        Path dataDir = createTempDir("datafusion-data");
        Arena arena = Arena.ofConfined();
 * The OpenSearch Contributors require contributions made to  
        // Clean up in reverse order
            java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG)
            java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG)  
            return org.opensearch.nativebridge.spi.NativeLibraryLoader.checkResult((long) TS_GET_BOX_PTR.invokeExact(tieredStorePtr));  
        // Create a real TieredObjectStore via FFM (local-only, no remote)
            false,  
    // Note: initTokioRuntimeManager uses OnceLock and can only be initialized once per JVM.
        });  
        MemorySegment configSegment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
        expectThrows(IllegalStateException.class, sessionCtx::getPointer);
                java.lang.foreign.ValueLayout.JAVA_LONG,  
import java.nio.file.Path;  
                future.complete(streamPtr);
    public void testSessionContextCreationAndTableRegistration() throws Exception {  
        WireConfigSnapshot.builder().build().writeTo(configSegment);  
            java.util.List.of(),
        // Create reader with the real store handle — this proves the full wiring  
        // Copy test parquet to a temp dir  
        assertFalse("SessionContextHandle pointer must no longer be live after execute", NativeHandle.isLivePointer(sessionCtxPtrBefore));  
            throw new RuntimeException("Failed to destroy TieredObjectStore", t);  
        CompletableFuture<Long> future = new CompletableFuture<>();
    }  
        ReaderHandle readerHandle = new ReaderHandle(
            readerHandle.getPointer(),  
        );  
        // Copy test parquet to a temp dir  
            throw new RuntimeException("Failed to create TieredObjectStore", t);
/*  
    private static final java.lang.invoke.MethodHandle TS_CREATE;  
        assertTrue("NativeStoreHandle should be live", storeHandle.isLive());
     * End-to-end test: create a real TieredObjectStore via FFM, wrap it in NativeStoreHandle,  
    /**
            java.util.List.of(),
import org.opensearch.test.OpenSearchTestCase;
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            List.of(),
        NativeBridge.initTokioRuntimeManager(2);
    private static final java.lang.invoke.MethodHandle TS_DESTROY_BOX_PTR;  
    public void testRuntimeLifecycle() {
        } catch (Throwable t) {
     * tiered storage → DataFusion reader with a real object store backing reads.
    private static final java.lang.invoke.MethodHandle TS_GET_BOX_PTR;
        assertTrue("SessionContext pointer should be live before execute", NativeHandle.isLivePointer(sessionCtxPtrBefore));
        );  
            queryConfigPtr,
        readerHandle.close();
        );  
        }  
}
        TS_DESTROY_BOX_PTR = linker.downcallHandle(  
    private static final java.lang.invoke.MethodHandle TS_DESTROY;
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
    // ═══════════════════════════════════════════════════════════════
     * and pass it to ReaderHandle. Proves the full native wiring works — Java → FFM → Rust
        long runtimePtr = NativeBridge.createGlobalRuntime(
        NativeBridge.initTokioRuntimeManager(2);
        queryConfigPtr = configSegment.address();
        storeHandle.close();  
public class DataFusionNativeBridgeTests extends OpenSearchTestCase {  
            0L,
            dataDir.toString(),
        }
        );
import java.lang.foreign.MemorySegment;
                java.lang.foreign.ValueLayout.JAVA_LONG
 * compatible open source license.
        );  
            java.util.List.of()
    }
        NativeBridge.executeWithContextAsync(sessionCtx, substrait, new ActionListener<>() {
        Path dataDir = createTempDir("datafusion-data");  
 *
/**
    // Do NOT call shutdownTokioRuntimeManager() here — it permanently kills the shared  
        }
        try {
            "test_table",  
        );
            )
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        // Get a Box<Arc<dyn ObjectStore>> pointer for DataFusion
            null,  
        NativeStoreTestHelper.destroyTieredObjectStore(tieredStorePtr);
        arena.close();
            lib.find("ts_create_tiered_object_store").orElseThrow(),  
    static {
        NativeStoreHandle storeHandle = new NativeStoreHandle(boxPtr, NativeStoreTestHelper::destroyObjectStoreBoxPtr);  
import java.lang.foreign.Arena;  
        long streamPtr = future.join();
            new byte[0]
        ReaderHandle readerHandle = new ReaderHandle(
        assertTrue("Reader pointer should be non-zero", readerHandle.getPointer() != 0);
    public void testReaderLifecycle() throws Exception {
 */
        );
            dataDir.toString(),
