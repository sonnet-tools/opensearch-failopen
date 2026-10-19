    // ── Happy path: bin <field> minspan=N ──────────────────────────────────  
            row("-20--10"),
            row("0-10"),  
        assertBucket(rows.get(0), "0-10", 10);
            }
    //   12.3 →  10 → "10-20"
            row((Object) null),
            );
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
 * Self-contained integration test for the PPL {@code minspan_bucket} scalar
        return Arrays.asList(values);
            "source=" + DATASET.indexName + " | bin num1 minspan=3 | stats count() as c by num1 | sort num1"
 * on the analytics-engine route. Exercises PPL's {@code bin <field>
 * this file be licensed under the Apache-2.0 license or a
        if (dataProvisioned == false) {  
    }  
    // the same width=10.
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
    @Override
    //   10   →  10 → "10-20"  
            dataProvisioned = true;
    //  
            row("0-10")
        if (expected == null || actual == null) {
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
    @SafeVarargs
    public void testBinMinspanDistributesRowsCorrectly() throws IOException {  
        if (expected instanceof Number && actual instanceof Number) {  
 * {@code minspan_bucket} UDF (via
import java.util.List;  
            return;  
            row("0-10"),
 * SPDX-License-Identifier: Apache-2.0
 */  
                want.size(),
        assertBucket(rows.get(1), "10-20", 7);  
        assertEquals("unexpected bucket label", expectedLabel, row.get(1));
                );
            row("10-20"),  
    // `bin num1 minspan=3` invokes MinSpanBinHandler with min_span=3 over
            if (Double.compare(e, a) != 0) {  
    }
 * {@code org.opensearch.sql.calcite.utils.binning.handlers.MinSpanBinHandler}).
    protected void onBeforeQuery() throws IOException {
import org.opensearch.client.Response;
    // WidthBucketCommandIT.testBinBinsPreservesNullsInNullableField — the  
    //   10 >= 3 → use default_width = 10.
import org.opensearch.client.Request;
    // (rust/src/udf/minspan_bucket.rs). Same shape as
    // `bin num0 minspan=3` over num0's range [-15.7, 15.7] ≈ 31.4. The
        );
    }  
            row((Object) null)
                "Column count mismatch at row " + i + " for query: " + ppl,
    //   default_width = 10^floor(log10(14.34)) = 10  
    // from floor(value/width)*width.
    //   -3.5 → -10 → "-10-0"  
import java.io.IOException;
    // ── helpers ─────────────────────────────────────────────────────────────
            List<Object> got = actualRows.get(i);
    private static void assertBucket(List<Object> row, String expectedLabel, long expectedCount) {
        );
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    public void testBinMinspanParameterBucketsValues() throws IOException {
/**  
    //   15.7 →  10 → "10-20"  
    // num1's observed data range [~2.47, 16.81] ≈ 14.34.  
    // Labels for num1:  
import java.util.Map;
 *
    //  -15.7 → -20 → "-20--10"
        }  
        assertEquals("unexpected count for bucket " + expectedLabel, expectedCount, ((Number) row.get(0)).longValue());  
    //   null → null
 * in {@code MIN(field) OVER ()} / {@code MAX(field) OVER ()} empty-partition
import java.util.Arrays;
    //   8.42 → "0-10", 6.71 → "0-10", 9.78 → "0-10" (all < 10)
    // ── Null-value propagation ──────────────────────────────────────────────  
 * window aggregates. End-to-end pushdown works once {@code OpenSearchProject}'s  
    // min/max OVER () operands feed optimal_width only; bin offset comes
        assertEquals(message, expected, actual);
    //
public class MinspanBucketCommandIT extends AnalyticsRestTestCase {
            assertEquals(  
    private static List<Object> row(Object... values) {
        for (int i = 0; i < expected.length; i++) {  
 *  
                    got.get(j)  
    //   first_bin_start = floor(2.47/10)*10 = 0.
    //  
    //
/*  
    }  
        @SuppressWarnings("unchecked")
        }
            double e = ((Number) expected).doubleValue();
            row("-10-0"),  
            row("0-10"),
            row("0-10"),
            row("-20--10"),
                    want.get(j),
 * {@code liftNestedRexOver} helper for details.
        @SuppressWarnings("unchecked")
        }
 * compatible open source license.
 * <p>{@code MinSpanBinHandler} wraps {@code data_range} and {@code max_value}
                got.size()  
            "source=" + DATASET.indexName + " | bin num0 minspan=3 | fields num0 | head 10",  
            }
        Map<String, Object> response = executePpl(
    //    3.5 →   0 → "0-10"
            List<Object> want = expected[i];
            for (int j = 0; j < want.size(); j++) {
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    //  -12.3 → -20 → "-20--10"
    }
 * The OpenSearch Contributors require contributions made to  
    private static void assertCellEquals(String message, Object expected, Object actual) {
            row("10-20"),  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
 * minspan=N} syntax, the only user-facing surface that emits the  
    @SuppressWarnings("varargs")
        );  
        }  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
    // Java algorithm:
 */  
            row("10-20"),
                assertCellEquals(  
            assertEquals(message, expected, actual);  
    //   minspan_width = 10^ceil(log10(3)) = 10
 * pre-substrait lift hoists the nested RexOver into a child Project — see the
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
            double a = ((Number) actual).doubleValue();
        Map<String, Object> response = executePpl(ppl);
}
    //    0   →   0 → "0-10"
    // minspan=3 and ≥ range/MAX_BINS).
package org.opensearch.analytics.qa;
    //
    private static boolean dataProvisioned = false;
        assertEquals("2 distinct buckets expected", 2, rows.size());
            "source=" + DATASET.indexName + " | bin num1 minspan=3 | fields num1 | head 3",
    }  
    public void testBinMinspanPreservesNullsInNullableField() throws IOException {
        assertRows(
    // Same 10/7 split as `bin bins=10` given the chosen minspan produces
    // bin_start = floor(value / width) * width
    }
    // ── Distribution across full dataset ────────────────────────────────────
        assertNotNull("rows missing", rows);  
            DatasetProvisioner.provision(client(), DATASET);
    }
    // optimal_width helper picks width=10 (smallest power of 10 that is ≥  
    // Per-row mapping uses the data-node UDF's per-value formula  
        assertRows(  
            return;
