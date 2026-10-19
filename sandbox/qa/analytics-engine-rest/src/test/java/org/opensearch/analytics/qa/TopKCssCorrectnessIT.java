                + " by SearchEngineID | sort SearchEngineID | head 10"
                + " max(ResolutionWidth) as mx by SearchEngineID"
                + " | stats count() as c by SearchEngineID"
        );  
 * SPDX-License-Identifier: Apache-2.0
    // ── case-11: many aggs on same column ────────────────────────────────────
    }  
        assertCssMatchesNoCss(  
            "source = " + INDEX  
    }  
                + " sum(IsRefresh) as si by SearchEngineID"
            );
                    + "\",\"search.concurrent.max_slice_count\":"
                + " count(ResolutionWidth) by SearchEngineID"  
            req.setJsonEntity(
            "source = " + INDEX
    }
    // ── case-13: mixed split + non-split (count/sum + percentile) ────────────
                + " avg(ResolutionWidth) as a,"
                + " max(ResolutionWidth) by SearchEngineID"  
                + " count() as c,"
    }
    }
                + " var_pop(ResolutionWidth) as vp"
        ensureProvisioned();
                + " min(ResolutionWidth) as mn,"  
        assertCssMatchesNoCss(
        );
        );
        setCss("all", 4);
    public void testCase09c_permutation3_cssMatchesNoCss() throws Exception {
 * The OpenSearch Contributors require contributions made to  
            client().performRequest(req);
        setCss("none", 0);
    }
        Request req = new Request("PUT", "/_cluster/settings");
        List<?> rows = (List<?>) result.get("rows");  
                + " | stats count() as c by SearchEngineID"
 * truncate to the TopK fetch limit before the coordinator merge, producing wrong counts.
