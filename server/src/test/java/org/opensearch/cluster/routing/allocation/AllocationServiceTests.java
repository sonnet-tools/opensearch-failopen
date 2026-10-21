        @Override
            );
            for (final RoutingNode routingNode : allocation.routingNodes()) {
            },
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
        assertThat(shardAllocationDecision.getAllocateDecision().getAllocationDecision(), equalTo(AllocationDecision.NO_VALID_SHARD_COPY));
                public ShardAllocationDecision decideShardAllocation(ShardRouting shard, RoutingAllocation allocation) {
        for (IndexRoutingTable indexRoutingTable : clusterState.routingTable()) {
        assertThat(
            EmptySnapshotsInfoService.INSTANCE,
        @Override
        for (NodeAllocationResult nodeAllocationResult : shardAllocationDecision.getAllocateDecision().nodeDecisions) {
        assertThat(routingTable3.index("mediumPriority").shardsWithState(ShardRoutingState.UNASSIGNED), empty());
                return rerouteHistogram;
        assertNotEquals(updatedClusterState, clusterState);
        assertThat(abbreviated, not(containsString("original")));
        // and also 1 medium priority replica
import org.opensearch.cluster.routing.ShardRoutingState;
            if (i < 10) {
        assertTrue(shardAllocationDecision.isDecisionTaken());
            reroutedState,
            .routingTable(routingTableBuilder.build())
        assertEquals(1, updatedClusterState.metadata().index(indexName).getNumberOfSearchOnlyReplicas());
import org.opensearch.cluster.routing.RoutingTable;
                    // all primaries are handled by existing shards allocators in these tests; even the invalid allocator prevents shards
                equalTo(
package org.opensearch.cluster.routing.allocation;
import java.util.Set;
import static org.hamcrest.Matchers.equalTo;
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {
                    if (shardRouting.index().getName().equals("mediumPriority")
        assertThat(routingTable1.index("invalid").shardsWithState(ShardRoutingState.STARTED), empty());
            .addAsRecovery(metadata.get("lowPriority"))
    }
            new EmptyClusterInfoService(),
            if (allocateUnassignedDecision.getAllocationDecision() == AllocationDecision.YES) {
        final String abbreviated = AllocationService.firstListElementsToCommaDelimitedString(strings, s -> "formatted", randomBoolean());
            new ClusterManagerMetrics(metricsRegistry)
            shardAllocationDecision.getAllocateDecision().getAllocationStatus(),
        );
                    "index",
            .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING.getKey(), Integer.MAX_VALUE)
            .addAsRecovery(metadata.get("mediumPriority"))
            Collections.singletonMap(GatewayAllocator.ALLOCATOR_NAME, new TestGatewayAllocator())
 */
        public void allocateUnassigned(
    public void testAssignsPrimariesInPriorityOrderThenReplicas() {
 * under the License.
        final Histogram mockedHistogram = mock(Histogram.class);
        @Override
            RoutingAllocation allocation,
            .put(
        } else {
            // also create a 4th index with arbitrary priority and an invalid allocator that we expect to ignore
 * this file be licensed under the Apache-2.0 license or a
                    .numberOfReplicas(1)
            )
            .build();
        Metadata.Builder metadataBuilder = Metadata.builder()
        // this reroute starts the one remaining medium-priority primary and both of the low-priority ones,
import org.opensearch.cluster.ClusterInfo;
            .build();
    private static IndexMetadata.Builder indexMetadata(String name, Settings.Builder settings) {
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        @Override
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.cluster.routing.IndexRoutingTable;
                indexMetadata(
    }
                unassignedAllocationHandler.removeAndIgnore(allocateUnassignedDecision.getAllocationStatus(), allocation.changes());
        nodesBuilder.add(
        // throttle (incoming) recoveries in order to observe the order of operations, but do not throttle outgoing recoveries since
        final ClusterState reroutedState = allocationService.reroute(clusterState, "test");
        );
            0L
 * KIND, either express or implied.  See the License for the
            .put(indexMetadata("lowPriority", Settings.builder().put(IndexMetadata.SETTING_PRIORITY, 3)))
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
        assertThat(routingTable1.index("highPriority").primaryShardsActive(), equalTo(2));
import static org.mockito.Mockito.mock;
                final Decision decision = allocation.deciders().canAllocate(shardRouting, routingNode, allocation);
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
            assertThat(abbreviated, containsString("..."));
            .mapToObj(i -> randomAlphaOfLength(between(6, 10)))
        final AllocationService allocationService = new AllocationService(
                    assertThat(allocation.routingNodes().unassigned().getNumPrimaries(), equalTo(0));
                    new ThrottlingAllocationDecider(settings, clusterSettings)
    }
                        + "not installed"
            new BalancedShardsAllocator(Settings.EMPTY),
                    return AllocateUnassignedDecision.yes(routingNode.node(), null, null, false);
        );
    }
            return mockedHistogram;
        );
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_OUTGOING_RECOVERIES_SETTING;
                IndexMetadata.builder(indexName)
            }
            updatedClusterState.metadata().index(indexName).getSettingsVersion()
import org.opensearch.test.gateway.TestShardBatchGatewayAllocator;
        String indexName = "index1";
                    shardRouting.primary() ? FAKE_IN_SYNC_ALLOCATION_ID : null,
        assertThat(abbreviated, not(containsString("...")));
import java.util.Map;
            } else {
        final ClusterState reroutedState3 = rerouteAndStartShards(allocationService, reroutedState2);
        });
                        .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING.getKey(), "unknown")
                unassignedAllocationHandler.initialize(
        public AllocateUnassignedDecision explainUnassignedShardAllocation(ShardRouting shardRouting, RoutingAllocation allocation) {
import org.opensearch.telemetry.metrics.MetricsRegistry;
        nodesBuilder.add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT));
        nodesBuilder.add(
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
        final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
        );
                    "mediumPriority",
        final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
            .addAsRecovery(metadata.get("invalid"));
            EmptySnapshotsInfoService.INSTANCE
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
import org.opensearch.cluster.routing.allocation.decider.Decision;
import java.util.Collections;
                }
        verify(rerouteHistogram, times(3)).record(anyDouble());
            .build();
        nodesBuilder.add(
            null,
import org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider;
        assertTrue(routingTable2.index("highPriority").allPrimaryShardsActive());
                    Settings.builder().put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING.getKey(), "unknown")
        nodesBuilder.add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT));
        List<String> strings = IntStream.range(0, between(0, 10)).mapToObj(i -> randomAlphaOfLength(10)).collect(Collectors.toList());
