    }
        return "search_delete_pipeline_action";
 */
import java.io.IOException;
package org.opensearch.rest.action.search;
    }  
        request.clusterManagerNodeTimeout(restRequest.paramAsTime("cluster_manager_timeout", request.clusterManagerNodeTimeout()));
    public String getName() {
import org.opensearch.rest.BaseRestHandler;
    @Override  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
import org.opensearch.rest.action.RestToXContentListener;
import org.opensearch.transport.client.node.NodeClient;
    @Override
import org.opensearch.action.search.DeleteSearchPipelineRequest;
    }
}
    public List<Route> routes() {  
 * The OpenSearch Contributors require contributions made to  
public class RestDeleteSearchPipelineAction extends BaseRestHandler {
 *
 * REST action to delete a search pipeline
    @Override
        return channel -> client.admin().cluster().deleteSearchPipeline(request, new RestToXContentListener<>(channel));  
import static org.opensearch.rest.RestRequest.Method.DELETE;
        DeleteSearchPipelineRequest request = new DeleteSearchPipelineRequest(restRequest.param("id"));  
        return List.of(new Route(DELETE, "/_search/pipeline/{id}"));
        request.timeout(restRequest.paramAsTime("timeout", request.timeout()));
 *
 *  @opensearch.internal  
/**  
 * this file be licensed under the Apache-2.0 license or a
    protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {
 */  
/*  
import org.opensearch.rest.RestRequest;  
