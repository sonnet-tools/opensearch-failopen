        int numberOfRelocatingShards = 0;
        clusterState = newState;
            }
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        logger.info("Marking the shard as failed");
                .build()
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            metadataBuilder.put(
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        clusterState = ClusterState.builder(clusterState).build();
        );
            .routingTable(routingTableBuilder.build())
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.metadata.Metadata;
        Metadata.Builder metadataBuilder = Metadata.builder();
        logger.info("Rerouting again, nothing should change");
            .metadata(metadata)
        AllocationService strategy = createAllocationService(
            assertThat(nodeIndex, lessThan(25));
                clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(),
    }
        for (int i = 0; i < numberOfIndices; i++) {
            // make sure we still have 2 shards initializing per node on the only 25 nodes
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 */
import org.opensearch.cluster.node.DiscoveryNodes;
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).unassigned(), equalTo(false));
            // make sure we still have 2 shards either relocating or started on the first 25 nodes (still)
        for (int i = 0; i < numberOfIndices; i++) {
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
        assertThat(newState, equalTo(clusterState));
                anyOf(equalTo(STARTED), equalTo(RELOCATING))
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
        assertThat(clusterState.routingTable().indicesRouting().size(), equalTo(numberOfIndices));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
            .build();
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(INITIALIZING));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));
        clusterState = newState;
import static org.hamcrest.Matchers.not;
        clusterState = strategy.reroute(clusterState, "reroute");
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
import static org.hamcrest.Matchers.anyOf;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            // check that we don't have a shard associated with a node with the same index name (we have a single shard)
            routingNodes.node("node1").shardsWithState(INITIALIZING).get(0),
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(), equalTo(INITIALIZING));
        Metadata.Builder metadataBuilder = Metadata.builder();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
