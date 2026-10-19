             * in the tests far below we call round(round(min)). The first
    }
        );
            "{} from {}{} to {}{}",  
    public void testAmbiguousHoursAfterDSTSwitch() {
            assertThat(floor, isDate(time("2006-10-28T00:00:00.000-02:30"), tz));  
        ZoneId tz = ZoneOffset.ofHours(-8);  
        Rounding unitRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).build();
            assertThat(prevFloor, isDate(time("1978-09-30T00:00:00+02:00"), tz));  
        assertFalse(nonUtcUnitRounding.isUTC());
                isDate(nextRoundingValue, tz)  
            long floor = rounding.round(timeBetweenMidnights);
        Rounding.Prepared prepared = rounding.prepare(start, end);
        {
                    "Expected ["
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.MONTH_OF_YEAR).timeZone(tz).build();
     * Check a {@link Rounding.Prepared#nextRoundingValue} that was difficult  
        assertThat(rounding.round(time("2015-10-25T02:35:00+01:00")), isDate(time("2015-10-25T02:20:00+01:00"), tz));
        {
import org.hamcrest.TypeSafeMatcher;
        // Second case, dst happens at 0am local time, switching back one hour to 23pm local time.
        assertThat(rounding.round(time("2016-03-27T03:39:00+02:00")), isDate(time("2016-03-27T03:36:00+02:00"), tz));  
                }
            equalTo(  
            // the interval between is 105 minutes long because the hour after transition starts at 00:15  
        {
        ZoneId tz = ZoneId.of("CET");
                );
        expectedDates.add(new Tuple<>("2011-10-30T02:10:00.000+01:00", "2011-10-30T02:15:00.000+02:00"));
                );
            return t <= time("1969-01-25T00:00:00Z") || t >= time("1969-01-26T00:00:00Z");
        assertTrue(emptyTzRounding.isUTC());  
        return dateBetween;
            IllegalArgumentException.class,  
        ZoneId tz = ZoneOffset.UTC;  
                            + " in "  
        Rounding.Prepared prepared = unitRounding.prepare(time("2010-01-01T00:00:00.000Z"), time("2020-01-01T00:00:00.000Z"));
        assertThat("rounded value smaller or equal than unrounded", rounded, lessThanOrEqualTo(unrounded));
        long midnightBeforeTransition = time("2000-10-29T00:00:00", tz);
            || tz.getId().equals("America/Goose_Bay")
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
        }
            assertInterval(floor, timeBetweenMidnights, ceiling, rounding, tz);  
        assertThat(tzRounding.round(0), equalTo(0L));
        assertThat(tzRounding.round(time("2014-10-10T17:00:00", tz)), isDate(time("2014-10-01T00:00:00", tz), tz));
            long[] bounds = randomDateBounds(unit);
        );
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.lessThan;  
            assertInterval(time("2015-09-27T01:00:00.000+12:45"), time("2015-09-27T02:00:00.000+12:45"), rounding, 60, tz);
     * from one back to the previous day. Usually these rounding start before  
        // 29 October 2006 - Daylight Saving Time ended, changing the UTC offset from -02:30 to -03:30.  
        }  
import static org.hamcrest.Matchers.greaterThan;
                "dateBetween [" + zonedDateBetween + "] should round up to nextRoundingValue",
    private static Matcher<Long> isDate(final long expected, ZoneId tz) {
                            + Instant.ofEpochMilli(esRounded)
        assertThat(tzRounding.round(time("2009-02-03T00:01:01")), isDate(time("2009-02-02T19:00:00.000Z"), tz));
            long roundingDateBetween = rounding.round(dateBetween);
            }  
    }  
                        + "]"
        assertThat(
    }
            assertInterval(time("1991-10-27T03:00:00.000+11:00"), time("1991-10-27T04:00:00.000+11:00"), rounding, 60, tz);
    public void testIntervalRounding_NotDivisibleInteval() {
        assertTrue(zoneOffsetUtcRounding.isUTC());
            tzRounding.nextRoundingValue(0L - TimeValue.timeValueHours(24 + timezoneOffset).millis()),
        assertThat(rounding.round(time("1982-11-10T02:51:22.662Z")), isDate(time("1982-03-23T05:00:00Z"), tz));
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T00:00:00.000Z")), isDate(time("2009-02-03T12:00:00.000Z"), tz));
        Rounding utcUnitRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).build();  
                        previousRoundedValueDate,
        assertThat(tzRounding.nextRoundingValue(time("2014-03-30T01:00:00", cet)), isDate(time("2014-03-30T03:00:00", cet), cet));  
        }  
            ZoneRules rules = tz.getRules();
            long mainDate = randomDate();
     * that. So, we jumped back a long, long way.  
            assertInterval(time("1991-10-27T00:00:00.000+10:30"), time("1991-10-27T01:00:00.000+10:30"), rounding, 60, tz);
 *     http://www.apache.org/licenses/LICENSE-2.0
            )
                    final long roundedDate = rounding.round(date);
        // Saturday, 31 March 1990, 23:00:00 local standard time instead  
            @Override  
        assertThat(time("2014-10-26T03:00:00+03:00"), isDate(time("2014-10-26T02:00:00+02:00"), tz));
        assertInterval(midnightBeforeTransition, nextMidnight, rounding, 25 * 60, tz);
        // check correct unit interval width for units smaller than a day, they should be fixed size except for transitions
        }
        assertThat(tzRounding.round(time("2015-03-27T17:00:00", tz)), isDate(time("2015-03-27T00:00:00", tz), tz));
     */
        assertThat(tzRounding.round(time("2014-10-26T02:30:00+02:00")), isDate(time("2014-10-26T02:00:00+02:00"), tz));
            if (javaNextRoundingValue != esNextRoundingValue) {  
            long floor = rounding.round(timeAfterSecondMidnight);
        assertThat(tzRounding.round(time("2009-02-03T13:01:01")), isDate(time("2009-02-03T12:00:00.000Z"), tz));  
        Rounding nonUtcWithOffsetRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH)
        assertThat(
            // at 02:00:00 clocks were turned backward 0:30 hours to Sunday, 3 March 1991, 01:30:00
        assertThat(rounding.round(time("2016-03-27T03:05:00+02:00")), isDate(time("2016-03-27T03:00:00+02:00"), tz));  
        }  
                        + "] to ["  
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-01T00:00:00.000Z"), tz));
        assertThat(rounding.round(time("2016-03-27T03:35:00+02:00")), isDate(time("2016-03-27T03:20:00+02:00"), tz));
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-10T01:00:00.000Z"), tz));
        ZoneId tz = ZoneId.of("Asia/Baghdad");
            ex.getMessage(),
                    ZonedDateTime dateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(date), tz);  
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
        // Test empty timezone (should default to UTC)
