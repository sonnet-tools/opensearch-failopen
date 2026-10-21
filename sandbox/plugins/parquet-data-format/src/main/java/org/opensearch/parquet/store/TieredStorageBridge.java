    public static void removeFile(long storePtr, String path) {
     */
     * @param tieredStorePtr the Arc&lt;TieredObjectStore&gt; pointer from createTieredObjectStore
 */
     * Register a single file in the registry with its own location and size.
     * This is the format that DataFusion's df_create_reader expects.
            .orElse(null);
     * Register files in the registry. Batch format: triplets of path\nremotePath\nsize\n...
    static {
                ValueLayout.JAVA_LONG,
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
            throw new RuntimeException("Failed to destroy object store box ptr", t);
    private static final MethodHandle GET_OBJECT_STORE_BOX_PTR;
import java.lang.foreign.MemorySegment;
            return NativeLibraryLoader.checkResult((long) GET_OBJECT_STORE_BOX_PTR.invokeExact(tieredStorePtr));
            lib.find("ts_get_object_store_box_ptr").orElseThrow(),
        registerFiles(storePtr, java.util.Map.of(file, path != null ? path : ""), location, size);
        String entries = sb.toString();
        REGISTER_FILES = linker.downcallHandle(
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)
        // Optional — graceful if native library is stale and symbol not yet available.
        SymbolLookup lib = NativeLibraryLoader.symbolLookup();
     * The returned pointer shares ownership with the original — free it with destroyObjectStoreBoxPtr.
     * @param remoteStorePtr Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer, or 0 for no remote
 * <p>Methods: create/destroy TieredObjectStore, batch register files, remove file,
                ValueLayout.JAVA_LONG,
 * FFM bridge for tiered storage Rust functions.
    /**
     * @param storePtr native pointer to the TieredObjectStore
import java.lang.foreign.Linker;
    }
            return NativeLibraryLoader.checkResult((long) CREATE.invokeExact(localStorePtr, remoteStorePtr, cacheBoxPtr));
/**
        try {
    private static final MethodHandle CREATE;
        } catch (Throwable t) {
        try {
        DESTROY = linker.downcallHandle(
    }
        );
    /**
        }
        } catch (Throwable t) {
        }
            lib.find("ts_create_tiered_object_store").orElseThrow(),
            NativeLibraryLoader.checkResult((long) DESTROY_OBJECT_STORE_BOX_PTR.invokeExact(boxPtr));
    }
    public static void destroyObjectStoreBoxPtr(long boxPtr) {
            FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG, ValueLayout.ADDRESS, ValueLayout.JAVA_LONG)
        }
        } catch (Throwable t) {
        // i64 ts_create_tiered_object_store(i64 local, i64 remote, i64 cache)
import java.lang.foreign.SymbolLookup;
        );
package org.opensearch.parquet.store;
public final class TieredStorageBridge {
            FunctionDescriptor.of(
 * SPDX-License-Identifier: Apache-2.0
     * @return Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer for DataFusion
     */
    /**
 *
 * This avoids per-file FFM overhead when seeding hundreds of files at shard open.
                ValueLayout.JAVA_LONG,
     * @param size       file size in bytes (applied to all files in batch)
     * @param fileToPath map of file path to remote path (remote path can be empty for Local)
 */
    /**
     * Drops the Box and decrements the Arc strong count.
        try {
     * @param path     blob path (remote path for REMOTE, local path for LOCAL)
    public static long createTieredObjectStore(long localStorePtr, long remoteStorePtr, long cacheBoxPtr) {
import java.lang.foreign.FunctionDescriptor;
        } catch (Throwable t) {
        REMOVE_FILE = linker.downcallHandle(
     *
            FunctionDescriptor.of(
            sb.append(e.getValue() != null ? e.getValue() : "").append('\n');
     */
            throw new RuntimeException("Failed to register " + fileToPath.size() + " files", t);
 * <p>The {@code registerFiles} method uses a newline-delimited batch format:
     *
 *
    public static void registerFile(long storePtr, String file, String path, int location, long size) {
            lib.find("ts_remove_file").orElseThrow(),
    /** Destroy a TieredObjectStore and its internal registry. */
            throw new RuntimeException("Failed to remove file: " + path, t);
        if (fileToPath.isEmpty()) return;
     * Remove a file from the registry.
        try (Arena arena = Arena.ofConfined()) {
     * Get a Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer from a TieredObjectStore Arc pointer.
                ValueLayout.JAVA_LONG,   // local_store_box_ptr (0 = default LocalFileSystem)
        GET_OBJECT_STORE_BOX_PTR = linker.downcallHandle(
 * compatible open source license.
     *
    private static final MethodHandle DESTROY_OBJECT_STORE_BOX_PTR;
            );
 * and block-cache pointer helpers.
            NativeLibraryLoader.checkResult((long) REMOVE_FILE.invokeExact(storePtr, seg, (long) path.length()));
                ValueLayout.JAVA_INT
            NativeLibraryLoader.checkResult(
            throw new RuntimeException("Failed to get object store box ptr", t);
    }
     */
        if (DESTROY_OBJECT_STORE_BOX_PTR == null) return;
        StringBuilder sb = new StringBuilder();
    public static long getObjectStoreBoxPtr(long tieredStorePtr) {
        }
     * @param location   0=Local, 1=Remote
        try (Arena arena = Arena.ofConfined()) {
     * Free a Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer returned by getObjectStoreBoxPtr.
     * @param localStorePtr  Box&lt;Arc&lt;dyn ObjectStore&gt;&gt; pointer, or 0 for default LocalFileSystem
    }
                ValueLayout.JAVA_LONG    // cache_box_ptr (0 = no cache)
            MemorySegment seg = arena.allocateFrom(path);
            )
     */
        }
    private static final MethodHandle REGISTER_FILES;
        if (boxPtr <= 0) return;
import java.lang.foreign.ValueLayout;
     * @param location 0=Local, 1=Remote
            NativeLibraryLoader.checkResult((long) DESTROY.invokeExact(ptr));
            .map(sym -> linker.downcallHandle(sym, FunctionDescriptor.of(ValueLayout.JAVA_LONG, ValueLayout.JAVA_LONG)))
import org.opensearch.nativebridge.spi.NativeLibraryLoader;
    /**
            sb.append(e.getKey()).append('\n');
    public static void destroyTieredObjectStore(long ptr) {
            MemorySegment seg = arena.allocateFrom(entries);
import java.lang.invoke.MethodHandle;
            throw new RuntimeException("Failed to create TieredObjectStore", t);
 * The OpenSearch Contributors require contributions made to
        sb.setLength(sb.length() - 1);
        );
    private static final MethodHandle DESTROY;
     * location: 0=Local, 1=Remote — applied to all files in the batch.
     * @param file     file identifier (absolute path for DataFusion lookups)
            )
    private static final MethodHandle REMOVE_FILE;
     * @return native Arc&lt;TieredObjectStore&gt; pointer
        } catch (Throwable t) {
     * No-op if the native symbol is not available (stale library).
                (long) REGISTER_FILES.invokeExact(storePtr, seg, (long) entries.length(), fileToPath.size(), location)
        );
     * Create a TieredObjectStore with optional local store, remote store, and block cache.
     * @param storePtr   native pointer to the TieredObjectStore
                ValueLayout.JAVA_INT,
                ValueLayout.JAVA_LONG,   // return: Arc<TieredObjectStore> ptr
            lib.find("ts_register_files").orElseThrow(),
     *
                ValueLayout.JAVA_LONG,   // remote_store_box_ptr (0 = no remote)
    }
        } catch (Throwable t) {
}
        for (java.util.Map.Entry<String, String> e : fileToPath.entrySet()) {
 * {@code path\nremotePath\nsize\npath\nremotePath\nsize\n...}. Empty remotePath for LOCAL files.
        DESTROY_OBJECT_STORE_BOX_PTR = lib.find("ts_destroy_object_store_box_ptr")
        Linker linker = Linker.nativeLinker();
            lib.find("ts_destroy_tiered_object_store").orElseThrow(),
            throw new RuntimeException("Failed to destroy TieredObjectStore", t);
        );
                ValueLayout.ADDRESS,
     * @param size     file size in bytes
            sb.append(size).append('\n');
 *
    }
        }
/*
     * @param cacheBoxPtr    block cache pointer, or 0 for no cache
import java.lang.foreign.Arena;
        }
     */
    public static void registerFiles(long storePtr, java.util.Map<String, String> fileToPath, int location, long size) {
    }
    /**
        try {
    private TieredStorageBridge() {}
 * this file be licensed under the Apache-2.0 license or a
        CREATE = linker.downcallHandle(
