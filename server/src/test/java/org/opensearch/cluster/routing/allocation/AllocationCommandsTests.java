import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.common.network.NetworkModule;
        );
import static org.hamcrest.Matchers.containsString;
            + "       ,{\"allocate_stale_primary\" : {\"index\" : \"test\", \"shard\" : 2,"
        final ClusterState updatedClusterState = clusterState;
        try {
 * You may obtain a copy of the License at
            );
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                    .putInSyncAllocationIds(0, Collections.singleton("asdf"))
                        + " can result in data loss. Please confirm by setting the accept_data_loss parameter to true"
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        assertThat(shardRoutings, hasSize(2));
        ).getClusterState();
            logger.info("--> move the replica shard again");
import java.util.Set;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        final String node1 = "node1";
        // move two tokens, parser expected to be "on" `commands` field
 * license agreements. See the NOTICE file distributed with
            assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).iterator().next().primary(), equalTo(true));
        logger.info("--> allocate the replica shard on on the second node");
            false,
        Metadata metadata = Metadata.builder()
            "[move_allocation] can't move [test][0] from "
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand(index, shardId.id(), "node42")), false, false);
            clusterState = allocation.reroute(
        DiscoveryNode node1 = new DiscoveryNode(
        logger.info("--> allocating empty primary with acceptDataLoss flag set to true");
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
                false
                IndexMetadata.builder(index)
import static org.hamcrest.Matchers.equalTo;
            fail("expected ShardNotFoundException when allocating non-existing shard");
            .metadata(metadata)
        logger.info("--> building initial routing table");
            "node1",
            "node1",
 *
import static java.util.Collections.emptyMap;
import java.util.List;
            new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node2")),
            false
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).index(), equalTo("test"));
        AllocationService allocation = createAllocationService(
            "test2",
                + node1
            )
            + "       ,{\"move\" : {\"index\" : \"test\", \"shard\" : 3, \"from_node\" : \"node2\", \"to_node\" : \"node3\"}} \n"
            false,
            .build();
        return new NamedXContentRegistry(NetworkModule.getNamedXContents());
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            )
                new AllocationCommands(
            allocation.reroute(clusterState, new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", false)), false, false);
import org.opensearch.common.settings.Settings;
            .routingTable(routingTable)
 * Unless required by applicable law or agreed to in writing,
            Version.CURRENT
    }
            .put(
            new AllocateEmptyPrimaryAllocationCommand("test", 1, "node1", true),
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
            false,
        );
        clusterState = allocation.reroute(
            clusterState = allocation.reroute(
                    .putInSyncAllocationIds(0, Collections.singleton("randomAllocID"))
            new AllocateReplicaAllocationCommand(index, shardId, node),
                    .numberOfShards(1)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );
                + " to "
                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
            new AllocationDeciders(Collections.emptyList()),
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
                new AllocationCommands(
import org.opensearch.core.common.io.stream.StreamInput;
            assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).size(), equalTo(1));
            ClusterInfo.EMPTY,
        Metadata metadata = Metadata.builder()
            SnapshotShardSizeInfo.EMPTY,
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).shardId(), equalTo(4));
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).allowPrimary(), equalTo(true));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        MoveAllocationCommand command = new MoveAllocationCommand(index.getName(), 0, "node2", "node1");
        logger.info("--> start the replica shard");
import org.opensearch.core.xcontent.NamedXContentRegistry;
        clusterState = ClusterState.builder(clusterState)
import static java.util.Collections.singleton;
    @Override
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
        ).getClusterState();
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            new AllocateStalePrimaryAllocationCommand("test", 2, "node1", true),
        final String node2 = "node2";
            false
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).shardId(), equalTo(3));
            new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node2")),
                finalClusterState,
            false,
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node1).add(node2)).build();
        DiscoveryNode node1 = new DiscoveryNode(
            Version.CURRENT
                ),
            .build();
        logger.info("--> allocate the replica shard on on the second node");
                new AllocationCommands(
            new AllocateReplicaAllocationCommand("test", 2, "node1"),
                    .add(newNode("node1"))
        assertThat(routingNode1.shardsWithState(STARTED).size(), equalTo(1));
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            assertThat(
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).shardId(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        String toNodeId;
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
        // Since the commands are named writeable we need to register them and wrap the input stream
        // mark all shards as stale
                e.getMessage(),
 * this file be licensed under the Apache-2.0 license or a
        clusterState = newState;
            fail();
            clusterState,
import static org.hamcrest.Matchers.not;
            false
            + "}\n";
            .metadata(metadata)
            "node1",
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).shardId(), equalTo(2));
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
                ),
        }
            clusterState,
