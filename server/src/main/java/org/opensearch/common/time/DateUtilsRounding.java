 *  See the License for the specific language governing permissions and
}
            minSum += millis;
    private static final int[] MAX_DAYS_PER_MONTH_ARRAY = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
 * - org.joda.time.chrono.GregorianChronology.calculateFirstDayOfYearMillis(int year)
        }
                oneYear = MILLIS_PER_DAY * 365L;
                ? ((i < 90 * 84375)
            // it works for both positive and negative values, except this optimization
                    ? ((i < 213 * 84375) ? 7 : (i < 244 * 84375) ? 8 : 9)
 *
    static boolean isLeapYear(final int year) {
        // compare using ints instead of longs. The number of milliseconds per
                year++;
    static long getTotalMillisByYearMonth(final int year, final int month) {
        }
     *
            if (isLeapYear(year)) {
 *  You may obtain a copy of the License at
    private static final long AVERAGE_MILLIS_PER_YEAR_DIVIDED_BY_TWO = MILLIS_PER_YEAR / 2;
 * <p>
     */
    // see org.joda.time.chrono.BasicGJChronology
        // 84375. There are 84375 (128/125)seconds per day.
        // milliseconds per day contains 1024 as a factor. After the division,
        // the instant isn't measured in milliseconds, but in units of
            if (yearStart <= utcMillis) {
 */
            long oneYear;
        long diff = utcMillis - yearStart;
            : ((i < 181 * 84375)
/*
            } else {
            // (year / 4) - (year / 100) + (year / 400),
 * compatible open source license.
            return MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[month - 1];
        int leapYears = year / 100;
        int year = (int) (i2 / unitMillis);
 * @opensearch.internal
    private static final long APPROX_MILLIS_AT_EPOCH_DIVIDED_BY_TWO = (1970L * MILLIS_PER_YEAR) / 2;
 *  limitations under the License.
        }
     * @param year the year
 * this file be licensed under the Apache-2.0 license or a
        }
         * rounding the nearest month by about 8%.
 * See following methods have been copied (along with required helper variables)
 *  Copyright 2001-2014 Stephen Colebourne
        if (isLeapYear(year)) {
    static int getMonthOfYear(final long utcMillis, final int year) {
    /**
         */
        int i = (int) ((utcMillis - utcMillisAtStartOfYear(year)) >> 10);
    private static final int[] MIN_DAYS_PER_MONTH_ARRAY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
 */
/* @notice
        // There are 86400000 milliseconds per day, but divided by 1024 is
 * <p>
/*
        // Joda had
        }
        if ((year & 3) != 0) {
         * Division is slow so it almost certainly is.
        // necessary.
        // return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);
        if (i2 < 0) {
    }
    private static final int MILLIS_PER_DAY = 86_400_000;
                ? ((i < 91 * 84375)
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        // represents the start of that year. Then verify estimate and fix if
    }
 *
 *
                    : ((i < 120 * 84375) ? 4 : (i < 151 * 84375) ? 5 : 6))
        for (int i = 0; i < 11; i++) {
 *  you may not use this file except in compliance with the License.
         * sequence of bit twiddling operations which the jvm thinks is faster.
        long unitMillis = AVERAGE_MILLIS_PER_YEAR_DIVIDED_BY_TWO;
    private static final int DAYS_0000_TO_1970 = 719527;
    private static final long[] MAX_TOTAL_MILLIS_BY_MONTH_ARRAY;
    private static final long[] MIN_TOTAL_MILLIS_BY_MONTH_ARRAY;
        // Perform a binary search to get the month. To make it go even faster,
            long millis = MIN_DAYS_PER_MONTH_ARRAY[i] * (long) MILLIS_PER_DAY;
        } else {
    static int getYear(final long utcMillis) {
         * Note: If you decompile this method to x86 assembly you won't see the
        // But we've replaced that with this:
        // (128/125)seconds.
            leapYears = (year >> 2) - leapYears + (leapYears >> 2);
        long minSum = 0;
            return MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[month - 1];
        return (year * 365L + (leapYears - DAYS_0000_TO_1970)) * MILLIS_PER_DAY; // millis per day
    }
            millis = MAX_DAYS_PER_MONTH_ARRAY[i] * (long) MILLIS_PER_DAY;
        return (isLeapYear(year))
            leapYears = ((year + 3) >> 2) - leapYears + ((leapYears + 3) >> 2) - 1;
                    ? ((i < 31 * 84375) ? 1 : (i < 59 * 84375) ? 2 : 3)
 * The source can be found at https://github.com/JodaOrg/joda-time/tree/v2.10.1
        }
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 * - org.joda.time.chrono.BasicGJChronology.getMonthOfYear(long utcMillis, int year)
 * Modifications Copyright OpenSearch Contributors. See
 * <p>
        } else if (diff >= MILLIS_PER_DAY * 365L) {
        } else {
                leapYears--;
    // see org.joda.time.chrono.BasicChronology
 */
            }
        // year exceeds the limit of a 32-bit int's capacity, so divide by
                    : ((i < 304 * 84375) ? 10 : (i < 334 * 84375) ? 11 : 12)));
    private static final long MILLIS_PER_YEAR = 31556952000L;
        long maxSum = 0;
 *  distributed under the License is distributed on an "AS IS" BASIS,
 * The OpenSearch Contributors require contributions made to
    // see org.joda.time.chrono.BasicGJChronology
        MIN_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
        if (year < 0) {
        MAX_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
        long yearStart = utcMillisAtStartOfYear(year);
                // Didn't go too far, so actually add one year.
        // 1024. No precision is lost (except time of day) since the number of
            maxSum += millis;
 * This class has been copied from different locations within the joda time package, as
package org.opensearch.common.time;
                    ? ((i < 212 * 84375) ? 7 : (i < 243 * 84375) ? 8 : 9)
                    : ((i < 121 * 84375) ? 4 : (i < 152 * 84375) ? 5 : 6))
 * time objects
            // on negative numbers. When the expression is written as
                : ((i < 274 * 84375)
            }
 */
         * It is a little faster because it saves a division. We don't have good
            MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i + 1] = maxSum;
            i2 = i2 - unitMillis + 1;
            MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i + 1] = minSum;
            // Add 3 before shifting right since /4 and >>2 behave differently
 * - org.joda.time.chrono.BasicChronology.getYear(int year)
                : ((i < 273 * 84375)
            // eliminates two divisions.
         *
     * @return the milliseconds since the epoch of the first of january at midnight of the specified year
    static long utcMillisAtStartOfYear(final int year) {
            return false;
        // Get an initial estimate of the year, and the millis value that
    // see org.joda.time.chrono.BasicGJChronology
        long i2 = (utcMillis >> 1) + APPROX_MILLIS_AT_EPOCH_DIVIDED_BY_TWO;
    }
            year--;
         * division you'd expect from % 100 and / 100. Instead you'll see a funny
    // see org.joda.time.chrono.GregorianChronology.calculateFirstDayOfYearMillis
        // Initial estimate uses values divided by two to avoid overflow.
        if (diff < 0) {
        // Initial value is just temporary.
            yearStart += oneYear;
            }
     * calculates the first day of a year in milliseconds since the epoch (assuming UTC)
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 * This code has been copied from jodatime 2.10.1
        return ((year / 100) & 3) == 0;
 * these methods fast when used for rounding, as they do not require conversion to java
                oneYear = MILLIS_PER_DAY * 366L;
 * SPDX-License-Identifier: Apache-2.0
/**
 * GitHub history for details.
        if (year % 100 != 0) {
            ? ((i < 182 * 84375)
            return true;
        /*
                    ? ((i < 31 * 84375) ? 1 : (i < 60 * 84375) ? 2 : 3)
    static {
            if (isLeapYear(year)) {
            // One year may need to be added to fix estimate.
                    : ((i < 305 * 84375) ? 10 : (i < 335 * 84375) ? 11 : 12)))
class DateUtilsRounding {
        }
    }
         * measurements for this method on its own, but this change speeds up
    }
 * - org.joda.time.chrono.BasicGJChronology.getTotalMillisByYearMonth(int year, int month)
        return year;
