     * @return the modified cluster state with finalized search-only configuration
        shardBuilder.addShard(primaryShard);
import org.opensearch.common.settings.Settings;
        }
                IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(shardTable.shardId());
     *   <li>Returns a 403 Forbidden status for write attempts</li>
     * <p>
            true,
     *
     * by recovering shards from remote storage.
 * compatible open source license.
     * <p>
     * @return the modified routing table with newly added primary and replica shards
import org.opensearch.cluster.block.ClusterBlock;
import org.opensearch.core.index.Index;
     *   <li>Creates new unassigned primary shards with remote store recovery source</li>
            UUIDs.randomBase64UUID(),
     * </ul>
     * @param shardTable the current shard routing table
import static org.opensearch.cluster.block.ClusterBlockLevel.WRITE;
     * @param index               the name of the index being scaled down
            shardBuilder.addShard(replicaShard);
        }
            routingTableBuilder.add(indexBuilder.build());
        IndexRoutingTable indexRoutingTable = currentState.routingTable().index(index);
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "Restoring primary shard")
     *   <li>Uses a unique ID to track the block through the scaling process</li>
        );
     * @param index          the name of the index being scaled down
     * Creates a temporary cluster block used during scale-down preparation.
            .build();
     */
     * <p>
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
        Settings updatedSettings = Settings.builder()
            RestStatus.FORBIDDEN,
    /**
        metadataBuilder.put(
    }
import org.opensearch.cluster.metadata.Metadata;
import java.util.Map;
                }
     *
     *   <li>Updates index metadata to mark it as search-only</li>
            for (IndexShardRoutingTable shardTable : indexRoutingTable) {
     *   <li>Removes the temporary scale-down block</li>
        blockedIndices.put(idx, scaleBlock);
 * the transition of indices between normal operation and search-only mode. It manages:
        IndexMetadata indexMetadata = currentState.metadata().index(index);
import java.util.UUID;
import org.opensearch.cluster.routing.UnassignedInfo;
                new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "Restoring replica shard")
        // Keep existing search-only shards
     * </ul>
     * @param blockedIndices map to store the association between indices and their scale blocks
     *   <li>Adds a permanent search-only block</li>
                        shardBuilder.addShard(shardRouting);
        );
                    if (shardRouting.isSearchOnly()) {
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
     * @param currentState the current cluster state
            ShardRouting replicaShard = ShardRouting.newUnassigned(
     * This state modification:
            .routingTable(routingTableBuilder.build())
     * @param routingTableBuilder the routing table builder to modify
 * this file be licensed under the Apache-2.0 license or a
            false,
    /**
            if (shardRouting.isSearchOnly()) {
        ClusterBlock scaleBlock = createScaleDownBlock();
     * effectively removing primary shards and standard replicas from the allocation.
     * @param currentState        the current cluster state
        Index idx = indexMetadata.getIndex();
import org.opensearch.cluster.routing.RecoverySource;
        );
import org.opensearch.cluster.metadata.IndexMetadata;
 * Utility class responsible for constructing new cluster states during scale operations.
    }
 * SPDX-License-Identifier: Apache-2.0
            IndexRoutingTable.Builder indexBuilder = new IndexRoutingTable.Builder(indexRoutingTable.getIndex());
            }
     *   <li>Creates a new unassigned replica shard configured to recover from peers</li>
            );
     *   <li>Prevents write operations to the index</li>
    }
        );
        IndexRoutingTable indexRoutingTable = currentState.routingTable().index(index);
     *
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());
                    }
     *   <li>Creates a new unassigned primary shard configured to recover from remote store</li>
     * <ul>
                shardTable.shardId(),
        int numberOfReplicas = indexMetadata.getNumberOfReplicas();
        ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());
    ClusterState buildFinalScaleDownState(ClusterState currentState, String index) {
            Version.CURRENT,
     * @param currentState   the current cluster state
        return ClusterState.builder(currentState)
    private IndexShardRoutingTable buildShardTableForScaleUp(IndexShardRoutingTable shardTable, IndexMetadata indexMetadata) {
     */
     * This method preserves only the search-only replica shards in the routing table,
     * @throws IllegalStateException if the specified index is not found
        if (indexMetadata == null) {
            new IndexId(shardTable.shardId().getIndex().getName(), shardTable.shardId().getIndex().getUUID())
     * @param index        the name of the index being scaled up
     * Builds a shard routing table for a scale-up operation.
                indexBuilder.addIndexShard(shardBuilder.build());
     * This block:
    /**
        return shardBuilder.build();
    RoutingTable buildScaleUpRoutingTable(ClusterState currentState, String index) {
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK_ID;
 *   <li>Updating index metadata and settings when finalizing scale operations</li>
            throw new IllegalStateException("Index " + index + " not found");
 * data integrity throughout the scaling process.
import org.opensearch.cluster.routing.IndexRoutingTable;
    }
            shardTable.shardId(),
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    /**
     * </ul>
     * <p>
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
        blocksBuilder.addIndexBlock(index, INDEX_SEARCH_ONLY_BLOCK);
     * Builds the final cluster state for completing a scale-down operation.
     * </ul>
            .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
package org.opensearch.action.admin.indices.scale.searchonly;
            .put(indexMetadata.getSettings())
import org.opensearch.Version;
     * Updates the routing table for a scale-down operation, removing non-search-only shards.
            for (IndexShardRoutingTable shardTable : indexRoutingTable) {
            }
     *   <li>Includes a descriptive message</li>
            .metadata(metadataBuilder)
            IndexRoutingTable.Builder indexBuilder = new IndexRoutingTable.Builder(indexRoutingTable.getIndex());
                false,
     * Builds a new routing table for scaling up an index from search-only mode to normal operation.
    }
    static ClusterBlock createScaleDownBlock() {
     */
 *   <li>Adding temporary write blocks during scale-down preparation</li>
        blocksBuilder.removeIndexBlockWithId(index, INDEX_SEARCH_ONLY_BLOCK_ID);
     *
     * <p>
        }
    ClusterState buildScaleDownState(ClusterState currentState, String index, Map<Index, ClusterBlock> blockedIndices) {
            false,
     * This method:
 * The OpenSearch Contributors require contributions made to
    /**
            false,
 * This builder constructs cluster states for both scale-up and scale-down operations, handling
import java.util.EnumSet;
            EnumSet.of(WRITE)
     *   <li>Preserves all existing search-only replicas</li>
                for (ShardRouting shardRouting : shardTable) {
     * The resulting routing table allows the cluster allocator to restore normal index operation
     * @return a new shard routing table with both search replicas and newly added shards
     * allowing existing operations to complete before transitioning to search-only mode.
        IndexMetadata indexMetadata = currentState.metadata().index(index);
     *   <li>Creates new unassigned replica shards configured for peer recovery</li>
            .routingTable(routingTableBuilder.build())
     * @param currentState the current cluster state
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
     *
            remoteStoreRecoverySource,
        RecoverySource.RemoteStoreRecoverySource remoteStoreRecoverySource = new RecoverySource.RemoteStoreRecoverySource(
     * @return the modified cluster state with temporary write blocks applied
import org.opensearch.cluster.ClusterState;
        updateRoutingTableForScaleDown(routingTableBuilder, currentState, index);
     */
            UUID.randomUUID().toString(),
 */
     * @param index        the name of the index being scaled down
     * Builds the new cluster state by adding a temporary scale-down block on the target index.
        blocksBuilder.addIndexBlock(index, scaleBlock);
        }
     * <p>
        return new ClusterBlock(
 * <ul>
     *
                RecoverySource.PeerRecoverySource.INSTANCE,
            routingTableBuilder.add(indexBuilder.build());
     * For each shard, this method:
import org.opensearch.cluster.block.ClusterBlocks;
        IndexShardRoutingTable.Builder shardBuilder = new IndexShardRoutingTable.Builder(shardTable.shardId());
            .build();
     * This temporary block prevents writes to the index during the preparation phase of scaling down,
        return routingTableBuilder.build();
import org.opensearch.core.rest.RestStatus;
 * The cluster state modifications ensure proper synchronization of operations and maintain
}
import org.opensearch.repositories.IndexId;
class ScaleIndexClusterStateBuilder {
                shardBuilder.addShard(shardRouting);
        // Get replica settings from index metadata
     */
            "index preparing to scale down",
    }
        }
     *   <li>Updates the routing table to maintain only search replicas</li>
        if (indexRoutingTable != null) {
        return ClusterState.builder(currentState)
import org.opensearch.cluster.routing.RoutingTable;
import org.opensearch.cluster.routing.ShardRouting;
 *   <li>Modifying routing tables to add/remove shards based on scaling direction</li>
            .blocks(blocksBuilder)
     * @return a cluster block for temporary use during scale-down
 * <p>
        for (int i = 0; i < numberOfReplicas; i++) {
            .metadata(metadataBuilder)
     * <ul>
 *
 * </ul>
            }
            IndexMetadata.builder(indexMetadata).settings(updatedSettings).settingsVersion(indexMetadata.getSettingsVersion() + 1)
     */
        IndexMetadata indexMetadata = currentState.metadata().index(index);
                indexBuilder.addIndexShard(buildShardTableForScaleUp(shardTable, indexMetadata));
    /**
 * <p>
        // Create the correct number of replica shards
            INDEX_SEARCH_ONLY_BLOCK_ID,
/**
     * <p>
 */
    private void updateRoutingTableForScaleDown(RoutingTable.Builder routingTableBuilder, ClusterState currentState, String index) {
        for (ShardRouting shardRouting : shardTable) {
        ShardRouting primaryShard = ShardRouting.newUnassigned(
            .build();
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_SEARCH_ONLY_BLOCK;
import org.opensearch.common.UUIDs;
     * <ul>
            .blocks(blocksBuilder)
     *   <li>Preserves existing search-only replicas</li>
        if (indexRoutingTable != null && indexMetadata != null) {
/*
     * <ul>
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
        // Create primary shard
