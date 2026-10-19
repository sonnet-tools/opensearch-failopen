    @SuppressWarnings("unchecked")
        for (List<Object> row : rows) {
    }
            client().performRequest(req);
    // oversampling is approximate by design (see AnalyticsApproximationSettings); a globally-top-N
        // `where c > 1` filters groups after aggregation. With TopK oversampling, borderline
        ensureProvisioned();
    }
    }
        assertRowCount(result, 10);
    public void testCountByGroup_sortDesc_head10() throws Exception {
        ensureProvisioned();
        Map<String, Object> result = executePPL(
        }
        ensureProvisioned();
            "source = " + INDEX + " | stats dc(UserID) as u by RegionID | sort - u | head 10"
import java.util.List;
     *  schema — the deterministic contract that holds regardless of oversampling factor. */
    /** Asserts the query returns exactly {@code expectedRows} rows with the expected [c, RegionID]
        );
 */
            assertTrue("count column must be numeric, got " + row.get(0), row.get(0) instanceof Number);
        assertRowCount(result, 10);
    /** Min/Max by group. */
        // Restore
    private void setOversamplingFactor(double factor) throws Exception {
        assertTrue("Should return at most 10 rows", rows.size() <= 10);
        for (List<Object> row : rows) {
        Map<String, Object> result = executePPL(
        client().performRequest(req);
            "source = " + INDEX + " | stats min(ResolutionWidth) as mi, max(ResolutionWidth) as ma by RegionID | sort - ma | head 10"
        Map<String, Object> result = executePPL(ppl);
        req.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": " + factor + "}}");
        }
        long totalCount = 0;
    public void testCountByGroup_having_sortDesc_head10() throws Exception {
    /** Mixed aggregation with TopK: dc + sum, sorted by dc. */
    private void assertRowCount(Map<String, Object> result, int expected) {
        ensureProvisioned();
    // property and would be flaky. The exactness of the fix (per-shard fetch sized off the inner
            "source = " + INDEX + " | stats sum(AdvEngineID), count() as c, avg(ResolutionWidth) by RegionID | sort - c | head 10"
        Request req = new Request("PUT", "/_cluster/settings");
        assertRowCount(result, 10);
            req.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 2.0}}");
        assertCountByQueryReturns("source = " + INDEX + " | stats count() as c by RegionID | sort - c | head 10", 10);
    /** Avg by group, sort desc. */
        Response response = client().performRequest(request);
    public void testFactorZero_queryWorks() throws Exception {
        assertCountByQueryReturns("source = " + INDEX + " | stats count() as c by RegionID | sort c | head 10", 10);
    /** sort on the GROUP KEY (not the agg), head 10 — sort field is the by-column. */
 * SPDX-License-Identifier: Apache-2.0
        // and the sum of all returned counts must be <= total docs.
    /** HAVING (post-stats where) between the agg and the limit, then sort + head. */
            long c = ((Number) row.get(0)).longValue();
        // 84 distinct RegionID groups in the fixture.
    public void testMinMaxByGroup() throws Exception {
        return (List<List<Object>>) rows;
/*
            "source = " + INDEX + " | stats avg(ResolutionWidth) as a by RegionID | sort - a | head 10"
        Map<String, Object> result = executePPL(
        ensureProvisioned();
    // 84 distinct RegionID groups over 100 docs on 2 shards, so `head 10` (10 << 84) genuinely
    @SuppressWarnings("unchecked")
        Request request = new Request("POST", "/_analytics/ppl");
        Map<String, Object> result = executePPL(
    private static volatile boolean provisioned = false;
        );
     *  must not trim, and TopK must not fire when there is no user limit). */
        return entityAsMap(response);
        // Temporarily set factor to 0
            totalCount += c;
        assertTrue("should return at least 5 groups (half of expected 10)", rows.size() >= 5);
    public void testCountByGroup_sortAscAgg_head10() throws Exception {
            Request req = new Request("PUT", "/_cluster/settings");
    public void testMultiAgg_sortByCount_head10() throws Exception {
    // sort-keys have no defined tie-break, so value-equality vs. an unsampled run is not a guaranteed
        ensureProvisioned();
import java.util.Map;
        ensureProvisioned();
            assertEquals("each row should have 3 columns [u, s, RegionID]", 3, row.size());
        assertTrue("sum of counts must be <= 100 (no double-counting)", totalCount <= 100);
        assertNotNull("response must have rows, got: " + result.keySet(), rows);
            assertTrue("each group count must be <= 100 (total docs)", c <= 100);
    }
        assertRowCount(result, 10);
        assertEquals(expected, rows.size());
    //
        ensureProvisioned();
    }
    private void assertCountByQueryReturns(String ppl, int expectedRows) throws Exception {
    public void testCountByGroup_sortDescAgg_head10() throws Exception {
    // shape variations. They intentionally do NOT assert exact group membership/values: shard-bucket
        ensureProvisioned();
        );
    // exercises the per-shard TopK oversampling path (a per-partition Sort+Limit below the ER).
    }
 * this file be licensed under the Apache-2.0 license or a
public class ShardBucketOversamplingIT extends AnalyticsRestTestCase {
        assertCountByQueryReturns("source = " + INDEX + " | stats count() as c by RegionID | sort - c", 84);
        Request req = new Request("PUT", "/_cluster/settings");
    /** Q13 shape: count by keyword, sort desc, head 10. */
    private void ensureProvisioned() throws Exception {
    // group that ranks below every shard's local cutoff can legitimately be dropped, and tied
 *
    public void testMultiAgg_sortByDc_head10() throws Exception {
    }
/**
        );
        Request restore = new Request("PUT", "/_cluster/settings");
    }
        req.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 0.0}}");
        );
        assertCountByQueryReturns("source = " + INDEX + " | stats count() as c by RegionID | sort - RegionID | head 10", 10);
    }
    public void testSumByGroup_sortDesc_head10() throws Exception {
    private static List<List<Object>> rowsOf(Map<String, Object> result) {
 * Exercises real TopK query shapes (stats+sort+head) on multi-shard index.
        restore.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 2.0}}");
    }
        assertEquals("row count", expectedRows, rows.size());
        // Verify all expected columns present (row is a positional list; schema has 3 columns: u, s, RegionID)
    /** dc by group, sort desc. */
        );
        // groups (count=1 per shard but >1 globally) may be pruned — result count is approximate.
 */
    }
            provisioned = true;
        assertRowCount(result, 10);
import org.opensearch.client.Request;
    /** No oversampling (factor=0): query still works. */
    }
        }
    }
        if (!provisioned) {
    private static final String INDEX = "parquet_hits";
        );
            assertEquals("each row is [count, RegionID]", 2, row.size());
        }
    private Map<String, Object> executePPL(String ppl) throws Exception {
    }
    public void testCountByGroup_sortOnGroupKey_head10() throws Exception {
    /** count by group, sort DESC on the agg, head 10. */
        );
    public void testDcByGroup_sortDesc_head10() throws Exception {
    // limit, not the outer system cap) is pinned deterministically in TopKRewriterPlanShapeTests.
            "source = " + INDEX + " | stats sum(ResolutionWidth) as s by RegionID | sort - s | head 10"
    public void testCountByGroup_sortDesc_noHead_returnsAllGroups() throws Exception {
            "source = " + INDEX + " | stats count() as c by RegionID | sort - c | head 10"
    }
        List<?> rows = (List<?>) result.get("rows");
        List<List<Object>> rows = rowsOf(result);
        ensureProvisioned();
        for (List<Object> row : rows) {
    /** No head: grouped + sorted, every surviving group returned (redundant outer system limit
        Map<String, Object> result = executePPL(
    }
        ensureProvisioned();
        assertRowCount(result, 10);
        List<List<Object>> rows = rowsOf(result);
import org.opensearch.client.Response;
        List<List<Object>> rows = rowsOf(result);
        Map<String, Object> result = executePPL(
    public void testAvgByGroup_sortDesc_head10() throws Exception {
    // These assert only the DETERMINISTIC contract — row count, schema, no error — across the
package org.opensearch.analytics.qa;
        assertRowCount(result, 10);
        List<?> rows = (List<?>) result.get("rows");
        client().performRequest(restore);
 * compatible open source license.
            "source = " + INDEX + " | stats count() as c by RegionID | where c > 1 | sort - c | head 10"
        assertFalse("Should return rows", rows.isEmpty());
            assertTrue("each group count must be > 1 (HAVING)", c > 1);
 * The OpenSearch Contributors require contributions made to
        ensureProvisioned();
        assertTrue("should return at most 10 groups", rows.size() <= 10);
    /** sort ASC on the agg, head 10 — opposite collation direction through the per-shard sort. */
    }
}
        Map<String, Object> result = executePPL(
        request.setJsonEntity("{\"query\": \"" + ppl + "\"}");
        client().performRequest(req);
        Map<String, Object> result = executePPL(
            DatasetProvisioner.provision(client(), ClickBenchTestHelper.DATASET, 2);
    }
        );
            "source = " + INDEX + " | stats dc(UserID) as u, sum(AdvEngineID) as s by RegionID | sort - u | head 10"
        assertNotNull("response must have rows, got: " + result.keySet(), rows);
        ensureProvisioned();
    // ── Multi-shard TopK across sort placements / group-by / having ─────────────────────
        // Verify no double-counting: each group's count must be <= total docs (100)
    }
            "source = " + INDEX + " | stats count() as c by RegionID | sort - c | head 10"
 * IT for per-shard bucket oversampling using ClickBench dataset.
    /** Q10 shape: sum + count + avg + dc by group, sort, head. */
    /** Sum by group, sort desc. */
        Map<String, Object> result = executePPL(
