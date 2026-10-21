        // length('FURNITURE') = 9 → 2 rows.
                + " | fields str0, num0, str2",
        Map<String, Object> response = executePpl(ppl);
            actualRows.size()
     * test body, not in {@code @BeforeClass} / {@code setUp()}.
        assertRowCount(
        );
     * exact row contents would be brittle (e.g. set membership tests where row order is not
 *   <li>{@code LIKE} (operator + function) and {@code contains} (lowers to {@code ILIKE})</li>
        @SuppressWarnings("unchecked")
    }
        }
import java.util.Map;
    // ── LIKE function and operator ──────────────────────────────────────────
        // num0 <= 0 → adds num0=0 → 4 rows.
        );
    }
            "source=" + DATASET.indexName + " | where str2 LIKE 'on_' | fields str2",
        );
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
        );
 *   <li>{@code IN} / {@code NOT IN}</li>
            row("one", 12.3)
 * compatible open source license.
            "source=" + DATASET.indexName + " | where abs(num0) > 10 | fields num0",
            double a = ((Number) actual).doubleValue();
            double e = ((Number) expected).doubleValue();
        // abs(num0) > 10 → {-15.7, -12.3, 12.3, 15.7} = 4 rows.
            "source=" + DATASET.indexName
 *   <li>{@code = / == / != / &lt; / &gt; / &lt;= / &gt;=}</li>
                + " as i | where i.int0 = o.int1 ] | fields int1",
            4
                );
        // 2 rows have str0='FURNITURE'.
        // str2 has 4 null rows in calcs.
    public void testWhereIsNull() throws IOException {
            "source=" + DATASET.indexName + " | where str0 in ('FURNITURE', 'OFFICE SUPPLIES') | fields str0",
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
        }
            "source=" + DATASET.indexName + " | where isnull(str2) | fields str2",
    public void testWhereInnerAbs() throws IOException {
    public void testWhereNot() throws IOException {
        // FURNITURE rows are key00 (num0=12.3) and key01 (num0=-12.3); AND num0>0 keeps key00.
    private void assertRowCount(String ppl, int expectedCount) throws IOException {
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
            0
 */
        assertRowCount(
            List<Object> want = expected[i];
 * <p>Sub-expression coverage (passed through to DataFusion via Substrait without
            "source=" + DATASET.indexName + " as o | where exists [ source=" + DATASET.indexName
 *
import java.util.Arrays;
                want.size(),
        assertRowCount("source=" + DATASET.indexName + " | where num0 != 0 | fields num0", 7);
            row("one", 12.3)
    public void testWhereEqualOnKeyword() throws IOException {
    public void testWhereInnerArithmetic() throws IOException {
            3
            "source=" + DATASET.indexName + " | where num0 in (12.3, -12.3) | fields num0",
        assertRowCount(
            "source=" + DATASET.indexName + " | where str0 contains 'URN' | fields str0",
        assertRowCount(
        assertRowCount("source=" + DATASET.indexName + " | where num0 < 0 | fields num0", 3);
    }
    public void testWhereEqualOnDouble() throws IOException {
        }
            "source=" + DATASET.indexName + " | where str0 contains 'urn' | fields str0",
    public void testWhereMultipleNotEqualsAndIsNotNull() throws IOException {
            "source=" + DATASET.indexName + " | where isnotnull(str2) | fields str2",
}
            11
        );
            "source=" + DATASET.indexName + " | where num0 == 12.3 OR num0 == -12.3 | fields num0",
    /**
 */
    // ── Boolean connectives ─────────────────────────────────────────────────
    public void testWhereLikeFunction() throws IOException {
            );
        assertRowCount("source=" + DATASET.indexName + " | where num0 >= 0 | fields num0", 5);
     * Assert that the PPL query returns exactly {@code expectedCount} rows. Used when the
    }
            "source=" + DATASET.indexName + " | where length(str0) = 9 | fields str0",
        );
                + " | where str0 = 'FURNITURE'"
        assertRowCount(
        // like(str0, 'FURN%') → 2 FURNITURE rows.
    }
     * as {@link FillNullCommandIT} — {@code client()} is only reliably available inside a
    }
                    got.get(j)
    }
    }
    public void testWhereLikeNoMatch() throws IOException {
    public void testWhereAnd() throws IOException {
    // LogicalCorrelate that marking rejects ("unmarked child [LogicalCorrelate]"). The planner now
    // ── Comparison operators ────────────────────────────────────────────────
    @Override
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
import org.opensearch.client.Request;
        );
                + " as i | where i.int0 = o.int1 ] | fields int1",
            return;
        assertRowCount("source=" + DATASET.indexName + " | where num0 > 0 | fields num0", 4);
    public void testWhereGreaterEqual() throws IOException {
        );
        // num0 >= 0 → adds the row with num0=0 → 5 rows.
import java.io.IOException;
        assertEquals(
    }
    }
                got.size()
    public void testWhereLikeOperator() throws IOException {
        // num0 < 0 → {-12.3, -15.7, -3.5}.
        // == is parsed as = at the AstExpressionBuilder layer; same plan, same result.
    public void testWhereIsNotNull() throws IOException {
        assertRowCount(
public class WhereCommandIT extends AnalyticsRestTestCase {
            2
            "source=" + DATASET.indexName + " as o | where not exists [ source=" + DATASET.indexName
        assertRowCount(
        );
/*
 * arithmetic {@code +}.
                + " | where num0 > 0"
                + " | where str2 = 'one'"
        }
    public void testWhereGreaterThan() throws IOException {
 *
    // ── NULL handling via isnull() / isnotnull() ────────────────────────────
            "source=" + DATASET.indexName + " | where num0 == 12.3 | fields str2, num0",
        );
    }
        for (int i = 0; i < expected.length; i++) {
    }
 * Self-contained integration test for PPL {@code where} on the analytics-engine route.
 * shipped under {@code sandbox/qa/analytics-engine-rest/src/test/resources/datasets/calcs/}.
    }
        // 'on_' matches 'one' only (3 chars starting with "on").
 *   <li>{@code IS NULL} / {@code IS NOT NULL} via {@code isnull()} / {@code isnotnull()}</li>
            List<Object> got = actualRows.get(i);
    // ── Helpers ─────────────────────────────────────────────────────────────
            "source=" + DATASET.indexName + " | where num0 + 100 > 105 | fields num0",
            row("FURNITURE", 12.3, "one")
    }
            "source=" + DATASET.indexName + " | where str2 != 'one' and str2 != 'two' and isnotnull(str2) | fields str2",
        if (dataProvisioned == false) {
            "source=" + DATASET.indexName + " | where not str0 = 'FURNITURE' | fields str0",
    public void testWhereLessEqual() throws IOException {
        );
     * shape, but PPL doesn't preserve that distinction at the API surface).
    protected void onBeforeQuery() throws IOException {
            expectedCount,
        assertRowCount(
            if (Double.compare(e, a) != 0) {
            row("one", 12.3)
            "source=" + DATASET.indexName + " | where str0 LIKE 'OFF%' | fields str0",
 *
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        assertRowCount("source=" + DATASET.indexName + " | where str0 = 'FURNITURE' | fields str0", 2);
    }
        );
 * appearing as the leaf-predicate operator): {@code length()}, {@code abs()},
    /** Multiple {@code !=} conjuncts combined with {@code isnotnull}. */
        // 8 non-null distinct num0 values; != 0 keeps 7 rows (drops the single num0=0).
    }
    @SafeVarargs
        assertRowCount(
    private static List<Object> row(Object... values) {
        // Lowercase pattern still hits FURNITURE because contains uses ILIKE.
     * numeric-tolerant cell comparator (Jackson parsing returns Integer/Long/Double per JSON
    public void testWhereDoubleEqualOperator() throws IOException {
            for (int j = 0; j < want.size(); j++) {
        // str2 has 13 non-null rows in calcs.
    }
 * this file be licensed under the Apache-2.0 license or a
                assertCellEquals(
            2
    }
    }
 *   <li>Boolean connectives {@code AND / OR / NOT}</li>
        if (expected instanceof Number && actual instanceof Number) {
        );
        );
    // ── Sub-expression scalar calls (pass through to DataFusion) ────────────
     * Assert exact row contents. Mirrors {@link FillNullCommandIT#assertRows} including the
    }
            15
            "source=" + DATASET.indexName + " | where str0 = 'FURNITURE' and num0 > 0 | fields str2, num0",
    }
    /**
    public void testWhereContainsCaseInsensitive() throws IOException {
     */
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        if (expected == null || actual == null) {
            6
 *
        );
            "source=" + DATASET.indexName + " | where like(str0, 'XYZ%') | fields str0",
        assertRows(
            2
        );
 * SPDX-License-Identifier: Apache-2.0
        assertRowCount(
        // 'URN' inside FURNITURE → 2 rows.
    public void testWhereMultipleChained() throws IOException {
        // num0 + 100 > 105 ⇔ num0 > 5 → {12.3, 15.7, 10} = 3 rows.
        assertRowCount(
            assertEquals(
            row("one")
 * <p>Top-level filter operators covered (see
            9
    public void testCorrelatedNotExistsSubsearch() throws IOException {
                "Column count mismatch at row " + i + " for query: " + ppl,
    public void testWhereNotEqual() throws IOException {
        );
        // num0 IN (12.3, -12.3) → key00, key01 = 2 rows.
 * The OpenSearch Contributors require contributions made to
 * {@code opensearch-sql} plugin), exercising the same {@code UnifiedQueryPlanner} →
    public void testWhereInOnNumeric() throws IOException {
     */
    @SuppressWarnings("varargs")
        // num0 == 12.3 OR num0 == -12.3 → key00, key01.
 * <p>Mirrors the surface exercised by {@code CalciteWhereCommandIT} from the
            "Row count mismatch for query: " + ppl + " — got rows: " + actualRows,
        // num0 > 0 → {12.3, 15.7, 3.5, 10}.
    public void testWhereContains() throws IOException {
        );
        assertRows(
 * {@link org.opensearch.analytics.spi.ScalarFunction} → {@code STANDARD_FILTER_OPS} in
        );
    public void testWhereLikeUnderscoreWildcard() throws IOException {
        assertRowCount(
    // have an int1 that equals some row's int0.
        assertRowCount(
            "source=" + DATASET.indexName + " | where not str0 in ('FURNITURE', 'OFFICE SUPPLIES') | fields str0",
            "source=" + DATASET.indexName + " | where like(str0, 'FURN%') | fields str0",
    }
    }
            4
        // Complement of (FURNITURE, OFFICE SUPPLIES): 9 TECHNOLOGY rows.
    }
    public void testWhereLessThan() throws IOException {
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
        assertRowCount(
            2
 * {@code opensearch-project/sql} repository, adapted to the {@code calcs} dataset
    }
    }
    // Complement of the EXISTS case: NOT EXISTS keeps the remaining 15 of 17 rows.
    public void testWhereNotIn() throws IOException {
        Map<String, Object> response = executePpl(ppl);
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    // strips the (existence-irrelevant) limit so the EXISTS decorrelates to a join. Two calcs rows
        assertRowCount("source=" + DATASET.indexName + " | where num0 <= 0 | fields num0", 4);
        );
        // Three filter steps: FURNITURE → num0>0 → str2='one'. Should leave one row.
        );
    }
        assertRowCount(
            }
    public void testCorrelatedExistsSubsearch() throws IOException {
            2
    private static void assertCellEquals(String message, Object expected, Object actual) {
 * {@code CalciteRelNodeVisitor} → analytics-engine planner → Substrait → DataFusion
        assertRowCount(
        assertRows(
 * </ul>
 * <ul>
    private static boolean dataProvisioned = false;
import org.opensearch.client.Response;
    // the top of the subsearch; that correlated Sort(fetch>1) blocks RelDecorrelator, leaving a
            2
     */
/**
        );
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
        @SuppressWarnings("unchecked")
        // 13 non-null str2 values; excluding 'one' and 'two' leaves 11.
    }
            2
                    want.get(j),
    /**
        assertRows(
        assertRowCount(
            assertEquals(message, expected, actual);
            8
            DatasetProvisioner.provision(client(), DATASET);
    public void testWhereOr() throws IOException {
        // str0 LIKE 'OFF%' → 6 OFFICE SUPPLIES rows.
import java.util.List;
     * Lazily provision the calcs dataset on first invocation. Same lazy-provision pattern
package org.opensearch.analytics.qa;
        assertRows(
        assertRowCount(
    }
            "source=" + DATASET.indexName + " | where num0 = 12.3 | fields str2, num0",
 * pipeline as the SQL plugin's force-routed analytics path.
 * Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed by the
    }
            13
    public void testWhereInnerLength() throws IOException {
    }
    // ── IN / NOT IN ─────────────────────────────────────────────────────────
    // ── CONTAINS (lowers to ILIKE — case-insensitive) ───────────────────────
    // A correlated EXISTS subsearch. The PPL frontend injects a SUBSEARCH_MAXOUT Sort(fetch=N) at
        );
            15
    }
            }
        return Arrays.asList(values);
    }
            return;
    }
    public void testWhereInOnKeyword() throws IOException {
        assertEquals(message, expected, actual);
        // FURNITURE (2) + OFFICE SUPPLIES (6) = 8.
     * guaranteed by the engine).
            dataProvisioned = true;
        // NOT (str0 = 'FURNITURE') → 17 - 2 = 15 rows. (str0 has no nulls in calcs.)
 * {@code DataFusionAnalyticsBackendPlugin}):
        );