import java.util.Collections;
        logger.info("--> cancel the primary being replicated, make sure it fails");
                    .numberOfReplicas(1)
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
            .build();
 * KIND, either express or implied.  See the License for the
                    .putInSyncAllocationIds(1, Collections.singleton("qwertz"))
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(INITIALIZING).get(0).relocatingNodeId(), nullValue());
        ClusterState newState = allocation.reroute(
                false,
    }
        logger.info("start primary shard");
        } catch (IllegalArgumentException e) {
        assertThat(newState, not(equalTo(clusterState)));
            clusterState,
        assertThat(newState, not(equalTo(clusterState)));
                    .add(newNode("node2"))
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand("test", 0, "node3")), false, false);
            false
        ).getClusterState();
                .build()
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).fromNode(), equalTo("node2"));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        ).getClusterState();
        }
            );
            .put(
            allocation.reroute(
        assertThat(expectThrows(IllegalArgumentException.class, () -> {
        try {
        logger.info("--> subsequent replica allocation fails as all configured replicas have been allocated");
        logger.info("--> building initial routing table");
            false
            .build();
                new AllocationCommands(new AllocateStalePrimaryAllocationCommand(index, shardId.id(), "node1", false)),
                    new AllocateStalePrimaryAllocationCommand(index1, 0, node2, true)
            System.nanoTime()
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).toNode(), equalTo("node3"));
 * not use this file except in compliance with the License.
            "node2",
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(INITIALIZING).size(), equalTo(1));
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).index(), equalTo("test"));
        // Now we can read them!
        logger.info("creating an index with 1 shard, no replica");
            false
        logger.info("--> adding two nodes");
            newState = allocation.reroute(
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        Set<String> inSyncAllocationIds = clusterState.metadata().index(index).inSyncAllocationIds(0);
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        logger.info("move the shard");
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).fromNode(), equalTo("node2"));
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).index(), equalTo("test"));
                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
 * specific language governing permissions and limitations
                + "] is not a data node.",
        assertThat(newState, not(equalTo(clusterState)));
            clusterState,
            false,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                false,
            fail("expected ShardNotFoundException when allocating non-existing index");
                false
        }
            buildNewFakeTransportAddress(),
        assertThat(clusterState.getRoutingNodes().node(existingNodeId).iterator().next().state(), equalTo(ShardRoutingState.RELOCATING));
        newState = allocation.reroute(
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).node(), equalTo("node5"));
                clusterState,
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),
            CLUSTER_MANAGER_DATA_ROLES,
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(STARTED).size(), equalTo(1));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
 * the Apache License, Version 2.0 (the "License"); you may
            new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand(index3, 0, node1, true)),
            assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node(toNodeId).iterator().next().state(), equalTo(ShardRoutingState.STARTED));
                false,
            ).getClusterState();
        final ClusterState finalClusterState = allocation.reroute(clusterState, "reroute");
        try {
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        logger.info("--> start the primary shard");
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).size(), equalTo(1));
        logger.info("--> cancel allocation of the replica shard");
                    .putInSyncAllocationIds(1, Collections.singleton("randomAllocID2"))
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
import org.opensearch.snapshots.SnapshotShardSizeInfo;
                IndexMetadata.builder(index3)
        String existingNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
            "node2",
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        clusterState = newState;
            "test2",
 * under the License.
 * software distributed under the License is distributed on an
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            assertThat(e.getMessage(), containsString("allocation can only be done on data nodes"));
        logger.info("--> verify that we fail when there are no unassigned shards");
            .routingTable(routingTable)
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).shardId(), equalTo(2));
                + node2.getName()
    protected NamedXContentRegistry xContentRegistry() {
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
            e.getMessage()
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        } catch (ShardNotFoundException e) {
        ).getClusterState();
        final String index1 = "test1";
 * Licensed to Elasticsearch under one or more contributor
        logger.info("--> allocate the replica shard on the primary shard node, should fail");
            clusterState,
            .build();
            clusterState = newState;
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(e.getMessage(), containsString("no such index [test2]"));
                ),
            new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node2")),
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
                new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", true)),
            Version.CURRENT
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).index(), equalTo("test"));
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(INITIALIZING).size(), equalTo(1));
        newState = allocation.reroute(
            + "    ]\n"
        AllocationService allocation = createAllocationService(
    public void testAllocateStalePrimaryCommand() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
            );
            new RoutingNodes(clusterState, false),
                + node2
            );
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        logger.info("--> move the replica shard");
    public void testAllocateCommand() {
            + "       ,{\"cancel\" : {\"index\" : \"test\", \"shard\" : 4, \"node\" : \"node5\", \"allow_primary\" : true}} \n"
    private final Logger logger = LogManager.getLogger(AllocationCommandsTests.class);
        ClusterState newState = allocation.reroute(
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
        try {
        } catch (IllegalArgumentException e) {}
/*
        logger.info("--> allocating non-existing shard, should fail");
import org.opensearch.cluster.ClusterState;
        logger.info("--> building initial routing table");
            new AllocationCommands(new CancelAllocationCommand("test", 0, "node2", false)),
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        XContentParser parser = createParser(JsonXContent.jsonXContent, commands);
            new AllocateStalePrimaryAllocationCommand(index, shardId, node, true)
            .build();
        RoutingTable routingTable = RoutingTable.builder().addAsRecovery(metadata.index(index)).build();
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).allowPrimary(), equalTo(true));
            fail("expected IllegalArgumentException when allocating replica shard on the primary shard node");
            .metadata(metadata)
                clusterState,
            clusterState,
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).shardId(), equalTo(2));
        DiscoveryNode node2 = new DiscoveryNode(
        );
        AllocationService allocation = createAllocationService(
                false
                false
                false,
            new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand("test", 0, "node1", true)),
                    .settings(settings(Version.CURRENT))
import org.opensearch.common.xcontent.json.JsonXContent;
    public void testMoveShardCommand() {
        clusterState = allocation.reroute(clusterState, "reroute");
        logger.info("--> adding two nodes");
            false
    public void testConflictingCommandsInSingleRequest() {
            Settings.builder()
        assertThat(clusterState.getRoutingNodes().node(toNodeId).iterator().next().state(), equalTo(ShardRoutingState.INITIALIZING));
 *     http://www.apache.org/licenses/LICENSE-2.0
        logger.info("--> allocating stale primary with acceptDataLoss flag set to false");
                .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
                    .putInSyncAllocationIds(1, Collections.singleton("qwertz"))
                + "] is not a data node.",
                clusterState,
        logger.info("--> allocate the replica shard on on the second node");
        } catch (IllegalArgumentException e) {
            toNodeId = "node1";
                + node1
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand(index, shardId.id(), "node4")), false, false);
        Metadata metadata = Metadata.builder()
        );
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            );
import static org.hamcrest.Matchers.nullValue;
                false
        Metadata metadata = Metadata.builder()
        logger.info("--> start the replica shard");
            .build();
        }
        clusterState = newState;
            fail("expected IllegalArgumentException when allocating stale primary with acceptDataLoss flag set to false");
            .build();
        DiscoveryNode node2 = new DiscoveryNode(
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
                    .settings(settings(Version.CURRENT))
                new AllocationCommands(new CancelAllocationCommand("test", 0, "node2", false)),
            assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
            assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
                clusterState,
                    .putInSyncAllocationIds(0, Collections.singleton("randomAllocID"))
 * ownership. Elasticsearch licenses this file to you under
            fail("expected IllegalArgumentException when allocating to non-data node");
            false,
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode(node1)).add(newNode(node2))).build();
        assertThat(clusterState.getRoutingNodes().node(existingNodeId).isEmpty(), equalTo(true));
        AllocationService allocation = createAllocationService(
            "test1",
import java.util.HashSet;
        logger.info("--> building initial routing table");
            false
                IndexMetadata.builder(index)
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).acceptDataLoss(), equalTo(true));
                false,
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        if (randomBoolean()) {
        try {
        );
        if ("node1".equals(existingNodeId)) {
 */
            fail("expected IllegalArgumentException when allocating empty primary with acceptDataLoss flag set to false");
                    new AllocateReplicaAllocationCommand(index3, 0, node2),
import org.opensearch.core.index.shard.ShardId;
        logger.info("--> adding 3 nodes");
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
                false,
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(INITIALIZING).size(), equalTo(1));
                false
        Metadata metadata = Metadata.builder()
        clusterState = newState;
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).node(), equalTo("node1"));
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;
                        + shardId
        logger.info("--> allocating non-existing index, should fail");
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).size(), equalTo(1));
            .build();
                    .putInSyncAllocationIds(1, Collections.singleton("randomAllocID2"))
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
            );
    }
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(INITIALIZING).size(), equalTo(1));
            clusterState,
                    .putInSyncAllocationIds(0, Collections.singleton("randomAllocID"))
            "node1",
        logger.info("start primary shard");
        AllocationCommands sCommands = AllocationCommands.fromXContent(parser);
            .build();
        logger.info("--> cancel primary allocation, make sure it fails...");
            allocation.reroute(
import org.apache.logging.log4j.LogManager;
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
        );
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        );
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                    .add(newNode("node3"))
/*
        } catch (IndexNotFoundException e) {
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
        try {
            "node2",
        try {
 */
            Settings.builder()
        newState = allocation.reroute(
        logger.info("--> allocating empty primary with acceptDataLoss flag set to true");
        logger.info("start primary shard");
                + ": source ["
        ).getClusterState();
                .build()
