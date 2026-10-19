            .metadata(metadata)
        Settings diskSettings = Settings.builder()
                new DevNullClusterInfo(  
            new BalancedShardsAllocator(Settings.EMPTY),  
        assertThat(decision.type(), equalTo(Decision.Type.NO));  
            )
            final Map<String, DiskUsage> leastAvailableSpaceUsage,  
        // Assert that all replicas could be started
            .build();
        fileCacheStatsMap.put(
        DiscoveryNode discoveryNode2 = new DiscoveryNode(
        logShardStates(clusterState);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        // Node5 is available now, so the shard is moved off of node2  
    public void testDiskThreshold() {  
        // assertThat(clusterState.getRoutingNodes().node(nodeWithPrimary).size(), equalTo(0));
        };
        ClusterInfoService cis = () -> {  
            new TestGatewayAllocator(),  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "30b")
        usages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 60)); // 40% used
                    new RestoreInProgressAllocationDecider(),
            .nodes(
            logger.info("--> simulating snapshot shards size retrieval success");
                new HashSet<>()
            new TestGatewayAllocator(),  
                new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
            );
import org.opensearch.test.gateway.TestGatewayAllocator;  
 * license agreements. See the NOTICE file distributed with
            deciders,  
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        routingAllocation.debugDecision(true);  
        );  
                    Map.of(
        ) {  
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 100)); // 0% used
                containsString("the node has fewer free bytes remaining than the total size of all incoming shards")
 * software distributed under the License is distributed on an
        final Map<SnapshotShard, Long> snapshotShardSizes = new HashMap<>();  
                )
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            )
        clusterState = ClusterState.builder(clusterState)  
        logShardStates(clusterState);
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
            .nodes(discoveryNodes)  
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().state(), equalTo(RELOCATING));
        // We have an index with 1 primary shards each taking 40 bytes. Each node has 100 bytes available
        logShardStates(clusterState);  
        usages.put("node2", new DiskUsage("node2", "node2", "/dev/null", 100, 35)); // 65% used  
            .build();  
            .build();  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
            deciders,
                expectThrows(IllegalArgumentException.class, () -> strategy.reroute(clusterStateThatRejectsCommands, cmds, false, false))  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "60%")
            new AggregateFileCacheStats(
        final Map<String, Long> shardSizes = new HashMap<>();  
        shardSizes.put("[test2][0][p]", 1L); // 1 bytes  
            .build();  
            .add(  
            clusterState.getRoutingNodes()
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
 *
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);  
                Arrays.asList(
            nodeWithoutPrimary = "node1";
            cis,
            "node2",
        RoutingNode firstRoutingNode = new RoutingNode("node1", discoveryNode1, firstRouting, secondRouting);
        logShardStates(clusterState);
    }
            EmptySnapshotsInfoService.INSTANCE
/*
        clusterState = ClusterState.builder(baseClusterState).routingTable(builder.build()).build();
        // Assert that we're able to start the primary  
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 40)); // 60% used  
            .nodes(
            rn.shardsWithState(STARTED)  
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));  
        ClusterState result = strategy.reroute(clusterState, "reroute");
                shardSizes,  
                        Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none").build(),
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
            return clusterInfo;
        clusterState = ClusterState.builder(clusterState)
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("node2", "n2", "/dev/null", 100, 30), 0L),  
        }  
        final IndexId indexId = new IndexId("_indexid_name", UUIDs.randomBase64UUID(random()));  
        final Map<String, Long> shardSizes = new HashMap<>();  
 * You may obtain a copy of the License at  
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
                Arrays.asList(  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(discoveryNode1).add(discoveryNode2).build();
        overfullUsages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 0));  // 100% used
import org.opensearch.cluster.routing.RoutingTable;
                containsString(  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        usages.put("node2", new DiskUsage("node2", "node2", "/dev/null", 100, 35)); // 65% used
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(1));
        // Set the high threshold to 70 instead of 80
        );
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
            .build();
            ((Decision.Single) decision).getExplanation(),
            .routingTable(routingTable)  
        AllocationService strategy = new AllocationService(
        diskSettings = Settings.builder()
        usages.put("node1", new DiskUsage("node1", "node1", "/dev/null", 100, 10)); // 90% used  
            final Map<String, Long> shardSizes,
 *  
        AllocationDeciders deciders = new AllocationDeciders(  
            return clusterInfo;
        logger.info("--> final cluster state:");
        Double after = decider.freeDiskPercentageAfterShardAssigned(
        final Map<String, DiskUsage> usages = new HashMap<>();
        // below checks are unnecessary as the primary shard is always assigned to node2 as BSA always picks up that node  
            new TestGatewayAllocator(),
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().state(), equalTo(STARTED));
        assertThat(shardRouting.relocatingNodeId(), nullValue());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logShardStates(clusterState);
        logShardStates(clusterState);  
            rn.shardsWithState(UNASSIGNED).size(),
                .map(ShardRouting::unassignedInfo)
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
        logger.info("--> adding node3");  
        String nodeWithPrimary, nodeWithoutPrimary;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
        {  
        shardSizes.put("[test][0][p]", 40L);
        strategy = new AllocationService(  
            "",  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
                new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
        }  
        );
        Metadata metadata = Metadata.builder()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            .build();  
        DiskThresholdDecider diskThresholdDecider = makeDecider(diskSettings);
            return clusterInfo;  
        firstRouting = TestShardRouting.newShardRouting("test", 0, "node2", null, true, ShardRoutingState.STARTED);
                    .numberOfReplicas(0)
            "node1",  
            .build();  
        );  
        RoutingTable initialRoutingTable = RoutingTable.builder()
            EmptySnapshotsInfoService.INSTANCE  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        logger.info("--> apply INITIALIZING shards");  
            this(leastAvailableSpaceUsage, mostAvailableSpaceUsage, null, shardSizes, Map.of(), nodeFileCacheStats);
        ClusterState clusterState = ClusterState.builder(new ClusterName(getTestName()))
            is(true)
            return "/dev/null";
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
import org.opensearch.core.index.Index;  
        shardSizes.put("[test][0][r]", 10L);
        shardSizes.put("[test][0][p]", 14L); // 14 bytes
            assertThat(
        // Assert that one replica is still unassigned  
}
            .build();  
                    makeDecider(diskSettings)
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
        final Map<String, Long> shardSizes = new HashMap<>();  
        final SnapshotShard snapshotShard = new SnapshotShard(snapshot, indexId, shardId);
                    .numberOfShards(1)
            .build();
    public void testDiskThresholdWithShardSizes() {
                metadata.index("test"),  
        ClusterState baseClusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
        );
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 1)); // 99% used
        ClusterState result = strategy.reroute(clusterState, "reroute");
        assertEquals(
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        logger.info("--> start the shards (primaries)");
                        Settings.EMPTY,
                ((Decision.Single) decision).getExplanation(),
                    ),
        );  
            new TestGatewayAllocator(),
            cis,
        strategy = new AllocationService(
            new DiskUsage("node1", "n1", "/dev/null", 100, 31), // 69% used
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
        assertThat(
                    "the node is above the high watermark cluster setting [cluster.routing.allocation.disk.watermark.high=70%], using "
        // Two shards consumes 80% of disk space in data node, but we have only one data node, shards should remain.  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        usages.put("node4", new DiskUsage("node4", "node4", "/dev/null", 100, 80)); // 20% used
            .put(IndexMetadata.builder("test").settings(remoteIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
    public void testForSingleDataNode() {  
            .build();
        );
        logShardStates(clusterState);
        usages.put("node3", new DiskUsage("node3", "node3", "/dev/null", 100, 60)); // 40% used
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));  
        AllocationDeciders deciders = new AllocationDeciders(
        shardSizes.put("[test][1][p]", 40L);  
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))  
        // first as both node1 and node2 have equal weight as both of them contain zero shards.
            .addAsNewRestore(
        DiscoveryNode discoveryNode2 = new DiscoveryNode(
            new TestGatewayAllocator(),
        DiscoveryNode discoveryNode3 = new DiscoveryNode(
            .routingTable(initialRoutingTable)
                // no shards on node3 since it has no free space  
        logger.info(
        final Map<String, Long> shardSizes = new HashMap<>();  
        shardSizes.put("[test][0][r]", 10L); // 10 bytes  
        assertThat(shardRouting.state(), equalTo(UNASSIGNED));
        logShardStates(clusterState);  
                    + "actual free: [20.0%]"
        );  
            new HashSet<>(
            EmptySnapshotsInfoService.INSTANCE
        logShardStates(clusterState);
        logger.info("--> adding node4");  
        final Map<String, Long> largerShardSizes = new HashMap<>();  
import org.opensearch.cluster.routing.RecoverySource;
        logger.info("--> start the shards");
            "data",
            );  
            assertThat(startedShardsWithOverfullDisk.size(), equalTo(4));
                    makeDecider(diskSettings)  
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
        final ClusterInfo overfullClusterInfo = new DevNullClusterInfo(overfullUsages, overfullUsages, largerShardSizes);  
import org.opensearch.cluster.routing.AllocationId;
        final ClusterInfoService clusterInfoService = () -> new DevNullClusterInfo(usages, usages, Map.of());
                    new SameShardAllocationDecider(
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
                    ),
                .stream()
            clusterState.getRoutingNodes()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));  
                .allMatch(unassignedInfo -> Reason.NEW_INDEX_RESTORED.equals(unassignedInfo.getReason())),
            deciders,  
        final Map<String, Long> shardSizes = new HashMap<>();
        logger.info("--> adding two nodes");  
 * compatible open source license.
            logger.info("--> calling fake getClusterInfo");  
            clusterInfoReference.set(overfullClusterInfo);
        snapshotShardSizeInfoRef.set(new SnapshotShardSizeInfo(snapshotShardSizes));
        // is still below the high watermark (unlike node3)
        logger.info("--> using shard size [{}]", shardSizeInBytes);  
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
                )  
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().relocatingNodeId(), equalTo("node3"));  
        // Two shards consuming each 80% of disk space while 70% is allowed, so shard 0 isn't allowed here
            new BalancedShardsAllocator(Settings.EMPTY),  
        final RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        }  
            )
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
                .map(ShardRouting::unassignedInfo)  
            null,  
import org.opensearch.cluster.node.DiscoveryNode;
            .metadata(metadata)
        );
            )  
        // node2 now should not have new shards allocated to it, but shards can remain  
        final Map<String, DiskUsage> usages = new HashMap<>();
        DiskThresholdDecider decider = makeDecider(Settings.EMPTY);
 * this file be licensed under the Apache-2.0 license or a
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));  
        logShardStates(clusterState);
            .metadata(metadata)  
        final boolean shouldAllocate;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),  
            null,  
import java.util.HashSet;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "5b")
    }
        clusterState = ClusterState.builder(clusterState)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    + "[cluster.routing.allocation.disk.watermark.high=70%] and there is less than the required [30.0%] free disk on node, "
        // Primary shard should be initializing, replica should not
        // A single shard is started on node1, even though it normally would not  
        );  
        strategy = new AllocationService(
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);  
            deciders,
        logShardStates(clusterState);  
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 100)); // 0% used  
        clusterState = strategy.reroute(clusterState, "reroute");
            Version.CURRENT  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
            final Map<String, DiskUsage> mostAvailableSpaceUsage,  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        // be allowed, because it's a primary that hasn't been allocated, and node1
        firstRoutingNode = new RoutingNode("node1", discoveryNode1, firstRouting, secondRouting);
        // Assert that the replica is initialized now that node3 is available with enough space  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "30b")
    public void testFreeDiskPercentageAfterShardAssigned() {
            rn.shardsWithState(INITIALIZING).size(),  
 */
        assertThat(clusterState.getRoutingNodes().node("node5").size(), equalTo(1));
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().currentNodeId(), equalTo("node2"));
            .put(DiskThresholdSettings.ENABLE_FOR_SINGLE_DATA_NODE.getKey(), true)
        // reroute triggers snapshot shard size fetching
        // Shards remain started  
        );
        Settings diskSettings = Settings.builder()
            );
                assertThat(shardRouting.toString(), shardRouting.currentNodeId(), oneOf("node2", "node3"));
            )
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;  
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
            .metadata(metadata)  
                    new SameShardAllocationDecider(
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                    "the node is above the low watermark cluster setting [cluster.routing.allocation.disk.watermark.low=60%], using more "
            emptyMap(),
            .build();  
            deciders,
        // assertThat(clusterState.getRoutingNodes().node(nodeWithoutPrimary).size(), equalTo(1));  
        DiscoveryNode clusterManagerNode = new DiscoveryNode(
            )  
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));  
        AllocationDeciders deciders = new AllocationDeciders(
        logger.info("--> apply INITIALIZING shards");
        );
        {
            .routingTable(initialRoutingTable)
            cis,
        assertThat(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)  
                    decider
        strategy = new AllocationService(
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
    }
            }
        AllocationService strategy = new AllocationService(  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(0));
            return clusterInfo;
        Settings diskSettings = Settings.builder()
        // Assert that node1 didn't get any shards because its disk usage is too high
            .nodes(
        // We have an index with 1 primary shard, taking 40 bytes. The single data node has only 20 bytes free.
                        Settings.EMPTY,
        usages.put("node3", new DiskUsage("node3", "node3", "/dev/null", 100, 60)); // 40% used
            emptyMap(),  
 *
        } else {  
        );
        // Primary shard should be initializing, replica should not
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
                containsString(
import org.opensearch.cluster.metadata.IndexMetadata;  
        );
        DiskThresholdDecider decider = makeDecider(diskSettings);
        assertThat(decision.type(), equalTo(Decision.Type.YES));  
            buildNewFakeTransportAddress(),
        // Initializing on node5
