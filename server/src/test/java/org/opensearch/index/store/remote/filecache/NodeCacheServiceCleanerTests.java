        final List<String> evicted2 = new ArrayList<>();
    public void testShardRemovedForWarmIndexWithIOExceptionOnDirectoryStream() throws IOException {
        assertTrue(Files.exists(files.get(SHARD_1)));
        orchestrator.addBlockCache(new BlockCache() {  
    private NodeEnvironment env;
/*  
                return false;  
        WARM_SETTINGS
        Path shardPath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
     */
        // cleanup shard_0 files.
        assertFalse(Files.exists(indexCachePath));
import org.opensearch.index.shard.ShardStateMetadata;
    public void testAllBlockCachesEvictedOnWarmShardDeletion() throws IOException {
public class NodeCacheServiceCleanerTests extends OpenSearchTestCase {
        assertTrue(Files.exists(indexFilePath));  
            @Override
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
    }
        assertTrue(Files.exists(indexFilePath0));  
        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        files.put(SHARD_0, addFile(fileCache, env, SHARD_0));
        assertEquals(warmShardDataPath.toString(), evicted1.get(0));
        IndexMetadata.builder("warm-index-0").settings(WARM_SETTINGS).build(),  
                return null;
        assertEquals("second cache must receive evict_prefix", 1, evicted2.size());
            }
        assertEquals(1, blockCacheEvictions.size());
        cleaner.beforeIndexPathDeleted(WARM_INDEX_SETTINGS_0.getIndex(), WARM_INDEX_SETTINGS_0, env);  
            @Override  
                return 1024;
        // Initially 4 files exits in fileCache.
            }  
        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // SHARD_0 uses INDEX_SETTINGS (remote_snapshot, not warm index)
     */
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);  
        // Restore permissions for cleanup
        // Try to clean up the deleted shard path
        cleaner.beforeIndexPathDeleted(WARM_INDEX_SETTINGS_0.getIndex(), WARM_INDEX_SETTINGS_0, env);  
        assertTrue(orchestrator.blockCaches().isEmpty());
     * Block cache eviction is NOT called for remote snapshot shards (isWarmIndex=false).  
    private static final Logger logger = LogManager.getLogger(FileCache.class);  
        // Assert that index path should exists and fileCache also have files for that index shard.
 * {@link FileCache} (Lucene LRU) and any registered {@link BlockCache} instances
import org.opensearch.plugins.BlockCache;
        // Try to not clean the index path without calling beforeShardPathDeleted method
        assertNull(fileCache.get(files.get(SHARD_0)));  
        orchestrator.addBlockCache(new BlockCache() {
        final Path cachePath = ShardPath.loadFileCachePath(env, SHARD_0).getDataPath();
        final Path indexFilePath1 = ShardPath.loadShardPath(logger, env, WARM_SHARD_1, "").getDataPath();
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));  
        assertTrue(Files.exists(files.get(WARM_SHARD_1)));
        final Path file = Files.createFile(localStorePath.resolve("file"));
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);  
            public void close() {}
            @Override
            @Override  
        assertEquals("evict_prefix must be called exactly once", 1, evictedPrefixes.size());
        cleaner = new NodeCacheServiceCleaner(() -> orchestrator);  
        assertFalse(Files.exists(files.get(WARM_SHARD_1)));  
        Files.createDirectories(localStorePath);  
        Files.setPosixFilePermissions(indicesPath, new HashSet<>());  
            @Override
    public void setUpFileCache() throws IOException {  
        Files.setPosixFilePermissions(indicesPath, PosixFilePermissions.fromString("rwxrwxrwx"));  
        // assert fileCache has 3 files.
    public void testIndexRemovedForWarmIndexWhenShardPathDeletedFirst() throws IOException {
import java.nio.file.attribute.PosixFilePermissions;  
        };
        BlockCache mockCache = new BlockCache() {
        IndexMetadata.builder("index").settings(SETTINGS).build(),  
        // Initially 4 files exits in fileCache.  
    /**
            public boolean isClosed() {
import org.apache.logging.log4j.Logger;
            @Override  
        // Verify fileCache still contains all files as remove operation won't get executed.
    private static void writeShardStateMetadata(String indexUUID, Path... paths) throws WriteStateException {
            paths
            public BlockCacheStats stats() {
        assertTrue(Files.exists(indexFilePath));  
        // Initially 4 files exist in fileCache
    private final FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(1024 * 1024, 1);
    }  
    private final Map<ShardId, Path> files = new HashMap<>();  
    }  
        final List<String> evictedPrefixes = new ArrayList<>();  
import java.nio.file.Path;
import org.opensearch.index.IndexSettings;
            @Override
        Path[] paths0 = env.availableShardPaths(WARM_SHARD_0);
        assertFalse(Files.exists(shardPath));
import org.opensearch.gateway.WriteStateException;
            @Override
        final List<String> evicted1 = new ArrayList<>();  
        // Shard path is still deleted  
        Path path1 = randomFrom(paths0);
        // clean warm_shard_1 files as well.
        final ShardPath shardPath = ShardPath.loadShardPath(logger, env, shardId, "");  
            public long length() {  
    }
     */
import static org.opensearch.index.store.remote.utils.FileTypeUtils.INDICES_FOLDER_IDENTIFIER;  
 */
            new ShardStateMetadata(true, indexUUID, AllocationId.newInitializing(), ShardStateMetadata.IndexDataLocation.LOCAL),
        assertFalse(Files.exists(indexFilePath));  
    );
        SETTINGS
            public long length() {  
     * When multiple block caches are registered, all of them receive evict_prefix
                return true;
        assertTrue(Files.exists(cachePath));
            @Override  
        files.put(SHARD_1, addFile(fileCache, env, SHARD_1));
import java.util.ArrayList;
     */  
            }
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));
            @Override
        assertFalse(Files.exists(files.get(SHARD_0)));
        final List<String> blockCacheEvictions = new ArrayList<>();
        final Path warmShardDataPath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();  
            @Override
