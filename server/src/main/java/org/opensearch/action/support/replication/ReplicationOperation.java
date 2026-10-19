                String message = String.format(Locale.ROOT, "failed to perform %s on replica %s", opType, shard);
     */
            }
         * <p>
        ReplicationProxy<ReplicaRequest> replicationProxy
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        /**
        final ReplicaRequest replicaRequest,
        totalShards.incrementAndGet();
         * @return the pending replication actions
                shardRouting,
        final ActionListener<ReplicaResponse> replicationListener = new ActionListener<ReplicaResponse>() {
                "[{}] not enough active copies to meet shard count of [{}] (have {}, needed {}), scheduling a retry. op [{}], "
        /**
            finishAsFailed(new UnavailableShardsException(primaryId, "{} Timeout: [{}]", activeShardCountFailure, request.timeout()));
         * Notifies the primary of a local checkpoint for the given allocation.
                logger.trace(
        final IndexShardRoutingTable shardRoutingTable = primary.getReplicationGroup().getRoutingTable();
         * @param primaryTerm  the primary term
            @Override
            ).build();
                + "] (have "
            }
        this.opType = opType;
         * Fail the specified shard if needed, removing it from the current set
            }
         * */
    private void updateCheckPoints(ShardRouting shard, LongSupplier localCheckpointSupplier, LongSupplier globalCheckpointSupplier) {
        this.threadPool = threadPool;
         *
                    updateCheckPoints(primary.routingEntry(), primary::localCheckpoint, primary::globalCheckpoint);
         *
    private void onNoLongerPrimary(Exception failure) {
        }
        this.replicationProxy = replicationProxy;
                replicaRequest,
import java.util.concurrent.atomic.AtomicInteger;
                if (failure instanceof ShardStateAction.NoLongerPrimaryShardException == false) {
        long computedGlobalCheckpoint();
            final ReplicationResponse.ShardInfo.Failure[] failuresArray;
        /**
        /**
        /**
                ? Integer.toString(shardRoutingTable.shards().size())
 * this work for additional information regarding copyright
                final Throwable cause = ExceptionsHelper.unwrapCause(e);
            primary.failShard(message, e);
    ) {
    ReplicaRequest extends ReplicationRequest<ReplicaRequest>,
            this(shardId, msg, null);
            // is valid for this replication group. If we would sample in the reverse, the global checkpoint might be based on a subset
        } catch (final AlreadyClosedException e) {
        /**
                // When the primary shard is closed mid-replication, we can't know whether the replica observed this
    private final long primaryTerm;
            final ReplicationGroup replicationGroup = primary.getReplicationGroup();
import org.opensearch.index.shard.ReplicationGroup;
        }
        if (pendingActions.decrementAndGet() == 0) {
            // when the node with the primary shard is gracefully shutting down.
                    decPendingAndFinishIfNeeded();
    }
        void failShard(String message, Exception exception);
/**
        Request request,
            );
                            restStatus,
            public void onFailure(Exception replicaException) {
         */
import java.util.concurrent.atomic.AtomicBoolean;
 */
        }
        /**
        };
            ShardRouting replica,
        this.initialRetryBackoffBound = initialRetryBackoffBound;
            }
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        }
        this.primaryTerm = primaryTerm;
import org.opensearch.core.common.io.stream.StreamInput;
        finishAsFailed(new RetryOnPrimaryException(primary.routingEntry().shardId(), message, failure));
         * Marks shard copy as stale if needed, removing its allocation id from
        /**
    }
                    );
                            primary.routingEntry().shardId(),
 * KIND, either express or implied.  See the License for the
         * @param message   the failure message
 *
        final String message;
        });
 * Licensed to Elasticsearch under one or more contributor
        final Throwable cause = ExceptionsHelper.unwrapCause(failure);
    }
         * @param maxSeqNoOfUpdatesOrDeletes the max seq_no of updates (index operations overwriting Lucene) or deletes on primary
        long primaryTerm,
/*
    private void finishAsFailed(Exception exception) {
                ActionListener.wrap(r -> decPendingAndFinishIfNeeded(), ReplicationOperation.this::onNoLongerPrimary)
         * @return the persisted global checkpoint
         */
         *
            }
         * Performs the specified request on the specified replica.
        }
        final RetryableAction<ReplicaResponse> replicationAction = new RetryableAction<ReplicaResponse>(
            setShard(shardId);
    }
        // for total stats, add number of unassigned shards and
                "node with primary [%s] is shutting down while failing replica shard",
        final String activeShardCountFailure = checkActiveShardCount();
            }
                replicasProxyConsumer.accept(listener);
     * <li>Coordination of the operation as a whole. This prevents the operation from terminating early if we haven't started any replica
 */
        for (String allocationId : replicationGroup.getUnavailableInSyncShards()) {
     *
 * Operation for a replication request
                allocationId,
         */
 * specific language governing permissions and limitations
import org.apache.logging.log4j.message.ParameterizedMessage;
            if (logger.isTraceEnabled()) {
        } else {
    /**
        public RetryOnPrimaryException(StreamInput in) throws IOException {
     * An encapsulation of an operation that is to be performed on the primary shard
            message = String.format(Locale.ROOT, "primary shard [%s] was demoted while failing replica shard", primary.routingEntry());
     * <li>The operation on the primary</li>
                    );
         *
        final ShardId primaryId = primaryRouting.shardId();
         */
                }
        final ActiveShardCount waitForActiveShards = request.waitForActiveShards();
 * @opensearch.internal
        final Consumer<ActionListener<ReplicaResponse>> replicasProxyConsumer,
            public void onResponse(Void aVoid) {
         * Returns the persisted local checkpoint on the primary shard.
                            replicaException
        this.primary = primary;
    /**
                );
        final ReplicationProxyRequest<ReplicaRequest> replicationProxyRequest
                primaryRouting,
                            replicaException,
        RequestT extends ReplicationRequest<RequestT>,
/*
                        replicaRequest
            retryTimeout,
                shardId,
                    + "request [{}]",
         * @param replica                    the shard this request should be executed on
                Locale.ROOT,
 * this file be licensed under the Apache-2.0 license or a
     *
        ReplicaRequestT extends ReplicationRequest<ReplicaRequestT>,
        );
            super(msg, cause);
                        "[{}] failure while performing [{}] on replica {}, request [{}]",
            final long maxSeqNoOfUpdatesOrDeletes = primary.maxSeqNoOfUpdatesOrDeletes();
    private void handlePrimaryResult(final PrimaryResultT primaryResult) {
        // if inSyncAllocationIds contains allocation ids of shards that don't exist in RoutingTable, mark copies as stale
                    ActionListener.wrap(r -> decPendingAndFinishIfNeeded(), ReplicationOperation.this::onNoLongerPrimary)
        }
import org.opensearch.index.shard.PrimaryShardClosedException;
        RetryOnPrimaryException(ShardId shardId, String msg) {
        /**
                        opType,
            pendingActions.incrementAndGet();
            super(in);
        ShardRouting routingEntry();
         */
         * listener when the primary request is completed. Yes, the primary request might complete before the method returns. Yes, it might
        this.request = request;
        long maxSeqNoOfUpdatesOrDeletes();
        void setShardInfo(ReplicationResponse.ShardInfo shardInfo);
                            shard.shardId(),
                shardRoutingTable.activeShards().size(),
        pendingReplicationActions.addPendingAction(allocationId, replicationAction);
            return;
            }
         * @param globalCheckpoint           the global checkpoint on the primary
                }
                    || cause instanceof OpenSearchRejectedExecutionException
                }
 *
