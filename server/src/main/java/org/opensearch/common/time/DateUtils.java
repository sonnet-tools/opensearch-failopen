     * @return            the rounded milliseconds since the epoch
        tzs.put("Australia/LHI", "Australia/Lord_Howe");
    public static long roundQuarterOfYear(final long utcMillis) {
        }
        tzs.put("Singapore", "Asia/Singapore");
        tzs.put("Eire", "Europe/Dublin");
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            );
        tzs.put("Australia/West", "Australia/Perth");
        if (milliSecondsSinceEpoch < 0) {
    /**
     *
        }
        tzs.put("Canada/Pacific", "America/Vancouver");
     * Returns the current UTC date-time with milliseconds precision.
        tzs.put("Mexico/BajaNorte", "America/Tijuana");
     * <p>
        return instant;
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DateUtils.class);
        tzs.put("Asia/Saigon", "Asia/Ho_Chi_Minh");
            );
 * You may obtain a copy of the License at
                    + nanoSecondsSinceEpoch
/*
        tzs.put("Asia/Katmandu", "Asia/Kathmandu");
 */
        tzs.put("EST", "-05:00"); // eastern time without daylight savings
        tzs.put("Chile/Continental", "America/Santiago");
    /**
     */
        tzs.put("Pacific/Samoa", "Pacific/Pago_Pago");
        tzs.put("Australia/Tasmania", "Australia/Hobart");
        tzs.put("Canada/Central", "America/Winnipeg");
import java.util.Map;
        tzs.put("Asia/Tel_Aviv", "Asia/Jerusalem");
     * convert a long value to a java time instant
        tzs.put("Asia/Harbin", "Asia/Shanghai");
import static org.opensearch.common.time.DateUtilsRounding.getYear;
        if (nanoSecondsSinceEpoch < 0) {
        tzs.put("US/Indiana-Starke", "America/Indiana/Knox");
        tzs.put("Asia/Chongqing", "Asia/Shanghai");
        tzs.put("America/Coral_Harbour", "America/Atikokan");
        }
        tzs.put("Navajo", "America/Denver");
        tzs.put("ROK", "Asia/Seoul");
        tzs.put("Mexico/BajaSur", "America/Mazatlan");
    }
        tzs.put("America/Mendoza", "America/Argentina/Mendoza");
        if (nanoSecondsSinceEpoch == 0) {
        }
        int month = getMonthOfYear(utcMillis, year);
     * Return the first day of the month
        }
        tzs.put("Europe/Belfast", "Europe/London");
     * Returns an instant that is with valid nanosecond resolution. If
        }
        if (instant.isAfter(MAX_NANOSECOND_INSTANT)) {
     * the parameter is after the valid nanosecond range then this returns
     * Round down to the beginning of the week based on week year of the specified time
        return DateUtils.of(year, month);
package org.opensearch.common.time;
     */
        tzs.put("Asia/Dacca", "Asia/Dhaka");
     */
        tzs.put("America/Fort_Wayne", "America/Indiana/Indianapolis");
        DEPRECATED_LONG_TIMEZONES = Collections.unmodifiableMap(tzs);
    public static long toLong(Instant instant) {
        tzs.put("Asia/Ulan_Bator", "Asia/Ulaanbaatar");
        millis += getTotalMillisByYearMonth(year, month);
     * @param utcMillis   the milliseconds since the epoch
        tzs.put("Asia/Macao", "Asia/Macau");
        tzs.put("Asia/Ujung_Pandang", "Asia/Makassar");
        tzs.put("Australia/South", "Australia/Adelaide");
        return DateUtils.of(year, firstMonthOfQuarter);
        tzs.put("Antarctica/South_Pole", "Pacific/Auckland");
        tzs.put("America/Shiprock", "America/Denver");
            return null;
     * @param nanoSecondsSinceEpoch the nanoseconds since the epoch
            return utcMillis - utcMillis % unitMillis;
import java.time.Clock;
    }
            return ZoneOffset.UTC;
     * @return The milliseconds since the epoch rounded down to the beginning of the year
                    + "] are before the epoch in 1970 and cannot "
     * @param utcMillis the milliseconds since the epoch
        tzs.put("America/Virgin", "America/Port_of_Spain");
 *
        tzs.put("America/Louisville", "America/Kentucky/Louisville");
        return of(timeZone.getID());
     */
        } else {
    }
    static {
    static final Instant MAX_NANOSECOND_INSTANT = Instant.parse("2262-04-11T23:47:16.854775807Z");
            );
                "nanoseconds are [" + nanoSecondsSinceEpoch + "] are before the epoch in 1970 and cannot " + "be converted to milliseconds"
        tzs.put("Canada/Mountain", "America/Edmonton");
     */
 *
     */
    public static DateTimeZone zoneIdToDateTimeZone(ZoneId zoneId) {
     * that the precision of the clock can be milliseconds, microseconds or nanoseconds), whereas in Java 8
            return 0;
            );
        tzs.put("Iran", "Asia/Tehran");
 * The OpenSearch Contributors require contributions made to
 *
        } else if (milliSecondsSinceEpoch > MAX_NANOSECOND_IN_MILLIS) {
     * Rounds the given utc milliseconds sicne the epoch down to the next unit millis
     * the long value resembles the nanoseconds since the epoch
     * @param instant the instant to convert
        long seconds = nanoSecondsSinceEpoch / 1_000_000_000;
        }
     * @return The milliseconds since the epoch rounded down to the month of the year
     * @param unitMillis  the unit to round to
                "milliSeconds [" + milliSecondsSinceEpoch + "] are before the epoch in 1970 and cannot " + "be converted to nanoseconds"
        tzs.put("Brazil/Acre", "America/Rio_Branco");
     * <p>
}
            return ZoneId.of(deprecatedId);
 * Licensed to Elasticsearch under one or more contributor
            return INSTANT_LONG_MAX_VALUE;
