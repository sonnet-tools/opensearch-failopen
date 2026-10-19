        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            row("0-10"),  
    //   effective_max = max(100, 15.7) = 100
import java.util.Arrays;
        assertRows(
                want.size(),
    //    0   → adj=100, idx=1, bin=0 → "0-100"  
        @SuppressWarnings("unchecked")
            return;  
    //  -15.7 → adj=84.3, idx=0, bin=-100 → "-100-0"  
 * pre-substrait lift hoists the nested RexOver into a child Project — see the
    // `bin num1 start=0 end=100` — width=10, every num1 value ∈ [2.47, 16.81]
    protected void onBeforeQuery() throws IOException {
public class RangeBucketCommandIT extends AnalyticsRestTestCase {
            "source=" + DATASET.indexName + " | bin num0 start=-100 end=100 | fields num0 | head 10",  
        if (expected == null || actual == null) {
    //   effective_min = min(-100, -15.7) = -100
    // ── Distribution across full dataset ────────────────────────────────────
    // first_bin_start = floor(0/10)*10 = 0.
            row("-100-0"),
    public void testBinStartEndDistributesRowsCorrectly() throws IOException {
    //   8.42 → bin_index=0, bin_start=0, bin_end=10 → "0-10"
}
 * compatible open source license.
    }
/*  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
        }  
            row("0-100"),  
    public void testBinStartEndBucketsValuesIntoExpandedRange() throws IOException {  
            for (int j = 0; j < want.size(); j++) {
    @SafeVarargs
                    got.get(j)  
    // ── Happy path: bin <field> start=X end=Y ───────────────────────────────  
 */  
            row((Object) null)
    //   -3.5 → adj=96.5, idx=0, bin=-100 → "-100-0"
                );
package org.opensearch.analytics.qa;
    private static void assertBucket(List<Object> row, String expectedLabel, long expectedCount) {
    }
            double a = ((Number) actual).doubleValue();
        if (expected instanceof Number && actual instanceof Number) {  
            row("0-10"),
    // range = 100 → exact power of 10 → width = 10^(2-1) = 10.
 *
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    }  
        }
        Map<String, Object> response = executePpl(ppl);
            List<Object> got = actualRows.get(i);
import java.util.List;  
import org.opensearch.client.Request;
 * <p>{@code RangeBinHandler} wraps {@code data_min} / {@code data_max} in
    private static void assertCellEquals(String message, Object expected, Object actual) {
    //    10  → adj=110, idx=1, bin=0 → "0-100"
    //   range = 200 (not power of 10) → width = 10^floor(log10(200)) = 100.  
 * SPDX-License-Identifier: Apache-2.0
            List<Object> want = expected[i];
    //   6.71, 9.78, 7.43, 9.05 → all "0-10".
 * The OpenSearch Contributors require contributions made to  
    }  
                    want.get(j),
            DatasetProvisioner.provision(client(), DATASET);
    //   effective_min = min(0, 2.47) = 0 (start=0 expands down)
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
            );
    //    3.5 → adj=103.5, idx=1, bin=0 → "0-100"
    //   12.3 → adj=112.3, idx=1, bin=-100+100=0 → "0-100"  
    // `bin num0 start=-100 end=100` over num0's range [-15.7, 15.7].  
    // `bin num1 start=0 end=100` invokes RangeBinHandler with start=0,
 * {@code liftNestedRexOver} helper for details.
    //   15.7 → adj=115.7, idx=1, bin=0 → "0-100"
                assertCellEquals(  
                got.size()  
            row("0-100"),
            row("0-100"),  
        );
 * {@code MIN(field) OVER ()} / {@code MAX(field) OVER ()} empty-partition
        assertNotNull("rows missing", rows);
import java.io.IOException;
            row("0-100"),
    // 7 rows).  
    }  
    private static boolean dataProvisioned = false;
        for (int i = 0; i < expected.length; i++) {  
/**  
            row("0-10"),
            }
    // Labels:
        if (dataProvisioned == false) {  
        assertBucket(rows.get(0), "0-10", 10);  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
 * start=X end=Y} syntax, the only user-facing surface that emits the  
        }  
    public void testBinStartEndPreservesNullsInNullableField() throws IOException {
        }
        assertEquals("unexpected bucket label", expectedLabel, row.get(1));
            double e = ((Number) expected).doubleValue();
    // ── helpers ─────────────────────────────────────────────────────────────
            row("-100-0"),
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
        assertEquals("2 distinct buckets expected", 2, rows.size());
            assertEquals(message, expected, actual);  
    //
import java.util.Map;
        @SuppressWarnings("unchecked")
 * this file be licensed under the Apache-2.0 license or a
            row((Object) null),
        assertRows(
    }  
 * {@code range_bucket} UDF (via
            row("-100-0"),  
            }
    // Labels for num1:  
        assertEquals(message, expected, actual);
 */  
                "Column count mismatch at row " + i + " for query: " + ppl,
    //  
        );
    @Override
            row("0-10"),  
    //   first_bin_start = floor(-100/100)*100 = -100.
            assertEquals(  
 * on the analytics-engine route. Exercises PPL's {@code bin <field>
    }
    //   effective_max = max(100, 16.81) = 100 (end=100 expands up)  
    // ── Null-value propagation ──────────────────────────────────────────────
            "source=" + DATASET.indexName + " | bin num1 start=0 end=100 | stats count() as c by num1 | sort num1"  
            row("0-10")
    //    null → null
    //
        );
    //  -12.3 → adj=87.7, idx=0, bin=-100 → "-100-0"
        assertEquals("unexpected count for bucket " + expectedLabel, expectedCount, ((Number) row.get(0)).longValue());  
    // Effective bounds (expansion-only):
            return;
 * window aggregates. End-to-end pushdown works once {@code OpenSearchProject}'s  
            row("0-100"),
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {  
            "source=" + DATASET.indexName + " | bin num1 start=0 end=100 | fields num1 | head 5",
            dataProvisioned = true;
        return Arrays.asList(values);
        assertBucket(rows.get(1), "10-20", 7);
    // falls in either "0-10" (num1 < 10, 10 rows) or "10-20" (num1 ≥ 10,
    }
        Map<String, Object> response = executePpl(
    // end=100 over num1's observed range [~2.47, 16.81].  
 * {@code org.opensearch.sql.calcite.utils.binning.handlers.RangeBinHandler}).
            if (Double.compare(e, a) != 0) {  
    @SuppressWarnings("varargs")
    //    null → null  
 * Self-contained integration test for the PPL {@code range_bucket} scalar
 *  
import org.opensearch.client.Response;
    private static List<Object> row(Object... values) {
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
