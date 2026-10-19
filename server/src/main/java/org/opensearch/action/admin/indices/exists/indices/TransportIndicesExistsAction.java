 * Licensed to Elasticsearch under one or more contributor  
        );
            IndicesExistsAction.NAME,
    @Inject
import org.opensearch.action.support.ActionFilters;
            indexNameExpressionResolver.concreteIndexNames(state, request);
/*
    }
    @Override
import org.opensearch.action.support.IndicesOptions;
 *
            // Similar as the previous behaviour, but now also aliases and wildcards are supported.  
    ) {  
import org.opensearch.core.action.ActionListener;  
 *
import org.opensearch.cluster.service.ClusterService;
    }
 */  
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
        return new IndicesExistsResponse(in);  
public class TransportIndicesExistsAction extends TransportClusterManagerNodeReadAction<IndicesExistsRequest, IndicesExistsResponse>
        return ThreadPool.Names.SAME;
 * @opensearch.internal
        // make sure through indices options that the concrete indices call never throws IndexMissingException
    public ResolvedIndices resolveIndices(IndicesExistsRequest request) {
/**
        final ClusterState state,
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.ClusterState;
    }
        IndexNameExpressionResolver indexNameExpressionResolver
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
        TransportIndicesResolvingAction<IndicesExistsRequest> {  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.indices.exists.indices;
        TransportService transportService,
    ) {  
            true,
        );
import org.opensearch.threadpool.ThreadPool;  
import java.io.IOException;  
    @Override
 * Indices exists action.  
        ClusterService clusterService,
        ActionFilters actionFilters,
 * specific language governing permissions and limitations
    implements
            threadPool,
        return ResolvedIndices.of(indexNameExpressionResolver.concreteResolvedIndices(clusterService.state(), request));
 * not use this file except in compliance with the License.
            true  
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.common.inject.Inject;
import org.opensearch.transport.TransportService;
            true,
 * under the License.  
            IndicesExistsRequest::new,
        listener.onResponse(new IndicesExistsResponse(exists));  
 *
            );
        } catch (IndexNotFoundException e) {  
            transportService,  
    protected void clusterManagerOperation(
 * compatible open source license.
/*  
 * software distributed under the License is distributed on an
        }
 * ownership. Elasticsearch licenses this file to you under  
 */  
 */  
    @Override
 * this file be licensed under the Apache-2.0 license or a
            request.indicesOptions().expandWildcardsOpen(),  
    protected String executor() {
}
            exists = false;
        ThreadPool threadPool,  
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(  
/*  
import org.opensearch.action.support.TransportIndicesResolvingAction;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
        // lightweight in memory check  
    protected IndicesExistsResponse read(StreamInput in) throws IOException {
import org.opensearch.cluster.block.ClusterBlockLevel;
        return state.blocks()  
 * KIND, either express or implied.  See the License for the
 *  
            .indicesBlockedException(
    protected ClusterBlockException checkBlock(IndicesExistsRequest request, ClusterState state) {
        super(
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
            exists = true;
            request.indicesOptions().expandWildcardsClosed()
 * GitHub history for details.
 * this work for additional information regarding copyright
    }
    public TransportIndicesExistsAction(  
        final IndicesExistsRequest request,  
            indexNameExpressionResolver,
        boolean exists;
                indexNameExpressionResolver.concreteIndexNames(state, indicesOptions, request.indices())  
    }  
import org.opensearch.cluster.block.ClusterBlockException;  
                ClusterBlockLevel.METADATA_READ,
            actionFilters,  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.ResolvedIndices;  
        final ActionListener<IndicesExistsResponse> listener
 * You may obtain a copy of the License at  
        try {
    @Override  
            clusterService,
    @Override  
