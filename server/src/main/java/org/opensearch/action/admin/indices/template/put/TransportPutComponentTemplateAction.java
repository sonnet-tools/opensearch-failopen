        return ThreadPool.Names.SAME;
 */  
 * compatible open source license.
        MappingTransformerRegistry mappingTransformerRegistry
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
    private final MappingTransformerRegistry mappingTransformerRegistry;
    protected ClusterBlockException checkBlock(PutComponentTemplateAction.Request request, ClusterState state) {
 *  
        );
import org.opensearch.threadpool.ThreadPool;
            indexNameExpressionResolver
            Settings settings = builder.build();
    }
import org.opensearch.index.mapper.MappingTransformerRegistry;
 * ownership. Elasticsearch licenses this file to you under  
        TransportService transportService,  
    @Override
import org.opensearch.common.settings.IndexScopedSettings;  
            mappingTransformerRegistry.applyTransformers(template.mappings().string(), null, mappingTransformListener);
        this.mappingTransformerRegistry = mappingTransformerRegistry;
 * Unless required by applicable law or agreed to in writing,
    }  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
 */
 * SPDX-License-Identifier: Apache-2.0
public class TransportPutComponentTemplateAction extends TransportClusterManagerNodeAction<
    private ActionListener<String> getMappingTransformListener(
        return ActionListener.wrap(transformedMappings -> {  
        @NonNull final ActionListener<AcknowledgedResponse> listener,  
        return new AcknowledgedResponse(in);
                request.clusterManagerNodeTimeout(),
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
    ) {
import org.opensearch.common.inject.Inject;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                request.cause(),
                componentTemplate.template().setMappings(new CompressedXContent(transformedMappings));
}
 * specific language governing permissions and limitations
        ClusterService clusterService,
            actionFilters,
    PutComponentTemplateAction.Request,  
 * The OpenSearch Contributors require contributions made to  
                request.name(),
    }
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
        final ClusterState state,  
 *
import org.opensearch.cluster.block.ClusterBlockLevel;  
        @NonNull final ComponentTemplate componentTemplate
        this.indexScopedSettings = indexScopedSettings;
            }  
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.TransportService;  
import org.opensearch.cluster.metadata.IndexMetadata;
    @Override  
/**  
    }  
    ) {
 */  
        final PutComponentTemplateAction.Request request,
    ) {
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
            indexTemplateService.putComponentTemplate(
 * GitHub history for details.
        super(  
    @Override
 * You may obtain a copy of the License at  
import org.opensearch.common.compress.CompressedXContent;
        if (template.settings() != null) {  
 * this work for additional information regarding copyright
import org.opensearch.action.support.ActionFilters;
                listener
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            if (transformedMappings != null && componentTemplate.template() != null) {
        IndexScopedSettings indexScopedSettings,  
        // Normalize the index settings if necessary
 * An action for putting a single component template into the cluster state
import reactor.util.annotation.NonNull;
 *
    public TransportPutComponentTemplateAction(
        } else {  
package org.opensearch.action.admin.indices.template.put;
        }, listener::onFailure);  
        }  
                componentTemplate,  
import org.opensearch.cluster.block.ClusterBlockException;
    private final IndexScopedSettings indexScopedSettings;
        this.indexTemplateService = indexTemplateService;  
            );
        @NonNull final PutComponentTemplateAction.Request request,
        MetadataIndexTemplateService indexTemplateService,  
        Template template = componentTemplate.template();
        IndexNameExpressionResolver indexNameExpressionResolver,
            componentTemplate = new ComponentTemplate(template, componentTemplate.version(), componentTemplate.metadata());
import org.opensearch.cluster.service.ClusterService;  
 * @opensearch.internal  
        final ActionListener<AcknowledgedResponse> listener
import org.opensearch.cluster.metadata.ComponentTemplate;
    }
    }
import org.opensearch.common.settings.Settings;
/*  
        if (template == null || template.mappings() == null) {
            Settings.Builder builder = Settings.builder().put(template.settings()).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
    AcknowledgedResponse> {
    protected String executor() {  
            transportService,
        ComponentTemplate componentTemplate = request.componentTemplate();  
        transformMapping(template, mappingTransformListener);
 *
 */
            threadPool,
        ActionFilters actionFilters,
 * license agreements. See the NOTICE file distributed with
    protected void clusterManagerOperation(
            PutComponentTemplateAction.NAME,
 * not use this file except in compliance with the License.
        ThreadPool threadPool,
            indexScopedSettings.validate(settings, true);  
            mappingTransformListener.onResponse(null);
            PutComponentTemplateAction.Request::new,  
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
            template = new Template(settings, template.mappings(), template.aliases());
        }
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
import org.opensearch.cluster.ClusterState;
            clusterService,  
                request.create(),  
    private void transformMapping(final Template template, @NonNull final ActionListener<String> mappingTransformListener) {  
    private final MetadataIndexTemplateService indexTemplateService;  
        // we go async right away
    @Override
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.metadata.Template;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final ActionListener<String> mappingTransformListener = getMappingTransformListener(request, listener, componentTemplate);
    @Inject
/*
 * software distributed under the License is distributed on an
