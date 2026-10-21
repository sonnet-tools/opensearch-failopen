            "source=" + DATASET.indexName + " | bin num1 bins=10 | stats count() as c by num1 | sort num1"
    // num1 ≥ 10: 16.42, 11.38, 12.4, 10.32, 12.05, 10.37, 16.81 → 7
    // non-null range [-15.7, 15.7] → range=31.4. target_width = 3.14,
    private static List<Object> row(Object... values) {
    //    0   → floor(0)*10    = 0 → "0-10"
 * The OpenSearch Contributors require contributions made to
            double a = ((Number) actual).doubleValue();
    //   12.3 → floor(1.23)*10 = 10 → "10-20"
        assertEquals("2 distinct buckets expected", 2, rows.size());
    //   "10-20": 5 rows (10.32, 10.37, 11.38, 12.05, 12.4, 16.42, 16.81 →
    // bin_start = floor(value / width) * width (rust/src/udf/width_bucket.rs).
 * this file be licensed under the Apache-2.0 license or a
                got.size()
        }
            row("0-10"),
 * then auto-lifts the top-level WindowFunction into a {@code LogicalWindow}
        assertRows(
            row("0-10"),
 * compatible open source license.
    //
 *
    private static void assertCellEquals(String message, Object expected, Object actual) {
        assertBucket(rows.get(0), "0-10", 10);
    // Per-row mapping uses the data-node UDF's per-value formula
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        if (expected instanceof Number && actual instanceof Number) {
    @SafeVarargs
        assertEquals("unexpected bucket label", expectedLabel, row.get(1));
    //    3.5 → floor(0.35)*10 = 0 → "0-10"
    // Expected labels for head 5 of natural calcs order (all < 10):
            List<Object> got = actualRows.get(i);
/*
            dataProvisioned = true;
        // Lex-sort on VARCHAR: "0-10", "10-20".
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
import org.opensearch.client.Request;
            row("-10-0"),
    public void testBinBinsParameterBucketsValues() throws IOException {
        }
            row((Object) null)
 * <p>{@code CountBinHandler} wraps {@code data_range} and {@code max_value} in
package org.opensearch.analytics.qa;
            for (int j = 0; j < want.size(); j++) {
 * pre-substrait lift hoists the nested RexOver into a child Project — see the
    public void testBinBinsParameterDistributesRowsCorrectly() throws IOException {
    // when `first_bin_start` is not a multiple of `width`. For width=10 the
            row((Object) null),
 *
    // function uses a different `adj = value - first_bin_start` form; both
    // ── Happy path: bin <field> bins=N ─────────────────────────────────────
    //   first_bin_start = floor(0/10)*10 = 0.
import org.opensearch.client.Response;
    // formulae coincide (every multiple-of-10 boundary is also a
    //   → width = 10. actualBins = ceil(14.34/10) = 2.
    @SuppressWarnings("varargs")
    // `bin num1 bins=10` → width=10 (computed as above). The 17 rows of num1
    //
            return;
        assertBucket(rows.get(1), "10-20", 7);
    // bump; actualBins = ceil(31.4/10) = 4 ≤ 10 so width stays 10.
        }
    // distribute as:
    //
    // floor(_/10)*10 boundary), so the labels listed below match both.
 * algorithm, documented extensively in
    //   max=16.81 not on boundary → no bump. 2 > 10 false → width stays 10.
 * SPDX-License-Identifier: Apache-2.0
            double e = ((Number) expected).doubleValue();
        @SuppressWarnings("unchecked")
    }
    // produce the same labels EXCEPT for values whose
    //
        Map<String, Object> response = executePpl(
    //   null → null (preserved by UDF's null-input short-circuit)
public class WidthBucketCommandIT extends AnalyticsRestTestCase {
    }
    }
 * variant (returns e.g. {@code "0-100"}) via the OpenSearch nice-number
            row("10-20"),
            return;
/**
        @SuppressWarnings("unchecked")
    @Override
            row("0-10")
            row("-20--10"),
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        assertEquals("unexpected count for bucket " + expectedLabel, expectedCount, ((Number) row.get(0)).longValue());
    //   15.7 → floor(1.57)*10 = 10 → "10-20"
    // The min/max OVER () operands are inputs to optimal_width only — they
            row("-20--10"),
    //   Every num1 < 10 → "0-10"; num1 ≥ 10 → "10-20".
    //
            if (Double.compare(e, a) != 0) {
            row("0-10"),
    //    10  → floor(1)*10 = 10 → "10-20"
            row("10-20"),
    protected void onBeforeQuery() throws IOException {
    // ── helpers ─────────────────────────────────────────────────────────────
    }
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
            row("0-10"),
        assertNotNull("rows missing", rows);
    //   range ≈ 14.34, target_width = 1.434, exponent=ceil(log10(1.434))=1
                    got.get(j)
                "Column count mismatch at row " + i + " for query: " + ppl,
            assertEquals(message, expected, actual);
 * which the physical planner can handle.
    //            actually 7 rows; let me recount)
    private static boolean dataProvisioned = false;
            "source=" + DATASET.indexName + " | bin num0 bins=10 | fields num0 | head 10",
    }
 * bins=N} syntax, which is the only user-facing surface that emits the
        Map<String, Object> response = executePpl(ppl);
    //   "0-10":  12 rows (all num1 < 10)
            assertEquals(
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            }
    // num1 values: 8.42, 6.71, 9.78, 7.43, 9.05, 9.38, 16.42, 11.38, 9.47,
        if (expected == null || actual == null) {
    public void testBinBinsPreservesNullsInNullableField() throws IOException {
    //   -3.5 → floor(-0.35)*10 = -10 → "-10-0"
        for (int i = 0; i < expected.length; i++) {
 * <p>Not the ISO-SQL {@code width_bucket}. This is PPL's VARCHAR-label
 * window aggregates. End-to-end pushdown works once {@code OpenSearchProject}'s
            "source=" + DATASET.indexName + " | bin num1 bins=10 | fields num1 | head 5",
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    // algorithm with those (approximate) bounds:
 * {@code liftNestedRexOver} helper for details. DataFusion's substrait consumer
    //   12.4, 10.32, 2.47, 12.05, 10.37, 7.1, 16.81, 7.12.
    //   8.42, 6.71, 9.78, 7.43, 9.05 → all "0-10".
        return Arrays.asList(values);
import java.util.Map;
import java.util.List;
 */
        );
    //  -15.7 → floor(-1.57)*10 = -20 → "-20--10"
    // ── `bin bins=N` is an aggregation-like operation — label distribution
            );
    //
    // determine `width`, not the bin offset. PPL's java-side WidthBucket
    // ── Null-value propagation ──────────────────────────────────────────────
        if (dataProvisioned == false) {
 */
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
        assertRows(
    // `floor(value/width)*width` differs from `first_bin_start + idx*width`
    // num0 has nulls from key07. `bin num0 bins=10` computes width from the
    //  -12.3 → floor(-1.23)*10 = -20 → "-20--10"
        );
                want.size(),
    private static void assertBucket(List<Object> row, String expectedLabel, long expectedCount) {
 * {@code org.opensearch.sql.calcite.utils.binning.handlers.CountBinHandler}).
import java.io.IOException;
import java.util.Arrays;
            List<Object> want = expected[i];
            row("10-20"),
    }
            }
 * {@code width_bucket} UDF (via
 * {@link org.opensearch.be.datafusion.WidthBucketAdapter}'s Javadoc.
        assertEquals(message, expected, actual);
    }
    // Total: 17 ✓
    //    across the full dataset reflects the bucketing. ───────────────────
}
 * on the analytics-engine route. Exercises PPL's {@code bin <field>
 * Self-contained integration test for the PPL {@code width_bucket} scalar
 * {@code MIN(field) OVER ()} / {@code MAX(field) OVER ()} empty-partition
                    want.get(j),
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
            row("0-10"),
    }
                assertCellEquals(
            DatasetProvisioner.provision(client(), DATASET);
                );
        }
    // num1 < 10: 8.42, 6.71, 9.78, 7.43, 9.05, 9.38, 9.47, 2.47, 7.1, 7.12 → 10
    // `bin num1 bins=10` invokes CountBinHandler with num_bins=10 over
 *
        );
    // exponent=ceil(log10(3.14))=1 → width=10. max=15.7 not on boundary → no
            row("0-10"),
    // num1's data range [~2.47, 16.81]. Running through Java's width_bucket
