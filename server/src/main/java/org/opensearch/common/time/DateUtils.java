        tzs.put("Australia/Tasmania", "Australia/Hobart");  
        tzs.put("Australia/North", "Australia/Darwin");  
     *  
        tzs.put("Chile/EasterIsland", "Pacific/Easter");
        tzs.put("US/Hawaii", "Pacific/Honolulu");
     * @return The milliseconds since the epoch rounded down to the beginning of the year  
        tzs.put("Iceland", "Atlantic/Reykjavik");  
    /**
    }
     * @param utcMillis the milliseconds since the epoch
     */  
 * specific language governing permissions and limitations
     * Useful for checking if all values for the field are within some range,  
        return utcMillisAtStartOfYear(year);
 * GitHub history for details.
     */  
            return utcMillis - utcMillis % unitMillis;  
    }
            return DateTimeZone.forOffsetMillis(((ZoneOffset) zoneId).getTotalSeconds() * 1000);
        }
     */  
        Map<String, String> tzs = new HashMap<>();  
    }
    /**
        if (instant.isAfter(MAX_NANOSECOND_INSTANT)) {  
     *
        tzs.put("Iran", "Asia/Tehran");
        tzs.put("Asia/Harbin", "Asia/Shanghai");
     * convert a java time instant to a long value which is stored in lucene  
        tzs.put("Singapore", "Asia/Singapore");
        tzs.put("Chile/Continental", "America/Santiago");
        tzs.put("Poland", "Europe/Warsaw");
    }  
        tzs.put("Asia/Katmandu", "Asia/Kathmandu");
        tzs.put("NZ-CHAT", "Pacific/Chatham");
 *
        tzs.put("Pacific/Johnston", "Pacific/Honolulu");
        int month = getMonthOfYear(utcMillis, year);
            throw new IllegalArgumentException(
        tzs.put("America/Atka", "America/Adak");
 * The OpenSearch Contributors require contributions made to  
     * which will offer a value for {@code ZonedDateTime.now()} set to always have milliseconds precision.  
        return ZonedDateTime.now(millisResolutionClock);
        }
        tzs.put("Canada/East-Saskatchewan", "America/Regina");
        tzs.put("Canada/Newfoundland", "America/St_Johns");
            );  
    /**
        millis += getTotalMillisByYearMonth(year, month);  
 * software distributed under the License is distributed on an
        DEPRECATED_SHORT_TZ_IDS = tzs.keySet();
        tzs.put("US/Indiana-Starke", "America/Indiana/Knox");  
    public static long roundWeekOfWeekYear(final long utcMillis) {  
    // Map of deprecated timezones and their recommended new counterpart
            return ZoneId.of(deprecatedId);
 * the Apache License, Version 2.0 (the "License"); you may
        tzs.put("Australia/ACT", "Australia/Sydney");
        tzs.put("US/East-Indiana", "America/Indiana/Indianapolis");  
        }
    /**
        Map<String, String> tzs = new HashMap<>();
     * @param instant the {@link Instant} to clamp
        } else {
        tzs.put("EST", "-05:00"); // eastern time without daylight savings
     * Convert a nanosecond timestamp in milliseconds  
    }
     * Round down to the beginning of the month of the year of the specified time
    static {  
     * @return {@link ZonedDateTime} instance for the current date-time with milliseconds precision in UTC
        }
        tzs.put("Asia/Ashkhabad", "Asia/Ashgabat");  
        tzs.put("US/Michigan", "America/Detroit");
            return ZoneOffset.UTC;
        String deprecatedId = DEPRECATED_SHORT_TIMEZONES.get(zoneId);
        tzs.put("Canada/Atlantic", "America/Halifax");
        tzs.put("Asia/Tel_Aviv", "Asia/Jerusalem");
        tzs.put("Portugal", "Europe/Lisbon");
        tzs.put("Europe/Tiraspol", "Europe/Chisinau");
     * @return        the nano seconds and seconds as a single long
 * this work for additional information regarding copyright
        return ZoneId.of(zoneId).normalized();
 * ownership. Elasticsearch licenses this file to you under  
    }
    public static Instant toInstant(long nanoSecondsSinceEpoch) {
     *
     * the parameter is before the valid nanosecond range then this returns
    static final long MAX_NANOSECOND_IN_MILLIS = MAX_NANOSECOND_INSTANT.toEpochMilli();  
    public static final Set<String> DEPRECATED_SHORT_TZ_IDS;
 * compatible open source license.
        tzs.put("UCT", "Etc/UCT");
                "milliSeconds ["  
import static org.opensearch.common.time.DateUtilsRounding.getTotalMillisByYearMonth;
     */
        tzs.put("ROC", "Asia/Taipei");  
     * @param milliSecondsSinceEpoch the millisecond since the epoch
        tzs.put("Canada/Pacific", "America/Vancouver");
        int year = getYear(utcMillis);
        tzs.put("NZ", "Pacific/Auckland");
        if (instant.isBefore(INSTANT_LONG_MIN_VALUE)) {
import java.time.ZoneOffset;
     * Return the first day of the month
        }  
    public static long roundFloor(long utcMillis, final long unitMillis) {
 * You may obtain a copy of the License at  
    // pkg private for tests
        tzs.put("Hongkong", "Asia/Hong_Kong");
        }  
    }
    static final Instant MAX_NANOSECOND_INSTANT = Instant.parse("2262-04-11T23:47:16.854775807Z");
    public static DateTimeZone zoneIdToDateTimeZone(ZoneId zoneId) {
     */
    public static Instant clampToMillisRange(Instant instant) {  
        return nanoSecondsSinceEpoch / 1_000_000;  
        tzs.put("ROK", "Asia/Seoul");
        return DateUtils.of(year, firstMonthOfQuarter);
 * Unless required by applicable law or agreed to in writing,
    public static long toLong(Instant instant) {  
        DEPRECATED_LONG_TIMEZONES = Collections.unmodifiableMap(tzs);
     */
    public static final Map<String, String> DEPRECATED_LONG_TIMEZONES;
        tzs.put("MST", "-07:00");  
import static org.opensearch.common.time.DateUtilsRounding.utcMillisAtStartOfYear;  
        return DateTimeZone.forID(zoneId.getId());
                "date[" + instant + "] is after 2262-04-11T23:47:16.854775807 and cannot be " + "stored in nanosecond resolution"
import static org.opensearch.common.time.DateUtilsRounding.getMonthOfYear;  
     */
import java.time.Duration;
        tzs.put("Canada/Mountain", "America/Edmonton");  
            // the id for zoneoffset is not ISO compatible, so cannot be read by ZoneId.of
        tzs.put("Canada/Yukon", "America/Whitehorse");  
        if (nanoSecondsSinceEpoch < 0) {
/*  
    }
    private static long of(final int year, final int month) {
        tzs.put("Israel", "Asia/Jerusalem");
        tzs.put("Asia/Ulan_Bator", "Asia/Ulaanbaatar");
        }
        if (instant.isBefore(Instant.EPOCH)) {
        tzs.put("GB", "Europe/London");
import java.time.Clock;
     * @param unitMillis  the unit to round to
        tzs.put("America/Buenos_Aires", "America/Argentina/Buenos_Aires");  
        tzs.put("Canada/Central", "America/Winnipeg");  
    public static long roundMonthOfYear(final long utcMillis) {  
public class DateUtils {
            );  
     * {@code System.currentTimeMillis()} is always used. To account for these differences, this method defines a new {@code Clock}
     */
     * Round down to the beginning of the quarter of the year of the specified time
     * Clamps the given {@link Instant} to the valid epoch millisecond range.
    /**
            deprecationLogger.deprecate(
        if (zoneId == null) {  
     * @throws NullPointerException if the input is {@code null}
        tzs.put("Asia/Kashgar", "Asia/Urumqi");  
        tzs.put("Brazil/DeNoronha", "America/Noronha");
    public static Instant clampToNanosRange(Instant instant) {  
        tzs.put("Asia/Calcutta", "Asia/Kolkata");
        tzs.put("Australia/LHI", "Australia/Lord_Howe");
        tzs.put("America/Mendoza", "America/Argentina/Mendoza");
     * Round down to the beginning of the year of the specified time
import java.util.HashMap;
     * Rounds the given utc milliseconds sicne the epoch down to the next unit millis
/*
     * the long value resembles the nanoseconds since the epoch  
     * @return The milliseconds since the epoch rounded down to the beginning of the week based on week year
import org.opensearch.common.logging.DeprecationLogger;
     *
            throw new IllegalArgumentException(  
     */
        tzs.put("Australia/Victoria", "Australia/Melbourne");
        tzs.put("US/Mountain", "America/Denver");
        tzs.put("Zulu", "Etc/UTC");
 * not use this file except in compliance with the License.
    public static ZonedDateTime nowWithMillisResolution() {
     *  
        tzs.put("US/Aleutian", "America/Adak");  
        tzs.put("Australia/Canberra", "Australia/Sydney");  
        tzs.put("Asia/Thimbu", "Asia/Thimphu");  
        tzs.put("US/Pacific", "America/Los_Angeles");  
        return nowWithMillisResolution(Clock.systemUTC());
     * @param utcMillis   the milliseconds since the epoch  
        tzs.put("Asia/Chungking", "Asia/Shanghai");  
 * license agreements. See the NOTICE file distributed with
        }
                "Use of short timezone id " + zoneId + " is deprecated. Use " + deprecatedId + " instead"  
     * Convert a nanosecond timestamp in milliseconds
        int firstMonthOfQuarter = (((month - 1) / 3) * 3) + 1;  
    }
    public static long roundQuarterOfYear(final long utcMillis) {  
 */  
     * - If the input is after {@code Long.MAX_VALUE}, it returns {@code Instant.ofEpochMilli(Long.MAX_VALUE)}.
        tzs.put("Turkey", "Europe/Istanbul");  
     */  
    /**
     * - If the input is before {@code Long.MIN_VALUE}, it returns {@code Instant.ofEpochMilli(Long.MIN_VALUE)}.
    static final Map<String, String> DEPRECATED_SHORT_TIMEZONES;  
    public static long toMilliSeconds(long nanoSecondsSinceEpoch) {
        tzs.put("Australia/Queensland", "Australia/Brisbane");
    }
        tzs.put("Pacific/Truk", "Pacific/Chuuk");
        }  
        tzs.put("US/Central", "America/Chicago");
        tzs.put("Greenwich", "Etc/GMT");
     * the long value resembles the nanoseconds since the epoch
        tzs.put("America/Knox_IN", "America/Indiana/Knox");
                "nanoseconds are [" + nanoSecondsSinceEpoch + "] are before the epoch in 1970 and cannot " + "be converted to milliseconds"
        tzs.put("America/Virgin", "America/Port_of_Spain");
     *       In order to ensure the performance of this methods, there are no guards or checks in it
        tzs.put("US/Arizona", "America/Phoenix");
        if (nanoSecondsSinceEpoch == 0) {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(DateUtils.class);
        return DateUtils.of(year, month);  
        if (deprecatedId != null) {  
import java.time.Instant;  
        int year = getYear(utcMillis);  
     *
     * the parameter is after the valid nanosecond range then this returns  
     *
        if (DateTimeZone.UTC.equals(timeZone)) {  
        tzs.put("America/Coral_Harbour", "America/Atikokan");
 * @opensearch.internal
                    + nanoSecondsSinceEpoch  
        }
        tzs.put("US/Samoa", "Pacific/Pago_Pago");
    }  
 * KIND, either express or implied.  See the License for the
        tzs.put("Asia/Macao", "Asia/Macau");
    static {
            return Instant.EPOCH;  
import java.time.ZonedDateTime;  
     * @param utcMillis the milliseconds since the epoch  
     * In Java 9+ (as opposed to Java 8) the {@code Clock} implementation uses system's best clock implementation (which could mean  
    /**
        tzs.put("Jamaica", "America/Jamaica");  
        tzs.put("Brazil/West", "America/Manaus");
        tzs.put("Kwajalein", "Pacific/Kwajalein");
 *
        return of(timeZone.getID());
            return 0;  
        tzs.put("Australia/South", "Australia/Adelaide");
    }
                    + "be processed in nanosecond resolution"
        tzs.put("ROC", "Asia/Taipei");
        int month = getMonthOfYear(utcMillis, year);
    static final Instant INSTANT_LONG_MIN_VALUE = Instant.ofEpochMilli(Long.MIN_VALUE);
        tzs.put("Brazil/Acre", "America/Rio_Branco");
        tzs.put("Asia/Ujung_Pandang", "Asia/Makassar");
            throw new IllegalArgumentException(
                "date[" + instant + "] is before the epoch in 1970 and cannot be " + "stored in nanosecond resolution"  
        tzs.put("America/Jujuy", "America/Argentina/Jujuy");
                    + "] are after 2262-04-11T23:47:16.854775807 "
        if (instant.isBefore(Instant.EPOCH)) {
     * @param utcMillis the milliseconds since the epoch  
            );
    /**  
    /**
            throw new IllegalArgumentException(
        tzs.put("Australia/West", "Australia/Perth");
        tzs.put("US/Eastern", "America/New_York");
    }
     */
        tzs.put("Cuba", "America/Havana");  
            return INSTANT_LONG_MAX_VALUE;
    }  
        return instant;
        return Instant.ofEpochSecond(seconds, nanos);
        tzs.put("America/Catamarca", "America/Argentina/Catamarca");
import java.util.Map;  
     * @param nanoSecondsSinceEpoch the nanoseconds since the epoch
 */  
    static final Instant INSTANT_LONG_MAX_VALUE = Instant.ofEpochMilli(Long.MAX_VALUE);
        long seconds = nanoSecondsSinceEpoch / 1_000_000_000;  
        tzs.put("Mexico/General", "America/Mexico_City");  
     * Returns the current UTC date-time with milliseconds precision.
        tzs.put("America/Rosario", "America/Argentina/Cordoba");
        }  
    /**
        if (instant.isAfter(MAX_NANOSECOND_INSTANT)) {
     * @return the milliseconds since the epoch of the first day of the month in the year
        tzs.put("Canada/Eastern", "America/Toronto");
        tzs.put("America/Argentina/ComodRivadavia", "America/Argentina/Catamarca");
     * Note: This does not check for correctness of the result, as this only works with units smaller or equal than a day  
     * @param utcMillis the milliseconds since the epoch  
        tzs.put("America/Shiprock", "America/Denver");  
    /**
        tzs.put("Universal", "Etc/UTC");
     *
        tzs.put("Brazil/East", "America/Sao_Paulo");  
        tzs.put("America/Porto_Acre", "America/Rio_Branco");  
        tzs.put("Pacific/Samoa", "Pacific/Pago_Pago");
    }
    public static ZoneId of(String zoneId) {
        tzs.put("Japan", "Asia/Tokyo");
            );
        DEPRECATED_SHORT_TIMEZONES = Collections.unmodifiableMap(tzs);  
        tzs.put("America/Louisville", "America/Kentucky/Louisville");  
     * convert a long value to a java time instant
        tzs.put("Asia/Rangoon", "Asia/Yangon");  
        return millis;
        Clock millisResolutionClock = Clock.tick(clock, Duration.ofMillis(1));  
        tzs.put("Africa/Timbuktu", "Africa/Abidjan");  
                "milliSeconds [" + milliSecondsSinceEpoch + "] are before the epoch in 1970 and cannot " + "be converted to nanoseconds"
    }
        tzs.put("America/Fort_Wayne", "America/Indiana/Indianapolis");
     * - Otherwise, it returns the input as-is.  
            utcMillis += 1;
        if (nanoSecondsSinceEpoch == 0) {
        tzs.put("Navajo", "America/Denver");  
        tzs.put("GB-Eire", "Europe/London");  
    }
        tzs.put("PRC", "Asia/Shanghai");
    public static ZonedDateTime nowWithMillisResolution(Clock clock) {
        tzs.put("Mexico/BajaNorte", "America/Tijuana");
     * <p>
 *  
            );
        tzs.put("America/Santa_Isabel", "America/Tijuana");
 * Licensed to Elasticsearch under one or more contributor  
        if (timeZone == null) {  
/**
     * @return The milliseconds since the epoch rounded down to the quarter of the year
        }
        tzs.put("Asia/Saigon", "Asia/Ho_Chi_Minh");
        tzs.put("Egypt", "Africa/Cairo");
     * <p>
import java.util.Collections;
     * Returns an instant that is with valid nanosecond resolution. If  
import static org.opensearch.common.time.DateUtilsRounding.getYear;
     * the maximum {@linkplain Instant} valid for nanosecond resolution.
    }
     * @param month the month to return, ranging from 1-12
 * under the License.  
     * Round down to the beginning of the week based on week year of the specified time
        tzs.put("Europe/Belfast", "Europe/London");  
/*  
        tzs.put("US/Alaska", "America/Anchorage");
     */
     * @return the clamped {@link Instant}  
     */
                "nanoseconds ["
        tzs.put("Australia/Yancowinna", "Australia/Broken_Hill");  
import java.util.Set;
     * @return                      the nanoseconds since the epoch  
        tzs.put("America/Cordoba", "America/Argentina/Cordoba");  
            return Instant.EPOCH;
     * @return                      the milliseconds since the epoch
 */  
        tzs.put("Atlantic/Jan_Mayen", "Europe/Oslo");
 * Date utilities.  
        tzs.put("Pacific/Yap", "Pacific/Chuuk");  
        tzs.put("Australia/NSW", "Australia/Sydney");
 * SPDX-License-Identifier: Apache-2.0
        }
            );
        tzs.put("Libya", "Africa/Tripoli");  
                    + "] are before the epoch in 1970 and cannot "
        return roundFloor(utcMillis + 3 * 86400 * 1000L, 604800000) - 3 * 86400 * 1000L;
        tzs.put("HST", "-10:00");
    }  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    + "and cannot be converted to nanoseconds"  
