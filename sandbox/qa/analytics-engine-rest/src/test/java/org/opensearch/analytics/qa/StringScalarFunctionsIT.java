        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
    /**
    }
    @Override  
    /** {@code tostring(1=1)} → "TRUE". Boolean literal routes through the adapter's CASE  
        assertNull("tonumber('abc') should be NULL but was " + cell, cell);
        assertNotNull("hex cell must not be null", cell);  
    }
    public void testLocateWithStart() throws IOException {  
    public void testStrcmpColumnLess() throws IOException {
    /** {@code locate('U', 'FURNITURE', 3)} → 7. Start-index=3 skips the first 'U' at position 2
 * <p>Covers three categories of routing:
    /**  
 *  
    public void testSubstringThreeArg() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval v = locate('U', str0, 3) | fields v", 7);
    /** {@code tonumber('FA34', 10)} → NULL */
    public void testToStringOnBooleanTrue() throws IOException {
 *   <li>{@code key00}: str0="FURNITURE", str2="one", num0=12.3, int0=1, int3=8</li>
 * coordinator, forcing the call to travel through Substrait into DataFusion
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 3661000, 'duration_millis') | fields v");
import java.util.List;  
        assertNotNull("duration_millis cell must not be null", cell);
        assertFirstRowLong(oneRow("key00") + "| eval v = position(\"RNI\" IN str0) | fields v", 3);
 *   <li>Full {@link org.opensearch.analytics.spi.ScalarFunctionAdapter} plans:  
    public void testToNumberHex() throws IOException {
    // ── tostring — format modes ─────────────────────────────────────────────
    }
    }  
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp('foo', 'foo') | fields v", 0);
    }  
        assertFirstRowString(oneRow("key00") + "| eval v = left(str0, 3) | fields v", "FUR");
    /** {@code tostring(1=0)} → "FALSE" */  
        Object cell = firstRowFirstCell(ppl);
 * <ul>
 *   <li>{@code key04}: str0="OFFICE SUPPLIES", str2="five", num0=3.5, int0=7</li>  
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('010101', 2) | fields v", 21.0, 0.0);  
    public void testRight() throws IOException {  
     */  
        assertTrue("binary cell must be String but was " + cell.getClass(), cell instanceof String);
    // ── concat / concat_ws ──────────────────────────────────────────────────
    }  
    public void testToStringOnBooleanFalse() throws IOException {
    /** {@code upper('one')} → "ONE". Complements testLower. */
    /** {@code locate('XYZ', str0)} → 0 (not found). */
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).longValue());  
        assertFirstRowString(oneRow("key00") + "| eval v = concat_ws(':', str0, str2) | fields v", "FURNITURE:one");