import static org.hamcrest.Matchers.nullValue;
 *
        for (int i = 0; i < numberOfIndices; i++) {
        clusterState = newState;
import org.opensearch.cluster.ClusterState;
public class SingleShardNoReplicasRoutingTests extends OpenSearchAllocationTestCase {
        Metadata metadata = metadataBuilder.build();
 * specific language governing permissions and limitations
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        ClusterState newState = strategy.reroute(clusterState, "reroute");
            } else if (clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state() == RELOCATING) {
    public void testSingleIndexStartedShard() {
                assertThat(encounteredIndices, not(hasItem(shardRoutingEntry.getIndexName())));
        assertThat(clusterState.routingTable().indicesRouting().size(), equalTo(numberOfIndices));
        // routingTable = strategy.reroute(new RoutingStrategyInfo(metadata, routingTable), nodes);
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
        final int numberOfIndices = 50;
            .build();
import org.opensearch.common.settings.Settings;
        assertThat(newState, not(equalTo(clusterState)));
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
            .build();
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4")).add(newNode("node5")))
            .build();
        ClusterState newState = strategy.reroute(clusterState, "reroute");
import org.opensearch.Version;
            assertThat(routingNode.numberOfShardsWithState(STARTED), equalTo(0));
        AllocationService strategy = createAllocationService(
import org.opensearch.cluster.routing.RoutingNodes;
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
            Settings.builder()
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
                numberOfRelocatingShards++;
            );
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));
        newState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState)
        clusterState = newState;
            routingTableBuilder.addAsNew(metadata.index("test" + i));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).unassigned(), equalTo(false));
        newState = strategy.reroute(clusterState, "reroute");
        );
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
        for (int i = (numberOfIndices / 2); i < numberOfIndices; i++) {
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
                anyOf(equalTo(RELOCATING), equalTo(STARTED))
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
        }
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = newState;
            clusterState,
        assertThat(newState, not(equalTo(clusterState)));
        for (int i = 0; i < numberOfIndices; i++) {
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(), equalTo(INITIALIZING));
import static org.hamcrest.Matchers.hasItem;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        }
        assertThat(numberOfShardsOfType(routingNodes, STARTED), equalTo(numberOfIndices));
            String nodeId = clusterState.routingTable().index("test" + i).shard(0).shards().get(0).currentNodeId();
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
        logger.info("Building initial routing table");
        assertThat(routingNodes.node("node2").numberOfShardsWithState(INITIALIZING), anyOf(equalTo(3), equalTo(4)));
        final int numberOfIndices = 10;
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
            .routingTable(routingTableBuilder.build())
        assertThat("4 source shard routing are relocating", numberOfShardsOfType(routingNodes, RELOCATING), equalTo(4));
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(routingNode.numberOfShardsWithState(STARTED), equalTo(2));
 * not use this file except in compliance with the License.
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
                IndexMetadata.builder("test" + i).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0)
        Metadata metadata = Metadata.builder()
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).primary(), equalTo(true));
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            nodesBuilder.add(newNode("node" + i));
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        assertThat(numberOfShardsOfType(routingNodes, INITIALIZING), equalTo(numberOfIndices));
            assertThat(
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        logger.info("Start another node, make sure that things remain the same (shard is in node2 and initializing)");
        Set<String> encounteredIndices = new HashSet<>();
        logger.info("Adding one node and rerouting");
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
        logger.info("Killing node1 where the shard is, checking the shard is unassigned");
import static org.hamcrest.Matchers.equalTo;
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                encounteredIndices.add(shardRoutingEntry.getIndexName());
        clusterState = newState;
            randomBoolean()
        assertThat(newState, equalTo(clusterState));
            int nodeIndex = Integer.parseInt(nodeId.substring("node".length()));
        }
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
        for (int i = 0; i < numberOfIndices; i++) {
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(STARTED));
    public void testMultiIndexUnevenNodes() {
/*
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).primary(), equalTo(true));
                IndexMetadata.builder("test" + i).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
 * Unless required by applicable law or agreed to in writing,
        logger.info("Start two more nodes, things should remain the same");
        clusterState = newState;
            Settings.builder()
        logger.info("Adding " + (numberOfIndices / 2) + " nodes");
        newState = strategy.applyFailedShard(
        logger.info("Starting another node and making sure nothing changed");
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
            .build();
        clusterState = newState;
        }
 * license agreements. See the NOTICE file distributed with
        Metadata metadata = Metadata.builder()
        AllocationService strategy = createAllocationService(
 * this file be licensed under the Apache-2.0 license or a
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
        }
        }
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
import java.util.Set;
        logger.info("Starting 3 nodes and rerouting");
        clusterState = newState;
            .metadata(metadata)
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
            .build();
        logger.info("Building initial routing table with " + numberOfIndices + " indices");
        );
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        assertThat(routingNodes.node("node1").numberOfShardsWithState(INITIALIZING), anyOf(equalTo(3), equalTo(4)));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
import static org.hamcrest.Matchers.lessThan;
            .metadata(metadata)
            assertThat(
        for (int i = 0; i < numberOfIndices; i++) {
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        logger.info("Adding additional " + (numberOfIndices / 2) + " nodes, nothing should change");
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        assertThat(newState, equalTo(clusterState));
    }
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        logger.info("Now, mark the relocated as started");
        newState = startInitializingShardsAndReroute(strategy, clusterState);
import org.apache.logging.log4j.LogManager;
 * under the License.
            );
import org.opensearch.cluster.routing.RoutingNode;
 */
            routingTableBuilder.addAsNew(metadata.index("test" + i));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            metadataBuilder.put(
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
    private final Logger logger = LogManager.getLogger(SingleShardNoReplicasRoutingTests.class);
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            assertThat(routingNode.size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        logger.info("Start the shard on node 1");
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
        clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
import static org.opensearch.cluster.routing.allocation.RoutingNodesUtils.numberOfShardsOfType;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(INITIALIZING));
        }
        for (RoutingNode routingNode : routingNodes) {
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
 *
        routingNodes = clusterState.getRoutingNodes();
        clusterState = newState;
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
        }
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertThat(nodeIndex, lessThan(25));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder().addAsNew(metadata.index("test"));
import java.util.HashSet;
            for (ShardRouting shardRoutingEntry : routingNode) {
 * Licensed to Elasticsearch under one or more contributor
            );
        assertThat(numberOfStartedShards, equalTo(25));
        Metadata metadata = metadataBuilder.build();
            String nodeId = clusterState.routingTable().index("test" + i).shard(0).shards().get(0).currentNodeId();
        for (int i = 0; i < numberOfIndices; i++) {
/*
        assertThat(newState, not(equalTo(clusterState)));
        }
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        assertThat(numberOfRelocatingShards, equalTo(25));
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        logger.info("Marking the shard as started");
        for (int i = 0; i < (numberOfIndices / 2); i++) {
 * The OpenSearch Contributors require contributions made to
        for (int i = 0; i < numberOfIndices; i++) {
        }
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
        }
import org.opensearch.cluster.routing.RoutingTable;
        logger.info("Adding one node and performing rerouting");
 * You may obtain a copy of the License at
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
            .build();
            );
        AllocationService strategy = createAllocationService(
        ClusterState newState = strategy.reroute(clusterState, "reroute");
            int nodeIndex = Integer.parseInt(nodeId.substring("node".length()));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node1"))).build();
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
            if (clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state() == STARTED) {
        for (int i = 0; i < numberOfIndices; i++) {
            // make sure we still have 2 shards initializing per node on the first 25 nodes
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        clusterState = newState;
        nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
package org.opensearch.cluster.routing.allocation;
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
 * software distributed under the License is distributed on an
/*
        assertThat("4 target shard routing are initializing", numberOfShardsOfType(routingNodes, INITIALIZING), equalTo(4));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1")).build();
        }
            .metadata(metadata)
        newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
            .routingTable(routingTableBuilder.build())
}
            int nodeIndex = Integer.parseInt(routingNode.nodeId().substring("node".length()));
        int numberOfStartedShards = 0;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));
        logger.info("Marking the shard as started");
        clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
        for (RoutingNode routingNode : routingNodes) {
        routingNodes = clusterState.getRoutingNodes();
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * ownership. Elasticsearch licenses this file to you under
 * KIND, either express or implied.  See the License for the
        for (int i = 0; i < numberOfIndices; i++) {
                numberOfStartedShards++;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = newState;
        logger.info("Building initial routing table with " + numberOfIndices + " indices");
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(routingNodes.node("node2").numberOfShardsWithState(INITIALIZING), anyOf(equalTo(3), equalTo(4)));
            nodesBuilder.add(newNode("node" + i));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
            assertThat(
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
    }
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(newState, not(equalTo(clusterState)));
            .routingTable(initialRoutingTable)
        logger.info("Building initial routing table");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(STARTED));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
        assertThat(newState, equalTo(clusterState));
        newState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
        logger.info("Bring node1 back, and see it's assinged");
        );
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).unassigned(), equalTo(false));
 * compatible open source license.
 * GitHub history for details.
        }
            );
 * SPDX-License-Identifier: Apache-2.0
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).currentNodeId(), nullValue());
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
        assertThat(newState, equalTo(clusterState));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        newState = strategy.reroute(clusterState, "reroute");
            .build();
    public void testMultiIndexEvenDistribution() {
                clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(),
import org.apache.logging.log4j.Logger;
            assertThat(nodeIndex, lessThan(25));
        }
                clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(),
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            }
        newState = startShardsAndReroute(strategy, clusterState, routingNodes.shardsWithState(INITIALIZING));
    public void testSingleIndexShardFailed() {
    }
                .build()
        );
                anyOf(equalTo(RELOCATING), equalTo(STARTED))
import org.opensearch.cluster.OpenSearchAllocationTestCase;
