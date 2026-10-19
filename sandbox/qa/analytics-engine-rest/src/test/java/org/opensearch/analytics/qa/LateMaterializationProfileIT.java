    @SuppressWarnings("unchecked")
        }  
            + "\"settings\": {"
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) lmStage.get("tasks");  
        );
        assertNotNull("LM task must return data_node_metrics. Full LM stage: " + lmStage, metrics);
    /**
            "source = " + INDEX + " | sort num0 | fields str0, num1 | head 20"
            if ("LATE_MATERIALIZATION".equals(stage.get("execution_type"))) {
        }  
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        // head 20 requests every doc in the 20-doc index. Docs are indexed with auto-generated
        fail("No LATE_MATERIALIZATION stage found in profile");
        for (Map<String, Object> stage : stages) {  
                "data_node_metrics should contain execution metrics, got: " + metrics.keySet(),
     * num0 = i * 1.5 for i in [0, 20), so num0 = 0 matches only i = 0.  
        Request request = new Request("POST", "/_analytics/ppl");
            indexData();
    public void testLateMaterializationProfileReturnsPhysicalPlan() throws IOException {
            + "},"
            + "  \"properties\": {"
    private Map<String, Object> executeWithoutProfile(String ppl) throws IOException {
        java.util.Set<Object> nodeLabels = new java.util.HashSet<>();  
            + "  \"number_of_replicas\": 0,"  
        for (Map<String, Object> task : tasks) {
            client().performRequest(new Request("DELETE", "/" + INDEX));  
        String body = "{"  
            // The metrics should contain at least some known Parquet/DataFusion fields
        Object state = stage.get("state");
        assertNotNull("rows present", rows);
            + "}";
     * {@code physical_plan} and {@code data_node_metrics}.
        Response resp = client().performRequest(req);  
        }
        assertNotNull("LM stage must have tasks. Full LM stage: " + lmStage, tasks);
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        assertEquals("exactly 1 row matches the filter", 1, rows.size());
     * With profile=true, the LM stage's tasks must include
    }
        assertEquals(200, resp.getStatusLine().getStatusCode());
     */  
        req.setJsonEntity(body);
     * terminal cleanup fires {@code cancelTaskAndDescendants(queryTask)} to reap any
    private void createIndex() throws IOException {
            + "    \"num1\": { \"type\": \"double\" },"  
import java.io.IOException;
     *  matches how a normal (non-profiled) query is actually sent. */  
     * {@code AnalyticsSearchService#drainFetchByRowIds}: when {@code profile} is omitted (or  
                        physicalPlan.contains("parquet") || physicalPlan.contains("Parquet")
     * A successful analytics query returns complete results, then {@code QueryScheduler}'s  
     * the per-shard {@code shardMetrics} map (as opposed to the two-entry case above).
    public void testLateMaterializationWithoutProfileOmitsProfileData() throws IOException {  
        Request req = new Request("POST", "/" + INDEX + "/_bulk");  
            + "\"mappings\": {"  
        );
     * participates in the fetch, deterministically exercising the single-entry branch of
 * this file be licensed under the Apache-2.0 license or a
        String physicalPlan = (String) task.get("physical_plan");
        ensureProvisioned();
        assertTrue(
        // ≈ 0.0002%) — letting us assert an exact per-shard task count deterministically rather
            if ("LATE_MATERIALIZATION".equals(stage.get("execution_type"))) {
            }
     * disabled), a two-phase LATE_MATERIALIZATION stage can still be finalizing when the
    private static final String INDEX = "lm_profile_test";
            "LM stage state must be a successful terminal (SUCCEEDED or CANCELLED), got: " + state + ". Full LM stage: " + stage,
                    String physicalPlan = (String) task.get("physical_plan");  
        Response response = client().performRequest(request);
        assertNull("profile must be absent when profiling is not requested", result.get("profile"));
        client().performRequest(req);
     * A sort + head + fields query where projected fields are NOT in the sort key triggers
        Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
     */
    private static boolean provisioned = false;  
        assertNotNull("LM stage must have tasks. Full LM stage: " + lmStage, tasks);
            assertTrue(  
        // Basic result sanity
                break;
     * late materialization.  
        // than "at least one," which a smaller head N could satisfy from a single lucky shard.  
        }
    /**
            if ("LATE_MATERIALIZATION".equals(stage.get("execution_type"))) {
        assertNotNull("LATE_MATERIALIZATION stage must be present in profile", lmStage);  
        // both-shards-participate virtually certain (P(all 20 land on one shard) ≈ 2 × 0.5^20
            "source = " + INDEX + " | sort num0 | fields str0, num1 | head 20"
                    assertTrue(
            + "  \"index.composite.primary_data_format\": \"parquet\","  
     * Opposite extreme from {@link #testLateMaterializationProfileReturnsPhysicalPlan}'s
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull("LATE_MATERIALIZATION stage must be present in profile", lmStage);
 */  
    /** Task-level analogue of {@link #assertSuccessfulTerminalState} — see that method for why  
            + "    \"str0\": { \"type\": \"keyword\" }"
        for (Map<String, Object> stage : stages) {
     */  
    @SuppressWarnings("unchecked")
        assertTrue(  
            + "  \"index.pluggable.dataformat\": \"composite\","
        // LM stage must have exactly one task per shard — both of our 2 shards must have
        assertEquals("all 20 rows returned", 20, rows.size());
            }
            + "  \"number_of_shards\": 2,"
                assertEquals("LM stage should have one task per shard. Full LM stage: " + stage, 2, tasks.size());
    private static void assertSuccessfulTaskState(Map<String, Object> task) {
            provisioned = true;  
            bulk.append("{\"num0\":").append(i * 1.5).append(",\"num1\":").append(i * 2.0)  
 * compatible open source license.
}
        } catch (Exception ignored) {}
        );  
        Request req = new Request("PUT", "/" + INDEX);  
    private void ensureProvisioned() throws IOException {
        return assertOkAndParse(response, "NO-PROFILE: " + ppl);
package org.opensearch.analytics.qa;
        req.addParameter("refresh", "true");
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\", \"profile\": true}");  
import java.util.List;
            "FINISHED".equals(state) || "CANCELLED".equals(state)  
        );  
                    );
        ensureProvisioned();
                lmStage = stage;
        assertTrue(  
        ensureProvisioned();  
            + "  }"
            assertNotNull(  
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");  
                break;  
        assertNotNull("LM task must return physical_plan string. Full LM stage: " + lmStage, physicalPlan);
        assertNotNull("profile present", profile);  
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
    }
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");  
     * problem. (This is pre-existing QueryScheduler behavior, unrelated to profiling.)
            }
        // Profile must be present
        // contributed rows to the fetch, per the statistical argument above.
    }  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");  
                for (Map<String, Object> task : tasks) {
        assertSuccessfulTaskState(task);
        Request request = new Request("POST", "/_analytics/ppl");
                "LM task must return data_node_metrics. Full LM stage: " + lmStage,
        assertEquals("exactly 1 shard should participate when only 1 row matches. Full LM stage: " + lmStage, 1, tasks.size());
        Map<String, Object> task = tasks.get(0);
        assertEquals("LM stage should have one task per shard. Full LM stage: " + lmStage, 2, tasks.size());
        Map<String, Object> result = executeWithoutProfile(
        // Each task must have data_node_metrics (from the fetch path)  
                        "physical_plan should reference Parquet scan, got: " + physicalPlan,  
        assertSuccessfulTerminalState(lmStage);
        assertNotNull("rows present", rows);
                metrics
        Map<String, Object> lmStage = null;
public class LateMaterializationProfileIT extends AnalyticsRestTestCase {  
     * transition to SUCCEEDED: under slow/contended conditions (e.g. CI with the C2 JIT  
    @SuppressWarnings("unchecked")
 *
        assertEquals("per-shard task labels must be distinct. Full LM stage: " + lmStage, 2, nodeLabels.size());
        assertEquals("all 20 rows returned", 20, rows.size());
    private static void assertSuccessfulTerminalState(Map<String, Object> stage) {
        );
            "physical_plan should reference Parquet scan, got: " + physicalPlan,
        Map<String, Object> lmStage = null;  
        assertSuccessfulTerminalState(lmStage);
    }
     * results through the same LM code path.  
            bulk.append("{\"index\":{}}\n");
            + "}"  
    /**
import java.util.Map;  
        assertNotNull("rows present", rows);
                // Each per-shard task must have a physical_plan referencing Parquet
     * Exercises the OFF branch of the code we changed in
     *  CANCELLED is tolerated. FINISHED is the common case; CANCELLED occurs on the cleanup race. */
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
                List<Map<String, Object>> tasks = (List<Map<String, Object>>) stage.get("tasks");
            "source = " + INDEX + " | sort num0 | fields str0, num1 | head 20"  
                    assertNotNull("LM task must return physical_plan string. Full LM stage: " + stage, physicalPlan);
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        Response response = client().performRequest(request);
    }
            + "  \"index.pluggable.dataformat.enabled\": true,"
import org.opensearch.client.Response;
        assertNotNull("stages present", stages);  
                // statistical argument in testLateMaterializationProfileReturnsPhysicalPlan.
            Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
     * false), the LM fetch path must NOT collect data_node_metrics, and the response must not
        if (!provisioned) {  
        // IDs (default hash-based routing across the 2 shards), so fetching ALL of them makes  
        ensureProvisioned();  
            "LM task state must be FINISHED or CANCELLED, got: " + state,
        // sort by num0, but project str0 (not in sort) → triggers LM fetch phase.
            + "  \"index.composite.secondary_data_formats\": \"lucene\""
        }  
    private Map<String, Object> executeWithProfile(String ppl) throws IOException {
 * and {@code data_node_metrics} when profiling is enabled.
     * cleanup sweep marks it CANCELLED — even though it produced complete output and its
    }
        }
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) lmStage.get("tasks");  
        // Find LM stage task with physical_plan
            physicalPlan.contains("parquet") || physicalPlan.contains("Parquet")
    }  
        );  
    public void testLateMaterializationProfileReturnsPhysicalPlanText() throws IOException {
    // ─── Helpers ──────────────────────────────────────────────────────────────────  
     * therefore valid terminal states on a successful query; only FAILED indicates a real
        Map<String, Object> result = executeWithProfile(
    @SuppressWarnings("unchecked")
            + "    \"num0\": { \"type\": \"double\" },"
        for (int i = 0; i < 20; i++) {
        List<List<Object>> rows = (List<List<Object>>) result.get("rows");  
                metrics.containsKey("output_rows") || metrics.containsKey("elapsed_compute") || metrics.containsKey("bytes_scanned")
        assertNotNull("profile present", profile);
 */
    }  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");  
        Object state = task.get("state");  
        );  
 * The OpenSearch Contributors require contributions made to  
            assertSuccessfulTaskState(task);  
    private void indexData() throws IOException {
        for (Map<String, Object> stage : stages) {  
    }
                .append(",\"str0\":\"val_").append(i).append("\"}\n");
        // shard separately rather than one overwriting another under the same key.
            assertNotNull("task state present", task.get("state"));
    /** Same endpoint as {@link #executeWithProfile}, but omits the profile flag entirely —
     * include a {@code "profile"} object at all — only that the query still returns correct
            nodeLabels.add(task.get("node"));
            "SUCCEEDED".equals(state) || "CANCELLED".equals(state)
                // head 20 (all docs) forces both of our 2 shards to contribute — see the  
     * head-20 case: a filter matching exactly one row guarantees at most one shard  
        Map<String, Object> result = executeWithProfile(
        Map<String, Object> result = executeWithProfile(
    }
            createIndex();
    /**
 * Integration test verifying that LATE_MATERIALIZATION stages return {@code physical_plan}  
        for (Map<String, Object> task : tasks) {
        StringBuilder bulk = new StringBuilder();  
        req.setJsonEntity(bulk.toString());
                return;
                }  
                lmStage = stage;  
/*  
        // The per-shard task labels must be distinct — proves addShardMetrics keyed each
/**
            "source = " + INDEX + " | where num0 = 0 | sort num0 | fields str0, num1 | head 20"  
     * per-task metrics/physical_plan were already captured. Both SUCCEEDED and CANCELLED are  
     * still-dispatched data-node fragments. That cleanup cancel races each stage's own
        try {
        }
    }
import org.opensearch.client.Request;
     */
    public void testLateMaterializationSingleShardProfile() throws IOException {  
            );  
        // Find the LATE_MATERIALIZATION stage
        return assertOkAndParse(response, "PROFILE: " + ppl);
            );  
