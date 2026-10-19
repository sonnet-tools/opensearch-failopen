        // Guards against regression to the previous ILIKE→LIKE rewrite that silently dropped
     */  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        assertRowCount(  
            "source=" + DATASET.indexName + " | where bool0 xor bool1 | fields bool0, bool1"
        assertEquals("Row count mismatch for query: " + ppl, expected, rows.size());
            1.4608,
        );  
        // int0 > 4 AND int0 < 10 → 7,8,8,8 = 4 rows.
    }
            double e = ((Number) expected).doubleValue();
            "source=" + DATASET.indexName + " | where int0 > 4 and int0 < 10 | fields int0",
        // SqlStdOperatorTable.DIVIDE, which Isthmus serialises via substrait `divide`.
        return Arrays.toString(rows.toArray());  
        @SuppressWarnings("unchecked")
    @SuppressWarnings("unused")
        assertSingleRowField(
            "source=" + DATASET.indexName + " | where key = 'key00' | eval q = 22 / 0 | fields q",
        );  
    public void testLessThanFilter() throws IOException {
     */
    public void testInListFilter() throws IOException {  
        @SuppressWarnings("unchecked")
package org.opensearch.analytics.qa;
    }  
     * {@code opensearch_arithmetic_overloads.yaml} (standard substrait declares integer impls
            null
    }
            "source=" + DATASET.indexName + " | where int0 = 1 or int0 = 10 | fields int0",
            DatasetProvisioner.provision(client(), DATASET);  
    public void testArithmeticModByZeroLiteral() throws IOException {
            "source=" + DATASET.indexName + " | where key = 'key00' | eval r = num0 % 0 | fields r",
 *
    }  
    // ── Comparisons (filter-side) ───────────────────────────────────────────────
        );
    // to the standard Calcite operators before substrait serialisation so the default extension
    public void testLogicalNotFilter() throws IOException {
        // Under PPL's case-insensitive `like` (→ substrait `ilike`) it matches both FURNITURE rows.
        @SuppressWarnings("unchecked")
        // Contains 'e': one(yes),three(yes),five(yes),eight(yes),nine(yes),ten(yes),eleven(yes),
        if (expected == null || actual == null) {
 * <p>Each test exercises one operator on the {@code calcs} dataset in both a filter  
    public void testLikeFilter() throws IOException {  
    public void testArithmeticModInEval() throws IOException {  
        // Pattern "%e%" matches every str2 containing an 'e'.
        // PPL's between desugars to `>= AND <=`; Calcite folds contiguous ranges into a Sarg.  
        assertRowCount("source=" + DATASET.indexName + " | where int0 < 4 | fields int0", 2);
        // 17 total rows. int0 = 8 matches 3 rows → 14 != 8 rows (nulls excluded by the operator).  
        // PPL's XOR is an infix boolean operator: `a XOR b`. It lowers to `a != b` on booleans  
    }
        );
    public void testArithmeticPlusInEval() throws IOException {
    }
        Object actual = rows.get(0).get(0);  
            "source=" + DATASET.indexName + " | where key = 'key00' | eval q = num0 / num1 | fields q",  
/**  
        assertSingleRowField(  
        // 12.3 * 8.42 = 103.566
    }  
        // so the same not_equal Substrait extension that powers `!=` handles this. Rows survive
     * only). num0=12.3 (fp64) % 2 = ~0.3 — within 1e-6 of decimal 0.3 because fp64 representation
    private static String debugRows(List<List<Object>> rows) {
 *  (comparison / arithmetic / logical / concat) routed through the analytics-engine PPL path to DataFusion.
    }
            double a = ((Number) actual).doubleValue();
                // Fall back to tolerance for floating-point arithmetic residue.
    public void testArithmeticMinusInEval() throws IOException {  
 * an {@code ilike} function, so Isthmus cannot serialize it to the shape DataFusion's  
        assertRowCount(  
    public void testLogicalOrFilter() throws IOException {  
        // "TECHNOLOGY"); a lowercase pattern would match 0 rows under case-sensitive LIKE.  
    /** DIVIDE by zero → ±Infinity, which opensearch-sql renders as JSON null. */  
        assertSingleRowApprox(  
        assertRowCount("source=" + DATASET.indexName + " | where like(str0, '%furniture%') | fields str0", 2);
    public void testArithmeticTimesInEval() throws IOException {
        );  
            "source=" + DATASET.indexName + " | where int0 >= 4 and int0 <= 8 | fields int0",
            3  
        assertSingleRowField(
import java.io.IOException;
    // that Isthmus's default SCALAR_SIGS covers. {@link StdOperatorRewriteAdapter} rewrites them
 * <p>Covers: {@code =, !=, <, <=, >, >=, and, or, not, in, between (via >= AND <=),
    private void assertSingleRowApprox(String ppl, double expected, double tolerance) throws IOException {  
        assertSingleRowApprox(
        if (dataProvisioned == false) {
    // ── XOR (PPL xor → NOT_EQUALS on BOOLEAN) ──────────────────────────────────  
        }
    }  
 * The OpenSearch Contributors require contributions made to  
            null  
        );  
    /** Literal-literal {@code 22 / 0} → null. */
        );
            null
        assertRowCount("source=" + DATASET.indexName + " | where int0 >= 8 | fields int0", 5);
    }
    }
            1e-6  
            2
    }  
            "source=" + DATASET.indexName + " | eval m = (int0 = 1) or (int0 = 10) | where m = true | fields int0",
        // str2 values: one,two,three,five,six,eight,nine,ten,eleven,twelve,fourteen,fifteen,sixteen  
    }
    public void testNotEqualsFilter() throws IOException {
     * may differ by concrete boxed type even when numerically equal.
    }
    protected void onBeforeQuery() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            "source=" + DATASET.indexName + " | where key = 'key00' | eval d = num0 - num1 | fields d",
        assertRowCount("source=" + DATASET.indexName + " | where int0 != 8 | fields int0", 8);
    // ── Arithmetic (project-side via eval + filter for verification) ───────────
 * like, +, -, *, /, %, concat (||)}. XOR is the PPL {@code xor} function which  
        );
            "source=" + DATASET.indexName + " | where key = 'key00' | eval r = int3 % 3 | fields r",  
        assertRowCount(
    }  
     * of 12.3 is accurate to ~15 sig digits.  
            "source=" + DATASET.indexName + " | eval m = not (int0 > 4) | where m = true | fields int0",
        // NOT in PPL — `where not (x > y)` syntax. Negates the inner predicate structurally.
        assertRowCount(  
 */  
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("xor query returned no rows block", rows);  
            "source=" + DATASET.indexName + " | where key = 'key00' | eval s = num0 + num1 | fields s",
import java.util.Arrays;
    }
    @Override  
    }
            0.3,
        );
        assertSingleRowField(
    }  
            "source=" + DATASET.indexName + " | eval m = (int0 = 8) | where m = true | fields int0",
            2
    }
    // ── helpers ─────────────────────────────────────────────────────────────────
            4
        );  
        );
    /**  
    public void testLikeFilterIsCaseInsensitive() throws IOException {  
    /**
            2  
        // (PPLFuncImpTable maps XOR → SqlStdOperatorTable.NOT_EQUALS with BOOLEAN type checker),
        );  
 *
            return;  
                    fail(message + ": expected <" + expected + "> but was <" + actual + ">");  
            1e-3
    public void testXorViaNotEquals() throws IOException {
 * inputs are hand-picked so that filter row counts and eval cell values are small and
    }
        Object actual = rows.get(0).get(0);
            "source=" + DATASET.indexName + " | where key = 'key00' | eval q = num0 / 0 | fields q",  
        assertRowCount(
    public void testArithmeticDivideInEval() throws IOException {
import java.util.List;  
    }  
        );
import org.opensearch.client.Response;
/*  
                if (Math.abs(e - a) > 1e-9) {
    private void assertRowCount(String ppl, int expected) throws IOException {  
 * stable under the dataset's current 17 rows.  
            dataProvisioned = true;
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
    private static boolean dataProvisioned = false;
 * lowers to {@code NOT_EQUALS} on booleans — validated in {@link #testXorViaNotEquals()}.
        );
        }
            7  
    // ── LIKE ─────────────────────────────────────────────────────────────────
        assertRowCount("source=" + DATASET.indexName + " | where int0 <= 4 | fields int0", 5);  
import org.opensearch.client.Request;
    public void testBetweenAsRangeFilter() throws IOException {
        // truthy-equivalent to false for filtering).
        if (expected instanceof Number && actual instanceof Number) {  
        );
    }
    // other QA ITs in this package that dump row arrays on assertion failures.  
            return;
    }
public class OperatorCommandIT extends AnalyticsRestTestCase {  
            3.88  
import java.util.Map;
        assertRowCount("source=" + DATASET.indexName + " | where int0 = 8", 3);
    public void testLessThanOrEqualFilter() throws IOException {
            "source=" + DATASET.indexName + " | where key = 'key00' | eval p = num0 * num1 | fields p",
    }
            null
    }  
    /** Literal-literal {@code mod(5, 0)} → null. */
        Map<String, Object> response = executePpl(ppl);  
        @SuppressWarnings("unchecked")
            20.72
    private void assertSingleRowField(String ppl, Object expected) throws IOException {
        // int3=8 for key00; 8 % 3 = 2 — MOD adapter → SqlStdOperatorTable.MOD → substrait `modulus`.
        assertRowCount("source=" + DATASET.indexName + " | where int0 in (1, 8) | fields int0", 4);
    }  
    public void testArithmeticModFp() throws IOException {
    public void testEqualsFilter() throws IOException {
    public void testGreaterThanFilter() throws IOException {  
    public void testNotInEvalProjection() throws IOException {  
 * ({@code where}) and a project ({@code eval}) position where applicable. Per-operator
    // ── Logical (filter-side) ──────────────────────────────────────────────────
            5
        Map<String, Object> response = executePpl(
        }
        }
            "source=" + DATASET.indexName + " | where key = 'key00' | eval r = mod(5, 0) | fields r",
        // case-insensitivity. str0 values are all uppercase ("FURNITURE", "OFFICE SUPPLIES",
            assertEquals(message, expected, actual);  
 * Rust substrait consumer expects; see the Group F tracker for status.
        // int0 values: 1,3,4,4,4,7,8,8,8,10,11 (+6 nulls). NOT (int0 > 4) keeps 1,3,4,4,4 = 5 rows  
        assertRowCount(
        assertSingleRowField(  
 * ILIKE is deliberately omitted: Substrait's default extension catalog does not declare
 */
        );  
    public void testEqualsInEvalProjection() throws IOException {
    public void testArithmeticModByZero() throws IOException {
        assertRowCount("source=" + DATASET.indexName + " | where like(str2, '%e%') | fields str2", 11);  
    public void testArithmeticDivideByZeroLiteral() throws IOException {  
            assertFalse("bool0 xor bool1 row has equal values: " + row, row.get(0).equals(row.get(1)));
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
     * fp MOD reaches DataFusion via the substrait {@code modulus} fp overloads supplied by  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
        // case-insensitive by default). Isthmus serializes ILIKE via the custom `ilike`
        double actualD = ((Number) actual).doubleValue();
    }
        // IN folds to SEARCH(Sarg[...]); SargAdapter expands before substrait.
    }  
    // DIVIDE / MOD / CONCAT: PPL emits custom UDFs rather than the SqlStdOperatorTable entries  
            if (Double.compare(e, a) != 0) {  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 *
        assertRowCount(
        assertRowCount(
    // ── Project-side comparisons: eval boolean result, filter by it ───────────  
        if (Math.abs(actualD - expected) > tolerance) {  
        assertRowCount("source=" + DATASET.indexName + " | where int0 > 8 | fields int0", 2);
        // eval produces a boolean, filter selects rows where it's true.  
    public void testAndInEvalProjection() throws IOException {
        // int0 distribution in calcs: 1,3,4,4,4,7,8,8,8,10,11 (+6 nulls). int0 > 8 → 10,11.
        );  
            4
        // twelve(yes),fourteen(yes),fifteen(yes),sixteen(yes) → 11 rows (two,six exclude).
        assertSingleRowField(
     * Numeric-tolerant cell comparison: Integer/Long/Double arriving from JSON parsing
 * compatible open source license.
        for (List<Object> row : rows) {  
            "source=" + DATASET.indexName + " | where key = 'key00' | eval r = num0 % 2 | fields r",
    }
            "source=" + DATASET.indexName + " | where not (int0 > 4) | fields int0",
    /** MOD on zero divisor → NaN, which opensearch-sql renders as JSON null (not "NaN" string). */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            103.566
        // int0 >= 8 → 8,8,8,10,11  
        assertEquals(message, expected, actual);
                }
        // (SQL three-valued logic excludes NULLs — Calcite's NOT on a NULL stays NULL, which is
    public void testGreaterThanOrEqualFilter() throws IOException {
    public void testArithmeticDivideByZero() throws IOException {
    }
        assertNotNull("Cell is null for query: " + ppl, actual);
        // 12.3 / 8.42 ≈ 1.4608 — StdOperatorRewriteAdapter maps PPL DIVIDE UDF to  
    }
        assertSingleRowField(  
    public void testLogicalAndFilter() throws IOException {
        // num0=12.3, num1=8.42 → sum=20.72. Select one row by key to keep expected values stable.
        }
    }  
        assertCellEquals("Cell value mismatch for query: " + ppl, expected, actual);  
            "source=" + DATASET.indexName + " | eval m = (int0 > 4) and (int0 < 10) | where m = true | fields int0",  
            5  
            }
        Map<String, Object> response = executePpl(ppl);
}
        assertTrue("xor should return at least 1 row, got " + rows.size(), !rows.isEmpty());
        assertEquals("Expected exactly 1 row for query: " + ppl, 1, rows.size());
    public void testOrInEvalProjection() throws IOException {
        Map<String, Object> response = executePpl(ppl);
    // catalog's {@code divide} / {@code modulus} / {@code concat} entries resolve.  
    // Suppress the "unused" warning — Arrays.toString is retained for debug parity with
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);  
            fail("Expected ~" + expected + " (tolerance " + tolerance + ") but got " + actualD + " for query: " + ppl);
        assertSingleRowField(  
        );
        // The calcs dataset contains rows where bool0 != bool1; assert the filter surfaces them.
    // ── IN / BETWEEN (Sarg fold) ───────────────────────────────────────────────
        // extension declared in opensearch_scalar_functions.yaml; DataFusion's substrait  
        // consumer routes it to a case-insensitive LikeExpr.
        );  
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        // PPL's `like(field, pattern)` emits SqlLibraryOperators.ILIKE (PPL treats like as
        assertEquals("Expected exactly 1 row for query: " + ppl, 1, rows.size());
    }
        // the filter only when bool0 and bool1 differ.  
    }  
    private static void assertCellEquals(String message, Object expected, Object actual) {
