 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .add(newNode("node2", attrMap("tag1", "value2")))
        logger.info("--> start the shards (only primaries)");
            .build();  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            DiscoveryNodes.builder()
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING;  
        final RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(initialMetadata.index("test")).build();
            Settings.builder().put(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value2"),  
        Map<String, String> result = new HashMap<>();
                .add(newNode("node4", attrMap("tag1", "value4")))
        );
                .add(newNode("node3", attrMap("tag1", "exclude_this")))  
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3")
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(INITIALIZING), equalTo(2));
            Settings.builder()  
                .add(newNode("node2", attrMap("tag2", "also_include_this")))
                .add(newNode("node1", attrMap("tag1", "value1")))
                .add(newNode("node4", attrMap("tag1", "value4")))  
            Settings.builder()  
                .add(newNode("node3", attrMap("tag1", "value3")))  
                .put(CLUSTER_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag1", "req1")  
import org.opensearch.cluster.routing.ShardRouting;
            .addAsNew(metadata.index("test2"))  
            Settings.builder()
        logger.info("--> start the shards (only primaries)");
            .build();
 * The OpenSearch Contributors require contributions made to  
    }
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(STARTED), equalTo(2));
        for (int i = 0; i < keysValues.length; i += 2) {  
                    .settings(Settings.builder().put(existingMetadata.getSettings()).put(updatedIndexSettings.build()).build())
        AllocationService strategy = createAllocationService(Settings.builder().build());
                .add(newNode("node4", attrMap("tag1", "value4")))
                    .settings(
                .put(CLUSTER_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag2", "req2"),
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
            assertThat(startedShard.currentNodeId(), Matchers.anyOf(equalTo("node1"), equalTo("node4")));  
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    public void testClusterIncludeFiltersSingleAttribute() {
    }
        testIndexFilters(
                .add(newNode("node4", attrMap()))
            Settings.builder()  
                IndexMetadata.builder("test")
}  
import org.opensearch.cluster.node.DiscoveryNode;  
            result.put(keysValues[i], keysValues[i + 1]);
            DiscoveryNodes.builder()
            DiscoveryNodes.builder()  
                .add(newNode("node1", attrMap("tag1", "value1")))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            DiscoveryNodes.builder()
                .add(newNode("node1", attrMap("tag1", "value1")))  
    }  
        assertThat(clusterState.getRoutingNodes().node(node1.getId()).numberOfShardsWithState(STARTED), equalTo(1));  
public class FilterRoutingTests extends OpenSearchAllocationTestCase {  
        clusterState = strategy.reroute(clusterState, "reroute");
        assertThat(startedShards.size(), equalTo(4));  
            .metadata(initialMetadata)
        logger.info("--> rerouting");  
        logger.info("Building initial routing table");
                .add(newNode("node3", attrMap("tag1", "value3")))
        );
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_ROUTING_INCLUDE_GROUP_SETTING;
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(STARTED), equalTo(3));
 * software distributed under the License is distributed on an
                .add(newNode("node1", attrMap("tag1", "req1", "tag2", "req2")))  
                .add(newNode("node2", attrMap("tag1", "value2")))  
                .add(newNode("node1", attrMap("tag1", "value1")))  
            .build();
                .add(newNode("node3", attrMap("tag1", "exclude_this")))  
    }
                .add(newNode("node4", attrMap("tag1", "value1", "tag2", "other", "tag3", "value3")))
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag2", "value4"),
            assertThat(startedShard.currentNodeId(), Matchers.anyOf(equalTo("node1"), equalTo("node2")));
                .add(newNode("node3", attrMap("tag1", "value3")))
        List<ShardRouting> startedShards = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED);
 * KIND, either express or implied.  See the License for the
                .add(newNode("node1", attrMap()))  
        clusterState = strategy.reroute(clusterState, "reroute");  
 *
        strategy = createAllocationService(
    }
        }
    }  
            DiscoveryNodes.builder()  
                .add(newNode("node4", attrMap("tag2", "also_exclude_this")))
import org.opensearch.cluster.node.DiscoveryNodes;
                .add(newNode("node2", attrMap("tag1", "value2")))  
     */
