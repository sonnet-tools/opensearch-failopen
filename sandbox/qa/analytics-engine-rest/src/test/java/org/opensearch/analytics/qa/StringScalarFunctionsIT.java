    }
import java.util.Map;
    // ── tonumber ────────────────────────────────────────────────────────────
     *  start-position and length semantics simultaneously. */
    }
    public void testStrcmpColumnEqual() throws IOException {
        assertNotNull("duration_millis cell must not be null", cell);
    /** {@code locate('U', 'FURNITURE')} → 2 (1-based position of first 'U'). */
        assertFirstRowLong(oneRow("key04") + "| eval v = length(str0) | fields v", 15);
    public void testLeftWithComputedLength() throws IOException {
    }
        assertEquals("tostring(3661, 'duration')", "01:01:01", cell);
 *       {@code length → char_length}, {@code locate → strpos} (with arg swap
    public void testToStringDurationFormat() throws IOException {
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 3661, 'duration') | fields v");
    public void testLength() throws IOException {
    /** {@code tonumber('abc')} → NULL. Unparseable input */
        assertFirstRowString(oneRow("key00") + "| eval v = concat(str0, str2) | fields v", "FURNITUREone");
 *       {@code upper}.</li>
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp('foo', 'foo') | fields v", 0);
     *  and finds the second 'U' at position 7. */
        assertNotNull("binary cell must not be null", cell);
     *  adapter must swap back for the user-intended semantics. */
 * example, {@code tostring(int0 * 12345, 'commas')} on {@code int0=1} yields
     */
 */
    public void testToNumberOctal() throws IOException {
    public void testStrcmpColumnGreater() throws IOException {
    // ── locate / position ───────────────────────────────────────────────────
    // ── lower / upper ────────────────────────────────────────────────────────
 * <p>Fixture row values used (from {@code calcs/bulk.json}):
        nf.setMinimumFractionDigits(0);
    public void testLocateWithStart() throws IOException {
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        }
    public void testToStringBinaryFormat() throws IOException {
    protected void onBeforeQuery() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('FA34', 16) | fields v", 64052.0, 0.0);
        assertFirstRowLong(oneRow("key00") + "| eval v = locate('U', str0, 3) | fields v", 7);
    /**
    /**
    public void testStrcmpGreater() throws IOException {
 *   <li>Full {@link org.opensearch.analytics.spi.ScalarFunctionAdapter} plans:
    /** {@code tonumber('101', 8)} → 65 (octal 101 = 64 + 1) */
        assertFirstRowLong(oneRow("key00") + "| eval v = length(str0) | fields v", 9);
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), delta);
    }
    }
    public void testLtrim() throws IOException {
     *  verifies the right-side whitespace removal. */
    // ── helpers ─────────────────────────────────────────────────────────────
        assertEquals("tostring(255, 'hex')", "ff", ((String) cell).toLowerCase(Locale.US));
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('4598') | fields v", 4598.0, 0.0);
    /** {@code position('RNI' IN 'FURNITURE')} → 3. */
     * {@code tostring(int0 * 3_661_000, 'duration_millis')} on row 0 (int0=1) → "01:01:01".
        assertNull("tonumber('abc') should be NULL but was " + cell, cell);
    }
    }
    /** {@code rtrim(concat(str2, '   '))} on row 0 → "one". Trailing-spaces counterpart to ltrim;
 * passthrough would produce {@code "12345"}.
    }
    /**
            dataProvisioned = true;
    /** {@code tonumber('FA34', 16)} → 64052. Base-16 parse with uppercase hex digits */
 * <ul>
    public void testAsciiDifferentRow() throws IOException {
    /** {@code right('FURNITURE', 3)} → "URE". Verifies suffix extraction; a left() misroute would
    }
    public void testPosition() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = concat_ws(':', str0, str2) | fields v", "FURNITURE:one");
 *       {@code substr → substring}, {@code trim → btrim}.</li>
 */
        assertFirstRowLong(oneRow("key00") + "| eval v = locate('U', str0) | fields v", 2);
    private String oneRow(String key) {
    }
 * {@code ReduceExpressionsRule} from constant-folding the expression on the
 * SPDX-License-Identifier: Apache-2.0
     */
    public void testAscii() throws IOException {
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
    private void assertFirstRowLong(String ppl, long expected) throws IOException {
        assertTrue("hex cell must be String but was " + cell.getClass(), cell instanceof String);
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    /** {@code strcmp('banana', 'apple')} → 1 (lhs &gt; rhs). */
 * </ul>
    }
     *  return "FUR". */
    public void testSubstringTwoArg() throws IOException {
    // ── ascii ───────────────────────────────────────────────────────────────
    /** {@code length('FURNITURE')} → 9.*/
 * End-to-end coverage for PPL string scalar functions
    public void testReverseOfConcat() throws IOException {
    }
    public void testToNumberBinary() throws IOException {
        Object cell = firstRowFirstCell(ppl);
    // ── concat / concat_ws ──────────────────────────────────────────────────
        assertNotNull("duration cell must not be null", cell);
package org.opensearch.analytics.qa;
    }
        if (dataProvisioned == false) {
    public void testToNumberDecimalFractional() throws IOException {
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tonumber('FA34', 10) | fields v");
    }
    public void testToStringOnBooleanFalse() throws IOException {
    private void assertFirstRowDouble(String ppl, double expected, double delta) throws IOException {
    }
 * {@code "12,345"} which proves the commas format path was evaluated; a
        assertFirstRowString(oneRow("key00") + "| eval v = right(str0, 3) | fields v", "URE");
    // ── substring ────────────────────────────────────────────────────────────
    }
 * {@code where key='keyNN'} — field references prevent Calcite's
        assertFirstRowString(oneRow("key00") + "| eval v = trim(concat('  ', str2, '  ')) | fields v", "one");
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
        nf.setMaximumFractionDigits(2);
        assertFirstRowString(oneRow("key00") + "| eval v = substring(str0, 2, 3) | fields v", "URN");
import java.text.NumberFormat;
 * <p>Covers three categories of routing:
     */
        assertEquals("tostring(21, 'binary')", "10101", cell);
    /** {@code tostring(1=0)} → "FALSE" */
    }
    public void testStrcmpEqual() throws IOException {
    /** {@code strcmp(str0, 'ZZZ')} */
    /** {@code substring('FURNITURE', 2, 3)} → "URN". Length-bounded 3-arg form; verifies both
 *
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    /** {@code tonumber('010101', 2)} → 21. Base-2 parse */
    public void testStrcmpLess() throws IOException {
    }
import java.util.List;
    }
    @Override
 *       {@code DataFusionAnalyticsBackendPlugin.scalarFunctionAdapters()}:
    // ── ltrim / rtrim / trim ────────────────────────────────────────────────
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp(str0, 'ZZZ') | fields v", -1);
    public void testSubstringThreeArg() throws IOException {
        assertTrue("commas cell must be String but was " + cell.getClass(), cell instanceof String);
        assertNull("tonumber('FA34', 10) should be NULL but was " + cell, cell);
    /** {@code ltrim(concat('   ', str2))} on row 0 → "one". The {@code concat} forces runtime
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 21, 'binary') | fields v");
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).longValue());
    public void testLocate() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = rtrim(concat(str2, '   ')) | fields v", "one");
    }
    // ── left / right ─────────────────────────────────────────────────────────
 *   <li>Direct-match Substrait signatures: {@code ascii}, {@code concat},
    /** {@code locate('U', 'FURNITURE', 3)} → 7. Start-index=3 skips the first 'U' at position 2
        assertFirstRowLong(oneRow("key00") + "| eval v = position(\"RNI\" IN str0) | fields v", 3);
        assertFirstRowString(oneRow("key00") + "| eval v = tostring(1=0) | fields v", "FALSE");
    }
     * {@code tostring(int0 * 3661, 'duration')} on row 0 (int0=1) → "01:01:01".
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp(str0, 'AAA') | fields v", 1);
    public void testToNumberBaseMismatchReturnsNull() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = upper(str2) | fields v", "ONE");
    private void assertFirstRowString(String ppl, String expected) throws IOException {
    public void testTrim() throws IOException {
    public void testToNumberReturnsNullOnParseFailure() throws IOException {
    private static boolean dataProvisioned = false;
    public void testToStringCommasFormat() throws IOException {
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
    /** {@code ascii(str0)} on {@code key04} (str0="OFFICE SUPPLIES") → 79 (ASCII code of 'O')*/
    // ── length ───────────────────────────────────────────────────────────────
import org.opensearch.client.Request;
    }
    /** {@code lower('FURNITURE')} → "furniture". */
    }
    // ── tostring — format modes ─────────────────────────────────────────────
    public void testLengthDifferentRow() throws IOException {
    /** {@code strcmp(str0, 'AAA')} */
    /** {@code locate('XYZ', str0)} → 0 (not found). */
        assertFirstRowString(oneRow("key00") + "| eval v = reverse(str0) | fields v", "ERUTINRUF");
    // ── tostring — basic ────────────────────────────────────────────────────
        @SuppressWarnings("unchecked")
    /** Base query template: filter to exactly one row (cardinality 1) keyed by {@code key}. */
    }
     *  computed at runtime ({@code "one" + "FURNITURE" = "oneFURNITURE"}) and its reverse is a
 * where the function wiring is actually exercised.
    }
        assertFirstRowLong(oneRow("key00") + "| eval v = locate('XYZ', str0) | fields v", 0);
 * coordinator, forcing the call to travel through Substrait into DataFusion
 * function under test — not by Calcite's constant-folder short-circuiting. For
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 255, 'hex') | fields v");
    }
    /** {@code length('OFFICE SUPPLIES')} on key04 → 15. */
    /** Two-field {@code concat(str0, str2)} on row 0 → "FURNITUREone". Both operands are field refs  */
     *  handles column references correctly: PPL frontend reverses args internally, and the
     * {@code tostring(int0 * 255, 'hex')} on row 0 (int0=1) → "ff".
    }
    }
        Object cell = firstRowFirstCell(ppl);
     * {@code tostring(int0 * 21, 'binary')} on row 0 (int0=1) → "10101".
    }
        assertFirstRowString(oneRow("key00") + "| eval v = tostring(1=1) | fields v", "TRUE");
    public void testRight() throws IOException {
/*
        assertTrue("duration_millis cell must be String but was " + cell.getClass(), cell instanceof String);
import java.io.IOException;
 *       and optional 3-arg decomposition), {@code position → strpos} (arg swap),
    public void testLower() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = ltrim(concat('   ', str2)) | fields v", "one");
    }
    public void testRtrim() throws IOException {
    }
 *
        assertEquals("tostring(3661000, 'duration_millis')", "01:01:01", cell);
    // ── reverse ──────────────────────────────────────────────────────────────
        assertNotNull("hex cell must not be null", cell);
    /** {@code left('FURNITURE', 3)} → "FUR". Verifies length-1 prefix extraction */
    public void testReverse() throws IOException {
 * tests are constructed so the expected output is <b>only</b> producible by the
    /** {@code substring('FURNITURE', 2)} → "URNITURE" (8 chars, from index 2 to end). */
     */
}
    /**
 * compatible open source license.
        assertFirstRowString(oneRow("key00") + "| eval v = left(str0, 3) | fields v", "FUR");
     *  one.
        Object cell = firstRowFirstCell(ppl);
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp(str0, 'FURNITURE') | fields v", 0);
    private Object firstRowFirstCell(String ppl) throws IOException {
     *  WHEN x THEN 'TRUE' WHEN NOT x THEN 'FALSE' END rewrite. */
    /** {@code concat_ws(':', str0, str2)} on row 0 → "FURNITURE:one" */
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
    }
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
    }
    }
        assertEquals("tostring(12345, 'commas')", nf.format(12345L), cell);
    /** {@code tostring(num0)} on row 0 (num0=12.3) → "12.3". */
    /** {@code tostring(1=1)} → "TRUE". Boolean literal routes through the adapter's CASE
    public void testToNumberDecimalInteger() throws IOException {
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tonumber('abc') | fields v");
    /** {@code trim(concat('  ', str2, '  '))} on row 0 → "one". */
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp('hello', 'hello world') | fields v", -1);
 * <p>Each test pins a single row of the {@code calcs} dataset via
 * this file be licensed under the Apache-2.0 license or a
    public void testLeft() throws IOException {
import org.opensearch.client.Response;
/**
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('101', 8) | fields v", 65.0, 0.0);
 *
 *   <li>{@code key04}: str0="OFFICE SUPPLIES", str2="five", num0=3.5, int0=7</li>
    /** {@code strcmp(str0, 'FURNITURE')} on row 0 (str0='FURNITURE') → 0. Verifies the adapter
    /** {@code tonumber('4598')} → 4598.0 */
    /** {@code tostring(int0)} on row 0 (int0=1) → "1". */
    /** {@code left(str0, length(str0))} on row 0 → "FURNITURE" (full string). */
 *   <li>Name-mapping adapter rewrites (PPL name ≠ DataFusion name) registered in
    public void testToStringOnBooleanTrue() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = reverse(concat(str2, str0)) | fields v", "ERUTINRUFeno");
    public void testToStringDurationMillisFormat() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = substring(str0, 2) | fields v", "URNITURE");
import java.util.Locale;
    public void testToStringOnDouble() throws IOException {
 *       {@code reverse}, {@code right}, {@code rtrim}, {@code substring},
    /** {@code upper('one')} → "ONE". Complements testLower. */
    }
    public void testConcatWs() throws IOException {
    /** {@code reverse('FURNITURE')} on a field → "ERUTINRUF". */
public class StringScalarFunctionsIT extends AnalyticsRestTestCase {
    }
    public void testStrcmpColumnLess() throws IOException {
    }
 *
    /** {@code reverse(concat(str2, str0))} → "ERUTINRUFeno". Composed with concat so the input is
    public void testToNumberHex() throws IOException {
    }
     */
     *  leading spaces guarantee only ltrim could produce "one" from the 6-character input. */
     * {@code tostring(int0 * 12345, 'commas')} on row 0 (int0=1) → "12,345".
    public void testLocateNotFound() throws IOException {
    /** {@code ascii(str0)} on {@code str0="FURNITURE"} → 70 (ASCII code of 'F') */
     *  evaluation (Calcite can't fold the call because {@code str2} is a column ref), and the
 *
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('4598.678') | fields v", 4598.678, 1e-9);
        assertTrue("binary cell must be String but was " + cell.getClass(), cell instanceof String);
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('010101', 2) | fields v", 21.0, 0.0);
    }
    /** {@code tonumber('FA34', 10)} → NULL */
    /** {@code tonumber('4598.678')} → 4598.678 */
    /**
    /** {@code strcmp('foo', 'foo')} → 0.  */
        assertNotNull("commas cell must not be null", cell);
    }
    public void testToStringOnInteger() throws IOException {
            DatasetProvisioner.provision(client(), DATASET);
    public void testToStringHexFormat() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp('banana', 'apple') | fields v", 1);
 * <ul>
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 3661000, 'duration_millis') | fields v");
        assertFirstRowLong(oneRow("key04") + "| eval v = ascii(str0) | fields v", (long) 'O');
 * <p>Where inputs must be literals (e.g. to exercise a specific parse path),
    }
 * </ul>
    }
    /** {@code strcmp('hello', 'hello world')} → -1 (lhs &lt; rhs).  */
        return rows.get(0).get(0);
        Map<String, Object> response = executePpl(ppl);
 *       and {@code tostring} / {@code tonumber}.</li>
    }
        assertFirstRowString(oneRow("key00") + "| eval v = tostring(int0) | fields v", "1");
 *       {@code concat_ws}, {@code left}, {@code lower}, {@code ltrim},
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
     *  12-char string that could only come from an actual character-by-character reversal. */
        assertTrue("duration cell must be String but was " + cell.getClass(), cell instanceof String);
        assertFirstRowLong(oneRow("key00") + "| eval v = ascii(str0) | fields v", (long) 'F');
        assertFirstRowString(oneRow("key00") + "| eval v = left(str0, length(str0)) | fields v", "FURNITURE");
    }
    // ── strcmp ───────────────────────────────────────────────────────────────
    }
        assertFirstRowString(oneRow("key00") + "| eval v = lower(str0) | fields v", "furniture");
    public void testConcat() throws IOException {
 * The OpenSearch Contributors require contributions made to
    }
    public void testUpper() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = tostring(num0) | fields v", "12.3");
    }
    }
 *       {@code strcmp} (decomposed to a SIMD-vectorized {@code CASE} expression)
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 12345, 'commas') | fields v");
 *   <li>{@code key00}: str0="FURNITURE", str2="one", num0=12.3, int0=1, int3=8</li>
