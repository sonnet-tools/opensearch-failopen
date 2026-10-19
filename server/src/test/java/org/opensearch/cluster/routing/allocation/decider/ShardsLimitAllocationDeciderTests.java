        test1Builder.addShard(TestShardRouting.newShardRouting("test1", 0, "node1", null, true, ShardRoutingState.STARTED));  
        IndexRoutingTable.Builder test3Builder = IndexRoutingTable.builder(metadata.index("test3").getIndex());
        // Shard 0 and 1: STARTED on node1
        assertEquals(YES, decider.canAllocate(shard3, clusterState.getRoutingNodes().node("node2"), allocation).type());
            .build();
        RoutingTable routingTable = routingTableBuilder.build();
        assertEquals(YES, decider.canAllocate(test2Shard2, clusterState.getRoutingNodes().node("node1"), allocation).type());
        ShardRouting shard3 = routingTable.index("test").shard(2).primaryShard();
        return new DiscoveryNode(nodeId, buildNewFakeTransportAddress(), Collections.emptyMap(), roles, Version.CURRENT);
        ShardRouting test3Shard2 = routingTable.index("test3").shard(2).primaryShard();  
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 0, "node1", null, true, ShardRoutingState.STARTED));
        assertEquals(NO, decider.canAllocate(test1Shard3, clusterState.getRoutingNodes().node("node1"), allocation).type());
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .build();  
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 1, null, null, false, ShardRoutingState.UNASSIGNED));
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 0, "node1", null, true, ShardRoutingState.STARTED));
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 1, null, null, true, ShardRoutingState.UNASSIGNED));  
        // Cannot allocate third primary to node1 (would exceed primary shard limit)
        // Set up routing table for test3  
            .build();
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();  
                                                                                                                              // test1 to  
        RoutingTable routingTable = routingTableBuilder.build();
        Metadata metadata = Metadata.builder()
                                                                                                                              // of test2 to
        // Existing primary can remain
import org.opensearch.cluster.node.DiscoveryNodeRole;  
}  
        test1Builder.addShard(TestShardRouting.newShardRouting("test1", 1, "node2", null, true, ShardRoutingState.STARTED));
            .metadata(metadata)
    private DiscoveryNode newNode(String nodeId) {
        // Cannot allocate second replica to node2 (would exceed total shard limit)
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);  
        Settings indexSettingsTest1 = Settings.builder()
            .put(IndexMetadata.builder("test2").settings(indexSettingsTest2).numberOfShards(3).numberOfReplicas(0))
        allocation.debugDecision(true);
import static org.opensearch.cluster.routing.allocation.decider.Decision.Type.YES;  
            .routingTable(routingTable)  
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 1)  // Set index-level limit to 1  
        assertEquals(NO, decider.canAllocate(shard3, clusterState.getRoutingNodes().node("node1"), allocation).type());
            .build();
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        // test1: Second primary on node2
import org.opensearch.common.settings.ClusterSettings;
        ShardRouting test1Shard1 = routingTable.index("test1").shard(1).primaryShard();
        // Create index settings for three indices  
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, false, ShardRoutingState.STARTED));
        assertEquals(NO, decider.canAllocate(test1Shard3, clusterState.getRoutingNodes().node("node2"), allocation).type());
            .build();
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 1, "node1", null, true, ShardRoutingState.STARTED));
        assertEquals(NO, decider.canAllocate(test2Replica2, clusterState.getRoutingNodes().node("node2"), allocation).type());
            .build();
        // Get shards for testing
            .build();
                                                                                                                              // of test2 to  
                                                                                                                              // shard of
