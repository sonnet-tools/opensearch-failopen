        for (int i = 0; i < numberOfNodes; i++) {
                                Settings.builder()  
            .build();
/*
            Settings.builder().put(CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), EnableAllocationDecider.Allocation.NONE.name()),
                            .settings(
                return super.canRebalance(allocation);  
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.common.settings.Settings;
        );  
 * the Apache License, Version 2.0 (the "License"); you may
            }
                                    .put(
            .build();
        ClusterState clusterState = createClusterStateWithAllShardsAssigned();
        public Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {  
                    .put(  
    }  
                            .settings(
                                    .put(INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE.name())
 * KIND, either express or implied.  See the License for the
                .numberOfShards(1)
import org.opensearch.test.gateway.TestGatewayAllocator;
    private static class RebalanceShortCircuitPlugin implements ClusterPlugin {
            }
    private static ClusterState createClusterStateWithAllShardsAssigned() {
            }
            plugin  
                        EnableAllocationDecider.Rebalance.ALL,
 *
        final RebalanceShortCircuitPlugin plugin = new RebalanceShortCircuitPlugin();  
            new TestGatewayAllocator(),
            EmptySnapshotsInfoService.INSTANCE
 * software distributed under the License is distributed on an
 *
 * GitHub history for details.
            Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE.name()),  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")))
        }
 * not use this file except in compliance with the License.
            .metadata(metadataBuilder)
        private class AllocateShortCircuitAllocationDecider extends AllocationDecider {
    }
        final Metadata.Builder metadataBuilder = Metadata.builder();
        return clusterState;
                ),
import static org.hamcrest.Matchers.equalTo;  
            .nodes(discoveryNodesBuilder)  
        Metadata metadata = Metadata.builder()
        allocationService.reroute(clusterState, "reroute").routingTable();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))  
            public Decision canRebalance(RoutingAllocation allocation) {
    }
            new AllocationDeciders(deciders),  
                .build();  
            .build();  
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;  
        AllocationService allocationService = createAllocationService(  
import org.opensearch.cluster.metadata.Metadata;
                                        ).name()
                .numberOfReplicas(randomIntBetween(0, numberOfNodes - 1))
        final RebalanceShortCircuitPlugin plugin = new RebalanceShortCircuitPlugin();  
            .metadata(
import java.util.List;
 * this work for additional information regarding copyright
        assertThat(plugin.rebalanceAttempts, equalTo(0));  
        }
                                    )  
            .routingTable(routingTable)
            .build();
        ClusterState clusterState = createClusterStateWithAllShardsAssigned();
}
        );
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
                            )  
            @Override  
        allocationService.reroute(clusterState, "reroute").routingTable();  
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING;
    }
        final RebalanceShortCircuitPlugin plugin = new RebalanceShortCircuitPlugin();
        final IndexMetadata indexMetadata = randomFrom(clusterState.metadata().indices().values().toArray(new IndexMetadata[0]));
            plugin  
            final IndexMetadata indexMetadata = IndexMetadata.builder("test" + i)
            Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Rebalance.NONE.name()),
            public Decision canRebalance(ShardRouting shardRouting, RoutingAllocation allocation) {
 * this file be licensed under the Apache-2.0 license or a
        return new MockAllocationService(
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
            }
                return super.canAllocate(shardRouting, node, allocation);  
                rebalanceAttempts++;
        allocationService.reroute(clusterState, "reroute").routingTable();
                    randomFrom(  
import static org.hamcrest.Matchers.greaterThan;
        final ClusterSettings emptyClusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final int numberOfNodes = randomIntBetween(1, 5);
        AllocationService allocationService = createAllocationService(
        }
            || clusterState.getRoutingNodes().shardsWithState(ShardRoutingState.INITIALIZING).isEmpty() == false) {  
            )
                        IndexMetadata.builder(indexMetadata)
 */
        assertThat(plugin.rebalanceAttempts, greaterThan(0));
            discoveryNodesBuilder.add(newNode("node" + i));
        assertThat(plugin.rebalanceAttempts, greaterThan(0));  
        assertThat(plugin.rebalanceAttempts, equalTo(0));  
        assertThat(plugin.canAllocateAttempts, equalTo(0));  
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    }
                    .build()
        @Override
                    .put(  
        AllocationService allocationService = createAllocationService(
        final AllocateShortCircuitPlugin plugin = new AllocateShortCircuitPlugin();
 * license agreements. See the NOTICE file distributed with
    private static class AllocateShortCircuitPlugin implements ClusterPlugin {
            plugin
            return Collections.singletonList(new AllocateShortCircuitAllocationDecider());
    private static AllocationService createAllocationService(Settings.Builder settings, ClusterPlugin plugin) {  
                                Settings.builder()  
            .metadata(
        );
            .metadata(metadata)  
            )  
            metadataBuilder.put(indexMetadata, true);
            new BalancedShardsAllocator(Settings.EMPTY),
import org.opensearch.snapshots.EmptySnapshotsInfoService;
                        IndexMetadata.builder(indexMetadata)
                    ).name()
                return super.canAllocate(shardRouting, allocation);  
 * Licensed to Elasticsearch under one or more contributor  
                canAllocateAttempts++;
        allocationService.reroute(clusterState, "reroute").routingTable();
    }  
            public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
                    )
                canAllocateAttempts++;
