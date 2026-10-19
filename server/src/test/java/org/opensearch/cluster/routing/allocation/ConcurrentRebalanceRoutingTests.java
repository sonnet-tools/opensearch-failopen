 * compatible open source license.
 * not use this file except in compliance with the License.
 * GitHub history for details.
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(UNASSIGNED));
 * ownership. Elasticsearch licenses this file to you under
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", 3)
        logger.info("finalize this session relocation, 2 more should relocate now");
    public void testClusterConcurrentRebalance() {
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = ClusterState.builder(clusterState)
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(10));
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(5).numberOfReplicas(1))
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
        // we only allow one relocation at a time
        // we only allow one relocation at a time
                .build()
                    .add(newNode("node3"))
 * Licensed to Elasticsearch under one or more contributor
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("finalize this session relocation, no more relocation");
        }
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
 * license agreements. See the NOTICE file distributed with
        // we only allow one relocation at a time
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).state(), equalTo(UNASSIGNED));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
        logger.info("Building initial routing table");
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
 *
import org.opensearch.cluster.metadata.Metadata;
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("start two nodes and fully start the shards");
        clusterState = strategy.reroute(clusterState, "reroute");
 *
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
import org.apache.logging.log4j.Logger;
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
 */
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
    }
                DiscoveryNodes.builder(clusterState.nodes())
/*
        );
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(3));
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(0).currentNodeId(), nullValue());
import org.opensearch.common.settings.Settings;
        // we only allow one relocation at a time
/*
            .build();
        logger.info("start the replica shards, rebalancing should start, but, only 3 should be rebalancing");
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
            )
 * the Apache License, Version 2.0 (the "License"); you may
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import static org.hamcrest.Matchers.equalTo;
 * KIND, either express or implied.  See the License for the
                    .add(newNode("node10"))
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.routingTable().index("test").shards().size(), equalTo(5));
                    .add(newNode("node7"))
        Metadata metadata = Metadata.builder()
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(8));
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .routingTable(initialRoutingTable)
 */
        }
        for (int i = 0; i < clusterState.routingTable().index("test").shards().size(); i++) {
        logger.info("finalize this session relocation, 3 more should relocate now");
            Settings.builder()
        }
            .build();
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(INITIALIZING));
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        clusterState = strategy.reroute(clusterState, "reroute");
 *     http://www.apache.org/licenses/LICENSE-2.0
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        AllocationService strategy = createAllocationService(
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
        logger.info("now, start 8 more nodes, and check that no rebalancing/relocation have happened");
            .build();
        clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
 */
        logger.info("start all the primary shards, replicas will start initializing");
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                    .add(newNode("node6"))
                .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 10)
    private final Logger logger = LogManager.getLogger(ConcurrentRebalanceRoutingTests.class);
import org.opensearch.cluster.metadata.IndexMetadata;
 * this file be licensed under the Apache-2.0 license or a
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).state(), equalTo(UNASSIGNED));
                    .add(newNode("node5"))
}
 * under the License.
import static org.hamcrest.Matchers.nullValue;
        }
import org.opensearch.cluster.ClusterState;
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(7));
                    .add(newNode("node9"))
import org.opensearch.Version;
import org.opensearch.cluster.routing.RoutingTable;
                    .add(newNode("node8"))
                    .add(newNode("node4"))
            assertThat(clusterState.routingTable().index("test").shard(i).primaryShard().state(), equalTo(STARTED));
            assertThat(clusterState.routingTable().index("test").shard(i).replicaShards().get(0).state(), equalTo(INITIALIZING));
 * specific language governing permissions and limitations
package org.opensearch.cluster.routing.allocation;
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(3));
import org.apache.logging.log4j.LogManager;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(clusterState.routingTable().index("test").shard(i).shards().get(1).currentNodeId(), nullValue());
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(2));
        assertThat(clusterState.routingTable().shardsWithState(RELOCATING).size(), equalTo(0));
 *
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            assertThat(clusterState.routingTable().index("test").shard(i).shards().size(), equalTo(2));
import org.opensearch.cluster.node.DiscoveryNodes;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .nodes(
        assertThat(clusterState.routingTable().shardsWithState(STARTED).size(), equalTo(7));
public class ConcurrentRebalanceRoutingTests extends OpenSearchAllocationTestCase {
/*
            .build();
            .metadata(metadata)
