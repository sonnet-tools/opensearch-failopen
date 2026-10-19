            0,
                    }  
            assertTrue(path + " not tracked and not on Linux", Constants.LINUX);
    }
        TestFileStore getTestFileStore(Path path) {  
                return minShardSize;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), WATERMARK_BYTES + "b")  
        assertBusy(() -> {
        // Free all the space
            .getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
            totalCacheSize,
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();  
    /**
            MockInternalClusterInfoService.TestPlugin.class,
    public static Collection<Object[]> parameters() {  
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageExceedsIndexThreshold() throws Exception {
            for (String index : indexList) {
import org.opensearch.index.store.remote.filecache.FileCacheStats;  
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "1000b")  
        final RestoreInfo restoreInfo = restoreSnapshotResponse.getRestoreInfo();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            0,
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        remoteRepoPath = randomRepoPath().toAbsolutePath();
            for (ShardRouting shard : indexShardRoutingTable.shards()) {  
            .setRoutingTable(true)
import org.opensearch.monitor.fs.FsService;
import java.util.concurrent.TimeUnit;  
    private void simulateFileCacheActiveUsage(
        public void setTotalSpace(long totalSpace) {
        final String dataNodeName = internalCluster().startDataOnlyNode();
                throw new AssertionError("unexpected", e);
            totalCacheSize,
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
    public void testIndexCreateBlockWhenAllNodesExceededHighWatermark() throws Exception {  
        );
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
    }
        createRepository("repo", FsRepository.TYPE, settings);  
            .put(INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), "0ms")
            0,
            createIndex(indexName, indexSettingBuilder.build());
            assertTrue(state1.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));  
     * Helper method to release disk pressure for both hot and warm indices  
            final long[] shardSizes = new long[shardStatses.length];
        final Path dataPath = fileSystemProvider.getRootDir().resolve("node-" + nodeOrdinal);  
        final Path dataNode0Path = internalCluster().getInstance(Environment.class, dataNodeName).dataFiles()[0];  
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageExceedsSearchThresholdInBytes() throws Exception {
                    .updateSettings(
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
                indexRequestBuilders[i] = client().prepareIndex(indexName).setSource("field", randomAlphaOfLength(10));
        assertBusyWithDiskUsageRefresh(dataNode0Id, indexName, empty());  
    protected Path remoteRepoPath;  
                }
        var nodeNames = startTestNodes(1, nodeSettings);  
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).get().getState();
                assertFalse(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK));  
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
 * specific language governing permissions and limitations
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;  
        assumeTrue(
        public String name() {
            return "fake"; // Lucene's is-spinning-disk check expects the device name here  
        return new AggregateFileCacheStats(System.currentTimeMillis(), overallStats, fullStats, blockStats, pinnedStats);
        long totalCacheSize  
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageDropsBelowIndexThreshold() throws Exception {
        return WRITABLE_WARM_INDEX_SETTING.get(settings) == false;
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, WATERMARK_BYTES - 1)
import org.opensearch.cluster.metadata.IndexMetadata;
        FileCacheStats overallStats = new FileCacheStats(  
        var nodeNames = startTestNodes(2, nodeSettings);  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(removeBlockSetting).get());  
        // reduce disk size of node 0 so that no shards fit below the low watermark, forcing shards to be assigned to the other data node
                return Math.max(0L, totalSpace - getTotalFileSize(path));
            .put(FsService.ALWAYS_REFRESH_SETTING.getKey(), true)
                        .build()
    private static class TestFileSystemProvider extends FilterFileSystemProvider {
        simulateDiskPressure(clusterInfoService);
     * Helper method to build test-specific settings with support for both hot and warm indices
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        ensureStableCluster(3);
import org.opensearch.repositories.fs.FsRepository;  
            );
        private final Map<Path, TestFileStore> trackedPaths = newConcurrentMap();
        internalCluster().startClusterManagerOnlyNode();  
            0,
import org.junit.Before;
 * Modifications Copyright OpenSearch Contributors. See
        } else {  
            ensureGreen(indexName);
import org.junit.After;
                        )
        Settings clusterFileCacheDisabled = Settings.builder()
            }
     */
            super(delegate, scheme);  
 * Unless required by applicable law or agreed to in writing,
            try {
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, TOTAL_SPACE_BYTES)
        final String dataNodeName = internalCluster().startDataOnlyNode();
    }
        return settingsBuilder.build();
        }, 30L, TimeUnit.SECONDS);  
        assertBusy(() -> {
    ) {
import org.opensearch.cluster.routing.ShardRouting;
                assertFalse(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK));  
        }
            assertAcked(client().admin().cluster().prepareReroute());  
