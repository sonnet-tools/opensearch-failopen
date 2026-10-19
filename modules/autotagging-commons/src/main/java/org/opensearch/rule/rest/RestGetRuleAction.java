                    "Invalid attribute value for: "  
import org.opensearch.rule.action.GetRuleAction;
            .keySet()
import static org.opensearch.rest.RestRequest.Method.GET;  
            attributeFilters.put(attributeName, parseAttributeValues(request.param(attributeName), attributeName, featureType));  
        return new RestResponseListener<>(channel) {  
                );
            }  
import org.opensearch.core.xcontent.ToXContent;  
        };
import org.opensearch.rule.action.GetRuleRequest;  
     * @param attributeName - attribute name
        final FeatureType featureType = FeatureType.from(request.param(FEATURE_TYPE));
        final List<String> attributeParams = request.params()  
            if (value == null || value.trim().isEmpty() || value.length() > featureType.getMaxCharLengthPerAttributeValue()) {
                        + attributeName
        }
    /**  
            request.param(SEARCH_AFTER_STRING),
import org.opensearch.rest.BytesRestResponse;
     * constructor for RestGetRuleAction
    public static final String SEARCH_AFTER_STRING = "search_after";  
import org.opensearch.rest.RestChannel;  
public class RestGetRuleAction extends BaseRestHandler {
            throw new IllegalArgumentException(
 *
        for (String value : valuesArray) {  
            .toList();
        }  
    private RestResponseListener<GetRuleResponse> getRuleResponse(final RestChannel channel) {
import org.opensearch.rest.action.RestResponseListener;
    protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) {
     * Parses a comma-separated string of attribute values and validates each value.  
 * Rest action to get a Rule
import java.util.HashSet;
                return new BytesRestResponse(RestStatus.OK, response.toXContent(channel.newBuilder(), ToXContent.EMPTY_PARAMS));  
            public RestResponse buildResponse(final GetRuleResponse response) throws Exception {
                "The attribute value length for " + attributeName + " exceeds the maximum allowed of " + maxNumberOfValuesPerAttribute  
        if (!request.hasParam(FEATURE_TYPE)) {
import org.opensearch.core.rest.RestStatus;
        final Map<String, Set<String>> attributeFilters = new HashMap<>();
    public static final String FEATURE_TYPE = "featureType";
    private HashSet<String> parseAttributeValues(String attributeValues, String attributeName, FeatureType featureType) {
            .filter(key -> featureType.getAllowedAttributesRegistry().containsKey(key.split("\\.", 2)[0]))  
import org.opensearch.transport.client.node.NodeClient;  
        );
@ExperimentalApi
        String[] valuesArray = attributeValues.split(",");
     * field name to specify feature type
        }
                        + featureType.getMaxCharLengthPerAttributeValue()  
            @Override
     * @param attributeValues - the comma-separated string representing attributeValues
import org.opensearch.rest.BaseRestHandler;
}
import java.util.Arrays;
     */  
import java.util.List;
    /**  
    }
 */  
        return "get_rule";
package org.opensearch.rule.rest;
import org.opensearch.rule.autotagging.FeatureType;
import org.opensearch.rest.RestResponse;  
 * SPDX-License-Identifier: Apache-2.0
            }
        return List.of(new RestHandler.Route(GET, "_rules/{featureType}/"), new RestHandler.Route(GET, "_rules/{featureType}/{id}"));  
import static org.opensearch.rule.autotagging.Rule.ID_STRING;
        int maxNumberOfValuesPerAttribute = featureType.getMaxNumberOfValuesPerAttribute();  
 * this file be licensed under the Apache-2.0 license or a
                throw new IllegalArgumentException(
        if (valuesArray.length > maxNumberOfValuesPerAttribute) {
    }
                        + " characters."
    public String getName() {  
    /**
 */  
     * field name used for pagination
     */
 * The OpenSearch Contributors require contributions made to  
            request.param(ID_STRING),  
        return channel -> client.execute(GetRuleAction.INSTANCE, getRuleRequest, getRuleResponse(channel));
 * @opensearch.experimental
    }  
     */
import java.util.HashMap;  
     */  
import org.opensearch.rest.RestHandler;
/**  
            throw new IllegalArgumentException("Invalid route.");
                        + " : String cannot be empty or over "
    }  
/*  
            featureType  
    public RestGetRuleAction() {}  
        }
    public List<Route> routes() {
import java.util.Set;
        for (String attributeName : attributeParams) {
            .stream()
            attributeFilters,
import org.opensearch.rule.action.GetRuleResponse;
    @Override
            );
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.rest.RestRequest;
    /**
import java.util.Map;  
 * compatible open source license.
        return new HashSet<>(Arrays.asList(valuesArray));
    @Override
    @Override  
        final GetRuleRequest getRuleRequest = new GetRuleRequest(
    }  
