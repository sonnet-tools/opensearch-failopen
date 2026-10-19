    }
     */
                @Override
                @Override
    }
                    );
                    return;
                }
     * the registration version deserializes it as a generic wrapper — detection also matches
                    + "] after "
     */
                try {
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)
import org.opensearch.storage.common.tiering.TieringUtils;
            indexNameExpressionResolver,
import org.opensearch.cluster.metadata.Metadata;
        ActionListener<AcknowledgedResponse> listener,
                        } else {
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata()).put(indexMetadataBuilder);
import static org.opensearch.storage.common.tiering.TieringUtils.resolveRequestIndex;
 */
            clusterService,
                        return;
                    if (indexMetadata == null) {
                            + " shard(s) failed for other reasons. "
            threadPool,
            @Override
                    int otherFailureCount = 0;
     * {@code blocks.write} setting (persisted in index metadata, cleanly reverted on cancel/failure) and
                    executePrepareTiering(request, newState, listener, 1);
                            "Pre-tiering sync attempt [{}/{}] had {} failed shard(s) for index [{}], retrying",
                );
        HotToWarmTieringService hotToWarmTieringService,
                        return currentState;
                    + request.getIndex()
        );
    /**
     * Best-effort — if this fails, the user can manually remove the block via index settings.
                }
                        // Mixed failures
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * {@link MergeDrainTimeoutException#MERGE_DRAIN_TIMEOUT_MARKER} in the (always wire-preserved)
            addWriteBlockAndPrepare(request, state, listener);
    ) {
import org.apache.logging.log4j.Logger;
                            otherFailureCount++;
        executePrepareTiering(request, state, listener, attempt + 1);
                // (the index is moving to warm). The try/catch still covers a synchronous throw before the
            .settings(indexSettingsBuilder)
                        if (timeoutMessage != null) {
     */
        } else {
     * the persisted {@code index.blocks.write} setting (and bumps {@code settingsVersion}) only when it
    }
            // Validate FIRST — before any state-mutating or expensive operations.
                    IndexMetadata indexMetadata = currentState.metadata().index(indexName);
    /**
    @Inject
                    }
            }
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                    TransportHotToWarmTierAction.super.clusterManagerOperation(request, state, tierListener);
                            + " shard(s) still waiting for merges to drain after "
                            + mergeTimeoutCount
                    DefaultShardOperationFailedException[] failures = broadcastResponse.getShardFailures();
                    );
                    if (attempt < MAX_PREPARE_RETRIES) {
            super.clusterManagerOperation(request, state, listener);
            t = t.getCause();
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                            + " attempts. Example: "
    ) {
                    logger.warn(
        });
        if (IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.get(indexMetadata.getSettings()) == blockWrites) {
            logger.info("Index [{}] is a DFA index, adding write block and performing pre-tiering sync", request.getIndex());
                            + mergeTimeoutSampleMessage;
        );
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        IndexTieringRequest request,
        }
                    return applyWriteBlock(currentState, indexMetadata, false);
                }
     * Removes the write block from the index.
                @Override
            // reject immediately without adding a write block or running prepare.
                    failAndRemoveWriteBlock(request.getIndex(), e, listener);
     * Terminal-failure cleanup for the tiering flow: removes the write block (so the index is not left
        TransportPrepareTieringAction prepareTieringAction
    // idempotency invariant directly (no settingsVersion bump when the setting is unchanged).
                }
        if (TieringUtils.isDfaIndex(state.metadata().index(request.getIndex()))) {
            }
                    // MERGE_DRAIN_TIMEOUT_MARKER in the (always wire-preserved) message.
     * serialization (see {@code OpenSearchServerException}) and round-trips as a typed exception
        clusterService.submitStateUpdateTask(
    private final HotToWarmTieringService hotToWarmTieringService;
                    listener::onResponse,
                    failAndRemoveWriteBlock(request.getIndex(), new IllegalStateException(errorMsg), listener);
import org.opensearch.threadpool.ThreadPool;
                return message;
                }
                // listener is ever invoked. removeWriteBlock is idempotent, so there is no double-removal risk.
 * For DFA (pluggable data format) indices, this action:
        super(
        prepareTieringAction.execute(prepareTieringRequest, new ActionListener<BroadcastResponse>() {
     * Detection is primarily by type: {@link MergeDrainTimeoutException} is registered for
                    }
                        "Pre-tiering sync attempt [{}/{}] failed for index [{}], retrying: {}",
                            + " attempts: "
    private void executePrepareTiering(
                @Override
                        // sample's message already carries shard id, merge counts, and the timeout).
     * @param indexNameExpressionResolver the index name expression resolver
                    logger.error(errorMsg);
                        // No merge timeouts — generic message with first failure details
        );
                    logger.info("Write block added for index [{}], proceeding with pre-tiering sync", request.getIndex());
                    e -> failAndRemoveWriteBlock(request.getIndex(), e, listener)
     */
 * this file be licensed under the Apache-2.0 license or a
                @Override
                        errorMsg = "Pre-tiering sync failed for index ["
