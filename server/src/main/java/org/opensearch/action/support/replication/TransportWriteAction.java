    @Override  
        }
        Writeable.Reader<Request> request,
import org.opensearch.telemetry.tracing.SpanScope;  
     * @opensearch.internal
                return indexingPressureService.markPrimaryOperationLocalToCoordinatingNodeStarted(
                    SpanBuilder.from("dispatchedShardOperationOnPrimary", clusterService.localNode().getId(), request)  
        String actionName,  
            }  
     * callback used by {@link AsyncAfterWriteAction} to notify that all post  
    }  
        threadPool.executor(executor).execute(new ActionRunnable<PrimaryResult<ReplicaRequest, Response>>(listener) {
        Writeable.Reader<ReplicaRequest> replicaRequest,
        ActionListener<PrimaryResult<ReplicaRequest, Response>> listener
            transportService,  
                    if (forcedRefresh) {  
     * @param listener listener for the result of the operation on replica, including current translog location and operation
            transportService,  
     * Result of taking the action on the replica.
                    }
 */  
            // If this primary request was received directly from the network, we must mark a new primary
            }  
                        waitUntilRefresh = true;
        return ClusterBlockLevel.WRITE;
            }  
            actionFilters,
                }, logger).run();
        private void maybeFinish() {  
            this.location = location;
        ) {  
                new AsyncAfterWriteAction(replica, request, location, new RespondingWriteResult() {
                    }
        }
                }, logger).run();
            if ((sync = indexShard.getTranslogDurability() == Translog.Durability.REQUEST && location != null)) {
    /**
import java.util.concurrent.atomic.AtomicBoolean;  
 * @opensearch.internal  
        private final boolean sync;
            tracer,  
        if (operationResult.getFailure() != null) {
                    break;  
            }
public abstract class TransportWriteAction<
        } else {  
import org.opensearch.cluster.block.ClusterBlockLevel;  
         */  
        IndexShard primary,
                Span span = tracer.startSpan(
     * Result of taking the action on the primary.  
        private final RespondingWriteResult respond;  
            IndexShard replica,
     * NOTE: public for testing
                    public void onFailure(Exception ex) {
    /**
 *  
        /* here we are moving forward in the translog with each operation. Under the hood this might
        return executorFunction.apply(shard);  
import org.opensearch.core.common.io.stream.Writeable;
            ThreadPool.Names.SAME,
     *  
    @Override  
import org.opensearch.core.action.ActionListener;
        Response extends ReplicationResponse & WriteResponse> extends PrimaryResult<ReplicaRequest, Response> {
            this.logger = logger;
                    }
        return abstraction != null ? abstraction.isSystem() : systemIndices.isSystemIndex(shardId.getIndexName());
import org.apache.logging.log4j.message.ParameterizedMessage;
        this(  
                message,  
        private final ReplicaRequest request;
    protected class WriteActionReplicasProxy extends ReplicasProxy {  
        this.indexingPressureService = indexingPressureService;
 * The OpenSearch Contributors require contributions made to  
    @Override
        AdmissionControlActionType admissionControlActionType
        @Override  
                pendingOps.incrementAndGet();
     */
import org.opensearch.telemetry.tracing.listener.TraceableActionListener;
        }
            this.location = location;
                + "but found: ["
     * refresh policy
                + operationFailure
 * Unless required by applicable law or agreed to in writing,
                    SpanBuilder.from("dispatchedShardOperationOnReplica", clusterService.localNode().getId(), request)  
         * the previous file is fsynced on after closing if needed.*/
            assert failure instanceof MapperParsingException : "expected mapper parsing failures. got " + failure;
                + "] translog location and ["
            shardStateAction,
    protected String executor(IndexShard shard) {
    protected TransportWriteAction(
        }  
            final RespondingWriteResult respond,  
        public final IndexShard primary;
        // We pass ThreadPool.Names.SAME to the super class as we control the dispatching to the
        public void failShardIfNeeded(  
            return indexingPressureService.markPrimaryOperationStarted(request.shardId, primaryOperationSize(request), force(request));
            actionName,
        return indexingPressureService.markReplicaOperationStarted(request.shardId, replicaOperationSize(request), force(request));
    protected static Location syncOperationResultOrThrow(final Engine.Result operationResult, final Location currentLocation)
            @Nullable Location location,
     * This class encapsulates post write actions like async waits for
            }
    public static Location locationToSync(Location current, Location next) {  
        IndexShard replica,
        private final Logger logger;  
                case NONE:
/*  
        ActionFilters actionFilters,  
                }
        ) {
        private final Logger logger;
            } else {  
                    if (location != null) {  
        final String executor = executorFunction.apply(primary);
    }  
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;  
            settings,
    Request extends ReplicatedWriteRequest<Request>,  
            final WriteRequest<?> request,
                try (SpanScope spanScope = tracer.withSpanInScope(span)) {
import org.opensearch.common.settings.Settings;  
                } else {
    protected Releasable checkOperationLimits(Request request) {
        );
 * under the License.  
                    refreshed.set(true);  
        ActionListener<PrimaryResult<ReplicaRequest, Response>> listener
    Response extends ReplicationResponse & WriteResponse> extends TransportReplicationAction<Request, ReplicaRequest, Response> {
        );  
            protected void doRun() {
     * Called once per replica with a reference to the replica {@linkplain IndexShard} to modify.  
            indicesService,
    public static class WritePrimaryResult<  
     * @param listener listener for the result of the operation on primary, including current translog location and operation response
                        listener.onFailure(ex);  
 * specific language governing permissions and limitations
            threadPool,  
            if (localRerouteInitiatedByNodeClient) {
            executorFunction,
            boolean waitUntilRefresh = false;
 * ownership. Elasticsearch licenses this file to you under  
                replica.shardId(),
            super(operationFailure);
            ActionListener<Void> listener
 */
    ReplicaRequest extends ReplicatedWriteRequest<ReplicaRequest>,
            assert numPending >= 0 && numPending <= 2 : "numPending must either 2, 1 or 0 but was " + numPending;  
        Writeable.Reader<ReplicaRequest> replicaRequest,
 *
            /*
            }
             * We either respond immediately (i.e., if we do not fsync per request or wait for
import org.opensearch.cluster.service.ClusterService;  
     */
     * process actions have been executed
import org.opensearch.index.translog.Translog.Location;  
                    }
    /**
import org.opensearch.action.support.TransportActions;
            indexingPressureService,
     * This extends {@code TransportReplicationAction.ReplicasProxy} to do the
    protected abstract void dispatchedShardOperationOnPrimary(
                primaryTerm,
            ShardRouting replica,
            super(request, finalResponse, operationFailure);  
             * respond.
        String actionName,  
                });
        }
                });  
        }  
            location = locationToSync(currentLocation, operationResult.getTranslogLocation());
        return location;  
 *
    protected boolean force(ReplicatedWriteRequest<?> request) {
            if (waitUntilRefresh) {  
                default:
        ShardStateAction shardStateAction,
     * failing and stale-ing.
                    @Override
        Settings settings,
     * visible.
            if (finalFailure != null) {
                 */
        throws Exception {
import org.opensearch.index.IndexingPressureService;
import java.util.function.Function;  
            } else {
            forceExecutionOnPrimary,
        ReplicaRequest extends ReplicatedWriteRequest<ReplicaRequest>,
    }  
            if (numPending == 0) {
        this.systemIndices = systemIndices;  
            public boolean isForceExecution() {
            // If this primary request was received from a local reroute initiated by the node client, we
        Function<IndexShard, String> executorFunction,  
        SystemIndices systemIndices,  
    );  
import org.opensearch.cluster.routing.ShardRouting;
                    request.shardId,  
                case WAIT_UNTIL:
        /**
                replica.allocationId().getId(),  
            }  
                listener.onFailure(finalFailure);  
        return 0;  
                indexShard.sync(location, (ex) -> {  
            @Override
                    break;
    }
import org.opensearch.core.index.shard.ShardId;  
    }
     *  
     */  
            shardStateAction.remoteShardFailed(shardId, allocationId, primaryTerm, true, "mark copy as stale", null, listener);
            // primary delegation, after the primary relocation hand-off.  
     * Called on the primary with a reference to the primary {@linkplain IndexShard} to modify.
            true,  
            request,  
        ) {
        private final AtomicInteger pendingOps = new AtomicInteger(1);  
            final Logger logger
        Request request,  
            null
        private final boolean waitUntilRefresh;
 * SPDX-License-Identifier: Apache-2.0
/**
            ReplicaRequest request,
            long primaryTerm,
     * and failure async refresh is performed on the <code>primary</code> shard according to the <code>Request</code> refresh policy
        return forceExecutionOnPrimary || isSystemShard(request.shardId);  
            this.request = request;
            replicaRequest,
                }
            maybeFinish();
    @Override  
package org.opensearch.action.support.replication;
        void onFailure(Exception ex);
        // ThreadPool.Names.WRITE/ThreadPool.Names.SYSTEM_WRITE thread pools in this class.
        }
                    break;
            this.indexShard = indexShard;  
     * @opensearch.internal
    public ClusterBlockLevel indexBlockLevel() {
    @Override
                    indexShard.refresh("refresh_flag_index");
        private final WriteRequest<?> request;
 * Modifications Copyright OpenSearch Contributors. See
    );  
 * Base class for transport actions that modify data in some shard like index, delete, and shardBulk.  
        private final IndexShard replica;  
 * not use this file except in compliance with the License.
    }
import org.opensearch.telemetry.tracing.Span;
        private final AtomicBoolean refreshed = new AtomicBoolean(false);
     */
    }
        this.executorFunction = executorFunction;
                    refreshed.set(forcedRefresh);  
    private final Tracer tracer;
        Tracer tracer,
    private final Function<IndexShard, String> executorFunction;
        return indexingPressureService.markPrimaryOperationStarted(request.shardId, primaryOperationSize(request), force(request));
import org.opensearch.action.support.WriteResponse;
}
    public static class WriteReplicaResult<ReplicaRequest extends ReplicatedWriteRequest<ReplicaRequest>> extends ReplicaResult {  
                case IMMEDIATE:
import org.opensearch.transport.TransportService;
        assert next != null : "next operation can't be null";  
     */
import org.apache.logging.log4j.Logger;
        });
            admissionControlActionType
    }
            replicaRequest,
        return 0;  
            switch (request.getRefreshPolicy()) {  
 * Licensed to Elasticsearch under one or more contributor  
            }
        public WritePrimaryResult(
            ReplicaRequest request,
    /**
        /**
 *
        return ClusterBlockLevel.WRITE;  
                indexShard.addRefreshListener(location, forcedRefresh -> {
        @Override
    ) {
 * Allows performing async actions (e.g. refresh) after performing write operations on primary and replica shards
            clusterService,
    }
                }
        ActionFilters actionFilters,  
         * locations even though they are not in the same file. When the translog rolls over files
                Span span = tracer.startSpan(
                listener.onFailure(finalFailure);
        ReplicaRequest request,  
        private final Logger logger;
            settings,
        Request request,  
import org.opensearch.common.lease.Releasable;
        ShardStateAction shardStateAction,
 * You may obtain a copy of the License at  
        IndexingPressureService indexingPressureService,
                return true;  
        public void runPostReplicaActions(ActionListener<Void> listener) {  
            threadPool,  
    /**
            );  
                logger.warn(new ParameterizedMessage("[{}] {}", replica.shardId(), message), exception);
                + "] failure";  
         * tape where only the highest location needs to be fsynced in order to sync all previous  
            if (finalFailure != null) {
        boolean forceExecutionOnPrimary,
            } else {  
     * response and failure async refresh is performed on the <code>replica</code> shard according to the <code>ReplicaRequest</code>  
                 * We call this after replication because this might wait for a refresh and that can take a while.  
            }
            }  
                return force(request);  
     * <p>
        public void markShardCopyAsStaleIfNeeded(ShardId shardId, String allocationId, long primaryTerm, ActionListener<Void> listener) {
            this.primary = primary;
                    @Override
        assert current == null || current.compareTo(next) < 0 : "translog locations are not increasing";
import org.opensearch.action.support.WriteRequest;  
            public boolean isForceExecution() {
                assert pendingOps.get() > 0;
            this.respond = respond;
            Exception exception,
    protected ClusterBlockLevel globalBlockLevel() {
    }  
                    dispatchedShardOperationOnReplica(request, replica, TraceableActionListener.create(listener, span, tracer));  
                    @Override
     *  
 * KIND, either express or implied.  See the License for the
         * @param forcedRefresh <code>true</code> iff this write has caused a refresh  
            if (sync) {
        SystemIndices systemIndices,  
    /**
 * license agreements. See the NOTICE file distributed with
import org.opensearch.telemetry.tracing.SpanBuilder;
            this.request = request;  
                + location  
        void run() {  
            }
     *
                    public void onFailure(Exception ex) {
    protected abstract void dispatchedShardOperationOnReplica(
        ActionListener<ReplicaResult> listener
            @Nullable final Translog.Location location,
    protected ReplicationOperation.Replicas<ReplicaRequest> newReplicasProxy() {  
            @Nullable Location location,
    /**
        TransportService transportService,
                    }  
        final Location location;  
    }
 * this file be licensed under the Apache-2.0 license or a
    ) {  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected long primaryOperationSize(Request request) {
        ClusterService clusterService,
    ) {  
                    public void onSuccess(boolean forcedRefresh) {  
            indicesService,
                    primaryOperationSize(request)
            @Override
import org.opensearch.indices.SystemIndices;
    protected TransportWriteAction(
            actionFilters,
            final int numPending = pendingOps.decrementAndGet();
        /** calls the response listener if all pending operations have returned otherwise it just decrements the pending opts counter.*/
        IndicesService indicesService,  
     * <p>  
                    syncFailure.set(ex);
            @Nullable Exception operationFailure,
     * replicas, where a failure to execute the operation should fail
     *  
            this.logger = logger;  
         * Called on successful processing of all post write actions
     */
        @Override  
        Writeable.Reader<Request> request,
                    respond.onFailure(syncFailure.get());
    }  
                    }
                /*
                new AsyncAfterWriteAction(primary, replicaRequest, location, new RespondingWriteResult() {  
        super(  
    protected void shardOperationOnPrimary(
import org.opensearch.action.support.ActionFilters;
                return () -> {};
import org.opensearch.common.Nullable;
                if (syncFailure.get() != null) {  
    @Override
 * software distributed under the License is distributed on an
     * @opensearch.internal
import java.util.concurrent.atomic.AtomicReference;
        public void runPostReplicationActions(ActionListener<Void> listener) {
import org.opensearch.cluster.action.shard.ShardStateAction;
    protected void shardOperationOnReplica(ReplicaRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {
    }  
                try (SpanScope spanScope = tracer.withSpanInScope(span)) {
                    @Override
    @Override
        IndexingPressureService indexingPressureService,
            // must mark a new primary operation local to the coordinating node.  
            if (TransportActions.isShardNotAvailableException(exception) == false) {
     * translog syncs or waiting for a refresh to happen making the write operation  
            forceExecutionOnPrimary,  
                listener
    protected final IndexingPressureService indexingPressureService;
         * cross translog files which is ok since from the user perspective the translog is like a
 * compatible open source license.
    }
            this.replica = replica;
        private final IndexShard indexShard;
import org.opensearch.cluster.metadata.IndexAbstraction;
                );
            this.logger = logger;
                    throw new IllegalArgumentException("unknown refresh policy: " + request.getRefreshPolicy());
    protected long replicaOperationSize(ReplicaRequest request) {
        ) {  
                        listener.onFailure(ex);  
     * A proxy for <b>write</b> operations that need to be performed on the  
    }  
                    public void onSuccess(boolean forcedRefresh) {
     *
        private final AtomicReference<Exception> syncFailure = new AtomicReference<>(null);
import java.util.concurrent.atomic.AtomicInteger;
             */
        IndicesService indicesService,  
        }
