     *    <li>TECHNOLOGY → avg over {6.75,6.75,6.75,6.75} = 6.75</li>
        } catch (ResponseException e) {
     *  via {@code span(int0, 10)}. */  
            "source=" + DATASET.indexName + " | sort key | eventstats dc(str3) as dc_str3 by str0 | fields key, str0, dc_str3"
            row("key08", null, 17L, avg, 1, 11),  
    /** sql IT: testEventstatsVarianceWithNullBy. Variance partitioned by {@code str3} which has  
            row("key11", "TECHNOLOGY",      null, 10,   10.0, 5.0,  techNullBavg, 9L),  
}
     *  path. */
    }
            row("key14", "TECHNOLOGY",      11,   tSp,  tSs,        tVp,  tVs),
     *  TECHNOLOGY 9 rows (cnt=9, avg=7, min=4, max=11). */
     */
 *       null-bubbling-through-window-aggregate code path.</li>  
            row("key07", "OFFICE SUPPLIES", "e",  null, 8.0,  8.0),
            row("key02", null, 17L, avg, 1, 11),
            row("key06", "e",  8,    10L,  6.0,  1,    11),
     *    <li>(TECHNOLOGY, null) 22/3-5 ≈ 2.333 → passes (5 rows)</li>
                + " | eventstats avg(avg_int0) as avg_str0_int0 by str0"
     *  eventstats chain. Filter and re-aggregate. Calcs translation:  
            row("key12", 3L), row("key13", 3L), row("key14", 3L), row("key15", 3L),
        double eSp = 3.3166247903554, eSs = 3.63318042491699, eVp = 11.0, eVs = 13.2;
            row("key01", "FURNITURE",       null, 1L),  
            row("key08", "TECHNOLOGY",      null, null, null, null, techNullBavg, 9L),  
        List<Object> got = rows.get(0);  
        assertRowsEqual(response,  
    /** sql IT: testEventstatsDistinctCountWithNull. Same query as {@link #testEventstatsDistinctCount}  
 *
            row("key15", "TECHNOLOGY",      "e",  4,    4.0,  -1.0, 1.75,         9L),
        );  
            row("key14", "TECHNOLOGY",      11,   9L, 7.0, 4, 11),
    /** sql IT: testEventstatsVarianceBy. Per-str0 variance broadcast to every row.
            row("key10", 4,    17L, avg, 1, 11),
     *  {@code str3} has 7 nulls (int0 non-null=[7,3,10,4,8] → cnt=7, avg=6.4, min=3, max=10)
 *                                  expectThrows.
    }
        double techAvgOuter = 191.0 / 27.0;
    }
            row("key14", "TECHNOLOGY",      11,   9L, 7.0, 4, 11),  
        // (FURNITURE,null)=1, (FURNITURE,0)=1; (OS,null)=3, (OS,0)=3; (TECH,null)=2, (TECH,0)=5, (TECH,10)=2.  
     *  span buckets further by str0. */
            row("key07", "e",  null, 10L,  6.0,  1,    11),
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,  8.0),  
    @SuppressWarnings({"unchecked", "varargs"})
 *   <li>calcs has no rows with NULL str0 / NULL str3 (other than rows already nullable on str3).  
            row("key05", null, 3,    4L),
            row("key14", 18, 11,   8L, avg10, 4, 11),
        try {
            row("key06", "OFFICE SUPPLIES", 8,    6L, 6.0, 3, 8),
    public void testEventstats() throws IOException {
        Map<String, Object> response = executePpl(
     *  eventstats. With calcs (str3 has nulls — 7 of them — but str0 has no nulls):
 *   <li>{@code earliest} / {@code latest} window function is not in {@link  
     *  </ul>  
            row("key16", 1L)
        Map<String, Object> response = executePpl(
            row("key16", "TECHNOLOGY", 1L)
 *   span(age,10) → span(int0,10)  — but PPL `span()` UDF is not registered on the  
            row("key12", null, null, 2L),  
            row("key06", "OFFICE SUPPLIES", 8,    3L),
 *                     stddev_pop=2.77746029931765  stddev_samp=3
        assertRowsEqual(response,  
                + " avg(int0), min(int0), max(int0), stddev_pop(int0), stddev_samp(int0),"
     *  FURNITURE has only 1 non-null int0 (key00=1, key01=null) → var_samp/stddev_samp emit  
        assertRowCount(r2, 0);
    public void testEventstatsVarianceWithNull() throws IOException {
        );  
            row("key01", "e",  null, 4L),
            row("key00", 1L), row("key01", 1L), row("key02", 1L), row("key03", 1L),  
     *    <li>eventstats avg(int0) as a by str0, str3, key (key is unique → a == int0 for
            row("key05", "OFFICE SUPPLIES", 1L),  
        assertRowsEqual(response,  
        // bucket_nullable=false drops str3-null partition's inner avg → avg_int0=null on those rows.  
            row("key11", 10,   sp, ss, vp, vs),
            row("key04", 7,    9L, avg0, 1,    8),
 *       calcs cannot reproduce; we test the int0-NULL case instead, which exercises the same
                + " | eventstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs by str3"
            row("key05", "OFFICE SUPPLIES", null, 3,    null, 8.0),
        assertRowsEqual(response,
        Map<String, Object> response = executePpl(  
            row("key07", null, sp, ss, vp, vs),
            for (int j = 0; j < want.size(); j++) {
        // Jackson serializes (Double) null as the string "NaN" inside JSON arrays, so the  
            "source=" + DATASET.indexName + " | sort key | eventstats dc(str3) as dc_str3 | fields key, dc_str3"  
            "percentile_approx"
            row("key16", null, 8,    7L,  6.4, 3, 10)  
     *  aggregate semantics are identical. */  
     *  calcs has int0 nulls already, so window numerics ignore them by default. */
 *     stddev_pop=3.00962642859034 stddev_samp=3.15652282799228
        assertRowsEqual(response,  
        assertEquals("Expected exactly one row", 1, rows.size());
            row("key02", "e",  null, 10L, 6.0, 1, 11),
    /** sql IT: testMultipleEventstats. Chain two eventstats: per-(str3, str0) avg, then  
import java.util.List;
    //
        for (int i = 0; i < expected.length; i++) {  
            row("key07", "OFFICE SUPPLIES", null, osSp, osSs,       osVp, osVs),  
        );
     *  Pairs with {@link #testEventstatsBySpanWithNull} which reintroduces the null bucket
            row("key12", "TECHNOLOGY",      null, 2L),
    public void testMultipleEventstatsWithNull() throws IOException {
                + " | eventstats bucket_nullable=false avg(int0) as avg_int0 by str3, str0"
            row("key07", null, 17L, avg, 1, 11),
        assertRowsEqual(response,
        );
            row("key11", "TECHNOLOGY",      null, 10,   tNull, techAvgOuter),  
        assertRowsEqual(
            "source=" + DATASET.indexName + " | sort key"  
            row("key10", "e",  4,    5L),
    }
            row("key07", "OFFICE SUPPLIES", "e",  null, 8.0,         8.0),  
        // str3='e':  10 rows, int0 non-null=[1,8,8,4,11,4] → sp,ss,vp,vs
            row("key01", 13, null, 8L, avg10, 4, 11),
            row("key05", "OFFICE SUPPLIES", null, 3,    5.0,   osAvgOuter),  
            double e = ((Number) expected).doubleValue();
     *  ({@link org.opensearch.analytics.planner.rel.OpenSearchProject#computeSelfCost}) on
            row("key13", "TECHNOLOGY",      null, 4,    4.0,  -1.0, techNullBavg, 9L),
        }  
        // Same per-(str0) aggregates as testEventstatsBy on single-shard.  
            row("key09", 2,  8,    9L, avg0,  1, 10),  
            row("key07", null, 17L, avg, 1, 11),
            List<Object> want = expected[i];
            row("key12", 1L), row("key13", 1L), row("key14", 1L), row("key15", 1L),
            row("key10", 4,    17L, avg, 1, 11),
     *    <li>(TECHNOLOGY, 'e') int0=[8,4,11,4] → avg=6.75, applied to 4 rows → outer feed: {6.75,6.75,6.75,6.75}</li>  
    }  
    }
 * this file be licensed under the Apache-2.0 license or a
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by span(int3, 10)"
     *  7 nulls + 10 'e' rows — covers null-key partition handling. */
            "source=" + DATASET_MULTI.indexName + " | sort key"  
        Map<String, Object> response = executePpl(
            Response response = client().performRequest(request);
     *  the single global partition. */
 * The OpenSearch Contributors require contributions made to  
            row("key09", "TECHNOLOGY",      8,    5L),
     *  null-key partition: rows whose {@code by} key is null get NULL window output, while
            row("key06", "e",  8,    10L, 6.0, 1, 11),
            row("key03", "OFFICE SUPPLIES", 1L),
     *  the non-null partition aggregates as usual. Same {@code by str3} as  
     *    <li>(FURNITURE,'e') int0=[1] → avg=1</li>
    }  
    // ── Multi-shard correctness — exercises the SINGLETON-gather cost gate ────  
            row("key00", "FURNITURE",       1,    2L, 1.0, 1, 1),
            row("key14", 11,   sp, ss, vp, vs),
    /** Multi-shard variant of {@link #testEventstatsDistinctCount} — exercises the
    /** sql IT: testEventstatsBySpanWithNull. Bucketing key has nulls — uses {@code int0}
     *  every shard contributes a partial HLL sketch, the coordinator merges them into a
            row("key01", "e",  null, 4L),
     *    <li>(OFFICE SUPPLIES, 'e') int0=[8] → avg=8, applied to 4 rows → outer feed: {8,8,8,8}</li>
     *  broadcast to every row from the single global partition. Values pre-computed from
     *  fails loudly, signalling that the assertion should be upgraded to assert exact rows. */
        assertRowsEqual(response,
            row("key11", null, 10,   1L),  
            row("key02", "OFFICE SUPPLIES", null, 3L),
        );  
            row("key02", "OFFICE SUPPLIES", "e",  null, 8.0,  8.0),
            row("key12", 1L), row("key13", 1L), row("key14", 1L), row("key15", 1L),
            row("key15", "e",  4,    10L, 6.0, 1, 11),
     *  → NULL stddev. */
            row("key12", "TECHNOLOGY", 1L),
            row("key04", 9,  7,    9L, avg0,  1, 10),
        double vp = 9.05785123966942;  
            row("key10", "e",  4,    5L),
import java.util.Map;
    /** Multi-shard variant of {@link #testEventstatsDistinctCountByCountry} — partitioned  
            }
    public void testEventstatsVarianceBySpan() throws IOException {
            row("key11", 10,   sp, ss, vp, vs),
            row("key14", "TECHNOLOGY", 1L),
                + " | fields key, str3, int0, cnt"
            row("key06", 18, 8,    8L, avg10, 4, 11),  
        double techAvgOuter = 191.0 / 27.0;
        );
        );
        // Per-partition dc(str3): FURNITURE has 2 rows of "e" (dc=1); OFFICE SUPPLIES has 4 of  
        assertRowsEqual(response,
            row("key13", null, 4,    null, null, null, null),
            row("key02", 2,  null, 9L, avg0,  1, 10),
        // Outer eventstats on str0 then averages only the non-null avg_int0 within each str0:
            row("key16", 8,    9L, avg0, 1,    8)
            row("key15", "TECHNOLOGY",      4,    5L),
            "source=" + DATASET.indexName + " | sort key"
            "source=" + DATASET.indexName + " | where key = 'non-existed' | eventstats count(),"
            row("key04", 7,    sp, ss, vp, vs),
            row("key13", "TECHNOLOGY", 1L),
        // str3=null: 7 rows, int0 non-null=[7,3,10,4,8] → sp,ss,vp,vs  
            row("key04", "OFFICE SUPPLIES", 7,    ss),
        Map<String, Object> response = executePpl(  
     *  shards. Without the SINGLETON-gather cost gate that
    // cardinality) HLL is exact, so we can assert the exact dc count.
            row("key13", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
            response,  
            row("key16", "TECHNOLOGY",      null, 8,    techNullAvg, techNullAvg)  
    }
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx"
            }  
        //   FURNITURE (only str3='e'): avg=1.0
        assertRowsEqual(response,
        double osSp = 2.160246899469287, osSs = 2.6457513110645907, osVp = 4.666666666666667, osVs = 7.0;
            row("key00", 8,  1,    9L, avg0,  1, 10),  
            row("key11", 10,   17L, avg, 1, 11),  
    /** sql IT: testEventstatsVarianceBySpan. After filtering out TECHNOLOGY, 8 rows remain
            row("key12", null, null, null, null, null, null),
            row("key05", null, 3,    4L),  
            row("key00", 1,    17L, avg, 1, 11),
            row("key15", "e",  4,    eSp, eSs, eVp, eVs),
        );
            row("key14", "TECHNOLOGY",      "e",  11,   11.0, 6.0,  1.75,         9L),  
        );
     *    <li>(OFFICE SUPPLIES,'e') int0=[8] (3 nulls dropped) → avg=8</li>
        );
        Map<String, Object> response = executePpl(  
            "source=" + DATASET.indexName + " | sort key"  
    }
    }
     *  partial sums per shard for the same partition — and {@code stats max(...) by str0}
     *  averages doesn't equal the global average unless rows-per-shard are equal. */
            row("key13", "TECHNOLOGY", 1L),
            "percentile"  
            row("key11", null, 10,   1L),
        Map<String, Object> response = executePpl(
            row("key15", "TECHNOLOGY",      "e",  4,    6.75,        techNullAvg),
            row("key04", "OFFICE SUPPLIES", 1L),
                + " var_pop(int0), var_samp(int0)"
            row("key02", "OFFICE SUPPLIES", "e",  null, null, null, 3.0,          4L),
            row("key11", 10,   2L, 10.5, 10,   11),  
        // timestamp column, but the contract here is just "this PPL form is not yet supported".  
            row("key03", "OFFICE SUPPLIES", "e",  null, 8.0,  8.0),  
            row("key13", null, 4,    7L,  6.4, 3, 10),  
            row("key08", null, null, null, null, null, null),  
 * {@code expectThrows} negative tests pinning the precise error message — failing those is  
            row("key11", null, 10,   nSp, nSs, nVp, nVs),  
        double avg10 = 31.0 / 5;
            row("key02", "OFFICE SUPPLIES", null, 3L),
            row("key15", "TECHNOLOGY", 1L),  
        );  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
                + " | fields key, int0, sp, ss, vp, vs"
        Map<String, Object> response = executePpl(
            row("key11", 10,   17L, avg, 1, 11),
    public void testEventstatsDistinctCountByCountry() throws IOException {
     * Send a PPL query expecting an error response. Asserts the response body contains  
            row("key10", "e",  4,    eSp, eSs, eVp, eVs),
            row("key04", 7,    sp, ss, vp, vs),
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,         8.0),
            "source=" + DATASET.indexName + " | sort key"
            row("key08", "TECHNOLOGY",      null, null, techNullAvg, techNullAvg),
 *       n, NULL) → FLOOR(field/n)*n before substrait emission. The {@code bySpan} cases
            row("key13", 4,    sp, ss, vp, vs),
            row("key01", "FURNITURE",       null, null),
    private final void assertRowsEqual(Map<String, Object> response, List<Object>... expected) {
    }  
                body.contains(expectedSubstring)
     *  Each output row carries the same partition-constant (cnt, avg, mn, mx) broadcast from  
     *  as single-shard. */  
            row("key06", 8,    17L, avg, 1, 11),  
     *  per-str0 avg-of-avg.
    private static boolean dataProvisioned = false;
    }  
     *  {@link org.opensearch.analytics.planner.rel.OpenSearchProject#computeSelfCost} forces  
    }
            row("key14", "TECHNOLOGY", 1L),  
            row("key15", 4,    17L, avg, 1, 11),
            row("key08", "TECHNOLOGY",      null, null, tNull, techAvgOuter),  
            row("key10", 4,    9L, avg0, 1,    8),
                + " | fields key, int0, cnt, avg, mn, mx"
    public void testEventstatsBy() throws IOException {  
            row("key08", 1L), row("key09", 1L), row("key10", 1L), row("key11", 1L),
     *  <ul>
            row("key01", "e",  null, 10L, 6.0, 1, 11),  
            row("key09", "TECHNOLOGY",      8,    tSp,  tSs,        tVp,  tVs),
        // dc(str0) = 3 across all 17 rows (FURNITURE, OFFICE SUPPLIES, TECHNOLOGY).
            return;
     *    <li>TECHNOLOGY → 9</li>
 * </pre>
            row("key02", "e",  null, 4L),  
            row("key09", "e",  8,    5L),  
            "source=" + DATASET.indexName + " | where str0 != 'TECHNOLOGY' | sort key"
     *  {@link #testEventstatsByMultiplePartitions1}. */  
        //   TECHNOLOGY: max(6.75, 22/3 ≈ 7.333) = 22/3
        Map<String, Object> r2 = executePpl(  
        // bucket 0 (9 rows int0∈[1,8]): avg=47/9; bucket 10 (2 rows {10,11}): avg=10.5;  
            row("key08", "TECHNOLOGY",      null, null, null, 6.75),
        // bucket 10: 8 rows, int0 non-null=[8,4,4,11,4] → cnt=8, avg=31/5, min=4, max=11
                + " | fields key, str3, int0, sp, ss, vp, vs"  
            row("key02", "e",  null, eSp, eSs, eVp, eVs),  
 *   By str0:  
            row("key04", null, 7,    nSp, nSs, nVp, nVs),
            row("key09", "TECHNOLOGY", 1L),  
            row("key16", 1L)
    public void testUnsupportedWindowFunctions() throws IOException {
            "source=" + DATASET.indexName + " | sort key"
            row("key05", "OFFICE SUPPLIES", 3,    3L),
     *  rows form their own partition and aggregate normally over its non-null int0 values.
            row("key16", null, 8,    nSp, nSs, nVp, nVs)
            row("key00", 1,    17L, avg, 1, 11),  
    /** sql IT: testUnsupportedWindowFunctions. PERCENTILE/PERCENTILE_APPROX rejected by the
        Map<String, Object> response = executePpl(  
            row("key13", 4,    sp, ss, vp, vs),
        );
     *  broadcast to every row in that partition:  
            row("key06", 8,    sp, ss, vp, vs),  
     *    <li>eventstats avg(b) as bavg by str0, str3 — equivalent to per-(str0, str3)
        }
            row("key03", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
            row("key13", "TECHNOLOGY",      null, 4,    null, 6.75),
        //   OFFICE SUPPLIES: max(8.0, 5.0) = 8.0
            row("key10", "TECHNOLOGY",      "e",  4,    6.75,  techAvgOuter),
            row("key02", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),  
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,   osAvgOuter),
        ensureMultiShardProvisioned();  
        if (expected instanceof Double && Double.isNaN((Double) expected)
        );  
     *  NaN-aware: NaN matches NaN. */  
            row("key08", null, 6L, null, null, null),  
        double avg = 68.0 / 11.0;
            row("key01", "e",  null, eSp, eSs, eVp, eVs),
        Map<String, Object> response = executePpl(
            row("key05", 3,    sp, ss, vp, vs),
    // ── Variance / stddev ──────────────────────────────────────────────────────
        if (expected == null || actual == null) {
    /** Empty-partition window on a 3-shard index. Global SUM/AVG/MIN/MAX must equal the
            row("key09", "e",  8,    5L),
        // response body delivers "NaN" not (Double) null. Treat NaN expectation match-on-string.
            row("key12", "TECHNOLOGY",      null, null, techNullAvg, techNullAvg),
        assertEquals(message, expected, actual);
            row("key00", "e",  1,    eSp, eSs, eVp, eVs),
     *  </ul>
    // ── distinct_count / dc ────────────────────────────────────────────────────  
     *  is regressed, sum/min/max would still be correct (commutative + associative is  
        );  
                + " | where bavg > 0"
            row("key13", 18, 4,    8L, avg10, 4, 11),
            row("key03", "OFFICE SUPPLIES", null, null),
                + " | eventstats avg(int0) as avg_int0 by str3, str0"  
        assertEquals("Row count mismatch", expected, rows.size());
            response,
        }
    /**
    }
            row("key15", "TECHNOLOGY",      "e",  4,    6.75,  techAvgOuter),
        assertRowsEqual(response,  
     *  on RexOver-bearing projects, per-shard window evaluation would produce different
        );
            row("key09", "TECHNOLOGY",      8,    9L, 7.0, 4, 11),
     *    <li>FURNITURE  → avg over {1,1} = 1.0</li>  
                + " | fields key, int0, cnt, avg, mn, mx"
     *  </ol>  
    // ── Empty input ────────────────────────────────────────────────────────────  
 *       org.opensearch.analytics.spi.WindowFunction}; expectThrows.</li>
            row("key00", "FURNITURE",       "e",  1,    1.0,  1.0),  
import java.io.IOException;
        Map<String, Object> response = executePpl(  
        );  
            return;
        );
        );  
            row("key08", "TECHNOLOGY",      null, 2L),
 * <p>Mirrors {@code CalcitePPLEventstatsIT} from the {@code opensearch-project/sql} repository
            assertTrue(  
        // "e" + 2 nulls (dc=1); TECHNOLOGY has 4 of "e" + 5 nulls (dc=1).
    /** sql IT: testMultipleEventstatsWithNullBucket. {@code bucket_nullable=false} on chained  
package org.opensearch.analytics.qa;
        );
                + " | eventstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs by str0"
            row("key08", null, null, 2L),  
 * <pre>  
            row("key07", "OFFICE SUPPLIES", "e",  null, null, null, 3.0,          4L),
        //   FURNITURE: max(1.0) = 1.0  
            row("key03", "OFFICE SUPPLIES", null, 3L),
            Response response = client().performRequest(request);
        Request request = new Request("POST", "/_plugins/_ppl");
        );
            row("key15", "e",  4,    5L),
            row("key08", "TECHNOLOGY", 1L),  
        );  
            row("key09", "TECHNOLOGY",      8,    5L),
        assertRowsEqual(response,  
 *                     var_pop=4.66666666666667  var_samp=7  
            row("key16", "TECHNOLOGY",      null, 8,    null, 6.75)
            row("key12", "TECHNOLOGY",      null, 9L, 7.0, 4, 11),
        Map<String, Object> response = executePpl(  
        assertRowsEqual(response,
            row("key16", "TECHNOLOGY",      8,    5L)  
    public void testEventstatsByWithNull() throws IOException {
    }
            row("key11", "TECHNOLOGY",      null, 10,   techNullAvg, techNullAvg),
     *  int0={1,7,3,8,8,4,10,4,11,4,8}, mean=68/11. */  
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str3"
            row("key06", 8,    17L, avg, 1, 11),
    protected void onBeforeQuery() throws IOException {  
            row("key05", 7,  3,    9L, avg0,  1, 10),
    /** sql IT: testEventstatsEmptyRows. {@code where … = 'non-existed' | eventstats …} on an
        Map<String, Object> response = executePpl(  
        try {  
                + " | eventstats count() as cnt by span(int0, 10), str3"  
     *  bucket 0 (int3 ∈ [0,10), 9 rows) and bucket 10 (int3 ∈ [10,20), 8 rows).  
            row("key11", "TECHNOLOGY",      10,   2L),
                + " | eventstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs"
        );
    private void assertErrorAny(String ppl) throws IOException {  
    /** sql IT: testEventstatsByMultiplePartitions1. {@code by span(int0, 10), str0} — splits  
            row("key12", null, null, nSp, nSs, nVp, nVs),
        assertErrorContains(
        for (int j = 0; j < expected.length; j++) {
import java.util.Arrays;  
            row("key14", "TECHNOLOGY",      "e",  11,   6.75,  techAvgOuter),  
            row("key00", "FURNITURE",       "e",  1,    1.0,   1.0),
            row("key10", "e",  4,    10L, 6.0, 1, 11),  
     *  fully populated in calcs. {@code span(int3, 10)} produces two buckets:
    }
    }
                + " | eventstats avg(b) as bavg by str0, str3"  
            row("key07", "OFFICE SUPPLIES", 1L),
            row("key04", 3L), row("key05", 3L), row("key06", 3L), row("key07", 3L),
        );  
            row("key11", "TECHNOLOGY",      10,   9L, 7.0, 4, 11),  
    public void testEventstatsBy_3shard() throws IOException {
                + " | fields key, int0, sp, ss, vp, vs"
            row("key12", "TECHNOLOGY",      null, null, null, null, techNullBavg, 9L),
 * cases that depend on functionality not yet wired through the analytics-engine route are
        // The actual error is "Default @timestamp field not found" because calcs has no
        assertRowsEqual(response,
            double a = ((Number) actual).doubleValue();  
                + " | fields key, int3, int0, cnt, avg, mn, mx"
 *     count=17  count(int0)=11  sum=68  min=1  max=11  avg=68/11
    }
 *       recurse into RexOver.window.partitionKeys, so the SpanAdapter rewrites SPAN(field,
 *  
            "source=" + DATASET.indexName + " | where key = 'non-existed' | eventstats count(),"  
            row("key09", "e",  8,    10L, 6.0, 1, 11),
    /** sql IT: testEventstatsBySpan. Bucketing key has no nulls — uses {@code int3}, which is
                + " | eventstats max(a) as max_a by str0"
                + " | eventstats count(bavg) as c by str0"
            row("key07", "e",  null, 4L),
    }
            row("key10", "TECHNOLOGY", 1L),
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str0"  
 * </pre>  
                + " | fields key, str0, str3, int0, a, max_a"  
 * SPDX-License-Identifier: Apache-2.0
            row("key12", "TECHNOLOGY",      null, null, tNull, techAvgOuter),
     *  {@link #testEventstatsVariance} — null int0 rows are already excluded from numerics. */  
        assertRowsEqual(response,  
    private static final Dataset DATASET_MULTI = new Dataset("calcs", "calcs_multi_eventstats");  
    public void testEventstatsBySpanWithNull() throws IOException {  
            row("key09", "TECHNOLOGY", 1L),
            row("key15", "TECHNOLOGY", 1L),
    public void testEventstatsByMultiplePartitions1() throws IOException {
     *  </ul>  
     *  PPL frontend with {@code "Unexpected window function: <name>"} before reaching the  
            row("key10", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),  
            row("key05", "OFFICE SUPPLIES", 1L),
                body = e.getMessage();
        assertRowsEqual(response,
        Map<String, Object> response = executePpl(
        assertErrorContains(  
        double avg = 68.0 / 11.0;
            "source=" + DATASET_MULTI.indexName + " | sort key"
            );  
     *  may change as more analytics-engine functionality lands). The contract here is just  
            row("key14", "TECHNOLOGY",      "e",  11,   6.75,  techAvgOuter),  
            row("key04", "OFFICE SUPPLIES", 1L),
                + " | sort key | eventstats dc(str3) as dc_str3 by str0 | fields key, str0, dc_str3"
 *   name       → key       (keyword; unique 17 row-id values key00..key16)
            row("key12", null, null, 7L,  6.4, 3, 10),
     *  <p>Per-(str0, str3) avg-5: see {@link #testMultipleEventstats} table — adjusted by -5:
    // broadcasts the global aggregate to every row.
        // bucket 0: 9 rows, int0 non-null=[1,7,3,8,10,8] → cnt=9, avg=37/6, min=1, max=10
            // Any error response is acceptable.
    /** sql IT: testEventstatsVariance. Global stddev_pop / stddev_samp / var_pop / var_samp
        double sp = 3.009626428590336;
            row("key06", "OFFICE SUPPLIES", 1L),
import org.opensearch.client.ResponseException;  
     *    <li>(TECHNOLOGY,null) int0=[10,4,8] (2 nulls dropped) → avg=22/3 ≈ 7.333</li>
        if (dataProvisioned == false) {
        );  
 *   age        → int0      (integer; 11 non-null + 6 nulls)
     *  (int0 ∈ [0,10), 9 rows) and bucket 10 (int0 ∈ [10,20), 2 rows). The null bucket
 * <h2>Schema translation (sql IT → calcs)</h2>  
    }
 *                     var_pop=7.71428571428571  var_samp=9  
     *  frontend's default-{@code @timestamp}-field check (calcs has no @timestamp column).
            row("key10", "TECHNOLOGY", 1L),
    /** sql IT: testEventstatsVarianceWithNull. Same query and result as
        double tNull = 22.0 / 3.0;  
 */  
        );
            row("key06", "OFFICE SUPPLIES", 8,    osSp, osSs,       osVp, osVs),
            row("key01", null, sp, ss, vp, vs),
            row("key09", "TECHNOLOGY",      "e",  8,    6.75,  techAvgOuter),
        // Per-str0 avg(avg_int0): F=1.0, OS=7.0, T=191/27.
    }
            row("key00", 1,    sp, ss, vp, vs),  
    public void testChainedEventstats_3shard() throws IOException {  
            row("key06", "OFFICE SUPPLIES", 8,    ss),
            dataProvisioned = true;  
 *   country    → str0      (keyword; 3 distinct: FURNITURE, OFFICE SUPPLIES, TECHNOLOGY)  
            row("key05", null, 3,    7L,  6.4, 3, 10),
 *   state      → str3      (keyword; 2 distinct non-null + 7 nulls)
        );  
            row("key08", "TECHNOLOGY",      null, null, tNull, techAvgOuter),  
        );  
    // DataFusion's built-in approx_distinct (HyperLogLog). At calcs's scale (17 rows, low  
            row("key02", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),  
     *  contribute as missing to the outer avg's count. avg(avg_int0) by str0 ignores nulls:
        Map<String, Object> response = executePpl(
            row("key14", "TECHNOLOGY",      11,   2L),
        );  
            row("key15", "TECHNOLOGY",      "e",  4,    6.75,  techAvgOuter),
     *  dc with {@code by str0}. Per-partition HLL state is built per shard, merged at the
            row("key05", 3,    17L, avg, 1, 11),  
    }
            row("key05", 3,    17L, avg, 1, 11),
        Map<String, Object> response = executePpl(
            "source=" + DATASET.indexName + " | sort key"
    /** sql IT: testEventstatsDistinctCountFunction. {@code distinct_count()} alias for dc. */  
    // BackendPlanAdapter rewrites RexOver(DISTINCT_COUNT_APPROX) → APPROX_COUNT_DISTINCT,
        double osAvgOuter = 7.0;
     *  (6 nulls), so {@code span(int0, 10)} produces a null bucket alongside bucket 0  
            row("key07", "e",  null, eSp, eSs, eVp, eVs),
            row("key05", null, 3,    null, null, null, null),  
            row("key04", "OFFICE SUPPLIES", 7,    osSp, osSs,       osVp, osVs),  
        // Per-(str0, str3) avg(int0): see testMultipleEventstats. Per-str0 max of those:
        );
            row("key00", 1L), row("key01", 1L), row("key02", 1L), row("key03", 1L),
            "source=" + DATASET.indexName + " | sort key"
 *   Global int0: 17 rows, 11 non-null = {1,7,3,8,8,4,10,4,11,4,8}
     *        avg(int0)-5</li>  
    public void testEventstatsVarianceBy() throws IOException {
            row("key05", "OFFICE SUPPLIES", null, 3,    5.0,         8.0),
                + " | fields key, int0, cnt, avg, mn, mx"  
            row("key15", 4,    sp, ss, vp, vs),  
    // ── Basic eventstats (no by) ───────────────────────────────────────────────
            row("key10", "TECHNOLOGY",      "e",  4,    4.0,  -1.0, 1.75,         9L),
                || "NaN".equals(actual))) {
        );
            row("key12", "TECHNOLOGY",      null, 9L, 7.0, 4, 11),
            row("key03", "OFFICE SUPPLIES", "e",  null, 8.0,         8.0),
 * </ul>
            row("key16", 8,    sp, ss, vp, vs)
            row("key07", "OFFICE SUPPLIES", null, 3L),  
        Map<String, Object> response = executePpl(
            row("key05", 3,    9L, avg0, 1,    8),  
    }
        Map<String, Object> response = executePpl(
    // ── Multiple eventstats (chained) ──────────────────────────────────────────
    public void testEventstatsDistinctCount() throws IOException {
            row("key07", "e",  null, 4L),
            row("key16", "TECHNOLOGY", 1L)
/**
            row("key04", "OFFICE SUPPLIES", null, 7,    5.0,         8.0),  
    }  
    private static void assertScalarRow(Map<String, Object> response, Object... expected) {
        );
        );  
            row("key13", 4,    17L, avg, 1, 11),
            row("key04", null, 7,    4L),
                + " var_pop(int0), var_samp(int0) by str0"  
        Map<String, Object> response = executePpl(  
            row("key13", "TECHNOLOGY",      4,    5L),  
            row("key08", 3L), row("key09", 3L), row("key10", 3L), row("key11", 3L),  
            row("key03", null, sp, ss, vp, vs),  
     *  module only ships the {@code calcs} dataset (whose {@code str3} already has 7 nulls). The
            row("key00", "e",  1,    5L),  
     *        → sum = 4*6.75 + 5*(22/3) = 27 + 110/3 = (81+110)/3 = 191/3
     *    <li>(FURNITURE, 'e') int0=[1] → avg=1, applied to 2 rows → outer feed: {1,1}</li>
    public void testEventstatsVarianceWithNullBy() throws IOException {
            row("key16", null, 8,    4L)
            row("key04", null, 7,    4L),
            row("key14", "TECHNOLOGY",      11,   2L),
                + " | fields key, str0, str3, int0, avg_int0, avg_str0_int0"
    public void testEventstatsDistinctCountByCountry_3shard() throws IOException {
        Map<String, Object> response = executePpl(
 * <ul>
    // {FURNITURE, OFFICE SUPPLIES, TECHNOLOGY} on every row → dc(str0)=3. eventstats
     *  and 10 'e' rows (int0 non-null=[1,8,8,4,11,4] → cnt=10, avg=6.0, min=1, max=11). */  
    /** Send a PPL query and assert it fails with ANY error response. Used for cases where
        }  
            "source=" + DATASET.indexName + " | sort key"
     *  coordinator, then broadcast. Each {@code str0} group sees the same {@code dc(str3)=1}
            row("key13", 4,    9L, avg0, 1,    8),
        );
        Map<String, Object> r1 = executePpl(
        }
            row("key09", "e",  8,    10L,  6.0,  1,    11),
            assertEquals("Column count mismatch at row " + i, want.size(), got.size());  
            row("key01", "FURNITURE",       null, 1L),  
                + " | eventstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs"
            row("key16", "TECHNOLOGY",      8,    9L, 7.0, 4, 11)  
    private void ensureMultiShardProvisioned() throws IOException {
            row("key16", "TECHNOLOGY",      8,    5L)  
            row("key12", null, null, 2L),
                + " avg(int0), min(int0), max(int0), stddev_pop(int0), stddev_samp(int0),"
     *    <li>(TECHNOLOGY,'e') int0=[8,4,11,4] → avg=6.75</li>
            row("key10", 4,    sp, ss, vp, vs),
            row("key03", null, 17L, avg, 1, 11),
                + " | eventstats avg(int0) as avg_int0 by str3, str0"
    }  
    public void testEventstatsByMultiplePartitionsWithNull2() throws IOException {  
        double sp = 3.009626428590336;
            row("key01", "FURNITURE",       "e",  null, 1.0,  1.0),
        );  
            row("key14", 11,   17L, avg, 1, 11),  
            row("key16", null, 8,    4L)
            row("key11", "TECHNOLOGY", 1L),
        );
        ensureMultiShardProvisioned();
    public void testMultipleEventstats() throws IOException {  
            DatasetProvisioner.provision(client(), DATASET);
     *        → avg = (191/3)/9 = 191/27 ≈ 7.074074</li>  
 *     FURNITURE       (2 rows, int0=[1])              sum=1   avg=1   min=1   max=1
            "source=" + DATASET.indexName + " | sort key"
     *  str0 partition (FURNITURE×2, OFFICE SUPPLIES×6, TECHNOLOGY×9) necessarily spans
                + " | eventstats bucket_nullable=false count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str3"  
            row("key09", "TECHNOLOGY",      8,    9L, 7.0, 4, 11),
            return;
                + " | fields key, str0, int0, cnt, avg, mn, mx"
        ensureMultiShardProvisioned();
     *  bucket_nullable=false on the first eventstats drops rows where {@code str3 IS NULL}
            row("key10", "TECHNOLOGY",      4,    5L),  
    /** sql IT: testEventstatsByWithNull. Default {@code bucket_nullable=true} mode — null-key  
        );
            row("key09", "e",  8,    eSp, eSs, eVp, eVs),
    }
            row("key06", "OFFICE SUPPLIES", 8,    3L),
            row("key16", "TECHNOLOGY",      null, 8,    tNull, techAvgOuter)
            row("key13", null, 4,    nSp, nSs, nVp, nVs),
            row("key13", "TECHNOLOGY",      null, 4,    tNull, techAvgOuter),
    public void testEventstatsByMultiplePartitions2() throws IOException {  
            row("key08", "TECHNOLOGY",      null, tSp,  tSs,        tVp,  tVs),
            row("key04", null, 7,    null, null, null, null),
        //   OFFICE SUPPLIES (only str3='e' contributes): avg=8.0  
     *  the second eventstats also bucket_nullable=false: rows with avg_int0=null (the str3-null rows)  
            row("key00", 1,    sp, ss, vp, vs),  
        double vs = 9.963636363636363;
    /** Chained eventstats on a 3-shard index — every {@code eventstats} lowers through
     *  <ol>
                + " | fields key, str0, int0, cnt, avg, mn, mx"
            row("key01", "FURNITURE",       null, 2L, 1.0, 1, 1),  
     *    <li>OFFICE SUPPLIES → 4</li>  
        }
        }
            row("key11", "TECHNOLOGY",      null, 10,   tNull, techAvgOuter),  
            row("key09", 8,    sp, ss, vp, vs),  
        );  
            row("key08", "TECHNOLOGY",      null, 9L, 7.0, 4, 11),
            row("key12", null, sp, ss, vp, vs),  
            row("key01", "FURNITURE",       "e",  null, 1.0,   1.0),
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        );
        //   TECHNOLOGY (only str3='e' contributes): avg=6.75
            row("key04", 7,    17L, avg, 1, 11),
 *       The {@code WithNull} variants in sql IT add a row {@code (Kevin, null, null)} that
        if (expected instanceof Number && actual instanceof Number) {
                + " | fields key, str0, int0, ss"  
            row("key12", "TECHNOLOGY",      null, null, null, 6.75),  
     *  call; the lifted-window detection has to fire on every one. Two chained eventstats  
            row("key12", "TECHNOLOGY",      null, 2L),
            row("key08", null, sp, ss, vp, vs),
        double osAvgOuter = 7.0;
 * to the calcs schema (see field-translation table below). Reachable cases assert exact rows;
     */
     *  count(*)=17, count(int0)=11 — eventstats count() counts every row including int0 nulls.
        assertErrorAny(
            }
        double tNull = 22.0 / 3.0;  
        // bavg = avg(int0) by (str0, str3) - 5; filter `bavg > 0` keeps only str0/str3 buckets
            row("key00", 3L), row("key01", 3L), row("key02", 3L), row("key03", 3L),
            row("key03", null, 6L, null, null, null),
     *    <li>OFFICE SUPPLIES rows={(O,e)×4 carrying 8} ∪ {(O,null)×2 carrying 5}
     *  After filter:  FURNITURE = 0 rows, OFFICE SUPPLIES = 4 rows, TECHNOLOGY = 9 rows.  
        assertNotNull("Response missing 'rows'", actualRows);
     *  </ul>
        );  
            row("key00", "FURNITURE", 1L),  
     *    <li>(OFFICE SUPPLIES, 'e') 8-5 = 3 → passes (4 rows)</li>
     *    <li>TECHNOLOGY rows={(T,e)×4 carrying 6.75} ∪ {(T,null)×5 carrying 22/3}  
            row("key07", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
                + " | fields key, str3, int0, cnt"
            row("key16", "TECHNOLOGY",      null, 8,    tNull, techAvgOuter)
     *  analytics-engine planner. */
            row("key03", "OFFICE SUPPLIES", 1L),  
            row("key11", "TECHNOLOGY",      10,   2L),
        assertRowsEqual(response,
     *    <li>(OFFICE SUPPLIES,null) int0=[7,3] → avg=5</li>  
            row("key07", null, sp, ss, vp, vs),
 *       collapse via {@code | stats max(...) by int0} and assert exact per-bucket rows.</li>  
            row("key10", "TECHNOLOGY",      "e",  4,    6.75, 6.75),
            row("key12", 11, null, 8L, avg10, 4, 11),  
        assertRowsEqual(response,
     *    <li>OFFICE SUPPLIES → avg over {8,8,8,8} = 8.0</li>
            row("key15", "e",  4,    10L,  6.0,  1,    11),
            row("key12", "TECHNOLOGY",      null, null, tNull, techAvgOuter),
            row("key05", "OFFICE SUPPLIES", 3,    6L, 6.0, 3, 8),  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
    }  
     *        → 9 rows × {6.75×4, 22/3×5}
     *  document ids, so partitions necessarily span shards — without the gather edge,
     *  "this PPL form is not yet supported" — if the query unexpectedly succeeds the test
    @SuppressWarnings("unchecked")
                + " | fields key, str3, int0, cnt, avg, mn, mx"
    public void testEventstatsBySpan() throws IOException {
                + " | eventstats avg(avg_int0) as avg_str0_int0 by str0"  
        assertRowsEqual(response,  
            row("key15", 4,    9L, avg0, 1,    8),
            row("key02", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
                + " | eventstats avg(int0) as a by str0, str3"
     *  would surface those wrong values. Identical expectations to  
            row("key11", "TECHNOLOGY",      null, 10,   null, 6.75),
 *                     stddev_pop=2.16024689946929  stddev_samp=2.64575131106459
 *       expectThrows on the missing index AND the missing earliest/latest window function.</li>
 * <h2>Limitations vs sql IT</h2>
    @SafeVarargs  
            row("key00", "FURNITURE", 1L),
        assertRowsEqual(response,
    /** sql IT: testEventstatsDistinctCount. */
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx"
            row("key07", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),  
            row("key05", "OFFICE SUPPLIES", null, 3,    5.0,   osAvgOuter),  
            row("key16", 3L)
            row("key16", 8,    17L, avg, 1, 11)
        );  
            "source=" + DATASET.indexName + " | eventstats earliest(str0), latest(str0) by str3"
import org.opensearch.client.Response;
     *  producing a 2-layer Project bundle per stage. Each bundle is rewired through
            row("key10", "e",  4,    10L,  6.0,  1,    11),
    public void testEventstatsDistinctCountFunction() throws IOException {
            row("key06", "e",  8,    eSp, eSs, eVp, eVs),
        assertRowCount(r1, 0);
            row("key03", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
            "source=" + DATASET.indexName + " | sort key"
 *     OFFICE SUPPLIES (6 rows, int0=[7,3,8])          sum=18  avg=6   min=3   max=8
        } catch (ResponseException expected) {
        );
            row("key12", "TECHNOLOGY",      null, tSp,  tSs,        tVp,  tVs),
            row("key10", "TECHNOLOGY",      "e",  4,    6.75,  techAvgOuter),
        );
            row("key15", 4,    sp, ss, vp, vs),  
 */  
            row("key09", 8,    9L, avg0, 1,    8),
            row("key03", "e",  null, eSp, eSs, eVp, eVs),
        // Per-(str0, str3) avg(int0): F/'e'=1, OS/'e'=8, OS/null=5, T/'e'=6.75, T/null=22/3.
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
            row("key16", "TECHNOLOGY",      null, 8,    8.0,  3.0,  techNullBavg, 9L)
            row("key01", "FURNITURE",       "e",  null, 1.0,         1.0),  
        assertRowsEqual(response,  
            row("key00", "e",  1,    10L,  6.0,  1,    11),
            row("key10", 4,    sp, ss, vp, vs),
                "Query [" + ppl + "] expected error containing [" + expectedSubstring + "] but body was: " + body,
        if (multiProvisioned == false) {
        );
    }
        double ss = 3.1565228279922772;
        );
     *    <li>(FURNITURE, 'e') 1-5 = -4 → fails {@code > 0}</li>  
    /** Multi-shard alias for tests that exercise the SINGLETON-gather cost gate
                + " | eventstats bucket_nullable=false avg(avg_int0) as avg_str0_int0 by str0"  
            row("key02", null, sp, ss, vp, vs),
        double avg0 = 37.0 / 6;  
     *  {@link #testEventstatsByMultiplePartitions2}. */
            row("key02", null, 6L, null, null, null),  
        Map<String, Object> response = executePpl(
    // ── Unsupported window functions ───────────────────────────────────────────  
            "source=" + DATASET.indexName + " | eventstats percentile_approx(int0)",
                + " | fields key, str0, int0, cnt"  
    }
     *  same numbers as the single-shard {@link #testEventstats}. If the SINGLETON gather
            row("key10", 11, 4,    8L, avg10, 4, 11),
 *     TECHNOLOGY      (9 rows, int0=[8,4,10,4,11,4,8]) sum=49  avg=7   min=4   max=11
     *  The 7 str3-null rows have inner avg=null (bucket_nullable=false drops the inner partition);
            row("key13", "TECHNOLOGY",      null, 4,    techNullAvg, techNullAvg),  
            row("key11", "TECHNOLOGY", 1L),  
    }
            "source=" + DATASET.indexName + " | sort key"
            row("key10", "TECHNOLOGY",      4,    tSp,  tSs,        tVp,  tVs),  
        assertRowsEqual(
            row("key03", "e",  null, 4L),  
            row("key11", "TECHNOLOGY",      10,   tSp,  tSs,        tVp,  tVs),
            row("key03", null, sp, ss, vp, vs),  
 *                                  analytics-engine route until #21621 lands; bySpan tests
            row("key02", "e",  null, 10L,  6.0,  1,    11),  
     *  the (cnt=7, avg=6.4, min=3, max=10) the default mode would broadcast. */
    // and the DataFusion plugin's approx_count_distinct wrapper UDAF aliases that name to
            String body;  
            row("key08", null, null, 7L,  6.4, 3, 10),
     * through the analytics-engine route — the throw is the contract.
        double nSp = 2.576819745345025, nSs = 2.880972058177586, nVp = 6.639999999999998, nVs = 8.299999999999997;
            assertCellEquals("Cell mismatch at col " + j, expected[j], got.get(j));  
 * <pre>
    // ── eventstats … by ────────────────────────────────────────────────────────  
    }  
            row("key08", 1L), row("key09", 1L), row("key10", 1L), row("key11", 1L),  
    }
        assertRowsEqual(response,
            row("key06", 8,    9L, avg0, 1,    8),
     *  {@link #testEventstatsByWithNull} — null-key rows now show NULL aggregates instead of
            row("key04", 1L), row("key05", 1L), row("key06", 1L), row("key07", 1L),  
        assertRowsEqual(response,
     *  NaN (DataFusion's behavior under Bessel's correction with n=1). */
            row("key04", "OFFICE SUPPLIES", null, 7,    5.0,   osAvgOuter),
            row("key13", null, 4,    4L),
            Map<String, Object> body = entityAsMap(response);  
    }
    }  
            row("key07", null, 6L, null, null, null),
            row("key05", "OFFICE SUPPLIES", 3,    osSp, osSs,       osVp, osVs),
            row("key07", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
            "source=" + DATASET.indexName + " | sort key | eventstats distinct_count(str0) as dc_str0 | fields key, dc_str0"  
        Map<String, Object> response = executePpl(
    private static List<Object> row(Object... values) {
        // (null,0)=4, (null,null)=2, (null,10)=1.
            row("key05", "OFFICE SUPPLIES", 3,    3L),
            row("key08", 17, null, 8L, avg10, 4, 11),
     *  index. Calcs's 17 rows distribute across 3 shards via UUID-hashed doc ids, so each  
            row("key01", "FURNITURE", 1L),
            row("key09", "TECHNOLOGY",      "e",  8,    6.75,  techAvgOuter),
    private static void assertCellEquals(String message, Object expected, Object actual) {
     *  the precise error message depends on which lowering path the PPL parser picks (which
    /** sql IT: testEventstats. eventstats count(), avg, min, max — global window over all rows.
        );
            row("key02", "OFFICE SUPPLIES", null, null),  
     *  <p>Per-(str0, str3) avg(int0) — only non-null int0 contributes:
                assertCellEquals("Cell mismatch at row " + i + ", col " + j, want.get(j), got.get(j));
            row("key02", null, 17L, avg, 1, 11),  
     *    <li>eventstats count(bavg) as c by str0 — count surviving rows per str0</li>
            row("key10", "TECHNOLOGY",      "e",  4,    6.75,        techNullAvg),  
            row("key04", "OFFICE SUPPLIES", 7,    3L),  
    // ── earliest / latest — not wired through analytics-engine yet ────────────
        double techNullBavg = 22.0 / 3.0 - 5;  // 7.333... - 5 = 2.333...  
    /** sql IT: testMultipleEventstatsWithNull. Same query as {@link #testMultipleEventstats} —  
        double ss = 3.304037933599835;
            row("key03", 5,  null, 9L, avg0,  1, 10),  
public class EventstatsCommandIT extends AnalyticsRestTestCase {
        Map<String, Object> response = executePpl(  
     * {@code expectedSubstring}. Used for cases that exercise functionality not yet wired
        );
     *  {@link org.opensearch.analytics.planner.rel.OpenSearchProject#liftNestedRexOver},  
            row("key15", "e",  4,    5L),  
                + " | eventstats count() as cnt by span(int0, 10), str0"
            "source=" + DATASET.indexName + " | sort key | eventstats dc(str3) as dc_str3 | fields key, dc_str3"
            fail("Expected query [" + ppl + "] to fail but got: " + body);  
     *    <li>FURNITURE  rows={(F,e)×2}                                  → avg(avg)=1</li>  
                + " | fields key, str3, int0, cnt, avg, mn, mx"
        );
        // (str3, span(int0,10)) buckets: (e,0)=5, (e,null)=4, (e,10)=1;  
                + " | fields key, str0, str3, int0, a, b, bavg, c"  
 * Self-contained integration test for PPL {@code eventstats} on the analytics-engine route.
    /** sql IT: testEventstatsByMultiplePartitionsWithNull2. Same query as
     *  exact rows as single-shard are expected because HLL is exact at calcs's scale. */  
            row("key06", "OFFICE SUPPLIES", 8,    6L, 6.0, 3, 8),
            "source=" + DATASET.indexName + " | sort key"
        Map<String, Object> response = executePpl(
            fail("Expected query [" + ppl + "] to fail with [" + expectedSubstring + "] but got: " + body);
     *  PARTIAL/FINAL split + SINGLETON-gather path for distinct-count. dc is set-based:  
    @Override
     *  <ul>  
        // count(bavg) grouped by str0: OS=4 (the 4 'e' rows in OS), T=9 (all 9 T rows).
        // FURNITURE entirely filtered out.
            row("key07", "OFFICE SUPPLIES", null, null)
            row("key08", 1L), row("key09", 1L), row("key10", 1L), row("key11", 1L),
            row("key15", 11, 4,    8L, avg10, 4, 11),  
     *    <li>eval b = a - 5 → per-row int0-5 (or null)</li>
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
     *    <li>(TECHNOLOGY, 'e') 6.75-5 = 1.75 → passes (4 rows)</li>  
            multiProvisioned = true;
    }
            row("key03", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
            row("key03", null, 17L, avg, 1, 11),  
            row("key12", 1L), row("key13", 1L), row("key14", 1L), row("key15", 1L),  
    // calcs.str3 is "e" on every non-null row → dc(str3)=1. calcs.str0 has three values  
            row("key04", 7,    17L, avg, 1, 11),
            row("key16", 8,    sp, ss, vp, vs)
                + " | fields key, str0, int0, cnt"
     *        → 6 rows × {8,8,8,8,5,5} → avg=42/6=7.0</li>
            DatasetProvisioner.provision(client(), DATASET_MULTI, 3);  
        double vp = 9.05785123966942;  
     *  count() per str0 (non-null bavg only):
            row("key00", "FURNITURE",       1,    ss),
            row("key15", "TECHNOLOGY",      "e",  4,    6.75, 6.75),  
            row("key10", "TECHNOLOGY",      4,    5L),  
     *  FURNITURE 2 rows (cnt=2, avg=1, min/max=1); OFFICE SUPPLIES 6 rows (cnt=6, avg=6, min=3, max=8);
 *  
    public void testMultipleEventstatsWithNullBucket() throws IOException {
            row("key08", "TECHNOLOGY", 1L),
     *  carries 6 null-key rows whose int0 is null → all aggregates are NULL. */
                + " | eventstats avg(int0) as a by str0, str3, key"
 *
        );
 *
            row("key15", 4,    17L, avg, 1, 11),  
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,  3.0,  3.0,          4L),
        Map<String, Object> response = executePpl(  
            row("key16", "TECHNOLOGY",      8,    9L, 7.0, 4, 11)
        );  
            row("key09", 8,    17L, avg, 1, 11),  
    public void testEventstatsDistinctCountWithNull() throws IOException {
        Map<String, Object> response = executePpl(
    }
            row("key05", 3,    sp, ss, vp, vs),
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
    public void testEventstatsByWithNullBucket() throws IOException {  
            row("key13", 4,    17L, avg, 1, 11),
            row("key16", 1L)  
                + " | eval b = a - 5"
        Map<String, Object> response = executePpl(  
            row("key04", "OFFICE SUPPLIES", null, 7,    5.0,   osAvgOuter),
     *  <p>After bucket_nullable=false, only str3='e' rows feed the inner avg:
                + " | fields key, str0, str3, int0, avg_int0, avg_str0_int0"
    private static void assertRowCount(Map<String, Object> response, int expected) {
     *  <ul>
        assertRowsEqual(response,
     */  
            row("key07", "e",  null, 10L, 6.0, 1, 11),  
        );
            row("key11", 2,  10,   9L, avg0,  1, 10),
            row("key16", null, 8,    null, null, null, null)
            row("key02", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),  
            row("key13", "TECHNOLOGY",      4,    5L),  
            row("key03", "e",  null, 10L, 6.0, 1, 11),
        assertRowsEqual(response,
            row("key13", "TECHNOLOGY",      null, 4,    tNull, techAvgOuter),
    public void testEventstatsEarliestAndLatest() throws IOException {
     *    <li>where bavg > 0 — filters partitions whose avg(int0) is &gt; 5</li>
 *       org.opensearch.analytics.spi.WindowFunction}; expectThrows.</li>
    /** sql IT: testMultipleEventstatsWithEval. eventstats → eval → eventstats → where →
            row("key01", null, 17L, avg, 1, 11),
            row("key13", "TECHNOLOGY",      4,    tSp,  tSs,        tVp,  tVs),  
     *  {@code DataFusionFragmentConvertor.replaceInput} as a separate {@code attachFragmentOnTop}
     *  Either way, the path is not reachable on analytics-engine today — assert the failure. */  
     *  (FURNITURE×2 + OFFICE SUPPLIES×6). All non-null int0 values are in span bucket 0
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
            "source=" + DATASET.indexName + " | sort key"
            Map<String, Object> body = entityAsMap(response);
            row("key03", "e",  null, 4L),
     *  per-str0 average of those.
        );
    /** Same eventstats {@code by str0} query as {@link #testEventstatsBy} but on a 3-shard
            row("key16", "TECHNOLOGY",      8,    tSp,  tSs,        tVp,  tVs)  
            row("key09", 8,    17L, avg, 1, 11),
            row("key03", "OFFICE SUPPLIES", "e",  null, 8.0,   osAvgOuter),
            row("key00", "e",  1,    5L),
            assertEquals(message, expected, actual);  
            row("key15", "TECHNOLOGY",      4,    tSp,  tSs,        tVp,  tVs),
    }
            row("key16", 0,  8,    9L, avg0,  1, 10)
            row("key12", null, 6L, null, null, null),
        );  
     *  <ul>
        double techNullAvg = 22.0 / 3.0;  
            row("key08", "TECHNOLOGY",      null, 2L),
            row("key08", null, sp, ss, vp, vs),
            row("key07", "OFFICE SUPPLIES", 1L),
            row("key14", "TECHNOLOGY",      "e",  11,   6.75, 6.75),
     *  partitioned windows. The 17 calcs rows distribute across 3 shards via UUID-hashed  
 * compatible open source license.
            List<Object> got = actualRows.get(i);
            row("key15", "TECHNOLOGY",      4,    5L),
            "source=" + DATASET_MULTI.indexName
 *   <li>{@code span()} as a PARTITION BY key works after BackendPlanAdapter is taught to  
            row("key16", 8,    17L, avg, 1, 11)
            row("key00", "FURNITURE",       "e",  1,    1.0,   1.0),
 * <h2>Calcs distribution facts (computed from bulk.json)</h2>
                + " | eventstats count() as cnt by span(int0, 10), str0"
            row("key02", "OFFICE SUPPLIES", "e",  null, 8.0,         8.0),
        ensureMultiShardProvisioned();
import org.opensearch.client.Request;
            row("key00", 1,    9L, avg0, 1,    8),
     *  <ul>
        double vs = 9.963636363636363;
            row("key01", null, 6L, null, null, null),
            row("key07", 3,  null, 9L, avg0,  1, 10),
    @SuppressWarnings("unchecked")
    }  
        );
        );  
            row("key06", 8,    sp, ss, vp, vs),  
     *    <li>(OFFICE SUPPLIES, null) 5-5 = 0 → fails (0 not > 0)</li>
    // ── Helpers ────────────────────────────────────────────────────────────────  
            row("key14", 11,   2L, 10.5, 10,   11),  
            row("key00", "FURNITURE",       1,    1L),
                + " | fields key, str0, int0, sp, ss, vp, vs"  
            row("key04", "OFFICE SUPPLIES", 7,    3L),  
            row("key01", "FURNITURE", 1L),
            row("key11", null, 10,   7L,  6.4, 3, 10),
            row("key15", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
    public void testEventstatsVariance() throws IOException {
        );
            row("key11", "TECHNOLOGY",      10,   9L, 7.0, 4, 11),
    /** sql IT: testEventstatsEarliestAndLatest. {@code earliest/latest} on calcs trip the PPL
            row("key14", "e",  11,   1L),  
            row("key08", null, 17L, avg, 1, 11),
            row("key09", 8,    sp, ss, vp, vs),  
            row("key14", "e",  11,   10L, 6.0, 1, 11),
            row("key00", "e",  1,    10L, 6.0, 1, 11),
            row("key05", "OFFICE SUPPLIES", 3,    ss),  
     *  span buckets further by str3 (which has 7 nulls + 10 'e's). */
            "source=" + DATASET.indexName + " | sort key"  
            row("key14", 11,   17L, avg, 1, 11),
 * source IT, with the query string translated from {@code state_country}/{@code logs} schema  
            try {
            row("key08", "TECHNOLOGY",      null, 9L, 7.0, 4, 11),  
    /** sql IT: testEventstatsByMultiplePartitions2. {@code by span(int0, 10), str3} — splits
        assertEquals("Row count mismatch", expected.length, actualRows.size());
        Map<String, Object> response = executePpl(
    public void testEventstats_3shard() throws IOException {  
            row("key02", null, sp, ss, vp, vs),
        double tSp  = 2.7774602993176543, tSs = 3.0, tVp = 7.714285714285714, tVs = 9.0;  
        assertNotNull("Response missing 'rows'", rows);
            row("key05", null, 3,    nSp, nSs, nVp, nVs),  
        ensureMultiShardProvisioned();
            row("key14", "TECHNOLOGY",      "e",  11,   6.75,        techNullAvg),
            row("key07", "OFFICE SUPPLIES", null, 3L),  
            row("key13", null, 4,    4L),
        assertRowsEqual(response,  
    /** sql IT: testEventstatsDistinctCountByCountry. */
            row("key01", null, sp, ss, vp, vs),
    }  
            row("key04", "OFFICE SUPPLIES", null, 7,    null, 8.0),
            row("key06", "OFFICE SUPPLIES", "e",  8,    8.0,   osAvgOuter),
            row("key01", null, 17L, avg, 1, 11),
            "source=" + DATASET_MULTI.indexName + " | sort key | eventstats dc(str3) as dc_str3 | fields key, dc_str3"
            row("key02", "OFFICE SUPPLIES", 1L),
     *  from the per-(str0, str3) avg; second eventstats then sees fewer rows feeding the  
            row("key06", "OFFICE SUPPLIES", 1L),  
            // Tolerance for floating-point reduction differences across reduction orders.
    public void testMultipleEventstatsWithEval() throws IOException {
        double avg0 = 47.0 / 9;
            row("key06", "e",  8,    5L),  
            row("key03", "OFFICE SUPPLIES", "e",  null, null, null, 3.0,          4L),  
     *  ({1,7,3,8}): stddev_samp({1,7,3,8}) ≈ 3.304. The 4 null-int0 rows form the null-bucket  
            "source=" + DATASET.indexName + " | eventstats percentile(int0)",
        // whose avg(int0)>5: (OS,'e')=8, (T,'e')=6.75, (T,null)=22/3. Each row carries the  
            row("key04", "OFFICE SUPPLIES", 7,    6L, 6.0, 3, 8),
     *  partial-final safe even without gather) but avg would NOT — avg of partial-shard
            row("key06", "e",  8,    5L),
 *
            row("key00", "FURNITURE",       1,    1L),
 *   <li>{@code dc} / {@code distinct_count} window function is not in {@link
            row("key10", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
        );
            row("key03", "e",  null, 10L,  6.0,  1,    11),
                + " | fields key, str0, str3, int0, avg_int0, avg_str0_int0"
        assertNotNull("Response missing 'rows'", rows);
            "source=" + DATASET.indexName + " | sort key"  
    public void testEventstatsEmptyRows() throws IOException {
            "source=" + DATASET.indexName + " | sort key"
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {
            } catch (Exception ioe) {  
            row("key09", "TECHNOLOGY",      "e",  8,    6.75,        techNullAvg),
     *  Per-str0 avg(avg_int0) (avg of the per-(str3,str0) avg values weighted by row count):
        double ss = 3.1565228279922772;
            row("key12", null, 17L, avg, 1, 11),  
        return Arrays.asList(values);  
            row("key03", "OFFICE SUPPLIES", null, 3L),
        // Every row sees the same global dc(str3) = 1 (only "e" appears as a non-null value).  
     *  </ul>
        // null bucket (6 rows int0=null): all aggregates NULL.
            row("key11", null, 10,   null, null, null, null),  
            row("key03", "OFFICE SUPPLIES", null, osSp, osSs,       osVp, osVs),
     *  {@link #testEventstatsBy} prove the gather is happening. */
        );
            row("key02", "OFFICE SUPPLIES", null, osSp, osSs,       osVp, osVs),
            row("key12", "TECHNOLOGY", 1L),  
        );
        assertRowsEqual(response,  
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably).
    /** sql IT: testEventstatsByWithNullBucket. {@code bucket_nullable=false} skips the
            row("key04", "OFFICE SUPPLIES", 7,    6L, 6.0, 3, 8),  
            row("key08", null, null, nSp, nSs, nVp, nVs),  
/*  
            row("key04", 1L), row("key05", 1L), row("key06", 1L), row("key07", 1L),
            row("key00", "FURNITURE",       1,    2L, 1.0, 1, 1),
            row("key14", "e",  11,   eSp, eSs, eVp, eVs),  
            row("key09", "TECHNOLOGY",      "e",  8,    6.75, 6.75),  
            row("key13", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),  
            "source=" + DATASET.indexName + " | sort key"  
            row("key00", 1L), row("key01", 1L), row("key02", 1L), row("key03", 1L),
     *        non-null rows, null for null rows) — degenerate per-row result</li>  
        assertEquals("Expected " + expected.length + " columns", expected.length, got.size());
 * one-to-one — every {@code @Test} method here corresponds to a method of the same name in the
     */  
            row("key04", 1L), row("key05", 1L), row("key06", 1L), row("key07", 1L),
 *   <li>{@code logs} index is not provisioned in this QA module; {@code testEventstatsEarliestAndLatest}
        );
        }  
            row("key14", "e",  11,   10L,  6.0,  1,    11),  
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");  
     *  per-shard window evaluation would silently produce wrong values. */
            row("key09", "TECHNOLOGY",      "e",  8,    8.0,  3.0,  1.75,         9L),
            row("key00", "FURNITURE",       "e",  1,    1.0,         1.0),
            row("key02", "OFFICE SUPPLIES", 1L),  
    }
        Request request = new Request("POST", "/_plugins/_ppl");
    /** sql IT: testEventstatsByMultiplePartitionsWithNull1. Same query as
            row("key04", null, 7,    7L,  6.4, 3, 10),  
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by span(int0, 10)"  
        );  
            row("key00", "FURNITURE",       1,    0.0,  (Double) null, 0.0,  (Double) null),
            row("key07", "OFFICE SUPPLIES", null, 6L, 6.0, 3, 8),
            row("key05", "OFFICE SUPPLIES", 3,    6L, 6.0, 3, 8),
     *  <ul>  
     *  prove the rewire stays correct across multiple bundles on the multi-shard exchange
    public void testEventstatsByMultiplePartitionsWithNull1() throws IOException {
            row("key01", "FURNITURE",       "e",  null, 1.0,   1.0),
     *  empty stream emits 0 rows for both forms. */  
     *  </ul>
            "source=" + DATASET.indexName + " | sort key"  
            row("key01", "FURNITURE",       null, 2L, 1.0, 1, 1),
            row("key02", "e",  null, 4L),
        }
    public void testEventstatsDistinctCount_3shard() throws IOException {
    /** sql IT: testEventstatsBy. eventstats partitioned by str0. Per-partition int0 aggregates
     *  single global sketch, then broadcasts {@code dc(str3)=1} to every row. The same
            && (actual instanceof Double && Double.isNaN((Double) actual)  
            if (Math.abs(e - a) > 1e-9 * Math.max(Math.abs(e), 1.0)) {
                + " | eventstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str0"  
            row("key01", "e",  null, 10L,  6.0,  1,    11),
            row("key12", null, 17L, avg, 1, 11),
            "source=" + DATASET_MULTI.indexName + " | sort key"  
     *  — sql-plugin's variant uses STATE_COUNTRY_WITH_NULL to exercise null handling, but this QA
        // (str0, span(int0,10)) buckets — cnt is the bucket size:
        );  
            row("key15", "TECHNOLOGY",      4,    9L, 7.0, 4, 11),
            row("key14", "e",  11,   1L),
            row("key08", null, null, 2L),
     *  Per-bucket int0 aggregates ignore int0 nulls.
                + " | eventstats count() as cnt by span(int0, 10), str3"  
            row("key14", 11,   sp, ss, vp, vs),
            row("key12", null, sp, ss, vp, vs),  
    private static boolean multiProvisioned = false;  
 *     var_pop=9.05785123966942   var_samp=9.96363636363636  
            row("key01", "FURNITURE",       null, 0.0,  (Double) null, 0.0,  (Double) null),  
 * how a future PR observes that they should be promoted to passing assertions.
                + " | eventstats stddev_samp(int0) as ss by span(int0, 10)"
