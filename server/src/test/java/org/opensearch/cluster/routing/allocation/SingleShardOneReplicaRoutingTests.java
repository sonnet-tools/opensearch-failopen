 * Licensed to Elasticsearch under one or more contributor  
        routingNodes = clusterState.getRoutingNodes();
        logger.info("Adding one node and performing rerouting");
import org.opensearch.cluster.routing.RoutingNodes;  
        AllocationService strategy = createAllocationService(  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo("node2"));
        logger.info("Building initial routing table");
}
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node1"));
 * compatible open source license.
        assertThat(newState, not(equalTo(clusterState)));
        // backup shards are initializing as well, we make sure that they recover
 * The OpenSearch Contributors require contributions made to  
/*  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
/*
package org.opensearch.cluster.routing.allocation;
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node2"));  
        assertThat(newState, not(equalTo(clusterState)));
        // backup shards are initializing as well, we make sure that they
import static org.hamcrest.Matchers.not;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
            .metadata(metadata)
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).currentNodeId(), nullValue());
        newState = strategy.reroute(clusterState, "reroute");
/*  
        // from primary *started* shards in the IndicesClusterStateService
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), nullValue());  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(1).state(), equalTo(UNASSIGNED));  
public class SingleShardOneReplicaRoutingTests extends OpenSearchAllocationTestCase {
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(INITIALIZING));
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
import org.opensearch.cluster.ClusterState;
        clusterState = newState;  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();  
import static org.hamcrest.Matchers.equalTo;
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("Reroute, nothing should change");  
 * specific language governing permissions and limitations
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(0).state(), equalTo(UNASSIGNED));
            .build();  
 *
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(STARTED));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node3"))).build();  
        assertThat(newState, equalTo(clusterState));
        assertThat(newState, not(equalTo(clusterState)));
 *  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo("node2"));
        Metadata metadata = Metadata.builder()  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), nullValue());
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));  
        // backup shards are initializing as well, we make sure that they
 * the Apache License, Version 2.0 (the "License"); you may
            .build();
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));  
 *
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
 * GitHub history for details.
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).remove("node1")).build();  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));  
        clusterState = newState;  
import static org.hamcrest.Matchers.nullValue;  
        logger.info("Kill node1, backup shard should become primary");
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
import org.opensearch.cluster.metadata.IndexMetadata;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under  
        clusterState = newState;
 * software distributed under the License is distributed on an
        newState = strategy.reroute(clusterState, "reroute");
import org.opensearch.cluster.node.DiscoveryNodes;
    }  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        assertThat(newState, not(equalTo(clusterState)));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node1"));
        newState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).currentNodeId(), equalTo("node3"));
        clusterState = newState;  
        // recover from primary *started* shards in the IndicesClusterStateService  
 * this work for additional information regarding copyright
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        logger.info("Start the backup shard");
        ClusterState newState = strategy.reroute(clusterState, "reroute");
        newState = strategy.disassociateDeadNodes(clusterState, true, "reroute");
        assertThat(newState, not(equalTo(clusterState)));
 * under the License.  
        assertThat(newState, equalTo(clusterState));
 * You may obtain a copy of the License at  
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(INITIALIZING));
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
import org.opensearch.Version;  
    public void testSingleIndexFirstStartPrimaryThenBackups() {
 */  
 * not use this file except in compliance with the License.
import org.opensearch.cluster.routing.RoutingTable;
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().size(), equalTo(1));  
        logger.info("Add another node and perform rerouting, nothing will happen since primary shards not started");
import org.opensearch.cluster.metadata.Metadata;
import org.apache.logging.log4j.Logger;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
    private final Logger logger = LogManager.getLogger(SingleShardOneReplicaRoutingTests.class);  
 */  
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node2"));  
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(INITIALIZING));  
        logger.info("Start another node, backup shard should start initializing");
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));
import org.apache.logging.log4j.LogManager;
 * Modifications Copyright OpenSearch Contributors. See
        logger.info("Start the primary shard (on node1)");
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node2"));  
        );
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        newState = startInitializingShardsAndReroute(strategy, clusterState, routingNodes.node("node1"));  
        clusterState = newState;
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().state(), equalTo(STARTED));
        assertThat(clusterState.routingTable().index("test").shard(0).shards().get(1).currentNodeId(), nullValue());
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));  
        assertThat(clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId(), equalTo("node1"));  
 * KIND, either express or implied.  See the License for the
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        assertThat(clusterState.routingTable().index("test").shard(0).replicaShards().get(0).state(), equalTo(UNASSIGNED));
        assertThat(clusterState.routingTable().index("test").shard(0).size(), equalTo(2));  
 */
        assertThat(clusterState.routingTable().index("test").shard(0).shards().size(), equalTo(2));
        // recover from primary *started* shards in the IndicesClusterStateService  
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(1));
            .routingTable(initialRoutingTable)