import org.opensearch.cluster.ClusterState;
        final ClusterState reroutedState2 = rerouteAndStartShards(allocationService, reroutedState1);
import org.opensearch.cluster.ClusterManagerMetrics;
 * You may obtain a copy of the License at
 *
        return IndexMetadata.builder(name)
    public void testFirstListElementsToCommaDelimitedStringReportsAllElementsIfShort() {
        public void beforeAllocation(RoutingAllocation allocation) {}
            .nodes(nodesBuilder)
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
            .routingTable(routingTableBuilder.build())
        }
        for (String string : strings) {
        assertThat(routingTable2.shardsWithState(ShardRoutingState.INITIALIZING), empty());
 * Modifications Copyright OpenSearch Contributors. See
        @Override
    private static class UnrealisticAllocator implements ExistingShardsAllocator {
import org.opensearch.cluster.EmptyClusterInfoService;
            );
        );
                }
    }
        );
            new TestGatewayAllocator(),
                    allocateUnassignedDecision.getTargetNode().getId(),
            .distinct()
    public void testFirstListElementsToCommaDelimitedStringReportsAllElementsIfDebugEnabled() {
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING;
        final RoutingTable routingTable3 = reroutedState3.routingTable();
     */
        }
            assertThat(nodeAllocationResult.getNodeDecision(), equalTo(AllocationDecision.NO));
        );
            .put(
                }
        assertThat(routingTable1.index("mediumPriority").primaryShardsActive(), equalTo(1));
                    .numberOfShards(1)