import org.hamcrest.Matchers;
        );
        );
    }  
                .putNull(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1"),
 */  
    public void testClusterExcludeFiltersWildcards() {
            Settings.builder()
        testClusterFilters(  
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "*incl*")
    }
import java.util.HashMap;  
            DiscoveryNodes.builder()
                .add(newNode("node1", attrMap("tag1", "do_include_this")))
 * this file be licensed under the Apache-2.0 license or a
                .add(newNode("node4", attrMap("tag2", "also_exclude_this")))
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .nodes(nodesBuilder)  
 * not use this file except in compliance with the License.
            .addAsNew(metadata.index("test1"))
        final List<ShardRouting> startedShards = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED);
import static org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider.CLUSTER_ROUTING_INCLUDE_GROUP_SETTING;
    private static Map<String, String> attrMap(String... keysValues) {
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag2", "value2"),
        );
            Settings.builder().put(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3,value4"),
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_ROUTING_EXCLUDE_GROUP_SETTING;
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "*incl*")
                .add(newNode("node3", attrMap("tag1", "value3")))
                .add(newNode("node6", attrMap()))
        startedShards = clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED);  
                .add(newNode("node2", attrMap("tag2", "value2")))
            DiscoveryNodes.builder()
     * to `node1` and `node2`.
                .add(newNode("node3", attrMap("tag1", "value3")))
                .add(newNode("node2", attrMap()))
                .add(newNode("node1", attrMap()))  
                .put(INDEX_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag2", "value2"),  
    public void testClusterIncludeFiltersWildcards() {
        );  
/*
            .build();
 */
        logger.info("--> finish relocation");  
    public void testClusterIncludeFiltersOptionalAttribute() {
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(INITIALIZING), equalTo(1));
        assertThat(startedShards.size(), equalTo(4));  
        testClusterFilters(
        logger.info("--> move shards from node1 to node2");  
import static org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider.CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING;  
            .routingTable(initialRoutingTable)
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))
    public void testClusterRequireFilters() {  
        final RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        if (keysValues.length == 0) {
        logger.info("--> check that concurrent recoveries only allows 1 shard to move");
        final IndexMetadata existingMetadata = clusterState.metadata().index("test");
                IndexMetadata.builder(existingMetadata)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(2));
                .add(newNode("node2", attrMap()))
            Settings.builder().put(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value4"),  
import static java.util.Collections.singletonMap;
        testClusterFilters(
     * A test that creates a 2p1r index and which expects the given allocation service's settings only to allocate the shards of this index
                .add(newNode("node3", attrMap("tag1", "value3")))  
 * You may obtain a copy of the License at  
        RoutingTable initialRoutingTable = RoutingTable.builder()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
    }
    /**  
                            .put(initialIndexSettings.build())
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(STARTED), equalTo(4));
        assertThat(clusterState.getRoutingNodes().node(node2.getId()).numberOfShardsWithState(INITIALIZING), equalTo(1));  
                .add(newNode("node1", attrMap("tag1", "value1")))
            )  
import org.opensearch.cluster.node.DiscoveryNodes.Builder;
            DiscoveryNodes.builder()  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
    /**
        );
        final Metadata updatedMetadata = Metadata.builder()
                .add(newNode("node2", attrMap("tag1", "value1", "tag2", "value2", "tag3", "other")))  
    public void testIndexIncludeThenExcludeFilters() {
        logger.info("--> start the shards (replicas)");
        if (keysValues.length == 2) {
    private void testIndexFilters(Settings.Builder initialIndexSettings, Settings.Builder updatedIndexSettings, Builder nodesBuilder) {  
        );
        testIndexFilters(
     * on updating the index allocation settings the shards should be relocated to nodes `node1` and `node4`.
        );
                .add(newNode("node4", attrMap("tag1", "other", "tag2", "req2")))  
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag2", "*excl*"),
import org.opensearch.common.settings.Settings;  
            Settings.builder().put(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3,value4"),  
        clusterState = strategy.reroute(clusterState, "reroute");
            return emptyMap();  
                .add(newNode("node1", attrMap("tag1", "do_include_this")))
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value1")
        );
                .put(INDEX_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag1", "value1")
            .put(  
    public void testClusterIncludeFiltersMultipleAttributes() {
                .add(newNode("node1", attrMap("tag1", "do_include_this")))
import static org.opensearch.cluster.routing.allocation.decider.FilterAllocationDecider.CLUSTER_ROUTING_REQUIRE_GROUP_SETTING;
            .metadata(metadata)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            Settings.builder().put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3,value4"),
            DiscoveryNodes.builder()
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag2", "*excl*"),  
                .add(newNode("node3", attrMap()))
        testIndexFilters(  
    }
                .add(newNode("node4", attrMap("tag2", "value4")))
                .build()  
        );
                .putNull(INDEX_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag2")
            .build();
        }  
        testClusterFilters(  
/*  
                .add(newNode("node4", attrMap("tag1", "value4")))  
                            .put("index.number_of_replicas", 1)
                .add(newNode("node5", attrMap()))  
 * Unless required by applicable law or agreed to in writing,
                        settings(Version.CURRENT).put("index.number_of_shards", 2)  
     * A test that creates a 2p1r index and expects the given index allocation settings only to allocate the shards to `node1` and `node2`;  
            .routingTable(initialRoutingTable)
            .put(  
        logger.info("--> disable allocation for node1 and reroute");
                .add(newNode("node2", attrMap("tag2", "also_include_this")))
        logger.info("--> start the shards (primaries)");
            Settings.builder()
                .add(newNode("node4", attrMap("tag1", "value4")))  
        );
    public void testIndexIncludeFilters() {  
        AllocationService strategy = createAllocationService(Settings.builder().build());
            DiscoveryNodes.builder()
        DiscoveryNode node1 = newNode("node1", singletonMap("tag1", "value1"));  
import org.opensearch.cluster.routing.RoutingTable;  
            DiscoveryNodes.builder()
                .add(newNode("node1", attrMap("tag1", "value1")))
                .add(newNode("node1", attrMap("tag1", "value1", "tag2", "value2", "tag3", "value3")))
        final AllocationService strategy = createAllocationService(allocationServiceSettings.build());
        logger.info("--> switch between value2 and value4, shards should be relocating");
            .nodes(nodes)  
        final Metadata metadata = Metadata.builder()  
 * compatible open source license.
        logger.info("--> start the shards (only primaries)");  
    }  
import static org.hamcrest.Matchers.equalTo;
                .add(newNode("node5", attrMap("tag2", "value2", "tag3", "value3")))  
            Settings.builder()  
 *  
        assertThat(clusterState.getRoutingNodes().node(node1.getId()).numberOfShardsWithState(INITIALIZING), equalTo(2));
        clusterState = ClusterState.builder(clusterState).nodes(DiscoveryNodes.builder().add(node1).add(node2)).build();
        logger.info("Building initial routing table");  
        );
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.routing.ShardRoutingState;
        );
            Settings.builder().put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value2"),
 * this work for additional information regarding copyright
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                .add(newNode("node4", attrMap("tag2", "value4")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.STARTED).size(), equalTo(2));
            return singletonMap(keysValues[0], keysValues[1]);  
        for (ShardRouting startedShard : startedShards) {
                .add(newNode("node3", attrMap("tag1", "included_by_tag1", "tag2", "excluded_by_tag2")))
    public void testClusterExcludeFiltersMultipleAttributes() {
 * under the License.  
    public void testIndexExcludeThenIncludeFilters() {  
                .add(newNode("node2", attrMap("tag1", "value2")))
    }  
 * specific language governing permissions and limitations
        testClusterFilters(  
            .build();
                .add(newNode("node4", attrMap()))  
import static org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING;  
            .build();
    }
        logger.info("--> start the shards (primaries)");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
        testClusterFilters(
 *     http://www.apache.org/licenses/LICENSE-2.0
        logger.info("Building initial routing table");
    }  
                .add(newNode("node1", attrMap("tag1", "value1")))
 */  
                .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_RECOVERIES_SETTING.getKey(), "1")
/*  
import org.opensearch.cluster.metadata.Metadata;
import java.util.List;
        logger.info("--> rerouting");  
            )
 * Modifications Copyright OpenSearch Contributors. See
    public void testClusterExcludeFiltersSingleAttribute() {
 *
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
        );  
            DiscoveryNodes.builder()  
    }
        testClusterFilters(  
    }
            Settings.builder().put(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value2"),
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.RELOCATING).size(), equalTo(2));  
                .add(newNode("node2", attrMap("tag1", "req1", "tag2", "req2")))
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(0))  
        }
    public void testConcurrentRecoveriesAfterShardsCannotRemainOnNode() {
                .put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "*excl*")
import org.opensearch.cluster.metadata.IndexMetadata;
        for (ShardRouting startedShard : startedShards) {
                .add(newNode("node2", attrMap("tag1", "value2")))
        testClusterFilters(
import org.opensearch.cluster.ClusterState;
            Settings.builder()  
        ClusterState clusterState = ClusterState.builder(CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        DiscoveryNode node2 = newNode("node2", singletonMap("tag1", "value2"));
        return result;  
        logger.info("--> make sure shards are only allocated on tag1 with value1 and value2");
        logger.info("--> make sure shards are only allocated on tag1 with value1 and value2");
                .putNull(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1"),  
package org.opensearch.cluster.routing.allocation;
 * GitHub history for details.
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                .add(newNode("node1", attrMap("tag1", "value1")))
                .put(INDEX_ROUTING_REQUIRE_GROUP_SETTING.getKey() + "tag3", "value3"),  
    public void testIndexRequireFilters() {
            Settings.builder().put(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value2,value3"),
        logger.info("--> move second shard from node1 to node2");
import static java.util.Collections.emptyMap;
import org.opensearch.Version;
        testIndexFilters(
            Settings.builder()
    public void testIndexExcludeFilters() {
                .add(newNode("node3", attrMap("tag1", "value3")))  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_ROUTING_REQUIRE_GROUP_SETTING;  
                .add(newNode("node4", attrMap("tag1", "excluded_by_tag1", "tag2", "included_by_tag2")))
                .add(newNode("node2", attrMap("tag1", "value2")))
        clusterState = strategy.reroute(clusterState, "reroute");
                .add(newNode("node3", attrMap("tag1", "req1")))
 * Licensed to Elasticsearch under one or more contributor  
            .metadata(metadata)
        clusterState = strategy.reroute(clusterState, "reroute");  
            assertThat(startedShard.currentNodeId(), Matchers.anyOf(equalTo("node1"), equalTo("node2")));
            Settings.builder()
    }
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag2", "*incl*"),
        }  
                .add(newNode("node2", attrMap("tag2", "value2")))
        assertThat(clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).size(), equalTo(2));
        );
        testClusterFilters(  
                .add(newNode("node3", attrMap("tag1", "value3")))
 * SPDX-License-Identifier: Apache-2.0
                .put(INDEX_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value4")
        }
                .add(newNode("node3", attrMap("tag1", "other", "tag2", "value2", "tag3", "other")))
    }
 * license agreements. See the NOTICE file distributed with
        logger.info("--> start the shards (replicas)");
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(startedShards.size(), equalTo(4));
        logger.info("--> adding two nodes and performing rerouting");
                .put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1")
        clusterState = ClusterState.builder(clusterState).metadata(updatedMetadata).build();  
 * ownership. Elasticsearch licenses this file to you under  
            .build();
    private void testClusterFilters(Settings.Builder allocationServiceSettings, DiscoveryNodes.Builder nodes) {
            Settings.builder().put(CLUSTER_ROUTING_INCLUDE_GROUP_SETTING.getKey() + "tag1", "value1,value2"),
        for (ShardRouting startedShard : startedShards) {
            DiscoveryNodes.builder()
        final Metadata initialMetadata = Metadata.builder()
        testClusterFilters(
            Settings.builder()  
        testIndexFilters(
     */  
                .add(newNode("node3", attrMap("tag1", "value3")))
    public void testClusterExcludeFiltersOptionalAttribute() {
            DiscoveryNodes.builder()
                .put(INDEX_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value2,value3")
            Settings.builder().put(CLUSTER_ROUTING_EXCLUDE_GROUP_SETTING.getKey() + "tag1", "value3,value4"),
                .add(newNode("node2", attrMap("tag1", "also_include_this", "tag2", "ok_by_tag2")))  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        logger.info("--> make sure all shards are started");
            DiscoveryNodes.builder()  
                .add(newNode("node4", attrMap("tag1", "value4")))  
import java.util.Map;
        }
    public void testClusterIncludeAndExcludeFilters() {
    }
                    )  
            .routingTable(initialRoutingTable)
