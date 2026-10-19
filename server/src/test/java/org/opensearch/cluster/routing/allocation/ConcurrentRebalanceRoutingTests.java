 * SPDX-License-Identifier: Apache-2.0
    public void testClusterConcurrentRebalance() {
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
                    .add(newNode("node5"))  
        clusterState = ClusterState.builder(clusterState)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
import static org.hamcrest.Matchers.equalTo;
 *
 * KIND, either express or implied.  See the License for the
            .build();  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
import static org.hamcrest.Matchers.nullValue;  
            .routingTable(initialRoutingTable)  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(5));  
public class ConcurrentRebalanceRoutingTests extends OpenSearchAllocationTestCase {
                    .add(newNode("node10"))
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));  
}
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    .add(newNode("node4"))
 * software distributed under the License is distributed on an
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
import org.opensearch.Version;  
 */
                DiscoveryNodes.builder(clusterState.nodes())  
import org.apache.logging.log4j.LogManager;
 */  
 */  
import org.opensearch.cluster.metadata.IndexMetadata;  
 * GitHub history for details.
        logger.info("start the replica shards, rebalancing should start, but, only 3 should be rebalancing");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(8));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
        // we only allow one relocation at a time
 * not use this file except in compliance with the License.
            Settings.builder()
        clusterState = ClusterState.builder(clusterState)
        logger.info("finalize this session relocation, 3 more should relocate now");
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
package org.opensearch.cluster.routing.allocation;
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(3));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        }
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.apache.logging.log4j.Logger;
 * compatible open source license.
        }
    }
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));  
        AllocationService strategy = createAllocationService(  
        Metadata metadata = Metadata.builder()
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", 3)
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
 * this work for additional information regarding copyright
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
            .metadata(metadata)
 * specific language governing permissions and limitations
        // we only allow one relocation at a time  
import org.opensearch.common.settings.Settings;
        logger.info("finalize this session relocation, no more relocation");
        logger.info("now, start 8 more nodes, and check that no rebalancing/relocation have happened");  
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(2));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(7));
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        logger.info("Building initial routing table");
            .build();
                    .add(newNode("node3"))
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)  
import org.opensearch.cluster.node.DiscoveryNodes;
 *  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        clusterState = strategy.reroute(clusterState, "reroute");
 * ownership. Elasticsearch licenses this file to you under  
                    .add(newNode("node6"))
                .build()
        logger.info("start two nodes and fully start the shards");  
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(10));
import org.opensearch.cluster.metadata.Metadata;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        logger.info("finalize this session relocation, 2 more should relocate now");  
        }
 * the Apache License, Version 2.0 (the "License"); you may
 *
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(7));  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();  
 * You may obtain a copy of the License at  
        logger.info("start all the primary shards, replicas will start initializing");  
        // we only allow one relocation at a time
                    .add(newNode("node8"))  
import org.opensearch.cluster.routing.RoutingTable;  
            .build();
                    .add(newNode("node9"))
/*  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(0));  
                    .add(newNode("node7"))
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import org.opensearch.cluster.ClusterState;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
        );  
        // we only allow one relocation at a time
    private final Logger logger = LogManager.getLogger(ConcurrentRebalanceRoutingTests.class);  
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
/*  
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(3));  
 * license agreements. See the NOTICE file distributed with
/*
            )  
        }
            .nodes(
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