import org.opensearch.client.Response;
    /** {@code tonumber('4598')} → 4598.0 */  
    }
 * SPDX-License-Identifier: Apache-2.0
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
    /** {@code concat_ws(':', str0, str2)} on row 0 → "FURNITURE:one" */
 *       {@code concat_ws}, {@code left}, {@code lower}, {@code ltrim},
    // ── locate / position ───────────────────────────────────────────────────  
        assertFirstRowLong(oneRow("key04") + "| eval v = ascii(str0) | fields v", (long) 'O');
    /** {@code length('OFFICE SUPPLIES')} on key04 → 15. */
    public void testToStringDurationFormat() throws IOException {
    /** {@code tonumber('010101', 2)} → 21. Base-2 parse */
    }  
    public void testToStringBinaryFormat() throws IOException {
    }
    // ── tonumber ────────────────────────────────────────────────────────────
 *   <li>Direct-match Substrait signatures: {@code ascii}, {@code concat},  
    /** {@code left('FURNITURE', 3)} → "FUR". Verifies length-1 prefix extraction */  
        assertTrue("hex cell must be String but was " + cell.getClass(), cell instanceof String);
    /** {@code strcmp(str0, 'ZZZ')} */
     *  handles column references correctly: PPL frontend reverses args internally, and the
    /**
    }
    public void testRtrim() throws IOException {  
    }
 * where the function wiring is actually exercised.  
import java.util.Map;
    // ── ascii ───────────────────────────────────────────────────────────────
        assertEquals("tostring(3661, 'duration')", "01:01:01", cell);  
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 3661, 'duration') | fields v");  
 *       {@code substr → substring}, {@code trim → btrim}.</li>
 * this file be licensed under the Apache-2.0 license or a
 * </ul>  
    /** {@code length('FURNITURE')} → 9.*/
    /** {@code strcmp('foo', 'foo')} → 0.  */  
     * {@code tostring(int0 * 3661, 'duration')} on row 0 (int0=1) → "01:01:01".
        assertFirstRowString(oneRow("key00") + "| eval v = upper(str2) | fields v", "ONE");
    public void testToStringCommasFormat() throws IOException {  
    // ── substring ────────────────────────────────────────────────────────────
     * {@code tostring(int0 * 21, 'binary')} on row 0 (int0=1) → "10101".  
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('4598.678') | fields v", 4598.678, 1e-9);
 * passthrough would produce {@code "12345"}.
        assertNotNull("duration cell must not be null", cell);
    /** {@code substring('FURNITURE', 2, 3)} → "URN". Length-bounded 3-arg form; verifies both  
    /** {@code tostring(int0)} on row 0 (int0=1) → "1". */
    public void testStrcmpLess() throws IOException {
 *
 * {@code where key='keyNN'} — field references prevent Calcite's  
    // ── tostring — basic ────────────────────────────────────────────────────  
    }  
 *       {@code upper}.</li>  
    // ── helpers ─────────────────────────────────────────────────────────────
    /** {@code strcmp('hello', 'hello world')} → -1 (lhs &lt; rhs).  */
     *  adapter must swap back for the user-intended semantics. */  
 * <ul>
    }
    /** {@code tonumber('4598.678')} → 4598.678 */
    public void testLengthDifferentRow() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('FA34', 16) | fields v", 64052.0, 0.0);
    }  
 *       {@code length → char_length}, {@code locate → strpos} (with arg swap  
    public void testToNumberReturnsNullOnParseFailure() throws IOException {
    /** {@code position('RNI' IN 'FURNITURE')} → 3. */  
public class StringScalarFunctionsIT extends AnalyticsRestTestCase {  
        assertTrue("duration cell must be String but was " + cell.getClass(), cell instanceof String);
    private void assertFirstRowDouble(String ppl, double expected, double delta) throws IOException {  
        assertEquals("tostring(3661000, 'duration_millis')", "01:01:01", cell);
     *  WHEN x THEN 'TRUE' WHEN NOT x THEN 'FALSE' END rewrite. */
    public void testLocateNotFound() throws IOException {
    }
        assertFirstRowString(oneRow("key00") + "| eval v = lower(str0) | fields v", "furniture");
        @SuppressWarnings("unchecked")
        assertFirstRowString(oneRow("key00") + "| eval v = reverse(concat(str2, str0)) | fields v", "ERUTINRUFeno");
        assertFirstRowString(oneRow("key00") + "| eval v = substring(str0, 2) | fields v", "URNITURE");  
    /** {@code left(str0, length(str0))} on row 0 → "FURNITURE" (full string). */
/*  
    // ── length ───────────────────────────────────────────────────────────────  
 * End-to-end coverage for PPL string scalar functions
    public void testAsciiDifferentRow() throws IOException {  
    /** Base query template: filter to exactly one row (cardinality 1) keyed by {@code key}. */
 * {@code "12,345"} which proves the commas format path was evaluated; a  
    public void testToNumberBinary() throws IOException {
    // ── left / right ─────────────────────────────────────────────────────────
    public void testStrcmpColumnEqual() throws IOException {
    /** {@code tonumber('abc')} → NULL. Unparseable input */
    public void testToNumberBaseMismatchReturnsNull() throws IOException {
    }
    }
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
 * <p>Fixture row values used (from {@code calcs/bulk.json}):  
            dataProvisioned = true;
 * function under test — not by Calcite's constant-folder short-circuiting. For
        nf.setMaximumFractionDigits(2);  
        Map<String, Object> response = executePpl(ppl);
    public void testLength() throws IOException {  
    }  
    public void testToStringHexFormat() throws IOException {
 *       {@code reverse}, {@code right}, {@code rtrim}, {@code substring},
    // ── strcmp ───────────────────────────────────────────────────────────────
    /** {@code strcmp(str0, 'AAA')} */
        assertEquals("tostring(21, 'binary')", "10101", cell);  
    public void testLeftWithComputedLength() throws IOException {  
 *       and optional 3-arg decomposition), {@code position → strpos} (arg swap),
    protected void onBeforeQuery() throws IOException {
    public void testToStringOnDouble() throws IOException {  
    }  
    public void testToStringOnInteger() throws IOException {
 * <p>Where inputs must be literals (e.g. to exercise a specific parse path),
        assertTrue("duration_millis cell must be String but was " + cell.getClass(), cell instanceof String);  
     * {@code tostring(int0 * 3_661_000, 'duration_millis')} on row 0 (int0=1) → "01:01:01".
    }  
    /** {@code tonumber('101', 8)} → 65 (octal 101 = 64 + 1) */
     */
        assertFirstRowLong(oneRow("key04") + "| eval v = length(str0) | fields v", 15);  
    public void testReverse() throws IOException {  
        return rows.get(0).get(0);  
    public void testStrcmpEqual() throws IOException {
    }  
        assertEquals("Value mismatch for query: " + ppl, expected, cell);  
    public void testPosition() throws IOException {
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tonumber('abc') | fields v");  
    }
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
     *  12-char string that could only come from an actual character-by-character reversal. */  
    }
        assertFirstRowString(oneRow("key00") + "| eval v = ltrim(concat('   ', str2)) | fields v", "one");
        assertFirstRowLong(oneRow("key00") + "| eval v = locate('U', str0) | fields v", 2);
    /**
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
    private void assertFirstRowString(String ppl, String expected) throws IOException {  
    public void testReverseOfConcat() throws IOException {
    }
     * {@code tostring(int0 * 12345, 'commas')} on row 0 (int0=1) → "12,345".
        assertNull("tonumber('FA34', 10) should be NULL but was " + cell, cell);
 * tests are constructed so the expected output is <b>only</b> producible by the  
    }
    /** {@code tonumber('FA34', 16)} → 64052. Base-16 parse with uppercase hex digits */  
     *  and finds the second 'U' at position 7. */
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), delta);  
    }
    // ── lower / upper ────────────────────────────────────────────────────────
        assertFirstRowString(oneRow("key00") + "| eval v = substring(str0, 2, 3) | fields v", "URN");  
    private Object firstRowFirstCell(String ppl) throws IOException {  
    /**  
package org.opensearch.analytics.qa;
    /** {@code strcmp(str0, 'FURNITURE')} on row 0 (str0='FURNITURE') → 0. Verifies the adapter
        }
     *  start-position and length semantics simultaneously. */
 *       {@code DataFusionAnalyticsBackendPlugin.scalarFunctionAdapters()}:
    }
    /** {@code ltrim(concat('   ', str2))} on row 0 → "one". The {@code concat} forces runtime  
    public void testLeft() throws IOException {
        assertEquals("tostring(255, 'hex')", "ff", ((String) cell).toLowerCase(Locale.US));
    /** {@code tostring(num0)} on row 0 (num0=12.3) → "12.3". */
    }
        nf.setMinimumFractionDigits(0);
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp(str0, 'AAA') | fields v", 1);
            DatasetProvisioner.provision(client(), DATASET);  
        assertFirstRowString(oneRow("key00") + "| eval v = rtrim(concat(str2, '   ')) | fields v", "one");
        assertFirstRowString(oneRow("key00") + "| eval v = right(str0, 3) | fields v", "URE");
        assertFirstRowLong(oneRow("key00") + "| eval v = ascii(str0) | fields v", (long) 'F');
    public void testLocate() throws IOException {  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tonumber('FA34', 10) | fields v");  
        assertFirstRowString(oneRow("key00") + "| eval v = tostring(num0) | fields v", "12.3");
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
    public void testToStringDurationMillisFormat() throws IOException {  
    public void testLower() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval v = locate('XYZ', str0) | fields v", 0);  
        assertFirstRowString(oneRow("key00") + "| eval v = trim(concat('  ', str2, '  ')) | fields v", "one");  
    }
     *  computed at runtime ({@code "one" + "FURNITURE" = "oneFURNITURE"}) and its reverse is a
    /** {@code ascii(str0)} on {@code str0="FURNITURE"} → 70 (ASCII code of 'F') */  
     */
        assertFirstRowString(oneRow("key00") + "| eval v = left(str0, length(str0)) | fields v", "FURNITURE");
import org.opensearch.client.Request;
}  
    /** Two-field {@code concat(str0, str2)} on row 0 → "FURNITUREone". Both operands are field refs  */  
        Object cell = firstRowFirstCell(ppl);
     *  return "FUR". */
    /** {@code trim(concat('  ', str2, '  '))} on row 0 → "one". */
        assertEquals("tostring(12345, 'commas')", nf.format(12345L), cell);
    public void testTrim() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = tostring(1=0) | fields v", "FALSE");
    }
    }
    /** {@code strcmp('banana', 'apple')} → 1 (lhs &gt; rhs). */
    }  
     *  leading spaces guarantee only ltrim could produce "one" from the 6-character input. */
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 255, 'hex') | fields v");
        if (dataProvisioned == false) {
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp(str0, 'FURNITURE') | fields v", 0);
/**
    private static boolean dataProvisioned = false;
    /** {@code ascii(str0)} on {@code key04} (str0="OFFICE SUPPLIES") → 79 (ASCII code of 'O')*/
import java.text.NumberFormat;
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp(str0, 'ZZZ') | fields v", -1);  
    }
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
    }  
        Object cell = firstRowFirstCell(ppl);
 * compatible open source license.
    }
     */
