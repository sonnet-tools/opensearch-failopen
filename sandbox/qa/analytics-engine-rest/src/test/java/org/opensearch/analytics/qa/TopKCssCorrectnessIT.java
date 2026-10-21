    }
            "source = " + INDEX
/**
 * truncate to the TopK fetch limit before the coordinator merge, producing wrong counts.
            req.setJsonEntity(
    }
 *
            client().performRequest(req);
                    + sliceCount
        List<List<Object>> withCss = rowsOf(executePPL(ppl));
                + " | stats percentile(ResolutionWidth, 50) as p50,"
        );
    // ── case-04: stddev / variance ───────────────────────────────────────────
        ensureProvisioned();
            req.setJsonEntity(
            DatasetProvisioner.provision(client(), ClickBenchTestHelper.DATASET, 2, DatasetProvisioner.SegmentLayout.MULTI_SEGMENT);
     */
     * Runs {@code ppl} with CSS off, then with CSS on (4 slices), and asserts the
 * The OpenSearch Contributors require contributions made to
            "source = " + INDEX
                + " max(ResolutionWidth) by SearchEngineID"
    private Map<String, Object> executePPL(String ppl) throws Exception {
        assertCssMatchesNoCss(
                + " sum(IsRefresh) as si,"
                + " max(ResolutionWidth) as mx by SearchEngineID"
        ensureProvisioned();
                + " sum(IsRefresh) as si by SearchEngineID"
    }
                + " sum(ResolutionWidth+1),"
    }
    private static final String INDEX = "parquet_hits";
        request.setJsonEntity("{\"query\": \"" + ppl + "\"}");
    // ── case-09c: agg permutation (avg, min, sum, max, count) ────────────────
        assertCssMatchesNoCss(
        client().performRequest(req);
public class TopKCssCorrectnessIT extends AnalyticsRestTestCase {
                + " | stats count(), sum(ResolutionWidth),"
    }
        assertCssMatchesNoCss(
    public void testCase12_percentile_cssMatchesNoCss() throws Exception {
    }
        ensureProvisioned();
            "source = " + INDEX
        );
                + " avg(ResolutionWidth),"
import org.opensearch.client.Response;
        assertCssMatchesNoCss(
    public void testCase08_avgSum_cssMatchesNoCss() throws Exception {
            withCss
                + " count() as c by SearchEngineID"
                + " | stats count() as c,"
        assertCssMatchesNoCss(
    // ── case-08: avg + sum ────────────────────────────────────────────────────
        if (sliceCount > 0) {
            "CSS result differs from no-CSS reference for query: " + ppl,
 * <p>Covers 13 aggregate shapes identified by Aniketh Jain across count, sum, avg, min/max,
        assertCssMatchesNoCss(
                + " | stats count() as c by SearchEngineID"
        ensureProvisioned();
 * compatible open source source license.
        ensureProvisioned();
        setCss("none", 0);
    // ── Helpers ───────────────────────────────────────────────────────────────
                + " min(ResolutionWidth),"
        assertEquals(
                + " min(ResolutionWidth),"
        );
        );
                + " | stats sum(ResolutionWidth),"
        Request req = new Request("PUT", "/_cluster/settings");
    private static volatile boolean provisioned = false;
                + " | sort SearchEngineID | head 5"
                + " | stats stddev_samp(ResolutionWidth) as sd,"
                + " | stats max(ResolutionWidth) as mx,"
        );
 * the results are identical.
                + " by SearchEngineID, ClientIP"
 * Each test runs the same query with CSS off (reference) and CSS on (subject) and asserts
    }
    // ── case-01: multi-key, count/sum/avg, != filter ──────────────────────────
                + " | sort - c, SearchEngineID | head 2"
 * SPDX-License-Identifier: Apache-2.0
                + " | stats sum(ResolutionWidth),"
                + " max(ResolutionWidth),"
    }
        }
                + " count() as c by SearchEngineID"
    // ── case-11: many aggs on same column ────────────────────────────────────
        assertCssMatchesNoCss(
        );
        );
    public void testCase07_minMax_cssMatchesNoCss() throws Exception {
                + " sum(IsRefresh) as si,"
    }
                    + mode
    public void testCase03_distinctCount_cssMatchesNoCss() throws Exception {
                + " | sort - c, SearchEngineID | head 2"
        );
                + " min(ResolutionWidth) as mn,"
                + " | where SearchPhrase != ''"
        assertCssMatchesNoCss(
        List<?> rows = (List<?>) result.get("rows");
        );
        Request request = new Request("POST", "/_analytics/ppl");
                + " | stats count() as c,"
                "{\"persistent\":{\"analytics.shard_bucket_oversampling_factor\": 0.1}}"
        );
                + " | sort - c, SearchEngineID | head 2"
            "source = " + INDEX
