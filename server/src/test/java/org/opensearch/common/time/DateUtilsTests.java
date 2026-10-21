import static org.hamcrest.Matchers.containsString;
    public void testClampToNanosRangeMin() {
        }
            assertNotNull(DateUtils.zoneIdToDateTimeZone(zoneId));
        assertThat(toNanoSeconds(0), equalTo(0L));
        long quarterInMillis = Year.of(randomZonedDateTime.getYear())
        long unitMillis = randomChronoField.getBaseUnit().getDuration().toMillis();
import java.time.ZoneId;
        assertThat(DateUtils.roundYear(endOf1970), is(0L));
        );
            }
        Instant instant = createRandomInstant();
    }
            if (IGNORE.contains(jodaId)) continue;
        assertThat(clampToNanosRange(instant), equalTo(instant));
        assertThat(clampToNanosRange(Instant.EPOCH), equalTo(Instant.EPOCH));
            DateTimeZone jodaTz = DateTimeZone.forID(jodaId);
    }
 * You may obtain a copy of the License at
        assertThat(DateUtils.roundQuarterOfYear(-1), is(lastQuarter1969));
 *
        assertNull(DateUtils.zoneIdToDateTimeZone(null));
import java.time.ZonedDateTime;
    }
            assertThat(
    }
        assertThat(DateUtils.roundFloor(0, randomLongBetween(0, Long.MAX_VALUE)), is(0L));
            .atStartOfDay(ZoneOffset.UTC)
        long nowInMs = instant.toEpochMilli();
        Instant tooLateInstant = ZonedDateTime.parse("2262-04-11T23:47:16.854775808Z").toInstant();
 *
 */
        long endOf1996 = ZonedDateTime.of(1996, 12, 31, 23, 59, 59, 999_999_999, ZoneOffset.UTC).toInstant().toEpochMilli();
            999_999_999,
 * under the License.
        int second = randomIntBetween(1, 59);
        assertThat(exc.getMessage(), containsString("after 2262"));
    public void testClampToMillisRange() {
    }
