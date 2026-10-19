        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).build();
            return cs;  
            .build();
            () -> applyRequest(state, newRequest("test-index", 0, 2))
        ClusterState updatedState = applyRequest(state, newRequest("test-index", 0, 2));
        assertEquals(2, splitMetadata.getChildShardIdsOfParent(0).size());  
    }
import java.util.HashSet;  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue(reason.contains("test-index"));
        Settings indexSettings = Settings.builder()
        expectThrows(ArithmeticException.class, () -> applyRequest(state, newRequest("test-index", 0, 0)));
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        nodesBuilder.add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.V_3_6_0));  
        );
            .addIndexShard(shardTable1.build())
        ClusterState finalState = state;
    public void testApplySplitShardRequestUpdatesMetadata() {
        ClusterState afterFirstSplit = applyRequest(state, newRequest("test-index", 0, 2));
        ClusterState finalState = state;
        // Build a routing table where shard 0 is relocating  
}
            .build();  
    public void testApplySplitShardRequestThrowsIfNodeBelowSplitVersion() {  
    // --- helpers ---  
            () -> applyRequest(state, newRequest("test-index", 0, 2))
        assertTrue(e.getMessage().contains("same version"));  
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).build())
        Settings indexSettings = Settings.builder()
        IndexShardRoutingTable.Builder shardTable1 = new IndexShardRoutingTable.Builder(new ShardId(index, 1)).addShard(  
        ClusterState state = createClusterState("test-index", 3, 0);
    }
package org.opensearch.cluster.metadata;
    public void testApplySplitShardRequestThrowsIfVirtualShardsEnabled() {
            .metadata(Metadata.builder().put(indexMetadata, false))
            () -> applyRequest(finalState, newRequest("test-index", 0, 2))
    private static InPlaceSplitShardClusterStateUpdateRequest newRequest(String index, int shardId, int splitInto) {  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    }
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).build();
        ClusterState state = createClusterState("test-index", 5, 0);
        childShards.forEach(s -> childIds.add(s.shardId()));  
    public void testApplySplitShardRequestThrowsIfAlreadyInProgress() {  
            .routingTable(RoutingTable.builder().add(indexRoutingBuilder).build())  
            () -> applyRequest(state, newRequest("test-index", 0, 2))
        ClusterState state = createClusterState("test-index", 3, 0);
            for (int r = 0; r < numReplicas; r++) {  
            TestShardRouting.newShardRouting(new ShardId(index, 2), "node1", true, ShardRoutingState.STARTED)
    public void testApplySplitShardRequestMultipleShardsIndependently() {
        ShardRouting relocatingShard = TestShardRouting.newShardRouting(
        ClusterState state = createClusterState("test-index", 3, 1);
    private ClusterState createClusterState(String indexName, int numShards, int numReplicas) {
        );
    }
            .build();  
    public void testApplySplitShardRequestThrowsForInvalidShardId() {
            IllegalArgumentException.class,  
            IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(new ShardId(index, i));
        expectThrows(Exception.class, () -> applyRequest(state, newRequest("test-index", 99, 2)));
            assertTrue(reason.contains("shard [1]"));
        );
        ClusterState state = createClusterState("test-index", 3, 1);
            .build();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            IllegalArgumentException.class,
            .build();  
        assertTrue(e.getMessage().contains(Version.V_3_7_0.toString()));  
        assertEquals(3, splitMetadata.getChildShardIdsOfParent(2).size());
        Metadata.Builder metaBuilder = Metadata.builder(state.metadata()).put(imBuilder);
            indexRoutingBuilder.addIndexShard(shardBuilder.build());
import org.opensearch.cluster.routing.IndexRoutingTable;
        long versionAfter = updatedState.metadata().index("test-index").getVersion();  
            new ShardId(index, 0),
        assertEquals(originalMetadata.getNumberOfReplicas(), updatedMetadata.getNumberOfReplicas());
    }
        assertTrue(rerouteCalled[0]);  
                shardBuilder.addShard(
        return new InPlaceSplitShardClusterStateUpdateRequest("test", index, shardId, splitInto);
        nodesBuilder.add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.V_3_5_0));  
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException e = expectThrows(
            () -> applyRequest(finalState, newRequest("test-index", 0, 2))
        IllegalArgumentException e = expectThrows(  
        assertTrue(splitMetadata.isSplitOfShardInProgress(2));  
import org.opensearch.core.index.shard.ShardId;  
        assertTrue(splitMetadata.isSplitOfShardInProgress(0));
            .routingTable(RoutingTable.builder().add(indexRoutingBuilder).build())
        InPlaceSplitShardClusterStateUpdateRequest request = newRequest("test-index", 1, 3);
            .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, 6)  
import org.opensearch.action.admin.indices.split.InPlaceSplitShardClusterStateUpdateRequest;
import org.opensearch.cluster.node.DiscoveryNode;
            () -> applyRequest(afterFirstSplit, newRequest("test-index", 0, 2))  
        }  
        });
            "node2",
        SplitShardsMetadata splitMetadata = updatedState.metadata().index("test-index").getSplitShardsMetadata();