import org.opensearch.common.settings.Settings;
            @Override  
            public BlockCacheStats stats() {  
            public void close() {
            @Override  
        final Path indexCachePath = env.fileCacheNodePath().fileCachePath.resolve(SHARD_0.getIndex().getUUID());
        // assert filecache contains 4 files
                evictedPrefixes.add(prefix);
/**  
import org.opensearch.cluster.metadata.IndexMetadata;
    private static final ShardId SHARD_1 = new ShardId("index", "uuid-1", 0);
import java.io.IOException;  
        });
            }  
                evicted1.add(prefix);
        // orchestrator has no block caches by default
        final Path warmShardDataPath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
     * caches with the shard's data path as the prefix.  
            public void evictPrefix(String prefix) {
            public void close() {}
            public boolean clear() {
                evictedPrefixes.add(prefix);
            public boolean clear() {
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        final Path localStorePath = shardPath.getDataPath().resolve(INDICES_FOLDER_IDENTIFIER);
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
    }
    }
        Path[] paths1 = env.availableShardPaths(WARM_SHARD_1);  
            public void evictPrefix(String prefix) {  
        assertFalse(Files.exists(indexFilePath1));
        logger.info("warm index local store location [{}]", localStorePath);  
        Path shardFilePath = shardPath.resolve(INDICES_FOLDER_IDENTIFIER).resolve("file");  
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
     */
        // assert filecache contains 4 files  
        // Initially 4 files exist in fileCache
            @Override
        final Path indexFilePath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
        });  
 * this file be licensed under the Apache-2.0 license or a
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
                return true;
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);  
    }
            }
    private NodeCacheService orchestrator;
        // now clean the index path.
}  
            public IndexInput getIndexInput() {
            @Override
    public void tearDownFileCache() {  
        .build();  
        );  
            }
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
    );
 * are deterministically evicted when a shard or index is deleted.  
