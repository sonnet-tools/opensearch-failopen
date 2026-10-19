import static org.opensearch.rest.RestRequest.Method.GET;  
import java.util.List;  
        // Act & Assert
        // Arrange
import java.util.HashMap;
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> handler.prepareRequest(request, client));  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
import org.opensearch.storage.action.tiering.status.rest.RestGetTieringStatusAction;  
        // Act  
import org.opensearch.test.OpenSearchTestCase;
        params.put("index", "test-index");  
        super.setUp();
    }
    private ThreadPool threadPool;
        Map<String, String> params = new HashMap<>();
        // Arrange
        threadPool = new TestThreadPool("test");  
        assertEquals(1, routes.size());
 */  
import org.mockito.Mock;  
    }
        assertEquals("request should contain single index", exception.getMessage());
import org.opensearch.rest.RestRequest;
        handler = new RestGetTieringStatusAction();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> handler.prepareRequest(request, client));  
import org.opensearch.threadpool.TestThreadPool;  
public class RestGetTieringStatusActionTests extends OpenSearchTestCase {
import org.opensearch.transport.client.node.NodeClient;
        Map<String, String> params = new HashMap<>();  
        assertNotNull(handler.prepareRequest(request, client));
    }
        assertEquals("get_index_tiering_status", handler.getName());  
import org.opensearch.threadpool.ThreadPool;
    private RestGetTieringStatusAction handler;  
        assertEquals("request should contain single index", exception.getMessage());
        MockitoAnnotations.openMocks(this);
        assertEquals("/{index}/_tier", route.getPath());
/*  
import org.opensearch.test.rest.FakeRestRequest;
    }
import org.mockito.MockitoAnnotations;
        Map<String, String> params = new HashMap<>();
    }  
    public void setUp() throws Exception {  
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.storage.action.admin.tiering.status.rest;
    public void testExecuteRequest() throws IOException {  
        assertNotNull(handler.prepareRequest(request, client));  
import java.util.Map;
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();  
        assertEquals("request should contain single index", exception.getMessage());  
    public void testPrepareRequestEmptyIndex() {
 *
        // Arrange  
        // Act & Assert
    public void testPrepareRequestNoIndex() {
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> handler.prepareRequest(request, client));
        Map<String, String> params = new HashMap<>();
    public void testPrepareRequestSingleIndex() throws IOException {  
    public void tearDown() throws Exception {
import java.io.IOException;
    public void testPrepareRequestMultipleIndices() {
    private NodeClient client;
        // Arrange
        // Act & Assert
        super.tearDown();
        params.put("index", "");
        List<RestHandler.Route> routes = handler.routes();
    public void testGetName() {
 * compatible open source license.
        params.put("index", "test-index");  
        RestHandler.Route route = routes.get(0);  
        // Arrange
import org.opensearch.rest.RestHandler;
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
        params.put("index", "index1,index2");
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).build();  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withParams(params).build();
    @Mock
 * The OpenSearch Contributors require contributions made to  
    }  
        assertEquals(GET, route.getMethod());
    }
        threadPool.shutdown();  
}  
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testRoutes() {  