import org.opensearch.cluster.ClusterStateUpdateTask;
                    IndexMetadata indexMetadata = currentState.metadata().index(request.getIndex());
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    return;
                                mergeTimeoutSampleMessage = timeoutMessage;
     */
import org.opensearch.core.index.Index;
 * 3. Proceeds with the tiering operation
        throws Exception {
        listener.onFailure(e);
import org.opensearch.action.support.ActionFilters;
                            + " shard(s) timed out waiting for merges, "
        ClusterState state,
            return ClusterState.builder(currentState).blocks(blocks).build();
                public ClusterState execute(ClusterState currentState) {
                    if (indexMetadata == null) {
            @Override
     * message.
                        );
    }
                public ClusterState execute(ClusterState currentState) {
        return ClusterState.builder(currentState).metadata(metadataBuilder).blocks(blocks).build();
     * between nodes running 3.8.0+. As a fallback for mixed-version clusters — where a peer older than
                    // cancel/failure) and apply the INDEX_WRITE_BLOCK cluster block (enforced immediately).
                    listener.onFailure(
import org.opensearch.cluster.metadata.IndexMetadata;
            }
                    // running 3.8.0+. As a fallback for mixed-version clusters — where a peer older than
        } else {
        // Use the cluster setting for timeout instead of the short AcknowledgedRequest default (30s).
                // The tier step (super.clusterManagerOperation) runs an async cluster-state update and
    public TransportHotToWarmTierAction(
                public void onFailure(String source, Exception e) {
            public void onResponse(BroadcastResponse broadcastResponse) {
                hotToWarmTieringService.preflightValidate(state, index);
     * @param blockWrites   {@code true} to block writes, {@code false} to unblock
                        throw new IllegalStateException("Index [" + request.getIndex() + "] not found");
        TransportService transportService,
                    logger.warn(
                            + MAX_PREPARE_RETRIES
                            + MAX_PREPARE_RETRIES
                            broadcastResponse.getFailedShards(),
            .put(indexMetadata.getSettings())
                String errorMsg = "Pre-tiering sync failed for DFA index ["
                if (broadcastResponse.getFailedShards() > 0) {
     * @param threadPool the thread pool
        // This controls both the transport channel timeout and the merge drain timeout on the data node.
            }
                            + indexName
import org.opensearch.common.Priority;
     * On success, proceeds to step 3 (tier).
                // the write block on failure (sync OR async). On success the block is intentionally retained
 * SPDX-License-Identifier: Apache-2.0
                            + "] after tiering failure. The block can be removed manually via index settings.",
    /**
                    + MAX_PREPARE_RETRIES
        ActionFilters actionFilters,
 */
     * @param actionFilters the action filters
            blocks.removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
            public void onFailure(Exception e) {
                    // (see OpenSearchServerException) and round-trips as a typed exception between nodes
    private void addWriteBlockAndPrepare(IndexTieringRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener) {
                listener.onFailure(e);
        IndexNameExpressionResolver indexNameExpressionResolver,
 *
     * On final failure, removes the write block to avoid leaving the index in a stuck, write-blocked state.
                            mergeTimeoutCount++;
    @Override
            }
                            }
import org.opensearch.storage.tiering.HotToWarmTieringService;
                        }
     *
/*
     * stuck in a write-blocked state) and then fails the listener. Co-locating the two steps ensures
                    logger.error(() -> "Failed to add write block for index [" + request.getIndex() + "]", e);
    /**
     * Retries the prepare tiering action with an incremented attempt counter.
                            + "First failure: "
    static ClusterState applyWriteBlock(ClusterState currentState, IndexMetadata indexMetadata, boolean blockWrites) {
                    retryPrepareTiering(request, state, listener, attempt);
            // Note: validation also runs inside TieringService.tier() for double-safety.
                            if (mergeTimeoutSampleMessage == null) {
                logger.info("Preflight validation failed for DFA index [{}]: {}", request.getIndex(), e.getMessage());
        ThreadPool threadPool,
 * Transport Tiering action to move indices from hot to warm.
                    logger.info("Write block removed for index [{}] after tiering failure", indexName);
import org.opensearch.common.settings.Settings;
                            + request.getIndex()
    private void failAndRemoveWriteBlock(String indexName, Exception e, ActionListener<AcknowledgedResponse> listener) {
                            + "] after "
     * proceeds to step 2 (prepare tiering).
     * @return the updated cluster state
import org.opensearch.cluster.service.ClusterService;
            blocks.addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
     * @param indexMetadata the (non-null) metadata of the index to update
            "add-write-block-for-tiering [" + request.getIndex() + "]",
                        e
                            + "Consider increasing cluster.tiering.prepare_timeout or retry later.";
                    }
                            + request.getIndex()
     * @param hotToWarmTieringService the hot to warm tiering service
                }
                Index index = resolveRequestIndex(indexNameExpressionResolver, request.getIndex(), state);
        while (t != null && depth++ < 10) {
                            MAX_PREPARE_RETRIES,
    private static final int MAX_PREPARE_RETRIES = 3;
import org.opensearch.action.support.broadcast.BroadcastResponse;
public class TransportHotToWarmTierAction extends TransportTierAction {
     * the {@link IndexMetadata#INDEX_WRITE_BLOCK} cluster block (enforced immediately). On success,
            "remove-write-block-for-tiering [" + indexName + "]",
                } catch (Exception e) {
    private final TransportPrepareTieringAction prepareTieringAction;
            hotToWarmTieringService
 * 2. Performs pre-tiering sync (flush + refresh + remote store sync) on all primary shards
                        errorMsg = "Tiering preparation timed out: "
        ClusterState state,
                        // All failures are merge drain timeouts — surface the per-shard detail (the
     * @param transportService the transport service
                    int mergeTimeoutCount = 0;
                    } else {
                            + broadcastResponse.getFailedShards()
                failAndRemoveWriteBlock(request.getIndex(), new IllegalStateException(errorMsg, e), listener);
        this.prepareTieringAction = prepareTieringAction;
    }
                logger.info("Pre-tiering sync completed for index [{}], proceeding with tiering", request.getIndex());
                // reports failure via listener.onFailure, not by throwing — so wrap the listener to remove
    protected void clusterManagerOperation(IndexTieringRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener)
                }
    }
                    // Build a targeted error message based on failure type. A MergeDrainTimeoutException
        return null;
                        errorMsg = "Pre-tiering sync failed for index ["
     * actually changes. Skipping the no-op rewrite avoids bumping {@code settingsVersion} without a real
import org.apache.logging.log4j.LogManager;
                            ? "unknown"
        int attempt
                        new IllegalStateException("Failed to add write block for DFA index [" + request.getIndex() + "]. Please retry.", e)
package org.opensearch.storage.action.tiering;
                    );
            try {
                public void onFailure(String source, Exception e) {
     */
     * Walks a failure's cause chain (bounded depth) looking for a merge-drain timeout and returns its
                            + otherFailureCount
     * Idempotently drives the index's write block to the desired state. Always (re)asserts the
                    }
        final String indexName = indexMetadata.getIndex().getName();
        ClusterService clusterService,
                if (attempt < MAX_PREPARE_RETRIES) {
            HotToWarmTierAction.NAME,
    private static String findMergeDrainTimeout(Throwable t) {
                return;
            new ClusterStateUpdateTask(Priority.URGENT) {
            }
        prepareTieringRequest.timeout(TieringUtils.PREPARE_TIERING_TIMEOUT.get(clusterService.getSettings()));
        removeWriteBlock(indexName);
            final String message = t.getMessage();
    /**
    /**
    }
                        retryPrepareTiering(request, state, listener, attempt);
                    // the registration version deserializes it as a generic wrapper — detection also matches
        ActionListener<AcknowledgedResponse> listener,
     * Step 1: write-block the DFA index so no new writes land during prepare. Applies both the
        this.hotToWarmTieringService = hotToWarmTieringService;
/**
        int attempt
                            request.getIndex()
     * Constructs a TransportHotToWarmTierAction.
                        MAX_PREPARE_RETRIES,
        IndexTieringRequest request,
            }
                        () -> "Failed to remove write block for index ["
                return t.getMessage();
            // If validation fails (e.g. warm nodes full, too many concurrent requests),
        clusterService.submitStateUpdateTask(
    }
     * @param clusterService the cluster service
    // Package-private (not private) so unit tests in the same package can exercise the
     * detail message, or {@code null} if none is found.
                            + mergeTimeoutCount
                    String errorMsg;
            .settingsVersion(1 + indexMetadata.getSettingsVersion());
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.ClusterState;
                            + " shard(s) failed. "
        }
                }
     * Called on prepare failure to avoid leaving the index in a stuck write-blocked state.
     * every failure exit removes the block. {@link #removeWriteBlock} is idempotent, so calling this
     * <p>
                    // is detected primarily by instanceof: the type is registered for serialization
        int depth = 0;
        PrepareTieringRequest prepareTieringRequest = new PrepareTieringRequest(request.getIndex());
            transportService,
                            + MAX_PREPARE_RETRIES
        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
                    String mergeTimeoutSampleMessage = null;
                    } else if (mergeTimeoutCount > 0) {
     * @param prepareTieringAction the prepare tiering action for DFA indices
                            + ". Please retry.";
import org.opensearch.cluster.block.ClusterBlocks;
    private void retryPrepareTiering(
                @Override
 * The OpenSearch Contributors require contributions made to
                    + " attempts. Please retry.";
                            + " attempts: "
                        String timeoutMessage = findMergeDrainTimeout(f.getCause());
        Settings.Builder indexSettingsBuilder = Settings.builder()
     * more than once for the same index is safe.
                    if (mergeTimeoutCount > 0 && otherFailureCount == 0) {
                        String firstFailure = failures.length == 0
     * {@link IndexMetadata#INDEX_WRITE_BLOCK} cluster block to match {@code blockWrites}, but rewrites
    private static final Logger logger = LogManager.getLogger(TransportHotToWarmTierAction.class);
                    for (DefaultShardOperationFailedException f : failures) {
     */
            actionFilters,
        if (blockWrites) {
                            attempt,
        // Setting already matches the desired state — only (re)assert the cluster block, no version bump.
                        attempt,
                    // Block writes before pre-tiering sync: persist blocks.write (revertible on
        }
 * compatible open source license.
            } catch (Exception e) {
            if (message != null && message.contains(MergeDrainTimeoutException.MERGE_DRAIN_TIMEOUT_MARKER)) {
                        request.getIndex(),
    }
    /**
    ) {
                logger.error(errorMsg, e);
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), blockWrites);
     * Common retry logic extracted from onResponse (shard failures) and onFailure (transport failures).
}
     */
 * 1. Adds a write block to prevent new writes
     *
    private void removeWriteBlock(String indexName) {
     * Step 2: Execute the prepare tiering action (flush + refresh + waitForRemoteStoreSync) on primary shards.
                ActionListener<AcknowledgedResponse> tierListener = ActionListener.wrap(
                        e
                            + "] after "
import org.opensearch.common.inject.Inject;
 * Non-DFA indices skip steps 1 and 2 and go directly to tiering.
     * settings change, which would violate the {@code IndexService.updateMetadata} invariant.
                    return applyWriteBlock(currentState, indexMetadata, true);
     * @param currentState  the current cluster state
        }
    /**
            if (t instanceof MergeDrainTimeoutException) {
                            : (failures[0].getCause() != null ? failures[0].getCause().getMessage() : "unknown");
                    }
 *
            new ClusterStateUpdateTask(Priority.URGENT) {
     * Retries up to MAX_PREPARE_RETRIES times on shard failures before giving up.
                            + firstFailure
                        logger.warn(
                }
import org.opensearch.core.action.ActionListener;
