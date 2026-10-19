    }  
        ensureProvisioned();
            assertTrue("Each group count must be > 0", cnt > 0);  
        List<Map<String, Object>> tasks = (List<Map<String, Object>>) shardStage.get("tasks");  
                    s.contains("mode=Partial")
                String reducePlan = (String) reduceStage.get("physical_plan");
    }
                    "shard plan must NOT contain mode=Final. Plan:\n" + s,
    }  
import java.util.List;
        String idx = CLICKBENCH.indexName;
 * Verifies shard DF physical plans use only {@code mode=Partial} for aggregate stages.
        runShardPlanCheck("all", 4, 0.0, VANILLA_QUERY);  
    }
                        "coordinator plan must contain Final or FinalPartitioned. Plan:\n" + reducePlan,
    public void testTopK_highCardinalityGroupBy_correctness() throws Exception {
        setOversampling(oversampling);  
        ensureProvisioned();  
            .findFirst()
    private void ensureProvisioned() throws Exception {
        setConcurrentSearchMode("none", 0);  
                    );  
    private void assertShardPlanPartialOnly(String ppl) throws IOException {
        req.setJsonEntity(body);
        if (provisioned == false) {  
 */
    }
        );
                        reducePlan.contains("mode=Final") || reducePlan.contains("FinalPartitioned")
        runShardPlanCheck("all", 4, 0.0, DELEGATION_QUERY);
            .ifPresent(reduceStage -> {  
                    assertTrue(  
        setOversampling(2.0);
                );  
    private void setOversampling(double factor) throws IOException {  
        runShardPlanCheck("none", 0, 2.0, DELEGATION_QUERY);  
    }
 * Tests all combinations of slice count (1, N), TopK (on, off), and scan type  
            ? "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode
            provisioned = true;
 * The OpenSearch Contributors require contributions made to  
        for (Map<String, Object> task : tasks) {  
    }  
                if (reducePlan != null && reducePlan.isEmpty() == false) {
    public void testShardPlan_slice1_topkOn_vanilla() throws Exception {
                assertTrue(
                + "\",\"search.concurrent.max_slice_count\":" + sliceCount + "}}"
            "Sum of top-K counts (" + sumTopK + ") must not exceed total (" + totalCount + ")",  
    private static final String VANILLA_QUERY = "source=" + CLICKBENCH.indexName + " | stats count() as c by RegionID | sort - c | head 10";
        runShardPlanCheck("none", 0, 0.0, VANILLA_QUERY);
    public void testShardPlan_sliceN_topkOff_vanilla() throws Exception {
                    "shard plan must NOT contain FinalPartitioned. Plan:\n" + s,
    }  
        Request request = new Request("POST", "/_analytics/ppl/_explain");  
        runShardPlanCheck("all", 4, 2.0, VANILLA_QUERY);
                );
            sumTopK <= totalCount
            "source=" + idx + " | stats count() as cnt by RegionID | sort - cnt | head 5"
        }
        client().performRequest(req);  
            .orElseThrow(() -> new AssertionError("no SHARD_FRAGMENT stage"));
        Map<String, Object> topk = executePpl(  
                );
        Request req = new Request("PUT", "/_cluster/settings");
    }
    }
    }
                    s.contains("FinalPartitioned")  
            .findFirst()  
            : "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode + "\"}}";  
        setOversampling(0.0);
        Map<String, Object> total = executePpl("source=" + idx + " | stats count()");  
    public void testShardPlan_slice1_topkOn_delegation() throws Exception {
    private static final Dataset CLICKBENCH = ClickBenchTestHelper.DATASET;  
    @SuppressWarnings("unchecked")
            Object plan = task.get("physical_plan");
            }  
        String body = sliceCount > 0  
        assertShardPlanPartialOnly(ppl);
        assertFalse("TopK must return rows", rows.isEmpty());
 * (vanilla, delegation with filter).
        }  
            DatasetProvisioner.provision(client(), CLICKBENCH, 2);
    /** Regression guard: TopK with high-cardinality group keys must produce valid counts. */  
            .filter(s -> "COORDINATOR_REDUCE".equals(s.get("execution_type")))
        assertNotNull("shard tasks present", tasks);
        runShardPlanCheck("none", 0, 0.0, DELEGATION_QUERY);
        assertTrue(
        runShardPlanCheck("none", 0, 2.0, VANILLA_QUERY);
    private void runShardPlanCheck(String searchMode, int sliceCount, double oversampling, String ppl) throws Exception {  
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        long sumTopK = rows.stream().mapToLong(r -> ((Number) r.get(0)).longValue()).sum();
        assertNotNull(rows);
    }
        stages.stream()  
import java.io.IOException;  
    private static final String DELEGATION_QUERY = "source=" + CLICKBENCH.indexName
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.analytics.qa;
            if (plan instanceof String s && s.isEmpty() == false) {
    }
                    "shard plan must contain mode=Partial. Plan:\n" + s,  
        long totalCount = ((Number) ((List<List<Object>>) total.get("datarows")).get(0).get(0)).longValue();
}  
    }
 * compatible open source license.
                    s.contains("mode=Final,") || s.contains("mode=Final ")
                }
        + " | where URL = 'https://opensearch.org' | stats count() as c by Title | sort - c | head 10";  
            });
/*  
        setConcurrentSearchMode("all", 4);
    @SuppressWarnings("unchecked")
    private void setConcurrentSearchMode(String mode, int sliceCount) throws IOException {
import org.opensearch.client.Request;
        assertNotNull("profile present", profile);
        req.setJsonEntity("{\"transient\":{\"analytics.shard_bucket_oversampling_factor\":" + factor + "}}");
        Request req = new Request("PUT", "/_cluster/settings");
    public void testShardPlan_sliceN_topkOn_vanilla() throws Exception {  
        List<List<Object>> rows = (List<List<Object>>) topk.get("datarows");  
        client().performRequest(req);  
        for (List<Object> row : rows) {
    private static volatile boolean provisioned = false;
 */  
            .filter(s -> "SHARD_FRAGMENT".equals(s.get("execution_type")))
        setConcurrentSearchMode(searchMode, sliceCount);
        Map<String, Object> result = assertOkAndParse(client().performRequest(request), "EXPLAIN: " + ppl);
/**
            long cnt = ((Number) row.get(0)).longValue();
                assertFalse(
 * this file be licensed under the Apache-2.0 license or a
    public void testShardPlan_slice1_topkOff_vanilla() throws Exception {  
        }
    public void testShardPlan_sliceN_topkOn_delegation() throws Exception {
import java.util.Map;
    public void testShardPlan_slice1_topkOff_delegation() throws Exception {
public class PartialAggregateModeIT extends AnalyticsRestTestCase {  
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
    @SuppressWarnings("unchecked")
 *
                assertFalse(  
        Map<String, Object> shardStage = stages.stream()
        );
        runShardPlanCheck("all", 4, 2.0, DELEGATION_QUERY);
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");  
    public void testShardPlan_sliceN_topkOff_delegation() throws Exception {  
