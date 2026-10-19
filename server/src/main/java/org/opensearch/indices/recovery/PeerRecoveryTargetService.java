    }
        RecoveryRunner(long recoveryId, StartRecoveryRequest startRecoveryRequest) {
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {  
     * <a href="https://github.com/opensearch-project/OpenSearch/issues/4502">github issue</a> on it.
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.get(recoveryId)) {  
        public void messageReceived(final RecoveryHandoffPrimaryContextRequest request, final TransportChannel channel, Task task)  
        }
import org.opensearch.transport.TransportException;  
        final TransportRequest requestToSend;
                }  
        logger.trace("{} local file count [{}]", recoveryTarget.shardId(), metadataSnapshot.size());
    class TranslogOperationsRequestHandler implements TransportRequestHandler<RecoveryTranslogOperationsRequest> {
            // do this through ongoing recoveries to remove it from the collection
                    recoverySettings.recoveryRateLimiter(),
import org.opensearch.OpenSearchTimeoutException;
                    indexShard.preRecovery();  
    private final RecoverySettings recoverySettings;  
                    luceneSample  
 * compatible open source license.
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(
 * <p>  
            // the REESTABLISH_RECOVERY request. In this case, we delay and then attempt to restart.
            startRequest.sourceNode(),
            final Consumer<Exception> retryOnMappingException = exception -> {  
        }  
                                "Exception while downloading segment files from remote store, will continue with peer to peer segment copy",
                request.maxSeqNoOfUpdatesOrDeletesOnPrimary(),
            Throwable cause = ExceptionsHelper.unwrapCause(e);
            this.timer = timer;
    }
                            }
     *
            final ActionListener<Void> listener,  
            recoveryTarget.indexShard().routingEntry().allocationId().getId(),
                    .append(", took [")
        RecoverySettings recoverySettings,
            return new RecoveryResponse(in);
                    logger.warn(
            recoverySettings.activityTimeout()  
        final long recoveryId = onGoingRecoveries.start(
        transportService.sendRequest(  
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.FILE_CHUNK, request);
                logger.trace("{}", sb);  
            }
            }  
