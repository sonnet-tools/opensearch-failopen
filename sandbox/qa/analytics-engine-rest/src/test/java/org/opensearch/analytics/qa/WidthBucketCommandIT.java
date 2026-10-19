 * which the physical planner can handle.
        Map<String, Object> response = executePpl(ppl);  
            for (int j = 0; j < want.size(); j++) {
    // floor(_/10)*10 boundary), so the labels listed below match both.
    // non-null range [-15.7, 15.7] → range=31.4. target_width = 3.14,  
            row("0-10"),  
    public void testBinBinsParameterBucketsValues() throws IOException {
            row("0-10"),  
 * window aggregates. End-to-end pushdown works once {@code OpenSearchProject}'s  
    @Override
            "source=" + DATASET.indexName + " | bin num1 bins=10 | stats count() as c by num1 | sort num1"
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        assertEquals("2 distinct buckets expected", 2, rows.size());  
    // num1 < 10: 8.42, 6.71, 9.78, 7.43, 9.05, 9.38, 9.47, 2.47, 7.1, 7.12 → 10
import org.opensearch.client.Request;
 * variant (returns e.g. {@code "0-100"}) via the OpenSearch nice-number
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
 *
    // determine `width`, not the bin offset. PPL's java-side WidthBucket
    @SafeVarargs  
    //
 * <p>{@code CountBinHandler} wraps {@code data_range} and {@code max_value} in
    //   Every num1 < 10 → "0-10"; num1 ≥ 10 → "10-20".
 */  
    //   "0-10":  12 rows (all num1 < 10)  
 * {@code org.opensearch.sql.calcite.utils.binning.handlers.CountBinHandler}).
    }
                    got.get(j)
    //    0   → floor(0)*10    = 0 → "0-10"  
        assertEquals("unexpected count for bucket " + expectedLabel, expectedCount, ((Number) row.get(0)).longValue());
 * SPDX-License-Identifier: Apache-2.0
            row("0-10"),
            row("-20--10"),  
    //   12.3 → floor(1.23)*10 = 10 → "10-20"  
        if (dataProvisioned == false) {
    //   12.4, 10.32, 2.47, 12.05, 10.37, 7.1, 16.81, 7.12.
            "source=" + DATASET.indexName + " | bin num1 bins=10 | fields num1 | head 5",
        );
            row("-10-0"),
    // num1 ≥ 10: 16.42, 11.38, 12.4, 10.32, 12.05, 10.37, 16.81 → 7  
    // num1's data range [~2.47, 16.81]. Running through Java's width_bucket
import java.io.IOException;
        assertRows(  
    private static void assertCellEquals(String message, Object expected, Object actual) {  
    //   range ≈ 14.34, target_width = 1.434, exponent=ceil(log10(1.434))=1  
    // ── Null-value propagation ──────────────────────────────────────────────  
    }
            row((Object) null)  
    // `floor(value/width)*width` differs from `first_bin_start + idx*width`
import org.opensearch.client.Response;
 */
    protected void onBeforeQuery() throws IOException {  
 * then auto-lifts the top-level WindowFunction into a {@code LogicalWindow}  
    }
    //   max=16.81 not on boundary → no bump. 2 > 10 false → width stays 10.
    //  -12.3 → floor(-1.23)*10 = -20 → "-20--10"
    //   null → null (preserved by UDF's null-input short-circuit)
    //   → width = 10. actualBins = ceil(14.34/10) = 2.
        @SuppressWarnings("unchecked")
            row("10-20"),  
    //
    // Per-row mapping uses the data-node UDF's per-value formula
    //   "10-20": 5 rows (10.32, 10.37, 11.38, 12.05, 12.4, 16.42, 16.81 →
            DatasetProvisioner.provision(client(), DATASET);
    //   8.42, 6.71, 9.78, 7.43, 9.05 → all "0-10".
        );
    // bump; actualBins = ceil(31.4/10) = 4 ≤ 10 so width stays 10.
                assertCellEquals(
        assertBucket(rows.get(0), "0-10", 10);
    //
            double e = ((Number) expected).doubleValue();  
    // The min/max OVER () operands are inputs to optimal_width only — they  
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
            row("-20--10"),
 * {@link org.opensearch.be.datafusion.WidthBucketAdapter}'s Javadoc.  
    public void testBinBinsPreservesNullsInNullableField() throws IOException {  
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,  
            );  
    }
    //  -15.7 → floor(-1.57)*10 = -20 → "-20--10"  
    private static List<Object> row(Object... values) {  
                want.size(),
        assertBucket(rows.get(1), "10-20", 7);  
        }  
 * {@code liftNestedRexOver} helper for details. DataFusion's substrait consumer
    // bin_start = floor(value / width) * width (rust/src/udf/width_bucket.rs).
    // ── `bin bins=N` is an aggregation-like operation — label distribution
 * Self-contained integration test for the PPL {@code width_bucket} scalar
