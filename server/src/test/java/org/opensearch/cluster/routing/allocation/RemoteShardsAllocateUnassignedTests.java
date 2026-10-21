        }
        }
import org.opensearch.cluster.routing.allocation.allocator.RemoteShardsBalancer;
        int remoteCapableNodes = 0;
                RoutingNode node = routingNodes.node(shard.currentNodeId());
        for (ShardRouting shard : newState.getRoutingTable().allShards()) {
        for (RoutingNode node : routingNodes) {
            }
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
    }
                && RoutingPool.REMOTE_CAPABLE.equals(RoutingPool.getShardPool(shard, allocation))
                if (shard.primary()) {
        final int indexShardLimit = (int) Math.ceil(totalPrimaries(remoteIndices) / (float) remoteCapableNodes);
        final int remoteIndices = 1;
        int remoteIndices = 15;
            } else {
    public void testPrimaryAllocation() {
    public void testNoRemoteAllocation() {
                assertTrue(shard.unassigned());
     */
            }
    /**
        int localOnlyNodes = 7;
        final int remoteCapableNodes = 5;
    /**
        int localIndices = 10;
}
                assertFalse(shard.primary());
        AllocationService service = this.createRemoteCapableAllocationService();
        int remoteIndices = 13;
            for (ShardRouting shard : indexShards.getPrimaries()) {
            if (RoutingPool.REMOTE_CAPABLE.equals(shardPool)) {
    /**
            }
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
        final ClusterState newState = allocateShardsAndBalance(oldState, service);
            } else {
 * SPDX-License-Identifier: Apache-2.0
        int remoteIndices = 13;
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
     * Test remote unassigned shard allocation for standard new cluster setup.
        assertEquals(remoteIndices, unassignedShardMap.size());
            RemoteShardsBalancer.UnassignedIndexShards indexShards = unassignedShardMap.get(index);
import static org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus.DECIDERS_THROTTLED;
     * Test remote unassigned shard allocation when remote capable nodes fail to come up.
import static org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus.NO_ATTEMPT;
 * The OpenSearch Contributors require contributions made to
package org.opensearch.cluster.routing.allocation;
        int remoteCapableNodes = 3;
                assertEquals(nodePool, shardPool);
                }
     */
                assertTrue(shard.unassigned());
                nodePrimariesCounter.compute(node.nodeId(), (k, v) -> (v == null) ? 1 : v + 1);
            RoutingPool nodePool = RoutingPool.getNodePool(node);
            RoutingNode node = routingNodes.node(shard.currentNodeId());
     * Test remote unassigned shard allocation when deciders make NO or THROTTLED decision.
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
        for (int primaries : nodePrimariesCounter.values()) {
        }
            assertFalse(shard.unassigned());
                assertEquals(RoutingPool.LOCAL_ONLY, RoutingPool.getNodePool(node));
                assertTrue(shard.primary());
        final int localOnlyNodes = 10;
    /**
        clusterState = allocateShardsAndBalance(clusterState, service);
                assertEquals(shard.getIndexName(), index);
import org.opensearch.cluster.routing.RoutingNode;
        for (String index : unassignedShardMap.keySet()) {
import org.opensearch.cluster.routing.UnassignedInfo;
        }
            if (RoutingPool.getNodePool(node) == RoutingPool.REMOTE_CAPABLE) {
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(index.startsWith(REMOTE_IDX_PREFIX));
        Map<String, RemoteShardsBalancer.UnassignedIndexShards> unassignedShardMap = remoteShardsBalancer.groupUnassignedShardsByIndex();
        int localOnlyNodes = 7;
                assertFalse(shard.unassigned());
    }
     */
                && shard.primary()) {
        }
            assertTrue(primaries <= indexShardLimit);
            }
    public void testInit() {
            if (RoutingPool.getShardPool(shard, allocation) == RoutingPool.REMOTE_CAPABLE) {
import org.opensearch.cluster.routing.ShardRouting;
                    assertEquals(expect, shard.unassignedInfo().getLastAllocationStatus());
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
                    assertEquals(NO_ATTEMPT, shard.unassignedInfo().getLastAllocationStatus());
 */
        assertEquals(0, routingNodes.unassigned().size());
    }
                } else {
                assertFalse(shard.unassigned());
            }
            assertEquals(5, indexShards.getPrimaries().size());
        final RoutingNodes routingNodes = newState.getRoutingNodes();
import java.util.HashMap;
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
        assertEquals(totalShards(remoteIndices), routingNodes.unassigned().size());
     * Test Remote Shards Balancer initialization.
            for (ShardRouting shard : indexShards.getReplicas()) {
public class RemoteShardsAllocateUnassignedTests extends RemoteShardsBalancerBaseTestCase {
        RoutingNodes routingNodes = new RoutingNodes(clusterState, false);
import java.util.Map;
        final Map<String, Integer> nodePrimariesCounter = new HashMap<>();
        for (ShardRouting shard : clusterState.getRoutingTable().allShards()) {
            if (RoutingPool.getNodePool(node) == RoutingPool.REMOTE_CAPABLE
 *
import static org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus.DECIDERS_NO;
        final AllocationService service = this.createRejectRemoteAllocationService(throttle);
                assertEquals(0, node.size());
        final int localIndices = 2;
            if (RoutingPool.getShardPool(shard, allocation) == RoutingPool.REMOTE_CAPABLE) {
     */
import org.opensearch.cluster.routing.RoutingPool;
        int localIndices = 10;
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
            RoutingPool shardPool = RoutingPool.getShardPool(shard, allocation);
        final RoutingAllocation allocation = getRoutingAllocation(newState, routingNodes);
        assertEquals(totalShards(remoteIndices), routingNodes.unassigned().size());
        RoutingAllocation allocation = getRoutingAllocation(clusterState, routingNodes);
/*
        clusterState = allocateShardsAndBalance(clusterState, service);
        final boolean throttle = randomBoolean();
        int localIndices = 10;
        int remoteCapableNodes = 3;
        }
        int localOnlyNodes = 7;
                assertEquals(shard.getIndexName(), index);
    public void testAllocationRemoteCapableNodesUnavailable() {
            }
            }
        AllocationService service = this.createRemoteCapableAllocationService();
                    final UnassignedInfo.AllocationStatus expect = throttle ? DECIDERS_THROTTLED : DECIDERS_NO;
import org.opensearch.cluster.ClusterState;
 * compatible open source license.
        final ClusterState oldState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
            assertEquals(5, indexShards.getReplicas().size());
        RemoteShardsBalancer remoteShardsBalancer = new RemoteShardsBalancer(logger, allocation);
        ClusterState clusterState = createInitialCluster(localOnlyNodes, remoteCapableNodes, localIndices, remoteIndices);
    }
import org.opensearch.cluster.routing.RoutingNodes;
