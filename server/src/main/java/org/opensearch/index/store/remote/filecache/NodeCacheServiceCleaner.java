import org.opensearch.core.index.Index;
                ioe
}
            final Path localStorePath;
 * compatible open source license.
                try {
            if (Files.exists(indexCachePath)) {
 * registered {@link BlockCache} instances (e.g. Foyer byte-range cache).
                for (Path subPath : ds) {
                if (shardPath != null) {
            logger.error(
            }
    /**
            }
            // Defensively evict all block cache entries for this index.
     */
 */
    }
    /**
     * all byte-range keys for every file that belonged to this shard.
/**
    private void cleanupShardCaches(ShardPath shardPath, boolean isWarmIndex, boolean isRemoteSnapshot) {
            }
            // if a shard was absent or deletion was partial.
import static org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION;
                    logger.error(() -> new ParameterizedMessage("Failed to delete indices path in cache for index {}", index), e);
    @Override
                ),
        final NodeCacheService ncs = nodeCacheServiceSupplier.get();
            final String prefix = shardPath.getDataPath().toString();
     * from the FileCache and all registered block caches, then deletes the shard's
                logger.error("failed to clean up shard cache directory", e);
     * <p>FileCache entries are removed by iterating the shard's local store path.
        }
        } catch (IOException ioe) {
            final NodeCacheService ncs = nodeCacheServiceSupplier.get();
    }
            cleanupShardCaches(shardPath, false, true);
        }
                    deleteShardFileCacheDirectory(shardPath);
            for (BlockCache cache : ncs.blockCaches()) {
     *
                    ncs.fileCache().remove(subPath.toRealPath());
        // ── BlockCaches (byte-range cache, e.g. Foyer) ───────────────────────
                    logger.error(() -> new ParameterizedMessage("Failed to delete cache path for index {}", index), e);
        }
import java.nio.file.DirectoryStream;
     */
 */
public class NodeCacheServiceCleaner implements IndexStoreListener {
        if (isWarmIndex && !ncs.blockCaches().isEmpty()) {
                }
            }
                    "Error removing FileCache entries during {} shard deletion {}",
        if (indexSettings.isRemoteSnapshot()) {
                }
                final String indexPrefix = indicesPathInCache.toString();
        // ── FileCache (Lucene LRU block-file cache) ───────────────────────────
                    cleanupShardCaches(shardPath, true, false);
            if (isWarmIndex) {
    }
                cache.evictPrefix(prefix);
                }
     */
            if (Files.exists(path)) {
        }
import java.util.function.Supplier;
    }
     * @param nodeCacheServiceSupplier lazy supplier — evaluated on first cleanup call,
     *                             after {@code NodeCacheService} is fully initialized.
import java.nio.file.Files;
     * {@link #beforeShardPathDeleted}.
    private static final Logger logger = LogManager.getLogger(NodeCacheServiceCleaner.class);
import org.opensearch.env.NodeEnvironment;
 * this file be licensed under the Apache-2.0 license or a
    private final Supplier<NodeCacheService> nodeCacheServiceSupplier;
                }
import org.opensearch.plugins.BlockCache;
            } else if (isRemoteSnapshot) {
import org.apache.logging.log4j.LogManager;
    }
    public void beforeShardPathDeleted(ShardId shardId, IndexSettings indexSettings, NodeEnvironment nodeEnvironment) {
            }
                    IOUtils.rm(indicesPathInCache);
            String operationType = isWarmIndex ? "warm index" : "remote snapshot";
        final Path path = shardPath.getDataPath();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.IndexSettings;
            final Path indexCachePath = nodeEnvironment.fileCacheNodePath().fileCachePath.resolve(index.getUUID());
     * Before the index path is deleted, removes the index-level cache directory from
                localStorePath = shardPath.getDataPath().resolve(INDICES_FOLDER_IDENTIFIER);
     * Removes all cache entries for the given shard from all node-level caches.
    @Override
                try {
 * deleted. Handles both the {@link FileCache} (Lucene LRU block-file cache) and any
                () -> new ParameterizedMessage(
        assert ncs != null : "NodeCacheService must be initialized before cache cleanup";
            );
     *                             Pass {@code () -> this.nodeCacheService} from {@code Node}.
    /**
                for (BlockCache cache : ncs.blockCaches()) {
    /**
            }
        try {
            // beforeShardPathDeleted evicts per-shard, but this catches any stragglers
     */
            if (Files.exists(indicesPathInCache)) {
import static org.opensearch.index.store.remote.utils.FileTypeUtils.INDICES_FOLDER_IDENTIFIER;
            deleteShardFileCacheDirectory(shardPath);
    public NodeCacheServiceCleaner(Supplier<NodeCacheService> nodeCacheServiceSupplier) {
 * @opensearch.internal
 *
     * BlockCache entries are evicted by prefix (the shard's data path), which removes
import org.opensearch.index.store.IndexStoreListener;
                }
        } catch (IOException e) {
        try {
     * disk. At this point all per-shard caches have already been cleaned up in
                final ShardPath shardPath = ShardPath.loadShardPath(logger, nodeEnvironment, shardId, indexSettings.customDataPath());
     * cache directory from disk.
                } catch (IOException e) {
                } catch (IOException e) {
            } catch (IOException e) {
        this.nodeCacheServiceSupplier = nodeCacheServiceSupplier;
 * waiting for natural LRU eviction pressure.
import org.opensearch.common.util.io.IOUtils;
    private void deleteShardFileCacheDirectory(ShardPath shardPath) {
import org.apache.logging.log4j.message.ParameterizedMessage;
/*
import org.opensearch.index.shard.ShardPath;
        }
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(localStorePath)) {
                IOUtils.rm(path);
 * The OpenSearch Contributors require contributions made to
 *
                    operationType,
 *
import org.opensearch.core.index.shard.ShardId;
                    IOUtils.rm(indexCachePath);
                    shardPath.getShardId()
            final Path indicesPathInCache = nodeEnvironment.fileCacheNodePath().indicesPath.resolve(index.getUUID());
package org.opensearch.index.store.remote.filecache;
            logger.error(() -> new ParameterizedMessage("Failed to delete cache path for shard {}", shardPath.getShardId()), e);
            try {
            final ShardPath shardPath = ShardPath.loadFileCachePath(nodeEnvironment, shardId);
                return;
                localStorePath = shardPath.getDataPath().resolve(LOCAL_STORE_LOCATION);
    public void beforeIndexPathDeleted(Index index, IndexSettings indexSettings, NodeEnvironment nodeEnvironment) {
 * IndexStoreListener that cleans up all node-level caches when a shard or index is
                    cache.evictPrefix(indexPrefix);
            if (ncs != null && !ncs.blockCaches().isEmpty()) {
import java.nio.file.Path;
 * <p>Cleanup is deterministic — entries are removed at deletion time rather than
            }
            }
            } else {
     * Before the shard path is deleted, removes all cache entries for that shard
        if (indexSettings.isRemoteSnapshot()) {
        } else if (indexSettings.isWarmIndex()) {
        } else if (indexSettings.isWarmIndex()) {
import org.apache.logging.log4j.Logger;
import java.io.IOException;
