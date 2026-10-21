import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .put(
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING;
                .add(newNode("node1", attrMap("tag1", "value1")))
            result.put(keysValues[i], keysValues[i + 1]);
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
        );
    public void testClusterExcludeFiltersOptionalAttribute() {
        if (keysValues.length == 0) {
import static org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider.CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING;
                    .settings(Settings.builder().put(existingMetadata.getSettings()).put(updatedIndexSettings.build()).build())
                .put(INDEX_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag2", "value2"),
    }
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), "1")
                .add(newNode("node4", attrMap("tag2", "also_exclude_this")))
        for (ShardRouting startedShard : startedShards) {
    public void testClusterIncludeFiltersWildcards() {
            .build();
        logger.info("--> start the shards (replicas)");
        );
            Settings.builder().put(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value2"),
    /**
                .add(newNode("node3", attrMap()))
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag2", "*incl*"),
        Map<String, String> result = new HashMap<>();
        );
            Settings.builder()
                .add(newNode("node4", attrMap("tag2", "value4")))
import org.opensearch.cluster.routing.ShardRoutingState;
        logger.info("--> switch between value2 and value4, shards should be relocating");
            Settings.builder()
            Settings.builder()
                .add(newNode("node2", attrMap("tag2", "also_include_this")))
        }
        testIndexFilters(
                .add(newNode("node5", attrMap("tag2", "value2", "tag3", "value3")))
                .add(newNode("node4", attrMap("tag1", "other", "tag2", "req2")))
            Settings.builder()
 * specific language governing permissions and limitations
    }
                .add(newNode("node1", attrMap("tag1", "value1")))
                .add(newNode("node3", attrMap("tag1", "value3")))
            .build();
        assertThat(clusterState.getRoutingNodes().node(node1.getId()).numberOfShardsWithState(INITIALIZING), equalTo(2));
                .add(newNode("node4", attrMap("tag1", "value4")))
        }
        logger.info("Building initial routing table");
                .add(newNode("node3", attrMap("tag1", "included_by_tag1", "tag2", "excluded_by_tag2")))
                .add(newNode("node1", attrMap("tag1", "value1")))
 * not use this file except in compliance with the License.
        );
        clusterState = strategy.reroute(clusterState, "reroute");
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value1")
        testIndexFilters(
        testClusterFilters(
            DiscoveryNodes.builder()
                .add(newNode("node4", attrMap()))
        for (int i = 0; i < keysValues.length; i += 2) {
                .add(newNode("node1", attrMap("tag1", "value1")))
            .addAsNew(metadata.index("test2"))
            Settings.builder().put(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3,value4"),
import static org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider.CLUSTER_ROUTING_INCLUDE_GROUP_SETTING;
     * A test that creates a 2p1r index and which expects the given allocation service's settings only to allocate the shards of this index
        logger.info("--> start the shards (primaries)");
        );
    }
        if (keysValues.length == 2) {
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(STARTED), equalTo(2));
        List<ShardRouting> startedShards = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED);
    public void testClusterIncludeAndExcludeFilters() {
                .add(newNode("node3", attrMap("tag1", "value3")))
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "*excl*")
        testClusterFilters(
            assertThat(startedShard.currentNodeId(), Matchers.anyOf(equalTo("node1"), equalTo("node2")));
        final AllocationService strategy = createAllocationService(allocationServiceSettings.build());
        );
                .add(newNode("node3", attrMap("tag1", "exclude_this")))
            DiscoveryNodes.builder()
 */
import org.opensearch.cluster.routing.RoutingTable;
            Settings.builder()
                .put(INDEX_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag3", "value3"),
            DiscoveryNodes.builder()
                .add(newNode("node2", attrMap("tag1", "value2")))
                .add(newNode("node3", attrMap("tag1", "value3")))
}
        );
    public void testClusterExcludeFiltersWildcards() {
import org.hamcrest.Matchers;
    public void testIndexExcludeFilters() {
        final Metadata metadata = Metadata.builder()
        logger.info("--> move shards from node1 to node2");
                .add(newNode("node4", attrMap("tag2", "also_exclude_this")))
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag2", "value2"),
                .add(newNode("node1", attrMap("tag1", "value1")))
     */
            DiscoveryNodes.builder()
            .addAsNew(metadata.index("test1"))
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3")
        logger.info("--> start the shards (primaries)");
                .add(newNode("node2", attrMap("tag1", "value1", "tag2", "value2", "tag3", "other")))
                .add(newNode("node3", attrMap("tag1", "value3")))
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING;
            Settings.builder().put(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3,value4"),
            Settings.builder().put(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value4"),
        RoutingTable initialRoutingTable = RoutingTable.builder()
        assertThat(startedShards.size(), equalTo(4));
    private static Map<String, String> attrMap(String... keysValues) {
        final Metadata initialMetadata = Metadata.builder()
                            .put(initialIndexSettings.build())
        logger.info("--> make sure shards are only allocated on tag1 with value1 and value2");
            Settings.builder().put(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value2"),
            DiscoveryNodes.builder()
                .add(newNode("node3", attrMap("tag1", "value3")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(2));
            )
        testClusterFilters(
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "*incl*")
                .put(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value2,value3")
        }
        );
            .build();
        );
import org.opensearch.cluster.metadata.IndexMetadata;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
import org.opensearch.cluster.ClusterState;
                .add(newNode("node2", attrMap("tag2", "value2")))
                .add(newNode("node1", attrMap()))
 *
 * under the License.
        for (ShardRouting startedShard : startedShards) {
            .build();
                .add(newNode("node4", attrMap("tag2", "value4")))
                .add(newNode("node4", attrMap("tag1", "excluded_by_tag1", "tag2", "included_by_tag2")))
    }
                .add(newNode("node2", attrMap("tag2", "also_include_this")))
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(STARTED), equalTo(4));
import org.opensearch.cluster.metadata.Metadata;
    }
            DiscoveryNodes.builder()
            DiscoveryNodes.builder()
import static org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider.CLUSTER_ROUTING_REQUIRE_GROUP_SETTING;
            return singletonMap(keysValues[0], keysValues[1]);
 * compatible open source license.
                .add(newNode("node2", attrMap("tag1", "also_include_this", "tag2", "ok_by_tag2")))
                .add(newNode("node1", attrMap("tag1", "value1")))
     * on updating the index allocation settings the shards should be relocated to nodes `node1` and `node4`.
import org.opensearch.cluster.node.DiscoveryNodes;
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(INITIALIZING), equalTo(1));
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(INITIALIZING), equalTo(2));
            .metadata(metadata)
        testIndexFilters(
    }
                .add(newNode("node4", attrMap("tag1", "value4")))
            )
            .routingTable(initialRoutingTable)
            Settings.builder()
        );
        }
                .add(newNode("node4", attrMap("tag1", "value4")))
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING;
        logger.info("--> make sure shards are only allocated on tag1 with value1 and value2");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        final IndexMetadata existingMetadata = clusterState.metadata().index("test");
            DiscoveryNodes.builder()
                .add(newNode("node1", attrMap("tag1", "do_include_this")))
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node1).add(node2)).build();
                .add(newNode("node1", attrMap()))
 * the Apache License, Version 2.0 (the "License"); you may
        testClusterFilters(
 * Licensed to Elasticsearch under one or more contributor
            .build();
        strategy = createAllocationService(
    public void testIndexRequireFilters() {
            assertThat(startedShard.currentNodeId(), Matchers.anyOf(equalTo("node1"), equalTo("node4")));
        logger.info("Building initial routing table");
    }
        logger.info("--> check that concurrent recoveries only allows 1 shard to move");
            DiscoveryNodes.builder()
        logger.info("--> finish relocation");
     * A test that creates a 2p1r index and expects the given index allocation settings only to allocate the shards to `node1` and `node2`;
            .build();
                .add(newNode("node2", attrMap("tag1", "value2")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
        }
 *
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            .metadata(metadata)
package org.opensearch.cluster.routing.allocation;
                        settings(Version.CURRENT).put("index.number_of_shards", 2)
    public void testConcurrentRecoveriesAfterShardsCannotRemainOnNode() {
        clusterState = strategy.reroute(clusterState, "reroute");
    }
            Settings.builder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(2));
                .put(CLUSTER_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag1", "req1")
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        for (ShardRouting startedShard : startedShards) {
            DiscoveryNodes.builder()
    public void testClusterIncludeFiltersSingleAttribute() {
                .add(newNode("node3", attrMap("tag1", "value3")))
        return result;
 */
    /**
        logger.info("--> start the shards (only primaries)");
        testIndexFilters(
            .routingTable(initialRoutingTable)
        startedShards = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED);
 * software distributed under the License is distributed on an
        logger.info("--> start the shards (only primaries)");
        logger.info("--> move second shard from node1 to node2");
 * The OpenSearch Contributors require contributions made to
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag2", "value4"),
                .add(newNode("node2", attrMap()))
                .add(newNode("node4", attrMap()))
        DiscoveryNode node2 = newNode("node2", singletonMap("tag1", "value2"));
            .metadata(initialMetadata)
            .nodes(nodes)
    }
        testClusterFilters(
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag2", "*excl*"),
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
            Settings.builder().put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value2"),
            .routingTable(initialRoutingTable)
                IndexMetadata.builder(existingMetadata)
        logger.info("--> disable allocation for node1 and reroute");
        logger.info("--> rerouting");
 * Modifications Copyright OpenSearch Contributors. See
            Settings.builder()
        logger.info("--> rerouting");
                .add(newNode("node4", attrMap("tag1", "value4")))
        logger.info("--> start the shards (replicas)");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            DiscoveryNodes.builder()
                .add(newNode("node4", attrMap("tag1", "value4")))
        logger.info("Building initial routing table");
import org.opensearch.Version;
        clusterState = strategy.reroute(clusterState, "reroute");
            Settings.builder()
        );
                .putNull(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1"),
                    .settings(
    public void testIndexIncludeFilters() {
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING;
                .add(newNode("node3", attrMap("tag1", "value3")))
        testClusterFilters(
            Settings.builder()
            .put(
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    }
 */
    }
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(STARTED), equalTo(3));
 * this file be licensed under the Apache-2.0 license or a
        logger.info("--> adding two nodes and performing rerouting");
    }
                .putNull(INDEX_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag2")
        assertThat(startedShards.size(), equalTo(4));
/*
                .add(newNode("node2", attrMap("tag1", "value2")))
        final RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                .add(newNode("node6", attrMap()))
                .add(newNode("node1", attrMap("tag1", "req1", "tag2", "req2")))
        testClusterFilters(
 * license agreements. See the NOTICE file distributed with
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(INITIALIZING), equalTo(1));
        testClusterFilters(
            DiscoveryNodes.builder()
        final List<ShardRouting> startedShards = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED);
                    )
        assertThat(clusterState.getRoutingNodes().node(node1.getId()).numberOfShardsWithState(STARTED), equalTo(1));
                .add(newNode("node1", attrMap("tag1", "do_include_this")))
                .add(newNode("node2", attrMap("tag1", "value2")))
    public void testClusterExcludeFiltersMultipleAttributes() {
    }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    public void testClusterIncludeFiltersMultipleAttributes() {
                .add(newNode("node3", attrMap("tag1", "value3")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
 * SPDX-License-Identifier: Apache-2.0
                .add(newNode("node3", attrMap("tag1", "req1")))
import static java.util.Collections.singletonMap;
        );
        );
 * ownership. Elasticsearch licenses this file to you under
            return emptyMap();
                .add(newNode("node5", attrMap()))
                .add(newNode("node4", attrMap("tag1", "value1", "tag2", "other", "tag3", "value3")))
import static java.util.Collections.emptyMap;
import java.util.HashMap;
                .add(newNode("node1", attrMap("tag1", "value1", "tag2", "value2", "tag3", "value3")))
            assertThat(startedShard.currentNodeId(), Matchers.anyOf(equalTo("node1"), equalTo("node2")));
        clusterState = strategy.reroute(clusterState, "reroute");
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1")
    }
            DiscoveryNodes.builder()
                IndexMetadata.builder("test")
    public void testClusterExcludeFiltersSingleAttribute() {
                .add(newNode("node3", attrMap("tag1", "exclude_this")))
            .build();
        logger.info("--> make sure all shards are started");
 * this work for additional information regarding copyright
        testIndexFilters(
            .build();
        clusterState = strategy.reroute(clusterState, "reroute");
    private void testIndexFilters(Settings.Builder initialIndexSettings, Settings.Builder updatedIndexSettings, Builder nodesBuilder) {
            Settings.builder().put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3,value4"),
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
                .add(newNode("node1", attrMap("tag1", "value1")))
        Metadata metadata = Metadata.builder()
        assertThat(startedShards.size(), equalTo(4));
                .add(newNode("node2", attrMap("tag1", "value2")))
        clusterState = ClusterState.builder(clusterState).metadata(updatedMetadata).build();
    }
        AllocationService strategy = createAllocationService(Settings.builder().build());
            DiscoveryNodes.builder()
/*
    public void testIndexExcludeThenIncludeFilters() {
        }
                .add(newNode("node1", attrMap("tag1", "do_include_this")))
        DiscoveryNode node1 = newNode("node1", singletonMap("tag1", "value1"));
                .put(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value4")
import java.util.Map;
    }
        final RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(initialMetadata.index("test")).build();
    }
public class FilterRoutingTests extends OpenSearchAllocationTestCase {
            Settings.builder().put(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value2,value3"),
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
            DiscoveryNodes.builder()
    }
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("--> start the shards (only primaries)");
/*
                .put(INDEX_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag1", "value1")
                .add(newNode("node2", attrMap("tag1", "req1", "tag2", "req2")))
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at
        testClusterFilters(
                .add(newNode("node3", attrMap("tag1", "value3")))
                .add(newNode("node2", attrMap()))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    }
        clusterState = strategy.reroute(clusterState, "reroute");
 * KIND, either express or implied.  See the License for the
                            .put("index.number_of_replicas", 1)
import java.util.List;
        testClusterFilters(
        );
 * GitHub history for details.
 *
                .add(newNode("node2", attrMap("tag2", "value2")))
import org.opensearch.cluster.routing.ShardRouting;
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testClusterIncludeFiltersOptionalAttribute() {
            .nodes(nodesBuilder)
                .build()
        AllocationService strategy = createAllocationService(Settings.builder().build());
            Settings.builder().put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value2"),
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.settings.Settings;
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            Settings.builder().put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3,value4"),
     * to `node1` and `node2`.
import org.opensearch.cluster.node.DiscoveryNode;
    private void testClusterFilters(Settings.Builder allocationServiceSettings, DiscoveryNodes.Builder nodes) {
    public void testIndexIncludeThenExcludeFilters() {
                .add(newNode("node1", attrMap("tag1", "value1")))
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        final Metadata updatedMetadata = Metadata.builder()
        );
                .put(CLUSTER_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag2", "req2"),
    public void testClusterRequireFilters() {
                .add(newNode("node3", attrMap("tag1", "other", "tag2", "value2", "tag3", "other")))
        clusterState = strategy.reroute(clusterState, "reroute");
            Settings.builder()
                .add(newNode("node2", attrMap("tag1", "value2")))
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag2", "*excl*"),
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "*incl*")
                .putNull(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1"),
                .add(newNode("node4", attrMap("tag1", "value4")))
