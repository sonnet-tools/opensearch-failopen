        ShardRouting shard = clusterState.routingTable().index("idx").shard(0).primaryShard();
        assertEquals(originalRouting.currentNodeId(), routingNodes.activePrimary(originalRouting.shardId()).currentNodeId());
            if (excludeNodes.contains(nodeResult.getNode().getId())) {  
    public void testRebalanceNonStartedShardNotAllowed() {  
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(shard, routingAllocation).getMoveDecision();  
            prevRanking = result.getWeightRanking();  
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        assertAssignedNodeRemainsSame(allocator, routingAllocation, shard);  
        for (NodeAllocationResult result : decision.getNodeDecisions()) {
public class BalancedSingleShardTests extends OpenSearchAllocationTestCase {
        assertNull(rebalanceDecision.getTargetNode());  
        assertSame(MoveDecision.NOT_TAKEN, rebalanceDecision);  
                assertNotEquals(nodeWithThreeShards, result.getNode().getId());
        int currentRanking = decision.getCurrentNodeRanking();  
        AllocationDecider canAllocateDecider = new AllocationDecider() {
        // return the same ranking as the current node
import java.util.Arrays;
            assertThat(result.getWeightRanking(), greaterThanOrEqualTo(prevRanking));
        AllocationDecider canAllocateDecider = new AllocationDecider() {
    public void testSingleShardBalanceProducesSameResultsAsBalanceStep() {
package org.opensearch.cluster.routing.allocation;
        // rebalance step on it to make sure it gets assigned to the same node.
import org.opensearch.cluster.routing.allocation.allocator.ShardsBalancer;
        }  
        );  
    }
        // in the routing table, then we have no guarantees about the order in which the 3 or more shards  
        final Set<String> excludeNodes = new HashSet<>();
            new AllocationDeciders(Arrays.asList(allocationDecider, rebalanceDecider)),
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        allocator.allocate(routingAllocation);
                    return Decision.NO;
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        assertThat(  
        AllocationDecider rebalanceDecider = new AllocationDecider() {
/*
            rebalanceDecision.getExplanation(),
        if (Float.compare(-1.0f, threshold) != 0) {  
        // one node initially so that all primary shards get allocated to the same node. We are only
        final Set<String> noDecisionNodes,
import java.util.List;
 * KIND, either express or implied.  See the License for the
        AllocationDecider noRebalanceDecider = new AllocationDecider() {  
        // be rebalanced, and so we pick the one that was chosen to be rebalanced and execute the single-shard  
            randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.UNASSIGNED, ShardRoutingState.RELOCATING)
        return ClusterState.builder(clusterState).nodes(nodesBuilder).build();
            clusterState  
 */
        final ClusterState clusterState,
        AllocationDecider allocationDecider = new AllocationDecider() {  
    public void testRebalancingNotAllowedDueToCanRebalance() {
                }
        clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
        assertNotNull(rebalanceDecision.getExplanation());  
        // only one shard, so moving it will not create a better balance anywhere, so all node decisions should
                break;
        };
        };  
        ClusterState clusterState = ClusterStateCreationUtils.state(
        decision = executeRebalanceFor(shardToRebalance, clusterState, emptySet(), 0.01f);
        };  
        routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
        Settings balancerSettings = Settings.builder().put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), 1000f).build();  
            "idx",  
                return Decision.YES;  
import org.opensearch.cluster.ClusterState;
            @Override
                return Decision.YES;  
        // randomly select a subset of the newly added nodes to set filter allocation on (but not all)  
        );
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
                nodesWithTwoShards.add(node.nodeId());  
        allocator.allocate(routingAllocation);
            }
        AllocationDecider allocationDecider = new AllocationDecider() {  
        assertThat(
        }
        );  
import java.util.HashSet;  
/*  
import org.opensearch.cluster.routing.RoutingNodes;
        ShardRouting originalRouting
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(balancerSettings);  
        final String[] indices = { "idx1", "idx2" };
        ShardRouting shardToRebalance = clusterState.routingTable().index("idx").shardsWithState(ShardRoutingState.STARTED).get(0);
        );
        Settings balancerSettings,
    }
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY);  
        RoutingAllocation routingAllocation,
        Tuple<ClusterState, MoveDecision> rebalance = setupStateAndRebalance(canAllocateDecider, Settings.EMPTY, true);
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(
        return Tuple.tuple(clusterState, rebalanceDecision);
        routingAllocation.setHasPendingAsyncFetch();
    private Tuple<ClusterState, MoveDecision> setupStateAndRebalance(
            List<ShardRouting> relocatingShards = routingNode.shardsWithState(ShardRoutingState.RELOCATING);
        // nodes will have 2 shard each. then, add another node. pick a shard on one of the nodes that has only 2 shard
            shard,  
        }
        // start off with one node and several shards assigned to that node, then add a few nodes to the cluster,  
        ShardRouting shard = clusterState.routingTable().index("idx").shard(0).primaryShard();  
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", 2, numShards);
        };
        };
        assertNotNull(rebalanceDecision.getNodeDecisions());
            clusterState
        for (RoutingNode routingNode : routingAllocation.routingNodes()) {  
        assertEquals(clusterState.nodes().getSize() - 1, rebalanceDecision.getNodeDecisions().size());  
    private MoveDecision executeRebalanceFor(
        // add a new node so shards can be rebalanced there
        for (NodeAllocationResult nodeResult : rebalanceDecision.getNodeDecisions()) {
        // ridiculously high threshold setting so we won't rebalance
 * Tests for balancing a single shard, see {@link ShardsBalancer#decideRebalance(ShardRouting)}.
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
 * this file be licensed under the Apache-2.0 license or a
                excludeNodes.add(discoveryNode.getId());
            }
    public void testRebalancingNotAllowedDueToCanAllocate() {  
        }
        AllocationDecider allocationDecider,  
            new AllocationDeciders(Collections.singleton(noRebalanceDecider)),
            assertThat(result.getWeightRanking(), lessThan(decision.getCurrentNodeRanking()));
        BalancedShardsAllocator allocator,  
        ClusterState clusterState = ClusterStateCreationUtils.state(randomIntBetween(1, 10), new String[] { "idx" }, 1);  
        return allocator.decideShardAllocation(shardRouting, routingAllocation).getMoveDecision();
 * license agreements. See the NOTICE file distributed with
        ShardRouting shardToRebalance = null;
    public void testDontBalanceShardWhenThresholdNotMet() {
    ) {
        ShardRouting shard = clusterState.getRoutingNodes().activePrimary(shardToRebalance.shardId());
        for (Decision subDecision : rebalanceDecision.getClusterRebalanceDecision().getDecisions()) {
            }
 */  
        AllocationDecider rebalanceDecider = new AllocationDecider() {  
                    shardToRebalance = node.shardsWithState(ShardRoutingState.STARTED).get(0);
 * GitHub history for details.
                }  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(clusterState.nodes().getSize() - 1, rebalanceDecision.getNodeDecisions().size());
        assertEquals(Type.YES, rebalanceDecision.getClusterRebalanceDecision().type());
                // worst ranked should be the node with two shards  
        List<AllocationDecider> allocationDeciders = Arrays.asList(rebalanceDecider, allocationDecider);
        clusterState = ClusterStateCreationUtils.state(3, new String[] { "idx" }, 7);  
        };
        }
        ShardRouting shard = clusterState.routingTable().index("idx").shard(0).primaryShard();  
 */  
        int prevRanking = 0;  
        clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(clusterState.nodes().getSize() - 1, rebalanceDecision.getNodeDecisions().size());
            settings = Settings.builder().put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), threshold).build();
        assertEquals(Type.YES, rebalanceDecision.getClusterRebalanceDecision().type());
        ShardRouting shard = clusterState.routingTable().index("idx").shard(0).primaryShard();
        assertEquals(1, rebalanceDecision.getClusterRebalanceDecision().getDecisions().size());
    ) {  
            DiscoveryNode discoveryNode = newNode(randomAlphaOfLength(7));
 * You may obtain a copy of the License at  
        assertEquals(shardToRebalance.relocatingNodeId(), rebalanceDecision.getTargetNode().getId());  
        // holding the shard as well as the other node with only 2 shards (they should have the same ranking), followed by the
            @Override
        final Decision canRebalanceDecision = randomFrom(Decision.NO, Decision.THROTTLE);
            @Override
import static org.hamcrest.Matchers.containsString;
        assertNull(rebalanceDecision.getTargetNode());
        assertNull(rebalanceDecision.getTargetNode());
        }
 * this work for additional information regarding copyright
        int excludeNodesSize = randomIntBetween(0, numAddedNodes - 1);
        final float threshold  
        clusterState = addNodesToClusterState(clusterState, 1);
        assertEquals(AllocationDecision.AWAITING_INFO, rebalanceDecision.getAllocationDecision());
            rebalanceDecision.getExplanation(),
                return Decision.YES;
        decision = executeRebalanceFor(shardToRebalance, clusterState, emptySet(), 0.01f);
 *
    }
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        for (NodeAllocationResult result : decision.getNodeDecisions()) {  
                assertEquals(nodeWithThreeShards, result.getNode().getId());
            assertEquals("foobar", ((Decision.Single) subDecision).getExplanation());  
        // start off with 3 nodes and 7 shards, so that one of the 3 nodes will have 3 shards assigned, the remaining 2
        final int numShards = randomIntBetween(8, 13);
 * Modifications Copyright OpenSearch Contributors. See
            @Override
import org.opensearch.common.settings.Settings;
        for (NodeAllocationResult result : rebalanceDecision.getNodeDecisions()) {
            }
                if (excludeNodes.contains(node.nodeId())) {  
    }
import java.util.Set;
        // allocate and get the node that is now relocating
            }
        };
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
        // add new nodes so one of the primaries can be rebalanced  
        assertEquals(Type.YES, rebalanceDecision.getClusterRebalanceDecision().type());
