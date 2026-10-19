            } else {
import org.opensearch.cluster.routing.allocation.decider.Decision;
import org.opensearch.cluster.routing.RoutingNode;
import org.opensearch.cluster.node.DiscoveryNode;
        @Override
public class LocalShardsBalancerTests extends OpenSearchAllocationTestCase {
        RoutingAllocation allocation = new RoutingAllocation(
            .build();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(4, unassignedShards.size());
    private final DiscoveryNode node2 = newNode("node2", "node2", Collections.singletonMap("zone", "1b"));
        assertEquals(6, initializingShards.size());
        );
            .build();
            null,
import org.opensearch.cluster.metadata.IndexMetadata;
        RoutingAllocation allocation = new RoutingAllocation(
        assertEquals(0, unassignedShards.size());
            return decider.apply(shardRouting);
    }
            false,
            this.decider = decider;
        RoutingTable routingTable = buildRoutingTable(metadata);
            }
import org.opensearch.cluster.ClusterState;
import java.util.Map;
            .routingTable(routingTable)
        );
        List<ShardRouting> unassignedShards = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);
            System.nanoTime()
        int numberOfIndices,
 *
            .metadata(metadata)
                IndexMetadata.builder("test_" + i)
            allocation,
            new RoutingNodes(state, false),
        );
    private Metadata buildMetadata(
            logger,
            null,
        localShardsBalancer.allocateUnassigned();
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3).add(node4).add(node5).add(node6))
        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
        int numberOfSearchReplicas = 3;
            System.nanoTime()
            if (!shardRouting.isSearchOnly() && !shardRouting.primary()) {
        return mb.build();
        }
        int numberOfShards = 1;
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
        );
            false,
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3).add(node4).add(node5).add(node6))
            allocation,
    private final DiscoveryNode node1 = newNode("node1", "node1", Collections.singletonMap("zone", "1a"));
            .build();
            ClusterInfo.EMPTY,
    private RoutingTable buildRoutingTable(Metadata metadata) {
        localShardsBalancer.allocateUnassigned();
import java.util.function.Function;
        int numberOfShards,
            0,
            logger,
        List<ShardRouting> unassignedShards = allocation.routingNodes().unassigned().ignored();
        when(weightFunction.weightWithAllocationConstraints(any(), any(), any())).thenReturn(0.5F);
        RoutingTable routingTable = buildRoutingTable(metadata);
        private final Function<ShardRouting, Decision> decider;
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            null,
    }
            0,
import org.opensearch.cluster.routing.RoutingTable;
        }
        List<ShardRouting> unassignedShards = allocation.routingNodes().unassigned().ignored();
        }
    private final DiscoveryNode node4 = newNode("node4", "node4", Collections.singletonMap("zone", "1a"));
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
            weightFunction,
        final ShardsBalancer localShardsBalancer = new LocalShardsBalancer(
            false,
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas, numberOfSearchReplicas);
        );
                    .numberOfShards(numberOfShards)
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas, numberOfSearchReplicas);
            false,
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
import static org.mockito.Mockito.when;
 * this file be licensed under the Apache-2.0 license or a
    }
                    .settings(settings(Version.CURRENT))
        }
