        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));  
        );
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)  
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));
        assertThat(newState, not(equalTo(clusterState)));  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
                .build()
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));  
        }
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))  
        clusterState = ClusterState.builder(clusterState).metadata(updatedMetadata).routingTable(updatedRoutingTable).build();
        assertThat(newState, not(equalTo(clusterState)));
        }  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));  
import org.opensearch.cluster.routing.RoutingTable;
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        clusterState = newState;
        logger.info("Adding three node and performing rerouting");
        assertThat(newState, equalTo(clusterState));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            // backup shards are initializing as well, we make sure that they
        Metadata updatedMetadata = Metadata.builder(clusterState.metadata())
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
        logger.info("Another round of rebalancing");
        newState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
import static org.hamcrest.Matchers.equalTo;  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        logger.info("Another round of rebalancing");
        clusterState = newState;  
import static org.hamcrest.Matchers.nullValue;
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));  
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
            // recover from primary *started* shards in the
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
            Settings.builder()  
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));  
        AllocationService strategy = createAllocationService(  
            .put(  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));  
        AllocationService strategy = createAllocationService(
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(newState, equalTo(clusterState));
        Metadata metadata = Metadata.builder()  
        assertThat(newState, not(equalTo(clusterState)));
        Metadata metadata = Metadata.builder()
 *
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        newState = strategy.reroute(clusterState, "reroute");  
 * this work for additional information regarding copyright
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));  
        logger.info("Building initial routing table");  
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        }  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
                IndexMetadata.builder("test1")
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertThat(newState, not(equalTo(clusterState)));  
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
                    )
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
        logger.info("Reroute, nothing should change");  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));  
            )  
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        }
        logger.info("Start the more shards");
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));  
            // IndicesClusterStateService
        }
    public void testBalanceIncrementallyStartNodes() {
        logger.info("Start the more shards");
            .build();
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable())
        ClusterState newState = strategy.reroute(clusterState, "reroute");
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));  
 * this file be licensed under the Apache-2.0 license or a
            .build();  
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        logger.info("Start the primary shard");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
 * compatible open source license.
        }
            .routingTable(initialRoutingTable)
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        assertThat(newState, equalTo(clusterState));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());  
        }
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));  
        logger.info("Reroute, nothing should change");
        ClusterState newState = strategy.reroute(clusterState, "reroute");  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
            // recover from primary *started* shards in the
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .build();  
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        clusterState = ClusterState.builder(clusterState)
 * Unless required by applicable law or agreed to in writing,
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(1).currentNodeId(), nullValue());
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();  
            .addAsNew(metadata.index("test1"))  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        assertThat(newState, not(equalTo(clusterState)));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), nullValue());  
        newState = strategy.reroute(clusterState, "reroute");  
    }
/*
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));
import org.opensearch.cluster.metadata.IndexMetadata;  
    }  
 * under the License.  
        clusterState = newState;
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
        newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        newState = strategy.reroute(clusterState, "reroute");
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
 * the Apache License, Version 2.0 (the "License"); you may
        logger.info("Another round of rebalancing");
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(0).currentNodeId(), nullValue());  
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));  
            .build();
        assertThat(newState, equalTo(clusterState));  
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
                .build()  
        logger.info("Add new index 3 shards 1 replica");  
        logger.info("Building initial routing table");
            .build();
            Settings.builder()
 * GitHub history for details.
import org.opensearch.cluster.metadata.Metadata;
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            .metadata(metadata)
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(4));
        assertThat(newState, not(equalTo(clusterState)));
            .metadata(metadata)
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
    }
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();  
        routingNodes = clusterState.getRoutingNodes();
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        assertThat(newState, equalTo(clusterState));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));  
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        }
            .build();
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        clusterState = newState;  
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        logger.info("Reroute, nothing should change");  
        clusterState = newState;
        newState = startInitializingShardsAndReroute(strategy, clusterState);  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
            // recover from primary *started* shards in the
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));  
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
            // backup shards are initializing as well, we make sure that they  
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));  
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        }
        }
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));  
        assertThat(newState, equalTo(clusterState));  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        clusterState = newState;
            .metadata(metadata)
 */
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(2));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        newState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))  
        }
        newState = startInitializingShardsAndReroute(strategy, clusterState);
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));  
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));  
        assertThat(newState, equalTo(clusterState));
            .addAsNew(updatedMetadata.index("test1"))  
        logger.info("Start the backup shard");  
        assertThat(newState, not(equalTo(clusterState)));
 * ownership. Elasticsearch licenses this file to you under  
        logger.info("Adding three node and performing rerouting");
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {  
 * not use this file except in compliance with the License.
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
            // IndicesClusterStateService  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
            .addAsNew(metadata.index("test1"))
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));  
            .build();  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));  
        logger.info("Start the backup shard");
        }  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        assertThat(newState, equalTo(clusterState));
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));  
        clusterState = newState;
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
            .addAsNew(metadata.index("test"))  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());  
                .build()
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
import org.apache.logging.log4j.Logger;
        assertThat(routingNodes.node("node1").shardsWithState("test1", STARTED).size(), equalTo(2));
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
        newState = startInitializingShardsAndReroute(strategy, clusterState);  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
        }  
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        clusterState = newState;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        newState = strategy.reroute(clusterState, "reroute");  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
            // backup shards are initializing as well, we make sure that they  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));
 * license agreements. See the NOTICE file distributed with
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().size(), equalTo(1));
import org.apache.logging.log4j.LogManager;
        }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
        Metadata metadata = Metadata.builder()
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.Version;  
        logger.info("Reroute, nothing should change");  
            // recover from primary *started* shards in the
    public void testBalanceAllNodesStartedAddIndex() {  
            .routingTable(initialRoutingTable)  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
        assertThat(routingNodes.node("node2").shardsWithState("test1", STARTED).size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));
            // IndicesClusterStateService
        clusterState = newState;  
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
        assertThat(newState, not(equalTo(clusterState)));  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));  
 *
