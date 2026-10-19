                .build()
        logger.info("start primary shard");
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
    }
                clusterState,
            allocation.reroute(clusterState, new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", false)), false, false);
            .addAsRecovery(metadata.index(index1))  
        } catch (IllegalArgumentException e) {
        logger.info("creating an index with 1 shard, no replica");
                    .settings(settings(Version.CURRENT))  
            + "    ]\n"  
            new AllocationCommands(new MoveAllocationCommand("test", 0, existingNodeId, toNodeId)),
    public void testAllocateStalePrimaryCommand() {
            Version.CURRENT
            .build();  
            buildNewFakeTransportAddress(),
            new AllocationCommands(new AllocateStalePrimaryAllocationCommand(index, 0, node1, true)),  
                clusterState,
            .addAsRecovery(metadata.index(index2))
        logger.info("--> building initial routing table");  
            .routingTable(routingTable)
            false,  
            new RoutingNodes(clusterState, false),
                        + shardId
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(STARTED).iterator().next().primary(), equalTo(true));
            new HashSet<>(  
                new AllocationCommands(  
        assertThat(newState, not(equalTo(clusterState)));
                + ": source ["
            clusterState,  
                .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
        logger.info("--> allocate the replica shard on on the second node");  
        assertThat(expectThrows(IllegalArgumentException.class, () -> {  
                + node2.getName()  
                    .numberOfShards(1)
            "test2",
        );
        assertThat(clusterState.getRoutingNodes().node(existingNodeId).iterator().next().state(), equalTo(ShardRoutingState.RELOCATING));
        Metadata metadata = Metadata.builder()  
        logger.info("move the shard");  
        clusterState = newState;  
        } catch (IllegalArgumentException e) {
                false,
            ClusterInfo.EMPTY,
            false  
        );  
        assertThat(newState, not(equalTo(clusterState)));  
        assertThat(shardRoutings, hasSize(2));
        logger.info("--> allocating non-existing index, should fail");
            logger.info("--> cancel the source replica shard");
                new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand("test", 0, "node1", false)),
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(INITIALIZING).size(), equalTo(1));  
        assertThat(routingNode1.shardsWithState(STARTED).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(INITIALIZING).size(), equalTo(1));
        );  
                e.getMessage(),
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        );  
import static java.util.Collections.singleton;
import java.util.HashSet;
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand(index, shardId.id(), "node42")), false, false);  
                + node2.getName()
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).shardId(), equalTo(3));
        try {
        logger.info("--> allocate the replica shard on on the second node");
        clusterState = newState;
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand("test", 1, "node2")), false, false);
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).index(), equalTo("test"));
                + ": source ["
            Settings.builder()
                new AllocationCommands(  
            false
        } catch (IllegalArgumentException e) {}
        logger.info("--> allocate the replica shard on on the second node");  
        );  
        AllocationService allocation = createAllocationService(
            SnapshotShardSizeInfo.EMPTY,
    }
                    .add(newNode("node3"))  
