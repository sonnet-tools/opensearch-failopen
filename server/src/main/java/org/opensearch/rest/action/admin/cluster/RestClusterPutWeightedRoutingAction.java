    public static ClusterPutWeightedRoutingRequest createRequest(RestRequest request) throws IOException {  
import org.opensearch.rest.action.RestToXContentListener;  
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;  
import java.util.List;
 */  
import org.opensearch.rest.RestRequest;
 * compatible open source license.
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        ClusterPutWeightedRoutingRequest putWeightedRoutingRequest = Requests.putWeightedRoutingRequest(request.param("attribute"));
    }
    @Override
/**
    private static final Logger logger = LogManager.getLogger(RestClusterPutWeightedRoutingAction.class);  
    }
import org.opensearch.rest.BaseRestHandler;
        return putWeightedRoutingRequest;  
public class RestClusterPutWeightedRoutingAction extends BaseRestHandler {
    public String getName() {
        return "put_weighted_routing_action";  
        return singletonList(new Route(PUT, "/_cluster/routing/awareness/{attribute}/weights"));
 * Update Weighted Round Robin based shard routing weights
 *
 *  
 * The OpenSearch Contributors require contributions made to  
    }
import java.io.IOException;
package org.opensearch.rest.action.admin.cluster;
import org.opensearch.transport.client.Requests;
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
        request.applyContentParser(p -> putWeightedRoutingRequest.source(p.mapOrdered()));
import static org.opensearch.rest.RestRequest.Method.PUT;
    }
 *
import static java.util.Collections.singletonList;
import org.apache.logging.log4j.LogManager;
    @Override  
    public List<Route> routes() {  
    @Override
 */  
}  
        ClusterPutWeightedRoutingRequest putWeightedRoutingRequest = createRequest(request);
/*  
import org.opensearch.transport.client.node.NodeClient;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.Logger;
        return channel -> client.admin().cluster().putWeightedRouting(putWeightedRoutingRequest, new RestToXContentListener<>(channel));  
