        }
 * @opensearch.internal
import org.opensearch.cluster.action.shard.ShardStateAction;
    }
    protected ReplicationOperation.Replicas<ShardRequest> newReplicasProxy() {
        final ClusterService clusterService,
    @Override
        }
import org.opensearch.cluster.service.ClusterService;
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
    @Override
        @Override
    @Override
import java.util.Objects;
import org.opensearch.action.support.ActionFilters;
        final TransportService transportService,
            shardStateAction.remoteShardFailed(shardId, allocationId, primaryTerm, true, "mark copy as stale", null, listener);
 * compatible open source license.
            threadPool,
        final IndexShard primary,
            indicesService,
            ThreadPool.Names.MANAGEMENT
            ShardRequest::new,
            clusterService,
 * The OpenSearch Contributors require contributions made to
 * specific language governing permissions and limitations
        public ClusterBlock clusterBlock() {
        private final ClusterBlock clusterBlock;
        final ShardId shardId = indexShard.shardId();
    ReplicationResponse> {
 */
import org.opensearch.action.support.replication.ReplicationResponse;
        return new VerifyShardBeforeCloseActionReplicasProxy();
        );
    public static final String NAME = CloseIndexAction.NAME + "[s]";
import org.apache.logging.log4j.Logger;
     * and the flush of the shard. This is done to ensure that such shards won't be later promoted as primary
 *
    }
 * ownership. Elasticsearch licenses this file to you under
        public boolean isPhase1() {
 * the Apache License, Version 2.0 (the "License"); you may
 *
        public String toString() {
    }
        return new ReplicationResponse(in);
            final String allocationId,
        ShardRequest(StreamInput in) throws IOException {
 * GitHub history for details.
        final ShardStateAction stateAction,
        final IndexShard replica,
        final long maxSeqNoOfUpdateOrDeletes
        final IndicesService indicesService,
import org.opensearch.transport.TransportService;
    }
        final ShardRequest shardRequest,
        }
        ActionListener.completeWith(listener, () -> {
            // sequence number to pass the verifyShardBeforeIndexClosing check and create a safe commit where the maximum sequence number
    protected Logger logger = LogManager.getLogger(getClass());
            indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));
     * A {@link ReplicasProxy} that marks as stale the shards that are unavailable during the verification
/*
        replica.acquireAllReplicaOperationsPermits(primaryTerm, globalCheckpoint, maxSeqNoOfUpdateOrDeletes, onAcquired, request.timeout());
 */
        final ActionFilters actionFilters
        }
        final ActionListener<Releasable> onAcquired
