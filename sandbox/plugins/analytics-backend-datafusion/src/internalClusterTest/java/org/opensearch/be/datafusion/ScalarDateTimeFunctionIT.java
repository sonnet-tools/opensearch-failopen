    }  
 *   <li>{@code DAYOFWEEK / DAY_OF_WEEK} — DF Sun=0..Sat=6, PPL Sun=1..Sat=7</li>
 *
    }  
    }
        assertScalarLong("week_of_year(created_at)", 24L);
        assertScalarLong("year(created_at)", 2024L);
 * <ul>  
        assertScalarLong("day(created_at)", 15L);  
 *   <li>{@code DATE_FORMAT / TIME_FORMAT} — DF chrono tokens, PPL MySQL dialect</li>
        assertNotNull("now() must not be null", evalScalar("now()"));
    }
    public void testDayOfMonth() {  
 * PPL → Calcite → Substrait → DataFusion. Bank fixture row 1:  
    }
    public void testUnixTimestamp() {  
    }  
    public void testCurrentTimestamp() {
        assertNotNull("current_timestamp() must not be null", evalScalar("current_timestamp()"));  
 *       Calcite binding returns VARCHAR for these, so downstream date-part calls  
        assertScalarLong("month(created_at)", 6L);
    public void testStrftimeFractionalSeconds() {
    public void testMonthOfYear() {
public class ScalarDateTimeFunctionIT extends BaseScalarFunctionIT {
    public void testDay() {
 *       extract; needs a dedicated adapter + yaml entry routing to {@code date_part}  
 * intentionally not advertised to the analytics-engine planner and flow through
    public void testStrftimeNegativeTimestamp() {  
        assertScalarString("strftime(1521467703, '%Y-%m-%d %H:%M:%S')", "2018-03-19 13:55:03");
        assertNotNull("current_time() must not be null", evalScalar("current_time()"));  
 *       (PPL {@code month(ts)} etc. already covers the same semantics).</li>
        assertScalarLong("unix_timestamp(convert_tz(created_at, '+00:00', '+10:00'))", 1718483400L);  
    public void testQuarter() {
        assertNotNull("current_date() must not be null", evalScalar("current_date()"));
    // CalciteDateTimeFunctionIT golden cases exactly.
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
 * </ul>  
    public void testCurrentTime() {
    }  
    }  
        assertNotNull("curdate() must not be null", evalScalar("curdate()"));
        assertScalarLong("week(created_at)", 24L);  
 *   <li>{@code SYSDATE} — DF now() is query-constant, PPL per-row</li>  
        assertScalarString("strftime(1521467703.123456, '%Y-%m-%d %H:%M:%S.%3Q')", "2018-03-19 13:55:03.123");  
 * non-null only — their value depends on wall-clock time.
    public void testCurtime() {  
        assertScalarLong("dayofmonth(created_at)", 15L);
 * {@code created_at = 2024-06-15T10:30:00Z}. Niladic functions are checked for
 *   <li>{@code SECOND / SECOND_OF_MINUTE} — DF returns DOUBLE, PPL INTEGER</li>
        assertScalarLong("unix_timestamp(created_at)", 1718447400L);
    }
    }
 *   <li>{@code FROM_UNIXTIME(epoch, fmt)} / {@code DATETIME(expr, tz)} 2-arg overloads —
    public void testWeekOfYear() {  
    public void testStrftimeOnDateField() {
    }  
        assertScalarLong("month_of_year(created_at)", 6L);
    // Fixture row 1: created_at = 2024-06-15T10:30:00Z, unix seconds = 1718447400.
    }  
    public void testCurrentDate() {  
 * compatible open source license.
 *  
    public void testHour() {  
        assertScalarLong("day_of_year(created_at)", 167L);  
 * plugin. Those are:
    }
    }  
 *       no matching DF signature</li>  
 *       lower to {@code date_part(string, string?)} which has no DataFusion signature.
        assertScalarLong("microsecond(created_at)", 0L);
    }
    }
        assertScalarLong("minute_of_hour(created_at)", 30L);
    public void testStrftimeIntegerUnixSeconds() {  
    }
 * the legacy Calcite path — they'll be re-routed through Rust UDFs in a  
    public void testDayOfYearAlias() {
    public void testCurdate() {
        assertScalarLong("dayofyear(created_at)", 167L);
        assertScalarString("strftime(created_at, '%Y-%m-%d %H:%M:%S')", "2024-06-15 10:30:00");
    }
 * follow-up, matching the convert_tz / to_unixtime pattern already in this
 */
    public void testWeek() {
}
    }
package org.opensearch.be.datafusion;
    public void testMonth() {  
    // Reference value 1521467703 = 2018-03-19T13:55:03Z — matches the SQL-plugin  
        assertNotNull("curtime() must not be null", evalScalar("curtime()"));
 * <p>Functions whose DF-builtin semantics diverge from legacy PPL are
 *       Needs PPL to produce real DATE/TIME types before they can route here.</li>
    public void testDayOfYear() {
        assertScalarString("strftime(-1, '%Y-%m-%d %H:%M:%S')", "1969-12-31 23:59:59");
        assertScalarLong("minute(created_at)", 30L);  
    public void testHourOfDay() {
    public void testConvertTz() {
    public void testYear() {
 * this file be licensed under the Apache-2.0 license or a
        assertScalarLong("hour(created_at)", 10L);
    }
    }
 *   <li>{@code DATE(expr)} / {@code TIME(expr)} / {@code MAKETIME(h,m,s)} — PPL's
    }
    }
    public void testNow() {
        assertScalarLong("quarter(created_at)", 2L);  
    // ── strftime ──────────────────────────────────────────────────────────────
 *   <li>{@code EXTRACT(unit FROM ts)} — isthmus resolves {@link org.apache.calcite.sql.SqlKind#EXTRACT}
    }
    }  
    public void testStrftimeComplexFormat() {
    public void testMinute() {
 * The OpenSearch Contributors require contributions made to  
/*  
        // UTC → +10:00 shift of 2024-06-15T10:30:00Z = 2024-06-15T20:30:00Z.
/**
    public void testMinuteOfHour() {  
 * End-to-end parity tests for PPL datetime scalar functions routed through
        assertScalarString("strftime(1521467703, '%a, %b %d, %Y %I:%M:%S %p %Z')", "Mon, Mar 19, 2018 01:55:03 PM UTC");
        assertScalarLong("hour_of_day(created_at)", 10L);
    }
    public void testMicrosecond() {
 *       through scalar-function lookup rather than emitting a native Substrait
    }
