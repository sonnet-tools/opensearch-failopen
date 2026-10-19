        assertEquals("eval-derived date span must remain DATE-typed", "2004-04-01", cell);
            123456L, ((Number) firstRowFirstCell(response)).longValue());
        );
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
    public void testMakeTimeFractional() throws IOException {
    }
        // maketime(20, 30, 40) → '20:30:40'; maketime(20.2, 49.5, 42.1) → '20:50:42.x'.
    /** TIME('16:00:61') rejects with a format hint. */
        assertSchemaType(response, "date_span", "date");
    /** microsecond on a varchar column resolves through the same string-overload arm. */
            oneRow() + "| eval a = cast('2200-01-01 00:00:00' as TIMESTAMP) | fields a",
    }
    public void testInvalidTimestampSecond61() throws IOException {
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    }
    /** MINUTE(TIME(...)) resolves through the DATE_PART(unit, TIME) overload. */
    }
        Object cell = firstRowFirstCell(response);
            oneRow() + "| eval f = microsecond('2024-01-15 12:00:00.000001') | fields f"
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
    // Format-token / mode / value-range — week modes, format tokens, MAKEDATE/MAKETIME, CAST.
    // ─────────────────────────────────────────────────────────────────────────
        Map<String, Object> response = executePpl(
        );
    public void testDaynameValidLiteral() throws IOException {
        Map<String, Object> response = executePpl(
    // Function overload resolution — 2-arg DATETIME, FSP variants, TIME args, ADDDATE/SUBDATE,
        Object cell = firstRowFirstCell(response);
            oneRow() + "| eval f = date_format(timestamp(date0, time1), '%Y-%m-%d %H:%i:%s') | fields f",
        );
        Map<String, Object> response = executePpl(oneRow() + "| eval f = week(date('2008-02-20'), 1) | fields f");
        assertEquals("minute bucket on time1='19:36:22' must be '19:36:00'", "19:36:00", cell);
    // ─────────────────────────────────────────────────────────────────────────
        assertErrorContains(
    private String oneRow() {
        List<Object> list = (List<Object>) cell;
        // datetime0 at key00 = 2004-07-09T10:17:35Z; +00:00 is identity.
    public void testHourOfTimeLiteralFold() throws IOException {
        // Value is TZ-config-dependent; pin only the type contract — pre-fix this 400'd.
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    public void testDateFormatPercentFFullSixDigits() throws IOException {
        assertFirstRowString(oneRow() + "| eval a = cast(bool0 as string) | fields a", "TRUE");
        assertFirstRowString(oneRow() + "| eval a = monthname('2020-08-26') | fields a", "August");
    public void testAddDateIntegerDaysOnTimestamp() throws IOException {
        assertFirstRowString(
            Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
    /** Boundary: cast('9999-12-31' AS DATE) — ANSI-SQL max DATE round-trips. */
        Map<String, Object> response = executePpl(
        );
    /** DATETIME('2025-13-02') with bad date folds to NULL (single-arg form). */
    }
        assertEquals("month bucket must be a bare date string", "2004-04-01", cell);
        // Single-arg DATETIME's contract on this branch is NULL fold (vs. throw for DATE/TIME/TIMESTAMP).
        Map<String, Object> response = executePpl(
        return row.get(0);
    // ─────────────────────────────────────────────────────────────────────────
    public void testDatePartTimeMinute() throws IOException {
    }
    // span() preserves bucket type for date / time inputs (5 tests)
    public void testCastTimestampPreservesMicros() throws IOException {
    public void testTimestampDiffMonthApprox() throws IOException {
        );
    public void testDateFormatPercentTokens() throws IOException {
        assertEquals("col-input DATETIME with +00:00 must be identity", "2004-07-09 10:17:35", cell);
    public void testDateSubOnTime() throws IOException {
    }
        assertNull("DATETIME('2025-13-02') must fold to NULL", cell);
        // nullif(x, x) → typed-null string, mirroring null `name` / `state` columns in the SQL fixture.
    /** span(date, 1month) preserves date type, bucket on month boundary. */
        Map<String, Object> response = executePpl(oneRow() + "| eval f = sysdate(0) | fields f");
 * {@code tests/parquet/a-date-time-failed/} and {@code tests/parquet/assertion-error-deep-dive/}.
    }
        }
    }
    }
    }
     * arg0 is a typed-null string ({@code precision_timestamp(9)?} mismatch pre-fix). */
        Object cell = firstRowFirstCell(response);
            oneRow() + "| eval f = time_format(date_add(time('09:00:00'), interval 1 hour), '%H:%i:%s') | fields f"
    /** Assert the query rejects with HTTP 4xx and the response body contains {@code expectedSubstring}. */
    public void testTwoArgDatetimeColInput() throws IOException {
    }
        // Per CalciteDateTimeFunctionIT testUnixTimeStamp.ppl: 3404817525.0
            Response response = client().performRequest(request);
    public void testTwoArgDatetimeNamedZone() throws IOException {
        // date0 at key00 = '2004-04-15'; time1 at key00 = '19:36:22'.
        assertEquals("μs=1 must surface as 1, not 0", 1L, ((Number) cell).longValue());
}
        assertEquals("microsecond on varchar col must surface the 6-digit fraction",
            DatasetProvisioner.provision(client(), DATASET);
    public void testDateFormatRichSpec() throws IOException {
    }
        // %H:%i:%s drops the fractional tail (engine-specific and not gate-stable).
            oneRow() + "| eval f = datetime('2008-01-01 02:00:00', '+10:00') | fields f",
 */
    /** TIMESTAMPDIFF with a bad string literal rejects. */
        // 2020-08-26 was a Wednesday.
    // swap the predicate for `OpenSearchTypeFactory.isDateExprType(type)` (already true for both
        assertFirstRowString(oneRow() + "| eval a = cast('9999-12-31' as DATE) | fields a", "9999-12-31");
 * compatible open source license.
    // ─────────────────────────────────────────────────────────────────────────
    public void testCastBooleanToStringUppercase() throws IOException {
                body.contains(expectedSubstring)
    }
    // ExprDateType (the SQL plugin's DATE UDT), not just DateOnlyType. The eval-derived `date(...)`
    }
        Map<String, Object> response = executePpl(
                return;
    public void testConvertTzOutOfRangeFolds() throws IOException {
        assertNotNull("μs-only fraction must be non-null post-fix", cell);
    /** MAKEDATE with fractional and >365 day-of-year inputs. */
            oneRow() + "| eval a = cast('2262-04-11 23:47:16.854' as TIMESTAMP) | fields a",
    public void testMonthnameBadStringRejects() throws IOException {
        assertEquals("timestampdiff(DAY,...) must be 30", 30L, ((Number) firstRowFirstCell(response)).longValue());
    }
        for (Map<String, Object> entry : schema) {
        assertFirstRowString(
package org.opensearch.analytics.qa;
        );
            "1945-01-06 / 1989-06-06"
        );
        // unlike stock MySQL's no-leading-zero %c, so January → "01".
    public void testSpanDateTypePreservesDate() throws IOException {
 * underlying fixes has been undone. Coverage shapes are sourced from
    @SuppressWarnings("unchecked")
            "12:00:00"
    /** 2-arg DATETIME with named-zone string — schema only; value depends on TZ. */
        Map<String, Object> response = executePpl(
        assertFirstRowString(oneRow() + "| eval a = cast(false as string) | fields a", "FALSE");
        Object cell = firstRowOf(response, "date_span");
    public void testAddDateIntegerDaysOnDate() throws IOException {
        Object cell = firstRowOf(response, "time_span");
    /** FROM_UNIXTIME(epoch, format) 2-arg overload renders correctly. */
        // 1521467703 = 2018-03-19 13:55:03 UTC.
    /** convert_tz with out-of-range tz folds to NULL (not HTTP 400). */
        assertNotNull("Response missing 'datarows'", rows);
    public void testTimestampDateAndTimeArgs() throws IOException {
    public void testDatePartTimeSecond() throws IOException {
        assertEquals("time bucket must omit the 1970-01-01 prefix", "19:00:00", cell);
    // ─────────────────────────────────────────────────────────────────────────
    /** unix_timestamp(numeric YYYYMMDDhhmmss) parses the compact form. */
    // Invalid string literals → HTTP 4xx with format hint (validation at plan time).
 * exercises one query shape that previously failed; a regression here signals that one of the
            oneRow() + "| eval f = timestampdiff(MONTH, '2024-01-01 00:00:00', '2024-07-15 00:00:00') | fields f"
    private void assertSchemaType(Map<String, Object> response, String colName, String expectedType) {
    }
        Map<String, Object> response = executePpl(
                + "| eval f = date_format(timestamp('1998-01-31 13:14:15'), '%a %b %c %D %d %H %i %M %m %S') | fields f",
        Map<String, Object> response = executePpl(oneRow() + "| eval a = datetime('2025-13-02') | fields a");
    }
    /** microsecond('… .123456') returns 123456, not 123000. */
    /** TIMESTAMP(date_col, time_col) combines the two operands. */
    }
        );
                + "| eval f = time_format(maketime(20, 30, 40), '%H:%i:%s') + ' / ' + time_format(maketime(20.2, 49.5, 42.1), '%H:%i:%s') | fields f",
    }
                assertEquals("schema type for [" + colName + "]", expectedType, entry.get("type"));
    public void testSubDateIntegerDaysOnDate() throws IOException {
        Object cell = firstRowFirstCell(response);
    }
        assertTrue("Row must have at least one cell", row.size() >= 1);
    public void testDaynameBadStringRejects() throws IOException {
            "source=" + DATASET.indexName + " | where key='key00' | stats list(datetime0) as l"
    /** cast(true AS string) literal form renders upper-case. */
    }
    /** CAST('xxx' AS TIME) rejects with a format hint. */
    }
            "source=" + DATASET.indexName + " | stats count() as c by span(date0, 1d) as date_span | sort date_span | head 1"
        );
        );
    /** DATE('2025-13-02') rejects with a format hint. */
    }
    }
    }
    }
        Map<String, Object> response = executePpl(
        );
    public void testCastTrueLiteralToStringUppercase() throws IOException {
import org.opensearch.client.ResponseException;
            } catch (Exception ioe) {
            assertTrue(
/*
    }
    private static boolean dataProvisioned = false;
        assertNotNull("unix_timestamp on YYYYMMDDhhmmss numeric must be non-null post-fix", cell);
    }
                + "| eval n = nullif(key, key), t = nullif(key, key) "
            oneRow() + "| eval f = date_format(timestampadd(YEAR, 1, '2024-01-15 12:00:00'), '%Y-%m-%d %H:%i:%s') | fields f",
    public void testInvalidTimeSecond61() throws IOException {
    /** cast('1985-10-09 12:00:00' AS TIME) returns the time portion only. */
        assertNotNull("Response missing 'datarows'", rows);
        assertNotNull("Response missing 'schema'", schema);
            "2020-08-27"
    }
    /** span(time, 1h) returns TIME-typed bucket, no '1970-01-01' prefix. */
            "2013-05-01 00:00:00"
    }
            "1677-09-21 00:12:44"
            oneRow() + "| eval f = subdate(date('2020-08-26'), 1) | fields f",
    // Datetime stringification — space separator, no 1970-epoch prefix, boolean upper-case.
    }
        assertTrue("Expected at least one row, got " + rows.size(), rows.size() >= 1);
        assertErrorContains(oneRow() + "| eval a = monthname('2025-13-02') | fields a", "unsupported format");
    /** DAYNAME with a valid date literal renders the full weekday name (positive path). */
        // Pre-fix %b silently mapped to month=1; post-fix it parses 'May' = 5.
        // Time-only DATE_ADD lifts to a date_add over today's date; pin the time-of-day suffix only.
    /** Boundary: cast('00:00:00' AS TIME) — midnight TIME round-trips. */
    /** ADDDATE(TIMESTAMP, integer days) — promotes to TIMESTAMP wall time. */
    public void testListFunctionTimestampUsesSpace() throws IOException {
    }
    public void testBoundary_minSupportedDate() throws IOException {
    }
        Map<String, Object> response = executePpl(
            "2200-01-01 00:00:00"
    /** DATE_SUB(TIME, interval) overload resolves. */
            oneRow() + "| eval f = date_format(str_to_date('1-May-13', '%d-%b-%y'), '%Y-%m-%d %H:%i:%s') | fields f",
    }
        assertSchemaType(response, "date_span", "date");
    /** μs=1 fraction surfaces as 1 (not zeroed by ms-truncation). */
    /** TIMESTAMPDIFF standalone string-overload resolves. */
    }
                + "| fields d1, d2"
    /** ADDDATE(DATE, INTERVAL n DAY) — interval form sharing the DATE_ADD path. */
        Map<String, Object> response = executePpl(
        assertTrue("schema missing column [" + colName + "], got " + cols, idx >= 0);
        Map<String, Object> response = executePpl(
        return rows.get(0).get(idx);
        assertSchemaType(response, "f", "timestamp");
    }
    public void testMakeDateFractionalDayOfYear() throws IOException {
    public void testCastTimeFromDatetimeString() throws IOException {
    public void testSpanCustomFormatDate() throws IOException {
import java.io.IOException;
    }
    private Object firstRowFirstCell(Map<String, Object> response) {
    /** WEEK(date, mode) — mode-arg overload resolves to a positive int. */
        assertFirstRowString(oneRow() + "| eval a = cast(true as string) | fields a", "TRUE");
    }
        return "source=" + DATASET.indexName + " | where key='key00' | head 1 ";
    }
            oneRow() + "| eval f = datetime(datetime0, '+00:00') | fields f"
        List<Map<String, Object>> schema = (List<Map<String, Object>>) response.get("schema");
            "2023-10-01 12:00:00.123456"
    }
    /** TIMESTAMPADD standalone string-overload resolves. */
    }
    /** TIMESTAMPDIFF(MONTH, ...) approximation rounds to whole months. */
        // Bare date string contract — pre-fix this rendered '2004-04-15 00:00:00'.
        assertEquals("timestampdiff(MONTH,...) over 6m14d must be 6", 6L, ((Number) firstRowFirstCell(response)).longValue());
        Object cell = firstRowFirstCell(response);
        assertFirstRowString(
        assertNotNull("sysdate(0) must be non-null post-fix", cell);
    /** TIMESTAMPADD with a bad string literal rejects. */
    /** date_format with %c %U %u %V %v emits zero-padded month + correct week numbering. */
            "source=" + DATASET.indexName + " | where key='key00' | stats list(datetime0) as l | head 1"
    // ─────────────────────────────────────────────────────────────────────────
        // time1 = '19:36:22' → 1h-bucket = '19:00:00'. Pre-fix this carried a 1970 prefix.
            oneRow() + "| eval f = microsecond('2024-01-15 12:00:00.123456') | fields f"
        assertSchemaType(response, "time_span", "time");
        assertEquals("hour(TIME) must be 17", 17L, ((Number) firstRowFirstCell(response)).longValue());
        assertFirstRowString(
            oneRow() + "| eval f = time_format(cast('1985-10-09 12:00:00' as TIME), '%H:%i:%s') | fields f",
    /** Assert the schema entry for {@code colName} declares the given type. */
        );
        assertSchemaType(response, "time_span", "time");
    // ─────────────────────────────────────────────────────────────────────────
            oneRow() + "| eval f = unix_timestamp(20771122143845) | fields f"
            "2262-04-11 23:47:16.854"
        Object cell = firstRowFirstCell(response);
import java.util.Map;
        );
        Map<String, Object> response = executePpl(
            "source=" + DATASET.indexName + " | where key='key00' | stats count() by span(time1, 1minute) as time_span"
        Request request = new Request("POST", "/_plugins/_ppl");
        );
    public void testMicrosecondOnVarcharColumn() throws IOException {
        // makedate(1945, 5.9) → '1945-01-06' (FLOOR rounding); makedate(1984, 1984) → '1989-06-06'.
            oneRow() + "| eval f = date_format('2024-01-15 12:00:00.123456', '%f') | fields f",
        assertFirstRowString(
    // ─────────────────────────────────────────────────────────────────────────
        // calcs has no date_nanos field; the µs round-trip is the closest available gate.
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("second(TIME) must be 45", 45L, ((Number) firstRowFirstCell(response)).longValue());
        Object cell = firstRowFirstCell(executePpl(ppl));
    }
        assertSchemaType(response, "f", "timestamp");
    public void testNowFspVariant() throws IOException {
            "Sat Jan 01 31st 31 13 14 January 01 15"
    /** Assert query returns exactly one cell of the given string value. */
        );
    public void testInvalidDateMonth13() throws IOException {
        Map<String, Object> response = executePpl(
    }
        assertFirstRowString(
        assertEquals("week_of_year(date('2008-02-20')) default mode 0 must be 7",
        // Locale-independent subset of the deep-dive 23-token spec (drops %j/%P/%r/%T).
    public void testListFunctionDateUsesSpace() throws IOException {
    public void testBoundary_minSupportedTimestamp() throws IOException {
        assertErrorContains(oneRow() + "| eval a = cast('xxx' as TIMESTAMP) | fields a", "xxx");
    /** WEEK_OF_YEAR(date) default mode 0 returns MySQL-style 7. */
    public void testTimestampAddStandalone() throws IOException {
    public void testDatePartTimeHour() throws IOException {
    // DateOnlyType and ExprDateType / stock DATE). Same for the TimeOnlyType branch below it.
        assertFirstRowString(oneRow() + "| eval a = cast('23:59:59.999999' as TIME) | fields a", "23:59:59.999999");
        );
                + "| eval f = date_format(makedate(1945, 5.9), '%Y-%m-%d') + ' / ' + date_format(makedate(1984, 1984), '%Y-%m-%d') | fields f",
        Map<String, Object> response = executePpl(
            oneRow() + "| eval f = convert_tz('2024-01-15 12:00:00', '+15:00', '+00:00') | fields f"
        );
        assertTrue("Expected at least one row", rows.size() >= 1);
        Object cell = firstRowFirstCell(response);
            oneRow()
    /** Pull the cell of column {@code colName} from row 0. */
    }
        assertFirstRowString(
import org.opensearch.client.Response;
        );
    public void testAddDateIntervalOnDate() throws IOException {
        Object cell = firstRowOf(response, "time_span");
    @SuppressWarnings("unchecked")
    // Helpers
        assertErrorContains(oneRow() + "| eval a = date('2025-13-02') | fields a", "2025-13-02");
        assertEquals("unix_timestamp(20771122143845) must equal 3404817525.0",
            "2025-01-15 12:00:00"
    }
        Object cell = firstRowFirstCell(response);
    /** cast(boolean AS string) emits upper-case TRUE post-fix (CastToVarcharRewriter). */
    public void testMonthnameValidLiteral() throws IOException {
    /** span(date, 1d) bucket renders as bare date, no '00:00:00' suffix. */
        assertFirstRowString(oneRow() + "| eval a = dayname('2020-08-26') | fields a", "Wednesday");
    /** DAYNAME('2025-13-02') rejects at plan time with the format hint (no StreamException). */
            "2004-04-15 19:36:22"
    /** list(date) renders with space separator, not 'T'. */
    /** HOUR('99:99:99') rejects (was silent 200 returning 0 pre-fix). */
    /** date_format with the rich %a/%b/%c/%D/%H/%i token spec round-trips. */
        Map<String, Object> response = executePpl(
        try {
            oneRow() + "| eval f = adddate(date('2020-08-26'), 1) | fields f",
    }
        assertFirstRowString(
        Map<String, Object> response = executePpl(
            oneRow() + "| eval d = date('2004-04-15') | stats count() by span(d, 1month) as date_span"
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        assertEquals("microsecond must be 123456 (6-digit, not ms-truncated)",
        assertEquals("list element must use space separator", "2004-07-09 10:17:35", list.get(0));
     * {@link org.opensearch.be.datafusion.ConvertTzAdapter} keeps the lowering well-typed when
    /** SUBDATE(DATE, integer days) — sign folded by adapter. */
    /** cast(varchar AS TIMESTAMP) preserves microseconds (not truncated to ms). */
    }
        Map<String, Object> response = executePpl(oneRow() + "| eval f = week_of_year(date('2008-02-20')) | fields f");
        }
            oneRow() + "| eval a = cast('1677-09-21 00:12:44' as TIMESTAMP) | fields a",
        assertEquals("ISO-T separator must not appear in stringified timestamp",
    public void testFromUnixTimeWithFormat() throws IOException {
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/sql/pull/<TBD>")
    /** DATE_ADD(TIME, interval) overload resolves. */
    /** 2-arg DATETIME with out-of-range tz folds to NULL (instead of HTTP 400). */
        Map<String, Object> response = executePpl(
        Map<String, Object> response = executePpl(oneRow() + "| eval f = hour(time('17:30:45')) | fields f");
        Object cell = firstRowOf(response, "date_span");
        assertFirstRowString(
        assertNull("datetime('2004-02-28 23:00:00-10:00', null) must be NULL", firstRowOf(response, "d2"));
    public void testSpanDateUnitMonth() throws IOException {
        assertEquals("week(date('2008-02-20')) default mode 0 must be 7",
import org.opensearch.client.Request;
            oneRow()
            "01 04 04 04 04"
            "2004-07-09 10:17:35", list.get(0));
        );
            "2020-09-17 17:30:00"
    }
            if (colName.equals(entry.get("name"))) {
        assertErrorContains(oneRow() + "| eval a = cast('xxx' as TIME) | fields a", "xxx");
     * Mirrors {@code CalcitePPLBuiltinFunctionsNullIT.testDatetimeNullString}; the SAFE-cast in
    // the renderer's `instanceof DateOnlyType` check at AnalyticsExecutionEngine.java:236 misses,
    // ─────────────────────────────────────────────────────────────────────────
        assertFirstRowString(oneRow() + "| eval a = cast('0001-01-01' as DATE) | fields a", "0001-01-01");
        assertErrorContains(oneRow() + "| eval a = timestampadd(YEAR, 1, '2025-13-02') | fields a", "2025-13-02");
 * The OpenSearch Contributors require contributions made to
        );
        assertFirstRowString(
    // ─────────────────────────────────────────────────────────────────────────
    // Sub-second precision — microseconds round-trip without ms-truncation.
            try {
        @SuppressWarnings("unchecked")
        );
        assertSchemaType(response, "d2", "timestamp");
        assertSchemaType(response, "date_span", "date");
        Map<String, Object> response = executePpl(oneRow() + "| eval f = minute(time('17:30:45')) | fields f");
        assertErrorContains(oneRow() + "| eval a = dayname('2025-13-02') | fields a", "unsupported format");
        assertErrorContains(oneRow() + "| eval a = time('16:00:61') | fields a", "16:00:61");
        assertFirstRowString(oneRow() + "| eval a = cast('00:00:00' as TIME) | fields a", "00:00:00");
 *
            oneRow() + "| eval f = datetime('2008-01-01 02:00:00', 'America/Los_Angeles') | fields f"
    protected void onBeforeQuery() throws IOException {
    public void testCastFalseLiteralToStringUppercase() throws IOException {
    }
        assertFirstRowString(
    public void testTimestampDiffStandalone() throws IOException {
    /** WEEK(date) default mode 0 returns MySQL-style 7 (not ISO 8). */
    /** list(timestamp) preserves space separator (timestamp-element accumulator path). */
    }
            oneRow() + "| eval f = date_format(date('2024-01-28'), '%c %U %u %V %v') | fields f",
    // TODO(sql-plugin): broaden midnight-suffix strip in AnalyticsExecutionEngine#convert to recognise
            7L, ((Number) firstRowFirstCell(response)).longValue());
        assertFirstRowString(
        int idx = cols.indexOf(colName);
    private void assertFirstRowString(String ppl, String expected) throws IOException {
            654321L, ((Number) firstRowFirstCell(response)).longValue());
    }
            "2020-08-25"
        );
    }
        assertFirstRowString(
        List<Object> list = (List<Object>) cell;
        Map<String, Object> response = executePpl(
public class DatetimeCoverageIT extends AnalyticsRestTestCase {
        assertEquals("date_span must render as bare date", "1972-07-04", cell);
        assertEquals("hour(TIME('17:30:00')) must fold to 17", 17L,
        // bool0 at key00 = true; PPL contract matches tostring(boolean) = uppercase.
    /** MAKETIME with integer and fractional H/M/S inputs. */
        assertFirstRowString(
    public void testSpanTimeUnitMinute() throws IOException {
    public void testBoundary_minSupportedTime() throws IOException {
        );
    // TIMESTAMP composition + HOUR plan-time fold.
            oneRow()
    }
        assertSchemaType(response, "d1", "timestamp");
            3404817525.0, ((Number) cell).doubleValue(), 0.5);
    }
    }
    /** CAST('xxx' AS DATE) rejects with a format hint. */
    @SuppressWarnings("unchecked")
        assertFirstRowString(
        );
        assertFirstRowString(
 * Regression gates for PPL date/time/timestamp coverage on the analytics-engine route. Each test
        assertErrorContains(oneRow() + "| eval a = hour('99:99:99') | fields a", "99:99:99");
    /** 2-arg DATETIME with null string operands returns TIMESTAMP-typed null rows.
    /** date_format('… .123456', '%f') emits the 6-digit fractional second. */
        @SuppressWarnings("unchecked")
            oneRow()
    /** 2-arg DATETIME(literal, tz-literal) folds to a typed TIMESTAMP. */
        );
    /** Boundary: cast('23:59:59.999999' AS TIME) — last-µs-of-day TIME round-trips. */
    public void testBoundary_dateNanosNearYear2262Limit() throws IOException {
    }
        assertEquals("date_sub(time, -30min) wall time must be 08:30:00", "08:30:00", firstRowFirstCell(response));
        assertFirstRowString(
    public void testDateAddOnTime() throws IOException {
    }
    /** MONTHNAME with a valid date literal renders the full month name (positive path). */
        List<String> cols = extractColumnNames(response);
            "2020-08-29 00:00:00"
    }
            }
            "source=" + DATASET.indexName + " | stats count() as c by span(date1, 1month) as date_span | sort date_span | head 1"
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
        );
    public void testCastStringToTimestampRejects() throws IOException {
    /** HOUR(TIME(...)) resolves through the DATE_PART(unit, TIME) overload. */
        assertNull("out-of-range tz must fold to NULL post-fix", cell);
            oneRow() + "| eval f = timestampdiff(DAY, '2024-01-01 00:00:00', '2024-01-31 00:00:00') | fields f"
    public void testCastStringToDateRejects() throws IOException {
    // TIMESTAMPADD/DIFF standalone, DATE_PART(unit, TIME), 2-arg FROM_UNIXTIME.
/**
        assertNotNull("date_span must be non-null", cell);
import java.util.List;
    public void testNanosecondLiteralFold() throws IOException {
    /** now(0)/sysdate(0) FSP-arg overload resolves. Asserts type+nonnull only. */
    /** span over an eval-derived DATE expression preserves DATE typing. */
    /** MONTHNAME('2025-13-02') rejects at plan time with the format hint (no StreamException). */
    }
        );
    /** str_to_date('1-May-13', '%d-%b-%y') resolves the %b month abbreviation. */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + body);
            );
    public void testTimestampAddBadLiteralRejects() throws IOException {
    }
        List<Object> row = rows.get(0);
        } catch (ResponseException e) {
    public void testTwoArgDatetimeBoundsFoldsNull() throws IOException {
            oneRow() + "| eval a = timestampdiff(DAY, '2025-13-02', '2025-12-01') | fields a",
            "20:30:40 / 20:50:42"
    }
    /** Boundary: max supported TIMESTAMP at milli precision — just under the i64-ns epoch ceiling (2262-04-11). */
    }
        // 2024-01-28 — Sunday. Mode 0 (Sun-first): U=4, V=4. Mode 1 (Mon-first): u=4, v=4.
    public void testUnixTimestampNumericLiteral() throws IOException {
        );
        fail("schema missing column [" + colName + "]");
    public void testWeekOfYearMode0() throws IOException {
    // ─────────────────────────────────────────────────────────────────────────
            String body;
            "source=" + DATASET.indexName + " | where key='key00' | stats count() by span(time1, 1h) as time_span"
            "2025-13-02"
        );
    public void testWeekDefaultMode0() throws IOException {
            oneRow() + "| eval f = datetime('2008-01-01 02:00:00', '+15:00') | fields f"
    private Object firstRowOf(Map<String, Object> response, String colName) {
    }
            oneRow() + "| eval f = adddate(date('2020-08-26'), interval 3 day) | fields f",
    /** Boundary: cast('2200-01-01 00:00:00' AS TIMESTAMP) — well below the year-2262 i64-ns ceiling. */
            "2007-12-31 16:00:00"
            "2018-03-19 13:55:03"
    /** 2-arg DATETIME with column input resolves through the same overload. */
    public void testTwoArgDatetimeNullOperandsReturnNull() throws IOException {
        assertErrorContains(oneRow() + "| eval a = timestamp('2025-12-01 15:02:61') | fields a", "2025-12-01 15:02:61");
    public void testBoundary_maxSupportedDate() throws IOException {
    // Boundary values — min/max supported date/time/timestamp.
        );
                + "| eval d1 = DATETIME(n, '+10:00'), d2 = datetime('2004-02-28 23:00:00-10:00', t) "
        Object cell = firstRowOf(response, "date_span");
    }
    }
    /** ADDDATE(DATE, integer days) lowers via DateAddSubAdapter integer-days form. */
        // %c on the PPL/AE route maps to "MM" (zero-padded) per DateTimeFormatterUtil.DATE_HANDLERS,
        );
    // ─────────────────────────────────────────────────────────────────────────
            7L, ((Number) firstRowFirstCell(response)).longValue());
        }
                + "| eval a = date_format(cast('2023-10-01 12:00:00.123456' as TIMESTAMP), '%Y-%m-%d %H:%i:%s.%f') | fields a",
    public void testStrToDatePercentB() throws IOException {
    // ─────────────────────────────────────────────────────────────────────────
    public void testTwoArgDatetimeLiteralFold() throws IOException {
        assertEquals("date_add(time, +1h) wall time must be 10:00:00", "10:00:00", firstRowFirstCell(response));
    /** Boundary: min supported TIMESTAMP — engine rejects below the i64-ns epoch floor (1677-09-21 00:12:44). */
    public void testHourBadStringRejects() throws IOException {
        Map<String, Object> response = executePpl(
            ((Number) firstRowFirstCell(response)).longValue());
        if (dataProvisioned == false) {
    /** Boundary: cast('0001-01-01' AS DATE) — ANSI-SQL min DATE round-trips. */
            oneRow()
    // ─────────────────────────────────────────────────────────────────────────
        );
    }
            oneRow() + "| eval s = '2024-01-15 12:00:00.654321' | eval f = microsecond(s) | fields f"
        );
    // produces ExprDateType, which SpanFunction.getReturnTypeInference forwards through the call;
        assertFirstRowString(
        );
    /** Pull cell [0][0] from a parsed response. */
    /** cast(false AS string) literal form renders upper-case. */
        Map<String, Object> response = executePpl(oneRow() + "| eval f = hour(time('17:30:00')) | fields f");
    public void testTimestampDiffBadLiteralRejects() throws IOException {
    public void testCastStringToTimeRejects() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            oneRow() + "| eval f = time_format(date_sub(time('09:00:00'), interval 30 minute), '%H:%i:%s') | fields f"
    // ─────────────────────────────────────────────────────────────────────────
        Map<String, Object> response = executePpl(
        assertErrorContains(oneRow() + "| eval a = cast('xxx' as DATE) | fields a", "xxx");
        );
        );
    }
        Map<String, Object> response = executePpl(oneRow() + "| eval f = second(time('17:30:45')) | fields f");
    }
    public void testBoundary_maxSupportedTime() throws IOException {
        );
    // ─────────────────────────────────────────────────────────────────────────
    }
    public void testWeekModeArgOverload() throws IOException {
                body = e.getMessage();
        Object cell = firstRowFirstCell(response);
            oneRow() + "| eval f = from_unixtime(1521467703, '%Y-%m-%d %H:%i:%s') | fields f",
    }
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {
        Map<String, Object> response = executePpl(oneRow() + "| eval f = week(date('2008-02-20')) | fields f");
        );
    @Override
        // engine prints fractional seconds as-given; no zero-pad to µs
        assertTrue("week(date, 1) must be a positive integer", ((Number) cell).longValue() > 0);
    }
    /** CAST('xxx' AS TIMESTAMP) rejects with a format hint. */
        assertTrue("list(datetime0) must be a List, got " + cell, cell instanceof List);
        assertNull("out-of-range source tz must fold to NULL", firstRowFirstCell(response));
    /** span(time, 1minute) returns TIME-typed bucket. */
        );
    }
    /** TIMESTAMP('2025-12-01 15:02:61') rejects with a format hint. */
        assertEquals("list(datetime0) length", 1, list.size());
            }
        // +10:00 offset shifts wall time back 10h → '2007-12-31 16:00:00'.
    public void testInvalidDatetimeFoldsNull() throws IOException {
 */
    }
            "123456"
    // ─────────────────────────────────────────────────────────────────────────
    public void testBoundary_maxSupportedTimestampMilli() throws IOException {
    }
            dataProvisioned = true;
        assertFirstRowString(
    // ─────────────────────────────────────────────────────────────────────────
        assertEquals("minute(TIME) must be 30", 30L, ((Number) firstRowFirstCell(response)).longValue());
    public void testMicrosecondTimestampSixDigits() throws IOException {
    /** SECOND(TIME(...)) resolves through the DATE_PART(unit, TIME) overload. */
            oneRow() + "| eval f = adddate(timestamp('2020-09-16 17:30:00'), 1) | fields f",
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        assertNotNull("week(date, mode) must be non-null post-fix", cell);
        );
    public void testSpanTimeTypePreservesTime() throws IOException {
    /** HOUR(TIME('17:30:00')) literal-folds at plan time. */
    // so the value comes back as "2004-04-01 00:00:00" instead of bare "2004-04-01". One-line fix:
        assertNull("DATETIME(null, '+10:00') must be NULL", firstRowOf(response, "d1"));
