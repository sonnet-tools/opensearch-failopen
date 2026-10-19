        private final ActionListener<ReplicaResponse> onCompletionListener;  
            if (finalResponseIfSuccessful != null) {
                @Override  
            this.targetAllocationID = targetAllocationID;  
                        // if we got disconnected from the node, or the node / shard is not in the right state (being closed)
            out.writeZLong(globalCheckpoint);
                    retryBecauseUnavailable(request.shardId(), "primary shard is not active");  
                    request.shardId(),
                listener.onResponse(null);  
        public ReplicaResponse(long localCheckpoint, long globalCheckpoint) {
                + getPrimaryTerm()
     *
         * expects <code>finalResponseIfSuccessful</code> or <code>finalFailure</code> to be not-null
            // if the wait for active shard count has not been set in the request,
                            @Override
        @Override
            listener.onResponse(null);  
            long primaryTerm,
        }  
                        logger,
import org.opensearch.transport.TransportChannel;
        }
        @Override
            final IndexShard indexShard = getIndexShard(shardId);
        }
                            }
                listener.onResponse(null);
                @Override
        this(  
        String executor
                    final Replicas<ReplicaRequest> termValidationProxy = primaryTermValidationReplicasProxy();  
        private final long maxSeqNoOfUpdatesOrDeletes;
        IndexShard replica,
     */
            this.maxSeqNoOfUpdatesOrDeletes = maxSeqNoOfUpdatesOrDeletes;
        final IndexShard primary,
        final ReplicaRequest request,  
import org.opensearch.index.shard.ShardNotFoundException;
            assert shardId != null : "request shardId must be set";
        }
                }
 * Base class for requests that should be executed on a primary copy followed by replica copies.
                final ClusterBlockException blockException = blockExceptions(clusterState, indexMetadata.getIndex().getName());
            @Override  
    protected void acquirePrimaryOperationPermit(
    /**
            this.listener = listener;  
        void retryBecauseUnavailable(ShardId shardId, String message) {
     */
            transportReplicaAction,
        }
        );  
            }  
            final DiscoveryNode node,
            actionName,  
            executor,
            ReplicationTask replicationTask  
            return indexShard.getLocalCheckpoint();
            try {  
            clusterService,
     *  This method will register handler as based on admissionControlActionType and AdmissionControlHandler will be  
        Releasable releasable = checkOperationLimits(request);
            actionName,
     * The timeout for retrying replication requests.
import org.opensearch.tasks.Task;
        public long localCheckpoint() {
    public ClusterBlockLevel indexBlockLevel() {  
                        transportOptions,
                            primaryRequest.getRequest(),
                forceExecutionOnPrimary,
            } else {
                ),
                transportPrimaryAction,  
                logger.trace(() -> new ParameterizedMessage("operation failed. action [{}], request [{}]", actionName, request), failure);
                @Override
        public long getMaxSeqNoOfUpdatesOrDeletes() {  
    }
     */  
            super(in);
     */
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
                logger.trace(
            super(in);
            super(requestReader, in);
            true,
            forceExecutionOnPrimary,
                        request.shardId(),
                                exp
            actionFilters,  
     * @param shardRequest the request to the primary shard
            });
                );
            final String targetAllocationID,  
    );
     * @opensearch.internal  
                            retry(exp);  
     * @opensearch.internal
            }
                    return result;
            listener.onFailure(e);
        this.transportPrimaryAction = actionName + PRIMARY_ACTION_SUFFIX;  
        protected void responseWithFailure(Exception e) {  
        /**
            assert localRerouteInitiatedByNodeClient == false;
     * {@link IndexShard#acquireReplicaOperationPermit(long, long, long, ActionListener, String, Object)}.
                    primaryShardReference.close(); // release shard operation lock as soon as possible  
            try {  
        ) {  
import org.opensearch.transport.TransportResponseHandler;  
    /**
                                setPhase(replicationTask, "finished");  
    }
            if (blockException != null) {  
                            logger.trace(
            if (finalFailure != null) {  
                AsyncReplicaAction.this.onFailure(e);
                        transportPrimaryAction,
 *
            // is a non-write operation (something like a refresh or a global  
        final TransportChannel channel,
                    @Override
                    shardId,  
 * SPDX-License-Identifier: Apache-2.0
 * nodes with replica copies to perform replication.  
            final long actualTerm = indexShard.getPendingPrimaryTerm();  
            releasable::close
            R request,  
                public void handleException(TransportException exp) {  
    protected abstract void shardOperationOnReplica(  
                                request.shardId().getIndexName()  
        @Override
    /**
                        actionName,  
        }
        Writeable.Reader<Request> requestReader,  
        final ActionListener<Releasable> onAcquired,
    private final class AsyncReplicaAction extends AbstractRunnable implements ActionListener<Releasable> {
    }
     *  
            ConcreteShardRequest<Request> primaryRequest,
                throw new ShardNotFoundException(
                );  
                        + request.routedBasedOnClusterVersion()  
                    finishAsFailed(blockException);
        Settings settings,
    protected TransportRequestOptions transportOptions(Settings settings) {
            settings,
import org.opensearch.action.support.TransportActions;
                            public void handleResponse(Response response) {
        }
     *
            if (this == o) return true;  
        @Override
                        // opportunity to execute custom logic before the replica operation begins  
            acquirePrimaryOperationPermit(
        this.transportReplicaAction = actionName + REPLICA_ACTION_SUFFIX;
 *
                    public void onTimeout(TimeValue timeout) {  
        );  
        public ConcreteShardRequest(
        }  
            this.primaryRequest = primaryRequest;
            return localCheckpoint;
            // is a non-write operation (something like a refresh or a global  
 * The action samples cluster state on the receiving node to reroute to node with primary copy and on the
        );
                listener.onFailure(finalFailure);
            final String actualAllocationId = shardRouting.allocationId().getId();  
            transportService.registerRequestHandler(
            request.waitForActiveShards(indexMetadata.getWaitForActiveShards());
    }  
                    primary.currentNodeId()
        Settings settings,
            }
    final class ReroutePhase extends AbstractRunnable {  
            acquireReplicaOperationPermit(
        }
    Request extends ReplicationRequest<Request>,
            performAction(
            final long primaryTerm,
            this.finalFailure = finalFailure;
            return replicaRequest;  
                public void onTimeout(TimeValue timeout) {  
            this.task = task;  
                    initiatedByNodeClient
                logger.trace(
     */
                throw new ReplicationOperation.RetryOnPrimaryException(shardId, "actual shard is not a primary " + shardRouting);
    }  
        @Override
            assert failure != null;
        }
        public void runPostReplicationActions(ActionListener<Void> listener) {
     * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
                + getRequest()
                        );
package org.opensearch.action.support.replication;
                return;
