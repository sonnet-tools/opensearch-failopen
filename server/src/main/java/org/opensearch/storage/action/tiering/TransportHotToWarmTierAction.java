                            + broadcastResponse.getFailedShards()  
 * The OpenSearch Contributors require contributions made to  
    /**  
                        new IllegalStateException("Failed to add write block for DFA index [" + request.getIndex() + "]. Please retry.", e)
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            new ClusterStateUpdateTask(Priority.URGENT) {
                    e -> failAndRemoveWriteBlock(request.getIndex(), e, listener)  
        if (TieringUtils.isDfaIndex(state.metadata().index(request.getIndex()))) {
                    if (attempt < MAX_PREPARE_RETRIES) {  
                String errorMsg = "Pre-tiering sync failed for DFA index ["
            // Validate FIRST — before any state-mutating or expensive operations.  
        ActionListener<AcknowledgedResponse> listener,  
                            "Pre-tiering sync attempt [{}/{}] had {} failed shard(s) for index [{}], retrying",
                if (broadcastResponse.getFailedShards() > 0) {
                            + MAX_PREPARE_RETRIES
            }
            .settings(indexSettingsBuilder)
import static org.opensearch.storage.common.tiering.TieringUtils.resolveRequestIndex;  
                            + indexName  
import org.opensearch.storage.common.tiering.TieringUtils;
                @Override
            transportService,
            threadPool,
     * @param prepareTieringAction the prepare tiering action for DFA indices
import org.opensearch.action.support.ActionFilters;  
package org.opensearch.storage.action.tiering;
    }
     * {@link IndexMetadata#INDEX_WRITE_BLOCK} cluster block to match {@code blockWrites}, but rewrites
    ) {  
                    + " attempts. Please retry.";
            blocks.removeIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);  
            hotToWarmTieringService
                            + "Consider increasing cluster.tiering.prepare_timeout or retry later.";
    private final HotToWarmTieringService hotToWarmTieringService;
     * more than once for the same index is safe.
     */
                    // Build a targeted error message based on failure type. A MergeDrainTimeoutException
                }  
                public ClusterState execute(ClusterState currentState) {  
            }
    private static final int MAX_PREPARE_RETRIES = 3;
                }
