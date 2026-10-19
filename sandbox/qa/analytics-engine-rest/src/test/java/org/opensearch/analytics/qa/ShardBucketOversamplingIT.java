        assertFalse("Should return rows", rows.isEmpty());  
            "source = " + INDEX + " | stats count() as c by RegionID | sort - c | head 10"  
        List<List<Object>> rows = rowsOf(result);
        List<List<Object>> rows = rowsOf(result);
            "source = " + INDEX + " | stats count() as c by RegionID | sort - c | head 10"  
    }
    // ── Multi-shard TopK across sort placements / group-by / having ─────────────────────
        }  
        ensureProvisioned();
    public void testCountByGroup_sortAscAgg_head10() throws Exception {  
        // and the sum of all returned counts must be <= total docs.
        assertRowCount(result, 10);
        ensureProvisioned();
        Response response = client().performRequest(request);  
        Map<String, Object> result = executePPL(
        assertTrue("should return at most 10 groups", rows.size() <= 10);  
            DatasetProvisioner.provision(client(), ClickBenchTestHelper.DATASET, 2);  
            provisioned = true;
 * this file be licensed under the Apache-2.0 license or a
        ensureProvisioned();
    public void testCountByGroup_having_sortDesc_head10() throws Exception {  
        Map<String, Object> result = executePPL(ppl);  
        assertNotNull("response must have rows, got: " + result.keySet(), rows);
    public void testMultiAgg_sortByDc_head10() throws Exception {  
        assertCountByQueryReturns("source = " + INDEX + " | stats count() as c by RegionID | sort - c | head 10", 10);
    public void testMultiAgg_sortByCount_head10() throws Exception {  
import java.util.List;
        client().performRequest(req);  
    public void testFactorZero_queryWorks() throws Exception {
    /** Sum by group, sort desc. */
        Map<String, Object> result = executePPL(
    // These assert only the DETERMINISTIC contract — row count, schema, no error — across the  
        for (List<Object> row : rows) {  
        );
    }  
        assertRowCount(result, 10);
    public void testCountByGroup_sortDesc_noHead_returnsAllGroups() throws Exception {  
        assertTrue("Should return at most 10 rows", rows.size() <= 10);
    private static volatile boolean provisioned = false;
        }
     *  schema — the deterministic contract that holds regardless of oversampling factor. */
        Map<String, Object> result = executePPL(
    /** count by group, sort DESC on the agg, head 10. */
    /** Avg by group, sort desc. */
        ensureProvisioned();
        Request req = new Request("PUT", "/_cluster/settings");
    }  
        // groups (count=1 per shard but >1 globally) may be pruned — result count is approximate.  
        assertTrue("should return at least 5 groups (half of expected 10)", rows.size() >= 5);
        List<List<Object>> rows = rowsOf(result);
        ensureProvisioned();
        client().performRequest(restore);
        for (List<Object> row : rows) {  
    }  
        assertRowCount(result, 10);
    public void testCountByGroup_sortOnGroupKey_head10() throws Exception {  
 * compatible open source license.
import org.opensearch.client.Response;
        ensureProvisioned();
        Request req = new Request("PUT", "/_cluster/settings");
 */  
    }  
        List<?> rows = (List<?>) result.get("rows");  
        Map<String, Object> result = executePPL(
            assertTrue("count column must be numeric, got " + row.get(0), row.get(0) instanceof Number);
    }  
        );
    /** HAVING (post-stats where) between the agg and the limit, then sort + head. */
    public void testDcByGroup_sortDesc_head10() throws Exception {  
    /** Min/Max by group. */
        assertRowCount(result, 10);
        ensureProvisioned();
        client().performRequest(req);  
        );  
        assertCountByQueryReturns("source = " + INDEX + " | stats count() as c by RegionID | sort - RegionID | head 10", 10);
    }  
        return entityAsMap(response);
    private static final String INDEX = "parquet_hits";
        );
/*  
    @SuppressWarnings("unchecked")
    // sort-keys have no defined tie-break, so value-equality vs. an unsampled run is not a guaranteed
    public void testMinMaxByGroup() throws Exception {  
            "source = " + INDEX + " | stats min(ResolutionWidth) as mi, max(ResolutionWidth) as ma by RegionID | sort - ma | head 10"  
    // exercises the per-shard TopK oversampling path (a per-partition Sort+Limit below the ER).
        // Restore
    private void assertCountByQueryReturns(String ppl, int expectedRows) throws Exception {
    }
        assertNotNull("response must have rows, got: " + result.keySet(), rows);
            assertTrue("each group count must be <= 100 (total docs)", c <= 100);
        // Verify no double-counting: each group's count must be <= total docs (100)
        Map<String, Object> result = executePPL(
        assertRowCount(result, 10);
        request.setJsonEntity("{\"query\": \"" + ppl + "\"}");
    }  
    /** Asserts the query returns exactly {@code expectedRows} rows with the expected [c, RegionID]  
        // `where c > 1` filters groups after aggregation. With TopK oversampling, borderline
            "source = " + INDEX + " | stats dc(UserID) as u, sum(AdvEngineID) as s by RegionID | sort - u | head 10"  
        if (!provisioned) {
public class ShardBucketOversamplingIT extends AnalyticsRestTestCase {
/**
    }
    public void testCountByGroup_sortDescAgg_head10() throws Exception {  
        );
    private void setOversamplingFactor(double factor) throws Exception {  
        }
    private Map<String, Object> executePPL(String ppl) throws Exception {  
    /** Mixed aggregation with TopK: dc + sum, sorted by dc. */
    private void assertRowCount(Map<String, Object> result, int expected) {
        Map<String, Object> result = executePPL(
            "source = " + INDEX + " | stats count() as c by RegionID | where c > 1 | sort - c | head 10"
        Map<String, Object> result = executePPL(
        }  
            totalCount += c;
    public void testSumByGroup_sortDesc_head10() throws Exception {  
        ensureProvisioned();
            Request req = new Request("PUT", "/_cluster/settings");
    //
        assertRowCount(result, 10);
        // 84 distinct RegionID groups in the fixture.
    /** Q13 shape: count by keyword, sort desc, head 10. */
 * SPDX-License-Identifier: Apache-2.0
            "source = " + INDEX + " | stats sum(ResolutionWidth) as s by RegionID | sort - s | head 10"  
        assertEquals(expected, rows.size());
 *
    /** No head: grouped + sorted, every surviving group returned (redundant outer system limit
        Request request = new Request("POST", "/_analytics/ppl");
 * IT for per-shard bucket oversampling using ClickBench dataset.
        req.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": " + factor + "}}");
 * Exercises real TopK query shapes (stats+sort+head) on multi-shard index.  
        return (List<List<Object>>) rows;  
    /** No oversampling (factor=0): query still works. */  
        assertRowCount(result, 10);
import java.util.Map;
    public void testCountByGroup_sortDesc_head10() throws Exception {  
        List<?> rows = (List<?>) result.get("rows");
package org.opensearch.analytics.qa;
    // shape variations. They intentionally do NOT assert exact group membership/values: shard-bucket
            assertEquals("each row is [count, RegionID]", 2, row.size());
            "source = " + INDEX + " | stats avg(ResolutionWidth) as a by RegionID | sort - a | head 10"  
    }  
    }
    private void ensureProvisioned() throws Exception {
            "source = " + INDEX + " | stats sum(AdvEngineID), count() as c, avg(ResolutionWidth) by RegionID | sort - c | head 10"  
    // group that ranks below every shard's local cutoff can legitimately be dropped, and tied  
    }
    /** dc by group, sort desc. */
            "source = " + INDEX + " | stats dc(UserID) as u by RegionID | sort - u | head 10"  
        ensureProvisioned();
    }  
        req.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 0.0}}");
        ensureProvisioned();
    public void testAvgByGroup_sortDesc_head10() throws Exception {  
            client().performRequest(req);  
        restore.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 2.0}}");  
            assertTrue("each group count must be > 1 (HAVING)", c > 1);  
    /** sort ASC on the agg, head 10 — opposite collation direction through the per-shard sort. */
    /** sort on the GROUP KEY (not the agg), head 10 — sort field is the by-column. */
        ensureProvisioned();
            req.setJsonEntity("{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 2.0}}");
        // Verify all expected columns present (row is a positional list; schema has 3 columns: u, s, RegionID)
    // 84 distinct RegionID groups over 100 docs on 2 shards, so `head 10` (10 << 84) genuinely  
        Map<String, Object> result = executePPL(
    // limit, not the outer system cap) is pinned deterministically in TopKRewriterPlanShapeTests.  
     *  must not trim, and TopK must not fire when there is no user limit). */
            long c = ((Number) row.get(0)).longValue();
    private static List<List<Object>> rowsOf(Map<String, Object> result) {  
 * The OpenSearch Contributors require contributions made to  
 */
        long totalCount = 0;  
        for (List<Object> row : rows) {
        ensureProvisioned();
        assertTrue("sum of counts must be <= 100 (no double-counting)", totalCount <= 100);
        Map<String, Object> result = executePPL(
    }
    }  
        );
    @SuppressWarnings("unchecked")
        );
        assertCountByQueryReturns("source = " + INDEX + " | stats count() as c by RegionID | sort c | head 10", 10);
        );
            assertEquals("each row should have 3 columns [u, s, RegionID]", 3, row.size());
        assertCountByQueryReturns("source = " + INDEX + " | stats count() as c by RegionID | sort - c", 84);  
}  
        );
        // Temporarily set factor to 0  
    }
        Request restore = new Request("PUT", "/_cluster/settings");
    // oversampling is approximate by design (see AnalyticsApproximationSettings); a globally-top-N
    /** Q10 shape: sum + count + avg + dc by group, sort, head. */
    }  
    // property and would be flaky. The exactness of the fix (per-shard fetch sized off the inner
    }  
import org.opensearch.client.Request;
        ensureProvisioned();
        assertEquals("row count", expectedRows, rows.size());
