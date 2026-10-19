            EmptySnapshotsInfoService.INSTANCE
        );
            Version.CURRENT
        assertThat(
        assertThat(clusterState.getRoutingNodes().node("node5").size(), equalTo(1));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        usages.put("node2", new DiskUsage("node2", "node2", "/dev/null", 100, 35)); // 65% used
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        logger.info("--> start the shards (primaries)");
     * ClusterInfo that always reports /dev/null for the shards' data paths.
        }
            .metadata(metadata)
            new RoutingNodes(clusterState),
        // Assert that we're able to start the primary
            cis,
        final Settings diskSettings = Settings.builder()
        final Map<String, DiskUsage> usages = new HashMap<>();
        final Map<String, DiskUsage> usages = new HashMap<>();
            final Map<String, AggregateFileCacheStats> nodeFileCacheStats
            new TestGatewayAllocator(),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
import java.util.HashSet;
            )
        logger.info("--> final cluster state:");
            deciders,
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
            rn.shardsWithState(RELOCATING),
            final Map<String, DiskUsage> mostAvailableSpaceUsage,
                    ),
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
        {
                    .numberOfShards(1)
        clusterState = ClusterState.builder(clusterState)
                )
        clusterState = strategy.reroute(clusterState, "reroute");
                Arrays.asList(
        );
            final Map<String, Long> shardSizes
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
        Settings diskSettings = Settings.builder()
import org.opensearch.repositories.IndexId;
            deciders,
            .build();
            .put(IndexMetadata.builder("test").settings(remoteIndexSettings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        logger.info("--> adding one cluster-manager node, one data node");
            .build();
        overfullUsages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 40)); // 60% used
        ClusterInfoService cis = () -> {
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
        final Map<String, DiskUsage> usages = new HashMap<>();
        clusterState = ClusterState.builder(clusterState)
        );
            clusterInfoReference.set(
            emptyMap(),
        // first as both node1 and node2 have equal weight as both of them contain zero shards.
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats.FileCacheStatsType;
 *     http://www.apache.org/licenses/LICENSE-2.0
            clusterInfoReference.set(clusterInfo);
                        Settings.EMPTY,
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.routing.allocation.command.AllocationCommand;
        logger.info("--> adding node4");
        DiscoveryNodes discoveryNodes = discoveryNodesBuilder.build();
        logger.info("--> nodeWithPrimary: {}", nodeWithPrimary);
        logShardStates(clusterState);
        decision = diskThresholdDecider.canAllocate(fooRouting, firstRoutingNode, routingAllocation);
        shardSizes.put("[test2][0][p]", 1L); // 1 bytes
                IndexRoutingTable.builder(firstRouting.index())
        DiscoveryNode dataNode = new DiscoveryNode(
import org.opensearch.cluster.routing.RoutingNode;
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        Decision decision = diskThresholdDecider.canRemain(firstRouting, firstRoutingNode, routingAllocation);
        );
        final RestoreInProgress.Builder restores = new RestoreInProgress.Builder().add(
import static org.hamcrest.Matchers.is;
        largerShardSizes.put("[test][0][r]", 14L);
            .build();
        // Primary should initialize, even though both nodes are over the limit initialize
            assertThat(
        usages.put("node1", new DiskUsage("node1", "node1", "/dev/null", 100, 10)); // 90% used
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        assertThat(decision.type(), equalTo(Decision.Type.YES));
        logShardStates(clusterState);
            new TestGatewayAllocator(),
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
        // Set the low threshold to 50 instead of 60
        logger.info("--> adding node3");
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
            deciders,
    public void testDiskThresholdWithShardSizes() {
                    .addIndexShard(new IndexShardRoutingTable.Builder(shardId).addShard(startedShard).build())
                IndexRoutingTable.builder(firstRouting.index())
                Arrays.asList(
        final Map<String, Long> shardSizes = new HashMap<>();
            cis,
        DiskThresholdDecider diskThresholdDecider = makeDecider(diskSettings);
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes, fileCacheStatsMap);
        clusterState = ClusterState.builder(clusterState)
            .build();
        RoutingTable.Builder builder = RoutingTable.builder()
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
        );
import static java.util.Collections.emptyMap;
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
            "--> counts: total: {}, unassigned: {}, initializing: {}, relocating: {}, started: {}",
import org.opensearch.snapshots.InternalSnapshotsInfoService.SnapshotShard;
                new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
        // below checks are unnecessary as the primary shard is always assigned to node2 as BSA always picks up that node
        Map<String, AggregateFileCacheStats> fileCacheStatsMap = new HashMap<>();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "70%")
        logger.info("--> changing settings again");
            new BalancedShardsAllocator(Settings.EMPTY),
                DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")) // node2 is added because DiskThresholdDecider
        logShardStates(clusterState);
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().relocatingNodeId(), equalTo("node3"));
        Settings diskSettings = Settings.builder()
        Metadata metadata = Metadata.builder()
        clusterState = strategy.reroute(clusterState, "reroute");
        ShardRouting firstRouting = TestShardRouting.newShardRouting("test", 0, "node2", null, true, ShardRoutingState.STARTED);
        usages.put("node5", new DiskUsage("node5", "n5", "/dev/null", 100, 85)); // 15% used
                    + " actual free: [20.0%]"
            return clusterInfo;
        );
            }
        final boolean shouldAllocate;
            logShardStates(clusterState);
import org.opensearch.cluster.metadata.IndexMetadata;
        decision = diskThresholdDecider.canRemain(firstRouting, firstRoutingNode, routingAllocation);
    }
        result = strategy.reroute(clusterState, "reroute");
                Arrays.asList(
            Version.CURRENT
                    "the node is above the low watermark cluster setting [cluster.routing.allocation.disk.watermark.low=60%], using more "
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
            new BalancedShardsAllocator(Settings.EMPTY),
        logger.info("--> start the shards (primaries)");
        };
            return "/dev/null";
            rn.shardsWithState(UNASSIGNED),
                        + "allowed [70.0%], actual free: [26.0%]"
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            "node2",
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            deciders,
                    usages,
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
                )
