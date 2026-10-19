        assertTrue(
/*  
 * the Apache License, Version 2.0 (the "License"); you may
                return beforeGapValue;
                fail("Shouldn't be called");  
        assertThat(lookup.lookup(overlapEnds), sameInstance(secondMidnightOffset));
            }  
    /**
        assertRoundingAtOffset(lookup.lookup(min), min, -TimeUnit.HOURS.toMillis(7));
         */
            @Override
        assertThat(secondMidnightOffset.localToUtc(localFirstMidnight, useValueForOverlap(overlapValue)), equalTo(overlapValue));
                return 0;
        };  
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(zone, Long.MIN_VALUE, Long.MAX_VALUE);
        int size,  
                fail("Shouldn't be called");
        assertThat(Instant.ofEpochMilli(min), lessThan(lastTransitionIn(zone).getInstant()));
        List<ZoneOffsetTransition> transitions = zone.getRules().getTransitions();
            min = max;  
import static org.hamcrest.Matchers.nullValue;
        long max,  
                return 0;
    }
 * Modifications Copyright OpenSearch Contributors. See
     * America/Tijuana's
        long secondMidnight = utcTime("1978-09-30T23:00:00");
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new LocalTimeOffset.Strategy() {
            }
        assertThat(localAtTransition - localBeforeTransition, equalTo(gapLength + 1));
        long localOverlapEnds = secondMidnightOffset.utcToLocalTime(overlapEnds);
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertRoundingAtOffset(lookup.lookup(between), between, betweenOffset);
            public long beforeGap(long localMillis, Gap gap) {
        assertRoundingAtOffset(randomBoolean() ? fixed : fixedInRange, randomLong(), offsetMillis);
        /*
 * not use this file except in compliance with the License.
        if (Runtime.version().compareTo(Version.parse("11")) > 0) {
            @Override
            }
    }
import static org.hamcrest.Matchers.notNullValue;  
         * Asia/Kathmandu turned their clocks 15 minutes forward at  
            }  
 * GitHub history for details.
    }
        long max = randomValueOtherThan(min, OpenSearchTestCase::randomLong);  
        assertThat(beforeGapOffset.localToUtcInThisOffset(localBeforeTransition), equalTo(transition - 1));
        assertThat(  
                fail("Shouldn't be called");
     * size assertion.  
    }
import org.opensearch.common.time.DateFormatter;  
            public long inOverlap(long localMillis, Overlap overlap) {
            public long inGap(long localMillis, Gap gap) {  
        assertTransitions(zone, min, max, time("2020-06-01", zone), min + hours(1), 3, hours(-5), hours(-4));  
        assertTransitions(zone, min, max, time("2000-06-01", zone), min + hours(1), 83, hours(-5), hours(-4));  
        long min = time("2020-01-01", zone);  
        assertThat(gapOffset.localToUtc(localBeforeTransition, useValueForBeforeGap(beforeGapValue)), equalTo(beforeGapValue));  
            }
        assertKnownMovesBacktoPreviousDay("America/St_Johns", "2010-11-07T02:31:00");
        long time = time("2000-10-30T00:00:00", zone);
    public void testLastTransitionWithoutRules() {
        long localSkippedTime = randomLongBetween(localBeforeTransition, localAtTransition);  
        assertRoundingAtOffset(LocalTimeOffset.lookup(zone, time, time).lookup(time), time, hours(-5));
    }
    }
        return new LocalTimeOffset.Strategy() {
            @Override
            }
    private static long time(String time, ZoneId zone) {
    }
 */
        assertThat(Instant.ofEpochMilli(max), lessThan(lastTransitionIn(zone).getInstant()));
    public void testSingleTimeBeforeRules() {  
        assertThat(lookup.size(), equalTo(1));
     * use the transitions will produce incorrect results, failing the
        long localOverlappingTime = randomLongBetween(localFirstMidnight, localOverlapEnds);
        long min = time("1980-01-01", zone);
    }
            public long inOverlap(long localMillis, Overlap overlap) {  
    }  
            public long inGap(long localMillis, Gap gap) {  
        ZoneId zone = ZoneId.of("America/Tijuana");  
        assertRoundingAtOffset(lookup.lookup(time - 1), time - 1, TimeUnit.MINUTES.toMillis(330));  
            assertKnownMovesBacktoPreviousDay("Pacific/Saipan", "1969-01-25T13:01:00");
    private static LocalTimeOffset.Strategy useValueForBeforeOverlap(long beforeOverlapValue) {  
        assertThat(LocalTimeOffset.lookup(zone, Long.MIN_VALUE, Long.MAX_VALUE), nullValue());
            equalTo(beforeOverlapValue)
        long between,
        assertThat(Instant.ofEpochMilli(max), greaterThan(lastTransitionIn(zone).getInstant()));
                fail("Shouldn't be called");  
                fail("Shouldn't be called");  
        long min = time("1980-01-01", zone);  
     * have to collect them independently. That will trip assertions, failing  
            public long beforeOverlap(long localMillis, Overlap overlap) {  
    public void testLastTransitionOverlapsRules() {
        ZoneId zone = ZoneId.of("America/New_York");
        return TimeUnit.HOURS.toMillis(hours);
        assertThat(offset.localToUtcInThisOffset(time + offsetMillis), equalTo(time));
            public long beforeGap(long localMillis, Gap gap) {  
import java.time.ZoneOffset;  
            @Override
 * Licensed to Elasticsearch under one or more contributor  
         * normal, but they rolled back past midnight which is pretty rare and neat.  
        assertRoundingAtOffset(lookup.lookup(max), max, minMaxOffset);
    public void testJustTransitions() {
        /*  
    private static ZoneOffsetTransition lastTransitionIn(ZoneId zone) {  
            @Override
            LocalTimeOffset.lookup(ZoneId.of(zone), utc, utc + 1).anyMoveBackToPreviousDay()  
            }
        assertThat(fixedInRange.anyMoveBackToPreviousDay(), equalTo(false));  
        long time = time("1980-01-01", zone);
            @Override
        long overlapEnds = utcTime("1978-10-01T0:00:00");  
    private void assertFixedOffset(ZoneId zone, long offsetMillis) {  
        long max = time("2021-01-01", zone) - 1;
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(tz, transition - 1, transition);  
        return new LocalTimeOffset.Strategy() {
                return 0;
            }
        return new LocalTimeOffset.Strategy() {  
        assertRoundingAtOffset(LocalTimeOffset.lookup(zone, time, time).lookup(time), time, hours(-5));
    public void testJustOneRuleApplies() {
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(zone, min, max);  
         * 1986-01-01T00:00:00 local time and hasn't changed time since.
            secondMidnightOffset.localToUtc(localFirstMidnight - 1, useValueForBeforeOverlap(beforeOverlapValue)),
        assertThat(lookup.size(), equalTo(2));
 * this work for additional information regarding copyright
    public void testSingleTimeAfterRules() {
                fail("Shouldn't be called");
            }  
                return 0;
            }
 *
                return 0;
        long localBeforeTransition = beforeGapOffset.utcToLocalTime(transition - 1);
         */
            max = s;
        assertThat(secondMidnightOffset.localToUtc(localOverlapEnds, unusedStrategy()), equalTo(overlapEnds));  
        assertRoundingAtOffset(LocalTimeOffset.lookup(zone, time, time).lookup(time), time, hours(-1));
import java.lang.Runtime.Version;  
            public long inOverlap(long localMillis, Overlap overlap) {
        LocalTimeOffset secondMidnightOffset = lookup.lookup(secondMidnight);
        assertThat(fixedInRange, notNullValue());
        long utc = utcTime(time);  
        assertThat(secondMidnightOffset.localToUtcInThisOffset(localFirstMidnight), equalTo(secondMidnight));
    private static LocalTimeOffset.Strategy useValueForOverlap(long overlapValue) {  
        long beforeGapValue = randomLong();
        if (min > max) {
            secondMidnightOffset.localToUtcInThisOffset(localOverlappingTime),
        }
     */
     * with its {@link ZoneRules#getTransitionRules() future rules} and if
            @Override
        assertThat(localSecondMidnight - localFirstMidnight, equalTo(0L));  
     * The last "fully defined" transitions in the provided {@linkplain ZoneId}.
    }
                return 0;
            @Override
            @Override
import java.time.ZoneId;
    }  
                fail("Shouldn't be called");  
import java.util.concurrent.TimeUnit;
        LocalTimeOffset gapOffset = lookup.lookup(transition);
        long min = randomLong();
        long time = time("1986-01-01T00:00:00", zone);  
        assertFixedOffset(zone, zone.getTotalSeconds() * 1000);  
         * 1986-01-01T00:00:00, creating a really "fun" gap.
        assertThat(lookup.anyMoveBackToPreviousDay(), equalTo(false));  
            }
        assertKnownMovesBacktoPreviousDay("America/Goose_Bay", "2010-11-07T03:01:00");
 * specific language governing permissions and limitations
    public void testAfterRules() {
        assertKnownMovesBacktoPreviousDay("America/Moncton", "2006-10-29T03:01:00");  
    }
                return 0;
        assertThat(firstMidnightOffset.localToUtcInThisOffset(localFirstMidnight), equalTo(firstMidnight));  
        assertThat(LocalTimeOffset.lookup(zone, min, max).fixedInRange(utcTime("2000-06-01"), utcTime("2000-06-02")), notNullValue());
    }
    private void assertKnownMovesBacktoPreviousDay(String zone, String time) {
        ZoneId zone = ZoneId.of("Asia/Kathmandu");
import java.time.Instant;
    }
            }  
    public void testUtc() {  
        ZoneOffset zone = ZoneOffset.ofTotalSeconds(between((int) -TimeUnit.HOURS.toSeconds(18), (int) TimeUnit.HOURS.toSeconds(18)));
    // Some sanity checks for when you pas a single time. We don't expect to do this much but it shouldn't be totally borked.
                return overlapValue;
                fail("Shouldn't be called");
        ZoneId zone = ZoneId.of("Atlantic/Azores");  
            public long beforeOverlap(long localMillis, Overlap overlap) {
            public long inOverlap(long localMillis, Overlap overlap) {
         * Asia/Kathmandu turned their clocks 15 minutes forward at
 *  
    public void testOverlap() {  
 * Unless required by applicable law or agreed to in writing,
        long transition = time("1986-01-01T00:00:00", tz);
    }
            public long inGap(long localMillis, Gap gap) {
            @Override
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(tz, firstMidnight, overlapEnds);
}  
        assertThat(LocalTimeOffset.fixedOffset(zone), nullValue());  
    }
 * ownership. Elasticsearch licenses this file to you under  
            public long inGap(long localMillis, Gap gap) {  
        long max = utcTime("2011-11-06T09:02:57.091Z");
         */
        LocalTimeOffset firstMidnightOffset = lookup.lookup(firstMidnight);
    ) {  
                return 0;
 * license agreements. See the NOTICE file distributed with
            }  
        LocalTimeOffset beforeGapOffset = lookup.lookup(transition - 1);  
                fail("Shouldn't be called");  
    private void assertRoundingAtOffset(LocalTimeOffset offset, long time, long offsetMillis) {
        assertRoundingAtOffset(lookup.lookup(min), min, minMaxOffset);  
        long min,
     */
        return DateFormatter.forPattern("date_optional_time").withZone(zone).parseMillis(time);  
                fail("Shouldn't be called");  
import static org.hamcrest.Matchers.sameInstance;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ZoneId tz = ZoneId.of("Asia/Kathmandu");  
        long overlapMillis = TimeUnit.HOURS.toMillis(1);  
    public void testNotFixed() {
        assertThat(Instant.ofEpochMilli(time), greaterThan(lastTransitionIn(zone).getInstant()));
        long localAtTransition = gapOffset.utcToLocalTime(transition);
                fail("Shouldn't be called");  
    private static LocalTimeOffset.Strategy useValueForGap(long gapValue) {  
import static org.hamcrest.Matchers.greaterThan;
        LocalTimeOffset fixedInRange = lookup.fixedInRange(min, max);
        assertThat(lookup.fixedInRange(min, sameOffsetAsMin), sameInstance(lookup.lookup(min)));
        };  
    public void testFixedOffset() {
    private static long utcTime(String time) {
            @Override
        );  
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(zone, time - 1, time);
import org.opensearch.common.LocalTimeOffset.Gap;
        assertThat(firstMidnightOffset.localToUtcInThisOffset(localFirstMidnight - 1), equalTo(firstMidnight - 1));
            @Override
import java.util.List;  
        ZoneId zone = ZoneId.of("America/New_York");  
         * Europe/Rome turn their clocks back an hour 1978 which is totally
        long overlapValue = randomLong();
        assertThat(Instant.ofEpochMilli(min), greaterThan(lastTransitionIn(zone).getInstant()));
import java.time.zone.ZoneRules;
        assertRoundingAtOffset(lookup.lookup(max), max, -TimeUnit.HOURS.toMillis(8));  
            assertKnownMovesBacktoPreviousDay("Pacific/Guam", "1969-01-25T13:01:00");  
                return 0;
import org.opensearch.test.OpenSearchTestCase;
        ZoneId zone = ZoneId.of("America/New_York");
            }
    }
    }
            // Added in java 12
        assertThat(gapOffset.localToUtc(localSkippedTime, useValueForGap(gapValue)), equalTo(gapValue));
                fail("Shouldn't be called");  
 * You may obtain a copy of the License at  
        assertThat(offset.utcToLocalTime(time), equalTo(time + offsetMillis));  
        assertThat(secondMidnightOffset.localToUtc(localOverlappingTime, useValueForOverlap(overlapValue)), equalTo(overlapValue));
 * this file be licensed under the Apache-2.0 license or a
            @Override
 */  
        assertThat(gapOffset.localToUtcInThisOffset(localAtTransition), equalTo(transition));  
    public void testGap() {
        assertThat(gapOffset.localToUtc(localAtTransition, unusedStrategy()), equalTo(transition));
    public void testTransitionsWithTransitionsAndRules() {  
            public long inOverlap(long localMillis, Overlap overlap) {  
        };  
        assertTransitions(zone, min, max, time("1980-06-01", zone), min + hours(1), 3, hours(-5), hours(-4));  
     * we're not careful we can end up with duplicate transitions because we
            public long beforeOverlap(long localMillis, Overlap overlap) {
        assertThat(  
                return 0;
/*  
    public void testKnownMovesBackToPreviousDay() {
        assertFixedOffset(ZoneId.of("UTC"), 0);
 * under the License.  
        assertRoundingAtOffset(lookup.lookup(time), time, TimeUnit.MINUTES.toMillis(345));
            }
            public long beforeOverlap(long localMillis, Overlap overlap) {
 *
/*
            @Override
            @Override
     * this test real fast. If they don't trip the assertions then trying to
            zone + " just after " + time + " should move back",
        assertThat(localOverlapEnds - localSecondMidnight, equalTo(overlapMillis));  
        return transitions.get(transitions.size() - 1);
        ZoneId zone = ZoneId.of("America/New_York");
                return 0;
    public void testRangeTooLarge() {
            @Override
    }
        };  
            public long beforeGap(long localMillis, Gap gap) {  
        long gapLength = TimeUnit.MINUTES.toMillis(15);
        long min = utcTime("2011-11-06T08:31:57.091Z");
            }
    /**  
            public long beforeOverlap(long localMillis, Overlap overlap) {
    private void assertTransitions(  
                return 0;
            public long inGap(long localMillis, Gap gap) {  
            @Override
        long localSecondMidnight = secondMidnightOffset.utcToLocalTime(secondMidnight);  
 * software distributed under the License is distributed on an
        LocalTimeOffset fixed = LocalTimeOffset.fixedOffset(zone);
        long max = time("2021-01-01", zone) - 1;  
        ZoneId tz = ZoneId.of("Europe/Rome");
    }
        assertThat(lookup.size(), equalTo(2));
    private static LocalTimeOffset.Strategy useValueForBeforeGap(long beforeGapValue) {  
        assertThat(secondMidnightOffset.localToUtcInThisOffset(localOverlapEnds), equalTo(overlapEnds));
        assertKnownMovesBacktoPreviousDay("America/Moncton", "2005-10-29T03:01:00");
 * The OpenSearch Contributors require contributions made to  
    }
                fail("Shouldn't be called");  
        long betweenOffset
            }
        };  
     * {@link ZoneRules#getTransitions() fully defined transitions} overlap  
                return 0;
    }  
 */  
        long minMaxOffset,
import org.opensearch.common.LocalTimeOffset.Overlap;
                fail("Shouldn't be called");
        long firstMidnight = utcTime("1978-09-30T22:00:00");
            }  
        ZoneId zone = ZoneId.of("America/New_York");
    private static long hours(long hours) {  
         * This has broken the transition collection code in the past.  
        ZoneId zone = ZoneId.of("America/New_York");
import static org.hamcrest.Matchers.equalTo;  
 * compatible open source license.
                return gapValue;
    private static LocalTimeOffset.Strategy unusedStrategy() {
            @Override
        return DateFormatter.forPattern("date_optional_time").parseMillis(time);
            }
                return 0;
                fail("Shouldn't be called");
        long max = time("1981-01-01", zone) - 1;
        ZoneId zone,
            equalTo(firstMidnightOffset.localToUtcInThisOffset(localOverlappingTime) + overlapMillis)
        }
        ZoneId zone = ZoneId.of("America/New_York");
        assertThat(lookup.fixedInRange(min, max), nullValue());  
        long localFirstMidnight = firstMidnightOffset.utcToLocalTime(firstMidnight);
package org.opensearch.common;
        );  
    }  
        long gapValue = randomLong();
                return 0;
                return 0;
    }  
            @Override
            public long beforeGap(long localMillis, Gap gap) {
        assertThat(lookup.size(), equalTo(size));
        assertKnownMovesBacktoPreviousDay("Canada/Newfoundland", "2010-11-07T02:31:00");  
                fail("Shouldn't be called");  
import java.time.zone.ZoneOffsetTransition;
        /*
        return new LocalTimeOffset.Strategy() {
        long beforeOverlapValue = randomLong();
            public long beforeGap(long localMillis, Gap gap) {  
    }
import static org.hamcrest.Matchers.lessThan;
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(zone, min, max);
            @Override
        assertThat(gapOffset.localToUtcInThisOffset(localBeforeTransition), equalTo(transition - 1 - gapLength));
public class LocalTimeOffsetTests extends OpenSearchTestCase {
 * KIND, either express or implied.  See the License for the
        assertThat(secondMidnightOffset.localToUtcInThisOffset(localFirstMidnight - 1), equalTo(secondMidnight - 1));
        );
    }  
        assertThat(lookup.anyMoveBackToPreviousDay(), equalTo(false)); // None of the examples we use this method with move back
        assertThat(fixed, notNullValue());
        long sameOffsetAsMin,
        long time = time("2020-01-01", zone);  
    }
        assertThat(Instant.ofEpochMilli(time), lessThan(lastTransitionIn(zone).getInstant()));  
            long s = min;
                return beforeOverlapValue;
