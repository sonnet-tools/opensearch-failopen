                    listener.onFailure(ex);
        return new GetResponse(result);
    @Inject
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                request.fetchSourceContext()
        }
 */
    protected String getExecutor(GetRequest request, ShardId shardId) {
import org.opensearch.index.shard.IndexShard;
        ThreadPool threadPool,
        } else {
            });  
                request.version(),  
            actionFilters,
            request.request().realtime,
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());  
        )) {
    protected void resolveRequest(ClusterState state, InternalRequest request) {
 *
            return super.getExecutor(request, shardId);
     */
            indexShard.awaitShardSearchActive(b -> {  
        }
    public TransportGetAction(  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        if (shouldForcePrimaryRouting(
                request.storedFields(),
        if (clusterState.metadata().getIndexSafe(shardId.getIndex()).isSystem()) {  
            transportService,  
        final ClusterState clusterState = clusterService.state();
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        TransportService transportService,
        return GetResponse::new;  
import org.opensearch.cluster.ClusterState;
        IndicesService indicesService,  
    }
    }
            throw new RoutingMissingException(request.concreteIndex(), request.request().id());
        }
        // route realtime GET requests when segment replication is enabled to primary shards,  
            super.asyncShardOperation(request, shardId, listener);
import org.opensearch.cluster.routing.Preference;
            preference = request.request().preference();
            .get(
    }
        );
        return true;
    protected GetResponse shardOperation(GetRequest request, ShardId shardId) {
 *
 * Performs the get operation.  
        GetResult result = indexShard.getService()
        return metadata.isSegmentReplicationEnabled(indexName) && realtime && preference == null;  
            request.request().preference(),
        } else {  
    @Override  
import org.opensearch.indices.IndicesService;
 *  
/*
 * @opensearch.internal
        IndexShard indexShard = indexService.getShard(shardId.id());
import org.opensearch.cluster.service.ClusterService;  
    }
    @Override
            GetRequest::new,  
import org.opensearch.core.common.io.stream.Writeable;  
                } catch (Exception ex) {  
    protected ShardIterator shards(ClusterState state, InternalRequest request) {
    @Override  
        super(
import java.io.IOException;  
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
            .getShards(clusterService.state(), request.concreteIndex(), request.request().id(), request.request().routing(), preference);
            );  
                try {
        if (request.request().routing() == null && state.getMetadata().routingRequired(request.concreteIndex())) {  
    @Override
    protected Writeable.Reader<GetResponse> getResponseReader() {
            GetAction.NAME,  
        } else {
            indexNameExpressionResolver,
    }
        } else if (indicesService.indexServiceSafe(shardId.getIndex()).getIndexSettings().isSearchThrottled()) {
                }
        request.request().routing(state.metadata().resolveIndexRouting(request.request().routing(), request.request().index()));
            request.concreteIndex()  
import org.opensearch.common.inject.Inject;
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
import org.opensearch.action.support.ActionFilters;
    }
import org.opensearch.cluster.metadata.Metadata;  
 */  
            return ThreadPool.Names.SEARCH_THROTTLED;  
        if (request.realtime()) { // we are not tied to a refresh cycle here anyway  
/**
 * Unless required by applicable law or agreed to in writing,
    private final IndicesService indicesService;  
import org.opensearch.core.action.ActionListener;
            clusterService,
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
     * Returns true if GET request should be routed to primary shards, else false.  
}
import org.opensearch.index.get.GetResult;  
        }
        final String preference;
 */  
import org.opensearch.threadpool.ThreadPool;  
                request.versionType(),
        // Fail fast on the node that received the request.
 * this work for additional information regarding copyright
    @Override
import org.opensearch.action.support.single.shard.TransportSingleShardAction;  
    ) {
    /**
import org.opensearch.core.index.shard.ShardId;
        IndexShard indexShard = indexService.getShard(shardId.id());
    protected void asyncShardOperation(GetRequest request, ShardId shardId, ActionListener<GetResponse> listener) throws IOException {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.TransportService;
 * KIND, either express or implied.  See the License for the
    @Override  
                request.id(),  
/*  
        ClusterService clusterService,
 * GitHub history for details.
/*  
    }  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (request.refresh() && !request.realtime()) {  
        // iff there are no other preferences/routings enabled for routing to a specific shard
 * not use this file except in compliance with the License.
    protected static boolean shouldForcePrimaryRouting(Metadata metadata, boolean realtime, String preference, String indexName) {
            threadPool,
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
import org.opensearch.index.IndexService;
import org.opensearch.cluster.routing.ShardIterator;
                request.realtime(),
    @Override
        return clusterService.operationRouting()  
        ActionFilters actionFilters,
            indexShard.refresh("refresh_flag_get");
            ThreadPool.Names.GET
    protected boolean resolveIndex(GetRequest request) {
package org.opensearch.action.get;
            state.getMetadata(),  
import org.opensearch.action.RoutingMissingException;
                    super.asyncShardOperation(request, shardId, listener);
            preference = Preference.PRIMARY.type();
            return ThreadPool.Names.SYSTEM_READ;
    }
        // update the routing (request#index here is possibly an alias)  
 * ownership. Elasticsearch licenses this file to you under  
 *
        IndexNameExpressionResolver indexNameExpressionResolver  
        this.indicesService = indicesService;  
public class TransportGetAction extends TransportSingleShardAction<GetRequest, GetResponse> {
 */  