import org.opensearch.cluster.ClusterState;
                .get()
        // even though it's now possible to achieve better balance, so we have to do an explicit reroute. TODO fix this?  
            forceMerge();
        @Override  
    @Override
            client().admin().indices().prepareUpdateSettings(indexName2).setSettings(readOnlySettings).get();
    }  
        }, 30L, TimeUnit.SECONDS);
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS  
            0,
    /**
    /**
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));  
        // User applies index create block.  
import java.util.ArrayList;
 * the Apache License, Version 2.0 (the "License"); you may
        }  
    }
    private long createReasonableSizedShards(final String indexName) throws InterruptedException {
        void addTrackedPath(Path path) {
        ensureStableCluster(3);
            }
        final RestoreSnapshotResponse restoreSnapshotResponse = client().admin()  
            } catch (IOException e) {
        createTestIndices(nodeNames);  
            0,  
                .get()  
    }
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));  
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(100, ByteSizeUnit.KB).getBytes();
        ensureStableCluster(3);
            return rootDir;
    }
        clusterInfoService.setAggregateFileCacheStats(setAggregateFileCacheStats(active, used, totalCacheSize));
            client().admin()  
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();  
            }
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> clusterInfoService.refresh());  
            for (int i = 0; i < indexRequestBuilders.length; i++) {
        long used,
            0,
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
                .setStore(true)  
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).get().getState();
    }
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;  
            // refresh the cluster-manager's ClusterInfoService before checking the assigned shards because DiskThresholdMonitor might still  
            0,
            for (ShardStats shardStats : shardStatses) {
        List<String> indexList = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
        if (isWarmIndex && !nodeNames.isEmpty()) {
     */  
                return super.getUsableSpace();
import org.opensearch.snapshots.RestoreInfo;
        List<String> indexList = createTestIndices(nodeNames);
        ensureStableCluster(3);
                .clear()
                .prepareHealth()  
    }
            0,
        super(nodeSettings);
import org.opensearch.common.Priority;
        return Settings.builder()  
        @Override
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
import org.opensearch.index.IndexSettings;  
    }  
            }
                    return Files.size(path);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
        );
import java.util.HashSet;
        List<String> indexList = createTestIndices(nodeNames);
}
import org.opensearch.monitor.fs.FsInfo;
    private FileSystem defaultFileSystem;  
    }  
            }
            .setWaitForCompletion(true)  
        ((InternalClusterInfoService) clusterInfoService).refresh();
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
import static org.hamcrest.Matchers.empty;  
        if (nodeName != null) {
        );
     * This test is excluded from parameterization and runs only once  
            indexRandom(true, indexRequestBuilders);
        );  
        ensureStableCluster(2);  
    private void refreshDiskUsage() {
        );  
        ensureStableCluster(2);
        final InternalClusterInfoService clusterInfoService = (InternalClusterInfoService) internalCluster()  
        client().admin().indices().prepareUpdateSettings(indexList.toArray(Strings.EMPTY_ARRAY)).setSettings(readBlockSettings);  
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
            .getState()  
            0,
        getMockInternalClusterInfoService().refresh();
                        total += getTotalFileSize(subpath);
            // Create warm indices on specific nodes  
    private static class TestFileStore extends FilterFileStore {
 * KIND, either express or implied.  See the License for the
package org.opensearch.cluster.routing.allocation.decider;
import org.opensearch.core.common.unit.ByteSizeUnit;
        // Reduce disk space of all node.
import org.opensearch.action.index.IndexRequestBuilder;  
            0,  
        assertBusy(() -> {
        var nodeNames = startTestNodes(2, nodeSettings);
            }  
            for (String index : indexList) {
        final Settings nodeSettings = buildTestSettings(false, false);
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
            client().admin()
        Path getRootDir() {
                .setWaitForEvents(Priority.LANGUID)
import java.util.Collection;  
            0,  
 *
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK));  
    protected Settings nodeSettings(int nodeOrdinal) {
        final Settings.Builder indexSettingBuilder = Settings.builder()  
            return internalCluster().startDataOnlyNodes(nodeCount, additionalSettings);
                    .indices()
    }  
    }
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();  
import java.nio.file.NoSuchFileException;
            totalCacheSize,  
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 100L, 100L, 100L);  
import org.opensearch.core.common.unit.ByteSizeValue;
        fileSystemProvider.getTestFileStore(dataNode0Path).setTotalSpace(minShardSize + WATERMARK_BYTES - 1L);  
        }, 30L, TimeUnit.SECONDS);
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Rebalance;  
                path = path.getParent().getParent();