import java.util.Arrays;
        );  
        Decision decision = diskThresholdDecider.canRemain(firstRouting, firstRoutingNode, routingAllocation);  
    public void testWatermarksEnabledForSingleDataNode() {  
            final Map<String, DiskUsage> mostAvailableSpaceUsage,
        // Set the high threshold to 60 instead of 70
        diskSettings = Settings.builder()  
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
        if (fooRouting.recoverySource().getType() == RecoverySource.Type.EMPTY_STORE) {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
                )
            .build();  
            );
            .build();  
        AllocationService strategy = new AllocationService(  
            .build();
            new BalancedShardsAllocator(Settings.EMPTY),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
        DiscoveryNodes discoveryNodes = discoveryNodesBuilder.build();  
        Decision decision = diskThresholdDecider.canRemain(firstRouting, firstRoutingNode, routingAllocation);
        logShardStates(clusterState);
import static java.util.Collections.singletonList;  
                        Settings.EMPTY,
        // as it randomises nodes to check for potential moves
            new HashSet<>(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        // Assert that the replica couldn't be started since node1 doesn't have enough space
        assertThat(  
        // shard cannot be assigned yet as the snapshot shard size is unknown  
                    new SameShardAllocationDecider(  
            AllocationCommand moveAllocationCommand = new MoveAllocationCommand("test2", 0, "node2", "node3");  
            singleton(DiscoveryNodeRole.DATA_ROLE),
        logger.info("--> changing decider settings");
        ClusterInfoService cis = () -> {
            "node1",
        // Assert that the replica couldn't be started since node1 doesn't have enough space
        strategy = new AllocationService(  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );  
    }  
            CLUSTER_MANAGER_DATA_ROLES,
import java.util.List;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "40b")  
        // Shards remain started on node3 and node4
        ShardRouting fooRouting = TestShardRouting.newShardRouting("foo", 0, null, true, ShardRoutingState.UNASSIGNED);  
            EmptySnapshotsInfoService.INSTANCE
        RoutingNode firstRoutingNode = new RoutingNode("node2", discoveryNode2, firstRouting, secondRouting);  
            logger.info("--> calling fake getClusterInfo");
            );
                0,
        logShardStates(clusterState);  
            clusterInfoReference.set(
        Decision decision = diskThresholdDecider.canRemain(startedShard, clusterState.getRoutingNodes().node("data"), routingAllocation);
                .map(ShardRouting::unassignedInfo)
                        + "disk space than the maximum allowed [60.0%], actual free: [20.0%]"
            CLUSTER_MANAGER_DATA_ROLES,  
        logger.info("--> apply INITIALIZING shards");
            EmptySnapshotsInfoService.INSTANCE
import java.util.concurrent.atomic.AtomicReference;
        );
        logger.info("--> start the shards (replicas)");
import static org.hamcrest.Matchers.equalTo;
        // node2 now should not have new shards allocated to it, but shards can remain  
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(1));  
        DiskThresholdDecider diskThresholdDecider = makeDecider(diskSettings);
            new TestGatewayAllocator(),
            emptyMap(),
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
                DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")) // node2 is added because DiskThresholdDecider  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "70%")
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().relocatingNodeId(), nullValue());  
            cis,
        final AtomicReference<SnapshotShardSizeInfo> snapshotShardSizeInfoRef = new AtomicReference<>(SnapshotShardSizeInfo.EMPTY);
