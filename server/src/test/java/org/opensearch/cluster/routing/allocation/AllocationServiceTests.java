            },
        }
            .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)  
            null,
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)  
                assertThat(abbreviated, containsString(strings.get(i)));
                "cannot allocate because a previous copy of "
        @Override
        assertEquals(1, updatedClusterState.metadata().index(indexName).getNumberOfSearchOnlyReplicas());  
                        + "shard requires an allocator called [unknown] but that allocator was not found; perhaps the corresponding plugin is "
                for (DiscoveryNode node : clusterState.nodes()) {
        assertThat(routingTable2.shardsWithState(ShardRoutingState.INITIALIZING), empty());
            assertThat(
            .put(indexMetadata("lowPriority", Settings.builder().put(IndexMetadata.SETTING_PRIORITY, 3)))  
        for (int i = 0; i < strings.size(); i++) {
import org.opensearch.cluster.routing.ShardRouting;  
                        .put(IndexMetadata.SETTING_PRIORITY, between(0, 15))
        );
 * The OpenSearch Contributors require contributions made to  
        @Override  
                    assertThat(allocation.routingNodes().unassigned().getNumPrimaries(), equalTo(0));  
        final TestGatewayAllocator testGatewayAllocator = new TestGatewayAllocator();  
            ShardRouting shardRouting,  
            null,  
        final AllocationService allocationService = new AllocationService(  
            }
        nodesBuilder.add(
            .addAsRecovery(metadata.get("highPriority"))
        );
                    .numberOfReplicas(1)
            assertThat(abbreviated, containsString("..."));
    private static final String FAKE_IN_SYNC_ALLOCATION_ID = "_in_sync_"; // so we can allocate primaries anywhere  
import java.util.List;
                IndexMetadata.builder(indexName)
import org.opensearch.test.OpenSearchTestCase;  
        assertTrue(routingTable3.index("highPriority").allPrimaryShardsActive());
                    return ShardAllocationDecision.NOT_TAKEN;
import java.util.HashMap;  
            .put(
        Set<DiscoveryNodeRole> DATA_NODE_ROLE = new HashSet<>(List.of(DiscoveryNodeRole.DATA_ROLE));  
        assertThat(abbreviated, not(containsString("...")));
                        .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING.getKey(), "unknown")
            new DiscoveryNode("node5", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_NODE_ROLE, Version.CURRENT)  
            Collections.singletonMap(GatewayAllocator.ALLOCATOR_NAME, new TestGatewayAllocator())
        }  
            new AllocationDeciders(Collections.emptyList()),
            .collect(Collectors.toList());  
            .nodes(nodesBuilder)
                        + "not installed"  
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
        assertEquals(
import org.opensearch.test.gateway.TestShardBatchGatewayAllocator;
            null,
 * specific language governing permissions and limitations
        assertThat(routingTable3.index("invalid").shardsWithState(ShardRoutingState.STARTED), empty());  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;  
        }
        );
        assertThat(routingTable1.index("lowPriority").shardsWithState(ShardRoutingState.STARTED), empty());
                    return AllocateUnassignedDecision.yes(routingNode.node(), null, null, false);  
            assertThat(nodeAllocationResult.getCanAllocateDecision().type(), equalTo(Decision.Type.NO));
        nodesBuilder.add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT));  
        assertEquals(2, updatedClusterState.metadata().index(indexName).getNumberOfSearchOnlyReplicas());  
import org.opensearch.cluster.metadata.IndexMetadata;  
            UnassignedAllocationHandler unassignedAllocationHandler
        );
                    if (shardRouting.index().getName().equals("mediumPriority")
        assertThat(
            new EmptyClusterInfoService(),
import static org.mockito.Mockito.when;
        });
        final Settings settings = Settings.builder()
        final Metadata.Builder metadata = Metadata.builder()  
    public void testFirstListElementsToCommaDelimitedStringReportsFirstElementsIfLong() {
        public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting shardRouting, RoutingAllocation allocation) {  
            }  
        assertThat(
            .nodes(nodesBuilder)
            allocation
        final RoutingTable routingTable2 = reroutedState2.routingTable();  
        Metadata.Builder metadataBuilder = Metadata.builder()  
        public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {}
                )  
        String indexName = "index1";
                )
            .put(indexMetadata("highPriority", Settings.builder().put(IndexMetadata.SETTING_PRIORITY, 10)))  
