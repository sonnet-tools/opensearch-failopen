 *     http://www.apache.org/licenses/LICENSE-2.0
                        .put(IndexMetadata.builder(meta1))
            .build();
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(6));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);  
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
 * software distributed under the License is distributed on an
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("Building initial routing table");
                for (ShardRouting routing : mutableShardRoutings) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                                    Settings.builder()  
                                            randomBoolean() ? Rebalance.PRIMARIES : Rebalance.ALL
            )
        ClusterSettings clusterSettings = new ClusterSettings(build, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        Metadata metadata = Metadata.builder()  
        RoutingTable initialRoutingTable = RoutingTable.builder()  
            .metadata(metadata)  
        } else {
            .build();
        );
            clusterState = ClusterState.builder(clusterState)
import org.opensearch.cluster.routing.ShardRouting;  
            "expected 6 shards to be started 2 to relocate useClusterSettings: " + useClusterSetting,
import org.opensearch.cluster.metadata.Metadata;  
 * the Apache License, Version 2.0 (the "License"); you may
            clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(),
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        AllocationService strategy = createAllocationService(build, clusterSettings, random());  
                // index settings override cluster settings
        }
        clusterSettings.applySettings(clusterState.metadata().settings());
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
        logger.info("--> adding one nodes and do rerouting");
    public void testClusterEnableNone() {
        } else {  
                                        .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), allowedOnes)
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Allocation;
            IndexMetadata meta = clusterState.getMetadata().index("test");
            )  
        final boolean useClusterSetting = randomBoolean();  
            IndexMetadata meta1 = clusterState.getMetadata().index("always_disabled");  
                    assertThat("only test index can rebalance", routing.getIndexName(), equalTo("test"));  
            IndexMetadata meta = clusterState.getMetadata().index("test");
        RoutingTable initialRoutingTable = RoutingTable.builder()  
            .addAsNew(metadata.index("always_disabled"))
        if (useClusterSetting) {  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import java.util.EnumSet;
            .build();
            case ALL:  
                }  
        logger.info("--> start the shards (replicas)");  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
                    assertFalse("only replicas are allowed to relocate", routing.primary());
        );
        clusterState = strategy.reroute(clusterState, "reroute");
        logger.info("--> start the shards (primaries)");
 * You may obtain a copy of the License at  
    }  
    public void testEnableClusterBalanceNoReplicas() {
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(8));  
                    assertThat("only test index can rebalance", routing.getIndexName(), equalTo("test"));
                                        .build()  
        clusterState = ClusterState.builder(clusterState)
                useClusterSetting ? Rebalance.NONE : RandomPicks.randomFrom(random(), Rebalance.values())
                        .put(  
                            Rebalance.NONE
                            IndexMetadata.builder(meta)
        logger.info("--> start the shards (primaries)");
            )
                    .numberOfReplicas(1)
        logger.info("--> adding one nodes and do rerouting");  
            clusterState = ClusterState.builder(clusterState)
            Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.PRIMARIES.name()).build()
            ? Settings.EMPTY  
            equalTo(4)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));  
        clusterState = strategy.reroute(clusterState, "reroute");
 * this file be licensed under the Apache-2.0 license or a
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            case PRIMARIES:  
            .addAsNew(metadata.index("enabled"))
            .put(ConcurrentRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING.getKey(), 3)
/*
                .build();
 */  
        Settings indexSettings = useClusterSetting
        assertThat(clusterState.getRoutingNodes().shardsWithState("disabled", STARTED).size(), equalTo(0));
    }  
        logger.info("--> start the shards (primaries)");  
                        )
 * ownership. Elasticsearch licenses this file to you under  
            .build();
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING;  
        clusterState = ClusterState.builder(clusterState)  
        switch (allowedOnes) {
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;  
            .build();  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                )
            )  
        clusterState = ClusterState.builder(clusterState)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(4));
        logger.info("--> start the shards (primaries)");