/**
    // pkg private for tests
        Clock millisResolutionClock = Clock.tick(clock, Duration.ofMillis(1));
    }
        }
     *
 * SPDX-License-Identifier: Apache-2.0
     *
 *
        tzs.put("Greenwich", "Etc/GMT");
    }
    public static long toMilliSeconds(long nanoSecondsSinceEpoch) {
            return Instant.EPOCH;
        tzs.put("Kwajalein", "Pacific/Kwajalein");
 * software distributed under the License is distributed on an
        tzs.put("Eire", "Europe/London");
 * specific language governing permissions and limitations
import java.time.ZonedDateTime;
        tzs.put("Asia/Rangoon", "Asia/Yangon");
        return ZonedDateTime.now(millisResolutionClock);
    public static Instant toInstant(long nanoSecondsSinceEpoch) {
     * which will offer a value for {@code ZonedDateTime.now()} set to always have milliseconds precision.
            );
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.common.time.DateUtilsRounding.utcMillisAtStartOfYear;
import org.joda.time.DateTimeZone;
        tzs.put("Universal", "Etc/UTC");
    }
        tzs.put("GB", "Europe/London");
    /**
        tzs.put("Egypt", "Africa/Cairo");
    private static long of(final int year, final int month) {
        tzs.put("US/Mountain", "America/Denver");
        tzs.put("Canada/East-Saskatchewan", "America/Regina");
     */
        tzs.put("Australia/Canberra", "Australia/Sydney");
    }
        return utcMillisAtStartOfYear(year);
        int month = getMonthOfYear(utcMillis, year);
            throw new IllegalArgumentException(
        tzs.put("Pacific/Johnston", "Pacific/Honolulu");
     * - If the input is before {@code Long.MIN_VALUE}, it returns {@code Instant.ofEpochMilli(Long.MIN_VALUE)}.
        }
     * Convert a nanosecond timestamp in milliseconds
    }
        tzs.put("Portugal", "Europe/Lisbon");
                "date[" + instant + "] is before the epoch in 1970 and cannot be " + "stored in nanosecond resolution"
     * Round down to the beginning of the year of the specified time
     * Convert a nanosecond timestamp in milliseconds
 * Unless required by applicable law or agreed to in writing,
    public static long roundYear(final long utcMillis) {
import static org.opensearch.common.time.DateUtilsRounding.getTotalMillisByYearMonth;
        tzs.put("America/Cordoba", "America/Argentina/Cordoba");
        tzs.put("Africa/Timbuktu", "Africa/Abidjan");
        tzs.put("Jamaica", "America/Jamaica");
        }
 * Date utilities.
        tzs.put("Cuba", "America/Havana");
                    + "and cannot be converted to nanoseconds"
        }
    public static Instant clampToMillisRange(Instant instant) {
     * the long value resembles the nanoseconds since the epoch
        return DateTimeZone.forID(zoneId.getId());
        if (utcMillis >= 0) {
     * - Otherwise, it returns the input as-is.
            deprecationLogger.deprecate(
     * @param utcMillis the milliseconds since the epoch
import java.util.Set;
        if (zoneId == null) {
        }
    }
        tzs.put("Libya", "Africa/Tripoli");
        tzs.put("Pacific/Truk", "Pacific/Chuuk");
    }
                "Use of short timezone id " + zoneId + " is deprecated. Use " + deprecatedId + " instead"
     * @param utcMillis the milliseconds since the epoch
        tzs.put("US/Michigan", "America/Detroit");
        tzs.put("Brazil/West", "America/Manaus");
        tzs.put("US/Pacific", "America/Los_Angeles");
                    + "be processed in nanosecond resolution"
    }
        long nanos = nanoSecondsSinceEpoch % 1_000_000_000;
        tzs.put("Turkey", "Europe/Istanbul");
     * @return        the nano seconds and seconds as a single long
            );
 * compatible open source license.
        tzs.put("Poland", "Europe/Warsaw");
     * @return                      the milliseconds since the epoch
     * @param instant the {@link Instant} to clamp
    }
        tzs.put("Canada/Atlantic", "America/Halifax");