import org.joda.time.DateTimeZone;
/*
    }
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(DateUtils.roundMonthOfYear(0), is(0L));
        assertEquals(normalInstant, DateUtils.clampToMillisRange(normalInstant));
import static org.opensearch.common.time.DateUtils.toMilliSeconds;
        assertThrows(NullPointerException.class, () -> DateUtils.clampToMillisRange(null));
    public void testRoundFloor() {
        assertThat(result, is(quarterInMillis));
        assertThat(toLong(Instant.EPOCH), is(0L));
        long lastQuarter1969 = ZonedDateTime.of(1969, 10, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
            ZoneId zoneId = DateUtils.dateTimeZoneToZoneId(jodaTz); // does not throw
        Instant instant = Instant.ofEpochSecond(randomLongBetween(0, Long.MAX_VALUE) / 1_000_000_000L);
        return Instant.ofEpochSecond(seconds, nanos);
        assertThat(
        assertThat(DateUtils.roundQuarterOfYear(0), is(0L));
        Instant tooLateInstant = ZonedDateTime.parse("2262-04-11T23:47:16.854775808Z").toInstant();
        int day = randomIntBetween(1, YearMonth.of(year, month).lengthOfMonth());
import java.time.Month;
        e = expectThrows(IllegalArgumentException.class, () -> toInstant(Long.MIN_VALUE));
        Arrays.asList("America/Bahia_Banderas", "America/Hermosillo", "America/Mazatlan", "Mexico/BajaSur", "WET")
    public void testClampToNanosRangeMax() {
 * Modifications Copyright OpenSearch Contributors. See
        int year = randomIntBetween(1970, 2040);
        assertThat(e.getMessage(), containsString("is before"));
            e.getMessage(),
        assertThat(toInstant(1), is(Instant.EPOCH.plusNanos(1)));
    public void testRoundMonthOfYear() {
    public void testMillisToNanos() {
        long nowInNs = toLong(instant);
                jodaId,
 * license agreements. See the NOTICE file distributed with
        assertThat(e.getMessage(), containsString("is before"));
                zoneId.getRules().getOffset(Instant.ofEpochMilli(now)).getTotalSeconds() * 1000,
        assertThat(clampToNanosRange(tooEarlyInstant), equalTo(Instant.EPOCH));
        Instant afterMaxInstant = DateUtils.INSTANT_LONG_MAX_VALUE.plusMillis(1);
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> toLong(tooLateInstant));
 * this work for additional information regarding copyright
            case SECOND_OF_MINUTE:
                break;
import java.time.LocalDate;
            randomIntBetween(0, 59),
        long nanos = randomLongBetween(0, 999_999_999L);
            is("nanoseconds [" + Long.MIN_VALUE + "] are before the epoch in 1970 and cannot be processed in nanosecond resolution")
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> toLong(tooEarlyInstant));
    public void testLongToInstant() {
        switch (randomChronoField) {
 * software distributed under the License is distributed on an
    private Instant createRandomInstant() {
        );
            ChronoField.MINUTE_OF_HOUR,
        assertThat(DateUtils.roundMonthOfYear(1), is(0L));
        Instant tooEarlyInstant = ZonedDateTime.parse("1677-09-21T00:12:43.145224191Z").toInstant();
        long timeSinceEpochInNanos = instant.getEpochSecond() * 1_000_000_000 + instant.getNano();
import static org.hamcrest.Matchers.equalTo;
 * The OpenSearch Contributors require contributions made to
public class DateUtilsTests extends OpenSearchTestCase {
        long millis = DateUtils.MAX_NANOSECOND_IN_MILLIS + randomLongBetween(0, 1000000);
                break;
 * not use this file except in compliance with the License.
        assertThat(clampToNanosRange(tooLateInstant), equalTo(DateUtils.MAX_NANOSECOND_INSTANT));
            month,
        long startOf1996 = Year.of(1996).atDay(1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
            .atDay(1)
        assertEquals(DateUtils.INSTANT_LONG_MIN_VALUE, DateUtils.clampToMillisRange(beforeMinInstant));
            randomIntBetween(0, 23),
    public void testInstantToLongMin() {
import java.util.Arrays;
            .atMonth(Month.of(month).firstMonthOfQuarter())
package org.opensearch.common.time;
        assertThat(DateUtils.roundYear(1), is(0L));
        Instant instant = createRandomInstant();
            .toInstant()
        assertThat(DateUtils.roundMonthOfYear(-1), is(dec1969));
        long dec1969 = LocalDate.of(1969, 12, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
}
 *     http://www.apache.org/licenses/LICENSE-2.0
            case MINUTE_OF_HOUR:
    public void testRoundQuarterOfYear() {
import java.time.YearMonth;
        for (String jodaId : DateTimeZone.getAvailableIDs()) {
        assertThat(clampToNanosRange(Instant.EPOCH.minusMillis(1)), equalTo(Instant.EPOCH));
        assertThat(toInstant(nowInNs), is(instant));
    public void testClampToNanosRange() {
import static org.hamcrest.Matchers.is;
        assertThat(toInstant(0), is(Instant.EPOCH));
        assertThat(DateUtils.roundYear(endOf1996), is(startOf1996));
                break;
        Instant instant = createRandomInstant();
            case HOUR_OF_DAY:
    }
import java.time.ZoneOffset;
        int hour = randomIntBetween(1, 23);
    public void testInstantToLong() {
 * SPDX-License-Identifier: Apache-2.0
        e = expectThrows(IllegalArgumentException.class, () -> toLong(Instant.EPOCH.minusMillis(1)));
        ZonedDateTime randomZonedDateTime = ZonedDateTime.of(
        long result = DateUtils.roundQuarterOfYear(randomZonedDateTime.toInstant().toEpochMilli());
        assertThat(toMilliSeconds(nowInNs), is(instant.toEpochMilli()));
        assertThat(rounded, is(result.toInstant().toEpochMilli()));
                result = result.withNano(0).withSecond(0);
/*
        assertThat(toLong(instant), is(timeSinceEpochInNanos));
        );
        assertEquals(DateUtils.INSTANT_LONG_MIN_VALUE, DateUtils.clampToMillisRange(DateUtils.INSTANT_LONG_MIN_VALUE));
    }
    public void testTimezoneIds() {
 */
    }
