import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
import org.opensearch.action.admin.indices.flush.FlushRequest;
    TransportVerifyShardBeforeCloseAction.ShardRequest,
import org.opensearch.threadpool.ThreadPool;
            // advanced first, which, when using async translog syncing, does not automatically hold at the time where we have acquired
        }  
        public String toString() {
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
        final long primaryTerm,
            transportService,  
    protected void shardOperationOnPrimary(  
    }  
import org.opensearch.indices.IndicesService;  
 */
    public static class ShardRequest extends ReplicationRequest<ShardRequest> {
        }  
    }
}
    protected ReplicationOperation.Replicas<ShardRequest> newReplicasProxy() {  
        if (indexShard.getActiveOperationsCount() != IndexShard.OPERATIONS_BLOCKED) {  
public class TransportVerifyShardBeforeCloseAction extends TransportReplicationAction<  
            final ActionListener<Void> listener  
     */
        final ActionListener<Releasable> onAcquired  
    @Inject
        ActionListener<PrimaryResult<ShardRequest, ReplicationResponse>> listener  
     * @opensearch.internal  
            return clusterBlock;
        final IndexShard primary,
import org.opensearch.action.support.replication.TransportReplicationAction;
    @Override
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
            return new ReplicaResult();  
import org.opensearch.common.inject.Inject;  
            out.writeBoolean(phase1);  
 * The OpenSearch Contributors require contributions made to  
        }
            indexShard.sync();  
 * under the License.  
     * A {@link ReplicasProxy} that marks as stale the shards that are unavailable during the verification
            throw new IllegalStateException("Index shard " + shardId + " must be blocked by " + request.clusterBlock() + " before closing");  
            super(in);  
            ThreadPool.Names.MANAGEMENT
 * Unless required by applicable law or agreed to in writing,
        ActionListener.completeWith(listener, () -> {
        }  
    }  
            super(shardId);  
        });
        final ClusterBlocks clusterBlocks = clusterService.state().blocks();
        }
 * @opensearch.internal
            NAME,
        @Override
        primary.acquireAllPrimaryOperationsPermits(onAcquired, request.timeout());
    @Override
    ) {
        public boolean isPhase1() {
import org.opensearch.common.lease.Releasable;
        public void writeTo(final StreamOutput out) throws IOException {  
            threadPool,  
/**
    /**  
            super.writeTo(out);
    ReplicationResponse> {  
    @Override
    protected void acquireReplicaOperationPermit(  
 */
        private final ClusterBlock clusterBlock;
    protected Logger logger = LogManager.getLogger(getClass());  
            stateAction,
     *
            actionFilters,
        final ActionListener<Releasable> onAcquired,  
    class VerifyShardBeforeCloseActionReplicasProxy extends ReplicasProxy {  
 * You may obtain a copy of the License at  
        final Settings settings,
        public void markShardCopyAsStaleIfNeeded(
        }
 * compatible open source license.
            clusterService,
import org.opensearch.core.tasks.TaskId;
    }  
    TransportVerifyShardBeforeCloseAction.ShardRequest,
/*
            return new PrimaryResult<>(shardRequest, new ReplicationResponse());
    @Override
            throw new IllegalStateException("Index shard " + shardId + " is not blocking all operations during closing");
        final long globalCheckpoint,
 */  
        @Override  
        }  
            this.clusterBlock = Objects.requireNonNull(clusterBlock);
 * the Apache License, Version 2.0 (the "License"); you may
    ) {
import java.io.IOException;
    protected void acquirePrimaryOperationPermit(  
     * or reopened in an unverified state with potential non flushed translog operations.
        return new VerifyShardBeforeCloseActionReplicasProxy();
            phase1 = in.readBoolean();
    private void executeShardOperation(final ShardRequest request, final IndexShard indexShard) throws IOException {
import org.opensearch.cluster.block.ClusterBlocks;
    }
import org.opensearch.transport.TransportService;
     * and the flush of the shard. This is done to ensure that such shards won't be later promoted as primary  
        );  
            clusterBlock = new ClusterBlock(in);
        public ClusterBlock clusterBlock() {  
        final ShardRequest request,
        final IndexShard replica,
            settings,
 * software distributed under the License is distributed on an
            executeShardOperation(shardRequest, replica);
        return new ReplicationResponse(in);
        final ShardRequest request,
        });
import org.opensearch.action.support.ActionFilters;  
        final ThreadPool threadPool,
import java.util.Objects;
     * Shard Request for verifying shards before closing
import org.opensearch.cluster.action.shard.ShardStateAction;
        final ShardRequest shardRequest,
 *
        if (request.isPhase1()) {
        }
import org.opensearch.action.support.replication.ReplicationRequest;
            final ShardId shardId,  
        final TransportService transportService,
            logger.trace("{} shard is ready for closing", shardId);
    protected void shardOperationOnReplica(ShardRequest shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {  
import org.opensearch.common.settings.Settings;
        private final boolean phase1;  
        }
import org.opensearch.core.index.shard.ShardId;  
 *  
            // sequence number to pass the verifyShardBeforeIndexClosing check and create a safe commit where the maximum sequence number
 *  
import org.apache.logging.log4j.Logger;
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.common.io.stream.StreamInput;
        super(  
package org.opensearch.action.admin.indices.close;
        final ClusterService clusterService,  
 * license agreements. See the NOTICE file distributed with
        if (clusterBlocks.hasIndexBlock(shardId.getIndexName(), request.clusterBlock()) == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.phase1 = phase1;
        final ShardStateAction stateAction,  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.shard.IndexShard;
            shardStateAction.remoteShardFailed(shardId, allocationId, primaryTerm, true, "mark copy as stale", null, listener);
 * KIND, either express or implied.  See the License for the
    public TransportVerifyShardBeforeCloseAction(  
        @Override
        final long maxSeqNoOfUpdateOrDeletes  
    /**
        final ActionFilters actionFilters
        replica.acquireAllReplicaOperationsPermits(primaryTerm, globalCheckpoint, maxSeqNoOfUpdateOrDeletes, onAcquired, request.timeout());
 * Transport action for verifying a shard before closing an index
 * not use this file except in compliance with the License.
import org.opensearch.action.support.replication.ReplicationOperation;
            setParentTask(parentTaskId);  
        public ShardRequest(final ShardId shardId, final ClusterBlock clusterBlock, final boolean phase1, final TaskId parentTaskId) {
            // is equal to the global checkpoint.
            ShardRequest::new,  
    ) {
/*
            final long primaryTerm,
            return phase1;
            // to the primary (we call this phase1), and phase2 can then use the fact that the global checkpoint has moved to the maximum  
    public static final String NAME = CloseIndexAction.NAME + "[s]";
/*  
            return "verify shard " + shardId + " before close with block " + clusterBlock;
            executeShardOperation(shardRequest, primary);  
    }
    }
            final String allocationId,
            indexShard.verifyShardBeforeIndexClosing();
            indicesService,
 */
 *
import org.opensearch.action.support.replication.ReplicationResponse;  
 * GitHub history for details.
        }
    ) {
            clusterBlock.writeTo(out);
     */
import org.opensearch.cluster.service.ClusterService;
    }  
 * this file be licensed under the Apache-2.0 license or a
        final IndicesService indicesService,
        } else {
            indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));  
            // in order to advance the global checkpoint to the maximum sequence number, the (persisted) local checkpoint needs to be  
            ShardRequest::new,
        ActionListener.completeWith(listener, () -> {
            // all operation permits. Instead, this requires and explicit sync, which communicates the updated (persisted) local checkpoint
import org.opensearch.cluster.block.ClusterBlock;  
        ) {
    }
        final ShardId shardId = indexShard.shardId();
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override  
        final IndexShard primary,
        ShardRequest(StreamInput in) throws IOException {
import org.opensearch.core.action.ActionListener;  
import org.apache.logging.log4j.LogManager;  
    }  
 * this work for additional information regarding copyright
