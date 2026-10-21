    }
        // Otherwise use a totally random date
            long floor = rounding.round(timeAfterSecondMidnight);
                        + "]"
    /**
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.MONTH_OF_YEAR).timeZone(tz).build();
        assertFalse(minusFiveRounding.isUTC());
        assertThat(rounding.round(time("2015-10-25T02:15:00+01:00")), isDate(time("2015-10-25T02:00:00+01:00"), tz));
                rounding.nextRoundingValue(dateBetween),
         * Lord Howe is fun because Daylight Savings time is only 30 minutes
            millisSinceEpoch - twoHours,
                        + "] to ["
        assertThat(time("2014-10-26T03:00:00+03:00"), isDate(time("2014-10-26T02:00:00+02:00"), tz));
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.QUARTER_OF_YEAR)
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(tz).build();
        if (transition.getDateTimeBefore().getYear() < 1950) {
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.MONTH_OF_YEAR), closeTo(3.0, 0.000001));
    public void testBeforeOverlapSmall() {
     * Check a {@link Rounding.Prepared#nextRoundingValue} that was difficult
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T12:00:00.000Z")), isDate(time("2009-02-04T00:00:00.000Z"), tz));
    /**
                    + zonedDateBetween
            assertInterval(time("2015-04-05T02:00:00.000+13:45"), time("2015-04-05T03:00:00.000+13:45"), rounding, 60, tz);
                );
        // hour unit
        ZoneId tz = ZoneId.of("CET");
     */
                    + dateBetween
    public void testQuarterOfYear() {
        assertThat(tzRounding.nextRoundingValue(time("2009-02-02T19:00:00.000Z")), isDate(time("2009-02-03T01:00:00.000Z"), tz));
        assertThat(rounding.round(time("2015-10-25T03:15:00+01:00")), isDate(time("2015-10-25T03:00:00+01:00"), tz));
     */
        assertThat(rounding.round(twoHours), equalTo(twoHours));
        assertThat(
            assertInterval(time("2015-10-25T01:00:00.000+02:00"), time("2015-10-25T02:00:00.000+02:00"), rounding, 60, tz);
        assertThat(rounding.round(time("1986-01-01T00:46:00+05:45")), isDate(time("1986-01-01T00:40:00+05:45"), tz));
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();
        Rounding quarterEightRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).timeZone(ZoneOffset.of("+08:00")).build();
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();
     * test DST end with interval rounding
        );
        long end = time("2014-10-19T01:00:00.000", tz);
            "{} from {}{} to {}{}",
    public void testMillisecondsBasedUnitCalendarRoundingSize() {
            // 3 Mar 1991 - Daylight Saving Time Ended
            for (ZoneOffsetTransitionRule transitionRule : rules.getTransitionRules()) {
                    previousRoundedValue = roundedDate;
            .timeZone(ZoneId.of("Asia/Tokyo"))
        assertThat(prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.MINUTES_OF_HOUR), closeTo(60.0, 0.000001));
            // Pick an arbitrary year to end the range too
        Rounding rounding = new Rounding.TimeUnitRounding(unit, tz);
            // the interval between is 105 minutes long because the hour after transition starts at 00:15
        assertThat(rounding.round(time("2015-10-25T02:15:00+02:00")), isDate(time("2015-10-25T02:00:00+02:00"), tz));
        assertThat(tzRounding.round(time("2014-10-26T01:30:00+03:00")), isDate(time("2014-10-26T01:00:00+03:00"), tz));
    /**
                isDate(nextRoundingValue, tz)
                    );
        // to Sunday, 29 October 2000, 00:00:00 local standard time instead
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.MONTH_OF_YEAR)
 */
    }
            long floor = rounding.round(timeBeforeFirstMidnight);
            long ceiling = rounding.nextRoundingValue(timeBetweenMidnights);
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.YEAR_OF_CENTURY).timeZone(tz).build();
        assertThat(rounding.round(time("2015-10-25T02:35:00+01:00")), isDate(time("2015-10-25T02:20:00+01:00"), tz));
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.DAY_OF_MONTH),
            assertInterval(time("2015-09-27T02:00:00.000+12:45"), time("2015-09-27T04:00:00.000+13:45"), rounding, 60, tz);
            int unitCount = randomIntBetween(1, 365);
                            + unit
        long nextMidnight = time("2000-10-30T00:00:00", tz);
     */
        // Test fixed offset timezones that are not UTC
}
        if (tz.getId().equals("Antarctica/Casey")) {
                    assertThat("Rounding should be >= previous rounding value", roundedDate, greaterThanOrEqualTo(previousRoundedValue));
        }
        assertThat(plusZeroZeroRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T01:00:00.000Z"), plusZeroZeroTz));
        assertThat(rounding.round(time("2016-03-27T01:41:00+01:00")), isDate(time("2016-03-27T01:30:00+01:00"), tz));
        rounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).offset(-twoHours).build();
            ex.getMessage(),
                    );
                    + "/"
            long floor = rounding.round(timeBetweenMidnights);
            date = transition.getInstant().toEpochMilli();
        assertThat(tzRounding_chg.round(time("2013-11-03T06:01:01", chg)), isDate(time("2013-11-03T06:00:00", chg), chg));
    public void testHardNewtonsMethod() {
        // Year interval
        assertThat(time("1986-01-01T00:15:00+05:45") - time("1985-12-31T23:40:00+05:30"), equalTo(TimeUnit.MINUTES.toMillis(20)));
                }
     * chooses test dates that are exactly on or close to offset changes (e.g.
        Rounding tzRounding = Rounding.builder(TimeValue.timeValueHours(12)).timeZone(tz).build();
        tz = ZoneId.of("-02:00");
            if (rules.getTransitions().isEmpty()) {
        long interval = TimeUnit.HOURS.toMillis(12);
            // But roundings that change *at* midnight are safe because they don't "jump" to the next day.
        ZoneId tz = ZoneId.of("CET");
            .offset(3600000)
        assertThat(tzRounding.round(time("2009-02-03T13:01:01")), isDate(time("2009-02-03T08:00:00.000Z"), tz));
        }
        assertThat(rounding.round(time("2016-03-28T13:00:00+02:00")), isDate(time("2016-03-28T12:00:00+02:00"), tz));
        }
            equalTo(
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T13:00:00.000Z")), isDate(time("2009-02-03T19:00:00.000Z"), tz));
    private static long time(String time, ZoneId zone) {
    public void testTimeIntervalCET_DST_Start() {
            long interval = unit.toMillis(unitCount);
                    + "]",
            // at 02:00:00 clocks were turned forward 0:30 hours to 02:30:00
     * time can land in a DST gap which results in wrong UTC rounding values.
    public void testOtherHardNewtonsMethod() {
            int offsetNextValue = tz.getRules().getOffset(Instant.ofEpochMilli(nextRoundingValue + 1)).getTotalSeconds();
                    .appendValue(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime) + " [" + actual + "]");
            )
        // We want the overlapping hour to count for the previous day here
    public void testEdgeCasesTransition() {
        Rounding rounding = Rounding.builder(TimeValue.timeValueDays(279)).timeZone(tz).build();
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(cet).build();
    public void testNonMillisecondsBasedUnitCalendarRoundingSize() {
        }
        // Two timestamps in same year and different timezone offset ("Double buckets" issue - #9491)
    /**
        // Saturday, 31 March 1990, 23:00:00 local standard time instead
    /**
            }
                            + "]"
    }
        }
            // 29 Mar 2015 - Daylight Saving Time Started
        ZoneId tz = ZoneId.of("Asia/Baghdad");
            closeTo(3600.0, 0.000001)
                "Cannot use month-based rate unit [year] with fixed interval based histogram, "
                            + unitCount
import org.opensearch.test.OpenSearchTestCase;
                            + " in "
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).offset(twoHours).build();
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(tz).build();
import java.time.Instant;
            assertThat(floor, isDate(time("1978-10-01T00:00:00+02:00"), tz));
        ZoneId tz = ZoneId.of("CET");
        for (int i = 0; i < 100; i++) {
    }
                mainDate = nastyDate(mainDate, tz, interval);
            final long roundedDate = rounding.round(time(dates.v1()));
                        date,
                    + "histogram [hour] only week, day, hour, minute and second are supported for this histogram"
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T00:00:00.000Z"), tz));
                            + "] but instead rounded to ["
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(cet).build();
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.SECOND_OF_MINUTE),
        long interval = TimeUnit.MINUTES.toMillis(45);
    /**
    }
                    throw e;
    }
 * this file be licensed under the Apache-2.0 license or a
            ZoneId tz = randomZone();
        // This happened at 02:31 UTC, 00:01 local time, so the clocks were set back 1 hour to 23:01 on the 28th.
        ZoneId tz = ZoneId.of("Asia/Jerusalem");
        } else {
            long previousRoundedValue = Long.MIN_VALUE;
        ZoneId chg = ZoneId.of("America/Chicago");
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-09T00:00:00.000Z"), tz));
        }
            long floor = rounding.round(timeBetweenMidnights);
     * test DayIntervalRounding, (interval &gt;= 12h) with time zone shift
 * KIND, either express or implied.  See the License for the
                isDate(rounded, tz)
    }
        {
            assertThat(ceiling, isDate(time("2006-10-30T00:00:00.000-03:30"), tz));
        Rounding dayTzRounding = new Rounding.TimeIntervalRounding(60000, tz);
            long timeAfterSecondMidnight = time("1978-10-01T00:30:00+01:00");
     * that. So, we jumped back a long, long way.
        ZoneId tz = ZoneId.of("America/Detroit");
        long interval = TimeUnit.MINUTES.toMillis(20);
 *
        assertThat(tzRounding.nextRoundingValue(time("2014-03-30T01:00:00", cet)), isDate(time("2014-03-30T03:00:00", cet), cet));
        return true;
                    fail(
            } else {
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
        assertInterval(midnightBeforeTransition, nextMidnight, rounding, 25 * 60, tz);
        assertThat("rounding should be idempotent", rounding.round(rounded), isDate(rounded, tz));
                // Pick an arbitrary year to start the range
            for (ZoneOffsetTransition transition : rules.getTransitions()) {
        long dateBetween = randomLongBetween(lower, upper - 1);
            ZoneId tz = randomZone();
        long interval = TimeUnit.MINUTES.toMillis(14);
            long ceiling = rounding.nextRoundingValue(timeBetweenMidnights);
     * It rounds the test date down and up and performs various checks on the
            if (javaNextRoundingValue != esNextRoundingValue) {
                } catch (AssertionError e) {
        assertThat(rounding.round(time("1986-01-01T00:16:00+05:45")), isDate(time("1986-01-01T00:15:00+05:45"), tz));
                if (javaRounded != esRounded) {
        assertThat(tzRounding.nextRoundingValue(time("2009-02-02T02:00:00")), isDate(time("2009-02-03T02:00:00"), tz));
            nastyDate(date, tz, unitMillis);
    }
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-04-01T00:00:00.000Z"), tz));
     * special test for DST switch from #9491
        final ZoneId tz = ZoneId.of("Asia/Jerusalem");
        Rounding.Prepared prepared = unitRounding.prepare(time("2010-01-01T00:00:00.000Z"), time("2020-01-01T00:00:00.000Z"));
    private void assertInterval(long rounded, long nextRoundingValue, Rounding rounding, int minutes, ZoneId tz) {
                ZoneOffsetTransition transition = transitionRule.createTransition(year);
        );
            ZoneId tz = ZoneId.of("Australia/Lord_Howe");
        assertThat(tzRounding_utc.round(time("2014-11-02T06:01:01", chg)), isDate(time("2014-11-02T06:00:00", chg), chg));
            public boolean matchesSafely(final Long item) {
        // Sunday, 1 April 1990, 00:00:00 clocks were turned backward 1 hour to
    public void testDST_America_St_Johns() {
        assertThat(rounding.round(time("2015-10-25T02:35:00+02:00")), isDate(time("2015-10-25T02:20:00+02:00"), tz));
        long min = time("01980-01-01T00:00:00Z");
        );
            Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.HOUR_OF_DAY, tz);
     * to build well with the java.time APIs.
                            + "] but instead was to ["
        assertThat(rounding.round(time("2015-10-25T01:55:00+02:00")), isDate(time("2015-10-25T01:40:00+02:00"), tz));
     * rounding unit interval that is defined by this. Assumptions tested are
            long min = mainDate - 2 * interval;
        assertThat("values less than rounded should round further down", rounding.round(rounded - 1), lessThan(rounded));
            .offset(3600000)
        assertThat(tzRounding.round(time("2014-10-26T01:30:00+02:00")), isDate(time("2014-10-26T01:00:00+02:00"), tz));
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).build();
    /**
        // the utc date for "2014-10-25T03:00:00+03:00" and "2014-10-25T03:00:00+02:00" is the same, local time turns back 1h here
        }
                            + Instant.ofEpochMilli(date)
 * Unless required by applicable law or agreed to in writing,
            ZoneId tz = ZoneId.of("Asia/Kathmandu");
            long dateBetween = dateBetween(rounded, nextRoundingValue);
                        prepared.round(roundedDate - 1),
    public void testPrepareLongRangeRoundsNotToMidnight() {
/*
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.SECOND_OF_MINUTE),
            int year = randomFrom(firstYear, lastYear);
                long esRounded = prepared.round(date);
        long thirdQuarter = prepared.round(time("2015-07-01T00:00:00.000Z"));
     * Test that rounded values are always greater or equal to last rounded value if date is increasing.
     */
     */
            assertInterval(time("2015-09-27T01:00:00.000+12:45"), time("2015-09-27T02:00:00.000+12:45"), rounding, 60, tz);
            rounding.round(nextRoundingValue + 1),
    }
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
                    }
        // DST on
        final long roundedDate = prepared.round(date);
            Rounding aliasUnitRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneId.of(utcAlias)).build();
        return new TypeSafeMatcher<Long>() {
            }
        {
            long esNextRoundingValue = prepared.nextRoundingValue(date);
        assertFalse(nonUtcIntervalRounding.isUTC());
            || tz.getId().equals("America/Moncton")
import java.time.format.DateTimeFormatter;
        long b1 = randomDate();
                    "unit interval width not as expected for [" + unit + "], [" + tz + "] at " + Instant.ofEpochMilli(roundedDate),
     */
            Rounding.Prepared javaTimeRounding = rounding.prepareJavaTime();
            // 1 Jan 1986 - Time Zone Change (IST → NPT), at 00:00:00 clocks were turned forward 00:15 minutes
            assertThat(prevFloor, isDate(time("1978-09-30T00:00:00+02:00"), tz));
    private static boolean isTimeWithWellDefinedRounding(ZoneId tz, long t) {
        assertThat(tzRounding.round(time("2014-10-26T17:00:00", tz)), isDate(time("2014-10-26T00:00:00", tz), tz));
        // Month interval
                        + Instant.ofEpochMilli(esNextRoundingValue)
                    assertThat(
        // time zone "America/St_Johns", rounding to days.
        long interval = TimeUnit.MINUTES.toMillis(20);
            }
                        + rounding
     * test DST start with offset not fitting interval, e.g. Asia/Kathmandu
import java.time.ZoneId;
                    ZonedDateTime previousRoundedValueDate = ZonedDateTime.ofInstant(Instant.ofEpochMilli(previousRoundedValue), tz);
     * To be even more nasty, go to a transition in the selected time zone.
        {
     */
            assertThat(tzRounding.nextRoundingValue(time), greaterThan(time));
        assertThat(tzRounding.round(time("2014-03-09T03:01:01", chg)), isDate(time("2014-03-09T03:00:00", chg), chg));
            .build();
    public void testFixedIntervalRoundingSize() {
            long esRounded = prepared.round(date);
    /**
            // Only overlaps cause the array rounding to have trouble
        ex = expectThrows(
                    equalTo(unitMillis)
            ZoneId tz = ZoneId.of(zoneId);
    public void testForwardsBackwardsTimeZones() {
        assertThat(rounding.round(0), equalTo(-oneDay + twoHours));
        assertThat(rounding.withoutOffset().nextRoundingValue(0), equalTo(oneDay));
        midnightBeforeTransition = time("1990-03-31T00:00:00.000-04:00");
            assertThat(floor, isDate(time("2006-10-29T00:00:00.000-02:30"), tz));
    private static long[] randomDateBounds(Rounding.DateTimeUnit unit) {
                        + "]"
        Rounding quarterUtcRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).timeZone(ZoneOffset.of("+00:00")).build();
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.YEAR_OF_CENTURY)
                        previousRoundedValue
    }
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
            assertThat(floor, isDate(time("1978-09-30T00:00:00+02:00"), tz));
            long timeBetweenMidnights = time("2006-10-29T00:00:30.000-02:30");
        Rounding fixedOffsetRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneOffset.ofHours(3)).build();
        // Test with different datetime units
                            + unitCount
            assertInterval(time("2015-10-25T02:00:00.000+02:00"), time("2015-10-25T02:00:00.000+01:00"), rounding, 60, tz);
     */
    }
        assertThat(
            ZoneId tz = ZoneId.of("Pacific/Chatham");
        assertThat(tzRounding.nextRoundingValue(time("2009-02-05T00:00:00.000Z")), isDate(time("2009-02-07T00:00:00.000Z"), tz));
            assertThat(ceiling, isDate(time("2006-10-29T00:00:00.000-02:30"), tz));
            .build();
        // Test UTC timezone for TimeUnitRounding
            }
    }
        {
        Rounding rounding = new Rounding.TimeUnitRounding(timeUnit, tz);
    public void testIntervalRounding_NotDivisibleInteval() {
        ZoneId tz = ZoneId.of("Africa/Cairo");
            transition.getOffsetBefore(),
        assertThat(tzRounding.round(time("2014-11-11T17:00:00", tz)), isDate(time("2014-11-01T00:00:00", tz), tz));
        assertThat(rounding.round(oneDay - twoHours), equalTo(oneDay - twoHours));
    /**
        {
        Rounding tzRounding_chg = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(chg).build();
        assertThat(rounding.prepareJavaTime().nextRoundingValue(1383463147373L), isDate(time("2013-11-03T03:40:00", tz), tz));
        assertEquals(60L * 60L * 1000L, midnightOfTransition - midnightBeforeTransition);
    /**
    }
            // at 03:45:00 clocks were turned backward 1 hour to 02:45:00
 * ownership. Elasticsearch licenses this file to you under
            assertThat("nextRounding value should be greater than date" + rounding, nextRoundingValue, greaterThan(unrounded));
            TimeUnit unit = randomFrom(TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS);
                    assertThat("Rounding should be idempotent", roundedDate, equalTo(prepared.round(roundedDate)));
        Rounding.DateTimeUnit timeUnit = Rounding.DateTimeUnit.DAY_OF_MONTH;
        assertThat(tzRounding.round(time("2009-02-03T13:01:01")), isDate(time("2009-02-03T13:00:00.000Z"), tz));
        if (tz.getId().equals("America/St_Johns")
        Rounding nonUtcWithOffsetRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH)
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-10T01:00:00.000Z"), tz));
            .timeZone(ZoneOffset.UTC)
    }
        long firstQuarter = prepared.round(time("2015-01-01T00:00:00.000Z"));
        );
            closeTo(36000.0, 0.000001)
            )
        assertThat(rounding.nextRoundingValue(0), equalTo(twoHours));
        long max = time("10000-01-01T00:00:00Z");
        assertTrue(plusZeroZeroRounding.isUTC());
 * GitHub history for details.
        assertInterval(midnightBeforeTransition, nextMidnight, rounding, 25 * 60, tz);
        assertThat(
                    );
                        lessThan(roundedDate)
        Rounding rounding = Rounding.builder(TimeValue.timeValueDays(257)).timeZone(tz).build();
        return dateBetween;
     * @param rounded the expected low end of the rounding interval
            for (int d = 0; d < 100; d++) {
                            + " "
        // Test +8:00 timezone format
        );
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-10T01:01:01.000Z"), tz));
        assertFalse(fixedOffsetRounding.isUTC());
            assertThat(prevFloor, lessThan(floor));
        }
        for (Tuple<String, String> dates : expectedDates) {
        Rounding tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(ZoneOffset.ofHours(timezoneOffset)).build();
        );
 * specific language governing permissions and limitations
            }
            // check two intervals around date
                    ZonedDateTime dateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date), tz);
        ZoneId tz = ZoneOffset.ofHours(-8);
    public void testDayIntervalRounding() {
        assertThat(rounding.round(time("2020-11-01T09:00:00")), equalTo(time("2020-11-01T02:00:00")));
     */
        ZoneId tz = ZoneId.of("Atlantic/Azores");
        assertThat(tzRounding.round(time("2014-10-26T00:30:00+03:00")), isDate(time("2014-10-26T00:00:00+03:00"), tz));
        // Day of switching DST off -> on
    public void testIntervalRounding_HalfDay_DST() {
        Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.DAY_OF_MONTH, tz);
        assertThat(prepared.roundingSize(thirdQuarter, Rounding.DateTimeUnit.HOUR_OF_DAY), closeTo(2208.0, 0.000001));
        Rounding.Prepared prepared = rounding.prepare(min, max);
            closeTo(1 / 168.0, 0.000001)
                        + Instant.ofEpochMilli(javaRounded)
                            + Instant.ofEpochMilli(date)
            // Round a whole bunch of dates and make sure they line up with the known good java time implementation
        assertThat(rounding.withoutOffset().round(0), equalTo(0L));
        rounding = new Rounding.TimeUnitRounding(timeUnit, tz);
        long unitMillis = unit.getField().getBaseUnit().getDuration().toMillis();
import static org.hamcrest.Matchers.lessThan;
     * Randomized test on TimeUnitRounding. Test uses random
            assertTrue("isUTC() should be true for ZoneId.of(\"" + utcAlias + "\") TimeUnitRounding", aliasUnitRounding.isUTC());
                            + "] to ["
        {
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-01T00:00:00.000Z"), tz));
        assertEquals(TimeUnit.MINUTES.toMillis(60), time("2011-10-30T02:15:00.000+01:00") - time("2011-10-30T02:15:00.000+02:00"));
                assertThat(
    /**
    }
 * Modifications Copyright OpenSearch Contributors. See
            assertInterval(time("2015-03-29T00:00:00.000+01:00"), time("2015-03-29T01:00:00.000+01:00"), rounding, 60, tz);
        assert lower <= dateBetween && dateBetween < upper;
        }
            // at 02:00:00 clocks were turned forward 1 hour to 03:00:00
        );
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.MONTH_OF_YEAR)
 * You may obtain a copy of the License at
        expectedDates.add(new Tuple<>("2011-10-30T01:40:00.000+02:00", "2011-10-30T01:30:00.000+02:00"));
                firstYear = 1999;
        assertEquals(TimeUnit.MINUTES.toMillis(45), time("2011-10-30T03:00:00.000+01:00") - time("2011-10-30T02:15:00.000+01:00"));
            tzRounding.nextRoundingValue(0L - TimeValue.timeValueHours(24 + timezoneOffset).millis()),
     * adding 15min on 1986-01-01T00:00:00 the interval from
        // Test UTC timezone for TimeIntervalRounding
    /**
                "dateBetween [" + zonedDateBetween + "] should round up to nextRoundingValue",
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(tz).build();
     * DST) in the chosen time zone.
        long date = dateBetween(start, end);
import static org.hamcrest.Matchers.greaterThan;
            long floor = rounding.round(timeBetweenMidnights);
        expectedDates.add(new Tuple<>("2011-10-30T02:55:00.000+01:00", "2011-10-30T02:15:00.000+01:00"));
     */
            if (javaRounded != esRounded) {
            Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.HOUR_OF_DAY, tz);
        assertThat(tzRounding.nextRoundingValue(0L), equalTo(TimeValue.timeValueHours(1L).getMillis()));
                        + "] to ["
                "dateBetween ["
import org.opensearch.common.unit.TimeValue;
        assertEquals(TimeUnit.MINUTES.toMillis(45), time("2011-10-30T02:15:00.000+02:00") - time("2011-10-30T01:30:00.000+02:00"));
    public void testTimeRounding() {
        // Test additional timezone formats for completeness
        assertThat(prepared.roundingSize(thirdQuarter, Rounding.DateTimeUnit.DAY_OF_MONTH), closeTo(92.0, 0.000001));
        ZoneId minusFiveTz = ZoneOffset.of("-05:00");
        assertThat(rounding.round(time("2016-03-27T01:59:00+01:00")), isDate(time("2016-03-27T01:58:00+01:00"), tz));
            assertInterval(time("1985-12-31T23:00:00.000+05:30"), time("1986-01-01T01:00:00.000+05:45"), rounding, 105, tz);
import org.hamcrest.Description;
                        + Instant.ofEpochMilli(esRounded)
        assertThat(rounding.round(time("2016-03-27T03:35:00+02:00")), isDate(time("2016-03-27T03:20:00+02:00"), tz));
         * to QUARTER_OF_YEAR properly.
            long roundingDateBetween = rounding.round(dateBetween);
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.YEAR_OF_CENTURY)
        return DateFormatters.from(accessor).toInstant().toEpochMilli();
            // 25 Oct 2015 - Daylight Saving Time Ended
            assertInterval(time("1991-10-27T00:00:00.000+10:30"), time("1991-10-27T01:00:00.000+10:30"), rounding, 60, tz);
        // Test non-UTC timezone for TimeUnitRounding
                        + Instant.ofEpochMilli(date)
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.SECOND_OF_MINUTE).build();
        }
                            + Instant.ofEpochMilli(esRounded)
            ex.getMessage(),
        // Real interval based
            long timeBeforeFirstMidnight = time("2006-10-28T23:30:00.000-02:30");
        long next = rounding.prepareForUnknown().nextRoundingValue(rounded);
    public void testTimeIntervalCET_DST_End() {
            int firstYear;
     */
            return;
import static org.hamcrest.Matchers.closeTo;
        // Day interval
            long max = mainDate + 2 * interval;
                            + "] to round ["
            closeTo(600.0, 0.000001)
                fail(
        // test DST start
            protected void describeMismatchSafely(final Long actual, final Description mismatchDescription) {
     * test for #10025, strict local to UTC conversion can cause joda exceptions
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.MINUTES_OF_HOUR),
        }
    public void testIntervalBeforeGap() {
        long twoHours = TimeUnit.HOURS.toMillis(2);
                mismatchDescription.appendText(" was ")
        rounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(ZoneId.of("America/New_York")).offset(-twoHours).build();
     * {@link #assertInterval(long, long, long, Rounding, ZoneId)}
            // at 02:45:00 clocks were turned forward 1 hour to 03:45:00
     */
        // DST on
            );
                }
        // Test ZoneRegion aliases that normalized() converts to ZoneOffset.UTC
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-01T00:00:00.000Z"), tz));
            assertThat(ceiling, isDate(time("2006-10-30T00:00:00.000-03:30"), tz));
            // Times after the second midnight should be rounded down to the first midnight.
    /**
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-09T01:00:00.000Z"), tz));
        assertThat(tzRounding.round(time("2009-02-03T00:01:01")), isDate(time("2009-02-02T20:00:00.000Z"), tz));
            long timeBeforeFirstMidnight = time("1978-09-30T23:59:00+02:00");
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.YEAR_OF_CENTURY).build();
            public void describeTo(Description description) {
        }
import java.util.List;
import org.hamcrest.Matcher;
        for (long time = start; time < end; time = time + 60000) {
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-10T00:00:00.000Z"), tz));
     * 1986-01-01T00:15:00+05:45 to 1986-01-01T00:20:00+05:45 to only be 5min
        ZoneId tz = ZoneId.of("CET");
        tzRounding = Rounding.builder(TimeValue.timeValueHours(48)).build();
        if (tz.getId().equals("Pacific/Guam") || tz.getId().equals("Pacific/Saipan")) {
            previousDate = roundedDate;
        if (transition.getDateTimeBefore().getDayOfMonth() == transition.getDateTimeAfter().getDayOfMonth()) {
        long max = time("10000-01-01T00:00:00Z");
        ZoneId tz = ZoneOffset.ofHours(-1);
        assertThat(rounding.round(time("2016-03-27T03:15:00+02:00")), isDate(time("2016-03-27T03:00:00+02:00"), tz));
                        assertThat(
    }
    public void testIsUTC() {
 *
    /**
             * in the tests far below we call round(round(min)). The first
            // 27 Oct 1991 - Daylight Saving Time Started
        long previousDate = Long.MIN_VALUE;
     * Example of when we round past when local clocks were wound backwards,
 * not use this file except in compliance with the License.
     * Check a {@link Rounding.Prepared#nextRoundingValue} that was difficult
    }
        assertThat(quarterEightRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-01-01T00:00:00.000+08:00"), plusEightTz));
                            + "] and nextRoundingValue to be ["
        assertThat(next, greaterThan(rounded));
                ZoneOffsetTransition lastTransition = rules.getTransitions().get(rules.getTransitions().size() - 1);
            // which is not a round value for hourly rounding
                        "Rounding error at {}/{}, timezone {}, interval: {} previousRoundedValue {}/{}",
        ZoneId tz = ZoneId.of("-08:00");
    /**
    }
        // Round a whole bunch of dates and make sure they line up with the known good java time implementation
            // hour rounding is stable before 1985-12-31T23:00:00.000 and after 1986-01-01T01:00:00.000+05:45
 * under the License.
 * software distributed under the License is distributed on an
        ZoneId tz = ZoneId.of("America/New_York");
        assertThat(prepared.round(time("9000-03-31T15:25:15.148Z")), isDate(time("9000-03-31T15:00:00Z"), tz));
    public void testLenientConversionDST() {
            tz,
                        + Instant.ofEpochMilli(javaNextRoundingValue)
            int offsetRounded = tz.getRules().getOffset(Instant.ofEpochMilli(roundedDate - 1)).getTotalSeconds();
            equalTo(
 */
        long rounded = rounding.prepareForUnknown().round(877824908400L);
        expectedDates.add(new Tuple<>("2011-10-30T02:25:00.000+02:00", "2011-10-30T02:15:00.000+02:00"));
            // Times between the two midnights which are on the earlier day should be rounded down to the earlier day's midnight.
            long javaNextRoundingValue = javaTimeRounding.nextRoundingValue(date);
    }
            return;
                        + "] to round ["
            ZoneRules rules = tz.getRules();
                    + "only week, day, hour, minute and second are supported for this histogram"
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
     * @param nextRoundingValue the expected upper end of the rounding interval
        long start = time("2014-10-18T20:50:00.000", tz);
        Rounding.Prepared prepared = rounding.prepare(start, end);
    /**
                roundingDateBetween,
        assertThat(rounding.round(time("9000-12-31T13:21:44.308Z")), isDate(time("9000-10-01T04:00:00Z"), tz));
        ZoneId tz = ZoneId.of("Australia/Lord_Howe");
        // testing savings to non savings switch 2014 (America/Chicago)
        assertThat(tzRounding.round(time("2014-08-11T17:00:00", tz)), isDate(time("2014-08-11T00:00:00", tz), tz));
                long date = dateBetween(min, max);
     */
import java.util.concurrent.TimeUnit;
        Rounding rounding = new Rounding.TimeIntervalRounding(19800000, tz);
                    fail(
                "Cannot use month-based rate unit [quarter] with non-month based calendar interval "
        // here's what this means for interval widths
        assertInterval(rounded, dateBetween(rounded, nextRoundingValue), nextRoundingValue, rounding, tz);
    /**
        Rounding nonUtcIntervalRounding = Rounding.builder(TimeValue.timeValueHours(2)).timeZone(ZoneId.of("Europe/Berlin")).build();
            IllegalArgumentException.class,
        /*
        }
    }
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.HOUR_OF_DAY), closeTo(2160.0, 0.000001));
            if (offsetRounded == offsetNextValue) {
     */
                            + tz
        assertThat(plusEightRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T01:00:00.000Z"), plusEightTz));
                        + Instant.ofEpochMilli(esRounded)
            }
            // Clocks went back at 00:01 between 1987 and 2010, causing overlapping days.
            millisSinceEpoch + twoHours
        long oneDay = TimeUnit.DAYS.toMillis(1);
        assertThat(tzRounding.round(0), equalTo(0L - TimeValue.timeValueHours(24 + timezoneOffset).millis()));
import java.time.zone.ZoneOffsetTransitionRule;
        Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.DAY_OF_MONTH, tz);
        // Second case, dst happens at 0am local time, switching back one hour to 23pm local time.
        for (int i = 0; i < 1000; ++i) {
        // check correct unit interval width for units smaller than a day, they should be fixed size except for transitions
    }
        assertFalse(plusEightRounding.isUTC());
            assertInterval(time("1991-10-27T01:00:00.000+10:30"), time("1991-10-27T03:00:00.000+11:00"), rounding, 90, tz);
            assertThat(floor, isDate(time("2006-10-28T00:00:00.000-02:30"), tz));
            }
     */
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.MONTH_OF_YEAR).timeZone(tz).build();
 * The OpenSearch Contributors require contributions made to
        assertThat(rounding.round(time("1985-12-31T23:55:00+05:30")), isDate(time("1985-12-31T23:40:00+05:30"), tz));
        Rounding emptyTzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).build();
            assertInterval(time("1986-01-01T01:00:00.000+05:45"), time("1986-01-01T02:00:00.000+05:45"), rounding, 60, tz);
    public void testDST_Europe_Rome() {
    }
 */
            assertThat(
        // testing savings to non savings switch 2013 (America/Chicago)
            long timeBetweenMidnights = time("2006-10-28T23:30:00.000-03:30");
        ex = expectThrows(
            @Override
        assertUnitRoundingSameAsJavaUtilTimeImplementation(
        assertThat(rounding.round(time("2006-12-31T13:21:44.308Z")), isDate(time("2006-10-01T04:00:00Z"), tz));
             * range just in case.
     * @param unrounded a date in the interval to be checked for rounding
            }
        for (int d = 0; d < 1000; d++) {
            return date + (randomLong() % unitMillis);  // positive and negative offset possible
    public void testIntervalTwoTransitions() {
        );
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR).build();
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.MINUTES_OF_HOUR).build();
    public void testTimezoneFormats() {
import java.time.zone.ZoneRules;
    public void testAmbiguousHoursAfterDSTSwitch() {
                    );
                    + "only week, day, hour, minute and second are supported for this histogram"
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.QUARTER_OF_YEAR), closeTo(1.0, 0.000001));
package org.opensearch.common;
         */
        assertThat(tzRounding_chg.round(time("2014-11-02T06:01:01", chg)), isDate(time("2014-11-02T06:00:00", chg), chg));
        assertThat(rounding.round(time("2016-03-27T01:00:00+01:00")), isDate(time("2016-03-27T00:00:00+01:00"), tz));
                    nextRoundingValue - roundedDate,
                        tz,
         * If we're not careful with how we look up local time offsets we can
                            + " in "
                        "Expected ["
            return t <= time("1987-10-01T00:00:00Z") || t >= time("2010-12-01T00:00:00Z");
        logger.info(
        assertThat(prepared.round(time("9000-12-31T13:21:44.308Z")), isDate(time("9000-10-01T04:00:00Z"), tz));
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.YEAR_OF_CENTURY).timeZone(tz).build();
        ZoneOffsetTransition transition = timezone.getRules().nextTransition(Instant.ofEpochMilli(initialDate));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    logger.error(
            assertInterval(time("2015-03-29T03:00:00.000+02:00"), time("2015-03-29T04:00:00.000+02:00"), rounding, 60, tz);
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-16T00:00:00.000Z"), tz));
        Rounding minusFiveRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(ZoneOffset.of("-05:00")).build();
            .build();
        ex = expectThrows(
        assertThat(rounding.round(time("2016-03-27T01:51:00+01:00")), isDate(time("2016-03-27T01:44:00+01:00"), tz));
                            + Instant.ofEpochMilli(javaNextRoundingValue)
            return;
        if (transition != null) {
            ex.getMessage(),
                            equalTo(interval)
                        dateTime,
     * described in
    public void testUTCTimeUnitRounding() {
            long ceiling = rounding.nextRoundingValue(timeAfterSecondMidnight);
                        "Expected ["
        assertThat(tzRounding.round(time("2014-11-11T17:00:00", tz)), isDate(time("2014-11-11T00:00:00", tz), tz));
     * to build well with the java.time APIs.
            ex.getMessage(),
        }
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();
        // Moncton has a perfectly normal hour long Daylight Savings time.
        // date in Feb-3rd, also in -02:00 timezone
    private void checkForForwardsBackwardsTransition(ZoneId tz, ZoneOffsetTransition transition) {
    }
        }
        expectedDates.add(new Tuple<>("2011-10-30T02:10:00.000+01:00", "2011-10-30T02:15:00.000+02:00"));
                    if (tz.getRules().isFixedOffset()) {
        assertThat(
            .timeZone(ZoneId.of("America/New_York"))
                        + "] but instead rounded to ["
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T02:00:00")), isDate(time("2009-02-04T02:00:00"), tz));
                        interval,
        // Only the first of these is considered "rounded". Moreover, the extra time between 23:01 and 23:59
        if (transition.getDateTimeBefore().getMinute() == 0) {
        {
        Rounding utcWithOffsetRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH)
        assertInterval(midnightAfterTransition, nextMidnight, rounding, 24 * 60, tz);
            long prevFloor = rounding.round(floor - 1);
        Rounding.Prepared javaTimeRounding = rounding.prepareJavaTime();
                ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(actual), tz);
    }
        long midnightOfTransition = time("2000-10-29T00:00:00-01:00");
            assertInterval(time("2015-04-05T03:00:00.000+13:45"), time("2015-04-05T03:00:00.000+12:45"), rounding, 60, tz);
                        );
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();
        // Test non-UTC timezone for TimeIntervalRounding
            // standard +/-1 hour DST transition, CET
            ZonedDateTime zonedDateBetween = ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateBetween), tz);
        long min = time("01980-01-01T00:00:00Z");
                    + "only week, day, hour, minute and second are supported for this histogram"
        assertThat(rounding.round(time("2016-03-27T03:05:00+02:00")), isDate(time("2016-03-27T03:00:00+02:00"), tz));
            assertInterval(time("1985-12-31T22:00:00.000+05:30"), time("1985-12-31T23:00:00.000+05:30"), rounding, 60, tz);
        assertThat(tzRounding.nextRoundingValue(time("2009-02-01T00:00:00.000Z")), isDate(time("2009-03-01T00:00:00.000Z"), tz));
    }
    }
