    protected void onBeforeQuery() throws IOException {
    // first_bin_start = floor(0/10)*10 = 0.
 * Self-contained integration test for the PPL {@code range_bucket} scalar
                assertCellEquals(
    // `bin num0 start=-100 end=100` over num0's range [-15.7, 15.7].
    }
    // `bin num1 start=0 end=100` invokes RangeBinHandler with start=0,
    //   12.3 → adj=112.3, idx=1, bin=-100+100=0 → "0-100"
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    //    0   → adj=100, idx=1, bin=0 → "0-100"
    //   6.71, 9.78, 7.43, 9.05 → all "0-10".
        }
    private static boolean dataProvisioned = false;
    //    10  → adj=110, idx=1, bin=0 → "0-100"
    // end=100 over num1's observed range [~2.47, 16.81].
    // Labels:
    //   8.42 → bin_index=0, bin_start=0, bin_end=10 → "0-10"
            double e = ((Number) expected).doubleValue();
    //   effective_min = min(-100, -15.7) = -100
    }
    @SafeVarargs
        @SuppressWarnings("unchecked")
import java.util.List;
    // falls in either "0-10" (num1 < 10, 10 rows) or "10-20" (num1 ≥ 10,
            return;
    public void testBinStartEndBucketsValuesIntoExpandedRange() throws IOException {
 *
            "source=" + DATASET.indexName + " | bin num1 start=0 end=100 | fields num1 | head 5",
                got.size()
        assertEquals(message, expected, actual);
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        return Arrays.asList(values);
    //
                );
    public void testBinStartEndDistributesRowsCorrectly() throws IOException {
            row("0-10"),
        assertBucket(rows.get(1), "10-20", 7);
import org.opensearch.client.Request;
        );
        assertEquals("2 distinct buckets expected", 2, rows.size());
package org.opensearch.analytics.qa;
            for (int j = 0; j < want.size(); j++) {
 * window aggregates. End-to-end pushdown works once {@code OpenSearchProject}'s
    //   first_bin_start = floor(-100/100)*100 = -100.
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
 *
    //   effective_min = min(0, 2.47) = 0 (start=0 expands down)
        );
            List<Object> want = expected[i];
        }
        for (int i = 0; i < expected.length; i++) {
            row("0-100"),
public class RangeBucketCommandIT extends AnalyticsRestTestCase {
 * start=X end=Y} syntax, the only user-facing surface that emits the
            row("0-10"),
 * {@code range_bucket} UDF (via
/**
    //   effective_max = max(100, 16.81) = 100 (end=100 expands up)
        assertNotNull("rows missing", rows);
        assertEquals("unexpected count for bucket " + expectedLabel, expectedCount, ((Number) row.get(0)).longValue());
    @Override
        assertRows(
    }
            double a = ((Number) actual).doubleValue();
        assertRows(
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            List<Object> got = actualRows.get(i);
    }
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    //   15.7 → adj=115.7, idx=1, bin=0 → "0-100"
    }
            }
 * {@code MIN(field) OVER ()} / {@code MAX(field) OVER ()} empty-partition
    }
        if (dataProvisioned == false) {
    // Effective bounds (expansion-only):
            return;
            "source=" + DATASET.indexName + " | bin num1 start=0 end=100 | stats count() as c by num1 | sort num1"
                    want.get(j),
 * on the analytics-engine route. Exercises PPL's {@code bin <field>
 * this file be licensed under the Apache-2.0 license or a
        }
            );
    //    null → null
            assertEquals(
 * <p>{@code RangeBinHandler} wraps {@code data_min} / {@code data_max} in
            row("-100-0"),
 * compatible open source license.
    private static void assertBucket(List<Object> row, String expectedLabel, long expectedCount) {
    //   -3.5 → adj=96.5, idx=0, bin=-100 → "-100-0"
    //
        if (expected == null || actual == null) {
            assertEquals(message, expected, actual);
    //  -12.3 → adj=87.7, idx=0, bin=-100 → "-100-0"
 */
    // Labels for num1:
    }
        @SuppressWarnings("unchecked")
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
    //    null → null
    // ── Distribution across full dataset ────────────────────────────────────
    // 7 rows).
import java.util.Arrays;
/*
            row("0-100"),
            "source=" + DATASET.indexName + " | bin num0 start=-100 end=100 | fields num0 | head 10",
    public void testBinStartEndPreservesNullsInNullableField() throws IOException {
            row("-100-0"),
            row("0-10")
        );
        Map<String, Object> response = executePpl(ppl);
            if (Double.compare(e, a) != 0) {
    //    3.5 → adj=103.5, idx=1, bin=0 → "0-100"
 * The OpenSearch Contributors require contributions made to
    //   range = 200 (not power of 10) → width = 10^floor(log10(200)) = 100.
    //  -15.7 → adj=84.3, idx=0, bin=-100 → "-100-0"
    //   effective_max = max(100, 15.7) = 100
 * {@code org.opensearch.sql.calcite.utils.binning.handlers.RangeBinHandler}).
            row("-100-0"),
}
        if (expected instanceof Number && actual instanceof Number) {
                    got.get(j)
    // ── Null-value propagation ──────────────────────────────────────────────
    @SuppressWarnings("varargs")
 */
    // ── Happy path: bin <field> start=X end=Y ───────────────────────────────
            }
    private static List<Object> row(Object... values) {
        }
import java.io.IOException;
            row("0-10"),
        Map<String, Object> response = executePpl(
import java.util.Map;
    // `bin num1 start=0 end=100` — width=10, every num1 value ∈ [2.47, 16.81]
        assertEquals("unexpected bucket label", expectedLabel, row.get(1));
 * SPDX-License-Identifier: Apache-2.0
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
 * pre-substrait lift hoists the nested RexOver into a child Project — see the
            row("0-100"),
            row((Object) null)
            row((Object) null),
                want.size(),
 * {@code liftNestedRexOver} helper for details.
                "Column count mismatch at row " + i + " for query: " + ppl,
            row("0-100"),
        assertBucket(rows.get(0), "0-10", 10);
            row("0-100"),
            dataProvisioned = true;
    //
import org.opensearch.client.Response;
    private static void assertCellEquals(String message, Object expected, Object actual) {
    }
            row("0-10"),
    // range = 100 → exact power of 10 → width = 10^(2-1) = 10.
    // ── helpers ─────────────────────────────────────────────────────────────
            DatasetProvisioner.provision(client(), DATASET);
