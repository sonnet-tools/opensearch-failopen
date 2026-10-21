    //   6.71, 7.43, 9.78, ... → "5-10"
            if (Double.compare(e, a) != 0) {
    public void testBinSpanFractionalSpanUsesDecimalFormat() throws IOException {
 * {@code span=N} path emits {@code span_bucket(field, span)} directly
            return;
    // fall in "5-10".
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
 * The OpenSearch Contributors require contributions made to
    public void testBinSpanPreservesNullsInNullableField() throws IOException {
        assertEquals("unexpected bucket label", expectedLabel, row.get(1));
    //   -3.5  → "-5-0"
    //   15.7  → "15-20"
 * {@code span_bucket} SqlFunction &rarr;
    //   null  → null
            row("10-15"),
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            }
    //
 * without a {@code MIN/MAX OVER ()} window wrapper, so it's exercisable
            row("0-5"),
import java.util.Arrays;
import java.util.List;
        );
}
    }
            row("5-10"),
            "source=" + DATASET.indexName + " | bin num1 span=5 | stats count() as c by num1 | sort num1"
import org.opensearch.client.Request;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.client.Response;
    //   "10-15": 5  (11.38, 12.4, 10.32, 12.05, 10.37)
            "source=" + DATASET.indexName + " | bin num1 span=2.5 | fields num1 | head 3",
    //   2.47 → "0-5"
    private static List<Object> row(Object... values) {
    // usable as a grouping key. Distribution for num1 at span=5:
    // `bin num1 span=2.5` — span is a literal float, spans the non-integer
        assertBucket(rows.get(0), "0-5", 1);
            row("-15--10"),
 * {@code rust/src/udf/span_bucket.rs} returns the VARCHAR bucket label.
        // PPL stats emits (aggregate, groupingKey) column order.
    }
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
/*
    //   null  → null (preserved)
            List<Object> want = expected[i];
    }
    //   -15.7 → "-20--15"
            double e = ((Number) expected).doubleValue();
            row("7.5-10.0"),
    //   8.42 → floor(8.42/2.5)*2.5 = 7.5, binEnd=10.0 → "7.5-10.0"
                assertCellEquals(
/**
 * DataFusion resolves the {@code span_bucket} Rust UDF by name &rarr;
 * {@link org.opensearch.be.datafusion.SpanBucketAdapter} rewrites to local
        @SuppressWarnings("unchecked")
    //   "5-10": 9   (8.42, 6.71, 9.78, 7.43, 9.05, 9.38, 9.47, 7.1, 7.12)
    @Override
 * this file be licensed under the Apache-2.0 license or a
 * {@code BinCommand} AST &rarr;
        assertBucket(rows.get(1), "10-15", 5);
 * {@code NumericSpanHelper.createNumericSpanExpression} &rarr;
    // `num1` has no nulls; values ∈ [2.47, 16.81]. `bin num1 span=5` labels:
        @SuppressWarnings("unchecked")
            row((Object) null)
        assertRows(
                    got.get(j)
    protected void onBeforeQuery() throws IOException {
                want.size(),
 * {@code span_bucket} UDF (via
    }
    //   12.3  → "10-15"
            row("5-10"),
            row("-5-0"),
    }
 * <p>Pipeline:
            row("5-10")
    //
        );
    // Head 5 of the natural calcs order (8.42, 6.71, 9.78, 7.43, 9.05) all
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            List<Object> got = actualRows.get(i);
            row("5-10"),
        if (dataProvisioned == false) {
 * PPL {@code bin f span=N} &rarr;
    //   "15-20": 2  (16.42, 16.81)
        assertEquals(message, expected, actual);
        if (expected instanceof Number && actual instanceof Number) {
        );
    //   6.71 → floor(2.684)*2.5 = 5.0, binEnd=7.5 → "5.0-7.5"
        }
    //   0     → "0-5"
 * compatible open source license.
        Map<String, Object> response = executePpl(ppl);
    //   11.38, 12.4, ... → "10-15"
    public void testBinSpanAsGroupingKey() throws IOException {
            row("0-5"),
    //   9.78 → floor(3.912)*2.5 = 7.5 → "7.5-10.0"
 * <p>Unlike the other {@code *_bucket} functions (width/minspan/range), the
            }
package org.opensearch.analytics.qa;
 * {@code org.opensearch.sql.calcite.utils.binning.handlers.NumericSpanHelper}).
    // path of the formatter (1dp since span >= 1.0).
        assertEquals("4 distinct bucket labels expected", 4, rows.size());
 * bucket label (same column name, VARCHAR type) — matching
 * <p>The {@code bin} command REPLACES the original field column with the
        assertRows(
    }
            );
    private static boolean dataProvisioned = false;
    //   "0-5": 1    (2.47)
    // ── helpers ─────────────────────────────────────────────────────────────
            "source=" + DATASET.indexName + " | bin num1 span=5 | fields num1 | head 5",
    }
            row("10-15"),
    public void testBinSpanOnDoubleFieldProducesBucketLabel() throws IOException {
public class SpanBucketCommandIT extends AnalyticsRestTestCase {
    //
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
 * isthmus resolves via {@code ADDITIONAL_SCALAR_SIGS} &rarr;
            for (int j = 0; j < want.size(); j++) {
 * the analytics-engine route. Exercises PPL's {@code bin <field> span=N}
    //
 * syntax, which is the only user-facing surface that emits the
                got.size()
 *
        assertRows(
            double a = ((Number) actual).doubleValue();
        );
 */
            row("15-20"),
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
        }
 * {@code SPAN_BUCKET(field, span)} RexNode &rarr;
            row("-20--15"),
        assertBucket(rows.get(2), "15-20", 2);
