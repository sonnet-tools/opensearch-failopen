                jodaId,
    private static final Set<String> IGNORE = new HashSet<>(  
            assertThat(  
        assertThat(DateUtils.roundYear(1), is(0L));
    );
import static org.opensearch.common.time.DateUtils.toMilliSeconds;
        assertThat(DateUtils.roundMonthOfYear(0), is(0L));  
    }
        assertThat(DateUtils.roundYear(-1), is(startOf1969));
        int minute = randomIntBetween(1, 59);
import java.util.HashSet;
            .toEpochMilli();  
        int month = randomIntBetween(1, 12);  
 * The OpenSearch Contributors require contributions made to  
        Instant tooLateInstant = ZonedDateTime.parse("2262-04-11T23:47:16.854775808Z").toInstant();
import java.time.Year;
        Instant instant = createRandomInstant();  
        assertThat(
        long lastQuarter1969 = ZonedDateTime.of(1969, 10, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant().toEpochMilli();
import static org.opensearch.common.time.DateUtils.toInstant;  
        assertThat(DateUtils.roundMonthOfYear(-1), is(dec1969));  
        switch (randomChronoField) {
 *  
        assertThat(toInstant(0), is(Instant.EPOCH));  
    }
        }
    }
        ZonedDateTime result = randomDate;
        assertThat(toLong(instant), is(timeSinceEpochInNanos));  
    public void testClampToNanosRangeMax() {  
        long endOf1970 = ZonedDateTime.of(1970, 12, 31, 23, 59, 59, 999_999_999, ZoneOffset.UTC).toInstant().toEpochMilli();
        assertThat(DateUtils.roundYear(endOf1996), is(startOf1996));
    }  
    public void testInstantToLongMax() {
            case SECOND_OF_MINUTE:  
        long seconds = randomLongBetween(0, Long.MAX_VALUE) / 1_000_000_000L;
    public void testNanosToMillis() {
    public void testMillisToNanos() {
    public void testRoundQuarterOfYear() {  
                break;
        int month = randomIntBetween(1, 12);
        assertThrows(NullPointerException.class, () -> DateUtils.clampToMillisRange(null));  
import static org.hamcrest.Matchers.equalTo;
        assertThat(clampToNanosRange(instant), equalTo(instant));
        for (String jodaId : DateTimeZone.getAvailableIDs()) {
            randomIntBetween(0, 59),
            case MINUTE_OF_HOUR:  
import org.joda.time.DateTimeZone;
        e = expectThrows(IllegalArgumentException.class, () -> toLong(Instant.EPOCH.minusMillis(1)));
        long rounded = DateUtils.roundFloor(randomDate.toInstant().toEpochMilli(), unitMillis);
        assertThat(DateUtils.roundMonthOfYear(1), is(0L));
        int year = randomIntBetween(1970, 2040);
/*  
        long quarterInMillis = Year.of(randomZonedDateTime.getYear())
    }
            ChronoField.DAY_OF_MONTH,
    }  
}
            );
        e = expectThrows(IllegalArgumentException.class, () -> toInstant(Long.MIN_VALUE));
        Instant normalInstant = Instant.now();
        // test with some leapyear
    }  
        Instant instant = createRandomInstant();
        assertThat(clampToNanosRange(Instant.EPOCH.minusMillis(1)), equalTo(Instant.EPOCH));  
            .atDay(1)  
                break;
import static org.hamcrest.Matchers.containsString;
        assertThat(toLong(Instant.EPOCH), is(0L));
        assertThat(toInstant(nowInNs), is(instant));
import java.time.ZoneOffset;
    }
    public void testInstantToLongMin() {  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
                assertWarnings("Use of short timezone id " + jodaId + " is deprecated. Use " + zoneId.getId() + " instead");  
        int day = randomIntBetween(1, YearMonth.of(year, month).lengthOfMonth());
            if (DateUtils.DEPRECATED_SHORT_TIMEZONES.containsKey(jodaTz.getID())) {
            day,  
    }
        assertThat(e.getMessage(), containsString("is before"));  
            case DAY_OF_MONTH:  
        assertThat(toNanoSeconds(0), equalTo(0L));
        assertEquals(DateUtils.INSTANT_LONG_MIN_VALUE, DateUtils.clampToMillisRange(DateUtils.INSTANT_LONG_MIN_VALUE));
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
        IllegalArgumentException exc = expectThrows(IllegalArgumentException.class, () -> toNanoSeconds(-1));
 *
                break;
        Instant afterMaxInstant = DateUtils.INSTANT_LONG_MAX_VALUE.plusMillis(1);
            if (IGNORE.contains(jodaId)) continue;
    public void testInstantToLong() {
        long nanos = randomLongBetween(0, 999_999_999L);  
                break;
    }
        assertThat(result, is(quarterInMillis));
        assertEquals(DateUtils.INSTANT_LONG_MAX_VALUE, DateUtils.clampToMillisRange(afterMaxInstant));  
import java.time.ZonedDateTime;
            .atStartOfDay(ZoneOffset.UTC)
/*  
 * Unless required by applicable law or agreed to in writing,
        assertThat(exc.getMessage(), containsString("after 2262"));
        int nanos = randomIntBetween(1, 999_999_999);  
            DateTimeZone jodaTz = DateTimeZone.forID(jodaId);  
 */  
            long now = 0;
 * software distributed under the License is distributed on an
 */  
        int second = randomIntBetween(1, 59);
        Arrays.asList("America/Bahia_Banderas", "America/Hermosillo", "America/Mazatlan", "Mexico/BajaSur", "WET")
        Instant tooEarlyInstant = ZonedDateTime.parse("1677-09-21T00:12:43.145224191Z").toInstant();
        assertThat(toMilliSeconds(nowInNs), is(instant.toEpochMilli()));
        assertNull(DateUtils.dateTimeZoneToZoneId(null));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> toInstant(-1));
        Instant instant = createRandomInstant();
import static org.hamcrest.Matchers.is;  
        assertThat(DateUtils.roundQuarterOfYear(0), is(0L));
        assertThat(rounded, is(result.toInstant().toEpochMilli()));  
import static org.opensearch.common.time.DateUtils.toNanoSeconds;  
 * compatible open source license.
            ChronoField.MINUTE_OF_HOUR,
        ZonedDateTime randomZonedDateTime = ZonedDateTime.of(  
        );  
        long result = DateUtils.roundQuarterOfYear(randomZonedDateTime.toInstant().toEpochMilli());
    public void testRoundFloor() {
    }
        assertThat(clampToNanosRange(tooLateInstant), equalTo(DateUtils.MAX_NANOSECOND_INSTANT));
        Instant tooLateInstant = ZonedDateTime.parse("2262-04-11T23:47:16.854775808Z").toInstant();  
 * GitHub history for details.
            ZoneId zoneId = DateUtils.dateTimeZoneToZoneId(jodaTz); // does not throw
            }
            999_999_999,
                result = result.withNano(0);
        assertThat(clampToNanosRange(tooEarlyInstant), equalTo(Instant.EPOCH));  
        assertThat(toInstant(Long.MAX_VALUE), is(ZonedDateTime.parse("2262-04-11T23:47:16.854775807Z").toInstant()));
            .atMonth(Month.of(month).firstMonthOfQuarter())
        );  
        assertThat(e.getMessage(), containsString("is after"));
import org.opensearch.test.OpenSearchTestCase;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> toLong(tooLateInstant));
public class DateUtilsTests extends OpenSearchTestCase {
        int year = randomIntBetween(-3000, 3000);  
        ChronoField randomChronoField = randomFrom(
        int day = randomIntBetween(1, YearMonth.of(year, month).lengthOfMonth());
            assertNotNull(DateUtils.zoneIdToDateTimeZone(zoneId));  
        long timeSinceEpochInNanos = instant.getEpochSecond() * 1_000_000_000 + instant.getNano();
    public void testTimezoneIds() {
        long dec1969 = LocalDate.of(1969, 12, 1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();
            randomIntBetween(0, 23),
        long nowInMs = instant.toEpochMilli();
        long startOf1996 = Year.of(1996).atDay(1).atStartOfDay().toInstant(ZoneOffset.UTC).toEpochMilli();  
 * license agreements. See the NOTICE file distributed with
/*
        long nowInNs = toLong(instant);  
    public void testClampToNanosRange() {
 * this file be licensed under the Apache-2.0 license or a
        assertThat(toMilliSeconds(0), is(Instant.EPOCH.toEpochMilli()));  
                result = result.withNano(0).withSecond(0).withMinute(0).withHour(0);
import java.time.LocalDate;
    }  
package org.opensearch.common.time;
            // roundtrip does not throw either
        Instant tooEarlyInstant = ZonedDateTime.parse("1677-09-21T00:12:43.145224191Z").toInstant();
            year,
    public void testRoundMonthOfYear() {
            ChronoField.HOUR_OF_DAY,  
        int hour = randomIntBetween(1, 23);  
import static org.opensearch.common.time.DateUtils.clampToNanosRange;
        assertThat(clampToNanosRange(Instant.EPOCH), equalTo(Instant.EPOCH));
        assertThat(toNanoSeconds(nowInMs), equalTo(toLong(instant)));  
        long unitMillis = randomChronoField.getBaseUnit().getDuration().toMillis();
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> toLong(tooEarlyInstant));
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        assertThat(exc.getMessage(), containsString("before the epoch"));  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.time.ZoneId;  
        assertThat(DateUtils.roundYear(0), is(0L));
            ZoneOffset.UTC
        );
        exc = expectThrows(IllegalArgumentException.class, () -> toNanoSeconds(millis));  
            .toInstant()
                result = result.withNano(0).withSecond(0).withMinute(0);
        assertNull(DateUtils.zoneIdToDateTimeZone(null));  
 * You may obtain a copy of the License at  
            month,
import java.time.temporal.ChronoField;  
                result = result.withNano(0).withSecond(0);
        assertThat(DateUtils.roundYear(endOf1970), is(0L));  
        assertThat(DateUtils.roundQuarterOfYear(-1), is(lastQuarter1969));  
        assertEquals(normalInstant, DateUtils.clampToMillisRange(normalInstant));  
        assertThat(e.getMessage(), containsString("is before"));
            ChronoField.SECOND_OF_MINUTE
 * not use this file except in compliance with the License.
        return Instant.ofEpochSecond(seconds, nanos);
import java.util.Arrays;
            case HOUR_OF_DAY:  
import java.time.Month;  
        long endOf1996 = ZonedDateTime.of(1996, 12, 31, 23, 59, 59, 999_999_999, ZoneOffset.UTC).toInstant().toEpochMilli();
        long startOf1969 = ZonedDateTime.of(1969, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant().toEpochMilli();  
 */
 *
                zoneId.getRules().getOffset(Instant.ofEpochMilli(now)).getTotalSeconds() * 1000,
        ZonedDateTime randomDate = ZonedDateTime.of(year, month, day, hour, minute, second, nanos, ZoneOffset.UTC);
                equalTo(jodaTz.getOffset(now))  
    public void testClampToNanosRangeMin() {
        long millis = DateUtils.MAX_NANOSECOND_IN_MILLIS + randomLongBetween(0, 1000000);
    public void testLongToInstant() {
        assertEquals(DateUtils.INSTANT_LONG_MIN_VALUE, DateUtils.clampToMillisRange(beforeMinInstant));  
        assertThat(toInstant(1), is(Instant.EPOCH.plusNanos(1)));
            is("nanoseconds [" + Long.MIN_VALUE + "] are before the epoch in 1970 and cannot be processed in nanosecond resolution")
        Instant instant = Instant.ofEpochSecond(randomLongBetween(0, Long.MAX_VALUE) / 1_000_000_000L);
 * under the License.  
        }  
        long nowInNs = toLong(instant);
        Instant instant = createRandomInstant();
import java.time.YearMonth;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Set;  
    }
        assertThat(DateUtils.roundFloor(0, randomLongBetween(0, Long.MAX_VALUE)), is(0L));
        assertEquals(DateUtils.INSTANT_LONG_MAX_VALUE, DateUtils.clampToMillisRange(DateUtils.INSTANT_LONG_MAX_VALUE));
    public void testRoundYear() {  
            randomIntBetween(0, 59),  
    }  
    public void testClampToMillisRange() {
    private Instant createRandomInstant() {
import static org.opensearch.common.time.DateUtils.toLong;
        assertThat(e.getMessage(), is("nanoseconds [-1] are before the epoch in 1970 and cannot be processed in nanosecond resolution"));
        Instant beforeMinInstant = DateUtils.INSTANT_LONG_MIN_VALUE.minusMillis(1);
 * this work for additional information regarding copyright
import java.time.Instant;
            e.getMessage(),  
    }
