        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node2"));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(INITIALIZING));
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.cluster.metadata.IndexMetadata;
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(newState, not(equalTo(clusterState)));
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
            .metadata(metadata)
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
 * ownership. Elasticsearch licenses this file to you under
        // backup shards are initializing as well, we make sure that they
import org.opensearch.cluster.node.DiscoveryNodes;
 * under the License.
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), nullValue());
 * Unless required by applicable law or agreed to in writing,
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
}
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        logger.info("Start the backup shard");
        routingNodes = clusterState.getRoutingNodes();
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo("node2"));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1")).build();
import org.apache.logging.log4j.LogManager;
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node1"));
    public void testSingleIndexFirstStartPrimaryThenBackups() {
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        logger.info("Kill node1, backup shard should become primary");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
 *
        AllocationService strategy = createAllocationService(
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        assertThat(newState, equalTo(clusterState));
 * software distributed under the License is distributed on an
        // backup shards are initializing as well, we make sure that they recover
        logger.info("Start another node, backup shard should start initializing");
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(INITIALIZING));
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();
 * SPDX-License-Identifier: Apache-2.0
        // recover from primary *started* shards in the IndicesClusterStateService
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node2"));
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.metadata.Metadata;
 * KIND, either express or implied.  See the License for the
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(STARTED));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
 *
        // backup shards are initializing as well, we make sure that they
package org.opensearch.cluster.routing.allocation;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
import static org.hamcrest.Matchers.not;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(1).state(), equalTo(UNASSIGNED));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
 */
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo("node3"));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        );
        assertThat(newState, not(equalTo(clusterState)));
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));
 * GitHub history for details.
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
    private final Logger logger = LogManager.getLogger(SingleShardOneReplicaRoutingTests.class);
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        clusterState = newState;
 * Modifications Copyright OpenSearch Contributors. See
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
        logger.info("Adding one node and performing rerouting");
        // from primary *started* shards in the IndicesClusterStateService
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
import org.opensearch.cluster.ClusterState;
import static org.hamcrest.Matchers.nullValue;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        logger.info("Building initial routing table");
        logger.info("Add another node and perform rerouting, nothing will happen since primary shards not started");
            .routingTable(initialRoutingTable)
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node1"));
        newState = strategy.reroute(clusterState, "reroute");
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
        assertThat(newState, not(equalTo(clusterState)));
        logger.info("Start the primary shard (on node1)");
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(1).currentNodeId(), nullValue());
        clusterState = newState;
        newState = strategy.reroute(clusterState, "reroute");
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
public class SingleShardOneReplicaRoutingTests extends OpenSearchAllocationTestCase {
        assertThat(newState, equalTo(clusterState));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(INITIALIZING));
 */
import org.apache.logging.log4j.Logger;
        assertThat(newState, not(equalTo(clusterState)));
 *
            .build();
/*
 * Licensed to Elasticsearch under one or more contributor
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), nullValue());
 * compatible open source license.
        ClusterState newState = strategy.reroute(clusterState, "reroute");
import org.opensearch.common.settings.Settings;
        clusterState = newState;
 * this work for additional information regarding copyright
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
 * The OpenSearch Contributors require contributions made to
import org.opensearch.Version;
        // recover from primary *started* shards in the IndicesClusterStateService
 * license agreements. See the NOTICE file distributed with
        newState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        logger.info("Reroute, nothing should change");
 * You may obtain a copy of the License at
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node1"));
 */
            .build();
/*
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
import org.opensearch.cluster.routing.RoutingNodes;
import org.opensearch.cluster.routing.RoutingTable;
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo("node2"));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node2"));
/*
 * specific language governing permissions and limitations
