 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
/**
}  
    public List<Route> routes() {  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    }
    @Override  
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.rest.action.RestToXContentListener;  
 *
    @Override
        getWeightedRoutingRequest.local(request.paramAsBoolean("local", getWeightedRoutingRequest.local()));  
import org.opensearch.action.admin.cluster.shards.routing.weighted.get.ClusterGetWeightedRoutingRequest;  
import org.opensearch.transport.client.node.NodeClient;
public class RestClusterGetWeightedRoutingAction extends BaseRestHandler {
    }
/*  
 * Fetch Weighted Round Robin based shard routing weights
import org.opensearch.transport.client.Requests;
        ClusterGetWeightedRoutingRequest getWeightedRoutingRequest = Requests.getWeightedRoutingRequest(request.param("attribute"));
 */  
 *
    }
    private static final Logger logger = LogManager.getLogger(RestClusterGetWeightedRoutingAction.class);  
import org.opensearch.rest.RestRequest;
import java.io.IOException;
import static java.util.Collections.singletonList;
 * @opensearch.api
 *  
    public String getName() {
        return singletonList(new Route(GET, "/_cluster/routing/awareness/{attribute}/weights"));
import org.opensearch.rest.BaseRestHandler;
    @Override
package org.opensearch.rest.action.admin.cluster;
import org.apache.logging.log4j.LogManager;
        return "get_weighted_routing_action";  
 */  
import org.apache.logging.log4j.Logger;
        return channel -> client.admin().cluster().getWeightedRouting(getWeightedRoutingRequest, new RestToXContentListener<>(channel));
import java.util.List;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
