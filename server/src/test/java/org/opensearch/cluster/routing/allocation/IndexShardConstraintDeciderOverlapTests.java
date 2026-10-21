        DiscoveryNodes.Builder nb = DiscoveryNodes.builder(clusterState.nodes())
     * Test zone aware clusters with balanced zones.
            assertNotEquals("node_2", shard.currentNodeId());
        createEmptyZoneAwareCluster(nodesPerZone);
import org.opensearch.cluster.ClusterState;
        ClusterInfoService cis = () -> clusterInfo;
/*
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
import org.opensearch.cluster.ClusterInfoService;
     * No hot spots expected.
            .add(newNode("old_node", VersionUtils.getPreviousVersion()));
 */
        // Disk threshold settings enabled
        }
     * Test zone aware clusters with unbalanced zones.
        reservedSpace.put(getNodeAndDevNullPath("node_1"), getReservedSpace());
        usages.put("high_watermark_node_0", new DiskUsage("high_watermark_node_0", "high_watermark_node_0", "/dev/null", 100, 10)); // 90%
    }
        buildZoneAwareAllocationService();
    public void testHighWatermarkBreachWithLowShardCount() {
     */
import org.opensearch.cluster.ClusterInfo;
                                                                                                                            // is 1
        clusterState = ClusterState.builder(clusterState).nodes(nb.build()).build();
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
                                                                                                                                    // used
        reservedSpace.put(getNodeAndDevNullPath("node_0"), getReservedSpace());
        addIndices("index_", 1, 5, 1);
                                                                                                                            // byte
        addIndices("big_index_", 1, 10, 0);
            .build();
     * Hot spots expected as awareness forces shards per zone restrictions.
     */
 * The OpenSearch Contributors require contributions made to
            final Map<String, NodeResourceUsageStats> nodeResourceUsageStats,
        usages.put("node_2", new DiskUsage("node_2", "node_2", "/dev/null", 100, 35)); // 65% used
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        // Shards should only go to remaining new version nodes
        public String getDataPath(ShardRouting shardRouting) {
    private ClusterInfo.ReservedSpace getReservedSpace() {
    /**
     * nodes.
        }
import org.opensearch.cluster.routing.ShardRouting;
     */
        resetCluster();
}
        clusterState = allocateShardsAndBalance(clusterState);
     */
        allocation = createAllocationService(settings, cis);
    }
            assertNotEquals("old_node", shard.currentNodeId());
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
    /**
     * ClusterInfo that always points to DevNull.
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
        nodesPerZone.put("zone_1", 1);
        updateInitialCluster();
        final ClusterInfo bigIndexClusterInfo = new DevNullClusterInfo(usages, usages, null, bigIndexShardSizes, reservedSpace);
 * compatible open source license.
        // Add an old version node and exclude a new version node
    }
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        for (ShardRouting shard : clusterState.getRoutingTable().index("big_index_0").shardsWithState(STARTED)) {
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        addIndices("index_", 4, 5, 1);
        assertForIndexShardHotSpots(true, 4);
import org.opensearch.cluster.DiskUsage;
        usages.put("node_1", new DiskUsage("node_1", "node_1", "/dev/null", 100, 55)); // 45% used
        setupInitialCluster(3, 6, 10, 1);
    public void testZoneBalanced() {
        allocateAndCheckIndexShardHotSpots(false, 3, "node_0", "node_1", "node_2");
            final Map<String, Long> shardSizes,
package org.opensearch.cluster.routing.allocation;
        clusterState = allocateShardsAndBalance(clusterState);
import org.opensearch.cluster.node.DiscoveryNodes;
        assertForIndexShardHotSpots(true, 6);
import java.util.HashMap;
            super(leastAvailableSpaceUsage, mostAvailableSpaceUsage, shardSizes, null, reservedSpace, Map.of(), nodeResourceUsageStats);
        return new ClusterInfo.NodeAndPath(node, "/dev/null");
        buildZoneAwareAllocationService();
    private ClusterInfo.NodeAndPath getNodeAndDevNullPath(String node) {
        allocateAndCheckIndexShardHotSpots(false, 6);
        buildAllocationService("node_0");
     * nodes is low, this will cause IndexShardPerNodeConstraint to breach.
public class IndexShardConstraintDeciderOverlapTests extends OpenSearchAllocationWithConstraintsTestCase {
        final Map<String, DiskUsage> usages = new HashMap<>();
    }
        nodesPerZone.put("zone_0", 3);
        cis = () -> bigIndexClusterInfo;
        }
        Settings settings = Settings.builder()
    public static class DevNullClusterInfo extends ClusterInfo {
        Map<String, Integer> nodesPerZone = new HashMap<>();
         */
     * This test verifies that this doesn't lead to unassigned shards, and there are no hot spots in eligible
    }
        final Map<String, Long> shardSizes = new HashMap<>();
        allocateAndCheckIndexShardHotSpots(false, 2, "node_1", "node_2");
        return new ClusterInfo.ReservedSpace.Builder().add(new ShardId("", "", 0), 2).build();
        allocation = createAllocationService(settings, cis);
     * <p>
        buildZoneAwareAllocationService();
        nodesPerZone.put("zone_1", 3);
    public void testZoneUnbalanced() {
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
import org.opensearch.node.NodeResourceUsageStats;
        assertForIndexShardHotSpots(true, 6);
        }
        allocateAndCheckIndexShardHotSpots(false, 6);
    }
            .put("cluster.routing.allocation.cluster_concurrent_recoveries", 1)
        final Map<String, Long> bigIndexShardSizes = new HashMap<>(shardSizes);
        createEmptyZoneAwareCluster(nodesPerZone);
        assertForIndexShardHotSpots(true, 4);
    /**
        reservedSpace.put(getNodeAndDevNullPath("node_2"), getReservedSpace());
import java.util.Map;
    /**
    /**
            final Map<String, DiskUsage> mostAvailableSpaceUsage,
        clusterState.getRoutingNodes().unassigned().forEach(shard -> bigIndexShardSizes.put(shardIdentifierFromRouting(shard), 20L));
        @Override
        reservedSpace.put(getNodeAndDevNullPath("high_watermark_node_0"), getReservedSpace());
        allocateAndCheckIndexShardHotSpots(false, 2, "node_0", "node_1");
     * New version shards should not migrate to old version nodes, even if this creates potential hot spots.
import org.opensearch.cluster.OpenSearchAllocationWithConstraintsTestCase;
            final Map<NodeAndPath, ReservedSpace> reservedSpace
        setupInitialCluster(3, 15, 10, 1);
     * Test clusters with subset of nodes on older version.
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
        usages.put("node_0", new DiskUsage("node_0", "node_0", "/dev/null", 100, 80)); // 20% used
        assertForIndexShardHotSpots(true, 4);
    public void testNodeVersionCompatibilityOverlap() {
        nodesPerZone.put("zone_0", 5);
        // Build Shard size and disk usages
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), 0.95)
 *
        resetCluster();
import org.opensearch.core.index.shard.ShardId;
        /* Shard sizes that would breach high watermark on node_2 if allocated.
        public DevNullClusterInfo(
        buildZoneAwareAllocationService();
            .put("cluster.routing.allocation.node_concurrent_recoveries", 1)
import org.opensearch.test.VersionUtils;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(clusterState.getRoutingNodes().node("high_watermark_node_0").isEmpty());
                                                                                                                            // shard
            final Map<String, DiskUsage> leastAvailableSpaceUsage,
        assertTrue(clusterState.getRoutingTable().shardsWithState(UNASSIGNED).isEmpty());
        addNodesWithIndexing(1, "high_watermark_node_", 6, 5, 1);
        clusterState.getRoutingTable().allShards().forEach(shard -> shardSizes.put(shardIdentifierFromRouting(shard), 1L)); // Each
        ) {
    }
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, null, shardSizes, reservedSpace);
        Map<String, Integer> nodesPerZone = new HashMap<>();
            assertNotEquals("node_0", shard.currentNodeId());
            return "/dev/null";
import org.opensearch.common.settings.Settings;
        final Map<ClusterInfo.NodeAndPath, ClusterInfo.ReservedSpace> reservedSpace = new HashMap<>();
     */
     * High watermark breach blocks new shard allocations to affected nodes. If shard count on such
