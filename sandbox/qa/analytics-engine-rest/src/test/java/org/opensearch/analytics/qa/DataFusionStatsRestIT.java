        JsonNode root = parseResponse(response);
/**
        int verified = 0;
     * Verify only those 2 sections in node entries.
        "io_runtime",
    public void testStatFilterSpillOnlyReturnsSpillSection() throws Exception {
        JsonNode nodesMap = root.get("nodes");
        JsonNode nodesMap = root.get("nodes");
    public void testNoIpLeakage() throws Exception {
import org.apache.hc.core5.http.io.entity.EntityUtils;
     * Spill section appears in every node's response and reflects disabled state
     * AND each entry must have its own spill section (no cross-node leakage).
    private static final ObjectMapper MAPPER = new ObjectMapper();
            // Verify no other stat sections are present
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());
        assertTrue("_nodes.total must be > 0", nodesHeader.get("total").asInt() > 0);
        while (nodeIds.hasNext()) {
 * this file be licensed under the Apache-2.0 license or a
     */
            () -> client().performRequest(new Request("GET", STATS_ENDPOINT + "/bogus"))
        // Verify the single node has stats
        }
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/disk_spill"));
        // Default test cluster runs 2 nodes; this IT enforces that the fan-out actually
        assertTrue("nodes must not be empty", nodesMap.size() > 0);
     */
     * Verify only io_runtime in node entries.
        assertTrue("response must contain 'cluster_name'", root.has("cluster_name"));
        Iterator<String> nodeIds = nodesMap.fieldNames();
/*
                    );
            JsonNode spill = nodeEntry.get("disk_spill");
    public void testStatFilterIoRuntimeExcludesSpill() throws Exception {
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT));
     */
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());
                    nodeEntry.has(section)
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT));
            String nodeId = nodeIds.next();
    }
        JsonNode nodesMap = root.get("nodes");
            "error message must contain 'Invalid stat sections', got: " + responseBody,
            String nodeId = nodeIds.next();
            String id = nodeIds.next();
                    );
                        nodeEntry.has(section)
import org.opensearch.client.ResponseException;
 * The OpenSearch Contributors require contributions made to
     */
    /**
                    assertFalse(
                if (!section.equals("io_runtime")) {
                );
            assertFalse("node entry must NOT contain 'name'", nodeEntry.has("name"));
        assertNotNull("local node entry must not be null", nodeEntry);
     * `?stat=io_runtime` does NOT include the disk_spill section.
            JsonNode nodeEntry = nodesMap.get(nodeId);
        "query_execution",
        String nodeId = nodeIds.next();
        return MAPPER.readTree(body);
                if (!section.equals("io_runtime") && !section.equals("fragment_executor_gate")) {
     */
     * Verify HTTP 400 status and error message contains "Invalid stat sections".
    /**
                    );
        "cpu_runtime",
            String nodeId = nodeIds.next();
        assertEquals(200, response.getStatusLine().getStatusCode());
        assertTrue("response must contain '_nodes'", root.has("_nodes"));
            }
                }
     */
            verified++;
import java.util.Iterator;
            assertTrue("node must contain 'fragment_executor_gate'", nodeEntry.has("fragment_executor_gate"));
     */
            assertEquals("expected disabled-state empty directory on node " + id, "", spill.get("directory").asText());
    private JsonNode parseResponse(Response response) throws Exception {
    }
