        };  
    /**
                );
import org.opensearch.rest.RestResponse;  
 * this file be licensed under the Apache-2.0 license or a
    public RestDeleteRuleAction() {}
import org.opensearch.rest.RestRequest;
    }
            }
import org.opensearch.core.rest.RestStatus;  
            @Override
@ExperimentalApi
     */  
 * The OpenSearch Contributors require contributions made to  
                    channel.newBuilder().startObject().field("acknowledged", response.isAcknowledged()).endObject()  
        return new RestResponseListener<>(channel) {
import org.opensearch.rule.action.DeleteRuleRequest;  
                return new BytesRestResponse(
                    RestStatus.OK,
        return List.of(new RestHandler.Route(DELETE, "_rules/{featureType}/{id}"));
        return channel -> client.execute(DeleteRuleAction.INSTANCE, deleteRuleRequest, deleteRuleResponse(channel));  
package org.opensearch.rule.rest;
    @Override  
    }
public class RestDeleteRuleAction extends BaseRestHandler {  
 * SPDX-License-Identifier: Apache-2.0
        final String ruleId = request.param(ID_STRING);  
/*  
    public String getName() {
import org.opensearch.rest.action.RestResponseListener;
            public RestResponse buildResponse(final AcknowledgedResponse response) throws Exception {  
    public List<Route> routes() {  
        DeleteRuleRequest deleteRuleRequest = new DeleteRuleRequest(ruleId, featureType);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.opensearch.rest.RestRequest.Method.DELETE;  
     * Constructor for RestDeleteRuleAction
        FeatureType featureType = FeatureType.from(request.param(FEATURE_TYPE));
import static org.opensearch.rule.rest.RestGetRuleAction.FEATURE_TYPE;
import org.opensearch.rule.action.DeleteRuleAction;
 */  
        return "delete_rule";
import java.util.List;
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.rule.autotagging.FeatureType;
}
 * Rest action to delete a Rule
import org.opensearch.rest.BaseRestHandler;
 *
 * @opensearch.experimental  
    @Override
import org.opensearch.transport.client.node.NodeClient;
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
    private RestResponseListener<AcknowledgedResponse> deleteRuleResponse(final RestChannel channel) {  
import org.opensearch.rest.RestChannel;  
 */
import org.opensearch.rest.BytesRestResponse;
import org.opensearch.rest.RestHandler;
 * compatible open source license.
    }
import static org.opensearch.rule.autotagging.Rule.ID_STRING;
    }  
    @Override
/**
