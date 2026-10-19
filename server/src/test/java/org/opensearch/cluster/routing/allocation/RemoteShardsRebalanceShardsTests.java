            }
                    assertEquals(0, (int) nodePrimariesCounter.getOrDefault(node.nodeId(), 0));
            if (i != (remoteCapableNodes / 2 - 1)) {  
        }
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
        service = this.createRemoteCapableAllocationService();
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
        RoutingAllocation allocation,  
        final StringBuilder excludeNodes = new StringBuilder();  
        }  
 *
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
                    assertEquals(avgPrimariesPerNode * 2, (int) nodePrimariesCounter.get(node.nodeId()));
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getNodePool(node))) {  
import org.opensearch.cluster.routing.RoutingNodes;  
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
 * The OpenSearch Contributors require contributions made to  
        AllocationService service = this.createRemoteCapableAllocationService(excludeNodes.toString());
        return nodePrimariesCounter;  
                assertEquals(avgPrimariesPerNode, (int) nodePrimariesCounter.get(node.nodeId()));
import org.opensearch.cluster.routing.RoutingPool;
        // Remove exclude constraint and rebalance
        final int remoteCapableNodes = 40;
import org.opensearch.cluster.ClusterState;
    private int getTotalShardCountAcrossNodes(final Map<String, Integer> nodePrimariesCounter) {  
 * this file be licensed under the Apache-2.0 license or a
        final int localOnlyNodes = 20;  
     * Test remote shard allocation and balancing for standard new cluster setup.
        }
            }
 * SPDX-License-Identifier: Apache-2.0
        final int localIndices = 40;  
 */  
}
    ) {
import java.util.Map;
public class RemoteShardsRebalanceShardsTests extends RemoteShardsBalancerBaseTestCase {
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getNodePool(node))) {  
                assertTrue(nodeReplicaCounter.getOrDefault(node.nodeId(), 0) >= 0);  
 * compatible open source license.
        for (int i = 0; i < halfRemoteCapableNodes; i++) {
                nodePrimariesCounter.compute(shard.currentNodeId(), (k, v) -> (v == null) ? 1 : v + 1);  
            }  
                excludeNodes.append(", ");
/*  
        final Map<String, Integer> nodePrimariesCounter = new HashMap<>();  
import org.opensearch.cluster.routing.RoutingNode;
    /**  
        }
                assertTrue(nodeReplicaCounter.getOrDefault(node.nodeId(), 0) >= 0);
        boolean primary
                } else {  
        clusterState = allocateShardsAndBalance(clusterState, service);
        clusterState = allocateShardsAndBalance(clusterState, service);  
import java.util.HashMap;
        Map<String, Integer> nodeReplicaCounter = getShardCounterPerNodeForRemoteCapablePool(clusterState, allocation, false);
        routingNodes = clusterState.getRoutingNodes();
import org.opensearch.cluster.routing.ShardRouting;
        int avgPrimariesPerNode = getTotalShardCountAcrossNodes(nodePrimariesCounter) / remoteCapableNodes;
        final int remoteIndices = 80;
            if (RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation)) && shard.primary() == primary) {
    private Map<String, Integer> getShardCounterPerNodeForRemoteCapablePool(
        for (RoutingNode node : routingNodes) {
     * <p>
    }
            excludeNodes.append(getNodeId(i, true));
        allocation = getRoutingAllocation(clusterState, routingNodes);
            totalShardCount += value;  
        // Primary and replica are balanced after first allocating unassigned
     */
        int totalShardCount = 0;
    }
package org.opensearch.cluster.routing.allocation;
        }
        for (int value : nodePrimariesCounter.values()) {
    public void testShardAllocationAndRebalance() {
        return totalShardCount;
        nodePrimariesCounter = getShardCounterPerNodeForRemoteCapablePool(clusterState, allocation, true);  
        final int halfRemoteCapableNodes = remoteCapableNodes / 2;
    }  
                }
        nodeReplicaCounter = getShardCounterPerNodeForRemoteCapablePool(clusterState, allocation, false);
                if (Integer.parseInt(node.nodeId().split("-")[4]) < halfRemoteCapableNodes) {
            }
        ClusterState clusterState,
        for (RoutingNode node : routingNodes) {
     * Post rebalance primaries should be balanced across all the nodes.  
        Map<String, Integer> nodePrimariesCounter = getShardCounterPerNodeForRemoteCapablePool(clusterState, allocation, true);  
