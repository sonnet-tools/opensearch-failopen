import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.Version;
            TestShardRouting.newShardRouting("test3", 0, "node1", "node3", false, ShardRoutingState.RELOCATING)  
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);  
        // node1 will gain 1500b of free space
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
        // [test2][0][P]: STARTED on node2, [test2][0][R]: STARTED on node1
        allocation.debugDecision(true);
 * SPDX-License-Identifier: Apache-2.0
 *  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        );
        routingTableBuilder.add(indexRoutingTableBuilder3.build());
    /**
        return new DiskUsage(nodeId, nodeId, "/dev/null", totalBytes, freeBytes);
            .metadata(metadata)
            cis,  
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();  
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
     */
 * this work for additional information regarding copyright
            rn.shardsWithState(ShardRoutingState.INITIALIZING).size(),  
        // The relocating replica on node1 is not credited, so node1 remains below the high watermark
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);  
    public void testCanRemainSufficientSpaceAfterRelocation() {  
        // For 70% low watermark, we need at least 30% free = 1500 bytes free  
        RoutingTable routingTable = routingTableBuilder.build();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
    private Map<String, AggregateFileCacheStats> createFileCacheStatsMap(long fileCacheSize, String... nodes) {
        for (ShardRouting shardRouting : clusterState.getRoutingNodes().unassigned()) {
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
/*  
            .nodes(
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));  
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
            .metadata(metadata)
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
            .metadata(metadata)  
    /**  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(2));  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        final Map<String, DiskUsage> usages = new HashMap<>();
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
     */  
            .routingTable(routingTable)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            .build();
        );
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
    public void logShardStates(ClusterState state) {  
     * A relocating REPLICA must not be credited as leaving remote space: only primaries own remote store bytes.  
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
        return fileCacheStatsMap;  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
    /**  
        final Map<String, Long> shardSizes = new HashMap<>();  
        shardSizes.put("[test][0][r]", 2000L);
    }
import org.opensearch.cluster.ClusterInfoService;  
        final Map<String, DiskUsage> usages = new HashMap<>();  
 * this file be licensed under the Apache-2.0 license or a
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
        shardSizes.put("[test][0][r]", 5500L);  
        shardSizes.put("[test3][0][r]", 1500L);  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")  
        // node1 is below the 1000b high watermark; only a credited leaving PRIMARY could lift it above
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        routingTableBuilder.add(indexRoutingTableBuilder2.build());
        assertEquals(Decision.Type.YES, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
            rn.shardsWithState(ShardRoutingState.RELOCATING),
                    new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
        routingTableBuilder.add(indexRoutingTableBuilder2.build());  
        shardSizes.put("[test2][0][p]", 1000L);
     * from node1, so node1 stays at 500b free (below the 200b x 5.0 = 1000b high watermark) and the decision must be NO.
        shardSizes.put("[test2][0][p]", 1000L);  
            new TestGatewayAllocator(),
            rn.shardsWithState(ShardRoutingState.UNASSIGNED),  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
            .routingTable(routingTable)  
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        shardSizes.put("[test2][0][r]", 1000L);
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        final Map<String, Long> shardSizes = new HashMap<>();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        Settings settings = Settings.builder()
        indexRoutingTableBuilder3.addShard(TestShardRouting.newShardRouting("test3", 0, "node2", null, true, ShardRoutingState.STARTED));
    }
    public void testCanRemainInsufficientSpace() {
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());  
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
     */  
     * Tests that the WarmDiskThresholdDecider returns a YES decision when allocating a shard with available space.
import org.opensearch.cluster.metadata.Metadata;  
            EmptySnapshotsInfoService.INSTANCE
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes  
        logger.info("--> adding two warm nodes");
            .metadata(metadata)
        ClusterInfoService cis = () -> {
     * A relocating primary of a NON-warm (LOCAL_ONLY) index must not be credited as leaving remote space.
    private DiskUsage createDiskUsage(String nodeId, long totalBytes, long freeBytes) {  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
            .metadata(metadata)  
        );  
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)  
 * KIND, either express or implied.  See the License for the
        routingTableBuilder.add(indexRoutingTableBuilder2.build());
    }
        shardSizes.put("[test][0][p]", 2000L); // 2000 bytes
            .build();  
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)  
    }
        );  
        shardSizes.put("[test][0][p]", 3000L); // 3000 bytes  
 * Unless required by applicable law or agreed to in writing,
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))  
        clusterState = ClusterState.builder(clusterState)  
        shardSizes.put("[test][0][r]", 5500L);
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes  
            fileCacheStatsMap.put(
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
import org.opensearch.cluster.metadata.IndexMetadata;
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
     * Creates a DiskUsage with the specified free bytes and total bytes.
            new TestGatewayAllocator(),
import org.opensearch.cluster.routing.ShardRoutingState;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        allocation.debugDecision(true);
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);  
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
     * @param nodes the node IDs to create stats for
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),  
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        indexRoutingTableBuilder3.addShard(
            new BalancedShardsAllocator(Settings.EMPTY),
    }  
            logger.info("--> calling fake getClusterInfo");
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(2));
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
            );
            .build();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
        routingTableBuilder.add(indexRoutingTableBuilder2.build());
        // Test canRemain decisions
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
        IndexRoutingTable.Builder indexRoutingTableBuilder3 = IndexRoutingTable.builder(metadata.index("test3").getIndex());  
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
        final Map<String, Long> shardSizes = new HashMap<>();
            .put(IndexMetadata.builder("test3").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .build();
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();  
        indexRoutingTableBuilder3.addShard(
        shardSizes.put("[test][0][r]", 3000L);
        final Map<String, Long> shardSizes = new HashMap<>();  
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));  
                )  
                node,