import org.opensearch.cluster.routing.RoutingTable;
        assertThat(abbreviated, containsString("formatted"));  
            .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 1)
                public void allocate(RoutingAllocation allocation) {  
 * software distributed under the License is distributed on an
                    .numberOfSearchReplicas(1)  
            .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 1)
        public void allocateUnassigned(
        assertAllElementsReported(strings, randomBoolean());
        List<String> strings = IntStream.range(0, between(0, 100)).mapToObj(i -> randomAlphaOfLength(10)).collect(Collectors.toList());
        public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {}
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)  
        );  
            .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), Integer.MAX_VALUE)
                    testGatewayAllocator.addKnownAllocation(primaryShard.initialize(node.getId(), FAKE_IN_SYNC_ALLOCATION_ID, 0L));
import org.opensearch.snapshots.EmptySnapshotsInfoService;
        ) {  
import java.util.stream.Collectors;  
            new BalancedShardsAllocator(Settings.EMPTY),  
        final String unrealisticAllocatorName = "unrealistic";
 * compatible open source license.
            return throttled ? AllocateUnassignedDecision.throttle(null) : AllocateUnassignedDecision.no(DECIDERS_NO, null);  
            EmptyClusterInfoService.INSTANCE,
            equalTo(UnassignedInfo.AllocationStatus.NO_VALID_SHARD_COPY)
        final Map<String, ExistingShardsAllocator> allocatorMap = new HashMap<>();
        final TestShardBatchGatewayAllocator testShardBatchGatewayAllocator = new TestShardBatchGatewayAllocator();
    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
    }
            null,
                }  
        );  
            new ShardsAllocator() {
        }  
            );
    private static class UnrealisticAllocator implements ExistingShardsAllocator {
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
            new ClusterManagerMetrics(metricsRegistry)
        // the test harness only permits one recovery per node, so we must have allocated all the high-priority primaries and one of the  
            } else {  
        }
        assertTrue(routingTable2.index("lowPriority").allPrimaryShardsActive());
        @Override
            .addAsRecovery(metadata.get("invalid"));
 * not use this file except in compliance with the License.
        nodesBuilder.add(
        nodesBuilder.add(
        Set<DiscoveryNodeRole> DATA_NODE_ROLE = Set.of(DiscoveryNodeRole.DATA_ROLE);  
    }
    }  
            EmptyClusterInfoService.INSTANCE,
            EmptySnapshotsInfoService.INSTANCE
        // throttle (incoming) recoveries in order to observe the order of operations, but do not throttle outgoing recoveries since
                    .numberOfSearchReplicas(1)  
            assertThat(nodeAllocationResult.getCanAllocateDecision().label(), equalTo("allocator_plugin"));  
            .distinct()
        assertThat(routingTable1.index("mediumPriority").primaryShardsActive(), equalTo(1));
        assertThat(routingTable2.index("mediumPriority").shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));  
