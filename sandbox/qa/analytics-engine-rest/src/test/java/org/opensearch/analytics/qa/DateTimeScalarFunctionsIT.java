    /** ADDTIME(timestamp, time) crossing midnight rolls the date forward (matches legacy SQL). */
        );  
    // subquery body and constant-folds the PPL TIMESTAMP(varchar) wrapper around the date literal
    private void assertFirstRowLong(String ppl, long expected) throws IOException {
    // comparison adapter does for >=.
    /** YEARWEEK on a TIMESTAMP column (not literal) exercises the os_yearweek column path. */
        }
    /**
            "2004-04-22"
}
    // %D ordinal day — proves shared mysql_format token table reachable via date_format.
                + " and datetime0 < date_add(date('2004-01-01'), interval 1 year) | stats count() as c",
        assertFirstRowLong(oneRow("key00") + "| eval d = period_diff(202612, 202601) | fields d", 11L);
    // date_add inside a WHERE predicate — the TPC-H q1/q4 shape that surfaced the gap.
        assertFirstRowString(
    // ToTypeString gap as time(expr); Time64(Microsecond) return has no working  
        // datetime0 at key00 == 2004-07-09 10:17:35; +1 day preserves the time-of-day.  
        assertFirstRowString(
    public void testAddDateIntervalHourOnTimestamp() throws IOException {  
    // which DateAddSubAdapter rejected ("Unable to convert call DATE_ADD(string?, interval_year)")
     * Sub-ms input ({@code .123456}) preserves all 6 µs digits — the TimestampFunctionAdapter
            oneRow("key00") + "| eval v = strftime(1521467703, '%a, %b %d, %Y %I:%M:%S %p %Z') | fields v",
 */
                + " | where datetime0 >= date('2004-01-01')"  
    }
            "2004-08-08 10:17:35"
        assertFirstRowString(
    }  
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek('1899-12-30', 4) | fields y", 189_952L);
            "2018-03-19 13:55:03.123"
    }
            oneRow("key00")
    public void testDateAddDayIntervalOnDateLiteral() throws IOException {
        assertFirstRowString(
        // Use a TIMESTAMP literal so the operand-typing path matches the dataset use.
     * branch — distinct from the literal-time branch covered by {@link #testAddTimeCrossesMidnight}.  
    /**
    public void testSubTimeWrapsToPreviousDay() throws IOException {  
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);  
        assertFirstRowLong(oneRow("key00") + "| eval v = minute_of_day(timestamp('2020-09-16 17:30:00')) | fields v", 1050L);  
            "2008-09-20 06:35:13"  
    }
        assertFirstRowLong(
        );
    public void testAddTimeTimestampPlusTimeColumn() throws IOException {
     */
    // ── DATE_ADD / DATE_SUB → DateAddSubAdapter (DATETIME_PLUS lowering) ──────────
    public void testStrftimeOnDateField() throws IOException {
        );
            oneRow("key00") + "| eval v = strftime(1521467703123, '%Y-%m-%d %H:%M:%S') | fields v",
    public void testYearweekModeArgChangesResult() throws IOException {
            17L
        );
/*  
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek('1899-12-30') | fields y", 189_952L);  
        );
    public void testDateOnTimestampFieldMonth() throws IOException {  
        );
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
            "2017-10-23 00:00:00"  
            "2017-10-23 00:00:00"  
                + "| eval v = date_format(datetime0, '%Y-%m-%d') | fields v",
    /** SUBDATE shares DATE_SUB's lowering — INTERVAL form on a DATE column. */
import java.util.Map;
    /** STR_TO_DATE accepts %h="00" zero-hour 12-hour-clock input. */
     * operand to TIMESTAMP for the two date_part calls. Reference: DateTimeFunctionIT#testMinuteOfDay.  
    /** TIME_TO_SEC on a full TIMESTAMP — modulus discards the date, returning seconds-of-day. */
            "2004-07-09 12:17:35"
    }  
    // Same comparison, but inside an IN subquery (TPC-H q20 shape). RelDecorrelator simplifies the
                + " | stats count() as c",
        );  
        );
    public void testDateAddMillisecondIntervalOnTimestampColumn() throws IOException {
            17L
    }
    }
     */
        assertFirstRowLong(
            "1998-09-02 00:00:00"
    }
    }
        // datetime0 = 2004-07-09 10:17:35Z; -11:00:00 → 2004-07-08 23:17:35.
    /** {@code date_format(_, '%f')} renders the 6-digit fractional second — pins the µs-preservation end-to-end. */
        assertFirstRowLong(oneRow("key00") + "| eval v = day_of_week(datetime0) | fields v", 6L);
    public void testDateAddInWherePredicate() throws IOException {  
            "22:06:22"
        if (dataProvisioned == false) {
            "10:17:36"  
            oneRow("key00") + "| eval v = time_format(time1, '%H:%i:%s') | fields v",
    }
            "123456"  
    public void testDateAddDayIntervalOnTimestampColumn() throws IOException {
    /** TO_SECONDS('1970-01-01 00:00:00') = 62167219200 — same anchor, second-resolution. */
    // The literal form is irrelevant: a native Calcite DATE literal (DATE '...') regresses the same
        );
        assertFirstRowString(
    public void testDateDiffPre1970Pair() throws IOException {
        assertFirstRowLong(  
import java.io.IOException;
            "10:17:35"
    }
    public void testAddDateIntegerDaysOnTimestampColumn() throws IOException {  
    }  
        assertFirstRowString(
            123456L
    public void testSubDateIntervalMinuteOnTimestamp() throws IOException {  
                + " | where key in [ source=" + DATASET.indexName
    }
    }
        assertFirstRowString(
        // datetime0 = 2004-07-09 10:17:35 → +30 days = 2004-08-08 10:17:35.
        );  
     */
    public void testTimestampMinusTimestampLiterals() throws IOException {  
    }
            oneRow("key00") + "| eval d = date_format(adddate('2020-08-26', interval 7 day), '%Y-%m-%d %H:%i:%s') | fields d",
        assertFirstRowString(
        assertFirstRowString(
    public void testStrftimeMilliEpochAutoDetect() throws IOException {  
    }  
 *
    public void testSysdateNonNull() throws IOException {  
    }
            oneRow("key00") + "| eval v = date_add(datetime0, interval 2 hour) | fields v",
        // DATE-DATE returns integer day-count.
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(HOUR FROM datetime0) | fields v", 10L);
            oneRow("key00") + "| eval v = date_sub(datetime0, interval 1 month) | fields v",  
     * ADDTIME with a TIMESTAMP column + TIME column (both non-literals) exercises the column-vs-column
        assertFirstRowString(
            oneRow("key00") + "| eval v = time_format(addtime(time1, time('02:30:00')), '%H:%i:%s') | fields v",  
        assertFirstRowLong(oneRow("key00") + "| eval d = to_days('1970-01-01') | fields d", 719_528L);
        );
    /** Year-rollover boundary: late-Dec 1899 reports as 1899's last week under both modes. */
            oneRow("key00") + "| eval v = date_add(datetime0, interval 1 day) | fields v",
        );
    /** ADDDATE integer form — per SPI: integer N is treated as INTERVAL N DAY. */
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    public void testDatetimeOnStringLiteral() throws IOException {
    }
    // Same date_add bound inside a SCALAR subquery (TPC-H q15 shape).
        assertFirstRowString(
    }
    }  
        );  
    }
            oneRow("key00") + "| eval v = microsecond(timestamp('2020-09-16 17:30:00.123')) | fields v",
    }
    // ── New PPL datetime scalars (ADDDATE/SUBDATE, DATEDIFF, TO_DAYS/TO_SECONDS/FROM_DAYS, ──────
    }
        assertFirstRowString(  
        assertFirstRowString(oneRow("key00") + "| eval v = strftime(-1, '%Y-%m-%d %H:%M:%S') | fields v", "1969-12-31 23:59:59");
            oneRow("key00") + "| eval v = date_sub(date('1998-12-01'), interval 90 day) | fields v",  
        );
        );
     * span a notional day boundary. Pins the DateDiffAdapter TIME-anchoring path end-to-end.
            oneRow("key00")
        );
    }  
    public void testMakedate() throws IOException {  
    /**  
        );
        );
        );
        );  
            "2018-03-19 13:55:03"
    }
        );
        assertFirstRowLong(oneRow("key00") + "| eval s = time_to_sec(time('19:36:22')) | fields s", 70_582L);
    }
    public void testStrToDateDateOnlyWithTimeFormat() throws IOException {
                + " | where num0 = [ source=" + DATASET.indexName
    public void testDateAddBoundScalarSubquery() throws IOException {
    public void testStrToDateZeroHour12h() throws IOException {
    // signature slot. Rust-level tests in rust/src/udf/maketime.rs cover semantics.
            oneRow("key00") + "| eval v = date_add(date('1993-07-01'), interval 3 month) | fields v",
            "2024-02-29"
                + " | where datetime0 >= date('2004-01-01')"  
    }  
            "2018-03-19 13:55:03"  
    public void testAddTimeCrossesMidnight() throws IOException {  
     * ({@code DatePartAdapters#coerceCharacterOperandToTimestamp}) end-to-end. The MOD 86400
    }
            oneRow("key00") + "| eval d = date_format(from_days(719528), '%Y-%m-%d') | fields d",  
    public void testDateAddYearIntervalOnDateLiteral() throws IOException {  
    public void testDateFormatOrdinalSuffix() throws IOException {  
    public void testDateFormatBasic() throws IOException {
    // time(expr) component extraction and TIME-operand time_format overloads are  
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        assertFirstRowLong(oneRow("key00") + "| eval v = month(date(datetime0)) | fields v", 7L);
        assertFirstRowString(  
    public void testTimestampGeDateNativeLiteralInSubquery() throws IOException {
            oneRow("key00") + "| eval v = date_format(addtime(datetime0, time('14:00:00')), '%Y-%m-%d %H:%i:%s') | fields v",  
    public void testDateDiffIgnoresTimeOfDay() throws IOException {  
            "source=" + DATASET.indexName
    public void testDateOnStringLiteralDay() throws IOException {
        assertFirstRowString(
        assertFirstRowString(  
    public void testExtractYear() throws IOException {  
        assertFirstRowLong(oneRow("key00") + "| eval v = year(date(datetime0)) | fields v", 2004L);  
        assertFirstRowLong(oneRow("key00") + "| eval v = hour(datetime('2004-07-09 10:17:35')) | fields v", 10L);  
            "2020-09-02 00:00:00"  
    // blocked by substrait-java 0.89.1's missing `ToTypeString` override for
    public void testMicrosecondOnTimestampPreservesMicroseconds() throws IOException {
    }
    public void testToSecondsEpochAnchor() throws IOException {
    public void testStrftimeIntegerUnixSeconds() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
     * fold bumps precision to 6 when the input carries non-zero sub-ms digits. Pre-fix this
        );
            oneRow("key00") + "| eval v = time_format(datetime0, '%H:%i:%s') | fields v",  
    /** WEEKDAY remap: 2004-07-09 was a Friday → MySQL 4 (Mon=0..Sun=6). */
            17L  
    // Same date_add bound inside an IN subquery (TPC-H q20 shape). Decorrelation folds the PPL  
        assertFirstRowString(
    /** GET_FORMAT(DATE, 'EUR') folds to '%d.%m.%Y' at plan time. */
        );
    }
     * DATEDIFF on two TIME operands: both anchor to the same (today's UTC) date, so their day-counts  
        assertFirstRowString(
    /** DATEDIFF on a pre-1970 pair — both operands negative-epoch, floor-divide preserves the calendar delta. */  
            oneRow("key00") + "| eval t = time_format(sec_to_time(123456), '%H:%i:%s') | fields t",
            "2004-06-09 10:17:35"
 * this file be licensed under the Apache-2.0 license or a
            "2004-07-09 00:00:00"  
        );
    public void testDayofweek() throws IOException {
    // date_add over a DATE() literal at the TOP LEVEL lowers fine (DateAddSubAdapter sees the
     * {@code DateAddSubAdapter} that routes through {@code coerceCharacterOperandToTimestamp}.
    }
    }  
            1L  
                + " | where datetime0 >= DATE '2004-01-01' | fields key ] | stats count() as c",
    }  
        // date0 at key00 = 2004-04-15 → last day of April 2004 = 2004-04-30.  
    // A timestamp-vs-date comparison at the TOP LEVEL coerces correctly and runs: all 17 calcs  
        // datetime0 at key00 = 2004-07-09 10:17:35; time1 = 19:36:22 → 2004-07-10 05:53:57.  
    public void testAddTimeOnTimeReturnsTime() throws IOException {  
        assertFirstRowLong(
    }
            "2004-04-10"
        assertFirstRowString(  
            "2004-07-09 10:17:35"
        );  
            "2004-04-30"  
            1L  
    /** PERIOD_DIFF(202612, 202601) = 11 — months between two YYYYMM periods within the same year. */
        assertFirstRowString(
            "source=" + DATASET.indexName + " | where datetime0 >= date('2004-01-01') | stats count() as c",
    }
    public void testDateDiffOnTimeOperandsReturnsZero() throws IOException {
            123000L
            "source=" + DATASET.indexName
            oneRow("key00") + "| eval v = date_format(subtime(datetime0, time('11:00:00')), '%Y-%m-%d %H:%i:%s') | fields v",  
     */
    }
    /** {@code extract(<unit> FROM TIME('<lit>'))} returns the unit value. */
    /** ADDTIME(time, time) returns a TIME — exercises the maketime branch (not from_unixtime). */
    public void testExtractFromVarcharLiteral() throws IOException {
        assertFirstRowLong(  
            "source=" + DATASET.indexName
        assertNotNull("sysdate() rendered to YYYY must be non-null", cell);
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
        // datetime0 at key00 == the literal → diff is epoch.
 * compatible open source license.
            "19:36:22"  
    /** SUBDATE integer form — per SPI: integer N is treated as INTERVAL N DAY. */  
                + " and datetime0 < date_add(date('2004-01-01'), interval 1 year) | fields key ]"
    }
            oneRow("key00") + "| eval d = date_format(adddate(datetime0, 30), '%Y-%m-%d %H:%i:%s') | fields d",  
        );  
        assertFirstRowString(
import org.opensearch.client.Request;
    public void testFromDaysRoundTripsThroughEpochAnchor() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(YEAR FROM '2003-12-31 17:30:00') | fields v", 2003L);
    }  
            oneRow("key00") + "| eval ld = date_format(last_day('2024-02-15'), '%Y-%m-%d') | fields ld",
                + " | where num0 = [ source=" + DATASET.indexName
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);  
    /** STR_TO_DATE on a date-only input with date+time format defaults time to 00:00:00. */
            oneRow("key00") + "| eval v = microsecond(timestamp('2020-09-16 17:30:00.000001')) | fields v",  
    // way as the PPL date('...') UDF inside a subquery, confirming the bug is the decorrelation fold,
    public void testAddDateIntervalForm() throws IOException {
    }
    protected void onBeforeQuery() throws IOException {  
            oneRow("key00") + "| eval v = date_add(date('1998-12-01'), interval 90 day) | fields v",  
    }
    /**
        assertFirstRowString(  
        assertTrue("sysdate year must start with '20', got " + cell, cell.toString().startsWith("20"));  
        assertFirstRowString(
            "2004-07-09 10:17:35.5"
    public void testSubDateIntegerForm() throws IOException {
     * discards the date, so result equals the time-of-day's second count regardless of the anchor.  
            oneRow("key00") + "| eval v = date_format(datetime0, '%Y-%m-%d %H:%i:%s') | fields v",  
            "2004-07-10 05:53:57"  
    /** TIMEDIFF returns a TIME — value of '23:59:59' minus '13:00:00' is '10:59:59'. */
    }
        // datetime0 at key00 = 2004-07-09 10:17:35 → +5 hours = 2004-07-09 15:17:35.
            oneRow("key00") + "| eval d = date_format(subdate(date0, 5), '%Y-%m-%d') | fields d",  
    }  
     * {@code minute_of_day(timestamp('<lit>'))} = hour*60 + minute. MinuteOfDayAdapter coerces the
        assertFirstRowLong(  
    public void testTimeToSecOnTimestamp() throws IOException {  
 * E2E coverage for PPL datetime scalar functions (PPL → Substrait → DataFusion). Fixture:
    public void testTimeDiffReturnsTime() throws IOException {
    }
    }  
    }
    public void testDateDiffAcrossEpochBoundary() throws IOException {
        Object cell = firstRowFirstCell(ppl);
    }  
            oneRow("key00") + "| eval v = timestamp(datetime0) - timestamp('2004-07-09 10:17:35') | fields v",
    /**
 * 1521467703 = 2018-03-19T13:55:03Z (matches SQL-plugin CalciteDateTimeFunctionIT).  
        );
    //    TIMEDIFF, LAST_DAY, YEARWEEK) — pin MySQL semantics that the q-suite smoke tests don't.  
    public void testDateMinusDateLiterals() throws IOException {  
    // Exercises the Rust UDF's `abs(v) >= 1e11` ms-auto-detect branch.
    }  
        assertFirstRowLong(oneRow("key00") + "| eval v = date('2024-01-15') - date('2024-01-10') | fields v", 5L);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    }
    public void testPeriodAddRollsAcrossYearBoundary() throws IOException {
    }  
        assertFirstRowLong(  
    // conversion fails with "Unable to convert call >=(precision_timestamp<0>?, string?)". The
                + "| where datetime0 < date_add(date('2005-01-01'), interval 1 year) "  
        assertFirstRowString(
    // top-level form above (which skips decorrelation) works.
        assertFirstRowLong(oneRow("key00") + "| eval v = year(makedate(2020, 1)) | fields v", 2020L);
    }  
    public void testExtractDayHourComposite() throws IOException {
    }
            oneRow("key00") + "| eval d = datediff('1969-12-31 00:00:00', '1969-12-30 00:00:00') | fields d",  
        assertFirstRowLong(oneRow("key00") + "| eval p = period_add(202612, 1) | fields p", 202_701L);
     * Millisecond-aligned input keeps the resolved (precision-3) fold, so {@code .123 → 123000}.  
            "2004-03-15"
     * silently truncated to {@code 123000}.  
    public void testMinuteOfDayOnTimeLiteral() throws IOException {
        );  
    public void testLastDayLeapYearFebruary() throws IOException {
import org.opensearch.client.Response;  
     * the ms-aligned fast path. The {@code subSecondNanos % 1_000_000 != 0} check pins this.
    }
    }
    public void testLastDayOnDateColumn() throws IOException {
    // down to a bare string before the backend's scalar-function adapter can coerce it, so Substrait  
        assertFirstRowString(
    /** FROM_DAYS round-trip: TO_DAYS('1970-01-01') back through FROM_DAYS yields 1970-01-01. */  
    public void testDateAddBoundInSubquery() throws IOException {
 * The OpenSearch Contributors require contributions made to  
            oneRow("key00") + "| eval d = date_format(adddate(datetime0, interval 5 hour), '%Y-%m-%d %H:%i:%s') | fields d",  
            1L  
        assertFirstRowLong(oneRow("key00") + "| eval v = dayofweek(datetime0) | fields v", 6L);  
                + " | where datetime0 >= date('2004-01-01') | fields key ] | stats count() as c",
     * {@code time_format(maketime(...), fmt)} path covered by {@link #testAddTimeOnTimeReturnsTime}.  
    }
    private String oneRow(String key) {
            "1993-10-01 00:00:00"
    }  
        );
        assertFirstRowString(  
        assertFirstRowString(  
            oneRow("key00") + "| eval v = strftime(1521467703, '%Y-%m-%d %H:%M:%S') | fields v",
     * ADDDATE with a VARCHAR base — exercises the {@code characterBase} branch in  
        );  
        // 19:36:22 → 19*3600 + 36*60 + 22 = 70582.  
            "1999-03-01 00:00:00"
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);  
            dataProvisioned = true;  
        assertFirstRowLong(oneRow("key00") + "| eval v = minute_of_day(time('17:30:00')) | fields v", 1050L);
