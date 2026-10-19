     */  
    public void testRoutes() {
    /**
        params.put("nodes", "");
    private RestPruneCacheAction action;
 */  
     * Tests single node parameter handling.  
        Map<String, String> params = new HashMap<>();
        });
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
            largeNodeList.append("node").append(i);
     */  
            assertArrayEquals("Nodes parameter should take priority", new String[] { "node1", "node2" }, pruneFileCacheRequest.nodesIds());
        when(mockNode.getHostAddress()).thenReturn("127.0.0.1");
     * Tests large node list parameter handling.
            .withParams(params)
    public void testWarmNodeTargetingSyntax() throws Exception {  
            assertArrayEquals("Single node should be targeted", new String[] { "node1" }, pruneFileCacheRequest.nodesIds());
import org.opensearch.cluster.ClusterName;
            .build();
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);  
    public void testComprehensiveParameterCombinations() throws Exception {
    }
    public void testParameterCleaning() throws Exception {
     * Tests empty parameter handling edge cases.
            .withParams(params)
        });
import java.util.Arrays;  
            assertArrayEquals("Node targeting should work", new String[] { "node1", "node2" }, pruneFileCacheRequest.nodesIds());
            .withPath("/_filecache/prune")  
            assertNull("Default should target all nodes", pruneFileCacheRequest.nodesIds());
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheAction;
    }
            .build();  
    }
        });  
        when(mockNode.getAddress()).thenReturn(buildNewFakeTransportAddress());  
            assertNull("Empty nodes parameter should result in null", pruneFileCacheRequest.nodesIds());
        action = new RestPruneCacheAction();
            return createMockMultiNodeResponse();
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
    }
            return createMockMultiNodeResponse();
        Map<String, String> params = new HashMap<>();
        StringBuilder largeNodeList = new StringBuilder();
     * Tests comprehensive parameter combinations.
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
    /**
        });
        verifyingClient.setExecuteVerifier((actionType, request) -> {
            .withParams(params)  
        for (int i = 0; i < 10; i++) {  
}  
 *
            .withPath("/_filecache/prune")
    /**
            assertThat(request, instanceOf(PruneFileCacheRequest.class));  
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;  
            .withPath("/_filecache/prune")
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
        verifyingClient.setExecuteVerifier((actionType, request) -> {
 * this file be licensed under the Apache-2.0 license or a
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;  
        params.put("nodes", "node1,node2");
            );
            return createMockMultiNodeResponse();
        });
/**
     * Tests warm node targeting syntax.
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
     */
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
    @Before  
        List<NodePruneFileCacheResponse> nodeResponses = Arrays.asList(new NodePruneFileCacheResponse(mockNode, 1024L, 10737418240L));
            .withPath("/_filecache/prune")
/*  
        params.put("nodes", "warm:true");  
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
    }
        verifyingClient.setExecuteVerifier((actionType, request) -> {
import java.util.List;  
            assertEquals("Should handle large node list", 10, pruneFileCacheRequest.nodesIds().length);
     * Tests enhanced parameter handling.  
        Map<String, String> params = new HashMap<>();  
import java.util.Collections;
import org.opensearch.rest.RestRequest;
        Map<String, String> params = new HashMap<>();
        dispatchRequest(request);
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);  
            return createMockMultiNodeResponse();  
public class RestPruneCacheActionTests extends RestActionTestCase {
        Map<String, String> params = new HashMap<>();
        assertEquals(1, action.routes().size());
     * Tests that the action correctly reports it cannot trip circuit breaker.
        assertEquals("prune_filecache_action", action.getName());
        dispatchRequest(request);
        params.put("nodes", "node1,node2");  
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
        return new PruneFileCacheResponse(new ClusterName("test-cluster"), nodeResponses, Collections.emptyList());
        assertEquals(RestRequest.Method.POST, action.routes().get(0).getMethod());  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
 * compatible open source license.
    /**  
import org.opensearch.test.rest.RestActionTestCase;  
            .build();
    }
            .build();
     */  
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);  
        params.put("timeout", "5m");  
        when(mockNode.getHostName()).thenReturn("localhost");
