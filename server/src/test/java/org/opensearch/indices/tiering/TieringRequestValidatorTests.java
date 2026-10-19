 * The OpenSearch Contributors require contributions made to
    private static DiskThresholdSettings diskThresholdSettings(String low, String high, String flood) {
        assertEquals(indices, tieringValidationResult.getAcceptedIndices());
        return Settings.builder()
        );
        String indexUuid = UUID.randomUUID().toString();
import static org.opensearch.indices.tiering.TieringRequestValidator.validateWarmNodes;
        ClusterState clusterState = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY))
            );
        String indexUuid = UUID.randomUUID().toString();
    }
        Map<String, DiskUsage> diskUsages = diskUsages(1, 100, 50);
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
        String indexUuid = UUID.randomUUID().toString();
        shardSizes.put("[test_index][0][p]", 10L); // 10 bytes
import java.util.Map;
 * compatible open source license.
    public void testValidHotIndex() {
        }
            Settings.builder().put(IndexModule.INDEX_TIERING_STATE.getKey(), tieringState).build()
            discoveryNodesBuilder.add(
        }
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.test.OpenSearchTestCase;
                .build()
            indexName,
                .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), flood)
        ClusterState clusterState1 = buildClusterState(
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        String indexUuid = UUID.randomUUID().toString();
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testValidRemoteStoreIndex() {
            .put("index.version.created", Version.CURRENT)
                )
        DiscoveryNodes.Builder discoveryNodesBuilder = DiscoveryNodes.builder();
        assertEquals(10, getIndexPrimaryStoreSize(clusterState, clusterInfo, indexName));
        String indexName = "test_index";
    public void testEligibleNodes() {
        assertEquals(0, getEligibleNodes(clusterState).size());
            Settings.builder()
    }
    private static ClusterState buildClusterState(String indexName, String indexUuid, Settings settings, IndexMetadata.State state) {
    }
import static org.opensearch.indices.tiering.TieringRequestValidator.validateEligibleNodesCapacity;
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)
    }
        final Map<String, Long> shardSizes = new HashMap<>();
            discoveryNodesBuilder.add(
    public void testValidateEligibleNodesCapacityWithAllAccepted() {
                    Collections.emptyMap(),
    public void testValidateDiskThresholdWaterMarkNotBreached() {
import java.util.UUID;
                .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), high)
    }
import org.opensearch.common.settings.Settings;
    public void testValidateIndexHealth() {
            discoveryNodesBuilder.add(
        ClusterState clusterStateWithWarmNodes = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        String indexUuid = UUID.randomUUID().toString();
            Settings.builder()
import static org.opensearch.indices.tiering.TieringRequestValidator.validateOpenIndex;
                )
    }
import org.opensearch.cluster.ClusterName;
                    Collections.emptyMap(),
            .build();
        Set<Index> indices = Set.of(new Index(indexName, indexUuid));
                new DiscoveryNode(
import org.opensearch.cluster.DiskUsage;
        for (int i = 0; i < numOfDataNodes; i++) {
        String indexName = "test_index";
        final Map<String, Long> shardSizes = new HashMap<>();
    }
        }
public class TieringRequestValidatorTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
import java.util.Set;
            .nodes(createNodes(noOfNodes, 0, 0))
    private static ClusterInfo clusterInfo(int noOfNodes, long totalBytes, long freeBytes) {
    }
    }
        );
        expectThrows(
            );
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
            indexUuid,
                    buildNewFakeTransportAddress(),
        // throws no errors
        String indexUuid = UUID.randomUUID().toString();
