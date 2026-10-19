            "/_plugins/_analytics_backend_datafusion/{nodeId}/stats",  
    // ---- Test: handler name ----  
/**
        // _local special value
            params.put("stat", "invalid_stat_name");
            assertEquals(Set.of("io_runtime", "cpu_runtime", "fragment_executor_gate"), capturedRequest.get().getStatsToRetrieve());
                .build();  
        try (NodeClient client = buildCapturingClient(capturedRequest)) {  
    // ---- Test: mixed valid and invalid stat returns 400 for the invalid one ----
    // ---- Test: no nodeId defaults to all nodes (empty array) ----
            ).withParams(params).build();
    // ---- Test: 4 canonical routes registered with correct paths and methods ----
                "/_plugins/_analytics_backend_datafusion/stats/io_runtime"
    public void testRoutesRegistered() {  
    // ---- Helper: build a NodeClient that captures the DataFusionStatsNodesRequest ----
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
            assertEquals(RestStatus.BAD_REQUEST, response.status());
                .build();
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(  
            assertNotNull(capturedRequest.get());
            assertThat(responseBody, containsString("query_execution"));
            action.handleRequest(request, channel, client);
            assertNotNull(capturedRequest.get());
            assertEquals(RestStatus.BAD_REQUEST, response.status());
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
        }
    // ---- Test: stat path parameter parsing ----
import java.util.Set;  
            assertTrue("Empty statsToRetrieve means all stats", capturedRequest.get().getStatsToRetrieve().isEmpty());  
            assertThat(responseBody, containsString("invalid_stat_name"));  
public class RestDataFusionStatsActionTests extends OpenSearchTestCase {  
        return new NoOpNodeClient(getTestName()) {  
        action = new RestDataFusionStatsAction();
            assertNotNull("Expected a response to be sent", response);  
        capturedRequest.set(null);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.node.NodeClient;
    public void setUp() throws Exception {
    }  
            assertNotNull("Expected a response to be sent", response);
            ).withParams(params).build();
            @Override
    public void testStatParsing() throws Exception {  
            action.handleRequest(request, channel, client);
        capturedRequest.set(null);
            RestDataFusionStatsAction.VALID_STATS.contains("disk_spill")
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
            action.handleRequest(request, channel, client);
    public void testGetName() {
            assertNotNull(capturedRequest.get());  
    private NodeClient buildCapturingClient(AtomicReference<DataFusionStatsNodesRequest> capturedRequest) {
        }
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
                "/_plugins/_analytics_backend_datafusion/stats/io_runtime,cpu_runtime,fragment_executor_gate"  
            assertNotNull("Request should have been captured", capturedRequest.get());
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);  
            "/_plugins/_analytics_backend_datafusion/{nodeId}/stats/{stat}",
    public void testNoNodeIdDefaultsToAllNodes() throws Exception {
    public void testNodeIdParsing() throws Exception {
            action.handleRequest(request, channel, client);
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
    }
import org.opensearch.test.OpenSearchTestCase;  
            assertNotNull("Request should have been captured", capturedRequest.get());
            Map<String, String> params = new HashMap<>();
        super.setUp();  
        }
    }  
 *  
        assertEquals("datafusion_stats_action", action.getName());  
    }  
            ).withParams(params).build();  
                .withParams(params)
        List<Route> routes = action.routes();
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_plugins/_analytics_backend_datafusion/stats")  
        }  
            assertNotNull(capturedRequest.get());  
        capturedRequest.set(null);  
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
 */  
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            action.handleRequest(request, channel, client);  
            ).withParams(params).build();
    }  
            assertThat(responseBody, containsString("coordinator_reduce"));  
import org.opensearch.rest.RestHandler.Route;  
        AtomicReference<DataFusionStatsNodesRequest> capturedRequest = new AtomicReference<>();
            assertArrayEquals(new String[] { "node1" }, capturedRequest.get().nodesIds());
        }
    public void testNoStatDefaultsToAllStats() throws Exception {
            assertEquals("Empty nodeIds means all nodes", 0, capturedRequest.get().nodesIds().length);
    }
import org.opensearch.rest.RestResponse;
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            action.handleRequest(request, channel, client);  
import org.opensearch.core.action.ActionResponse;
            ).withParams(params).build();
    // ---- Test: nodeId path parameter parsing ----
