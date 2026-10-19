import org.opensearch.action.support.replication.ReplicationOperation;
     * and the flush of the shard. This is done to ensure that such shards won't be later promoted as primary
        ShardRequest(StreamInput in) throws IOException {
    TransportVerifyShardIndexBlockAction.ShardRequest,
/*
     */  
import org.opensearch.transport.TransportService;
            clusterBlock = new ClusterBlock(in);  
 * license agreements. See the NOTICE file distributed with
        final IndexShard replica,
 *     http://www.apache.org/licenses/LICENSE-2.0
        final TransportService transportService,  
    }  
import org.apache.logging.log4j.LogManager;  
import org.opensearch.cluster.action.shard.ShardStateAction;
 * You may obtain a copy of the License at  
 *
        }  
            final String allocationId,
        public String toString() {
    protected ReplicationOperation.Replicas<ShardRequest> newReplicasProxy() {
        final ShardId shardId = indexShard.shardId();  
        ) {
 * GitHub history for details.
            stateAction,
import org.opensearch.core.action.ActionListener;  
        public void markShardCopyAsStaleIfNeeded(  
            super(in);
        final IndicesService indicesService,
            indicesService,  
 * and are no longer executing any operations in violation of that block. This action  
    ) {
            return clusterBlock;  
 * KIND, either express or implied.  See the License for the
            clusterBlock.writeTo(out);
     * @opensearch.internal
     * @opensearch.internal
        if (indexShard.getActiveOperationsCount() != IndexShard.OPERATIONS_BLOCKED) {
import org.opensearch.cluster.block.ClusterBlocks;
        if (clusterBlocks.hasIndexBlock(shardId.getIndexName(), request.clusterBlock()) == false) {
    TransportVerifyShardIndexBlockAction.ShardRequest,
import org.opensearch.core.index.shard.ShardId;  
    /**  
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;
        @Override  
import org.opensearch.threadpool.ThreadPool;
    }
    @Override  
        ActionListener.completeWith(listener, () -> {
import org.opensearch.common.settings.Settings;
 */
            actionFilters,  
        public ShardRequest(final ShardId shardId, final ClusterBlock clusterBlock, final TaskId parentTaskId) {  
        @Override
import org.opensearch.action.support.ActionFilters;  
     *
        final ClusterBlocks clusterBlocks = clusterService.state().blocks();
/*
        final ThreadPool threadPool,  
import org.opensearch.common.inject.Inject;  
        }  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 *
            clusterService,
package org.opensearch.action.admin.indices.readonly;
            executeShardOperation(shardRequest, primary);
    @Override
 * Action used to verify whether shards have properly applied a given index block,
}  
import org.opensearch.core.tasks.TaskId;
    public static class ShardRequest extends ReplicationRequest<ShardRequest> {  
 * software distributed under the License is distributed on an
    }
 * compatible open source license.
 * under the License.  
            settings,
        ActionListener.completeWith(listener, () -> {  
        primary.acquireAllPrimaryOperationsPermits(onAcquired, request.timeout());  
        public void writeTo(final StreamOutput out) throws IOException {  
    ) {
        ActionListener<PrimaryResult<ShardRequest, ReplicationResponse>> listener
    @Override  
            setParentTask(parentTaskId);  
     * or reopened in an unverified state with potential non flushed translog operations.  
    ) {
    protected void shardOperationOnPrimary(
        final ActionListener<Releasable> onAcquired,
        replica.acquireAllReplicaOperationsPermits(primaryTerm, globalCheckpoint, maxSeqNoOfUpdateOrDeletes, onAcquired, request.timeout());  
public class TransportVerifyShardIndexBlockAction extends TransportReplicationAction<  
        });
 * the Apache License, Version 2.0 (the "License"); you may
        }
        final ClusterService clusterService,
        }
    class VerifyShardReadOnlyActionReplicasProxy extends ReplicasProxy {
    protected Logger logger = LogManager.getLogger(getClass());
            NAME,  
import org.opensearch.cluster.service.ClusterService;
        final ActionFilters actionFilters
        }
            ShardRequest::new,
    public static final String NAME = AddIndexBlockAction.NAME + "[s]";
    @Inject  
    }
        });  
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.action.support.replication.ReplicationRequest;
            super(shardId);
        final long primaryTerm,
import org.opensearch.index.shard.IndexShard;
    protected void acquirePrimaryOperationPermit(
            super.writeTo(out);
 * requests all operation permits of the shard in order to wait for all write operations
        }
            throw new IllegalStateException(
            ThreadPool.Names.MANAGEMENT  
        final IndexShard primary,  
 *  
import org.opensearch.indices.IndicesService;  
 * to complete.
        final Settings settings,
            executeShardOperation(shardRequest, replica);  
            return "verify shard " + shardId + " before block with " + clusterBlock;
 * Unless required by applicable law or agreed to in writing,
            this.clusterBlock = Objects.requireNonNull(clusterBlock);
import org.opensearch.action.support.replication.ReplicationResponse;  
    public static final ActionType<ReplicationResponse> TYPE = new ActionType<>(NAME, ReplicationResponse::new);  
    }
     */
    @Override  
        final ShardRequest shardRequest,
    @Override  
    public TransportVerifyShardIndexBlockAction(
    @Override
     *  
 *  
import org.opensearch.common.lease.Releasable;
            final long primaryTerm,  
        final ShardRequest request,  
 * this work for additional information regarding copyright
import org.opensearch.action.ActionType;
        final long globalCheckpoint,  
 */
            transportService,
        return new ReplicationResponse(in);  
/**
        final ShardRequest request,  
    ReplicationResponse> {  
        private final ClusterBlock clusterBlock;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import org.opensearch.action.support.replication.TransportReplicationAction;
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        final IndexShard primary,
/*  
        final ActionListener<Releasable> onAcquired
            );
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
    private void executeShardOperation(final ShardRequest request, final IndexShard indexShard) {
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.Logger;
        final long maxSeqNoOfUpdateOrDeletes
            return new PrimaryResult<>(shardRequest, new ReplicationResponse());
        super(
    }
            shardStateAction.remoteShardFailed(shardId, allocationId, primaryTerm, true, "mark copy as stale", null, listener);  
    protected void shardOperationOnReplica(ShardRequest shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
    }
    ) {  
            final ShardId shardId,
            final ActionListener<Void> listener
    /**
            return new ReplicaResult();
            throw new IllegalStateException("index shard " + shardId + " has not applied block " + request.clusterBlock());  
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
        }
 */  
     * Per shard request
 */
            threadPool,
        final ShardStateAction stateAction,
                "index shard " + shardId + " is not blocking all operations while waiting for block " + request.clusterBlock()  
    }
        return new VerifyShardReadOnlyActionReplicasProxy();  
import org.opensearch.cluster.block.ClusterBlock;  
        }
    protected void acquireReplicaOperationPermit(
        public ClusterBlock clusterBlock() {
            ShardRequest::new,
import java.util.Objects;
 * Modifications Copyright OpenSearch Contributors. See  
     * A {@link ReplicasProxy} that marks as stale the shards that are unavailable during the verification
        );
    }
 * SPDX-License-Identifier: Apache-2.0