import java.util.stream.Stream;
        // data node (subtract the translog size since the disk threshold decider ignores this and may therefore move  
    private Settings buildTestSettings(boolean diskThresholdEnabled, Boolean autoRelease) {  
    }  
                .setWaitForNoInitializingShards(true)  
        ensureStableCluster(2);  
     */
    @Before
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);  
            final Settings readOnlySettings = Settings.builder()
    }  
    }
            final IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[scaledRandomIntBetween(100, 10000)];  
        }, 30L, TimeUnit.SECONDS);
    protected static final String BASE_REMOTE_REPO = "test-rs-repo";
            if (totalSpace == -1) {  
            if (totalSpace == -1) {  
            // Apply a read_only_allow_delete_block on the indices  
            // be processing a previous ClusterInfo update and will skip the new one (see DiskThresholdMonitor#onNewInfo(ClusterInfo)
        simulateDiskPressure(getMockInternalClusterInfoService());
    public void installFilesystemProvider() {
        FileCacheStats fullStats = new FileCacheStats(
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_THRESHOLD_ENABLED_SETTING.getKey(), Boolean.FALSE.toString())  
        TestFileStore(FileStore delegate, String scheme, Path path) {
        defaultFileSystem = PathUtils.getDefaultFileSystem();
        return Arrays.asList(
        final CreateSnapshotResponse createSnapshotResponse = client().admin()  
            .cluster()
                return super.getTotalSpace();
                .cluster()
        assertThat(restoreInfo.failedShards(), is(0));
            .cluster()
 * under the License.  
        if (isWarmIndex) {  
        final Set<ShardRouting> shardRoutings = new HashSet<>();
        assertNull(fileSystemProvider);
 * You may obtain a copy of the License at  
            0,
                .setTranslog(true)
        FileCacheStats blockStats = new FileCacheStats(
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
import org.opensearch.common.io.PathUtilsForTesting;
        var nodeNames = startTestNodes(2, nodeSettings);
                .setTransientSettings(  
        Settings nodeSettings = buildTestSettings(false, null);
                .isTimedOut()
    private List<String> startTestNodes(int nodeCount, Settings additionalSettings) {
    @Override
        // the node from high watermark breached list.  
        // Validate index create block is removed on the cluster
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 1000L, 1000L, 1000L);  
            }
        var nodeNames = startTestNodes(1, nodeSettings);  
        // Validate index create block is applied on the cluster
        assertBusy(() -> {
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }  
            .index(indexName)) {
        Settings removeBlockSetting = Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), "false").build();
import static org.hamcrest.Matchers.greaterThan;
        }
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();  
        }
            final Settings readOnlySettings = Settings.builder()
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).get().getState();  
        }
            assertFalse(state1.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).get().getState();
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
                try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        assertBusyWithDiskUsageRefresh(dataNode0Id, indexName, hasSize(1));
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        private final Path path;
            AggregateFileCacheStats.FileCacheStatsType.FULL_FILE_STATS
     * Index documents until all the shards are at least WATERMARK_BYTES in size, and return the size of the smallest shard.
            return internalCluster().startDataAndWarmNodes(nodeCount, nodeSettings);
        PathUtilsForTesting.installMock(defaultFileSystem); // set the default filesystem back
        refreshDiskUsage();
        }, 30L, TimeUnit.SECONDS);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * this file be licensed under the Apache-2.0 license or a
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);  
        }
            for (String index : indexList) {
import org.opensearch.cluster.routing.ShardRoutingState;  
        MockInternalClusterInfoService clusterInfoService,  
                .cluster()
            .prepareRestoreSnapshot("repo", "snap")
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
        assertNotNull(defaultFileSystem);
            this.path = path;
        // and whether reallocation is disabled on that index or not.
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);  
            this.rootDir = new FilterPath(rootDir, fileSystem);
            totalCacheSize,
        }, 30L, TimeUnit.SECONDS);
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        clusterInfoService.setDiskUsageFunctionAndRefresh(  
        // For hot indices, no pre-creation needed as disk usage simulation handles it
                return super.getUnallocatedSpace();
            .setWaitForCompletion(true)  
                indexList.add(index);
     * Helper method to create test indices for both hot and warm scenarios  
        var nodeNames = startTestNodes(2, nodeSettings);
            } else if (path.getFileName().toString().equals("_state") || path.getFileName().toString().equals("translog")) {
            0,
                try {
            }
 * GitHub history for details.
    }  
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
    private Settings warmNodeSettings(ByteSizeValue cacheSize) {
            final long totalSpace = this.totalSpace;  
        }
        var pluginList = List.of(  
        var nodeNames = startTestNodes(1, nodeSettings);
 * this work for additional information regarding copyright
import org.opensearch.node.Node;  
import org.opensearch.test.InternalSettingsPlugin;
        public long getUsableSpace() throws IOException {
            }
        ensureStableCluster(3);  
        assertFalse(  
        ensureStableCluster(3);
        // the shard back again).
        }  
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
            indexSettingBuilder.put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(INDEX_ROUTING_ALLOCATION_NODE_SETTING, nodeName);  
import org.opensearch.cluster.ClusterInfoService;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
    private void createIndex(String indexName, String nodeName, boolean isWarmIndex) throws Exception {
            0,  
        @Override
                assertFalse(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
            Files.createDirectories(dataPath);
        final ClusterInfoService clusterInfoService = internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);  
    public void testIndexCreateBlockWithAReadOnlyBlock() throws Exception {
        final InternalClusterInfoService clusterInfoService = (InternalClusterInfoService) internalCluster()
                return totalSpace;  
            final long totalSpace = this.totalSpace;
        );
            } else {
                } catch (NotDirectoryException | NoSuchFileException | FileNotFoundException e) {
     */  
        Settings.Builder settings = Settings.builder().put("location", randomRepoPath()).put("compress", randomBoolean());
    /**  
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
        var nodeNames = startTestNodes(1, nodeSettings);
            createIndex(indexName, indexSettingBuilder.build());
            settingsBuilder.put(DiskThresholdSettings.CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE.getKey(), autoRelease);
 *
import java.nio.file.NotDirectoryException;
                String index = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
import org.opensearch.cluster.routing.allocation.FileCacheThresholdSettings;
                            Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
    public void testRestoreSnapshotAllocationDoesNotExceedWatermark() throws Exception {
        releaseDiskPressure(clusterInfoService);
            for (String nodeName : nodeNames) {
            // not so it can configure the merge scheduler accordingly
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);  
 * not use this file except in compliance with the License.
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            if (path.endsWith(path.getFileSystem().getPath("nodes", "0"))) {
        createTestIndices(nodeNames);
    }  
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
    private Set<ShardRouting> getShardRoutings(final String nodeId, final String indexName) {
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
import org.hamcrest.Matcher;  
        if (autoRelease != null) {
    private static TestFileSystemProvider fileSystemProvider;
                .setTransientSettings(
import org.opensearch.cluster.metadata.Metadata;  
    }
        // reduce disk size of node 0 so that no shards fit below the high watermark, forcing all shards onto the other
        );
            createIndex(indexName, nodeNames.get(0), true);  
        }, 30L, TimeUnit.SECONDS);  
        final String dataNode0Id = internalCluster().getInstance(NodeEnvironment.class, dataNodeName).nodeId();
 */
            }
        final Settings nodeSettings = buildTestSettings(false, false);
        // Validate if cluster block is applied on the cluster  
        private volatile long totalSpace = -1;  
            .build();  
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
    public void testDiskMonitorResetLastRuntimeMilliSecOnlyInFirstCall() throws Exception {
    public void removeFilesystemProvider() {
    }
import static org.hamcrest.Matchers.is;
        Settings readBlockSettings = Settings.builder()  
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageDropsBelowSearchThreshold() throws Exception {
import java.util.stream.StreamSupport;  
        final String dataNode0Id = internalCluster().getInstance(NodeEnvironment.class, dataNodeName).nodeId();  
        // Skip this test when running with parameters to ensure it only runs once  
                // ignore metadata and translog, since the disk threshold decider only cares about the store size
import java.nio.file.FileStore;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), diskThresholdEnabled);
            InternalSettingsPlugin.class,
import org.opensearch.cluster.InternalClusterInfoService;  
 * compatible open source license.
            0,
            .put(super.nodeSettings(0))
        Settings readBlockSettings = Settings.builder().put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString()).build();
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> clusterInfoService.refresh());
        ensureStableCluster(2);
        var nodeNames = startTestNodes(1, nodeSettings);
            // (can happen if the corresponding node has breached flood stage watermark).  
