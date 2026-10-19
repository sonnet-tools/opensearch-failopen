        public int hashCode() {
            R request,
        private final ReplicationTask task;
        }
     *
        @Override
    public static class ReplicaResult {
                if (state.nodes().nodeExists(primary.currentNodeId()) == false) {
    }
                            "failed to find index [{}] for request [{}] despite sender thinking it would be here. "
                }
     *
                });
    public ClusterBlockLevel indexBlockLevel() {
    }
         **/
     * method because its more convenient that way.
        this.threadPool = threadPool;
                    final IndexShard indexShard = primaryShardReference.indexShard;
     * Execute the specified replica operation. This is done under a permit from
                    return;
                ),
                + '\''
                                            "{} failed to execute post-operation global checkpoint sync",
        public final Response finalResponseIfSuccessful;
 * nodes with replica copies to perform replication.
                listener = ActionListener.map(listener, result -> {
            out.writeString(targetAllocationID);
                in -> new ConcreteShardRequest<>(requestReader, in),
    }
            settings,
                // target is not aware that it is the active primary shard already.
            localCheckpoint = in.readZLong();
        final TransportChannel channel,
        }
    /**
            this.globalCheckpoint = globalCheckpoint;
                    if (state.version() < request.routedBasedOnClusterVersion()) {
import org.opensearch.transport.TransportRequestOptions;
        public String getDescription() {
                        onCompletionListener.onResponse(response);
            out.writeVLong(primaryTerm);
    /**
    /**
                                            primaryShardReference.indexShard.shardId()
        ) {
        public ReplicaResponse(long localCheckpoint, long globalCheckpoint) {
        }
                if (blockException != null) {
            shardStateAction,
        }
            actionName,
     */
        ShardStateAction shardStateAction,
        final IndexShard replica,
            String message,
        runReroutePhase(task, request, listener, false);
        Releasable releasable = checkPrimaryLimits(
                    primaryShardReference.close(); // release shard operation lock as soon as possible
            logger.warn(
import org.opensearch.core.Assertions;
            executor,
        final Request request,
import org.opensearch.common.unit.TimeValue;
        public String toString() {
            );
import org.opensearch.action.UnavailableShardsException;
                    finishAsFailed(blockException);
        }
            clusterService,
import org.opensearch.transport.TransportResponseHandler;
        this(
        private final long primaryTerm;
        return null;
            ReplicationTask replicationTask
            return replicaRequest;
                    request.shardId(),
import org.opensearch.transport.client.transport.NoNodeAvailableException;
            });
            // is a non-write operation (something like a refresh or a global
                                if (ExceptionsHelper.unwrap(e, AlreadyClosedException.class, IndexShardClosedException.class) == null) {
                @Override
import org.opensearch.index.shard.IndexShard;
    protected Releasable checkPrimaryLimits(final Request request, boolean rerouteWasLocal, boolean localRerouteInitiatedByNodeClient) {
                    e
        }
     * @return Primary term validation replicas proxy.
    protected void acquirePrimaryOperationPermit(
                        + result.replicaRequest()
            if (blockException != null) {
            executor,
                listener.onResponse(null);
                indexShard,
            return indexShard.isRelocatedPrimary();
            actionFilters,
            forceExecutionOnPrimary,
            listener.onFailure(e);
                        AsyncReplicaAction.this.onFailure(e);
        private long globalCheckpoint;
    }
        @Override
            this(task, request, listener, false);
                        return;
            }
                        setPhase(replicationTask, "finished");
        final long maxSeqNoOfUpdatesOrDeletes
                + "] failure and ["
        protected void responseWithFailure(Exception e) {
                );
    }
            );
     */
 * KIND, either express or implied.  See the License for the
        }
        @Override
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
                        if (cause instanceof ConnectTransportException
                + getTargetAllocationID()
    }
     */
    public static final String REPLICA_ACTION_SUFFIX = "[r]";
            this::handleReplicaRequest
            Objects.requireNonNull(targetAllocationID);
            setPhase(task, "replica");
            sentFromLocalReroute = false;
                transportPrimaryAction,
        implements
    }
                transportPrimaryAction,
    protected final ClusterService clusterService;
        private final ActionListener<Response> onCompletionListener;
                + '\''
            final long maxSeqNoOfUpdatesOrDeletes
            globalCheckpoint = in.readZLong();
                @Override
                    performRemoteAction(state, primary, node);
            // "alive" if it were to be marked as stale.
            if (Assertions.ENABLED) {
        final ActionListener<Releasable> onAcquired
        public PrimaryResult(ReplicaRequest replicaRequest, Response replicationResponse) {
        try {
        private final boolean sentFromLocalReroute;
                @Override
     */
            @Override
            if (observer.isTimedOut()) {
            out.writeZLong(localCheckpoint);
        public void performOn(
                        logger,
        @Override
                listener.onResponse(null);
                    );
        public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {
/*
            return indexShard.getLastKnownGlobalCheckpoint();
                throw new UnsupportedOperationException("Primary term validation is not available for " + actionName);
                + ", primaryTerm='"
        runReroutePhase(task, request, listener, true);
                            new IndexNotFoundException(
        clusterSettings.addSettingsUpdateConsumer(REPLICATION_INITIAL_RETRY_BACKOFF_BOUND, (v) -> initialRetryBackoffBound = v);
                            request.routedBasedOnClusterVersion()
                    "failed to find primary as current cluster state with version ["
        this.transportService = transportService;
        @Override
                            )
                );
        @Override
            );
         * Result of executing a primary operation
            this.replicaRequest = replicaRequest;
            performAction(
                            request.shardId().getIndex(),
                    @Override
                    if (e instanceof ShardNotInPrimaryModeException) {
            final ClusterState state = observer.setAndGetObservedState();
        if (task != null) {
            return indexShard.getLocalCheckpoint();
     *
            return globalCheckpoint;
            ) {
     * method can be overridden to acquire more.
                                indexShard.isRemoteTranslogEnabled()
            null
            requestReader,
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
            return request.createTask(id, type, action, parentTaskId, headers);
            // "alive" if it were to fail.
import org.opensearch.action.support.ActionFilters;
            }
                return blockException;
                    assert primary.relocating() : "indexShard is marked as relocated but routing isn't" + primary;
        public void setShardInfo(ReplicationResponse.ShardInfo shardInfo) {
            transportService.registerRequestHandler(
            }
                if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
                        request,
     *
    private final boolean syncGlobalCheckpointAfterOperation;
    class PrimaryShardReference
            try {
                request.routedBasedOnClusterVersion(state.version());
        public final Exception finalFailure;
        this.retryTimeout = getRetryTimeoutSetting().get(settings);
                        state.version()
                if (primary.currentNodeId().equals(state.nodes().getLocalNodeId())) {
        public ConcreteShardRequest(
                    @Override
                    }
                public void handleResponse(Response response) {
        }
        private final ActionListener<ReplicaResponse> onCompletionListener;
                            primaryRequest.getPrimaryTerm()
                                termValidationProxy,
                        replicaRequest.getRequest()
        }
                        + request.routedBasedOnClusterVersion()
     */
 * the Apache License, Version 2.0 (the "License"); you may
                    ).execute();
            final ShardId shardId = primaryRequest.getRequest().shardId();
import org.opensearch.cluster.node.DiscoveryNode;
        }
        }
                        );
            threadPool,
    }
            onFailure(e);
