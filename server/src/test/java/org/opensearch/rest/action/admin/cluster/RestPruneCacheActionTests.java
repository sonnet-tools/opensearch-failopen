        when(mockNode.getId()).thenReturn("node1");
        });
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
import java.util.Arrays;
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
import static org.mockito.Mockito.when;
        StringBuilder largeNodeList = new StringBuilder();
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
        when(mockNode.getName()).thenReturn("test-node");
import org.opensearch.test.rest.FakeRestRequest;
            assertArrayEquals("Should clean parameters", new String[] { "node1", "node2" }, pruneFileCacheRequest.nodesIds());
    }
            .withParams(params)
            .withPath("/_filecache/prune")
        verifyingClient.setExecuteVerifier((actionType, request) -> {
            .withPath("/_filecache/prune")
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
        when(mockNode.getHostAddress()).thenReturn("127.0.0.1");
import java.util.HashMap;
     * Tests single node parameter handling.
    public void testEnhancedParameterHandling() throws Exception {
            .withParams(params)
            .withParams(params)
        verifyingClient.setExecuteVerifier((actionType, request) -> {
        // Test large node list
 * compatible open source license.
    /**
    public void testPrepareRequestDefaults() throws Exception {
        params.put("node", "node3");
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
import org.junit.Before;
        dispatchRequest(request);
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheRequest;
    public void testCanTripCircuitBreaker() {
 */
        dispatchRequest(request);
        Map<String, String> params = new HashMap<>();
    private RestPruneCacheAction action;
     * Tests comprehensive parameter combinations.
import static org.mockito.Mockito.mock;
     */
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheAction;
            return createMockMultiNodeResponse();
        controller().registerHandler(action);
public class RestPruneCacheActionTests extends RestActionTestCase {
import org.opensearch.test.rest.RestActionTestCase;
            assertArrayEquals("Single node should be targeted", new String[] { "node1" }, pruneFileCacheRequest.nodesIds());
    public void testComprehensiveParameterCombinations() throws Exception {
    }
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
            );
    /**
import java.util.List;
        params.put("nodes", "warm:true");
        });
        when(mockNode.getHostName()).thenReturn("localhost");
     * Tests enhanced parameter handling.
    /**
        Map<String, String> params = new HashMap<>();
     */
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
    }
     * Verifies that the action has the correct registered name.
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
            .build();
        return new PruneFileCacheResponse(new ClusterName("test-cluster"), nodeResponses, Collections.emptyList());
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
     */
 * Covers route registration, parameter parsing, and multi-node response handling.
    /**
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
        });
        // Test empty parameters
    /**
        verifyingClient.setExecuteVerifier((actionType, request) -> {
    }
            .build();
    private PruneFileCacheResponse createMockMultiNodeResponse() {
            assertArrayEquals("Should target warm nodes", new String[] { "warm:true" }, pruneFileCacheRequest.nodesIds());
            assertEquals("Timeout should be set", 30000, pruneFileCacheRequest.timeout().getMillis());
    public void testGetName() {
    /**
            return createMockMultiNodeResponse();
        params.put("timeout", "5m");
        });
        params.put("nodes", "warm-node-1,warm-node-2");
        }
}
        when(mockNode.getAddress()).thenReturn(buildNewFakeTransportAddress());
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
     * Tests empty parameter handling edge cases.
     */
    /**
        verifyingClient.setExecuteVerifier((actionType, request) -> {
            .withPath("/_filecache/prune")
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
     * Tests warm node targeting syntax.
            .withParams(params)
        assertEquals("/_filecache/prune", action.routes().get(0).getPath());
        verifyingClient.setExecuteVerifier((actionType, request) -> {
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
    }
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
        verifyingClient.setExecuteVerifier((actionType, request) -> {
        verifyingClient.setExecuteVerifier((actionType, request) -> {
            .withParams(params)
        dispatchRequest(request);
    }
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
     */
            return createMockMultiNodeResponse();
        List<NodePruneFileCacheResponse> nodeResponses = Arrays.asList(new NodePruneFileCacheResponse(mockNode, 1024L, 10737418240L));
    @Before
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
        params.put("nodes", largeNodeList.toString());
        DiscoveryNode mockNode = mock(DiscoveryNode.class);
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
    }
     */
            .withPath("/_filecache/prune")
        assertFalse("Prune cache action should not trip circuit breaker", action.canTripCircuitBreaker());
import java.util.Collections;
            return createMockMultiNodeResponse();
        verifyingClient.setExecuteVerifier((actionType, request) -> {
        params.put("timeout", "30s");
 * The OpenSearch Contributors require contributions made to
        assertEquals("prune_filecache_action", action.getName());
        assertEquals(RestRequest.Method.POST, action.routes().get(0).getMethod());
     * Tests that the action correctly reports it cannot trip circuit breaker.
import static org.hamcrest.Matchers.instanceOf;
        });
            if (i > 0) largeNodeList.append(",");
        dispatchRequest(request);
            .withPath("/_filecache/prune")
        params.put("nodes", "");
        });
            .withPath("/_filecache/prune")
            assertArrayEquals("Nodes parameter should take priority", new String[] { "node1", "node2" }, pruneFileCacheRequest.nodesIds());
    /**
    public void testSingleNodeParameter() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            .build();
    }
            return createMockMultiNodeResponse();
        dispatchRequest(request);
    }
     */
            .build();
    }
     */
     * Tests large node list parameter handling.
    /**
            .withParams(params)
        verifyingClient.setExecuteVerifier((actionType, request) -> {
package org.opensearch.rest.action.admin.cluster;
            assertArrayEquals("Node targeting should work", new String[] { "node1", "node2" }, pruneFileCacheRequest.nodesIds());
            // Should clean whitespace and filter empty strings
        Map<String, String> params = new HashMap<>();
            .withPath("/_filecache/prune")
/**
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
        Map<String, String> params = new HashMap<>();
     * Tests basic request preparation without parameters (all defaults).
        Map<String, String> params = new HashMap<>();
 */
        params.put("nodes", "node1,node2");
        assertEquals(1, action.routes().size());
        params.put("nodes", " node1 ,  node2  , ,   ");
    public void setUpAction() {
        for (int i = 0; i < 10; i++) {
/*
            assertEquals("Should handle large node list", 10, pruneFileCacheRequest.nodesIds().length);
        params.put("nodes", "node1,node2");
            .build();
                new String[] { "warm-node-1", "warm-node-2" },
     * Tests parameter cleaning and validation.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.rest.RestRequest;
            largeNodeList.append("node").append(i);
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
            assertNull("Default should target all nodes", pruneFileCacheRequest.nodesIds());
     */
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
        action = new RestPruneCacheAction();
            .build();
        dispatchRequest(request);
        Map<String, String> params = new HashMap<>();
            return createMockMultiNodeResponse();
            .build();
    public void testRoutes() {
    /**
     */
        });
            assertNull("Empty nodes parameter should result in null", pruneFileCacheRequest.nodesIds());
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
import org.opensearch.cluster.node.DiscoveryNode;
            return createMockMultiNodeResponse();
            .withParams(params)
import java.util.Map;
            assertArrayEquals(
    }
 * Tests for the enhanced {@link RestPruneCacheAction} class.
    public void testLargeNodeListHandling() throws Exception {
            .build();
     * Tests nodes parameter takes priority over node parameter.
     */
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
import org.opensearch.action.admin.cluster.filecache.NodePruneFileCacheResponse;
        params.put("node", "node1");
        dispatchRequest(request);
            assertThat(request, instanceOf(PruneFileCacheRequest.class));
    public void testWarmNodeTargetingSyntax() throws Exception {
        params.put("node", "");
            .withPath("/_filecache/prune")
        dispatchRequest(request);
    public void testParameterCleaning() throws Exception {
    public void testParameterPriority() throws Exception {
        Map<String, String> params = new HashMap<>();
        });
    /**
        });
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
        Map<String, String> params = new HashMap<>();
import org.opensearch.action.admin.cluster.filecache.PruneFileCacheResponse;
import org.opensearch.cluster.ClusterName;
    public void testEmptyParameterHandling() throws Exception {
            PruneFileCacheRequest pruneFileCacheRequest = (PruneFileCacheRequest) request;
    }
    }
            .build();
            .withPath("/_filecache/prune")
                pruneFileCacheRequest.nodesIds()
            return createMockMultiNodeResponse();
                "Node targeting should work",
            return createMockMultiNodeResponse();
            assertEquals(PruneFileCacheAction.INSTANCE, actionType);
            .withParams(params)
        RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withMethod(RestRequest.Method.POST)
        dispatchRequest(request);
    }
 *
