import org.opensearch.core.action.ActionListener;
            }
        final RecoverySettings recoverySettings,
                startMergedSegmentReplication(replicaShard, receivedCheckpoint, new SegmentReplicationListener() {
                        logger.debug(
    private final ThreadPool threadPool;
            );
                }
    public SegmentReplicationState getlatestCompletedEventSegmentReplicationState(ShardId shardId) {
                }
     * Cancel any replications on this node for a replica that is about to be closed.
    public SegmentReplicationTargetService(
    ) {
    /**
                        }
                startReplication(replicaShard, receivedCheckpoint, isRetry, new SegmentReplicationListener() {
                request.getCheckpoint()
            }
        final AtomicLong bytesSinceLastPause = new AtomicLong();
                            recoverySettings.getMergedSegmentReplicationTimeout().seconds()
        // How many bytes we've copied since we last called RateLimiter.pause
        final TransportService transportService,
            .orElseGet(() -> getlatestCompletedEventSegmentReplicationState(shardId));
                );
            // ignore if shard is closed
        final IndicesService indicesService,
    public void startMergedSegmentReplication(
        if (oldRouting != null
    }
                        () -> new ParameterizedMessage(
                try {
                logger.error(
    /**
            final Thread thread = Thread.currentThread();
            .build();
                                    indexShard.getLatestReplicationCheckpoint(),
            new ForceSyncTransportRequestHandler()
                () -> new ParameterizedMessage("Ignoring checkpoint, shard not started {} {}", receivedCheckpoint, replicaShard.state())
                        () -> new ParameterizedMessage(
                        );
                        if (shard.routingEntry().primary() == false && shard.routingEntry().isSearchOnly() == false) {
                        request.getCheckpoint()
                                    state.getReplicationId(),
    }
    /**
        public static final String MERGED_SEGMENT_FILE_CHUNK = "internal:index/shard/replication/merged_segment_file_chunk";
                        // update visible checkpoint to primary
        final IndexShard indexShard,
            };
     * @opensearch.internal
     */
    public SegmentReplicationState getOngoingEventSegmentReplicationState(ShardId shardId) {
                    logger.debug(
        return replicator.getCompleted(shardId);
        final TransportService transportService,
                    receivedCheckpoint,
            && newRouting.primary()) {
            in -> TransportResponse.Empty.INSTANCE
                                state.getReplicationId(),
                                ongoingReplicationTarget.getCheckpoint().getPrimaryTerm()
                            }
                        );
                            failShard(e, replicaShard);
                            );
        }
            // Checks if received checkpoint is already present
    private class MergedSegmentFileChunkTransportRequestHandler implements TransportRequestHandler<FileChunkRequest> {
        final SegmentReplicationListener listener
    }
     */
        replicator.updateReplicationCheckpointStats(receivedCheckpoint, replicaShard);
        // if the shard is in any state
     * returns SegmentReplicationState of on-going segment replication events.
                    ),
                        if (sendShardFailure) {
    }
    }
                if (indexService.getIndexSettings().isSegRepEnabledOrRemoteNode()
            // We are skipping any validation for an incoming checkpoint, use the shard's latest checkpoint in the target.
        transportService.registerRequestHandler(
                } catch (InterruptedException e) {
                            }
                        } else {
        if (latestPublishedCheckpoint != null) {
import java.util.concurrent.atomic.AtomicLong;
                            ongoingReplicationTarget.getCheckpoint()
import org.opensearch.action.support.ChannelActionListener;
    protected boolean processLatestReceivedCheckpoint(IndexShard replicaShard, Thread thread) {
            e.addSuppressed(inner);
                for (MergedSegmentReplicationTarget ongoingReplicationTarget : ongoingReplicationTargetList) {
                // if we retry ensure the shard is not in the process of being closed.
        public void messageReceived(final FileChunkRequest request, TransportChannel channel, Task task) throws Exception {
                        }
            startReplication(
        // Checks if replica shard is in the correct STARTED state to process checkpoints (avoids parallel replication events taking place)
        final SegmentReplicationSourceFactory sourceFactory,
                            if (previousNode.equals(currentNode) == false) {
        return replicator.getMergeReplicationRef(replicationId);
            }
            if (ongoingReplicationTargetList != null) {
        };
     * Start a round of replication and sync to at least the given checkpoint.
                "Updating Primary shard that replica {}-{} is synced to checkpoint {}",
    }
     * @return {@link SegmentReplicationTarget} target event orchestrating the event.
                    public void onReplicationFailure(
                    public void onReplicationDone(SegmentReplicationState state) {
    }
            }
                    onNewCheckpoint(replicator.getPrimaryCheckpoint(replicaShard.shardId()), replicaShard, isRetry);
import org.apache.logging.log4j.Logger;
                    public void onReplicationFailure(
    @Override
    }
                                indexShard.resetToWriteableEngine();
     * returns SegmentReplicationState of latest completed segment replication events.
                            final String previousNode = event.previousState()
                );
     * @param isRetry - is it a retry after failure
 * SPDX-License-Identifier: Apache-2.0
            Actions.FILE_CHUNK,
        );
import org.opensearch.indices.replication.common.ReplicationCollection;
                e
            public void onFailure(Exception e) {
    private boolean isRemoteStoreMergedSegmentCheckpoint(ReplicationCheckpoint checkpoint) {
                        )
    public synchronized void onNewCheckpoint(
     *
        if (isRemoteStoreMergedSegmentCheckpoint(receivedCheckpoint)) {
                        logger.warn(
                                state.getReplicationId(),
        this.replicator = replicator;
        final ShardId shardId = request.getShardId();
        final SegmentReplicator replicator
    /**
            // Checks if received checkpoint is already present and ahead then it replaces old received checkpoint
        // checkpoint to be replayed once the shard is Active.
        );
                    replicaShard.shardId(),
        }
                    @Override
    protected boolean processLatestReceivedCheckpoint(IndexShard replicaShard, Thread thread, boolean isRetry) {
                                .currentNodeId();
                        // behind until the next publish; comparing against the achieved checkpoint re-triggers the
            FileChunkRequest::new,
    public SegmentReplicationTarget startReplication(
            onReplicationFailure((SegmentReplicationState) state, e, sendShardFailure);
        // only log as error if error is not a cancellation.
                                "Ignoring new merge replication checkpoint - shard is currently replicating to checkpoint {}",
                    public void onReplicationDone(SegmentReplicationState state) {
                                // Update the replica's checkpoint on primary's replication tracker.
    ) {
                ),
                                state.getTimingData()
import org.opensearch.common.settings.Settings;
                target.handleFileChunk(request, target, bytesSinceLastPause, recoverySettings.replicationRateLimiter(), listener);
    protected void updateVisibleCheckpoint(long replicationId, IndexShard replicaShard) {
        updateLatestReceivedCheckpoint(receivedCheckpoint, replicaShard);
        if (indexShard.indexSettings().isSegRepEnabledOrRemoteNode() && indexShard.routingEntry().primary() == false) {
     * returns SegmentReplicationState of on-going if present or completed segment replication events.
        final IndexShard indexShard = indicesService.getShardOrNull(shardId);
                        // checkpoint rather than the checkpoint this round targeted (receivedCheckpoint). A retry
    void startReplication(final SegmentReplicationTarget target) {
        }
                    public void onReplicationDone(SegmentReplicationState state) {
        return startReplication(indexShard, checkpoint, false, listener);
            return;
    public SegmentReplicationState getSegmentReplicationState(ShardId shardId) {
                            () -> new ParameterizedMessage(
                    }
            threadPool,
                            // Promote engine type for primary target
                        request.getCheckpoint()
     *
            try (ReplicationRef<SegmentReplicationTarget> ref = replicator.get(request.recoveryId(), request.shardId())) {
                                ongoingReplicationTarget.getCheckpoint()
        final ClusterService clusterService
            listener.onResponse(TransportResponse.Empty.INSTANCE);
        transportClient.executeRetryableAction(
                    logger.debug(
                                receivedCheckpoint,
            ThreadPool.Names.GENERIC,
            replicator.cancel(indexShard.shardId(), "Shard has been promoted to primary");
                // send our latest checkpoint to the primary to update tracking.
            }
        void onReplicationDone(SegmentReplicationState state);
        );
import org.opensearch.index.shard.IndexEventListener;
                            ongoingReplicationTarget.getCheckpoint().getPrimaryTerm()
                    "Processing latest received checkpoint for shard {} {}",
        final RecoverySettings recoverySettings,
                        latch.countDown();
                () -> new ParameterizedMessage(
            logger.trace(() -> "Ignoring checkpoint, Shard is closed");
            }
        return processLatestReceivedCheckpoint(replicaShard, thread, false);
    /**
                e
    /**
                        logger.debug(
                final MergedSegmentReplicationTarget target = ref.get();
            logger.trace(
import org.opensearch.indices.recovery.ForceSyncRequest;
            primaryShard.shardId(),
            ThreadPool.Names.GENERIC,
    private void failShard(ReplicationFailedException e, IndexShard indexShard) {
        this.threadPool = threadPool;
        final IndicesService indicesService,
                        ongoingReplicationTarget.cancel("Cancelling stuck merged segment target after new primary");
        return Optional.ofNullable(getOngoingEventSegmentReplicationState(shardId))
            }
                    e
                runnable.run();
        this(
                    for (IndexShard shard : indexService) {
     * @return {@link SegmentReplicationTarget} target event orchestrating the event.
    private final ClusterService clusterService;
                )
        // node communication, checkpoint update is piggy-backed to GET_SEGMENT_FILES transport call
        assert indicesService != null;
    private static final Logger logger = LogManager.getLogger(SegmentReplicationTargetService.class);
     * Replay any received checkpoint while replica was recovering.  This does not need to happen
    private final TransportService transportService;
     */
            @Override
                    replicaShard.shardId(),
    @Override
            () -> new ParameterizedMessage("Replica received new merged segment checkpoint [{}] from primary", receivedCheckpoint)
                    );
                    }
                            () -> new ParameterizedMessage(
                    "[shardId {}] [replication id {}] Replication failed, timing data: {}",
    }
     */
     */
                    recoverySettings.mergedSegmentReplicationRateLimiter(),
            return;
import org.apache.logging.log4j.LogManager;
import java.util.Optional;
import org.opensearch.core.index.shard.ShardId;
        final ClusterService clusterService,
        boolean isRetry
                () -> new ParameterizedMessage(
            } else if (replicaShard.isSegmentReplicationAllowed()) {
        } else {
                    "[shardId {}] [replication id {}] Replication cancelled",
            // Checks if we are using same thread and forks if necessary.
                        // If the latest checkpoint known from the primary is still ahead of what this replica has
                                .shardRoutingTable(shard.shardId())
            sourceFactory,
        }
        } catch (Exception inner) {
import java.util.List;
        // Proceed with round of segment replication only when it is allowed
                logger.trace(
    @Nullable
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {
            SegmentReplicationTarget ongoingReplicationTarget = replicator.get(replicaShard.shardId());
                });
                                ongoingReplicationTarget.description(),
     */
                    request.shardId()
    private void unmarkPendingDownloadMergedSegments(IndexShard shard, ReplicationCheckpoint receivedCheckpoint) {
        );
        return Optional.ofNullable(replicator.get(shardId)).map(SegmentReplicationTarget::state).orElse(null);
        default void onDone(ReplicationState state) {
            assert replicator.size() == 0 : "Replication collection should be empty on shutdown";
import org.opensearch.common.util.CancellableThreads;
                                "Cancelling ongoing merge replication {} from old primary with primary term {}",
        }
        this.sourceFactory = sourceFactory;
    private class FileChunkTransportRequestHandler implements TransportRequestHandler<FileChunkRequest> {
    }
            Runnable runnable = () -> {
    ) {
            shard.getRemoteDirectory().unmarkMergedSegmentsPendingDownload(receivedCheckpoint.getMetadataMap().keySet());
                // it will be removed from indexService's collection before the shard is actually marked as closed.
    }
    public SegmentReplicationTargetService(
            )
    /**
        final SegmentReplicationListener listener
                        );
                    }
                    }
                            logger.trace(
                    replicaShard.state()
    }
import java.util.concurrent.CountDownLatch;
    /**
import org.opensearch.indices.replication.common.ReplicationListener;
    protected void doClose() throws IOException {
        return replicator.startReplication(indexShard, checkpoint, sourceFactory.get(indexShard), isRetry, listener);
                        }
        }
    }
        this.clusterService = clusterService;
    List<MergedSegmentReplicationTarget> getMergedSegmentReplicationTarget(ShardId shardId) {
            new SegmentReplicator(threadPool)
                    );
    }
 */
    }
        replicator.setSourceFactory(sourceFactory);
        // if the shard is in any state
    }
     */
    }
    public void afterIndexShardStarted(IndexShard indexShard) {
            ThreadPool.Names.GENERIC,
            );
                    listener
                        boolean sendShardFailure
/**
                            && latestReceivedCheckpoint.isAheadOf(replicaShard.getLatestReplicationCheckpoint())) {
                    @Override
            logger
     * Invoked when a new checkpoint is received from a primary shard.
            indicesService,
    }
                            "Merged segment replication for {} timed out after [{}] seconds",
        // How many bytes we've copied since we last called RateLimiter.pause
            }
    @Nullable
        }
        }
                    state.getReplicationId()
import org.opensearch.index.shard.IndexShardState;
    }
    // visible to tests
            Actions.MERGED_SEGMENT_FILE_CHUNK,
import org.opensearch.transport.TransportRequestOptions;
    @Deprecated
                    }
                )
        this.indicesService = indicesService;
        logger.trace(
        final ReplicationCollection<SegmentReplicationTarget> ongoingSegmentReplications
        public static final String FILE_CHUNK = "internal:index/shard/replication/file_chunk";
                        );
            logger.trace(() -> "Ignoring merged segment checkpoint, Shard is closed");
        replicator.startReplication(target, recoverySettings.activityTimeout());
                    }
        public void messageReceived(final ForceSyncRequest request, TransportChannel channel, Task task) throws Exception {
     * Listener that runs on changes in Replication state
    @Override
                final ActionListener<Void> listener = target.createOrFinishListener(channel, Actions.FILE_CHUNK, request);
            clusterService,
        this.transportService = transportService;
import org.opensearch.cluster.node.DiscoveryNode;
import static org.opensearch.indices.replication.SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT;
    }
        if (replicaShard.state().equals(IndexShardState.STARTED) == true) {
    }
            );
                    @Override
            } else {
            for (IndexService indexService : indicesService) {
        }
     */
    }