import java.util.HashSet;
        ShardRouting shard1 = routingTable.index("test").shard(0).primaryShard();  
        test2Builder.addShard(TestShardRouting.newShardRouting("test2", 2, null, null, true, ShardRoutingState.UNASSIGNED));  
        routingTableBuilder.add(test2Builder.build());
        ShardRouting shard2 = routingTable.index("test").shard(1).primaryShard();
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        // Test allocation decisions  
        assertEquals(YES, decider.canAllocate(test2Shard2, clusterState.getRoutingNodes().node("node2"), allocation).type()); // Can assign
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 1, "node2", null, true, ShardRoutingState.STARTED));
        // Can allocate second replica to node1 (within total shard limit)
        assertEquals(NO, decider.canAllocate(test3Shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());  // Cannot
import java.util.Set;  
        Metadata metadata = Metadata.builder()  
        assertEquals(YES, decider.canAllocate(test1Shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());
        routingTableBuilder.add(test1Builder.build());  
                                                                                                                              // test3 to
        ShardRouting shard2 = routingTable.index("test").shard(1).primaryShard();
        // test2: First replica on node2
        RoutingTable routingTable = routingTableBuilder.build();
        // Get unassigned shards for testing  
            .metadata(metadata)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        // test2: First primary on node1
            .build();
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 1, null, null, true, ShardRoutingState.UNASSIGNED));
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);  
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);
            .build();
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(clusterSettings, clusterSettingsObject);
import static org.opensearch.cluster.routing.allocation.decider.Decision.Type.NO;
        Metadata metadata = Metadata.builder()  
        Settings indexSettingsTest3 = Settings.builder()  
        Metadata metadata = Metadata.builder()
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 1)
    }
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, true, ShardRoutingState.STARTED));
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2)
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());  
        allocation.debugDecision(true);
    public void testWithNoLimit() {
        allocation.debugDecision(true);
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(clusterSettings, clusterSettingsObject);
        ClusterSettings clusterSettingsObject = new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ShardRouting test1Shard2 = routingTable.index("test1").shard(2).primaryShard();
import org.opensearch.common.settings.Settings;  
            .build();
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(settings, clusterSettings);
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        IndexRoutingTable.Builder test1RoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test1").getIndex());
import org.opensearch.cluster.routing.allocation.RoutingAllocation;
        RoutingTable routingTable = routingTableBuilder.build();
                                                                                                                              // assign 3rd
        // test2: Second primary on node2
            .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 3)
            .metadata(metadata)
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(0))
            .put(IndexMetadata.builder("test3").settings(indexSettingsTest3).numberOfShards(3).numberOfReplicas(0))
        // Set up routing table for test1
        routingTableBuilder.add(test2RoutingTableBuilder.build());
        assertEquals(YES, decider.canAllocate(shard3, clusterState.getRoutingNodes().node("node1"), allocation).type());
            .put(IndexMetadata.builder("test").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(0))
import org.opensearch.cluster.routing.ShardRoutingState;
            .metadata(metadata)
        ShardRouting test2Shard2 = routingTable.index("test2").shard(2).primaryShard();
        // Test allocation decisions
        // Shard 0 and 1: STARTED on node1
        Settings clusterSettings = Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(YES, decider.canRemain(test1Shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        assertEquals(YES, decider.canRemain(test1Shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());
        routingTableBuilder.add(indexRoutingTableBuilder.build());  
    public void testClusterShardLimit() {
            .build();
        ClusterSettings clusterSettingsObject = new ClusterSettings(clusterSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import org.opensearch.cluster.routing.IndexRoutingTable;
                                                                                                                              // 3rd shard
        IndexRoutingTable.Builder test1RoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test1").getIndex());  
        assertEquals(YES, decider.canAllocate(test2Replica2, clusterState.getRoutingNodes().node("node1"), allocation).type());
                                                                                                                              // node2
    public void testIndexShardLimit() {  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        // test1: First primary on node1
        allocation.debugDecision(true);
    }
            .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), -1)
        // Cannot allocate third primary to node2 (would exceed primary shard limit)
            .routingTable(routingTable)
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));  
    public void testIndexPrimaryShardLimit() {
import org.opensearch.indices.replication.common.ReplicationType;
                                                                                                                              // shard of
            .put(IndexMetadata.builder("test2").settings(indexSettings).numberOfShards(3).numberOfReplicas(0))  
    }
        IndexRoutingTable.Builder indexRoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test").getIndex());  
import java.util.Collections;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        ShardRouting test2Replica2 = routingTable.index("test2").shard(1).replicaShards().get(0);
        assertEquals(NO, decider.canAllocate(test1Shard2, clusterState.getRoutingNodes().node("node1"), allocation).type());  // Cannot  
        // Setup routing for test2 (2 primaries, 1 replica)
        IndexRoutingTable.Builder test2RoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test2").getIndex());
 * compatible open source license.
        // test2: Second replica unassigned  
        // Test assertions
            .build();
        ShardRouting test1Shard2 = routingTable.index("test1").shard(2).primaryShard();
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(settings, clusterSettings);
        routingTableBuilder.add(test1RoutingTableBuilder.build());  
            .routingTable(routingTable)
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))
        ShardRouting test1Shard3 = routingTable.index("test1").shard(2).primaryShard();  
