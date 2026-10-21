        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
        shardSizes.put("[test2][0][r]", 1000L);
        usages.put("node1", createDiskUsage("node1", 5000, 5000));
 * Licensed to Elasticsearch under one or more contributor
            .routingTable(routingTable)
import org.opensearch.cluster.ClusterName;
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
                node,
        RoutingTable routingTable = routingTableBuilder.build();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
            .build();
        // [test2][0][P] : STARTED on node2, [test2][0][R] : STARTED on node1
import java.util.HashMap;
        RoutingTable routingTable = routingTableBuilder.build();
        routingTableBuilder.add(indexRoutingTableBuilder3.build());
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
            .nodes(
        Metadata metadata = Metadata.builder()
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
    }
        clusterState = ClusterState.builder(clusterState)
                    new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
            .routingTable(routingTable)
            rn.shardsWithState(ShardRoutingState.INITIALIZING).size(),
        // [test2][0][P]: STARTED on node2, [test2][0][R]: STARTED on node1
            .metadata(metadata)
                    .add(newNode("node3", defaultWithWarmRole))
     * Tests that the WarmDiskThresholdDecider returns a NO decision when allocating a shard with insufficient available space.
        indexRoutingTableBuilder3.addShard(
        logger.info("--> adding two warm nodes");
        shardSizes.put("[test2][0][p]", 1000L);
        AllocationDeciders deciders = new AllocationDeciders(
import org.opensearch.cluster.DiskUsage;
            .build();
import org.opensearch.common.settings.ClusterSettings;
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        assertEquals(Decision.Type.NO, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
     */
        Settings settings = Settings.builder()
        Metadata metadata = Metadata.builder()
        }
        routingTableBuilder.add(indexRoutingTableBuilder.build());
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        );
import org.opensearch.cluster.routing.ShardRouting;
 *
        usages.put("node1", createDiskUsage("node1", 5000, 3000));
            .build();
        AllocationService strategy = new AllocationService(
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
        final Map<String, Long> shardSizes = new HashMap<>();
    public void testCanRemainRelocatingReplicaNotCredited() {
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
        final Map<String, DiskUsage> usages = new HashMap<>();
                    .add(newNode("node2", defaultWithWarmRole))
import org.opensearch.cluster.routing.allocation.AllocationService;
        final Map<String, DiskUsage> usages = new HashMap<>();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).addAsNew(metadata.index("test2")).build();
        shardSizes.put("[test2][0][r]", 1000L);
            .build();
        allocation.debugDecision(true);
    WarmDiskThresholdDecider makeDecider(Settings settings) {
 * GitHub history for details.
            "--> unassigned: {}, initializing: {}, relocating: {}, started: {}",
        Settings diskSettings = Settings.builder()
    }
        // [test][0][P]: STARTED on node1, [test][0][R]: STARTED on node2
        allocation.debugDecision(true);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
    private Map<String, AggregateFileCacheStats> createFileCacheStatsMap(long fileCacheSize, String... nodes) {
     */
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);
        // [test2][0][P]: STARTED on node2, [test2][0][R]: STARTED on node1
            .metadata(metadata)
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
        // Assert that test index shards (P and R) are not allocated due to insufficient space
            .build();
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
        return fileCacheStatsMap;
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
        assertEquals(Decision.Type.NO, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        routingTableBuilder.add(indexRoutingTableBuilder2.build());
            .build();
        Settings settings = Settings.builder()
        shardSizes.put("[test][0][r]", 2000L);
 * compatible open source license.
        indexRoutingTableBuilder3.addShard(TestShardRouting.newShardRouting("test3", 0, "node2", null, true, ShardRoutingState.STARTED));
        };
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
            .build();
            rn.shardsWithState(ShardRoutingState.RELOCATING),
            .build();
        AllocationDeciders deciders = new AllocationDeciders(
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
        // Test canRemain decisions
            new BalancedShardsAllocator(Settings.EMPTY),
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
public class WarmDiskThresholdDeciderTests extends OpenSearchAllocationTestCase {
        for (String node : nodes) {
     * A relocating REPLICA must not be credited as leaving remote space: only primaries own remote store bytes.
        routingTableBuilder.add(indexRoutingTableBuilder2.build());
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
            .metadata(metadata)
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
        AllocationService strategy = new AllocationService(
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
 * license agreements. See the NOTICE file distributed with
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
            .build();
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes
            TestShardRouting.newShardRouting("test3", 0, "node1", "node2", true, ShardRoutingState.RELOCATING)
            }
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
import java.util.HashSet;
            TestShardRouting.newShardRouting("test3", 0, "node1", "node3", false, ShardRoutingState.RELOCATING)
            deciders,
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                new AggregateFileCacheStats(
import org.opensearch.cluster.routing.ShardRoutingState;
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            cis,
            .metadata(metadata)
import org.opensearch.index.store.remote.filecache.FileCacheStats;
 * the Apache License, Version 2.0 (the "License"); you may
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
        shardSizes.put("[test2][0][r]", 1000L);
        usages.put("node1", createDiskUsage("node1", 5000, 0));
        IndexRoutingTable.Builder indexRoutingTableBuilder3 = IndexRoutingTable.builder(metadata.index("test3").getIndex());
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
            .routingTable(routingTable)
        shardSizes.put("[test][0][r]", 3000L);
        // The relocating replica on node1 is not credited, so node1 remains below the high watermark
import org.opensearch.cluster.routing.IndexRoutingTable;
        final Map<String, DiskUsage> usages = new HashMap<>();
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
        shardSizes.put("[test2][0][r]", 1000L);
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
                DiscoveryNodes.builder()
            .build();
        indexRoutingTableBuilder3.addShard(
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        Metadata metadata = Metadata.builder()
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
import org.opensearch.common.settings.Settings;
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
        // Create a RoutingTable with shards 0 and 1 initialized on node1, and shard 2 unassigned
            new TestGatewayAllocator(),
        logger.info("--> adding two warm nodes");
            new TestGatewayAllocator(),
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
     */
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        shardSizes.put("[test2][0][r]", 1000L);
     * A relocating primary of a NON-warm (LOCAL_ONLY) index must not be credited as leaving remote space.
            .build();
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        usages.put("node1", createDiskUsage("node1", 5000, 5000));
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
        // [test][0][P]: STARTED on node1, [test][0][R]: STARTED on node2
        allocation.debugDecision(true);
            )
 *
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
            fileCacheStatsMap.put(
     * @return a map of node ID to AggregateFileCacheStats
 * this file be licensed under the Apache-2.0 license or a
                assertThat(shardRouting.state(), equalTo(ShardRoutingState.UNASSIGNED));
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        shardSizes.put("[test][0][p]", 5500L); // 5500 bytes shard size and total addressable space - 5000 bytes
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        return new WarmDiskThresholdDecider(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
    }
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
            logger.info("--> calling fake getClusterInfo");
            .routingTable(routingTable)
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
     */
 * under the License.
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
        Metadata metadata = Metadata.builder()
            rn.shardsWithState(ShardRoutingState.STARTED).size()
    }
            .routingTable(routingTable)
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
/*
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(2));
import static org.hamcrest.Matchers.equalTo;
        shardSizes.put("[test3][0][p]", 1500L);
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
     * stays at 500b free (below the 200b x 5.0 = 1000b high watermark) and the decision must be NO.
import org.opensearch.cluster.metadata.Metadata;
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
        for (ShardRouting shardRouting : clusterState.getRoutingNodes().unassigned()) {
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2", "node3");
        final Map<String, DiskUsage> usages = new HashMap<>();
        // For high watermark of 250b, we set free space < 250b to trigger NO decision
            EmptySnapshotsInfoService.INSTANCE
            rn.shardsWithState(ShardRoutingState.UNASSIGNED).size(),
            // regular (LOCAL_ONLY) index
        );
        routingTableBuilder.add(indexRoutingTableBuilder2.build());
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
        shardSizes.put("[test][0][p]", 5500L); // Shard size more than total addressable space - 5000 bytes
import org.opensearch.cluster.ClusterInfoService;
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
        final Map<String, Long> shardSizes = new HashMap<>();
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
     * @param fileCacheSize the size of the file cache
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes
            .build();
        );
        Metadata metadata = Metadata.builder()
        usages.put("node1", createDiskUsage("node1", 5000, 500));
        shardSizes.put("[test][0][p]", 2000L); // 2000 bytes
        final Map<String, Long> shardSizes = new HashMap<>();
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(2));
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
 * ownership. Elasticsearch licenses this file to you under
            .build();
        ClusterInfoService cis = () -> {
            new BalancedShardsAllocator(Settings.EMPTY),
import org.opensearch.cluster.node.DiscoveryNodeRole;
        );
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes
        indexRoutingTableBuilder3.addShard(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(2));
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
            return clusterInfo;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
        shardSizes.put("[test2][0][r]", 1000L);
 * SPDX-License-Identifier: Apache-2.0
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
            rn.shardsWithState(ShardRoutingState.RELOCATING).size(),
        shardSizes.put("[test][0][r]", 5500L);
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);
        // We need enough free space to handle relocation - with [test3][0][p] relocating away,
        );
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
        RoutingNodes rn = state.getRoutingNodes();
    public void testCanAllocateInSufficientFreeSpace() {
        final Map<String, DiskUsage> usages = new HashMap<>();
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
import org.opensearch.cluster.routing.TestShardRouting;
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    /**
        // [test3][0][P]: STARTED on node2, [test3][0][R]: RELOCATING from node1 to node3
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
        shardSizes.put("[test][0][r]", 3000L);
     */
            .build();
        );
 * Modifications Copyright OpenSearch Contributors. See
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
 * software distributed under the License is distributed on an
        // [test][0][P]: STARTED on node1, [test][0][R]: STARTED on node2
    public void testCanRemainInsufficientSpace() {
    public void testCanAllocateSufficientFreeSpace() {
        logShardStates(clusterState);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "250b")
        Metadata metadata = Metadata.builder()
        final Map<String, DiskUsage> usages = new HashMap<>();
}
import org.opensearch.test.gateway.TestGatewayAllocator;
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        shardSizes.put("[test][0][r]", 5500L);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
        Settings settings = Settings.builder()
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            );
        shardSizes.put("[test][0][p]", 3000L);
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
        assertEquals(Decision.Type.NO, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        return new DiskUsage(nodeId, nodeId, "/dev/null", totalBytes, freeBytes);
     * @param nodes the node IDs to create stats for
    /**
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
 *
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
            .build();
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
import org.opensearch.cluster.routing.RoutingNodes;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            .routingTable(routingTable)
 * Unless required by applicable law or agreed to in writing,
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        shardSizes.put("[test3][0][p]", 1500L);
            rn.shardsWithState(ShardRoutingState.INITIALIZING),
     */
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
        // [test][0][P] : STARTED on node1, [test][0][R] : STARTED on node2
     * Creates a standard FileCacheStats map for testing with warm nodes.
        final Map<String, Long> shardSizes = new HashMap<>();
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
    /**
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = new HashMap<>();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        Settings diskSettings = Settings.builder()
        final Map<String, Long> shardSizes = new HashMap<>();
            if (shardRouting.index().getName().equals("test")) {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
        routingTableBuilder.add(indexRoutingTableBuilder3.build());
            .metadata(metadata)
                    .add(newNode("node1", defaultWithWarmRole))
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
import org.opensearch.cluster.routing.RoutingTable;
        // [test3][0][P]: RELOCATING from node1
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
/*
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        usages.put("node2", createDiskUsage("node2", 5000, 5000));
            rn.shardsWithState(ShardRoutingState.STARTED)
        // Test canRemain decisions with [test3][0][p] relocating from node1
            deciders,
    /**
     * from node1, so node1 stays at 500b free (below the 200b x 5.0 = 1000b high watermark) and the decision must be NO.
            .build();
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        // Test canRemain decisions
            TestShardRouting.newShardRouting("test3", 0, "node1", "node2", true, ShardRoutingState.RELOCATING)
 * this work for additional information regarding copyright
            .metadata(metadata)
        final Map<String, Long> shardSizes = new HashMap<>();
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
        }
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
        routingTableBuilder.add(indexRoutingTableBuilder2.build());
                    new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
        // For 70% low watermark, we need at least 30% free = 1500 bytes free
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
        shardSizes.put("[test][0][p]", 3000L); // 3000 bytes
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
            rn.shardsWithState(ShardRoutingState.UNASSIGNED),
package org.opensearch.cluster.routing.allocation.decider;
        clusterState = ClusterState.builder(clusterState)
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
        Settings settings = Settings.builder()
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
        Metadata metadata = Metadata.builder()
    }
import org.opensearch.cluster.ClusterInfo;
        RoutingTable routingTable = routingTableBuilder.build();
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * You may obtain a copy of the License at
                )
        );
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
        shardSizes.put("[test][0][p]", 3000L);
    public void testCanRemainSufficientSpaceAfterRelocation() {
            .put(IndexMetadata.builder("test3").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
import org.opensearch.cluster.metadata.IndexMetadata;
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes
                    new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
        shardSizes.put("[test][0][r]", 3000L);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);
     * Same fixture as {@link #testCanRemainSufficientSpaceAfterRelocation} but [test3] is a regular index, so node1
        shardSizes.put("[test][0][r]", 2000L);
        IndexRoutingTable.Builder indexRoutingTableBuilder3 = IndexRoutingTable.builder(metadata.index("test3").getIndex());
        // node1 is below the 1000b high watermark; only a credited leaving PRIMARY could lift it above
            .build();
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes
    }
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
        usages.put("node2", createDiskUsage("node2", 5000, 5000));
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
        usages.put("node3", createDiskUsage("node3", 5000, 4000));
            "--> counts: total: {}, unassigned: {}, initializing: {}, relocating: {}, started: {}",
            .metadata(metadata)
            .build();
        ClusterInfoService cis = () -> {
    }
            EmptySnapshotsInfoService.INSTANCE
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
        final Map<String, Long> shardSizes = new HashMap<>();
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
    }
     * Tests that the WarmDiskThresholdDecider returns a YES decision when allocating a shard with available space.
            return clusterInfo;
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
            rn.shards(shard -> true).size(),
    public void testCanRemainSufficientSpace() {
        );
        };
        logShardStates(clusterState);
        IndexRoutingTable.Builder indexRoutingTableBuilder3 = IndexRoutingTable.builder(metadata.index("test3").getIndex());
    /**
    public void testCanRemainRelocatingNonWarmPrimaryNotCredited() {
     * Creates a DiskUsage with the specified free bytes and total bytes.
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
        usages.put("node1", createDiskUsage("node1", 5000, 500));
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
        final Map<String, DiskUsage> usages = new HashMap<>();
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
    public void logShardStates(ClusterState state) {
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
            .build();
        Settings settings = Settings.builder()
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
        RoutingTable routingTable = routingTableBuilder.build();
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        RoutingTable routingTable = routingTableBuilder.build();
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertEquals(Decision.Type.YES, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
        allocation.debugDecision(true);
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
        // Test shard is 5500 bytes, which exceeds the total addressable space
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
        usages.put("node1", createDiskUsage("node1", 5000, 500));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes
            .build();
 */
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        );
            .build();
        // [test3][0][P] (non-warm): RELOCATING from node1
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
        // node1 will gain 1500b of free space
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).addAsNew(metadata.index("test2")).build();
        // The relocating non-warm primary on node1 is not credited, so node1 remains below the high watermark
        shardSizes.put("[test2][0][p]", 1000L);
import java.util.Map;
        // [test2][0][P]: STARTED on node2, [test2][0][R]: STARTED on node1
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
import java.util.Arrays;
    }
                    randomNonNegativeInt(),
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
        shardSizes.put("[test3][0][r]", 1500L);
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
        // node1 is below the 1000b high watermark; only a credited leaving WARM primary could lift it above
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(2));
import org.opensearch.cluster.node.DiscoveryNodes;
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        allocation.debugDecision(true);
        // [test2][0][P]: STARTED on node2, [test2][0][R]: STARTED on node1
        shardSizes.put("[test3][0][p]", 1500L);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
/*
        assertEquals(Decision.Type.YES, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        routingTableBuilder.add(indexRoutingTableBuilder2.build());
        shardSizes.put("[test2][0][r]", 1000L);
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        logger.info(
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
 */
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
            .routingTable(routingTable)
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
import org.opensearch.cluster.ClusterState;
    }
            .build();
 * The OpenSearch Contributors require contributions made to
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
            .put(IndexMetadata.builder("test3").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        routingTableBuilder.add(indexRoutingTableBuilder3.build());
import org.opensearch.Version;
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
    private DiskUsage createDiskUsage(String nodeId, long totalBytes, long freeBytes) {
            cis,
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
        logger.info(
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
            .build();
        // [test][0][P]: STARTED on node1, [test][0][R]: STARTED on node2
        shardSizes.put("[test][0][p]", 2000L); // 2000 bytes
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            logger.info("--> calling fake getClusterInfo");
            .put(IndexMetadata.builder("test3").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
 * not use this file except in compliance with the License.
import java.util.Set;
     * Same fixture as {@link #testCanRemainSufficientSpaceAfterRelocation} but [test3][0] is a replica relocating away
    }
                    new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
