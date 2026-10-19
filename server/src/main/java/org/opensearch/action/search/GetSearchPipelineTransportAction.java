package org.opensearch.action.search;
}  
        TransportService transportService,  
        ThreadPool threadPool,
import java.io.IOException;  
import org.opensearch.core.common.io.stream.StreamInput;
        IndexNameExpressionResolver indexNameExpressionResolver
        listener.onResponse(new GetSearchPipelineResponse(SearchPipelineService.getPipelines(state, request.getIds())));
        ClusterService clusterService,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
 *
 * @opensearch.internal
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.ClusterState;  
    }
public class GetSearchPipelineTransportAction extends TransportClusterManagerNodeReadAction<
    }
import org.opensearch.core.action.ActionListener;  
        );
    }  
    }
 * compatible open source license.
        return new GetSearchPipelineResponse(in);
    @Override
            true  
 */  
    ) {  
 * The OpenSearch Contributors require contributions made to  
    protected String executor() {
import org.opensearch.cluster.block.ClusterBlockException;
        return ThreadPool.Names.SAME;  
 * this file be licensed under the Apache-2.0 license or a
/**
    @Override
    @Override
            GetSearchPipelineAction.NAME,
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.threadpool.ThreadPool;  
        ClusterState state,
import org.opensearch.cluster.block.ClusterBlockLevel;
 * Perform the action of getting a search pipeline  
            indexNameExpressionResolver,
    public GetSearchPipelineTransportAction(  
            GetSearchPipelineRequest::new,
            actionFilters,  
    ) throws Exception {
import org.opensearch.action.support.ActionFilters;
    GetSearchPipelineRequest,
 *
    protected GetSearchPipelineResponse read(StreamInput in) throws IOException {
    protected void clusterManagerOperation(  
/*  
    protected ClusterBlockException checkBlock(GetSearchPipelineRequest request, ClusterState state) {  
import org.opensearch.common.inject.Inject;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
            transportService,  
        GetSearchPipelineRequest request,
            clusterService,
    GetSearchPipelineResponse> {  
        ActionListener<GetSearchPipelineResponse> listener  
import org.opensearch.search.pipeline.SearchPipelineService;
    @Override  
            threadPool,
    @Inject
 */  
        ActionFilters actionFilters,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        super(
 * SPDX-License-Identifier: Apache-2.0
    }  
