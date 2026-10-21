        + " | where URL = 'https://opensearch.org' | stats count() as c by Title | sort - c | head 10";
    @SuppressWarnings("unchecked")
            ? "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode
    }
package org.opensearch.analytics.qa;
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        runShardPlanCheck("all", 4, 0.0, DELEGATION_QUERY);
            : "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode + "\"}}";
        }
    private void setOversampling(double factor) throws IOException {
        }
    private static volatile boolean provisioned = false;
                    "shard plan must NOT contain FinalPartitioned. Plan:\n" + s,
                        reducePlan.contains("mode=Final") || reducePlan.contains("FinalPartitioned")
        if (provisioned == false) {
        );
        runShardPlanCheck("all", 4, 2.0, VANILLA_QUERY);
 * this file be licensed under the Apache-2.0 license or a
    public void testShardPlan_sliceN_topkOn_vanilla() throws Exception {
    private void setConcurrentSearchMode(String mode, int sliceCount) throws IOException {
        long totalCount = ((Number) ((List<List<Object>>) total.get("datarows")).get(0).get(0)).longValue();
import org.opensearch.client.Request;
    public void testShardPlan_sliceN_topkOff_vanilla() throws Exception {
                    s.contains("mode=Final,") || s.contains("mode=Final ")
            .ifPresent(reduceStage -> {
    }
                if (reducePlan != null && reducePlan.isEmpty() == false) {
 * SPDX-License-Identifier: Apache-2.0
                    "shard plan must contain mode=Partial. Plan:\n" + s,
    public void testShardPlan_slice1_topkOff_delegation() throws Exception {
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
        Map<String, Object> result = assertOkAndParse(client().performRequest(request), "EXPLAIN: " + ppl);
        assertTrue(
            .filter(s -> "COORDINATOR_REDUCE".equals(s.get("execution_type")))
        Request req = new Request("PUT", "/_cluster/settings");
        );
        assertFalse("TopK must return rows", rows.isEmpty());
    public void testTopK_highCardinalityGroupBy_correctness() throws Exception {
    @SuppressWarnings("unchecked")
        req.setJsonEntity("{\"transient\":{\"analytics.shard_bucket_oversampling_factor\":" + factor + "}}");
            sumTopK <= totalCount
        ensureProvisioned();
import java.util.Map;
    }
            .findFirst()
        runShardPlanCheck("all", 4, 0.0, VANILLA_QUERY);
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
    private static final String VANILLA_QUERY = "source=" + CLICKBENCH.indexName + " | stats count() as c by RegionID | sort - c | head 10";
    public void testShardPlan_sliceN_topkOff_delegation() throws Exception {
                );
    private static final Dataset CLICKBENCH = ClickBenchTestHelper.DATASET;
            });
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
    private void assertShardPlanPartialOnly(String ppl) throws IOException {
        assertNotNull(rows);
    }
    }
                    s.contains("mode=Partial")
                String reducePlan = (String) reduceStage.get("physical_plan");
    }
    @SuppressWarnings("unchecked")
    }
                );
        long sumTopK = rows.stream().mapToLong(r -> ((Number) r.get(0)).longValue()).sum();
        setConcurrentSearchMode("all", 4);
    public void testShardPlan_slice1_topkOn_vanilla() throws Exception {
                    s.contains("FinalPartitioned")
        String idx = CLICKBENCH.indexName;
    private static final String DELEGATION_QUERY = "source=" + CLICKBENCH.indexName
                + "\",\"search.concurrent.max_slice_count\":" + sliceCount + "}}"
                assertTrue(
        setOversampling(0.0);
            }
                assertFalse(
    }
        runShardPlanCheck("none", 0, 2.0, VANILLA_QUERY);
/*
            long cnt = ((Number) row.get(0)).longValue();
        assertNotNull("shard tasks present", tasks);
import java.util.List;
    }
    }
/**
        stages.stream()
        assertNotNull("profile present", profile);
    /** Regression guard: TopK with high-cardinality group keys must produce valid counts. */
            "Sum of top-K counts (" + sumTopK + ") must not exceed total (" + totalCount + ")",
                    );
 * compatible open source license.
                    assertTrue(
        req.setJsonEntity(body);
        setConcurrentSearchMode("none", 0);
            Object plan = task.get("physical_plan");
        List<List<Object>> rows = (List<List<Object>>) topk.get("datarows");
    public void testShardPlan_slice1_topkOff_vanilla() throws Exception {
    private void ensureProvisioned() throws Exception {
 */
    }
                assertFalse(
    public void testShardPlan_slice1_topkOn_delegation() throws Exception {
        runShardPlanCheck("none", 0, 2.0, DELEGATION_QUERY);
        Request request = new Request("POST", "/_analytics/ppl/_explain");
    }
public class PartialAggregateModeIT extends AnalyticsRestTestCase {
            "source=" + idx + " | stats count() as cnt by RegionID | sort - cnt | head 5"
        setOversampling(oversampling);
            if (plan instanceof String s && s.isEmpty() == false) {
                }
 * The OpenSearch Contributors require contributions made to
            assertTrue("Each group count must be > 0", cnt > 0);
        assertShardPlanPartialOnly(ppl);
        ensureProvisioned();
        setConcurrentSearchMode(searchMode, sliceCount);
                        "coordinator plan must contain Final or FinalPartitioned. Plan:\n" + reducePlan,
        Map<String, Object> topk = executePpl(
 * (vanilla, delegation with filter).
        Map<String, Object> total = executePpl("source=" + idx + " | stats count()");
            DatasetProvisioner.provision(client(), CLICKBENCH, 2);
        String body = sliceCount > 0
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        for (Map<String, Object> task : tasks) {
        runShardPlanCheck("none", 0, 0.0, VANILLA_QUERY);
    public void testShardPlan_sliceN_topkOn_delegation() throws Exception {
 * Tests all combinations of slice count (1, N), TopK (on, off), and scan type
        Map<String, Object> shardStage = stages.stream()
        setOversampling(2.0);
}
    }
    private void runShardPlanCheck(String searchMode, int sliceCount, double oversampling, String ppl) throws Exception {
                );
        runShardPlanCheck("all", 4, 2.0, DELEGATION_QUERY);
        client().performRequest(req);
 *
 */
            .findFirst()
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");
        runShardPlanCheck("none", 0, 0.0, DELEGATION_QUERY);
        Request req = new Request("PUT", "/_cluster/settings");
        for (List<Object> row : rows) {
import java.io.IOException;
            provisioned = true;
 * Verifies shard DF physical plans use only {@code mode=Partial} for aggregate stages.
                    "shard plan must NOT contain mode=Final. Plan:\n" + s,
    }
        client().performRequest(req);
        }
