 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < numberOfIndices; i++) {
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));  
        for (RoutingNode routingNode : routingNodes) {  
        logger.info("Building initial routing table");  
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int numberOfStartedShards = 0;
 */
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).primary(), equalTo(true));
            clusterState,
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
            // check that we don't have a shard associated with a node with the same index name (we have a single shard)  
        }
            randomBoolean()
        for (int i = 0; i < numberOfIndices; i++) {
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
        logger.info("Adding one node and rerouting");
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));  
        Metadata.Builder metadataBuilder = Metadata.builder();
            metadataBuilder.put(  
            String nodeId = clusterState.routingTable().index("test" + i).shard(0).shards().get(0).currentNodeId();  
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
import org.opensearch.cluster.metadata.Metadata;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
    }  
 * KIND, either express or implied.  See the License for the
            .build();
            assertThat(routingNode.numberOfShardsWithState(STARTED), equalTo(2));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(), equalTo(INITIALIZING));
        }  
            .routingTable(routingTableBuilder.build())
        clusterState = newState;
            Settings.builder()
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        newState = strategy.reroute(clusterState, "reroute");
            .metadata(metadata)  
            .metadata(metadata)  
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).currentNodeId(), nullValue());  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))  
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        clusterState = ClusterState.builder(clusterState)
                IndexMetadata.builder("test" + i).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0)
            int nodeIndex = Integer.parseInt(routingNode.nodeId().substring("node".length()));
import org.opensearch.cluster.routing.RoutingTable;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).unassigned(), equalTo(false));  
        assertThat(newState, equalTo(clusterState));
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState)
        clusterState = newState;
            );
        );
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));  
 * this work for additional information regarding copyright
    public void testSingleIndexStartedShard() {
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node1"))).build();
            assertThat(routingNode.numberOfShardsWithState(STARTED), equalTo(0));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(newState, equalTo(clusterState));
        assertThat(newState, not(equalTo(clusterState)));
        for (int i = 0; i < numberOfIndices; i++) {
        }  
 * Licensed to Elasticsearch under one or more contributor  
        logger.info("Adding one node and performing rerouting");
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
 */  
    public void testMultiIndexEvenDistribution() {
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
 *  
        );
}
        ClusterState newState = strategy.reroute(clusterState, "reroute");  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));  
        clusterState = newState;
        logger.info("Start the shard on node 1");  
            assertThat(nodeIndex, lessThan(25));
        newState = strategy.reroute(clusterState, "reroute");
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.not;
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
        logger.info("Starting 3 nodes and rerouting");
        newState = strategy.reroute(clusterState, "reroute");  
        Metadata metadata = metadataBuilder.build();
import org.opensearch.cluster.metadata.IndexMetadata;  
        }
                .build()
        }
        Set<String> encounteredIndices = new HashSet<>();
            .metadata(metadata)
import org.apache.logging.log4j.LogManager;
        logger.info("Rerouting again, nothing should change");
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));  
        logger.info("Start another node, make sure that things remain the same (shard is in node2 and initializing)");
        AllocationService strategy = createAllocationService(
        clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).unassigned(), equalTo(false));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(INITIALIZING), anyOf(equalTo(3), equalTo(4)));
        logger.info("Building initial routing table");  
            // make sure we still have 2 shards either relocating or started on the first 25 nodes (still)
        ClusterState newState = strategy.reroute(clusterState, "reroute");
            }
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
    public void testMultiIndexUnevenNodes() {
        }  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        Metadata metadata = metadataBuilder.build();
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
            .metadata(metadata)
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
 * ownership. Elasticsearch licenses this file to you under  
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        clusterState = newState;  
        routingNodes = clusterState.getRoutingNodes();
        }
        int numberOfRelocatingShards = 0;  
                clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(),
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
 * You may obtain a copy of the License at  
            .routingTable(routingTableBuilder.build())
        logger.info("Now, mark the relocated as started");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();  
        clusterState = strategy.reroute(clusterState, "reroute");  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(STARTED));
            String nodeId = clusterState.routingTable().index("test" + i).shard(0).shards().get(0).currentNodeId();  
