            client().admin().indices().prepareUpdateSettings(indexName2).setSettings(readOnlySettings).get();
        if (nodeName != null) {
    private void releaseDiskPressure(MockInternalClusterInfoService clusterInfoService) {
            assertThat("Mismatching shard routings: " + shardRoutings, shardRoutings, matcher);
 * KIND, either express or implied.  See the License for the
            MockInternalClusterInfoService.TestPlugin.class,
 * license agreements. See the NOTICE file distributed with
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
 * under the License.
                return Math.max(0L, totalSpace - getTotalFileSize(path));
                    return 0L;
        } else {
import java.nio.file.FileSystem;
        // the node from high watermark breached list.
            );
        } catch (IOException e) {
    }
            }
    }
                    // probably removed
        return WRITABLE_WARM_INDEX_SETTING.get(settings) == false;
        @Override
import org.opensearch.index.store.remote.filecache.FileCacheStats;
import org.apache.lucene.util.Constants;
import static org.opensearch.common.util.FeatureFlags.WRITABLE_WARM_INDEX_SETTING;
        // increase disk size of node 0 to allow just enough room for one shard, and check that it's rebalanced back
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
    protected boolean addMockIndexStorePlugin() {
     */
import org.opensearch.common.settings.Settings;
                // ignore metadata and translog, since the disk threshold decider only cares about the store size
            createIndex(indexName, indexSettingBuilder.build());
        Settings nodeSettings = buildTestSettings(false, null);
            client().admin()
            ensureGreen(indexName);
 *
import org.opensearch.plugins.Plugin;
            }
        public long getUsableSpace() throws IOException {
        var nodeNames = startTestNodes(1, nodeSettings);
            0,
        // even though it's now possible to achieve better balance, so we have to do an explicit reroute. TODO fix this?
        private static long getTotalFileSize(Path path) throws IOException {
import java.util.concurrent.TimeUnit;
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
            this.totalSpace = totalSpace;
    }
            }
    /**
            if (minShardSize > WATERMARK_BYTES) {
        // User removes index create block.
        createTestIndices(nodeNames);
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).get().getState();
                    Settings.builder().putNull(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey()).build()
        }
            .put(INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING.getKey(), "0ms")
        long used,
            AggregateFileCacheStats.FileCacheStatsType.FULL_FILE_STATS
            .put(Node.NODE_SEARCH_CACHE_SIZE_SETTING.getKey(), cacheSize.toString())
            if (totalSpace == -1) {
        fileSystemProvider = null;
        }, 30L, TimeUnit.SECONDS);
import static org.hamcrest.Matchers.hasSize;
    public void testRestoreSnapshotAllocationDoesNotExceedWatermark() throws Exception {
            0,
        clusterInfoService.setAggregateFileCacheStats(setAggregateFileCacheStats(active, used, totalCacheSize));
            final long totalSpace = this.totalSpace;
        }, 30L, TimeUnit.SECONDS);
        assertBusy(() -> assertThat(getShardRoutings(dataNode0Id, indexName), empty()));
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        assertBusy(() -> {
        final String dataNodeName = internalCluster().startDataOnlyNode();
                if (shard.currentNodeId().equals(nodeId)) {
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        TestFileStore(FileStore delegate, String scheme, Path path) {
import org.opensearch.snapshots.RestoreInfo;
        );
            }
    /**
import org.opensearch.env.Environment;
            .put(IndexMetadata.SETTING_BLOCKS_READ, Boolean.TRUE.toString())
        Settings removeBlockSetting = Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), false).build();
import java.nio.file.Path;
    private long createReasonableSizedShards(final String indexName) throws InterruptedException {
    private long createAndPopulateIndex(final String indexName, final String nodeName) throws Exception {
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
    public void removeFilesystemProvider() {
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
    }
        PathUtilsForTesting.installMock(defaultFileSystem); // set the default filesystem back
            assertTrue(state1.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
    @Override
            // not so it can configure the merge scheduler accordingly
                        .build()
        );
        internalCluster().startClusterManagerOnlyNode();
        final Settings nodeSettings = buildTestSettings(false, false);
            }
                .getShards();
            assertAcked(
        var nodeNames = startTestNodes(1, nodeSettings);
        }
        @Override
        );
    }
        var nodeNames = startTestNodes(2, nodeSettings);
        assertBusy(() -> {
            }
        // Validate index create block is not removed on the cluster
        internalCluster().startClusterManagerOnlyNode();
        final InternalClusterInfoService clusterInfoService = (InternalClusterInfoService) internalCluster()
                    }
    }
                        .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), Rebalance.NONE.toString())
        }, 30L, TimeUnit.SECONDS);
                }
import java.io.FileNotFoundException;
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
package org.opensearch.cluster.routing.allocation.decider;
                .prepareUpdateSettings()
            } catch (IOException e) {
            }
                .setTransientSettings(
import org.opensearch.core.common.unit.ByteSizeUnit;
            totalCacheSize,
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
    private static class TestFileStore extends FilterFileStore {
        Path getRootDir() {
                .indices()
import org.opensearch.cluster.ClusterState;
        var nodeNames = startTestNodes(2, nodeSettings);
    }
            final Settings readOnlySettings = Settings.builder()
    /**
        return new FsInfo.Path(original.getPath(), original.getMount(), totalBytes, freeBytes, freeBytes);
import org.opensearch.snapshots.SnapshotState;
        }, 30L, TimeUnit.SECONDS);
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(fileCacheModifiedSettings).get();
            }
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_THRESHOLD_ENABLED_SETTING.getKey(), Boolean.FALSE.toString())
        client().admin().indices().prepareUpdateSettings(indexList.toArray(Strings.EMPTY_ARRAY)).setSettings(readBlockSettings);
            .getRoutingTable()
            }
            return trackedPaths.get(containingPaths.iterator().next());
            }
        ensureStableCluster(3);
        assertBusy(() -> {
        return Stream.concat(super.nodePlugins().stream(), pluginList.stream()).collect(Collectors.toList());
        final long minShardSize = createAndPopulateIndex(indexName, null);
        assertBusy(() -> {
        assertNull(fileSystemProvider);
import java.util.HashSet;
        ((InternalClusterInfoService) clusterInfoService).refresh();
    private static final long WATERMARK_BYTES = new ByteSizeValue(10, ByteSizeUnit.KB).getBytes();
    @After
     */
        } else {
    }
        Settings nodeSettings = buildTestSettings(false, null);
    }
        assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
    public DiskThresholdDeciderIT(Settings nodeSettings) {
 * Unless required by applicable law or agreed to in writing,
            // Apply a read_only_allow_delete_block on one of the index
        }
            .cluster()
            for (ShardRouting shard : indexShardRoutingTable.shards()) {
            }
 * Modifications Copyright OpenSearch Contributors. See
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).get().getState();
        if (isWarmIndex && !nodeNames.isEmpty()) {
        }, 30L, TimeUnit.SECONDS);
        Settings readBlockSettings = Settings.builder()
