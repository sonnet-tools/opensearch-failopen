        final RestRequest requestWithEmptyIndex = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/_cancel/")  
        final RestRequest validSpecialCharRequest = new FakeRestRequest.Builder(xContentRegistry()).withPath(  
    public void testInvalidBlankIndexName() {
        assertNotNull(action.prepareRequest(validDataStreamRequest, mock(NodeClient.class)));
    private RestCancelTierAction action;
            .withParams(Map.of("index", ""))
        ).withParams(Map.of("index", "test-index_123")).build();
package org.opensearch.storage.action.admin.tiering;
        assertNotNull(action.prepareRequest(validSpecialCharRequest, mock(NodeClient.class)));
        super.setUp();  
public class RestCancelTierActionTests extends OpenSearchTestCase {
        final RestRequest requestWithTimeouts = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/_cancel/test-index")
        // Test index names with valid special characters
 * this file be licensed under the Apache-2.0 license or a
        // This should not throw an exception as data stream indices are allowlisted  
        IllegalArgumentException e = expectThrows(
        final RestRequest requestWithBlocklistedIndex = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/_cancel/.kibana")
/*  
            .build();  
            .withParams(Map.of("index", "test-index"))
        assertEquals(1, action.routes().size());  
/**  
        action = new RestCancelTierAction();
        final RestRequest requestWithMultipleIndices = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/_cancel/foo,bar")
    }
    public void testGetName() {
    public void testValidDataStreamBackingIndex() {  
 * Tests REST endpoint validation, parameter handling, and error conditions.
            () -> action.prepareRequest(requestWithMultipleIndices, mock(NodeClient.class))
    public void testInvalidInputNullIndex() {
    }
import org.opensearch.test.rest.FakeRestRequest;
        assertThat(e.getMessage(), containsString("Index is blocklisted for migrations"));  
        );
        assertNotNull(action.prepareRequest(requestWithTimeouts, mock(NodeClient.class)));  
        );
            () -> action.prepareRequest(requestWithNullIndex, mock(NodeClient.class))
    }
 *
    }
    }
            .withParams(Map.of("index", "foo,bar"))
        );
        IllegalArgumentException e = expectThrows(
        // This should not throw an exception and should handle timeout parameters
    public void setUp() throws Exception {
        // Test that data stream backing indices (which start with .ds-) are allowed
    }
        final RestRequest requestWithNullIndex = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/_cancel/").build();  
        ).withParams(Map.of("index", ".ds-logs-2023.01.01-000001")).build();
            IllegalArgumentException.class,  
        assertNotNull(action.prepareRequest(validRequest, mock(NodeClient.class)));  
        final RestRequest validDataStreamRequest = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            .build();  
        assertEquals(RestRequest.Method.POST, action.routes().get(0).getMethod());
            IllegalArgumentException.class,
    public void testValidIndexWithSpecialCharacters() {
    }  
    }  
        );
        assertEquals("/_tier/_cancel/{index}", action.routes().get(0).getPath());
            "/_tier/_cancel/test-index_123"
    }
 * compatible open source license.
        final RestRequest requestWithBlankIndex = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/_cancel/ /")
 * Unit tests for RestCancelTierAction.
        assertThat(e.getMessage(), containsString("Index parameter is required"));  
        // This should not throw an exception
    }
        IllegalArgumentException e = expectThrows(
 * The OpenSearch Contributors require contributions made to  
            .build();
            () -> action.prepareRequest(requestWithEmptyIndex, mock(NodeClient.class))  
import org.opensearch.storage.action.tiering.RestCancelTierAction;
        assertThat(e.getMessage(), containsString("Cancel tiering request should contain exactly one index"));  
            IllegalArgumentException.class,  
 */  
            IllegalArgumentException.class,  
 * SPDX-License-Identifier: Apache-2.0
            .withParams(Map.of("index", " "))  
    public void testValidIndexWithTimeoutParameters() {  
        );  
        IllegalArgumentException e = expectThrows(
        final RestRequest validRequest = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_tier/_cancel/test-index")
    @Override
    public void testValidSingleIndex() {  
 */  
import java.util.Map;
import static org.mockito.Mockito.mock;
            .withParams(Map.of("index", ".kibana"))
    public void testInvalidInputMultipleIndices() {  
    public void testInvalidInputBlocklistedIndex() {  
    public void testInvalidInputEmptyIndex() {
    public void testRoutes() {
import static org.hamcrest.Matchers.containsString;  
    }  
            "/_tier/_cancel/.ds-logs-2023.01.01-000001"  
        assertThat(e.getMessage(), containsString("Index name cannot be null or empty"));
import org.opensearch.transport.client.node.NodeClient;
        assertEquals("cancel_tier_action", action.getName());
            () -> action.prepareRequest(requestWithBlankIndex, mock(NodeClient.class))
            () -> action.prepareRequest(requestWithBlocklistedIndex, mock(NodeClient.class))
}  
import org.opensearch.rest.RestRequest;
            .build();  
            .build();
        IllegalArgumentException e = expectThrows(  
            IllegalArgumentException.class,
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(e.getMessage(), containsString("Index parameter is required"));
            .build();  
            .withParams(Map.of("index", "test-index", "timeout", "30s", "cluster_manager_timeout", "60s"))
    }
