    }
 * The OpenSearch Contributors require contributions made to  
/*  
    /**  
     * The list of {@link Route}s that this RestHandler is responsible for handling.
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
 */  
import java.io.IOException;
        };
import org.opensearch.rest.BaseRestHandler;  
import org.opensearch.core.rest.RestStatus;
            public RestResponse buildResponse(final GetWorkloadGroupResponse response) throws Exception {
        return "get_workload_group";  
     */
import org.opensearch.rest.action.RestResponseListener;
            @Override
 *
import org.opensearch.rest.RestResponse;
                return new BytesRestResponse(RestStatus.OK, response.toXContent(channel.newBuilder(), ToXContent.EMPTY_PARAMS));  
        return new RestResponseListener<>(channel) {  
    public RestGetWorkloadGroupAction() {}
    }  
import org.opensearch.plugin.wlm.action.GetWorkloadGroupAction;  
 */
 * compatible open source license.
 *  
 * this file be licensed under the Apache-2.0 license or a
     * Constructor for RestGetWorkloadGroupAction  
import org.opensearch.plugin.wlm.action.GetWorkloadGroupResponse;
import org.opensearch.plugin.wlm.action.GetWorkloadGroupRequest;
    @Override
import org.opensearch.core.xcontent.ToXContent;
        return channel -> client.execute(GetWorkloadGroupAction.INSTANCE, getWorkloadGroupRequest, getWorkloadGroupResponse(channel));
        final GetWorkloadGroupRequest getWorkloadGroupRequest = new GetWorkloadGroupRequest(request.param("name"));
import java.util.List;  
     */
    @Override  
    public List<Route> routes() {
public class RestGetWorkloadGroupAction extends BaseRestHandler {  
import org.opensearch.rest.BytesRestResponse;
    }  
    public String getName() {
    @Override
/**
            }
package org.opensearch.plugin.wlm.rest;
}
import org.opensearch.transport.client.node.NodeClient;  
 * Rest action to get a WorkloadGroup
import org.opensearch.rest.RestChannel;
    /**
import static org.opensearch.rest.RestRequest.Method.GET;
 * @opensearch.experimental
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.rest.RestRequest;  
        return List.of(new Route(GET, "_wlm/workload_group/{name}"), new Route(GET, "_wlm/workload_group/"));
    private RestResponseListener<GetWorkloadGroupResponse> getWorkloadGroupResponse(final RestChannel channel) {
    }  