/*  
        for (NodeAllocationResult result : decision.getNodeDecisions()) {  
        for (int i = 0; i < numAddedNodes; i++) {  
            }
            DiscoveryNode discoveryNode = newNode(randomAlphaOfLength(7));
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(shard, routingAllocation).getMoveDecision();
            @Override
        // to rebalance. the new node should have the best ranking (because it has no shards), followed by the node currently  
        MoveDecision rebalanceDecision = rebalance.v2();  
            assertAssignedNodeRemainsSame(allocator, routingAllocation, shard);
        AllocationDecider canAllocateDecider = new AllocationDecider() {
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.STARTED);
                if (noDecisionNodes.contains(node.nodeId())) {  
            } else if (result.getWeightRanking() > decision.getCurrentNodeRanking()) {
        // node with 3 shards which will have the lowest ranking.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.RoutingNode;  
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());  
}  
    private void assertAssignedNodeRemainsSame(
                return Decision.YES;
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY);
            @Override  
        clusterState = ClusterStateCreationUtils.state(1, new String[] { "idx" }, randomIntBetween(2, 10));
        }  
        Tuple<ClusterState, MoveDecision> rebalance = setupStateAndRebalance(canAllocateDecider, Settings.EMPTY, false);
        // make sure the previous node id is the same as the current one after rerouting  
        // make sure all excluded nodes returned a NO decision
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;  
            if (i < excludeNodesSize) {  
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.STARTED);
        assertEquals(AllocationDecision.fromDecisionType(canRebalanceDecision.type()), rebalanceDecision.getAllocationDecision());  
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
/**
        assertNotNull(rebalanceDecision.getClusterRebalanceDecision());
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(shard, routingAllocation).getMoveDecision();
            }
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        List<AllocationDecider> allocationDeciders = Arrays.asList(rebalanceDecider, allocationDecider);  
            startsWith("cannot rebalance as information about existing copies of this shard in the cluster is still being gathered")
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(settings);  
        ClusterState clusterState = rebalance.v1();
                if (shardToRebalance == null) {
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY);  
import static java.util.Collections.emptySet;
            @Override
        }
            }
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());  
            @Override
 * Unless required by applicable law or agreed to in writing,
        shardToRebalance = null;
        assertEquals(canRebalanceDecision.type(), rebalanceDecision.getClusterRebalanceDecision().type());
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {  
import java.util.Collections;
        // Create a cluster state with 2 indices, each with 1 started primary shard, and only  
 */  
    public void testRebalanceNotAllowedDuringPendingAsyncFetch() {  
    }
            nodesBuilder.add(discoveryNode);  
            nodesBuilder.add(discoveryNode);
        routingAllocation.debugDecision(true);  
