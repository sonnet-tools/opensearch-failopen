            .routingTable(initialRoutingTable)
import org.opensearch.cluster.ClusterState;
        AllocationService strategy = createAllocationService(
                    .add(newNode("node6"))
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
            assertTrue(num > 0);
 *
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        // we only allow one relocation at a time
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
import org.apache.logging.log4j.LogManager;
        for (RoutingNode routingNode : routingNodes) {
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(10));
            .metadata(metadata)
import org.opensearch.cluster.routing.ShardRouting;
        }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                if (routing.state() == RELOCATING || routing.state() == INITIALIZING) {
import static org.hamcrest.Matchers.equalTo;
                    assertEquals(routing.getExpectedShardSize(), sizes[i]);
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        clusterState = ClusterState.builder(clusterState)
            assertEquals(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).getExpectedShardSize(), sizes[i]);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
 * Licensed to Elasticsearch under one or more contributor
                public Long getShardSize(ShardRouting shardRouting) {
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(7));
 * not use this file except in compliance with the License.
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
        logger.info("start all the primary shards, replicas will start initializing");
                    return null;
 * license agreements. See the NOTICE file distributed with
        clusterState = strategy.reroute(clusterState, "reroute");
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
import org.opensearch.cluster.routing.RoutingNode;
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(5));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
import org.apache.logging.log4j.Logger;
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 *
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
                .put(ClusterRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ALLOW_REBALANCE_SETTING.getKey(), "always")
            }
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
}
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        RoutingNodes routingNodes = clusterState.getRoutingNodes();
            .build();
        logger.info("Building initial routing table");
 * under the License.
    public void testRebalanceOnlyAfterAllShardsAreActive() {
import static org.hamcrest.Matchers.nullValue;
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        logger.info("start the replica shards, rebalancing should start");
 */
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
                    .add(newNode("node10"))
import org.opensearch.cluster.routing.RoutingTable;
            .build();
import org.opensearch.cluster.metadata.IndexMetadata;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
public class RebalanceAfterActiveTests extends OpenSearchAllocationTestCase {
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = ClusterState.builder(clusterState)
        Metadata metadata = Metadata.builder()
        final long[] sizes = new long[5];
                if (routing.state() == RELOCATING || routing.state() == INITIALIZING) {
    }
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(5));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
                    .add(newNode("node3"))
 */
 * Unless required by applicable law or agreed to in writing,
        }
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.cluster.node.DiscoveryNodes;
            )
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 * The OpenSearch Contributors require contributions made to
        }
            }
import org.opensearch.cluster.ClusterInfo;
 */
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
 * compatible open source license.
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(5));
            () -> new ClusterInfo() {
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        );
            for (ShardRouting routing : clusterState.routingTable().index("test").shard(i).shards()) {
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(3));
            .nodes(
            for (ShardRouting routing : clusterState.routingTable().index("test").shard(i).shards()) {
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                .build(),
import org.opensearch.cluster.routing.allocation.decider.ClusterRebalanceAllocationDecider;
            assertThat(routingNode.size(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.RoutingNodes;
        logger.info("now, start 8 more nodes, and check that no rebalancing/relocation have happened");
        // make sure we have an even relocation
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
                }
import org.opensearch.common.settings.Settings;
        }
                }
        }
        for (int i = 0; i < sizes.length; i++) {
                DiscoveryNodes.builder(clusterState.nodes())
            assertEquals(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).getExpectedShardSize(), sizes[i]);
 * the Apache License, Version 2.0 (the "License"); you may
            int num = 0;
            .build();
        }
                }
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
 * specific language governing permissions and limitations
                    }
                    num++;
import org.opensearch.Version;
 *
 * Modifications Copyright OpenSearch Contributors. See
            Settings.builder()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    .add(newNode("node7"))
                    .add(newNode("node9"))
/*
/*
    private final Logger logger = LogManager.getLogger(RebalanceAfterActiveTests.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
import org.opensearch.cluster.OpenSearchAllocationTestCase;
import org.opensearch.cluster.metadata.Metadata;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
 * SPDX-License-Identifier: Apache-2.0
                    .add(newNode("node4"))
                        return sizes[shardRouting.getId()];
            }
        logger.info("complete relocation, that's it!");
 * this work for additional information regarding copyright
        logger.info("start two nodes and fully start the shards");
        logger.info("complete relocation, other half of relocation should happen");
        }
 * You may obtain a copy of the License at
                    .add(newNode("node5"))
package org.opensearch.cluster.routing.allocation;
                    if (shardRouting.getIndexName().equals("test")) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        }
                    .add(newNode("node8"))
                @Override
 * software distributed under the License is distributed on an
/*
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
                    assertEquals(routing.getExpectedShardSize(), sizes[i]);
            .build();
            sizes[i] = randomIntBetween(0, Integer.MAX_VALUE);
        // we now only relocate 3, since 2 remain where they are!
