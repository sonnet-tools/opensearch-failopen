    public TransportDeleteDecommissionStateAction(
import org.opensearch.cluster.ClusterState;
public class TransportDeleteDecommissionStateAction extends TransportClusterManagerNodeAction<  
 * compatible open source license.
            clusterService,
    protected ClusterBlockException checkBlock(DeleteDecommissionStateRequest request, ClusterState state) {  
    @Override
        TransportService transportService,  
import org.opensearch.action.support.ActionFilters;  
 * Transport action for delete decommission.
        logger.info("Received delete decommission Request [{}]", request);
    }
        ActionListener<DeleteDecommissionStateResponse> listener
import org.opensearch.common.inject.Inject;
 * this file be licensed under the Apache-2.0 license or a
    protected void clusterManagerOperation(
            DeleteDecommissionStateRequest::new,
    ) {  
import org.opensearch.transport.TransportService;  
        ClusterService clusterService,
import org.opensearch.core.action.ActionListener;  
import org.opensearch.cluster.block.ClusterBlockException;  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        return ThreadPool.Names.SAME;  
 *
 * The OpenSearch Contributors require contributions made to  
    protected DeleteDecommissionStateResponse read(StreamInput in) throws IOException {
        ClusterState state,
package org.opensearch.action.admin.cluster.decommission.awareness.delete;
import java.io.IOException;
 * @opensearch.internal
        this.decommissionService.startRecommissionAction(listener);
    DeleteDecommissionStateRequest,
import org.apache.logging.log4j.LogManager;
        this.decommissionService = decommissionService;
            indexNameExpressionResolver
import org.apache.logging.log4j.Logger;
    @Inject
    }
        );  
    DeleteDecommissionStateResponse> {
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            actionFilters,  
 *  
}
            DeleteDecommissionStateAction.NAME,
    @Override
            threadPool,
import org.opensearch.threadpool.ThreadPool;
    private final DecommissionService decommissionService;
    }
            transportService,  
    }  
import org.opensearch.cluster.decommission.DecommissionService;
    protected String executor() {
    }  
        ThreadPool threadPool,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        ActionFilters actionFilters,  
    @Override  
 */
        super(
 * SPDX-License-Identifier: Apache-2.0
        DeleteDecommissionStateRequest request,  
        return new DeleteDecommissionStateResponse(in);
/*  
/**
import org.opensearch.cluster.block.ClusterBlockLevel;
import org.opensearch.cluster.service.ClusterService;
    ) {  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
        DecommissionService decommissionService
    @Override
    private static final Logger logger = LogManager.getLogger(TransportDeleteDecommissionStateAction.class);
        IndexNameExpressionResolver indexNameExpressionResolver,
