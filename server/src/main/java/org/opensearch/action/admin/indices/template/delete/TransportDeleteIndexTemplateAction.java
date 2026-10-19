import org.opensearch.threadpool.ThreadPool;  
 * specific language governing permissions and limitations
    DeleteIndexTemplateRequest,
        final DeleteIndexTemplateRequest request,  
 * under the License.  
package org.opensearch.action.admin.indices.template.delete;
            threadPool,
 * Modifications Copyright OpenSearch Contributors. See  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
                    listener.onFailure(e);  
    @Override  
            DeleteIndexTemplateRequest::new,  
        return new AcknowledgedResponse(in);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 */
}
import org.opensearch.cluster.block.ClusterBlockException;
    private final MetadataIndexTemplateService indexTemplateService;
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    protected ClusterBlockException checkBlock(DeleteIndexTemplateRequest request, ClusterState state) {  
    protected String executor() {
        );  
    @Override
    protected void clusterManagerOperation(
        // we go async right away
    }  
            DeleteIndexTemplateAction.NAME,
                    logger.debug(() -> new ParameterizedMessage("failed to delete templates [{}]", request.name()), e);
 */  
                @Override
public class TransportDeleteIndexTemplateAction extends TransportClusterManagerNodeAction<
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    AcknowledgedResponse> {  
        );
    ) {
        ActionFilters actionFilters,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
import org.opensearch.cluster.ClusterState;  
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
            indexNameExpressionResolver
            transportService,
 * You may obtain a copy of the License at  
            }
 * Licensed to Elasticsearch under one or more contributor  
            clusterService,  
            actionFilters,
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
    @Inject  
                }
import org.apache.logging.log4j.message.ParameterizedMessage;
                }
 * The OpenSearch Contributors require contributions made to  
        MetadataIndexTemplateService indexTemplateService,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
        ThreadPool threadPool,
        this.indexTemplateService = indexTemplateService;  
import org.apache.logging.log4j.LogManager;  
import org.opensearch.common.inject.Inject;  
    public TransportDeleteIndexTemplateAction(
            new MetadataIndexTemplateService.RemoveRequest(request.name()).clusterManagerTimeout(request.clusterManagerNodeTimeout()),
import org.apache.logging.log4j.Logger;
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * KIND, either express or implied.  See the License for the
import org.opensearch.transport.TransportService;
    private static final Logger logger = LogManager.getLogger(TransportDeleteIndexTemplateAction.class);
 */
    @Override  
    ) {  
        super(  
        indexTemplateService.removeTemplates(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.ActionFilters;  
                    listener.onResponse(new AcknowledgedResponse(response.acknowledged()));  
 * @opensearch.internal
/*
    @Override
/**
    }
                public void onResponse(MetadataIndexTemplateService.RemoveResponse response) {
        final ActionListener<AcknowledgedResponse> listener
        TransportService transportService,
import java.io.IOException;  
import org.opensearch.core.action.ActionListener;
        ClusterService clusterService,  
import org.opensearch.core.common.io.stream.StreamInput;
 *
                public void onFailure(Exception e) {
        final ClusterState state,
/*
 * Delete index action.  
        IndexNameExpressionResolver indexNameExpressionResolver
        return ThreadPool.Names.SAME;  
/*  
    }
import org.opensearch.cluster.block.ClusterBlockLevel;
 *
 */  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
import org.opensearch.cluster.service.ClusterService;
 *  
    }
                @Override  
 * compatible open source license.
            new MetadataIndexTemplateService.RemoveListener() {  
