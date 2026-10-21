}
        }
        if (expectedRows.size() != actualRows.size()) {
 * compatible open source license.
        }
        Map<String, Object> result = assertOkAndParse(client().performRequest(request), "EXPLAIN: " + ppl);
        setOversampling(oversampling);
            fail("Single-shard mismatch [mode=" + mode + ", slice=" + sliceCount
        setConcurrentSearchMode("all", 4);
                label, expectedRows.size(), actualRows.size());
        client().performRequest(req);
package org.opensearch.analytics.qa;
    // Vanilla DF scan — numeric filters only
        // Baseline: concurrent off, topk off
        boolean hasReduce = stages.stream()
    }
        runCheck("all", 4, 0.0, DELEGATION_QUERY);
    }
    }
        Request req = new Request("PUT", "/_cluster/settings");
            }
import java.util.Locale;
    @Override
 *
    }
            + " | stats count() as cnt, sum(Income) as total by OS, Age"
    private static final String VANILLA_QUERY = "source=" + IDX
        Request request = new Request("POST", "/_analytics/ppl/_explain");
    private static final String DELEGATION_TOPK_QUERY = "source=" + IDX
        + " | where Title = 'Search Results' AND GoodEvent = 1 | stats count() as cnt by RegionID"
    }
    public void testSliceN_topkOff_delegation() throws Exception {
        client().performRequest(req);
 * combinations of: partitions (1, N), TopK (off, on), scan type (vanilla, delegation).
        // Test: apply settings
    // ── Core test logic ─────────────────────────────────────────────────────────
    // ── Helpers ──────────────────────────────────────────────────────────────────
    }
        // Reset
