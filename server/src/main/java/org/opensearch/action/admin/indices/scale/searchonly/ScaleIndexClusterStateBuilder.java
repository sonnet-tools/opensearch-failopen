     * @param currentState        the current cluster state
        );  
     * @param routingTableBuilder the routing table builder to modify
import org.opensearch.cluster.routing.IndexRoutingTable;
        IndexMetadata indexMetadata = currentState.metadata().index(index);
     *
        if (indexMetadata == null) {
 * This builder constructs cluster states for both scale-up and scale-down operations, handling  
            .put(indexMetadata.getSettings())  
                }  
import org.opensearch.cluster.metadata.Metadata;  
 *
     * Builds a shard routing table for a scale-up operation.  
                false,  
import org.opensearch.repositories.IndexId;
     * Builds the final cluster state for completing a scale-down operation.
            RestStatus.FORBIDDEN,
import org.opensearch.core.rest.RestStatus;
     * <ul>
    /**
     *   <li>Uses a unique ID to track the block through the scaling process</li>
import org.opensearch.cluster.routing.RoutingTable;
            new IndexId(shardTable.shardId().getIndex().getName(), shardTable.shardId().getIndex().getUUID())
 *   <li>Updating index metadata and settings when finalizing scale operations</li>
        RecoverySource.RemoteStoreRecoverySource remoteStoreRecoverySource = new RecoverySource.RemoteStoreRecoverySource(
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK_ID;
     * This method:
 * <ul>
                shardBuilder.addShard(shardRouting);
     * <ul>
                IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(shardTable.shardId());
 *   <li>Adding temporary write blocks during scale-down preparation</li>  
        );  
     *  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
            false,  
                shardTable.shardId(),
        ShardRouting primaryShard = ShardRouting.newUnassigned(  
                indexBuilder.addIndexShard(buildShardTableForScaleUp(shardTable, indexMetadata));  
     * Updates the routing table for a scale-down operation, removing non-search-only shards.
     * This state modification:
        if (indexRoutingTable != null) {
     *   <li>Creates new unassigned primary shards with remote store recovery source</li>
     * @param currentState   the current cluster state
     * <p>  
import org.opensearch.core.index.Index;  
            throw new IllegalStateException("Index " + index + " not found");  
            UUIDs.randomBase64UUID(),
        int numberOfReplicas = indexMetadata.getNumberOfReplicas();  
        // Create the correct number of replica shards
     * This block:
     */
            false,
     * @return the modified cluster state with finalized search-only configuration
    }  
            "index preparing to scale down",  
     * Builds the new cluster state by adding a temporary scale-down block on the target index.
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
     * The resulting routing table allows the cluster allocator to restore normal index operation
     *
 * The cluster state modifications ensure proper synchronization of operations and maintain
     * </ul>
     * </ul>
        metadataBuilder.put(
    }
import static org.opensearch.cluster.block.ClusterBlockLevel.WRITE;
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
     * @param currentState the current cluster state
     * @param blockedIndices map to store the association between indices and their scale blocks  
                RecoverySource.PeerRecoverySource.INSTANCE,
                indexBuilder.addIndexShard(shardBuilder.build());
import org.opensearch.cluster.metadata.IndexMetadata;
                    if (shardRouting.isSearchOnly()) {  
import java.util.EnumSet;
            IndexRoutingTable.Builder indexBuilder = new IndexRoutingTable.Builder(indexRoutingTable.getIndex());
 * <p>
        shardBuilder.addShard(primaryShard);  
        return ClusterState.builder(currentState)  
}
 */
