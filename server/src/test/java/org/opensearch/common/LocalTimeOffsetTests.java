    }
    }
        long beforeOverlapValue = randomLong();
        assertThat(LocalTimeOffset.fixedOffset(zone), nullValue());
        assertKnownMovesBacktoPreviousDay("America/Moncton", "2005-10-29T03:01:00");
    private static long utcTime(String time) {
        assertThat(fixed, notNullValue());
        assertThat(LocalTimeOffset.lookup(zone, min, max).fixedInRange(utcTime("2000-06-01"), utcTime("2000-06-02")), notNullValue());
    private static long time(String time, ZoneId zone) {
            public long inGap(long localMillis, Gap gap) {
            public long inOverlap(long localMillis, Overlap overlap) {
    public void testTransitionsWithTransitionsAndRules() {
            }
    public void testSingleTimeBeforeRules() {
        assertThat(secondMidnightOffset.localToUtcInThisOffset(localFirstMidnight - 1), equalTo(secondMidnight - 1));
        long min = time("2020-01-01", zone);
}
            @Override
    }
                return 0;
    }
        );
        ZoneId zone = ZoneId.of("America/New_York");
                fail("Shouldn't be called");
    }
        ZoneId zone = ZoneId.of("America/New_York");
            }
        assertRoundingAtOffset(LocalTimeOffset.lookup(zone, time, time).lookup(time), time, hours(-1));
    }
        ZoneId zone = ZoneId.of("Asia/Kathmandu");
     */
            }
        assertKnownMovesBacktoPreviousDay("America/St_Johns", "2010-11-07T02:31:00");
        long utc = utcTime(time);
        assertThat(localSecondMidnight - localFirstMidnight, equalTo(0L));
    }
            public long inGap(long localMillis, Gap gap) {
         * This has broken the transition collection code in the past.
        return TimeUnit.HOURS.toMillis(hours);
                return 0;
                fail("Shouldn't be called");
        assertThat(offset.utcToLocalTime(time), equalTo(time + offsetMillis));
        if (Runtime.version().compareTo(Version.parse("11")) > 0) {
import java.util.concurrent.TimeUnit;
        assertThat(lookup.size(), equalTo(2));
 * GitHub history for details.
        assertThat(localAtTransition - localBeforeTransition, equalTo(gapLength + 1));
import org.opensearch.common.LocalTimeOffset.Overlap;
 * compatible open source license.
        assertRoundingAtOffset(lookup.lookup(time), time, TimeUnit.MINUTES.toMillis(345));
        assertThat(Instant.ofEpochMilli(min), lessThan(lastTransitionIn(zone).getInstant()));
        long time = time("1986-01-01T00:00:00", zone);
                return 0;
public class LocalTimeOffsetTests extends OpenSearchTestCase {
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(zone, min, max);
    public void testNotFixed() {
        long min = time("1980-01-01", zone);
            public long beforeGap(long localMillis, Gap gap) {
        assertKnownMovesBacktoPreviousDay("America/Moncton", "2006-10-29T03:01:00");
        long time = time("2000-10-30T00:00:00", zone);
        assertKnownMovesBacktoPreviousDay("Canada/Newfoundland", "2010-11-07T02:31:00");
        assertThat(secondMidnightOffset.localToUtcInThisOffset(localOverlapEnds), equalTo(overlapEnds));
            @Override
/*
        long min = utcTime("2011-11-06T08:31:57.091Z");
            }
        assertThat(gapOffset.localToUtc(localSkippedTime, useValueForGap(gapValue)), equalTo(gapValue));
        ZoneId tz = ZoneId.of("Asia/Kathmandu");
                return gapValue;
                return overlapValue;
    }
        ZoneId tz = ZoneId.of("Europe/Rome");
        long overlapValue = randomLong();
                return 0;
        assertThat(lookup.size(), equalTo(1));
        return transitions.get(transitions.size() - 1);
            assertKnownMovesBacktoPreviousDay("Pacific/Guam", "1969-01-25T13:01:00");
        assertThat(lookup.anyMoveBackToPreviousDay(), equalTo(false)); // None of the examples we use this method with move back
                fail("Shouldn't be called");
    private static LocalTimeOffset.Strategy useValueForBeforeGap(long beforeGapValue) {
 *
         */
 * You may obtain a copy of the License at
    /**
        assertThat(Instant.ofEpochMilli(time), lessThan(lastTransitionIn(zone).getInstant()));
            public long beforeOverlap(long localMillis, Overlap overlap) {
         * normal, but they rolled back past midnight which is pretty rare and neat.
    public void testRangeTooLarge() {
                fail("Shouldn't be called");
            assertKnownMovesBacktoPreviousDay("Pacific/Saipan", "1969-01-25T13:01:00");
        assertTransitions(zone, min, max, time("1980-06-01", zone), min + hours(1), 3, hours(-5), hours(-4));
        if (min > max) {
                fail("Shouldn't be called");
    }
            }
        assertFixedOffset(zone, zone.getTotalSeconds() * 1000);
    public void testJustOneRuleApplies() {
        assertThat(secondMidnightOffset.localToUtc(localOverlapEnds, unusedStrategy()), equalTo(overlapEnds));
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
import java.util.List;
        /*
                fail("Shouldn't be called");
    public void testUtc() {
        };
            }
         * Europe/Rome turn their clocks back an hour 1978 which is totally
        ZoneId zone = ZoneId.of("America/New_York");
        long overlapMillis = TimeUnit.HOURS.toMillis(1);
     */
     * have to collect them independently. That will trip assertions, failing
        assertRoundingAtOffset(lookup.lookup(min), min, minMaxOffset);
import java.time.ZoneOffset;
        assertThat(lookup.fixedInRange(min, sameOffsetAsMin), sameInstance(lookup.lookup(min)));
        LocalTimeOffset beforeGapOffset = lookup.lookup(transition - 1);
    private static long hours(long hours) {
        return new LocalTimeOffset.Strategy() {
            max = s;
        LocalTimeOffset fixed = LocalTimeOffset.fixedOffset(zone);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.LocalTimeOffset.Gap;
    /**
import static org.hamcrest.Matchers.greaterThan;
                return 0;
        LocalTimeOffset firstMidnightOffset = lookup.lookup(firstMidnight);
import java.lang.Runtime.Version;
    public void testSingleTimeAfterRules() {
        assertThat(secondMidnightOffset.localToUtc(localFirstMidnight, useValueForOverlap(overlapValue)), equalTo(overlapValue));
        long gapLength = TimeUnit.MINUTES.toMillis(15);
            }
    }
        assertThat(fixedInRange.anyMoveBackToPreviousDay(), equalTo(false));
    }
        long transition = time("1986-01-01T00:00:00", tz);
        /*
        List<ZoneOffsetTransition> transitions = zone.getRules().getTransitions();
        assertThat(gapOffset.localToUtc(localAtTransition, unusedStrategy()), equalTo(transition));
        };
    private static LocalTimeOffset.Strategy useValueForGap(long gapValue) {
        assertThat(beforeGapOffset.localToUtcInThisOffset(localBeforeTransition), equalTo(transition - 1));
 * KIND, either express or implied.  See the License for the
    private void assertFixedOffset(ZoneId zone, long offsetMillis) {
        assertThat(
        long gapValue = randomLong();
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
            @Override
        assertThat(firstMidnightOffset.localToUtcInThisOffset(localFirstMidnight - 1), equalTo(firstMidnight - 1));
            }
        LocalTimeOffset secondMidnightOffset = lookup.lookup(secondMidnight);
    }
    }
        }
import java.time.zone.ZoneRules;
        ZoneId zone,
            @Override
 * ownership. Elasticsearch licenses this file to you under
        return DateFormatter.forPattern("date_optional_time").parseMillis(time);
        long beforeGapValue = randomLong();
        assertRoundingAtOffset(lookup.lookup(max), max, -TimeUnit.HOURS.toMillis(8));
            }
                fail("Shouldn't be called");
            equalTo(firstMidnightOffset.localToUtcInThisOffset(localOverlappingTime) + overlapMillis)
            public long beforeOverlap(long localMillis, Overlap overlap) {
        long overlapEnds = utcTime("1978-10-01T0:00:00");
            @Override
    }
    private static LocalTimeOffset.Strategy useValueForOverlap(long overlapValue) {
import static org.hamcrest.Matchers.nullValue;
        long betweenOffset
    }
 * specific language governing permissions and limitations
        assertRoundingAtOffset(lookup.lookup(min), min, -TimeUnit.HOURS.toMillis(7));
        assertRoundingAtOffset(randomBoolean() ? fixed : fixedInRange, randomLong(), offsetMillis);
                return 0;
        long localFirstMidnight = firstMidnightOffset.utcToLocalTime(firstMidnight);
        ZoneId zone = ZoneId.of("America/New_York");
                fail("Shouldn't be called");
        long min = randomLong();
            }
        long localOverlappingTime = randomLongBetween(localFirstMidnight, localOverlapEnds);
            public long beforeGap(long localMillis, Gap gap) {
            public long beforeGap(long localMillis, Gap gap) {
 */
        long min = time("1980-01-01", zone);
 * Licensed to Elasticsearch under one or more contributor
    }
 * software distributed under the License is distributed on an
            @Override
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
                return 0;
                fail("Shouldn't be called");
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(tz, transition - 1, transition);
                return 0;
    public void testAfterRules() {
                fail("Shouldn't be called");
 */
        assertThat(gapOffset.localToUtcInThisOffset(localBeforeTransition), equalTo(transition - 1 - gapLength));
        };
        ZoneOffset zone = ZoneOffset.ofTotalSeconds(between((int) -TimeUnit.HOURS.toSeconds(18), (int) TimeUnit.HOURS.toSeconds(18)));
    }
        assertThat(localOverlapEnds - localSecondMidnight, equalTo(overlapMillis));
         * 1986-01-01T00:00:00, creating a really "fun" gap.
         */
            LocalTimeOffset.lookup(ZoneId.of(zone), utc, utc + 1).anyMoveBackToPreviousDay()
            @Override
            @Override
import static org.hamcrest.Matchers.sameInstance;
        assertRoundingAtOffset(LocalTimeOffset.lookup(zone, time, time).lookup(time), time, hours(-5));
            }
        assertThat(gapOffset.localToUtc(localBeforeTransition, useValueForBeforeGap(beforeGapValue)), equalTo(beforeGapValue));
    public void testLastTransitionOverlapsRules() {
                return 0;
        }
            @Override
        long localOverlapEnds = secondMidnightOffset.utcToLocalTime(overlapEnds);
import java.time.Instant;
            @Override
        assertThat(secondMidnightOffset.localToUtc(localOverlappingTime, useValueForOverlap(overlapValue)), equalTo(overlapValue));
            }
        ZoneId zone = ZoneId.of("America/Tijuana");
    public void testJustTransitions() {
                fail("Shouldn't be called");
    public void testKnownMovesBackToPreviousDay() {
            public long beforeGap(long localMillis, Gap gap) {
import org.opensearch.test.OpenSearchTestCase;
        );
        assertTrue(
            // Added in java 12
    public void testGap() {
    private void assertKnownMovesBacktoPreviousDay(String zone, String time) {
        long localBeforeTransition = beforeGapOffset.utcToLocalTime(transition - 1);
            }
        assertTransitions(zone, min, max, time("2020-06-01", zone), min + hours(1), 3, hours(-5), hours(-4));
        assertThat(firstMidnightOffset.localToUtcInThisOffset(localFirstMidnight), equalTo(firstMidnight));
            public long inOverlap(long localMillis, Overlap overlap) {
        assertFixedOffset(ZoneId.of("UTC"), 0);
            public long inOverlap(long localMillis, Overlap overlap) {
            public long inGap(long localMillis, Gap gap) {
            public long beforeGap(long localMillis, Gap gap) {
                return beforeOverlapValue;
        long localAtTransition = gapOffset.utcToLocalTime(transition);
 *
        long max = time("2021-01-01", zone) - 1;
        assertThat(secondMidnightOffset.localToUtcInThisOffset(localFirstMidnight), equalTo(secondMidnight));
    private void assertRoundingAtOffset(LocalTimeOffset offset, long time, long offsetMillis) {
                return 0;
 * SPDX-License-Identifier: Apache-2.0
    // Some sanity checks for when you pas a single time. We don't expect to do this much but it shouldn't be totally borked.
            }
            equalTo(beforeOverlapValue)
            public long inOverlap(long localMillis, Overlap overlap) {
        long between,
        );
    public void testOverlap() {
            min = max;
    }
        LocalTimeOffset fixedInRange = lookup.fixedInRange(min, max);
        assertThat(lookup.fixedInRange(min, max), nullValue());
    }
            public long inOverlap(long localMillis, Overlap overlap) {
            secondMidnightOffset.localToUtcInThisOffset(localOverlappingTime),
    }
                fail("Shouldn't be called");
        ZoneId zone = ZoneId.of("Atlantic/Azores");
        assertThat(Instant.ofEpochMilli(time), greaterThan(lastTransitionIn(zone).getInstant()));
        return new LocalTimeOffset.Strategy() {
                return 0;
    ) {
            @Override
        LocalTimeOffset gapOffset = lookup.lookup(transition);
        ZoneId zone = ZoneId.of("America/New_York");
    }
            }
 * under the License.
            long s = min;
                return 0;
         * Asia/Kathmandu turned their clocks 15 minutes forward at
     * {@link ZoneRules#getTransitions() fully defined transitions} overlap
        ZoneId zone = ZoneId.of("America/New_York");
import static org.hamcrest.Matchers.notNullValue;
                fail("Shouldn't be called");
    }
        long localSecondMidnight = secondMidnightOffset.utcToLocalTime(secondMidnight);
     * this test real fast. If they don't trip the assertions then trying to
        assertRoundingAtOffset(lookup.lookup(max), max, minMaxOffset);
            @Override
/*
        assertThat(Instant.ofEpochMilli(max), greaterThan(lastTransitionIn(zone).getInstant()));
            zone + " just after " + time + " should move back",
     * we're not careful we can end up with duplicate transitions because we
     * use the transitions will produce incorrect results, failing the
    public void testFixedOffset() {
        long max = time("1981-01-01", zone) - 1;
            }
                return 0;
            @Override
import org.opensearch.common.time.DateFormatter;
            secondMidnightOffset.localToUtc(localFirstMidnight - 1, useValueForBeforeOverlap(beforeOverlapValue)),
         */
        return new LocalTimeOffset.Strategy() {
import static org.hamcrest.Matchers.equalTo;
        long sameOffsetAsMin,
            public long inGap(long localMillis, Gap gap) {
                return 0;
        assertRoundingAtOffset(lookup.lookup(between), between, betweenOffset);
            @Override
        long firstMidnight = utcTime("1978-09-30T22:00:00");
        assertThat(lookup.size(), equalTo(2));
        /*
        assertKnownMovesBacktoPreviousDay("America/Goose_Bay", "2010-11-07T03:01:00");
 * Modifications Copyright OpenSearch Contributors. See
            public long beforeOverlap(long localMillis, Overlap overlap) {
 * the Apache License, Version 2.0 (the "License"); you may
        };
            public long beforeOverlap(long localMillis, Overlap overlap) {
        long time = time("2020-01-01", zone);
                fail("Shouldn't be called");
        assertThat(Instant.ofEpochMilli(min), greaterThan(lastTransitionIn(zone).getInstant()));
 *
import java.time.zone.ZoneOffsetTransition;
        assertRoundingAtOffset(LocalTimeOffset.lookup(zone, time, time).lookup(time), time, hours(-5));
        assertThat(fixedInRange, notNullValue());
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(tz, firstMidnight, overlapEnds);
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(zone, Long.MIN_VALUE, Long.MAX_VALUE);
    private void assertTransitions(
    }
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * size assertion.
            @Override
    }
        assertThat(lookup.anyMoveBackToPreviousDay(), equalTo(false));
         * 1986-01-01T00:00:00 local time and hasn't changed time since.
        long max = time("2021-01-01", zone) - 1;
            @Override
        long max = randomValueOtherThan(min, OpenSearchTestCase::randomLong);
    private static ZoneOffsetTransition lastTransitionIn(ZoneId zone) {
 * The OpenSearch Contributors require contributions made to
        assertThat(gapOffset.localToUtcInThisOffset(localAtTransition), equalTo(transition));
    private static LocalTimeOffset.Strategy unusedStrategy() {
                fail("Shouldn't be called");
     * with its {@link ZoneRules#getTransitionRules() future rules} and if
                return beforeGapValue;
        };
package org.opensearch.common;
        long localSkippedTime = randomLongBetween(localBeforeTransition, localAtTransition);
        return new LocalTimeOffset.Strategy() {
        assertThat(LocalTimeOffset.lookup(zone, Long.MIN_VALUE, Long.MAX_VALUE), nullValue());
        long minMaxOffset,
import java.time.ZoneId;
        return DateFormatter.forPattern("date_optional_time").withZone(zone).parseMillis(time);
                return 0;
         * Asia/Kathmandu turned their clocks 15 minutes forward at
        assertThat(Instant.ofEpochMilli(max), lessThan(lastTransitionIn(zone).getInstant()));
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(zone, time - 1, time);
            public long inGap(long localMillis, Gap gap) {
        long max = utcTime("2011-11-06T09:02:57.091Z");
    }
                fail("Shouldn't be called");
        assertRoundingAtOffset(lookup.lookup(time - 1), time - 1, TimeUnit.MINUTES.toMillis(330));
                return 0;
            public long beforeOverlap(long localMillis, Overlap overlap) {
            @Override
/*
            }
        assertThat(offset.localToUtcInThisOffset(time + offsetMillis), equalTo(time));
        int size,
            @Override
            @Override
     * America/Tijuana's
        long max,
import static org.hamcrest.Matchers.lessThan;
 */
            }
        assertThat(lookup.lookup(overlapEnds), sameInstance(secondMidnightOffset));
        long secondMidnight = utcTime("1978-09-30T23:00:00");
        assertThat(
        assertThat(lookup.size(), equalTo(size));
        long min,
     * The last "fully defined" transitions in the provided {@linkplain ZoneId}.
            @Override
        assertTransitions(zone, min, max, time("2000-06-01", zone), min + hours(1), 83, hours(-5), hours(-4));
        long time = time("1980-01-01", zone);
    }
    public void testLastTransitionWithoutRules() {
        LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(zone, min, max);
            }
        ZoneId zone = ZoneId.of("America/New_York");
        return new LocalTimeOffset.Strategy() {
    }
    private static LocalTimeOffset.Strategy useValueForBeforeOverlap(long beforeOverlapValue) {
