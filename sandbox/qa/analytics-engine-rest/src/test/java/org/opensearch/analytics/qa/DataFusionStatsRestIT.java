            String nodeId = nodeIds.next();
import org.opensearch.test.rest.OpenSearchRestTestCase;
    }
            }
 * {@code /_plugins/_analytics_backend_datafusion/stats}.
                    nodeEntry.has(section)  
                        nodeEntry.has(section)
    private static final ObjectMapper MAPPER = new ObjectMapper();
                if (!section.equals("io_runtime")) {
        assertTrue("_nodes.total must be > 0", nodesHeader.get("total").asInt() > 0);
        Response response = client().performRequest(new Request("GET", LOCAL_STATS_ENDPOINT));
     */  
        while (nodeIds.hasNext()) {
import com.fasterxml.jackson.databind.JsonNode;
        JsonNode root = parseResponse(response);
    public void testSpillSectionPresentInEveryNodeAndShowsDisabledState() throws Exception {  
        // Default test cluster runs 2 nodes; this IT enforces that the fan-out actually
        );
            assertTrue("node " + id + " missing 'disk_spill' section", nodeEntry.has("disk_spill"));
                if (!section.equals("io_runtime") && !section.equals("fragment_executor_gate")) {
            "error message must contain 'Invalid stat sections', got: " + responseBody,
        assertTrue("expected multi-node cluster (>=2 nodes)", nodeCount >= 2);  
import org.apache.hc.core5.http.io.entity.EntityUtils;
     */
        JsonNode nodes = root.get("nodes");
        assertTrue("response must contain 'cluster_name'", root.has("cluster_name"));  
 * <p>Verifies node targeting, stat filtering, HTTP error codes, IP leakage
        String nodeId = nodeIds.next();
        JsonNode nodesHeader = root.get("_nodes");
        // Verify nodes map and stat sections
        int successful = root.get("_nodes").get("successful").asInt();  
    /**  
    }  
 *
        int nodeCount = root.get("nodes").size();
            verified++;  
    public void testSingleStatFilter() throws Exception {
        assertEquals("nodes.{} count should match _nodes.successful", successful, nodeCount);
     * GET /_plugins/_analytics_backend_datafusion/stats
        }  
    /**
                        "filtered response must NOT contain '" + section + "'",  
        "disk_spill"
                if (!other.equals("disk_spill")) {  
            assertEquals("expected disabled-state zero disk_used_bytes",      0L, spill.get("disk_used_bytes").asLong());
        int verified = 0;  
    /**
     * Verify HTTP 200, verify _nodes, cluster_name, nodes keys exist,
        Iterator<String> nodeIds = nodesMap.fieldNames();  
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());  
        Iterator<String> nodeIds = nodesMap.fieldNames();
     */  
package org.opensearch.analytics.qa;
        assertTrue("nodes must not be empty", nodesMap.size() > 0);
    // ── Test methods ────────────────────────────────────────────────────────  
        JsonNode nodesMap = root.get("nodes");  
 */
        }
        JsonNode root = parseResponse(response);
                        nodeEntry.has(section)
        "io_runtime",
    }  
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());  
    /**
        }
     * GET /_plugins/_analytics_backend_datafusion/stats/io_runtime
        assertTrue("expected to verify at least one node", verified > 0);
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/io_runtime"));
        JsonNode root = parseResponse(response);
    public void testInvalidStatReturns400() throws Exception {  
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/disk_spill"));  
     * Verify node entries do NOT contain 'name', 'host', 'transport_address'.
    /**
    private static final String LOCAL_STATS_ENDPOINT = "/_plugins/_analytics_backend_datafusion/_local/stats";
     * `?stat=io_runtime` does NOT include the disk_spill section.
        assertEquals(200, response.getStatusLine().getStatusCode());
            assertEquals("expected disabled-state zero disk_available_bytes", 0L, spill.get("disk_available_bytes").asLong());  
    /**  
            JsonNode nodeEntry = nodes.get(id);  
     */  
            JsonNode nodeEntry = nodesMap.get(nodeId);  
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT));
                    );
        while (nodeIds.hasNext()) {
public class DataFusionStatsRestIT extends OpenSearchRestTestCase {  
        assertTrue(  
    }  
    }
                        "section '" + other + "' must NOT be present when ?stat=disk_spill",
/**
     * Spill section appears in every node's response and reflects disabled state  
        JsonNode root = parseResponse(response);
        Iterator<String> nodeIds = nodes.fieldNames();
            }  
     */  
            // Verify no other stat sections are present
    }
            String nodeId = nodeIds.next();
                }  
            assertTrue("node must contain 'io_runtime'", nodeEntry.has("io_runtime"));
        JsonNode nodeEntry = nodesMap.get(nodeId);