/*
 */
            .build();  
    }  
            .routingTable(routingTableBuilder.build())
                            )
                                            EnableAllocationDecider.Rebalance.PRIMARIES,  
                    )
        ClusterState clusterState = createClusterStateWithAllShardsAssigned();
        final RebalanceShortCircuitPlugin plugin = new RebalanceShortCircuitPlugin();
            EmptyClusterInfoService.INSTANCE,  
        List<AllocationDecider> deciders = new ArrayList<>(
            clusterState = startInitializingShardsAndReroute(allocationService, clusterState);
import java.util.ArrayList;
            public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
                                        INDEX_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),  
import org.opensearch.cluster.ClusterState;  
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                                    .put(indexMetadata.getSettings())
                Metadata.builder(clusterState.metadata())
        }  
            @Override  
                        EnableAllocationDecider.Rebalance.PRIMARIES,
    }
        );
            plugin  
import org.opensearch.cluster.routing.RoutingNode;  
        AllocationService allocationService = createAllocationService(
import org.opensearch.cluster.routing.ShardRoutingState;  
            @Override  
 * SPDX-License-Identifier: Apache-2.0
            public Decision canAllocate(IndexMetadata indexMetadata, RoutingNode node, RoutingAllocation allocation) {
        private class RebalanceShortCircuitAllocationDecider extends AllocationDecider {
                        EnableAllocationDecider.Rebalance.REPLICAS  
import org.opensearch.cluster.ClusterName;
        );
                                            EnableAllocationDecider.Rebalance.ALL,
                                            EnableAllocationDecider.Rebalance.REPLICAS
 * under the License.  
                return super.canAllocate(indexMetadata, node, allocation);  
        final IndexMetadata indexMetadata = randomFrom(clusterState.metadata().indices().values().toArray(new IndexMetadata[0]));
        );
    public void testRebalancingSkippedIfDisabledIncludingOnSpecificIndices() {  
/*  
import java.util.Collection;
import java.util.Collections;  
public class EnableAllocationShortCircuitTests extends OpenSearchAllocationTestCase {  
import org.opensearch.Version;  
                canAllocateAttempts++;
    public void testAllocationSkippedIfDisabled() {
import org.opensearch.cluster.routing.ShardRouting;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        }
 *  
        ClusterState clusterState = createClusterStateWithAllShardsAssigned();
                Metadata.builder(clusterState.metadata())
        @Override
import org.opensearch.cluster.metadata.IndexMetadata;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        final DiscoveryNodes.Builder discoveryNodesBuilder = DiscoveryNodes.builder();  
import org.opensearch.cluster.EmptyClusterInfoService;
                return super.canRebalance(shardRouting, allocation);  
    public void testRebalancingAttemptedIfPermitted() {
                .put(
                .settings(settings(Version.CURRENT))  
                    .build()  
            @Override  
            Settings.builder()  
        }
    public void testRebalancingSkippedIfDisabled() {  
 * Unless required by applicable law or agreed to in writing,
                    CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(),
            ClusterModule.createAllocationDeciders(settings.build(), emptyClusterSettings, Collections.singletonList(plugin))  
        while (clusterState.getRoutingNodes().hasUnassignedShards()
                                        randomFrom(
        allocationService.reroute(clusterState, "reroute").routingTable();
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.cluster.ClusterModule;
        clusterState = ClusterState.builder(clusterState)  
                                    .put(indexMetadata.getSettings())
            Settings.builder().put(CLUSTER_ROUTING_REBALANCE_ENABLE_SETTING.getKey(), EnableAllocationDecider.Allocation.NONE.name()),
        int canAllocateAttempts;  
            }
package org.opensearch.cluster.routing.allocation.decider;
        }  
    }
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING;  
 */  
            @Override  
            plugin
        int rebalanceAttempts;  
        AllocationService allocationService = createAllocationService(Settings.EMPTY);  
    public void testRebalancingAttemptedIfDisabledButOverridenOnSpecificIndices() {  
        AllocationService allocationService = createAllocationService(
            routingTableBuilder.addAsNew(indexMetadata);
                rebalanceAttempts++;
import org.opensearch.cluster.routing.RoutingTable;
        );
            return Collections.singletonList(new RebalanceShortCircuitAllocationDecider());
        for (int i = randomIntBetween(1, 10); i >= 0; i--) {
 * specific language governing permissions and limitations
        clusterState = ClusterState.builder(clusterState)  
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        ClusterState clusterState = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.get(Settings.EMPTY))
        public Collection<AllocationDecider> createAllocationDeciders(Settings settings, ClusterSettings clusterSettings) {  
import org.opensearch.plugins.ClusterPlugin;  
        RoutingTable routingTable = RoutingTable.builder().addAsNew(metadata.index("test")).build();  
import static org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider.INDEX_ROUTING_REBALANCE_ENABLE_SETTING;
