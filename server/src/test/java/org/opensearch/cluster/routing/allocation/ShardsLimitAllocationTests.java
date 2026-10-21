        clusterState = ClusterState.builder(clusterState).metadata(metadata).build();
        logger.info("Start the primary shards");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder(clusterState.nodes()).add(newNode("node2"))).build();
        Matcher<String> node1Matcher = anyOf(equalTo("test"), equalTo("test1"));
            )
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
    }
                IndexMetadata.builder("test")
/*
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(2));
        Matcher<String> node2Matcher = relocatingIndex.equals("test1") ? equalTo("test1") : node1Matcher;
        assertThat(RoutingNodesUtils.numberOfShardsOfType(clusterState.getRoutingNodes(), RELOCATING), equalTo(2));
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
 * under the License.
        AllocationService strategy = createAllocationService(
        logger.info("Adding two nodes and performing rerouting");
import org.opensearch.cluster.metadata.IndexMetadata;
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.Logger;
                    .settings(
import java.util.stream.Stream;
import org.opensearch.cluster.routing.allocation.decider.ShardsLimitAllocationDecider;
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();
                IndexMetadata.builder("test")
        }
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(2));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                    )
            )
        // Bump the cluster total shards to 2
                .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2)
        return indices.iterator().next();
        Metadata metadata = Metadata.builder()
public class ShardsLimitAllocationTests extends OpenSearchAllocationTestCase {
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(0));
import java.util.stream.Collectors;
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 * Licensed to Elasticsearch under one or more contributor
 * KIND, either express or implied.  See the License for the
        Metadata metadata = Metadata.builder()
            .routingTable(routingTable)
                .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 1)
        assertThat(indices.size(), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(RELOCATING), equalTo(node2RelocCount));
        logger.info("Building initial routing table");
        logger.info("Building initial routing table");
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(STARTED), equalTo(5));
        logger.info("Adding two nodes and performing rerouting");
package org.opensearch.cluster.routing.allocation;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("Do another reroute, make sure shards are now allocated");
        );
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
 * specific language governing permissions and limitations
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("Adding one node and reroute");
            Settings.builder()
        startInitializingShardsAndReroute(strategy, clusterState);
 * You may obtain a copy of the License at
    private final Logger logger = LogManager.getLogger(ShardsLimitAllocationTests.class);
        AllocationService strategy = createAllocationService(
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(1));
            .put(
        logger.info("add another index with 5 shards");
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(newNode("node1"))).build();
import org.opensearch.cluster.routing.ShardRoutingState;
import static org.hamcrest.Matchers.equalTo;
    public void testClusterLevelShardsLimitAllocate() {
                IndexMetadata.builder("test")
        // moving the nodes to node2 since we consider INITIALIZING nodes during rebalance
        clusterState = strategy.reroute(clusterState, "reroute");
 * this work for additional information regarding copyright
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
                .build()
            .put(
                            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 3)
        logger.info("Start the primary shards");
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .flatMap(node -> node.shardsWithState(RELOCATING).stream().map(x -> x.getIndexName()))
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .collect(Collectors.toSet());
        logger.info("reroute after setting");
            .build();
        clusterState = ClusterState.builder(clusterState)
            Settings.builder().put("cluster.routing.allocation.node_concurrent_recoveries", 10).build()
                .build()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .metadata(metadata)
        assertThat(RoutingNodesUtils.numberOfShardsOfType(clusterState.getRoutingNodes(), STARTED), equalTo(8));
            Settings.builder()
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 */
 * software distributed under the License is distributed on an
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
import org.opensearch.cluster.ClusterState;
                IndexMetadata.builder(clusterState.metadata().index("test"))
        strategy = createAllocationService(
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
import org.opensearch.common.settings.Settings;
        Metadata metadata = Metadata.builder()
import java.util.Set;
    public void testIndexLevelShardsLimitAllocate() {
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                IndexMetadata.builder("test1")
            .build();
}
            .put(
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(2));
 * ownership. Elasticsearch licenses this file to you under
        metadata = Metadata.builder(clusterState.metadata())
 *     http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        String relocatingIndex = getRelocatingIndex(clusterState);
        );
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(2));
 * not use this file except in compliance with the License.
            )
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(0));
        logger.info("Building initial routing table");
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(RELOCATING), equalTo(node1RelocCount));
        logger.info("update {} for test, see that things move", ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey());
            .routingTable(initialRoutingTable)
                            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2)
            .build();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    private String getRelocatingIndex(ClusterState clusterState) {
        // AllocationConstraints will choose node2 for 3 test1 shards and the rest are assigned to node1
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 4)
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(2));
                            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .build();
        RoutingTable updatedRoutingTable = RoutingTable.builder(clusterState.routingTable()).addAsNew(metadata.index("test1")).build();
            .build();
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
        // the first move will destroy the balance and the balancer will move 2 shards from node2 to node one right after