/*
                    logger.trace("operation succeeded. action [{}],request [{}]", actionName, request);
    protected final TransportRequestOptions transportOptions;
        boolean forceExecutionOnPrimary,
        Writeable.Reader<ReplicaRequest> replicaRequestReader,
            });
            settings,
            new ChannelActionListener<>(channel, transportPrimaryAction, request),
                                replicasProxy,
        ClusterService clusterService,
    protected boolean retryPrimaryException(final Throwable e) {
            final IndexShard indexShard = getIndexShard(shardId);
                    assert result.replicaRequest() == null || result.finalFailure == null : "a replica request ["
                );
                    new ReplicationOperation<>(
import org.opensearch.transport.TransportRequest;
    }
        );
        public void close() {
                logger.trace(
import org.opensearch.cluster.block.ClusterBlockException;
            setPhase(task, "rerouted");
            }
                                getReplicationMode(indexShard),
        public void onFailure(Exception e) {
                                primaryShardReference.indexShard.maybeSyncGlobalCheckpoint("post-operation");
            releasable::close
    boolean isRetryableClusterBlockException(final Throwable e) {
                        final ReplicaResponse response = new ReplicaResponse(
                logger.trace(
        // public for tests
        public long globalCheckpoint() {
                        }
                replicaRequest.getPrimaryTerm(),
import java.io.IOException;
        try {
                                "failed to find index as current cluster state with version ["
                    // phase is executed on local shard and all subsequent operations are executed on relocation target as primary phase.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                public void handleException(TransportException exp) {
     */
        } catch (RuntimeException e) {
        );
                        finishAsFailed(new IndexNotFoundException(request.shardId().getIndex()));
            transportService,
                );
        return false;
            final ActionListenerResponseHandler<ReplicaResponse> handler = new ActionListenerResponseHandler<>(
                    request.shardId(),
        }
    class AsyncPrimaryAction extends AbstractRunnable {
        }
                    "send action [{}] on primary [{}] for request [{}] with cluster state version [{}] to [{}]",
    protected ClusterBlockLevel globalBlockLevel() {
        PrimaryShardReference(IndexShard indexShard, Releasable operationLock) {
         * {@link AllocationId#getId()} of the shard this request is sent to
        public void onResponse(Releasable releasable) {
        Request shardRequest,
    protected Setting<TimeValue> getRetryTimeoutSetting() {
     * @param requestReader instance of the request reader
            this.replicaRequest = replicaRequest;
                    DiscoveryNode relocatingNode = clusterState.nodes().get(primary.relocatingNodeId());
 * <p>
    private final class AsyncReplicaAction extends AbstractRunnable implements ActionListener<Releasable> {
                    "unexpected error during the primary phase for action [{}], request [{}]",
import org.opensearch.transport.ConnectTransportException;
                    request,
            clusterService,
            ActionListener<Response> onCompletionListener,
            this.finalFailure = finalFailure;
                true,
        }
            ConcreteReplicaRequest<ReplicaRequest> replicaRequest,
                            replica.getLocalCheckpoint(),
import org.opensearch.common.settings.Setting;
                    retryBecauseUnavailable(request.shardId(), "primary shard is not active");
        }
        }
                                    logger.info(
                            )
             */
                        releasable.close(); // release shard operation lock before responding to caller
        ShardStateAction shardStateAction,
                public void onClusterServiceClose() {
     *
                if (logger.isTraceEnabled()) {
            assert sentFromLocalReroute == false;
                    logger.trace(
                assert false : new AssertionError("finishAsFailed called but operation is already finished", failure);
            new AsyncPrimaryAction(request, listener, (ReplicationTask) task).run();
        return () -> {};
import org.opensearch.index.IndexService;
                    replica,
        public boolean sentFromLocalReroute() {
import org.opensearch.action.support.TransportActions;
            out.writeZLong(globalCheckpoint);
        );
        @Override
     * Resolves index and shard id for the request before routing it to target node
                }
            final ShardId shardId = replicaRequest.getRequest().shardId();
        public long getMaxSeqNoOfUpdatesOrDeletes() {
 * Modifications Copyright OpenSearch Contributors. See
            finishWithUnexpectedFailure(e);
import org.opensearch.node.NodeClosedException;
            final long primaryTerm,
        ReroutePhase(ReplicationTask task, Request request, ActionListener<Response> listener) {
                            new ActionListenerResponseHandler<>(onCompletionListener, ReplicaResponse::new)
        public boolean equals(Object o) {
        public void onFailure(Exception e) {
                    initiatedByNodeClient
            observer.waitForNextChange(new ClusterStateObserver.Listener() {
 * compatible open source license.
                        + state.version()
        private final boolean initiatedByNodeClient;
        ) {
        public long globalCheckpoint() {
     * Index level block to check before request execution. Returning null means that no blocks need to be checked.
            return ((ClusterBlockException) e).retryable();
                    "expected allocation id [{}] but found [{}]",
            setPhase(task, "waiting_for_retry");
             * checkpoint background sync, and the primary/replica resync).
                        relocatingNode,
        private final ClusterStateObserver observer;
        void finishWithUnexpectedFailure(Exception failure) {
import org.opensearch.cluster.ClusterState;
                    public void onNewClusterState(ClusterState state) {
import org.opensearch.index.IndexNotFoundException;
                logger.trace(() -> new ParameterizedMessage("operation failed. action [{}], request [{}]", actionName, request), failure);
    );
        final ReplicaRequest request,
                throw new ReplicationOperation.RetryOnPrimaryException(shardId, "actual shard is not a primary " + shardRouting);
     * Asynchronous primary action
        this.transportReplicaAction = actionName + REPLICA_ACTION_SUFFIX;
            return indexShard.getReplicationGroup();
        }
    private ClusterBlockException blockExceptions(final ClusterState state, final String indexName) {
        protected void doRun() {
            transportService.sendRequest(node, action, requestToPerform, transportOptions, new TransportResponseHandler<Response>() {
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
        return e.getClass() == ReplicationOperation.RetryOnPrimaryException.class
        }
                @Override
                final ShardRouting primary = state.getRoutingTable().shardRoutingTable(request.shardId()).primaryShard();
                    state.version(),
    public static class ConcreteShardRequest<R extends TransportRequest> extends TransportRequest {
import org.opensearch.common.settings.Settings;
                }
        @Override
        }
     *
                        + "]";
        clusterSettings.addSettingsUpdateConsumer(getRetryTimeoutSetting(), (v) -> retryTimeout = v);
                    return;
            if (finalFailure != null) {
                throw new ShardNotFoundException(
                }
        public R getRequest() {
        boolean forceExecutionOnPrimary
                final IndexMetadata indexMetadata = clusterState.metadata().getIndexSafe(primaryShardReference.routingEntry().index());
import org.opensearch.index.shard.IndexShardClosedException;
            this.finalFailure = finalFailure;
                            @Override
        }
        return TransportRequestOptions.EMPTY;
 *
                        transportReplicaAction,
     * @param primary      the primary shard to perform the operation on
                    } catch (Exception e) {
            setPhase(task, "waiting_on_primary");
            false
            setPhase(task, "routing");
import java.util.Objects;
        this.shardStateAction = shardStateAction;
                responseWithFailure(e);
                    actionName,
                return;
            ActionListener<ReplicaResponse> onCompletionListener,
        this.clusterService = clusterService;
import org.opensearch.transport.TransportService;
                final IndexMetadata indexMetadata = state.metadata().index(request.shardId().getIndex());
                listener.onFailure(finalFailure);
import org.opensearch.OpenSearchException;
                + "] response";
            final long globalCheckpoint,
    protected final boolean forceExecutionOnPrimary;
                    "expected allocation id [{}] but found [{}]",
            final String action,
                ReplicaResponse::new
            final DiscoveryNode node,
        }
                            public void handleException(TransportException exp) {
            request.waitForActiveShards(indexMetadata.getWaitForActiveShards());
        this.transportOptions = transportOptions(settings);
        return null;
        }
                        primary.currentNodeId(),
        @Override
        );
            this.finalResponseIfSuccessful = finalResponseIfSuccessful;
                            );
                        onFailure(e);
        }
     *
                        }
     * @param replica      the replica shard to perform the operation on
    protected final String transportReplicaAction;
        super(actionName, actionFilters, transportService.getTaskManager());
            final ShardRouting shardRouting = indexShard.routingEntry();
        }
        }
import org.opensearch.cluster.routing.AllocationId;
    }
                        primaryShardReference.close(); // release shard operation lock before responding to caller
     */
        public String getTargetAllocationID() {
            }
     * The primary shard reference
            setPhase(task, "finished");
     * shards. It also encapsulates the logic required for failing the replica
import org.opensearch.index.seqno.SequenceNumbers;
    protected final ShardStateAction shardStateAction;
        public void perform(Request request, ActionListener<PrimaryResult<ReplicaRequest, Response>> listener) {
            this.onCompletionListener = onCompletionListener;
                globalCheckpoint,
    }
                    // resolve it from the index settings
        Releasable releasable = checkReplicaLimits(replicaRequest.getRequest());
                    finishOnSuccess(response);
 * SPDX-License-Identifier: Apache-2.0
                transportPrimaryAction,
            this.task = task;
            performAction(node, actionName, false, request);
        protected void doRun() throws Exception {
                        actionName,
 *
import org.opensearch.common.lease.Releasable;
        @Override
            request = requestReader.read(in);
 *     http://www.apache.org/licenses/LICENSE-2.0
        private final R request;
     * The Primary Result
    public static final Setting<TimeValue> REPLICATION_INITIAL_RETRY_BACKOFF_BOUND = Setting.timeSetting(
            this.sentFromLocalReroute = sentFromLocalReroute;
        }
        Writeable.Reader<Request> requestReader,
        TimeValue.timeValueMillis(50),
 */
import java.util.Map;
            if (logger.isTraceEnabled()) {
                                        new ParameterizedMessage(
                ActionListener.wrap(releasable -> runWithPrimaryShardReference(new PrimaryShardReference(indexShard, releasable)), e -> {
        TimeValue.timeValueMillis(10),
            this.primaryRequest = primaryRequest;
        Setting.Property.NodeScope
            listener.onResponse(null);
    @Nullable
            }
        @Override
     * @opensearch.internal
        public void updateGlobalCheckpointForShard(final String allocationId, final long globalCheckpoint) {
        }
        if (globalBlockLevel != null) {
                    );
        }
            }
            final String actualAllocationId = this.replica.routingEntry().allocationId().getId();
        }
            } else {
            final ClusterBlockException blockException = blockExceptions(state, request.shardId().getIndexName());
        public RetryOnReplicaException(StreamInput in) throws IOException {
                            }
        Settings settings,
                        request,
    protected void resolveRequest(final IndexMetadata indexMetadata, final Request request) {
        }
     * Internal request for concrete replica
                    final ShardRouting primary = primaryShardReference.routingEntry();
            }
        void runWithPrimaryShardReference(final PrimaryShardReference primaryShardReference) {
     */
        Setting.Property.Dynamic,
    }
     * This method is used for defining the {@link ReplicationMode} override per {@link TransportReplicationAction}.
    /**
            } else {
        String actionName,
        boolean syncGlobalCheckpointAfterOperation,
            actionName,
        if (e instanceof ClusterBlockException) {
    }
    protected void handleReplicaRequest(
        String actionName,
     *
                        onFailure(new ReplicationOperation.RetryOnPrimaryException(shardId, "shard is not in primary mode", e));
        ClusterBlockLevel indexBlockLevel = indexBlockLevel();
            final ShardRouting replica,
                            + "cluster state version [{}]",
        String actionName,
            releasable::close
        }
        }
                if (indexMetadata == null) {
        public void setParentTask(TaskId taskId) {
                + "found ["
 * specific language governing permissions and limitations
import org.opensearch.tasks.Task;
        } catch (RuntimeException e) {
        this.forceExecutionOnPrimary = forceExecutionOnPrimary;
        return indexService.getShard(shardId.id());
                ShardRouting replica,
                }
                    finishAsFailed(new IndexClosedException(indexMetadata.getIndex()));
            this.globalCheckpoint = globalCheckpoint;
            releasable::close
    }
            this.listener = listener;
    }
                        primaryRequest.getRequest(),
                long maxSeqNoOfUpdatesOrDeletes,
        ActionListener<Response> listener = ActionListener.runBefore(
import org.opensearch.cluster.block.ClusterBlockLevel;
 * under the License.
            return primaryTerm;
                    return;
                final ClusterBlockException blockException = blockExceptions(clusterState, indexMetadata.getIndex().getName());
        private final ReplicationTask task;
    }
        @Override
        }
            }
                replica.allocationId().getId(),
                } else {
    ) {
                        return;
            onCompletionListener.onFailure(e);
    }
        @Override
/*
    protected class ReplicasProxy implements Replicas<ReplicaRequest> {
            final long globalCheckpoint,
     * Additional processing or validation of the request should be done here.
    ) {
                                        ),
        }
        }
     * This returns a ReplicaProxy that is used for primary term validation. The default behavior is that the control
 * ownership. Elasticsearch licenses this file to you under
    }
 * You may obtain a copy of the License at
        String executor,
            ClusterBlockException blockException = state.blocks().indexBlockedException(indexBlockLevel, indexName);
    @Override
            boolean localRerouteInitiatedByNodeClient
                return blockException;
            request.getRequest(),
            listener.onResponse(null);
        public void onFailure(Exception e) {
                                exp
            final ReplicaRequest request,
    protected static void setPhase(ReplicationTask task, String phase) {
        @Override
                    }
                + getPrimaryTerm()
 * license agreements. See the NOTICE file distributed with
            request.writeTo(out);
                    @Override
                                setPhase(replicationTask, "finished");
                                    "received an error from node [{}] for request [{}], scheduling a retry",
     */
import org.apache.lucene.store.AlreadyClosedException;
             * checkpoint value when simulating responses to replication actions that pre-6.0 nodes are not aware of (e.g., the global
            // we may end up here if the cluster state used to route the primary is so stale that the underlying
            globalCheckpoint = in.readZLong();
/**
                    "failed to find primary [{}] for request [{}] despite sender thinking it would be here. Local cluster state "
    /**
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                        e.addSuppressed(exp);
                    }
            if (finished.compareAndSet(false, true)) {
     * must not reach inside the performOn method for ReplicationActions. However, the implementations of the underlying
        if (indexShard.indexSettings().isAssignedOnRemoteNode()) {
                    actualTerm
            }
        // is only true if sentFromLocalReroute is true.
                @Override
import org.opensearch.cluster.metadata.ResolvedIndices;
                    "expected allocation id [{}] with term [{}] but found [{}]",
    }
            }
                observer.waitForNextChange(new ClusterStateObserver.Listener() {
            assert localCheckpoint != SequenceNumbers.UNASSIGNED_SEQ_NO;
                long globalCheckpoint,
            shardOperationOnPrimary(request, indexShard, listener);
                forceExecutionOnPrimary,
                        indexShard.indexSettings().isAssignedOnRemoteNode()
        }
            false,
import org.opensearch.common.lease.Releasables;
                                replicaRequest.getRequest()
                new ConcreteShardRequest<>(
            syncGlobalCheckpointAfterOperation,
import org.opensearch.index.shard.ShardNotFoundException;
    }
    protected Releasable checkReplicaLimits(final ReplicaRequest request) {
            if (task != null) {
            }
            return Objects.hash(localCheckpoint, globalCheckpoint);
    /**
    }
            listener.onFailure(e);
            true,
        @Override
            this(replicaRequest, replicationResponse, null);
        private final long globalCheckpoint;
            listener.onFailure(e);
                this,
    /**
     * The replica result
        public ConcreteShardRequest(Writeable.Reader<R> requestReader, StreamInput in) throws IOException {
            if (finished.compareAndSet(false, true)) {
            this.initiatedByNodeClient = initiatedByNodeClient;
                if (primaryShardReference.isRelocated()) {
                    run();
     * @param shardRequest the request to the primary shard
     * The timeout for retrying replication requests.
 * this file be licensed under the Apache-2.0 license or a
                setPhase(task, "finished");
                                + "Local cluster state version [{}]] is older than on sending node (version [{}]), scheduling a retry...",
        }
import org.opensearch.action.support.TransportIndicesResolvingAction;
                );
        AdmissionControlActionType admissionControlActionType
import org.opensearch.transport.TransportChannel;
        }
        ThreadPool threadPool,
import org.apache.logging.log4j.message.ParameterizedMessage;
            task.setPhase(phase);
import org.opensearch.core.common.io.stream.Writeable;
            final ActionListener<ReplicationOperation.ReplicaResponse> listener
        public void failShardIfNeeded(
            super(request, targetAllocationID, primaryTerm);
                    })), e -> {
        @Override
                        responseWithFailure(new NodeClosedException(clusterService.localNode()));
        @Override
                        onCompletionListener.onResponse(response);
        }
                    state.version(),
        public ShardRouting routingEntry() {
                    : "request waitForActiveShards must be set in resolveRequest";
    }
                    final Replicas<ReplicaRequest> termValidationProxy = primaryTermValidationReplicasProxy();
    }
                }
            super.writeTo(out);
        }
            if (state.version() < request.routedBasedOnClusterVersion()) {
            this(request, targetAllocationID, primaryTerm, false, false);
        this(
        @Override
import org.opensearch.indices.IndicesService;
            }
                public Response read(StreamInput in) throws IOException {
            assert finalFailure != null ^ finalResponseIfSuccessful != null : "either a response or a failure has to be not null, "
        @Override
        );
import org.opensearch.common.util.concurrent.AbstractRunnable;
                    transportService.sendRequest(
            try {
     * @opensearch.internal
        AdmissionControlActionType admissionControlActionType
            replicaRequestReader,
                public void onTimeout(TimeValue timeout) {
        public void setParentTask(String parentTaskNode, long parentTaskId) {
                        setPhase(task, "finished");
        private final Request request;
                );
                        final Throwable cause = exp.unwrapCause();
                handleException(primaryShardReference, e);
            || TransportActions.isShardNotAvailableException(e)
        public long getPrimaryTerm() {
                indexShard.failShard(reason, e);
    /**
                final DiscoveryNode node = state.nodes().get(primary.currentNodeId());
            if (actualAllocationId.equals(primaryRequest.getTargetAllocationID()) == false) {
    @Override
    protected Releasable checkOperationLimits(final Request request) {
                failure
            } else {
        if (request.waitForActiveShards() == ActiveShardCount.DEFAULT) {
            return maxSeqNoOfUpdatesOrDeletes;
        }
                    request,
                        transportOptions,
        public ReplicaResponse(StreamInput in) throws IOException {
                                        e
                    primaryRequest.getTargetAllocationID(),
                }
            true,
                }
        ActionFilters actionFilters,
     */
    /**
     * @param request       the request to resolve
        ActionListener<ReplicaResult> listener
        Settings settings,
            try {
     * @param indexShard index shard used to determining the policy.
        TransportService transportService,
        Setting.Property.NodeScope
        private void handleException(PrimaryShardReference primaryShardReference, Exception e) {
     * @opensearch.internal
     * interface that performs the actual {@code ReplicaRequest} on the replica
                            transportReplicaAction,
            final boolean isPrimaryAction,
     * @param indexMetadata index metadata of the concrete index this request is going to operate on
                    setPhase(replicationTask, "primary_delegation");
                    public void onTimeout(TimeValue timeout) {
    }
                            replica.getLastSyncedGlobalCheckpoint()
            if (finalFailure != null) {
                    } else {
     * @opensearch.internal
            } else {
        @Override
                // we running as a last attempt after a timeout has happened. don't retry
        final Exception finalFailure;
        void retry(Exception failure) {
            if (actualAllocationId.equals(replicaRequest.getTargetAllocationID()) == false) {
            acquireReplicaOperationPermit(
                    }, e -> handleException(primaryShardReference, e));
     */
    }
        }
                forceExecutionOnPrimary,
                        }
    /**
     *
     * Primary operation on node with primary copy.
    protected final TransportService transportService;
                    request.routedBasedOnClusterVersion()
            return ReplicationMode.NO_REPLICATION;
        private final ActionListener<Response> listener;
                            }
            Exception exception,
                                    + request.routedBasedOnClusterVersion()
        IndicesService indicesService,
                                }
        }
        public long computedGlobalCheckpoint() {
        }
            this.task = task;
                        responseWithFailure(e);
            maxSeqNoOfUpdatesOrDeletes = in.readZLong();
            // This does not need to make the shard stale. The idea is that this
                    transportPrimaryAction,
import org.opensearch.cluster.action.shard.ShardStateAction;
                        retryTimeout,
                    try {
     * @opensearch.internal
            this.localCheckpoint = localCheckpoint;
            acquirePrimaryOperationPermit(
                    primaryRequest.getTargetAllocationID(),
                        primaryRequest.getPrimaryTerm(),
        @Override
                    return newResponseInstance(in);
                + ", request="
                replicaRequest.getGlobalCheckpoint(),
            onCompletionListener.onFailure(e);
            );
import org.opensearch.core.tasks.TaskId;
                }
            final DiscoveryNode node = clusterService.state().nodes().get(nodeId);
            return request;
     *
        public long localCheckpoint() {
                        if (logger.isTraceEnabled()) {
import org.opensearch.action.support.ChannelActionListener;
            return targetAllocationID;
        public ReplicationGroup getReplicationGroup() {
                }
                        // if we got disconnected from the node, or the node / shard is not in the right state (being closed)
        Releasable releasable = checkOperationLimits(request);
            } catch (Exception e) {
     */
            indicesService,
                                clusterState.getNodes(),
                    // it is safe to execute primary phase on relocation target as there are no more in-flight operations where primary
            // if the wait for active shard count has not been set in the request,
import org.opensearch.ExceptionsHelper;
                            primaryRequest.getRequest(),
            if (logger.isTraceEnabled()) {
            this.maxSeqNoOfUpdatesOrDeletes = maxSeqNoOfUpdatesOrDeletes;
        }
            return indexShard.getPendingReplicationActions();
                + getRequest()
     * Making primary and replica actions suffixes as constant
        ReroutePhase(ReplicationTask task, Request request, ActionListener<Response> listener, boolean initiatedByNodeClient) {
        }
                }
    protected void adaptResponse(Response response, IndexShard indexShard) {
    protected IndexShard getIndexShard(final ShardId shardId) {
    /**
        Setting.Property.Dynamic,
        this.syncGlobalCheckpointAfterOperation = syncGlobalCheckpointAfterOperation;
     * @opensearch.internal
            threadPool,
        return ReplicationMode.FULL_REPLICATION;
    public static final class ConcreteReplicaRequest<R extends TransportRequest> extends ConcreteShardRequest<R> {
     * Thrown if there are any errors retrying on the replica
        return new ReplicasProxy();
            ActionListener<Void> listener
     * @opensearch.internal
    public static final String PRIMARY_ACTION_SUFFIX = "[p]";
                }
        implements
                                setPhase(replicationTask, "finished");
                                // only log non-closed exceptions
        }
            if (node == null) {
                        adaptResponse(response, primaryShardReference.indexShard);
        private final ClusterStateObserver observer = new ClusterStateObserver(clusterService, null, logger, threadPool.getThreadContext());
                        actionName,
                finishAsFailed(failure);
    public static class PrimaryResult<ReplicaRequest extends ReplicationRequest<ReplicaRequest>, Response extends ReplicationResponse>
                }
        }
        void finishAsFailed(Exception failure) {
                                request.shardId().getIndexName()
        }
    }
                } else {
        boolean syncGlobalCheckpointAfterOperation,
            this.primaryTerm = primaryTerm;
public abstract class TransportReplicationAction<
            this.onCompletionListener = onCompletionListener;
 *
                        retry(
                })
        public RetryOnReplicaException(ShardId shardId, String msg) {
                AsyncReplicaAction.this.onFailure(e);
        ) {
                            primary.allocationId().getRelocationId(),
                in -> new ConcreteShardRequest<>(requestReader, in),
     */
 * Subclasses can resolve the target shard and provide implementation for primary and replica operations.
        }
                + finalFailure
            );
    /**
 */
            // This does not need to fail the shard. The idea is that this
     * Executes the logic for acquiring one or more operation permit on a replica shard. The default is to acquire a single permit but this
    protected final IndicesService indicesService;
                            }
                    }
 * primary node to validate request before primary operation followed by sampling state again for resolving
            assert indexShard.getActiveOperationsCount() != 0 : "must perform shard operation under a permit";
    protected Replicas<ReplicaRequest> primaryTermValidationReplicasProxy() {
            new ReroutePhase((ReplicationTask) task, request, listener, initiatedByNodeClient).run();
                    run();
 * @opensearch.internal
    protected TransportRequestOptions transportOptions(Settings settings) {
        @Override
        }
import org.opensearch.core.common.io.stream.StreamInput;
            this.request = request;
                replica,
        private final IndexShard replica;
 * this work for additional information regarding copyright
 * GitHub history for details.
                                super.handleException(exp);
            ReplicationTask task
        /**
        }
                request,
                        actionName,
        if (indexBlockLevel != null) {
        ActionListener<ReplicaResponse> listener = ActionListener.runBefore(
                    shardId,
        ThreadPool threadPool,
    ) {
                    return ThreadPool.Names.SAME;
    }
            localRerouteInitiatedByNodeClient = false;
            this.indexShard = indexShard;
            this(null);
            return "ConcreteReplicaRequest{"
                finalResponseIfSuccessful.setShardInfo(shardInfo);
                        transportService.sendRequest(
            } catch (Exception inner) {
                ReplicaRequest request,
                        new ConcreteShardRequest<>(
    protected TransportReplicationAction(
                // cluster state version this prevents redirect loops between two nodes when a primary was relocated and the relocation
        String executor
        public boolean localRerouteInitiatedByNodeClient() {
                                    + "]",
                    actionName,
        TransportService transportService,
            } catch (Exception e) {
        // This method will register Primary Request Handler Based on AdmissionControlActionType
        final long globalCheckpoint,
        ReplicaRequest shardRequest,
         * The task on the node with the replica shard.
            return globalCheckpoint;
        public ConcreteReplicaRequest(Writeable.Reader<R> requestReader, StreamInput in) throws IOException {
                        + "]"
        }
                    request
        }
     * {@link IndexShard#acquireReplicaOperationPermit(long, long, long, ActionListener, String, Object)}.
import org.opensearch.cluster.ClusterStateObserver;
            String targetAllocationID,
        }
                true,
import org.opensearch.transport.TransportException;
                    })
            long primaryTerm,
                                super.handleResponse(response);
        public String toString() {
    public static final Setting<TimeValue> REPLICATION_RETRY_TIMEOUT = Setting.timeSetting(
            // the replica will take over and a replica will be assigned to the first node.
    );
        @Override
                        transportPrimaryAction,
        }
            final ConcreteReplicaRequest<ReplicaRequest> replicaRequest = new ConcreteReplicaRequest<>(
        "indices.replication.retry_timeout",
        }
            assert localRerouteInitiatedByNodeClient == false;
        ) {
    }
    private void handleOperationRequest(final Request request, final TransportChannel channel, Task task) {
            ReplicationOperation.PrimaryResult<ReplicaRequest> {
     */
            // is a non-write operation (something like a refresh or a global
    protected void handlePrimaryRequest(final ConcreteShardRequest<Request> request, final TransportChannel channel, final Task task) {
        private final AtomicBoolean finished = new AtomicBoolean();
        primary.acquirePrimaryOperationPermit(onAcquired, executor, request, forceExecutionOnPrimary);
        }
                        }
     * @opensearch.internal
            return "[" + request.getDescription() + "] for aID [" + targetAllocationID + "] and term [" + primaryTerm + "]";
        private final boolean localRerouteInitiatedByNodeClient;
        }
                            + "cluster state version [{}]",
                long primaryTerm,
         */
     *
     *  This method will register handler as based on admissionControlActionType and AdmissionControlHandler will be
                        } else {
        );
                + finalResponseIfSuccessful
            || isRetryableClusterBlockException(e);
                maxSeqNoOfUpdatesOrDeletes
                            || cause instanceof NodeClosedException
     * @opensearch.internal
        registerPrimaryRequestHandler(requestReader, admissionControlActionType);
            this.request = request;
        private void performRemoteAction(ClusterState state, ShardRouting primary, DiscoveryNode node) {
    ReplicaRequest extends ReplicationRequest<ReplicaRequest>,
                }
            requestReader,
