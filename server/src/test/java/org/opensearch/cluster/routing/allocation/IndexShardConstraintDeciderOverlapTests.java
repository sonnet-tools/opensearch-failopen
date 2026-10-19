        }  
     * <p>  
     */
        }
            .add(newNode("old_node", VersionUtils.getPreviousVersion()));  
import org.opensearch.test.VersionUtils;
        @Override  
package org.opensearch.cluster.routing.allocation;
            .put("cluster.routing.allocation.node_concurrent_recoveries", 1)
    }
import org.opensearch.cluster.OpenSearchAllocationWithConstraintsTestCase;
    public static class DevNullClusterInfo extends ClusterInfo {
            .build();
import org.opensearch.cluster.ClusterInfoService;
        allocateAndCheckIndexShardHotSpots(false, 6);  
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
        final Map<String, DiskUsage> usages = new HashMap<>();
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
    /**
        for (ShardRouting shard : clusterState.getRoutingTable().index("big_index_0").shardsWithState(STARTED)) {
import org.opensearch.cluster.ClusterState;  
        clusterState = ClusterState.builder(clusterState).nodes(nb.build()).build();
     * New version shards should not migrate to old version nodes, even if this creates potential hot spots.
            super(leastAvailableSpaceUsage, mostAvailableSpaceUsage, shardSizes, null, reservedSpace, Map.of(), nodeResourceUsageStats);  
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
        usages.put("node_0", new DiskUsage("node_0", "node_0", "/dev/null", 100, 80)); // 20% used
    }
/*  
     * Test zone aware clusters with unbalanced zones.
            assertNotEquals("node_0", shard.currentNodeId());
        setupInitialCluster(3, 6, 10, 1);
        final ClusterInfo bigIndexClusterInfo = new DevNullClusterInfo(usages, usages, null, bigIndexShardSizes, reservedSpace);
            assertNotEquals("old_node", shard.currentNodeId());
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
        addNodesWithIndexing(1, "high_watermark_node_", 6, 5, 1);  
        buildZoneAwareAllocationService();
        }  
        createEmptyZoneAwareCluster(nodesPerZone);
import org.opensearch.core.index.shard.ShardId;  
    public void testZoneBalanced() {
            return "/dev/null";
            final Map<String, DiskUsage> mostAvailableSpaceUsage,
            final Map<String, DiskUsage> leastAvailableSpaceUsage,  
        // Add an old version node and exclude a new version node
        nodesPerZone.put("zone_0", 3);  
 * SPDX-License-Identifier: Apache-2.0
    private ClusterInfo.ReservedSpace getReservedSpace() {
     * This test verifies that this doesn't lead to unassigned shards, and there are no hot spots in eligible
import java.util.HashMap;
        usages.put("high_watermark_node_0", new DiskUsage("high_watermark_node_0", "high_watermark_node_0", "/dev/null", 100, 10)); // 90%
                                                                                                                            // is 1
    }  
        reservedSpace.put(getNodeAndDevNullPath("high_watermark_node_0"), getReservedSpace());
     */  
    /**  
     * nodes.
    /**  
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
        // Build Shard size and disk usages  
import org.opensearch.cluster.node.DiscoveryNodes;  
        clusterState.getRoutingNodes().unassigned().forEach(shard -> bigIndexShardSizes.put(shardIdentifierFromRouting(shard), 20L));  
        addIndices("big_index_", 1, 10, 0);
 * compatible open source license.
import java.util.Map;
        buildZoneAwareAllocationService();
     * High watermark breach blocks new shard allocations to affected nodes. If shard count on such
        updateInitialCluster();
        return new ClusterInfo.ReservedSpace.Builder().add(new ShardId("", "", 0), 2).build();  
        return new ClusterInfo.NodeAndPath(node, "/dev/null");
        clusterState.getRoutingTable().allShards().forEach(shard -> shardSizes.put(shardIdentifierFromRouting(shard), 1L)); // Each
            final Map<String, NodeResourceUsageStats> nodeResourceUsageStats,
        allocateAndCheckIndexShardHotSpots(false, 2, "node_1", "node_2");
    public void testNodeVersionCompatibilityOverlap() {
        DiscoveryNodes.Builder nb = DiscoveryNodes.builder(clusterState.nodes())
     * ClusterInfo that always points to DevNull.
        buildZoneAwareAllocationService();  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), 0.95)
        buildAllocationService("node_0");
import org.opensearch.cluster.DiskUsage;
        assertForIndexShardHotSpots(true, 4);  
        final Map<String, Long> bigIndexShardSizes = new HashMap<>(shardSizes);
        public DevNullClusterInfo(
                                                                                                                                    // used  
     */  
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, null, shardSizes, reservedSpace);
        addIndices("index_", 4, 5, 1);  
        usages.put("node_2", new DiskUsage("node_2", "node_2", "/dev/null", 100, 35)); // 65% used
 * The OpenSearch Contributors require contributions made to  
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
        Settings settings = Settings.builder()  
        // Disk threshold settings enabled
        // Shards should only go to remaining new version nodes