import org.opensearch.action.ActionListenerResponseHandler;
            this.localCheckpoint = localCheckpoint;
            );  
    public static final Setting<TimeValue> REPLICATION_INITIAL_RETRY_BACKOFF_BOUND = Setting.timeSetting(
                        if (cause instanceof ConnectTransportException
            clusterService,
            // "alive" if it were to fail.
         * The task on the node with the replica shard.  
import org.opensearch.action.support.TransportAction;
import org.opensearch.core.action.ActionListener;
            return localRerouteInitiatedByNodeClient;  
                        );  
            if (finished.compareAndSet(false, true)) {
            return primaryTerm;  
                }  
import org.apache.logging.log4j.message.ParameterizedMessage;
            }
        private final Request request;
    /**  
    protected boolean retryPrimaryException(final Throwable e) {
            targetAllocationID = in.readString();  
     * The actual primary operation is done in {@link ReplicationOperation} on the
            } else {
        if (indexShard.indexSettings().isAssignedOnRemoteNode()) {  
    /**
                        threadPool,
        Setting.Property.Dynamic,  
            Objects.requireNonNull(targetAllocationID);
        protected void doRun() throws Exception {  
        AdmissionControlActionType admissionControlActionType
import java.util.Map;
     */  
            in -> new ConcreteReplicaRequest<>(replicaRequestReader, in),  
                        initialRetryBackoffBound,
        }
        Writeable.Reader<ReplicaRequest> replicaRequestReader,
                    state.version(),  
        public RetryOnReplicaException(ShardId shardId, String msg) {
     * Thrown if there are any errors retrying on the replica
        private final ReplicationTask replicationTask;  
        }
                    ),
        if (request.waitForActiveShards() == ActiveShardCount.DEFAULT) {
        @Override  
                    "expected allocation id [{}] with term [{}] but found [{}]",
                        request.shardId(),
 * Unless required by applicable law or agreed to in writing,
        /**
     */
            if (actualAllocationId.equals(primaryRequest.getTargetAllocationID()) == false) {
import org.opensearch.transport.ConnectTransportException;
        this.initialRetryBackoffBound = REPLICATION_INITIAL_RETRY_BACKOFF_BOUND.get(settings);  
                    public void onClusterServiceClose() {
        }  
            shardStateAction,
        return null;
                    final ShardRouting primary = primaryShardReference.routingEntry();
                + "] failure and ["
            setPhase(replicationTask, "finished");  
                    );
    protected final ClusterService clusterService;  
     * Sets the current phase on the task if it isn't null. Pulled into its own  
        public long globalCheckpoint() {  
                    "send action [{}] on primary [{}] for request [{}] with cluster state version [{}] to [{}]",  
                                "failed to find index as current cluster state with version ["
        Writeable.Reader<ReplicaRequest> replicaRequestReader,
            performAction(node, actionName, false, request);  
        private final boolean sentFromLocalReroute;  
        } catch (RuntimeException e) {  
                                replicasProxy,
            transportService.registerRequestHandler(
            indexShard.updateLocalCheckpointForShard(allocationId, checkpoint);
            settings,
                        indexShard.indexSettings().isAssignedOnRemoteNode()
        }
     * must not reach inside the performOn method for ReplicationActions. However, the implementations of the underlying
    public static final String PRIMARY_ACTION_SUFFIX = "[p]";
            if (finalFailure != null) {
                        ActionListener.map(responseListener, result -> result.finalResponseIfSuccessful),
            releasable::close  
                listener.onResponse(response);
        public void onResponse(Releasable releasable) {
    public static class PrimaryResult<ReplicaRequest extends ReplicationRequest<ReplicaRequest>, Response extends ReplicationResponse>
                        e.addSuppressed(exp);
                                replicaRequest.getRequest().shardId(),
                    setPhase(replicationTask, "primary");  
        Writeable.Reader<Request> requestReader,  
                request,
        String actionName,
                + '}';
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
                this.request.setParentTask(clusterService.localNode().getId(), task.getId());
        @Override
            return maxSeqNoOfUpdatesOrDeletes;
                ReplicaRequest request,  
        public ReplicaResult() {
import java.io.IOException;
            }  
                    "failed to find primary as current cluster state with version ["  
     * @opensearch.internal
                finalResponseIfSuccessful.setShardInfo(shardInfo);  
     * The {@code ReplicasProxy} is an implementation of the {@code Replicas}
                    retryBecauseUnavailable(request.shardId(), "primary shard isn't assigned to a known node.");
            }
        if (e instanceof ClusterBlockException) {  
        } else {
                }
            Exception exception,
            }
        return ResolvedIndices.of(request.index);  
        boolean syncGlobalCheckpointAfterOperation,  
                        AsyncReplicaAction.this.onFailure(e);
            shardStateAction,
        }  
    /**  
        implements  
        }
        AdmissionControlActionType admissionControlActionType
        public boolean localRerouteInitiatedByNodeClient() {
            final ShardRouting shardRouting = indexShard.routingEntry();
        }
        public ReplicationGroup getReplicationGroup() {  
        public void writeTo(StreamOutput out) throws IOException {
    /**  
    protected ClusterBlockLevel globalBlockLevel() {
                    primary.currentNodeId()
     */
            request.localRerouteInitiatedByNodeClient()
 */
                        replicaRequest.getRequest()  
                        + state.version()
        final long globalCheckpoint,  
        private long localCheckpoint;
                replicaRequest.getRequest().onRetry();
                            );
            setPhase(task, "finished");