import org.opensearch.common.settings.Settings;
        ensureStableCluster(3);  
        TestFileSystemProvider(FileSystem delegateInstance, Path rootDir) {
        @Override  
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(createBlockSetting).get());
        assertBusy(() -> {
            final Set<Path> containingPaths = trackedPaths.keySet().stream().filter(path::startsWith).collect(Collectors.toSet());  
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();  
                fileStore = super.getFileStore(path);  
            AggregateFileCacheStats.FileCacheStatsType.PINNED_FILE_STATS  
        var nodeNames = startTestNodes(1, nodeSettings);
            .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false);  
        } else {
        );
        }, 30L, TimeUnit.SECONDS);
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), Rebalance.NONE.toString())  
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 90L, 100L, 100L);  
                    long total = 0L;  
        }, 30L, TimeUnit.SECONDS);  
        assertBusyWithDiskUsageRefresh(dataNode0Id, indexName, hasSize(1));
    /**
    }
    }  
                    )  
                .put(additionalSettings)
            }
    private void releaseDiskPressure(MockInternalClusterInfoService clusterInfoService) {
            return getTestFileStore(path);  
    public void testIndexCreateBlockIsRemovedWhenAnyNodesNotExceedHighWatermarkWithAutoReleaseDisabled() throws Exception {
            .clear()  
    /**
 * Licensed to Elasticsearch under one or more contributor  
        ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
            Settings nodeSettings = Settings.builder()
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
        assertThat(restoreInfo.successfulShards(), is(snapshotInfo.totalShards()));  
                .setWaitForNoRelocatingShards(true)
    }  
                return 0L;  
            }
        // Validate if index create block is removed on the cluster. Need to refresh this periodically as well to remove
        if (StreamSupport.stream(clusterInfoService.getClusterInfo().getNodeMostAvailableDiskUsages().values().spliterator(), false)
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));  
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
    public void setup() {  
import java.util.Set;
            .put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString())
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(fileCacheModifiedSettings).get();
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "900b")
            }  
                .put(warmNodeSettings(new ByteSizeValue(TOTAL_SPACE_BYTES)))  
                        new UpdateSettingsRequest(indexName).settings(  
        releaseDiskPressure(clusterInfoService);  
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();  
    }
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
                    return 0L;
import org.opensearch.common.io.PathUtils;  
                    Settings.builder()
import static org.opensearch.index.store.Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING;
                }  
            .build();
            .allMatch(cur -> cur.getFreeBytes() > WATERMARK_BYTES)) {
        // Validate index create block is not removed on the cluster
        long active,
    private static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {
 */  
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                client().admin()  
import org.apache.lucene.tests.mockfile.FilterFileStore;
        }
            .get();
                .getShards();  
        // Reduce disk space of all node until all of them is breaching high disk watermark.
                    shardRoutings.add(shard);  
            active,
            .prepareCreateSnapshot("repo", "snap")
                .indices()  
        for (IndexShardRoutingTable indexShardRoutingTable : client().admin()  
        // Validate if cluster block is applied on the cluster
    public void testDiskMonitorAppliesBlockBackWhenUserRemovesIndexCreateBlock() throws Exception {  
                .prepareUpdateSettings()  
    /**
                .prepareStats(indexName)
        fileSystemProvider.getTestFileStore(dataNode0Path).setTotalSpace(minShardSize + WATERMARK_BYTES + 1L);  
    public void testIndexCreateBlockIsRemovedWhenAnyNodesNotExceedHighWatermarkWithAutoReleaseEnabled() throws Exception {  
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        @Override
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
        }  
        simulateDiskPressure(clusterInfoService);
        fileSystemProvider = null;  
    }
    private void assertBusyWithDiskUsageRefresh(String nodeName, String indexName, Matcher<? super Set<ShardRouting>> matcher)  
            refresh();  
        ensureStableCluster(3);  
        Settings nodeSettings = buildTestSettings(false, null);
        }
    private void simulateDiskPressure(MockInternalClusterInfoService clusterInfoService) {
        if (isWarmIndex) {
            .getCurrentClusterManagerNodeInstance(ClusterInfoService.class);  
            for (String index : indexList) {
        // Validate if cluster block is applied on the cluster
        // Refresh so that DiskThresholdMonitor kicks in and applies block.
            if (totalSpace == -1) {
import java.util.stream.Collectors;
        assertNull(defaultFileSystem);  
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), WATERMARK_BYTES + "b")
        final Settings nodeSettings = buildTestSettings(false, false);  
        FileCacheStats pinnedStats = new FileCacheStats(  
    public void testIndexCreateBlockNotAppliedWhenAnyNodesBelowHighWatermark() throws Exception {  
        while (true) {
    }  
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageExceedsSearchThresholdWithFeatureToggle() throws Exception {  
        // increase disk size of node 0 to allow just enough room for one shard, and check that it's rebalanced back  
        throws Exception {
import org.opensearch.env.Environment;  
     * Helper method to simulate disk pressure for both hot and warm indices  
    }  
        assertBusy(() -> {  
        PathUtilsForTesting.installMock(fileSystemProvider.getFileSystem(null));
        final long minShardSize = createAndPopulateIndex(indexName, null);
import static org.hamcrest.Matchers.anyOf;
        assertBusy(() -> {
    private MockInternalClusterInfoService getMockInternalClusterInfoService() {
            MockFsRepositoryPlugin.class  
        // if the nodes were all under the low watermark already (but unbalanced) then a change in the disk usage doesn't trigger a reroute
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            .put(IndexMetadata.SETTING_BLOCKS_READ, Boolean.TRUE.toString())
                    .get()
        assertBusy(() -> {
            WRITABLE_WARM_INDEX_SETTING.get(settings) == false  
            // Apply a read_only_allow_delete_block on one of the index
            0,
        }
 * The OpenSearch Contributors require contributions made to  
                createIndex(index, nodeName, true);  
                .cluster()
        simulateDiskPressure(clusterInfoService);  
        }  
        ensureStableCluster(2);  
        var nodeNames = startTestNodes(2, nodeSettings);  
            0,
        public FileStore getFileStore(Path path) {
        }
        }, 30L, TimeUnit.SECONDS);  
                    Settings.builder().putNull(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey()).build()
        List<String> indexList = createTestIndices(nodeNames);
    private static AggregateFileCacheStats setAggregateFileCacheStats(long active, long used, long totalCacheSize) {
    }  
            indexSettingBuilder.put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 6);  
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 89L, 100L, 100L);
        }
            assertThat(path + " not contained in a unique tracked path", containingPaths, hasSize(1));
                shardSizes[shardStats.getShardRouting().id()] = shardStats.getStats().getStore().sizeInBytes();  
        assertBusy(() -> {
@ParameterizedStaticSettingsOpenSearchIntegTestCase.ClusterScope(scope = ParameterizedStaticSettingsOpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
                .build();  
    }  
                .get()
            final Set<ShardRouting> shardRoutings = getShardRoutings(nodeName, indexName);
     */
            // Create indices  
        simulateDiskPressure(clusterInfoService);
        }, 30L, TimeUnit.SECONDS);  
        final Settings nodeSettings = buildTestSettings(false, null);
 *  
        Settings createBlockSetting = Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), "true").build();
        // Validate index create block is not removed on the cluster  
