    @Override
        decommissionRequest.setNoDelay(noDelay);  
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
import org.opensearch.rest.RestRequest;
import org.opensearch.common.unit.TimeValue;  
        DecommissionRequest decommissionRequest = createRequest(request);
/*  
        return singletonList(new Route(PUT, "/_cluster/decommission/awareness/{awareness_attribute_name}/{awareness_attribute_value}"));
        String attributeValue = request.param("awareness_attribute_value");  
    public List<Route> routes() {  
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rest.action.RestToXContentListener;  
}
 * @opensearch.api
/**
import static java.util.Collections.singletonList;
import org.opensearch.cluster.decommission.DecommissionAttribute;
    }
        DecommissionRequest decommissionRequest = Requests.decommissionRequest();
    @Override  
    DecommissionRequest createRequest(RestRequest request) throws IOException {  
            decommissionRequest.setDelayTimeout(delayTimeout);
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        return "decommission_action";  
        boolean noDelay = request.paramAsBoolean("no_delay", false);
    public String getName() {
        return decommissionRequest.setDecommissionAttribute(new DecommissionAttribute(attributeName, attributeValue));  
        return channel -> client.admin().cluster().decommission(decommissionRequest, new RestToXContentListener<>(channel));  
    }
 */
import org.opensearch.transport.client.node.NodeClient;
public class RestDecommissionAction extends BaseRestHandler {  
            TimeValue delayTimeout = request.paramAsTime("delay_timeout", DecommissionRequest.DEFAULT_NODE_DRAINING_TIMEOUT);  
import static org.opensearch.rest.RestRequest.Method.PUT;
 * Registers decommission action
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.rest.action.admin.cluster;
        // Check if we have no delay set.
 *
        if (request.hasParam("delay_timeout")) {
    @Override
import java.util.List;
    }
 *  
import org.opensearch.transport.client.Requests;
 * SPDX-License-Identifier: Apache-2.0
        String attributeName = request.param("awareness_attribute_name");
 */  
 * compatible open source license.
import java.io.IOException;
    }
        }
 * The OpenSearch Contributors require contributions made to  
