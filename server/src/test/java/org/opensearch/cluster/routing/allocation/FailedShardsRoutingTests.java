            .routingTable(initialRoutingTable)
        newState = allocation.applyFailedShard(clusterState, primaryShardRouting2, randomBoolean());
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            ) != null) {
            assertThat(
        final String nodeHoldingPrimary = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
            Settings.builder()
                    0,
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(newState, not(equalTo(clusterState)));
        Metadata metadata = Metadata.builder()
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
                failedShard.getRoutingEntry().shardId(),
        // remote store migration metadata settings
 * license agreements. See the NOTICE file distributed with
import org.opensearch.indices.replication.common.ReplicationType;
        ShardRouting primaryShard0 = clusterState.routingTable().index("test").shard(0).primaryShard();
            );
                failedShards.add(new FailedShard(shardToFail, null, null, randomBoolean()));
    public void testFailAllReplicasInitializingOnPrimaryFail() {
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(metadata)
            assertTrue(
            .routingTable(routingTable)
        assertNotEquals(clusterState, newState);
        ClusterState newState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
            if (!routingNodes.node(failedNode).isEmpty()) {
import org.opensearch.node.remotestore.RemoteStoreNodeService;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), lessThan(3));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));
        ShardRouting newPrimaryShard = clusterState.routingTable().index("test").shard(0).primaryShard();
        assertThat(newState, not(equalTo(clusterState)));
        // fail primary shard again
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
        ShardRouting startedReplica = clusterState.getRoutingNodes().activeReplicaWithOldestVersion(shardId);
            false
            .metadata(metadata)
        // start one replica so it can take over.
                anyOf(equalTo("node1"), equalTo("node2"))
        // add 4 nodes
            .put(IndexMetadata.builder("test").settings(settingsBuilder).numberOfShards(1).numberOfReplicas(3))
 * the Apache License, Version 2.0 (the "License"); you may
                failedShard.getRoutingEntry().allocationId().getId()
            ShardRouting shardToFail = routingNodes.node(failedNode).iterator().next();
                new MoveAllocationCommand(
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        DiscoveryNode remoteNode2 = new DiscoveryNode(
import static org.hamcrest.Matchers.equalTo;
    }
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
                failedNodes.add(failedNode);
        clusterState = allocation.reroute(clusterState, "reroute");
        // start primary shard
        // check promotion of replica to primary
        newState = allocation.applyFailedShard(clusterState, primaryShardRouting1, randomBoolean());
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        ShardId shardId = new ShardId(metadata.index("test").getIndex(), 0);
        );
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        clusterState = strategy.applyFailedShards(clusterState, failedShards);
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        // start primary shards
            assertThat(
                )
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            primaryShardRouting3.currentNodeId().equals(nonRemoteNode1.getId())
                    .build()
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
                anyOf(equalTo("node1"), equalTo("node2"))
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                    .add(
        );
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        );
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
import static org.hamcrest.Matchers.nullValue;
        // add remote and non-remote nodes and start replica shards
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(RELOCATING));
        clusterState = allocation.applyFailedShard(
public class FailedShardsRoutingTests extends OpenSearchAllocationTestCase {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        ShardRouting primaryShardRouting3 = clusterState.routingTable().index("test").shard(0).primaryShard();
    public void testFailAllReplicasInitializingOnPrimaryFailWhileHavingAReplicaToElect() {
            .build();
                        newNode(
            buildNewFakeTransportAddress(),
        assertThat(newState, not(clusterState));
        assertThat(newState, not(equalTo(clusterState)));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
                // Skip the node that the primary was on, it doesn't have a replica so doesn't need a version check
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        ArrayList<FailedShard> failedShards = new ArrayList<>();
        clusterState = startShardsAndReroute(allocation, clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).get(0));
        logger.info("Fail the shards on node 3");
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(RELOCATING));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            );
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(1));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED, RELOCATING), equalTo(2));
        for (String failedNode : failedNodes) {
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(2));
    }
            );
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        logger.info("--> all shards allocated, replica that should be promoted: {}", startedReplica);
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertNotEquals(primaryShardRouting1.currentNodeId(), primaryShardRouting2.currentNodeId());
        clusterState = newState;
            .build();
        Settings.Builder settingsBuilder = isSegmentReplicationEnabled
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
                anyOf(equalTo("node1"), equalTo("node2"))
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
                clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(),
    public void testSingleShardMultipleAllocationFailures() {
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        );
            .build();
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = ClusterState.builder(clusterState).routingTable(allocation.reroute(clusterState, "reroute").routingTable()).build();
        DiscoveryNode remoteNode3 = new DiscoveryNode(
        }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        AllocationService allocation = createAllocationService(Settings.builder().build());
        );
            clusterState = ClusterState.builder(clusterState)
                anyOf(equalTo("node1"), equalTo("node2"))
            .build();
            primaryShardRouting1.currentNodeId().equals(remoteNode2.getId())
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2-1.0", Version.fromString("1.0.0"))))
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(3));
            .build();
                    )
        AllocationService strategy = createAllocationService(
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        String origPrimaryNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
        assertThat(newPrimaryShard, not(equalTo(primaryShardToFail)));
            .build();
 * You may obtain a copy of the License at
        clusterState = allocation.applyFailedShard(
 * SPDX-License-Identifier: Apache-2.0
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState)
    private void testReplicaIsPromoted(boolean isSegmentReplicationEnabled) {
 * specific language governing permissions and limitations
                clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(),
        );
                    .put(MIGRATION_DIRECTION_SETTING.getKey(), RemoteStoreNodeService.Direction.REMOTE_STORE.direction)
        // starting replicas
        // fail the primary shard again and make sure the correct replica is promoted
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        logger.info("fail the first shard, will start INITIALIZING on the second node");
        );
            assertThat(
                fail("shard was re-assigned to failed node " + failedNode);
        logger.info("--> fail primary shard recovering instance on node1 being relocated");
        for (FailedShard failedShard : failedShards) {
        newState = startInitializingShardsAndReroute(strategy, clusterState);
                        newNode(
            .build();
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            remoteStoreNodeAttributes,
        // verify that promoted replica again exists on a remote node
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .nodes(
        clusterState = allocation.reroute(clusterState, "reroute");
    public void testReplicaOnOldestVersionIsPromotedDocRep() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(2));
        Set<ShardRouting> shardRoutingsToFail = new HashSet<>();
            .build();
    }
        // fail primary shard again
            not(equalTo(shardToFail.currentNodeId()))
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED, RELOCATING), equalTo(2));
            Settings.builder()
        clusterState = newState;
            .build();
        logger.info("Adding two nodes and performing rerouting");
                "expected node [" + cursor.getId() + "] with version " + nodeVer + " to be after " + replicaNodeVersion,
            )
                replicaNodeVersion.onOrBefore(nodeVer)
    }
            .routingTable(initialRoutingTable)
