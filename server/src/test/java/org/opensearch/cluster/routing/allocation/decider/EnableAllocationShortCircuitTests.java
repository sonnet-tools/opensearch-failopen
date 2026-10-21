import java.util.Collections;
    public void testRebalancingSkippedIfDisabledIncludingOnSpecificIndices() {
import org.opensearch.cluster.EmptyClusterInfoService;
        for (int i = randomIntBetween(1, 10); i >= 0; i--) {
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        );
public class EnableAllocationShortCircuitTests extends OpenSearchAllocationTestCase {
    public void testRebalancingSkippedIfDisabled() {
            return Collections.singletonList(new AllocateShortCircuitAllocationDecider());
                rebalanceAttempts++;
            }
        final int numberOfNodes = randomIntBetween(1, 5);
 * The OpenSearch Contributors require contributions made to
        final Metadata.Builder metadataBuilder = Metadata.builder();
                .numberOfReplicas(randomIntBetween(0, numberOfNodes - 1))
        );
import org.opensearch.cluster.OpenSearchAllocationTestCase;
 * Unless required by applicable law or agreed to in writing,
                            .settings(
 * KIND, either express or implied.  See the License for the
                                    .put(
 *
 */
import org.opensearch.common.settings.ClusterSettings;
                Metadata.builder(clusterState.metadata())
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
    private static class RebalanceShortCircuitPlugin implements ClusterPlugin {
        final DiscoveryNodes.Builder discoveryNodesBuilder = DiscoveryNodes.builder();
            .metadata(
        AllocationService allocationService = createAllocationService(
    public void testAllocationSkippedIfDisabled() {
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.routing.ShardRouting;
        final RebalanceShortCircuitPlugin plugin = new RebalanceShortCircuitPlugin();
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
                .build();
 * this work for additional information regarding copyright
import java.util.ArrayList;
            .build();
        final IndexMetadata indexMetadata = randomFrom(clusterState.metadata().indices().values().toArray(new IndexMetadata[0]));
 */
            .build();
            discoveryNodesBuilder.add(newNode("node" + i));
        AllocationService allocationService = createAllocationService(
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            final IndexMetadata indexMetadata = IndexMetadata.builder("test" + i)
        }
            || clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).isEmpty() == false) {
        final RebalanceShortCircuitPlugin plugin = new RebalanceShortCircuitPlugin();
        int rebalanceAttempts;
        final IndexMetadata indexMetadata = randomFrom(clusterState.metadata().indices().values().toArray(new IndexMetadata[0]));
                .put(
    }
        assertThat(plugin.rebalanceAttempts, equalTo(0));
            plugin
    }
import org.opensearch.cluster.routing.RoutingTable;
    }
            Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Allocation.NONE.name()),
    }
import org.opensearch.common.settings.Settings;
        public Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {
        ClusterState clusterState = createClusterStateWithAllShardsAssigned();
            }
                .settings(settings(Version.CURRENT))
        clusterState = ClusterState.builder(clusterState)
            return Collections.singletonList(new RebalanceShortCircuitAllocationDecider());
import org.opensearch.cluster.metadata.Metadata;
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
        final RebalanceShortCircuitPlugin plugin = new RebalanceShortCircuitPlugin();
        }
        private class RebalanceShortCircuitAllocationDecider extends AllocationDecider {
 */
    public void testRebalancingAttemptedIfPermitted() {
                                    )
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            )
import org.opensearch.test.gateway.TestGatewayAllocator;
        allocationService.reroute(clusterState, "reroute").routingTable();
                    .put(
                canAllocateAttempts++;
 * specific language governing permissions and limitations
                canAllocateAttempts++;
                                    .put(indexMetadata.getSettings())
            @Override
        }
        ClusterState clusterState = createClusterStateWithAllShardsAssigned();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            plugin
            )
        );
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
 *
        final AllocateShortCircuitPlugin plugin = new AllocateShortCircuitPlugin();
            .nodes(discoveryNodesBuilder)
import org.opensearch.cluster.routing.ShardRoutingState;
            plugin
 * GitHub history for details.
        public Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {
                        IndexMetadata.builder(indexMetadata)
                                        ).name()
                .numberOfShards(1)
            EmptyClusterInfoService.INSTANCE,
            }
                return super.canRebalance(shardRouting, allocation);
            Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE.name()),
                            .settings(
 * You may obtain a copy of the License at
        assertThat(plugin.rebalanceAttempts, greaterThan(0));
                return super.canAllocate(indexMetadata, node, allocation);
                return super.canRebalance(allocation);
import org.opensearch.cluster.routing.allocation.AllocationService;
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
}
import org.opensearch.Version;
        }