import org.opensearch.cluster.metadata.Metadata;
            false,
        in = new NamedWriteableAwareStreamInput(in, namedWriteableRegistry);
                )  
            )
        logger.info("--> move the replica shard");
            new AllocateReplicaAllocationCommand("test", 2, "node1"),  
        if (randomBoolean()) {
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).index(), equalTo("test"));
            new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node2")),
                IndexMetadata.builder(index)
                        + " can result in data loss. Please confirm by setting the accept_data_loss parameter to true"
        );
        );
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));  
            new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand("test", 0, "node1", true)),
            "[move_allocation] can't move [test][0] from "
            new AllocateStalePrimaryAllocationCommand("test", 2, "node1", true),
        try {
                + " to "  
        clusterState = newState;
        DiscoveryNode node2 = new DiscoveryNode(  
        logger.info("--> adding 3 nodes on same rack and do rerouting");  
        logger.info("--> allocating stale primary with acceptDataLoss flag set to false");
    public void testMoveShardFromNonDataNode() {
                containsString(  
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(INITIALIZING).size(), equalTo(1));
                clusterState,
                e.getMessage(),
            e.getMessage()
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).node(), equalTo("node1"));
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).allowPrimary(), equalTo(true));
import org.opensearch.core.index.shard.ShardId;
                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
        AllocationCommands commands = new AllocationCommands(  
                false
        RoutingTable routingTable = RoutingTable.builder().addAsRecovery(metadata.index(index)).build();
            buildNewFakeTransportAddress(),
            fail("expected IllegalArgumentException when allocating stale primary with acceptDataLoss flag set to false");
        }).getMessage(), containsString("all copies of [" + index3 + "][0] are already assigned. Use the move allocation command instead"));
            "test2",
    }  
            .build();
            clusterState = allocation.reroute(
        );
            assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).iterator().next().primary(), equalTo(true));  
                new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", true)),
            "[move_allocation] can't move [test][0] from "  
                false
            clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            CLUSTER_MANAGER_DATA_ROLES,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        Index index = clusterState.getMetadata().index("test").getIndex();
 * license agreements. See the NOTICE file distributed with
            clusterState,  
        );
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        logger.info("--> allocating empty primary shard with accept_data_loss flag set to true");
                IndexMetadata.builder(index1)
                    new AllocateStalePrimaryAllocationCommand(index1, 0, node1, true),
            assertThat(e.getMessage(), containsString("failed to resolve [node42], no matching nodes"));  
        try {  
        }
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
            .put(
        } catch (IllegalArgumentException e) {}
                false
        assertThat(newState, not(equalTo(clusterState)));
    public void testConflictingCommandsInSingleRequest() {  
            );
            "node2",  
            clusterState,
            new MoveAllocationCommand("test", 3, "node2", "node3"),
            false,
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;  
        ).getClusterState();  
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).index(), equalTo("test"));
        ClusterState newState = allocation.reroute(
        try {
        final String index3 = "test3";
        ).getClusterState();
        String existingNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
                new AllocationCommands(new CancelAllocationCommand("test", 0, "node2", false)),
                false
            ),
        String commands = "{\n"  
                false,
 */  
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
}  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import static org.hamcrest.Matchers.equalTo;
        final String node2 = "node2";
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
            .routingTable(routingTable)  
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
                    new AllocateEmptyPrimaryAllocationCommand(index2, 0, node1, true),
        BytesStreamOutput bytes = new BytesStreamOutput();
            fail("expected ShardNotFoundException when allocating non-existing shard");
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        );
 * The OpenSearch Contributors require contributions made to  
    }  
        AllocationService allocation = createAllocationService(
        clusterState = newState;  
import org.opensearch.cluster.routing.allocation.command.AllocateEmptyPrimaryAllocationCommand;
                    "allocating an empty primary for "  
 * this work for additional information regarding copyright
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
                false  
import static org.hamcrest.Matchers.not;  
                containsString(
        clusterState = newState;
            new AllocateReplicaAllocationCommand(index, shardId, node),
import org.opensearch.cluster.routing.allocation.command.AllocateStalePrimaryAllocationCommand;  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        AllocationService allocation = createAllocationService(  
            false
/*
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        Metadata metadata = Metadata.builder()  
        logger.info("--> subsequent replica allocation fails as all configured replicas have been allocated");
            assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        logger.info("--> allocating to non-data node, should fail");  
                    .putInSyncAllocationIds(0, Collections.singleton("randomAllocID"))  
            + "       ,{\"cancel\" : {\"index\" : \"test\", \"shard\" : 4, \"node\" : \"node5\", \"allow_primary\" : true}} \n"
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(INITIALIZING).size(), equalTo(1));
            "node1",
import org.opensearch.cluster.routing.allocation.command.CancelAllocationCommand;
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(STARTED).size(), equalTo(1));  
                ),  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            logger.info("--> start the former target replica shard");
        } catch (IllegalArgumentException e) {}
                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
        logger.info("--> verify that we fail when there are no unassigned shards");
        try {  
            .build();  
            "node2",
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        }
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).toNode(), equalTo("node3"));  
        try {
            fail();  
        logger.info("--> executing move allocation command from non-data node");
    }
                    .numberOfShards(1)  
import org.opensearch.cluster.routing.RoutingTable;  
            new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node2")),  
import org.opensearch.cluster.routing.ShardRouting;
            assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));  
            .put(  
import org.opensearch.cluster.routing.RoutingNodes;
        logger.info("--> allocating empty primary with acceptDataLoss flag set to true");
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> command.execute(routingAllocation, false));
    public void testXContent() throws Exception {
            ).getClusterState();  
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).allowPrimary(), equalTo(true));
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).shardId(), equalTo(3));  
        logger.info("--> start the primary shard");
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))  
            allocation.reroute(
        final String index = "test";
import org.opensearch.index.IndexNotFoundException;
        );
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        }).getMessage(), containsString("primary [" + index2 + "][0] is already assigned"));
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
                    "allocating an empty primary for "
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
        }
    }
            ).getClusterState();  
        logger.info("--> building initial routing table");
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
            false,
            false  
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(INITIALIZING).size(), equalTo(1));
            clusterState,
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
    public void testAllocateCommand() {
            new AllocationCommands(new CancelAllocationCommand("test", 0, "node2", false)),
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        assertThat(routingNode1.size(), equalTo(1));
                false
            allocation.reroute(
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
            .build();
            clusterState,  
        clusterState = newState;  
            + "       ,{\"move\" : {\"index\" : \"test\", \"shard\" : 3, \"from_node\" : \"node2\", \"to_node\" : \"node3\"}} \n"
        Metadata metadata = Metadata.builder()
        clusterState = allocation.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node1).add(node2)).build();
 * GitHub history for details.
            false  
            assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).size(), equalTo(1));
        assertThat(expectThrows(IllegalArgumentException.class, () -> {  
        }  
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(NetworkModule.getNamedWriteables());  
            new CancelAllocationCommand("test", 4, "node5", true)
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        XContentParser parser = createParser(JsonXContent.jsonXContent, commands);
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
            buildNewFakeTransportAddress(),
    public void testMoveShardToNonDataNode() {  
                false
import static org.hamcrest.Matchers.containsString;  
            .build();
        try {
                .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
            new AllocateStalePrimaryAllocationCommand(index, shardId, node, true)  
            new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand(index3, 0, node1, true)),
            emptyMap(),
        clusterState = newState;
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
import org.opensearch.cluster.metadata.IndexMetadata;
            assertThat(e.getMessage(), containsString("no such shard"));
                    .putInSyncAllocationIds(0, Collections.singleton("asdf"))
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).node(), equalTo("node1"));
            allocation.reroute(clusterState, new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", false)), false, false);
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).index(), equalTo("test"));
        inSyncAllocationIds = clusterState.metadata().index(index).inSyncAllocationIds(0);
        // mark all shards as stale
        try {  
        ).getClusterState();  
        MoveAllocationCommand command = new MoveAllocationCommand(index.getName(), 0, "node2", "node1");
                randomSubsetOf(new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.INGEST_ROLE)))
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).index(), equalTo("test"));  
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).index(), equalTo("test"));  
            assertThat(newState, not(equalTo(clusterState)));  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
        logger.info("--> cancel the relocation allocation");
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).acceptDataLoss(), equalTo(true));
            "test2",
            + "         \"node\" : \"node1\", \"accept_data_loss\" : true}}\n"
                    .putInSyncAllocationIds(1, Collections.singleton("qwertz"))  
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));  
 * Modifications Copyright OpenSearch Contributors. See
                .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")  
            new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node2")),  
import org.opensearch.cluster.routing.RecoverySource;  
            logger.info("--> cancel the move of the replica shard");  
        logger.info("adding two nodes and performing rerouting");  
        DiscoveryNode node1 = new DiscoveryNode(
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        assertThat(updatedClusterState.getRoutingNodes().node(node1).shardsWithState(STARTED).size(), equalTo(1));  
            false,  
                + "] is not a data node.",  
import org.opensearch.core.xcontent.XContentParser;
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        } catch (ShardNotFoundException e) {  
        final String index2 = "test2";  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            "test1",
        DiscoveryNode node1 = new DiscoveryNode(
                    .settings(settings(Version.CURRENT))  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node1).add(node2)).build();  
            .build();  
            fail("expected IllegalArgumentException when allocating shard while no unassigned shard available");
        assertThat(inSyncAllocationIds, equalTo(Collections.singleton(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID)));
            )  
        logger.info("creating an index with 1 shard, no replica");
            "node2",
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand("test", 0, "node3")), false, false);  
            emptyMap(),
            clusterState,
            .routingTable(routingTable)  
        clusterState = allocation.reroute(
            assertThat(
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).index(), equalTo("test"));  
                .build()  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
                    .numberOfReplicas(1)
                IndexMetadata.builder(index)
        assertThat(routingNode1.size(), equalTo(1));  
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).node(), equalTo("node1"));  
            "node2",
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));  
        assertEquals(  
        AllocationService allocation = createAllocationService(
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).index(), equalTo("test"));
            new AllocationCommands(new CancelAllocationCommand("test", 0, "node2", false)),
        // Since the commands are named writeable we need to register them and wrap the input stream
import org.opensearch.cluster.routing.allocation.command.AllocateReplicaAllocationCommand;
        logger.info("--> start the replica shard");
                + node1
        logger.info("--> start the replica shard");  
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        Index index = clusterState.getMetadata().index("test").getIndex();  
            e.getMessage()
                .put(EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), "none")
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            ),
        );  
            ).getClusterState();
        ).getClusterState();
        return new NamedXContentRegistry(NetworkModule.getNamedXContents());  
            SnapshotShardSizeInfo.EMPTY,  
        }
import org.opensearch.Version;  
                + node1
            false
            false
        }  
import org.opensearch.cluster.node.DiscoveryNodes;
                ),  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));  
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
    }  
        AllocationCommands.writeTo(commands, bytes);
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        final String index = "test";  
import java.util.List;  
            .routingTable(routingTable)
                updatedClusterState,
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        logger.info("finish moving the shard");
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        try {
            toNodeId = "node2";
            logger.info("--> cancel the primary allocation (with allow_primary set to true)");
import static org.hamcrest.Matchers.hasSize;
        logger.info("--> cancel primary allocation, make sure it fails...");  
        logger.info("creating an index with 1 shard, no replica");
 *
            clusterState,
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).size(), equalTo(1));
            .build();  
        );  
import org.opensearch.core.common.io.stream.StreamInput;  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
        );
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
import org.opensearch.cluster.node.DiscoveryNode;  
                finalClusterState,
                clusterState,
            .routingTable(routingTable)  
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).toNode(), equalTo("node3"));
            clusterState,  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        assertThat(clusterState.getRoutingNodes().node(existingNodeId).isEmpty(), equalTo(true));
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).node(), equalTo("node1"));  
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).node(), equalTo("node1"));
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).index(), equalTo("test"));  
        logger.info("--> building initial routing table");
    public void testCancelCommand() {
                false,  
            assertThat(newState, not(equalTo(clusterState)));  
                )
        );  
            false,
import org.opensearch.common.network.NetworkModule;
            + "       ,{\"allocate_replica\" : {\"index\" : \"test\", \"shard\" : 2, \"node\" : \"node1\"}}\n"  
 *  
                    .putInSyncAllocationIds(1, Collections.singleton("randomAllocID2"))
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).shardId(), equalTo(2));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> command.execute(routingAllocation, false));
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));  
            fail();  
            assertThat(  
            .put(  
        } else {
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).node(), equalTo("node5"));
            false,  
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).index(), equalTo("test"));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        assertThat(sCommands.commands().size(), equalTo(5));
import java.util.Set;
                    .settings(settings(Version.CURRENT))
            "test1",  
    protected NamedXContentRegistry xContentRegistry() {
                    .putInSyncAllocationIds(0, Collections.singleton("randomAllocID"))
        final ClusterState finalClusterState = allocation.reroute(clusterState, "reroute");  
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).node(), equalTo("node5"));  
        final String node2 = "node2";
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            "test2",  
        logger.info("--> adding two nodes");
            + "         \"node\" : \"node1\", \"accept_data_loss\" : true}}\n"  
                        + shardId
            assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
                    new AllocateReplicaAllocationCommand(index3, 0, node2),
            );  
                clusterState,
            false  
            );  
            new AllocateEmptyPrimaryAllocationCommand("test", 1, "node1", true),
        clusterState = allocation.reroute(  
            toNodeId = "node1";  
 * KIND, either express or implied.  See the License for the
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).acceptDataLoss(), equalTo(true));
                false
            );
            false,  
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).size(), equalTo(1));
            );  
        // move two tokens, parser expected to be "on" `commands` field  
                    .add(newNode("node4", singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE)))
        MoveAllocationCommand command = new MoveAllocationCommand(index.getName(), 0, "node1", "node2");  
        // primary with accept_data_loss flag set to false fails
            clusterState,
            assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
                new AllocationCommands(  
            )
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            .metadata(metadata)
                new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),  
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(INITIALIZING).size(), equalTo(1));  
                IndexMetadata.builder(index2)
            new HashSet<>(
        logger.info("--> cancel the primary being replicated, make sure it fails");  
                DiscoveryNodes.builder()  
            "node1",  
                new AllocationCommands(new CancelAllocationCommand("test", 0, "node3", false)),  
            "node2",
            .metadata(metadata)
                false,  
            clusterState = newState;
 * You may obtain a copy of the License at  
 */
        parser.nextToken();
            Settings.builder()  
        clusterState = ClusterState.builder(clusterState)
        AllocationService allocation = createAllocationService(
            .build();
            .put(
 */  
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(INITIALIZING).size(), equalTo(1));  
        } else {
        logger.info("--> cancel allocation of the replica shard");
 *     http://www.apache.org/licenses/LICENSE-2.0
            new AllocationCommands(new AllocateEmptyPrimaryAllocationCommand("test", 0, "node1", true)),
        ClusterState newState = allocation.reroute(  
            new RoutingNodes(clusterState, false),  
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).shardId(), equalTo(2));
        ClusterState newState = allocation.reroute(
                    .numberOfReplicas(1)  
    }
import org.opensearch.cluster.routing.ShardRoutingState;
                    new AllocateStalePrimaryAllocationCommand(index1, 0, node2, true)
            "node1",  
        assertThat(inSyncAllocationIds, not(Collections.singleton(RecoverySource.ExistingStoreRecoverySource.FORCED_ALLOCATION_ID)));
                false
            .routingTable(routingTable)  
            fail("expected IllegalArgumentException when allocating to non-existing node");
    private final Logger logger = LogManager.getLogger(AllocationCommandsTests.class);
                false,  
            .build();
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).shardId(), equalTo(4));
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(INITIALIZING).size(), equalTo(1));  
                clusterState,  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        logger.info("--> allocating empty primary with acceptDataLoss flag set to false");  
 * not use this file except in compliance with the License.
        ).getClusterState();
        newState = allocation.reroute(
        logger.info("--> allocating empty primary with acceptDataLoss flag set to true");  
            )
            false,
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(0));
                + " to "
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .build()  
                    new AllocateReplicaAllocationCommand(index3, 0, node2)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
        newState = allocation.reroute(
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).shardId(), equalTo(1));
        Set<String> inSyncAllocationIds = clusterState.metadata().index(index).inSyncAllocationIds(0);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
        }).getMessage(), containsString("primary [" + index1 + "][0] is already assigned"));
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
        ).getClusterState();
                    .numberOfReplicas(1)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(metadata)
