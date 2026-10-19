package org.opensearch.analytics.qa;
import java.util.List;  
        // num0 has 9 nulls and 8 non-nulls; count(num0) counts non-nulls only.  
    }  
        // TECHNOLOGY nets to 10.0.
        // num0 non-nulls sum to 10.0 (12.3 + -12.3 + 15.7 + -15.7 + 3.5 + -3.5 + 0 + 10).
        // Positive-num0 values: 12.3 + 15.7 + 3.5 + 10 = 41.5.
 * <p>Group-by tests use an explicit {@code | sort} suffix because the analytics-engine backend's
            "source=" + DATASET.indexName + " | stats sum(num0) by str0 | sort str0",  
 * The OpenSearch Contributors require contributions made to  
            List<Object> want = expected[i];
        for (int i = 0; i < expected.length; i++) {
    }  
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
 * the broader stats family (AVG, SUM, COUNT, MIN/MAX, DISTINCT_COUNT, STDDEV_POP / SAMP,
        // TECHNOLOGY rows have null num0 and don't contribute to the average.
            );
import java.util.Map;
 *
        // Sort by the bucket field so the test is deterministic across engines; ASC sort
                "Column count mismatch at row " + i + " for query: " + ppl,
    }
            row(10.651056285646039)  
        }
 *  
            row(2, "FURNITURE"),
    }
    }
 *
    }
            row(0.0, "FURNITURE"),
    // ── group-by aggregates ────────────────────────────────────────────────────
            "source=" + DATASET.indexName + " | stats count() by str0 | sort str0",
            row(113.445)
            "source=" + DATASET.indexName + " | where num0 > 0 | stats sum(num0)",  
        }
        // num0 averages per str0 bucket. FURNITURE: {12.3, -12.3} → 0. OFFICE SUPPLIES:
        assertRowsEqual(  
    private static void assertCellEquals(String message, Object expected, Object actual) {
/*  
 *  
        // {15.7, -15.7} → 0. TECHNOLOGY non-null num0 is just {10} → 10. The other  
        }
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably). */
            row(6, (Object) null),
    @Override
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
        if (dataProvisioned == false) {
        // int0 buckets at width 5: {0:[1,3,4,4,4], 5:[7,8,8], 10:[10,11], null:6}.
            double e = ((Number) expected).doubleValue();
    }
            }  
        assertRowsEqual(
                + " | stats count() by span(int0, 5) as bucket | sort bucket",  
            row(129.65142857142857)  
    protected void onBeforeQuery() throws IOException {  
        assertRowsEqual("source=" + DATASET.indexName + " | stats count(num0)", row(8));
            "source=" + DATASET.indexName + " | stats stddev_samp(num0)",  
        // 17 rows in calcs.
        );
            return;
        }  
    }
    @SuppressWarnings("varargs")  
        );
        // calcs str0: 2 FURNITURE, 6 OFFICE SUPPLIES, 9 TECHNOLOGY rows (no nulls).
            for (int j = 0; j < want.size(); j++) {  
            DatasetProvisioner.provision(client(), DATASET);
        assertRowsEqual("source=" + DATASET.indexName + " | stats max(num0)", row(15.7));
            }  
    public void testStatsIntegralSum() throws IOException {  
        );  
            "source=" + DATASET.indexName + " | stats var_pop(num0)",
        );
    public void testStatsDistinctCount() throws IOException {
    }
