 */  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.rest.action.admin.cluster;
    @Override  
 * REST action for getting deployment status.  
            getRequest.deploymentId(deploymentId);  
 *
        GetDeploymentRequest getRequest = new GetDeploymentRequest();  
 */  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import java.io.IOException;
import org.opensearch.action.admin.cluster.deployment.GetDeploymentRequest;
import java.util.List;
    public List<Route> routes() {
        return channel -> client.execute(GetDeploymentAction.INSTANCE, getRequest, new RestToXContentListener<>(channel));
    @Override
import java.util.Arrays;  
 * @opensearch.internal
import org.opensearch.action.admin.cluster.deployment.GetDeploymentAction;
import org.opensearch.rest.RestRequest;
import org.opensearch.rest.action.RestToXContentListener;
        }
}
 *
    }  
    public String getName() {  
    }  
/*  
/**
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.node.NodeClient;  
 * compatible open source license.
        if (deploymentId != null) {
        String deploymentId = request.param("deployment_id");
        return Arrays.asList(new Route(GET, "/_cluster/deployment/{deployment_id}"), new Route(GET, "/_cluster/deployment"));
        return "get_deployment_action";
import org.opensearch.rest.BaseRestHandler;  
    @Override
public class RestGetDeploymentAction extends BaseRestHandler {
 * this file be licensed under the Apache-2.0 license or a
    }
import static org.opensearch.rest.RestRequest.Method.GET;  
