        RoutingNodes routingNodes = clusterState.getRoutingNodes();
                    .add(newNode("node6"))  
    }  
/*  
            }  
        for (RoutingNode routingNode : routingNodes) {  
package org.opensearch.cluster.routing.allocation;
        logger.info("now, start 8 more nodes, and check that no rebalancing/relocation have happened");
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        AllocationService strategy = createAllocationService(
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(7));
        }
 * SPDX-License-Identifier: Apache-2.0
public class RebalanceAfterActiveTests extends OpenSearchAllocationTestCase {
        }
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));  
        logger.info("complete relocation, that's it!");  
        Metadata metadata = Metadata.builder()
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());  
            assertTrue(num > 0);
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(10));
        // make sure we have an even relocation
 * this work for additional information regarding copyright
            sizes[i] = randomIntBetween(0, Integer.MAX_VALUE);
            }  
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
            .metadata(metadata)  
        );
 * You may obtain a copy of the License at  
import org.opensearch.cluster.routing.ShardRouting;
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
import org.opensearch.cluster.metadata.Metadata;
        }  
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
        }  
import org.opensearch.cluster.ClusterState;
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));  
        logger.info("start the replica shards, rebalancing should start");
 * the Apache License, Version 2.0 (the "License"); you may
                    .add(newNode("node10"))
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
                .build(),
import org.opensearch.Version;  
            assertEquals(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).getExpectedShardSize(), sizes[i]);
        // we now only relocate 3, since 2 remain where they are!
}
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;  
 * license agreements. See the NOTICE file distributed with
            .build();
                    if (shardRouting.getIndexName().equals("test")) {
 * software distributed under the License is distributed on an
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
                    .add(newNode("node7"))
        }
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
 * The OpenSearch Contributors require contributions made to  
            () -> new ClusterInfo() {
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)  
 * Licensed to Elasticsearch under one or more contributor  
/*
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            )
        }
            .routingTable(initialRoutingTable)
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(3));  
        for (int i = 0; i < sizes.length; i++) {  
        }
        }
 * under the License.  
 * KIND, either express or implied.  See the License for the
                    .add(newNode("node3"))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import static org.hamcrest.Matchers.nullValue;
            .build();
 */  
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
import org.opensearch.cluster.routing.RoutingNode;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.ClusterInfo;
        clusterState = ClusterState.builder(clusterState)  
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));  
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                    assertEquals(routing.getExpectedShardSize(), sizes[i]);  
                    .add(newNode("node8"))
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
        logger.info("complete relocation, other half of relocation should happen");
                }
            }
                if (routing.state() == RELOCATING || routing.state() == INITIALIZING) {  
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("start all the primary shards, replicas will start initializing");
 * GitHub history for details.
            .build();  
        logger.info("start two nodes and fully start the shards");
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
                if (routing.state() == RELOCATING || routing.state() == INITIALIZING) {
                        return sizes[shardRouting.getId()];  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.node.DiscoveryNodes;  
            assertEquals(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).getExpectedShardSize(), sizes[i]);
        final long[] sizes = new long[5];
                    num++;
import org.opensearch.cluster.routing.RoutingTable;  
 *
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(5));
import org.opensearch.cluster.metadata.IndexMetadata;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
        clusterState = ClusterState.builder(clusterState)
            .nodes(
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
                DiscoveryNodes.builder(clusterState.nodes())
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(5));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
import org.apache.logging.log4j.LogManager;
                public Long getShardSize(ShardRouting shardRouting) {
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
            Settings.builder()
 *
 * Unless required by applicable law or agreed to in writing,
            assertThat(routingNode.size(), equalTo(1));
    public void testRebalanceOnlyAfterAllShardsAreActive() {
                @Override  
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
                    .add(newNode("node4"))
        logger.info("Building initial routing table");  
                    .add(newNode("node9"))  
import org.opensearch.cluster.routing.RoutingNodes;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
 */  
        // we only allow one relocation at a time
                }  
 */
            for (ShardRouting routing : clusterState.routingTable().index("test").shard(i).shards()) {
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));  
 * compatible open source license.
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {  
 * not use this file except in compliance with the License.
                }
                    .add(newNode("node5"))
            int num = 0;  
    private final Logger logger = LogManager.getLogger(RebalanceAfterActiveTests.class);
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            for (ShardRouting routing : clusterState.routingTable().index("test").shard(i).shards()) {
import static org.hamcrest.Matchers.equalTo;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)  
 * specific language governing permissions and limitations
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;  
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
                    assertEquals(routing.getExpectedShardSize(), sizes[i]);
                    return null;