/*  
        }
            "/_plugins/_analytics_backend_datafusion/stats/{stat}",
            assertArrayEquals(new String[] { "_local" }, capturedRequest.get().nodesIds());  
import org.opensearch.test.client.NoOpNodeClient;
            assertThat(responseBody, containsString("stream_next"));
import java.util.Map;
import static org.opensearch.rest.RestRequest.Method.GET;
        try (NodeClient client = new NoOpNodeClient(getTestName())) {
                }  
        AtomicReference<DataFusionStatsNodesRequest> capturedRequest = new AtomicReference<>();
        }  
                "/_plugins/_analytics_backend_datafusion/node1,node2,node3/stats"
            assertThat(responseBody, containsString("fragment_executor_gate"));
    public void testSpillIsAcceptedAsValidStatName() {  
            ).withParams(params).build();  
        assertTrue(
            Map<String, String> params = new HashMap<>();  
                    capturedRequest.set((DataFusionStatsNodesRequest) request);
    public void testInvalidStatReturns400() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            params.put("nodeId", "node1");
import java.util.stream.Collectors;
 * {@code stat}), and HTTP 400 for invalid stat names.
        );
    // ---- Test: invalid stat name returns HTTP 400 ----
import java.util.List;
        }
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
                ActionType<Response> action,  
            assertThat(responseBody, containsString("bogus_stat"));
    }
                ActionListener<Response> listener
            assertThat(responseBody, containsString("cpu_runtime"));
            params.put("nodeId", "node1,node2,node3");
        try (NodeClient client = new NoOpNodeClient(getTestName())) {
            action.handleRequest(request, channel, client);  
        Set<String> expectedPaths = Set.of(
            "/_plugins/_analytics_backend_datafusion/stats"
            FakeRestChannel channel = new FakeRestChannel(request, true, 1);  
    // ---- Test: no stat defaults to all stats (empty set) ----  
            params.put("stat", "io_runtime");  
                "/_plugins/_analytics_backend_datafusion/node1/stats"  
package org.opensearch.be.datafusion.action.stats;
            assertEquals(Set.of("io_runtime"), capturedRequest.get().getStatsToRetrieve());  
            public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
            String responseBody = response.content().utf8ToString();
            ).withParams(params).build();  
            params.put("stat", "io_runtime,cpu_runtime,fragment_executor_gate");
            Map<String, String> params = new HashMap<>();  
            assertEquals(GET, route.getMethod());
            assertArrayEquals(new String[] { "node1", "node2", "node3" }, capturedRequest.get().nodesIds());
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
 *
import org.opensearch.action.ActionType;
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
            assertThat(responseBody, containsString("io_runtime"));
            Map<String, String> params = new HashMap<>();
            action.handleRequest(request, channel, client);
 * compatible open source license.
        // Multiple comma-separated node IDs
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_plugins/_analytics_backend_datafusion/stats")
            params.put("nodeId", "_local");  
            assertNotNull(capturedRequest.get());
import org.opensearch.core.rest.RestStatus;
import org.opensearch.action.ActionRequest;
        Set<String> actualPaths = routes.stream().map(Route::getPath).collect(Collectors.toSet());
            RestResponse response = channel.capturedResponse();
    }
                .withParams(params)
        assertEquals("Expected 4 canonical routes", 4, routes.size());
    @SuppressWarnings("unchecked")
    public void testMixedValidAndInvalidStatReturns400() throws Exception {  
            String responseBody = response.content().utf8ToString();  
            assertThat(responseBody, containsString("Invalid stat sections"));
            assertThat(responseBody, containsString("plan_setup"));  
        }
        // Single stat  
                Request request,
            Map<String, String> params = new HashMap<>();  
            "VALID_STATS should include 'disk_spill' but was: " + RestDataFusionStatsAction.VALID_STATS,  
    }
    }
import org.opensearch.test.rest.FakeRestChannel;
            // Single node ID
            params.put("stat", "io_runtime,bogus_stat");  
 */
    @Override
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
 * Unit tests for {@link RestDataFusionStatsAction}.
    private RestDataFusionStatsAction action;
            assertThat(responseBody, containsString("Invalid stat sections"));
                "/_plugins/_analytics_backend_datafusion/stats/invalid_stat_name"  
            ) {  
        // Multiple comma-separated stats  
        for (Route route : routes) {  
import org.opensearch.rest.RestRequest;
        );  
            RestResponse response = channel.capturedResponse();  
 * this file be licensed under the Apache-2.0 license or a
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            Map<String, String> params = new HashMap<>();  
import java.util.HashMap;  
            Map<String, String> params = new HashMap<>();
        // The REST handler exposes VALID_STATS for error messages; assert "disk_spill" is now in it.
                "/_plugins/_analytics_backend_datafusion/stats/io_runtime,bogus_stat"
import static org.hamcrest.Matchers.containsString;
        };  
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
                if (request instanceof DataFusionStatsNodesRequest) {
    }
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
        assertEquals(expectedPaths, actualPaths);  
 * @opensearch.internal
import org.opensearch.test.rest.FakeRestRequest;  
import java.util.concurrent.atomic.AtomicReference;
        }  
        // All routes should be GET
            }
                "/_plugins/_analytics_backend_datafusion/_local/stats"
}
            Map<String, String> params = new HashMap<>();
            action.handleRequest(request, channel, client);  
                // Don't call listener - we just want to capture the request
            Map<String, String> params = new HashMap<>();
        AtomicReference<DataFusionStatsNodesRequest> capturedRequest = new AtomicReference<>();
 *  
        AtomicReference<DataFusionStatsNodesRequest> capturedRequest = new AtomicReference<>();  
 * <p>Verifies route registration, path parameter parsing ({@code nodeId} and
            FakeRestChannel channel = new FakeRestChannel(request, true, 1);
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);  
import org.opensearch.core.action.ActionListener;  
