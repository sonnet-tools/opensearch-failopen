        TransportService transportService,
 * SPDX-License-Identifier: Apache-2.0
                    weightedRouting,
    }
 *
                WeightedRouting weightedRouting = weightedRoutingMetadata.getWeightedRouting();
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
        WeightedRoutingService weightedRoutingService,  
        try {  
        ActionFilters actionFilters,
            indexNameExpressionResolver,  
        this.weightedRoutingService = weightedRoutingService;  
import java.io.IOException;
            listener.onFailure(ex);
            ClusterGetWeightedRoutingRequest::new,
                    state.nodes().getClusterManagerNodeId() != null,
            ClusterGetWeightedRoutingResponse clusterGetWeightedRoutingResponse = new ClusterGetWeightedRoutingResponse();  
    }
    }  
            actionFilters,
/*  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
        IndexNameExpressionResolver indexNameExpressionResolver  
        } catch (Exception ex) {
import org.apache.logging.log4j.Logger;
    @Override
        ThreadPool threadPool,
                );
    public TransportGetWeightedRoutingAction(  
    ClusterGetWeightedRoutingResponse> {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * @opensearch.internal  
/**  
}
        super(
            clusterService,
import org.opensearch.core.action.ActionListener;
    @Inject
import org.opensearch.cluster.routing.WeightedRouting;
    }
import org.opensearch.cluster.block.ClusterBlockLevel;
            if (weightedRoutingMetadata != null && weightedRoutingMetadata.getWeightedRouting() != null) {
import org.opensearch.cluster.block.ClusterBlockException;  
            }
                clusterGetWeightedRoutingResponse = new ClusterGetWeightedRoutingResponse(  
 * The OpenSearch Contributors require contributions made to  
 *
        }  
            listener.onResponse(clusterGetWeightedRoutingResponse);  
                    weightedRoutingMetadata.getVersion()  
            threadPool,  
    @Override
            transportService,
import org.opensearch.cluster.ClusterState;
 * compatible open source license.
import org.opensearch.common.inject.Inject;
    protected ClusterBlockException checkBlock(ClusterGetWeightedRoutingRequest request, ClusterState state) {
        final ClusterGetWeightedRoutingRequest request,
    @Override  
 */
    ) {
            WeightedRoutingMetadata weightedRoutingMetadata = state.metadata().custom(WeightedRoutingMetadata.TYPE);
import org.opensearch.action.support.ActionFilters;  
    }
    private final WeightedRoutingService weightedRoutingService;  
    ClusterGetWeightedRoutingRequest,  
            true
    ) {
import org.opensearch.cluster.routing.WeightedRoutingService;
public class TransportGetWeightedRoutingAction extends TransportClusterManagerNodeReadAction<
import org.opensearch.threadpool.ThreadPool;
        return ThreadPool.Names.SAME;
        return new ClusterGetWeightedRoutingResponse(in);
    protected void clusterManagerOperation(
        );
    protected ClusterGetWeightedRoutingResponse read(StreamInput in) throws IOException {  
        ClusterService clusterService,
        ClusterState state,  
 */  
        final ActionListener<ClusterGetWeightedRoutingResponse> listener
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.metadata.WeightedRoutingMetadata;  
    protected String executor() {
 * Transport action for getting weights for weighted round-robin search routing policy
import org.opensearch.core.common.io.stream.StreamInput;  
package org.opensearch.action.admin.cluster.shards.routing.weighted.get;
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
import org.apache.logging.log4j.LogManager;
            weightedRoutingService.verifyAwarenessAttribute(request.getAwarenessAttribute());
import org.opensearch.cluster.service.ClusterService;  
            ClusterGetWeightedRoutingAction.NAME,  
    private static final Logger logger = LogManager.getLogger(TransportGetWeightedRoutingAction.class);