import org.opensearch.common.settings.Settings;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            : Settings.builder().put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), Rebalance.NONE).build();
package org.opensearch.cluster.routing.allocation.decider;
 *
        AllocationService strategy = createAllocationService(build, clusterSettings, random());
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
                                    randomBoolean() ? Rebalance.PRIMARIES : Rebalance.ALL  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .addAsNew(metadata.index("test"))
        clusterState = strategy.reroute(clusterState, "reroute");
            .put(
    }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
 * not use this file except in compliance with the License.
                    Metadata.builder(clusterState.metadata())  
                                )
    }  
                                .put(
        clusterState = ClusterState.builder(clusterState)
        AllocationService strategy = createAllocationService(  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        ClusterSettings clusterSettings = new ClusterSettings(build, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                .build();  
                )
                .build();
            .build();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        clusterState = strategy.reroute(clusterState, "reroute");
                                        .build()  
        Metadata metadata = Metadata.builder()
                                            EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),  
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(0));
 * SPDX-License-Identifier: Apache-2.0
            .routingTable(routingTable)
            .metadata(metadata)  
        logger.info("--> adding two nodes do rerouting");
        }
        logger.info("Building initial routing table");  
/*  
                                        .put(
                // index settings override cluster settings
            Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name()).build()  
            .routingTable(initialRoutingTable)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT).put(indexSettings)).numberOfShards(6).numberOfReplicas(0))
                    )  
 */
            .put(
            .build();
                    .settings(settings(Version.CURRENT).put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name()))
        assertThat(
                            IndexMetadata.builder(meta)
            : Settings.builder().put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), Rebalance.NONE).build();  
                IndexMetadata.builder("always_disabled")  
                        settings(Version.CURRENT).put(
        Metadata metadata = Metadata.builder()
            equalTo(6)  
        Metadata metadata = Metadata.builder()  
    }  
        );
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
            case REPLICAS:  
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(0));
        Settings build = Settings.builder()
            .put(IndexMetadata.builder("enabled").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))  
            .build();  
        final boolean useClusterSetting = randomBoolean();  
                for (ShardRouting routing : mutableShardRoutings) {
                                        )
        assertThat(
                break;
import org.opensearch.cluster.node.DiscoveryNodes;
 * compatible open source license.
            .routingTable(routingTable)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
 * under the License.  
            .build();
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));  
                                    CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
                                        .put(meta.getSettings())
        clusterSettings.applySettings(clusterState.metadata().settings());  
                .metadata(
        Settings build = Settings.builder()
                    .numberOfShards(1)  
            .metadata(metadata)  
        clusterState = ClusterState.builder(clusterState)
                                )
                                .build()
                }
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
            .metadata(metadata)
}  
 * this work for additional information regarding copyright
                    Metadata.builder(metadata)
            equalTo(2)
        metadata = clusterState.metadata();  
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();  
        );  
            .build();  
        assertThat(clusterState.getRoutingNodes().shardsWithState("enabled", STARTED).size(), equalTo(2));
 * license agreements. See the NOTICE file distributed with
        Settings indexSettings = useClusterSetting
            .build();
                    assertThat("only test index can rebalance", routing.getIndexName(), equalTo("test"));  
        clusterState = strategy.reroute(clusterState, "reroute");  
 * The OpenSearch Contributors require contributions made to  
                                .settings(
                                    Settings.builder()  
                break;
public class EnableAllocationTests extends OpenSearchAllocationTestCase {  
        logger.info("--> adding two nodes and do rerouting");
            .build();
                        )
                IndexMetadata.builder("disabled")
import org.opensearch.Version;
                break;
                CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),  
        logger.info("Building initial routing table");
        AllocationService strategy = createAllocationService(
        logger.info("--> adding two nodes and do rerouting");
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                .metadata(
        final Rebalance allowedOnes = RandomPicks.randomFrom(random(), EnumSet.of(Rebalance.PRIMARIES, Rebalance.REPLICAS, Rebalance.ALL));
            .build();
    public void testIndexEnableNone() {
                        .transientSettings(
            .addAsNew(metadata.index("disabled"))
                        .removeAllIndices()
 */  
                        .transientSettings(Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), allowedOnes).build())
import org.opensearch.cluster.ClusterState;  
            clusterState = ClusterState.builder(clusterState)
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
import org.opensearch.cluster.routing.allocation.AllocationService;
                }
import org.opensearch.cluster.metadata.IndexMetadata;
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 * Unless required by applicable law or agreed to in writing,
        }  