import org.opensearch.cluster.routing.UnassignedInfo;
                    new SameShardAllocationDecider(settings, clusterSettings),
        nodesBuilder.add(
                "cannot allocate because a previous copy of "
        Set<DiscoveryNodeRole> SEARCH_NODE_ROLE = new HashSet<>(List.of(DiscoveryNodeRole.SEARCH_ROLE));
import org.opensearch.common.settings.Settings;
            return 0;
import org.opensearch.Version;
import org.opensearch.cluster.node.DiscoveryNode;
        nodesBuilder.add(
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)
            .put(
import org.opensearch.cluster.node.DiscoveryNodes;
                )
import java.util.Arrays;
        assertEquals(
            clusterState.getRoutingNodes(),
        nodesBuilder.add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.CURRENT));
        if (strings.size() > 10) {
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.mockito.ArgumentMatchers.anyString;
 * not use this file except in compliance with the License.
            reroutedState.routingTable().shardsWithState(ShardRoutingState.INITIALIZING)
            .metadata(metadata)
import java.util.stream.Collectors;
 * the Apache License, Version 2.0 (the "License"); you may
            .settings(settings(Version.CURRENT).put(settings.build()))
                Arrays.asList(
            EmptyClusterInfoService.INSTANCE,
        // the test harness only permits one recovery per node, so we must have allocated all the high-priority primaries and one of the
            .put(CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING.getKey(), 1)
        final Settings settings = Settings.builder()
    public void testExplainsNonAllocationOfShardWithUnknownAllocator() {
            clusterState.routingTable().index("index").shard(0).primaryShard(),
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder().addAsRecovery(metadataBuilder.get("index1"));
import static org.mockito.Mockito.verify;
        assertThat(routingTable2.index("mediumPriority").shardsWithState(ShardRoutingState.UNASSIGNED).size(), equalTo(1));
            clusterState.metadata().index(indexName).getSettingsVersion() + 1,
        );
            assertThat(nodeAllocationResult.getCanAllocateDecision().label(), equalTo("allocator_plugin"));
import org.opensearch.test.gateway.TestGatewayAllocator;
import org.opensearch.snapshots.EmptySnapshotsInfoService;
    private void assertAllElementsReported(List<String> strings, boolean isDebugEnabled) {
            ),
        assertThat(routingTable1.shardsWithState(ShardRoutingState.RELOCATING), empty());
        final TestShardBatchGatewayAllocator testShardBatchGatewayAllocator = new TestShardBatchGatewayAllocator();
            .numberOfReplicas(1)
                        allocation.deciders().canAllocate(shardRouting, routingNode, allocation);
            new DiscoveryNode("node2", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)
        assertThat(routingTable3.index("mediumPriority").shardsWithState(ShardRoutingState.STARTED).size(), equalTo(4));
        nodesBuilder.add(
        }
                    Settings.builder()
        // the effects of that depend on the earlier (random) allocations
        );
        );
        ClusterState updatedClusterState = allocationService.adaptAutoExpandReplicas(clusterState);
import org.opensearch.cluster.node.DiscoveryNodeRole;
 * Unless required by applicable law or agreed to in writing,
        List<String> strings = IntStream.range(0, between(0, 100)).mapToObj(i -> randomAlphaOfLength(10)).collect(Collectors.toList());
 * GitHub history for details.