import org.opensearch.cluster.ClusterInfo;
            null,
        fileCacheStatsMap.put(
        shardSizes.put("[test][0][p]", 14L); // 14 bytes
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().state(), equalTo(STARTED));
        clusterState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        assertThat(
            clusterState.getRoutingNodes()
        shardSizes.put("[test][0][p]", 40L);
            rn.shardsWithState(STARTED)
            )
        RoutingNode firstRoutingNode = new RoutingNode("node1", discoveryNode1, firstRouting, secondRouting);
                .shardsWithState(UNASSIGNED)
 * this file be licensed under the Apache-2.0 license or a
        // validate that the shard cannot be allocated
                    .addIndexShard(new IndexShardRoutingTable.Builder(firstRouting.shardId()).addShard(firstRouting).build())
        Decision decision = diskThresholdDecider.canRemain(startedShard, clusterState.getRoutingNodes().node("data"), routingAllocation);
 * not use this file except in compliance with the License.
        logShardStates(clusterState);
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().state(), equalTo(STARTED));
        usages.put("node3", new DiskUsage("node3", "node3", "/dev/null", 100, 60)); // 40% used
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
        assertThat(decision.type(), equalTo(Decision.Type.NO));
            rn.shards(shard -> true).size(),
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                new DevNullClusterInfo(
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
        }
            deciders,
                .map(ShardRouting::unassignedInfo)
import org.opensearch.snapshots.EmptySnapshotsInfoService;
            .build();
        shardSizes.put("[test][0][p]", 40L);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            return clusterInfo2;
            new HashSet<>(
            for (ShardRouting shardRouting : startedShardsWithReservedSpace) {
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().relocatingNodeId(), nullValue());
        usages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 0));  // 100% used
import org.opensearch.cluster.routing.RecoverySource;
            new TestGatewayAllocator(),
                leastAvailableSpaceUsage,
        AllocationService strategy = new AllocationService(
            clusterInfoReference.set(overfullClusterInfo);
            .routingTable(initialRoutingTable)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        );
    }
            rn.shardsWithState(STARTED).size()
        final IndexId indexId = new IndexId("_indexid_name", UUIDs.randomBase64UUID(random()));
            "node1",
        diskSettings = Settings.builder()
            emptyMap(),
                        Settings.EMPTY,
            )
 * ownership. Elasticsearch licenses this file to you under
        // We have an index with 1 primary shard, taking 40 bytes. The single data node has only 20 bytes free.
        logShardStates(clusterState);
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        shardSizes.put("[test][1][p]", 40L);
            .nodes(discoveryNodes)
            new DiskUsage("node1", "n1", "/dev/null", 100, 31), // 69% used
            assertThat(startedShardsWithReservedSpace.size(), equalTo(4));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(discoveryNode3))
        shardSizes.put("[test][0][r]", 10L);
    DiskThresholdDecider makeDecider(Settings settings) {
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node5"))).build();
    static class DevNullClusterInfo extends ClusterInfo {
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
                    ),
            EmptySnapshotsInfoService.INSTANCE
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            new HashSet<>(
                    usages,
        assertThat(
            new BalancedShardsAllocator(Settings.EMPTY),
        ShardRouting startedShard = shardRouting.initialize("data", null, 40L).moveToStarted();
            .build();
            System.nanoTime()
            containsString("there is enough disk on this node for the shard to remain, free: [60b]")
        // Assert that the replica couldn't be started since node1 doesn't have enough space
        } else {
            new TestGatewayAllocator(),
            .metadata(metadata)
                        + "[cluster.routing.allocation.disk.watermark.low=0.7], using more disk space than the maximum "
        ClusterState baseClusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            buildNewFakeTransportAddress(),
            .add(
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().currentNodeId(), equalTo("node2"));
        shardSizes.put("[test][0][p]", 40L);
        final Map<String, Long> shardSizes = new HashMap<>();
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(shouldAllocate ? 0 : 1));
        ShardRouting firstRouting = TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED);
                containsString(
            CLUSTER_MANAGER_DATA_ROLES,
        final Map<String, DiskUsage> usages = Map.of(
        clusterState = strategy.reroute(clusterState, "reroute");
        logShardStates(clusterState);
import org.opensearch.core.index.shard.ShardId;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.cluster.routing.IndexRoutingTable;
            new RestoreInProgress.Entry("_restore_uuid", snapshot, RestoreInProgress.State.INIT, singletonList("test"), shards)
            clusterState = strategy.reroute(clusterState, cmds, false, false).getClusterState();
        Settings diskSettings = Settings.builder()
            logger.info("--> simulating snapshot shards size retrieval success");
                                                                                     // automatically ignore single-node clusters
                0,
            containsString(
 * You may obtain a copy of the License at
        ShardRouting secondRouting = TestShardRouting.newShardRouting("test", 1, "node2", null, true, ShardRoutingState.STARTED);
                    .getMessage(),
                    .addIndexShard(new IndexShardRoutingTable.Builder(firstRouting.shardId()).addShard(firstRouting).build())
        @Override
            ((Decision.Single) decision).getExplanation(),
        routingAllocation = new RoutingAllocation(null, new RoutingNodes(clusterState), clusterState, clusterInfo, null, System.nanoTime());
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().relocatingNodeId(), nullValue());
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
            return clusterInfo;
    }
        assertThat(shardRouting.state(), equalTo(UNASSIGNED));
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().currentNodeId(), equalTo("node2"));
        // shard cannot be assigned yet as the snapshot shard size is unknown
        );
            new RoutingNodes(clusterState),
                .stream()
            nodeWithoutPrimary = "node1";
        // primary first unless explicitly set by setting. This is caught with PR
                    .addIndexShard(new IndexShardRoutingTable.Builder(firstRouting.shardId()).addShard(firstRouting).build())
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            );
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(discoveryNodes)
        ClusterState result = strategy.reroute(clusterState, "reroute");
            deciders,
            final Map<String, Long> shardSizes,
                    .addIndexShard(new IndexShardRoutingTable.Builder(secondRouting.shardId()).addShard(secondRouting).build())
            .build();
            .build();
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
                    ),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "30b")
        };
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
        AllocationDeciders deciders = new AllocationDeciders(
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 21));  // 79% used
        DiskThresholdDecider diskThresholdDecider = makeDecider(diskSettings);
    public void testForSingleDataNode() {
        // Assert that node1 didn't get any shards because its disk usage is too high
            Version.CURRENT
                    makeDecider(diskSettings)
            .build();
    }
 * Unless required by applicable law or agreed to in writing,
