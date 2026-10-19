        assertFirstRowDouble(oneRow("key00") + "| eval s = '2g' | convert memk(s) AS v | fields v", 2.0 * 1024 * 1024, 0.0);  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '34,54,45' | convert num(s) AS v | fields v", 345445.0, 0.0);  
        // int0 = 1 on key00; no conversion applied, original numeric value returned.
        assertFirstRowString(oneRow("key00") + "| convert none(str2) | fields str2", "one");  
    /** Millisecond precision — zero-pads {@code .5} to {@code .500}. */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '03:45' | convert mstime(s) AS v | fields v", 225.0, 0.0);  
            1_234_567.89, 1e-6  
        assertNull("mktime('not a date') should be NULL but was " + cell, cell);
            "2023-11-14"
        assertFirstRowDouble(
        assertFirstRowDouble(oneRow("key00") + "| eval s = '500' | convert memk(s) AS v | fields v", 500.0, 0.0);  
        assertEquals("Constant false predicate should remove all rows", 0, rowCount);  
import java.util.List;
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '+0' | convert num(s) AS v | fields v", 0.0, 0.0);
    public void testMstimeAcceptsBareNumber() throws IOException {
 *
    public void testRmunitHandlesScientificNotation() throws IOException {
            oneRow("key00") + "| eval s = '1066507633' | convert TIMEFORMAT='%d/%m/%Y' ctime(s) AS v | fields v",
        // str2 = 'one' passed through via none; num('1,234.5') transformed to 1234.5.
    public void testDur2secWithDaysPrefix() throws IOException {  
    }  
    /** Edge boundaries */
    public void testDur2secSimple() throws IOException {
            assertNull("mstime('" + input + "') should be NULL but was " + cell, cell);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '500k' | convert memk(s) AS v | fields v", 500.0, 0.0);
    /** Pure numeric input — rmunit just parses. */
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = '00:60' | convert mstime(s) AS v | fields v");
        Map<String, Object> response = executePpl(ppl);  
            oneRow("key00") + "| eval s = '1,234,567.89' | convert rmcomma(s) AS v | fields v",
            oneRow("key00") + "| eval s = '1066507633' | convert TIMEFORMAT='' ctime(s) as v | fields v"
 *
    public void testMktimeCustomFormat() throws IOException {  
    public void testRmunitReturnsNullForLetterStart() throws IOException {
    public void testRmunitHandlesPureNumber() throws IOException {  
    }
            1e-9
            oneRow("key00") + "| eval s = '1066507633' | convert TIMEFORMAT='%Y-%m-%d %H:%M:%S' ctime(s) AS v | fields v",
        assertFirstRowDouble(oneRow("key00") + "| eval s = '+123' | convert num(s) AS v | fields v", 123.0, 0.0);
        }
    public void testMstimeRejectsSecondsOver59InMmSs() throws IOException {
    public void testMktimeRejectsDateOnlyFormat() throws IOException {
    public void testRmcommaReturnsNullForLetters() throws IOException {
 *   <li>{@code none(x)} — no-op. Upstream {@code AstBuilder} drops unaliased calls entirely
    public void testMstimeRejectsMalformed() throws IOException {
    /** Memory-size suffixes — auto goes through memk first */
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";  
    public void testNoneWithAliasRenames() throws IOException {
        Object cell = firstRowFirstCell(oneRow("key00") + "| convert none(int0) | fields int0");
 * </ul>
    public void testAutoRejectsLetterPrefix() throws IOException {
        );
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'AAAA2.000,000' | convert auto(s) AS v | fields v");  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1,234.5' | convert num(s) AS v | fields v", 1234.5, 1e-9);  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '12,345.67' | convert rmcomma(s) AS v | fields v", 12345.67, 1e-9);  
    }
/*  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '45.123' | convert mstime(s) AS v | fields v", 45.123, 1e-9);
    }  
 *       as a formatted time string</li>  
    public void testNumOnNumericColumn() throws IOException {  
    /** 'k' suffix — value pass-through. */  
        );
    private Object firstRowFirstCell(String ppl) throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '123 K' | convert rmunit(s) AS v | fields v", 123.0, 0.0);  
        Map<String, Object> response = executePpl(
    }  
        // An empty result may omit the data array entirely — treat absent as zero rows.  
    }  
    }
    /** Plain decimal literal routed through num(). */
    public void testNoneMixedWithRealConversion() throws IOException {  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '3.14'  | convert mstime(s) AS v | fields v", 3.14, 1e-9);  
    /** Unknown suffix ('t' for terabytes isn't supported) returns NULL. */  
    /** Whitespace between number and suffix is rejected */
        );  
import java.util.Map;  
        assertFirstRowString(
    /** Numeric short-circuit — already in seconds. */
    }
        int rowCount = data == null ? 0 : ((List<?>) data).size();
            946_684_800.0, 0.0  
    public void testCtimeDefaultFormat() throws IOException {  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'not-a-number' | convert ctime(s) AS v | fields v");  
        );  
    public void testCtimeOnNumericColumn() throws IOException {
 *
    // ── rmcomma ────────────────────────────────────────────────────────────
        assertNull("dur2sec('24:00:00') should be NULL but was " + cell, cell);  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '+100' | convert memk(s) AS v| fields v", 100.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1234' | convert rmcomma(s) AS v | fields v", 1234.0, 0.0);
 * <p>Numeric family — return DOUBLE
        for (String special : new String[] { "Infinity", "NaN" }) {
            String ppl = oneRow("key00") + "| eval s = '" + input + "' | convert memk(s) AS v | fields v";
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-100' | convert memk(s) AS v | fields v", -100.0, 0.0);
    }  
    /** Default format: {@code ctime(1700000000)} → "11/14/2023 22:13:20" (UTC). */
     *  SS-only with ms. */
    /** Exact-comma-count ladder - comma-stripped number are truncated. */
    /** Empty format returns NULL */
            1_066_473_433.0, 0.0
 *   <li>{@code mstime(x)} — parse a {@code [MM:]SS.SSS} time-of-day string into total seconds
    public void testMemkMSuffixMultipliesBy1024() throws IOException {  
    // impl), so it reaches OpenSearchFilterRule and the indexed scan, both of
    public void testDur2secEdgeBoundaries() throws IOException {
 *   <li>{@code rmcomma(x)} — strip commas then parse; NULL if the input contains any letter.</li>
    /** Unaliased {@code convert none(str)} preserves original string type and value. */
            oneRow("key00") + "| eval s = '1700000000' | convert ctime(s) AS v | fields v",
    /** custom-format */
        Object data = response.containsKey("datarows") ? response.get("datarows") : response.get("rows");
        );  
            String ppl = oneRow("key00") + "| eval s = '" + special + "' | convert auto(s) AS v | fields v";
    /** Unparseable input → NULL. */
            946_684_800.0, 0.0
public class ConversionFunctionsIT extends AnalyticsRestTestCase {  
    // ── ctime ──────────────────────────────────────────────────────────────  
    /** MM:SS without millis, MM:SS.SSS, minute overflow that still parses since minutes are unbounded, and  
    }
    public void testNumZeroBoundaries() throws IOException {
 *
        );
        assertFirstRowDouble(oneRow("key00") + "| eval s = '01:01:01' | convert dur2sec(s) AS v | fields v", 3661.0, 0.0);
    }  
            oneRow("key00") + "| eval s = '1066473433' | convert mktime(s) AS v | fields v",  
        assertFirstRowDouble(
        assertFirstRowDouble(oneRow("key00") + "| eval s = '03:45.123' | convert mstime(s) AS v | fields v", 225.123, 1e-9);
    // ── rmunit ─────────────────────────────────────────────────────────────
        assertFirstRowDouble(oneRow("key00") + "| eval s = '42' | convert rmunit(s) AS v | fields v", 42.0, 0.0);
        for (String input : new String[] { "invalid", "1:2:3" }) {
        );
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), delta);
        return rows.get(0).get(0);
    }
    public void testCtimeMktimeRoundTrip() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1e5 meters' | convert num(s) AS v | fields v", 1e5, 0.0);
    }
    /** Signed-zero boundaries */
        assertNull("mktime with date-only format should be NULL but was " + cell, cell);
    }
            0.0
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1.23e-4' | convert num(s) AS v | fields v", 1.23e-4, 1e-12);  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2g' | convert auto(s) AS v | fields v", 2_097_152.0, 0.0);
    /** {@code none} composes with real conversions in the same convert clause — only the real one transforms. */
    }
    }  
 * The OpenSearch Contributors require contributions made to  
    /** Complex comma patterns */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '3600' | convert dur2sec(s) AS v | fields v", 3600.0, 0.0);  
 * <ul>
 *   <li>{@code ctime(value[, format])} — render UNIX epoch seconds (numeric or numeric-string)
    public void testMktimeNumericInputPassesThrough() throws IOException {  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-0' | convert num(s) AS v | fields v", -0.0, 0.0);
    }
    }  
    public void testCtimePplCustomFormat() throws IOException {
        assertTrue("none(int0) should preserve numeric type but got: " + cell, cell instanceof Number);  
    }
        );
    }  
    }
    public void testConvertMktimeThenWhereConstantPredicatePasses() throws IOException {
            Object cell = firstRowFirstCell(ppl);
    public void testMemkKSuffixIsPassThrough() throws IOException {
}
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
    /** Invalid-shape */  
    public void testMemkAcceptsSignedValues() throws IOException {
 * </ul>  
package org.opensearch.analytics.qa;
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = '12,345abc' | convert rmcomma(s) AS v | fields v");
 *       string back into UNIX epoch seconds (DOUBLE)</li>
        assertFirstRowDouble(oneRow("key00") + "| eval s = '02:30' | convert mstime(s) AS v | fields v", 150.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '50.5 m' | convert rmunit(s) AS v | fields v", 50.5, 1e-9);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1+00:00:00' | convert dur2sec(s) AS v | fields v", 86_400.0, 0.0);  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2232,4.000,000' | convert auto(s) AS v | fields v", 22324.0, 0.0);
    }  
 *   <li>{@code rmunit(x)} — extract and parse the leading numeric token.</li>
    }  
    public void testAutoFallsBackToNum() throws IOException {  
            "01/01/1970 00:00:01"  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'abc' | convert auto(s) AS v | fields v");  
        );  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = '24:00:00' | convert dur2sec(s) AS v | fields v");
        assertFirstRowDouble(oneRow("key00") + "| eval s = '+50m' | convert memk(s) AS v | fields v", 51200.0, 0.0);
    }  
    public void testNumExtractsLeadingNumberBeforeUnitSuffix() throws IOException {
    }
    private void assertFirstRowDouble(String ppl, double expected, double delta) throws IOException {
    }
    public void testAutoPrefersMemoryUnit() throws IOException {
    }  
     *  before dispatch. Epoch 1 UTC → 01/01/1970 00:00:01. */
    public void testDur2secAcceptsPreParsedNumber() throws IOException {
    }
        assertNull("ctime with empty format should be NULL but was " + cell, cell);
    }
        assertNull("num('abc') should be NULL but was " + cell, cell);
        assertFirstRowDouble(
    }
    }
    }
    /** {@code convert none(field) AS alias} lowers to a plain rename — same value, new name. */  
        assertFirstRowString(
    }  
        );
    /** Out-of-range components trip the regex-branch validation. */  
            DatasetProvisioner.provision(client(), DATASET);  
     *  comma-strip fallback */
 * <ul>  
        );  
        // 61:01 is valid because the regex doesn't bound minutes.  
    // ── num ────────────────────────────────────────────────────────────────  
 *
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-100k' | convert auto(s) AS v | fields v", -100.0, 0.0);  
        assertNull("memk('1.5t') should be NULL but was " + cell, cell);  
    public void testAutoReturnsNullWhenBothPathsFail() throws IOException {
    // ── dur2sec ────────────────────────────────────────────────────────────
    }
 */
            Object cell = firstRowFirstCell(ppl);  
    public void testMemkReturnsNullForUnknownSuffix() throws IOException {
        );
            dataProvisioned = true;
    public void testNonePassesColumnThrough() throws IOException {  
    }
        );
 *   <li>{@code key00}: num0=12.3, int0=1, str2="one"</li>
            1_066_507_633.0, 0.0
                + " | where date_str > 1000000000 | fields date_str",  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:00:00' | convert dur2sec(s) AS v | fields v", 0.0, 0.0);
            0.0
            "18/10/2003"  
 * <ul>  
    public void testAutoRejectsSpecialValues() throws IOException {  
    }  
        );  
    /** Letter-prefixed memory values are rejected even when a valid suffix follows */
    public void testAutoComplexCommaPatterns() throws IOException {
        Object cell = firstRowFirstCell(  
    public void testMktimeRejectsUnknownFormatTokens() throws IOException {  
        if (dataProvisioned == false) {
    /** Unparseable input — both paths fail, auto returns NULL. */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2232,4.000,000AAAAA' | convert auto(s) AS v | fields v", 2232.0, 0.0);
    /** Memory-unit input — auto() routes through memk first. */  
    }
    /** Signed variants */  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1+02:03:04' | convert dur2sec(s) AS v | fields v", 93784.0, 0.0);
    // ── memk ───────────────────────────────────────────────────────────────
    }
 * this file be licensed under the Apache-2.0 license or a
/**
    /** Days-prefixed duration. */
 * <ul>
    }
    /** Round-trip: ctime → mktime returns the original epoch. */  
        assertNull("auto('AAAA2.000,000') should be NULL but was " + cell, cell);
            oneRow("key00") + "| eval s = '10/18/2003 20:07:13' | convert TIMEFORMAT='' mktime(s) AS v | fields v"
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:59.999' | convert mstime(s) AS v | fields v", 59.999, 1e-9);  
    /** Negative values pass through. */  
    public void testRmcommaAcceptsNegative() throws IOException {
    /** Date-only format returns NULL */  
    }
    }  
    public void testDur2secRejectsOutOfRange() throws IOException {
    /** Scientific notation before the unit. */  
    /** Leading {@code +} is accepted. */
    }
        );  
    }
        assertFirstRowDouble(  
        // int0 = 1 on key00 → CAST(1 AS VARCHAR) = "1" → epoch 1s → 01/01/1970 00:00:01.  
    public void testMstimePplReference() throws IOException {
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
            oneRow("key00") + "| eval s = '1700000000' | convert TIMEFORMAT='%Y-%m-%d %H:%M:%S' ctime(s) as ss | convert TIMEFORMAT='%Y-%m-%d %H:%M:%S' mktime(ss) AS v | fields v",  
            oneRow("key00")
        }
    /** num on a numeric column reference — ConversionFunctionAdapter coerces int0 to VARCHAR. */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '50m' | convert auto(s) AS v | fields v", 51200.0, 0.0);
    /** 'g' suffix — value × 1024². */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '61:01' | convert mstime(s) AS v | fields v", 3661.0, 0.0);
    }
            Object cell = firstRowFirstCell(ppl);  
        assertNull("mktime with invalid format should be NULL but was " + cell, cell);
    /** No leading number — rmunit returns NULL. */
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '   2,12.0 AAA' | convert num(s) AS v | fields v", 2.0, 1e-9);
        assertFirstRowDouble(
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:59:59' | convert dur2sec(s) AS v | fields v", 3599.0, 0.0);
            Object cell = firstRowFirstCell(ppl);  
        }  
            assertNull("auto('" + special + "') should be NULL but was " + cell, cell);
        assertFirstRowDouble(
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'abc' | convert num(s) AS v | fields v");
        assertFirstRowString(
            1_066_507_633.0,
        assertNull("mstime('00:60') should be NULL but was " + cell, cell);  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:00.5' | convert mstime(s) AS v | fields v", 0.5, 1e-9);
    /** Unparseable input → NULL. */
    }
            "1970"
    }  
    public void testMemkRejectsSpacedSuffix() throws IOException {  
    /** Scientific notation */  
    /** Leading number followed by a non-digit unit suffix — num extracts the numeric head. */  
    public void testNumCommaAndUnitLadder() throws IOException {  
    // which once rejected constant predicates. mktime('10/18/2003 20:07:13') =
    }  
    /** {@code convert none(field)} is dropped by the AST — original column passes through unchanged. */
    // ── mktime ─────────────────────────────────────────────────────────────
    /** Comma-separated thousands — num should 1strip them. */
        assertFirstRowString(oneRow("key00") + "| convert none(str2) AS copy | fields copy", "one");
 *   <li>{@code mktime(value[, format])} — inverse of {@code ctime}: parse a formatted time
 * <p>Identity verb
    }
    public void testAutoMemorySuffixes() throws IOException {
            1_700_000_000.0,
    /** Non-memory numeric input — auto falls through to num(). */
 *   <li>{@code key04}: num0=3.5, int0=7</li>  
 *       and lowers aliased calls to a plain field rename, so nothing has to reach
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'not a date' | convert mktime(s) AS v | fields v");  
        }
 */  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = '1.5t' | convert memk(s) AS v | fields v");
    /** Malformed format string returns NULL */
    }
    public void testRmcommaReference() throws IOException {  
 * <p>Time-formatting family  
        assertFirstRowString(  
            assertNull("memk('" + input + "') should be NULL but was " + cell, cell);
    /** Edge-case boundaries */  
 * End-to-end coverage for conversion functions  
    private void assertFirstRowString(String ppl, String expected) throws IOException {
    }  
    /** Strip commas then parse. */
        }
        assertEquals("none(int0) should preserve value", 1, ((Number) cell).intValue());
        assertFirstRowDouble(  
            oneRow("key00") + "| eval s = '2023-11-14' | convert TIMEFORMAT='%Y-%m-%d' mktime(s) AS v | fields v"  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '0' | convert num(s) AS v | fields v", 0.0, 0.0);  
        Object cell = firstRowFirstCell(
    public void testMktimeDefaultFormat() throws IOException {
        );
            oneRow("key00") + "| eval s = '1,234.5' | convert none(str2), num(s) AS v | fields v",  
    /** {@code dur2sec('01:01:01')} → 3661. */  
        Object cell = firstRowFirstCell(
    }
    public void testNumPlainDecimalLiteral() throws IOException {  
            oneRow("key00") + "| eval s = '2003-10-18 20:07:13' | convert TIMEFORMAT='invalid format' mktime(s) AS v | fields v"
    /** Empty format string returns NULL */
    }  
            String ppl = oneRow("key00") + "| eval s = '" + input + "' | convert memk(s) AS v | fields v";
    // ── convert + where on a constant conversion ────────────────────────────  
            assertNull("memk('" + input + "') should be NULL but was " + cell, cell);
    public void testRmunitExtractsLeadingNumber() throws IOException {
            oneRow("key00") + "| eval s = '10/18/2003 20:07:13' | convert mktime(s) AS v | fields v",
    /** Pre-parsed numeric input short-circuits to passthrough. */
        );  
    }  
    public void testMemkRejectsLetterPrefixedValues() throws IOException {  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1.5m' | convert auto(s) AS v | fields v", 1536.0, 0.0);
    /** Regex-branch check: {@code 00:60} has seconds >= 60 → NULL. */  
import java.io.IOException;
 *       with millisecond precision.</li>  
    }
            "2003-10-18 20:07:13"
 * </ul>  
            oneRow("key00") + "| convert ctime(int0) AS v | fields v",
                + "| eval date_str = '10/18/2003 20:07:13' | convert mktime(date_str)"  
    public void testRmunitAcceptsSpacedMemoryUnits() throws IOException {
            oneRow("key00") + "| eval s = '18/10/2003 20:07:13' | convert TIMEFORMAT='%d/%m/%Y %H:%M:%S' mktime(s) AS v | fields v",
    }  
        assertNull("ctime('not-a-number') should be NULL but was " + cell, cell);
    /** Spaced memory units */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '100k' | convert auto(s) AS v | fields v", 100.0, 0.0);  
        for (String input : new String[] { "abc100m", "test50k", "memory2g" }) {
        for (String input : new String[] { "100 k", "50 m", "2 g" }) {
        );
    /** Default-format */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1' | convert num(s) AS v | fields v", 1.0, 0.0);
    public void testCtimeRejectsEmptyFormat() throws IOException {  
    /** {@code mstime('02:30')} → 150 seconds. */  
 *   <li>{@code dur2sec(x)} — parse an {@code [D+]HH:MM:SS} duration string into total seconds.</li>
    // constant predicate. ReduceExpressionsRule can't fold mktime (no plan-time  
    }  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1.5e2kg' | convert rmunit(s) AS v | fields v", 150.0, 0.0);
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
        @SuppressWarnings("unchecked")
            oneRow("key00") + "| eval s = '0' | convert TIMEFORMAT='%Y' ctime(s) AS v | fields v",  
            1234.5,
        assertFirstRowDouble(oneRow("key00") + "| eval s = '100MB' | convert num(s) AS v | fields v", 100.0, 0.0);
 *   <li>{@code num(x)} — strict numeric parse with comma-strip + leading-number-plus-unit-suffix fallback.</li>
    }  
    // ── helpers ─────────────────────────────────────────────────────────────  
        assertFirstRowDouble(
    /** Numeric column — ConversionFunctionAdapter's sibling coerces int0 to VARCHAR  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1,234' | convert auto(s) AS v | fields v", 1234.0, 0.0);
import org.opensearch.client.Response;
    /** custom-format */
            String ppl = oneRow("key00") + "| eval s = '" + input + "' | convert mstime(s) AS v | fields v";  
    public void testMstimeEdgeBoundaries() throws IOException {  
        assertNull("rmunit('abc') should be NULL but was " + cell, cell);
            1_066_507_633.0, 0.0  
            oneRow("key00") + "| eval s = '01/01/2000 00:00:00' | convert mktime(s) AS v | fields v",
    /** Custom format. */
    public void testMstimeMmSs() throws IOException {
    public void testNumScientificNotation() throws IOException {
            oneRow("key00") + "| eval s = '01/01/2000 00:00:00' | convert TIMEFORMAT='%d/%m/%Y %H:%M:%S' mktime(s) AS v | fields v",  
    // ── auto ───────────────────────────────────────────────────────────────
        assertFirstRowString(
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        // int0 = 1 on key00 → CAST(1 AS VARCHAR) = "1" → num("1") = 1.0.
    public void testCtimeReturnsNullOnGarbage() throws IOException {
    }
    /** Special values — {@code ∞}, {@code Infinity}, {@code NaN} are all rejected. */
    // ── mstime ─────────────────────────────────────────────────────────────
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-1,000' | convert rmcomma(s) AS v | fields v", -1000.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-50m' | convert memk(s) AS v | fields v", -51200.0, 0.0);  
    }
        assertFirstRowDouble(
        assertFirstRowDouble(oneRow("key00") + "| eval s = '01:30.5' | convert mstime(s) AS v | fields v", 90.5, 1e-9);
 *       backend. These tests lock the pass-through contract end-to-end.</li>  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '3.14' | convert num(s) AS v | fields v", 3.14, 1e-9);
    }  
    public void testMemkGSuffixMultipliesBy1024Squared() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:00.001' | convert mstime(s) AS v | fields v", 0.001, 1e-9);
    public void testCtimeCustomFormat() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '100MB' | convert rmunit(s) AS v | fields v", 100.0, 0.0);  
    //
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1.5m' | convert memk(s) AS v | fields v", 1536.0, 0.0);
        assertNull("auto('abc') should be NULL but was " + cell, cell);
        );
    /** Numeric short-circuit returns the value verbatim (even if >= 60). */
    }
    public void testNonePreservesStringColumn() throws IOException {
    /** Letter-prefixed input — auto rejects even when commas would normally unlock the  
                + " | where date_str < 1000000000 | fields date_str"
    public void testMstimeZeroPadsMillis() throws IOException {  
    /** Extract the leading numeric token before a unit suffix. */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
import org.opensearch.client.Request;
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1e5' | convert num(s) AS v | fields v", 1e5, 0.0);
        Object cell = firstRowFirstCell(ppl);  
            "11/14/2023 22:13:20"  
    @Override  
        assertFirstRowDouble(oneRow("key00") + "| eval s = '3600' | convert mktime(s) AS v | fields v", 3600.0, 0.0);
 * </ul>
 * <p>Fixture row values (from {@code datasets/calcs/bulk.json}):  
 *   <li>{@code memk(x)} — pure memory-unit conversion ({@code k}/{@code m}/{@code g} → KB).</li>  
        assertFirstRowString(  
 * <ul>  
    public void testNumAcceptsLeadingPlus() throws IOException {  
 * compatible open source license.
 * </ul>
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:00' | convert mstime(s) AS v | fields v", 0.0, 0.0);
    public void testConvertMktimeThenWhereConstantPredicateFiltersOut() throws IOException {  
    /** PPL rmcomma reference */
        assertNull("mktime with empty format should be NULL but was " + cell, cell);  
    public void testMktimeRejectsEmptyFormat() throws IOException {
    }  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'abc' | convert rmunit(s) AS v | fields v");  
    }
    private static boolean dataProvisioned = false;
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2.000' | convert auto(s) AS v | fields v", 2.0, 1e-9);  
    private String oneRow(String key) {
    }
            oneRow("key00") + "| eval s = '1700000000' | convert TIMEFORMAT='%Y-%m-%d' ctime(s) AS v | fields v",
        Object cell = firstRowFirstCell(ppl);  
 *
                + "| eval date_str = '10/18/2003 20:07:13' | convert mktime(date_str)"
    }
    }
    /** Bare number is already in KB. */
 * <p>Duration / time-of-day family — return DOUBLE seconds
    public void testMktimeReturnsNullOnMalformed() throws IOException {
    public void testRmcommaStripsAndParses() throws IOException {
        assertNull("rmcomma('12,345abc') should be NULL but was " + cell, cell);  
    /** Letters anywhere in the input short-circuit to NULL, even after commas. */  
    }
    protected void onBeforeQuery() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    /** 'm' suffix — value × 1024. */
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);  
 *   <li>{@code auto(x)} — {@code num} semantics plus memory-unit prefix (k / m / g → KB).</li>
    // ── none ───────────────────────────────────────────────────────────────  
    /** Letter-prefixed input — num returns NULL. */
    // convert mktime(<literal>) | where converted <op> N yields a column-less
        );
    public void testNumReturnsNullForLetterPrefix() throws IOException {  
            oneRow("key00")
        Object cell = firstRowFirstCell(
    public void testMemkBareNumberIsKilobytes() throws IOException {
    // 1066507633: > 1000000000 keeps the row, < 1000000000 drops it.  
    public void testNumStripsCommas() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '212.04,54545 AAA' | convert num(s) AS v | fields v", 212.04, 1e-9);
