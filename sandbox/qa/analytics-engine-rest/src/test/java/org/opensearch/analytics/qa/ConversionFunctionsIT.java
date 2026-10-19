        for (String special : new String[] { "Infinity", "NaN" }) {
    }
        );
    /** Regex-branch check: {@code 00:60} has seconds >= 60 → NULL. */
        for (String input : new String[] { "abc100m", "test50k", "memory2g" }) {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '+50m' | convert memk(s) AS v | fields v", 51200.0, 0.0);
    public void testAutoFallsBackToNum() throws IOException {
        }
    }
    }
    /** Comma-separated thousands — num should 1strip them. */
            1_234_567.89, 1e-6
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2232,4.000,000AAAAA' | convert auto(s) AS v | fields v", 2232.0, 0.0);
    /** MM:SS without millis, MM:SS.SSS, minute overflow that still parses since minutes are unbounded, and
 *
 *   <li>{@code mstime(x)} — parse a {@code [MM:]SS.SSS} time-of-day string into total seconds
        );
 *
    public void testMktimeReturnsNullOnMalformed() throws IOException {
    @Override
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:00.001' | convert mstime(s) AS v | fields v", 0.001, 1e-9);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:00:00' | convert dur2sec(s) AS v | fields v", 0.0, 0.0);
        assertNull("ctime('not-a-number') should be NULL but was " + cell, cell);
    public void testRmcommaReference() throws IOException {
    }
        );
        );
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2.000' | convert auto(s) AS v | fields v", 2.0, 1e-9);
    /** Numeric short-circuit — already in seconds. */
        );
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1,234' | convert auto(s) AS v | fields v", 1234.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '   2,12.0 AAA' | convert num(s) AS v | fields v", 2.0, 1e-9);
            0.0
    /** Signed variants */
    /** 'k' suffix — value pass-through. */
        assertFirstRowString(oneRow("key00") + "| convert none(str2) | fields str2", "one");
    public void testAutoRejectsLetterPrefix() throws IOException {
    /** 'm' suffix — value × 1024. */
 * <ul>
import java.util.Map;
        assertFirstRowDouble(oneRow("key00") + "| eval s = '02:30' | convert mstime(s) AS v | fields v", 150.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '100MB' | convert rmunit(s) AS v | fields v", 100.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '01:01:01' | convert dur2sec(s) AS v | fields v", 3661.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1+00:00:00' | convert dur2sec(s) AS v | fields v", 86_400.0, 0.0);
    }
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1.23e-4' | convert num(s) AS v | fields v", 1.23e-4, 1e-12);
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-100' | convert memk(s) AS v | fields v", -100.0, 0.0);
    public void testMemkKSuffixIsPassThrough() throws IOException {
        // int0 = 1 on key00 → CAST(1 AS VARCHAR) = "1" → num("1") = 1.0.
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'AAAA2.000,000' | convert auto(s) AS v | fields v");
 *       as a formatted time string</li>
        assertFirstRowDouble(
    }
    public void testMstimeZeroPadsMillis() throws IOException {
    }
    public void testMktimeNumericInputPassesThrough() throws IOException {
        assertFirstRowDouble(
    /** Letter-prefixed memory values are rejected even when a valid suffix follows */
            "18/10/2003"
        );
    public void testDur2secSimple() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1e5 meters' | convert num(s) AS v | fields v", 1e5, 0.0);
/**
        assertNull("memk('1.5t') should be NULL but was " + cell, cell);
    }
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1+02:03:04' | convert dur2sec(s) AS v | fields v", 93784.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '500k' | convert memk(s) AS v | fields v", 500.0, 0.0);
        );
 * <p>Time-formatting family
    public void testCtimeMktimeRoundTrip() throws IOException {
 * <p>Identity verb
        );
    }
    /** No leading number — rmunit returns NULL. */
 * SPDX-License-Identifier: Apache-2.0
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = '1.5t' | convert memk(s) AS v | fields v");
        // str2 = 'one' passed through via none; num('1,234.5') transformed to 1234.5.
    public void testRmunitHandlesScientificNotation() throws IOException {
    public void testNumCommaAndUnitLadder() throws IOException {
        );
 *   <li>{@code rmcomma(x)} — strip commas then parse; NULL if the input contains any letter.</li>
        assertNull("mktime with invalid format should be NULL but was " + cell, cell);
public class ConversionFunctionsIT extends AnalyticsRestTestCase {
    /** Out-of-range components trip the regex-branch validation. */
        );
        assertFirstRowDouble(oneRow("key00") + "| eval s = '0' | convert num(s) AS v | fields v", 0.0, 0.0);
    }
    // impl), so it reaches OpenSearchFilterRule and the indexed scan, both of
    }
            oneRow("key00") + "| eval s = '01/01/2000 00:00:00' | convert TIMEFORMAT='%d/%m/%Y %H:%M:%S' mktime(s) AS v | fields v",
    /** Exact-comma-count ladder - comma-stripped number are truncated. */
    public void testMstimePplReference() throws IOException {
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'not a date' | convert mktime(s) AS v | fields v");
        }
    }
        assertFirstRowString(
 */
    public void testRmcommaStripsAndParses() throws IOException {
    /** Bare number is already in KB. */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '01:30.5' | convert mstime(s) AS v | fields v", 90.5, 1e-9);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '3600' | convert dur2sec(s) AS v | fields v", 3600.0, 0.0);
 * <ul>
    /** Memory-size suffixes — auto goes through memk first */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '50.5 m' | convert rmunit(s) AS v | fields v", 50.5, 1e-9);
 * </ul>
        );
import java.util.List;
        assertFirstRowString(
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
 *
 * <p>Numeric family — return DOUBLE
        assertFirstRowDouble(
        assertFirstRowDouble(
 *   <li>{@code rmunit(x)} — extract and parse the leading numeric token.</li>
    public void testMemkReturnsNullForUnknownSuffix() throws IOException {
 * </ul>
        assertFirstRowDouble(oneRow("key00") + "| eval s = '3.14'  | convert mstime(s) AS v | fields v", 3.14, 1e-9);
    // ── num ────────────────────────────────────────────────────────────────
        );
    private String oneRow(String key) {
        );
        }
    }
 *       string back into UNIX epoch seconds (DOUBLE)</li>
            String ppl = oneRow("key00") + "| eval s = '" + input + "' | convert memk(s) AS v | fields v";
            oneRow("key00") + "| eval s = '10/18/2003 20:07:13' | convert TIMEFORMAT='' mktime(s) AS v | fields v"
    public void testMstimeEdgeBoundaries() throws IOException {
            1_066_473_433.0, 0.0
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1,234.5' | convert num(s) AS v | fields v", 1234.5, 1e-9);
    public void testMemkMSuffixMultipliesBy1024() throws IOException {
        // int0 = 1 on key00; no conversion applied, original numeric value returned.
    /** Scientific notation before the unit. */
    public void testNumStripsCommas() throws IOException {
            oneRow("key00")
    /** {@code mstime('02:30')} → 150 seconds. */
        assertFirstRowDouble(
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'not-a-number' | convert ctime(s) AS v | fields v");
    private Object firstRowFirstCell(String ppl) throws IOException {
 * <ul>
    // ── dur2sec ────────────────────────────────────────────────────────────
            oneRow("key00")
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:00.5' | convert mstime(s) AS v | fields v", 0.5, 1e-9);
        assertNull("mstime('00:60') should be NULL but was " + cell, cell);
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'abc' | convert rmunit(s) AS v | fields v");
    public void testMstimeAcceptsBareNumber() throws IOException {
    /** 'g' suffix — value × 1024². */
    }
            1_066_507_633.0, 0.0
 * <p>Duration / time-of-day family — return DOUBLE seconds
    }
    public void testAutoPrefersMemoryUnit() throws IOException {
    }
    public void testNumPlainDecimalLiteral() throws IOException {
    /** Whitespace between number and suffix is rejected */
    /** Unparseable input → NULL. */
        assertNull("num('abc') should be NULL but was " + cell, cell);
    // ── convert + where on a constant conversion ────────────────────────────
    public void testDur2secRejectsOutOfRange() throws IOException {
    /** Unknown suffix ('t' for terabytes isn't supported) returns NULL. */
    private static boolean dataProvisioned = false;
    /** Special values — {@code ∞}, {@code Infinity}, {@code NaN} are all rejected. */
        assertFirstRowDouble(
 *   <li>{@code auto(x)} — {@code num} semantics plus memory-unit prefix (k / m / g → KB).</li>
        assertFirstRowDouble(oneRow("key00") + "| eval s = '45.123' | convert mstime(s) AS v | fields v", 45.123, 1e-9);
        );
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-100k' | convert auto(s) AS v | fields v", -100.0, 0.0);
 *
    }
            946_684_800.0, 0.0
    public void testMemkRejectsSpacedSuffix() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1' | convert num(s) AS v | fields v", 1.0, 0.0);
        Object cell = firstRowFirstCell(
    /** num on a numeric column reference — ConversionFunctionAdapter coerces int0 to VARCHAR. */
 * <ul>
    // ── none ───────────────────────────────────────────────────────────────
        Object data = response.containsKey("datarows") ? response.get("datarows") : response.get("rows");
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1e5' | convert num(s) AS v | fields v", 1e5, 0.0);
        );
    public void testRmunitHandlesPureNumber() throws IOException {
        assertNull("mktime with date-only format should be NULL but was " + cell, cell);
        // int0 = 1 on key00 → CAST(1 AS VARCHAR) = "1" → epoch 1s → 01/01/1970 00:00:01.
    /** Numeric short-circuit returns the value verbatim (even if >= 60). */
 * compatible open source license.
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
    public void testDur2secWithDaysPrefix() throws IOException {
    }
        Map<String, Object> response = executePpl(ppl);
 * The OpenSearch Contributors require contributions made to
import java.io.IOException;
        assertFirstRowDouble(oneRow("key00") + "| eval s = '+100' | convert memk(s) AS v| fields v", 100.0, 0.0);
            oneRow("key00") + "| eval s = '1700000000' | convert ctime(s) AS v | fields v",
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:59.999' | convert mstime(s) AS v | fields v", 59.999, 1e-9);
    // ── memk ───────────────────────────────────────────────────────────────
    /** Unaliased {@code convert none(str)} preserves original string type and value. */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '50m' | convert auto(s) AS v | fields v", 51200.0, 0.0);
        assertFirstRowString(
            assertNull("memk('" + input + "') should be NULL but was " + cell, cell);
import org.opensearch.client.Request;
    // ── helpers ─────────────────────────────────────────────────────────────
            oneRow("key00") + "| eval s = '1700000000' | convert TIMEFORMAT='%Y-%m-%d' ctime(s) AS v | fields v",
        assertFirstRowDouble(oneRow("key00") + "| eval s = '03:45.123' | convert mstime(s) AS v | fields v", 225.123, 1e-9);
    /** Letters anywhere in the input short-circuit to NULL, even after commas. */
    /** Strip commas then parse. */
        if (dataProvisioned == false) {
 *       with millisecond precision.</li>
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1.5m' | convert auto(s) AS v | fields v", 1536.0, 0.0);
        );
        assertFirstRowDouble(oneRow("key00") + "| eval s = '100k' | convert auto(s) AS v | fields v", 100.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '212.04,54545 AAA' | convert num(s) AS v | fields v", 212.04, 1e-9);
        for (String input : new String[] { "100 k", "50 m", "2 g" }) {
    /** Unparseable input — both paths fail, auto returns NULL. */
    }
            1_066_507_633.0, 0.0
    public void testRmcommaReturnsNullForLetters() throws IOException {
    public void testNonePassesColumnThrough() throws IOException {
        assertNull("rmcomma('12,345abc') should be NULL but was " + cell, cell);
            oneRow("key00") + "| eval s = '01/01/2000 00:00:00' | convert mktime(s) AS v | fields v",
    public void testCtimeReturnsNullOnGarbage() throws IOException {
    /** Custom format. */
            oneRow("key00") + "| eval s = '10/18/2003 20:07:13' | convert mktime(s) AS v | fields v",
            oneRow("key00") + "| eval s = '1066507633' | convert TIMEFORMAT='' ctime(s) as v | fields v"
    }
                + " | where date_str > 1000000000 | fields date_str",
    /** {@code none} composes with real conversions in the same convert clause — only the real one transforms. */
    public void testConvertMktimeThenWhereConstantPredicateFiltersOut() throws IOException {
        // An empty result may omit the data array entirely — treat absent as zero rows.
    }
            oneRow("key00") + "| eval s = '1700000000' | convert TIMEFORMAT='%Y-%m-%d %H:%M:%S' ctime(s) as ss | convert TIMEFORMAT='%Y-%m-%d %H:%M:%S' mktime(ss) AS v | fields v",
        assertFirstRowDouble(oneRow("key00") + "| eval s = '+0' | convert num(s) AS v | fields v", 0.0, 0.0);
            1234.5,
            "2003-10-18 20:07:13"
    }
            "11/14/2023 22:13:20"
    }
 *
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '34,54,45' | convert num(s) AS v | fields v", 345445.0, 0.0);
    protected void onBeforeQuery() throws IOException {
    /** Edge boundaries */
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = '12,345abc' | convert rmcomma(s) AS v | fields v");
    }
            oneRow("key00") + "| eval s = '1066507633' | convert TIMEFORMAT='%d/%m/%Y' ctime(s) AS v | fields v",
        assertEquals("Constant false predicate should remove all rows", 0, rowCount);
            assertNull("mstime('" + input + "') should be NULL but was " + cell, cell);
            oneRow("key00") + "| eval s = '18/10/2003 20:07:13' | convert TIMEFORMAT='%d/%m/%Y %H:%M:%S' mktime(s) AS v | fields v",
    /** Scientific notation */
    /** Edge-case boundaries */
    // ── ctime ──────────────────────────────────────────────────────────────
    public void testMktimeDefaultFormat() throws IOException {
    public void testNumScientificNotation() throws IOException {
        Object cell = firstRowFirstCell(
    /** Letter-prefixed input — num returns NULL. */
    }
        Object cell = firstRowFirstCell(
    /** Leading {@code +} is accepted. */
 *   <li>{@code ctime(value[, format])} — render UNIX epoch seconds (numeric or numeric-string)
    public void testCtimePplCustomFormat() throws IOException {
        int rowCount = data == null ? 0 : ((List<?>) data).size();
    }
    public void testNumExtractsLeadingNumberBeforeUnitSuffix() throws IOException {
    }
    public void testRmunitReturnsNullForLetterStart() throws IOException {
 *       backend. These tests lock the pass-through contract end-to-end.</li>
    public void testRmcommaAcceptsNegative() throws IOException {
            assertNull("auto('" + special + "') should be NULL but was " + cell, cell);
    public void testAutoRejectsSpecialValues() throws IOException {
    }
 *   <li>{@code num(x)} — strict numeric parse with comma-strip + leading-number-plus-unit-suffix fallback.</li>
    }
 *   <li>{@code key04}: num0=3.5, int0=7</li>
    public void testConvertMktimeThenWhereConstantPredicatePasses() throws IOException {
 *   <li>{@code dur2sec(x)} — parse an {@code [D+]HH:MM:SS} duration string into total seconds.</li>
    }
    public void testMemkRejectsLetterPrefixedValues() throws IOException {
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| convert none(int0) | fields int0");
        Object cell = firstRowFirstCell(ppl);
    public void testMktimeRejectsEmptyFormat() throws IOException {
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        assertFirstRowDouble(oneRow("key00") + "| eval s = '42' | convert rmunit(s) AS v | fields v", 42.0, 0.0);
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'abc' | convert num(s) AS v | fields v");
        );
    public void testRmunitAcceptsSpacedMemoryUnits() throws IOException {
            1_700_000_000.0,
        assertFirstRowString(
        }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:59:59' | convert dur2sec(s) AS v | fields v", 3599.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '61:01' | convert mstime(s) AS v | fields v", 3661.0, 0.0);
    public void testMstimeRejectsSecondsOver59InMmSs() throws IOException {
    }
        assertFirstRowString(
 *   <li>{@code memk(x)} — pure memory-unit conversion ({@code k}/{@code m}/{@code g} → KB).</li>
    // ── rmunit ─────────────────────────────────────────────────────────────
    }
 * <ul>
    public void testAutoComplexCommaPatterns() throws IOException {
    }
    }
    }
            oneRow("key00") + "| eval s = '1,234,567.89' | convert rmcomma(s) AS v | fields v",
        return rows.get(0).get(0);
    public void testNumZeroBoundaries() throws IOException {
    // ── rmcomma ────────────────────────────────────────────────────────────
        assertNull("mktime('not a date') should be NULL but was " + cell, cell);
                + "| eval date_str = '10/18/2003 20:07:13' | convert mktime(date_str)"
 *   <li>{@code none(x)} — no-op. Upstream {@code AstBuilder} drops unaliased calls entirely
    // 1066507633: > 1000000000 keeps the row, < 1000000000 drops it.
package org.opensearch.analytics.qa;
    /** Empty format returns NULL */
        assertFirstRowString(oneRow("key00") + "| convert none(str2) AS copy | fields copy", "one");
 *   <li>{@code mktime(value[, format])} — inverse of {@code ctime}: parse a formatted time
            oneRow("key00") + "| eval s = '1,234.5' | convert none(str2), num(s) AS v | fields v",
        assertFirstRowDouble(oneRow("key00") + "| eval s = '00:00' | convert mstime(s) AS v | fields v", 0.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '+123' | convert num(s) AS v | fields v", 123.0, 0.0);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '123 K' | convert rmunit(s) AS v | fields v", 123.0, 0.0);
    }
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
    /** Signed-zero boundaries */
    public void testMktimeCustomFormat() throws IOException {
    /** {@code convert none(field) AS alias} lowers to a plain rename — same value, new name. */
    // which once rejected constant predicates. mktime('10/18/2003 20:07:13') =
            oneRow("key00") + "| eval s = '2003-10-18 20:07:13' | convert TIMEFORMAT='invalid format' mktime(s) AS v | fields v"
     *  comma-strip fallback */
    /** Days-prefixed duration. */
        assertNull("ctime with empty format should be NULL but was " + cell, cell);
    }
 *       and lowers aliased calls to a plain field rename, so nothing has to reach
    public void testMktimeRejectsDateOnlyFormat() throws IOException {
        );
    // ── mstime ─────────────────────────────────────────────────────────────
        assertFirstRowDouble(oneRow("key00") + "| eval s = '100MB' | convert num(s) AS v | fields v", 100.0, 0.0);
    // ── auto ───────────────────────────────────────────────────────────────
    /** Spaced memory units */
}
        Map<String, Object> response = executePpl(
    /** Default format: {@code ctime(1700000000)} → "11/14/2023 22:13:20" (UTC). */
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = '24:00:00' | convert dur2sec(s) AS v | fields v");
 * this file be licensed under the Apache-2.0 license or a
    }
        assertNull("auto('AAAA2.000,000') should be NULL but was " + cell, cell);
 *   <li>{@code key00}: num0=12.3, int0=1, str2="one"</li>
    /** Numeric column — ConversionFunctionAdapter's sibling coerces int0 to VARCHAR
            946_684_800.0, 0.0
    /** Negative values pass through. */
    /** custom-format */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2232,4.000,000' | convert auto(s) AS v | fields v", 22324.0, 0.0);
    }
    }
            dataProvisioned = true;
            1_066_507_633.0,
    public void testMktimeRejectsUnknownFormatTokens() throws IOException {
    /** {@code dur2sec('01:01:01')} → 3661. */
            "2023-11-14"
    public void testMstimeRejectsMalformed() throws IOException {
    // ── mktime ─────────────────────────────────────────────────────────────
        assertTrue("none(int0) should preserve numeric type but got: " + cell, cell instanceof Number);
 */
    public void testMstimeMmSs() throws IOException {
    /** Millisecond precision — zero-pads {@code .5} to {@code .500}. */
    public void testNoneWithAliasRenames() throws IOException {
    }
    /** custom-format */
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
            Object cell = firstRowFirstCell(ppl);
    }
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
    /** Non-memory numeric input — auto falls through to num(). */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-1,000' | convert rmcomma(s) AS v | fields v", -1000.0, 0.0);
    /** Pre-parsed numeric input short-circuits to passthrough. */
        assertNull("rmunit('abc') should be NULL but was " + cell, cell);
    }
    /** {@code convert none(field)} is dropped by the AST — original column passes through unchanged. */
    }
    }
    /** Invalid-shape */
    }
    }
    public void testCtimeDefaultFormat() throws IOException {
    }
            oneRow("key00") + "| convert ctime(int0) AS v | fields v",
    }
        }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1.5e2kg' | convert rmunit(s) AS v | fields v", 150.0, 0.0);
    public void testAutoReturnsNullWhenBothPathsFail() throws IOException {
 * </ul>
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-50m' | convert memk(s) AS v | fields v", -51200.0, 0.0);
    /** PPL rmcomma reference */
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).doubleValue(), delta);
    /** Malformed format string returns NULL */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '-0' | convert num(s) AS v | fields v", -0.0, 0.0);
    // constant predicate. ReduceExpressionsRule can't fold mktime (no plan-time
    /** Default-format */
        assertNull("dur2sec('24:00:00') should be NULL but was " + cell, cell);
    }
        assertFirstRowDouble(
    public void testCtimeOnNumericColumn() throws IOException {
            String ppl = oneRow("key00") + "| eval s = '" + input + "' | convert mstime(s) AS v | fields v";
    }
        Object cell = firstRowFirstCell(
        assertNull("mktime with empty format should be NULL but was " + cell, cell);
            "01/01/1970 00:00:01"
            1e-9
        assertFirstRowDouble(oneRow("key00") + "| eval s = '3600' | convert mktime(s) AS v | fields v", 3600.0, 0.0);
    }
        assertFirstRowDouble(oneRow("key00") + "| eval s = '12,345.67' | convert rmcomma(s) AS v | fields v", 12345.67, 1e-9);
    /** Round-trip: ctime → mktime returns the original epoch. */
    public void testMemkBareNumberIsKilobytes() throws IOException {
        for (String input : new String[] { "invalid", "1:2:3" }) {
            DatasetProvisioner.provision(client(), DATASET);
        );
    }
    // convert mktime(<literal>) | where converted <op> N yields a column-less
        assertFirstRowDouble(oneRow("key00") + "| eval s = '03:45' | convert mstime(s) AS v | fields v", 225.0, 0.0);
    }
    public void testCtimeCustomFormat() throws IOException {
            oneRow("key00") + "| eval s = '1066473433' | convert mktime(s) AS v | fields v",
        @SuppressWarnings("unchecked")
        assertFirstRowString(
 * End-to-end coverage for conversion functions
    /** Leading number followed by a non-digit unit suffix — num extracts the numeric head. */
     *  SS-only with ms. */
    public void testMemkGSuffixMultipliesBy1024Squared() throws IOException {
    private void assertFirstRowString(String ppl, String expected) throws IOException {
        assertNull("auto('abc') should be NULL but was " + cell, cell);
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1234' | convert rmcomma(s) AS v | fields v", 1234.0, 0.0);
    public void testNonePreservesStringColumn() throws IOException {
                + " | where date_str < 1000000000 | fields date_str"
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2g' | convert auto(s) AS v | fields v", 2_097_152.0, 0.0);
    //
/*
            String ppl = oneRow("key00") + "| eval s = '" + input + "' | convert memk(s) AS v | fields v";
    /** Plain decimal literal routed through num(). */
        Object cell = firstRowFirstCell(ppl);
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = '00:60' | convert mstime(s) AS v | fields v");
    public void testNoneMixedWithRealConversion() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '3.14' | convert num(s) AS v | fields v", 3.14, 1e-9);
                + "| eval date_str = '10/18/2003 20:07:13' | convert mktime(date_str)"
            0.0
            String ppl = oneRow("key00") + "| eval s = '" + special + "' | convert auto(s) AS v | fields v";
        assertFirstRowDouble(oneRow("key00") + "| eval s = '1.5m' | convert memk(s) AS v | fields v", 1536.0, 0.0);
    }
            Object cell = firstRowFirstCell(ppl);
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
    public void testNumAcceptsLeadingPlus() throws IOException {
        assertFirstRowDouble(oneRow("key00") + "| eval s = '2g' | convert memk(s) AS v | fields v", 2.0 * 1024 * 1024, 0.0);
    public void testNumReturnsNullForLetterPrefix() throws IOException {
    private void assertFirstRowDouble(String ppl, double expected, double delta) throws IOException {
    /** Empty format string returns NULL */
        assertFirstRowDouble(oneRow("key00") + "| eval s = '500' | convert memk(s) AS v | fields v", 500.0, 0.0);
 *
    public void testMemkAcceptsSignedValues() throws IOException {
    }
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval s = 'abc' | convert auto(s) AS v | fields v");
        assertEquals("none(int0) should preserve value", 1, ((Number) cell).intValue());
    public void testNumOnNumericColumn() throws IOException {
            oneRow("key00") + "| eval s = '1066507633' | convert TIMEFORMAT='%Y-%m-%d %H:%M:%S' ctime(s) AS v | fields v",
    /** Pure numeric input — rmunit just parses. */
 * </ul>
    public void testRmunitExtractsLeadingNumber() throws IOException {
     *  before dispatch. Epoch 1 UTC → 01/01/1970 00:00:01. */
            "1970"
    /** Letter-prefixed input — auto rejects even when commas would normally unlock the
    }
            Object cell = firstRowFirstCell(ppl);
        assertFirstRowDouble(
    /** Extract the leading numeric token before a unit suffix. */
            oneRow("key00") + "| eval s = '2023-11-14' | convert TIMEFORMAT='%Y-%m-%d' mktime(s) AS v | fields v"
        assertFirstRowDouble(
        );
            assertNull("memk('" + input + "') should be NULL but was " + cell, cell);
    }
    }
 * <p>Fixture row values (from {@code datasets/calcs/bulk.json}):
    /** Memory-unit input — auto() routes through memk first. */
    public void testDur2secAcceptsPreParsedNumber() throws IOException {
    public void testCtimeRejectsEmptyFormat() throws IOException {
    public void testAutoMemorySuffixes() throws IOException {
    /** Complex comma patterns */
            oneRow("key00") + "| eval s = '0' | convert TIMEFORMAT='%Y' ctime(s) AS v | fields v",
            Object cell = firstRowFirstCell(ppl);
    /** Date-only format returns NULL */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
import org.opensearch.client.Response;
    }
        // 61:01 is valid because the regex doesn't bound minutes.
    /** Unparseable input → NULL. */
 * </ul>
    }
    }
    public void testDur2secEdgeBoundaries() throws IOException {
    }
