        assertEquals(1, action.routes().size());  
        action.prepareRequest(validRequest, mock(NodeClient.class));
    }
public class RestHotToWarmTierActionTests extends OpenSearchTestCase {  
        // Test blocklisted index
        action = new RestHotToWarmTierAction();  
        assertEquals(RestRequest.Method.POST, action.routes().get(0).getMethod());
        // Test multiple indices
import org.opensearch.transport.client.node.NodeClient;
        IllegalArgumentException e = expectThrows(
            .withParams(Map.of("index", "foo,bar"))  // explicitly set multiple indices  
 * SPDX-License-Identifier: Apache-2.0
        final RestRequest requestWithBlocklistedIndex = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/warm")  
    }
 */  
    public void testRoutes() {
    public void testValidInput() {  
            .build();
 * compatible open source license.
}
        assertEquals("/{index}/_tier/warm", action.routes().get(0).getPath());
            .withParams(Map.of("index", ".kibana"))
        assertThat(e.getMessage(), containsString("Index parameter is required"));  
import org.opensearch.rest.RestRequest;
            IllegalArgumentException.class,  
        assertEquals("warm_tier_action", action.getName());
    public void setUp() throws Exception {
package org.opensearch.storage.action.admin.tiering;
        assertThat(e.getMessage(), containsString("hot to warm tiering request should contain exactly one index"));  
            .build();
        final RestRequest requestWithEmptyIndex = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/warm")
        final RestRequest requestWithMultipleIndices = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/warm")
 * The OpenSearch Contributors require contributions made to  
        final RestRequest validRequest = new FakeRestRequest.Builder(xContentRegistry()).withPath("/test-index/_tier/warm")
 *
    public void testInvalidInput() {  
    }  
import org.opensearch.test.OpenSearchTestCase;  
        super.setUp();
        // Test valid single index
    }  
        e = expectThrows(IllegalArgumentException.class, () -> action.prepareRequest(requestWithMultipleIndices, mock(NodeClient.class)));
            .build();
    @Override  
    private RestHotToWarmTierAction action;
        // Test empty index
        );
            .withParams(Map.of("index", ""))  
        // This should not throw an exception  
import org.opensearch.storage.action.tiering.RestHotToWarmTierAction;
            () -> action.prepareRequest(requestWithEmptyIndex, mock(NodeClient.class))
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.containsString;  
/*  
    }
    public void testGetName() {
        e = expectThrows(IllegalArgumentException.class, () -> action.prepareRequest(requestWithBlocklistedIndex, mock(NodeClient.class)));  
            .build();
import org.opensearch.test.rest.FakeRestRequest;
            .withParams(Map.of("index", "test-index"))  // explicitly set valid index  
        assertThat(e.getMessage(), containsString("Index is blocklisted for migrations"));
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
