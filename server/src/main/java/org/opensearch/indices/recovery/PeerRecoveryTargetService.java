            final RecoveryTarget recoveryTarget = recoveryRef.get();
                    .append(" with total_size of [")
        }
 * @opensearch.api
        this.recoverySettings = recoverySettings;
            final ClusterStateObserver observer = new ClusterStateObserver(clusterService, null, logger, threadPool.getThreadContext());
                        ),
            final long mappingVersionOnTarget = indexMetadata != null ? indexMetadata.getMappingVersion() : 0L;
            this.recoveryId = recoveryId;
        DiscoveryNode localNode,
        RecoveryTarget recoveryTarget,
                return;
 * KIND, either express or implied.  See the License for the
    }
                    request,
                request.operations(),
     * @opensearch.internal
                logger.debug("{} starting recovery from {}", startRequest.shardId(), startRequest.sourceNode());
        if (indexShard != null) {
        // How many bytes we've copied since we last called RateLimiter.pause
        private void performTranslogOps(
                    .stream()
import org.opensearch.common.unit.TimeValue;
     *
                // this can also come from the source wrapped in a RemoteTransportException
                    .append("], throttling_wait [")
                if (listener == null) {
        public static final String CLEAN_FILES = "internal:index/shard/recovery/clean_files";
import org.apache.logging.log4j.Logger;
                reestablishRecovery(request, cause.getMessage(), recoverySettings.retryDelayNetwork());
                    }
            new FileChunkTransportRequestHandler()
                    .append("]")
                                "Exception while downloading segment files from remote store, will continue with peer to peer segment copy",
            if (logger.isTraceEnabled()) {
                    .append(" transaction log operations")
        }
                logger.trace("{}", sb);
    class FileChunkTransportRequestHandler implements TransportRequestHandler<FileChunkRequest> {
        public String executor() {
                    indexShard.preRecovery();
                    return;
                    .append(request.shardId().getIndex().getName())
        final long recoveryId = onGoingRecoveries.start(
     * Initiates recovery of the replica. TODO - Need to revisit it with PRRL and later. @see
            ThreadPool.Names.GENERIC,
            channel.sendResponse(TransportResponse.Empty.INSTANCE);
                );
                    .append("]")
        }
    }
            } else {
                    bytesSinceLastPause,
            ThreadPool.Names.GENERIC,
                );
 *
                performTranslogOps(request, listener, recoveryRef);
                        new RecoveryFailedException(recoveryTarget.state(), "failed to prepare shard for recovery", e),
                return;
                    .keySet()
            cause = ExceptionsHelper.unwrapCause(cause);
        @Override
     * @param logger           the logger
        this.onGoingRecoveries = new ReplicationCollection<>(logger, threadPool);
                    logger.trace("{} preparing shard for peer recovery", recoveryTarget.shardId());
                    .keySet()
    protected void retryRecovery(final long recoveryId, final String reason, TimeValue retryAfter, TimeValue activityTimeout) {
 * this file be licensed under the Apache-2.0 license or a
                    );
import java.util.concurrent.atomic.AtomicLong;
            localNode,
                                )
     *                         This is the first operation after the local checkpoint of the safe commit if exists.
        return getStartRecoveryRequest(logger, localNode, recoveryTarget, startingSeqNo, true);
        @Override
            logger.trace("{} shard folder empty, recovering all files", recoveryTarget);
                                    request.shardId()
    public static StartRecoveryRequest getStartRecoveryRequest(
                // canceled)
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
    ) {
                        true
                    request,
            if (startingSeqNo != UNASSIGNED_SEQ_NO) {
            }
import org.opensearch.index.shard.IndexEventListener;
import org.opensearch.index.shard.IllegalIndexShardStateException;
    }
