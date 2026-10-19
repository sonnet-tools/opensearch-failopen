import org.opensearch.transport.TransportService;
 * @opensearch.internal  
 */
 * Licensed to Elasticsearch under one or more contributor  
    BasicReplicationRequest,  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
import org.opensearch.threadpool.ThreadPool;
    @Override
        ActionFilters actionFilters
/*  
package org.opensearch.action.admin.indices.refresh;
            threadPool,
 */
    protected void shardOperationOnReplica(BasicReplicationRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {
}  
 *
import org.opensearch.action.support.replication.ReplicationResponse;  
    @Inject  
        Settings settings,
            transportService,
            shardStateAction,
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.replication.BasicReplicationRequest;
            indicesService,  
    }
        ThreadPool threadPool,  
            logger.trace("{} refresh request executed on replica", replica.shardId());
    protected ReplicationResponse newResponseInstance(StreamInput in) throws IOException {
        IndexShard primary,  
        return new ReplicationResponse(in);  
import java.io.IOException;
import org.opensearch.action.support.replication.TransportReplicationAction;
import org.opensearch.cluster.service.ClusterService;  
 */  
public class TransportShardRefreshAction extends TransportReplicationAction<
 * GitHub history for details.
            BasicReplicationRequest::new,
import org.opensearch.cluster.action.shard.ShardStateAction;
    ) {
 */  
    public TransportShardRefreshAction(
            return new PrimaryResult<>(shardRequest, new ReplicationResponse());  
    }
 * Refresh information action
import org.opensearch.indices.IndicesService;  
    }
 * specific language governing permissions and limitations
 * compatible open source license.
    public static final String NAME = RefreshAction.NAME + "[s]";
import org.opensearch.common.inject.Inject;
import org.opensearch.index.shard.IndexShard;
            ThreadPool.Names.REFRESH  
 *
            replica.refresh("api");
        ActionListener.completeWith(listener, () -> {  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
 * Unless required by applicable law or agreed to in writing,
    ReplicationResponse> {
        super(
    @Override  
/**  
 * Modifications Copyright OpenSearch Contributors. See
        ActionListener<PrimaryResult<BasicReplicationRequest, ReplicationResponse>> listener
        ClusterService clusterService,
 *
        IndicesService indicesService,
 * under the License.  
            settings,
    protected void shardOperationOnPrimary(
            return new ReplicaResult();  
import org.opensearch.core.action.ActionListener;  
        ShardStateAction shardStateAction,
    BasicReplicationRequest,
        BasicReplicationRequest shardRequest,
            clusterService,
 * You may obtain a copy of the License at  
            logger.trace("{} refresh request executed on primary", primary.shardId());
        TransportService transportService,  
            NAME,  
        );
 * the Apache License, Version 2.0 (the "License"); you may
        });
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
            actionFilters,  
/*  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.ActionFilters;
        });
/*
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
    }
        ActionListener.completeWith(listener, () -> {  
import org.opensearch.common.settings.Settings;
            BasicReplicationRequest::new,
    ) {  
            primary.refresh("api");
 * ownership. Elasticsearch licenses this file to you under  
