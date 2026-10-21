                .build();
            .put(
        clusterState = ClusterState.builder(clusterState)
        clusterState = strategy.reroute(clusterState, "reroute");
                            IndexMetadata.builder(meta)
                    assertThat("only test index can rebalance", routing.getIndexName(), equalTo("test"));
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
                .metadata(
            )
            .build();
 *
                    .numberOfReplicas(1)
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(8));
            .metadata(metadata)
                    assertTrue("only primaries are allowed to relocate", routing.primary());
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        clusterState = strategy.reroute(clusterState, "reroute");
            .build();
                                .settings(
        Metadata metadata = Metadata.builder()
            equalTo(4)
                CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
                                .build()
                .build();
            .metadata(metadata)
            .routingTable(routingTable)
            equalTo(2)
        logger.info("--> start the shards (replicas)");
        clusterState = strategy.reroute(clusterState, "reroute");
                .metadata(
                                    randomBoolean() ? Rebalance.PRIMARIES : Rebalance.ALL
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        clusterSettings.applySettings(clusterState.metadata().settings());
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.equalTo;
                                )
            )
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        RoutingTable initialRoutingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(4));
    private final Logger logger = LogManager.getLogger(EnableAllocationTests.class);
            : Settings.builder().put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), Rebalance.NONE).build();
/*
            .build();
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
        if (useClusterSetting) {
        Metadata metadata = Metadata.builder()
                        )
                        .put(
        final boolean useClusterSetting = randomBoolean();
                    )
                for (ShardRouting routing : mutableShardRoutings) {
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        );
 * The OpenSearch Contributors require contributions made to
        assertThat(clusterState.getRoutingNodes().shardsWithState("disabled", STARTED).size(), equalTo(0));
        } else {
                )
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
        clusterState = ClusterState.builder(clusterState)
            case ALL:
        Settings build = Settings.builder()
                    .numberOfReplicas(1)
        );
        clusterState = strategy.reroute(clusterState, "reroute");
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
            .build();
    }
                break;
            .build();
                IndexMetadata.builder("disabled")
            case PRIMARIES:
            .build();
    public void testClusterEnableNone() {
        AllocationService strategy = createAllocationService(build, clusterSettings, random());
        );
import org.opensearch.Version;
                // index settings override cluster settings
        );
            .build();
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
import org.opensearch.cluster.ClusterState;
            .metadata(metadata)
                fail("only replicas, primaries or all are allowed");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(8));
                .build();
                            Rebalance.NONE
        assertThat(clusterState.getRoutingNodes().shardsWithState("enabled", STARTED).size(), equalTo(2));
 */
                                        .put(
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
import org.opensearch.cluster.metadata.IndexMetadata;
        logger.info("Building initial routing table");
        );
        Metadata metadata = Metadata.builder()
        logger.info("--> verify only enabled index has been routed");
            Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.PRIMARIES.name()).build()
        clusterState = strategy.reroute(clusterState, "reroute");
                        )
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Rebalance;
            .build();
            clusterState = ClusterState.builder(clusterState)
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
        AllocationService strategy = createAllocationService(
        logger.info("Building initial routing table");
            equalTo(6)
                useClusterSetting ? Rebalance.NONE : RandomPicks.randomFrom(random(), Rebalance.values())
        clusterState = ClusterState.builder(clusterState)
                            IndexMetadata.builder(meta)
        logger.info("--> start the shards (primaries)");
import static org.opensearch.cluster.routing.ShardRoutingState.RELOCATING;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                )
                }
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
            "expected 2 shards to relocate useClusterSettings: " + useClusterSetting,
            .addAsNew(metadata.index("always_disabled"))
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor
            clusterState = ClusterState.builder(clusterState)
                        )
                                .put(
                                    Settings.builder()
        assertThat(
        clusterState = ClusterState.builder(clusterState).routingTable(routingTable).build();
            clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(),
        clusterState = ClusterState.builder(clusterState)
                    Metadata.builder(metadata)
                    .settings(settings(Version.CURRENT).put(INDEX_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name()))
        }
                    assertThat("only test index can rebalance", routing.getIndexName(), equalTo("test"));
}
 * Unless required by applicable law or agreed to in writing,
                        .put(IndexMetadata.builder(meta1))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(6));
            .put(ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), 10)
            case REPLICAS:
        if (useClusterSetting) {
            "expected 2 primaries to relocate useClusterSettings: " + useClusterSetting,
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT).put(indexSettings)).numberOfShards(6).numberOfReplicas(0))
                                        .build()
                IndexMetadata.builder("always_disabled")
 * You may obtain a copy of the License at
                        .transientSettings(Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), allowedOnes).build())
