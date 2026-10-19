            .build();  
        assertTrue(tieringValidationResult.getRejectedIndices().isEmpty());
                    Collections.emptyMap(),  
        assertEquals(200, getTotalAvailableBytesInWarmTier(diskUsages, Set.of("node-w0", "node-w1")));
        DiskThresholdSettings diskThresholdSettings = diskThresholdSettings("10b", "10b", "5b");  
import static org.opensearch.indices.tiering.TieringRequestValidator.validateIndexHealth;  
                .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT)  
        String indexName = "test_index";
                    Version.CURRENT
        Map<String, DiskUsage> diskUsages = diskUsages(1, 100, 50);
import java.util.Collections;  
        shardSizes.put("[test_index][0][p]", 10L); // 10 bytes
    public void testEligibleNodes() {
    public void testValidateWarmNodes() {
            );  
            .build();
        ClusterInfo clusterInfo = new ClusterInfo(diskUsages, null, shardSizes, null, null, Map.of(), Map.of());  
            indexUuid,  
                    "node-i" + i,
        ClusterInfo clusterInfo = clusterInfo(noOfNodes, 100, 20);  
import org.opensearch.cluster.DiskUsage;  
        assertTrue(validateHotIndex(buildClusterState(indexName, indexUuid, Settings.EMPTY), new Index(indexName, indexUuid)));
    }
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 1)  
                )
        ClusterInfo clusterInfo = new ClusterInfo(diskUsages, null, shardSizes, null, null, Map.of(), Map.of());
        for (int i = 0; i < numOfDataNodes; i++) {
        String indexName = "test_index";  
    private static ClusterState buildClusterState(String indexName, String indexUuid, Settings settings, IndexMetadata.State state) {  
            .build();
                new DiscoveryNode(
        );
            Settings.builder()
        String indexUuid = UUID.randomUUID().toString();
        for (int i = 0; i < noOfWarmNodes; i++) {  
        return new DiskThresholdSettings(
        assertEquals(indices.size(), tieringValidationResult.getRejectedIndices().size());  
import org.opensearch.test.OpenSearchTestCase;
                new DiscoveryNode(  
    public void testValidateDiskThresholdWaterMarkNotBreached() {  
            Settings.builder().put(IndexModule.INDEX_TIERING_STATE.getKey(), tieringState).build()
            .build();
import org.opensearch.cluster.ClusterInfo;  
        assertTrue(tieringValidationResult.getAcceptedIndices().isEmpty());
    }  
        return new ClusterInfo(diskUsages, null, null, null, null, Map.of(), Map.of());
import java.util.UUID;
    }
        String indexUuid = UUID.randomUUID().toString();
            .nodes(createNodes(0, 1, 1))  
        validateEligibleNodesCapacity(clusterInfo, clusterState, tieringValidationResult);
        );
package org.opensearch.indices.tiering;
import static org.opensearch.indices.tiering.TieringRequestValidator.validateHotIndex;
                .build()
            IllegalArgumentException.class,
        }
                buildClusterState(indexName, indexUuid, Settings.EMPTY, IndexMetadata.State.CLOSE),  
            .routingTable(routingTable)  
    }
import static org.opensearch.indices.tiering.TieringRequestValidator.getEligibleNodes;  
/*  
        // throws no errors  
            discoveryNodesBuilder.add(  
                .put(CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), high)
        Map<String, DiskUsage> diskUsages = diskUsages(1, 100, 10);  
import org.opensearch.common.settings.ClusterSettings;
    }
        validateWarmNodes(clusterStateWithWarmNodes, "test_index");
                    "node-w" + i,  
 * compatible open source license.
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        String indexName = "test_index";  
        assertTrue(validateOpenIndex(buildClusterState(indexName, indexUuid, Settings.EMPTY), new Index(indexName, indexUuid)));
    private static ClusterInfo clusterInfo(int noOfNodes, long totalBytes, long freeBytes) {
        validateEligibleNodesCapacity(clusterInfo, clusterState, tieringValidationResult);  
        for (int i = 0; i < numOfIngestNodes; i++) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexModule;
    private static ClusterState buildClusterState(String indexName, String indexUuid, Settings settings) {
        return buildClusterState(indexName, indexUuid, settings, IndexMetadata.State.OPEN);  
    private DiscoveryNodes createNodes(int numOfWarmNodes, int numOfDataNodes, int numOfIngestNodes) {
    }  
    }
            .put(IndexMetadata.SETTING_INDEX_UUID, indexUuid)
 */  
        final Map<String, Long> shardSizes = new HashMap<>();
}
    }
        Settings combinedSettings = Settings.builder().put(settings).put(createDefaultIndexSettings(indexUuid)).build();
    }
        final Map<String, Long> shardSizes = new HashMap<>();