import java.util.Arrays;
        assertRowsEqual(
    public void testStatsVarPop() throws IOException {
 * Self-contained integration test for PPL {@code stats} on the analytics-engine route.
    }  
 * analytics-route ITs, but inside core without depending on the SQL plugin.
        );
        return Arrays.asList(values);
    public void testStatsStddevSamp() throws IOException {
 * keeps it across test methods.  
        assertRowsEqual("source=" + DATASET.indexName + " | stats sum(int0)", row(68));
    public void testStatsAvgByGroup() throws IOException {
            if (Double.compare(e, a) != 0) {
                    got.get(j)
    public void testStatsSum() throws IOException {
    public void testStatsCountField() throws IOException {
            row(2, 10)
        // puts the null bucket first.  
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
                );
            row(41.5)
            row(5, 0),
        if (expected instanceof Number && actual instanceof Number) {
                got.size()
        assertRowsEqual(
 * Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed by the
    }  
            "source=" + DATASET.indexName + " | stats stddev_pop(num0)",
        );
            "source=" + DATASET.indexName + " | stats distinct_count(str0)",
import java.io.IOException;
 */  
        );
        assertEquals(message, expected, actual);  
    public void testStatsMin() throws IOException {  
        assertRowsEqual("source=" + DATASET.indexName + " | stats min(num0)", row(-15.7));
            return;
            row(9, "TECHNOLOGY")
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
 * SPDX-License-Identifier: Apache-2.0
    public void testStatsWithFilter() throws IOException {  
import org.opensearch.client.Request;
        if (expected == null || actual == null) {  
        assertRowsEqual(  
    // ── span (numeric bucketing) ───────────────────────────────────────────────
            double a = ((Number) actual).doubleValue();  
 * <p>Mirrors {@code CalciteStatsCommandIT} from the {@code opensearch-project/sql} repository  
    }
    }
        assertRowsEqual(
            row(0.0, "FURNITURE"),
            List<Object> got = actualRows.get(i);  
        assertRowsEqual(
        assertRowsEqual(
            row(10.0, "TECHNOLOGY")  
    }
    public void testStatsStddevPop() throws IOException {  
    // ── statistical aggregates (STDDEV / VAR) ──────────────────────────────────
            assertEquals(
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
    public void testStatsCount() throws IOException {  
    }  
/**  
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
 * for the operators reachable from this PR — SPAN over numerics (the wiring added here) plus
            "source=" + DATASET.indexName + " | stats var_samp(num0)",
        @SuppressWarnings("unchecked")  
    @SafeVarargs
        assertRowsEqual(
 * compatible open source license.
        assertRowsEqual(
        );
    public void testStatsCountBySpanNumeric() throws IOException {  
public class StatsCommandIT extends AnalyticsRestTestCase {
}  
    }
            row(10.0, "TECHNOLOGY")  
        // str0 takes 3 distinct values: FURNITURE, OFFICE SUPPLIES, TECHNOLOGY (plus nulls).  
    }  
    private static List<Object> row(Object... values) {
 * hash-aggregation output order is non-deterministic.
            row(4, 5),  
                assertCellEquals(
        assertRowsEqual("source=" + DATASET.indexName + " | stats sum(num0)", row(10.0));  
        );
    // ── single-value aggregates ────────────────────────────────────────────────
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
    }
    // ── filter + aggregate ─────────────────────────────────────────────────────
import org.opensearch.client.Response;
 * VAR_POP / SAMP) which already flow through the analytics-engine route via Calcite's  
 */
        );
        assertRowsEqual("source=" + DATASET.indexName + " | stats avg(num0)", row(1.25));  
        // num0 sums per str0 bucket. FURNITURE and OFFICE SUPPLIES happen to net to 0.0;  
            row(0.0, "OFFICE SUPPLIES"),
 * {@code opensearch-sql} plugin), exercising the same {@code UnifiedQueryPlanner} →  
            row(6, "OFFICE SUPPLIES"),  
    public void testStatsAvg() throws IOException {
    // ── helpers ─────────────────────────────────────────────────────────────────
 * {@link org.opensearch.analytics.planner.rules.OpenSearchAggregateReduceRule} decomposition.
        // 10.0 / 8 = 1.25.
    }
 * {@code CalciteRelNodeVisitor} → Substrait → DataFusion pipeline as the SQL plugin's
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
        assertRowsEqual("source=" + DATASET.indexName + " | stats count()", row(17));
                want.size(),  
 * this file be licensed under the Apache-2.0 license or a
            "source=" + DATASET.indexName + " | stats avg(num0) by str0 | sort str0",  
    public void testStatsMax() throws IOException {
    public void testStatsCountByGroup() throws IOException {
    public void testStatsSumByGroup() throws IOException {
            row(11.386458122323578)
            "source=" + DATASET.indexName
    }  
    }
            row(3)  
            dataProvisioned = true;  
            assertEquals(message, expected, actual);
                    want.get(j),  
    private static boolean dataProvisioned = false;  
        Map<String, Object> response = executePpl(ppl);
    public void testStatsVarSamp() throws IOException {  
            row(0.0, "OFFICE SUPPLIES"),
