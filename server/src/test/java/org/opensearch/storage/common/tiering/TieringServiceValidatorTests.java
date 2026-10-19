        ClusterState state = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY, null))  
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;  
            diskUsages(2, 2, totalBytes, freeBytes),
        return new DiskThresholdSettings(
            .build();
            TieringRejectionException.class,
            shardSizes,  
            Map.of(),  
                HOT_TO_WARM,
        TieringServiceValidator.validateCommon(clusterState, clusterInfo, testIndex, 2, 5, 90, WARM, HOT_TO_WARM, shardLimitValidator);
        }  
    private static Map<String, NodeResourceUsageStats> nodeResourceUsageStatsMap(int warmNodes, int hotNodes, double jvmPercent) {
                clusterState,
import java.util.UUID;
    public void testValidateCommon_SuccessfulHotToWarmTransition() {
                90,  
    }
        }
            .put("index.version.created", Version.CURRENT)
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
                clusterInfo,  
                    Version.CURRENT
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
            () -> TieringServiceValidator.validateCommon(  
import static org.opensearch.storage.common.tiering.TieringUtils.Tier.HOT;
/*  
    }
            )
import static org.opensearch.storage.common.tiering.TieringServiceValidator.validateEligibleHotNodesCapacity;  
    }  
    }
            .put(settings)  
        expectThrows(
        String indexName = "test_index";  
import org.opensearch.common.settings.Settings;
                3,
            map.put("data-" + i, new NodeResourceUsageStats("data-" + i, System.currentTimeMillis(), jvmPercent, 0, null, 0));
        return builder.build();
            .metadata(Metadata.builder().put(indexMetadata, false))  
        expectThrows(
                testIndex,  
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(settings))
    private ClusterState clusterState;
 * compatible open source license.
            idx,
import org.opensearch.test.OpenSearchTestCase;
        return builder.build();
 *
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();  
                90,
                WARM,  
        for (int i = 0; i < warmNodes; i++) {
                new HashSet<>(),  
        validateCapacity(100, 50, 20L, IndexModule.TieringState.HOT);  
                    Collections.singleton(DiscoveryNodeRole.WARM_ROLE),
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)
            null,  
        }
        DiskThresholdSettings diskThresholdSettings = diskThresholdSettings("150b", "100b", "50b");
    }
        setupClusterStateWithRemoteStore(1, HOT.toString(), true, false);
        Map<String, DiskUsage> usages = new HashMap<>();  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        Set<Index> tieringIndices = Collections.singleton(idx);
        int jvmUtilPercent,
        IndexRoutingTable.Builder builder = IndexRoutingTable.builder(index);
        Map<String, Long> shardSizes = Collections.singletonMap("[test-index][0][p]", shardSize);
    public void testValidateSpaceForLargestShard_Success() {
                testIndex,
                1,  
                )
                    Collections.singleton(DiscoveryNodeRole.DATA_ROLE),  
            info,
import org.opensearch.cluster.node.DiscoveryNodes;  
    public void testValidateEligibleNodesCapacityW2H_Failure() {  
import org.opensearch.cluster.node.DiscoveryNodeRole;
    public void testValidateCommon_FailsWithNoWarmNodes() {
            new ClusterSettings(Settings.EMPTY, settings)
    private void setupClusterStateWithRemoteStore(int warmNodes, String tierState, boolean isHealthy, boolean remoteStoreEnabled) {
        shardLimitValidator = mock(ShardLimitValidator.class);
                    buildNewFakeTransportAddress(),
            diskUsages(2, 2, totalBytes, freeBytes),
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
import org.opensearch.cluster.ClusterState;  
            () -> TieringServiceValidator.validateCommon(
    }
    private IndexMetadata indexMetadata;  
                HOT_TO_WARM,
        return usages;
        super.setUp();  
        for (int i = 0; i < hotNodes; i++) {  
            Settings.builder()
            .routingTable(routingTable)
                HOT_TO_WARM,  
                testIndex,  
        );
        builder.addShard(primaryShard);  
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
        setupClusterInfo(1, 100, 50, 10L, 40, 20);
import org.opensearch.node.NodeResourceUsageStats;
        ClusterInfo info = new ClusterInfo(  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            TieringRejectionException.class,
        );  
    }
        expectThrows(  
    public void testValidateCommon_FailsWithIncorrectInitialState() {
                WARM,
 * The OpenSearch Contributors require contributions made to  
    public void testValidateWarmNodeDiskThresholdWaterMarkLow_NoBreached() {
        Settings combinedSettings = Settings.builder()
        Index idx = new Index(indexName, indexUuid);
        Map<String, Long> shardSizes = new HashMap<>();
            state,
        );
            )
                WARM,
            .nodes(createNodes(2, 0, 0))
import org.opensearch.indices.ShardLimitValidator;  
            Map.of(),
        expectThrows(
    ) {  
        setupClusterInfo(1, 100, 50, 10L, 99, 20);  
                shardLimitValidator  
        expectThrows(
    }  
import org.opensearch.cluster.ClusterInfo;
            diskUsages(warmNodeCount, 0, totalBytes, freeBytes),  
import org.opensearch.cluster.DiskUsage;
import static org.opensearch.index.IndexModule.TieringState.WARM;
    private DiscoveryNodes createNodes(int numWarm, int numData, int numIngest) {
import org.opensearch.cluster.node.DiscoveryNode;
                3,
package org.opensearch.storage.common.tiering;
    private static ClusterState buildClusterState(String indexName, String indexUuid, Settings settings, RoutingTable routingTable) {
        TieringServiceValidator.validateSpaceForLargestShard(clusterState, clusterInfo, testIndex, WARM, 20L * 1024 * 1024 * 1024L);
import org.opensearch.cluster.routing.RoutingTable;
    private static Map<String, DiskUsage> diskUsages(int warmNodes, int hotNodes, long totalBytes, long freeBytes) {
            true,  
    }
    public void testValidateCommon_SucceedsWithLowJVMUtilization() {
        setupClusterState(1, HOT.toString(), true);  
        setupClusterState(2, HOT.toString(), true);
        assertTrue(e.getMessage().contains("no nodes found with the warm role"));
    }  
import org.opensearch.core.index.Index;
        int warmNodeCount,  
    }
        setupClusterState(1, HOT.toString(), true);
                .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), low)  
                1,
                3,
        Map<String, Long> shardSizes = Collections.singletonMap("[test_index][0][p]", shardSize);
                HOT_TO_WARM,
                90,
            () -> TieringServiceValidator.validateCommon(
import java.util.Map;
                clusterInfo,
import org.opensearch.core.index.shard.ShardId;  
        setupClusterInfo(2, 1000, 500, 10L, 50, 20);  
import org.opensearch.cluster.routing.ShardRoutingState;
        TieringServiceValidator.validateCommon(clusterState, clusterInfo, testIndex, 2, 3, 99, WARM, HOT_TO_WARM, shardLimitValidator);
                20L * 1024 * 1024 * 1024L
                clusterInfo,  
import static org.opensearch.index.IndexModule.TieringState.HOT_TO_WARM;
            .nodes(createNodes(2, 0, 0))
        expectThrows(
            .put(IndexMetadata.SETTING_INDEX_UUID, indexUuid)
    }
        indicesNodeMap.put(idx, "warm-0");
    }
import static org.mockito.Mockito.mock;
            .routingTable(routingTableBuilder.build())
        );  
        );
        diskUsages.put("warm-0", new DiskUsage("warm-0", "warm-0", "/foo/bar", 2000, 1500));
    }
import java.util.HashSet;
    }  
        return new FileCacheSettings(
import java.util.Set;  
                clusterInfo,
        }
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 2)  
            nodeResourceUsageStatsMap(warmNodeCount, 0, jvmUtilPercent)  
                idx,
                .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), high)
        );
        Map<String, DiskUsage> diskUsages = new HashMap<>();
    }  
    private ClusterInfo clusterInfo;
    }
            )
        setupClusterInfo(1, 100, 50, 10L, 50, 20);  
            .put(IndexMetadata.SETTING_INDEX_UUID, testIndex.getUUID())  
                3,  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        );  
        TieringRejectionException e = expectThrows(
            isHealthy ? ShardRoutingState.STARTED : ShardRoutingState.UNASSIGNED
        diskUsages.put("warm-1", new DiskUsage("warm-1", "warm-1", "/foo/bar", 2000, 1500));  
        String indexName = "test";
        Index idx = new Index(indexName, indexUuid);
                    "data-" + i,  
        setupClusterStateWithRemoteStore(warmNodes, tierState, isHealthy, true);
            null
public class TieringServiceValidatorTests extends OpenSearchTestCase {
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;  
            TieringRejectionException.class,
        );
 * SPDX-License-Identifier: Apache-2.0
    public void setUp() throws Exception {
    }  
                new DiscoveryNode(  
                    "warm-" + i,
    private void setupClusterInfo(
            Map.of(),
        int fileCachePercent
        shardSizes.put("[test][0][p]", 100L);
                info,
        ClusterState state = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY, null))
        ClusterInfo info = new ClusterInfo(diskUsages, diskUsages, shardSizes, null, Map.of(), Map.of(), null);
                shardLimitValidator
import org.opensearch.cluster.routing.TestShardRouting;
        );
                clusterState,  
        ShardRouting primaryShard = TestShardRouting.newShardRouting(  
            .build();  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                clusterState,
            Map.of(),
    private IndexRoutingTable createRoutingTable(Index index, String nodeId, boolean isHealthy) {
    }  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
        }  
import org.opensearch.cluster.routing.allocation.WarmNodeDiskThresholdEvaluator;
            routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();  
        );
        Map<String, Long> shardSizes = new HashMap<>();  
    private void setupClusterState(int warmNodes, String tierState, boolean isHealthy) {  
    @Before
            new WarmNodeDiskThresholdEvaluator(diskThresholdSettings, fileCacheSettings(2.0)::getRemoteDataRatio)
                1,
        settings.add(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING);
import org.opensearch.cluster.routing.ShardRouting;  
    private static FileCacheSettings fileCacheSettings(double ratio) {
    public void testValidateSpaceForLargestShard_Failure() {
    }
        setupClusterState(1, HOT.toString(), true);  
        for (int i = 0; i < warmNodes; i++) {  
        clusterInfo = new ClusterInfo(
            TieringRejectionException.class,  
    public void testValidateWarmNodeDiskThresholdWaterMarkLow_Breached() {  
                90,
    public void testValidateCommon_FailsWithHighJVMUtilization() {
    private static DiskThresholdSettings diskThresholdSettings(String low, String high, String flood) {  
                    Collections.emptyMap(),
            )  
import org.opensearch.common.settings.Setting;  
        );
            usages.put("data-" + i, new DiskUsage("data-" + i, "data-" + i, "/foo/bar", totalBytes, freeBytes));
                clusterInfo,
        }
    }
        long shardSize,  
        shardSizes.put("[test][0][p]", 2000L);
            )  
import org.opensearch.Version;  
            )
                new DiscoveryNode(
    public void testValidateCommon_FailsWithRemoteStoreDisabled() {  
    }  
            TieringRejectionException.class,
            .nodes(createNodes(warmNodes, 0, 0))
        ClusterInfo info = new ClusterInfo(Map.of(), Map.of(), shardSizes, null, Map.of(), Map.of(), Map.of());
        long totalBytes,
        Settings indexSettings = Settings.builder()
        if (routingTable == null) {
 */  
        setupClusterInfo(1, 100, 50, 10L, 50, 20);
import org.opensearch.cluster.ClusterName;
            .nodes(createNodes(2, 2, 0))
                clusterState,
    }  
                new WarmNodeDiskThresholdEvaluator(diskThresholdSettings, fileCacheSettings(1.0)::getRemoteDataRatio)
