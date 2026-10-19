        Map<String, Object> result = executeExplain("source=" + DATASET.indexName + " | fields str0");
        assertNotNull("index_query_time present", metrics.get("index_query_time"));
            .orElseThrow(() -> new AssertionError("no COORDINATOR_REDUCE stage"));
        // Each stage should have required fields
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
        assertNotNull("simple scan task has physical_plan", physicalPlan);
        assertTrue(
        assertNotNull("rows present", result.get("rows"));
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
        // Sanity: this query scans parquet, so at least one scan node with file_groups must exist —
            assertTrue("task elapsed is non-negative", elapsed >= 0);
        assertNotNull("profile present", profile);
        assertNotNull("stage_id", stage.get("stage_id"));
 */
    private static boolean delegationProvisioned = false;
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        // Find a task with physical_plan
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
                        assertTrue("file_groups must be redacted, got: " + s, s.contains("<redacted>"));
        }
            for (Map<String, Object> task : tasks) {
            Map<String, Object> m = (Map<String, Object>) t.get("data_node_metrics");
    }
        assertFalse("at least one stage", stages.isEmpty());
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
        assertTrue("plan mentions table scan", planText.contains("TableScan") || planText.contains("Scan"));
        Map<String, Object> reduceStage = stages.stream()
        return assertOkAndParse(response, "PROFILE: " + ppl);
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
    }
        assertNotNull("profile present", profile);
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
                assertTrue("output_rows non-negative", ((Number) metrics.get("output_rows")).longValue() >= 0);
    }
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        String physicalPlan = null;
        String physicalPlan = (String) task.get("physical_plan");
        Map<String, Object> shardStage = stages.stream()
    private static boolean dataProvisioned = false;
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) reduceStage.get("tasks");
        Map<String, Object> result = executeWithProfile(
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
    }
        ensureClickBenchProvisioned();
    private static final Dataset DELEGATION = new Dataset("delegation", "delegation");
        Request request = new Request("POST", "/_analytics/ppl/_explain");
        assertEquals("rows_matched equals 10 (10% of 100 docs)", 10L, ((Number) metrics.get("rows_matched")).longValue());
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        }
    @SuppressWarnings("unchecked")
        ensureClickBenchProvisioned();
            if (tasks == null) {
        Map<String, Object> task = tasks.get(0);
    @SuppressWarnings("unchecked")
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\", \"profile\": true}");
        assertNotNull("coordinator metrics present", metrics);
 * <p>Unlike the other QA ITs in this package, this one targets the {@code test-ppl-frontend}
                    assertFalse("physical_plan must not leak an object-store URI, got: " + s, s.contains("s3://"));
    @SuppressWarnings("unchecked")
            physicalPlan.contains("QueryShardExec"));
        );
 * unified (or these tests are rewritten against plain plan-text), keep them on the shim.
        assertNotNull("stages present", stages);
        assertNotNull("full_plan present", fullPlan);
        assertNotNull("columns present", result.get("columns"));
        Map<String, Object> stage = stages.get(0);
        // Simple scan has a SHARD_FRAGMENT stage but no COORDINATOR_REDUCE
        assertNotNull("profile present", profile);
        Map<String, Object> shardStage = stages.stream()
        assertNotNull("row_groups_processed present", metrics.get("row_groups_processed"));
        // Find the COORDINATOR_REDUCE stage
        assertNotNull("execution_time_ms present", profile.get("execution_time_ms"));
                assertNotNull("output_batches present", metrics.get("output_batches"));
    public void testExplainReturnsProfileWithStages() throws IOException {
        assertTrue("execution_time_ms is positive", totalElapsed > 0);
    }
            String execType = (String) stage.get("execution_type");
        assertTrue("shard stage has at least 2 tasks (one per shard), got " + tasks.size(), tasks.size() >= 2);