import org.opensearch.common.logging.DeprecationLogger;
        tzs.put("Chile/EasterIsland", "Pacific/Easter");
        tzs.put("America/Ensenada", "America/Tijuana");
     * the minimum {@linkplain Instant} valid for nanosecond resultion. If
        }
        tzs.put("Canada/Yukon", "America/Whitehorse");
     * @return                      the nanoseconds since the epoch
        tzs.put("America/Porto_Acre", "America/Rio_Branco");
        DEPRECATED_SHORT_TIMEZONES = Collections.unmodifiableMap(tzs);
                "date[" + instant + "] is after 2262-04-11T23:47:16.854775807 and cannot be " + "stored in nanosecond resolution"
    public static ZoneId dateTimeZoneToZoneId(DateTimeZone timeZone) {
import java.util.Collections;
        if (DateTimeZone.UTC.equals(timeZone)) {
    }
    public static ZoneId of(String zoneId) {
                    + milliSecondsSinceEpoch
    // Map of deprecated timezones and their recommended new counterpart
    /**
            // the id for zoneoffset is not ISO compatible, so cannot be read by ZoneId.of
    }
        tzs.put("Australia/NSW", "Australia/Sydney");
        return nowWithMillisResolution(Clock.systemUTC());
        tzs.put("MST", "-07:00");
        }
     */
     * - If the input is after {@code Long.MAX_VALUE}, it returns {@code Instant.ofEpochMilli(Long.MAX_VALUE)}.
            throw new IllegalArgumentException(
        if (instant.isBefore(Instant.EPOCH)) {
        tzs.put("America/Catamarca", "America/Argentina/Catamarca");
    }
        tzs.put("Canada/Eastern", "America/Toronto");
     *
     *
        tzs.put("America/Argentina/ComodRivadavia", "America/Argentina/Catamarca");
        tzs.put("PRC", "Asia/Shanghai");
 * ownership. Elasticsearch licenses this file to you under
     * @param milliSecondsSinceEpoch the millisecond since the epoch
import static org.opensearch.common.time.DateUtilsRounding.getMonthOfYear;
        return nanoSecondsSinceEpoch / 1_000_000;
        }
        tzs.put("Europe/Tiraspol", "Europe/Chisinau");
        tzs.put("Japan", "Asia/Tokyo");
    public static long roundMonthOfYear(final long utcMillis) {
     *
     * {@code System.currentTimeMillis()} is always used. To account for these differences, this method defines a new {@code Clock}
     * @param utcMillis the milliseconds since the epoch
        tzs.put("Asia/Kashgar", "Asia/Urumqi");
 * GitHub history for details.
        tzs.put("US/Eastern", "America/New_York");
     *
    public static long roundFloor(long utcMillis, final long unitMillis) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (deprecatedId != null) {
import java.time.Instant;
     * @return The milliseconds since the epoch rounded down to the beginning of the week based on week year
        tzs.put("US/Arizona", "America/Phoenix");
        tzs.put("America/Buenos_Aires", "America/Argentina/Buenos_Aires");
        tzs.put("Israel", "Asia/Jerusalem");
public class DateUtils {
        return instant;
     * @return {@link ZonedDateTime} instance for the current date-time with milliseconds precision in UTC
     */
     * convert a java time instant to a long value which is stored in lucene
    public static long roundWeekOfWeekYear(final long utcMillis) {
        if (instant.isAfter(MAX_NANOSECOND_INSTANT)) {
     * @return the clamped {@link Instant}
    /**
            return INSTANT_LONG_MIN_VALUE;
        long millis = utcMillisAtStartOfYear(year);
 */
     * @return the milliseconds since the epoch of the first day of the month in the year
    /**
        tzs.put("US/Samoa", "Pacific/Pago_Pago");
        tzs.put("Australia/Victoria", "Australia/Melbourne");
    /**
        return milliSecondsSinceEpoch * 1_000_000;
import java.time.Duration;
    static final Instant INSTANT_LONG_MAX_VALUE = Instant.ofEpochMilli(Long.MAX_VALUE);
        tzs.put("America/Jujuy", "America/Argentina/Jujuy");
     * @return The milliseconds since the epoch rounded down to the quarter of the year
        int year = getYear(utcMillis);
import java.time.ZoneOffset;
            utcMillis += 1;
    }
     * Round down to the beginning of the quarter of the year of the specified time
    public static Instant clampToNanosRange(Instant instant) {
     * the maximum {@linkplain Instant} valid for nanosecond resolution.
 * the Apache License, Version 2.0 (the "License"); you may
                "timezone_" + zoneId,
    static final Instant INSTANT_LONG_MIN_VALUE = Instant.ofEpochMilli(Long.MIN_VALUE);
    /**
 * under the License.
     * @param year  the year to return
     * @param nanoSecondsSinceEpoch the nanoseconds since the epoch
                "milliSeconds ["
    }
        return Instant.ofEpochSecond(seconds, nanos);
            return Instant.EPOCH;
        tzs.put("NZ", "Pacific/Auckland");
        DEPRECATED_SHORT_TZ_IDS = tzs.keySet();
 * @opensearch.internal
     *       In order to ensure the performance of this methods, there are no guards or checks in it
     * @throws NullPointerException if the input is {@code null}
        tzs.put("US/East-Indiana", "America/Indiana/Indianapolis");
            throw new IllegalArgumentException(
        tzs.put("Atlantic/Faeroe", "Atlantic/Faroe");
        tzs.put("Africa/Asmera", "Africa/Nairobi");
        tzs.put("America/Knox_IN", "America/Indiana/Knox");
            return DateTimeZone.forOffsetMillis(((ZoneOffset) zoneId).getTotalSeconds() * 1000);
        tzs.put("US/Aleutian", "America/Adak");
        tzs.put("America/Santa_Isabel", "America/Tijuana");
            throw new IllegalArgumentException(
    public static ZonedDateTime nowWithMillisResolution() {
        tzs.put("Australia/Yancowinna", "Australia/Broken_Hill");
        }
        tzs.put("America/Indianapolis", "America/Indiana/Indianapolis");
    static {
     */
        int year = getYear(utcMillis);
        if (timeZone == null) {
        tzs.put("America/Montreal", "America/Toronto");
        tzs.put("NZ-CHAT", "Pacific/Chatham");
        if (zoneId instanceof ZoneOffset) {
        tzs.put("Asia/Calcutta", "Asia/Kolkata");
        int year = getYear(utcMillis);
            throw new IllegalArgumentException(
        tzs.put("Australia/ACT", "Australia/Sydney");
        tzs.put("Australia/Queensland", "Australia/Brisbane");
        tzs.put("Australia/North", "Australia/Darwin");
/*
        tzs.put("Brazil/East", "America/Sao_Paulo");
            return MAX_NANOSECOND_INSTANT;
                "nanoseconds ["
     * @param month the month to return, ranging from 1-12
        tzs.put("America/Rosario", "America/Argentina/Cordoba");
        tzs.put("UCT", "Etc/UCT");
        if (nanoSecondsSinceEpoch < 0) {
    }
        tzs.put("Atlantic/Jan_Mayen", "Europe/Oslo");
        if (instant.isBefore(Instant.EPOCH)) {
            return null;
    static final Map<String, String> DEPRECATED_SHORT_TIMEZONES;
    /**
        tzs.put("Hongkong", "Asia/Hong_Kong");
     * even if the range's endpoints are not valid nanosecond resolution.
import java.time.ZoneId;
    /**
        int firstMonthOfQuarter = (((month - 1) / 3) * 3) + 1;
        tzs.put("US/Hawaii", "Pacific/Honolulu");
 * this work for additional information regarding copyright
    }
     */
        tzs.put("America/Atka", "America/Adak");
        tzs.put("Asia/Ashkhabad", "Asia/Ashgabat");
    public static final Set<String> DEPRECATED_SHORT_TZ_IDS;
        tzs.put("ROC", "Asia/Taipei");
        tzs.put("W-SU", "Europe/Moscow");
    /**
        Map<String, String> tzs = new HashMap<>();
            throw new IllegalArgumentException(
     * the parameter is before the valid nanosecond range then this returns
        tzs.put("HST", "-10:00");
        tzs.put("Iceland", "Atlantic/Reykjavik");
        Map<String, String> tzs = new HashMap<>();
        tzs.put("Asia/Chungking", "Asia/Shanghai");
        tzs.put("Pacific/Ponape", "Pacific/Pohnpei");
        tzs.put("Zulu", "Etc/UTC");
/*
    /**
 */
        tzs.put("GB-Eire", "Europe/London");
        tzs.put("ROC", "Asia/Taipei");
        return instant.getEpochSecond() * 1_000_000_000 + instant.getNano();
        return ZoneId.of(zoneId).normalized();
     * @return                      the instant resembling the specified date
     */
        String deprecatedId = DEPRECATED_SHORT_TIMEZONES.get(zoneId);
     * Note: This does not check for correctness of the result, as this only works with units smaller or equal than a day
        tzs.put("US/Alaska", "America/Anchorage");
 * Modifications Copyright OpenSearch Contributors. See
        tzs.put("Brazil/DeNoronha", "America/Noronha");
     * In Java 9+ (as opposed to Java 8) the {@code Clock} implementation uses system's best clock implementation (which could mean
    static final long MAX_NANOSECOND_IN_MILLIS = MAX_NANOSECOND_INSTANT.toEpochMilli();
            );
    public static long toNanoSeconds(long milliSecondsSinceEpoch) {
        tzs.put("US/Central", "America/Chicago");
                    + "] are after 2262-04-11T23:47:16.854775807 "
        tzs.put("Mexico/General", "America/Mexico_City");
        if (instant.isBefore(INSTANT_LONG_MIN_VALUE)) {
 */
        tzs.put("Asia/Thimbu", "Asia/Thimphu");
        return millis;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.HashMap;
        return roundFloor(utcMillis + 3 * 86400 * 1000L, 604800000) - 3 * 86400 * 1000L;
     * Clamps the given {@link Instant} to the valid epoch millisecond range.
    /**
        if (nanoSecondsSinceEpoch == 0) {
            return utcMillis - utcMillis % unitMillis - unitMillis;
        tzs.put("Pacific/Yap", "Pacific/Chuuk");
    public static ZonedDateTime nowWithMillisResolution(Clock clock) {
        if (instant.isAfter(INSTANT_LONG_MAX_VALUE)) {
     *
    public static final Map<String, String> DEPRECATED_LONG_TIMEZONES;
        }
     * Round down to the beginning of the month of the year of the specified time
        tzs.put("Canada/Newfoundland", "America/St_Johns");
     * Useful for checking if all values for the field are within some range,
     */
 * KIND, either express or implied.  See the License for the
