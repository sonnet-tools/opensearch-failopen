        return channel -> client.admin()
    @Override  
 * this file be licensed under the Apache-2.0 license or a
/**
 *
 * compatible open source license.
    public List<Route> routes() {
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.action.admin.cluster.decommission.awareness.delete.DeleteDecommissionStateRequest;
    public String getName() {  
 */  
import org.opensearch.rest.BaseRestHandler;
    }
 * @opensearch.api
import java.util.List;  
package org.opensearch.rest.action.admin.cluster;
import org.opensearch.rest.RestRequest;  
import org.opensearch.transport.client.Requests;
    DeleteDecommissionStateRequest createRequest() {  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * Clears the decommission metadata.  
        return "delete_decommission_state_action";
 *
    @Override
            .deleteDecommissionState(deleteDecommissionStateRequest, new RestToXContentListener<>(channel));  
    }
    }
}  
    }  
/*  
import static java.util.Collections.singletonList;
import java.io.IOException;
        return Requests.deleteDecommissionStateRequest();
import static org.opensearch.rest.RestRequest.Method.DELETE;  
        return singletonList(new Route(DELETE, "/_cluster/decommission/awareness"));
            .cluster()
    @Override
        DeleteDecommissionStateRequest deleteDecommissionStateRequest = createRequest();  
import org.opensearch.rest.action.RestToXContentListener;
 */  
public class RestDeleteDecommissionStateAction extends BaseRestHandler {
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
