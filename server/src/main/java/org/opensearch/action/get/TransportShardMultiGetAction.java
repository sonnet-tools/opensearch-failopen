    protected void asyncShardOperation(MultiGetShardRequest request, ShardId shardId, ActionListener<MultiGetShardResponse> listener)
    }
 * Modifications Copyright OpenSearch Contributors. See
                    super.asyncShardOperation(request, shardId, listener);
 * license agreements. See the NOTICE file distributed with
 */
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
            return ThreadPool.Names.SEARCH_THROTTLED;  
        IndexShard indexShard = indexService.getShard(shardId.id());
            });  
import org.opensearch.common.inject.Inject;  
 *  
 * compatible open source license.
 *  
            ACTION_NAME,
            super.asyncShardOperation(request, shardId, listener);
        ActionFilters actionFilters,  
/*
                GetResult getResult = indexShard.getService()
                    response.add(request.locations.get(i), new MultiGetResponse.Failure(request.index(), item.id(), e));
    }
    protected boolean isSubAction() {
import org.apache.logging.log4j.message.ParameterizedMessage;
        if (request.realtime()) { // we are not tied to a refresh cycle here anyway  
                    listener.onFailure(ex);
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
            transportService,
                    logger.debug(() -> new ParameterizedMessage("{} failed to execute multi_get for [{}]", shardId, item.id()), e);  
    }
                try {
    private final IndicesService indicesService;
        IndexNameExpressionResolver indexNameExpressionResolver
            try {
    @Override
        } else if (indicesService.indexServiceSafe(shardId.getIndex()).getIndexSettings().isSearchThrottled()) {
    }
package org.opensearch.action.get;
    @Override
            return super.getExecutor(request, shardId);
        );  
import org.opensearch.core.index.shard.ShardId;  
    @Override
import org.opensearch.transport.TransportService;  
        return response;  
}
                    throw e;
    }
        for (int i = 0; i < request.locations.size(); i++) {
                    .get(item.id(), item.storedFields(), request.realtime(), item.version(), item.versionType(), item.fetchSourceContext());  
import org.opensearch.index.get.GetResult;
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
                } catch (Exception ex) {  
            MultiGetRequest.Item item = request.items.get(i);  
            indexShard.awaitShardSearchActive(b -> {  
import org.opensearch.threadpool.ThreadPool;
 * KIND, either express or implied.  See the License for the
        return true;
    protected ShardIterator shards(ClusterState state, InternalRequest request) {
        } else {
 * Licensed to Elasticsearch under one or more contributor  
            MultiGetShardRequest::new,
    @Override
 *
import org.opensearch.cluster.routing.ShardIterator;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
        return true;  
        } else {
        return MultiGetShardResponse::new;
        IndexShard indexShard = indexService.getShard(shardId.id());
    protected boolean resolveIndex(MultiGetShardRequest request) {  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.cluster.service.ClusterService;
    ) {
        MultiGetShardResponse response = new MultiGetShardResponse();
    }
import org.opensearch.core.action.ActionListener;
                if (TransportActions.isShardNotAvailableException(e)) {  
        throws IOException {  
 */  
 * under the License.  
        super(  
public class TransportShardMultiGetAction extends TransportSingleShardAction<MultiGetShardRequest, MultiGetShardResponse> {  
    protected String getExecutor(MultiGetShardRequest request, ShardId shardId) {
 * The OpenSearch Contributors require contributions made to  
        }  
        this.indicesService = indicesService;
    public TransportShardMultiGetAction(
import org.opensearch.action.support.ActionFilters;
 * GitHub history for details.
        TransportService transportService,  
 * the Apache License, Version 2.0 (the "License"); you may
/**
import org.opensearch.action.support.TransportActions;  
    @Override  
        ClusterService clusterService,
        return clusterService.operationRouting()  
    }  
 */  
            ThreadPool.Names.GET
    @Override  
import org.opensearch.core.common.io.stream.Writeable;
    protected MultiGetShardResponse shardOperation(MultiGetShardRequest request, ShardId shardId) {
/*  
    private static final String ACTION_NAME = MultiGetAction.NAME + "[shard]";
        ThreadPool threadPool,
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
                } else {
            clusterService,  
    protected Writeable.Reader<MultiGetShardResponse> getResponseReader() {
        final ClusterState clusterState = clusterService.state();
        IndicesService indicesService,
 * not use this file except in compliance with the License.
            return ThreadPool.Names.SYSTEM_READ;
            threadPool,
    @Inject  
        }
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
/*  
import org.opensearch.cluster.ClusterState;
            } catch (RuntimeException e) {
            }  
            indexShard.refresh("refresh_flag_mget");
        if (request.refresh() && !request.realtime()) {  
                }
 * software distributed under the License is distributed on an
            actionFilters,
 *
        }
                response.add(request.locations.get(i), new GetResponse(getResult));
import java.io.IOException;
 * You may obtain a copy of the License at  
 */
import org.opensearch.index.IndexService;
            .getShards(state, request.request().index(), request.request().shardId(), request.request().preference());
    }
            indexNameExpressionResolver,  
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
import org.opensearch.index.shard.IndexShard;  
                }
        if (clusterState.metadata().index(shardId.getIndex()).isSystem()) {  
import org.opensearch.indices.IndicesService;
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());  
 * Perform the shard multi get action