import org.opensearch.index.IndexNotFoundException;
            RecoveryCleanFilesRequest::new,
            if (cause instanceof CancellableThreads.ExecutionCancelledException) {
                    final String expectedTranslogUUID = metadataSnapshot.getCommitUserData().get(Translog.TRANSLOG_UUID_KEY);
                    .append(recoveryResponse.phase2Operations)
                    cause.getMessage()
 * The OpenSearch Contributors require contributions made to
            recoveryTarget.getId(),
    ) {
        public void handleException(TransportException e) {
    private void retryRecovery(final long recoveryId, final TimeValue retryAfter, final TimeValue activityTimeout) {
        request = new StartRecoveryRequest(
            metadataSnapshot = Store.MetadataSnapshot.EMPTY;
 * You may obtain a copy of the License at
                    total,
                    request.getGlobalCheckpoint(),
            timer = recoveryTarget.state().getTimer();
                logger.warn("error while listing local files, recovering as if there are none", e);
                        listener.onFailure(e);
        }
        ThreadPool threadPool,
        }
                    .append(timeValueMillis(recoveryResponse.phase2Time))
import org.opensearch.transport.TransportException;
        @Override
                                + "resetting the starting sequence number from {} to unassigned and recovering as if there are none",
        try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.get(recoveryId)) {
                        new ParameterizedMessage(
                        request.shardId().getIndex().getName(),
    @Override
        public static final String FILE_CHUNK = "internal:index/shard/recovery/file_chunk";
                final RecoveryTarget recoveryTarget = recoveryRef.get();
            metadataSnapshot = recoveryTarget.indexShard().snapshotStoreMetadata();
                    logger.debug(
                sb.append("   phase1: recovered_files [")
        public static final String HANDOFF_PRIMARY_CONTEXT = "internal:index/shard/recovery/handoff_primary_context";
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.FILE_CHUNK, request);
                        logger,
                    nullVal -> new RecoveryTranslogOperationsResponse(recoveryTarget.indexShard().getLocalCheckpoint())
                }
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(
        private final long recoveryId;
            final IndexMetadata indexMetadata = clusterService.state().metadata().index(request.shardId().getIndex());
 * under the License.
            return ThreadPool.Names.GENERIC;
        }
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
        transportService.registerRequestHandler(
import org.opensearch.tasks.Task;
    private static final Logger logger = LogManager.getLogger(PeerRecoveryTargetService.class);
            final RecoveryTranslogOperationsRequest request,
    class RecoveryRunner extends AbstractRunnable {
            this.request = request;
        transportService.registerRequestHandler(
                    .append(new ByteSizeValue(recoveryResponse.phase1ExistingTotalSize))
    }
                if (listener == null) {
            // do it twice, in case we have double transport exception
    class FinalizeRecoveryRequestHandler implements TransportRequestHandler<RecoveryFinalizeRecoveryRequest> {
            Actions.HANDOFF_PRIMARY_CONTEXT,
            if (cause instanceof ConnectTransportException) {
                    new ParameterizedMessage(
                    final boolean hasRemoteTranslog = recoveryTarget.state().getPrimary() == false
                logger.debug("{} recovery done from [{}], took [{}]", request.shardId(), request.sourceNode(), recoveryTime);
        public static final String PREPARE_TRANSLOG = "internal:index/shard/recovery/prepare_translog";
                        recoveryId,
                    assert startingSeqNo == UNASSIGNED_SEQ_NO || recoveryTarget.state().getStage() == RecoveryState.Stage.TRANSLOG
                }
                        // GitHub Issue to track the revamp: https://github.com/opensearch-project/OpenSearch/issues/11331
                    .filter(name -> name.contains("/") == false)
        }
            if (verifyTranslog) {
                ActionListener.wrap(checkpoint -> listener.onResponse(null), e -> {
    public void beforeIndexShardClosed(ShardId shardId, @Nullable IndexShard indexShard, Settings indexSettings) {
            }
            final Consumer<Exception> retryOnMappingException = exception -> {
     */
            Actions.FILES_INFO,
    private final ThreadPool threadPool;
                observer.waitForNextChange(new ClusterStateObserver.Listener() {
 * license agreements. See the NOTICE file distributed with
        }
    class HandoffPrimaryContextRequestHandler implements TransportRequestHandler<RecoveryHandoffPrimaryContextRequest> {
                }
                    recoverySettings.activityTimeout()
        @Override
                request.mappingVersionOnPrimary(),
 * Modifications Copyright OpenSearch Contributors. See
        public void onFailure(Exception e) {
        this.threadPool = threadPool;
                    actionName = PeerRecoverySourceService.Actions.START_RECOVERY;
                || cause instanceof IndexNotFoundException
    private final ReplicationCollection<RecoveryTarget> onGoingRecoveries;
        retryRecovery(recoveryId, retryAfter, activityTimeout);
}
        public void handleResponse(RecoveryResponse recoveryResponse) {
        public void messageReceived(final RecoveryHandoffPrimaryContextRequest request, final TransportChannel channel, Task task)
        // create a new recovery status, and process...
        }
        transportService.registerRequestHandler(
                sb.append("recovery completed from ").append(request.sourceNode()).append(", took[").append(recoveryTime).append("]\n");
    /**
import org.opensearch.core.common.io.stream.StreamInput;
        long startingSeqNo,
import java.io.IOException;
        public void messageReceived(RecoveryCleanFilesRequest request, TransportChannel channel, Task task) throws Exception {
                        () -> new ParameterizedMessage("unexpected error during recovery, but recovery id [{}] is finished", recoveryId),
                        threadPool.generic().execute(ActionRunnable.wrap(listener, l -> {
                    channel,
                recoveryTarget.receiveFileInfo(
                return;
                    startingSeqNo = UNASSIGNED_SEQ_NO;
        public void messageReceived(final RecoveryTranslogOperationsRequest request, final TransportChannel channel, Task task)
            onGoingRecoveries.cancelForShard(shardId, "shard closed");
            RecoveryTranslogOperationsRequest::new,
import org.opensearch.common.util.CancellableThreads;
        RecoveryTarget recoveryTarget,
                retryRecovery(recoveryId, cause, recoverySettings.retryDelayStateSync(), recoverySettings.activityTimeout());
            RecoveryFilesInfoRequest::new,
                int total = metadataSnapshot.size();
                final RecoveryTarget recoveryTarget = recoveryRef.get();
            final ActionListener<Void> listener,
        @Override
            recoveryTarget.indexTranslogOperations(
                );
import org.opensearch.cluster.service.ClusterService;
                    if (hasRemoteSegmentStore || indexShard.isRemoteSeeded()) {
            }
        private RecoveryResponseHandler(final StartRecoveryRequest request, final ReplicationTimer timer) {
     * @param preExistingRequest start recovery request
            }
            doRecovery(recoveryId, startRecoveryRequest);
                        new RecoveryFailedException(recoveryRef.get().state(), "unexpected error", e),
        // assertions to trip if we executed it on the same thread hence we fork off to the generic threadpool.
import org.opensearch.common.settings.Settings;
                    final long globalCheckpoint = Translog.readGlobalCheckpoint(recoveryTarget.translogLocation(), expectedTranslogUUID);
 *
                sb.append('[')
            return new RecoveryResponse(in);
        final TransportRequest requestToSend;
                            startingSeqNo
                            }
    }
                }
/*
                actionName = PeerRecoverySourceService.Actions.REESTABLISH_RECOVERY;
        transportService.registerRequestHandler(
        TransportService transportService,
        logger.trace(() -> new ParameterizedMessage("will retry recovery with id [{}] in [{}]", recoveryId, retryAfter), reason);
                    .append(']')
            }
                    listener
                    request.phase1ExistingFileNames,
                    ),
                logger.debug(
import org.opensearch.common.annotation.PublicApi;
                    .append("] with total_size of [")
            if (cause instanceof IllegalIndexShardStateException
        @Override
                );
                        listener.onFailure(new OpenSearchException("cluster service was closed while waiting for mapping updates"));
            this.startRecoveryRequest = startRecoveryRequest;
 */
                return;
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
        threadPool.scheduleUnlessShuttingDown(retryAfter, ThreadPool.Names.GENERIC, new RecoveryRunner(recoveryId, request));
                                performTranslogOps(request, listener, recoveryRef);
            ThreadPool.Names.GENERIC,
        boolean verifyTranslog
        );
                        "[{}][{}] Got exception on recovery",
                                ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(
                    metadataSnapshot = Store.MetadataSnapshot.EMPTY;
        public void messageReceived(RecoveryPrepareForTranslogOperationsRequest request, TransportChannel channel, Task task) {
                        request.shardId().id()
            threadPool.scheduleUnlessShuttingDown(retryAfter, ThreadPool.Names.GENERIC, new RecoveryRunner(newTarget.getId()));
 * Note, it can be safely assumed that there will only be a single recovery per shard (index+id) and
        @Override
            }
            new HandoffPrimaryContextRequestHandler()
        }
            }
        return request;
import org.opensearch.OpenSearchTimeoutException;
        }
                    return;
                request.retentionLeases(),
            startingSeqNo
                }
     * @param startingSeqNo    a sequence number that an operation-based peer recovery can start with.
        final StartRecoveryRequest startRequest;
            onGoingRecoveries.markAsDone(recoveryId);
                recoveryRef.get().handoffPrimaryContext(request.primaryContext());
        );
                    logger.error(() -> new ParameterizedMessage("unexpected error during recovery [{}], failing shard", recoveryId), e);
                        startingSeqNo
                    }
                    listener
            this(recoveryId, null);
            recoveryTarget.indexShard().routingEntry().allocationId().getId(),
     * @return a start recovery request
 * <p>
                    recoverySettings.retryDelayStateSync(),
     * @param verifyTranslog should the recovery request validate translog consistency with snapshot store metadata.
     * @param recoveryTarget   the target of the recovery
                        // ToDo: This is a temporary mitigation to not fail the peer recovery flow in case there is
                    logger.debug("unexpected error while preparing shard for peer recovery, failing recovery", e);
            // PeerRecoveryNotFound is returned when the source node cannot find the recovery requested by
                request.maxSeqNoOfUpdatesOrDeletesOnPrimary(),
            } else {
        transportService.registerRequestHandler(
            Actions.FINALIZE,
    }
    }
                    .sorted()
import org.apache.logging.log4j.message.ParameterizedMessage;
        this.transportService = transportService;
                if (listener == null) {
                        : "unexpected recovery stage [" + recoveryTarget.state().getStage() + "] starting seqno [ " + startingSeqNo + "]";
 * not several of them (since we don't allocate several shard replicas to the same node).
                    recoveryTarget,
                    String.join(", ", dfaFiles),
import org.opensearch.common.util.concurrent.AbstractRunnable;
 * specific language governing permissions and limitations
                request.maxSeenAutoIdTimestampOnPrimary(),
    ) {
                    "remote shard not ready",
            new CleanFilesRequestHandler()
            actionName,
        final StartRecoveryRequest request;
                    request.shardId(),
        @Override
import org.opensearch.common.Nullable;
                    .append(", took [")
                    .limit(5)
        final ReplicationTimer timer;
        public void messageReceived(RecoveryFilesInfoRequest request, TransportChannel channel, Task task) throws Exception {
                        true // be safe
                    final long startingSeqNo = indexShard.recoverLocallyAndFetchStartSeqNo(!hasRemoteTranslog);
            if (logger.isTraceEnabled()) {
            Throwable cause = ExceptionsHelper.unwrapCause(e);
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.FILES_INFO, request);
        }
            if (preExistingRequest == null) {
            requestToSend,
                    }
                    .append(timeValueMillis(recoveryResponse.phase1ThrottlingWaitTime))
                    }
import org.opensearch.OpenSearchException;
                logger.trace(
import org.opensearch.cluster.node.DiscoveryNode;
                // index.
            } else {
 *
                logger.trace("not running recovery with id [{}] - can not find it (probably finished)", recoveryId);
            }
import org.opensearch.core.index.shard.ShardId;
     * The internal actions
                cause = cause.getCause();
import org.opensearch.transport.TransportChannel;
            this.recoveryId = request.recoveryId();
 * The recovery target handles recoveries of peer shards of the shard+node to recover to.
                            logger.error(
                    .append('[')
            // do this through ongoing recoveries to remove it from the collection
        Logger logger,
                        e
            Actions.CLEAN_FILES,
    private final RecoverySettings recoverySettings;
public class PeerRecoveryTargetService implements IndexEventListener {
 * SPDX-License-Identifier: Apache-2.0
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.get(recoveryId)) {
            }
                    .filter(name -> name.contains("/"))
        retryRecovery(recoveryId, retryAfter, activityTimeout);
            throws IOException {
                    }
                    return;
import org.opensearch.ExceptionsHelper;
        logger.trace("{} local file count [{}]", recoveryTarget.shardId(), metadataSnapshot.size());
                        // an exception while downloading segments from remote store. For remote backed indexes, we
                    ),
                        "error while listing local files, resetting the starting sequence number from {} "
import org.opensearch.index.translog.TranslogCorruptedException;
                    .append(recoveryResponse.phase1FileNames.size())
                            "error while reading global checkpoint from translog, "
        }
                if (listener == null) {
                    // do not retry if the mapping on replica is at least as recent as the mapping
        } catch (final org.apache.lucene.index.IndexNotFoundException e) {
                        e
                // we do not need to use a timeout here since the entire recovery mechanism has an inactivity protection (it will be
    }
                } catch (final Exception e) {
            }
                    Actions.TRANSLOG_OPS,
        );
        logger.trace("will try to reestablish recovery with id [{}] in [{}] (reason [{}])", recoveryId, retryAfter, reason);
    }
            recoveryTarget.shardId(),
 * Unless required by applicable law or agreed to in writing,
                    .append("\n");
                        }));
                );
    protected void reestablishRecovery(final StartRecoveryRequest request, final String reason, TimeValue retryAfter) {
                recoveryTarget.cleanFiles(
import org.opensearch.transport.TransportRequestHandler;
                recoveryTarget.finalizeRecovery(request.globalCheckpoint(), request.trimAboveSeqNo(), listener);
 */
                    @Override
        private final StartRecoveryRequest request;
        ) {
                // if the target is not ready yet, retry
import org.opensearch.indices.replication.common.ReplicationCollection.ReplicationRef;
                    assert recoveryTarget.sourceNode() != null : "can not do a recovery without a source node";
                    if (mappingVersionOnTarget < request.mappingVersionOnPrimary() && e instanceof MapperException) {
                    .append(request.shardId().id())
                    return;
 * Licensed to Elasticsearch under one or more contributor
            }
                logger.debug("{} reestablishing recovery from {}", startRequest.shardId(), startRequest.sourceNode());
    private void doRecovery(final long recoveryId, final StartRecoveryRequest preExistingRequest) {
import org.opensearch.index.mapper.MapperException;
                    @Override
    }
                            );
        RecoveryRunner(long recoveryId) {
import org.opensearch.indices.replication.common.ReplicationTimer;
        RecoveryTarget newTarget = onGoingRecoveries.reset(recoveryId, activityTimeout);
    public void startRecovery(final IndexShard indexShard, final DiscoveryNode sourceNode, final RecoveryListener listener) {
        RecoveryRunner(long recoveryId, StartRecoveryRequest startRecoveryRequest) {
                    dfaFiles.size(),
                    listener
    class PrepareForTranslogOperationsRequestHandler implements TransportRequestHandler<RecoveryPrepareForTranslogOperationsRequest> {
                );
 * software distributed under the License is distributed on an
import org.opensearch.transport.ConnectTransportException;
                }
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.FINALIZE, request);
            ThreadPool.Names.GENERIC,
     */
        this.clusterService = clusterService;
    }
        public void doRun() {
            ThreadPool.Names.GENERIC,
                    "recovery of {} from [{}] interrupted by network disconnect, will retry in [{}]; cause: [{}]",
                sb.append("   phase2: start took [").append(timeValueMillis(recoveryResponse.startTime)).append("]\n");
                    request.totalTranslogOps(),
import org.opensearch.transport.TransportService;
    class TranslogOperationsRequestHandler implements TransportRequestHandler<RecoveryTranslogOperationsRequest> {
                );
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.CLEAN_FILES, request);
            RecoveryHandoffPrimaryContextRequest::new,
        }
                    logger.warn(
                logger.warn(
import org.opensearch.index.engine.RecoveryEngineException;
            }
            RecoveryPrepareForTranslogOperationsRequest::new,
                    public void onTimeout(TimeValue timeout) {
            final TimeValue recoveryTime = new TimeValue(timer.time());
 *    http://www.apache.org/licenses/LICENSE-2.0
                        // note that we do not use a timeout (see comment above)
    public static StartRecoveryRequest getStartRecoveryRequest(
        public void messageReceived(final FileChunkRequest request, TransportChannel channel, Task task) throws Exception {
                return;
 * not use this file except in compliance with the License.
    /**
                })
                    // this will be logged as warning later on...
 */
    }
        logger.trace("{} collecting local files for [{}]", recoveryTarget.shardId(), recoveryTarget.sourceNode());
            );
                                e
 * compatible open source license.
        private void onException(Exception e) {
/**
                    startRequest = getStartRecoveryRequest(
        try {
        @Override
        );
                    final IndexShard indexShard = recoveryTarget.indexShard();
    public PeerRecoveryTargetService(
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
            onGoingRecoveries.fail(recoveryId, new RecoveryFailedException(request, e), true);
                        listener.onFailure(
                    );
        ClusterService clusterService
        transportService.registerRequestHandler(
                // in very rare cases a translog replay from primary is processed before a mapping update on this node
import org.opensearch.transport.TransportRequest;
                    } else {
        DiscoveryNode localNode,
                if (recoveryRef != null) {
                StringBuilder sb = new StringBuilder();
                // unwrap an exception that was thrown as part of the recovery
        }
        @Override
                final RecoveryTarget recoveryTarget = recoveryRef.get();
            ThreadPool.Names.GENERIC,
import org.opensearch.indices.replication.common.ReplicationCollection;
            final RecoveryTarget recoveryTarget = recoveryRef.get();
            recoverySettings.activityTimeout()
import org.opensearch.transport.TransportResponseHandler;
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
                try {
                    recoveryId,
                // Make sure that the current translog is consistent with the Lucene index; otherwise, we have to throw away the Lucene
                requestToSend = new ReestablishRecoveryRequest(recoveryId, startRequest.shardId(), startRequest.targetAllocationId());
        final long recoveryId = request.recoveryId();
                recoveryTarget.prepareForTranslogOperations(request.totalTranslogOps(), listener);
/*
                final ActionListener<Void> listener = recoveryTarget.createOrFinishListener(channel, Actions.PREPARE_TRANSLOG, request);
                    );
        final AtomicLong bytesSinceLastPause = new AtomicLong();
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
        }
                    .append("]\n");
                logger.debug("delaying recovery due to missing mapping changes", exception);
        }
     * Prepare the start recovery request.
                            + "to unassigned and recovering as if there are none",
    }
            metadataSnapshot = Store.MetadataSnapshot.EMPTY;
                if (listener == null) {
    private final TransportService transportService;
                request.totalTranslogOps(),
                        startingSeqNo,
        threadPool.generic().execute(new RecoveryRunner(recoveryId));
        );
            }
    }
                startRequest = preExistingRequest;
            // happens on an empty folder. no need to log
                    .append(", took [")
                    return;
        }
                );
                }
                }
                } else {
                    recoverySettings.recoveryRateLimiter(),
                    final boolean hasNoTranslog = indexShard.indexSettings().isRemoteSnapshot();
        public static final String FINALIZE = "internal:index/shard/recovery/finalize";
import org.opensearch.index.shard.IndexShard;
            new FilesInfoRequestHandler()
import org.apache.logging.log4j.LogManager;
        public static final String TRANSLOG_OPS = "internal:index/shard/recovery/translog_ops";
                    request.phase1ExistingFileSizes,
        }
                        verifyTranslog
            assert startingSeqNo == UNASSIGNED_SEQ_NO : startingSeqNo;
                    assert globalCheckpoint + 1 >= startingSeqNo : "invalid startingSeqNo " + startingSeqNo + " >= " + globalCheckpoint;
        public void messageReceived(RecoveryFinalizeRecoveryRequest request, TransportChannel channel, Task task) throws Exception {
                final RecoveryTarget recoveryTarget = recoveryRef.get();
                onGoingRecoveries.fail(recoveryId, new RecoveryFailedException(request, "source has canceled the recovery", cause), false);
        );
                    recoveryTarget.shardId(),
            if (recoveryRef == null) {
                            new OpenSearchTimeoutException("timed out waiting for mapping updates " + "(timeout [" + timeout + "])")
                        // plan to revamp this flow so that node-node segment copy will not happen.
                        } catch (Exception e) {
        public RecoveryResponse read(StreamInput in) throws IOException {
            new PrepareForTranslogOperationsRequestHandler()
    }
                        && indexShard.indexSettings().isAssignedOnRemoteNode();
                cause = cause.getCause();
                // which causes local mapping changes since the mapping (clusterstate) might not have arrived on this node.
        }
        Store.MetadataSnapshot metadataSnapshot;
            // here, we would add checks against exception that need to be retried (and not removeAndClean in this case)
     */
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.core.common.unit.ByteSizeValue;
        Logger logger,
                } catch (IOException | TranslogCorruptedException e) {
            }
                    recoverySettings.retryDelayNetwork(),
            Actions.PREPARE_TRANSLOG,
        @Override
            recoveryTarget.state().getPrimary(),
                    e
    }
import org.opensearch.index.shard.ShardNotFoundException;
        private final StartRecoveryRequest startRecoveryRequest;
        }
            }