import java.io.IOException;
        + " | where GoodEvent = 1 AND Age > 0 | stats count() as cnt by OS | sort - cnt, OS | head 5";
    public void testSlice1_topkOff_delegation() throws Exception {
        runCheck("all", 4, 0.0, "source=" + IDX
 * as SINGLE (no PARTIAL/FINAL split). Verifies group-by results are identical across all
 */
    }
            + " | where cnt > 1");
            + " | where avg_age > 20 AND cnt > 5");
    }
        runCheck("all", 4, 0.0, VANILLA_QUERY);
            if (!e.get(i).equals(a.get(i))) {
    private static volatile boolean provisioned = false;
    // ── slice=N, topk on ────────────────────────────────────────────────────────
    }
    }
    }
    @SuppressWarnings("unchecked")
                + ", topk=" + (oversampling > 0) + "]: " + diff);
            + " | stats avg(Age) as avg_age, sum(Income) as total, count() as cnt by OS"
        }
        runCheck("all", 4, 2.0, VANILLA_TOPK_QUERY);
        if (diff != null) {
    public void testSliceN_topkOn_delegation() throws Exception {
    protected void onBeforeQuery() throws IOException {
        }
    private void assertNoCoordinatorReduce(String ppl) throws IOException {
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
    // Delegation scan — keyword equality delegated to indexed table provider
    public void testPlanShape_noCoordinatorReduce_delegation() throws Exception {
        req.setJsonEntity("{\"transient\":{\"analytics.shard_bucket_oversampling_factor\":" + factor + "}}");
        return null;
        if (expectedRows == null || actualRows == null) {
        assertNoCoordinatorReduce(VANILLA_QUERY);
    private String compareResults(Map<String, Object> expected, Map<String, Object> actual, String label) {
    @SuppressWarnings("unchecked")
 */
 * this file be licensed under the Apache-2.0 license or a
        runCheck("all", 4, 2.0, DELEGATION_TOPK_QUERY);
            return String.format(Locale.ROOT, "%s: row count — baseline=%d, test=%d",
        setConcurrentSearchMode(mode, sliceCount);
    }
    public void testSliceN_multiAgg_vanilla() throws Exception {
    }
            provisioned = true;
        runCheck("none", 0, 0.0, VANILLA_QUERY);
    // ── slice=1, topk off ───────────────────────────────────────────────────────
        List<List<Object>> expectedRows = (List<List<Object>>) expected.get("datarows");
/*
        setConcurrentSearchMode("none", 0);
        assertNotNull("stages present", stages);
    // ── Additional aggregate shapes ─────────────────────────────────────────────
        String body = sliceCount > 0
        }
        runCheck("none", 0, 2.0, VANILLA_TOPK_QUERY);
        Request req = new Request("PUT", "/_cluster/settings");
            : "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode + "\"}}";
        setConcurrentSearchMode("none", 0);
            DatasetProvisioner.provision(client(), CLICKBENCH_1SHARD, 1);
public class SingleShardAggregationIT extends AnalyticsRestTestCase {
    }
            .anyMatch(s -> "COORDINATOR_REDUCE".equals(s.get("execution_type")));
    public void testSlice1_topkOn_vanilla() throws Exception {
    public void testSliceN_topkOff_vanilla() throws Exception {
            return String.format(Locale.ROOT, "%s: one side null", label);
    private void setConcurrentSearchMode(String mode, int sliceCount) throws IOException {
        List<String> a = actualRows.stream().map(Object::toString).sorted()
    public void testSliceN_multiGroupKey_vanilla() throws Exception {
            .collect(java.util.stream.Collectors.toList());
import java.util.Map;
    }
            ? "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode
        setConcurrentSearchMode("none", 0);
    public void testSlice1_topkOn_delegation() throws Exception {
        List<String> e = expectedRows.stream().map(Object::toString).sorted()
        runCheck("all", 4, 0.0, "source=" + IDX
 * Single-shard aggregation correctness. On a 1-shard index the planner keeps the aggregate
    private static final Dataset CLICKBENCH_1SHARD = new Dataset("clickbench", "clickbench_1shard");
        String diff = compareResults(baseline, test, ppl);
            .collect(java.util.stream.Collectors.toList());
        for (int i = 0; i < e.size(); i++) {
        req.setJsonEntity(body);
                return String.format(Locale.ROOT, "%s: row %d — baseline=%s, test=%s",
        + " | sort - cnt, RegionID | head 5";
    // ── slice=N, topk off ───────────────────────────────────────────────────────
    public void testSlice1_topkOff_vanilla() throws Exception {
            + " | where GoodEvent = 1"
        assertFalse("Single-shard must not have COORDINATOR_REDUCE stage", hasReduce);
        Map<String, Object> baseline = executePpl(ppl);
        Map<String, Object> test = executePpl(ppl);
    private static final String VANILLA_TOPK_QUERY = "source=" + IDX
    private void setOversampling(double factor) throws IOException {
        assertNotNull("profile present", profile);
        setOversampling(0.0);
        + " | where Title = 'Search Results' AND GoodEvent = 1 | stats count() as cnt by RegionID | where cnt > 1";
    }
import java.util.List;
import org.opensearch.client.Request;
    private void runCheck(String mode, int sliceCount, double oversampling, String ppl) throws Exception {
        if (expectedRows == null && actualRows == null) return null;
        if (provisioned == false) {
            + " | where GoodEvent = 1 AND Income > 0"
        + " | where GoodEvent = 1 AND Age > 0 | stats count() as cnt by OS | where cnt > 5";
 * SPDX-License-Identifier: Apache-2.0
        setOversampling(0.0);
        List<Map<String, Object>> stages = (List<Map<String, Object>>) profile.get("stages");
        assertNoCoordinatorReduce(DELEGATION_QUERY);
    private static final String IDX = CLICKBENCH_1SHARD.indexName;
    // ── slice=1, topk on ────────────────────────────────────────────────────────
        runCheck("none", 0, 0.0, DELEGATION_QUERY);
    public void testPlanShape_noCoordinatorReduce_vanilla() throws Exception {
                    label, i, e.get(i), a.get(i));
 * The OpenSearch Contributors require contributions made to
        runCheck("none", 0, 2.0, DELEGATION_TOPK_QUERY);
    public void testSliceN_topkOn_vanilla() throws Exception {
    // ── Plan shape: no coordinator reduce ───────────────────────────────────────
    }
    private static final String DELEGATION_QUERY = "source=" + IDX
    }
        List<List<Object>> actualRows = (List<List<Object>>) actual.get("datarows");
/**
        Map<String, Object> profile = (Map<String, Object>) result.get("profile");
                + "\",\"search.concurrent.max_slice_count\":" + sliceCount + "}}"
import java.util.ArrayList;
