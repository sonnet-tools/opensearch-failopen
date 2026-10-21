            row(10.0, "TECHNOLOGY")
    private final void assertRowsEqual(String ppl, List<Object>... expected) throws IOException {
            "source=" + DATASET.indexName + " | stats var_pop(num0)",
            "source=" + DATASET.indexName + " | stats count() by str0 | sort str0",
    // ── helpers ─────────────────────────────────────────────────────────────────
        return Arrays.asList(values);
    public void testStatsMax() throws IOException {
    }
 * compatible open source license.
 * analytics-route ITs, but inside core without depending on the SQL plugin.
    public void testStatsStddevSamp() throws IOException {
            }
                    want.get(j),
            List<Object> want = expected[i];
public class StatsCommandIT extends AnalyticsRestTestCase {
            for (int j = 0; j < want.size(); j++) {
        // Sort by the bucket field so the test is deterministic across engines; ASC sort
 * {@code opensearch-sql} plugin), exercising the same {@code UnifiedQueryPlanner} →
import java.io.IOException;
            "source=" + DATASET.indexName + " | stats sum(num0) by str0 | sort str0",
    }
    }
 *
    // ── single-value aggregates ────────────────────────────────────────────────
            "source=" + DATASET.indexName + " | where num0 > 0 | stats sum(num0)",
    public void testStatsIntegralSum() throws IOException {
    }
    public void testStatsAvgByGroup() throws IOException {
    }
        assertRowsEqual("source=" + DATASET.indexName + " | stats count(num0)", row(8));
        assertRowsEqual("source=" + DATASET.indexName + " | stats sum(num0)", row(10.0));
        assertRowsEqual("source=" + DATASET.indexName + " | stats count()", row(17));
        assertRowsEqual(
    public void testStatsCountBySpanNumeric() throws IOException {
 * Self-contained integration test for PPL {@code stats} on the analytics-engine route.
package org.opensearch.analytics.qa;
            row(0.0, "FURNITURE"),
import java.util.Map;
import org.opensearch.client.Request;
 */
        assertRowsEqual(
        // calcs str0: 2 FURNITURE, 6 OFFICE SUPPLIES, 9 TECHNOLOGY rows (no nulls).
        assertRowsEqual("source=" + DATASET.indexName + " | stats max(num0)", row(15.7));
    public void testStatsCount() throws IOException {
        }
        );
    }
            row(3)
            row(129.65142857142857)
        assertRowsEqual("source=" + DATASET.indexName + " | stats avg(num0)", row(1.25));
import org.opensearch.client.Response;
    }
    // ── group-by aggregates ────────────────────────────────────────────────────
        if (expected instanceof Number && actual instanceof Number) {
            row(6, (Object) null),
        );
            "source=" + DATASET.indexName
    }
            row(10.0, "TECHNOLOGY")
            row(4, 5),
        assertRowsEqual(
 * hash-aggregation output order is non-deterministic.
    protected void onBeforeQuery() throws IOException {
            dataProvisioned = true;
            row(9, "TECHNOLOGY")
    private static boolean dataProvisioned = false;
        assertRowsEqual(
        assertEquals(message, expected, actual);
            DatasetProvisioner.provision(client(), DATASET);
            "source=" + DATASET.indexName + " | stats var_samp(num0)",
                got.size()
            row(0.0, "OFFICE SUPPLIES"),
    @SafeVarargs
            if (Double.compare(e, a) != 0) {
    }
        assertRowsEqual(
    public void testStatsDistinctCount() throws IOException {
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
        assertRowsEqual("source=" + DATASET.indexName + " | stats sum(int0)", row(68));
 * VAR_POP / SAMP) which already flow through the analytics-engine route via Calcite's
        assertRowsEqual(
 * for the operators reachable from this PR — SPAN over numerics (the wiring added here) plus
                assertCellEquals(
        );
    }
import java.util.Arrays;
                "Column count mismatch at row " + i + " for query: " + ppl,
    }
    public void testStatsMin() throws IOException {
        );
    public void testStatsStddevPop() throws IOException {
            "source=" + DATASET.indexName + " | stats stddev_samp(num0)",
    }
 * The OpenSearch Contributors require contributions made to
            "source=" + DATASET.indexName + " | stats stddev_pop(num0)",
    @SuppressWarnings("varargs")
        // 10.0 / 8 = 1.25.
 * SPDX-License-Identifier: Apache-2.0
            double a = ((Number) actual).doubleValue();
        // num0 sums per str0 bucket. FURNITURE and OFFICE SUPPLIES happen to net to 0.0;
    public void testStatsAvg() throws IOException {
        );
        );
/**
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
            return;
        // {15.7, -15.7} → 0. TECHNOLOGY non-null num0 is just {10} → 10. The other
        // TECHNOLOGY rows have null num0 and don't contribute to the average.
    public void testStatsSumByGroup() throws IOException {
            row(6, "OFFICE SUPPLIES"),
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
    }
 * {@link org.opensearch.analytics.planner.rules.OpenSearchAggregateReduceRule} decomposition.
 * Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed by the
        }
        // num0 non-nulls sum to 10.0 (12.3 + -12.3 + 15.7 + -15.7 + 3.5 + -3.5 + 0 + 10).
    }
        assertRowsEqual(
 * {@code CalciteRelNodeVisitor} → Substrait → DataFusion pipeline as the SQL plugin's
 * this file be licensed under the Apache-2.0 license or a
    public void testStatsWithFilter() throws IOException {
        assertRowsEqual(
            row(41.5)
 *
    public void testStatsSum() throws IOException {
            row(2, 10)
        // num0 has 9 nulls and 8 non-nulls; count(num0) counts non-nulls only.
        );
            row(10.651056285646039)
            assertEquals(message, expected, actual);
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        // puts the null bucket first.
    }
            "source=" + DATASET.indexName + " | stats distinct_count(str0)",
 * keeps it across test methods.
    // ── statistical aggregates (STDDEV / VAR) ──────────────────────────────────
        assertRowsEqual(
    }
        assertRowsEqual(
            row(11.386458122323578)
        );
                want.size(),
            "source=" + DATASET.indexName + " | stats avg(num0) by str0 | sort str0",
    }
        for (int i = 0; i < expected.length; i++) {
        // 17 rows in calcs.
}
        );
 * the broader stats family (AVG, SUM, COUNT, MIN/MAX, DISTINCT_COUNT, STDDEV_POP / SAMP,
 *
        );
            double e = ((Number) expected).doubleValue();
                    got.get(j)
    private static List<Object> row(Object... values) {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
/*
            row(113.445)
                );
        }
            );
 */
                + " | stats count() by span(int0, 5) as bucket | sort bucket",
            row(2, "FURNITURE"),
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    // ── filter + aggregate ─────────────────────────────────────────────────────
        // TECHNOLOGY nets to 10.0.
    }
    @Override
    public void testStatsVarPop() throws IOException {
        if (dataProvisioned == false) {
            row(0.0, "OFFICE SUPPLIES"),
            return;
        // str0 takes 3 distinct values: FURNITURE, OFFICE SUPPLIES, TECHNOLOGY (plus nulls).
    public void testStatsCountField() throws IOException {
    public void testStatsVarSamp() throws IOException {
    public void testStatsCountByGroup() throws IOException {
    // ── span (numeric bucketing) ───────────────────────────────────────────────
        }
            }
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
        assertNotNull("Response missing 'rows' for query: " + ppl, actualRows);
        assertRowsEqual("source=" + DATASET.indexName + " | stats min(num0)", row(-15.7));
        // Positive-num0 values: 12.3 + 15.7 + 3.5 + 10 = 41.5.
            row(0.0, "FURNITURE"),
        // num0 averages per str0 bucket. FURNITURE: {12.3, -12.3} → 0. OFFICE SUPPLIES:
import java.util.List;
    private static void assertCellEquals(String message, Object expected, Object actual) {
 * <p>Mirrors {@code CalciteStatsCommandIT} from the {@code opensearch-project/sql} repository
        @SuppressWarnings("unchecked")
        // int0 buckets at width 5: {0:[1,3,4,4,4], 5:[7,8,8], 10:[10,11], null:6}.
        if (expected == null || actual == null) {
        Map<String, Object> response = executePpl(ppl);
    /** Numeric-tolerant cell comparator (Jackson returns Integer/Long/Double interchangeably). */
 * <p>Group-by tests use an explicit {@code | sort} suffix because the analytics-engine backend's
            assertEquals(
    }
            List<Object> got = actualRows.get(i);
 *
            row(5, 0),
    }
    }
