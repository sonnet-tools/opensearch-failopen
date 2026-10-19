        String req = "{\"_ver\":2}";
}  
 */  
    public void setupAction() {  
    public void testCreateRequest_EmptyRequestBody() throws IOException {
public class RestClusterDeleteWeightedRoutingActionTests extends RestActionTestCase {
            .withPath("/_cluster/routing/awareness/zone/weights")  
    }
        RestRequest restRequest = buildRestRequest(req);  
        );
        controller().registerHandler(action);
        RestRequest restRequest2 = buildRestRequestWithAwarenessAttribute(req);  
    }
        String req = "{}";
        String req = "{\"_version\":2}";  
            .withParams(singletonMap("attribute", "zone"))
 * SPDX-License-Identifier: Apache-2.0
    private RestRequest buildRestRequestWithAwarenessAttribute(String content) {
import org.opensearch.action.admin.cluster.shards.routing.weighted.delete.ClusterDeleteWeightedRoutingRequest;
import static java.util.Collections.singletonMap;  
import org.opensearch.OpenSearchParseException;
        RestRequest restRequest2 = buildRestRequestWithAwarenessAttribute(req);  
            .build();
        ClusterDeleteWeightedRoutingRequest clusterDeleteWeightedRoutingRequest = RestClusterDeleteWeightedRoutingAction.createRequest(
        clusterDeleteWeightedRoutingRequest = RestClusterDeleteWeightedRoutingAction.createRequest(restRequest);
    @Before
    }  
import org.opensearch.test.rest.FakeRestRequest;  
    }
        assertEquals(2, clusterDeleteWeightedRoutingRequest.getVersion());
        assertThrows(OpenSearchParseException.class, () -> RestClusterDeleteWeightedRoutingAction.createRequest(restRequest));
import org.opensearch.rest.RestRequest;
        assertEquals(2, clusterDeleteWeightedRoutingRequest.getVersion());
        assertThrows(OpenSearchParseException.class, () -> RestClusterDeleteWeightedRoutingAction.createRequest(restRequest2));
        RestRequest restRequest = buildRestRequest(req);
import org.opensearch.test.rest.RestActionTestCase;
import org.opensearch.core.common.bytes.BytesArray;  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.rest.action.admin.cluster;
 *
        assertThrows(OpenSearchParseException.class, () -> RestClusterDeleteWeightedRoutingAction.createRequest(restRequest));
    public void testDeleteRequest_BadRequest() throws IOException {
        assertThrows(OpenSearchParseException.class, () -> RestClusterDeleteWeightedRoutingAction.createRequest(restRequest2));
import org.junit.Before;
        action = new RestClusterPutWeightedRoutingAction();
        return new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.DELETE)
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * this file be licensed under the Apache-2.0 license or a
    public void testDeleteRequest_SupportedRequestBody() throws IOException {
/*  
            .withContent(new BytesArray(content), MediaTypeRegistry.JSON)  
            .withPath("/_cluster/routing/awareness/weights")
 * compatible open source license.
        RestRequest restRequest = buildRestRequest(req);  
        return new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.DELETE)
    private RestRequest buildRestRequest(String content) {  
    private RestClusterPutWeightedRoutingAction action;  
            .withContent(new BytesArray(content), MediaTypeRegistry.JSON)
import java.io.IOException;
            .build();  
    }
        restRequest = buildRestRequestWithAwarenessAttribute(req);
        assertEquals("zone", clusterDeleteWeightedRoutingRequest.getAwarenessAttribute());  
            restRequest  
    }
