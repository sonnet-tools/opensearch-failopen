 */  
            double e = ((Number) expected).doubleValue();
            return;
package org.opensearch.analytics.qa;
    //
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
            row("5-10"),  
        assertEquals(message, expected, actual);
        }
                    got.get(j)  
        }  
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
import java.util.List;  
 * bucket label (same column name, VARCHAR type) — matching  
 * The OpenSearch Contributors require contributions made to  
            row("7.5-10.0"),
}
        assertNotNull("rows missing", rows);
            row("-5-0"),
    private static void assertCellEquals(String message, Object expected, Object actual) {
import org.opensearch.client.Request;
 * {@code span_bucket} SqlFunction &rarr;  
    //   10    → "10-15"
            List<Object> want = expected[i];
            row("7.5-10.0")  
        if (expected instanceof Number && actual instanceof Number) {  
    @SafeVarargs
            assertEquals(message, expected, actual);  
        );
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
    //   3.5   → "0-5"  
    //   null  → null (preserved)  
    // num0 goes null at key07. `bin num0 span=5` must preserve nulls.
    private static void assertBucket(List<Object> row, String expectedLabel, long expectedCount) {
            dataProvisioned = true;
    //   -15.7 → "-20--15"
        assertEquals("unexpected bucket label", expectedLabel, row.get(1));
    //   null  → null
        assertEquals("4 distinct bucket labels expected", 4, rows.size());
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
            "source=" + DATASET.indexName + " | bin num1 span=2.5 | fields num1 | head 3",  
 * Self-contained integration test for the PPL {@code span_bucket} scalar on
    // `bin num1 span=2.5` — span is a literal float, spans the non-integer
 * isthmus resolves via {@code ADDITIONAL_SCALAR_SIGS} &rarr;
    //   11.38, 12.4, ... → "10-15"
            }
 *
        for (int i = 0; i < expected.length; i++) {  
                    want.get(j),
 * {@code span=N} path emits {@code span_bucket(field, span)} directly
    // `num1` has no nulls; values ∈ [2.47, 16.81]. `bin num1 span=5` labels:
    // usable as a grouping key. Distribution for num1 at span=5:
        assertBucket(rows.get(1), "10-15", 5);
    }  
 * {@code rust/src/udf/span_bucket.rs} returns the VARCHAR bucket label.  
        assertEquals("unexpected count for bucket " + expectedLabel, expectedCount, ((Number) row.get(0)).longValue());  
        @SuppressWarnings("unchecked")
    public void testBinSpanOnDoubleFieldProducesBucketLabel() throws IOException {  
 * compatible open source license.
            List<Object> got = actualRows.get(i);
            row("-20--15"),  
public class SpanBucketCommandIT extends AnalyticsRestTestCase {
    }
            "source=" + DATASET.indexName + " | bin num1 span=5 | fields num1 | head 5",
    }  
import java.util.Arrays;
            row((Object) null),
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
        return Arrays.asList(values);
    // ── Fractional span uses decimal formatting ─────────────────────────────  
 * <p>Pipeline:  
            return;  
        );
        @SuppressWarnings("unchecked")
            DatasetProvisioner.provision(client(), DATASET);
 */  
    //   15.7  → "15-20"
    }
    // fall in "5-10".
 * SPDX-License-Identifier: Apache-2.0
            row("5-10"),
 * end-to-end without empty-partition window pushdown support.
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
    // ── Null-value propagation via `bin` on a nullable field ────────────────
            }
    // path of the formatter (1dp since span >= 1.0).  
            row("0-5"),  
 * {@code BinCommand} AST &rarr;
 * repository.
            row("5-10"),
    //   6.71 → floor(2.684)*2.5 = 5.0, binEnd=7.5 → "5.0-7.5"
            row("5-10")
    //   16.42, 16.81 → "15-20"  
        Map<String, Object> response = executePpl(ppl);
 * syntax, which is the only user-facing surface that emits the  
    //   9.78 → floor(3.912)*2.5 = 7.5 → "7.5-10.0"  
    //   -12.3 → floor(-12.3/5)*5 = -15 → "-15--10"  
        // PPL stats emits (aggregate, groupingKey) column order.
    }
    //   "15-20": 2  (16.42, 16.81)
    //   "0-5": 1    (2.47)
 * {@code SPAN_BUCKET(field, span)} RexNode &rarr;
    private static List<Object> row(Object... values) {  
    //   8.42 → floor(8.42/2.5)*2.5 = 7.5, binEnd=10.0 → "7.5-10.0"
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
import java.util.Map;
        );
    }
 * {@code org.opensearch.sql.calcite.utils.binning.handlers.NumericSpanHelper}).
        }  
 * PPL {@code bin f span=N} &rarr;
        assertBucket(rows.get(3), "5-10", 9);  
 * <p>The {@code bin} command REPLACES the original field column with the
        assertBucket(rows.get(0), "0-5", 1);  
            "source=" + DATASET.indexName + " | bin num1 span=5 | stats count() as c by num1 | sort num1"  
    // Lexicographic sort on the VARCHAR label: "0-5", "10-15", "15-20", "5-10".  
 * {@link org.opensearch.be.datafusion.SpanBucketAdapter} rewrites to local
 * DataFusion resolves the {@code span_bucket} Rust UDF by name &rarr;
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
    //  
        Map<String, Object> response = executePpl(
    private static boolean dataProvisioned = false;
        assertRows(
    //
    //   0     → "0-5"
        if (dataProvisioned == false) {  
            row("10-15"),
            double a = ((Number) actual).doubleValue();
    @Override
                assertCellEquals(  
            "source=" + DATASET.indexName + " | bin num0 span=5 | fields num0 | head 10",
    // Head 5 of the natural calcs order (8.42, 6.71, 9.78, 7.43, 9.05) all
    //   "5-10": 9   (8.42, 6.71, 9.78, 7.43, 9.05, 9.38, 9.47, 7.1, 7.12)  
    public void testBinSpanFractionalSpanUsesDecimalFormat() throws IOException {
            row("15-20"),
            row("5.0-7.5"),
    protected void onBeforeQuery() throws IOException {
    //   2.47 → "0-5"  
        assertRows(
    //   6.71, 7.43, 9.78, ... → "5-10"
    //   "10-15": 5  (11.38, 12.4, 10.32, 12.05, 10.37)
    @SuppressWarnings("varargs")
                got.size()  
    public void testBinSpanPreservesNullsInNullableField() throws IOException {  
    }
            row("0-5"),
    }
            row("-15--10"),
/*  
            assertEquals(  
 *
        }
 * <p>Unlike the other {@code *_bucket} functions (width/minspan/range), the
            row("5-10"),  
    //   -3.5  → "-5-0"
    public void testBinSpanAsGroupingKey() throws IOException {
            );
    //   12.3  → "10-15"
 *
    // ── Aggregating over bucket labels ──────────────────────────────────────
import org.opensearch.client.Response;
 * {@code span_bucket} UDF (via
    // Feeds `bin` into `stats count()` to verify the VARCHAR column is  
    //
        if (expected == null || actual == null) {
        assertBucket(rows.get(2), "15-20", 2);
                "Column count mismatch at row " + i + " for query: " + ppl,
        assertRows(
/**  
                want.size(),
            for (int j = 0; j < want.size(); j++) {
    // ── Integer span on a non-null double field ─────────────────────────────  
    }
 * {@code NumericSpanHelper.createNumericSpanExpression} &rarr;  
 * without a {@code MIN/MAX OVER ()} window wrapper, so it's exercisable  
    // ── helpers ─────────────────────────────────────────────────────────────
import java.io.IOException;
                );
            if (Double.compare(e, a) != 0) {  
 * {@code CalciteBinCommandIT}'s observed behaviour in the {@code sql}
 * the analytics-engine route. Exercises PPL's {@code bin <field> span=N}
        );
            row((Object) null)  
 *  
            row("10-15"),  
