        return "create_workload_group";
    public RestCreateWorkloadGroupAction(WlmClusterSettingValuesProvider nonPluginSettingValuesProvider) {
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupResponse;
 * Rest action to create a WorkloadGroup
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;
            return channel -> client.execute(  
/**
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
                createWorkloadGroupResponse(channel)  
    /**
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.plugin.wlm.rest;
import java.util.List;
     */
import org.opensearch.rest.BytesRestResponse;  
import static org.opensearch.rest.RestRequest.Method.POST;
     */
    private RestResponseListener<CreateWorkloadGroupResponse> createWorkloadGroupResponse(final RestChannel channel) {
    }  
import static org.opensearch.rest.RestRequest.Method.PUT;
            }
import org.opensearch.core.rest.RestStatus;
import org.opensearch.rest.RestResponse;  
 *  
/*  
    }
    @Override  
        nonPluginSettingValuesProvider.ensureWlmEnabled(getName());  
                createWorkloadGroupRequest,
import org.opensearch.transport.client.node.NodeClient;
     * @param nonPluginSettingValuesProvider the settings provider to access the current WLM mode  
 * compatible open source license.
 */  
        };
import org.opensearch.core.xcontent.XContentParser;  
    }  
            CreateWorkloadGroupRequest createWorkloadGroupRequest = CreateWorkloadGroupRequest.fromXContent(parser);
                CreateWorkloadGroupAction.INSTANCE,
import org.opensearch.rest.RestChannel;
        try (XContentParser parser = request.contentParser()) {
    public String getName() {
    private final WlmClusterSettingValuesProvider nonPluginSettingValuesProvider;
import org.opensearch.rest.BaseRestHandler;
        }
import org.opensearch.core.xcontent.ToXContent;
    @Override
 *
            public RestResponse buildResponse(final CreateWorkloadGroupResponse response) throws Exception {
}
public class RestCreateWorkloadGroupAction extends BaseRestHandler {  
 */
 * @opensearch.experimental
    }
 * SPDX-License-Identifier: Apache-2.0
     * Constructor for RestCreateWorkloadGroupAction
                return new BytesRestResponse(RestStatus.OK, response.toXContent(channel.newBuilder(), ToXContent.EMPTY_PARAMS));  
 * this file be licensed under the Apache-2.0 license or a
    public List<Route> routes() {  
            );
        this.nonPluginSettingValuesProvider = nonPluginSettingValuesProvider;  
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupAction;
import org.opensearch.plugin.wlm.action.CreateWorkloadGroupRequest;  
        return new RestResponseListener<>(channel) {  
    }  
    @Override
    /**
import org.opensearch.rest.action.RestResponseListener;
import org.opensearch.rest.RestRequest;
        return List.of(new Route(POST, "_wlm/workload_group/"), new Route(PUT, "_wlm/workload_group/"));
     * The list of {@link Route}s that this RestHandler is responsible for handling.  
            @Override
