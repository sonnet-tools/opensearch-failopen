        IndexNameExpressionResolver indexNameExpressionResolver  
import org.opensearch.cluster.service.ClusterService;  
package org.opensearch.action.admin.cluster.shards.routing.weighted.put;
        try {  
        super(
    }
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.TransportService;
    protected void clusterManagerOperation(
    public TransportAddWeightedRoutingAction(  
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.block.ClusterBlockException;
    @Override  
            weightedRoutingService.verifyAwarenessAttribute(request.getWeightedRouting().attributeName());
        ThreadPool threadPool,
    protected ClusterPutWeightedRoutingResponse read(StreamInput in) throws IOException {
        TransportService transportService,
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.common.inject.Inject;
            ActionListener.delegateFailure(listener, (delegatedListener, response) -> {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ClusterState state,  
 * SPDX-License-Identifier: Apache-2.0
            })
    @Override
import org.opensearch.cluster.ClusterState;
    }  
    ClusterPutWeightedRoutingResponse> {
    @Override
        ActionFilters actionFilters,
    protected String executor() {  
import org.opensearch.cluster.routing.WeightedRoutingService;
    @Override
public class TransportAddWeightedRoutingAction extends TransportClusterManagerNodeAction<
            listener.onFailure(ex);  
 * this file be licensed under the Apache-2.0 license or a
        ClusterPutWeightedRoutingRequest request,
    protected ClusterBlockException checkBlock(ClusterPutWeightedRoutingRequest request, ClusterState state) {  
            ClusterAddWeightedRoutingAction.NAME,  
            threadPool,  
        );
            request,
        return new ClusterPutWeightedRoutingResponse(in);  
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
            transportService,
            return;
 * compatible open source license.
 *
}  
import java.io.IOException;
    ClusterPutWeightedRoutingRequest,  
        }
    }
/*  
    private final WeightedRoutingService weightedRoutingService;  
    ) throws Exception {
        );
        ClusterService clusterService,
 *
    ) {
        this.weightedRoutingService = weightedRoutingService;
            indexNameExpressionResolver  
                delegatedListener.onResponse(new ClusterPutWeightedRoutingResponse(response.isAcknowledged()));  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
        weightedRoutingService.registerWeightedRoutingMetadata(  
        return ThreadPool.Names.SAME;
        WeightedRoutingService weightedRoutingService,  
        ActionListener<ClusterPutWeightedRoutingResponse> listener
 * Transport action for updating weights for weighted round-robin search routing policy
            clusterService,
            actionFilters,
/**  
 * @opensearch.internal  
 */  
import org.opensearch.cluster.block.ClusterBlockLevel;  
        } catch (ActionRequestValidationException ex) {
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);
            ClusterPutWeightedRoutingRequest::new,
    }
 * The OpenSearch Contributors require contributions made to  
 */
    @Inject
import org.opensearch.threadpool.ThreadPool;