public class DateTimeScalarFunctionsIT extends AnalyticsRestTestCase {
    public void testExtractHour() throws IOException {
        // datetime0 at key00 = 2004-07-09 (Fri); mode 0 (Sun-first) → week 27 of 2004 → 200427.  
            "1970-01-01"
    }
    public void testTimestampGeDateLiteralScalarSubquery() throws IOException {
    }
    /** SUBTIME on a TIMESTAMP that wraps backwards into the previous day. */
        );  
    // Same comparison inside a SCALAR subquery (TPC-H q15 shape).  
     * TIME_TO_SEC on a bare TIME literal exercises the today-anchor path
    /** {@code minute_of_day(time('<lit>'))} — TIME operand synthesized to a 1970-pinned TIMESTAMP. */  
    /** LAST_DAY in February of a leap year resolves to the 29th, not the 28th. */  
    }  
        );
            "2004-07-09"
            1L
     * coerces the operand and computes {@code MOD(date_part('microsecond', ts), 1_000_000)}.
    }
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).longValue());
    // MILLISECOND is the day-time base unit — exercises the 1:1 (no-scale) interval branch.  
        assertFirstRowString(
    public void testYearweekDec1899Boundary() throws IOException {
    /**  
            17L  
        );  
    // the upstream fix.  
    // End-to-end maketime coverage is blocked by the same substrait-java 0.89.1
    public void testSecToTimeWrapsOverOneDay() throws IOException {  
    public void testStrToDate() throws IOException {
    public void testTimeFormatBasic() throws IOException {
    public void testStrftimeFractionalSeconds() throws IOException {
    }
    public void testAddDateVarcharBaseCoerces() throws IOException {  
    public void testSecond() throws IOException {
        assertFirstRowString(
            oneRow("key00") + "| eval d = datediff('1970-01-01 00:00:00', '1969-12-31 12:00:00') | fields d",
    // subquery variants below, which use the SAME comparison but inside a subquery.
    }
        assertFirstRowString(oneRow("key00") + "| eval v = date_format(datetime0, '%D') | fields v", "9th");
    public void testDateAddBoundTopLevel() throws IOException {  
     */
    //    TIME_TO_SEC/SEC_TO_TIME, WEEKDAY, PERIOD_ADD/PERIOD_DIFF, GET_FORMAT, ADDTIME/SUBTIME/
        );
    public void testDateFormatPercentFOnTimestampMicros() throws IOException {  
    // docs have a datetime0 in 2004, so the predicate matches everything. Baseline for the
            "2004-07-10 10:17:35"  
        );
    /** SEC_TO_TIME(123456) wraps past one day → MySQL 10:17:36 (123456 % 86400 = 37056). */
     */
    }
    }  
        );
            "source=" + DATASET.indexName
        );
    public void testStrftimeNegativeTimestamp() throws IOException {
    // DATE() wrapper off the date_add ARGUMENT too, leaving DATE_ADD('2004-01-01':VARCHAR, interval)
    // until it learned to coerce a character base back to TIMESTAMP — the same recovery the  
    public void testExtractFromTimeLiteral() throws IOException {  
            oneRow("key00")
    /** ADDDATE on a TIMESTAMP column (not literal) — exercises the column-base lowering for ADDDATE. */
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(HOUR FROM time('17:30:00')) | fields v", 17L);
                + " | where key in [ source=" + DATASET.indexName  
    public void testMinuteOfDayOnTimestamp() throws IOException {
package org.opensearch.analytics.qa;
    /**
    }  
            DatasetProvisioner.provision(client(), DATASET);
    // not the literal's surface syntax.  
    public void testDateSubDayIntervalOnDateLiteral() throws IOException {
    public void testMicrosecondOnTimestamp() throws IOException {
    public void testDateSubMonthIntervalOnTimestampColumn() throws IOException {
    public void testDateAddMonthIntervalOnDateLiteral() throws IOException {
    }
 */  
        assertFirstRowString(oneRow("key00") + "| eval f = get_format(DATE, 'EUR') | fields f", "%d.%m.%Y");  
        );
        assertFirstRowString(
        assertFirstRowLong(
            1L
                + " | where datetime0 >= date('2004-01-01')"  
    }
            oneRow("key00") + "| eval v = date_format(last_day(date0), '%Y-%m-%d') | fields v",
            1L
    // DATE base). Baseline for the subquery variants below. All 17 calcs rows fall in [2004,2005).
        Map<String, Object> response = executePpl(ppl);
        assertFirstRowString(
            "2004-07-10 00:17:35"
    /**  
            "2004-07-08 23:17:35"
    private void assertFirstRowString(String ppl, String expected) throws IOException {
    /** DATEDIFF discards time-of-day — DATEDIFF('2000-01-02 00:00:00', '2000-01-01 23:59:59') = 1 not 0. */
            oneRow("key00")
        // datetime0 = 2004-07-09 10:17:35 → -30 minutes = 2004-07-09 09:47:35.
            "1970-01-01 00:00:00"
            oneRow("key00") + "| eval v = date_format(timestamp('2020-09-16 17:30:00.123456'), '%f') | fields v",
        );
        );  
    }
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(DAY_HOUR FROM datetime0) | fields v", 910L);  
    public void testWeekdayMatchesMySql() throws IOException {
     * cancel — matches MySQL's documented behavior of returning 0 even when the time-of-day values
    }  
    public void testTimestampGeDateLiteralInSubquery() throws IOException {  
            oneRow("key00") + "| eval d = date_format(adddate(date0, interval 7 day), '%Y-%m-%d') | fields d",  
        );
     */
            "10:59:59"
            oneRow("key00") + "| eval v = timestamp('1999-12-31 15:42:13') - timestamp('1961-04-12 09:07:00') | fields v",
    public void testStrftimeComplexFormat() throws IOException {  
            "source=" + DATASET.indexName  
    /** SUBDATE with a non-DAY interval unit — exercises the adapter's MINUTE branch with sign-flip. */
            0L
    public void testFromUnixtime() throws IOException {
        );
        assertFirstRowLong(oneRow("key00") + "| eval w = weekday(datetime0) | fields w", 4L);  
                + "| eval v = date_format(str_to_date('2017-10-23 00:00:00', '%Y-%m-%d %h:%i:%s'), '%Y-%m-%d %H:%i:%s') | fields v",
        assertFirstRowString(  
     * {@code microsecond(timestamp('<lit>'))} extracts the sub-second component. MicrosecondAdapter
        assertFirstRowLong(
    }
    /** YEARWEEK mode 0 vs mode 3 differ for 2003-10-03 (200339 vs 200340) — pins the mode arg path. */  
        );
    // ── TIMESTAMP / DATE subtraction → MinusAdapter ──────────────────────────────
     */
        );
        assertFirstRowLong(oneRow("key00") + "| eval v = day(date('2024-06-15')) | fields v", 15L);
            oneRow("key00") + "| eval v = strftime(datetime0, '%Y-%m-%d %H:%M:%S') | fields v",
    }  
        assertFirstRowLong(oneRow("key00") + "| eval s = time_to_sec(datetime0) | fields s", 37_055L);
        assertFirstRowLong(
        assertFirstRowString(
        );
     * Boundary: a single µs digit ({@code .000001}) must round-trip as {@code 1}, not be lost to
    public void testDateOnTimestampFieldYear() throws IOException {
        );
                + " | where datetime0 >= date('2004-01-01') | stats max(num0) ] | stats count() as c",
 * {@code calcs.key00} → {@code datetime0 = 2004-07-09T10:17:35Z}; literal-input cases use
        assertFirstRowString(  
    public void testToDaysEpochAnchor() throws IOException {  
     */  
            "Mon, Mar 19, 2018 01:55:03 PM UTC"  
                + "| eval v = date_format(str_to_date('09,07,2004', '%d,%m,%Y'), '%Y-%m-%d %H:%i:%s') | fields v",
    /** PERIOD_ADD(202612, 1) rolls into the next year: → 202701. */  
        );
    }
            "source=" + DATASET.indexName  
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = date_format(sysdate(), '%Y') | fields v");
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek('2003-10-03') | fields y", 200_339L);
    }  
            "2018-03-19 13:55:03"
    public void testPeriodDiffWithinYear() throws IOException {  
    }
    public void testDateAddHourIntervalOnTimestampColumn() throws IOException {
        );
     * LAST_DAY over a DATE column — exercises the no-anchor DATE branch end-to-end. The
    }  
            oneRow("key00") + "| eval v = date_format(addtime(datetime0, time1), '%Y-%m-%d %H:%i:%s') | fields v",
                + "| eval v = date_format(str_to_date('2017-10-23', '%Y-%m-%d %h:%i:%s'), '%Y-%m-%d %H:%i:%s') | fields v",
        assertFirstRowString(
    public void testDayOfWeekAlias() throws IOException {  
        assertFirstRowLong(
    }
            oneRow("key00") + "| eval d = datediff('2000-01-02 00:00:00', '2000-01-01 23:59:59') | fields d",
        Object cell = firstRowFirstCell(ppl);
    }
        // datetime0 at key00 = 10:17:35 → 10*3600 + 17*60 + 35 = 37055.
    }
            oneRow("key00") + "| eval d = date_format(subdate(date0, interval 1 month), '%Y-%m-%d') | fields d",
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek(datetime0) | fields y", 200_427L);
        assertFirstRowString(
        @SuppressWarnings("unchecked")  
    public void testTimeFormatOnTimeColumn() throws IOException {  
            oneRow("key00") + "| eval v = date_add(date('1994-01-01'), interval 1 year) | fields v",
        assertFirstRowLong(  
    public void testTimestampGeDateLiteralTopLevel() throws IOException {  
    public void testMicrosecondOnTimestampSingleMicrosecond() throws IOException {
    private Object firstRowFirstCell(String ppl) throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek('2003-10-03', 3) | fields y", 200_340L);  
    /**
                + " and datetime0 < date_add(date('2004-01-01'), interval 1 year) | stats max(num0) ]"
                + " | stats count() as c",
    public void testSubDateIntervalForm() throws IOException {
        );
     */  
     * {@code testLastDayLeapYearFebruary} IT only covers a string literal.  
            oneRow("key00") + "| eval d = date_format(adddate(date0, 7), '%Y-%m-%d') | fields d",
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
        return rows.get(0).get(0);
        // 19:36:22 + 02:30:00 → 22:06:22.
        assertFirstRowLong(
            "2004-04-22"  
    }  
    @Override
    }  
            oneRow("key00") + "| eval d = datediff(time('23:59:59'), time('00:00:00')) | fields d",  
    public void testTimestampMinusTimestampColumn() throws IOException {
    }
    public void testSecondOfMinute() throws IOException {
    public void testGetFormatDateEurFoldsAtPlanTime() throws IOException {
    }
    private static boolean dataProvisioned = false;  
    /** ADDDATE with a non-DAY interval unit — exercises the adapter's HOUR branch on a TIMESTAMP base. */
        );  
            oneRow("key00") + "| eval v = date_add(datetime0, interval 500 millisecond) | fields v",  
    }  
        assertFirstRowLong(oneRow("key00") + "| eval v = second_of_minute(datetime0) | fields v", 35L);  
        assertFirstRowString(  
    /** ADDDATE shares DATE_ADD's lowering — INTERVAL form on a DATE column. */  
        assertFirstRowString(
            17L  
        // datetime0 = 2004-07-09 10:17:35Z; +14:00:00 → 2004-07-10 00:17:35.
    public void testYearweekOnTimestampColumn() throws IOException {
        );
            "1995-01-01 00:00:00"  
        );
    public void testTimeToSecOnTimeLiteral() throws IOException {
        assertFirstRowString(
            "2004-07-09 15:17:35"
    }
        );
            oneRow("key00") + "| eval td = time_format(timediff(time('23:59:59'), time('13:00:00')), '%H:%i:%s') | fields td",
        assertFirstRowString(
    }
        assertFirstRowString(  
    /** {@code extract(<unit> FROM '<varchar literal>')} returns the unit value. */  
    }
            oneRow("key00") + "| eval v = microsecond(timestamp('2020-09-16 17:30:00.123456')) | fields v",
     * The {@code time1} column at key00 is {@code 19:36:22}.
            oneRow("key00") + "| eval d = date_format(subdate(datetime0, interval 30 minute), '%Y-%m-%d %H:%i:%s') | fields d",  
/**  
    /** DATEDIFF spanning the epoch — pins floor-divide; truncate-toward-zero would return 0. */
        assertFirstRowLong(oneRow("key00") + "| eval v = second(datetime0) | fields v", 35L);
        );  
        assertFirstRowString(
    public void testAddDateIntegerForm() throws IOException {  
    }  
    /** TO_DAYS('1970-01-01') = 719528 — pins the MySQL day-1 origin (year 0000-01-01). */
        assertFirstRowLong(oneRow("key00") + "| eval s = to_seconds('1970-01-01 00:00:00') | fields s", 62_167_219_200L);  
            oneRow("key00") + "| eval v = strftime(1521467703.123456, '%Y-%m-%d %H:%M:%S.%3Q') | fields v",  
    }  
    }
        assertFirstRowLong(
    }  
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(YEAR FROM datetime0) | fields v", 2004L);
            "2004-07-09 09:47:35"
    }
                + " | where key in [ source=" + DATASET.indexName
            "2004-07-09 10:17:35"
            oneRow("key00") + "| eval v = date_format(from_unixtime(1521467703), '%Y-%m-%d %H:%i:%s') | fields v",  
import java.util.List;  
    // `ParameterizedType.PrecisionTime`. Out of scope for Wave A; landing with
     * {@code time_format(time_column, fmt)} against a TIME column — distinct from the
        );
    /**  
    }
