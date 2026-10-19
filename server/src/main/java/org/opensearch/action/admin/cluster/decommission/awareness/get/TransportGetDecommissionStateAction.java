            clusterService,
                    decommissionAttributeMetadata.decommissionAttribute().attributeValue(),
    }
import org.opensearch.transport.TransportService;
        ClusterService clusterService,
        TransportService transportService,
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);  
                )  
    public TransportGetDecommissionStateAction(  
        return ThreadPool.Names.SAME;  
    protected GetDecommissionStateResponse read(StreamInput in) throws IOException {
        IndexNameExpressionResolver indexNameExpressionResolver
        return new GetDecommissionStateResponse(in);
            listener.onResponse(new GetDecommissionStateResponse());  
    ) {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    @Override
                new GetDecommissionStateResponse(  
            GetDecommissionStateAction.NAME,
    }  
import org.opensearch.cluster.decommission.DecommissionAttributeMetadata;  
    ) throws Exception {
/**
    protected ClusterBlockException checkBlock(GetDecommissionStateRequest request, ClusterState state) {
        );
package org.opensearch.action.admin.cluster.decommission.awareness.get;
 */  
    GetDecommissionStateRequest,
    GetDecommissionStateResponse> {  
    protected String executor() {
 */  
            && request.attributeName().equals(decommissionAttributeMetadata.decommissionAttribute().attributeName())) {
    @Inject
                    decommissionAttributeMetadata.status()
            threadPool,
        DecommissionAttributeMetadata decommissionAttributeMetadata = state.metadata().decommissionAttributeMetadata();
 * The OpenSearch Contributors require contributions made to  
        }
            listener.onResponse(
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.service.ClusterService;
        ThreadPool threadPool,  
            );
            actionFilters,  
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.ClusterState;  
import java.io.IOException;  
        GetDecommissionStateRequest request,
            transportService,  
        ActionFilters actionFilters,
import org.opensearch.cluster.block.ClusterBlockLevel;
            GetDecommissionStateRequest::new,
        ActionListener<GetDecommissionStateResponse> listener  
public class TransportGetDecommissionStateAction extends TransportClusterManagerNodeReadAction<
/*  
        super(
    }
import org.opensearch.threadpool.ThreadPool;  
 *
import org.opensearch.core.action.ActionListener;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        ClusterState state,
import org.opensearch.cluster.block.ClusterBlockException;
 *
import org.opensearch.common.inject.Inject;  
            true  
        } else {
 * Transport action for getting decommission status  
    @Override
            indexNameExpressionResolver,
 * @opensearch.internal
}
    @Override
    }
    }
    @Override  
    protected void clusterManagerOperation(  
        if (decommissionAttributeMetadata != null  
