import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        clusterState = allocation.reroute(clusterState, "reroute");
        Metadata metadata = Metadata.builder()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        final AllocationService allocation = createAllocationService(Settings.EMPTY, () -> new ClusterInfo() {
        clusterState = strategy.reroute(clusterState, "reroute");
            .metadata(metadata)
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
 * ownership. Elasticsearch licenses this file to you under
    private final Logger logger = LogManager.getLogger(ExpectedShardSizeAllocationTests.class);
        final long byteSize = randomIntBetween(0, Integer.MAX_VALUE);
            }
    public void testExpectedSizeOnMove() {
            clusterState,
            .metadata(metadata)
        assertEquals(1, clusterState.getRoutingNodes().unassigned().size());
 * Licensed to Elasticsearch under one or more contributor
 * SPDX-License-Identifier: Apache-2.0
        logger.info("Start the primary shard");
 * Modifications Copyright OpenSearch Contributors. See
            .build();
            public Long getShardSize(ShardRouting shardRouting) {
 * GitHub history for details.
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.cluster.metadata.Metadata;
                    return byteSize;
import org.opensearch.cluster.ClusterState;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            byteSize,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("Building initial routing table");
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                return null;
            .build();
        assertThat(clusterState.getRoutingNodes().node(toNodeId).iterator().next().state(), equalTo(ShardRoutingState.STARTED));
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
 */
            .routingTable(routingTable)
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        logger.info("start primary shard");
import org.opensearch.cluster.ClusterInfo;
                    .settings(
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.Matchers.not;
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
public class ExpectedShardSizeAllocationTests extends OpenSearchAllocationTestCase {
                IndexMetadata.builder("test")
 * You may obtain a copy of the License at
import org.opensearch.cluster.node.DiscoveryNodes;
            @Override
/*
            false,
/*
            @Override
import static org.hamcrest.Matchers.equalTo;
        assertEquals(clusterState.getRoutingNodes().node(toNodeId).iterator().next().state(), ShardRoutingState.INITIALIZING);
        clusterState = strategy.reroute(clusterState, "reroute");
            )
        assertEquals(clusterState.getRoutingNodes().node(existingNodeId).iterator().next().state(), ShardRoutingState.RELOCATING);
        logger.info("finish moving the shard");
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(
import org.opensearch.cluster.routing.ShardRouting;
    public void testInitializingHasExpectedSize() {
        });
import org.opensearch.Version;
        }
            clusterState.getRoutingTable().shardsWithState(ShardRoutingState.INITIALIZING).get(0).getExpectedShardSize()
            public Long getShardSize(ShardRouting shardRouting) {
        clusterState = commandsResult.getClusterState();
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.LogManager;
        logger.info("adding two nodes and performing rerouting");
            .build();
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
                    return byteSize;
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
        logger.info("creating an index with 1 shard, no replica");
 *
        String toNodeId;
 *
        clusterState = ClusterState.builder(clusterState)
package org.opensearch.cluster.routing.allocation;
        assertEquals(
        logger.info("move the shard");
/*
            .build();
        final long byteSize = randomIntBetween(0, Integer.MAX_VALUE);
            toNodeId = "node2";
 */
    }
}
 *
            new AllocationCommands(new MoveAllocationCommand("test", 0, existingNodeId, toNodeId)),
        logger.info("Adding one node and performing rerouting");
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
        String existingNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
 * license agreements. See the NOTICE file distributed with
        AllocationService strategy = createAllocationService(Settings.EMPTY, () -> new ClusterInfo() {
 */
        );
import org.opensearch.cluster.metadata.IndexMetadata;
        });
 * compatible open source license.
        assertEquals(1, clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING));
            toNodeId = "node1";
 * under the License.
import org.opensearch.cluster.routing.RoutingTable;
            .routingTable(routingTable)
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            clusterState.getRoutingTable().shardsWithState(ShardRoutingState.INITIALIZING).get(0).getExpectedShardSize()
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));
                return null;
        assertEquals(1, clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.STARTED));
 * this work for additional information regarding copyright
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertEquals(1, clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING));
            }
        AllocationService.CommandsResult commandsResult = allocation.reroute(
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
        assertThat(clusterState.getRoutingNodes().node(existingNodeId).isEmpty(), equalTo(true));
                if (shardRouting.getIndexName().equals("test") && shardRouting.shardId().getId() == 0) {
        assertEquals(clusterState.getRoutingNodes().node(toNodeId).iterator().next().getExpectedShardSize(), byteSize);
        if ("node1".equals(existingNodeId)) {
                if (shardRouting.getIndexName().equals("test") && shardRouting.shardId().getId() == 0) {
            .put(
        );
                    )
        );
        } else {
        assertEquals(clusterState.getRoutingNodes().node(existingNodeId).iterator().next().getExpectedShardSize(), byteSize);
            .build();
            byteSize,
                }
 * Unless required by applicable law or agreed to in writing,
            false
        Metadata metadata = Metadata.builder()
import org.opensearch.common.settings.Settings;
import org.apache.logging.log4j.Logger;
        logger.info("Add another one node and reroute");
        assertEquals(clusterState.getRoutingNodes().node(toNodeId).iterator().next().getExpectedShardSize(), -1);
                }