import org.opensearch.cluster.metadata.Metadata;
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            if ("node1".equals(cursor.getId())) {
                shardRoutingsToFail.add(shardToFail);
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        Metadata metadata = Metadata.builder()
        // the primary gets allocated on another node, replicas are initializing
            .routingTable(initialRoutingTable)
        );
        logger.info("--> verifying all is allocated");
                    0,
        ShardRouting shardToFail = routingNodes.node("node3").iterator().next();
        while (!clusterState.routingTable().shardsWithState(UNASSIGNED).isEmpty()) {
        AllocationService strategy = createAllocationService(
        // fail the primary shard again, and ensure the same thing happens
            Settings.builder()
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            .metadata(metadata)
            .routingTable(initialRoutingTable)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertTrue(
        AllocationService strategy = createAllocationService(
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        int shardsToFail = randomIntBetween(1, numberOfReplicas);
        assertThat(newState, not(equalTo(clusterState)));
            ),
                        )
                anyOf(equalTo("node2"), equalTo("node1"))
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo(origReplicaNodeId));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
 * ownership. Elasticsearch licenses this file to you under
            clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
                DiscoveryNodes.builder(clusterState.nodes())
            Settings.builder()
        // verify that promoted replica exists on a non-remote node
import org.opensearch.common.settings.Settings;
            UUIDs.base64UUID(),
        for (int i = 0; i < numberOfReplicas + 1; i++) {
        }
 * software distributed under the License is distributed on an
            clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
        clusterState = newState;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .metadata(metadata)
        }
            ),
            REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
            .metadata(metadata)
            );
                clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(),
        newState = strategy.applyFailedShard(clusterState, firstShard, randomBoolean());
 *
