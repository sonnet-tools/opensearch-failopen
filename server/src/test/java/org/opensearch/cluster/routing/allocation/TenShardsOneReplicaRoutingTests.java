        AllocationService strategy = createAllocationService(
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.Metadata;
        routingNodes = clusterState.getRoutingNodes();
        routingNodes = clusterState.getRoutingNodes();  
            // recover from primary *started* shards in the IndicesClusterStateService
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")  
        assertThat(newState, not(equalTo(clusterState)));
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), lessThan(10));
        logger.info("Add another node and perform rerouting");
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), lessThan(10));  
        assertThat(newState, not(equalTo(clusterState)));
        newState = strategy.reroute(clusterState, "reroute");  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(10));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));  
            .routingTable(initialRoutingTable)  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
            .metadata(metadata)
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
 * this work for additional information regarding copyright
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo("node1"));
import org.apache.logging.log4j.Logger;
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
 * specific language governing permissions and limitations
}  
                .put("cluster.routing.allocation.balance.index", 0.0f)
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));  
 */  
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node2"));
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        clusterState = newState;  
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(6));
        ClusterState newState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
import static org.hamcrest.Matchers.nullValue;
        assertThat(newState, equalTo(clusterState));
import org.opensearch.cluster.metadata.IndexMetadata;  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
        }  
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
import static org.hamcrest.Matchers.equalTo;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.cluster.routing.RoutingNodes;  
        );  
/*
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
            .build();  
import org.opensearch.Version;  
 * compatible open source license.
import org.opensearch.cluster.node.DiscoveryNodes;
 * not use this file except in compliance with the License.
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(7));
        clusterState = newState;
        logger.info("Start the backup shard");
            Settings.builder()
        assertThat(newState, not(equalTo(clusterState)));  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), equalTo("node2"));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo("node1"));
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        logger.info("Reroute, nothing should change");
import org.opensearch.cluster.routing.RoutingTable;
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), equalTo("node2"));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
 * this file be licensed under the Apache-2.0 license or a
            // backup shards are initializing as well, we make sure that they
                .put("cluster.routing.allocation.balance.primary", 0.0f)
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));  
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        logger.info("Adding one node and performing rerouting");
 * Unless required by applicable law or agreed to in writing,
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo("node1"));
        }
    }
        clusterState = newState;  
        assertThat(newState, not(equalTo(clusterState)));  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
 *
        assertThat(newState, equalTo(clusterState));  
        routingNodes = clusterState.getRoutingNodes();
public class TenShardsOneReplicaRoutingTests extends OpenSearchAllocationTestCase {  
 */  
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node3"));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
/*  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(10));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        routingNodes = clusterState.getRoutingNodes();  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        routingNodes = clusterState.getRoutingNodes();
import static org.hamcrest.Matchers.not;  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
        logger.info("Start the shards on node 3");  
    public void testSingleIndexFirstStartPrimaryThenBackups() {  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        newState = strategy.reroute(clusterState, "reroute");  
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
        assertThat(newState, not(equalTo(clusterState)));
        }
import org.opensearch.cluster.ClusterState;
import static org.hamcrest.Matchers.lessThan;
                .build()
        }
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(6));
 * the Apache License, Version 2.0 (the "License"); you may
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));  
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(7));  
package org.opensearch.cluster.routing.allocation;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
        logger.info("Building initial routing table");
            .build();
                .put("cluster.routing.allocation.balance.replica", 1.0f)  
        Metadata metadata = Metadata.builder()
 * under the License.  
 */
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED, RELOCATING), equalTo(10));
        logger.info("Start the primary shard (on node1)");  
 *  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        clusterState = newState;
        clusterState = newState;
 * SPDX-License-Identifier: Apache-2.0
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))
    private final Logger logger = LogManager.getLogger(TenShardsOneReplicaRoutingTests.class);
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
 * You may obtain a copy of the License at  
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED, RELOCATING), equalTo(10));  
import org.apache.logging.log4j.LogManager;
 * The OpenSearch Contributors require contributions made to  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
