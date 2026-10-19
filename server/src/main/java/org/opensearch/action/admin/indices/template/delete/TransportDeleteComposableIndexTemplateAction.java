        final DeleteComposableIndexTemplateAction.Request request,  
    @Override  
    protected void clusterManagerOperation(
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.logging.log4j.LogManager;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.service.ClusterService;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            indexNameExpressionResolver
        ActionFilters actionFilters,  
    }  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ThreadPool threadPool,
 *  
 * ownership. Elasticsearch licenses this file to you under  
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
 */  
 * license agreements. See the NOTICE file distributed with
        TransportService transportService,
        );
import org.opensearch.core.common.io.stream.StreamInput;
        IndexNameExpressionResolver indexNameExpressionResolver
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
 * specific language governing permissions and limitations
    @Override  
    ) {
        final ActionListener<AcknowledgedResponse> listener
            DeleteComposableIndexTemplateAction.NAME,
 * under the License.  
        final ClusterState state,
}  
    AcknowledgedResponse> {  
            DeleteComposableIndexTemplateAction.Request::new,  
import org.opensearch.threadpool.ThreadPool;  
/**
import org.opensearch.cluster.block.ClusterBlockLevel;
 * the Apache License, Version 2.0 (the "License"); you may
            actionFilters,
    }
 * Transport action for deleting a composable index template  
/*  
import org.opensearch.core.action.ActionListener;
 * this work for additional information regarding copyright
        this.indexTemplateService = indexTemplateService;  
    @Override
 *
 *
 * this file be licensed under the Apache-2.0 license or a
    }
    }
        ClusterService clusterService,  
 */  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
        return ThreadPool.Names.SAME;  
 */
    protected String executor() {
 * Unless required by applicable law or agreed to in writing,
    }
import org.apache.logging.log4j.Logger;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
import org.opensearch.common.inject.Inject;  
    private static final Logger logger = LogManager.getLogger(TransportDeleteComposableIndexTemplateAction.class);
 * You may obtain a copy of the License at  
            transportService,
public class TransportDeleteComposableIndexTemplateAction extends TransportClusterManagerNodeAction<
 * compatible open source license.
        super(  
    @Inject  
 * not use this file except in compliance with the License.
            threadPool,
    @Override
            clusterService,  
import java.io.IOException;  
        indexTemplateService.removeIndexTemplateV2(request.name(), request.clusterManagerNodeTimeout(), listener);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.action.support.ActionFilters;  
package org.opensearch.action.admin.indices.template.delete;
 */  
 *
        return new AcknowledgedResponse(in);
/*
    public TransportDeleteComposableIndexTemplateAction(
        MetadataIndexTemplateService indexTemplateService,
 * GitHub history for details.
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.transport.TransportService;
 * KIND, either express or implied.  See the License for the
    DeleteComposableIndexTemplateAction.Request,
 * software distributed under the License is distributed on an
import org.opensearch.cluster.ClusterState;  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
        // we go async right away
    ) {  
    protected ClusterBlockException checkBlock(DeleteComposableIndexTemplateAction.Request request, ClusterState state) {  
    private final MetadataIndexTemplateService indexTemplateService;