import java.util.Map;  
        assertThat(decision.type(), equalTo(Decision.Type.NO));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));  
                mostAvailableSpaceUsage,
import org.opensearch.index.store.remote.filecache.FileCacheStats;
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        logger.info("--> nodeWithoutPrimary: {}", nodeWithoutPrimary);
        assertThat(decision.type(), equalTo(Decision.Type.NO));
    /**
        RoutingTable forceAssignedRoutingTable = RoutingTable.builder()
        RoutingNodes rn = state.getRoutingNodes();
        // Primary should initialize, even though both nodes are over the limit initialize  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)  
            .build();  
import org.opensearch.snapshots.InternalSnapshotsInfoService.SnapshotShard;
                .stream()
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
                    .putInSyncAllocationIds(0, singleton(AllocationId.newInitializing().getId()))  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));  
            EmptySnapshotsInfoService.INSTANCE  
            .build();
        // No shards are started, no nodes have enough disk for allocation
        clusterState = strategy.reroute(clusterState, "reroute");  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
import static org.hamcrest.Matchers.containsString;  
            .routingTable(routingTable)  
            EmptySnapshotsInfoService.INSTANCE
            buildNewFakeTransportAddress(),
                IndexRoutingTable.builder(firstRouting.index())
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        // reroute uses the previous snapshot shard size
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().relocatingNodeId(), nullValue());  
            .put(IndexMetadata.builder("foo").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
            nodeWithoutPrimary = "node2";
            new BalancedShardsAllocator(Settings.EMPTY),  
        // One shard is relocating off of node1
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().state(), equalTo(RELOCATING));
        // node2 now should not have new shards allocated to it, and shards cannot remain
        logShardStates(clusterState);
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().currentNodeId(), equalTo("node2"));
            final Map<String, NodeResourceUsageStats> nodeResourceUsages,
            final ClusterState clusterStateThatRejectsCommands = clusterState;  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        logger.info("--> adding node5");
        ShardRouting secondRouting = TestShardRouting.newShardRouting("test", 1, "node1", null, true, ShardRoutingState.STARTED);
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(discoveryNode3))
        usages.put(nodeWithoutPrimary, new DiskUsage(nodeWithoutPrimary, "", "/dev/null", 100, 35)); // 65% used
        );
        Metadata metadata = Metadata.builder()
            new BalancedShardsAllocator(Settings.EMPTY),
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
                    + " [cluster.routing.allocation.disk.watermark.high=70%] and there is less than the required [30.0%] free disk on node,"
            Map<NodeAndPath, ReservedSpace> reservedSpace,  
    }
            .putCustom(RestoreInProgress.TYPE, restores.build())
                )  
            new BalancedShardsAllocator(Settings.EMPTY),
import org.opensearch.snapshots.Snapshot;  
            new HashSet<>(
            rn.shardsWithState(UNASSIGNED),  
import org.opensearch.cluster.node.DiscoveryNodes;
                    new EnableAllocationDecider(
            rn.shards(shard -> true).size(),
        }
        );
        ) {  
            )
/*  
        logger.info("--> nodeWithPrimary: {}", nodeWithPrimary);
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)  
            this(leastAvailableSpaceUsage, mostAvailableSpaceUsage, null, shardSizes, Map.of(), Map.of());
        };
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
        );  
    public void testCanRemainWithShardRelocatingAway() {
import org.opensearch.cluster.routing.RoutingNode;  
        logger.info("--> changing settings again");
import static org.hamcrest.Matchers.is;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "9b")
                        + "allowed [70.0%], actual free: [26.0%]"
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)  
 * the Apache License, Version 2.0 (the "License"); you may
            Version.CURRENT  
        assertThat(decision.type(), equalTo(Decision.Type.YES));  
        );
            .build();
import static java.util.Collections.emptyMap;
    }
        );  
            deciders,
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(4));
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;  
                    .addIndexShard(new IndexShardRoutingTable.Builder(secondRouting.shardId()).addShard(secondRouting).build())  
                    usages,
        final Map<String, Long> shardSizes = new HashMap<>();
            .add(  
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 10)); // 90% used
        // and therefor we will have sufficient disk space on node1.
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));  
            new AggregateFileCacheStats(  
            )  
            "cluster-manager",  
        clusterState = strategy.reroute(clusterState, "reroute");
        Map<String, DiskUsage> usages = new HashMap<>();
            new RoutingNodes(clusterState),
import org.opensearch.snapshots.SnapshotId;
                    diskThresholdDecider
            logger.info("--> simulating snapshot shards size retrieval failure");  
 * Modifications Copyright OpenSearch Contributors. See
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.5)
            Version.CURRENT
            new HashSet<>(
        routingAllocation.debugDecision(true);
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)  
            "node1",
        routingAllocation = new RoutingAllocation(null, new RoutingNodes(clusterState), clusterState, clusterInfo, null, System.nanoTime());  
        );  
        DevNullClusterInfo(
            new TestGatewayAllocator(),
            "--> counts: total: {}, unassigned: {}, initializing: {}, relocating: {}, started: {}",  
            .add(  
        final ShardId shardId = new ShardId(new Index("test", IndexMetadata.INDEX_UUID_NA_VALUE), 0);
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))  
        Settings diskSettings = Settings.builder()
            .build();
                        new ClusterInfo.NodeAndPath("node1", "/dev/null"),  
        DiscoveryNode discoveryNode1 = new DiscoveryNode(
            "",
        ) {
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        );
        final Map<String, DiskUsage> usages = new HashMap<>();
        ClusterState clusterState = ClusterState.builder(baseClusterState).routingTable(builder.build()).build();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)  
        shardSizes.put("[test][0][p]", 40L);  
        decision = diskThresholdDecider.canAllocate(fooRouting, firstRoutingNode, routingAllocation);
            assertThat(
            .routingTable(initialRoutingTable)  
        AllocationDeciders deciders = new AllocationDeciders(
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
            deciders,
        // Assert that we're able to start the primary and replica, since they were both initializing
            Version.CURRENT
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
                        new ClusterInfo.ReservedSpace.Builder().add(new ShardId("", "", 0), between(51, 200)).build()
import org.opensearch.repositories.IndexId;  
        );  
        DiskThresholdDecider diskThresholdDecider = makeDecider(diskSettings);
            deciders,
 * KIND, either express or implied.  See the License for the
            new HashSet<>(
        );
        clusterState = strategy.reroute(clusterState, "reroute");  
        logShardStates(clusterState);
        }
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
                expectThrows(IllegalArgumentException.class, () -> strategy.reroute(clusterStateThatRejectsCommands, cmds, false, false))  
        logger.info("--> adding node3");  
            "--> unassigned: {}, initializing: {}, relocating: {}, started: {}",
            deciders,
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            );
import org.opensearch.cluster.routing.RoutingNodes;
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
        logShardStates(clusterState);
            new HashSet<>(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 20));  // 80% used
            cis,  
                new RecoverySource.SnapshotRecoverySource("_restore_uuid", snapshot, Version.CURRENT, indexId),
            assertThat(
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
            new TestGatewayAllocator(),
        );
        assertThat(
        logShardStates(clusterState);  
            clusterInfo,
        // Set the low threshold to 60 instead of 70
        }
                    diskThresholdDecider
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));  
        // Assert that node1 got a single shard (the primary), even though its disk usage is too high
                IndexRoutingTable.builder(firstRouting.index())  
                    new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),  
        shardSizes.put("[test][1][p]", 40L);
                    new SameShardAllocationDecider(  
        AllocationDeciders deciders = new AllocationDeciders(
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                IndexRoutingTable.builder(firstRouting.index())
        Settings diskSettings = Settings.builder()
            deciders,  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "60%")
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
        AllocationService strategy = new AllocationService(  
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));  
        largerShardSizes.put("[test][0][p]", 14L);
        final Map<String, DiskUsage> overfullUsages = new HashMap<>();
            System.nanoTime()
            .build();
            new RestoreInProgress.Entry("_restore_uuid", snapshot, RestoreInProgress.State.INIT, singletonList("test"), shards)
        shardSizes.put("[test][0][r]", 14L);
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
                    .settings(settings(Version.CURRENT))  
            rn.shardsWithState(INITIALIZING),
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        logger.info("--> adding node3");
        );
        ShardRouting firstRouting = TestShardRouting.newShardRouting("test", 0, "node2", null, true, ShardRoutingState.STARTED);
 * Unless required by applicable law or agreed to in writing,
        clusterState = strategy.reroute(clusterState, "reroute");  
            "data",
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();  
                IndexRoutingTable.builder(shardId.getIndex())
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            is(true)
            .build();  
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().relocatingNodeId(), nullValue());  
import org.opensearch.cluster.ClusterInfoService;  
        builder = RoutingTable.builder()
        // Assert that the replica is initialized now that node3 is available with enough space  
        );
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))  
        // https://github.com/opensearch-project/OpenSearch/pull/15239/  
        );  
        logShardStates(clusterState);  
                                                                                     // automatically ignore single-node clusters
        final ClusterInfo clusterInfo2 = new DevNullClusterInfo(usages, usages, shardSizes);  
                Arrays.asList(  
        logShardStates(clusterState);
        ClusterState result = strategy.reroute(clusterState, "reroute");
        logger.info("--> changing settings again");
            logger.info("--> calling fake getClusterInfo");  
        } else {  
            deciders,
import org.opensearch.cluster.routing.TestShardRouting;
            cis,
        // We have an index with 2 primary shards each taking 40 bytes. Each node has 100 bytes available
        deciders = new AllocationDeciders(  
        if (randomBoolean()) {  
            );
        // Assert that the replica couldn't be started since node1 doesn't have enough space  
        ClusterInfoService cis = () -> {
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 10)); // 90% used  
    public void testDiskThresholdWithSnapshotShardSizes() {
    DiskThresholdDecider makeDecider(Settings settings) {
                IndexMetadata.builder("test")
            new BalancedShardsAllocator(Settings.EMPTY),
 * SPDX-License-Identifier: Apache-2.0
            buildNewFakeTransportAddress(),  
 */  
        logger.info("--> changing decider settings");
        final Map<String, DiskUsage> usages = new HashMap<>();
        logger.info("--> start the shards (primaries)");
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // Assert that we're able to start the primary and replicas
        // because it's a primary that's never been allocated before
            AllocationCommands cmds = new AllocationCommands(moveAllocationCommand);
            .addAsNew(metadata.index("test"))  
        final RestoreInProgress.Builder restores = new RestoreInProgress.Builder().add(  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));  
        logger.info("--> adding node1");  
                    .addIndexShard(new IndexShardRoutingTable.Builder(firstRouting.shardId()).addShard(firstRouting).build())  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            new BalancedShardsAllocator(Settings.EMPTY),  
                0,
    public void testDiskThresholdForRemoteShards() {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "60%")
        if (randomBoolean()) {  
        assertThat(decision.getExplanation(), containsString("there is only a single data node present"));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
        // node2 now should not have new shards allocated to it, and shards cannot remain  
    }
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 50)); // 50% used
    public void testDiskThresholdWithAbsoluteSizes() {  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            containsString("there is enough disk on this node for the shard to remain, free: [60b]")  
        );
            EmptySnapshotsInfoService.INSTANCE
                    ),
                        + "more disk space than the maximum allowed [70.0%], actual free: [20.0%]"  
            null,
        // One shard is relocating off of node2 now  
        }
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 40)); // 60% used
            clusterState = strategy.reroute(clusterState, cmds, false, false).getClusterState();  
        logger.info("--> adding node3");  
        usages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 0));  // 100% used  
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))  
            )  
        builder = RoutingTable.builder()
        );  
                        Settings.EMPTY,
        // Shards remain started
        shards.put(shardId, new RestoreInProgress.ShardRestoreStatus("node1"));
        // force assign shard and validate that it cannot remain.
        // Shards remain started
        clusterState = strategy.reroute(clusterState, "reroute");
            shouldAllocate = shardSizeInBytes < usages.get("node1").getFreeBytes();
        fileCacheStatsMap.put(
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("--> start the shards (replicas)");
                    ),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "60%")  
                    .addIndexShard(new IndexShardRoutingTable.Builder(secondRouting.shardId()).addShard(secondRouting).build())
            )  
        assertThat(  
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;  
        final Map<String, DiskUsage> usages = Map.of(
            .metadata(metadata)  
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
import static org.hamcrest.Matchers.oneOf;
            new TestGatewayAllocator(),
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            .routingTable(routingTable)
            new BalancedShardsAllocator(Settings.EMPTY),
        overfullUsages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 40)); // 60% used
            new DiskUsage("node2", "n2", "/dev/null", 100, 1)  
            clusterState,  
                )
            singleton(DiscoveryNodeRole.DATA_ROLE),  
