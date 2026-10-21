        Arena arena = Arena.ofConfined();
            )
import org.opensearch.analytics.backend.jni.NativeHandle;
            throw new RuntimeException("Failed to destroy TieredObjectStore", t);
            List.of(MonoFileWriterSet.of(dataDir.toString(), 1L, "test.parquet", 0L)),
        MemorySegment configSegment = arena.allocate(WireConfigSnapshot.BYTE_SIZE);
            lib.find("ts_destroy_object_store_box_ptr").orElseThrow(),
        Path spillDir = createTempDir("datafusion-spill");
import org.opensearch.plugins.NativeStoreHandle;
        // Init tokio runtime (no-op if already initialized by another test class)
            storeHandle,
        NativeBridge.initTokioRuntimeManager(2);
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
            List.of(),
        );
        assertTrue("NativeStoreHandle should be live", storeHandle.isLive());
        // executeWithContextAsync marks the handle consumed (which closes the Java wrapper).
        } catch (Throwable t) {
        // Clean up in reverse order
        try {
        }
            32 * 1024 * 1024 // 32MB spill
        ReaderHandle readerHandle = new ReaderHandle(
            lib.find("ts_destroy_tiered_object_store").orElseThrow(),
     * and pass it to ReaderHandle. Proves the full native wiring works — Java → FFM → Rust
            runtimeHandle.get(),
                java.lang.foreign.ValueLayout.JAVA_LONG,
        NativeStoreHandle storeHandle = new NativeStoreHandle(boxPtr, NativeStoreTestHelper::destroyObjectStoreBoxPtr);
            "test_table",
        TS_GET_BOX_PTR = linker.downcallHandle(
     * End-to-end test: create a real TieredObjectStore via FFM, wrap it in NativeStoreHandle,
            org.opensearch.nativebridge.spi.NativeLibraryLoader.checkResult((long) TS_DESTROY_BOX_PTR.invokeExact(ptr));
            queryConfigPtr,
                java.lang.foreign.ValueLayout.JAVA_LONG
    static {
    // executor and other test classes (DatafusionSearchExecEngineTests, etc.) will fail
            return org.opensearch.nativebridge.spi.NativeLibraryLoader.checkResult((long) TS_CREATE.invokeExact(localPtr, remotePtr));
    }
        // Get a Box<Arc<dyn ObjectStore>> pointer for DataFusion
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
    private static final java.lang.invoke.MethodHandle TS_DESTROY;
 * Smoke test for the DataFusion JNI bridge.
        readerHandle.close();
        // Clean up the per-test runtime only
            64 * 1024 * 1024, // 64MB
        assertTrue("Runtime pointer should be non-zero", runtimePtr != 0);
            }
            }
        arena.close();
    }
            null,
            0L,
    private static final java.lang.invoke.MethodHandle TS_DESTROY_BOX_PTR;
        NativeBridge.initTokioRuntimeManager(2);
            new byte[0]
            dataDir.toString(),
        // Wrap in NativeStoreHandle with proper cleanup
        long tieredStorePtr = NativeStoreTestHelper.createTieredObjectStore(0L, 0L);
        assertFalse("SessionContextHandle pointer must no longer be live after execute", NativeHandle.isLivePointer(sessionCtxPtrBefore));
        assertTrue("Reader pointer should be non-zero", readerHandle.getPointer() != 0);
            java.util.List.of()
        Path dataDir = createTempDir("datafusion-data");
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG)
                java.lang.foreign.ValueLayout.JAVA_LONG,
        );
        );
            @Override
        try {
        }
        } catch (Throwable t) {
        NativeRuntimeHandle runtimeHandle = new NativeRuntimeHandle(runtimePtr);
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
            java.util.List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),
     */
        ReaderHandle readerHandle = new ReaderHandle(
 * this file be licensed under the Apache-2.0 license or a
            throw new RuntimeException("Failed to create TieredObjectStore", t);
        } catch (Throwable t) {
/*
public class DataFusionNativeBridgeTests extends OpenSearchTestCase {
    }
        // Create global runtime with small memory pool
            dataDir.toString(),
        queryConfigPtr = configSegment.address();
            false,
        }
            "test_table",
        assertTrue("Stream pointer should be non-zero", streamPtr != 0);
    }
            java.util.List.of(),
 */
            public void onResponse(Long streamPtr) {
            readerHandle.getPointer(),
        long runtimePtr = NativeBridge.createGlobalRuntime(
        var linker = java.lang.foreign.Linker.nativeLinker();
import org.opensearch.be.datafusion.nativelib.NativeBridge;
        try {
        try {
    // Note: initTokioRuntimeManager uses OnceLock and can only be initialized once per JVM.
        );
        TS_DESTROY = linker.downcallHandle(
            null,
            spillDir.toString(),
import java.util.concurrent.CompletableFuture;
        // Create reader with the real store handle — this proves the full wiring
    private static void destroyTieredObjectStore(long ptr) {
import java.nio.file.Files;
    /**
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            java.lang.foreign.FunctionDescriptor.of(
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;
        long sessionCtxPtrBefore = sessionCtx.getPointer();
    private static final java.lang.invoke.MethodHandle TS_CREATE;
        NativeBridge.closeGlobalRuntime(runtimePtr);
    public void testReaderLifecycle() throws Exception {
        );
 * compatible open source license.
        ReaderHandle readerHandle = new ReaderHandle(
        Path dataDir = createTempDir("datafusion-data");
        NativeBridge.streamClose(streamPtr);
        WireConfigSnapshot.builder().build().writeTo(configSegment);
        SessionContextHandle sessionCtx = NativeBridge.createSessionContext(
            dataDir.toString(),
    private static long createTieredObjectStore(long localPtr, long remotePtr) {
        NativeBridge.initTokioRuntimeManager(2);
        );
            lib.find("ts_create_tiered_object_store").orElseThrow(),
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
    private static final java.lang.invoke.MethodHandle TS_GET_BOX_PTR;
        }
        Path spillDir = createTempDir("datafusion-spill");
        // Capture the pointer value BEFORE execute — after execute the handle is marked consumed
    // with "Worker gone" if they run after this class.
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
        // Copy test parquet to a temp dir
            @Override
 */
import java.nio.file.Path;
        Path dataDir = createTempDir("datafusion-data");
            List.of()
            readerHandle.getPointer(),
    // FFM helpers for TieredObjectStore (inline — avoids dependency on parquet-data-format)
import java.lang.foreign.Arena;
        TS_DESTROY_BOX_PTR = linker.downcallHandle(
            java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG)
    private static void destroyObjectStoreBoxPtr(long ptr) {
        // Create reader
        long queryConfigPtr;
        NativeBridge.closeGlobalRuntime(runtimePtr);
        assertTrue("Box pointer should be non-zero", boxPtr > 0);
        );
    }
 * Verifies native library loading, runtime creation, and reader lifecycle.
        long runtimePtr = NativeBridge.createGlobalRuntime(64 * 1024 * 1024, 0L, spillDir.toString(), 32 * 1024 * 1024);
        TS_CREATE = linker.downcallHandle(
     * tiered storage → DataFusion reader with a real object store backing reads.
            public void onFailure(Exception exception) {
        assertTrue("TieredObjectStore pointer should be non-zero", tieredStorePtr > 0);
        var lib = org.opensearch.nativebridge.spi.NativeLibraryLoader.symbolLookup();
        // Create session context with table registered
            java.lang.foreign.FunctionDescriptor.of(java.lang.foreign.ValueLayout.JAVA_LONG, java.lang.foreign.ValueLayout.JAVA_LONG)
        // Execute a simple query to verify the session context is properly configured
        byte[] substrait = NativeBridge.sqlToSubstrait(
        } catch (Throwable t) {
        storeHandle.close();
        // Close reader
 * The OpenSearch Contributors require contributions made to
        Path spillDir = createTempDir("datafusion-spill");
        // Verify the pointer is no longer in the live registry and the wrapper rejects getPointer().
        );
    // ═══════════════════════════════════════════════════════════════
// They cannot be shut down without breaking other test classes that share the same JVM.
import org.opensearch.core.action.ActionListener;
import org.opensearch.test.OpenSearchTestCase;
    public void testReaderWithRealNativeStoreHandle() throws Exception {
package org.opensearch.be.datafusion;
            throw new RuntimeException("Failed to get object store box ptr", t);
        runtimeHandle.close();
import java.util.List;
        readerHandle.close();
            return org.opensearch.nativebridge.spi.NativeLibraryLoader.checkResult((long) TS_GET_BOX_PTR.invokeExact(tieredStorePtr));
        // ts_create_tiered_object_store(0, 0) → default LocalFileSystem, no remote
/**
 *
// The Tokio runtime worker threads are process-lifetime singletons that persist after tests complete.
        readerHandle.close();
        // Copy test parquet to a temp dir
    // Do NOT call shutdownTokioRuntimeManager() here — it permanently kills the shared
        // (which closes the Java wrapper), so getPointer() would throw IllegalStateException.
        long boxPtr = NativeStoreTestHelper.getObjectStoreBoxPtr(tieredStorePtr);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.be.datafusion.nativelib.ReaderHandle;
        });
import org.opensearch.index.engine.exec.MonoFileWriterSet;
        );
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
        long streamPtr = future.join();
    }
        CompletableFuture<Long> future = new CompletableFuture<>();
    }
        NativeStoreTestHelper.destroyTieredObjectStore(tieredStorePtr);
            java.util.List.of(),
import java.lang.foreign.MemorySegment;
        NativeBridge.closeGlobalRuntime(runtimePtr);
    // ═══════════════════════════════════════════════════════════════
        NativeBridge.initTokioRuntimeManager(2);
        Path spillDir = createTempDir("datafusion-spill");
        Path testParquet = Path.of(getClass().getClassLoader().getResource("test.parquet").toURI());
            0L,
            java.util.List.of(MonoFileWriterSet.of(".", 0L, "test.parquet", 0L)),
        assertTrue("SessionContext pointer should be non-zero", sessionCtx.getPointer() != 0);
            runtimeHandle.get()
        assertTrue("Reader pointer should be non-zero", readerHandle.getPointer() != 0);
                future.completeExceptionally(exception);
        );
        expectThrows(IllegalStateException.class, sessionCtx::getPointer);
            false,
    private static long getObjectStoreBoxPtr(long tieredStorePtr) {
            throw new RuntimeException("Failed to destroy object store box ptr", t);
            java.util.List.of()
    public void testRuntimeLifecycle() {
            lib.find("ts_get_object_store_box_ptr").orElseThrow(),
            org.opensearch.nativebridge.spi.NativeLibraryLoader.checkResult((long) TS_DESTROY.invokeExact(ptr));
        // Create a real TieredObjectStore via FFM (local-only, no remote)
    public void testSessionContextCreationAndTableRegistration() throws Exception {
        assertTrue("SessionContext pointer should be live before execute", NativeHandle.isLivePointer(sessionCtxPtrBefore));
    }
        NativeBridge.executeWithContextAsync(sessionCtx, substrait, new ActionListener<>() {
        Files.copy(testParquet, dataDir.resolve("test.parquet"));
                future.complete(streamPtr);
            "SELECT message FROM test_table",
    }
}
