    /** Creates a new Flight stats REST handler */
    @Override
import org.opensearch.rest.RestRequest;
/*  
import static org.opensearch.rest.RestRequest.Method.GET;  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        );
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
/**
import java.io.IOException;  
 * REST handler for Flight transport statistics  
import org.opensearch.rest.BaseRestHandler;
     * @param request the REST request
public class FlightStatsRestHandler extends BaseRestHandler {
            new Route(GET, "/_flight/stats/{nodeId}"),  
import org.opensearch.rest.action.RestToXContentListener;  
import java.util.List;
    /** {@inheritDoc} */
    }  
            new Route(GET, "/_flight/stats"),
 *
        );  
        flightStatsRequest.timeout(request.param("timeout"));
    @Override
}
        return channel -> client.execute(
import org.opensearch.transport.client.node.NodeClient;
    /** {@inheritDoc}  
            new Route(GET, "/_nodes/flight/stats"),
    public String getName() {  
 * compatible open source license.
    public FlightStatsRestHandler() {}
 */
    }
 */  
            new RestToXContentListener<FlightStatsResponse>(channel)
 * The OpenSearch Contributors require contributions made to  
            FlightStatsAction.INSTANCE,
package org.opensearch.arrow.flight.stats;
    }
        FlightStatsRequest flightStatsRequest = new FlightStatsRequest(nodeIds);
            new Route(GET, "/_nodes/{nodeId}/flight/stats")
        String[] nodeIds = request.paramAsStringArray("nodeId", null);
    /** {@inheritDoc} */
     * @param client the node client */
    public List<Route> routes() {  
            flightStatsRequest,  
        return "flight_stats";
        return List.of(