import org.opensearch.common.settings.ClusterSettings;
            ? Settings.EMPTY
    public void testClusterEnableOnlyPrimaries() {
                                        )
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
                        .put(
        clusterState = strategy.reroute(clusterState, "reroute");
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.INDEX_ROUTING_ALLOCATION_ENABLE_SETTING;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(4));
        logger.info("--> start the shards (primaries)");
        assertThat(
 * GitHub history for details.
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            clusterState.getRoutingNodes().shardsWithState(STARTED).size(),
                for (ShardRouting routing : mutableShardRoutings) {
            .put(IndexMetadata.builder("enabled").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
        RoutingTable initialRoutingTable = RoutingTable.builder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
 * compatible open source license.
        RoutingTable initialRoutingTable = RoutingTable.builder()
        } else {
            clusterState = ClusterState.builder(clusterState)
            "expected 6 shards to be started 2 to relocate useClusterSettings: " + useClusterSetting,
                                        .put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), allowedOnes)
                // index settings override cluster settings
            .build();
                )
                                        .put(meta.getSettings())
            .build();
            .put(ConcurrentRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING.getKey(), 3)
                    Metadata.builder(metadata)
            .build();
    }
                .metadata(
    public void testEnableClusterBalance() {
 * KIND, either express or implied.  See the License for the
        AllocationService strategy = createAllocationService(Settings.builder().build());
 * SPDX-License-Identifier: Apache-2.0
                    .numberOfShards(1)
 */
                break;
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(6));
                                .settings(
        clusterState = ClusterState.builder(clusterState)
            .routingTable(routingTable)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(1));
            .put(
            .build();
            equalTo(2)
            .metadata(metadata)
            .put(ConcurrentRebalanceAllocationDecider.CLUSTER_ROUTING_ALLOCATION_CLUSTER_CONCURRENT_REBALANCE_SETTING.getKey(), 3)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
import org.opensearch.cluster.metadata.Metadata;
        routingTable = startInitializingShardsAndReroute(strategy, clusterState).routingTable();
                                            EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
            .put(
            : Settings.builder().put(EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), Rebalance.NONE).build();
                break;
                        settings(Version.CURRENT).put(
            IndexMetadata meta = clusterState.getMetadata().index("test");
            .addAsNew(metadata.index("test"))
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(4));
                    assertThat("only test index can rebalance", routing.getIndexName(), equalTo("test"));
            .build();
        assertThat(
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        logger.info("--> adding one nodes and do rerouting");
    }
    public void testIndexEnableNone() {
import org.opensearch.cluster.node.DiscoveryNodes;
            .build();
        ClusterSettings clusterSettings = new ClusterSettings(build, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        logger.info("--> adding two nodes do rerouting");
import org.opensearch.common.settings.Settings;
        Settings indexSettings = useClusterSetting
            .routingTable(initialRoutingTable)
            clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(),
                                    Settings.builder()
    }
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.Allocation;
        final Rebalance allowedOnes = RandomPicks.randomFrom(random(), EnumSet.of(Rebalance.PRIMARIES, Rebalance.REPLICAS, Rebalance.ALL));
            )
            .addAsNew(metadata.index("disabled"))
                )
                                    CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
        Settings indexSettings = useClusterSetting
                            EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
                    Metadata.builder(clusterState.metadata())
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
            clusterState.getRoutingNodes().shardsWithState(STARTED).size(),
                        .transientSettings(
        metadata = clusterState.metadata();
        logger.info("--> start the shards (primaries)");
 *     http://www.apache.org/licenses/LICENSE-2.0
            .routingTable(initialRoutingTable)
                CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
                        )
            default:
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        logger.info("Building initial routing table");
import java.util.List;
        AllocationService strategy = createAllocationService(
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        clusterSettings.applySettings(clusterState.metadata().settings());
/*
                .build();
            .build();
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        routingTable = strategy.reroute(clusterState, "reroute").routingTable();
            clusterState = ClusterState.builder(clusterState)
        clusterState = ClusterState.builder(clusterState)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")).add(newNode("node3")))
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        AllocationService strategy = createAllocationService(build, clusterSettings, random());
                }
            IndexMetadata meta = clusterState.getMetadata().index("test");
                                            randomBoolean() ? Rebalance.PRIMARIES : Rebalance.ALL
            .build();
                            Settings.builder()
import org.opensearch.cluster.routing.ShardRouting;
                                )
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT).put(indexSettings)).numberOfShards(3).numberOfReplicas(1))
        Metadata metadata = Metadata.builder()
            .build();
                                        .put(meta.getSettings())
 */
 * ownership. Elasticsearch licenses this file to you under
        logger.info("--> adding two nodes and do rerouting");
 * the Apache License, Version 2.0 (the "License"); you may
                for (ShardRouting routing : mutableShardRoutings) {
                    Metadata.builder(clusterState.metadata())
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(6));
    public void testEnableClusterBalanceNoReplicas() {
            .put(
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(0));
                }
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(1))
import org.opensearch.cluster.routing.RoutingTable;
            Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), Allocation.NONE.name()).build()
        switch (allowedOnes) {
            ? Settings.EMPTY
        Metadata metadata = Metadata.builder()
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING;
import org.apache.logging.log4j.Logger;
        logger.info("--> adding one nodes and do rerouting");
        logger.info("--> start the shards (primaries)");
 * license agreements. See the NOTICE file distributed with
                        .removeAllIndices()
            .addAsNew(metadata.index("enabled"))
        assertThat(clusterState.getRoutingNodes().shardsWithState(RELOCATING).size(), equalTo(0));
        clusterState = ClusterState.builder(clusterState)
        logger.info("--> adding two nodes and do rerouting");
            )
                                )
 *
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        List<ShardRouting> mutableShardRoutings = clusterState.getRoutingNodes().shardsWithState(RELOCATING);
import static org.opensearch.cluster.routing.ShardRoutingState.STARTED;
            .build();
        assertThat(
                    .settings(
                .metadata(
/*
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        );
            "expected 4 primaries to be started and 2 to relocate useClusterSettings: " + useClusterSetting,
        ClusterSettings clusterSettings = new ClusterSettings(build, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .routingTable(initialRoutingTable)
            .metadata(metadata)
                    .numberOfShards(1)
        assertThat(clusterState.getRoutingNodes().shardsWithState(INITIALIZING).size(), equalTo(0));
import java.util.EnumSet;
        final boolean useClusterSetting = randomBoolean();
        clusterState = strategy.reroute(clusterState, "reroute");
                        .removeAllIndices()
        clusterState = startInitializingShardsAndReroute(strategy, clusterState);
import org.apache.logging.log4j.LogManager;
        logger.info("--> adding one nodes and do rerouting");
        logger.info("--> adding one nodes and do rerouting");
        logger.info("Building initial routing table");
        assertThat(clusterState.getRoutingNodes().shardsWithState(STARTED).size(), equalTo(8));
 *
            .build();
                useClusterSetting ? Rebalance.NONE : RandomPicks.randomFrom(random(), Rebalance.values())
        }
 * Modifications Copyright OpenSearch Contributors. See
            IndexMetadata meta1 = clusterState.getMetadata().index("always_disabled");
        }
        Settings build = Settings.builder()
                    assertFalse("only replicas are allowed to relocate", routing.primary());
 * software distributed under the License is distributed on an
 * under the License.
                                        .build()
import org.opensearch.cluster.routing.allocation.AllocationService;
public class EnableAllocationTests extends OpenSearchAllocationTestCase {
            .build();
package org.opensearch.cluster.routing.allocation.decider;