package org.opensearch.index.store.remote.filecache;
            public boolean clear() {
        Path shardPath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
 * Tests for {@link NodeCacheServiceCleaner}: verifies that both the
     * and FileCache cleanup proceeds normally.
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
    // ── BlockCache eviction tests ─────────────────────────────────────────────
            @Override
import org.hamcrest.MatcherAssert;
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
        fileCache.put(file, new CachedIndexInput() {
            }
        return file;
            }
        cleaner.beforeShardPathDeleted(WARM_SHARD_1, WARM_INDEX_SETTINGS_1, env);  
            public void evictPrefix(String prefix) {
            @Override  
        Files.createDirectories(localStorePath);
    public void testBlockCacheEvictedOnWarmShardDeletion() throws IOException {
            @Override
            @Override
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));  
     * when a warm shard is deleted.  
            @Override  
import static org.hamcrest.Matchers.equalTo;
        orchestrator.addBlockCache(mockCache);
        Files.delete(shardFilePath);
        files.put(WARM_SHARD_1, addFileForWarmIndex(fileCache, env, WARM_SHARD_1));  
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
                return 1024;
        WARM_SETTINGS  
        fileCache.put(file, new CachedIndexInput() {
                return true;  
import java.util.List;
        MatcherAssert.assertThat(fileCache.size(), equalTo(2L));
            @Override
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));  
import org.opensearch.index.shard.ShardPath;  
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
        .put(IS_WARM_INDEX_SETTING.getKey(), true)
import org.opensearch.plugins.BlockCacheStats;  
        // clean warm_shard_0 files  
        final Path localStorePath = shardPath.getDataPath().resolve(LOCAL_STORE_LOCATION);
        };
    public void testNoCrashWhenNoBlockCachesRegistered() throws IOException {  
        assertFalse(Files.exists(cachePath));  
            public void evictPrefix(String prefix) {
        MatcherAssert.assertThat(fileCache.size(), equalTo(2L));
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
        IndexMetadata.builder("warm-index-1").settings(WARM_SETTINGS).build(),
        assertFalse(Files.exists(indexFilePath0));  
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
        Path indicesPath = shardPath.resolve(INDICES_FOLDER_IDENTIFIER);  
            @Override
        writeShardStateMetadata("warm-uuid-0", path1);  
        // Before: 4 files in FileCache, 0 block cache evictions
        assertFalse(Files.exists(files.get(WARM_SHARD_0)));
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
        cleaner.beforeShardPathDeleted(SHARD_0, INDEX_SETTINGS, env);
import org.opensearch.Version;
    }  
    private static final ShardId WARM_SHARD_1 = new ShardId("warm-index-1", "warm-uuid-1", 1);
    private static final IndexSettings WARM_INDEX_SETTINGS_0 = new IndexSettings(
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));  
        final List<String> evictedPrefixes = new ArrayList<>();  
        // Try to clean up with non-readable directory
    }  
        // add files in filecache for warm index shards.
    // ── FileCache eviction (original tests, adapted) ────────────────────────
    );
    private static final IndexSettings WARM_INDEX_SETTINGS_1 = new IndexSettings(
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);
        // Should not throw and should clean FileCache normally
    @Before
 * SPDX-License-Identifier: Apache-2.0
        });  
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
    }
        env.close();
            }  
    private static final ShardId WARM_SHARD_0 = new ShardId("warm-index-0", "warm-uuid-0", 0);
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));
        });
    }
        assertTrue("evict_prefix must NOT be called for remote snapshot shards", evictedPrefixes.isEmpty());
        env = newNodeEnvironment(SETTINGS);
    /**
    private static Path addFile(FileCache fileCache, NodeEnvironment env, ShardId shardId) throws IOException {  
        cleaner.beforeShardPathDeleted(SHARD_0, INDEX_SETTINGS, env);  
     * When a warm shard is deleted, evict_prefix is called on all registered block
    private static final Settings WARM_SETTINGS = Settings.builder()
import static org.opensearch.index.IndexModule.IS_WARM_INDEX_SETTING;
        cleaner.beforeShardPathDeleted(SHARD_1, INDEX_SETTINGS, env);
            @Override  
            @Override  
        });
        // Make the indices directory non-readable to cause IOException during directory stream
            }
            }
            }  
            }  
            public void close() {}
    public void testIndexNotRemovedForWarmIndexWhenShardPathNotDeletedFirst() throws IOException {  
    private static final ShardId SHARD_0 = new ShardId("index", "uuid-0", 0);  
        orchestrator.addBlockCache(new BlockCache() {  
        writeShardStateMetadata("warm-uuid-1", path2);
import org.apache.lucene.store.IndexInput;  
    public void testBothFileCacheAndBlockCacheEvictedTogether() throws IOException {
        orchestrator = new NodeCacheService(fileCache);
    private static final IndexSettings INDEX_SETTINGS = new IndexSettings(
            }  
        assertNull(fileCache.get(files.get(WARM_SHARD_1)));
        .build();
        final ShardPath shardPath = ShardPath.loadFileCachePath(env, shardId);
    private static final Settings SETTINGS = Settings.builder()
                blockCacheEvictions.add(prefix);
    }
import java.util.Map;
        assertEquals(warmShardDataPath.toString(), evicted2.get(0));  
import org.junit.Before;
            public BlockCacheStats stats() {  
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);
        assertTrue(Files.exists(shardFilePath));
            public BlockCacheStats stats() {
                return true;  
import org.apache.logging.log4j.LogManager;
        // Verify fileCache still contains all files as operation failed
            }  
    public void testIndexRemoved() {  
            }
        cleaner.beforeIndexPathDeleted(SHARD_0.getIndex(), INDEX_SETTINGS, env);  
import java.util.HashSet;  
            }
            }  
        final Path indexFilePath0 = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
            @Override  
    }
                evicted2.add(prefix);
            public void evictPrefix(String prefix) {  
        assertNull(fileCache.get(files.get(WARM_SHARD_0)));
                return new BlockCacheStats(0, 0, 0, 0, 0, 0, 0, 0, 0L, 0L, 0L, 0L);
            }
    private static Path addFileForWarmIndex(FileCache fileCache, NodeEnvironment env, ShardId shardId) throws IOException {
        cleaner.beforeShardPathDeleted(WARM_SHARD_0, WARM_INDEX_SETTINGS_0, env);  
        assertTrue(blockCacheEvictions.isEmpty());
        MatcherAssert.assertThat(fileCache.size(), equalTo(4L));  
        .put("index.store.type", "remote_snapshot")  
                return null;
        assertEquals("evict_prefix must use the shard data path", warmShardDataPath.toString(), evictedPrefixes.get(0));
import org.opensearch.cluster.routing.AllocationId;  
    }
            public void close() {
            public boolean isClosed() {
            public void close() {}
            public boolean clear() {
        orchestrator.addBlockCache(mockCache);
            @Override
                return false;  
     * Block cache eviction and FileCache eviction happen together in the same
 *
            }  
    public void testBlockCacheNotEvictedForRemoteSnapshotShard() {
     * beforeShardPathDeleted call — both caches are cleaned atomically.
            }
        Path path2 = randomFrom(paths1);
        cleaner.beforeShardPathDeleted(SHARD_0, INDEX_SETTINGS, env);
            public void close() {}
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));
        MatcherAssert.assertThat(fileCache.size(), equalTo(3L));
        assertNull(fileCache.get(files.get(WARM_SHARD_0)));
            public BlockCacheStats stats() {  
            }
        // Assert that index path deleted and fileCache also doesn't have files for that index shard.
 */  
        files.put(WARM_SHARD_0, addFileForWarmIndex(fileCache, env, WARM_SHARD_0));
    private NodeCacheServiceCleaner cleaner;  
        assertNull(fileCache.get(files.get(WARM_SHARD_0)));  
    /**
    }  
        assertEquals("first cache must receive evict_prefix", 1, evicted1.size());  
import java.nio.file.Files;
import org.opensearch.core.index.shard.ShardId;
import java.util.HashMap;
     * If no block caches are registered (hot nodes), no evict_prefix calls are made  
        assertTrue(Files.exists(indexFilePath));
        return file;
        // After: FileCache evicted the shard's file, BlockCache evict_prefix called
import static org.opensearch.index.store.remote.directory.RemoteSnapshotDirectoryFactory.LOCAL_STORE_LOCATION;
 * The OpenSearch Contributors require contributions made to  
        assertTrue(Files.exists(indexCachePath));
        final Path file = Files.createFile(localStorePath.resolve("file"));  
                return true;  
    public void testShardRemovedForWarmIndex() throws IOException {  
        ShardStateMetadata.FORMAT.writeAndCleanup(  
        BlockCache mockCache = new BlockCache() {
            public boolean clear() {
    }  
    @After
    public void testShardRemoved() {  
    /**
            @Override
import org.opensearch.env.NodeEnvironment;  
    }
            public IndexInput getIndexInput() {
        // clean shard path files first.  
            @Override
    /**  
        // Delete the shard path to simulate IOException when trying to load shard path
        final Path indexFilePath = ShardPath.loadShardPath(logger, env, WARM_SHARD_0, "").getDataPath();
    public void testFileCacheNotClearedAndWithFileAlreadyDeleted() throws IOException {  
            }
import org.junit.After;  
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
