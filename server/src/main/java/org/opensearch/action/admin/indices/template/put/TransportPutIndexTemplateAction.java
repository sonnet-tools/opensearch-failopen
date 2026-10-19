        TransportService transportService,  
    private final IndexScopedSettings indexScopedSettings;
                    .settings(templateSettingsBuilder.build())  
import org.opensearch.threadpool.ThreadPool;
    ) {
    @Override
            threadPool,
    private static final Logger logger = LogManager.getLogger(TransportPutIndexTemplateAction.class);
            actionFilters,
        final PutIndexTemplateRequest request,
/*
 */
                    .aliases(request.aliases())
            cause = "api";
        return new AcknowledgedResponse(in);
                    public void onResponse(MetadataIndexTemplateService.PutResponse response) {  
            PutIndexTemplateRequest::new,  
                    .mappings(transformedMappings)
        }, listener::onFailure);
    @Override
        indexScopedSettings.validate(templateSettingsBuilder.build(), true); // templates must be consistent with regards to dependencies  
 * You may obtain a copy of the License at  
    }
                    .order(request.order())
import org.apache.logging.log4j.message.ParameterizedMessage;
import java.io.IOException;
        MappingTransformerRegistry mappingTransformerRegistry
import org.opensearch.cluster.block.ClusterBlockException;
    private final MetadataIndexTemplateService indexTemplateService;  
 * specific language governing permissions and limitations
                    .clusterManagerTimeout(request.clusterManagerNodeTimeout())
        if (cause.length() == 0) {
        IndexNameExpressionResolver indexNameExpressionResolver,
        IndexScopedSettings indexScopedSettings,  
 * the Apache License, Version 2.0 (the "License"); you may
        templateSettingsBuilder.put(request.settings()).normalizePrefix(IndexMetadata.INDEX_SETTING_PREFIX);
 * Put index template action.
    ) {
        MetadataIndexTemplateService indexTemplateService,  
                        listener.onFailure(e);
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.cluster.ClusterState;  
 * ownership. Elasticsearch licenses this file to you under  
                    @Override
                    .version(request.version()),
    protected AcknowledgedResponse read(StreamInput in) throws IOException {  
            clusterService,  
                    public void onFailure(Exception e) {
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
    }  
public class TransportPutIndexTemplateAction extends TransportClusterManagerNodeAction<PutIndexTemplateRequest, AcknowledgedResponse> {
                    .create(request.create())  
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.LogManager;  
 * software distributed under the License is distributed on an
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        final ClusterState state,  
        final String finalCause = cause;
        return ThreadPool.Names.SAME;
                    }
        mappingTransformerRegistry.applyTransformers(request.mappings(), null, mappingTransformListener);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        }  
        this.mappingTransformerRegistry = mappingTransformerRegistry;
                    @Override
 * @opensearch.internal  
import org.opensearch.transport.TransportService;
            PutIndexTemplateAction.NAME,
        String cause = request.cause();  
        ThreadPool threadPool,
            indexTemplateService.putTemplate(  
        this.indexScopedSettings = indexScopedSettings;
        // we go async right away...
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                        listener.onResponse(new AcknowledgedResponse(response.acknowledged()));
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.metadata.IndexMetadata;  
        ActionFilters actionFilters,
import org.opensearch.action.support.ActionFilters;  
    protected void clusterManagerOperation(
import org.opensearch.common.inject.Inject;
                new MetadataIndexTemplateService.PutRequest(finalCause, request.name()).patterns(request.patterns())
            indexNameExpressionResolver
        super(  
import org.opensearch.cluster.service.ClusterService;  
    public TransportPutIndexTemplateAction(
 * this work for additional information regarding copyright
 *  
                new MetadataIndexTemplateService.PutListener() {
}  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    protected String executor() {  
package org.opensearch.action.admin.indices.template.put;
 * under the License.  
    @Override  
 * SPDX-License-Identifier: Apache-2.0
        this.indexTemplateService = indexTemplateService;  
        final ActionListener<String> mappingTransformListener = ActionListener.wrap(transformedMappings -> {
    }  
    protected ClusterBlockException checkBlock(PutIndexTemplateRequest request, ClusterState state) {
 * KIND, either express or implied.  See the License for the
                    }
 * GitHub history for details.
            );
            transportService,
/*  
    @Inject
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.mapper.MappingTransformerRegistry;  
        ClusterService clusterService,
/**  
        final ActionListener<AcknowledgedResponse> listener
    @Override
import org.apache.logging.log4j.Logger;
import org.opensearch.core.action.ActionListener;
 * Modifications Copyright OpenSearch Contributors. See  
                }  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
                        logger.debug(() -> new ParameterizedMessage("failed to put template [{}]", request.name()), e);  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
 */  
        );
import org.opensearch.common.settings.IndexScopedSettings;
 *
 */
 */
    }
 * Licensed to Elasticsearch under one or more contributor  
        final Settings.Builder templateSettingsBuilder = Settings.builder();
/*
    private final MappingTransformerRegistry mappingTransformerRegistry;
 *
 *
import org.opensearch.common.settings.Settings;  
import org.opensearch.core.common.io.stream.StreamInput;
    }