/*
            new TestGatewayAllocator(),
        // medium-priority ones
        );
            assertThat(abbreviated, not(containsString("...")));
                        .put(ExistingShardsAllocator.EXISTING_SHARDS_ALLOCATOR_SETTING.getKey(), unrealisticAllocatorName)
        assertAllElementsReported(strings, true);
            .nodes(nodesBuilder)
    public void testFirstListElementsToCommaDelimitedStringUsesFormatterNotToString() {
                    allocation.changes()
                nodeAllocationResult.getCanAllocateDecision().getExplanation(),
            new DiscoveryNode("node3", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)
                        && decision.type() == Decision.Type.THROTTLE) {
            new DiscoveryNode("node5", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_NODE_ROLE, Version.CURRENT)
    public void testFirstListElementsToCommaDelimitedStringReportsFirstElementsIfLong() {
public class AllocationServiceTests extends OpenSearchTestCase {
            new ShardsAllocator() {
                if (decision.type() == Decision.Type.YES) {
import static org.mockito.ArgumentMatchers.anyDouble;
        assertTrue(routingTable3.index("mediumPriority").allPrimaryShardsActive());
        );
        nodesBuilder.add(
        Set<DiscoveryNodeRole> DATA_NODE_ROLE = Set.of(DiscoveryNodeRole.DATA_ROLE);
        assertEquals(2, updatedClusterState.routingTable().index(indexName).shard(0).searchOnlyReplicas().size());
                        + "shard requires an allocator called [unknown] but that allocator was not found; perhaps the corresponding plugin is "
                        .put(IndexMetadata.SETTING_PRIORITY, between(0, 15))
        final RoutingTable routingTable1 = reroutedState1.routingTable();
        public int getNumberOfInFlightFetches() {
            assertThat(nodeAllocationResult.getCanAllocateDecision().type(), equalTo(Decision.Type.NO));
            .metadata(metadataBuilder)
        final ShardAllocationDecision shardAllocationDecision = allocationService.explainShardAllocation(
            // does not allocate any replicas, whereas the medium priority one uses the unrealistic allocator which does allocate replicas
                        settings(Version.CURRENT).put(SETTING_AUTO_EXPAND_REPLICAS, "0-all")
        assertTrue(routingTable1.shardsWithState(ShardRoutingState.STARTED).stream().allMatch(ShardRouting::primary));
        assertTrue(routingTable2.index("lowPriority").allPrimaryShardsActive());
                            .put(SETTING_AUTO_EXPAND_SEARCH_REPLICAS, "0-all")
                public void allocate(RoutingAllocation allocation) {
            String histogramName = (String) invocationOnMock.getArguments()[0];
        final Map<String, ExistingShardsAllocator> allocatorMap = new HashMap<>();
        final String unrealisticAllocatorName = "unrealistic";
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder()
                } else {
 * ownership. Elasticsearch licenses this file to you under
        );
                    return ShardAllocationDecision.NOT_TAKEN;
        List<String> strings = IntStream.range(0, between(0, 100))
            // create 3 indices with different priorities. The high and low priority indices use the default allocator which (in this test)
        allocationService.setExistingShardsAllocators(allocatorMap);
            );
                for (DiscoveryNode node : clusterState.nodes()) {
        public void cleanCaches() {}
        nodesBuilder.add(
        ClusterState updatedClusterState = allocationService.adaptAutoExpandReplicas(clusterState);
                    Settings.builder()
            )
                )
            null,
            null,
        // permit the testGatewayAllocator to allocate primaries to every node
import org.opensearch.common.settings.ClusterSettings;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_SEARCH_REPLICAS;
            new DiscoveryNode("node2", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)
 * SPDX-License-Identifier: Apache-2.0
            clusterState,
            .put(
import static org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus.DECIDERS_NO;
    }
                indexMetadata(
                @Override
        @Override
        assertThat(routingTable3.shardsWithState(ShardRoutingState.INITIALIZING), empty());
import org.opensearch.cluster.ClusterName;
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.stream.IntStream;
            equalTo(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_AUTO_EXPAND_REPLICAS;
                    }
                        && shardRouting.primary() == false
                    testGatewayAllocator.addKnownAllocation(primaryShard.initialize(node.getId(), FAKE_IN_SYNC_ALLOCATION_ID, 0L));
        allocationService.setExistingShardsAllocators(
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder().addAsRecovery(metadataBuilder.get("index1"));
                    .numberOfShards(1)
            .nodes(nodesBuilder)
import org.opensearch.cluster.routing.ShardRouting;
 *
        assertThat(routingTable2.shardsWithState(ShardRoutingState.RELOCATING), empty());
            assertThat(
                assertThat(abbreviated, containsString(strings.get(i)));
        assertThat(routingTable1.shardsWithState(ShardRoutingState.INITIALIZING), empty());
 * specific language governing permissions and limitations
        final MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);
            .metadata(metadataBuilder)
}
            EmptyClusterInfoService.INSTANCE,
        );
    public void testAdaptAutoExpandReplicasWhenAutoExpandChangesNotExists() {
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
            ShardRouting shardRouting,
        final AllocationService allocationService = new AllocationService(
        }
        for (int i = 0; i < strings.size(); i++) {
            new DiscoveryNode("node5", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_NODE_ROLE, Version.CURRENT)
                )
        List<String> strings = IntStream.range(0, between(1, 100)).mapToObj(i -> "original").collect(Collectors.toList());
import org.opensearch.test.OpenSearchTestCase;
            );
            for (IndexShardRoutingTable indexShardRoutingTable : indexRoutingTable) {
        assertEquals(1, updatedClusterState.routingTable().index(indexName).shard(0).searchOnlyReplicas().size());
        final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
/*
 * compatible open source license.
            .addAsRecovery(metadata.get("highPriority"))
                    "invalid",
        final String abbreviated = AllocationService.firstListElementsToCommaDelimitedString(strings, Function.identity(), false);
            new DiscoveryNode("node4", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_NODE_ROLE, Version.CURRENT)
        allocatorMap.put(GatewayAllocator.ALLOCATOR_NAME, testGatewayAllocator);
                );
            boolean throttled = false;
        allocatorMap.put(unrealisticAllocatorName, new UnrealisticAllocator());
 * software distributed under the License is distributed on an
        nodesBuilder.add(new DiscoveryNode("node3", buildNewFakeTransportAddress(), Version.CURRENT));
            new DiscoveryNode("node4", buildNewFakeTransportAddress(), Collections.emptyMap(), SEARCH_NODE_ROLE, Version.CURRENT)
                @Override
            .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING.getKey(), 1)
    private static ClusterState rerouteAndStartShards(final AllocationService allocationService, final ClusterState clusterState) {
        );
            .putInSyncAllocationIds(1, Collections.singleton(FAKE_IN_SYNC_ALLOCATION_ID));
        assertTrue(routingTable3.index("lowPriority").allPrimaryShardsActive());
                    .numberOfSearchReplicas(1)
            new AllocationDeciders(Collections.emptyList()),
            }
import java.util.HashSet;
                    .numberOfSearchReplicas(1)
            }
import org.opensearch.gateway.ShardsBatchGatewayAllocator;
                    + "the primary shard existed but can no longer be found on the nodes in the cluster"
 * this work for additional information regarding copyright
            EmptySnapshotsInfoService.INSTANCE
        @Override
                )
 */
        assertEquals(updatedClusterState, clusterState);
                    .numberOfReplicas(1)
        final String abbreviated = AllocationService.firstListElementsToCommaDelimitedString(strings, Function.identity(), isDebugEnabled);