import org.opensearch.cluster.ClusterStateListener;
        return clusterService.state().nodes().get(primaryShard.currentNodeId());
    @Nullable
            processLatestReceivedCheckpoint(indexShard, Thread.currentThread());
/*
        @Override
     * Start a round of replication and sync to at least the given checkpoint.
            transportService,
        @Override
            new MergedSegmentFileChunkTransportRequestHandler()
import org.opensearch.cluster.service.ClusterService;
package org.opensearch.indices.replication;
        final SegmentReplicationSourceFactory sourceFactory,
        );
import org.apache.logging.log4j.message.ParameterizedMessage;
            replicationId,
        public static final String FORCE_SYNC = "internal:index/shard/replication/segments_sync";
        return replicator.getMergedSegmentReplicationTarget(shardId);
                        // and #20551), leaving the replica behind the checkpoint it was asked to sync to. Comparing
                    request.recoveryId(),
            Actions.FORCE_SYNC,
                    replicaShard.shardId(),
                    } else if (ongoingReplicationTarget.checkpoint.equals(receivedCheckpoint)) {
        RetryableTransportClient transportClient = new RetryableTransportClient(
        final ThreadPool threadPool,
import org.opensearch.index.shard.IndexShard;
                target.handleFileChunk(
    }
                        boolean sendShardFailure
    }
        }
        final SegmentReplicationSourceFactory sourceFactory,
            indexShard.failShard("unrecoverable replication failure", e);
        } else {
                );
                final ActionListener<Void> listener = target.createOrFinishListener(channel, Actions.MERGED_SEGMENT_FILE_CHUNK, request);
                    bytesSinceLastPause,
    ) {
                    state.getReplicationId(),
    }
            clusterService.addListener(this);
            request,
            logger.trace(
                    if (ongoingReplicationTarget.getCheckpoint().getPrimaryTerm() < receivedCheckpoint.getPrimaryTerm()) {
    @Deprecated
import org.opensearch.cluster.ClusterChangedEvent;
        }
    private final SegmentReplicator replicator;
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
            @Override
        }
                    ) {
     */
                });
                                .primaryShard()
            replicator.cancel(indexShard.shardId(), "Shard closing");
                new SegmentReplicationTargetService.SegmentReplicationListener() {
     * calling this handler.
                        boolean sendShardFailure
                        latch.countDown();
                        listener.onFailure(e);
                    return;
                    ) {
        final ThreadPool threadPool,
                        if (sendShardFailure == true) {
    }
        }
                        // round may finalize against a stale metadata checkpoint returned by the primary (see #20550
    public static class Actions {
        if (indexShard != null && indexShard.indexSettings().isSegRepEnabledOrRemoteNode()) {
    private final SegmentReplicationSourceFactory sourceFactory;
        final ClusterService clusterService,
            forceReplication(request, new ChannelActionListener<>(channel, Actions.FORCE_SYNC, request));
        final IndicesService indicesService,
    protected void updateLatestReceivedCheckpoint(ReplicationCheckpoint receivedCheckpoint, IndexShard replicaShard) {
     * @param indexShard - {@link IndexShard} replica shard
        final RecoverySettings recoverySettings,
            if (thread == Thread.currentThread()) {
    // visible to tests
    }
            ) {
        @Override
            .withTimeout(recoverySettings.internalActionTimeout())
        transportService.registerRequestHandler(
                                processLatestReceivedCheckpoint(shard, Thread.currentThread());
        );
                        logger.debug(
            clusterService.removeListener(this);
                            listener.onFailure(e);
        final ReplicationCheckpoint checkpoint,
                        }
                if (ongoingReplicationTarget.getCheckpoint().getPrimaryTerm() < receivedCheckpoint.getPrimaryTerm()) {
                        replicaShard.shardId(),
                    )
                                "[shardId {}] [replication id {}] Merge Replication complete to {}, timing data: {}",
            recoverySettings.internalActionRetryTimeout(),
    public interface SegmentReplicationListener extends ReplicationListener {
     * Cancel any replications on this node for a replica that has just been promoted as the new primary.
                                () -> new ParameterizedMessage(
        );
import java.io.IOException;
                    latestPublishedCheckpoint
 *
            ActionListener.map(listener, r -> null),
                    }
    }
 * The OpenSearch Contributors require contributions made to
        );
                                )
                    ongoingReplicationTarget.cancel("Cancelling stuck target after new primary");
    ) {
                )
                        ReplicationFailedException e,
                            listener.onResponse(TransportResponse.Empty.INSTANCE);
        if (replicaShard.state().equals(IndexShardState.CLOSED)) {
        onNewCheckpoint(receivedCheckpoint, replicaShard, false);
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
                }
            replicaShard.getLatestReplicationCheckpoint()
                ReplicationRef<MergedSegmentReplicationTarget> ref = replicator.getMergeReplicationRef(
                            logger.error("Error while marking replication completed", e);
                        try {
        final IndexShard indexShard,
     * @param isRetry            is it a retry after failure
                final long replicationId = NO_OPS_PERFORMED;
                        updateVisibleCheckpoint(state.getReplicationId(), replicaShard);
            public void onResponse(Void unused) {
                if (indicesService.getShardOrNull(replicaShard.shardId()) != null) {
            options,
                        // catch-up. In the normal case the achieved checkpoint is at least the targeted one, so this
                                .primaryShard()
            if (replicaShard.shouldProcessMergedSegmentCheckpoint(receivedCheckpoint)) {
     * The internal actions
                            )
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
        this.recoverySettings = recoverySettings;
        replicator.startMergedSegmentReplication(indexShard, checkpoint, sourceFactory.get(indexShard), listener);
        ShardRouting primaryShard = clusterService.state().routingTable().shardRoutingTable(replicaShard.shardId()).primaryShard();
        final ActionListener<Void> listener = new ActionListener<>() {
            new FileChunkTransportRequestHandler()
            logger.trace(
        final boolean isRetry,
     * Invoked when a new checkpoint is received from a primary shard.
    private DiscoveryNode getPrimaryNode(ShardRouting primaryShard) {
                replicaShard.routingEntry().allocationId(),
    /**
import org.opensearch.ExceptionsHelper;
                    target,
                        () -> new ParameterizedMessage("Interrupted while waiting for pre copy merged segment [{}]", receivedCheckpoint),
                        if (Objects.nonNull(latestReceivedCheckpoint)
        }
                                updateVisibleCheckpoint(state.getReplicationId(), indexShard);
        @Override
        final IndexShard indexShard,
        if (replicaShard.indexSettings().isAssignedOnRemoteNode() == false) {
                        return;
import org.opensearch.core.transport.TransportResponse;
                            if (indexShard.recoveryState().getPrimary() == true) {
        );
     * It checks if a new checkpoint should be processed or not and starts replication if needed.
        this(
            recoverySettings,
                indexShard.getLatestReplicationCheckpoint(),
     * Force sync transport handler forces round of segment replication. Caller should verify necessary checks before
        try {
import org.opensearch.indices.replication.common.ReplicationFailedException;
        final ReplicationCheckpoint checkpoint,
            new ReplicationCollection<>(logger, threadPool)
import org.opensearch.threadpool.ThreadPool;
            // ignore if shard is closed
                    }
        } else {
                () -> new ParameterizedMessage(
     */
        }
                final SegmentReplicationTarget target = ref.get();
            UPDATE_VISIBLE_CHECKPOINT,
                threadPool.generic().execute(runnable);
        if (event.routingTableChanged()) {
                            )
            return;
                    public void onReplicationFailure(
        logger.debug(
import org.opensearch.indices.recovery.FileChunkRequest;
                            // for this shard look up its primary routing, if it has completed a relocation trigger replication
        final IndexShard replicaShard,
                        ReplicationFailedException e,
public class SegmentReplicationTargetService extends AbstractLifecycleComponent implements ClusterStateListener, IndexEventListener {
                        }
        }
                        unmarkPendingDownloadMergedSegments(replicaShard, receivedCheckpoint);
    }
        if (ExceptionsHelper.unwrap(e, CancellableThreads.ExecutionCancelledException.class) == null) {
                                "[shardId {}] [replication id {}] Replication complete to {}, timing data: {}",
            transportService,
                            ongoingReplicationTarget.description(),
                                replicaShard.shardId().getId(),
                        SegmentReplicationState state,
     * @param listener - {@link ReplicationListener}
    private class ForceSyncTransportRequestHandler implements TransportRequestHandler<ForceSyncRequest> {
                            } else {
        return checkpoint instanceof RemoteStoreMergedSegmentCheckpoint;
            recoverySettings,
                        // does not introduce extra rounds.
            logger.error(
        // This check ensures we do not try to process a received checkpoint while the shard is still recovering, yet we stored the latest
     */
    private final RecoverySettings recoverySettings;
            );
    /**
                            "Ignoring new replication checkpoint - shard is currently replicating to checkpoint {}",
            if (ongoingReplicationTarget != null) {
        }
    @Override
                    logger.warn(
     * @opensearch.internal
                            processLatestReceivedCheckpoint(replicaShard, thread);
    public ReplicationRef<SegmentReplicationTarget> get(long replicationId) {
    }
     * @param indexShard - {@link IndexShard} replica shard
    }
                updateVisibleCheckpoint(replicationId, replicaShard);
        if (replicaShard.state().equals(IndexShardState.STARTED) == true) {
                }
                            "Cancelling ongoing replication {} from old primary with primary term {}",
import org.opensearch.common.Nullable;
                ),
                    request,
                                    "[shardId {}] [replication id {}] Force replication Sync complete to {}, timing data: {}",
     */
            FileChunkRequest::new,
import org.opensearch.transport.TransportService;
    }
    ) {
}
    @Override
                indexShard,
        final UpdateVisibleCheckpointRequest request = new UpdateVisibleCheckpointRequest(
                                replicaShard.getLatestReplicationCheckpoint(),
        public void messageReceived(final FileChunkRequest request, TransportChannel channel, Task task) throws Exception {
                // replicationId is not used by the primary set to a default value.
    }
        final ReplicationCheckpoint checkpoint,
 * @opensearch.internal
    public void onNewCheckpoint(final ReplicationCheckpoint receivedCheckpoint, final IndexShard replicaShard) {
import java.util.concurrent.TimeUnit;
        @Override
     *
import org.opensearch.transport.TransportRequestHandler;
                                .shardRoutingTable(shard.shardId())
        return false;
    public SegmentReplicationTarget startReplication(
                            final String currentNode = event.state()
        return replicator.get(replicationId);
                            receivedCheckpoint,
        final TransportRequestOptions options = TransportRequestOptions.builder()
                        // actually replicated, process it to catch up. We compare against the replica's achieved
                            processLatestReceivedCheckpoint(replicaShard, thread, true);
     * @param replicaShard       replica shard on which checkpoint is received
                                .routingTable()
            return true;
            && oldRouting.primary() == false
import java.util.Objects;
                                replicaShard.shardId().getId(),
import org.opensearch.indices.IndicesService;
                        logReplicationFailure(state, e, indexShard);
                    @Override
        default void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
                } else {
     * @param checkpoint - {@link ReplicationCheckpoint} checkpoint to sync to
        final AtomicLong bytesSinceLastPause = new AtomicLong();
                // if we didn't process the checkpoint because we are up to date,
    protected void doStart() {
    public void clusterChanged(ClusterChangedEvent event) {
                        );
    @Override
        }
        // Update replication checkpoint on source via transport call only supported for remote store integration. For node-
            ForceSyncRequest::new,
     * for primary relocations because they recover from translog.
            && indexShard.indexSettings().isSegRepEnabledOrRemoteNode()
                        "Failed to update visible checkpoint for replica {}, {}:",
import org.opensearch.transport.TransportChannel;
        void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure);
                    () -> new ParameterizedMessage(
 */
        }
import org.opensearch.indices.replication.common.ReplicationCollection.ReplicationRef;
                        e
    /**
                        ReplicationCheckpoint latestReceivedCheckpoint = replicator.getPrimaryCheckpoint(replicaShard.shardId());
     *
                    state.getTimingData()
     * @param replicaShard       replica shard on which checkpoint is received
        }
            logger.error("Error attempting to fail shard", inner);
    public ReplicationRef<MergedSegmentReplicationTarget> getMergedSegmentReplicationRef(long replicationId) {
                                    shardId,
            replicator.initializeStats(indexShard.shardId());
                            )
        logger.debug(() -> new ParameterizedMessage("Replica received new replication checkpoint from primary [{}]", receivedCheckpoint));
            transportService,
            );
     * @param checkpoint - {@link ReplicationCheckpoint} checkpoint to sync to
    private void logReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, IndexShard replicaShard) {
                CountDownLatch latch = new CountDownLatch(1);
                }
                        SegmentReplicationState state,
                    }
            threadPool,
            onReplicationDone((SegmentReplicationState) state);
            try (
import org.opensearch.cluster.routing.ShardRouting;
    protected void doStop() {
    private final IndicesService indicesService;
                    && event.indexRoutingTableChanged(indexService.index().getName())) {
    }
            indicesService,
        final ReplicationCheckpoint receivedCheckpoint,
                    ) {
                            () -> new ParameterizedMessage(
                () -> new ParameterizedMessage(
                        } catch (Exception e) {
                                .currentNodeId();
                        replicaShard.shardId(),
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {
    }
                        // against the targeted checkpoint would miss this case and leave the replica permanently
        } else {
    }
                    if (latch.await(recoverySettings.getMergedSegmentReplicationTimeout().seconds(), TimeUnit.SECONDS) == false) {
            clusterService,
                    "Ignoring merged segment checkpoint, shard not started {} {}",
    }
     */
 * Service class that handles incoming checkpoints to initiate replication events on replicas.
    /**
        return replicator.get(shardId);
        final TransportService transportService,
    private void forceReplication(ForceSyncRequest request, ActionListener<TransportResponse> listener) {
 * this file be licensed under the Apache-2.0 license or a
            }
                        logger.debug(
    public void onNewMergedSegmentCheckpoint(final ReplicationCheckpoint receivedCheckpoint, final IndexShard replicaShard) {
    // visible to tests
    /**
                replicaShard.shardId(),
            replicaShard.routingEntry().allocationId().getId(),
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        );
                }
                        unmarkPendingDownloadMergedSegments(replicaShard, receivedCheckpoint);
        }
            if (replicaShard.shouldProcessCheckpoint(receivedCheckpoint)) {
                                .routingTable()
        if (replicaShard.state().equals(IndexShardState.CLOSED)) {
     * It checks if a new checkpoint should be processed or not and starts replication if needed.
            );
                                    state.getTimingData()
        final SegmentReplicationListener listener
                            () -> new ParameterizedMessage(
        if (indexShard == null || indexShard.isReplicationTarget() == false) {
    // pkg-private for integration tests
import org.opensearch.indices.recovery.RecoverySettings;
            getPrimaryNode(primaryShard),
import org.opensearch.indices.replication.common.ReplicationState;
    }
        final ThreadPool threadPool,
import org.opensearch.indices.replication.checkpoint.RemoteStoreMergedSegmentCheckpoint;
    public void shardRoutingChanged(IndexShard indexShard, @Nullable ShardRouting oldRouting, ShardRouting newRouting) {
    public SegmentReplicationTarget get(ShardId shardId) {
            }
     * @param listener - {@link ReplicationListener}
            () -> new ParameterizedMessage(
            logger.debug(
                                state.getTimingData()
                    @Override
 * compatible open source license.
     * @param receivedCheckpoint received checkpoint that is checked for processing
                        "Successfully updated replication checkpoint {} for replica {}",
     * @param receivedCheckpoint received checkpoint that is checked for processing
        final ReplicationCheckpoint latestPublishedCheckpoint = replicator.getPrimaryCheckpoint(replicaShard.shardId());
            sourceFactory,
                        ReplicationFailedException e,
import org.opensearch.tasks.Task;
        transportService.registerRequestHandler(
                        logReplicationFailure(state, e, replicaShard);
                            failShard(e, indexShard);
import org.opensearch.index.IndexService;
    public SegmentReplicationTargetService(
import org.opensearch.indices.recovery.RetryableTransportClient;
                    @Override
    }
    ) {
                    () -> new ParameterizedMessage(
                            )
                    );
                        SegmentReplicationState state,
    @Override
                        )
            getPrimaryNode(primaryShard),
            List<MergedSegmentReplicationTarget> ongoingReplicationTargetList = getMergedSegmentReplicationTarget(replicaShard.shardId());