import java.time.zone.ZoneOffsetTransition;
                try {
    /**
        // First case, dst happens at 1am local time, switching back one hour.
        assertThat(tzRounding.nextRoundingValue(time("2009-02-02T20:00:00.000Z")), isDate(time("2009-02-03T08:00:00.000Z"), tz));
        assertThat(
import java.time.ZonedDateTime;
        assertThat(rounding.round(time("2018-03-31T15:25:15.148Z")), isDate(time("2018-03-31T14:00:00Z"), tz));
            if (randomBoolean()) {
        assertThat(rounding.nextRoundingValue(-oneDay), equalTo(-twoHours));
        Rounding unitRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).build();
    private static Matcher<Long> isDate(final long expected, ZoneId tz) {
        assertThat("rounded value smaller or equal than unrounded", rounded, lessThanOrEqualTo(unrounded));
    /**
        ZoneId tz = ZoneId.of("Europe/Rome");
     * {@link org.opensearch.common.Rounding.DateTimeUnit} and {@link ZoneId} and often (50% of the time)
                );
        );
        assertThat(rounding.round(time("1982-11-10T02:51:22.662Z")), isDate(time("1982-03-23T05:00:00Z"), tz));
    }
            // at 02:00:00 clocks were turned backward 0:30 hours to Sunday, 3 March 1991, 01:30:00
        ZoneId tz = ZoneOffset.UTC;
        assertThat(
        ZoneId tz = ZoneId.of("Australia/Lord_Howe");
                            + unit
            long ceiling = rounding.nextRoundingValue(timeBeforeFirstMidnight);
 * license agreements. See the NOTICE file distributed with
            assertInterval(time("2015-04-05T03:00:00.000+12:45"), time("2015-04-05T04:00:00.000+12:45"), rounding, 60, tz);
            // at 03:00:00 clocks were turned backward 1 hour to 02:00:00
        );
            equalTo(TimeValue.timeValueHours(-timezoneOffset).millis())
        // date in Feb-3rd, but still in Feb-2nd in -02:00 timezone
     */
        long next = rounding.prepareJavaTime().nextRoundingValue(rounded);
            // (this is halfway through the last minute before the clocks changed, in which local time was ambiguous)
        Rounding tzRounding = Rounding.builder(TimeValue.timeValueHours(6)).timeZone(tz).build();
        assertThat(minusFiveRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-02T05:00:00.000Z"), minusFiveTz));
            assertInterval(time("2015-09-27T04:00:00.000+13:45"), time("2015-09-27T05:00:00.000+13:45"), rounding, 60, tz);
            long timeAfterSecondMidnight = time("2006-10-29T06:00:00.000-03:30");
     */
                );
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(tz).build();
        // This means that 2006-10-29 has _two_ midnights, one in the -02:30 offset and one in the -03:30 offset.
            }
    }
            return;
            "values above nextRounding should round down there",
        assertThat(
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        ZoneId plusZeroZeroTz = ZoneOffset.of("+00:00");
             * Prepare a rounding with one extra interval of range because
            ex.getMessage(),
            assertTrue("isUTC() should be true for ZoneId.of(\"" + utcAlias + "\") TimeIntervalRounding", aliasIntervalRounding.isUTC());
        Rounding plusZeroZeroRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneOffset.of("+00:00")).build();
    }
     * CET: 25 October 2015, 03:00:00 clocks were turned backward 1 hour to 25 October 2015, 02:00:00 local standard time
        {
    public void testDayRounding() {
    }
            || tz.getId().equals("Canada/Newfoundland")) {
            assertInterval(time("2015-03-29T01:00:00.000+01:00"), time("2015-03-29T03:00:00.000+02:00"), rounding, 60, tz);
        }
            // the interval containing the switch time is 90 minutes long
            transition.getDateTimeBefore(),
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
 *
        ZoneId tz = ZoneOffset.ofHours(-2);
        assertThat(tzRounding.round(0), equalTo(0L));
                    + "histogram [hour] only week, day, hour, minute and second are supported for this histogram"
     * Test for a time zone whose days overlap because the clocks are set back across midnight at the end of DST.
        assertTrue(utcUnitRounding.isUTC());
            IllegalArgumentException.class,
     * perform a number on assertions and checks on {@link org.opensearch.common.Rounding.TimeUnitRounding} intervals
        for (String utcAlias : new String[] { "UTC", "Etc/UTC", "+00:00", "Z" }) {
            Rounding aliasIntervalRounding = Rounding.builder(TimeValue.timeValueHours(2)).timeZone(ZoneId.of(utcAlias)).build();
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T01:00:00"), tz));
                checkForForwardsBackwardsTransition(tz, transition);
        assertThat(rounding.withoutOffset().nextRoundingValue(0), equalTo(oneDay));
        );
        assertThat(tzRounding.round(time("2012-04-01T04:15:30Z")), equalTo(time("2012-03-01T08:00:00Z")));
        if (isTimeWithWellDefinedRounding(tz, unrounded)) {
            // if the interval defined didn't cross timezone offset transition, it should cover unitMillis width
                            + Instant.ofEpochMilli(esNextRoundingValue)
             * daylight savings time transition. So we request an extra big
        assertThat(time("1986-01-01T00:20:00+05:45") - time("1986-01-01T00:15:00+05:45"), equalTo(TimeUnit.MINUTES.toMillis(5)));
                    final long nextRoundingValue = prepared.nextRoundingValue(roundedDate);
                            "NextRounding value should be interval from rounded value",
     * In this case, when interval crosses DST transition point, rounding in local
        assertThat(tzRounding_chg.round(time("2014-03-09T03:01:01", chg)), isDate(time("2014-03-09T03:00:00", chg), chg));
        // Test ZoneOffset.UTC specifically
        }
            closeTo(10.0 / 24.0, 0.000001)
        assertThat(emptyTzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T01:00:00.000Z"), emptyTz));
                    "Expected ["
    public void testRandomTimeIntervalRounding() {
        if (b1 < b2) {
        Rounding tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();
    }
                    assertThat("Rounded value smaller or equal than unrounded", roundedDate, lessThanOrEqualTo(date));
    /**
            // time zone "Asia/Kathmandu"
            long floor = rounding.round(timeBeforeFirstMidnight);
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(rounding.nextRoundingValue(0), equalTo(oneDay - twoHours));
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.DAY_OF_MONTH), closeTo(90.0, 0.000001));
        assertThat(tzRounding.nextRoundingValue(time("2014-10-26T01:00:00", cet)), isDate(time("2014-10-26T02:00:00+02:00"), cet));
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
        assertThat(prepared.round(time("2006-12-31T13:21:44.308Z")), isDate(time("2006-10-01T04:00:00Z"), tz));
        }
            assertInterval(floor, timeBetweenMidnights, ceiling, rounding, tz);
import org.opensearch.common.time.DateFormatters;
            // time zone "Australia/Lord_Howe"
        assertThat(tzRounding.round(time("2009-02-05T13:01:01")), isDate(time("2009-02-05T00:00:00.000Z"), tz));
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T08:00:00.000Z")), isDate(time("2009-02-03T20:00:00.000Z"), tz));
        {
        ZoneId tz = ZoneId.of("America/Sao_Paulo");
            int lastYear = 2050;
    }
        assertThat(rounding.round(time("2016-03-27T01:55:00+01:00")), isDate(time("2016-03-27T01:40:00+01:00"), tz));
    public void testIntervalRoundingMonotonic_CET() {
        Rounding tzRounding = Rounding.builder(TimeValue.timeValueHours(12)).build();
            // We don't support transitions far in the past at all
                description.appendText(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime) + " [" + expected + "] ");
        int timezoneOffset = -2;
        assertThat(rounding.round(time("2015-10-25T02:55:00+02:00")), isDate(time("2015-10-25T02:40:00+02:00"), tz));
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T01:00:00")), isDate(time("2009-02-03T02:00:00"), tz));
     */
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).build();
        assertTrue(zoneOffsetUtcRounding.isUTC());
        Rounding.Prepared prepared = unitRounding.prepare(time("2010-01-01T00:00:00.000Z"), time("2020-01-01T00:00:00.000Z"));
        assertThat(rounding.round(time("2016-03-27T03:12:00+02:00")), isDate(time("2016-03-27T03:08:00+02:00"), tz));
            assertThat(dates.toString(), roundedDate, greaterThanOrEqualTo(previousDate));
            assertThat(dates.toString(), roundedDate, isDate(time(dates.v2()), tz));
            IllegalArgumentException.class,
import org.opensearch.common.time.DateFormatter;
        Rounding.Prepared prepared = rounding.prepare(min, max);
            IllegalArgumentException.class,
        expectedDates.add(new Tuple<>("2011-10-30T03:17:30.000+01:00", "2011-10-30T03:00:00.000+01:00"));
        Rounding tzRounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.MINUTES_OF_HOUR, tz);
            // Times between the two midnights which are on the later day should be rounded down to the later day's midnight.
        // testing non savings to savings switch
        );
     */
                    assertThat("NextRounding value rounds to itself", nextRoundingValue, isDate(rounding.round(nextRoundingValue), tz));
                            + "] to ["
             */
            equalTo(
        }
        long midnightBeforeTransition = time("2000-10-29T00:00:00", tz);
        // FIXME this was copy pasted from the other impl and not used. breaks the nasty date actually gets assigned
                return expected == item;
                            + Instant.ofEpochMilli(esRounded)
            }
                            nextRoundingValue - roundedDate,
    private void assertUnitRoundingSameAsJavaUtilTimeImplementation(Rounding.DateTimeUnit unit, ZoneId tz, long start, long end) {
        // Test UTC timezone with offset
        assertThat("nextRounding value should be a rounded date", rounding.round(nextRoundingValue), isDate(nextRoundingValue, tz));
        Rounding unitRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).build();
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).timeZone(tz).build();
            }
     * to build well our janky Newton's Method/binary search hybrid.
            )
        /*
        }
     * from one back to the previous day. Usually these rounding start before
    }
        assertThat(rounding.nextRoundingValue(-oneDay), equalTo(-oneDay + twoHours));
        ZoneId tz = ZoneId.of("Asia/Kathmandu");
                    + Instant.ofEpochMilli(roundingDateBetween)
        }
        ZoneId tz = ZoneId.of("America/Glace_Bay");
import java.util.ArrayList;
     */
 * SPDX-License-Identifier: Apache-2.0
    }
        long midnightAfterTransition = time("1990-04-01T00:00:00.000-05:00");
                            + "] to round ["
            assertInterval(time("1991-03-03T01:00:00.000+11:00"), time("1991-03-03T02:00:00.000+10:30"), rounding, 90, tz);
     * tests for dst transition with overlaps and day roundings.
                        + Instant.ofEpochMilli(date)
        if (randomBoolean()) {
        assertThat(
        }
            );
        assertThat(tzRounding.round(time("2009-02-03T13:01:01")), isDate(time("2009-02-03T12:00:00.000Z"), tz));
