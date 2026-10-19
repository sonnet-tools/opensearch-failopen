        Map<String, Object> nodesHeader = (Map<String, Object>) body.get("_nodes");  
 * The OpenSearch Contributors require contributions made to  
            executePpl("source=" + DATASET.indexName + " | where num0 > 0 | fields str0, num0");
                assertLatencyStatsShape(label + ".elapsed_ms", (Map<String, Object>) bucket.get("elapsed_ms"));
        Map<String, Object> scopedNodes = (Map<String, Object>) body.get("nodes");
            Map<String, Object> queries = (Map<String, Object>) analytics.get("queries");
                if (((Number) bucket.get("started")).longValue() > 0) {  
            if (fragTotal > 0) {  
        assertTrue("at least one node recorded a stage", sawAnyStage);  
        Response response = client().performRequest(request);  
            if (((Number) elapsed.get("count")).longValue() > 0) {  
            }  
        // At least one node must have recorded work — every query was coordinated by some
        assertTrue("at least one node recorded a fragment", sawAnyFragment);
                    nodeId + ".fragments.succeeded > 0 when total > 0, total=" + fragTotal + " succeeded=" + fragSucceeded,  
    }
            Map<String, Object> fragments = (Map<String, Object>) analytics.get("fragments");
import java.util.Map;
 *  
 * <p>The endpoint mirrors {@code _nodes/stats}'s shape:
        Map<String, Object> body = fetchStats();
        assertNotNull(nodeId + ".analytics present", ((Map<String, Object>) scopedNodes.get(nodeId)).get("analytics"));
            DatasetProvisioner.provision(client(), DATASET);
        // histograms have enough samples for percentile spread. The REST client round-robins  
 * this file be licensed under the Apache-2.0 license or a
 * PPL queries via {@code POST /_analytics/ppl} and verifies the stats endpoint  
                sawAnyFragment = true;
        for (Map.Entry<String, Object> nodeEntry : nodes.entrySet()) {
public class AnalyticsStatsApiIT extends AnalyticsRestTestCase {
            assertLatencyStatsShape(nodeId + ".queries.elapsed_ms", elapsed);
        ensureDataProvisioned();  
            Map<String, Object> stagesByType = (Map<String, Object>) analytics.get("stages_by_type");
                    sawAnyStage = true;
            assertLatencyStatsShape(nodeId + ".fragments.elapsed_ms", fragElapsed);  
                );
        ensureDataProvisioned();  
            assertNotNull(nodeId + ".analytics present", analytics);  
        }  
        // the coordinator across nodes, so different queries land on different coordinators.
 * returns a cluster-wide response with one entry per node, each carrying the
    public void testStatsEndpointReflectsExecutedQueries() throws IOException {
    @SuppressWarnings("unchecked")
                    fragSucceeded > 0
}
        // Fire a mix of query shapes so the per-stage-type buckets see varied work and the
            assertNotNull(nodeId + ".stages_by_type present", stagesByType);
    public void testStatsEndpointScopedToSingleNode() throws IOException {
        assertEquals("path scope contacts exactly one node", 1, ((Number) nodesHeader.get("total")).intValue());
            for (Map.Entry<String, Object> stageEntry : stagesByType.entrySet()) {  
import org.opensearch.client.Request;
        Map<String, Object> body = assertOkAndParse(client().performRequest(request), "STATS GET (single node)");
/**
 */  
            // queries bucket carries only the latency distributions — query counters
 * full analytics rollup.
            Map<String, Object> nodeBody = (Map<String, Object>) nodeEntry.getValue();
        }
                long fragSum = ((Number) fragElapsed.get("sum_ms")).longValue();  
            long v = ((Number) latency.get(field)).longValue();
 *   "_nodes": {...},
        assertTrue(nodeId + " is the only entry", scopedNodes.containsKey(nodeId));  
                String label = nodeId + ".stages_by_type." + stageEntry.getKey();
    private Map<String, Object> fetchStats() throws IOException {
        boolean sawAnyFragment = false;
            assertNotNull(nodeId + ".fragments present", fragments);  
        for (int i = 0; i < 30; i++) {
 * Integration test for {@code GET /_plugins/_analytics/stats}. Fires a few
        Request request = new Request("GET", "/_plugins/_analytics/" + nodeId + "/stats");  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
        return assertOkAndParse(response, "STATS GET");
        // saw the most activity.
            Map<String, Object> analytics = (Map<String, Object>) nodeBody.get("analytics");
            dataProvisioned = true;  
            assertNotNull(label + "." + field, latency.get(field));
    private static boolean dataProvisioned = false;
import java.io.IOException;
                Map<String, Object> bucket = (Map<String, Object>) stageEntry.getValue();
 * SPDX-License-Identifier: Apache-2.0
        Request request = new Request("GET", "/_plugins/_analytics/stats");
        for (String field : new String[] { "count", "sum_ms" }) {  
package org.opensearch.analytics.qa;
 *     ...
 */  
                assertNotNull(label + ".started", bucket.get("started"));  
                }
        String nodeId = nodes.keySet().iterator().next();
        assertFalse("at least one node in cluster", nodes.isEmpty());  
        }  
 * </pre>
        // Pick an arbitrary node id from a cluster-wide call, then re-query scoped to that id.
 * }
            Map<String, Object> fragElapsed = (Map<String, Object>) fragments.get("elapsed_ms");
            executePpl("source=" + DATASET.indexName + " | stats avg(num0)");
        boolean sawAnyQuery = false;
    }
    @SuppressWarnings("unchecked")
/*  
                assertTrue(
 *   "cluster_name": "...",
        assertNotNull("_nodes header present", nodesHeader);
    }
        Map<String, Object> all = fetchStats();  
            Map<String, Object> elapsed = (Map<String, Object>) queries.get("elapsed_ms");  
 *   }  
            assertLatencyStatsShape(nodeId + ".queries.planning_ms", (Map<String, Object>) queries.get("planning_ms"));
            String nodeId = nodeEntry.getKey();  
        Map<String, Object> nodes = (Map<String, Object>) all.get("nodes");
            }
        assertFalse("at least one node in response", nodes.isEmpty());  
            assertNotNull(nodeId + ".queries present", queries);
        boolean sawAnyStage = false;  
import org.opensearch.client.Response;
        // node in this cluster. Walk all nodes, validate each one's shape, and track which  
        assertNotNull("_nodes header present", nodesHeader);
 * <pre>
        Map<String, Object> nodes = (Map<String, Object>) body.get("nodes");
            assertTrue(label + "." + field + " non-negative, got " + v, v >= 0);  
            long fragTotal = ((Number) fragments.get("total")).longValue();
        Map<String, Object> nodesHeader = (Map<String, Object>) body.get("_nodes");  
        assertTrue("at least one node recorded a query", sawAnyQuery);
            assertNotNull(nodeId + ".fragments.total", fragments.get("total"));
    private void ensureDataProvisioned() throws IOException {  
        assertEquals("response carries exactly one node entry", 1, scopedNodes.size());
    }
            executePpl("source=" + DATASET.indexName + " | fields str0");  
 *     "&lt;node-id&gt;": { "analytics": { "queries": {...}, "stages_by_type": {...}, "fragments": {...} } },
        }
    private static void assertLatencyStatsShape(String label, Map<String, Object> latency) {
 *   "nodes": {  
        assertNotNull(label + " object present", latency);
        assertNotNull("nodes block present", nodes);
 * {  
                assertNotNull(label + ".succeeded", bucket.get("succeeded"));
        assertNotNull("cluster_name present", body.get("cluster_name"));
                sawAnyQuery = true;
 * compatible open source license.
 *
        assertNotNull("nodes block present", nodes);
            long fragSucceeded = ((Number) fragments.get("succeeded")).longValue();
                assertTrue(nodeId + ".fragments.elapsed_ms.sum_ms > 0 when fragments succeeded", fragSum > 0);
            // (total/succeeded/failed) live in _nodes/stats, not here.  
    }
            }
        if (dataProvisioned == false) {
