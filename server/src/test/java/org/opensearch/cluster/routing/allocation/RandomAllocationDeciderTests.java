        final boolean frequentNodes = randomBoolean();
                            break;
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
import org.opensearch.cluster.routing.RoutingTable;
                logger.info("adding node [{}]", nodeIdCounter);
                case 4:
                for (ShardRouting shard : routingNode != null ? routingNode : Collections.<ShardRouting>emptyList()) {
                case 3:
    /* This test will make random allocation decision on a growing and shrinking
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
            if (nodeIdCounter > 1 && rarely()) {
            totalNumShards += numShards * (replicas + 1);
            );
        int totalNumShards = 0;
import java.util.Collections;
 * GitHub history for details.
            EmptySnapshotsInfoService.INSTANCE
        private Decision getRandomDecision() {
        }
        public boolean alwaysSayYes = false;
                            safeToRemove = false;
                case 2:
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
            for (int j = 0; j < (maxNumReplicas - clusterState.nodes().getSize()); j++) {
        );
        final int numNodes = clusterState.nodes().getSize();
 * this work for additional information regarding copyright
     * already allocated on a node and balances the cluster to gain optimal
            }
        for (int i = 0; i < indices; i++) {
            clusterState = stateBuilder.build();
            ClusterState.Builder stateBuilder = ClusterState.builder(clusterState);
            if (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size() > 0) {
 * You may obtain a copy of the License at
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
 *     http://www.apache.org/licenses/LICENSE-2.0
        AllocationService strategy = new AllocationService(
import org.opensearch.Version;
            int numShards = scaledRandomIntBetween(1, 20);
            return getRandomDecision();
        int numIters = scaledRandomIntBetween(5, 15);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new AllocationDeciders(
                        if (clusterState.routingTable().shardRoutingTable(shard.shardId()).activeShards().size() <= 1) {
 * specific language governing permissions and limitations
            return getRandomDecision();
import org.opensearch.cluster.metadata.Metadata.Builder;
        // we stop after 200 iterations if it didn't stabelize by then something is likely to be wrong
        int indices = scaledRandomIntBetween(1, 20);
            boolean nodesRemoved = false;
            int replicas = scaledRandomIntBetween(0, 6);
            .routingTable(initialRoutingTable)
import org.opensearch.cluster.routing.allocation.decider.Decision;
            return getRandomDecision();
import org.hamcrest.Matchers;
 * compatible open source license.
            stateBuilder.nodes(newNodesBuilder.build());
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
                boolean safeToRemove = true;
        assertThat(shards, equalTo(totalNumShards));
        do {
                Matchers.anyOf(
                    return Decision.YES;
package org.opensearch.cluster.routing.allocation;
        }
/*
            metaBuilder.put(
                IndexMetadata.builder("INDEX_" + i).settings(settings(Version.CURRENT)).numberOfShards(numShards).numberOfReplicas(replicas)
 * The OpenSearch Contributors require contributions made to
                case 7:
            if (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size() > 0) {
                clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
        for (int i = 0; i < indices; i++) {
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.ShardRouting;
 * Modifications Copyright OpenSearch Contributors. See
            DiscoveryNodes.Builder newNodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
                }
            switch (random.nextInt(10)) {
        int maxNumReplicas = 1;
 * software distributed under the License is distributed on an
        }
                newNodesBuilder.add(newNode("NODE_" + (nodeIdCounter++)));
            EmptyClusterInfoService.INSTANCE,
        for (int i = 0; i < numIters; i++) {
        @Override
                case 6:
import org.opensearch.cluster.EmptyClusterInfoService;
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
 *
        }
                case 1:
import org.opensearch.test.gateway.TestGatewayAllocator;
                final String node = "NODE_" + nodeId;
            stateBuilder.nodes(newNodesBuilder.build());
            }
            .build();
 * ownership. Elasticsearch licenses this file to you under
            iterations++;
                    }
            assertThat(
                    if (shard.active() && shard.primary()) {
                return Decision.YES;
        int nodeIdCounter = 0;
            clusterState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        if (clusterState.nodes().getSize() < maxNumReplicas) {
public class RandomAllocationDeciderTests extends OpenSearchAllocationTestCase {
                }
        public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        }
        }
        @Override
import org.opensearch.cluster.node.DiscoveryNodes;
                clusterState.getRoutingNodes().node("NODE_" + i).size(),
        int iterations = 0;
            }
                    nodesRemoved = true;
     * amount of iterations the test allows allocation unless the same shard is
 * KIND, either express or implied.  See the License for the
            || clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size() != 0 && iterations < 200);
    public void testRandomDecisions() {
        }
                        // make sure there is an active replica to prevent from going red
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("now say YES to everything");
 * license agreements. See the NOTICE file distributed with
            }
        final int upperBound = (int) Math.round(((shards / numNodes) * 1.10));
import org.opensearch.cluster.metadata.Metadata;
                        randomAllocationDecider
import org.opensearch.cluster.routing.ShardRoutingState;
        logger.info("Fill up nodes such that every shard can be allocated");
 * Unless required by applicable law or agreed to in writing,
            );
        private final Random random;
            }
        logger.info("Done Balancing after [{}] iterations. State:\n{}", iterations, clusterState);
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(0));
            DiscoveryNodes.Builder newNodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
        int atMostNodes = scaledRandomIntBetween(Math.max(1, maxNumReplicas), 15);
                    Matchers.allOf(Matchers.greaterThanOrEqualTo(lowerBound), Matchers.lessThanOrEqualTo(upperBound))
            if (alwaysSayYes) {
     * cluster leading to a random distribution of the shards. After a certain
                            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
/*
            }
            }
                )
            maxNumReplicas = Math.max(maxNumReplicas, replicas + 1);
}
import static org.hamcrest.Matchers.equalTo;
            clusterState = stateBuilder.build();
        final int lowerBound = (int) Math.round(((shards / numNodes) * 0.90));
        public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
            logger.info("Start iteration [{}]", i);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            .metadata(metadata)
                int nodeId = scaledRandomIntBetween(0, nodeIdCounter - 2);
        }
/*
 * Licensed to Elasticsearch under one or more contributor
                }
                    return Decision.NO;
        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
                case 5:
            if (clusterState.getRoutingNodes().node("NODE_" + i) == null) {
                case 9:
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        Metadata metadata = metaBuilder.build();
                    return Decision.THROTTLE;
 */
    }
                        ),
 */
                new HashSet<>(
                    logger.debug("not removing node [{}] as it holds a primary with no replacement", nodeId);
                        new SameShardAllocationDecider(
    public static final class RandomAllocationDecider extends AllocationDecider {
                    )
                    newNodesBuilder.remove(node);
            }
            if (nodesRemoved) {
                clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 *
                continue;
                if (safeToRemove) {
            }
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
     * balance.*/
            new BalancedShardsAllocator(Settings.EMPTY),
                RoutingNode routingNode = clusterState.getRoutingNodes().node(node);
                    Matchers.anyOf(equalTo((shards / numNodes) + 1), equalTo((shards / numNodes) - 1), equalTo((shards / numNodes))),
        assertThat("max num iteration exceeded", iterations, Matchers.lessThan(200));
                int numNodes = scaledRandomIntBetween(1, 3);
        @Override
                    Arrays.asList(
                    logger.info("adding node [{}]", nodeIdCounter);
 * under the License.
                default:
        }
                        }
        randomAllocationDecider.alwaysSayYes = true;
                } else {
    }
            ),
        RoutingTable initialRoutingTable = routingTableBuilder.build();
                    logger.info("removing node [{}]", nodeId);
                case 8:
 */
            ClusterState.Builder stateBuilder = ClusterState.builder(clusterState);
 * not use this file except in compliance with the License.
            } else {
            new TestGatewayAllocator(),
import org.opensearch.common.settings.Settings;
import java.util.HashSet;
                    newNodesBuilder.add(newNode("NODE_" + (nodeIdCounter++)));
        } while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() != 0
                            Settings.EMPTY,
        RandomAllocationDecider randomAllocationDecider = new RandomAllocationDecider(random());
                )
            this.random = random;
            routingTableBuilder.addAsNew(metadata.index("INDEX_" + i));
                clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.cluster.routing.RoutingNode;
                        new ReplicaAfterPrimaryActiveAllocationDecider(),
import org.opensearch.common.settings.ClusterSettings;
        Builder metaBuilder = Metadata.builder();
 *
import java.util.Random;
        public RandomAllocationDecider(Random random) {
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
                    return Decision.ALWAYS;
        }
        for (int i = 0; i < nodeIdCounter; i++) {
                for (int j = 0; j < numNodes; j++) {
                clusterState = strategy.reroute(clusterState, "reroute");
        int shards = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size();
            if (clusterState.nodes().getSize() <= atMostNodes && (nodeIdCounter == 0 || (frequentNodes ? frequently() : rarely()))) {
