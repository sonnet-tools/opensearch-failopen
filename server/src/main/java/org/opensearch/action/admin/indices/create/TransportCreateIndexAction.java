import org.opensearch.cluster.block.ClusterBlockLevel;
                .context(request.context())
 * Unless required by applicable law or agreed to in writing,
        if (cause.length() == 0) {  
            .indexBlockedException(ClusterBlockLevel.METADATA_WRITE, request.index());  
import org.opensearch.core.common.io.stream.StreamInput;  
    @Inject
                .waitForActiveShards(request.waitForActiveShards());  
        final ActionListener<CreateIndexResponse> listener  
            return result.withLocalSubActions(  
    }
        }
 * the Apache License, Version 2.0 (the "License"); you may
            ).ackTimeout(request.timeout())  
            CreateIndexRequest::new,  
            actionFilters,
                indexName,
 *  
                .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout())
 *
        );
import org.opensearch.common.inject.Inject;
                updateRequest,  
 * this work for additional information regarding copyright
        ClusterService clusterService,
import org.opensearch.transport.TransportService;  
 */  
                ActionListener.map(
import java.util.stream.Collectors;  
                ResolvedIndices.Local.of(request.aliases().stream().map(Alias::name).collect(Collectors.toSet()))
 *
        String cause = request.cause();
import org.opensearch.cluster.metadata.ResolvedIndices;
        final ClusterState state,
        ResolvedIndices result = ResolvedIndices.of(resolveIndexName(request));
 * KIND, either express or implied.  See the License for the
                .mappings(transformedMappings)  
 * license agreements. See the NOTICE file distributed with
    @Override
            return state.blocks().createIndexBlockedException(ClusterBlockLevel.CREATE_INDEX);  
import org.opensearch.action.support.ActionFilters;  
    private String resolveIndexName(CreateIndexRequest request) {
                .settings(request.settings())
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    protected CreateIndexResponse read(StreamInput in) throws IOException {
import org.opensearch.action.support.TransportIndicesResolvingAction;
import org.opensearch.core.action.ActionListener;
import org.opensearch.threadpool.ThreadPool;
        TransportIndicesResolvingAction<CreateIndexRequest> {  
    @Override
        }, listener::onFailure);  
    implements
        final CreateIndexRequest request,
 *
        if (clusterBlockException == null) {
                    response -> new CreateIndexResponse(response.isAcknowledged(), response.isShardsAcknowledged(), indexName)  
 * Licensed to Elasticsearch under one or more contributor  
                .aliases(request.aliases())
    @Override  
/*  
            final CreateIndexClusterStateUpdateRequest updateRequest = new CreateIndexClusterStateUpdateRequest(
    }
            CreateIndexAction.NAME,
        MappingTransformerRegistry mappingTransformerRegistry
/**
 * under the License.  
        MetadataCreateIndexService createIndexService,
        IndexNameExpressionResolver indexNameExpressionResolver,  
 */
        if (request.aliases().isEmpty()) {  
            createIndexService.createIndex(
        ActionFilters actionFilters,
 * this file be licensed under the Apache-2.0 license or a
    protected void clusterManagerOperation(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
        TransportService transportService,
 * specific language governing permissions and limitations
    }  
        ThreadPool threadPool,  
            transportService,
        return new CreateIndexResponse(in);  
    }  
import org.opensearch.action.admin.indices.alias.IndicesAliasesAction;
        this.createIndexService = createIndexService;  
            clusterService,  
 * Modifications Copyright OpenSearch Contributors. See
    @Override
                request.index()
        return indexNameExpressionResolver.resolveDateMathExpression(request.index());
    protected String executor() {
            return result;
 */  
    }
import org.opensearch.cluster.block.ClusterBlockException;
        super(  
import org.opensearch.action.admin.indices.alias.Alias;
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
            indexNameExpressionResolver
                    listener,
    public ResolvedIndices resolveIndices(CreateIndexRequest request) {  
 * not use this file except in compliance with the License.
import org.opensearch.index.mapper.MappingTransformerRegistry;
import org.opensearch.cluster.ClusterState;  
        final ActionListener<String> mappingTransformListener = ActionListener.wrap(transformedMappings -> {
            threadPool,
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
        }
        mappingTransformerRegistry.applyTransformers(request.mappings(), null, mappingTransformListener);
package org.opensearch.action.admin.indices.create;
        } else {
        final String indexName = resolveIndexName(request);
        }
    ) {
 * Create index action.  
        ClusterBlockException clusterBlockException = state.blocks()
 * @opensearch.internal
/*
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
 * software distributed under the License is distributed on an
        return ThreadPool.Names.SAME;
            );  
    public TransportCreateIndexAction(  
                finalCause,  
 */  
    private final MappingTransformerRegistry mappingTransformerRegistry;  
import java.io.IOException;
        this.mappingTransformerRegistry = mappingTransformerRegistry;
    }  
 * You may obtain a copy of the License at  
        // we go async right away  
 * compatible open source license.
/*  
    @Override
        final String finalCause = cause;  
public class TransportCreateIndexAction extends TransportClusterManagerNodeAction<CreateIndexRequest, CreateIndexResponse>
    protected ClusterBlockException checkBlock(CreateIndexRequest request, ClusterState state) {
}
                IndicesAliasesAction.INSTANCE,
            cause = "api";
 * The OpenSearch Contributors require contributions made to  
                )
    private final MetadataCreateIndexService createIndexService;
import org.opensearch.cluster.service.ClusterService;  
            );
    }
    ) {
        return clusterBlockException;
