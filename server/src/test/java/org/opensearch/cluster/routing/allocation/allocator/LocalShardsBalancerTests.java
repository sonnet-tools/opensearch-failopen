        assertEquals(8, initializingShards.size());  
            provideAllocationDecidersWithNoDecisionForRegularReplica(),
 *
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        BalancedShardsAllocator.WeightFunction weightFunction = mock(BalancedShardsAllocator.WeightFunction.class);  
            false,
        int numberOfReplicas,  
            null,
            logger,  
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
            state,  
            0,  
            logger,
    private Metadata buildMetadata(
            this.decider = decider;
    public void testAllocateUnassignedWhenAllShardsCanBeAllocated() {  
import java.util.Collections;  
            provideAllocationDecidersWithNoDecisionForSearchReplica(),
            return decider.apply(shardRouting);
import org.opensearch.cluster.routing.RoutingTable;  
    private RoutingTable buildRoutingTable(Metadata metadata) {  
        );  
            .metadata(metadata)
            null,  
import org.opensearch.cluster.ClusterName;  
        assertEquals(6, initializingShards.size());
import org.opensearch.cluster.routing.allocation.decider.Decision;  
    private final DiscoveryNode node3 = newNode("node3", "node3", Collections.singletonMap("zone", "1c"));
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        }
            0,
import org.opensearch.cluster.node.DiscoveryNodes;  
            null
import java.util.Arrays;
            } else {
            null  
    public void testAllocateUnassignedWhenRegularReplicaShardsCannotBeAllocated() {
import org.opensearch.cluster.node.DiscoveryNode;
        );
            .routingTable(routingTable)
    }  
    }
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);
import org.opensearch.cluster.routing.ShardRoutingState;
            System.nanoTime()
        public Decision canAllocate(ShardRouting shardRouting, RoutingAllocation allocation) {
 * The OpenSearch Contributors require contributions made to  
                return Decision.NO;  
        for (int i = 0; i < numberOfIndices; i++) {  
        RoutingAllocation allocation = new RoutingAllocation(
            .routingTable(routingTable)  
        RoutingTable routingTable = buildRoutingTable(metadata);  
        );
            return decider.apply(shardRouting);  
            ClusterInfo.EMPTY,
        int numberOfReplicas = 2;
        }  
        Metadata.Builder mb,  
import java.util.function.Function;  
import org.opensearch.cluster.routing.ShardRouting;
            weightFunction,
                return Decision.NO;
            ClusterInfo.EMPTY,
import org.opensearch.cluster.metadata.IndexMetadata;  
        assertEquals(4, unassignedShards.size());  
            false,
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        int numberOfSearchReplicas = 3;
}
            );
        localShardsBalancer.allocateUnassigned();
            new RoutingNodes(state, false),
    ) {
import org.opensearch.Version;
        for (Map.Entry<String, IndexMetadata> entry : metadata.getIndices().entrySet()) {
        final ShardsBalancer localShardsBalancer = new LocalShardsBalancer(
        );
        return new AllocationDeciders(Arrays.asList(new TestAllocateDecision((shardRouting -> {
        int numberOfIndices,
    public static class TestAllocateDecision extends AllocationDecider {
            .build();  
import org.opensearch.cluster.routing.allocation.decider.SameShardAllocationDecider;
import org.opensearch.cluster.ClusterInfo;
import org.opensearch.cluster.OpenSearchAllocationTestCase;
            .build();
        int numberOfSearchReplicas = 3;
            new RoutingNodes(state, false),  
    }
public class LocalShardsBalancerTests extends OpenSearchAllocationTestCase {  
import org.opensearch.common.settings.Settings;  
            false,
import static org.mockito.Mockito.when;
        }
        );  
import org.opensearch.common.settings.ClusterSettings;
        int numberOfReplicas = 2;
import static org.mockito.Mockito.mock;  
        when(weightFunction.weightWithAllocationConstraints(any(), any(), any())).thenReturn(0.5F);
            .build();
        when(weightFunction.weightWithAllocationConstraints(any(), any(), any())).thenReturn(0.5F);
        })), new SameShardAllocationDecider(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)))
            routingTableBuilder.addAsNew(entry.getValue());  
                IndexMetadata.builder("test_" + i)
            allocation,  
            allocation,
        public Decision canAllocate(ShardRouting shardRouting, RoutingNode node, RoutingAllocation allocation) {
            weightFunction,  
            false,
import org.opensearch.cluster.routing.RoutingNode;
            System.nanoTime()  
        return new AllocationDeciders(Arrays.asList(new TestAllocateDecision((shardRouting -> {
package org.opensearch.cluster.routing.allocation.allocator;
            if (!shardRouting.isSearchOnly() && !shardRouting.primary()) {
        final ShardsBalancer localShardsBalancer = new LocalShardsBalancer(
            false,  
                    .numberOfShards(numberOfShards)
        }
        RoutingAllocation allocation = new RoutingAllocation(  
        );
    private final DiscoveryNode node6 = newNode("node6", "node6", Collections.singletonMap("zone", "1c"));
            null,
            System.nanoTime()
            null,  
            ClusterInfo.EMPTY,  
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3).add(node4).add(node5).add(node6))
            if (shardRouting.isSearchOnly()) {  
    private final DiscoveryNode node1 = newNode("node1", "node1", Collections.singletonMap("zone", "1a"));
        })), new SameShardAllocationDecider(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)))
    }  
    private AllocationDeciders provideAllocationDecidersWithNoDecisionForRegularReplica() {  
                    .numberOfReplicas(numberOfReplicas)
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3).add(node4).add(node5).add(node6))  
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas, numberOfSearchReplicas);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        final ShardsBalancer localShardsBalancer = new LocalShardsBalancer(  
                    .numberOfSearchReplicas(numberOfSearchReplicas)  
        localShardsBalancer.allocateUnassigned();
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        RoutingAllocation allocation = new RoutingAllocation(
            null,
            .metadata(metadata)  
    private AllocationDeciders provideAllocationDecidersWithNoDecisionForSearchReplica() {
        assertEquals(12, initializingShards.size());
            allocation,
        assertEquals(6, unassignedShards.size());
                return Decision.YES;
            mb.put(
        localShardsBalancer.allocateUnassigned();  
import org.opensearch.cluster.routing.allocation.decider.AllocationDecider;
        int numberOfSearchReplicas
    }
            } else {
    private final DiscoveryNode node4 = newNode("node4", "node4", Collections.singletonMap("zone", "1a"));
        public TestAllocateDecision(Function<ShardRouting, Decision> decider) {  
            false,
        @Override  
        int numberOfIndices = 2;
        RoutingTable routingTable = buildRoutingTable(metadata);
import org.opensearch.cluster.ClusterState;
            false,
    private final DiscoveryNode node2 = newNode("node2", "node2", Collections.singletonMap("zone", "1b"));  
            yesAllocationDeciders(),  
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas, numberOfSearchReplicas);
                return Decision.YES;  
        int numberOfSearchReplicas = 3;  
        BalancedShardsAllocator.WeightFunction weightFunction = mock(BalancedShardsAllocator.WeightFunction.class);
        List<ShardRouting> initializingShards = allocation.routingNodes().shardsWithState(ShardRoutingState.INITIALIZING);  
import org.opensearch.cluster.routing.RoutingNodes;
 */  
    public void testAllocateUnassignedWhenSearchShardsCannotBeAllocated() {
        assertEquals(0, unassignedShards.size());
        int numberOfShards = 1;  
            logger,
            false,  
        RoutingTable routingTable = buildRoutingTable(metadata);
        private final Function<ShardRouting, Decision> decider;
        Metadata metadata = buildMetadata(Metadata.builder(), numberOfIndices, numberOfShards, numberOfReplicas, numberOfSearchReplicas);  
        int numberOfIndices = 2;
        List<ShardRouting> unassignedShards = allocation.routingNodes().unassigned().ignored();
        int numberOfShards = 1;
            state,
            weightFunction,
        int numberOfShards,
            null,
        return routingTableBuilder.build();
            null
        }
    }  
import org.opensearch.cluster.metadata.Metadata;
        BalancedShardsAllocator.WeightFunction weightFunction = mock(BalancedShardsAllocator.WeightFunction.class);
        );
            .metadata(metadata)
        return mb.build();
        when(weightFunction.weightWithAllocationConstraints(any(), any(), any())).thenReturn(0.5F);  
import java.util.Map;
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            .routingTable(routingTable)
            false,  
        int numberOfReplicas = 2;  
        int numberOfIndices = 2;  
                    .settings(settings(Version.CURRENT))  
    private final DiscoveryNode node5 = newNode("node5", "node5", Collections.singletonMap("zone", "1b"));  
        );  
 * compatible open source license.
import static org.mockito.ArgumentMatchers.any;
            0,
        List<ShardRouting> unassignedShards = allocation.routingNodes().unassigned().ignored();  
            state,
        List<ShardRouting> unassignedShards = allocation.routingNodes().shardsWithState(ShardRoutingState.UNASSIGNED);
            }
            .nodes(DiscoveryNodes.builder().add(node1).add(node2).add(node3).add(node4).add(node5).add(node6))
    }
import java.util.List;
        int numberOfShards = 1;
            new RoutingNodes(state, false),
import org.opensearch.cluster.routing.allocation.RoutingAllocation;  
        @Override
    }
/*  
            }  
