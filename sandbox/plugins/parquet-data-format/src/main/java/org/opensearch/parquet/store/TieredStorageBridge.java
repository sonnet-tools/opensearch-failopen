            lib.find("ts_register_files").orElseThrow(),
 * {@code path\nremotePath\nsize\npath\nremotePath\nsize\n...}. Empty remotePath for LOCAL files.  
                ValueLayout.JAVA_LONG,
     * @param location 0=Local, 1=Remote
                ValueLayout.JAVA_LONG,   // remote_store_box_ptr (0 = no remote)
import java.lang.foreign.MemorySegment;  
        );
    private static final MethodHandle DESTROY;  
    private static final MethodHandle CREATE;
    }
                ValueLayout.JAVA_LONG,   // return: Arc<TieredObjectStore> ptr
        sb.setLength(sb.length() - 1);
        if (DESTROY_OBJECT_STORE_BOX_PTR == null) return;
    }  
            FunctionDescriptor.of(
                ValueLayout.JAVA_LONG    // cache_box_ptr (0 = no cache)
            NativeLibraryLoader.checkResult((long) DESTROY_OBJECT_STORE_BOX_PTR.invokeExact(boxPtr));  
    }  
     */  
     * No-op if the native symbol is not available (stale library).  
        GET_OBJECT_STORE_BOX_PTR = linker.downcallHandle(  
 */  
     * The returned pointer shares ownership with the original — free it with destroyObjectStoreBoxPtr.
        String entries = sb.toString();
        try {
        );
public final class TieredStorageBridge {  
        // i64 ts_create_tiered_object_store(i64 local, i64 remote, i64 cache)
 *
 * The OpenSearch Contributors require contributions made to  
            return NativeLibraryLoader.checkResult((long) GET_OBJECT_STORE_BOX_PTR.invokeExact(tieredStorePtr));  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
    public static long createTieredObjectStore(long localStorePtr, long remoteStorePtr, long cacheBoxPtr) {  
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
        try {
     */  
            return NativeLibraryLoader.checkResult((long) CREATE.invokeExact(localStorePtr, remoteStorePtr, cacheBoxPtr));
        } catch (Throwable t) {  
 * and block-cache pointer helpers.  
     * Free a Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer returned by getObjectStoreBoxPtr.
     * @param path     blob path (remote path for REMOTE, local path for LOCAL)  
            sb.append(size).append('\n');
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
import java.lang.foreign.Linker;
     * @param fileToPath map of file path to remote path (remote path can be empty for Local)
        try (Arena arena = Arena.ofConfined()) {  
    }  
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
    public static void registerFiles(long storePtr, java.util.Map<String, String> fileToPath, int location, long size) {
        }  
     * @param remoteStorePtr Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer, or 0 for no remote
import java.lang.foreign.Arena;  
            MemorySegment seg = arena.allocateFrom(path);
     * @return Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer for DataFusion
        );
        try (Arena arena = Arena.ofConfined()) {  
     * @param size     file size in bytes
                ValueLayout.JAVA_INT,
     * @param storePtr   native pointer to the TieredObjectStore  
            FunctionDescriptor.of(
    public static void destroyTieredObjectStore(long ptr) {  
 * this file be licensed under the Apache-2.0 license or a
        }
     */
            lib.find("ts_get_object_store_box_ptr").orElseThrow(),
 */
        DESTROY = linker.downcallHandle(
                ValueLayout.JAVA_LONG,  
        REGISTER_FILES = linker.downcallHandle(  
        }
        registerFiles(storePtr, java.util.Map.of(file, path != null ? path : ""), location, size);
     * @param cacheBoxPtr    block cache pointer, or 0 for no cache  
    public static void removeFile(long storePtr, String path) {
     *
     * @param size       file size in bytes (applied to all files in batch)  
     *  
     * This is the format that DataFusion's df_create_reader expects.
     * Register a single file in the registry with its own location and size.
 *
    private static final MethodHandle DESTROY_OBJECT_STORE_BOX_PTR;
        for (java.util.Map.Entry<String, String> e : fileToPath.entrySet()) {
        CREATE = linker.downcallHandle(
            );
 * This avoids per-file FFM overhead when seeding hundreds of files at shard open.
    public static void destroyObjectStoreBoxPtr(long boxPtr) {
        REMOVE_FILE = linker.downcallHandle(
     */
     *  
        } catch (Throwable t) {  
    public static long getObjectStoreBoxPtr(long tieredStorePtr) {
                (long) REGISTER_FILES.invokeExact(storePtr, seg, (long) entries.length(), fileToPath.size(), location)  
            NativeLibraryLoader.checkResult((long) REMOVE_FILE.invokeExact(storePtr, seg, (long) path.length()));
    }
            sb.append(e.getKey()).append('\n');  
            lib.find("ts_destroy_tiered_object_store").orElseThrow(),  
    /**
        // Optional — graceful if native library is stale and symbol not yet available.
        } catch (Throwable t) {  
        } catch (Throwable t) {
 * SPDX-License-Identifier: Apache-2.0
        try {
     * @param location   0=Local, 1=Remote
            throw new RuntimeException("Failed to create TieredObjectStore", t);
            NativeLibraryLoader.checkResult((long) DESTROY.invokeExact(ptr));
     *  
            .orElse(null);
        DESTROY_OBJECT_STORE_BOX_PTR = lib.find("ts_destroy_object_store_box_ptr")
        Linker linker = Linker.nativeLinker();
        }
        } catch (Throwable t) {
     * Register files in the registry. Batch format: triplets of path\nremotePath\nsize\n...  
            )  
        if (fileToPath.isEmpty()) return;  
                ValueLayout.JAVA_LONG,  
    private static final MethodHandle GET_OBJECT_STORE_BOX_PTR;  
        }
import java.lang.foreign.FunctionDescriptor;
     * Create a TieredObjectStore with optional local store, remote store, and block cache.
}
            throw new RuntimeException("Failed to register " + fileToPath.size() + " files", t);  
    public static void registerFile(long storePtr, String file, String path, int location, long size) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        } catch (Throwable t) {
            throw new RuntimeException("Failed to destroy object store box ptr", t);
     * @return native Arc&lt;TieredObjectStore&gt; pointer
            sb.append(e.getValue() != null ? e.getValue() : "").append('\n');
        try {
 *
            .map(sym -> linker.downcallHandle(sym, FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)))  
        StringBuilder sb = new StringBuilder();
            throw new RuntimeException("Failed to remove file: " + path, t);
            lib.find("ts_remove_file").orElseThrow(),  
            )  
/*  
    }  
            throw new RuntimeException("Failed to destroy TieredObjectStore", t);
        }  
     * @param storePtr native pointer to the TieredObjectStore
                ValueLayout.ADDRESS,
 * <p>The {@code registerFiles} method uses a newline-delimited batch format:
     * Remove a file from the registry.  
    /**
import java.lang.foreign.SymbolLookup;
 * <p>Methods: create/destroy TieredObjectStore, batch register files, remove file,
/**
    /**
     * @param localStorePtr  Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer, or 0 for default LocalFileSystem
import java.lang.invoke.MethodHandle;  
        );  
    }
 * FFM bridge for tiered storage Rust functions.  
    /**
    /**
    private TieredStorageBridge() {}
    /** Destroy a TieredObjectStore and its internal registry. */
    /**  
import java.lang.foreign.ValueLayout;
        }  
    private static final MethodHandle REGISTER_FILES;
            NativeLibraryLoader.checkResult(
                ValueLayout.JAVA_LONG,   // local_store_box_ptr (0 = default LocalFileSystem)  
     * Get a Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer from a TieredObjectStore Arc pointer.  
package org.opensearch.parquet.store;
     */
            lib.find("ts_create_tiered_object_store").orElseThrow(),  
            throw new RuntimeException("Failed to get object store box ptr", t);
                ValueLayout.JAVA_INT
     * Drops the Box and decrements the Arc strong count.
 * compatible open source license.
     * location: 0=Local, 1=Remote — applied to all files in the batch.
     */
        );
    static {  
     * @param tieredStorePtr the Arc&lt;TieredObjectStore&gt; pointer from createTieredObjectStore
    }  
     * @param file     file identifier (absolute path for DataFusion lookups)
    private static final MethodHandle REMOVE_FILE;
            MemorySegment seg = arena.allocateFrom(entries);
        if (boxPtr <= 0) return;  