import java.util.HashMap;
        // throws error
    public void testValidateEligibleNodesCapacityWithAllRejected() {
    }
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        assertEquals(0, getEligibleNodes(clusterState).size());
                    Collections.emptyMap(),
        // throws error
            validateOpenIndex(
                    Version.CURRENT  
    public void testValidateDiskThresholdWaterMarkNotBreachedThrowsError() {  
    }
import java.util.Map;
                    "node-d" + i,
                .build(),  
    public void testValidHotIndex() {
            diskUsages.put("node-w" + i, new DiskUsage("node-w" + i, "node-w" + i, "/foo/bar", totalBytes, freeBytes));
        ClusterState clusterState = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY))
        Map<String, DiskUsage> diskUsages = diskUsages(1, 100, 50);
        String indexName = "test_index";  
                    Collections.singleton(DiscoveryNodeRole.WARM_ROLE),  
    }
        IllegalArgumentException e = expectThrows(  
import static org.opensearch.indices.tiering.TieringRequestValidator.validateOpenIndex;
            );
        assertEquals(10, getIndexPrimaryStoreSize(clusterState, clusterInfo, indexName));  
    }  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
public class TieringRequestValidatorTests extends OpenSearchTestCase {
        Set<Index> indices = Set.of(new Index(indexName, indexUuid));  
        int noOfNodes = 2;
        return Settings.builder()
            .build();
import org.opensearch.common.settings.Settings;  
    }  
            .build();
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testCloseIndex() {
        int noOfNodes = 2;
        DiskThresholdSettings diskThresholdSettings = diskThresholdSettings("10b", "10b", "5b");
                    Version.CURRENT
            IllegalArgumentException.class,  
    }
import org.opensearch.Version;
        Set<Index> indices = Set.of(new Index(indexName, indexUuid));
        final Map<String, Long> shardSizes = new HashMap<>();  
        return discoveryNodesBuilder.build();  
import org.opensearch.action.admin.indices.tiering.TieringValidationResult;
            .nodes(createNodes(2, 0, 0))  
        String indexUuid = UUID.randomUUID().toString();
import org.opensearch.cluster.ClusterState;
            )
        String indexUuid = UUID.randomUUID().toString();
    }
        assertEquals(indices, tieringValidationResult.getRejectedIndices().keySet());
                .put(CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), flood)
