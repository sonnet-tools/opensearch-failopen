    public void testPrepareRequestFiltersAllowedAttributes() {  
    public void testGetName() {
        Map<String, String> params = Map.of(FEATURE_TYPE, featureType.getName(), validAttrName, "value1", "invalidAttr", "shouldBeIgnored");  
        assertEquals(2, routes.size());
package org.opensearch.rule.rest;
 * compatible open source license.
        assertTrue(routes.stream().anyMatch(r -> r.getPath().equals("_rules/{featureType}/{id}")));  
import org.opensearch.rest.RestRequest.Method;
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.rest.FakeRestRequest;  
        assertEquals("get_rule", action.getName());
public class RestGetRuleActionTests extends OpenSearchTestCase {
import static org.opensearch.rule.rest.RestGetRuleAction.FEATURE_TYPE;
        assertTrue(routes.stream().anyMatch(r -> r.getPath().equals("_rules/{featureType}/")));
import org.opensearch.test.OpenSearchTestCase;
    }  
        FeatureType featureType = InMemoryRuleProcessingServiceTests.WLMFeatureType.WLM;
    private RestGetRuleAction action;  
        assertNotNull(action.prepareRequest(request, null));
import java.util.Map;  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(Method.GET).withParams(params).build();
    }  
import org.junit.Before;
/*  
import org.opensearch.rest.RestRequest;
import org.opensearch.rule.autotagging.FeatureType;
    }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    public void setUpAction() {  
import org.opensearch.rule.InMemoryRuleProcessingServiceTests;  
    public void testRoutes() {
        action = new RestGetRuleAction();
    @Before
        var routes = action.routes();  
 */  
}
    }
        String validAttrName = featureType.getAllowedAttributesRegistry().keySet().iterator().next();
