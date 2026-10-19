        RoutingNodes defaultRoutingNodes = clusterState.getRoutingNodes();
        // Incompatible Pools
        String remoteNodeId = remoteShard.currentNodeId();
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTable).build();
                break;
            .stream()
        assertEquals(Decision.YES.type(), deciders.canAllocate(localIdx, remoteCapableNode, globalAllocation).type());
        RoutingTable routingTable = RoutingTable.builder(clusterState.routingTable())
            if (routingNode.nodeId().startsWith(LOCAL_NODE_PREFIX)) {
package org.opensearch.cluster.routing.allocation.decider;
        }
        clusterState = allocateShardsAndBalance(clusterState, service);
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(localIdx, localOnlyNode.node(), globalAllocation).type());
            Decision.YES.type(),
import org.opensearch.cluster.routing.allocation.AllocationService;
        assertEquals(Decision.NO.type(), deciders.canAllocate(remoteShard, localOnlyNode, globalAllocation).type());
        assertEquals(Decision.NO.type(), deciders.canAllocate(remoteShard, localOnlyNode, globalAllocation).type());
            .build();
            .stream()
        );
            .stream()
        decision = targetPoolAllocationDecider.canAllocate(remoteIdx, remoteCapableNode, globalAllocation);
        );
public class TargetPoolAllocationDeciderTests extends RemoteShardsBalancerBaseTestCase {
            deciders.canForceAllocatePrimary(unassignedLocalShard, remoteCapableNode, globalAllocation).type()
import org.opensearch.cluster.routing.allocation.RemoteShardsBalancerBaseTestCase;
            .stream()
            .allShards(getIndexName(0, false))
        assertEquals("Routing pools are incompatible. Index pool: [REMOTE_CAPABLE], node pool: [LOCAL_ONLY]", decision.getExplanation());
        ShardRouting localShard = clusterState.routingTable()
        AllocationDeciders deciders = new AllocationDeciders(Collections.singletonList(new TargetPoolAllocationDecider()));
 * this file be licensed under the Apache-2.0 license or a
            .filter(ShardRouting::primary)
    public void testTargetPoolHybridAllocationDecisions() {
        // Compatible Pools
        String localNodeId = LOCAL_NODE_PREFIX;
        ShardRouting unassignedRemoteShard = clusterState.routingTable()
        clusterState = createRemoteIndex(clusterState, "test_remote_unassigned");
        // Verify only compatible nodes are used for auto expand replica decision for remote index and local index
 * SPDX-License-Identifier: Apache-2.0
            .collect(Collectors.toList())
            .stream()
        IndexMetadata localIdx = globalAllocation.metadata().getIndexSafe(localShard.index());
        ShardRouting remoteShard = clusterState.routingTable()
        assertEquals(Decision.YES.type(), deciders.canAllocate(localIdx, localOnlyNode, globalAllocation).type());
            .filter(ShardRouting::primary)
            .filter(ShardRouting::primary)
            .filter(ShardRouting::primary)
        ShardRouting localShard = clusterState.routingTable()
        assertEquals("Routing pools are compatible. Shard pool: [REMOTE_CAPABLE], node pool: [REMOTE_CAPABLE]", decision.getExplanation());
            .collect(Collectors.toList())
import org.opensearch.cluster.routing.RoutingNode;
            .get(0);
        // Add remote index unassigned primary
            decision.getExplanation()
        String remoteNodeId = remoteShard.currentNodeId();
            }
        RoutingNode remoteCapableNode = defaultRoutingNodes.node(remoteNodeId);
        for (RoutingNode routingNode : globalAllocation.routingNodes()) {
/*
        AllocationService service = this.createRemoteCapableAllocationService();
            .collect(Collectors.toList())
            Decision.YES.type(),
        // Verify only remote nodes are used for auto expand replica decision for remote index
            .build();
            .allShards("test_remote_unassigned")
 */
            .get(0);
        assertEquals(Decision.NO.type(), deciders.canAllocate(remoteIdx, localOnlyNode, globalAllocation).type());
            .get(0);
            .build();
        ShardRouting unassignedLocalShard = clusterState.routingTable()
        AllocationService service = this.createRemoteCapableAllocationService();
        decision = targetPoolAllocationDecider.canAllocate(remoteShard, remoteCapableNode, globalAllocation);
            .collect(Collectors.toList())
import org.opensearch.cluster.ClusterState;
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTable).build();
            .stream()
        AllocationDeciders deciders = new AllocationDeciders(Collections.singletonList(new TargetPoolAllocationDecider()));
        IndexMetadata remoteIdx = globalAllocation.metadata().getIndexSafe(remoteShard.index());
        ClusterState clusterState = createInitialCluster(3, 3, 2, 2);
    public void testDebugMessage() {
            .collect(Collectors.toList())
        assertEquals(
        // Add an unassigned primary shard for force allocation checks
    }
            "Routing pools are incompatible. Index pool: [LOCAL_ONLY], node pool: [REMOTE_CAPABLE] without [data] role",
        assertEquals(Decision.YES.type(), deciders.canAllocate(remoteShard, remoteCapableNode, globalAllocation).type());
                localNodeId = routingNode.nodeId();
        assertEquals(Decision.YES.type(), deciders.canAllocate(localShard, localOnlyNode, globalAllocation).type());
}
        assertEquals("Routing pools are incompatible. Shard pool: [REMOTE_CAPABLE], node pool: [LOCAL_ONLY]", decision.getExplanation());
            }
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(localIdx, remoteCapableNode.node(), globalAllocation).type());
            .addAsNew(metadata.index("test_local_unassigned"))
            .filter(ShardRouting::primary)
        ShardRouting remoteShard = clusterState.routingTable()
            .get(0);
            if (routingNode.nodeId().startsWith(LOCAL_NODE_PREFIX)) {
        );