/*  
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/io_runtime"));
    }
        assertTrue("expected at least one node", nodes.size() > 0);  
                }
    @Override
     * Verify HTTP 200, verify single node in response.
    public void testStatFilterSpillOnlyReturnsSpillSection() throws Exception {
    public void testAllStatsFromAllNodes() throws Exception {
                    assertFalse(  
            String id = nodeIds.next();
            assertFalse("disk_spill section must NOT appear when ?stat=io_runtime", nodeEntry.has("disk_spill"));  
        assertTrue("nodes must not be empty", nodesMap.size() > 0);
                    );  
        ResponseException ex = expectThrows(
            assertEquals("expected disabled-state zero disk_total_bytes",     0L, spill.get("disk_total_bytes").asLong());
        while (nodeIds.hasNext()) {
    public void testLocalNodeStats() throws Exception {
        "stream_next",  
}  
        assertTrue("nodes must not be empty", nodesMap.size() > 0);
     * Multi-node fan-out: `_nodes.successful` must equal the number of `nodes.{}` entries
        Iterator<String> nodeIds = nodesMap.fieldNames();  
    public void testMultiNodeFanoutProducesIndependentSpillSections() throws Exception {
    }
        JsonNode nodes = parseResponse(response).get("nodes");
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT));
        JsonNode root = parseResponse(response);
            responseBody.contains("Invalid stat sections")
        // Verify _nodes header  
        JsonNode nodesMap = root.get("nodes");  
     * `?stat=disk_spill` returns only the spill section per node.  
import java.util.Set;  
    }
     * GET /_plugins/_analytics_backend_datafusion/_local/stats
     * verify all 7 stat sections in each node entry.
import org.opensearch.client.Response;  
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
        }
     */
        }
            String nodeId = nodeIds.next();
        }  
        JsonNode root = parseResponse(response);
 *
    /**
        JsonNode nodesMap = root.get("nodes");  
            JsonNode nodeEntry = nodes.get(nodeIds.next());  
                }
    protected boolean preserveClusterUponCompletion() {
        return true;  
 * REST integration tests for the DataFusion cluster stats endpoint.  
     */  
                    assertFalse(
     */  
            assertFalse("node entry must NOT contain 'name'", nodeEntry.has("name"));
        JsonNode nodes = parseResponse(response).get("nodes");  
            assertFalse("node entry must NOT contain 'transport_address'", nodeEntry.has("transport_address"));
        assertEquals("expected HTTP 400", 400, ex.getResponse().getStatusLine().getStatusCode());  
        // produced 2 entries (would silently regress to 1 if the transport action lost a hop).
        "adaptive_budget",  
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());  
            assertTrue("node must contain 'io_runtime'", nodeEntry.has("io_runtime"));
        String body = EntityUtils.toString(response.getEntity());  
     * AND each entry must have its own spill section (no cross-node leakage).  
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT));
            // Verify no other stat sections are present  
        "cpu_runtime",  
     * GET /_plugins/_analytics_backend_datafusion/stats  
            for (String section : ALL_SECTIONS) {  
     */
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());  
        "fragment_executor_gate",
                        nodeEntry.has(other)  
import com.fasterxml.jackson.databind.ObjectMapper;
     * GET /_plugins/_analytics_backend_datafusion/stats/bogus  
        String responseBody = EntityUtils.toString(ex.getResponse().getEntity());
