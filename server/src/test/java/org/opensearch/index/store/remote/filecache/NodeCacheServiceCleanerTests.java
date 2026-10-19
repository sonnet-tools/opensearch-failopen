    @After
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
    }
        orchestrator.addBlockCache(new BlockCache() {
import org.opensearch.index.shard.ShardStateMetadata;
            public IndexInput getIndexInput() {
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
    }
        final Path indexCachePath = env.fileCacheNodePath().fileCachePath.resolve(SHARD_0.getIndex().getUUID());
     * When multiple block caches are registered, all of them receive evict_prefix
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
            @Override
    public void testShardRemovedForWarmIndex() throws IOException {
            public boolean clear() {
            public BlockCacheStats stats() {
            public void evictPrefix(String prefix) {
        WARM_SETTINGS
     */
import java.io.IOException;
     */
import org.opensearch.common.settings.Settings;
        final Path localStorePath = shardPath.getDataPath().resolve(INDICES_FOLDER_IDENTIFIER);
import org.junit.After;
        final Path indexFilePath1 = ShardPath.loadShardPath(logger, env, WARM_SHARD_1, "").getDataPath();
        orchestrator = new NodeCacheService(fileCache);
     */
        final Path localStorePath = shardPath.getDataPath().resolve(LOCAL_STORE_LOCATION);
        cleaner.beforeIndexPathDeleted(SHARD_0.getIndex(), INDEX_SETTINGS, env);
        // Assert that index path should exists and fileCache also have files for that index shard.
                return true;
            public void close() {}
                return null;
        // clean warm_shard_0 files
        // Restore permissions for cleanup
            }
        assertEquals("evict_prefix must be called exactly once", 1, evictedPrefixes.size());
        assertFalse(Files.exists(indexFilePath1));
 */
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
     */
        IndexMetadata.builder("warm-index-0").settings(WARM_SETTINGS).build(),
                return 1024;
        env.close();
import org.apache.lucene.store.IndexInput;
            public boolean clear() {
        assertFalse(Files.exists(files.get(SHARD_0)));
        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.core.index.shard.ShardId;
        assertFalse(Files.exists(files.get(WARM_SHARD_0)));
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));
            public void close() {
 * Tests for {@link NodeCacheServiceCleaner}: verifies that both the
    private static final Logger logger = LogManager.getLogger(FileCache.class);
import org.opensearch.index.shard.ShardPath;
        assertNull(fileCache.get(files.get(WARM_SHARD_0)));
        assertNull(fileCache.get(files.get(WARM_SHARD_0)));
    public void testShardRemoved() {
import java.nio.file.attribute.PosixFilePermissions;
            @Override
                return true;
    );
        // Make the indices directory non-readable to cause IOException during directory stream
    }
                evicted1.add(prefix);
            @Override
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
    public void testBlockCacheEvictedOnWarmShardDeletion() throws IOException {
            paths
        MatcherAssert.assertThat(fileCache.size(), equalTo(2L));
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
            }
            @Override
    }
        // Verify fileCache still contains all files as remove operation won't get executed.
            }
    // ── FileCache eviction (original tests, adapted) ────────────────────────
                return true;
            public void close() {}
                blockCacheEvictions.add(prefix);
            @Override
        Path shardPath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);
        orchestrator.addBlockCache(mockCache);
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);
        assertFalse(Files.exists(files.get(WARM_SHARD_1)));
 * compatible open source license.
 * are deterministically evicted when a shard or index is deleted.
            @Override
    private final Map<ShardId, Path> files = new HashMap<>();
    private static final IndexSettings WARM_INDEX_SETTINGS_1 = new IndexSettings(
import org.junit.Before;
    }
        assertTrue(Files.exists(indexCachePath));
        .build();
        assertNull(fileCache.get(files.get(WARM_SHARD_0)));
        Path path2 = randomFrom(paths1);
    /**
        ShardStateMetadata.FORMAT.writeAndCleanup(
import org.opensearch.index.IndexSettings;
    private static final Settings SETTINGS = Settings.builder()
    /**
        // Try to not clean the index path without calling beforeShardPathDeleted method
            new ShardStateMetadata(true, indexUUID, AllocationId.newInitializing(), ShardStateMetadata.IndexDataLocation.LOCAL),
        assertFalse(Files.exists(indexCachePath));
            public void close() {}
        Path[] paths0 = env.availableShardPaths(WARM_SHARD_0);
        // SHARD_0 uses INDEX_SETTINGS (remote_snapshot, not warm index)
        // Before: 4 files in FileCache, 0 block cache evictions
        assertTrue(Files.exists(files.get(WARM_SHARD_1)));
    private static final IndexSettings INDEX_SETTINGS = new IndexSettings(
public class NodeCacheServiceCleanerTests extends OpenSearchTestCase {
        .put("index.store.type", "remote_snapshot")
        });
        cleaner.beforeShardPathDeleted(SHARD_0, INDEX_SETTINGS, env);
        fileCache.put(file, new CachedIndexInput() {
        final Path file = Files.createFile(localStorePath.resolve("file"));
        // Delete the shard path to simulate IOException when trying to load shard path
    private static final IndexSettings WARM_INDEX_SETTINGS_0 = new IndexSettings(
            public boolean isClosed() {
    /**
        // Should not throw and should clean FileCache normally
        SETTINGS
    }
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
    }
    private static final ShardId SHARD_0 = new ShardId("index", "uuid-0", 0);
        assertFalse(Files.exists(cachePath));
                evicted2.add(prefix);
    @Before
        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
/*
    );
    }
        assertNull(fileCache.get(files.get(SHARD_0)));
    public void testAllBlockCachesEvictedOnWarmShardDeletion() throws IOException {
import java.util.HashSet;
            public BlockCacheStats stats() {
        // assert fileCache has 3 files.
        // now clean the index path.
import static org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION;
        // Initially 4 files exist in fileCache
                evictedPrefixes.add(prefix);
            public boolean clear() {
import java.nio.file.Path;
import org.opensearch.plugins.BlockCache;
            @Override
            public void evictPrefix(String prefix) {
            public boolean clear() {
        assertEquals(warmShardDataPath.toString(), evicted1.get(0));
            public void close() {}
import org.opensearch.cluster.metadata.IndexMetadata;
package org.opensearch.index.store.remote.filecache;
            @Override
            public BlockCacheStats stats() {
        fileCache.put(file, new CachedIndexInput() {
 * The OpenSearch Contributors require contributions made to
    // ── BlockCache eviction tests ─────────────────────────────────────────────
        final Path file = Files.createFile(localStorePath.resolve("file"));
     * If no block caches are registered (hot nodes), no evict_prefix calls are made
 */
        assertTrue(Files.exists(cachePath));
        final Path warmShardDataPath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
        cleaner.beforeIndexPathDeleted(WARM_INDEX_SETTINGS_0.getIndex(), WARM_INDEX_SETTINGS_0, env);
        .put(IS_WARM_INDEX_SETTING.getKey(), true)
        assertTrue("evict_prefix must NOT be called for remote snapshot shards", evictedPrefixes.isEmpty());
        cleaner.beforeShardPathDeleted(SHARD_1, INDEX_SETTINGS, env);
        // Initially 4 files exits in fileCache.
        Path shardFilePath = shardPath.resolve(INDICES_FOLDER_IDENTIFIER).resolve("file");
            }
