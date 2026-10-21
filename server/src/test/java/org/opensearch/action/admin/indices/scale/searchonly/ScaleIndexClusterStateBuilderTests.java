import java.util.Map;
        boolean hasPrimary = indexRoutingTable.shardsWithState(UNASSIGNED).stream().anyMatch(ShardRouting::primary);
        assertNotNull("Index routing table should exist", indexRoutingTable);
        assertTrue("Search-only block should be present", finalState.blocks().hasIndexBlock(testIndex, INDEX_SEARCH_ONLY_BLOCK));
        long replicaCount = indexRoutingTable.shardsWithState(UNASSIGNED)
        assertTrue("Should have an unassigned primary shard", hasPrimary);
import org.opensearch.indices.replication.common.ReplicationType;
    public void testBuildFinalScaleDownStateWithInvalidIndex() {
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
        Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
            updatedMetadata.getSettings().getAsBoolean(INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
        // Verify search replicas were preserved
        IndexRoutingTable.Builder routingTableBuilder = new IndexRoutingTable.Builder(searchOnlyMetadata.getIndex()).addShard(
}
 * The OpenSearch Contributors require contributions made to
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  // Add search replicas
            .put(SETTING_CREATION_DATE, System.currentTimeMillis())
        // Verify blocks
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
public class ScaleIndexClusterStateBuilderTests extends OpenSearchTestCase {
            .filter(shard -> !shard.primary() && !shard.isSearchOnly())
    private ClusterState initialState;
            .put(indexMetadata.getSettings())
import org.opensearch.cluster.routing.ShardRouting;
    }
            false,  // not primary
import org.opensearch.cluster.metadata.Metadata;
        Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
/*
        );
    @Override
        assertTrue(
import java.util.HashMap;
import org.opensearch.cluster.routing.IndexRoutingTable;
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.cluster.ClusterState;
    public void testBuildScaleUpRoutingTable() {
        long searchReplicaCount = indexRoutingTable.shardsWithState(UNASSIGNED).stream().filter(ShardRouting::isSearchOnly).count();
import org.opensearch.core.index.Index;
        assertEquals("Should have correct number of replica shards", indexMetadata.getNumberOfReplicas(), replicaCount);
    private IndexMetadata indexMetadata;
 *
import org.opensearch.test.OpenSearchTestCase;
            .metadata(metadata)
            .build();
 */
        assertEquals("Should have one blocked index", 1, blockedIndices.size());
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            .put(INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
        // Execute scale up
import org.opensearch.cluster.routing.UnassignedInfo;
    public void testBuildScaleDownState() {
        ClusterState newState = builder.buildScaleDownState(initialState, testIndex, blockedIndices);
import org.opensearch.cluster.block.ClusterBlock;
            .count();
        Settings indexSettings = Settings.builder()
package org.opensearch.action.admin.indices.scale.searchonly;
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  // Enable segment replication
        initialState = ClusterState.builder(ClusterState.EMPTY_STATE)
        // Create basic index metadata with segment replication enabled
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
        builder = new ScaleIndexClusterStateBuilder();
import org.opensearch.cluster.routing.RoutingTable;
            .stream()
            .build();
import org.opensearch.Version;
            RecoverySource.EmptyStoreRecoverySource.INSTANCE,
        IndexRoutingTable indexRoutingTable = newRoutingTable.index(testIndex);
        // Verify blocked indices map was updated
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        // Verify primary shard was added
    }
        super.setUp();
        // Prepare a proper search-only state
        // Create initial cluster state with routing table
        IndexMetadata searchOnlyMetadata = IndexMetadata.builder(indexMetadata).settings(scaleUpSettings).build();
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        );
        RoutingTable newRoutingTable = builder.buildScaleUpRoutingTable(searchOnlyState, testIndex);
            .build();
        Settings scaleUpSettings = Settings.builder()
import org.opensearch.core.index.shard.ShardId;
        assertFalse(
        indexMetadata = IndexMetadata.builder(testIndex).settings(indexSettings).build();
        // Create search-only shard routing
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).build())
        Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK;
            .metadata(Metadata.builder(initialState.metadata()).put(searchOnlyMetadata, true))
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING;
    }
        );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
            .routingTable(RoutingTable.builder().add(routingTableBuilder.build()).build())
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK_ID;
            finalState.blocks().hasIndexBlock(testIndex, blockedIndices.get(indexMetadata.getIndex()))
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
            true, // search only
            "Index should be marked as search-only",
        );
 * compatible open source license.
        expectThrows(IllegalStateException.class, () -> builder.buildFinalScaleDownState(initialState, "nonexistent_index"));
        assertEquals("Should preserve search replicas", indexMetadata.getNumberOfSearchOnlyReplicas(), searchReplicaCount);
            .put(SETTING_NUMBER_OF_SHARDS, 1)
            new ShardId(searchOnlyMetadata.getIndex(), 0),
        // Build routing table with search-only shard
        ClusterState finalState = builder.buildFinalScaleDownState(stateWithBlock, testIndex);
import org.opensearch.cluster.routing.RecoverySource;
import org.opensearch.common.settings.Settings;
            .build();
        ClusterState searchOnlyState = ClusterState.builder(initialState)
    }
            .put(SETTING_REMOTE_STORE_ENABLED, true)  // Enable remote store
        // Execute scale down state build
        IndexMetadata updatedMetadata = finalState.metadata().index(testIndex);
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")
        // Verify regular replicas were added (excluding search replicas)
        testIndex = "test_index";
    public void setUp() throws Exception {
            "Temporary block should be removed",
    public void testBuildFinalScaleDownState() {
        ShardRouting searchOnlyShard = ShardRouting.newUnassigned(
    private ScaleIndexClusterStateBuilder builder;
            searchOnlyShard
        // Verify metadata was updated
        assertFalse("Blocked indices map should not be empty", blockedIndices.isEmpty());
 * SPDX-License-Identifier: Apache-2.0
        // Verify routing table
        assertTrue("Index should be in blocked indices map", blockedIndices.containsKey(indexMetadata.getIndex()));
        ClusterState stateWithBlock = builder.buildScaleDownState(initialState, testIndex, blockedIndices);
        // Verify block was added
        assertTrue("Scale down block should be present", newState.blocks().hasIndexBlockWithId(testIndex, INDEX_SEARCH_ONLY_BLOCK_ID));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            .put(SETTING_INDEX_UUID, randomAlphaOfLength(8))
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
    private String testIndex;