/*
 * The OpenSearch Contributors require contributions made to
        assertNotNull("profile present", profile);
            assertTrue("elapsed is non-negative", elapsed >= 0);
        assertNotNull("output_rows present in coordinator metrics", metrics.get("output_rows"));
                break;
        assertNotNull("tasks present", tasks);
import org.opensearch.client.Request;
        }
        // Verify result count matches expected distinct groups
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
        assertNotNull("delegated task has physical_plan", physicalPlan);
    }
        assertTrue("coordinator output_rows is positive and >= result count",
            }
        // Verify IndexedExec custom metrics proving Lucene delegation occurred
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) reduceStage.get("tasks");
    @SuppressWarnings("unchecked")
        assertTrue("has COORDINATOR_REDUCE stage", hasCoordinatorReduce);
            long elapsed = ((Number) task.get("elapsed_ms")).longValue();
        }
    @SuppressWarnings("unchecked")
                continue;
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");
            long elapsed = ((Number) stage.get("elapsed_ms")).longValue();
        Map<String, Object> result = executeExplain(
        assertNotNull("at least one task has data_node_metrics with ffm_collector_calls", metrics);
            .findFirst()
        // Verify we have both a SHARD_FRAGMENT and a COORDINATOR_REDUCE stage
 * this file be licensed under the Apache-2.0 license or a
        // Collect every physical_plan string across all stages/tasks — redaction must hold everywhere,
        }
        assertFalse("physical_plan does NOT contain QueryShardExec (no delegation)",
            .filter(s -> "COORDINATOR_REDUCE".equals(s.get("execution_type")))
            DatasetProvisioner.provision(client(), DATASET);
    @SuppressWarnings("unchecked")
            if (plan instanceof String s && s.isEmpty() == false) {
                    // No absolute filesystem path or object-store URI should survive redaction.
            .findFirst()
        );
        Map<String, Object> result = executeWithProfile(
            }
 * compatible open source license.
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        );
        assertNotNull("query_id present", profile.get("query_id"));
        Map<String, Object> task = tasks.get(0);
        }
        // SHARD_FRAGMENT (partial aggregate on data nodes) + COORDINATOR_REDUCE (final aggregate)
    @SuppressWarnings("unchecked")
        assertNotNull("profile present", profile);
        String physicalPlan = null;
        // full_plan should contain the optimized Calcite plan as lines
    @Override
        Response response = client().performRequest(request);
    public void testProfileReturnsPhysicalPlan() throws IOException {
                        // The redaction marker replaces the path list but keeps the group count.
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
            Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
            .findFirst()
            .findFirst()
        Map<String, Object> result = executeWithProfile(
            }
        String planText = String.join("\n", fullPlan);
        // Find a task with metrics
        assertNotNull("stages present", stages);
        boolean hasShardFragment = false;
    public void testProfileCoordinatorOutputRowsMatchesResultCount() throws IOException {
        if (delegationProvisioned == false) {
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
        Map<String, Object> result = executeExplain("source=" + DATASET.indexName + " | fields str0, num0");
                metrics = m;
        assertNotNull("tasks present", tasks);
    }
        long outputRows = ((Number) metrics.get("output_rows")).longValue();
    }
        Map<String, Object> result = executeWithProfile(
        // clickbench index has 2 shards
        assertNotNull("rows_matched present", metrics.get("rows_matched"));
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        Map<String, Object> result = executeExplain(
            List<Map<String, Object>> tasks = (List<Map<String, Object>>) stage.get("tasks");
                    assertFalse("physical_plan must not leak a filesystem path, got: " + s, s.contains(".parquet"));
 * Integration test for {@code POST /_analytics/ppl/_explain}.
        String physicalPlan = null;
            clickBenchProvisioned = true;
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
            outputRows >= rows.size());
import org.opensearch.client.Response;
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
        );
        Map<String, Object> result = executeWithProfile(
 *
            if ("COORDINATOR_REDUCE".equals(execType)) hasCoordinatorReduce = true;
        assertFalse("reduce stage has at least one task", tasks.isEmpty());
        for (Map<String, Object> task : tasks) {
        for (Map<String, Object> task : tasks) {
        return assertOkAndParse(response, "EXPLAIN: " + ppl);
    public void testExplainWithAggregationShowsMultipleStages() throws IOException {
                Object plan = task.get("physical_plan");
            "ffm_collector_calls > 0 (Lucene delegation occurred)",
    }
        assertEquals("query returns 84 distinct RegionID groups", 84, rows.size());
    public void testProfileSimpleScanHasMetricsAndPlan() throws IOException {
            if (m != null && m.containsKey("ffm_collector_calls")) {
        // Plan should reference the table being scanned
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        for (Map<String, Object> task : tasks) {
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
    public void testProfileCoordinatorReduceHasMetrics() throws IOException {
        Map<String, Object> shardStage = stages.stream()
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
            physicalPlan.contains("QueryShardExec"));
    }
        assertNotNull("profile present", profile);
        boolean sawFileGroups = false;
        assertNotNull("reduce stage has tasks", tasks);
import java.io.IOException;
        );
        assertTrue("planning_time_ms is non-negative", planningTime >= 0);
    protected void onBeforeQuery() throws IOException {
    private Map<String, Object> executeWithProfile(String ppl) throws IOException {
 * timing) that these tests assert against; the real plugin's {@code /_plugins/_ppl/_explain}
    public void testExplainTotalElapsedIsPositive() throws IOException {
            physicalPlan.contains("QueryShardExec"));
        Map<String, Object> result = executeWithProfile("source=" + DATASET.indexName + " | fields str0, num0");
        // Should have profile section
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
        assertTrue("has SHARD_FRAGMENT stage", hasShardFragment);
    private static boolean clickBenchProvisioned = false;
                break;
import java.util.Map;
        Map<String, Object> shardStage = stages.stream()
        Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
    }
        ensureClickBenchProvisioned();
import java.util.List;
        for (Map<String, Object> stage : stages) {
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");
        for (Map<String, Object> task : tasks) {
     * DataFusion's file-scan Display embeds the real parquet file path(s) in {@code file_groups={...}};
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
                if (plan instanceof String s && s.isEmpty() == false) {
    private static final Dataset CLICKBENCH = ClickBenchTestHelper.DATASET;
 * <p>Verifies that the explain endpoint executes the query and returns profiling information
        List<String> fullPlan = (List<String>) profile.get("full_plan");
        ensureClickBenchProvisioned();
    private void ensureDelegationProvisioned() throws IOException {
        ensureDelegationProvisioned();
        }
    }
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        assertTrue("physical_plan contains QueryShardExec (delegation active)",
        );
                physicalPlan = (String) t.get("physical_plan");
    private void ensureClickBenchProvisioned() throws IOException {
                anyMetrics = true;
            assertNotNull("task has node", task.get("node"));
            if ("SHARD_FRAGMENT".equals(execType)) hasShardFragment = true;
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
        assertNotNull("shard stage has tasks", tasks);
 * shim rather than the real {@code opensearch-sql} plugin. The shim's explain output ships
        // Multi-shard aggregation should produce at least 2 stages:
        assertNotNull("tasks present", tasks);
        }
        long totalElapsed = ((Number) profile.get("execution_time_ms")).longValue();
            DatasetProvisioner.provision(client(), DELEGATION);
        // Find a task with data_node_metrics (some shards may be empty on multi-node clusters)
        );
        }
        Map<String, Object> result = executeExplain("source=" + DATASET.indexName + " | where num0 > 0 | fields str0");
        // this may reflect the leaf operator (StreamingTableExec input) rather than the root
            .filter(s -> "COORDINATOR_REDUCE".equals(s.get("execution_type")))
                physicalPlan = (String) task.get("physical_plan");
            if (m != null) {
                    }
        assertNotNull("coordinator reduce task has data_node_metrics", metrics);
            .orElseThrow(() -> new AssertionError("no COORDINATOR_REDUCE stage"));
        // Find the SHARD_FRAGMENT stage and verify it has tasks (one per shard)
                break;
            ((Number) metrics.get("ffm_collector_calls")).longValue() > 0
        assertTrue("output_rows > 0", ((Number) metrics.get("output_rows")).longValue() > 0);
        // Simple scan physical plan should show a scan operator and NOT use delegation
        }
                        sawFileGroups = true;
    @SuppressWarnings("unchecked")
        assertNotNull("tasks present", tasks);
                metrics = m;
     * Verifies that the physical_plan surfaced by profile=true does NOT leak storage locations.
        Map<String, Object> reduceStage = stages.stream()
    public void testExplainMultiStageShardFragmentHasTasks() throws IOException {
    @SuppressWarnings("unchecked")
        List<Object> rows = (List<Object>) result.get("rows");
     */
        Map<String, Object> result = executeWithProfile(
    }
