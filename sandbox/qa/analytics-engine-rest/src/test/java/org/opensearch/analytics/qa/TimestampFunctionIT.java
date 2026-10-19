    public void testShapeETwoArgAddsTime() throws IOException {  
    public void testShapeFColumnRefRoutesToToTimestamp() throws IOException {  
    /** TIME = TIMESTAMP — same time-of-day on today's date holds. */
        // bad input verbatim. Pin this contract — the SQL plugin's tests rely on it.  
 *
            oneRow("key00") + "| eval v = date_format(timestamp('2020-01-01T10:30:00Z'), '%Y-%m-%d %H:%i:%s') | fields v",
 *
        assertErrorContains(
    /** TIME = DATE — today-anchored midnight is not 2004-07-09. */
/**
        );
        try {  
            "2024-01-01 04:30:00"
            try {  
        if (dataProvisioned == false) {
            oneRow("key00") + "| eval v = time('10:20:30') = timestamp('" + today + " 10:20:30') | fields v"
}
        );
    private void assertFirstRowString(String ppl, String expected) throws IOException {
    // ── Shape A: TIMESTAMP('<varchar literal>') ──────────────────────────────────
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    }
        );
        // fold path emitted a typed TIMESTAMP literal whose date is today's UTC date  
    private String oneRow(String key) {
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
        );
 *       through to {@code DateTimeAdapters.DatetimeAdapter} ({@code to_timestamp} identity)</li>  
        Object cell = firstRowFirstCell(  
            oneRow("key00") + "| eval v = timestamp('3077-04-12 09:07:00') | fields v",  
        );
    public void testTimeEqualsDate() throws IOException {
            dataProvisioned = true;  
        assertEquals(Boolean.TRUE, cell);
 *   <li>D — {@code TIMESTAMP(TIMESTAMP('<lit>'))} → inner shape A folds, outer falls
                body = e.getMessage();  
 */
            oneRow("key00") + "| eval v = date_format(timestamp('2024-01-15T10:30:00'), '%Y-%m-%d %H:%i:%s') | fields v",  
    public void testShapeGUnparseableSecondSixtyOneRejects() throws IOException {
    }
    }  
    public void testYearAfter2262RejectsAtPlanTime() throws IOException {
        // -05:00 offset → wall time shifts forward 5h to UTC.  
    }
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
 * SPDX-License-Identifier: Apache-2.0
        assertFirstRowString(
        );
 * fall-through routing so regressions surface as user-facing failures.  
            "2020-01-02 01:30:00"  
        assertFirstRowString(
 * The OpenSearch Contributors require contributions made to  
            "2025-13-02"  
            "outside the supported range"
            } catch (Exception ioe) {
import java.util.Map;  
            oneRow("key00") + "| eval v = date_format(timestamp('2024-01-01'), '%Y-%m-%d %H:%i:%s') | fields v",
    }
        );
        } catch (ResponseException e) {
 * function to_timestamp}); this IT pins both the fold-correct cases and the
        Object cell = firstRowFirstCell(
 * corresponds to a branch in the adapter's {@code tryFoldLiteral} / dispatch path:
    public void testShapeDNestedTimestampOfTimestampLiteral() throws IOException {
import org.opensearch.client.Request;
        String today = LocalDate.now(ZoneOffset.UTC).toString();
 *   <li>B — {@code TIMESTAMP(DATE('<lit>'))} → fold to date.atStartOfDay(UTC)</li>  
        // the day boundary instead of clamping to 24:00.
            oneRow("key00")  
    public void testShapeETwoArgAcrossMidnight() throws IOException {  
    }  
import java.io.IOException;
        assertEquals(Boolean.TRUE, cell);
    // ── Shape B: TIMESTAMP(DATE('<lit>')) → fold to midnight UTC ─────────────────
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 * compatible open source license.
            "2004-04-15 00:00:00"  
    // ── Shape C: TIMESTAMP(TIME('<lit>')) → fold with today's UTC date ───────────
    // ── Shape D: TIMESTAMP(TIMESTAMP('<lit>')) → inner folds, outer is identity ──  
            oneRow("key00")  
            "2020-01-01 11:30:00"
    }
    }
    }
            oneRow("key00") + "| eval v = date_format(timestamp(date('2020-08-26')), '%Y-%m-%d %H:%i:%s') | fields v",
 *   <li>F — {@code TIMESTAMP(<column>)} → falls through to DatetimeAdapter</li>
    /** TIMESTAMP != TIME — opposite direction. */
                + "| eval v = date_format(timestamp('2020-01-01 10:00:00', '01:30:00'), '%Y-%m-%d %H:%i:%s') | fields v",
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,  
        );
        );  
        }
 */  
        // Operand is a column ref, not a literal — fold doesn't catch. Adapter renames
        String today = LocalDate.now(ZoneOffset.UTC).toString();  
        // which renames to {@code to_timestamp} (DataFusion treats this as identity).
    public void testShapeASpaceSeparator() throws IOException {
 * </ul>
        // Without this guard, DataFusion's simplify_expressions widens TIMESTAMP(3) → ns
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
    // ── Shape F: TIMESTAMP(<column>) → falls through to DatetimeAdapter ──────────
    private static boolean dataProvisioned = false;  
        assertFirstRowString(  
        // 23:00 + 02:30 = 01:30 next day. Validates LocalDateTime.plusNanos crosses
            Response response = client().performRequest(request);
    public void testShapeGUnparseableMonthThirteenRejects() throws IOException {  
        assertFirstRowString(
        }  
    }
        assertFirstRowString(
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(Boolean.TRUE, cell);  
        Object cell = firstRowFirstCell(
        // via *1000 and the optimizer emits an opaque "Arrow error: Arithmetic overflow"  
    }  
package org.opensearch.analytics.qa;
            oneRow("key00") + "| eval v = date_format(timestamp('2024-01-01T10:00:00-05:00'), '%Y-%m-%d %H:%i:%s') | fields v",
public class TimestampFunctionIT extends AnalyticsRestTestCase {
    public void testTimestampNotEqualsTime() throws IOException {
        assertFirstRowString(
import java.time.LocalDate;  
        return rows.get(0).get(0);
        Request request = new Request("POST", "/_plugins/_ppl");
    public void testShapeADateOnly() throws IOException {
 * End-to-end coverage for PPL {@code TIMESTAMP(...)} call shapes routed through  
        assertEquals(Boolean.FALSE, cell);
            oneRow("key00") + "| eval v = timestamp('2025-12-01 15:02:61') | fields v",  
        assertFirstRowString(
        // sees a TIMESTAMP-typed operand (not VARCHAR), falls through to DatetimeAdapter
            "2020-08-26 00:00:00"  
            "2004-07-09 10:17:35"  
                + "| eval v = date_format(timestamp(timestamp('2020-01-01 00:00:00')), '%Y-%m-%d %H:%i:%s') | fields v",
        assertFirstRowString(
            oneRow("key00") + "| eval v = date_format(timestamp('2024-01-01T10:00:00+05:30'), '%Y-%m-%d %H:%i:%s') | fields v",  
        // (year(v) >= 2020) AND time_format(v) == '10:20:30'. The combination pins the
        @SuppressWarnings("unchecked")
            today + " 10:20:30"
    public void testFoldedTimestampLiteralsRemainComparable() throws IOException {
    public void testDateLessThanTime() throws IOException {
    // ── Shape E: TIMESTAMP('<dt>', '<time>') → 2-arg fold, adds time-of-day ──────
    protected void onBeforeQuery() throws IOException {  
        // and whose time is the parsed input.
                + "| eval neq2 = (timestamp('1984-12-15 22:15:08') != timestamp('1984-12-15 22:15:07')) | fields neq2"
    }  
    // ── helpers ──────────────────────────────────────────────────────────────────  
    public void testShapeANegativeTimezoneOffset() throws IOException {
            );
        assertFirstRowString(
        );
    public void testShapeAIsoWithTAndZ() throws IOException {
        // Inner TIMESTAMP('lit') folds to a typed TIMESTAMP literal; outer TIMESTAMP(...)  
            oneRow("key00") + "| eval v = timestamp('2025-13-02') | fields v",
    // ── Shape F-DATE: TIMESTAMP(<date column>) lifts via native CAST, not to_timestamp ──  
    }
            Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
            oneRow("key00") + "| eval v = date_format(timestamp(time('10:20:30')), '%Y-%m-%d %H:%i:%s') | fields v",
    }  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = date('2020-09-16') < time('09:07:00') | fields v");  
    public void testShapeFDateColumnLiftsToTimestamp() throws IOException {
        assertFirstRowString(
    public void testShapeATimezoneOffsetNormalizesToUtc() throws IOException {  
import java.util.List;
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = time('00:00:00') = date('2004-07-09') | fields v");  
    }
            DatasetProvisioner.provision(client(), DATASET);
            "2020-01-01 00:00:00"  
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {  
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
            oneRow("key00") + "| eval v = timestamp('1984-12-15 10:20:30') != time('10:20:30') | fields v"
                + "| eval v = date_format(timestamp('2020-01-01 23:00:00', '02:30:00'), '%Y-%m-%d %H:%i:%s') | fields v",
        // exception message; the REST layer surfaces this as HTTP 400 carrying the
    }
            }
        Map<String, Object> response = executePpl(ppl);  
        );
import org.opensearch.client.Response;
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);  
        // at execution. The adapter rejects up front with "outside the supported range".
        assertErrorContains(
 * {@code org.opensearch.be.datafusion.TimestampFunctionAdapter}. Each shape below
        // date0 at key00 → 2004-04-15; midnight UTC.  
 * DataFusion can't execute on this stack ({@code Unsupported data type Date32 for
    }
            oneRow("key00") + "| eval v = date_format(timestamp(date0), '%Y-%m-%d %H:%i:%s') | fields v",
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + body);  
        assertFirstRowString(  
            oneRow("key00") + "| eval v = date_format(timestamp(datetime0), '%Y-%m-%d %H:%i:%s') | fields v",
 * <ul>
    // ── Comparison parity with SQL plugin's DateTimeComparisonIT.neq2 case ───────
 * <p>The fold path bypasses runtime {@code to_timestamp(to_date(...))} chains that  
    /** {@code DATE < TIME} — TIME lifts to today-anchored TIMESTAMP, so a past DATE is less than today. */
    }
    private Object firstRowFirstCell(String ppl) throws IOException {
    // ── TIME-vs-{DATE,TIMESTAMP} comparison routes through ComparisonTemporalCoercionAdapter ──
                body.contains(expectedSubstring)
 *   <li>E — {@code TIMESTAMP('<dt>', '<time>')} → 2-arg fold, adds time-of-day</li>
        );
 *   <li>G — {@code TIMESTAMP('<bad>')} → IllegalArgumentException with raw input</li>  
 *   <li>C — {@code TIMESTAMP(TIME('<lit>'))} → fold with today's UTC date</li>
        // ISO-8601 with T separator + Z — parseTimestamp normalizes to UTC.  
    // ── i64-ns range guard (year > 2262 rejects at plan time) ────────────────────
        // parseTimestamp throws IllegalArgumentException with the raw input as the
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
        assertFirstRowString(  
        assertErrorContains(
            oneRow("key00") + "| eval v = date_format(timestamp('2020-01-01 10:30:45'), '%Y-%m-%d %H:%i:%s') | fields v",  
    @Override
        );
        );  
        // Matches legacy TimestampFunction.timestamp(props, dt, addTime) → exprAddTime.
    public void testShapeAIsoWithTNoZ() throws IOException {
import java.time.ZoneOffset;
        // Today's date varies, so we extract the time-of-day component and assert that
    public void testTimeEqualsTimestampSameTimeOfDay() throws IOException {
        );
        // datetime0 is a date-typed field on the calcs dataset (key00 = 2004-07-09T10:17:35Z).
        Object cell = firstRowFirstCell(ppl);  
        // to {@code to_timestamp} which DataFusion executes against the column value.  
    }
    }
    // Pre-fix every shape failed plan-time with "Unable to convert call to_timestamp(precision_time<9>?)".
        );
        );  
            oneRow("key00")
    }
            oneRow("key00")
        assertFirstRowString(  
    // ── Shape G: TIMESTAMP('<bad string>') → HTTP 400 with raw input as message ──
            "2024-01-01 00:00:00"
import org.opensearch.client.ResponseException;  
 *  
    public void testShapeCTimeLiteralFoldsWithTodayUtc() throws IOException {  
            "2025-12-01 15:02:61"
        // +05:30 offset → wall time shifts back 5h30m to UTC.
        );  
    }  
    public void testShapeBDateLiteralFoldsToMidnightUtc() throws IOException {  
            "2020-01-01 10:30:00"  
        );
 *   <li>A — {@code TIMESTAMP('<varchar literal>')} → plan-time fold</li>
        assertEquals("neq2 between adjacent-second TIMESTAMP literals must be true", Boolean.TRUE, cell);  
    }
            "2024-01-01 15:00:00"  
    }  
            "2020-01-01 10:30:45"
    }  
            String body;
/*  
            assertTrue(
    }
            "2024-01-15 10:30:00"
