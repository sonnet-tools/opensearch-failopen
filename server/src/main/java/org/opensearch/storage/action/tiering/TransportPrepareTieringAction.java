     * to the thread pool in parallel, and the transport response is sent only after
    private final IndicesService indicesService;
     */
     */
import org.opensearch.cluster.block.ClusterBlockException;
    @Override
        // Flush before refresh: committed segments_N must exist before waitForRemoteStoreSync uploads them.
    BroadcastResponse,
                    listener.onFailure(e);
        // invoke us more than once under a narrow scheduler race, and `completed` ensures the body
     * Constructs a TransportPrepareTieringAction.
import org.opensearch.threadpool.ThreadPool;
 */
    private Releasable acquirePrimaryPermits(IndexShard indexShard, ShardRouting shardRouting) throws IOException {
                    listener.onFailure(
        this.indicesService = indicesService;
            actionFilters,
    protected ClusterBlockException checkRequestBlock(ClusterState state, PrepareTieringRequest request, String[] concreteIndices) {
        // Timeout: use 80% of the transport timeout so we fail with a meaningful message
    @Override
        // Wait for replicas to apply the latest checkpoint before relocation.
                    permit.close();
     * Non-blocking async shard operation. Registers a merge drain listener instead of
                        + indexShard.state()
import java.util.concurrent.atomic.AtomicBoolean;
    }
    ) {
    protected boolean isAsyncShardOperation() {
    }
     * @param indicesService the indices service
 * <p>
     * @param indexNameExpressionResolver the index name expression resolver
            if (completed.compareAndSet(false, true)) {
        indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));
     */
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        super(
    protected ClusterBlockException checkGlobalBlock(ClusterState state, PrepareTieringRequest request) {
        } catch (Exception e) {
     * @param transportService the transport service
import org.opensearch.cluster.service.ClusterService;
    protected PrepareTieringRequest readRequestFrom(StreamInput in) throws IOException {
    }
            clusterService,
            PrepareTieringAction.NAME,
    protected void shardOperationAsync(PrepareTieringRequest request, ShardRouting shardRouting, ActionListener<EmptyResult> listener) {
        // before the transport channel times out with a generic error. This allows the caller to retry.
     * Called after merges have drained (either via blocking wait or async listener).
            );
 *
    ) {
    private void setPrepareTieringTimeout(TimeValue timeout) {
                        + "). Cannot prepare for tiering — will retry."
     * @param clusterService the cluster service
    /**
     * Sync fallback — required by the abstract contract but never called because
     * (merge callback OR timeout) completes the operation.
            listener.onFailure(e);
public class TransportPrepareTieringAction extends TransportBroadcastByNodeAction<
 * slowest shard's upload time.
        PrepareTieringRequest request,
     */
import org.opensearch.action.support.broadcast.BroadcastResponse;
    protected EmptyResult shardOperation(PrepareTieringRequest request, ShardRouting shardRouting) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * <p>
                new IOException(
 *
     * Performs the final sync, flush, refresh, remote store sync, and verification.
        TimeValue effectiveTimeout = TimeValue.timeValueMillis(mergeTimeoutMillis);
        IndexShard indexShard = indicesService.indexServiceSafe(shardRouting.shardId().getIndex()).getShard(shardRouting.shardId().id());
            "TransportPrepareTieringAction uses shardOperationAsync exclusively; sync path should never be called"
    protected ShardsIterator shards(ClusterState clusterState, PrepareTieringRequest request, String[] concreteIndices) {
        // add a write block on the index. That block includes METADATA_WRITE level,
                } finally {
                        + "] is not in STARTED state (current: "
        }
 * Transport action that prepares DFA indices for tiering by performing
    /**
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.index.shard.IndexShardState;
    PrepareTieringRequest,
        // Schedule timeout — fires before transport timeout with diagnostic info about pending merges
                } finally {
        int successfulShards,
        logger.debug("Shard [{}] prepared for tiering successfully", shardRouting.shardId());
        logger.info("Updated prepare tiering timeout to [{}]", timeout);
    @Inject
        // which would reject this action. Since this is an internal operation that runs after the block
        return EmptyResult.readEmptyResultFrom(in);
    private void completeSyncAndFlush(IndexShard indexShard, ShardRouting shardRouting) throws IOException {
 * @opensearch.internal
import org.opensearch.storage.common.tiering.TieringUtils;
     * @param actionFilters the action filters
import org.apache.logging.log4j.Logger;
        ClusterState clusterState
        return new BroadcastResponse(totalShards, successfulShards, failedShards, shardFailures);
    @Override
import org.opensearch.cluster.routing.ShardsIterator;
                () -> "Failed to acquire primary permits for shard [" + shardRouting.shardId() + "] during tiering prepare — will retry",
/*
import org.opensearch.index.shard.IndexShard;
        // Do not check index-level blocks here. This action is called internally after we intentionally
    TransportBroadcastByNodeAction.EmptyResult> {
                "Shard [" + shardRouting.shardId() + "] still has " + uncommitted + " uncommitted translog ops after flush"
                }
     */
    private volatile TimeValue replicaSyncTimeout;
    @Override
    private static final Logger logger = LogManager.getLogger(TransportPrepareTieringAction.class);
        this.replicaSyncTimeout = timeout;
import org.opensearch.action.support.ActionFilters;
    private void verifyNoUncommittedOps(IndexShard indexShard, ShardRouting shardRouting) throws IOException {
    }
     * Blocks until all currently executing operations complete (up to 30s timeout).
        if (indexShard.state() != IndexShardState.STARTED) {
     */
    /**
    /**
        long mergeTimeoutMillis = (long) (mergeTimeout.millis() * 0.8);
import org.opensearch.common.inject.Inject;
import org.opensearch.action.support.PlainActionFuture;
    /**
    }
                    "Shard ["
 * compatible open source license.
        );
    /**
        clusterService.getClusterSettings()
            }
            indexNameExpressionResolver,
        indexShard.refresh("prepare_tiering");
            transportService,
        // "prepare_tiering" source bypasses the freeze guard — this is the last refresh ever.
    }
        IndexNameExpressionResolver indexNameExpressionResolver
        logger.debug("Preparing shard [{}] for tiering (async path)", shardRouting.shardId());
        int failedShards,
        return new PrepareTieringRequest(in);
            listener.onFailure(
        int totalShards,
import org.opensearch.core.action.ActionListener;
        return true;
        indexShard.onMergesDrained(() -> {
    protected EmptyResult readShardResult(StreamInput in) throws IOException {
    @Override
    private final ThreadPool threadPool;
        // Thread returns immediately — not blocked!
import org.opensearch.threadpool.Scheduler;
        }, effectiveTimeout, ThreadPool.Names.GENERIC);
import org.opensearch.cluster.routing.ShardRouting;
        }
    }
import org.apache.logging.log4j.LogManager;
        ActionFilters actionFilters,
            );
            indexShard.acquireAllPrimaryOperationsPermits(permitFuture, PERMITS_ACQUIRE_TIMEOUT);
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
        int uncommitted = indexShard.translogStats().getUncommittedOperations();
                    );
        this.prepareTieringTimeout = timeout;
 */
    public TransportPrepareTieringAction(
        this.prepareTieringTimeout = TieringUtils.PREPARE_TIERING_TIMEOUT.get(clusterService.getSettings());
        try {
            permit = acquirePrimaryPermits(indexShard, shardRouting);
        indexShard.waitForReplicaSync(replicaSyncTimeout);
        TransportService transportService,
        logger.trace("Completing sync and flush for shard [{}]", shardRouting.shardId());
            return;
    private volatile TimeValue prepareTieringTimeout;
        if (uncommitted > 0) {
 * Registered as internal action: {@code internal:admin/indices/prepare_tiering}
            }
        // force=true bypasses the freeze guard — this is the last flush ever for this engine.
        AtomicBoolean completed = new AtomicBoolean(false);
        List<DefaultShardOperationFailedException> shardFailures,
            .addSettingsUpdateConsumer(TieringUtils.REPLICA_SYNC_TIMEOUT_SETTING, this::setReplicaSyncTimeout);
        return null;
                try {
        Releasable permit;
     * {@link #shardOperationAsync}. Throws unconditionally to catch misuse.
        verifyNoUncommittedOps(indexShard, shardRouting);
    @Override
            logger.debug(
    }
        // This ensures replicas have downloaded the merged segment(s) from remote store.
                }
    private void setReplicaSyncTimeout(TimeValue timeout) {
import java.io.IOException;
     */
import org.opensearch.indices.IndicesService;
            PrepareTieringRequest::new,
        Scheduler.ScheduledCancellable timeout = threadPool.schedule(() -> {
            if (completed.compareAndSet(false, true)) {
    @Override
import org.opensearch.common.unit.TimeValue;
    }
     * the thread that received the transport request.
 * sync, flush, refresh, and remote store sync on primary shards.
        indexShard.sync();
                    completeSyncAndFlush(indexShard, shardRouting);
     *
                e
            throw new IOException("Failed to acquire primary operation permits for shard [" + shardRouting.shardId() + "]", e);
    protected BroadcastResponse newResponse(
    /**
        clusterService.getClusterSettings().addSettingsUpdateConsumer(TieringUtils.PREPARE_TIERING_TIMEOUT, this::setPrepareTieringTimeout);
                boolean hasPendingMerges = indexShard.hasPendingMerges();
        // (sync/flush, listener.onResponse, permit.close) runs at most once.
     * This is a defensive check — with read-only block + force flush, uncommitted should always be 0.
     */
 * This action is a single broadcast RPC to all nodes with primary shards,
package org.opensearch.storage.action.tiering;
 * The OpenSearch Contributors require contributions made to
        });
            ThreadPool.Names.GENERIC
        ClusterService clusterService,
        // Non-blocking merge wait. The CAS makes this listener idempotent — onMergesDrained may
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        List<EmptyResult> responses,
                } catch (Exception e) {
     * blocking a thread waiting for merges. Uses AtomicBoolean to ensure only one path
        try {
     * all shards complete. This prevents long-running flush + remote sync from blocking
 * this file be licensed under the Apache-2.0 license or a
    }
            return;
        indexShard.freezeForTiering();
        throw new UnsupportedOperationException(
                int activeMerges = indexShard.getActiveMergeCount();
     * Targets primary shards only. Replicas get data via segment replication from primary.
    @Override
     * While permits are held, no new indexing operations can start on this shard.
    }
    }
        }
    private static final TimeValue PERMITS_ACQUIRE_TIMEOUT = TimeValue.timeValueSeconds(30);
        );
            );
        return clusterState.routingTable().allShardsSatisfyingPredicate(concreteIndices, ShardRouting::primary);
    /**
    @Override
     * Verifies that no uncommitted translog operations remain after flush.
        indexShard.waitForRemoteStoreSync();
        IndicesService indicesService,
import org.opensearch.transport.TransportService;
    }
import org.opensearch.common.lease.Releasable;
     * Opt-in to async shard operation execution. Each shard's syncAndFlush is dispatched
 * executing operations in parallel across nodes. The total time equals the
     * {@link #isAsyncShardOperation()} returns true and we override
        this.threadPool = transportService.getThreadPool();
import java.util.List;
            return permitFuture.actionGet();
import org.opensearch.cluster.ClusterState;
        TimeValue mergeTimeout = request.timeout() != null ? request.timeout() : prepareTieringTimeout;
        // is deliberately set, we skip the index-level block check.
            PlainActionFuture<Releasable> permitFuture = new PlainActionFuture<>();
     * Acquires all primary operation permits to drain in-flight indexing operations.
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
                try {
/**
        logger.info("Updated replica sync timeout to [{}]", timeout);
        this.replicaSyncTimeout = TieringUtils.REPLICA_SYNC_TIMEOUT_SETTING.get(clusterService.getSettings());
        }
                    listener.onResponse(EmptyResult.INSTANCE);
                    permit.close();
}
    }
                        new MergeDrainTimeoutException(shardRouting.shardId(), activeMerges, hasPendingMerges, mergeTimeout.toString())
                )
            throw new IOException(
                timeout.cancel();
                        + shardRouting.shardId()
        // Fail fast if shard is not fully started
    }
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.admin.indices.flush.FlushRequest;
        } catch (IOException e) {
