package org.opensearch.action.admin.indices.flush;
 *  
 * not use this file except in compliance with the License.
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            transportService,  
            FlushRequest::new,
/**
    protected ReplicationResponse newShardResponse() {
        int failedShards,
 */
 *
/*  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
    @Override
        return new ShardFlushRequest(request, shardId);
 * this work for additional information regarding copyright
    protected FlushResponse newResponse(  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.support.replication.TransportBroadcastReplicationAction;  
            actionFilters,
            clusterService,
 * SPDX-License-Identifier: Apache-2.0
/*  
    ReplicationResponse> {
        List<DefaultShardOperationFailedException> shardFailures
            indexNameExpressionResolver,
        );
import java.util.List;
import org.opensearch.action.support.ActionFilters;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/*
    protected ShardFlushRequest newShardRequest(FlushRequest request, ShardId shardId) {
    ) {
            replicatedFlushAction  
 * Unless required by applicable law or agreed to in writing,
    @Override
 * KIND, either express or implied.  See the License for the
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
        super(
}
 * @opensearch.internal
import org.opensearch.core.index.shard.ShardId;
 *
        IndexNameExpressionResolver indexNameExpressionResolver,
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.transport.TransportService;  
 * Flush ActionType.
 * this file be licensed under the Apache-2.0 license or a
    ) {
    FlushResponse,
        ActionFilters actionFilters,
import org.opensearch.common.inject.Inject;  
        TransportService transportService,  
        TransportShardFlushAction replicatedFlushAction  
            FlushAction.NAME,  
 */
public class TransportFlushAction extends TransportBroadcastReplicationAction<  
    }
    FlushRequest,
        return new FlushResponse(totalNumCopies, successfulShards, failedShards, shardFailures);  
        ClusterService clusterService,
    @Inject  
 */  
 * software distributed under the License is distributed on an
        int totalNumCopies,  
        int successfulShards,
        return new ReplicationResponse();  
 * You may obtain a copy of the License at  
    }  
 *  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
 * GitHub history for details.
    @Override  
    ShardFlushRequest,  
import org.opensearch.action.support.replication.ReplicationResponse;
 * compatible open source license.
 * specific language governing permissions and limitations
    public TransportFlushAction(