import org.opensearch.Version;
        decision = targetPoolAllocationDecider.canAllocate(remoteIdx, localOnlyNode, globalAllocation);
                localNodeId = routingNode.nodeId();
        // Add an unassigned primary shard for force allocation checks
        ShardRouting unassignedRemoteShard = clusterState.routingTable()
            .allShards(getIndexName(0, false))
            "Routing pools are incompatible. Shard pool: [LOCAL_ONLY], node pool: [REMOTE_CAPABLE] without [data] role",
            .put(IndexMetadata.builder("test_local_unassigned").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .get(0);
        AllocationService service = this.createRemoteCapableAllocationService();
        assertEquals(Decision.NO.type(), deciders.canAllocate(remoteIdx, localOnlyNode, globalAllocation).type());
        clusterState = allocateShardsAndBalance(clusterState, service);
        assertEquals(Decision.YES.type(), deciders.canForceAllocatePrimary(unassignedLocalShard, localOnlyNode, globalAllocation).type());
            .build();
        Decision decision = targetPoolAllocationDecider.canAllocate(localShard, remoteCapableNode, globalAllocation);
        RoutingTable routingTable = RoutingTable.builder(clusterState.routingTable())
            .build();
            .collect(Collectors.toList())
        globalAllocation.setDebugMode(RoutingAllocation.DebugMode.ON);
        assertEquals(Decision.YES.type(), deciders.canForceAllocatePrimary(unassignedLocalShard, localOnlyNode, globalAllocation).type());
            .collect(Collectors.toList())
        RoutingAllocation globalAllocation = getRoutingAllocation(clusterState, defaultRoutingNodes);
            .allShards(getIndexName(0, true))
            .allShards(getIndexName(0, true))
            .filter(ShardRouting::primary)
        RoutingNode remoteCapableNode = defaultRoutingNodes.node(remoteNodeId);
        String localNodeId = LOCAL_NODE_PREFIX;
        IndexMetadata localIdx = globalAllocation.metadata().getIndexSafe(localShard.index());
        ShardRouting localShard = clusterState.routingTable()
    }
            .stream()
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTable).build();
        RoutingNode localOnlyNode = defaultRoutingNodes.node(localNodeId);
        ShardRouting unassignedLocalShard = clusterState.routingTable()
        assertEquals(Decision.YES.type(), deciders.canAllocate(remoteIdx, remoteCapableNode, globalAllocation).type());
        RoutingAllocation globalAllocation = getRoutingAllocation(clusterState, defaultRoutingNodes);
            Decision.NO.type(),
        );
        assertEquals(Decision.NO.type(), deciders.canForceAllocatePrimary(unassignedRemoteShard, localOnlyNode, globalAllocation).type());
            .filter(ShardRouting::primary)
            .collect(Collectors.toList())
 * The OpenSearch Contributors require contributions made to
            .put(IndexMetadata.builder("test_local_unassigned").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertEquals(Decision.NO.type(), deciders.canAllocate(localShard, remoteCapableNode, globalAllocation).type());
        RoutingTable routingTable = RoutingTable.builder(clusterState.routingTable())
        assertEquals(
        clusterState = createRemoteIndex(clusterState, "test_remote_unassigned");
                break;
            .stream()
        IndexMetadata remoteIdx = globalAllocation.metadata().getIndexSafe(remoteShard.index());
            .get(0);
            .addAsNew(metadata.index("test_local_unassigned"))
        assertEquals("Routing pools are compatible. Index pool: [REMOTE_CAPABLE], node pool: [REMOTE_CAPABLE]", decision.getExplanation());
            .allShards(getIndexName(0, false))
 *
            .stream()
            .addAsNew(metadata.index("test_local_unassigned"))
        assertEquals(Decision.YES.type(), deciders.canAllocate(remoteShard, remoteCapableNode, globalAllocation).type());
        // A dedicated warm node should not accept local shards and indices.
        // Add remote index unassigned primary
            .allShards("test_local_unassigned")
                break;
            .allShards("test_local_unassigned")
            .filter(ShardRouting::primary)
        // Compatible Pools
            .get(0);
        Metadata metadata = Metadata.builder(clusterState.metadata())
            Decision.YES.type(),
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(localIdx, localOnlyNode.node(), globalAllocation).type());
import java.util.Collections;
 * compatible open source license.
        Metadata metadata = Metadata.builder(clusterState.metadata())
import org.opensearch.cluster.metadata.Metadata;
            .filter(ShardRouting::primary)
        ShardRouting remoteShard = clusterState.routingTable()
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(remoteIdx, remoteCapableNode.node(), globalAllocation).type());
        assertEquals(Decision.YES.type(), deciders.canAllocate(localIdx, localOnlyNode, globalAllocation).type());
        assertEquals(Decision.YES.type(), deciders.canAllocate(localShard, remoteCapableNode, globalAllocation).type());
        Metadata metadata = Metadata.builder(clusterState.metadata())
            .get(0);
    }
        RoutingNode localOnlyNode = defaultRoutingNodes.node(localNodeId);
            .filter(ShardRouting::primary)
            .allShards(getIndexName(0, true))
            .get(0);
        );
        }
        assertEquals(Decision.NO.type(), deciders.shouldAutoExpandToNode(remoteIdx, localOnlyNode.node(), globalAllocation).type());
        IndexMetadata remoteIdx = globalAllocation.metadata().getIndexSafe(remoteShard.index());
            .collect(Collectors.toList())
        assertEquals(
            deciders.canForceAllocatePrimary(unassignedRemoteShard, remoteCapableNode, globalAllocation).type()
            .allShards("test_local_unassigned")
            .collect(Collectors.toList())
            .allShards("test_remote_unassigned")
        IndexMetadata localIdx = globalAllocation.metadata().getIndexSafe(localShard.index());
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        RoutingNode remoteCapableNode = defaultRoutingNodes.node(remoteNodeId);
        assertEquals(
        for (RoutingNode routingNode : globalAllocation.routingNodes()) {
        assertEquals(Decision.NO.type(), deciders.shouldAutoExpandToNode(remoteIdx, localOnlyNode.node(), globalAllocation).type());
        assertEquals(
            .get(0);
        clusterState = allocateShardsAndBalance(clusterState, service);
            .stream()
            .collect(Collectors.toList())
        assertEquals(Decision.YES.type(), deciders.canAllocate(remoteIdx, remoteCapableNode, globalAllocation).type());
            .get(0);
            .filter(ShardRouting::primary)
import org.opensearch.cluster.routing.RoutingNodes;
        String remoteNodeId = remoteShard.currentNodeId();
        assertEquals(Decision.NO.type(), deciders.shouldAutoExpandToNode(localIdx, remoteCapableNode.node(), globalAllocation).type());
        ShardRouting unassignedRemoteShard = clusterState.routingTable()
        String localNodeId = LOCAL_NODE_PREFIX;
        ClusterState clusterState = createInitialCluster(3, 3, true, 2, 2, false);
        for (RoutingNode routingNode : globalAllocation.routingNodes()) {
        assertEquals(Decision.YES.type(), deciders.canAllocate(localShard, localOnlyNode, globalAllocation).type());
        decision = targetPoolAllocationDecider.canAllocate(remoteShard, localOnlyNode, globalAllocation);
        }
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.RoutingTable;
        );
            if (routingNode.nodeId().startsWith(LOCAL_NODE_PREFIX)) {
        // Add remote index unassigned primary
        TargetPoolAllocationDecider targetPoolAllocationDecider = new TargetPoolAllocationDecider();
                localNodeId = routingNode.nodeId();
        ClusterState clusterState = createInitialCluster(3, 3, true, 2, 2, false);
        RoutingNodes defaultRoutingNodes = clusterState.getRoutingNodes();
        RoutingAllocation globalAllocation = getRoutingAllocation(clusterState, defaultRoutingNodes);
        ShardRouting unassignedLocalShard = clusterState.routingTable()
        decision = targetPoolAllocationDecider.canAllocate(localIdx, remoteCapableNode, globalAllocation);
            deciders.canForceAllocatePrimary(unassignedLocalShard, remoteCapableNode, globalAllocation).type()
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(remoteIdx, remoteCapableNode.node(), globalAllocation).type());
        assertEquals(Decision.NO.type(), deciders.canForceAllocatePrimary(unassignedRemoteShard, localOnlyNode, globalAllocation).type());
        assertEquals(
            .stream()
            .get(0);
            .collect(Collectors.toList())
        assertEquals(Decision.NO.type(), deciders.canAllocate(localIdx, remoteCapableNode, globalAllocation).type());
            .put(IndexMetadata.builder("test_local_unassigned").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .allShards("test_remote_unassigned")
        RoutingNodes defaultRoutingNodes = clusterState.getRoutingNodes();
        // Incompatible Pools
            decision.getExplanation()
import org.opensearch.cluster.metadata.IndexMetadata;
        // Add an unassigned primary shard for force allocation checks
            }
            .build();
            deciders.canForceAllocatePrimary(unassignedRemoteShard, remoteCapableNode, globalAllocation).type()
        clusterState = createRemoteIndex(clusterState, "test_remote_unassigned");
            .filter(ShardRouting::primary)
import java.util.stream.Collectors;
        RoutingNode localOnlyNode = defaultRoutingNodes.node(localNodeId);
    public void testTargetPoolDedicatedSearchNodeAllocationDecisions() {
            .stream()