public class TransportHotToWarmTierAction extends TransportTierAction {
     * Best-effort — if this fails, the user can manually remove the block via index settings.
     * Called on prepare failure to avoid leaving the index in a stuck write-blocked state.
        }
        TransportService transportService,
        // Use the cluster setting for timeout instead of the short AcknowledgedRequest default (30s).
    static ClusterState applyWriteBlock(ClusterState currentState, IndexMetadata indexMetadata, boolean blockWrites) {
                    retryPrepareTiering(request, state, listener, attempt);
                return t.getMessage();
 * Non-DFA indices skip steps 1 and 2 and go directly to tiering.  
     */
     * @param hotToWarmTieringService the hot to warm tiering service  
                        } else {
     *  
                ActionListener<AcknowledgedResponse> tierListener = ActionListener.wrap(
import org.opensearch.threadpool.ThreadPool;  
        int depth = 0;
                        // All failures are merge drain timeouts — surface the per-shard detail (the  
        ThreadPool threadPool,
     * message.
import org.opensearch.cluster.metadata.Metadata;
    private void executePrepareTiering(  
                    return;
                            + mergeTimeoutCount  
                    // the registration version deserializes it as a generic wrapper — detection also matches  
        // Setting already matches the desired state — only (re)assert the cluster block, no version bump.  
     * Idempotently drives the index's write block to the desired state. Always (re)asserts the
/**
                            + "] after "  
 * 2. Performs pre-tiering sync (flush + refresh + remote store sync) on all primary shards  
     * Walks a failure's cause chain (bounded depth) looking for a merge-drain timeout and returns its
import org.opensearch.cluster.ClusterState;  
    /**
                            + firstFailure  
        ClusterBlocks.Builder blocks = ClusterBlocks.builder().blocks(currentState.blocks());
 * For DFA (pluggable data format) indices, this action:
                } catch (Exception e) {
                            MAX_PREPARE_RETRIES,
                            + mergeTimeoutCount  
                            + " shard(s) timed out waiting for merges, "
                }  
            }
                            + request.getIndex()
     * Common retry logic extracted from onResponse (shard failures) and onFailure (transport failures).
        Settings.Builder indexSettingsBuilder = Settings.builder()
                            ? "unknown"
                            + " shard(s) failed for other reasons. "  
    }
    }  
                hotToWarmTieringService.preflightValidate(state, index);  
                            + request.getIndex()
            logger.info("Index [{}] is a DFA index, adding write block and performing pre-tiering sync", request.getIndex());  
                    IndexMetadata indexMetadata = currentState.metadata().index(indexName);
     * Detection is primarily by type: {@link MergeDrainTimeoutException} is registered for
        } else {
        );  
                    String errorMsg;
    /**
            // Note: validation also runs inside TieringService.tier() for double-safety.  
            HotToWarmTierAction.NAME,
                @Override
                        // No merge timeouts — generic message with first failure details  
                // listener is ever invoked. removeWriteBlock is idempotent, so there is no double-removal risk.  
                // (the index is moving to warm). The try/catch still covers a synchronous throw before the
                    for (DefaultShardOperationFailedException f : failures) {
            "add-write-block-for-tiering [" + request.getIndex() + "]",  
     * serialization (see {@code OpenSearchServerException}) and round-trips as a typed exception  
                @Override
                @Override
            } catch (Exception e) {
                }  
     * @return the updated cluster state
                public ClusterState execute(ClusterState currentState) {  
 * this file be licensed under the Apache-2.0 license or a
        return ClusterState.builder(currentState).metadata(metadataBuilder).blocks(blocks).build();  
        });  
                    }
                    logger.error(() -> "Failed to add write block for index [" + request.getIndex() + "]", e);  
     * {@code blocks.write} setting (persisted in index metadata, cleanly reverted on cancel/failure) and  
                                mergeTimeoutSampleMessage = timeoutMessage;  
    public TransportHotToWarmTierAction(
    private void retryPrepareTiering(
import org.opensearch.cluster.service.ClusterService;  
        prepareTieringAction.execute(prepareTieringRequest, new ActionListener<BroadcastResponse>() {
                }
                    logger.warn(  
                            + ". Please retry.";
        this.hotToWarmTieringService = hotToWarmTieringService;
                    executePrepareTiering(request, newState, listener, 1);
            @Override  
                            + " shard(s) still waiting for merges to drain after "
                return message;
                        errorMsg = "Pre-tiering sync failed for index ["
    protected void clusterManagerOperation(IndexTieringRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener)  
                    } else if (mergeTimeoutCount > 0) {
    private void addWriteBlockAndPrepare(IndexTieringRequest request, ClusterState state, ActionListener<AcknowledgedResponse> listener) {
     * Constructs a TransportHotToWarmTierAction.
        int attempt
                        e
     */  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.core.action.ActionListener;
                            otherFailureCount++;  
                        () -> "Failed to remove write block for index ["
        if (IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.get(indexMetadata.getSettings()) == blockWrites) {
import org.opensearch.common.inject.Inject;
        return null;  
            "remove-write-block-for-tiering [" + indexName + "]",  
     */
                listener.onFailure(e);  
     * <p>
                            + MAX_PREPARE_RETRIES
     */
    }
                    }
        super(
     * actually changes. Skipping the no-op rewrite avoids bumping {@code settingsVersion} without a real
        );  
                    return applyWriteBlock(currentState, indexMetadata, false);
    private void removeWriteBlock(String indexName) {
    }  
import org.opensearch.action.support.broadcast.BroadcastResponse;
 * compatible open source license.
                    + MAX_PREPARE_RETRIES
     * the persisted {@code index.blocks.write} setting (and bumps {@code settingsVersion}) only when it  
                        );
 */  
            .settingsVersion(1 + indexMetadata.getSettingsVersion());
                            request.getIndex()  
            // If validation fails (e.g. warm nodes full, too many concurrent requests),
            super.clusterManagerOperation(request, state, listener);  
                        // Mixed failures  
        ClusterState state,  
                logger.info("Pre-tiering sync completed for index [{}], proceeding with tiering", request.getIndex());
    // Package-private (not private) so unit tests in the same package can exercise the  
                    failAndRemoveWriteBlock(request.getIndex(), new IllegalStateException(errorMsg), listener);
import org.opensearch.cluster.ClusterStateUpdateTask;
     * @param threadPool the thread pool  
    /**
    // idempotency invariant directly (no settingsVersion bump when the setting is unchanged).
                        attempt,
                    IndexMetadata indexMetadata = currentState.metadata().index(request.getIndex());
                            + "] after "  
                try {
    ) {  
                            if (mergeTimeoutSampleMessage == null) {
     * detail message, or {@code null} if none is found.  
            }
                @Override
                        // sample's message already carries shard id, merge counts, and the timeout).
                    if (indexMetadata == null) {
                    logger.warn(
 *
                    logger.error(errorMsg);  
import org.opensearch.cluster.block.ClusterBlocks;
        }
     * @param blockWrites   {@code true} to block writes, {@code false} to unblock  
                Index index = resolveRequestIndex(indexNameExpressionResolver, request.getIndex(), state);
import org.opensearch.transport.TransportService;
                        }
            public void onResponse(BroadcastResponse broadcastResponse) {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
    @Override
        IndexTieringRequest request,
import org.opensearch.common.Priority;
                    }
                failAndRemoveWriteBlock(request.getIndex(), new IllegalStateException(errorMsg, e), listener);
                            }
            }
import org.apache.logging.log4j.LogManager;
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        }
            @Override  
                    listener.onFailure(
        while (t != null && depth++ < 10) {
                    // Block writes before pre-tiering sync: persist blocks.write (revertible on
     * @param currentState  the current cluster state
     * Step 1: write-block the DFA index so no new writes land during prepare. Applies both the
                    // cancel/failure) and apply the INDEX_WRITE_BLOCK cluster block (enforced immediately).  
            addWriteBlockAndPrepare(request, state, listener);
    private void failAndRemoveWriteBlock(String indexName, Exception e, ActionListener<AcknowledgedResponse> listener) {  
                    + request.getIndex()
        }  
                            + mergeTimeoutSampleMessage;
        clusterService.submitStateUpdateTask(
                        errorMsg = "Pre-tiering sync failed for index ["
            if (t instanceof MergeDrainTimeoutException) {  
            blocks.addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK);
                    );  
        HotToWarmTieringService hotToWarmTieringService,
            .put(indexMetadata.getSettings())  
                    String mergeTimeoutSampleMessage = null;  
     * On success, proceeds to step 3 (tier).  
     * On final failure, removes the write block to avoid leaving the index in a stuck, write-blocked state.
                    failAndRemoveWriteBlock(request.getIndex(), e, listener);
        this.prepareTieringAction = prepareTieringAction;
                logger.error(errorMsg, e);  
                        errorMsg = "Tiering preparation timed out: "
                            + "First failure: "
 * 1. Adds a write block to prevent new writes
                    }
        );
import org.opensearch.storage.tiering.HotToWarmTieringService;
            try {
     * @param indexMetadata the (non-null) metadata of the index to update
 *
                public void onFailure(String source, Exception e) {  
     *  
                    if (indexMetadata == null) {
                return;
     * Retries the prepare tiering action with an incremented attempt counter.
        } else {
    }
        if (blockWrites) {  
    }  
                            broadcastResponse.getFailedShards(),
                    // is detected primarily by instanceof: the type is registered for serialization  
                            + " attempts: "
            actionFilters,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    DefaultShardOperationFailedException[] failures = broadcastResponse.getShardFailures();
                            + MAX_PREPARE_RETRIES
            t = t.getCause();
                        request.getIndex(),
                        if (timeoutMessage != null) {  
                    return applyWriteBlock(currentState, indexMetadata, true);
        TransportPrepareTieringAction prepareTieringAction
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata)  
                    );  
                    TransportHotToWarmTierAction.super.clusterManagerOperation(request, state, tierListener);  
                    } else {
                    int otherFailureCount = 0;
     * @param actionFilters the action filters
    }
            return ClusterState.builder(currentState).blocks(blocks).build();
                            + " attempts. Example: "  
import org.opensearch.core.index.Index;  
        int attempt
        removeWriteBlock(indexName);
                // the write block on failure (sync OR async). On success the block is intentionally retained
                    // (see OpenSearchServerException) and round-trips as a typed exception between nodes
                @Override  
            // reject immediately without adding a write block or running prepare.
                            mergeTimeoutCount++;
        final String indexName = indexMetadata.getIndex().getName();  
                    );  
                        retryPrepareTiering(request, state, listener, attempt);
     * Removes the write block from the index.  
                    return;
                            + " shard(s) failed. "
                }  
                // reports failure via listener.onFailure, not by throwing — so wrap the listener to remove  
                        "Pre-tiering sync attempt [{}/{}] failed for index [{}], retrying: {}",
     * proceeds to step 2 (prepare tiering).
                // The tier step (super.clusterManagerOperation) runs an async cluster-state update and
                            + "] after tiering failure. The block can be removed manually via index settings.",
    private static final Logger logger = LogManager.getLogger(TransportHotToWarmTierAction.class);
     * stuck in a write-blocked state) and then fails the listener. Co-locating the two steps ensures
            public void onFailure(Exception e) {
import org.opensearch.cluster.metadata.IndexMetadata;  
    @Inject  
     * Retries up to MAX_PREPARE_RETRIES times on shard failures before giving up.
     */  
     * between nodes running 3.8.0+. As a fallback for mixed-version clusters — where a peer older than
    private static String findMergeDrainTimeout(Throwable t) {  
        listener.onFailure(e);
 * Transport Tiering action to move indices from hot to warm.  
     * every failure exit removes the block. {@link #removeWriteBlock} is idempotent, so calling this  
    ) {
            final String message = t.getMessage();  
                    logger.info("Write block added for index [{}], proceeding with pre-tiering sync", request.getIndex());  
    private final TransportPrepareTieringAction prepareTieringAction;
    }
 * SPDX-License-Identifier: Apache-2.0
                        return;  
                        throw new IllegalStateException("Index [" + request.getIndex() + "] not found");  
                    listener::onResponse,
 * 3. Proceeds with the tiering operation
                        return currentState;  
            indexNameExpressionResolver,  
        executePrepareTiering(request, state, listener, attempt + 1);
     * Terminal-failure cleanup for the tiering flow: removes the write block (so the index is not left
                        String firstFailure = failures.length == 0
        prepareTieringRequest.timeout(TieringUtils.PREPARE_TIERING_TIMEOUT.get(clusterService.getSettings()));  
     * {@link MergeDrainTimeoutException#MERGE_DRAIN_TIMEOUT_MARKER} in the (always wire-preserved)  
                    if (mergeTimeoutCount > 0 && otherFailureCount == 0) {
                    // MERGE_DRAIN_TIMEOUT_MARKER in the (always wire-preserved) message.
                            : (failures[0].getCause() != null ? failures[0].getCause().getMessage() : "unknown");  
                }
                        e
     * @param indexNameExpressionResolver the index name expression resolver
            new ClusterStateUpdateTask(Priority.URGENT) {
     * @param transportService the transport service
            }
                            + " attempts: "
            }  
    /**  
import org.apache.logging.log4j.Logger;
        ActionListener<AcknowledgedResponse> listener,
                        logger.warn(
     * the registration version deserializes it as a generic wrapper — detection also matches
            .put(IndexMetadata.INDEX_BLOCKS_WRITE_SETTING.getKey(), blockWrites);
     * Step 2: Execute the prepare tiering action (flush + refresh + waitForRemoteStoreSync) on primary shards.
        Metadata.Builder metadataBuilder = Metadata.builder(currentState.metadata()).put(indexMetadataBuilder);
}
     */  
                    }
    /**
                }
     */
            clusterService,  
                            attempt,  
                logger.info("Preflight validation failed for DFA index [{}]: {}", request.getIndex(), e.getMessage());
                        MAX_PREPARE_RETRIES,  
/*  
     * the {@link IndexMetadata#INDEX_WRITE_BLOCK} cluster block (enforced immediately). On success,
                }  
        PrepareTieringRequest prepareTieringRequest = new PrepareTieringRequest(request.getIndex());  
                            + otherFailureCount
    /**  
                    logger.info("Write block removed for index [{}] after tiering failure", indexName);
    /**  
        IndexNameExpressionResolver indexNameExpressionResolver,  
        ActionFilters actionFilters,
                public void onFailure(String source, Exception e) {
        // This controls both the transport channel timeout and the merge drain timeout on the data node.
        ClusterState state,
import org.opensearch.common.settings.Settings;  
            if (message != null && message.contains(MergeDrainTimeoutException.MERGE_DRAIN_TIMEOUT_MARKER)) {
        clusterService.submitStateUpdateTask(
                );
 */
                if (attempt < MAX_PREPARE_RETRIES) {
     * @param clusterService the cluster service
        ClusterService clusterService,  
        throws Exception {
     * settings change, which would violate the {@code IndexService.updateMetadata} invariant.
                    + "] after "  
                        String timeoutMessage = findMergeDrainTimeout(f.getCause());
        IndexTieringRequest request,
                    // running 3.8.0+. As a fallback for mixed-version clusters — where a peer older than
                    int mergeTimeoutCount = 0;
