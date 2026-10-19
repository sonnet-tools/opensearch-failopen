                            latch.countDown();
                        return ThreadPool.Names.SAME;
    }  
        boolean waitForCompletion,  
            transportService.sendChildRequest(  
        ActionListener<Void> notifyOnceListener = ActionListener.notifyOnce(listener);
                        );
import org.opensearch.action.support.ActionFilters;
                            logger.debug(  
                                    indexShard.shardId().getId(),  
                        } finally {
import org.apache.logging.log4j.message.ParameterizedMessage;
        IndexShard indexShard,
                                NodeClosedException.class,
                    checkpoint
import org.opensearch.node.NodeClosedException;
            final ReplicationTimer timer = new ReplicationTimer();  
     *  
                                ),
            shardStateAction,  
            logger.trace(() -> new ParameterizedMessage("Checkpoint {} received on replica {}", shardRequest, replica.shardId()));
                            );
                }  
import org.opensearch.indices.replication.common.ReplicationTimer;
            logger.trace(
        Settings settings,
                    public ReplicationResponse read(StreamInput in) throws IOException {
                    @Override
     */  
import org.opensearch.cluster.service.ClusterService;  
                return new ReplicaResult();  
import org.opensearch.common.util.concurrent.ThreadContext;  
    public ReplicationMode getReplicationMode(IndexShard indexShard) {  
                        e
                                indexShard.shardId().getId(),  
                () -> new ParameterizedMessage(
        }  
            notifyOnceListener.onResponse(null);
import java.util.concurrent.TimeUnit;  
        ReplicationCheckpoint checkpoint,  
import org.opensearch.transport.TransportRequest;
    @Override
                    @Override  
        TimeValue waitTimeout,
     * Execute the specified replica operation.
                transportPrimaryAction,
import org.opensearch.action.support.replication.ReplicationRequest;
    Request extends ReplicationRequest<Request>,
            );  
import java.util.concurrent.CountDownLatch;
import org.opensearch.action.support.replication.ReplicationTask;  
import org.opensearch.action.support.replication.TransportReplicationAction;
                    @Override
                new ConcreteShardRequest<>(request, primaryAllocationId, primaryTerm),  
        Logger logger  
                            taskManager.unregister(task);
        ActionListener.completeWith(listener, () -> {  
        } catch (Exception e) {  
 */
        if (indexShard.indexSettings().isAssignedOnRemoteNode()) {
 * Abstract base class for publish checkpoint.
/*  
                                e
                            task.setPhase("finished");
                                () -> new ParameterizedMessage(
import org.opensearch.indices.IndicesService;  
    }  
        String primaryAllocationId = indexShard.routingEntry().allocationId().getId();
    ReplicaRequest extends ReplicationRequest<ReplicaRequest>> extends TransportReplicationAction<
        );
        Objects.requireNonNull(shardRequest);
    @Override
            clusterService,  
import org.opensearch.action.support.replication.ReplicationMode;  
                                return;  
        super(
    final protected void shardOperationOnReplica(ReplicaRequest shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {  
            actionFilters,
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
                                "[shardId {}] Failed to publish checkpoint [{}], timing: {}",
    }
import java.io.IOException;  
}
        });
            actionName,
        IndicesService indicesService,
        ReplicaRequest,
        TransportRequest request,
                        }  
        long primaryTerm = indexShard.getPendingPrimaryTerm();  
import org.opensearch.common.unit.TimeValue;
                                IndexShardClosedException.class,
package org.opensearch.indices.replication.checkpoint;
                }
                    checkpoint.getShardId().getId(),
        ThreadPool threadPool,  
                            ) != null) {
            // Condition for ensuring that we ignore Segrep checkpoints received on Docrep shard copies.
import org.opensearch.cluster.action.shard.ShardStateAction;
            settings,  
                            }
        TransportService transportService,  
                            logger.warn(
 *
                        return newResponseInstance(in);  
/**  
import org.opensearch.common.settings.Settings;
            final ReplicationTask task = (ReplicationTask) taskManager.register("transport", action, request);
import org.opensearch.threadpool.ThreadPool;  
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
    final void doPublish(
        String threadPoolName,
        String actionName,
     * @param shardRequest the request to the replica shard
                    "[shardId {}] Publishing replication checkpoint [{}]",  
            indicesService,
import org.opensearch.core.action.ActionListener;
                                    checkpoint  
import org.opensearch.core.common.io.stream.Writeable;
                indexShard.recoveryState().getTargetNode(),
        ActionListener<Void> listener
        ClusterService clusterService,
            // This case will hit iff the replica hosting node is not remote enabled and replication type != SEGMENT  
            timer.start();
    /**
        return super.getReplicationMode(indexShard);
                                ShardNotInPrimaryModeException.class  
    public AbstractPublishCheckpointAction(  
            notifyOnceListener.onFailure(e);
            // we have to execute under the system context so that if security is enabled the sync is authorized  
        ShardStateAction shardStateAction,
            transportService,
                                    "{} segment replication checkpoint [{}] publishing failed",
     * Publish checkpoint request to shard
                    public void handleException(TransportException e) {
        String action,
                    }
                                    "[shardId {}] Completed publishing checkpoint [{}], timing: {}",
            );
                    public void handleResponse(ReplicationResponse response) {  
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
    @Override  
                        try {
        this.logger = logger;  
                                timer.time()
                    }
            if (waitForCompletion) {
                            );  
        ReplicationResponse> {
                            timer.stop();
                                checkpoint,
                            timer.stop();  
 * this file be licensed under the Apache-2.0 license or a
        Writeable.Reader<ReplicaRequest> replicaRequestReader,
                        notifyOnceListener.onFailure(
                    }
import org.opensearch.index.shard.IndexShardClosedException;
        }
                        try {
                new TransportResponseHandler<ReplicationResponse>() {  
                    public String executor() {
                                )  
 * SPDX-License-Identifier: Apache-2.0
                    @Override  
                                    indexShard.shardId(),
                                IndexNotFoundException.class,  
                transportOptions,
            doReplicaOperation(shardRequest, replica);
                            latch.countDown();
import org.opensearch.index.shard.IndexShard;  
import org.opensearch.ExceptionsHelper;
                                    timer.time()
                )  
                task,
 *
                    logger.warn(
            }
import org.opensearch.action.support.replication.ReplicationResponse;
import org.apache.logging.log4j.Logger;
        Request,  
     * @param replica      the replica shard to perform the operation on
        Objects.requireNonNull(replica);
                            task.setPhase("finished");
        ActionFilters actionFilters,
            replicaRequestReader,  
                            if (ExceptionsHelper.unwrap(  
                                AlreadyClosedException.class,
                                e,
                        } finally {
    ) {
import org.apache.lucene.store.AlreadyClosedException;  
                    }
            threadPool,
import org.opensearch.transport.TransportResponseHandler;  
                        () -> new ParameterizedMessage("Interrupted while waiting for publish checkpoint complete [{}]", checkpoint),  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
import java.util.concurrent.TimeoutException;
            return new ReplicaResult();  
            if (replica.indexSettings().isAssignedOnRemoteNode() == false && replica.indexSettings().isSegRepLocalEnabled() == false) {
import java.util.Objects;
public abstract class AbstractPublishCheckpointAction<  
                    }  
                    );
            CountDownLatch latch = new CountDownLatch(1);
                            new TimeoutException("Timed out waiting for publish checkpoint to complete. Checkpoint: " + checkpoint)  
                                // Node is shutting down or the index was deleted or the shard is closed
            return ReplicationMode.FULL_REPLICATION;
        Writeable.Reader<Request> requestReader,  
            }
 * compatible open source license.
    protected abstract void doReplicaOperation(ReplicaRequest shardRequest, IndexShard replica);
import org.opensearch.common.util.concurrent.ThreadContextAccess;
                logger.trace("Received segrep checkpoint on a docrep shard copy during an ongoing remote migration. NoOp.");
    private final Logger logger;
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
        final ThreadContext threadContext = threadPool.getThreadContext();
                            );  
 */  
                try {  
                        }  
import org.opensearch.index.IndexNotFoundException;
                            logger.debug(
 * @opensearch.api  
    ) {  
 * The OpenSearch Contributors require contributions made to  
                                new ParameterizedMessage(  
                                    checkpoint,
            threadPoolName
                    if (latch.await(waitTimeout.seconds(), TimeUnit.SECONDS) == false) {
     */  
        return new ReplicationResponse(in);
import org.opensearch.transport.TransportException;
    /**
                    notifyOnceListener.onFailure(e);
    }
            requestReader,
import org.opensearch.transport.TransportService;
                } catch (InterruptedException e) {  
                            taskManager.unregister(task);  