import org.opensearch.common.collect.Tuple;
            @Override
import org.opensearch.cluster.routing.ShardRoutingState;  
                }
        for (NodeAllocationResult result : rebalanceDecision.getNodeDecisions()) {
 *  
        String nodeWithThreeShards = null;  
import org.opensearch.cluster.routing.allocation.decider.Decision;
            }
        Tuple<ClusterState, MoveDecision> rebalance = setupStateAndRebalance(canAllocateDecider, balancerSettings, false);
        }
 * software distributed under the License is distributed on an
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        };
            }
        // using 2 indices (i.e. 2 total primary shards) because if we have any more than 2 started shards
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        for (RoutingNode node : clusterState.getRoutingNodes()) {
        assertEquals(AllocationDecision.NO, rebalanceDecision.getAllocationDecision());
 * specific language governing permissions and limitations
                return allocation.decision(canRebalanceDecision, "TEST", "foobar");  
            } else {
            }  
    }
    }
        RoutingAllocation routingAllocation = newRoutingAllocation(  
            }
                assertEquals(3, node.numberOfShardsWithState(ShardRoutingState.STARTED));
        clusterState = addNodesToClusterState(clusterState, randomIntBetween(1, 10));
        assertThat(  
        final ShardRouting shardRouting,  
            if (relocatingShards.size() > 0) {
                return Decision.YES;  
            randomBoolean(),
            containsString(canRebalanceDecision.type() == Type.THROTTLE ? "rebalancing is throttled" : "rebalancing is not allowed")  
    }  
            if (result.getWeightRanking() < decision.getCurrentNodeRanking()) {
            rebalanceDecision.getExplanation(),
            assertEquals(1, result.getWeightRanking());  
        RoutingAllocation routingAllocation = newRoutingAllocation(
    }
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;  
        }
        assertAssignedNodeRemainsSame(allocator, routingAllocation, shard);
        if (rebalanceExpected == false) {
        assertEquals(clusterState.nodes().getSize() - 1, rebalanceDecision.getNodeDecisions().size());
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(Collections.emptyList()), clusterState);
    private ClusterState addNodesToClusterState(ClusterState clusterState, int numNodesToAdd) {
    }  
                return Decision.NO;
                assertTrue(nodesWithTwoShards.contains(result.getNode().getId()));  
                return Decision.YES;  
        MoveDecision rebalanceDecision = rebalance.v2();  
 * The OpenSearch Contributors require contributions made to  
                assertFalse(nodesWithTwoShards.contains(result.getNode().getId()));  
        assertNotNull(rebalanceDecision.getExplanation());
        MoveDecision rebalanceDecision = rebalance.v2();  
    ) {  
            if (node.numberOfShardsWithState(ShardRoutingState.STARTED) == 2) {
            startsWith("cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance")
        MoveDecision decision = executeRebalanceFor(shardToRebalance, clusterState, emptySet(), -1);
        for (int i = 0; i < numNodesToAdd; i++) {
    public void testRebalancePossible() {  
 *
    public void testNodeDecisionsRanking() {  
        // are selected to be rebalanced to the new node, and hence the node to which they are rebalanced
        shardToRebalance = clusterState.routingTable().index("idx").shardsWithState(ShardRoutingState.STARTED).get(0);  
        ClusterState clusterState = ClusterStateCreationUtils.state(1, indices, 1);
            assertThat(result.getWeightRanking(), greaterThanOrEqualTo(prevRanking));
        assertNull(rebalanceDecision.getTargetNode());
        boolean rebalanceExpected
 * not use this file except in compliance with the License.
                    return Decision.NO;
        Set<String> nodesWithTwoShards = new HashSet<>();
        assertEquals(1, currentRanking);
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(AllocationDecision.NO, rebalanceDecision.getAllocationDecision());
        }  
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.lessThan;
        );  
        RoutingNodes routingNodes = routingAllocation.routingNodes();
        // each of these new nodes should have a better ranking than the current, given a low enough threshold
                nodeWithThreeShards = node.nodeId();
        }  
        };  
        Settings settings = Settings.EMPTY;
 * the Apache License, Version 2.0 (the "License"); you may
                return Decision.YES;
                assertNull(nodeWithThreeShards); // should only have one of these  
                shardToRebalance = randomFrom(relocatingShards);  
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
        nodesBuilder.add(newNode(randomAlphaOfLength(7)));
 * under the License.  
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(shard, routingAllocation).getMoveDecision();
                assertEquals(Type.NO, nodeResult.getCanAllocateDecision().type());
    }  
                // highest ranked node should not be any of the initial nodes
        );  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.cluster.node.DiscoveryNodes;
 * compatible open source license.
        ClusterState clusterState = rebalance.v1();
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
            }
            prevRanking = result.getWeightRanking();  
            }
            } else {
        ClusterState clusterState = rebalance.v1();
import org.opensearch.cluster.routing.ShardRouting;
    }  
        }  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        ).getMoveDecision();
        int prevRanking = 0;  
        AllocationDecider rebalanceDecider = new AllocationDecider() {  
        // is not deterministic. Using only two shards guarantees that only one of those two shards will
        int numAddedNodes = randomIntBetween(1, 5);
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY);
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
            newRoutingAllocation(new AllocationDeciders(Collections.emptyList()), clusterState)