/*
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
import java.util.Set;
    @LockFeatureFlag(REMOTE_STORE_MIGRATION_EXPERIMENTAL)
                        )
            );
        // add a remote node and start primary shard
            false,
        newPrimaryShard = clusterState.routingTable().index("test").shard(0).primaryShard();
            primaryShardRouting2.currentNodeId().equals(remoteNode2.getId())
import static org.hamcrest.Matchers.anyOf;
        logger.info("Building initial routing table");
            randomBoolean()
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
            clusterState,
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            .build();
        logger.info("Start the shards (primaries)");
        ClusterState newState = allocation.applyFailedShard(clusterState, primaryShardToFail, randomBoolean());
        assertEquals(3, clusterState.getRoutingNodes().shardsWithState(STARTED).size());
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
                anyOf(equalTo("node2"), equalTo("node1"))
            .metadata(metadata)
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED, RELOCATING), equalTo(2));
        newState = strategy.applyFailedShard(clusterState, firstShard, randomBoolean());
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        }
        newState = strategy.reroute(clusterState, "reroute");
        startedReplica = clusterState.getRoutingNodes().activeReplicaWithOldestVersion(shardId);
            ? settings(Version.CURRENT).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            Version nodeVer = cursor.getVersion();
 * Unless required by applicable law or agreed to in writing,
            UUIDs.base64UUID(),
        }
                    "node3"
        assertEquals(expectedCandidateForSegRep.allocationId(), primaryShardRouting3.allocationId());
        clusterState = allocation.reroute(clusterState, "reroute");
        DiscoveryNode nonRemoteNode1 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), nullValue());
        }
            String failedNode = "node" + Integer.toString(randomInt(numberOfReplicas));
        assertThat(clusterState.getRoutingNodes().node("node3").iterator().next().state(), equalTo(INITIALIZING));
            anyOf(equalTo("node1"), equalTo("node2"))
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
    }
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState)
    }
            .metadata(metadata)
            remoteStoreNodeAttributes,
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), lessThan(3));
    }
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        );
 * under the License.
        newState = strategy.applyFailedShard(clusterState, shardToFail, randomBoolean());
                            VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), null)
        logger.info("Start the shards (backups)");
        logger.info("Building initial routing table");
        logger.info("Start the shards (primaries)");
        logger.info("Adding two nodes and performing rerouting");
                    "node3"
        );
        assertEquals(2, clusterState.getRoutingNodes().shardsWithState(STARTED).size());
            Version.CURRENT
        // start the shards, should have 1 primary and 1 replica available
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.getRoutingNodes().node("node2").iterator().next().state(), equalTo(STARTED));
        logger.info("Building initial routing table");
        ClusterState newState = allocation.applyFailedShard(clusterState, primaryShardToFail, randomBoolean());
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            if (primaryShardToFail.currentNodeId().equals(cursor.getId())
        clusterState = strategy.reroute(clusterState, "reroute");
import org.opensearch.cluster.node.DiscoveryNodeRole;
import java.util.List;
        // add a single node
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("--> adding 2 nodes on same rack and do rerouting");
 *
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            Settings.builder()
                continue;
        DiscoveryNodes.Builder nodeBuilder = DiscoveryNodes.builder();
                clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(),
        Map<String, String> remoteStoreNodeAttributes = Map.of(
        assertThat(nodeHoldingPrimary2, not(equalTo(nodeHoldingPrimary)));
                    .add(
        ClusterState newState = allocation.applyFailedShard(clusterState, primaryShardToFail, randomBoolean());
import org.opensearch.cluster.ClusterState;
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        clusterState = newState;
            if (routingNodes.getByAllocationId(
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        Metadata metadata = Metadata.builder()
        ShardRouting newPrimaryShard = clusterState.routingTable().index("test").shard(0).primaryShard();
        clusterState = newState;
        assertTrue(
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        clusterState = newState;
            buildNewFakeTransportAddress(),
 * GitHub history for details.
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(newPrimaryShard, not(equalTo(primaryShardToFail)));
            logger.info("failing shard on node [{}]", failedNode);
            }
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        replicaNodeVersion = clusterState.nodes().getDataNodes().get(startedReplica.currentNodeId()).getVersion();
        newState = strategy.applyFailedShard(clusterState, shardToFail, randomBoolean());
        List<DiscoveryNode> replicaShardNodes = List.of(remoteNode2, remoteNode3, nonRemoteNode1, nonRemoteNode2);
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        clusterState = newState;
                clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(),
                .build()
            .metadata(metadata)
        String origReplicaNodeId = clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId();
            assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1 + (i + 1)));
        logger.info("--> fail primary shard recovering instance on node3 being initialized");
        for (final DiscoveryNode cursor : clusterState.nodes().getDataNodes().values()) {
            .put(IndexMetadata.builder("test").settings(settingsBuilder).numberOfShards(1).numberOfReplicas(4))
        clusterState = ClusterState.builder(clusterState)
        }
        for (final DiscoveryNode cursor : clusterState.nodes().getDataNodes().values()) {
        for (int i = 0; i < shardsToFail; i++) {
            Version nodeVer = cursor.getVersion();
            Version.CURRENT
        ShardRouting expectedCandidateForSegRep = clusterState.getRoutingNodes().activeReplicaWithOldestVersion(shardId);
 */
        clusterState = ClusterState.builder(clusterState).routingTable(allocation.reroute(clusterState, "reroute").routingTable()).build();
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AllocationService allocation = createAllocationService(Settings.builder().build());
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED, RELOCATING), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo(nodeHoldingPrimary));
 *
                clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(),
            new AllocationCommands(
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(2));
            .build();
            clusterState,
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(remoteNode1)).build();
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
 * this work for additional information regarding copyright
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
    private final Logger logger = LogManager.getLogger(FailedShardsRoutingTests.class);
        );
    }
