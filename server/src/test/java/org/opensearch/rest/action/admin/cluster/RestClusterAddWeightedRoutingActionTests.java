        action = new RestClusterPutWeightedRoutingAction();
    public void testCreateRequest_MalformedRequestBody() throws IOException {  
import org.opensearch.rest.RestRequest;
        Map<String, String> params = new HashMap<>();  
        String req = "{\"weights\":{\"us-east-1c\":\"0,\"us-east-1b\":\"1\",\"us-east-1a\":\"1\"},\"_version\":1}";  
            .withPath("/_cluster/routing/awareness/zone/weights")
        RestRequest restRequest = buildRestRequest(req);
import org.junit.Before;  
import java.util.HashMap;  
import org.opensearch.core.common.bytes.BytesArray;  
import org.opensearch.test.rest.FakeRestRequest;  
        assertEquals("1.0", clusterPutWeightedRoutingRequest.getWeightedRouting().weights().get("us-east-1b").toString());  
            .withContent(new BytesArray(content), MediaTypeRegistry.JSON)  
        assertThrows(OpenSearchParseException.class, () -> RestClusterPutWeightedRoutingAction.createRequest(restRequest));
 * compatible open source license.
public class RestClusterAddWeightedRoutingActionTests extends RestActionTestCase {
        String req = "[\"us-east-1c\" : \"1\", \"us-east-1d\":\"1\", \"us-east-1a\":\"0\"]";
        String req = "{}";  
    public void testCreateRequest_SupportedRequestBody() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    @Before
    }
    private RestClusterPutWeightedRoutingAction action;  
import org.opensearch.OpenSearchParseException;
 */  
            .withParams(singletonMap("attribute", "zone"))
import org.opensearch.tools.jackson.core.JsonParseException;
        controller().registerHandler(action);
        assertEquals(1, clusterPutWeightedRoutingRequest.getVersion());
        assertEquals("0.0", clusterPutWeightedRoutingRequest.getWeightedRouting().weights().get("us-east-1c").toString());
            .build();
    }  
    private RestRequest buildRestRequest(String content) {
import org.opensearch.action.admin.cluster.shards.routing.weighted.put.ClusterPutWeightedRoutingRequest;
 * SPDX-License-Identifier: Apache-2.0
        ClusterPutWeightedRoutingRequest clusterPutWeightedRoutingRequest = RestClusterPutWeightedRoutingAction.createRequest(restRequest);
    }  
    }  
        assertThrows(JsonParseException.class, () -> RestClusterPutWeightedRoutingAction.createRequest(restRequest));
import java.util.Map;
    public void setupAction() {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*  
        assertEquals("1.0", clusterPutWeightedRoutingRequest.getWeightedRouting().weights().get("us-east-1a").toString());
        RestRequest restRequest = buildRestRequest(req);
import org.opensearch.test.rest.RestActionTestCase;
 *
package org.opensearch.rest.action.admin.cluster;
        assertEquals("zone", clusterPutWeightedRoutingRequest.getWeightedRouting().attributeName());  
import static java.util.Collections.singletonMap;  
    public void testCreateRequest_UnsupportedRequestBody() throws IOException {
    }
    }  
        Map<String, String> params = new HashMap<>();
        assertNotNull(clusterPutWeightedRoutingRequest.getWeightedRouting().weights());
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        RestRequest restRequest = buildRestRequest(req);
}
        return new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.PUT)  
        String req = "{\"weights\":{\"us-east-1c\":\"0\",\"us-east-1b\":\"1\",\"us-east-1a\":\"1\"},\"_version\":1}";  
        assertThrows(OpenSearchParseException.class, () -> RestClusterPutWeightedRoutingAction.createRequest(restRequest));  
    public void testCreateRequest_EmptyRequestBody() throws IOException {
        RestRequest restRequest = buildRestRequest(req);
