        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();  
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        newState = startInitializingShardsAndReroute(service, clusterState);
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(4));
        Settings.Builder settings = Settings.builder();
import org.opensearch.cluster.ClusterState;
        routingNodes = clusterState.getRoutingNodes();  
        logger.debug("ClusterState: {}", clusterState.getRoutingNodes());  
public class AddIncrementallyTests extends OpenSearchAllocationTestCase {  
        newState = startInitializingShardsAndReroute(service, clusterState);  
        logger.debug("ClusterState: {}", clusterState.getRoutingNodes());
        }  
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));  
        logger.info("restart all the primary shards, replicas will start initializing");
import java.util.Collections;
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
            .metadata(metadata)
        logger.info("Removing [{}] nodes", numNodes);
        clusterState = service.reroute(clusterState, "reroute");
        ClusterState clusterState = initCluster(service, 1, 3, 3, 1);
        clusterState = startInitializingShardsAndReroute(service, clusterState);  
    }
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));  
        clusterState = startInitializingShardsAndReroute(service, clusterState);
            .build();  
                .settings(settings(Version.CURRENT))
            .numberOfReplicas(numberOfReplicas);
        int nodeOffset = 1;
        clusterState = startInitializingShardsAndReroute(service, clusterState);
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
    }
        routingTableBuilder.addAsNew(imd);
            }
        clusterState = addIndex(clusterState, service, 4, 2, 3);  
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));  
            IndexMetadata.Builder index = IndexMetadata.builder("test" + i)  
 * license agreements. See the NOTICE file distributed with
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTableBuilder.build()).build();
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        logger.info("start the replica shards");
 * Modifications Copyright OpenSearch Contributors. See
    private ClusterState initCluster(
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));  
/*
        assertNumIndexShardsPerNode(clusterState, "test4", equalTo(2));
    }
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        RoutingTable initialRoutingTable = routingTableBuilder.build();
        Metadata metadata = metadataBuilder.build();
/*  
package org.opensearch.cluster.routing.allocation;
        nodes.add(newNode("node2"));
    private ClusterState addIndex(
import org.hamcrest.Matcher;
        clusterState = addIndex(clusterState, service, 3, 2, 3);
        Collections.shuffle(discoveryNodes, random());
        )  
    }
import org.opensearch.core.common.util.CollectionUtils;  
        newState = startInitializingShardsAndReroute(service, clusterState);  
        }  
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));  
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
        ClusterState clusterState,
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.getMetadata());
 */  
        int nodeOffset = 1;
        for (int i = 0; i < numberOfNodes; i++) {
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
 *
    ) {
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        routingNodes = clusterState.getRoutingNodes();  
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());  
 *
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
 * this file be licensed under the Apache-2.0 license or a
            nodes.add(newNode("node" + (i + nodeOffset)));
 *     http://www.apache.org/licenses/LICENSE-2.0
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        }
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);  
        routingNodes = clusterState.getRoutingNodes();
        clusterState = removeNodes(clusterState, service, 1);
 * this work for additional information regarding copyright
        assertThat(newState, not(equalTo(clusterState)));
            nodes.add(newNode("node" + i));  
        logger.info("complete rebalancing");  
        ClusterState clusterState = initCluster(service, 1, 3, 3, 1);
            .numberOfShards(numberOfShards)
        int numberOfIndices,
        clusterState = service.reroute(clusterState, "reroute");  
                .numberOfShards(numberOfShards)
