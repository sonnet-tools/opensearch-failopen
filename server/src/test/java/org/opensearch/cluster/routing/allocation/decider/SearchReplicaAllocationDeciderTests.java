        AllocationService strategy = createAllocationService(Settings.EMPTY, gatewayAllocator);
        Decision decision = throttlingDecisionForSearchReplicaMoveWithoutPrimary(
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        );
                REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
                assertEquals(Decision.Type.NO, decision.type());
        TestGatewayAllocator gatewayAllocator,
        assertEquals("Remote based search replica below incoming recovery limit: [0 < 2]", decision.getExplanation());
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
import org.opensearch.cluster.node.DiscoveryNodes;
            EmptyClusterInfoService.INSTANCE,
        clusterState = strategy.disassociateDeadNodes(
            name,
        );
            false,
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            if (decision.label().equals(ThrottlingAllocationDecider.NAME)) {
        return newNode(
        routingTableBuilder.addAsRecovery(indexMetadata);
     * store, so it must keep the same exemption a full remote store node gets.
        for (Decision decision : commandsResult.explanations().explanations().get(0).decisions().getDecisions()) {
                new SameShardAllocationDecider(Settings.EMPTY, clusterSettings),
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newSearchNode("node2")))
        clusterState = strategy.reroute(clusterState, "reroute");
                "cluster-repo",
     * A {@code segments_only} node has no translog repository, but a search replica recovers from the remote segment
    }
        }
        Metadata.Builder metadataBuilder = new Metadata.Builder(metadata);
        // start a third node, we will try and move the SR to this node
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        decision = (Decision.Single) filterAllocationDecider.canRemain(regularReplica, state.getRoutingNodes().node("node2"), allocation);
                assertEquals("primary shard for this replica is not yet active", decision.getExplanation());
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")
import org.opensearch.common.settings.Setting;
        AllocationService.CommandsResult commandsResult = strategy.reroute(
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
                isCorrectNoDecision = true;
        Metadata metadata,
        AllocationService.CommandsResult commandsResult = strategy.reroute(
    private Decision throttlingDecisionForSearchReplicaMoveWithoutPrimary(
        );
import org.opensearch.cluster.routing.ShardRoutingHelper;
        );
    private static DiscoveryNode newSegmentsOnlySearchNode(String name) {
            "test"
        Set<Setting<?>> settings = new HashSet<>(ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    .numberOfSearchReplicas(1)
                "segment-repo",
            allocation
    /**
                "translog-repo"
        metadataBuilder.put(indexMetadata, false);
            )
    private void initializePrimaryAndMarkInSync(
        assertEquals(Decision.Type.YES, decision.type());
                filterAllocationDecider,
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.NO);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertEquals("Remote based search replica below incoming recovery limit: [0 < 2]", decision.getExplanation());
        );
            "test"
        // Tests for canRemain
        clusterState = strategy.reroute(clusterState, "reroute");
            )
                "translog-repo"
        assertEquals(commandsResult.explanations().explanations().size(), 1);
import org.opensearch.cluster.routing.ShardRouting;
        decision = (Decision.Single) filterAllocationDecider.canRemain(primary, state.getRoutingNodes().node("node1"), allocation);
        assertEquals(commandsResult.explanations().explanations().size(), 1);
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
            )
        return newNode(name, name, Map.of(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-repo"));
            true,
            newRemoteNode("node3")
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries("node1"), 0);
        decision = (Decision.Single) filterAllocationDecider.canRemain(searchReplica, state.getRoutingNodes().node("node1"), allocation);
        assertEquals(2, clusterState.routingTable().shardsWithState(STARTED).size());
            name,
        // Cannot allocate primary on search node
        RoutingTable routingTable = state.routingTable();
            .routingTable(routingTable)
            )
        ClusterState state = FilterAllocationDeciderTests.createInitialClusterState(service, Settings.EMPTY, Settings.EMPTY);
import java.util.HashSet;
        return newSearchNode(name, name, Map.of(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-repo"));
        );
 */
        final ShardRouting unassigned = ShardRouting.newUnassigned(
        DiscoveryNode targetNode
            true,
            .build();
            .put(
        decision = (Decision.Single) filterAllocationDecider.canRemain(regularReplica, state.getRoutingNodes().node("node1"), allocation);
            searchReplica,
        clusterState = strategy.reroute(clusterState, "reroute");
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
import org.opensearch.cluster.metadata.IndexMetadata;
                new ReplicaAfterPrimaryActiveAllocationDecider()
        decision = (Decision.Single) filterAllocationDecider.canAllocate(primary, state.getRoutingNodes().node("node1"), allocation);
import org.opensearch.cluster.EmptyClusterInfoService;
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
    }
    }
    private static DiscoveryNode newRemoteSearchNode(String name) {
            routingTable.index("sourceIndex").shard(0).shardId(),
                REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
        IndexMetadata indexMetadata = metadata.index("test");
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(searchNode)).build();
            true,
                REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY,
        DiscoveryNode primaryNode,
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
import java.util.Map;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            newSegmentsOnlyNode("node1"),
            newRemoteNode("node1"),
    }
        RoutingAllocation allocation = new RoutingAllocation(allocationDeciders, state.getRoutingNodes(), state, null, null, 0);
        for (Decision decision : commandsResult.explanations().explanations().get(0).decisions().getDecisions()) {
}
            Map.of(
     * asks to move the search replica to {@code targetNode} and returns the throttling decider's decision.
        clusterState = strategy.reroute(clusterState, "reroute");
import org.opensearch.cluster.routing.UnassignedInfo;
        initializePrimaryAndMarkInSync(indexMetadata.getIndex(), indexMetadataBuilder, gatewayAllocator, primaryNode);
        clusterState = strategy.reroute(clusterState, "reroute");
            false,
        // regular replicas would get promoted to primary before the CanMoveAway call.
            newSegmentsOnlyNode("node3")
            name,
            false,
            .build();
        }
                "cluster-repo",
                IndexMetadata.builder("test")
            newRemoteSearchNode("node2"),
        AllocationDeciders allocationDeciders = new AllocationDeciders(
        ShardRouting primary = ShardRouting.newUnassigned(
import java.util.Arrays;
            new BalancedShardsAllocator(Settings.EMPTY),
            .metadata(metadataBuilder.build())
        Decision decision = throttlingDecisionForSearchReplicaMoveWithoutPrimary(
        );
public class SearchReplicaAllocationDeciderTests extends OpenSearchAllocationTestCase {
     * Starts the primary on {@code primaryNode} and the search replica on {@code searchNode}, kills the primary, then
        );
        ShardRouting searchReplica = ShardRouting.newUnassigned(
 * The OpenSearch Contributors require contributions made to
            if (decision.label().equals(ThrottlingAllocationDecider.NAME)) {
        Index index,
                    .numberOfReplicas(0)
        );
        AllocationService service = new AllocationService(
package org.opensearch.cluster.routing.allocation.decider;
            routingTable.index("sourceIndex").shard(0).shardId(),
        clusterState = ClusterState.builder(clusterState)
        // remove the primary and reroute - this would throw an NPE for search replicas but *not* regular.
        // Can allocate regularReplica on data node
        DiscoveryNode primaryNode,
        // Can allocate searchReplica on search node
        AllocationService strategy = createAllocationService(Settings.EMPTY, gatewayAllocator);
                REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY,
        SearchReplicaAllocationDecider filterAllocationDecider = new SearchReplicaAllocationDecider();
import java.util.Set;
import org.opensearch.core.index.Index;
        // attempt to move the replica
                    .settings(settings(Version.CURRENT))
        ShardRouting regularReplica = ShardRouting.newUnassigned(
            ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(primaryNode.getId())).build(),
        // Cannot allocate searchReplica on data node
    }
            true,
                    .numberOfReplicas(0)
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
import org.opensearch.cluster.routing.RecoverySource;
            RecoverySource.PeerRecoverySource.INSTANCE,
    public void testSearchReplicaWithThrottlingDeciderWithoutPrimary_SegmentsOnly() {
    private static DiscoveryNode newRemoteNode(String name) {
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
    ) {
import org.opensearch.Version;
                    .numberOfShards(1)
            false
        boolean isCorrectNoDecision = false;
        // remove the primary and reroute - this would throw an NPE for search replicas but *not* regular.
        // throttle outgoing on primary
import org.opensearch.cluster.metadata.Metadata;
        decision = (Decision.Single) filterAllocationDecider.canRemain(searchReplica, state.getRoutingNodes().node("node2"), allocation);
    ) {
        decision = (Decision.Single) filterAllocationDecider.canAllocate(searchReplica, state.getRoutingNodes().node("node1"), allocation);
        );
        assertEquals(Decision.Type.YES, decision.type());
        // Can allocate primary on data node
        // Tests for canAllocate
            new AllocationCommands(new MoveAllocationCommand("test", 0, searchNode.getId(), targetNode.getId())),
            true,
        assertTrue(isCorrectNoDecision);
        );
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
    private static DiscoveryNode newSegmentsOnlyNode(String name) {
import org.opensearch.cluster.ClusterState;
            state.getRoutingNodes().node("node2"),
/*
                    .numberOfSearchReplicas(1)
    }
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            new UnassignedInfo(UnassignedInfo.Reason.NODE_LEFT, "")
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
        Decision.Single decision = (Decision.Single) filterAllocationDecider.canAllocate(
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.common.settings.ClusterSettings;
        decision = (Decision.Single) filterAllocationDecider.canRemain(primary, state.getRoutingNodes().node("node2"), allocation);
            .build();
import java.util.Collections;
            }
        decision = (Decision.Single) filterAllocationDecider.canAllocate(regularReplica, state.getRoutingNodes().node("node1"), allocation);
        ClusterState clusterState = initializeClusterStateWithSingleIndexAndShard(primaryNode, metadata, gatewayAllocator);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;
 * this file be licensed under the Apache-2.0 license or a
        return newSearchNode(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
            name,
            true,
            RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(targetNode)).build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            true,
    }
    }
import org.opensearch.cluster.node.DiscoveryNode;
            false
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
    /**
            false,
    }
        DiscoveryNode searchNode,
            new AllocationCommands(new MoveAllocationCommand("test", 0, "node2", "node3")),
            clusterState,
        gatewayAllocator.addKnownAllocation(started);
        IndexMetadata.Builder indexMetadata,
        );
import org.opensearch.cluster.routing.allocation.AllocationService;
            .build();
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.test.gateway.TestGatewayAllocator;
        DiscoveryNode primaryNode
                    .settings(settings(Version.CURRENT))
        RoutingTable routingTable = routingTableBuilder.build();
        indexMetadata.putInSyncAllocationIds(0, Collections.singleton(started.allocationId().getId()));
            }
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "")
    private ClusterState initializeClusterStateWithSingleIndexAndShard(
        );
        // attempt to move the replica
    }
            new TestGatewayAllocator(),
        );
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
            EmptySnapshotsInfoService.INSTANCE
        Metadata metadata = Metadata.builder()
     */
     */
 * compatible open source license.
            clusterState,
        return ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(
        decision = (Decision.Single) filterAllocationDecider.canAllocate(regularReplica, state.getRoutingNodes().node("node2"), allocation);
        assertEquals(2, clusterState.routingTable().shardsWithState(STARTED).size());
 *
            routingTable.index("sourceIndex").shard(0).shardId(),
import org.opensearch.common.settings.Settings;
        assertEquals(commandsResult.explanations().explanations().get(0).decisions().type(), Decision.Type.NO);
    }
    public void testSearchReplicaWithThrottlingDecider_PrimaryBasedReplication() {
 * SPDX-License-Identifier: Apache-2.0
        TestGatewayAllocator gatewayAllocator
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), settings);
        // regular replicas would get promoted to primary before the CanMoveAway call.
            ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1")).build(),
            newSegmentsOnlySearchNode("node2"),
        // start a third node, we will try and move the SR to this node
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
            new ShardId(index, 0),
    public void testSearchReplicaWithThrottlingDeciderWithoutPrimary_RemoteStoreEnabled() {
        throw new AssertionError("no " + ThrottlingAllocationDecider.NAME + " decision was returned");
            .nodes(DiscoveryNodes.builder().add(primaryNode))
        assertEquals(clusterState.getRoutingNodes().getOutgoingRecoveries(primaryNode.getId()), 0);
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "")
        Metadata metadata = Metadata.builder()
        ClusterState clusterState = initializeClusterStateWithSingleIndexAndShard(newNode("node1"), metadata, gatewayAllocator);
            RecoverySource.PeerRecoverySource.INSTANCE,
            )
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata);
                    .numberOfShards(1)
        ShardRouting started = ShardRoutingHelper.moveToStarted(ShardRoutingHelper.initialize(unassigned, primaryNode.getId()));
        TestGatewayAllocator gatewayAllocator = new TestGatewayAllocator();
    public void testSearchReplicaRoutingDedicatedIncludes() {
            allocationDeciders,
        clusterState = strategy.disassociateDeadNodes(
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
        assertEquals(decision.toString(), Decision.Type.YES, decision.type());
                return decision;
                REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY,
                IndexMetadata.builder("test")
            Arrays.asList(
            RecoverySource.PeerRecoverySource.INSTANCE,
        clusterState = strategy.reroute(clusterState, "reroute");
        // Cannot allocate regularReplica on search node
        decision = (Decision.Single) filterAllocationDecider.canAllocate(primary, state.getRoutingNodes().node("node2"), allocation);
        );
                "segment-repo",
        allocation.debugDecision(true);
            Map.of(
    ) {
        assertEquals(decision.toString(), Decision.Type.NO, decision.type());
