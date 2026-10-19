 */  
import java.util.Map;  
                    } catch (Exception e) {
package org.opensearch.parquet.store;
     * handle (all operations are no-ops).
                        long boxPtr = TieredStorageBridge.getObjectStoreBoxPtr(storeHandle.getPointer());
        // The box holds an Arc clone of the TieredObjectStore, keeping it alive independently.
 *   <li>{@code seed} → {@code ts_register_files} (batch, per-file location)</li>
 * {@code ts_get_file_location} FFM call for LOCAL/REMOTE routing.
            );  
import java.io.IOException;
        if (nativeStoreForReader == null) {  
        }
     *
 *   <li>{@code onUploaded} → {@code ts_register_files} (single file, REMOTE)</li>  
/**
     * @param repo           the native remote store, or {@code NativeStoreRepository.EMPTY}
            TieredStorageBridge.registerFile(  
 * Per-shard native file registry for parquet files.  
 *
 *
            NativeStoreHandle cacheHandle = (cacheRegistry != null)  
        if (storeHandle.isLive() == false) {
        if (isWarm) {
     *                       or {@code null} if no block cache support is available
import org.opensearch.plugins.BlockCacheRegistry;
     * <p>On hot nodes (or when the native store is unavailable), creates an empty  
                "[{}] ParquetDataFormatStoreHandler created: cache={}",  
            // Resolve preferred cache by name; EMPTY if unavailable (hot nodes or no matching cache).
                        if (boxPtr > 0) {
    private volatile NativeStoreHandle nativeStoreForReader;  
import org.opensearch.core.index.shard.ShardId;  
            }  
        }  
        logger.trace("onUploaded: file=[{}], remotePath=[{}], size={}", file, remotePath, size);
    @Override
public class ParquetDataFormatStoreHandler implements DataFormatStoreHandler {  
     * {@link BlockCacheConstants#FOYER} from {@code cacheRegistry} and wires it into the  
                : NativeStoreHandle.EMPTY;
     * @param isWarm         true if the shard is on a warm node
                if (nativeStoreForReader == null) {
    public ParquetDataFormatStoreHandler(ShardId shardId, boolean isWarm, NativeStoreRepository repo, BlockCacheRegistry cacheRegistry) {  
     *
        // Lazily create the boxed pointer once — same lifetime as the handler (shard lifetime).
        TieredStorageBridge.removeFile(storeHandle.getPointer(), file);
    }  
            long remotePtr = (repo != null && repo.isLive()) ? repo.getPointer() : 0L;
                entry.getKey(),
            long cachePtr = cacheHandle.isLive() ? cacheHandle.getPointer() : 0L;  
                        }
        return nativeStoreForReader != null ? nativeStoreForReader : NativeStoreHandle.EMPTY;
     * Creates a per-shard native file registry.  
    /** Cached native object store handle for DataFusion readers — created lazily, closed with the handler. */
                shardId,
        if (storeHandle.isLive() == false) {
        for (Map.Entry<String, FileEntry> entry : files.entrySet()) {
        if (storeHandle.isLive() == false) {
                entry.getValue().location(),
    private static final Logger logger = LogManager.getLogger(ParquetDataFormatStoreHandler.class);
            return;
        if (nativeStoreForReader != null) {
 * is seeded from remote metadata at shard open. No local files, no eviction.  
            }
 *
    @Override
        logger.trace("seed: {} files registered", files.size());
            return;
 * <ul>
        // Close box handle first (decrements Arc refcount), then the store handle (frees TieredObjectStore).
            this.storeHandle = new NativeStoreHandle(ptr, TieredStorageBridge::destroyTieredObjectStore);  
                storeHandle.getPointer(),
     * @param cacheRegistry  registry for resolving the preferred block cache by name,  
            // owned by NodeCacheService and must not be freed here.
 * {@link TieredStorageBridge} which invokes the Rust {@code ts_*} functions:  
                );
        }
 *   <li>{@code onRemoved} → {@code ts_remove_file}</li>
        logger.trace("onRemoved: file=[{}]", file);
                entry.getValue().size()
    public void onUploaded(String file, String remotePath, long size) {  
    public void close() throws IOException {  
            );  
                ? cacheRegistry.get(BlockCacheConstants.FOYER).map(BlockCache::nativeCacheHandle).orElse(NativeStoreHandle.EMPTY)
            if (remotePtr == 0L) {
 * compatible open source license.
                    "[" + shardId + "] remote object store is not available for this warm shard. Cannot serve read requests."  
    public void onRemoved(String file) {  
import org.opensearch.plugins.NativeStoreHandle;
    }  
}
import org.opensearch.index.engine.dataformat.DataFormatStoreHandler;
        }  
     * <p>On warm nodes, creates a native store via FFM. The handler resolves
            synchronized (this) {
 *   <li>{@code close} → {@code ts_destroy_tiered_object_store}</li>
import org.apache.logging.log4j.LogManager;
 * <p>Owns a Rust {@code TieredObjectStore} via FFM. All calls delegate to
import org.opensearch.repositories.NativeStoreRepository;  
            logger.debug(
        TieredStorageBridge.registerFile(storeHandle.getPointer(), file, remotePath, REMOTE, size);
    }
            nativeStoreForReader.close();  
     */
    }  
    private final NativeStoreHandle storeHandle;
                    }
import org.apache.logging.log4j.Logger;
    }  
    }  
        if (storeHandle.isLive() == false) {
                            nativeStoreForReader = new NativeStoreHandle(boxPtr, TieredStorageBridge::destroyObjectStoreBoxPtr);  
                    try {  
 * SPDX-License-Identifier: Apache-2.0
/*  
                        logger.error("getFormatStoreHandle: failed to get object store box ptr", e);  
            this.storeHandle = NativeStoreHandle.EMPTY;
            long ptr = TieredStorageBridge.createTieredObjectStore(0L, remotePtr, cachePtr);
            return NativeStoreHandle.EMPTY;
 * <p><b>TODO (writable warm):</b> add getFileLocation, acquireRead, releaseRead
 * when LOCAL parquet files exist and eviction is enabled. Wire  
                }
     *
 */
    @Override
                throw new IllegalStateException(
        }
     * store if available.
    @Override  
                entry.getValue().path(),  
 *
 * </ul>  
    public void seed(Map<String, FileEntry> files) {
    @Override
        } else {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.BlockCacheConstants;  
    /**
        }  
            return;  
 * The OpenSearch Contributors require contributions made to  
    public NativeStoreHandle getFormatStoreHandle() {  
import org.opensearch.plugins.BlockCache;
        }  
     * @param shardId        the shard id (for logging)  
 * <p><b>Read-only warm (current):</b> all parquet files are REMOTE. The registry
        storeHandle.close();
        }
                cacheHandle.isLive() ? BlockCacheConstants.FOYER : "none"