/*
                    + "histogram [hour] only week, day, hour, minute and second are supported for this histogram"
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T01:00:00"), tz));
        Rounding rounding = new Rounding.TimeIntervalRounding(13800000, tz);
     * to build well with the java.time APIs.
        long millisSinceEpoch = TimeUnit.SECONDS.toMillis(transition.toEpochSecond());
    }
                    }  
            @Override
    /**
        assertThat(  
        if (false == transition.isOverlap()) {
                fail(
        Rounding tzRounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.MINUTES_OF_HOUR, tz);
        }  
            // check two intervals around date
            ex.getMessage(),
            transition.getOffsetBefore(),  
        return time(time, ZoneOffset.UTC);
 * compatible open source license.
        assertFalse(plusEightRounding.isUTC());  
                        previousRoundedValue  
        assertThat(rounding.round(time("2016-03-28T13:00:00+02:00")), isDate(time("2016-03-28T12:00:00+02:00"), tz));
        for (String utcAlias : new String[] { "UTC", "Etc/UTC", "+00:00", "Z" }) {
    }
        assertThat(tzRounding.round(time("2014-11-11T17:00:00", tz)), isDate(time("2014-11-01T00:00:00", tz), tz));  
            assertInterval(floor, timeAfterSecondMidnight, ceiling, rounding, tz);  
        }  
             * daylight savings time transition. So we request an extra big
        }  
        {
        }  
        long date = dateBetween(start, end);
            equalTo(
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.YEAR_OF_CENTURY)
        // testing savings to non savings switch
            assertInterval(time("2015-04-05T03:00:00.000+13:45"), time("2015-04-05T03:00:00.000+12:45"), rounding, 60, tz);
        IllegalArgumentException ex = expectThrows(
        }  
        // time zone "America/St_Johns", rounding to days.
        // Sunday, 29 October 2000, 01:00:00 clocks were turned backward 1 hour
        Rounding plusZeroZeroRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneOffset.of("+00:00")).build();  
                    final long nextRoundingValue = prepared.nextRoundingValue(roundedDate);  
        assertThat(rounding.round(time("1986-01-01T00:46:00+05:45")), isDate(time("1986-01-01T00:40:00+05:45"), tz));
        assertTrue(utcWithOffsetRounding.isUTC());
    public void testTimezoneFormats() {
        assertThat(rounding.withoutOffset().round(0), equalTo(0L));
                    assertThat(  
        assertThat(
    private static long randomDate() {
import org.opensearch.common.collect.Tuple;
        assertThat(rounding.round(time("2016-03-27T03:12:00+02:00")), isDate(time("2016-03-27T03:08:00+02:00"), tz));
            // Sometimes use a fairly close date
     * Test for half day rounding intervals scrossing DST.
            long esNextRoundingValue = prepared.nextRoundingValue(date);
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(tz).build();
        }
        Rounding tzRounding;
        // timeZone.convertLocalToUTC() gives the later of the two because Rome is east of UTC, whereas we want the earlier.  
 * the Apache License, Version 2.0 (the "License"); you may
        ZoneId tz = ZoneId.of("CET");
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(tz).build();
        if (randomBoolean()) {
        {  
        }
                        assertThat(
import java.time.zone.ZoneRules;  
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.MONTH_OF_YEAR)  
                            + Instant.ofEpochMilli(date)
            || tz.getId().equals("America/Moncton")
        assertThat(tzRounding.nextRoundingValue(0L), equalTo(TimeValue.timeValueHours(1L).getMillis()));  
        Rounding fixedOffsetRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneOffset.ofHours(3)).build();
             */  
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.YEAR_OF_CENTURY).build();  
        for (long time = start; time < end; time = time + 60000) {  
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.MINUTES_OF_HOUR),
            assertInterval(time("2015-10-25T02:00:00.000+01:00"), time("2015-10-25T03:00:00.000+01:00"), rounding, 60, tz);
            // Times between the two midnights which are on the later day should be rounded down to the later day's midnight.
            Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.HOUR_OF_DAY, tz);  
    /**
    /**  
     * In this case, when interval crosses DST transition point, rounding in local
        {
            assertInterval(time("2015-03-29T01:00:00.000+01:00"), time("2015-03-29T03:00:00.000+02:00"), rounding, 60, tz);  
     * <p>  
        assertThat(prepared.round(time("9000-03-31T15:25:15.148Z")), isDate(time("9000-03-31T15:00:00Z"), tz));  
        ZoneId tz = ZoneId.of("CET");
        expectedDates.add(new Tuple<>("2011-10-30T02:02:30.000+02:00", "2011-10-30T01:30:00.000+02:00"));
                            + unitCount
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.YEAR_OF_CENTURY), closeTo(0.25, 0.000001));
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-04-01T00:00:00.000Z"), tz));
        // hour unit
        assertFalse(minusFiveRounding.isUTC());  
                        "Values smaller than rounded value should round further down",
            assertInterval(time("1991-03-03T01:00:00.000+11:00"), time("1991-03-03T02:00:00.000+10:30"), rounding, 90, tz);  
            assertInterval(time("2015-09-27T04:00:00.000+13:45"), time("2015-09-27T05:00:00.000+13:45"), rounding, 60, tz);  
     */
 * SPDX-License-Identifier: Apache-2.0
            Rounding aliasIntervalRounding = Rounding.builder(TimeValue.timeValueHours(2)).timeZone(ZoneId.of(utcAlias)).build();
        assertTrue(utcIntervalRounding.isUTC());
        tz = ZoneId.of("America/Lima");
                            + Instant.ofEpochMilli(esRounded)  
        if (transition.getDateTimeBefore().getYear() < 1950) {
        // FIXME this was copy pasted from the other impl and not used. breaks the nasty date actually gets assigned
        assertThat(plusEightRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T01:00:00.000Z"), plusEightTz));
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);  
    /**
            // Clocks went back at 00:01 between 1987 and 2010, causing overlapping days.
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.HOUR_OF_DAY), closeTo(2160.0, 0.000001));  
                        + "] to ["  
        for (int i = 0; i < 1000; ++i) {
        // Two timestamps in same year and different timezone offset ("Double buckets" issue - #9491)
            )
            assertInterval(time("1991-03-03T00:00:00.000+11:00"), time("1991-03-03T01:00:00.000+11:00"), rounding, 60, tz);
    /**
    }
    private void assertInterval(long rounded, long unrounded, long nextRoundingValue, Rounding rounding, ZoneId tz) {
            previousDate = roundedDate;
        assertFalse(nonUtcWithOffsetRounding.isUTC());
        assertThat(  
        Rounding rounding = new Rounding.TimeIntervalRounding(960000, ZoneId.of("Europe/Minsk"));
        // which means there were two midnights that day.  
        assertThat(tzRounding.round(time("2014-10-26T00:30:00+03:00")), isDate(time("2014-10-26T00:00:00+03:00"), tz));
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.MINUTES_OF_HOUR).build();
                        + "] and nextRoundingValue to be ["
        long oneDay = TimeUnit.DAYS.toMillis(1);
        );
        Rounding tzRounding = Rounding.builder(TimeValue.timeValueHours(12)).timeZone(tz).build();
            // time zone "Pacific/Chatham"  
                            + Instant.ofEpochMilli(javaNextRoundingValue)
        // Test non-UTC timezone for TimeIntervalRounding
import java.time.format.DateTimeFormatter;
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T01:00:00")), isDate(time("2009-02-03T02:00:00"), tz));  
        assertEquals(60L * 60L * 1000L, midnightOfTransition - midnightBeforeTransition);
        assertFalse(nonUtcIntervalRounding.isUTC());  
        }
        // We want the overlapping hour to count for the next day, making it a 25h interval
        }  
                    assertThat("NextRounding value should be greater than date", nextRoundingValue, greaterThan(roundedDate));  
             * Prepare a rounding with one extra interval of range because
            assertThat(dayTzRounding.nextRoundingValue(time), greaterThan(time));
        List<Tuple<String, String>> expectedDates = new ArrayList<>();
                            equalTo(interval)
        ZoneId tz = ZoneOffset.ofHours(-1);
        assertTrue(plusZeroZeroRounding.isUTC());  
     */  
            equalTo(  
            return;
            // at 03:00:00 clocks were turned backward 1 hour to 02:00:00
        // to Sunday, 29 October 2000, 00:00:00 local standard time instead
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T02:00:00")), isDate(time("2009-02-04T02:00:00"), tz));
                            + "] to round ["  
    public void testTimeInterval_Kathmandu_DST_Start() {
    /**
        assertThat(tzRounding_chg.round(time("2014-11-02T06:01:01", chg)), isDate(time("2014-11-02T06:00:00", chg), chg));
        Rounding quarterEightRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).timeZone(ZoneOffset.of("+08:00")).build();  
                        + Instant.ofEpochMilli(date)
        assertThat(plusZeroZeroRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T01:00:00.000Z"), plusZeroZeroTz));
         * end up not loading the offsets far enough back to round this time
import java.time.temporal.TemporalAccessor;  
        if (transition.getDateTimeBefore().getDayOfMonth() == transition.getDateTimeAfter().getDayOfMonth()) {  
        // This happened at 02:31 UTC, 00:01 local time, so the clocks were set back 1 hour to 23:01 on the 28th.
        if (isTimeWithWellDefinedRounding(tz, unrounded)) {
        assertThat(rounding.round(time("9000-12-31T13:21:44.308Z")), isDate(time("9000-10-01T04:00:00Z"), tz));
     * In one third of the cases stay there, otherwise go half a unit back or forth
    /**
        Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.DAY_OF_MONTH, tz);
            closeTo(1 / 168.0, 0.000001)  
    private void assertUnitRoundingSameAsJavaUtilTimeImplementation(Rounding.DateTimeUnit unit, ZoneId tz, long start, long end) {  
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();
            if (rules.getTransitions().isEmpty()) {
     * described in  
    }
     */  
                    "unit interval width not as expected for [" + unit + "], [" + tz + "] at " + Instant.ofEpochMilli(roundedDate),
     * test for #10025, strict local to UTC conversion can cause joda exceptions
        ZoneId tz = ZoneId.of("Atlantic/Azores");  
    }
    private static long[] randomDateBounds(Rounding.DateTimeUnit unit) {
        assertThat(rounding.round(oneDay - twoHours), equalTo(oneDay - twoHours));  
        Rounding.DateTimeUnit timeUnit = Rounding.DateTimeUnit.DAY_OF_MONTH;
                roundingDateBetween,  
     */
        };
     * Check a {@link Rounding.Prepared#nextRoundingValue} that was difficult
            // Only when the rounding changes the day
    private static long nastyDate(long initialDate, ZoneId timezone, long unitMillis) {
        assertThat(rounding.round(time("2016-03-27T03:15:00+02:00")), isDate(time("2016-03-27T03:00:00+02:00"), tz));  
                        );
        );  
 * GitHub history for details.
        // Only the first of these is considered "rounded". Moreover, the extra time between 23:01 and 23:59  
     * to build well with the java.time APIs.  
                        + "]"  
                    );
     */
            // time zone "Australia/Lord_Howe"
                            + "] to round ["
                );
        assertThat("values less than rounded should round further down", rounding.round(rounded - 1), lessThan(rounded));
        // First case, dst happens at 1am local time, switching back one hour.  
                    fail(
     */
                return expected == item;
     */
        final long roundedDate = prepared.round(date);
 * KIND, either express or implied.  See the License for the
    }
 * under the License.  
        assertThat(prepared.roundingSize(thirdQuarter, Rounding.DateTimeUnit.HOUR_OF_DAY), closeTo(2208.0, 0.000001));
        Rounding tzRounding = Rounding.builder(TimeValue.timeValueHours(12)).build();
            long timeBeforeFirstMidnight = time("1978-09-30T23:59:00+02:00");  
        return new TypeSafeMatcher<Long>() {
            assertTrue("isUTC() should be true for ZoneId.of(\"" + utcAlias + "\") TimeIntervalRounding", aliasIntervalRounding.isUTC());  
import org.hamcrest.Matcher;
                checkForForwardsBackwardsTransition(tz, transition);
        assertThat(next, greaterThan(rounded));
    public void testDayRounding() {  
        // Test ZoneOffset.UTC specifically
        expectedDates.add(new Tuple<>("2011-10-30T03:17:30.000+01:00", "2011-10-30T03:00:00.000+01:00"));
            }  
        // date in Feb-3rd, but still in Feb-2nd in -02:00 timezone
                    + dateBetween
                }  
            // We don't support transitions far in the past at all
        assertThat(tzRounding.round(time("2014-10-26T01:30:00+03:00")), isDate(time("2014-10-26T01:00:00+03:00"), tz));  
     * @param rounded the expected low end of the rounding interval  
            .build();  
        ZoneId tz = ZoneId.of("Europe/Rome");
        assertEquals(millisPerMinute * minutes, nextRoundingValue - rounded);
        Rounding utcWithOffsetRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH)  
        assertThat(tzRounding.round(time("2014-11-11T17:00:00", tz)), isDate(time("2014-01-01T00:00:00", tz), tz));  
                checkForForwardsBackwardsTransition(tz, transition);
        assertThat(tzRounding.round(time("2009-02-03T13:01:01")), isDate(time("2009-02-03T13:00:00.000Z"), tz));
        // date in Feb-3rd, also in -02:00 timezone
        ZoneId tz = ZoneId.of("America/St_Johns");  
            return t <= time("2010-03-03T00:00:00Z") || t >= time("2010-03-07T00:00:00Z");  
            }
        assertThat(rounding.round(time("2016-03-27T03:25:00+02:00")), isDate(time("2016-03-27T03:22:00+02:00"), tz));
            public void describeTo(Description description) {  
        // testing non savings to savings switch  
        }
        assertThat(rounding.round(time("2016-03-27T01:55:00+01:00")), isDate(time("2016-03-27T01:40:00+01:00"), tz));
            }  
    }
        assertThat(prepared.round(time("2018-03-31T15:25:15.148Z")), isDate(time("2018-03-31T14:00:00Z"), tz));
            protected void describeMismatchSafely(final Long actual, final Description mismatchDescription) {  
                ZoneOffsetTransition transition = transitionRule.createTransition(year);  
        long start = time("2014-10-18T20:50:00.000", tz);
        assertThat(rounding.round(time("2016-03-27T01:51:00+01:00")), isDate(time("2016-03-27T01:44:00+01:00"), tz));
            // Clocks went back 3 hours at 02:00 on 2010-03-05, causing overlapping days.
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(rounding.nextRoundingValue(-oneDay), equalTo(-twoHours));
            // Round a whole bunch of dates and make sure they line up with the known good java time implementation  
            ex.getMessage(),  
        assert lower <= dateBetween && dateBetween < upper;  
            long previousRoundedValue = Long.MIN_VALUE;
    }
     * test DST start with offset not fitting interval, e.g. Asia/Kathmandu
            long timeAfterSecondMidnight = time("2006-10-29T06:00:00.000-03:30");
    }
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).timeZone(tz).build();  
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.YEAR_OF_CENTURY).timeZone(tz).build();
        assertThat(tzRounding_utc.round(time("2014-11-02T06:01:01", chg)), isDate(time("2014-11-02T06:00:00", chg), chg));
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-01T00:00:00.000Z"), tz));
    public void testEdgeCasesTransition() {  
        );
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-09T00:01:00.000Z"), tz));  
        // test DST start  
        }
        long millisPerMinute = 60_000;  
                "Cannot use month-based rate unit [quarter] with non-month based calendar interval "
            assertUnitRoundingSameAsJavaUtilTimeImplementation(unit, tz, bounds[0], bounds[1]);
    public void testIntervalBeforeGap() {  
        } else {  
        tz = ZoneId.of("-02:00");
        // Real interval based  
                fail(
        );  
                            + tz
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.DAY_OF_MONTH), closeTo(90.0, 0.000001));
            return;  
        // Sunday, 1 April 1990, 00:00:00 clocks were turned backward 1 hour to
        assertThat(tzRounding_utc.round(time("2013-11-03T06:01:01", chg)), isDate(time("2013-11-03T06:00:00", chg), chg));  
            long javaNextRoundingValue = javaTimeRounding.nextRoundingValue(date);
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).build();
            ZoneId tz = ZoneId.of(zoneId);
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.QUARTER_OF_YEAR)
        int timezoneOffset = -2;
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-10T01:01:00.000Z"), tz));
import static org.hamcrest.Matchers.closeTo;
            )
            // Times after the second midnight should be rounded down to the first midnight.  
            }
            // 1 Jan 1986 - Time Zone Change (IST → NPT), at 00:00:00 clocks were turned forward 00:15 minutes  
     * Special test for intervals that don't fit evenly into rounding interval.  
        assertThat(rounding.prepareJavaTime().nextRoundingValue(1383463147373L), isDate(time("2013-11-03T03:40:00", tz), tz));
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
                mismatchDescription.appendText(" was ")
    }  
                            + " in "
        );
            if (randomBoolean()) {  
                            + "] and nextRoundingValue to be ["
        assertThat(tzRounding.round(time("2012-04-01T04:15:30Z")), equalTo(time("2012-03-01T08:00:00Z")));
    public void testOtherHardNextRoundingValue() {
        // Round a whole bunch of dates and make sure they line up with the known good java time implementation  
        // testing savings to non savings switch 2013 (America/Chicago)
        assertThat(rounding.round(time("2020-11-01T09:00:00")), equalTo(time("2020-11-01T02:00:00")));
                mainDate = nastyDate(mainDate, tz, interval);
            // hour rounding is stable before 1985-12-31T23:00:00.000 and after 1986-01-01T01:00:00.000+05:45
                    );  
        // time zone "Europe/Rome", rounding to days. Rome had two midnights on the day the clocks went back in 1978, and
        );
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-10T00:00:00.000Z"), tz));
     * @param unrounded a date in the interval to be checked for rounding
    }  
        Rounding unitRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).build();
            long ceiling = rounding.nextRoundingValue(timeAfterSecondMidnight);
        // Test ZoneRegion aliases that normalized() converts to ZoneOffset.UTC  
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2013-01-01T00:00:00.000Z"), tz));
        long nextMidnight = time("2000-10-30T00:00:00", tz);
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-01T00:00:00.000Z"), tz));
                    + zonedDateBetween  
    }
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T00:00:00.000Z"), tz));
                            + "] to ["
                }
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.MONTH_OF_YEAR).timeZone(tz).build();
            assertThat(floor, isDate(time("1978-10-01T00:00:00+02:00"), tz));
            long timeBeforeFirstMidnight = time("2006-10-28T23:30:00.000-02:30");
     * Test that rounded values are always greater or equal to last rounded value if date is increasing.  
     */
        // after DST shift  
        assertThat(time("1986-01-01T00:20:00+05:45") - time("1986-01-01T00:15:00+05:45"), equalTo(TimeUnit.MINUTES.toMillis(5)));  
     */
    }
        }
            millisSinceEpoch + twoHours
        ZoneId plusZeroZeroTz = ZoneOffset.of("+00:00");
 * license agreements. See the NOTICE file distributed with
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(cet).build();
         */
        );
        assertThat(  
            final long roundedDate = rounding.round(time(dates.v1()));
                            + "]"
     */  
        assertThat(tzRounding.nextRoundingValue(time("2009-02-02T02:00:00")), isDate(time("2009-02-03T02:00:00"), tz));
            IllegalArgumentException.class,  
            TimeUnit unit = randomFrom(TimeUnit.MINUTES, TimeUnit.HOURS, TimeUnit.DAYS);
    /**
            long prevFloor = rounding.round(floor - 1);
        ZoneId tz = ZoneOffset.ofHours(-2);  
            // the interval containing the switch time is 90 minutes long  
     * Check a {@link Rounding.Prepared#nextRoundingValue} that was difficult
                    + "histogram [hour] only week, day, hour, minute and second are supported for this histogram"  
                if (javaRounded != esRounded) {  
     * long
    public void testOffsetRounding() {
     */
        // Test additional timezone formats for completeness
        assertThat(rounding.nextRoundingValue(-oneDay), equalTo(-oneDay + twoHours));
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);  
        long interval = TimeUnit.MINUTES.toMillis(20);
        assertThat("rounding should be idempotent", rounding.round(rounded), isDate(rounded, tz));  
            .timeZone(ZoneOffset.UTC)
                        dateTime,
        assertEquals(TimeUnit.MINUTES.toMillis(60), time("2011-10-30T02:15:00.000+01:00") - time("2011-10-30T02:15:00.000+02:00"));  
                try {
 */  
        );  
     */
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T12:00:00.000Z")), isDate(time("2009-02-04T00:00:00.000Z"), tz));
         * If we're not careful with how we look up local time offsets we can
 * specific language governing permissions and limitations
    public void testRandomTimeUnitRounding() {  
            // 5 Apr 2015 - Daylight Saving Time Ended
        long next = rounding.prepareJavaTime().nextRoundingValue(rounded);
        ex = expectThrows(  
        // Year interval
    /**  
        assertThat(prepared.roundingSize(thirdQuarter, Rounding.DateTimeUnit.DAY_OF_MONTH), closeTo(92.0, 0.000001));  
                    );
        long b2 = randomValueOtherThan(b1, RoundingTests::randomDate);  
    public void testBeforeOverlapSmall() {
        assertThat(minusFiveRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-02T05:00:00.000Z"), minusFiveTz));
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-10T01:01:01.000Z"), tz));  
        logger.info(
            }
        assertThat(  
     * <strong>and</strong> then past the time they were wound forwards before
            Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
            assertInterval(time("1991-10-27T01:00:00.000+10:30"), time("1991-10-27T03:00:00.000+11:00"), rounding, 90, tz);
        Rounding.Prepared prepared = rounding.prepare(min, max);
                    assertThat("Rounding should be >= previous rounding value", roundedDate, greaterThanOrEqualTo(previousRoundedValue));
                        + Instant.ofEpochMilli(esRounded)  
        ZoneId tz = ZoneId.of("Africa/Cairo");
            // time zone "Asia/Kathmandu"
 * Unless required by applicable law or agreed to in writing,
        expectedDates.add(new Tuple<>("2011-10-30T02:47:30.000+02:00", "2011-10-30T02:15:00.000+02:00"));  
    }  
        ex = expectThrows(  
    public void testMillisecondsBasedUnitCalendarRoundingSize() {  
    }  
        assertThat(tzRounding.round(time("2014-10-26T17:00:00", tz)), isDate(time("2014-10-26T00:00:00", tz), tz));  
        assertThat(rounding.round(time("2016-03-26T13:00:00+01:00")), isDate(time("2016-03-26T12:00:00+01:00"), tz));  
    }
            closeTo(3600.0, 0.000001)
        ZoneId tz = ZoneId.of("America/New_York");
                    equalTo(unitMillis)
            assertThat(dates.toString(), roundedDate, greaterThanOrEqualTo(previousDate));
            transition.getDateTimeBefore(),
                } catch (AssertionError e) {
    }
        assertThat(rounding.round(time("2016-03-26T01:00:00+01:00")), isDate(time("2016-03-26T00:00:00+01:00"), tz));
    public void testDayIntervalRounding() {
        // the utc date for "2014-10-25T03:00:00+03:00" and "2014-10-25T03:00:00+02:00" is the same, local time turns back 1h here
        }
            .offset(3600000)  
            transition.getOffsetAfter()
        ZoneId chg = ZoneId.of("America/Chicago");
     * to build well our janky Newton's Method/binary search hybrid.
                    .appendValue(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime) + " [" + actual + "]");  
        ZoneId tz = ZoneId.of("Asia/Kathmandu");  
        assertThat(rounding.round(time("1969-07-08T09:00:14.599Z")), isDate(time("1969-04-18T22:00:00Z"), tz));  
        assertThat(tzRounding.round(time("2009-02-03T13:01:01")), isDate(time("2009-02-03T08:00:00.000Z"), tz));
            nastyDate(date, tz, unitMillis);  
                    );  
                    + "] should round down to roundedDate ["  
        assertThat(tzRounding.nextRoundingValue(time("2009-02-02T19:00:00.000Z")), isDate(time("2009-02-03T01:00:00.000Z"), tz));
        rounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(ZoneId.of("America/New_York")).offset(-twoHours).build();  
                            + "] to ["
            long timeBetweenMidnights = time("1978-10-01T00:30:00+02:00");  
        assertThat(prepared.round(time("2006-12-31T13:21:44.308Z")), isDate(time("2006-10-01T04:00:00Z"), tz));
        // Test with different datetime units
            equalTo(
    public void testRandomTimeIntervalRounding() {
        /*
        long min = time("01980-01-01T00:00:00Z");  
     * Randomized test on TimeUnitRounding. Test uses random
            return new long[] { b1, b1 + unit.extraLocalOffsetLookup() * between(1, 40) };  
        Rounding rounding = new Rounding.TimeIntervalRounding(480000, ZoneId.of("Portugal"));  
     */  
        long twoHours = TimeUnit.HOURS.toMillis(2);  
                    assertThat("Rounded value smaller or equal than unrounded", roundedDate, lessThanOrEqualTo(date));
                long javaRounded = javaTimeRounding.round(date);
        assertThat(rounding.round(time("1985-12-31T23:55:00+05:30")), isDate(time("1985-12-31T23:40:00+05:30"), tz));
    public void testTimeIntervalCET_DST_End() {  
        // make sure the next interval is 24h long again  
            // Times before the first midnight should be rounded up to the first midnight.
        if (tz.getId().equals("Antarctica/Casey")) {
        Rounding rounding = Rounding.builder(TimeValue.timeValueDays(279)).timeZone(tz).build();
     * Example of when we round past when local clocks were wound forward.
        // testing savings to non savings switch 2014 (America/Chicago)  
        final ZoneId tz = ZoneId.of("Asia/Jerusalem");  
                        interval,
            assertThat(ceiling, isDate(time("2006-10-30T00:00:00.000-03:30"), tz));
                    + "only week, day, hour, minute and second are supported for this histogram"
    }
        ZoneId cet = ZoneId.of("CET");  
        // testing non savings to savings switch (America/Chicago)  
        ZoneId tz = ZoneOffset.UTC;
                            + unit  
        assertThat(
            // Pick an arbitrary year to end the range too
        {
                    + "only week, day, hour, minute and second are supported for this histogram"  
                    ZonedDateTime previousRoundedValueDate = ZonedDateTime.ofInstant(Instant.ofEpochMilli(previousRoundedValue), tz);
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);  
import org.opensearch.common.time.DateFormatters;  
                ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(actual), tz);
        );  
            date = transition.getInstant().toEpochMilli();
        assertThat(rounding.round(0), equalTo(-twoHours));
     */
        assertUnitRoundingSameAsJavaUtilTimeImplementation(  
        assertThat(time("1986-01-01T00:40:00+05:45") - time("1986-01-01T00:20:00+05:45"), equalTo(TimeUnit.MINUTES.toMillis(20)));
        );  
                    + Instant.ofEpochMilli(roundingDateBetween)
            }
                ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(expected), tz);
     * Tests for DST transitions that cause the rounding to jump "backwards" because they round
    public void testIntervalTwoTransitions() {
        );
                        + "] to round ["
        ZoneId plusEightTz = ZoneOffset.of("+08:00");
        // Day of switching DST on -> off
        assertThat(rounding.nextRoundingValue(0), equalTo(twoHours));  
        }
            // These timezones are otherwise uninteresting, so just skip this period.  
        Rounding quarterUtcRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).timeZone(ZoneOffset.of("+00:00")).build();  
        assertThat(tzRounding.nextRoundingValue(time("2009-02-05T00:00:00.000Z")), isDate(time("2009-02-07T00:00:00.000Z"), tz));
        for (int d = 0; d < 1000; d++) {
import org.opensearch.common.time.DateFormatter;
    }
     * Example of when we round past when local clocks were wound backwards,
     * CET: 25 October 2015, 03:00:00 clocks were turned backward 1 hour to 25 October 2015, 02:00:00 local standard time
            assertTrue("isUTC() should be true for ZoneId.of(\"" + utcAlias + "\") TimeUnitRounding", aliasUnitRounding.isUTC());  