import org.opensearch.test.rest.FakeRestRequest;
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
import static org.hamcrest.Matchers.instanceOf;  
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
import static org.mockito.Mockito.when;
            assertEquals("Timeout should be set", 30000, pruneFileCacheRequest.timeout().getMillis());  
        verifyingClient.setExecuteVerifier((actionType, request) -> {
 * The OpenSearch Contributors require contributions made to  
        params.put("nodes", largeNodeList.toString());  
        verifyingClient.setExecuteVerifier((actionType, request) -> {  
     */  
        });
        Map<String, String> params = new HashMap<>();
            .withParams(params)  
            .build();
            assertArrayEquals("Should clean parameters", new String[] { "node1", "node2" }, pruneFileCacheRequest.nodesIds());
    }  
 * SPDX-License-Identifier: Apache-2.0
    /**  
            .withPath("/_filecache/prune")  
            .build();  
    public void testGetName() {
        verifyingClient.setExecuteVerifier((actionType, request) -> {
                pruneFileCacheRequest.nodesIds()
package org.opensearch.rest.action.admin.cluster;
            .withParams(params)
        Map<String, String> params = new HashMap<>();
            .build();
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
        });
        dispatchRequest(request);
    public void testSingleNodeParameter() throws Exception {
        params.put("nodes", " node1 ,  node2  , ,   ");
            return createMockMultiNodeResponse();
    /**
     * Tests parameter cleaning and validation.
    }
        params.put("node", "node3");
        params.put("node", "");  
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
            .withParams(params)  
    public void testCanTripCircuitBreaker() {  
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
        dispatchRequest(request);  
        params.put("nodes", "warm-node-1,warm-node-2");
        controller().registerHandler(action);  
 * Covers route registration, parameter parsing, and multi-node response handling.  
                "Node targeting should work",
        verifyingClient.setExecuteVerifier((actionType, request) -> {
        Map<String, String> params = new HashMap<>();
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
        // Test large node list
    }  
     * Tests basic request preparation without parameters (all defaults).  
        when(mockNode.getId()).thenReturn("node1");
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)  
import org.junit.Before;
import java.util.Map;
    public void testPrepareRequestDefaults() throws Exception {
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
     */
        dispatchRequest(request);
    public void testLargeNodeListHandling() throws Exception {
    }
    /**
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
        DiscoveryNode mockNode = mock(DiscoveryNode.class);
    /**  
    }
    public void testEnhancedParameterHandling() throws Exception {
        }  
    /**
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);  
     */
            .withParams(params)
     * Tests nodes parameter takes priority over node parameter.
        dispatchRequest(request);  
            .build();
import org.opensearch.action.admin.cluster.filecache.NodePruneFileCacheResponse;
    private PruneFileCacheResponse createMockMultiNodeResponse() {  
        dispatchRequest(request);
 */
            .withPath("/_filecache/prune")
        assertEquals("/_filecache/prune", action.routes().get(0).getPath());
    /**
            .withPath("/_filecache/prune")  
            if (i > 0) largeNodeList.append(",");
        // Test empty parameters  
        dispatchRequest(request);  
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheRequest;  
            return createMockMultiNodeResponse();
    public void testParameterPriority() throws Exception {  
        });  
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;  
            .withParams(params)
     */  
     */
    /**
        verifyingClient.setExecuteVerifier((actionType, request) -> {  
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
                new String[] { "warm-node-1", "warm-node-2" },  
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;  
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
            .withPath("/_filecache/prune")
            assertArrayEquals("Should target warm nodes", new String[] { "warm:true" }, pruneFileCacheRequest.nodesIds());  
        params.put("timeout", "30s");
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheResponse;
import java.util.HashMap;
        verifyingClient.setExecuteVerifier((actionType, request) -> {  
    public void testEmptyParameterHandling() throws Exception {
    public void setUpAction() {
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
            assertArrayEquals(
            // Should clean whitespace and filter empty strings
        });
        assertFalse("Prune cache action should not trip circuit breaker", action.canTripCircuitBreaker());
        params.put("node", "node1");
            assertThat(request, instanceOf(PruneFileCacheRequest.class));  
            return createMockMultiNodeResponse();  
    }
            return createMockMultiNodeResponse();
    }  
import static org.mockito.Mockito.mock;
 * Tests for the enhanced {@link RestPruneCacheAction} class.
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
            .withPath("/_filecache/prune")  
            return createMockMultiNodeResponse();
    }
     */
            .build();
        dispatchRequest(request);
import org.opensearch.cluster.node.DiscoveryNode;  
     */
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
        when(mockNode.getName()).thenReturn("test-node");  
     * Verifies that the action has the correct registered name.