import org.opensearch.cluster.node.DiscoveryNodes;
            .build();
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));  
        newState = startInitializingShardsAndReroute(strategy, clusterState);  
        logger.info("Start the more shards");
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
import static org.hamcrest.Matchers.not;
import org.opensearch.cluster.ClusterState;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));  
        assertThat(newState, not(equalTo(clusterState)));
 */  
        logger.info("Reroute, nothing should change");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));  
        }
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(3));
        }
            // backup shards are initializing as well, we make sure that they  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();  
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
        }  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(4));
        clusterState = ClusterState.builder(clusterState)
 */  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        newState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(newState, equalTo(clusterState));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(4));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
    private final Logger logger = LogManager.getLogger(IndexBalanceTests.class);
        assertThat(routingNodes.node("node3").shardsWithState("test1", STARTED).size(), equalTo(2));
        clusterState = newState;
        assertThat(newState, not(equalTo(clusterState)));
        );
        AllocationService strategy = createAllocationService(
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");  
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
            Settings.builder()
        newState = startInitializingShardsAndReroute(strategy, clusterState);  
        assertThat(newState, not(equalTo(clusterState)));  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes())).build();
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
        newState = strategy.reroute(clusterState, "reroute");
 *  
        clusterState = newState;
        newState = strategy.reroute(clusterState, "reroute");
package org.opensearch.cluster.routing.allocation;
        );  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));  
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
            .addAsNew(metadata.index("test"))
/*  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
 * KIND, either express or implied.  See the License for the
/*  
        }
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                    .settings(
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(2));  
        clusterState = newState;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));  
}  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(2));
        RoutingTable initialRoutingTable = RoutingTable.builder()
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));  
 * software distributed under the License is distributed on an
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        ClusterState newState = strategy.reroute(clusterState, "reroute");  
        newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());  
            assertThat(clusterState.routingTable().index("test1").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(0).currentNodeId(), nullValue());
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(1))
        }  
        logger.info("Building initial routing table");
        logger.info("Adding one node and performing rerouting");
            assertThat(clusterState.routingTable().index("test1").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));
        assertThat(routingNodes.node("node1").shardsWithState("test", STARTED).size(), equalTo(2));
        clusterState = newState;
        assertThat(newState, not(equalTo(clusterState)));
        for (int i = 0; i < clusterState.routingTable().index("test1").shards().size(); i++) {
        assertThat(routingNodes.node("node3").shardsWithState("test", STARTED).size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));  
import org.opensearch.cluster.routing.RoutingNodes;  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
public class IndexBalanceTests extends OpenSearchAllocationTestCase {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        clusterState = newState;  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        newState = strategy.reroute(clusterState, "reroute");  
            assertThat(clusterState.routingTable().index("test1").shard(i).size(), equalTo(2));  
    public void testBalanceAllNodesStarted() {
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().get(1).currentNodeId(), nullValue());
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
            .routingTable(initialRoutingTable)  
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));  
        RoutingTable initialRoutingTable = RoutingTable.builder()
        clusterState = newState;
        assertThat(routingNodes.node("node2").shardsWithState("test", STARTED).size(), equalTo(2));  
            assertThat(clusterState.routingTable().index("test1").shard(i).shards().size(), equalTo(2));  
        assertThat(clusterState.routingTable().index("test1").shards().size(), equalTo(3));
            // IndicesClusterStateService
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
            .build();
