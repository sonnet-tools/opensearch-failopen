        decision = executeRebalanceFor(shardToRebalance, clusterState, emptySet(), 0.01f);
 * Modifications Copyright OpenSearch Contributors. See
        // using 2 indices (i.e. 2 total primary shards) because if we have any more than 2 started shards
        if (rebalanceExpected == false) {
        nodesBuilder.add(newNode(randomAlphaOfLength(7)));
            rebalanceDecision.getExplanation(),
        }
        ShardRouting originalRouting
    }
        clusterState = addNodesToClusterState(clusterState, randomIntBetween(1, 10));
            DiscoveryNode discoveryNode = newNode(randomAlphaOfLength(7));
        ShardRouting shard = clusterState.routingTable().index("idx").shard(0).primaryShard();
        assertThat(
        // one node initially so that all primary shards get allocated to the same node. We are only
        AllocationDecider rebalanceDecider = new AllocationDecider() {
            new AllocationDeciders(Arrays.asList(allocationDecider, rebalanceDecider)),
        shardToRebalance = null;
    ) {
        MoveDecision rebalanceDecision = rebalance.v2();
        // rebalance step on it to make sure it gets assigned to the same node.
 * software distributed under the License is distributed on an
                if (noDecisionNodes.contains(node.nodeId())) {
        }
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY);
        assertEquals(AllocationDecision.fromDecisionType(canRebalanceDecision.type()), rebalanceDecision.getAllocationDecision());
}
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        assertEquals(AllocationDecision.NO, rebalanceDecision.getAllocationDecision());
        allocator.allocate(routingAllocation);
            }
        }
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(settings);
        for (NodeAllocationResult result : decision.getNodeDecisions()) {
                return Decision.YES;
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY);
            @Override
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.STARTED);
        ClusterState clusterState = rebalance.v1();
            if (excludeNodes.contains(nodeResult.getNode().getId())) {
    public void testRebalanceNonStartedShardNotAllowed() {
            } else {
import org.opensearch.cluster.routing.ShardRoutingState;
 * compatible open source license.
            List<ShardRouting> relocatingShards = routingNode.shardsWithState(ShardRoutingState.RELOCATING);
            }
            if (i < excludeNodesSize) {
import static org.hamcrest.Matchers.startsWith;
 * the Apache License, Version 2.0 (the "License"); you may
public class BalancedSingleShardTests extends OpenSearchAllocationTestCase {
    private ClusterState addNodesToClusterState(ClusterState clusterState, int numNodesToAdd) {
 * this file be licensed under the Apache-2.0 license or a
            @Override
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(shard, routingAllocation).getMoveDecision();
 */
        }
        AllocationDecider allocationDecider,
            assertThat(result.getWeightRanking(), greaterThanOrEqualTo(prevRanking));
 * Licensed to Elasticsearch under one or more contributor
        decision = executeRebalanceFor(shardToRebalance, clusterState, emptySet(), 0.01f);
        AllocationDecider canAllocateDecider = new AllocationDecider() {
import org.opensearch.cluster.ClusterState;
                return Decision.YES;
/*
        return ClusterState.builder(clusterState).nodes(nodesBuilder).build();
        assertEquals(canRebalanceDecision.type(), rebalanceDecision.getClusterRebalanceDecision().type());
        // be rebalanced, and so we pick the one that was chosen to be rebalanced and execute the single-shard
        MoveDecision rebalanceDecision = rebalance.v2();
        for (Decision subDecision : rebalanceDecision.getClusterRebalanceDecision().getDecisions()) {
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
        assertEquals(Type.YES, rebalanceDecision.getClusterRebalanceDecision().type());
        Tuple<ClusterState, MoveDecision> rebalance = setupStateAndRebalance(canAllocateDecider, balancerSettings, false);
        for (NodeAllocationResult result : decision.getNodeDecisions()) {
        final int numShards = randomIntBetween(8, 13);
 * GitHub history for details.
    }
                break;
            rebalanceDecision.getExplanation(),
                assertFalse(nodesWithTwoShards.contains(result.getNode().getId()));
        MoveDecision decision = executeRebalanceFor(shardToRebalance, clusterState, emptySet(), -1);
    public void testRebalancePossible() {
            }
            nodesBuilder.add(discoveryNode);
import java.util.HashSet;
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(
        AllocationDecider allocationDecider = new AllocationDecider() {
        // to rebalance. the new node should have the best ranking (because it has no shards), followed by the node currently
import static java.util.Collections.emptySet;
            prevRanking = result.getWeightRanking();
        );
 * under the License.
        assertEquals(shardToRebalance.relocatingNodeId(), rebalanceDecision.getTargetNode().getId());
import org.opensearch.cluster.node.DiscoveryNodes;
                assertEquals(Type.NO, nodeResult.getCanAllocateDecision().type());
                    return Decision.NO;
    }
                return Decision.YES;
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        AllocationDecider allocationDecider = new AllocationDecider() {
        Set<String> nodesWithTwoShards = new HashSet<>();
        ).getMoveDecision();
            }
/**
        assertSame(MoveDecision.NOT_TAKEN, rebalanceDecision);
        // nodes will have 2 shard each. then, add another node. pick a shard on one of the nodes that has only 2 shard
    }
        // start off with 3 nodes and 7 shards, so that one of the 3 nodes will have 3 shards assigned, the remaining 2
        final float threshold
        assertEquals(originalRouting.currentNodeId(), routingNodes.activePrimary(originalRouting.shardId()).currentNodeId());
        assertNull(rebalanceDecision.getTargetNode());
        assertNotNull(rebalanceDecision.getClusterRebalanceDecision());
import java.util.List;
        assertNull(rebalanceDecision.getTargetNode());
        ShardRouting shard = clusterState.getRoutingNodes().activePrimary(shardToRebalance.shardId());
                return Decision.YES;
        RoutingAllocation routingAllocation,
import java.util.Collections;
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY);
        BalancedShardsAllocator allocator,
        RoutingNodes routingNodes = routingAllocation.routingNodes();
        }
        // only one shard, so moving it will not create a better balance anywhere, so all node decisions should
        assertEquals(1, rebalanceDecision.getClusterRebalanceDecision().getDecisions().size());
import static org.hamcrest.Matchers.lessThan;
        assertThat(
        }
import org.opensearch.cluster.routing.allocation.decider.Decision;
        shardToRebalance = clusterState.routingTable().index("idx").shardsWithState(ShardRoutingState.STARTED).get(0);
        }
        int excludeNodesSize = randomIntBetween(0, numAddedNodes - 1);
                return Decision.YES;
        ShardRouting shard = clusterState.routingTable().index("idx").shard(0).primaryShard();
        };
        ShardRouting shard = clusterState.routingTable().index("idx").shard(0).primaryShard();
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(shard, routingAllocation).getMoveDecision();
        boolean rebalanceExpected
        int currentRanking = decision.getCurrentNodeRanking();
            }
            }
/*
        // are selected to be rebalanced to the new node, and hence the node to which they are rebalanced
    }
            randomBoolean(),
            startsWith("cannot rebalance as no target node exists that can both allocate this shard and improve the cluster balance")
        // each of these new nodes should have a better ranking than the current, given a low enough threshold
import static org.hamcrest.Matchers.containsString;
        AllocationDecider rebalanceDecider = new AllocationDecider() {
        );
    }
            prevRanking = result.getWeightRanking();
        clusterState = addNodesToClusterState(clusterState, 1);
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
        for (RoutingNode routingNode : routingAllocation.routingNodes()) {
 * specific language governing permissions and limitations
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
        // is not deterministic. Using only two shards guarantees that only one of those two shards will
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
            randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.UNASSIGNED, ShardRoutingState.RELOCATING)
            }
import org.opensearch.common.settings.Settings;
        assertNotNull(rebalanceDecision.getNodeDecisions());
        // in the routing table, then we have no guarantees about the order in which the 3 or more shards
    }
        };
        // holding the shard as well as the other node with only 2 shards (they should have the same ranking), followed by the
            if (relocatingShards.size() > 0) {
            newRoutingAllocation(new AllocationDeciders(Collections.emptyList()), clusterState)
    }
        MoveDecision rebalanceDecision = rebalance.v2();
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
    public void testRebalancingNotAllowedDueToCanRebalance() {
            clusterState
        assertEquals(clusterState.nodes().getSize() - 1, rebalanceDecision.getNodeDecisions().size());
 * SPDX-License-Identifier: Apache-2.0
        ShardRouting shardToRebalance = null;
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(shard, routingAllocation).getMoveDecision();
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", 2, numShards);
                return Decision.YES;
        final Set<String> excludeNodes = new HashSet<>();
            }
/*
            assertAssignedNodeRemainsSame(allocator, routingAllocation, shard);
    }
                    shardToRebalance = node.shardsWithState(ShardRoutingState.STARTED).get(0);
    public void testNodeDecisionsRanking() {
        // add a new node so shards can be rebalanced there
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(balancerSettings);
        assertNull(rebalanceDecision.getTargetNode());
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        String nodeWithThreeShards = null;
            new AllocationDeciders(Collections.singleton(noRebalanceDecider)),
        }
    ) {
        RoutingAllocation routingAllocation = newRoutingAllocation(
        };
        assertEquals(Type.YES, rebalanceDecision.getClusterRebalanceDecision().type());
            containsString(canRebalanceDecision.type() == Type.THROTTLE ? "rebalancing is throttled" : "rebalancing is not allowed")
        };
        List<AllocationDecider> allocationDeciders = Arrays.asList(rebalanceDecider, allocationDecider);
        for (int i = 0; i < numNodesToAdd; i++) {
 * license agreements. See the NOTICE file distributed with
                }
        assertEquals(Type.YES, rebalanceDecision.getClusterRebalanceDecision().type());
            clusterState
            if (node.numberOfShardsWithState(ShardRoutingState.STARTED) == 2) {
        int numAddedNodes = randomIntBetween(1, 5);
    public void testSingleShardBalanceProducesSameResultsAsBalanceStep() {
                excludeNodes.add(discoveryNode.getId());
    }
                // worst ranked should be the node with two shards
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
    public void testRebalancingNotAllowedDueToCanAllocate() {
                    return Decision.NO;
        int prevRanking = 0;
                assertEquals(nodeWithThreeShards, result.getNode().getId());
    }
        ShardRouting shardToRebalance = clusterState.routingTable().index("idx").shardsWithState(ShardRoutingState.STARTED).get(0);
        BalancedShardsAllocator allocator = new BalancedShardsAllocator(Settings.EMPTY);
        ShardRouting shard = clusterState.routingTable().index("idx").shard(0).primaryShard();
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(Collections.emptyList()), clusterState);
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
            }
        AllocationDecider canAllocateDecider = new AllocationDecider() {
        AllocationDecider noRebalanceDecider = new AllocationDecider() {
        // start off with one node and several shards assigned to that node, then add a few nodes to the cluster,
        assertEquals(clusterState.nodes().getSize() - 1, rebalanceDecision.getNodeDecisions().size());
        // make sure all excluded nodes returned a NO decision
                nodesWithTwoShards.add(node.nodeId());
        return allocator.decideShardAllocation(shardRouting, routingAllocation).getMoveDecision();
        clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
        assertEquals(clusterState.nodes().getSize() - 1, rebalanceDecision.getNodeDecisions().size());
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
                nodeWithThreeShards = node.nodeId();
                assertEquals(3, node.numberOfShardsWithState(ShardRoutingState.STARTED));
            assertEquals(1, result.getWeightRanking());
                }
        }
 */
        RoutingAllocation routingAllocation = newRoutingAllocation(
        }
        ClusterState clusterState = ClusterStateCreationUtils.state(1, indices, 1);
import org.opensearch.cluster.routing.ShardRouting;
                if (shardToRebalance == null) {
        assertEquals(AllocationDecision.AWAITING_INFO, rebalanceDecision.getAllocationDecision());
        clusterState = ClusterStateCreationUtils.state(3, new String[] { "idx" }, 7);
package org.opensearch.cluster.routing.allocation;
        routingAllocation.setHasPendingAsyncFetch();
            assertThat(result.getWeightRanking(), lessThan(decision.getCurrentNodeRanking()));
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
            } else {
        return Tuple.tuple(clusterState, rebalanceDecision);
        };
        };
        Tuple<ClusterState, MoveDecision> rebalance = setupStateAndRebalance(canAllocateDecider, Settings.EMPTY, false);
        routingAllocation.debugDecision(true);
                return allocation.decision(canRebalanceDecision, "TEST", "foobar");
        routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
                assertTrue(nodesWithTwoShards.contains(result.getNode().getId()));
        List<AllocationDecider> allocationDeciders = Arrays.asList(rebalanceDecider, allocationDecider);
            assertThat(result.getWeightRanking(), greaterThanOrEqualTo(prevRanking));
            @Override
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        final Set<String> noDecisionNodes,
    }
        }
            } else if (result.getWeightRanking() > decision.getCurrentNodeRanking()) {
import org.opensearch.common.collect.Tuple;
        if (Float.compare(-1.0f, threshold) != 0) {
        };
        assertEquals(AllocationDecision.NO, rebalanceDecision.getAllocationDecision());
 *
 * Unless required by applicable law or agreed to in writing,
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            if (result.getWeightRanking() < decision.getCurrentNodeRanking()) {
        final Decision canRebalanceDecision = randomFrom(Decision.NO, Decision.THROTTLE);
            @Override
 * KIND, either express or implied.  See the License for the
            }
        AllocationDecider canAllocateDecider = new AllocationDecider() {
            assertEquals("foobar", ((Decision.Single) subDecision).getExplanation());
        Settings balancerSettings,
    public void testRebalanceNotAllowedDuringPendingAsyncFetch() {
            settings = Settings.builder().put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), threshold).build();
            }
 * this work for additional information regarding copyright
        for (NodeAllocationResult nodeResult : rebalanceDecision.getNodeDecisions()) {
        assertAssignedNodeRemainsSame(allocator, routingAllocation, shard);
        ClusterState clusterState = ClusterStateCreationUtils.state("idx", randomBoolean(), ShardRoutingState.STARTED);
                assertNull(nodeWithThreeShards); // should only have one of these
            rebalanceDecision.getExplanation(),
import org.opensearch.cluster.routing.RoutingNode;
            @Override
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
        assertEquals(1, currentRanking);
        assertEquals(clusterState.nodes().getSize() - 1, rebalanceDecision.getNodeDecisions().size());
        );
        assertAssignedNodeRemainsSame(allocator, routingAllocation, shard);
        // return the same ranking as the current node
        ClusterState clusterState = rebalance.v1();
        // allocate and get the node that is now relocating
        );
        for (int i = 0; i < numAddedNodes; i++) {
        // Create a cluster state with 2 indices, each with 1 started primary shard, and only
 */
            }
        // randomly select a subset of the newly added nodes to set filter allocation on (but not all)
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        );
        ClusterState clusterState = ClusterStateCreationUtils.state(randomIntBetween(1, 10), new String[] { "idx" }, 1);
            @Override
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            shard,
        final ShardRouting shardRouting,
            nodesBuilder.add(discoveryNode);
            }
        // make sure the previous node id is the same as the current one after rerouting
                assertNotEquals(nodeWithThreeShards, result.getNode().getId());
        for (RoutingNode node : clusterState.getRoutingNodes()) {
            }
            "idx",
        RoutingAllocation routingAllocation = newRoutingAllocation(new AllocationDeciders(allocationDeciders), clusterState);
                shardToRebalance = randomFrom(relocatingShards);
        };
        Tuple<ClusterState, MoveDecision> rebalance = setupStateAndRebalance(canAllocateDecider, Settings.EMPTY, true);
 *
    private Tuple<ClusterState, MoveDecision> setupStateAndRebalance(
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        assertThat(
        ClusterState clusterState = ClusterStateCreationUtils.state(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            @Override
        final ClusterState clusterState,
                return Decision.YES;
    private MoveDecision executeRebalanceFor(
                return Decision.NO;
    public void testDontBalanceShardWhenThresholdNotMet() {
                // highest ranked node should not be any of the initial nodes
        Settings settings = Settings.EMPTY;
import org.opensearch.cluster.routing.allocation.allocator.ShardsBalancer;
        int prevRanking = 0;
            @Override
 * Tests for balancing a single shard, see {@link ShardsBalancer#decideRebalance(ShardRouting)}.
import org.opensearch.cluster.routing.RoutingNodes;
        );
                }
        MoveDecision rebalanceDecision = allocator.decideShardAllocation(shard, routingAllocation).getMoveDecision();
        }
            DiscoveryNode discoveryNode = newNode(randomAlphaOfLength(7));
        };
    ) {
import java.util.Set;
 *
        Settings balancerSettings = Settings.builder().put(BalancedShardsAllocator.THRESHOLD_SETTING.getKey(), 1000f).build();
        for (NodeAllocationResult result : rebalanceDecision.getNodeDecisions()) {
        assertNotNull(rebalanceDecision.getExplanation());
        // add new nodes so one of the primaries can be rebalanced
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            @Override
import java.util.Arrays;
    private void assertAssignedNodeRemainsSame(
        // node with 3 shards which will have the lowest ranking.
        clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
        allocator.allocate(routingAllocation);
        AllocationDecider rebalanceDecider = new AllocationDecider() {
 * ownership. Elasticsearch licenses this file to you under
                if (excludeNodes.contains(node.nodeId())) {
        assertNotNull(rebalanceDecision.getExplanation());
import org.opensearch.cluster.node.DiscoveryNode;
 * The OpenSearch Contributors require contributions made to
        for (NodeAllocationResult result : decision.getNodeDecisions()) {
            startsWith("cannot rebalance as information about existing copies of this shard in the cluster is still being gathered")
        ClusterState clusterState = rebalance.v1();
        final String[] indices = { "idx1", "idx2" };
        clusterState = ClusterStateCreationUtils.state(1, new String[] { "idx" }, randomIntBetween(2, 10));
        // ridiculously high threshold setting so we won't rebalance
        }
        for (NodeAllocationResult result : rebalanceDecision.getNodeDecisions()) {
        assertNull(rebalanceDecision.getTargetNode());