/*  
        };
 *
        assertEquals(Decision.Type.NO, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
            new BalancedShardsAllocator(Settings.EMPTY),  
        // Test canRemain decisions with [test3][0][p] relocating from node1  
        final Map<String, DiskUsage> usages = new HashMap<>();
 * not use this file except in compliance with the License.
        // [test][0][P]: STARTED on node1, [test][0][R]: STARTED on node2  
                    .add(newNode("node1", defaultWithWarmRole))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        routingTableBuilder.add(indexRoutingTableBuilder.build());  
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = new HashMap<>();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
    /**  
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());  
     * Same fixture as {@link #testCanRemainSufficientSpaceAfterRelocation} but [test3][0] is a replica relocating away
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);
            return clusterInfo;
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
        final Map<String, DiskUsage> usages = new HashMap<>();
        shardSizes.put("[test2][0][r]", 1000L);
import org.opensearch.common.settings.Settings;
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
    public void testCanAllocateInSufficientFreeSpace() {  
        routingTableBuilder.add(indexRoutingTableBuilder.build());  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
import org.opensearch.cluster.routing.allocation.AllocationService;  
        // [test2][0][P] : STARTED on node2, [test2][0][R] : STARTED on node1  
            rn.shards(shard -> true).size(),
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
                assertThat(shardRouting.state(), equalTo(ShardRoutingState.UNASSIGNED));  
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes
        usages.put("node3", createDiskUsage("node3", 5000, 4000));
        );
    }
        RoutingTable routingTable = routingTableBuilder.build();
            .metadata(metadata)
            TestShardRouting.newShardRouting("test3", 0, "node1", "node2", true, ShardRoutingState.RELOCATING)
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
        // [test3][0][P]: STARTED on node2, [test3][0][R]: RELOCATING from node1 to node3
 * The OpenSearch Contributors require contributions made to  
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);  
            rn.shardsWithState(ShardRoutingState.UNASSIGNED).size(),
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);  
            .build();
        Metadata metadata = Metadata.builder()
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
        usages.put("node2", createDiskUsage("node2", 5000, 5000));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")  
        final Map<String, DiskUsage> usages = new HashMap<>();
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));  
    public void testCanAllocateSufficientFreeSpace() {  
    /**  
        // [test3][0][P] (non-warm): RELOCATING from node1
     * @return a map of node ID to AggregateFileCacheStats
import org.opensearch.cluster.routing.RoutingTable;
        usages.put("node2", createDiskUsage("node2", 5000, 4000));
        Metadata metadata = Metadata.builder()
                    .add(newNode("node3", defaultWithWarmRole))  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)  
    }
 * the Apache License, Version 2.0 (the "License"); you may
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "250b")  
        shardSizes.put("[test2][0][r]", 1000L);
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        shardSizes.put("[test3][0][p]", 1500L);  
     * stays at 500b free (below the 200b x 5.0 = 1000b high watermark) and the decision must be NO.  
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes  
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;  
        Settings settings = Settings.builder()
import org.opensearch.cluster.routing.ShardRouting;  
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
        final Map<String, Long> shardSizes = new HashMap<>();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).addAsNew(metadata.index("test2")).build();
        shardSizes.put("[test2][0][r]", 1000L);  
        AllocationDeciders deciders = new AllocationDeciders(
     * Tests that the WarmDiskThresholdDecider returns a NO decision when allocating a shard with insufficient available space.
        }
            deciders,
    }
        shardSizes.put("[test][0][r]", 3000L);
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
        return new WarmDiskThresholdDecider(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
 * Modifications Copyright OpenSearch Contributors. See
        shardSizes.put("[test][0][r]", 2000L);
            .routingTable(routingTable)
            }
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
        shardSizes.put("[test2][0][r]", 1000L);
        shardSizes.put("[test][0][p]", 3000L);
        RoutingTable routingTable = routingTableBuilder.build();
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).addAsNew(metadata.index("test2")).build();  
        // node1 is below the 1000b high watermark; only a credited leaving WARM primary could lift it above
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
        shardSizes.put("[test3][0][p]", 1500L);
import java.util.HashMap;
        );
        final Map<String, Long> shardSizes = new HashMap<>();  
            .build();
     * Creates a standard FileCacheStats map for testing with warm nodes.
        shardSizes.put("[test2][0][r]", 1000L);
import org.opensearch.cluster.ClusterName;
        routingTableBuilder.add(indexRoutingTableBuilder3.build());
     */
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
            .routingTable(routingTable)
            .build();
        Settings settings = Settings.builder()  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")  
    public void testCanRemainSufficientSpace() {
        Metadata metadata = Metadata.builder()
            .routingTable(routingTable)  
import java.util.Set;
        logger.info("--> adding two warm nodes");
        assertEquals(Decision.Type.NO, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)  
import java.util.Map;
            .build();
                    .add(newNode("node2", defaultWithWarmRole))
        // [test2][0][P]: STARTED on node2, [test2][0][R]: STARTED on node1  
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);  
        // [test][0][P]: STARTED on node1, [test][0][R]: STARTED on node2
        usages.put("node2", createDiskUsage("node2", 5000, 5000));  
 */