/*
            @Nullable Response finalResponse,  
    }
        return new WriteActionReplicasProxy();
 * this work for additional information regarding copyright
        @Override
import org.opensearch.indices.IndicesService;
                        listener.onResponse(null);
         * Called on failure if a post action failed.
    }
        ThreadPool threadPool,
        public final Location location;
        Tracer tracer
import org.opensearch.index.engine.Engine;
        Settings settings,
                        finalResponseIfSuccessful.setForcedRefresh(forcedRefresh);  
        ClusterService clusterService,
    interface RespondingWriteResult {  
                );
                assert pendingOps.get() > 0;
    static final class AsyncAfterWriteAction {
    }  
                    maybeFinish();
            Exception failure = operationResult.getFailure();  
            // decrement pending by one, if there is nothing else to do we just respond with success
                );
import org.opensearch.threadpool.ThreadPool;  
            Logger logger
        this.tracer = tracer;
            }  
 */
        }
            systemIndices,
import org.opensearch.index.shard.IndexShard;
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            actionName,
/*  
        boolean forceExecutionOnPrimary,
            assert location == null || operationFailure == null : "expected either failure to be null or translog location to be null, "
                    respond.onSuccess(refreshed.get());  
            // check if any transient write operation failures should be bubbled up
        }
                    dispatchedShardOperationOnPrimary(request, primary, TraceableActionListener.create(listener, span, tracer));  
        threadPool.executor(executorFunction.apply(replica)).execute(new ActionRunnable<ReplicaResult>(listener) {
import org.opensearch.index.mapper.MapperParsingException;  
            String message,  
            }
        IndexShard primary,
     * the replica shard and/or mark the replica as stale.
            protected void doRun() {
    @Override  
        private final Location location;  
    protected Releasable checkReplicaLimits(ReplicaRequest request) {
    /** Syncs operation result to the translog or throws a shard not available failure */  
        return next;
            IndexShard primary,  
    }
            // operation. This happens if the write action skips the reroute step (ex: rsync) or during
        });
 * the Apache License, Version 2.0 (the "License"); you may
            @Override  
                        logger.warn("block until refresh ran out of slots and forced a refresh: [{}]", request);
    }  
            request,  
            indexShard.afterWriteOperation();  
 */  
                        pendingOps.incrementAndGet();
