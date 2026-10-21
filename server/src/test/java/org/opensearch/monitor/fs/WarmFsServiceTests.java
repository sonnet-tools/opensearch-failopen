                indicesService,
    private FileCache fileCache;
        long shard2Size = 30L * 1024 * 1024; // 30MB
            long expectedFree = expectedTotal - expectedUsed;
            assertEquals(expectedFree, warmPath.free);
        // Mock multiple indices
        when(orc.cacheUtilizedBytes()).thenReturn(0L);
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
            assertEquals(0L, warmPath.fileCacheUtilized);
            for (FsInfo.Path path : fsInfo) {
            for (FsInfo.Path path : fsInfo) {
            assertEquals(expectedTotal, warmPath.total);
        IndexShard normalShard = mockShard(true, true, shard1Size);
            "node1",
        when(fileCache.usage()).thenReturn(fileCacheUsage);
    }
                mockOrchestrator(fileCache)
    public void testStatsWithNullIndicesService() throws IOException {
            FsInfo.Path warmPath = paths.get(0);
            FsInfo.Path warmPath = paths.get(0);
        // Setup
        when(store.stats(anyLong())).thenReturn(storeStats);
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(ratio);
import org.opensearch.cluster.routing.TestShardRouting;
 */
            assertNotNull(fsInfo);
            }
            assertEquals("/warm", warmPath.path);
     * {@code virtualBlockCacheBytes()}, and {@code cacheUtilizedBytes()}.
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
        // cacheUtilizedBytes = fileCache.usage() + block caches disk/memory (0 here)
            FsInfo.Path warmPath = fsInfo.iterator().next();
        // virtualBlockCacheBytes from block caches should contribute to the reported total capacity.
        try (var nodeEnv = newNodeEnvironment()) {
            FsInfo.Path warmPath = paths.get(0);
            assertEquals(expectedFree, warmPath.available);
        return shard;
            long expectedFree = expectedTotal - expectedUsed;
        // Create shard with null routing entry
            for (FsInfo.Path path : fsInfo) {
        fileCacheSettings = mock(FileCacheSettings.class);
        long expectedReserved = fileCacheSSD + blockCacheSSD;
        // Setup
                fileCacheSettings,
            long expectedUsed = shard1Size + shard2Size;
            assertEquals("warm", warmPath.type);
import org.opensearch.cluster.routing.ShardRouting;
            assertEquals(expectedTotal, warmPath.total);
                fileCacheSettings,
        IndexService indexService1 = mockIndexService(50L * 1024 * 1024, 30L * 1024 * 1024);
    }
import static org.mockito.Mockito.when;
    // ── Helpers ───────────────────────────────────────────────────────────────
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
        // Setup
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
 * compatible open source license.
            WarmFsService warmFsService = new WarmFsService(
        when(indexService.iterator()).thenReturn(shards.iterator());
            FsInfo fsInfo = warmFsService.stats();
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
            assertEquals("warm", warmPath.mount);
                mockOrchestrator(zeroFileCache)
            assertEquals(expectedFree, warmPath.available);
        }
            assertEquals(1, paths.size());
        StoreStats storeStats = mock(StoreStats.class);
    }
        long fileCacheSSD = 100L * 1024 * 1024;   // 100 MB
        IndexService indexService = mockIndexService(shard1Size, shard2Size);
import org.opensearch.index.store.StoreStats;
        double dataToFileCacheSizeRatio = 1.0; // Small ratio
            FsInfo fsInfo = warmFsService.stats();
            assertEquals("warm", warmPath.type);
            List<FsInfo.Path> paths = new ArrayList<>();
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
        when(orc.virtualBlockCacheBytes()).thenReturn(0L);
        long virtualBlockBytes = 200L * 1024 * 1024;  // block cache virtual capacity contribution
        );
            List<FsInfo.Path> paths = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
    public void testStatsWithBlockCacheUtilizationIncludedInCacheUtilized() throws Exception {
            assertEquals(expectedFree, warmPath.available);
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
import org.opensearch.indices.IndicesService;
        try (var nodeEnv = newNodeEnvironment()) {
            assertEquals(-1L, warmPath.fileCacheReserved);
            FsInfo fsInfo = svc.stats();
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
            for (FsInfo.Path path : fsInfo) {
            assertEquals(expectedReserved, warmPath.fileCacheReserved);
            shards.add(mockShard(true, true, size));
            // Verify only primary shard size is counted
        List<IndexShard> shards = new ArrayList<>();
        when(fileCache.usage()).thenReturn(fileCacheUsage);
                nodeEnv,
        shards.add(normalShard);
            long expectedUsed = 50L * 1024 * 1024; // Only primary shard
        when(shard.store()).thenReturn(store);
        when(orc.cacheUtilizedBytes()).thenReturn(0L);
        when(orc.blockCacheCapacityBytes()).thenReturn(0L);
        double dataToFileCacheSizeRatio = 5.0;
            isPrimary,
    /**
            );
    }
            }
            assertEquals(0L, warmPath.free); // Math.max(0, negative) = 0
            FsInfo.Path warmPath = paths.get(0);
            WarmFsService warmFsService = new WarmFsService(
        long fileCacheCapacity = 10L * 1024 * 1024; // 10MB
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
import static org.mockito.Mockito.verify;
    }
        // Setup
                nodeEnv,
                paths.add(path);
        IndexService indexService = mock(IndexService.class);
                settings,
            FsInfo fsInfo = warmFsService.stats();
import org.opensearch.common.settings.Settings;
        // Create service and get stats
            assertEquals(expectedTotal, warmPath.free); // No used bytes since no indices
        double dataToFileCacheSizeRatio = 5.0;
                nodeEnv,
            // Verify that store.stats was only called on active shard
        Store store = mock(Store.class);
        }
        // Create service and get stats
        IndexShard replicaShard = mockShard(false, true, 30L * 1024 * 1024); // Replica, 30MB
            );
    private IndexShard mockShard(boolean isPrimary, boolean isActive, long sizeInBytes) throws Exception {
    public void setUp() throws Exception {
        when(indexService.iterator()).thenReturn(shards.iterator());
        // Create service and get stats
        when(orc.fileCache()).thenReturn(fc);
        Store store = mock(Store.class);
            );
            }
            );
import org.opensearch.index.IndexService;
        when(fileCache.usage()).thenReturn(fileCacheUsage);
        List<IndexShard> shards = new ArrayList<>();
    private FileCacheSettings fileCacheSettings;
    }
            assertEquals(expectedTotal, warmPath.total);
            // Verify only active shard size is counted
            // Verify
        double ratio = 5.0;
                fileCacheSettings,
            FsInfo.Path warmPath = paths.get(0);
        List<IndexShard> shards = Collections.singletonList(shard);
            for (FsInfo.Path path : fsInfo) {
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
                mockOrchestrator(fileCache)
                settings,
     * Creates a {@link NodeCacheService} mock that wraps the given {@link FileCache}.
        when(fileCache.usage()).thenReturn(fileCacheUsage);
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(ratio);
            List<FsInfo.Path> paths = new ArrayList<>();
                indicesService,
            FsInfo.Path warmPath = paths.get(0);
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
                paths.add(path);
        when(orc.fileCache()).thenReturn(fileCache);
import org.opensearch.index.shard.IndexShard;
        IndexService indexService = mock(IndexService.class);
    }
        when(fileCache.usage()).thenReturn(fileCacheUsage);
                paths.add(path);
            FsInfo.Path warmPath = paths.get(0);
        }
        }
        // Create shards - one active, one inactive
        when(fileCache.usage()).thenReturn(0L);
        when(orc.blockCacheCapacityBytes()).thenReturn(blockCacheSSD);
        try (var nodeEnv = newNodeEnvironment()) {
        IndexShard errorShard = mockShardWithError(true, true);
    }
                nodeEnv,
        when(fileCache.usage()).thenReturn(20L * 1024 * 1024);
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
            long expectedUsed = 50L * 1024 * 1024; // Only active shard
                paths.add(path);
        }
            // Verify only normal shard size is counted
    }
import org.opensearch.index.store.remote.filecache.NodeCacheService;
        when(indicesService.iterator()).thenReturn(indexServices.iterator());
                indicesService,
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
        long totalCacheUtilized = 70L * 1024 * 1024;  // combined file + block cache usage
            for (FsInfo.Path path : fsInfo) {
        double dataToFileCacheSizeRatio = 5.0;
import org.opensearch.core.index.shard.ShardId;
        IndexShard shard = mock(IndexShard.class);
        when(orc.virtualBlockCacheBytes()).thenReturn(virtualBlockBytes);
            assertEquals(0L, warmPath.available);
        return shard;
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
        // Create service with null indices service
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
            assertNotNull(fsInfo);
        when(orc.fileCache()).thenReturn(fileCache);
        double dataToFileCacheSizeRatio = 5.0;
                fileCacheSettings,
            WarmFsService warmFsService = new WarmFsService(
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(1, paths.size());
    }
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
        // Create service and get stats
     * No block caches are registered, so all block-cache metrics are 0.
        try (var nodeEnv = newNodeEnvironment()) {
        super.setUp();
        }
            List<FsInfo.Path> paths = new ArrayList<>();
        fileCache = mock(FileCache.class);
        long fileCacheSSD = 100L * 1024 * 1024;
        shards.add(activeShard);
        when(orc.fileCache()).thenReturn(fileCache);
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
            assertEquals(expectedTotal, warmPath.total);
        when(indicesService.iterator()).thenReturn(Collections.emptyIterator());
            assertEquals("warm", warmPath.mount);
                fileCacheSettings,
    }
        shards.add(replicaShard);
                indicesService,
            verify(shard, never()).store();
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
    public void testStatsWithNullFileCache() throws Exception {
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
        long fileCacheSSD = 100L * 1024 * 1024;
            long expectedUsed = shard1Size; // Only the normal shard
    }
package org.opensearch.monitor.fs;
import java.util.ArrayList;
    public void testStatsWithNullRoutingEntry() throws Exception {
        // cacheUtilizedBytes returned by the orchestrator includes block cache disk+memory usage.
        indexServices.add(indexService2);
            assertEquals(totalCacheUtilized, warmPath.fileCacheUtilized);
        indicesService = mock(IndicesService.class);
        // Setup — simulate a disabled cache: capacity=0, usage=0
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
        try (var nodeEnv = newNodeEnvironment()) {
        NodeCacheService orc = mock(NodeCacheService.class);
            // Verify
            // Verify
import org.opensearch.cluster.routing.ShardRoutingState;
        IndexShard primaryShard = mockShard(true, true, 50L * 1024 * 1024); // Primary, 50MB
            assertEquals(0L, warmPath.total);
        }
        when(fileCache.usage()).thenReturn(fileCacheUsage);
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        long shard1Size = 20L * 1024 * 1024; // 20MB - larger than total
                indicesService,
            }
        // Setup
    private IndicesService indicesService;
            assertEquals(expectedTotal, warmPath.total);
        // Create service and get stats
            assertEquals(0L, warmPath.available);
                nodeEnv,
        when(orc.cacheUtilizedBytes()).thenReturn(utilizedBytes);
        // Create shards - one normal, one that throws exception
            assertEquals(expectedTotal, warmPath.available);
    public void testStatsWithNormalOperation() throws Exception {
                indicesService,
            WarmFsService warmFsService = new WarmFsService(
    private IndexShard mockShardWithError(boolean isPrimary, boolean isActive) throws Exception {
            FsInfo fsInfo = warmFsService.stats();
        );
        IndexService indexService = mock(IndexService.class);
                indicesService,
        // Create service with zero-capacity cache (equivalent to the old "null" case)
    }
    public void testStatsWithExceptionWhileGettingShardSize() throws Exception {
    }
            assertEquals("/warm", warmPath.path);
        long utilizedBytes = fc != null ? fc.usage() : 0L;
    private IndexService mockIndexService(long... shardSizes) throws Exception {
        // Mock indices and shards
            assertNotNull(fsInfo);
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
            List<FsInfo.Path> paths = new ArrayList<>();
        when(fileCache.usage()).thenReturn(fileCacheUsage);
        shards.add(primaryShard);
        when(orc.blockCacheCapacityBytes()).thenReturn(0L);
            FsInfo fsInfo = warmFsService.stats();
        }
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
        double ratio = 5.0;
        double dataToFileCacheSizeRatio = 5.0;
        NodeCacheService orc = mock(NodeCacheService.class);
            );
        }
        long shard1Size = 50L * 1024 * 1024; // 50MB
                paths.add(path);
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
        when(fileCache.usage()).thenReturn(0L);
            isActive ? ShardRoutingState.STARTED : ShardRoutingState.INITIALIZING
            // Verify that store.stats was never called
        when(shard.routingEntry()).thenReturn(shardRouting);
        try (var nodeEnv = newNodeEnvironment()) {
        when(fileCache.usage()).thenReturn(fileCacheUsage);
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
        return indexService;
        FileCache zeroFileCache = mock(FileCache.class);
                nodeEnv,
        IndexShard activeShard = mockShard(true, true, 50L * 1024 * 1024); // Active primary, 50MB
            FsInfo fsInfo = warmFsService.stats();
        List<IndexShard> shards = new ArrayList<>();
                indicesService,
        when(indexService.iterator()).thenReturn(shards.iterator());
 *
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
                mockOrchestrator(fileCache)
    private NodeCacheService mockOrchestrator(FileCache fc) {
import static org.mockito.Mockito.mock;
            // Verify free bytes is 0 (not negative)
                paths.add(path);
import org.opensearch.test.OpenSearchTestCase;
        when(shard.store()).thenReturn(store);
        try (var nodeEnv = newNodeEnvironment()) {
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
        when(orc.blockCacheCapacityBytes()).thenReturn(0L);
            for (FsInfo.Path path : fsInfo) {
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        // Create shards - one primary, one replica
        when(shard.shardId()).thenReturn(shardRouting.shardId());
                settings,
                fileCacheSettings,
            FsInfo fsInfo = warmFsService.stats();
        List<IndexShard> shards = new ArrayList<>();
        try (var nodeEnv = newNodeEnvironment()) {
    public void testStatsWithNonPrimaryShards() throws Exception {
                paths.add(path);
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
                fileCacheSettings,
                nodeEnv,
            assertEquals(0L, warmPath.free);
                mockOrchestrator(fileCache)
            WarmFsService warmFsService = new WarmFsService(
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(ratio);
            List<FsInfo.Path> paths = new ArrayList<>();
            verify(activeShard.store()).stats(anyLong());
            verify(inactiveShard.store(), never()).stats(anyLong());
            FsInfo.Path warmPath = paths.get(0);
        long shard1Size = 50L * 1024 * 1024; // 50MB
        long blockCacheSSD = 50L * 1024 * 1024;    // 50 MB
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
        IndexShard inactiveShard = mockShard(true, false, 30L * 1024 * 1024); // Inactive primary, 30MB
import static org.mockito.ArgumentMatchers.anyLong;
            FsInfo.Path warmPath = fsInfo.iterator().next();
        indexServices.add(indexService1);
    @Override
                fileCacheSettings,
        long fileCacheCapacity = 200L * 1024 * 1024; // 200MB
            FsInfo fsInfo = svc.stats();
            assertEquals(expectedFree, warmPath.free);
        when(shard.shardId()).thenReturn(shardRouting.shardId());
     */
            assertEquals(expectedFree, warmPath.free);
        try (var nodeEnv = newNodeEnvironment()) {
        double dataToFileCacheSizeRatio = 5.0;
    public void testStatsWithInactiveShards() throws Exception {
        double ratio = 5.0;
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
        when(shard.routingEntry()).thenReturn(null);
        // Setup
import org.opensearch.index.store.Store;
        IndexService indexService = mock(IndexService.class);
        try (var nodeEnv = newNodeEnvironment()) {
        when(fileCache.capacity()).thenReturn(fileCacheSSD);
            // Verify that store.stats was only called on primary shard
        // Create service and get stats
        // Block cache SSD bytes should be included in fileCacheReserved alongside FileCache bytes.
        when(indexService.iterator()).thenReturn(shards.iterator());
            FsInfo fsInfo = warmFsService.stats();
        for (long size : shardSizes) {
            "node1",
        // Setup
                paths.add(path);
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        return orc;
            assertEquals(expectedFree, warmPath.available);
    public void testStatsWithVirtualBlockCacheBytesAddedToTotal() throws Exception {
import java.util.List;
            }
            new ShardId("test", "_na_", 1),
        long shard2Size = 30L * 1024 * 1024; // 30MB
                settings,
            );
        when(fileCache.capacity()).thenReturn(fileCacheSSD);
        when(zeroFileCache.capacity()).thenReturn(0L);
                nodeEnv,
 * The OpenSearch Contributors require contributions made to
        when(storeStats.getSizeInBytes()).thenReturn(sizeInBytes);
                mockOrchestrator(fileCache)
            FsInfo fsInfo = svc.stats();
            assertEquals(expectedFree, warmPath.available);
                mockOrchestrator(fileCache)
            FsInfo fsInfo = warmFsService.stats();
            assertEquals(1, paths.size());
            WarmFsService svc = new WarmFsService(settings, nodeEnv, fileCacheSettings, indicesService, orc);
    public void testStatsWithMultipleIndices() throws Exception {
            List<FsInfo.Path> paths = new ArrayList<>();
            );
            WarmFsService svc = new WarmFsService(settings, nodeEnv, fileCacheSettings, indicesService, orc);
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
        shards.add(errorShard);
import java.util.Collections;
        // Create service and get stats
    public void testStatsWithBlockCacheCapacityAddedToReserved() throws Exception {
            long expectedFree = expectedTotal - expectedUsed;
            }
    private Settings settings;
                settings,
        when(fileCache.capacity()).thenReturn(fileCacheSSD);
        // Mock indices and shards
            assertEquals(fileCacheUsage, warmPath.fileCacheUtilized);
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        List<IndexService> indexServices = new ArrayList<>();
        IndexShard shard = mock(IndexShard.class);
            assertEquals(expectedTotal, warmPath.total);
        long shard1Size = 50L * 1024 * 1024; // 50MB
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
                settings,
public class WarmFsServiceTests extends OpenSearchTestCase {
            WarmFsService warmFsService = new WarmFsService(
            new ShardId("test", "_na_", 0),
import org.opensearch.index.store.remote.filecache.FileCache;
            List<FsInfo.Path> paths = new ArrayList<>();
        settings = Settings.EMPTY;
        long fileCacheUsage = 40L * 1024 * 1024; // 40MB
        // Setup
            assertEquals(fileCacheCapacity, warmPath.fileCacheReserved);
            long expectedFree = expectedTotal - expectedUsed;
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
        IndexService indexService = mockIndexService(shard1Size);
        long expectedTotal = (long) (ratio * fileCacheSSD) + virtualBlockBytes;
}
    }
        IndexService indexService = mock(IndexService.class);
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
     * Stubs only the methods called by {@link WarmFsService#stats()}:
        when(shard.routingEntry()).thenReturn(shardRouting);
        long fileCacheUsage = 5L * 1024 * 1024; // 5MB
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
            assertEquals(expectedTotal, warmPath.total);
        shards.add(inactiveShard);
            long expectedUsed = 50L * 1024 * 1024 + 30L * 1024 * 1024 + 20L * 1024 * 1024 + 10L * 1024 * 1024; // All shards
        when(store.stats(anyLong())).thenThrow(new RuntimeException("Test exception"));
            List<FsInfo.Path> paths = new ArrayList<>();
            assertEquals(expectedTotal, warmPath.total);
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
            verify(replicaShard.store(), never()).stats(anyLong());
            FsInfo.Path warmPath = paths.get(0);
        when(indicesService.iterator()).thenReturn(Collections.emptyIterator());
                settings,
            assertEquals(expectedFree, warmPath.free);
            WarmFsService warmFsService = new WarmFsService(settings, nodeEnv, fileCacheSettings, null, mockOrchestrator(fileCache));
            }
            isPrimary,
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        double dataToFileCacheSizeRatio = 5.0;
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
                mockOrchestrator(fileCache)
        NodeCacheService orc = mock(NodeCacheService.class);
            );
            WarmFsService warmFsService = new WarmFsService(
        try (var nodeEnv = newNodeEnvironment()) {
            assertEquals(expectedTotal, warmPath.free); // No used bytes since shard has null routing
import static org.mockito.Mockito.never;
                paths.add(path);
            }
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
        when(orc.cacheUtilizedBytes()).thenReturn(totalCacheUtilized);
        when(indicesService.iterator()).thenReturn(Collections.emptyIterator());
    }
        IndexService indexService2 = mockIndexService(20L * 1024 * 1024, 10L * 1024 * 1024);
            assertEquals(expectedFree, warmPath.free);
        try (var nodeEnv = newNodeEnvironment()) {
        // Mock indices and shards
        when(orc.virtualBlockCacheBytes()).thenReturn(0L);
            for (FsInfo.Path path : fsInfo) {
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        }
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
import java.io.IOException;
        }
        when(orc.virtualBlockCacheBytes()).thenReturn(0L);
            WarmFsService warmFsService = new WarmFsService(
        IndexService indexService = mockIndexService(shard1Size, shard2Size);
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
    }
        IndexShard shard = mock(IndexShard.class);
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
            isActive ? ShardRoutingState.STARTED : ShardRoutingState.INITIALIZING
            assertEquals(expectedTotal, warmPath.total);
            // Verify
                settings,
    public void testStatsWithUsedBytesExceedingTotal() throws Exception {
/*
            long expectedFree = expectedTotal - expectedUsed;
            }
        }
        when(indexService.iterator()).thenReturn(shards.iterator());
        double dataToFileCacheSizeRatio = 5.0;
            assertEquals(expectedTotal, warmPath.available);
            verify(primaryShard.store()).stats(anyLong());
        when(zeroFileCache.usage()).thenReturn(0L);
            WarmFsService svc = new WarmFsService(settings, nodeEnv, fileCacheSettings, indicesService, orc);
        NodeCacheService orc = mock(NodeCacheService.class);
            // Verify
            for (FsInfo.Path path : fsInfo) {
     * {@code fileCache()}, {@code blockCacheCapacityBytes()},
            FsInfo.Path warmPath = fsInfo.iterator().next();
        }