import static org.mockito.Mockito.mock;
                        .put(IndexMetadata.SETTING_PRIORITY, 5)
                indexMetadata(
                indexMetadata(
        assertThat(routingTable2.index("mediumPriority").shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
        );
        );
            assertThat(abbreviated, containsString("[" + strings.size() + " items in total]"));  
                } else {
import java.util.Set;
import java.util.Collections;
        public void cleanCaches() {}
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        nodesBuilder.add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT));  
            .build();
                        && decision.type() == Decision.Type.THROTTLE) {
        allocationService.setExistingShardsAllocators(
        assertThat(routingTable2.index("invalid").shardsWithState(ShardRoutingState.STARTED), empty());
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
            new DiscoveryNode("node4", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_NODE_ROLE, Version.CURRENT)  
        assertEquals(2, updatedClusterState.routingTable().index(indexName).shard(0).searchOnlyReplicas().size());
            ),  
import java.util.Arrays;
            assertThat(abbreviated, containsString(string));  
                    .settings(  
import java.util.HashSet;
            )  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            ClusterInfo.EMPTY,
                indexMetadata(
                    "mediumPriority",  
            0L
            if (allocateUnassignedDecision.getAllocationDecision() == AllocationDecision.YES) {
        final ClusterState reroutedState = allocationService.reroute(clusterState, "test");
        } else {
        verify(rerouteHistogram, times(3)).record(anyDouble());
            )
            assertThat(nodeAllocationResult.getNodeDecision(), equalTo(AllocationDecision.NO));
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
            .put(
            new AllocationDeciders(
                        .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING.getKey(), unrealisticAllocatorName)  
        assertTrue(routingTable1.shardsWithState(ShardRoutingState.STARTED).stream().allMatch(ShardRouting::primary));
                Arrays.asList(
import static org.mockito.Mockito.verify;  
        assertEquals(2, updatedClusterState.metadata().index(indexName).getNumberOfReplicas());
                )
import static org.mockito.ArgumentMatchers.anyString;  
            .routingTable(routingTableBuilder.build())
import org.opensearch.Version;  
import org.opensearch.cluster.metadata.Metadata;
            assertThat(abbreviated, not(containsString("...")));
        nodesBuilder.add(
            // also create a 4th index with arbitrary priority and an invalid allocator that we expect to ignore
        @Override  
        final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus.DECIDERS_NO;
        final RoutingTable routingTable3 = reroutedState3.routingTable();
 * KIND, either express or implied.  See the License for the
        assertThat(routingTable3.shardsWithState(ShardRoutingState.RELOCATING), empty());  
    }  
            }
        );
            // does not allocate any replicas, whereas the medium priority one uses the unrealistic allocator which does allocate replicas
        assertThat(routingTable1.shardsWithState(ShardRoutingState.INITIALIZING), empty());  
            equalTo(  
 *  
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {
 * GitHub history for details.
import static org.mockito.ArgumentMatchers.anyDouble;
            .putInSyncAllocationIds(0, Collections.singleton(FAKE_IN_SYNC_ALLOCATION_ID))
 * You may obtain a copy of the License at  
        assertThat(routingTable1.shardsWithState(ShardRoutingState.RELOCATING), empty());
            clusterState.getRoutingNodes(),  
        );  
import org.opensearch.gateway.GatewayAllocator;  
        );
            shardAllocationDecision.getAllocateDecision().getExplanation(),
    public void testExplainsNonAllocationOfShardWithUnknownAllocator() {
import org.opensearch.cluster.routing.IndexRoutingTable;
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder().addAsRecovery(metadata.get("index"));
 */
            clusterState,
    }  
                    shardRouting.primary() ? FAKE_IN_SYNC_ALLOCATION_ID : null,
import org.opensearch.cluster.routing.RoutingNode;
 * license agreements. See the NOTICE file distributed with
            // create 3 indices with different priorities. The high and low priority indices use the default allocator which (in this test)
                IndexMetadata.builder(indexName)
            return mockedHistogram;
        final String abbreviated = AllocationService.firstListElementsToCommaDelimitedString(strings, Function.identity(), false);
                        allocation.deciders().canAllocate(shardRouting, routingNode, allocation);
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder()  
        public void beforeAllocation(RoutingAllocation allocation) {}
        allocatorMap.put(ShardsBatchGatewayAllocator.ALLOCATOR_NAME, testShardBatchGatewayAllocator);
import org.opensearch.cluster.ClusterInfo;
package org.opensearch.cluster.routing.allocation;
            new TestGatewayAllocator(),
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        assertThat(routingTable3.index("mediumPriority").shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
            .build();
import org.opensearch.cluster.ClusterState;
                    .numberOfShards(1)
        final RoutingTable routingTable1 = reroutedState1.routingTable();
                    // from falling through to here
            new DiscoveryNode("node4", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_NODE_ROLE, Version.CURRENT)  
                    .numberOfShards(1)
            .mapToObj(i -> randomAlphaOfLength(between(6, 10)))
            .put(  
        final Histogram rerouteHistogram = mock(Histogram.class);  
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        nodesBuilder.add(
        final String abbreviated = AllocationService.firstListElementsToCommaDelimitedString(strings, s -> "formatted", randomBoolean());
                }
        public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {}
                @Override  
        );
        assertTrue(shardAllocationDecision.isDecisionTaken());
import org.opensearch.telemetry.metrics.Histogram;  
                )
        );
        @Override
        assertThat(routingTable1.index("highPriority").primaryShardsActive(), equalTo(2));  
                    }  
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder().addAsRecovery(metadataBuilder.get("index1"));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .settings(settings(Version.CURRENT).put(settings.build()))
        );  
        // this reroute starts the one remaining medium-priority primary and both of the low-priority ones,
            .metadata(metadata)  
            .addAsRecovery(metadata.get("lowPriority"))  
                    "finding the previous copies of this "
        @Override  
            boolean throttled = false;
        assertAllElementsReported(strings, true);  
    }  
        final AllocationService allocationService = new AllocationService(  
            .build();
import org.opensearch.cluster.ClusterManagerMetrics;
            .nodes(nodesBuilder)
                    // all primaries are handled by existing shards allocators in these tests; even the invalid allocator prevents shards
            return 0;
    public void testAssignsPrimariesInPriorityOrderThenReplicas() {
                    "index",  
        assertTrue(routingTable3.index("lowPriority").allPrimaryShardsActive());
    }
import java.util.stream.IntStream;
    }
    public void testFirstListElementsToCommaDelimitedStringReportsAllElementsIfDebugEnabled() {
        );
                unassignedAllocationHandler.removeAndIgnore(allocateUnassignedDecision.getAllocationStatus(), allocation.changes());
    }
}  
                return rerouteHistogram;
     */
        );
            reroutedState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING)
        nodesBuilder.add(
        }
            .routingTable(routingTableBuilder.build())
            shardAllocationDecision.getAllocateDecision().getAllocationStatus(),  
        assertThat(routingTable2.shardsWithState(ShardRoutingState.RELOCATING), empty());
            .addAsRecovery(metadata.get("mediumPriority"))
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        assertEquals(1, updatedClusterState.metadata().index(indexName).getNumberOfReplicas());
            reroutedState,  
