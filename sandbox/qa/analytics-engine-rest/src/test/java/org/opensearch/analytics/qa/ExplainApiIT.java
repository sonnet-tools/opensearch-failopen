import org.opensearch.client.Request;
        assertTrue("shard stage has at least 2 tasks (one per shard), got " + tasks.size(), tasks.size() >= 2);
 * SPDX-License-Identifier: Apache-2.0
        }  
        Map<String, Object> result = executeWithProfile(
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"  
    }  
        // Verify the physical plan shows IndexedExec (delegation operator)
            Object plan = task.get("physical_plan");
 *
        assertNotNull("stages present", stages);
        assertTrue("physical_plan contains AggregateExec operator",  
 * timing) that these tests assert against; the real plugin's {@code /_plugins/_ppl/_explain}
        // SHARD_FRAGMENT (partial aggregate on data nodes) + COORDINATOR_REDUCE (final aggregate)
    @SuppressWarnings("unchecked")  
        assertNotNull("tasks present", tasks);
 */  
                    assertFalse("physical_plan must not leak a data dir path, got: " + s, s.contains("/nodes/"));
                break;  
        // Verify we have both a SHARD_FRAGMENT and a COORDINATOR_REDUCE stage
    public void testProfilePhysicalPlanRedactsStoragePaths() throws IOException {
            }  
        Response response = client().performRequest(request);
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));  
    @SuppressWarnings("unchecked")
        assertNotNull("at least one task has data_node_metrics with ffm_collector_calls", metrics);  
        long outputRows = ((Number) metrics.get("output_rows")).longValue();
        // Non-delegation path: shard plan uses standard ParquetExec with AggregateExec
        Map<String, Object> shardStage = stages.stream()
    private Map<String, Object> executeWithProfile(String ppl) throws IOException {
        assertNotNull("profile present", profile);  
        assertNotNull("execution_type", stage.get("execution_type"));
    private static boolean dataProvisioned = false;
    }
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        }
        // output_rows from the coordinator's reduce plan. Due to the flat-map tree walk,
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
    }
        if (delegationProvisioned == false) {
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        assertFalse("physical_plan does NOT contain QueryShardExec (no delegation)",
        long planningTime = ((Number) profile.get("planning_time_ms")).longValue();
    }  
    @SuppressWarnings("unchecked")
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
                anyMetrics = true;
        // not just on the one stage the happy-path test happens to inspect.
                assertNotNull("elapsed_compute present", metrics.get("elapsed_compute"));  
    private void ensureClickBenchProvisioned() throws IOException {
        assertFalse("has tasks", tasks.isEmpty());
            .findFirst()  
        assertNotNull("coordinator reduce task has data_node_metrics", metrics);
                continue;  
    }
 * The OpenSearch Contributors require contributions made to  
 * Integration test for {@code POST /_analytics/ppl/_explain}.  
    @SuppressWarnings("unchecked")  
        Map<String, Object> metrics = null;
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        // ClickBench has 100 docs with 84 distinct RegionID values across 2 shards.  
 *
        // Collect every physical_plan string across all stages/tasks — redaction must hold everywhere,  
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
        List<Object> rows = (List<Object>) result.get("rows");
        assertNotNull("profile present", profile);  
                        // The redaction marker replaces the path list but keeps the group count.
        // Should have normal query results
        Map<String, Object> result = executeExplain("source=" + DATASET.indexName + " | fields str0");
            if ("SHARD_FRAGMENT".equals(execType)) hasShardFragment = true;  
        assertNotNull("query_id present", profile.get("query_id"));  
            assertTrue("elapsed is non-negative", elapsed >= 0);
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) reduceStage.get("tasks");  
                physicalPlan = (String) task.get("physical_plan");
        Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
        assertNotNull("index_query_time present", metrics.get("index_query_time"));  
    }
            DatasetProvisioner.provision(client(), DELEGATION);
    @Override  
        Map<String, Object> task = tasks.get(0);
                break;  
            .filter(s -> "COORDINATOR_REDUCE".equals(s.get("execution_type")))
        Map<String, Object> task = tasks.get(0);
