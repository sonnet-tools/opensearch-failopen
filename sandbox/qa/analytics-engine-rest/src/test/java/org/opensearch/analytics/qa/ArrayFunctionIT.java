            assertEquals(
        assertFirstRowList(
 *       via {@link org.opensearch.be.datafusion.ArrayElementAdapter}.</li>
 * {@code func<…>} lambda-typed arguments, so those don't ship through the
    }
        }
 *   <li>{@code mvindex(arr, from, to)} (range form) → DataFusion {@code array_slice}
        return rows.get(0).get(0);
    }
            oneRow() + "| eval result = array(1, 'demo') | fields result",
        assertNotNull("Expected non-null array result for query [" + ppl + "]", cell);
            oneRow() + "| eval result = mvjoin(array('x', 'y'), '-->') | fields result",
 * scan.
    }
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
 * analytics-engine route in this PR. Empty-array tests are also absent —
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
    public void testMvindexRangePositive() throws IOException {
     *  via {@code ArrayFunctionImpl.internalCast}. */
    // ── mvjoin (array_to_string) ────────────────────────────────────────────
        assertFirstRowString(
            Arrays.asList("1", "demo"));
import java.util.Map;
            return;
 */
/**
        @SuppressWarnings("unchecked")
    // ── mvfind (Rust UDF) ───────────────────────────────────────────────────
            oneRow() + "| eval result = mvfind(array('apple', 'banana', 'cherry'), 'ban.*') | fields result",
    public void testMvzipWithCustomDelimiter() throws IOException {
public class ArrayFunctionIT extends AnalyticsRestTestCase {
 * intentionally absent: substrait extension YAML doesn't support declaring
                "Numeric value mismatch",
    /** Negative indices — DataFusion's array_slice supports them natively. */
            oneRow()
        }
    public void testArrayLength() throws IOException {
            oneRow() + "| eval arr = array(1, -1.5, 2, 1.0) | eval len = array_length(arr) | fields len",
 * that the source is a parquet-backed index the analytics-engine planner can
    public void testSplitWithMultiCharDelimiter() throws IOException {
     *  would be {@code [1, 2, 3]} instead of the expected {@code [2, 3, 4]}. */
    /** Dynamic regex — exercises the {@code SqlLibraryOperators.CONCAT_FUNCTION} → substrait
            Arrays.asList(10, 20, 30));
            "1 | 2 | 3");
        assertFirstRowList(
    /** Mixed-numeric literal array — exercises the BigDecimal → Double row-codec
            oneRow() + "| eval arr = array(10, 20, 30) | eval result = mvindex(arr, -1) | fields result",
    // ── mvzip (Rust UDF) ────────────────────────────────────────────────────
    }
            oneRow() + "| eval result = mvjoin(array('a', 'b', 'c'), ',') | fields result",
 * </ul>
 *   <li>{@code array(...)} → DataFusion {@code make_array} via
    }
            oneRow() + "| eval result = split('a::b::c', '::') | fields result",
            oneRow() + "| eval result = array(1, -1.5, 2, 1.0) | fields result",
    }
    private void assertFirstRowDouble(String ppl, double expected) throws IOException {
 *       via {@link org.opensearch.be.datafusion.ArraySliceAdapter} (BIGINT index
        if (expected == null || actual == null) {
        assertFirstRowList(
        }
import java.io.IOException;
        assertNull("Expected null result for query [" + ppl + "] but got: " + cell, cell);
        }
            "x-->y");
 * {@code reduce}, {@code forall}, {@code exists}, {@code filter}) are
            "Expected list result for query [" + ppl + "] but got: " + cell + " (" + cell.getClass() + ")",
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        List<?> actual = (List<?>) cell;
        assertFirstRowList(
 * arrays inside {@code eval} so the field types don't matter — what matters is
 * End-to-end coverage for the PPL array-construction and multivalue (mv*)
            return;
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
            1.0);
    // ── array_length ────────────────────────────────────────────────────────
     *  via {@link org.opensearch.be.datafusion.ArraySliceAdapter}. Without the rewrite the result
 * {@code array()} defaults to {@code ARRAY[UNKNOWN]} which substrait can't
    }
            oneRow()
            oneRow() + "| eval arr = array(10, 20, 30) | eval result = mvindex(arr, 1) | fields result",
    }
 *
        assertFirstRowList(
    }
    /** Returns the 0-based index of the first array element matching the regex. */
 *   <li>{@code array_length} → DataFusion native {@code array_length}.</li>
 * <p>Tests for lambda-based functions ({@code transform}, {@code mvmap},
            Arrays.asList("a", "b", "c"));
    public void testSplitWithSemicolonDelimiter() throws IOException {
        for (int i = 0; i < expected.size(); i++) {
 *       coerce + 0-based-{@code (start, length)} → 1-based-{@code (start, end)}).</li>
            actual.size());
                ((Number) expected).doubleValue(),
    // ── mvindex range (array_slice) ─────────────────────────────────────────
     *  Integer/Long/Double interchangeably, so equality on cross-type numbers
    }
    }
 *   <li>{@code mvzip(left, right [, sep])} → custom Rust UDF {@code udf::mvzip}.</li>
 * Substrait → DataFusion). Mirrors the SQL plugin's
        assertFirstRowList(
 *
                ((Number) actual).doubleValue(),
/*
            Arrays.asList(3, 4, 5));
        assertEquals(
 *   <li>{@code mvindex(arr, N)} (single-element form) → DataFusion {@code array_element}
        Object cell = firstRowFirstCell(ppl);
     *  {@code concat} Sig bridge added in this PR. Without that bridge the call fails substrait
        assertFirstRowDouble(
 * {@code CalciteArrayFunctionIT} one-test-method-to-one for the subset of tests
    // ── array(...) constructor ──────────────────────────────────────────────
            oneRow() + "| eval arr = array(7, 7, 7) | eval result = mvdedup(arr) | fields result",
    }
    }
        if (dataProvisioned == false) {
                + "| eval r = mvzip(mvzip(array('a','b'), array('1','2')), array('x','y')) | fields r",
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
            oneRow() + "| eval result = mvfind(array('apple', 'banana'), 'zzz') | fields result");
        assertFirstRowDouble(
            "a,b,c");
    }
            Arrays.asList(1.0, -1.5, 2.0, 1.0));
    public void testMvindexRangeFirstThree() throws IOException {
    // ── mvindex single (array_element) ──────────────────────────────────────
    }
    public void testMvjoinWithStringArray() throws IOException {
     *  promotion (without it, decimal cells truncate to integers). */
    protected void onBeforeQuery() throws IOException {
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), 1e-9);
 */
            oneRow() + "| eval result = mvzip(array('a', 'b', 'c'), array('1', '2', '3')) | fields result",
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            Arrays.asList(2, 3, 4));
    private static void assertCellEquals(Object expected, Object actual) {
    /** Base query template: pin to one row so every assertion runs against a single result row. */
            assertEquals(expected, actual);
            Arrays.asList("a,1,x", "b,2,y"));
    public void testMvzipNested() throws IOException {
        assertEquals(expected, actual);
            Arrays.asList(1, 2, 3));
            oneRow() + "| eval arr = array(1, 2, 2, 3, 3, 3) | eval result = mvdedup(arr) | fields result",
            oneRow() + "| eval arr = array(1, 2, 3, 4, 5) | eval result = mvindex(arr, 1, 3) | fields result",
    }