/*
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(newState, not(equalTo(clusterState)));
        Metadata metadata = Metadata.builder()
import org.opensearch.common.UUIDs;
        // fail the primary shard, check one replica gets elected to primary, others become INITIALIZING (from it)
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
    public void testRebalanceFailure() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
            .build();
        logger.info("fail the first shard, will have no place to be rerouted to (single node), so stays unassigned");
        assertNotEquals(clusterState, newState);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        assertNotEquals(primaryShardRouting2, primaryShardRouting3);
                .build()
            anyOf(equalTo(origPrimaryNodeId), equalTo("node3"))
        ShardId shardId = new ShardId(metadata.index("test").getIndex(), 0);
        clusterState = newState;
import java.util.HashSet;
            .build();
        clusterState = newState;
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            }
    }
import org.opensearch.cluster.metadata.IndexMetadata;
            buildNewFakeTransportAddress(),
                fail("shard " + failedShard + " was not failed");
                Settings.builder()
                || primaryShardRouting2.currentNodeId().equals(remoteNode3.getId())
        ShardRouting newPrimaryShard = clusterState.routingTable().index("test").shard(0).primaryShard();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
    public void testFailPrimaryStartedCheckReplicaElected() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(4));
        // make sure the failedShard is not INITIALIZING again on node3
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
            .build();
package org.opensearch.cluster.routing.allocation;
            REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
        clusterState = ClusterState.builder(clusterState)
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), lessThan(3));
            .persistentSettings(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
            .build();
            .routingTable(initialRoutingTable)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        Set<String> failedNodes = new HashSet<>();
        assertNotEquals(primaryShard0, primaryShardRouting1);
        ShardRouting startedReplica = clusterState.getRoutingNodes().activeReplicaWithOldestVersion(shardId);
        );
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));
        assertNotEquals(primaryShardRouting1, primaryShardRouting2);
import java.util.ArrayList;
            nodeBuilder.add(newNode("node" + Integer.toString(i)));
        clusterState = ClusterState.builder(clusterState).routingTable(allocation.reroute(clusterState, "reroute").routingTable()).build();
        }
        testReplicaIsPromoted(true);
                "expected node [" + cursor.getId() + "] with version " + nodeVer + " to be after " + replicaNodeVersion,
        }
import org.opensearch.cluster.node.DiscoveryNodes;
            );
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        );
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        assertThat(newState, not(equalTo(clusterState)));
            .build();
            assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        // the primary gets allocated on another node
        ShardRouting primaryShardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
/*
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(UNASSIGNED));
        logger.info("--> building initial routing table");
            "REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_VALUE",
        AllocationService allocation = createAllocationService(Settings.builder().build());
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1 + i));
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
        Metadata metadata = Metadata.builder()
            UUIDs.base64UUID(),
        );
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        clusterState = newState;
                || secondPrimaryShardToFail.currentNodeId().equals(cursor.getId())) {
            );
import static org.opensearch.common.util.FeatureFlags.REMOTE_STORE_MIGRATION_EXPERIMENTAL;
            .build();
        Metadata metadata = Metadata.builder()
                clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(),
 * Modifications Copyright OpenSearch Contributors. See
            "REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_VALUE"
}
        clusterState = newState;
        }
            clusterState,
        logger.info("Building initial routing table");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            .build();
            }
        clusterState = newState;
                    "test",
        logger.info("--> failing primary shard a second time, should select: {}", startedReplica);
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(3));
            Settings.builder()
            .routingTable(routingTable)
        routingNodes = clusterState.getRoutingNodes();
        // fail the primary shard, check replicas get removed as well...
        for (int i = 0; i < 4; i++) {
        // start another replica shard, while keep one initializing
            .build();
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        ClusterState newState = allocation.applyFailedShard(clusterState, primaryShard0, randomBoolean());
        clusterState = newState;
                .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(replicaShardNodes.get(i)))
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
import org.apache.logging.log4j.Logger;
        clusterState = ClusterState.builder(clusterState).nodes(nodeBuilder).build();
            .metadata(metadata)
    }
        );
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        assertNotEquals(clusterState, newState);
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
                            "node4-old",
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(3));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
import org.apache.logging.log4j.LogManager;
        Metadata metadata = Metadata.builder()
        ShardRouting firstShard = clusterState.getRoutingNodes().node("node1").iterator().next();
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("Building initial routing table");
        clusterState = ClusterState.builder(clusterState)
            );
            );
        logger.info("--> adding additional node");
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
        AllocationService strategy = createAllocationService(
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            .build();
            false
        assertThat(clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next().state(), equalTo(STARTED));
                    "test",
        // start all the replicas
    public void testPreferReplicaOnRemoteNodeForPrimaryPromotion() {
        ShardRouting primaryShardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo("node1"));
            DiscoveryNodeRole.BUILT_IN_ROLES,
        logger.info("Start the shards (backups)");
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
    public void testFirstAllocationFailureTwoNodes() {
        Settings.Builder settingsBuilder = settings(Version.CURRENT).put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT);
            assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(4 - (i + 1)));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            }
            .build();
import java.util.Map;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        clusterState = newState;
 * KIND, either express or implied.  See the License for the
                replicaNodeVersion.onOrBefore(nodeVer)
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        final String nodeHoldingPrimary2 = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
                anyOf(equalTo("node2"), equalTo("node1"))
            clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(),
                new MoveAllocationCommand(
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(1));
        ShardRouting secondPrimaryShardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        clusterState = newState;
            Version.CURRENT
            : settings(Version.CURRENT);
        DiscoveryNode remoteNode1 = new DiscoveryNode(
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        // add another 1.0 node
        AllocationService allocation = createAllocationService(
        commandsResult = allocation.reroute(
        testReplicaIsPromoted(false);
            .metadata(metadata)
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(2))
 * The OpenSearch Contributors require contributions made to
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        // start primary shards
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        clusterState = allocation.reroute(clusterState, "reroute");
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(
        ShardId shardId = new ShardId(metadata.index("test").getIndex(), 0);
    public void testFirstAllocationFailureSingleNode() {
            .build();
import org.opensearch.core.index.shard.ShardId;
                .build();
        assertThat(newPrimaryShard, not(equalTo(primaryShardToFail)));
        logger.info("Adding third node and reroute");
                    clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
import org.opensearch.test.VersionUtils;
        clusterState = ClusterState.builder(clusterState)
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
        // the primary gets allocated on another node
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            "REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY",
import org.opensearch.cluster.routing.ShardRouting;
            remoteStoreNodeAttributes,
    public void testReplicaOnOldestVersionIsPromotedSegRep() {
        clusterState = newState;
import static org.hamcrest.Matchers.lessThan;
        );
            assertThat(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        clusterState = commandsResult.getClusterState();
            .routingTable(routingTable)
            clusterState.getRoutingNodes().node("node3").iterator().next(),
            );
                .build()
            .routingTable(initialRoutingTable)
 */
            clusterState,
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(2));
        }
        ShardRouting shardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
        // starting primaries
        Metadata metadata = Metadata.builder()
        );