import org.opensearch.action.support.RetryableAction;
    private final String opType;
                    return;
import org.opensearch.core.common.breaker.CircuitBreakingException;
                + ", needed "
         * routing entry for this primary
    private final Replicas<ReplicaRequest> replicasProxy;
            primary.updateLocalCheckpointForShard(shard.allocationId().getId(), localCheckpointSupplier.getAsLong());
        // number of initializing shards that are not ready yet to receive operations (recovery has not opened engine yet on the target)
 */
            replicationProxy.performOnReplicaProxy(proxyRequest, this::performOnReplica);
         */
        replicationAction.run();
 * GitHub history for details.
        }
     * they complete:
                : waitForActiveShards.toString();
                    throw new AssertionError("unexpected failure", failure);
import java.util.function.Consumer;
            // This would entail that some shards could learn about a global checkpoint that would be higher than its local checkpoint.
     * The result of the primary.
         * @return the computed global checkpoint
            final PendingReplicationActions pendingReplicationActions = primary.getPendingReplicationActions();
        RetryOnPrimaryException(ShardId shardId, String msg, Throwable cause) {
         */
                failuresArray = new ReplicationResponse.ShardInfo.Failure[shardReplicaFailures.size()];
    }
                resolvedShards,
         **/
        pendingActions.incrementAndGet();
            @Override
 * not use this file except in compliance with the License.
        final ReplicaRequest replicaRequest = replicationProxyRequest.getReplicaRequest();
