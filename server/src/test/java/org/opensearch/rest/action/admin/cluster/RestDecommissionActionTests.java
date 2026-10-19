        Map<String, String> params = new HashMap<>();
import java.util.Map;  
    private FakeRestRequest buildRestRequest(Map<String, String> params) {
    }  
package org.opensearch.rest.action.admin.cluster;
 */  
        assertEquals(request.getDelayTimeout().getSeconds(), DecommissionRequest.DEFAULT_NODE_DRAINING_TIMEOUT.getSeconds());
 * compatible open source license.
            .withPath("/_cluster/decommission/awareness/{awareness_attribute_name}/{awareness_attribute_value}")
            .withParams(params)
        DecommissionRequest request = action.createRequest(deprecatedRequest);
        RestRequest deprecatedRequest = buildRestRequest(params);
    }
        DecommissionRequest request = action.createRequest(deprecatedRequest);
        Map<String, String> params = new HashMap<>();
import org.opensearch.rest.RestRequest;
    public void setupAction() {
    public void testCreateRequestWithNoDelay() throws IOException {
        assertEquals(request.getDecommissionAttribute().attributeValue(), "zone-1");
        action = new RestDecommissionAction();
import java.io.IOException;
        params.put("delay_timeout", "300s");  
        assertEquals(request.getDelayTimeout().getSeconds(), 120);
        params.put("awareness_attribute_value", "zone-1");  
        params.put("awareness_attribute_name", "zone");
        assertEquals(request.getDelayTimeout().getSeconds(), 0);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(deprecatedRequest.getHttpRequest().method(), RestRequest.Method.PUT);  
        params.put("draining_timeout", "60s");
import java.util.HashMap;
        params.put("awareness_attribute_name", "zone");
 *
    public void testCreateRequestWithDefaultTimeout() throws IOException {  
        RestRequest deprecatedRequest = buildRestRequest(params);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.rest.FakeRestRequest;  
        assertEquals(request.getDelayTimeout().getSeconds(), 300);
            .build();  
    }
        params.put("awareness_attribute_name", "zone");
        assertEquals(deprecatedRequest.getHttpRequest().method(), RestRequest.Method.PUT);
        Map<String, String> params = new HashMap<>();  
        params.put("awareness_attribute_value", "zone-1");
        controller().registerHandler(action);  
    }  
        assertEquals(request.getDecommissionAttribute().attributeName(), "zone");
import org.opensearch.action.admin.cluster.decommission.awareness.put.DecommissionRequest;
 * The OpenSearch Contributors require contributions made to  
        assertEquals(request.getDecommissionAttribute().attributeValue(), "zone-1");  
        params.put("no_delay", "true");  
        params.put("awareness_attribute_name", "zone");
    public void testCreateRequest() throws IOException {  
        params.put("awareness_attribute_value", "zone-1");  
        assertEquals(request.getDecommissionAttribute().attributeName(), "zone");  
        params.put("awareness_attribute_value", "zone-1");
}
        return new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.PUT)  
        assertEquals(deprecatedRequest.getHttpRequest().method(), RestRequest.Method.PUT);
        assertEquals(request.getDecommissionAttribute().attributeName(), "zone");
public class RestDecommissionActionTests extends RestActionTestCase {
    private RestDecommissionAction action;
        assertEquals(request.getDecommissionAttribute().attributeName(), "zone");
import org.junit.Before;
        RestRequest deprecatedRequest = buildRestRequest(params);
        DecommissionRequest request = action.createRequest(deprecatedRequest);
    }
    @Before  
    public void testCreateRequestWithDelayTimeout() throws IOException {
/*  
        DecommissionRequest request = action.createRequest(deprecatedRequest);
        assertEquals(deprecatedRequest.getHttpRequest().method(), RestRequest.Method.PUT);
        assertEquals(request.getDecommissionAttribute().attributeValue(), "zone-1");  
    }  
import org.opensearch.test.rest.RestActionTestCase;
        assertEquals(request.getDecommissionAttribute().attributeValue(), "zone-1");  
        RestRequest deprecatedRequest = buildRestRequest(params);  
        Map<String, String> params = new HashMap<>();  