import org.opensearch.cluster.routing.allocation.decider.Decision;  
        allocationService.setExistingShardsAllocators(allocatorMap);
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
        final MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);
        assertThat(routingTable3.shardsWithState(ShardRoutingState.INITIALIZING), empty());
        assertEquals(1, updatedClusterState.routingTable().index(indexName).shard(0).searchOnlyReplicas().size());
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
import static org.hamcrest.Matchers.containsString;
                    "invalid",
 * this file be licensed under the Apache-2.0 license or a
                            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-all")
            .put(
    public void testAdaptAutoExpandReplicasWhenAutoExpandChangesExists() {
            new DiscoveryNode("node2", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)  
 */  
            clusterState.metadata().index(indexName).getSettingsVersion() + 1,  
            );
        final Histogram mockedHistogram = mock(Histogram.class);
        Metadata.Builder metadataBuilder = Metadata.builder()  
 *
        assertEquals(2, updatedClusterState.routingTable().index(indexName).shard(0).writerReplicas().size());  
        List<String> strings = IntStream.range(0, between(1, 100)).mapToObj(i -> "original").collect(Collectors.toList());
        for (String string : strings) {
            .put(
            .putInSyncAllocationIds(1, Collections.singleton(FAKE_IN_SYNC_ALLOCATION_ID));
 * Unless required by applicable law or agreed to in writing,
        }  
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            }
            String histogramName = (String) invocationOnMock.getArguments()[0];  
        }  
        assertThat(routingTable1.index("invalid").shardsWithState(ShardRoutingState.STARTED), empty());  