import org.opensearch.client.Request;
        Iterator<String> nodeIds = nodes.fieldNames();  
     * Verify only io_runtime in node entries.
        assertTrue("_nodes must have 'total'", nodesHeader.has("total"));
        // Verify the single node has stats
        assertTrue("response must contain 'nodes'", root.has("nodes"));  
        assertTrue("response must contain '_nodes'", root.has("_nodes"));
    /**  
        while (nodeIds.hasNext()) {
        assertEquals("expected HTTP 200", 200, response.getStatusLine().getStatusCode());  
        while (nodeIds.hasNext()) {  
                        "filtered response must NOT contain '" + section + "'",
            assertEquals("expected disabled-state zero disk_reserved_bytes",  0L, spill.get("disk_reserved_bytes").asLong());
        assertTrue("nodes must not be empty", nodesMap.size() > 0);  
    );
            assertEquals("expected disabled-state empty directory on node " + id, "", spill.get("directory").asText());
        while (nodeIds.hasNext()) {
     * Verify only those 2 sections in node entries.
        "coordinator_reduce",
    }
     */  
    public void testStatFilterIoRuntimeExcludesSpill() throws Exception {
        "plan_setup",
            }
 * compatible open source license.
    // ── Helper methods ──────────────────────────────────────────────────────  
        "query_execution",
    public void testMultipleStatFilter() throws Exception {
        Iterator<String> nodeIds = nodesMap.fieldNames();  
            assertTrue("disk_spill must be present", nodeEntry.has("disk_spill"));
        );  
    }
     */
        assertEquals(200, response.getStatusLine().getStatusCode());
        JsonNode nodesMap = root.get("nodes");
     * (default test cluster has no datafusion.spill_directory).
                    );
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/disk_spill"));  
     * Parse an HTTP response body into a Jackson {@link JsonNode}.  
        Iterator<String> nodeIds = nodesMap.fieldNames();  
                );
        JsonNode nodesMap = root.get("nodes");
import org.opensearch.client.ResponseException;
        assertTrue("response must contain 'nodes'", root.has("nodes"));
        assertNotNull("local node entry must not be null", nodeEntry);  
                    "node '" + nodeId + "' must contain section '" + section + "'",
                assertTrue(
 */  
            () -> client().performRequest(new Request("GET", STATS_ENDPOINT + "/bogus"))  
    /**
 * SPDX-License-Identifier: Apache-2.0
            JsonNode nodeEntry = nodesMap.get(nodeId);  
    /**  
            for (String other : ALL_SECTIONS) {
 * this file be licensed under the Apache-2.0 license or a
        // Verify top-level structure
        assertEquals("_local request must return exactly 1 node", 1, nodesMap.size());  
import java.util.Iterator;
        while (nodeIds.hasNext()) {
            for (String section : ALL_SECTIONS) {
            }
        Response response = client().performRequest(new Request("GET", STATS_ENDPOINT + "/io_runtime,fragment_executor_gate"));
    private static final Set<String> ALL_SECTIONS = Set.of(
        return MAPPER.readTree(body);
                    assertFalse(
     */
     * Verify HTTP 400 status and error message contains "Invalid stat sections".
    private static final String STATS_ENDPOINT = "/_plugins/_analytics_backend_datafusion/stats";
        assertTrue("_nodes must have 'successful'", nodesHeader.has("successful"));  
    private JsonNode parseResponse(Response response) throws Exception {
     * All 7 stat sections that a full (unfiltered) response should contain.
        JsonNode root = parseResponse(response);
            JsonNode nodeEntry = nodesMap.get(nodeId);  
            JsonNode nodeEntry = nodes.get(nodeIds.next());
            for (String section : ALL_SECTIONS) {  
            String nodeId = nodeIds.next();
        assertTrue("_nodes.successful must be > 0", nodesHeader.get("successful").asInt() > 0);
     * GET /_plugins/_analytics_backend_datafusion/stats/io_runtime,fragment_executor_gate
    }
            assertTrue("node must contain 'fragment_executor_gate'", nodeEntry.has("fragment_executor_gate"));  
            JsonNode spill = nodeEntry.get("disk_spill");  
    /**
        assertEquals(200, response.getStatusLine().getStatusCode());  
    /**
        Iterator<String> nodeIds = nodes.fieldNames();
            assertFalse("node entry must NOT contain 'host'", nodeEntry.has("host"));  
    public void testNoIpLeakage() throws Exception {
            ResponseException.class,
        }
 * protection, and legacy route deprecation via REST calls against  
            JsonNode nodeEntry = nodesMap.get(nodeId);