import java.time.ZoneId;
        tzs.put("Africa/Asmera", "Africa/Nairobi");
package org.opensearch.common.time;
     * @return            the rounded milliseconds since the epoch
     * @param year  the year to return  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        tzs.put("America/Indianapolis", "America/Indiana/Indianapolis");  
        return instant.getEpochSecond() * 1_000_000_000 + instant.getNano();
        return milliSecondsSinceEpoch * 1_000_000;
                    + milliSecondsSinceEpoch
        tzs.put("America/Ensenada", "America/Tijuana");
        if (utcMillis >= 0) {
}  
     * @param instant the instant to convert  
        }  
        long nanos = nanoSecondsSinceEpoch % 1_000_000_000;
        int year = getYear(utcMillis);
        tzs.put("America/Montreal", "America/Toronto");
 */
            return null;
    public static long roundYear(final long utcMillis) {
            );  
        tzs.put("W-SU", "Europe/Moscow");  
    public static ZoneId dateTimeZoneToZoneId(DateTimeZone timeZone) {
     * @param nanoSecondsSinceEpoch the nanoseconds since the epoch
     * @return The milliseconds since the epoch rounded down to the month of the year
        tzs.put("Antarctica/South_Pole", "Pacific/Auckland");
        tzs.put("Pacific/Ponape", "Pacific/Pohnpei");  
        }  
            throw new IllegalArgumentException(
        tzs.put("Eire", "Europe/Dublin");
        tzs.put("Eire", "Europe/London");
            return utcMillis - utcMillis % unitMillis - unitMillis;  
     * the minimum {@linkplain Instant} valid for nanosecond resultion. If
            return INSTANT_LONG_MIN_VALUE;
        }  
            throw new IllegalArgumentException(
        if (milliSecondsSinceEpoch < 0) {  
 * Modifications Copyright OpenSearch Contributors. See
import org.joda.time.DateTimeZone;
        long millis = utcMillisAtStartOfYear(year);
                "timezone_" + zoneId,
    /**
        } else if (milliSecondsSinceEpoch > MAX_NANOSECOND_IN_MILLIS) {
     * even if the range's endpoints are not valid nanosecond resolution.
        return instant;
            return null;
        if (instant.isAfter(INSTANT_LONG_MAX_VALUE)) {
        tzs.put("Asia/Dacca", "Asia/Dhaka");
        tzs.put("Mexico/BajaSur", "America/Mazatlan");
            return MAX_NANOSECOND_INSTANT;
     * @return                      the instant resembling the specified date  
    public static long toNanoSeconds(long milliSecondsSinceEpoch) {
    /**  
        }
 * this file be licensed under the Apache-2.0 license or a
     * that the precision of the clock can be milliseconds, microseconds or nanoseconds), whereas in Java 8
 *
        if (zoneId instanceof ZoneOffset) {  
        tzs.put("Atlantic/Faeroe", "Atlantic/Faroe");  
        tzs.put("Asia/Chongqing", "Asia/Shanghai");
        if (nanoSecondsSinceEpoch < 0) {  