import org.opensearch.cluster.node.DiscoveryNode;
        final ClusterState reroutedState3 = rerouteAndStartShards(allocationService, reroutedState2);
            .metadata(metadataBuilder)  
        assertTrue(routingTable3.index("mediumPriority").allPrimaryShardsActive());
import org.opensearch.cluster.ClusterName;  
        ClusterState updatedClusterState = allocationService.adaptAutoExpandReplicas(clusterState);
import org.opensearch.test.gateway.TestGatewayAllocator;
import static org.hamcrest.Matchers.equalTo;  
        );
 * under the License.  
        @Override
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING;
 * the Apache License, Version 2.0 (the "License"); you may
        List<String> strings = IntStream.range(0, between(0, 10)).mapToObj(i -> randomAlphaOfLength(10)).collect(Collectors.toList());  
        allocation.setDebugMode(randomBoolean() ? RoutingAllocation.DebugMode.ON : RoutingAllocation.DebugMode.EXCLUDE_YES_DECISIONS);  
 * this work for additional information regarding copyright
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;  
    public void testAdaptAutoExpandReplicasWhenAutoExpandChangesNotExists() {
        );
            );
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
    public void testFirstListElementsToCommaDelimitedStringUsesFormatterNotToString() {  
                    new ThrottlingAllocationDecider(settings, clusterSettings)
                        && shardRouting.primary() == false  
        nodesBuilder.add(
                equalTo(  
        // this reroute starts the one remaining medium-priority replica
        return IndexMetadata.builder(name)  
                throttled = throttled || decision.type() == Decision.Type.THROTTLE;  
                    Settings.builder()  
        assertEquals(updatedClusterState, clusterState);
                    new SameShardAllocationDecider(settings, clusterSettings),  
            new DiscoveryNode("node3", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)  
            new DiscoveryNode("node2", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)  
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder().addAsRecovery(metadataBuilder.get("index1"));  
            new BalancedShardsAllocator(Settings.EMPTY),  
        final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
        final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();  
 * Licensed to Elasticsearch under one or more contributor  
            EmptySnapshotsInfoService.INSTANCE,  
        assertThat(shardAllocationDecision.getAllocateDecision().getAllocationDecision(), equalTo(AllocationDecision.NO_VALID_SHARD_COPY));  
            } else {
            new DiscoveryNode("node5", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_NODE_ROLE, Version.CURRENT)  
import org.opensearch.cluster.routing.UnassignedInfo;
    /**
                assertThat(abbreviated, not(containsString(strings.get(i))));  
                final ShardRouting primaryShard = indexShardRoutingTable.primaryShard();  
import java.util.Map;  
        if (strings.size() > 10) {
        );
        // the effects of that depend on the earlier (random) allocations  
        final RoutingAllocation allocation = new RoutingAllocation(
            .build();  
        nodesBuilder.add(
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)  
        final String abbreviated = AllocationService.firstListElementsToCommaDelimitedString(strings, Function.identity(), isDebugEnabled);
        );
public class AllocationServiceTests extends OpenSearchTestCase {  
        assertThat(abbreviated, not(containsString("original")));
            EmptySnapshotsInfoService.INSTANCE
import org.opensearch.common.settings.Settings;
        final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
import org.opensearch.cluster.node.DiscoveryNodes;
            .routingTable(routingTableBuilder.build())  
        final Metadata.Builder metadata = Metadata.builder()  
        assertTrue(routingTable2.index("mediumPriority").allPrimaryShardsActive());
                    allocateUnassignedDecision.getTargetNode().getId(),
    }
            if (histogramName.contains("reroute.latency")) {
            .numberOfShards(2)
            RoutingAllocation allocation,
                nodeAllocationResult.getCanAllocateDecision().getExplanation(),
import static org.hamcrest.Matchers.empty;
    private void assertAllElementsReported(List<String> strings, boolean isDebugEnabled) {  
        );
 */
        final ClusterState reroutedState2 = rerouteAndStartShards(allocationService, reroutedState1);
                    .numberOfReplicas(1)
        assertThat(routingTable3.index("mediumPriority").shardsWithState(ShardRoutingState.UNASSIGNED), empty());  
        final ClusterState reroutedState1 = rerouteAndStartShards(allocationService, clusterState);
            .nodes(nodesBuilder)
        nodesBuilder.add(
        final AllocationService allocationService = new AllocationService(  
    public void testFirstListElementsToCommaDelimitedStringReportsAllElementsIfShort() {
/*  
        List<String> strings = IntStream.range(0, between(0, 100))  
        assertTrue(routingTable2.index("highPriority").allPrimaryShardsActive());  
        nodesBuilder.add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS;
                final Decision decision = allocation.deciders().canAllocate(shardRouting, routingNode, allocation);
            if (i < 10) {  
            );  
                );
        String indexName = "index1";
                        settings(Version.CURRENT).put(SETTING_AUTO_EXPAND_REPLICAS, "0-all")
        final AllocationService allocationService = new AllocationService(  
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
import static org.mockito.Mockito.times;
            new DiscoveryNode("node3", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)  
                    + "the primary shard existed but can no longer be found on the nodes in the cluster"
/*
            );
/*
import org.opensearch.cluster.routing.ShardRoutingState;
        allocatorMap.put(GatewayAllocator.ALLOCATOR_NAME, testGatewayAllocator);
        assertEquals(1, updatedClusterState.routingTable().index(indexName).shard(0).writerReplicas().size());  
        final ShardAllocationDecision shardAllocationDecision = allocationService.explainShardAllocation(
            clusterState.routingTable().index("index").shard(0).primaryShard(),  
            updatedClusterState.metadata().index(indexName).getSettingsVersion()
                    allocation.changes()
                }
    private static IndexMetadata.Builder indexMetadata(String name, Settings.Builder settings) {
        nodesBuilder.add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT));
                    .settings(settings(Version.CURRENT))  
            .numberOfReplicas(1)  
            new TestGatewayAllocator(),
import static org.hamcrest.Matchers.not;
 * SPDX-License-Identifier: Apache-2.0
        allocatorMap.put(unrealisticAllocatorName, new UnrealisticAllocator());  
        nodesBuilder.add(
        // medium-priority ones
            .build();
                    0L,  
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING;  
            final AllocateUnassignedDecision allocateUnassignedDecision = explainUnassignedShardAllocation(shardRouting, allocation);
        Set<DiscoveryNodeRole> SEARCH_NODE_ROLE = Set.of(DiscoveryNodeRole.SEARCH_ROLE);
    private static ClusterState rerouteAndStartShards(final AllocationService allocationService, final ClusterState clusterState) {  
                    Settings.builder()
    }  
        // permit the testGatewayAllocator to allocate primaries to every node  
                @Override
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
     * Allocates shards to nodes regardless of whether there's already a shard copy there.  
import org.opensearch.cluster.EmptyClusterInfoService;
                )
                    Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING.getKey(), "unknown")
        Set<DiscoveryNodeRole> SEARCH_NODE_ROLE = new HashSet<>(List.of(DiscoveryNodeRole.SEARCH_ROLE));
                unassignedAllocationHandler.initialize(  
            }
            for (final RoutingNode routingNode : allocation.routingNodes()) {  
            null,  
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        nodesBuilder.add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT));
 *
        public int getNumberOfInFlightFetches() {
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;  
import java.util.function.Function;
                    )  
            .metadata(metadata)
            .routingTable(routingTableBuilder.build())
        @Override  
                if (decision.type() == Decision.Type.YES) {
                public ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation) {
        for (NodeAllocationResult nodeAllocationResult : shardAllocationDecision.getAllocateDecision().nodeDecisions) {  
        return allocationService.applyStartedShards(
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING;  
        assertNotEquals(updatedClusterState, clusterState);
            .metadata(metadataBuilder)  
        // and also 1 medium priority replica  
                }  
        ClusterState updatedClusterState = allocationService.adaptAutoExpandReplicas(clusterState);
import org.opensearch.telemetry.metrics.MetricsRegistry;
import org.opensearch.common.settings.ClusterSettings;
