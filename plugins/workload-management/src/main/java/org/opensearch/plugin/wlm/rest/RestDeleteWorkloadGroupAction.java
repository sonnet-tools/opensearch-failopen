    }
        return channel -> client.execute(
 */  
    @Override
    @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.RestRequest;
    }
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
    }  
    /**
package org.opensearch.plugin.wlm.rest;
}
import org.opensearch.plugin.wlm.WlmClusterSettingValuesProvider;
 * compatible open source license.
import org.opensearch.rest.BaseRestHandler;
        );
        deleteWorkloadGroupRequest.clusterManagerNodeTimeout(  
        );
import org.opensearch.rest.action.RestToXContentListener;  
 * @opensearch.experimental
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupAction;
        deleteWorkloadGroupRequest.timeout(request.paramAsTime("timeout", deleteWorkloadGroupRequest.timeout()));  
        nonPluginSettingValuesProvider.ensureWlmEnabled(getName());
 * this file be licensed under the Apache-2.0 license or a
     * The list of {@link Route}s that this RestHandler is responsible for handling.
            new RestToXContentListener<>(channel)
import java.io.IOException;  
    public String getName() {
    /**  
 *
/*  
 * SPDX-License-Identifier: Apache-2.0
public class RestDeleteWorkloadGroupAction extends BaseRestHandler {
     */
    public List<Route> routes() {
    }  
 * Rest action to delete a WorkloadGroup  
import org.opensearch.transport.client.node.NodeClient;
    @Override  
        this.nonPluginSettingValuesProvider = nonPluginSettingValuesProvider;
     * @param nonPluginSettingValuesProvider the settings provider to access the current WLM mode
 *
        return "delete_workload_group";  
import org.opensearch.plugin.wlm.action.DeleteWorkloadGroupRequest;  
import static org.opensearch.rest.RestRequest.Method.DELETE;  
 */  
/**
            request.paramAsTime("cluster_manager_timeout", deleteWorkloadGroupRequest.clusterManagerNodeTimeout())
import java.util.List;
    public RestDeleteWorkloadGroupAction(WlmClusterSettingValuesProvider nonPluginSettingValuesProvider) {  
        DeleteWorkloadGroupRequest deleteWorkloadGroupRequest = new DeleteWorkloadGroupRequest(request.param("name"));
     */
     * Constructor for RestDeleteWorkloadGroupAction  
            deleteWorkloadGroupRequest,  
            DeleteWorkloadGroupAction.INSTANCE,
        return List.of(new Route(DELETE, "_wlm/workload_group/{name}"));
    private final WlmClusterSettingValuesProvider nonPluginSettingValuesProvider;  
