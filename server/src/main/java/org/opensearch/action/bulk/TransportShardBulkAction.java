            this.primaryTerm = primaryTerm;
            return new ReplicationTask(id, type, action, getDescription(), parentTaskId, headers);
            this::handlePrimaryTermValidationRequest
    implements
        IndicesService indicesService,
            // fence blob during every translog upload (see RemoteStoreFence), so the no-op primary term validation
    }  
        }  
    };
        final long version = context.getRequestToExecute().version();
            }
        ThreadPool threadPool,
import org.opensearch.indices.SystemIndices;  
                final ShardId shardId = replica.shardId();
                } finally {  
        super(
                    while (context.hasMoreOperationsToExecute()) {
                request.versionType(),  
     *
                    opType.getLowercase(),
                return;
public class TransportShardBulkAction extends TransportWriteAction<BulkShardRequest, BulkShardRequest, BulkShardResponse>  
            return ReplicationMode.PRIMARY_TERM_VALIDATION;
            actionFilters,  
                            context.setRequestToExecute(context.getCurrent());
            this.request = request;
 * this file be licensed under the Apache-2.0 license or a
                        while (context.hasMoreOperationsToExecute()) {  
import org.opensearch.core.xcontent.ToXContent;  
    }
                        @Override
    @Override
 *  
            PrimaryTermValidationRequest request
                        indexSourceAsBytes,
                assert response.getResponse().getSeqNo() != SequenceNumbers.UNASSIGNED_SEQ_NO;
            shardId = new ShardId(in);  
                    indexResponse.getResult()
                        UpdateHelper.extractGetResult(  
import org.opensearch.transport.TransportRequestOptions;  
                final DeleteResponse deleteResponse = operationResponse.getResponse();
            long globalCheckpoint,  
        ) {  
            return new WriteReplicaResult<>(request, location, null, replica, logger);  
            );
            targetAllocationID = in.readString();
            );
                    "{} failed to execute bulk item ({}) {}",  
            this.onCompletionListener = onCompletionListener;
            systemIndices,  
                    null
            super.writeTo(out);
                    finishTranslogBatch(bodyFailure);
                    deleteResponse.getId(),
import org.opensearch.action.ActionRunnable;
    ) {
            shardStateAction,
    ) throws Exception {
             * Failure handling mirrors the per-operation path, where a {@code Translog#add} failure propagates out of
import org.opensearch.action.support.replication.TransportWriteAction;
     * @return {@code true} if request completed on this thread and the listener was invoked, {@code false} if the request triggered
            return false;
    }
    protected Releasable checkPrimaryLimits(BulkShardRequest request, boolean rerouteWasLocal, boolean localRerouteInitiatedByNodeClient) {
                segmentReplicationPressureService.isSegrepLimitBreached(request.shardId());
        );  
    static boolean executeBulkItemRequest(
                default:
                throw new ShardNotFoundException(  
        BulkPrimaryExecutionContext context,  
        final Task task  
                    request.getPrimaryTerm(),
                ReplicaResponse::new
import org.apache.logging.log4j.Logger;
import org.opensearch.index.SegmentReplicationPressureService;
        final PrimaryTermValidationRequest request,
                    }  
            @Override
        LongSupplier nowInMillisSupplier,
    }  
            // service
                    bodyFailure = e;
            }
        assert context.getRequestToExecute() != null; // also checks that we're in TRANSLATED state
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
                );
                            context.resetForExecutionForRetry();
             * <p>
    @Inject
        final DocWriteRequest<?> docWriteRequest = context.getCurrent();
