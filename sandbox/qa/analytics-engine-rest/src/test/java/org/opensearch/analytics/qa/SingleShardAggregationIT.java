    // ── Additional aggregate shapes ─────────────────────────────────────────────
        List<List<Object>> actualRows = (List<List<Object>>) actual.get("datarows");  
        req.setJsonEntity("{\"transient\":{\"analytics.shard_bucket_oversampling_factor\":" + factor + "}}");
        assertNoCoordinatorReduce(DELEGATION_QUERY);
            return String.format(Locale.ROOT, "%s: one side null", label);
        req.setJsonEntity(body);
        // Test: apply settings
    public void testSliceN_topkOn_vanilla() throws Exception {
    }  
        runCheck("none", 0, 0.0, VANILLA_QUERY);  
    }
        + " | where GoodEvent = 1 AND Age > 0 | stats count() as cnt by OS | where cnt > 5";
        }  
            + " | where GoodEvent = 1"
    }  
        runCheck("all", 4, 0.0, "source=" + IDX  
            + " | stats count() as cnt, sum(Income) as total by OS, Age"
        }  
    public void testSliceN_multiAgg_vanilla() throws Exception {
    }
            provisioned = true;
    // ── Core test logic ─────────────────────────────────────────────────────────  
        assertNoCoordinatorReduce(VANILLA_QUERY);
    }  
        Request req = new Request("PUT", "/_cluster/settings");  
import java.util.Locale;  
        if (expectedRows == null || actualRows == null) {  
    }
    public void testSlice1_topkOff_delegation() throws Exception {  
    }
    private void assertNoCoordinatorReduce(String ppl) throws IOException {
            : "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode + "\"}}";
            + " | where cnt > 1");  
        client().performRequest(req);
        Request req = new Request("PUT", "/_cluster/settings");  
            DatasetProvisioner.provision(client(), CLICKBENCH_1SHARD, 1);
 * this file be licensed under the Apache-2.0 license or a
    private static final String DELEGATION_QUERY = "source=" + IDX
    // ── slice=1, topk off ───────────────────────────────────────────────────────  
        List<String> a = actualRows.stream().map(Object::toString).sorted()
 * Single-shard aggregation correctness. On a 1-shard index the planner keeps the aggregate
        assertNotNull("stages present", stages);
    public void testSliceN_topkOff_vanilla() throws Exception {
    public void testPlanShape_noCoordinatorReduce_delegation() throws Exception {
            .anyMatch(s -> "COORDINATOR_REDUCE".equals(s.get("execution_type")));
    }
        setOversampling(0.0);  
        }
        assertFalse("Single-shard must not have COORDINATOR_REDUCE stage", hasReduce);
        if (expectedRows == null && actualRows == null) return null;
/*  
        Map<String, Object> test = executePpl(ppl);
 */  
        runCheck("all", 4, 0.0, DELEGATION_QUERY);  
    public void testSlice1_topkOn_vanilla() throws Exception {  
    private static volatile boolean provisioned = false;
    }  
            + " | stats avg(Age) as avg_age, sum(Income) as total, count() as cnt by OS"
    // ── Plan shape: no coordinator reduce ───────────────────────────────────────
        List<List<Object>> expectedRows = (List<List<Object>>) expected.get("datarows");
            if (!e.get(i).equals(a.get(i))) {
                + "\",\"search.concurrent.max_slice_count\":" + sliceCount + "}}"
    // ── slice=N, topk off ───────────────────────────────────────────────────────
        List<String> e = expectedRows.stream().map(Object::toString).sorted()
            .collect(java.util.stream.Collectors.toList());  
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        boolean hasReduce = stages.stream()  
        if (expectedRows.size() != actualRows.size()) {  
        return null;
    // Delegation scan — keyword equality delegated to indexed table provider  
import java.util.ArrayList;
    private String compareResults(Map<String, Object> expected, Map<String, Object> actual, String label) {
        setOversampling(oversampling);
    // ── Helpers ──────────────────────────────────────────────────────────────────
    private static final String DELEGATION_TOPK_QUERY = "source=" + IDX  
        runCheck("none", 0, 2.0, DELEGATION_TOPK_QUERY);
        setConcurrentSearchMode("none", 0);
    private void runCheck(String mode, int sliceCount, double oversampling, String ppl) throws Exception {
            ? "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode  
import java.util.List;
        Map<String, Object> result = assertOkAndParse(client().performRequest(request), "EXPLAIN: " + ppl);
    private static final String VANILLA_QUERY = "source=" + IDX
        assertNotNull("profile present", profile);
 * The OpenSearch Contributors require contributions made to  
                label, expectedRows.size(), actualRows.size());
package org.opensearch.analytics.qa;
    private static final String IDX = CLICKBENCH_1SHARD.indexName;
    @SuppressWarnings("unchecked")  
        Request request = new Request("POST", "/_analytics/ppl/_explain");  
        // Reset
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
import org.opensearch.client.Request;
        runCheck("all", 4, 2.0, VANILLA_TOPK_QUERY);  
            fail("Single-shard mismatch [mode=" + mode + ", slice=" + sliceCount
            .collect(java.util.stream.Collectors.toList());
        if (diff != null) {  
    }
                + ", topk=" + (oversampling > 0) + "]: " + diff);
            }
            + " | where GoodEvent = 1 AND Income > 0"  
    }
    }