import org.opensearch.cluster.metadata.IndexMetadata;
    protected final ThreadPool threadPool;
    }
                node,
                        threadPool,
                    retryBecauseUnavailable(request.shardId(), "primary shard isn't assigned to a known node.");
     */
        IndexShard replica,
     *
 */
                    primary.allocationId().getId(),
     */
                retryBecauseUnavailable(
                    final ActionListener<Response> responseListener = ActionListener.wrap(response -> {
            return indexShard.getLastSyncedGlobalCheckpoint();
            primaryTerm = in.readVLong();
        return ResolvedIndices.of(request.index);
        protected final IndexShard indexShard;
        AsyncPrimaryAction(
        @Override
                // TODO: Evaluate if we still need to catch this exception
        public long localCheckpoint() {
                        state.version()
        }
            transportService.registerRequestHandler(
            } else {
                        replicasProxy,
            }
        }
        replica.acquireReplicaOperationPermit(primaryTerm, globalCheckpoint, maxSeqNoOfUpdatesOrDeletes, onAcquired, executor, request);
        return null;
                        // opportunity to execute custom logic before the replica operation begins
                logger.trace(
                    } else {
            actionFilters,
                public String executor() {
     * Cluster level block to check before request execution. Returning null means that no blocks need to be checked.
                        "primary shard [{}] is not yet active, scheduling a retry: action [{}], request [{}], "
        protected final ReplicaRequest replicaRequest;
    }
                    // if the wait for active shard count has not been set in the request,
                    shardId,
            new AsyncReplicaAction(replicaRequest, listener, (ReplicationTask) task).run();
package org.opensearch.action.support.replication;
                        + "version [{}]] is older than on sending node (version [{}]), scheduling a retry...",
        // we must never reject on because of thread pool capacity on replicas
     */
            request.onRetry();
        AsyncReplicaAction(
                    request.waitForActiveShards(indexMetadata.getWaitForActiveShards());
        @Override
    /**
                            try {
    public static class ReplicaResponse extends ActionResponse implements ReplicationOperation.ReplicaResponse {
        private void performAction(
        @Override
                return;
            transportReplicaAction,
        return new ReplicasProxy() {
        private final String targetAllocationID;
                            || (isPrimaryAction && retryPrimaryException(cause))) {
            if (finished.compareAndSet(false, true)) {
                        ),
        public void writeTo(StreamOutput out) throws IOException {
    /**
                    replicaRequest.getRequest(),
            // the wire, then it was NOT sent from a local reroute.
                }
     * node with primary copy.
    final class ReroutePhase extends AbstractRunnable {
     */
                + ", globalCheckpoint="
                executor,
        public long getGlobalCheckpoint() {
        public PendingReplicationActions getPendingReplicationActions() {
     */
            setPhase(replicationTask, "finished");
                listener,
        public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.Nullable;
import org.opensearch.cluster.service.ClusterService;
            if (o == null || getClass() != o.getClass()) return false;
                                    + state.version()
    ) {
    protected TransportReplicationAction(
     *
            String nodeId = replica.currentNodeId();
                        + result.finalFailure
            final String actualAllocationId = shardRouting.allocationId().getId();
            Objects.requireNonNull(request);
 *
        }
        ActionListener<Response> listener = ActionListener.runBefore(
                    ),
            transportService.sendRequest(node, transportReplicaAction, replicaRequest, transportOptions, handler);
                            @Override
                } else {
                executor,
                + ", maxSeqNoOfUpdatesOrDeletes="
            }
        Writeable.Reader<ReplicaRequest> replicaRequestReader,
            out.writeZLong(globalCheckpoint);
     *
                if (primary == null || primary.active() == false) {
     * will increase exponential if failures continue.
import org.opensearch.threadpool.ThreadPool;
                            clusterService.localNode(),
                    public void onClusterServiceClose() {
            super(requestReader, in);
        public boolean isRelocated() {
                assert request.waitForActiveShards() != ActiveShardCount.DEFAULT
            }
 * Licensed to Elasticsearch under one or more contributor
            transportService,
        private final ReplicationTask replicationTask;
                listener.onFailure(failure);
                replicaRequest.getRequest().onRetry();
        Writeable.Reader<Request> requestReader,
        public PrimaryResult(ReplicaRequest replicaRequest, Response finalResponseIfSuccessful, Exception finalFailure) {
                        );
                                replicaRequest.getRequest().shardId(),
        private final ConcreteReplicaRequest<ReplicaRequest> replicaRequest;
            return request.getParentTask();
        private final long maxSeqNoOfUpdatesOrDeletes;
        @Override
        try {
                                    + "] is stale (expected at least ["
                    );
                throw new ShardNotFoundException(
                + maxSeqNoOfUpdatesOrDeletes
            }
                if (request.waitForActiveShards() == ActiveShardCount.DEFAULT) {
            this.observer = new ClusterStateObserver(clusterService, request.timeout(), logger, threadPool.getThreadContext());
                }
                    logger.trace("cluster is blocked, action failed on primary", blockException);
                            state.version(),
                )
        TransportService transportService,
                throw new ShardNotFoundException(
        return () -> {};
            final long primaryTerm,
                                "action [{}] completed on shard [{}] for request [{}]",
                    primary.currentNodeId()
                @Override
        }
     *
            new ChannelActionListener<>(channel, actionName, request),
                    final Replicas<ReplicaRequest> replicasProxy = newReplicasProxy();
             * A replica should always know its own local checkpoints so this should always be a valid sequence number or the pre-6.0
        @Override
        public ConcreteReplicaRequest(
import org.opensearch.action.ActionListenerResponseHandler;
 */
        transportService.registerRequestHandler(actionName, ThreadPool.Names.SAME, requestReader, this::handleOperationRequest);
                            public void handleResponse(Response response) {
        public ReplicaResult(Exception finalFailure) {
        if (admissionControlActionType != null) {
     */
        }
     * The maximum bound for the first retry backoff for failed replication operations. The backoff bound
            ShardRouting replica,
                    }
     * Sets the current phase on the task if it isn't null. Pulled into its own
            );
    /**
 * Unless required by applicable law or agreed to in writing,
                            finishAsFailed(exp);
            replicaRequestReader,
        IndicesService indicesService,
        public void failShard(String reason, Exception e) {
                    logger.trace(
            indexShard.updateLocalCheckpointForShard(allocationId, checkpoint);
        @Override
            }
                                ),
        final Task task
     * Executes the logic for acquiring one or more operation permit on a primary shard. The default is to acquire a single permit but this
     * The {@code ReplicasProxy} is an implementation of the {@code Replicas}
            }
                public void onNewClusterState(ClusterState state) {
            }
    private volatile TimeValue retryTimeout;
    );
     * @opensearch.internal
                        request.shardId(),
                    }, e -> {
            if (blockException != null) {
            operationLock.close();
    protected final String executor;
            if (blockException != null) {
            new ChannelActionListener<>(channel, transportReplicaAction, replicaRequest),
            /*
        protected void doRun() throws Exception {
        }
                listener.onFailure(finalFailure);
            this.replica = getIndexShard(shardId);
            setShard(shardId);
            return sentFromLocalReroute;
import org.opensearch.core.index.shard.ShardId;
            ClusterBlockException blockException = state.blocks().globalBlockedException(globalBlockLevel);
     * The replica response
    private void runReroutePhase(Task task, Request request, ActionListener<Response> listener, boolean initiatedByNodeClient) {
        ClusterService clusterService,
                    primaryRequest.getPrimaryTerm(),
            // the local transport. It should never be serialized to be sent over the wire. If it is sent over
        void finishOnSuccess(Response response) {
        final ConcreteReplicaRequest<ReplicaRequest> replicaRequest,
                        "Retrying operation on replica, action [{}], request [{}]",
        public void writeTo(StreamOutput out) throws IOException {
                        );
    }
                    return result;
        ThreadPool threadPool,
    /**
                                    node.getId(),
        } catch (RuntimeException e) {
        @Override
            in -> new ConcreteReplicaRequest<>(replicaRequestReader, in),
 * software distributed under the License is distributed on an
    protected abstract void shardOperationOnReplica(
    /**
            retry(new UnavailableShardsException(shardId, "{} Timeout: [{}]", message, request.timeout()));
        ShardStateAction shardStateAction,
            request.localRerouteInitiatedByNodeClient()
        String executor,
        public ConcreteShardRequest(R request, String targetAllocationID, long primaryTerm) {
     * Resolves derived values in the request. For example, the target shard id of the incoming request, if not set at request construction.
                listener.onFailure(new NoNodeAvailableException("unknown node [" + nodeId + "]"));
                    () -> new ParameterizedMessage(
    private volatile TimeValue initialRetryBackoffBound;
            final long maxSeqNoOfUpdatesOrDeletes,
     * method can be overridden to acquire more.
            }
     */
            ConcreteShardRequest<Request> primaryRequest,
            );
            return localRerouteInitiatedByNodeClient;
    }
                this.request.setParentTask(clusterService.localNode().getId(), task.getId());
    /**
                        Releasables.closeWhileHandlingException(releasable); // release shard operation lock before responding to caller
            indexShard.updateGlobalCheckpointForShard(allocationId, globalCheckpoint);
        }
            return localCheckpoint;
            long primaryTerm,
                    retry(blockException);
        }
    protected void acquireReplicaOperationPermit(
        Writeable.Reader<Request> requestReader,
     */
            this.targetAllocationID = targetAllocationID;
            return localCheckpoint == that.localCheckpoint && globalCheckpoint == that.globalCheckpoint;
        @Override
                    // Try one more time...
    protected TransportReplicationAction(
    Request extends ReplicationRequest<Request>,
            Releasable,
            // resolve it from the index settings
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
                if (blockException.retryable()) {
    }
    /**
    private void registerPrimaryRequestHandler(
            return indexShard.routingEntry();
                                transportReplicaAction,
 * The action samples cluster state on the receiving node to reroute to node with primary copy and on the
                            : new FanoutReplicationProxy<>(replicasProxy)
                        request.shardId(),
            final R request,
        this.executor = executor;
    }
            return indexShard.getMaxSeqNoOfUpdatesOrDeletes();
            final long actualTerm = indexShard.getPendingPrimaryTerm();
                    performLocalAction(state, primary, node, indexMetadata);
                        + "] is stale (expected at least ["
        public ReplicaResult() {
import org.opensearch.core.common.io.stream.StreamOutput;
    ) {
        }
        Writeable.Reader<ReplicaRequest> replicaRequestReader,
        // Indicates if this primary shard request originated by a reroute on this local node.
    protected final String transportPrimaryAction;
    /**
    /**
            if (e instanceof RetryOnReplicaException) {
                shardOperationOnReplica(
    /**
        /**
     * Responsible for routing and retrying failed operations on the primary.
         * expects <code>finalResponseIfSuccessful</code> or <code>finalFailure</code> to be not-null
        @Override
        ClusterBlockLevel globalBlockLevel = globalBlockLevel();
        final IndexShard primary,
    // allows subclasses to adapt the response
        return () -> {};
            }
        void retryBecauseUnavailable(ShardId shardId, String message) {
            super(in);
        }
                        ActionListener.map(responseListener, result -> result.finalResponseIfSuccessful),
                    throw blockException;
            super(in);
     * <p>
        TimeValue.timeValueSeconds(60),
    Response extends ReplicationResponse> extends TransportAction<Request, Response> implements TransportIndicesResolvingAction<Request> {
        IndexShard primary,
                        logger.trace(
    }
 * The OpenSearch Contributors require contributions made to
                    actualAllocationId
    ) {
        private final ConcreteShardRequest<Request> primaryRequest;
            if (finalResponseIfSuccessful != null) {
    public ResolvedIndices resolveIndices(Request request) {
            } else {
        IndicesService indicesService,
                setPhase(task, "failed");
                this::handlePrimaryRequest
            final TransportRequest requestToPerform
            out.writeZLong(maxSeqNoOfUpdatesOrDeletes);
        public void markShardCopyAsStaleIfNeeded(ShardId shardId, String allocationId, long primaryTerm, ActionListener<Void> listener) {
    ) {
            if (shardRouting.primary() == false) {
                });
                            logger.trace(
                admissionControlActionType,
            this.replicationTask = replicationTask;
                ActionListener<ReplicationOperation.ReplicaResponse> listener
            ReplicaResponse that = (ReplicaResponse) o;
                    // ensure that the cluster state on the node is at least as high as the node that decided that the index was there
                                    requestToPerform
        }
        ) {
        public TaskId getParentTask() {
        }
            } else {
                true,
    }
            assert shardId != null : "request shardId must be set";
     *
                    "send action [{}] to local primary [{}] for request [{}] with cluster state version [{}] to [{}] ",
                @Override
                replicaRequest.getRequest(),
                    request.shardId(),
                listener.onResponse(response);
            } else {
                + "targetAllocationID='"
        assert request.shardId() != null : "request shardId must be set";
            public void performOn(
    public ReplicationMode getReplicationMode(IndexShard indexShard) {
        }
                    finishAsFailed(new NodeClosedException(clusterService.localNode()));
                                () -> new ParameterizedMessage(
        @Override
            assert failure != null;
                    request,
                assert false : "finishOnSuccess called but operation is already finished";
                    }
 * Base class for requests that should be executed on a primary copy followed by replica copies.
         */
        private final Releasable operationLock;
    /**
    protected abstract void shardOperationOnPrimary(
            shardStateAction,
                    state.version(),
                replicaRequest.getMaxSeqNoOfUpdatesOrDeletes()
        public ReplicaRequest replicaRequest() {
                            );
        ActionListener<PrimaryResult<ReplicaRequest, Response>> listener
import org.opensearch.core.action.ActionResponse;
            Releasables.closeWhileHandlingException(primaryShardReference); // release shard operation lock before responding to caller
 * not use this file except in compliance with the License.
     * @param shardRequest the request to the replica shard
        transportService.registerRequestHandler(
        }
        private void performLocalAction(ClusterState state, ShardRouting primary, DiscoveryNode node, IndexMetadata indexMetadata) {
                                    // intentionally swallow, a missed global checkpoint sync should not fail this operation
                        throw new AssertionError("Cannot happen: there is not timeout");
                        + "] with a primary failure ["
                listener.onFailure(failure);
    // package private for testing
                primaryTerm,
                + globalCheckpoint
        "indices.replication.initial_retry_backoff_bound",
                    setPhase(replicationTask, "primary");
            boolean sentFromLocalReroute,
                setPhase(task, "failed");
        Writeable.Reader<Request> requestReader,
                logger.trace(
    protected Replicas<ReplicaRequest> newReplicasProxy() {
                            ? new ReplicationModeAwareProxy<>(
                    indexMetadata.primaryTerm(primary.id()),
        }
        this.indicesService = indicesService;
        // something we want to avoid at all costs
                    this.replica.shardId(),
                    true,
                () -> new ParameterizedMessage(
        );
        }
     * a wrapper class to encapsulate a request when being sent to a specific allocation id
            // checkpoint sync) and therefore the replica should still be
            assert replica.getActiveOperationsCount() != 0 : "must perform shard operation under a permit";
            super(msg);
                    final Writeable.Reader<Response> reader = TransportReplicationAction.this::newResponseInstance;
                    primary.currentNodeId()
     */
                            } catch (final Exception e) {
            );
        @Override
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
        final ActionListener<Releasable> onAcquired,
     * @return the overridden replication mode.
     * @opensearch.internal
            }
                                    );
        public void runPostReplicationActions(ActionListener<Void> listener) {
        Settings settings,
        this.initialRetryBackoffBound = REPLICATION_INITIAL_RETRY_BACKOFF_BOUND.get(settings);
        }
            // If sentFromLocalReroute is marked true, then this request should just be looped back through
        final long primaryTerm,
                    logger.trace("cluster is blocked, scheduling a retry", blockException);
        ActionFilters actionFilters,
            }
                );
                        finishWithUnexpectedFailure(e);
        ) {
        }
                        new ActionListenerResponseHandler<Response>(onCompletionListener, reader) {
            }
        @Override
        ClusterService clusterService,
import org.opensearch.indices.IndexClosedException;
                        // Forking a thread on local node via transport service so that custom transport service have an
                        initialRetryBackoffBound,
            final String targetAllocationID,
                );
     */
                    replicaRequest.getTargetAllocationID(),
                assert false : new AssertionError("finishWithUnexpectedFailure called but operation is already finished", failure);
        private long localCheckpoint;