import org.apache.logging.log4j.message.ParameterizedMessage;  
            };
                // which causes local mapping changes since the mapping (clusterstate) might not have arrived on this node.
 */  
        }
            RecoveryPrepareForTranslogOperationsRequest::new,
        }
                // we do not need to use a timeout here since the entire recovery mechanism has an inactivity protection (it will be
                    .append(" with total_size of [")
     * @opensearch.internal
    }  
                request.operations(),
    private void doRecovery(final long recoveryId, final StartRecoveryRequest preExistingRequest) {  
            throws Exception {
        final AtomicLong bytesSinceLastPause = new AtomicLong();
            // PeerRecoveryNotFound is returned when the source node cannot find the recovery requested by  
        public void messageReceived(final FileChunkRequest request, TransportChannel channel, Task task) throws Exception {
    private class RecoveryResponseHandler implements TransportResponseHandler<RecoveryResponse> {
                    // that the primary used to index the operations in the request.
            if (verifyTranslog) {  
        threadPool.scheduleUnlessShuttingDown(retryAfter, ThreadPool.Names.GENERIC, new RecoveryRunner(recoveryId, request));  
        DiscoveryNode localNode,  
import org.opensearch.index.shard.IndexEventListener;
                    .limit(5)  
                    e
            new CleanFilesRequestHandler()  
@PublicApi(since = "1.0.0")  
                            logger.error(
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
                recoveryRef.get().handoffPrimaryContext(request.primaryContext());  
            this.recoveryId = recoveryId;  
            Actions.TRANSLOG_OPS,  
                        );
                });  
import org.opensearch.cluster.ClusterState;  
                    request.phase1ExistingFileNames,
    }  
                actionName = PeerRecoverySourceService.Actions.REESTABLISH_RECOVERY;
                // unwrap an exception that was thrown as part of the recovery
    }
            final RecoveryTarget recoveryTarget = recoveryRef.get();
                logger.debug("{} starting recovery from {}", startRequest.shardId(), startRequest.sourceNode());  
        transportService.registerRequestHandler(
            localNode,
     *
        }
                if (listener == null) {  
                return;
        public void messageReceived(RecoveryFinalizeRecoveryRequest request, TransportChannel channel, Task task) throws Exception {
import org.opensearch.core.transport.TransportResponse;  
 */
                return;
                    listener
    /**
                logger.trace("not running recovery with id [{}] - can not find it (probably finished)", recoveryId);
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.PREPARE_TRANSLOG, request);
                        recoveryTarget,
                    request,
        }
                );  
                            new OpenSearchTimeoutException("timed out waiting for mapping updates " + "(timeout [" + timeout + "])")  
    @Override
        }
import org.opensearch.cluster.metadata.IndexMetadata;
                    public void onNewClusterState(ClusterState state) {
     * The internal actions  
    /**
    public static StartRecoveryRequest getStartRecoveryRequest(
    }  
                    request.shardId(),
        transportService.registerRequestHandler(
        }
                );
    class HandoffPrimaryContextRequestHandler implements TransportRequestHandler<RecoveryHandoffPrimaryContextRequest> {  
                    logger.error(() -> new ParameterizedMessage("unexpected error during recovery [{}], failing shard", recoveryId), e);
                    requestToSend = startRequest;  
                startRequest = preExistingRequest;
        public void messageReceived(RecoveryPrepareForTranslogOperationsRequest request, TransportChannel channel, Task task) {
    }
                        request.shardId().id()
        @Override  
            }
 * GitHub history for details.
                recoveryTarget.finalizeRecovery(request.globalCheckpoint(), request.trimAboveSeqNo(), listener);
 * under the License.  
                    .append("]")  
                }
            }
                        startingSeqNo
            }
                        + "dfaFiles={} dfaList=[{}] luceneSample=[{}]",
import org.opensearch.common.unit.TimeValue;
            threadPool.scheduleUnlessShuttingDown(retryAfter, ThreadPool.Names.GENERIC, new RecoveryRunner(newTarget.getId()));
                StringBuilder sb = new StringBuilder();
            }
import org.apache.logging.log4j.Logger;
            ThreadPool.Names.GENERIC,
    protected void retryRecovery(final long recoveryId, final Throwable reason, TimeValue retryAfter, TimeValue activityTimeout) {
                    final boolean hasNoTranslog = indexShard.indexSettings().isRemoteSnapshot();  
/*  
        final long recoveryId = request.recoveryId();
                            + "to unassigned and recovering as if there are none",  
 * not several of them (since we don't allocate several shard replicas to the same node).
            }
                }
import org.opensearch.index.shard.ShardNotFoundException;
                    assert globalCheckpoint + 1 >= startingSeqNo : "invalid startingSeqNo " + startingSeqNo + " >= " + globalCheckpoint;  
        @Override
                    request.sourceMetaSnapshot(),
    }
            metadataSnapshot,
                    "recovery of {} from [{}] interrupted by network disconnect, will retry in [{}]; cause: [{}]",  
                    } else {
    }  
import org.opensearch.core.index.shard.ShardId;
 *  
                }
            }  
        public static final String HANDOFF_PRIMARY_CONTEXT = "internal:index/shard/recovery/handoff_primary_context";
 * specific language governing permissions and limitations
            channel.sendResponse(TransportResponse.Empty.INSTANCE);
                    logger.debug(  
                    }
 * Unless required by applicable law or agreed to in writing,
                    if (hasRemoteSegmentStore || indexShard.isRemoteSeeded()) {
                    .append("]\n");
 * the Apache License, Version 2.0 (the "License"); you may
        }
                || cause instanceof IndexNotFoundException  
                            try (
            Actions.PREPARE_TRANSLOG,  
 * Note, it can be safely assumed that there will only be a single recovery per shard (index+id) and
                    final long globalCheckpoint = Translog.readGlobalCheckpoint(recoveryTarget.translogLocation(), expectedTranslogUUID);
                    .keySet()
 */  
                    );
        private final long recoveryId;
                    channel,  
            // happens on an empty folder. no need to log  
                    if (mappingVersionOnTarget < request.mappingVersionOnPrimary() && e instanceof MapperException) {
}
        threadPool.generic().execute(new RecoveryRunner(recoveryId));
                    request.totalTranslogOps(),
        transportService.registerRequestHandler(
        public static final String FILES_INFO = "internal:index/shard/recovery/filesInfo";
        try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.get(recoveryId)) {
        transportService.registerRequestHandler(
                        threadPool.generic().execute(ActionRunnable.wrap(listener, l -> {  
                if (listener == null) {  
            Actions.FILES_INFO,  
        @Override
     * @param recoveryId recovery id  
        @Override  
        public RecoveryResponse read(StreamInput in) throws IOException {
            if (cause instanceof IllegalIndexShardStateException
            }  
            new HandoffPrimaryContextRequestHandler()  
                java.util.List<String> dfaFiles = metadataSnapshot.asMap()
            new PrepareForTranslogOperationsRequestHandler()  
        return getStartRecoveryRequest(logger, localNode, recoveryTarget, startingSeqNo, true);
        public void messageReceived(final RecoveryTranslogOperationsRequest request, final TransportChannel channel, Task task)
        return request;
            new RecoveryResponseHandler(startRequest, timer)
                        // ToDo: This is a temporary mitigation to not fail the peer recovery flow in case there is  
     * @param recoveryTarget   the target of the recovery
                    .filter(name -> name.contains("/"))
            if (cause instanceof DelayRecoveryException || cause instanceof PeerRecoveryNotFound) {
            final long mappingVersionOnTarget = indexMetadata != null ? indexMetadata.getMappingVersion() : 0L;  
            this.startRecoveryRequest = startRecoveryRequest;
                    final long startingSeqNo = indexShard.recoverLocallyAndFetchStartSeqNo(!hasRemoteTranslog);
                } catch (IOException | TranslogCorruptedException e) {
            }
        public void onFailure(Exception e) {
import org.opensearch.threadpool.ThreadPool;  
    }
                        // GitHub Issue to track the revamp: https://github.com/opensearch-project/OpenSearch/issues/11331  
import org.apache.logging.log4j.LogManager;
            // do it twice, in case we have double transport exception
 * Modifications Copyright OpenSearch Contributors. See
            recoveryTarget.sourceNode(),  
        @Override  
        private RecoveryResponseHandler(final StartRecoveryRequest request, final ReplicationTimer timer) {
                    dfaFiles.size(),
                    recoverySettings.retryDelayStateSync(),  
                            ) {  
        RecoveryTarget recoveryTarget,
            Actions.CLEAN_FILES,  
 *  
                    request.getGlobalCheckpoint(),  
            if (recoveryRef == null) {  
            }  
                );
                    .keySet()
        private void onException(Exception e) {
                    return;  
    }  
                    recoverySettings.retryDelayNetwork(),  
                return;
 *
        );
                    new ParameterizedMessage(
    public PeerRecoveryTargetService(
                })
 *
        }  
            onGoingRecoveries.markAsDone(recoveryId);  
        transportService.registerRequestHandler(
            recoveryTarget.state().getPrimary(),  
                                + "resetting the starting sequence number from {} to unassigned and recovering as if there are none",
import org.opensearch.index.IndexNotFoundException;
            new RecoveryTarget(indexShard, sourceNode, listener, threadPool),
    protected void reestablishRecovery(final StartRecoveryRequest request, final String reason, TimeValue retryAfter) {  
    class PrepareForTranslogOperationsRequestHandler implements TransportRequestHandler<RecoveryPrepareForTranslogOperationsRequest> {
 * this file be licensed under the Apache-2.0 license or a
                logger.debug("delaying recovery due to missing mapping changes", exception);  
                        "error while listing local files, resetting the starting sequence number from {} "
import org.opensearch.common.Nullable;
/*
                        recoveryId,  
import org.opensearch.cluster.node.DiscoveryNode;  
     *                         This is the first operation after the local checkpoint of the safe commit if exists.  
     * @param logger           the logger
                if (recoveryRef != null) {
                requestToSend = new ReestablishRecoveryRequest(recoveryId, startRequest.shardId(), startRequest.targetAllocationId());  
            requestToSend,  
        );
                    cause.getMessage()
                    actionName = PeerRecoverySourceService.Actions.START_RECOVERY;
        @Override
                recoveryTarget.handleFileChunk(  
 * KIND, either express or implied.  See the License for the
        @Override  
            metadataSnapshot = Store.MetadataSnapshot.EMPTY;  
                );
 * The recovery target handles recoveries of peer shards of the shard+node to recover to.
            if (logger.isTraceEnabled()) {  
        );
                    .append(new ByteSizeValue(recoveryResponse.phase1ExistingTotalSize))
            this.request = request;
                    .append("\n");
                        // an exception while downloading segments from remote store. For remote backed indexes, we
    private static final Logger logger = LogManager.getLogger(PeerRecoveryTargetService.class);  
                        true // be safe  
            // we do some heavy work like refreshes in the response so fork off to the generic threadpool
                    .append(']')
     * Prepare the start recovery request.  
                    () -> new ParameterizedMessage(
        public void doRun() {  
                // unwrap an exception that was thrown as part of the recovery
import org.opensearch.transport.TransportService;
    }  
import org.opensearch.cluster.service.ClusterService;
            startingSeqNo
                }  
import org.opensearch.index.shard.IndexShard;  
            RecoveryCleanFilesRequest::new,
        }
                    request,
        ClusterService clusterService  
                final RecoveryTarget recoveryTarget = recoveryRef.get();
     */  
                    return;
                }
            recoveryTarget.shardId(),
import org.opensearch.core.action.ActionListener;
                return;  
    }
            assert startingSeqNo == UNASSIGNED_SEQ_NO : startingSeqNo;
                    .collect(java.util.stream.Collectors.toList());  
                    final IndexShard indexShard = recoveryTarget.indexShard();
                    request.sourceNode(),
                ActionListener.wrap(checkpoint -> listener.onResponse(null), e -> {
                            startingSeqNo  
        );
                    .filter(name -> name.contains("/") == false)
                        retryOnMappingException.accept(e);  
            ThreadPool.Names.GENERIC,
import org.opensearch.transport.ConnectTransportException;
        transportService.registerRequestHandler(
                        true
            timer = recoveryTarget.state().getTimer();
                    onGoingRecoveries.fail(
        }  
                    .append('[')  
        retryRecovery(recoveryId, retryAfter, activityTimeout);  
                    .sorted()
                    return;
                        listener.onFailure(
 * software distributed under the License is distributed on an
    ) {
import org.opensearch.core.common.unit.ByteSizeValue;
        public void messageReceived(RecoveryCleanFilesRequest request, TransportChannel channel, Task task) throws Exception {
     * @param preExistingRequest start recovery request
    private void retryRecovery(final long recoveryId, final TimeValue retryAfter, final TimeValue activityTimeout) {
            metadataSnapshot = recoveryTarget.indexShard().snapshotStoreMetadata();
            new FilesInfoRequestHandler()  
        this.recoverySettings = recoverySettings;
    }  
                observer.waitForNextChange(new ClusterStateObserver.Listener() {  
                request.mappingVersionOnPrimary(),
    protected void retryRecovery(final long recoveryId, final String reason, TimeValue retryAfter, TimeValue activityTimeout) {  
            actionName,
                // Make sure that the current translog is consistent with the Lucene index; otherwise, we have to throw away the Lucene
                    .append(timeValueMillis(recoveryResponse.phase2Time))  
        logger.trace("will try to reestablish recovery with id [{}] in [{}] (reason [{}])", recoveryId, retryAfter, reason);
                    .append("]")  
public class PeerRecoveryTargetService implements IndexEventListener {
            Actions.FINALIZE,  
                final RecoveryTarget recoveryTarget = recoveryRef.get();
        public static final String PREPARE_TRANSLOG = "internal:index/shard/recovery/prepare_translog";  
                    @Override
import org.opensearch.tasks.Task;
import org.opensearch.index.engine.RecoveryEngineException;
                    total,  
                sb.append("recovery completed from ").append(request.sourceNode()).append(", took[").append(recoveryTime).append("]\n");  
            ThreadPool.Names.GENERIC,
    private final ClusterService clusterService;
                onGoingRecoveries.fail(recoveryId, new RecoveryFailedException(request, "source shard is closed", cause), false);
        final long recoveryId;
                    .append("]")  
        // create a new recovery status, and process...  
        } catch (final IOException e) {
                        listener.onFailure(new OpenSearchException("cluster service was closed while waiting for mapping updates"));
        if (indexShard != null) {  
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
                        logger,  
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        @Override  
        }
        final StartRecoveryRequest request;
import org.opensearch.indices.replication.common.ReplicationTimer;
            RecoveryFilesInfoRequest::new,
        retryRecovery(recoveryId, retryAfter, activityTimeout);
                    .append(" transaction log operations")
                    nullVal -> new RecoveryTranslogOperationsResponse(recoveryTarget.indexShard().getLocalCheckpoint())  
 */
                logger.debug("{} reestablishing recovery from {}", startRequest.shardId(), startRequest.sourceNode());
import org.opensearch.common.annotation.PublicApi;  
                    assert recoveryTarget.sourceNode() != null : "can not do a recovery without a source node";
            }
                    .append("] with total_size of [")  
                        "[{}][{}] Got exception on recovery",  
        }
        // How many bytes we've copied since we last called RateLimiter.pause
                    "remote shard not ready",
                        verifyTranslog
import org.opensearch.index.store.Store;
        final String actionName;
        // assertions to trip if we executed it on the same thread hence we fork off to the generic threadpool.  
                    final boolean verifyTranslog = (hasRemoteTranslog || hasNoTranslog || hasRemoteSegmentStore) == false;
                recoveryTarget.cleanFiles(
 * not use this file except in compliance with the License.
import org.opensearch.transport.TransportChannel;
        logger.trace(() -> new ParameterizedMessage("will retry recovery with id [{}] in [{}]", recoveryId, retryAfter), reason);
            }  
        }  
            new FileChunkTransportRequestHandler()  
                    final String expectedTranslogUUID = metadataSnapshot.getCommitUserData().get(Translog.TRANSLOG_UUID_KEY);
                sb.append("         : reusing_files   [")
            final IndexMetadata indexMetadata = clusterService.state().metadata().index(request.shardId().getIndex());
                || cause instanceof ShardNotFoundException) {
import java.util.concurrent.atomic.AtomicLong;
package org.opensearch.indices.recovery;
        }  
        final StartRecoveryRequest startRequest;  
    class FileChunkTransportRequestHandler implements TransportRequestHandler<FileChunkRequest> {
                    .sorted()
                        new RecoveryFailedException(recoveryRef.get().state(), "unexpected error", e),
                    );
            throws IOException {
                    .append("]")
            if (cause instanceof ConnectTransportException) {
    }  
                            );
        @Override
                        recoveryId,
            if (cause instanceof RecoveryEngineException) {
import org.opensearch.index.mapper.MapperException;  
            if (startingSeqNo != UNASSIGNED_SEQ_NO) {
 * You may obtain a copy of the License at  
                    recoveryId,
                final RecoveryTarget recoveryTarget = recoveryRef.get();  
        public void handleException(TransportException e) {
            ThreadPool.Names.GENERIC,
        @Override
            FileChunkRequest::new,
        }
                                performTranslogOps(request, listener, recoveryRef);
     * @param verifyTranslog should the recovery request validate translog consistency with snapshot store metadata.
                sb.append('[')  
        transportService.registerRequestHandler(
                    ),  
        if (newTarget != null) {
            }
import org.opensearch.common.settings.Settings;
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.FILES_INFO, request);  
import org.apache.lucene.store.AlreadyClosedException;
                        }));  
                    indexShard.prepareForIndexRecovery();  
                    request.phase1FileNames,  
        long startingSeqNo,
    public void startRecovery(final IndexShard indexShard, final DiscoveryNode sourceNode, final RecoveryListener listener) {
        this.clusterService = clusterService;
            }
            final TimeValue recoveryTime = new TimeValue(timer.time());
                // this can also come from the source wrapped in a RemoteTransportException  
            }
        final ReplicationTimer timer;
        @Override
            doRecovery(recoveryId, startRecoveryRequest);
                String luceneSample = metadataSnapshot.asMap()
        public static final String CLEAN_FILES = "internal:index/shard/recovery/clean_files";
            final RecoveryTarget recoveryTarget = recoveryRef.get();  
                // index.
        request = new StartRecoveryRequest(  
                // if the target is not ready yet, retry
            ThreadPool.Names.GENERIC,
                        clusterService.localNode(),
 * this work for additional information regarding copyright
                    return;  
                    .append(request.shardId().id())
                    }  
                    listener
                    .append(timeValueMillis(recoveryResponse.phase1Time))
                    startRequest = getStartRecoveryRequest(
            onGoingRecoveries.fail(recoveryId, new RecoveryFailedException(request, e), true);  
                        new RecoveryFailedException(recoveryTarget.state(), "failed to prepare shard for recovery", e),
            if (logger.isInfoEnabled()) {
        // we fork off quickly here and go async but this is called from the cluster state applier thread too and that can cause
import org.opensearch.index.shard.IllegalIndexShardStateException;
                if (listener == null) {
                        request.shardId().getIndex().getName(),
                        // note that we do not use a timeout (see comment above)
                    final boolean hasRemoteTranslog = recoveryTarget.state().getPrimary() == false
/*  
            RecoveryFinalizeRecoveryRequest::new,
                    onGoingRecoveries.fail(  
            onException(e);
            }
                );
                }
                        } catch (Exception e) {  
                request.retentionLeases(),  
                logger.warn("error while listing local files, recovering as if there are none", e);
                    .append(new ByteSizeValue(recoveryResponse.phase1TotalSize))
                        listener.onFailure(e);
import org.opensearch.transport.TransportRequest;
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
import org.opensearch.action.ActionRunnable;
                    Actions.TRANSLOG_OPS,
                logger.warn(  
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
    public static class Actions {
                    return;
                    .append("], throttling_wait [")  
                                    request.recoveryId(),  
        boolean verifyTranslog  
 * ownership. Elasticsearch licenses this file to you under  
                            indexShard.syncSegmentsFromRemoteSegmentStore(false, recoveryTarget::setLastAccessTime);
        public String executor() {
                if (listener == null) {
            logger.trace("{} shard folder empty, recovering all files", recoveryTarget);
                sb.append("         : recovered [")
                    listener
                final RecoveryTarget recoveryTarget = recoveryRef.get();
                    .append(request.shardId().getIndex().getName())
import org.opensearch.indices.replication.common.ReplicationCollection.ReplicationRef;  
                );
import org.opensearch.common.util.concurrent.AbstractRunnable;
                        ),
import org.opensearch.common.util.CancellableThreads;  
        );  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        RecoveryRunner(long recoveryId) {
                onGoingRecoveries.fail(recoveryId, new RecoveryFailedException(request, "source has canceled the recovery", cause), false);
    }
        private void performTranslogOps(
                        try {
    class CleanFilesRequestHandler implements TransportRequestHandler<RecoveryCleanFilesRequest> {
            final ReplicationRef<RecoveryTarget> recoveryRef
                    .append(recoveryResponse.phase1ExistingFileNames.size())
                    }  
        Store.MetadataSnapshot metadataSnapshot;
                        new ParameterizedMessage(  
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {  
 * Licensed to Elasticsearch under one or more contributor  
                        // plan to revamp this flow so that node-node segment copy will not happen.
            RecoveryTranslogOperationsRequest::new,
    }
                    // this will be logged as warning later on...  
                    .stream()  
                    }
            if (logger.isTraceEnabled()) {
                );  
        logger.trace("{} collecting local files for [{}]", recoveryTarget.shardId(), recoveryTarget.sourceNode());  
import java.io.IOException;  
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.FINALIZE, request);
                    );  
                    public void onClusterServiceClose() {
                logger.trace(
        DiscoveryNode localNode,
                        e
 * @opensearch.api
                // canceled)
 *    http://www.apache.org/licenses/LICENSE-2.0
            final ClusterStateObserver observer = new ClusterStateObserver(clusterService, null, logger, threadPool.getThreadContext());
 * license agreements. See the NOTICE file distributed with
            this.recoveryId = request.recoveryId();  
                cause = cause.getCause();  
                    startingSeqNo = UNASSIGNED_SEQ_NO;
    class FilesInfoRequestHandler implements TransportRequestHandler<RecoveryFilesInfoRequest> {  
            if (cause instanceof AlreadyClosedException) {
            }
            new FinalizeRecoveryRequestHandler()  
                    @Override  
                        && indexShard.indexSettings().isAssignedOnRemoteNode();
                logger.debug(
                    }  
        public static final String FINALIZE = "internal:index/shard/recovery/finalize";
        Logger logger,  
import org.opensearch.transport.TransportRequestHandler;
    private final TransportService transportService;
                    .append("\n");  
        public static final String TRANSLOG_OPS = "internal:index/shard/recovery/translog_ops";
        );
        }  
        public void handleResponse(RecoveryResponse recoveryResponse) {  
                        () -> new ParameterizedMessage("unexpected error during recovery, but recovery id [{}] is finished", recoveryId),
                        : "unexpected recovery stage [" + recoveryTarget.state().getStage() + "] starting seqno [ " + startingSeqNo + "]";
            }
        Logger logger,
                    String.join(", ", dfaFiles),
                retryRecovery(recoveryId, cause, recoverySettings.retryDelayStateSync(), recoverySettings.activityTimeout());  
                    );  
        @Override
     * Initiates recovery of the replica. TODO - Need to revisit it with PRRL and later. @see
                } catch (final Exception e) {
                    metadataSnapshot = Store.MetadataSnapshot.EMPTY;
            ThreadPool.Names.GENERIC,
        long startingSeqNo  
            return ThreadPool.Names.GENERIC;  
        } catch (final org.apache.lucene.index.IndexNotFoundException e) {
        TransportService transportService,
    public static StartRecoveryRequest getStartRecoveryRequest(
                request.totalTranslogOps(),  
        this.onGoingRecoveries = new ReplicationCollection<>(logger, threadPool);  
        private final ReplicationTimer timer;  
                }
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
        );
                    .append("] ");
                    assert startingSeqNo == UNASSIGNED_SEQ_NO || recoveryTarget.state().getStage() == RecoveryState.Stage.TRANSLOG  
                    recoveryTarget.shardId(),
                    "[DFA-RECOVERY] peer recovery TARGET sending metadata to source shardId={} totalFiles={} "  
                    request.phase1ExistingFileSizes,  
import org.opensearch.transport.TransportResponseHandler;  
            Actions.FILE_CHUNK,  
        }  
            }
            recoveryTarget.getId(),
                try {  
                performTranslogOps(request, listener, recoveryRef);  
 * SPDX-License-Identifier: Apache-2.0
                    .collect(java.util.stream.Collectors.joining(", "));
        ThreadPool threadPool,  
                request.maxSeenAutoIdTimestampOnPrimary(),
 * The OpenSearch Contributors require contributions made to  
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {  
        RecoveryTarget recoveryTarget,
                        e
                } else {
                    recoverySettings.activityTimeout()
                                )
                                e  
                    logger.trace("{} preparing shard for peer recovery", recoveryTarget.shardId());
            metadataSnapshot = Store.MetadataSnapshot.EMPTY;  
        public void messageReceived(RecoveryFilesInfoRequest request, TransportChannel channel, Task task) throws Exception {  
                    .append(recoveryResponse.phase2Operations)
        this.transportService = transportService;  
            recoveryTarget.indexTranslogOperations(
            cause = ExceptionsHelper.unwrapCause(cause);  
    }  
            if (cause instanceof CancellableThreads.ExecutionCancelledException) {
    private final ThreadPool threadPool;
        public static final String FILE_CHUNK = "internal:index/shard/recovery/file_chunk";  
    ) {
                                    request.shardId()
                logger.info(
            RecoveryHandoffPrimaryContextRequest::new,
                    return;
                    ),
                return;
     */  
                return;  
     * @param localNode        the local node of the recovery target  
                    .stream()  
            } else {
                cause = cause.getCause();  
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {  
                    @Override
                recoveryTarget.prepareForTranslogOperations(request.totalTranslogOps(), listener);  
        private final StartRecoveryRequest startRecoveryRequest;
        try {  
     * @return a start recovery request
                retryRecovery(  
            // here, we would add checks against exception that need to be retried (and not removeAndClean in this case)  
import org.opensearch.ExceptionsHelper;
    }  
            }
            );
import org.opensearch.cluster.ClusterStateObserver;
        @Override
                // in very rare cases a translog replay from primary is processed before a mapping update on this node
                int total = metadataSnapshot.size();  
        logger.trace("will retry recovery with id [{}] in [{}] (reason [{}])", recoveryId, retryAfter, reason);
            if (cause instanceof RecoveryEngineException) {
                startingSeqNo = UNASSIGNED_SEQ_NO;
                    final boolean hasRemoteSegmentStore = indexShard.indexSettings().isRemoteStoreEnabled();
    class RecoveryRunner extends AbstractRunnable {
                    .append(timeValueMillis(recoveryResponse.phase1ThrottlingWaitTime))
                logger.debug("{} recovery done from [{}], took [{}]", request.shardId(), request.sourceNode(), recoveryTime);
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.indices.replication.common.ReplicationCollection;
                    .append(recoveryResponse.phase1FileNames.size())
        );
import org.opensearch.OpenSearchException;  
                try {
                sb.append("   phase2: start took [").append(timeValueMillis(recoveryResponse.startTime)).append("]\n");  
        );
            } else {  
        }  
    class FinalizeRecoveryRequestHandler implements TransportRequestHandler<RecoveryFinalizeRecoveryRequest> {
            if (preExistingRequest == null) {  
                    );  
import org.opensearch.index.translog.TranslogCorruptedException;
                    recoveryTarget,
            }
                    .append(']')
            onGoingRecoveries.cancelForShard(shardId, "shard closed");
        ) {
                        }
                                ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(
                    e  
     */
        }
                reestablishRecovery(request, cause.getMessage(), recoverySettings.retryDelayNetwork());  
import org.opensearch.index.translog.Translog;  
            new TranslogOperationsRequestHandler()  
        RecoveryTarget newTarget = onGoingRecoveries.reset(recoveryId, activityTimeout);  
/**
     * @param startingSeqNo    a sequence number that an operation-based peer recovery can start with.
                    logger.debug("unexpected error while preparing shard for peer recovery, failing recovery", e);
                sb.append("   phase1: recovered_files [")
                    public void onTimeout(TimeValue timeout) {  
                        startingSeqNo,  
        private final StartRecoveryRequest request;
                );
                if (listener == null) {
                    // do not retry if the mapping on replica is at least as recent as the mapping  
                    request.totalTranslogOps,
            ThreadPool.Names.GENERIC,
            final RecoveryTranslogOperationsRequest request,
                            "error while reading global checkpoint from translog, "
                );  
                final RecoveryTarget recoveryTarget = recoveryRef.get();
import java.util.function.Consumer;
            this(recoveryId, null);
    }
        }  
        this.threadPool = threadPool;
                recoveryTarget.receiveFileInfo(
    /**  
        );
            Actions.HANDOFF_PRIMARY_CONTEXT,  
                final RecoveryTarget recoveryTarget = recoveryRef.get();
    private final ReplicationCollection<RecoveryTarget> onGoingRecoveries;  
                    .append(", took [")
            } else {
    ) {
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.CLEAN_FILES, request);
                    request.phase1FileSizes,
                    bytesSinceLastPause,  