import static org.hamcrest.Matchers.nullValue;
            "test1",
        Metadata metadata = Metadata.builder()
                    .putInSyncAllocationIds(0, Collections.singleton("randomAllocID"))
        newState = allocation.reroute(  
                false,
                false,
            allocation.reroute(
        RoutingAllocation routingAllocation = new RoutingAllocation(
        newState = allocation.reroute(
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
            false,
        logger.info("--> allocating non-existing shard, should fail");
                ),  
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).node(), equalTo("node1"));
                IndexMetadata.builder(index3)  
                .build()
                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")  
 * software distributed under the License is distributed on an
            buildNewFakeTransportAddress(),  
            clusterState = allocation.reroute(
            clusterState,
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));  
                    .numberOfShards(1)
        // primary with accept_data_loss flag set to false fails
 * specific language governing permissions and limitations
                    new AllocateEmptyPrimaryAllocationCommand(index2, 0, node2, true)
                    .settings(settings(Version.CURRENT))
            .build();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(routingNode1.shardsWithState(INITIALIZING).size(), equalTo(1));  
        AllocationCommands sCommands = AllocationCommands.fromXContent(parser);  
            "node2",  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
            .put(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            false
import org.opensearch.cluster.routing.allocation.command.AbstractAllocateAllocationCommand;  
            logger.info("--> cancel the primary allocation (with allow_primary set to true)");
            );  
            Version.CURRENT
        clusterState = allocation.reroute(clusterState, "reroute");
            .nodes(
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
            clusterState,
        if ("node1".equals(existingNodeId)) {  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Collections;
import static java.util.Collections.emptyMap;  
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).fromNode(), equalTo("node2"));
            ).getClusterState();
    }
        ).getClusterState();
        }
 * Unless required by applicable law or agreed to in writing,
            clusterState = allocation.reroute(  
                    .add(newNode("node1"))
                randomSubsetOf(new HashSet<>(Arrays.asList(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE, DiscoveryNodeRole.INGEST_ROLE)))  
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
                + node2  
        assertThat(newState, not(equalTo(clusterState)));
 *
            clusterState = newState;
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            ClusterInfo.EMPTY,  
            fail("expected ShardNotFoundException when allocating non-existing index");
        AllocationCommands sCommands = AllocationCommands.readFrom(in);
        // Now we can read them!  
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).acceptDataLoss(), equalTo(true));  
import org.opensearch.common.xcontent.json.JsonXContent;  
            .build();  
                false
            emptyMap(),
 * Licensed to Elasticsearch under one or more contributor  
        clusterState = newState;  
        assertThat(newState, not(equalTo(clusterState)));  
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand("test2", 0, "node2")), false, false);  
            fail("expected IllegalArgumentException when allocating empty primary with acceptDataLoss flag set to false");
            assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        assertThat(inSyncAllocationIds, hasSize(1));  
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(RELOCATING).size(), equalTo(1));  
            assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(RELOCATING).size(), equalTo(1));
            clusterState,  
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
            allocation.reroute(
        newState = allocation.reroute(
        );  
        ).getClusterState();
                    .numberOfReplicas(1)
            .build();  
                    .add(newNode("node2"))
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
import org.opensearch.common.settings.Settings;
            allocation.reroute(clusterState, new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", false)), false, false);
        assertThat(clusterState.getRoutingNodes().node(toNodeId).iterator().next().state(), equalTo(ShardRoutingState.STARTED));
        logger.info("--> allocate the replica shard on the primary shard node, should fail");
        logger.info("--> allocate the replica shard on on the second node");
            .build();
import java.util.Arrays;  
        RoutingTable routingTable = RoutingTable.builder().addAsRecovery(metadata.index(index)).build();  
            false,
        clusterState = ClusterState.builder(clusterState)
        logger.info("--> executing move allocation command to non-data node");  
        ).getClusterState();  
            + "        {\"allocate_empty_primary\" : {\"index\" : \"test\", \"shard\" : 1,"
                false,
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
                    .putInSyncAllocationIds(1, Collections.singleton("randomAllocID2"))  
    public void testMoveShardCommand() {  
            assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
/*  
        assertThat(((MoveAllocationCommand) (sCommands.commands().get(3))).fromNode(), equalTo("node2"));
                new AllocationCommands(new CancelAllocationCommand("test", 0, "node1", true)),
            .metadata(metadata)
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(STARTED).size(), equalTo(1));  
 * the Apache License, Version 2.0 (the "License"); you may
            );  
                finalClusterState,
            assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
        assertThat(((AllocateStalePrimaryAllocationCommand) (sCommands.commands().get(1))).shardId(), equalTo(2));  
        assertThat(clusterState.getRoutingNodes().node("node2").shardsWithState(INITIALIZING).size(), equalTo(1));
        clusterState = ClusterState.builder(clusterState)
            logger.info("--> move the replica shard again");  
        try {
        final List<ShardRouting> shardRoutings = clusterState.getRoutingNodes().shardsWithState(UNASSIGNED);  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));  
        assertEquals(
                false,
/*  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode(node1)).add(newNode(node2))).build();
        StreamInput in = bytes.bytes().streamInput();  
                new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node1")),  
                    .putInSyncAllocationIds(1, Collections.singleton("qwertz"))
    private AbstractAllocateAllocationCommand randomAllocateCommand(String index, int shardId, String node) {
        assertThat(clusterState.getRoutingNodes().node(toNodeId).iterator().next().state(), equalTo(ShardRoutingState.INITIALIZING));
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
        logger.info("--> start the replica shard");  
        final ClusterState updatedClusterState = clusterState;
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));  
                clusterState,
        return randomFrom(  
        routingNode1 = clusterState.getRoutingNodes().node(node1);
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
                false,
    }  
        DiscoveryNode node2 = new DiscoveryNode(
        assertThat(newState, not(equalTo(clusterState)));
        String toNodeId;
            )
        AllocationService allocation = createAllocationService(  
            allocation.reroute(
        ).getClusterState();
            allocation.reroute(clusterState, new AllocationCommands(randomAllocateCommand(index, shardId.id(), "node4")), false, false);
                    .putInSyncAllocationIds(1, Collections.singleton("randomAllocID2"))
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),
public class AllocationCommandsTests extends OpenSearchAllocationTestCase {  
            System.nanoTime()
            "node1",
            emptyMap(),  
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).shardId(), equalTo(1));  
        newState = allocation.reroute(
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));  
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));
            )
    public void testSerialization() throws Exception {
        final String node1 = "node1";  
        clusterState = newState;  
            Version.CURRENT  
            clusterState,
        Metadata metadata = Metadata.builder()
        logger.info("start primary shard");  
            new AllocateEmptyPrimaryAllocationCommand(index, shardId, node, true),
            fail();  
            ).getClusterState();
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            + "       ,{\"allocate_stale_primary\" : {\"index\" : \"test\", \"shard\" : 2,"
        logger.info("--> building initial routing table");
                    .numberOfShards(1)
            assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
import org.opensearch.index.shard.ShardNotFoundException;  
        assertThat(((CancelAllocationCommand) (sCommands.commands().get(4))).shardId(), equalTo(4));
            new AllocationDeciders(Collections.emptyList()),  
            .build();
            assertThat(clusterState.getRoutingNodes().node("node3").shardsWithState(INITIALIZING).get(0).relocatingNodeId(), nullValue());
            "test1",  
        final String index1 = "test1";
            newState = allocation.reroute(  
            .metadata(metadata)  
            );
        clusterState = allocation.reroute(clusterState, "reroute");  
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(0));  
        }
                        + " can result in data loss. Please confirm by setting the accept_data_loss parameter to true"  
            .routingTable(routingTable)
        logger.info("--> adding 3 nodes");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.common.io.stream.BytesStreamOutput;  
            .metadata(metadata)
                    .settings(settings(Version.CURRENT))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
    }  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode(node1)).add(newNode(node2))).build();
        } catch (IllegalArgumentException e) {
                new AllocationCommands(new AllocateStalePrimaryAllocationCommand(index, shardId.id(), "node1", false)),  
import org.opensearch.cluster.ClusterInfo;
        logger.info("--> adding two nodes");  
        AllocationService allocation = createAllocationService(
            new AllocationDeciders(Collections.emptyList()),
            assertThat(e.getMessage(), containsString("no such index [test2]"));  
                + node2
        parser.nextToken();
        RoutingTable routingTable = RoutingTable.builder()
            allocation.reroute(
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
        RoutingAllocation routingAllocation = new RoutingAllocation(
                    .putInSyncAllocationIds(0, Collections.singleton("asdf"))  
                    .numberOfShards(1)  
import org.opensearch.core.index.Index;
import org.opensearch.cluster.routing.RoutingNode;
        Metadata metadata = Metadata.builder()  
            false  
        } catch (IllegalArgumentException e) {}
            clusterState,
                clusterState,
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        } catch (IllegalArgumentException e) {}
import org.opensearch.snapshots.SnapshotShardSizeInfo;
        assertThat(((AllocateEmptyPrimaryAllocationCommand) (sCommands.commands().get(0))).acceptDataLoss(), equalTo(true));  
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            .build();  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))  
            Settings.builder()
            false,
            Version.CURRENT
        // shard routing is added as "from recovery" instead of "new index creation" so that we can test below that allocating an empty  
                    .numberOfReplicas(1)
            fail("expected IllegalArgumentException when allocating replica shard on the primary shard node");
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
            CLUSTER_MANAGER_DATA_ROLES,  
        try {
import org.opensearch.cluster.ClusterState;
        assertThat(expectThrows(IllegalArgumentException.class, () -> {  
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(0));
        final String node1 = "node1";  
            false
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            false
        logger.info("--> cancel primary allocation, make sure it fails...");  
package org.opensearch.cluster.routing.allocation;
        assertThat(((AllocateReplicaAllocationCommand) (sCommands.commands().get(2))).shardId(), equalTo(2));
        logger.info("--> start the primary shard");  
        } catch (IndexNotFoundException e) {
            fail("expected IllegalArgumentException when allocating to non-data node");  
        final ShardId shardId = new ShardId(metadata.index(index).getIndex(), 0);
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
 * compatible open source license.
        // shard routing is added as "from recovery" instead of "new index creation" so that we can test below that allocating an empty
        Metadata metadata = Metadata.builder()  
            "node1",
            + "}\n";
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.getRoutingNodes().node("node2").size(), equalTo(1));  
        RoutingNode routingNode1 = clusterState.getRoutingNodes().node(node1);
            System.nanoTime()
                false
        assertThat(sCommands.commands().size(), equalTo(5));  
        assertThat(clusterState.getRoutingNodes().node("node3").size(), equalTo(1));
        clusterState = allocation.reroute(clusterState, "reroute");
            new AllocationCommands(new AllocateReplicaAllocationCommand("test", 0, "node2")),
            "node1",
        assertThat(clusterState.getRoutingNodes().node("node1").size(), equalTo(1));
                + "] is not a data node.",
            .build();
        ).getClusterState();
                false,
        logger.info("--> allocating same index primary in multiple commands should fail");
        logger.info("--> allocating to non-existent node, should fail");
                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), "none")
        ).getClusterState();
import org.apache.logging.log4j.Logger;
        clusterState = allocation.reroute(  
            .build();
            assertThat(e.getMessage(), containsString("allocation can only be done on data nodes"));
            Settings.builder()  
            .metadata(metadata)
        );
        } catch (IllegalArgumentException e) {  
            .addAsRecovery(metadata.index(index3))
            newState = allocation.reroute(  
            + "    \"commands\" : [\n"
    @Override
        logger.info("start primary shard");  