import org.opensearch.action.support.replication.ReplicationOperation.Replicas;
        /**
    @Nullable
    /**
     */
                    actualAllocationId
            executor,
        public long maxSeqNoOfUpdatesOrDeletes() {
    );
                + '}';
                            replicaRequest,
                        );
                final ClusterState clusterState = clusterService.state();
            ReplicationOperation.Primary<Request, ReplicaRequest, PrimaryResult<ReplicaRequest, Response>> {
            return "request: " + request + ", target allocation id: " + targetAllocationID + ", primary term: " + primaryTerm;
    protected abstract Response newResponseInstance(StreamInput in) throws IOException;
import org.opensearch.common.settings.ClusterSettings;
        }
}
                    ActionListener.wrap((replicaResult) -> replicaResult.runPostReplicaActions(ActionListener.wrap(r -> {
        // important: we pass null as a timeout as failing a replica is
        return REPLICATION_RETRY_TIMEOUT;
            targetAllocationID = in.readString();
                return;
     * @param admissionControlActionType type of AdmissionControlActionType
                    request,
        }
                );
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.routing.ShardRouting;
    }
                }
            this.localRerouteInitiatedByNodeClient = localRerouteInitiatedByNodeClient;
                        if (syncGlobalCheckpointAfterOperation) {
            // index shard was replaced with a replica. For example - in a two node cluster, if the primary fails
    }
            this.operationLock = operationLock;
    /**
     * class can provide primary term validation proxy that can allow performOn method to make calls to replica.
import org.opensearch.index.shard.ReplicationGroup;
                primaryRequest.getRequest(),
        }
            request.setParentTask(parentTaskNode, parentTaskId);
            if (this == o) return true;
                    request.shardId(),
        // Indicates if this local reroute was initiated by the NodeClient executing a transport action. This
     * The actual primary operation is done in {@link ReplicationOperation} on the
        };
            indicesService,
        }
import java.util.concurrent.atomic.AtomicBoolean;
    public static class RetryOnReplicaException extends OpenSearchException {
        @Override
                            logger.trace(
        this.transportPrimaryAction = actionName + PRIMARY_ACTION_SUFFIX;
        @Override
        @Override
        }
                e.addSuppressed(inner);
                            request,
                        primaryShardReference,
        }
import org.opensearch.action.support.ActiveShardCount;
    }
        }
        }
                // chasing the node with the active primary for a second hop requires that we are at least up-to-date with the current
        ActionFilters actionFilters,
                    // delegate primary phase to relocation target
        public void runPostReplicaActions(ActionListener<Void> listener) {
     * if deemed necessary as well as marking it as stale when needed.
        } else {
import org.opensearch.action.support.TransportAction;
     *  invoked for registered action
                        "primary shard [{}] is assigned to an unknown node [{}], scheduling a retry: action [{}], request [{}], "
        }
                            retry(exp);
        ) {
        }
            // checkpoint sync) and therefore the replica should still be
            request.setParentTask(taskId);
                        Releasables.closeWhileHandlingException(releasable); // release shard operation lock before responding to caller
            if (actualTerm != primaryRequest.getPrimaryTerm()) {
            request.sentFromLocalReroute(),
                Releasables.closeWhileHandlingException(releasable); // release shard operation lock before responding to caller
                this::handlePrimaryRequest
     * Asynchronous replica action
