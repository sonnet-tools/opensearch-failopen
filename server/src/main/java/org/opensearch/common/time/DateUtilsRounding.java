            }
        }
    // see org.joda.time.chrono.GregorianChronology.calculateFirstDayOfYearMillis
        // milliseconds per day contains 1024 as a factor. After the division,  
                    ? ((i < 213 * 84375) ? 7 : (i < 244 * 84375) ? 8 : 9)  
        long maxSum = 0;
    private static final int DAYS_0000_TO_1970 = 719527;
        long yearStart = utcMillisAtStartOfYear(year);
 *
 * - org.joda.time.chrono.BasicChronology.getYear(int year)
        // return ((year & 3) == 0) && ((year % 100) != 0 || (year % 400) == 0);  
        } else {  
            : ((i < 181 * 84375)
            } else {  
 * - org.joda.time.chrono.GregorianChronology.calculateFirstDayOfYearMillis(int year)
 */
                    ? ((i < 31 * 84375) ? 1 : (i < 60 * 84375) ? 2 : 3)  
/**  
        }
 * See following methods have been copied (along with required helper variables)
/* @notice
    }
        int i = (int) ((utcMillis - utcMillisAtStartOfYear(year)) >> 10);
            return true;  
 * compatible open source license.
    // see org.joda.time.chrono.BasicGJChronology
    private static final long[] MIN_TOTAL_MILLIS_BY_MONTH_ARRAY;  
        }
 * time objects  
                leapYears--;  
            MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[i + 1] = minSum;
    /**
 *  Unless required by applicable law or agreed to in writing, software
            leapYears = ((year + 3) >> 2) - leapYears + ((leapYears + 3) >> 2) - 1;
 *  You may obtain a copy of the License at
 *  See the License for the specific language governing permissions and
            // on negative numbers. When the expression is written as
        // compare using ints instead of longs. The number of milliseconds per  
 * these methods fast when used for rounding, as they do not require conversion to java
 * The source can be found at https://github.com/JodaOrg/joda-time/tree/v2.10.1  
        if (i2 < 0) {  
 * Modifications Copyright OpenSearch Contributors. See  
        long minSum = 0;  
        // the instant isn't measured in milliseconds, but in units of
        // There are 86400000 milliseconds per day, but divided by 1024 is  
         * rounding the nearest month by about 8%.  
        // year exceeds the limit of a 32-bit int's capacity, so divide by
            if (isLeapYear(year)) {
            i2 = i2 - unitMillis + 1;
                oneYear = MILLIS_PER_DAY * 365L;
    static long utcMillisAtStartOfYear(final int year) {
            }
        int leapYears = year / 100;
         *
/*  
 *  limitations under the License.  
package org.opensearch.common.time;
        } else {  
         */  
        long unitMillis = AVERAGE_MILLIS_PER_YEAR_DIVIDED_BY_TWO;
        return (year * 365L + (leapYears - DAYS_0000_TO_1970)) * MILLIS_PER_DAY; // millis per day
        if (diff < 0) {
        return year;  
 *
}
            }  
 *
 *      http://www.apache.org/licenses/LICENSE-2.0  
        int year = (int) (i2 / unitMillis);  
 *  distributed under the License is distributed on an "AS IS" BASIS,  
 *  Copyright 2001-2014 Stephen Colebourne  
        }
         * division you'd expect from % 100 and / 100. Instead you'll see a funny  
        // (128/125)seconds.
 *
                    : ((i < 121 * 84375) ? 4 : (i < 152 * 84375) ? 5 : 6))
     * calculates the first day of a year in milliseconds since the epoch (assuming UTC)
 */
    // see org.joda.time.chrono.BasicGJChronology
            leapYears = (year >> 2) - leapYears + (leapYears >> 2);
         * It is a little faster because it saves a division. We don't have good
         * Division is slow so it almost certainly is.
        for (int i = 0; i < 11; i++) {
    private static final int MILLIS_PER_DAY = 86_400_000;
        } else if (diff >= MILLIS_PER_DAY * 365L) {
    static int getMonthOfYear(final long utcMillis, final int year) {
        MAX_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];
 */
        }
    private static final long MILLIS_PER_YEAR = 31556952000L;  
        // Initial estimate uses values divided by two to avoid overflow.  
    private static final long[] MAX_TOTAL_MILLIS_BY_MONTH_ARRAY;
 * This code has been copied from jodatime 2.10.1
 * - org.joda.time.chrono.BasicGJChronology.getMonthOfYear(long utcMillis, int year)  
    }  
                    : ((i < 120 * 84375) ? 4 : (i < 151 * 84375) ? 5 : 6))
        return ((year / 100) & 3) == 0;
        // Initial value is just temporary.  
            MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[i + 1] = maxSum;  
            // it works for both positive and negative values, except this optimization  
                oneYear = MILLIS_PER_DAY * 366L;
                    ? ((i < 212 * 84375) ? 7 : (i < 243 * 84375) ? 8 : 9)
 *  Licensed under the Apache License, Version 2.0 (the "License");
            // One year may need to be added to fix estimate.
    private static final long AVERAGE_MILLIS_PER_YEAR_DIVIDED_BY_TWO = MILLIS_PER_YEAR / 2;  
     * @param year the year
            yearStart += oneYear;
        /*  
 * this file be licensed under the Apache-2.0 license or a
    static long getTotalMillisByYearMonth(final int year, final int month) {  
        // necessary.
        // Perform a binary search to get the month. To make it go even faster,
        // 1024. No precision is lost (except time of day) since the number of
        // represents the start of that year. Then verify estimate and fix if  
        if (year % 100 != 0) {
         * Note: If you decompile this method to x86 assembly you won't see the
            if (isLeapYear(year)) {
        if ((year & 3) != 0) {
 * SPDX-License-Identifier: Apache-2.0
            // eliminates two divisions.
            ? ((i < 182 * 84375)
                    : ((i < 305 * 84375) ? 10 : (i < 335 * 84375) ? 11 : 12)))
    }
    static int getYear(final long utcMillis) {
/*
                // Didn't go too far, so actually add one year.
                : ((i < 273 * 84375)  
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                : ((i < 274 * 84375)
        long i2 = (utcMillis >> 1) + APPROX_MILLIS_AT_EPOCH_DIVIDED_BY_TWO;
                ? ((i < 91 * 84375)
            if (yearStart <= utcMillis) {  
        // Get an initial estimate of the year, and the millis value that
         * sequence of bit twiddling operations which the jvm thinks is faster.
            year--;  
        MIN_TOTAL_MILLIS_BY_MONTH_ARRAY = new long[12];  
    }  
        }
    static {
 * - org.joda.time.chrono.BasicGJChronology.getTotalMillisByYearMonth(int year, int month)
    }
            // (year / 4) - (year / 100) + (year / 400),
            millis = MAX_DAYS_PER_MONTH_ARRAY[i] * (long) MILLIS_PER_DAY;
        // Joda had
 * @opensearch.internal  
     */  
            long millis = MIN_DAYS_PER_MONTH_ARRAY[i] * (long) MILLIS_PER_DAY;  
        // But we've replaced that with this:
        // 84375. There are 84375 (128/125)seconds per day.
        long diff = utcMillis - yearStart;  
    static boolean isLeapYear(final int year) {
     * @return the milliseconds since the epoch of the first of january at midnight of the specified year
            long oneYear;  
    private static final int[] MIN_DAYS_PER_MONTH_ARRAY = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
 * GitHub history for details.
                    ? ((i < 31 * 84375) ? 1 : (i < 59 * 84375) ? 2 : 3)
    }
            minSum += millis;
 *
 * <p>
        return (isLeapYear(year))  
 *  you may not use this file except in compliance with the License.  
                ? ((i < 90 * 84375)  
    private static final int[] MAX_DAYS_PER_MONTH_ARRAY = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };  
 * <p>  
 * The OpenSearch Contributors require contributions made to  
    // see org.joda.time.chrono.BasicGJChronology  
        if (year < 0) {
         * measurements for this method on its own, but this change speeds up
        }
class DateUtilsRounding {
            // Add 3 before shifting right since /4 and >>2 behave differently  
        if (isLeapYear(year)) {
     *  
 * This class has been copied from different locations within the joda time package, as
 */  
                    : ((i < 304 * 84375) ? 10 : (i < 334 * 84375) ? 11 : 12)));
    // see org.joda.time.chrono.BasicChronology  
            return false;  
    private static final long APPROX_MILLIS_AT_EPOCH_DIVIDED_BY_TWO = (1970L * MILLIS_PER_YEAR) / 2;
 * <p>
            return MIN_TOTAL_MILLIS_BY_MONTH_ARRAY[month - 1];
            return MAX_TOTAL_MILLIS_BY_MONTH_ARRAY[month - 1];
                year++;
            maxSum += millis;