import org.opensearch.cluster.node.DiscoveryNodes;
        IndexRoutingTable.Builder test1Builder = IndexRoutingTable.builder(metadata.index("test1").getIndex());
        IndexRoutingTable.Builder test2Builder = IndexRoutingTable.builder(metadata.index("test2").getIndex());  
            .put(IndexMetadata.builder("test1").settings(settings(Version.CURRENT)).numberOfShards(3).numberOfReplicas(0))  
            .nodes(DiscoveryNodes.builder().add(newNode("node1")).add(newNode("node2")))  
        ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            .put(ShardsLimitAllocationDecider.INDEX_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)
import org.opensearch.Version;
import org.opensearch.cluster.routing.RoutingTable;  
import org.opensearch.test.OpenSearchTestCase;
        test3Builder.addShard(TestShardRouting.newShardRouting("test3", 0, "node1", null, true, ShardRoutingState.STARTED));
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertEquals(NO, decider.canAllocate(test2Shard2, clusterState.getRoutingNodes().node("node2"), allocation).type());  
        test3Builder.addShard(TestShardRouting.newShardRouting("test3", 2, null, null, true, ShardRoutingState.UNASSIGNED));
                                                                                                                              // assign 3rd  
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);  
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        // Create routing table
            .build();
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        test2Builder.addShard(TestShardRouting.newShardRouting("test2", 1, "node2", null, true, ShardRoutingState.STARTED));
package org.opensearch.cluster.routing.allocation.decider;
        Settings settings = Settings.builder().put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_SHARDS_PER_NODE_SETTING.getKey(), 2).build();
 * this file be licensed under the Apache-2.0 license or a
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        routingTableBuilder.add(test1RoutingTableBuilder.build());
        // Create a RoutingTable with shards 0 and 1 initialized on node1, and shard 2 unassigned
 *
        assertEquals(YES, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());  
    }
        Settings indexSettingsTest2 = Settings.builder()
        ShardsLimitAllocationDecider decider = new ShardsLimitAllocationDecider(settings, clusterSettings);
import org.opensearch.cluster.metadata.IndexMetadata;  
            .build();  
            .build();  
import org.opensearch.cluster.routing.TestShardRouting;  
    public void testClusterPrimaryShardLimit() {
        assertEquals(YES, decider.canRemain(test2Shard1, clusterState.getRoutingNodes().node("node2"), allocation).type());
        Settings settings = Settings.builder().build();
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 1, "node2", null, true, ShardRoutingState.STARTED));
        assertEquals(NO, decider.canAllocate(test1Shard2, clusterState.getRoutingNodes().node("node1"), allocation).type());  
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 0, "node1", null, true, ShardRoutingState.STARTED));  
        test2Builder.addShard(TestShardRouting.newShardRouting("test2", 0, "node1", null, true, ShardRoutingState.STARTED));
        Settings indexSettings = Settings.builder()
