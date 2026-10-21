        );
    }
        Map<String, Object> response = executePpl(
    public void testEventstatsDistinctCount_3shard() throws IOException {
 *
                + " | eventstats count() as cnt by span(int0, 10), str0"
     * through the analytics-engine route — the throw is the contract.
    /** sql IT: testUnsupportedWindowFunctions. PERCENTILE/PERCENTILE_APPROX rejected by the
            row("key06", 8,    sp, ss, vp, vs),
            && (actual instanceof Double && Double.isNaN((Double) actual)
            "source=" + DATASET.indexName + " | where key = 'non-existed' | eventstats count(),"
            row("key08", "TECHNOLOGY",      null, 9L, 7.0, 4, 11),
            row("key03", null, 17L, avg, 1, 11),
            row("key16", "TECHNOLOGY",      8,    9L, 7.0, 4, 11)
     *  on RexOver-bearing projects, per-shard window evaluation would produce different
        // (FURNITURE,null)=1, (FURNITURE,0)=1; (OS,null)=3, (OS,0)=3; (TECH,null)=2, (TECH,0)=5, (TECH,10)=2.
            row("key14", "TECHNOLOGY",      "e",  11,   11.0, 6.0,  1.75,         9L),
    }
package org.opensearch.analytics.qa;
     *    <li>(OFFICE SUPPLIES, null) 5-5 = 0 → fails (0 not > 0)</li>
            row("key08", "TECHNOLOGY", 1L),
        assertEquals("Expected exactly one row", 1, rows.size());
     *  {@link #testEventstatsVariance} — null int0 rows are already excluded from numerics. */
        double vp = 9.05785123966942;
    public void testEventstatsByMultiplePartitionsWithNull2() throws IOException {
        Map<String, Object> response = executePpl(
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        Map<String, Object> response = executePpl(
public class EventstatsCommandIT extends AnalyticsRestTestCase {
 * </pre>
            row("key02", "OFFICE SUPPLIES", "e",  null, null, null, 3.0,          4L),
            row("key01", "e",  null, 4L),
            row("key01", "FURNITURE", 1L),
            row("key16", null, 8,    nSp, nSs, nVp, nVs)
            Map<String, Object> body = entityAsMap(response);
            assertTrue(
        // response body delivers "NaN" not (Double) null. Treat NaN expectation match-on-string.
    }
        double vs = 9.963636363636363;
            row("key06", "e",  8,    eSp, eSs, eVp, eVs),
            row("key08", "TECHNOLOGY",      null, null, tNull, techAvgOuter),
        assertRowsEqual(response,
        assertRowsEqual(
    /** sql IT: testEventstatsBySpan. Bucketing key has no nulls — uses {@code int3}, which is
            row("key16", 1L)
            row("key16", "TECHNOLOGY",      null, 8,    tNull, techAvgOuter)
    // ── Basic eventstats (no by) ───────────────────────────────────────────────
    }
            row("key05", "OFFICE SUPPLIES", null, 3,    null, 8.0),
 *                     var_pop=4.66666666666667  var_samp=7
     *    <li>(OFFICE SUPPLIES,'e') int0=[8] (3 nulls dropped) → avg=8</li>
    /** sql IT: testEventstatsByWithNullBucket. {@code bucket_nullable=false} skips the
        double avg0 = 47.0 / 9;
                + " | eventstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs"
 *
            "source=" + DATASET.indexName + " | sort key"
     *  per-str0 avg-of-avg.
            row("key10", "TECHNOLOGY", 1L),
    }
            }
        Map<String, Object> r1 = executePpl(
    @SuppressWarnings({"unchecked", "varargs"})
            row("key11", "TECHNOLOGY",      10,   9L, 7.0, 4, 11),
            row("key12", null, sp, ss, vp, vs),
     *  rows form their own partition and aggregate normally over its non-null int0 values.
     *  {@code DataFusionFragmentConvertor.replaceInput} as a separate {@code attachFragmentOnTop}
     *  </ul>
     *    <li>(OFFICE SUPPLIES, 'e') int0=[8] → avg=8, applied to 4 rows → outer feed: {8,8,8,8}</li>
            response,
     *  After filter:  FURNITURE = 0 rows, OFFICE SUPPLIES = 4 rows, TECHNOLOGY = 9 rows.
            row("key10", "e",  4,    10L, 6.0, 1, 11),
            row("key08", null, null, nSp, nSs, nVp, nVs),
        );
            } catch (Exception ioe) {
 *   span(age,10) → span(int0,10)  — but PPL `span()` UDF is not registered on the
            row("key05", null, 3,    4L),
        // bucket 0 (9 rows int0∈[1,8]): avg=47/9; bucket 10 (2 rows {10,11}): avg=10.5;
 *     TECHNOLOGY      (9 rows, int0=[8,4,10,4,11,4,8]) sum=49  avg=7   min=4   max=11
            row("key08", null, null, 2L),
            row("key03", "OFFICE SUPPLIES", "e",  null, 8.0,  8.0),
            row("key00", "e",  1,    10L,  6.0,  1,    11),
        );
    }
            row("key04", null, 7,    nSp, nSs, nVp, nVs),
            row("key11", 10,   sp, ss, vp, vs),
 *
        double ss = 3.1565228279922772;
            row("key13", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
            row("key00", "FURNITURE", 1L),
 *                                  analytics-engine route until #21621 lands; bySpan tests
        }
            row("key14", "e",  11,   1L),
                + " | fields key, str3, int0, cnt"
        double eSp = 3.3166247903554, eSs = 3.63318042491699, eVp = 11.0, eVs = 13.2;
     *  per-str0 average of those.
    /** Send a PPL query and assert it fails with ANY error response. Used for cases where
    /** Empty-partition window on a 3-shard index. Global SUM/AVG/MIN/MAX must equal the
            row("key02", null, sp, ss, vp, vs),
        );
            row("key09", 8,    sp, ss, vp, vs),
            row("key02", "OFFICE SUPPLIES", "e",  null, 8.0,         8.0),
        Request request = new Request("POST", "/_plugins/_ppl");
    // BackendPlanAdapter rewrites RexOver(DISTINCT_COUNT_APPROX) → APPROX_COUNT_DISTINCT,
        );
            row("key16", 8,    9L, avg0, 1,    8)
        ensureMultiShardProvisioned();
 *   <li>{@code span()} as a PARTITION BY key works after BackendPlanAdapter is taught to
            row("key04", 7,    17L, avg, 1, 11),
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str0"
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,  8.0),
            "source=" + DATASET.indexName + " | sort key"
            "source=" + DATASET.indexName + " | sort key"
     *  dc with {@code by str0}. Per-partition HLL state is built per shard, merged at the
            row("key15", "TECHNOLOGY", 1L),
            row("key02", "OFFICE SUPPLIES", "e",  null, 8.0,  8.0),
            row("key01", "e",  null, 10L, 6.0, 1, 11),
    // ── Helpers ────────────────────────────────────────────────────────────────
            row("key15", "TECHNOLOGY",      4,    5L),
 *
            row("key09", "TECHNOLOGY",      "e",  8,    6.75,  techAvgOuter),
 *       calcs cannot reproduce; we test the int0-NULL case instead, which exercises the same
            row("key11", "TECHNOLOGY",      null, 10,   10.0, 5.0,  techNullBavg, 9L),
            row("key06", "e",  8,    5L),
        for (int j = 0; j < expected.length; j++) {
        // (null,0)=4, (null,null)=2, (null,10)=1.
            row("key12", null, null, 7L,  6.4, 3, 10),
 */
    }
        );
            row("key08", null, 17L, avg, 1, 11),
     *  </ul>
        assertRowsEqual(response,
 *                     var_pop=7.71428571428571  var_samp=9
            row("key08", null, null, 2L),
        // bucket 10: 8 rows, int0 non-null=[8,4,4,11,4] → cnt=8, avg=31/5, min=4, max=11
    private static void assertCellEquals(String message, Object expected, Object actual) {
        assertRowsEqual(response,
     *  may change as more analytics-engine functionality lands). The contract here is just
     *  ({1,7,3,8}): stddev_samp({1,7,3,8}) ≈ 3.304. The 4 null-int0 rows form the null-bucket
            row("key00", "FURNITURE",       1,    1L),
            row("key03", "OFFICE SUPPLIES", null, 3L),
        Map<String, Object> response = executePpl(
 *     stddev_pop=3.00962642859034 stddev_samp=3.15652282799228
            row("key15", "e",  4,    5L),
            row("key16", null, 8,    7L,  6.4, 3, 10)
            List<Object> want = expected[i];
 * to the calcs schema (see field-translation table below). Reachable cases assert exact rows;
            row("key06", "OFFICE SUPPLIES", 8,    ss),
 *     count=17  count(int0)=11  sum=68  min=1  max=11  avg=68/11
        List<Object> got = rows.get(0);
                + " | eventstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs by str0"
            row("key15", 4,    17L, avg, 1, 11),
            row("key00", "FURNITURE",       "e",  1,    1.0,  1.0),
        );
            row("key04", 7,    17L, avg, 1, 11),
        ensureMultiShardProvisioned();
            row("key02", "OFFICE SUPPLIES", 1L),
            "source=" + DATASET_MULTI.indexName + " | sort key"
            row("key12", null, 17L, avg, 1, 11),
            row("key09", "TECHNOLOGY",      "e",  8,    6.75,  techAvgOuter),
                + " | fields key, int0, cnt, avg, mn, mx"
            row("key04", "OFFICE SUPPLIES", 1L),
        // timestamp column, but the contract here is just "this PPL form is not yet supported".
     *  7 nulls + 10 'e' rows — covers null-key partition handling. */
            row("key01", null, sp, ss, vp, vs),
    public void testEventstatsVariance() throws IOException {
        );
 * <h2>Calcs distribution facts (computed from bulk.json)</h2>
            row("key12", "TECHNOLOGY",      null, 9L, 7.0, 4, 11),
     *  str0 partition (FURNITURE×2, OFFICE SUPPLIES×6, TECHNOLOGY×9) necessarily spans
        );
                + " | fields key, str0, str3, int0, avg_int0, avg_str0_int0"
            row("key04", 3L), row("key05", 3L), row("key06", 3L), row("key07", 3L),
            row("key00", "e",  1,    5L),
            row("key12", null, sp, ss, vp, vs),
            row("key04", 1L), row("key05", 1L), row("key06", 1L), row("key07", 1L),
            row("key09", 8,    9L, avg0, 1,    8),
     *    <li>FURNITURE  rows={(F,e)×2}                                  → avg(avg)=1</li>
    /** sql IT: testMultipleEventstatsWithNullBucket. {@code bucket_nullable=false} on chained
            row("key12", 1L), row("key13", 1L), row("key14", 1L), row("key15", 1L),
    /** sql IT: testMultipleEventstats. Chain two eventstats: per-(str3, str0) avg, then
            row("key14", "TECHNOLOGY",      11,   tSp,  tSs,        tVp,  tVs),
            row("key03", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
            row("key13", 4,    sp, ss, vp, vs),
        Map<String, Object> response = executePpl(
    /** sql IT: testEventstatsByMultiplePartitions1. {@code by span(int0, 10), str0} — splits
            "percentile_approx"
            row("key03", "OFFICE SUPPLIES", null, osSp, osSs,       osVp, osVs),
    public void testEventstatsBySpan() throws IOException {
            row("key13", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
            "source=" + DATASET.indexName + " | sort key | eventstats dc(str3) as dc_str3 | fields key, dc_str3"
            row("key08", 3L), row("key09", 3L), row("key10", 3L), row("key11", 3L),
        double tNull = 22.0 / 3.0;
    }
        );
 * </ul>
            row("key08", "TECHNOLOGY",      null, 2L),
     *  from the per-(str0, str3) avg; second eventstats then sees fewer rows feeding the
     *  "this PPL form is not yet supported" — if the query unexpectedly succeeds the test
 */
        assertRowsEqual(response,
            row("key06", "e",  8,    10L, 6.0, 1, 11),
     *  <ol>
     *  prove the rewire stays correct across multiple bundles on the multi-shard exchange
     *  {@link org.opensearch.analytics.planner.rel.OpenSearchProject#computeSelfCost} forces
            return;
     *    <li>(OFFICE SUPPLIES, 'e') 8-5 = 3 → passes (4 rows)</li>
    }
     *    <li>eventstats count(bavg) as c by str0 — count surviving rows per str0</li>
            row("key05", 3,    17L, avg, 1, 11),
 * <pre>
        );
        );
            row("key02", "OFFICE SUPPLIES", null, 3L),
            row("key11", "TECHNOLOGY",      10,   2L),
                + " | fields key, str3, int0, cnt, avg, mn, mx"
            row("key05", "OFFICE SUPPLIES", 1L),
        double techAvgOuter = 191.0 / 27.0;
 * cases that depend on functionality not yet wired through the analytics-engine route are
     *    <li>(OFFICE SUPPLIES,null) int0=[7,3] → avg=5</li>
     *  bucket 0 (int3 ∈ [0,10), 9 rows) and bucket 10 (int3 ∈ [10,20), 8 rows).
            row("key09", 8,    17L, avg, 1, 11),
        );
        // Per-(str0, str3) avg(int0): F/'e'=1, OS/'e'=8, OS/null=5, T/'e'=6.75, T/null=22/3.
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {
            row("key16", "TECHNOLOGY",      null, 8,    null, 6.75)
            row("key04", 1L), row("key05", 1L), row("key06", 1L), row("key07", 1L),
            row("key12", null, null, 2L),
     *  PPL frontend with {@code "Unexpected window function: <name>"} before reaching the
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        assertRowsEqual(response,
            row("key00", 8,  1,    9L, avg0,  1, 10),
            row("key07", 3,  null, 9L, avg0,  1, 10),
            row("key01", "FURNITURE",       null, 1L),
     *        → 9 rows × {6.75×4, 22/3×5}
        Map<String, Object> response = executePpl(
            row("key04", "OFFICE SUPPLIES", 7,    3L),
            "percentile"
import org.opensearch.client.Response;
            row("key13", "TECHNOLOGY",      null, 4,    tNull, techAvgOuter),
            row("key00", "FURNITURE",       1,    ss),
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
    public void testEventstatsEmptyRows() throws IOException {
    public void testEventstatsVarianceBySpan() throws IOException {
        );
            assertEquals(message, expected, actual);
    }
            row("key00", "FURNITURE",       1,    2L, 1.0, 1, 1),
        if (multiProvisioned == false) {
    @SafeVarargs
            row("key10", "TECHNOLOGY",      "e",  4,    6.75, 6.75),
            row("key13", 4,    17L, avg, 1, 11),
            row("key11", 10,   2L, 10.5, 10,   11),
        );
        assertRowsEqual(response,
                + " var_pop(int0), var_samp(int0) by str0"
            row("key00", 1,    sp, ss, vp, vs),
        assertRowsEqual(response,
     *  PARTIAL/FINAL split + SINGLETON-gather path for distinct-count. dc is set-based:
     *  eventstats chain. Filter and re-aggregate. Calcs translation:
 *     var_pop=9.05785123966942   var_samp=9.96363636363636
        // Every row sees the same global dc(str3) = 1 (only "e" appears as a non-null value).
            row("key13", null, 4,    nSp, nSs, nVp, nVs),
            row("key01", "FURNITURE",       null, 0.0,  (Double) null, 0.0,  (Double) null),
        Map<String, Object> response = executePpl(
     *    <li>OFFICE SUPPLIES → 4</li>
        double vs = 9.963636363636363;
    private static void assertScalarRow(Map<String, Object> response, Object... expected) {
            row("key07", "OFFICE SUPPLIES", null, 3L),
        // bucket_nullable=false drops str3-null partition's inner avg → avg_int0=null on those rows.
            row("key07", null, sp, ss, vp, vs),
        );
}
            row("key04", 7,    sp, ss, vp, vs),
 *   <li>calcs has no rows with NULL str0 / NULL str3 (other than rows already nullable on str3).
            row("key14", 11,   17L, avg, 1, 11),
            row("key12", "TECHNOLOGY",      null, 2L),
     *  </ul>
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,         8.0),
            "source=" + DATASET.indexName + " | sort key"
        assertRowsEqual(response,
            "source=" + DATASET.indexName + " | sort key | eventstats dc(str3) as dc_str3 by str0 | fields key, str0, dc_str3"
        Map<String, Object> response = executePpl(
        );
     */
     *  every shard contributes a partial HLL sketch, the coordinator merges them into a
    }
            assertEquals("Column count mismatch at row " + i, want.size(), got.size());
 * The OpenSearch Contributors require contributions made to
            row("key07", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
            row("key14", "e",  11,   10L, 6.0, 1, 11),
    }
import java.util.Arrays;
        Map<String, Object> response = executePpl(
            row("key15", "TECHNOLOGY",      "e",  4,    6.75,  techAvgOuter),
 *     OFFICE SUPPLIES (6 rows, int0=[7,3,8])          sum=18  avg=6   min=3   max=8
     *  is regressed, sum/min/max would still be correct (commutative + associative is
            row("key09", "TECHNOLOGY",      8,    9L, 7.0, 4, 11),
            row("key00", 1L), row("key01", 1L), row("key02", 1L), row("key03", 1L),
    public void testEventstatsVarianceWithNull() throws IOException {
    // {FURNITURE, OFFICE SUPPLIES, TECHNOLOGY} on every row → dc(str0)=3. eventstats
            row("key03", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
        Map<String, Object> response = executePpl(
    public void testEventstatsEarliestAndLatest() throws IOException {
     *  {@link #testEventstatsBy} prove the gather is happening. */
     *  {@link #testEventstatsByWithNull} — null-key rows now show NULL aggregates instead of
                + " | eventstats avg(int0) as avg_int0 by str3, str0"
     *  — sql-plugin's variant uses STATE_COUNTRY_WITH_NULL to exercise null handling, but this QA
                + " | eventstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs by str3"
    @SuppressWarnings("unchecked")
    private static boolean multiProvisioned = false;
     *  NaN (DataFusion's behavior under Bessel's correction with n=1). */
        );
            row("key06", 8,    17L, avg, 1, 11),
        );
            row("key03", null, 6L, null, null, null),
            row("key16", "TECHNOLOGY",      8,    9L, 7.0, 4, 11)
            row("key12", 1L), row("key13", 1L), row("key14", 1L), row("key15", 1L),
            row("key13", "TECHNOLOGY",      4,    5L),
            row("key02", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
            row("key07", "OFFICE SUPPLIES", "e",  null, 8.0,  8.0),
            row("key06", "e",  8,    10L,  6.0,  1,    11),
            response,
     *  fully populated in calcs. {@code span(int3, 10)} produces two buckets:
     *  Each output row carries the same partition-constant (cnt, avg, mn, mx) broadcast from
 *   By str0:
            row("key10", "TECHNOLOGY",      4,    tSp,  tSs,        tVp,  tVs),
            row("key13", null, 4,    4L),
        // count(bavg) grouped by str0: OS=4 (the 4 'e' rows in OS), T=9 (all 9 T rows).
            row("key05", null, 3,    4L),
            row("key02", 2,  null, 9L, avg0,  1, 10),
 * <h2>Limitations vs sql IT</h2>
    }
     *    <li>eventstats avg(b) as bavg by str0, str3 — equivalent to per-(str0, str3)
    // ── Unsupported window functions ───────────────────────────────────────────
        );
            row("key00", "e",  1,    eSp, eSs, eVp, eVs),
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by span(int0, 10)"
            "source=" + DATASET.indexName + " | sort key"
            row("key02", "OFFICE SUPPLIES", null, 3L),
    // ── Multiple eventstats (chained) ──────────────────────────────────────────
            row("key05", 3,    17L, avg, 1, 11),
            row("key16", "TECHNOLOGY",      8,    5L)
 *   <li>{@code logs} index is not provisioned in this QA module; {@code testEventstatsEarliestAndLatest}
            row("key09", "TECHNOLOGY",      8,    5L),
 *     FURNITURE       (2 rows, int0=[1])              sum=1   avg=1   min=1   max=1
            row("key02", "e",  null, eSp, eSs, eVp, eVs),
     *  index. Calcs's 17 rows distribute across 3 shards via UUID-hashed doc ids, so each
            row("key00", "e",  1,    5L),
            row("key11", 10,   sp, ss, vp, vs),
            row("key04", "OFFICE SUPPLIES", 7,    ss),
    }
            row("key11", "TECHNOLOGY",      null, 10,   tNull, techAvgOuter),
     *  <ul>
    /** sql IT: testEventstatsVarianceBy. Per-str0 variance broadcast to every row.
 *
/*
    /** sql IT: testEventstatsByMultiplePartitionsWithNull2. Same query as
     *  <ul>
        Map<String, Object> response = executePpl(
            row("key09", "e",  8,    5L),
        //   OFFICE SUPPLIES (only str3='e' contributes): avg=8.0
     *  Per-str0 avg(avg_int0) (avg of the per-(str3,str0) avg values weighted by row count):
     *    <li>eventstats avg(int0) as a by str0, str3, key (key is unique → a == int0 for
        assertRowsEqual(
    public void testEventstats_3shard() throws IOException {
     *  <ul>
     *  <ul>
            row("key04", null, 7,    7L,  6.4, 3, 10),
            "source=" + DATASET.indexName + " | eventstats earliest(str0), latest(str0) by str3"
            row("key03", null, sp, ss, vp, vs),
            row("key01", "FURNITURE",       null, null),
        // Same per-(str0) aggregates as testEventstatsBy on single-shard.
            row("key05", "OFFICE SUPPLIES", 3,    6L, 6.0, 3, 8),
        }
            row("key15", "e",  4,    10L, 6.0, 1, 11),
            row("key12", null, 6L, null, null, null),
            row("key09", "TECHNOLOGY", 1L),
            row("key16", "TECHNOLOGY",      null, 8,    tNull, techAvgOuter)
            row("key07", "e",  null, 4L),
    /** sql IT: testEventstatsEarliestAndLatest. {@code earliest/latest} on calcs trip the PPL
     *  </ul>
     *  eventstats. With calcs (str3 has nulls — 7 of them — but str0 has no nulls):
            row("key05", "OFFICE SUPPLIES", null, 3,    5.0,   osAvgOuter),
        assertRowsEqual(response,
     *    <li>(TECHNOLOGY, 'e') 6.75-5 = 1.75 → passes (4 rows)</li>
                + " | eventstats avg(avg_int0) as avg_str0_int0 by str0"
            "source=" + DATASET.indexName + " | sort key"
        double sp = 3.009626428590336;
            }
                + " | eventstats count() as cnt by span(int0, 10), str3"
            row("key00", "FURNITURE",       "e",  1,    1.0,         1.0),
            row("key05", 3,    9L, avg0, 1,    8),
            fail("Expected query [" + ppl + "] to fail with [" + expectedSubstring + "] but got: " + body);
    }
        ensureMultiShardProvisioned();
        assertRowsEqual(response,
            row("key12", "TECHNOLOGY",      null, tSp,  tSs,        tVp,  tVs),
    @Override
            row("key14", "e",  11,   eSp, eSs, eVp, eVs),
    /** sql IT: testEventstatsBy. eventstats partitioned by str0. Per-partition int0 aggregates
            row("key03", "OFFICE SUPPLIES", null, null),
        Map<String, Object> response = executePpl(
            row("key13", null, 4,    null, null, null, null),
     *    <li>where bavg > 0 — filters partitions whose avg(int0) is &gt; 5</li>
     */
        );
            row("key12", null, null, 2L),
            row("key15", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
            row("key01", "FURNITURE",       "e",  null, 1.0,   1.0),
     *    <li>(FURNITURE, 'e') 1-5 = -4 → fails {@code > 0}</li>
            row("key02", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
        double ss = 3.1565228279922772;
            "source=" + DATASET.indexName + " | sort key"
        // Jackson serializes (Double) null as the string "NaN" inside JSON arrays, so the
                + " | fields key, str0, str3, int0, a, max_a"
        //   OFFICE SUPPLIES: max(8.0, 5.0) = 8.0
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str0"
import java.io.IOException;
            row("key05", "OFFICE SUPPLIES", 3,    ss),
                + " | fields key, str3, int0, cnt, avg, mn, mx"
                + " | eventstats count(bavg) as c by str0"
            "source=" + DATASET.indexName + " | where key = 'non-existed' | eventstats count(),"
        );
    /** sql IT: testEventstatsBySpanWithNull. Bucketing key has nulls — uses {@code int0}
            row("key04", 9,  7,    9L, avg0,  1, 10),
            row("key08", "TECHNOLOGY",      null, null, tNull, techAvgOuter),
        );
        double ss = 3.304037933599835;
        if (expected instanceof Double && Double.isNaN((Double) expected)
        double techNullBavg = 22.0 / 3.0 - 5;  // 7.333... - 5 = 2.333...
     *  {@code str3} has 7 nulls (int0 non-null=[7,3,10,4,8] → cnt=7, avg=6.4, min=3, max=10)
            fail("Expected query [" + ppl + "] to fail but got: " + body);
        );
            "source=" + DATASET.indexName + " | sort key"
            row("key08", "TECHNOLOGY",      null, 9L, 7.0, 4, 11),
        // str3=null: 7 rows, int0 non-null=[7,3,10,4,8] → sp,ss,vp,vs
     *  count(*)=17, count(int0)=11 — eventstats count() counts every row including int0 nulls.
 *   country    → str0      (keyword; 3 distinct: FURNITURE, OFFICE SUPPLIES, TECHNOLOGY)
            DatasetProvisioner.provision(client(), DATASET);
        Map<String, Object> response = executePpl(
            row("key13", "TECHNOLOGY",      null, 4,    null, 6.75),
            "source=" + DATASET_MULTI.indexName + " | sort key"
    }
    /** sql IT: testEventstatsDistinctCountWithNull. Same query as {@link #testEventstatsDistinctCount}
     *  empty stream emits 0 rows for both forms. */
    public void testEventstatsDistinctCountFunction() throws IOException {
/**
                + " | eventstats bucket_nullable=false count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str3"
                + " | fields key, str0, int0, cnt"
     *  per-shard window evaluation would silently produce wrong values. */
        double osAvgOuter = 7.0;
     *  NaN-aware: NaN matches NaN. */
                + " | fields key, str0, int0, cnt"
        ensureMultiShardProvisioned();
        Map<String, Object> response = executePpl(
            row("key06", "OFFICE SUPPLIES", 8,    3L),
     *  ({@link org.opensearch.analytics.planner.rel.OpenSearchProject#computeSelfCost}) on
            row("key12", "TECHNOLOGY", 1L),
            row("key02", null, 17L, avg, 1, 11),
            row("key10", "e",  4,    5L),
            row("key09", "TECHNOLOGY", 1L),
            }
    public void testMultipleEventstatsWithEval() throws IOException {
            DatasetProvisioner.provision(client(), DATASET_MULTI, 3);
            row("key01", "FURNITURE",       "e",  null, 1.0,  1.0),
        );
    public void testEventstatsByWithNull() throws IOException {
            row("key00", "FURNITURE",       1,    2L, 1.0, 1, 1),
    public void testEventstatsByMultiplePartitions2() throws IOException {
     *        avg(int0)-5</li>
            row("key10", 4,    9L, avg0, 1,    8),
     *  and 10 'e' rows (int0 non-null=[1,8,8,4,11,4] → cnt=10, avg=6.0, min=1, max=11). */
            row("key08", 17, null, 8L, avg10, 4, 11),
        // (str0, span(int0,10)) buckets — cnt is the bucket size:
        );
            row("key16", null, 8,    4L)
            row("key04", "OFFICE SUPPLIES", 1L),
            row("key07", "OFFICE SUPPLIES", "e",  null, null, null, 3.0,          4L),
            row("key06", 8,    sp, ss, vp, vs),
            "source=" + DATASET.indexName + " | sort key | eventstats dc(str3) as dc_str3 | fields key, dc_str3"
 *   name       → key       (keyword; unique 17 row-id values key00..key16)
        assertRowCount(r1, 0);
            row("key05", "OFFICE SUPPLIES", 1L),
            row("key00", "FURNITURE",       "e",  1,    1.0,   1.0),
                + " | fields key, int0, sp, ss, vp, vs"
            row("key03", null, sp, ss, vp, vs),
                + " | fields key, str0, str3, int0, a, b, bavg, c"
                + " | sort key | eventstats dc(str3) as dc_str3 by str0 | fields key, str0, dc_str3"
            row("key09", 8,    sp, ss, vp, vs),
        double osAvgOuter = 7.0;
            row("key15", "e",  4,    eSp, eSs, eVp, eVs),
    public void testEventstatsVarianceBy() throws IOException {
        double osSp = 2.160246899469287, osSs = 2.6457513110645907, osVp = 4.666666666666667, osVs = 7.0;
            "source=" + DATASET.indexName + " | sort key"
            row("key11", "TECHNOLOGY",      10,   2L),
            row("key09", "TECHNOLOGY",      "e",  8,    6.75, 6.75),
            row("key01", "FURNITURE",       "e",  null, 1.0,   1.0),
            Map<String, Object> body = entityAsMap(response);
     *  {@link org.opensearch.analytics.planner.rel.OpenSearchProject#liftNestedRexOver},
            row("key14", "TECHNOLOGY",      "e",  11,   6.75,  techAvgOuter),
            row("key03", "OFFICE SUPPLIES", "e",  null, null, null, 3.0,          4L),
     *  span buckets further by str0. */
        }
            row("key12", "TECHNOLOGY",      null, null, tNull, techAvgOuter),
            row("key06", "OFFICE SUPPLIES", 8,    3L),
 *       collapse via {@code | stats max(...) by int0} and assert exact per-bucket rows.</li>
            row("key09", 8,    17L, avg, 1, 11),
            row("key10", 4,    17L, avg, 1, 11),
     *  as single-shard. */
            row("key13", null, 4,    4L),
     *  FURNITURE has only 1 non-null int0 (key00=1, key01=null) → var_samp/stddev_samp emit
            row("key12", "TECHNOLOGY",      null, null, tNull, techAvgOuter),
    private static boolean dataProvisioned = false;
 *   age        → int0      (integer; 11 non-null + 6 nulls)
        } catch (ResponseException expected) {
            row("key00", 1L), row("key01", 1L), row("key02", 1L), row("key03", 1L),
        if (expected instanceof Number && actual instanceof Number) {
    // ── Variance / stddev ──────────────────────────────────────────────────────
            row("key01", null, 17L, avg, 1, 11),
            row("key11", "TECHNOLOGY", 1L),
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
                + " | eventstats avg(b) as bavg by str0, str3"
     *  the (cnt=7, avg=6.4, min=3, max=10) the default mode would broadcast. */
            "source=" + DATASET.indexName + " | sort key"
    private static final Dataset DATASET_MULTI = new Dataset("calcs", "calcs_multi_eventstats");
        );
            row("key15", "TECHNOLOGY",      "e",  4,    6.75, 6.75),
        // bucket 0: 9 rows, int0 non-null=[1,7,3,8,10,8] → cnt=9, avg=37/6, min=1, max=10
        assertRowsEqual(response,
            "source=" + DATASET.indexName + " | sort key"
        // Outer eventstats on str0 then averages only the non-null avg_int0 within each str0:
        // null bucket (6 rows int0=null): all aggregates NULL.
                + " var_pop(int0), var_samp(int0)"
        assertRowsEqual(response,
            row("key02", "e",  null, 4L),
        double nSp = 2.576819745345025, nSs = 2.880972058177586, nVp = 6.639999999999998, nVs = 8.299999999999997;
            row("key04", "OFFICE SUPPLIES", 7,    6L, 6.0, 3, 8),
 *       n, NULL) → FLOOR(field/n)*n before substrait emission. The {@code bySpan} cases
    }
    /** sql IT: testEventstats. eventstats count(), avg, min, max — global window over all rows.
    public void testEventstatsByMultiplePartitionsWithNull1() throws IOException {
            row("key01", null, sp, ss, vp, vs),
        }
                + " | eventstats count() as cnt by span(int0, 10), str3"
            "source=" + DATASET.indexName + " | sort key"
        }
            row("key14", 18, 11,   8L, avg10, 4, 11),
    public void testMultipleEventstatsWithNullBucket() throws IOException {
            row("key11", null, 10,   1L),
    /** sql IT: testEventstatsByMultiplePartitionsWithNull1. Same query as
        }
    public void testEventstatsDistinctCountWithNull() throws IOException {
            row("key09", "TECHNOLOGY",      8,    9L, 7.0, 4, 11),
    private static void assertRowCount(Map<String, Object> response, int expected) {
            row("key09", "TECHNOLOGY",      8,    tSp,  tSs,        tVp,  tVs),
        assertEquals("Row count mismatch", expected.length, actualRows.size());
    // ── eventstats … by ────────────────────────────────────────────────────────
    /** sql IT: testEventstatsVariance. Global stddev_pop / stddev_samp / var_pop / var_samp
            row("key05", 7,  3,    9L, avg0,  1, 10),
        // bavg = avg(int0) by (str0, str3) - 5; filter `bavg > 0` keeps only str0/str3 buckets
    public void testEventstatsBySpanWithNull() throws IOException {
            row("key03", "e",  null, 10L,  6.0,  1,    11),
            row("key09", "e",  8,    10L,  6.0,  1,    11),
            row("key05", "OFFICE SUPPLIES", 3,    6L, 6.0, 3, 8),
     *  document ids, so partitions necessarily span shards — without the gather edge,
    }
        assertNotNull("Response missing 'rows'", rows);
    @SuppressWarnings("unchecked")
            row("key11", "TECHNOLOGY", 1L),
     *  carries 6 null-key rows whose int0 is null → all aggregates are NULL. */
     *  count() per str0 (non-null bavg only):
     *    <li>TECHNOLOGY → avg over {6.75,6.75,6.75,6.75} = 6.75</li>
     *  partial-final safe even without gather) but avg would NOT — avg of partial-shard
    }
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
                + " | fields key, int0, cnt, avg, mn, mx"
            row("key08", "TECHNOLOGY",      null, tSp,  tSs,        tVp,  tVs),
import org.opensearch.client.ResponseException;
    // ── Empty input ────────────────────────────────────────────────────────────
        );
            List<Object> got = actualRows.get(i);
    /** sql IT: testEventstatsVarianceBySpan. After filtering out TECHNOLOGY, 8 rows remain
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by span(int3, 10)"
            row("key10", "TECHNOLOGY",      4,    5L),
        );
            row("key04", null, 7,    null, null, null, null),
            row("key16", "TECHNOLOGY",      8,    5L)
            row("key07", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
        // dc(str0) = 3 across all 17 rows (FURNITURE, OFFICE SUPPLIES, TECHNOLOGY).
        assertRowCount(r2, 0);
    public void testEventstatsDistinctCount() throws IOException {
            row("key07", "e",  null, eSp, eSs, eVp, eVs),
        Map<String, Object> response = executePpl(
 *       org.opensearch.analytics.spi.WindowFunction}; expectThrows.</li>
            row("key14", 11,   sp, ss, vp, vs),
            row("key13", "TECHNOLOGY",      null, 4,    tNull, techAvgOuter),
    /** Chained eventstats on a 3-shard index — every {@code eventstats} lowers through
            row("key03", 5,  null, 9L, avg0,  1, 10),
     *    <li>(TECHNOLOGY, null) 22/3-5 ≈ 2.333 → passes (5 rows)</li>
            row("key01", "FURNITURE",       null, 2L, 1.0, 1, 1),
     *  → NULL stddev. */
            "source=" + DATASET.indexName + " | sort key"
        // whose avg(int0)>5: (OS,'e')=8, (T,'e')=6.75, (T,null)=22/3. Each row carries the
            row("key06", "OFFICE SUPPLIES", 1L),
            return;
            row("key00", "FURNITURE",       1,    1L),
            row("key16", 1L)
     *  <p>Per-(str0, str3) avg(int0) — only non-null int0 contributes:
            row("key15", 4,    9L, avg0, 1,    8),
            row("key14", "TECHNOLOGY",      11,   2L),
            "source=" + DATASET.indexName + " | sort key"
            row("key05", null, 3,    7L,  6.4, 3, 10),
                + " | where bavg > 0"
        return Arrays.asList(values);
            row("key04", 1L), row("key05", 1L), row("key06", 1L), row("key07", 1L),
            row("key04", 7,    9L, avg0, 1,    8),
        assertEquals("Row count mismatch", expected, rows.size());
        );
                + " | eventstats avg(avg_int0) as avg_str0_int0 by str0"
     *  </ul>
            row("key06", 8,    9L, avg0, 1,    8),
            row("key04", null, 7,    4L),
            row("key11", null, 10,   1L),
            row("key16", 8,    17L, avg, 1, 11)
 * <p>Mirrors {@code CalcitePPLEventstatsIT} from the {@code opensearch-project/sql} repository
            row("key03", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
    /** Multi-shard alias for tests that exercise the SINGLETON-gather cost gate
    /** Multi-shard variant of {@link #testEventstatsDistinctCount} — exercises the
     *  </ol>
        );
    }
        );
            row("key07", "OFFICE SUPPLIES", null, null)
            row("key00", "FURNITURE",       1,    0.0,  (Double) null, 0.0,  (Double) null),
                + " | fields key, str0, str3, int0, avg_int0, avg_str0_int0"
     *  shards. Without the SINGLETON-gather cost gate that
        // Per-str0 avg(avg_int0): F=1.0, OS=7.0, T=191/27.
     *  <ul>
            row("key04", "OFFICE SUPPLIES", null, 7,    5.0,         8.0),
            row("key14", "TECHNOLOGY",      "e",  11,   6.75,  techAvgOuter),
            for (int j = 0; j < want.size(); j++) {
        );
     *  averages doesn't equal the global average unless rows-per-shard are equal. */
            row("key09", "TECHNOLOGY",      "e",  8,    6.75,        techNullAvg),
        assertRowsEqual(response,
            row("key10", "e",  4,    eSp, eSs, eVp, eVs),
            row("key05", "OFFICE SUPPLIES", 3,    osSp, osSs,       osVp, osVs),
        // (str3, span(int0,10)) buckets: (e,0)=5, (e,null)=4, (e,10)=1;
            row("key09", "e",  8,    eSp, eSs, eVp, eVs),
            row("key12", "TECHNOLOGY", 1L),
            "source=" + DATASET.indexName + " | sort key"
        if (dataProvisioned == false) {
            row("key01", "FURNITURE",       null, 1L),
        Map<String, Object> response = executePpl(
            multiProvisioned = true;
            row("key02", "e",  null, 10L, 6.0, 1, 11),
    public void testEventstatsBy_3shard() throws IOException {
            row("key16", 8,    17L, avg, 1, 11)
     * Send a PPL query expecting an error response. Asserts the response body contains
            row("key05", 3,    sp, ss, vp, vs),
        Map<String, Object> response = executePpl(
            row("key03", null, 17L, avg, 1, 11),
 * Self-contained integration test for PPL {@code eventstats} on the analytics-engine route.
     *  coordinator, then broadcast. Each {@code str0} group sees the same {@code dc(str3)=1}
            dataProvisioned = true;
        assertRowsEqual(response,
            row("key16", 1L)
    }
            row("key07", "OFFICE SUPPLIES", 1L),
 * compatible open source license.
    /** sql IT: testEventstatsDistinctCountByCountry. */
        assertEquals(message, expected, actual);
            row("key02", "OFFICE SUPPLIES", 1L),
            row("key04", null, 7,    4L),
            row("key06", "OFFICE SUPPLIES", 1L),
            row("key15", 4,    sp, ss, vp, vs),
            row("key05", "OFFICE SUPPLIES", 3,    3L),
        assertRowsEqual(response,
 *       recurse into RexOver.window.partitionKeys, so the SpanAdapter rewrites SPAN(field,
    //
     *  (FURNITURE×2 + OFFICE SUPPLIES×6). All non-null int0 values are in span bucket 0
        // Per-partition dc(str3): FURNITURE has 2 rows of "e" (dc=1); OFFICE SUPPLIES has 4 of
            row("key00", "e",  1,    10L, 6.0, 1, 11),
     *  would surface those wrong values. Identical expectations to
        assertNotNull("Response missing 'rows'", rows);
            row("key11", null, 10,   7L,  6.4, 3, 10),
            row("key06", 8,    17L, avg, 1, 11),
        Map<String, Object> response = executePpl(
     *  null-key partition: rows whose {@code by} key is null get NULL window output, while
            row("key15", 4,    17L, avg, 1, 11),
            row("key04", "OFFICE SUPPLIES", null, 7,    5.0,   osAvgOuter),
        assertRowsEqual(response,
                || "NaN".equals(actual))) {
            row("key07", "e",  null, 10L, 6.0, 1, 11),
            row("key08", 1L), row("key09", 1L), row("key10", 1L), row("key11", 1L),
            row("key16", "TECHNOLOGY", 1L)
            "source=" + DATASET_MULTI.indexName + " | sort key | eventstats dc(str3) as dc_str3 | fields key, dc_str3"
    /** Multi-shard variant of {@link #testEventstatsDistinctCountByCountry} — partitioned
import java.util.Map;
            row("key15", "e",  4,    10L,  6.0,  1,    11),
            row("key06", 18, 8,    8L, avg10, 4, 11),
     *  via {@code span(int0, 10)}. */
        Map<String, Object> response = executePpl(
     *        non-null rows, null for null rows) — degenerate per-row result</li>
            row("key13", 4,    sp, ss, vp, vs),
     *  exact rows as single-shard are expected because HLL is exact at calcs's scale. */
        // Per-(str0, str3) avg(int0): see testMultipleEventstats. Per-str0 max of those:
            row("key16", 8,    sp, ss, vp, vs)
     *  Per-bucket int0 aggregates ignore int0 nulls.
            row("key10", "e",  4,    5L),
 *   Global int0: 17 rows, 11 non-null = {1,7,3,8,8,4,10,4,11,4,8}
            row("key02", null, 17L, avg, 1, 11),
            row("key02", "e",  null, 10L,  6.0,  1,    11),
            row("key13", "TECHNOLOGY",      4,    5L),
     *  the single global partition. */
            row("key08", "TECHNOLOGY",      null, 2L),
            row("key14", "TECHNOLOGY",      11,   9L, 7.0, 4, 11),
import java.util.List;
        );
 * <ul>
                + " | eventstats bucket_nullable=false avg(avg_int0) as avg_str0_int0 by str0"
            row("key05", "OFFICE SUPPLIES", 3,    3L),
                assertCellEquals("Cell mismatch at row " + i + ", col " + j, want.get(j), got.get(j));
            row("key13", 18, 4,    8L, avg10, 4, 11),
 * how a future PR observes that they should be promoted to passing assertions.
        Request request = new Request("POST", "/_plugins/_ppl");
 *                     stddev_pop=2.77746029931765  stddev_samp=3
            row("key14", "e",  11,   1L),
     *  FURNITURE 2 rows (cnt=2, avg=1, min/max=1); OFFICE SUPPLIES 6 rows (cnt=6, avg=6, min=3, max=8);
        Map<String, Object> response = executePpl(
            row("key14", "TECHNOLOGY",      "e",  11,   6.75,        techNullAvg),
     *  aggregate semantics are identical. */
     *    <li>OFFICE SUPPLIES rows={(O,e)×4 carrying 8} ∪ {(O,null)×2 carrying 5}
        assertNotNull("Response missing 'rows'", actualRows);
     *  int0={1,7,3,8,8,4,10,4,11,4,8}, mean=68/11. */
            try {
            row("key11", 10,   17L, avg, 1, 11),
     *  analytics-engine planner. */
    /** sql IT: testMultipleEventstatsWithNull. Same query as {@link #testMultipleEventstats} —
            row("key13", "TECHNOLOGY", 1L),
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx"
            row("key04", "OFFICE SUPPLIES", 7,    3L),
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        );
            "source=" + DATASET.indexName + " | sort key | eventstats distinct_count(str0) as dc_str0 | fields key, dc_str0"
    }
     *    <li>TECHNOLOGY rows={(T,e)×4 carrying 6.75} ∪ {(T,null)×5 carrying 22/3}
 * this file be licensed under the Apache-2.0 license or a
    }
            row("key14", "TECHNOLOGY",      11,   9L, 7.0, 4, 11),
    public void testEventstatsBy() throws IOException {
            row("key07", "e",  null, 4L),
        assertRowsEqual(response,
            "source=" + DATASET.indexName + " | eventstats percentile(int0)",
        );
     *  {@link #testEventstatsByMultiplePartitions2}. */
    public void testEventstatsDistinctCountByCountry_3shard() throws IOException {
            row("key16", "TECHNOLOGY",      null, 8,    8.0,  3.0,  techNullBavg, 9L)
        );
            row("key00", 3L), row("key01", 3L), row("key02", 3L), row("key03", 3L),
            row("key07", "OFFICE SUPPLIES", null, osSp, osSs,       osVp, osVs),
     *    <li>eval b = a - 5 → per-row int0-5 (or null)</li>
     *    <li>TECHNOLOGY → 9</li>
    public void testMultipleEventstats() throws IOException {
            row("key16", "TECHNOLOGY",      null, 8,    techNullAvg, techNullAvg)
            row("key03", "e",  null, 4L),
        } catch (ResponseException e) {
            row("key13", 4,    9L, avg0, 1,    8),
            row("key02", "OFFICE SUPPLIES", null, osSp, osSs,       osVp, osVs),
        );
        //   FURNITURE (only str3='e'): avg=1.0
     *  single global sketch, then broadcasts {@code dc(str3)=1} to every row. The same
    public void testChainedEventstats_3shard() throws IOException {
                + " | eventstats bucket_nullable=false avg(int0) as avg_int0 by str3, str0"
            row("key08", 1L), row("key09", 1L), row("key10", 1L), row("key11", 1L),
            row("key12", "TECHNOLOGY",      null, 9L, 7.0, 4, 11),
            row("key05", "OFFICE SUPPLIES", null, 3,    5.0,   osAvgOuter),
    /** sql IT: testEventstatsDistinctCountFunction. {@code distinct_count()} alias for dc. */
     *  the precise error message depends on which lowering path the PPL parser picks (which
 * source IT, with the query string translated from {@code state_country}/{@code logs} schema
        double avg10 = 31.0 / 5;
            row("key12", "TECHNOLOGY",      null, null, null, null, techNullBavg, 9L),
            row("key01", null, 6L, null, null, null),
            row("key07", null, 17L, avg, 1, 11),
    }
        Map<String, Object> response = executePpl(
            row("key11", 10,   17L, avg, 1, 11),
            row("key16", 3L)
            row("key10", 4,    sp, ss, vp, vs),
        assertRowsEqual(response,
            row("key13", "TECHNOLOGY",      4,    tSp,  tSs,        tVp,  tVs),
        );
            row("key07", null, 17L, avg, 1, 11),
     *    <li>(TECHNOLOGY,null) int0=[10,4,8] (2 nulls dropped) → avg=22/3 ≈ 7.333</li>
    /**
    /** sql IT: testEventstatsDistinctCount. */
            row("key00", 1,    17L, avg, 1, 11),
        );
        Map<String, Object> response = executePpl(
                + " | fields key, str0, int0, cnt, avg, mn, mx"
import org.opensearch.client.Request;
        //   FURNITURE: max(1.0) = 1.0
    }
     *  broadcast to every row from the single global partition. Values pre-computed from
        );
     *  frontend's default-{@code @timestamp}-field check (calcs has no @timestamp column).
    }
            row("key07", "OFFICE SUPPLIES", 1L),
        );
            row("key04", "OFFICE SUPPLIES", null, 7,    null, 8.0),
                + " | fields key, str3, int0, cnt"
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,   osAvgOuter),
            row("key13", 4,    17L, avg, 1, 11),
 *   <li>{@code dc} / {@code distinct_count} window function is not in {@link
            row("key15", "TECHNOLOGY", 1L),
 *       The {@code WithNull} variants in sql IT add a row {@code (Kevin, null, null)} that
            row("key14", "TECHNOLOGY",      "e",  11,   6.75, 6.75),
     *  span buckets further by str3 (which has 7 nulls + 10 'e's). */
        }
        Map<String, Object> response = executePpl(
            row("key01", "e",  null, 10L,  6.0,  1,    11),
        );
 *                                  expectThrows.
 *
            row("key02", null, 6L, null, null, null),
            row("key00", 1,    9L, avg0, 1,    8),
            row("key12", "TECHNOLOGY",      null, null, techNullAvg, techNullAvg),
            row("key08", "TECHNOLOGY", 1L),
     *    <li>(FURNITURE,'e') int0=[1] → avg=1</li>
            Response response = client().performRequest(request);
        // "e" + 2 nulls (dc=1); TECHNOLOGY has 4 of "e" + 5 nulls (dc=1).
 * {@code expectThrows} negative tests pinning the precise error message — failing those is
     *        → avg = (191/3)/9 = 191/27 ≈ 7.074074</li>
    public void testEventstatsByMultiplePartitions1() throws IOException {
 *   <li>{@code earliest} / {@code latest} window function is not in {@link
            row("key11", null, 10,   null, null, null, null),
     *  <ul>
            row("key08", null, null, 7L,  6.4, 3, 10),
    }
                + " | eventstats count() as cnt by span(int0, 10), str0"
 *       org.opensearch.analytics.spi.WindowFunction}; expectThrows.</li>
     *        → 6 rows × {8,8,8,8,5,5} → avg=42/6=7.0</li>
        );
        assertRowsEqual(response,
    /** Same eventstats {@code by str0} query as {@link #testEventstatsBy} but on a 3-shard
        );
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str3"
            );
            "source=" + DATASET.indexName + " | sort key"
            row("key15", "TECHNOLOGY",      "e",  4,    4.0,  -1.0, 1.75,         9L),
            row("key09", "e",  8,    10L, 6.0, 1, 11),
            row("key14", "e",  11,   10L,  6.0,  1,    11),
            row("key03", "OFFICE SUPPLIES", 1L),
        Map<String, Object> response = executePpl(
    }
        );
            row("key03", "OFFICE SUPPLIES", 1L),
            row("key08", "TECHNOLOGY",      null, null, null, 6.75),
            "source=" + DATASET.indexName + " | sort key"
        );
    }
        double vp = 9.05785123966942;
 *       null-bubbling-through-window-aggregate code path.</li>
            row("key03", "e",  null, 4L),
            row("key05", 3,    sp, ss, vp, vs),
            Response response = client().performRequest(request);
            row("key12", null, null, null, null, null, null),
        Map<String, Object> response = executePpl(
            row("key01", "e",  null, eSp, eSs, eVp, eVs),
        }
 * <pre>
    /** sql IT: testEventstatsVarianceWithNullBy. Variance partitioned by {@code str3} which has
     *  call; the lifted-window detection has to fire on every one. Two chained eventstats
        double avg = 68.0 / 11.0;
        // str3='e':  10 rows, int0 non-null=[1,8,8,4,11,4] → sp,ss,vp,vs
     *  module only ships the {@code calcs} dataset (whose {@code str3} already has 7 nulls). The
            row("key10", "TECHNOLOGY",      "e",  4,    6.75,        techNullAvg),
            row("key10", 4,    sp, ss, vp, vs),
            row("key09", "e",  8,    5L),
            row("key00", 1,    sp, ss, vp, vs),
    }
            row("key02", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
            row("key14", "TECHNOLOGY", 1L),
            row("key15", "e",  4,    5L),
            row("key05", "OFFICE SUPPLIES", null, 3,    5.0,         8.0),
    // and the DataFusion plugin's approx_count_distinct wrapper UDAF aliases that name to
    }
        );
        );
        assertErrorContains(
            row("key03", "e",  null, eSp, eSs, eVp, eVs),
            row("key13", "TECHNOLOGY", 1L),
        Map<String, Object> response = executePpl(
            row("key14", "TECHNOLOGY", 1L),
                body = e.getMessage();
            row("key02", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
        );
            row("key10", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
    }
        }
                + " | fields key, str0, int0, ss"
        assertRowsEqual(response,
    }
        assertRowsEqual(response,
        );
            row("key10", 11, 4,    8L, avg10, 4, 11),
                + " | eventstats avg(int0) as a by str0, str3, key"
            row("key01", "FURNITURE", 1L),
                + " | eventstats avg(int0) as a by str0, str3"
     *  the second eventstats also bucket_nullable=false: rows with avg_int0=null (the str3-null rows)
            row("key11", 2,  10,   9L, avg0,  1, 10),
            row("key03", "OFFICE SUPPLIES", "e",  null, 8.0,         8.0),
     */
        double sp = 3.009626428590336;
            row("key12", "TECHNOLOGY",      null, null, null, 6.75),
            row("key15", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
            row("key02", "e",  null, 4L),
            "source=" + DATASET.indexName + " | sort key"
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably).
        double avg = 68.0 / 11.0;
        Map<String, Object> response = executePpl(
            row("key10", "TECHNOLOGY",      4,    5L),
     *  same numbers as the single-shard {@link #testEventstats}. If the SINGLETON gather
            row("key14", 11,   2L, 10.5, 10,   11),
            row("key16", null, 8,    null, null, null, null)
     *  partitioned windows. The 17 calcs rows distribute across 3 shards via UUID-hashed
                + " | eventstats stddev_samp(int0) as ss by span(int0, 10)"
            row("key03", "OFFICE SUPPLIES", null, 3L),
            row("key15", 11, 4,    8L, avg10, 4, 11),
            row("key07", null, sp, ss, vp, vs),
            row("key08", null, sp, ss, vp, vs),
    /** sql IT: testEventstatsEmptyRows. {@code where … = 'non-existed' | eventstats …} on an
    protected void onBeforeQuery() throws IOException {
     *  Pairs with {@link #testEventstatsBySpanWithNull} which reintroduces the null bucket
            row("key06", "OFFICE SUPPLIES", 8,    osSp, osSs,       osVp, osVs),
     *  Either way, the path is not reachable on analytics-engine today — assert the failure. */
        );
     *    <li>FURNITURE  → avg over {1,1} = 1.0</li>
     *  producing a 2-layer Project bundle per stage. Each bundle is rewired through
            row("key16", "TECHNOLOGY", 1L)
 * one-to-one — every {@code @Test} method here corresponds to a method of the same name in the
    // broadcasts the global aggregate to every row.
                + " | fields key, str0, str3, int0, avg_int0, avg_str0_int0"
        // FURNITURE entirely filtered out.
            row("key08", null, 6L, null, null, null),
            row("key12", 1L), row("key13", 1L), row("key14", 1L), row("key15", 1L),
            row("key16", null, 8,    4L)
    // DataFusion's built-in approx_distinct (HyperLogLog). At calcs's scale (17 rows, low
     *  the non-null partition aggregates as usual. Same {@code by str3} as
     *    <li>(TECHNOLOGY,'e') int0=[8,4,11,4] → avg=6.75</li>
 * SPDX-License-Identifier: Apache-2.0
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,  3.0,  3.0,          4L),
     *    <li>(FURNITURE, 'e') int0=[1] → avg=1, applied to 2 rows → outer feed: {1,1}</li>
        //   TECHNOLOGY (only str3='e' contributes): avg=6.75
        if (expected == null || actual == null) {
        assertRowsEqual(response,
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx"
            row("key10", "TECHNOLOGY",      "e",  4,    4.0,  -1.0, 1.75,         9L),
 * <h2>Schema translation (sql IT → calcs)</h2>
        assertRowsEqual(response,
            "source=" + DATASET_MULTI.indexName
            row("key11", "TECHNOLOGY",      null, 10,   tNull, techAvgOuter),
            String body;
            row("key12", "TECHNOLOGY",      null, 2L),
            row("key13", "TECHNOLOGY",      null, 4,    techNullAvg, techNullAvg),
    public void testEventstatsDistinctCountByCountry() throws IOException {
    /** sql IT: testEventstatsVarianceWithNull. Same query and result as
            row("key09", "TECHNOLOGY",      8,    5L),
    }
    // ── distinct_count / dc ────────────────────────────────────────────────────
            row("key06", "OFFICE SUPPLIES", 8,    6L, 6.0, 3, 8),
    private void ensureMultiShardProvisioned() throws IOException {
        );
        assertEquals("Expected " + expected.length + " columns", expected.length, got.size());
        assertErrorAny(
            row("key16", "TECHNOLOGY",      8,    tSp,  tSs,        tVp,  tVs)
            row("key07", null, 6L, null, null, null),
    /** sql IT: testEventstatsByWithNull. Default {@code bucket_nullable=true} mode — null-key
                + " | eventstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs"
            row("key12", null, 17L, avg, 1, 11),
        double techAvgOuter = 191.0 / 27.0;
    // cardinality) HLL is exact, so we can assert the exact dc count.
     *  (6 nulls), so {@code span(int0, 10)} produces a null bucket alongside bucket 0
            "source=" + DATASET.indexName + " | where str0 != 'TECHNOLOGY' | sort key"
            row("key00", 1,    17L, avg, 1, 11),
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,   osAvgOuter),
            row("key08", null, 17L, avg, 1, 11),
            row("key00", "FURNITURE",       "e",  1,    1.0,   1.0),
        double tSp  = 2.7774602993176543, tSs = 3.0, tVp = 7.714285714285714, tVs = 9.0;
                + " | eventstats max(a) as max_a by str0"
                body.contains(expectedSubstring)
        double techNullAvg = 22.0 / 3.0;
    // ── earliest / latest — not wired through analytics-engine yet ────────────
            row("key11", "TECHNOLOGY",      10,   tSp,  tSs,        tVp,  tVs),
            row("key02", null, sp, ss, vp, vs),
     * {@code expectedSubstring}. Used for cases that exercise functionality not yet wired
            row("key01", null, 17L, avg, 1, 11),
            row("key01", 13, null, 8L, avg10, 4, 11),
            row("key08", null, sp, ss, vp, vs),
     *  <p>Per-(str0, str3) avg-5: see {@link #testMultipleEventstats} table — adjusted by -5:
     *  calcs has int0 nulls already, so window numerics ignore them by default. */
    private final void assertRowsEqual(Map<String, Object> response, List<Object>... expected) {
 *       expectThrows on the missing index AND the missing earliest/latest window function.</li>
            row("key15", "TECHNOLOGY",      4,    tSp,  tSs,        tVp,  tVs),
            row("key03", "e",  null, 10L, 6.0, 1, 11),
                + " | fields key, int0, sp, ss, vp, vs"
            row("key07", "OFFICE SUPPLIES", "e",  null, 8.0,         8.0),
        assertRowsEqual(response,
            double a = ((Number) actual).doubleValue();
            row("key06", "OFFICE SUPPLIES", 8,    6L, 6.0, 3, 8),
        );
            row("key08", "TECHNOLOGY",      null, null, techNullAvg, techNullAvg),
 *   state      → str3      (keyword; 2 distinct non-null + 7 nulls)
            row("key00", 1L), row("key01", 1L), row("key02", 1L), row("key03", 1L),
     *    <li>(TECHNOLOGY, 'e') int0=[8,4,11,4] → avg=6.75, applied to 4 rows → outer feed: {6.75,6.75,6.75,6.75}</li>
            row("key01", "e",  null, 4L),
            row("key12", 3L), row("key13", 3L), row("key14", 3L), row("key15", 3L),
            row("key12", 11, null, 8L, avg10, 4, 11),
        );
 * </pre>
            row("key16", 0,  8,    9L, avg0,  1, 10)
            row("key09", 2,  8,    9L, avg0,  1, 10),
     *        → sum = 4*6.75 + 5*(22/3) = 27 + 110/3 = (81+110)/3 = 191/3
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
        );
     *  (int0 ∈ [0,10), 9 rows) and bucket 10 (int0 ∈ [10,20), 2 rows). The null bucket
                + " | eventstats avg(int0) as avg_int0 by str3, str0"
     *  path. */
            row("key08", 1L), row("key09", 1L), row("key10", 1L), row("key11", 1L),
     *  broadcast to every row in that partition:
     *  fails loudly, signalling that the assertion should be upgraded to assert exact rows. */
        try {
    public void testUnsupportedWindowFunctions() throws IOException {
            row("key03", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
            // Tolerance for floating-point reduction differences across reduction orders.
    /** sql IT: testMultipleEventstatsWithEval. eventstats → eval → eventstats → where →
    public void testMultipleEventstatsWithNull() throws IOException {
            row("key15", 4,    sp, ss, vp, vs),
    }
 *                     stddev_pop=2.16024689946929  stddev_samp=2.64575131106459
            row("key15", "TECHNOLOGY",      "e",  4,    6.75,  techAvgOuter),
    // ── Multi-shard correctness — exercises the SINGLETON-gather cost gate ────
            row("key04", "OFFICE SUPPLIES", 7,    osSp, osSs,       osVp, osVs),
            assertCellEquals("Cell mismatch at col " + j, expected[j], got.get(j));
     *  contribute as missing to the outer avg's count. avg(avg_int0) by str0 ignores nulls:
            return;
    public void testEventstatsByWithNullBucket() throws IOException {
    }
            row("key10", "TECHNOLOGY", 1L),
            "source=" + DATASET.indexName + " | eventstats percentile_approx(int0)",
            row("key08", null, null, null, null, null, null),
            row("key07", "OFFICE SUPPLIES", null, 3L),
                + " avg(int0), min(int0), max(int0), stddev_pop(int0), stddev_samp(int0),"
    private void assertErrorAny(String ppl) throws IOException {
            double e = ((Number) expected).doubleValue();
                + " | fields key, str3, int0, sp, ss, vp, vs"
            row("key09", "TECHNOLOGY",      "e",  8,    8.0,  3.0,  1.75,         9L),
        // The actual error is "Default @timestamp field not found" because calcs has no
                + " | fields key, str0, int0, sp, ss, vp, vs"
            row("key04", "OFFICE SUPPLIES", null, 7,    5.0,   osAvgOuter),
                + " | fields key, int3, int0, cnt, avg, mn, mx"
            row("key14", "TECHNOLOGY",      11,   2L),
            row("key10", "TECHNOLOGY",      "e",  4,    6.75,  techAvgOuter),
        Map<String, Object> response = executePpl(
     *    <li>OFFICE SUPPLIES → avg over {8,8,8,8} = 8.0</li>
        assertRowsEqual(response,
        ensureMultiShardProvisioned();
            row("key01", "FURNITURE",       "e",  null, 1.0,         1.0),
        for (int i = 0; i < expected.length; i++) {
    private static List<Object> row(Object... values) {
     *  TECHNOLOGY 9 rows (cnt=9, avg=7, min=4, max=11). */
            row("key15", "TECHNOLOGY",      4,    5L),
    }
            row("key15", "TECHNOLOGY",      "e",  4,    6.75,        techNullAvg),
            row("key11", null, 10,   nSp, nSs, nVp, nVs),
            row("key07", "e",  null, 10L,  6.0,  1,    11),
                + " | eval b = a - 5"
     *  </ul>
            row("key05", null, 3,    null, null, null, null),
    public void testEventstatsVarianceWithNullBy() throws IOException {
            // Any error response is acceptable.
     *  {@link #testEventstatsByMultiplePartitions1}. */
            row("key11", "TECHNOLOGY",      null, 10,   null, 6.75),
    public void testEventstats() throws IOException {
            row("key04", "OFFICE SUPPLIES", 7,    6L, 6.0, 3, 8),
            if (Math.abs(e - a) > 1e-9 * Math.max(Math.abs(e), 1.0)) {
            row("key13", null, 4,    7L,  6.4, 3, 10),
            row("key12", null, null, nSp, nSs, nVp, nVs),
     *  <p>After bucket_nullable=false, only str3='e' rows feed the inner avg:
            row("key02", "OFFICE SUPPLIES", null, null),
            row("key10", "TECHNOLOGY",      "e",  4,    6.75,  techAvgOuter),
            row("key08", "TECHNOLOGY",      null, null, null, null, techNullBavg, 9L),
    /** sql IT: testEventstatsByMultiplePartitions2. {@code by span(int0, 10), str3} — splits
            row("key04", 7,    sp, ss, vp, vs),
            row("key14", 11,   17L, avg, 1, 11),
        Map<String, Object> r2 = executePpl(
                "Query [" + ppl + "] expected error containing [" + expectedSubstring + "] but body was: " + body,
        //   TECHNOLOGY: max(6.75, 22/3 ≈ 7.333) = 22/3
            "source=" + DATASET_MULTI.indexName + " | sort key"
        double avg0 = 37.0 / 6;
            row("key16", 8,    sp, ss, vp, vs)
     *  bucket_nullable=false on the first eventstats drops rows where {@code str3 IS NULL}
            row("key10", "e",  4,    10L,  6.0,  1,    11),
     *  partial sums per shard for the same partition — and {@code stats max(...) by str0}
                + " | fields key, int0, cnt, avg, mn, mx"
            row("key07", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
    // calcs.str3 is "e" on every non-null row → dc(str3)=1. calcs.str0 has three values
        );
        );
            row("key01", "FURNITURE",       null, 2L, 1.0, 1, 1),
        assertErrorContains(
        try {
        );
            row("key06", "e",  8,    5L),
            row("key00", "FURNITURE", 1L),
            row("key11", "TECHNOLOGY",      null, 10,   techNullAvg, techNullAvg),
                + " avg(int0), min(int0), max(int0), stddev_pop(int0), stddev_samp(int0),"
            row("key10", 4,    17L, avg, 1, 11),
    }
     */
        assertRowsEqual(response,
        );
        );
    }
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
                + " | fields key, str0, int0, cnt, avg, mn, mx"
            row("key05", null, 3,    nSp, nSs, nVp, nVs),
            row("key07", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
     *  The 7 str3-null rows have inner avg=null (bucket_nullable=false drops the inner partition);
            row("key13", "TECHNOLOGY",      null, 4,    4.0,  -1.0, techNullBavg, 9L),
    }
        double tNull = 22.0 / 3.0;
            row("key10", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
            row("key11", "TECHNOLOGY",      10,   9L, 7.0, 4, 11),
            row("key14", 11,   sp, ss, vp, vs),
