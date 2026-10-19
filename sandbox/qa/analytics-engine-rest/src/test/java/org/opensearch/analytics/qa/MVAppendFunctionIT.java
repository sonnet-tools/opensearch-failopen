            DatasetProvisioner.provision(client(), DATASET);
            return;
            Arrays.asList("hello", "world"));  
 * {@code mvappend('test', nullif(1,1), 2)}) are absent because Calcite legitimately  
import java.util.Map;
 * operands into singleton {@code make_array} calls so substrait's variadic-{@code any1}
    // Add them back once #5424 lands. Their SQL-side counterparts are verified
import java.util.List;  
        Map<String, Object> response = executePpl(ppl);  
    }  
 * adapter ({@link org.opensearch.be.datafusion.MvappendAdapter}) reshapes scalar  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    }
 * ARRAY field) is also absent because the analytics-engine planner's filter
            oneRow() + "| eval result = mvappend(42) | fields result",
 * rule rejects {@code EQUALS} on an ARRAY field without walking into the  
 */  
        List<?> actual = (List<?>) cell;  
 * ({@code udf::mvappend}) registered at session-context creation; the Java
 * The OpenSearch Contributors require contributions made to  
        assertFirstRowList(
    public void testMvappendWithArrayFlattening() throws IOException {
            "Length mismatch for query [" + ppl + "]: expected " + expected + " but got " + actual,
    public void testMvappendWithMultipleElements() throws IOException {  
        }
    // opensearch-project/sql#5424 (the {@code MVAppendFunctionImpl} widening
     *  to a specific row by filtering on {@code key} so the assertion is
            return;  
        assertFirstRowList(
 *  
    // {@code unified-query-core:3.7.0.0-SNAPSHOT}. Without it, these collapse
    @Override
    }  
 * widens those to {@code ARRAY[ANY]} — substrait can't encode {@code ANY}, and
 * <p>The {@code testMvappendInWhereClause} variant (filter predicate on an
    //   testMvappendWithMixedArrayAndScalar — array(1,2), 3, 4 (nullability bridge)
import org.opensearch.client.Response;
 * <p>{@code mvappend} flattens an arbitrary mix of scalar and array operands  
        if (expected == null || actual == null) {
                + " | where key='key00' | head 1 | eval result = mvappend(str0, str1) | fields result",
    }
        assertFirstRowList(  
            actual.size());
 * analytics-engine route. Mirrors the SQL plugin's
    // ── tests gated on SQL companion #5424 ──────────────────────────────────  
            "source=" + DATASET.indexName  
    //   testMvappendWithIntAndDouble        — 1, 2.5 (DECIMAL → DOUBLE promotion + pre-cast)
        assertFirstRowList(
    // via {@code leastRestrictive} + DECIMAL → DOUBLE promotion + operand  
    private void assertFirstRowList(String ppl, List<?> expected) throws IOException {  
        return "source=" + DATASET.indexName + " | head 1 ";
    private String oneRow() {  
    }
            Arrays.asList("FURNITURE", "CLAMP ON LAMPS"));  
 * <p>Tests covering genuinely heterogeneous mvappend signatures
    public void testMvappendWithStringValues() throws IOException {  
        @SuppressWarnings("unchecked")
        if (dataProvisioned == false) {  
    // in CalciteMVAppendFunctionIT against the analytics-engine route.
 * Empty-array operand tests are also absent — the empty {@code array()} default  
                "Numeric value mismatch",
                1e-9);
        }
        }
        Object cell = firstRowFirstCell(ppl);
        assertEquals(expected, actual);
 * "What's left" section.
            Arrays.asList("a", "b", "c", "d", "e"));
        assertTrue(  
    public void testMvappendWithRealFields() throws IOException {
import org.opensearch.client.Request;
            expected.size(),  
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
        return rows.get(0).get(0);
import java.io.IOException;
public class MVAppendFunctionIT extends AnalyticsRestTestCase {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
 * surfaces as {@code ARRAY[UNKNOWN]}/{@code ARRAY[VARCHAR]} in the column ref,
    /** Two VARCHAR field references → uniform {@code ARRAY[VARCHAR]}. Anchored
    public void testMvappendWithSingleElement() throws IOException {  
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);  
            // calcs row key00: str0='FURNITURE', str1='CLAMP ON LAMPS'
        assertFirstRowList(
 * predicate tree — that's a separate planner refactor tracked under #21554's
    //   testMvappendWithComplexExpression   — array(int0), array(int0*2), int0+10 (nullability bridge)
 * Arrow's Union arrays aren't operated on by {@code datafusion-functions-array}.
 * shape sees a uniform {@code list[componentType]} across every position.
            assertCellEquals(expected.get(i), actual.get(i));  
            Arrays.asList(42));  
            Arrays.asList(1, 2, 3));  
    // pre-cast in {@code MVAppendImplementor}) is merged and republished as
                ((Number) expected).doubleValue(),  
                + "| eval arr1 = array('a', 'b'), arr2 = array('c'), arr3 = array('d', 'e'),"  
        assertNotNull("Expected non-null array result for query [" + ppl + "]", cell);
            assertEquals(
 * End-to-end coverage for PPL {@code mvappend(arg1, arg2, …)} on the
    // ── helpers ─────────────────────────────────────────────────────────────
            oneRow()
                + "| eval arr1 = array(1, 2), arr2 = array(3, 4), result = mvappend(arr1, arr2) | fields result",
 * which type-inference can't reach back through the project chain to ignore.
    }
 * this file be licensed under the Apache-2.0 license or a
 *  
    }
 * into a single array, dropping null elements. Onboarded as a custom Rust UDF
    //  
 * SPDX-License-Identifier: Apache-2.0
 */  
    // The following SQL-side tests are intentionally absent until
            Arrays.asList(1, 2, 3, 4));  
import java.util.Arrays;
        assertEquals(
 * tests that pass on the analytics-engine path.
     *  deterministic. */  
            oneRow()
    // ── field references ────────────────────────────────────────────────────
    public void testMvappendWithNestedArrays() throws IOException {  
    protected void onBeforeQuery() throws IOException {
/**  
    // ── array operands (uniform element type) ───────────────────────────────  
        }  
        if (expected instanceof Number && actual instanceof Number) {  
/*  
    //
 * ({@code mvappend(1, 'text', 2.5)}, {@code mvappend(age, 'years', 'old')},
    }  
    // to {@code ARRAY[ANY]} which substrait can't encode:  
package org.opensearch.analytics.qa;
                + " result = mvappend(arr1, arr2, arr3) | fields result",
    }
    private static boolean dataProvisioned = false;
        for (int i = 0; i < expected.size(); i++) {
    private Object firstRowFirstCell(String ppl) throws IOException {
 *
 * {@code CalciteMVAppendFunctionIT} one-test-method-to-one for the subset of  
            "Expected list result for query [" + ppl + "] but got: " + cell + " (" + cell.getClass() + ")",
 * compatible open source license.
    //   testMvappendWithNumericArrays       — array(1.5,2.5), array(3.5), 4.5 (nullability bridge)  
}
            cell instanceof List);
    // ── uniform-typed scalar variadic ───────────────────────────────────────
    private static void assertCellEquals(Object expected, Object actual) {
        assertFirstRowList(
 *
    }
            oneRow() + "| eval result = mvappend('hello', 'world') | fields result",
            dataProvisioned = true;
    }
                ((Number) actual).doubleValue(),
            oneRow() + "| eval result = mvappend(1, 2, 3) | fields result",
            assertEquals(expected, actual);  