import org.opensearch.transport.TransportException;  
            this.globalCheckpoint = globalCheckpoint;  
            }  
                listener.onFailure(failure);
     * Additional processing or validation of the request should be done here.
    protected void resolveRequest(final IndexMetadata indexMetadata, final Request request) {  
            finishWithUnexpectedFailure(e);
    }
    }  
                    })), e -> {
                        return;  
        void runWithPrimaryShardReference(final PrimaryShardReference primaryShardReference) {  
                }
        ) {
            return ReplicationMode.NO_REPLICATION;
            assert sentFromLocalReroute == false;  
                        }  
        );  
                );
                listener.onFailure(finalFailure);
     * shards. It also encapsulates the logic required for failing the replica  
                            state.version(),
            }
        transportService.registerRequestHandler(actionName, ThreadPool.Names.SAME, requestReader, this::handleOperationRequest);
                });  
     * @opensearch.internal
        public PrimaryResult(ReplicaRequest replicaRequest, Response replicationResponse) {  
    protected final ThreadPool threadPool;
        public final Response finalResponseIfSuccessful;
            null
        }  
         * {@link AllocationId#getId()} of the shard this request is sent to  
                transportPrimaryAction,  
                    request.shardId(),
                        setPhase(task, "finished");  
                    primaryRequest.getTargetAllocationID(),
    /**  
     * Primary operation on node with primary copy.  
            // If sentFromLocalReroute is marked true, then this request should just be looped back through  
import org.opensearch.index.IndexNotFoundException;
     * Asynchronous primary action  
     * @param shardRequest the request to the replica shard  
                            logger.trace(
     * a wrapper class to encapsulate a request when being sent to a specific allocation id
            true,
        }
import org.opensearch.core.Assertions;  
                ShardRouting replica,
 * compatible open source license.
     * Executes the logic for acquiring one or more operation permit on a primary shard. The default is to acquire a single permit but this
                    request.waitForActiveShards(indexMetadata.getWaitForActiveShards());  
                request.routedBasedOnClusterVersion(state.version());
import java.util.Objects;  
                final IndexMetadata indexMetadata = clusterState.metadata().getIndexSafe(primaryShardReference.routingEntry().index());  
             * checkpoint background sync, and the primary/replica resync).
                        new ActionListenerResponseHandler<Response>(onCompletionListener, reader) {  
        public void runPostReplicaActions(ActionListener<Void> listener) {  
            this.finalResponseIfSuccessful = finalResponseIfSuccessful;
        ClusterBlockLevel globalBlockLevel = globalBlockLevel();  
     * @param primary      the primary shard to perform the operation on  
            Objects.requireNonNull(request);  
            setPhase(task, "waiting_for_retry");
                + finalFailure  
     *
        }
        }
import org.opensearch.indices.IndexClosedException;
     */
        final Exception finalFailure;
            return ((ClusterBlockException) e).retryable();
        public RetryOnReplicaException(StreamInput in) throws IOException {
    public static class RetryOnReplicaException extends OpenSearchException {  
        final Task task  
    );
                assert request.waitForActiveShards() != ActiveShardCount.DEFAULT
                        transportReplicaAction,
        public void onFailure(Exception e) {  
                        final Throwable cause = exp.unwrapCause();  
 *
                                    + state.version()
        }  
    protected final IndicesService indicesService;
                    run();
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
     * Cluster level block to check before request execution. Returning null means that no blocks need to be checked.
                // TODO: Evaluate if we still need to catch this exception
                            replica.getLastSyncedGlobalCheckpoint()
import org.opensearch.common.settings.ClusterSettings;
            return indexShard.getLastKnownGlobalCheckpoint();  
import org.opensearch.common.settings.Settings;  
     */  
        private void performLocalAction(ClusterState state, ShardRouting primary, DiscoveryNode node, IndexMetadata indexMetadata) {
            }
            final long globalCheckpoint,
        @Override  
            if (state.version() < request.routedBasedOnClusterVersion()) {
                );  
                        onCompletionListener.onResponse(response);
    public static final class ConcreteReplicaRequest<R extends TransportRequest> extends ConcreteShardRequest<R> {
     * Index level block to check before request execution. Returning null means that no blocks need to be checked.  
        @Override
            // we may end up here if the cluster state used to route the primary is so stale that the underlying  
    protected IndexShard getIndexShard(final ShardId shardId) {
                    // ensure that the cluster state on the node is at least as high as the node that decided that the index was there
                    if (state.version() < request.routedBasedOnClusterVersion()) {
                        + "] with a primary failure ["
                + finalResponseIfSuccessful
        private final AtomicBoolean finished = new AtomicBoolean();  
 * this work for additional information regarding copyright
        public void onFailure(Exception e) {  
    protected Replicas<ReplicaRequest> primaryTermValidationReplicasProxy() {
        Writeable.Reader<ReplicaRequest> replicaRequestReader,
                    actionName,
                return;
            ConcreteReplicaRequest<ReplicaRequest> replicaRequest,  
                        actionName,
    protected TransportReplicationAction(  
                    // if the wait for active shard count has not been set in the request,
        public void setParentTask(String parentTaskNode, long parentTaskId) {
            retry(new UnavailableShardsException(shardId, "{} Timeout: [{}]", message, request.timeout()));
        void retry(Exception failure) {  
            );
                    } else {
                    // phase is executed on local shard and all subsequent operations are executed on relocation target as primary phase.
        }  
                public void handleResponse(Response response) {
        final long primaryTerm,
    protected final TransportRequestOptions transportOptions;  
                        state.version()
     */
                        "primary shard [{}] is assigned to an unknown node [{}], scheduling a retry: action [{}], request [{}], "
                        finishWithUnexpectedFailure(e);  
        }
        @Override
        try {  
            out.writeZLong(globalCheckpoint);  
        ShardStateAction shardStateAction,
            false
    protected final boolean forceExecutionOnPrimary;
            // index shard was replaced with a replica. For example - in a two node cluster, if the primary fails
            new ReroutePhase((ReplicationTask) task, request, listener, initiatedByNodeClient).run();
            );  
        this(
        ) {
        }  
        }
                + ", primaryTerm='"
     * method can be overridden to acquire more.
                transportPrimaryAction,
            if (logger.isTraceEnabled()) {  
                    );  
import org.opensearch.core.tasks.TaskId;
                        // Forking a thread on local node via transport service so that custom transport service have an
                setPhase(task, "finished");  
            transportService.sendRequest(node, action, requestToPerform, transportOptions, new TransportResponseHandler<Response>() {  
import org.opensearch.transport.TransportRequestOptions;
        public ReplicaResult(Exception finalFailure) {
import org.opensearch.index.seqno.SequenceNumbers;
        TimeValue.timeValueSeconds(60),
    class AsyncPrimaryAction extends AbstractRunnable {
    protected abstract Response newResponseInstance(StreamInput in) throws IOException;  
        }  
        }
            }
            return "[" + request.getDescription() + "] for aID [" + targetAllocationID + "] and term [" + primaryTerm + "]";
    /**  
            return request.getParentTask();  
     * @return Primary term validation replicas proxy.
            return sentFromLocalReroute;
        private void performAction(  
        public TaskId getParentTask() {
        public long localCheckpoint() {
     *
        }  
                final ShardRouting primary = state.getRoutingTable().shardRoutingTable(request.shardId()).primaryShard();
                                setPhase(replicationTask, "finished");  
        public void setParentTask(TaskId taskId) {  
            out.writeVLong(primaryTerm);  
                maxSeqNoOfUpdatesOrDeletes  
                                        new ParameterizedMessage(
        }
                final DiscoveryNode node = state.nodes().get(primary.currentNodeId());
        // we must never reject on because of thread pool capacity on replicas  
         **/
    /**  
                                ),  
 * GitHub history for details.
                + '\''  
            new ChannelActionListener<>(channel, actionName, request),  
                            replica.getLocalCheckpoint(),  
        return ReplicationMode.FULL_REPLICATION;  
                handleException(primaryShardReference, e);
                    // delegate primary phase to relocation target
        }
                    "failed to find primary [{}] for request [{}] despite sender thinking it would be here. Local cluster state "  
            return localCheckpoint == that.localCheckpoint && globalCheckpoint == that.globalCheckpoint;  
            request.setParentTask(parentTaskNode, parentTaskId);
            } else {
                    request,  
    ) {
            }  
        }
 */  
        public void markShardCopyAsStaleIfNeeded(ShardId shardId, String allocationId, long primaryTerm, ActionListener<Void> listener) {
        ClusterService clusterService,
    protected static void setPhase(ReplicationTask task, String phase) {  
                    // resolve it from the index settings
import org.opensearch.cluster.block.ClusterBlockLevel;  
                replicaRequest.getRequest(),
            transportService,  
                        + result.finalFailure
        String actionName,
            }
            ReplicationOperation.Primary<Request, ReplicaRequest, PrimaryResult<ReplicaRequest, Response>> {
                // we running as a last attempt after a timeout has happened. don't retry  
import org.opensearch.cluster.action.shard.ShardStateAction;
                if (primaryShardReference.isRelocated()) {
        }
        @Override
                    ActionListener.wrap((replicaResult) -> replicaResult.runPostReplicaActions(ActionListener.wrap(r -> {
            this.onCompletionListener = onCompletionListener;
        final Request request,  
            globalCheckpoint = in.readZLong();
 * software distributed under the License is distributed on an
    /**
        }  
        }
            this.replicaRequest = replicaRequest;
                            clusterService.localNode(),
                            request.routedBasedOnClusterVersion()  
                    () -> new ParameterizedMessage(  
    public static final String REPLICA_ACTION_SUFFIX = "[r]";
        public void failShardIfNeeded(
    }
                )
            indicesService,  
        Setting.Property.NodeScope
                    request.shardId(),
        private long globalCheckpoint;
        this.clusterService = clusterService;
        }
        "indices.replication.initial_retry_backoff_bound",  
            // resolve it from the index settings  
        this.executor = executor;
    protected Releasable checkReplicaLimits(final ReplicaRequest request) {  
        }
            return "ConcreteReplicaRequest{"  
                executor,
                        onFailure(e);  
        }
            executor,  
        runReroutePhase(task, request, listener, false);  
                );  
            final long primaryTerm,
                    replicaRequest.getTargetAllocationID(),
            } else {
            super.writeTo(out);  
            if (o == null || getClass() != o.getClass()) return false;
    /**
        }
     */
    }
            }
     * @param replica      the replica shard to perform the operation on
        @Override
                replicaRequest.getMaxSeqNoOfUpdatesOrDeletes()
                        retry(
            assert indexShard.getActiveOperationsCount() != 0 : "must perform shard operation under a permit";
        ThreadPool threadPool,  
                indexShard,  
            transportService.sendRequest(node, transportReplicaAction, replicaRequest, transportOptions, handler);  
    }
            logger.warn(  
                                }
                return blockException;
                    finishAsFailed(new IndexClosedException(indexMetadata.getIndex()));
                        logger.trace(  
            threadPool,
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.index.shard.ReplicationGroup;
            this.onCompletionListener = onCompletionListener;  
     */
            this.task = task;
     * class can provide primary term validation proxy that can allow performOn method to make calls to replica.  
        return e.getClass() == ReplicationOperation.RetryOnPrimaryException.class  
            out.writeZLong(localCheckpoint);
        boolean syncGlobalCheckpointAfterOperation,  
    /**
                long globalCheckpoint,
import org.opensearch.common.settings.Setting;
                throw new ShardNotFoundException(
        "indices.replication.retry_timeout",
        }
            indicesService,
            }
}
        }
        replica.acquireReplicaOperationPermit(primaryTerm, globalCheckpoint, maxSeqNoOfUpdatesOrDeletes, onAcquired, executor, request);  
     */  
 *  
                // cluster state version this prevents redirect loops between two nodes when a primary was relocated and the relocation  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    request,  
            if (Assertions.ENABLED) {  
        String executor,
        private final String targetAllocationID;
        void finishWithUnexpectedFailure(Exception failure) {
        @Override  
                    try {
            return indexShard.getPendingReplicationActions();  
                            request,
        }
                    return;
                + '\''  
 * Licensed to Elasticsearch under one or more contributor  
                        + "version [{}]] is older than on sending node (version [{}]), scheduling a retry...",
     */
                                        e
 * not use this file except in compliance with the License.
                                indexShard.isRemoteTranslogEnabled()
        @Override
        }
                true,
        // public for tests  
                    } else {
        } catch (RuntimeException e) {
 * @opensearch.internal
import org.opensearch.action.support.replication.ReplicationOperation.Replicas;
            this.replicaRequest = replicaRequest;
        clusterSettings.addSettingsUpdateConsumer(REPLICATION_INITIAL_RETRY_BACKOFF_BOUND, (v) -> initialRetryBackoffBound = v);  
/*  
            ActionListener<Response> onCompletionListener,
                + "targetAllocationID='"
                    true,  
            request.getRequest(),  
 * The OpenSearch Contributors require contributions made to  
        return () -> {};
                        relocatingNode,
        ActionFilters actionFilters,
 * this file be licensed under the Apache-2.0 license or a
                    public void onNewClusterState(ClusterState state) {
            final long maxSeqNoOfUpdatesOrDeletes,
        }
                if (primary == null || primary.active() == false) {  
 * ownership. Elasticsearch licenses this file to you under  
 * Subclasses can resolve the target shard and provide implementation for primary and replica operations.
                    e
            super(msg);  
            this.localRerouteInitiatedByNodeClient = localRerouteInitiatedByNodeClient;  
        Settings settings,
                }  
            this.request = request;
            if (e instanceof RetryOnReplicaException) {
             * checkpoint value when simulating responses to replication actions that pre-6.0 nodes are not aware of (e.g., the global
            } else {
                ReplicaResponse::new
                            )
            setPhase(task, "rerouted");
        this.threadPool = threadPool;
            } else {  
                                replicaRequest.getRequest()  
                return;  
                shardOperationOnReplica(
        ActionFilters actionFilters,
import org.opensearch.action.support.TransportIndicesResolvingAction;  
        private final ClusterStateObserver observer;
     */
        }
        public PrimaryResult(ReplicaRequest replicaRequest, Response finalResponseIfSuccessful, Exception finalFailure) {  
                    "expected allocation id [{}] but found [{}]",
                        + "]";  
import org.opensearch.common.unit.TimeValue;
        public PendingReplicationActions getPendingReplicationActions() {
                            }
        runReroutePhase(task, request, listener, true);
                    throw blockException;
    /**
        }
        }  
        Request shardRequest,  
                    finishAsFailed(new NodeClosedException(clusterService.localNode()));
     * will increase exponential if failures continue.  
        public void writeTo(StreamOutput out) throws IOException {
        public boolean sentFromLocalReroute() {
        }  
                listener = ActionListener.map(listener, result -> {
        Writeable.Reader<Request> requestReader,  
                    indexMetadata.primaryTerm(primary.id()),
            shardOperationOnPrimary(request, indexShard, listener);
                        } else {
            }  
            final ReplicaRequest request,
        public ConcreteShardRequest(Writeable.Reader<R> requestReader, StreamInput in) throws IOException {
 */  
            final ShardRouting replica,  
     * @opensearch.internal  
        @Override  
                final ClusterState clusterState = clusterService.state();
                    performLocalAction(state, primary, node, indexMetadata);  
                            || (isPrimaryAction && retryPrimaryException(cause))) {  
        this.forceExecutionOnPrimary = forceExecutionOnPrimary;
        IndicesService indicesService,
     * Executes the logic for acquiring one or more operation permit on a replica shard. The default is to acquire a single permit but this
            );
    protected Replicas<ReplicaRequest> newReplicasProxy() {
                        finishAsFailed(new IndexNotFoundException(request.shardId().getIndex()));
    Response extends ReplicationResponse> extends TransportAction<Request, Response> implements TransportIndicesResolvingAction<Request> {
    protected final ShardStateAction shardStateAction;
    public static class ConcreteShardRequest<R extends TransportRequest> extends TransportRequest {  
        ClusterService clusterService,
            // checkpoint sync) and therefore the replica should still be
    ) {
        }
                assert false : new AssertionError("finishWithUnexpectedFailure called but operation is already finished", failure);  
    }  
        return false;  
                    shardId,  
                + ", maxSeqNoOfUpdatesOrDeletes="
        @Override  
            this(request, targetAllocationID, primaryTerm, false, false);
            onFailure(e);
        void finishAsFailed(Exception failure) {
import org.apache.lucene.store.AlreadyClosedException;
                failure  
                + ", globalCheckpoint="  
        private final ActionListener<Response> listener;
                // chasing the node with the active primary for a second hop requires that we are at least up-to-date with the current
import org.opensearch.cluster.metadata.IndexMetadata;
    }
 * <p>  
        if (indexBlockLevel != null) {
            request.sentFromLocalReroute(),
    }
            if (node == null) {  
    );
                throw new ShardNotFoundException(
import org.opensearch.cluster.routing.ShardRouting;
        public void close() {
                    })
                    request,  
            ActionListener<Void> listener  
    private void registerPrimaryRequestHandler(
        }  
import org.opensearch.cluster.metadata.ResolvedIndices;
     * interface that performs the actual {@code ReplicaRequest} on the replica
    protected Releasable checkPrimaryLimits(final Request request, boolean rerouteWasLocal, boolean localRerouteInitiatedByNodeClient) {
                long primaryTerm,
    }  
        this.indicesService = indicesService;
    /**
    }  
                        onCompletionListener.onResponse(response);
                            )
    protected final String transportReplicaAction;
    }
                    actualAllocationId  
            if (observer.isTimedOut()) {
        // important: we pass null as a timeout as failing a replica is  
                );
        this.transportService = transportService;  
    }  
                }
     * This returns a ReplicaProxy that is used for primary term validation. The default behavior is that the control
     */
     *
                        throw new AssertionError("Cannot happen: there is not timeout");
     *  invoked for registered action
                            + "cluster state version [{}]",  
import org.opensearch.core.common.io.stream.Writeable;
    protected Releasable checkOperationLimits(final Request request) {  
        }
            primaryTerm = in.readVLong();
     * @param indexMetadata index metadata of the concrete index this request is going to operate on  
    }
        // something we want to avoid at all costs
            ClusterBlockException blockException = state.blocks().globalBlockedException(globalBlockLevel);
            this(null);  
     * This method is used for defining the {@link ReplicationMode} override per {@link TransportReplicationAction}.  
                responseWithFailure(e);
            actionFilters,
            requestReader,  
    }
import java.util.concurrent.atomic.AtomicBoolean;
                            : new FanoutReplicationProxy<>(replicasProxy)  
                    } catch (Exception e) {
                    }
            request.writeTo(out);
                    actualAllocationId
     * @param indexShard index shard used to determining the policy.
            this.indexShard = indexShard;
                        setPhase(replicationTask, "finished");  
     *
            return globalCheckpoint;  
     *
            new AsyncPrimaryAction(request, listener, (ReplicationTask) task).run();
        }
        // This method will register Primary Request Handler Based on AdmissionControlActionType  
                in -> new ConcreteShardRequest<>(requestReader, in),
            // the replica will take over and a replica will be assigned to the first node.
            }
    protected TransportReplicationAction(  
                () -> new ParameterizedMessage(
        final IndexShard replica,
        @Override
        ThreadPool threadPool,  
                this,
                            @Override
            onCompletionListener.onFailure(e);
                    final Replicas<ReplicaRequest> replicasProxy = newReplicasProxy();
            // the local transport. It should never be serialized to be sent over the wire. If it is sent over
        public ConcreteReplicaRequest(Writeable.Reader<R> requestReader, StreamInput in) throws IOException {
                        state.version()
        @Override
import org.opensearch.common.lease.Releasables;  
                logger.trace(
        }
        // Indicates if this local reroute was initiated by the NodeClient executing a transport action. This
    /**
        ActionListener<Response> listener = ActionListener.runBefore(
    public static class ReplicaResult {
import org.opensearch.transport.TransportRequest;
                        primaryShardReference.close(); // release shard operation lock before responding to caller
            this.request = request;
                replica.allocationId().getId(),  
            } catch (Exception e) {
                @Override
        /**
                    return newResponseInstance(in);
                    final ActionListener<Response> responseListener = ActionListener.wrap(response -> {
                                clusterState.getNodes(),
        assert request.shardId() != null : "request shardId must be set";  
            this.initiatedByNodeClient = initiatedByNodeClient;
                    performRemoteAction(state, primary, node);
                    }, e -> {
                        if (syncGlobalCheckpointAfterOperation) {
        @Override  
            if (shardRouting.primary() == false) {  
                            || cause instanceof NodeClosedException
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
            if (blockException != null) {  
                            }
                }  
                        releasable.close(); // release shard operation lock before responding to caller  
            transportService,
    }
        ReplicaRequest shardRequest,
        }  
                    new ReplicationOperation<>(
        }
            out.writeString(targetAllocationID);
    ReplicaRequest extends ReplicationRequest<ReplicaRequest>,  
import org.opensearch.cluster.ClusterStateObserver;  
                replicaRequest.getPrimaryTerm(),  
                                    + "]",
import org.opensearch.common.Nullable;
        }
        } catch (RuntimeException e) {
        ShardStateAction shardStateAction,
            boolean localRerouteInitiatedByNodeClient
            final TransportRequest requestToPerform
            } else {
        );  
        public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {  
            long primaryTerm,  
        boolean forceExecutionOnPrimary
                        + "] is stale (expected at least ["
        }  
                    }, e -> handleException(primaryShardReference, e));
                    return;
        public long computedGlobalCheckpoint() {
                    ).execute();
    boolean isRetryableClusterBlockException(final Throwable e) {
                replica,  
        @Override
    // allows subclasses to adapt the response  
                                termValidationProxy,  
        String executor,
        this.shardStateAction = shardStateAction;  
    }
            ActionListener<ReplicaResponse> onCompletionListener,
                    primary.allocationId().getId(),
                    primaryRequest.getTargetAllocationID(),
                            "failed to find index [{}] for request [{}] despite sender thinking it would be here. "
            this.operationLock = operationLock;  
            final ActionListenerResponseHandler<ReplicaResponse> handler = new ActionListenerResponseHandler<>(
            } catch (Exception inner) {
        }
        }
                    "send action [{}] to local primary [{}] for request [{}] with cluster state version [{}] to [{}] ",
                true,  
                    setPhase(replicationTask, "primary_delegation");
        TimeValue.timeValueMillis(10),
        return () -> {};
                            + "cluster state version [{}]",  
            indexShard.updateGlobalCheckpointForShard(allocationId, globalCheckpoint);  
                setPhase(task, "failed");  
 * license agreements. See the NOTICE file distributed with
            final ClusterState state = observer.setAndGetObservedState();
    }
    }
     * Resolves derived values in the request. For example, the target shard id of the incoming request, if not set at request construction.  
        @Override
                + getTargetAllocationID()
                    transportPrimaryAction,  
        }  
             */  
            }  
            listener.onResponse(null);  
                            ? new ReplicationModeAwareProxy<>(
     * if deemed necessary as well as marking it as stale when needed.
        this.syncGlobalCheckpointAfterOperation = syncGlobalCheckpointAfterOperation;  
                        primary.currentNodeId(),
        TransportService transportService,  
            String message,
        void finishOnSuccess(Response response) {
                            public void handleException(TransportException exp) {
                throw new UnsupportedOperationException("Primary term validation is not available for " + actionName);  
        private final boolean initiatedByNodeClient;  
    }
                                if (ExceptionsHelper.unwrap(e, AlreadyClosedException.class, IndexShardClosedException.class) == null) {
            return indexShard.getReplicationGroup();
                    replica,  
            }
        try {
    protected void handleReplicaRequest(  
import org.opensearch.action.support.ActionFilters;
        public long getGlobalCheckpoint() {
        TransportService transportService,  
    private volatile TimeValue retryTimeout;
                    }
        return new ReplicasProxy();  
                if (request.waitForActiveShards() == ActiveShardCount.DEFAULT) {  
            return request;
                    // Try one more time...
        Releasable releasable = checkReplicaLimits(replicaRequest.getRequest());
            operationLock.close();
        private final ReplicationTask task;
        public ShardRouting routingEntry() {
        ThreadPool threadPool,  
                    finishOnSuccess(response);
                    retry(blockException);  
                }  
    private final boolean syncGlobalCheckpointAfterOperation;
        // Indicates if this primary shard request originated by a reroute on this local node.
        public String getTargetAllocationID() {
        }
        @Override  
                if (blockException.retryable()) {
    public ResolvedIndices resolveIndices(Request request) {
import org.opensearch.index.shard.ShardNotInPrimaryModeException;  
                        actionName,  
        ActionListener<ReplicaResult> listener  
     * Responsible for routing and retrying failed operations on the primary.
                        primaryShardReference,
                    return;  
                        }  
            final ShardId shardId = primaryRequest.getRequest().shardId();  
            new AsyncReplicaAction(replicaRequest, listener, (ReplicationTask) task).run();  
        public String toString() {
    private volatile TimeValue initialRetryBackoffBound;  
            return indexShard.isRelocatedPrimary();
        ) {
 * the Apache License, Version 2.0 (the "License"); you may
    }  
                    state.version(),
            });  
    }  
                setPhase(task, "failed");  
                }
import org.opensearch.common.util.concurrent.AbstractRunnable;
                        }  
                @Override
    protected void handlePrimaryRequest(final ConcreteShardRequest<Request> request, final TransportChannel channel, final Task task) {
                                    "received an error from node [{}] for request [{}], scheduling a retry",  
     *
                long maxSeqNoOfUpdatesOrDeletes,  
            return "request: " + request + ", target allocation id: " + targetAllocationID + ", primary term: " + primaryTerm;
    protected void acquireReplicaOperationPermit(
        @Override
        @Override
        }  
        IndexShard primary,
                );
                public String executor() {
        @Override
        // is only true if sentFromLocalReroute is true.
                // target is not aware that it is the active primary shard already.
        public void performOn(
            if (logger.isTraceEnabled()) {
                })
                );  
    );  
        PrimaryShardReference(IndexShard indexShard, Releasable operationLock) {
                        );
                        ),
                        replicasProxy,  
                        onFailure(new ReplicationOperation.RetryOnPrimaryException(shardId, "shard is not in primary mode", e));
                    run();  
    ) {
        public void failShard(String reason, Exception e) {
                forceExecutionOnPrimary,
            new ChannelActionListener<>(channel, transportReplicaAction, replicaRequest),
                if (logger.isTraceEnabled()) {
                                    // intentionally swallow, a missed global checkpoint sync should not fail this operation
                replicaRequest.getGlobalCheckpoint(),
import org.opensearch.common.lease.Releasable;
            if (actualAllocationId.equals(replicaRequest.getTargetAllocationID()) == false) {  
 * KIND, either express or implied.  See the License for the
        ClusterBlockLevel indexBlockLevel = indexBlockLevel();
                                    );  
            new ChannelActionListener<>(channel, transportPrimaryAction, request),
            this::handleReplicaRequest
            }
        }
 */  
import org.opensearch.core.index.shard.ShardId;  
                }  
     *
                        request,
        }
     * @opensearch.internal
public abstract class TransportReplicationAction<
        }
                indexShard.failShard(reason, e);
                            );
                assert false : new AssertionError("finishAsFailed called but operation is already finished", failure);
import org.opensearch.index.shard.IndexShardClosedException;  
        protected final IndexShard indexShard;
            || isRetryableClusterBlockException(e);
            final String action,
                    transportService.sendRequest(  
    /**
        private final IndexShard replica;
            /*
        public final Exception finalFailure;  
        private final long globalCheckpoint;
                                primaryShardReference.indexShard.maybeSyncGlobalCheckpoint("post-operation");
                                        ),
                return blockException;
        final long maxSeqNoOfUpdatesOrDeletes
                        final ReplicaResponse response = new ReplicaResponse(
            out.writeZLong(maxSeqNoOfUpdatesOrDeletes);
        return null;
     * @param request       the request to resolve
        Releasable releasable = checkPrimaryLimits(
     */
    }  
                            new ActionListenerResponseHandler<>(onCompletionListener, ReplicaResponse::new)
         */
            releasable::close
        primary.acquirePrimaryOperationPermit(onAcquired, executor, request, forceExecutionOnPrimary);  
                    logger.trace("cluster is blocked, scheduling a retry", blockException);
            assert localCheckpoint != SequenceNumbers.UNASSIGNED_SEQ_NO;
        }
        public long globalCheckpoint() {  
                                    + "] is stale (expected at least ["  
    }
    private void runReroutePhase(Task task, Request request, ActionListener<Response> listener, boolean initiatedByNodeClient) {  
     * method because its more convenient that way.
                        "primary shard [{}] is not yet active, scheduling a retry: action [{}], request [{}], "
            }
            this.globalCheckpoint = globalCheckpoint;  
    protected class ReplicasProxy implements Replicas<ReplicaRequest> {
            );
                    }
    ) {  
            final ActionListener<ReplicationOperation.ReplicaResponse> listener
            request.setParentTask(taskId);
        return TransportRequestOptions.EMPTY;
     * @opensearch.internal  
        }  
import org.opensearch.index.shard.IndexShard;
import org.opensearch.cluster.block.ClusterBlockException;
        @Override
     * Execute the specified replica operation. This is done under a permit from  
                    );
        this.retryTimeout = getRetryTimeoutSetting().get(settings);
        registerPrimaryRequestHandler(requestReader, admissionControlActionType);
                            request.shardId().getIndex(),  
        ) {  
            } catch (Exception e) {  
        private final ActionListener<Response> onCompletionListener;
            task.setPhase(phase);
    ) {
                        adaptResponse(response, primaryShardReference.indexShard);  
    public static class ReplicaResponse extends ActionResponse implements ReplicationOperation.ReplicaResponse {  
                                getReplicationMode(indexShard),  
                assert false : "finishOnSuccess called but operation is already finished";  
        @Override
                if (primary.currentNodeId().equals(state.nodes().getLocalNodeId())) {
                                "action [{}] completed on shard [{}] for request [{}]",  
        try {
        final ActionListener<Releasable> onAcquired
        @Override  
                + "] response";  
        private void handleException(PrimaryShardReference primaryShardReference, Exception e) {
        @Override
            final R request,
                    final IndexShard indexShard = primaryShardReference.indexShard;
     * @opensearch.internal
     */  
            ReplicaResponse that = (ReplicaResponse) o;
        @Override  
            if (finished.compareAndSet(false, true)) {
                    replicaRequest.getRequest(),
    protected final String transportPrimaryAction;  
                }
    /**
            this.finalFailure = finalFailure;  
     */
                    @Override  
                if (state.nodes().nodeExists(primary.currentNodeId()) == false) {  
import org.opensearch.node.NodeClosedException;  
                    request.routedBasedOnClusterVersion()
        public ReplicaRequest replicaRequest() {
                        responseWithFailure(new NodeClosedException(clusterService.localNode()));
                this::handlePrimaryRequest
    /**  
            setShard(shardId);
    }  
        private final long primaryTerm;  
            observer.waitForNextChange(new ClusterStateObserver.Listener() {  
     * The primary shard reference
    /**  
                primaryTerm,
    ) {  
        ShardStateAction shardStateAction,
            requestReader,
        public String toString() {
        }
                listener.onFailure(new NoNodeAvailableException("unknown node [" + nodeId + "]"));
        protected void doRun() throws Exception {
    }
        super(actionName, actionFilters, transportService.getTaskManager());
 * primary node to validate request before primary operation followed by sampling state again for resolving
        ActionListener<ReplicaResponse> listener = ActionListener.runBefore(  
    ) {
            public void performOn(
        public int hashCode() {
        @Override  
                        Releasables.closeWhileHandlingException(releasable); // release shard operation lock before responding to caller  
                new ConcreteShardRequest<>(
        implements
        }
        ) {
            // "alive" if it were to be marked as stale.
                                + "Local cluster state version [{}]] is older than on sending node (version [{}]), scheduling a retry...",
                        + "]"
    class PrimaryShardReference
                this::handlePrimaryRequest
import org.opensearch.OpenSearchException;
     * node with primary copy.  
     *  
                in -> new ConcreteShardRequest<>(requestReader, in),
                @Override  
    }
        private final ClusterStateObserver observer = new ClusterStateObserver(clusterService, null, logger, threadPool.getThreadContext());
                        Releasables.closeWhileHandlingException(releasable); // release shard operation lock before responding to caller  
                    state.version(),
     *  
            localRerouteInitiatedByNodeClient = false;  
import org.opensearch.action.support.ActiveShardCount;
    @Override
        public void updateGlobalCheckpointForShard(final String allocationId, final long globalCheckpoint) {
     * <p>
            replicaRequestReader,
        Setting.Property.Dynamic,  
    }
            boolean sentFromLocalReroute,  
                            transportReplicaAction,  
                        transportService.sendRequest(
    public static final Setting<TimeValue> REPLICATION_RETRY_TIMEOUT = Setting.timeSetting(  
            super(request, targetAllocationID, primaryTerm);
        Setting.Property.NodeScope
            ) {
                    logger.trace(
            );  
            return indexShard.routingEntry();  
                                    node.getId(),
                    return ThreadPool.Names.SAME;  
    /**
            }
                                    logger.info(  
                } else {
                        if (logger.isTraceEnabled()) {
        boolean forceExecutionOnPrimary,
        public ReplicaResponse(StreamInput in) throws IOException {
            final ConcreteReplicaRequest<ReplicaRequest> replicaRequest = new ConcreteReplicaRequest<>(
        }
     */
                            try {  
        }  
            this.replicationTask = replicationTask;
                } else {
            request = requestReader.read(in);
        protected void doRun() {
                + maxSeqNoOfUpdatesOrDeletes  
        };
        }  
            onCompletionListener.onFailure(e);
 * specific language governing permissions and limitations
            if (finished.compareAndSet(false, true)) {
            return targetAllocationID;
            this(task, request, listener, false);  
                            replicaRequest,
            maxSeqNoOfUpdatesOrDeletes = in.readZLong();
                primaryRequest.getRequest(),
            listener.onFailure(e);  
        }
            if (actualTerm != primaryRequest.getPrimaryTerm()) {
    protected final TransportService transportService;
/*
                    actualTerm
                    }
/**  
            ClusterBlockException blockException = state.blocks().indexBlockedException(indexBlockLevel, indexName);  
                    }  
        ReroutePhase(ReplicationTask task, Request request, ActionListener<Response> listener, boolean initiatedByNodeClient) {  
        if (admissionControlActionType != null) {  
        protected final ReplicaRequest replicaRequest;
            return indexShard.getLastSyncedGlobalCheckpoint();
    public ReplicationMode getReplicationMode(IndexShard indexShard) {
    }
 * You may obtain a copy of the License at  
        @Override
                public void onNewClusterState(ClusterState state) {
        public ConcreteShardRequest(R request, String targetAllocationID, long primaryTerm) {
            } else {  
    }
import org.opensearch.indices.IndicesService;
        public boolean equals(Object o) {
                public void onClusterServiceClose() {
            replicaRequestReader,
    // package private for testing
        public R getRequest() {  
                @Override
                    "expected allocation id [{}] but found [{}]",  
                            primary.allocationId().getRelocationId(),
     *
                ActionListener.wrap(releasable -> runWithPrimaryShardReference(new PrimaryShardReference(indexShard, releasable)), e -> {
    /**
            sentFromLocalReroute = false;
                e.addSuppressed(inner);  
            Releasables.closeWhileHandlingException(primaryShardReference); // release shard operation lock before responding to caller  
     * The replica result  
     * @opensearch.internal  
        }
                    request,
                    DiscoveryNode relocatingNode = clusterState.nodes().get(primary.relocatingNodeId());
                } else {
            return indexShard.getMaxSeqNoOfUpdatesOrDeletes();
                        responseWithFailure(e);
            }  
            try {
            Releasable,
        return new ReplicasProxy() {
                    assert primary.relocating() : "indexShard is marked as relocated but routing isn't" + primary;  
                    actionName,  
            return globalCheckpoint;
import org.opensearch.threadpool.ThreadPool;  
                                    requestToPerform
        @Override  
    }
    protected final String executor;
        TransportService transportService,  
                        retryTimeout,  
                    @Override  
        private final boolean localRerouteInitiatedByNodeClient;  
                admissionControlActionType,  
        return indexService.getShard(shardId.id());  
import org.opensearch.transport.TransportService;
     * Resolves index and shard id for the request before routing it to target node
        }
     *  
                    : "request waitForActiveShards must be set in resolveRequest";  
        String actionName,
        final ConcreteReplicaRequest<ReplicaRequest> replicaRequest,
                    "unexpected error during the primary phase for action [{}], request [{}]",
import org.opensearch.cluster.node.DiscoveryNode;  
        @Override  
                observer.waitForNextChange(new ClusterStateObserver.Listener() {
                                super.handleResponse(response);
            threadPool,  
        return REPLICATION_RETRY_TIMEOUT;
                Releasables.closeWhileHandlingException(releasable); // release shard operation lock before responding to caller  
                executor,  
            if (blockException != null) {
import org.opensearch.transport.client.transport.NoNodeAvailableException;
        return () -> {};
        public long getPrimaryTerm() {
                }
        private final ConcreteReplicaRequest<ReplicaRequest> replicaRequest;  
                            primaryRequest.getPrimaryTerm()  
    /**  
            // checkpoint sync) and therefore the replica should still be
     * Making primary and replica actions suffixes as constant
                + globalCheckpoint
        transportService.registerRequestHandler(
        AsyncReplicaAction(
     * Asynchronous replica action
        ActionListener<PrimaryResult<ReplicaRequest, Response>> listener
        }
    }
            final DiscoveryNode node = clusterService.state().nodes().get(nodeId);
            }
                true,
import org.opensearch.action.support.ChannelActionListener;  
                }  
        IndicesService indicesService,
                        primaryRequest.getPrimaryTerm(),
                listener,  
         */
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
        }
                }  
        public void onFailure(Exception e) {
    protected abstract void shardOperationOnPrimary(
/*  
     *
        @Override  
        public void perform(Request request, ActionListener<PrimaryResult<ReplicaRequest, Response>> listener) {
                finishAsFailed(failure);
                                            primaryShardReference.indexShard.shardId()  
        public void writeTo(StreamOutput out) throws IOException {
     * @param admissionControlActionType type of AdmissionControlActionType  
            );  
                        "Retrying operation on replica, action [{}], request [{}]",
            ReplicationOperation.PrimaryResult<ReplicaRequest> {  
                                () -> new ParameterizedMessage(
        this.transportOptions = transportOptions(settings);
            this.primaryTerm = primaryTerm;
                    primaryRequest.getPrimaryTerm(),  
                logger.trace(
        }  
                if (indexMetadata.getState() == IndexMetadata.State.CLOSE) {
import org.opensearch.cluster.ClusterState;
             * A replica should always know its own local checkpoints so this should always be a valid sequence number or the pre-6.0  
                    logger.trace("cluster is blocked, action failed on primary", blockException);
            final long globalCheckpoint,  
            ReplicationTask task
            String nodeId = replica.currentNodeId();
            final long maxSeqNoOfUpdatesOrDeletes  
                        );
                                transportReplicaAction,
     */
                node,
     */  
        return null;
                + ", request="
            this.observer = new ClusterStateObserver(clusterService, request.timeout(), logger, threadPool.getThreadContext());
    }
        TimeValue.timeValueMillis(50),
        );
        public long maxSeqNoOfUpdatesOrDeletes() {
                                    + request.routedBasedOnClusterVersion()
            request.onRetry();
        public boolean isRelocated() {  
     * The Primary Result  
     *
import org.opensearch.cluster.routing.AllocationId;
import org.opensearch.core.action.ActionResponse;
                                // only log non-closed exceptions  
            final String actualAllocationId = this.replica.routingEntry().allocationId().getId();
        }  
                        request,  
                final IndexMetadata indexMetadata = state.metadata().index(request.shardId().getIndex());
        );
                    logger.trace(
                                            "{} failed to execute post-operation global checkpoint sync",
                        + result.replicaRequest()  
    @Nullable  
            // This does not need to make the shard stale. The idea is that this
     * method can be overridden to acquire more.
        private final Releasable operationLock;
        public String getDescription() {  
                );  
            listener.onFailure(e);
    /**  
            }  
                    logger.trace("operation succeeded. action [{}],request [{}]", actionName, request);
        }  
            executor,  
    @Override
        ) {
                    if (e instanceof ShardNotInPrimaryModeException) {  
    /**
                public Response read(StreamInput in) throws IOException {  
        Writeable.Reader<Request> requestReader,  
         * Result of executing a primary operation  
            if (task != null) {  
            // This does not need to fail the shard. The idea is that this
                }
            || TransportActions.isShardNotAvailableException(e)
     * @param requestReader instance of the request reader
        @Override
                    }
            this.replica = getIndexShard(shardId);  
        }
 * under the License.  
                            finishAsFailed(exp);
        }  
    @Nullable
        }
                    final Writeable.Reader<Response> reader = TransportReplicationAction.this::newResponseInstance;
            final ClusterBlockException blockException = blockExceptions(state, request.shardId().getIndexName());
        if (task != null) {
            localCheckpoint = in.readZLong();  
            this(replicaRequest, replicationResponse, null);
            return Objects.hash(localCheckpoint, globalCheckpoint);
                            new IndexNotFoundException(  
        IndicesService indicesService,
        private final ConcreteShardRequest<Request> primaryRequest;
                            } catch (final Exception e) {
                        }
        ClusterService clusterService,
        ReroutePhase(ReplicationTask task, Request request, ActionListener<Response> listener) {
                                super.handleException(exp);
                if (indexMetadata == null) {  
     * The replica response
        }
                listener.onFailure(failure);
        private void performRemoteAction(ClusterState state, ShardRouting primary, DiscoveryNode node) {  
                + "found ["
    private ClusterBlockException blockExceptions(final ClusterState state, final String indexName) {
                ActionListener<ReplicationOperation.ReplicaResponse> listener
            assert finalFailure != null ^ finalResponseIfSuccessful != null : "either a response or a failure has to be not null, "
            final boolean isPrimaryAction,  
                        primaryRequest.getRequest(),  
        ActionFilters actionFilters,
            assert replica.getActiveOperationsCount() != 0 : "must perform shard operation under a permit";
     * @return the overridden replication mode.  
     * @opensearch.internal
        clusterSettings.addSettingsUpdateConsumer(getRetryTimeoutSetting(), (v) -> retryTimeout = v);
            return request.createTask(id, type, action, parentTaskId, headers);
import org.opensearch.core.common.io.stream.StreamOutput;
                });
import org.opensearch.index.IndexService;  
    protected void doExecute(Task task, Request request, ActionListener<Response> listener) {
                }  
        if (globalBlockLevel != null) {
     * The maximum bound for the first retry backoff for failed replication operations. The backoff bound
     * Internal request for concrete replica
            String targetAllocationID,
    private void handleOperationRequest(final Request request, final TransportChannel channel, Task task) {  
            // the wire, then it was NOT sent from a local reroute.
        @Override
        AsyncPrimaryAction(  
            );  
        private final R request;
            setPhase(task, "replica");
            final ShardId shardId = replicaRequest.getRequest().shardId();
                if (blockException != null) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
    protected TransportReplicationAction(  
                retryBecauseUnavailable(
        }
                globalCheckpoint,
                    // it is safe to execute primary phase on relocation target as there are no more in-flight operations where primary  
import org.opensearch.ExceptionsHelper;  
                    request.shardId(),
        @Override
                    this.replica.shardId(),
                }
                        return;  
        ActionListener<Response> listener = ActionListener.runBefore(
    protected Setting<TimeValue> getRetryTimeoutSetting() {
            setPhase(task, "routing");  
                        new ConcreteShardRequest<>(  
            false,
     */
            syncGlobalCheckpointAfterOperation,  
            ShardRouting replica,
     */  
            this.sentFromLocalReroute = sentFromLocalReroute;
        public ConcreteReplicaRequest(
                    assert result.replicaRequest() == null || result.finalFailure == null : "a replica request ["
        private final ReplicationTask task;
                    request
            setPhase(task, "waiting_on_primary");
        public void setShardInfo(ReplicationResponse.ShardInfo shardInfo) {
import org.opensearch.action.UnavailableShardsException;  
            globalCheckpoint = in.readZLong();  
        }
    protected void adaptResponse(Response response, IndexShard indexShard) {