import java.io.IOException;
    /** {@code rtrim(concat(str2, '   '))} on row 0 → "one". Trailing-spaces counterpart to ltrim;
    public void testConcat() throws IOException {
    }
    public void testSubstringTwoArg() throws IOException {
    public void testToNumberDecimalInteger() throws IOException {
        assertFirstRowString(oneRow("key00") + "| eval v = tostring(1=1) | fields v", "TRUE");  
    private String oneRow(String key) {  
     *  evaluation (Calcite can't fold the call because {@code str2} is a column ref), and the
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp('hello', 'hello world') | fields v", -1);  
import java.util.Locale;
 * {@code ReduceExpressionsRule} from constant-folding the expression on the
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 21, 'binary') | fields v");  
    }
    public void testLtrim() throws IOException {  
     *  one.  
 * <p>Each test pins a single row of the {@code calcs} dataset via
    }
 *
        assertFirstRowString(oneRow("key00") + "| eval v = tostring(int0) | fields v", "1");  
    /** {@code lower('FURNITURE')} → "furniture". */  
    /** {@code reverse(concat(str2, str0))} → "ERUTINRUFeno". Composed with concat so the input is
    /** {@code locate('U', 'FURNITURE')} → 2 (1-based position of first 'U'). */
 * </ul>
    }
        assertNotNull("binary cell must not be null", cell);
     * {@code tostring(int0 * 255, 'hex')} on row 0 (int0=1) → "ff".
 *
     */
 */
    public void testToNumberOctal() throws IOException {  
    }
 *       {@code strcmp} (decomposed to a SIMD-vectorized {@code CASE} expression)
    /** {@code right('FURNITURE', 3)} → "URE". Verifies suffix extraction; a left() misroute would
    public void testStrcmpColumnGreater() throws IOException {  
 */  
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
    // ── reverse ──────────────────────────────────────────────────────────────  
 *       and {@code tostring} / {@code tonumber}.</li>
    }
    }
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
     *  verifies the right-side whitespace removal. */
    }
    public void testToNumberDecimalFractional() throws IOException {  
        assertFirstRowString(oneRow("key00") + "| eval v = reverse(str0) | fields v", "ERUTINRUF");
 * The OpenSearch Contributors require contributions made to  
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('101', 8) | fields v", 65.0, 0.0);
        assertFirstRowLong(oneRow("key00") + "| eval v = length(str0) | fields v", 9);
    }
    private void assertFirstRowLong(String ppl, long expected) throws IOException {  
    /** {@code substring('FURNITURE', 2)} → "URNITURE" (8 chars, from index 2 to end). */
    // ── ltrim / rtrim / trim ────────────────────────────────────────────────
        assertFirstRowString(oneRow("key00") + "| eval v = concat(str0, str2) | fields v", "FURNITUREone");
    public void testStrcmpGreater() throws IOException {  
        assertNotNull("commas cell must not be null", cell);
    }
        assertTrue("commas cell must be String but was " + cell.getClass(), cell instanceof String);  
    }
 * example, {@code tostring(int0 * 12345, 'commas')} on {@code int0=1} yields
        assertFirstRowDouble(oneRow("key00") + "| eval v = tonumber('4598') | fields v", 4598.0, 0.0);
    public void testUpper() throws IOException {  
    /** {@code reverse('FURNITURE')} on a field → "ERUTINRUF". */
    }  
 *   <li>Name-mapping adapter rewrites (PPL name ≠ DataFusion name) registered in
    public void testConcatWs() throws IOException {  
    public void testAscii() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval v = strcmp('banana', 'apple') | fields v", 1);
 *
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = tostring(int0 * 12345, 'commas') | fields v");
