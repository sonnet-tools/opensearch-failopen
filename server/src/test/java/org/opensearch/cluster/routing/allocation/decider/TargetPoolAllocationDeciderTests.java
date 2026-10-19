            .stream()
            .allShards(getIndexName(0, true))
        assertEquals(
            decision.getExplanation()
        TargetPoolAllocationDecider targetPoolAllocationDecider = new TargetPoolAllocationDecider();  
import org.opensearch.cluster.metadata.Metadata;
        RoutingTable routingTable = RoutingTable.builder(clusterState.routingTable())
        String localNodeId = LOCAL_NODE_PREFIX;
        // Add remote index unassigned primary
        decision = targetPoolAllocationDecider.canAllocate(remoteIdx, localOnlyNode, globalAllocation);
            .filter(ShardRouting::primary)
            .collect(Collectors.toList())
            .allShards("test_remote_unassigned")  
            deciders.canForceAllocatePrimary(unassignedLocalShard, remoteCapableNode, globalAllocation).type()
        AllocationService service = this.createRemoteCapableAllocationService();
        IndexMetadata remoteIdx = globalAllocation.metadata().getIndexSafe(remoteShard.index());  
        // Add an unassigned primary shard for force allocation checks
            .filter(ShardRouting::primary)
            .stream()  
        assertEquals("Routing pools are incompatible. Shard pool: [REMOTE_CAPABLE], node pool: [LOCAL_ONLY]", decision.getExplanation());
        assertEquals(Decision.NO.type(), deciders.canAllocate(localIdx, remoteCapableNode, globalAllocation).type());
            .build();
        assertEquals(
import org.opensearch.Version;
        IndexMetadata localIdx = globalAllocation.metadata().getIndexSafe(localShard.index());
        ShardRouting localShard = clusterState.routingTable()
        );
            .stream()
        }
        assertEquals(Decision.NO.type(), deciders.shouldAutoExpandToNode(remoteIdx, localOnlyNode.node(), globalAllocation).type());
            .filter(ShardRouting::primary)
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(localIdx, remoteCapableNode.node(), globalAllocation).type());  
            .filter(ShardRouting::primary)
import org.opensearch.cluster.routing.ShardRouting;
            .allShards("test_local_unassigned")  
        ShardRouting remoteShard = clusterState.routingTable()
            .stream()
            .collect(Collectors.toList())  
    public void testTargetPoolHybridAllocationDecisions() {
 *
            decision.getExplanation()
        RoutingTable routingTable = RoutingTable.builder(clusterState.routingTable())  
        Metadata metadata = Metadata.builder(clusterState.metadata())
    }  
        RoutingAllocation globalAllocation = getRoutingAllocation(clusterState, defaultRoutingNodes);
