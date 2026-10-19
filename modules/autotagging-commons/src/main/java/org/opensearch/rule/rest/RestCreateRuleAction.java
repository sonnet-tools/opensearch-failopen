        };
     * constructor for RestCreateRuleAction
    @Override  
        return List.of(new RestHandler.Route(PUT, "_rules/{featureType}"));  
    public List<Route> routes() {
/*  
import org.opensearch.rest.BytesRestResponse;
        try (XContentParser parser = request.contentParser()) {  
            return channel -> client.execute(CreateRuleAction.INSTANCE, createRuleRequest, createRuleResponse(channel));  
            }  
    private RestResponseListener<CreateRuleResponse> createRuleResponse(final RestChannel channel) {
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.rule.autotagging.Rule.Builder;  
    @Override
 *
 * SPDX-License-Identifier: Apache-2.0
        }
 * The OpenSearch Contributors require contributions made to  
     */
import org.opensearch.rule.autotagging.FeatureType;
 * Rest action to create a Rule
package org.opensearch.rule.rest;
import org.opensearch.rest.RestHandler;
import org.opensearch.rule.action.CreateRuleAction;
 */
            public RestResponse buildResponse(final CreateRuleResponse response) throws Exception {
/**
 * @opensearch.experimental  
            CreateRuleRequest createRuleRequest = new CreateRuleRequest(builder.updatedAt(Instant.now().toString()).id().build());
    /**  
import java.util.List;
    @Override
public class RestCreateRuleAction extends BaseRestHandler {
import org.opensearch.rest.BaseRestHandler;
import org.opensearch.rule.action.CreateRuleResponse;
import org.opensearch.rest.RestRequest;
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
    public String getName() {  
import org.joda.time.Instant;
 * compatible open source license.
            Builder builder = Builder.fromXContent(parser, featureType);
import static org.opensearch.rule.rest.RestGetRuleAction.FEATURE_TYPE;
 */  
}  
        return new RestResponseListener<>(channel) {
import java.io.IOException;
import org.opensearch.rest.RestChannel;  
                return new BytesRestResponse(RestStatus.OK, response.toXContent(channel.newBuilder(), ToXContent.EMPTY_PARAMS));
import org.opensearch.rule.action.CreateRuleRequest;  
    }
import org.opensearch.rest.RestResponse;  
import org.opensearch.transport.client.node.NodeClient;
    }
    }
        final FeatureType featureType = FeatureType.from(request.param(FEATURE_TYPE));
import static org.opensearch.rest.RestRequest.Method.PUT;
    }
        return "create_rule";
    public RestCreateRuleAction() {}  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rest.action.RestResponseListener;
            @Override  
import org.opensearch.core.xcontent.XContentParser;  