import static java.util.Collections.singleton;
            new AggregateFileCacheStats(
            .metadata(metadata)
            is(true)
                DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node3")) // node3 is added because DiskThresholdDecider
                        Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none").build(),
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        shardSizes.put("[test][0][r]", 10L); // 10 bytes
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 40)); // 60% used
            .put(DiskThresholdSettings.ENABLE_FOR_SINGLE_DATA_NODE.getKey(), true)
            .build();
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
            clusterInfoService,
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().currentNodeId(), equalTo("node2"));
        // Ensure that the reroute call doesn't alter the routing table, since the first primary is relocating away
        Metadata metadata = Metadata.builder()
                    diskThresholdDecider
                .shardsWithState(UNASSIGNED)
            EmptySnapshotsInfoService.INSTANCE
            emptyMap(),
        assertThat(
import org.opensearch.cluster.routing.RoutingNodes;
        final Map<String, DiskUsage> overfullUsages = new HashMap<>();
        final Map<SnapshotShard, Long> snapshotShardSizes = new HashMap<>();
import java.util.HashMap;
            return clusterInfo;
                new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
import org.opensearch.cluster.routing.UnassignedInfo.Reason;
        firstRouting = TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED);
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        String nodeWithPrimary, nodeWithoutPrimary;
            rn.shardsWithState(INITIALIZING).size(),
        deciders = new AllocationDeciders(
        defaultWithWarmRole.add(DiscoveryNodeRole.WARM_ROLE);
        logShardStates(clusterState);
            .build();
            new TestGatewayAllocator(),
        }
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        if (fooRouting.recoverySource().getType() == RecoverySource.Type.EMPTY_STORE) {
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
            new HashSet<>(
        // reroute uses the previous snapshot shard size
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
        ClusterInfoService cis = () -> clusterInfo;
        ClusterInfoService cis = () -> {
                    new SameShardAllocationDecider(
        if (clusterState.getRoutingNodes().node("node1").size() == 1) {
        AllocationService strategy = new AllocationService(
            return clusterInfo;
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        );
            new TestGatewayAllocator(),
            for (ShardRouting shardRouting : startedShardsWithOverfullDisk) {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.DiskUsage;
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            .nodes(discoveryNodes)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.node.DiscoveryNode;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            new BalancedShardsAllocator(Settings.EMPTY),
                IndexRoutingTable.builder(shardId.getIndex())
            final Map<String, AggregateFileCacheStats> nodeFileCacheStats
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
        logShardStates(clusterState);
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
                    .addIndexShard(new IndexShardRoutingTable.Builder(secondRouting.shardId()).addShard(secondRouting).build())
    public void testShardRelocationsTakenIntoAccount() {
            )
        assertThat(
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                new FileCacheStats(0, 0, 0, 0, 0, 0, 0, 0, FileCacheStatsType.FULL_FILE_STATS),
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(1));
            .add(
        RoutingNodes rn = state.getRoutingNodes();
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().state(), equalTo(RELOCATING));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "30b")
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "71%")
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            EmptySnapshotsInfoService.INSTANCE
        Map<String, DiskUsage> usages = new HashMap<>();
import org.opensearch.common.settings.Settings;
        logShardStates(clusterState);
        DiskThresholdDecider diskThresholdDecider = makeDecider(diskSettings);
import static java.util.Collections.singletonList;
        // assertThat(clusterState.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
            AllocationCommand moveAllocationCommand = new MoveAllocationCommand("test2", 0, "node2", "node3");
            .routingTable(routingTable)
        // Assert that we're able to start the primary and replicas
import org.opensearch.node.NodeResourceUsageStats;
            cis,
        ) {
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
import org.opensearch.Version;
            .build();
        final Map<String, Long> largerShardSizes = new HashMap<>();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        RoutingAllocation routingAllocation = new RoutingAllocation(
import org.opensearch.cluster.routing.AllocationId;
    }
        // primary shard already has been relocated away - this is a wrong expectation as we don't really move
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            "there is enough disk on this node for the shard to remain, free: [60b]",
        shardSizes.put("[test][0][r]", 10L);
        diskSettings = Settings.builder()
        Metadata metadata = Metadata.builder()
            EmptySnapshotsInfoService.INSTANCE
        );
            new HashSet<>(
            .routingTable(initialRoutingTable)
        fileCacheStatsMap.put(
        );
        RoutingTable.Builder builder = RoutingTable.builder()
        final Map<String, Long> shardSizes = new HashMap<>();
        // node2 now should not have new shards allocated to it, and shards cannot remain
            .build();
                assertThat(shardRouting.toString(), shardRouting.currentNodeId(), oneOf("node2", "node3"));
        DiscoveryNode discoveryNode2 = new DiscoveryNode(
            "cluster-manager",
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
            EmptySnapshotsInfoService.INSTANCE
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().relocatingNodeId(), nullValue());
/*
                "the shard cannot remain on this node because it is above the high watermark cluster setting"
            AllocationCommands cmds = new AllocationCommands(moveAllocationCommand);
            null,
        Double after = decider.freeDiskPercentageAfterShardAssigned(
                    + "[cluster.routing.allocation.disk.watermark.high=70%] and there is less than the required [30.0%] free disk on node, "
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        final Map<String, DiskUsage> usages = new HashMap<>();
        RoutingAllocation routingAllocation = new RoutingAllocation(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
        final Map<String, Long> shardSizes = new HashMap<>();
        usages.put("node2", new DiskUsage("node2", "node2", "/dev/null", 100, 35)); // 65% used
        final Map<String, DiskUsage> usages = new HashMap<>();
        clusterState = ClusterState.builder(updateClusterState).routingTable(builder.build()).build();
            new TestGatewayAllocator(),
        );
        logShardStates(clusterState);
        AllocationDeciders deciders = new AllocationDeciders(
            .build();
        // Shard can be allocated to node1, even though it only has 25% free,
        routingAllocation.debugDecision(true);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
/*
        // Shard hasn't been moved off of node2 yet because there's nowhere for it to go
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "70%")
            nodeWithoutPrimary = "node2";
        // Shards remain started on node3 and node4
        // shards should be initializing
                    .addIndexShard(new IndexShardRoutingTable.Builder(secondRouting.shardId()).addShard(secondRouting).build())
            .routingTable(initialRoutingTable)
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        }
            clusterInfo,
        );
        Set<DiscoveryNodeRole> defaultWithWarmRole = new HashSet<>(CLUSTER_MANAGER_DATA_ROLES);
        overfullUsages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 40)); // 60% used
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        clusterState = strategy.reroute(clusterState, "reroute");
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
                    diskThresholdDecider
        strategy = new AllocationService(
        // No shards are started, no nodes have enough disk for allocation
        final RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
            deciders,
            "",
                    ),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            )
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        Decision decision = diskThresholdDecider.canRemain(firstRouting, firstRoutingNode, routingAllocation);
                Arrays.asList(
            new BalancedShardsAllocator(Settings.EMPTY),
        ClusterState clusterState = ClusterState.builder(baseClusterState).routingTable(builder.build()).build();
        ClusterInfoService cis = () -> {
        );
            rn.shardsWithState(INITIALIZING),
            .build();
        );
        {
import org.opensearch.cluster.node.DiscoveryNodeRole;
    public void testDiskThresholdWithSnapshotShardSizes() {
        usages.put("node4", new DiskUsage("node4", "n4", "/dev/null", 100, 80)); // 20% used
            final List<ShardRouting> startedShardsWithOverfullDisk = clusterState.getRoutingNodes().shardsWithState(STARTED);
        final ClusterInfo clusterInfo2 = new DevNullClusterInfo(usages, usages, shardSizes);
        cis = () -> {
            .addAsNew(metadata.index("test2"))
            "data",
        ) {
                                                                                     // automatically ignore single-node clusters
    public void testDiskThresholdForRemoteShards() {
            new TestGatewayAllocator(),
            cis,
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
            .build();
        }
        logger.info("--> adding node3");
            logger.info("--> calling fake getClusterInfo");
        usages.put("node3", new DiskUsage("node3", "node3", "/dev/null", 100, 60)); // 40% used
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
            new TestGatewayAllocator(),
                .map(ShardRouting::unassignedInfo)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "70%")
        // Two shards consumes 80% of disk space in data node, but we have only one data node, shards should remain.
            deciders,
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        logShardStates(clusterState);
        };
            assertThat(
        public String getDataPath(ShardRouting shardRouting) {
        logger.info("--> start the shards (primaries)");
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 10)); // 90% used
        if (randomBoolean()) {
        // node2 now should not have new shards allocated to it, but shards can remain
            Map<NodeAndPath, ReservedSpace> reservedSpace,
            .add(
        DiscoveryNode discoveryNode3 = new DiscoveryNode(
        usages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 100)); // 0% used
            super(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        Settings diskSettings = Settings.builder()
            );
            .build();
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            .build();
        // Primary shard should be initializing, replica should not
import static org.hamcrest.Matchers.oneOf;
                        Settings.EMPTY,
        clusterState = strategy.reroute(clusterState, "reroute");
        final Map<String, DiskUsage> usages = new HashMap<>();
        // Initializing on node5
        logShardStates(clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
            "node2",
                    makeDecider(diskSettings)
                new HashSet<>()
 */
        final Map<String, DiskUsage> usages = new HashMap<>();
            is(true)
        logger.info("--> start the shards (replicas)");
}
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
        assertThat(shardRouting.currentNodeId(), nullValue());
                        + "more disk space than the maximum allowed [70.0%], actual free: [20.0%]"
        logger.info("--> adding node3");
            final Map<String, Long> shardSizes,
            .addAsNew(metadata.index("test"))
            )
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        logShardStates(clusterState);
            this(leastAvailableSpaceUsage, mostAvailableSpaceUsage, null, shardSizes, Map.of(), Map.of());
        );
        );
                )
        // Assert that node2 got a single shard (a replica)
            new BalancedShardsAllocator(Settings.EMPTY),
        final Metadata metadata = Metadata.builder()
            cis,
            clusterInfo,
        );
        logShardStates(clusterState);
