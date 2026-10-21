        final DiscoveryNode oldNode2 = new DiscoveryNode(
                    + "] to a node with equal-or-newer version ["
                    .addIndexShard(
                        )
            Settings.builder()
            newNode.node().getVersion(),
            CLUSTER_MANAGER_DATA_ROLES,
                            .addShard(
import static java.util.Collections.shuffle;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
        );
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
                                oldNode2.getId(),
                    } else {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            new TestGatewayAllocator(),
            }
                    .build()
            .nodes(DiscoveryNodes.builder().add(newNode1).add(newNode2).add(oldNode1).add(oldNode2))
            UUIDs.randomBase64UUID(),
import static org.hamcrest.core.Is.is;
 * KIND, either express or implied.  See the License for the
        assertThat(
        }
                logger.trace(
        clusterState = service.disassociateDeadNodes(clusterState, true, "reroute");
        RoutingTable routingTable = RoutingTable.builder()
            .nodes(DiscoveryNodes.builder().add(newNode("new2")).add(newNode("new1")).add(newNode("new0")))
            .build();
            if (!r.primary()) {
                    .add(newNode("old2", VersionUtils.getPreviousVersion()))
                .build()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(2))
                                    shard1.getId(),
            }
    public void testRandom() {
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
                    + oldNode.node().getVersion()
        final DiscoveryNode newNode = new DiscoveryNode(
            .routingTable(initialRoutingTable)
import org.opensearch.cluster.routing.ShardRoutingHelper;
                                    ShardRoutingState.STARTED,
 * software distributed under the License is distributed on an
import org.opensearch.core.index.Index;
                                shard1.getId(),
    public void testRollingRestart() {
                                    shard1.getIndexName(),
        AllocationService strategy = new MockAllocationService(
                    .settings(settings(Version.CURRENT).put(Settings.EMPTY))
/*
 * not use this file except in compliance with the License.
                String toId = r.relocatingNodeId();
                                    null,
            .build();
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
import org.opensearch.cluster.routing.allocation.decider.Decision;
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocationId1P.getId(), allocationId1R.getId()))
            .metadata(metadata)
            .put(
        logger.info("Building initial routing table");
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        final Map<InternalSnapshotsInfoService.SnapshotShard, Long> snapshotShardSizes = new HashMap<>(numberOfShards);
            )
                    "From: {} with Version: {} to: {} with Version: {}",
        final IndexId indexId = new IndexId("test", UUIDs.randomBase64UUID(random()));
        AllocationId allocationId2R = AllocationId.newInitializing();
            )
                IndexRoutingTable.builder(shard2.getIndex())
            .nodes(
            is(
        clusterState = strategy.reroute(clusterState, "reroute");
        mutableShardRoutings = routingNodes.shardsWithState(ShardRoutingState.INITIALIZING);
            )
    }
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
            emptyMap(),
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(INITIALIZING).size(), equalTo(1));
            new BalancedShardsAllocator(Settings.EMPTY),
        final DiscoveryNode oldNode2 = new DiscoveryNode(
                shuffle(nodes, random());
                    + newNode.node().getVersion()
                    .numberOfShards(1)
import java.util.Arrays;
            CLUSTER_MANAGER_DATA_ROLES,
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(STARTED).size(), equalTo(2));
        List<ShardRouting> mutableShardRoutings = routingNodes.shardsWithState(ShardRoutingState.RELOCATING);
            .nodes(
                for (int j = nodes.size(); j < numNodes; j++) {
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(2))
        assertThat(decision.type(), is(Decision.Type.NO));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).currentNodeId(), nullValue());
        assertThat(decision.type(), is(Decision.Type.NO));
                DiscoveryNodes.builder().add(newNode("node0", VersionUtils.getPreviousVersion())).add(newNode("new1")).add(newNode("new0"))
            routingNodes = clusterState.getRoutingNodes();
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                );
                                    oldNode1.getId(),
            .nodes(
                    toId,
                assertThat(primary, notNullValue());
            .nodes(DiscoveryNodes.builder().add(newNode.node()).add(oldNode.node()))
            CLUSTER_MANAGER_DATA_ROLES,
import org.opensearch.snapshots.InternalSnapshotsInfoService;
            "newNode1",
        AllocationService service = createAllocationService(
        );
            UUIDs.randomBase64UUID(),
                    + newNode.node().getVersion()
                String fromId = r.currentNodeId();
        );
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
            .build();
import static org.hamcrest.Matchers.equalTo;
        for (ShardRouting r : mutableShardRoutings) {
 * ownership. Elasticsearch licenses this file to you under
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                                allocationId2P
            CLUSTER_MANAGER_DATA_ROLES,
            } else {
        final IndexId indexId = new IndexId("test", UUIDs.randomBase64UUID(random()));
                    .addAsRestore(
            .metadata(metadata)
            logger.trace("RoutingNodes: {}", clusterState.getRoutingNodes());
                    + newNode.node().getVersion()
            .settings(settings(Version.CURRENT))
                                    shard1.getId(),
            )
                    "From: {} with Version: {} to: {} with Version: {}",
        AllocationId allocationId1P = AllocationId.newInitializing();
        Metadata metadata = Metadata.builder()
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
        final ShardRouting primaryShard = clusterState.routingTable().shardRoutingTable(shardId).primaryShard();
        clusterState = ClusterState.builder(clusterState)
                        metadata.index("test"),
import org.opensearch.cluster.routing.allocation.decider.NodeVersionAllocationDecider;
        Metadata metadata = Metadata.builder()
            Collections.singleton(new NodeVersionAllocationDecider(segmentReplicationSettings))
                                allocationId1P
        AllocationService strategy = createAllocationService(
package org.opensearch.cluster.routing.allocation;
        final ShardRouting replicaShard = clusterState.routingTable().shardRoutingTable(shardId).replicaShards().get(0);
 * Unless required by applicable law or agreed to in writing,
        Metadata metadata = Metadata.builder().put(indexMetadata).build();
    private final Logger logger = LogManager.getLogger(NodeVersionAllocationDeciderTests.class);
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
                    routingNodes.node(toId).node().getVersion()
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
}
        clusterState = ClusterState.builder(clusterState)
            }
        RoutingAllocation routingAllocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
                    .add(newNode("old1", VersionUtils.getPreviousVersion()))
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.test.gateway.TestGatewayAllocator;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(UNASSIGNED).size(), equalTo(2));
            "newNode",
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
        logger.info("start two nodes and fully start the shards");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
                    .add(newNode("old0", VersionUtils.getPreviousVersion()))
                                    null,
        );
        final DiscoveryNode oldNode1 = new DiscoveryNode(
import org.opensearch.snapshots.SnapshotShardSizeInfo;
                    .settings(settings(Version.CURRENT).put(segmentReplicationSettings))
        ShardId shard1 = new ShardId("test1", "_na_", 0);
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
                        new IndexShardRoutingTable.Builder(shard1).addShard(
            emptyMap(),
        );
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(STARTED));
            );
                                    false,
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
                                shard2.getIndexName(),
                            )
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).state(), equalTo(UNASSIGNED));
        int iters = scaledRandomIntBetween(10, 100);
            .put(
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocationId2P.getId(), allocationId2R.getId()))
            allocationDeciders,
                                    oldNode1.getId(),
            snapshotShardSizes.put(new InternalSnapshotsInfoService.SnapshotShard(snapshot, indexId, shardId), randomNonNegativeLong());
                            .addShard(
        assertThat(decision.type(), is(Decision.Type.NO));
            .put(
                                shard2.getIndexName(),
            ClusterState newState = startInitializingShardsAndReroute(service, clusterState);
        assertThat(decision.type(), is(Decision.Type.YES));
            VersionUtils.getPreviousVersion()
import org.apache.logging.log4j.Logger;
                                shard1.getIndexName(),
            is(
        clusterState = ClusterState.builder(clusterState)
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
        routingAllocation.debugDecision(true);
        final DiscoveryNode newNode = new DiscoveryNode(
            is(
            final ShardId shardId = new ShardId(index, i);
                                null,
                    .numberOfReplicas(1)
        assertThat(decision.type(), is(Decision.Type.YES));
                            )
                "cannot allocate replica shard to a node with version ["
        );
                    toId,
        final ShardRouting startedPrimary = routingNodes.startShard(
                                    null,
            "oldNode2",
            changed = newState.equals(clusterState) == false;
        List<DiscoveryNode> nodes = new ArrayList<>();
                    "From: {} with Version: {} to: {} with Version: {}",
        assertThat(
            is(
        }
            "newNode",
            routingNodes.initializeShard(primaryShard, "newNode", null, 0, routingChangesObserver),
                                    null,
            .add(
                                    ShardRoutingState.STARTED,
                    )
        }
        );
            VersionUtils.getPreviousVersion()
                    routingNodes.node(fromId).node().getVersion(),
            .build();
import org.opensearch.cluster.routing.IndexRoutingTable;
        for (int i = 0; i < numberOfShards; i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            buildNewFakeTransportAddress(),
        int numIndices = between(1, 20);
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import java.util.List;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).currentNodeId(), notNullValue());
        decision = allocationDecider.canAllocate(replicaShard, oldNode, routingAllocation);
                    .numberOfReplicas(1)
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
        AllocationDeciders allocationDeciders = new AllocationDeciders(
import org.opensearch.snapshots.SnapshotId;
            is(
        routingAllocation = new RoutingAllocation(null, routingNodes, clusterState, null, null, 0);
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
                nodesBuilder.add(node);
            new TestGatewayAllocator(),
            "oldNode1",
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(5));
        RoutingTable.Builder rtBuilder = RoutingTable.builder();
                                true,
                    + "] is the same or newer than snapshot version ["
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            "oldNode1",
        decision = allocationDecider.canAllocate(
            clusterState = newState;
        }
                    toId,
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
            .numberOfShards(numberOfShards)
        );
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    .numberOfShards(1)
            .build();
                                shard2.getId(),
        logger.info("complete rebalancing");
            }
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(STARTED).size(), equalTo(1));
                        new IndexShardRoutingTable.Builder(shard2).addShard(
        final ShardId shardId = clusterState.routingTable().index("test").shard(0).getShardId();
        final RoutingChangesObserver routingChangesObserver = new RoutingChangesObserver.AbstractRoutingChangesObserver();
        );
                    + "] is older than the snapshot version ["
        );
            Settings.EMPTY
        boolean changed;
            Version.CURRENT
            .build();
                    + "]"
 *     http://www.apache.org/licenses/LICENSE-2.0
            CLUSTER_MANAGER_DATA_ROLES,
            )
                IndexMetadata.builder(shard2.getIndexName())
                assertTrue(routingNodes.node(toId).node().getVersion().onOrAfter(routingNodes.node(fromId).node().getVersion()));
                            TestShardRouting.newShardRouting(
import org.opensearch.cluster.routing.TestShardRouting;
            "newNode2",
        );
        for (int i = 0; i < numberOfShards; i++) {
                logger.trace(
        AllocationId allocationId2P = AllocationId.newInitializing();
            emptyMap(),
        clusterState = strategy.reroute(clusterState, "reroute");
        final NodeVersionAllocationDecider allocationDecider = new NodeVersionAllocationDecider(Settings.EMPTY);
    private void assertRecoveryNodeVersions(RoutingNodes routingNodes) {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(UNASSIGNED).size(), equalTo(1));
        ShardId shard2 = new ShardId("test2", "_na_", 0);
                "can allocate replica shard to a node with version ["
import org.opensearch.cluster.EmptyClusterInfoService;
        assertThat(state.routingTable().index(shard1.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(0));
import static org.opensearch.test.VersionUtils.randomVersion;
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        final DiscoveryNode newNode2 = new DiscoveryNode(
                ShardRouting primary = routingNodes.activePrimary(r.shardId());
            emptyMap(),
                .build()
                                true,
                                    oldNode2.getId(),
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            emptyMap(),
            buildNewFakeTransportAddress(),
                assertTrue(routingNodes.node(toId).node().getVersion().onOrAfter(routingNodes.node(fromId).node().getVersion()));
        return clusterState;
 * The OpenSearch Contributors require contributions made to
                String toId = r.currentNodeId();
            .add(
        decision = allocationDecider.canAllocate(
            new TestGatewayAllocator(),
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            buildNewFakeTransportAddress(),
            for (DiscoveryNode node : nodes) {
 * the Apache License, Version 2.0 (the "License"); you may
                        new IndexShardRoutingTable.Builder(shard2).addShard(
    }
 *
        logger.info("start all the primary shards, replicas will start initializing");
        assertThat(
import org.opensearch.cluster.routing.RecoverySource.SnapshotRecoverySource;
            logger,
                                    shard2.getId(),
            if (r.primary()) {
    }
        routingAllocation = new RoutingAllocation(null, routingNodes, clusterState, null, null, 0);
                    + "] since this is older than the primary version ["
            .build();
                                null,
                                true,
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
        }
    public void testRebalanceDoesNotAllocatePrimaryOnHigherVersionNodesSegrepEnabled() {
                nodes = nodes.subList(0, numNodes);
            () -> new SnapshotShardSizeInfo(snapshotShardSizes)
            )
                IndexMetadata.builder(shard1.getIndexName())
        state = strategy.reroute(state, new AllocationCommands(), true, false).getClusterState();
        );
        AllocationDeciders allocationDeciders = new AllocationDeciders(
                    )
 * under the License.
import java.util.HashMap;
        Settings segmentReplicationSettings = Settings.builder()
 * this work for additional information regarding copyright
                String toId = r.relocatingNodeId();
                                    allocationId1R
 * specific language governing permissions and limitations
                    + oldNode.node().getVersion()
            buildNewFakeTransportAddress(),
                            .build()
        Metadata metadata = Metadata.builder()
            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),
            .add(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            routingChangesObserver
                    .settings(settings(Version.CURRENT))
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), notNullValue());
        }
            .routingTable(routingTable)
                                    allocationId1R
                    .settings(settings(Version.CURRENT).put(Settings.EMPTY))
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        AllocationId allocationId1R = AllocationId.newInitializing();
            decision.getExplanation(),
            EmptySnapshotsInfoService.INSTANCE
        RoutingTable routingTable = RoutingTable.builder()
        for (int i = 0; i < numberOfShards; i++) {
                                    false,
            state.routingTable().index(shard2.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).get(0).primary(),
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocationId2P.getId(), allocationId2R.getId()))
import org.opensearch.test.VersionUtils;
            rtBuilder.addAsNew(metadata.index("test_" + i));
            oldNode.node().getVersion(),
                String fromId = primary.currentNodeId();
        Metadata metadata = builder.build();
        );
            indexMetadata.putInSyncAllocationIds(i, Collections.singleton("_test_"));
                                null,
                    .numberOfReplicas(1)
            .build();
                RoutingTable.builder()
                IndexRoutingTable.builder(shard1.getIndex())
            buildNewFakeTransportAddress(),
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).state(), equalTo(STARTED));
                                    shard2.getId(),
                                    allocationId2R
            if (nodes.size() > numNodes) {
                                ShardRoutingState.STARTED,
        assertThat(state.routingTable().index(shard2.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
        assertThat(
    public void testDoNotAllocateFromPrimary() {
                                shard1.getId(),
        );
            equalTo(false)
                            .addShard(
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            new BalancedShardsAllocator(Settings.EMPTY),
        final DiscoveryNode newNode1 = new DiscoveryNode(
            emptyMap(),
        decision = allocationDecider.canAllocate(ShardRoutingHelper.initialize(primaryShard, "newNode"), oldNode, routingAllocation);
                                )
                                TestShardRouting.newShardRouting(
                IndexMetadata.builder("test_" + i)
 */
            .routingTable(
            .metadata(metadata)
        final SnapshotRecoverySource oldVersionSnapshot = new SnapshotRecoverySource(
import org.opensearch.cluster.node.DiscoveryNodes;
            routingNodes.relocateShard(startedPrimary, "oldNode", 0, routingChangesObserver).v2(),
        ShardId shard2 = new ShardId("test2", "_na_", 0);
        do {
            )
            )
                String fromId = primary.currentNodeId();
            )
            )
        clusterState = stabilize(clusterState, service);
        for (int i = 0; i < numIndices; i++) {
        }
                DiscoveryNodes.builder()
        final DiscoveryNode oldNode2 = new DiscoveryNode(
    }
            new BalancedShardsAllocator(Settings.EMPTY),
                                true,
            CLUSTER_MANAGER_DATA_ROLES,
            CLUSTER_MANAGER_DATA_ROLES,
/*
                                ShardRoutingState.STARTED,
        }
            "oldNode2",
                        new IndexShardRoutingTable.Builder(shard1).addShard(
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                            )
                    + "]"
        }
                    + newNode.node().getVersion()
        AllocationId allocationId1R = AllocationId.newInitializing();
            Settings.builder()
        final SnapshotRecoverySource newVersionSnapshot = new SnapshotRecoverySource(
            .metadata(metadata)
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
                    .putInSyncAllocationIds(0, Sets.newHashSet(allocationId1P.getId(), allocationId1R.getId()))
            )
        }
                                    ShardRoutingState.STARTED,
            EmptyClusterInfoService.INSTANCE,
import org.opensearch.cluster.metadata.IndexMetadata;
        Decision decision = allocationDecider.canAllocate(primaryShard, newNode, routingAllocation);
 *
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(UNASSIGNED).size(), equalTo(1));
                    routingNodes.node(fromId).node().getVersion(),
    }
        final int numberOfShards = randomIntBetween(1, 3);
            .add(
import org.opensearch.cluster.routing.RoutingNode;
 *
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        clusterState = ClusterState.builder(clusterState)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            VersionUtils.getPreviousVersion()
                    .numberOfReplicas(between(0, 2))
        );
        );
        }
        routingNodes.startShard(
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3", VersionUtils.getPreviousVersion())))
            ShardRoutingHelper.newWithRestoreSource(primaryShard, oldVersionSnapshot),
                            TestShardRouting.newShardRouting(
            .numberOfReplicas(randomIntBetween(0, 3));
            clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
            buildNewFakeTransportAddress(),
            logger,
        // Make sure that primary shards are only allocated on the new node
                        nodes.add(newNode("node" + (nodeIdx++), randomBoolean() ? VersionUtils.getPreviousVersion() : Version.CURRENT));
    public void testRebalanceDoesNotAllocatePrimaryAndReplicasOnDifferentVersionNodes() {
                DiscoveryNodes.builder()
            .put(
                    )
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).state(), equalTo(UNASSIGNED));
                        )
                                TestShardRouting.newShardRouting(
            buildNewFakeTransportAddress(),
        }
                    .addIndexShard(
            is(
                                    allocationId2R
            } else {
            .build();
        );
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(5));
            )
import org.opensearch.indices.replication.common.ReplicationType;
            .build();
            buildNewFakeTransportAddress(),
import org.opensearch.cluster.metadata.Metadata;
        );
            equalTo(false)
            EmptyClusterInfoService.INSTANCE,
            routingAllocation
        AllocationId allocationId2R = AllocationId.newInitializing();
            indexId
            emptyMap(),
import org.opensearch.snapshots.Snapshot;
import org.opensearch.repositories.IndexId;
import org.apache.logging.log4j.LogManager;
        routingAllocation.debugDecision(true);
                            )
        for (ShardRouting r : mutableShardRoutings) {
                    + newNode.node().getVersion()
import org.opensearch.cluster.routing.ShardRoutingState;
                "node version ["
                    + oldNode.node().getVersion()
        ShardId shard1 = new ShardId("test1", "_na_", 0);
 * You may obtain a copy of the License at
            )
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
                                    shard2.getIndexName(),
 * this file be licensed under the Apache-2.0 license or a
        Metadata.Builder builder = Metadata.builder();
            VersionUtils.getPreviousVersion()
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.RoutingNodes;
                logger.trace(
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        );
            buildNewFakeTransportAddress(),
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(STARTED));
                                )
        );
            .nodes(DiscoveryNodes.builder().add(newNode).add(oldNode1).add(oldNode2))
import org.opensearch.common.UUIDs;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(STARTED).size(), equalTo(1));
        assertRecoveryNodeVersions(routingNodes);
        clusterState = stabilize(clusterState, service);
            decision.getExplanation(),
import org.opensearch.common.util.set.Sets;
        assertThat(decision.type(), is(Decision.Type.YES));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                }
        AllocationId allocationId2P = AllocationId.newInitializing();
                                ShardRoutingState.STARTED,
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
public class NodeVersionAllocationDeciderTests extends OpenSearchAllocationTestCase {
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
        RoutingNode oldNode = new RoutingNode("oldNode", newNode("oldNode", VersionUtils.getPreviousVersion()));
import org.opensearch.core.index.shard.ShardId;
        ClusterState clusterState = ClusterState.builder(clusterName)
        assertThat(
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            builder.put(
                                )
        );
        RoutingNode newNode = new RoutingNode("newNode", newNode("newNode", Version.CURRENT));
            emptyMap(),
                                shard2.getId(),
                                TestShardRouting.newShardRouting(
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
                );
                    .numberOfReplicas(1)
        assertThat(decision.getExplanation(), is("the primary shard is new or already existed on the node"));
        AllocationService strategy = new MockAllocationService(
        );
        );
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        );
        }
        final DiscoveryNode oldNode1 = new DiscoveryNode(
        }
                                    false,
        for (int i = 0; i < iters; i++) {
        AllocationService service = createAllocationService(
            emptyMap(),
        );
                    }
import org.opensearch.common.settings.Settings;
                            TestShardRouting.newShardRouting(
import org.opensearch.cluster.routing.AllocationId;
            .build();
        assertThat(state.routingTable().index(shard2.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(0));
            decision.getExplanation(),
        Metadata metadata = Metadata.builder()
            .nodes(DiscoveryNodes.builder().add(newNode).add(oldNode1).add(oldNode2))
            CLUSTER_MANAGER_DATA_ROLES,
            .build();
        assertThat(
        );
        clusterState = ClusterState.builder(clusterState)
        Metadata metadata = Metadata.builder()
                    + "] since this is equal-or-newer than the primary version ["
            Version.CURRENT
            routingAllocation
                                shard1.getIndexName(),
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        } while (changed);
                "cannot relocate primary shard from a node with version ["
            .routingTable(routingTable)
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(STARTED).size(), equalTo(1));
            VersionUtils.getPreviousVersion()
/*
            .metadata(metadata)
                "node version ["
                        nodes.add(newNode("node" + (nodeIdx++), randomVersion(random())));
        }
import org.opensearch.cluster.routing.ShardRouting;
            .metadata(metadata)
import org.opensearch.cluster.node.DiscoveryNode;
                                    false,
                    .numberOfShards(1)
        );
                    + "] to a node with older version ["
            .metadata(metadata)
        logger.info("Building initial routing table");
import static java.util.Collections.emptyMap;
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        logger.trace("RoutingNodes: {}", routingNodes);
            .build();
        routingAllocation.debugDecision(true);
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
            .build();
        decision = allocationDecider.canAllocate(replicaShard, newNode, routingAllocation);
            decision.getExplanation(),
            emptyMap(),
        assertThat(
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        );
        );
import static org.hamcrest.Matchers.notNullValue;
        assertThat(routingTable.shardsWithState(UNASSIGNED).size(), equalTo(routingTable.allShards().size()));
            )
                assertThat(primary, notNullValue());
                                    ShardRoutingState.STARTED,
        final org.opensearch.cluster.ClusterName clusterName = org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            assertEquals("newNode", state.routingTable().index("test").getShards().get(i).primaryShard().currentNodeId());
            allocationDeciders,
            CLUSTER_MANAGER_DATA_ROLES,
            )
            .routingTable(routingTable)
                                newNode.getId(),
            decision.getExplanation(),
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
 */
            new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID())),
        decision = allocationDecider.canAllocate(ShardRoutingHelper.initialize(primaryShard, "oldNode"), newNode, routingAllocation);
            .routingTable(initialRoutingTable)
            clusterState = stabilize(clusterState, service);
                    if (frequently()) {
        assertThat(decision.type(), is(Decision.Type.YES));
        AllocationService strategy = new MockAllocationService(
                    + "]"
 * license agreements. See the NOTICE file distributed with
        );
 */
                .build()
        );
        int nodeIdx = 0;
                            TestShardRouting.newShardRouting(
                    )
                    routingNodes.node(fromId).node().getVersion(),
        );
            Arrays.asList(new ReplicaAfterPrimaryActiveAllocationDecider(), new NodeVersionAllocationDecider(Settings.EMPTY))
            oldNode,
                                    shard1.getIndexName(),
            .build();
 * SPDX-License-Identifier: Apache-2.0
                            .build()
            VersionUtils.getPreviousVersion()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4"))).build();
            EmptySnapshotsInfoService.INSTANCE
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(UNASSIGNED).size(), equalTo(1));
                    .settings(settings(Version.CURRENT).put(segmentReplicationSettings))
            routingChangesObserver