import org.opensearch.env.NodeEnvironment;
                return false;
        // After: FileCache evicted the shard's file, BlockCache evict_prefix called
        return file;
import org.opensearch.plugins.BlockCacheStats;
     * beforeShardPathDeleted call — both caches are cleaned atomically.
        // Initially 4 files exits in fileCache.
        // Assert that index path deleted and fileCache also doesn't have files for that index shard.
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
            @Override
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertEquals(warmShardDataPath.toString(), evicted2.get(0));
        BlockCache mockCache = new BlockCache() {
                return false;
    }
        // orchestrator has no block caches by default
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);
            }
        Files.setPosixFilePermissions(indicesPath, new HashSet<>());
            }
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));
        };
        Files.setPosixFilePermissions(indicesPath, PosixFilePermissions.fromString("rwxrwxrwx"));
            @Override
            }
    }
import org.hamcrest.MatcherAssert;
                return 1024;
            public boolean isClosed() {
            public BlockCacheStats stats() {
        MatcherAssert.assertThat(fileCache.size(), equalTo(2L));
        orchestrator.addBlockCache(new BlockCache() {
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
    private final FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(1024 * 1024, 1);
        // clean shard path files first.
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);
        writeShardStateMetadata("warm-uuid-1", path2);
        writeShardStateMetadata("warm-uuid-0", path1);
            @Override
        assertNull(fileCache.get(files.get(WARM_SHARD_1)));
    private NodeEnvironment env;
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
            }
            @Override
            public void close() {}
        // Try to clean up the deleted shard path
        cleaner.beforeShardPathDeleted(SHARD_0, INDEX_SETTINGS, env);
            @Override
    }
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));
        final List<String> evicted1 = new ArrayList<>();
    public void setUpFileCache() throws IOException {
    /**
        final Path warmShardDataPath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
        files.put(SHARD_1, addFile(fileCache, env, SHARD_1));
            @Override
import org.opensearch.cluster.routing.AllocationId;
        assertTrue(Files.exists(indexFilePath));
        assertTrue(Files.exists(shardFilePath));
        final Path indexFilePath0 = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
            @Override
                return true;
    public void testBlockCacheNotEvictedForRemoteSnapshotShard() {
                return null;
            @Override
            public void evictPrefix(String prefix) {
        final List<String> evictedPrefixes = new ArrayList<>();
            public long length() {
        Files.delete(shardFilePath);
            @Override
        Path[] paths1 = env.availableShardPaths(WARM_SHARD_1);
        });
    private static Path addFileForWarmIndex(FileCache fileCache, NodeEnvironment env, ShardId shardId) throws IOException {
        assertTrue(blockCacheEvictions.isEmpty());
            @Override
        cleaner.beforeShardPathDeleted(WARM_SHARD_1, WARM_INDEX_SETTINGS_1, env);
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);
        // add files in filecache for warm index shards.
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
            @Override
            @Override
    private static void writeShardStateMetadata(String indexUUID, Path... paths) throws WriteStateException {
            @Override
        assertTrue(orchestrator.blockCaches().isEmpty());
import static org.hamcrest.Matchers.equalTo;
            }
        return file;
            public void evictPrefix(String prefix) {
        Path path1 = randomFrom(paths0);
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
            public boolean clear() {
                return true;
        final Path indexFilePath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
import org.apache.logging.log4j.Logger;
     * Block cache eviction is NOT called for remote snapshot shards (isWarmIndex=false).
    }
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));
        Files.createDirectories(localStorePath);
            }
        Files.createDirectories(localStorePath);
        assertEquals("evict_prefix must use the shard data path", warmShardDataPath.toString(), evictedPrefixes.get(0));
    private static final ShardId WARM_SHARD_1 = new ShardId("warm-index-1", "warm-uuid-1", 1);
    }
        assertFalse(Files.exists(indexFilePath0));
import static org.opensearch.index.store.remote.utils.FileTypeUtils.INDICES_FOLDER_IDENTIFIER;
        files.put(SHARD_0, addFile(fileCache, env, SHARD_0));
import java.util.ArrayList;
            @Override
     * and FileCache cleanup proceeds normally.
    private static Path addFile(FileCache fileCache, NodeEnvironment env, ShardId shardId) throws IOException {
        );
        // Shard path is still deleted
        logger.info("warm index local store location [{}]", localStorePath);
        // Verify fileCache still contains all files as operation failed
     */
     * Block cache eviction and FileCache eviction happen together in the same
            }
    private NodeCacheServiceCleaner cleaner;
            }
            @Override
