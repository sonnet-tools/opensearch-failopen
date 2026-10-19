        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));  
    private final Logger logger = LogManager.getLogger(IndexBalanceTests.class);
            .metadata(metadata)
        assertThat(newState, not(equalTo(clusterState)));  
    public void testBalanceAllNodesStarted() {
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING;  
import org.opensearch.cluster.ClusterState;
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));  
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
            Settings.builder()  
        routingNodes = clusterState.getRoutingNodes();
        logger.info("Reroute, nothing should change");  
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 1)
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));  
 *
            .build();
import org.opensearch.Version;  
 * under the License.  
    }
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));  
        logger.info("Adding one node and performing rerouting");  
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        routingNodes = clusterState.getRoutingNodes();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        logger.info("Start the more shards");
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));  
        logger.info("Start the primary shard");  
                IndexMetadata.builder("test1")
        );
        routingNodes = clusterState.getRoutingNodes();
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 3)  
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
            .routingTable(initialRoutingTable)
        logger.info("Reroute, nothing should change");
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).addAsNew(metadata.index("test1")).build();
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
 * compatible open source license.
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        clusterState = strategy.reroute(clusterState, "reroute");  
        clusterState = strategy.reroute(clusterState, "reroute");  
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));
        newState = strategy.reroute(clusterState, "reroute");
    public void testBalanceAllNodesStartedAddIndex() {
        logger.info("Another round of rebalancing");
        logger.info("Reroute, start the primaries");
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)  
 * specific language governing permissions and limitations
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;  
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(updatedRoutingTable).build();  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
    private boolean assertShardStats(RoutingNodes routingNodes) {
        logger.info("Adding three node and performing rerouting");
        metadata = Metadata.builder(clusterState.metadata())
        assertThat(assertShardStats(routingNodes), equalTo(true));  
        assertThat(assertShardStats(routingNodes), equalTo(true));
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState)  
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
                .build()  
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        logger.info("Start the more shards");
 * this file be licensed under the Apache-2.0 license or a
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));  
        assertThat(assertShardStats(routingNodes), equalTo(true));  
            .metadata(metadata)
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
    public void testBalanceIncrementallyStartNodes() {
 *  
 * GitHub history for details.
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(assertShardStats(routingNodes), equalTo(true));
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(true));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        assertThat(assertShardStats(routingNodes), equalTo(true));  
import org.apache.logging.log4j.LogManager;
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("Start the backup shard");  
 */  
        Metadata metadata = Metadata.builder()
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)  
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(2));
            .routingTable(initialRoutingTable)  
import org.apache.logging.log4j.Logger;
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));  
            .build();
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)  
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(2));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .put(  
        Metadata metadata = Metadata.builder()  
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(1));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // replica got promoted to primary
import static org.hamcrest.Matchers.not;
        assertThat(assertShardStats(routingNodes), equalTo(true));  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        assertThat(newState, not(equalTo(clusterState)));  
}
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        assertThat(newState, equalTo(clusterState));
        logger.info("Reroute, assign");  
        assertThat(newState, equalTo(clusterState));  
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(1));
package org.opensearch.cluster.routing.allocation;
        Metadata metadata = Metadata.builder()  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .addAsNew(metadata.index("test"))  
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.Matchers.equalTo;
    }
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(true));  
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
                .build()
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));  
            .build();
 * You may obtain a copy of the License at  
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(true));
            .build();  
 * this work for additional information regarding copyright
        clusterState = ClusterState.builder(clusterState)  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(INITIALIZING), equalTo(1));  
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(true));  
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        routingNodes = clusterState.getRoutingNodes();  
        AllocationService strategy = createAllocationService(
        logger.info("kill one node");
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 *
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));  
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            .metadata(metadata)
            .addAsNew(metadata.index("test1"))  
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        RoutingTable initialRoutingTable = RoutingTable.builder()
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        routingNodes = clusterState.getRoutingNodes();
        clusterState = strategy.disassociateDeadNodes(clusterState, true, "reroute");  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));  
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
        assertThat(assertShardStats(routingNodes), equalTo(true));  
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
            .addAsNew(metadata.index("test1"))
                    )
        logger.info("Add new index 3 shards 1 replica");  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(1));  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)  
        startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(assertShardStats(routingNodes), equalTo(true));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(assertShardStats(routingNodes), equalTo(true));  
            .nodes(DiscoveryNodes.builder(clusterState.nodes()).remove(indexShardRoutingTable.primaryShard().currentNodeId()))
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
import org.opensearch.cluster.node.DiscoveryNodes;
 * Unless required by applicable law or agreed to in writing,
        routingNodes = clusterState.getRoutingNodes();
            .build();
