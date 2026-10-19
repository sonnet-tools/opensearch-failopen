     * Test remote unassigned shard allocation when remote capable nodes fail to come up.  
        assertEquals(0, routingNodes.unassigned().size());
        }
import org.opensearch.cluster.routing.RoutingNode;
                nodePrimariesCounter.compute(node.nodeId(), (k, v) -> (v == null) ? 1 : v + 1);  
            RemoteShardsBalancer.UnassignedIndexShards indexShards = unassignedShardMap.get(index);  
        int localOnlyNodes = 7;
        assertEquals(totalShards(remoteIndices), routingNodes.unassigned().size());  
            } else {  
            if (RoutingPool.getShardPool(shard, allocation) == RoutingPool.REMOTE_CAPABLE) {  
     */
 * this file be licensed under the Apache-2.0 license or a
        }  
                assertEquals(RoutingPool.LOCAL_ONLY, RoutingPool.getNodePool(node));  
 * compatible open source license.
        Map<String, RemoteShardsBalancer.UnassignedIndexShards> unassignedShardMap = remoteShardsBalancer.groupUnassignedShardsByIndex();
import static org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED;
        final boolean throttle = randomBoolean();  
        for (int primaries : nodePrimariesCounter.values()) {
import java.util.Map;
            }
            assertEquals(5, indexShards.getReplicas().size());  
                } else {
            RoutingPool nodePool = RoutingPool.getNodePool(node);
 *
            if (RoutingPool.getShardPool(shard, allocation) == RoutingPool.REMOTE_CAPABLE) {
        clusterState = allocateShardsAndBalance(clusterState, service);  
        final int remoteCapableNodes = 5;
                assertFalse(shard.primary());
    }
        int localIndices = 10;  
            for (ShardRouting shard : indexShards.getPrimaries()) {
                }
                assertEquals(shard.getIndexName(), index);  
        int remoteCapableNodes = 3;
    /**  
            assertFalse(shard.unassigned());
        }
        assertEquals(totalShards(remoteIndices), routingNodes.unassigned().size());
            }  
 */  
        final int remoteIndices = 1;
     * Test remote unassigned shard allocation when deciders make NO or THROTTLED decision.
                assertEquals(0, node.size());
            if (RoutingPool.REMOTE_CAPABLE.equals(shardPool)) {  
        RemoteShardsBalancer remoteShardsBalancer = new RemoteShardsBalancer(logger, allocation);  
public class RemoteShardsAllocateUnassignedTests extends RemoteShardsBalancerBaseTestCase {
        RoutingNodes routingNodes = new RoutingNodes(clusterState, false);  
                RoutingNode node = routingNodes.node(shard.currentNodeId());
        for (RoutingNode node : routingNodes) {  
        for (ShardRouting shard : newState.getRoutingTable().allShards()) {
                    assertEquals(NO_ATTEMPT, shard.unassignedInfo().getLastAllocationStatus());  
        AllocationService service = this.createRemoteCapableAllocationService();
    public void testNoRemoteAllocation() {  
        assertEquals(remoteIndices, unassignedShardMap.size());  
        final ClusterState newState = allocateShardsAndBalance(oldState, service);
    public void testInit() {  
        int remoteCapableNodes = 0;
                && shard.primary()) {
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        final Map<String, Integer> nodePrimariesCounter = new HashMap<>();  
        int localOnlyNodes = 7;  
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {  
        }
                assertFalse(shard.unassigned());  
                assertEquals(nodePool, shardPool);
    }  
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
            }
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
            for (ShardRouting shard : indexShards.getReplicas()) {
        int localOnlyNodes = 7;  
import static org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus.NO_ATTEMPT;
            }
import static org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus.DECIDERS_NO;  
                assertEquals(shard.getIndexName(), index);
        final RoutingNodes routingNodes = newState.getRoutingNodes();  
        final int localIndices = 2;  
        int localIndices = 10;
                if (shard.primary()) {
            RoutingNode node = routingNodes.node(shard.currentNodeId());  
        }
    public void testPrimaryAllocation() {
            assertTrue(index.startsWith(REMOTE_IDX_PREFIX));
     */
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
import org.opensearch.cluster.routing.allocation.allocator.RemoteShardsBalancer;
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
    public void testAllocationRemoteCapableNodesUnavailable() {
import org.opensearch.cluster.routing.ShardRouting;
    /**  
        final ClusterState oldState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
        clusterState = allocateShardsAndBalance(clusterState, service);  
            }
     * Test Remote Shards Balancer initialization.
    /**
                && RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation))
                assertTrue(shard.unassigned());
        final int indexShardLimit = (int) Math.ceil(totalPrimaries(remoteIndices) / (float) remoteCapableNodes);  
import org.opensearch.cluster.ClusterState;
        int remoteIndices = 13;  
    }  
import org.opensearch.cluster.routing.RoutingPool;
        int remoteIndices = 13;  
/*  
        final int localOnlyNodes = 10;
            } else {
            assertEquals(5, indexShards.getPrimaries().size());
                    final UnassignedInfo.AllocationStatus expect = throttle ? DECIDERS_THROTTLED : DECIDERS_NO;  
 * The OpenSearch Contributors require contributions made to  
            if (RoutingPool.getNodePool(node) == RoutingPool.REMOTE_CAPABLE  
        int remoteIndices = 15;
            }
package org.opensearch.cluster.routing.allocation;
            if (RoutingPool.getNodePool(node) == RoutingPool.REMOTE_CAPABLE) {
                    assertEquals(expect, shard.unassignedInfo().getLastAllocationStatus());
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
    /**
import org.opensearch.cluster.routing.RoutingNodes;  
 * SPDX-License-Identifier: Apache-2.0
                assertTrue(shard.primary());  
        AllocationService service = this.createRemoteCapableAllocationService();
     */
        int remoteCapableNodes = 3;
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
        final AllocationService service = this.createRejectRemoteAllocationService(throttle);
        for (String index : unassignedShardMap.keySet()) {
import org.opensearch.cluster.routing.UnassignedInfo;  
        }
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
            assertTrue(primaries <= indexShardLimit);
}  
     * Test remote unassigned shard allocation for standard new cluster setup.  
    }
                assertTrue(shard.unassigned());
                assertFalse(shard.unassigned());
        int localIndices = 10;
        final RoutingAllocation allocation = getRoutingAllocation(newState, routingNodes);
import java.util.HashMap;  
            }
     */