import org.opensearch.cluster.routing.RoutingNodes;
        assertThat(sCommands.commands().size(), equalTo(5));
                .build()
    }
import org.opensearch.core.xcontent.XContentParser;
            allocation.reroute(clusterState, new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", false)), false, false);
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
                new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", true)),
import org.opensearch.common.io.stream.BytesStreamOutput;
            Version.CURRENT
            .build();
        }
                    .numberOfReplicas(1)
            "test1",
            buildNewFakeTransportAddress(),
                    new AllocateReplicaAllocationCommand(index3, 0, node2)
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
            .metadata(metadata)
        final String index2 = "test2";
            new MoveAllocationCommand("test", 3, "node2", "node3"),
        );
            "node2",
                    "allocating an empty primary for "
                IndexMetadata.builder(index1)
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> command.execute(routingAllocation, false));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
            false,
        logger.info("--> start the replica shard");
            new AllocationCommands(new MoveAllocationCommand("test", 0, existingNodeId, toNodeId)),
        assertThat(inSyncAllocationIds, not(Collections.singleton(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID)));
            assertThat(e.getMessage(), containsString("no such shard"));
        assertThat(inSyncAllocationIds, hasSize(1));
        RoutingTable routingTable = RoutingTable.builder()
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
import org.opensearch.cluster.metadata.IndexMetadata;
        clusterState = newState;
    }
            .routingTable(routingTable)
        Index index = clusterState.getMetadata().index("test").getIndex();
            "node2",
        }).getMessage(), containsString("primary [" + index1 + "][0] is already assigned"));
        StreamInput in = bytes.bytes().streamInput();
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        clusterState = ClusterState.builder(clusterState)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
        newState = allocation.reroute(
        assertThat(expectThrows(IllegalArgumentException.class, () -> {
                false,
                clusterState,
                .build()
                new AllocationCommands(new CancelAllocationCommand("test", 0, "node3", false)),
                + " to "
        clusterState = newState;
import java.util.Arrays;
import static org.hamcrest.Matchers.hasSize;
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).shardId(), equalTo(1));
        RoutingNode routingNode1 = clusterState.getRoutingNodes().node(node1);
            assertThat(newState, not(equalTo(clusterState)));
                        + shardId
                    new AllocateEmptyPrimaryAllocationCommand(index2, 0, node1, true),
        RoutingAllocation routingAllocation = new RoutingAllocation(
                new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),
        try {
        );
import org.apache.logging.log4j.Logger;
            assertThat(e.getMessage(), containsString("failed to resolve [node42], no matching nodes"));
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).acceptDataLoss(), equalTo(true));
            + "        {\"allocate_empty_primary\" : {\"index\" : \"test\", \"shard\" : 1,"
            clusterState,
            .addAsRecovery(metadata.index(index2))
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).index(), equalTo("test"));
            "test1",
        Metadata metadata = Metadata.builder()
        assertThat(expectThrows(IllegalArgumentException.class, () -> {
        String commands = "{\n"
/*
        }).getMessage(), containsString("primary [" + index2 + "][0] is already assigned"));
                )
            new AllocationDeciders(Collections.emptyList()),
            ),
            "node1",
            fail();
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            logger.info("--> cancel the primary allocation (with allow_primary set to true)");
                    new AllocateStalePrimaryAllocationCommand(index1, 0, node1, true),
        newState = allocation.reroute(
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).index(), equalTo("test"));
        assertThat(sCommands.commands().size(), equalTo(5));
public class AllocationCommandsTests extends OpenSearchAllocationTestCase {
        );
                false
            .build();
    private AbstractAllocateAllocationCommand randomAllocateCommand(String index, int shardId, String node) {
        assertThat(newState, not(equalTo(clusterState)));
            false,
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(INITIALIZING).size(), equalTo(1));
 * this work for additional information regarding copyright
            .routingTable(routingTable)
        BytesStreamOutput bytes = new BytesStreamOutput();
                    .settings(settings(Version.CURRENT))
        assertThat(routingNode1.shardsWithState(INITIALIZING).size(), equalTo(1));
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand("test2", 0, "node2")), false, false);
            .put(
            clusterState = allocation.reroute(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> command.execute(routingAllocation, false));
 * compatible open source license.
        final String index = "test";
        assertThat(inSyncAllocationIds, equalTo(Collections.singleton(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID)));
 * Modifications Copyright OpenSearch Contributors. See
        ).getClusterState();
        final String node2 = "node2";
                finalClusterState,
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).toNode(), equalTo("node3"));
        final List<ShardRouting> shardRoutings = clusterState.getRoutingNodes().shardsWithState(UNASSIGNED);
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        } catch (IllegalArgumentException e) {}
package org.opensearch.cluster.routing.allocation;
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        logger.info("--> allocating empty primary with acceptDataLoss flag set to false");
            emptyMap(),
        clusterState = allocation.reroute(clusterState, "reroute");
                false
                clusterState,
        clusterState = newState;
            new HashSet<>(
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand("test", 1, "node2")), false, false);
                e.getMessage(),
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        final ShardId shardId = new ShardId(metadata.index(index).getIndex(), 0);
            assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
            newState = allocation.reroute(
            .routingTable(routingTable)
        parser.nextToken();
            false,
            false,
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).node(), equalTo("node1"));
            assertThat(
                .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
        final String index = "test";
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            clusterState,
        );
 */
import org.opensearch.cluster.routing.ShardRouting;
            clusterState,
        AllocationCommands.writeTo(commands, bytes);
        logger.info("--> cancel the relocation allocation");
                containsString(
            .nodes(
                    new AllocateEmptyPrimaryAllocationCommand(index2, 0, node2, true)
        ).getClusterState();
            .put(
        assertEquals(
        MoveAllocationCommand command = new MoveAllocationCommand(index.getName(), 0, "node1", "node2");
        // primary with accept_data_loss flag set to false fails
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
        assertThat(updatedClusterState.getRoutingNodes().node(node1).shardsWithState(STARTED).size(), equalTo(1));
            new RoutingNodes(clusterState, false),
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).node(), equalTo("node1"));
                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
    }
        clusterState = allocation.reroute(
            ).getClusterState();
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
import org.opensearch.cluster.routing.ShardRoutingState;
            fail("expected IllegalArgumentException when allocating shard while no unassigned shard available");
                false
        }
            .routingTable(routingTable)
            allocation.reroute(
            .metadata(metadata)
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).node(), equalTo("node1"));
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            "node1",
    }
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            false
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        assertEquals(
                false,
        // shard routing is added as "from recovery" instead of "new index creation" so that we can test below that allocating an empty
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).node(), equalTo("node1"));
        routingNode1 = clusterState.getRoutingNodes().node(node1);
            new AllocationCommands(new AllocateStalePrimaryAllocationCommand(index, 0, node1, true)),
        logger.info("--> allocating to non-data node, should fail");
            .routingTable(routingTable)
            new AllocationCommands(new CancelAllocationCommand("test", 0, "node2", false)),
                    .settings(settings(Version.CURRENT))
        } catch (IllegalArgumentException e) {}
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        in = new NamedWriteableAwareStreamInput(in, namedWriteableRegistry);
        clusterState = ClusterState.builder(clusterState)
        logger.info("--> start the primary shard");
                    .numberOfShards(1)
            logger.info("--> start the former target replica shard");
    }
}
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(INITIALIZING).size(), equalTo(1));
            "node2",
            .build();
            new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand("test", 0, "node1", true)),
        AllocationCommands commands = new AllocationCommands(
            );
            "[move_allocation] can't move [test][0] from "
        );
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).node(), equalTo("node1"));
            logger.info("--> cancel the source replica shard");
        ).getClusterState();