import org.opensearch.cluster.metadata.Metadata;
    }
            state,
                    .numberOfReplicas(numberOfReplicas)
    ) {
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
    private AllocationDeciders provideAllocationDecidersWithNoDecisionForRegularReplica() {
                return Decision.NO;
            .metadata(metadata)
            new RoutingNodes(state, false),
        );
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
                return Decision.YES;
    }
            null,
    public void testAllocateUnassignedWhenSearchShardsCannotBeAllocated() {
import static org.mockito.ArgumentMatchers.any;
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            if (shardRouting.isSearchOnly()) {
import org.opensearch.common.settings.Settings;
 */
            false,
    private final DiscoveryNode node6 = newNode("node6", "node6", Collections.singletonMap("zone", "1c"));
        Metadata.Builder mb,
        int numberOfReplicas,
        int numberOfReplicas = 2;
        RoutingAllocation allocation = new RoutingAllocation(
        for (Map.Entry<String, IndexMetadata> entry : metadata.getIndices().entrySet()) {
    }
        public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
            null,
            provideAllocationDecidersWithNoDecisionForRegularReplica(),
package org.opensearch.cluster.routing.allocation.allocator;
            return decider.apply(shardRouting);
            null,
            false,
        int numberOfIndices = 2;
        BalancedShardsAllocator.WeightFunction weightFunction = mock(BalancedShardsAllocator.WeightFunction.class);
            0,
        when(weightFunction.weightWithAllocationConstraints(any(), any(), any())).thenReturn(0.5F);
 * compatible open source license.
        int numberOfIndices = 2;
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
 * The OpenSearch Contributors require contributions made to
        when(weightFunction.weightWithAllocationConstraints(any(), any(), any())).thenReturn(0.5F);
    private final DiscoveryNode node5 = newNode("node5", "node5", Collections.singletonMap("zone", "1b"));
            System.nanoTime()
            allocation,
            ClusterInfo.EMPTY,
        for (int i = 0; i < numberOfIndices; i++) {
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3).add(node4).add(node5).add(node6))
                return Decision.NO;
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(12, initializingShards.size());
        })), new SameShardAllocationDecider(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)))
            null
/*
import org.opensearch.cluster.routing.RoutingNodes;
    public static class TestAllocateDecision extends AllocationDecider {
            weightFunction,
        localShardsBalancer.allocateUnassigned();
}
                return Decision.YES;
            new RoutingNodes(state, false),
        int numberOfSearchReplicas = 3;
    public void testAllocateUnassignedWhenAllShardsCanBeAllocated() {
            yesAllocationDeciders(),
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        final ShardsBalancer localShardsBalancer = new LocalShardsBalancer(
        return new AllocationDeciders(Arrays.asList(new TestAllocateDecision((shardRouting -> {
            routingTableBuilder.addAsNew(entry.getValue());
            state,
            mb.put(
        int numberOfSearchReplicas = 3;
        @Override
import org.opensearch.Version;
        int numberOfShards = 1;
                    .numberOfSearchReplicas(numberOfSearchReplicas)
    private final DiscoveryNode node3 = newNode("node3", "node3", Collections.singletonMap("zone", "1c"));
        int numberOfReplicas = 2;
        );
        int numberOfReplicas = 2;
        }
import org.opensearch.cluster.routing.ShardRoutingState;
    public void testAllocateUnassignedWhenRegularReplicaShardsCannotBeAllocated() {
import org.opensearch.cluster.routing.ShardRouting;
            false,
            .routingTable(routingTable)
        );
            null
            .metadata(metadata)
import static org.mockito.Mockito.mock;
        public TestAllocateDecision(Function<ShardRouting, Decision> decider) {
        int numberOfIndices = 2;
        return routingTableBuilder.build();
        final ShardsBalancer localShardsBalancer = new LocalShardsBalancer(
            } else {
import org.opensearch.cluster.ClusterName;
        BalancedShardsAllocator.WeightFunction weightFunction = mock(BalancedShardsAllocator.WeightFunction.class);
        return new AllocationDeciders(Arrays.asList(new TestAllocateDecision((shardRouting -> {
            logger,
    }
            state,
    }
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
    private AllocationDeciders provideAllocationDecidersWithNoDecisionForSearchReplica() {
            false,
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas, numberOfSearchReplicas);
import java.util.List;
        })), new SameShardAllocationDecider(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)))
        int numberOfSearchReplicas
        assertEquals(6, unassignedShards.size());
            );
        int numberOfShards = 1;
        RoutingTable routingTable = buildRoutingTable(metadata);
            .routingTable(routingTable)
            }
            provideAllocationDecidersWithNoDecisionForSearchReplica(),
import org.opensearch.cluster.ClusterInfo;
import java.util.Collections;
            false,
            ClusterInfo.EMPTY,
            weightFunction,
import org.opensearch.cluster.node.DiscoveryNodes;
        BalancedShardsAllocator.WeightFunction weightFunction = mock(BalancedShardsAllocator.WeightFunction.class);
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            null
import java.util.Arrays;
        assertEquals(8, initializingShards.size());
