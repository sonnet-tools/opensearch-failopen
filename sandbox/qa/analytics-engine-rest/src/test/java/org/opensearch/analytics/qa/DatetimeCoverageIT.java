        // %H:%i:%s drops the fractional tail (engine-specific and not gate-stable).
import java.util.List;
        // 1521467703 = 2018-03-19 13:55:03 UTC.
        Object cell = firstRowFirstCell(executePpl(ppl));
    }
        Object cell = firstRowFirstCell(response);
        assertNull("DATETIME(null, '+10:00') must be NULL", firstRowOf(response, "d1"));
    /** CAST('xxx' AS TIME) rejects with a format hint. */
 * this file be licensed under the Apache-2.0 license or a
    /** 2-arg DATETIME with out-of-range tz folds to NULL (instead of HTTP 400). */  
        assertEquals("week_of_year(date('2008-02-20')) default mode 0 must be 7",
    }
    public void testDateFormatPercentFFullSixDigits() throws IOException {
        // +10:00 offset shifts wall time back 10h → '2007-12-31 16:00:00'.
    }
        assertNull("out-of-range tz must fold to NULL post-fix", cell);  
            "01 04 04 04 04"
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");  
    }
    }  
    }  
        Map<String, Object> response = executePpl(
        assertEquals("date_sub(time, -30min) wall time must be 08:30:00", "08:30:00", firstRowFirstCell(response));
    public void testBoundary_minSupportedDate() throws IOException {
            }  
    }
            oneRow() + "| eval a = cast('2200-01-01 00:00:00' as TIMESTAMP) | fields a",
    public void testWeekOfYearMode0() throws IOException {  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            oneRow() + "| eval f = adddate(date('2020-08-26'), 1) | fields f",
        // engine prints fractional seconds as-given; no zero-pad to µs  
    }
    /** cast(true AS string) literal form renders upper-case. */
    }
            }
    /** date_format('… .123456', '%f') emits the 6-digit fractional second. */
    /** cast(varchar AS TIMESTAMP) preserves microseconds (not truncated to ms). */
        );  
    /** Boundary: cast('2200-01-01 00:00:00' AS TIMESTAMP) — well below the year-2262 i64-ns ceiling. */
        }
        Map<String, Object> response = executePpl(
public class DatetimeCoverageIT extends AnalyticsRestTestCase {
        Object cell = firstRowFirstCell(response);  
            Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
    /** TIMESTAMP(date_col, time_col) combines the two operands. */
    }  
    /** DAYNAME('2025-13-02') rejects at plan time with the format hint (no StreamException). */  
    /** SECOND(TIME(...)) resolves through the DATE_PART(unit, TIME) overload. */  
        Map<String, Object> response = executePpl(
    /** Pull cell [0][0] from a parsed response. */  
    }
    public void testNanosecondLiteralFold() throws IOException {
            try {
    }
    // ─────────────────────────────────────────────────────────────────────────
    private String oneRow() {  
        assertFirstRowString(  
                + "| eval f = date_format(timestamp('1998-01-31 13:14:15'), '%a %b %c %D %d %H %i %M %m %S') | fields f",
        Object cell = firstRowFirstCell(response);
            oneRow() + "| eval a = cast('1677-09-21 00:12:44' as TIMESTAMP) | fields a",
        assertEquals("eval-derived date span must remain DATE-typed", "2004-04-01", cell);
        assertSchemaType(response, "date_span", "date");
    /** unix_timestamp(numeric YYYYMMDDhhmmss) parses the compact form. */
    }
    /** MAKEDATE with fractional and >365 day-of-year inputs. */
            oneRow() + "| eval f = datetime(datetime0, '+00:00') | fields f"
            oneRow() + "| eval f = time_format(cast('1985-10-09 12:00:00' as TIME), '%H:%i:%s') | fields f",
            oneRow()
            );
    public void testBoundary_minSupportedTimestamp() throws IOException {  
    public void testBoundary_maxSupportedTimestampMilli() throws IOException {
    /** WEEK(date, mode) — mode-arg overload resolves to a positive int. */  
    // Sub-second precision — microseconds round-trip without ms-truncation.
        );
    public void testTwoArgDatetimeColInput() throws IOException {  
        assertNotNull("μs-only fraction must be non-null post-fix", cell);  
    // swap the predicate for `OpenSearchTypeFactory.isDateExprType(type)` (already true for both  
    @SuppressWarnings("unchecked")
    /** Assert query returns exactly one cell of the given string value. */  
            oneRow() + "| eval a = timestampdiff(DAY, '2025-13-02', '2025-12-01') | fields a",
    /** Assert the schema entry for {@code colName} declares the given type. */
    /** microsecond on a varchar column resolves through the same string-overload arm. */  
        Object cell = firstRowFirstCell(response);
    public void testDaynameValidLiteral() throws IOException {
    public void testBoundary_maxSupportedDate() throws IOException {
    protected void onBeforeQuery() throws IOException {
    @Override
    }
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/sql/pull/<TBD>")
    public void testTimestampDateAndTimeArgs() throws IOException {  
    public void testUnixTimestampNumericLiteral() throws IOException {  
        );
        List<Object> list = (List<Object>) cell;  
    /** 2-arg DATETIME with column input resolves through the same overload. */
    }  
    private void assertFirstRowString(String ppl, String expected) throws IOException {
    /** HOUR(TIME('17:30:00')) literal-folds at plan time. */
        Map<String, Object> response = executePpl(
            "2023-10-01 12:00:00.123456"  
    }
    /** DATE_SUB(TIME, interval) overload resolves. */
        Object cell = firstRowOf(response, "time_span");
    public void testDatePartTimeSecond() throws IOException {
    public void testCastTimestampPreservesMicros() throws IOException {
                + "| eval a = date_format(cast('2023-10-01 12:00:00.123456' as TIMESTAMP), '%Y-%m-%d %H:%i:%s.%f') | fields a",
        );  
    /** FROM_UNIXTIME(epoch, format) 2-arg overload renders correctly. */  
    }
    }  
    /** cast(false AS string) literal form renders upper-case. */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            dataProvisioned = true;
    }  
            "12:00:00"
        assertNotNull("week(date, mode) must be non-null post-fix", cell);
    }
    }  
        Map<String, Object> response = executePpl(
        if (dataProvisioned == false) {  
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + body);
        );
    public void testStrToDatePercentB() throws IOException {
        assertEquals("minute bucket on time1='19:36:22' must be '19:36:00'", "19:36:00", cell);
import org.opensearch.client.ResponseException;
    // ─────────────────────────────────────────────────────────────────────────  
        assertNull("datetime('2004-02-28 23:00:00-10:00', null) must be NULL", firstRowOf(response, "d2"));  
    public void testTimestampDiffMonthApprox() throws IOException {
        } catch (ResponseException e) {  
        // Locale-independent subset of the deep-dive 23-token spec (drops %j/%P/%r/%T).
        Map<String, Object> response = executePpl(oneRow() + "| eval f = hour(time('17:30:45')) | fields f");
    /** date_format with the rich %a/%b/%c/%D/%H/%i token spec round-trips. */  
    public void testCastStringToDateRejects() throws IOException {
    }
    public void testBoundary_maxSupportedTime() throws IOException {
    public void testWeekModeArgOverload() throws IOException {
 */  
    public void testTwoArgDatetimeNullOperandsReturnNull() throws IOException {
    public void testDatePartTimeMinute() throws IOException {
            "source=" + DATASET.indexName + " | where key='key00' | stats count() by span(time1, 1h) as time_span"  
        assertSchemaType(response, "date_span", "date");  
        assertTrue("list(datetime0) must be a List, got " + cell, cell instanceof List);
        );  
 * {@code tests/parquet/a-date-time-failed/} and {@code tests/parquet/assertion-error-deep-dive/}.
    }  
    }
 * The OpenSearch Contributors require contributions made to  
    public void testSpanDateTypePreservesDate() throws IOException {  
    public void testDateAddOnTime() throws IOException {  
        assertEquals("second(TIME) must be 45", 45L, ((Number) firstRowFirstCell(response)).longValue());  
            "2007-12-31 16:00:00"
    }  
    public void testMicrosecondTimestampSixDigits() throws IOException {
        // Time-only DATE_ADD lifts to a date_add over today's date; pin the time-of-day suffix only.
        Object cell = firstRowOf(response, "time_span");  
        assertFirstRowString(  
        assertNull("out-of-range source tz must fold to NULL", firstRowFirstCell(response));
        assertErrorContains(oneRow() + "| eval a = cast('xxx' as TIME) | fields a", "xxx");
        return row.get(0);
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
    // ─────────────────────────────────────────────────────────────────────────  
    /** ADDDATE(TIMESTAMP, integer days) — promotes to TIMESTAMP wall time. */
    // Datetime stringification — space separator, no 1970-epoch prefix, boolean upper-case.
     * {@link org.opensearch.be.datafusion.ConvertTzAdapter} keeps the lowering well-typed when
                body = e.getMessage();
    /** date_format with %c %U %u %V %v emits zero-padded month + correct week numbering. */  
        );
    /** 2-arg DATETIME with named-zone string — schema only; value depends on TZ. */
    }  
        assertNotNull("sysdate(0) must be non-null post-fix", cell);
    /** now(0)/sysdate(0) FSP-arg overload resolves. Asserts type+nonnull only. */  
    // ─────────────────────────────────────────────────────────────────────────  
        assertErrorContains(
    }
    // ─────────────────────────────────────────────────────────────────────────  
        Map<String, Object> response = executePpl(oneRow() + "| eval f = second(time('17:30:45')) | fields f");
package org.opensearch.analytics.qa;
     * Mirrors {@code CalcitePPLBuiltinFunctionsNullIT.testDatetimeNullString}; the SAFE-cast in
        );
            oneRow() + "| eval f = date_format(str_to_date('1-May-13', '%d-%b-%y'), '%Y-%m-%d %H:%i:%s') | fields f",
        assertSchemaType(response, "time_span", "time");  
        Map<String, Object> response = executePpl(
        Map<String, Object> response = executePpl(oneRow() + "| eval f = week_of_year(date('2008-02-20')) | fields f");
        );
        Map<String, Object> response = executePpl(
            oneRow() + "| eval f = microsecond('2024-01-15 12:00:00.000001') | fields f"  
        assertFirstRowString(  
            "2200-01-01 00:00:00"  
        // unlike stock MySQL's no-leading-zero %c, so January → "01".
    /** DATETIME('2025-13-02') with bad date folds to NULL (single-arg form). */
        Object cell = firstRowFirstCell(response);
            "2013-05-01 00:00:00"
    public void testDateFormatRichSpec() throws IOException {
    public void testInvalidTimeSecond61() throws IOException {
            } catch (Exception ioe) {
        assertErrorContains(oneRow() + "| eval a = cast('xxx' as DATE) | fields a", "xxx");
    public void testDaynameBadStringRejects() throws IOException {
            "Sat Jan 01 31st 31 13 14 January 01 15"  
            654321L, ((Number) firstRowFirstCell(response)).longValue());  
    /** HOUR('99:99:99') rejects (was silent 200 returning 0 pre-fix). */
    }
    }
    // Boundary values — min/max supported date/time/timestamp.
    }
        assertFirstRowString(oneRow() + "| eval a = monthname('2020-08-26') | fields a", "August");  
    /** span(time, 1minute) returns TIME-typed bucket. */
    public void testFromUnixTimeWithFormat() throws IOException {
        );  
        Map<String, Object> response = executePpl(  
        // bool0 at key00 = true; PPL contract matches tostring(boolean) = uppercase.
                + "| eval n = nullif(key, key), t = nullif(key, key) "
        assertFirstRowString(
        );  
        try {
    // ─────────────────────────────────────────────────────────────────────────
    }  
    /** cast(boolean AS string) emits upper-case TRUE post-fix (CastToVarcharRewriter). */
            String body;
import java.util.Map;
    public void testWeekDefaultMode0() throws IOException {  
    public void testSpanCustomFormatDate() throws IOException {  
        assertFirstRowString(
                body.contains(expectedSubstring)  
    // ─────────────────────────────────────────────────────────────────────────
        Map<String, Object> response = executePpl(
        assertFirstRowString(
        assertFirstRowString(oneRow() + "| eval a = cast('0001-01-01' as DATE) | fields a", "0001-01-01");  
        assertEquals("timestampdiff(DAY,...) must be 30", 30L, ((Number) firstRowFirstCell(response)).longValue());
        Map<String, Object> response = executePpl(
    public void testTimestampAddBadLiteralRejects() throws IOException {
        // 2020-08-26 was a Wednesday.  
        assertEquals("list(datetime0) length", 1, list.size());
    public void testCastTimeFromDatetimeString() throws IOException {
        );  
        );  
    // TIMESTAMP composition + HOUR plan-time fold.
    /** WEEK_OF_YEAR(date) default mode 0 returns MySQL-style 7. */
    /** Assert the query rejects with HTTP 4xx and the response body contains {@code expectedSubstring}. */
    /** span(date, 1d) bucket renders as bare date, no '00:00:00' suffix. */
            oneRow() + "| eval f = microsecond('2024-01-15 12:00:00.123456') | fields f"
    public void testTwoArgDatetimeBoundsFoldsNull() throws IOException {
    public void testInvalidDateMonth13() throws IOException {
    private void assertSchemaType(Map<String, Object> response, String colName, String expectedType) {
                + "| fields d1, d2"
            "20:30:40 / 20:50:42"  
            oneRow() + "| eval d = date('2004-04-15') | stats count() by span(d, 1month) as date_span"
 *
    }
        );
    public void testAddDateIntegerDaysOnDate() throws IOException {
        assertNotNull("Response missing 'datarows'", rows);
        assertErrorContains(oneRow() + "| eval a = date('2025-13-02') | fields a", "2025-13-02");  
    public void testInvalidDatetimeFoldsNull() throws IOException {
    }  
    /** TIMESTAMP('2025-12-01 15:02:61') rejects with a format hint. */
    /** 2-arg DATETIME(literal, tz-literal) folds to a typed TIMESTAMP. */
        assertFirstRowString(
        assertEquals("timestampdiff(MONTH,...) over 6m14d must be 6", 6L, ((Number) firstRowFirstCell(response)).longValue());  
        assertErrorContains(oneRow() + "| eval a = cast('xxx' as TIMESTAMP) | fields a", "xxx");  
            oneRow() + "| eval a = cast('2262-04-11 23:47:16.854' as TIMESTAMP) | fields a",
            DatasetProvisioner.provision(client(), DATASET);
        Map<String, Object> response = executePpl(  
    /** TIMESTAMPADD standalone string-overload resolves. */  
        assertNotNull("date_span must be non-null", cell);  
    public void testSpanDateUnitMonth() throws IOException {  
    public void testMicrosecondOnVarcharColumn() throws IOException {
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
            oneRow()
    }
    }
        assertFirstRowString(  
    private Object firstRowOf(Map<String, Object> response, String colName) {
    }  
    public void testListFunctionTimestampUsesSpace() throws IOException {  
import java.io.IOException;  
 */  
        int idx = cols.indexOf(colName);  
}
        }  
    public void testMonthnameValidLiteral() throws IOException {
                + "| eval f = date_format(makedate(1945, 5.9), '%Y-%m-%d') + ' / ' + date_format(makedate(1984, 1984), '%Y-%m-%d') | fields f",  
    }  
    public void testConvertTzOutOfRangeFolds() throws IOException {  
        assertNotNull("Response missing 'schema'", schema);  
        );
        assertEquals("week(date('2008-02-20')) default mode 0 must be 7",
            oneRow() + "| eval f = date_format(timestampadd(YEAR, 1, '2024-01-15 12:00:00'), '%Y-%m-%d %H:%i:%s') | fields f",  
            oneRow() + "| eval f = date_format(date('2024-01-28'), '%c %U %u %V %v') | fields f",  
        Map<String, Object> response = executePpl(oneRow() + "| eval f = week(date('2008-02-20'), 1) | fields f");
    }  
    // the renderer's `instanceof DateOnlyType` check at AnalyticsExecutionEngine.java:236 misses,
            oneRow() + "| eval f = timestampdiff(DAY, '2024-01-01 00:00:00', '2024-01-31 00:00:00') | fields f"
        assertEquals("date_span must render as bare date", "1972-07-04", cell);
        assertSchemaType(response, "time_span", "time");
        Request request = new Request("POST", "/_plugins/_ppl");  
        assertSchemaType(response, "date_span", "date");  
    public void testTimestampDiffBadLiteralRejects() throws IOException {  
            "2020-08-29 00:00:00"
        assertErrorContains(oneRow() + "| eval a = time('16:00:61') | fields a", "16:00:61");
    // Helpers  
        // date0 at key00 = '2004-04-15'; time1 at key00 = '19:36:22'.
        assertFirstRowString(oneRow() + "| eval a = cast(bool0 as string) | fields a", "TRUE");
            oneRow() + "| eval f = time_format(date_add(time('09:00:00'), interval 1 hour), '%H:%i:%s') | fields f"  
            "source=" + DATASET.indexName + " | where key='key00' | stats list(datetime0) as l | head 1"
            "123456"
    /** Boundary: cast('0001-01-01' AS DATE) — ANSI-SQL min DATE round-trips. */
/**
        assertEquals("hour(TIME) must be 17", 17L, ((Number) firstRowFirstCell(response)).longValue());  
        Map<String, Object> response = executePpl(
        assertFirstRowString(
        assertSchemaType(response, "f", "timestamp");
    }  
            "2262-04-11 23:47:16.854"  
        Map<String, Object> response = executePpl(
    /** cast('1985-10-09 12:00:00' AS TIME) returns the time portion only. */
    }
    }  
    }  
    public void testBoundary_dateNanosNearYear2262Limit() throws IOException {
    }
        assertErrorContains(oneRow() + "| eval a = timestampadd(YEAR, 1, '2025-13-02') | fields a", "2025-13-02");
            "2004-04-15 19:36:22"
        assertEquals("Value mismatch for query: " + ppl, expected, cell);  
    @SuppressWarnings("unchecked")  
        assertFirstRowString(
    @SuppressWarnings("unchecked")  
    public void testCastStringToTimeRejects() throws IOException {  
    public void testNowFspVariant() throws IOException {
    /** MONTHNAME('2025-13-02') rejects at plan time with the format hint (no StreamException). */
    // ─────────────────────────────────────────────────────────────────────────
    public void testDateFormatPercentTokens() throws IOException {
    // ─────────────────────────────────────────────────────────────────────────
    /** convert_tz with out-of-range tz folds to NULL (not HTTP 400). */
        // 2024-01-28 — Sunday. Mode 0 (Sun-first): U=4, V=4. Mode 1 (Mon-first): u=4, v=4.
        Object cell = firstRowFirstCell(response);  
            oneRow() + "| eval f = unix_timestamp(20771122143845) | fields f"
        assertTrue("Expected at least one row", rows.size() >= 1);
        Object cell = firstRowFirstCell(response);
        Map<String, Object> response = executePpl(  
    // ─────────────────────────────────────────────────────────────────────────  
    private static boolean dataProvisioned = false;
        // makedate(1945, 5.9) → '1945-01-06' (FLOOR rounding); makedate(1984, 1984) → '1989-06-06'.  
        );
    // Format-token / mode / value-range — week modes, format tokens, MAKEDATE/MAKETIME, CAST.
        );  
    public void testSubDateIntegerDaysOnDate() throws IOException {
    public void testMakeDateFractionalDayOfYear() throws IOException {
        );
    // TIMESTAMPADD/DIFF standalone, DATE_PART(unit, TIME), 2-arg FROM_UNIXTIME.
        assertEquals("unix_timestamp(20771122143845) must equal 3404817525.0",
    /** Boundary: max supported TIMESTAMP at milli precision — just under the i64-ns epoch ceiling (2262-04-11). */
    public void testTwoArgDatetimeLiteralFold() throws IOException {  
            oneRow() + "| eval f = convert_tz('2024-01-15 12:00:00', '+15:00', '+00:00') | fields f"
        assertTrue("Expected at least one row, got " + rows.size(), rows.size() >= 1);
        assertTrue("week(date, 1) must be a positive integer", ((Number) cell).longValue() > 0);
        }  
    public void testMakeTimeFractional() throws IOException {  
            oneRow()
    }
        );  
        Object cell = firstRowFirstCell(response);  
        assertEquals("μs=1 must surface as 1, not 0", 1L, ((Number) cell).longValue());
        Map<String, Object> response = executePpl(oneRow() + "| eval f = minute(time('17:30:45')) | fields f");
        Map<String, Object> response = executePpl(oneRow() + "| eval f = week(date('2008-02-20')) | fields f");
    }
    /** str_to_date('1-May-13', '%d-%b-%y') resolves the %b month abbreviation. */  
        assertFirstRowString(  
    /** WEEK(date) default mode 0 returns MySQL-style 7 (not ISO 8). */
        assertFirstRowString(  
        assertEquals("date_add(time, +1h) wall time must be 10:00:00", "10:00:00", firstRowFirstCell(response));
    public void testBoundary_minSupportedTime() throws IOException {
        List<Object> list = (List<Object>) cell;  
    /** TIME('16:00:61') rejects with a format hint. */  
        assertEquals("hour(TIME('17:30:00')) must fold to 17", 17L,
    /** list(timestamp) preserves space separator (timestamp-element accumulator path). */
            oneRow() + "| eval f = datetime('2008-01-01 02:00:00', '+10:00') | fields f",  
     * arg0 is a typed-null string ({@code precision_timestamp(9)?} mismatch pre-fix). */  
            oneRow() + "| eval f = from_unixtime(1521467703, '%Y-%m-%d %H:%i:%s') | fields f",
    /** HOUR(TIME(...)) resolves through the DATE_PART(unit, TIME) overload. */  
    /** Boundary: cast('23:59:59.999999' AS TIME) — last-µs-of-day TIME round-trips. */  
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());  
    }
            "2025-13-02"  
        @SuppressWarnings("unchecked")
    }
    }
        assertFirstRowString(oneRow() + "| eval a = cast(true as string) | fields a", "TRUE");
    public void testMonthnameBadStringRejects() throws IOException {  
    }  
        assertFirstRowString(
    }
    }
        for (Map<String, Object> entry : schema) {
        assertNull("DATETIME('2025-13-02') must fold to NULL", cell);  
            123456L, ((Number) firstRowFirstCell(response)).longValue());
            "2004-07-09 10:17:35", list.get(0));
    /** 2-arg DATETIME with null string operands returns TIMESTAMP-typed null rows.  
            oneRow()
        );  
        );
                return;
        // calcs has no date_nanos field; the µs round-trip is the closest available gate.  
        );
        assertSchemaType(response, "d1", "timestamp");  
    }
        assertNotNull("Response missing 'datarows'", rows);  
            oneRow() + "| eval f = datetime('2008-01-01 02:00:00', 'America/Los_Angeles') | fields f"
            "2018-03-19 13:55:03"
            7L, ((Number) firstRowFirstCell(response)).longValue());  
    private Object firstRowFirstCell(Map<String, Object> response) {
        assertEquals("microsecond on varchar col must surface the 6-digit fraction",
        // nullif(x, x) → typed-null string, mirroring null `name` / `state` columns in the SQL fixture.
            oneRow() + "| eval f = datetime('2008-01-01 02:00:00', '+15:00') | fields f"  
        );
    }
/*  
            "1945-01-06 / 1989-06-06"
            oneRow() + "| eval f = time_format(date_sub(time('09:00:00'), interval 30 minute), '%H:%i:%s') | fields f"
    }
    // ExprDateType (the SQL plugin's DATE UDT), not just DateOnlyType. The eval-derived `date(...)`
        assertEquals("minute(TIME) must be 30", 30L, ((Number) firstRowFirstCell(response)).longValue());  
    // so the value comes back as "2004-04-01 00:00:00" instead of bare "2004-04-01". One-line fix:
    }
            "2020-09-17 17:30:00"  
    public void testHourOfTimeLiteralFold() throws IOException {  
    public void testSpanTimeTypePreservesTime() throws IOException {
    }  
    }
    private static final Dataset DATASET = new Dataset("calcs", "calcs");  
        );
 * exercises one query shape that previously failed; a regression here signals that one of the  
    public void testAddDateIntervalOnDate() throws IOException {
 * Regression gates for PPL date/time/timestamp coverage on the analytics-engine route. Each test
        assertEquals("list element must use space separator", "2004-07-09 10:17:35", list.get(0));
            oneRow() + "| eval f = subdate(date('2020-08-26'), 1) | fields f",  
        assertEquals("microsecond must be 123456 (6-digit, not ms-truncated)",  
        assertFirstRowString(oneRow() + "| eval a = cast('00:00:00' as TIME) | fields a", "00:00:00");  
        assertSchemaType(response, "d2", "timestamp");
    /** MAKETIME with integer and fractional H/M/S inputs. */
        );  
        return "source=" + DATASET.indexName + " | where key='key00' | head 1 ";
 * underlying fixes has been undone. Coverage shapes are sourced from
        assertEquals("col-input DATETIME with +00:00 must be identity", "2004-07-09 10:17:35", cell);  
            Response response = client().performRequest(request);  
            oneRow() + "| eval f = adddate(date('2020-08-26'), interval 3 day) | fields f",
        assertFirstRowString(
        // Pre-fix %b silently mapped to month=1; post-fix it parses 'May' = 5.
        );
    /** CAST('xxx' AS TIMESTAMP) rejects with a format hint. */
    // ─────────────────────────────────────────────────────────────────────────  
        Object cell = firstRowOf(response, "date_span");
                assertEquals("schema type for [" + colName + "]", expectedType, entry.get("type"));  
    }
        // Value is TZ-config-dependent; pin only the type contract — pre-fix this 400'd.
    // span() preserves bucket type for date / time inputs (5 tests)
                + "| eval d1 = DATETIME(n, '+10:00'), d2 = datetime('2004-02-28 23:00:00-10:00', t) "  
        List<Object> row = rows.get(0);  
    // ─────────────────────────────────────────────────────────────────────────  
    /** span over an eval-derived DATE expression preserves DATE typing. */  
    /** Pull the cell of column {@code colName} from row 0. */
    // produces ExprDateType, which SpanFunction.getReturnTypeInference forwards through the call;  
        fail("schema missing column [" + colName + "]");
            ((Number) firstRowFirstCell(response)).longValue());  
            "1677-09-21 00:12:44"  
        assertFirstRowString(oneRow() + "| eval a = dayname('2020-08-26') | fields a", "Wednesday");
    }
    // ─────────────────────────────────────────────────────────────────────────
        Map<String, Object> response = executePpl(
    // ─────────────────────────────────────────────────────────────────────────  
    }
        );  
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {
    /** TIMESTAMPDIFF(MONTH, ...) approximation rounds to whole months. */
            oneRow() + "| eval s = '2024-01-15 12:00:00.654321' | eval f = microsecond(s) | fields f"  
            "source=" + DATASET.indexName + " | stats count() as c by span(date1, 1month) as date_span | sort date_span | head 1"
            "2025-01-15 12:00:00"
    public void testInvalidTimestampSecond61() throws IOException {  
        assertErrorContains(oneRow() + "| eval a = dayname('2025-13-02') | fields a", "unsupported format");
    }
        List<Map<String, Object>> schema = (List<Map<String, Object>>) response.get("schema");
        assertFirstRowString(oneRow() + "| eval a = cast('9999-12-31' as DATE) | fields a", "9999-12-31");
        assertEquals("time bucket must omit the 1970-01-01 prefix", "19:00:00", cell);
        Map<String, Object> response = executePpl(
import org.opensearch.client.Response;  
        Map<String, Object> response = executePpl(  
        Map<String, Object> response = executePpl(
    /** DAYNAME with a valid date literal renders the full weekday name (positive path). */
    // ─────────────────────────────────────────────────────────────────────────  
            "source=" + DATASET.indexName + " | where key='key00' | stats count() by span(time1, 1minute) as time_span"
    // DateOnlyType and ExprDateType / stock DATE). Same for the TimeOnlyType branch below it.
        assertTrue("Row must have at least one cell", row.size() >= 1);
        );  
    /** Boundary: cast('00:00:00' AS TIME) — midnight TIME round-trips. */
        // Per CalciteDateTimeFunctionIT testUnixTimeStamp.ppl: 3404817525.0  
        );  
    }
    /** TIMESTAMPDIFF standalone string-overload resolves. */
        );
    public void testCastBooleanToStringUppercase() throws IOException {  
    }
        assertFirstRowString(oneRow() + "| eval a = cast(false as string) | fields a", "FALSE");  
            oneRow() + "| eval f = adddate(timestamp('2020-09-16 17:30:00'), 1) | fields f",
        );  
        assertFirstRowString(
    public void testSpanTimeUnitMinute() throws IOException {  
    }
        assertErrorContains(oneRow() + "| eval a = monthname('2025-13-02') | fields a", "unsupported format");
                + "| eval f = time_format(maketime(20, 30, 40), '%H:%i:%s') + ' / ' + time_format(maketime(20.2, 49.5, 42.1), '%H:%i:%s') | fields f",
    }
    public void testCastFalseLiteralToStringUppercase() throws IOException {
    public void testDatePartTimeHour() throws IOException {
        );  
    public void testTimestampAddStandalone() throws IOException {
    /** Boundary: min supported TIMESTAMP — engine rejects below the i64-ns epoch floor (1677-09-21 00:12:44). */
        Object cell = firstRowOf(response, "date_span");
    /** microsecond('… .123456') returns 123456, not 123000. */
        assertFirstRowString(
        Object cell = firstRowFirstCell(response);
        );
    }
    // ─────────────────────────────────────────────────────────────────────────
        assertEquals("month bucket must be a bare date string", "2004-04-01", cell);
        Map<String, Object> response = executePpl(oneRow() + "| eval f = hour(time('17:30:00')) | fields f");
    // Invalid string literals → HTTP 4xx with format hint (validation at plan time).
        // maketime(20, 30, 40) → '20:30:40'; maketime(20.2, 49.5, 42.1) → '20:50:42.x'.
        );
        assertErrorContains(oneRow() + "| eval a = hour('99:99:99') | fields a", "99:99:99");  
        List<String> cols = extractColumnNames(response);
        );
 * compatible open source license.
        @SuppressWarnings("unchecked")
            oneRow() + "| eval f = timestampdiff(MONTH, '2024-01-01 00:00:00', '2024-07-15 00:00:00') | fields f"
    /** CAST('xxx' AS DATE) rejects with a format hint. */  
        Map<String, Object> response = executePpl(oneRow() + "| eval a = datetime('2025-13-02') | fields a");
        Map<String, Object> response = executePpl(
import org.opensearch.client.Request;
    /** MONTHNAME with a valid date literal renders the full month name (positive path). */
    }  
    /** TIMESTAMPDIFF with a bad string literal rejects. */
            3404817525.0, ((Number) cell).doubleValue(), 0.5);
            oneRow() + "| eval f = date_format('2024-01-15 12:00:00.123456', '%f') | fields f",
    /** ADDDATE(DATE, integer days) lowers via DateAddSubAdapter integer-days form. */
        Object cell = firstRowOf(response, "date_span");
        );  
    /** MINUTE(TIME(...)) resolves through the DATE_PART(unit, TIME) overload. */  
    }
        );
    }  
            oneRow()
    public void testListFunctionDateUsesSpace() throws IOException {
    /** Boundary: cast('9999-12-31' AS DATE) — ANSI-SQL max DATE round-trips. */  
            assertTrue(
    // TODO(sql-plugin): broaden midnight-suffix strip in AnalyticsExecutionEngine#convert to recognise
        // Single-arg DATETIME's contract on this branch is NULL fold (vs. throw for DATE/TIME/TIMESTAMP).  
    }
    public void testAddDateIntegerDaysOnTimestamp() throws IOException {  
    /** ADDDATE(DATE, INTERVAL n DAY) — interval form sharing the DATE_ADD path. */
    public void testTwoArgDatetimeNamedZone() throws IOException {  
        // %c on the PPL/AE route maps to "MM" (zero-padded) per DateTimeFormatterUtil.DATE_HANDLERS,  
    /** span(date, 1month) preserves date type, bucket on month boundary. */
            "2020-08-25"
    }  
        assertFirstRowString(  
        assertFirstRowString(  
        );
        );
            7L, ((Number) firstRowFirstCell(response)).longValue());  
        assertTrue("schema missing column [" + colName + "], got " + cols, idx >= 0);
    /** span(time, 1h) returns TIME-typed bucket, no '1970-01-01' prefix. */  
        assertFirstRowString(oneRow() + "| eval a = cast('23:59:59.999999' as TIME) | fields a", "23:59:59.999999");
        // Bare date string contract — pre-fix this rendered '2004-04-15 00:00:00'.
    /** list(date) renders with space separator, not 'T'. */
    public void testDateSubOnTime() throws IOException {  
        assertEquals("ISO-T separator must not appear in stringified timestamp",
    /** SUBDATE(DATE, integer days) — sign folded by adapter. */  
    // Function overload resolution — 2-arg DATETIME, FSP variants, TIME args, ADDDATE/SUBDATE,
        assertNotNull("unix_timestamp on YYYYMMDDhhmmss numeric must be non-null post-fix", cell);
    /** DATE_ADD(TIME, interval) overload resolves. */
    // ─────────────────────────────────────────────────────────────────────────
            oneRow() + "| eval f = date_format(timestamp(date0, time1), '%Y-%m-%d %H:%i:%s') | fields f",  
    public void testCastStringToTimestampRejects() throws IOException {
    }  
        return rows.get(0).get(idx);
            if (colName.equals(entry.get("name"))) {
        assertFirstRowString(  
    /** TIMESTAMPADD with a bad string literal rejects. */  
    }
        // time1 = '19:36:22' → 1h-bucket = '19:00:00'. Pre-fix this carried a 1970 prefix.
    }  
    // ─────────────────────────────────────────────────────────────────────────
        assertSchemaType(response, "f", "timestamp");
            "source=" + DATASET.indexName + " | where key='key00' | stats list(datetime0) as l"
        assertErrorContains(oneRow() + "| eval a = timestamp('2025-12-01 15:02:61') | fields a", "2025-12-01 15:02:61");
        Map<String, Object> response = executePpl(
    public void testTimestampDiffStandalone() throws IOException {  
    /** μs=1 fraction surfaces as 1 (not zeroed by ms-truncation). */  
            "2020-08-27"
        );
    /** DATE('2025-13-02') rejects with a format hint. */
    public void testCastTrueLiteralToStringUppercase() throws IOException {  
        // datetime0 at key00 = 2004-07-09T10:17:35Z; +00:00 is identity.
    public void testHourBadStringRejects() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
        Map<String, Object> response = executePpl(oneRow() + "| eval f = sysdate(0) | fields f");
            "source=" + DATASET.indexName + " | stats count() as c by span(date0, 1d) as date_span | sort date_span | head 1"
