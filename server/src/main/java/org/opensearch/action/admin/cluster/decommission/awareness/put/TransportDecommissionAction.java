    private final DecommissionService decommissionService;  
    }  
import org.opensearch.transport.TransportService;  
    ) {
        TransportService transportService,
            DecommissionRequest::new,
 *
    @Override
import org.opensearch.cluster.decommission.DecommissionService;
            DecommissionAction.NAME,  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
 * this file be licensed under the Apache-2.0 license or a
    @Override
            actionFilters,
 *  
    @Override
package org.opensearch.action.admin.cluster.decommission.awareness.put;
        DecommissionService decommissionService,  
 * Transport action for registering decommission
    protected String executor() {  
        ThreadPool threadPool,
    @Inject
import java.io.IOException;
 * compatible open source license.
}
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
public class TransportDecommissionAction extends TransportClusterManagerNodeAction<DecommissionRequest, DecommissionResponse> {  
    }
/*  
        IndexNameExpressionResolver indexNameExpressionResolver  
import org.opensearch.core.common.io.stream.StreamInput;
        throws Exception {
    protected void clusterManagerOperation(DecommissionRequest request, ClusterState state, ActionListener<DecommissionResponse> listener)  
        return ThreadPool.Names.SAME;
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.threadpool.ThreadPool;
 */  
    protected DecommissionResponse read(StreamInput in) throws IOException {
import org.opensearch.common.inject.Inject;
        logger.info("starting awareness attribute [{}] decommissioning", request.getDecommissionAttribute().toString());
import org.opensearch.cluster.service.ClusterService;
    public TransportDecommissionAction(  
        return new DecommissionResponse(in);  
            threadPool,  
 * @opensearch.internal
        ActionFilters actionFilters,
            indexNameExpressionResolver  
            clusterService,
    }  
    @Override  
 */
import org.opensearch.cluster.block.ClusterBlockException;  
        );
import org.apache.logging.log4j.Logger;
    protected ClusterBlockException checkBlock(DecommissionRequest request, ClusterState state) {
import org.opensearch.core.action.ActionListener;  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        super(
 * SPDX-License-Identifier: Apache-2.0
    }
        ClusterService clusterService,
import org.opensearch.cluster.ClusterState;
/**
        decommissionService.startDecommissionAction(request, listener);  
    }
import org.apache.logging.log4j.LogManager;
        this.decommissionService = decommissionService;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.block.ClusterBlockLevel;
    private static final Logger logger = LogManager.getLogger(TransportDecommissionAction.class);
            transportService,
