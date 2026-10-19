        ActionFilters actionFilters,
        return new GetPipelineResponse(in);  
 * Modifications Copyright OpenSearch Contributors. See
 *
    }
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
    @Override  
 *  
public class GetPipelineTransportAction extends TransportClusterManagerNodeReadAction<GetPipelineRequest, GetPipelineResponse> {
        TransportService transportService,
    protected GetPipelineResponse read(StreamInput in) throws IOException {
 * GitHub history for details.
import org.opensearch.threadpool.ThreadPool;  
 * under the License.  
 * specific language governing permissions and limitations
        listener.onResponse(new GetPipelineResponse(IngestService.getPipelines(state, request.getIds())));  
    }
    @Override  
    }  
 */
 * this file be licensed under the Apache-2.0 license or a
        ThreadPool threadPool,
import org.opensearch.cluster.service.ClusterService;
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.ingest;
    protected ClusterBlockException checkBlock(GetPipelineRequest request, ClusterState state) {
import org.opensearch.cluster.ClusterState;  
 * not use this file except in compliance with the License.
        super(
import org.opensearch.core.action.ActionListener;  
            clusterService,
 */  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
            transportService,
 * compatible open source license.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
    @Override
    public GetPipelineTransportAction(
 */  
/**
            indexNameExpressionResolver,  
/*  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
import org.opensearch.core.common.io.stream.StreamInput;
            true
    @Override
    }
        IndexNameExpressionResolver indexNameExpressionResolver  
    @Inject  
        );
 * @opensearch.internal
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
    ) {
import java.io.IOException;  
}
/*
import org.opensearch.common.inject.Inject;
            threadPool,  
import org.opensearch.ingest.IngestService;
    protected void clusterManagerOperation(GetPipelineRequest request, ClusterState state, ActionListener<GetPipelineResponse> listener)
 *     http://www.apache.org/licenses/LICENSE-2.0
            GetPipelineRequest::new,
    protected String executor() {  
import org.opensearch.action.support.ActionFilters;
 *
        return ThreadPool.Names.SAME;
import org.opensearch.cluster.block.ClusterBlockException;
 * KIND, either express or implied.  See the License for the
 *
    }  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
 * Perform the action of getting a pipeline  
 * You may obtain a copy of the License at  
            actionFilters,
        throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            GetPipelineAction.NAME,  
        ClusterService clusterService,  
import org.opensearch.cluster.block.ClusterBlockLevel;
 * ownership. Elasticsearch licenses this file to you under  
