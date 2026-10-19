            IllegalArgumentException.class,
        assertThat(e.getMessage(), containsString("index is required"));
        assertThat(e.getMessage(), containsString("Parameter [search_only] is required"));
            .withMethod(RestRequest.Method.POST)  
import static org.mockito.Mockito.mock;
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
            .withContent(new BytesArray(json), XContentType.JSON)
            .build();
package org.opensearch.rest.action.admin.indices;
        Map<String, String> params = new HashMap<>();
        Map<String, String> params = new HashMap<>();  
            .withContent(new BytesArray(json), XContentType.JSON)
            .withMethod(RestRequest.Method.POST)  
        assertThat(e.getMessage(), containsString("Request body must be valid JSON"));
    }  
        );
        IllegalArgumentException e = expectThrows(  
    public void testInvalidJson() {
        Map<String, String> params = new HashMap<>();  
import org.opensearch.core.common.bytes.BytesArray;
 * SPDX-License-Identifier: Apache-2.0
        params.put("index", "test-index");
            .withContent(new BytesArray(json), XContentType.JSON)
        String json = "{\"unknown\": \"value\"}";
        params.put("index", "test-index");
        // Build a fake request with no "index" parameter
        );  
    public void testMissingIndexParam() {
        Object consumer = action.prepareRequest(restRequest, mock(NodeClient.class));  
    }
        assertThat(e.getMessage(), containsString("Unknown parameter [unknown]. Only [search_only] is allowed."));
    public void testParseScaleDownValueMultipleFields() {
        String json = "{\"search_only\": true}";
    @Override
        assertThat(consumer, notNullValue());
import static org.hamcrest.Matchers.notNullValue;  
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
            .withContent(new BytesArray(json), XContentType.JSON)
        Map<String, String> params = new HashMap<>();  
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
        );  
}
/*  
    }
import org.opensearch.common.xcontent.XContentType;
            .build();
        super.setUp();  
        params.put("index", "test-index");
        String json = "{}";
        IllegalArgumentException e = expectThrows(  
        params.put("index", "test-index");
            () -> action.prepareRequest(restRequest, mock(NodeClient.class))
import java.util.HashMap;
            IllegalArgumentException.class,
import org.opensearch.transport.client.node.NodeClient;  
    }  
            () -> action.prepareRequest(restRequest, mock(NodeClient.class))  
        Map<String, String> params = new HashMap<>();  
            .build();
    }
    public void testEmptyIndexParam() {
        IllegalArgumentException e = expectThrows(
        params.put("index", "test-index");
            IllegalArgumentException.class,
            .withContent(new BytesArray(json), XContentType.JSON)
    }
            .withMethod(RestRequest.Method.POST)  
        IllegalArgumentException e = expectThrows(  
        IllegalArgumentException e = expectThrows(  
            IllegalArgumentException.class,
    public void testUnknownParameterInBody() {
        );  
        Map<String, String> params = new HashMap<>();  
        String json = "{\"search_only\": true, \"unknown_field\": \"value\"}";
 */  
    public void setUp() throws Exception {
        assertThat(e.getMessage(), containsString("Unknown parameter [unknown_field]. Only [search_only] is allowed."));
        IllegalArgumentException e = expectThrows(
        Object consumer = action.prepareRequest(restRequest, mock(NodeClient.class));  
            IllegalArgumentException.class,
        String json = "{\"search_only\": false}";
    }
            .withMethod(RestRequest.Method.POST)  
            IllegalArgumentException.class,
    public void testValidRequestWithSearchOnlyTrue() throws Exception {
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
            () -> action.prepareRequest(restRequest, mock(NodeClient.class))
            () -> action.prepareRequest(restRequest, mock(NodeClient.class))
    public void testValidRequestWithSearchOnlyFalse() throws Exception {
            .withContent(new BytesArray(json), XContentType.JSON)
    private RestScaleIndexAction action;
            .build();
        assertThat(e.getMessage(), containsString("Parameter [search_only] must be a boolean (true or false)"));
    }
        params.put("index", "test-index");
        Map<String, String> params = new HashMap<>();  
            .build();
        assertThat(e.getMessage(), containsString("index is required"));
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            () -> action.prepareRequest(restRequest, mock(NodeClient.class))
            .withMethod(RestRequest.Method.POST)  
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
        params.put("index", "   ");
        String json = "{\"search_only\": \"not_a_boolean\"}";
        );  
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
            .build();
        params.put("index", "test-index");
        );
            () -> action.prepareRequest(restRequest, mock(NodeClient.class))
    public void testEmptyBody() {
            .build();
            .build();  
        // Build a fake request with an empty "index" parameter  
 *
            .withMethod(RestRequest.Method.POST)  
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
    }
        assertThat(consumer, notNullValue());
public class RestScaleIndexActionTests extends OpenSearchTestCase {  
        FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withParams(params)
            .build();
 * The OpenSearch Contributors require contributions made to  
        String json = "{\"search_only\": fa}"; // Invalid JSON
            .withContent(new BytesArray(json), XContentType.JSON)
            () -> action.prepareRequest(restRequest, mock(NodeClient.class))  
        Map<String, String> params = new HashMap<>();  
    }
        );  
import org.opensearch.test.OpenSearchTestCase;
        action = new RestScaleIndexAction();
        Map<String, String> params = new HashMap<>();  
            IllegalArgumentException.class,
import org.opensearch.test.rest.FakeRestRequest;
            .withMethod(RestRequest.Method.POST)
    public void testInvalidSearchOnlyType() {
            .withMethod(RestRequest.Method.POST)  
import java.util.Map;  
import org.opensearch.rest.RestRequest;  
            .withMethod(RestRequest.Method.POST)
import static org.hamcrest.Matchers.containsString;
        IllegalArgumentException e = expectThrows(  
