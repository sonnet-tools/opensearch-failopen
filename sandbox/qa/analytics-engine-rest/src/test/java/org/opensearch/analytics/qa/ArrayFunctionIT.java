 *  
 *   <li>{@code mvzip(left, right [, sep])} → custom Rust UDF {@code udf::mvzip}.</li>
            oneRow() + "| eval result = mvjoin(array('1', '2', '3'), ' | ') | fields result",
 *   <li>{@code mvdedup(arr)} → DataFusion native {@code array_distinct}.</li>
            Arrays.asList("1", "demo"));  
        assertTrue(
    }
 *   <li>{@code mvjoin(arr, sep)} → DataFusion {@code array_to_string} via  
            return;  
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
    private void assertFirstRowList(String ppl, List<?> expected) throws IOException {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            Arrays.asList(10, 20, 30));
    public void testArrayWithString() throws IOException {  
            oneRow() + "| eval result = mvfind(array('apple', 'banana'), 'zzz') | fields result");
    }  
    }  
 *
    // ── array(...) constructor ──────────────────────────────────────────────  
    }  
            "x-->y");
        assertFirstRowDouble(  
    }
import java.util.Arrays;
        if (expected == null || actual == null) {
            Arrays.asList("a", "b", "c"));
            Arrays.asList(2, 3, 4));
        return rows.get(0).get(0);
            oneRow() + "| eval arr = array(7, 7, 7) | eval result = mvdedup(arr) | fields result",
 * SPDX-License-Identifier: Apache-2.0
 *   <li>{@code mvfind(arr, regex)} → custom Rust UDF {@code udf::mvfind}.</li>  
 * this file be licensed under the Apache-2.0 license or a
    public void testMvdedupWithDuplicates() throws IOException {  
            oneRow() + "| eval arr = array(1, 2, 2, 3, 3, 3) | eval result = mvdedup(arr) | fields result",
            assertCellEquals(expected.get(i), actual.get(i));
    }  
     *  via {@code ArrayFunctionImpl.internalCast}. */
    private void assertFirstRowDouble(String ppl, double expected) throws IOException {
    }
            Arrays.asList(7));  
    public void testMvzipBasic() throws IOException {
    }
        Object cell = firstRowFirstCell(ppl);
            actual.size());
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
            oneRow() + "| eval result = array(1, -1.5, 2, 1.0) | fields result",  
    }  
        assertFirstRowList(
        @SuppressWarnings("unchecked")  
        assertFirstRowList(  
        if (expected instanceof Number && actual instanceof Number) {
            "Expected list result for query [" + ppl + "] but got: " + cell + " (" + cell.getClass() + ")",
        assertFirstRowString(  
     *  {@code concat} Sig bridge added in this PR. Without that bridge the call fails substrait
    // ── helpers ─────────────────────────────────────────────────────────────
        assertEquals(expected, actual);
        return "source=" + DATASET.indexName + " | head 1 ";  
        assertFirstRowList(
        assertFirstRowDouble(
 *   <li>{@code mvindex(arr, N)} (single-element form) → DataFusion {@code array_element}  
 * Substrait → DataFusion). Mirrors the SQL plugin's  
            Arrays.asList(3, 4, 5));
            oneRow() + "| eval arr = array(10, 20, 30) | eval result = mvindex(arr, -1) | fields result",  
 *   <li>{@code split(str, delim)} (returns array) → DataFusion {@code string_to_array}.</li>
    /** Returns the 0-based index of the first array element matching the regex. */
    public void testMvzipWithCustomDelimiter() throws IOException {
 */  
            Arrays.asList("a,1", "b,2", "c,3"));
    /** Negative indices — DataFusion's array_slice supports them natively. */
            oneRow() + "| eval result = mvfind(array('apple', 'banana', 'cherry'), 'ban.*') | fields result",
        assertFirstRowList(
        Object cell = firstRowFirstCell(ppl);
                ((Number) actual).doubleValue(),  
public class ArrayFunctionIT extends AnalyticsRestTestCase {
 * <ul>
 *       via {@link org.opensearch.be.datafusion.ArrayElementAdapter}.</li>
        assertFirstRowNull(  
            4.0);
 * scan.
     *  via {@link org.opensearch.be.datafusion.ArraySliceAdapter}. Without the rewrite the result
            oneRow() + "| eval result = mvjoin(array('a', 'b', 'c'), ',') | fields result",
            Arrays.asList("a-1", "b-2"));
 * intentionally absent: substrait extension YAML doesn't support declaring
import java.io.IOException;
    public void testMvjoinWithStringifiedNumbers() throws IOException {
    }
        }
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    }
        for (int i = 0; i < expected.size(); i++) {  
    }
    private Object firstRowFirstCell(String ppl) throws IOException {
 *       {@link org.opensearch.be.datafusion.MakeArrayAdapter}.</li>
            cell instanceof List);  
    public void testMvjoinWithStringArray() throws IOException {
        }
 * analytics-engine route in this PR. Empty-array tests are also absent —
    // ── mvzip (Rust UDF) ────────────────────────────────────────────────────
                + "| eval r = mvzip(mvzip(array('a','b'), array('1','2')), array('x','y')) | fields r",
    }
    /** Dynamic regex — exercises the {@code SqlLibraryOperators.CONCAT_FUNCTION} → substrait
 * <p>Function surface exercised:
     *  {@code SqlStdOperatorTable.ITEM} which {@link org.opensearch.be.datafusion.ArrayElementAdapter}
    /** {@code mvindex(arr, 1, 3)} — 0-based-(start, length) → DataFusion 1-based-(start, end inclusive)
        assertFirstRowDouble(
 * <p>The {@code calcs} dataset is used as a scan target; most tests build literal
    public void testMvindexRangeFirstThree() throws IOException {
        Object cell = firstRowFirstCell(ppl);  
            "a,b,c");
            20.0);
    }
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
    private void assertFirstRowNull(String ppl) throws IOException {
            DatasetProvisioner.provision(client(), DATASET);
 * arrays inside {@code eval} so the field types don't matter — what matters is
        assertFirstRowList(
    private String oneRow() {
    /** {@code mvindex(arr, N)} with a single index — PPL emits Calcite's
 * End-to-end coverage for the PPL array-construction and multivalue (mv*)
    }
 *   <li>{@code array(...)} → DataFusion {@code make_array} via  
import java.util.List;  
        assertFirstRowList(
import org.opensearch.client.Request;
    private static boolean dataProvisioned = false;  
            Arrays.asList("a", "b", "c"));  
    // ── mvjoin (array_to_string) ────────────────────────────────────────────  
}
    /** Base query template: pin to one row so every assertion runs against a single result row. */
    }
 *   <li>{@code array_length} → DataFusion native {@code array_length}.</li>
    private void assertFirstRowString(String ppl, String expected) throws IOException {
     *  Integer/Long/Double interchangeably, so equality on cross-type numbers
            return;
    }
    private static void assertCellEquals(Object expected, Object actual) {  
    }  
    @Override
            oneRow()  
    public void testMvfindWithNoMatch() throws IOException {
            Arrays.asList(1.0, -1.5, 2.0, 1.0));
    }
    // ── split (returns array of strings) ─────────────────────────────────
            30.0);
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), 1e-9);
     *  renames to DataFusion {@code array_element} with a BIGINT-coerced 1-based index. */  
    }