import java.util.Set;
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        routingAllocation = new RoutingAllocation(null, new RoutingNodes(clusterState), clusterState, clusterInfo, null, System.nanoTime());  
        clusterState = ClusterState.builder(clusterState)
        );  
    public void logShardStates(ClusterState state) {  
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = new HashMap<>();
        RoutingTable.Builder builder = RoutingTable.builder()  
        deciders = new AllocationDeciders(
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        shardSizes.put("[test][0][r]", 10L);  
                .shardsWithState(UNASSIGNED)  
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
        shardSizes.put("[test][0][r]", 10L);  
            return clusterInfo;
        final AtomicReference<ClusterInfo> clusterInfoReference = new AtomicReference<>(clusterInfo);
        usages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 100)); // 0% used
            .build();
            cis,
                    + " actual free: [20.0%]"
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        final Map<String, DiskUsage> usages = new HashMap<>();
        };
        logger.info(
import org.opensearch.cluster.routing.ShardRoutingState;
        logShardStates(clusterState);
            .build();  
        );
                    .getMessage(),
        logger.info("--> adding node4");
        // Set the low threshold to 50 instead of 60
        // Set the high threshold to 60 instead of 70
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        // Now the replica should be able to initialize
            clusterInfo,
        // Assert that the replica is initialized now that node3 is available with enough space  
        final Map<String, Long> shardSizes = new HashMap<>();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.7)
                        clusterSettings  
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
        );
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            )  
        final RoutingTable routingTable = RoutingTable.builder()
                .shardsWithState(UNASSIGNED)
        // Assert that we're able to start the primary  
    static class DevNullClusterInfo extends ClusterInfo {
            cis,
    }
            "node3",  
        final Map<String, Long> shardSizes = new HashMap<>();
        // Set the low threshold to 50 instead of 60  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)  
        usages.put("node2", new DiskUsage("node2", "node2", "/dev/null", 100, 50)); // 50% used
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.6)  
        final RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
            )
                )
            .add(
        // Shards remain started  
            deciders,
            snapshotShardSizes.put(snapshotShard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
            new BalancedShardsAllocator(Settings.EMPTY),  
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().currentNodeId(), equalTo("node1"));
            )  
                null,
        );  
            );
        );  // 99% used
            .metadata(metadata)  
        ShardRouting secondRouting = TestShardRouting.newShardRouting("test", 1, "node2", null, true, ShardRoutingState.STARTED);
        logger.info("--> adding node3");  
        // Ensure that the reroute call doesn't alter the routing table, since the first primary is relocating away  
        RoutingAllocation routingAllocation = new RoutingAllocation(  
import org.opensearch.snapshots.EmptySnapshotsInfoService;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
                    .addIndexShard(new IndexShardRoutingTable.Builder(secondRouting.shardId()).addShard(secondRouting).build())
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            EmptySnapshotsInfoService.INSTANCE
import org.opensearch.common.settings.Settings;
            .build();
            cis,
        deciders = new AllocationDeciders(
        );  
            .put(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
        routingAllocation.debugDecision(true);  
        // Creating AllocationService instance and the services it depends on...
            .build();
            return clusterInfo2;  
            logger.info("--> calling fake getClusterInfo");  
import org.opensearch.cluster.ClusterName;
            new RoutingNodes(clusterState),  
            clusterInfoReference.set(clusterInfo);
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))  
            .routingTable(initialRoutingTable)
        Metadata metadata = Metadata.builder()
                                                                                     // automatically ignore single-node clusters
            Version.CURRENT
            rn.shardsWithState(STARTED).size()
            .build();
        ClusterInfoService cis = () -> {
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
    }
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "95%")
                    new SameShardAllocationDecider(
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
        logShardStates(clusterState);
        public String getDataPath(ShardRouting shardRouting) {  
        logShardStates(clusterState);
        ClusterState baseClusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        Map<String, Long> shardSizes = new HashMap<>();
        clusterState = strategy.reroute(clusterState, "reroute");
        DiscoveryNode discoveryNode1 = new DiscoveryNode(  
            final List<ShardRouting> startedShardsWithOverfullDisk = clusterState.getRoutingNodes().shardsWithState(STARTED);  
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().state(), equalTo(STARTED));
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().currentNodeId(), equalTo("node2"));
        );
        decision = diskThresholdDecider.canRemain(firstRouting, firstRoutingNode, routingAllocation);
        // Make node without the primary now habitable to replicas
        usages.put("node5", new DiskUsage("node5", "n5", "/dev/null", 100, 85)); // 15% used
        decision = diskThresholdDecider.canRemain(firstRouting, firstRoutingNode, routingAllocation);