import org.opensearch.action.admin.indices.stats.ShardStats;
                )
    @ParametersFactory
        }, 30L, TimeUnit.SECONDS);  
                .prepareUpdateSettings()
            .build();
                .build();
        // Free all the space
    }
        ensureStableCluster(2);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        }
        assertAcked(  
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
                assertFalse(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
            AggregateFileCacheStats.FileCacheStatsType.BLOCK_FILE_STATS
        assertThat(snapshotInfo.successfulShards(), is(snapshotInfo.totalShards()));  
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
import org.opensearch.index.IndexModule;
    protected boolean addMockIndexStorePlugin() {  
        Settings nodeSettings = buildTestSettings(false, null);
        createTestIndices(nodeNames);  
        }
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
        }  
        Settings nodeSettings = buildTestSettings(false, null);  
            assertAcked(
            assertTrue(state1.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
            0,  
                .put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString())
        } catch (IOException e) {  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.plugins.Plugin;
    }
public class DiskThresholdDeciderIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK));
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 1)  
/*
            0,  
                    // probably removed  
        return Settings.builder()
            }  
        clusterInfoService.setDiskUsageFunctionAndRefresh(  
     * Helper method to start nodes that support both data and warm roles
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
            .getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
        createTestIndices(nodeNames);  
            assertThat("Mismatching shard routings: " + shardRoutings, shardRoutings, matcher);  
    }
        private static long getTotalFileSize(Path path) throws IOException {
        assertBusy(() -> {  
            .prepareState()
            0,
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(readOnlySettings).get();
        final Path dataNode0Path = internalCluster().getInstance(Environment.class, dataNodeName).dataFiles()[0];
        return shardRoutings;
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageExceedsSearchThreshold() throws Exception {  
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
            .build();  
        assertBusy(() -> {
import java.nio.file.Files;  
        var nodeNames = startTestNodes(2, nodeSettings);  
import java.io.FileNotFoundException;
    public void testHighWatermarkNotExceeded() throws Exception {
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        releaseDiskPressure(clusterInfoService);  
        private final Path rootDir;  
        return indexList;
        return Stream.concat(super.nodePlugins().stream(), pluginList.stream()).collect(Collectors.toList());
        assertBusy(() -> {  
                    for (Path subpath : directoryStream) {
    @Before
        Settings.Builder settingsBuilder = Settings.builder()
        assertBusy(() -> {
        fileSystemProvider.getTestFileStore(dataNode0Path).setTotalSpace(minShardSize + WATERMARK_BYTES + 1L);
        public long getUnallocatedSpace() throws IOException {
import java.util.Map;
        }, 30L, TimeUnit.SECONDS);
        }
        Settings fileCacheModifiedSettings = Settings.builder()
        createTestIndices(nodeNames);
    private static final long WATERMARK_BYTES = new ByteSizeValue(10, ByteSizeUnit.KB).getBytes();  
        final Settings nodeSettings = buildTestSettings(false, false);  
            assertFalse(state1.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        assertBusy(() -> {  
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 100L, 100L, 100L);
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(removeBlockSetting).get());
        fileSystemProvider.addTrackedPath(dataPath);  
            }
                assertThat(shard.state(), equalTo(ShardRoutingState.STARTED));
     */
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();  
    }  
            assertTrue(path + " starts with " + rootDir, path.startsWith(rootDir));  
        createIndex(indexName, nodeName, false);  
                    return total;
        List<String> indexList = createTestIndices(nodeNames);
        return createReasonableSizedShards(indexName);
            .put(super.nodeSettings(nodeOrdinal))
            createAndPopulateIndex(indexName, nodeNames.get(0));  
                .get()  