import org.opensearch.common.settings.ClusterSettings;
            default:
            "expected 4 primaries to be started and 2 to relocate useClusterSettings: " + useClusterSetting,  
        clusterState = strategy.reroute(clusterState, "reroute");
    public void testEnableClusterBalance() {
        );  
                    Metadata.builder(clusterState.metadata())  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
            .build();
            clusterState.getRoutingNodes().shardsWithState(STARTED).size(),
    public void testClusterEnableOnlyPrimaries() {
            .build();
import org.apache.logging.log4j.LogManager;  
            "expected 2 shards to relocate useClusterSettings: " + useClusterSetting,  
        AllocationService strategy = createAllocationService(Settings.builder().build());  
                    assertTrue("only primaries are allowed to relocate", routing.primary());
 * KIND, either express or implied.  See the License for the
                        .removeAllIndices()
 * specific language governing permissions and limitations
                        )
            .build();
import java.util.List;
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .build();
                                )
 *
        );
    private final Logger logger = LogManager.getLogger(EnableAllocationTests.class);
import org.apache.logging.log4j.Logger;
            .put(  
                        .put(  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Rebalance;  
                fail("only replicas, primaries or all are allowed");  
        if (useClusterSetting) {
        clusterState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING;
            .build();  
                    .numberOfShards(1)
                    .settings(
        logger.info("Building initial routing table");  
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(6));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
                useClusterSetting ? Rebalance.NONE : RandomPicks.randomFrom(random(), Rebalance.values())  
                .metadata(  
            .metadata(metadata)
                )  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(6));
 *  
        clusterState = ClusterState.builder(clusterState)  
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 10)  
import static org.hamcrest.Matchers.equalTo;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
/*  
            equalTo(2)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
            clusterState = ClusterState.builder(clusterState)
            .build();  
                for (ShardRouting routing : mutableShardRoutings) {
import org.opensearch.cluster.routing.RoutingTable;
                                .settings(
        logger.info("--> adding one nodes and do rerouting");
                )  
        List<ShardRouting> mutableShardRoutings = clusterState.getRoutingNodes().shardsWithState(RELOCATING);
                    .numberOfReplicas(1)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT).put(indexSettings)).numberOfShards(3).numberOfReplicas(1))
                            EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),  
            .build();
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
        clusterState = ClusterState.builder(clusterState)
 * GitHub history for details.
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(8));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            .put(  
        assertThat(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.info("--> adding one nodes and do rerouting");
            .put(ConcurrentRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING.getKey(), 3)
 * Modifications Copyright OpenSearch Contributors. See
            clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(),  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            "expected 2 primaries to relocate useClusterSettings: " + useClusterSetting,
            ? Settings.EMPTY
                                        .put(meta.getSettings())
        logger.info("--> verify only enabled index has been routed");  
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
                        )  
                            Settings.builder()  
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(4));  
            .build();
                .metadata(  
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();  
            clusterState.getRoutingNodes().shardsWithState(STARTED).size(),
            .routingTable(initialRoutingTable)
        Metadata metadata = Metadata.builder()
                    Metadata.builder(metadata)
                .build();
            .routingTable(initialRoutingTable)  
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(8));  
        assertThat(