import org.opensearch.client.Response;
        assertNotNull("profile present", profile);
        Map<String, Object> result = executeExplain("source=" + DATASET.indexName + " | fields str0");
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
            Map<String, Object> m = (Map<String, Object>) t.get("data_node_metrics");
        for (Map<String, Object> task : tasks) {
    }  
            ((Number) metrics.get("ffm_collector_calls")).longValue() > 0
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
    public void testExplainReturnsFullPlan() throws IOException {
        return assertOkAndParse(response, "PROFILE: " + ppl);  
        );
 * compatible open source license.
                break;
        assertNotNull("columns present", result.get("columns"));  
            if (tasks == null) {
            long elapsed = ((Number) task.get("elapsed_ms")).longValue();
        assertTrue("output_rows > 0", ((Number) metrics.get("output_rows")).longValue() > 0);
        Map<String, Object> result = executeWithProfile("source=" + DATASET.indexName + " | fields str0, num0");  
        assertNotNull("rows_matched present", metrics.get("rows_matched"));  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");  
    public void testExplainTotalElapsedIsPositive() throws IOException {  
        // Plan should reference the table being scanned
            DatasetProvisioner.provision(client(), DATASET);  
    public void testProfileReturnsPhysicalPlan() throws IOException {
        );
        ensureClickBenchProvisioned();  
                        assertTrue("file_groups must be redacted, got: " + s, s.contains("<redacted>"));  
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
        assertTrue("expected at least one file_groups scan node in the profile", sawFileGroups);
    public void testProfileCoordinatorReduceHasMetrics() throws IOException {  
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
    }  
    private static boolean clickBenchProvisioned = false;  
                    if (s.contains("file_groups=")) {  
        assertNotNull("tasks present", tasks);
        }
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        assertTrue("plan mentions table scan", planText.contains("TableScan") || planText.contains("Scan"));  
        Map<String, Object> result = executeWithProfile(
     * URIs/keys on S3/GCS/Azure-backed indices) into an API any query-authorized caller can hit.
            if (m != null) {  
        assertNotNull("profile present", profile);
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");  
        assertNotNull("stages present", stages);
    }  
        Map<String, Object> result = executeWithProfile(
        long totalElapsed = ((Number) profile.get("execution_time_ms")).longValue();
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\", \"profile\": true}");
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
    public void testProfileCoordinatorOutputRowsMatchesResultCount() throws IOException {
        Map<String, Object> reduceStage = stages.stream()
        assertTrue("coordinator output_rows is positive and >= result count",  
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"  
        String physicalPlan = null;  
            for (Map<String, Object> task : tasks) {
package org.opensearch.analytics.qa;
            }
        // Find a task with data_node_metrics (some shards may be empty on multi-node clusters)
        assertTrue("has SHARD_FRAGMENT stage", hasShardFragment);  
            physicalPlan.contains("QueryShardExec"));
        // Simple scan has a SHARD_FRAGMENT stage but no COORDINATOR_REDUCE  
            .filter(s -> "COORDINATOR_REDUCE".equals(s.get("execution_type")))  
        assertNotNull("profile present", profile);
            assertEquals("stage succeeded", "SUCCEEDED", stage.get("state"));
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
        assertNotNull("profile present", profile);  
    public void testExplainMultiStageShardFragmentHasTasks() throws IOException {
            long elapsed = ((Number) stage.get("elapsed_ms")).longValue();  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        String planText = String.join("\n", fullPlan);
            }
        assertNotNull("full_plan present", fullPlan);
        );
            .findFirst()  
 * (stage timings, plan) alongside the normal results.
                Object plan = task.get("physical_plan");  
        String physicalPlan = null;
        assertFalse("reduce stage has at least one task", tasks.isEmpty());  
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");
 * shim rather than the real {@code opensearch-sql} plugin. The shim's explain output ships  
        }
        assertNotNull("state", stage.get("state"));  
                metrics = m;
        assertTrue("has COORDINATOR_REDUCE stage", hasCoordinatorReduce);
        }
        assertFalse("full_plan not empty", fullPlan.isEmpty());
                    }
        assertNotNull("execution_time_ms present", profile.get("execution_time_ms"));
    }
        );  
        boolean hasShardFragment = false;
     * Verifies that the physical_plan surfaced by profile=true does NOT leak storage locations.
            if ("COORDINATOR_REDUCE".equals(execType)) hasCoordinatorReduce = true;
        // Find a task with metrics
                    // No absolute filesystem path or object-store URI should survive redaction.
        // Sanity: this query scans parquet, so at least one scan node with file_groups must exist —
    public void testExplainStagesShowSucceededState() throws IOException {
import java.util.Map;  
        assertNotNull("elapsed_ms", stage.get("elapsed_ms"));
                assertNotNull("output_rows present", metrics.get("output_rows"));
        Map<String, Object> result = executeWithProfile(
        // Should have profile section  
    private static boolean delegationProvisioned = false;
            if (metrics != null) {  
        for (Map<String, Object> t : tasks) {
        assertTrue("at least one task has data_node_metrics", anyMetrics);
                        sawFileGroups = true;
        assertNotNull("profile present", profile);
        for (Map<String, Object> task : tasks) {  
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");  
        assertNotNull("tasks present", tasks);
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        assertFalse("has tasks", tasks.isEmpty());
    }
        // Find the SHARD_FRAGMENT stage and verify it has tasks (one per shard)
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
                }
        assertNotNull("row_groups_processed present", metrics.get("row_groups_processed"));
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
    public void testExplainWithAggregationShowsMultipleStages() throws IOException {
        return assertOkAndParse(response, "EXPLAIN: " + ppl);
        Map<String, Object> shardStage = stages.stream()  
        }  
        Map<String, Object> stage = stages.get(0);  
        assertNotNull("coordinator metrics present", metrics);  
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))  
        // (final aggregate output). Assert it's positive and >= actual result count.
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");  
        assertNotNull("rows present", result.get("rows"));
        assertNotNull("profile present", profile);
        // Each stage should have required fields
        );
    @SuppressWarnings("unchecked")
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
 *
            String execType = (String) stage.get("execution_type");
            assertEquals("task finished", "FINISHED", task.get("state"));
    @SuppressWarnings("unchecked")  
        ensureClickBenchProvisioned();  
                    assertFalse("physical_plan must not leak an object-store URI, got: " + s, s.contains("s3://"));
        // otherwise the assertions above would vacuously pass without exercising redaction.  
    /**  
    public void testProfileReturnsDataNodeMetrics() throws IOException {  
        // The coordinator reduce (final aggregate) must report output_rows == 84.
        String physicalPlan = (String) task.get("physical_plan");
        // clickbench index has 2 shards
    public void testProfileSimpleScanHasMetricsAndPlan() throws IOException {
        assertFalse("at least one stage", stages.isEmpty());  
        Map<String, Object> result = executeExplain("source=" + DATASET.indexName + " | where num0 > 0 | fields str0");  
        assertNotNull("output_rows present in coordinator metrics", metrics.get("output_rows"));
        for (Map<String, Object> task : tasks) {
        assertNotNull("shard stage has tasks", tasks);  
        ensureClickBenchProvisioned();
                physicalPlan = s;  
/**
                if (plan instanceof String s && s.isEmpty() == false) {
    @SuppressWarnings("unchecked")
            physicalPlan.contains("AggregateExec"));
 * <p>Verifies that the explain endpoint executes the query and returns profiling information  
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");  
 * this file be licensed under the Apache-2.0 license or a
    }
        // Verify IndexedExec custom metrics proving Lucene delegation occurred
    }
        Map<String, Object> shardStage = stages.stream()
        Map<String, Object> result = executeExplain(
        assertNotNull("reduce stage has tasks", tasks);
        assertEquals("rows_matched equals 10 (10% of 100 docs)", 10L, ((Number) metrics.get("rows_matched")).longValue());
    }
        Map<String, Object> reduceStage = stages.stream()
            assertNotNull("task has node", task.get("node"));  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
            "source=" + DELEGATION.indexName + " | where status = \"active\" | fields status, value"  
    @SuppressWarnings("unchecked")
import java.util.List;
        assertNotNull("coordinator reduce task has physical_plan", physicalPlan);  
        assertTrue("physical_plan contains QueryShardExec (delegation active)",
        Request request = new Request("POST", "/_analytics/ppl");  
    public void testProfileDelegatedQueryHasFFMCollectorCalls() throws IOException {  
            .findFirst()
        if (dataProvisioned == false) {
    }
        for (Map<String, Object> task : tasks) {
        );
        }
        // Verify result count matches expected distinct groups  
        }
            List<Map<String, Object>> tasks = (List<Map<String, Object>>) stage.get("tasks");
        assertNotNull("simple scan task has physical_plan", physicalPlan);
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");
            .findFirst()  
                physicalPlan = (String) t.get("physical_plan");
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
            Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");  
        assertNotNull("tasks present", tasks);
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
            .findFirst()
            }
            .findFirst()
        // Find the COORDINATOR_REDUCE stage
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
            outputRows >= rows.size());
        assertTrue(
        assertTrue("planning_time_ms is non-negative", planningTime >= 0);
    }
    private void ensureDelegationProvisioned() throws IOException {  
    private static final Dataset DELEGATION = new Dataset("delegation", "delegation");
        ensureClickBenchProvisioned();
    @SuppressWarnings("unchecked")  
        }
            if (plan instanceof String s && s.isEmpty() == false) {
            }  
        for (Map<String, Object> stage : stages) {
}
    }
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
    }
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");  
            "ffm_collector_calls > 0 (Lucene delegation occurred)",  
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");  
        }
    protected void onBeforeQuery() throws IOException {
        Request request = new Request("POST", "/_analytics/ppl/_explain");
import java.io.IOException;
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        // Simple scan physical plan should show a scan operator and NOT use delegation
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"  
            if (m != null && m.containsKey("ffm_collector_calls")) {  
        assertNotNull("output_rows present", metrics.get("output_rows"));
        assertNotNull("at least one task has physical_plan", physicalPlan);
        boolean hasCoordinatorReduce = false;  
        assertNotNull("at least one task has data_node_metrics for simple scan", metrics);  
 * unified (or these tests are rewritten against plain plan-text), keep them on the shim.
        for (Map<String, Object> stage : stages) {
        ensureClickBenchProvisioned();
        );
        String physicalPlan = null;  
                assertNotNull("output_batches present", metrics.get("output_batches"));
    private Map<String, Object> executeExplain(String ppl) throws IOException {
            .findFirst()  
            clickBenchProvisioned = true;
     */  
        ensureClickBenchProvisioned();
            .orElseThrow(() -> new AssertionError("no COORDINATOR_REDUCE stage"));
