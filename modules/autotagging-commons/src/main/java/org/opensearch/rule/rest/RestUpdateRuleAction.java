import static org.opensearch.rule.rest.RestGetRuleAction.FEATURE_TYPE;  
import org.opensearch.rest.RestResponse;
    /**
                builder.getFeatureValue(),
}
        return "update_rule";  
        };  
import org.opensearch.rest.RestChannel;
 * The OpenSearch Contributors require contributions made to  
            );
/*  
    }
 */
    private RestResponseListener<UpdateRuleResponse> updateRuleResponse(final RestChannel channel) {  
    }
    @Override
        return List.of(new RestHandler.Route(PUT, "_rules/{featureType}/{id}"));
import org.opensearch.rest.RestRequest;  
            Builder builder = Builder.fromXContent(parser, featureType);  
                featureType  
        }  
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {  
import org.opensearch.core.rest.RestStatus;
    }
import static org.opensearch.rest.RestRequest.Method.PUT;
    public String getName() {
        return new RestResponseListener<>(channel) {
import org.opensearch.rule.action.UpdateRuleResponse;
import static org.opensearch.rule.autotagging.Rule.ID_STRING;
 * @opensearch.experimental
 * Rest action to update a Rule  
            public RestResponse buildResponse(final UpdateRuleResponse response) throws Exception {  
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.action.RestResponseListener;
import org.opensearch.rest.BaseRestHandler;
/**
import org.opensearch.rule.autotagging.FeatureType;  
                return new BytesRestResponse(RestStatus.OK, response.toXContent(channel.newBuilder(), ToXContent.EMPTY_PARAMS));
 * compatible open source license.
        try (XContentParser parser = request.contentParser()) {
    public List<Route> routes() {
    @Override
    @Override  
import org.opensearch.core.xcontent.ToXContent;  
 */  
import org.opensearch.rule.autotagging.Rule.Builder;
package org.opensearch.rule.rest;
@ExperimentalApi  
                builder.getAttributeMap(),
            return channel -> client.execute(UpdateRuleAction.INSTANCE, updateRuleRequest, updateRuleResponse(channel));
import java.util.List;
import java.io.IOException;
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.rule.action.UpdateRuleAction;  
    }  
import org.opensearch.rest.RestHandler;
public class RestUpdateRuleAction extends BaseRestHandler {
    public RestUpdateRuleAction() {}
import org.opensearch.rule.action.UpdateRuleRequest;
        final FeatureType featureType = FeatureType.from(request.param(FEATURE_TYPE));
            }
                builder.getDescription(),  
     */
                request.param(ID_STRING),
            @Override
            UpdateRuleRequest updateRuleRequest = new UpdateRuleRequest(
import org.opensearch.rest.BytesRestResponse;  
     * constructor for RestUpdateRuleAction  
 * this file be licensed under the Apache-2.0 license or a
