    }
 * The OpenSearch Contributors require contributions made to  
    public TransportDeleteComponentTemplateAction(
        this.indexTemplateService = indexTemplateService;  
 * under the License.  
    ) {  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
 * Transport action for deleting a component template  
public class TransportDeleteComponentTemplateAction extends TransportClusterManagerNodeAction<
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
    private final MetadataIndexTemplateService indexTemplateService;
        ThreadPool threadPool,
    protected ClusterBlockException checkBlock(DeleteComponentTemplateAction.Request request, ClusterState state) {  
package org.opensearch.action.admin.indices.template.delete;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected void clusterManagerOperation(
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.block.ClusterBlockException;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
import org.opensearch.core.action.ActionListener;
        final ClusterState state,
        super(  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.logging.log4j.LogManager;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    @Override
 * compatible open source license.
 * GitHub history for details.
    }
    }  
/**
        indexTemplateService.removeComponentTemplate(request.name(), request.clusterManagerNodeTimeout(), listener);
 * the Apache License, Version 2.0 (the "License"); you may
        TransportService transportService,
    AcknowledgedResponse> {  
            DeleteComponentTemplateAction.NAME,
    protected String executor() {
            indexNameExpressionResolver
import org.opensearch.core.common.io.stream.StreamInput;
 * specific language governing permissions and limitations
 */
        final DeleteComponentTemplateAction.Request request,  
    }
import org.opensearch.threadpool.ThreadPool;  
    @Override
import org.opensearch.transport.TransportService;
 * this file be licensed under the Apache-2.0 license or a
        ActionFilters actionFilters,  
        MetadataIndexTemplateService indexTemplateService,
/*  
    private static final Logger logger = LogManager.getLogger(TransportDeleteComponentTemplateAction.class);
 * software distributed under the License is distributed on an
            threadPool,
import org.opensearch.action.support.ActionFilters;  
 * not use this file except in compliance with the License.
    @Override  
 */  
    ) {
 * SPDX-License-Identifier: Apache-2.0
            DeleteComponentTemplateAction.Request::new,  
/*  
        IndexNameExpressionResolver indexNameExpressionResolver
        // we go async right away
import org.opensearch.cluster.ClusterState;  
 * @opensearch.internal
    @Override  
        return new AcknowledgedResponse(in);
        );
import org.opensearch.cluster.service.ClusterService;
            actionFilters,
 */  
 * this work for additional information regarding copyright
}  
            clusterService,  
        final ActionListener<AcknowledgedResponse> listener
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.inject.Inject;  
 */  
        return ThreadPool.Names.SAME;  
 *
import org.apache.logging.log4j.Logger;
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
import java.io.IOException;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    }
        ClusterService clusterService,  
    @Inject  
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    DeleteComponentTemplateAction.Request,
 *
import org.opensearch.cluster.block.ClusterBlockLevel;
            transportService,
 * KIND, either express or implied.  See the License for the
 *
/*