import static org.hamcrest.Matchers.equalTo;
            refreshDiskUsage();  
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        defaultFileSystem = null;  
    }
        internalCluster().startClusterManagerOnlyNode(nodeSettings);  
                } catch (NoSuchFileException | FileNotFoundException e) {  
        assertBusy(() -> {
            } else {  
            .get()
    }
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
            } else {
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 99L, 100L, 100L);  
            }
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING;
                }
            assertThat(totalSpace, anyOf(is(-1L), greaterThan(0L)));
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
            // Create one of the index.
            .getRoutingTable()
import org.opensearch.cluster.MockInternalClusterInfoService;
import java.nio.file.DirectoryStream;  
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            // On Linux, and only Linux, Lucene obtains a filestore for the index in order to determine whether it's on a spinning disk or  
        assertBusy(() -> {  
 */  
 * ownership. Elasticsearch licenses this file to you under  
            assertNull(trackedPaths.put(path, new TestFileStore(fileStore, getScheme(), path)));
        internalCluster().startClusterManagerOnlyNode(nodeSettings);  
            0,
        if (isWarmIndex) {
                return fileStore;  
            0,  
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> clusterInfoService.refresh());
            final TestFileStore fileStore = trackedPaths.get(path);
        public long getTotalSpace() throws IOException {
            if (minShardSize > WATERMARK_BYTES) {
        Settings nodeSettings = buildTestSettings(false, null);
import java.io.IOException;
        // User removes index create block.
            .build();
        );
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            }  
    private static final String INDEX_ROUTING_ALLOCATION_NODE_SETTING = "index.routing.allocation.include._name";
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(clusterFileCacheDisabled).get();
     */
        try {
            .cluster()
            for (String index : indexList) {  
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
import org.opensearch.snapshots.SnapshotState;  
        Settings removeBlockSetting = Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), false).build();
import org.opensearch.core.common.Strings;  
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
    }  
        fileSystemProvider = new TestFileSystemProvider(defaultFileSystem, createTempDir());  
            for (String index : indexList) {
                    // probably removed
    /**
            indexSettingBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);  
        final SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
        }, 30L, TimeUnit.SECONDS);
        assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));  
    }
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();  
        }
            .get();
            }  
        // Validate cluster block is not applied on the cluster
                )
            if (Files.isRegularFile(path)) {  
            createIndex(indexName2, nodeNames.get(1), true);
        Settings nodeSettings = buildTestSettings(false, null);
     */
        }, 30L, TimeUnit.SECONDS);
        // Free all the space
                .put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString())
        } else {  
            "Test should only run in the default (non-parameterized) test suite",
            .put(Environment.PATH_DATA_SETTING.getKey(), dataPath)  
    }  
            0,
        ensureStableCluster(3);
        }, 30L, TimeUnit.SECONDS);  
