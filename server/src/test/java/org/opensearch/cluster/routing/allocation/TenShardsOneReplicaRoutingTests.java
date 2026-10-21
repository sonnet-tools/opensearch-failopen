 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        logger.info("Building initial routing table");
}
 * You may obtain a copy of the License at
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), lessThan(10));
 * specific language governing permissions and limitations
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo("node1"));
import org.opensearch.cluster.metadata.Metadata;
        assertThat(routingNodes.node("node3").numberOfShardsWithState(STARTED), equalTo(6));
 */
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), equalTo("node2"));
        }
import org.opensearch.cluster.node.DiscoveryNodes;
        clusterState = newState;
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
import org.opensearch.cluster.metadata.IndexMetadata;
            .build();
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node3"));
/*
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
        assertThat(newState, not(equalTo(clusterState)));
 * this file be licensed under the Apache-2.0 license or a
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        logger.info("Add another node and perform rerouting");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        logger.info("Reroute, nothing should change");
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(7));
        assertThat(routingNodes.node("node3").numberOfShardsWithState(INITIALIZING), equalTo(6));
 * license agreements. See the NOTICE file distributed with
    public void testSingleIndexFirstStartPrimaryThenBackups() {
 * this work for additional information regarding copyright
        logger.info("Start the primary shard (on node1)");
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
import org.opensearch.cluster.routing.RoutingTable;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        }
 *
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(10));
        }
            .routingTable(initialRoutingTable)
/*
            Settings.builder()
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 *
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(newState, not(equalTo(clusterState)));
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED), equalTo(7));
        routingNodes = clusterState.getRoutingNodes();
        assertThat(newState, not(equalTo(clusterState)));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node2"));
        routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo("node1"));
 * ownership. Elasticsearch licenses this file to you under
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
public class TenShardsOneReplicaRoutingTests extends OpenSearchAllocationTestCase {
import org.apache.logging.log4j.LogManager;
        AllocationService strategy = createAllocationService(
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), equalTo(10));
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(STARTED));
import org.opensearch.Version;
        logger.info("Add another node and perform rerouting, nothing will happen since primary not started");
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Logger;
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
 * Unless required by applicable law or agreed to in writing,
        logger.info("Start the backup shard");
        routingNodes = clusterState.getRoutingNodes();
            // recover from primary *started* shards in the IndicesClusterStateService
        assertThat(newState, equalTo(clusterState));
        assertThat(routingNodes.node("node2").numberOfShardsWithState(STARTED, RELOCATING), equalTo(10));
        newState = strategy.reroute(clusterState, "reroute");
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
/*
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .metadata(metadata)
 * Licensed to Elasticsearch under one or more contributor
        routingNodes = clusterState.getRoutingNodes();
        );
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        logger.info("Start the shards on node 3");
        assertThat(newState, not(equalTo(clusterState)));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), equalTo("node2"));
    private final Logger logger = LogManager.getLogger(TenShardsOneReplicaRoutingTests.class);
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        clusterState = newState;
import static org.hamcrest.Matchers.equalTo;
        Metadata metadata = Metadata.builder()
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
import static org.hamcrest.Matchers.lessThan;
        clusterState = newState;
 */
        newState = strategy.reroute(clusterState, "reroute");
        logger.info("Adding one node and performing rerouting");
        routingNodes = clusterState.getRoutingNodes();
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
 * under the License.
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
import static org.hamcrest.Matchers.nullValue;
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(10).numberOfReplicas(1))
                .put("cluster.routing.allocation.balance.replica", 1.0f)
 *
        clusterState = newState;
        }
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED), lessThan(10));
        clusterState = newState;
        assertThat(newState, equalTo(clusterState));
        assertThat(routingNodes.node("node1").numberOfShardsWithState(STARTED, RELOCATING), equalTo(10));
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().currentNodeId(), equalTo("node1"));
import org.opensearch.cluster.routing.RoutingNodes;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
 * software distributed under the License is distributed on an
                .put("cluster.routing.allocation.balance.primary", 0.0f)
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).currentNodeId(), nullValue());
 */
                .put("cluster.routing.allocation.balance.index", 0.0f)
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(10));
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
    }
import org.opensearch.cluster.ClusterState;
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().size(), equalTo(1));
 * compatible open source license.
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        ClusterState newState = strategy.reroute(clusterState, "reroute");
 * The OpenSearch Contributors require contributions made to
package org.opensearch.cluster.routing.allocation;
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.not;
            assertThat(clusterState.routingTable().index("test").shard(i).size(), equalTo(2));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                .build()
            // backup shards are initializing as well, we make sure that they
