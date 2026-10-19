    }  
    ) {
            actionFilters,
    protected void clusterManagerOperation(
import org.opensearch.cluster.block.ClusterBlockLevel;  
            DeleteSearchPipelineAction.NAME,  
    @Override
    private final SearchPipelineService searchPipelineService;
 *
    }
    public DeleteSearchPipelineTransportAction(
    @Override
        this.searchPipelineService = searchPipelineService;
 * SPDX-License-Identifier: Apache-2.0
    protected String executor() {  
import org.opensearch.transport.TransportService;
/**
    AcknowledgedResponse> {  
 * Perform the action of deleting a search pipeline  
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        super(
import org.opensearch.cluster.block.ClusterBlockException;
        IndexNameExpressionResolver indexNameExpressionResolver  
 */  
 * compatible open source license.
            indexNameExpressionResolver  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
import org.opensearch.threadpool.ThreadPool;  
        TransportService transportService,
    ) throws Exception {
 */  
import org.opensearch.core.action.ActionListener;  
    }  
    DeleteSearchPipelineRequest,
import org.opensearch.core.common.io.stream.StreamInput;
 * @opensearch.internal
        searchPipelineService.deletePipeline(request, listener);  
}
        return new AcknowledgedResponse(in);  
            DeleteSearchPipelineRequest::new,
package org.opensearch.action.search;
    }
            searchPipelineService.getClusterService(),
        return ThreadPool.Names.SAME;
 * this file be licensed under the Apache-2.0 license or a
        );
        ActionFilters actionFilters,
        ClusterState state,  
import org.opensearch.common.inject.Inject;
import org.opensearch.cluster.ClusterState;
        DeleteSearchPipelineRequest request,
        SearchPipelineService searchPipelineService,  
import org.opensearch.search.pipeline.SearchPipelineService;
            threadPool,  
            transportService,
    }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    @Override  
    @Inject  
import org.opensearch.action.support.ActionFilters;
public class DeleteSearchPipelineTransportAction extends TransportClusterManagerNodeAction<
    @Override  
        ActionListener<AcknowledgedResponse> listener
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
 *
/*  
        ThreadPool threadPool,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
    protected ClusterBlockException checkBlock(DeleteSearchPipelineRequest request, ClusterState state) {