import org.opensearch.Version;
            allocation.reroute(
            e.getMessage()
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).shardId(), equalTo(3));
            allocation.reroute(clusterState, new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", false)), false, false);
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        assertThat(routingNode1.size(), equalTo(1));
            buildNewFakeTransportAddress(),
import org.opensearch.core.index.Index;
        assertThat(newState, not(equalTo(clusterState)));
                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 *
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).shardId(), equalTo(4));
                IndexMetadata.builder(index2)
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).index(), equalTo("test"));
            false
    }
            allocation.reroute(
        );
                + node2
        Index index = clusterState.getMetadata().index("test").getIndex();
        } catch (IllegalArgumentException e) {}
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(RELOCATING).size(), equalTo(1));
import org.opensearch.cluster.metadata.Metadata;
                containsString(
            );
        ).getClusterState();
        AllocationService allocation = createAllocationService(
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
            logger.info("--> cancel the primary allocation (with allow_primary set to true)");
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
                    .numberOfShards(1)
                .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
                    .putInSyncAllocationIds(0, Collections.singleton("asdf"))
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        clusterState = newState;
        }
        try {
                .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
        ).getClusterState();
        return randomFrom(
        } catch (IllegalArgumentException e) {
        final String node1 = "node1";
            assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
import org.opensearch.cluster.ClusterInfo;
        RoutingTable routingTable = RoutingTable.builder().addAsRecovery(metadata.index(index)).build();
        try {
        logger.info("--> allocating empty primary shard with accept_data_loss flag set to true");
        logger.info("--> allocating to non-existent node, should fail");
                    "allocating an empty primary for "
            emptyMap(),
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        );
import org.opensearch.cluster.routing.RoutingNode;
            "test1",
            allocation.reroute(
            new HashSet<>(
            Settings.builder()
        AllocationService allocation = createAllocationService(
import org.opensearch.index.IndexNotFoundException;
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            clusterState = newState;
        }).getMessage(), containsString("all copies of [" + index3 + "][0] are already assigned. Use the move allocation command instead"));
            false,
            assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
                new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node1")),
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(NetworkModule.getNamedWriteables());
                false
                )
        } else {
            false,
                    .settings(settings(Version.CURRENT))
            clusterState,
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("finish moving the shard");
    }
            ClusterInfo.EMPTY,
            .addAsRecovery(metadata.index(index1))
    public void testXContent() throws Exception {
 * GitHub history for details.
        RoutingAllocation routingAllocation = new RoutingAllocation(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node1).add(node2)).build();
                    .numberOfReplicas(1)
                new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand("test", 0, "node1", false)),
            ).getClusterState();
                randomSubsetOf(new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.INGEST_ROLE)))
                    .numberOfReplicas(1)
        } catch (IllegalArgumentException e) {}
        clusterState = allocation.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        logger.info("creating an index with 1 shard, no replica");
            SnapshotShardSizeInfo.EMPTY,
            emptyMap(),
        );
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).index(), equalTo("test"));
                + ": source ["
            false
                    .numberOfShards(1)
        }
        AllocationService allocation = createAllocationService(
            .build();
            .build();
            .build();
        try {
        AllocationCommands sCommands = AllocationCommands.readFrom(in);
        assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(INITIALIZING).size(), equalTo(1));
            clusterState,
            clusterState,
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(INITIALIZING).size(), equalTo(1));
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        logger.info("--> adding 3 nodes on same rack and do rerouting");
            + "    \"commands\" : [\n"
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).index(), equalTo("test"));
        Metadata metadata = Metadata.builder()
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).acceptDataLoss(), equalTo(true));
import org.opensearch.index.shard.ShardNotFoundException;
        } else {
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        inSyncAllocationIds = clusterState.metadata().index(index).inSyncAllocationIds(0);
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).node(), equalTo("node5"));
                false,
