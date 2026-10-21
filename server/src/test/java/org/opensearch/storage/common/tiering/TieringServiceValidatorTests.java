        clusterState = ClusterState.builder(buildClusterState("test-index", "na", Settings.EMPTY, null))
                clusterInfo,
    public void testValidateCommon_FailsWithHighJVMUtilization() {
import org.opensearch.cluster.metadata.Metadata;
            );
        Map<String, DiskUsage> usages = new HashMap<>();
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
        for (int i = 0; i < hotNodes; i++) {
        diskUsages.put("warm-0", new DiskUsage("warm-0", "warm-0", "/foo/bar", 2000, 1500));
import org.opensearch.common.settings.Settings;
        assertTrue(e.getMessage().contains("no nodes found with the warm role"));
        expectThrows(
                testIndex,
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
        for (int i = 0; i < numWarm; i++) {
import org.opensearch.cluster.metadata.IndexMetadata;
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
                testIndex,
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            nodeResourceUsageStatsMap(warmNodeCount, 0, jvmUtilPercent)
                90,
        Map<String, Long> shardSizes = new HashMap<>();
        return builder.build();
                new WarmNodeDiskThresholdEvaluator(diskThresholdSettings, fileCacheSettings(1.0)::getRemoteDataRatio)
    }
    private static DiskThresholdSettings diskThresholdSettings(String low, String high, String flood) {
import org.opensearch.indices.ShardLimitValidator;
            .put(INDEX_TIERING_STATE.getKey(), tierState)
    private ClusterState clusterState;
                    buildNewFakeTransportAddress(),
            TieringRejectionException.class,
        ClusterInfo info = new ClusterInfo(diskUsages, diskUsages, shardSizes, null, Map.of(), Map.of(), null);
import org.opensearch.common.settings.Setting;
    public void testValidateCommon_FailsWithNoWarmNodes() {
        setupClusterState(1, HOT.toString(), true);
        clusterInfo = new ClusterInfo(
import org.opensearch.cluster.ClusterName;
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            diskUsages(2, 2, totalBytes, freeBytes),
    }
            )
        }
    private DiscoveryNodes createNodes(int numWarm, int numData, int numIngest) {
        TieringServiceValidator.validateSpaceForLargestShard(clusterState, clusterInfo, testIndex, WARM, 20L * 1024 * 1024 * 1024L);
                new DiscoveryNode(
        testIndex = new Index("test-index", "uuid");
        String indexUuid = UUID.randomUUID().toString();
                clusterInfo,
                    "data-" + i,
    private static FileCacheSettings fileCacheSettings(double ratio) {
    public void testValidateSpaceForLargestShard_Success() {
        ClusterState state = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY, null))
            .put(IndexMetadata.SETTING_INDEX_UUID, indexUuid)
        ClusterState state = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY, null))
        shardLimitValidator = mock(ShardLimitValidator.class);
    }
                testIndex,
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
            null,
                1,
public class TieringServiceValidatorTests extends OpenSearchTestCase {
import org.opensearch.cluster.routing.RoutingTable;
            )
                testIndex,
        int fileCachePercent
                WARM,
                    Version.CURRENT
import java.util.HashMap;
    public void testValidateEligibleNodesCapacityW2H_Failure() {
            .put("index.version.created", Version.CURRENT)
        int jvmUtilPercent,
        String indexName = "test_index";
                HOT_TO_WARM,
                testIndex,
    private static Map<String, DiskUsage> diskUsages(int warmNodes, int hotNodes, long totalBytes, long freeBytes) {
        long shardSize,
import org.opensearch.index.IndexModule;
    // --- Helper methods ---
                    Collections.singleton(DiscoveryNodeRole.WARM_ROLE),
                clusterState,
    public void testValidateEligibleNodesCapacityW2H_Success() {
            () -> TieringServiceValidator.validateSpaceForLargestShard(
        expectThrows(
    }
        );
package org.opensearch.storage.common.tiering;
/*
            routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
import java.util.Map;
        setupClusterStateWithRemoteStore(1, HOT.toString(), true, false);
    }
}
    public void testValidateCommon_FailsWithIncorrectInitialState() {
 */
    public void testValidateCommon_SucceedsWithLowJVMUtilization() {
                20L * 1024 * 1024 * 1024L
    public void setUp() throws Exception {
            .routingTable(routingTableBuilder.build())
                4,
                clusterInfo,
        for (int i = 0; i < warmNodes; i++) {
        return new DiskThresholdSettings(
                WARM,
import org.opensearch.cluster.routing.ShardRoutingState;
                1,
        ShardRouting primaryShard = TestShardRouting.newShardRouting(
                )
            )
            Settings.builder().put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), ratio).build(),
                shardLimitValidator
            isHealthy ? ShardRoutingState.STARTED : ShardRoutingState.UNASSIGNED
        validateEligibleHotNodesCapacity(state, info, tieringIndices, idx);
            new ClusterSettings(Settings.EMPTY, settings)
        for (int i = 0; i < warmNodes; i++) {
        );
    private void validateCapacity(long totalBytes, long freeBytes, long shardSize, IndexModule.TieringState targetTier) {
            TieringRejectionException.class,
    public void testValidateSpaceForLargestShard_Failure() {
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
                    Collections.emptyMap(),
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        ClusterInfo info = new ClusterInfo(Map.of(), Map.of(), shardSizes, null, Map.of(), Map.of(), Map.of());
            info,
 *
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.cluster.ClusterState;
            .put(IndexMetadata.SETTING_INDEX_UUID, testIndex.getUUID())
                90,
        if (routingTable == null) {
                    Collections.emptyMap(),
        expectThrows(
            () -> TieringServiceValidator.validateCommon(
                90,
            () -> TieringServiceValidator.validateCommon(
                clusterInfo,
    private static Map<String, NodeResourceUsageStats> nodeResourceUsageStatsMap(int warmNodes, int hotNodes, double jvmPercent) {
import org.opensearch.Version;
import org.opensearch.cluster.node.DiscoveryNodes;
        return usages;
    }
                )
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
                3,
                90,
            null
        TieringRejectionException e = expectThrows(
        }
                info,
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
                clusterState,
        indicesNodeMap.put(idx, "warm-0");
            () -> TieringServiceValidator.validateCommon(
import org.opensearch.cluster.DiskUsage;
                .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), high)
    }
            .metadata(metadata)
        setupClusterInfo(1, 100, 5, 50L, 50, 20);
        setupClusterState(1, HOT.toString(), true);
import static org.opensearch.storage.common.tiering.TieringServiceValidator.validateEligibleHotNodesCapacity;
                WARM,
        super.setUp();
        );
    public void testValidateWarmNodeDiskThresholdWaterMarkLow_NoBreached() {
import java.util.HashSet;
                1,
                    buildNewFakeTransportAddress(),
                clusterInfo,
        expectThrows(
        }
        Index idx = new Index(indexName, indexUuid);
        routingTableBuilder.add(createRoutingTable(testIndex, "warm-0", isHealthy));
    }
 * The OpenSearch Contributors require contributions made to
                state,
    ) {
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;
        diskUsages.put("warm-1", new DiskUsage("warm-1", "warm-1", "/foo/bar", 2000, 1500));
                WARM,
    private ClusterInfo clusterInfo;
                3,
                90,
        );
 * SPDX-License-Identifier: Apache-2.0
        setupClusterState(1, HOT.toString(), true);
            .metadata(Metadata.builder().put(indexMetadata, false))
    }
            diskUsages(2, 2, totalBytes, freeBytes),
        expectThrows(TieringRejectionException.class, () -> validateCapacity(100, 5, 20L, IndexModule.TieringState.HOT));
        );
        builder.addShard(primaryShard);
    }
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
            .build();
            TieringRejectionException.class,
            .build();
        validateCapacity(100, 50, 20L, IndexModule.TieringState.HOT);
                testIndex,
        Index idx = new Index(indexName, indexUuid);
            TieringRejectionException.class,
    }
        Map<String, Long> shardSizes = Collections.singletonMap("[test-index][0][p]", shardSize);
import org.junit.Before;
            .build();
                shardLimitValidator
            () -> TieringServiceValidator.validateWarmNodeDiskThresholdWaterMarkLow(
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
            () -> TieringServiceValidator.validateCommon(
        for (int i = 0; i < hotNodes; i++) {
    }
                1,
    private IndexMetadata indexMetadata;
        );
        }
                .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), low)
        return new FileCacheSettings(
                idx,
            map.put("warm-" + i, new NodeResourceUsageStats("warm-" + i, System.currentTimeMillis(), jvmPercent, 0, null, 0));
            .nodes(createNodes(2, 0, 0))
            new HashSet<>(),
                    Version.CURRENT
        setupClusterStateWithRemoteStore(warmNodes, tierState, isHealthy, true);
            .routingTable(routingTable)
                new DiscoveryNode(
                .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), flood)
        ClusterInfo info = new ClusterInfo(
        Map<String, NodeResourceUsageStats> map = new HashMap<>();
            new WarmNodeDiskThresholdEvaluator(diskThresholdSettings, fileCacheSettings(2.0)::getRemoteDataRatio)
                clusterState,
        Index idx = new Index(indexName, indexUuid);
    public void testValidateCommon_SuccessfulHotToWarmTransition() {
            builder.add(
import static org.opensearch.storage.common.tiering.TieringUtils.Tier.HOT;
import org.opensearch.cluster.routing.TestShardRouting;
        Map<String, DiskUsage> diskUsages = new HashMap<>();
        shardSizes.put("[test][0][p]", 100L);
        setupClusterInfo(2, 1000, 500, 10L, 50, 20);
    private static ClusterState buildClusterState(String indexName, String indexUuid, Settings settings, RoutingTable routingTable) {
    }
        return map;
        Set<Index> tieringIndices = Collections.singleton(idx);
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
    }
                    Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        setupClusterState(1, HOT.toString(), true);
            TieringRejectionException.class,
            null,
        );
                HOT_TO_WARM,
                HOT_TO_WARM,
        TieringServiceValidator.validateCommon(clusterState, clusterInfo, testIndex, 2, 5, 90, WARM, HOT_TO_WARM, shardLimitValidator);
            Map.of(),
                shardLimitValidator
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
        Settings combinedSettings = Settings.builder()
        }
 * this file be licensed under the Apache-2.0 license or a
            )
            TieringRejectionException.class,
            );
        setupClusterState(0, HOT.toString(), true);
