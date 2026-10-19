     *
            execute(new Request(shardId), ActionListener.wrap(r -> {}, e -> {  
    public GlobalCheckpointSyncAction(
    @Override
        return new ReplicationResponse(in);
            settings,  
        );
 */
        if (indexShard.getTranslogDurability() == Translog.Durability.REQUEST
 * under the License.  
                + ", index='"  
 * specific language governing permissions and limitations
import org.opensearch.threadpool.ThreadPool;  
            && indexShard.indexSettings().isAssignedOnRemoteNode() == false) {  
    }
            actionFilters,
 *  
 * the global checkpoint will never be synced to the replicas.
        IndexShard indexShard,
import org.opensearch.transport.TransportService;
import org.opensearch.core.index.shard.ShardId;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.common.util.concurrent.ThreadContext;  
    }  
        }  
    ) {  
    ReplicationResponse> {  
            Request::new,  
            indexShard.sync();
public class GlobalCheckpointSyncAction extends TransportReplicationAction<  
import org.opensearch.core.action.ActionListener;
import java.io.IOException;  
/*
    GlobalCheckpointSyncAction.Request,
                + '\''
        ActionListener.completeWith(listener, () -> {
 * on every replication operation, after the last operation completes the global checkpoint could advance but without a follow-up operation
            ACTION_NAME,
        final TransportService transportService,
        final ShardStateAction shardStateAction,
    @Override
        }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.replication.ReplicationRequest;
 * not use this file except in compliance with the License.
        final ThreadPool threadPool,
            threadPool,
            && indexShard.getLastSyncedGlobalCheckpoint() < indexShard.getLastKnownGlobalCheckpoint()
        public Request(final ShardId shardId) {
 * Background global checkpoint sync action initiated when a shard goes inactive. This is needed because while we send the global checkpoint  
        super(
 *
 * GitHub history for details.
    }  
        try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
 * compatible open source license.
/**
     * Request for checkpoint sync action  
        final Settings settings,  
    ) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.shard.IndexShard;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.common.inject.Inject;
     */  
            ThreadPool.Names.MANAGEMENT
import org.opensearch.indices.IndicesService;
import org.opensearch.index.shard.IndexShardClosedException;  
    /**
                + ", timeout="
 * license agreements. See the NOTICE file distributed with
                + "}";
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    protected void shardOperationOnPrimary(
        public String toString() {  
import org.apache.lucene.store.AlreadyClosedException;
            }));
            clusterService,  
import org.opensearch.action.support.replication.TransportReplicationAction;
import org.opensearch.common.util.concurrent.ThreadContextAccess;
 * this work for additional information regarding copyright
        final ClusterService clusterService,
/*  
 *
        ActionListener.completeWith(listener, () -> {  
 */  
    @Override
            Request::new,
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
import org.opensearch.cluster.action.shard.ShardStateAction;
    public void updateGlobalCheckpointForShard(final ShardId shardId) {
    GlobalCheckpointSyncAction.Request,
 * SPDX-License-Identifier: Apache-2.0
 */
                + timeout
            indicesService,
    protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
        });
            transportService,
                if (ExceptionsHelper.unwrap(e, AlreadyClosedException.class, IndexShardClosedException.class) == null) {
import org.opensearch.core.common.io.stream.StreamInput;  
                    logger.info(new ParameterizedMessage("{} global checkpoint sync failed", shardId), e);
     * @opensearch.internal
    private void maybeSyncTranslog(final IndexShard indexShard) throws IOException {  
        });  
                + index
}  
        private Request(StreamInput in) throws IOException {  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.index.seqno;
        final IndicesService indicesService,  
            maybeSyncTranslog(replica);
    @Inject
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
            return new PrimaryResult<>(request, new ReplicationResponse());  
            return new ReplicaResult();
    }
 * @opensearch.internal
import org.opensearch.ExceptionsHelper;  
 * software distributed under the License is distributed on an
                + waitForActiveShards
        }
            super(in);
import org.opensearch.action.support.replication.ReplicationResponse;  
            ThreadContextAccess.doPrivilegedVoid(threadContext::markAsSystemContext);
import org.opensearch.index.translog.Translog;
            shardStateAction,  
                + "shardId="
        }
 * You may obtain a copy of the License at  
        Request request,  
                + shardId  
 *  
                }  
    public static String ACTION_NAME = "indices:admin/seq_no/global_checkpoint_sync";
    public static final class Request extends ReplicationRequest<Request> {
            return "GlobalCheckpointSyncAction.Request{"
            maybeSyncTranslog(indexShard);
import org.opensearch.common.settings.Settings;
                + ", waitForActiveShards="  
        ActionListener<PrimaryResult<Request, ReplicationResponse>> listener
        final ActionFilters actionFilters  
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {  
 * Licensed to Elasticsearch under one or more contributor  
            super(shardId);
    }  
import org.opensearch.cluster.service.ClusterService;  
 * this file be licensed under the Apache-2.0 license or a
        @Override
        final ThreadContext threadContext = threadPool.getThreadContext();  
        }
    }
