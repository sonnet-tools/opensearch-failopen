        );
        RoutingTable routingTable = state.routingTable();  
        Metadata metadata = Metadata.builder()  
            routingTable.index("sourceIndex").shard(0).shardId(),  
            searchReplica,
        SearchReplicaAllocationDecider filterAllocationDecider = new SearchReplicaAllocationDecider();
     */
        // Can allocate primary on data node
            newRemoteSearchNode("node2"),
        assertEquals(2, clusterState.routingTable().shardsWithState(STARTED).size());  
                "translog-repo"
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            new BalancedShardsAllocator(Settings.EMPTY),
    public void testSearchReplicaRoutingDedicatedIncludes() {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
            name,  
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
        Decision decision = throttlingDecisionForSearchReplicaMoveWithoutPrimary(
        );
     * store, so it must keep the same exemption a full remote store node gets.
import org.opensearch.cluster.metadata.Metadata;  
                "segment-repo",  
    }
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.NO);
                    .numberOfShards(1)
import org.opensearch.core.index.shard.ShardId;
        assertEquals("Remote based search replica below incoming recovery limit: [0 < 2]", decision.getExplanation());
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
        IndexMetadata.Builder indexMetadata,
            false,
        // attempt to move the replica
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,  
        return newSearchNode(name, name, Map.of(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-repo"));  
 * this file be licensed under the Apache-2.0 license or a
        RoutingTable routingTable = routingTableBuilder.build();  
            )
        // Can allocate regularReplica on data node  
        );  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), settings);
        return newSearchNode(
        for (Decision decision : commandsResult.explanations().explanations().get(0).decisions().getDecisions()) {
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")  
        );
            RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        clusterState = strategy.disassociateDeadNodes(  
                "cluster-repo",
        DiscoveryNode targetNode
        DiscoveryNode primaryNode,
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    .settings(settings(Version.CURRENT))  
        // regular replicas would get promoted to primary before the CanMoveAway call.
        AllocationService service = new AllocationService(
import org.opensearch.cluster.EmptyClusterInfoService;  
import java.util.Map;  
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,  
    ) {
                    .numberOfShards(1)
            false,  
        return newNode(name, name, Map.of(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-repo"));
        // throttle outgoing on primary
        Metadata metadata = Metadata.builder()  
        clusterState = strategy.reroute(clusterState, "reroute");
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
            clusterState,
            Arrays.asList(
                assertEquals("primary shard for this replica is not yet active", decision.getExplanation());
import org.opensearch.cluster.node.DiscoveryNodes;
                REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
                    .numberOfReplicas(0)
        clusterState = strategy.reroute(clusterState, "reroute");  
        assertEquals(commandsResult.explanations().explanations().size(), 1);
        DiscoveryNode primaryNode  
        decision = (Decision.Single) filterAllocationDecider.canAllocate(searchReplica, state.getRoutingNodes().node("node1"), allocation);
        );  
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
            true,
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        clusterState = strategy.reroute(clusterState, "reroute");
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
        // start a third node, we will try and move the SR to this node
        ShardRouting searchReplica = ShardRouting.newUnassigned(
                isCorrectNoDecision = true;
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
import org.opensearch.cluster.routing.allocation.AllocationService;
    }
            RecoverySource.PeerRecoverySource.INSTANCE,
        decision = (Decision.Single) filterAllocationDecider.canRemain(regularReplica, state.getRoutingNodes().node("node1"), allocation);
            EmptySnapshotsInfoService.INSTANCE  
        // Can allocate searchReplica on search node
        }  
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),
            true,
/*  
    private static DiscoveryNode newRemoteSearchNode(String name) {
        Metadata.Builder metadataBuilder = new Metadata.Builder(metadata);
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "")
    }  
            )  
        decision = (Decision.Single) filterAllocationDecider.canRemain(primary, state.getRoutingNodes().node("node2"), allocation);
            RecoverySource.PeerRecoverySource.INSTANCE,  
        decision = (Decision.Single) filterAllocationDecider.canAllocate(primary, state.getRoutingNodes().node("node1"), allocation);
        );
        );
            false  
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;  
        gatewayAllocator.addKnownAllocation(started);
            true,
                assertEquals(Decision.Type.NO, decision.type());  
        );
            ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(primaryNode.getId())).build(),
        ClusterState clusterState = initializeClusterStateWithSingleIndexAndShard(primaryNode, metadata, gatewayAllocator);
        clusterState = strategy.reroute(clusterState, "reroute");  
        allocation.debugDecision(true);
        // Tests for canRemain  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(searchNode)).build();
import org.opensearch.cluster.routing.ShardRoutingHelper;  
        // attempt to move the replica  
        routingTableBuilder.addAsRecovery(indexMetadata);
        Index index,  
import org.opensearch.cluster.routing.RoutingTable;
        assertEquals("Remote based search replica below incoming recovery limit: [0 < 2]", decision.getExplanation());  
        throw new AssertionError("no " + ThrottlingAllocationDecider.NAME + " decision was returned");  
        TestGatewayAllocator gatewayAllocator,
    }
    ) {
                filterAllocationDecider,
     */
        decision = (Decision.Single) filterAllocationDecider.canAllocate(primary, state.getRoutingNodes().node("node2"), allocation);  
    public void testSearchReplicaWithThrottlingDeciderWithoutPrimary_SegmentsOnly() {  
import org.opensearch.common.settings.Settings;  
        initializePrimaryAndMarkInSync(indexMetadata.getIndex(), indexMetadataBuilder, gatewayAllocator, primaryNode);  
        assertEquals(commandsResult.explanations().explanations().size(), 1);  
            EmptyClusterInfoService.INSTANCE,
                REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
            new AllocationCommands(new MoveAllocationCommand("test", 0, searchNode.getId(), targetNode.getId())),  
                REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
                    .settings(settings(Version.CURRENT))  
            routingTable.index("sourceIndex").shard(0).shardId(),
    }
                    .numberOfSearchReplicas(1)  
 * compatible open source license.
            "test"
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;  
import org.opensearch.common.settings.ClusterSettings;
        TestGatewayAllocator gatewayAllocator  
package org.opensearch.cluster.routing.allocation.decider;
            )
 * SPDX-License-Identifier: Apache-2.0
        );
            new ShardId(index, 0),  
    public void testSearchReplicaWithThrottlingDecider_PrimaryBasedReplication() {
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),  
                    .numberOfSearchReplicas(1)  
    /**
            newSegmentsOnlyNode("node1"),
}
        // start a third node, we will try and move the SR to this node
            allocation  
        decision = (Decision.Single) filterAllocationDecider.canRemain(searchReplica, state.getRoutingNodes().node("node2"), allocation);
            if (decision.label().equals(ThrottlingAllocationDecider.NAME)) {
        decision = (Decision.Single) filterAllocationDecider.canAllocate(regularReplica, state.getRoutingNodes().node("node1"), allocation);
            )  
        Metadata metadata,
        AllocationService strategy = createAllocationService(Settings.EMPTY, gatewayAllocator);
        indexMetadata.putInSyncAllocationIds(0, Collections.singleton(started.allocationId().getId()));  
        boolean isCorrectNoDecision = false;
        ClusterState state = FilterAllocationDeciderTests.createInitialClusterState(service, Settings.EMPTY, Settings.EMPTY);
            true,
            true,  
    private static DiscoveryNode newSegmentsOnlyNode(String name) {
            Map.of(
            new TestGatewayAllocator(),  
        DiscoveryNode primaryNode,  
        );
            .build();
            if (decision.label().equals(ThrottlingAllocationDecider.NAME)) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "")
    private static DiscoveryNode newSegmentsOnlySearchNode(String name) {
import org.opensearch.cluster.metadata.IndexMetadata;
            .routingTable(routingTable)
        Decision decision = throttlingDecisionForSearchReplicaMoveWithoutPrimary(
                new ReplicaAfterPrimaryActiveAllocationDecider()
            false,  
import java.util.Arrays;  
import org.opensearch.cluster.node.DiscoveryNode;
        );
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;  
        assertEquals(2, clusterState.routingTable().shardsWithState(STARTED).size());
        );  
            .nodes(DiscoveryNodes.builder().add(primaryNode))
            true,
                return decision;  
public class SearchReplicaAllocationDeciderTests extends OpenSearchAllocationTestCase {  
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
     * A {@code segments_only} node has no translog repository, but a search replica recovers from the remote segment  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
            .put(
                "cluster-repo",
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.Version;
        metadataBuilder.put(indexMetadata, false);
        IndexMetadata indexMetadata = metadata.index("test");
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.NO);  
    ) {  
            .metadata(metadataBuilder.build())  
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries(primaryNode.getId()), 0);  
 *
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
    }
        // remove the primary and reroute - this would throw an NPE for search replicas but *not* regular.
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
        );
            Map.of(
    public void testSearchReplicaWithThrottlingDeciderWithoutPrimary_RemoteStoreEnabled() {
        AllocationService strategy = createAllocationService(Settings.EMPTY, gatewayAllocator);
        decision = (Decision.Single) filterAllocationDecider.canRemain(regularReplica, state.getRoutingNodes().node("node2"), allocation);
        return newNode(
        clusterState = strategy.disassociateDeadNodes(
        for (Decision decision : commandsResult.explanations().explanations().get(0).decisions().getDecisions()) {  
            false
                REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata);
    private void initializePrimaryAndMarkInSync(
                IndexMetadata.builder("test")
                "translog-repo"
        // regular replicas would get promoted to primary before the CanMoveAway call.  
        DiscoveryNode searchNode,
                "segment-repo",  
        AllocationDeciders allocationDeciders = new AllocationDeciders(  
        ShardRouting primary = ShardRouting.newUnassigned(
        AllocationService.CommandsResult commandsResult = strategy.reroute(
            true,
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newSearchNode("node2")))
            state.getRoutingNodes().node("node2"),
        decision = (Decision.Single) filterAllocationDecider.canAllocate(regularReplica, state.getRoutingNodes().node("node2"), allocation);  
    }  
        return ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.routing.RecoverySource;  
import org.opensearch.core.index.Index;
import java.util.HashSet;
            ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1")).build(),
        assertEquals(Decision.Type.YES, decision.type());
            name,
import org.opensearch.cluster.OpenSearchAllocationTestCase;
    }  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
        decision = (Decision.Single) filterAllocationDecider.canRemain(primary, state.getRoutingNodes().node("node1"), allocation);
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(  
            )
            newRemoteNode("node1"),  
     * asks to move the search replica to {@code targetNode} and returns the throttling decider's decision.  
        AllocationService.CommandsResult commandsResult = strategy.reroute(
        ClusterState clusterState = initializeClusterStateWithSingleIndexAndShard(newNode("node1"), metadata, gatewayAllocator);
            .put(
        ShardRouting regularReplica = ShardRouting.newUnassigned(  
import java.util.Collections;
    }
    private ClusterState initializeClusterStateWithSingleIndexAndShard(  
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();  
            "test"  
        }
 * The OpenSearch Contributors require contributions made to  
            name,  
        // Tests for canAllocate
            routingTable.index("sourceIndex").shard(0).shardId(),
        // Cannot allocate searchReplica on data node
        assertEquals(Decision.Type.YES, decision.type());
            .build();  
        // Cannot allocate regularReplica on search node
    private Decision throttlingDecisionForSearchReplicaMoveWithoutPrimary(
            newSegmentsOnlyNode("node3")
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
        clusterState = strategy.reroute(clusterState, "reroute");  
    }
                    .numberOfReplicas(0)
     * Starts the primary on {@code primaryNode} and the search replica on {@code searchNode}, kills the primary, then
    }  
            }
        Set<Setting<?>> settings = new HashSet<>(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            false,
            newSegmentsOnlySearchNode("node2"),  
                IndexMetadata.builder("test")
            allocationDeciders,
        clusterState = strategy.reroute(clusterState, "reroute");
        final ShardRouting unassigned = ShardRouting.newUnassigned(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        decision = (Decision.Single) filterAllocationDecider.canRemain(searchReplica, state.getRoutingNodes().node("node1"), allocation);
            name,
        // Cannot allocate primary on search node
import org.opensearch.cluster.ClusterState;
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
            clusterState,  
 */  
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());  
    private static DiscoveryNode newRemoteNode(String name) {
        // remove the primary and reroute - this would throw an NPE for search replicas but *not* regular.
            }
            RecoverySource.PeerRecoverySource.INSTANCE,
        );  
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
    /**
import org.opensearch.cluster.routing.UnassignedInfo;
        );
        clusterState = ClusterState.builder(clusterState)
            .build();
import org.opensearch.snapshots.EmptySnapshotsInfoService;  
import org.opensearch.test.gateway.TestGatewayAllocator;
            new UnassignedInfo(UnassignedInfo.Reason.NODE_LEFT, "")  
            newRemoteNode("node3")
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());  
        ShardRouting started = ShardRoutingHelper.moveToStarted(ShardRoutingHelper.initialize(unassigned, primaryNode.getId()));
import org.opensearch.cluster.routing.ShardRouting;
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(targetNode)).build();
import org.opensearch.common.settings.Setting;
import java.util.Set;
        assertTrue(isCorrectNoDecision);
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