import static org.hamcrest.Matchers.equalTo;
        }  
 * Modifications Copyright OpenSearch Contributors. See
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
import org.opensearch.Version;  
        for (int i = 0; i < numberOfIndices; i++) {
            nodesBuilder.add(newNode("node" + i));  
import org.opensearch.cluster.routing.RoutingNode;  
            // make sure we still have 2 shards initializing per node on the first 25 nodes
                clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(),  
        }  
import static org.hamcrest.Matchers.anyOf;  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        clusterState = newState;  
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.nullValue;
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));  
import org.opensearch.cluster.routing.RoutingNodes;
            );
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
/*
        );
import org.apache.logging.log4j.Logger;
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
            }  
            assertThat(
 *     http://www.apache.org/licenses/LICENSE-2.0
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        }
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(routingNodes.node("node2").numberOfShardsWithState(INITIALIZING), anyOf(equalTo(3), equalTo(4)));  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));  
        newState = startInitializingShardsAndReroute(strategy, clusterState);
                numberOfRelocatingShards++;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.routingTable().indicesRouting().size(), equalTo(numberOfIndices));  
        assertThat(newState, not(equalTo(clusterState)));  
        }
 * license agreements. See the NOTICE file distributed with
 */  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));  
                anyOf(equalTo(RELOCATING), equalTo(STARTED))
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));  
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
        newState = strategy.applyFailedShard(
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(INITIALIZING));
        clusterState = newState;  
        routingNodes = clusterState.getRoutingNodes();  
                encounteredIndices.add(shardRoutingEntry.getIndexName());  
        clusterState = newState;
            // make sure we still have 2 shards initializing per node on the only 25 nodes  
            assertThat(
        logger.info("Starting another node and making sure nothing changed");
        assertThat(numberOfRelocatingShards, equalTo(25));
        assertThat(newState, equalTo(clusterState));
        newState = startShardsAndReroute(strategy, clusterState, routingNodes.shardsWithState(INITIALIZING));
            int nodeIndex = Integer.parseInt(nodeId.substring("node".length()));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(STARTED));  
            .build();  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(INITIALIZING), anyOf(equalTo(3), equalTo(4)));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
            nodesBuilder.add(newNode("node" + i));
            .routingTable(routingTableBuilder.build())  
                clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(),
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        AllocationService strategy = createAllocationService(
        );
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(nodeIndex, lessThan(25));
        logger.info("Adding " + (numberOfIndices / 2) + " nodes");  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));  
        assertThat(newState, not(equalTo(clusterState)));
                numberOfStartedShards++;  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
        assertThat(clusterState.routingTable().indicesRouting().size(), equalTo(numberOfIndices));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        for (int i = 0; i < numberOfIndices; i++) {  
        clusterState = newState;
        clusterState = newState;
            .build();  
import org.opensearch.cluster.ClusterState;
package org.opensearch.cluster.routing.allocation;
 * software distributed under the License is distributed on an
import java.util.HashSet;
            for (ShardRouting shardRoutingEntry : routingNode) {
                .build()
        logger.info("Building initial routing table with " + numberOfIndices + " indices");  
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
        final int numberOfIndices = 50;
        logger.info("Marking the shard as started");
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
import org.opensearch.cluster.node.DiscoveryNodes;
            if (clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state() == STARTED) {
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
 * SPDX-License-Identifier: Apache-2.0
        for (RoutingNode routingNode : routingNodes) {  
import static org.opensearch.cluster.routing.allocation.RoutingNodesUtils.numberOfShardsOfType;
        assertThat(newState, not(equalTo(clusterState)));  
            routingNodes.node("node1").shardsWithState(INITIALIZING).get(0),  
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
            .build();
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).primary(), equalTo(true));
        assertThat(newState, not(equalTo(clusterState)));
        for (int i = (numberOfIndices / 2); i < numberOfIndices; i++) {  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
        logger.info("Marking the shard as failed");
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)  
        );  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node4")).add(newNode("node5")))
            assertThat(routingNode.size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
            Settings.builder()  
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
                anyOf(equalTo(STARTED), equalTo(RELOCATING))  
        nodesBuilder = DiscoveryNodes.builder(clusterState.nodes());
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));  
        for (int i = 0; i < (numberOfIndices / 2); i++) {
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(newState, equalTo(clusterState));
        assertThat(numberOfStartedShards, equalTo(25));
import java.util.Set;
            int nodeIndex = Integer.parseInt(nodeId.substring("node".length()));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
            assertThat(
        AllocationService strategy = createAllocationService(  
 *
import org.opensearch.cluster.routing.ShardRouting;  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));  
        assertThat(newState, not(equalTo(clusterState)));  
        logger.info("Marking the shard as started");
        routingNodes = clusterState.getRoutingNodes();
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));  
        for (int i = 0; i < numberOfIndices; i++) {
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
        for (int i = 0; i < numberOfIndices; i++) {  
        Metadata.Builder metadataBuilder = Metadata.builder();
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        newState = strategy.reroute(clusterState, "reroute");
            .routingTable(initialRoutingTable)
/*  
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).unassigned(), equalTo(false));
            assertThat(clusterState.routingTable().index("test" + i).shards().size(), equalTo(1));
            );  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));  
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
        logger.info("Adding additional " + (numberOfIndices / 2) + " nodes, nothing should change");
import static org.hamcrest.Matchers.lessThan;  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
 * this file be licensed under the Apache-2.0 license or a
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));  
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
    }  
        }
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(1));  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
    }
        assertThat(numberOfShardsOfType(routingNodes, STARTED), equalTo(numberOfIndices));
        for (int i = 0; i < numberOfIndices; i++) {
        clusterState = newState;
        }
        logger.info("Building initial routing table with " + numberOfIndices + " indices");
    }
            routingTableBuilder.addAsNew(metadata.index("test" + i));
        clusterState = newState;
        ClusterState newState = strategy.reroute(clusterState, "reroute");  
            .build();
        assertThat(newState, not(equalTo(clusterState)));  
            );
 *
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
        clusterState = ClusterState.builder(clusterState).nodes(nodesBuilder).build();
            metadataBuilder.put(
            );
 * compatible open source license.
        // routingTable = strategy.reroute(new RoutingStrategyInfo(metadata, routingTable), nodes);  
        newState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(newState, not(equalTo(clusterState)));  
            } else if (clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state() == RELOCATING) {
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
 * under the License.  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), equalTo("node1"));
    public void testSingleIndexShardFailed() {
    private final Logger logger = LogManager.getLogger(SingleShardNoReplicasRoutingTests.class);
 * specific language governing permissions and limitations
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
        clusterState = newState;  
        assertThat(numberOfShardsOfType(routingNodes, INITIALIZING), equalTo(numberOfIndices));
 * Unless required by applicable law or agreed to in writing,
        logger.info("Killing node1 where the shard is, checking the shard is unassigned");
        newState = startInitializingShardsAndReroute(strategy, clusterState);
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(), equalTo(INITIALIZING));  
            .build();
            routingTableBuilder.addAsNew(metadata.index("test" + i));  
        assertThat("4 target shard routing are initializing", numberOfShardsOfType(routingNodes, INITIALIZING), equalTo(4));
        logger.info("Start two more nodes, things should remain the same");  
        logger.info("Bring node1 back, and see it's assinged");  
        for (int i = 0; i < numberOfIndices; i++) {  
 * GitHub history for details.
        final int numberOfIndices = 10;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
/*  
        assertThat("4 source shard routing are relocating", numberOfShardsOfType(routingNodes, RELOCATING), equalTo(4));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));  
        clusterState = ClusterState.builder(clusterState).build();  
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(newState, equalTo(clusterState));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).shards().size(), equalTo(1));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        newState = strategy.reroute(clusterState, "reroute");  
        }
            assertThat(nodeIndex, lessThan(25));
                anyOf(equalTo(RELOCATING), equalTo(STARTED))  
 * not use this file except in compliance with the License.
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))  
            .build();
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder().addAsNew(metadata.index("test"));  
public class SingleShardNoReplicasRoutingTests extends OpenSearchAllocationTestCase {
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(STARTED));
        for (int i = 0; i < numberOfIndices; i++) {
        AllocationService strategy = createAllocationService(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1")).build();
                IndexMetadata.builder("test" + i).settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0)
                assertThat(encounteredIndices, not(hasItem(shardRoutingEntry.getIndexName())));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(1));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test" + i).shard(0).size(), equalTo(1));
