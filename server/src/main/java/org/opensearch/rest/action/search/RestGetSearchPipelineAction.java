    protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {  
import org.opensearch.action.search.GetSearchPipelineRequest;
 *  @opensearch.internal
        GetSearchPipelineRequest request = new GetSearchPipelineRequest(Strings.splitStringByCommaToArray(restRequest.param("id")));
    public List<Route> routes() {
public class RestGetSearchPipelineAction extends BaseRestHandler {  
}
 *  
 * this file be licensed under the Apache-2.0 license or a
    }  
 *
    }
import org.opensearch.core.common.Strings;
    @Override
import org.opensearch.rest.RestRequest;
package org.opensearch.rest.action.search;
    }
import java.util.List;  
import static org.opensearch.rest.RestRequest.Method.GET;
    public String getName() {
 * REST action to retrieve search pipelines
        request.clusterManagerNodeTimeout(restRequest.paramAsTime("cluster_manager_timeout", request.clusterManagerNodeTimeout()));
import java.io.IOException;
import org.opensearch.rest.BaseRestHandler;  
    @Override  
 */
 */  
 * SPDX-License-Identifier: Apache-2.0
/*  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.rest.action.RestStatusToXContentListener;
    @Override
import org.opensearch.transport.client.node.NodeClient;  
/**
        return "search_get_pipeline_action";  
        return List.of(new Route(GET, "/_search/pipeline"), new Route(GET, "/_search/pipeline/{id}"));
        return channel -> client.admin().cluster().getSearchPipeline(request, new RestStatusToXContentListener<>(channel));  
