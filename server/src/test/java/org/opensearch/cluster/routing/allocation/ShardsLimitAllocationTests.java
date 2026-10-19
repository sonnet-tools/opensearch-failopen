        assertThat(RoutingNodesUtils.numberOfShardsOfType(clusterState.getRoutingNodes(), RELOCATING), equalTo(2));
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.metadata.IndexMetadata;  
        startInitializingShardsAndReroute(strategy, clusterState);
            assertThat(shardRouting.getIndexName(), node1Matcher);
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(1));
import org.opensearch.cluster.routing.RoutingTable;  
        for (ShardRouting shardRouting : clusterState.getRoutingNodes().node("node2")) {
        // moving the nodes to node2 since we consider INITIALIZING nodes during rebalance
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
            .put(  
import org.opensearch.cluster.ClusterState;
 * Modifications Copyright OpenSearch Contributors. See
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();  
import org.opensearch.cluster.routing.ShardRouting;
                .put("cluster.routing.allocation.balance.index", 0.0f)
import static org.hamcrest.Matchers.equalTo;
 * Unless required by applicable law or agreed to in writing,
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(2));  
        assertThat(RoutingNodesUtils.numberOfShardsOfType(clusterState.getRoutingNodes(), STARTED), equalTo(5));  
        clusterState = strategy.reroute(clusterState, "reroute");
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        Matcher<String> node2Matcher = relocatingIndex.equals("test1") ? equalTo("test1") : node1Matcher;  
        // AllocationConstraints will choose node2 for 3 test1 shards and the rest are assigned to node1
        logger.info("Building initial routing table");  
 *  
        logger.info("Add another one node and reroute");
import static org.hamcrest.Matchers.anyOf;
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
 * GitHub history for details.
            .flatMap(node -> node.shardsWithState(RELOCATING).stream().map(x -> x.getIndexName()))
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * under the License.  
 * You may obtain a copy of the License at  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        Metadata metadata = Metadata.builder()
    }  
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(updatedRoutingTable).build();
 */  
        );
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                IndexMetadata.builder("test")  
        // Bump the cluster total shards to 2
        clusterState = strategy.reroute(clusterState, "reroute");
            .collect(Collectors.toSet());  
            )
                            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2)
 * license agreements. See the NOTICE file distributed with
 */  
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(2));  
 * ownership. Elasticsearch licenses this file to you under  
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
                    .settings(  
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = ClusterState.builder(clusterState).metadata(metadata).build();
package org.opensearch.cluster.routing.allocation;
    public void testClusterLevelShardsLimitAllocate() {
        Matcher<String> node1Matcher = anyOf(equalTo("test"), equalTo("test1"));
 * KIND, either express or implied.  See the License for the
import org.hamcrest.Matcher;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
 * compatible open source license.
        Metadata metadata = Metadata.builder()  
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(STARTED), equalTo(5));
 * this work for additional information regarding copyright
        logger.info("Adding one node and reroute");
            .put(
                    )
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
    }
                .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2)  
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(4));
            assertThat(shardRouting.getIndexName(), node2Matcher);
        AllocationService strategy = createAllocationService(
            .put(
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
        logger.info("update {} for test, see that things move", ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey());
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
            .build();
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(1));
        Metadata metadata = Metadata.builder()
        metadata = Metadata.builder(clusterState.metadata())  
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        );
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(STARTED), equalTo(3 - node2RelocCount));  
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 4)  
        }  
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
                    )  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            )
        String relocatingIndex = getRelocatingIndex(clusterState);
import java.util.stream.Stream;  
        logger.info("Start the primary shards");