public class RoundingTests extends OpenSearchTestCase {  
     * DST) in the chosen time zone.
    }  
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-09T01:00:00.000Z"), tz));  
        // Test UTC timezone for TimeUnitRounding
            equalTo(
        assertInterval(midnightBeforeTransition, nextMidnight, rounding, 25 * 60, tz);
        Rounding rounding = new Rounding.TimeIntervalRounding(interval, tz);
            long ceiling = rounding.nextRoundingValue(timeBetweenMidnights);
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-10T00:00:00.000Z"), tz));  
    }
                    previousRoundedValue = roundedDate;
            closeTo(10.0 / 168.0, 0.000001)
                        + rounding  
        // here's what this means for interval widths
        Rounding tzRounding = Rounding.builder(TimeValue.timeValueHours(6)).timeZone(tz).build();  
        assertThat(rounding.round(time("2015-10-25T03:15:00+01:00")), isDate(time("2015-10-25T03:00:00+01:00"), tz));
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.SECOND_OF_MINUTE),  
        assertThat(tzRounding.round(time("2014-11-11T17:00:00", tz)), isDate(time("2014-11-11T00:00:00", tz), tz));
        Rounding tzRounding_utc = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneOffset.UTC).build();
     * The example covers an interval around 2011-10-30T02:10:00+01:00, time zone CET, interval: 2700000ms
            assertThat(floor, isDate(time("1978-09-30T00:00:00+02:00"), tz));
            closeTo(1 / 24.0, 0.000001)
     * {@link #assertInterval(long, long, long, Rounding, ZoneId)}
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-16T00:00:00.000Z"), tz));
    public void testFixedIntervalRoundingSize() {
                rounding.nextRoundingValue(dateBetween),
            @Override
    }
            return;  
        // should be considered as part of the 28th even though it comes after midnight on the 29th.
        );  
    private static long time(String time) {
        long interval = TimeUnit.MINUTES.toMillis(20);  
                        + Instant.ofEpochMilli(esNextRoundingValue)
            rounding.round(nextRoundingValue + 1),  
        Rounding tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(ZoneOffset.ofHours(timezoneOffset)).build();
     * tests for dst transition with overlaps and day roundings.  
    }
            "values above nextRounding should round down there",
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.DAY_OF_MONTH),  
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(cet).build();
        // Day of switching DST off -> on
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.YEAR_OF_CENTURY).timeZone(tz).build();  
                            + Instant.ofEpochMilli(date)  
                    + "/"
 *  