import org.opensearch.core.common.io.stream.StreamOutput;
        if (indexShard.getActiveOperationsCount() != IndexShard.OPERATIONS_BLOCKED) {
 * this work for additional information regarding copyright
import org.apache.logging.log4j.LogManager;
            executeShardOperation(shardRequest, replica);
            final ActionListener<Void> listener
            super(shardId);
    protected void acquireReplicaOperationPermit(
        }
    ) {
            // to the primary (we call this phase1), and phase2 can then use the fact that the global checkpoint has moved to the maximum
            // in order to advance the global checkpoint to the maximum sequence number, the (persisted) local checkpoint needs to be
    /**
public class TransportVerifyShardBeforeCloseAction extends TransportReplicationAction<
            // advanced first, which, when using async translog syncing, does not automatically hold at the time where we have acquired
            // all operation permits. Instead, this requires and explicit sync, which communicates the updated (persisted) local checkpoint
 * You may obtain a copy of the License at
            clusterBlock = new ClusterBlock(in);
            settings,
 */
            final ShardId shardId,
 * under the License.
    }
            return new PrimaryResult<>(shardRequest, new ReplicationResponse());
    class VerifyShardBeforeCloseActionReplicasProxy extends ReplicasProxy {
        @Override
        final ClusterBlocks clusterBlocks = clusterService.state().blocks();
    protected void shardOperationOnReplica(ShardRequest shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
            super.writeTo(out);
            phase1 = in.readBoolean();
    TransportVerifyShardBeforeCloseAction.ShardRequest,
            this.phase1 = phase1;
import org.opensearch.core.common.io.stream.StreamInput;
        primary.acquireAllPrimaryOperationsPermits(onAcquired, request.timeout());
import org.opensearch.action.support.replication.ReplicationRequest;
 * Licensed to Elasticsearch under one or more contributor
            logger.trace("{} shard is ready for closing", shardId);
        ) {
     *
        super(
    ) {
    TransportVerifyShardBeforeCloseAction.ShardRequest,
            setParentTask(parentTaskId);
            throw new IllegalStateException("Index shard " + shardId + " is not blocking all operations during closing");
            throw new IllegalStateException("Index shard " + shardId + " must be blocked by " + request.clusterBlock() + " before closing");
import org.opensearch.action.admin.indices.flush.FlushRequest;
        final ActionListener<Releasable> onAcquired,
        final ShardRequest request,
import org.opensearch.core.action.ActionListener;
        }
    public static class ShardRequest extends ReplicationRequest<ShardRequest> {
            executeShardOperation(shardRequest, primary);
import java.io.IOException;
        final ShardRequest request,
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.replication.ReplicationOperation;
            NAME,
        }
            stateAction,
 * Unless required by applicable law or agreed to in writing,
        } else {
        final IndexShard primary,
        @Override
     * or reopened in an unverified state with potential non flushed translog operations.
        if (request.isPhase1()) {
    }
        if (clusterBlocks.hasIndexBlock(shardId.getIndexName(), request.clusterBlock()) == false) {
 */
            indexShard.sync();
 * license agreements. See the NOTICE file distributed with
     */
            final long primaryTerm,
        public ShardRequest(final ShardId shardId, final ClusterBlock clusterBlock, final boolean phase1, final TaskId parentTaskId) {
        });
 * SPDX-License-Identifier: Apache-2.0
    @Override
        }
import org.opensearch.action.support.replication.TransportReplicationAction;
    private void executeShardOperation(final ShardRequest request, final IndexShard indexShard) throws IOException {
        ActionListener<PrimaryResult<ShardRequest, ReplicationResponse>> listener
    protected void acquirePrimaryOperationPermit(
        private final boolean phase1;
            transportService,
        final ThreadPool threadPool,
 * not use this file except in compliance with the License.
    @Inject
            this.clusterBlock = Objects.requireNonNull(clusterBlock);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;
            actionFilters,
        });
            return clusterBlock;
            indexShard.verifyShardBeforeIndexClosing();
     * @opensearch.internal
     * Shard Request for verifying shards before closing
import org.opensearch.indices.IndicesService;
}
/**
        public void markShardCopyAsStaleIfNeeded(
    ) {
 * Transport action for verifying a shard before closing an index
    public TransportVerifyShardBeforeCloseAction(
        }
            return phase1;
        public void writeTo(final StreamOutput out) throws IOException {
import org.opensearch.common.lease.Releasable;
    ) {
 * this file be licensed under the Apache-2.0 license or a
     */
            return "verify shard " + shardId + " before close with block " + clusterBlock;
 * software distributed under the License is distributed on an
    }
    }
import org.opensearch.index.shard.IndexShard;
import org.opensearch.cluster.block.ClusterBlock;
 *
/*
import org.opensearch.core.tasks.TaskId;
    protected void shardOperationOnPrimary(
import org.opensearch.threadpool.ThreadPool;
            super(in);
 * Modifications Copyright OpenSearch Contributors. See
        final long primaryTerm,
import org.opensearch.common.inject.Inject;
            // is equal to the global checkpoint.
 *
        final Settings settings,
        ActionListener.completeWith(listener, () -> {
            ShardRequest::new,
import org.opensearch.cluster.block.ClusterBlocks;
            return new ReplicaResult();
    @Override
            out.writeBoolean(phase1);
    @Override
        final long globalCheckpoint,
import org.opensearch.core.index.shard.ShardId;
package org.opensearch.action.admin.indices.close;
    /**
        }
            clusterBlock.writeTo(out);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
    }