public class ExplainApiIT extends AnalyticsRestTestCase {
            .findFirst()
        Response response = client().performRequest(request);
        assertNotNull("profile present", profile);
            .findFirst()
        for (Map<String, Object> t : tasks) {
        assertNotNull("state", stage.get("state"));
package org.opensearch.analytics.qa;
        Map<String, Object> metrics = (Map<String, Object>) task.get("data_node_metrics");
 * a structured {@code profile} block ({@code query_id}, {@code execution_time_ms}, per-stage
        }
            delegationProvisioned = true;
        assertFalse("simple scan does NOT use QueryShardExec (no delegation). Plan: " + physicalPlan,
        long planningTime = ((Number) profile.get("planning_time_ms")).longValue();
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
        // ClickBench has 100 docs with 84 distinct RegionID values across 2 shards.
                assertNotNull("output_rows present", metrics.get("output_rows"));
            Object plan = task.get("physical_plan");
 * SPDX-License-Identifier: Apache-2.0
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
 */
        );
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");
    }
    public void testProfileReturnsDataNodeMetrics() throws IOException {
    /**
            if (metrics != null) {
    public void testProfilePhysicalPlanRedactsStoragePaths() throws IOException {
        for (Map<String, Object> stage : stages) {
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    @SuppressWarnings("unchecked")
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
    }
    }
        if (dataProvisioned == false) {
        Request request = new Request("POST", "/_analytics/ppl");
    public void testProfileDelegatedQueryHasFFMCollectorCalls() throws IOException {
}
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
        if (clickBenchProvisioned == false) {
                assertNotNull("elapsed_compute present", metrics.get("elapsed_compute"));
        // (final aggregate output). Assert it's positive and >= actual result count.
     * count. This guards against re-introducing the leak (local filesystem paths, or object-store
        // Non-delegation path: shard plan uses standard ParquetExec with AggregateExec
                physicalPlan = s;
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        Map<String, Object> shardStage = stages.stream()
        boolean hasCoordinatorReduce = false;
        // otherwise the assertions above would vacuously pass without exercising redaction.
        ensureClickBenchProvisioned();
            }
    @SuppressWarnings("unchecked")
 *
    public void testExplainReturnsFullPlan() throws IOException {
        // Coordinator should also have physical_plan
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
    private Map<String, Object> executeExplain(String ppl) throws IOException {
            dataProvisioned = true;
        assertTrue("expected at least one file_groups scan node in the profile", sawFileGroups);
        assertTrue("multi-shard aggregation produces multiple stages, got " + stages.size(), stages.size() >= 2);
     * QueryProfileBuilder redacts that path list to {@code <redacted>} while preserving the group
 * returns just the Calcite plan text with no profile wrapper. Until the explain shape is
        boolean anyMetrics = false;
            DatasetProvisioner.provision(client(), CLICKBENCH);
        Map<String, Object> metrics = null;
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
            }
        assertNotNull("coordinator reduce task has physical_plan", physicalPlan);
    }
    @SuppressWarnings("unchecked")
            .findFirst()
        // output_rows from the coordinator's reduce plan. Due to the flat-map tree walk,
     * URIs/keys on S3/GCS/Azure-backed indices) into an API any query-authorized caller can hit.
        assertFalse("has tasks", tasks.isEmpty());
                    assertFalse("physical_plan must not leak a data dir path, got: " + s, s.contains("/nodes/"));
            "source=" + CLICKBENCH.indexName + " | stats avg(AdvEngineID) by RegionID"
            assertEquals("stage succeeded", "SUCCEEDED", stage.get("state"));
        assertNotNull("profile present", profile);
        ensureClickBenchProvisioned();
            physicalPlan.contains("AggregateExec"));
            assertEquals("task finished", "FINISHED", task.get("state"));
        assertNotNull("execution_type", stage.get("execution_type"));
/**
        assertNotNull("profile present", profile);
        assertFalse("full_plan not empty", fullPlan.isEmpty());
        );
        // Verify the physical plan shows IndexedExec (delegation operator)
            "source=" + DELEGATION.indexName + " | where status = \"active\" | fields status, value"
                }
            Map<String, Object> m = (Map<String, Object>) task.get("data_node_metrics");
        assertNotNull("elapsed_ms", stage.get("elapsed_ms"));
 *
        assertNotNull("at least one task has data_node_metrics for simple scan", metrics);
        assertNotNull("at least one task has physical_plan", physicalPlan);
        ensureClickBenchProvisioned();
            }
        Map<String, Object> result = executeExplain("source=" + DATASET.indexName + " | fields str0");
                    if (s.contains("file_groups=")) {
        assertFalse("has tasks", tasks.isEmpty());
        assertNotNull("output_rows present", metrics.get("output_rows"));
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");
        // The coordinator reduce (final aggregate) must report output_rows == 84.
        assertTrue("physical_plan contains AggregateExec operator",
        // Should have normal query results
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        // Should have at least one stage
 * (stage timings, plan) alongside the normal results.
    public void testExplainStagesShowSucceededState() throws IOException {
        assertTrue("at least one task has data_node_metrics", anyMetrics);
    }
        for (Map<String, Object> stage : stages) {
    @SuppressWarnings("unchecked")
        // not just on the one stage the happy-path test happens to inspect.
        Map<String, Object> metrics = null;