public class ExplainApiIT extends AnalyticsRestTestCase {  
        // Multi-shard aggregation should produce at least 2 stages:  
            }
        boolean anyMetrics = false;  
     * QueryProfileBuilder redacts that path list to {@code <redacted>} while preserving the group  
        if (clickBenchProvisioned == false) {  
        // Coordinator should also have physical_plan
                    assertFalse("physical_plan must not leak a filesystem path, got: " + s, s.contains(".parquet"));  
        // Should have at least one stage  
    @SuppressWarnings("unchecked")
        }  
        Map<String, Object> result = executeExplain(  
            DatasetProvisioner.provision(client(), CLICKBENCH);
        // full_plan should contain the optimized Calcite plan as lines
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        ensureClickBenchProvisioned();
        );
            physicalPlan.contains("QueryShardExec"));  
        assertEquals("query returns 84 distinct RegionID groups", 84, rows.size());
    @SuppressWarnings("unchecked")
 * returns just the Calcite plan text with no profile wrapper. Until the explain shape is  
    public void testExplainReturnsProfileWithStages() throws IOException {
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) reduceStage.get("tasks");
                metrics = m;
        Map<String, Object> result = executeExplain("source=" + DATASET.indexName + " | fields str0, num0");  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
 * a structured {@code profile} block ({@code query_id}, {@code execution_time_ms}, per-stage
        ensureDelegationProvisioned();
            delegationProvisioned = true;  
        Map<String, Object> shardStage = stages.stream()
        boolean sawFileGroups = false;
        assertFalse("simple scan does NOT use QueryShardExec (no delegation). Plan: " + physicalPlan,  
 */
    @SuppressWarnings("unchecked")
            .orElseThrow(() -> new AssertionError("no COORDINATOR_REDUCE stage"));
        // this may reflect the leaf operator (StreamingTableExec input) rather than the root  
     * count. This guards against re-introducing the leak (local filesystem paths, or object-store
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
            physicalPlan.contains("QueryShardExec"));
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        assertNotNull("profile present", profile);
        assertTrue("execution_time_ms is positive", totalElapsed > 0);
    private static final Dataset CLICKBENCH = ClickBenchTestHelper.DATASET;  
        Map<String, Object> shardStage = stages.stream()
        List<String> fullPlan = (List<String>) profile.get("full_plan");  
 * <p>Unlike the other QA ITs in this package, this one targets the {@code test-ppl-frontend}
            assertTrue("task elapsed is non-negative", elapsed >= 0);
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");  
        );  
        Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");  
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
        for (Map<String, Object> stage : stages) {  
        Response response = client().performRequest(request);
        // Find a task with physical_plan
        assertNotNull("delegated task has physical_plan", physicalPlan);  
        Map<String, Object> result = executeWithProfile(  
/*  
     * DataFusion's file-scan Display embeds the real parquet file path(s) in {@code file_groups={...}};
            Map<String, Object> m = (Map<String, Object>) task.get("data_node_metrics");
        assertNotNull("stage_id", stage.get("stage_id"));
        assertTrue("multi-shard aggregation produces multiple stages, got " + stages.size(), stages.size() >= 2);
                assertTrue("output_rows non-negative", ((Number) metrics.get("output_rows")).longValue() >= 0);
        Map<String, Object> result = executeWithProfile(
        Map<String, Object> metrics = null;
            dataProvisioned = true;
    @SuppressWarnings("unchecked")