import java.util.Map;
 * encode without the SQL companion {@code #5421} default to {@code VARCHAR}.  
 *   <li>{@code mvindex(arr, from, to)} (range form) → DataFusion {@code array_slice}  
 * that the source is a parquet-backed index the analytics-engine planner can  
    public void testMvjoinWithSpecialDelimiters() throws IOException {
    /** Mixed int+string literal array — Calcite widens to {@code ARRAY<VARCHAR>}
            oneRow() + "| eval arr = array(1, 2, 3, 4, 5) | eval result = mvindex(arr, -3, -1) | fields result",
        assertEquals(
    // ── mvindex single (array_element) ──────────────────────────────────────
    }
    public void testMvdedupAllDuplicates() throws IOException {  
        assertFirstRowList(  
            Arrays.asList("a,1,x", "b,2,y"));
    }
     *  numeric pairs and {@link Object#equals} otherwise. */  
    public void testMvfindWithMatch() throws IOException {
            1.0);
        if (dataProvisioned == false) {
                "Numeric value mismatch",
        assertFirstRowList(
            oneRow() + "| eval arr = array(1, -1.5, 2, 1.0) | eval len = array_length(arr) | fields len",
        assertFirstRowList(
    }  
 * {@code func<…>} lambda-typed arguments, so those don't ship through the  
    public void testMvzipNested() throws IOException {
    protected void onBeforeQuery() throws IOException {  
 * <p>Tests for lambda-based functions ({@code transform}, {@code mvmap},  
 * functions on the analytics-engine route (PPL → CalciteRelNodeVisitor →
        }  
            "1 | 2 | 3");
    public void testMvindexSingleElementNegative() throws IOException {
        assertFirstRowList(
            oneRow() + "| eval arr = array('a', 'b', 'a', 'c', 'b') | eval result = mvdedup(arr) | fields result",
     *  fails even when values match. Compare via {@link Double#compare} on
        }
        assertFirstRowList(
            expected.size(),
    public void testArrayLength() throws IOException {
    }
        Map<String, Object> response = executePpl(ppl);
 *       coerce + 0-based-{@code (start, length)} → 1-based-{@code (start, end)}).</li>
    }  
/**  
                1e-9);
        List<?> actual = (List<?>) cell;
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);  
            Arrays.asList(1, 2, 3));  
            oneRow() + "| eval result = array(1, 'demo') | fields result",
    public void testSplitWithMultiCharDelimiter() throws IOException {
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analytics.qa;
            oneRow() + "| eval result = mvjoin(array('x', 'y'), '-->') | fields result",
 * {@code array()} defaults to {@code ARRAY[UNKNOWN]} which substrait can't
    /** Mixed-numeric literal array — exercises the BigDecimal → Double row-codec
    // ── mvindex range (array_slice) ─────────────────────────────────────────
            assertEquals(expected, actual);
     *  would be {@code [1, 2, 3]} instead of the expected {@code [2, 3, 4]}. */  
    public void testSplitWithSemicolonDelimiter() throws IOException {
 *       {@link org.opensearch.be.datafusion.ArrayToStringAdapter}.</li>
            assertEquals(  
        assertNull("Expected null result for query [" + ppl + "] but got: " + cell, cell);  
        Object cell = firstRowFirstCell(ppl);  
            oneRow() + "| eval result = mvzip(array('a', 'b'), array('1', '2'), '-') | fields result",  
    }
            oneRow() + "| eval arr = array(1, 2, 3, 4, 5) | eval result = mvindex(arr, 1, 3) | fields result",  
 * the analytics-engine path supports today.
            "Length mismatch for query [" + ppl + "]: expected " + expected + " but got " + actual,  
    // ── mvfind (Rust UDF) ───────────────────────────────────────────────────
    public void testMvindexSingleElementPositive() throws IOException {
    }  
            Arrays.asList("a", "b", "c"));
            1.0);
     *  conversion with {@code Unable to convert call CONCAT(string, string)}. */  
                ((Number) expected).doubleValue(),
            dataProvisioned = true;  
    }  
 *       via {@link org.opensearch.be.datafusion.ArraySliceAdapter} (BIGINT index
    public void testMvindexRangePositive() throws IOException {
 * {@code reduce}, {@code forall}, {@code exists}, {@code filter}) are
    public void testMvindexRangeNegative() throws IOException {
 *
            oneRow()  
    }
        assertFirstRowList(
            oneRow() + "| eval result = mvzip(array('a', 'b', 'c'), array('1', '2', '3')) | fields result",  
            oneRow() + "| eval arr = array(10, 20, 30) | eval result = mvindex(arr, 1) | fields result",  
import org.opensearch.client.Response;
 * compatible open source license.
    }  
/*  
            oneRow() + "| eval result = split('a::b::c', '::') | fields result",  
 * {@code CalciteArrayFunctionIT} one-test-method-to-one for the subset of tests
        assertFirstRowDouble(
    // ── mvdedup (array_distinct) ────────────────────────────────────────────
 */
        assertFirstRowString(  
     *  promotion (without it, decimal cells truncate to integers). */  
 * </ul>
        assertFirstRowDouble(  
    public void testMvfindWithDynamicRegex() throws IOException {
    public void testMvdedupWithStrings() throws IOException {  
    /** Numeric-tolerant list comparison — Jackson parses JSON numbers as  
            oneRow() + "| eval result = split('a;b;c', ';') | fields result",  
    public void testArray() throws IOException {
                + "| eval result = mvfind(array('apple', 'banana', 'cherry'), concat('ban', '.*')) | fields result",
        assertNotNull("Expected non-null array result for query [" + ppl + "]", cell);  
        assertFirstRowList(
        assertFirstRowString(  
            oneRow() + "| eval arr = array(10, 20, 30, 40, 50) | eval result = mvindex(arr, 0, 2) | fields result",
 *  
    // ── array_length ────────────────────────────────────────────────────────  