import org.opensearch.cluster.ClusterInfo;
     */  
        reservedSpace.put(getNodeAndDevNullPath("node_1"), getReservedSpace());
        clusterState = allocateShardsAndBalance(clusterState);
        cis = () -> bigIndexClusterInfo;
 *
    private ClusterInfo.NodeAndPath getNodeAndDevNullPath(String node) {
            final Map<NodeAndPath, ReservedSpace> reservedSpace
import org.opensearch.cluster.routing.ShardRouting;
        Map<String, Integer> nodesPerZone = new HashMap<>();  
            final Map<String, Long> shardSizes,  
     * No hot spots expected.
        clusterState = allocateShardsAndBalance(clusterState);
        reservedSpace.put(getNodeAndDevNullPath("node_2"), getReservedSpace());  
        buildZoneAwareAllocationService();
        resetCluster();  
     * Hot spots expected as awareness forces shards per zone restrictions.  
        usages.put("node_1", new DiskUsage("node_1", "node_1", "/dev/null", 100, 55)); // 45% used  
import org.opensearch.common.settings.Settings;
    }
        setupInitialCluster(3, 15, 10, 1);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        allocateAndCheckIndexShardHotSpots(false, 6);
        ) {
            assertNotEquals("node_2", shard.currentNodeId());  
        ClusterInfoService cis = () -> clusterInfo;  
    /**  
        assertForIndexShardHotSpots(true, 4);
public class IndexShardConstraintDeciderOverlapTests extends OpenSearchAllocationWithConstraintsTestCase {
    }
                                                                                                                            // byte
     * Test clusters with subset of nodes on older version.
    /**
        nodesPerZone.put("zone_1", 1);
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
    }
        addIndices("index_", 1, 5, 1);
import org.opensearch.node.NodeResourceUsageStats;
        allocateAndCheckIndexShardHotSpots(false, 3, "node_0", "node_1", "node_2");  
    public void testZoneUnbalanced() {
        allocation = createAllocationService(settings, cis);
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpace = new HashMap<>();  
                                                                                                                            // shard  
        createEmptyZoneAwareCluster(nodesPerZone);  
        final Map<String, Long> shardSizes = new HashMap<>();
 */  
        resetCluster();
        nodesPerZone.put("zone_1", 3);
        Map<String, Integer> nodesPerZone = new HashMap<>();
        assertForIndexShardHotSpots(true, 4);  
        /* Shard sizes that would breach high watermark on node_2 if allocated.
     * nodes is low, this will cause IndexShardPerNodeConstraint to breach.
        public String getDataPath(ShardRouting shardRouting) {
            .put("cluster.routing.allocation.cluster_concurrent_recoveries", 1)  
     * Test zone aware clusters with balanced zones.
        assertForIndexShardHotSpots(true, 6);  
        reservedSpace.put(getNodeAndDevNullPath("node_0"), getReservedSpace());
        assertForIndexShardHotSpots(true, 6);  
        allocateAndCheckIndexShardHotSpots(false, 2, "node_0", "node_1");
        assertTrue(clusterState.getRoutingNodes().node("high_watermark_node_0").isEmpty());  
         */  
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        }
     */  
    }
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)  
 * this file be licensed under the Apache-2.0 license or a
        allocation = createAllocationService(settings, cis);  
        nodesPerZone.put("zone_0", 5);
    public void testHighWatermarkBreachWithLowShardCount() {
}