import org.opensearch.common.UUIDs;  
        {
                    Map.of()  
            rn.shardsWithState(RELOCATING),
        secondRouting = TestShardRouting.newShardRouting("test", 1, "node1", "node2", true, ShardRoutingState.RELOCATING);
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.DiskUsage;  
            is(true)
                ((Decision.Single) decision).getExplanation(),  
                containsString(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        largerShardSizes.put("[test][0][r]", 14L);
        DevNullClusterInfo(
        final AllocationService strategy = new AllocationService(  
        Map<String, DiskUsage> usages = new HashMap<>();
        AllocationDeciders deciders = new AllocationDeciders(
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
        );
        );  
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().relocatingNodeId(), nullValue());  
        // Shards remain started
            final Map<String, Long> shardSizes
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));  
        assertThat(decision.type(), equalTo(Decision.Type.YES));  
        cis = () -> {
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));  
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().currentNodeId(), equalTo("node1"));
            EmptySnapshotsInfoService.INSTANCE
        clusterState = ClusterState.builder(clusterState).routingTable(forceAssignedRoutingTable).build();
        // Shards remain started
            .metadata(metadata)
import static org.hamcrest.Matchers.nullValue;  
    public void testShardRelocationsTakenIntoAccount() {  
 * Licensed to Elasticsearch under one or more contributor  
        diskSettings = Settings.builder()
        routingAllocation.debugDecision(true);
            .build();
package org.opensearch.cluster.routing.allocation.decider;
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
            cis,
            new RoutingNodes(clusterState),  
            .build();
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
        Metadata metadata = Metadata.builder()
            new TestGatewayAllocator(),  
        );
        AllocationDeciders deciders = new AllocationDeciders(  
        logShardStates(clusterState);
            cis,  
        largerShardSizes.put("[test2][0][p]", 2L);  
        );
        logShardStates(clusterState);  
            .metadata(metadata)  
                    .addIndexShard(new IndexShardRoutingTable.Builder(firstRouting.shardId()).addShard(firstRouting).build())
                    .getMessage(),
            assertThat(startedShardsWithReservedSpace.size(), equalTo(4));
        final Map<String, DiskUsage> usages = new HashMap<>();  
            11L
        firstRouting = TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED);
            .build();
                    ),  
        );
