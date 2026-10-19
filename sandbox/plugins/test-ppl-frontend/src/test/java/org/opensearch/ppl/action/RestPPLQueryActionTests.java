import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.common.xcontent.XContentType;
            .withPath("/_analytics/ppl")
    public void testPrepareRequestMissingQuery() {
        assertEquals("/_analytics/ppl", action.routes().get(0).getPath());  
 * this file be licensed under the Apache-2.0 license or a
    }  
}
    public void testName() {
/*  
import org.opensearch.rest.RestRequest;  
        assertEquals(RestRequest.Method.POST, action.routes().get(1).getMethod());
        assertTrue(ex.getMessage().contains("query"));  
    }
 *
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> action.prepareRequest(request, null));
public class RestPPLQueryActionTests extends OpenSearchTestCase {
    }
    private final RestPPLQueryAction action = new RestPPLQueryAction();  
import org.opensearch.test.rest.FakeRestRequest;
package org.opensearch.ppl.action;
        assertEquals(2, action.routes().size());
 * SPDX-License-Identifier: Apache-2.0
            .withContent(new BytesArray("{\"other\":\"value\"}"), XContentType.JSON)
        assertEquals(RestRequest.Method.POST, action.routes().get(0).getMethod());
        assertEquals("/_analytics/ppl/_explain", action.routes().get(1).getPath());
        assertEquals("analytics_ppl_query", action.getName());  
            .build();  
        FakeRestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)  
 * The OpenSearch Contributors require contributions made to  
 */  
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
    public void testRoutes() {  
