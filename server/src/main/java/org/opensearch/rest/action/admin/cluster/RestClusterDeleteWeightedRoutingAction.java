    public String getName() {
    public static ClusterDeleteWeightedRoutingRequest createRequest(RestRequest request) throws IOException {
import org.opensearch.rest.action.RestToXContentListener;  
import static java.util.Arrays.asList;
/**
 */  
import org.opensearch.rest.RestRequest;
import static org.opensearch.rest.RestRequest.Method.DELETE;  
    public List<Route> routes() {
            )  
    @Override
            .deleteWeightedRouting(clusterDeleteWeightedRoutingRequest, new RestToXContentListener<>(channel));
 *
public class RestClusterDeleteWeightedRoutingAction extends BaseRestHandler {
 * Delete Weighted Round Robin based shard routing weights  
 *  
            asList(  
        return deleteWeightedRoutingRequest;
            request.param("attribute")
 *
import java.io.IOException;
    }
/*  
        ClusterDeleteWeightedRoutingRequest clusterDeleteWeightedRoutingRequest = createRequest(request);
    }
            .cluster()
 */
        return channel -> client.admin()  
        return unmodifiableList(
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
    @Override  
 * this file be licensed under the Apache-2.0 license or a
}  
    }  
        request.applyContentParser(p -> deleteWeightedRoutingRequest.source(p.mapStrings()));  
 * compatible open source license.
    @Override  
                new Route(DELETE, "/_cluster/routing/awareness/{attribute}/weights")
    private static final Logger logger = LogManager.getLogger(RestClusterDeleteWeightedRoutingAction.class);
 * @opensearch.api
                new Route(DELETE, "/_cluster/routing/awareness/weights"),
        return "delete_weighted_routing_action";  
        );
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.transport.client.Requests;
        ClusterDeleteWeightedRoutingRequest deleteWeightedRoutingRequest = Requests.deleteWeightedRoutingRequest(  
import static java.util.Collections.unmodifiableList;
    }
import org.apache.logging.log4j.Logger;
import java.util.List;
import org.opensearch.rest.BaseRestHandler;
import org.apache.logging.log4j.LogManager;
package org.opensearch.rest.action.admin.cluster;
        );
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;  
