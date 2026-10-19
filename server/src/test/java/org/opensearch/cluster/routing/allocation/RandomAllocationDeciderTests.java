        }
                            safeToRemove = false;  
        final int lowerBound = (int) Math.round(((shards / numNodes) * 0.90));
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;  
    public static final class RandomAllocationDecider extends AllocationDecider {
 * ownership. Elasticsearch licenses this file to you under  
            ),
        assertThat(shards, equalTo(totalNumShards));
                logger.info("adding node [{}]", nodeIdCounter);  
        @Override
                    Matchers.allOf(Matchers.greaterThanOrEqualTo(lowerBound), Matchers.lessThanOrEqualTo(upperBound))
        Metadata metadata = metaBuilder.build();
     * balance.*/
            iterations++;
        }
                default:  
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < nodeIdCounter; i++) {
import org.opensearch.snapshots.EmptySnapshotsInfoService;  
            }
        }
    /* This test will make random allocation decision on a growing and shrinking
        } while (clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size() != 0
        Builder metaBuilder = Metadata.builder();  
            }  
            } else {  
            routingTableBuilder.addAsNew(metadata.index("INDEX_" + i));
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
                IndexMetadata.builder("INDEX_" + i).settings(settings(Version.CURRENT)).numberOfShards(numShards).numberOfReplicas(replicas)  
 * not use this file except in compliance with the License.
        RoutingTable initialRoutingTable = routingTableBuilder.build();
                    return Decision.NO;
    public void testRandomDecisions() {  
        }  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            clusterState = stateBuilder.build();  
        int numIters = scaledRandomIntBetween(5, 15);  
            }  
                    logger.debug("not removing node [{}] as it holds a primary with no replacement", nodeId);
import org.opensearch.cluster.routing.ShardRouting;
        assertThat("max num iteration exceeded", iterations, Matchers.lessThan(200));  
            EmptyClusterInfoService.INSTANCE,
import org.opensearch.cluster.metadata.Metadata.Builder;
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
 * You may obtain a copy of the License at  
            new TestGatewayAllocator(),  
import java.util.HashSet;  
                    return Decision.THROTTLE;
                    return Decision.YES;
        private Decision getRandomDecision() {
                    if (shard.active() && shard.primary()) {  
import org.opensearch.common.settings.ClusterSettings;
                clusterState.getRoutingNodes().node("NODE_" + i).size(),
        logger.info("Done Balancing after [{}] iterations. State:\n{}", iterations, clusterState);
            switch (random.nextInt(10)) {
                        new ReplicaAfterPrimaryActiveAllocationDecider(),
            if (alwaysSayYes) {
        public boolean alwaysSayYes = false;  
            if (nodesRemoved) {
                }
        int maxNumReplicas = 1;
    }
import org.opensearch.Version;
            }
import org.opensearch.cluster.routing.ShardRoutingState;  
                case 5:
                for (int j = 0; j < numNodes; j++) {
                case 8:
                    }  
        logger.info("Fill up nodes such that every shard can be allocated");
        }
            boolean nodesRemoved = false;
                    newNodesBuilder.remove(node);
                RoutingNode routingNode = clusterState.getRoutingNodes().node(node);
 *
import org.hamcrest.Matchers;
            if (clusterState.getRoutingNodes().node("NODE_" + i) == null) {  
 */  
            assertThat(  
                case 1:
     * already allocated on a node and balances the cluster to gain optimal
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;  
                )
        AllocationService strategy = new AllocationService(
                    )  
            );  
        for (int i = 0; i < indices; i++) {  
 * software distributed under the License is distributed on an
                    nodesRemoved = true;
            clusterState = strategy.reroute(clusterState, "reroute");  
 * the Apache License, Version 2.0 (the "License"); you may
        if (clusterState.nodes().getSize() < maxNumReplicas) {
            DiscoveryNodes.Builder newNodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
        }
                clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
 * this work for additional information regarding copyright
            for (int j = 0; j < (maxNumReplicas - clusterState.nodes().getSize()); j++) {
            totalNumShards += numShards * (replicas + 1);
public class RandomAllocationDeciderTests extends OpenSearchAllocationTestCase {  
                        // make sure there is an active replica to prevent from going red
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
                case 6:  
                    logger.info("adding node [{}]", nodeIdCounter);  
        }
            stateBuilder.nodes(newNodesBuilder.build());  
import org.opensearch.cluster.EmptyClusterInfoService;  
            if (clusterState.nodes().getSize() <= atMostNodes && (nodeIdCounter == 0 || (frequentNodes ? frequently() : rarely()))) {  
        logger.info("now say YES to everything");
            stateBuilder.nodes(newNodesBuilder.build());
import org.opensearch.cluster.routing.allocation.decider.Decision;
import org.opensearch.common.settings.Settings;
            }
            clusterState = stateBuilder.build();
            DiscoveryNodes.Builder newNodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
        int atMostNodes = scaledRandomIntBetween(Math.max(1, maxNumReplicas), 15);
 */
import org.opensearch.cluster.metadata.Metadata;  
                            Settings.EMPTY,
        for (int i = 0; i < indices; i++) {  
                case 7:
                }
        @Override
            if (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size() > 0) {  
                clusterState = strategy.reroute(clusterState, "reroute");
 * GitHub history for details.
                            break;
        int nodeIdCounter = 0;
                        }
/*  
        public Decision canRemain(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
     * cluster leading to a random distribution of the shards. After a certain
    }  
                int nodeId = scaledRandomIntBetween(0, nodeIdCounter - 2);
                if (safeToRemove) {
        final boolean frequentNodes = randomBoolean();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        public RandomAllocationDecider(Random random) {
 * Licensed to Elasticsearch under one or more contributor  
                        ),  
        int indices = scaledRandomIntBetween(1, 20);
            return getRandomDecision();  
import org.opensearch.cluster.routing.RoutingNode;  
            ClusterState.Builder stateBuilder = ClusterState.builder(clusterState);  
import org.opensearch.cluster.node.DiscoveryNodes;
 *  
package org.opensearch.cluster.routing.allocation;
            }
            new BalancedShardsAllocator(Settings.EMPTY),
            return getRandomDecision();
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(0));
                )
                case 4:  
        RandomAllocationDecider randomAllocationDecider = new RandomAllocationDecider(random());
                    Arrays.asList(
                    logger.info("removing node [{}]", nodeId);  
import java.util.Arrays;
            );
        for (int i = 0; i < numIters; i++) {
                boolean safeToRemove = true;  
                Matchers.anyOf(
                        if (clusterState.routingTable().shardRoutingTable(shard.shardId()).activeShards().size() <= 1) {
                case 2:  
                    Matchers.anyOf(equalTo((shards / numNodes) + 1), equalTo((shards / numNodes) - 1), equalTo((shards / numNodes))),  
                int numNodes = scaledRandomIntBetween(1, 3);
                new HashSet<>(
            EmptySnapshotsInfoService.INSTANCE  
            return getRandomDecision();
                        new SameShardAllocationDecider(  
            }
/*
                        randomAllocationDecider
 * Unless required by applicable law or agreed to in writing,
        do {
     * amount of iterations the test allows allocation unless the same shard is  
            if (nodeIdCounter > 1 && rarely()) {  
            }  
        final int upperBound = (int) Math.round(((shards / numNodes) * 1.10));  
 * Modifications Copyright OpenSearch Contributors. See
                case 9:  
        public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {  
                    return Decision.ALWAYS;
            metaBuilder.put(
            ClusterState.Builder stateBuilder = ClusterState.builder(clusterState);  
 * The OpenSearch Contributors require contributions made to  
}
        int shards = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size();  
        randomAllocationDecider.alwaysSayYes = true;
            .routingTable(initialRoutingTable)
        final int numNodes = clusterState.nodes().getSize();
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        // we stop after 200 iterations if it didn't stabelize by then something is likely to be wrong
            .metadata(metadata)  
            || clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.UNASSIGNED).size() != 0 && iterations < 200);  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
                return Decision.YES;  
            }
        );
 */  
                    newNodesBuilder.add(newNode("NODE_" + (nodeIdCounter++)));
                newNodesBuilder.add(newNode("NODE_" + (nodeIdCounter++)));
            this.random = random;  
            new AllocationDeciders(  
                } else {  
import org.opensearch.cluster.ClusterState;
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(0));
        int totalNumShards = 0;
                continue;
                case 3:
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                final String node = "NODE_" + nodeId;
            int replicas = scaledRandomIntBetween(0, 6);
import org.opensearch.cluster.routing.RoutingTable;
            logger.info("Start iteration [{}]", i);
        }  
            if (clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size() > 0) {
import static org.hamcrest.Matchers.equalTo;
                for (ShardRouting shard : routingNode != null ? routingNode : Collections.<ShardRouting>emptyList()) {
        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {  
/*  
        private final Random random;  
import org.opensearch.cluster.metadata.IndexMetadata;
                clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            maxNumReplicas = Math.max(maxNumReplicas, replicas + 1);
                            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            .build();
import org.opensearch.test.gateway.TestGatewayAllocator;
import org.opensearch.cluster.routing.allocation.decider.ReplicaAfterPrimaryActiveAllocationDecider;
import java.util.Collections;
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
 * under the License.  
                }
        @Override
                clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import java.util.Random;
        }
 * compatible open source license.
        int iterations = 0;  
 * KIND, either express or implied.  See the License for the
        }  
            int numShards = scaledRandomIntBetween(1, 20);  