import org.opensearch.cluster.routing.UnassignedInfo.Reason;
        largerShardSizes.put("[test2][0][r]", 2L);
        AllocationService strategy = new AllocationService(
        final Map<String, DiskUsage> usages = new HashMap<>();
                DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node3")) // node3 is added because DiskThresholdDecider
import org.opensearch.cluster.RestoreInProgress;
        Settings diskSettings = Settings.builder()  
import org.opensearch.cluster.routing.IndexRoutingTable;  
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));  
                leastAvailableSpaceUsage,
        // Assert that node2 got a single shard (a replica)  
        shardSizes.put("[foo][0][p]", 10L);
        // Set the low threshold to 60 instead of 70
            .routingTable(initialRoutingTable)
            .build();
            final Map<String, AggregateFileCacheStats> nodeFileCacheStats
            "node2",  
        assertThat(after, equalTo(19.0));  
                    .addIndexShard(new IndexShardRoutingTable.Builder(firstRouting.shardId()).addShard(firstRouting).build())
                    .addIndexShard(new IndexShardRoutingTable.Builder(firstRouting.shardId()).addShard(firstRouting).build())
 * specific language governing permissions and limitations
            clusterState = applyStartedShardsUntilNoChange(clusterState, strategy);  
            singleton(DiscoveryNodeRole.DATA_ROLE),
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            .build();  
        final long shardSizeInBytes = randomBoolean() ? 10L : 50L;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            buildNewFakeTransportAddress(),  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();  
        logShardStates(clusterState);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).addAsNew(metadata.index("foo")).build();
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            emptyMap(),
            new TestGatewayAllocator(),
            )
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "30b")  
            .metadata(metadata)
            deciders,
        // Shard can't be allocated to node1 (or node2) because it would cause too much usage
        );
        }
            final List<ShardRouting> startedShardsWithReservedSpace = clusterState.getRoutingNodes().shardsWithState(STARTED);
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));  
            deciders,  
            final Map<String, DiskUsage> leastAvailableSpaceUsage,
 * ownership. Elasticsearch licenses this file to you under  
            clusterState = applyStartedShardsUntilNoChange(clusterState, strategy);