@ParameterizedStaticSettingsOpenSearchIntegTestCase.ClusterScope(scope = ParameterizedStaticSettingsOpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
import org.opensearch.action.admin.indices.stats.ShardStats;
        if (isWarmIndex) {
    }
        var nodeNames = startTestNodes(2, nodeSettings);
        simulateDiskPressure(getMockInternalClusterInfoService());
            createIndex(indexName, indexSettingBuilder.build());
            for (String nodeName : nodeNames) {
        Settings fileCacheModifiedSettings = Settings.builder()
    }
        final ClusterInfoService clusterInfoService = internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
        assertBusy(() -> {
import java.nio.file.NotDirectoryException;
                createIndex(index, nodeName, true);
/*
            0,
}
        final RestoreInfo restoreInfo = restoreSnapshotResponse.getRestoreInfo();
            .get();
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
            assertNull(trackedPaths.put(path, new TestFileStore(fileStore, getScheme(), path)));
    private Settings buildTestSettings(boolean diskThresholdEnabled, Boolean autoRelease) {
        // For hot indices, no pre-creation needed as disk usage simulation handles it
            "Test should only run in the default (non-parameterized) test suite",
 *
            AggregateFileCacheStats.FileCacheStatsType.OVER_ALL_STATS
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageExceedsSearchThresholdWithFeatureToggle() throws Exception {
            0,
            if (path.endsWith(path.getFileSystem().getPath("nodes", "0"))) {
                throw new AssertionError("unexpected", e);
                .setStore(true)
                client().admin()
        var nodeNames = startTestNodes(2, nodeSettings);
            } else {
            assertTrue(path + " not tracked and not on Linux", Constants.LINUX);
            if (Files.isRegularFile(path)) {
        assertBusy(() -> {
            .getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
            0,
    }
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
            // Create indices
            0,
    }
                assertFalse(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
        Settings nodeSettings = buildTestSettings(false, null);
import org.junit.After;
        try {
            .cluster()
            throw new AssertionError("unexpected", e);
import java.util.List;
            indexSettingBuilder.put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true);
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.snapshots.SnapshotInfo;
import java.nio.file.DirectoryStream;
        assertThat(restoreInfo.successfulShards(), is(snapshotInfo.totalShards()));
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK));
            super(delegate, scheme);
        List<String> indexList = createTestIndices(nodeNames);
        // reduce disk size of node 0 so that no shards fit below the high watermark, forcing all shards onto the other
            settingsBuilder.put(remoteStoreClusterSettings(BASE_REMOTE_REPO, remoteRepoPath));
    private static final long TOTAL_SPACE_BYTES = new ByteSizeValue(100, ByteSizeUnit.KB).getBytes();
        long totalCacheSize
            final String indexName2 = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        Settings createBlockSetting = Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), "true").build();
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), true).build() }
    ) {
                path = path.getParent().getParent();
    public void installFilesystemProvider() {
        assertNotNull(defaultFileSystem);
            .put(IndexSettings.INDEX_MERGE_ON_FLUSH_ENABLED.getKey(), false);
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
        TestFileStore getTestFileStore(Path path) {
 * not use this file except in compliance with the License.
        }
                return totalSpace;
            .cluster()
        // Validate if index create block is removed on the cluster. Need to refresh this periodically as well to remove
    /**
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
import static org.opensearch.index.store.Store.INDEX_STORE_STATS_REFRESH_INTERVAL_SETTING;
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(createBlockSetting).get());
        ensureStableCluster(2);
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        fileSystemProvider.getTestFileStore(dataNode0Path).setTotalSpace(minShardSize + WATERMARK_BYTES - 1L);
                            Settings.builder().put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        simulateDiskPressure(clusterInfoService);
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
        public long getUnallocatedSpace() throws IOException {
     * Index documents until all the shards are at least WATERMARK_BYTES in size, and return the size of the smallest shard.
            0,
        // Reduce disk space of all node.
import org.opensearch.monitor.fs.FsInfo;
        Settings clusterFileCacheDisabled = Settings.builder()
            createAndPopulateIndex(indexName, nodeNames.get(0));
        defaultFileSystem = PathUtils.getDefaultFileSystem();
            for (String index : indexList) {
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 1)
                .setWaitForEvents(Priority.LANGUID)
import org.opensearch.env.NodeEnvironment;
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
                .put(warmNodeSettings(new ByteSizeValue(TOTAL_SPACE_BYTES)))
            return getTestFileStore(path);
        FileCacheStats fullStats = new FileCacheStats(
        var nodeNames = startTestNodes(1, nodeSettings);
        // Refresh so that DiskThresholdMonitor kicks in and applies block.
import org.opensearch.action.admin.indices.settings.put.UpdateSettingsRequest;
                        )
            final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
    }
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
    @ParametersFactory
        );
        assertNull(defaultFileSystem);
        PathUtilsForTesting.installMock(fileSystemProvider.getFileSystem(null));
                try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).get().getState();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), diskThresholdEnabled);
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
        // Validate if cluster block is applied on the cluster
                .get()
public class DiskThresholdDeciderIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
        private final Map<Path, TestFileStore> trackedPaths = newConcurrentMap();
            }
    }
            0,
            0,
            client().admin()
                indexRequestBuilders[i] = client().prepareIndex(indexName).setSource("field", randomAlphaOfLength(10));
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        clusterInfoService.setDiskUsageFunctionAndRefresh(
            .get()
 * Licensed to Elasticsearch under one or more contributor
        }
            // refresh the cluster-manager's ClusterInfoService before checking the assigned shards because DiskThresholdMonitor might still
                assertFalse(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK));
     * Helper method to build test-specific settings with support for both hot and warm indices
    }
            .build();
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_SEARCH_THRESHOLD_SETTING.getKey(), "1000b")
            0,
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
     */
        createTestIndices(nodeNames);
            } else {
import java.util.Arrays;
    private static final String INDEX_ROUTING_ALLOCATION_NODE_SETTING = "index.routing.allocation.include._name";
                indexList.add(index);
import org.opensearch.monitor.fs.FsService;
        return (MockInternalClusterInfoService) internalCluster().getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
            .build();
        internalCluster().startDataOnlyNode();
import org.opensearch.cluster.MockInternalClusterInfoService;
            .put(FsService.ALWAYS_REFRESH_SETTING.getKey(), true)
                .isTimedOut()
        Settings removeBlockSetting = Settings.builder().put(Metadata.SETTING_CREATE_INDEX_BLOCK_SETTING.getKey(), "false").build();
    @Override
                .build();
                String index = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
import org.opensearch.action.admin.cluster.snapshots.restore.RestoreSnapshotResponse;
        }, 30L, TimeUnit.SECONDS);
        var nodeNames = startTestNodes(1, nodeSettings);
        // increase disk size of node 0 to allow just enough room for one shard, and check that it's rebalanced back
                .cluster()
        assertBusy(() -> {
            active,
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 89L, 100L, 100L);
        }
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
            0,
        }
            return internalCluster().startDataOnlyNodes(nodeCount, additionalSettings);
                )
        ensureStableCluster(3);
        final RestoreSnapshotResponse restoreSnapshotResponse = client().admin()
    }
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
            // Create one of the index.
            .put(Environment.PATH_DATA_SETTING.getKey(), dataPath)
        ensureStableCluster(2);
        client().admin().indices().prepareUpdateSettings(indexList.toArray(Strings.EMPTY_ARRAY)).setSettings(readBlockSettings);
        startTestNodes(2, nodeSettings);
        @Override
        } else {
        throws Exception {
        void addTrackedPath(Path path) {
    /**
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
        public long getTotalSpace() throws IOException {
        List<String> indexList = createTestIndices(nodeNames);
        }, 30L, TimeUnit.SECONDS);
            .getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
            final long totalSpace = this.totalSpace;
        var pluginList = List.of(
        Settings nodeSettings = buildTestSettings(false, null);
/*
                .put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString())
        // User removes the block.
        assertBusy(() -> {
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
    public void testDiskMonitorAppliesBlockBackWhenUserRemovesIndexCreateBlock() throws Exception {
    private Set<ShardRouting> getShardRoutings(final String nodeId, final String indexName) {
import java.nio.file.FileStore;
import org.opensearch.repositories.fs.FsRepository;
                        new UpdateSettingsRequest(indexName).settings(
import org.opensearch.index.IndexSettings;
    public void setup() {
        refreshDiskUsage();
    }
            // Create warm indices on specific nodes
import org.opensearch.test.InternalSettingsPlugin;
    /**
     * This test is excluded from parameterization and runs only once
            InternalSettingsPlugin.class,
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK));
    }
                .put(additionalSettings)
        FileCacheStats overallStats = new FileCacheStats(
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(removeBlockSetting).get());
        final Path dataNode0Path = internalCluster().getInstance(Environment.class, dataNodeName).dataFiles()[0];
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING;
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            for (String index : indexList) {
            totalCacheSize,
        final long minShardSize = createAndPopulateIndex(indexName, null);
            .clear()
                    .indices()
        super(nodeSettings);
            assertFalse(state1.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        return Settings.builder()
        if (isWarmIndex) {
 * SPDX-License-Identifier: Apache-2.0
    }
import org.opensearch.cluster.routing.ShardRouting;
            .setWaitForCompletion(true)
            }
    /**
    }
import org.apache.lucene.tests.mockfile.FilterPath;
        }, 30L, TimeUnit.SECONDS);
            Settings nodeSettings = Settings.builder()
        }
            0,
    private void assertBusyWithDiskUsageRefresh(String nodeName, String indexName, Matcher<? super Set<ShardRouting>> matcher)
import org.opensearch.cluster.routing.allocation.FileCacheThresholdSettings;
                assertFalse(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 1000L, 1000L, 1000L);
    }
        Settings nodeSettings = buildTestSettings(false, null);
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * compatible open source license.
        return shardRoutings;
            final ShardStats[] shardStatses = client().admin()
        // Reduce disk space of all node until all of them is breaching high disk watermark.
        @Override
     * Helper method to simulate disk pressure for both hot and warm indices
    }
        public FileStore getFileStore(Path path) {
        assertBusy(() -> {
        // if the nodes were all under the low watermark already (but unbalanced) then a change in the disk usage doesn't trigger a reroute
        }
import org.opensearch.node.Node;
            } else {
    }
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
    }
        // Validate cluster block is not applied on the cluster
    }
        // reduce disk size of node 0 so that no shards fit below the low watermark, forcing shards to be assigned to the other data node
    }
            for (String index : indexList) {
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
                .cluster()
                )
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        simulateDiskPressure(clusterInfoService);
            0,
            if (totalSpace == -1) {
import org.opensearch.action.index.IndexRequestBuilder;
        final MockInternalClusterInfoService clusterInfoService = getMockInternalClusterInfoService();
            .prepareState()
 * this work for additional information regarding copyright
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageDropsBelowIndexThreshold() throws Exception {
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageDropsBelowSearchThreshold() throws Exception {
        createTestIndices(nodeNames);
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(readOnlySettings).get();
                .clear()
import java.util.stream.Stream;
        if (StreamSupport.stream(clusterInfoService.getClusterInfo().getNodeMostAvailableDiskUsages().values().spliterator(), false)
        long active,
 *     http://www.apache.org/licenses/LICENSE-2.0
        ensureStableCluster(3);
        final String indexName = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
    }
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        }, 30L, TimeUnit.SECONDS);
import org.opensearch.cluster.metadata.Metadata;
                try {
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        List<String> indexList = createTestIndices(nodeNames);
    public void testIndexCreateBlockIsRemovedWhenAnyNodesNotExceedHighWatermarkWithAutoReleaseDisabled() throws Exception {
        // Validate if cluster block is applied on the cluster
            }
            if (fileStore != null) {
import org.opensearch.cluster.InternalClusterInfoService;
        fileSystemProvider.getTestFileStore(dataNode0Path).setTotalSpace(minShardSize + WATERMARK_BYTES + 1L);
import org.opensearch.cluster.ClusterInfoService;
            } else {
            .getState()
        final SnapshotInfo snapshotInfo = createSnapshotResponse.getSnapshotInfo();
        return new AggregateFileCacheStats(System.currentTimeMillis(), overallStats, fullStats, blockStats, pinnedStats);
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, WATERMARK_BYTES - 1)
                .get()
 * the Apache License, Version 2.0 (the "License"); you may
            final long[] shardSizes = new long[shardStatses.length];
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
                    // probably removed
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING.getKey(), "0ms")
            // Apply a read_only_allow_delete_block on the indices
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
            settingsBuilder.put(DiskThresholdSettings.CLUSTER_CREATE_INDEX_BLOCK_AUTO_RELEASE.getKey(), autoRelease);
            }
        final InternalClusterInfoService clusterInfoService = (InternalClusterInfoService) internalCluster()
                fileStore = super.getFileStore(path);
        @Override
        Settings nodeSettings = buildTestSettings(false, null);
                return fileStore;
    }
            forceMerge();
            0,
    }
                .prepareUpdateSettings()
        Settings nodeSettings = buildTestSettings(false, null);
        assertBusy(() -> {
                    shardRoutings.add(shard);
    public void testHighWatermarkNotExceeded() throws Exception {
            // (can happen if the corresponding node has breached flood stage watermark).
        );
        // Free all the space
    private FileSystem defaultFileSystem;
import java.util.Set;
            final long minShardSize = Arrays.stream(shardSizes).min().orElseThrow(() -> new AssertionError("no shards"));
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageExceedsSearchThresholdInBytes() throws Exception {
            } else if (path.getFileName().toString().equals("_state") || path.getFileName().toString().equals("translog")) {
    @Before
        FileCacheStats pinnedStats = new FileCacheStats(
        return settingsBuilder.build();
        if (autoRelease != null) {
import static org.opensearch.common.util.concurrent.ConcurrentCollections.newConcurrentMap;
            .put(super.nodeSettings(nodeOrdinal))
        return Arrays.asList(
        createRepository("repo", FsRepository.TYPE, settings);
        assertBusy(() -> {
            final TestFileStore fileStore = trackedPaths.get(path);
    private void refreshDiskUsage() {
        while (true) {
                .setTransientSettings(
        }, 30L, TimeUnit.SECONDS);
        releaseDiskPressure(clusterInfoService);
 * this file be licensed under the Apache-2.0 license or a
            this.path = path;
        }
import static org.hamcrest.Matchers.anyOf;
    protected Settings nodeSettings(int nodeOrdinal) {
            this.rootDir = new FilterPath(rootDir, fileSystem);
        }
        private final Path path;
        }, 30L, TimeUnit.SECONDS);
        fileSystemProvider.addTrackedPath(dataPath);
        ensureStableCluster(3);
        createIndex(indexName, nodeName, false);
        );
        Settings nodeSettings = buildTestSettings(false, null);
    private static FsInfo.Path setDiskUsage(FsInfo.Path original, long totalBytes, long freeBytes) {
        ensureStableCluster(3);
            // On Linux, and only Linux, Lucene obtains a filestore for the index in order to determine whether it's on a spinning disk or
        // Validate index create block is not removed on the cluster
        final String dataNode0Id = internalCluster().getInstance(NodeEnvironment.class, dataNodeName).nodeId();
        fileSystemProvider.getTestFileStore(dataNode0Path).setTotalSpace(minShardSize + WATERMARK_BYTES - 1L);
            for (String index : indexList) {
            final Settings readOnlySettings = Settings.builder()
            0,
        assertBusyWithDiskUsageRefresh(dataNode0Id, indexName, hasSize(1));
        assertBusy(() -> {
            }
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 99L, 100L, 100L);
        assertFalse(
        assertAcked(
                .get()
        assertBusy(() -> {
            new Object[] { Settings.builder().put(WRITABLE_WARM_INDEX_SETTING.getKey(), false).build() },
                .cluster()
        // and whether reallocation is disabled on that index or not.
        // Skip this test when running with parameters to ensure it only runs once
            .put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString())
            }
                    Settings.builder()
                .build();
import java.util.Map;
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
import org.opensearch.common.io.PathUtilsForTesting;
        }
                        total += getTotalFileSize(subpath);
        final Settings nodeSettings = buildTestSettings(false, false);
import org.opensearch.cluster.service.ClusterService;
        createTestIndices(nodeNames);
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
                } catch (NoSuchFileException | FileNotFoundException e) {
            totalCacheSize,
        assertBusy(() -> {
            refresh();
        }
import org.opensearch.core.common.Strings;
        );
        assertAcked(client().admin().indices().prepareDelete(indexName).get());
import org.opensearch.cluster.metadata.IndexMetadata;
                return super.getUnallocatedSpace();
        }
        }
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
 * software distributed under the License is distributed on an
    }
            AggregateFileCacheStats.FileCacheStatsType.BLOCK_FILE_STATS
        ensureStableCluster(2);
    }
            .build();
        List<String> indexList = createTestIndices(nodeNames);
        );
import org.opensearch.remotestore.multipart.mocks.MockFsRepositoryPlugin;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final Path dataPath = fileSystemProvider.getRootDir().resolve("node-" + nodeOrdinal);
/*
        }
            .get();
    }
 * The OpenSearch Contributors require contributions made to
 * ownership. Elasticsearch licenses this file to you under
            assertTrue(path + " starts with " + rootDir, path.startsWith(rootDir));
                }
    }
            client().admin().indices().prepareUpdateSettings(indexName).setSettings(readOnlySettings).get();
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> clusterInfoService.refresh());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        Settings.Builder settings = Settings.builder().put("location", randomRepoPath()).put("compress", randomBoolean());
            Files.createDirectories(dataPath);
    private static TestFileSystemProvider fileSystemProvider;
        final Set<ShardRouting> shardRoutings = new HashSet<>();
            for (ShardStats shardStats : shardStatses) {
import java.nio.file.NoSuchFileException;
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
            0,
        final String dataNodeName = internalCluster().startDataOnlyNode();
import java.util.Collection;
        // the shard back again).
            createIndex(indexName2, nodeNames.get(1), true);
    private void simulateDiskPressure(MockInternalClusterInfoService clusterInfoService) {
            ClusterState state1 = client().admin().cluster().prepareState().setLocal(true).get().getState();
            .put(FileCacheThresholdSettings.CLUSTER_FILECACHE_ACTIVEUSAGE_INDEXING_THRESHOLD_SETTING.getKey(), "900b")
        }
    }
import org.opensearch.index.IndexModule;
        }
        List<String> indexList = createTestIndices(nodeNames);
        List<String> indexList = createTestIndices(nodeNames);
import static org.hamcrest.Matchers.equalTo;
            client().admin()
                return 0L;
    public void testDiskMonitorResetLastRuntimeMilliSecOnlyInFirstCall() throws Exception {
            // and its internal checkInProgress flag)
        }
        final InternalClusterInfoService clusterInfoService = (InternalClusterInfoService) internalCluster()
                .setWaitForNoRelocatingShards(true)
            .allMatch(cur -> cur.getFreeBytes() > WATERMARK_BYTES)) {
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
            return internalCluster().startDataAndWarmNodes(nodeCount, nodeSettings);
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageExceedsSearchThreshold() throws Exception {
    private void simulateFileCacheActiveUsage(
        fileSystemProvider.getTestFileStore(dataNode0Path).setTotalSpace(minShardSize + WATERMARK_BYTES + 1L);
            for (String index : indexList) {
            createIndex(indexName, nodeNames.get(0), true);
            .prepareCreateSnapshot("repo", "snap")
        // data node (subtract the translog size since the disk threshold decider ignores this and may therefore move
    }
 * GitHub history for details.
        var nodeNames = startTestNodes(2, nodeSettings);
        final String dataNode0Id = internalCluster().getInstance(NodeEnvironment.class, dataNodeName).nodeId();
import org.opensearch.cluster.routing.ShardRoutingState;
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 100L, 100L, 100L);
            .build();
     * Helper method to start nodes that support both data and warm roles
            0,
    protected static final String BASE_REMOTE_REPO = "test-rs-repo";
    private MockInternalClusterInfoService getMockInternalClusterInfoService() {
    }
    public static Collection<Object[]> parameters() {
                .get()
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> clusterInfoService.refresh());
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
                .setWaitForNoInitializingShards(true)
        assertBusy(() -> {
            return "fake"; // Lucene's is-spinning-disk check expects the device name here
            super("diskthreshold://", delegateInstance);
        var nodeNames = startTestNodes(1, nodeSettings);
    public void testIndexCreateBlockWhenAllNodesExceededHighWatermark() throws Exception {
        ensureStableCluster(2);
            0,
import org.opensearch.common.Priority;
            indexRandom(true, indexRequestBuilders);
            try {
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        FileCacheStats blockStats = new FileCacheStats(
        // Validate index create block is removed on the cluster
    public void testIndexCreateBlockNotAppliedWhenAnyNodesBelowHighWatermark() throws Exception {
            0,
import static org.hamcrest.Matchers.greaterThan;
        simulateDiskPressure(clusterInfoService);
        Settings readBlockSettings = Settings.builder().put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString()).build();
 *
            .build();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), WATERMARK_BYTES + "b")
        assertBusyWithDiskUsageRefresh(dataNode0Id, indexName, hasSize(1));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), WATERMARK_BYTES + "b")
        }, 30L, TimeUnit.SECONDS);
        private volatile long totalSpace = -1;
        assumeTrue("Test should only run in the default (non-parameterized) test suite", WRITABLE_WARM_INDEX_SETTING.get(settings) == true);
            0,
    @Before
        );
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
        // Validate if cluster block is applied on the cluster
import org.hamcrest.Matcher;
            indexSettingBuilder.put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(INDEX_ROUTING_ALLOCATION_NODE_SETTING, nodeName);
        internalCluster().startDataOnlyNode();
            MockFsRepositoryPlugin.class
        ensureStableCluster(3);
                return Math.max(0L, totalSpace - getTotalFileSize(path));
            assertAcked(client().admin().cluster().prepareReroute());
        );
        defaultFileSystem = null;
        }
import org.opensearch.common.io.PathUtils;
    /**
        }, 30L, TimeUnit.SECONDS);
            0,
        client().admin().cluster().prepareUpdateSettings().setPersistentSettings(clusterFileCacheDisabled).get();
        if (isWarmIndex) {
            assertFalse(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
                assertThat(shard.state(), equalTo(ShardRoutingState.STARTED));
        }, 30L, TimeUnit.SECONDS);
import org.apache.lucene.tests.mockfile.FilterFileStore;
        var nodeNames = startTestNodes(2, nodeSettings);
                    )
        getMockInternalClusterInfoService().refresh();
        // Free all the space
    private static class TestFileSystemProvider extends FilterFileSystemProvider {
    private List<String> createTestIndices(List<String> nodeNames) throws Exception {
        }
        final Path dataNode0Path = internalCluster().getInstance(Environment.class, dataNodeName).dataFiles()[0];
        Settings.Builder settingsBuilder = Settings.builder()
        ensureStableCluster(3);
        final CreateSnapshotResponse createSnapshotResponse = client().admin()
            for (String index : indexList) {
            .index(indexName)) {
            .prepareRestoreSnapshot("repo", "snap")
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
            AggregateFileCacheStats.FileCacheStatsType.PINNED_FILE_STATS
     */
                    .get()
        fileSystemProvider = new TestFileSystemProvider(defaultFileSystem, createTempDir());
        // Free all the space
        clusterInfoService.setDiskUsageFunctionAndRefresh(
import java.util.stream.Collectors;
            .setWaitForCompletion(true)
        List<String> indexList = new ArrayList<>();
import org.junit.Before;
                    return 0L;
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
        releaseDiskPressure(clusterInfoService);
import static org.hamcrest.Matchers.empty;
        if (isWarmIndex) {
        assumeTrue(
            for (int i = 0; i < indexRequestBuilders.length; i++) {
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotResponse;
            (discoveryNode, fsInfoPath) -> setDiskUsage(fsInfoPath, TOTAL_SPACE_BYTES, TOTAL_SPACE_BYTES)
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
import java.util.Locale;
                return minShardSize;
                    .updateSettings(
        ensureStableCluster(2);
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
        createTestIndices(nodeNames);
        ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
        // User applies index create block.
    private void createIndex(String indexName, String nodeName, boolean isWarmIndex) throws Exception {
     */
        var nodeNames = startTestNodes(1, nodeSettings);
 * You may obtain a copy of the License at
            assertThat(path + " not contained in a unique tracked path", containingPaths, hasSize(1));
                shardSizes[shardStats.getShardRouting().id()] = shardStats.getStats().getStore().sizeInBytes();
        }, 30L, TimeUnit.SECONDS);
        private final Path rootDir;
    }
 */
                }
    }
        return createReasonableSizedShards(indexName);
            assertFalse(state1.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Rebalance;
        remoteRepoPath = randomRepoPath().toAbsolutePath();
            final FileStore fileStore;
            assertTrue(state1.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        }, 30L, TimeUnit.SECONDS);
                    return total;
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
    protected Path remoteRepoPath;
                return super.getTotalSpace();
            // be processing a previous ClusterInfo update and will skip the new one (see DiskThresholdMonitor#onNewInfo(ClusterInfo)
            }
     */
import java.io.IOException;
            0,
        public String name() {
                assertTrue(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK));
        final Settings nodeSettings = buildTestSettings(false, null);
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
                .setTranslog(true)
        MockInternalClusterInfoService clusterInfoService,
            0,
            WRITABLE_WARM_INDEX_SETTING.get(settings) == false
     * Helper method to create test indices for both hot and warm scenarios
            final IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[scaledRandomIntBetween(100, 10000)];
            indexSettingBuilder.put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 6);
            final Set<ShardRouting> shardRoutings = getShardRoutings(nodeName, indexName);
        internalCluster().getCurrentClusterManagerNodeInstance(ClusterService.class).addListener(event -> clusterInfoService.refresh());
        simulateDiskPressure(clusterInfoService);
        simulateDiskPressure(clusterInfoService);
import java.util.ArrayList;
        final Settings nodeSettings = buildTestSettings(false, false);
            totalCacheSize,
     * Helper method to release disk pressure for both hot and warm indices
        boolean isWarmIndex = WRITABLE_WARM_INDEX_SETTING.get(settings);
 */
                .prepareStats(indexName)
 * specific language governing permissions and limitations
        assertBusy(() -> {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        }
    @Override
import static org.hamcrest.Matchers.is;
        assertAcked(
        assertAcked(client().admin().cluster().prepareUpdateSettings().setPersistentSettings(removeBlockSetting).get());
            0,
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "0b")
            used,
    public void testIndexCreateBlockIsRemovedWhenAnyNodesNotExceedHighWatermarkWithAutoReleaseEnabled() throws Exception {
                    long total = 0L;
                .put(IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE, Boolean.TRUE.toString())
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 100L, 100L, 100L);
     * Helper method to simulate disk pressure for both hot and warm indices
    }
        ensureStableCluster(2);
                    return Files.size(path);
import java.nio.file.Files;
            assertThat(totalSpace, anyOf(is(-1L), greaterThan(0L)));
        ensureStableCluster(3);
        return indexList;
            final long totalSpace = this.totalSpace;
            return rootDir;
            .setRoutingTable(true)
        assertThat(restoreInfo.failedShards(), is(0));
        }
        assertThat(snapshotInfo.state(), is(SnapshotState.SUCCESS));
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
                return super.getUsableSpace();
        simulateFileCacheActiveUsage(getMockInternalClusterInfoService(), 90L, 100L, 100L);
            0,
            getMockInternalClusterInfoService().refresh();
    private Settings warmNodeSettings(ByteSizeValue cacheSize) {
                } catch (NotDirectoryException | NoSuchFileException | FileNotFoundException e) {
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
                .prepareHealth()
        assertBusy(() -> {
        for (IndexShardRoutingTable indexShardRoutingTable : client().admin()
    private static AggregateFileCacheStats setAggregateFileCacheStats(long active, long used, long totalCacheSize) {
        TestFileSystemProvider(FileSystem delegateInstance, Path rootDir) {
        assertThat(snapshotInfo.successfulShards(), is(snapshotInfo.totalShards()));
            0,
        final Settings nodeSettings = buildTestSettings(false, false);
        final Settings.Builder indexSettingBuilder = Settings.builder()
            ClusterState state = client().admin().cluster().prepareState().setLocal(true).get().getState();
     */
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
    public void testIndexCreateBlockWithAReadOnlyBlock() throws Exception {
        return Settings.builder()
 */
            .put(super.nodeSettings(0))
    }
            final Set<Path> containingPaths = trackedPaths.keySet().stream().filter(path::startsWith).collect(Collectors.toSet());
        public void setTotalSpace(long totalSpace) {
            refreshDiskUsage();
     */
import java.util.stream.StreamSupport;
    private List<String> startTestNodes(int nodeCount, Settings additionalSettings) {
        );
            .getCurrentClusterManagerNodeInstance(ClusterInfoService.class);
        );
                .build();
        ensureStableCluster(3);
                    for (Path subpath : directoryStream) {
        // Validate index create block is applied on the cluster
            if (totalSpace == -1) {
                assertFalse(state.getBlocks().hasIndexBlock(index, IndexMetadata.INDEX_READ_BLOCK));
        // Depending on node name specified or not, we determine whether to enable node name based shard routing for index
        releaseDiskPressure(clusterInfoService);
            assertTrue(state.blocks().hasGlobalBlockWithId(Metadata.CLUSTER_CREATE_INDEX_BLOCK.id()));
        internalCluster().startClusterManagerOnlyNode(nodeSettings);
        }, 30L, TimeUnit.SECONDS);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    public void testIndexWriteBlockWhenNodeFileCacheActiveUsageExceedsIndexThreshold() throws Exception {
        assertBusyWithDiskUsageRefresh(dataNode0Id, indexName, empty());