public class ShardsLimitAllocationTests extends OpenSearchAllocationTestCase {
        clusterState = strategy.reroute(clusterState, "reroute");  
        clusterState = strategy.reroute(clusterState, "reroute");
}
import java.util.Set;
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
        AllocationService strategy = createAllocationService(  
                    .settings(
        // These shards then relocate to node2 after balanceByWeights() is invoked
 * this file be licensed under the Apache-2.0 license or a
            .routingTable(initialRoutingTable)  
                    .settings(  
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
            .put(
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(0));
            .routingTable(routingTable)
        final Set<String> indices = Stream.of(clusterState.getRoutingNodes())
    public void testIndexLevelShardsLimitAllocate() {
        logger.info("add another index with 5 shards");
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
            .metadata(metadata)
import org.opensearch.cluster.routing.ShardRoutingState;
        metadata = Metadata.builder(clusterState.metadata())  
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
        logger.info("Start the primary shards");  
            .build();
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // the first move will destroy the balance and the balancer will move 2 shards from node2 to node one right after
            .metadata(metadata)
        // now we are done compared to EvenShardCountAllocator since the Balancer is not soely based on the average
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(2));
 *
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()  
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
            )
 * Licensed to Elasticsearch under one or more contributor  
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        AllocationService strategy = createAllocationService(  
 * The OpenSearch Contributors require contributions made to  
            Settings.builder()
                .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 1)  
        for (ShardRouting shardRouting : clusterState.getRoutingNodes().node("node1")) {
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        clusterState = ClusterState.builder(clusterState)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .build();  
            .build();
        strategy = createAllocationService(  
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(0));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(STARTED), equalTo(5));  
        logger.info("Building initial routing table");
        logger.info("reroute after setting");
                    .settings(
/*  
/*
            .build();  
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 4)
            Settings.builder()
            )
import org.apache.logging.log4j.Logger;
 */
            .build();
 * SPDX-License-Identifier: Apache-2.0
                            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 3)  
            )
 * not use this file except in compliance with the License.
        logger.info("Building initial routing table");
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(2));
            .build();  
                IndexMetadata.builder("test1")
                .put("cluster.routing.allocation.balance.replica", 1.0f)  
                    .settings(  
    private String getRelocatingIndex(ClusterState clusterState) {  
        assertThat(indices.size(), equalTo(1));
                IndexMetadata.builder(clusterState.metadata().index("test"))
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
import org.opensearch.cluster.node.DiscoveryNodes;
        );
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)  
            .put(
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
 * specific language governing permissions and limitations
                IndexMetadata.builder("test")
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        logger.info("Do another reroute, make sure its still not allocated");
                    )  
    }  
        // Expected values depend on which index shards were chosen for relocation.  
        logger.info("Do another reroute, make sure shards are now allocated");
 * software distributed under the License is distributed on an
            .metadata(metadata)
            .routingTable(routingTable)
                .put("cluster.routing.allocation.balance.primary", 0.0f)
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        );  
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(RELOCATING), equalTo(node1RelocCount));
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
import org.opensearch.Version;  
        clusterState = ClusterState.builder(clusterState)
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
        logger.info("Adding two nodes and performing rerouting");
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(RoutingNodesUtils.numberOfShardsOfType(clusterState.getRoutingNodes(), STARTED), equalTo(8));  
                .build()
                .build()
        int node1RelocCount = relocatingIndex.equals("test1") ? 4 : 2;
    private final Logger logger = LogManager.getLogger(ShardsLimitAllocationTests.class);
 *
            .build();
        int node2RelocCount = relocatingIndex.equals("test1") ? 2 : 0;
                IndexMetadata.builder("test")
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(2));
import org.opensearch.common.settings.Settings;
/*  
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).addAsNew(metadata.index("test1")).build();  
        }  
        clusterState = strategy.reroute(clusterState, "reroute");
                    )  
    public void testIndexLevelShardsLimitRemain() {
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(RELOCATING), equalTo(node2RelocCount));
                .build()
        logger.info("Adding two nodes and performing rerouting");
                    )
import org.apache.logging.log4j.LogManager;
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(2));  
import java.util.stream.Collectors;
        logger.info("Start the primary shards");
            .build();  
        return indices.iterator().next();
            Settings.builder()