import org.opensearch.client.Request;
    }
    public void testMvjoinWithSpecialDelimiters() throws IOException {
    }
    public void testMvdedupWithDuplicates() throws IOException {
    /** {@code mvindex(arr, N)} with a single index — PPL emits Calcite's
    }
            cell instanceof List);
        assertTrue(
 * The OpenSearch Contributors require contributions made to
 *
    // ── split (returns array of strings) ─────────────────────────────────
        Map<String, Object> response = executePpl(ppl);
 *   <li>{@code mvdedup(arr)} → DataFusion native {@code array_distinct}.</li>
    private Object firstRowFirstCell(String ppl) throws IOException {
    }
 * encode without the SQL companion {@code #5421} default to {@code VARCHAR}.
            "Length mismatch for query [" + ppl + "]: expected " + expected + " but got " + actual,
import java.util.Arrays;
    // ── mvdedup (array_distinct) ────────────────────────────────────────────
    public void testMvdedupWithStrings() throws IOException {
        assertFirstRowString(
 * compatible open source license.
 *       {@link org.opensearch.be.datafusion.ArrayToStringAdapter}.</li>
        return "source=" + DATASET.indexName + " | head 1 ";
    public void testMvdedupAllDuplicates() throws IOException {
            Arrays.asList("a,1", "b,2", "c,3"));
 * <p>Function surface exercised:
            DatasetProvisioner.provision(client(), DATASET);
    public void testMvjoinWithStringifiedNumbers() throws IOException {
        Object cell = firstRowFirstCell(ppl);
            oneRow() + "| eval result = mvjoin(array('1', '2', '3'), ' | ') | fields result",
import java.util.List;
            Arrays.asList(7));
        Object cell = firstRowFirstCell(ppl);
    /** Numeric-tolerant list comparison — Jackson parses JSON numbers as
    private void assertFirstRowNull(String ppl) throws IOException {
    /** Mixed int+string literal array — Calcite widens to {@code ARRAY<VARCHAR>}
        assertFirstRowList(
     *  numeric pairs and {@link Object#equals} otherwise. */
    public void testMvfindWithNoMatch() throws IOException {
    }
            oneRow() + "| eval result = mvzip(array('a', 'b'), array('1', '2'), '-') | fields result",
    /** {@code mvindex(arr, 1, 3)} — 0-based-(start, length) → DataFusion 1-based-(start, end inclusive)
        assertFirstRowNull(
    public void testArray() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    private void assertFirstRowList(String ppl, List<?> expected) throws IOException {
                1e-9);
    @Override
            4.0);
 * <ul>
    }
    private static boolean dataProvisioned = false;
     *  fails even when values match. Compare via {@link Double#compare} on
package org.opensearch.analytics.qa;
        assertFirstRowDouble(
 * SPDX-License-Identifier: Apache-2.0
}
        assertFirstRowList(
    private void assertFirstRowString(String ppl, String expected) throws IOException {
        assertFirstRowDouble(
 *       {@link org.opensearch.be.datafusion.MakeArrayAdapter}.</li>
    }
    // ── helpers ─────────────────────────────────────────────────────────────
     *  conversion with {@code Unable to convert call CONCAT(string, string)}. */
    public void testMvzipBasic() throws IOException {
            20.0);
     *  {@code SqlStdOperatorTable.ITEM} which {@link org.opensearch.be.datafusion.ArrayElementAdapter}
            oneRow() + "| eval arr = array(1, 2, 3, 4, 5) | eval result = mvindex(arr, -3, -1) | fields result",
            oneRow() + "| eval arr = array(10, 20, 30, 40, 50) | eval result = mvindex(arr, 0, 2) | fields result",
     *  renames to DataFusion {@code array_element} with a BIGINT-coerced 1-based index. */
            oneRow() + "| eval arr = array('a', 'b', 'a', 'c', 'b') | eval result = mvdedup(arr) | fields result",
            Arrays.asList("a", "b", "c"));
                + "| eval result = mvfind(array('apple', 'banana', 'cherry'), concat('ban', '.*')) | fields result",
        assertFirstRowList(
        assertFirstRowList(
            dataProvisioned = true;
    public void testMvindexSingleElementNegative() throws IOException {
import org.opensearch.client.Response;
    }
            Arrays.asList("a", "b", "c"));
 *
    }
 *   <li>{@code split(str, delim)} (returns array) → DataFusion {@code string_to_array}.</li>
        assertFirstRowList(
    public void testArrayWithString() throws IOException {
        assertFirstRowDouble(
            30.0);
    }
        if (expected instanceof Number && actual instanceof Number) {
    private String oneRow() {
 * functions on the analytics-engine route (PPL → CalciteRelNodeVisitor →
 *   <li>{@code mvjoin(arr, sep)} → DataFusion {@code array_to_string} via
 *   <li>{@code mvfind(arr, regex)} → custom Rust UDF {@code udf::mvfind}.</li>
        Object cell = firstRowFirstCell(ppl);
 * <p>The {@code calcs} dataset is used as a scan target; most tests build literal
            expected.size(),
    public void testMvindexSingleElementPositive() throws IOException {
        assertFirstRowList(
    }
 * the analytics-engine path supports today.
            oneRow() + "| eval result = split('a;b;c', ';') | fields result",
            Arrays.asList("a-1", "b-2"));
    public void testMvfindWithMatch() throws IOException {
    }
    public void testMvfindWithDynamicRegex() throws IOException {
    public void testMvindexRangeNegative() throws IOException {
        assertFirstRowString(
            assertCellEquals(expected.get(i), actual.get(i));
    }
            1.0);
        assertFirstRowList(
    }