import org.opensearch.Version;
            @Override
 * {@link FileCache} (Lucene LRU) and any registered {@link BlockCache} instances
        orchestrator.addBlockCache(new BlockCache() {
            }
        final Path indexFilePath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
        };
        assertTrue(Files.exists(files.get(SHARD_1)));
    );
}
        Path indicesPath = shardPath.resolve(INDICES_FOLDER_IDENTIFIER);
            }
    public void testIndexRemoved() {
import org.apache.logging.log4j.LogManager;
        cleaner.beforeIndexPathDeleted(WARM_INDEX_SETTINGS_0.getIndex(), WARM_INDEX_SETTINGS_0, env);
        WARM_SETTINGS
            }
                evictedPrefixes.add(prefix);
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
        cleaner.beforeShardPathDeleted(SHARD_0, INDEX_SETTINGS, env);
import java.nio.file.Files;
        // assert filecache contains 4 files
        });
        assertEquals(1, blockCacheEvictions.size());
            }
            }
    public void testShardRemovedForWarmIndexWithIOExceptionOnDirectoryStream() throws IOException {
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
            }
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
            }
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));
            @Override
    }
            public IndexInput getIndexInput() {
            @Override
        env = newNodeEnvironment(SETTINGS);
            }
            public void evictPrefix(String prefix) {
        assertEquals("first cache must receive evict_prefix", 1, evicted1.size());
        // cleanup shard_0 files.
        Path shardPath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
        assertTrue(Files.exists(indexFilePath));
        assertTrue(Files.exists(indexFilePath0));
        files.put(WARM_SHARD_0, addFileForWarmIndex(fileCache, env, WARM_SHARD_0));
        final List<String> blockCacheEvictions = new ArrayList<>();
    private static final ShardId SHARD_1 = new ShardId("index", "uuid-1", 0);
    public void testIndexRemovedForWarmIndexWhenShardPathDeletedFirst() throws IOException {
    private static final Settings WARM_SETTINGS = Settings.builder()
    public void testBothFileCacheAndBlockCacheEvictedTogether() throws IOException {
     * caches with the shard's data path as the prefix.
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import java.util.HashMap;
        });
        IndexMetadata.builder("warm-index-1").settings(WARM_SETTINGS).build(),
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            @Override
    /**
    private static final ShardId WARM_SHARD_0 = new ShardId("warm-index-0", "warm-uuid-0", 0);
import org.opensearch.gateway.WriteStateException;
        files.put(WARM_SHARD_1, addFileForWarmIndex(fileCache, env, WARM_SHARD_1));
     * when a warm shard is deleted.
    public void testFileCacheNotClearedAndWithFileAlreadyDeleted() throws IOException {
    public void tearDownFileCache() {
import java.util.List;
    }
            }
            public long length() {
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
import org.opensearch.test.OpenSearchTestCase;
        orchestrator.addBlockCache(mockCache);
        BlockCache mockCache = new BlockCache() {
    public void testIndexNotRemovedForWarmIndexWhenShardPathNotDeletedFirst() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    }
        final Path cachePath = ShardPath.loadFileCachePath(env, SHARD_0).getDataPath();
        // Initially 4 files exist in fileCache
            public void close() {
        .build();
/**
        final List<String> evictedPrefixes = new ArrayList<>();
        assertFalse(Files.exists(shardPath));
    private NodeCacheService orchestrator;
        assertEquals("second cache must receive evict_prefix", 1, evicted2.size());
            public BlockCacheStats stats() {
        final List<String> evicted2 = new ArrayList<>();
        final ShardPath shardPath = ShardPath.loadFileCachePath(env, shardId);
            @Override
        // clean warm_shard_1 files as well.
        assertFalse(Files.exists(indexFilePath));
    public void testNoCrashWhenNoBlockCachesRegistered() throws IOException {
        });
        // Try to clean up with non-readable directory
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
 *
            }
        assertTrue(Files.exists(indexFilePath));
        // assert filecache contains 4 files
        cleaner = new NodeCacheServiceCleaner(() -> orchestrator);
    }
            }
     * When a warm shard is deleted, evict_prefix is called on all registered block
        final ShardPath shardPath = ShardPath.loadShardPath(logger, env, shardId, "");
        IndexMetadata.builder("index").settings(SETTINGS).build(),