package org.opensearch.common;
    /**
import java.time.zone.ZoneOffsetTransition;
        long interval = TimeUnit.MINUTES.toMillis(14);
    }  
    }
        ZoneId emptyTz = ZoneOffset.UTC;
        assertThat(rounding.round(time("2016-03-28T01:00:00+02:00")), isDate(time("2016-03-28T00:00:00+02:00"), tz));  
        Rounding nonUtcUnitRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR)
            // Times between the two midnights which are on the earlier day should be rounded down to the earlier day's midnight.
     */  
     * @param rounding the rounding instance  
                        + Instant.ofEpochMilli(javaRounded)
        assertThat(rounding.round(time("2016-03-27T01:00:00+01:00")), isDate(time("2016-03-27T00:00:00+01:00"), tz));
            assertThat(floor, isDate(time("2006-10-29T00:00:00.000-02:30"), tz));  
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();  
        }  
    }
        );
        // Test non-UTC timezone with offset  
            assertInterval(time("1985-12-31T22:00:00.000+05:30"), time("1985-12-31T23:00:00.000+05:30"), rounding, 60, tz);
        if (tz.getId().equals("Pacific/Guam") || tz.getId().equals("Pacific/Saipan")) {
     * It rounds the test date down and up and performs various checks on the
                firstYear = lastTransition.getDateTimeAfter().getYear() + 1;  
        assertThat(rounding.round(0), equalTo(-oneDay + twoHours));  
        long end = time("2014-10-19T01:00:00.000", tz);  
        {  
        assertThat(rounding.round(time("2016-03-27T01:59:00+01:00")), isDate(time("2016-03-27T01:58:00+01:00"), tz));
        assertThat(quarterEightRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-01-01T00:00:00.000+08:00"), plusEightTz));
                        + "] to round ["
            Rounding.Prepared prepared = rounding.prepare(min - interval, max);
            assertThat(prevFloor, lessThan(floor));
    public void testPrepareLongRangeRoundsNotToMidnight() {
/*  
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T00:00:00.000Z"), tz));
        assertThat(rounding.round(time("2016-03-27T02:00:00+01:00")), isDate(time("2016-03-27T03:00:00+02:00"), tz));
        ZoneId minusFiveTz = ZoneOffset.of("-05:00");
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).build();  
            assertThat(tzRounding.nextRoundingValue(time), greaterThan(time));
        assertThat(rounding.round(time("2018-03-31T15:25:15.148Z")), isDate(time("2018-03-31T14:00:00Z"), tz));
    /**  
             * range just in case.
    public void testDST_Europe_Rome() {
            int offsetRounded = tz.getRules().getOffset(Instant.ofEpochMilli(roundedDate - 1)).getTotalSeconds();
        Rounding.Prepared prepared = rounding.prepare(min, max);  
import java.time.ZoneId;
        );
    }
            ex.getMessage(),  
        // We want the overlapping hour to count for the previous day here  
        }
        for (String zoneId : JAVA_ZONE_IDS) {  
        assertThat(rounding.prepareJavaTime().nextRoundingValue(1824929914182L), isDate(time("2027-10-31T01:30:00", tz), tz));
            long min = mainDate - 2 * interval;  
import java.util.concurrent.TimeUnit;  
                        + Instant.ofEpochMilli(esRounded)
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR).build();
     * perform a number on assertions and checks on {@link org.opensearch.common.Rounding.TimeUnitRounding} intervals
            // standard +/-1 hour DST transition, CET
        }  
                long javaNextRoundingValue = javaTimeRounding.nextRoundingValue(date);
            assertInterval(time("1991-03-03T02:00:00.000+10:30"), time("1991-03-03T03:00:00.000+10:30"), rounding, 60, tz);
                if (javaNextRoundingValue != esNextRoundingValue) {
        assertThat(rounding.withoutOffset().nextRoundingValue(0), equalTo(oneDay));
        );
        if (randomBoolean()) {
    }
            IllegalArgumentException.class,
        assertThat(emptyTzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-03T01:00:00.000Z"), emptyTz));
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.MINUTES_OF_HOUR), closeTo(129600.0, 0.000001));
     */  
        nextMidnight = time("1990-04-01T00:00:00.000-05:00");  
            long ceiling = rounding.nextRoundingValue(timeBeforeFirstMidnight);
        assertThat(rounding.round(time("2016-03-27T13:00:00+02:00")), isDate(time("2016-03-27T12:00:00+02:00"), tz));
            }
            assertThat(floor, isDate(time("2006-10-28T00:00:00.000-02:30"), tz));
        if (tz.getId().equals("America/St_Johns")  
                long esRounded = prepared.round(date);
        {
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.DAY_OF_MONTH),
        for (Tuple<String, String> dates : expectedDates) {
    }  
 */
 * this work for additional information regarding copyright
        }
        assertThat(rounding.round(time("9000-03-31T15:25:15.148Z")), isDate(time("9000-03-31T15:00:00Z"), tz));
    private static long dateBetween(long lower, long upper) {
        expectedDates.add(new Tuple<>("2011-10-30T02:25:00.000+02:00", "2011-10-30T02:15:00.000+02:00"));
            assertInterval(time("1985-12-31T23:00:00.000+05:30"), time("1986-01-01T01:00:00.000+05:45"), rounding, 105, tz);  
            if (javaRounded != esRounded) {  
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.QUARTER_OF_YEAR).timeZone(tz).build();
        assertThat(tzRounding_chg.round(time("2014-03-09T03:01:01", chg)), isDate(time("2014-03-09T03:00:00", chg), chg));  
            .timeZone(ZoneId.of("America/New_York"))  
        rounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).offset(-twoHours).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
                firstYear = 1999;  
 */  
                            nextRoundingValue - roundedDate,  
    /**
        long firstQuarter = prepared.round(time("2015-01-01T00:00:00.000Z"));
    }
    public void testOtherHardNewtonsMethod() {
     * 1986-01-01T00:15:00+05:45 to 1986-01-01T00:20:00+05:45 to only be 5min
     * adding 15min on 1986-01-01T00:00:00 the interval from  
        assertThat(rounding.withoutOffset().round(0), equalTo(0L));  
        if (transition.getDateTimeBefore().getMinute() == 0) {
        assertThat(tzRounding.round(time("2014-03-09T03:01:01", chg)), isDate(time("2014-03-09T03:00:00", chg), chg));  
        Rounding utcIntervalRounding = Rounding.builder(TimeValue.timeValueHours(2)).build();
        long min = time("01980-01-01T00:00:00Z");
            Rounding.DateTimeUnit unit = randomFrom(Rounding.DateTimeUnit.values());
            long interval = unit.toMillis(unitCount);
    }
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR),
        for (int i = 0; i < 100; i++) {
        Rounding.Prepared prepared = unitRounding.prepare(time("2010-01-01T00:00:00.000Z"), time("2020-01-01T00:00:00.000Z"));  
 * not use this file except in compliance with the License.
            IllegalArgumentException.class,
            assertThat(floor, isDate(time("2006-10-29T00:00:00.000-02:30"), tz));
                            + "] but instead rounded to ["  
        // Test +00:00 timezone format
            // But roundings that change *at* midnight are safe because they don't "jump" to the next day.
        // This means that 2006-10-29 has _two_ midnights, one in the -02:30 offset and one in the -03:30 offset.
            long timeAfterSecondMidnight = time("1978-10-01T00:30:00+01:00");  
                        date,
        Rounding unitRounding = Rounding.builder(TimeValue.timeValueHours(10)).build();  
            assertThat(floor, isDate(time("1978-10-01T00:00:00+02:00"), tz));
        // DST on  
            return new long[] { b1, b2 };
        assertThat(
                    + "only week, day, hour, minute and second are supported for this histogram"
    public void testTimeRounding() {
        ZoneOffsetTransition transition = timezone.getRules().nextTransition(Instant.ofEpochMilli(initialDate));
            assertThat(
}
        long max = time("10000-01-01T00:00:00Z");
            // Only overlaps cause the array rounding to have trouble  
        Rounding tzRounding_chg = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(chg).build();
        long b1 = randomDate();  
            Rounding.Prepared javaTimeRounding = rounding.prepareJavaTime();
            long timeBetweenMidnights = time("2006-10-29T00:00:30.000-02:30");  
            /*  
                description.appendText(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(zonedDateTime) + " [" + expected + "] ");
            for (ZoneOffsetTransitionRule transitionRule : rules.getTransitionRules()) {
        assertThat(tzRounding.nextRoundingValue(time("2009-02-02T20:00:00.000Z")), isDate(time("2009-02-03T08:00:00.000Z"), tz));  
            long floor = rounding.round(timeBetweenMidnights);  
    /**
                            + unit
        // Otherwise use a totally random date
                    assertThat("Rounding should be idempotent", roundedDate, equalTo(prepared.round(roundedDate)));
                            + unitCount  
    private static long time(String time, ZoneId zone) {
                            + tz
         */
                        "Rounding error at {}/{}, timezone {}, interval: {} previousRoundedValue {}/{}",  
            assertInterval(floor, timeBetweenMidnights, ceiling, rounding, tz);
            )  
        Rounding rounding = Rounding.builder(TimeValue.timeValueDays(257)).timeZone(tz).build();
    }  
        assertThat(rounding.round(time("2000-10-29T06:00:00-01:00")), isDate(time("2000-10-29T00:00:00Z"), tz));  
        // Test UTC timezone for TimeIntervalRounding  
        assertThat(tzRounding.round(0), equalTo(0L - TimeValue.timeValueHours(24 + timezoneOffset).millis()));  
    /**
            long floor = rounding.round(timeBeforeFirstMidnight);
         * so we round HOUR_OF_DAY differently.
            Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.HOUR_OF_DAY, tz);  
            .timeZone(ZoneId.of("Asia/Tokyo"))
        assertThat(tzRounding.round(time("2014-03-30T01:01:01", cet)), isDate(time("2014-03-30T01:00:00+01:00"), cet));
    }  
            assertInterval(floor, timeBeforeFirstMidnight, ceiling, rounding, tz);
        return Math.abs(randomLong() % (2 * (long) 10e11)); // 1970-01-01T00:00:00Z - 2033-05-18T05:33:20.000+02:00
    public void testIsUTC() {
        Rounding rounding = new Rounding.TimeUnitRounding(timeUnit, tz);
        Rounding rounding = new Rounding.TimeIntervalRounding(19800000, tz);  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(rounding.round(time("2015-10-25T02:35:00+02:00")), isDate(time("2015-10-25T02:20:00+02:00"), tz));
    public void testTimeIntervalRounding() {
            long ceiling = rounding.nextRoundingValue(timeBetweenMidnights);  
                ZoneOffsetTransition lastTransition = rules.getTransitions().get(rules.getTransitions().size() - 1);
                            "NextRounding value should be interval from rounded value",
        if (transition != null) {
    /**
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T00:00:00.000Z")), isDate(time("2009-02-05T00:00:00.000Z"), tz));
                    assertThat("NextRounding value rounds to itself", nextRoundingValue, isDate(rounding.round(nextRoundingValue), tz));
    public void testUTCTimeUnitRounding() {
            // at 03:45:00 clocks were turned backward 1 hour to 02:45:00
        assertThat(rounding.round(twoHours), equalTo(twoHours));
            int unitCount = randomIntBetween(1, 365);  
    /**
    public void testBeforeOverlapLarge() {  
        Rounding emptyTzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).build();  
        assertThat(rounding.nextRoundingValue(0), equalTo(oneDay - twoHours));
     * Check a {@link Rounding.Prepared#nextRoundingValue} that was difficult
                        prepared.round(roundedDate - 1),
        assertThat(  
            long javaRounded = javaTimeRounding.round(date);
            return date;
    public void testHardNewtonsMethod() {
     * to build well with the java.time APIs.  
        return new long[] { b2, b1 };
            closeTo(10.0 / 24.0, 0.000001)
        assertThat(tzRounding.round(time("2014-10-26T01:01:01", cet)), isDate(time("2014-10-26T01:00:00+02:00"), cet));
    public void testDST_END_Edgecases() {
        long interval = TimeUnit.HOURS.toMillis(12);
                    "Expected ["
import org.opensearch.common.unit.TimeValue;
            Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.HOUR_OF_DAY, tz);
        long midnightAfterTransition = time("1990-04-01T00:00:00.000-05:00");
                    if (tz.getRules().isFixedOffset()) {  
        }
            tz,
                        lessThan(roundedDate)  
        ZoneId tz = ZoneId.of("America/Moncton");
        long date = initialDate;  
                    fail(
            assertThat(ceiling, isDate(time("2006-10-29T00:00:00.000-02:30"), tz));  
        assertThat(tzRounding.round(time("2012-01-10T01:01:01")), isDate(time("2012-01-09T00:00:00.000Z"), tz));  
        assertEquals(TimeUnit.MINUTES.toMillis(45), time("2011-10-30T02:15:00.000+02:00") - time("2011-10-30T01:30:00.000+02:00"));
            } else {
        Rounding zoneOffsetUtcRounding = Rounding.builder(Rounding.DateTimeUnit.SECOND_OF_MINUTE).timeZone(ZoneOffset.UTC).build();  
 * You may obtain a copy of the License at  
                        + "] but instead was to ["
                    + "]",
        assertThat(
            // 25 Oct 2015 - Daylight Saving Time Ended  
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.MONTH_OF_YEAR), closeTo(3.0, 0.000001));  
import java.util.ArrayList;
     * test DST end with interval rounding  
            isDate(nextRoundingValue, tz)
            ZoneId tz = ZoneId.of("Pacific/Chatham");  
        ZoneId tz = ZoneId.of("Australia/Lord_Howe");  
                    throw e;
            tz,
        long previousDate = Long.MIN_VALUE;  
            int lastYear = 2050;  
            long max = mainDate + 2 * interval;
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.MONTH_OF_YEAR)
    private void assertInterval(long rounded, long nextRoundingValue, Rounding rounding, int minutes, ZoneId tz) {
        expectedDates.add(new Tuple<>("2011-10-30T01:40:00.000+02:00", "2011-10-30T01:30:00.000+02:00"));  
        assertThat(rounding.round(time("1986-01-01T00:16:00+05:45")), isDate(time("1986-01-01T00:15:00+05:45"), tz));  
import java.time.zone.ZoneOffsetTransitionRule;
            assertThat(ceiling, isDate(time("2006-10-30T00:00:00.000-03:30"), tz));
        assertThat(tzRounding.round(time("2014-11-11T17:00:00", tz)), isDate(tzRounding.round(time("2014-08-11T17:00:00", tz)), tz));
    public void testForwardsBackwardsTimeZones() {
        assertThat(tzRounding.round(time("2014-08-11T17:00:00", tz)), isDate(time("2014-08-11T00:00:00", tz), tz));
     * rounding unit interval that is defined by this. Assumptions tested are
                        "Expected ["  
        );
        }  
     */
            for (ZoneOffsetTransition transition : rules.getTransitions()) {  
            equalTo(
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).build();
            }  
        // Day interval  
            assertInterval(time("2015-04-05T02:00:00.000+13:45"), time("2015-04-05T03:00:00.000+13:45"), rounding, 60, tz);  
        assertThat(rounding.round(time("2003-10-26T03:43:35.079Z")), isDate(time("2003-10-26T03:00:00Z"), tz));
        );
            ZonedDateTime zonedDateBetween = ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateBetween), tz);  
            // at 02:00:00 clocks were turned forward 1 hour to 03:00:00
        assertTrue(utcUnitRounding.isUTC());
                            + Instant.ofEpochMilli(javaRounded)
    public void testDST_America_St_Johns() {
        }
            closeTo(36000.0, 0.000001)
            ex.getMessage(),
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();
     * {@link org.opensearch.common.Rounding.DateTimeUnit} and {@link ZoneId} and often (50% of the time)  
        long next = rounding.prepareForUnknown().nextRoundingValue(rounded);  
            );
    }  
        nextMidnight = time("1990-04-02T00:00:00.000-05:00");
            }
        ZoneId tz = ZoneId.of("America/Detroit");  
     */
        // Month interval
            // if the interval defined didn't cross timezone offset transition, it should cover unitMillis width  
    private void checkForForwardsBackwardsTransition(ZoneId tz, ZoneOffsetTransition transition) {  
    public void testPrepareLongRangeRoundsToMidnight() {
            }
            assertThat("nextRounding value should be greater than date" + rounding, nextRoundingValue, greaterThan(unrounded));
        assertThat(tzRounding.nextRoundingValue(time("2014-10-26T01:00:00", cet)), isDate(time("2014-10-26T02:00:00+02:00"), cet));  
            // 27 Oct 1991 - Daylight Saving Time Started  
        assertThat(prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.HOUR_OF_DAY), closeTo(1.0, 0.000001));
        // DST on
    }
        {
                long date = dateBetween(min, max);  
                "Cannot use month-based rate unit [quarter] with fixed interval based histogram, "
        // Test fixed offset timezones that are not UTC
            closeTo(600.0, 0.000001)
        tzRounding = Rounding.builder(TimeValue.timeValueHours(48)).build();  
        Rounding tzRounding;
                            + Instant.ofEpochMilli(esNextRoundingValue)
 *
            // 3 Mar 1991 - Daylight Saving Time Ended  
            ZoneId tz = randomZone();  
                assertThat(
     * Test for a time zone whose days overlap because the clocks are set back across midnight at the end of DST.
        assertThat(tzRounding.nextRoundingValue(time("2014-03-30T03:00:00", cet)), isDate(time("2014-03-30T04:00:00", cet), cet));
        long max = time("10000-01-01T00:00:00Z");
    public void testNonMillisecondsBasedUnitCalendarRoundingSize() {
        Rounding dayTzRounding = new Rounding.TimeIntervalRounding(60000, tz);
        assertThat(tzRounding.round(time("2009-02-03T00:01:01")), isDate(time("2009-02-02T20:00:00.000Z"), tz));
        // Test non-UTC timezone for TimeUnitRounding
        ZoneId tz = ZoneId.of("CET");
         * to QUARTER_OF_YEAR properly.  
        // Check that rounding is internally consistent and consistent with nextRoundingValue
        assertThat(rounding.withoutOffset().nextRoundingValue(0), equalTo(oneDay));
        assertThat(rounding.round(time("2016-03-27T01:41:00+01:00")), isDate(time("2016-03-27T01:30:00+01:00"), tz));  
    public void testTimeIntervalCET_DST_Start() {
        }
        assertThat(
     * To be even more nasty, go to a transition in the selected time zone.
        );
        long thirdQuarter = prepared.round(time("2015-07-01T00:00:00.000Z"));
     */
import java.time.Instant;
/*  
            // at 02:00:00 clocks were turned forward 0:30 hours to 02:30:00
    /**  
            for (int d = 0; d < 100; d++) {
     * special test for DST switch from #9491
        long interval = TimeUnit.MINUTES.toMillis(20);
        );  
                "Cannot use month-based rate unit [month] with fixed interval based histogram, "
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat(
            IllegalArgumentException.class,
            }
        assertThat(tzRounding.round(time("2009-02-03T02:01:01")), isDate(time("2009-02-03T02:00:00"), tz));  
        assertFalse(fixedOffsetRounding.isUTC());  
            assertInterval(time("2015-03-29T03:00:00.000+02:00"), time("2015-03-29T04:00:00.000+02:00"), rounding, 60, tz);
            assertInterval(time("1986-01-01T01:00:00.000+05:45"), time("1986-01-01T02:00:00.000+05:45"), rounding, 60, tz);
                "Cannot use month-based rate unit [year] with fixed interval based histogram, "  
            transition.getDateTimeAfter(),
            )  
             * round might spit out a time below the min if min is near a  
            for (long date = min; date < max; date += interval / 2) {  
        }
        ZoneId tz = ZoneId.of("Australia/Lord_Howe");  
        long twoHours = TimeUnit.HOURS.toMillis(2);
        }
        Rounding.Prepared javaTimeRounding = rounding.prepareJavaTime();
            assertInterval(time("2015-04-05T03:00:00.000+12:45"), time("2015-04-05T04:00:00.000+12:45"), rounding, 60, tz);
    public void testHardNextRoundingValue() {  
        Rounding tzRounding = Rounding.builder(Rounding.DateTimeUnit.MONTH_OF_YEAR).build();  
        assertThat(tzRounding.round(time("2014-10-26T01:30:00+02:00")), isDate(time("2014-10-26T01:00:00+02:00"), tz));  
 * The OpenSearch Contributors require contributions made to  
        if (randomBoolean()) {
        long rounded = rounding.prepareJavaTime().round(972780720000L);
            ZoneId tz = ZoneId.of("Australia/Lord_Howe");
                        + Instant.ofEpochMilli(javaNextRoundingValue)  
     * test DayIntervalRounding, (interval &gt;= 12h) with time zone shift  
import java.time.ZonedDateTime;
            assertInterval(time("2015-03-29T00:00:00.000+01:00"), time("2015-03-29T01:00:00.000+01:00"), rounding, 60, tz);
        // Test UTC timezone with offset
        assertThat(rounding.round(time("2015-10-25T02:55:00+02:00")), isDate(time("2015-10-25T02:40:00+02:00"), tz));
     * test DST start with interval rounding
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).offset(twoHours).build();
            long floor = rounding.round(timeBeforeFirstMidnight);  
                        + rounding  
            Rounding aliasUnitRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneId.of(utcAlias)).build();
    }
        assertThat(rounding.round(time("2006-12-31T13:21:44.308Z")), isDate(time("2006-09-30T20:00:00Z"), tz));
        long unitMillis = unit.getField().getBaseUnit().getDuration().toMillis();  
            assertThat(  
        ZoneId tz = ZoneId.of("-08:00");  
        assertThat(prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.HOUR_OF_DAY), closeTo(10.0, 0.000001));
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.QUARTER_OF_YEAR), closeTo(1.0, 0.000001));
    }
                        + "] but instead rounded to ["
import static org.hamcrest.Matchers.equalTo;  
            date = dateBetween(start, end);  
        ex = expectThrows(
            // Clocks went back at 00:01 in 1969, causing overlapping days.  
                            + " "
    /**
        // Moncton has a perfectly normal hour long Daylight Savings time.
        assertThat(tzRounding_chg.round(time("2013-11-03T06:01:01", chg)), isDate(time("2013-11-03T06:00:00", chg), chg));
            //
        assertThat(tzRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-02-02T02:00:00"), tz));
        expectedDates.add(new Tuple<>("2011-10-30T02:32:30.000+01:00", "2011-10-30T02:15:00.000+01:00"));
        assertThat("nextRounding value should be a rounded date", rounding.round(nextRoundingValue), isDate(nextRoundingValue, tz));  
    }
            long timeBetweenMidnights = time("2006-10-28T23:30:00.000-03:30");
import org.hamcrest.Description;  
        ex = expectThrows(
                    + "histogram [hour] only week, day, hour, minute and second are supported for this histogram"
            );
            assertThat(dates.toString(), roundedDate, isDate(time(dates.v2()), tz));  
     * on DST start  
        Rounding nonUtcIntervalRounding = Rounding.builder(TimeValue.timeValueHours(2)).timeZone(ZoneId.of("Europe/Berlin")).build();
        }  
        assertThat(next, greaterThan(rounded));  
        assertThat(tzRounding.nextRoundingValue(time("2012-01-09T00:00:00.000Z")), isDate(time("2012-01-09T00:00:01.000Z"), tz));
        assertEquals(TimeUnit.MINUTES.toMillis(45), time("2011-10-30T03:00:00.000+01:00") - time("2011-10-30T02:15:00.000+01:00"));
     * test TimeIntervalRounding, (interval &lt; 12h) with time zone shift
                    nextRoundingValue - roundedDate,  
    }  
    }
            prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.SECOND_OF_MINUTE),
    public void testQuarterOfYear() {
 *
            equalTo(TimeValue.timeValueHours(-timezoneOffset).millis())  
            assertInterval(time("2015-10-25T01:00:00.000+02:00"), time("2015-10-25T02:00:00.000+02:00"), rounding, 60, tz);
    public void testUTCIntervalRounding() {
    public void testIntervalRounding_HalfDay_DST() {  
            int year = randomFrom(firstYear, lastYear);
    /**
            ex.getMessage(),
        assertInterval(roundedDate, date, nextRoundingValue, rounding, tz);
        assertThat(rounding.round(time("1986-01-01T00:26:00+05:45")), isDate(time("1986-01-01T00:20:00+05:45"), tz));
            int firstYear;  
    public void testIntervalRoundingMonotonic_CET() {  
    /**
        Rounding rounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();  
                        "Expected ["
            // 27 Sep 2015 - Daylight Saving Time Started
        Rounding plusEightRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(ZoneOffset.of("+08:00")).build();  
        long rounded = rounding.prepareForUnknown().round(877824908400L);
        long interval = TimeUnit.MINUTES.toMillis(45);
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.QUARTER_OF_YEAR)  
            () -> prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.YEAR_OF_CENTURY)
                            + " "
        IllegalArgumentException ex = expectThrows(
            long floor = rounding.round(timeBetweenMidnights);
            assertInterval(time("2015-10-25T02:00:00.000+02:00"), time("2015-10-25T02:00:00.000+01:00"), rounding, 60, tz);  
    /**  
            if (offsetRounded == offsetNextValue) {  
                // Pick an arbitrary year to start the range
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(tz).build();
        // Ratio based
            ZoneId tz = randomZone();  
        Rounding rounding = new Rounding.TimeUnitRounding(unit, tz);
    public void testTimeUnitRoundingDST() {  
     * chooses test dates that are exactly on or close to offset changes (e.g.
        {
        );  
import java.time.ZoneOffset;  
     * CET: 27 March 2016, 02:00:00 clocks were turned forward 1 hour to 27 March 2016, 03:00:00 local daylight time  
 * this file be licensed under the Apache-2.0 license or a
            return t <= time("1987-10-01T00:00:00Z") || t >= time("2010-12-01T00:00:00Z");
            .build();
        assertThat(prepared.roundingSize(time("2015-01-01T00:00:00.000Z"), Rounding.DateTimeUnit.MINUTES_OF_HOUR), closeTo(60.0, 0.000001));
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T13:00:00.000Z")), isDate(time("2009-02-03T19:00:00.000Z"), tz));
        assertThat(tzRounding.round(time("2009-02-05T13:01:01")), isDate(time("2009-02-05T00:00:00.000Z"), tz));  
        assertThat(time("1986-01-01T00:15:00+05:45") - time("1985-12-31T23:40:00+05:30"), equalTo(TimeUnit.MINUTES.toMillis(20)));
        assertThat(rounding.round(time("2015-10-25T02:55:00+01:00")), isDate(time("2015-10-25T02:40:00+01:00"), tz));  
        }
    }  
    }
    }
            return date + (randomLong() % unitMillis);  // positive and negative offset possible
            || tz.getId().equals("Canada/Newfoundland")) {  
    }
        assertThat(rounding.round(time("2015-10-25T02:15:00+01:00")), isDate(time("2015-10-25T02:00:00+01:00"), tz));
            assertInterval(time("2015-09-27T02:00:00.000+12:45"), time("2015-09-27T04:00:00.000+13:45"), rounding, 60, tz);
        return true;
            int offsetNextValue = tz.getRules().getOffset(Instant.ofEpochMilli(nextRoundingValue + 1)).getTotalSeconds();
    }
                    logger.error(
    }
        assertThat(prepared.round(time("9000-12-31T13:21:44.308Z")), isDate(time("9000-10-01T04:00:00Z"), tz));
         * Lord Howe is fun because Daylight Savings time is only 30 minutes  
        expectedDates.add(new Tuple<>("2011-10-30T02:55:00.000+01:00", "2011-10-30T02:15:00.000+01:00"));  
            assertThat(ceiling, isDate(time("2006-10-29T00:00:00.000-02:30"), tz));  
     * time can land in a DST gap which results in wrong UTC rounding values.
            long esRounded = prepared.round(date);
        if (unitMillis <= 86400 * 1000) {
                            + "]"
        assertThat(quarterUtcRounding.round(time("2009-02-03T01:01:01")), isDate(time("2009-01-01T00:00:00.000Z"), plusZeroZeroTz));
            // (this is halfway through the last minute before the clocks changed, in which local time was ambiguous)
        return DateFormatters.from(accessor).toInstant().toEpochMilli();
        assertThat(prepared.roundingSize(firstQuarter, Rounding.DateTimeUnit.SECOND_OF_MINUTE), closeTo(7776000.0, 0.000001));
        // Test +8:00 timezone format
        final long nextRoundingValue = prepared.nextRoundingValue(roundedDate);  
                "Cannot use month-based rate unit [month] with non-month based calendar interval "  
        assertThat(tzRounding.nextRoundingValue(time("2009-02-03T08:00:00.000Z")), isDate(time("2009-02-03T20:00:00.000Z"), tz));  
        TemporalAccessor accessor = DateFormatter.forPattern("date_optional_time").withZone(zone).parse(time);  
        // first date is the date to be rounded, second the expected result
        assertThat(
        ZoneId tz = ZoneId.of("America/Glace_Bay");  
import java.util.List;
 * software distributed under the License is distributed on an
        midnightBeforeTransition = time("1990-03-31T00:00:00.000-04:00");
     */
 * Licensed to Elasticsearch under one or more contributor  
        long dateBetween = randomLongBetween(lower, upper - 1);
            // at 02:45:00 clocks were turned forward 1 hour to 03:45:00
                        tz,  
        );  
     * @param nextRoundingValue the expected upper end of the rounding interval
        assertThat(tzRounding.round(time("2012-04-01T04:15:30Z")), isDate(time("2012-03-31T08:00:00Z"), tz));
        assertInterval(rounded, dateBetween(rounded, nextRoundingValue), nextRoundingValue, rounding, tz);
    }  
    /**
        Rounding tzRounding = Rounding.builder(Rounding.DateTimeUnit.HOUR_OF_DAY).timeZone(tz).build();
            .offset(3600000)
            IllegalArgumentException.class,
        }
            )
            Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.HOUR_OF_DAY, tz);
        assertThat(tzRounding.nextRoundingValue(time("2014-10-26T02:00:00", cet)), isDate(time("2014-10-26T02:00:00+01:00"), cet));
            return;
        assertThat(tzRounding.nextRoundingValue(time("2009-02-01T00:00:00.000Z")), isDate(time("2009-03-01T00:00:00.000Z"), tz));  
            // 29 Mar 2015 - Daylight Saving Time Started  
        Rounding rounding = new Rounding.TimeUnitRounding(Rounding.DateTimeUnit.DAY_OF_MONTH, tz);  
        ZoneId tz = ZoneId.of("CET");  
        assertThat(  
                            + "] but instead was to ["  
        /*  
        long midnightOfTransition = time("2000-10-29T00:00:00-01:00");  
            millisSinceEpoch - twoHours,  
        assertThat(rounding.round(time("2018-03-31T15:25:15.148Z")), isDate(time("2018-03-31T14:00:00Z"), tz));
                "Cannot use month-based rate unit [year] with non-month based calendar interval "
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.SECOND_OF_MINUTE).build();
    public void testLenientConversionDST() {
                        + Instant.ofEpochMilli(date)
        ZoneId tz = ZoneId.of("America/Sao_Paulo");  
            ZoneId tz = ZoneId.of("CET");  
        assertThat(rounding.round(time("2015-10-25T01:55:00+02:00")), isDate(time("2015-10-25T01:40:00+02:00"), tz));
            .build();
        assertThat(rounding.round(time("2015-10-25T02:15:00+02:00")), isDate(time("2015-10-25T02:00:00+02:00"), tz));  
        tzRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(tz).build();  
     */  
            // (this is halfway through the hour after the clocks changed, in which local time was ambiguous)  
import org.opensearch.test.OpenSearchTestCase;
            ZoneId tz = ZoneId.of("Asia/Kathmandu");
                isDate(rounded, tz)
        assertThat(rounding.round(time("2006-12-31T13:21:44.308Z")), isDate(time("2006-10-01T04:00:00Z"), tz));  
        Rounding.Prepared prepared = unitRounding.prepare(time("2010-01-01T00:00:00.000Z"), time("2020-01-01T00:00:00.000Z"));
                "dateBetween ["
            Rounding.DateTimeUnit.DAY_OF_MONTH,
        assertInterval(midnightAfterTransition, nextMidnight, rounding, 24 * 60, tz);  
        ZoneId tz = ZoneId.of("Asia/Jerusalem");
            public boolean matchesSafely(final Long item) {
                long esNextRoundingValue = prepared.nextRoundingValue(date);  
        rounding = new Rounding.TimeUnitRounding(timeUnit, tz);  
            // which is not a round value for hourly rounding
            long floor = rounding.round(timeAfterSecondMidnight);
        if (b1 < b2) {
        Rounding minusFiveRounding = Rounding.builder(Rounding.DateTimeUnit.DAY_OF_MONTH).timeZone(ZoneOffset.of("-05:00")).build();  
    private static boolean isTimeWithWellDefinedRounding(ZoneId tz, long t) {
            long dateBetween = dateBetween(rounded, nextRoundingValue);
