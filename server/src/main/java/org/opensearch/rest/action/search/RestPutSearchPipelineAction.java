import java.util.List;
import org.opensearch.rest.BaseRestHandler;
    @Override  
 */
}  
 */  
        PutSearchPipelineRequest request = new PutSearchPipelineRequest(restRequest.param("id"), sourceTuple.v2(), sourceTuple.v1());
import org.opensearch.common.collect.Tuple;
    public List<Route> routes() {  
/*  
import org.opensearch.rest.action.RestToXContentListener;
import org.opensearch.action.search.PutSearchPipelineRequest;
import java.io.IOException;
    @Override
 * REST action to put a search pipeline
    }
import org.opensearch.core.common.bytes.BytesReference;  
        return "search_put_pipeline_action";
package org.opensearch.rest.action.search;
 * compatible open source license.
        return channel -> client.admin().cluster().putSearchPipeline(request, new RestToXContentListener<>(channel));
    protected RestChannelConsumer prepareRequest(RestRequest restRequest, NodeClient client) throws IOException {
        Tuple<MediaType, BytesReference> sourceTuple = restRequest.contentOrSourceParam();  
import org.opensearch.transport.client.node.NodeClient;
 * SPDX-License-Identifier: Apache-2.0
    }  
        return List.of(new Route(PUT, "/_search/pipeline/{id}"));
    public String getName() {
    }
 * @opensearch.internal  
public class RestPutSearchPipelineAction extends BaseRestHandler {
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.rest.RestRequest.Method.PUT;
/**  
import org.opensearch.rest.RestRequest;  
        request.clusterManagerNodeTimeout(restRequest.paramAsTime("cluster_manager_timeout", request.clusterManagerNodeTimeout()));
 * this file be licensed under the Apache-2.0 license or a
 *
 *
    @Override
        request.timeout(restRequest.paramAsTime("timeout", request.timeout()));  
import org.opensearch.core.xcontent.MediaType;