/*
            long javaRounded = javaTimeRounding.round(date);
        assertThat(tzRounding.round(time("2014-03-30T01:01:01", cet)), isDate(time("2014-03-30T01:00:00+01:00"), cet));
                ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(expected), tz);
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-10T00:00:00.000Z"), tz));
        assertThat(rounding.round(time("2003-10-26T03:43:35.079Z")), isDate(time("2003-10-26T03:00:00Z"), tz));
            assertThat(floor, isDate(time("1978-10-01T00:00:00+02:00"), tz));
    }
        );
     * Check a {@link Rounding.Prepared#nextRoundingValue} that was difficult
        expectedDates.add(new Tuple<>("2011-10-30T02:47:30.000+02:00", "2011-10-30T02:15:00.000+02:00"));
        assertThat(tzRounding.round(time("2009-02-03T02:01:01")), isDate(time("2009-02-03T02:00:00"), tz));
        assertThat(rounding.round(time("2016-03-26T13:00:00+01:00")), isDate(time("2016-03-26T12:00:00+01:00"), tz));
        }
     * <p>
        long twoHours = TimeUnit.HOURS.toMillis(2);
        {
        // testing non savings to savings switch (America/Chicago)
 * compatible open source license.
        // 29 October 2006 - Daylight Saving Time ended, changing the UTC offset from -02:30 to -03:30.
     * Example of when we round past when local clocks were wound forward.
         * end up not loading the offsets far enough back to round this time
        );
        // after DST shift
        // time zone "Europe/Rome", rounding to days. Rome had two midnights on the day the clocks went back in 1978, and
                if (javaNextRoundingValue != esNextRoundingValue) {
                        previousRoundedValueDate,
        assertThat(rounding.round(time("9000-03-31T15:25:15.148Z")), isDate(time("9000-03-31T15:00:00Z"), tz));
            equalTo(
            transition.getDateTimeAfter(),
            // Times before the first midnight should be rounded up to the first midnight.
    public void testUTCIntervalRounding() {
                "Cannot use month-based rate unit [quarter] with fixed interval based histogram, "
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2013-01-01T00:00:00.000Z"), tz));
        if (false == transition.isOverlap()) {
    public void testOtherHardNextRoundingValue() {
        assertThat(prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.HOUR_OF_DAY), closeTo(1.0, 0.000001));
    public void testRandomTimeUnitRounding() {
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-01T00:00:00.000Z"), tz));
        return new long[] { b2, b1 };
    public void testOffsetRounding() {
        assertThat(rounding.round(time("2016-03-27T02:00:00+01:00")), isDate(time("2016-03-27T03:00:00+02:00"), tz));
        long date = initialDate;
     */
        }
     * In one third of the cases stay there, otherwise go half a unit back or forth
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.SECOND_OF_MINUTE), closeTo(7776000.0, 0.000001));
        assertThat(
            long floor = rounding.round(timeAfterSecondMidnight);
            assertThat(
            assertThat(floor, isDate(time("2006-10-28T00:00:00.000-02:30"), tz));
        Rounding nonUtcUnitRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR)
        }
            // (this is halfway through the hour after the clocks changed, in which local time was ambiguous)
        assertThat(rounding.withoutOffset().round(0), equalTo(0L));
                }
        assertThat(rounding.prepareJavaTime().nextRoundingValue(1824929914182L), isDate(time("2027-10-31T01:30:00", tz), tz));
        if (unitMillis <= 86400 * 1000) {
        Rounding rounding = new Rounding.TimeIntervalRounding(480000, ZoneId.of("Portugal"));
        assertFalse(nonUtcWithOffsetRounding.isUTC());
        assertThat(rounding.round(time("2016-03-27T03:25:00+02:00")), isDate(time("2016-03-27T03:22:00+02:00"), tz));
            return t <= time("2010-03-03T00:00:00Z") || t >= time("2010-03-07T00:00:00Z");
                    final long roundedDate = rounding.round(date);
        long millisPerMinute = 60_000;
            assertInterval(time("1991-03-03T00:00:00.000+11:00"), time("1991-03-03T01:00:00.000+11:00"), rounding, 60, tz);
        Rounding tzRounding;
    }
            Rounding.DateTimeUnit unit = randomFrom(Rounding.DateTimeUnit.values());
            long timeBetweenMidnights = time("1978-10-01T00:30:00+02:00");
        nextMidnight = time("1990-04-01T00:00:00.000-05:00");
        if (randomBoolean()) {
        assertThat(tzRounding.round(time("2015-03-27T17:00:00", tz)), isDate(time("2015-03-27T00:00:00", tz), tz));
            assertInterval(floor, timeBeforeFirstMidnight, ceiling, rounding, tz);
        Rounding utcIntervalRounding = Rounding.builder(TimeValue.timeValueHours(2)).build();
        assertThat(rounding.round(time("1986-01-01T00:26:00+05:45")), isDate(time("1986-01-01T00:20:00+05:45"), tz));
        for (String zoneId : JAVA_ZONE_IDS) {
     * <strong>and</strong> then past the time they were wound forwards before
        );
        assertThat(rounding.round(time("2015-10-25T02:55:00+01:00")), isDate(time("2015-10-25T02:40:00+01:00"), tz));
        assertTrue(utcWithOffsetRounding.isUTC());
            return date;
        assertThat(
    private static long randomDate() {
    public void testTimeInterval_Kathmandu_DST_Start() {
        expectedDates.add(new Tuple<>("2011-10-30T02:02:30.000+02:00", "2011-10-30T01:30:00.000+02:00"));
    }
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.DAY_OF_MONTH),
    }
            // 27 Sep 2015 - Daylight Saving Time Started
            return t <= time("1969-01-25T00:00:00Z") || t >= time("1969-01-26T00:00:00Z");
        assertThat(rounding.round(0), equalTo(-twoHours));
        Rounding tzRounding_utc = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneOffset.UTC).build();
                firstYear = lastTransition.getDateTimeAfter().getYear() + 1;
        assertThat(tzRounding.nextRoundingValue(time("2014-03-30T03:00:00", cet)), isDate(time("2014-03-30T04:00:00", cet), cet));
     * Special test for intervals that don't fit evenly into rounding interval.