import java.util.Map;
        ClusterState state = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            decision.getExplanation(),
 * compatible open source license.
                    .numberOfShards(between(1, 5))
                    fromId,
        final Index index = metadata.index("test").getIndex();
                assertTrue(routingNodes.node(toId).node().getVersion().onOrAfter(routingNodes.node(fromId).node().getVersion()));
import org.opensearch.cluster.routing.RoutingTable;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            allocationDeciders,
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            int numNodes = between(1, 20);
import org.opensearch.snapshots.EmptySnapshotsInfoService;
                            .build()
        AllocationDeciders allocationDeciders = new AllocationDeciders(
        RoutingTable routingTable = rtBuilder.build();
                                newNode.getId(),
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        // the two indices must stay as is, the replicas cannot move to oldNode2 because versions don't match
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                                TestShardRouting.newShardRouting(
                        )
        // the two indices must stay as is, the replicas cannot move to oldNode2 because versions don't match
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), notNullValue());
                assertThat(fromId, notNullValue());
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
                                    oldNode1.getId(),
                        new SnapshotRecoverySource(UUIDs.randomBase64UUID(), snapshot, Version.CURRENT, indexId)
            ShardRoutingHelper.newWithRestoreSource(primaryShard, newVersionSnapshot),
    }
                                )
        state = strategy.reroute(state, new AllocationCommands(), true, false).getClusterState();
                    fromId,
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(3));
                            )
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShardsWithState(INITIALIZING).size(), equalTo(1));
            "oldNode2",
    }
            buildNewFakeTransportAddress(),
            )
    public void testRestoreDoesNotAllocateSnapshotOnOlderNodes() {
            .build();
        clusterState = ClusterState.builder(clusterState)
        for (int i = 0; i < numIndices; i++) {
            newNode,
        );
        AllocationId allocationId1P = AllocationId.newInitializing();
                "can relocate primary shard from a node with version ["
                    .addIndexShard(
            Version.CURRENT
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(2).currentNodeId(), nullValue());
        state = strategy.reroute(state, new AllocationCommands(), true, false).getClusterState();
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
                IndexRoutingTable.builder(shard1.getIndex())
                    )
                                null,
                                ShardRoutingState.STARTED,
                assertThat(toId, notNullValue());
                    .addIndexShard(
            state.routingTable().index(shard1.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).get(0).primary(),
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import static org.hamcrest.Matchers.nullValue;
                    + "]"
                                    shard2.getIndexName(),
        }
