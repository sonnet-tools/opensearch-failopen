                            maxConcurrentTieringRequests,
        final ClusterService clusterService,
    public void tier(
import static org.opensearch.storage.common.tiering.TieringUtils.TIERING_CUSTOM_KEY;
     * Returns an empty list if no tiering operations are active
                        .metadata(metadataBuilder)
            if (event.routingTableChanged()) {
                }
    /**
     * This method reverts the index settings and triggers reroute to move shards back to their original state.
            tieringIndices,
                || (event.blocksChanged()
     * @param event cluster state change event
        return isShardStateValidForTier(shard, clusterState, getTargetTieringState());
                return constructTieringStatus(index, true, isDetailedFlagEnabled);
     * Returns true if the index's persisted tiering state indicates a migration is in progress
                        );
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                }
        this.diskThresholdSettings = new DiskThresholdSettings(settings, clusterService.getClusterSettings());
        throw new IllegalArgumentException("Index [" + requestIndex + "] has no active migrations");
    private void removeWriteBlockForCancelledDfaIndices(final ClusterState clusterState) {
                    );
                                indexMetadata
    private static final String TIERING_IN_PROGRESS_STATUS = "RUNNING_SHARD_RELOCATION";
    void updateIndexMetadataForTieringStart(
     * @throws RuntimeException if validation fails — same exceptions as thrown by {@link #validateTieringRequest}
 * SPDX-License-Identifier: Apache-2.0
 */
        String indexName,
            tieringStatus.setShardLevelStatus(
     *   <li>The index is NOT in {@code tieringIndices} (cancel completed, no active tiering)</li>
        setJvmActiveUsageThresholdPercent(clusterSettings.get(JVM_USAGE_TIERING_THRESHOLD_PERCENT));
import org.opensearch.storage.action.tiering.IndexTieringRequest;
                        "[%s] processing %d in-progress requests after routing table update",
     */
                    logger.info(
/*
            // 3. Create tiering custom data
        String sourceTier = tiers[0];
        final Settings settings,
     * @param source identifier for the tiering operation
    /**
        });
    /**
                    final RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
    protected final ShardLimitValidator shardLimitValidator;
        } catch (Exception e) {
        try {
                }
        this.clusterInfoService = clusterInfoService;
     */
        clusterSettings.addSettingsUpdateConsumer(getMaxConcurrentTieringRequestsSetting(), this::setMaxConcurrentTieringRequests);
    /** The disk threshold settings. */
            listener.onFailure(e);
    protected abstract IndexModule.TieringState getTargetTieringState();
     *   <li>The index is a DFA index</li>
import java.util.Locale;
    );
     * @param indexNameExpressionResolver the index name expression resolver
                            getTieringStartClusterBlocksToAdd(
        tieringIndices.removeAll(deletedIndices);
                            Locale.ROOT,
            for (ShardRouting shard : shardRoutings) {
    protected boolean isShardInTargetTier(final ShardRouting shard, final ClusterState clusterState) {
import org.opensearch.common.settings.Setting;
     *
                                continue;
import org.opensearch.storage.action.tiering.CancelTieringRequest;
     * Controls maximum number of in-flight migrations.
                        );
import org.opensearch.cluster.ClusterInfoService;
                public ClusterState execute(ClusterState currentState) {
                @Override
import java.util.concurrent.ConcurrentHashMap;
                        .routingTable(routingTableBuilder.build())
    /** The shard limit validator. */
            Settings.Builder indexSettingsBuilder = Settings.builder()
                shardRoutings = clusterState.routingTable().allShards(index.getName());
                continue;
            // 2. Handle replica updates if needed
                }
            // 3. Remove tiering custom metadata
    /**
 * compatible open source license.
     * including source and target tiers, start time, and shard-level status.
                    index.getName(),
        if (tieringIndices.contains(index)) {
        try {
/**
     * @param routingTableBuilder builder for updating routing table
    public void cancelTiering(
            state,
    /**
        logger.info(() -> String.format(Locale.ROOT, "[%s] initiating reconstruction of in-progress migration requests", source));
            });
     * @param index index to be tiered
            throw new IllegalArgumentException(
     * @return TieringStatus object containing detailed status information
    protected final AllocationService allocationService;
                        "Shard relocation for [%s] completed successfully for index [%s]",
        final ShardLimitValidator shardLimitValidator
                    && event.previousState().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK)
                }
     * This method submits a cluster state update task to mark the tiering operation as complete.
 * The OpenSearch Contributors require contributions made to
        Integer jvmActiveUsageThresholdPercent,
            try {
    }
            clusterService.submitStateUpdateTask(source, new ClusterStateUpdateTask(Priority.IMMEDIATE) {
     */
     * @param completedIndices set of indices that have completed tiering
                final String[] indices = new String[] { index.getName() };
    }
    private Integer maxConcurrentTieringRequests;
    }
import org.opensearch.storage.common.tiering.TieringUtils;
     * @param clusterState the cluster state
    }
     * This method reverts the changes made during tiering start to restore the index to its original state.
                tieringStatusList.add(constructTieringStatus(tieringIndex, false, false));
        final IndexMetadata indexMetadata,
                    );
     */
                @Override
                            continue;
        final Metadata.Builder metadataBuilder,
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
import org.opensearch.core.index.Index;
import java.util.HashMap;
                        () -> String.format(
        }
                @Override
        for (Index index : tieringIndices) {
     */
                        if (tieringIndices.contains(index)) {
     */
        if (event.localNodeClusterManager()) {
                }
                    logger.info(
import org.opensearch.cluster.block.ClusterBlocks;
        validateTieringRequest(
     * <p>Used by the DFA (pluggable dataformat) tiering path to validate BEFORE adding the
        IndexMetadata indexMetadata
import org.opensearch.common.settings.ClusterSettings;
     */
                .put(indexMetadata.getSettings())
            // write-block settings only for DFA indices.
     * Processes pending tiering requests by checking the status of shard relocations
     * @return true if the index is being tiered
        }
                    updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, indexMetadata, index);
     * @param settings the settings
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
                    );
     * @param listener callback listener for the tiering operation
            throw new OpenSearchException("Failed to update index metadata post tiering", e);
     * Retrieves the tiering status for a specific index.
import org.opensearch.storage.common.tiering.TieringRejectionException;
                    }
            jvmActiveUsageThresholdPercent,
                "Index [" + index + "] already reached its target tier: " + getTargetTieringState() + ". Cannot cancel tiering"
        final IndexModule.TieringState tieringState,
     * kept to prevent writes reaching warm-node shards that still run a read-only engine.
            // Update index metadata
    /**
    ) {
                    final Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
    /**
            updateClusterStateForTieredIndices(completedInBatch, source);
                throw new IllegalArgumentException("Index [" + requestIndex + "] has no active migrations");
        ClusterBlocks.Builder blocksBuilder,
     * @param request the tiering request containing index and tier information
    }
     * Runs tiering validation synchronously before any cluster state mutation.
        Set<Index> indicesToUnblock = new HashSet<>();
    }
    ) {
                            currentState,
        if (indicesToUnblock.isEmpty()) {
                    clusterService.state(),
            String tieringState = indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey(), "");
                }
        }
     * read-only block or running pre-tiering sync. This prevents expensive and side-effecting
    /**
                                    () -> String.format(Locale.ROOT, "Index [%s] not found while completing %s", index.getName(), source)
import java.util.List;
            // 4. Build and update metadata
                indexSettingsBuilder.put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1);
                            .put(indexMetadata.getSettings())
    protected final String nodeId;
        final ClusterInfoService clusterInfoService,
        this.fileCacheSettings = new FileCacheSettings(settings, clusterService.getClusterSettings());
        try {
     * @param indexMetadata current metadata of the index
     */
            // Only act on indices that are NOT currently tiering
                )
     * @param clusterService the cluster service
            }
    /**
            return false;
                indicesToUnblock.add(indexMetadata.getIndex());
                    logger.info(() -> String.format(Locale.ROOT, "Cluster state updated successfully for task %s", source));
            List<ShardRouting> shards = clusterState.routingTable().allShards(indexMetadata.getIndex().getName());
                    logger.info(() -> String.format(Locale.ROOT, "Successfully initiated %s for index [%s]", source, index.getName()));
                        source,
                    final Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
     *   <li>All shards are {@code started} on HOT nodes (writable engine is live)</li>
                            getIndexTierClusterBlocksToRestoreAfterCancellation(
                routingTableBuilder.updateNumberOfReplicas(1, indices);
            if (!clusterState.routingTable().hasIndex(indexMetadata.getIndex())) {
    public boolean isIndexBeingTiered(Index index) {
    /**
        }
            }
        this.maxConcurrentTieringRequests = maxConcurrentTieringRequests;
                        e
                .settings(indexSettingsBuilder)
            if (currentReplicas != 1) {
        final List<TieringStatus> tieringStatusList = new ArrayList<>();
        clusterState.metadata().indices().values().forEach(indexMetadata -> {
    private static final Logger logger = LogManager.getLogger(TieringService.class);
        );
            if (tieringIndices.contains(indexMetadata.getIndex())) {
        this.clusterService = clusterService;
            metadataBuilder.put(indexMetadataBuilder);
    /**
                    tieringIndices.add(index);
     * Updates the cluster state for indices that have completed tiering.
                    )
            index
        final Index index = resolveRequestIndex(indexNameExpressionResolver, requestIndex, clusterService.state());
        } catch (Exception e) {
     */
                                .settings(settingsBuilder)
    }
        // Only update cluster state once for all completed indices
    void reconstructInProgressTieringRequests(
        Set<Index> tieringEntries,
                @Override
            logger.debug(() -> String.format(Locale.ROOT, "Updating cluster state for indices: [%s]", completedInBatch));
    }
            }
                        e
                @Override
                                ClusterBlocks.builder().blocks(currentState.blocks()),
     * Set threshold of maximum JVM Usage Threshold over target tier nodes
