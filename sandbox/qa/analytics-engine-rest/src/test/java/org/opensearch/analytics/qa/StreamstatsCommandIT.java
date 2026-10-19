            row("key03", "e",  null, 4L,  1.0,                1,    1),
            row("key04", 7,    5L,  4.0,                 1, 7),
            row("key11", 10,   2.996596709057576,   3.236694374850748,  8.979591836734695,  10.476190476190476),  
            row("key09", 8,    3.209361307176242),
            row("key05", 3,    6L,  3.5),
            row("key08", 9L,  10, 54L),
    /** sql IT: testWhereInWithStreamstatsSubquery. WHERE-IN with streamstats subquery — uses
            row("key03", 4L,  5,  14L),
 *
        Map<String, Object> response = executePpl(
            row("key07", null, 5.5),   // window={3,8,null}  
            row("key14", "e",  1L),
        Map<String, Object> response = executePpl(  
            row("key07", null, 8L,  7.0),  
                + " | eventstats max(cnt) as max_cnt"  
            row("key03", null, 1.0),
    /** Per-row {@code window=2} running average of {@code int0} over the calcs dataset, computed  
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {
            row("key10", "e",  1L),
            row("key02", null, 1.0),
        Request request = new Request("POST", "/_plugins/_ppl");
    // DataFusion's built-in approx_distinct (HyperLogLog). streamstats applies the aggregate
            row("key16", 8,    6.0)
            row(1L, "OFFICE SUPPLIES"),
            "source=" + DATASET.indexName + " | sort key"
     *  NaN as a string in JSON arrays). */
                + " | streamstats sum(x) as sx"
        assertRowsEqual(
                + " | streamstats current=false window=2 avg(int0) as avg"
            row("key14", 11,   15L, 14.0),
        row("key05", "OFFICE SUPPLIES", 3,    5.0),
            "source=" + DATASET.indexName + " | sort key"  
            row("key01", null, 1.0),  
                + " | fields key, int0, prev_avg"  
            row("key15", "e",  4,    5L),
                + " | sort key | fields key"
            row("key08", null, 8.0),
            row(2L, "FURNITURE"),  
     * not span the boundary. Lowering: {@code buildStreamWindowJoinPlan} (Correlate +
    }  
                + " | fields key, int0, avg"  
    /** sql IT: testStreamstatsWindow. {@code window=3} → frame is 2 PRECEDING TO CURRENT ROW.
            row("key01", null, 2L,  1.5),  
        );  
            "source=" + DATASET.indexName + " | sort key"
    /** sql IT: testStreamstatsVarianceBy. Per-partition running variance. NaN until 2+ non-null  
            row("key15", 4,    6.222222222222222),  
            row("key08", null, 8.0),   // window={8,null,null}
            row("key14", "TECHNOLOGY",      11,   2L),  
            row("key04", 7,    5L,  17L),
            row("key11", "TECHNOLOGY",      12L, 13, 46L),
            row("key12", null, 13L, 17L),
        );  
                + " avg(int0) as avg by str0"
            List<Object> got = actualRows.get(i);
        );
    // ── Unsupported window functions ───────────────────────────────────────────
            row("key06", 8,    4.75),  
        }  
 * 4-row STATE_COUNTRY index.
            row("key04", 7,    7.0),
     *  7 nulls). */  
            row("key08", null, null, 2.0,                2.8284271247461903, 4.0,                8.0),
            row("key06", "e",  8,    3.5,                4.949747468305833,  12.25,              24.5),
            row("key08", null, null, 1L),
        assertRowsEqual(
            assertTrue(  
            row("key02", null, 3L,  1.0,                 1, 1),
        Map<String, Object> response = executePpl(  
            row("key14", 11,   2L, 10.5,               10,   11),
            row("key03", "e",  1L),
    public void testStreamstatsVariance() throws IOException {
            row("key07", "e",  1L),
            row("key10", 4,    5.4),
            row("key00", "e",  1,    1L,  1.0,                1,    1),
    }
    }
            row("key03", null, 4L,  2.5),
    public void testStreamstatsAndEventstats() throws IOException {
            row("key11", 2,  10,   8L, 5.8,                1,    10),
        assertRowsEqual(response,
     *  gets its own running 1..N). eval x=cnt+1. Second streamstats sum(x) by str0  
                + " | streamstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs"
            row("key12", null, 7.0),   // {4,10,null}
            row("key06", 18, 8,    2L, 8.0,                8,    8),
            row("key05", null, 3,    2.0,                2.8284271247461903, 4.0,                8.0),
        );  
        row("key11", "TECHNOLOGY",      10,   7.0),
            row("key00", 1,    1L, 1.0,                1,    1),  
        );
            row("key09", 8,    5.4),  
        assertEquals("Expected " + expected.length + " columns", expected.length, got.size());
            row("key15", "TECHNOLOGY",      4,    8L, 6.833333333333333,   4,    11),
    /** sql IT: testStreamstatsCurrentWithNUll. Same query as {@link #testStreamstatsCurrent} —  
            row("key13", 4,    2.8695600708122493,  3.0676887530703447, 8.234375,           9.410714285714286),  
            row("key08", null, 5L, null,               null, null),
    public void testStreamstatsVarianceBySpan() throws IOException {
            row("key01", null, 2L,  1.0,                 1, 1),
 *       before substrait emission. The {@code bySpan} cases assert exact per-bucket rows.</li>  
            row("key01", "FURNITURE",       null, 1.0),  
                + " | eval x = cnt + 1"  
    }
        );  
            row("key09", "e",  1L),
            row("key08", 17, null, 3L, 8.0,                8,    8),
            row("key02", null, 1.0),
     *  Streamstats does not gather rows from the same partition together — it sees them in  
    }  
            row("key04", "OFFICE SUPPLIES", 7,    7.0),  
            row("key15", "e",  1L),
            "source=" + DATASET.indexName + " | sort key"
        assertRowsEqualList(response, Arrays.asList(expected));
    public void testStreamstatsCurrent() throws IOException {  
    /** sql IT: testStreamstatsByWithNullBucket. {@code bucket_nullable=false} drops the
            row("key02", "e",  null, 0.0,                (Double) null,         0.0,                (Double) null),
            row("key02", "e",  null, 3L,   1.0,               1,    1),
            row("key11", 10,   5.857142857142857),
            row("key16", 8,    17L, 9.0)  
 *       column via {@code ROW_NUMBER() OVER ()} (now in our enum), then per-partition running
    // ── streamstats … by ───────────────────────────────────────────────────────
            row("key12", "TECHNOLOGY",      null, 5L, 7.333333333333333,   4,    10),
        }  
            row("key11", "TECHNOLOGY", 1L),
        Map<String, Object> response = executePpl(
            row("key01", "FURNITURE",       2L,  3,  5L),  
        row("key03", "OFFICE SUPPLIES", null, null),  
            "source=" + DATASET.indexName + " | sort key"  
    public void testStreamstatsVarianceWithNullBy() throws IOException {
        Map<String, Object> response = executePpl(  
                + " | fields key, str3, int0, cnt"  
            row("key07", "OFFICE SUPPLIES", 2L),
        );
            row("key15", 4,    7.5),
        assertNotNull("Response missing 'rows'", actualRows);
                + " | fields key, int0, prev_avg"
        assertEquals(message, expected, actual);
            row("key09", 8,    5L, 5.4,                1,    8),  
                + " | streamstats count() as cnt by span(int0, 10), str3"
            row("key08", null, null, null, null,              null, null),
     *  dataset, sorted by key. See {@link #testStreamstatsReset} javadoc for the segId mapping. */
                assertCellEquals("Cell mismatch at row " + i + ", col " + j, want.get(j), got.get(j));
        );
            row("key01", "e",  null, 1L),
            row("key09", "e",  1L),
     *  int0 seen in the partition; null until 1+ non-null seen. */
        row("key16", "TECHNOLOGY",      8,    6.0)
        );
            row("key03", null, 0.0,                 (Double) null,         0.0,                (Double) null),
    /** sql IT: testStreamstatsByMultiplePartitionsWithNull2. Same query as  
            row("key03", "OFFICE SUPPLIES", 1L),  
            row("key13", "TECHNOLOGY", 1L),
            row("key10", "TECHNOLOGY",      4,    3L, 6.0,                 4,    8),  
 *       CalciteRelNodeVisitor#buildStreamWindowJoinPlan}). Not reachable on analytics-engine.</li>
            row("key13", null, 4,    null, null,              null, null),
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
    //
        );
        assertNotNull("Response missing 'rows'", rows);
    }
    private static void assertScalarRow(Map<String, Object> response, Object... expected) {
            Response response = client().performRequest(request);  
            row("key15", "TECHNOLOGY",      4,    2.967415635794142,   3.250640962435972,  8.805555555555552,  10.566666666666663),  
                + " | fields key, int0, avg3"
                + " | fields key, int0, avg"
     * + {@code window=0} → running average over rows with the same {@code (str0, segId)} and
            row("key09", "TECHNOLOGY",      8,    2L, 8.0,                 8,    8),
            row("key03", "e",  null, 0.0,                (Double) null,         0.0,                (Double) null),
        );
            row("key15", 4,    6.333333333333333),  // {4,11,4}
     *  Null-key rows form their own running partition and accumulate count() but  
            row("key02", null, 3L,  2.0),
    @Override
    public void testStreamstatsWindowWithNull() throws IOException {  
    public void testStreamstatsDistinctCountByCountry_3shard() throws IOException {
            row("key14", 11,   6.222222222222222),
    }
            row("key10", 4,    11L, 5.166666666666667,   1, 8),
            row("key10", 4,    6.0),
 * <p>Mirrors {@code CalciteStreamstatsCommandIT} from the {@code opensearch-project/sql}
            row("key05", null, 3,    2L),
                + " | fields key, int0, sp, ss, vp, vs"
        assertRowsEqual(response,  
 * this file be licensed under the Apache-2.0 license or a
        row("key13", "TECHNOLOGY",      4,    4.0),
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");  
     *  stays inside one group — making the {@code global=true} output identical to {@code  
     *  multi-node race ({@code Stage 0 sink feed failed: partition stream receiver dropped before
            row("key05", null, 3,    null, null,              null, null),
     * {@code streamstats reset_before=…} segments rows by seq position: each row where the
        assertRowsEqual(response,
    }
    /** sql IT: testStreamstatsCurrent. {@code current=false} → frame is N-1 preceding to 1 PRECEDING.
            "source=" + DATASET.indexName + " | sort key"
     *  by hand and shared by the two {@code global=true} cases. Frame is {@code rightSeq IN
            "source=" + DATASET.indexName + " | sort key"  
 *  
            "source=" + DATASET.indexName + " | sort key"  
        );  
            row("key06", 8,    6.0),   // window={7,3,8}
import org.opensearch.client.ResponseException;  
            row("key03", null, 4L,  2.5),
     *  per-partition. */  
        assertRowsEqualList(response, EXPECTED_RESET_ROWS);
            row("key01", 13, null, 1L, null,               null, null),  
            row("key16", 8,    17L, 9.0)
     *  skipped). HLL is exact at calcs's scale so {@code max(dc_str3)} matches single-shard. */  
        );
    public void testStreamstatsBigWindow() throws IOException {
    /** sql IT: testStreamstatsByWithNull. Default {@code bucket_nullable=true} mode — null-key
     *  execution path was fixed (multi-input backend selection in {@code PlanForker} and the  
        );
            row("key16", 8,    17L, 17L)
        );  
            row("key06", 8,    4L, 4.75,               1,    8),  
        if (dataProvisioned == false) {  
        row("key06", "OFFICE SUPPLIES", 8,    5.5),  
            row("key03", 5,  null, 3L, 1.0,                1,    1),
     *  streamstats sum(x) running. */
     *  {@link #testStreamstatsByMultiplePartitions1}. */
            row("key12", null, 1L),
    public void testStreamstatsByMultiplePartitions2() throws IOException {
            double a = ((Number) actual).doubleValue();
            row("key05", "OFFICE SUPPLIES", 3,    2.0,                 2.8284271247461903, 4.0,                8.0),
        );
            row("key04", 7,    3.0,                 4.242640687119285,  9.0,                18.0),  
            row("key00", 1,    1.0),  
            "source=" + DATASET.indexName + " | sort key"
 *   <li>{@code testLeftJoinWithStreamstats} — streamstats inside a left-join, not exercised on  
            row("key09", "e",  8,    3.299831645537222,  4.041451884327381,  10.888888888888891, 16.333333333333336),
     *  running cnt. */
            row("key00", "FURNITURE",       1,    1L, 1.0,                 1,    1),
    }
            row("key14", 11,   4.0),
        }
                + " | streamstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs"  
        assertEquals("Row count mismatch", expected.size(), actualRows.size());
        row("key04", "OFFICE SUPPLIES", 7,    7.0),
    }
            row("key08", "TECHNOLOGY",      null, 1L),  
    private static final List<List<Object>> EXPECTED_GLOBAL_TRUE_ROWS = List.of(
            row("key01", "FURNITURE", 1L),
            row("key01", null, 2L,  1.5),  
    /** sql IT: testStreamstatsVarianceBySpan. Per-row running stddev_samp partitioned by
            row("key12", null, 13L, 7.0),
    /** sql IT: testMultipleStreamstatsWithEval2. Streamstats with eval and a partition-key
            row("key14", 11,   5.625),  
            row("key14", "TECHNOLOGY",      11,   7.5),
 *
            row("key03", "e",  1L),
            fail("Expected query [" + ppl + "] to fail but got: " + body);
                + " | left join on key=key right=" + DATASET.indexName
     *  calcs already has int0 nulls covered. */
public class StreamstatsCommandIT extends AnalyticsRestTestCase {
 * repository one-to-one — every {@code @Test} method here corresponds to a method of the same
    public void testStreamstatsCurrentAndWindowWithNull() throws IOException {
            row("key14", "e",  11,   9L,  6.4,                1,    11),
            row("key13", 4,    2.8695600708122493,  3.0676887530703447, 8.234375,           9.410714285714286),
    // and the DataFusion plugin's approx_count_distinct wrapper UDAF aliases that name to  
        );
     *  At each row, prev_avg = avg of int0 over all preceding rows (excluding current). */
            row("key04", 7,    1.0),
            row("key12", null, null, 2L),
            row("key03", "OFFICE SUPPLIES", null, null,                null,               null,               null),  
        List<Object> got = rows.get(0);  
    private void assertErrorAny(String ppl) throws IOException {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    /** {@code bucket_nullable=false} excludes null group-keys from aggregation. Calcs has no
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
    // ── streamstats composed with other commands ──────────────────────────────
     *  send}) so the assertion was the tolerant {@code assertErrorAny}. The decorrelated-correlate
                + " | fields key, int0, cnt"  
        );
        assertRowsEqual(response,
                + " | streamstats bucket_nullable=false reset_before=(int0 > 5)"  
     *  the input row order, so e.g. OFFICE SUPPLIES rows {key02..key05, key07, key09} appear
            row("key13", 4,    14L),  
            row("key06", 8,    3.304037933599835),
                + " | streamstats count(), avg(int0), min(int0), max(int0),"
            row("key09", 8,    8.0),   // window={null,null,8}
            row("key09", "TECHNOLOGY", 1L),  
            row("key12", null, 6L, null,               null, null),  
            row("key02", "e",  1L),
            row("key00", 1,    null),  
    // ── Variance / stddev (running) ────────────────────────────────────────────
        );
        assertRowsEqual(
        Map<String, Object> response = executePpl(
            "source=" + DATASET.indexName + " | sort key | streamstats dc(str3) as dc_str3 | fields key, str3, dc_str3"  
     *  {@link #testMultipleStreamstats}. */
    // distinct non-null values seen so far in the partition. At calcs's scale (low cardinality)  
                + " | fields key, int0, cnt, avg_cnt"
        assertRowsEqual(response,
    }
        assertRowsEqualList(response, EXPECTED_RESET_ROWS);
            row("key11", "TECHNOLOGY",      10,   2.4944382578492936,  3.0550504633038926, 6.222222222222219,  9.333333333333329),
        assertRowsEqual(response,  
                "Query [" + ppl + "] expected error containing [" + expectedSubstring + "] but body was: " + body,
        Map<String, Object> response = executePpl(
            row("key08", "TECHNOLOGY",      null, null),
        );  
    }
            row("key05", null, 3,    2L,  5.0,                3,    7),
     * segment-id filter), which became reachable on the analytics-engine route after theta-join
            row("key16", 8,    7.5)
            row("key10", 4,    11L, 10.0),  
     *  count is deterministic: rows with {@code cnt < 5} are the first four keys (key00..key03).
            row("key05", 6L,  7,  27L),
            row("key09", 10L, 11, 65L),
    }
            response,
        );
 * <p>Streamstats running aggregates depend on row-order. Calcs has 17 rows; without an explicit
        );
            row("key14", "e",  11,   1L),
            row("key16", null, 8,    null, null,              null, null)
            row("key08", null, 9L,  5.0),
 */
        row("key04", "OFFICE SUPPLIES", 7,    7.0),
            row("key05", "OFFICE SUPPLIES", 3,    5.0),
            row("key02", "OFFICE SUPPLIES", null, 1L, null,                null, null),
        );
            "source=" + DATASET.indexName + " | streamstats percentile_approx(int0)",
            row("key01", "FURNITURE", 1L),
        Map<String, Object> r1 = executePpl(
 * before the streamstats step. This differs from the sql IT which trusts ingestion order on a
        );
            row("key01", null, 1.0),
            row("key10", 4,    8.0),  
     *  but this QA module only ships the {@code calcs} dataset (whose {@code str3} already has
            "source=" + DATASET.indexName + " | sort key | streamstats dc(str3) as dc_str3 | fields key, str3, dc_str3"
        assertEquals("Expected exactly one row", 1, rows.size());
    private static boolean multiProvisioned = false;
            assertEquals("Column count mismatch at row " + i, want.size(), got.size());  
     *  over int0. Each row carries the running value at its position (NaN for samp variants
        Map<String, Object> response = executePpl(
            row("key11", null, 1L),  
            row("key10", "TECHNOLOGY",      11L, 12, 33L),  
            row("key04", "OFFICE SUPPLIES", 7,    1L),
        Map<String, Object> response = executePpl(
 */  
                + " | streamstats window=100 avg(int0) as avg"
 * <ul>  
            row("key07", null, 4.75),
    }  
            row("key12", null, 2.996596709057576,   3.236694374850748,  8.979591836734695,  10.476190476190476),
     *  global=false} on this data. Both null bucket variants behave the same here because no
 *       — not in {@link org.opensearch.analytics.spi.WindowFunction} enum.</li>
            row("key02", "e",  null, 3L,  1.0,                1,    1),
            row("key02", null, 1.0),
            row("key09", "e",  8,    7L,   5.666666666666667, 1,    8),  
 *
    /** sql IT: testMultipleStreamstatsWithEval. Streamstats running cnt → eval x=cnt+1 →  
                + " | streamstats window=3 avg(int0) as avg3"
        Map<String, Object> response = executePpl(
        assertErrorContains(
            "source=" + DATASET.indexName + " | where key = 'non-existed'"  
            row("key10", "e",  4,    8L,  5.25,               1,    8),  
            row("key05", 3,    4.0),  
            row("key00", "e",  1L),
    }  
            "source=" + DATASET.indexName + " | sort key"
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str0"
            row("key02", 2,  null, 2L, 1.0,                1,    1),
 *       until the downstream race is closed.</li>
        assertRowsEqual(response,  
import java.util.Arrays;  
            row("key14", "TECHNOLOGY", 3L),  
            row("key07", "e",  null, 4L),  
    );  
    /** {@code streamstats … by str0} on a 3-shard index. Pre-fix this crashed with
            "source=" + DATASET.indexName + " | sort key"
            row("key08", "TECHNOLOGY",      null, 1L, null,                null, null),
            row("key06", 8,    2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
        );  
            row("key08", null, 4.75),
            fail("Expected query [" + ppl + "] to fail with [" + expectedSubstring + "] but got: " + body);
    public void testStreamstatsByMultiplePartitions1() throws IOException {  
            row("key11", 10,   12L, 11.0),
            }
            row("key13", null, 4,    2.7386127875258306, 3.1622776601683795, 7.5,                10.0),  
            row("key13", 4,    10.0),
            row("key10", 4,    6.0),   // window={null,8,4}  
    /** Same data shape as {@link #testStreamstatsGlobalWithNull} — see the comment there for the  
        // analytics-engine likely rejects the streamstats-in-subsearch shape.
                + " | streamstats current=false avg(int0) as prev_avg"
        assertRowsEqual(
            "source=" + DATASET.indexName + " | sort key"  
            row("key04", 5L,  6,  20L),  
                + " | streamstats count() as cnt"  
     */
            row("key12", null, 1L),
        assertRowsEqual(response,
    /** sql IT: testStreamstatsDistinctCountByCountry. Per-partition running dc(str3).
        );
        );
            row("key13", 4,    14L, 5.625,               1, 10),
            row("key13", "TECHNOLOGY",      4,    3L),
    /** sql IT: testStreamstatsVarianceWithNull. Same query as
            row("key02", null, 1.0),  
    /** sql IT: testMultipleStreamstats. Two chained streamstats — first running count, then  
        Map<String, Object> response = executePpl(
    public void testStreamstatsGlobal() throws IOException {  
            row("key15", 4,    2.5319388392523003),
    /** sql IT: testStreamstatsWindowError. window=-1 must be a parse-time / argument-validation
    /** sql IT: testStreamstatsDistinctCountWithNull. Same shape as  
            row("key12", "TECHNOLOGY", 1L),  
    private static void assertRowCount(Map<String, Object> response, int expected) {
 *       aggregate. Cost gate gathers, WindowAggExec runs.</li>  
    }
        }
    // calcs.str3 is "e" on every non-null row → dc_str3 stays at 1 once the first non-null is  
        assertErrorAny(
    }  
        assertEquals("Row count mismatch", expected, rows.size());
                + " | fields key, str0, int0, avg"
     *  avg/min/max stay NULL since there are no non-null int0 values to consume. */
 * SPDX-License-Identifier: Apache-2.0
            row("key08", "TECHNOLOGY", 3L),  
        row("key09", "TECHNOLOGY",      8,    8.0),  
            row("key05", "OFFICE SUPPLIES", 3,    2L),  
            "source=" + DATASET.indexName + " | sort key"
        );
     *  "this PPL form is not yet supported". */
            row("key00", 1,    1.0),
    }
    public void testStreamstatsBySpanWithNull() throws IOException {
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
            row("key04", 7,    3.0,                 4.242640687119285,  9.0,                18.0),
        Map<String, Object> response = executePpl(  
        assertRowsEqual(response,
            row("key10", 11, 4,    4L, 6.0,                4,    8),  
            row("key03", null, null),
        Map<String, Object> response = executePpl(  
            row("key05", 3,    5.0),   // window={null,7,3}
            row("key07", null, 5.5),
            row("key08", null, 1L),
            row("key01", null, 1.0),
        );
            row("key13", 4,    7.0),
    public void testStreamstatsBy_3shard() throws IOException {
            row("key09", 8,    10L, 5.5),
            row("key15", "TECHNOLOGY",      4,    4L),
            row("key03", "OFFICE SUPPLIES", 2L),
            row("key04", null, 7,    0.0,                (Double) null,         0.0,                (Double) null),  
            row("key07", "e",  null, 6L,   4.5,               1,    8),
            row("key07", null, 8L,  7.0),  
            row("key15", 16L, 17, 152L),
     *  join and streamstats together. The join shape uses lowering paths (LogicalJoin) that  
    @SuppressWarnings({"unchecked", "varargs"})
            row("key01", 2L,  3,  5L),  
            row("key10", 4,    2.926886855802026),  
            row("key00", "FURNITURE",       1,    0.0,                 (Double) null,         0.0,                (Double) null),  
            row("key01", "FURNITURE",       null, 1L),
    }
            row("key00", 1,    0.0,                 (Double) null,         0.0,                (Double) null),
            row("key14", 11,   4.0),
        assertErrorContains(
            row("key11", "TECHNOLOGY",      10,   1L),  
            row(9L, "TECHNOLOGY")
            row("key16", "TECHNOLOGY", 1L)
        );
            row("key04", null, 1L),
        assertRowsEqual(response,
            "source=" + DATASET.indexName + " | streamstats window=-1 avg(int0) as avg",  
            row("key16", 8,    2.5873624493766703)  
    /** sql IT: testStreamstatsBigWindow. {@code window=100} exceeds row count; effectively  
            row("key02", 3L,  4,  9L),
    protected void onBeforeQuery() throws IOException {
     *  may change as more analytics-engine functionality lands). The contract here is just  
            row("key00", "e",  1,    1L),  
        Map<String, Object> response = executePpl(
     *  calcs already has int0 nulls covered. */
            row("key07", null, 4.75),
            "source=" + DATASET.indexName + " | sort key"
    public void testStreamstatsDistinctCountFunction() throws IOException {  
            row("key10", 4,    5.166666666666667),
            row("key06", 8,    5.0),
            dataProvisioned = true;
        assertRowsEqual(response,
     *  produces per-partition running sum of (cnt+1) within the same partition. */
    }
    // that order (sorted by key), so dc_str0 walks 1 → 2 → 3.
        assertRowsEqual(response,
        );  
            row("key16", "TECHNOLOGY",      8,    6.0)  
        );
     *  running aggregate at its position within the partition (rows ordered by key).
            row("key06", 8,    7L,  4.0),
 *       conditional aggregate, doesn't flow through RexOver at all (see {@code
    }
        assertRowsEqual(response,
        Map<String, Object> response = executePpl(
        );  
            row("key01", null, 2L,  17L),
            response,
            row("key07", "OFFICE SUPPLIES", null, 6L, 6.0,                 3,    8),  
        );
import org.opensearch.client.Request;
    /** sql IT: testStreamstatsCurrentAndWindowWithNull. Same query as
 *   <li><b>{@code streamstats window=N}</b> — frame is {@code ROWS N-1 PRECEDING TO CURRENT ROW}.  
            row("key02", null, 1.0),
            row("key12", null, 7.0),  
    public void testStreamstatsByMultiplePartitionsWithNull1() throws IOException {  
            row("key11", 10,   6.0),
/**
            "source=" + DATASET.indexName + " | sort key"  
        assertRowsEqual(response,
            row("key05", 3,    3.6666666666666665),
 * not yet wired through the analytics-engine route are {@code expectThrows} negative tests
        assertRowsEqualList(response, EXPECTED_GLOBAL_TRUE_ROWS);  
                + " | streamstats count() as cnt"
            row("key14", "e",  11,   1L),
 *   <li><b>Plain {@code streamstats <agg>}</b> (no by, no current, no window, no reset, no global) —
            row("key09", 8,    10L, 17L),
            row("key13", 18, 4,    6L, 5.333333333333333,  4,    8),  
            row("key13", "TECHNOLOGY",      4,    6L, 6.5,                 4,    10),  
        if (multiProvisioned == false) {
    }
            row("key14", 11,   7.5),   // {null,4,11}
    @SuppressWarnings("unchecked")
 * <h2>Note on row order determinism</h2>
            row("key11", null, 10,   1L),
            row("key06", "e",  8,    2L),  
        Map<String, Object> response = executePpl(  
 * <h2>What works on the analytics-engine route after #21668 + this PR's PARTITION BY relaxation</h2>
            row("key01", "FURNITURE",       null, 0.0,                 (Double) null,         0.0,                (Double) null),
            if (Math.abs(e - a) > 1e-9 * Math.max(Math.abs(e), 1.0)) {  
        Map<String, Object> response = executePpl(
        assertRowsEqualList(response, EXPECTED_RESET_ROWS);
        Map<String, Object> response = executePpl(
                + " | streamstats count() as cnt"
     *  row including int0 nulls; avg/min/max ignore them. */
        );  
    public void testStreamstatsAndSort() throws IOException {
 * starts with {@code | sort key} (the unique row id) to pin output to a deterministic order  
 * sort, DataFusion's parallel scan can return rows in any order. Every reachable test below
        );  
            "source=" + DATASET.indexName + " | where key in"
     *  reason this matches {@code testStreamstatsGlobal}. {@code bucket_nullable=false} only
    private static void assertCellEquals(String message, Object expected, Object actual) {
            row("key10", "TECHNOLOGY",      4,    2L),
    }
        Map<String, Object> response = executePpl(
            row("key00", 1L,  2,  2L),
            row("key08", null, null),
            row("key16", 8,    7.666666666666667)
    /** sql IT: testStreamstatsByMultiplePartitions2. {@code by span(int0, 10), str3}. */  
            row("key14", 11,   3.189488909868294,   3.3829638550307397, 10.172839506172838, 11.444444444444443),  
    public void testStreamstatsResetWithNullBucket() throws IOException {  
     *  row has a null {@code str0}. */
            row("key08", "TECHNOLOGY",      9L,  10, 10L),
    // ── Helpers ────────────────────────────────────────────────────────────────
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
            row("key03", null, null),
     *  ordered row set — this asserts real content end-to-end, not just that the query ran. */
            row("key11", 10,   5.166666666666667),
        row("key11", "TECHNOLOGY",      10,   10.0),  
    public void testStreamstatsByMultiplePartitionsWithNull2() throws IOException {
            row("key00", 1,    1.0),
            row("key07", "OFFICE SUPPLIES", null, 3L),
    @SafeVarargs
                + " | fields key, int0, avg3"
            row("key08", null, 9L,  4.75,                1, 8),
            row("key10", 4,    11L, 10.0),  
            row("key01", "FURNITURE",       null, 2L, 1.0,                 1,    1),  
                + " | fields key, int0, cnt, avg_cnt"
     *  running avg over those counts. At row N, cnt=N and avg_cnt = (N+1)/2. */
    }  
                + " | streamstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs by str3"
     *  RexSubQuery becomes a decorrelated correlate. This historically hit a nondeterministic  
    /** sql IT: testStreamstatsVariance. Running stddev_pop / stddev_samp / var_pop / var_samp
            row("key15", 4,    16L, 8.5),
                + " | streamstats window=3 avg(cnt) as avg_cnt"
                + " | streamstats window=2 global=false avg(int0) as avg by str0"  
        );
            row("key13", "TECHNOLOGY",      4,    3L),
            row("key15", 4,    6.0),  
            row("key11", "TECHNOLOGY",      10,   4L, 7.333333333333333,   4,    10),
            row("key05", 3,    7.0),
            row("key15", 4,    7.5),  
            row("key07", "OFFICE SUPPLIES", null, 2.160246899469287,   2.6457513110645907, 4.666666666666667,  7.0),
        if (expected instanceof Number && actual instanceof Number) {  
            "source=" + DATASET.indexName + " | where key = 'non-existed'"
                + " | stats max(cnt) as final_cnt by str0 | sort str0"  
            row("key12", null, 7.0),
        row("key02", "OFFICE SUPPLIES", null, null),  
            row("key09", "TECHNOLOGY",      8,    1L),
            row("key12", 13L, 14, 104L),
 * </ul>  
     *  (each {@code str0} group has only the value "e" or null in {@code str3}; null is
            "source=" + DATASET.indexName + " | sort key"
            row("key01", "e",  null, 2L,  1.0,                1,    1),  
     *  {@code span(int0, 10)}. NaN at 1-element partitions; null until 1+ non-null seen. */  
            row("key11", "TECHNOLOGY", 3L),  
            row("key04", 7,    5L,  3.0),
 *       gate forces SINGLETON gather, WindowAggExec runs running-aggregate on coordinator.</li>  
            row("key07", null, 8L,  4.5),
            row("key03", "OFFICE SUPPLIES", null, 2L, null,                null, null),
            "source=" + DATASET.indexName + " | sort key"
    }
            row("key08", null, 2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
            row("key12", "TECHNOLOGY",      null, 2L),
        );
            row("key08", null, 2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),  
        row("key10", "TECHNOLOGY",      4,    6.0),
            String body;  
            row("key01", "e",  1L),  
            row("key13", 4,    14L, 13.0),  
     *  — same shape as {@link #testStreamstatsBy_3shard}. The final dc per partition is 1
                + " | fields key, int0, cnt, max_cnt"
            row("key01", null, 1.0),
            row("key16", "TECHNOLOGY",      8,    9L, 7.0,                 4,    11)  
            row("key10", 4,    11L, 6.0),
            row("key14", "TECHNOLOGY",      15L, 16, 91L),
            "percentile_approx"
    /** sql IT: testStreamstatsCurrentAndWindow. {@code current=false window=2} → frame is
        );  
    }
                + " | fields key, str3, int0, cnt"
            row("key16", null, 1L)  
            row("key09", "TECHNOLOGY",      8,    0.0,                 (Double) null,         0.0,                (Double) null),  
            row("key12", null, 2.996596709057576,   3.236694374850748,  8.979591836734695,  10.476190476190476),
        for (int i = 0; i < expected.size(); i++) {  
            row("key06", 7L,  8,  35L),
 * <h2>Schema translation</h2>
            row("key02", "OFFICE SUPPLIES", 3L,  4,  4L),
     *  + 10 'e' rows; companion to {@link #testStreamstatsByWithNullBucket}. */  
            row("key07", "e",  1L),  
            row("key13", "TECHNOLOGY", 3L),
        row("key16", "TECHNOLOGY",      8,    8.0)
            row("key01", "e",  1L),
            row("key06", 8,    6.0),
        );
     *  avg of int0 over those 2 prior rows. */
            row("key05", "OFFICE SUPPLIES", 1L),
 *       into RexOver.window.partitionKeys, letting SpanAdapter rewrite SPAN's NULL operand
            row("key11", null, 10,   1L),
    }
     *  coordinator out of key order, so per-row running values are not deterministic.
     *  multi-leaf {@code OpenSearchStageInputScan} schema resolution in
            row("key16", 8,    17L),  
    public void testStreamstatsEmptyRows() throws IOException {
            "source=" + DATASET.indexName + " | sort key"
            row("key02", null, 3L,  2.0),  
                + " | fields key, cnt, x, sx"
            row("key10", "TECHNOLOGY",      4,    2.0,                 2.8284271247461903, 4.0,                8.0),
            row("key13", "TECHNOLOGY",      14L, 15, 75L),  
 *   <li>{@code streamstats global=true window=N by …} — uses self-join lowering, also not RexOver.</li>  
            row("key06", "e",  1L),
    }
    }  
     *  the 2 rows immediately before current (excluding current itself). avg per row =  
            row("key06", 8,    5.0),  
            row("key13", 4,    5.857142857142857),
    /** sql IT: testUnsupportedWindowFunctions. */
    // ── global / reset — uses self-join lowering, not RexOver ─────────────────
            row("key09", 8,    4.75),
                + " | fields key, str0, int0, cnt, avg, mn, mx"
            row("key00", 1,    null),
            row("key05", 3,    6L,  5.0),
            response,  
            row("key11", 10,   2.996596709057576,   3.236694374850748,  8.979591836734695,  10.476190476190476),
 * Self-contained integration test for PPL {@code streamstats} on the analytics-engine route.
     *  {@code span(int0, 10)} reintroducing the null bucket. */  
            row("key16", null, 8,    7L,  6.4,                3,    10)  
        );
                + " | fields key, int0, ss"
            row("key12", null, 13L, 12.0),
    private static List<Object> row(Object... values) {  
    }  
        Map<String, Object> response = executePpl(  
            row("key15", 4,    6.333333333333333),
            row("key13", 4,    7.0),   // {10,null,4}  
        row("key09", "TECHNOLOGY",      8,    8.0),
            row("key00", 1,    1L,  1.0),
            row("key08", null, 8.0),  
    }
    /** sql IT: testStreamstatsGlobal. {@code global=false} with {@code window=2 by str0} is the  
            row("key10", "TECHNOLOGY", 3L),
            row("key04", "OFFICE SUPPLIES", 7,    3L, 7.0,                 7,    7),  
            row("key15", 4,    16L, 17L),
        if (expected == null || actual == null) {  
        row("key08", "TECHNOLOGY",      null, null),
        Map<String, Object> response = executePpl(  
     *  in key order intermixed with FURNITURE/TECHNOLOGY rows but the running counter is
                + " | streamstats count() as cnt"
        for (int j = 0; j < expected.length; j++) {
            row("key00", "e",  1L),
     *  {@link #testStreamstatsByWithNull}; null-key rows now show NULL aggregates. */
        assertRowsEqual(response,
        );  
 * compatible open source license.
            row("key11", 10,   12L, 5.857142857142857,   1, 10),
            row("key13", null, 1L),  
            row("key05", 7,  3,    5L, 3.6666666666666665, 1,    7),
        Map<String, Object> response = executePpl(
            row("key11", 10,   (Double) null),
     *  
        assertRowsEqual(response,
            row("key02", "OFFICE SUPPLIES", null, null,                null,               null,               null),
    }  
            "source=" + DATASET.indexName + " | sort key | streamstats distinct_count(str0) as dc_str0 | fields key, str0, dc_str0"
            row("key11", null, 10,   2.867441755680875,  3.5118845842842457, 8.22222222222222,   12.333333333333329),
            row("key13", null, 4,    3L),
     *  null in {@code str0} so the output matches the bucket-nullable variant exactly. */
            row("key06", 8,    7L,  17L),
            row("key07", null, 8L,  4.75,                1, 8),
    }
            row("key01", "e",  null, 2L,   1.0,               1,    1),
        row("key08", "TECHNOLOGY",      null, null),  
            row("key06", "OFFICE SUPPLIES", 1L),  
        );
        row("key01", "FURNITURE",       null, 1.0),
    /** sql IT: testLeftJoinWithStreamstats. streamstats inside left join — exercises both
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
            row("key11", null, 1L),
     *  <p>The subquery sorts by {@code key} before {@code streamstats count()} so the running
        }
            row("key03", "OFFICE SUPPLIES", null, 2L),
            row("key11", 10,   6.0),
            row("key01", null, null),  
    @SuppressWarnings("unchecked")
 *  
            row("key13", 14L, 15, 119L),  
            row("key01", null, 2L,  1.5),  
            row("key14", "e",  11,   9L,   6.4,               1,    11),
        ensureMultiShardProvisioned();  
    public void testStreamstatsDistinctCount() throws IOException {
 * pinning the precise error message — failing those is how a future PR observes that they
        Map<String, Object> r2 = executePpl(  
            row("key08", "TECHNOLOGY", 0L),
        row("key12", "TECHNOLOGY",      null, 10.0),  
    }
     *  semi-join lowering inside the subquery. After PlannerImpl's subquery-remove phase the
            row("key07", "e",  null, 6L,  4.5,                1,    8),  
    private final void assertRowsEqual(Map<String, Object> response, List<Object>... expected) {  
            row("key03", null, null),  // window={null,null,null}, no non-null
                + " | eval x = cnt + 1"  
 * {@code state→str3}, {@code name→key}.  
            row("key11", 10,   1L, 10.0,               10,   10),
        );  
            return;
                + " | fields key, int0, avg"  
        assertRowCount(r1, 0);
        Map<String, Object> response = executePpl(  
        );  
            row("key13", 4,    5.625),
        );
                + " | fields key, str3, int0, cnt, avg, mn, mx"
            row("key13", "TECHNOLOGY",      4,    2.598076211353316,   3.0,                6.75,               9.0),
            row("key06", 8,    7L,  4.75,                1, 8),  
            row("key15", "TECHNOLOGY", 3L),
        );
            row("key05", "OFFICE SUPPLIES", 6L,  7,  22L),
 * name in the source IT. Reachable cases assert exact rows; cases that depend on functionality  
    }
import org.opensearch.client.Response;
            row("key13", 4,    14L, 13.0),  
                + " | fields key, str3, int0, cnt, avg, mn, mx"  
            row("key05", null, 1L),
            row("key13", 4,    10.0),  
            row("key09", 8,    10L, 5.4,                 1, 8),  
            row("key04", 7,    2L, 4.0,                1,    7),
     *  same pattern. */
        );
        Map<String, Object> response = executePpl(
                || "NaN".equals(actual))) {  
            row("key00", "FURNITURE",       1,    1L),
            row("key06", 8,    2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
     *  rows that contribute a non-null value. */
            row("key13", null, 4,    6L,  6.0,                3,    10),  
                + " | streamstats avg(cnt) as avg_cnt"
        assertRowsEqual(response,
    }
     *  which {@code OpenSearchJoinSplitRule} sends both sides through coord-singleton ERs and
        assertRowsEqual(response,
     *  OFFICE SUPPLIES (key02..07): "e","e","e",null,null,"e","e" → 1,1,1,1,1,1.  
            row("key06", "e",  8,    5L,   4.5,               1,    8),  
            row("key04", "OFFICE SUPPLIES", 2L),
        );
     *  "Field reference offset (27) must be less than number of fields in struct (27)" —
     *  DataFusion's NestedLoopJoinExec evaluates the frame predicate.
            row("key15", "TECHNOLOGY",      4,    4L),
            row("key15", "TECHNOLOGY",      4,    7.5),
                + " | streamstats count() as cnt"  
    public void testMultipleStreamstatsWithNull2() throws IOException {  
            row("key13", "TECHNOLOGY",      4,    4.0),  
            row("key02", null, 1.0),
            row("key12", null, 5.857142857142857),  
            row("key10", 4,    8.0),
     *  its own running variance over int0. */  
            row("key12", null, 13L, 5.857142857142857,   1, 10),  
                + " | streamstats count() as cnt"
    /** sql IT: testStreamstatsBySpanWithNull. Bucketing key has nulls — uses
    // ── Empty input ────────────────────────────────────────────────────────────
        );  
        // Test source uses BANK_TWO which we don't have. Use a self-join on calcs as a stand-in;
            row("key00", 1,    1L,  1.0),
        );
        row("key06", "OFFICE SUPPLIES", 8,    8.0),
        );
    private static boolean dataProvisioned = false;
            row("key02", null, 1.0),  
                + " | streamstats count(), avg(int0), min(int0), max(int0),"
            row("key07", 3,  null, 6L, 3.6666666666666665, 1,    7),  
        );
            row("key12", "TECHNOLOGY",      null, 2L),
    /** sql IT: testStreamstatsDistinctCountFunction. {@code distinct_count()} alias for dc. */
            row("key02", null, null),
            row("key16", 8,    3.009626428590336,   3.1565228279922772, 9.05785123966942,   9.963636363636363)
 *       Bounded frame, RexOver-shaped, passes through.</li>
 * <ul>
            row("key12", null, 13L, 12.0),
        // OFFICE SUPPLIES: [null, null, 7, 3, 8, null] → null, null, 7, 5, 5.5, 8
        row("key14", "TECHNOLOGY",      11,   11.0),  
            row("key15", "e",  4,    10L,  6.0,               1,    11),  
            row("key00", "e",  1,    1L,   1.0,               1,    1),  
            row("key16", "TECHNOLOGY", 3L)
            row("key07", 8L,  9,  44L),  
    }
            row("key07", null, 2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),  
            "source=" + DATASET.indexName + " | sort key | streamstats dc(str3) as dc_str3 by str0 | fields key, str0, dc_str3"
            row("key06", "OFFICE SUPPLIES", 7L,  8,  30L),
    /** sql IT: testStreamstatsAndSort. Streamstats then sort -key (descending). */  
            row("key09", 8,    10L, 5.5),
            row("key05", "OFFICE SUPPLIES", 2L),  
     *  Each row's avg covers up to 3 consecutive rows ending at current; null int0 ignored. */  
 * <h2>What fails (expectThrows)</h2>
    /** sql IT: testMultipleStreamstatsWithNull1. Same query as
     *  FURNITURE (key00..01): "e" both → 1, 1.
 *       PRECEDING}. Still a RexOver, still passes through.</li>
     *  rows form their own running partition and accumulate normally. {@code str3} has 7 nulls
            row("key10", 4,    2.6718699236469,     2.926886855802026,  7.13888888888889,   8.566666666666668),  
            "source=" + DATASET.indexName + " | streamstats count() as cnt"
        );  
    public void testStreamstatsBy() throws IOException {
        row("key02", "OFFICE SUPPLIES", null, null),
    /** sql IT: testStreamstatsBy. Per-partition running cnt/avg/min/max. Each row gets the
            row("key12", null, 5.857142857142857),  
 *   <li>{@code testWhereInWithStreamstatsSubquery} — reachable on the analytics-engine route via
        }
            row("key04", "OFFICE SUPPLIES", 7,    0.0,                 (Double) null,         0.0,                (Double) null),
        );
            row("key11", 10,   5.166666666666667),  
        Request request = new Request("POST", "/_plugins/_ppl");  
            row("key03", "OFFICE SUPPLIES", 4L,  5,  9L),
    // HLL is exact, so we can pin the exact running count.
     *  default-{@code @timestamp} check — calcs has no @timestamp column. Either way the
    private static final List<List<Object>> EXPECTED_RESET_ROWS = List.of(  
 * <p>Same as {@link EventstatsCommandIT}: {@code age→int0}, {@code country→str0},
            return;
     * predicate is true bumps a segment id, partitioning the running aggregate so windows do  
            "source=" + DATASET.indexName + " | sort key"  
            row("key05", 3,    6L,  17L),  
            row("key09", 8,    null),
        // Window=3 over running counts [1,2,...,17]: at row N≥3, avg = (N-2 + N-1 + N)/3 = N-1.  
 *  
     *  per-partition windowed running aggregate. Each row's avg covers up to 2 rows of int0
    // ── Multiple streamstats (chained) ─────────────────────────────────────────
    // BackendPlanAdapter rewrites RexOver(DISTINCT_COUNT_APPROX) → APPROX_COUNT_DISTINCT,
            "source=" + DATASET.indexName + " | streamstats earliest(str0), latest(str0) by str3"  
     * key16}, producing 7 segments (id 0..6) over the 17-row dataset. Default {@code current=true}
    public void testStreamstatsByWithNullBucket() throws IOException {
        } catch (ResponseException e) {
    /**
            && (actual instanceof Double && Double.isNaN((Double) actual)
        );
            row("key12", null, null, 2L),  
                + " | fields key, str3, int0, sp, ss, vp, vs"
                + " | fields key, str0, int0, sp, ss, vp, vs"  
        );  
     *  ending at current within its str0 partition (sorted by key). */
            row("key09", 8,    null),  
        );
        Map<String, Object> response = executePpl(
            row("key09", 8,    10L, 9.0),
            "source=" + DATASET.indexName + " | streamstats percentile(int0)",
        row("key00", "FURNITURE",       1,    1.0),  
            row("key13", 4,    14L, 17L),
                + " | streamstats window=3 avg(int0) as avg3"  
     *  {@link #testStreamstatsVariance}. */
     * {@code seq <= current_seq}. Nulls in {@code int0} are dropped by AVG.  
    }
            row("key03", null, 3L, null,               null, null),  
            row("key01", "FURNITURE",       null, 1L),
     *  {@code FragmentConversionDriver}); the query now executes deterministically.
                + " stddev_pop(int0), stddev_samp(int0), var_pop(int0), var_samp(int0) by str0"  
     *  see {@code DataFusionFragmentConvertor.replaceInput} for the lifted-window Project  
    }
                + " stddev_pop(int0), stddev_samp(int0), var_pop(int0), var_samp(int0)"
 *   <li>{@code streamstats dc / distinct_count / earliest / latest / percentile / median / mode}
    public void testStreamstatsReset() throws IOException {
            DatasetProvisioner.provision(client(), DATASET);
        Map<String, Object> response = executePpl(
            return;  
    private static final Dataset DATASET_MULTI = new Dataset("calcs", "calcs_multi_streamstats");
 *       PlannerImpl's subquery-remove phase, but the streamstats-inside-decorrelated-correlate  
            row("key14", 11,   3.189488909868294,   3.3829638550307397, 10.172839506172838, 11.444444444444443),
            row("key03", "e",  null, 4L,   1.0,               1,    1),  
    // ── Multi-shard correctness — exercises the SINGLETON-gather cost gate ────
 *   <li>{@code streamstats … by span(int0, 10)} works after BackendPlanAdapter recurses
            row("key10", 4,    5.4),
            row("key07", null, 5.5),
        );  
            row("key06", 8,    7L,  6.0),
     * <p>For {@code int0 > 5}: segId increments before rows {key04, key06, key09, key11, key14,  
    private void ensureMultiShardProvisioned() throws IOException {  
            row("key08", null, null, 1L),
            Response response = client().performRequest(request);
            assertCellEquals("Cell mismatch at col " + j, expected[j], got.get(j));  
    }
     * column) and used to be rejected at the marker rule.
            "source=" + DATASET.indexName + " | sort key"
        Map<String, Object> response = executePpl(
    }  
                + " [ source=" + DATASET.indexName + " | sort key | streamstats count() as cnt"
        Map<String, Object> response = executePpl(
        assertRowsEqual(response,  
            row("key07", null, 2.8613807855648994,  3.304037933599835,  8.1875,             10.916666666666666),
    public void testStreamstatsEarliestAndLatest() throws IOException {
     *  {@link #testStreamstatsCurrentAndWindow}. */  
        // "e" on key14..15; null on key16. Once the first non-null is seen, count is 1 forever.
     *  is fully populated. {@code span(int3, 10)} produces two buckets: 0 (9 rows) and 10
            row("key01", null, 1.0),
        Map<String, Object> response = executePpl(  
        );
     *  TECHNOLOGY (key08..16): null,"e","e",null,null,null,"e","e",null
    }
        assertErrorAny(  
        );
            row("key00", 1,    (Double) null),
            row("key14", "TECHNOLOGY",      11,   2.9393876913398134,  3.2863353450309964, 8.639999999999997,  10.799999999999997),
            row("key04", null, 7,    1L),
                + " | where cnt < 5 | fields key ]"  
            row("key12", 11, null, 5L, 6.0,                4,    8),
        assertRowsEqual(response,  
            row("key16", "TECHNOLOGY",      17L, 18, 126L)  
        assertRowsEqual(response,
            row("key00", 1,    1L,  1.0),
                + " | streamstats current=false window=2 avg(int0) as avg"
        );
            row("key12", "TECHNOLOGY", 3L),
        assertRowsEqual(response, row("key00"), row("key01"), row("key02"), row("key03"));  
            row("key05", 3,    7.0),
        Map<String, Object> response = executePpl(
            row(6L, "OFFICE SUPPLIES"),
     *  error. PPL parser rejects this before reaching analytics-engine planner. */  
    public void testLeftJoinWithStreamstats() throws IOException {  
    }
            }  
            row("key01", null, 1.0),  
            row("key09", "TECHNOLOGY",      8,    1L),
            row("key02", null, 3L,  2.0),
        );
            "source=" + DATASET_MULTI.indexName + " | sort key | streamstats count() as cnt by str0"
            row("key14", 11,   15L, 14.0),
                + " | fields key, str0, cnt, x, sx"
 * should be promoted to passing assertions.  
package org.opensearch.analytics.qa;
     *  has 7 nulls + 10 'e' rows — covers null-key partition handling. Each partition runs
            row("key16", 8,    17L, 16.0)  
        row("key07", "OFFICE SUPPLIES", null, 8.0),
            row("key11", null, 10,   4L,  6.666666666666667,  3,    10),
        assertRowsEqual(response,
 *   <li><b>{@code streamstats current=false}</b> — frame is {@code ROWS UNBOUNDED PRECEDING TO 1
            row("key05", 3,    3.055050463303893),
    }  
            row("key12", null, null, 5L,  6.666666666666667,  3,    10),
    /** sql IT: testStreamstats. Per-row running count/avg/min/max over int0. count() counts every  
                + " | fields key, str0, int0, cnt"
    }  
    // ── distinct_count / dc ────────────────────────────────────────────────────
            row("key12", null, 13L)
    public void testStreamstatsBySpan() throws IOException {
            row("key07", "OFFICE SUPPLIES", null, 8.0),  
            DatasetProvisioner.provision(client(), DATASET_MULTI, 3);
                + " | fields key, str0, int0, avg"
        row("key13", "TECHNOLOGY",      4,    7.0),
            row("key02", "OFFICE SUPPLIES", 2L),  
        assertRowsEqual(response,  
        );
     *  TECHNOLOGY) are ingested contiguously, so each row's window of {seq−1, seq} naturally
     * restoration — the correlate's join predicate is non-equi (range over the row-number seq  
                + " | fields key, str0, int0, avg"
            row("key09", 8,    2.8705400188814645,  3.209361307176242,  8.239999999999998,  10.299999999999997),
            // Any error response is acceptable.
     *  case it now handles. */
    public void testStreamstatsGlobalWithNullBucket() throws IOException {  
            row("key01", null, 0.0,                 (Double) null,         0.0,                (Double) null),  
    public void testStreamstatsVarianceBy() throws IOException {
                + " | fields key, str0, int0, avg"  
    /** sql IT: testMultipleStreamstatsWithNull2. Same query as
            row("key16", null, 1L)
        assertRowsEqual(response,  
            row("key16", "TECHNOLOGY",      8,    2.7774602993176543,  3.0,                7.714285714285714,  9.0)
        );
    public void testStreamstatsCurrentWithNUll() throws IOException {
                + " | stats max(dc_str3) as final_dc by str0 | sort str0"  
            row("key16", "TECHNOLOGY",      8,    5L)
            for (int j = 0; j < want.size(); j++) {
            row("key16", null, 8,    4L)
                + " | fields key, str0, int0, avg"
                + " | sort key | streamstats dc(str3) as dc_str3 by str0"
            row("key06", "OFFICE SUPPLIES", 8,    2.160246899469287,   2.6457513110645907, 4.666666666666667,  7.0),  
        assertRowsEqual(response,
            row("key09", "e",  8,    7L,  5.666666666666667,  1,    8),
            row("key10", "e",  4,    8L,   5.25,              1,    8),
            row("key12", null, 13L, 7.0),
            row("key15", 4,    8L, 4.875,              1,    8),  
            row("key05", 3,    3L, 3.6666666666666665, 1,    7),
            }
            row("key05", null, 1L),  
            row("key01", null, 1L, null,               null, null),
        row("key12", "TECHNOLOGY",      null, 10.0),
            row("key09", 8,    4.75),  
            row("key12", null, null, 2.867441755680875,  3.5118845842842457, 8.22222222222222,   12.333333333333329),
                + " | streamstats count() as cnt by span(int0, 10), str0"  
            row("key00", "FURNITURE", 1L),
            row("key11", 10,   12L, 6.5),  
            row("key06", 8,    7L,  4.0),
        );
            row("key04", 7,    null),  
            row("key14", "TECHNOLOGY",      11,   7L, 7.4,                 4,    11),
            row("key05", 3,    6L,  5.0),
/*  
            row("key00", 1,    1L,  17L),
            row("key02", "e",  1L),  
        row("key15", "TECHNOLOGY",      4,    7.5),  
     *  global max(cnt) — every row carries the same global max=17. */
            row("key15", 4,    16L, 15.0),
            row("key04", 9,  7,    4L, 4.0,                1,    7),  
            row("key02", null, 0.0,                 (Double) null,         0.0,                (Double) null),
                + " | streamstats count() as cnt by span(int0, 10), str0"  
            "source=" + DATASET.indexName + " | sort key"
        // FURNITURE: [1, null] → avg=1, 1
     *  {@code str0} has null values, and calcs has none, so the output is identical. */  
        Map<String, Object> response = executePpl(
        );
            row("key03", "OFFICE SUPPLIES", null, 2L),
     *  by AVG; left-join semantics keep every left row even when the frame matches no right  
        row("key01", "FURNITURE",       null, 1.0),
        Map<String, Object> response = executePpl(  
     *  {leftSeq−1, leftSeq}} AND {@code rightStr0 = leftStr0}; nulls in {@code int0} are dropped
        row("key05", "OFFICE SUPPLIES", 3,    5.0),  
            row("key00", "FURNITURE", 1L),  
            row("key13", 4,    14L, 7.5),
 *   <li><b>{@code streamstats … by <field>}</b> — adds a helper {@code __row_number_for_streamstats__}
            row("key03", null, 0.0,                 (Double) null,         0.0,                (Double) null),
        );
        Map<String, Object> response = executePpl(  
    // ── Basic streamstats (no by) ──────────────────────────────────────────────
        } catch (ResponseException expected) {  
        );
            row("key15", 4,    16L),
            row("key16", 8,    7.666666666666667)   // {11,4,8}  
            "source=" + DATASET_MULTI.indexName
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str3"
    // ── current=false / window=N variants ──────────────────────────────────────
            row("key07", null, 8L,  4.5),  
        );  
                + " | streamstats count() as cnt by span(int0, 10), str3"
    public void testMultipleStreamstats() throws IOException {
            row("key01", null, 2L,  1.5),
                + " | streamstats stddev_pop(int0) as sp, stddev_samp(int0) as ss, var_pop(int0) as vp, var_samp(int0) as vs by str0"
            row("key16", 8,    3.009626428590336,   3.1565228279922772, 9.05785123966942,   9.963636363636363)  
            row("key15", 4,    3.0983866769659336,  3.265986323710904,  9.6,                10.666666666666666),
    public void testStreamstatsResetWithNull() throws IOException {
            row(1L, "FURNITURE"),
                + " | fields key, int0, cnt, avg_cnt"
            row("key12", "TECHNOLOGY",      null, 10.0),
            "source=" + DATASET.indexName + " | sort key"
import java.io.IOException;
            row("key11", 10,   12L, 11.0),
            row("key03", null, null),  
            "source=" + DATASET.indexName + " | sort key"
            row("key13", null, 4,    3L),  
            row("key04", null, 7,    1L),  
        row("key00", "FURNITURE",       1,    1.0),
            row("key12", "TECHNOLOGY",      null, 2.4944382578492936,  3.0550504633038926, 6.222222222222219,  9.333333333333329),  
            row("key10", "TECHNOLOGY", 1L),
    }  
        ensureMultiShardProvisioned();
    @SuppressWarnings("unchecked")
            row("key11", 12L, 13, 90L),
        );
    /** sql IT: testStreamstatsBySpan. Bucketing key has no nulls — uses {@code int3} which  
            row("key09", "e",  8,    3L),  
            row("key04", 7,    7.0),   // window={null,null,7}  
        );
            row("key05", 3,    2.494438257849294,   3.055050463303893,  6.222222222222221,  9.333333333333332),
            row("key09", 8,    8.0),
        assertRowsEqual(response,
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by span(int0, 10)"
            "source=" + DATASET.indexName + " | sort key"  
        );  
            "source=" + DATASET.indexName + " | sort key"
     *  changes the both-null group-key handling, and no row in calcs has a null {@code str0}. */
            row("key10", "e",  4,    4L),
            row("key08", null, 4.75),
        Map<String, Object> response = executePpl(  
            "source=" + DATASET.indexName + " | sort key"  
            row("key16", 8,    6.0)
 *       the analytics-engine route yet.</li>
            row("key05", 3,    2.494438257849294,   3.055050463303893,  6.222222222222221,  9.333333333333332),  
    /** Multi-shard variant for streamstats dc by partition. Streamstats running aggregates  
            row("key08", null, 1L),  
                + " | fields key, int0, cnt, avg, mn, mx"  
            row("key00", 1,    1L,  1.0,                 1, 1),  
            row("key04", null, 7,    null, null,              null, null),
            row("key03", null, 1.0),  
    /** sql IT: testStreamstatsEmptyRows. */  
        }
            row("key15", "e",  4,    10L, 6.0,                1,    11),
     *  expect throw. */
    }  
                + " | streamstats window=3 avg(cnt) as avg_cnt"  
                + " | streamstats avg(cnt) as avg_cnt"  
        row("key07", "OFFICE SUPPLIES", null, 8.0),
            row("key08", null, 4.75),  
    /** sql IT: testStreamstatsVarianceWithNullBy. Variance partitioned by {@code str3}, which
            row("key09", "TECHNOLOGY",      10L, 11, 21L),
            row("key08", "TECHNOLOGY",      null, null,                null,               null,               null),
            row("key04", 7,    5L,  4.0),  
            "source=" + DATASET.indexName + " | sort key"  
            row("key14", 11,   0.7071067811865476),
    public void testWhereInWithStreamstatsSubquery() throws IOException {
            row("key04", "OFFICE SUPPLIES", 7,    1L),
            row("key02", null, 0.0,                 (Double) null,         0.0,                (Double) null),  
        // Running dc(str0): FURNITURE×2 → 1,1; OFFICE×6 → 2,2,2,2,2,2; TECHNOLOGY×9 → 3,3,...
     *  reset on the second streamstats. First pass: per-partition cnt by str0 (each str0
     *  the non-null partition's running count proceeds as usual. Same {@code by str3} as  
            row("key06", "OFFICE SUPPLIES", 2L),
            row("key02", "OFFICE SUPPLIES", null, null),
                + " | fields key, int0, sp, ss, vp, vs"
            row("key07", null, null),  
            row("key07", null, 8L,  17L),
     *  NaN-aware: (Double) null matches both (Double) null and the string "NaN" (Jackson encodes  
                + " | streamstats bucket_nullable=false count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by str3"
            row("key11", "TECHNOLOGY",      10,   1L),  
 *       shape has a nondeterministic multi-node execution race today. Marked {@code @AwaitsFix}
            "source=" + DATASET.indexName + " | sort key"
            row("key13", 4,    7L, 5.0,                1,    8),
            List<Object> want = expected.get(i);
                + " | sort -key | head 5"
            row("key00", "e",  1,    0.0,                (Double) null,         0.0,                (Double) null),
        );
    /** sql IT: testStreamstatsDistinctCount. */
    public void testStreamstatsCurrentAndWindow() throws IOException {
            row("key15", 4,    16L, 8.5),
            row("key10", "e",  4,    2.947456530637899,  3.4034296427770228, 8.6875,             11.583333333333334),  
        assertErrorContains(  
            row("key07", null, 4L, null,               null, null),
}
    public void testMultipleStreamstatsWithEval() throws IOException {
            row("key04", 7,    5L,  4.0),  
            row("key14", 11,   15L),
            row("key08", null, 9L,  5.0),  
            Map<String, Object> body = entityAsMap(response);
            row("key08", null, null, 3L,  5.0,                3,    7),
            row("key16", 0,  8,    9L, 6.166666666666667,  1,    10)  
            row("key01", null, 1.0),
            row("key16", 8,    9L, 5.222222222222222,  1,    8)
            row("key09", 8,    2.8705400188814645,  3.209361307176242,  8.239999999999998,  10.299999999999997),
            row("key00", 1,    null),  
        );  
                + " | fields key, int0, cnt, avg, mn, mx"  
    }  
            response,  
     *  while only 0/1 non-null int0 has been seen). Final row matches eventstats global. */  
            row("key04", 7,    5L,  3.0),  
            row("key10", "e",  1L),  
            row("key09", "TECHNOLOGY", 3L),
    public void testMultipleStreamstatsWithWindow() throws IOException {
    /** sql IT: testStreamstatsEarliestAndLatest. earliest/latest exercise the PPL frontend's
            row("key10", "TECHNOLOGY",      4,    6.0),  
            row("key06", "OFFICE SUPPLIES", 8,    5.5),
        row("key15", "TECHNOLOGY",      4,    7.5),
            row("key02", null, 3L,  2.0),
            row("key15", "TECHNOLOGY", 1L),  
        assertRowsEqual(response,
            row("key14", 18, 11,   7L, 6.75,               4,    11),
            row("key04", "OFFICE SUPPLIES", 5L,  6,  15L),  
            row("key15", 4,    16L, 6.0,                 1, 11),  
     *  (8 rows). Pairs with {@link #testStreamstatsBySpanWithNull} which uses
                + " | streamstats bucket_nullable=false window=2 global=true avg(int0) as avg by str0"  
            "source=" + DATASET.indexName + " | sort key"
 *       lowers to {@code SUM/AVG/COUNT/MIN/MAX OVER (ROWS UNBOUNDED PRECEDING TO CURRENT ROW)}. Cost
            row("key14", "e",  1L),  
                + " | streamstats reset_before=(int0 > 5) avg(int0) as avg by str0"
            row("key08", null, 9L,  8.0),
            row("key04", 7,    null),
            row("key15", "e",  4,    3.3166247903554,    3.63318042491699,   11.0,               13.2),
     *  the precise error message depends on which lowering path the PPL parser picks (which
            row("key02", "OFFICE SUPPLIES", null, 1L),  
        );
            row("key14", 11,   7.5),  
        }
    /** Send a PPL query and assert it fails with ANY error response. Used for cases where
                body.contains(expectedSubstring)
            row("key07", null, 4.75),
            row("key14", 11,   15L, 17L),  
        Map<String, Object> response = executePpl(
            row("key00", "FURNITURE",       1,    1L),
import java.util.List;
    public void testStreamstatsDistinctCountWithNull() throws IOException {
            row("key08", "TECHNOLOGY",      null, 1L),  
     *  may not flow through analytics-engine for the specific embedded shape; conservatively
            row("key04", 7,    1.0),
    public void testUnsupportedWindowFunctions() throws IOException {
            row("key03", "e",  null, 3L),
            row(1L, "TECHNOLOGY")  
    /** Same data, same query — same lowering. {@code bucket_nullable} only matters when
                + " | streamstats count() as cnt"
import java.util.Map;
            row("key03", null, 4L,  3.0),
            row("key03", null, 4L,  3.0),
    // seen. calcs.str0 has three values {FURNITURE, OFFICE SUPPLIES, TECHNOLOGY} appearing in
        Map<String, Object> response = executePpl(
            row("key10", 4,    6L, 5.166666666666667,  1,    8),
    );
            row("key04", 7,    4.242640687119285),  
            row("key06", 8,    7L,  6.0),
            row("key13", 4,    14L, 7.5),  
        Map<String, Object> response = executePpl(  
            } catch (Exception ioe) {  
            row("key16", 17L, 18, 170L)  
    }
        Map<String, Object> response = executePpl(
            "source=" + DATASET.indexName + " | sort key"
            row("key11", 10,   7.333333333333333),  
            row("key16", 8,    7.5)  
        assertRowCount(r2, 0);
    /** sql IT: testStreamstatsAndEventstats. Streamstats running cnt followed by eventstats  
            row("key07", "OFFICE SUPPLIES", null, 3L),
    public void testStreamstatsByWithNull() throws IOException {
            row("key01", "e",  null, 0.0,                (Double) null,         0.0,                (Double) null),  
            row("key09", "TECHNOLOGY",      8,    8.0),
     *  {@link #testMultipleStreamstatsWithWindow}. */
            row("key16", "TECHNOLOGY",      8,    5L)
    }
                body = e.getMessage();
            row("key16", null, 8,    2.576819745345025,  2.880972058177586,  6.639999999999998,  8.299999999999997)  
    public void testStreamstatsVarianceWithNull() throws IOException {  
            row("key07", "OFFICE SUPPLIES", 1L),
            row("key03", null, 1.0),  
            row("key11", 10,   12L, 6.5),
            row("key06", "OFFICE SUPPLIES", 8,    5L, 6.0,                 3,    8),
            row("key15", "e",  4,    5L),  
            "source=" + DATASET.indexName + " | sort key"  
            row("key08", null, 9L,  17L),  
            row("key09", 2,  8,    7L, 4.75,               1,    8),
            row("key06", "e",  8,    5L,  4.5,                1,    8),
            );  
            row("key05", 3,    5.0),  
     *  same as the unbounded running avg in {@link #testStreamstats}. */
            "source=" + DATASET.indexName + " | sort key"
     *  BETWEEN frame predicate (non-equi) AND-ed with the group equality. The non-equi predicate
            row("key06", 8,    3.6666666666666665),
        assertRowsEqual(response,
        row("key03", "OFFICE SUPPLIES", null, null),
     *  <p>For our calcs dataset the {@code str0} groups (FURNITURE / OFFICE SUPPLIES /
            multiProvisioned = true;  
            row("key14", 11,   15L, 8.0),
            row("key04", null, 1L),  
            row("key15", 11, 4,    8L, 6.2,                4,    11),
            row("key12", "TECHNOLOGY",      13L, 14, 60L),
 *  
 *   <li>{@code streamstats reset_before=… / reset_after=…} — the PPL lowering uses correlate +  
    // over a UNBOUNDED PRECEDING / CURRENT ROW frame, so dc_* is a per-row running count of
     *  The outer query re-sorts by {@code key} so the IN-filtered result is pinned to an exact,  
            row("key03", null, 4L,  1.0,                 1, 1),  
 * </ul>
            row("key08", null, 9L,  8.0),
            row("key00", "FURNITURE",       1,    1.0),
        return Arrays.asList(values);
            row("key10", 4,    2.6718699236469,     2.926886855802026,  7.13888888888889,   8.566666666666668),
            row("key06", "e",  1L),
            row("key16", 8,    17L, 6.181818181818182,   1, 11)
     *  Collapse the running stream to per-partition finals via {@code stats max(dc_str3) by str0}  
    /** sql IT: testStreamstatsGlobalWithNull. {@code global=true} lowers to a self-join with a
            row("key16", null, 8,    4L)  
        Map<String, Object> response = executePpl(
            row("key15", 4,    16L, 15.0),
                + " | fields key, int0, cnt, avg_cnt"
        Map<String, Object> response = executePpl(  
        // "e" on key06..07 still 1; null on key08; "e" on key09..10; nulls on key11..13;
        Map<String, Object> response = executePpl(
            row("key01", null, 0.0,                 (Double) null,         0.0,                (Double) null),
            row("key05", 3,    6L,  3.6666666666666665,  1, 7),
        );
            row("key02", null, 3L,  17L),  
    public void testStreamstatsWindow() throws IOException {
            "Window size must be >= 0"
            row("key13", 4,    5.857142857142857),
    public void testMultipleStreamstatsWithNull1() throws IOException {  
    }
            row("key03", null, 4L,  17L),
    }  
    private void assertRowsEqualList(Map<String, Object> response, List<List<Object>> expected) {
    public void testStreamstats() throws IOException {
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably).
            row("key06", "OFFICE SUPPLIES", 8,    3L),
    }
     *  path is not yet reachable on analytics-engine — assert the failure. */  
    public void testMultipleStreamstatsWithEval2() throws IOException {
            row("key14", "TECHNOLOGY", 1L),
            row("key07", "OFFICE SUPPLIES", 8L,  9,  39L),  
                + " | streamstats count() as cnt"
     *  used to be rejected at the join marker rule until theta-join routing was restored, after  
     *  null-key partition: rows whose {@code by} key is null get NULL running output, while
                + " | streamstats sum(x) as sx by str0"
        // Per-(str0) sliding window=2 over int0 ignoring nulls:  
            row("key14", "TECHNOLOGY",      11,   2L),  
        );
            row("key16", 8,    17L, 16.0)  
     *  {@link #testStreamstatsDistinctCount} — sql-plugin's variant uses STATE_COUNTRY_WITH_NULL,
        Map<String, Object> response = executePpl(  
            row("key15", "e",  1L),
            row("key03", "e",  null, 3L),  
        }
            row("key00", 1,    1L,  1.0),
            "source=" + DATASET.indexName + " | sort key"
        );  
     *  partitioned streaming windows. See {@code EventstatsCommandIT.DATASET_MULTI} for the  
            "source=" + DATASET.indexName + " | sort key"
            row("key10", "e",  4,    4L),  
            row("key09", 8,    10L, 9.0),
        );  
        // Running dc(str3): "e" on key00..03 → 1; nulls on key04..05 don't change count;  
        assertRowsEqualList(response, EXPECTED_GLOBAL_TRUE_ROWS);  
            row("key11", 10,   12L, 17L),  
            Map<String, Object> body = entityAsMap(response);  
                + " | fields key, str0, int0, avg"
            row("key13", 4,    2.70801280154532),  
                + " | streamstats window=2 global=true avg(int0) as avg by str0"  
                + " | streamstats current=false avg(int0) as prev_avg"  
            row("key16", 8,    6.181818181818182)
    }
            row("key15", "TECHNOLOGY",      16L, 17, 108L),
                + " | streamstats stddev_samp(int0) as ss by span(int0, 10)"
            row("key07", "e",  null, 4L),
        );  
            row("key10", "TECHNOLOGY",      4,    2L),
        );
            row("key00", "FURNITURE",       1L,  2,  2L),
    public void testStreamstatsGlobalWithNull() throws IOException {  
        assertRowsEqual(response,
            row("key12", null, null),
            row("key10", 11L, 12, 77L),  
            row("key03", null, null),
            row("key11", null, 10,   null, null,              null, null),
    }
            row("key12", null, 7.0),
            row("key07", "e",  null, 3.5,                4.949747468305833,  12.25,              24.5),  
            row("key05", "OFFICE SUPPLIES", 3,    4L, 5.0,                 3,    7),
            row("key02", "e",  null, 2L),
        Map<String, Object> response = executePpl(  
     *
     *    → 0,1,1,1,1,1,1,1,1 (the leading null sees no non-null yet, so dc=0). */
            row("key14", 11,   5.625),
        );  
            row("key05", "OFFICE SUPPLIES", 3,    2L),  
     *  depend on input row-order; under multi-shard parallelism rows arrive at the
            row("key04", "OFFICE SUPPLIES", 1L),
            row("key06", 8,    3.6666666666666665),  
        );
            row("key06", "OFFICE SUPPLIES", 8,    3L),
            "source=" + DATASET.indexName + " | sort key"
            row("key05", 3,    4.0),
     *  
            row("key10", 4,    11L, 6.0),  
            row("key11", 10,   7.333333333333333),  // {8,4,10}
            double e = ((Number) expected).doubleValue();
            row("key07", null, 5.5),  
            "source=" + DATASET.indexName + " | sort key"
            row("key14", 11,   15L, 6.222222222222222,   1, 11),
            row("key00", 8,  1,    1L, 1.0,                1,    1),
            row("key10", 4,    11L, 17L),
            row("key14", "e",  11,   3.49857113690718,   3.911521443121589,  12.239999999999998, 15.299999999999997),
            row("key08", null, 8.0),
            row("key15", 4,    3.0983866769659336,  3.265986323710904,  9.6,                10.666666666666666),
        assertNotNull("Response missing 'rows'", rows);
            row("key09", "e",  8,    3L),
            row("key05", 3,    6L,  3.5),  
    /** Hand-computed running average for {@code reset_before=(int0 > 5)} over the calcs
    }
            row("key03", "OFFICE SUPPLIES", null, null),
        assertRowsEqual(response,
        assertRowsEqual(response,
     *  {@code span(int0, 10)} which produces a null bucket alongside bucket 0 and bucket 10.
                + " | fields key, int3, int0, cnt, avg, mn, mx"
            row("key13", null, 1L),
            row("key15", 4,    6.222222222222222),
        row("key14", "TECHNOLOGY",      11,   7.5),
            row("key02", "OFFICE SUPPLIES", 1L),
            "percentile"  
    /** sql IT: testStreamstatsByMultiplePartitionsWithNull1. Same query as
        try {
        );
            row("key06", "e",  8,    2L),
    /** sql IT: testStreamstatsByMultiplePartitions1. {@code by span(int0, 10), str0}. */
            row("key00", 1,    0.0,                 (Double) null,         0.0,                (Double) null),
    /** sql IT: testStreamstatsWindowWithNull. Same query as {@link #testStreamstatsWindow} —
        row("key10", "TECHNOLOGY",      4,    6.0),
                + " | head 1"  
        );  
    /** Send a PPL query and assert response body contains {@code expectedSubstring}. */  
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    /** Multi-shard alias for tests that exercise the SINGLETON-gather cost gate on
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx by span(int3, 10)"
        assertRowsEqual(response,
    public void testStreamstatsWindowError() throws IOException {
            row("key04", 7,    4.0),
            row("key00", "e",  1,    1L),
            response,  
            row("key01", "e",  null, 1L),  
        // TECHNOLOGY: [null, 8, 4, 10, null, 4, 11, 4, 8] → null, 8, 6, 7, 10, 4, 7.5, 7.5, 6  
        if (expected instanceof Double && Double.isNaN((Double) expected)
        );  
            row("key14", 11,   15L, 8.0),  
    }
                + " | streamstats count() as cnt, avg(int0) as avg, min(int0) as mn, max(int0) as mx"
            row("key05", null, 3,    2L),
            row("key04", null, 7,    1L,  7.0,                7,    7),  
    }
            row("key12", null, null, null, null,              null, null),  
     *  {@link #testStreamstatsByMultiplePartitions2}. */
                + " | fields key, str0, int0, cnt"
            row("key14", 15L, 16, 135L),
        try {
    /** sql IT: testMultipleStreamstatsWithWindow. Second streamstats uses window=3 over the  
            row("key12", null, 5.857142857142857),
            row("key00", 1,    null),
 * The OpenSearch Contributors require contributions made to  
        assertRowsEqual(  
            try {
            row("key02", "e",  null, 2L),
            row("key11", "TECHNOLOGY",      10,   7.0),
                + " | streamstats reset_before=(int0 > 5) avg(int0) as avg by str0"
            row("key02", "OFFICE SUPPLIES", null, 1L),  
            assertEquals(message, expected, actual);
            row("key02", null, 2L, null,               null, null),
    public void testStreamstatsDistinctCountByCountry() throws IOException {  