import org.opensearch.core.rest.RestStatus;
import org.opensearch.ExceptionsHelper;
import org.opensearch.cluster.action.shard.ShardStateAction;
            public String toString() {
         * @return the persisted local checkpoint
        final ShardRouting shard = replicationProxyRequest.getShardRouting();
                + resolvedShards
            return null;
        this.replicasProxy = replicas;
        ) {
     * An interface to encapsulate the metadata needed from replica shards when they respond to operations performed on them.
        /**
 * ownership. Elasticsearch licenses this file to you under
    }
            // we also have to make sure to get the global checkpoint before the replication group, to ensure that the global checkpoint
         * @param listener result listener
            public void tryAction(ActionListener<ReplicaResponse> listener) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                            "primary shard was closed while replicating to " + shard,
         * is left up to the implementation.
        ThreadPool threadPool,
                // go out of sync with the primary
            }
        /**
        long globalCheckpoint();
/*
        if (activeShardCountFailure != null) {
                    shardReplicaFailures.add(
        final ReplicaRequest replicaRequest = primaryResult.replicaRequest();
         *
            // We prefer not to fail the primary to avoid unnecessary warning log
            replicationListener
     */
         *
            long primaryTerm,
            assert maxSeqNoOfUpdatesOrDeletes != SequenceNumbers.UNASSIGNED_SEQ_NO : "seqno_of_updates still uninitialized";
            // we have to capture the max_seq_no_of_updates after this request was completed on the primary to make sure the value of
    private void decPendingAndFinishIfNeeded() {
         */
            return null;  // not waiting for any shards
    }
                opType,
        Logger logger,
        if (replicaRequest != null) {
         *
 * The OpenSearch Contributors require contributions made to
            long maxSeqNoOfUpdatesOrDeletes,
import java.util.List;
import org.opensearch.core.index.shard.ShardId;
 * SPDX-License-Identifier: Apache-2.0
                replicaRequest.shardId(),
         *
         * Update the local knowledge of the global checkpoint for the specified allocation ID.
import org.opensearch.index.seqno.SequenceNumbers;
            public void onResponse(ReplicaResponse response) {
         * @param exception the exception that triggered the failure
         *
     */
         * The persisted local checkpoint for the shard.
         * @param message      a (short) description of the reason
         *                                   after this replication was executed on it.
         * also complete after. Deal with it.
import org.opensearch.transport.ConnectTransportException;
    private void markUnavailableShardsAsStale(ReplicaRequest replicaRequest, ReplicationGroup replicationGroup) {
 * Modifications Copyright OpenSearch Contributors. See
                waitForActiveShards,
                replicasProxy.failShardIfNeeded(
            }
import org.opensearch.common.unit.TimeValue;
                maxSeqNoOfUpdatesOrDeletes,
            @Override
     * operations and the primary finishes.</li>
        } else {
import org.opensearch.core.action.ActionListener;
            message = String.format(
    public interface ReplicaResponse {
    /**
                // TODO: Reach out to the cluster-manager node to get the latest shard state then report.
     * @opensearch.internal
    }
            }
                + waitForActiveShards
         *
        }
         * @param listener     a listener that will be notified when the failing shard has been removed from the in-sync set
    }
        final ShardRouting primaryRouting = primary.routingEntry();
         * Returns the persisted global checkpoint on the primary shard.
        void updateLocalCheckpointForShard(String allocationId, long checkpoint);
import org.opensearch.action.UnavailableShardsException;
    // exposed for tests
                        new ReplicationResponse.ShardInfo.Failure(
            // max_seq_no_of_updates on replica when this request is executed is at least the value on the primary when it was executed
                primaryTerm
import org.apache.logging.log4j.Logger;
        Primary<Request, ReplicaRequest, PrimaryResultT> primary,
        pendingActions.incrementAndGet(); // increase by 1 until we finish all primary coordination
    private void performOnReplica(
        }
        if (logger.isTraceEnabled()) {
    private void performOnReplicas(
     */
 */
}
    public interface Replicas<RequestT extends ReplicationRequest<RequestT>> {
         */
            if (shardReplicaFailures.isEmpty()) {
        PendingReplicationActions getPendingReplicationActions();
                    message,
    private final ReplicationProxy<ReplicaRequest> replicationProxy;
     * The number of pending sub-operations in this operation. This is incremented when the following operations start and decremented when
                }
        } catch (final Exception e) {
                try {
            primary.failShard(message, failure);
                        shard.shardId(),
         */
        void perform(RequestT request, ActionListener<PrimaryResultT> listener);
            public void onFailure(Exception e) {
         * @param primaryTerm                the primary term
            final long globalCheckpoint = primary.computedGlobalCheckpoint();
         * @param shardId      shard id
import java.io.IOException;
            final String message = String.format(Locale.ROOT, "primary failed updating local checkpoint for replica %s", shard);
    /**
            @Override
                    () -> new ParameterizedMessage(
         * Performs the given request on this primary. Yes, this returns as soon as it can with the request for the replicas and calls a
            @Override
import java.util.Collections;
import java.util.function.LongSupplier;
                + ").";
 * under the License.
         * the set of in-sync allocation ids. Whether marking as stale is needed
import org.opensearch.cluster.routing.ShardRouting;
            resultListener.onResponse(primaryResult);
            @Override
        void performOn(
        this.retryTimeout = retryTimeout;
                    shard,
            ReplicationProxyRequest<ReplicaRequest> proxyRequest = new Builder<ReplicaRequest>(
            @Override
                pendingReplicationActions.removeReplicationAction(allocationId, this);
                        new RetryOnPrimaryException(
        final boolean nodeIsClosing = cause instanceof NodeClosedException;
        TimeValue retryTimeout,
        void failShardIfNeeded(ShardRouting replica, long primaryTerm, String message, Exception exception, ActionListener<Void> listener);
    private final Primary<Request, ReplicaRequest, PrimaryResultT> primary;
         * @param listener     a listener that will be notified when the failing shard has been removed from the in-sync set
        void runPostReplicationActions(ActionListener<Void> listener);
         */
                logger.trace("[{}] op [{}] post replication actions failed for [{}]", primary.routingEntry().shardId(), opType, request);
                    replicaException
            replicasProxy.markShardCopyAsStaleIfNeeded(
         * @param exception    the original exception which caused the ReplicationOperation to request the shard to be failed
                shardReplicaFailures.toArray(failuresArray);
 * Unless required by applicable law or agreed to in writing,
            } else {
    }
 * compatible open source license.
                request
         * @param globalCheckpoint the global checkpoint
            // we are no longer the primary, fail ourselves and start over
        @Nullable
            RequestT replicaRequest,
    private final AtomicInteger totalShards = new AtomicInteger();
    private final Request request;
         *
    private final AtomicInteger successfulShards = new AtomicInteger();
public class ReplicationOperation<
                primaryTerm,
                    primaryTerm,
        final ShardRouting primaryRouting = primary.routingEntry();
        try {
        /**
         * @param allocationId allocation id to remove from the set of in-sync allocation ids
            );
            // on.
                // op. Fail the op instead so the coordinator retries against the new primary.
     * <ul>
                            shard.currentNodeId(),
import org.opensearch.action.support.ActiveShardCount;
    private final ThreadPool threadPool;
        if (finished.compareAndSet(false, true)) {
import org.opensearch.common.Nullable;
    private final List<ReplicationResponse.ShardInfo.Failure> shardReplicaFailures = Collections.synchronizedList(new ArrayList<>());
         * @param request the request to perform
         **/
     * Returns **null* if OK to proceed, or a string describing the reason to stop
            finish();
import org.opensearch.action.support.replication.ReplicationProxyRequest.Builder;
        final String allocationId = shard.allocationId().getId();
            // we have to make sure that every operation indexed into the primary after recovery start will also be replicated
            markUnavailableShardsAsStale(replicaRequest, replicationGroup);
            logger.trace("[{}] sending op [{}] to replica {} for request [{}]", shard.shardId(), opType, shard, replicaRequest);
     */
        final PendingReplicationActions pendingReplicationActions
        this.logger = logger;
            long globalCheckpoint,
    private final TimeValue retryTimeout;
        }
     */
        final PendingReplicationActions pendingReplicationActions = replicationProxyRequest.getPendingReplicationActions();
import org.opensearch.threadpool.ThreadPool;
     * An encapsulation of an operation that will be executed on the replica shards, if present.
     * @opensearch.internal
                finishAsFailed(e);
         */
        String opType,
         * Run actions to be triggered post replication
                super.onFinished();
         *
                    RestStatus restStatus = ExceptionsHelper.status(replicaException);
                failuresArray = ReplicationResponse.EMPTY;
            // to the recovery target. If we used an old replication group, we may miss a recovery that has started since then.
    /**
                if (ExceptionsHelper.unwrapCause(replicaException) instanceof PrimaryShardClosedException) {
            // the index was deleted or this shard was never activated after a relocation; fall through and finish normally
        final long globalCheckpoint,
import org.apache.lucene.store.AlreadyClosedException;
        final ShardId shardId = primary.routingEntry().shardId();
                    finishAsFailed(
                );
         * Returns the maximum seq_no of updates (index operations overwrite Lucene) or deletes on the primary.
    public static class RetryOnPrimaryException extends OpenSearchException {
    private final Logger logger;
    }
                        shard,
    private final TimeValue initialRetryBackoffBound;
        PrimaryResultT extends PrimaryResult<ReplicaRequestT>> {
            resultListener.onFailure(exception);
         * @return null if no operation needs to be sent to a replica
import org.opensearch.OpenSearchException;
package org.opensearch.action.support.replication;
        totalShards.addAndGet(replicationGroup.getSkippedShards().size());
        long localCheckpoint();
import org.opensearch.core.Assertions;
    public interface Primary<
         * (for example when the operation failed on the primary due to a parsing exception)
                    ),
        }
 * software distributed under the License is distributed on an
        }
    protected String checkActiveShardCount() {
 * the Apache License, Version 2.0 (the "License"); you may
        primary.perform(request, ActionListener.wrap(this::handlePrimaryResult, this::finishAsFailed));
     * <li>The operation on each replica</li>
            // we have to get the replication group after successfully indexing into the primary in order to honour recovery semantics.
    }
        if (finished.compareAndSet(false, true)) {
            threadPool,
     * </ul>
    ) {
         *
        primaryResult.runPostReplicationActions(new ActionListener<Void>() {
import org.opensearch.node.NodeClosedException;
    }
     */
                    decPendingAndFinishIfNeeded();
         * @return the replication group
                globalCheckpoint,
        }
 *
                            false
        }
    /**
        assert pendingActions.get() > 0 : "pending action count goes below 0 for request [" + request + "]";
                        )
import java.util.Locale;
                primary.routingEntry()
 * license agreements. See the NOTICE file distributed with
                    updateCheckPoints(shard, response::localCheckpoint, response::globalCheckpoint);
            // of the sampled replication group, and advanced further than what the given replication group would allow it to.
                // Only report "critical" exceptions
         * @param replicaRequest             the operation to perform
            ActionListener<ReplicaResponse> listener
            public boolean shouldRetry(Exception e) {
            logger,
                + shardRoutingTable.activeShards().size()
        /**
         * @param listener calllback that is invoked after post replication actions have completed
         * Fail the primary shard.
         * Note: The primary will use this information to advance the global checkpoint if possible.
        long localCheckpoint();
            primaryResult.setShardInfo(new ReplicationResponse.ShardInfo(totalShards.get(), successfulShards.get(), failuresArray));
         * @param checkpoint the *local* checkpoint for the shard
import org.opensearch.action.support.TransportActions;
    private final ActionListener<PrimaryResultT> resultListener;
                } finally {
        if (waitForActiveShards == ActiveShardCount.NONE) {
     * Checks whether we can perform a write based on the required active shard count setting.
        totalShards.incrementAndGet();
            // fail the primary but fall through and let the rest of operation processing complete
         * of active shards. Whether a failure is needed is left up to the
        /**
         * @param allocationId allocation ID of the shard corresponding to the supplied local checkpoint
                return "[" + replicaRequest + "][" + shard + "]";
                logger.trace("[{}] op [{}] completed on primary for request [{}]", primary.routingEntry().shardId(), opType, request);
        /**
            );
         */
        for (final ShardRouting shardRouting : replicationGroup.getReplicationTargets()) {
        void updateGlobalCheckpointForShard(String allocationId, long globalCheckpoint);
    ) {
            logger.trace(
        RequestT replicaRequest();
        /**
        /**
    public interface PrimaryResult<RequestT extends ReplicationRequest<RequestT>> {
         * @return the persisted global checkpoint
         * @param primaryTerm  the primary term
         * implementation.
         * Returns the global checkpoint computed on the primary shard.
    private void finish() {
        this.resultListener = listener;
                    replicaException,
    private volatile PrimaryResultT primaryResult = null;
                } finally {
    }
                return cause instanceof CircuitBreakingException
         *
         * Returns the pending replication actions on the primary shard
         * @param allocationId     the allocation ID to update the global checkpoint for
    private final AtomicBoolean finished = new AtomicBoolean();
    PrimaryResultT extends ReplicationOperation.PrimaryResult<ReplicaRequest>> {
        /**
         * @param listener                   callback for handling the response or failure
        };
        ReplicationGroup getReplicationGroup();
        void markShardCopyAsStaleIfNeeded(ShardId shardId, String allocationId, long primaryTerm, ActionListener<Void> listener);
            final String resolvedShards = waitForActiveShards == ActiveShardCount.ALL
                    || cause instanceof ConnectTransportException;
         */
        long globalCheckpoint();
    }
    }
    private final AtomicInteger pendingActions = new AtomicInteger();
            if (Assertions.ENABLED) {
 *
        final ReplicationGroup replicationGroup,
            initialRetryBackoffBound,
         * @param replica      shard to fail
        if (waitForActiveShards.enoughShardsActive(shardRoutingTable)) {
         * Returns the current replication group on the primary shard
            public void onFinished() {
                        )
    /**
                try {
         * This value must be captured after the execution of a replication request on the primary is completed.
                if (TransportActions.isShardNotAvailableException(replicaException) == false) {
    Request extends ReplicationRequest<Request>,
         */
    public ReplicationOperation(
    }
    public void execute() throws Exception {
        TimeValue initialRetryBackoffBound,
import java.util.ArrayList;
 * You may obtain a copy of the License at
                successfulShards.incrementAndGet();
            return "Not enough active copies to meet shard count of ["
            performOnReplicas(replicaRequest, globalCheckpoint, maxSeqNoOfUpdatesOrDeletes, replicationGroup, pendingReplicationActions);
            @Override
        }
                }
         * The persisted global checkpoint for the shard.
        final long maxSeqNoOfUpdatesOrDeletes,
                // TODO: fail shard? This will otherwise have the local / global checkpoint info lagging, or possibly have replicas
         * @return the local checkpoint
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        ActionListener<PrimaryResultT> listener,
                pendingReplicationActions,
        if (nodeIsClosing) {
     * Thrown if there are any errors retrying on primary
        Replicas<ReplicaRequest> replicas,
        this.primaryResult = primaryResult;
            primary.updateGlobalCheckpointForShard(shard.allocationId().getId(), globalCheckpointSupplier.getAsLong());
                successfulShards.incrementAndGet();
