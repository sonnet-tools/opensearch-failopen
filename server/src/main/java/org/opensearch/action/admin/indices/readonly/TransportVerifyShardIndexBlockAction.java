    TransportVerifyShardIndexBlockAction.ShardRequest,
    protected void shardOperationOnReplica(ShardRequest shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
    protected void acquirePrimaryOperationPermit(
        ) {
        public void writeTo(final StreamOutput out) throws IOException {
     */
import org.opensearch.common.inject.Inject;
        ShardRequest(StreamInput in) throws IOException {
    ) {
        final long primaryTerm,
        }
 */
        final ShardRequest request,
    }
        final ClusterBlocks clusterBlocks = clusterService.state().blocks();
        final ThreadPool threadPool,
 * this work for additional information regarding copyright
        final ShardId shardId = indexShard.shardId();
        final IndexShard replica,
        final ShardStateAction stateAction,
import org.opensearch.core.tasks.TaskId;
        }
            super(in);
            ShardRequest::new,
        ActionListener.completeWith(listener, () -> {
    @Override
    @Override
import org.opensearch.action.support.replication.ReplicationResponse;
        @Override
import org.opensearch.cluster.service.ClusterService;
 * and are no longer executing any operations in violation of that block. This action
        private final ClusterBlock clusterBlock;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * software distributed under the License is distributed on an
 *
    private void executeShardOperation(final ShardRequest request, final IndexShard indexShard) {
 * You may obtain a copy of the License at
import org.opensearch.core.common.io.stream.StreamInput;
 * Action used to verify whether shards have properly applied a given index block,
    /**
        });
        final Settings settings,
 */
    }
     * @opensearch.internal
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ActionListener.completeWith(listener, () -> {
    @Override
        final ActionFilters actionFilters
    protected void shardOperationOnPrimary(
 * Unless required by applicable law or agreed to in writing,
            settings,
            return "verify shard " + shardId + " before block with " + clusterBlock;
/*
     * @opensearch.internal
            ShardRequest::new,
 * specific language governing permissions and limitations
            throw new IllegalStateException(
        }
            super.writeTo(out);
import java.io.IOException;
    }
import org.opensearch.index.shard.IndexShard;
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.action.shard.ShardStateAction;
        public ClusterBlock clusterBlock() {
    ) {
    TransportVerifyShardIndexBlockAction.ShardRequest,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.threadpool.ThreadPool;
            super(shardId);
        }
/**
            setParentTask(parentTaskId);
            return new PrimaryResult<>(shardRequest, new ReplicationResponse());
        final long maxSeqNoOfUpdateOrDeletes
     * and the flush of the shard. This is done to ensure that such shards won't be later promoted as primary
        final ClusterService clusterService,
            final ActionListener<Void> listener
            return new ReplicaResult();
            transportService,
    }
import org.opensearch.transport.TransportService;
        return new VerifyShardReadOnlyActionReplicasProxy();
        if (clusterBlocks.hasIndexBlock(shardId.getIndexName(), request.clusterBlock()) == false) {
            indicesService,
     * or reopened in an unverified state with potential non flushed translog operations.
import org.opensearch.action.support.replication.TransportReplicationAction;
        final IndexShard primary,
            actionFilters,
            executeShardOperation(shardRequest, primary);
    ReplicationResponse> {
    @Override
    @Override
        }
 */
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
            );
        return new ReplicationResponse(in);
import org.opensearch.indices.IndicesService;
 * not use this file except in compliance with the License.
            final String allocationId,
        }
    public static final ActionType<ReplicationResponse> TYPE = new ActionType<>(NAME, ReplicationResponse::new);
        final ShardRequest request,
            final ShardId shardId,
     * Per shard request
 * Modifications Copyright OpenSearch Contributors. See
            clusterBlock.writeTo(out);
        @Override
        @Override
            this.clusterBlock = Objects.requireNonNull(clusterBlock);
 *
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
    }
        ActionListener<PrimaryResult<ShardRequest, ReplicationResponse>> listener
        public void markShardCopyAsStaleIfNeeded(
    public static class ShardRequest extends ReplicationRequest<ShardRequest> {
 * requests all operation permits of the shard in order to wait for all write operations
    @Override
    }
    }
import org.opensearch.action.support.ActionFilters;
import org.opensearch.action.ActionType;
    protected ReplicationOperation.Replicas<ShardRequest> newReplicasProxy() {
 * SPDX-License-Identifier: Apache-2.0
public class TransportVerifyShardIndexBlockAction extends TransportReplicationAction<
        super(
    /**
        public String toString() {
            clusterService,
import org.opensearch.core.index.shard.ShardId;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
import java.util.Objects;
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.block.ClusterBlock;
import org.opensearch.action.support.replication.ReplicationRequest;
    }
            executeShardOperation(shardRequest, replica);
            threadPool,
            final long primaryTerm,
    class VerifyShardReadOnlyActionReplicasProxy extends ReplicasProxy {
        final IndicesService indicesService,
import org.apache.logging.log4j.Logger;
 * Licensed to Elasticsearch under one or more contributor
    public static final String NAME = AddIndexBlockAction.NAME + "[s]";
        );
    }
 */
                "index shard " + shardId + " is not blocking all operations while waiting for block " + request.clusterBlock()
            return clusterBlock;
    protected Logger logger = LogManager.getLogger(getClass());
        public ShardRequest(final ShardId shardId, final ClusterBlock clusterBlock, final TaskId parentTaskId) {
        final ActionListener<Releasable> onAcquired
     */
 *
    }
/*
        replica.acquireAllReplicaOperationsPermits(primaryTerm, globalCheckpoint, maxSeqNoOfUpdateOrDeletes, onAcquired, request.timeout());
     * A {@link ReplicasProxy} that marks as stale the shards that are unavailable during the verification
     *
    @Inject
            clusterBlock = new ClusterBlock(in);
            NAME,
            ThreadPool.Names.MANAGEMENT
            stateAction,
    ) {
 * under the License.
    public TransportVerifyShardIndexBlockAction(
}
 * license agreements. See the NOTICE file distributed with
        if (indexShard.getActiveOperationsCount() != IndexShard.OPERATIONS_BLOCKED) {
import org.opensearch.common.lease.Releasable;
 * @opensearch.internal
import org.opensearch.cluster.block.ClusterBlocks;
 *
        final IndexShard primary,
        final ShardRequest shardRequest,
import org.apache.logging.log4j.LogManager;
    ) {
    protected void acquireReplicaOperationPermit(
        final long globalCheckpoint,
        final ActionListener<Releasable> onAcquired,
            throw new IllegalStateException("index shard " + shardId + " has not applied block " + request.clusterBlock());
 * The OpenSearch Contributors require contributions made to
package org.opensearch.action.admin.indices.readonly;
     *
import org.opensearch.core.common.io.stream.StreamOutput;
 * to complete.
import org.opensearch.action.support.replication.ReplicationOperation;
 * compatible open source license.
        });
            shardStateAction.remoteShardFailed(shardId, allocationId, primaryTerm, true, "mark copy as stale", null, listener);
/*
        final TransportService transportService,
        primary.acquireAllPrimaryOperationsPermits(onAcquired, request.timeout());