import org.opensearch.cluster.routing.RoutingTable;
        }
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(4));
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                // Skip the node that the primary was on, it doesn't have a replica so doesn't need a version check
            assertThat(
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).add(newNode("node4")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            assertThat(
        assertThat(newPrimaryShard.allocationId(), equalTo(startedReplica.allocationId()));
        DiscoveryNode nonRemoteNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
                anyOf(equalTo("node2"), equalTo("node1"))
        clusterState = newState;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
        AllocationService.CommandsResult commandsResult = allocation.reroute(
                || primaryShardRouting3.currentNodeId().equals(nonRemoteNode2.getId())
        );
import org.opensearch.Version;
        assertNotNull(replicaNodeVersion);
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .build();
        logger.info("Adding two nodes and performing rerouting");
        assertThat(newState, not(equalTo(clusterState)));
import org.opensearch.cluster.routing.RoutingNodes;
                            "node3-old",
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
        assertEquals(4, clusterState.getRoutingNodes().shardsWithState(STARTED).size());
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        logger.info("Adding single node and performing rerouting");
        routingNodes = clusterState.getRoutingNodes();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
                clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(),
        logger.info("--> shard {} got assigned to node with version {}", startedReplica, replicaNodeVersion);
        assertNotNull(replicaNodeVersion);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        clusterState = newState;
                )
                            VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumIndexCompatibilityVersion(), null)
 * not use this file except in compliance with the License.
        assertThat(
        logger.info("--> shard {} got assigned to node with version {}", startedReplica, replicaNodeVersion);
            assertThat(
            false,
                    .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED.mode)
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
    public void testFailedShardPrimaryRelocatingToAndFrom() {
        ShardRouting primaryShardRouting2 = clusterState.routingTable().index("test").shard(0).primaryShard();
                .build()
        assertThat(clusterState.getRoutingNodes().node(origReplicaNodeId).iterator().next().state(), equalTo(STARTED));
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(0));
    }
            clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")).add(newNode("node4")))
        // segment replication enabled
                    clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
