        assertRowsEqual(response,
            row("key15", "TECHNOLOGY",      4,    2.967415635794142,   3.250640962435972,  8.805555555555552,  10.566666666666663),
            row("key05", 3,    2.494438257849294,   3.055050463303893,  6.222222222222221,  9.333333333333332),
            row("key08", null, 9L,  5.0),
            row("key12", null, 13L, 5.857142857142857,   1, 10),
                + " | fields key, int0, avg3"
        );
            row("key03", null, 4L,  1.0,                 1, 1),
        if (expected instanceof Double && Double.isNaN((Double) expected)
            row("key03", "OFFICE SUPPLIES", null, 2L),
    public void testStreamstatsDistinctCount() throws IOException {
            row("key08", null, 9L,  8.0),
        row("key06", "OFFICE SUPPLIES", 8,    5.5),
            row("key07", "OFFICE SUPPLIES", null, 3L),
            row("key06", "OFFICE SUPPLIES", 8,    5L, 6.0,                 3,    8),
            row("key13", 4,    2.8695600708122493,  3.0676887530703447, 8.234375,           9.410714285714286),
            row("key09", "TECHNOLOGY", 3L),
            row("key10", "e",  4,    8L,  5.25,               1,    8),
            row("key06", 8,    3.6666666666666665),
            Response response = client().performRequest(request);
                + " | fields key, str0, int0, avg"
        );
            "source=" + DATASET.indexName + " | sort key"
                + " | streamstats avg(cnt) as avg_cnt"
 *   <li><b>{@code streamstats … by <field>}</b> — adds a helper {@code __row_number_for_streamstats__}
            row("key02", null, 3L,  1.0,                 1, 1),
    }
        );
        Request request = new Request("POST", "/_plugins/_ppl");
        row("key16", "TECHNOLOGY",      8,    6.0)
            row("key10", 4,    11L, 17L),
     *  same pattern. */
            row("key04", 7,    5L,  3.0),
            "source=" + DATASET.indexName + " | sort key"
            row(1L, "OFFICE SUPPLIES"),
            row("key11", 10,   7.333333333333333),  // {8,4,10}
            row("key03", "OFFICE SUPPLIES", null, 2L, null,                null, null),
    }
    /** sql IT: testMultipleStreamstatsWithNull2. Same query as
            row("key15", "e",  4,    5L),
     *  NaN as a string in JSON arrays). */
            row("key03", "OFFICE SUPPLIES", null, 2L),
    }
                + " stddev_pop(int0), stddev_samp(int0), var_pop(int0), var_samp(int0)"
        }
    public void testStreamstatsCurrentAndWindow() throws IOException {
        );
            row("key04", 7,    null),
            row("key13", 4,    2.8695600708122493,  3.0676887530703447, 8.234375,           9.410714285714286),
            row("key07", null, 2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
            if (Math.abs(e - a) > 1e-9 * Math.max(Math.abs(e), 1.0)) {
    }
        assertNotNull("Response missing 'rows'", actualRows);
            "source=" + DATASET.indexName + " | streamstats window=-1 avg(int0) as avg",
            row("key08", "TECHNOLOGY",      null, null,                null,               null,               null),
    //
            "source=" + DATASET.indexName + " | sort key"
        );
            return;
    public void testStreamstatsGlobalWithNull() throws IOException {
                + " | streamstats count() as cnt by span(int0, 10), str0"
            row("key15", "TECHNOLOGY",      4,    4L),
    public void testStreamstatsDistinctCountByCountry() throws IOException {
    /** sql IT: testStreamstatsWindowError. window=-1 must be a parse-time / argument-validation
        );
            row("key13", "TECHNOLOGY",      4,    3L),
        Map<String, Object> response = executePpl(
            row("key12", "TECHNOLOGY",      13L, 14, 60L),
            row("key14", "TECHNOLOGY",      11,   2.9393876913398134,  3.2863353450309964, 8.639999999999997,  10.799999999999997),
     *  depend on input row-order; under multi-shard parallelism rows arrive at the
    }
        Map<String, Object> r2 = executePpl(
        assertRowsEqualList(response, EXPECTED_RESET_ROWS);
    /**
            row("key01", null, 1.0),
        );
            row("key10", 4,    2.6718699236469,     2.926886855802026,  7.13888888888889,   8.566666666666668),
     *  may not flow through analytics-engine for the specific embedded shape; conservatively
            row("key10", 4,    11L, 5.166666666666667,   1, 8),
                + " | streamstats count() as cnt"
            row("key03", "OFFICE SUPPLIES", 4L,  5,  9L),
        Map<String, Object> response = executePpl(
                + " | streamstats count() as cnt"
        assertRowsEqual(
    }
     *  send}) so the assertion was the tolerant {@code assertErrorAny}. The decorrelated-correlate
                + " | fields key, int3, int0, cnt, avg, mn, mx"
            row("key15", "TECHNOLOGY",      4,    8L, 6.833333333333333,   4,    11),
                + " | streamstats window=3 avg(int0) as avg3"
            row("key08", null, 8.0),
            row("key07", null, 8L,  7.0),
            row("key16", 8,    17L, 16.0)
     *  see {@code DataFusionFragmentConvertor.replaceInput} for the lifted-window Project
                + " | fields key, str0, int0, sp, ss, vp, vs"
            row("key08", null, null, null, null,              null, null),
            row("key12", null, 7.0),   // {4,10,null}
    }
     *  may change as more analytics-engine functionality lands). The contract here is just
    /** Multi-shard variant for streamstats dc by partition. Streamstats running aggregates
        row("key00", "FURNITURE",       1,    1.0),
        } catch (ResponseException expected) {
    }
            row("key01", null, 1L, null,               null, null),
            row("key12", null, 13L, 7.0),
        );
            row("key11", 10,   12L, 11.0),
    // calcs.str3 is "e" on every non-null row → dc_str3 stays at 1 once the first non-null is
        );
     *  is fully populated. {@code span(int3, 10)} produces two buckets: 0 (9 rows) and 10
    }
 * <h2>What works on the analytics-engine route after #21668 + this PR's PARTITION BY relaxation</h2>
            row("key15", "TECHNOLOGY", 1L),
                + " [ source=" + DATASET.indexName + " | sort key | streamstats count() as cnt"
            double e = ((Number) expected).doubleValue();
            row("key14", 11,   5.625),
            row("key16", "TECHNOLOGY",      8,    9L, 7.0,                 4,    11)
 *       gate forces SINGLETON gather, WindowAggExec runs running-aggregate on coordinator.</li>
        // Running dc(str3): "e" on key00..03 → 1; nulls on key04..05 don't change count;
     *  stays inside one group — making the {@code global=true} output identical to {@code
    }
     *  avg of int0 over those 2 prior rows. */
            dataProvisioned = true;
        );
    /** sql IT: testStreamstatsByMultiplePartitions1. {@code by span(int0, 10), str0}. */
        ensureMultiShardProvisioned();
            row("key03", null, 1.0),
            row("key09", 8,    8.0),
            row("key08", "TECHNOLOGY",      null, null),
            row("key14", 11,   6.222222222222222),
    }
    /** sql IT: testUnsupportedWindowFunctions. */
                + " | fields key, str0, int0, avg"
            row("key01", null, 2L,  1.5),
    /** sql IT: testStreamstatsDistinctCountByCountry. Per-partition running dc(str3).
            row("key14", 11,   15L, 14.0),
     *  running cnt. */
     *  the input row order, so e.g. OFFICE SUPPLIES rows {key02..key05, key07, key09} appear
            row("key15", 4,    6.333333333333333),  // {4,11,4}
            row("key09", "e",  8,    7L,   5.666666666666667, 1,    8),
            row("key02", "OFFICE SUPPLIES", null, 1L, null,                null, null),
                + " | streamstats count() as cnt"
            row("key11", 10,   5.857142857142857),
            "source=" + DATASET.indexName + " | streamstats earliest(str0), latest(str0) by str3"
            row("key07", "e",  1L),
            "source=" + DATASET.indexName + " | sort key"
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str3"
            row("key04", 7,    3.0,                 4.242640687119285,  9.0,                18.0),
    }
                body.contains(expectedSubstring)
 *       lowers to {@code SUM/AVG/COUNT/MIN/MAX OVER (ROWS UNBOUNDED PRECEDING TO CURRENT ROW)}. Cost
 *   <li><b>Plain {@code streamstats <agg>}</b> (no by, no current, no window, no reset, no global) —
            row("key05", 3,    4.0),
            row("key10", 4,    5.4),
        assertRowsEqualList(response, Arrays.asList(expected));
        );
            row("key03", null, 4L,  2.5),
            row("key15", "TECHNOLOGY",      4,    7.5),
                || "NaN".equals(actual))) {
            row("key00", "FURNITURE", 1L),
        try {
            row("key10", "TECHNOLOGY",      4,    3L, 6.0,                 4,    8),
    }
     *  gets its own running 1..N). eval x=cnt+1. Second streamstats sum(x) by str0
        );
            row("key09", 10L, 11, 65L),
    /** sql IT: testStreamstatsDistinctCountFunction. {@code distinct_count()} alias for dc. */
            row("key11", null, 10,   4L,  6.666666666666667,  3,    10),
        Map<String, Object> response = executePpl(
            row("key10", 4,    5.4),
            row("key07", null, 8L,  4.75,                1, 8),
            row("key16", 8,    17L, 16.0)
            "source=" + DATASET.indexName + " | sort key"
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
     *  {@link #testStreamstatsByMultiplePartitions2}. */
    // ── Multi-shard correctness — exercises the SINGLETON-gather cost gate ────
            row("key09", 8,    5.4),
            row("key16", 17L, 18, 170L)
            row("key04", null, 1L),
        if (multiProvisioned == false) {
    }
            row("key14", "e",  1L),
            row("key09", 8,    5L, 5.4,                1,    8),
            row("key09", "TECHNOLOGY",      8,    2L, 8.0,                 8,    8),
            row("key00", "e",  1,    1L,  1.0,                1,    1),
     *  expect throw. */
            row("key14", 11,   5.625),
            row("key00", 1,    0.0,                 (Double) null,         0.0,                (Double) null),
            row("key13", null, 1L),
            row("key09", "TECHNOLOGY", 1L),
    /** sql IT: testStreamstatsVariance. Running stddev_pop / stddev_samp / var_pop / var_samp
            row("key04", "OFFICE SUPPLIES", 7,    1L),
            row("key12", null, null, 5L,  6.666666666666667,  3,    10),
            row("key10", "TECHNOLOGY",      4,    2L),
    private static void assertCellEquals(String message, Object expected, Object actual) {
            row("key01", "FURNITURE",       null, 1L),
 *
     *  reset on the second streamstats. First pass: per-partition cnt by str0 (each str0
            row(1L, "TECHNOLOGY")
            row("key07", "OFFICE SUPPLIES", null, 8.0),
        Map<String, Object> response = executePpl(
            row("key05", 3,    3L, 3.6666666666666665, 1,    7),
        assertRowsEqual(
            row("key09", 8,    10L, 9.0),
    public void testStreamstatsCurrent() throws IOException {
        Map<String, Object> response = executePpl(
    }
            row("key07", "OFFICE SUPPLIES", 2L),
            row("key11", 10,   12L, 5.857142857142857,   1, 10),
    public void testMultipleStreamstatsWithEval() throws IOException {
            row("key02", "e",  1L),
     *  reason this matches {@code testStreamstatsGlobal}. {@code bucket_nullable=false} only
 * name in the source IT. Reachable cases assert exact rows; cases that depend on functionality
            row("key05", 6L,  7,  27L),
        );
            "source=" + DATASET.indexName + " | sort key"
     *  which {@code OpenSearchJoinSplitRule} sends both sides through coord-singleton ERs and
    private void assertErrorAny(String ppl) throws IOException {
            row("key10", "TECHNOLOGY",      4,    6.0),
                + " | fields key, int0, cnt, avg_cnt"
            row("key11", "TECHNOLOGY",      10,   1L),
            "source=" + DATASET.indexName + " | sort key"
        Map<String, Object> response = executePpl(
    public void testStreamstatsByMultiplePartitionsWithNull2() throws IOException {
    }
            row("key08", null, null, 3L,  5.0,                3,    7),
            row("key14", 11,   3.189488909868294,   3.3829638550307397, 10.172839506172838, 11.444444444444443),
    }
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {
    public void testStreamstatsResetWithNullBucket() throws IOException {
            row("key09", 8,    2.8705400188814645,  3.209361307176242,  8.239999999999998,  10.299999999999997),
            row("key08", null, 9L,  17L),
            row("key01", "FURNITURE", 1L),
    private static boolean dataProvisioned = false;
            row("key06", 8,    7L,  4.0),
    public void testStreamstatsWindowError() throws IOException {
    /** Send a PPL query and assert response body contains {@code expectedSubstring}. */
            response,
            row("key10", 4,    6L, 5.166666666666667,  1,    8),
    public void testStreamstatsWindowWithNull() throws IOException {
            row("key15", "e",  1L),
        assertRowsEqual(response,
            row("key12", null, 2.996596709057576,   3.236694374850748,  8.979591836734695,  10.476190476190476),
            row("key09", "TECHNOLOGY",      8,    1L),
            row("key11", 10,   5.166666666666667),
            row("key14", "TECHNOLOGY", 1L),
            row("key02", "OFFICE SUPPLIES", 2L),
     *    → 0,1,1,1,1,1,1,1,1 (the leading null sees no non-null yet, so dc=0). */
    }
            row("key13", 4,    14L, 13.0),
                + " | streamstats current=false avg(int0) as prev_avg"
    public void testStreamstatsAndEventstats() throws IOException {
    /** sql IT: testStreamstatsWindow. {@code window=3} → frame is 2 PRECEDING TO CURRENT ROW.
        );
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> response = executePpl(
     *  produces per-partition running sum of (cnt+1) within the same partition. */
    }
            row("key09", 8,    10L, 5.5),
    public void testStreamstatsCurrentAndWindowWithNull() throws IOException {
        Map<String, Object> response = executePpl(
        );
        );
        );
        assertRowsEqual(response,
        assertErrorContains(
        );
        );
            "source=" + DATASET.indexName + " | streamstats percentile_approx(int0)",
        );
    // ── Helpers ────────────────────────────────────────────────────────────────
    }
                + " | where cnt < 5 | fields key ]"
            row("key02", null, 3L,  2.0),
            row("key08", null, 4.75),
            row("key16", null, 8,    7L,  6.4,                3,    10)
    /** sql IT: testStreamstatsWindowWithNull. Same query as {@link #testStreamstatsWindow} —
        assertRowsEqual(response,
            row("key11", 10,   5.166666666666667),
            row("key14", "TECHNOLOGY",      15L, 16, 91L),
            "source=" + DATASET.indexName + " | streamstats percentile(int0)",
        );
                + " | sort key | fields key"
        assertEquals("Row count mismatch", expected.size(), actualRows.size());
            row("key13", 4,    14L, 17L),
                + " | streamstats window=3 avg(cnt) as avg_cnt"
     *  per-partition. */
            row("key07", null, 4L, null,               null, null),
        return Arrays.asList(values);
                + " | eventstats max(cnt) as max_cnt"
    }
        assertRowsEqual(
        }
                + " | streamstats count() as cnt by span(int0, 10), str3"
                + " | fields key, int0, cnt, avg_cnt"
     *  {@link #testMultipleStreamstats}. */
            row("key14", "e",  11,   1L),
    private static final Dataset DATASET_MULTI = new Dataset("calcs", "calcs_multi_streamstats");
 * 4-row STATE_COUNTRY index.
    public void testUnsupportedWindowFunctions() throws IOException {
            row("key05", null, 1L),
                + " | sort key | streamstats dc(str3) as dc_str3 by str0"
            row("key08", null, 8.0),   // window={8,null,null}
    /** Multi-shard alias for tests that exercise the SINGLETON-gather cost gate on
     *  case it now handles. */
            row("key06", "e",  8,    3.5,                4.949747468305833,  12.25,              24.5),
                assertCellEquals("Cell mismatch at row " + i + ", col " + j, want.get(j), got.get(j));
     *  in key order intermixed with FURNITURE/TECHNOLOGY rows but the running counter is
            row("key13", "TECHNOLOGY",      4,    2.598076211353316,   3.0,                6.75,               9.0),
     *  "Field reference offset (27) must be less than number of fields in struct (27)" —
            "source=" + DATASET.indexName + " | streamstats count() as cnt"
    public void testStreamstatsWindow() throws IOException {
            row("key02", null, 1.0),
                + " | eval x = cnt + 1"
 * sort, DataFusion's parallel scan can return rows in any order. Every reachable test below
            row("key01", "FURNITURE",       null, 2L, 1.0,                 1,    1),
            row("key16", 8,    7.666666666666667)   // {11,4,8}
            row("key11", "TECHNOLOGY",      10,   1L),
            "source=" + DATASET.indexName + " | sort key | streamstats dc(str3) as dc_str3 | fields key, str3, dc_str3"
     *  over int0. Each row carries the running value at its position (NaN for samp variants
    );
            row("key05", "OFFICE SUPPLIES", 3,    2L),
            row("key15", "TECHNOLOGY", 3L),
            row("key04", 9,  7,    4L, 4.0,                1,    7),
    }
            row("key09", 8,    null),
            row("key07", null, 8L,  17L),
    @SuppressWarnings({"unchecked", "varargs"})
            row("key01", null, null),
            row("key10", "e",  1L),
            );
                + " | fields key, int0, cnt, avg, mn, mx"
        Map<String, Object> response = executePpl(
            row("key01", null, 1.0),
        assertRowsEqual(response,
            row("key13", 4,    10.0),
    /** Per-row {@code window=2} running average of {@code int0} over the calcs dataset, computed
            row("key10", 4,    5.166666666666667),
            row("key01", "e",  1L),
 *       until the downstream race is closed.</li>
        assertRowsEqual(response,
            row("key06", 8,    2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
            row("key11", 10,   6.0),
    // ── Empty input ────────────────────────────────────────────────────────────
            row("key09", "e",  1L),
            row("key00", 1,    1L,  1.0),
        assertRowsEqual(response,
            row("key08", "TECHNOLOGY",      null, 1L, null,                null, null),
            row("key08", null, 8.0),
                + " | streamstats stddev_samp(int0) as ss by span(int0, 10)"
            row("key00", 1,    null),
    public void testStreamstatsReset() throws IOException {
        assertRowsEqualList(response, EXPECTED_GLOBAL_TRUE_ROWS);
 * The OpenSearch Contributors require contributions made to
     *  Null-key rows form their own running partition and accumulate count() but
        assertNotNull("Response missing 'rows'", rows);
        );
            row("key01", "FURNITURE",       null, 0.0,                 (Double) null,         0.0,                (Double) null),
            row("key04", null, 7,    1L),
 *   <li>{@code testWhereInWithStreamstatsSubquery} — reachable on the analytics-engine route via
                + " | fields key, int0, cnt, avg_cnt"
            row("key01", null, 1.0),
    public void testStreamstatsGlobal() throws IOException {
        );
 */
        );
    }
    // BackendPlanAdapter rewrites RexOver(DISTINCT_COUNT_APPROX) → APPROX_COUNT_DISTINCT,
    }
            return;
            row("key10", 4,    6.0),
                + " | fields key, str0, cnt, x, sx"
     *  {@code span(int0, 10)} reintroducing the null bucket. */
            row("key05", "OFFICE SUPPLIES", 2L),
    public void testStreamstatsBy() throws IOException {
            row("key13", 4,    14L, 13.0),
            row("key10", "TECHNOLOGY",      4,    2.0,                 2.8284271247461903, 4.0,                8.0),
 *
        row("key06", "OFFICE SUPPLIES", 8,    8.0),
    /** sql IT: testStreamstatsVarianceBySpan. Per-row running stddev_samp partitioned by
            row("key12", "TECHNOLOGY",      null, 2L),
            row("key04", "OFFICE SUPPLIES", 7,    1L),
        );
        assertRowsEqual(response,
        Map<String, Object> response = executePpl(
        row("key07", "OFFICE SUPPLIES", null, 8.0),
            row("key15", 4,    6.222222222222222),
    @SafeVarargs
            row("key07", "e",  null, 6L,  4.5,                1,    8),
        if (expected instanceof Number && actual instanceof Number) {
 *   <li>{@code streamstats dc / distinct_count / earliest / latest / percentile / median / mode}
            row("key12", 11, null, 5L, 6.0,                4,    8),
        );
        );
     * not span the boundary. Lowering: {@code buildStreamWindowJoinPlan} (Correlate +
            row("key16", 8,    3.009626428590336,   3.1565228279922772, 9.05785123966942,   9.963636363636363)
    // ── streamstats … by ───────────────────────────────────────────────────────
            row("key06", "OFFICE SUPPLIES", 8,    3L),
            row("key09", 8,    null),
            row("key01", "FURNITURE", 1L),
     *  ending at current within its str0 partition (sorted by key). */
        Map<String, Object> response = executePpl(
            row("key01", null, 1.0),
            row("key05", 3,    3.6666666666666665),
            row("key00", "FURNITURE",       1,    1.0),
        );
            row("key14", 11,   15L, 8.0),
            row("key13", 4,    5.857142857142857),
            row("key04", null, 7,    1L,  7.0,                7,    7),
    private static final List<List<Object>> EXPECTED_RESET_ROWS = List.of(
        assertErrorAny(
            row("key06", "e",  1L),
        );
            row("key09", 8,    10L, 9.0),
        row("key05", "OFFICE SUPPLIES", 3,    5.0),
                + " | fields key, int0, sp, ss, vp, vs"
                + " | streamstats reset_before=(int0 > 5) avg(int0) as avg by str0"
            "source=" + DATASET_MULTI.indexName
    public void testStreamstatsCurrentWithNUll() throws IOException {
    }
            row("key14", 11,   15L, 17L),
        );
public class StreamstatsCommandIT extends AnalyticsRestTestCase {
            row("key03", "OFFICE SUPPLIES", null, null),
                + " | fields key, str0, int0, avg"
    }
                + " | streamstats bucket_nullable=false count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str3"
            row("key08", 9L,  10, 54L),
    public void testStreamstatsVarianceBySpan() throws IOException {
            row("key12", null, 13L, 7.0),
            row("key12", null, 13L, 12.0),
                + " | streamstats window=2 global=false avg(int0) as avg by str0"
        row("key15", "TECHNOLOGY",      4,    7.5),
            row("key09", 8,    8.0),   // window={null,null,8}
            row("key02", null, 1.0),
            row("key07", null, null),
        );
    protected void onBeforeQuery() throws IOException {
            row("key00", "FURNITURE", 1L),
        );
            double a = ((Number) actual).doubleValue();
     *  7 nulls). */
            row("key09", "e",  8,    3.299831645537222,  4.041451884327381,  10.888888888888891, 16.333333333333336),
                + " | fields key, cnt, x, sx"
            row("key16", null, 8,    4L)
 *
            row("key09", 8,    3.209361307176242),
                + " stddev_pop(int0), stddev_samp(int0), var_pop(int0), var_samp(int0) by str0"
            row("key05", 3,    6L,  17L),
 * <p>Streamstats running aggregates depend on row-order. Calcs has 17 rows; without an explicit
    /** sql IT: testStreamstatsGlobalWithNull. {@code global=true} lowers to a self-join with a
 * should be promoted to passing assertions.
            row("key08", 17, null, 3L, 8.0,                8,    8),
            "source=" + DATASET.indexName + " | sort key"
    /** Hand-computed running average for {@code reset_before=(int0 > 5)} over the calcs
            row("key09", 8,    10L, 17L),
            row("key13", 4,    14L, 5.625,               1, 10),
     *  Streamstats does not gather rows from the same partition together — it sees them in
            row("key11", 10,   (Double) null),
 *       into RexOver.window.partitionKeys, letting SpanAdapter rewrite SPAN's NULL operand
            row("key10", "TECHNOLOGY",      11L, 12, 33L),
     *  same as the unbounded running avg in {@link #testStreamstats}. */
        // "e" on key14..15; null on key16. Once the first non-null is seen, count is 1 forever.
            row("key03", 5,  null, 3L, 1.0,                1,    1),
        );
        assertRowsEqual(response,
     *  {@link #testStreamstatsVariance}. */
            row("key16", 8,    6.181818181818182)
            row("key11", null, 1L),
    }
            row("key14", 11,   15L, 6.222222222222222,   1, 11),
            row("key10", 4,    11L, 10.0),
        Map<String, Object> response = executePpl(
            row("key16", null, 8,    null, null,              null, null)
        row("key02", "OFFICE SUPPLIES", null, null),
            row("key01", "e",  null, 2L,   1.0,               1,    1),
            "source=" + DATASET.indexName + " | sort key"
            row("key01", null, 2L,  17L),
    public void testStreamstatsDistinctCountByCountry_3shard() throws IOException {
     *  {@code str0} has null values, and calcs has none, so the output is identical. */
 * repository one-to-one — every {@code @Test} method here corresponds to a method of the same
            "source=" + DATASET.indexName + " | sort key | streamstats distinct_count(str0) as dc_str0 | fields key, str0, dc_str0"
            row("key06", 18, 8,    2L, 8.0,                8,    8),
            row("key14", 11,   7.5),   // {null,4,11}
            row("key14", 11,   4.0),
                + " | streamstats bucket_nullable=false reset_before=(int0 > 5)"
            row("key08", null, null, 1L),
        row("key12", "TECHNOLOGY",      null, 10.0),
                + " | stats max(dc_str3) as final_dc by str0 | sort str0"
            row("key15", 4,    3.0983866769659336,  3.265986323710904,  9.6,                10.666666666666666),
    /** sql IT: testStreamstatsCurrentAndWindow. {@code current=false window=2} → frame is
            row("key00", 1,    null),
        for (int j = 0; j < expected.length; j++) {
            row("key11", null, 10,   2.867441755680875,  3.5118845842842457, 8.22222222222222,   12.333333333333329),
            List<Object> got = actualRows.get(i);
            row("key05", null, 1L),
        assertRowsEqual(response,
        Map<String, Object> response = executePpl(
        assertRowsEqual(response,
        Map<String, Object> response = executePpl(
            row("key12", null, null),
            row("key07", 8L,  9,  44L),
            // Any error response is acceptable.
        row("key04", "OFFICE SUPPLIES", 7,    7.0),
            row("key14", "TECHNOLOGY",      11,   7.5),
        Map<String, Object> response = executePpl(
        assertRowsEqual(response,
                + " | fields key, str3, int0, cnt, avg, mn, mx"
    public void testLeftJoinWithStreamstats() throws IOException {
 * compatible open source license.
            "source=" + DATASET.indexName + " | sort key"
            row("key14", "TECHNOLOGY",      11,   7L, 7.4,                 4,    11),
        assertRowsEqual(response,
 *       Bounded frame, RexOver-shaped, passes through.</li>
            row("key16", "TECHNOLOGY",      8,    6.0)
            "source=" + DATASET.indexName + " | sort key"
     *  changes the both-null group-key handling, and no row in calcs has a null {@code str0}. */
            row("key00", "e",  1L),
        assertRowsEqual(response,
            row("key04", "OFFICE SUPPLIES", 2L),
     *  count is deterministic: rows with {@code cnt < 5} are the first four keys (key00..key03).
            row("key00", 1,    1.0),
                + " | streamstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs"
    public void testStreamstatsBySpanWithNull() throws IOException {
            row("key11", null, 1L),
            row("key02", "OFFICE SUPPLIES", 3L,  4,  4L),
        row("key12", "TECHNOLOGY",      null, 10.0),
            row("key04", 7,    3.0,                 4.242640687119285,  9.0,                18.0),
            row("key12", "TECHNOLOGY", 1L),
                + " | streamstats window=3 avg(cnt) as avg_cnt"
            row("key06", 7L,  8,  35L),
        List<Object> got = rows.get(0);
            "source=" + DATASET.indexName + " | sort key"
     *  The outer query re-sorts by {@code key} so the IN-filtered result is pinned to an exact,
    // ── current=false / window=N variants ──────────────────────────────────────
            row("key03", null, 4L,  3.0),
            row("key07", "OFFICE SUPPLIES", null, 3L),
            row("key06", 8,    4L, 4.75,               1,    8),
        if (dataProvisioned == false) {
            row("key05", null, 3,    2.0,                2.8284271247461903, 4.0,                8.0),
            row("key13", "TECHNOLOGY", 1L),
     *  NaN-aware: (Double) null matches both (Double) null and the string "NaN" (Jackson encodes
            row("key03", "e",  null, 3L),
                + " | streamstats count() as cnt by span(int0, 10), str3"
            row("key08", null, 8.0),
        Map<String, Object> response = executePpl(
            row("key06", "e",  8,    2L),
                + " | fields key, int0, prev_avg"
        row("key13", "TECHNOLOGY",      4,    4.0),
            row("key12", null, 1L),
            row("key01", null, 2L,  1.5),
            row("key02", null, 1.0),
     *  join and streamstats together. The join shape uses lowering paths (LogicalJoin) that
        Request request = new Request("POST", "/_plugins/_ppl");
 * <p>Same as {@link EventstatsCommandIT}: {@code age→int0}, {@code country→str0},
            row("key05", 3,    4.0),
            row("key12", null, null, null, null,              null, null),
        row("key13", "TECHNOLOGY",      4,    7.0),
    private static void assertRowCount(Map<String, Object> response, int expected) {
            }
    /** sql IT: testStreamstatsBySpanWithNull. Bucketing key has nulls — uses
            row("key04", null, 7,    0.0,                (Double) null,         0.0,                (Double) null),
     *  calcs already has int0 nulls covered. */
            row("key12", null, null, 2L),
     *  DataFusion's NestedLoopJoinExec evaluates the frame predicate.
    /** sql IT: testStreamstatsBy. Per-partition running cnt/avg/min/max. Each row gets the
    // ── streamstats composed with other commands ──────────────────────────────
            row("key01", null, 0.0,                 (Double) null,         0.0,                (Double) null),
                "Query [" + ppl + "] expected error containing [" + expectedSubstring + "] but body was: " + body,
            row("key12", null, 7.0),
        assertRowsEqual(response,
        );
     *  but this QA module only ships the {@code calcs} dataset (whose {@code str3} already has
        );
    public void testStreamstatsBy_3shard() throws IOException {
            row("key16", 8,    3.009626428590336,   3.1565228279922772, 9.05785123966942,   9.963636363636363)
            "source=" + DATASET.indexName + " | sort key | streamstats dc(str3) as dc_str3 by str0 | fields key, str0, dc_str3"
            row("key03", null, 4L,  17L),
            row("key10", 11L, 12, 77L),
    public void testStreamstatsByMultiplePartitionsWithNull1() throws IOException {
        );
 *   <li>{@code streamstats global=true window=N by …} — uses self-join lowering, also not RexOver.</li>
            row("key16", 8,    6.0)
     *  — same shape as {@link #testStreamstatsBy_3shard}. The final dc per partition is 1
            row("key01", null, 2L,  1.5),
        // Window=3 over running counts [1,2,...,17]: at row N≥3, avg = (N-2 + N-1 + N)/3 = N-1.
    // over a UNBOUNDED PRECEDING / CURRENT ROW frame, so dc_* is a per-row running count of
            row("key11", 10,   7.333333333333333),
            row("key07", null, 5.5),
            row("key03", null, 1.0),
            row("key08", null, 9L,  4.75,                1, 8),
            row("key05", "OFFICE SUPPLIES", 1L),
            "source=" + DATASET.indexName + " | sort key"
        );
     *  per-partition windowed running aggregate. Each row's avg covers up to 2 rows of int0
            row("key09", "TECHNOLOGY",      8,    8.0),
            row("key10", 4,    11L, 10.0),
        assertRowsEqual(
    /** sql IT: testWhereInWithStreamstatsSubquery. WHERE-IN with streamstats subquery — uses
    private static void assertScalarRow(Map<String, Object> response, Object... expected) {
        Map<String, Object> response = executePpl(
            row("key06", "OFFICE SUPPLIES", 8,    2.160246899469287,   2.6457513110645907, 4.666666666666667,  7.0),
        row("key08", "TECHNOLOGY",      null, null),
        Map<String, Object> response = executePpl(
    }
            row("key13", 4,    14L, 7.5),
        assertRowsEqual(response,
            row("key15", "e",  1L),
            row("key13", null, 4,    6L,  6.0,                3,    10),
            row("key02", "e",  1L),
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
 * <ul>
     *  calcs already has int0 nulls covered. */
    // ── Unsupported window functions ───────────────────────────────────────────
            row("key13", null, 4,    3L),
            row("key06", 8,    3.6666666666666665),
    /** Same data shape as {@link #testStreamstatsGlobalWithNull} — see the comment there for the
            row("key06", 8,    4.75),
            response,
        assertRowsEqual(
        );
                body = e.getMessage();
        // Per-(str0) sliding window=2 over int0 ignoring nulls:
            row("key00", "FURNITURE",       1L,  2,  2L),
            row("key16", 8,    7.5)
                + " | streamstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs by str3"
                + " | fields key, int0, avg"
 * Self-contained integration test for PPL {@code streamstats} on the analytics-engine route.
 *
 *       CalciteRelNodeVisitor#buildStreamWindowJoinPlan}). Not reachable on analytics-engine.</li>
     *  {@code span(int0, 10)} which produces a null bucket alongside bucket 0 and bucket 10.
    }
            row("key04", null, 1L),
            row("key00", 1,    (Double) null),
            row("key15", 4,    6.0),
 *   <li>{@code streamstats … by span(int0, 10)} works after BackendPlanAdapter recurses
            row("key14", "e",  11,   9L,   6.4,               1,    11),
        );
    }
     *  coordinator out of key order, so per-row running values are not deterministic.
            row("key13", "TECHNOLOGY",      4,    3L),
        assertRowsEqual(response,
            row("key04", 7,    4.242640687119285),
        );
        assertRowsEqual(response,
            row("key06", "OFFICE SUPPLIES", 8,    5.5),
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            response,
            row("key07", "e",  1L),
        );
 *       column via {@code ROW_NUMBER() OVER ()} (now in our enum), then per-partition running
            row("key07", null, 5.5),
        );
                + " | sort -key | head 5"
            Map<String, Object> body = entityAsMap(response);
            row("key16", null, 1L)
        );
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        Map<String, Object> response = executePpl(
            row("key15", "TECHNOLOGY",      16L, 17, 108L),
 */
        Map<String, Object> response = executePpl(
            row("key06", 8,    5.0),
        Map<String, Object> response = executePpl(
 * {@code state→str3}, {@code name→key}.
        assertRowsEqual(response,
     *  the precise error message depends on which lowering path the PPL parser picks (which
    public void testStreamstatsBySpan() throws IOException {
        assertRowsEqual(response,
    public void testMultipleStreamstatsWithNull2() throws IOException {
    }
     *  the 2 rows immediately before current (excluding current itself). avg per row =
            row("key13", 4,    5.625),
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        row("key07", "OFFICE SUPPLIES", null, 8.0),
                + " | fields key, str0, int0, cnt, avg, mn, mx"
    /** sql IT: testStreamstatsAndSort. Streamstats then sort -key (descending). */
            row("key15", 11, 4,    8L, 6.2,                4,    11),
            row("key13", 4,    7.0),
            response,
            row("key14", "e",  11,   9L,  6.4,                1,    11),
            row("key11", 10,   1L, 10.0,               10,   10),
    public void testStreamstatsByWithNullBucket() throws IOException {
    public void testStreamstatsVarianceBy() throws IOException {
    }
            Response response = client().performRequest(request);
            row("key10", "e",  1L),
            row("key07", "e",  null, 4L),
            row("key09", "e",  1L),
            row("key12", null, 6L, null,               null, null),
    }
        assertRowCount(r2, 0);
            row("key05", 3,    3.055050463303893),
            row("key16", "TECHNOLOGY",      8,    2.7774602993176543,  3.0,                7.714285714285714,  9.0)
            row("key08", "TECHNOLOGY",      9L,  10, 10L),
        );
    /** sql IT: testMultipleStreamstatsWithWindow. Second streamstats uses window=3 over the
            row("key04", "OFFICE SUPPLIES", 1L),
            row("key05", null, 3,    2L),
            row("key15", 4,    16L, 15.0),
            fail("Expected query [" + ppl + "] to fail but got: " + body);
                + " | streamstats window=100 avg(int0) as avg"
            row("key12", null, 13L, 12.0),
            row("key13", null, 4,    null, null,              null, null),
            "source=" + DATASET.indexName + " | sort key"
    /** sql IT: testLeftJoinWithStreamstats. streamstats inside left join — exercises both
        row("key00", "FURNITURE",       1,    1.0),
            row("key15", "e",  4,    5L),
                + " | streamstats sum(x) as sx"
     * restoration — the correlate's join predicate is non-equi (range over the row-number seq
        );
 *
            row("key15", "e",  4,    10L, 6.0,                1,    11),
        row("key04", "OFFICE SUPPLIES", 7,    7.0),
            row("key00", 1,    1L,  1.0),
    public void testStreamstatsVariance() throws IOException {
            row("key00", 1,    0.0,                 (Double) null,         0.0,                (Double) null),
            row("key03", null, 0.0,                 (Double) null,         0.0,                (Double) null),
            row("key14", 11,   15L, 14.0),
            row("key02", null, 1.0),
                + " | eval x = cnt + 1"
        // Test source uses BANK_TWO which we don't have. Use a self-join on calcs as a stand-in;
        row("key15", "TECHNOLOGY",      4,    7.5),
            row("key00", 1,    1L,  1.0),
    }
     *  rows that contribute a non-null value. */
        );
        );
            row("key16", 0,  8,    9L, 6.166666666666667,  1,    10)
    }
/**
            row("key00", "e",  1,    1L),
            response,
            row("key13", 4,    5.857142857142857),
            row(1L, "FURNITURE"),
            row("key14", 11,   15L),
     *  TECHNOLOGY) are ingested contiguously, so each row's window of {seq−1, seq} naturally
            row("key03", "e",  1L),
                + " | streamstats bucket_nullable=false window=2 global=true avg(int0) as avg by str0"
            row("key07", null, 8L,  4.5),
            row("key15", 4,    3.0983866769659336,  3.265986323710904,  9.6,                10.666666666666666),
                + " | fields key, int0, prev_avg"
     *  {@link #testStreamstatsByMultiplePartitions1}. */
            row("key16", 8,    7.666666666666667)
     *  global max(cnt) — every row carries the same global max=17. */
                + " | streamstats window=2 global=true avg(int0) as avg by str0"
     *  semi-join lowering inside the subquery. After PlannerImpl's subquery-remove phase the
            "source=" + DATASET.indexName + " | sort key | streamstats dc(str3) as dc_str3 | fields key, str3, dc_str3"
        ensureMultiShardProvisioned();
                + " | fields key, str0, int0, avg"
    /** sql IT: testMultipleStreamstatsWithEval2. Streamstats with eval and a partition-key
    public void testStreamstatsDistinctCountWithNull() throws IOException {
            row("key05", "OFFICE SUPPLIES", 3,    2.0,                 2.8284271247461903, 4.0,                8.0),
     *  {@code FragmentConversionDriver}); the query now executes deterministically.
            row("key14", "e",  11,   1L),
            row("key12", null, 5.857142857142857),
                + " | fields key, str0, int0, avg"
            row("key05", "OFFICE SUPPLIES", 3,    5.0),
            row("key15", 4,    16L),
            row("key04", 7,    5L,  4.0),
            "source=" + DATASET.indexName + " | sort key"
    }
            "source=" + DATASET_MULTI.indexName + " | sort key | streamstats count() as cnt by str0"
            row("key09", "TECHNOLOGY",      8,    1L),
            row("key10", "e",  4,    4L),
        row("key14", "TECHNOLOGY",      11,   7.5),
        assertRowsEqual(response,
        // OFFICE SUPPLIES: [null, null, 7, 3, 8, null] → null, null, 7, 5, 5.5, 8
            row("key00", "FURNITURE",       1,    1L),
            row("key16", null, 8,    2.576819745345025,  2.880972058177586,  6.639999999999998,  8.299999999999997)
    /** sql IT: testStreamstatsEmptyRows. */
                + " | fields key, int0, cnt, max_cnt"
    public void testStreamstatsAndSort() throws IOException {
            row("key01", 13, null, 1L, null,               null, null),
        assertRowsEqual(response,
                + " | streamstats count(), avg(int0), min(int0), max(int0),"
            row("key00", "e",  1,    1L,   1.0,               1,    1),
            row("key13", "TECHNOLOGY",      4,    6L, 6.5,                 4,    10),
            row("key09", 8,    2.8705400188814645,  3.209361307176242,  8.239999999999998,  10.299999999999997),
     *  default-{@code @timestamp} check — calcs has no @timestamp column. Either way the
     * {@code streamstats reset_before=…} segments rows by seq position: each row where the
            row("key03", "OFFICE SUPPLIES", 1L),
        );
            row("key05", 3,    5.0),
    // ── distinct_count / dc ────────────────────────────────────────────────────
                + " | fields key, str3, int0, cnt"
            row("key14", 11,   4.0),
    }
        Map<String, Object> response = executePpl(
            row("key10", "TECHNOLOGY",      4,    2L),
        assertRowsEqual(response,
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
            row("key14", 11,   2L, 10.5,               10,   11),
            row("key15", 4,    8L, 4.875,              1,    8),
            row("key13", "TECHNOLOGY", 3L),
            row("key16", null, 1L)
            row("key01", "FURNITURE",       2L,  3,  5L),
        // Running dc(str0): FURNITURE×2 → 1,1; OFFICE×6 → 2,2,2,2,2,2; TECHNOLOGY×9 → 3,3,...
            row("key16", 8,    17L, 6.181818181818182,   1, 11)
        );
            row("key16", 8,    6.0)
    /** sql IT: testMultipleStreamstats. Two chained streamstats — first running count, then
            row("key06", 8,    6.0),   // window={7,3,8}
            row("key14", 11,   15L, 8.0),
        Map<String, Object> response = executePpl(
        assertEquals("Row count mismatch", expected, rows.size());
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by span(int3, 10)"
            row("key13", "TECHNOLOGY",      14L, 15, 75L),
    }
    /** sql IT: testStreamstatsBigWindow. {@code window=100} exceeds row count; effectively
            row("key12", null, 5.857142857142857),
    }
            row("key05", 3,    6L,  3.5),
    public void testStreamstatsVarianceWithNull() throws IOException {
        );
            row("key14", "TECHNOLOGY",      11,   2L),
 *       shape has a nondeterministic multi-node execution race today. Marked {@code @AwaitsFix}
                + " | left join on key=key right=" + DATASET.indexName
            row(9L, "TECHNOLOGY")
        assertErrorAny(
            row("key07", "OFFICE SUPPLIES", null, 6L, 6.0,                 3,    8),
            row("key14", 11,   7.5),
     *  <p>The subquery sorts by {@code key} before {@code streamstats count()} so the running
                + " | streamstats count() as cnt"
        Map<String, Object> response = executePpl(
     *  <p>For our calcs dataset the {@code str0} groups (FURNITURE / OFFICE SUPPLIES /
            "source=" + DATASET.indexName + " | sort key"
        );
            row("key12", null, null, 2L),
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx"
            row("key07", null, 4.75),
            row("key07", null, 4.75),
            row("key02", null, 0.0,                 (Double) null,         0.0,                (Double) null),
        Map<String, Object> response = executePpl(
    }
            row("key10", "e",  4,    2.947456530637899,  3.4034296427770228, 8.6875,             11.583333333333334),
            row("key01", "FURNITURE",       null, 1.0),
                + " | streamstats window=3 avg(int0) as avg3"
        );
                + " | streamstats count() as cnt"
            row("key14", 11,   0.7071067811865476),
            row("key02", null, 1.0),
            row("key12", null, 7.0),
            DatasetProvisioner.provision(client(), DATASET);
            row("key11", 12L, 13, 90L),
            row("key12", null, 13L)
        );
            row("key10", "TECHNOLOGY", 3L),
     *  TECHNOLOGY (key08..16): null,"e","e",null,null,null,"e","e",null
                + " | streamstats avg(cnt) as avg_cnt"
            row("key13", 4,    7.0),   // {10,null,4}
        }
            row("key02", null, 3L,  17L),
            row("key01", null, 1.0),
                + " | fields key, str3, int0, cnt"
            row("key12", null, 2.996596709057576,   3.236694374850748,  8.979591836734695,  10.476190476190476),
            row("key02", null, 3L,  2.0),
                + " | fields key, int0, avg3"
            row("key11", "TECHNOLOGY", 3L),
            row("key11", 10,   2.996596709057576,   3.236694374850748,  8.979591836734695,  10.476190476190476),
    public void testStreamstatsVarianceWithNullBy() throws IOException {
            row("key06", "OFFICE SUPPLIES", 2L),
        );
        Map<String, Object> r1 = executePpl(
        row("key01", "FURNITURE",       null, 1.0),
            row("key03", null, null),
        }
    // and the DataFusion plugin's approx_count_distinct wrapper UDAF aliases that name to
    }
        assertEquals("Expected " + expected.length + " columns", expected.length, got.size());
            row("key16", "TECHNOLOGY", 3L)
            row("key06", "OFFICE SUPPLIES", 8,    3L),
            row("key12", null, 1L),
 *       before substrait emission. The {@code bySpan} cases assert exact per-bucket rows.</li>
    /** sql IT: testStreamstatsGlobal. {@code global=false} with {@code window=2 by str0} is the
            "Window size must be >= 0"
     *
            row("key04", 7,    7.0),   // window={null,null,7}
        );
            row("key00", 1,    1L,  1.0,                 1, 1),
        // analytics-engine likely rejects the streamstats-in-subsearch shape.
            row("key05", "OFFICE SUPPLIES", 3,    2L),
     * segment-id filter), which became reachable on the analytics-engine route after theta-join
        row("key10", "TECHNOLOGY",      4,    6.0),
        Map<String, Object> response = executePpl(
    }
    /** sql IT: testStreamstatsAndEventstats. Streamstats running cnt followed by eventstats
            row("key05", 3,    6L,  3.6666666666666665,  1, 7),
        Map<String, Object> response = executePpl(
        // "e" on key06..07 still 1; null on key08; "e" on key09..10; nulls on key11..13;
     *  the non-null partition's running count proceeds as usual. Same {@code by str3} as
    public void testStreamstatsEarliestAndLatest() throws IOException {
            row("key01", 2L,  3,  5L),
        Map<String, Object> response = executePpl(
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
            row("key04", "OFFICE SUPPLIES", 7,    0.0,                 (Double) null,         0.0,                (Double) null),
            row("key00", "e",  1,    0.0,                (Double) null,         0.0,                (Double) null),
                + " | fields key, str0, int0, cnt"
            row("key04", 7,    4.0),
            row("key04", 7,    5L,  17L),
                + " | streamstats count() as cnt by span(int0, 10), str0"
            row("key02", "e",  null, 2L),
            row("key04", 7,    5L,  4.0,                 1, 7),
            }
            row("key16", 8,    17L, 9.0)
            row("key08", null, 4.75),
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str0"
     *  {leftSeq−1, leftSeq}} AND {@code rightStr0 = leftStr0}; nulls in {@code int0} are dropped
    /** sql IT: testStreamstatsByMultiplePartitions2. {@code by span(int0, 10), str3}. */
            row("key02", null, null),
        );
            row("key02", null, 3L,  2.0),
            assertEquals(message, expected, actual);
            String body;
            row("key06", 8,    2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
    /** sql IT: testStreamstatsCurrentWithNUll. Same query as {@link #testStreamstatsCurrent} —
            row("key03", null, null),  // window={null,null,null}, no non-null
            "percentile"
 *       conditional aggregate, doesn't flow through RexOver at all (see {@code
            row("key08", null, 9L,  8.0),
            row("key05", 3,    6L,  3.5),
 * before the streamstats step. This differs from the sql IT which trusts ingestion order on a
            row("key11", 10,   2.996596709057576,   3.236694374850748,  8.979591836734695,  10.476190476190476),
            row("key11", 10,   12L, 11.0),
 * <p>Mirrors {@code CalciteStreamstatsCommandIT} from the {@code opensearch-project/sql}
            row("key02", null, 1.0),
        row("key03", "OFFICE SUPPLIES", null, null),
            row("key00", "FURNITURE",       1,    0.0,                 (Double) null,         0.0,                (Double) null),
    // that order (sorted by key), so dc_str0 walks 1 → 2 → 3.
            row("key05", 3,    5.0),   // window={null,7,3}
     *  running aggregate at its position within the partition (rows ordered by key).
    @SuppressWarnings("unchecked")
import org.opensearch.client.Request;
 *       the analytics-engine route yet.</li>
        Map<String, Object> response = executePpl(
            row("key04", 7,    7.0),
    }
            row("key04", null, 7,    1L),
    private static List<Object> row(Object... values) {
            "source=" + DATASET.indexName + " | where key in"
    public void testStreamstatsByWithNull() throws IOException {
            row("key03", "e",  null, 3L),
     *  global=false} on this data. Both null bucket variants behave the same here because no
        Map<String, Object> response = executePpl(
            row("key12", "TECHNOLOGY",      null, 10.0),
            row("key16", 8,    17L),
        assertRowsEqual(response,
        );
            row("key16", "TECHNOLOGY",      8,    5L)
    /** sql IT: testStreamstatsCurrentAndWindowWithNull. Same query as
    }
     *  running avg over those counts. At row N, cnt=N and avg_cnt = (N+1)/2. */
            row("key07", null, 5.5),
            row("key16", null, 8,    4L)
            assertEquals("Column count mismatch at row " + i, want.size(), got.size());
            "source=" + DATASET.indexName + " | sort key"
 * starts with {@code | sort key} (the unique row id) to pin output to a deterministic order
                + " | streamstats count() as cnt"
            row("key07", 3,  null, 6L, 3.6666666666666665, 1,    7),
                + " | streamstats count(), avg(int0), min(int0), max(int0),"
            row("key06", 8,    7L,  4.0),
    public void testStreamstats() throws IOException {
        assertRowsEqual(response,
     *  multi-node race ({@code Stage 0 sink feed failed: partition stream receiver dropped before
            row("key01", null, 2L,  1.0,                 1, 1),
            row("key12", null, 5.857142857142857),
     *  error. PPL parser rejects this before reaching analytics-engine planner. */
            row("key02", "OFFICE SUPPLIES", null, 1L),
        );
        Map<String, Object> response = executePpl(
                + " | stats max(cnt) as final_cnt by str0 | sort str0"
     *  partitioned streaming windows. See {@code EventstatsCommandIT.DATASET_MULTI} for the
            row("key16", 8,    17L, 17L)
package org.opensearch.analytics.qa;
            row("key04", 5L,  6,  20L),
 * </ul>
        );
            row("key03", "e",  null, 4L,   1.0,               1,    1),
            row("key04", "OFFICE SUPPLIES", 7,    3L, 7.0,                 7,    7),
                + " | streamstats count() as cnt"
            row("key07", null, 2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
            row("key05", 3,    7.0),
            row("key13", 4,    2.70801280154532),
            row("key00", 1L,  2,  2L),
        row("key01", "FURNITURE",       null, 1.0),
    }
     * key16}, producing 7 segments (id 0..6) over the 17-row dataset. Default {@code current=true}
    public void testMultipleStreamstatsWithWindow() throws IOException {
            row("key05", null, 3,    null, null,              null, null),
import org.opensearch.client.ResponseException;
        }
     *  BETWEEN frame predicate (non-equi) AND-ed with the group equality. The non-equi predicate
            "source=" + DATASET.indexName + " | sort key"
            row("key15", 4,    16L, 8.5),
        );
            row("key15", 4,    16L, 8.5),
    @SuppressWarnings("unchecked")
            row("key03", "e",  null, 0.0,                (Double) null,         0.0,                (Double) null),
    }
            row("key10", 4,    6.0),   // window={null,8,4}
            row("key16", "TECHNOLOGY",      8,    5L)
            assertTrue(
            return;
 *   <li>{@code testLeftJoinWithStreamstats} — streamstats inside a left-join, not exercised on
            row("key05", 7,  3,    5L, 3.6666666666666665, 1,    7),
        Map<String, Object> response = executePpl(
            row("key15", 4,    16L, 15.0),
            "source=" + DATASET.indexName + " | sort key"
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably).
            row("key08", null, 1L),
            row("key09", 8,    4.75),
            row("key12", "TECHNOLOGY",      null, 5L, 7.333333333333333,   4,    10),
     *  path is not yet reachable on analytics-engine — assert the failure. */
            row("key01", null, 0.0,                 (Double) null,         0.0,                (Double) null),
 * not yet wired through the analytics-engine route are {@code expectThrows} negative tests
                + " | streamstats current=false avg(int0) as prev_avg"
import java.io.IOException;
        }
            row("key00", "FURNITURE",       1,    1L),
            row("key04", 7,    5L,  3.0),
            row("key02", "OFFICE SUPPLIES", null, 1L),
                + " | streamstats count() as cnt"
            row("key01", "e",  null, 1L),
            row("key03", "OFFICE SUPPLIES", 2L),
            "source=" + DATASET.indexName + " | sort key"
            row("key15", 4,    7.5),
        row("key09", "TECHNOLOGY",      8,    8.0),
        Map<String, Object> response = executePpl(
            row("key08", null, null),
     *  OFFICE SUPPLIES (key02..07): "e","e","e",null,null,"e","e" → 1,1,1,1,1,1.
    public void testStreamstatsByMultiplePartitions1() throws IOException {
        );
        }
            "source=" + DATASET.indexName + " | sort key"
            row("key02", "OFFICE SUPPLIES", 1L),
                + " | fields key, int0, sp, ss, vp, vs"
            "source=" + DATASET.indexName + " | sort key"
    /** sql IT: testMultipleStreamstatsWithNull1. Same query as
            row("key02", "OFFICE SUPPLIES", null, null),
            row("key09", 8,    10L, 5.4,                 1, 8),
    public void testStreamstatsResetWithNull() throws IOException {
            row("key01", "e",  1L),
    }
        );
                + " | head 1"
            row("key16", 8,    9L, 5.222222222222222,  1,    8)
    }
    // distinct non-null values seen so far in the partition. At calcs's scale (low cardinality)
    }
            row("key05", 3,    6L,  5.0),
 * <ul>
    public void testMultipleStreamstatsWithEval2() throws IOException {
        );
            row("key10", 4,    2.926886855802026),
                + " | streamstats current=false window=2 avg(int0) as avg"
            "source=" + DATASET.indexName + " | sort key"
            row("key10", 4,    11L, 6.0),
    /** sql IT: testStreamstatsEarliestAndLatest. earliest/latest exercise the PPL frontend's
     *  streamstats sum(x) running. */
            row("key11", 2,  10,   8L, 5.8,                1,    10),
     *  avg/min/max stay NULL since there are no non-null int0 values to consume. */
            row("key03", null, 1.0),
        assertRowsEqual(response,
        assertErrorContains(
        );
    /** sql IT: testStreamstats. Per-row running count/avg/min/max over int0. count() counts every
            row("key09", 8,    4.75),
        row("key11", "TECHNOLOGY",      10,   7.0),
            row("key14", 18, 11,   7L, 6.75,               4,    11),
import java.util.Arrays;
            row("key15", "e",  4,    3.3166247903554,    3.63318042491699,   11.0,               13.2),
     *  rows form their own running partition and accumulate normally. {@code str3} has 7 nulls
                + " | fields key, int0, cnt, avg_cnt"
            row("key16", "TECHNOLOGY",      17L, 18, 126L)
            row("key13", 4,    10.0),
                + " | fields key, str3, int0, sp, ss, vp, vs"
            "source=" + DATASET.indexName + " | sort key"
            row("key09", "TECHNOLOGY",      8,    0.0,                 (Double) null,         0.0,                (Double) null),
        assertEquals("Expected exactly one row", 1, rows.size());
            row("key03", "OFFICE SUPPLIES", null, null,                null,               null,               null),
        } catch (ResponseException e) {
     *  multi-leaf {@code OpenSearchStageInputScan} schema resolution in
 * SPDX-License-Identifier: Apache-2.0
            && (actual instanceof Double && Double.isNaN((Double) actual)
            "source=" + DATASET.indexName + " | sort key"
            row("key13", null, 1L),
            row("key13", 4,    14L),
import java.util.Map;
        row("key11", "TECHNOLOGY",      10,   10.0),
            row("key15", 4,    2.5319388392523003),
        assertRowsEqual(response,
            row("key02", "e",  null, 2L),
        assertRowsEqualList(response, EXPECTED_RESET_ROWS);
     * {@code seq <= current_seq}. Nulls in {@code int0} are dropped by AVG.
            row("key02", null, 0.0,                 (Double) null,         0.0,                (Double) null),
     *  used to be rejected at the join marker rule until theta-join routing was restored, after
            row("key11", null, 10,   null, null,              null, null),
        row("key10", "TECHNOLOGY",      4,    6.0),
     * predicate is true bumps a segment id, partitioning the running aggregate so windows do
            row("key04", 7,    2L, 4.0,                1,    7),
            row(6L, "OFFICE SUPPLIES"),
                + " | fields key, int0, avg"
            row("key14", "TECHNOLOGY",      11,   2L),
    }
            row("key02", "OFFICE SUPPLIES", null, null,                null,               null,               null),
    /** {@code bucket_nullable=false} excludes null group-keys from aggregation. Calcs has no
            row("key08", "TECHNOLOGY", 0L),
            "source=" + DATASET.indexName + " | where key = 'non-existed'"
                + " | fields key, int0, avg"
    private static boolean multiProvisioned = false;
            "source=" + DATASET.indexName + " | sort key"
    // ── Basic streamstats (no by) ──────────────────────────────────────────────
    }
    // ── Multiple streamstats (chained) ─────────────────────────────────────────
        Map<String, Object> response = executePpl(
        assertEquals(message, expected, actual);
            row("key10", 11, 4,    4L, 6.0,                4,    8),
        );
        );
        // FURNITURE: [1, null] → avg=1, 1
            row("key12", 13L, 14, 104L),
        Map<String, Object> response = executePpl(
            row("key06", "OFFICE SUPPLIES", 1L),
        row("key08", "TECHNOLOGY",      null, null),
        assertErrorContains(
     *  {@link #testStreamstatsCurrentAndWindow}. */
                + " | fields key, int0, cnt"
            row("key11", 10,   12L, 6.5),
            row("key06", "e",  8,    5L,   4.5,               1,    8),
        }
            row("key10", 4,    2.6718699236469,     2.926886855802026,  7.13888888888889,   8.566666666666668),
            row("key00", 1,    null),
 * <h2>What fails (expectThrows)</h2>
            row("key10", 4,    8.0),
            row("key06", 8,    7L,  4.75,                1, 8),
            row("key03", null, 4L,  3.0),
            row("key10", 4,    8.0),
    }
            row("key14", "e",  1L),
            row("key00", "e",  1L),
            row("key10", 4,    11L, 6.0),
            row("key02", null, 1.0),
            row("key11", "TECHNOLOGY",      10,   2.4944382578492936,  3.0550504633038926, 6.222222222222219,  9.333333333333329),
            row("key15", 4,    16L, 17L),
        assertRowsEqualList(response, EXPECTED_RESET_ROWS);
            List<Object> want = expected.get(i);
    }
     *  + 10 'e' rows; companion to {@link #testStreamstatsByWithNullBucket}. */
            "source=" + DATASET.indexName + " | sort key"
    /** sql IT: testStreamstatsDistinctCountWithNull. Same shape as
    private void assertRowsEqualList(Map<String, Object> response, List<List<Object>> expected) {
import org.opensearch.client.Response;
            row("key14", "e",  11,   3.49857113690718,   3.911521443121589,  12.239999999999998, 15.299999999999997),
        );
            row("key06", 8,    7L,  17L),
            row("key02", 3L,  4,  9L),
        );
                + " | streamstats reset_before=(int0 > 5) avg(int0) as avg by str0"
    /** sql IT: testStreamstatsByMultiplePartitionsWithNull2. Same query as
            row("key04", 7,    1.0),
    );
                + " avg(int0) as avg by str0"
            row("key15", "TECHNOLOGY",      4,    4L),
            row("key12", null, 13L, 17L),
        }
            row("key08", null, 2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
            row("key04", 7,    5L,  4.0),
            row("key11", null, 10,   1L),
            row("key05", 3,    6L,  5.0),
            row("key15", 4,    7.5),
            row("key08", null, 1L),
            row("key05", "OFFICE SUPPLIES", 6L,  7,  22L),
            "source=" + DATASET.indexName + " | where key = 'non-existed'"
            row("key09", 8,    10L, 5.5),
}
     *  {@link #testStreamstatsDistinctCount} — sql-plugin's variant uses STATE_COUNTRY_WITH_NULL,
            row("key15", 4,    6.222222222222222),
            row("key00", 1,    null),
    // seen. calcs.str0 has three values {FURNITURE, OFFICE SUPPLIES, TECHNOLOGY} appearing in
            row("key09", "e",  8,    3L),
     *  its own running variance over int0. */
     * + {@code window=0} → running average over rows with the same {@code (str0, segId)} and
    /** sql IT: testStreamstatsDistinctCount. */
    }
            row("key13", 18, 4,    6L, 5.333333333333333,  4,    8),
        );
            row("key08", null, 4.75),
     *  dataset, sorted by key. See {@link #testStreamstatsReset} javadoc for the segId mapping. */
                + " | fields key, int0, ss"
 * <h2>Note on row order determinism</h2>
import java.util.List;
        if (expected == null || actual == null) {
        row("key03", "OFFICE SUPPLIES", null, null),
            row("key01", "e",  null, 0.0,                (Double) null,         0.0,                (Double) null),
     *  null in {@code str0} so the output matches the bucket-nullable variant exactly. */
            row("key04", 7,    null),
            row("key13", 14L, 15, 119L),
        );
            } catch (Exception ioe) {
            row("key06", 8,    7L,  6.0),
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
     *  ordered row set — this asserts real content end-to-end, not just that the query ran. */
     *  {@code span(int0, 10)}. NaN at 1-element partitions; null until 1+ non-null seen. */
            row("key04", "OFFICE SUPPLIES", 7,    7.0),
        );
            row("key05", "OFFICE SUPPLIES", 3,    4L, 5.0,                 3,    7),
    /** sql IT: testStreamstatsByMultiplePartitionsWithNull1. Same query as
            row("key06", "e",  8,    2L),
        );
     *  (each {@code str0} group has only the value "e" or null in {@code str3}; null is
        );
    /** sql IT: testStreamstatsVarianceBy. Per-partition running variance. NaN until 2+ non-null
     *  row has a null {@code str0}. */
            for (int j = 0; j < want.size(); j++) {
     *  while only 0/1 non-null int0 has been seen). Final row matches eventstats global. */
     * column) and used to be rejected at the marker rule.
            row("key08", "TECHNOLOGY",      null, 1L),
            fail("Expected query [" + ppl + "] to fail with [" + expectedSubstring + "] but got: " + body);
    }
        );
        );
            row("key04", 7,    1.0),
            multiProvisioned = true;
    public void testWhereInWithStreamstatsSubquery() throws IOException {
                + " | streamstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs"
            row("key13", "TECHNOLOGY",      4,    4.0),
            row("key00", 1,    1L, 1.0,                1,    1),
     *  skipped). HLL is exact at calcs's scale so {@code max(dc_str3)} matches single-shard. */
                + " | fields key, int0, cnt, avg, mn, mx"
        assertRowsEqual(response,
            row("key10", "TECHNOLOGY", 1L),
            row("key15", 4,    16L, 6.0,                 1, 11),
            row("key03", null, 3L, null,               null, null),
            row("key08", null, 9L,  5.0),
            row("key08", "TECHNOLOGY", 3L),
            row("key04", "OFFICE SUPPLIES", 5L,  6,  15L),
            try {
            row("key00", 1,    1L,  17L),
     *  execution path was fixed (multi-input backend selection in {@code PlanForker} and the
        );
            "source=" + DATASET.indexName + " | sort key"
        row("key02", "OFFICE SUPPLIES", null, null),
                + " | streamstats current=false window=2 avg(int0) as avg"
 *   <li>{@code streamstats reset_before=… / reset_after=…} — the PPL lowering uses correlate +
            "source=" + DATASET.indexName + " | sort key"
        Map<String, Object> response = executePpl(
            row("key11", "TECHNOLOGY",      10,   4L, 7.333333333333333,   4,    10),
            DatasetProvisioner.provision(client(), DATASET_MULTI, 3);
            row("key05", null, 3,    2L,  5.0,                3,    7),
 *   <li><b>{@code streamstats window=N}</b> — frame is {@code ROWS N-1 PRECEDING TO CURRENT ROW}.
    }
        Map<String, Object> response = executePpl(
        row("key16", "TECHNOLOGY",      8,    8.0)
            row("key00", 1,    1.0),
            "source=" + DATASET.indexName + " | sort key"
    // ── Variance / stddev (running) ────────────────────────────────────────────
            row("key00", 1,    1L,  1.0),
                + " | streamstats sum(x) as sx by str0"
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by span(int0, 10)"
            row("key12", "TECHNOLOGY",      null, 2L),
        Map<String, Object> response = executePpl(
        Map<String, Object> response = executePpl(
            row("key12", "TECHNOLOGY",      null, 2.4944382578492936,  3.0550504633038926, 6.222222222222219,  9.333333333333329),
        row("key09", "TECHNOLOGY",      8,    8.0),
    public void testStreamstatsDistinctCountFunction() throws IOException {
    @Override
        Map<String, Object> response = executePpl(
            row("key09", 2,  8,    7L, 4.75,               1,    8),
    public void testMultipleStreamstats() throws IOException {
            row("key15", 16L, 17, 152L),
        assertRowsEqual(response,
    public void testStreamstatsGlobalWithNullBucket() throws IOException {
     *  Collapse the running stream to per-partition finals via {@code stats max(dc_str3) by str0}
            row("key06", "OFFICE SUPPLIES", 7L,  8,  30L),
     *  int0 seen in the partition; null until 1+ non-null seen. */
        Map<String, Object> response = executePpl(
        row("key14", "TECHNOLOGY",      11,   11.0),
    /** Same data, same query — same lowering. {@code bucket_nullable} only matters when
        try {
            row("key02", "e",  null, 3L,   1.0,               1,    1),
                + " | streamstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs by str0"
            row("key03", null, null),
            row("key01", null, 1.0),
            Map<String, Object> body = entityAsMap(response);
            row("key04", null, 7,    null, null,              null, null),
        );
            row("key08", null, null, 2.0,                2.8284271247461903, 4.0,                8.0),
     *  {@link #testMultipleStreamstatsWithWindow}. */
     *  null-key partition: rows whose {@code by} key is null get NULL running output, while
            row("key03", 4L,  5,  14L),
    // DataFusion's built-in approx_distinct (HyperLogLog). streamstats applies the aggregate
            row("key07", "OFFICE SUPPLIES", null, 2.160246899469287,   2.6457513110645907, 4.666666666666667,  7.0),
            row("key03", null, null),
 *
            row("key01", "e",  null, 2L,  1.0,                1,    1),
            row("key01", null, 2L,  1.5),
 * </ul>
            row("key06", 8,    7L,  6.0),
            row("key08", "TECHNOLOGY",      null, 1L),
            row("key08", null, 2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
            row("key07", "OFFICE SUPPLIES", 8L,  9,  39L),
            "source=" + DATASET.indexName + " | sort key"
/*
 *       PRECEDING}. Still a RexOver, still passes through.</li>
            row("key02", "e",  null, 0.0,                (Double) null,         0.0,                (Double) null),
    }
            row("key05", 3,    2.494438257849294,   3.055050463303893,  6.222222222222221,  9.333333333333332),
            row("key02", null, 2L, null,               null, null),
     *  FURNITURE (key00..01): "e" both → 1, 1.
    /** sql IT: testStreamstatsByWithNull. Default {@code bucket_nullable=true} mode — null-key
        assertRowsEqual(response, row("key00"), row("key01"), row("key02"), row("key03"));
     *
     * <p>For {@code int0 > 5}: segId increments before rows {key04, key06, key09, key11, key14,
            row("key07", "e",  null, 4L),
            row("key01", "FURNITURE",       null, 1L),
            row("key07", null, 8L,  4.5),
            row("key06", "e",  1L),
        assertRowsEqual(response,
     *
                + " | fields key, str3, int0, cnt, avg, mn, mx"
 * <h2>Schema translation</h2>
            row("key06", 8,    6.0),
            row("key13", 4,    7L, 5.0,                1,    8),
    @SuppressWarnings("unchecked")
 *       aggregate. Cost gate gathers, WindowAggExec runs.</li>
            assertCellEquals("Cell mismatch at col " + j, expected[j], got.get(j));
            row("key11", "TECHNOLOGY", 1L),
            row(2L, "FURNITURE"),
     *  At each row, prev_avg = avg of int0 over all preceding rows (excluding current). */
            row("key03", "e",  1L),
        );
            "source=" + DATASET.indexName + " | sort key"
            row("key09", "e",  8,    7L,  5.666666666666667,  1,    8),
            row("key00", 8,  1,    1L, 1.0,                1,    1),
            row("key12", null, 7.0),
        );
            row("key02", 2,  null, 2L, 1.0,                1,    1),
     *  Each row's avg covers up to 3 consecutive rows ending at current; null int0 ignored. */
            row("key11", 10,   12L, 6.5),
            row("key16", 8,    17L, 9.0)
            row("key12", "TECHNOLOGY", 3L),
    private void ensureMultiShardProvisioned() throws IOException {
     *  {@link #testStreamstatsByWithNull}; null-key rows now show NULL aggregates. */
            row("key06", 8,    5.0),
        );
            row("key00", 1,    1.0),
            row("key08", null, null, 1L),
            row("key03", null, 0.0,                 (Double) null,         0.0,                (Double) null),
            row("key08", null, 5L, null,               null, null),
        );
            row("key11", null, 10,   1L),
        Map<String, Object> response = executePpl(
            row("key10", "e",  4,    4L),
            row("key14", 15L, 16, 135L),
     */
            row("key01", null, 1.0),
    // HLL is exact, so we can pin the exact running count.
            row("key11", 10,   6.0),
        row("key05", "OFFICE SUPPLIES", 3,    5.0),
            row("key13", 4,    14L, 7.5),
    /** sql IT: testMultipleStreamstatsWithEval. Streamstats running cnt → eval x=cnt+1 →
    /** sql IT: testStreamstatsBySpan. Bucketing key has no nulls — uses {@code int3} which
     *  row including int0 nulls; avg/min/max ignore them. */
            row("key09", "TECHNOLOGY",      10L, 11, 21L),
    public void testMultipleStreamstatsWithNull1() throws IOException {
        assertRowCount(r1, 0);
 * pinning the precise error message — failing those is how a future PR observes that they
            row("key03", null, null),
            row("key10", "e",  4,    8L,   5.25,              1,    8),
        Map<String, Object> response = executePpl(
        );
            row("key13", null, 4,    2.7386127875258306, 3.1622776601683795, 7.5,                10.0),
            row("key13", null, 4,    3L),
        );
            row("key07", "e",  null, 6L,   4.5,               1,    8),
    public void testStreamstatsBigWindow() throws IOException {
        );
     *  by AVG; left-join semantics keep every left row even when the frame matches no right
            row("key07", null, 8L,  7.0),
     *  has 7 nulls + 10 'e' rows — covers null-key partition handling. Each partition runs
    /** sql IT: testStreamstatsVarianceWithNullBy. Variance partitioned by {@code str3}, which
        assertNotNull("Response missing 'rows'", rows);
            row("key02", "e",  null, 3L,  1.0,                1,    1),
    /** Send a PPL query and assert it fails with ANY error response. Used for cases where
            row("key00", "FURNITURE",       1,    1L, 1.0,                 1,    1),
        assertRowsEqual(response,
        for (int i = 0; i < expected.size(); i++) {
            "percentile_approx"
            row("key11", 10,   12L, 17L),
            row("key03", null, 4L,  2.5),
            row("key15", 4,    6.333333333333333),
            row("key00", "e",  1,    1L),
            row("key07", "OFFICE SUPPLIES", 1L),
    private static final List<List<Object>> EXPECTED_GLOBAL_TRUE_ROWS = List.of(
        );
        );
            row("key12", null, null, 2.867441755680875,  3.5118845842842457, 8.22222222222222,   12.333333333333329),
    public void testStreamstatsByMultiplePartitions2() throws IOException {
            row("key14", 11,   3.189488909868294,   3.3829638550307397, 10.172839506172838, 11.444444444444443),
            row("key05", null, 3,    2L),
            row("key16", 8,    2.5873624493766703)
    /** sql IT: testStreamstatsVarianceWithNull. Same query as
            row("key09", "e",  8,    3L),
            row("key15", "e",  4,    10L,  6.0,               1,    11),
    /** sql IT: testStreamstatsByWithNullBucket. {@code bucket_nullable=false} drops the
     *  by hand and shared by the two {@code global=true} cases. Frame is {@code rightSeq IN
            row("key07", null, 5.5),   // window={3,8,null}
            row("key02", null, 3L,  2.0),
 *       PlannerImpl's subquery-remove phase, but the streamstats-inside-decorrelated-correlate
    public void testStreamstatsEmptyRows() throws IOException {
 *   <li><b>{@code streamstats current=false}</b> — frame is {@code ROWS UNBOUNDED PRECEDING TO 1
            "source=" + DATASET.indexName + " | sort key"
                + " | fields key, str0, int0, avg"
            "source=" + DATASET.indexName + " | sort key"
 *
            row("key06", "e",  8,    5L,  4.5,                1,    8),
            row("key16", "TECHNOLOGY", 1L)
        );
            row("key05", 3,    7.0),
            row("key01", "e",  null, 1L),
            "source=" + DATASET.indexName + " | sort key"
     *  RexSubQuery becomes a decorrelated correlate. This historically hit a nondeterministic
    /** sql IT: testStreamstatsCurrent. {@code current=false} → frame is N-1 preceding to 1 PRECEDING.
     *  "this PPL form is not yet supported". */
    /** {@code streamstats … by str0} on a 3-shard index. Pre-fix this crashed with
 *       — not in {@link org.opensearch.analytics.spi.WindowFunction} enum.</li>
            row("key06", 8,    3.304037933599835),
                + " | fields key, str0, int0, cnt"
        assertRowsEqual(response,
            "source=" + DATASET.indexName + " | sort key"
            }
        assertRowsEqualList(response, EXPECTED_GLOBAL_TRUE_ROWS);
            row("key11", "TECHNOLOGY",      12L, 13, 46L),
            row("key11", "TECHNOLOGY",      10,   7.0),
            row("key14", "TECHNOLOGY", 3L),
     *  (8 rows). Pairs with {@link #testStreamstatsBySpanWithNull} which uses
        // TECHNOLOGY: [null, 8, 4, 10, null, 4, 11, 4, 8] → null, 8, 6, 7, 10, 4, 7.5, 7.5, 6
            row("key16", 8,    7.5)
    private final void assertRowsEqual(Map<String, Object> response, List<Object>... expected) {
    }
            row("key07", null, 4.75),
    // ── global / reset — uses self-join lowering, not RexOver ─────────────────
            row("key03", "e",  null, 4L,  1.0,                1,    1),
            row("key07", "e",  null, 3.5,                4.949747468305833,  12.25,              24.5),