import org.opensearch.index.mapper.MapperException;  
        }  
                        context.getPrimary(),
            false,
                request.ifPrimaryTerm(),
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;  
            } catch (Exception e) {  
                    deleteResponse.getShardInfo(),  
            public void onNewClusterState(ClusterState state) {
        }
        if (isUpdate
            result = primary.applyIndexOperationOnPrimary(
        } else {
     * term validation in presence of a new primary.
        final Engine.Result result;  
            if (node == null) {  
     *                      a mapping update that will finish and invoke the listener on a different thread  
import org.opensearch.action.support.replication.ReplicationMode;  
        private final IndexShard replica;  
            ActionListener<ReplicaResponse> onCompletionListener,
        public void performOn(
                        updateIndexRequest.getContentType()  
        }
            final DocWriteResponse.Result translatedResult = translate.getResponseResult();
                                null
import org.opensearch.cluster.metadata.IndexMetadata;  
            BulkShardRequest request,
                            context.failOnMappingUpdate(e);  
            }  
 * @opensearch.internal
                    primaryResponse.getId(),  
                    final BytesReference indexSourceAsBytes = updateIndexRequest.source();
 * Modifications Copyright OpenSearch Contributors. See
    protected void handlePrimaryTermValidationRequest(  
            threadPool,
        }
    public ReplicationMode getReplicationMode(IndexShard indexShard) {
                mappingUpdateListener.onFailure(new MapperException("timed out while waiting for a dynamic mapping update"));  
import org.opensearch.index.remote.RemoteStorePressureService;  
                + primaryTerm
import org.opensearch.action.ActionListenerResponseHandler;  
import org.opensearch.cluster.ClusterState;
             * the finish failure is attached as suppressed; otherwise the finish failure propagates.  
                    primaryResponse.getPrimaryTerm(),
             * {@code batch.add} or an ordering {@code flush()}) is exactly what {@code finish()} throws again. Attaching
            @Override  
     * This {@link org.opensearch.action.support.replication.TransportReplicationAction.ReplicasProxy} implementation is  
        @Override  
     */
            ActionListener<ReplicationOperation.ReplicaResponse> listener
        String executorName
     * used for primary term validation and is only relevant for TransportShardBulkAction replication action.
        }), listener, threadPool, executor(primary));
                } else {
            // With remote-store fencing enabled, stale-primary fencing is enforced by a conditional write on the
            protected void doRun() throws Exception {
            response = executionResult;
                    actualAllocationId
                mappingUpdateListener.onResponse(null);
     */
             * tragic event and the sync that would acknowledge any item never runs. If the body already threw, that
                context.setTranslogBatch(translogBatch);
import java.util.function.LongSupplier;
        public String toString() {
    }
import org.opensearch.node.NodeClosedException;
            assert response != null;  
                mappingUpdateListener.onFailure(new NodeClosedException(clusterService.localNode()));
                + targetAllocationID
        private final ActionListener<ReplicaResponse> onCompletionListener;
import org.apache.logging.log4j.message.ParameterizedMessage;  
                    context.markAsRequiringMappingUpdate();
        if (result.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {  
    }  
            default:
            }
        @Override
     *
                long startTime = System.nanoTime();
    protected void dispatchedShardOperationOnPrimary(
        return result;
                    primaryTerm = replica.getOperationPrimaryTerm();  
                        }
            } else {  
import org.apache.logging.log4j.util.MessageSupplier;
    }
                final BulkShardRequest requestForResult;
                                    docWriteRequest.version()
        if (indexShard.indexSettings().isAssignedOnRemoteNode()) {  
            try {
                    indexResponse.getShardId(),
        final ShardId shardId = request.getShardId();  
                    indexRequest.routing(),
        if (operationResponse.isFailed()) {
        this.mappingUpdatedAction = mappingUpdatedAction;
            && isFailed
                + "]";
                final long primaryTerm;  
                result = replica.applyDeleteOperationOnReplica(
            EXECUTOR_NAME_FUNCTION,  
                final Engine.Result result = new Engine.IndexResult(failure, updateRequest.version());
    ) {  
import org.opensearch.common.lease.Releasable;
            final Translog.Location location = performOnReplica(request, replica);
                final SourceToParse sourceToParse = new SourceToParse(  
            final UpdateResponse updateResponse;
        ActionListener<PrimaryResult<BulkShardRequest, BulkShardResponse>> listener,
import org.opensearch.common.inject.Inject;
        performOnPrimary(request, primary, updateHelper, threadPool::absoluteTimeInMillis, (update, shardId, mappingListener) -> {
/*  
                throw new IllegalStateException("Unexpected request operation type on replica: " + docWriteRequest.opType().getLowercase());  
                    break;
            // Check operation primary term against the incoming primary term
import org.apache.logging.log4j.LogManager;
    private static boolean isConflictException(final Exception e) {
                            sourceAndContent.v1(),
    }
            );
        }
            }
                            // We are waiting for a mapping update on another thread, that will invoke this action again
        ActionListener<PrimaryResult<BulkShardRequest, BulkShardResponse>> listener
        @Override
                }
        }.run();  
                    context.setRequestToExecute(indexRequest);
                    final Tuple<? extends MediaType, Map<String, Object>> sourceAndContent = XContentHelper.convertToMap(  
                    indexRequest.getAutoGeneratedTimestamp(),
            return shardId;
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                            // requesting the mapping update, so the scope is closed and its location merged before any  
    private final UpdateHelper updateHelper;  
        this.transportPrimaryTermValidationAction = ACTION_NAME + "[validate_primary_term]";  
import java.util.Objects;
            if (segmentReplicationPressureService.isSegmentReplicationBackpressureEnabled()) {  
                    sourceToParse  
                listener.onFailure(new NoNodeAvailableException("unknown node [" + nodeId + "]"));
                }
            true,  
            ReplicationTask task,
}  
 * under the License.  
        if (isDelete) {
                    request.source(),
             * Appends the final chunk and detaches the scope, folding the greatest appended location into the
        transportService.registerRequestHandler(
import org.opensearch.cluster.routing.AllocationId;
    public static final String ACTION_NAME = BulkAction.NAME + "[s]";
            }
                            updateHelper,
    }  
                // If no actual writes occurred (locationToSync is null), we should not trigger refresh
            setPhase(task, "failed");  
            indexingPressureService,
    /**
                            // continuation can run; the finally below is then a no-op.
        final BulkItemResponse response;  
        return request.ramBytesUsed();  
        switch (docWriteRequest.opType()) {
        final String concreteIndex,
                    }
                if (locationToSync == null && bulkShardRequest.getRefreshPolicy() != WriteRequest.RefreshPolicy.NONE) {
            // the caller on another thread (possibly before this one returns), so the scope must be finished, and any
             * {@link #executeBulkItemRequest} and fails the whole shard-bulk request: the translog has recorded its own  
                }  
        });
                // Batch successful primary index operations for eligible remote-backed segment-replication engines. A  
                context.markAsCompleted(context.getExecutionResult());
        return response;
            final BulkItemResponse response = item.primaryResponse();
            this.targetAllocationID = Objects.requireNonNull(targetAllocationID);  
                    request.id(),  
                // updates/deletes flush the current chunk for ordering, and finally always appends and closes it.
                                    docWriteRequest.opType() == DocWriteRequest.OpType.DELETE,
            primaryTerm = in.readVLong();
            && isConflictException(executionResult.getFailure().getCause())  
            public void onTimeout(TimeValue timeout) {
     * Primary term validation request sent to a specific allocation id
            return targetAllocationID;
                        }
                            assert context.requiresWaitingForMappingUpdate();  
                    deleteRequest.id(),  
            executor,
import org.opensearch.core.xcontent.MediaType;
    public static Translog.Location performOnReplica(BulkShardRequest request, IndexShard replica) throws Exception {  
            if (actualAllocationId.equals(request.getTargetAllocationID()) == false) {
                context.setRequestToExecute(updateRequest);  
                        bulkShardRequest.items()
     * ultimately boils down to TransportShardBulkAction and isolated primary could continue to acknowledge if it is not  
                // we use index result to communicate failure while translating update request
        final DocWriteRequest.OpType opType = context.getCurrent().opType();
        final Engine.Result result;  
                    primaryResponse.getSeqNo(),  
            transportService,
            return primaryTerm;  
            );  
     * @opensearch.internal
/**
            final Engine.Result operationResult;
        if (force(request) == false) {
/*  
import org.opensearch.cluster.ClusterStateObserver;  
        }  
        Tracer tracer
     * replicas to perform primary term validation. This make sures an isolated primary fails to ack after primary  
import org.opensearch.transport.TransportService;
                    context.finishTranslogBatch();  
                    indexResponse.getVersion(),  
                        context.buildShardResponse(serviceTimeEWMAInNanos, nodeQueueSize),
                        )  
    private final SegmentReplicationPressureService segmentReplicationPressureService;
            if (indexShard.indexSettings().isRemoteStoreFencingEnabled()
            // Durability is a dynamic index setting, and this decision is not atomic with the ack-time sync: an
        public PrimaryTermValidationRequest(String targetAllocationID, long primaryTerm, ShardId shardId) {
                    if (bodyFailure != null) {
             * retry on the re-promoted primary. The same instance is therefore never attached to itself.
 * ownership. Elasticsearch licenses this file to you under  
            long maxSeqNoOfUpdatesOrDeletes,
        return super.getReplicationMode(indexShard);
            public void onClusterServiceClose() {  
        } else {
    }
                    // primary is on older version, just take the current primary term
        return super.checkPrimaryLimits(request, rerouteWasLocal, localRerouteInitiatedByNodeClient);  
    }
        return isDelete ? primary.getFailedDeleteResult(e, version) : primary.getFailedIndexResult(e, version);  
            if (translatedResult == DocWriteResponse.Result.CREATED || translatedResult == DocWriteResponse.Result.UPDATED) {  
        context.markOperationAsExecuted(r);
        SystemIndices systemIndices,
                    primaryResponse.getSeqNo(),
            context.setRequestToExecute(context.getCurrent());  
            settings,
                try {
                + "] for targetAllocationID ["
                ActionListener.completeWith(  
                );
    ) {
        final boolean isDelete = context.getRequestToExecute().opType() == DocWriteRequest.OpType.DELETE;
    protected ReplicationOperation.Replicas<BulkShardRequest> primaryTermValidationReplicasProxy() {
                    break;
             * does before requesting a mapping update so the scope never outlives this thread's execution.  
                }  
     *  
        } else {
                    throw finishFailure;
                replica.shardId()
import org.opensearch.cluster.action.index.MappingUpdatedAction;
             * {@code TransportActions#isShardNotAvailableException} does not recognise and defeat the coordinator's
                // We must finish the outstanding request. Finishing the outstanding request can include
        ActionListener<ReplicaResponse> listener = new ChannelActionListener<>(channel, transportPrimaryTermValidationAction, request);
        private final ShardId shardId;  
 * license agreements. See the NOTICE file distributed with
             * exception stays the one the client sees (per-operation, the first failing append is what propagates) and
                        if (current != null
            // If the request primary term is low, then trigger lister failure
                    IndexMetadata metadata = context.getPrimary().indexSettings().getIndexMetadata();
            mappingUpdater.updateMappings(result.getRequiredMappingUpdate(), primary.shardId(), new ActionListener<Void>() {
                request.getAutoGeneratedTimestamp(),
            }
                }  
        }  
                    shardId.getIndexName(),
import org.opensearch.action.support.WriteRequest;
                updateResult = updateHelper.prepare(updateRequest, context.getPrimary(), nowInMillisSupplier);
                case CREATED:
                                ),  
            } else if (translatedResult == DocWriteResponse.Result.DELETED) {  
    @Override
                    );
                    response.getFailure().getMessage()
            this.task = task;  
                final GetResult getResult = UpdateHelper.extractGetResult(  
        BulkShardRequest request,
                        requestForResult,  
                throw new IllegalArgumentException("unknown operation type: " + translatedResult);
                updateResponse = new UpdateResponse(  
        public void onFailure(Exception e) {
                final String message = String.format(
     * {@link TransportShardBulkAction#transportPrimaryTermValidationAction}.
                onComplete(exceptionToResult(e, primary, isDelete, version), context, updateResult);
    private final RemoteStorePressureService remoteStorePressureService;  
        );  
                @Override
                        assert context.isInitial(); // either completed and moved to next or reset
            // append failure thrown, here on the owning thread rather than in the caller's finally block.
        SegmentReplicationPressureService segmentReplicationPressureService,
import org.opensearch.cluster.metadata.MappingMetadata;
import org.opensearch.action.support.ChannelActionListener;  
        ) {  
                            context,  
 * this work for additional information regarding copyright
                "Mappings are not available on the replica yet, triggered update: " + result.getRequiredMappingUpdate()
            BulkShardRequest::new,
import org.opensearch.action.delete.DeleteResponse;
                    indexResponse.getId(),  
        IndexShard primary,  
        if (result.getResultType() == Engine.Result.Type.MAPPING_UPDATE_REQUIRED) {
import org.opensearch.common.collect.Tuple;
import org.opensearch.action.update.UpdateRequest;  
            }
                if (TransportShardBulkAction.isConflictException(failure)) {
import org.opensearch.action.update.UpdateHelper;
    protected BulkShardResponse newResponseInstance(StreamInput in) throws IOException {
                        ) == false) {  
                onFailure(new IllegalStateException(message));
                    indexRequest.source(),  
     * be durably persisted in remote store. Without remote translog, current transport replication calls does primary
        return true;
                    "%s operation primary term [%d] is too old (current [%d])",  
                    @Override  
                updateResponse = new UpdateResponse(
        } else {
import org.opensearch.core.common.bytes.BytesReference;  
         **/  
        UpdateHelper updateHelper,
            context.resetForExecutionForRetry();
                    );
    @Override
                    primaryResponse.getVersion(),
import org.opensearch.common.Nullable;
                    () -> new WritePrimaryResult<>(
    private static final class PrimaryTermValidationReplicaAction extends AbstractRunnable implements ActionListener<Releasable> {  
import org.opensearch.common.xcontent.XContentHelper;
         * {@link AllocationId#getId()} of the shard this request is sent to
    }
    private final MappingUpdatedAction mappingUpdatedAction;
        if (shard.indexSettings().getIndexMetadata().isSystem()) {
                request.id(),
                    // Requesting mapping update failed, so we don't have to wait for a cluster state update
                } catch (RuntimeException finishFailure) {
                request.ifSeqNo(),
        return ResolvedIndices.of(request.index());  
                    indexRequest.getContentType(),
                    request.getShardId(),
            throw new TransportReplicationAction.RetryOnReplicaException(
            final ActionListenerResponseHandler<ReplicaResponse> handler = new ActionListenerResponseHandler<>(  
import java.util.function.Function;
            } else {  
                                    e,
        public ShardId getShardId() {  
import org.opensearch.transport.TransportChannel;
        new ActionRunnable<PrimaryResult<BulkShardRequest, BulkShardResponse>>(listener) {  
                            // once its done so we just break out here. executeBulkItemRequest finished the batch before
                new SourceToParse(
            assert update != null;
            final BulkItemRequest item = request.items()[i];  
        ActionListener<Void> itemDoneListener
        }  
    }
                    onComplete(exceptionToResult(e, primary, isDelete, version), context, updateResult);
                logger.info(() -> new ParameterizedMessage("{} mapping update rejected by primary", primary.shardId()), e);
            }
                        bulkShardRequest.shardId(),
            assert shardId != null;  
            }  
        }  
                    updateResponse.setGetResult(
            indicesService,  
        }  
import org.opensearch.ExceptionsHelper;
        Settings settings,
    @Override  
        IndexShard replica = getIndexShard(shardId);
        assert context.isInitial();
                    protected void doRun() {
import org.opensearch.tasks.Task;  
            }
                final IndexRequest updateIndexRequest = translate.action();
            updateResult = null;
import org.opensearch.action.delete.DeleteRequest;
                        MapperService.SINGLE_MAPPING_NAME,
            @Override  
        final TransportChannel channel,
                    deleteResponse.getVersion(),
        Consumer<ActionListener<Void>> waitForMappingUpdate,
            AdmissionControlActionType.INDEXING
                    @Override
                    }
 */
 * compatible open source license.
import org.opensearch.index.mapper.MapperService;
            return;  
                        return;  
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;
                return true;  
                    request.getTargetAllocationID(),  
                break;  
        final DocWriteRequest.OpType opType = docWriteRequest.opType();  
                final Translog.Location locationToSync = context.getLocationToSync();  
            // (it’s happening concurrently). Request r2, which now arrives on the primary and which also has the new
            setPhase(task, "primary-term-validation");  
 * You may obtain a copy of the License at  
                            sourceAndContent.v2(),  
        ThreadPool threadPool,  
                if (response.getFailure().getTerm() == SequenceNumbers.UNASSIGNED_PRIMARY_TERM) {
                    context.markOperationAsNoOp(updateResult.action());
     * Creates a new bulk item result from the given requests and result of performing the update operation on the shard.
 */  
        }
                    .merge(
                    request.getContentType(),
                final IndexResponse indexResponse = operationResponse.getResponse();
                        public void onFailure(Exception e) {
        this.segmentReplicationPressureService = segmentReplicationPressureService;  
        IndexShard primary,  
            } catch (Exception failure) {
        }
                    primaryTerm = response.getFailure().getTerm();
                            waitForMappingUpdate,
                    indexRequest.process(metadata.getCreationVersion(), mappingMd, updateRequest.concreteIndex());  
    ) {
import org.opensearch.core.action.ActionListener;
                    deleteRequest.routing()
                public void onFailure(Exception e) {  
                        }
     * @opensearch.internal  
        private final String targetAllocationID;
            onCompletionListener.onFailure(e);
    ) {
        }
        context.markAsCompleted(response);
                    // No actual writes occurred, so we should not refresh  
                    throw e;
                onResponse(null);
             * the append exception and rethrows it from every later call, so the body's exception (thrown out of  
import org.opensearch.cluster.metadata.ResolvedIndices;
                        public void onResponse(Void v) {
                executor.execute(new ActionRunnable<PrimaryResult<BulkShardRequest, BulkShardResponse>>(listener) {
        final boolean isFailed = executionResult.isFailed();  
                // even if the request has RefreshPolicy.IMMEDIATE
        MappingUpdatePerformer mappingUpdater,  
                    context.setRequestToExecute(updateResult.action());
    /**  
                            final DocWriteRequest<?> docWriteRequest = context.getRequestToExecute();
            // fanout to replicas is not required and replicas are taken off the write path entirely. With ASYNC  
        }
                    primaryResponse.getPrimaryTerm(),
     */
        UpdateHelper updateHelper,
                + "] with primaryTerm ["  
                    indexResponse.getSeqNo(),
            tracer,
        DocWriteResponse primaryResponse,
        return request.ramBytesUsed();
        final IndexShard primary = context.getPrimary();  
            mappingUpdatedAction.updateMappingOnClusterManager(shardId.getIndex(), update, mappingListener);
            // Even though the primary waits on all nodes to ack the mapping changes to the cluster-manager  
            super(in);  
                            ActionListener.wrap(v -> executor.execute(this), this::onRejection)
                        logger
                    )  
        @Override  
import org.opensearch.index.get.GetResult;
                    requestForResult.setParentTask(bulkShardRequest.getParentTask());
import org.opensearch.indices.IndicesService;
            shardId.writeTo(out);
                    indexResponse.getPrimaryTerm(),
        final UpdateHelper.Result translate
            this.replica = replica;
                        locationToSync,
                    deleteResponse.getSeqNo(),  
        ClusterStateObserver observer = new ClusterStateObserver(clusterService, request.timeout(), logger, threadPool.getThreadContext());  
                }  
            try {  
     * This action is used for performing primary term validation. With remote translog enabled, the translogs would  
    public TransportShardBulkAction(  
                primary.mapperService()  
        final UpdateHelper.Result updateResult;  
            switch (updateResult.getResponseResult()) {  
             * an exception to itself is rejected by the JDK ({@code IllegalArgumentException: Self-suppression not
                } else {
    /**
    @Override
    private final class PrimaryTermValidationProxy extends WriteActionReplicasProxy {
            if (response.isFailed()) {
                    deleteResponse.getSeqNo(),  
import org.opensearch.action.DocWriteResponse;  
        final BulkItemResponse response;
                            nowInMillisSupplier,
import org.opensearch.index.IndexingPressureService;
            // mapping update. Assume that the update is first applied on the primary, and only later on the replica  
 * software distributed under the License is distributed on an
            return toString();  
        public PrimaryTermValidationRequest(StreamInput in) throws IOException {
            ACTION_NAME,  
                if (updateRequest.fetchSource() != null && updateRequest.fetchSource().fetchSource()) {
            new PrimaryTermValidationReplicaAction(listener, replica, (ReplicationTask) task, request).run();
                        if (finishFailure != bodyFailure) {  
                            indexResponse.getPrimaryTerm(),
 * KIND, either express or implied.  See the License for the
                            bodyFailure.addSuppressed(finishFailure);
                    request.index(),
/*
import org.opensearch.threadpool.ThreadPool;
        ClusterService clusterService,  
import org.opensearch.index.engine.VersionConflictEngineException;
                );
            onComplete(result, context, updateResult);  
        private final long primaryTerm;
import org.opensearch.index.engine.Engine;  
                        final DocWriteRequest<?> current = context.getCurrent();  
import org.opensearch.action.support.replication.ReplicationTask;
                final Engine.TranslogBatch translogBatch = beginResult != null ? beginResult : Engine.NO_OP_TRANSLOG_BATCH;
            this.shardId = Objects.requireNonNull(shardId);
            && context.getRetryCounter() < ((UpdateRequest) docWriteRequest).retryOnConflict()) {
                    deleteResponse.getPrimaryTerm(),
                    finishRequest(serviceTimeNanos, ((OpenSearchThreadPoolExecutor) executor).getQueue().size());  
import org.opensearch.action.support.ActionFilters;
        return new PrimaryTermValidationProxy();
import org.opensearch.index.mapper.SourceToParse;
    protected long replicaOperationSize(BulkShardRequest request) {
                + shardId  
                DeleteRequest deleteRequest = (DeleteRequest) docWriteRequest;
            if (request.getPrimaryTerm() < replica.getOperationPrimaryTerm()) {  
                            );  
                        true,
    protected void dispatchedShardOperationOnReplica(BulkShardRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {  
                        }  
            // durability the fence is only validated at the upload interval, so the per-op fanout is retained.
            case CREATE:
    @Override
            private final ExecutorService executor = threadPool.executor(executorName);
    @Override
            // to the replica. When it arrives on the replica, there’s no guarantee that the replica has already  
                    indexRequest.isRetry(),
import org.opensearch.common.compress.CompressedXContent;  
                    deleteResponse.getVersion(),
        BulkShardRequest request,
        MappingUpdatePerformer mappingUpdater,  
 *  
                // refreshing and fsyncing. Therefore, we must force execution on the WRITE thread.  
            public void onRejection(Exception e) {
             * On the common failure path both are the <em>same</em> instance: a failed {@code TranslogBatchScope} stores
            }
    private static Engine.Result performOpOnReplica(
 * Licensed to Elasticsearch under one or more contributor  
    }  
import org.opensearch.transport.TransportRequest;
                    listener,
        IndexShard replica
            @Override  
    public ResolvedIndices resolveIndices(BulkShardRequest request) {
                    docWriteRequest  
        LongSupplier nowInMillisSupplier,
        assert shardId != null : "request shardId must be set";
import org.opensearch.core.tasks.TaskId;
                    "expected allocation id [{}] but found [{}]",
                    requestForResult = new BulkShardRequest(
    @Override  
                case NOOP:  
    private static void onComplete(Engine.Result r, BulkPrimaryExecutionContext context, UpdateHelper.Result updateResult) {  
                    }, () -> itemDoneListener.onResponse(null)));
                final MessageSupplier messageSupplier = () -> new ParameterizedMessage(
     * This action is the primary term validation action which is used for doing primary term validation with replicas.
                    itemDoneListener.onResponse(null);
                }
        this.remoteStorePressureService = remoteStorePressureService;
        UpdateHelper updateHelper,
     */
            assert operationResult != null : "operation result must never be null";
                );
                // Create a modified request with NONE refresh policy if no writes occurred  
package org.opensearch.action.bulk;
            final PrimaryTermValidationRequest validationRequest = new PrimaryTermValidationRequest(
        }  
     * aware that the primary has changed. This helps achieve the same. More details in java doc of
                try {
import org.opensearch.cluster.service.ClusterService;  
import java.util.Locale;
            // That is accepted rather than defended against - flipping to ASYNC is an explicit request for
                            concreteIndex,
             */  
                request.versionType(),
                // We're done, there's no more operations to execute so we resolve the wrapped listener  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        finishRequest(-1, -1);
            // and wait for them. The reason is concurrent requests. Request r1 which has new field f triggers a
            return Names.WRITE;
        TransportIndicesResolvingAction<BulkShardRequest> {
            } else {  
            // Close this thread's translog batch before the mapping update is requested. Its completion re-executes  
            private void finishTranslogBatch(@Nullable Exception bodyFailure) {
                    request.extraFieldValues()
                    indexResponse.getShardInfo(),
                                exceptionToResult(
    ) throws Exception {  
            result = primary.applyDeleteOperationOnPrimary(  
                            indexResponse.getSeqNo(),  
    }
                    deleteResponse.getResult()  
                            updateRequest,
                    );
                replica.shardId(),  
            case INDEX:  
                } else {
            case DELETE:  
                    continue; // ignore replication as it's a noop
            out.writeVLong(primaryTerm);
import java.util.Map;  
                    finishRequest(serviceTimeNanos, 0);
    /**  
        DocWriteRequest<?> docWriteRequest,  
        final BulkItemResponse executionResult = context.getExecutionResult();
                    this.replica.shardId(),
    /**  
    protected long primaryOperationSize(BulkShardRequest request) {  
        } else {
            if (isFailed) {  
        public String getDescription() {
                remoteStorePressureService.validateSegmentsUploadLag(request.shardId());  
import org.opensearch.action.update.UpdateResponse;
                    deleteResponse.getShardId(),
                    updateRequest,
            @Override
            return Names.SYSTEM_WRITE;  
                );
import java.util.function.Consumer;  
                        }
                    requestForResult.index(bulkShardRequest.index());  
            // interval-bounded durability, and every acknowledgement under it carries the same exposure.  
    }
                }  
import java.util.concurrent.ExecutorService;
            onCompletionListener.onResponse(new ReplicaResponse(SequenceNumbers.NO_OPS_PERFORMED, SequenceNumbers.NO_OPS_PERFORMED));
    }
            final String actualAllocationId = this.replica.routingEntry().allocationId().getId();
            // ASYNC skips its sync, leaving that one operation checked against neither witness until the next upload.
                    waitForMappingUpdate.accept(ActionListener.runAfter(new ActionListener<Void>() {  
                        @Override
import org.opensearch.common.util.concurrent.AbstractRunnable;
        ShardStateAction shardStateAction,  
                    requestForResult = bulkShardRequest;  
                                    primary,  
        return BulkAction.INSTANCE.transportOptions(settings);
            out.writeString(targetAllocationID);  
     */
    private static Engine.Result exceptionToResult(Exception e, IndexShard primary, boolean isDelete, long version) {
                case DELETED:  
                operationResult = performOpOnReplica(response.getResponse(), item.request(), replica);
                                context,
     */
import org.opensearch.transport.client.transport.NoNodeAvailableException;
                        if (executeBulkItemRequest(
                            context.mergeLocationToSync(translogBatch.flush());  
        }
            /**  
                    translate.updateSourceContentType(),
 */  
        for (int i = 0; i < request.items().length; i++) {
        try {  
                        // Fail all operations after a bulk rejection hit an action that waited for a mapping update and finish the request
        return new BulkShardResponse(in);  
            final UpdateRequest updateRequest = (UpdateRequest) context.getCurrent();
 * not use this file except in compliance with the License.
        }
     * @opensearch.internal  
                );
        ActionListener.completeWith(listener, () -> {
                );
            IndexShard replica,  
import java.io.IOException;
        }
                public void onResponse(Void v) {
            setPhase(task, "finished");  
        /**
                    assert context.isInitial();  
                            return;
        protected void doRun() throws Exception {
                            indexSourceAsBytes
 * specific language governing permissions and limitations
import org.opensearch.cluster.routing.ShardRouting;
 *
        Consumer<ActionListener<Void>> waitForMappingUpdate,
                final Exception failure = executionResult.getFailure().getCause();
            context.finishTranslogBatch();  
                            indexResponse.getVersion(),
                } else {
                    continue; // ignore replication as we didn't generate a sequence number for this request.  
            String nodeId = replica.currentNodeId();
 * Unless required by applicable law or agreed to in writing,
            }
             * <p>
        private final ReplicationTask task;
                            mappingUpdater,  
                && indexShard.indexSettings().getTranslogDurability() == Translog.Durability.REQUEST) {
import org.opensearch.telemetry.tracing.Tracer;
                }
        @Override
import org.opensearch.index.seqno.SequenceNumbers;
                operationResult = replica.markSeqNoAsNoop(
        } else {  
import org.opensearch.index.translog.Translog;
                    return true;
                    IndexRequest indexRequest = updateResult.action();  
                return ReplicationMode.NO_REPLICATION;  
                if (response.getFailure().getSeqNo() == SequenceNumbers.UNASSIGNED_SEQ_NO) {
                final IndexRequest indexRequest = (IndexRequest) docWriteRequest;
        TransportService transportService,
 * the Apache License, Version 2.0 (the "License"); you may
                long serviceTimeNanos = System.nanoTime() - startTime;
                updateResponse.setGetResult(getResult);
import org.opensearch.cluster.action.shard.ShardStateAction;
                return true;  
    @Override
        return ExceptionsHelper.unwrapCause(e) instanceof VersionConflictEngineException;  
                );
    private final String transportPrimaryTermValidationAction;  
                Exception bodyFailure = null;  
                @Override  
                primaryTerm,  
        if (isUpdate) {  
                        null,  
            });  
    }
            // (see MappingUpdatedAction.updateMappingOnClusterManager) we still need to protect against missing mappings
                    context.getPrimary().noopUpdate();
                request.isRetry()  
                assert false : "Unexpected request operation type on replica: " + docWriteRequest + ";primary result: " + primaryResponse;
            );
                case UPDATED:
                }
            BulkShardRequest::new,
 * SPDX-License-Identifier: Apache-2.0
    protected static final class PrimaryTermValidationRequest extends TransportRequest {
                );  
import org.opensearch.common.settings.Settings;  
            return "PrimaryTermValidationRequest ["
        public void onResponse(Releasable releasable) {
                version,
                if (executor instanceof OpenSearchThreadPoolExecutor) {
                            onComplete(  
                listener,
    }  
            PrimaryTermValidationRequest::new,
                    }
                    replica.getOperationPrimaryTerm()  
            }  
        } catch (RuntimeException e) {
            true,
                    indexRequest.extraFieldValues()  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
                    Locale.ROOT,
            response = new BulkItemResponse(operationResponse.getItemId(), DocWriteRequest.OpType.UPDATE, operationResponse.getFailure());
            // TODO - While removing remote store flag, this can be encapsulated to single class with common interface for backpressure  
import org.opensearch.action.index.IndexResponse;
            if (remoteStorePressureService.isSegmentsUploadBackpressureEnabled()) {
        RemoteStorePressureService remoteStorePressureService,  
                    indexRequest.id(),
import org.opensearch.action.support.replication.ReplicationOperation;
                );
        public long getPrimaryTerm() {
        private final PrimaryTermValidationRequest request;
                replica.allocationId().getId(),
    }
    private static final Logger logger = LogManager.getLogger(TransportShardBulkAction.class);  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
             * request's sync location. A no-op once the batch has been finished, which {@link #executeBulkItemRequest}
                    deleteResponse.getPrimaryTerm(),
            final DiscoveryNode node = clusterService.state().nodes().get(nodeId);
                request.ifPrimaryTerm()  
                final BulkShardRequest bulkShardRequest = context.getBulkShardRequest();
                        new CompressedXContent(result.getRequiredMappingUpdate(), ToXContent.EMPTY_PARAMS),  
import org.opensearch.cluster.node.DiscoveryNode;  
    public static void performOnPrimary(
                        MapperService.MergeReason.MAPPING_UPDATE_PREFLIGHT
import org.opensearch.core.index.shard.ShardId;  
                    translate.updatedSourceAsMap(),  
    }
    static BulkItemResponse processUpdateResponse(  
            }
                    response.getFailure().getSeqNo(),
        @Override
                    context.markAsCompleted(context.getExecutionResult());  
import org.opensearch.action.DocWriteRequest;
                    context.getPrimary().shardId(),
        BulkItemResponse operationResponse,  
                version,
import org.opensearch.index.shard.IndexShard;
            transportPrimaryTermValidationAction,  
                    throw new IllegalStateException("Illegal update operation " + updateResult.getResponseResult());  
 *
            response = processUpdateResponse((UpdateRequest) docWriteRequest, context.getConcreteIndex(), executionResult, updateResult);
                    MappingMetadata mappingMd = metadata.mapping();
            }
        }
 */
        }, mappingUpdateListener -> observer.waitForNextChange(new ClusterStateObserver.Listener() {
            clusterService,
        MappingUpdatedAction mappingUpdatedAction,
                result = replica.applyIndexOperationOnReplica(
                ),
            final IndexRequest request = context.getRequestToExecute();  
            }
        }  
                        }
                    request.routing(),  
                request.ifSeqNo(),  
    }
        @Override
     * term validation as well as logically replicate the data. With remote translog, the primary would make calls to
        public String getTargetAllocationID() {
        final UpdateRequest updateRequest,
        Translog.Location location = null;
    private static final Function<IndexShard, String> EXECUTOR_NAME_FUNCTION = shard -> {
    @Override  
        public void writeTo(StreamOutput out) throws IOException {
                } catch (Exception e) {  
        final boolean isUpdate = opType == DocWriteRequest.OpType.UPDATE;
                request.routing(),  
                });  
            // operation that reads REQUEST here (dropping the fanout) can be acknowledged after a concurrent flip to  
        }
            long primaryTerm,
        IndexingPressureService indexingPressureService,
             * permitted}), which would replace an {@code AlreadyClosedException} with an exception  
import org.opensearch.threadpool.ThreadPool.Names;  
                // realtime GET or the size cap may flush a chunk from another thread while this scope remains open;
import org.opensearch.index.shard.ShardNotFoundException;  
        public PrimaryTermValidationReplicaAction(
                    public boolean isForceExecution() {  
    /**  
            location = syncOperationResultOrThrow(operationResult, location);
        }
            private final BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(request, primary);
                            && (current.opType() == DocWriteRequest.OpType.UPDATE || current.opType() == DocWriteRequest.OpType.DELETE)) {
                if (response.getResponse().getResult() == DocWriteResponse.Result.NOOP) {
    }
            }  
            response = new BulkItemResponse(operationResponse.getItemId(), DocWriteRequest.OpType.UPDATE, updateResponse);  
 * Performs shard-level bulk (index, delete or update) operations
        return location;
                        return true;
                    logger.trace(messageSupplier, failure);  
                context.markOperationAsExecuted(result);
import org.opensearch.action.index.IndexRequest;  
                    primaryResponse.getVersion(),  
                    concreteIndex,
import org.opensearch.action.support.replication.TransportReplicationAction;  
        }  
     * Executes bulk item requests and handles request execution exceptions.
import org.opensearch.action.support.TransportIndicesResolvingAction;
        if (opType == DocWriteRequest.OpType.UPDATE) {
            // applied the new mapping, so there is no other option than to wait.
            transportService.sendRequest(node, transportPrimaryTermValidationAction, validationRequest, transportOptions, handler);
        }
        }
            private void finishRequest(long serviceTimeEWMAInNanos, int nodeQueueSize) {  
                    );
                break;
                // we may fail translating a update to index or delete operation  
            final DeleteRequest request = context.getRequestToExecute();
                    primaryTerm,  
import org.opensearch.core.common.io.stream.StreamInput;
        ActionFilters actionFilters,  
                }  
     * This is only applicable for TransportShardBulkAction because all writes (delete/update/single write/bulk)
            // execute translated update request
            ShardRouting replica,  
import org.opensearch.common.unit.TimeValue;
                );
            // field f might see the updated mapping (on the primary), and will therefore proceed to be replicated
                Engine.TranslogBatch beginResult = primary.beginTranslogBatch();  
        }
    protected TransportRequestOptions transportOptions(Settings settings) {  
        this.updateHelper = updateHelper;
            listener.onFailure(e);  
                        WriteRequest.RefreshPolicy.NONE,  
                    logger.debug(messageSupplier, failure);