import java.io.IOException;
            "source=" + DATASET.indexName + " | bin num0 span=5 | fields num0 | head 10",
            row("5-10"),
        Map<String, Object> response = executePpl(
        assertEquals("unexpected count for bucket " + expectedLabel, expectedCount, ((Number) row.get(0)).longValue());
            assertEquals(
        assertBucket(rows.get(3), "5-10", 9);
    // Feeds `bin` into `stats count()` to verify the VARCHAR column is
    // ── Fractional span uses decimal formatting ─────────────────────────────
    @SuppressWarnings("varargs")
        }
            row("7.5-10.0")
    @SafeVarargs
    // ── Null-value propagation via `bin` on a nullable field ────────────────
        for (int i = 0; i < expected.length; i++) {
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
 * {@code CalciteBinCommandIT}'s observed behaviour in the {@code sql}
            row("5.0-7.5"),
import java.util.Map;
    private static void assertBucket(List<Object> row, String expectedLabel, long expectedCount) {
            dataProvisioned = true;
            row((Object) null),
            DatasetProvisioner.provision(client(), DATASET);
            assertEquals(message, expected, actual);
    }
 * Self-contained integration test for the PPL {@code span_bucket} scalar on
    //   10    → "10-15"
    }
    // ── Aggregating over bucket labels ──────────────────────────────────────
    //   16.42, 16.81 → "15-20"
    //   -12.3 → floor(-12.3/5)*5 = -15 → "-15--10"
 *
    // num0 goes null at key07. `bin num0 span=5` must preserve nulls.
                );
        }
    private static void assertCellEquals(String message, Object expected, Object actual) {
        return Arrays.asList(values);
    // ── Integer span on a non-null double field ─────────────────────────────
            return;
 */
 *
        if (expected == null || actual == null) {
    // Lexicographic sort on the VARCHAR label: "0-5", "10-15", "15-20", "5-10".
 * repository.
 *
 * end-to-end without empty-partition window pushdown support.
                    want.get(j),
                "Column count mismatch at row " + i + " for query: " + ppl,
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    //   3.5   → "0-5"
        assertNotNull("rows missing", rows);
