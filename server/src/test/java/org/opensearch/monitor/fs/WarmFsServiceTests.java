    public void testStatsWithNullFileCache() throws Exception {
        when(fileCache.capacity()).thenReturn(fileCacheSSD);
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
            // Verify only primary shard size is counted
                indicesService,  
            // Verify only normal shard size is counted
            new ShardId("test", "_na_", 0),
            isActive ? ShardRoutingState.STARTED : ShardRoutingState.INITIALIZING
        long utilizedBytes = fc != null ? fc.usage() : 0L;
    public void testStatsWithBlockCacheCapacityAddedToReserved() throws Exception {
                indicesService,
            assertEquals("/warm", warmPath.path);
import org.opensearch.index.store.Store;
        // Setup
        // Create shards - one active, one inactive
import org.opensearch.core.index.shard.ShardId;
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
            assertEquals(expectedTotal, warmPath.total);  
    public void testStatsWithNullIndicesService() throws IOException {
        double dataToFileCacheSizeRatio = 5.0;
        try (var nodeEnv = newNodeEnvironment()) {
    private IndexService mockIndexService(long... shardSizes) throws Exception {  
        when(fileCache.usage()).thenReturn(fileCacheUsage);
            assertEquals(0L, warmPath.free);  
            // Verify that store.stats was only called on active shard
        List<IndexService> indexServices = new ArrayList<>();  
            FsInfo fsInfo = warmFsService.stats();  
        // Create service and get stats
                paths.add(path);
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);  
            for (FsInfo.Path path : fsInfo) {  
     * No block caches are registered, so all block-cache metrics are 0.
 */  
    public void setUp() throws Exception {
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
     */  
        when(orc.virtualBlockCacheBytes()).thenReturn(0L);
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
                indicesService,  
            // Verify that store.stats was only called on primary shard  
        // Mock multiple indices
import org.opensearch.cluster.routing.TestShardRouting;  
        }
        IndexShard errorShard = mockShardWithError(true, true);
        StoreStats storeStats = mock(StoreStats.class);
import org.opensearch.index.store.StoreStats;  
                mockOrchestrator(fileCache)  
    private NodeCacheService mockOrchestrator(FileCache fc) {
            assertEquals(fileCacheUsage, warmPath.fileCacheUtilized);
        double ratio = 5.0;
            assertEquals(expectedTotal, warmPath.total);  
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
                mockOrchestrator(fileCache)
            );
 * SPDX-License-Identifier: Apache-2.0
        List<IndexShard> shards = new ArrayList<>();
        // Create service and get stats
        List<IndexShard> shards = Collections.singletonList(shard);  
        // virtualBlockCacheBytes from block caches should contribute to the reported total capacity.
                paths.add(path);
                nodeEnv,
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
        when(orc.fileCache()).thenReturn(fc);  
                mockOrchestrator(fileCache)  
        double dataToFileCacheSizeRatio = 5.0;  
        long virtualBlockBytes = 200L * 1024 * 1024;  // block cache virtual capacity contribution
        when(fileCache.capacity()).thenReturn(fileCacheSSD);
            FsInfo.Path warmPath = fsInfo.iterator().next();
            for (FsInfo.Path path : fsInfo) {
        when(shard.store()).thenReturn(store);
                fileCacheSettings,
                settings,
    private IndexShard mockShardWithError(boolean isPrimary, boolean isActive) throws Exception {
            FsInfo.Path warmPath = paths.get(0);
            WarmFsService warmFsService = new WarmFsService(
            assertNotNull(fsInfo);
            assertEquals("warm", warmPath.mount);
        IndexService indexService = mock(IndexService.class);
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());  
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
        }
            }  
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
            assertEquals(expectedTotal, warmPath.total);
        double dataToFileCacheSizeRatio = 5.0;
import org.opensearch.index.IndexService;  
        when(shard.routingEntry()).thenReturn(shardRouting);
        try (var nodeEnv = newNodeEnvironment()) {  
        when(orc.cacheUtilizedBytes()).thenReturn(utilizedBytes);
                indicesService,
            // Verify that store.stats was never called  
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(ratio);  
        // Create shards - one primary, one replica  
            isPrimary,
            WarmFsService warmFsService = new WarmFsService(
            FsInfo.Path warmPath = paths.get(0);  
        when(zeroFileCache.capacity()).thenReturn(0L);
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
    }
        try (var nodeEnv = newNodeEnvironment()) {
 * compatible open source license.
                fileCacheSettings,
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(ratio);
                indicesService,  
        when(orc.blockCacheCapacityBytes()).thenReturn(0L);
    }
    }
                nodeEnv,  
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(ratio);  
            assertNotNull(fsInfo);  
                paths.add(path);
        when(indexService.iterator()).thenReturn(shards.iterator());
        when(shard.store()).thenReturn(store);
                mockOrchestrator(fileCache)  
        shards.add(normalShard);
        }
        when(orc.blockCacheCapacityBytes()).thenReturn(0L);  
        when(fileCache.usage()).thenReturn(fileCacheUsage);  
            FsInfo fsInfo = warmFsService.stats();
 *
        when(fileCache.usage()).thenReturn(fileCacheUsage);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.routing.ShardRoutingState;
        long fileCacheCapacity = 10L * 1024 * 1024; // 10MB  
        }
        when(orc.fileCache()).thenReturn(fileCache);
        // Setup — simulate a disabled cache: capacity=0, usage=0  
            verify(shard, never()).store();
        // Mock indices and shards
            FsInfo fsInfo = svc.stats();  
        when(orc.blockCacheCapacityBytes()).thenReturn(0L);
import static org.mockito.Mockito.verify;  
            long expectedFree = expectedTotal - expectedUsed;  
                mockOrchestrator(fileCache)
        for (long size : shardSizes) {
            List<FsInfo.Path> paths = new ArrayList<>();
            WarmFsService warmFsService = new WarmFsService(
    }
        when(store.stats(anyLong())).thenThrow(new RuntimeException("Test exception"));
    }  
        // Setup
            // Verify only active shard size is counted
    }
            long expectedUsed = shard1Size; // Only the normal shard  
        long shard1Size = 50L * 1024 * 1024; // 50MB
            assertEquals(totalCacheUtilized, warmPath.fileCacheUtilized);  
        // Create service and get stats  
        IndexService indexService1 = mockIndexService(50L * 1024 * 1024, 30L * 1024 * 1024);  
     * {@code fileCache()}, {@code blockCacheCapacityBytes()},  
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
            assertEquals(expectedFree, warmPath.free);
                fileCacheSettings,
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());
            assertEquals(expectedTotal, warmPath.available);
            FsInfo.Path warmPath = paths.get(0);
            "node1",  
            }  
            FsInfo fsInfo = warmFsService.stats();  
                fileCacheSettings,
        // Create service and get stats  
    private IndexShard mockShard(boolean isPrimary, boolean isActive, long sizeInBytes) throws Exception {
            WarmFsService warmFsService = new WarmFsService(
        super.setUp();  
                settings,  
            assertEquals(0L, warmPath.available);  
    public void testStatsWithInactiveShards() throws Exception {  
        List<IndexShard> shards = new ArrayList<>();
    }  
        // Create shard with null routing entry
            }
            FsInfo fsInfo = warmFsService.stats();
            FsInfo.Path warmPath = fsInfo.iterator().next();
        when(orc.fileCache()).thenReturn(fileCache);  
    private IndicesService indicesService;
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
            FsInfo.Path warmPath = paths.get(0);  
        long expectedReserved = fileCacheSSD + blockCacheSSD;
            FsInfo.Path warmPath = paths.get(0);  
            assertEquals(expectedFree, warmPath.available);
        return orc;  
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
        when(orc.blockCacheCapacityBytes()).thenReturn(blockCacheSSD);
        fileCacheSettings = mock(FileCacheSettings.class);
        when(indexService.iterator()).thenReturn(shards.iterator());  
            long expectedUsed = 50L * 1024 * 1024; // Only active shard  
            for (FsInfo.Path path : fsInfo) {
    private FileCache fileCache;
            assertEquals(expectedFree, warmPath.free);  
import org.opensearch.cluster.routing.ShardRouting;
        // Setup  
            for (FsInfo.Path path : fsInfo) {
package org.opensearch.monitor.fs;
        long blockCacheSSD = 50L * 1024 * 1024;    // 50 MB  
        double dataToFileCacheSizeRatio = 5.0;
        double ratio = 5.0;
        when(orc.cacheUtilizedBytes()).thenReturn(totalCacheUtilized);  
            FsInfo fsInfo = warmFsService.stats();  
        try (var nodeEnv = newNodeEnvironment()) {
     * {@code virtualBlockCacheBytes()}, and {@code cacheUtilizedBytes()}.
            );
        double dataToFileCacheSizeRatio = 5.0;
            // Verify
        // Create service and get stats
        }  
        IndexService indexService = mockIndexService(shard1Size, shard2Size);  
        when(indexService.iterator()).thenReturn(shards.iterator());
            assertEquals(expectedTotal, warmPath.total);
        double dataToFileCacheSizeRatio = 5.0;  
        when(shard.shardId()).thenReturn(shardRouting.shardId());
            assertEquals(fileCacheCapacity, warmPath.fileCacheReserved);  
        try (var nodeEnv = newNodeEnvironment()) {
        indexServices.add(indexService2);
        try (var nodeEnv = newNodeEnvironment()) {  
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB  
import static org.mockito.Mockito.mock;
        try (var nodeEnv = newNodeEnvironment()) {  
                settings,
        IndexShard primaryShard = mockShard(true, true, 50L * 1024 * 1024); // Primary, 50MB
                nodeEnv,
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);  
            isActive ? ShardRoutingState.STARTED : ShardRoutingState.INITIALIZING
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
            verify(inactiveShard.store(), never()).stats(anyLong());  
            long expectedFree = expectedTotal - expectedUsed;
    private Settings settings;
import org.opensearch.index.shard.IndexShard;
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
    public void testStatsWithNullRoutingEntry() throws Exception {
    @Override
import org.opensearch.indices.IndicesService;
        when(indicesService.iterator()).thenReturn(Collections.emptyIterator());
                settings,
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
                fileCacheSettings,
            WarmFsService svc = new WarmFsService(settings, nodeEnv, fileCacheSettings, indicesService, orc);  
        IndexShard activeShard = mockShard(true, true, 50L * 1024 * 1024); // Active primary, 50MB  
            isPrimary,  
        when(orc.virtualBlockCacheBytes()).thenReturn(0L);
        // cacheUtilizedBytes = fileCache.usage() + block caches disk/memory (0 here)  
                settings,
        when(shard.routingEntry()).thenReturn(null);
    }
        IndexService indexService = mock(IndexService.class);  
                mockOrchestrator(zeroFileCache)
            FsInfo fsInfo = svc.stats();
            List<FsInfo.Path> paths = new ArrayList<>();
            assertEquals(0L, warmPath.available);
        long fileCacheSSD = 100L * 1024 * 1024;  
            for (FsInfo.Path path : fsInfo) {  
        when(fileCache.usage()).thenReturn(fileCacheUsage);  
        // Block cache SSD bytes should be included in fileCacheReserved alongside FileCache bytes.  
    public void testStatsWithNonPrimaryShards() throws Exception {
        IndexService indexService = mock(IndexService.class);
        Store store = mock(Store.class);
            assertEquals(expectedFree, warmPath.free);
        long fileCacheCapacity = 200L * 1024 * 1024; // 200MB
        double dataToFileCacheSizeRatio = 5.0;  
        when(fileCache.usage()).thenReturn(20L * 1024 * 1024);
            List<FsInfo.Path> paths = new ArrayList<>();  
    }  
    public void testStatsWithNormalOperation() throws Exception {
        NodeCacheService orc = mock(NodeCacheService.class);
        when(orc.fileCache()).thenReturn(fileCache);  
import static org.mockito.Mockito.never;
            FsInfo.Path warmPath = paths.get(0);  
            FsInfo.Path warmPath = paths.get(0);
            // Verify
            assertEquals(-1L, warmPath.fileCacheReserved);
        when(fileCache.capacity()).thenReturn(fileCacheSSD);  
        // Setup
            assertEquals("warm", warmPath.type);
            List<FsInfo.Path> paths = new ArrayList<>();
        );  
        IndexService indexService = mockIndexService(shard1Size, shard2Size);
        indicesService = mock(IndicesService.class);  
        // Setup
            for (FsInfo.Path path : fsInfo) {
        IndexShard shard = mock(IndexShard.class);  
        when(orc.cacheUtilizedBytes()).thenReturn(0L);  
            );
            assertEquals(expectedTotal, warmPath.total);
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB  
        when(indexService.iterator()).thenReturn(shards.iterator());  
            long expectedFree = expectedTotal - expectedUsed;  
            assertEquals(0L, warmPath.total);
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
        }  
            for (FsInfo.Path path : fsInfo) {  
                settings,  
        IndexService indexService = mock(IndexService.class);
        when(fileCache.usage()).thenReturn(fileCacheUsage);
            new ShardId("test", "_na_", 1),
        long fileCacheUsage = 40L * 1024 * 1024; // 40MB
            }
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
        shards.add(inactiveShard);  
        // cacheUtilizedBytes returned by the orchestrator includes block cache disk+memory usage.
        // Create service and get stats
                mockOrchestrator(fileCache)
        shards.add(errorShard);  
        IndexService indexService = mockIndexService(shard1Size);  
            assertEquals(expectedTotal, warmPath.available);
            // Verify
            assertEquals(expectedFree, warmPath.free);  
            }  
        }
            FsInfo fsInfo = warmFsService.stats();
            assertEquals(expectedTotal, warmPath.free); // No used bytes since shard has null routing  
            assertEquals(expectedFree, warmPath.available);
            long expectedUsed = 50L * 1024 * 1024 + 30L * 1024 * 1024 + 20L * 1024 * 1024 + 10L * 1024 * 1024; // All shards
    }
    }
        IndexShard normalShard = mockShard(true, true, shard1Size);  
            // Verify
        fileCache = mock(FileCache.class);
