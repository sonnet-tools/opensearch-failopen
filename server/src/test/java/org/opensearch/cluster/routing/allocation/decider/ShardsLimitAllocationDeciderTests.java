        ClusterSettings clusterSettingsObject = new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // Setup routing for test1 (3 primaries)
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.routing.RoutingTable;
            .routingTable(routingTable)
import org.opensearch.cluster.node.DiscoveryNode;
        allocation.debugDecision(true);
                                                                                                                              // test3 to
        Settings settings = Settings.builder().put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2).build();
    }
        // Create a RoutingTable with shards 0 and 1 initialized on node1, and shard 2 unassigned
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 1, null, null, true, ShardRoutingState.UNASSIGNED));
import org.opensearch.test.OpenSearchTestCase;
        test2Builder.addShard(TestShardRouting.newShardRouting("test2", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        routingTableBuilder.add(test3Builder.build());
                                                                                                                              // test1 to
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // Test allocation decisions
 * The OpenSearch Contributors require contributions made to
        ShardRouting shard2 = routingTable.index("test").shard(1).primaryShard();
            .routingTable(routingTable)
        // Set up routing table for test1
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        Metadata metadata = Metadata.builder()
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
            .put(IndexMetadata.builder("test1").settings(indexSettings).numberOfShards(3).numberOfReplicas(0))
        assertEquals(YES, decider.canAllocate(test2Shard2, clusterState.getRoutingNodes().node("node1"), allocation).type()); // Can assign
        Settings indexSettingsTest2 = Settings.builder()
        Settings indexSettingsTest3 = Settings.builder()
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
        // Shard 2: Unassigned
        // Test assertions
        Metadata metadata = Metadata.builder()
                                                                                                                              // node2
                                                                                                                              // node1
            .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2)
                                                                                                                              // of test2 to
import org.opensearch.cluster.metadata.IndexMetadata;
        ShardRouting shard3 = routingTable.index("test").shard(2).primaryShard();
        // test1: First primary on node1
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        // Set up routing table for test2
            .routingTable(routingTable)
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
        routingTableBuilder.add(test2RoutingTableBuilder.build());
        RoutingTable routingTable = routingTableBuilder.build();
import static org.opensearch.cluster.routing.allocation.decider.Decision.Type.YES;
        assertEquals(NO, decider.canAllocate(test2Replica2, clusterState.getRoutingNodes().node("node2"), allocation).type());
            .build();
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 1, null, null, true, ShardRoutingState.UNASSIGNED));
import org.opensearch.indices.replication.common.ReplicationType;
        ShardRouting test1Shard1 = routingTable.index("test1").shard(0).primaryShard();
        routingTableBuilder.add(test1RoutingTableBuilder.build());
        Settings settings = Settings.builder().build();
import org.opensearch.cluster.routing.IndexRoutingTable;
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 2, null, null, true, ShardRoutingState.UNASSIGNED));
            .put(IndexMetadata.builder("test2").settings(indexSettings).numberOfShards(3).numberOfReplicas(0))
    private DiscoveryNode newNode(String nodeId) {
            .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), -1)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