import org.opensearch.cluster.routing.TestShardRouting;
        logger.info("--> using shard size [{}]", shardSizeInBytes);
        );
            )
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        Metadata metadata = Metadata.builder()
                        new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            .routingTable(initialRoutingTable)
            .build();
        assertThat(after, equalTo(19.0));
        };
            snapshotShardSizes.put(snapshotShard, ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE);
        DiscoveryNodes.Builder discoveryNodesBuilder = DiscoveryNodes.builder().add(dataNode);
        // We have an index with 1 primary shards each taking 40 bytes. Each node has 100 bytes available
            final List<ShardRouting> startedShardsWithReservedSpace = clusterState.getRoutingNodes().shardsWithState(STARTED);
        // node2 now should not have new shards allocated to it, but shards can remain
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        // Primary shard should be initializing, replica should not
        );
        logShardStates(clusterState);
            "node2",
        );
                mostAvailableSpaceUsage,
public class DiskThresholdDeciderTests extends OpenSearchAllocationTestCase {
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        ClusterState clusterState = ClusterState.builder(new ClusterName(getTestName()))
        if (randomBoolean()) {
        logger.info("--> nodeWithoutPrimary: {}", nodeWithoutPrimary);
        clusterState = ClusterState.builder(clusterState).routingTable(forceAssignedRoutingTable).build();
                .allMatch(unassignedInfo -> AllocationStatus.FETCHING_SHARD_DATA.equals(unassignedInfo.getLastAllocationStatus())),
        // Assert that node1 got a single shard (the primary), even though its disk usage is too high
        final ShardId shardId = new ShardId(new Index("test", IndexMetadata.INDEX_UUID_NA_VALUE), 0);
        // be allowed, because it's a primary that hasn't been allocated, and node1
        logger.info("--> start the shards");
                expectThrows(IllegalArgumentException.class, () -> strategy.reroute(clusterStateThatRejectsCommands, cmds, false, false))
        // Assert that one replica is still unassigned
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
                    new EnableAllocationDecider(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "50b")
        logger.info("--> apply INITIALIZING shards");
            .build();
        // Shards remain started
            .nodes(
        logger.info("--> adding two nodes");
 * software distributed under the License is distributed on an
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().relocatingNodeId(), equalTo("node2"));
        deciders = new AllocationDeciders(
        logger.info("--> start the shards (replicas)");
 * GitHub history for details.
            .build();
            .add(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        logger.info("--> start the shards (primaries)");
            EmptySnapshotsInfoService.INSTANCE
    public void testFreeDiskPercentageAfterShardAssigned() {
            .metadata(metadata)
                IndexRoutingTable.builder(firstRouting.index())
                    new SameShardAllocationDecider(
                    ),
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        );
        // We have an index with 2 primary shards each taking 40 bytes. Each node has 100 bytes available
            .build();
        );
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
            cis,
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
        shardSizes.put("[foo][0][p]", 10L);
        logger.info("--> start the shards (replicas)");
            new BalancedShardsAllocator(Settings.EMPTY),
        AllocationService strategy = new AllocationService(
                IndexRoutingTable.builder(firstRouting.index())
            .build();
        assertThat(
            strategy.reroute(clusterState, "foo"); // ensure reroute doesn't fail even though there is negative free space
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(discoveryNode1).add(discoveryNode2).build();
                )
        );
        logShardStates(clusterState);
        assertThat(decision.type(), equalTo(Decision.Type.YES));
        // Assert that the replica is initialized now that node3 is available with enough space
        clusterState = ClusterState.builder(clusterState)
        firstRoutingNode = new RoutingNode("node1", discoveryNode1, firstRouting, secondRouting);
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
        overfullUsages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 0));  // 100% used
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.7)
            EmptySnapshotsInfoService.INSTANCE
            clusterState.getRoutingNodes()
            cis,
            logger.info("--> calling fake getClusterInfo");
            logger.info("--> shard is always allocated when its size could not be retrieved");
        );
        Settings diskSettings = Settings.builder()
        final AllocationService strategy = new AllocationService(
            logger.info("--> calling fake getClusterInfo");
        diskSettings = Settings.builder()
            .build();
        // Shards remain started
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
            shouldAllocate = true;
            new TestGatewayAllocator(),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
                "the shard cannot remain on this node because it is above the high watermark cluster setting "
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            rn.shardsWithState(UNASSIGNED).size(),
        usages.put(nodeWithoutPrimary, new DiskUsage(nodeWithoutPrimary, "", "/dev/null", 100, 35)); // 65% used
        Metadata metadata = Metadata.builder()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // Set the high threshold to 60 instead of 70
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
        // Node5 is available now, so the shard is moved off of node2
        {
        );
        ClusterState clusterState = ClusterState.builder(new ClusterName("test"))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.85)
        final ClusterInfo overfullClusterInfo = new DevNullClusterInfo(overfullUsages, overfullUsages, largerShardSizes);
        // Assert that we're able to start the primary and replica, since they were both initializing
            new BalancedShardsAllocator(Settings.EMPTY),
        RoutingNode firstRoutingNode = new RoutingNode("node2", discoveryNode2, firstRouting, secondRouting);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "9b")
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "90%")
        DevNullClusterInfo(
import java.util.concurrent.atomic.AtomicReference;
        strategy = new AllocationService(
                null,
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            new AggregateFileCacheStats(
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.BLOCK_FILE_STATS),
            emptyMap(),
        logger.info("--> adding node1 and node2 node");
        AllocationDeciders deciders = new AllocationDeciders(
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        };
            null,
            .metadata(metadata)
            .metadata(metadata)
        final AllocationDeciders deciders = new AllocationDeciders(
                    null,
        );
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
                )
            new HashSet<>(
            AllocationCommand moveAllocationCommand = new MoveAllocationCommand("test", 0, "node2", "node3");
        }
            new BalancedShardsAllocator(Settings.EMPTY),
                )
            cis,
            .routingTable(routingTable)
        // Creating AllocationService instance and the services it depends on...
            11L
        );
            new AggregateFileCacheStats(
        );
                0,
        DiscoveryNode discoveryNode2 = new DiscoveryNode(
                        Settings.EMPTY,
        );
            new BalancedShardsAllocator(Settings.EMPTY),
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
            logger.info("--> calling fake getClusterInfo");
                    ),
            new HashSet<>(
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.6)
        builder = RoutingTable.builder()
        RoutingTable initialRoutingTable = RoutingTable.builder()
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 40)); // 60% used
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 50)); // 50% used
        routingAllocation.debugDecision(true);
        final Map<ShardId, RestoreInProgress.ShardRestoreStatus> shards = new HashMap<>();
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(1));
            assertThat(startedShardsWithOverfullDisk.size(), equalTo(4));
            return clusterInfo;
        logger.info("--> adding node1");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
            emptyMap(),
        AllocationService strategy = new AllocationService(
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
        );
        DiscoveryNode discoveryNode1 = new DiscoveryNode(
            buildNewFakeTransportAddress(),
                    + " [cluster.routing.allocation.disk.watermark.high=70%] and there is less than the required [30.0%] free disk on node,"
        clusterState = strategy.reroute(clusterState, "reroute");
        // is still below the high watermark (unlike node3)
        );
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                        new ClusterInfo.NodeAndPath("node1", "/dev/null"),
        // Node1 still has no shards because it has no space for them
        clusterState = strategy.reroute(clusterState, "reroute");
    public void testCanRemainWithShardRelocatingAway() {
            new BalancedShardsAllocator(Settings.EMPTY),
        clusterState = strategy.reroute(clusterState, "reroute");
                ((Decision.Single) decision).getExplanation(),
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
            clusterInfo,
        // Shards remain started
                        + "disk space than the maximum allowed [60.0%], actual free: [20.0%]"
    /**
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        clusterState = strategy.reroute(clusterState, "reroute");
        ClusterState result = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(4));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "40b")
        // Shards remain started
            .build();
        // Assert that all replicas could be started
            AllocationCommands cmds = new AllocationCommands(moveAllocationCommand);
                    ),
            nodeWithPrimary = "node1";
            "",
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
            singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            System.nanoTime()
            deciders,
        usages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 40)); // 60% used
            return clusterInfo;
            );
            AllocationCommand moveAllocationCommand = new MoveAllocationCommand("test2", 0, "node2", "node3");
 * SPDX-License-Identifier: Apache-2.0
        ) {
            logger.info("--> calling fake getClusterInfo");
        assertThat(decision.type(), equalTo(Decision.Type.NO));
                .stream()
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            final Map<String, DiskUsage> leastAvailableSpaceUsage,
            cis,
        Settings diskSettings = Settings.builder()
        decision = diskThresholdDecider.canRemain(firstRouting, firstRoutingNode, routingAllocation);
        );
            "data",
                DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")) // node2 is added because DiskThresholdDecider
        shardSizes.put("[test][0][r]", 10L);
            snapshotShardSizes.put(snapshotShard, shardSizeInBytes);
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().relocatingNodeId(), nullValue());
            new BalancedShardsAllocator(Settings.EMPTY),
            logger.info("--> calling fake getClusterInfo");
        final Map<String, Long> shardSizes = new HashMap<>();
        logger.info("--> apply INITIALIZING shards");
            deciders,
            final Map<String, DiskUsage> mostAvailableSpaceUsage,
import org.opensearch.cluster.routing.allocation.AllocationService;
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 20));  // 80% used
import org.opensearch.common.settings.ClusterSettings;
        logShardStates(clusterState);
        AllocationService strategy = new AllocationService(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
            clusterState = applyStartedShardsUntilNoChange(clusterState, strategy);
        logShardStates(clusterState);
     */
    public void testWatermarksEnabledForSingleDataNode() {
        final AtomicReference<SnapshotShardSizeInfo> snapshotShardSizeInfoRef = new AtomicReference<>(SnapshotShardSizeInfo.EMPTY);
            deciders,
                    .settings(settings(Version.CURRENT))
            decision.getExplanation(),
        };
        AllocationService strategy = new AllocationService(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
        ShardRouting secondRouting = TestShardRouting.newShardRouting("test", 1, "node1", null, true, ShardRoutingState.STARTED);
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        // assertThat(clusterState.getRoutingNodes().node(nodeWithoutPrimary).size(), equalTo(1));
        } else {
import org.opensearch.cluster.RestoreInProgress;
                    "the node is above the low watermark cluster setting "
            )
            System.nanoTime()
            .build();
                    decider
                    .getMessage(),
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
        );
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
import java.util.Set;
            "node1",
    }
