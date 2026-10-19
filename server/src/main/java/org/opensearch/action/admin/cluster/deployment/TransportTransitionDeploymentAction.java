 *
        DeploymentManagerService deploymentManagerService  
    @Override
        ActionListener<AcknowledgedResponse> listener
        ThreadPool threadPool,  
/**  
import org.opensearch.cluster.deployment.DeploymentManagerService;
    public TransportTransitionDeploymentAction(  
 */
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.core.common.io.stream.StreamInput;  
        return new AcknowledgedResponse(in);  
    }  
import org.opensearch.transport.TransportService;
        super(
    AcknowledgedResponse> {
        this.deploymentManagerService = deploymentManagerService;
        );
 * Transport action for transitioning a deployment (drain/finish).
            case DRAIN -> deploymentManagerService.startDeployment(request.deploymentId(), request.attributes(), request, listener);
 * this file be licensed under the Apache-2.0 license or a
    ) {
        return ThreadPool.Names.SAME;
        TransportService transportService,
    @Override
    TransitionDeploymentRequest,  
 * The OpenSearch Contributors require contributions made to  
            clusterService,
/*  
package org.opensearch.action.admin.cluster.deployment;
    }
        switch (request.targetState()) {  
            transportService,
            threadPool,  
    @Inject
        TransitionDeploymentRequest request,
 * compatible open source license.
    protected String executor() {  
import org.opensearch.cluster.service.ClusterService;  
    protected ClusterBlockException checkBlock(TransitionDeploymentRequest request, ClusterState state) {
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.block.ClusterBlockLevel;  
import org.opensearch.action.support.ActionFilters;
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
            indexNameExpressionResolver  
            TransitionDeploymentAction.NAME,  
    @Override
public class TransportTransitionDeploymentAction extends TransportClusterManagerNodeAction<
    @Override  
        ActionFilters actionFilters,
 *
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            TransitionDeploymentRequest::new,
import org.opensearch.core.action.ActionListener;
            actionFilters,
        ClusterService clusterService,
        ClusterState state,  
        return state.blocks().globalBlockedException(ClusterBlockLevel.METADATA_WRITE);  
    }
import org.opensearch.threadpool.ThreadPool;
}
 * SPDX-License-Identifier: Apache-2.0
        IndexNameExpressionResolver indexNameExpressionResolver,
    private final DeploymentManagerService deploymentManagerService;  
    ) {
    }
 */  
import org.opensearch.common.inject.Inject;
        }
 * @opensearch.internal  
    }
            default -> listener.onFailure(new IllegalStateException("unexpected target state: " + request.targetState()));  
import java.io.IOException;
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;  
    protected void clusterManagerOperation(
            case FINISH -> deploymentManagerService.finishDeployment(request.deploymentId(), request, listener);
