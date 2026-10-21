            }
        Request request,
            shardStateAction.remoteShardFailed(shardId, allocationId, primaryTerm, true, "mark copy as stale", null, listener);
    /**
            if (finalFailure != null) {
            final int numPending = pendingOps.decrementAndGet();
        private final Logger logger;
                + operationFailure
        private final AtomicReference<Exception> syncFailure = new AtomicReference<>(null);
import org.opensearch.common.settings.Settings;
            }
                    dispatchedShardOperationOnPrimary(request, primary, TraceableActionListener.create(listener, span, tracer));
    protected boolean isSystemShard(ShardId shardId) {
            final WriteRequest<?> request,
     *
            indicesService,
    public ClusterBlockLevel indexBlockLevel() {
                 * This way we wait for the refresh in parallel on the primary and on the replica.
                return true;
            shardStateAction,
                }, logger).run();
                    @Override
            this.request = request;
            clusterService,
                    break;
    /**
            );
    ) {
            // must mark a new primary operation local to the coordinating node.
            super(operationFailure);
     * This class encapsulates post write actions like async waits for
            transportService,
        IndexShard replica,
        );
 * You may obtain a copy of the License at
             * respond.
        return ClusterBlockLevel.WRITE;
        ShardStateAction shardStateAction,
        public WriteReplicaResult(
        @Override
 * not use this file except in compliance with the License.
}
     * @param listener listener for the result of the operation on primary, including current translog location and operation response
        if (operationResult.getFailure() != null) {
            this.waitUntilRefresh = waitUntilRefresh;
    }
        Function<IndexShard, String> executorFunction,
        }
            if (finalFailure != null) {
 * Unless required by applicable law or agreed to in writing,
         * the previous file is fsynced on after closing if needed.*/
 * software distributed under the License is distributed on an
    protected ReplicationOperation.Replicas<ReplicaRequest> newReplicasProxy() {
                + "but found: ["
        return new WriteActionReplicasProxy();
                 */
                    SpanBuilder.from("dispatchedShardOperationOnReplica", clusterService.localNode().getId(), request)
                default:
            true,
            long primaryTerm,
        } else {
            Logger logger
                    public void onSuccess(boolean forcedRefresh) {
            assert location == null || operationFailure == null : "expected either failure to be null or translog location to be null, "
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;
        @Override
    }
     * failing and stale-ing.
                    refreshed.set(true);
    protected ClusterBlockLevel globalBlockLevel() {
            IndexShard primary,
            threadPool,
            /*
    }
    /**
            @Nullable Response finalResponse,
                 * We call this after replication because this might wait for a refresh and that can take a while.
 *
    protected final SystemIndices systemIndices;
                    @Override
            clusterService,
    @Override
        Request request,
     */
     */
            }
        return indexingPressureService.markReplicaOperationStarted(request.shardId, replicaOperationSize(request), force(request));
             */
                    maybeFinish();
        public WritePrimaryResult(
                indexShard.addRefreshListener(location, forcedRefresh -> {
import java.util.concurrent.atomic.AtomicReference;
            Logger logger
                + "] failure";
        super(
                pendingOps.incrementAndGet();
import org.opensearch.action.support.WriteResponse;
                    break;
            final RespondingWriteResult respond,
            Exception exception,
            maybeFinish();
import org.opensearch.cluster.action.shard.ShardStateAction;
        ReplicaRequest request,
                );
                true,
    }
     * @opensearch.internal
                        listener.onResponse(null);
     * Result of taking the action on the replica.
        }
        }
            return indexingPressureService.markPrimaryOperationStarted(request.shardId, primaryOperationSize(request), force(request));
        private final Logger logger;
            } else {
                new AsyncAfterWriteAction(replica, request, location, new RespondingWriteResult() {
        return forceExecutionOnPrimary || isSystemShard(request.shardId);
import org.opensearch.cluster.service.ClusterService;
                    }
        String actionName,
    @Override
    protected String executor(IndexShard shard) {
     * NOTE: public for testing
            indexShard.afterWriteOperation();
                    dispatchedShardOperationOnReplica(request, replica, TraceableActionListener.create(listener, span, tracer));
import java.util.concurrent.atomic.AtomicBoolean;
                    @Override
            settings,
    ) {
 * Licensed to Elasticsearch under one or more contributor
        private final ReplicaRequest request;
    private final Function<IndexShard, String> executorFunction;
 * Modifications Copyright OpenSearch Contributors. See
    }
    protected class WriteActionReplicasProxy extends ReplicasProxy {
    private final Tracer tracer;
            }
            boolean waitUntilRefresh = false;
import org.opensearch.indices.IndicesService;
        AsyncAfterWriteAction(
    protected abstract void dispatchedShardOperationOnPrimary(
                if (syncFailure.get() != null) {
        public void markShardCopyAsStaleIfNeeded(ShardId shardId, String allocationId, long primaryTerm, ActionListener<Void> listener) {
     *
 * compatible open source license.
            }
     * Called on the primary with a reference to the primary {@linkplain IndexShard} to modify.
            // check if any transient write operation failures should be bubbled up
                    if (location != null) {
                    refreshed.set(forcedRefresh);
    protected void shardOperationOnReplica(ReplicaRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {
                );
/*
            if (waitUntilRefresh) {
        return 0;
        ClusterService clusterService,
                return indexingPressureService.markPrimaryOperationLocalToCoordinatingNodeStarted(
            shardStateAction.remoteShardFailed(
        threadPool.executor(executorFunction.apply(replica)).execute(new ActionRunnable<ReplicaResult>(listener) {
            replicaRequest,
            }
 *
import org.opensearch.core.action.ActionListener;
 * this file be licensed under the Apache-2.0 license or a
            }
        private void maybeFinish() {
    }
     */
            this.replica = replica;
         * tape where only the highest location needs to be fsynced in order to sync all previous
            request,
            actionFilters,
     * This extends {@code TransportReplicationAction.ReplicasProxy} to do the
                + "] translog location and ["
            }
    protected void shardOperationOnPrimary(
 * SPDX-License-Identifier: Apache-2.0
        this.systemIndices = systemIndices;
 */
        ActionListener<PrimaryResult<ReplicaRequest, Response>> listener
        threadPool.executor(executor).execute(new ActionRunnable<PrimaryResult<ReplicaRequest, Response>>(listener) {
            this.location = location;
    }
                }, logger).run();
                + location
            this.indexShard = indexShard;
                try (SpanScope spanScope = tracer.withSpanInScope(span)) {
    }
 * Base class for transport actions that modify data in some shard like index, delete, and shardBulk.
            this.location = location;
         */
 */
        ) {
            final Logger logger
            public boolean isForceExecution() {
        IndicesService indicesService,
            IndexShard replica,
    @Override
                }
                primaryTerm,
    protected Releasable checkPrimaryLimits(Request request, boolean rerouteWasLocal, boolean localRerouteInitiatedByNodeClient) {
                    }
        }
        private final WriteRequest<?> request;
    /**
        public final Location location;
        ) {
     */
    }
            @Override
        ThreadPool threadPool,
    static final class AsyncAfterWriteAction {
import org.opensearch.common.lease.Releasable;
 * GitHub history for details.
        void run() {
 * ownership. Elasticsearch licenses this file to you under
        ActionFilters actionFilters,
            null
                    @Override
                exception,
            // If this primary request was received directly from the network, we must mark a new primary
        assert current == null || current.compareTo(next) < 0 : "translog locations are not increasing";
        /* here we are moving forward in the translog with each operation. Under the hood this might
    @Override
import java.util.concurrent.atomic.AtomicInteger;
                return () -> {};
     *
     * visible.
     * A proxy for <b>write</b> operations that need to be performed on the
import java.util.function.Function;
             * We either respond immediately (i.e., if we do not fsync per request or wait for
        Settings settings,
        }
                assert pendingOps.get() > 0;
 * @opensearch.internal
import org.opensearch.action.support.TransportActions;
     * the replica shard and/or mark the replica as stale.
import org.opensearch.index.engine.Engine;
import org.opensearch.telemetry.tracing.listener.TraceableActionListener;
    }
    @Override
    public static class WriteReplicaResult<ReplicaRequest extends ReplicatedWriteRequest<ReplicaRequest>> extends ReplicaResult {
        IndexShard primary,
        // We pass ThreadPool.Names.SAME to the super class as we control the dispatching to the
     *
                    public void onFailure(Exception ex) {
    }
/*
     * callback used by {@link AsyncAfterWriteAction} to notify that all post
        ActionFilters actionFilters,
        IndexingPressureService indexingPressureService,
            admissionControlActionType
    protected boolean force(ReplicatedWriteRequest<?> request) {
            location = locationToSync(currentLocation, operationResult.getTranslogLocation());
            // If this primary request was received from a local reroute initiated by the node client, we
            if (localRerouteInitiatedByNodeClient) {
import org.opensearch.threadpool.ThreadPool;
            ActionListener<Void> listener
            }
        }
     * translog syncs or waiting for a refresh to happen making the write operation
            settings,
                Span span = tracer.startSpan(
                    maybeFinish();
                assert pendingOps.get() > 0;
        TransportService transportService,
        }
            forceExecutionOnPrimary,
            ReplicaRequest request,
        ClusterService clusterService,
import org.opensearch.index.shard.IndexShard;
import org.opensearch.telemetry.tracing.Tracer;
    }
        Response extends ReplicationResponse & WriteResponse> extends PrimaryResult<ReplicaRequest, Response> {
     *
     */
            @Nullable Location location,
 * license agreements. See the NOTICE file distributed with
    }
            indicesService,
                        finalResponseIfSuccessful.setForcedRefresh(forcedRefresh);
import org.opensearch.cluster.metadata.IndexAbstraction;
    Response extends ReplicationResponse & WriteResponse> extends TransportReplicationAction<Request, ReplicaRequest, Response> {
     * response and failure async refresh is performed on the <code>replica</code> shard according to the <code>ReplicaRequest</code>
         * locations even though they are not in the same file. When the translog rolls over files
            protected void doRun() {
        private final IndexShard replica;
            shardStateAction,
            threadPool,
        if (rerouteWasLocal) {
            forceExecutionOnPrimary,
                    break;
        @Override
        /** calls the response listener if all pending operations have returned otherwise it just decrements the pending opts counter.*/
        IndexingPressureService indexingPressureService,
    }
            this.logger = logger;
        return location;
            } else {
        public void runPostReplicaActions(ActionListener<Void> listener) {
            @Nullable final Translog.Location location,
            } else {
            transportService,
            @Nullable Exception operationFailure,
     * @opensearch.internal
        public void failShardIfNeeded(
                        pendingOps.incrementAndGet();
        );
    );
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.logging.log4j.message.ParameterizedMessage;
        }
    protected final IndexingPressureService indexingPressureService;
            if (sync) {
        Writeable.Reader<Request> request,
import org.opensearch.common.Nullable;
import org.opensearch.index.mapper.MapperParsingException;
                return force(request);
                logger.warn(new ParameterizedMessage("[{}] {}", replica.shardId(), message), exception);
        assert next != null : "next operation can't be null";
            actionName,
            public boolean isForceExecution() {
            switch (request.getRefreshPolicy()) {
        Writeable.Reader<Request> request,
                        logger.warn("block until refresh ran out of slots and forced a refresh: [{}]", request);
            }
    public static Location locationToSync(Location current, Location next) {
                case IMMEDIATE:
    Request extends ReplicatedWriteRequest<Request>,
 *     http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
        /**
                    primaryOperationSize(request)
                        listener.onFailure(ex);
        this.tracer = tracer;
        throws Exception {
                }
                    respond.onSuccess(refreshed.get());
            @Override
            if (TransportActions.isShardNotAvailableException(exception) == false) {
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.support.replication;
                    indexShard.refresh("refresh_flag_index");
            this.request = request;
import org.opensearch.cluster.routing.ShardRouting;
                case NONE:
public abstract class TransportWriteAction<
            actionFilters,
            String message,
        this(
        IndexShard primary,
        final Location location;
        ) {
 * Allows performing async actions (e.g. refresh) after performing write operations on primary and replica shards
        ThreadPool threadPool,
        this.executorFunction = executorFunction;
                Span span = tracer.startSpan(
        IndicesService indicesService,
import org.apache.logging.log4j.Logger;
                        listener.onFailure(ex);
         * Called on failure if a post action failed.
                /*
                replica.shardId(),
import org.opensearch.indices.SystemIndices;
        void onFailure(Exception ex);
        ) {
                indexShard.sync(location, (ex) -> {
        @Override
    ReplicaRequest extends ReplicatedWriteRequest<ReplicaRequest>,
        });
                    respond.onFailure(syncFailure.get());
        } else {
 * The OpenSearch Contributors require contributions made to
        SystemIndices systemIndices,
        }
        return indexingPressureService.markPrimaryOperationStarted(request.shardId, primaryOperationSize(request), force(request));
     *
        /**
                message,
                try (SpanScope spanScope = tracer.withSpanInScope(span)) {
                });
                    public void onSuccess(boolean forcedRefresh) {
            throw failure;
        this.indexingPressureService = indexingPressureService;
import org.opensearch.index.translog.Translog;
            ShardRouting replica,
            if (numPending == 0) {
        SystemIndices systemIndices,
        Function<IndexShard, String> executorFunction,
            assert pendingOps.get() >= 0 && pendingOps.get() <= 3 : "pendingOpts was: " + pendingOps.get();
        public final IndexShard primary;
import org.opensearch.action.ActionRunnable;
        final IndexAbstraction abstraction = clusterService.state().metadata().getIndicesLookup().get(shardId.getIndexName());
                        listener.onResponse(null);
                listener.onFailure(finalFailure);
                    }
    );
            }
                    request.shardId,
     * <p>
    public static class WritePrimaryResult<
import org.opensearch.index.IndexingPressureService;
 * this work for additional information regarding copyright
            super(request, finalResponse, operationFailure);
        private final IndexShard indexShard;
    @Override
            @Nullable Location location,
    }
     * <p>
            replicaRequest,
            @Override
import org.opensearch.telemetry.tracing.SpanScope;
 */
    protected Releasable checkOperationLimits(Request request) {
                });
            this.location = location;
        public void runPostReplicationActions(ActionListener<Void> listener) {
 */
/*
        return 0;
            this.primary = primary;
                    throw new IllegalArgumentException("unknown refresh policy: " + request.getRefreshPolicy());
    protected static Location syncOperationResultOrThrow(final Engine.Result operationResult, final Location currentLocation)
            }
        ActionListener<PrimaryResult<ReplicaRequest, Response>> listener
            systemIndices,
 * the Apache License, Version 2.0 (the "License"); you may
    /** Syncs operation result to the translog or throws a shard not available failure */
        Settings settings,
import org.opensearch.action.support.ActionFilters;
        private final Logger logger;
     * refresh policy
            final IndexShard indexShard,
import org.opensearch.action.support.WriteRequest;
     * Called once per replica with a reference to the replica {@linkplain IndexShard} to modify.
                    }
        private final AtomicBoolean refreshed = new AtomicBoolean(false);
    interface RespondingWriteResult {
            }
 *
import org.opensearch.core.index.shard.ShardId;
        Writeable.Reader<ReplicaRequest> replicaRequest,
         */
            this.logger = logger;
 *
    }
    }
                listener.onFailure(finalFailure);
         * Called on successful processing of all post write actions
            ReplicaRequest request,
                listener
    protected TransportWriteAction(
        return executorFunction.apply(shard);
import org.opensearch.telemetry.tracing.SpanBuilder;
            executorFunction,
                replica.allocationId().getId(),
        ReplicaRequest extends ReplicatedWriteRequest<ReplicaRequest>,
        Writeable.Reader<ReplicaRequest> replicaRequest,
            Exception failure = operationResult.getFailure();
        // ThreadPool.Names.WRITE/ThreadPool.Names.SYSTEM_WRITE thread pools in this class.
    /**
            @Nullable Exception operationFailure,
            ThreadPool.Names.SAME,
                    public void onFailure(Exception ex) {
    @Override
import org.opensearch.telemetry.tracing.Span;
        private final AtomicInteger pendingOps = new AtomicInteger(1);
            indexingPressureService,
    }
        private final RespondingWriteResult respond;
    protected abstract void dispatchedShardOperationOnReplica(
                    }
        boolean forceExecutionOnPrimary,
             * refresh), or we there are past async operations and we wait for them to return to
            // operation. This happens if the write action skips the reroute step (ex: rsync) or during
            this.logger = logger;
        private final boolean waitUntilRefresh;
        });
            protected void doRun() {
            assert numPending >= 0 && numPending <= 2 : "numPending must either 2, 1 or 0 but was " + numPending;
        }
     * replicas, where a failure to execute the operation should fail
        AdmissionControlActionType admissionControlActionType
/**
        boolean forceExecutionOnPrimary,
        ShardStateAction shardStateAction,
        TransportService transportService,
        ActionListener<ReplicaResult> listener
    protected Releasable checkReplicaLimits(ReplicaRequest request) {
                    if (forcedRefresh) {
    protected long primaryOperationSize(Request request) {
        private final Location location;
            // primary delegation, after the primary relocation hand-off.
     * and failure async refresh is performed on the <code>primary</code> shard according to the <code>Request</code> refresh policy
                    SpanBuilder.from("dispatchedShardOperationOnPrimary", clusterService.localNode().getId(), request)
    }
     */
                        waitUntilRefresh = true;
import org.opensearch.index.translog.Translog.Location;
    protected TransportWriteAction(
     * Result of taking the action on the primary.
     * @opensearch.internal
                }
                    syncFailure.set(ex);
    @Override
            actionName,
            if ((sync = indexShard.getTranslogDurability() == Translog.Durability.REQUEST && location != null)) {
        return next;
        return abstraction != null ? abstraction.isSystem() : systemIndices.isSystemIndex(shardId.getIndexName());
    /**
            assert failure instanceof MapperParsingException : "expected mapper parsing failures. got " + failure;
                    }
     * process actions have been executed
     */
    }
        String actionName,
        public final Location location;
                } else {
    protected long replicaOperationSize(ReplicaRequest request) {
import org.opensearch.cluster.block.ClusterBlockLevel;
            tracer,
         * @param forcedRefresh <code>true</code> iff this write has caused a refresh
    ) {
        return ClusterBlockLevel.WRITE;
     * @opensearch.internal
            this.respond = respond;
        private final boolean sync;
        final String executor = executorFunction.apply(primary);
 * under the License.
import org.opensearch.transport.TransportService;
            // decrement pending by one, if there is nothing else to do we just respond with success
import org.opensearch.core.common.io.stream.Writeable;
    /**
         * cross translog files which is ok since from the user perspective the translog is like a
     * @param listener listener for the result of the operation on replica, including current translog location and operation
                new AsyncAfterWriteAction(primary, replicaRequest, location, new RespondingWriteResult() {
                );
        Tracer tracer
                case WAIT_UNTIL:
    }
            request,
            @Override
    }
        Tracer tracer,
        void onSuccess(boolean forcedRefresh);