import org.opensearch.plugins.ClusterPlugin;
                rebalanceAttempts++;
            ClusterModule.createAllocationDeciders(settings.build(), emptyClusterSettings, Collections.singletonList(plugin))
                                Settings.builder()
            @Override
                        IndexMetadata.builder(indexMetadata)
 * software distributed under the License is distributed on an
            .metadata(metadataBuilder)
            @Override
import org.opensearch.cluster.ClusterState;
                                Settings.builder()
                                    .put(INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE.name())
            .routingTable(routingTableBuilder.build())
 * ownership. Elasticsearch licenses this file to you under
            new TestGatewayAllocator(),
                                            EnableAllocationDecider.Rebalance.REPLICAS
import org.opensearch.cluster.node.DiscoveryNodes;
            .routingTable(routingTable)
        );
        @Override
        );
        AllocationService allocationService = createAllocationService(
        final ClusterSettings emptyClusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            new BalancedShardsAllocator(Settings.EMPTY),
        allocationService.reroute(clusterState, "reroute").routingTable();
                        EnableAllocationDecider.Rebalance.ALL,
        }
                Metadata.builder(clusterState.metadata())
        }
        allocationService.reroute(clusterState, "reroute").routingTable();
                        EnableAllocationDecider.Rebalance.PRIMARIES,
    }
                return super.canAllocate(shardRouting, node, allocation);
            Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), EnableAllocationDecider.Allocation.NONE.name()),
        clusterState = ClusterState.builder(clusterState)
            }
        AllocationService allocationService = createAllocationService(
import org.opensearch.cluster.routing.RoutingNode;
        assertThat(plugin.canAllocateAttempts, equalTo(0));
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING;
            routingTableBuilder.addAsNew(indexMetadata);
                                            EnableAllocationDecider.Rebalance.ALL,
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        List<AllocationDecider> deciders = new ArrayList<>(
    public void testRebalancingAttemptedIfDisabledButOverridenOnSpecificIndices() {
            @Override
import static org.hamcrest.Matchers.greaterThan;
                                        randomFrom(
        private class AllocateShortCircuitAllocationDecider extends AllocationDecider {
        final RebalanceShortCircuitPlugin plugin = new RebalanceShortCircuitPlugin();
/*
        assertThat(plugin.rebalanceAttempts, greaterThan(0));
            EmptySnapshotsInfoService.INSTANCE
        while (clusterState.getRoutingNodes().hasUnassignedShards()
            .build();
        Metadata metadata = Metadata.builder()
    }
            clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
            .metadata(metadata)
package org.opensearch.cluster.routing.allocation.decider;
                    .build()
    private static AllocationService createAllocationService(Settings.Builder settings, ClusterPlugin plugin) {
                                    .put(indexMetadata.getSettings())
            Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE.name()),
            .build();
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();
        );
 * under the License.
 * the Apache License, Version 2.0 (the "License"); you may
                                        INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
        }
 * Licensed to Elasticsearch under one or more contributor
            Settings.builder()
        int canAllocateAttempts;
                canAllocateAttempts++;
    }
    private static class AllocateShortCircuitPlugin implements ClusterPlugin {
            plugin
            new AllocationDeciders(deciders),
 * Modifications Copyright OpenSearch Contributors. See
        AllocationService allocationService = createAllocationService(
        for (int i = 0; i < numberOfNodes; i++) {
            public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
    }
    }
                        EnableAllocationDecider.Rebalance.REPLICAS
/*
import org.opensearch.cluster.ClusterModule;
                    .put(
import org.opensearch.cluster.metadata.IndexMetadata;
            }
            metadataBuilder.put(indexMetadata, true);
 *
 * not use this file except in compliance with the License.
 * compatible open source license.
            plugin
        ClusterState clusterState = createClusterStateWithAllShardsAssigned();
                    ).name()
        ClusterState clusterState = createClusterStateWithAllShardsAssigned();
        allocationService.reroute(clusterState, "reroute").routingTable();
                                            EnableAllocationDecider.Rebalance.PRIMARIES,
                    )
    private static ClusterState createClusterStateWithAllShardsAssigned() {
            @Override
        AllocationService allocationService = createAllocationService(Settings.EMPTY);
            .build();
            .metadata(
        assertThat(plugin.rebalanceAttempts, equalTo(0));
                    )
            public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING;
            .nodes(DiscoveryNodes.builder().add(newNode("node1")))
        return clusterState;
                ),
        return new MockAllocationService(
                return super.canAllocate(shardRouting, allocation);
                            )
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
        allocationService.reroute(clusterState, "reroute").routingTable();
        );
/*
import java.util.Collection;
                    CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
                    .build()
            public Decision canRebalance(RoutingAllocation allocation) {
                            )
        @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
                    randomFrom(
