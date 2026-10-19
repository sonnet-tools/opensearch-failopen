import static org.hamcrest.Matchers.containsString;  
    }  
        final RestRequest validRequest = new FakeRestRequest.Builder(xContentRegistry()).withPath("/test-index/_tier/hot")
        );
            .build();
    @Override  
        final RestRequest requestWithBlocklistedIndex = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/hot")  
            () -> action.prepareRequest(requestWithEmptyIndex, mock(NodeClient.class))
package org.opensearch.storage.action.admin.tiering;
        final RestRequest requestWithMultipleIndices = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/hot")
    }
        super.setUp();
public class RestWarmToHotTierActionTests extends OpenSearchTestCase {  
    public void setUp() throws Exception {
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.test.rest.FakeRestRequest;
            .build();
        assertThat(e.getMessage(), containsString("Index parameter is required"));  
/*  
        assertEquals("hot_tier_action", action.getName());
    }
 */  
    public void testRoutes() {
            .withParams(Map.of("index", ""))  
        action = new RestWarmToHotTierAction();  
    public void testInvalidInput() {  
    public void testGetName() {
}
 * SPDX-License-Identifier: Apache-2.0
        // This should not throw an exception  
 * this file be licensed under the Apache-2.0 license or a
    private RestWarmToHotTierAction action;
        // Test empty index
            IllegalArgumentException.class,  
        e = expectThrows(IllegalArgumentException.class, () -> action.prepareRequest(requestWithBlocklistedIndex, mock(NodeClient.class)));  
import org.opensearch.rest.RestRequest;
    }
        action.prepareRequest(validRequest, mock(NodeClient.class));
    public void testValidInput() {  
        // Test blocklisted index
        final RestRequest requestWithEmptyIndex = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/hot")
 *
import org.opensearch.storage.action.tiering.RestWarmToHotTierAction;
import static org.mockito.Mockito.mock;
            .withParams(Map.of("index", "test-index"))  // explicitly set valid index  
            .withParams(Map.of("index", ".kibana"))
        assertThat(e.getMessage(), containsString("Index is blocklisted for migrations"));
    }  
        IllegalArgumentException e = expectThrows(
        assertEquals("/{index}/_tier/hot", action.routes().get(0).getPath());
 * compatible open source license.
            .build();
        // Test valid single index
import java.util.Map;
            .withParams(Map.of("index", "foo,bar"))  // explicitly set multiple indices  
        e = expectThrows(IllegalArgumentException.class, () -> action.prepareRequest(requestWithMultipleIndices, mock(NodeClient.class)));
            .build();
        // Test multiple indices
        assertThat(e.getMessage(), containsString("warm to hot tiering request should contain exactly one index"));  
        assertEquals(1, action.routes().size());  
import org.opensearch.transport.client.node.NodeClient;
        assertEquals(RestRequest.Method.POST, action.routes().get(0).getMethod());
 * The OpenSearch Contributors require contributions made to  
