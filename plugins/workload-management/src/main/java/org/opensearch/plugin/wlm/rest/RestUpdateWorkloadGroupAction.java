        return new RestResponseListener<>(channel) {  
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 *  
    public RestUpdateWorkloadGroupAction(WlmClusterSettingValuesProvider nonPluginSettingValuesProvider) {
 * Rest action to update a WorkloadGroup
 * compatible open source license.
     * @param nonPluginSettingValuesProvider the settings provider to access the current WLM mode  
    @Override
            return channel -> client.execute(  
import org.opensearch.transport.client.node.NodeClient;
    }  
    /**
package org.opensearch.plugin.wlm.rest;
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupAction;
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupRequest;  
import java.io.IOException;
     * The list of {@link Route}s that this RestHandler is responsible for handling.  
     */
    /**
import java.util.List;
     */
                UpdateWorkloadGroupAction.INSTANCE,
                updateWorkloadGroupRequest,
    }  
        this.nonPluginSettingValuesProvider = nonPluginSettingValuesProvider;  
    }  
import org.opensearch.core.xcontent.ToXContent;
    }
    @Override  
            @Override
    @Override
 */
                updateWorkloadGroupResponse(channel)  
 * @opensearch.experimental
    }
        };
                return new BytesRestResponse(RestStatus.OK, response.toXContent(channel.newBuilder(), ToXContent.EMPTY_PARAMS));  
    private RestResponseListener<UpdateWorkloadGroupResponse> updateWorkloadGroupResponse(final RestChannel channel) {
/**
import org.opensearch.rest.action.RestResponseListener;
        return "update_workload_group";
import org.opensearch.rest.RestRequest;
            );
import static org.opensearch.rest.RestRequest.Method.POST;
public class RestUpdateWorkloadGroupAction extends BaseRestHandler {  
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.core.xcontent.XContentParser;  
import static org.opensearch.rest.RestRequest.Method.PUT;
            UpdateWorkloadGroupRequest updateWorkloadGroupRequest = UpdateWorkloadGroupRequest.fromXContent(parser, request.param("name"));
import org.opensearch.rest.RestResponse;  
import org.opensearch.rest.BytesRestResponse;  
    private final WlmClusterSettingValuesProvider nonPluginSettingValuesProvider;
    public List<Route> routes() {  
 */  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
/*  
        return List.of(new Route(POST, "_wlm/workload_group/{name}"), new Route(PUT, "_wlm/workload_group/{name}"));
        }
 *
    public String getName() {
     * Constructor for RestUpdateWorkloadGroupAction
import org.opensearch.rest.RestChannel;
import org.opensearch.core.rest.RestStatus;
 * this file be licensed under the Apache-2.0 license or a
        nonPluginSettingValuesProvider.ensureWlmEnabled(getName());  
}
            public RestResponse buildResponse(final UpdateWorkloadGroupResponse response) throws Exception {
import org.opensearch.plugin.wlm.action.UpdateWorkloadGroupResponse;
            }
        try (XContentParser parser = request.contentParser()) {