import static org.hamcrest.Matchers.not;
        }
        assertTrue(routingTable3.index("highPriority").allPrimaryShardsActive());
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
import org.opensearch.cluster.routing.RoutingNode;
                    .settings(settings(Version.CURRENT))
            new DiscoveryNode("node3", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)
            .routingTable(routingTableBuilder.build())
import org.opensearch.cluster.routing.allocation.allocator.ShardsAllocator;
    private static final String FAKE_IN_SYNC_ALLOCATION_ID = "_in_sync_"; // so we can allocate primaries anywhere
import java.util.List;
    }
        nodesBuilder.add(
    /**
        assertThat(routingTable2.index("mediumPriority").shardsWithState(ShardRoutingState.STARTED).size(), equalTo(3));
        allocatorMap.put(ShardsBatchGatewayAllocator.ALLOCATOR_NAME, testShardBatchGatewayAllocator);
                )
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_CONCURRENT_INCOMING_RECOVERIES_SETTING;
                    .settings(
        assertEquals(2, updatedClusterState.metadata().index(indexName).getNumberOfReplicas());
            .metadata(metadata)
            null,
        assertEquals(2, updatedClusterState.routingTable().index(indexName).shard(0).writerReplicas().size());
        );
            .nodes(nodesBuilder)
        String indexName = "index1";
import org.opensearch.telemetry.metrics.Histogram;
            );
        assertEquals(1, updatedClusterState.routingTable().index(indexName).shard(0).writerReplicas().size());
            shardAllocationDecision.getAllocateDecision().getExplanation(),
        Set<DiscoveryNodeRole> SEARCH_NODE_ROLE = Set.of(DiscoveryNodeRole.SEARCH_ROLE);
        assertThat(routingTable3.index("invalid").shardsWithState(ShardRoutingState.STARTED), empty());
            new DiscoveryNode("node1", buildNewFakeTransportAddress(), Collections.emptyMap(), DATA_NODE_ROLE, Version.CURRENT)
import org.opensearch.cluster.metadata.IndexMetadata;
        );
            new AllocationDeciders(
        final RoutingTable routingTable2 = reroutedState2.routingTable();
        assertThat(abbreviated, containsString("formatted"));
        final TestGatewayAllocator testGatewayAllocator = new TestGatewayAllocator();
            new BalancedShardsAllocator(Settings.EMPTY),
                    "finding the previous copies of this "
        public void applyStartedShards(List<ShardRouting> startedShards, RoutingAllocation allocation) {}
            .collect(Collectors.toList());
                }
        @Override
            }
    }
        assertThat(routingTable3.shardsWithState(ShardRoutingState.RELOCATING), empty());
                throttled = throttled || decision.type() == Decision.Type.THROTTLE;
                    // from falling through to here
            equalTo(UnassignedInfo.AllocationStatus.NO_VALID_SHARD_COPY)
            .routingTable(routingTableBuilder.build())
        allocation.setDebugMode(randomBoolean() ? RoutingAllocation.DebugMode.ON : RoutingAllocation.DebugMode.EXCLUDE_YES_DECISIONS);
        // this reroute starts the one remaining medium-priority replica
 * The OpenSearch Contributors require contributions made to
            .build();
            if (histogramName.contains("reroute.latency")) {
            ClusterInfo.EMPTY,
    }
        assertAllElementsReported(strings, randomBoolean());
            .putInSyncAllocationIds(0, Collections.singleton(FAKE_IN_SYNC_ALLOCATION_ID))
    }
                IndexMetadata.builder(indexName)
        final RoutingTable.Builder routingTableBuilder = RoutingTable.builder().addAsRecovery(metadata.get("index"));
        final Metadata.Builder metadata = Metadata.builder()
        final Histogram rerouteHistogram = mock(Histogram.class);
        public void afterPrimariesBeforeReplicas(RoutingAllocation allocation) {}
                indexMetadata(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
                        .put(IndexMetadata.SETTING_PRIORITY, 5)
 * license agreements. See the NOTICE file distributed with
                final ShardRouting primaryShard = indexShardRoutingTable.primaryShard();
import static org.mockito.Mockito.times;
        final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
        Set<DiscoveryNodeRole> DATA_NODE_ROLE = new HashSet<>(List.of(DiscoveryNodeRole.DATA_ROLE));
        assertThat(routingTable2.index("invalid").shardsWithState(ShardRoutingState.STARTED), empty());
import static org.hamcrest.Matchers.empty;
            .put(CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_REPLICAS_RECOVERIES_SETTING.getKey(), 1)
        return allocationService.applyStartedShards(
            assertThat(abbreviated, containsString("[" + strings.size() + " items in total]"));
        assertTrue(routingTable2.index("mediumPriority").allPrimaryShardsActive());
        );
        assertEquals(2, updatedClusterState.metadata().index(indexName).getNumberOfSearchOnlyReplicas());
        final Metadata.Builder metadata = Metadata.builder()
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        }
        }
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
     * Allocates shards to nodes regardless of whether there's already a shard copy there.
        }
import java.util.HashMap;
        nodesBuilder.add(
                    )
    public void testAdaptAutoExpandReplicasWhenAutoExpandChangesExists() {
import org.opensearch.gateway.GatewayAllocator;
        final ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT)
        ) {
        Metadata.Builder metadataBuilder = Metadata.builder()
            allocation
        public void applyFailedShards(List<FailedShard> failedShards, RoutingAllocation allocation) {}
    }
        assertThat(
            .numberOfShards(2)
        nodesBuilder.add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.CURRENT));
import org.opensearch.cluster.metadata.Metadata;
        assertThat(routingTable1.index("lowPriority").shardsWithState(ShardRoutingState.STARTED), empty());
import static org.hamcrest.Matchers.containsString;
            final AllocateUnassignedDecision allocateUnassignedDecision = explainUnassignedShardAllocation(shardRouting, allocation);
        final ClusterState reroutedState1 = rerouteAndStartShards(allocationService, clusterState);
        assertEquals(1, updatedClusterState.metadata().index(indexName).getNumberOfReplicas());
                    0L,
            .build();
            } else {
        );
import java.util.function.Function;
        final RoutingAllocation allocation = new RoutingAllocation(
    }
/*
            .put(indexMetadata("highPriority", Settings.builder().put(IndexMetadata.SETTING_PRIORITY, 10)))
                assertThat(abbreviated, not(containsString(strings.get(i))));
            UnassignedAllocationHandler unassignedAllocationHandler
        final AllocationService allocationService = new AllocationService(
        final AllocationService allocationService = new AllocationService(
            null,
            .put(
            return throttled ? AllocateUnassignedDecision.throttle(null) : AllocateUnassignedDecision.no(DECIDERS_NO, null);
            assertThat(abbreviated, containsString(string));
            }
import static org.mockito.Mockito.when;
        );
