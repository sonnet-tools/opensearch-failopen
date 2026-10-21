        // PPL's `like(field, pattern)` emits SqlLibraryOperators.ILIKE (PPL treats like as
        assertRowCount(
            null
        for (List<Object> row : rows) {
    private static String debugRows(List<List<Object>> rows) {
        assertRowCount(
            1.4608,
        Map<String, Object> response = executePpl(ppl);
    }
    // that Isthmus's default SCALAR_SIGS covers. {@link StdOperatorRewriteAdapter} rewrites them
            20.72
        assertRowCount("source=" + DATASET.indexName + " | where int0 >= 8 | fields int0", 5);
        // "TECHNOLOGY"); a lowercase pattern would match 0 rows under case-sensitive LIKE.
        );
    // ── Comparisons (filter-side) ───────────────────────────────────────────────
    }
    public void testLogicalNotFilter() throws IOException {
    private static boolean dataProvisioned = false;
    }
package org.opensearch.analytics.qa;
    }
        assertRowCount("source=" + DATASET.indexName + " | where like(str2, '%e%') | fields str2", 11);
    public void testArithmeticModByZeroLiteral() throws IOException {
                }
        assertSingleRowField(
 * <p>Each test exercises one operator on the {@code calcs} dataset in both a filter
        );
            return;
    }
        assertRowCount(
            3
        assertCellEquals("Cell value mismatch for query: " + ppl, expected, actual);
            dataProvisioned = true;
    public void testXorViaNotEquals() throws IOException {
        // str2 values: one,two,three,five,six,eight,nine,ten,eleven,twelve,fourteen,fifteen,sixteen
        // Guards against regression to the previous ILIKE→LIKE rewrite that silently dropped
        // consumer routes it to a case-insensitive LikeExpr.
            "source=" + DATASET.indexName + " | where key = 'key00' | eval r = mod(5, 0) | fields r",
        // int0 distribution in calcs: 1,3,4,4,4,7,8,8,8,10,11 (+6 nulls). int0 > 8 → 10,11.
 * ILIKE is deliberately omitted: Substrait's default extension catalog does not declare
        Object actual = rows.get(0).get(0);
    }
    @SuppressWarnings("unused")
        assertRowCount("source=" + DATASET.indexName + " | where int0 != 8 | fields int0", 8);
        // num0=12.3, num1=8.42 → sum=20.72. Select one row by key to keep expected values stable.
        // so the same not_equal Substrait extension that powers `!=` handles this. Rows survive
    public void testEqualsInEvalProjection() throws IOException {
 * compatible open source license.
        assertSingleRowField(
        // SqlStdOperatorTable.DIVIDE, which Isthmus serialises via substrait `divide`.
    }
        assertRowCount(
                if (Math.abs(e - a) > 1e-9) {
        Map<String, Object> response = executePpl(ppl);
        );
        assertSingleRowField(
        assertSingleRowField(
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        assertSingleRowField(
            "source=" + DATASET.indexName + " | where key = 'key00' | eval p = num0 * num1 | fields p",
    // ── Project-side comparisons: eval boolean result, filter by it ───────────
    // other QA ITs in this package that dump row arrays on assertion failures.
    public void testArithmeticDivideByZeroLiteral() throws IOException {
        assertRowCount(
            "source=" + DATASET.indexName + " | eval m = (int0 = 1) or (int0 = 10) | where m = true | fields int0",
            5
    }
 *
    // ── helpers ─────────────────────────────────────────────────────────────────
    }
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 * <p>Covers: {@code =, !=, <, <=, >, >=, and, or, not, in, between (via >= AND <=),
        // IN folds to SEARCH(Sarg[...]); SargAdapter expands before substrait.
        if (expected == null || actual == null) {
            "source=" + DATASET.indexName + " | where key = 'key00' | eval r = num0 % 2 | fields r",
        assertRowCount("source=" + DATASET.indexName + " | where like(str0, '%furniture%') | fields str0", 2);
        assertRowCount(
 * ({@code where}) and a project ({@code eval}) position where applicable. Per-operator
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
     * of 12.3 is accurate to ~15 sig digits.
            assertFalse("bool0 xor bool1 row has equal values: " + row, row.get(0).equals(row.get(1)));
    }
            null
        assertRowCount(
public class OperatorCommandIT extends AnalyticsRestTestCase {
        if (Math.abs(actualD - expected) > tolerance) {
    // Suppress the "unused" warning — Arrays.toString is retained for debug parity with
import java.util.Map;
            "source=" + DATASET.indexName + " | where key = 'key00' | eval s = num0 + num1 | fields s",
        @SuppressWarnings("unchecked")
        );
     * Numeric-tolerant cell comparison: Integer/Long/Double arriving from JSON parsing
            3.88
        assertRowCount("source=" + DATASET.indexName + " | where int0 <= 4 | fields int0", 5);
        );
    private void assertSingleRowField(String ppl, Object expected) throws IOException {
    public void testArithmeticModByZero() throws IOException {
    }
        // Under PPL's case-insensitive `like` (→ substrait `ilike`) it matches both FURNITURE rows.
    public void testLogicalAndFilter() throws IOException {
        Map<String, Object> response = executePpl(
        assertEquals(message, expected, actual);
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            1e-6
import org.opensearch.client.Response;
        assertSingleRowApprox(
    // DIVIDE / MOD / CONCAT: PPL emits custom UDFs rather than the SqlStdOperatorTable entries
            1e-3
 * stable under the dataset's current 17 rows.
        // Contains 'e': one(yes),three(yes),five(yes),eight(yes),nine(yes),ten(yes),eleven(yes),
        // twelve(yes),fourteen(yes),fifteen(yes),sixteen(yes) → 11 rows (two,six exclude).
    public void testAndInEvalProjection() throws IOException {
            "source=" + DATASET.indexName + " | where int0 > 4 and int0 < 10 | fields int0",
    }
    public void testArithmeticModInEval() throws IOException {
    }
    /** MOD on zero divisor → NaN, which opensearch-sql renders as JSON null (not "NaN" string). */
        // int0 values: 1,3,4,4,4,7,8,8,8,10,11 (+6 nulls). NOT (int0 > 4) keeps 1,3,4,4,4 = 5 rows
        );
        );
 * lowers to {@code NOT_EQUALS} on booleans — validated in {@link #testXorViaNotEquals()}.
    }
    }
            "source=" + DATASET.indexName + " | where key = 'key00' | eval r = num0 % 0 | fields r",
    /** Literal-literal {@code mod(5, 0)} → null. */
            fail("Expected ~" + expected + " (tolerance " + tolerance + ") but got " + actualD + " for query: " + ppl);
    public void testArithmeticMinusInEval() throws IOException {
/*
        if (expected instanceof Number && actual instanceof Number) {
    }
    }
    /** Literal-literal {@code 22 / 0} → null. */
    @Override
    }
            "source=" + DATASET.indexName + " | eval m = not (int0 > 4) | where m = true | fields int0",
            double a = ((Number) actual).doubleValue();
    private static void assertCellEquals(String message, Object expected, Object actual) {
        assertRowCount("source=" + DATASET.indexName + " | where int0 > 8 | fields int0", 2);
    private void assertSingleRowApprox(String ppl, double expected, double tolerance) throws IOException {
    }
    public void testLikeFilter() throws IOException {
    }
        // NOT in PPL — `where not (x > y)` syntax. Negates the inner predicate structurally.
            DatasetProvisioner.provision(client(), DATASET);
        // int3=8 for key00; 8 % 3 = 2 — MOD adapter → SqlStdOperatorTable.MOD → substrait `modulus`.
    }
            return;
            0.3,
            if (Double.compare(e, a) != 0) {
        // 17 total rows. int0 = 8 matches 3 rows → 14 != 8 rows (nulls excluded by the operator).
        assertRowCount("source=" + DATASET.indexName + " | where int0 in (1, 8) | fields int0", 4);
    public void testGreaterThanFilter() throws IOException {
        );
        // (SQL three-valued logic excludes NULLs — Calcite's NOT on a NULL stays NULL, which is
    public void testInListFilter() throws IOException {
            null
        assertSingleRowField(
        // 12.3 / 8.42 ≈ 1.4608 — StdOperatorRewriteAdapter maps PPL DIVIDE UDF to
    }
    public void testNotEqualsFilter() throws IOException {
     * fp MOD reaches DataFusion via the substrait {@code modulus} fp overloads supplied by
     * may differ by concrete boxed type even when numerically equal.
            103.566
        }
        );
                // Fall back to tolerance for floating-point arithmetic residue.
            4
            "source=" + DATASET.indexName + " | where key = 'key00' | eval q = num0 / num1 | fields q",
        // PPL's between desugars to `>= AND <=`; Calcite folds contiguous ranges into a Sarg.
        );
        );
            2
        assertNotNull("xor query returned no rows block", rows);
        );
 * an {@code ilike} function, so Isthmus cannot serialize it to the shape DataFusion's
        assertEquals("Row count mismatch for query: " + ppl, expected, rows.size());
        double actualD = ((Number) actual).doubleValue();
        // eval produces a boolean, filter selects rows where it's true.
        @SuppressWarnings("unchecked")
        assertRowCount("source=" + DATASET.indexName + " | where int0 = 8", 3);
        // PPL's XOR is an infix boolean operator: `a XOR b`. It lowers to `a != b` on booleans
        // truthy-equivalent to false for filtering).
        // (PPLFuncImpTable maps XOR → SqlStdOperatorTable.NOT_EQUALS with BOOLEAN type checker),
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            2
            2
    // ── LIKE ─────────────────────────────────────────────────────────────────
    public void testLogicalOrFilter() throws IOException {
 *
            "source=" + DATASET.indexName + " | where key = 'key00' | eval d = num0 - num1 | fields d",
    public void testArithmeticPlusInEval() throws IOException {
    public void testBetweenAsRangeFilter() throws IOException {
        assertNotNull("Cell is null for query: " + ppl, actual);
    }
        assertSingleRowApprox(
import java.util.List;
        );
    }
}
    public void testGreaterThanOrEqualFilter() throws IOException {
        );
    }
        assertRowCount(
    public void testLikeFilterIsCaseInsensitive() throws IOException {
        Map<String, Object> response = executePpl(ppl);
    public void testEqualsFilter() throws IOException {
        assertRowCount("source=" + DATASET.indexName + " | where int0 < 4 | fields int0", 2);
        );
    }
                    fail(message + ": expected <" + expected + "> but was <" + actual + ">");
 *  (comparison / arithmetic / logical / concat) routed through the analytics-engine PPL path to DataFusion.
     * only). num0=12.3 (fp64) % 2 = ~0.3 — within 1e-6 of decimal 0.3 because fp64 representation
        return Arrays.toString(rows.toArray());
            null
import java.util.Arrays;
        Object actual = rows.get(0).get(0);
            double e = ((Number) expected).doubleValue();
            7
        assertTrue("xor should return at least 1 row, got " + rows.size(), !rows.isEmpty());
        // int0 >= 8 → 8,8,8,10,11
    // ── Arithmetic (project-side via eval + filter for verification) ───────────
        }
            "source=" + DATASET.indexName + " | where key = 'key00' | eval r = int3 % 3 | fields r",
        assertSingleRowField(
    // catalog's {@code divide} / {@code modulus} / {@code concat} entries resolve.
import org.opensearch.client.Request;
    public void testArithmeticModFp() throws IOException {
    protected void onBeforeQuery() throws IOException {
        // the filter only when bool0 and bool1 differ.
    public void testArithmeticDivideInEval() throws IOException {
            "source=" + DATASET.indexName + " | where key = 'key00' | eval q = 22 / 0 | fields q",
            "source=" + DATASET.indexName + " | where bool0 xor bool1 | fields bool0, bool1"
        // int0 > 4 AND int0 < 10 → 7,8,8,8 = 4 rows.
            "source=" + DATASET.indexName + " | where int0 >= 4 and int0 <= 8 | fields int0",
     * {@code opensearch_arithmetic_overloads.yaml} (standard substrait declares integer impls
 *
        // extension declared in opensearch_scalar_functions.yaml; DataFusion's substrait
 * Rust substrait consumer expects; see the Group F tracker for status.
    }
    // ── Logical (filter-side) ──────────────────────────────────────────────────
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to
        );
        assertSingleRowField(
        if (dataProvisioned == false) {
    public void testLessThanFilter() throws IOException {
    }
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        }
            assertEquals(message, expected, actual);
            "source=" + DATASET.indexName + " | eval m = (int0 = 8) | where m = true | fields int0",
            "source=" + DATASET.indexName + " | where key = 'key00' | eval q = num0 / 0 | fields q",
    // ── XOR (PPL xor → NOT_EQUALS on BOOLEAN) ──────────────────────────────────
    }
        }
        assertEquals("Expected exactly 1 row for query: " + ppl, 1, rows.size());
    }
    }
    public void testArithmeticDivideByZero() throws IOException {
        );
    /**
        // 12.3 * 8.42 = 103.566
    // to the standard Calcite operators before substrait serialisation so the default extension
 */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            5
        );
        // case-insensitive by default). Isthmus serializes ILIKE via the custom `ilike`
    }
        // case-insensitivity. str0 values are all uppercase ("FURNITURE", "OFFICE SUPPLIES",
/**
    }
    public void testLessThanOrEqualFilter() throws IOException {
            4
        // Pattern "%e%" matches every str2 containing an 'e'.
            "source=" + DATASET.indexName + " | where int0 = 1 or int0 = 10 | fields int0",
    /**
    private void assertRowCount(String ppl, int expected) throws IOException {
 * inputs are hand-picked so that filter row counts and eval cell values are small and
    public void testArithmeticTimesInEval() throws IOException {
     */
 * like, +, -, *, /, %, concat (||)}. XOR is the PPL {@code xor} function which
    }
            }
    // ── IN / BETWEEN (Sarg fold) ───────────────────────────────────────────────
        }
    public void testOrInEvalProjection() throws IOException {
            "source=" + DATASET.indexName + " | eval m = (int0 > 4) and (int0 < 10) | where m = true | fields int0",
    /** DIVIDE by zero → ±Infinity, which opensearch-sql renders as JSON null. */
import java.io.IOException;
        @SuppressWarnings("unchecked")
        assertEquals("Expected exactly 1 row for query: " + ppl, 1, rows.size());
        // The calcs dataset contains rows where bool0 != bool1; assert the filter surfaces them.
        );
 */
    public void testNotInEvalProjection() throws IOException {
     */
            "source=" + DATASET.indexName + " | where not (int0 > 4) | fields int0",
        @SuppressWarnings("unchecked")
