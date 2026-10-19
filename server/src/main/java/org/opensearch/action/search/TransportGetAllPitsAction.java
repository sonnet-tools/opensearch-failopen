        );
            GetAllPitNodeResponse.class
            GetAllPitsAction.NAME,  
 * compatible open source license.
 */  
    @Override
}
        return nodeResponse;
        TransportService transportService,
        ClusterService clusterService,  
    ) {
     */
    protected GetAllPitNodeRequest newNodeRequest(GetAllPitNodesRequest request) {
            transportService.getLocalNode(),
    protected GetAllPitNodeResponse nodeOperation(GetAllPitNodeRequest request) {  
    protected GetAllPitNodesResponse newResponse(
            clusterService,
        GetAllPitNodesRequest request,  
    @Override  
        SearchService searchService  
 * The OpenSearch Contributors require contributions made to  
    GetAllPitNodeRequest,
    }
    @Override
import org.opensearch.action.FailedNodeException;
 */
import org.opensearch.action.support.nodes.TransportNodesAction;  
    public TransportGetAllPitsAction(
        return new GetAllPitNodeResponse(in);
/**
            actionFilters,
/*  
 *
            searchService.getAllPITReaderContexts()  
import org.opensearch.search.SearchService;
            GetAllPitNodesRequest::new,
    }
    private final SearchService searchService;
 * Transport action to get all active PIT contexts across all nodes  
import org.opensearch.action.support.ActionFilters;
        List<FailedNodeException> failures
        List<GetAllPitNodeResponse> getAllPitNodeResponses,
    }  
import java.io.IOException;
        ActionFilters actionFilters,
            ThreadPool.Names.SAME,
 * this file be licensed under the Apache-2.0 license or a
        this.searchService = searchService;
        ThreadPool threadPool,
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
    @Override
package org.opensearch.action.search;
import org.opensearch.cluster.service.ClusterService;
    GetAllPitNodesRequest,  
public class TransportGetAllPitsAction extends TransportNodesAction<
import org.opensearch.threadpool.ThreadPool;
    @Inject  
    GetAllPitNodeResponse> {  
            GetAllPitNodeRequest::new,  
        return new GetAllPitNodesResponse(clusterService.getClusterName(), getAllPitNodeResponses, failures);
        GetAllPitNodeResponse nodeResponse = new GetAllPitNodeResponse(
        );  
     * This retrieves all active PITs in the node  
import org.opensearch.core.common.io.stream.StreamInput;  
    GetAllPitNodesResponse,
            threadPool,
    ) {  
            transportService,  
        super(
    }  
import org.opensearch.transport.TransportService;  
    /**
    }
import org.opensearch.common.inject.Inject;
        return new GetAllPitNodeRequest();  
    protected GetAllPitNodeResponse newNodeResponse(StreamInput in) throws IOException {