import org.opensearch.cluster.ClusterState;
     * <p>
     * @return the modified cluster state with temporary write blocks applied
     */
     * <ul>
     */
    ClusterState buildScaleDownState(ClusterState currentState, String index, Map<Index, ClusterBlock> blockedIndices) {  
            EnumSet.of(WRITE)
     * Creates a temporary cluster block used during scale-down preparation.
            Version.CURRENT,
     *   <li>Preserves existing search-only replicas</li>  
            .metadata(metadataBuilder)
     * This temporary block prevents writes to the index during the preparation phase of scaling down,
            IndexMetadata.builder(indexMetadata).settings(updatedSettings).settingsVersion(indexMetadata.getSettingsVersion() + 1)
     *   <li>Creates new unassigned replica shards configured for peer recovery</li>
import org.opensearch.cluster.routing.ShardRouting;
     * <p>  
    }
    /**
            .build();
        IndexRoutingTable indexRoutingTable = currentState.routingTable().index(index);
        return routingTableBuilder.build();
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK;  
        blocksBuilder.removeIndexBlockWithId(index, INDEX_SEARCH_ONLY_BLOCK_ID);  
 * the transition of indices between normal operation and search-only mode. It manages:
     *   <li>Returns a 403 Forbidden status for write attempts</li>
        }
 * data integrity throughout the scaling process.  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());  
import org.opensearch.cluster.routing.UnassignedInfo;  
     * @return the modified routing table with newly added primary and replica shards
            UUID.randomUUID().toString(),  
 * SPDX-License-Identifier: Apache-2.0
    static ClusterBlock createScaleDownBlock() {
     * This method preserves only the search-only replica shards in the routing table,
     * @param currentState the current cluster state  
        }  
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());
        return shardBuilder.build();
        updateRoutingTableForScaleDown(routingTableBuilder, currentState, index);
        );  
     * </ul>  
        blocksBuilder.addIndexBlock(index, scaleBlock);  
            INDEX_SEARCH_ONLY_BLOCK_ID,
    RoutingTable buildScaleUpRoutingTable(ClusterState currentState, String index) {  
            }
     *   <li>Creates a new unassigned replica shard configured to recover from peers</li>  
 */  
        // Get replica settings from index metadata
     * effectively removing primary shards and standard replicas from the allocation.
        }  
            if (shardRouting.isSearchOnly()) {  
            routingTableBuilder.add(indexBuilder.build());  
        return ClusterState.builder(currentState)  
            .build();
     *   <li>Updates the routing table to maintain only search replicas</li>  
import java.util.UUID;  
            .blocks(blocksBuilder)
     * @return a new shard routing table with both search replicas and newly added shards
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());  
     *  
     * <ul>  
        }
    }
    }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            ShardRouting replicaShard = ShardRouting.newUnassigned(
     * @param index        the name of the index being scaled down
                for (ShardRouting shardRouting : shardTable) {
        blocksBuilder.addIndexBlock(index, INDEX_SEARCH_ONLY_BLOCK);
package org.opensearch.action.admin.indices.scale.searchonly;
    ClusterState buildFinalScaleDownState(ClusterState currentState, String index) {
        IndexRoutingTable indexRoutingTable = currentState.routingTable().index(index);  
     * @throws IllegalStateException if the specified index is not found  
    /**
     *   <li>Prevents write operations to the index</li>  
        blockedIndices.put(idx, scaleBlock);
        for (int i = 0; i < numberOfReplicas; i++) {  
     *   <li>Preserves all existing search-only replicas</li>
            shardTable.shardId(),
            routingTableBuilder.add(indexBuilder.build());
     * @param index        the name of the index being scaled up  
            shardBuilder.addShard(replicaShard);
        Index idx = indexMetadata.getIndex();  
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
        if (indexRoutingTable != null && indexMetadata != null) {
 * compatible open source license.
            );  
import org.opensearch.cluster.block.ClusterBlock;  
     *   <li>Includes a descriptive message</li>  
     * @param index          the name of the index being scaled down
    /**
import org.opensearch.cluster.routing.RecoverySource;  
        // Create primary shard
            remoteStoreRecoverySource,  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
     */
     *
     *
            for (IndexShardRoutingTable shardTable : indexRoutingTable) {  
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "Restoring primary shard")
    private void updateRoutingTableForScaleDown(RoutingTable.Builder routingTableBuilder, ClusterState currentState, String index) {
/**  
import org.opensearch.common.UUIDs;
    /**
                        shardBuilder.addShard(shardRouting);
        for (ShardRouting shardRouting : shardTable) {
            .blocks(blocksBuilder)
     */
     * @param shardTable the current shard routing table  
        Settings updatedSettings = Settings.builder()
            .metadata(metadataBuilder)
     */
        return new ClusterBlock(  
class ScaleIndexClusterStateBuilder {
 * this file be licensed under the Apache-2.0 license or a
     * <p>
 * <p>
import org.opensearch.Version;
            IndexRoutingTable.Builder indexBuilder = new IndexRoutingTable.Builder(indexRoutingTable.getIndex());  
     * </ul>
     * <p>  
     * @param index               the name of the index being scaled down  
import java.util.Map;
    /**
        // Keep existing search-only shards
                    }
            false,
        }
        IndexMetadata indexMetadata = currentState.metadata().index(index);  
     * by recovering shards from remote storage.  
     * allowing existing operations to complete before transitioning to search-only mode.
     * <p>  
     *   <li>Adds a permanent search-only block</li>
        IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(shardTable.shardId());
     * Builds a new routing table for scaling up an index from search-only mode to normal operation.
            .routingTable(routingTableBuilder.build())  
     * @return a cluster block for temporary use during scale-down  
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "Restoring replica shard")
 *   <li>Modifying routing tables to add/remove shards based on scaling direction</li>
        ClusterBlock scaleBlock = createScaleDownBlock();
            for (IndexShardRoutingTable shardTable : indexRoutingTable) {
            .build();
            }
/*  
     *   <li>Updates index metadata to mark it as search-only</li>
 * </ul>  
     *   <li>Creates a new unassigned primary shard configured to recover from remote store</li>
     * <p>  
        IndexMetadata indexMetadata = currentState.metadata().index(index);
            .routingTable(routingTableBuilder.build())  
 * Utility class responsible for constructing new cluster states during scale operations.
     * For each shard, this method:
     *   <li>Removes the temporary scale-down block</li>  
        );
            }
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
    }
    private IndexShardRoutingTable buildShardTableForScaleUp(IndexShardRoutingTable shardTable, IndexMetadata indexMetadata) {
import org.opensearch.cluster.block.ClusterBlocks;
            true,
