        ThreadPool threadPool,
 * compatible open source license.
            // to the recovery target. If we used an old replication group, we may miss a recovery that has started since then.  
        long maxSeqNoOfUpdatesOrDeletes();
 * You may obtain a copy of the License at  
                replicaRequest,
    }  
import java.util.function.Consumer;  
         * @param listener result listener  
 * The OpenSearch Contributors require contributions made to  
            RequestT replicaRequest,
    public void execute() throws Exception {
    /**
        final ReplicationProxyRequest<ReplicaRequest> replicationProxyRequest
import org.opensearch.action.support.ActiveShardCount;  
    private void handlePrimaryResult(final PrimaryResultT primaryResult) {  
         */
            threadPool,  
         *
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 * software distributed under the License is distributed on an
            long primaryTerm,
                    updateCheckPoints(shard, response::localCheckpoint, response::globalCheckpoint);  
                    );  
            final String resolvedShards = waitForActiveShards == ActiveShardCount.ALL
            markUnavailableShardsAsStale(replicaRequest, replicationGroup);
import java.util.function.LongSupplier;
    Request extends ReplicationRequest<Request>,  
            super(msg, cause);  
import org.opensearch.ExceptionsHelper;  
         */
        TimeValue initialRetryBackoffBound,
     * Checks whether we can perform a write based on the required active shard count setting.  
/*  
         * Returns the persisted local checkpoint on the primary shard.
            // we have to make sure that every operation indexed into the primary after recovery start will also be replicated
     * An interface to encapsulate the metadata needed from replica shards when they respond to operations performed on them.
import org.apache.logging.log4j.Logger;  
    private final Logger logger;  
    private void updateCheckPoints(ShardRouting shard, LongSupplier localCheckpointSupplier, LongSupplier globalCheckpointSupplier) {  
import org.opensearch.core.index.shard.ShardId;
        final String activeShardCountFailure = checkActiveShardCount();
import java.io.IOException;
        final RetryableAction<ReplicaResponse> replicationAction = new RetryableAction<ReplicaResponse>(
        final boolean nodeIsClosing = cause instanceof NodeClosedException;  
         *  
        }  
    }  
        PrimaryResultT extends PrimaryResult<ReplicaRequestT>> {  
        ReplicaRequestT extends ReplicationRequest<ReplicaRequestT>,
 * Unless required by applicable law or agreed to in writing,
            logger,
         */
                    || cause instanceof OpenSearchRejectedExecutionException  
    private final long primaryTerm;
 * specific language governing permissions and limitations
        // for total stats, add number of unassigned shards and
                replicaRequest.shardId(),
import java.util.Collections;
        for (String allocationId : replicationGroup.getUnavailableInSyncShards()) {
         * @param shardId      shard id
        );  
     * Returns **null* if OK to proceed, or a string describing the reason to stop
        this.resultListener = listener;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    }
    public interface ReplicaResponse {
        final ShardRouting primaryRouting = primary.routingEntry();  
        finishAsFailed(new RetryOnPrimaryException(primary.routingEntry().shardId(), message, failure));
                ? Integer.toString(shardRoutingTable.shards().size())
                logger.trace("[{}] op [{}] completed on primary for request [{}]", primary.routingEntry().shardId(), opType, request);
        }  
            replicationListener  
                ActionListener.wrap(r -> decPendingAndFinishIfNeeded(), ReplicationOperation.this::onNoLongerPrimary)
         *
            logger.trace("[{}] sending op [{}] to replica {} for request [{}]", shard.shardId(), opType, shard, replicaRequest);  
            ActionListener<ReplicaResponse> listener
    private final Primary<Request, ReplicaRequest, PrimaryResultT> primary;
                opType,
         * Fail the specified shard if needed, removing it from the current set  
        if (nodeIsClosing) {
        }
            }
            @Override  
        Logger logger,
        primary.perform(request, ActionListener.wrap(this::handlePrimaryResult, this::finishAsFailed));  
                return cause instanceof CircuitBreakingException
            @Override
         */  
                + ").";
                        shard,
        pendingReplicationActions.addPendingAction(allocationId, replicationAction);
     * operations and the primary finishes.</li>  
                        )
         * Notifies the primary of a local checkpoint for the given allocation.
