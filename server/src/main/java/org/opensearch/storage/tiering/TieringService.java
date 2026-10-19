        Integer maxConcurrentTieringRequests,  
    /**
        final IndexTieringRequest request,
        final ActionListener<ClusterStateUpdateResponse> listener,  
        this.fileCacheSettings = new FileCacheSettings(settings, clusterService.getClusterSettings());  
                continue;  
     * Returns true if the index's persisted tiering state indicates a migration is in progress
     * @param clusterService the cluster service
                        if (indexMetadata == null) continue;  
                        String tieringState = indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey(), "");
            return;
        try {
    /** Returns the setting for max concurrent tiering requests. @return the max concurrent tiering requests setting */  
                    updateIndexMetadataForTieringStart(metadataBuilder, routingTableBuilder, indexMetadata, index);
        if (indexMetadata == null) {
    }  
                            request.getIndex()
import org.opensearch.storage.action.tiering.CancelTieringRequest;
                        .blocks(
        final String state = indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT.name());
        }
                final String[] indices = new String[] { index.getName() };  
            int currentReplicas = Integer.parseInt(indexMetadata.getSettings().get(INDEX_NUMBER_OF_REPLICAS_SETTING.getKey()));
     * @param state current cluster state
     */
                @Override
     */  
                logger.debug(
 * SPDX-License-Identifier: Apache-2.0
    /**
                }
                    final IndexMetadata indexMetadata = currentState.metadata().index(index);
import java.util.Locale;  
     * Updates the metadata for an index after tiering operation completion.
    /**
import java.util.HashMap;  
            Settings.Builder indexSettingsBuilder = Settings.builder()
    public List<TieringStatus> listTieringStatus() {
     * @param requestIndex The name of the index to check
        );
                    final Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
     *
     * @param tieringEntries the tiering entries  
        logger.info(() -> String.format(Locale.ROOT, "[%s] initiating reconstruction of in-progress migration requests", source));
        final ClusterService clusterService,
import org.opensearch.storage.common.tiering.TieringRejectionException;
     * @return TieringStatus object containing detailed status information
     */
                        "[%s] processing %d in-progress requests after routing table update",
    }  
     *  
                shardRoutings = clusterState.routingTable().allShards(index.getName());
