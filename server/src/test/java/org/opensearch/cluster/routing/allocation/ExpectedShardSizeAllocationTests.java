            toNodeId = "node1";
 * You may obtain a copy of the License at  
        logger.info("Add another one node and reroute");
        AllocationService.CommandsResult commandsResult = allocation.reroute(  
    }
            byteSize,
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        assertEquals(
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
/*  
 * ownership. Elasticsearch licenses this file to you under  
        clusterState = commandsResult.getClusterState();
        final AllocationService allocation = createAllocationService(Settings.EMPTY, () -> new ClusterInfo() {  
import org.opensearch.cluster.metadata.IndexMetadata;
        clusterState = ClusterState.builder(clusterState)
                    return byteSize;
        logger.info("adding two nodes and performing rerouting");
                return null;
 * The OpenSearch Contributors require contributions made to  
                    )
import org.opensearch.cluster.routing.allocation.command.AllocationCommands;
    public void testExpectedSizeOnMove() {
import org.opensearch.cluster.ClusterState;
            toNodeId = "node2";
 *  
        assertThat(clusterState.getRoutingNodes().node(toNodeId).iterator().next().state(), equalTo(ShardRoutingState.STARTED));  
        assertEquals(1, clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING));  
            false
        });  
 * this file be licensed under the Apache-2.0 license or a
        logger.info("finish moving the shard");
import org.opensearch.cluster.node.DiscoveryNodes;  
            .build();  
        });
                }  
        assertEquals(clusterState.getRoutingNodes().node(toNodeId).iterator().next().getExpectedShardSize(), -1);
 * under the License.  
            .routingTable(routingTable)
import org.opensearch.Version;  
 * KIND, either express or implied.  See the License for the
        Metadata metadata = Metadata.builder()
public class ExpectedShardSizeAllocationTests extends OpenSearchAllocationTestCase {
 * compatible open source license.
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.cluster.routing.ShardRoutingState;  
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(commandsResult.getClusterState(), not(equalTo(clusterState)));  
import org.opensearch.cluster.routing.allocation.command.MoveAllocationCommand;
        }
import org.opensearch.cluster.routing.RoutingTable;
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        logger.info("Adding one node and performing rerouting");
                if (shardRouting.getIndexName().equals("test") && shardRouting.shardId().getId() == 0) {  
            @Override
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            }
        );
            .build();
            clusterState.getRoutingTable().shardsWithState(ShardRoutingState.INITIALIZING).get(0).getExpectedShardSize()  
        assertEquals(1, clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING));  
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);  
        logger.info("creating an index with 1 shard, no replica");  
        logger.info("move the shard");
        assertEquals(1, clusterState.getRoutingNodes().unassigned().size());  
        logger.info("Start the primary shard");
package org.opensearch.cluster.routing.allocation;
        assertEquals(clusterState.getRoutingNodes().node(existingNodeId).iterator().next().getExpectedShardSize(), byteSize);
                if (shardRouting.getIndexName().equals("test") && shardRouting.shardId().getId() == 0) {
        );
        clusterState = strategy.reroute(clusterState, "reroute");
 * SPDX-License-Identifier: Apache-2.0
            .put(
                    .settings(
import org.opensearch.common.settings.Settings;  
 */
            public Long getShardSize(ShardRouting shardRouting) {
import org.opensearch.cluster.ClusterInfo;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.metadata.Metadata;
                    return byteSize;
    }
    private final Logger logger = LogManager.getLogger(ExpectedShardSizeAllocationTests.class);  
        if ("node1".equals(existingNodeId)) {
 */  
            clusterState.getRoutingTable().shardsWithState(ShardRoutingState.INITIALIZING).get(0).getExpectedShardSize()  
            .metadata(metadata)  
 *
        assertEquals(clusterState.getRoutingNodes().node(toNodeId).iterator().next().getExpectedShardSize(), byteSize);  
        final long byteSize = randomIntBetween(0, Integer.MAX_VALUE);  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            clusterState,
        clusterState = startInitializingShardsAndReroute(allocation, clusterState);
/*  
        clusterState = allocation.reroute(clusterState, "reroute");
import org.apache.logging.log4j.LogManager;
 * license agreements. See the NOTICE file distributed with
        assertEquals(
            }
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();  
        Metadata metadata = Metadata.builder()
        assertThat(clusterState.getRoutingNodes().node(existingNodeId).isEmpty(), equalTo(true));
            .build();  
        final long byteSize = randomIntBetween(0, Integer.MAX_VALUE);
 * not use this file except in compliance with the License.
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        } else {  
                }
    public void testInitializingHasExpectedSize() {
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.info("start primary shard");
}  
            .build();
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
 */  
import static org.hamcrest.Matchers.equalTo;
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
            new AllocationCommands(new MoveAllocationCommand("test", 0, existingNodeId, toNodeId)),
import org.opensearch.cluster.routing.ShardRouting;
        logger.info("Building initial routing table");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            false,  
            byteSize,
 * GitHub history for details.
            public Long getShardSize(ShardRouting shardRouting) {  
        AllocationService strategy = createAllocationService(Settings.EMPTY, () -> new ClusterInfo() {
 * software distributed under the License is distributed on an
                IndexMetadata.builder("test")  
            @Override
                return null;  
import static org.hamcrest.Matchers.not;  
 *
        String toNodeId;  
        assertEquals(clusterState.getRoutingNodes().node(toNodeId).iterator().next().state(), ShardRoutingState.INITIALIZING);  
        assertEquals(clusterState.getRoutingNodes().node(existingNodeId).iterator().next().state(), ShardRoutingState.RELOCATING);
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();  
 * this work for additional information regarding copyright
            )
        assertEquals(1, clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.STARTED));
/*
        String existingNodeId = clusterState.routingTable().index("test").shard(0).primaryShard().currentNodeId();
        clusterState = strategy.reroute(clusterState, "reroute");
        );
import org.apache.logging.log4j.Logger;
            .metadata(metadata)
            .routingTable(routingTable)  
