    // ── helpers ──────────────────────────────────────────────────────────────────
            } catch (Exception ioe) {
 *
    public void testShapeAIsoWithTNoZ() throws IOException {
                body = e.getMessage();
    // ── Shape B: TIMESTAMP(DATE('<lit>')) → fold to midnight UTC ─────────────────
import org.opensearch.client.Request;
            oneRow("key00")
    public void testShapeGUnparseableMonthThirteenRejects() throws IOException {
        // the day boundary instead of clamping to 24:00.
        Object cell = firstRowFirstCell(
    public void testTimestampNotEqualsTime() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    private void assertErrorContains(String ppl, String expectedSubstring) throws IOException {
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
        );
    }
    // ── Shape C: TIMESTAMP(TIME('<lit>')) → fold with today's UTC date ───────────
    public void testShapeFColumnRefRoutesToToTimestamp() throws IOException {
                + "| eval v = date_format(timestamp('2020-01-01 10:00:00', '01:30:00'), '%Y-%m-%d %H:%i:%s') | fields v",
        );
 */
        );
            oneRow("key00") + "| eval v = date_format(timestamp('2020-01-01T10:30:00Z'), '%Y-%m-%d %H:%i:%s') | fields v",
 * compatible open source license.
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
    }
    }
                + "| eval v = date_format(timestamp(timestamp('2020-01-01 00:00:00')), '%Y-%m-%d %H:%i:%s') | fields v",
    protected void onBeforeQuery() throws IOException {
        assertFirstRowString(
    /** TIME = TIMESTAMP — same time-of-day on today's date holds. */
            oneRow("key00")
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        // -05:00 offset → wall time shifts forward 5h to UTC.
 * The OpenSearch Contributors require contributions made to
 *       through to {@code DateTimeAdapters.DatetimeAdapter} ({@code to_timestamp} identity)</li>
            oneRow("key00")
        // (year(v) >= 2020) AND time_format(v) == '10:20:30'. The combination pins the
            oneRow("key00") + "| eval v = timestamp('1984-12-15 10:20:30') != time('10:20:30') | fields v"
import org.opensearch.client.Response;
 *   <li>C — {@code TIMESTAMP(TIME('<lit>'))} → fold with today's UTC date</li>
import java.util.Map;
            oneRow("key00") + "| eval v = timestamp('3077-04-12 09:07:00') | fields v",
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        assertFirstRowString(
        assertFirstRowString(
    private void assertFirstRowString(String ppl, String expected) throws IOException {
                + "| eval neq2 = (timestamp('1984-12-15 22:15:08') != timestamp('1984-12-15 22:15:07')) | fields neq2"
 * fall-through routing so regressions surface as user-facing failures.
    // ── Shape G: TIMESTAMP('<bad string>') → HTTP 400 with raw input as message ──
    private String oneRow(String key) {
    }
        return rows.get(0).get(0);
        );
    }
            oneRow("key00") + "| eval v = timestamp('2025-12-01 15:02:61') | fields v",
        assertErrorContains(
        assertFirstRowString(
    }
    /** TIMESTAMP != TIME — opposite direction. */
    // ── Shape F: TIMESTAMP(<column>) → falls through to DatetimeAdapter ──────────
        }
 * corresponds to a branch in the adapter's {@code tryFoldLiteral} / dispatch path:
            oneRow("key00") + "| eval v = date_format(timestamp('2024-01-15T10:30:00'), '%Y-%m-%d %H:%i:%s') | fields v",
        );
        assertEquals(Boolean.TRUE, cell);
        // parseTimestamp throws IllegalArgumentException with the raw input as the
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
 * <p>The fold path bypasses runtime {@code to_timestamp(to_date(...))} chains that
    public void testShapeATimezoneOffsetNormalizesToUtc() throws IOException {
            oneRow("key00") + "| eval v = date_format(timestamp('2020-01-01 10:30:45'), '%Y-%m-%d %H:%i:%s') | fields v",
}
 * <ul>
 *   <li>G — {@code TIMESTAMP('<bad>')} → IllegalArgumentException with raw input</li>
        );
    // ── Shape E: TIMESTAMP('<dt>', '<time>') → 2-arg fold, adds time-of-day ──────
        );
            oneRow("key00") + "| eval v = date_format(timestamp('2024-01-01'), '%Y-%m-%d %H:%i:%s') | fields v",
        // to {@code to_timestamp} which DataFusion executes against the column value.
        assertFirstRowString(
        // Operand is a column ref, not a literal — fold doesn't catch. Adapter renames
        try {
            String body;
        assertErrorContains(
import org.opensearch.client.ResponseException;
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = date('2020-09-16') < time('09:07:00') | fields v");
    }
 *   <li>A — {@code TIMESTAMP('<varchar literal>')} → plan-time fold</li>
            today + " 10:20:30"
        assertEquals(Boolean.FALSE, cell);
        );
    }
            "2020-08-26 00:00:00"
        @SuppressWarnings("unchecked")
        // fold path emitted a typed TIMESTAMP literal whose date is today's UTC date
 * </ul>
            "2025-12-01 15:02:61"
        // Today's date varies, so we extract the time-of-day component and assert that
        } catch (ResponseException e) {
/*
        );
        // 23:00 + 02:30 = 01:30 next day. Validates LocalDateTime.plusNanos crosses
 */
            );
            "2020-01-01 10:30:45"
            dataProvisioned = true;
    public void testShapeGUnparseableSecondSixtyOneRejects() throws IOException {
            "2020-01-02 01:30:00"
        Object cell = firstRowFirstCell(
        // via *1000 and the optimizer emits an opaque "Arrow error: Arithmetic overflow"
    /** {@code DATE < TIME} — TIME lifts to today-anchored TIMESTAMP, so a past DATE is less than today. */
 * this file be licensed under the Apache-2.0 license or a
        );
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
        );
        assertErrorContains(
            "2020-01-01 00:00:00"
            oneRow("key00") + "| eval v = date_format(timestamp(time('10:20:30')), '%Y-%m-%d %H:%i:%s') | fields v",
    // ── Comparison parity with SQL plugin's DateTimeComparisonIT.neq2 case ───────
        // at execution. The adapter rejects up front with "outside the supported range".
        Object cell = firstRowFirstCell(
            oneRow("key00") + "| eval v = date_format(timestamp('2024-01-01T10:00:00-05:00'), '%Y-%m-%d %H:%i:%s') | fields v",
import java.time.LocalDate;
 *
    public void testTimeEqualsDate() throws IOException {
import java.io.IOException;
        assertFirstRowString(
            assertTrue(
        );
        assertFirstRowString(
    }
            }
        String today = LocalDate.now(ZoneOffset.UTC).toString();
    }
    }
    public void testShapeAIsoWithTAndZ() throws IOException {
        // and whose time is the parsed input.
        // datetime0 is a date-typed field on the calcs dataset (key00 = 2004-07-09T10:17:35Z).
            oneRow("key00")
    // Pre-fix every shape failed plan-time with "Unable to convert call to_timestamp(precision_time<9>?)".
import java.time.ZoneOffset;
            Response response = client().performRequest(request);
    }
            "2024-01-01 15:00:00"
 *   <li>D — {@code TIMESTAMP(TIMESTAMP('<lit>'))} → inner shape A folds, outer falls
        // which renames to {@code to_timestamp} (DataFusion treats this as identity).
    }
        // Inner TIMESTAMP('lit') folds to a typed TIMESTAMP literal; outer TIMESTAMP(...)
 *   <li>E — {@code TIMESTAMP('<dt>', '<time>')} → 2-arg fold, adds time-of-day</li>
    public void testDateLessThanTime() throws IOException {
        // +05:30 offset → wall time shifts back 5h30m to UTC.
        assertEquals(Boolean.TRUE, cell);
 *
                + "| eval v = date_format(timestamp('2020-01-01 23:00:00', '02:30:00'), '%Y-%m-%d %H:%i:%s') | fields v",
        );
    /** TIME = DATE — today-anchored midnight is not 2004-07-09. */
            oneRow("key00") + "| eval v = timestamp('2025-13-02') | fields v",
 *   <li>B — {@code TIMESTAMP(DATE('<lit>'))} → fold to date.atStartOfDay(UTC)</li>
            "2020-01-01 10:30:00"
        // exception message; the REST layer surfaces this as HTTP 400 carrying the
        assertFirstRowString(
            oneRow("key00") + "| eval v = date_format(timestamp(date('2020-08-26')), '%Y-%m-%d %H:%i:%s') | fields v",
            try {
        // sees a TIMESTAMP-typed operand (not VARCHAR), falls through to DatetimeAdapter
    private Object firstRowFirstCell(String ppl) throws IOException {
    // ── Shape A: TIMESTAMP('<varchar literal>') ──────────────────────────────────
    private static boolean dataProvisioned = false;
    public void testShapeETwoArgAcrossMidnight() throws IOException {
        // ISO-8601 with T separator + Z — parseTimestamp normalizes to UTC.
        );
        assertFirstRowString(
        assertEquals("neq2 between adjacent-second TIMESTAMP literals must be true", Boolean.TRUE, cell);
        // Matches legacy TimestampFunction.timestamp(props, dt, addTime) → exprAddTime.
 * function to_timestamp}); this IT pins both the fold-correct cases and the
    }
            oneRow("key00") + "| eval v = time('10:20:30') = timestamp('" + today + " 10:20:30') | fields v"
        );
        // bad input verbatim. Pin this contract — the SQL plugin's tests rely on it.
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = time('00:00:00') = date('2004-07-09') | fields v");
    // ── TIME-vs-{DATE,TIMESTAMP} comparison routes through ComparisonTemporalCoercionAdapter ──
        // date0 at key00 → 2004-04-15; midnight UTC.
    }
 *   <li>F — {@code TIMESTAMP(<column>)} → falls through to DatetimeAdapter</li>
            "2004-07-09 10:17:35"
        assertFirstRowString(
    public void testShapeANegativeTimezoneOffset() throws IOException {
    public void testShapeFDateColumnLiftsToTimestamp() throws IOException {
        );
    public void testFoldedTimestampLiteralsRemainComparable() throws IOException {
    public void testShapeBDateLiteralFoldsToMidnightUtc() throws IOException {
            "outside the supported range"
    }
            "2020-01-01 11:30:00"
        assertFirstRowString(
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    }
    public void testShapeETwoArgAddsTime() throws IOException {
    }
import java.util.List;
        // Without this guard, DataFusion's simplify_expressions widens TIMESTAMP(3) → ns
        if (dataProvisioned == false) {
    }
    public void testShapeASpaceSeparator() throws IOException {
    public void testShapeCTimeLiteralFoldsWithTodayUtc() throws IOException {
            oneRow("key00") + "| eval v = date_format(timestamp('2024-01-01T10:00:00+05:30'), '%Y-%m-%d %H:%i:%s') | fields v",
    }
        Map<String, Object> response = executePpl(ppl);
    // ── Shape D: TIMESTAMP(TIMESTAMP('<lit>')) → inner folds, outer is identity ──
    }
        );
            Map<String, Object> body = assertOkAndParse(response, "PPL: " + ppl);
 * End-to-end coverage for PPL {@code TIMESTAMP(...)} call shapes routed through
        assertEquals(Boolean.TRUE, cell);
    }
        assertFirstRowString(
public class TimestampFunctionIT extends AnalyticsRestTestCase {
        Request request = new Request("POST", "/_plugins/_ppl");
            DatasetProvisioner.provision(client(), DATASET);
            "2025-13-02"
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
    @Override
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + body);
    public void testShapeADateOnly() throws IOException {
    }
/**
        Object cell = firstRowFirstCell(ppl);
        );
        );
            "2024-01-01 00:00:00"
            "2004-04-15 00:00:00"
    public void testTimeEqualsTimestampSameTimeOfDay() throws IOException {
    // ── i64-ns range guard (year > 2262 rejects at plan time) ────────────────────
package org.opensearch.analytics.qa;
        assertFirstRowString(
    }
    public void testShapeDNestedTimestampOfTimestampLiteral() throws IOException {
    }
    public void testYearAfter2262RejectsAtPlanTime() throws IOException {
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
 * DataFusion can't execute on this stack ({@code Unsupported data type Date32 for
            "2024-01-15 10:30:00"
        String today = LocalDate.now(ZoneOffset.UTC).toString();
 * {@code org.opensearch.be.datafusion.TimestampFunctionAdapter}. Each shape below
        }
            oneRow("key00") + "| eval v = date_format(timestamp(date0), '%Y-%m-%d %H:%i:%s') | fields v",
            "2024-01-01 04:30:00"
            oneRow("key00") + "| eval v = date_format(timestamp(datetime0), '%Y-%m-%d %H:%i:%s') | fields v",
    }
        request.setJsonEntity("{\"query\": \"" + escapeJson(ppl) + "\"}");
    // ── Shape F-DATE: TIMESTAMP(<date column>) lifts via native CAST, not to_timestamp ──
                body.contains(expectedSubstring)