import java.util.List;
            new TestGatewayAllocator(),
        AllocationDeciders deciders = new AllocationDeciders(
            EmptySnapshotsInfoService.INSTANCE
        AllocationDeciders deciders = new AllocationDeciders(
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).addAsNew(metadata.index("foo")).build();
        final RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        usages.put("node3", new DiskUsage("node3", "n3", "/dev/null", 100, 60)); // 40% used
                IndexMetadata.builder("test")
        // A single shard is started on node1, even though it normally would not
                .stream()
        logShardStates(clusterState);
            .build();
            .build();
                Arrays.asList(
        // Two shards consuming each 80% of disk space while 70% is allowed, but one is relocating, so shard 0 can stay
            .build();
        // Assert that we're able to start the primary
            .build();
        // Add another datanode, it should relocate.
            Version.CURRENT
 * The OpenSearch Contributors require contributions made to
                    new SameShardAllocationDecider(
        // force assign shard and validate that it cannot remain.
        largerShardSizes.put("[test2][0][r]", 2L);
        snapshotShardSizeInfoRef.set(new SnapshotShardSizeInfo(snapshotShardSizes));
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        // reroute triggers snapshot shard size fetching
                shardSizes,
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
import org.opensearch.index.store.remote.filecache.FileCacheStats;
            Version.CURRENT
import org.opensearch.cluster.ClusterName;
        ClusterState result = strategy.reroute(clusterState, "reroute");
            .routingTable(initialRoutingTable)
            )
            EmptySnapshotsInfoService.INSTANCE
            new DiskUsage("node2", "n2", "/dev/null", 100, 1)
        // Set the high threshold to 70 instead of 80
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().currentNodeId(), equalTo("node1"));
        );
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            new HashSet<>(
        );
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 *
                    Map.of()
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
                )
            );
        // remove test in 9.0
        logger.info("--> adding node3");
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_THRESHOLD_ENABLED_SETTING.getKey(), true)
        logShardStates(clusterState);
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "5b")
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().currentNodeId(), equalTo("node2"));
        // assertThat(clusterState.getRoutingNodes().node(nodeWithPrimary).size(), equalTo(0));
        routingAllocation.debugDecision(true);
        // Two shards should start happily
            .metadata(metadata)
            );
            singleton(DiscoveryNodeRole.DATA_ROLE),
        Map<String, DiskUsage> usages = new HashMap<>();
            .nodes(
            clusterState.getRoutingNodes()
            )
    }
        assertThat(decision.type(), equalTo(Decision.Type.NO));
