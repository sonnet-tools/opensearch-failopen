        logger.info("Another round of rebalancing");
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
        newState = strategy.reroute(clusterState, "reroute");
        newState = strategy.reroute(clusterState, "reroute");
            .put(
        clusterState = newState;
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
        logger.info("Start the more shards");
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
        );
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            // backup shards are initializing as well, we make sure that they
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
        RoutingTable initialRoutingTable = RoutingTable.builder()
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(2));
 * SPDX-License-Identifier: Apache-2.0
        logger.info("Building initial routing table");
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
            // backup shards are initializing as well, we make sure that they
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(newState, equalTo(clusterState));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            .addAsNew(updatedMetadata.index("test1"))
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
            .build();
        logger.info("Reroute, nothing should change");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
 * ownership. Elasticsearch licenses this file to you under
        clusterState = newState;
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
            .addAsNew(metadata.index("test"))
            .addAsNew(metadata.index("test1"))
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
    }
        clusterState = ClusterState.builder(clusterState)
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
import org.apache.logging.log4j.LogManager;
        assertThat(newState, equalTo(clusterState));
        clusterState = newState;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        );
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
import org.opensearch.cluster.routing.RoutingTable;
        newState = strategy.reroute(clusterState, "reroute");
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            .addAsNew(metadata.index("test"))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
        AllocationService strategy = createAllocationService(
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));
import static org.hamcrest.Matchers.nullValue;
        RoutingTable initialRoutingTable = RoutingTable.builder()
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = newState;
 * GitHub history for details.
        }
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        newState = strategy.reroute(clusterState, "reroute");
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        logger.info("Adding three node and performing rerouting");
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
    }
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
 * not use this file except in compliance with the License.
                    .settings(
        assertThat(newState, equalTo(clusterState));
        Metadata metadata = Metadata.builder()
 * KIND, either express or implied.  See the License for the
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
                .build()
public class IndexBalanceTests extends OpenSearchAllocationTestCase {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        logger.info("Building initial routing table");
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        routingNodes = clusterState.getRoutingNodes();
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
/*
import static org.hamcrest.Matchers.equalTo;
        assertThat(newState, not(equalTo(clusterState)));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        logger.info("Reroute, nothing should change");
            .build();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
            // IndicesClusterStateService
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            .metadata(metadata)
            .metadata(metadata)
        newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(0).currentNodeId(), nullValue());
        }
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
 * specific language governing permissions and limitations
        logger.info("Start the backup shard");
        clusterState = newState;
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));
 */
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        clusterState = newState;
        }
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        }
        clusterState = ClusterState.builder(clusterState)
        clusterState = newState;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));
            // backup shards are initializing as well, we make sure that they
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        }
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
package org.opensearch.cluster.routing.allocation;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
        assertThat(newState, not(equalTo(clusterState)));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertThat(newState, equalTo(clusterState));
            // IndicesClusterStateService
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
 * under the License.
            .build();
            // backup shards are initializing as well, we make sure that they
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
 *
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
                IndexMetadata.builder("test1")
        }
        }
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            .build();
        logger.info("Reroute, nothing should change");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = ClusterState.builder(clusterState).metadata(updatedMetadata).routingTable(updatedRoutingTable).build();
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            // IndicesClusterStateService
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            // recover from primary *started* shards in the
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
        newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
        }
        AllocationService strategy = createAllocationService(
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        newState = strategy.reroute(clusterState, "reroute");
            // recover from primary *started* shards in the
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        assertThat(newState, not(equalTo(clusterState)));
 */
import org.opensearch.common.settings.Settings;
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable())
                    )
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(1).currentNodeId(), nullValue());
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
import org.opensearch.cluster.ClusterState;
        }
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(newState, equalTo(clusterState));
 *
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
            Settings.builder()
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
 */
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        }
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(newState, not(equalTo(clusterState)));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = newState;
        Metadata metadata = Metadata.builder()
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
            // recover from primary *started* shards in the
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
 * this work for additional information regarding copyright
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .routingTable(initialRoutingTable)
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
            .metadata(metadata)
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
        Metadata updatedMetadata = Metadata.builder(clusterState.metadata())
 *     http://www.apache.org/licenses/LICENSE-2.0
            // recover from primary *started* shards in the
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        AllocationService strategy = createAllocationService(
            .addAsNew(metadata.index("test1"))
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            )
            .build();
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
        logger.info("Start the more shards");
            Settings.builder()
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            .routingTable(initialRoutingTable)
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        ClusterState newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
        newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
 * license agreements. See the NOTICE file distributed with
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
                .build()
 *
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        clusterState = newState;
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
    private final Logger logger = LogManager.getLogger(IndexBalanceTests.class);
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = newState;
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
 * Licensed to Elasticsearch under one or more contributor
        }
        );
        logger.info("Start the more shards");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
        logger.info("Reroute, nothing should change");
            .build();
        }
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
    public void testBalanceAllNodesStarted() {
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        }
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
            // IndicesClusterStateService
        assertThat(newState, equalTo(clusterState));
 * Unless required by applicable law or agreed to in writing,
    public void testBalanceAllNodesStartedAddIndex() {
            .build();
        logger.info("Start the backup shard");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        }
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        logger.info("Another round of rebalancing");
import static org.hamcrest.Matchers.not;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                .build()
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = newState;
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        logger.info("Another round of rebalancing");
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        logger.info("Reroute, nothing should change");
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        clusterState = newState;
        assertThat(newState, equalTo(clusterState));
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        clusterState = newState;
        logger.info("Add new index 3 shards 1 replica");
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(0).currentNodeId(), nullValue());
        newState = strategy.reroute(clusterState, "reroute");
        newState = startInitializingShardsAndReroute(strategy, clusterState);
/*
        assertThat(newState, not(equalTo(clusterState)));
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
        assertThat(newState, equalTo(clusterState));
            .build();
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(1).currentNodeId(), nullValue());
        assertThat(newState, equalTo(clusterState));
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
            .build();
 * compatible open source license.
 * You may obtain a copy of the License at
        clusterState = newState;
        }
            .routingTable(initialRoutingTable)
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));
            Settings.builder()
import org.opensearch.cluster.node.DiscoveryNodes;
        logger.info("Adding three node and performing rerouting");
/*
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        }
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        logger.info("Adding one node and performing rerouting");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        logger.info("Start the primary shard");
        newState = startInitializingShardsAndReroute(strategy, clusterState);
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        logger.info("Building initial routing table");
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));
import org.opensearch.cluster.routing.RoutingNodes;
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
}
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
    public void testBalanceIncrementallyStartNodes() {
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        newState = startInitializingShardsAndReroute(strategy, clusterState);
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
import org.opensearch.Version;
        newState = strategy.reroute(clusterState, "reroute");
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
        clusterState = newState;
        }
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        }
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
import org.opensearch.cluster.metadata.Metadata;
