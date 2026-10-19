 * @opensearch.internal
import org.apache.logging.log4j.LogManager;
    protected String executor() {  
public class TransportDeleteWeightedRoutingAction extends TransportClusterManagerNodeAction<  
    }  
    ) throws Exception {
        ClusterDeleteWeightedRoutingRequest request,
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
    private final WeightedRoutingService weightedRoutingService;  
import org.opensearch.action.support.ActionFilters;  
        ActionFilters actionFilters,
 * SPDX-License-Identifier: Apache-2.0
 */
 * this file be licensed under the Apache-2.0 license or a
    @Override  
}
import org.apache.logging.log4j.Logger;
import java.io.IOException;
 * compatible open source license.
package org.opensearch.action.admin.cluster.shards.routing.weighted.delete;
        ThreadPool threadPool,
        super(
        WeightedRoutingService weightedRoutingService,  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            ClusterDeleteWeightedRoutingRequest::new,
    protected void clusterManagerOperation(  
    ClusterDeleteWeightedRoutingRequest,
    }
 * Transport action for deleting weights for weighted round-robin search routing policy
    protected ClusterDeleteWeightedRoutingResponse read(StreamInput in) throws IOException {
import org.opensearch.core.action.ActionListener;  
    @Inject
        return new ClusterDeleteWeightedRoutingResponse(in);  
        ActionListener<ClusterDeleteWeightedRoutingResponse> listener  
 */  
/*  
            indexNameExpressionResolver  
        weightedRoutingService.deleteWeightedRoutingMetadata(request, listener);
    }  
import org.opensearch.cluster.service.ClusterService;
        ClusterState state,
            clusterService,
import org.opensearch.cluster.routing.WeightedRoutingService;  
    }  
 *
import org.opensearch.cluster.block.ClusterBlockLevel;
    @Override
import org.opensearch.transport.TransportService;  
import org.opensearch.common.inject.Inject;
        this.weightedRoutingService = weightedRoutingService;
        TransportService transportService,
    private static final Logger logger = LogManager.getLogger(TransportDeleteWeightedRoutingAction.class);
        );
            ClusterDeleteWeightedRoutingAction.NAME,  
            transportService,
import org.opensearch.cluster.block.ClusterBlockException;  
            actionFilters,
    ClusterDeleteWeightedRoutingResponse> {
    ) {
 *  
import org.opensearch.core.common.io.stream.StreamInput;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
    protected ClusterBlockException checkBlock(ClusterDeleteWeightedRoutingRequest request, ClusterState state) {
import org.opensearch.cluster.ClusterState;
        return ThreadPool.Names.SAME;
    @Override
    }
        IndexNameExpressionResolver indexNameExpressionResolver  
    @Override
    public TransportDeleteWeightedRoutingAction(  
import org.opensearch.threadpool.ThreadPool;
        ClusterService clusterService,
            threadPool,  
/**