import org.opensearch.cluster.metadata.IndexMetadata;  
        RoutingNode remoteCapableNode = defaultRoutingNodes.node(remoteNodeId);  
        decision = targetPoolAllocationDecider.canAllocate(remoteIdx, remoteCapableNode, globalAllocation);
        assertEquals("Routing pools are compatible. Index pool: [REMOTE_CAPABLE], node pool: [REMOTE_CAPABLE]", decision.getExplanation());
        assertEquals(Decision.YES.type(), deciders.canForceAllocatePrimary(unassignedLocalShard, localOnlyNode, globalAllocation).type());
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
            }  
        assertEquals(  
            if (routingNode.nodeId().startsWith(LOCAL_NODE_PREFIX)) {  
            Decision.YES.type(),
        assertEquals(Decision.YES.type(), deciders.canAllocate(localIdx, localOnlyNode, globalAllocation).type());  
        ClusterState clusterState = createInitialCluster(3, 3, 2, 2);  
        RoutingNodes defaultRoutingNodes = clusterState.getRoutingNodes();
            .allShards(getIndexName(0, true))  
}
                break;
        AllocationService service = this.createRemoteCapableAllocationService();
            .stream()
            .collect(Collectors.toList())  
            .stream()  
        String remoteNodeId = remoteShard.currentNodeId();
            .get(0);
        assertEquals(
import org.opensearch.cluster.routing.RoutingTable;
        assertEquals(Decision.NO.type(), deciders.canAllocate(remoteIdx, localOnlyNode, globalAllocation).type());  
        assertEquals(
            .get(0);  
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTable).build();  
            .filter(ShardRouting::primary)
        );  
        IndexMetadata remoteIdx = globalAllocation.metadata().getIndexSafe(remoteShard.index());  
                localNodeId = routingNode.nodeId();
            .collect(Collectors.toList())  
        decision = targetPoolAllocationDecider.canAllocate(remoteShard, localOnlyNode, globalAllocation);
        assertEquals(Decision.YES.type(), deciders.canAllocate(localShard, localOnlyNode, globalAllocation).type());
        String localNodeId = LOCAL_NODE_PREFIX;  
        ShardRouting unassignedLocalShard = clusterState.routingTable()
        // Add an unassigned primary shard for force allocation checks
        ClusterState clusterState = createInitialCluster(3, 3, true, 2, 2, false);  
        String localNodeId = LOCAL_NODE_PREFIX;
        globalAllocation.setDebugMode(RoutingAllocation.DebugMode.ON);  
            .collect(Collectors.toList())  
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTable).build();
        ShardRouting remoteShard = clusterState.routingTable()
            .get(0);  
public class TargetPoolAllocationDeciderTests extends RemoteShardsBalancerBaseTestCase {
            .build();
            .get(0);
            Decision.NO.type(),
        clusterState = allocateShardsAndBalance(clusterState, service);
        RoutingNode remoteCapableNode = defaultRoutingNodes.node(remoteNodeId);
            .allShards("test_remote_unassigned")
        clusterState = allocateShardsAndBalance(clusterState, service);
            .get(0);
            .stream()
            .filter(ShardRouting::primary)
                localNodeId = routingNode.nodeId();
        // Compatible Pools  
        );  
            .get(0);
            .stream()
            Decision.YES.type(),
            .build();
        RoutingNode localOnlyNode = defaultRoutingNodes.node(localNodeId);  
            .stream()  
        // A dedicated warm node should not accept local shards and indices.  
            deciders.canForceAllocatePrimary(unassignedRemoteShard, remoteCapableNode, globalAllocation).type()  
        Decision decision = targetPoolAllocationDecider.canAllocate(localShard, remoteCapableNode, globalAllocation);
        ShardRouting unassignedRemoteShard = clusterState.routingTable()
            .get(0);
            .collect(Collectors.toList())
        // Compatible Pools
        );
            deciders.canForceAllocatePrimary(unassignedRemoteShard, remoteCapableNode, globalAllocation).type()  
        // Incompatible Pools
        assertEquals(Decision.YES.type(), deciders.canAllocate(localShard, localOnlyNode, globalAllocation).type());
        RoutingTable routingTable = RoutingTable.builder(clusterState.routingTable())
            .filter(ShardRouting::primary)
            .stream()
        for (RoutingNode routingNode : globalAllocation.routingNodes()) {
        assertEquals("Routing pools are incompatible. Index pool: [REMOTE_CAPABLE], node pool: [LOCAL_ONLY]", decision.getExplanation());
        assertEquals(Decision.YES.type(), deciders.canAllocate(localIdx, remoteCapableNode, globalAllocation).type());
        Metadata metadata = Metadata.builder(clusterState.metadata())
        String remoteNodeId = remoteShard.currentNodeId();
        IndexMetadata localIdx = globalAllocation.metadata().getIndexSafe(localShard.index());
        AllocationDeciders deciders = new AllocationDeciders(Collections.singletonList(new TargetPoolAllocationDecider()));
        RoutingNode localOnlyNode = defaultRoutingNodes.node(localNodeId);
            deciders.canForceAllocatePrimary(unassignedLocalShard, remoteCapableNode, globalAllocation).type()
            "Routing pools are incompatible. Index pool: [LOCAL_ONLY], node pool: [REMOTE_CAPABLE] without [data] role",  
            .collect(Collectors.toList())  
        assertEquals(Decision.NO.type(), deciders.canForceAllocatePrimary(unassignedRemoteShard, localOnlyNode, globalAllocation).type());
            .filter(ShardRouting::primary)
        clusterState = createRemoteIndex(clusterState, "test_remote_unassigned");
        assertEquals(Decision.YES.type(), deciders.canAllocate(remoteIdx, remoteCapableNode, globalAllocation).type());
        assertEquals(Decision.YES.type(), deciders.canAllocate(remoteIdx, remoteCapableNode, globalAllocation).type());
            .get(0);  
            .get(0);
        clusterState = allocateShardsAndBalance(clusterState, service);  
        // Verify only compatible nodes are used for auto expand replica decision for remote index and local index
        // Add remote index unassigned primary
            .addAsNew(metadata.index("test_local_unassigned"))  
import org.opensearch.cluster.ClusterState;
        decision = targetPoolAllocationDecider.canAllocate(localIdx, remoteCapableNode, globalAllocation);
            .addAsNew(metadata.index("test_local_unassigned"))
import org.opensearch.cluster.routing.RoutingNodes;  
                break;
import org.opensearch.cluster.routing.allocation.RemoteShardsBalancerBaseTestCase;
            .build();
        assertEquals(Decision.NO.type(), deciders.canAllocate(localShard, remoteCapableNode, globalAllocation).type());
            .collect(Collectors.toList())  
            .stream()
            .filter(ShardRouting::primary)
        // Verify only remote nodes are used for auto expand replica decision for remote index
            .collect(Collectors.toList())
            .stream()  
            .put(IndexMetadata.builder("test_local_unassigned").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
package org.opensearch.cluster.routing.allocation.decider;
            .allShards(getIndexName(0, false))  
        assertEquals(Decision.NO.type(), deciders.canAllocate(remoteShard, localOnlyNode, globalAllocation).type());
import org.opensearch.cluster.routing.RoutingNode;
        ShardRouting unassignedRemoteShard = clusterState.routingTable()
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(localIdx, localOnlyNode.node(), globalAllocation).type());
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(localIdx, localOnlyNode.node(), globalAllocation).type());
        ClusterState clusterState = createInitialCluster(3, 3, true, 2, 2, false);
        // Add remote index unassigned primary
