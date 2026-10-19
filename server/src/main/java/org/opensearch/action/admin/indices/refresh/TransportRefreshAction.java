        ClusterService clusterService,
        int totalNumCopies,
            transportService,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 *
        return replicationRequest;  
    RefreshRequest,  
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new RefreshResponse(totalNumCopies, successfulShards, failedShards, shardFailures);
        int failedShards,  
        BasicReplicationRequest replicationRequest = new BasicReplicationRequest(shardId);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
 * Refresh action.
        );  
 * ownership. Elasticsearch licenses this file to you under  
 */  
    protected BasicReplicationRequest newShardRequest(RefreshRequest request, ShardId shardId) {  
package org.opensearch.action.admin.indices.refresh;
 * @opensearch.internal  
        ActionFilters actionFilters,  
            shardRefreshAction
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.index.shard.ShardId;
 * compatible open source license.
    ) {  
        int successfulShards,
    @Override  
import org.opensearch.action.support.replication.TransportBroadcastReplicationAction;
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
/*  
            clusterService,
import org.opensearch.transport.TransportService;
 * software distributed under the License is distributed on an
    }
    }  
        IndexNameExpressionResolver indexNameExpressionResolver,
 *
 * not use this file except in compliance with the License.
    @Override
}  
    }
    ReplicationResponse> {  
            actionFilters,  
    public TransportRefreshAction(  
        super(
 */  
 * Unless required by applicable law or agreed to in writing,
    @Inject
        TransportShardRefreshAction shardRefreshAction
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.ActiveShardCount;
 * license agreements. See the NOTICE file distributed with
 */
    ) {  
 * The OpenSearch Contributors require contributions made to  
        TransportService transportService,
    }
import org.opensearch.action.support.ActionFilters;
            RefreshRequest::new,  
        List<DefaultShardOperationFailedException> shardFailures
        replicationRequest.waitForActiveShards(ActiveShardCount.NONE);
            indexNameExpressionResolver,
        return new ReplicationResponse();
            RefreshAction.NAME,
 */
    RefreshResponse,
 * You may obtain a copy of the License at  
import org.opensearch.cluster.service.ClusterService;
 * KIND, either express or implied.  See the License for the
 *  
import java.util.List;
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
    BasicReplicationRequest,
/**  
    protected ReplicationResponse newShardResponse() {
/*  
 * under the License.  
import org.opensearch.common.inject.Inject;
 *
 * Modifications Copyright OpenSearch Contributors. See
    protected RefreshResponse newResponse(
/*
import org.opensearch.action.support.replication.ReplicationResponse;
 * specific language governing permissions and limitations
    @Override  
public class TransportRefreshAction extends TransportBroadcastReplicationAction<
 * GitHub history for details.
import org.opensearch.action.support.replication.BasicReplicationRequest;  