package org.opensearch.analytics.qa;
                + " count()"
                "{\"transient\":{\"search.concurrent_segment_search.mode\":\""
                    + "\",\"search.concurrent.max_slice_count\":"
        ensureProvisioned();
     * result rows are identical. Restores CSS-off after the check.
            );
        );
                + " var_pop(ResolutionWidth) as vp"
    }
    public void testCase01_multiKeyCountSumAvg_cssMatchesNoCss() throws Exception {
                + " | stats count() as c, sum(IsRefresh), avg(ResolutionWidth)"
        assertCssMatchesNoCss(
            req.setJsonEntity(
            // truncates to a very small fetch limit, producing wrong results without the fix.
            );
    // ── case-12: percentile ───────────────────────────────────────────────────
                + " | stats count() as c by SearchEngineID"
                + " | stats avg(ResolutionWidth) as a,"
                + " percentile(ResolutionWidth, 50) as p50 by SearchEngineID"
 * <p>Before the PartialReduce fix, CSS caused each intra-shard partition to independently
    // ── case-09b: agg permutation (max, avg, count, min, sum) ────────────────
        ensureProvisioned();
    private void ensureProvisioned() throws Exception {
    }
    public void testCase09a_permutation1_cssMatchesNoCss() throws Exception {
            // bug reproducible on the local test cluster — each CSS partition independently
        return entityAsMap(response);
        List<List<Object>> reference = rowsOf(executePPL(ppl));
    }
                + " max(ResolutionWidth) as mx,"
}
 * Regression tests for TopK correctness when concurrent segment search (CSS) is active.
 */
        assertCssMatchesNoCss(
        ensureProvisioned();
import java.util.Map;
    public void testCase13_mixedSplitAndNonSplit_cssMatchesNoCss() throws Exception {
                + " avg(ResolutionWidth) as a,"
            "source = " + INDEX
    public void testCase10_noAliases_cssMatchesNoCss() throws Exception {
    }
    }
        assertCssMatchesNoCss(
                + " min(ResolutionWidth) as mn,"
        ensureProvisioned();
    public void testCase09b_permutation2_cssMatchesNoCss() throws Exception {
                + " max(ResolutionWidth) as mx,"
        assertCssMatchesNoCss(
                + " | sort SearchEngineID | head 5"
            "source = " + INDEX
        ensureProvisioned();
                + " | sort SearchEngineID | head 5"
            );
        );
                    + "}}"
                + " | sort - c, SearchEngineID, ClientIP | head 10"
        assertCssMatchesNoCss(
    private void assertCssMatchesNoCss(String ppl) throws Exception {
            "source = " + INDEX
    // ── case-05: scalar aggregate (no group-by, no TopK) ─────────────────────
    // ── case-13: mixed split + non-split (count/sum + percentile) ────────────
                + " | sort - c, SearchEngineID | head 2"
            "source = " + INDEX
    // ── case-03: distinct_count (HLL) ────────────────────────────────────────
    // ── case-09a: agg permutation (count, sum, avg, min, max) ────────────────
            Request req = new Request("PUT", "/_cluster/settings");
        ensureProvisioned();
            "source = " + INDEX
    private void setCss(String mode, int sliceCount) throws Exception {
    }
                + " | sort - c, SearchEngineID | head 2 from 1"
    }
        ensureProvisioned();
                + " count() as c,"
 */
    private List<List<Object>> rowsOf(Map<String, Object> result) {
                + " avg(ResolutionWidth) as a,"
    public void testCase02_singleKeyCount_cssMatchesNoCss() throws Exception {
import org.opensearch.client.Request;
                + " by SearchEngineID | sort SearchEngineID | head 10"
        } else {
    }
            "source = " + INDEX
                "{\"transient\":{\"search.concurrent_segment_search.mode\":\"" + mode + "\"}}"
            "source = " + INDEX
        ensureProvisioned();
    }
        assertCssMatchesNoCss(
    }
        ensureProvisioned();
        // Sort by SearchEngineID (deterministic key, not count) to avoid tie-breaking flakiness.
        assertCssMatchesNoCss(
        }
            "source = " + INDEX
                + " | stats avg(ResolutionWidth) as a,"
import java.util.List;
        ensureProvisioned();
                + " | sort - dc, SearchEngineID | head 2"
        assertNotNull("response must have rows, got: " + result.keySet(), rows);
 *
/*
        );
        );
        setCss("none", 0);
    // ── case-02: single-key count ────────────────────────────────────────────
    // ── case-06: offset + limit ───────────────────────────────────────────────
 * distinct_count, stddev/variance, percentile, offset, scalar agg, and permutation variants.
    public void testCase04_stddevVariance_cssMatchesNoCss() throws Exception {
        if (!provisioned) {
                + " | sort - c, SearchEngineID | head 2"
        );
                + " sum(ResolutionWidth) as s,"
                + " | sort SearchEngineID | head 5"
    public void testCase11_manyAggsOnSameColumn_cssMatchesNoCss() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                + " | sort - c, SearchEngineID | head 2"
                + " | stats min(ResolutionWidth) as mn,"
            "source = " + INDEX
                + " percentile(ResolutionWidth, 95) as p95 by SearchEngineID"
                + " var_samp(ResolutionWidth) as vs,"
        );
 *
        return (List<List<Object>>) rows;
                + " sum(ResolutionWidth) as s,"
            reference,
                + " count() as c by SearchEngineID"
    // ── case-07: min / max ────────────────────────────────────────────────────
@SuppressWarnings("unchecked")
                + " sum(ResolutionWidth+2),"
            // MULTI_SEGMENT (2 segments/shard) + low oversampling makes the CSS truncation
    public void testCase05_scalarSums_cssMatchesNoCss() throws Exception {
                + " min(ResolutionWidth) as mn,"
            "source = " + INDEX
                + " count(ResolutionWidth) by SearchEngineID"
    }
            "source = " + INDEX
                + " | stats distinct_count(ClientIP) as dc by SearchEngineID"
    public void testCase06_offsetLimit_cssMatchesNoCss() throws Exception {
                + " avg(ResolutionWidth),"
    public void testCase09c_permutation3_cssMatchesNoCss() throws Exception {
        Response response = client().performRequest(request);
            provisioned = true;
    /**
        setCss("all", 4);
    // ── case-10: no aliases ───────────────────────────────────────────────────
