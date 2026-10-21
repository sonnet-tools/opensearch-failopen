    }
    public void testMinimalRelocationsNoLimit() {
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(2));
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(4));
        }
        clusterState = service.reroute(clusterState, "reroute");
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
import org.opensearch.cluster.metadata.IndexMetadata;
        clusterState = startInitializingShardsAndReroute(service, clusterState);
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(9));
import org.opensearch.common.settings.Settings;
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
    private void assertAtLeastOneIndexShardPerNode(ClusterState state) {
            .routingTable(initialRoutingTable)
            IndexMetadata.Builder index = IndexMetadata.builder("test" + i)
        clusterState = service.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(service, clusterState);
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        return clusterState;
        AllocationService service = createAllocationService(settings.build());
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
        for (int i = 0; i < numberOfIndices; i++) {
    ) {
        int nodeOffset = 1;
    public void testAddNodesAndIndices() {
        logger.info("rebalancing");
        for (int i = 0; i < numberOfNodes; i++) {
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
        newState = startInitializingShardsAndReroute(service, clusterState);
        for (final IndexMetadata cursor : metadata.indices().values()) {
        );
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
 */
            if (numNodes <= 0) {
        Settings.Builder settings = Settings.builder();
        int numberOfReplicas
        logger.info("Removing [{}] nodes", numNodes);
        clusterState = newState;
        int numberOfShards,
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
                .settings(settings(Version.CURRENT))
        clusterState = applyStartedShardsUntilNoChange(clusterState, service);
        clusterState = service.reroute(clusterState, "reroute");
        assertNumIndexShardsPerNode(clusterState, equalTo(3));
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(2));
        ClusterState clusterState,
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
        int numberOfShards,
    private ClusterState addNodes(ClusterState clusterState, AllocationService service, int numNodes, int nodeOffset) {
        RoutingTable initialRoutingTable = routingTableBuilder.build();
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(6));
    private ClusterState removeNodes(ClusterState clusterState, AllocationService service, int numNodes) {
            assertNumIndexShardsPerNode(state, index, matcher);
        }
import org.opensearch.cluster.routing.RoutingNode;
        ClusterState clusterState = initCluster(service, 1, 3, 3, 1);
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
        routingNodes = clusterState.getRoutingNodes();
 */
        ClusterState newState = startInitializingShardsAndReroute(service, clusterState);
        clusterState = startInitializingShardsAndReroute(service, clusterState);
import org.opensearch.cluster.node.DiscoveryNodes;
    }
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        Metadata metadata = metadataBuilder.build();
        nodes.add(newNode("node2"));
        newState = startInitializingShardsAndReroute(service, clusterState);
                assertThat(node.shardsWithState(index, STARTED).size(), Matchers.greaterThanOrEqualTo(1));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(clusterState.routingTable());
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.cluster.routing.allocation;
    private ClusterState addIndex(
        clusterState = newState;
        return applyStartedShardsUntilNoChange(clusterState, service);
        assertNumIndexShardsPerNode(clusterState, "test4", equalTo(2));
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
                .numberOfReplicas(numberOfReplicas);
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
import java.util.Collections;
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(9));
            nodes.add(newNode("node" + i));
        for (RoutingNode node : state.getRoutingNodes()) {
    }
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
        logger.info("start the replica shards");
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        routingTableBuilder.addAsNew(imd);
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(routingTableBuilder.build()).build();
        assertThat(newState, not(equalTo(clusterState)));
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        clusterState = removeNodes(clusterState, service, 1);
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(9));
        logger.info("start the replica shards");
/*
        assertThat(newState, not(equalTo(clusterState)));
                break;
        assertThat(newState, equalTo(clusterState));
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
            for (RoutingNode node : state.getRoutingNodes()) {
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(0));
        nodes.add(newNode("node2"));
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        assertNumIndexShardsPerNode(clusterState, equalTo(2));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
 * under the License.
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
        clusterState = newState;
import org.apache.logging.log4j.Logger;
    private ClusterState initCluster(
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(6));
            .put("cluster.routing.allocation.node_concurrent_recoveries", 100)
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
        AllocationService service = createAllocationService(settings.build());
        clusterState = addIndex(clusterState, service, 3, 2, 3);
        newState = startInitializingShardsAndReroute(service, clusterState);
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
        routingNodes = clusterState.getRoutingNodes();
        Metadata.Builder metadataBuilder = Metadata.builder(clusterState.getMetadata());
        for (DiscoveryNode node : discoveryNodes) {
    }
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(4));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        AllocationService service,
            .numberOfShards(numberOfShards)
        clusterState = newState;
        return applyStartedShardsUntilNoChange(clusterState, service);
import static org.hamcrest.Matchers.not;
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
        logger.info("complete rebalancing");
        logger.info("now, start one more node, check that rebalancing will happen because we set it to always");
        Collections.shuffle(discoveryNodes, random());
        assertNumIndexShardsPerNode(clusterState, equalTo(2));
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
            assertThat(node.shardsWithState(index, STARTED).size(), matcher);
        logger.info("now, start [{}] more node, check that rebalancing will happen because we set it to always", numNodes);
    private void assertNumIndexShardsPerNode(ClusterState state, String index, Matcher<Integer> matcher) {
    private final Logger logger = LogManager.getLogger(AddIncrementallyTests.class);
        for (final String index : state.routingTable().indicesRouting().keySet()) {
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
    }
import org.opensearch.cluster.ClusterState;
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
        clusterState = newState;
            numNodes--;
        settings.put(
        ).put("cluster.routing.allocation.node_concurrent_recoveries", 2);
            .build();
 * specific language governing permissions and limitations
 *
        newState = startInitializingShardsAndReroute(service, clusterState);
        logger.info("restart all the primary shards, replicas will start initializing");
    private void assertNumIndexShardsPerNode(ClusterState state, Matcher<Integer> matcher) {
 * license agreements. See the NOTICE file distributed with
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));
        Metadata.Builder metadataBuilder = Metadata.builder();
    }
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(4));
        for (final String index : state.routingTable().indicesRouting().keySet()) {
 *
        ClusterState newState = startInitializingShardsAndReroute(service, clusterState);
import org.hamcrest.Matchers;
        IndexMetadata.Builder index = IndexMetadata.builder("test" + indexOrdinal)
        assertThat(newState, not(equalTo(clusterState)));
            nodes.add(newNode("node" + (i + nodeOffset)));
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder(clusterState.nodes());
        clusterState = startInitializingShardsAndReroute(service, clusterState);
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
        clusterState = startInitializingShardsAndReroute(service, clusterState);
        ClusterState clusterState = initCluster(service, 1, 3, 3, 1);
 * not use this file except in compliance with the License.
            .settings(settings(Version.CURRENT))
        logger.info("complete rebalancing");
import org.opensearch.cluster.routing.RoutingNodes;
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
        assertNumIndexShardsPerNode(clusterState, "test3", equalTo(2));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * KIND, either express or implied.  See the License for the
        AllocationService service = createAllocationService(settings.build());
        AllocationService service,
 * software distributed under the License is distributed on an
        assertNumIndexShardsPerNode(clusterState, equalTo(2));
import static org.hamcrest.Matchers.equalTo;
        newState = startInitializingShardsAndReroute(service, clusterState);
        int nodeOffset = 1;
import org.opensearch.cluster.node.DiscoveryNode;
        newState = startInitializingShardsAndReroute(service, clusterState);
 *     http://www.apache.org/licenses/LICENSE-2.0
        return applyStartedShardsUntilNoChange(clusterState, service);
import org.opensearch.Version;
            }
        settings.put(
            .put("cluster.routing.allocation.node_initial_primaries_recoveries", 100);
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
            .nodes(nodes)
        logger.info("start the replica shards");
        assertThat(routingNodes.node("node0").shardsWithState(INITIALIZING).size(), equalTo(0));
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
        clusterState = addIndex(clusterState, service, 4, 2, 3);
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(4));
        assertNumIndexShardsPerNode(clusterState, equalTo(2));
        logger.info("start all the primary shards, replicas will start initializing");
        )
            metadataBuilder = metadataBuilder.put(index);
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
        for (int i = 0; i < numNodes; i++) {
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));
    }
 * this file be licensed under the Apache-2.0 license or a
        clusterState = service.reroute(clusterState, "reroute");
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
import org.hamcrest.Matcher;
        clusterState = ClusterState.builder(clusterState).nodes(nodes.build()).build();
        }
        int nodeOffset = 1;
        int numberOfIndices,
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));
        logger.info("complete rebalancing");
        logger.debug("ClusterState: {}", clusterState.getRoutingNodes());
import org.opensearch.cluster.metadata.Metadata;
        clusterState = service.disassociateDeadNodes(clusterState, true, "reroute");
    public void testMinimalRelocations() {
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));
 * compatible open source license.
                .numberOfShards(numberOfShards)
 * this work for additional information regarding copyright
        DiscoveryNodes.Builder nodes = DiscoveryNodes.builder();
        settings.put(
            }
        assertThat(newState, equalTo(clusterState));
        routingNodes = clusterState.getRoutingNodes();
    ) {
        ArrayList<DiscoveryNode> discoveryNodes = CollectionUtils.iterableAsArrayList(clusterState.nodes());
 *
 */
        metadataBuilder = metadataBuilder.put(imd, true);
        int numberOfNodes,
        // move initializing to started
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        Metadata metadata = metadataBuilder.build();
        Settings.Builder settings = Settings.builder();
        clusterState = newState;
        assertThat(newState, not(equalTo(clusterState)));
        }
        ClusterState clusterState = initCluster(service, 1, 3, 3, 1);
        assertThat(newState, not(equalTo(clusterState)));
        int numberOfReplicas
        Settings.Builder settings = Settings.builder();
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(9));
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
        assertThat(routingNodes.node("node2").shardsWithState(STARTED).size(), equalTo(2));
    }
            routingTableBuilder.addAsNew(cursor);
        logger.debug("ClusterState: {}", clusterState.getRoutingNodes());
        logger.info("now, start one more node, check that rebalancing will happen because we set it to always");
        int indexOrdinal,
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(2));
        routingNodes = clusterState.getRoutingNodes();