import java.util.stream.Collectors;
            Decision.YES.type(),
        // Incompatible Pools
        RoutingNodes defaultRoutingNodes = clusterState.getRoutingNodes();
        RoutingAllocation globalAllocation = getRoutingAllocation(clusterState, defaultRoutingNodes);
            }  
            .build();
    }
        assertEquals("Routing pools are compatible. Shard pool: [REMOTE_CAPABLE], node pool: [REMOTE_CAPABLE]", decision.getExplanation());
        assertEquals(Decision.YES.type(), deciders.canForceAllocatePrimary(unassignedLocalShard, localOnlyNode, globalAllocation).type());
        decision = targetPoolAllocationDecider.canAllocate(remoteShard, remoteCapableNode, globalAllocation);
        ShardRouting localShard = clusterState.routingTable()
        clusterState = createRemoteIndex(clusterState, "test_remote_unassigned");
/*  
        assertEquals(Decision.YES.type(), deciders.canAllocate(remoteShard, remoteCapableNode, globalAllocation).type());  
            .filter(ShardRouting::primary)
        ShardRouting unassignedRemoteShard = clusterState.routingTable()
        assertEquals(Decision.NO.type(), deciders.canAllocate(remoteIdx, localOnlyNode, globalAllocation).type());
        assertEquals(Decision.NO.type(), deciders.canForceAllocatePrimary(unassignedRemoteShard, localOnlyNode, globalAllocation).type());
        assertEquals(Decision.NO.type(), deciders.shouldAutoExpandToNode(remoteIdx, localOnlyNode.node(), globalAllocation).type());  
            .filter(ShardRouting::primary)
        String remoteNodeId = remoteShard.currentNodeId();
            .allShards("test_local_unassigned")
            .addAsNew(metadata.index("test_local_unassigned"))  
import org.opensearch.cluster.routing.allocation.AllocationService;  
        assertEquals(  
        Metadata metadata = Metadata.builder(clusterState.metadata())  
                localNodeId = routingNode.nodeId();  
            "Routing pools are incompatible. Shard pool: [LOCAL_ONLY], node pool: [REMOTE_CAPABLE] without [data] role",  
        ShardRouting remoteShard = clusterState.routingTable()
        RoutingAllocation globalAllocation = getRoutingAllocation(clusterState, defaultRoutingNodes);  
        // Add an unassigned primary shard for force allocation checks
    }  
 * this file be licensed under the Apache-2.0 license or a
            .get(0);
    public void testTargetPoolDedicatedSearchNodeAllocationDecisions() {  
            .filter(ShardRouting::primary)
            .allShards(getIndexName(0, false))
            .allShards(getIndexName(0, false))  
        assertEquals(Decision.YES.type(), deciders.canAllocate(localIdx, localOnlyNode, globalAllocation).type());  
        assertEquals(Decision.NO.type(), deciders.shouldAutoExpandToNode(localIdx, remoteCapableNode.node(), globalAllocation).type());
        RoutingNode remoteCapableNode = defaultRoutingNodes.node(remoteNodeId);
            .put(IndexMetadata.builder("test_local_unassigned").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            if (routingNode.nodeId().startsWith(LOCAL_NODE_PREFIX)) {  
            .put(IndexMetadata.builder("test_local_unassigned").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
            .build();
        assertEquals(Decision.NO.type(), deciders.canAllocate(remoteShard, localOnlyNode, globalAllocation).type());  
 */  
        assertEquals(Decision.YES.type(), deciders.canAllocate(localShard, remoteCapableNode, globalAllocation).type());
        }
            .allShards("test_remote_unassigned")  
            if (routingNode.nodeId().startsWith(LOCAL_NODE_PREFIX)) {
        clusterState = createRemoteIndex(clusterState, "test_remote_unassigned");  
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTable).build();
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(remoteIdx, remoteCapableNode.node(), globalAllocation).type());  
        assertEquals(Decision.YES.type(), deciders.shouldAutoExpandToNode(remoteIdx, remoteCapableNode.node(), globalAllocation).type());
        ShardRouting localShard = clusterState.routingTable()
    public void testDebugMessage() {
            .collect(Collectors.toList())  
            .get(0);  
        for (RoutingNode routingNode : globalAllocation.routingNodes()) {
        AllocationDeciders deciders = new AllocationDeciders(Collections.singletonList(new TargetPoolAllocationDecider()));  
        IndexMetadata remoteIdx = globalAllocation.metadata().getIndexSafe(remoteShard.index());
        AllocationService service = this.createRemoteCapableAllocationService();
                break;
        for (RoutingNode routingNode : globalAllocation.routingNodes()) {
        ShardRouting unassignedLocalShard = clusterState.routingTable()
        assertEquals(Decision.YES.type(), deciders.canAllocate(remoteShard, remoteCapableNode, globalAllocation).type());  
            .allShards(getIndexName(0, true))  
            .allShards("test_local_unassigned")  
import java.util.Collections;
            .collect(Collectors.toList())  
            .collect(Collectors.toList())
        }  
        IndexMetadata localIdx = globalAllocation.metadata().getIndexSafe(localShard.index());
 * compatible open source license.
        ShardRouting unassignedLocalShard = clusterState.routingTable()
        );
        );
            }
            .get(0);
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        RoutingNode localOnlyNode = defaultRoutingNodes.node(localNodeId);  
        RoutingNodes defaultRoutingNodes = clusterState.getRoutingNodes();