import org.opensearch.common.settings.ClusterSettings;
            () -> TieringServiceValidator.validateWarmNodeDiskThresholdWaterMarkLow(  
                4,  
        return map;  
            TieringRejectionException.class,  
                state,
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
        );
                testIndex,
                shardLimitValidator
        String indexUuid = UUID.randomUUID().toString();
import org.opensearch.index.IndexModule;
        DiskThresholdSettings diskThresholdSettings = diskThresholdSettings("10b", "10b", "5b");
import java.util.HashMap;  
        String indexName = "test";  
    private Index testIndex;
                90,  
                clusterInfo,
            TieringRejectionException.class,
        String indexUuid = UUID.randomUUID().toString();  
                )  
    private void validateCapacity(long totalBytes, long freeBytes, long shardSize, IndexModule.TieringState targetTier) {
                1,
                clusterState,
        Map<String, NodeResourceUsageStats> map = new HashMap<>();
        validateEligibleHotNodesCapacity(state, info, tieringIndices, idx);
                clusterState,
            () -> TieringServiceValidator.validateCommon(  
        clusterState = ClusterState.builder(buildClusterState("test-index", "na", Settings.EMPTY, null))
        setupClusterState(1, HOT.toString(), true);  
            builder.add(
        long freeBytes,
        routingTableBuilder.add(createRoutingTable(testIndex, "warm-0", isHealthy));
        expectThrows(TieringRejectionException.class, () -> validateCapacity(100, 5, 20L, IndexModule.TieringState.HOT));
            isHealthy ? nodeId : null,
        String indexUuid = UUID.randomUUID().toString();
        TieringServiceValidator.validateWarmNodeDiskThresholdWaterMarkLow(  
        Map<Index, String> indicesNodeMap = new HashMap<>();  
        for (int i = 0; i < numWarm; i++) {
        indexMetadata = IndexMetadata.builder(testIndex.getName()).settings(indexSettings).numberOfShards(1).numberOfReplicas(1).build();
            new HashSet<>(),  
        setupClusterState(1, HOT.toString(), true);
            () -> TieringServiceValidator.validateCommon(
import java.util.Collections;
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, remoteStoreEnabled)
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
        );
    public void testValidateCommon_FailsWithMaxConcurrentRequestsBreached() {
            usages.put("warm-" + i, new DiskUsage("warm-" + i, "warm-" + i, "/foo/bar", totalBytes, freeBytes));
            .build();  
        for (int i = 0; i < numData; i++) {  
                    Collections.emptyMap(),  
import org.opensearch.cluster.routing.IndexRoutingTable;
            null,
                    buildNewFakeTransportAddress(),
        setupClusterInfo(1, 100, 5, 50L, 50, 20);  
            .put(INDEX_TIERING_STATE.getKey(), tierState)
                WARM,
                WARM,
        Index idx = new Index(indexName, indexUuid);
            );
    public void testValidateEligibleNodesCapacityW2H_Success() {
            .build();
            null,
                shardLimitValidator
        ClusterState state = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY, null))
                shardLimitValidator  
                4,
                .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), flood)
            builder.add(
            .build();  
        for (int i = 0; i < hotNodes; i++) {
            .build();
                    Version.CURRENT
    private ShardLimitValidator shardLimitValidator;
        testIndex = new Index("test-index", "uuid");
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.metadata.IndexMetadata;
                .build(),  
            Settings.builder().put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), ratio).build(),  
            );  
                HOT_TO_WARM,  
            shardSizes,
        setupClusterState(1, WARM.toString(), true);
                testIndex,
    }
            new ShardId(index, 0),
            map.put("warm-" + i, new NodeResourceUsageStats("warm-" + i, System.currentTimeMillis(), jvmPercent, 0, null, 0));
import org.opensearch.cluster.metadata.Metadata;  
            .metadata(metadata)  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;  
        }
    }  
                WARM,
    // --- Helper methods ---
import org.junit.Before;  
        setupClusterState(0, HOT.toString(), true);  
}
                testIndex,  
            () -> TieringServiceValidator.validateSpaceForLargestShard(  
            .build();
        Metadata metadata = Metadata.builder().put(IndexMetadata.builder(indexName).settings(combinedSettings)).build();
        HashSet<Setting<?>> settings = new HashSet<>(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            )  
