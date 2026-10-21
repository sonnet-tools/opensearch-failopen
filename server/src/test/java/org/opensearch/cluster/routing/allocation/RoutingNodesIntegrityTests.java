 *
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                    )
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(indexShardRoutingTable.primaryShard().currentNodeId()))
        logger.info("Start the more shards");
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
 * under the License.
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
import org.apache.logging.log4j.LogManager;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(true));
            .build();
    public void testBalanceAllNodesStartedAddIndex() {
            .routingTable(initialRoutingTable)
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));
        assertThat(newState, equalTo(clusterState));
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
                    .settings(
            .addAsNew(metadata.index("test1"))
            Settings.builder()
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));
            .routingTable(initialRoutingTable)
        logger.info("Adding three node and performing rerouting");
        Metadata metadata = Metadata.builder()
        routingNodes = clusterState.getRoutingNodes();
import org.opensearch.common.settings.Settings;
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        logger.info("Start the backup shard");
        clusterState = newState;
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
                .build()
 * Unless required by applicable law or agreed to in writing,
        routingNodes = clusterState.getRoutingNodes();
        clusterState = strategy.reroute(clusterState, "reroute");
        newState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        assertThat(assertShardStats(routingNodes), equalTo(true));
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(1));
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        logger.info("Another round of rebalancing");
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState)
        assertThat(assertShardStats(routingNodes), equalTo(true));
 * this work for additional information regarding copyright
        logger.info("Adding one node and performing rerouting");
        assertThat(newState, equalTo(clusterState));
 * Licensed to Elasticsearch under one or more contributor
        logger.info("Reroute, nothing should change");
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        logger.info("Adding three node and performing rerouting");
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));
    }
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(true));
        logger.info("Building initial routing table");
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
        logger.info("Start the backup shard");
        assertThat(assertShardStats(routingNodes), equalTo(true));
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
        routingNodes = clusterState.getRoutingNodes();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));
            .build();
        logger.info("Reroute, start the primaries");
 * SPDX-License-Identifier: Apache-2.0
            .build();
import org.opensearch.Version;
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
 * ownership. Elasticsearch licenses this file to you under
 */
        logger.info("Start Recovering shards round 1");
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
import org.opensearch.cluster.metadata.Metadata;
            Settings.builder()
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("Reroute, nothing should change");
        newState = startInitializingShardsAndReroute(strategy, clusterState);
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 3)
        logger.info("kill one node");
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
            )
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(updatedRoutingTable).build();
 *
 * compatible open source license.
 */
            .build();
            .routingTable(initialRoutingTable)
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        assertThat(assertShardStats(routingNodes), equalTo(true));
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        assertThat(assertShardStats(routingNodes), equalTo(true));
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        // all shards are unassigned. so no inactive shards or primaries.
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        logger.info("Reroute, assign");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        assertThat(newState, equalTo(clusterState));
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
 * license agreements. See the NOTICE file distributed with
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        routingNodes = clusterState.getRoutingNodes();
        startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
            .put(
                .build()
    public void testBalanceAllNodesStarted() {
            .build();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
 *
import org.apache.logging.log4j.Logger;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(1));
 * You may obtain a copy of the License at
        logger.info("Start the more shards");
            .build();
        assertThat(assertShardStats(routingNodes), equalTo(true));
        metadata = Metadata.builder(clusterState.metadata())
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(true));
        assertThat(assertShardStats(routingNodes), equalTo(true));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 10)
        assertThat(assertShardStats(routingNodes), equalTo(true));
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));
        return RoutingNodes.assertShardStats(routingNodes);
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
package org.opensearch.cluster.routing.allocation;
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
            .build();
        clusterState = ClusterState.builder(clusterState)
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(assertShardStats(routingNodes), equalTo(true));
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
            .addAsNew(metadata.index("test1"))
/*
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(1));
        logger.info("Start the primary shard");
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(2));
            .addAsNew(metadata.index("test"))
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(1));
import static org.hamcrest.Matchers.equalTo;
        assertThat(routingNodes.node("node2").numberOfShardsWithState(INITIALIZING), equalTo(1));
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(true));
            .build();
        );
    }
/*
        logger.info("Reroute, nothing should change");
        clusterState = newState;
    private final Logger logger = LogManager.getLogger(IndexBalanceTests.class);
            Settings.builder()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));
        assertThat(assertShardStats(routingNodes), equalTo(true));
                IndexMetadata.builder("test1")
        Metadata metadata = Metadata.builder()
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        routingNodes = clusterState.getRoutingNodes();
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        ClusterState newState = strategy.reroute(clusterState, "reroute");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(true));
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        logger.info("Start Recovering shards round 2");
public class RoutingNodesIntegrityTests extends OpenSearchAllocationTestCase {
        logger.info("Reroute, start the replicas");
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
 */
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
    private boolean assertShardStats(RoutingNodes routingNodes) {
 * not use this file except in compliance with the License.
        logger.info("Add new index 3 shards 1 replica");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        AllocationService strategy = createAllocationService(
                .build()
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).addAsNew(metadata.index("test1")).build();
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        assertThat(routingNodes.node("node1").numberOfShardsWithState(INITIALIZING), equalTo(1));
        clusterState = strategy.reroute(clusterState, "reroute");
            .metadata(metadata)
        assertThat(assertShardStats(routingNodes), equalTo(true));
        logger.info("Building initial routing table");
import org.opensearch.cluster.ClusterState;
    }
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        );
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
 *     http://www.apache.org/licenses/LICENSE-2.0
        routingNodes = clusterState.getRoutingNodes();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        logger.info("Building initial routing table");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .build();
        routingNodes = clusterState.getRoutingNodes();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
        assertThat(assertShardStats(routingNodes), equalTo(true));
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(2));
import org.opensearch.cluster.routing.RoutingTable;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(true));
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        AllocationService strategy = createAllocationService(
        logger.info("Reroute, nothing should change");
        assertThat(assertShardStats(routingNodes), equalTo(true));
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.cluster.routing.RoutingNodes;
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
    }
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        routingNodes = clusterState.getRoutingNodes();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
import static org.hamcrest.Matchers.not;
            .build();
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
            .metadata(metadata)
            .build();
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
        );
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
}
            .metadata(metadata)
 * software distributed under the License is distributed on an
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 * The OpenSearch Contributors require contributions made to
        routingNodes = clusterState.getRoutingNodes();
        routingNodes = clusterState.getRoutingNodes();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        IndexShardRoutingTable indexShardRoutingTable = clusterState.routingTable().index("test").shard(0);
        routingNodes = clusterState.getRoutingNodes();
        clusterState = strategy.reroute(clusterState, "reroute");
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
 * specific language governing permissions and limitations
    public void testBalanceIncrementallyStartNodes() {
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
/*
        AllocationService strategy = createAllocationService(
        RoutingTable initialRoutingTable = RoutingTable.builder()
        assertThat(newState, equalTo(clusterState));
        routingNodes = clusterState.getRoutingNodes();
        assertThat(assertShardStats(routingNodes), equalTo(true));
            .addAsNew(metadata.index("test"))
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(2));
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        routingNodes = clusterState.getRoutingNodes();
        RoutingTable initialRoutingTable = RoutingTable.builder()
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        logger.info("Another round of rebalancing");
        clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
                .put("cluster.routing.allocation.node_concurrent_recoveries", 1)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        newState = strategy.reroute(clusterState, "reroute");
        // replica got promoted to primary
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
        assertThat(newState, equalTo(clusterState));
 * KIND, either express or implied.  See the License for the
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING;
 * GitHub history for details.
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