import org.opensearch.cluster.routing.ShardRoutingState;
            .metadata(Metadata.builder().put(indexMetadata, false))  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    // --- applySplitShardRequest: success cases ---
        imBuilder.splitShardsMetadata(splitBuilder.build());
        ClusterState afterSplit1 = applyRequest(afterSplit0, newRequest("test-index", 1, 2));
        SplitShardsMetadata.Builder splitBuilder = new SplitShardsMetadata.Builder(indexMetadata.getSplitShardsMetadata());  
            ShardRoutingState.RELOCATING  
            .addIndexShard(shardTable2.build());
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
    public void testApplySplitShardRequestCallsReroute() {  
    private static ClusterState applyRequest(ClusterState state, InPlaceSplitShardClusterStateUpdateRequest request) {
            .build();
        nodesBuilder.add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.V_3_5_0));
    public void testApplySplitShardRequestBumpsVersion() {  
        IllegalArgumentException e = expectThrows(
        var childShards = splitBuilder.splitShard(0, 2);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
import org.opensearch.cluster.node.DiscoveryNodes;  
    }  
import org.opensearch.cluster.ClusterName;  
    }
        );
        state = ClusterState.builder(state).nodes(nodesBuilder).build();
        );
        assertEquals(2, splitMetadata.getChildShardIdsOfParent(0).size());
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).build())
    }  
        assertEquals(originalMetadata.getIndex(), updatedMetadata.getIndex());  
    }
                );  
            true,
        boolean[] rerouteCalled = { false };
import org.opensearch.Version;
            TestShardRouting.newShardRouting(new ShardId(index, 1), "node1", true, ShardRoutingState.STARTED)
import org.opensearch.cluster.routing.RoutingTable;  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            rerouteCalled[0] = true;  
        ClusterState state = createClusterState("test-index", 3, 0);
        assertTrue(e.getMessage().contains("primary shard is not started"));  
        state = ClusterState.builder(state).nodes(nodesBuilder).build();
        Set<Integer> allChildIds = new HashSet<>();
        ClusterState updatedState = applyRequest(state, newRequest("test-index", 0, 2));
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(originalMetadata.getNumberOfShards(), updatedMetadata.getNumberOfShards());
    }
            .metadata(Metadata.builder().put(indexMetadata, false))
        IndexMetadata updatedMetadata = updatedState.metadata().index("test-index");  
    }
        );  
        IndexMetadata indexMetadata = state.metadata().index("test-index");
            .build();
 *
    }
        nodesBuilder.add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.V_3_5_0));