import static org.opensearch.indices.tiering.TieringRequestValidator.validateIndexHealth;
        assertTrue(tieringValidationResult.getRejectedIndices().isEmpty());
        Map<String, DiskUsage> diskUsages = diskUsages(1, 100, 10);
    public void testWithNoWarmNodesInCluster() {
                    Collections.singleton(DiscoveryNodeRole.INGEST_ROLE),
package org.opensearch.indices.tiering;
    }
        String indexUuid = UUID.randomUUID().toString();
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
    private static ClusterState buildClusterState(String indexName, String indexUuid, Settings settings) {
            .build();
    public void testValidOpenIndex() {
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            indexUuid,
        );
                    buildNewFakeTransportAddress(),
    public void testValidateEligibleNodesCapacityWithAllRejected() {
        assertTrue(tieringValidationResult.getAcceptedIndices().isEmpty());
            IllegalArgumentException.class,
            );
        ClusterInfo clusterInfo = clusterInfo(noOfNodes, 100, 20);
import org.opensearch.indices.replication.common.ReplicationType;
        // throws no error
            validateOpenIndex(
import static org.opensearch.indices.tiering.TieringRequestValidator.getTotalAvailableBytesInWarmTier;
    }
            .build();
        ClusterInfo clusterInfo = new ClusterInfo(diskUsages, null, shardSizes, null, null, Map.of(), Map.of());
import org.opensearch.cluster.ClusterState;
            .nodes(createNodes(0, 1, 1))
import org.opensearch.cluster.node.DiscoveryNode;
    }
                )
    public void testValidateDiskThresholdWaterMarkNotBreachedThrowsError() {
            .build();
                    Version.CURRENT
                new Index(indexName, indexUuid)
import org.opensearch.index.IndexModule;
        assertFalse(
        for (int i = 0; i < noOfWarmNodes; i++) {
        // throws error
            )
                    Version.CURRENT
        int noOfNodes = 2;
        return diskUsages;
            .build();
                    Collections.singleton(DiscoveryNodeRole.WARM_ROLE),
        );
            .build();
        String indexUuid = UUID.randomUUID().toString();
        String indexUuid = UUID.randomUUID().toString();
                    "node-i" + i,
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        return new DiskThresholdSettings(
                new DiscoveryNode(
        String indexName = "test_index";
        String indexName = "test_index";
        assertTrue(validateHotIndex(buildClusterState(indexName, indexUuid, Settings.EMPTY), new Index(indexName, indexUuid)));
            indexName,
    public void testValidateWarmNodes() {
        Map<String, DiskUsage> diskUsages = diskUsages(1, 100, 50);
import org.opensearch.action.admin.indices.tiering.TieringValidationResult;
import org.opensearch.common.settings.ClusterSettings;
        Settings combinedSettings = Settings.builder().put(settings).put(createDefaultIndexSettings(indexUuid)).build();
        Map<String, DiskUsage> diskUsages = diskUsages(2, 500, 100);
        ClusterInfo clusterInfo = clusterInfo(noOfNodes, 100, 5);
                .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
                buildClusterState(indexName, indexUuid, Settings.EMPTY, IndexMetadata.State.CLOSE),
        final Map<String, Long> shardSizes = new HashMap<>();
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 2)
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .nodes(createNodes(1, 0, 0))
    private static Settings createDefaultIndexSettings(String indexUuid) {
        TieringValidationResult tieringValidationResult = new TieringValidationResult(indices);
            diskUsages.put("node-w" + i, new DiskUsage("node-w" + i, "node-w" + i, "/foo/bar", totalBytes, freeBytes));
            .nodes(createNodes(0, 1, 1))
    public void testDocRepIndex() {
        DiskThresholdSettings diskThresholdSettings = diskThresholdSettings("10b", "10b", "5b");
    }
            IllegalArgumentException.class,
        }
        ClusterState clusterState = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY))
import static org.opensearch.indices.tiering.TieringRequestValidator.validateRemoteStoreIndex;
        String indexName = "test_index";
        return new ClusterInfo(diskUsages, null, null, null, null, Map.of(), Map.of());
    }
        );
            .nodes(createNodes(2, 0, 0))
            .nodes(createNodes(1, 0, 0))
    private static Map<String, DiskUsage> diskUsages(int noOfWarmNodes, long totalBytes, long freeBytes) {
        validateWarmNodes(clusterStateWithWarmNodes, "test_index");
        // throws error
        Metadata metadata = Metadata.builder().put(IndexMetadata.builder(indexName).settings(combinedSettings).state(state)).build();
    }
 *
        validateEligibleNodesCapacity(clusterInfo, clusterState, tieringValidationResult);
                    Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
 */
