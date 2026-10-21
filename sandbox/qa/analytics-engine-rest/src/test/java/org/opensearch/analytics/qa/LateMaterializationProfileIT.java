     * head-20 case: a filter matching exactly one row guarantees at most one shard
    /**
            + "}"
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
            "source = " + INDEX + " | sort num0 | fields str0, num1 | head 20"
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) lmStage.get("tasks");
    }
            indexData();
     * participates in the fetch, deterministically exercising the single-entry branch of
            + "    \"str0\": { \"type\": \"keyword\" }"
     * num0 = i * 1.5 for i in [0, 20), so num0 = 0 matches only i = 0.
                    );
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
     *  CANCELLED is tolerated. FINISHED is the common case; CANCELLED occurs on the cleanup race. */
     * With profile=true, the LM stage's tasks must include
     * {@code AnalyticsSearchService#drainFetchByRowIds}: when {@code profile} is omitted (or
            );
public class LateMaterializationProfileIT extends AnalyticsRestTestCase {
        );
            + "    \"num1\": { \"type\": \"double\" },"
        Map<String, Object> lmStage = null;
        assertTrue(
     * Opposite extreme from {@link #testLateMaterializationProfileReturnsPhysicalPlan}'s
     * include a {@code "profile"} object at all — only that the query still returns correct
        }
    private void ensureProvisioned() throws IOException {
    // ─── Helpers ──────────────────────────────────────────────────────────────────
    private void createIndex() throws IOException {
        // Find LM stage task with physical_plan
                // statistical argument in testLateMaterializationProfileReturnsPhysicalPlan.
            if ("LATE_MATERIALIZATION".equals(stage.get("execution_type"))) {
        assertNull("profile must be absent when profiling is not requested", result.get("profile"));
     *  matches how a normal (non-profiled) query is actually sent. */
            nodeLabels.add(task.get("node"));
import java.util.Map;
                break;
        assertNotNull("profile present", profile);
        Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
 *
        Response resp = client().performRequest(req);
            "LM stage state must be a successful terminal (SUCCEEDED or CANCELLED), got: " + state + ". Full LM stage: " + stage,
    @SuppressWarnings("unchecked")
        }
        for (Map<String, Object> stage : stages) {
        }
        assertEquals("per-shard task labels must be distinct. Full LM stage: " + lmStage, 2, nodeLabels.size());
            + "  }"
        assertNotNull("LATE_MATERIALIZATION stage must be present in profile", lmStage);
        assertNotNull("LM stage must have tasks. Full LM stage: " + lmStage, tasks);
                    assertTrue(
        assertTrue(
    @SuppressWarnings("unchecked")
                for (Map<String, Object> task : tasks) {
            bulk.append("{\"num0\":").append(i * 1.5).append(",\"num1\":").append(i * 2.0)
     * {@code physical_plan} and {@code data_node_metrics}.
        assertEquals(200, resp.getStatusLine().getStatusCode());
        );
/**
     * results through the same LM code path.
            provisioned = true;
     * cleanup sweep marks it CANCELLED — even though it produced complete output and its
        String body = "{"
        assertTrue(
     * transition to SUCCEEDED: under slow/contended conditions (e.g. CI with the C2 JIT
        // both-shards-participate virtually certain (P(all 20 land on one shard) ≈ 2 × 0.5^20
        Map<String, Object> result = executeWithProfile(
 * SPDX-License-Identifier: Apache-2.0
                metrics.containsKey("output_rows") || metrics.containsKey("elapsed_compute") || metrics.containsKey("bytes_scanned")
     */
    @SuppressWarnings("unchecked")
        );
        Response response = client().performRequest(request);
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
/*
            // The metrics should contain at least some known Parquet/DataFusion fields
    private static void assertSuccessfulTaskState(Map<String, Object> task) {
            + "}";
        Object state = task.get("state");
import org.opensearch.client.Request;
        // than "at least one," which a smaller head N could satisfy from a single lucky shard.
                "LM task must return data_node_metrics. Full LM stage: " + lmStage,
    public void testLateMaterializationProfileReturnsPhysicalPlan() throws IOException {
    private Map<String, Object> executeWithoutProfile(String ppl) throws IOException {
        ensureProvisioned();
        // sort by num0, but project str0 (not in sort) → triggers LM fetch phase.
        String physicalPlan = (String) task.get("physical_plan");
            bulk.append("{\"index\":{}}\n");
        ensureProvisioned();
    }
        assertNotNull("LM task must return physical_plan string. Full LM stage: " + lmStage, physicalPlan);
        return assertOkAndParse(response, "PROFILE: " + ppl);
        Map<String, Object> result = executeWithoutProfile(
    private Map<String, Object> executeWithProfile(String ppl) throws IOException {
            + "\"mappings\": {"
        req.setJsonEntity(bulk.toString());
        // LM stage must have exactly one task per shard — both of our 2 shards must have
        ensureProvisioned();
        assertEquals("LM stage should have one task per shard. Full LM stage: " + lmStage, 2, tasks.size());
     * the per-shard {@code shardMetrics} map (as opposed to the two-entry case above).
 * Integration test verifying that LATE_MATERIALIZATION stages return {@code physical_plan}
        for (Map<String, Object> stage : stages) {
        for (Map<String, Object> stage : stages) {
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
            "LM task state must be FINISHED or CANCELLED, got: " + state,
    public void testLateMaterializationProfileReturnsPhysicalPlanText() throws IOException {
        assertEquals("all 20 rows returned", 20, rows.size());
        Request req = new Request("POST", "/" + INDEX + "/_bulk");
        // IDs (default hash-based routing across the 2 shards), so fetching ALL of them makes
        Map<String, Object> result = executeWithProfile(
    }
        for (Map<String, Object> task : tasks) {
                "data_node_metrics should contain execution metrics, got: " + metrics.keySet(),
     * A successful analytics query returns complete results, then {@code QueryScheduler}'s
            }
        Response response = client().performRequest(request);
import java.io.IOException;
                List<Map<String, Object>> tasks = (List<Map<String, Object>>) stage.get("tasks");
 * this file be licensed under the Apache-2.0 license or a
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        Map<String, Object> task = tasks.get(0);
    }
        // shard separately rather than one overwriting another under the same key.
            );
        assertSuccessfulTerminalState(lmStage);
        }
        // ≈ 0.0002%) — letting us assert an exact per-shard task count deterministically rather
    @SuppressWarnings("unchecked")
        assertNotNull("rows present", rows);
                }
    }
     * terminal cleanup fires {@code cancelTaskAndDescendants(queryTask)} to reap any
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
            if ("LATE_MATERIALIZATION".equals(stage.get("execution_type"))) {
        } catch (Exception ignored) {}
        assertSuccessfulTerminalState(lmStage);
        Request request = new Request("POST", "/_analytics/ppl");
                .append(",\"str0\":\"val_").append(i).append("\"}\n");
    }
     * problem. (This is pre-existing QueryScheduler behavior, unrelated to profiling.)
                // head 20 (all docs) forces both of our 2 shards to contribute — see the
            + "  \"number_of_shards\": 2,"
        StringBuilder bulk = new StringBuilder();
        Request req = new Request("PUT", "/" + INDEX);
    private static final String INDEX = "lm_profile_test";
        );
        assertSuccessfulTaskState(task);
     * still-dispatched data-node fragments. That cleanup cancel races each stage's own
        assertEquals("exactly 1 row matches the filter", 1, rows.size());
 * and {@code data_node_metrics} when profiling is enabled.
        return assertOkAndParse(response, "NO-PROFILE: " + ppl);
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        }
    /** Same endpoint as {@link #executeWithProfile}, but omits the profile flag entirely —
        // Basic result sanity
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) lmStage.get("tasks");
        }
        // Find the LATE_MATERIALIZATION stage
        );
    /**
     * therefore valid terminal states on a successful query; only FAILED indicates a real
        Map<String, Object> lmStage = null;
     * A sort + head + fields query where projected fields are NOT in the sort key triggers
        try {
        client().performRequest(req);
 */
                        "physical_plan should reference Parquet scan, got: " + physicalPlan,
            "source = " + INDEX + " | sort num0 | fields str0, num1 | head 20"
        for (int i = 0; i < 20; i++) {
            "source = " + INDEX + " | sort num0 | fields str0, num1 | head 20"
            + "  \"properties\": {"
        assertEquals("exactly 1 shard should participate when only 1 row matches. Full LM stage: " + lmStage, 1, tasks.size());
        assertNotNull("rows present", rows);
        assertNotNull("rows present", rows);
                    assertNotNull("LM task must return physical_plan string. Full LM stage: " + stage, physicalPlan);
 */
            }
    /**
     * Exercises the OFF branch of the code we changed in
            + "  \"index.pluggable.dataformat.enabled\": true,"
            + "  \"number_of_replicas\": 0,"
 * The OpenSearch Contributors require contributions made to
            assertSuccessfulTaskState(task);
        assertNotNull("LM task must return data_node_metrics. Full LM stage: " + lmStage, metrics);
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
            physicalPlan.contains("parquet") || physicalPlan.contains("Parquet")
        assertNotNull("LATE_MATERIALIZATION stage must be present in profile", lmStage);
        Map<String, Object> result = executeWithProfile(
import org.opensearch.client.Response;
        assertEquals("all 20 rows returned", 20, rows.size());
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\", \"profile\": true}");
                lmStage = stage;
            + "\"settings\": {"
        ensureProvisioned();
                assertEquals("LM stage should have one task per shard. Full LM stage: " + stage, 2, tasks.size());
     */
            if ("LATE_MATERIALIZATION".equals(stage.get("execution_type"))) {
package org.opensearch.analytics.qa;
            + "  \"index.composite.primary_data_format\": \"parquet\","
                return;
     * disabled), a two-phase LATE_MATERIALIZATION stage can still be finalizing when the
        req.setJsonEntity(body);
            + "    \"num0\": { \"type\": \"double\" },"
        assertNotNull("stages present", stages);
                        physicalPlan.contains("parquet") || physicalPlan.contains("Parquet")
                lmStage = stage;
            "physical_plan should reference Parquet scan, got: " + physicalPlan,
            + "},"
        // Profile must be present
            "FINISHED".equals(state) || "CANCELLED".equals(state)
        assertNotNull("profile present", profile);
                break;
    /** Task-level analogue of {@link #assertSuccessfulTerminalState} — see that method for why
            }
     */
        java.util.Set<Object> nodeLabels = new java.util.HashSet<>();
    public void testLateMaterializationWithoutProfileOmitsProfileData() throws IOException {
        // The per-shard task labels must be distinct — proves addShardMetrics keyed each
    private static void assertSuccessfulTerminalState(Map<String, Object> stage) {
                metrics
     */
            assertNotNull("task state present", task.get("state"));
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
    /**
            assertTrue(
                    String physicalPlan = (String) task.get("physical_plan");
                // Each per-shard task must have a physical_plan referencing Parquet
            + "  \"index.pluggable.dataformat\": \"composite\","
            "SUCCEEDED".equals(state) || "CANCELLED".equals(state)
    private static boolean provisioned = false;
        );
        for (Map<String, Object> task : tasks) {
        }
        assertNotNull("LM stage must have tasks. Full LM stage: " + lmStage, tasks);
        // head 20 requests every doc in the 20-doc index. Docs are indexed with auto-generated
    public void testLateMaterializationSingleShardProfile() throws IOException {
    }
    private void indexData() throws IOException {
            createIndex();
    }
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");
    }
}
 * compatible open source license.
            assertNotNull(
    }
            Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        Request request = new Request("POST", "/_analytics/ppl");
     * false), the LM fetch path must NOT collect data_node_metrics, and the response must not
     * per-task metrics/physical_plan were already captured. Both SUCCEEDED and CANCELLED are
            client().performRequest(new Request("DELETE", "/" + INDEX));
        req.addParameter("refresh", "true");
        if (!provisioned) {
    }
            "source = " + INDEX + " | where num0 = 0 | sort num0 | fields str0, num1 | head 20"
        Object state = stage.get("state");
     * late materialization.
        );
        fail("No LATE_MATERIALIZATION stage found in profile");
        // Each task must have data_node_metrics (from the fetch path)
        // contributed rows to the fetch, per the statistical argument above.
import java.util.List;