public class SingleShardAggregationIT extends AnalyticsRestTestCase {
    public void testSlice1_topkOn_delegation() throws Exception {
        if (provisioned == false) {  
        setConcurrentSearchMode(mode, sliceCount);  
    }  
 * combinations of: partitions (1, N), TopK (off, on), scan type (vanilla, delegation).  
        runCheck("none", 0, 2.0, VANILLA_TOPK_QUERY);
    @SuppressWarnings("unchecked")  
                    label, i, e.get(i), a.get(i));
    }
        // Baseline: concurrent off, topk off  
 * compatible open source license.
    // Vanilla DF scan — numeric filters only  
    public void testSliceN_topkOff_delegation() throws Exception {
    public void testSliceN_topkOn_delegation() throws Exception {  
 * as SINGLE (no PARTIAL/FINAL split). Verifies group-by results are identical across all
    private static final String VANILLA_TOPK_QUERY = "source=" + IDX  
    // ── slice=N, topk on ────────────────────────────────────────────────────────  
        }  
}
    private void setOversampling(double factor) throws IOException {
        + " | sort - cnt, RegionID | head 5";
        }  
        String diff = compareResults(baseline, test, ppl);
            + " | where avg_age > 20 AND cnt > 5");
        setConcurrentSearchMode("none", 0);
        + " | where GoodEvent = 1 AND Age > 0 | stats count() as cnt by OS | sort - cnt, OS | head 5";
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");  
    }
        runCheck("none", 0, 0.0, DELEGATION_QUERY);
        Map<String, Object> baseline = executePpl(ppl);  
    private static final Dataset CLICKBENCH_1SHARD = new Dataset("clickbench", "clickbench_1shard");
    private void setConcurrentSearchMode(String mode, int sliceCount) throws IOException {
    }
        setConcurrentSearchMode("none", 0);
        String body = sliceCount > 0
    // ── slice=1, topk on ────────────────────────────────────────────────────────
    }
/**  
            return String.format(Locale.ROOT, "%s: row count — baseline=%d, test=%d",
    public void testSlice1_topkOff_vanilla() throws Exception {
import java.io.IOException;  
        setConcurrentSearchMode("all", 4);
        runCheck("all", 4, 2.0, DELEGATION_TOPK_QUERY);
 *
        runCheck("all", 4, 0.0, VANILLA_QUERY);
    public void testSliceN_multiGroupKey_vanilla() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
    protected void onBeforeQuery() throws IOException {
        setOversampling(0.0);
        + " | where Title = 'Search Results' AND GoodEvent = 1 | stats count() as cnt by RegionID | where cnt > 1";
    public void testPlanShape_noCoordinatorReduce_vanilla() throws Exception {  
    }  
 */
    @Override
        client().performRequest(req);
import java.util.Map;
        runCheck("all", 4, 0.0, "source=" + IDX
        for (int i = 0; i < e.size(); i++) {
        + " | where Title = 'Search Results' AND GoodEvent = 1 | stats count() as cnt by RegionID"
                return String.format(Locale.ROOT, "%s: row %d — baseline=%s, test=%s",  