import org.opensearch.cluster.node.DiscoveryNodeRole;
        ClusterState state = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY, null))
        for (int i = 0; i < numData; i++) {
import org.opensearch.cluster.routing.allocation.WarmNodeDiskThresholdEvaluator;
                clusterState,
            null,
        Map<String, Long> shardSizes = Collections.singletonMap("[test_index][0][p]", shardSize);
import org.opensearch.test.OpenSearchTestCase;
            .nodes(createNodes(warmNodes, 0, 0))
            usages.put("data-" + i, new DiskUsage("data-" + i, "data-" + i, "/foo/bar", totalBytes, freeBytes));
    }
            )
    }
        );
    public void testValidateWarmNodeDiskThresholdWaterMarkLow_Breached() {
        }
    private void setupClusterState(int warmNodes, String tierState, boolean isHealthy) {
            Settings.builder()
                clusterInfo,
import java.util.Set;
        return builder.build();
    }
    private ShardLimitValidator shardLimitValidator;
            diskUsages(warmNodeCount, 0, totalBytes, freeBytes),
    }
            .build();
            .build();
        String indexUuid = UUID.randomUUID().toString();
        HashSet<Setting<?>> settings = new HashSet<>(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    private Index testIndex;
    }
        DiskThresholdSettings diskThresholdSettings = diskThresholdSettings("150b", "100b", "50b");
        setupClusterState(1, HOT.toString(), true);
        String indexName = "test";
        settings.add(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.cluster.ClusterInfo;
            isHealthy ? nodeId : null,
        setupClusterInfo(1, 100, 50, 10L, 99, 20);
import org.opensearch.node.NodeResourceUsageStats;
            true,
        expectThrows(
        TieringServiceValidator.validateCommon(clusterState, clusterInfo, testIndex, 2, 3, 99, WARM, HOT_TO_WARM, shardLimitValidator);
    public void testValidateCommon_FailsWithMaxConcurrentRequestsBreached() {
    }
        String indexUuid = UUID.randomUUID().toString();
            usages.put("warm-" + i, new DiskUsage("warm-" + i, "warm-" + i, "/foo/bar", totalBytes, freeBytes));
    }
import org.opensearch.cluster.routing.ShardRouting;
                HOT_TO_WARM,
import org.opensearch.core.index.shard.ShardId;
                WARM,
        expectThrows(
        shardSizes.put("[test][0][p]", 2000L);
    }
                HOT_TO_WARM,
        setupClusterState(1, WARM.toString(), true);
    @Before
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(settings))
            Map.of(),
    }
                shardLimitValidator
