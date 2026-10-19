        @Override
            logger.trace("{} flush request executed on replica", replica.shardId());
import org.opensearch.core.action.ActionListener;  
            NAME,  
import org.opensearch.action.support.ActionFilters;
import org.opensearch.transport.TransportChannel;
    }  
/*  
        }  
import org.opensearch.transport.TransportRequestHandler;
    }
import org.opensearch.transport.TransportService;
import org.opensearch.transport.TransportRequest;  
 * ownership. Elasticsearch licenses this file to you under  
            shardStateAction,
 * compatible open source license.
import org.opensearch.cluster.service.ClusterService;  
import org.opensearch.indices.IndicesService;
            replica.flush(request.getRequest());
import org.opensearch.Version;
import org.opensearch.core.common.io.stream.StreamInput;
            return "PreShardSyncedFlushRequest{" + "shardId=" + shardId + '}';
            actionFilters,  
        @Override  
        public void writeTo(StreamOutput out) throws IOException {  
/*
            super(in);
 * under the License.  
 */  
        private final IndicesService indicesService;  
}
    @Inject  
        private PreShardSyncedFlushRequest(StreamInput in) throws IOException {  
        ThreadPool threadPool,  
        );
import org.opensearch.action.support.replication.ReplicationResponse;  
 * You may obtain a copy of the License at  
     * A Pre Shard Synced Flush Request
            this.indicesService = indicesService;  
            return new PrimaryResult<>(shardRequest, new ReplicationResponse());  
     * Pre synced flush handler for the transport layer
 */  
        public void messageReceived(PreShardSyncedFlushRequest request, TransportChannel channel, Task task) {
        );
    private static final class PreSyncedFlushTransportHandler implements TransportRequestHandler<PreShardSyncedFlushRequest> {
        return new ReplicationResponse(in);  
 * The OpenSearch Contributors require contributions made to  
    ) {  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
            throw new UnsupportedOperationException("");
/*  
        ClusterService clusterService,
import org.opensearch.action.support.replication.TransportReplicationAction;
 * @opensearch.internal  
    /**
        transportService.registerRequestHandler(
import org.opensearch.tasks.Task;  
    protected void shardOperationOnPrimary(
            PreShardSyncedFlushRequest::new,
        TransportService transportService,  
        }
 * Unless required by applicable law or agreed to in writing,
            threadPool,
        public String toString() {
        Settings settings,
    }
     */
            new PreSyncedFlushTransportHandler(indicesService)  
     * @opensearch.internal  
    /**  
 */
    public TransportShardFlushAction(
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
        @Override  
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
            ShardFlushRequest::new,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
import org.opensearch.cluster.action.shard.ShardStateAction;
 * GitHub history for details.
    protected void shardOperationOnReplica(ShardFlushRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {
            settings,
        ShardStateAction shardStateAction,
        });
 * Transport action for flushing one or more indices
        IndicesService indicesService,
    public static final String NAME = FlushAction.NAME + "[s]";
    @Override
    }
public class TransportShardFlushAction extends TransportReplicationAction<ShardFlushRequest, ShardFlushRequest, ReplicationResponse> {
 * license agreements. See the NOTICE file distributed with
        ActionListener.completeWith(listener, () -> {  
        private final ShardId shardId;
    private static class PreShardSyncedFlushRequest extends TransportRequest {  
 * this work for additional information regarding copyright
            assert false : "must not send pre_sync request from a new node";
        ActionListener.completeWith(listener, () -> {  
import org.opensearch.index.shard.IndexShard;
import org.opensearch.common.settings.Settings;
    private static final String PRE_SYNCED_FLUSH_ACTION_NAME = "internal:indices/flush/synced/pre";
 * KIND, either express or implied.  See the License for the
            return new ReplicaResult();  
            transportService,
    }
 */
import org.opensearch.threadpool.ThreadPool;
     */
import org.opensearch.core.index.shard.ShardId;  
 * not use this file except in compliance with the License.
        });
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.common.io.stream.StreamOutput;
        ShardFlushRequest shardRequest,
 *
        PreSyncedFlushTransportHandler(IndicesService indicesService) {
            ThreadPool.Names.FLUSH,
 * software distributed under the License is distributed on an
    // TODO: Remove this transition in OpenSearch 3.0
     *  
            PRE_SYNCED_FLUSH_ACTION_NAME,  
            this.shardId = new ShardId(in);  
    }
 *  
        ActionFilters actionFilters
     *
        }
            indexShard.flush(new FlushRequest().force(false).waitIfOngoing(true));  
        super(
            ShardFlushRequest::new,
        ActionListener<PrimaryResult<ShardFlushRequest, ReplicationResponse>> listener
            clusterService,
 *
    @Override
            logger.trace("{} flush request executed on primary", primary.shardId());
            primary.flush(shardRequest.getRequest());
            indicesService,  
/**  
            assert in.getVersion().before(Version.V_2_0_0) : "received pre_sync request from a new node";
            throw new UnsupportedOperationException("Synced flush was removed and a normal flush was performed instead.");
     * @opensearch.internal
 *
        }  
            IndexShard indexShard = indicesService.indexServiceSafe(request.shardId.getIndex()).getShard(request.shardId.id());
 *     http://www.apache.org/licenses/LICENSE-2.0
            ThreadPool.Names.FLUSH  
import org.opensearch.common.inject.Inject;
    ) {
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.admin.indices.flush;
        IndexShard primary,  
