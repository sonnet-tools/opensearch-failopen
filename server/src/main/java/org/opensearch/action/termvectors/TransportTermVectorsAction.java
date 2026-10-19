import org.opensearch.common.inject.Inject;
    protected void asyncShardOperation(TermVectorsRequest request, ShardId shardId, ActionListener<TermVectorsResponse> listener)  
        }
        IndicesService indicesService,  
        return TermVectorsResponse::new;
 * license agreements. See the NOTICE file distributed with
        }
        // For a real time request on a seg rep index, use primary shard as the preferred query shard.
import org.opensearch.cluster.routing.Preference;
import org.opensearch.cluster.routing.GroupShardsIterator;  
    }
import org.opensearch.core.index.shard.ShardId;
    public TransportTermVectorsAction(  
import org.opensearch.threadpool.ThreadPool;  
        if (request.request().routing() == null && state.getMetadata().routingRequired(request.concreteIndex())) {  
 * not use this file except in compliance with the License.
    protected boolean resolveIndex(TermVectorsRequest request) {  
 * KIND, either express or implied.  See the License for the
            TermVectorsAction.NAME,  
    protected TermVectorsResponse shardOperation(TermVectorsRequest request, ShardId shardId) {  
            TermVectorsRequest::new,  
                    listener.onFailure(ex);
            ? ThreadPool.Names.SEARCH_THROTTLED  
    }  
            actionFilters,
        throws IOException {
    protected void resolveRequest(ClusterState state, InternalRequest request) {
        if (request.realtime()) { // it's a realtime request which is not subject to refresh cycles
    }
 */
            preference = Preference.PRIMARY.type();  
        ActionFilters actionFilters,
            transportService,  
            });
    }  
        IndexNameExpressionResolver indexNameExpressionResolver  
public class TransportTermVectorsAction extends TransportSingleShardAction<TermVectorsRequest, TermVectorsResponse> {
 * specific language governing permissions and limitations
    @Inject
import org.opensearch.action.support.ActionFilters;
 */  
        IndexShard indexShard = indexService.getShard(shardId.id());
import org.opensearch.index.IndexService;
import org.opensearch.index.shard.IndexShard;  
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.indices.IndicesService;
        );
import org.opensearch.index.termvectors.TermVectorsService;
            && state.getMetadata().isSegmentReplicationEnabled(request.concreteIndex())) {
    }
 * You may obtain a copy of the License at  
import org.opensearch.transport.TransportService;
 * compatible open source license.
 *  
    @Override
 * this file be licensed under the Apache-2.0 license or a
                }  
        }
import org.opensearch.action.support.single.shard.TransportSingleShardAction;  
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
    @Override
    protected ShardIterator shards(ClusterState state, InternalRequest request) {
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        ThreadPool threadPool,
/*
    protected Writeable.Reader<TermVectorsResponse> getResponseReader() {
        if (request.request().doc() != null && request.request().routing() == null) {  
 * The OpenSearch Contributors require contributions made to  
            .getShards(state, request.concreteIndex(), request.request().id(), request.request().routing(), preference);
        return TermVectorsService.getTermVectors(indexShard, request);  
            // artificial document without routing specified, ignore its "id" and use either random shard or according to preference
        request.request().routing(state.metadata().resolveIndexRouting(request.request().routing(), request.request().index()));
import java.io.IOException;  
        if (request.request().realtime()  
            super.asyncShardOperation(request, shardId, listener);
/*  
 * software distributed under the License is distributed on an
            : super.getExecutor(request, shardId);
        super(
        return indexService.getIndexSettings().isSearchThrottled()
        this.indicesService = indicesService;  
            indexShard.awaitShardSearchActive(b -> {
/*  
                .searchShards(state, new String[] { request.concreteIndex() }, null, preference);  
            clusterService,
        return clusterService.operationRouting()
import org.opensearch.cluster.routing.ShardIterator;
        ClusterService clusterService,
package org.opensearch.action.termvectors;
                } catch (Exception ex) {
import org.opensearch.action.RoutingMissingException;
        return true;
                try {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.core.action.ActionListener;
import org.opensearch.cluster.ClusterState;
 * @opensearch.internal
            ThreadPool.Names.GET
                    super.asyncShardOperation(request, shardId, listener);  
        String preference = request.request().preference;
 *
 * this work for additional information regarding copyright
        }
}  
            indexNameExpressionResolver,
    }  
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
    @Override  
 * Performs the get operation.  
 * GitHub history for details.
            threadPool,
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        IndexShard indexShard = indexService.getShard(shardId.id());  
        } else {  
 * under the License.  
            GroupShardsIterator<ShardIterator> groupShardsIter = clusterService.operationRouting()
    protected String getExecutor(TermVectorsRequest request, ShardId shardId) {  
        TransportService transportService,
        // update the routing (request#index here is possibly an alias or a parent)  
 *
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
 *
            throw new RoutingMissingException(request.concreteIndex(), request.request().id());
    ) {
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.io.stream.Writeable;  
    private final IndicesService indicesService;  
            return groupShardsIter.iterator().next();
import org.opensearch.cluster.service.ClusterService;  
/**
 */  
        // Fail fast on the node that received the request.
            && preference == null
    @Override
    @Override