import org.opensearch.snapshots.SnapshotInfo;
            0,
 *     http://www.apache.org/licenses/LICENSE-2.0
    @After
    }
    private long createAndPopulateIndex(final String indexName, final String nodeName) throws Exception {
    }
import java.util.Locale;  
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        internalCluster().startDataOnlyNode();  
        final long minShardSize = createAndPopulateIndex(indexName, null);  
        List<String> indexList = createTestIndices(nodeNames);
            final FileStore fileStore;
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));  
import static org.hamcrest.Matchers.hasSize;  
/*  
        if (isWarmIndex) {  
import org.apache.lucene.util.Constants;
        fileSystemProvider.getTestFileStore(dataNode0Path).setTotalSpace(minShardSize + WATERMARK_BYTES - 1L);
        assertBusy(() -> assertThat(getShardRoutings(dataNode0Id, indexName), empty()));  
        assertAcked(client().admin().indices().prepareDelete(indexName).get());  
                return Math.max(0L, totalSpace - getTotalFileSize(path));  
        simulateDiskPressure(clusterInfoService);  
        assertAcked(
            final long minShardSize = Arrays.stream(shardSizes).min().orElseThrow(() -> new AssertionError("no shards"));  
        List<String> indexList = createTestIndices(nodeNames);  
    public DiskThresholdDeciderIT(Settings nodeSettings) {
            used,  
import java.util.Arrays;
            getMockInternalClusterInfoService().refresh();
        // increase disk size of node 0 to allow just enough room for one shard, and check that it's rebalanced back
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(readOnlySettings).get();
                if (shard.currentNodeId().equals(nodeId)) {
        }, 30L, TimeUnit.SECONDS);  
            } else {
    @Override
        assertBusy(() -> {
        // Depending on node name specified or not, we determine whether to enable node name based shard routing for index  
        }
        Settings nodeSettings = buildTestSettings(false, null);  
        );
            return trackedPaths.get(containingPaths.iterator().next());
            this.totalSpace = totalSpace;  
            0,  
        startTestNodes(2, nodeSettings);  
import java.nio.file.FileSystem;
            final ShardStats[] shardStatses = client().admin()
                .build();  
        Settings nodeSettings = buildTestSettings(false, null);
            super("diskthreshold://", delegateInstance);  
        final InternalClusterInfoService clusterInfoService = (InternalClusterInfoService) internalCluster()
        internalCluster().startDataOnlyNode();
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
        client().admin().indices().prepareUpdateSettings(indexList.toArray(Strings.EMPTY_ARRAY)).setSettings(readBlockSettings);
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        // User removes the block.  
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
                    return 0L;
            // and its internal checkInProgress flag)
            final String indexName2 = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
            final long totalSpace = this.totalSpace;
            if (fileStore != null) {
     * Helper method to simulate disk pressure for both hot and warm indices  
            throw new AssertionError("unexpected", e);
import org.apache.lucene.tests.mockfile.FilterPath;  
        }
    }
import java.nio.file.Path;  
        }  
    private List<String> createTestIndices(List<String> nodeNames) throws Exception {
            client().admin()
        internalCluster().startClusterManagerOnlyNode();
import java.util.List;
 * software distributed under the License is distributed on an
            settingsBuilder.put(remoteStoreClusterSettings(BASE_REMOTE_REPO, remoteRepoPath));
/*  
import org.opensearch.env.NodeEnvironment;
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        );