import org.opensearch.threadpool.ThreadPool;
        public static final String FILES_INFO = "internal:index/shard/recovery/filesInfo";
                    );
     * <a href="https://github.com/opensearch-project/OpenSearch/issues/4502">github issue</a> on it.
                        recoveryTarget,
                    .append("]")
                    // that the primary used to index the operations in the request.
import org.opensearch.index.store.Store;
            startRequest.sourceNode(),
        final String actionName;
import org.opensearch.core.action.ActionListener;
 * GitHub history for details.
                java.util.List<String> dfaFiles = metadataSnapshot.asMap()
import org.opensearch.cluster.ClusterState;
        logger.trace("will retry recovery with id [{}] in [{}] (reason [{}])", recoveryId, retryAfter, reason);
        final long recoveryId;
            try (ReplicationRef<RecoveryTarget> recoveryRef = onGoingRecoveries.getSafe(request.recoveryId(), request.shardId())) {
 *
                logger.info(
            }
                    );
 */
    }
                    indexShard.prepareForIndexRecovery();
                    e
                sb.append("         : recovered [")
     *
            throws Exception {
                    public void onNewClusterState(ClusterState state) {
    }
                    request.sourceMetaSnapshot(),
                    .append("\n");
                            ) {
        }
        // we fork off quickly here and go async but this is called from the cluster state applier thread too and that can cause
        transportService.sendRequest(
            }
                    request.totalTranslogOps,
                    .collect(java.util.stream.Collectors.toList());
                    .stream()
                                    request.recoveryId(),