import java.util.Map;
        ClusterState baseClusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            // reset free space on node 3 and reserve space on node1
            Version.CURRENT
        final ClusterInfoService clusterInfoService = () -> new DevNullClusterInfo(usages, usages, Map.of());
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 10)); // 90% used
            .build();
            logShardStates(clusterState);
            emptyMap(),
        logShardStates(clusterState);
        strategy = new AllocationService(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .metadata(metadata)
            .build();
        Settings diskSettings = Settings.builder()
        logShardStates(clusterState);
        deciders = new AllocationDeciders(
            .metadata(metadata)
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.8)
        // Set the high threshold to 70 instead of 80
            .build();
        shards.put(shardId, new RestoreInProgress.ShardRestoreStatus("node1"));
            final ClusterState clusterStateThatRejectsCommands = clusterState;
                    ),
                    .addIndexShard(new IndexShardRoutingTable.Builder(firstRouting.shardId()).addShard(firstRouting).build())
            cis,
            logger.info("--> calling fake getClusterInfo");
        ClusterInfoService cis = () -> {
        // Assert that the replica couldn't be started since node1 doesn't have enough space
        // Now the replica should be able to initialize
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
            buildNewFakeTransportAddress(),
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
                Arrays.asList(
        };
 *
        // Assert that the replica is initialized now that node3 is available with enough space
            buildNewFakeTransportAddress(),
        // Shards remain started
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        firstRoutingNode = new RoutingNode("node2", discoveryNode2, firstRouting, secondRouting);
        assertThat(clusterState.getRoutingNodes().node("node4").size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        logger.info(
        logger.info("--> adding two nodes");
        assertThat(clusterState.getRoutingNodes().node("node4").size(), equalTo(1));
        );
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), 0.5)
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        AllocationDeciders deciders = new AllocationDeciders(
                    diskThresholdDecider
                .allMatch(unassignedInfo -> Reason.NEW_INDEX_RESTORED.equals(unassignedInfo.getReason())),
            "node2",
                containsString("the node has fewer free bytes remaining than the total size of all incoming shards")
            null,
            discoveryNodesBuilder.add(clusterManagerNode);
            clusterState = applyStartedShardsUntilNoChange(clusterState, strategy);
            this(leastAvailableSpaceUsage, mostAvailableSpaceUsage, null, shardSizes, Map.of(), nodeFileCacheStats);
        // as it randomises nodes to check for potential moves
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        );
            AllocationCommands cmds = new AllocationCommands(moveAllocationCommand);
    }
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 20)); // 80% used
        usages.put("node4", new DiskUsage("node4", "node4", "/dev/null", 100, 80)); // 20% used
                Arrays.asList(
    public void logShardStates(ClusterState state) {
                    new SameShardAllocationDecider(
        logShardStates(clusterState);
            logger.info("--> shard allocation depends on its size");
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            .putCustom(RestoreInProgress.TYPE, restores.build())
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
            ((Decision.Single) decision).getExplanation()
        // and therefor we will have sufficient disk space on node1.
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
            buildNewFakeTransportAddress(),
            deciders,
            assertThat(
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 100)); // 0% used
            .routingTable(routingTable)
 * under the License.
        final Map<String, Long> shardSizes = new HashMap<>();
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
 *
                .map(ShardRouting::unassignedInfo)
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        Metadata metadata = Metadata.builder()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
                metadata.index("test"),
        // Assert that the replica is initialized now that node3 is available with enough space
        DevNullClusterInfo(
            return clusterInfo;
        logShardStates(clusterState);
            cis,
    public void testUnknownDiskUsage() {
                )
        usages.put("node3", new DiskUsage("node3", "node3", "/dev/null", 100, 0));  // 100% used
        usages.put("data", new DiskUsage("data", "data", "/dev/null", 100, 20));  // 80% used
                .allMatch(unassignedInfo -> AllocationStatus.NO_ATTEMPT.equals(unassignedInfo.getLastAllocationStatus())),
        logger.info("--> start the shards (primaries)");
            deciders,
                )
        DevNullClusterInfo(
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
        usages.put("node2", new DiskUsage("node2", "n2", "/dev/null", 100, 1)); // 99% used
package org.opensearch.cluster.routing.allocation.decider;
        return new DiskThresholdDecider(settings, new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS));
            )
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
    }
 * KIND, either express or implied.  See the License for the
        AllocationDeciders deciders = new AllocationDeciders(
        AllocationService strategy = new AllocationService(
        assertThat(decision.type(), equalTo(Decision.Type.YES));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    "the node is above the high watermark cluster setting [cluster.routing.allocation.disk.watermark.high=70%], using "
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            "--> unassigned: {}, initializing: {}, relocating: {}, started: {}",
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
        clusterState = strategy.reroute(clusterState, "reroute");
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
        // node2 now should not have new shards allocated to it, and shards cannot remain
            "node3",
        assertThat(shardRouting.relocatingNodeId(), nullValue());
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
    }
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        // Set the low threshold to 60 instead of 70
            }
        final Map<String, DiskUsage> usages = new HashMap<>();
            new RoutingNodes(clusterState),
                containsString(
            "node3",
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.common.UUIDs;
 * the Apache License, Version 2.0 (the "License"); you may
        // One shard is relocating off of node1
        routingAllocation = new RoutingAllocation(null, new RoutingNodes(clusterState), clusterState, clusterInfo, null, System.nanoTime());
import static org.hamcrest.Matchers.containsString;
            final Map<String, DiskUsage> leastAvailableSpaceUsage,
        Map<String, Long> shardSizes = new HashMap<>();
        clusterState = ClusterState.builder(baseClusterState).routingTable(builder.build()).build();
            )
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), "95%")
        DiskThresholdDecider decider = makeDecider(diskSettings);
        logger.info("--> changing decider settings");