/*
import static org.opensearch.indices.tiering.TieringRequestValidator.validateDiskThresholdWaterMarkNotBreached;
import java.util.HashMap;
        for (int i = 0; i < numOfWarmNodes; i++) {
        ClusterInfo clusterInfo = new ClusterInfo(diskUsages, null, shardSizes, null, null, Map.of(), Map.of());
        for (int i = 0; i < numOfIngestNodes; i++) {
        final Map<String, DiskUsage> diskUsages = new HashMap<>();
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)
        return buildClusterState(indexName, indexUuid, settings, IndexMetadata.State.OPEN);
            .metadata(metadata)
        assertEquals(200, getTotalAvailableBytesInWarmTier(diskUsages, Set.of("node-w0", "node-w1")));
        assertEquals(indices.size(), tieringValidationResult.getRejectedIndices().size());
            .nodes(createNodes(2, 0, 0))
            .nodes(createNodes(1, 0, 0))
        DiskThresholdSettings diskThresholdSettings = diskThresholdSettings("10b", "10b", "5b");
import static org.opensearch.indices.tiering.TieringRequestValidator.validateHotIndex;
    }
            .build();
    }
        final Map<String, DiskUsage> diskUsages = diskUsages(noOfNodes, totalBytes, freeBytes);
        IndexModule.TieringState tieringState = randomBoolean() ? IndexModule.TieringState.HOT_TO_WARM : IndexModule.TieringState.WARM;
            () -> validateWarmNodes(clusterStateWithNoWarmNodes, "test")
import static org.opensearch.indices.tiering.TieringRequestValidator.getEligibleNodes;
        ClusterState clusterState = buildClusterState(
        assertFalse(validateRemoteStoreIndex(buildClusterState(indexName, indexUuid, Settings.EMPTY), new Index(indexName, indexUuid)));
            .put(IndexMetadata.SETTING_INDEX_UUID, indexUuid)
    }
        ClusterState clusterState = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY))
        ClusterState clusterState = buildClusterState(indexName, indexUuid, Settings.EMPTY);
    private DiscoveryNodes createNodes(int numOfWarmNodes, int numOfDataNodes, int numOfIngestNodes) {
        ClusterInfo clusterInfo = new ClusterInfo(diskUsages, null, shardSizes, null, null, Map.of(), Map.of());
    public void testCloseIndex() {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        String indexName = "test_index";
        assertTrue(validateRemoteStoreIndex(clusterState1, new Index(indexName, indexUuid)));
        assertTrue(validateIndexHealth(clusterState, new Index(indexName, indexUuid)));
                    Collections.emptyMap(),
                    "node-w" + i,
        String indexUuid = UUID.randomUUID().toString();
        );
            .build();
                    Version.CURRENT
import org.opensearch.Version;
        validateEligibleNodesCapacity(clusterInfo, clusterState, tieringValidationResult);
    }
        assertFalse(validateHotIndex(clusterState, new Index(indexName, indexUuid)));
import org.opensearch.cluster.ClusterInfo;
import org.opensearch.cluster.metadata.IndexMetadata;
                    buildNewFakeTransportAddress(),
            .build();
        shardSizes.put("[test_index][0][p]", 20L); // 20 bytes
        shardSizes.put("[test_index][0][p]", 10L); // 10 bytes
        assertEquals(2, getEligibleNodes(clusterState).size());
                    "node-d" + i,
        Set<Index> indices = Set.of(new Index(indexName, indexUuid));
        String indexName = "test_index";
    public void testGetTotalIndexSize() {
    }
    public void testGetTotalAvailableBytesInWarmTier() {
        return discoveryNodesBuilder.build();
import org.opensearch.cluster.node.DiscoveryNodes;
import java.util.Collections;
        String indexName = "test_index";
        ClusterState clusterStateWithNoWarmNodes = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
                .build(),
                new DiscoveryNode(
        assertTrue(validateOpenIndex(buildClusterState(indexName, indexUuid, Settings.EMPTY), new Index(indexName, indexUuid)));
            .build();
            () -> validateDiskThresholdWaterMarkNotBreached(clusterState, clusterInfo, diskThresholdSettings, "test")
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;
import org.opensearch.cluster.node.DiscoveryNodeRole;
                .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), low)
            .nodes(createNodes(noOfNodes, 0, 0))
        String indexName = "test_index";
            .routingTable(routingTable)
import static org.opensearch.indices.tiering.TieringRequestValidator.getIndexPrimaryStoreSize;
        validateDiskThresholdWaterMarkNotBreached(clusterState, clusterInfo, diskThresholdSettings, "test");
import org.opensearch.core.index.Index;
        TieringValidationResult tieringValidationResult = new TieringValidationResult(indices);
        assertEquals(indices, tieringValidationResult.getRejectedIndices().keySet());
        String indexName = "test_index";
        IllegalArgumentException e = expectThrows(
        int noOfNodes = 2;
    public void testIndexWithOngoingOrCompletedTiering() {
}
import org.opensearch.cluster.routing.RoutingTable;
    }
            .build();
