            );
import static org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION;
                final ShardPath shardPath = ShardPath.loadShardPath(logger, nodeEnvironment, shardId, indexSettings.customDataPath());  
    @Override  
 *
    @Override
        } else if (indexSettings.isWarmIndex()) {
                    deleteShardFileCacheDirectory(shardPath);  
                logger.error("failed to clean up shard cache directory", e);  
                IOUtils.rm(path);  
import java.nio.file.Path;
            }
 * IndexStoreListener that cleans up all node-level caches when a shard or index is
                for (Path subPath : ds) {
/**
            } else {
     * <p>FileCache entries are removed by iterating the shard's local store path.
                    logger.error(() -> new ParameterizedMessage("Failed to delete cache path for index {}", index), e);
 */  
import org.opensearch.core.index.Index;
                ioe
        } catch (IOException ioe) {
        final NodeCacheService ncs = nodeCacheServiceSupplier.get();
                    cache.evictPrefix(indexPrefix);
import java.nio.file.DirectoryStream;
        if (isWarmIndex && !ncs.blockCaches().isEmpty()) {  
    /**
     */
                localStorePath = shardPath.getDataPath().resolve(INDICES_FOLDER_IDENTIFIER);
import org.opensearch.common.util.io.IOUtils;
            if (isWarmIndex) {
            logger.error(() -> new ParameterizedMessage("Failed to delete cache path for shard {}", shardPath.getShardId()), e);  
import org.apache.logging.log4j.Logger;
import org.opensearch.env.NodeEnvironment;
        if (indexSettings.isRemoteSnapshot()) {
     *                             after {@code NodeCacheService} is fully initialized.
 */
                final String indexPrefix = indicesPathInCache.toString();
            for (BlockCache cache : ncs.blockCaches()) {
                ),  
     * BlockCache entries are evicted by prefix (the shard's data path), which removes  
                }
                try {
import java.nio.file.Files;  
     */  
     * Removes all cache entries for the given shard from all node-level caches.  
        assert ncs != null : "NodeCacheService must be initialized before cache cleanup";
    public void beforeShardPathDeleted(ShardId shardId, IndexSettings indexSettings, NodeEnvironment nodeEnvironment) {
                () -> new ParameterizedMessage(
    }  
    private static final Logger logger = LogManager.getLogger(NodeCacheServiceCleaner.class);
    }  
            final Path indexCachePath = nodeEnvironment.fileCacheNodePath().fileCachePath.resolve(index.getUUID());  
     * Before the index path is deleted, removes the index-level cache directory from
import org.apache.logging.log4j.message.ParameterizedMessage;  
            // Defensively evict all block cache entries for this index.  
    /**
 * compatible open source license.
            final ShardPath shardPath = ShardPath.loadFileCachePath(nodeEnvironment, shardId);
     */  
     * {@link #beforeShardPathDeleted}.
    private void cleanupShardCaches(ShardPath shardPath, boolean isWarmIndex, boolean isRemoteSnapshot) {  
     *
            } catch (IOException e) {
        // ── BlockCaches (byte-range cache, e.g. Foyer) ───────────────────────
 * The OpenSearch Contributors require contributions made to  
        }
     */
                if (shardPath != null) {
    public void beforeIndexPathDeleted(Index index, IndexSettings indexSettings, NodeEnvironment nodeEnvironment) {
                    cleanupShardCaches(shardPath, true, false);
     *                             Pass {@code () -> this.nodeCacheService} from {@code Node}.
 * this file be licensed under the Apache-2.0 license or a
                cache.evictPrefix(prefix);  
                }  
import static org.opensearch.index.store.remote.utils.FileTypeUtils.INDICES_FOLDER_IDENTIFIER;
                for (BlockCache cache : ncs.blockCaches()) {  
            deleteShardFileCacheDirectory(shardPath);  
            if (Files.exists(indicesPathInCache)) {
                }  
/*  
                }  
import java.io.IOException;
                try {
 *
        this.nodeCacheServiceSupplier = nodeCacheServiceSupplier;
import org.opensearch.index.shard.ShardPath;  
                }
 * waiting for natural LRU eviction pressure.
import org.apache.logging.log4j.LogManager;
    public NodeCacheServiceCleaner(Supplier<NodeCacheService> nodeCacheServiceSupplier) {
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(localStorePath)) {  
        // ── FileCache (Lucene LRU block-file cache) ───────────────────────────
    private final Supplier<NodeCacheService> nodeCacheServiceSupplier;  
                    operationType,
            final String prefix = shardPath.getDataPath().toString();
            // if a shard was absent or deletion was partial.
        }  
                } catch (IOException e) {
            }
    }
            }
            String operationType = isWarmIndex ? "warm index" : "remote snapshot";  
            logger.error(
 * deleted. Handles both the {@link FileCache} (Lucene LRU block-file cache) and any  
                    shardPath.getShardId()
    /**
public class NodeCacheServiceCleaner implements IndexStoreListener {
            if (Files.exists(indexCachePath)) {
            }
                    IOUtils.rm(indicesPathInCache);  
import org.opensearch.core.index.shard.ShardId;  
     * disk. At this point all per-shard caches have already been cleaned up in  
                } catch (IOException e) {
                    logger.error(() -> new ParameterizedMessage("Failed to delete indices path in cache for index {}", index), e);
import org.opensearch.plugins.BlockCache;
                    "Error removing FileCache entries during {} shard deletion {}",  
            }
        if (indexSettings.isRemoteSnapshot()) {  
     * Before the shard path is deleted, removes all cache entries for that shard  
        } catch (IOException e) {
        }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.store.remote.filecache;
            try {
 *
        } else if (indexSettings.isWarmIndex()) {
                return;  
            if (Files.exists(path)) {
 * @opensearch.internal  
     * all byte-range keys for every file that belonged to this shard.
import org.opensearch.index.store.IndexStoreListener;
            final Path indicesPathInCache = nodeEnvironment.fileCacheNodePath().indicesPath.resolve(index.getUUID());  
            cleanupShardCaches(shardPath, false, true);
     * @param nodeCacheServiceSupplier lazy supplier — evaluated on first cleanup call,  
import org.opensearch.index.IndexSettings;
 * <p>Cleanup is deterministic — entries are removed at deletion time rather than  
                    ncs.fileCache().remove(subPath.toRealPath());
}  
        }
            }  
     * cache directory from disk.
    private void deleteShardFileCacheDirectory(ShardPath shardPath) {
    /**
                localStorePath = shardPath.getDataPath().resolve(LOCAL_STORE_LOCATION);
                    IOUtils.rm(indexCachePath);  
    }
            final Path localStorePath;  
 * registered {@link BlockCache} instances (e.g. Foyer byte-range cache).
        }
            } else if (isRemoteSnapshot) {  
        try {
            }
            }
import java.util.function.Supplier;
        final Path path = shardPath.getDataPath();  
            // beforeShardPathDeleted evicts per-shard, but this catches any stragglers
            if (ncs != null && !ncs.blockCaches().isEmpty()) {
    }  
        try {
            final NodeCacheService ncs = nodeCacheServiceSupplier.get();  
     * from the FileCache and all registered block caches, then deletes the shard's