public class DiskThresholdDeciderTests extends OpenSearchAllocationTestCase {  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            containsString(
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
            super(  
        // Add another datanode, it should relocate.
            new TestGatewayAllocator(),
        ClusterInfoService cis = () -> {
                    "the node is above the low watermark cluster setting "  
        deciders = new AllocationDeciders(
 * The OpenSearch Contributors require contributions made to  
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
import org.opensearch.cluster.routing.ShardRouting;  
            .build();
            logger.info("--> calling fake getClusterInfo");
        logger.info("--> start the shards (replicas)");
        }
                DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")) // node2 is added because DiskThresholdDecider  
 * this work for additional information regarding copyright
                .shardsWithState(UNASSIGNED)  
        final AllocationDeciders deciders = new AllocationDeciders(
        AllocationDeciders deciders = new AllocationDeciders(  
            new TestGatewayAllocator(),
        // Two shards should start happily
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(shouldAllocate ? 0 : 1));
        logger.info("--> start the shards (primaries)");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        };
        logger.info("--> adding one cluster-manager node, one data node");
            }  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.85)  
        logShardStates(clusterState);  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "20b")
                .allMatch(unassignedInfo -> AllocationStatus.NO_ATTEMPT.equals(unassignedInfo.getLastAllocationStatus())),  
        }
        logger.info("--> adding node1 and node2 node");
        overfullUsages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 40)); // 60% used  
            ((Decision.Single) decision).getExplanation(),
            );
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));  
        firstRoutingNode = new RoutingNode("node2", discoveryNode2, firstRouting, secondRouting);  
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().state(), equalTo(STARTED));
        DiscoveryNode dataNode = new DiscoveryNode(  
import org.opensearch.cluster.metadata.Metadata;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            buildNewFakeTransportAddress(),  
                reservedSpace,
        // Two shards consuming each 80% of disk space while 70% is allowed, but one is relocating, so shard 0 can stay  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        AllocationService strategy = new AllocationService(
            logger.info("--> shard is always allocated when its size could not be retrieved");
        RoutingTable.Builder builder = RoutingTable.builder()
            decision.getExplanation(),
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        // Shard can be allocated to node1, even though it only has 25% free,  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
            new HashSet<>(
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));  
        RoutingAllocation routingAllocation = new RoutingAllocation(
import org.opensearch.snapshots.SnapshotShardSizeInfo;
        // primary shard already has been relocated away - this is a wrong expectation as we don't really move
            .build();
            null,
        logShardStates(clusterState);
            EmptySnapshotsInfoService.INSTANCE
                    ),  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        logger.info("--> start the shards (replicas)");
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
        ShardRouting startedShard = shardRouting.initialize("data", null, 40L).moveToStarted();
            System.nanoTime()
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));  
        clusterState = strategy.reroute(clusterState, "reroute");  
            .build();
            AllocationCommands cmds = new AllocationCommands(moveAllocationCommand);
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
            cis,
                )
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "70%")
import java.util.HashMap;  
        DevNullClusterInfo(
        usages.put("node1", new DiskUsage("node1", "node1", "/dev/null", 100, 10)); // 90% used
 * not use this file except in compliance with the License.
        final Metadata metadata = Metadata.builder()  
                        Settings.EMPTY,
                        + "[cluster.routing.allocation.disk.watermark.low=0.7], using more disk space than the maximum "
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
            "",
                )  
            logShardStates(clusterState);
        RoutingAllocation routingAllocation = new RoutingAllocation(
        assertThat(clusterState.getRoutingNodes().shardsWithState("test", INITIALIZING, STARTED).size(), equalTo(shouldAllocate ? 1 : 0));  
            emptyMap(),
        usages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 40)); // 60% used
            buildNewFakeTransportAddress(),
            "node1",
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            clusterInfoService,
        logger.info("--> adding two nodes");
        final ClusterInfoService cis = clusterInfoReference::get;
        DiscoveryNodes.Builder discoveryNodesBuilder = DiscoveryNodes.builder().add(dataNode);
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 20)); // 80% used
            .add(
                "the shard cannot remain on this node because it is above the high watermark cluster setting"  
            .build();  
            logShardStates(clusterState);
            .metadata(metadata)
            for (ShardRouting shardRouting : startedShardsWithOverfullDisk) {
        if (clusterState.getRoutingNodes().node("node1").size() == 1) {  
            for (ShardRouting shardRouting : startedShardsWithReservedSpace) {  
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
            .build();  
                    makeDecider(diskSettings)
            new AggregateFileCacheStats(
        };
        final Settings diskSettings = Settings.builder()
            ((Decision.Single) decision).getExplanation()  
        );
                new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),  
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().state(), equalTo(STARTED));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
            clusterInfoReference.set(overfullClusterInfo);
            final Map<String, DiskUsage> mostAvailableSpaceUsage,  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node5"))).build();  
        };
            logger.info("--> shard allocation depends on its size");  
        );
    }
        ClusterInfoService cis = () -> {
        assertThat(shardRouting.currentNodeId(), nullValue());
        );
            Version.CURRENT
        // Node1 still has no shards because it has no space for them
        final Map<String, DiskUsage> usages = new HashMap<>();  
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().relocatingNodeId(), equalTo("node2"));  
        // Node4 is available now, so the shard is moved off of node2
                Arrays.asList(  
            null,
        };
        clusterState = strategy.reroute(clusterState, "reroute");  
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));  
            discoveryNodesBuilder.add(clusterManagerNode);