import java.util.Set;
    }
        assertThat(e.getMessage(), containsString("is after"));
        long rounded = DateUtils.roundFloor(randomDate.toInstant().toEpochMilli(), unitMillis);
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
        long endOf1970 = ZonedDateTime.of(1970, 12, 31, 23, 59, 59, 999_999_999, ZoneOffset.UTC).toInstant().toEpochMilli();
            day,
    }
        int minute = randomIntBetween(1, 59);
import java.time.Year;
        int nanos = randomIntBetween(1, 999_999_999);
import org.opensearch.test.OpenSearchTestCase;
                result = result.withNano(0).withSecond(0).withMinute(0).withHour(0);
    );
            case DAY_OF_MONTH:
            ZoneOffset.UTC
 * specific language governing permissions and limitations
        long startOf1969 = ZonedDateTime.of(1969, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> toNanoSeconds(-1));
        long nowInNs = toLong(instant);
import java.util.HashSet;
    public void testNanosToMillis() {
        int month = randomIntBetween(1, 12);
        Instant normalInstant = Instant.now();
            .toEpochMilli();
                equalTo(jodaTz.getOffset(now))
        assertThat(toNanoSeconds(nowInMs), equalTo(toLong(instant)));
import static org.opensearch.common.time.DateUtils.toNanoSeconds;
    public void testInstantToLongMax() {
        exc = expectThrows(IllegalArgumentException.class, () -> toNanoSeconds(millis));
        assertEquals(DateUtils.INSTANT_LONG_MAX_VALUE, DateUtils.clampToMillisRange(DateUtils.INSTANT_LONG_MAX_VALUE));
            ChronoField.HOUR_OF_DAY,
            ChronoField.DAY_OF_MONTH,
        int year = randomIntBetween(-3000, 3000);
 */
            ChronoField.SECOND_OF_MINUTE
        Instant instant = createRandomInstant();
/*
            if (DateUtils.DEPRECATED_SHORT_TIMEZONES.containsKey(jodaTz.getID())) {
    }
        assertThat(toMilliSeconds(0), is(Instant.EPOCH.toEpochMilli()));
        }
import static org.opensearch.common.time.DateUtils.toLong;
        ZonedDateTime randomDate = ZonedDateTime.of(year, month, day, hour, minute, second, nanos, ZoneOffset.UTC);
    }
import static org.opensearch.common.time.DateUtils.clampToNanosRange;
import java.time.Instant;
        assertThat(exc.getMessage(), containsString("before the epoch"));
import static org.opensearch.common.time.DateUtils.toInstant;
        Instant tooEarlyInstant = ZonedDateTime.parse("1677-09-21T00:12:43.145224191Z").toInstant();
 *
        // test with some leapyear
                result = result.withNano(0).withSecond(0).withMinute(0);
        assertThat(toInstant(Long.MAX_VALUE), is(ZonedDateTime.parse("2262-04-11T23:47:16.854775807Z").toInstant()));
        assertNull(DateUtils.dateTimeZoneToZoneId(null));
            year,
        assertThat(e.getMessage(), is("nanoseconds [-1] are before the epoch in 1970 and cannot be processed in nanosecond resolution"));
    private static final Set<String> IGNORE = new HashSet<>(
        assertEquals(DateUtils.INSTANT_LONG_MAX_VALUE, DateUtils.clampToMillisRange(afterMaxInstant));
        ChronoField randomChronoField = randomFrom(
            randomIntBetween(0, 59),
        ZonedDateTime result = randomDate;
 * Licensed to Elasticsearch under one or more contributor
            );
 * ownership. Elasticsearch licenses this file to you under
        Instant beforeMinInstant = DateUtils.INSTANT_LONG_MIN_VALUE.minusMillis(1);
        long seconds = randomLongBetween(0, Long.MAX_VALUE) / 1_000_000_000L;
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(DateUtils.roundYear(-1), is(startOf1969));
                assertWarnings("Use of short timezone id " + jodaId + " is deprecated. Use " + zoneId.getId() + " instead");
        int month = randomIntBetween(1, 12);
 * Unless required by applicable law or agreed to in writing,
    }
            long now = 0;
    public void testRoundYear() {
import java.time.temporal.ChronoField;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> toInstant(-1));
        int day = randomIntBetween(1, YearMonth.of(year, month).lengthOfMonth());
                break;
            // roundtrip does not throw either
                result = result.withNano(0);
        assertThat(DateUtils.roundYear(0), is(0L));
 * GitHub history for details.
    }
