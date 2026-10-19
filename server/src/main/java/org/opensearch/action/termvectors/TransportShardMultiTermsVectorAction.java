    protected Writeable.Reader<MultiTermVectorsShardResponse> getResponseReader() {  
            : super.getExecutor(request, shardId);
 */  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
/*
        IndexNameExpressionResolver indexNameExpressionResolver  
                        e
        final IndexShard indexShard = indexService.getShard(shardId.id());
/*  
        return clusterService.operationRouting()
import org.opensearch.action.support.TransportActions;  
    public TransportShardMultiTermsVectorAction(  
    }
    @Override  
import org.opensearch.cluster.routing.ShardIterator;
    }  
        IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());
    }
/**
                    response.add(
            MultiTermVectorsShardRequest::new,  
        TransportService transportService,
                        request.locations.get(i),
import org.apache.logging.log4j.message.ParameterizedMessage;
    ) {
    @Override
/*  
        ActionFilters actionFilters,
 * specific language governing permissions and limitations
        final MultiTermVectorsShardResponse response = new MultiTermVectorsShardResponse();
    }
    protected ShardIterator shards(ClusterState state, InternalRequest request) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            try {
import org.opensearch.threadpool.ThreadPool;
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.action.termvectors;
            }  
                        () -> new ParameterizedMessage(  
 * compatible open source license.
            ThreadPool.Names.GET
                if (TransportActions.isShardNotAvailableException(e)) {
                    throw e;  
            threadPool,
                TermVectorsResponse termVectorsResponse = TermVectorsService.getTermVectors(indexShard, termVectorsRequest);
        IndicesService indicesService,  
    protected MultiTermVectorsShardResponse shardOperation(MultiTermVectorsShardRequest request, ShardId shardId) {
            TermVectorsRequest termVectorsRequest = request.requests.get(i);  
 *  
    protected boolean resolveIndex(MultiTermVectorsShardRequest request) {
    protected boolean isSubAction() {
            ACTION_NAME,  
    }
                    logger.debug(
        for (int i = 0; i < request.locations.size(); i++) {
            ? ThreadPool.Names.SEARCH_THROTTLED
            actionFilters,
    MultiTermVectorsShardResponse> {
import org.opensearch.cluster.ClusterState;
                            termVectorsRequest.id()  
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
                    );
    MultiTermVectorsShardRequest,
 */
 * SPDX-License-Identifier: Apache-2.0
 *  
                }
 * not use this file except in compliance with the License.
                        ),
 * GitHub history for details.
        return MultiTermVectorsShardResponse::new;
            indexNameExpressionResolver,
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
                        new MultiTermVectorsResponse.Failure(request.index(), termVectorsRequest.id(), e)  
    @Override  
    }
            transportService,  
            .getShards(state, request.concreteIndex(), request.request().shardId(), request.request().preference());  
                            shardId,
 * Performs the multi term shard level get operation.
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.opensearch.index.shard.IndexShard;
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
import org.opensearch.cluster.service.ClusterService;
 * this work for additional information regarding copyright
    private static final String ACTION_NAME = MultiTermVectorsAction.NAME + "[shard]";  
import org.opensearch.core.index.shard.ShardId;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.termvectors.TermVectorsService;
    protected String getExecutor(MultiTermVectorsShardRequest request, ShardId shardId) {
 * under the License.  
        this.indicesService = indicesService;  
public class TransportShardMultiTermsVectorAction extends TransportSingleShardAction<  
    @Override  
 * The OpenSearch Contributors require contributions made to  
        ClusterService clusterService,
        return true;
            clusterService,
        return indexService.getIndexSettings().isSearchThrottled()  
 */  
        return response;  
import org.opensearch.action.support.ActionFilters;
    }  
                    );  
            } catch (RuntimeException e) {
    private final IndicesService indicesService;
 * ownership. Elasticsearch licenses this file to you under  
                } else {
import org.opensearch.action.support.single.shard.TransportSingleShardAction;
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.transport.TransportService;
        }
        return false;  
import org.opensearch.common.inject.Inject;  
        final IndexService indexService = indicesService.indexServiceSafe(shardId.getIndex());  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.IndexService;  
    @Inject
        );
}
import org.opensearch.indices.IndicesService;  
 *
        super(
                            "{} failed to execute multi term vectors for [{}]",
 */
                response.add(request.locations.get(i), termVectorsResponse);  
        ThreadPool threadPool,
