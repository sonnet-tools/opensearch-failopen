        ClearCacheNodesRequest req = captureRequest(Map.of("footer", "false", "column", "true"));  
    @SuppressWarnings("unchecked")  
 *
                }  
        assertFalse(req.isStatistics());
        assertFalse(req.isStatistics());
    public void testSinglePostRoute() {
                "/_plugins/_analytics_backend_datafusion/cache/_clear"
    }  
                    captured.set((ClearCacheNodesRequest) request);
        assertEquals(POST, routes.get(0).getMethod());
        assertFalse(req.isFooter());
        assertFalse(req.isClearAll());
    public void testFooterParamSetsFooterFlag() throws Exception {
        assertFalse(req.isOffset());  
        assertFalse(req.isFooter());
            public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
    public void testName() {  
    }  
 */  
        assertTrue(req.isOffset());  
/**
        assertFalse(req.isFooter());
            action.handleRequest(restRequest, channel, client);
package org.opensearch.be.datafusion.action.stats;
        assertFalse(req.isFooter());
        super.setUp();
                ActionListener<Response> listener
public class RestClearCacheActionTests extends OpenSearchTestCase {
    public void testFalseParamDoesNotSetFlag() throws Exception {
    public void testNoParamsSendsClearAllRequest() throws Exception {
        assertFalse(req.isClearAll());  
        assertFalse(req.isClearAll());
 * this file be licensed under the Apache-2.0 license or a
 */  
        assertFalse(req.isClearAll());
        }) {
        assertFalse(action.canTripCircuitBreaker());
        assertFalse(req.isOffset());  
    public void setUp() throws Exception {  
        List<Route> routes = action.routes();  
            @Override
/*  
import static org.opensearch.rest.RestRequest.Method.POST;
        assertFalse(req.isClearAll());
    }
        assertFalse(req.isColumn());
        ClearCacheNodesRequest req = captureRequest(Map.of());  
    public void testColumnParamSetsColumnFlag() throws Exception {
    public void testMultipleParamsSetsMultipleFlags() throws Exception {
    @Override
import java.util.List;
    private ClearCacheNodesRequest captureRequest(Map<String, String> params) throws Exception {
            ) {  
        assertTrue(req.isColumn());
    }  
    }
 * compatible open source license.
    }
        assertFalse(req.isFooter());
        AtomicReference<ClearCacheNodesRequest> captured = new AtomicReference<>();
        assertNotNull("request must have been captured", captured.get());  
        assertTrue(req.isOffset());  
        ClearCacheNodesRequest req = captureRequest(Map.of("offset", "true"));  
    public void testDoesNotTripCircuitBreaker() {
import org.opensearch.core.action.ActionResponse;
        assertEquals("datafusion_clear_cache_action", action.getName());
import org.opensearch.rest.RestHandler.Route;
 * Unit tests for {@link RestClearCacheAction}.
        ClearCacheNodesRequest req = captureRequest(Map.of("footer", "true"));  
        assertTrue(req.isColumn());
    public void testStatisticsParamSetsStatisticsFlag() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
    }  
    }  
            FakeRestRequest restRequest = new FakeRestRequest.Builder(xContentRegistry()).withPath(  
        assertFalse(req.isOffset());  
        ClearCacheNodesRequest req = captureRequest(Map.of("column", "true", "offset", "true"));  
        assertFalse(req.isFooter());
        assertTrue(req.isFooter());
import org.opensearch.core.action.ActionListener;  
        assertEquals("/_plugins/_analytics_backend_datafusion/cache/_clear", routes.get(0).getPath());  
        assertFalse(req.isStatistics());
import java.util.concurrent.atomic.AtomicReference;  
}  
        assertFalse(req.isColumn());
        assertFalse(req.isColumn());
import java.util.HashMap;  
        assertFalse(req.isStatistics());
import org.opensearch.test.rest.FakeRestRequest;  
        assertTrue(req.isColumn());
        ClearCacheNodesRequest req = captureRequest(Map.of("column", "true"));  
        }
                if (request instanceof ClearCacheNodesRequest) {
import org.opensearch.test.OpenSearchTestCase;  
    }  
import org.opensearch.test.client.NoOpNodeClient;
            }
        action = new RestClearCacheAction();
    private RestClearCacheAction action;  
        assertFalse(req.isOffset());  
    }  
    public void testOffsetParamSetsOffsetFlag() throws Exception {
        assertFalse(req.isClearAll());
 * The OpenSearch Contributors require contributions made to  
        assertEquals(1, routes.size());
                ActionType<Response> actionType,  
        assertFalse(req.isColumn());
import org.opensearch.action.ActionRequest;
        return captured.get();
    }  
            ).withParams(new HashMap<>(params)).build();
        assertTrue(req.isStatistics());
import org.opensearch.transport.client.node.NodeClient;
            FakeRestChannel channel = new FakeRestChannel(restRequest, false, 1);  
import java.util.Map;
    }
import org.opensearch.action.ActionType;
        try (NodeClient client = new NoOpNodeClient(getTestName()) {  
        assertTrue("no params → isClearAll()", req.isClearAll());
import org.opensearch.test.rest.FakeRestChannel;
        assertFalse(req.isStatistics());
        ClearCacheNodesRequest req = captureRequest(Map.of("statistics", "true"));  
                Request request,