/*
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
import org.opensearch.Version;
 * this file be licensed under the Apache-2.0 license or a
            .routingTable(routingTable)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import static org.hamcrest.Matchers.anyOf;
        int node2RelocCount = relocatingIndex.equals("test1") ? 2 : 0;
        logger.info("Do another reroute, make sure its still not allocated");
        logger.info("Start the primary shards");
        assertThat(clusterState.getRoutingNodes().node("node1").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(1));
 */
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(4));
            assertThat(shardRouting.getIndexName(), node1Matcher);
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(STARTED), equalTo(5));
        // Expected values depend on which index shards were chosen for relocation.
            assertThat(shardRouting.getIndexName(), node2Matcher);
                .put("cluster.routing.allocation.node_concurrent_recoveries", 10)
                    .settings(
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.routing.ShardRouting;
import org.apache.logging.log4j.LogManager;
 *
            .put(
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
 * The OpenSearch Contributors require contributions made to
    }
        clusterState = ClusterState.builder(clusterState).metadata(metadata).routingTable(updatedRoutingTable).build();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .put("cluster.routing.allocation.balance.index", 0.0f)
                    )
import org.opensearch.cluster.routing.RoutingTable;
import org.hamcrest.Matcher;
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
            )
/*
import org.opensearch.cluster.metadata.Metadata;
 *
                .put("cluster.routing.allocation.node_initial_primaries_recoveries", 10)
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = strategy.reroute(clusterState, "reroute");
        }
                .put("cluster.routing.allocation.balance.primary", 0.0f)
        final Set<String> indices = Stream.of(clusterState.getRoutingNodes())
        int node1RelocCount = relocatingIndex.equals("test1") ? 4 : 2;
                    )
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(STARTED), equalTo(3 - node2RelocCount));
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(0));
        );
            .build();
            .metadata(metadata)
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 5)
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                        settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 4)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        // now we are done compared to EvenShardCountAllocator since the Balancer is not soely based on the average
                    .settings(
                    )
 *
            .put(
        for (ShardRouting shardRouting : clusterState.getRoutingNodes().node("node1")) {
                .put("cluster.routing.allocation.balance.replica", 1.0f)
    public void testIndexLevelShardsLimitRemain() {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.opensearch.cluster.node.DiscoveryNodes;
            .build();
                    .settings(
        assertThat(RoutingNodesUtils.numberOfShardsOfType(clusterState.getRoutingNodes(), STARTED), equalTo(5));
            )
        // These shards then relocate to node2 after balanceByWeights() is invoked
            .build();
            .metadata(metadata)
    }
            Settings.builder()
 */
                .build()
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
                    .settings(
        for (ShardRouting shardRouting : clusterState.getRoutingNodes().node("node2")) {
        assertThat(clusterState.getRoutingNodes().unassigned().size(), equalTo(2));
                .put("cluster.routing.allocation.cluster_concurrent_rebalance", -1)
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.STARTED), equalTo(2));
        metadata = Metadata.builder(clusterState.metadata())
                    )
        assertThat(clusterState.getRoutingNodes().node("node2").numberOfShardsWithState(ShardRoutingState.INITIALIZING), equalTo(1));
        logger.info("Add another one node and reroute");
        AllocationService strategy = createAllocationService(