import java.time.ZoneOffset;
     * Check a {@link Rounding.Prepared#nextRoundingValue} that was difficult
    /**
        // Ratio based
            date = dateBetween(start, end);
    }
                            + tz
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
        // Test empty timezone (should default to UTC)
    public void testTimeUnitRoundingDST() {
            equalTo(
            assertInterval(floor, timeAfterSecondMidnight, ceiling, rounding, tz);
        ex = expectThrows(
     */
                        + "] and nextRoundingValue to be ["
        assertThat(rounding.round(time("2016-03-26T01:00:00+01:00")), isDate(time("2016-03-26T00:00:00+01:00"), tz));
            closeTo(10.0 / 168.0, 0.000001)
            transition.getOffsetAfter()
                            + Instant.ofEpochMilli(javaRounded)
        assertThat(tzRounding.round(time("2014-11-11T17:00:00", tz)), isDate(time("2014-01-01T00:00:00", tz), tz));
     * Test for half day rounding intervals scrossing DST.
    }
            )
        assertTrue(emptyTzRounding.isUTC());
        // timeZone.convertLocalToUTC() gives the later of the two because Rome is east of UTC, whereas we want the earlier.
     * on DST start
         * so we round HOUR_OF_DAY differently.
        assertThat(next, greaterThan(rounded));
     * @param rounding the rounding instance
        ZoneId cet = ZoneId.of("CET");
            )
            return new long[] { b1, b2 };
 * this work for additional information regarding copyright
            assertThat(ceiling, isDate(time("2006-10-29T00:00:00.000-02:30"), tz));
        assertEquals(millisPerMinute * minutes, nextRoundingValue - rounded);
        assertThat(
        assertThat(quarterUtcRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-01-01T00:00:00.000Z"), plusZeroZeroTz));
     * long
         */
        expectedDates.add(new Tuple<>("2011-10-30T02:32:30.000+01:00", "2011-10-30T02:15:00.000+01:00"));
                "Cannot use month-based rate unit [month] with non-month based calendar interval "
    }
                "Cannot use month-based rate unit [month] with fixed interval based histogram, "
            // Clocks went back at 00:01 in 1969, causing overlapping days.
            Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.HOUR_OF_DAY, tz);
                    assertThat("NextRounding value should be greater than date", nextRoundingValue, greaterThan(roundedDate));
            ZoneId tz = ZoneId.of("CET");
        assertThat(rounding.round(time("1969-07-08T09:00:14.599Z")), isDate(time("1969-04-18T22:00:00Z"), tz));
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T00:00:00.000Z")), isDate(time("2009-02-05T00:00:00.000Z"), tz));
            assertInterval(time("2015-10-25T02:00:00.000+01:00"), time("2015-10-25T03:00:00.000+01:00"), rounding, 60, tz);
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-09T00:00:01.000Z"), tz));
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).timeZone(tz).build();
    }
            assertInterval(time("1991-10-27T03:00:00.000+11:00"), time("1991-10-27T04:00:00.000+11:00"), rounding, 60, tz);
        assertThat(prepared.round(time("2018-03-31T15:25:15.148Z")), isDate(time("2018-03-31T14:00:00Z"), tz));
                            + "]"
        // testing savings to non savings switch
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.QUARTER_OF_YEAR)
        // We want the overlapping hour to count for the next day, making it a 25h interval
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-02T02:00:00"), tz));
        IllegalArgumentException ex = expectThrows(
        assertThat(tzRounding.nextRoundingValue(time("2014-10-26T02:00:00", cet)), isDate(time("2014-10-26T02:00:00+01:00"), cet));
                        + "] to round ["
        }
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-09T00:01:00.000Z"), tz));
        );
        assertInterval(roundedDate, date, nextRoundingValue, rounding, tz);
        assertThat(tzRounding.round(time("2014-11-11T17:00:00", tz)), isDate(tzRounding.round(time("2014-08-11T17:00:00", tz)), tz));
        List<Tuple<String, String>> expectedDates = new ArrayList<>();
        ZoneId emptyTz = ZoneOffset.UTC;
            Rounding.Prepared prepared = rounding.prepare(min - interval, max);
            assertInterval(time("1991-03-03T02:00:00.000+10:30"), time("1991-03-03T03:00:00.000+10:30"), rounding, 60, tz);
     * Tests for DST transitions that cause the rounding to jump "backwards" because they round
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.MINUTES_OF_HOUR), closeTo(129600.0, 0.000001));
    }
        ZoneId tz = ZoneId.of("America/Moncton");
                long javaRounded = javaTimeRounding.round(date);
        // Sunday, 29 October 2000, 01:00:00 clocks were turned backward 1 hour
        Rounding unitRounding = Rounding.builder(TimeValue.timeValueHours(10)).build();
        {
        Rounding utcUnitRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).build();
        Rounding rounding = new Rounding.TimeIntervalRounding(13800000, tz);
            for (long date = min; date < max; date += interval / 2) {
                    "Expected ["
                "Cannot use month-based rate unit [year] with non-month based calendar interval "
        ZoneId tz = ZoneOffset.UTC;
        return Math.abs(randomLong() % (2 * (long) 10e11)); // 1970-01-01T00:00:00Z - 2033-05-18T05:33:20.000+02:00
    }
        long b2 = randomValueOtherThan(b1, RoundingTests::randomDate);
        assertTrue(utcIntervalRounding.isUTC());
            long[] bounds = randomDateBounds(unit);