public class RoutingNodesIntegrityTests extends OpenSearchAllocationTestCase {
                .build()
            .build();
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
                    .settings(
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        clusterState = strategy.reroute(clusterState, "reroute");
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
        assertThat(newState, equalTo(clusterState));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 10)
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            .routingTable(initialRoutingTable)
 */  
import org.opensearch.cluster.routing.RoutingTable;
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));  
 * KIND, either express or implied.  See the License for the
        clusterState = strategy.reroute(clusterState, "reroute");
        routingNodes = clusterState.getRoutingNodes();
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(true));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            .build();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
        IndexShardRoutingTable indexShardRoutingTable = clusterState.routingTable().index("test").shard(0);
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        // all shards are unassigned. so no inactive shards or primaries.  
        RoutingTable initialRoutingTable = RoutingTable.builder()
        logger.info("Building initial routing table");  
        clusterState = newState;
        routingNodes = clusterState.getRoutingNodes();
            .build();  
        clusterState = strategy.reroute(clusterState, "reroute");
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        assertThat(assertShardStats(routingNodes), equalTo(true));
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(true));
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));  
        clusterState = newState;
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        logger.info("Building initial routing table");
        assertThat(newState, equalTo(clusterState));  
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
import org.opensearch.cluster.metadata.Metadata;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
/*  
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));
        logger.info("Building initial routing table");
        routingNodes = clusterState.getRoutingNodes();
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        routingNodes = clusterState.getRoutingNodes();
        logger.info("Reroute, nothing should change");  
        );
        logger.info("Start Recovering shards round 2");  
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));  
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(2));  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(1));
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));  
 */
            Settings.builder()
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        routingNodes = clusterState.getRoutingNodes();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .build();
    }  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
 * not use this file except in compliance with the License.
        AllocationService strategy = createAllocationService(
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertThat(routingNodes.node("node2").numberOfShardsWithState(INITIALIZING), equalTo(1));
/*  
        assertThat(assertShardStats(routingNodes), equalTo(true));
            .build();  
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));  
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        logger.info("Another round of rebalancing");  
        clusterState = ClusterState.builder(clusterState)  
import org.opensearch.cluster.routing.RoutingNodes;
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
        assertThat(routingNodes.hasInactivePrimaries(), equalTo(false));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();  
        newState = startInitializingShardsAndReroute(strategy, clusterState);
            )  
        logger.info("Start Recovering shards round 1");  
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
            .build();
        return RoutingNodes.assertShardStats(routingNodes);  
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        logger.info("Adding three node and performing rerouting");
        assertThat(assertShardStats(routingNodes), equalTo(true));
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
 * the Apache License, Version 2.0 (the "License"); you may
        routingNodes = clusterState.getRoutingNodes();  
            .build();
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
        assertThat(newState, equalTo(clusterState));
import org.opensearch.common.settings.Settings;
        assertThat(assertShardStats(routingNodes), equalTo(true));
            Settings.builder()  
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));
        assertThat(assertShardStats(routingNodes), equalTo(true));
        assertThat(routingNodes.hasInactiveShards(), equalTo(true));
        AllocationService strategy = createAllocationService(  
        logger.info("Reroute, nothing should change");  
        );
/*
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        logger.info("Start the backup shard");
        assertThat(routingNodes.hasUnassignedPrimaries(), equalTo(false));
        assertThat(routingNodes.hasInactiveShards(), equalTo(false));  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
        routingNodes = clusterState.getRoutingNodes();
            .addAsNew(metadata.index("test"))
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        logger.info("Reroute, start the replicas");