import static org.opensearch.node.remotestore.RemoteStoreNodeService.MIGRATION_DIRECTION_SETTING;
            assertThat(clusterState.getRoutingNodes().shardsWithState(UNASSIGNED).size(), equalTo(4 - (i + 1)));
import static org.hamcrest.Matchers.not;
        assertThat(
            .routingTable(initialRoutingTable)
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        int numberOfReplicas = scaledRandomIntBetween(2, 10);
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
        Version replicaNodeVersion = clusterState.nodes().getDataNodes().get(startedReplica.currentNodeId()).getVersion();
            new AllocationCommands(
    }
            .nodes(DiscoveryNodes.builder().add(newNode("node1-1.0", Version.fromString("1.0.0"))))
            )
            DiscoveryNodeRole.BUILT_IN_ROLES,
        AllocationService allocation = createAllocationService(Settings.builder().build());
        ShardRouting primaryShardToFail = clusterState.routingTable().index("test").shard(0).primaryShard();
        logger.info("--> moving primary shard to node3");
        assertTrue(
            clusterState = allocation.reroute(clusterState, "reroute");
        clusterState = commandsResult.getClusterState();
        assertThat(newPrimaryShard, not(equalTo(secondPrimaryShardToFail)));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        clusterState = startShardsAndReroute(allocation, clusterState, clusterState.getRoutingNodes().shardsWithState(INITIALIZING).get(0));
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        AllocationService strategy = createAllocationService(
        newState = allocation.applyFailedShard(clusterState, secondPrimaryShardToFail, randomBoolean());
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        // fail primary shard
        clusterState = allocation.reroute(clusterState, "reroute");
                .build()
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
                    )
            if (shardRoutingsToFail.contains(shardToFail) == false) {
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        // add 4 nodes
        clusterState = ClusterState.builder(clusterState)
 */
        assertThat(newPrimaryShard.allocationId(), equalTo(startedReplica.allocationId()));
        assertThat(clusterState.getRoutingNodes().node("node1").iterator().next().state(), equalTo(STARTED));
        }
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), lessThan(3));
        logger.info("Adding {} nodes and performing rerouting", numberOfReplicas + 1);
        }
            assertTrue(
        assertThat(routingNodes.node("node3").iterator().next().shardId(), not(equalTo(shardToFail.shardId())));
        // verify that promoted replica exists on a remote node
        logger.info("--> moving primary shard to node3");
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
        final ShardRouting firstShard = clusterState.getRoutingNodes().node(nodeHoldingPrimary).iterator().next();
        Metadata metadata = Metadata.builder()
        assertThat(newState, not(equalTo(clusterState)));
        );
            }
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(numberOfReplicas))
        ClusterState newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
            clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(),
                .build()
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            randomBoolean()
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), not(equalTo(nodeHoldingPrimary)));
            .build();
        assertThat(newPrimaryShard.allocationId(), equalTo(startedReplica.allocationId()));
            .build();
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        }
            clusterState.getRoutingNodes().node(origPrimaryNodeId).iterator().next(),
        logger.info("fail the primary shard, will have no place to be rerouted to (single node), so stays unassigned");
                continue;
            .build();
            assertThat(
                || primaryShardRouting1.currentNodeId().equals(remoteNode3.getId())
        ShardRouting primaryShardRouting1 = clusterState.routingTable().index("test").shard(0).primaryShard();
import org.opensearch.cluster.node.DiscoveryNode;