@SuppressWarnings("unchecked")  
                    + sliceCount
        assertCssMatchesNoCss(
        assertCssMatchesNoCss(
        if (!provisioned) {
                + " min(ResolutionWidth),"
    public void testCase11_manyAggsOnSameColumn_cssMatchesNoCss() throws Exception {
                + " | where SearchPhrase != ''"  
            req.setJsonEntity(  
        ensureProvisioned();
        assertCssMatchesNoCss(
                + " count() as c by SearchEngineID"
 */  
    }
            DatasetProvisioner.provision(client(), ClickBenchTestHelper.DATASET, 2, DatasetProvisioner.SegmentLayout.MULTI_SEGMENT);
                + " | sort SearchEngineID | head 5"
                + " avg(ResolutionWidth),"
                "{\"transient\":{\"search.concurrent_segment_search.mode\":\""
        );  
        );
    public void testCase12_percentile_cssMatchesNoCss() throws Exception {
        assertCssMatchesNoCss(
                + " | stats count(), sum(ResolutionWidth),"  
    public void testCase03_distinctCount_cssMatchesNoCss() throws Exception {
            "source = " + INDEX
 *  
    // ── Helpers ───────────────────────────────────────────────────────────────  
/*  
                + " percentile(ResolutionWidth, 95) as p95 by SearchEngineID"  
    }
        ensureProvisioned();  
        );  
                + " | sort - dc, SearchEngineID | head 2"
        ensureProvisioned();  
                + " sum(ResolutionWidth+2),"
        ensureProvisioned();
        } else {
    private Map<String, Object> executePPL(String ppl) throws Exception {
 * <p>Covers 13 aggregate shapes identified by Aniketh Jain across count, sum, avg, min/max,  
import org.opensearch.client.Response;
                + " sum(ResolutionWidth+1),"
                + " | sort - c, SearchEngineID | head 2 from 1"
            req.setJsonEntity(
    // ── case-05: scalar aggregate (no group-by, no TopK) ─────────────────────  
        ensureProvisioned();
                + " sum(ResolutionWidth) as s,"  
                + " avg(ResolutionWidth) as a,"
        assertCssMatchesNoCss(
        );
        );  
        assertCssMatchesNoCss(
            Request req = new Request("PUT", "/_cluster/settings");  
            "source = " + INDEX
    public void testCase09a_permutation1_cssMatchesNoCss() throws Exception {
            withCss
    /**
    // ── case-03: distinct_count (HLL) ────────────────────────────────────────  
                + " count() as c by SearchEngineID"
            "source = " + INDEX  
                + " | stats percentile(ResolutionWidth, 50) as p50,"
                + " | stats distinct_count(ClientIP) as dc by SearchEngineID"  
        Response response = client().performRequest(request);
                + " | stats stddev_samp(ResolutionWidth) as sd,"
    public void testCase07_minMax_cssMatchesNoCss() throws Exception {
 */
                + " | sort - c, SearchEngineID, ClientIP | head 10"  
                + " | stats sum(ResolutionWidth),"
    public void testCase10_noAliases_cssMatchesNoCss() throws Exception {
                + " | stats sum(ResolutionWidth),"  
    // ── case-07: min / max ────────────────────────────────────────────────────  
    public void testCase01_multiKeyCountSumAvg_cssMatchesNoCss() throws Exception {
 * distinct_count, stddev/variance, percentile, offset, scalar agg, and permutation variants.
        ensureProvisioned();
    }  
            "source = " + INDEX
                + " min(ResolutionWidth),"
                + " count() as c by SearchEngineID"
    public void testCase05_scalarSums_cssMatchesNoCss() throws Exception {
        if (sliceCount > 0) {  
    private void assertCssMatchesNoCss(String ppl) throws Exception {  
        ensureProvisioned();  
                + " percentile(ResolutionWidth, 50) as p50 by SearchEngineID"
    }
                + " | stats count() as c,"
                + " var_samp(ResolutionWidth) as vs,"  
            // MULTI_SEGMENT (2 segments/shard) + low oversampling makes the CSS truncation
        List<List<Object>> reference = rowsOf(executePPL(ppl));
 * <p>Before the PartialReduce fix, CSS caused each intra-shard partition to independently
                + " sum(IsRefresh) as si,"
            provisioned = true;
            "source = " + INDEX
            "source = " + INDEX
    // ── case-09b: agg permutation (max, avg, count, min, sum) ────────────────  
                + " max(ResolutionWidth) as mx,"  
        );
        assertCssMatchesNoCss(  
                    + mode  
    public void testCase08_avgSum_cssMatchesNoCss() throws Exception {  
    }  
                + " | stats avg(ResolutionWidth) as a,"
            "source = " + INDEX
    }
import java.util.Map;
    public void testCase06_offsetLimit_cssMatchesNoCss() throws Exception {  
        setCss("none", 0);
    }
    public void testCase13_mixedSplitAndNonSplit_cssMatchesNoCss() throws Exception {
                + " max(ResolutionWidth) as mx,"
                + " avg(ResolutionWidth),"  
import org.opensearch.client.Request;
    // ── case-10: no aliases ───────────────────────────────────────────────────  
    private void ensureProvisioned() throws Exception {  
        assertNotNull("response must have rows, got: " + result.keySet(), rows);
     */
                + " | sort - c, SearchEngineID | head 2"
                + " | stats max(ResolutionWidth) as mx,"  
                + " | stats count() as c,"  
public class TopKCssCorrectnessIT extends AnalyticsRestTestCase {
                "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode + "\"}}"
                + " | sort SearchEngineID | head 5"
 *
    }  
import java.util.List;
        return entityAsMap(response);
    }
     * Runs {@code ppl} with CSS off, then with CSS on (4 slices), and asserts the  
/**
                + " min(ResolutionWidth) as mn,"  
        }  
                + " min(ResolutionWidth) as mn,"
            "source = " + INDEX
        );
 * the results are identical.
        ensureProvisioned();  
    // ── case-02: single-key count ────────────────────────────────────────────
    private List<List<Object>> rowsOf(Map<String, Object> result) {
                + " | stats min(ResolutionWidth) as mn,"  
package org.opensearch.analytics.qa;
                + " | sort SearchEngineID | head 5"
                + " count()"  
    public void testCase09b_permutation2_cssMatchesNoCss() throws Exception {
            "source = " + INDEX
    }
 * this file be licensed under the Apache-2.0 license or a
        assertCssMatchesNoCss(  
            "source = " + INDEX
        );
        );
    // ── case-08: avg + sum ────────────────────────────────────────────────────
        );  
    // ── case-01: multi-key, count/sum/avg, != filter ──────────────────────────  
    }
            "source = " + INDEX
                + " sum(IsRefresh) as si,"
            );  
                + " | sort - c, SearchEngineID | head 2"
 * compatible open source source license.
        Request request = new Request("POST", "/_analytics/ppl");
        client().performRequest(req);
            // bug reproducible on the local test cluster — each CSS partition independently  
                + " | sort - c, SearchEngineID | head 2"
        request.setJsonEntity("{\"query\": \"" + ppl + "\"}");  
        ensureProvisioned();
    private static volatile boolean provisioned = false;  
            // truncates to a very small fetch limit, producing wrong results without the fix.
            "source = " + INDEX
    }  
    private static final String INDEX = "parquet_hits";
        );  
 *
        assertCssMatchesNoCss(
                + " | sort - c, SearchEngineID | head 2"
                + " | stats avg(ResolutionWidth) as a,"  
        assertCssMatchesNoCss(
    // ── case-04: stddev / variance ───────────────────────────────────────────
        // Sort by SearchEngineID (deterministic key, not count) to avoid tie-breaking flakiness.
    public void testCase04_stddevVariance_cssMatchesNoCss() throws Exception {
        assertCssMatchesNoCss(  
            reference,  
    private void setCss(String mode, int sliceCount) throws Exception {
        ensureProvisioned();
    // ── case-09a: agg permutation (count, sum, avg, min, max) ────────────────  
                + " max(ResolutionWidth),"
        return (List<List<Object>>) rows;
        }  
        assertCssMatchesNoCss(
                "{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 0.1}}"
                + " | sort SearchEngineID | head 5"
 * Regression tests for TopK correctness when concurrent segment search (CSS) is active.
                + " | sort - c, SearchEngineID | head 2"  
        assertEquals(
            "CSS result differs from no-CSS reference for query: " + ppl,
 * Each test runs the same query with CSS off (reference) and CSS on (subject) and asserts  
     * result rows are identical. Restores CSS-off after the check.
        ensureProvisioned();  
}
        );  
        ensureProvisioned();  
    }
                + " | sort - c, SearchEngineID | head 2"
        ensureProvisioned();  
                + " sum(ResolutionWidth) as s,"  
    // ── case-09c: agg permutation (avg, min, sum, max, count) ────────────────  
        ensureProvisioned();  
    // ── case-12: percentile ───────────────────────────────────────────────────
    }
    public void testCase02_singleKeyCount_cssMatchesNoCss() throws Exception {  
        List<List<Object>> withCss = rowsOf(executePPL(ppl));
            "source = " + INDEX
                + " | stats count() as c, sum(IsRefresh), avg(ResolutionWidth)"
    // ── case-06: offset + limit ───────────────────────────────────────────────
            );
        assertCssMatchesNoCss(  
        );  
                + " by SearchEngineID, ClientIP"
                    + "}}"  
