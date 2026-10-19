            oneRow() + "| eval result = mvappend(1, 2, 3) | fields result",
    // via {@code leastRestrictive} + DECIMAL → DOUBLE promotion + operand
        assertFirstRowList(
 * surfaces as {@code ARRAY[UNKNOWN]}/{@code ARRAY[VARCHAR]} in the column ref,
        Map<String, Object> response = executePpl(ppl);
 * <p>{@code mvappend} flattens an arbitrary mix of scalar and array operands
        if (expected == null || actual == null) {
        assertTrue(
    //   testMvappendWithIntAndDouble        — 1, 2.5 (DECIMAL → DOUBLE promotion + pre-cast)
            oneRow()
    // opensearch-project/sql#5424 (the {@code MVAppendFunctionImpl} widening
        assertFirstRowList(
            Arrays.asList(1, 2, 3, 4));
    // ── array operands (uniform element type) ───────────────────────────────
 * operands into singleton {@code make_array} calls so substrait's variadic-{@code any1}
 * <p>The {@code testMvappendInWhereClause} variant (filter predicate on an
 * adapter ({@link org.opensearch.be.datafusion.MvappendAdapter}) reshapes scalar
                + " result = mvappend(arr1, arr2, arr3) | fields result",
 * {@code CalciteMVAppendFunctionIT} one-test-method-to-one for the subset of
    protected void onBeforeQuery() throws IOException {
     *  deterministic. */
        assertEquals(
    // ── tests gated on SQL companion #5424 ──────────────────────────────────
            "Expected list result for query [" + ppl + "] but got: " + cell + " (" + cell.getClass() + ")",
        assertFirstRowList(
            oneRow()
            // calcs row key00: str0='FURNITURE', str1='CLAMP ON LAMPS'
 * SPDX-License-Identifier: Apache-2.0
    }
    //   testMvappendWithNumericArrays       — array(1.5,2.5), array(3.5), 4.5 (nullability bridge)
 * {@code mvappend('test', nullif(1,1), 2)}) are absent because Calcite legitimately
 * Empty-array operand tests are also absent — the empty {@code array()} default
    private static void assertCellEquals(Object expected, Object actual) {
            assertCellEquals(expected.get(i), actual.get(i));
    }
 * <p>Tests covering genuinely heterogeneous mvappend signatures
 * predicate tree — that's a separate planner refactor tracked under #21554's
    /** Two VARCHAR field references → uniform {@code ARRAY[VARCHAR]}. Anchored
    private String oneRow() {
        assertNotNull("Expected non-null array result for query [" + ppl + "]", cell);
    public void testMvappendWithMultipleElements() throws IOException {
 *
    public void testMvappendWithSingleElement() throws IOException {
    }
import java.util.List;
    public void testMvappendWithRealFields() throws IOException {
     *  to a specific row by filtering on {@code key} so the assertion is
        return "source=" + DATASET.indexName + " | head 1 ";
public class MVAppendFunctionIT extends AnalyticsRestTestCase {
/*
import org.opensearch.client.Response;
 *
    public void testMvappendWithArrayFlattening() throws IOException {
 * tests that pass on the analytics-engine path.
        @SuppressWarnings("unchecked")
                + "| eval arr1 = array(1, 2), arr2 = array(3, 4), result = mvappend(arr1, arr2) | fields result",
    // Add them back once #5424 lands. Their SQL-side counterparts are verified
            "source=" + DATASET.indexName
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
 *
 * "What's left" section.
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
 * The OpenSearch Contributors require contributions made to
    // in CalciteMVAppendFunctionIT against the analytics-engine route.
 * compatible open source license.
 * ({@code mvappend(1, 'text', 2.5)}, {@code mvappend(age, 'years', 'old')},
    @Override
        if (dataProvisioned == false) {
import java.util.Map;
    // {@code unified-query-core:3.7.0.0-SNAPSHOT}. Without it, these collapse
    //   testMvappendWithMixedArrayAndScalar — array(1,2), 3, 4 (nullability bridge)
    }
            assertEquals(expected, actual);
                + " | where key='key00' | head 1 | eval result = mvappend(str0, str1) | fields result",
            Arrays.asList("FURNITURE", "CLAMP ON LAMPS"));
    //
                ((Number) actual).doubleValue(),
            oneRow() + "| eval result = mvappend('hello', 'world') | fields result",
                ((Number) expected).doubleValue(),
    //   testMvappendWithComplexExpression   — array(int0), array(int0*2), int0+10 (nullability bridge)
    // ── uniform-typed scalar variadic ───────────────────────────────────────
 * Arrow's Union arrays aren't operated on by {@code datafusion-functions-array}.
        assertEquals(expected, actual);
    private static boolean dataProvisioned = false;
    // ── field references ────────────────────────────────────────────────────
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
            DatasetProvisioner.provision(client(), DATASET);
        assertFirstRowList(
            "Length mismatch for query [" + ppl + "]: expected " + expected + " but got " + actual,
 * ARRAY field) is also absent because the analytics-engine planner's filter
            Arrays.asList(1, 2, 3));
/**
 */
    // ── helpers ─────────────────────────────────────────────────────────────
 * shape sees a uniform {@code list[componentType]} across every position.
 * which type-inference can't reach back through the project chain to ignore.
    }
            assertEquals(
 * analytics-engine route. Mirrors the SQL plugin's
        }
                1e-9);
    public void testMvappendWithNestedArrays() throws IOException {
    // pre-cast in {@code MVAppendImplementor}) is merged and republished as
            Arrays.asList(42));
            Arrays.asList("a", "b", "c", "d", "e"));
    }
    }
            oneRow() + "| eval result = mvappend(42) | fields result",
 * End-to-end coverage for PPL {@code mvappend(arg1, arg2, …)} on the
 *
        if (expected instanceof Number && actual instanceof Number) {
        assertFirstRowList(
    public void testMvappendWithStringValues() throws IOException {
                + "| eval arr1 = array('a', 'b'), arr2 = array('c'), arr3 = array('d', 'e'),"
    }
            cell instanceof List);
            return;
            expected.size(),
import java.io.IOException;
            actual.size());
            Arrays.asList("hello", "world"));
    // to {@code ARRAY[ANY]} which substrait can't encode:
    private Object firstRowFirstCell(String ppl) throws IOException {
 */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        for (int i = 0; i < expected.size(); i++) {
    // The following SQL-side tests are intentionally absent until
import org.opensearch.client.Request;
    }
 * into a single array, dropping null elements. Onboarded as a custom Rust UDF
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
    //
            dataProvisioned = true;
package org.opensearch.analytics.qa;
    }
                "Numeric value mismatch",
        List<?> actual = (List<?>) cell;
    private void assertFirstRowList(String ppl, List<?> expected) throws IOException {
        return rows.get(0).get(0);
}
        }
        }
    }
        }
            return;
 * rule rejects {@code EQUALS} on an ARRAY field without walking into the
        Object cell = firstRowFirstCell(ppl);
 * ({@code udf::mvappend}) registered at session-context creation; the Java
 * widens those to {@code ARRAY[ANY]} — substrait can't encode {@code ANY}, and
        assertFirstRowList(