import static org.opensearch.index.IndexModule.TieringState.WARM;
                shardLimitValidator
        Metadata metadata = Metadata.builder().put(IndexMetadata.builder(indexName).settings(combinedSettings)).build();
            .build();
            shardSizes,
            map.put("data-" + i, new NodeResourceUsageStats("data-" + i, System.currentTimeMillis(), jvmPercent, 0, null, 0));
                .build(),
        Map<Index, String> indicesNodeMap = new HashMap<>();
        );
                    "warm-" + i,
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, remoteStoreEnabled)
            idx,
            .build();
            .nodes(createNodes(2, 2, 0))
            )
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
        TieringServiceValidator.validateWarmNodeDiskThresholdWaterMarkLow(
        int warmNodeCount,
import java.util.Collections;
                clusterState,
            )
                3,
        long totalBytes,
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 2)
        );
        );
        Settings indexSettings = Settings.builder()
            Map.of(),
        );
import java.util.UUID;
    private void setupClusterInfo(
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
                clusterState,
        }
    }
        indexMetadata = IndexMetadata.builder(testIndex.getName()).settings(indexSettings).numberOfShards(1).numberOfReplicas(1).build();
        DiskThresholdSettings diskThresholdSettings = diskThresholdSettings("10b", "10b", "5b");
    private void setupClusterStateWithRemoteStore(int warmNodes, String tierState, boolean isHealthy, boolean remoteStoreEnabled) {
            shardSizes,
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
import org.opensearch.core.index.Index;
        setupClusterInfo(1, 100, 50, 10L, 40, 20);
            Map.of(),
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
            TieringRejectionException.class,
import static org.mockito.Mockito.mock;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        );
                new HashSet<>(),
            .put(settings)
            builder.add(
            () -> TieringServiceValidator.validateCommon(
import org.opensearch.cluster.routing.IndexRoutingTable;
        String indexName = "test";
            state,
            .nodes(createNodes(2, 0, 0))
                WARM,
                3,
                4,
    }
import org.opensearch.cluster.node.DiscoveryNode;
    public void testValidateCommon_FailsWithRemoteStoreDisabled() {
    private IndexRoutingTable createRoutingTable(Index index, String nodeId, boolean isHealthy) {
            new ShardId(index, 0),
 * compatible open source license.
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        Map<String, Long> shardSizes = new HashMap<>();
        long freeBytes,
        setupClusterState(2, HOT.toString(), true);