import static org.opensearch.indices.tiering.TieringRequestValidator.getIndexPrimaryStoreSize;
    public void testIndexWithOngoingOrCompletedTiering() {
                    buildNewFakeTransportAddress(),
 * The OpenSearch Contributors require contributions made to  
    private static DiskThresholdSettings diskThresholdSettings(String low, String high, String flood) {  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING;  
 *
        String indexUuid = UUID.randomUUID().toString();
            .metadata(metadata)
import org.opensearch.core.index.Index;
import org.opensearch.cluster.node.DiscoveryNodeRole;
        ClusterInfo clusterInfo = clusterInfo(noOfNodes, 100, 5);
        String indexName = "test_index";
import static org.opensearch.indices.tiering.TieringRequestValidator.validateDiskThresholdWaterMarkNotBreached;  
        }
            .build();
    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            .nodes(createNodes(1, 0, 0))
        validateDiskThresholdWaterMarkNotBreached(clusterState, clusterInfo, diskThresholdSettings, "test");  
        for (int i = 0; i < numOfWarmNodes; i++) {  
            indexName,
    public void testWithNoWarmNodesInCluster() {
            .nodes(createNodes(noOfNodes, 0, 0))  
import org.opensearch.cluster.node.DiscoveryNodes;
        String indexName = "test_index";
    }
        assertEquals(2, getEligibleNodes(clusterState).size());  
        TieringValidationResult tieringValidationResult = new TieringValidationResult(indices);
            .nodes(createNodes(0, 1, 1))  
import static org.opensearch.indices.tiering.TieringRequestValidator.validateRemoteStoreIndex;
        String indexName = "test_index";
                )  
    public void testGetTotalIndexSize() {
                    buildNewFakeTransportAddress(),  
        String indexUuid = UUID.randomUUID().toString();
        DiscoveryNodes.Builder discoveryNodesBuilder = DiscoveryNodes.builder();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index(indexName)).build();
        String indexUuid = UUID.randomUUID().toString();  
        ClusterInfo clusterInfo = new ClusterInfo(diskUsages, null, shardSizes, null, null, Map.of(), Map.of());
        ClusterState clusterState = buildClusterState(
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING;
        TieringValidationResult tieringValidationResult = new TieringValidationResult(indices);
                new DiscoveryNode(
        String indexName = "test_index";
        String indexUuid = UUID.randomUUID().toString();
                )
                    Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
            );
        ClusterState clusterState = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY))  
            indexUuid,  
                    Collections.singleton(DiscoveryNodeRole.INGEST_ROLE),
                new Index(indexName, indexUuid)
    public void testGetTotalAvailableBytesInWarmTier() {
        assertEquals(indices, tieringValidationResult.getAcceptedIndices());
        String indexName = "test_index";  
    public void testValidateEligibleNodesCapacityWithAllAccepted() {  
            .build();
        expectThrows(
        ClusterState clusterStateWithNoWarmNodes = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );  
            Settings.builder()
            discoveryNodesBuilder.add(
            discoveryNodesBuilder.add(
import org.opensearch.indices.replication.common.ReplicationType;  
            .nodes(createNodes(2, 0, 0))  
        IndexModule.TieringState tieringState = randomBoolean() ? IndexModule.TieringState.HOT_TO_WARM : IndexModule.TieringState.WARM;
import org.opensearch.cluster.metadata.Metadata;
            .build();
        clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        return diskUsages;  
import static org.opensearch.indices.tiering.TieringRequestValidator.getTotalAvailableBytesInWarmTier;
        String indexUuid = UUID.randomUUID().toString();
        final Map<String, DiskUsage> diskUsages = new HashMap<>();
        assertFalse(validateRemoteStoreIndex(buildClusterState(indexName, indexUuid, Settings.EMPTY), new Index(indexName, indexUuid)));
import static org.opensearch.indices.tiering.TieringRequestValidator.validateEligibleNodesCapacity;
    }
        shardSizes.put("[test_index][0][p]", 10L); // 10 bytes  
 * SPDX-License-Identifier: Apache-2.0
    }  
    }
        }
            indexName,
                .put(CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), low)  
        assertFalse(validateHotIndex(clusterState, new Index(indexName, indexUuid)));  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testValidOpenIndex() {
            () -> validateWarmNodes(clusterStateWithNoWarmNodes, "test")
        Metadata metadata = Metadata.builder().put(IndexMetadata.builder(indexName).settings(combinedSettings).state(state)).build();  
    }
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 2)
        Map<String, DiskUsage> diskUsages = diskUsages(2, 500, 100);  
        ClusterState clusterStateWithWarmNodes = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ClusterState clusterState = ClusterState.builder(buildClusterState(indexName, indexUuid, Settings.EMPTY))
            .nodes(createNodes(1, 0, 0))
        String indexUuid = UUID.randomUUID().toString();  
        );
        assertTrue(validateIndexHealth(clusterState, new Index(indexName, indexUuid)));
                    Collections.emptyMap(),
        ClusterState clusterState = buildClusterState(indexName, indexUuid, Settings.EMPTY);  
    }
        ClusterState clusterState1 = buildClusterState(
        final Map<String, DiskUsage> diskUsages = diskUsages(noOfNodes, totalBytes, freeBytes);  
        );
            .build();
            .put("index.version.created", Version.CURRENT)  
    private static Map<String, DiskUsage> diskUsages(int noOfWarmNodes, long totalBytes, long freeBytes) {
import org.opensearch.cluster.routing.RoutingTable;  
        assertFalse(
import org.opensearch.cluster.node.DiscoveryNode;  
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING;
        }  
                .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
import static org.opensearch.indices.tiering.TieringRequestValidator.validateWarmNodes;  
import org.opensearch.cluster.ClusterName;
import java.util.Set;  
            .nodes(createNodes(noOfNodes, 0, 0))  
        // throws no error
        assertTrue(validateRemoteStoreIndex(clusterState1, new Index(indexName, indexUuid)));
    private static Settings createDefaultIndexSettings(String indexUuid) {
        String indexName = "test_index";  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testValidateIndexHealth() {  
            .nodes(createNodes(1, 0, 0))  
    public void testValidRemoteStoreIndex() {  
                    buildNewFakeTransportAddress(),
            () -> validateDiskThresholdWaterMarkNotBreached(clusterState, clusterInfo, diskThresholdSettings, "test")
        );  
        shardSizes.put("[test_index][0][p]", 20L); // 20 bytes
    public void testDocRepIndex() {
            .build();
