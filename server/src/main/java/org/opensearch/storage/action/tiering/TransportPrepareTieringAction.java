        // Flush before refresh: committed segments_N must exist before waitForRemoteStoreSync uploads them.
     */  
        throw new UnsupportedOperationException(  
                () -> "Failed to acquire primary permits for shard [" + shardRouting.shardId() + "] during tiering prepare — will retry",
                    listener.onFailure(e);  
     * Non-blocking async shard operation. Registers a merge drain listener instead of  
        this.prepareTieringTimeout = TieringUtils.PREPARE_TIERING_TIMEOUT.get(clusterService.getSettings());
    }  
    PrepareTieringRequest,
    }  
 * Transport action that prepares DFA indices for tiering by performing
 * executing operations in parallel across nodes. The total time equals the
     *  
 * SPDX-License-Identifier: Apache-2.0
     * @param clusterService the cluster service
 * @opensearch.internal
    @Inject
    }
            PrepareTieringAction.NAME,
        // which would reject this action. Since this is an internal operation that runs after the block  
        return new PrepareTieringRequest(in);
    private static final Logger logger = LogManager.getLogger(TransportPrepareTieringAction.class);
                int activeMerges = indexShard.getActiveMergeCount();
        // force=true bypasses the freeze guard — this is the last flush ever for this engine.
    protected EmptyResult shardOperation(PrepareTieringRequest request, ShardRouting shardRouting) throws IOException {
        TimeValue mergeTimeout = request.timeout() != null ? request.timeout() : prepareTieringTimeout;  
        logger.info("Updated replica sync timeout to [{}]", timeout);
        TransportService transportService,
import org.opensearch.transport.TransportService;  
        try {  
        IndexNameExpressionResolver indexNameExpressionResolver
        );
                new IOException(  
     * @param transportService the transport service
        return null;
    }  
                    );
    }
        PrepareTieringRequest request,
            logger.debug(  
     * the thread that received the transport request.
    protected ClusterBlockException checkRequestBlock(ClusterState state, PrepareTieringRequest request, String[] concreteIndices) {  
        IndexShard indexShard = indicesService.indexServiceSafe(shardRouting.shardId().getIndex()).getShard(shardRouting.shardId().id());  
    protected BroadcastResponse newResponse(  
            PlainActionFuture<Releasable> permitFuture = new PlainActionFuture<>();
        );
     * {@link #shardOperationAsync}. Throws unconditionally to catch misuse.
     * Opt-in to async shard operation execution. Each shard's syncAndFlush is dispatched
        // "prepare_tiering" source bypasses the freeze guard — this is the last refresh ever.
    @Override
     * @param indicesService the indices service  
     */  
        // (sync/flush, listener.onResponse, permit.close) runs at most once.
                } finally {
        // This ensures replicas have downloaded the merged segment(s) from remote store.
            .addSettingsUpdateConsumer(TieringUtils.REPLICA_SYNC_TIMEOUT_SETTING, this::setReplicaSyncTimeout);  
                    "Shard ["
        indexShard.waitForRemoteStoreSync();  
     */  
        try {  
 * This action is a single broadcast RPC to all nodes with primary shards,
     * Verifies that no uncommitted translog operations remain after flush.
    @Override
        // Schedule timeout — fires before transport timeout with diagnostic info about pending merges
 */
        clusterService.getClusterSettings()
                e
        // Timeout: use 80% of the transport timeout so we fail with a meaningful message
                        + shardRouting.shardId()
}
        this.replicaSyncTimeout = TieringUtils.REPLICA_SYNC_TIMEOUT_SETTING.get(clusterService.getSettings());
    private final ThreadPool threadPool;  
                } catch (Exception e) {
            }
        return new BroadcastResponse(totalShards, successfulShards, failedShards, shardFailures);  
    @Override
        // Do not check index-level blocks here. This action is called internally after we intentionally
import org.opensearch.cluster.block.ClusterBlockLevel;
                try {
        if (uncommitted > 0) {  
        logger.debug("Shard [{}] prepared for tiering successfully", shardRouting.shardId());  
 */  
import org.opensearch.core.action.ActionListener;  
            transportService,  
        logger.trace("Completing sync and flush for shard [{}]", shardRouting.shardId());
import org.opensearch.cluster.routing.ShardRouting;  
        indexShard.sync();  
     */  
import java.util.List;  
            PrepareTieringRequest::new,  
 * this file be licensed under the Apache-2.0 license or a
        List<DefaultShardOperationFailedException> shardFailures,  
import org.opensearch.threadpool.ThreadPool;
        Releasable permit;
            ThreadPool.Names.GENERIC
    @Override  
    private volatile TimeValue prepareTieringTimeout;
        int successfulShards,  
    private static final TimeValue PERMITS_ACQUIRE_TIMEOUT = TimeValue.timeValueSeconds(30);  
     * Blocks until all currently executing operations complete (up to 30s timeout).
        // Wait for replicas to apply the latest checkpoint before relocation.
    protected void shardOperationAsync(PrepareTieringRequest request, ShardRouting shardRouting, ActionListener<EmptyResult> listener) {
    protected ClusterBlockException checkGlobalBlock(ClusterState state, PrepareTieringRequest request) {
        }  
        }
            );  
import org.opensearch.action.support.ActionFilters;
    /**
        });
    @Override
        AtomicBoolean completed = new AtomicBoolean(false);  
    /**
            permit = acquirePrimaryPermits(indexShard, shardRouting);
        verifyNoUncommittedOps(indexShard, shardRouting);
        return true;  
     * Called after merges have drained (either via blocking wait or async listener).
        // is deliberately set, we skip the index-level block check.
        // add a write block on the index. That block includes METADATA_WRITE level,
    /**  
            throw new IOException("Failed to acquire primary operation permits for shard [" + shardRouting.shardId() + "]", e);
    @Override
/*  
        }  
import org.opensearch.cluster.block.ClusterBlockException;  
        TimeValue effectiveTimeout = TimeValue.timeValueMillis(mergeTimeoutMillis);
        indexShard.freezeForTiering();
        this.indicesService = indicesService;  
            listener.onFailure(
            return permitFuture.actionGet();  
            indexShard.acquireAllPrimaryOperationsPermits(permitFuture, PERMITS_ACQUIRE_TIMEOUT);
        ActionFilters actionFilters,  
            if (completed.compareAndSet(false, true)) {  
            actionFilters,
        clusterService.getClusterSettings().addSettingsUpdateConsumer(TieringUtils.PREPARE_TIERING_TIMEOUT, this::setPrepareTieringTimeout);  
        indexShard.onMergesDrained(() -> {
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
                        + indexShard.state()
    }
            throw new IOException(
                    listener.onFailure(
    @Override  
            if (completed.compareAndSet(false, true)) {
    @Override
                "Shard [" + shardRouting.shardId() + "] still has " + uncommitted + " uncommitted translog ops after flush"
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            );  
import org.apache.logging.log4j.Logger;
 * <p>
    private final IndicesService indicesService;
     * Targets primary shards only. Replicas get data via segment replication from primary.
    private void setReplicaSyncTimeout(TimeValue timeout) {
     * Acquires all primary operation permits to drain in-flight indexing operations.
     * While permits are held, no new indexing operations can start on this shard.  
    protected ShardsIterator shards(ClusterState clusterState, PrepareTieringRequest request, String[] concreteIndices) {
import org.opensearch.storage.common.tiering.TieringUtils;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.broadcast.BroadcastResponse;  
    private volatile TimeValue replicaSyncTimeout;
        if (indexShard.state() != IndexShardState.STARTED) {
    protected boolean isAsyncShardOperation() {
        super(  
        List<EmptyResult> responses,
        } catch (Exception e) {
import org.opensearch.indices.IndicesService;
        } catch (IOException e) {
     * Constructs a TransportPrepareTieringAction.
public class TransportPrepareTieringAction extends TransportBroadcastByNodeAction<  
                    permit.close();  
import org.opensearch.action.support.broadcast.node.TransportBroadcastByNodeAction;
        logger.info("Updated prepare tiering timeout to [{}]", timeout);
        indexShard.waitForReplicaSync(replicaSyncTimeout);  
import org.opensearch.common.inject.Inject;  
    protected EmptyResult readShardResult(StreamInput in) throws IOException {
        this.threadPool = transportService.getThreadPool();
    }  
 *
    /**  
     * blocking a thread waiting for merges. Uses AtomicBoolean to ensure only one path
            return;
/**  
    }
     * @param indexNameExpressionResolver the index name expression resolver
        indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));  
     * (merge callback OR timeout) completes the operation.
     */  
            indexNameExpressionResolver,
    /**  
                )  
        // Fail fast if shard is not fully started  
                }  
                try {
    }
package org.opensearch.storage.action.tiering;
import org.opensearch.index.shard.IndexShardState;
     */  
 * Registered as internal action: {@code internal:admin/indices/prepare_tiering}
    ) {
import org.opensearch.threadpool.Scheduler;
import org.opensearch.action.support.PlainActionFuture;
        int failedShards,
                }
        IndicesService indicesService,
            clusterService,
    protected PrepareTieringRequest readRequestFrom(StreamInput in) throws IOException {
            return;
    }  
import org.opensearch.action.admin.indices.flush.FlushRequest;  
     * to the thread pool in parallel, and the transport response is sent only after  
    BroadcastResponse,
        int uncommitted = indexShard.translogStats().getUncommittedOperations();
                timeout.cancel();
                    completeSyncAndFlush(indexShard, shardRouting);  
    /**
            }
        this.prepareTieringTimeout = timeout;
    }
    private Releasable acquirePrimaryPermits(IndexShard indexShard, ShardRouting shardRouting) throws IOException {
        }  
                boolean hasPendingMerges = indexShard.hasPendingMerges();  
 * sync, flush, refresh, and remote store sync on primary shards.
    /**
     */
        this.replicaSyncTimeout = timeout;  
        int totalShards,
 * compatible open source license.
            );
     * Sync fallback — required by the abstract contract but never called because  
        }, effectiveTimeout, ThreadPool.Names.GENERIC);  
    TransportBroadcastByNodeAction.EmptyResult> {  
        // Thread returns immediately — not blocked!  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                    listener.onResponse(EmptyResult.INSTANCE);
 *  
        // invoke us more than once under a narrow scheduler race, and `completed` ensures the body  
     */  
import java.util.concurrent.atomic.AtomicBoolean;
    private void completeSyncAndFlush(IndexShard indexShard, ShardRouting shardRouting) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        ClusterState clusterState
        indexShard.refresh("prepare_tiering");
import org.opensearch.common.unit.TimeValue;
                    permit.close();
import org.opensearch.cluster.ClusterState;
    @Override  
                } finally {
    private void verifyNoUncommittedOps(IndexShard indexShard, ShardRouting shardRouting) throws IOException {
     * {@link #isAsyncShardOperation()} returns true and we override
        Scheduler.ScheduledCancellable timeout = threadPool.schedule(() -> {  
            listener.onFailure(e);
import org.apache.logging.log4j.LogManager;
 * <p>  
    ) {
        return EmptyResult.readEmptyResultFrom(in);
                        + "] is not in STARTED state (current: "  
    private void setPrepareTieringTimeout(TimeValue timeout) {  
                        new MergeDrainTimeoutException(shardRouting.shardId(), activeMerges, hasPendingMerges, mergeTimeout.toString())  
     * @param actionFilters the action filters
     * Performs the final sync, flush, refresh, remote store sync, and verification.
     * all shards complete. This prevents long-running flush + remote sync from blocking
        // Non-blocking merge wait. The CAS makes this listener idempotent — onMergesDrained may
        ClusterService clusterService,  
        logger.debug("Preparing shard [{}] for tiering (async path)", shardRouting.shardId());
    }  
import java.io.IOException;
            "TransportPrepareTieringAction uses shardOperationAsync exclusively; sync path should never be called"
 * slowest shard's upload time.  
import org.opensearch.cluster.routing.ShardsIterator;
     * This is a defensive check — with read-only block + force flush, uncommitted should always be 0.
    }
        long mergeTimeoutMillis = (long) (mergeTimeout.millis() * 0.8);
    public TransportPrepareTieringAction(
        // before the transport channel times out with a generic error. This allows the caller to retry.
    }
import org.opensearch.common.lease.Releasable;
        return clusterState.routingTable().allShardsSatisfyingPredicate(concreteIndices, ShardRouting::primary);  
    /**
    }
                        + "). Cannot prepare for tiering — will retry."
import org.opensearch.index.shard.IndexShard;  