/**  
        ) {
 */
            );
            if (logger.isTraceEnabled()) {
            retryTimeout,
         *                                   after this replication was executed on it.
                + waitForActiveShards  
        if (logger.isTraceEnabled()) {
         * Returns the persisted global checkpoint on the primary shard.
/*
         * listener when the primary request is completed. Yes, the primary request might complete before the method returns. Yes, it might
        /**
         * The persisted local checkpoint for the shard.
         * @param primaryTerm  the primary term
        final ReplicaRequest replicaRequest = replicationProxyRequest.getReplicaRequest();
                    throw new AssertionError("unexpected failure", failure);
            setShard(shardId);
            // the index was deleted or this shard was never activated after a relocation; fall through and finish normally
         * (for example when the operation failed on the primary due to a parsing exception)  
        this.primaryTerm = primaryTerm;
            this(shardId, msg, null);
        void failShardIfNeeded(ShardRouting replica, long primaryTerm, String message, Exception exception, ActionListener<Void> listener);
            }  
        }  
     * @opensearch.internal
     * The result of the primary.
import org.opensearch.index.seqno.SequenceNumbers;
    }  
    }
         */  
         *
                    || cause instanceof ConnectTransportException;
                resolvedShards,
         * Returns the pending replication actions on the primary shard  
            long globalCheckpoint,  
         *
     */  
            assert maxSeqNoOfUpdatesOrDeletes != SequenceNumbers.UNASSIGNED_SEQ_NO : "seqno_of_updates still uninitialized";
                // op. Fail the op instead so the coordinator retries against the new primary.
        if (waitForActiveShards == ActiveShardCount.NONE) {  
        void updateGlobalCheckpointForShard(String allocationId, long globalCheckpoint);
         * @return the replication group
         * @param listener calllback that is invoked after post replication actions have completed  
            logger.trace(
                pendingReplicationActions,
            return null;  // not waiting for any shards
        /**
        final Throwable cause = ExceptionsHelper.unwrapCause(failure);
import org.opensearch.cluster.action.shard.ShardStateAction;
         * @param replica      shard to fail
         */
                    replicaException
    }
        for (final ShardRouting shardRouting : replicationGroup.getReplicationTargets()) {
    ReplicaRequest extends ReplicationRequest<ReplicaRequest>,
import org.opensearch.node.NodeClosedException;
            public String toString() {
                } finally {
 * under the License.  
         **/
         */
        void perform(RequestT request, ActionListener<PrimaryResultT> listener);
         * @param exception the exception that triggered the failure
    public static class RetryOnPrimaryException extends OpenSearchException {  
        try {
            );
                }
    public interface Primary<  
        ShardRouting routingEntry();
    public interface PrimaryResult<RequestT extends ReplicationRequest<RequestT>> {
    protected String checkActiveShardCount() {  
        }  
            public void onFailure(Exception replicaException) {
import java.util.concurrent.atomic.AtomicInteger;
        public RetryOnPrimaryException(StreamInput in) throws IOException {
                shardRoutingTable.activeShards().size(),  
     */
         * implementation.
        } catch (final AlreadyClosedException e) {
         * is left up to the implementation.  
                final Throwable cause = ExceptionsHelper.unwrapCause(e);
import org.opensearch.core.action.ActionListener;
            // we are no longer the primary, fail ourselves and start over
 * this file be licensed under the Apache-2.0 license or a
        /**
            return "Not enough active copies to meet shard count of ["
                        new RetryOnPrimaryException(
import org.opensearch.index.shard.ReplicationGroup;  
import java.util.Locale;  
            finish();  
 * @opensearch.internal  
        pendingActions.incrementAndGet(); // increase by 1 until we finish all primary coordination
            public void onFailure(Exception e) {
                            replicaException,
         * @param message   the failure message
            performOnReplicas(replicaRequest, globalCheckpoint, maxSeqNoOfUpdatesOrDeletes, replicationGroup, pendingReplicationActions);
        replicationAction.run();  
     */
            message = String.format(Locale.ROOT, "primary shard [%s] was demoted while failing replica shard", primary.routingEntry());
            // is valid for this replication group. If we would sample in the reverse, the global checkpoint might be based on a subset
        this.primaryResult = primaryResult;
package org.opensearch.action.support.replication;
            // of the sampled replication group, and advanced further than what the given replication group would allow it to.  
    private final AtomicInteger successfulShards = new AtomicInteger();
        /**
    private final ActionListener<PrimaryResultT> resultListener;
                + resolvedShards
         * of active shards. Whether a failure is needed is left up to the
    private void finishAsFailed(Exception exception) {  
                            primary.routingEntry().shardId(),
    private final Replicas<ReplicaRequest> replicasProxy;  
        /**
                primaryTerm,  
         *
    /**
         *
                // TODO: fail shard? This will otherwise have the local / global checkpoint info lagging, or possibly have replicas
                // TODO: Reach out to the cluster-manager node to get the latest shard state then report.
        long globalCheckpoint();  
        /**
                failuresArray = new ReplicationResponse.ShardInfo.Failure[shardReplicaFailures.size()];
        final String allocationId = shard.allocationId().getId();  
        };
            final String message = String.format(Locale.ROOT, "primary failed updating local checkpoint for replica %s", shard);
    ) {
        }
            @Override  
                finishAsFailed(e);  
        void failShard(String message, Exception exception);
                    message,  
    private final AtomicBoolean finished = new AtomicBoolean();
            if (Assertions.ENABLED) {
                globalCheckpoint,
    private void markUnavailableShardsAsStale(ReplicaRequest replicaRequest, ReplicationGroup replicationGroup) {
            // we have to get the replication group after successfully indexing into the primary in order to honour recovery semantics.
         * @return the computed global checkpoint
import org.apache.lucene.store.AlreadyClosedException;
                    () -> new ParameterizedMessage(  
    private void onNoLongerPrimary(Exception failure) {
                        replicaRequest
    }
        /**
        } else {
         */
            // This would entail that some shards could learn about a global checkpoint that would be higher than its local checkpoint.
            // fail the primary but fall through and let the rest of operation processing complete
    private final AtomicInteger pendingActions = new AtomicInteger();  
        void setShardInfo(ReplicationResponse.ShardInfo shardInfo);
            @Override  
        final Consumer<ActionListener<ReplicaResponse>> replicasProxyConsumer,
         **/
 *  
                try {  
                // Only report "critical" exceptions  
    }
     * @opensearch.internal  
        // number of initializing shards that are not ready yet to receive operations (recovery has not opened engine yet on the target)
        /**
     */
            final PendingReplicationActions pendingReplicationActions = primary.getPendingReplicationActions();  
        /**
public class ReplicationOperation<
     *  
                    return;
            super(in);
         * @return null if no operation needs to be sent to a replica
        Request request,  
 */
         *  
         * @param allocationId     the allocation ID to update the global checkpoint for
                            shard.shardId(),  
import org.opensearch.action.UnavailableShardsException;
    private void performOnReplica(  
         * Returns the current replication group on the primary shard
            primary.updateGlobalCheckpointForShard(shard.allocationId().getId(), globalCheckpointSupplier.getAsLong());  
            final long globalCheckpoint = primary.computedGlobalCheckpoint();
                shardRouting,  
import java.util.ArrayList;  
         */
        /**  
         * Note: The primary will use this information to advance the global checkpoint if possible.
         * @param listener                   callback for handling the response or failure  
         */  
 * KIND, either express or implied.  See the License for the
                shardReplicaFailures.toArray(failuresArray);
                    shardReplicaFailures.add(
     * Thrown if there are any errors retrying on primary
                            "primary shard was closed while replicating to " + shard,  
        long localCheckpoint();  
            }  
            finishAsFailed(new UnavailableShardsException(primaryId, "{} Timeout: [{}]", activeShardCountFailure, request.timeout()));  
    ) {  
         *
     * The number of pending sub-operations in this operation. This is incremented when the following operations start and decremented when  
            primary.updateLocalCheckpointForShard(shard.allocationId().getId(), localCheckpointSupplier.getAsLong());
        PendingReplicationActions getPendingReplicationActions();
 * Modifications Copyright OpenSearch Contributors. See  
         * @param maxSeqNoOfUpdatesOrDeletes the max seq_no of updates (index operations overwriting Lucene) or deletes on primary
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.rest.RestStatus;  
                }  
         * Returns the maximum seq_no of updates (index operations overwrite Lucene) or deletes on the primary.
     * they complete:
        final ReplicaRequest replicaRequest,
                String message = String.format(Locale.ROOT, "failed to perform %s on replica %s", opType, shard);
            // on.
 * Licensed to Elasticsearch under one or more contributor  
     */
                }
         * the set of in-sync allocation ids. Whether marking as stale is needed
        this.request = request;
import org.opensearch.action.support.TransportActions;
        final ShardId shardId = primary.routingEntry().shardId();
    private final Request request;
        }  
        }
            public void onFinished() {  
        /**
import org.opensearch.core.common.breaker.CircuitBreakingException;
         * @param replicaRequest             the operation to perform
        final ReplicaRequest replicaRequest = primaryResult.replicaRequest();
                // When the primary shard is closed mid-replication, we can't know whether the replica observed this  
            }
         * Returns the global checkpoint computed on the primary shard.  
                    decPendingAndFinishIfNeeded();  
     * <li>The operation on the primary</li>  
                logger.trace(
            ShardRouting replica,  
                primaryTerm  
         *
                if (failure instanceof ShardStateAction.NoLongerPrimaryShardException == false) {  
                        new ReplicationResponse.ShardInfo.Failure(
                failuresArray = ReplicationResponse.EMPTY;
        final PendingReplicationActions pendingReplicationActions = replicationProxyRequest.getPendingReplicationActions();  
                    ActionListener.wrap(r -> decPendingAndFinishIfNeeded(), ReplicationOperation.this::onNoLongerPrimary)
                    finishAsFailed(  
        }
                        shard.shardId(),
            replicationProxy.performOnReplicaProxy(proxyRequest, this::performOnReplica);
                maxSeqNoOfUpdatesOrDeletes,  
            ).build();
                if (TransportActions.isShardNotAvailableException(replicaException) == false) {
         * @param exception    the original exception which caused the ReplicationOperation to request the shard to be failed
                        "[{}] failure while performing [{}] on replica {}, request [{}]",
                + shardRoutingTable.activeShards().size()
                allocationId,
    ) {  
        @Nullable
        /**
 * not use this file except in compliance with the License.
         * @param allocationId allocation ID of the shard corresponding to the supplied local checkpoint  
                            false
    private final TimeValue initialRetryBackoffBound;
         * @param listener     a listener that will be notified when the failing shard has been removed from the in-sync set
    private final ThreadPool threadPool;
        long localCheckpoint();
            // when the node with the primary shard is gracefully shutting down.  
        // if inSyncAllocationIds contains allocation ids of shards that don't exist in RoutingTable, mark copies as stale  
        ReplicationProxy<ReplicaRequest> replicationProxy
        final PendingReplicationActions pendingReplicationActions
        primaryResult.runPostReplicationActions(new ActionListener<Void>() {
            message = String.format(  
        String opType,  
            primaryResult.setShardInfo(new ReplicationResponse.ShardInfo(totalShards.get(), successfulShards.get(), failuresArray));
        if (pendingActions.decrementAndGet() == 0) {
            }  
         * routing entry for this primary  
                // go out of sync with the primary
        }
        ActionListener<PrimaryResultT> listener,
                        opType,  
            @Override
        }
    /**
 *
         * also complete after. Deal with it.  
        }
     * </ul>
        if (finished.compareAndSet(false, true)) {
        totalShards.incrementAndGet();
        this.primary = primary;
                            shard.currentNodeId(),
         * Performs the given request on this primary. Yes, this returns as soon as it can with the request for the replicas and calls a
         *  
        long computedGlobalCheckpoint();
import org.opensearch.core.Assertions;  
import java.util.List;
                    updateCheckPoints(primary.routingEntry(), primary::localCheckpoint, primary::globalCheckpoint);
    }
        ReplicationGroup getReplicationGroup();  
        assert pendingActions.get() > 0 : "pending action count goes below 0 for request [" + request + "]";
            primary.failShard(message, e);  
                : waitForActiveShards.toString();  
    private void performOnReplicas(  
        } else {  
            // max_seq_no_of_updates on replica when this request is executed is at least the value on the primary when it was executed
            }
        this.retryTimeout = retryTimeout;  
                primary.routingEntry()  
    }
                pendingReplicationActions.removeReplicationAction(allocationId, this);
         * @param allocationId allocation id to remove from the set of in-sync allocation ids  
                + "] (have "
    public ReplicationOperation(
        if (replicaRequest != null) {  
                    + "request [{}]",  
                    ),  
        this.opType = opType;  
    private final String opType;  
            replicasProxy.markShardCopyAsStaleIfNeeded(  
import java.util.concurrent.atomic.AtomicBoolean;
     * An encapsulation of an operation that will be executed on the replica shards, if present.
import org.opensearch.common.Nullable;
         * @param checkpoint the *local* checkpoint for the shard
                } finally {
    }
        this.initialRetryBackoffBound = initialRetryBackoffBound;
                    decPendingAndFinishIfNeeded();
    }
    // exposed for tests
        TimeValue retryTimeout,  
 * this work for additional information regarding copyright
         * @return the persisted global checkpoint  
        } catch (final Exception e) {  
                "[{}] not enough active copies to meet shard count of [{}] (have {}, needed {}), scheduling a retry. op [{}], "
import org.opensearch.transport.ConnectTransportException;  
            @Override  
import org.opensearch.threadpool.ThreadPool;
                        )
                primaryRouting,
    }
    private void decPendingAndFinishIfNeeded() {  
         * @return the pending replication actions
                }
        this.logger = logger;  
                    replicaException,
     */  
         *
     */
                logger.trace("[{}] op [{}] post replication actions failed for [{}]", primary.routingEntry().shardId(), opType, request);  
        final ActiveShardCount waitForActiveShards = request.waitForActiveShards();
                successfulShards.incrementAndGet();
import org.apache.logging.log4j.message.ParameterizedMessage;
         * @param listener     a listener that will be notified when the failing shard has been removed from the in-sync set
         */
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
                successfulShards.incrementAndGet();
                replicasProxy.failShardIfNeeded(  
        RequestT replicaRequest();  
            // we also have to make sure to get the global checkpoint before the replication group, to ensure that the global checkpoint
            resultListener.onFailure(exception);
            initialRetryBackoffBound,
        /**
    private final ReplicationProxy<ReplicaRequest> replicationProxy;
        final long globalCheckpoint,
         * @param globalCheckpoint           the global checkpoint on the primary  
        RetryOnPrimaryException(ShardId shardId, String msg, Throwable cause) {
         */  
                );
    }
     * <ul>
            final ReplicationGroup replicationGroup = primary.getReplicationGroup();
        });
            }
 * Operation for a replication request
            }  
    private volatile PrimaryResultT primaryResult = null;
    /**  
import org.opensearch.OpenSearchException;
 */
        totalShards.addAndGet(replicationGroup.getSkippedShards().size());  
    PrimaryResultT extends ReplicationOperation.PrimaryResult<ReplicaRequest>> {
        long globalCheckpoint();
         * @return the persisted local checkpoint  
            return null;
            ReplicationProxyRequest<ReplicaRequest> proxyRequest = new Builder<ReplicaRequest>(
                try {
         * Fail the primary shard.
    }
        /**  
    private final TimeValue retryTimeout;  
 * the Apache License, Version 2.0 (the "License"); you may
            }
            );
        Primary<Request, ReplicaRequest, PrimaryResultT> primary,
         * This value must be captured after the execution of a replication request on the primary is completed.  
                replicasProxyConsumer.accept(listener);
        final ShardRouting shard = replicationProxyRequest.getShardRouting();
            }  
                waitForActiveShards,
                if (ExceptionsHelper.unwrapCause(replicaException) instanceof PrimaryShardClosedException) {
                    RestStatus restStatus = ExceptionsHelper.status(replicaException);  
 * SPDX-License-Identifier: Apache-2.0
}
         * @param message      a (short) description of the reason  
                shardId,
        final ActionListener<ReplicaResponse> replicationListener = new ActionListener<ReplicaResponse>() {
            } else {  
    }
        void performOn(
        /**  
         * The persisted global checkpoint for the shard.
            primary.failShard(message, failure);  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.routing.ShardRouting;  
        final long maxSeqNoOfUpdatesOrDeletes,  
         * @return the local checkpoint
                    shard,
            return;
     * An encapsulation of an operation that is to be performed on the primary shard
        }  
        final String message;
            long maxSeqNoOfUpdatesOrDeletes,
        this.replicasProxy = replicas;  
                request  
         * Marks shard copy as stale if needed, removing its allocation id from
                return "[" + replicaRequest + "][" + shard + "]";
        void runPostReplicationActions(ActionListener<Void> listener);
         * Update the local knowledge of the global checkpoint for the specified allocation ID.  
                + ", needed "  
 * license agreements. See the NOTICE file distributed with
    /**  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
import org.opensearch.action.support.RetryableAction;
         */  
            public boolean shouldRetry(Exception e) {  
            pendingActions.incrementAndGet();
            public void onResponse(ReplicaResponse response) {  
         * */
        pendingActions.incrementAndGet();  
        /**  
            resultListener.onResponse(primaryResult);
        /**  
                Locale.ROOT,
                super.onFinished();
            public void tryAction(ActionListener<ReplicaResponse> listener) {
         *  
    private final AtomicInteger totalShards = new AtomicInteger();
         * Performs the specified request on the specified replica.
         */
import org.opensearch.action.support.replication.ReplicationProxyRequest.Builder;  
            @Override
        RequestT extends ReplicationRequest<RequestT>,
                }
        this.threadPool = threadPool;
        Replicas<ReplicaRequest> replicas,  
        RetryOnPrimaryException(ShardId shardId, String msg) {
            // we have to capture the max_seq_no_of_updates after this request was completed on the primary to make sure the value of  
        if (activeShardCountFailure != null) {
         * @param request the request to perform
         *  
    /**
        final IndexShardRoutingTable shardRoutingTable = primary.getReplicationGroup().getRoutingTable();  
/*
    }
 *
            final ReplicationResponse.ShardInfo.Failure[] failuresArray;  
                    primaryTerm,
            }  
                    );  
        /**
         * @param globalCheckpoint the global checkpoint  
        }  
        totalShards.incrementAndGet();
                            restStatus,  
        if (waitForActiveShards.enoughShardsActive(shardRoutingTable)) {
    /**
import org.opensearch.core.common.io.stream.StreamInput;  
            public void onResponse(Void aVoid) {
            @Override
        void markShardCopyAsStaleIfNeeded(ShardId shardId, String allocationId, long primaryTerm, ActionListener<Void> listener);
         * @param replica                    the shard this request should be executed on  
         * @param primaryTerm                the primary term
     * <li>The operation on each replica</li>
        void updateLocalCheckpointForShard(String allocationId, long checkpoint);  
         */
                "node with primary [%s] is shutting down while failing replica shard",
                );  
    private void finish() {
        final ReplicationGroup replicationGroup,
            final long maxSeqNoOfUpdatesOrDeletes = primary.maxSeqNoOfUpdatesOrDeletes();  
        }  
         * @param primaryTerm  the primary term
 */  
        this.replicationProxy = replicationProxy;
        if (finished.compareAndSet(false, true)) {
        };  
         * <p>  
     *
         * Run actions to be triggered post replication
import org.opensearch.index.shard.PrimaryShardClosedException;
            // We prefer not to fail the primary to avoid unnecessary warning log
            if (shardReplicaFailures.isEmpty()) {
        final ShardId primaryId = primaryRouting.shardId();
    public interface Replicas<RequestT extends ReplicationRequest<RequestT>> {
        long primaryTerm,
    private final List<ReplicationResponse.ShardInfo.Failure> shardReplicaFailures = Collections.synchronizedList(new ArrayList<>());  
                            replicaException
     * <li>Coordination of the operation as a whole. This prevents the operation from terminating early if we haven't started any replica
        final ShardRouting primaryRouting = primary.routingEntry();
         * @return the persisted global checkpoint
