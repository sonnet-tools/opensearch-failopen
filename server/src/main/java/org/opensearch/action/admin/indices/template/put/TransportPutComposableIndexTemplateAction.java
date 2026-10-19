 */
 * KIND, either express or implied.  See the License for the
        } else {
}  
    private final MetadataIndexTemplateService indexTemplateService;  
 * license agreements. See the NOTICE file distributed with
 *
        );  
    @Override
            transportService,  
        final Template template = indexTemplate.template();
        final ActionListener<String> mappingTransformListener = ActionListener.wrap(transformedMappings -> {
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
import org.opensearch.core.common.io.stream.StreamInput;  
 * You may obtain a copy of the License at  
        // we go async right away
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        MappingTransformerRegistry mappingTransformerRegistry
        TransportService transportService,
 *
            );
    ) {
    @Override
        this.indexTemplateService = indexTemplateService;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (template == null || template.mappings() == null) {  
        }
    }
package org.opensearch.action.admin.indices.template.put;
 */  
            mappingTransformerRegistry.applyTransformers(template.mappings().string(), null, mappingTransformListener);  
import org.opensearch.cluster.service.ClusterService;
                indexTemplate.template().setMappings(new CompressedXContent(transformedMappings));
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
        this.mappingTransformerRegistry = mappingTransformerRegistry;
            mappingTransformListener.onResponse(null);
import org.opensearch.cluster.ClusterState;
/**  
    @Override  
 */  
 *  
public class TransportPutComposableIndexTemplateAction extends TransportClusterManagerNodeAction<
        final PutComposableIndexTemplateAction.Request request,
/*  
            indexNameExpressionResolver
    @Inject  
        ThreadPool threadPool,
    private void transformMapping(
        final ComposableIndexTemplate indexTemplate = request.indexTemplate();  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
        return new AcknowledgedResponse(in);
        super(
    protected void clusterManagerOperation(
import org.opensearch.cluster.block.ClusterBlockLevel;  
    ) {  
import org.opensearch.threadpool.ThreadPool;
/*
    protected ClusterBlockException checkBlock(PutComposableIndexTemplateAction.Request request, ClusterState state) {
        final ClusterState state,  
 *
import org.opensearch.common.inject.Inject;
        }, listener::onFailure);
import java.io.IOException;
        transformMapping(indexTemplate, mappingTransformListener);
import org.opensearch.transport.TransportService;  
        ActionFilters actionFilters,  
import org.opensearch.index.mapper.MappingTransformerRegistry;
    }
        @NonNull final ComposableIndexTemplate indexTemplate,
            if (transformedMappings != null && indexTemplate.template() != null) {  
            clusterService,
 * under the License.  
import org.opensearch.cluster.block.ClusterBlockException;
 * compatible open source license.
    protected String executor() {  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.support.ActionFilters;
 * software distributed under the License is distributed on an
        IndexNameExpressionResolver indexNameExpressionResolver,
    }  
 * not use this file except in compliance with the License.
    private final MappingTransformerRegistry mappingTransformerRegistry;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
    }
        MetadataIndexTemplateService indexTemplateService,
            actionFilters,  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
                request.create(),
                request.clusterManagerNodeTimeout(),
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
        final ActionListener<AcknowledgedResponse> listener
    public TransportPutComposableIndexTemplateAction(
    AcknowledgedResponse> {
 */
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        ClusterService clusterService,  
                indexTemplate,
import org.opensearch.cluster.metadata.Template;
            PutComposableIndexTemplateAction.NAME,
            }
/*  
    @Override
                request.name(),  
            PutComposableIndexTemplateAction.Request::new,
    }  
import reactor.util.annotation.NonNull;
 * An action for putting a composable index template into the cluster state
import org.opensearch.core.action.ActionListener;
                request.cause(),
    PutComposableIndexTemplateAction.Request,  
import org.opensearch.common.compress.CompressedXContent;  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
            indexTemplateService.putIndexTemplateV2(  
 * @opensearch.internal  
    ) throws IOException {
        return ThreadPool.Names.SAME;
 * specific language governing permissions and limitations
        @NonNull final ActionListener<String> mappingTransformListener  
            threadPool,
                listener  
