        SplitShardsMetadata splitMetadata = afterSplit1.metadata().index("test-index").getSplitShardsMetadata();
        long versionAfter = updatedState.metadata().index("test-index").getVersion();
    public void testApplySplitShardRequestPreservesExistingMetadata() {
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
    }
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException.class,
    public void testApplySplitShardRequestThrowsIfNodeBelowSplitVersion() {
            .put(IndexMetadata.SETTING_NUMBER_OF_VIRTUAL_SHARDS, 6)
        );
        long versionBefore = state.metadata().index("test-index").getVersion();
import org.opensearch.cluster.ClusterState;
    }
        Set<Integer> childIds = new HashSet<>();
        nodesBuilder.add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.V_3_6_0));
            shardBuilder.addShard(TestShardRouting.newShardRouting(new ShardId(index, i), "node1", true, ShardRoutingState.STARTED));
        IllegalArgumentException e = expectThrows(
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
        }
                );
    }
        ClusterState afterFirstSplit = applyRequest(state, newRequest("test-index", 0, 2));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(index).addIndexShard(shardTable0.build())
        ClusterState state = createClusterState("test-index", 3, 1);
 *
        ClusterState state = createClusterState("test-index", 3, 1);
        IllegalArgumentException e = expectThrows(
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            IllegalArgumentException.class,
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            TestShardRouting.newShardRouting(new ShardId(index, 2), "node1", true, ShardRoutingState.STARTED)
    }
    }
    public void testApplySplitShardRequestBumpsVersion() {
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        nodesBuilder.add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.V_3_5_0));
        ClusterState afterSplit0 = applyRequest(state, newRequest("test-index", 0, 2));
            () -> applyRequest(state, newRequest("test-index", 0, 2))
        ClusterState stateWithCompletedSplit = ClusterState.builder(state).metadata(metaBuilder).build();
        IndexMetadata originalMetadata = state.metadata().index("test-index");
            .metadata(Metadata.builder().put(indexMetadata, false))
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).build())
    public void testApplySplitShardRequestThrowsIfAlreadySplit() {
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, numReplicas)
        Set<Integer> allChildIds = new HashSet<>();
            "node2",
            "node1",
 * SPDX-License-Identifier: Apache-2.0
                shardBuilder.addShard(
        return ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        );
        IllegalArgumentException e = expectThrows(
            () -> applyRequest(state, newRequest("test-index", 0, 2))
    public void testApplySplitShardRequestThrowsIfPrimaryNotStarted() {
 * The OpenSearch Contributors require contributions made to
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).build();
        assertTrue(e.getMessage().contains("relocating"));
            .build();
        SplitShardsMetadata.Builder splitBuilder = new SplitShardsMetadata.Builder(indexMetadata.getSplitShardsMetadata());
    // --- helpers ---
        assertTrue(rerouteCalled[0]);
            IllegalArgumentException.class,
        assertEquals(originalMetadata.getIndex(), updatedMetadata.getIndex());
        assertEquals(2, splitMetadata.getChildShardIdsOfParent(0).size());
import java.util.Set;
import org.opensearch.cluster.node.DiscoveryNodes;
        ClusterState state = createClusterState("test-index", 3, 0);
        });
        );
        assertEquals(originalMetadata.getNumberOfShards(), updatedMetadata.getNumberOfShards());
        ClusterState state = createClusterState("test-index", 5, 0);
        ClusterState state = createClusterState("test-index", 3, 1);
        childShards.forEach(s -> childIds.add(s.shardId()));
            () -> applyRequest(state, newRequest("test-index", 0, 2))
    public void testApplySplitShardRequestCallsReroute() {
        );
    }
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    public void testApplySplitShardRequestMultipleShardsIndependently() {
        imBuilder.splitShardsMetadata(splitBuilder.build());
 */
    }
import org.opensearch.cluster.routing.IndexRoutingTable;
        IndexMetadata indexMetadata = IndexMetadata.builder(indexName).settings(indexSettings).build();
            .metadata(Metadata.builder().put(indexMetadata, false))
