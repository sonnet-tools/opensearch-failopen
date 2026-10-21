 * <p>Verifies route registration, path parameter parsing ({@code nodeId} and
            "/_plugins/_analytics_backend_datafusion/stats"
            Map<String, String> params = new HashMap<>();
 * @opensearch.internal
            params.put("nodeId", "node1,node2,node3");
            params.put("nodeId", "_local");
                ActionType<Response> action,
                "/_plugins/_analytics_backend_datafusion/_local/stats"
            assertEquals(RestStatus.BAD_REQUEST, response.status());
import java.util.concurrent.atomic.AtomicReference;
/*
import org.opensearch.rest.RestHandler.Route;
            assertNotNull(capturedRequest.get());
            assertEquals(Set.of("io_runtime"), capturedRequest.get().getStatsToRetrieve());
        AtomicReference<DataFusionStatsNodesRequest> capturedRequest = new AtomicReference<>();
        try (NodeClient client = new NoOpNodeClient(getTestName())) {
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
        // Single stat
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
/**
                Request request,
    public void testSpillIsAcceptedAsValidStatName() {
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.action.ActionListener;
            Map<String, String> params = new HashMap<>();
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            RestResponse response = channel.capturedResponse();
            RestResponse response = channel.capturedResponse();
        );
import org.opensearch.core.rest.RestStatus;
    // ---- Test: mixed valid and invalid stat returns 400 for the invalid one ----
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
            assertThat(responseBody, containsString("plan_setup"));
            params.put("stat", "io_runtime,bogus_stat");
package org.opensearch.be.datafusion.action.stats;
        capturedRequest.set(null);
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
public class RestDataFusionStatsActionTests extends OpenSearchTestCase {
            action.handleRequest(request, channel, client);
                "/_plugins/_analytics_backend_datafusion/node1/stats"
            ).withParams(params).build();
    }
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_plugins/_analytics_backend_datafusion/stats")
        Set<String> expectedPaths = Set.of(
import java.util.List;
            Map<String, String> params = new HashMap<>();
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
                ActionListener<Response> listener
    public void testRoutesRegistered() {
            }
            "/_plugins/_analytics_backend_datafusion/{nodeId}/stats/{stat}",
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
    }
    private NodeClient buildCapturingClient(AtomicReference<DataFusionStatsNodesRequest> capturedRequest) {
            Map<String, String> params = new HashMap<>();
        List<Route> routes = action.routes();
            assertArrayEquals(new String[] { "_local" }, capturedRequest.get().nodesIds());
        // Multiple comma-separated stats
    }
        }
    }
            ) {
}
        capturedRequest.set(null);
        }
import org.opensearch.rest.RestRequest;
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
            action.handleRequest(request, channel, client);
    }
                // Don't call listener - we just want to capture the request
            assertThat(responseBody, containsString("io_runtime"));
        action = new RestDataFusionStatsAction();
    public void testNodeIdParsing() throws Exception {
            assertEquals(GET, route.getMethod());
        }
            params.put("stat", "io_runtime,cpu_runtime,fragment_executor_gate");
import org.opensearch.action.ActionType;
    // ---- Helper: build a NodeClient that captures the DataFusionStatsNodesRequest ----
            action.handleRequest(request, channel, client);
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
    private RestDataFusionStatsAction action;
    public void testNoNodeIdDefaultsToAllNodes() throws Exception {
    // ---- Test: handler name ----
 *
            String responseBody = response.content().utf8ToString();
        // _local special value
import static org.hamcrest.Matchers.containsString;
            // Single node ID
                "/_plugins/_analytics_backend_datafusion/stats/invalid_stat_name"
            action.handleRequest(request, channel, client);
            params.put("stat", "invalid_stat_name");
            @Override
            assertNotNull(capturedRequest.get());
        super.setUp();
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            assertNotNull("Request should have been captured", capturedRequest.get());
 * Unit tests for {@link RestDataFusionStatsAction}.
        }
            assertNotNull(capturedRequest.get());
    }
    }
            assertNotNull("Request should have been captured", capturedRequest.get());
    // ---- Test: invalid stat name returns HTTP 400 ----
            action.handleRequest(request, channel, client);
    // ---- Test: no stat defaults to all stats (empty set) ----
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
                "/_plugins/_analytics_backend_datafusion/stats/io_runtime,bogus_stat"
            assertThat(responseBody, containsString("bogus_stat"));
        for (Route route : routes) {
import java.util.stream.Collectors;
            assertArrayEquals(new String[] { "node1" }, capturedRequest.get().nodesIds());
                    capturedRequest.set((DataFusionStatsNodesRequest) request);
        assertTrue(
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
    public void testMixedValidAndInvalidStatReturns400() throws Exception {
        try (NodeClient client = new NoOpNodeClient(getTestName())) {
import org.opensearch.test.client.NoOpNodeClient;
            params.put("nodeId", "node1");
            FakeRestChannel channel = new FakeRestChannel(request, true, 1);
import org.opensearch.transport.client.node.NodeClient;
            Map<String, String> params = new HashMap<>();
import org.opensearch.test.rest.FakeRestRequest;
            assertThat(responseBody, containsString("coordinator_reduce"));
        }
    // ---- Test: no nodeId defaults to all nodes (empty array) ----
            assertThat(responseBody, containsString("stream_next"));
            assertEquals(Set.of("io_runtime", "cpu_runtime", "fragment_executor_gate"), capturedRequest.get().getStatsToRetrieve());
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
 *
    }
            assertArrayEquals(new String[] { "node1", "node2", "node3" }, capturedRequest.get().nodesIds());
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            assertThat(responseBody, containsString("cpu_runtime"));
import java.util.Set;
            assertThat(responseBody, containsString("Invalid stat sections"));
import org.opensearch.rest.RestResponse;
            Map<String, String> params = new HashMap<>();
import org.opensearch.core.action.ActionResponse;
        }
            assertThat(responseBody, containsString("Invalid stat sections"));
import org.opensearch.action.ActionRequest;
            action.handleRequest(request, channel, client);
        }
            ).withParams(params).build();
        }
 * SPDX-License-Identifier: Apache-2.0
            "VALID_STATS should include 'disk_spill' but was: " + RestDataFusionStatsAction.VALID_STATS,
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
            assertNotNull(capturedRequest.get());
import java.util.Map;
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath("/_plugins/_analytics_backend_datafusion/stats")
            action.handleRequest(request, channel, client);
        return new NoOpNodeClient(getTestName()) {
        }
            FakeRestChannel channel = new FakeRestChannel(request, true, 1);
        // The REST handler exposes VALID_STATS for error messages; assert "disk_spill" is now in it.
 */
            assertTrue("Empty statsToRetrieve means all stats", capturedRequest.get().getStatsToRetrieve().isEmpty());
    }
    }
            Map<String, String> params = new HashMap<>();
            assertEquals("Empty nodeIds means all nodes", 0, capturedRequest.get().nodesIds().length);
 * The OpenSearch Contributors require contributions made to
            assertNotNull("Expected a response to be sent", response);
        // All routes should be GET
                "/_plugins/_analytics_backend_datafusion/stats/io_runtime,cpu_runtime,fragment_executor_gate"
            "/_plugins/_analytics_backend_datafusion/stats/{stat}",
 * {@code stat}), and HTTP 400 for invalid stat names.
            ).withParams(params).build();
            Map<String, String> params = new HashMap<>();
    // ---- Test: stat path parameter parsing ----
 */
 * this file be licensed under the Apache-2.0 license or a
            params.put("stat", "io_runtime");
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
            RestRequest request = new FakeRestRequest.Builder(xContentRegistry()).withPath(
import java.util.HashMap;
            action.handleRequest(request, channel, client);
    public void setUp() throws Exception {
            Map<String, String> params = new HashMap<>();
            assertThat(responseBody, containsString("invalid_stat_name"));
                .withParams(params)
        AtomicReference<DataFusionStatsNodesRequest> capturedRequest = new AtomicReference<>();
            ).withParams(params).build();
            assertThat(responseBody, containsString("query_execution"));
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
import org.opensearch.test.rest.FakeRestChannel;
        };
    public void testGetName() {
            public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
 * compatible open source license.
    // ---- Test: 4 canonical routes registered with correct paths and methods ----
 *
        assertEquals("datafusion_stats_action", action.getName());
                if (request instanceof DataFusionStatsNodesRequest) {
            assertNotNull(capturedRequest.get());
    @SuppressWarnings("unchecked")
        }
                .withParams(params)
                "/_plugins/_analytics_backend_datafusion/node1,node2,node3/stats"
    public void testInvalidStatReturns400() throws Exception {
                .build();
        capturedRequest.set(null);
            "/_plugins/_analytics_backend_datafusion/{nodeId}/stats",
            ).withParams(params).build();
            assertThat(responseBody, containsString("fragment_executor_gate"));
    public void testNoStatDefaultsToAllStats() throws Exception {
            action.handleRequest(request, channel, client);
    // ---- Test: nodeId path parameter parsing ----
                .build();
            ).withParams(params).build();
        assertEquals("Expected 4 canonical routes", 4, routes.size());
        AtomicReference<DataFusionStatsNodesRequest> capturedRequest = new AtomicReference<>();
            assertEquals(RestStatus.BAD_REQUEST, response.status());
    }
            FakeRestChannel channel = new FakeRestChannel(request, false, 1);
            RestDataFusionStatsAction.VALID_STATS.contains("disk_spill")
import static org.opensearch.rest.RestRequest.Method.GET;
                "/_plugins/_analytics_backend_datafusion/stats/io_runtime"
        assertEquals(expectedPaths, actualPaths);
        try (NodeClient client = buildCapturingClient(capturedRequest)) {
            assertNotNull("Expected a response to be sent", response);
        // Multiple comma-separated node IDs
                }
        );
    @Override
            String responseBody = response.content().utf8ToString();
            ).withParams(params).build();
        AtomicReference<DataFusionStatsNodesRequest> capturedRequest = new AtomicReference<>();
        Set<String> actualPaths = routes.stream().map(Route::getPath).collect(Collectors.toSet());
    public void testStatParsing() throws Exception {