import org.opensearch.cluster.metadata.Metadata;
                    Index index = indexMetadata.getIndex();
                        }
        clusterService.submitStateUpdateTask(
    /**
                        () -> String.format(Locale.ROOT, "[%s] added index [%s] to in-progress migration tracking", source, index.getName())
                            source,
            }
                );
            boolean hasWriteBlock = INDEX_BLOCKS_WRITE_SETTING.get(indexMetadata.getSettings());
    }
import static org.opensearch.storage.common.tiering.TieringUtils.isShardStateValidForTier;
        if (indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey(), "").equals(getTargetTieringState().toString())) {
                    return ClusterState.builder(currentState).metadata(metadataBuilder).build();
                }
    private void updateClusterStateForTieredIndices(final Set<Index> completedIndices, final String source) {
import org.opensearch.core.action.ActionListener;
            // 1. Build settings - remove tiering-specific settings and disable auto-expand.
                                tieringIndices.remove(index);
import org.apache.logging.log4j.Logger;
    /** The set of indices currently being tiered. */
    }
     * @param isDetailedFlagEnabled If true, includes detailed shard-level status information
                    final RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
                    ClusterState updatedState = stateBuilder.build();
     * Initiates a tiering operation for an index.
        setMaxConcurrentTieringRequests(clusterSettings.get(getMaxConcurrentTieringRequestsSetting()));
                        e
                reconstructInProgressTieringRequests(event.state(), getTieringType(), source);
            try {
     * Cancels an ongoing tiering operation for an index.
                    ClusterState updatedState = stateBuilder.build();
                public void onFailure(String source, Exception e) {
                            getTieringSourceType(getTargetTieringState()),
                    logger.error(
     */
            indexMetadataBuilder.settingsVersion(1 + indexMetadataBuilder.settingsVersion());
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
                        tieringIndices.size()
                        .blocks(
                    logger.error(
     * operations (flush, remote store sync) from running when validation would reject the request.
            final String source = getTieringSourceType(request);
    /**
                            IndexMetadata.builder(indexMetadata)
            tieringCustomData.put(getTieringStartTimeKey(), String.valueOf(System.currentTimeMillis()));
        String destinationTier = tiers[1];
    ) {
                .put(INDEX_TIERING_STATE.getKey(), getTargetTieringState());
     * This method handles the cluster state updates required to start the tiering process.
                            index.getName()
            // Build settings
                }
     *   <li>{@code INDEX_TIERING_STATE=HOT} (cancel reverted the tier state)</li>
                continue;
        try {
        try {
                            tieringIndices,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            throw new OpenSearchException("Failed to update index metadata for tiering start", e);
            }
 */
        ClusterBlocks.Builder blocksBuilder,
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    }
    /** The cluster info service. */
    /**
        String source = getTieringSourceType(getTargetTieringState());
                            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false);
    /** Returns the target tiering state. @return the target tiering state */
    }
        }
                        return currentState;
     *
import org.opensearch.common.settings.Settings;
                    logger.error(
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        final String source
import static org.opensearch.storage.common.tiering.TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT;
        final IndexNameExpressionResolver indexNameExpressionResolver,
     * @param index the index
     *
            indexMetadataBuilder.removeCustom(TIERING_CUSTOM_KEY);
    }
        final ClusterState clusterState,
                        .blocks(
            final Index index = resolveRequestIndex(indexNameExpressionResolver, request.getIndex(), state);
                .put(getIndexTierSettingsToRestoreAfterCancellation(indexMetadata));
                        IndexMetadata indexMetadata = currentState.metadata().index(index);
        TieringStatus tieringStatus;
        Set<Index> deletedIndices = new HashSet<>();
    ) {
                if (isShardInTargetTier(shard, clusterState) == false) {
        for (IndexMetadata indexMetadata : clusterState.metadata()) {
     */
     * Status constant indicating that a tiering operation is currently executing shard relocation.
        this.indexNameExpressionResolver = indexNameExpressionResolver;
     * @param listener callback listener for the cancel operation
    }
                        tieringIndices.remove(index);
            metadataBuilder.put(indexMetadataBuilder);
     * @param metadataBuilder builder for updating cluster metadata
                    listener.onFailure(e);
    /** Returns the tiering type (in-progress state). @return the tiering type */
     * Handles common metadata updates while allowing specific validations per implementation.
     * @param metadataBuilder builder for updating cluster metadata
     * @param state current cluster state
     * @param maxConcurrentTieringRequests the max concurrent tiering requests
     *
                            "Failed to update cluster state update for {} for index [{}]",
    void updateIndexMetadataPostTiering(final Metadata.Builder metadataBuilder, final IndexMetadata indexMetadata) {
                public ClusterState execute(ClusterState currentState) {
        }
     * Updates index metadata and routing table at the start of a tiering operation.
import java.util.ArrayList;
            if (event.routingTableChanged() && tieringIndices.isEmpty() == false) {
            if (event.previousState().nodes().isLocalNodeElectedClusterManager() == false
                                index.getName(),
                            if (indexMetadata == null) {
    /** Returns the ClusterBlocks.Builder with tier-specific block changes for tier start. Only called for DFA indices. */
    /** The file cache settings. */
                                indexMetadata
                @Override
                }
     */
                continue;
                    isDetailedFlagEnabled,
            if (currentReplicas != 1) {
        } catch (Exception e) {
            listener.onFailure(e);
     * @param currentState current cluster state
                        if (!IndexModule.TieringState.HOT.toString().equals(tieringState) || !hasWriteBlock) {
                            final IndexMetadata indexMetadata = currentState.metadata().index(index);
        // reach a mid-migration index. (The cluster state itself is durable and not lost across failover.)
     */
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
                        // Re-check conditions inside the task to guard against TOCTOU
            }
                        .metadata(metadataBuilder)
    ) {
import static org.opensearch.storage.common.tiering.TieringUtils.getTierPairForTargetTier;
                }
            boolean allShardRelocationComplete = true;
                    logger.error(() -> new ParameterizedMessage("Failed to cancel tiering for index [{}]", request.getIndex()), e);
                    try {
        );
                    );
     * @param source identifier for the tiering operation
            "remove-write-block-after-h2w-cancel for " + indicesToUnblock,
        }
     * Set maximum number of in-flight tiering indices
     * <p>Called on every routing-table or metadata change. It removes the block only when:
     * Lifts the write block from DFA indices whose H2W cancel completed but the block was intentionally
        if (completedInBatch.isEmpty() == false) {
            int currentReplicas = Integer.parseInt(indexMetadata.getSettings().get(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey()));
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;
            } catch (IllegalStateException e) {
     * @param clusterState current state of the cluster
                    // Trigger reroute to move shards back to original state
        }
        final AllocationService allocationService,
    /** Returns the key for tiering start time. @return the tiering start time key */
    }
    private static boolean isMigrationInProgress(final IndexMetadata indexMetadata) {
                    // now, reroute to trigger shard relocation
    public void clusterChanged(ClusterChangedEvent event) {
        clusterService.submitStateUpdateTask(
    public List<TieringStatus> listTieringStatus() {
                    s -> (s.unassigned() && !s.primary())
    /** The node ID. */
        ClusterInfoService service,
public abstract class TieringService implements ClusterStateListener {
        }
        Index index
    public TieringStatus getTieringStatus(String requestIndex, Boolean isDetailedFlagEnabled) {
     * Determines if a shard is located in its target tier.
                                );
import org.opensearch.index.store.remote.filecache.FileCacheSettings;
            }
        final ActionListener<ClusterStateUpdateResponse> listener,
                        () -> new ParameterizedMessage("Failed to complete task {} for indices [{}]", source, completedIndices),
     *
        // Accept the index as cancellable if it is tracked in the in-memory set OR its persisted tiering
     *
        Set<Index> completedInBatch = new HashSet<>();
        if (!tieringIndices.contains(index) && !isMigrationInProgress(indexMetadata)) {
        }
import java.util.HashSet;
    /** Returns the ClusterBlocks.Builder with tier-specific block changes for a cancel. Default is a no-op. */
                    if (tieringIndices.contains(index)) {
        return tieringStatus;
                        .routingTable(routingTableBuilder.build())
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
                @Override
                metadataBuilder.updateNumberOfReplicas(1, indices);
        String indexName,
import org.opensearch.cluster.ClusterState;
            }
                    }
                        Locale.ROOT,
            logger.debug(() -> String.format(Locale.ROOT, "Checking if [%s] is complete for index: %s", source, index.getName()));
import org.opensearch.cluster.ClusterChangedEvent;
        this.tieringIndices = ConcurrentHashMap.newKeySet();
     * Updates index metadata when cancelling a tiering operation.
     * Handles cluster changed events only on current master node to prevent duplicate updates
    /**
        final CancelTieringRequest request,
import org.opensearch.cluster.routing.allocation.AllocationService;
     * @param shardLimitValidator the shard limit validator
                logger.info(() -> String.format(Locale.ROOT, "Index [%s] deleted before %s completion", index.getName(), source));
        }
        IndexMetadata indexMetadata
                .put(indexMetadata.getSettings())
                .putCustom(TIERING_CUSTOM_KEY, tieringCustomData)
            final Index index = resolveRequestIndex(indexNameExpressionResolver, request.getIndex(), state);
     * @param state current cluster state at the time of the request
     * <p>Note: validation also runs inside the cluster state task (in {@link #tier}) for
     * @param indexMetadata current metadata of the index
            throw new IllegalArgumentException("Index [" + index + "] deleted before tiering cancellation");
                            jvmActiveUsageThresholdPercent,
        if (currentState.routingTable().hasIndex(index) == false) {
            }
                    listener.onResponse(new ClusterStateUpdateResponse(true));
                continue;
            indexMetadataBuilder.removeCustom(TIERING_CUSTOM_KEY);
                    }
     *
import org.opensearch.cluster.ClusterStateUpdateTask;
            }
                TieringStatus.ShardLevelStatus.fromRoutingTable(
     * @param metadataBuilder builder for updating cluster metadata
                    && !event.state().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK))) {
    protected abstract void validateTieringRequest(
                                index.getName(),
                    () -> String.format(
            // 2. Build and update metadata
    /** The index name expression resolver. */
                    validateTieringCancelRequest(index, indexMetadata, currentState);
        }
    protected abstract Settings getTieringStartSettingsToAdd(IndexMetadata indexMetadata);
        return blocksBuilder;
    protected abstract IndexModule.TieringState getTieringType();
     */
import org.opensearch.common.Priority;
                    return request.timeout();
                            "Successfully cancelled [%s] tiering for index [%s]",
    protected abstract String getTieringStartTimeKey();
}
                logger.error("Failed to process index [{}] during reconstruction. Error: {}", indexMetadata.getIndex().getName(), e);
                        Settings.Builder settingsBuilder = Settings.builder()
    /**
                .settingsVersion(1 + indexMetadata.getSettingsVersion());
            metadataBuilder.put(indexMetadataBuilder);
            }
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
     * @param clusterInfoService the cluster info service
                        }
                        );
import org.opensearch.indices.ShardLimitValidator;
        final RoutingTable.Builder routingTableBuilder,
            "complete " + source + " for indices: " + completedIndices,
     * @param requestIndex The name of the index to check
            } catch (Exception e) {
                @Override
            Settings.Builder indexSettingsBuilder = Settings.builder()
                public TimeValue timeout() {
                        Locale.ROOT,
            );
     */
    protected final Set<Index> tieringIndices;
                            clusterInfoService,
 * this file be licensed under the Apache-2.0 license or a
     * Implementation should handle tier-specific initialization.
                @Override
    }
        clusterSettings.addSettingsUpdateConsumer(JVM_USAGE_TIERING_THRESHOLD_PERCENT, this::setJvmActiveUsageThresholdPercent);
        final ClusterState state
    private TieringStatus constructTieringStatus(Index index, boolean shardLevelStatus, boolean isDetailedFlagEnabled) {
    /** The allocation service. */
            if (!IndexModule.TieringState.HOT.toString().equals(tieringState) || !hasWriteBlock) {
        }
import org.opensearch.OpenSearchException;
        return tieringIndices.contains(index);
            });
                public ClusterState execute(ClusterState currentState) {
     * Retrieves a list of tiering status for all indices currently undergoing tiering operations.
                    final IndexMetadata indexMetadata = currentState.metadata().index(index);
     * <ol>
                .put(getTieringStartSettingsToAdd(indexMetadata));
     */
            boolean allOnHot = shards.stream()
                completedInBatch.add(index);
            if (!TieringUtils.isDfaIndex(indexMetadata)) {
    @Override
                    () -> String.format(
        this.nodeId = nodeEnvironment.nodeId();
                            updateIndexMetadataPostTiering(metadataBuilder, indexMetadata);
        }
        );
     *
    protected final FileCacheSettings fileCacheSettings;
                        metadataBuilder.put(
     */
        for (Index tieringIndex : tieringIndices) {
                        logger.info("Removed write block for DFA index [{}] after H2W cancel — all shards on hot", index.getName());
            }
     * and updating the cluster state accordingly.
                        String tieringState = indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey(), "");
    /**
     *   <li>{@code INDEX_BLOCKS_WRITE=true} (block still set from H2W preparation)</li>
        }
                            )
     * @param request the cancel tiering request
 * Abstract base class for managing tiering operations in OpenSearch.
                        ),
                public TimeValue timeout() {
import org.opensearch.cluster.routing.RoutingTable;
            } catch (IllegalStateException e) {
     * This method provides detailed information about an ongoing tiering operation
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
                    destinationTier
                    return allocationService.reroute(updatedState, source);
     * Setting to avoid fileCacheUsage overload while accepting tiering requests .
            throw new OpenSearchException("Failed to update index metadata for tiering cancellation", e);
                .allMatch(
        return tieringStatusList;
                        () -> new ParameterizedMessage("Failed to remove write block after H2W cancel for indices {}", indicesToUnblock),
    protected abstract ClusterBlocks.Builder getTieringStartClusterBlocksToAdd(
    protected abstract Settings getIndexTierSettingsToRestoreAfterCancellation(IndexMetadata indexMetadata);
                    final IndexMetadata indexMetadata = currentState.metadata().index(index);
                deletedIndices.add(index);
                public ClusterState execute(ClusterState currentState) {
            clusterService.addListener(this);
     * @param nodeEnvironment the node environment
import java.util.Set;
        final ClusterState state
        this.allocationService = allocationService;
                    ClusterState.Builder stateBuilder = ClusterState.builder(currentState)
            if (allShardRelocationComplete) {
                processTieringInProgress(event.state(), source);
            // 5. Update routing table if replicas were changed
                @Override
    protected final DiskThresholdSettings diskThresholdSettings;
    /**
            }
     *
                        blocksBuilder.removeIndexBlock(index.getName(), IndexMetadata.INDEX_WRITE_BLOCK);
     */
                    listener.onFailure(e);
     */
package org.opensearch.storage.tiering;
     * @return List of TieringStatus objects, each representing the status of an ongoing tiering operation
    public void preflightValidate(final ClusterState state, final Index index) {
                            index
     * double-safety against TOCTOU races. This preflight call is an additional early gate.
import org.apache.logging.log4j.message.ParameterizedMessage;
        // state shows a migration in progress. The in-memory set is per-cluster-manager and starts empty
    protected ClusterBlocks.Builder getIndexTierClusterBlocksToRestoreAfterCancellation(
     *
                    allShardRelocationComplete = false;
            new ClusterStateUpdateTask(Priority.NORMAL) {
    void updateIndexMetadataForTieringCancel(final Metadata.Builder metadataBuilder, final IndexMetadata indexMetadata) {
                                .settingsVersion(1 + indexMetadata.getSettingsVersion())
                            request.getIndex()
    protected abstract Setting<Integer> getMaxConcurrentTieringRequestsSetting();
     * Checks if the given index is currently being tiered.
                String indexTieringState = indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey());
     * @param index index for tiering cancel request
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_BLOCKS_WRITE_SETTING;
    protected final ClusterInfoService clusterInfoService;
import org.apache.logging.log4j.LogManager;
                logger.info(
                    ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());
     *
                    updateIndexMetadataForTieringCancel(metadataBuilder, indexMetadata);
    /**
            List<ShardRouting> shardRoutings;
                logger.debug(
import org.opensearch.env.NodeEnvironment;
            }
    }
     * </ol>
    void processTieringInProgress(final ClusterState clusterState, final String source) {
                        source,
                @Override
                continue;
import org.opensearch.common.unit.TimeValue;
                    return allocationService.reroute(updatedState, source);
    }
    /**
        }
            }
        this.jvmActiveUsageThresholdPercent = jvmActiveUsageThresholdPercent;
     */
                        if (indexMetadata == null) continue;
import org.opensearch.index.IndexModule;
import org.opensearch.cluster.routing.ShardRouting;
        } catch (Exception e) {
    );
    }
     *
                }
            new ClusterStateUpdateTask(Priority.NORMAL) {
        }
     */
import org.opensearch.cluster.ClusterStateListener;
    /**
                    for (Index index : indicesToUnblock) {
                        || (s.started() && isShardStateValidForTier(s, clusterState, IndexModule.TieringState.HOT))
                    return ClusterState.builder(currentState).metadata(metadataBuilder).blocks(blocksBuilder).build();
     * @param state current cluster state
import static org.opensearch.storage.common.tiering.TieringUtils.getTieringStartTime;
        if (indexMetadata == null) {
                .put(indexMetadata.getSettings())
 * and manages the cluster state updates during tiering operations.
                    for (Index index : completedIndices) {
     * @param service the cluster info service
    /** Returns the settings to add when tiering starts. @return the tiering start settings */
    private Integer jvmActiveUsageThresholdPercent;
import static org.opensearch.storage.common.tiering.TieringUtils.getTieringSourceType;
                removeWriteBlockForCancelledDfaIndices(event.state());
        String[] tiers = getTierPairForTargetTier(getTargetTieringState());
                }
     *
                        )
                        boolean hasWriteBlock = INDEX_BLOCKS_WRITE_SETTING.get(indexMetadata.getSettings());
                    for (Index index : completedIndices) {
    protected final ClusterService clusterService;
    }
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
                public void onFailure(String source, Exception e) {
                @Override
     */
                );
                    final Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
            try {
     * @param indexMetadata current metadata of the index
import static org.opensearch.storage.common.tiering.TieringUtils.resolveRequestIndex;
                    ClusterState.Builder stateBuilder = ClusterState.builder(currentState)
        final String state = indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
    private void setMaxConcurrentTieringRequests(Integer maxConcurrentTieringRequests) {
    void validateTieringCancelRequest(final Index index, final IndexMetadata indexMetadata, final ClusterState currentState) {
import org.opensearch.cluster.service.ClusterService;
        tieringStatus = new TieringStatus(index.getName(), TIERING_IN_PROGRESS_STATUS, sourceTier, destinationTier, tieringStartTime);
    // TODO: Add TierActionMetrics field and its settings/initialization in the implementation PR
    ) {
     * Updates the metadata for an index after tiering operation completion.
            if (clusterState.routingTable().hasIndex(index)) {
    /** Validates the tiering request.
            if (allOnHot) {
     * Constructs a new TieringService.
        } catch (Exception e) {
    private void setJvmActiveUsageThresholdPercent(Integer jvmActiveUsageThresholdPercent) {
        final Index index
        Integer maxConcurrentTieringRequests,
                                logger.info(
                    break;
     * @param jvmActiveUsageThresholdPercent the JVM active usage threshold percent
        if (shardLevelStatus) {
                continue;
            // Update index settings version
            }
                    listener.onResponse(new ClusterStateUpdateResponse(true));
            maxConcurrentTieringRequests,
    }
                .settingsVersion(1 + indexMetadata.getSettingsVersion());
     */
     * This method provides a summary view of all active tiering operations in the cluster.
     * (HOT_TO_WARM or WARM_TO_HOT), as opposed to a terminal HOT/WARM state.
 * This service handles the movement of indices between different storage tiers
        final NodeEnvironment nodeEnvironment,
            } else {
            }
    /**
     *
                            }
        return IndexModule.TieringState.HOT_TO_WARM.name().equals(state) || IndexModule.TieringState.WARM_TO_HOT.name().equals(state);
import org.opensearch.cluster.node.DiscoveryNode;
    /** Returns the setting for max concurrent tiering requests. @return the max concurrent tiering requests setting */
            clusterService.submitStateUpdateTask(source, new ClusterStateUpdateTask(Priority.URGENT) {
                        index.getName()
                            )
            // All shards must be started on hot nodes before we re-enable writes
                    tieringIndices.remove(index);
        ClusterState clusterState,
        final ActionListener<ClusterStateUpdateResponse> listener,
     * @param index index to be tiered
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata).settings(indexSettingsBuilder);
     * @param index the index to check
                if (tieringState.toString().equals(indexTieringState)) {
                        validateTieringRequest(
            Settings.Builder indexSettingsBuilder = Settings.builder()
                    );
        this.shardLimitValidator = shardLimitValidator;
                        throw (RuntimeException) e.getCause();
    }
                }
                public void onFailure(String source, Exception e) {
            }
    protected TieringService(
        if (DiscoveryNode.isClusterManagerNode(settings)) {
     * @param tieringEntries the tiering entries
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
            final String source = "cancel " + getTieringSourceType(getTargetTieringState());
     * @param allocationService the allocation service
            );
        final IndexTieringRequest request,
                public void onFailure(String source, Exception e) {
     * @throws IllegalArgumentException if the specified index has no active migrations
                        );
        long tieringStartTime = getTieringStartTime(clusterService.state(), index, getTieringStartTimeKey());
                    } catch (TieringRejectionException e) {
        // Update cluster state for completed indices, we use NORMAL priority here.
                    }
    /** Returns the index tier settings to restore after cancellation. @return the settings to restore */
import java.util.Map;
     * Performs common validations for tiering cancel request.
        // on a newly elected cluster-manager; until it is rebuilt from cluster state
 *
                @Override
                                ClusterBlocks.builder().blocks(currentState.blocks()),
        }
            // Must be in HOT state (cancel succeeded) with write block still present
                    return request.clusterManagerNodeTimeout();
                    Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
                        () -> new ParameterizedMessage(
     * @param indexMetadata current metadata of the index
            throw new IllegalArgumentException("Index [" + index + "] is not currently undergoing tiering operation");
                    )
            Map<String, String> tieringCustomData = new HashMap<>();
                    tieringIndices.add(index);
    /** The cluster service. */
    protected final IndexNameExpressionResolver indexNameExpressionResolver;
                );
        // (reconstructInProgressTieringRequests), the persisted INDEX_TIERING_STATE is what lets cancel
            return;
                }
                .settings(indexSettingsBuilder)
            clusterInfoService,
     *
