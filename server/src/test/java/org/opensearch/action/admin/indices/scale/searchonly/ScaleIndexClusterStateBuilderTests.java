            .put(indexMetadata.getSettings())  
            true, // search only
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
    public void testBuildScaleUpRoutingTable() {  
        IndexRoutingTable indexRoutingTable = newRoutingTable.index(testIndex);
import org.opensearch.test.OpenSearchTestCase;  
 * The OpenSearch Contributors require contributions made to  
        Settings indexSettings = Settings.builder()
        assertEquals("Should have one blocked index", 1, blockedIndices.size());
        // Create search-only shard routing  
            .build();  
        builder = new ScaleIndexClusterStateBuilder();
import org.opensearch.indices.replication.common.ReplicationType;
        expectThrows(IllegalStateException.class, () -> builder.buildFinalScaleDownState(initialState, "nonexistent_index"));
import org.opensearch.cluster.routing.ShardRouting;  
import org.opensearch.core.index.Index;  
        IndexMetadata searchOnlyMetadata = IndexMetadata.builder(indexMetadata).settings(scaleUpSettings).build();
            .put(SETTING_NUMBER_OF_SEARCH_REPLICAS, 1)  // Add search replicas
        Settings scaleUpSettings = Settings.builder()
    }
        initialState = ClusterState.builder(ClusterState.EMPTY_STATE)  
        // Verify blocked indices map was updated  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "test")  
        Metadata metadata = Metadata.builder().put(indexMetadata, true).build();
            .metadata(metadata)
        RoutingTable newRoutingTable = builder.buildScaleUpRoutingTable(searchOnlyState, testIndex);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        long replicaCount = indexRoutingTable.shardsWithState(UNASSIGNED)
        assertEquals("Should preserve search replicas", indexMetadata.getNumberOfSearchOnlyReplicas(), searchReplicaCount);  
import org.opensearch.common.settings.Settings;
package org.opensearch.action.admin.indices.scale.searchonly;
        // Verify regular replicas were added (excluding search replicas)  
        boolean hasPrimary = indexRoutingTable.shardsWithState(UNASSIGNED).stream().anyMatch(ShardRouting::primary);  
    }
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
        // Build routing table with search-only shard  
        // Prepare a proper search-only state
 */  
    }
        ClusterState searchOnlyState = ClusterState.builder(initialState)
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
import org.opensearch.Version;
 *
import org.opensearch.cluster.routing.RoutingTable;
        indexMetadata = IndexMetadata.builder(testIndex).settings(indexSettings).build();
import static org.opensearch.cluster.routing.ShardRoutingState.UNASSIGNED;
            searchOnlyShard
            .routingTable(RoutingTable.builder().add(routingTableBuilder.build()).build())
        // Verify metadata was updated
        );
        // Execute scale down state build  
            .stream()
            .build();
        // Verify search replicas were preserved
    public void testBuildFinalScaleDownState() {  
    public void setUp() throws Exception {
            .put(SETTING_INDEX_UUID, randomAlphaOfLength(8))
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        ShardRouting searchOnlyShard = ShardRouting.newUnassigned(
            .routingTable(RoutingTable.builder().addAsNew(indexMetadata).build())
import org.opensearch.cluster.routing.UnassignedInfo;
            .metadata(Metadata.builder(initialState.metadata()).put(searchOnlyMetadata, true))  
import org.opensearch.cluster.routing.IndexRoutingTable;  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.block.ClusterBlock;  
            .put(INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
    public void testBuildFinalScaleDownStateWithInvalidIndex() {  
            "Index should be marked as search-only",
    private ScaleIndexClusterStateBuilder builder;
    }
            .build();
import org.opensearch.core.index.shard.ShardId;
            RecoverySource.EmptyStoreRecoverySource.INSTANCE,
            .filter(shard -> !shard.primary() && !shard.isSearchOnly())  
        assertTrue("Should have an unassigned primary shard", hasPrimary);
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  // Enable segment replication
    private String testIndex;
    public void testBuildScaleDownState() {  
import java.util.Map;  
        Map<Index, ClusterBlock> blockedIndices = new HashMap<>();
        // Create initial cluster state with routing table  
        ClusterState finalState = builder.buildFinalScaleDownState(stateWithBlock, testIndex);
        assertFalse("Blocked indices map should not be empty", blockedIndices.isEmpty());
        assertNotNull("Index routing table should exist", indexRoutingTable);  
            new ShardId(searchOnlyMetadata.getIndex(), 0),
    private IndexMetadata indexMetadata;
        );  
            updatedMetadata.getSettings().getAsBoolean(INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), false)
            .put(SETTING_VERSION_CREATED, Version.CURRENT)  
import org.opensearch.cluster.metadata.Metadata;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;  
import org.opensearch.cluster.ClusterState;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SEARCH_REPLICAS;
        ClusterState stateWithBlock = builder.buildScaleDownState(initialState, testIndex, blockedIndices);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    private ClusterState initialState;  
}  
        // Execute scale up
        super.setUp();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REMOTE_STORE_ENABLED;
        );  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK;  
            "Temporary block should be removed",
            finalState.blocks().hasIndexBlock(testIndex, blockedIndices.get(indexMetadata.getIndex()))  
import org.opensearch.cluster.routing.RecoverySource;
        // Verify block was added  
        assertEquals("Should have correct number of replica shards", indexMetadata.getNumberOfReplicas(), replicaCount);
        IndexMetadata updatedMetadata = finalState.metadata().index(testIndex);
import java.util.HashMap;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;  
        assertTrue("Search-only block should be present", finalState.blocks().hasIndexBlock(testIndex, INDEX_SEARCH_ONLY_BLOCK));
        // Verify blocks  
        testIndex = "test_index";
 * compatible open source license.
        // Verify routing table
    }
        assertTrue("Index should be in blocked indices map", blockedIndices.containsKey(indexMetadata.getIndex()));  
            .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            false,  // not primary  
        ClusterState newState = builder.buildScaleDownState(initialState, testIndex, blockedIndices);
        // Verify primary shard was added
        assertTrue(  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK_ID;
            .put(SETTING_NUMBER_OF_REPLICAS, 1)  
            .count();
        );
public class ScaleIndexClusterStateBuilderTests extends OpenSearchTestCase {  
    @Override
        long searchReplicaCount = indexRoutingTable.shardsWithState(UNASSIGNED).stream().filter(ShardRouting::isSearchOnly).count();
/*  
        assertTrue("Scale down block should be present", newState.blocks().hasIndexBlockWithId(testIndex, INDEX_SEARCH_ONLY_BLOCK_ID));
            .put(SETTING_REMOTE_STORE_ENABLED, true)  // Enable remote store  
        IndexRoutingTable.Builder routingTableBuilder = new IndexRoutingTable.Builder(searchOnlyMetadata.getIndex()).addShard(
        assertFalse(
            .build();
        // Create basic index metadata with segment replication enabled
