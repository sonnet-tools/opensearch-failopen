        return channel -> {
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
    @Override
    RandomnessProviderNameAction() {}  
 *
        return List.of(new Route(GET, "/_randomness/provider_name"));
}  
    }
            String providerName = Randomness.createSecure().getProvider().getName();  
import org.opensearch.rest.BytesRestResponse;
 * this file be licensed under the Apache-2.0 license or a
            XContentBuilder builder = channel.newBuilder();
        return "randomness_get_provider_name_action";  
 * compatible open source license.
import org.opensearch.transport.client.node.NodeClient;  
import static org.opensearch.core.rest.RestStatus.OK;
    @Override  
            channel.sendResponse(new BytesRestResponse(OK, builder));  
    }
    public String getName() {
    @Override
import org.opensearch.rest.BaseRestHandler;  
        };
import org.opensearch.rest.RestRequest;
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.common.Randomness;
/*  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
    public List<Route> routes() {  
package org.opensearch;
 */  
    }
 * The OpenSearch Contributors require contributions made to  
            builder.startObject().field("name", providerName).endObject();
public class RandomnessProviderNameAction extends BaseRestHandler {
import org.opensearch.core.xcontent.XContentBuilder;