import org.opensearch.cluster.routing.allocation.command.AbstractAllocateAllocationCommand;
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).shardId(), equalTo(2));
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).index(), equalTo("test"));
            "test2",
            "test2",
import org.opensearch.cluster.routing.RoutingTable;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        logger.info("--> allocating same index primary in multiple commands should fail");
                clusterState,
            logger.info("--> cancel the move of the replica shard");
            new CancelAllocationCommand("test", 4, "node5", true)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
            new AllocateEmptyPrimaryAllocationCommand(index, shardId, node, true),
import org.opensearch.cluster.routing.RecoverySource;
                    .add(newNode("node4", singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)))
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            .addAsRecovery(metadata.index(index3))
        // primary with accept_data_loss flag set to false fails
        parser.nextToken();
            assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(RELOCATING).size(), equalTo(1));
            ).getClusterState();
        logger.info("--> executing move allocation command from non-data node");
            ),
    public void testCancelCommand() {
            .put(
            new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node2")),
            emptyMap(),
                        + " can result in data loss. Please confirm by setting the accept_data_loss parameter to true"
        logger.info("--> allocate the replica shard on on the second node");
    public void testMoveShardToNonDataNode() {
            System.nanoTime()
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            CLUSTER_MANAGER_DATA_ROLES,
            + "         \"node\" : \"node1\", \"accept_data_loss\" : true}}\n"
                + node2.getName()
        newState = allocation.reroute(
                false
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(INITIALIZING).size(), equalTo(1));
            clusterState = startInitializingShardsAndReroute(allocation, clusterState);
    public void testSerialization() throws Exception {
        logger.info("adding two nodes and performing rerouting");
            ).getClusterState();
import org.opensearch.cluster.node.DiscoveryNodeRole;
                updatedClusterState,
            )
        ClusterState newState = allocation.reroute(
                false,
            )
                    .putInSyncAllocationIds(1, Collections.singleton("randomAllocID2"))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode(node1)).add(newNode(node2))).build();
    }
        logger.info("creating an index with 1 shard, no replica");
            fail("expected IllegalArgumentException when allocating to non-existing node");
        logger.info("--> executing move allocation command to non-data node");
            assertThat(newState, not(equalTo(clusterState)));
            fail();
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
        clusterState = allocation.reroute(clusterState, "reroute");
            + "         \"node\" : \"node1\", \"accept_data_loss\" : true}}\n"
                false,
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        logger.info("--> cancel primary allocation, make sure it fails...");
        );
            toNodeId = "node2";
    public void testMoveShardFromNonDataNode() {
                clusterState,
        clusterState = allocation.reroute(
        ).getClusterState();
            clusterState,
        assertThat(routingNode1.size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        // shard routing is added as "from recovery" instead of "new index creation" so that we can test below that allocating an empty
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        clusterState = newState;
            false
        } catch (IllegalArgumentException e) {
            )
        final String index3 = "test3";
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
 * The OpenSearch Contributors require contributions made to
 *
                    .numberOfReplicas(1)
            buildNewFakeTransportAddress(),
                DiscoveryNodes.builder()
            )
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(STARTED).iterator().next().primary(), equalTo(true));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
                randomSubsetOf(new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.INGEST_ROLE)))
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).acceptDataLoss(), equalTo(true));
                    .numberOfShards(1)
import org.opensearch.cluster.node.DiscoveryNode;
            + "       ,{\"allocate_replica\" : {\"index\" : \"test\", \"shard\" : 2, \"node\" : \"node1\"}}\n"
            Settings.builder()
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
