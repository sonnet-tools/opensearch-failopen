                        if (sendShardFailure == true) {
                            final String previousNode = event.previousState()  
                    && event.indexRoutingTableChanged(indexService.index().getName())) {
     */
 * Service class that handles incoming checkpoints to initiate replication events on replicas.
import java.util.List;  
 */
            // Checks if received checkpoint is already present and ahead then it replaces old received checkpoint
                    }
        final TransportService transportService,  
            clusterService.addListener(this);
    /**
                }
    private class ForceSyncTransportRequestHandler implements TransportRequestHandler<ForceSyncRequest> {
            // Checks if received checkpoint is already present  
                            )
    /**
        if (event.routingTableChanged()) {
                indexShard.getLatestReplicationCheckpoint(),
            if (replicaShard.shouldProcessMergedSegmentCheckpoint(receivedCheckpoint)) {  
            new SegmentReplicator(threadPool)
                        unmarkPendingDownloadMergedSegments(replicaShard, receivedCheckpoint);
            ThreadPool.Names.GENERIC,  
import org.opensearch.indices.recovery.FileChunkRequest;
     * @return {@link SegmentReplicationTarget} target event orchestrating the event.
            startReplication(
            options,  
        if (isRemoteStoreMergedSegmentCheckpoint(receivedCheckpoint)) {
     *
                        latch.countDown();
        return false;
                            logger.error("Error while marking replication completed", e);  
                    ongoingReplicationTarget.cancel("Cancelling stuck target after new primary");
        final boolean isRetry,  
            forceReplication(request, new ChannelActionListener<>(channel, Actions.FORCE_SYNC, request));
        return replicator.getMergedSegmentReplicationTarget(shardId);
                            failShard(e, replicaShard);  
    }  
            return;
    public SegmentReplicationTarget startReplication(
        public void messageReceived(final ForceSyncRequest request, TransportChannel channel, Task task) throws Exception {  
    /**
                    if (ongoingReplicationTarget.getCheckpoint().getPrimaryTerm() < receivedCheckpoint.getPrimaryTerm()) {
            logger.debug(  
    @Override  
    @Override  
                final MergedSegmentReplicationTarget target = ref.get();
     */  
            public void onFailure(Exception e) {  
                startReplication(replicaShard, receivedCheckpoint, isRetry, new SegmentReplicationListener() {
                    ) {  
                        () -> new ParameterizedMessage("Interrupted while waiting for pre copy merged segment [{}]", receivedCheckpoint),
    public void onNewCheckpoint(final ReplicationCheckpoint receivedCheckpoint, final IndexShard replicaShard) {  
            new ReplicationCollection<>(logger, threadPool)
                    public void onReplicationDone(SegmentReplicationState state) {
                // if we retry ensure the shard is not in the process of being closed.  
            recoverySettings,
            onReplicationDone((SegmentReplicationState) state);
        this.clusterService = clusterService;  
    public SegmentReplicationTarget startReplication(  
            listener.onResponse(TransportResponse.Empty.INSTANCE);
            );
                }
            indicesService,
                    replicaShard.shardId(),
                            )  
     * @opensearch.internal
        this.sourceFactory = sourceFactory;
                threadPool.generic().execute(runnable);
                final ActionListener<Void> listener = target.createOrFinishListener(channel, Actions.MERGED_SEGMENT_FILE_CHUNK, request);  
                        request.getCheckpoint()  
        public void messageReceived(final FileChunkRequest request, TransportChannel channel, Task task) throws Exception {
                    }
                            receivedCheckpoint,
            );
        final ClusterService clusterService,  
        final IndexShard indexShard,  
    }
import java.io.IOException;
    protected void doStop() {  
                replicaShard.routingEntry().allocationId(),
            new ForceSyncTransportRequestHandler()
                // send our latest checkpoint to the primary to update tracking.
                () -> new ParameterizedMessage("Ignoring checkpoint, shard not started {} {}", receivedCheckpoint, replicaShard.state())  
                            failShard(e, indexShard);
    public synchronized void onNewCheckpoint(  
            recoverySettings,
            Actions.FILE_CHUNK,
    public ReplicationRef<SegmentReplicationTarget> get(long replicationId) {
package org.opensearch.indices.replication;
                        }
    private final RecoverySettings recoverySettings;
                        e  
                        );
                ),
                                )
            && newRouting.primary()) {
/**
                logger.trace(
            indexShard.failShard("unrecoverable replication failure", e);  
     * It checks if a new checkpoint should be processed or not and starts replication if needed.
        );  
        try {
        updateLatestReceivedCheckpoint(receivedCheckpoint, replicaShard);  
    @Deprecated  
                                ongoingReplicationTarget.getCheckpoint()
            && oldRouting.primary() == false
    @Override
    private final ClusterService clusterService;  
            assert replicator.size() == 0 : "Replication collection should be empty on shutdown";
    }
    @Deprecated
            }  
                    )
    }
        return replicator.getCompleted(shardId);
                    @Override  
                            "Ignoring new replication checkpoint - shard is currently replicating to checkpoint {}",
            public void onResponse(Void unused) {
    }  
        final IndexShard indexShard,
                        logger.debug(
    private void unmarkPendingDownloadMergedSegments(IndexShard shard, ReplicationCheckpoint receivedCheckpoint) {  
                        // does not introduce extra rounds.
                            }  
                        } catch (Exception e) {
import org.opensearch.index.shard.IndexEventListener;
import org.opensearch.indices.replication.common.ReplicationListener;
                CountDownLatch latch = new CountDownLatch(1);
                }
        replicator.startMergedSegmentReplication(indexShard, checkpoint, sourceFactory.get(indexShard), listener);
    private final ThreadPool threadPool;  
                ReplicationRef<MergedSegmentReplicationTarget> ref = replicator.getMergeReplicationRef(  
        final ShardId shardId = request.getShardId();  
    }
                        logReplicationFailure(state, e, indexShard);
import org.opensearch.indices.replication.common.ReplicationCollection;
                            if (previousNode.equals(currentNode) == false) {
import org.apache.logging.log4j.message.ParameterizedMessage;  
        }
    }
     * @param receivedCheckpoint received checkpoint that is checked for processing
        void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure);  
    }  
            );
    }  
            return;  
        } else {
            ForceSyncRequest::new,
        final IndicesService indicesService,
            sourceFactory,
                                state.getReplicationId(),  
        final ActionListener<Void> listener = new ActionListener<>() {
import org.opensearch.common.settings.Settings;
                    @Override  
        if (indexShard != null && indexShard.indexSettings().isSegRepEnabledOrRemoteNode()) {
    }  
                                .routingTable()  
    /**
                                // Update the replica's checkpoint on primary's replication tracker.
public class SegmentReplicationTargetService extends AbstractLifecycleComponent implements ClusterStateListener, IndexEventListener {
                );
            && indexShard.indexSettings().isSegRepEnabledOrRemoteNode()  
                } catch (InterruptedException e) {  
        @Override  
            // ignore if shard is closed
import org.opensearch.index.shard.IndexShard;
            indicesService,
            logger.trace(() -> "Ignoring checkpoint, Shard is closed");  
            }
                            processLatestReceivedCheckpoint(replicaShard, thread, true);
                        ongoingReplicationTarget.cancel("Cancelling stuck merged segment target after new primary");  
        public static final String FORCE_SYNC = "internal:index/shard/replication/segments_sync";
                () -> new ParameterizedMessage(
    /**  
        assert indicesService != null;
                        ReplicationCheckpoint latestReceivedCheckpoint = replicator.getPrimaryCheckpoint(replicaShard.shardId());  
        final IndicesService indicesService,
                    state.getTimingData()
                });  
            () -> new ParameterizedMessage("Replica received new merged segment checkpoint [{}] from primary", receivedCheckpoint)  
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {  
        );
            logger.trace(
        }  
     * @param listener - {@link ReplicationListener}  
                final SegmentReplicationTarget target = ref.get();
    private void forceReplication(ForceSyncRequest request, ActionListener<TransportResponse> listener) {
     *
                    ),  
            );
                // if we didn't process the checkpoint because we are up to date,
            if (ongoingReplicationTarget != null) {
                        SegmentReplicationState state,  
                    } else if (ongoingReplicationTarget.checkpoint.equals(receivedCheckpoint)) {
    protected void updateLatestReceivedCheckpoint(ReplicationCheckpoint receivedCheckpoint, IndexShard replicaShard) {  
                            }  
    }  
                                receivedCheckpoint,
 * this file be licensed under the Apache-2.0 license or a
            replicaShard.getLatestReplicationCheckpoint()  
            // ignore if shard is closed
            replicationId,
                    request.shardId()
                        );
                                "Cancelling ongoing merge replication {} from old primary with primary term {}",
                );
        if (DiscoveryNode.isDataNode(clusterService.getSettings())) {
                                    state.getReplicationId(),
        final RecoverySettings recoverySettings,
import org.opensearch.threadpool.ThreadPool;
import java.util.Objects;
            getPrimaryNode(primaryShard),
import org.opensearch.cluster.service.ClusterService;
                        // If the latest checkpoint known from the primary is still ahead of what this replica has  
        return clusterService.state().nodes().get(primaryShard.currentNodeId());
    private void failShard(ReplicationFailedException e, IndexShard indexShard) {
                () -> new ParameterizedMessage(
                                "[shardId {}] [replication id {}] Replication complete to {}, timing data: {}",
import org.opensearch.transport.TransportRequestHandler;
                    public void onReplicationDone(SegmentReplicationState state) {
     */
        final UpdateVisibleCheckpointRequest request = new UpdateVisibleCheckpointRequest(
        transportClient.executeRetryableAction(  
            try (ReplicationRef<SegmentReplicationTarget> ref = replicator.get(request.recoveryId(), request.shardId())) {
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        final ReplicationCheckpoint checkpoint,
            clusterService,  
        };
    ) {
        }
                        unmarkPendingDownloadMergedSegments(replicaShard, receivedCheckpoint);  
            .withTimeout(recoverySettings.internalActionTimeout())
                                state.getTimingData()
                        if (Objects.nonNull(latestReceivedCheckpoint)
            );
        } catch (Exception inner) {
                try {
        }
            threadPool,
        }
                target.handleFileChunk(request, target, bytesSinceLastPause, recoverySettings.replicationRateLimiter(), listener);
    // visible to tests
    public SegmentReplicationState getlatestCompletedEventSegmentReplicationState(ShardId shardId) {
                    public void onReplicationFailure(
        } else {  
                        try {
                        SegmentReplicationState state,
        public void messageReceived(final FileChunkRequest request, TransportChannel channel, Task task) throws Exception {  
        return replicator.getMergeReplicationRef(replicationId);
                            if (indexShard.recoveryState().getPrimary() == true) {
     * @opensearch.internal
        // Checks if replica shard is in the correct STARTED state to process checkpoints (avoids parallel replication events taking place)
     *
        }  
            logger  
        this.threadPool = threadPool;
                            "Cancelling ongoing replication {} from old primary with primary term {}",
        transportService.registerRequestHandler(
    public SegmentReplicationTargetService(
        this(  
        }  
import org.opensearch.indices.replication.common.ReplicationFailedException;
                                replicaShard.getLatestReplicationCheckpoint(),
     * Invoked when a new checkpoint is received from a primary shard.
                            ongoingReplicationTarget.getCheckpoint()  
            transportService,  
                        updateVisibleCheckpoint(state.getReplicationId(), replicaShard);
    private class FileChunkTransportRequestHandler implements TransportRequestHandler<FileChunkRequest> {  
    private final TransportService transportService;
                () -> new ParameterizedMessage(  
            SegmentReplicationTarget ongoingReplicationTarget = replicator.get(replicaShard.shardId());  
            Runnable runnable = () -> {
                    );  
    }
        public static final String MERGED_SEGMENT_FILE_CHUNK = "internal:index/shard/replication/merged_segment_file_chunk";  
                            () -> new ParameterizedMessage(  
                    e
                    target,  
                    state.getReplicationId()
    ) {
        );
    ) {  
     * @param receivedCheckpoint received checkpoint that is checked for processing  
 * @opensearch.internal  
     * Invoked when a new checkpoint is received from a primary shard.  
     * @param checkpoint - {@link ReplicationCheckpoint} checkpoint to sync to
                        ReplicationFailedException e,
            Actions.FORCE_SYNC,
     * @param replicaShard       replica shard on which checkpoint is received
import org.opensearch.ExceptionsHelper;
        final TransportRequestOptions options = TransportRequestOptions.builder()  
                }  
    ) {  
        // This check ensures we do not try to process a received checkpoint while the shard is still recovering, yet we stored the latest
    // visible to tests  
                    () -> new ParameterizedMessage(
                            ongoingReplicationTarget.getCheckpoint().getPrimaryTerm()
                    logger.debug(  
                    @Override
    private DiscoveryNode getPrimaryNode(ShardRouting primaryShard) {  
                    );
    /**
        final IndexShard indexShard,  
    }  
 * compatible open source license.
        );
import org.opensearch.indices.recovery.RetryableTransportClient;
    // pkg-private for integration tests  
                        logReplicationFailure(state, e, replicaShard);
                                "Ignoring new merge replication checkpoint - shard is currently replicating to checkpoint {}",
        onNewCheckpoint(receivedCheckpoint, replicaShard, false);
        // Update replication checkpoint on source via transport call only supported for remote store integration. For node-  
        if (oldRouting != null
    @Override
        this.replicator = replicator;
            }
            processLatestReceivedCheckpoint(indexShard, Thread.currentThread());
        return replicator.get(replicationId);  
                        SegmentReplicationState state,
     */
    void startReplication(final SegmentReplicationTarget target) {
    public interface SegmentReplicationListener extends ReplicationListener {
        this.indicesService = indicesService;
                    "Processing latest received checkpoint for shard {} {}",  
        @Override
     * @param isRetry            is it a retry after failure
                logger.error(
                                () -> new ParameterizedMessage(
                        listener.onFailure(e);  
            logger.error("Error attempting to fail shard", inner);
            if (ongoingReplicationTargetList != null) {
                        return;
    /**
                                    shardId,  
    @Nullable
    // visible to tests
                        )
                        () -> new ParameterizedMessage(
import org.opensearch.cluster.node.DiscoveryNode;
                    }
                "Updating Primary shard that replica {}-{} is synced to checkpoint {}",
                e  
                        logger.warn(  
            FileChunkRequest::new,
                                indexShard.resetToWriteableEngine();
            logger.trace(
                target.handleFileChunk(
    ) {
                    public void onReplicationFailure(
     * Replay any received checkpoint while replica was recovering.  This does not need to happen
        );
     */
import java.util.concurrent.CountDownLatch;  
     */  
import java.util.Optional;
import org.opensearch.indices.replication.common.ReplicationState;  
import org.opensearch.common.util.CancellableThreads;
                    request.recoveryId(),
import org.opensearch.cluster.ClusterChangedEvent;  
                // replicationId is not used by the primary set to a default value.  
        final TransportService transportService,
            @Override  
            replicator.initializeStats(indexShard.shardId());
            }  
     */  
            List<MergedSegmentReplicationTarget> ongoingReplicationTargetList = getMergedSegmentReplicationTarget(replicaShard.shardId());
    public void afterIndexShardStarted(IndexShard indexShard) {
                        // behind until the next publish; comparing against the achieved checkpoint re-triggers the  
                                    state.getTimingData()  
                        )
            transportService,  
        }
                                replicaShard.shardId().getId(),
        ShardRouting primaryShard = clusterService.state().routingTable().shardRoutingTable(replicaShard.shardId()).primaryShard();
     */
            Actions.MERGED_SEGMENT_FILE_CHUNK,
                        );
    private final IndicesService indicesService;
            primaryShard.shardId(),
            )  
        return processLatestReceivedCheckpoint(replicaShard, thread, false);  
import org.opensearch.indices.recovery.RecoverySettings;
        if (replicaShard.state().equals(IndexShardState.CLOSED)) {  
    public SegmentReplicationState getOngoingEventSegmentReplicationState(ShardId shardId) {
                                    "[shardId {}] [replication id {}] Force replication Sync complete to {}, timing data: {}",
     */
        final IndexShard replicaShard,
        } else {
    }
        );
        return Optional.ofNullable(getOngoingEventSegmentReplicationState(shardId))
        return startReplication(indexShard, checkpoint, false, listener);
        return replicator.startReplication(indexShard, checkpoint, sourceFactory.get(indexShard), isRetry, listener);  
import org.opensearch.core.index.shard.ShardId;
        // Proceed with round of segment replication only when it is allowed  
                    if (latch.await(recoverySettings.getMergedSegmentReplicationTimeout().seconds(), TimeUnit.SECONDS) == false) {
                        () -> new ParameterizedMessage(
     *  
                    replicaShard.shardId(),
import org.opensearch.indices.recovery.ForceSyncRequest;  
    ) {
            return true;  
        final SegmentReplicationSourceFactory sourceFactory,
     * @param indexShard - {@link IndexShard} replica shard  
            e.addSuppressed(inner);  
     */  
                            listener.onResponse(TransportResponse.Empty.INSTANCE);
                        }
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
        final IndexShard indexShard = indicesService.getShardOrNull(shardId);
 *
        final SegmentReplicationSourceFactory sourceFactory,  
    @Nullable
        }  
     * @return {@link SegmentReplicationTarget} target event orchestrating the event.  
            .build();
                    }
                            )  
    @Nullable  
    /**
        void onReplicationDone(SegmentReplicationState state);
                        // checkpoint rather than the checkpoint this round targeted (receivedCheckpoint). A retry
    }
 * SPDX-License-Identifier: Apache-2.0
                    }
                    recoverySettings.mergedSegmentReplicationRateLimiter(),
        }
        // node communication, checkpoint update is piggy-backed to GET_SEGMENT_FILES transport call
        }
                });
    private final SegmentReplicator replicator;
            clusterService.removeListener(this);  
                        );
            try (
    }
     * Start a round of replication and sync to at least the given checkpoint.
        }
                    public void onReplicationDone(SegmentReplicationState state) {
                    onNewCheckpoint(replicator.getPrimaryCheckpoint(replicaShard.shardId()), replicaShard, isRetry);  
                        if (sendShardFailure) {  
    }
import org.opensearch.core.action.ActionListener;  
                                state.getTimingData()
        }
import org.opensearch.action.support.ChannelActionListener;
        return checkpoint instanceof RemoteStoreMergedSegmentCheckpoint;
    public void shardRoutingChanged(IndexShard indexShard, @Nullable ShardRouting oldRouting, ShardRouting newRouting) {
        logger.trace(  
        @Override
            .orElseGet(() -> getlatestCompletedEventSegmentReplicationState(shardId));
            getPrimaryNode(primaryShard),
    /**  
 * The OpenSearch Contributors require contributions made to  
            }
    }
        this.transportService = transportService;
                        replicaShard.shardId(),
                request.getCheckpoint()
    protected void doClose() throws IOException {
                    ) {
                                "[shardId {}] [replication id {}] Merge Replication complete to {}, timing data: {}",
                        boolean sendShardFailure
                            () -> new ParameterizedMessage(  
                        // round may finalize against a stale metadata checkpoint returned by the primary (see #20550  
    }
        }
        final ReplicationCheckpoint checkpoint,
                                updateVisibleCheckpoint(state.getReplicationId(), indexShard);
            );  
                    for (IndexShard shard : indexService) {  
                            processLatestReceivedCheckpoint(replicaShard, thread);  
                for (MergedSegmentReplicationTarget ongoingReplicationTarget : ongoingReplicationTargetList) {  
     * @param isRetry - is it a retry after failure
     * Start a round of replication and sync to at least the given checkpoint.
    }
    private void logReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, IndexShard replicaShard) {
        return Optional.ofNullable(replicator.get(shardId)).map(SegmentReplicationTarget::state).orElse(null);  
            request,
    @Override
import org.opensearch.cluster.ClusterStateListener;
                        replicaShard.shardId(),
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {  
                                .currentNodeId();  
                if (ongoingReplicationTarget.getCheckpoint().getPrimaryTerm() < receivedCheckpoint.getPrimaryTerm()) {
                            )  
                indexShard,  
                if (indexService.getIndexSettings().isSegRepEnabledOrRemoteNode()
                                processLatestReceivedCheckpoint(shard, Thread.currentThread());
    private static final Logger logger = LogManager.getLogger(SegmentReplicationTargetService.class);
            if (replicaShard.shouldProcessCheckpoint(receivedCheckpoint)) {
                        }
                    "[shardId {}] [replication id {}] Replication cancelled",
                    }
     * calling this handler.
                            () -> new ParameterizedMessage(  
            sourceFactory,
                        logger.debug(
                            ongoingReplicationTarget.description(),  
import org.opensearch.tasks.Task;
            } else if (replicaShard.isSegmentReplicationAllowed()) {  
                    "Ignoring merged segment checkpoint, shard not started {} {}",
                        boolean sendShardFailure  
        final ThreadPool threadPool,
                    state.getReplicationId(),  
     */
     */
    public void onNewMergedSegmentCheckpoint(final ReplicationCheckpoint receivedCheckpoint, final IndexShard replicaShard) {
     * Cancel any replications on this node for a replica that is about to be closed.  
                                .currentNodeId();
        // if the shard is in any state  
        final ReplicationCheckpoint latestPublishedCheckpoint = replicator.getPrimaryCheckpoint(replicaShard.shardId());
        final TransportService transportService,
    }
     * returns SegmentReplicationState of latest completed segment replication events.
                    replicaShard.shardId(),  
                        // update visible checkpoint to primary  
                                state.getReplicationId(),  
        if (replicaShard.state().equals(IndexShardState.STARTED) == true) {
        }
                }
                                    indexShard.getLatestReplicationCheckpoint(),
     */
            }
        final RecoverySettings recoverySettings,
                }
                    listener  
            clusterService,  
            replicator.cancel(indexShard.shardId(), "Shard closing");
        final IndicesService indicesService,  
            // Checks if we are using same thread and forks if necessary.  
    }  
                    "[shardId {}] [replication id {}] Replication failed, timing data: {}",
                } else {
                                replicaShard.shardId().getId(),
        final ReplicationCheckpoint receivedCheckpoint,
                            // for this shard look up its primary routing, if it has completed a relocation trigger replication
        );  
        logger.debug(
                            logger.trace(  
                            );
     * for primary relocations because they recover from translog.
    @Override
        final ThreadPool threadPool,
        // checkpoint to be replayed once the shard is Active.  
                                .primaryShard()
        replicator.updateReplicationCheckpointStats(receivedCheckpoint, replicaShard);
    private boolean isRemoteStoreMergedSegmentCheckpoint(ReplicationCheckpoint checkpoint) {  
    public void clusterChanged(ClusterChangedEvent event) {
        final SegmentReplicationListener listener
            FileChunkRequest::new,
            new MergedSegmentFileChunkTransportRequestHandler()
                                ongoingReplicationTarget.description(),
                    public void onReplicationFailure(  
import org.opensearch.index.shard.IndexShardState;  
        final ThreadPool threadPool,  
    }
    public ReplicationRef<MergedSegmentReplicationTarget> getMergedSegmentReplicationRef(long replicationId) {  
        @Override  
        if (indexShard == null || indexShard.isReplicationTarget() == false) {
    private final SegmentReplicationSourceFactory sourceFactory;  
                    }  
     * Listener that runs on changes in Replication state  
        final RecoverySettings recoverySettings,  
    }
     * returns SegmentReplicationState of on-going if present or completed segment replication events.  
        this.recoverySettings = recoverySettings;  
import org.apache.logging.log4j.Logger;
                                .shardRoutingTable(shard.shardId())
            }
        logger.debug(() -> new ParameterizedMessage("Replica received new replication checkpoint from primary [{}]", receivedCheckpoint));
import org.opensearch.transport.TransportRequestOptions;
import org.opensearch.transport.TransportService;  
                        // against the targeted checkpoint would miss this case and leave the replica permanently
                    replicaShard.state()  
        // only log as error if error is not a cancellation.  
                                .shardRoutingTable(shard.shardId())
     * The internal actions
                        // catch-up. In the normal case the achieved checkpoint is at least the targeted one, so this
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;  
        }
                new SegmentReplicationTargetService.SegmentReplicationListener() {
                    bytesSinceLastPause,
    /**  
                            && latestReceivedCheckpoint.isAheadOf(replicaShard.getLatestReplicationCheckpoint())) {
                            listener.onFailure(e);
        final SegmentReplicationSourceFactory sourceFactory,
    protected boolean processLatestReceivedCheckpoint(IndexShard replicaShard, Thread thread) {
                    @Override  
        return replicator.get(shardId);
            onReplicationFailure((SegmentReplicationState) state, e, sendShardFailure);
            logger.error(
                        ReplicationFailedException e,
                startMergedSegmentReplication(replicaShard, receivedCheckpoint, new SegmentReplicationListener() {
        final SegmentReplicationListener listener
                () -> new ParameterizedMessage(  
            return;  
     * @param listener - {@link ReplicationListener}
            replicator.cancel(indexShard.shardId(), "Shard has been promoted to primary");  
        );
    /**
            final Thread thread = Thread.currentThread();  
    /**
        replicator.startReplication(target, recoverySettings.activityTimeout());
                ),
                    receivedCheckpoint,
    protected void doStart() {
     * @param indexShard - {@link IndexShard} replica shard  
        if (replicaShard.state().equals(IndexShardState.STARTED) == true) {
        }  
            recoverySettings.internalActionRetryTimeout(),
        @Override
        final ClusterService clusterService,
                final ActionListener<Void> listener = target.createOrFinishListener(channel, Actions.FILE_CHUNK, request);  
    private class MergedSegmentFileChunkTransportRequestHandler implements TransportRequestHandler<FileChunkRequest> {
import org.opensearch.cluster.routing.ShardRouting;  
            logger.trace(() -> "Ignoring merged segment checkpoint, Shard is closed");
        // if the shard is in any state
            ) {
import org.opensearch.core.transport.TransportResponse;
        if (replicaShard.state().equals(IndexShardState.CLOSED)) {
        default void onDone(ReplicationState state) {
                    latestPublishedCheckpoint
 */  
    }  
                    logger.debug(  
    public void startMergedSegmentReplication(
                updateVisibleCheckpoint(replicationId, replicaShard);
        transportService.registerRequestHandler(
        if (ExceptionsHelper.unwrap(e, CancellableThreads.ExecutionCancelledException.class) == null) {
    public SegmentReplicationTarget get(ShardId shardId) {
                        boolean sendShardFailure
                        logger.debug(
     * @param replicaShard       replica shard on which checkpoint is received  
                        );
                );
    /**  
    }
                                ongoingReplicationTarget.getCheckpoint().getPrimaryTerm()  
        // How many bytes we've copied since we last called RateLimiter.pause
                )
    protected void updateVisibleCheckpoint(long replicationId, IndexShard replicaShard) {
            shard.getRemoteDirectory().unmarkMergedSegmentsPendingDownload(receivedCheckpoint.getMetadataMap().keySet());
                    ) {
        if (replicaShard.indexSettings().isAssignedOnRemoteNode() == false) {
                if (indicesService.getShardOrNull(replicaShard.shardId()) != null) {
    }
                        // actually replicated, process it to catch up. We compare against the replica's achieved
    public SegmentReplicationTargetService(
import org.opensearch.indices.IndicesService;
            ThreadPool.Names.GENERIC,  
                    logger.warn(
    }  
                    @Override  
    }
        }
    }
        }
            }  
            @Override
import org.opensearch.transport.TransportChannel;  
        final SegmentReplicationListener listener
        transportService.registerRequestHandler(
        if (latestPublishedCheckpoint != null) {  
            in -> TransportResponse.Empty.INSTANCE
                        // and #20551), leaving the replica behind the checkpoint it was asked to sync to. Comparing
        );  
    }
        replicator.setSourceFactory(sourceFactory);
                            recoverySettings.getMergedSegmentReplicationTimeout().seconds()  
        }  
                        "Successfully updated replication checkpoint {} for replica {}",
        final ClusterService clusterService
                        ReplicationFailedException e,  
                        "Failed to update visible checkpoint for replica {}, {}:",  
import static org.opensearch.indices.replication.SegmentReplicationSourceService.Actions.UPDATE_VISIBLE_CHECKPOINT;
        if (indexShard.indexSettings().isSegRepEnabledOrRemoteNode() && indexShard.routingEntry().primary() == false) {  
    }
                            final String currentNode = event.state()
            } else {  
                                .routingTable()
            ActionListener.map(listener, r -> null),
                            // Promote engine type for primary target  
                        latch.countDown();  
        }  
                                .primaryShard()  
                    () -> new ParameterizedMessage(  
                )  
     * returns SegmentReplicationState of on-going segment replication events.
        );  
                    @Override
    List<MergedSegmentReplicationTarget> getMergedSegmentReplicationTarget(ShardId shardId) {
            logger.trace(
            // We are skipping any validation for an incoming checkpoint, use the shard's latest checkpoint in the target.
            threadPool,
            }
        RetryableTransportClient transportClient = new RetryableTransportClient(
        } else {
                replicaShard.shardId(),  
    ) {
            new FileChunkTransportRequestHandler()
import org.opensearch.indices.replication.common.ReplicationCollection.ReplicationRef;  
    public SegmentReplicationState getSegmentReplicationState(ShardId shardId) {  
        final AtomicLong bytesSinceLastPause = new AtomicLong();
            if (thread == Thread.currentThread()) {
import org.opensearch.indices.replication.checkpoint.RemoteStoreMergedSegmentCheckpoint;  
                        }  
    }
import org.apache.logging.log4j.LogManager;
                    );
    }
        // How many bytes we've copied since we last called RateLimiter.pause  
                    }
    }  
            ThreadPool.Names.GENERIC,  
        final ReplicationCollection<SegmentReplicationTarget> ongoingSegmentReplications
    }
import org.opensearch.index.IndexService;  
     * Cancel any replications on this node for a replica that has just been promoted as the new primary.
        final SegmentReplicator replicator  
/*  
    }
                            () -> new ParameterizedMessage(  
            };
     * Force sync transport handler forces round of segment replication. Caller should verify necessary checks before
                        }
    public SegmentReplicationTargetService(  
            transportService,  
                            } else {  
                        } else {
            () -> new ParameterizedMessage(
            replicaShard.routingEntry().allocationId().getId(),  
    }  
                            "Merged segment replication for {} timed out after [{}] seconds",
}
                )  
        this(  
    protected boolean processLatestReceivedCheckpoint(IndexShard replicaShard, Thread thread, boolean isRetry) {
            for (IndexService indexService : indicesService) {  
                runnable.run();
        final ReplicationCheckpoint checkpoint,
                        if (shard.routingEntry().primary() == false && shard.routingEntry().isSearchOnly() == false) {
     * It checks if a new checkpoint should be processed or not and starts replication if needed.  
        boolean isRetry  
            }  
                    request,
                e  
                        logger.debug(
        public static final String FILE_CHUNK = "internal:index/shard/replication/file_chunk";
    @Override
        final AtomicLong bytesSinceLastPause = new AtomicLong();  
        default void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {  
                    return;  
     * @param checkpoint - {@link ReplicationCheckpoint} checkpoint to sync to
                // it will be removed from indexService's collection before the shard is actually marked as closed.
import org.opensearch.common.Nullable;
                    }  
    }  
                        request.getCheckpoint()
                final long replicationId = NO_OPS_PERFORMED;
            UPDATE_VISIBLE_CHECKPOINT,
    public static class Actions {  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