public class ShardsLimitAllocationDeciderTests extends OpenSearchTestCase {
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 1)  // Set index-level limit to 1
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
                                                                                                                              // node2
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        // test2: Second primary on node2
import org.opensearch.cluster.routing.TestShardRouting;
import org.opensearch.cluster.routing.ShardRoutingState;
            .build();
            .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 3)
        IndexRoutingTable.Builder test2RoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test2").getIndex());
            .build();
    public void testWithNoLimit() {
 */
    public void testClusterShardLimit() {
        assertEquals(NO, decider.canAllocate(test2Shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
        ShardRouting test3Shard2 = routingTable.index("test3").shard(2).primaryShard();
        assertEquals(YES, decider.canAllocate(test2Shard2, clusterState.getRoutingNodes().node("node1"), allocation).type());
        // Test allocation decisions
    }
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
            .build();
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        // Cannot allocate third primary to node1 (would exceed primary shard limit)
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, true, ShardRoutingState.STARTED));
        Settings indexSettings = Settings.builder()
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(clusterSettings, clusterSettingsObject);
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
                                                                                                                              // assign 3rd
        assertEquals(YES, decider.canAllocate(shard3, clusterState.getRoutingNodes().node("node2"), allocation).type());
        ShardRouting shard2 = routingTable.index("test").shard(1).primaryShard();
        test1Builder.addShard(TestShardRouting.newShardRouting("test1", 0, "node1", null, true, ShardRoutingState.STARTED));
            .build();
        assertEquals(YES, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
            .metadata(metadata)
        ShardRouting test1Shard1 = routingTable.index("test1").shard(1).primaryShard();
        routingTableBuilder.add(indexRoutingTableBuilder.build());
            .build();
        RoutingTable routingTable = routingTableBuilder.build();
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
        assertEquals(YES, decider.canAllocate(shard3, clusterState.getRoutingNodes().node("node2"), allocation).type());
                                                                                                                              // assign 3rd
    }
import org.opensearch.Version;
            .build();
import org.opensearch.common.settings.ClusterSettings;
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), Collections.emptyMap(), roles, Version.CURRENT);
        assertEquals(NO, decider.canAllocate(test1Shard2, clusterState.getRoutingNodes().node("node1"), allocation).type());  // Cannot
        Settings clusterSettings = Settings.builder()
    }
}
        // Existing primary can remain
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 2, null, null, true, ShardRoutingState.UNASSIGNED));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        Set<DiscoveryNodeRole> roles = new HashSet<>(Collections.singleton(DiscoveryNodeRole.DATA_ROLE));
        ShardRouting test1Shard3 = routingTable.index("test1").shard(2).primaryShard();
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 0, "node1", null, true, ShardRoutingState.STARTED));
        test3Builder.addShard(TestShardRouting.newShardRouting("test3", 1, "node2", null, true, ShardRoutingState.STARTED));
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
            .metadata(metadata)
        Metadata metadata = Metadata.builder()
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 1, null, null, false, ShardRoutingState.UNASSIGNED));
    public void testClusterPrimaryShardLimit() {
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(settings, clusterSettings);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(YES, decider.canAllocate(test2Shard2, clusterState.getRoutingNodes().node("node2"), allocation).type()); // Can assign
        // Shard 0 and 1: STARTED on node1
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 1, "node2", null, true, ShardRoutingState.STARTED));
        // Create metadata for two indices
        IndexRoutingTable.Builder test2Builder = IndexRoutingTable.builder(metadata.index("test2").getIndex());
