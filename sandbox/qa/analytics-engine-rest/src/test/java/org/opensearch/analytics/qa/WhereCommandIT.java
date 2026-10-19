    }
 *  
    public void testWhereNot() throws IOException {  
        // num0 >= 0 → adds the row with num0=0 → 5 rows.
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
                    want.get(j),  
            2  
        assertEquals(
    /**  
import org.opensearch.client.Response;  
     * numeric-tolerant cell comparator (Jackson parsing returns Integer/Long/Double per JSON
                + " | fields str0, num0, str2",  
/*  
            "source=" + DATASET.indexName + " | where str2 != 'one' and str2 != 'two' and isnotnull(str2) | fields str2",  
        assertRowCount(  
 * this file be licensed under the Apache-2.0 license or a
    // ── IN / NOT IN ─────────────────────────────────────────────────────────
        );  
        assertRowCount(
 * {@code CalciteRelNodeVisitor} → analytics-engine planner → Substrait → DataFusion  
 */  
    // LogicalCorrelate that marking rejects ("unmarked child [LogicalCorrelate]"). The planner now
        }
    @SafeVarargs
    }
        assertRowCount(  
     */
            "source=" + DATASET.indexName + " | where num0 == 12.3 OR num0 == -12.3 | fields num0",
    }
 *
    public void testWhereOr() throws IOException {
        );
            0  
        );
        );
        );
                got.size()
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
            expectedCount,
    }
        );  
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
    public void testWhereIsNotNull() throws IOException {  
            4
        // str0 LIKE 'OFF%' → 6 OFFICE SUPPLIES rows.  
            2
import java.io.IOException;
        @SuppressWarnings("unchecked")
            row("one")
        // 8 non-null distinct num0 values; != 0 keeps 7 rows (drops the single num0=0).  
    // ── Sub-expression scalar calls (pass through to DataFusion) ────────────
public class WhereCommandIT extends AnalyticsRestTestCase {  
        assertRowCount(  
        );
    }  
    }  
                assertCellEquals(
        // str2 has 13 non-null rows in calcs.
        );
            double e = ((Number) expected).doubleValue();
    public void testWhereLikeOperator() throws IOException {
 *
    /** Multiple {@code !=} conjuncts combined with {@code isnotnull}. */
    public void testWhereLikeFunction() throws IOException {  
            "source=" + DATASET.indexName + " | where str0 = 'FURNITURE' and num0 > 0 | fields str2, num0",
    }
        assertRowCount(  
 * compatible open source license.
    }
    }
        );  
            if (Double.compare(e, a) != 0) {
    }
        // num0 < 0 → {-12.3, -15.7, -3.5}.  
    public void testWhereLessEqual() throws IOException {
    }
        if (expected instanceof Number && actual instanceof Number) {
            double a = ((Number) actual).doubleValue();  
    private void assertRowCount(String ppl, int expectedCount) throws IOException {  
    public void testWhereContainsCaseInsensitive() throws IOException {
        // num0 <= 0 → adds num0=0 → 4 rows.
    }
 * <p>Mirrors the surface exercised by {@code CalciteWhereCommandIT} from the
    @Override
                "Column count mismatch at row " + i + " for query: " + ppl,
    public void testWhereEqualOnKeyword() throws IOException {  
            );
            "source=" + DATASET.indexName + " | where isnotnull(str2) | fields str2",  
            4  
            }  
        assertRowCount(
            9  
 *   <li>{@code = / == / != / &lt; / &gt; / &lt;= / &gt;=}</li>
            6  
    public void testWhereContains() throws IOException {  
    }  
            8
    public void testWhereInnerArithmetic() throws IOException {
        // Three filter steps: FURNITURE → num0>0 → str2='one'. Should leave one row.  
    }
                    got.get(j)
        assertRowCount("source=" + DATASET.indexName + " | where num0 < 0 | fields num0", 3);
            "source=" + DATASET.indexName + " | where str0 contains 'URN' | fields str0",  
                + " | where str0 = 'FURNITURE'"  
    public void testCorrelatedNotExistsSubsearch() throws IOException {
                + " | where num0 > 0"
    }
        assertRowCount(
    // ── Comparison operators ────────────────────────────────────────────────
    }
        // 13 non-null str2 values; excluding 'one' and 'two' leaves 11.
import java.util.List;
        // num0 + 100 > 105 ⇔ num0 > 5 → {12.3, 15.7, 10} = 3 rows.
    }
            actualRows.size()
 * appearing as the leaf-predicate operator): {@code length()}, {@code abs()},  
 *   <li>{@code LIKE} (operator + function) and {@code contains} (lowers to {@code ILIKE})</li>
        assertRows(
    // ── NULL handling via isnull() / isnotnull() ────────────────────────────
            "source=" + DATASET.indexName + " | where str0 in ('FURNITURE', 'OFFICE SUPPLIES') | fields str0",
        // str2 has 4 null rows in calcs.
     * shape, but PPL doesn't preserve that distinction at the API surface).  
            List<Object> want = expected[i];
     * Assert that the PPL query returns exactly {@code expectedCount} rows. Used when the
     * guaranteed by the engine).
        assertRowCount(
     */
        );
        assertRowCount(  
 *   <li>{@code IS NULL} / {@code IS NOT NULL} via {@code isnull()} / {@code isnotnull()}</li>  
        );
            "source=" + DATASET.indexName + " | where isnull(str2) | fields str2",
    // strips the (existence-irrelevant) limit so the EXISTS decorrelates to a join. Two calcs rows  
 *
    public void testWhereInnerAbs() throws IOException {
            "source=" + DATASET.indexName + " | where length(str0) = 9 | fields str0",  
            return;
            "source=" + DATASET.indexName + " as o | where not exists [ source=" + DATASET.indexName
import org.opensearch.client.Request;
        // FURNITURE rows are key00 (num0=12.3) and key01 (num0=-12.3); AND num0>0 keeps key00.  
        // abs(num0) > 10 → {-15.7, -12.3, 12.3, 15.7} = 4 rows.  
        @SuppressWarnings("unchecked")  
        );
        Map<String, Object> response = executePpl(ppl);
 * The OpenSearch Contributors require contributions made to  
        );
    public void testWhereInnerLength() throws IOException {  
        assertRowCount("source=" + DATASET.indexName + " | where num0 != 0 | fields num0", 7);
     */
        // == is parsed as = at the AstExpressionBuilder layer; same plan, same result.
        if (dataProvisioned == false) {
            "source=" + DATASET.indexName + " | where num0 + 100 > 105 | fields num0",
    @SuppressWarnings("varargs")  
        assertRowCount("source=" + DATASET.indexName + " | where num0 <= 0 | fields num0", 4);  
            "source=" + DATASET.indexName + " | where like(str0, 'XYZ%') | fields str0",
     * test body, not in {@code @BeforeClass} / {@code setUp()}.  
        assertRowCount(
    protected void onBeforeQuery() throws IOException {  
    }
    // Complement of the EXISTS case: NOT EXISTS keeps the remaining 15 of 17 rows.
        assertRowCount(
     * as {@link FillNullCommandIT} — {@code client()} is only reliably available inside a
    /**
            3
    }  
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
    public void testWhereLikeNoMatch() throws IOException {  
     * exact row contents would be brittle (e.g. set membership tests where row order is not  
        assertRowCount(
        // num0 IN (12.3, -12.3) → key00, key01 = 2 rows.
            row("one", 12.3)
        // Lowercase pattern still hits FURNITURE because contains uses ILIKE.  
    public void testWhereNotIn() throws IOException {
        assertRowCount(
 * SPDX-License-Identifier: Apache-2.0
    }  
        Map<String, Object> response = executePpl(ppl);
    public void testWhereDoubleEqualOperator() throws IOException {  
    public void testWhereGreaterThan() throws IOException {
        // 2 rows have str0='FURNITURE'.
            return;
        // num0 == 12.3 OR num0 == -12.3 → key00, key01.
import java.util.Arrays;  
        assertRowCount(
                want.size(),  
 * Each test sends a PPL query through {@code POST /_plugins/_ppl} (exposed by the
 * pipeline as the SQL plugin's force-routed analytics path.
        );  
    private static List<Object> row(Object... values) {  
        assertRows(  
    public void testWhereGreaterEqual() throws IOException {  
            "source=" + DATASET.indexName + " | where like(str0, 'FURN%') | fields str0",  
    // ── CONTAINS (lowers to ILIKE — case-insensitive) ───────────────────────
    }  
    public void testWhereIsNull() throws IOException {
            for (int j = 0; j < want.size(); j++) {  
    public void testWhereLessThan() throws IOException {
 * {@link org.opensearch.analytics.spi.ScalarFunction} → {@code STANDARD_FILTER_OPS} in
    }
        );
            2
            "source=" + DATASET.indexName + " as o | where exists [ source=" + DATASET.indexName
        // 'URN' inside FURNITURE → 2 rows.
            15
 * {@code opensearch-sql} plugin), exercising the same {@code UnifiedQueryPlanner} →
        // num0 > 0 → {12.3, 15.7, 3.5, 10}.
package org.opensearch.analytics.qa;
            "source=" + DATASET.indexName + " | where not str0 = 'FURNITURE' | fields str0",  
        assertRowCount(
/**
        }
            "source=" + DATASET.indexName + " | where num0 in (12.3, -12.3) | fields num0",  
        // Complement of (FURNITURE, OFFICE SUPPLIES): 9 TECHNOLOGY rows.  
                fail(message + ": expected <" + expected + "> but was <" + actual + ">");
    }
    public void testWhereMultipleNotEqualsAndIsNotNull() throws IOException {  
    }
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
    }
            2  
            "source=" + DATASET.indexName + " | where str2 LIKE 'on_' | fields str2",
        if (expected == null || actual == null) {  
            15  
        );
    // ── Helpers ─────────────────────────────────────────────────────────────
        );
    }
        assertRowCount(
        );  
    public void testCorrelatedExistsSubsearch() throws IOException {
        for (int i = 0; i < expected.length; i++) {
        // length('FURNITURE') = 9 → 2 rows.
        );
            assertEquals(message, expected, actual);
            "source=" + DATASET.indexName + " | where abs(num0) > 10 | fields num0",
            assertEquals(
    }
        // 'on_' matches 'one' only (3 chars starting with "on").
        }  
            "source=" + DATASET.indexName + " | where num0 == 12.3 | fields str2, num0",  
    }
        assertRowCount("source=" + DATASET.indexName + " | where num0 > 0 | fields num0", 4);  
    // ── LIKE function and operator ──────────────────────────────────────────
    public void testWhereNotEqual() throws IOException {
            11
        assertRowCount(
     * Lazily provision the calcs dataset on first invocation. Same lazy-provision pattern
                );
    public void testWhereEqualOnDouble() throws IOException {
}
        );
            row("one", 12.3)
 * shipped under {@code sandbox/qa/analytics-engine-rest/src/test/resources/datasets/calcs/}.  
                + " as i | where i.int0 = o.int1 ] | fields int1",
 * </ul>  
    }
    }  
    }  
            List<Object> got = actualRows.get(i);  
        );  
            2
            row("FURNITURE", 12.3, "one")
                + " as i | where i.int0 = o.int1 ] | fields int1",
        assertRowCount("source=" + DATASET.indexName + " | where num0 >= 0 | fields num0", 5);
    private static void assertCellEquals(String message, Object expected, Object actual) {
                + " | where str2 = 'one'"
        assertRows(
        return Arrays.asList(values);
 * <ul>  
        // NOT (str0 = 'FURNITURE') → 17 - 2 = 15 rows. (str0 has no nulls in calcs.)
 * arithmetic {@code +}.
 * <p>Sub-expression coverage (passed through to DataFusion via Substrait without
            row("one", 12.3)  
    // ── Boolean connectives ─────────────────────────────────────────────────  
    private static boolean dataProvisioned = false;
    public void testWhereInOnNumeric() throws IOException {  
            13
        assertEquals(message, expected, actual);  
     * Assert exact row contents. Mirrors {@link FillNullCommandIT#assertRows} including the
            dataProvisioned = true;  
        );
 * {@code DataFusionAnalyticsBackendPlugin}):
            "source=" + DATASET.indexName + " | where str0 contains 'urn' | fields str0",
            }  
            2
 * <p>Top-level filter operators covered (see  
            DatasetProvisioner.provision(client(), DATASET);
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        }
            "source=" + DATASET.indexName + " | where str0 LIKE 'OFF%' | fields str0",
            "Row count mismatch for query: " + ppl + " — got rows: " + actualRows,  
        assertRowCount(  
    // A correlated EXISTS subsearch. The PPL frontend injects a SUBSEARCH_MAXOUT Sort(fetch=N) at  
            2
        assertRows(
    }  
    public void testWhereAnd() throws IOException {
 * {@code opensearch-project/sql} repository, adapted to the {@code calcs} dataset
import java.util.Map;
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
    public void testWhereInOnKeyword() throws IOException {
    // the top of the subsearch; that correlated Sort(fetch>1) blocks RelDecorrelator, leaving a
            "source=" + DATASET.indexName + " | where num0 = 12.3 | fields str2, num0",
    public void testWhereMultipleChained() throws IOException {
        assertRowCount("source=" + DATASET.indexName + " | where str0 = 'FURNITURE' | fields str0", 2);
        );  
    /**  
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
 *   <li>{@code IN} / {@code NOT IN}</li>
 * Self-contained integration test for PPL {@code where} on the analytics-engine route.
    }  
    }  
 *   <li>Boolean connectives {@code AND / OR / NOT}</li>
            "source=" + DATASET.indexName + " | where not str0 in ('FURNITURE', 'OFFICE SUPPLIES') | fields str0",
 */
    // have an int1 that equals some row's int0.
        );
    public void testWhereLikeUnderscoreWildcard() throws IOException {
        assertRows(  
        // FURNITURE (2) + OFFICE SUPPLIES (6) = 8.
        // like(str0, 'FURN%') → 2 FURNITURE rows.
            "source=" + DATASET.indexName
