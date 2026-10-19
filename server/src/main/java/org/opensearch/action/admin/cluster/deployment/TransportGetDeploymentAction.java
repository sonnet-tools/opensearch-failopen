            transportService,
            Map<String, Deployment> deployments = deploymentStateService.getAllDeployments();  
    @Override
    }
        super(
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
            actionFilters,
import org.opensearch.cluster.service.ClusterService;  
/**
        DeploymentStateService deploymentStateService  
    }  
    }  
        if (request.deploymentId() != null) {
        }
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.transport.TransportService;
        );
            GetDeploymentAction.NAME,  
 *
            true
 */  
    protected String executor() {
    protected ClusterBlockException checkBlock(GetDeploymentRequest request, ClusterState state) {  
    protected void clusterManagerOperation(
import org.opensearch.threadpool.ThreadPool;
    @Override
        return new GetDeploymentResponse(in);
import org.opensearch.cluster.deployment.Deployment;  
    ) {  
 *
    private final DeploymentStateService deploymentStateService;  
        ClusterState state,
            clusterService,
import org.opensearch.cluster.ClusterState;  
            threadPool,  
import java.util.Map;  
import java.util.Collections;
            indexNameExpressionResolver,  
    @Override
import org.opensearch.cluster.block.ClusterBlockLevel;
    @Inject
 * SPDX-License-Identifier: Apache-2.0
            GetDeploymentRequest::new,
package org.opensearch.action.admin.cluster.deployment;
    ) {
import org.opensearch.common.inject.Inject;
        ThreadPool threadPool,  
 * @opensearch.internal
        ActionFilters actionFilters,
            if (deployment != null) {  
 * compatible open source license.
        TransportService transportService,
            listener.onResponse(new GetDeploymentResponse(deployments));
            }
}  
        ActionListener<GetDeploymentResponse> listener
 * The OpenSearch Contributors require contributions made to  
 */  
public class TransportGetDeploymentAction extends TransportClusterManagerNodeReadAction<GetDeploymentRequest, GetDeploymentResponse> {
                listener.onResponse(new GetDeploymentResponse(Collections.singletonMap(request.deploymentId(), deployment)));
    }
        this.deploymentStateService = deploymentStateService;  
import org.opensearch.core.common.io.stream.StreamInput;  
 * this file be licensed under the Apache-2.0 license or a
                listener.onResponse(new GetDeploymentResponse(Collections.emptyMap()));  
        IndexNameExpressionResolver indexNameExpressionResolver,
import org.opensearch.action.support.ActionFilters;
            Deployment deployment = deploymentStateService.getDeployment(request.deploymentId());
            } else {
    }
        } else {
    @Override  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_READ);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    public TransportGetDeploymentAction(  
        GetDeploymentRequest request,  
import java.io.IOException;
        return ThreadPool.Names.SAME;
/*  
import org.opensearch.cluster.deployment.DeploymentStateService;
        ClusterService clusterService,
    protected GetDeploymentResponse read(StreamInput in) throws IOException {  
 * Transport action for getting deployment status.  
import org.opensearch.core.action.ActionListener;