import org.opensearch.client.Request;
        Iterator<String> nodeIds = nodesMap.fieldNames();
        }
            assertTrue("node " + id + " missing 'disk_spill' section", nodeEntry.has("disk_spill"));
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());
    /**
        while (nodeIds.hasNext()) {
        Iterator<String> nodeIds = nodes.fieldNames();
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT));
        assertTrue("nodes must not be empty", nodesMap.size() > 0);
        String body = EntityUtils.toString(response.getEntity());
 *
    }
    private static final String LOCAL_STATS_ENDPOINT = "/_plugins/_analytics_backend_datafusion/_local/stats";
     * (default test cluster has no datafusion.spill_directory).
     * verify all 7 stat sections in each node entry.
        ResponseException ex = expectThrows(
        JsonNode root = parseResponse(response);
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());
     */
            JsonNode nodeEntry = nodesMap.get(nodeId);
     * GET /_plugins/_analytics_backend_datafusion/stats/io_runtime,fragment_executor_gate
                }
        assertTrue("response must contain 'nodes'", root.has("nodes"));
        JsonNode nodeEntry = nodesMap.get(nodeId);
    }
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/io_runtime"));
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/io_runtime"));
        while (nodeIds.hasNext()) {
    private static final String STATS_ENDPOINT = "/_plugins/_analytics_backend_datafusion/stats";
        "fragment_executor_gate",
        Iterator<String> nodeIds = nodesMap.fieldNames();
        );
    /**
 * protection, and legacy route deprecation via REST calls against
 * {@code /_plugins/_analytics_backend_datafusion/stats}.
        while (nodeIds.hasNext()) {
            assertTrue("node must contain 'io_runtime'", nodeEntry.has("io_runtime"));
    }
        assertTrue("_nodes must have 'total'", nodesHeader.has("total"));
 * compatible open source license.
            JsonNode nodeEntry = nodesMap.get(nodeId);
        int successful = root.get("_nodes").get("successful").asInt();
    public void testSingleStatFilter() throws Exception {
     */
        assertTrue("nodes must not be empty", nodesMap.size() > 0);
    /**
            JsonNode nodeEntry = nodes.get(nodeIds.next());
        assertTrue("_nodes.successful must be > 0", nodesHeader.get("successful").asInt() > 0);
    public void testSpillSectionPresentInEveryNodeAndShowsDisabledState() throws Exception {
                        "filtered response must NOT contain '" + section + "'",
            assertEquals("expected disabled-state zero disk_reserved_bytes",  0L, spill.get("disk_reserved_bytes").asLong());
            for (String section : ALL_SECTIONS) {
            for (String section : ALL_SECTIONS) {
        assertTrue("expected at least one node", nodes.size() > 0);
        assertEquals("_local request must return exactly 1 node", 1, nodesMap.size());
            }
import java.io.IOException;
            String nodeId = nodeIds.next();
 */
    protected boolean preserveClusterUponCompletion() {
        while (nodeIds.hasNext()) {
        assertEquals("nodes.{} count should match _nodes.successful", successful, nodeCount);
        while (nodeIds.hasNext()) {
    }
        Iterator<String> nodeIds = nodesMap.fieldNames();
    /**
        return true;
 * <p>Verifies node targeting, stat filtering, HTTP error codes, IP leakage
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/disk_spill"));
        "adaptive_budget",
     * GET /_plugins/_analytics_backend_datafusion/stats
     */
            JsonNode nodeEntry = nodesMap.get(nodeId);
                }
        assertTrue("expected to verify at least one node", verified > 0);
 *
            assertTrue("node must contain 'io_runtime'", nodeEntry.has("io_runtime"));
        Iterator<String> nodeIds = nodes.fieldNames();
        }
     */
                    "node '" + nodeId + "' must contain section '" + section + "'",
        Iterator<String> nodeIds = nodes.fieldNames();
        int nodeCount = root.get("nodes").size();
    }
    /**
        JsonNode nodesMap = root.get("nodes");
            assertFalse("node entry must NOT contain 'transport_address'", nodeEntry.has("transport_address"));
     * GET /_plugins/_analytics_backend_datafusion/stats
            assertFalse("node entry must NOT contain 'host'", nodeEntry.has("host"));
        }
    public void testMultiNodeFanoutProducesIndependentSpillSections() throws Exception {
            responseBody.contains("Invalid stat sections")
            assertFalse("disk_spill section must NOT appear when ?stat=io_runtime", nodeEntry.has("disk_spill"));
        JsonNode root = parseResponse(response);
        "plan_setup",
    public void testAllStatsFromAllNodes() throws Exception {
public class DataFusionStatsRestIT extends OpenSearchRestTestCase {
            ResponseException.class,
        assertEquals(200, response.getStatusLine().getStatusCode());
     * Verify HTTP 200, verify single node in response.
            }
    /**
     * GET /_plugins/_analytics_backend_datafusion/stats/io_runtime
}
    /**
    /**
        Iterator<String> nodeIds = nodesMap.fieldNames();
            for (String other : ALL_SECTIONS) {
    // ── Helper methods ──────────────────────────────────────────────────────
    /**
    @Override
        JsonNode nodesMap = root.get("nodes");
            // Verify no other stat sections are present
            for (String section : ALL_SECTIONS) {
        // Verify nodes map and stat sections
 * SPDX-License-Identifier: Apache-2.0
        "coordinator_reduce",
            assertEquals("expected disabled-state zero disk_total_bytes",     0L, spill.get("disk_total_bytes").asLong());
            }
        assertEquals("expected HTTP 400", 400, ex.getResponse().getStatusLine().getStatusCode());
import org.opensearch.test.rest.OpenSearchRestTestCase;
     * GET /_plugins/_analytics_backend_datafusion/stats/bogus
        assertTrue(
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());
                    assertFalse(
        while (nodeIds.hasNext()) {
     * GET /_plugins/_analytics_backend_datafusion/_local/stats
        JsonNode root = parseResponse(response);
import org.opensearch.client.Response;
    /**
        Response response = client().performRequest(new Request("GET", LOCAL_STATS_ENDPOINT));
        "disk_spill"
    );
        JsonNode root = parseResponse(response);
import com.fasterxml.jackson.databind.JsonNode;
        JsonNode root = parseResponse(response);
            assertTrue("disk_spill must be present", nodeEntry.has("disk_spill"));
    }
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/io_runtime,fragment_executor_gate"));
     * Verify HTTP 200, verify _nodes, cluster_name, nodes keys exist,
        JsonNode nodesHeader = root.get("_nodes");
        // Verify top-level structure
     * Multi-node fan-out: `_nodes.successful` must equal the number of `nodes.{}` entries
            assertEquals("expected disabled-state zero disk_used_bytes",      0L, spill.get("disk_used_bytes").asLong());
    public void testLocalNodeStats() throws Exception {
        JsonNode root = parseResponse(response);
        assertTrue("nodes must not be empty", nodesMap.size() > 0);
 */
        assertTrue("response must contain 'nodes'", root.has("nodes"));
    }
    public void testInvalidStatReturns400() throws Exception {
            assertEquals("expected disabled-state zero disk_available_bytes", 0L, spill.get("disk_available_bytes").asLong());
        );
    private static final Set<String> ALL_SECTIONS = Set.of(
package org.opensearch.analytics.qa;
        "stream_next",
        assertTrue("expected multi-node cluster (>=2 nodes)", nodeCount >= 2);
        }
 * REST integration tests for the DataFusion cluster stats endpoint.
        JsonNode nodes = parseResponse(response).get("nodes");
                        nodeEntry.has(section)
        JsonNode nodes = parseResponse(response).get("nodes");
        // produced 2 entries (would silently regress to 1 if the transport action lost a hop).
    public void testMultipleStatFilter() throws Exception {
        String responseBody = EntityUtils.toString(ex.getResponse().getEntity());
        }
        // Verify _nodes header
                    assertFalse(
    }
                if (!other.equals("disk_spill")) {
            JsonNode nodeEntry = nodes.get(id);
     * `?stat=disk_spill` returns only the spill section per node.
    }
                assertTrue(
                        nodeEntry.has(other)
     * All 7 stat sections that a full (unfiltered) response should contain.
import com.fasterxml.jackson.databind.ObjectMapper;
        JsonNode nodes = root.get("nodes");
                        "filtered response must NOT contain '" + section + "'",
    // ── Test methods ────────────────────────────────────────────────────────
    }
     * Parse an HTTP response body into a Jackson {@link JsonNode}.
            JsonNode nodeEntry = nodes.get(nodeIds.next());
        assertEquals(200, response.getStatusLine().getStatusCode());
import java.util.Set;
        assertTrue("_nodes must have 'successful'", nodesHeader.has("successful"));
     * Verify node entries do NOT contain 'name', 'host', 'transport_address'.
                        "section '" + other + "' must NOT be present when ?stat=disk_spill",
        }
     */