public class ShardsLimitAllocationDeciderTests extends OpenSearchTestCase {
                                                                                                                              // 3rd shard  
        Set<DiscoveryNodeRole> roles = new HashSet<>(Collections.singleton(DiscoveryNodeRole.DATA_ROLE));  
        // Create a RoutingTable with shards 0 and 1 initialized on node1, and shard 2 unassigned
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
        assertEquals(YES, decider.canAllocate(test2Shard2, clusterState.getRoutingNodes().node("node1"), allocation).type()); // Can assign
        // Shard 2: Unassigned  
        RoutingTable routingTable = routingTableBuilder.build();
        // Set up routing table for test1
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .put(ShardsLimitAllocationDecider.CLUSTER_TOTAL_PRIMARY_SHARDS_PER_NODE_SETTING.getKey(), 2)  
    }  
                                                                                                                              // node1
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        Metadata metadata = Metadata.builder()
            .build();
        assertEquals(YES, decider.canRemain(shard1, clusterState.getRoutingNodes().node("node1"), allocation).type());  
        routingTableBuilder.add(test3Builder.build());
import org.opensearch.cluster.node.DiscoveryNode;
        IndexRoutingTable.Builder test2RoutingTableBuilder = IndexRoutingTable.builder(metadata.index("test2").getIndex());
            .put(IndexMetadata.builder("test2").settings(settings(Version.CURRENT)).numberOfShards(2).numberOfReplicas(1))
        routingTableBuilder.add(indexRoutingTableBuilder.build());  
        // Set up routing table for test2  
        RoutingAllocation allocation = new RoutingAllocation(null, clusterState.getRoutingNodes(), clusterState, null, null, 0);  
        test3Builder.addShard(TestShardRouting.newShardRouting("test3", 1, "node2", null, true, ShardRoutingState.STARTED));  
import org.opensearch.cluster.ClusterState;
                                                                                                                              // node2  
        // Create metadata for two indices
        // Shard 2: Unassigned  
        test1Builder.addShard(TestShardRouting.newShardRouting("test1", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        test2RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test2", 0, "node2", null, true, ShardRoutingState.STARTED));
    }  
        routingTableBuilder.add(test2RoutingTableBuilder.build());
        test1RoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test1", 2, null, null, true, ShardRoutingState.UNASSIGNED));  
            .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), ReplicationType.SEGMENT.toString())
        ShardRouting test1Shard1 = routingTable.index("test1").shard(0).primaryShard();
            .routingTable(routingTable)
 */  
        // Test allocation decisions
        Settings settings = Settings.builder()
/*  
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 1, "node1", null, true, ShardRoutingState.STARTED));
        // Setup routing for test1 (3 primaries)
        // Test allocation decisions  
            .build();
        assertEquals(YES, decider.canAllocate(shard3, clusterState.getRoutingNodes().node("node2"), allocation).type());
            .put(IndexMetadata.builder("test1").settings(indexSettings).numberOfShards(3).numberOfReplicas(0))
 * The OpenSearch Contributors require contributions made to  
            .put(IndexMetadata.builder("test1").settings(indexSettingsTest1).numberOfShards(3).numberOfReplicas(0))  
        // Set up routing table for test2
                                                                                                                              // node1
        ShardRouting shard3 = routingTable.index("test").shard(2).primaryShard();
        ShardRouting test2Shard2 = routingTable.index("test2").shard(2).primaryShard();
            .metadata(metadata)
        indexRoutingTableBuilder.addShard(TestShardRouting.newShardRouting("test", 2, null, null, true, ShardRoutingState.UNASSIGNED));
        // Create index settings with INDEX_TOTAL_SHARDS_PER_NODE_SETTING and version
        allocation.debugDecision(true);
        // test1: Third primary unassigned
import org.opensearch.cluster.metadata.Metadata;
        Settings clusterSettings = Settings.builder()  
            .routingTable(routingTable)
import org.opensearch.cluster.routing.ShardRouting;
        ShardRouting test2Shard1 = routingTable.index("test2").shard(1).primaryShard();  