@PublicApi(since = "1.0.0")
                startingSeqNo = UNASSIGNED_SEQ_NO;
        if (newTarget != null) {
                        + "dfaFiles={} dfaList=[{}] luceneSample=[{}]",
            new RecoveryTarget(indexShard, sourceNode, listener, threadPool),
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
                    () -> new ParameterizedMessage(
                    onGoingRecoveries.fail(
                    .append("] ");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            final ReplicationRef<RecoveryTarget> recoveryRef
                || cause instanceof ShardNotFoundException) {
import org.opensearch.index.translog.Translog;
 * ownership. Elasticsearch licenses this file to you under
                );
                        }
    class FilesInfoRequestHandler implements TransportRequestHandler<RecoveryFilesInfoRequest> {
            };
                    request.phase1FileNames,
            if (cause instanceof DelayRecoveryException || cause instanceof PeerRecoveryNotFound) {
            Actions.TRANSLOG_OPS,
                // unwrap an exception that was thrown as part of the recovery
                    .sorted()
                retryRecovery(
                    .append("]")
            }
                    .append(timeValueMillis(recoveryResponse.phase1Time))
            FileChunkRequest::new,
            this.timer = timer;
            if (cause instanceof RecoveryEngineException) {
            }
import static org.opensearch.common.unit.TimeValue.timeValueMillis;
                    return;
                });
            ThreadPool.Names.GENERIC,
                            try (
                    onGoingRecoveries.fail(
                    request.phase1FileSizes,
package org.opensearch.indices.recovery;
 * the Apache License, Version 2.0 (the "License"); you may
                    final boolean hasRemoteSegmentStore = indexShard.indexSettings().isRemoteStoreEnabled();
            new RecoveryResponseHandler(startRequest, timer)
    public static class Actions {
        );
                        recoveryId,
    }
        private final ReplicationTimer timer;
/*
                final RecoveryTarget recoveryTarget = recoveryRef.get();
                    .collect(java.util.stream.Collectors.joining(", "));
                String luceneSample = metadataSnapshot.asMap()
import org.opensearch.core.transport.TransportResponse;
        long startingSeqNo
import java.util.function.Consumer;
                    final boolean verifyTranslog = (hasRemoteTranslog || hasNoTranslog || hasRemoteSegmentStore) == false;
                        try {
                        retryOnMappingException.accept(e);
                    request.sourceNode(),
            new TranslogOperationsRequestHandler()
            if (logger.isInfoEnabled()) {
    private class RecoveryResponseHandler implements TransportResponseHandler<RecoveryResponse> {
        } catch (final IOException e) {
            recoveryTarget.sourceNode(),
                    requestToSend = startRequest;
import org.apache.lucene.store.AlreadyClosedException;
                recoveryTarget.handleFileChunk(
                        );
import org.opensearch.cluster.ClusterStateObserver;
                    @Override
                sb.append("         : reusing_files   [")
import org.opensearch.action.ActionRunnable;
    /**
            // we do some heavy work like refreshes in the response so fork off to the generic threadpool
            metadataSnapshot,
        );
            new FinalizeRecoveryRequestHandler()
     * @param localNode        the local node of the recovery target
                    .append(new ByteSizeValue(recoveryResponse.phase1TotalSize))
        RecoverySettings recoverySettings,
                    .append(recoveryResponse.phase1ExistingFileNames.size())
    private final ClusterService clusterService;
        @Override
                    luceneSample
            RecoveryFinalizeRecoveryRequest::new,
            onException(e);
     * @param recoveryId recovery id
        );
            if (cause instanceof RecoveryEngineException) {
                    public void onClusterServiceClose() {
            }
                final RecoveryTarget recoveryTarget = recoveryRef.get();
            // the REESTABLISH_RECOVERY request. In this case, we delay and then attempt to restart.
                    .append(']')
                return;
                onGoingRecoveries.fail(recoveryId, new RecoveryFailedException(request, "source shard is closed", cause), false);
                        clusterService.localNode(),
    }
            }
    class CleanFilesRequestHandler implements TransportRequestHandler<RecoveryCleanFilesRequest> {
            Actions.FILE_CHUNK,
    protected void retryRecovery(final long recoveryId, final Throwable reason, TimeValue retryAfter, TimeValue activityTimeout) {
                    "[DFA-RECOVERY] peer recovery TARGET sending metadata to source shardId={} totalFiles={} "
            }
        );
        @Override
                            indexShard.syncSegmentsFromRemoteSegmentStore(false, recoveryTarget::setLastAccessTime);
        transportService.registerRequestHandler(
 * this work for additional information regarding copyright
            if (cause instanceof AlreadyClosedException) {
                try {
