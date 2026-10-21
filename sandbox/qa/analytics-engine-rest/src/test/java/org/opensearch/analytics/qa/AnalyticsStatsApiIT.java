        assertNotNull(label + " object present", latency);
    }
        assertFalse("at least one node in response", nodes.isEmpty());
        boolean sawAnyQuery = false;
        ensureDataProvisioned();
        assertEquals("path scope contacts exactly one node", 1, ((Number) nodesHeader.get("total")).intValue());
                assertNotNull(label + ".started", bucket.get("started"));
        assertTrue(nodeId + " is the only entry", scopedNodes.containsKey(nodeId));
        Map<String, Object> body = assertOkAndParse(client().performRequest(request), "STATS GET (single node)");
            Map<String, Object> stagesByType = (Map<String, Object>) analytics.get("stages_by_type");
            // (total/succeeded/failed) live in _nodes/stats, not here.
            assertNotNull(nodeId + ".stages_by_type present", stagesByType);
        Response response = client().performRequest(request);
/**
 * compatible open source license.
        assertEquals("response carries exactly one node entry", 1, scopedNodes.size());
        assertTrue("at least one node recorded a fragment", sawAnyFragment);
                    nodeId + ".fragments.succeeded > 0 when total > 0, total=" + fragTotal + " succeeded=" + fragSucceeded,
            }
    private void ensureDataProvisioned() throws IOException {
 * <pre>
        assertNotNull("_nodes header present", nodesHeader);
    private static void assertLatencyStatsShape(String label, Map<String, Object> latency) {
import org.opensearch.client.Response;
        // Fire a mix of query shapes so the per-stage-type buckets see varied work and the
            }
            long fragSucceeded = ((Number) fragments.get("succeeded")).longValue();
            executePpl("source=" + DATASET.indexName + " | fields str0");
                    fragSucceeded > 0
                assertLatencyStatsShape(label + ".elapsed_ms", (Map<String, Object>) bucket.get("elapsed_ms"));
 */
    public void testStatsEndpointScopedToSingleNode() throws IOException {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    private Map<String, Object> fetchStats() throws IOException {
            assertNotNull(nodeId + ".analytics present", analytics);
        if (dataProvisioned == false) {
            }
        Map<String, Object> nodesHeader = (Map<String, Object>) body.get("_nodes");
            long v = ((Number) latency.get(field)).longValue();
                    sawAnyStage = true;
            assertNotNull(nodeId + ".fragments.total", fragments.get("total"));
            assertLatencyStatsShape(nodeId + ".queries.elapsed_ms", elapsed);
        assertNotNull("_nodes header present", nodesHeader);
            assertLatencyStatsShape(nodeId + ".fragments.elapsed_ms", fragElapsed);
                }
    public void testStatsEndpointReflectsExecutedQueries() throws IOException {
        for (String field : new String[] { "count", "sum_ms" }) {
                long fragSum = ((Number) fragElapsed.get("sum_ms")).longValue();
        }
                );
 *   "cluster_name": "...",
        return assertOkAndParse(response, "STATS GET");
            executePpl("source=" + DATASET.indexName + " | where num0 > 0 | fields str0, num0");
        Map<String, Object> all = fetchStats();
 *   }
                assertTrue(
        }
        // histograms have enough samples for percentile spread. The REST client round-robins
        for (Map.Entry<String, Object> nodeEntry : nodes.entrySet()) {
 *
        String nodeId = nodes.keySet().iterator().next();
package org.opensearch.analytics.qa;
            String nodeId = nodeEntry.getKey();
            if (fragTotal > 0) {
                if (((Number) bucket.get("started")).longValue() > 0) {
        for (int i = 0; i < 30; i++) {
 */
 * this file be licensed under the Apache-2.0 license or a
/*
        assertNotNull("nodes block present", nodes);
            Map<String, Object> nodeBody = (Map<String, Object>) nodeEntry.getValue();
            Map<String, Object> fragElapsed = (Map<String, Object>) fragments.get("elapsed_ms");
        // saw the most activity.
            Map<String, Object> queries = (Map<String, Object>) analytics.get("queries");
        }
            Map<String, Object> analytics = (Map<String, Object>) nodeBody.get("analytics");
        Request request = new Request("GET", "/_plugins/_analytics/" + nodeId + "/stats");
            long fragTotal = ((Number) fragments.get("total")).longValue();
        Map<String, Object> body = fetchStats();
 *     ...
 * <p>The endpoint mirrors {@code _nodes/stats}'s shape:
 *     "&lt;node-id&gt;": { "analytics": { "queries": {...}, "stages_by_type": {...}, "fragments": {...} } },
    }
    }
 * {
        Map<String, Object> nodes = (Map<String, Object>) all.get("nodes");
        assertNotNull(nodeId + ".analytics present", ((Map<String, Object>) scopedNodes.get(nodeId)).get("analytics"));
            // queries bucket carries only the latency distributions — query counters
        Map<String, Object> nodesHeader = (Map<String, Object>) body.get("_nodes");
    @SuppressWarnings("unchecked")
 *
    }
    private static boolean dataProvisioned = false;
        assertTrue("at least one node recorded a query", sawAnyQuery);
            DatasetProvisioner.provision(client(), DATASET);
        assertNotNull("cluster_name present", body.get("cluster_name"));
            assertNotNull(nodeId + ".fragments present", fragments);
        assertFalse("at least one node in cluster", nodes.isEmpty());
        // At least one node must have recorded work — every query was coordinated by some
    }
        ensureDataProvisioned();
import org.opensearch.client.Request;
 * SPDX-License-Identifier: Apache-2.0
            Map<String, Object> elapsed = (Map<String, Object>) queries.get("elapsed_ms");
            assertNotNull(nodeId + ".queries present", queries);
        Map<String, Object> nodes = (Map<String, Object>) body.get("nodes");
            for (Map.Entry<String, Object> stageEntry : stagesByType.entrySet()) {
import java.util.Map;
            assertNotNull(label + "." + field, latency.get(field));
            dataProvisioned = true;
 *   "_nodes": {...},
    @SuppressWarnings("unchecked")
                sawAnyQuery = true;
 *   "nodes": {
}
        // Pick an arbitrary node id from a cluster-wide call, then re-query scoped to that id.
                sawAnyFragment = true;
public class AnalyticsStatsApiIT extends AnalyticsRestTestCase {
 * PPL queries via {@code POST /_analytics/ppl} and verifies the stats endpoint
 * </pre>
        Request request = new Request("GET", "/_plugins/_analytics/stats");
                assertTrue(nodeId + ".fragments.elapsed_ms.sum_ms > 0 when fragments succeeded", fragSum > 0);
 * }
 * full analytics rollup.
            assertLatencyStatsShape(nodeId + ".queries.planning_ms", (Map<String, Object>) queries.get("planning_ms"));
        boolean sawAnyFragment = false;
        // the coordinator across nodes, so different queries land on different coordinators.
                Map<String, Object> bucket = (Map<String, Object>) stageEntry.getValue();
            executePpl("source=" + DATASET.indexName + " | stats avg(num0)");
import java.io.IOException;
        assertTrue("at least one node recorded a stage", sawAnyStage);
            Map<String, Object> fragments = (Map<String, Object>) analytics.get("fragments");
 * Integration test for {@code GET /_plugins/_analytics/stats}. Fires a few
        }
            assertTrue(label + "." + field + " non-negative, got " + v, v >= 0);
                String label = nodeId + ".stages_by_type." + stageEntry.getKey();
        Map<String, Object> scopedNodes = (Map<String, Object>) body.get("nodes");
        // node in this cluster. Walk all nodes, validate each one's shape, and track which
                assertNotNull(label + ".succeeded", bucket.get("succeeded"));
        boolean sawAnyStage = false;
 * The OpenSearch Contributors require contributions made to
 * returns a cluster-wide response with one entry per node, each carrying the
            if (((Number) elapsed.get("count")).longValue() > 0) {
        assertNotNull("nodes block present", nodes);