import java.util.HashSet;
        allocation.debugDecision(true);
        // Test allocation decisions
                                                                                                                              // 3rd shard
        // Setup routing for test2 (2 primaries, 1 replica)
        assertEquals(YES, decider.canRemain(test2Shard1, clusterState.getRoutingNodes().node("node2"), allocation).type());
        IndexRoutingTable.Builder test1RoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test1").getIndex());
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 1, "node2", null, true, ShardRoutingState.STARTED));
        test3Builder.addShard(TestShardRouting.newShardRouting("test3", 2, null, null, true, ShardRoutingState.UNASSIGNED));
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));
        ShardRouting test1Shard2 = routingTable.index("test1").shard(2).primaryShard();
                                                                                                                              // node1
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // Set up routing table for test2
        RoutingTable routingTable = routingTableBuilder.build();
        // test2: First replica on node2
            .metadata(metadata)
        assertEquals(NO, decider.canAllocate(test3Shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());  // Cannot
        routingTableBuilder.add(test2RoutingTableBuilder.build());
            .put(IndexMetadata.builder("test2").settings(indexSettingsTest2).numberOfShards(3).numberOfReplicas(0))
            .routingTable(routingTable)
    public void testIndexShardLimit() {
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        // Cannot allocate second replica to node2 (would exceed total shard limit)
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        RoutingTable routingTable = routingTableBuilder.build();
            .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 1, "node1", null, true, ShardRoutingState.STARTED));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
        test1Builder.addShard(TestShardRouting.newShardRouting("test1", 1, "node2", null, true, ShardRoutingState.STARTED));
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, false, ShardRoutingState.STARTED));
import static org.opensearch.cluster.routing.allocation.decider.Decision.Type.NO;
        assertEquals(YES, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        assertEquals(NO, decider.canAllocate(test1Shard3, clusterState.getRoutingNodes().node("node2"), allocation).type());
            .build();
        // Create index settings for three indices
    public void testIndexPrimaryShardLimit() {
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(clusterSettings, clusterSettingsObject);
        // Shard 2: Unassigned
                                                                                                                              // shard of
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        routingTableBuilder.add(indexRoutingTableBuilder.build());
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(settings, clusterSettings);
        assertEquals(NO, decider.canAllocate(test1Shard2, clusterState.getRoutingNodes().node("node1"), allocation).type());
        test1Builder.addShard(TestShardRouting.newShardRouting("test1", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        RoutingTable routingTable = routingTableBuilder.build();
 *
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ShardRouting test2Shard2 = routingTable.index("test2").shard(2).primaryShard();
                                                                                                                              // shard of
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        // Set up routing table for test3
        ShardRouting shard3 = routingTable.index("test").shard(2).primaryShard();
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
            .build();
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(settings, clusterSettings);
            .build();
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(0))
        test2Builder.addShard(TestShardRouting.newShardRouting("test2", 1, "node2", null, true, ShardRoutingState.STARTED));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
            .metadata(metadata)
        // Get unassigned shards for testing
import org.opensearch.cluster.metadata.Metadata;
        assertEquals(NO, decider.canAllocate(test1Shard3, clusterState.getRoutingNodes().node("node1"), allocation).type());
    }
        // test2: Second replica unassigned
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(0))
        ShardRouting test2Replica2 = routingTable.index("test2").shard(1).replicaShards().get(0);
        Settings indexSettingsTest1 = Settings.builder()
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(0))
        // test2: First primary on node1
        assertEquals(YES, decider.canAllocate(test1Shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
        routingTableBuilder.add(test1Builder.build());
        // test1: Third primary unassigned
        ShardRouting test1Shard2 = routingTable.index("test1").shard(2).primaryShard();
        // Create index settings with INDEX_TOTAL_SHARDS_PER_NODE_SETTING and version
        routingTableBuilder.add(test1RoutingTableBuilder.build());
import java.util.Set;
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        // Shard 0 and 1: STARTED on node1
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.node.DiscoveryNodeRole;
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.node.DiscoveryNodes;
            .build();
        IndexRoutingTable.Builder test1Builder = IndexRoutingTable.builder(metadata.index("test1").getIndex());
 * SPDX-License-Identifier: Apache-2.0
        // Get shards for testing
        allocation.debugDecision(true);
import org.opensearch.common.settings.Settings;
            .build();
                                                                                                                              // 3rd shard
        // Create routing table
package org.opensearch.cluster.routing.allocation.decider;
        allocation.debugDecision(true);
        test3Builder.addShard(TestShardRouting.newShardRouting("test3", 0, "node1", null, true, ShardRoutingState.STARTED));
        Settings settings = Settings.builder()
            .put(IndexMetadata.builder("test1").settings(indexSettingsTest1).numberOfShards(3).numberOfReplicas(0))
            .routingTable(routingTable)
            .put(IndexMetadata.builder("test3").settings(indexSettingsTest3).numberOfShards(3).numberOfReplicas(0))
        // Can allocate second replica to node1 (within total shard limit)
        assertEquals(YES, decider.canRemain(test1Shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
import java.util.Collections;
        ClusterSettings clusterSettingsObject = new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(YES, decider.canAllocate(test2Replica2, clusterState.getRoutingNodes().node("node1"), allocation).type());
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        test2Builder.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, true, ShardRoutingState.STARTED));
        IndexRoutingTable.Builder test2RoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test2").getIndex());
            .build();
        Settings clusterSettings = Settings.builder()
            .metadata(metadata)
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        // Cannot allocate third primary to node2 (would exceed primary shard limit)
 * compatible open source license.
        IndexRoutingTable.Builder test3Builder = IndexRoutingTable.builder(metadata.index("test3").getIndex());
        assertEquals(YES, decider.canRemain(test1Shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        routingTableBuilder.add(test2Builder.build());
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 0, "node1", null, true, ShardRoutingState.STARTED));
            .build();
        ShardRouting test2Shard1 = routingTable.index("test2").shard(1).primaryShard();
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
            .build();
    }
        Metadata metadata = Metadata.builder()
        assertEquals(YES, decider.canAllocate(shard3, clusterState.getRoutingNodes().node("node1"), allocation).type());
/*
                                                                                                                              // of test2 to
        // Set up routing table for test1
        IndexRoutingTable.Builder test1RoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test1").getIndex());
        ShardRouting test2Shard2 = routingTable.index("test2").shard(2).primaryShard();
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 1, "node1", null, true, ShardRoutingState.STARTED));
        assertEquals(NO, decider.canAllocate(shard3, clusterState.getRoutingNodes().node("node1"), allocation).type());
        // Create a RoutingTable with shards 0 and 1 initialized on node1, and shard 2 unassigned
        // Test allocation decisions
            .build();
        // test1: Second primary on node2
        allocation.debugDecision(true);