import org.opensearch.cluster.routing.IndexRoutingTable;  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);  
        // [test][0][P]: STARTED on node1, [test][0][R]: STARTED on node2
        }
            .put(FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5.0)
     */
        // For high watermark of 250b, we set free space < 250b to trigger NO decision
            "--> unassigned: {}, initializing: {}, relocating: {}, started: {}",
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));  
            )
            .metadata(metadata)
        for (String node : nodes) {  
            TestShardRouting.newShardRouting("test3", 0, "node1", "node2", true, ShardRoutingState.RELOCATING)
        RoutingTable routingTable = routingTableBuilder.build();  
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            .build();  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
            rn.shardsWithState(ShardRoutingState.INITIALIZING),
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
/*
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));  
        allocation.debugDecision(true);
        usages.put("node1", createDiskUsage("node1", 5000, 5000));
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.RoutingNodes;
        usages.put("node1", createDiskUsage("node1", 5000, 500));  
        routingTableBuilder.add(indexRoutingTableBuilder.build());
            logger.info("--> calling fake getClusterInfo");  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "100b")
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
    }  
        allocation.debugDecision(true);
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
        allocation.debugDecision(true);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
package org.opensearch.cluster.routing.allocation.decider;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Settings settings = Settings.builder()
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");
        RoutingTable routingTable = routingTableBuilder.build();
        final Map<String, DiskUsage> usages = new HashMap<>();
        );  
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        logShardStates(clusterState);
        // [test][0][P]: STARTED on node1, [test][0][R]: STARTED on node2
        AllocationService strategy = new AllocationService(  
        AllocationService strategy = new AllocationService(
 * compatible open source license.
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);  
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
        usages.put("node1", createDiskUsage("node1", 5000, 5000));
            .build();  
        usages.put("node1", createDiskUsage("node1", 5000, 3000));
            .routingTable(routingTable)
public class WarmDiskThresholdDeciderTests extends OpenSearchAllocationTestCase {  
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);  
        assertEquals(Decision.Type.NO, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
            .build();  
            rn.shardsWithState(ShardRoutingState.STARTED)  
        shardSizes.put("[test][0][r]", 3000L);  
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");  
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes
import java.util.HashSet;  
        shardSizes.put("[test][0][p]", 3000L);
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        logger.info(
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;  
            .build();
                    new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
import org.opensearch.cluster.ClusterState;
    }
            deciders,  
     * Same fixture as {@link #testCanRemainSufficientSpaceAfterRelocation} but [test3] is a regular index, so node1
            rn.shardsWithState(ShardRoutingState.STARTED).size()
        usages.put("node1", createDiskUsage("node1", 5000, 500));  
        indexRoutingTableBuilder3.addShard(  
        // Create a RoutingTable with shards 0 and 1 initialized on node1, and shard 2 unassigned
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");  
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());  
        IndexRoutingTable.Builder indexRoutingTableBuilder3 = IndexRoutingTable.builder(metadata.index("test3").getIndex());
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
        routingTableBuilder.add(indexRoutingTableBuilder2.build());  
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));  
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));  
            .build();
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2");  
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
        WarmDiskThresholdDecider decider = new WarmDiskThresholdDecider(settings, clusterSettings);
                    randomNonNegativeInt(),
                new AggregateFileCacheStats(  
        shardSizes.put("[test][0][p]", 5500L); // 5500 bytes shard size and total addressable space - 5000 bytes  
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))  
        usages.put("node1", createDiskUsage("node1", 5000, 0));  
            if (shardRouting.index().getName().equals("test")) {
                DiscoveryNodes.builder()  
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
 */  
            .build();
import org.opensearch.cluster.ClusterInfo;
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        // Test canRemain decisions  
 * license agreements. See the NOTICE file distributed with
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
 * ownership. Elasticsearch licenses this file to you under  
        // [test2][0][P]: STARTED on node2, [test2][0][R]: STARTED on node1
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(2));
        assertEquals(Decision.Type.YES, decider.canRemain(shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());  
 * under the License.  
import org.opensearch.test.gateway.TestGatewayAllocator;
        IndexRoutingTable.Builder indexRoutingTableBuilder3 = IndexRoutingTable.builder(metadata.index("test3").getIndex());  
    /**
            return clusterInfo;  
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        };
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = createFileCacheStatsMap(1000L, "node1", "node2", "node3");
        routingTableBuilder.add(indexRoutingTableBuilder3.build());  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")  
        RoutingNodes rn = state.getRoutingNodes();
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node2", null, false, ShardRoutingState.STARTED));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
            .put(IndexMetadata.builder("test").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            EmptySnapshotsInfoService.INSTANCE
        shardSizes.put("[test][0][p]", 2000L); // 2000 bytes
        final Map<String, DiskUsage> usages = new HashMap<>();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "200b")
        usages.put("node1", createDiskUsage("node1", 5000, 500));  
            .build();
        final ClusterInfo clusterInfo = new DiskThresholdDeciderTests.DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
     * @param fileCacheSize the size of the file cache  
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes  
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // With file cache of 1000 bytes and ratio of 5.0, total addressable space = 1000 * 5 = 5000 bytes  
            rn.shardsWithState(ShardRoutingState.RELOCATING).size(),
        Metadata metadata = Metadata.builder()
            // regular (LOCAL_ONLY) index
import static org.hamcrest.Matchers.equalTo;
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import org.opensearch.cluster.routing.TestShardRouting;
            .build();
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
        Metadata metadata = Metadata.builder()
    WarmDiskThresholdDecider makeDecider(Settings settings) {
            .put(IndexMetadata.builder("test3").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        Settings diskSettings = Settings.builder()
        // Assert that test index shards (P and R) are not allocated due to insufficient space  
        logger.info(
                    new FileCacheStats(0, fileCacheSize, 0, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
            cis,
 *
import java.util.Arrays;
        assertEquals(Decision.Type.YES, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
 */  
        Settings settings = Settings.builder()  
            .routingTable(routingTable)
import org.opensearch.index.store.remote.filecache.FileCacheStats;  
        AllocationDeciders deciders = new AllocationDeciders(  
        indexRoutingTableBuilder2.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, false, ShardRoutingState.STARTED));
    }
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")
            .build();
    public void testCanRemainRelocatingNonWarmPrimaryNotCredited() {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // [test3][0][P]: RELOCATING from node1
        // [test2][0][P]: STARTED on node2, [test2][0][R]: STARTED on node1  
            .put(IndexMetadata.builder("test2").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        shardSizes.put("[test3][0][p]", 1500L);
            .build();  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "300b")  
            .build();  
}
 * software distributed under the License is distributed on an
            .build();
    public void testCanRemainRelocatingReplicaNotCredited() {
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));  
        // We need enough free space to handle relocation - with [test3][0][p] relocating away,
 * Licensed to Elasticsearch under one or more contributor  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        shardSizes.put("[test2][0][p]", 1000L); // 1000 bytes
        routingTableBuilder.add(indexRoutingTableBuilder.build());
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, clusterInfo, null, 0);
        // Test shard is 5500 bytes, which exceeds the total addressable space
        ClusterInfoService cis = () -> {
 * You may obtain a copy of the License at  
        // [test][0][P] : STARTED on node1, [test][0][R] : STARTED on node2
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(2));  
        Metadata metadata = Metadata.builder()
        final Map<String, Long> shardSizes = new HashMap<>();
        // The relocating non-warm primary on node1 is not credited, so node1 remains below the high watermark
import org.opensearch.cluster.DiskUsage;  
            "--> counts: total: {}, unassigned: {}, initializing: {}, relocating: {}, started: {}",  
            .build();
        shardSizes.put("[test][0][p]", 5500L); // Shard size more than total addressable space - 5000 bytes
        clusterState = ClusterState.builder(clusterState)
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
        logShardStates(clusterState);
        );  
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
        IndexRoutingTable.Builder indexRoutingTableBuilder2 = IndexRoutingTable.builder(metadata.index("test2").getIndex());
import org.opensearch.common.settings.ClusterSettings;
        Metadata metadata = Metadata.builder()
     */
        Settings diskSettings = Settings.builder()
        shardSizes.put("[test2][0][r]", 1000L);  
 * GitHub history for details.
            .put(IndexMetadata.builder("test3").settings(warmIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        ShardRouting shard2 = routingTable.index("test2").shard(0).primaryShard();