import org.opensearch.cluster.routing.RoutingTable;
     * @param maxConcurrentTieringRequests the max concurrent tiering requests
                        .metadata(metadataBuilder)
                    updateIndexMetadataForTieringCancel(metadataBuilder, indexMetadata);
        final AllocationService allocationService,
                @Override  
                .settingsVersion(1 + indexMetadata.getSettingsVersion());
        final Index index = resolveRequestIndex(indexNameExpressionResolver, requestIndex, clusterService.state());
            try {
        final RoutingTable.Builder routingTableBuilder,
                }  
    }
     *
            tieringIndices,  
                                indexMetadata  
        clusterState.metadata().indices().values().forEach(indexMetadata -> {  
        return isShardStateValidForTier(shard, clusterState, getTargetTieringState());
                tieringStatusList.add(constructTieringStatus(tieringIndex, false, false));  
        this.maxConcurrentTieringRequests = maxConcurrentTieringRequests;  
        if (!tieringIndices.contains(index) && !isMigrationInProgress(indexMetadata)) {
                || (event.blocksChanged()
                        );
    /**  
                }
}
 * The OpenSearch Contributors require contributions made to  
        }
                        index.getName()
    }
     * @param listener callback listener for the tiering operation
     * @param routingTableBuilder builder for updating routing table
     * @param source identifier for the tiering operation
    }  
        clusterSettings.addSettingsUpdateConsumer(JVM_USAGE_TIERING_THRESHOLD_PERCENT, this::setJvmActiveUsageThresholdPercent);  
    /** Returns the settings to add when tiering starts. @return the tiering start settings */
                    listener.onResponse(new ClusterStateUpdateResponse(true));
     * @return true if the index is being tiered
            throw new OpenSearchException("Failed to update index metadata for tiering start", e);
    ) {
    void validateTieringCancelRequest(final Index index, final IndexMetadata indexMetadata, final ClusterState currentState) {
    protected final IndexNameExpressionResolver indexNameExpressionResolver;
     * @param metadataBuilder builder for updating cluster metadata  
                            if (indexMetadata == null) {  
        // state shows a migration in progress. The in-memory set is per-cluster-manager and starts empty
                    ClusterState updatedState = stateBuilder.build();
            metadataBuilder.put(indexMetadataBuilder);
     */  
                .putCustom(TIERING_CUSTOM_KEY, tieringCustomData)
            metadataBuilder.put(indexMetadataBuilder);  
                                logger.info(
        } catch (Exception e) {
                    s -> (s.unassigned() && !s.primary())
    }  
     *   <li>{@code INDEX_TIERING_STATE=HOT} (cancel reverted the tier state)</li>
                    );
import org.opensearch.OpenSearchException;
        }  
                        () -> new ParameterizedMessage("Failed to complete task {} for indices [{}]", source, completedIndices),
     * Performs common validations for tiering cancel request.
                public void onFailure(String source, Exception e) {
    protected abstract ClusterBlocks.Builder getTieringStartClusterBlocksToAdd(  
            index  
        }  
                    return request.clusterManagerNodeTimeout();
        Set<Index> tieringEntries,
                .put(indexMetadata.getSettings())
                    );
                @Override
        validateTieringRequest(  
            } catch (Exception e) {
            Settings.Builder indexSettingsBuilder = Settings.builder()  
                continue;
                    // now, reroute to trigger shard relocation  
            if (!clusterState.routingTable().hasIndex(indexMetadata.getIndex())) {
    /** Returns the ClusterBlocks.Builder with tier-specific block changes for a cancel. Default is a no-op. */  
        clusterService.submitStateUpdateTask(  
                            getIndexTierClusterBlocksToRestoreAfterCancellation(
            }
                        );
            // Only act on indices that are NOT currently tiering  
                        () -> new ParameterizedMessage("Failed to remove write block after H2W cancel for indices {}", indicesToUnblock),  
        return IndexModule.TieringState.HOT_TO_WARM.name().equals(state) || IndexModule.TieringState.WARM_TO_HOT.name().equals(state);  
     * Initiates a tiering operation for an index.  
    public void clusterChanged(ClusterChangedEvent event) {
        Index index
                    for (Index index : completedIndices) {  
                                );  
     * Handles cluster changed events only on current master node to prevent duplicate updates
     */  
        for (Index tieringIndex : tieringIndices) {
            }  
                    ClusterBlocks.Builder blocksBuilder = ClusterBlocks.builder().blocks(currentState.blocks());  
        if (indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey(), "").equals(getTargetTieringState().toString())) {
            // 2. Build and update metadata
                throw new IllegalArgumentException("Index [" + requestIndex + "] has no active migrations");
                logger.info(  
     * @param clusterState current state of the cluster  
            }  
    protected final ClusterService clusterService;
        }  
            }  
     *  
     * @param settings the settings  
        final IndexMetadata indexMetadata,
                    index.getName(),  
                }
     */
                continue;  
                .put(INDEX_TIERING_STATE.getKey(), getTargetTieringState());  
        this.nodeId = nodeEnvironment.nodeId();  
    private static final String TIERING_IN_PROGRESS_STATUS = "RUNNING_SHARD_RELOCATION";
     * @param index index for tiering cancel request
package org.opensearch.storage.tiering;
            // 1. Build settings - remove tiering-specific settings and disable auto-expand.
                        .routingTable(routingTableBuilder.build())
        ClusterBlocks.Builder blocksBuilder,
                routingTableBuilder.updateNumberOfReplicas(1, indices);
     * @param completedIndices set of indices that have completed tiering
        ClusterState clusterState,  
     * @param jvmActiveUsageThresholdPercent the JVM active usage threshold percent
import org.opensearch.cluster.metadata.IndexMetadata;  
    public TieringStatus getTieringStatus(String requestIndex, Boolean isDetailedFlagEnabled) {
     * @param isDetailedFlagEnabled If true, includes detailed shard-level status information  
            // Update index metadata
                                index.getName(),
                    Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
     * @param request the tiering request containing index and tier information  
    ) {
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING;  
                if (isShardInTargetTier(shard, clusterState) == false) {
            tieringStatus.setShardLevelStatus(  
     * (HOT_TO_WARM or WARM_TO_HOT), as opposed to a terminal HOT/WARM state.
                completedInBatch.add(index);
    private void updateClusterStateForTieredIndices(final Set<Index> completedIndices, final String source) {
        TieringStatus tieringStatus;  
     *   <li>The index is a DFA index</li>  
                }  
            String tieringState = indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey(), "");
    ) {
    /**  
import static org.opensearch.storage.common.tiering.TieringUtils.getTieringStartTime;
        );
                .put(indexMetadata.getSettings())
    /**  
     * Setting to avoid fileCacheUsage overload while accepting tiering requests .  
            updateClusterStateForTieredIndices(completedInBatch, source);
    }
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                    logger.error(  
        );
                "Index [" + index + "] already reached its target tier: " + getTargetTieringState() + ". Cannot cancel tiering"
     * Handles common metadata updates while allowing specific validations per implementation.
        // reach a mid-migration index. (The cluster state itself is durable and not lost across failover.)
                indexSettingsBuilder.put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1);
        final CancelTieringRequest request,
                        e  
                            updateIndexMetadataPostTiering(metadataBuilder, indexMetadata);
     * @param index index to be tiered
        String indexName,  
                reconstructInProgressTieringRequests(event.state(), getTieringType(), source);
     * Runs tiering validation synchronously before any cluster state mutation.
     */
                        );
     */
     * Checks if the given index is currently being tiered.  
                }  
                deletedIndices.add(index);
    }
        }
        IndexMetadata indexMetadata
     *
                public void onFailure(String source, Exception e) {  
        try {
                        () -> String.format(Locale.ROOT, "[%s] added index [%s] to in-progress migration tracking", source, index.getName())
            // All shards must be started on hot nodes before we re-enable writes
     * @param clusterState the cluster state
                    )  
        }
                        }
     * Updates the cluster state for indices that have completed tiering.
    void processTieringInProgress(final ClusterState clusterState, final String source) {  
     * @param event cluster state change event
    private void setMaxConcurrentTieringRequests(Integer maxConcurrentTieringRequests) {
                                .settingsVersion(1 + indexMetadata.getSettingsVersion())
    /** Returns the target tiering state. @return the target tiering state */  
                @Override
 * compatible open source license.
        final ClusterState clusterState,
    @Override  
    /** The index name expression resolver. */
                }
import java.util.concurrent.ConcurrentHashMap;  
import org.opensearch.cluster.ClusterInfoService;  
                    destinationTier
    /**  
                @Override  
                    ClusterState.Builder stateBuilder = ClusterState.builder(currentState)
     * <p>Called on every routing-table or metadata change. It removes the block only when:  
                    return ClusterState.builder(currentState).metadata(metadataBuilder).blocks(blocksBuilder).build();  
                            )
                            )
     */  
    private Integer jvmActiveUsageThresholdPercent;
                TieringStatus.ShardLevelStatus.fromRoutingTable(
                        tieringIndices.size()
                    logger.info(  
    private Integer maxConcurrentTieringRequests;
                                .settings(settingsBuilder)  
        } catch (Exception e) {
        } catch (Exception e) {  
    protected ClusterBlocks.Builder getIndexTierClusterBlocksToRestoreAfterCancellation(
            "complete " + source + " for indices: " + completedIndices,
                .put(getTieringStartSettingsToAdd(indexMetadata));
    }
                    // Trigger reroute to move shards back to original state
                    tieringIndices.add(index);
                    isDetailedFlagEnabled,
     * @param indexNameExpressionResolver the index name expression resolver  
            jvmActiveUsageThresholdPercent,
                        Locale.ROOT,
     *
     * This method reverts the changes made during tiering start to restore the index to its original state.
                public void onFailure(String source, Exception e) {
                public ClusterState execute(ClusterState currentState) {  
        try {
        tieringIndices.removeAll(deletedIndices);  
                @Override
     * Implementation should handle tier-specific initialization.
            throw new OpenSearchException("Failed to update index metadata for tiering cancellation", e);
import org.opensearch.cluster.routing.allocation.DiskThresholdSettings;
 *
    /**  
                @Override
                        if (!IndexModule.TieringState.HOT.toString().equals(tieringState) || !hasWriteBlock) {
                                ClusterBlocks.builder().blocks(currentState.blocks()),
     * @param listener callback listener for the cancel operation
    /** The node ID. */
     */
import static org.opensearch.storage.common.tiering.TieringUtils.JVM_USAGE_TIERING_THRESHOLD_PERCENT;  
import org.opensearch.cluster.routing.allocation.AllocationService;  
     */  
            }  
     * This method reverts the index settings and triggers reroute to move shards back to their original state.
    // TODO: Add TierActionMetrics field and its settings/initialization in the implementation PR  
                    try {
    }
        String destinationTier = tiers[1];
     * This method submits a cluster state update task to mark the tiering operation as complete.
    public void tier(
        String[] tiers = getTierPairForTargetTier(getTargetTieringState());  
     * @param source identifier for the tiering operation
                    }  
            boolean allShardRelocationComplete = true;  
                    logger.info(
            "remove-write-block-after-h2w-cancel for " + indicesToUnblock,
                        Locale.ROOT,
                    () -> String.format(  
                public TimeValue timeout() {
                            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), false);  
                    final Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
     * @param allocationService the allocation service
     * Determines if a shard is located in its target tier.
        Set<Index> completedInBatch = new HashSet<>();
    }
     * Set threshold of maximum JVM Usage Threshold over target tier nodes
        final ShardLimitValidator shardLimitValidator  
    protected boolean isShardInTargetTier(final ShardRouting shard, final ClusterState clusterState) {
                        .routingTable(routingTableBuilder.build())
    private static boolean isMigrationInProgress(final IndexMetadata indexMetadata) {
 */  
        return tieringStatus;  
                    tieringIndices.add(index);
            );
                    for (Index index : indicesToUnblock) {
        Set<Index> deletedIndices = new HashSet<>();
        }
        IndexMetadata indexMetadata  
        final IndexModule.TieringState tieringState,
        // Update cluster state for completed indices, we use NORMAL priority here.
        setMaxConcurrentTieringRequests(clusterSettings.get(getMaxConcurrentTieringRequestsSetting()));
                        }  
            }
     */
            if (currentReplicas != 1) {
    protected abstract Setting<Integer> getMaxConcurrentTieringRequestsSetting();
     * @param index the index to check
        ClusterBlocks.Builder blocksBuilder,
     * @param request the cancel tiering request  
import org.opensearch.env.NodeEnvironment;
        final ClusterInfoService clusterInfoService,
                @Override  
                        e
            clusterService.submitStateUpdateTask(source, new ClusterStateUpdateTask(Priority.IMMEDIATE) {
import org.opensearch.core.index.Index;  
                        IndexMetadata indexMetadata = currentState.metadata().index(index);
    }
            if (event.routingTableChanged() && tieringIndices.isEmpty() == false) {
        String sourceTier = tiers[0];
                            jvmActiveUsageThresholdPercent,
                    listener.onFailure(e);
        clusterService.submitStateUpdateTask(  
     *
     */
        final ClusterState state
 * Abstract base class for managing tiering operations in OpenSearch.  
     * Updates index metadata when cancelling a tiering operation.  
    private TieringStatus constructTieringStatus(Index index, boolean shardLevelStatus, boolean isDetailedFlagEnabled) {
    /** The set of indices currently being tiered. */
/*  
        }  
            // 3. Create tiering custom data
                logger.error("Failed to process index [{}] during reconstruction. Error: {}", indexMetadata.getIndex().getName(), e);
            // Build settings  
                                index.getName(),  
    /** Validates the tiering request.  
                continue;
                removeWriteBlockForCancelledDfaIndices(event.state());
                    logger.info(() -> String.format(Locale.ROOT, "Successfully initiated %s for index [%s]", source, index.getName()));
            final Index index = resolveRequestIndex(indexNameExpressionResolver, request.getIndex(), state);
                    }
        setJvmActiveUsageThresholdPercent(clusterSettings.get(JVM_USAGE_TIERING_THRESHOLD_PERCENT));
            clusterInfoService,
/**
        this.allocationService = allocationService;
            if (event.previousState().nodes().isLocalNodeElectedClusterManager() == false
     *   <li>{@code INDEX_BLOCKS_WRITE=true} (block still set from H2W preparation)</li>
            metadataBuilder.put(indexMetadataBuilder);
     * Processes pending tiering requests by checking the status of shard relocations  
     * @param index index to be tiered  
     */  
    protected final DiskThresholdSettings diskThresholdSettings;
    protected final FileCacheSettings fileCacheSettings;
                }
import org.opensearch.storage.action.tiering.IndexTieringRequest;  
 * this file be licensed under the Apache-2.0 license or a
        this.indexNameExpressionResolver = indexNameExpressionResolver;
     * Retrieves the tiering status for a specific index.
        Set<Index> indicesToUnblock = new HashSet<>();
     * Retrieves a list of tiering status for all indices currently undergoing tiering operations.
                    final RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());  
                    logger.info(() -> String.format(Locale.ROOT, "Cluster state updated successfully for task %s", source));
     * @return List of TieringStatus objects, each representing the status of an ongoing tiering operation
                @Override  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        for (Index index : tieringIndices) {
                @Override
        }
import java.util.ArrayList;
    /** Returns the ClusterBlocks.Builder with tier-specific block changes for tier start. Only called for DFA indices. */
                        () -> String.format(
                        || (s.started() && isShardStateValidForTier(s, clusterState, IndexModule.TieringState.HOT))  
        } catch (Exception e) {  
                    clusterService.state(),
                            "Failed to update cluster state update for {} for index [{}]",
        }  
     */  
        this.jvmActiveUsageThresholdPercent = jvmActiveUsageThresholdPercent;
            }
    /** Returns the key for tiering start time. @return the tiering start time key */  
    protected abstract Settings getTieringStartSettingsToAdd(IndexMetadata indexMetadata);  
            if (!TieringUtils.isDfaIndex(indexMetadata)) {
                            Locale.ROOT,  
     * <p>Note: validation also runs inside the cluster state task (in {@link #tier}) for
                    return allocationService.reroute(updatedState, source);
    /**
            final String source = getTieringSourceType(request);
import static org.opensearch.storage.common.tiering.TieringUtils.TIERING_CUSTOM_KEY;
                continue;
                        return currentState;  
        return tieringIndices.contains(index);
                    logger.error(  
                    && !event.state().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK))) {
            if (currentReplicas != 1) {  
                    }
        }
     * Updates index metadata and routing table at the start of a tiering operation.  
                    validateTieringCancelRequest(index, indexMetadata, currentState);
                            source,  
    void updateIndexMetadataPostTiering(final Metadata.Builder metadataBuilder, final IndexMetadata indexMetadata) {
        }  
            // 4. Build and update metadata
                    ClusterState updatedState = stateBuilder.build();
    /** The cluster info service. */
                )  
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
                            clusterInfoService,
            try {
        ClusterInfoService service,
            if (tieringIndices.contains(indexMetadata.getIndex())) {
        final IndexNameExpressionResolver indexNameExpressionResolver,  
    /** Returns the index tier settings to restore after cancellation. @return the settings to restore */
        final ClusterState state
                        .metadata(metadataBuilder)  
    }
                        e
    protected final Set<Index> tieringIndices;  
            final String source = "cancel " + getTieringSourceType(getTargetTieringState());
            });
            boolean allOnHot = shards.stream()  
import org.opensearch.indices.ShardLimitValidator;
                                    () -> String.format(Locale.ROOT, "Index [%s] not found while completing %s", index.getName(), source)
     * operations (flush, remote store sync) from running when validation would reject the request.
        ClusterSettings clusterSettings = clusterService.getClusterSettings();  
            tieringCustomData.put(getTieringStartTimeKey(), String.valueOf(System.currentTimeMillis()));  
            return false;  
     * double-safety against TOCTOU races. This preflight call is an additional early gate.
                        Settings.Builder settingsBuilder = Settings.builder()
        if (currentState.routingTable().hasIndex(index) == false) {
    protected TieringService(
                logger.info(() -> String.format(Locale.ROOT, "Index [%s] deleted before %s completion", index.getName(), source));
            }
    /** Returns the tiering type (in-progress state). @return the tiering type */  
            List<ShardRouting> shardRoutings;  
    protected abstract Settings getIndexTierSettingsToRestoreAfterCancellation(IndexMetadata indexMetadata);  
        return blocksBuilder;  
        final Settings settings,  
                    } catch (TieringRejectionException e) {
     * @param metadataBuilder builder for updating cluster metadata  
                    )
            // Must be in HOT state (cancel succeeded) with write block still present
    protected final ClusterInfoService clusterInfoService;  
     * @param service the cluster info service
        clusterSettings.addSettingsUpdateConsumer(getMaxConcurrentTieringRequestsSetting(), this::setMaxConcurrentTieringRequests);
            }
     */  
                            currentState,
            indexMetadataBuilder.removeCustom(TIERING_CUSTOM_KEY);
            });
            if (allOnHot) {
    /**
                );
            }
     * @param state current cluster state at the time of the request
    /** The allocation service. */  
    }
    protected final AllocationService allocationService;
            logger.debug(() -> String.format(Locale.ROOT, "Updating cluster state for indices: [%s]", completedInBatch));
     */
                    listener.onResponse(new ClusterStateUpdateResponse(true));  
                .settingsVersion(1 + indexMetadata.getSettingsVersion());  
            maxConcurrentTieringRequests,
     *  
        final List<TieringStatus> tieringStatusList = new ArrayList<>();
import org.opensearch.index.store.remote.filecache.FileCacheSettings;  
                    }
     * @param currentState current cluster state  
import java.util.List;
        }
            boolean hasWriteBlock = INDEX_BLOCKS_WRITE_SETTING.get(indexMetadata.getSettings());  
                    && event.previousState().blocks().hasGlobalBlock(STATE_NOT_RECOVERED_BLOCK)  
                public TimeValue timeout() {
                .settings(indexSettingsBuilder)
     * including source and target tiers, start time, and shard-level status.  
    private void removeWriteBlockForCancelledDfaIndices(final ClusterState clusterState) {  
                return constructTieringStatus(index, true, isDetailedFlagEnabled);  
     * </ol>
        for (IndexMetadata indexMetadata : clusterState.metadata()) {
            indexMetadataBuilder.settingsVersion(1 + indexMetadataBuilder.settingsVersion());
import org.opensearch.cluster.ClusterState;
            new ClusterStateUpdateTask(Priority.NORMAL) {
            listener.onFailure(e);
                                indexMetadata
    /**
        }
     *  
        this.tieringIndices = ConcurrentHashMap.newKeySet();
     *
     */
    public void preflightValidate(final ClusterState state, final Index index) {
import org.opensearch.common.settings.Setting;
                        () -> new ParameterizedMessage(
            // 2. Handle replica updates if needed
    ) {
import static org.opensearch.gateway.GatewayService.STATE_NOT_RECOVERED_BLOCK;
        if (tieringIndices.contains(index)) {
    protected abstract IndexModule.TieringState getTieringType();
                public ClusterState execute(ClusterState currentState) {
        // Only update cluster state once for all completed indices
 * and manages the cluster state updates during tiering operations.
            listener.onFailure(e);
                            getTieringSourceType(getTargetTieringState()),
        String indexName,
                    tieringIndices.remove(index);  
                    allShardRelocationComplete = false;  
                        // Re-check conditions inside the task to guard against TOCTOU
                if (tieringState.toString().equals(indexTieringState)) {  
                .put(indexMetadata.getSettings())
            // Update index settings version  
            Settings.Builder indexSettingsBuilder = Settings.builder()
                @Override  
     * Returns an empty list if no tiering operations are active
import org.opensearch.common.settings.Settings;  
    /**
    /**
    ) {
        } catch (Exception e) {  
     *  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_BLOCKS_WRITE_SETTING;
    /** The file cache settings. */  
                            IndexMetadata.builder(indexMetadata)
import org.opensearch.index.IndexModule;
                        validateTieringRequest(  
    /**
import org.apache.logging.log4j.message.ParameterizedMessage;  
    public boolean isIndexBeingTiered(Index index) {
                    for (Index index : completedIndices) {  
    void updateIndexMetadataForTieringStart(
     * Set maximum number of in-flight tiering indices  
     * @param indexMetadata current metadata of the index
    void reconstructInProgressTieringRequests(  
import org.opensearch.cluster.ClusterChangedEvent;
public abstract class TieringService implements ClusterStateListener {
                        blocksBuilder.removeIndexBlock(index.getName(), IndexMetadata.INDEX_WRITE_BLOCK);  
     * This method provides a summary view of all active tiering operations in the cluster.
                        source,
                            index  
     * Constructs a new TieringService.
    /**
import static org.opensearch.storage.common.tiering.TieringUtils.resolveRequestIndex;  
        this.shardLimitValidator = shardLimitValidator;
                    logger.error(
        if (event.localNodeClusterManager()) {  
                        ),
                                tieringIndices.remove(index);
                        tieringIndices.remove(index);
     *   <li>The index is NOT in {@code tieringIndices} (cancel completed, no active tiering)</li>
                    break;
            indexMetadataBuilder.removeCustom(TIERING_CUSTOM_KEY);
                        if (tieringIndices.contains(index)) {
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                indicesToUnblock.add(indexMetadata.getIndex());  
import org.opensearch.cluster.service.ClusterService;
        String source = getTieringSourceType(getTargetTieringState());
    protected abstract void validateTieringRequest(
        this.clusterInfoService = clusterInfoService;  
                            "Successfully cancelled [%s] tiering for index [%s]",
     * @param nodeEnvironment the node environment
import org.opensearch.cluster.ClusterStateListener;
     */  
    }
     * Controls maximum number of in-flight migrations.
                metadataBuilder.updateNumberOfReplicas(1, indices);
            }
     * @param index the index  
import org.opensearch.common.Priority;  
                    );
            if (!IndexModule.TieringState.HOT.toString().equals(tieringState) || !hasWriteBlock) {
    }  
            }  
                            maxConcurrentTieringRequests,
                    );  
                            index.getName()  
                        );  
        try {  
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata).settings(indexSettingsBuilder);  
     *  
        try {  
            logger.debug(() -> String.format(Locale.ROOT, "Checking if [%s] is complete for index: %s", source, index.getName()));
     * This method handles the cluster state updates required to start the tiering process.
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    );
    }  
                        boolean hasWriteBlock = INDEX_BLOCKS_WRITE_SETTING.get(indexMetadata.getSettings());  
import org.opensearch.cluster.node.DiscoveryNode;  
                        logger.info("Removed write block for DFA index [{}] after H2W cancel — all shards on hot", index.getName());
            // 3. Remove tiering custom metadata
                    listener.onFailure(e);
    protected final ShardLimitValidator shardLimitValidator;  
import org.opensearch.cluster.metadata.Metadata;
    private void setJvmActiveUsageThresholdPercent(Integer jvmActiveUsageThresholdPercent) {  
        }
        if (completedInBatch.isEmpty() == false) {  
            clusterService.addListener(this);
            throw new IllegalArgumentException("Index [" + index + "] deleted before tiering cancellation");
                        metadataBuilder.put(
import java.util.HashSet;
 * This service handles the movement of indices between different storage tiers
                    final Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata());
                @Override
                        source,  
     *
import static org.opensearch.storage.common.tiering.TieringUtils.getTierPairForTargetTier;
            }  
            for (ShardRouting shard : shardRoutings) {
import org.opensearch.cluster.ClusterStateUpdateTask;  
                @Override
     *   <li>All shards are {@code started} on HOT nodes (writable engine is live)</li>  
import org.opensearch.common.unit.TimeValue;
            new ClusterStateUpdateTask(Priority.NORMAL) {
     * Lifts the write block from DFA indices whose H2W cancel completed but the block was intentionally  
                    if (tieringIndices.contains(index)) {
import org.opensearch.cluster.block.ClusterBlocks;
                }  
            }  
        });
        this.diskThresholdSettings = new DiskThresholdSettings(settings, clusterService.getClusterSettings());
     * @param metadataBuilder builder for updating cluster metadata
            if (event.routingTableChanged()) {  
     * @throws RuntimeException if validation fails — same exceptions as thrown by {@link #validateTieringRequest}  
                            tieringIndices,  
                continue;
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
    }
import java.util.Set;
                .allMatch(
     * @param indexMetadata current metadata of the index
            throw new IllegalArgumentException(  
                    );
    protected abstract String getTieringStartTimeKey();
    /**
    );  
                processTieringInProgress(event.state(), source);
            List<ShardRouting> shards = clusterState.routingTable().allShards(indexMetadata.getIndex().getName());
                            }  
     * @throws IllegalArgumentException if the specified index has no active migrations
    public void cancelTiering(
        Integer jvmActiveUsageThresholdPercent,
                    return allocationService.reroute(updatedState, source);
    void updateIndexMetadataForTieringCancel(final Metadata.Builder metadataBuilder, final IndexMetadata indexMetadata) {  
        // on a newly elected cluster-manager; until it is rebuilt from cluster state
import org.opensearch.common.settings.ClusterSettings;
                            final IndexMetadata indexMetadata = currentState.metadata().index(index);
    /** The cluster service. */  
    protected abstract IndexModule.TieringState getTargetTieringState();
            }  
import org.apache.logging.log4j.LogManager;
                }
    ) {
     *  
                            getTieringStartClusterBlocksToAdd(  
                    ClusterState.Builder stateBuilder = ClusterState.builder(currentState)  
     * This method provides detailed information about an ongoing tiering operation
    /**  
        long tieringStartTime = getTieringStartTime(clusterService.state(), index, getTieringStartTimeKey());
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)  
                }  
            try {
     */  
            }  
                                continue;
                        .blocks(  
                    logger.error(() -> new ParameterizedMessage("Failed to cancel tiering for index [{}]", request.getIndex()), e);
            throw new OpenSearchException("Failed to update index metadata post tiering", e);
    }  
                public ClusterState execute(ClusterState currentState) {  
        final Index index  
            state,
     * @param shardLimitValidator the shard limit validator  
                );
            );
                }
import static org.opensearch.storage.common.tiering.TieringUtils.getTieringSourceType;  
import org.opensearch.storage.common.tiering.TieringUtils;  
    }  
        final String source  
        if (indicesToUnblock.isEmpty()) {  
                    final RoutingTable.Builder routingTableBuilder = RoutingTable.builder(currentState.routingTable());
     * @param clusterInfoService the cluster info service
        final NodeEnvironment nodeEnvironment,
     * @param indexMetadata current metadata of the index
                        throw (RuntimeException) e.getCause();  
                .put(getIndexTierSettingsToRestoreAfterCancellation(indexMetadata));  
                    Index index = indexMetadata.getIndex();
     * <ol>
    /**
                                ClusterBlocks.builder().blocks(currentState.blocks()),
                    () -> String.format(
                    return request.timeout();  
            if (clusterState.routingTable().hasIndex(index)) {
    /**
            }
        return tieringStatusList;
        throw new IllegalArgumentException("Index [" + requestIndex + "] has no active migrations");  
    /**  
     * read-only block or running pre-tiering sync. This prevents expensive and side-effecting
import static org.opensearch.storage.common.tiering.TieringUtils.isShardStateValidForTier;
            IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)  
            } catch (IllegalStateException e) {
        this.clusterService = clusterService;
            // 5. Update routing table if replicas were changed
     * @param indexMetadata current metadata of the index
            }  
                    }
     * @param state current cluster state
    private static final Logger logger = LogManager.getLogger(TieringService.class);  
                    return ClusterState.builder(currentState).metadata(metadataBuilder).build();
            throw new IllegalArgumentException("Index [" + index + "] is not currently undergoing tiering operation");  
                .settings(indexSettingsBuilder)
                public ClusterState execute(ClusterState currentState) {
                public void onFailure(String source, Exception e) {
    /** The disk threshold settings. */
     *
    /**
    protected final String nodeId;
        if (shardLevelStatus) {
import org.opensearch.cluster.routing.ShardRouting;
        tieringStatus = new TieringStatus(index.getName(), TIERING_IN_PROGRESS_STATUS, sourceTier, destinationTier, tieringStartTime);  
        // (reconstructInProgressTieringRequests), the persisted INDEX_TIERING_STATE is what lets cancel  
                }
     * Cancels an ongoing tiering operation for an index.  
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
            Map<String, String> tieringCustomData = new HashMap<>();
                    final IndexMetadata indexMetadata = currentState.metadata().index(index);
        final Metadata.Builder metadataBuilder,  
     * Status constant indicating that a tiering operation is currently executing shard relocation.
            } else {  
                }  
        if (DiscoveryNode.isClusterManagerNode(settings)) {  
     */  
     * <p>Used by the DFA (pluggable dataformat) tiering path to validate BEFORE adding the  
    }  
     * and updating the cluster state accordingly.
        // Accept the index as cancellable if it is tracked in the in-memory set OR its persisted tiering  
                        "Shard relocation for [%s] completed successfully for index [%s]",  
    /** The shard limit validator. */
            final Index index = resolveRequestIndex(indexNameExpressionResolver, request.getIndex(), state);
                );  
    /**
 */  
            // write-block settings only for DFA indices.  
        }
     * kept to prevent writes reaching warm-node shards that still run a read-only engine.
                            continue;
            if (allShardRelocationComplete) {
     */
import org.apache.logging.log4j.Logger;
                        )
                            .put(indexMetadata.getSettings())
import java.util.Map;
            clusterService.submitStateUpdateTask(source, new ClusterStateUpdateTask(Priority.URGENT) {
     */
        }
                String indexTieringState = indexMetadata.getSettings().get(INDEX_TIERING_STATE.getKey());
        final ActionListener<ClusterStateUpdateResponse> listener,  
            } catch (IllegalStateException e) {
    }
                }  
import org.opensearch.core.action.ActionListener;