import org.opensearch.telemetry.tracing.Tracer;
import org.opensearch.index.translog.Translog;
             * refresh), or we there are past async operations and we wait for them to return to  
 * GitHub history for details.
            @Nullable Exception operationFailure,  
        ThreadPool threadPool,
                        listener.onResponse(null);
            @Override  
                 * This way we wait for the refresh in parallel on the primary and on the replica.
            this.location = location;  
            final IndexShard indexShard,  
                true,
    protected boolean isSystemShard(ShardId shardId) {  
        public final Location location;  
import org.opensearch.action.ActionRunnable;  
        } else {  
        void onSuccess(boolean forcedRefresh);
        final IndexAbstraction abstraction = clusterService.state().metadata().getIndicesLookup().get(shardId.getIndexName());
        TransportService transportService,
            Logger logger
    protected final SystemIndices systemIndices;
    protected Releasable checkPrimaryLimits(Request request, boolean rerouteWasLocal, boolean localRerouteInitiatedByNodeClient) {  
        Function<IndexShard, String> executorFunction,  
         */
        if (rerouteWasLocal) {
            shardStateAction,
                exception,
            shardStateAction.remoteShardFailed(
     */
     * @opensearch.internal  
            clusterService,
            throw failure;
    }  
        AsyncAfterWriteAction(
        public WriteReplicaResult(  
            assert pendingOps.get() >= 0 && pendingOps.get() <= 3 : "pendingOpts was: " + pendingOps.get();
                    maybeFinish();
            this.waitUntilRefresh = waitUntilRefresh;
