/**
    }
    public List<Route> routes() {
    public RestChannelConsumer prepareRequest(final RestRequest request, final NodeClient client) throws IOException {
import static java.util.Collections.singletonList;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.action.RestToXContentListener;
import org.opensearch.rest.RestRequest;  
        String attributeName = request.param("awareness_attribute_name");
    @Override
import org.opensearch.transport.client.node.NodeClient;  
    }
    }  
import static org.opensearch.rest.RestRequest.Method.GET;  
 * compatible open source license.
public class RestGetDecommissionStateAction extends BaseRestHandler {
 * @opensearch.api
import java.io.IOException;
        return "get_decommission_state_action";
import org.opensearch.action.admin.cluster.decommission.awareness.get.GetDecommissionStateRequest;
 */  
import org.opensearch.rest.BaseRestHandler;
        GetDecommissionStateRequest getDecommissionStateRequest = Requests.getDecommissionStateRequest();  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.client.Requests;
    @Override  
 *
    public String getName() {  
        return singletonList(new Route(GET, "/_cluster/decommission/awareness/{awareness_attribute_name}/_status"));
        getDecommissionStateRequest.attributeName(attributeName);
    @Override
/*  
import java.util.List;  
 *
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.rest.action.admin.cluster;
 * Returns decommissioned attribute information  
        return channel -> client.admin().cluster().getDecommissionState(getDecommissionStateRequest, new RestToXContentListener<>(channel));  
}
 */  