import java.util.HashSet;
        Metadata.Builder metaBuilder = Metadata.builder(state.metadata()).put(imBuilder);
    public void testApplySplitShardRequestUpdatesMetadata() {
                    TestShardRouting.newShardRouting(new ShardId(index, i), "node" + (r + 2), false, ShardRoutingState.STARTED)
        IndexMetadata updatedMetadata = updatedState.metadata().index("test-index");
            assertTrue(reason.contains("shard [1]"));
        ClusterState afterSplit1 = applyRequest(afterSplit0, newRequest("test-index", 1, 2));
            rerouteCalled[0] = true;
        ClusterState updatedState = applyRequest(state, newRequest("test-index", 0, 2));
        ClusterState state = createClusterState("test-index", 5, 0);
        ClusterState state = createClusterState("test-index", 3, 0);
    public void testApplySplitShardRequestThrowsForSplitIntoZero() {
        IndexMetadata indexMetadata = state.metadata().index("test-index");
            .build();
            indexRoutingBuilder.addIndexShard(shardBuilder.build());
        IllegalArgumentException e = expectThrows(
        ClusterState afterSplit2 = applyRequest(afterSplit0, newRequest("test-index", 2, 3));
        );
        SplitShardsMetadata splitMetadata = afterSplit2.metadata().index("test-index").getSplitShardsMetadata();
        Index index = indexMetadata.getIndex();
        ClusterState finalState = state;
        for (int i = 0; i < numShards; i++) {
            IllegalArgumentException.class,
        Index index = indexMetadata.getIndex();
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, numShards)
            .metadata(Metadata.builder().put(indexMetadata, false))
        assertEquals(5, allChildIds.size()); // 3 + 2, all unique
        assertEquals(3, splitMetadata.getChildShardIdsOfParent(2).size());
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        Settings indexSettings = Settings.builder()
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).build())
            .build();
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
    public void testApplySplitShardRequestChildShardIdsAreUnique() {
        splitBuilder.updateSplitMetadataForChildShards(0, childIds);
        ClusterState state = createClusterState("test-index", 3, 0);
            () -> applyRequest(finalState, newRequest("test-index", 0, 2))
        // Build a routing table where shard 0 is relocating
        assertTrue(e.getMessage().contains("already been split"));
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.ClusterName;
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder();
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
import org.opensearch.cluster.routing.TestShardRouting;
package org.opensearch.cluster.metadata;
public class MetadataInPlaceSplitShardServiceTests extends OpenSearchTestCase {
        ClusterState state = createClusterState("test-index", 3, 0);
    }
        assertEquals(2, splitMetadata.getChildShardIdsOfParent(0).size());
        ClusterState state = createClusterState("test-index", 3, 1);
        assertTrue(splitMetadata.isSplitOfShardInProgress(0));
        IndexShardRoutingTable.Builder shardTable1 = new IndexShardRoutingTable.Builder(new ShardId(index, 1)).addShard(
        assertEquals(originalMetadata.getNumberOfReplicas(), updatedMetadata.getNumberOfReplicas());
            assertTrue(reason.contains("test-index"));
    public void testApplySplitShardRequestThrowsForNonExistentIndex() {
        ClusterState afterSplit0 = applyRequest(state, newRequest("test-index", 0, 3));
            .metadata(Metadata.builder().put(indexMetadata, false))
        allChildIds.addAll(splitMetadata.getChildShardIdsOfParent(1));
            () -> applyRequest(finalState, newRequest("test-index", 0, 2))
    public void testApplySplitShardRequestThrowsInMixedVersionCluster() {
            .build();
        assertTrue(e.getMessage().contains(Version.V_3_7_0.toString()));
            true,
        allChildIds.addAll(splitMetadata.getChildShardIdsOfParent(0));
            TestShardRouting.newShardRouting(new ShardId(index, 1), "node1", true, ShardRoutingState.STARTED)
            for (int r = 0; r < numReplicas; r++) {
        Settings indexSettings = Settings.builder()
        ClusterState finalState = state;
 * compatible open source license.
        ClusterState state = createClusterState("test-index", 3, 0);
/*
        boolean[] rerouteCalled = { false };
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).build();
        Settings indexSettings = Settings.builder()
            () -> applyRequest(stateWithCompletedSplit, newRequest("test-index", 0, 2))
        state = ClusterState.builder(state).nodes(nodesBuilder).build();
        assertTrue(e.getMessage().contains("virtual shards"));
            IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(new ShardId(index, i));
        assertTrue(splitMetadata.isSplitOfShardInProgress(0));
        Settings indexSettings = Settings.builder()
import org.opensearch.core.index.Index;
        IllegalArgumentException e = expectThrows(
            .routingTable(RoutingTable.builder().add(indexRoutingBuilder).build())
        assertTrue(e.getMessage().contains("already in progress"));
        assertTrue(splitMetadata.isSplitOfShardInProgress(2));
        InPlaceSplitShardClusterStateUpdateRequest request = newRequest("test-index", 0, 2);
    // --- applySplitShardRequest: success cases ---
        assertTrue(e.getMessage().contains("same version"));
            return cs;
            IllegalArgumentException.class,
    }
            .addIndexShard(shardTable1.build())
    public void testApplySplitShardRequestThrowsIfAlreadyInProgress() {
            new ShardId(index, 0),
        ClusterState state = ClusterState.builder(ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
    // --- applySplitShardRequest: error cases ---
import org.opensearch.common.settings.Settings;
        return MetadataInPlaceSplitShardService.applySplitShardRequest(state, request, (cs, reason) -> cs);
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 3)
        MetadataInPlaceSplitShardService.applySplitShardRequest(state, request, (cs, reason) -> {
        ClusterState state = createClusterState("test-index", 3, 1);
            .build();
            () -> applyRequest(afterFirstSplit, newRequest("test-index", 0, 2))
        IllegalArgumentException e = expectThrows(
        );
import org.opensearch.action.admin.indices.split.InPlaceSplitShardClusterStateUpdateRequest;
            .routingTable(RoutingTable.builder().add(indexRoutingBuilder).build())
    private ClusterState createClusterState(String indexName, int numShards, int numReplicas) {
    }
    }
            IllegalArgumentException.class,
        ClusterState updatedState = applyRequest(state, request);
import org.opensearch.cluster.routing.RoutingTable;
            ShardRoutingState.RELOCATING
        ClusterState updatedState = applyRequest(state, newRequest("test-index", 0, 2));
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        expectThrows(Exception.class, () -> applyRequest(state, newRequest("test-index", 99, 2)));
        SplitShardsMetadata splitMetadata = updatedState.metadata().index("test-index").getSplitShardsMetadata();
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        );
    }
    }
    }
        assertFalse(splitMetadata.isSplitOfShardInProgress(1));
        IllegalArgumentException e = expectThrows(
            IllegalArgumentException.class,
    }
    }
        );
        var childShards = splitBuilder.splitShard(0, 2);
}
        IndexShardRoutingTable.Builder shardTable2 = new IndexShardRoutingTable.Builder(new ShardId(index, 2)).addShard(
        );
        assertTrue(versionAfter > versionBefore);
        nodesBuilder.add(new DiscoveryNode("node2", buildNewFakeTransportAddress(), Version.V_3_5_0));
            .build();
        return new InPlaceSplitShardClusterStateUpdateRequest("test", index, shardId, splitInto);
import org.opensearch.core.index.shard.ShardId;
        );
        assertTrue(e.getMessage().contains("primary shard is not started"));
        ShardRouting relocatingShard = TestShardRouting.newShardRouting(
            .build();
        InPlaceSplitShardClusterStateUpdateRequest request = newRequest("test-index", 1, 3);
        expectThrows(ArithmeticException.class, () -> applyRequest(state, newRequest("test-index", 0, 0)));
        IllegalArgumentException e = expectThrows(
import org.opensearch.cluster.routing.ShardRoutingState;
        IndexRoutingTable.Builder indexRoutingBuilder = new IndexRoutingTable.Builder(index);
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(indexSettings).build();
    public void testApplySplitShardRequestThrowsIfShardIsRelocating() {
        state = ClusterState.builder(state).nodes(nodesBuilder).build();
        // addAsNew creates UNASSIGNED shards
        );
            }
        IndexShardRoutingTable.Builder shardTable0 = new IndexShardRoutingTable.Builder(new ShardId(index, 0)).addShard(relocatingShard);
    public void testApplySplitShardRequestThrowsForInvalidShardId() {
    public void testApplySplitShardRequestThrowsIfVirtualShardsEnabled() {
import org.opensearch.Version;
        ClusterState state = createClusterState("test-index", 3, 1);
            .build();
            .addIndexShard(shardTable2.build());
    private static ClusterState applyRequest(ClusterState state, InPlaceSplitShardClusterStateUpdateRequest request) {
import org.opensearch.test.OpenSearchTestCase;
            () -> applyRequest(state, newRequest("non-existent-index", 0, 2))
        IndexMetadata.Builder imBuilder = IndexMetadata.builder(indexMetadata);
        assertTrue(e.getMessage().contains("not found"));
import org.opensearch.cluster.node.DiscoveryNode;
    private static InPlaceSplitShardClusterStateUpdateRequest newRequest(String index, int shardId, int splitInto) {
        nodesBuilder.add(new DiscoveryNode("node1", buildNewFakeTransportAddress(), Version.V_3_5_0));
    }
            IllegalArgumentException.class,