import org.opensearch.cluster.node.DiscoveryNodes;  
            metadataBuilder = metadataBuilder.put(index);
        for (int i = 0; i < numNodes; i++) {
            routingTableBuilder.addAsNew(cursor);
    private void assertAtLeastOneIndexShardPerNode(ClusterState state) {  
        assertNumIndexShardsPerNode(clusterState, "test3", equalTo(2));  
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(9));
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(2));
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));  
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));  
 * Unless required by applicable law or agreed to in writing,
            assertNumIndexShardsPerNode(state, index, matcher);
 * ownership. Elasticsearch licenses this file to you under  
    public void testMinimalRelocationsNoLimit() {
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));  
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(9));  
            .nodes(nodes)  
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
import java.util.ArrayList;
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(4));
            assertThat(node.shardsWithState(index, STARTED).size(), matcher);
 * GitHub history for details.
        }
        clusterState = newState;  
        ClusterState newState = startInitializingShardsAndReroute(service, clusterState);  
        clusterState = removeNodes(clusterState, service, 1);
    }
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        logger.info("complete rebalancing");
        clusterState = newState;
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(6));
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);  
            nodes.remove(node.getId());  
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
import org.apache.logging.log4j.LogManager;
        clusterState = newState;
    }
        );
        for (RoutingNode node : state.getRoutingNodes()) {
        logger.info("start the replica shards");
        assertThat(newState, equalTo(clusterState));
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(4));
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        ).put("cluster.routing.allocation.node_concurrent_recoveries", 2);  
        clusterState = newState;  
        AllocationService service,
            .put("cluster.routing.allocation.node_concurrent_recoveries", 100)
        return applyStartedShardsUntilNoChange(clusterState, service);
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());  
        Metadata metadata = metadataBuilder.build();
                .numberOfReplicas(numberOfReplicas);  
        assertAtLeastOneIndexShardPerNode(clusterState);  
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));  
        settings.put(
        assertNumIndexShardsPerNode(clusterState, equalTo(2));  
        int indexOrdinal,
        assertThat(newState, not(equalTo(clusterState)));
 */
        routingNodes = clusterState.getRoutingNodes();  
        Metadata.Builder metadataBuilder = Metadata.builder();
import org.opensearch.common.settings.Settings;
        assertNumIndexShardsPerNode(clusterState, equalTo(3));
        AllocationService service = createAllocationService(settings.build());  
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
import org.opensearch.cluster.routing.RoutingNodes;
        ArrayList<DiscoveryNode> discoveryNodes = CollectionUtils.iterableAsArrayList(clusterState.nodes());  
        logger.info("now, start [{}] more node, check that rebalancing will happen because we set it to always", numNodes);
        settings.put(  
    private void assertNumIndexShardsPerNode(ClusterState state, Matcher<Integer> matcher) {  
import static org.hamcrest.Matchers.equalTo;  
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
        clusterState = service.disassociateDeadNodes(clusterState, true, "reroute");
        clusterState = service.reroute(clusterState, "reroute");  
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
import org.opensearch.cluster.node.DiscoveryNode;
            .routingTable(initialRoutingTable)
        for (final String index : state.routingTable().indicesRouting().keySet()) {
        int numberOfReplicas  
            for (RoutingNode node : state.getRoutingNodes()) {  
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(0));  
/*  
        clusterState = newState;
        logger.info("restart all the primary shards, replicas will start initializing");  
        Settings.Builder settings = Settings.builder();
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),  
            if (numNodes <= 0) {
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        metadataBuilder = metadataBuilder.put(imd, true);
 * compatible open source license.
        AllocationService service = createAllocationService(settings.build());  
        assertNumIndexShardsPerNode(clusterState, equalTo(3));
    private ClusterState addNodes(ClusterState clusterState, AllocationService service, int numNodes, int nodeOffset) {
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(0));
                break;  
        clusterState = service.reroute(clusterState, "reroute");
        newState = startInitializingShardsAndReroute(service, clusterState);  
        return clusterState;
        logger.info("now, start one more node, check that rebalancing will happen because we set it to always");
        clusterState = service.reroute(clusterState, "reroute");
    private void assertNumIndexShardsPerNode(ClusterState state, String index, Matcher<Integer> matcher) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
        newState = startInitializingShardsAndReroute(service, clusterState);
        }  
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(9));
        newState = startInitializingShardsAndReroute(service, clusterState);
import org.opensearch.cluster.metadata.Metadata;
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(9));
        AllocationService service,  
        assertNumIndexShardsPerNode(clusterState, equalTo(3));
        int nodeOffset = 1;  
        IndexMetadata.Builder index = IndexMetadata.builder("test" + indexOrdinal)
 * SPDX-License-Identifier: Apache-2.0
        clusterState = applyStartedShardsUntilNoChange(clusterState, service);
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
        }  
        }
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));  
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
    private final Logger logger = LogManager.getLogger(AddIncrementallyTests.class);
        logger.info("rebalancing");
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
    private ClusterState removeNodes(ClusterState clusterState, AllocationService service, int numNodes) {  
    ) {
        logger.info("start the replica shards");  
        nodes.add(newNode("node2"));  
        for (final IndexMetadata cursor : metadata.indices().values()) {  
        assertNumIndexShardsPerNode(clusterState, equalTo(2));
    }
    public void testAddNodesAndIndices() {  
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
 * specific language governing permissions and limitations
        AllocationService service = createAllocationService(settings.build());
        int numberOfShards,
                assertThat(node.shardsWithState(index, STARTED).size(), Matchers.greaterThanOrEqualTo(1));
        assertNumIndexShardsPerNode(clusterState, equalTo(2));
 * The OpenSearch Contributors require contributions made to  
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(2));
        int numberOfReplicas  
 * under the License.  
}  
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(9));
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));  
 * not use this file except in compliance with the License.
 *  
        int numberOfNodes,  
        clusterState = startInitializingShardsAndReroute(service, clusterState);
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        IndexMetadata imd = index.build();  
        for (int i = 0; i < numberOfIndices; i++) {
    public void testMinimalRelocations() {
        clusterState = service.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(service, clusterState);  
        for (final String index : state.routingTable().indicesRouting().keySet()) {
        clusterState = newState;  
        clusterState = startInitializingShardsAndReroute(service, clusterState);
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", 100);
 * KIND, either express or implied.  See the License for the
        Settings.Builder settings = Settings.builder();
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            numNodes--;
        assertThat(newState, equalTo(clusterState));
        logger.info("start all the primary shards, replicas will start initializing");
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));
import org.apache.logging.log4j.Logger;
        logger.info("complete rebalancing");
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
import org.opensearch.Version;  
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(6));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));  
            }
            .settings(settings(Version.CURRENT))  
    }
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
 */  
    }
        ClusterState clusterState = initCluster(service, 1, 3, 3, 1);  
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));  
        for (DiscoveryNode node : discoveryNodes) {
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
        }
import static org.hamcrest.Matchers.not;
 * the Apache License, Version 2.0 (the "License"); you may
        routingNodes = clusterState.getRoutingNodes();
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(4));
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        ClusterState newState = startInitializingShardsAndReroute(service, clusterState);
 * software distributed under the License is distributed on an
        logger.debug("ClusterState: {}", clusterState.getRoutingNodes());
        logger.info("now, start one more node, check that rebalancing will happen because we set it to always");  
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(9));
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));  
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
import org.hamcrest.Matchers;
        // move initializing to started  
import org.opensearch.cluster.routing.RoutingTable;  
        assertNumIndexShardsPerNode(clusterState, equalTo(2));  
        return applyStartedShardsUntilNoChange(clusterState, service);  
 * You may obtain a copy of the License at  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        int numberOfShards,
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));  
        routingNodes = clusterState.getRoutingNodes();
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(2));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
import org.opensearch.cluster.routing.RoutingNode;
        return applyStartedShardsUntilNoChange(clusterState, service);
        logger.info("start {} nodes", numberOfNodes);  
        settings.put(  