public class RoundingTests extends OpenSearchTestCase {
        assertThat(tzRounding.round(time("2014-10-10T17:00:00", tz)), isDate(time("2014-10-01T00:00:00", tz), tz));
        assertThat(tzRounding_utc.round(time("2013-11-03T06:01:01", chg)), isDate(time("2013-11-03T06:00:00", chg), chg));
        TemporalAccessor accessor = DateFormatter.forPattern("date_optional_time").withZone(zone).parse(time);
        assertThat(
            // These timezones are otherwise uninteresting, so just skip this period.
        IllegalArgumentException ex = expectThrows(
        long rounded = rounding.prepareJavaTime().round(972780720000L);
        // make sure the next interval is 24h long again
    public void testHardNextRoundingValue() {
        tz = ZoneId.of("America/Lima");
        assertThat(
        Rounding.Prepared prepared = unitRounding.prepare(time("2010-01-01T00:00:00.000Z"), time("2020-01-01T00:00:00.000Z"));
        Rounding rounding = new Rounding.TimeIntervalRounding(960000, ZoneId.of("Europe/Minsk"));
    private static long time(String time) {
                long javaNextRoundingValue = javaTimeRounding.nextRoundingValue(date);
/*
        return time(time, ZoneOffset.UTC);
        ZoneId tz = ZoneId.of("America/St_Johns");
        );
    }
            IllegalArgumentException.class,
        long millisSinceEpoch = TimeUnit.SECONDS.toMillis(transition.toEpochSecond());
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-10T01:01:00.000Z"), tz));
            )
        // which means there were two midnights that day.
            assertUnitRoundingSameAsJavaUtilTimeImplementation(unit, tz, bounds[0], bounds[1]);
     * CET: 27 March 2016, 02:00:00 clocks were turned forward 1 hour to 27 March 2016, 03:00:00 local daylight time
     * The example covers an interval around 2011-10-30T02:10:00+01:00, time zone CET, interval: 2700000ms
            closeTo(1 / 24.0, 0.000001)
import java.time.temporal.TemporalAccessor;
            Rounding.DateTimeUnit.DAY_OF_MONTH,
import org.hamcrest.TypeSafeMatcher;
        }
        final long nextRoundingValue = prepared.nextRoundingValue(roundedDate);
        }
        );
 * Licensed to Elasticsearch under one or more contributor
            equalTo(
        }
    public void testTimeIntervalRounding() {
    }
        assertThat(rounding.round(time("2016-03-28T01:00:00+02:00")), isDate(time("2016-03-28T00:00:00+02:00"), tz));
            /*
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).build();
        nextMidnight = time("1990-04-02T00:00:00.000-05:00");
            long mainDate = randomDate();
    private void assertInterval(long rounded, long unrounded, long nextRoundingValue, Rounding rounding, ZoneId tz) {
            // Clocks went back 3 hours at 02:00 on 2010-03-05, causing overlapping days.
        assertThat(rounding.round(time("2000-10-29T06:00:00-01:00")), isDate(time("2000-10-29T00:00:00Z"), tz));
            tz,
        assertThat(rounding.round(time("2016-03-27T13:00:00+02:00")), isDate(time("2016-03-27T12:00:00+02:00"), tz));
        assertFalse(nonUtcUnitRounding.isUTC());
        }
        assertThat(tzRounding.round(time("2014-10-26T01:01:01", cet)), isDate(time("2014-10-26T01:00:00+02:00"), cet));
                        "Values smaller than rounded value should round further down",
        ZoneId tz = ZoneId.of("CET");
            @Override
            assertInterval(floor, timeBetweenMidnights, ceiling, rounding, tz);
                            + " "
            return new long[] { b1, b1 + unit.extraLocalOffsetLookup() * between(1, 40) };
    }
        }
                        + "] but instead was to ["
    public void testPrepareLongRangeRoundsToMidnight() {
        );
    private static long nastyDate(long initialDate, ZoneId timezone, long unitMillis) {
        // Day of switching DST on -> off
     * test TimeIntervalRounding, (interval &lt; 12h) with time zone shift
        // Test +00:00 timezone format
                    + "histogram [hour] only week, day, hour, minute and second are supported for this histogram"
                fail(
            // Sometimes use a fairly close date
        Rounding tzRounding;
            Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
        if (randomBoolean()) {
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T00:00:00.000Z"), tz));
            IllegalArgumentException.class,
        Rounding zoneOffsetUtcRounding = Rounding.builder(Rounding.DateTimeUnit.SECOND_OF_MINUTE).timeZone(ZoneOffset.UTC).build();
        assertThat(tzRounding.round(time("2012-04-01T04:15:30Z")), isDate(time("2012-03-31T08:00:00Z"), tz));
    }
        };
    public void testBeforeOverlapLarge() {
        ZoneId plusEightTz = ZoneOffset.of("+08:00");
        // Test non-UTC timezone with offset
 * the Apache License, Version 2.0 (the "License"); you may
            //
        // first date is the date to be rounded, second the expected result
     * test DST start with interval rounding
    }
            ex.getMessage(),
                    + "] should round down to roundedDate ["
        assertThat(
                        + rounding
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T00:00:00.000Z")), isDate(time("2009-02-03T12:00:00.000Z"), tz));
            // Only when the rounding changes the day
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.YEAR_OF_CENTURY), closeTo(0.25, 0.000001));
        // Check that rounding is internally consistent and consistent with nextRoundingValue
    }
        assertThat(prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.HOUR_OF_DAY), closeTo(10.0, 0.000001));
        assertThat(tzRounding.round(time("2014-10-26T02:30:00+02:00")), isDate(time("2014-10-26T02:00:00+02:00"), tz));
    /**
    private static long dateBetween(long lower, long upper) {
    }
            assertThat(floor, isDate(time("2006-10-29T00:00:00.000-02:30"), tz));
        // should be considered as part of the 28th even though it comes after midnight on the 29th.
            }
        assertThat(rounding.round(time("2006-12-31T13:21:44.308Z")), isDate(time("2006-09-30T20:00:00Z"), tz));
                long esNextRoundingValue = prepared.nextRoundingValue(date);
            // 5 Apr 2015 - Daylight Saving Time Ended
        Rounding plusEightRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneOffset.of("+08:00")).build();
            || tz.getId().equals("America/Goose_Bay")
        assertThat(
        assertThat(tzRounding.round(time("2009-02-03T00:01:01")), isDate(time("2009-02-02T19:00:00.000Z"), tz));
            // time zone "Pacific/Chatham"
        );
        assertThat(rounding.round(time("2018-03-31T15:25:15.148Z")), isDate(time("2018-03-31T14:00:00Z"), tz));
             * round might spit out a time below the min if min is near a
            Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.HOUR_OF_DAY, tz);
            assertThat(dayTzRounding.nextRoundingValue(time), greaterThan(time));
        long interval = TimeUnit.MINUTES.toMillis(20);
        assertThat(rounding.round(time("2016-03-27T03:39:00+02:00")), isDate(time("2016-03-27T03:36:00+02:00"), tz));
        }
     * to build well with the java.time APIs.
    public void testDST_END_Edgecases() {
        );
import org.opensearch.common.collect.Tuple;
        );
        );
            isDate(nextRoundingValue, tz)
import static org.hamcrest.Matchers.equalTo;
            @Override
        Rounding tzRounding = Rounding.builder(Rounding.DateTimeUnit.MONTH_OF_YEAR).build();
                checkForForwardsBackwardsTransition(tz, transition);
        assertThat(time("1986-01-01T00:40:00+05:45") - time("1986-01-01T00:20:00+05:45"), equalTo(TimeUnit.MINUTES.toMillis(20)));