import java.util.ArrayList;
            .build();
                IndexMetadata.builder(shard2.getIndexName())
        final IndexMetadata.Builder indexMetadata = IndexMetadata.builder("test")
            Collections.singleton(new NodeVersionAllocationDecider(Settings.EMPTY))
                                oldNode1.getId(),
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
                    + oldNode.node().getVersion()
                                allocationId1P
                            )
            CLUSTER_MANAGER_DATA_ROLES,
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
    public void testMessages() {
                    + oldNode.node().getVersion()
        clusterState = stabilize(clusterState, service);
                            .addShard(
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
                    + newNode.node().getVersion()
        }
            .routingTable(routingTable)
        assertThat(state.routingTable().index(shard1.getIndex()).shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(1));
import org.opensearch.Version;
            assertRecoveryNodeVersions(routingNodes);
        clusterState = stabilize(clusterState, service);
                IndexMetadata.builder(shard1.getIndexName())
                    routingNodes.node(toId).node().getVersion()
            .build();
                IndexRoutingTable.builder(shard2.getIndex())
            Version.CURRENT
            )
                    + "]"
            EmptyClusterInfoService.INSTANCE,
                    routingNodes.node(toId).node().getVersion()
                ShardRouting primary = routingNodes.activePrimary(r.shardId());
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
        final Snapshot snapshot = new Snapshot("rep1", new SnapshotId("snp1", UUIDs.randomBase64UUID()));
                    .add(newNode("new0"))
        final DiscoveryNode oldNode1 = new DiscoveryNode(
                    fromId,
    }
        final RoutingNodes routingNodes = new RoutingNodes(clusterState, false);
        logger.trace("RoutingNodes: {}", clusterState.getRoutingNodes());
                    .add(newNode("old1", VersionUtils.getPreviousVersion()))
            indexId
        logger.info("Building initial routing table");
                                allocationId2P
                        )
                    + oldNode.node().getVersion()
        );
                            .build()
            Settings.builder()
                    .numberOfShards(1)
import org.opensearch.cluster.routing.RoutingChangesObserver;
        assertThat(
                            )
                            )
                    + "]"
            DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
                );
                    .add(newNode("old0", VersionUtils.getPreviousVersion()))
    private ClusterState stabilize(ClusterState clusterState, AllocationService service) {
import java.util.Collections;
            "oldNode1",
            )