/*  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)  
        splitBuilder.updateSplitMetadataForChildShards(0, childIds);
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
            .build();  
        Settings indexSettings = Settings.builder()
            IllegalArgumentException.class,
        );
        ClusterState state = createClusterState("test-index", 3, 1);  
        Settings indexSettings = Settings.builder()
        );  
    public void testApplySplitShardRequestThrowsForSplitIntoZero() {
    }
        IndexShardRoutingTable.Builder shardTable0 = new IndexShardRoutingTable.Builder(new ShardId(index, 0)).addShard(relocatingShard);
    }
import java.util.Set;
        allChildIds.addAll(splitMetadata.getChildShardIdsOfParent(0));
        IndexShardRoutingTable.Builder shardTable2 = new IndexShardRoutingTable.Builder(new ShardId(index, 2)).addShard(  
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        assertTrue(e.getMessage().contains("already in progress"));
        ClusterState stateWithCompletedSplit = ClusterState.builder(state).metadata(metaBuilder).build();  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.cluster.routing.TestShardRouting;  
            IllegalArgumentException.class,  
import org.opensearch.common.settings.Settings;
        ClusterState state = createClusterState("test-index", 3, 1);
            IllegalArgumentException.class,  
        ClusterState afterSplit0 = applyRequest(state, newRequest("test-index", 0, 2));
    }
        IndexMetadata originalMetadata = state.metadata().index("test-index");
                    TestShardRouting.newShardRouting(new ShardId(index, i), "node" + (r + 2), false, ShardRoutingState.STARTED)
        ClusterState state = createClusterState("test-index", 3, 0);
        IllegalArgumentException e = expectThrows(
public class MetadataInPlaceSplitShardServiceTests extends OpenSearchTestCase {  
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
        assertTrue(e.getMessage().contains("relocating"));
            shardBuilder.addShard(TestShardRouting.newShardRouting(new ShardId(index, i), "node1", true, ShardRoutingState.STARTED));
            () -> applyRequest(stateWithCompletedSplit, newRequest("test-index", 0, 2))
        );
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
    }
        IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(index);
 * The OpenSearch Contributors require contributions made to  
        assertTrue(e.getMessage().contains("already been split"));  
        assertEquals(5, allChildIds.size()); // 3 + 2, all unique
            .metadata(Metadata.builder().put(indexMetadata, false))
        ClusterState state = createClusterState("test-index", 3, 0);
        SplitShardsMetadata splitMetadata = afterSplit1.metadata().index("test-index").getSplitShardsMetadata();  
            () -> applyRequest(state, newRequest("non-existent-index", 0, 2))
            IllegalArgumentException.class,
        ClusterState state = createClusterState("test-index", 5, 0);
            }
 * compatible open source license.
    public void testApplySplitShardRequestThrowsInMixedVersionCluster() {  
        IllegalArgumentException e = expectThrows(
import org.opensearch.cluster.ClusterState;
 */  
            IllegalArgumentException.class,  
    }
        long versionBefore = state.metadata().index("test-index").getVersion();
        ClusterState updatedState = applyRequest(state, request);
    public void testApplySplitShardRequestChildShardIdsAreUnique() {  
    public void testApplySplitShardRequestThrowsForNonExistentIndex() {  
    public void testApplySplitShardRequestThrowsIfPrimaryNotStarted() {
        );
        ClusterState afterSplit0 = applyRequest(state, newRequest("test-index", 0, 3));  
        ClusterState afterSplit2 = applyRequest(afterSplit0, newRequest("test-index", 2, 3));
        assertTrue(e.getMessage().contains("virtual shards"));  
        IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(index).addIndexShard(shardTable0.build())  
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).build();  
        allChildIds.addAll(splitMetadata.getChildShardIdsOfParent(1));  
    public void testApplySplitShardRequestThrowsIfAlreadySplit() {
        SplitShardsMetadata splitMetadata = afterSplit2.metadata().index("test-index").getSplitShardsMetadata();
        ClusterState state = createClusterState("test-index", 3, 1);
    public void testApplySplitShardRequestThrowsIfShardIsRelocating() {  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
        Index index = indexMetadata.getIndex();  
            "node1",  
    }
        return MetadataInPlaceSplitShardService.applySplitShardRequest(state, request, (cs, reason) -> cs);  
            IllegalArgumentException.class,  
import org.opensearch.core.index.Index;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        InPlaceSplitShardClusterStateUpdateRequest request = newRequest("test-index", 0, 2);  
        for (int i = 0; i < numShards; i++) {  
        assertTrue(splitMetadata.isSplitOfShardInProgress(0));
    }
        ClusterState state = createClusterState("test-index", 3, 1);
        assertTrue(e.getMessage().contains("not found"));
        // addAsNew creates UNASSIGNED shards
        Set<Integer> childIds = new HashSet<>();
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
import org.opensearch.cluster.routing.ShardRouting;
        assertTrue(versionAfter > versionBefore);
    // --- applySplitShardRequest: error cases ---
        assertFalse(splitMetadata.isSplitOfShardInProgress(1));  
        IndexMetadata.Builder imBuilder = IndexMetadata.builder(indexMetadata);  
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        IllegalArgumentException e = expectThrows(
    public void testApplySplitShardRequestPreservesExistingMetadata() {  
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName).settings(indexSettings).build();
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        IllegalArgumentException e = expectThrows(
        MetadataInPlaceSplitShardService.applySplitShardRequest(state, request, (cs, reason) -> {
        Index index = indexMetadata.getIndex();
        IllegalArgumentException e = expectThrows(  
