            }
            clusterService,
        );
                                ),
                                IndexNotFoundException.class,
        if (indexShard.indexSettings().isAssignedOnRemoteNode()) {
import org.opensearch.action.support.replication.ReplicationRequest;
            // we have to execute under the system context so that if security is enabled the sync is authorized
        TransportService transportService,
import org.apache.lucene.store.AlreadyClosedException;
import org.opensearch.common.unit.TimeValue;
import org.opensearch.indices.replication.common.ReplicationTimer;
        super(
import org.opensearch.action.support.ActionFilters;
     * Publish checkpoint request to shard
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
                                )
                    public ReplicationResponse read(StreamInput in) throws IOException {
                    }
                        e
            logger.trace(() -> new ParameterizedMessage("Checkpoint {} received on replica {}", shardRequest, replica.shardId()));
import org.opensearch.action.support.replication.ReplicationTask;
                }
                )
 * SPDX-License-Identifier: Apache-2.0
            if (waitForCompletion) {
                            logger.debug(
            return new ReplicaResult();
     * @param shardRequest the request to the replica shard
import org.opensearch.action.support.replication.ReplicationMode;
                                    checkpoint
        ActionListener.completeWith(listener, () -> {
        Writeable.Reader<ReplicaRequest> replicaRequestReader,
        TransportRequest request,
                            );
                try {
                                IndexShardClosedException.class,
                        } finally {
                                e,
        String threadPoolName,
import java.io.IOException;
                                e
                () -> new ParameterizedMessage(
                logger.trace("Received segrep checkpoint on a docrep shard copy during an ongoing remote migration. NoOp.");
import org.opensearch.index.shard.IndexShardClosedException;
                                "[shardId {}] Failed to publish checkpoint [{}], timing: {}",
import org.opensearch.threadpool.ThreadPool;
/*
        IndicesService indicesService,
        Writeable.Reader<Request> requestReader,
            // This case will hit iff the replica hosting node is not remote enabled and replication type != SEGMENT
                }
                            logger.debug(
import org.opensearch.index.shard.IndexShard;
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
        Logger logger
                                timer.time()
                transportOptions,
    /**
        this.logger = logger;
            );
            settings,
                            new TimeoutException("Timed out waiting for publish checkpoint to complete. Checkpoint: " + checkpoint)
    protected abstract void doReplicaOperation(ReplicaRequest shardRequest, IndexShard replica);
                new ConcreteShardRequest<>(request, primaryAllocationId, primaryTerm),
            replicaRequestReader,
import java.util.concurrent.TimeoutException;
        String actionName,
            actionFilters,
    Request extends ReplicationRequest<Request>,
            indicesService,
        TimeValue waitTimeout,
                            timer.stop();
                indexShard.recoveryState().getTargetNode(),
import org.opensearch.cluster.action.shard.ShardStateAction;
                            taskManager.unregister(task);
import org.opensearch.common.settings.Settings;
import org.opensearch.common.util.concurrent.ThreadContext;
                    @Override
        }
import org.opensearch.cluster.service.ClusterService;
                            task.setPhase("finished");
import org.opensearch.core.common.io.stream.StreamInput;
                    checkpoint
     *
import org.opensearch.action.support.replication.ReplicationResponse;
                new TransportResponseHandler<ReplicationResponse>() {
/**
            // Condition for ensuring that we ignore Segrep checkpoints received on Docrep shard copies.
import org.opensearch.transport.TransportException;
                    }
                            latch.countDown();
        final ThreadContext threadContext = threadPool.getThreadContext();
        Request,
        } catch (Exception e) {
 * The OpenSearch Contributors require contributions made to
        ReplicaRequest,
                                new ParameterizedMessage(
 */
import java.util.Objects;
                        } finally {
     * Execute the specified replica operation.
                                AlreadyClosedException.class,
 * Abstract base class for publish checkpoint.
            actionName,
                        return ThreadPool.Names.SAME;
                    "[shardId {}] Publishing replication checkpoint [{}]",
                return new ReplicaResult();
import org.opensearch.core.action.ActionListener;
                        }
 *
    }
            doReplicaOperation(shardRequest, replica);
                                checkpoint,
                        );
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.indices.IndicesService;
                                () -> new ParameterizedMessage(
        return super.getReplicationMode(indexShard);
            CountDownLatch latch = new CountDownLatch(1);
                                ShardNotInPrimaryModeException.class
        ActionListener<Void> listener
                            );
        boolean waitForCompletion,
        Objects.requireNonNull(shardRequest);
}
            transportService,
        ReplicationCheckpoint checkpoint,
     * @param replica      the replica shard to perform the operation on
                                    indexShard.shardId().getId(),
public abstract class AbstractPublishCheckpointAction<
            threadPool,
                        }
                            if (ExceptionsHelper.unwrap(
            shardStateAction,
                    );
    @Override
    ) {
 * compatible open source license.
        IndexShard indexShard,
                            logger.warn(
            logger.trace(
            notifyOnceListener.onFailure(e);
                    logger.warn(
import org.opensearch.core.common.io.stream.Writeable;
        ActionFilters actionFilters,
package org.opensearch.indices.replication.checkpoint;
                    public void handleResponse(ReplicationResponse response) {
        String action,
            );
            transportService.sendChildRequest(
    @Override
            }
                        () -> new ParameterizedMessage("Interrupted while waiting for publish checkpoint complete [{}]", checkpoint),
                                indexShard.shardId().getId(),
    private final Logger logger;
                    checkpoint.getShardId().getId(),
     */
        return new ReplicationResponse(in);
        String primaryAllocationId = indexShard.routingEntry().allocationId().getId();
                                    "{} segment replication checkpoint [{}] publishing failed",
                transportPrimaryAction,
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
 *
                            }
                    @Override
    final protected void shardOperationOnReplica(ReplicaRequest shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
        });
                        return newResponseInstance(in);
import org.opensearch.node.NodeClosedException;
                            ) != null) {
        Settings settings,
import org.opensearch.action.support.replication.TransportReplicationAction;
    }
    ) {
            if (replica.indexSettings().isAssignedOnRemoteNode() == false && replica.indexSettings().isSegRepLocalEnabled() == false) {
                                    "[shardId {}] Completed publishing checkpoint [{}], timing: {}",
    /**
            timer.start();
 */
                        try {
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
        ActionListener<Void> notifyOnceListener = ActionListener.notifyOnce(listener);
                            latch.countDown();
        ClusterService clusterService,
                            timer.stop();
                                    checkpoint,
 * @opensearch.api
import org.apache.logging.log4j.Logger;
                    if (latch.await(waitTimeout.seconds(), TimeUnit.SECONDS) == false) {
                    @Override
                            taskManager.unregister(task);
import org.apache.logging.log4j.message.ParameterizedMessage;
                    notifyOnceListener.onFailure(e);
            threadPoolName
import java.util.concurrent.TimeUnit;
    }
 * this file be licensed under the Apache-2.0 license or a
            final ReplicationTimer timer = new ReplicationTimer();
                                    timer.time()
        ReplicationResponse> {
                            task.setPhase("finished");
            notifyOnceListener.onResponse(null);
import org.opensearch.transport.TransportService;
                        notifyOnceListener.onFailure(
                                NodeClosedException.class,
        }
                    }
            final ReplicationTask task = (ReplicationTask) taskManager.register("transport", action, request);
            return ReplicationMode.FULL_REPLICATION;
import org.opensearch.transport.TransportRequest;
                                return;
                            );
    @Override
                task,
                    @Override
                    }
import org.opensearch.common.util.concurrent.ThreadContextAccess;
        long primaryTerm = indexShard.getPendingPrimaryTerm();
        ShardStateAction shardStateAction,
                    public void handleException(TransportException e) {
     */
                    public String executor() {
                        try {
        Objects.requireNonNull(replica);
            requestReader,
                    }
                                    indexShard.shardId(),
    public ReplicationMode getReplicationMode(IndexShard indexShard) {
    }
import org.opensearch.ExceptionsHelper;
                } catch (InterruptedException e) {
    public AbstractPublishCheckpointAction(
    }
                                // Node is shutting down or the index was deleted or the shard is closed
import org.opensearch.transport.TransportResponseHandler;
        ThreadPool threadPool,
    final void doPublish(
    ReplicaRequest extends ReplicationRequest<ReplicaRequest>> extends TransportReplicationAction<
import java.util.concurrent.CountDownLatch;