import org.opensearch.snapshots.Snapshot;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "30b")
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .put(
import org.opensearch.core.index.Index;
            new BalancedShardsAllocator(Settings.EMPTY),
            new TestGatewayAllocator(),
        strategy = new AllocationService(
            null,
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder().add(discoveryNode1).add(discoveryNode2).build();
        Metadata metadata = Metadata.builder()
                        clusterSettings
        logger.info("--> adding node4");
import org.opensearch.test.gateway.TestGatewayAllocator;
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
                    new SameShardAllocationDecider(
        };
            .routingTable(initialRoutingTable)
            cis,
        // Set the low threshold to 50 instead of 60
import org.opensearch.cluster.routing.RoutingTable;
        secondRouting = TestShardRouting.newShardRouting("test", 1, "node1", "node2", true, ShardRoutingState.RELOCATING);
        clusterState = ClusterState.builder(clusterState)
            logger.info("--> simulating snapshot shards size retrieval failure");
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().currentNodeId(), equalTo("node1"));
        logger.info("--> apply INITIALIZING shards");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
            containsString(
import org.opensearch.cluster.node.DiscoveryNodes;
            deciders,
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().shardsWithState("test", INITIALIZING, STARTED).size(), equalTo(shouldAllocate ? 1 : 0));
 * license agreements. See the NOTICE file distributed with
        final ClusterInfoService cis = clusterInfoReference::get;
        final ClusterInfo clusterInfo = new DevNullClusterInfo(usages, usages, shardSizes);
        usages.put("node2", new DiskUsage("node2", "node2", "/dev/null", 100, 50)); // 50% used
            .addAsNewRestore(
        final AtomicReference<ClusterInfo> clusterInfoReference = new AtomicReference<>(clusterInfo);
import java.util.Arrays;
        // Set the high threshold to 60 instead of 70
        deciders = new AllocationDeciders(
                    shardSizes,
import org.opensearch.snapshots.SnapshotShardSizeInfo;
        assertThat(result.routingTable().index("test").getShards().get(1).primaryShard().state(), equalTo(RELOCATING));
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.ClusterState;
            final Map<String, DiskUsage> leastAvailableSpaceUsage,
                    + "actual free: [20.0%]"
            clusterState,
            );
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
        secondRouting = TestShardRouting.newShardRouting("test", 1, "node2", "node3", true, ShardRoutingState.RELOCATING);
import static org.hamcrest.Matchers.nullValue;
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "60%")
        final SnapshotShard snapshotShard = new SnapshotShard(snapshot, indexId, shardId);
        // Make node without the primary now habitable to replicas
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
                    makeDecider(diskSettings)
            .build();
            .put(IndexMetadata.builder("foo").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        );
            logger.info("--> calling fake getClusterInfo");
        {
                )
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().state(), equalTo(STARTED));
        );
            emptyMap(),
        DiskThresholdDecider decider = makeDecider(Settings.EMPTY);
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            )
                    .addIndexShard(new IndexShardRoutingTable.Builder(secondRouting.shardId()).addShard(secondRouting).build())
        // Two shards consuming each 80% of disk space while 70% is allowed, so shard 0 isn't allowed here
            .build();
            shouldAllocate = shardSizeInBytes < usages.get("node1").getFreeBytes();
    }
            )
        shardSizes.put("[test][1][p]", 40L);
            new BalancedShardsAllocator(Settings.EMPTY),
            new DiskThresholdDecider.DiskUsageWithRelocations(new DiskUsage("node2", "n2", "/dev/null", 100, 30), 0L),
                        Settings.EMPTY,
        assertThat(result.routingTable().index("test").getShards().get(0).primaryShard().state(), equalTo(STARTED));
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
        Settings diskSettings = Settings.builder()
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "60%")
            final Map<String, NodeResourceUsageStats> nodeResourceUsages,
            "node1",
        diskSettings = Settings.builder()
        );
        RoutingAllocation routingAllocation = new RoutingAllocation(
        ClusterState updateClusterState = ClusterState.builder(clusterState)
        );
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            snapshotShardSizeInfoRef::get
            null,
        // Node4 is available now, so the shard is moved off of node2
            )
        assertEquals(
        usages.put("node1", new DiskUsage("node1", "node1", "/dev/null", 100, 10)); // 90% used
            buildNewFakeTransportAddress(),
        assertThat(decision.getExplanation(), containsString("there is only a single data node present"));
        final Map<String, Long> shardSizes = new HashMap<>();
            singleton(DiscoveryNodeRole.DATA_ROLE),
            .metadata(metadata)
            .build();
        // Shard can't be allocated to node1 (or node2) because it would cause too much usage
    public void testDiskThreshold() {
        // https://github.com/opensearch-project/OpenSearch/pull/15239/
            assertThat(
        clusterState = ClusterState.builder(clusterState)
        // One shard is relocating off of node2 now
                expectThrows(IllegalArgumentException.class, () -> strategy.reroute(clusterStateThatRejectsCommands, cmds, false, false))
        AllocationDeciders deciders = new AllocationDeciders(
            )
            buildNewFakeTransportAddress(),
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
        clusterState = strategy.reroute(clusterState, "reroute");
            clusterInfoReference.set(overfullClusterInfo);
        routingAllocation.debugDecision(true);
            clusterState = strategy.reroute(clusterState, cmds, false, false).getClusterState();
        logger.info("--> adding node3");
        logger.info("--> changing settings again");
                new RecoverySource.SnapshotRecoverySource("_restore_uuid", snapshot, Version.CURRENT, indexId),
        firstRouting = TestShardRouting.newShardRouting("test", 0, "node2", null, true, ShardRoutingState.STARTED);
            .build();
    }
        // Set the low threshold to 60 instead of 70
        logger.info("--> adding node1");
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        }
            new TestGatewayAllocator(),
 */
            clusterState,
            );
            cis,
        largerShardSizes.put("[test][0][p]", 14L);
        );
                                                                                     // automatically ignore single-node clusters
        logger.info("--> adding two nodes");
            )
        clusterState = strategy.reroute(clusterState, "reroute");
                // no shards on node1 since all its free space is reserved
        logger.info("--> start the shards (replicas)");
                        Settings.EMPTY,
            is(true)
            new TestGatewayAllocator(),
            .nodes(DiscoveryNodes.builder().add(newNode("node1", defaultWithWarmRole)).add(newNode("node2", defaultWithWarmRole)))
                containsString(
            .build();
        // Shards remain started
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(1));
            singleton(DiscoveryNodeRole.DATA_ROLE),
            EmptySnapshotsInfoService.INSTANCE
                )
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
            );
        // because it's a primary that's never been allocated before