package org.opensearch.analytics.qa;
import java.util.Arrays;
 * {@code MIN(field) OVER ()} / {@code MAX(field) OVER ()} empty-partition
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
                got.size()
            row("10-20"),
            List<Object> want = expected[i];  
    //  
            List<Object> got = actualRows.get(i);
            }
        }
    // function uses a different `adj = value - first_bin_start` form; both
            row("0-10"),
        if (expected == null || actual == null) {
    // `bin num1 bins=10` invokes CountBinHandler with num_bins=10 over  
 * pre-substrait lift hoists the nested RexOver into a child Project — see the
            return;  
            return;
            row("10-20"),
        );
            row("0-10")  
    private static void assertBucket(List<Object> row, String expectedLabel, long expectedCount) {
                "Column count mismatch at row " + i + " for query: " + ppl,  
 * The OpenSearch Contributors require contributions made to  
        return Arrays.asList(values);
            dataProvisioned = true;  
/**  
            assertEquals(
        }
 *
    }
    // exponent=ceil(log10(3.14))=1 → width=10. max=15.7 not on boundary → no
    //   15.7 → floor(1.57)*10 = 10 → "10-20"
    // distribute as:
    // num0 has nulls from key07. `bin num0 bins=10` computes width from the
    //            actually 7 rows; let me recount)
        }
    // ── helpers ─────────────────────────────────────────────────────────────
import java.util.Map;
 * bins=N} syntax, which is the only user-facing surface that emits the  
}  
    public void testBinBinsParameterDistributesRowsCorrectly() throws IOException {
    // ── Happy path: bin <field> bins=N ─────────────────────────────────────
 * <p>Not the ISO-SQL {@code width_bucket}. This is PPL's VARCHAR-label  
import java.util.List;  
    //   first_bin_start = floor(0/10)*10 = 0.  
            double a = ((Number) actual).doubleValue();
            row((Object) null),
    // num1 values: 8.42, 6.71, 9.78, 7.43, 9.05, 9.38, 16.42, 11.38, 9.47,  
 * this file be licensed under the Apache-2.0 license or a
public class WidthBucketCommandIT extends AnalyticsRestTestCase {
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    // `bin num1 bins=10` → width=10 (computed as above). The 17 rows of num1
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");  
/*  
 * algorithm, documented extensively in
 *  
    // Total: 17 ✓
                );  
    //    10  → floor(1)*10 = 10 → "10-20"
    }
    // when `first_bin_start` is not a multiple of `width`. For width=10 the
    // formulae coincide (every multiple-of-10 boundary is also a  
 * {@code width_bucket} UDF (via
        Map<String, Object> response = executePpl(  
    }
    private static boolean dataProvisioned = false;  
    //   -3.5 → floor(-0.35)*10 = -10 → "-10-0"
            row("0-10"),
        assertEquals("unexpected bucket label", expectedLabel, row.get(1));  
            row("0-10"),
 * on the analytics-engine route. Exercises PPL's {@code bin <field>
        assertRows(
        if (expected instanceof Number && actual instanceof Number) {
 * compatible open source license.
                    want.get(j),
    //    3.5 → floor(0.35)*10 = 0 → "0-10"
        assertNotNull("rows missing", rows);
        for (int i = 0; i < expected.length; i++) {
    }  
        // Lex-sort on VARCHAR: "0-10", "10-20".
    // algorithm with those (approximate) bounds:
        assertEquals(message, expected, actual);
            }
    //
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);  
            "source=" + DATASET.indexName + " | bin num0 bins=10 | fields num0 | head 10",
    //  
    // Expected labels for head 5 of natural calcs order (all < 10):  
            if (Double.compare(e, a) != 0) {
    @SuppressWarnings("varargs")
            assertEquals(message, expected, actual);
    //    across the full dataset reflects the bucketing. ───────────────────
        @SuppressWarnings("unchecked")  
    // produce the same labels EXCEPT for values whose  