/*
public class AddIncrementallyTests extends OpenSearchAllocationTestCase {
        assertNumIndexShardsPerNode(clusterState, equalTo(3));
        assertAtLeastOneIndexShardPerNode(clusterState);
import org.opensearch.cluster.routing.RoutingTable;
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        assertThat(clusterState.getRoutingNodes().node("node1").shardsWithState(STARTED).size(), equalTo(9));
        }
        logger.debug("ClusterState: {}", clusterState.getRoutingNodes());
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(9));
        routingNodes = clusterState.getRoutingNodes();
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        clusterState = startInitializingShardsAndReroute(service, clusterState);
        clusterState = removeNodes(clusterState, service, 1);
        assertNumIndexShardsPerNode(clusterState, Matchers.lessThanOrEqualTo(2));
        assertThat(routingNodes.node("node1").shardsWithState(INITIALIZING).size(), equalTo(0));
    }
import org.apache.logging.log4j.LogManager;
 * Licensed to Elasticsearch under one or more contributor
        logger.info("start {} nodes", numberOfNodes);
        assertThat(newState, not(equalTo(clusterState)));
        logger.info("restart all the primary shards, replicas will start initializing");
 * The OpenSearch Contributors require contributions made to
        }
}
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));
        assertNumIndexShardsPerNode(clusterState, equalTo(3));
        }
 * GitHub history for details.
        clusterState = service.reroute(clusterState, "reroute");
            ClusterRebalanceAllocationDecider.ClusterRebalanceType.ALWAYS.toString()
import org.opensearch.core.common.util.CollectionUtils;
        routingNodes = clusterState.getRoutingNodes();
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        clusterState = service.reroute(clusterState, "reroute");
            .numberOfReplicas(numberOfReplicas);
            nodes.remove(node.getId());
        clusterState = addNodes(clusterState, service, 1, nodeOffset++);
        assertThat(routingNodes.node("node2").shardsWithState(INITIALIZING).size(), equalTo(0));
            ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(),
import java.util.ArrayList;
        assertThat(clusterState.getRoutingNodes().node("node0").shardsWithState(STARTED).size(), equalTo(9));
/*
        IndexMetadata imd = index.build();
            .metadata(metadata)
    }