import org.opensearch.cluster.routing.ShardRoutingState;
            final Map<String, DiskUsage> mostAvailableSpaceUsage,
            "node1",
            "",
        clusterState = strategy.reroute(clusterState, "reroute");
            rn.shardsWithState(RELOCATING).size(),
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        logShardStates(clusterState);
        shardSizes.put("[test][0][r]", 14L);
        ShardRouting shardRouting = result.routingTable().index("test").getShards().get(0).primaryShard();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(1));
    }
            .build();
        assertThat(result, equalTo(clusterState));
            EmptySnapshotsInfoService.INSTANCE
        );
                    new RestoreInProgressAllocationDecider(),
            .routingTable(initialRoutingTable)
        );
        AllocationService strategy = new AllocationService(
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            CLUSTER_MANAGER_DATA_ROLES,
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.PINNED_FILE_STATS)
        logShardStates(clusterState);
    }
        assertThat(clusterState.getRoutingNodes().node("node4").size(), equalTo(1));
            )
        logger.info("--> changing decider settings");
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        );
                nodeResourceUsages
                        new ClusterInfo.ReservedSpace.Builder().add(new ShardId("", "", 0), between(51, 200)).build()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        }
        );
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.index.store.remote.filecache.AggregateFileCacheStats;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
                    .putInSyncAllocationIds(0, singleton(AllocationId.newInitializing().getId()))
        logShardStates(clusterState);
        shardSizes.put("[test][0][p]", 10L); // 10 bytes
                new FileCacheStats(0, 0, 1000, 0, 0, 0, 0, 0, FileCacheStatsType.OVER_ALL_STATS),
        );
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            .nodes(
        }
        logger.info("--> adding node5");
                    new SameShardAllocationDecider(
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
 * compatible open source license.
        );
                0,
        strategy = new AllocationService(
            ((Decision.Single) decision).getExplanation(),
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "60%")
    public void testDiskThresholdWithAbsoluteSizes() {
            Version.CURRENT
        logger.info(
        }
                ((Decision.Single) decision).getExplanation(),
        largerShardSizes.put("[test2][0][p]", 2L);
            EmptySnapshotsInfoService.INSTANCE
        ClusterInfoService cis = () -> {
        builder = RoutingTable.builder()
            );
 * this work for additional information regarding copyright
        logShardStates(clusterState);
                    .numberOfReplicas(0)
                reservedSpace,
        ShardId shardId = shardRouting.shardId();
        } else {
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        DiscoveryNode discoveryNode1 = new DiscoveryNode(
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                nodeFileCacheStats,
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_DISK_FLOOD_STAGE_WATERMARK_SETTING.getKey(), "20b")
        final RoutingTable routingTable = RoutingTable.builder()
        );
                // no shards on node3 since it has no free space
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(1));
                    Map.of(
 */
        RoutingTable forceAssignedRoutingTable = RoutingTable.builder()
        AllocationService strategy = new AllocationService(
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "40b")
        final Snapshot snapshot = new Snapshot("_repository", new SnapshotId("_snapshot_name", UUIDs.randomBase64UUID(random())));
        ShardRouting fooRouting = TestShardRouting.newShardRouting("foo", 0, null, true, ShardRoutingState.UNASSIGNED);
        DiscoveryNode clusterManagerNode = new DiscoveryNode(
        final long shardSizeInBytes = randomBoolean() ? 10L : 50L;
                assertThat(shardRouting.toString(), shardRouting.currentNodeId(), oneOf("node1", "node2"));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_HIGH_DISK_WATERMARK_SETTING.getKey(), 0.7)
            new HashSet<>(Arrays.asList(new SameShardAllocationDecider(Settings.EMPTY, clusterSettings), makeDecider(diskSettings)))
            "cluster-manager",
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            .put(DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_LOW_DISK_WATERMARK_SETTING.getKey(), "60%")
            new TestGatewayAllocator(),
        fileCacheStatsMap.put(
            nodeWithPrimary = "node2";
        logShardStates(clusterState);
            .build();
            clusterInfoReference.set(overfullClusterInfo);
        logShardStates(clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(0));
        }
            clusterState,
            .build();
                    new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
        );
            EmptySnapshotsInfoService.INSTANCE
import org.opensearch.cluster.ClusterInfoService;
            new BalancedShardsAllocator(Settings.EMPTY),
import org.opensearch.snapshots.SnapshotId;
        routingAllocation.debugDecision(true);
            cis,
        );
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
            );
        // Shard hasn't been moved off of node2 yet because there's nowhere for it to go
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(0));
        usages.put("node1", new DiskUsage("node1", "n1", "/dev/null", 100, 100)); // 0% used
        shardSizes.put("[test2][0][r]", 1L);
                .shardsWithState(UNASSIGNED)
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
/*
        ClusterInfoService cis = () -> {
        ClusterInfoService cis = () -> {
        Settings diskSettings = Settings.builder()
        final Map<String, Long> shardSizes = new HashMap<>();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
            .add(
        ClusterState clusterState = ClusterState.builder(baseClusterState).routingTable(builder.build()).build();
            deciders,
        );  // 99% used
        // Assert that the replica couldn't be started since node1 doesn't have enough space
        AllocationDeciders deciders = new AllocationDeciders(
        );
            .build();
