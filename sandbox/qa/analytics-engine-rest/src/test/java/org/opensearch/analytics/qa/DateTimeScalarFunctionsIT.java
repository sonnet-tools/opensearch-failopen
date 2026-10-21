    }
        assertFirstRowString(
            "2004-04-22"
            oneRow("key00") + "| eval v = date_add(date('1994-01-01'), interval 1 year) | fields v",
            oneRow("key00")
            "2004-07-10 05:53:57"
        );
        );
    // subquery body and constant-folds the PPL TIMESTAMP(varchar) wrapper around the date literal
    }
    /** ADDDATE integer form — per SPI: integer N is treated as INTERVAL N DAY. */
    }
        assertFirstRowString(
            "2004-04-22"
            oneRow("key00") + "| eval v = strftime(1521467703123, '%Y-%m-%d %H:%M:%S') | fields v",
package org.opensearch.analytics.qa;
 * compatible open source license.
        assertFirstRowString(
    public void testAddDateIntegerForm() throws IOException {
                + " and datetime0 < date_add(date('2004-01-01'), interval 1 year) | stats max(num0) ]"
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(DAY_HOUR FROM datetime0) | fields v", 910L);
        assertFirstRowLong(oneRow("key00") + "| eval v = minute_of_day(time('17:30:00')) | fields v", 1050L);
    public void testSecondOfMinute() throws IOException {
            1L
    /** TO_DAYS('1970-01-01') = 719528 — pins the MySQL day-1 origin (year 0000-01-01). */
            "123456"
        assertFirstRowString(
            oneRow("key00")
        );
            oneRow("key00") + "| eval v = date_format(addtime(datetime0, time('14:00:00')), '%Y-%m-%d %H:%i:%s') | fields v",
        );
    /** TIMEDIFF returns a TIME — value of '23:59:59' minus '13:00:00' is '10:59:59'. */
    public void testStrftimeNegativeTimestamp() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek('2003-10-03') | fields y", 200_339L);
    public void testExtractFromVarcharLiteral() throws IOException {
 */
    // ── DATE_ADD / DATE_SUB → DateAddSubAdapter (DATETIME_PLUS lowering) ──────────
            "2004-07-09 12:17:35"
    public void testDateAddBoundTopLevel() throws IOException {
        assertFirstRowString(
                + " | where key in [ source=" + DATASET.indexName
    public void testDateAddBoundInSubquery() throws IOException {
                + "| where datetime0 < date_add(date('2005-01-01'), interval 1 year) "
    /** GET_FORMAT(DATE, 'EUR') folds to '%d.%m.%Y' at plan time. */
    }
    /**
    public void testDateFormatOrdinalSuffix() throws IOException {
        }
    public void testTimeFormatBasic() throws IOException {
            "source=" + DATASET.indexName
    /** Year-rollover boundary: late-Dec 1899 reports as 1899's last week under both modes. */
    }
        assertFirstRowString(
 * 1521467703 = 2018-03-19T13:55:03Z (matches SQL-plugin CalciteDateTimeFunctionIT).
     * {@code DateAddSubAdapter} that routes through {@code coerceCharacterOperandToTimestamp}.
 */
                + " | where datetime0 >= date('2004-01-01') | stats max(num0) ] | stats count() as c",
    public void testDateAddHourIntervalOnTimestampColumn() throws IOException {
    }
    public void testAddDateIntervalHourOnTimestamp() throws IOException {
    public void testYearweekDec1899Boundary() throws IOException {
    public void testLastDayOnDateColumn() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval s = time_to_sec(time('19:36:22')) | fields s", 70_582L);
        assertFirstRowString(
    }
            DatasetProvisioner.provision(client(), DATASET);
            "2004-07-09 09:47:35"
        assertFirstRowString(
        assertFirstRowLong(oneRow("key00") + "| eval v = day(date('2024-06-15')) | fields v", 15L);
        assertFirstRowLong(
        Object cell = firstRowFirstCell(ppl);
    }
    public void testStrftimeComplexFormat() throws IOException {
/**
     * cancel — matches MySQL's documented behavior of returning 0 even when the time-of-day values
     */
                + " | where datetime0 >= date('2004-01-01') | fields key ] | stats count() as c",
    }
    }
    protected void onBeforeQuery() throws IOException {
            oneRow("key00") + "| eval d = datediff('1969-12-31 00:00:00', '1969-12-30 00:00:00') | fields d",
        );
    // conversion fails with "Unable to convert call >=(precision_timestamp<0>?, string?)". The
    }
        assertFirstRowString(oneRow("key00") + "| eval v = date_format(datetime0, '%D') | fields v", "9th");
        assertFirstRowLong(oneRow("key00") + "| eval d = period_diff(202612, 202601) | fields d", 11L);
                + " | stats count() as c",
    public void testExtractYear() throws IOException {
    }
        assertFirstRowLong(oneRow("key00") + "| eval v = year(date(datetime0)) | fields v", 2004L);
        assertFirstRowString(
    }
        // datetime0 = 2004-07-09 10:17:35 → +30 days = 2004-08-08 10:17:35.
        );
        assertFirstRowString(
    }
    /** ADDTIME(time, time) returns a TIME — exercises the maketime branch (not from_unixtime). */
    }
            "10:17:36"
        assertFirstRowString(
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(YEAR FROM datetime0) | fields v", 2004L);
    }
     */
    public void testLastDayLeapYearFebruary() throws IOException {
            123000L
    // way as the PPL date('...') UDF inside a subquery, confirming the bug is the decorrelation fold,
    // time(expr) component extraction and TIME-operand time_format overloads are
            oneRow("key00") + "| eval v = time_format(time1, '%H:%i:%s') | fields v",
        assertFirstRowLong(
     * ADDDATE with a VARCHAR base — exercises the {@code characterBase} branch in
    public void testTimeToSecOnTimeLiteral() throws IOException {
    public void testSubTimeWrapsToPreviousDay() throws IOException {
            17L
     * {@code time_format(maketime(...), fmt)} path covered by {@link #testAddTimeOnTimeReturnsTime}.
        );
    }
    public void testDayOfWeekAlias() throws IOException {
     */
            "2008-09-20 06:35:13"
            1L
        assertFirstRowLong(oneRow("key00") + "| eval v = year(makedate(2020, 1)) | fields v", 2020L);
            "10:59:59"
        );
    public void testAddTimeTimestampPlusTimeColumn() throws IOException {
                + " | where key in [ source=" + DATASET.indexName
    }
            "1999-03-01 00:00:00"
    /**
    public void testAddDateVarcharBaseCoerces() throws IOException {
            oneRow("key00") + "| eval v = time_format(datetime0, '%H:%i:%s') | fields v",
        );
                + " | stats count() as c",
    public void testDateOnTimestampFieldYear() throws IOException {
    public void testDateFormatBasic() throws IOException {
        assertTrue("sysdate year must start with '20', got " + cell, cell.toString().startsWith("20"));
        assertFirstRowString(
        // datetime0 = 2004-07-09 10:17:35Z; +14:00:00 → 2004-07-10 00:17:35.
        Object cell = firstRowFirstCell(oneRow("key00") + "| eval v = date_format(sysdate(), '%Y') | fields v");
            17L
        );
        Object cell = firstRowFirstCell(ppl);
    public void testTimeDiffReturnsTime() throws IOException {
            1L
        );
        assertFirstRowString(
    // DATE base). Baseline for the subquery variants below. All 17 calcs rows fall in [2004,2005).
            "2004-07-09"
    public void testExtractFromTimeLiteral() throws IOException {
    }
     * operand to TIMESTAMP for the two date_part calls. Reference: DateTimeFunctionIT#testMinuteOfDay.
    /** FROM_DAYS round-trip: TO_DAYS('1970-01-01') back through FROM_DAYS yields 1970-01-01. */
    // signature slot. Rust-level tests in rust/src/udf/maketime.rs cover semantics.
    }
        assertFirstRowLong(oneRow("key00") + "| eval v = day_of_week(datetime0) | fields v", 6L);
            "2004-04-30"
        );
    // not the literal's surface syntax.
        );
        assertFirstRowString(
 *
    }
    }
            oneRow("key00") + "| eval d = datediff('1970-01-01 00:00:00', '1969-12-31 12:00:00') | fields d",
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
    public void testAddDateIntegerDaysOnTimestampColumn() throws IOException {
            oneRow("key00") + "| eval d = datediff('2000-01-02 00:00:00', '2000-01-01 23:59:59') | fields d",
        // datetime0 at key00 = 10:17:35 → 10*3600 + 17*60 + 35 = 37055.
    public void testDateDiffOnTimeOperandsReturnsZero() throws IOException {
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
                + " | where key in [ source=" + DATASET.indexName
    }
    /**
            oneRow("key00") + "| eval d = date_format(subdate(date0, interval 1 month), '%Y-%m-%d') | fields d",
    }
                + " and datetime0 < date_add(date('2004-01-01'), interval 1 year) | stats count() as c",
    }
        );
    public void testAddTimeCrossesMidnight() throws IOException {
    }
    // which DateAddSubAdapter rejected ("Unable to convert call DATE_ADD(string?, interval_year)")
        assertTrue("Expected numeric result for query [" + ppl + "] but got: " + cell, cell instanceof Number);
            oneRow("key00") + "| eval v = timestamp('1999-12-31 15:42:13') - timestamp('1961-04-12 09:07:00') | fields v",
        assertFirstRowString(
    public void testExtractDayHourComposite() throws IOException {
    // A timestamp-vs-date comparison at the TOP LEVEL coerces correctly and runs: all 17 calcs
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek('2003-10-03', 3) | fields y", 200_340L);
        // 19:36:22 → 19*3600 + 36*60 + 22 = 70582.
    public void testSecond() throws IOException {
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
    /** SUBDATE with a non-DAY interval unit — exercises the adapter's MINUTE branch with sign-flip. */
    // Same date_add bound inside an IN subquery (TPC-H q20 shape). Decorrelation folds the PPL
    // `ParameterizedType.PrecisionTime`. Out of scope for Wave A; landing with
    }
    //    TIMEDIFF, LAST_DAY, YEARWEEK) — pin MySQL semantics that the q-suite smoke tests don't.
     */
     * {@code microsecond(timestamp('<lit>'))} extracts the sub-second component. MicrosecondAdapter
    public void testTimeFormatOnTimeColumn() throws IOException {
        @SuppressWarnings("unchecked")
        assertFirstRowLong(
    }
    }
    }
        );
     */
        );
            oneRow("key00") + "| eval v = date_format(subtime(datetime0, time('11:00:00')), '%Y-%m-%d %H:%i:%s') | fields v",
        // datetime0 at key00 == 2004-07-09 10:17:35; +1 day preserves the time-of-day.
        );
     * LAST_DAY over a DATE column — exercises the no-anchor DATE branch end-to-end. The
    }
        );
    public void testSubDateIntervalMinuteOnTimestamp() throws IOException {
            oneRow("key00") + "| eval v = date_format(from_unixtime(1521467703), '%Y-%m-%d %H:%i:%s') | fields v",
    /** TIME_TO_SEC on a full TIMESTAMP — modulus discards the date, returning seconds-of-day. */
        assertTrue("Expected at least one row for query: " + ppl, rows.size() >= 1);
    // until it learned to coerce a character base back to TIMESTAMP — the same recovery the
            1L
            oneRow("key00") + "| eval t = time_format(sec_to_time(123456), '%H:%i:%s') | fields t",
        assertFirstRowString(
            "source=" + DATASET.indexName + " | where datetime0 >= date('2004-01-01') | stats count() as c",
        assertFirstRowString(
            oneRow("key00") + "| eval v = strftime(1521467703, '%a, %b %d, %Y %I:%M:%S %p %Z') | fields v",
    }
            "source=" + DATASET.indexName
        assertFirstRowString(oneRow("key00") + "| eval v = strftime(-1, '%Y-%m-%d %H:%M:%S') | fields v", "1969-12-31 23:59:59");
    }
    /** YEARWEEK on a TIMESTAMP column (not literal) exercises the os_yearweek column path. */
    }
    }
    }
            "1998-09-02 00:00:00"
        );
            "1970-01-01"
        assertFirstRowLong(oneRow("key00") + "| eval s = to_seconds('1970-01-01 00:00:00') | fields s", 62_167_219_200L);
        assertFirstRowString(
    }
        assertNotNull("sysdate() rendered to YYYY must be non-null", cell);
        assertFirstRowString(
     * Sub-ms input ({@code .123456}) preserves all 6 µs digits — the TimestampFunctionAdapter
        assertFirstRowString(
        );
                + " | where datetime0 >= date('2004-01-01')"
                + " | where datetime0 >= DATE '2004-01-01' | fields key ] | stats count() as c",
        // datetime0 = 2004-07-09 10:17:35 → -30 minutes = 2004-07-09 09:47:35.
import org.opensearch.client.Response;
    }
     */
     */
    }
    public void testMicrosecondOnTimestampPreservesMicroseconds() throws IOException {
        // 19:36:22 + 02:30:00 → 22:06:22.
    public void testMinuteOfDayOnTimestamp() throws IOException {
    /** PERIOD_ADD(202612, 1) rolls into the next year: → 202701. */
    // date_add over a DATE() literal at the TOP LEVEL lowers fine (DateAddSubAdapter sees the
                + " | where num0 = [ source=" + DATASET.indexName
    public void testDateDiffIgnoresTimeOfDay() throws IOException {
        assertFirstRowLong(
        assertFirstRowString(
            "source=" + DATASET.indexName
            oneRow("key00") + "| eval d = date_format(adddate(date0, interval 7 day), '%Y-%m-%d') | fields d",
        assertFirstRowString(
    }
    }
    public void testDateSubMonthIntervalOnTimestampColumn() throws IOException {
        assertFirstRowString(
    public void testMinuteOfDayOnTimeLiteral() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval v = hour(datetime('2004-07-09 10:17:35')) | fields v", 10L);
    public void testFromDaysRoundTripsThroughEpochAnchor() throws IOException {
    @Override
            oneRow("key00") + "| eval v = date_add(date('1998-12-01'), interval 90 day) | fields v",
        assertFirstRowString(
        );
    }
    // Exercises the Rust UDF's `abs(v) >= 1e11` ms-auto-detect branch.
    }
        assertFirstRowString(
                + " | where datetime0 >= date('2004-01-01')"
        assertFirstRowString(
        assertEquals("Value mismatch for query: " + ppl, expected, cell);
    // down to a bare string before the backend's scalar-function adapter can coerce it, so Substrait
            "Mon, Mar 19, 2018 01:55:03 PM UTC"
        assertFirstRowLong(oneRow("key00") + "| eval v = second(datetime0) | fields v", 35L);
     */
        assertFirstRowLong(
        assertNotNull("Response missing 'rows' for query: " + ppl, rows);
        assertFirstRowString(
            oneRow("key00") + "| eval d = date_format(adddate('2020-08-26', interval 7 day), '%Y-%m-%d %H:%i:%s') | fields d",
    }
    }
    }
            "2018-03-19 13:55:03"
     * {@code testLastDayLeapYearFebruary} IT only covers a string literal.
            "source=" + DATASET.indexName
                + "| eval v = date_format(datetime0, '%Y-%m-%d') | fields v",
import java.util.List;
        assertFirstRowLong(oneRow("key00") + "| eval d = to_days('1970-01-01') | fields d", 719_528L);
            oneRow("key00") + "| eval d = date_format(subdate(datetime0, interval 30 minute), '%Y-%m-%d %H:%i:%s') | fields d",
    /** ADDDATE on a TIMESTAMP column (not literal) — exercises the column-base lowering for ADDDATE. */
    public void testDateDiffPre1970Pair() throws IOException {
        // datetime0 at key00 = 2004-07-09 (Fri); mode 0 (Sun-first) → week 27 of 2004 → 200427.
    }
            dataProvisioned = true;
    }
    }
    }
    // Same comparison inside a SCALAR subquery (TPC-H q15 shape).
        );
            oneRow("key00") + "| eval d = date_format(adddate(date0, 7), '%Y-%m-%d') | fields d",
        assertFirstRowString(
        assertFirstRowString(oneRow("key00") + "| eval f = get_format(DATE, 'EUR') | fields f", "%d.%m.%Y");
    public void testTimestampGeDateNativeLiteralInSubquery() throws IOException {
        );
            1L
    /**
/*
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek(datetime0) | fields y", 200_427L);
    private void assertFirstRowString(String ppl, String expected) throws IOException {
            "2004-06-09 10:17:35"
        );
    public void testFromUnixtime() throws IOException {
     * discards the date, so result equals the time-of-day's second count regardless of the anchor.
        assertFirstRowString(
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek('1899-12-30', 4) | fields y", 189_952L);
    public void testDateSubDayIntervalOnDateLiteral() throws IOException {
    public void testSysdateNonNull() throws IOException {
        );
            "1995-01-01 00:00:00"
     * the ms-aligned fast path. The {@code subSecondNanos % 1_000_000 != 0} check pins this.
        assertFirstRowLong(oneRow("key00") + "| eval v = dayofweek(datetime0) | fields v", 6L);
        assertNotNull("Expected non-null result for query [" + ppl + "]", cell);
    }
        if (dataProvisioned == false) {
    private String oneRow(String key) {
    public void testDateOnTimestampFieldMonth() throws IOException {
    }
     * {@code minute_of_day(timestamp('<lit>'))} = hour*60 + minute. MinuteOfDayAdapter coerces the
public class DateTimeScalarFunctionsIT extends AnalyticsRestTestCase {
        // DATE-DATE returns integer day-count.
    }
        assertFirstRowLong(
            oneRow("key00") + "| eval v = strftime(datetime0, '%Y-%m-%d %H:%M:%S') | fields v",
    public void testDateAddDayIntervalOnTimestampColumn() throws IOException {
    /** SUBTIME on a TIMESTAMP that wraps backwards into the previous day. */
import java.util.Map;
        );
        );
            oneRow("key00") + "| eval v = date_add(datetime0, interval 500 millisecond) | fields v",
        );
        assertFirstRowLong(oneRow("key00") + "| eval v = second_of_minute(datetime0) | fields v", 35L);
    }
            oneRow("key00") + "| eval d = date_format(adddate(datetime0, interval 5 hour), '%Y-%m-%d %H:%i:%s') | fields d",
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(HOUR FROM time('17:30:00')) | fields v", 17L);
            oneRow("key00") + "| eval v = microsecond(timestamp('2020-09-16 17:30:00.000001')) | fields v",
        assertFirstRowString(
        );
    public void testDateAddBoundScalarSubquery() throws IOException {
        );
 * E2E coverage for PPL datetime scalar functions (PPL → Substrait → DataFusion). Fixture:
    public void testStrToDate() throws IOException {
            oneRow("key00") + "| eval d = datediff(time('23:59:59'), time('00:00:00')) | fields d",
        );
            oneRow("key00") + "| eval v = date_add(datetime0, interval 1 day) | fields v",
 * The OpenSearch Contributors require contributions made to
    // top-level form above (which skips decorrelation) works.
    public void testStrftimeFractionalSeconds() throws IOException {
    public void testStrToDateDateOnlyWithTimeFormat() throws IOException {
        );
    /** SEC_TO_TIME(123456) wraps past one day → MySQL 10:17:36 (123456 % 86400 = 37056). */
            oneRow("key00") + "| eval v = date_sub(datetime0, interval 1 month) | fields v",
            "2018-03-19 13:55:03"
    // ── TIMESTAMP / DATE subtraction → MinusAdapter ──────────────────────────────
        assertFirstRowString(
    public void testAddDateIntervalForm() throws IOException {
    // blocked by substrait-java 0.89.1's missing `ToTypeString` override for
    public void testStrToDateZeroHour12h() throws IOException {
        );
    public void testToDaysEpochAnchor() throws IOException {
            oneRow("key00") + "| eval v = strftime(1521467703.123456, '%Y-%m-%d %H:%M:%S.%3Q') | fields v",
     * TIME_TO_SEC on a bare TIME literal exercises the today-anchor path
    /** YEARWEEK mode 0 vs mode 3 differ for 2003-10-03 (200339 vs 200340) — pins the mode arg path. */
        assertFirstRowString(
    /** DATEDIFF discards time-of-day — DATEDIFF('2000-01-02 00:00:00', '2000-01-01 23:59:59') = 1 not 0. */
    public void testDateAddYearIntervalOnDateLiteral() throws IOException {
    }
}
    }
    public void testTimestampGeDateLiteralScalarSubquery() throws IOException {
    public void testDateOnStringLiteralDay() throws IOException {
    }
            oneRow("key00") + "| eval v = date_sub(date('1998-12-01'), interval 90 day) | fields v",
    /** {@code date_format(_, '%f')} renders the 6-digit fractional second — pins the µs-preservation end-to-end. */
    public void testDateAddDayIntervalOnDateLiteral() throws IOException {
import org.opensearch.client.Request;
            oneRow("key00") + "| eval d = date_format(from_days(719528), '%Y-%m-%d') | fields d",
        assertFirstRowLong(
            oneRow("key00") + "| eval v = date_format(timestamp('2020-09-16 17:30:00.123456'), '%f') | fields v",
    private Object firstRowFirstCell(String ppl) throws IOException {
     * ({@code DatePartAdapters#coerceCharacterOperandToTimestamp}) end-to-end. The MOD 86400
            "1993-10-01 00:00:00"
    public void testPeriodDiffWithinYear() throws IOException {
    // subquery variants below, which use the SAME comparison but inside a subquery.
    }
                + " and datetime0 < date_add(date('2004-01-01'), interval 1 year) | fields key ]"
        return "source=" + DATASET.indexName + " | where key='" + key + "' | head 1 ";
            1L
            17L
        );
            oneRow("key00") + "| eval v = strftime(1521467703, '%Y-%m-%d %H:%M:%S') | fields v",
            "source=" + DATASET.indexName
            oneRow("key00") + "| eval td = time_format(timediff(time('23:59:59'), time('13:00:00')), '%H:%i:%s') | fields td",
    }
    }
    }
        assertFirstRowLong(
    /**
        );
    }
            "2004-04-10"
    // the upstream fix.
        );
    /** STR_TO_DATE on a date-only input with date+time format defaults time to 00:00:00. */
        );
    // MILLISECOND is the day-time base unit — exercises the 1:1 (no-scale) interval branch.
    public void testTimestampMinusTimestampColumn() throws IOException {
    public void testDateAddInWherePredicate() throws IOException {
        // date0 at key00 = 2004-04-15 → last day of April 2004 = 2004-04-30.
     * The {@code time1} column at key00 is {@code 19:36:22}.
     * DATEDIFF on two TIME operands: both anchor to the same (today's UTC) date, so their day-counts
        );
    /** {@code extract(<unit> FROM TIME('<lit>'))} returns the unit value. */
            "2017-10-23 00:00:00"
    public void testMicrosecondOnTimestamp() throws IOException {
            "2018-03-19 13:55:03"
    //    TIME_TO_SEC/SEC_TO_TIME, WEEKDAY, PERIOD_ADD/PERIOD_DIFF, GET_FORMAT, ADDTIME/SUBTIME/
        assertFirstRowString(
    public void testTimestampGeDateLiteralTopLevel() throws IOException {
    /**
        assertFirstRowString(
        // datetime0 at key00 = 2004-07-09 10:17:35; time1 = 19:36:22 → 2004-07-10 05:53:57.
        // Use a TIMESTAMP literal so the operand-typing path matches the dataset use.
    private void assertFirstRowLong(String ppl, long expected) throws IOException {
                + "| eval v = date_format(str_to_date('09,07,2004', '%d,%m,%Y'), '%Y-%m-%d %H:%i:%s') | fields v",
    // %D ordinal day — proves shared mysql_format token table reachable via date_format.
    }
    public void testDatetimeOnStringLiteral() throws IOException {
    // ToTypeString gap as time(expr); Time64(Microsecond) return has no working
    }
            oneRow("key00") + "| eval d = date_format(subdate(date0, 5), '%Y-%m-%d') | fields d",
            "2004-07-10 10:17:35"
import java.io.IOException;
    }
        assertFirstRowLong(
            "19:36:22"
    }
    /** DATEDIFF on a pre-1970 pair — both operands negative-epoch, floor-divide preserves the calendar delta. */
            oneRow("key00")
            oneRow("key00") + "| eval ld = date_format(last_day('2024-02-15'), '%Y-%m-%d') | fields ld",
    /** STR_TO_DATE accepts %h="00" zero-hour 12-hour-clock input. */
    /**
            "2004-07-09 10:17:35.5"
 * {@code calcs.key00} → {@code datetime0 = 2004-07-09T10:17:35Z}; literal-input cases use
    public void testDateFormatPercentFOnTimestampMicros() throws IOException {
    /** ADDDATE with a non-DAY interval unit — exercises the adapter's HOUR branch on a TIMESTAMP base. */
     * fold bumps precision to 6 when the input carries non-zero sub-ms digits. Pre-fix this
        assertFirstRowLong(oneRow("key00") + "| eval y = yearweek('1899-12-30') | fields y", 189_952L);
    // DATE() wrapper off the date_add ARGUMENT too, leaving DATE_ADD('2004-01-01':VARCHAR, interval)
    public void testDayofweek() throws IOException {
    // docs have a datetime0 in 2004, so the predicate matches everything. Baseline for the
    }
            "2004-08-08 10:17:35"
                + " | where datetime0 >= date('2004-01-01')"
            "10:17:35"
            "1970-01-01 00:00:00"
    }
        );
    /**
            17L
    /** WEEKDAY remap: 2004-07-09 was a Friday → MySQL 4 (Mon=0..Sun=6). */
            "2004-07-09 10:17:35"
    /** {@code minute_of_day(time('<lit>'))} — TIME operand synthesized to a 1970-pinned TIMESTAMP. */
            "2004-07-10 00:17:35"
        assertFirstRowLong(oneRow("key00") + "| eval v = minute_of_day(timestamp('2020-09-16 17:30:00')) | fields v", 1050L);
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(YEAR FROM '2003-12-31 17:30:00') | fields v", 2003L);
        assertFirstRowLong(
        assertFirstRowLong(
    }
    }
            "22:06:22"
            "2004-07-09 15:17:35"
            "2017-10-23 00:00:00"
    public void testTimestampGeDateLiteralInSubquery() throws IOException {
    /** TO_SECONDS('1970-01-01 00:00:00') = 62167219200 — same anchor, second-resolution. */
            oneRow("key00") + "| eval v = date_format(datetime0, '%Y-%m-%d %H:%i:%s') | fields v",
            oneRow("key00") + "| eval v = timestamp(datetime0) - timestamp('2004-07-09 10:17:35') | fields v",
    /** ADDDATE shares DATE_ADD's lowering — INTERVAL form on a DATE column. */
        );
        assertFirstRowLong(
    }
    public void testExtractHour() throws IOException {
    }
     * Boundary: a single µs digit ({@code .000001}) must round-trip as {@code 1}, not be lost to
     * silently truncated to {@code 123000}.
    public void testSubDateIntervalForm() throws IOException {
    }
        assertFirstRowString(
    // Same date_add bound inside a SCALAR subquery (TPC-H q15 shape).
        assertFirstRowLong(oneRow("key00") + "| eval v = date('2024-01-15') - date('2024-01-10') | fields v", 5L);
    // comparison adapter does for >=.
        // datetime0 = 2004-07-09 10:17:35Z; -11:00:00 → 2004-07-08 23:17:35.
    public void testStrftimeOnDateField() throws IOException {
        );
            oneRow("key00") + "| eval v = date_add(date('1993-07-01'), interval 3 month) | fields v",
            "2020-09-02 00:00:00"
        assertFirstRowLong(oneRow("key00") + "| eval w = weekday(datetime0) | fields w", 4L);
    }
     * {@code time_format(time_column, fmt)} against a TIME column — distinct from the
    public void testSubDateIntegerForm() throws IOException {
            oneRow("key00")
    public void testToSecondsEpochAnchor() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval p = period_add(202612, 1) | fields p", 202_701L);
     * branch — distinct from the literal-time branch covered by {@link #testAddTimeCrossesMidnight}.
        );
    }
            oneRow("key00") + "| eval v = time_format(addtime(time1, time('02:30:00')), '%H:%i:%s') | fields v",
        // datetime0 at key00 = 2004-07-09 10:17:35 → +5 hours = 2004-07-09 15:17:35.
    public void testSecToTimeWrapsOverOneDay() throws IOException {
        assertFirstRowString(
    }
    }
        assertFirstRowString(
 * SPDX-License-Identifier: Apache-2.0
            "2004-07-09 10:17:35"
    public void testDateDiffAcrossEpochBoundary() throws IOException {
    public void testGetFormatDateEurFoldsAtPlanTime() throws IOException {
        );
    private static boolean dataProvisioned = false;
            "2004-03-15"
            oneRow("key00") + "| eval d = date_format(adddate(datetime0, 30), '%Y-%m-%d %H:%i:%s') | fields d",
        );
    /** DATEDIFF spanning the epoch — pins floor-divide; truncate-toward-zero would return 0. */
            "2004-07-09 00:00:00"
        );
    }
     * ADDTIME with a TIMESTAMP column + TIME column (both non-literals) exercises the column-vs-column
    /** PERIOD_DIFF(202612, 202601) = 11 — months between two YYYYMM periods within the same year. */
        );
    /** SUBDATE integer form — per SPI: integer N is treated as INTERVAL N DAY. */
    }
        );
    }
    // Same comparison, but inside an IN subquery (TPC-H q20 shape). RelDecorrelator simplifies the
            "source=" + DATASET.indexName
        );
            "2004-07-08 23:17:35"
    }
        );
     * span a notional day boundary. Pins the DateDiffAdapter TIME-anchoring path end-to-end.
    }
    public void testTimeToSecOnTimestamp() throws IOException {
            oneRow("key00") + "| eval v = microsecond(timestamp('2020-09-16 17:30:00.123')) | fields v",
            oneRow("key00") + "| eval v = date_format(last_day(date0), '%Y-%m-%d') | fields v",
        );
    public void testTimestampMinusTimestampLiterals() throws IOException {
    // End-to-end maketime coverage is blocked by the same substrait-java 0.89.1
        assertFirstRowLong(
        assertFirstRowLong(oneRow("key00") + "| eval s = time_to_sec(datetime0) | fields s", 37_055L);
        return rows.get(0).get(0);
    public void testYearweekOnTimestampColumn() throws IOException {
            17L
        assertFirstRowString(
    }
    }
    public void testWeekdayMatchesMySql() throws IOException {
            oneRow("key00") + "| eval v = microsecond(timestamp('2020-09-16 17:30:00.123456')) | fields v",
        assertFirstRowString(
            123456L
    public void testStrftimeMilliEpochAutoDetect() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            0L
            "2024-02-29"
    }
        assertFirstRowString(
        assertFirstRowString(
        Map<String, Object> response = executePpl(ppl);
    // date_add inside a WHERE predicate — the TPC-H q1/q4 shape that surfaced the gap.
        // datetime0 at key00 == the literal → diff is epoch.
                + "| eval v = date_format(str_to_date('2017-10-23', '%Y-%m-%d %h:%i:%s'), '%Y-%m-%d %H:%i:%s') | fields v",
    }
                + "| eval v = date_format(str_to_date('2017-10-23 00:00:00', '%Y-%m-%d %h:%i:%s'), '%Y-%m-%d %H:%i:%s') | fields v",
        assertFirstRowLong(oneRow("key00") + "| eval v = month(date(datetime0)) | fields v", 7L);
    public void testDateAddMillisecondIntervalOnTimestampColumn() throws IOException {
    }
    }
    public void testAddTimeOnTimeReturnsTime() throws IOException {
    // ── New PPL datetime scalars (ADDDATE/SUBDATE, DATEDIFF, TO_DAYS/TO_SECONDS/FROM_DAYS, ──────
    public void testMicrosecondOnTimestampSingleMicrosecond() throws IOException {
            "2018-03-19 13:55:03.123"
    /**
        );
    public void testMakedate() throws IOException {
        );
     * coerces the operand and computes {@code MOD(date_part('microsecond', ts), 1_000_000)}.
            oneRow("key00") + "| eval v = date_add(datetime0, interval 2 hour) | fields v",
    public void testPeriodAddRollsAcrossYearBoundary() throws IOException {
    public void testStrftimeIntegerUnixSeconds() throws IOException {
    }
        assertFirstRowLong(
    /** {@code extract(<unit> FROM '<varchar literal>')} returns the unit value. */
                + " | where num0 = [ source=" + DATASET.indexName
     */
    /** ADDTIME(timestamp, time) crossing midnight rolls the date forward (matches legacy SQL). */
    }
    }
        );
    /**
    // The literal form is irrelevant: a native Calcite DATE literal (DATE '...') regresses the same
    /** SUBDATE shares DATE_SUB's lowering — INTERVAL form on a DATE column. */
        assertEquals("Value mismatch for query: " + ppl, expected, ((Number) cell).longValue());
    public void testYearweekModeArgChangesResult() throws IOException {
            oneRow("key00") + "| eval v = date_format(addtime(datetime0, time1), '%Y-%m-%d %H:%i:%s') | fields v",
        );
     * Millisecond-aligned input keeps the resolved (precision-3) fold, so {@code .123 → 123000}.
     */
    /** LAST_DAY in February of a leap year resolves to the 29th, not the 28th. */
    public void testDateAddMonthIntervalOnDateLiteral() throws IOException {
        );
    public void testDateMinusDateLiterals() throws IOException {
        assertFirstRowLong(oneRow("key00") + "| eval v = extract(HOUR FROM datetime0) | fields v", 10L);