import java.util.List;
        long shard1Size = 20L * 1024 * 1024; // 20MB - larger than total
            // Verify
            FsInfo fsInfo = warmFsService.stats();  
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        return indexService;
        NodeCacheService orc = mock(NodeCacheService.class);
        when(indexService.iterator()).thenReturn(shards.iterator());
            List<FsInfo.Path> paths = new ArrayList<>();  
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);  
            assertEquals("/warm", warmPath.path);
            assertNotNull(fsInfo);
        // Create service and get stats  
            FsInfo.Path warmPath = paths.get(0);
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB  
        try (var nodeEnv = newNodeEnvironment()) {  
        when(fileCache.usage()).thenReturn(fileCacheUsage);  
        settings = Settings.EMPTY;
            WarmFsService svc = new WarmFsService(settings, nodeEnv, fileCacheSettings, indicesService, orc);  
        when(fileCache.usage()).thenReturn(fileCacheUsage);
            }  
        ShardRouting shardRouting = TestShardRouting.newShardRouting(  
        }
        NodeCacheService orc = mock(NodeCacheService.class);
        long shard2Size = 30L * 1024 * 1024; // 30MB
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
            for (FsInfo.Path path : fsInfo) {
        long fileCacheUsage = 5L * 1024 * 1024; // 5MB
            assertEquals("warm", warmPath.type);  
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
 * this file be licensed under the Apache-2.0 license or a
        List<IndexShard> shards = new ArrayList<>();
import java.io.IOException;
                paths.add(path);
            List<FsInfo.Path> paths = new ArrayList<>();  
            assertEquals(1, paths.size());
        return shard;
    public void testStatsWithExceptionWhileGettingShardSize() throws Exception {
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
        IndexShard shard = mock(IndexShard.class);
                nodeEnv,  
                paths.add(path);
                fileCacheSettings,
            assertEquals(expectedTotal, warmPath.total);
        when(fileCache.usage()).thenReturn(fileCacheUsage);  
        IndexService indexService = mock(IndexService.class);
        FileCache zeroFileCache = mock(FileCache.class);
            FsInfo fsInfo = svc.stats();
        double ratio = 5.0;  
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
/*  
                fileCacheSettings,
        try (var nodeEnv = newNodeEnvironment()) {  
        when(indicesService.iterator()).thenReturn(Collections.emptyIterator());  
            verify(activeShard.store()).stats(anyLong());
        }
            assertEquals("warm", warmPath.mount);  
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
        when(indicesService.iterator()).thenReturn(indexServices.iterator());  
     * Stubs only the methods called by {@link WarmFsService#stats()}:
        long expectedTotal = (long) (ratio * fileCacheSSD) + virtualBlockBytes;  
    private FileCacheSettings fileCacheSettings;  
    }  
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
    }
        // Setup  
        try (var nodeEnv = newNodeEnvironment()) {
    public void testStatsWithUsedBytesExceedingTotal() throws Exception {  
    public void testStatsWithVirtualBlockCacheBytesAddedToTotal() throws Exception {
        when(shard.shardId()).thenReturn(shardRouting.shardId());
                nodeEnv,  
        long fileCacheUsage = 20L * 1024 * 1024; // 20MB
            FsInfo.Path warmPath = fsInfo.iterator().next();
        when(fileCache.usage()).thenReturn(0L);
            long expectedUsed = shard1Size + shard2Size;  
public class WarmFsServiceTests extends OpenSearchTestCase {  
            WarmFsService warmFsService = new WarmFsService(
        long shard1Size = 50L * 1024 * 1024; // 50MB  
            FsInfo fsInfo = warmFsService.stats();
    }  
        double dataToFileCacheSizeRatio = 5.0;  
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
                indicesService,  
            verify(replicaShard.store(), never()).stats(anyLong());
                paths.add(path);
        long fileCacheSSD = 100L * 1024 * 1024;   // 100 MB
        NodeCacheService orc = mock(NodeCacheService.class);
        when(shard.routingEntry()).thenReturn(shardRouting);  
                indicesService,
            assertEquals(expectedTotal, warmPath.free); // No used bytes since no indices  
        double dataToFileCacheSizeRatio = 1.0; // Small ratio
            WarmFsService warmFsService = new WarmFsService(
            );
        // Setup
import org.opensearch.index.store.remote.filecache.FileCache;
            List<FsInfo.Path> paths = new ArrayList<>();
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());  
        // Create service with zero-capacity cache (equivalent to the old "null" case)  
        shards.add(activeShard);
        // Setup
import org.opensearch.test.OpenSearchTestCase;
                paths.add(path);
            "node1",
            long expectedFree = expectedTotal - expectedUsed;
                nodeEnv,  
            );
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);
        Store store = mock(Store.class);  
import org.opensearch.index.store.remote.filecache.NodeCacheService;  
import org.opensearch.common.settings.Settings;
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
            assertEquals(expectedTotal, warmPath.total);
            );
            WarmFsService warmFsService = new WarmFsService(settings, nodeEnv, fileCacheSettings, null, mockOrchestrator(fileCache));
        shards.add(replicaShard);
                settings,  
                nodeEnv,
                paths.add(path);  
            shards.add(mockShard(true, true, size));  
                indicesService,
            for (FsInfo.Path path : fsInfo) {
        );
        // Mock indices and shards
            }  
            FsInfo fsInfo = warmFsService.stats();
            assertEquals(expectedTotal, warmPath.total);
        IndexShard inactiveShard = mockShard(true, false, 30L * 1024 * 1024); // Inactive primary, 30MB
        IndexService indexService2 = mockIndexService(20L * 1024 * 1024, 10L * 1024 * 1024);
            long expectedFree = expectedTotal - expectedUsed;
     * Creates a {@link NodeCacheService} mock that wraps the given {@link FileCache}.
        when(indicesService.iterator()).thenReturn(Collections.emptyIterator());  
            assertEquals(expectedFree, warmPath.available);
            // Verify free bytes is 0 (not negative)
            assertEquals(expectedFree, warmPath.available);
        }
            assertEquals(expectedReserved, warmPath.fileCacheReserved);  
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
        }  
            verify(primaryShard.store()).stats(anyLong());
            WarmFsService svc = new WarmFsService(settings, nodeEnv, fileCacheSettings, indicesService, orc);
            assertEquals(expectedFree, warmPath.free);
                fileCacheSettings,
    }
        }
    /**  
        try (var nodeEnv = newNodeEnvironment()) {
            WarmFsService warmFsService = new WarmFsService(
        when(zeroFileCache.usage()).thenReturn(0L);  
            long expectedUsed = 50L * 1024 * 1024; // Only primary shard
    }
            }
        long shard2Size = 30L * 1024 * 1024; // 30MB
            long expectedTotal = (long) (dataToFileCacheSizeRatio * fileCacheCapacity);
    // ── Helpers ───────────────────────────────────────────────────────────────
                mockOrchestrator(fileCache)  
import java.util.ArrayList;
        long fileCacheCapacity = 100L * 1024 * 1024; // 100MB
        shards.add(primaryShard);
import static org.mockito.ArgumentMatchers.anyLong;  
        when(storeStats.getSizeInBytes()).thenReturn(sizeInBytes);  
            List<FsInfo.Path> paths = new ArrayList<>();  
        long fileCacheSSD = 100L * 1024 * 1024;
        // Create shards - one normal, one that throws exception
import static org.mockito.Mockito.when;
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
            }
    }
        when(fileCacheSettings.getRemoteDataRatio()).thenReturn(dataToFileCacheSizeRatio);  
        long totalCacheUtilized = 70L * 1024 * 1024;  // combined file + block cache usage
                settings,  
        IndexShard shard = mock(IndexShard.class);  
            List<FsInfo.Path> paths = new ArrayList<>();  
        List<IndexShard> shards = new ArrayList<>();
import java.util.Collections;  
        when(fileCache.usage()).thenReturn(0L);
            assertEquals(1, paths.size());
            assertEquals(1, paths.size());
        // Mock indices and shards
        when(orc.virtualBlockCacheBytes()).thenReturn(virtualBlockBytes);
}  
            assertEquals(0L, warmPath.free); // Math.max(0, negative) = 0
        when(fileCache.capacity()).thenReturn(fileCacheCapacity);
            assertEquals(0L, warmPath.fileCacheUtilized);  
        when(orc.virtualBlockCacheBytes()).thenReturn(0L);
                paths.add(path);
        return shard;
        when(orc.cacheUtilizedBytes()).thenReturn(0L);
            assertEquals(expectedTotal, warmPath.total);  
            WarmFsService warmFsService = new WarmFsService(
    public void testStatsWithBlockCacheUtilizationIncludedInCacheUtilized() throws Exception {  
        when(indicesService.iterator()).thenReturn(Collections.singletonList(indexService).iterator());  
    public void testStatsWithMultipleIndices() throws Exception {
        }
                nodeEnv,
        when(store.stats(anyLong())).thenReturn(storeStats);
            FsInfo.Path warmPath = paths.get(0);  
        try (var nodeEnv = newNodeEnvironment()) {
            );
        // Create service with null indices service
        long shard1Size = 50L * 1024 * 1024; // 50MB
        indexServices.add(indexService1);
            assertEquals(expectedFree, warmPath.available);
        IndexShard replicaShard = mockShard(false, true, 30L * 1024 * 1024); // Replica, 30MB  
            );