import org.opensearch.core.index.shard.ShardId;
                Arrays.asList(
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;  
        Metadata metadata = Metadata.builder()
    }
        } else {
            clusterState,
            assertThat(
            snapshotShardSizeInfoRef::get
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "70%")
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(discoveryNode1).add(discoveryNode2).build();  
                                                                                     // automatically ignore single-node clusters  
        clusterState = ClusterState.builder(clusterState)
            containsString(
        logShardStates(clusterState);
            clusterInfoReference.set(overfullClusterInfo);  
            new BalancedShardsAllocator(Settings.EMPTY),  
        usages.put("node4", new DiskUsage("node4", "n4", "/dev/null", 100, 80)); // 20% used  
        );
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            .routingTable(initialRoutingTable)
        usages.put("data", new DiskUsage("data", "data", "/dev/null", 100, 20));  // 80% used  
        Metadata metadata = Metadata.builder()  
            logger.info("--> calling fake getClusterInfo");  
            return clusterInfo;
                    usages,
            buildNewFakeTransportAddress(),
            AllocationCommands cmds = new AllocationCommands(moveAllocationCommand);
import static java.util.Collections.singleton;
            // reset free space on node 3 and reserve space on node1
 */  
        ClusterInfoService cis = () -> clusterInfo;  
        assertThat(clusterState.getRoutingNodes().node("node4").size(), equalTo(1));
        assertThat(
            .build();  
            AllocationCommand moveAllocationCommand = new MoveAllocationCommand("test", 0, "node2", "node3");  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Settings diskSettings = Settings.builder()
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));  
        AllocationDeciders deciders = new AllocationDeciders(  
            cis,  
        );
            .build();
            .build();
        final Snapshot snapshot = new Snapshot("_repository", new SnapshotId("_snapshot_name", UUIDs.randomBase64UUID(random())));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        logger.info("--> adding node1");
        );
        secondRouting = TestShardRouting.newShardRouting("test", 1, "node2", "node3", true, ShardRoutingState.RELOCATING);
        result = strategy.reroute(clusterState, "reroute");  
        logger.info("--> start the shards (primaries)");
            new BalancedShardsAllocator(Settings.EMPTY),  
        // validate that the shard cannot be allocated
        clusterState = strategy.reroute(clusterState, "reroute");
        diskSettings = Settings.builder()
     */  
            .build();
                // no shards on node1 since all its free space is reserved
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().currentNodeId(), equalTo("node2"));
        clusterState = strategy.reroute(clusterState, "reroute");
            clusterState,
        // Shard hasn't been moved off of node2 yet because there's nowhere for it to go
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            EmptySnapshotsInfoService.INSTANCE  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
import org.opensearch.node.NodeResourceUsageStats;
        }
                "the shard cannot remain on this node because it is above the high watermark cluster setting "  
            );  
        logger.info("--> adding two nodes");
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),  
        routingAllocation.debugDecision(true);
                assertThat(shardRouting.toString(), shardRouting.currentNodeId(), oneOf("node1", "node2"));
                )  
        clusterState = strategy.reroute(clusterState, "reroute");  
        }
            System.nanoTime()  
        AllocationService strategy = new AllocationService(  
        );
        // shards should be initializing
     * ClusterInfo that always reports /dev/null for the shards' data paths.
 * GitHub history for details.
                    null,  
        // remove test in 9.0
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
import org.opensearch.cluster.routing.allocation.AllocationService;
            .build();  
        ClusterState clusterState = ClusterState.builder(baseClusterState).routingTable(builder.build()).build();  
                nodeFileCacheStats,  
                    shardSizes,
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
            clusterState.getRoutingNodes()  
        return new DiskThresholdDecider(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));  
                .stream()
                    .addIndexShard(new IndexShardRoutingTable.Builder(secondRouting.shardId()).addShard(secondRouting).build())  
        logger.info("--> start the shards (primaries)");  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "50b")  
                )  
            null,
            new BalancedShardsAllocator(Settings.EMPTY),  
            )
                IndexRoutingTable.builder(firstRouting.index())
                    diskThresholdDecider
        assertThat(result, equalTo(clusterState));  
        logShardStates(clusterState);
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 21));  // 79% used  
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
            new TestGatewayAllocator(),
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            AllocationCommand moveAllocationCommand = new MoveAllocationCommand("test2", 0, "node2", "node3");  
            cis,  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
                        Settings.EMPTY,  
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards = new HashMap<>();  
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
    public void testUnknownDiskUsage() {
 * under the License.  
                nodeResourceUsages
            return clusterInfo;  
            snapshotShardSizes.put(snapshotShard, shardSizeInBytes);
        {
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
                0,  
            logger.info("--> calling fake getClusterInfo");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        Metadata metadata = Metadata.builder()  
        Settings diskSettings = Settings.builder()
            final Map<String, DiskUsage> leastAvailableSpaceUsage,
            nodeWithPrimary = "node2";
import org.opensearch.cluster.ClusterState;
        ShardId shardId = shardRouting.shardId();  
    }
        };  
                    ),
        fileCacheStatsMap.put(  
        // Shard hasn't been moved off of node2 yet because there's nowhere for it to go  
        ShardRouting shardRouting = result.routingTable().index("test").getShards().get(0).primaryShard();  
            .build();
            "node2",
        // Set the high threshold to 70 instead of 80
        clusterState = strategy.reroute(clusterState, "reroute");  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "40b")
            )
            nodeWithPrimary = "node1";
        clusterState = strategy.reroute(clusterState, "reroute");
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)  
            .nodes(discoveryNodes)
            new BalancedShardsAllocator(Settings.EMPTY),
import org.opensearch.common.settings.ClusterSettings;
        AllocationService strategy = new AllocationService(
            )
                )  
        );
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        usages.put("node3", new DiskUsage("node3", "node3", "/dev/null", 100, 0));  // 100% used
import org.opensearch.cluster.ClusterInfo;
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
            EmptySnapshotsInfoService.INSTANCE
                Arrays.asList(
import org.opensearch.Version;
            EmptySnapshotsInfoService.INSTANCE
            final Map<String, Long> shardSizes,
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
    }
            .addAsNew(metadata.index("test2"))
        AllocationService strategy = new AllocationService(  
        assertThat(clusterState.getRoutingNodes().node("node4").size(), equalTo(1));  
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            "there is enough disk on this node for the shard to remain, free: [60b]",
            rn.shardsWithState(RELOCATING).size(),
            emptyMap(),
        // primary first unless explicitly set by setting. This is caught with PR
            logger.info("--> calling fake getClusterInfo");
            emptyMap(),
            clusterInfo,
            .nodes(discoveryNodes)  
        ClusterState updateClusterState = ClusterState.builder(clusterState)  
            .routingTable(initialRoutingTable)
 *     http://www.apache.org/licenses/LICENSE-2.0
        ShardRouting firstRouting = TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED);  
            deciders,
        Settings diskSettings = Settings.builder()
            )
        ClusterInfoService cis = () -> {
                Arrays.asList(  
            clusterState = strategy.reroute(clusterState, cmds, false, false).getClusterState();
        assertThat(clusterState.getRoutingNodes().node("node4").size(), equalTo(1));
        clusterState = ClusterState.builder(updateClusterState).routingTable(builder.build()).build();
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
            "node2",
            new TestGatewayAllocator(),
        shardSizes.put("[test][0][p]", 40L);
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
                .allMatch(unassignedInfo -> AllocationStatus.FETCHING_SHARD_DATA.equals(unassignedInfo.getLastAllocationStatus())),  
            new BalancedShardsAllocator(Settings.EMPTY),
            final Map<String, AggregateFileCacheStats> nodeFileCacheStats
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)  
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "71%")
    }  
                    .addIndexShard(new IndexShardRoutingTable.Builder(shardId).addShard(startedShard).build())
                    ),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            Version.CURRENT  
            strategy.reroute(clusterState, "foo"); // ensure reroute doesn't fail even though there is negative free space  
        logShardStates(clusterState);
            "node3",  
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
/*  
                    new SameShardAllocationDecider(
        // assertThat(clusterState.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
        shardSizes.put("[test2][0][r]", 1L);
            shouldAllocate = true;  
            "cluster-manager",
        @Override
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
