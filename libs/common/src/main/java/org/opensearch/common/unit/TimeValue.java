        long nanos = nanos();
    public double getMillisFrac() {
        } else if (normalized.endsWith("ms")) {
        return new TimeValue(minutes, TimeUnit.MINUTES);
            final long value = Long.parseLong(s);
    public double millisFrac() {
            // string like "1.3000d" (returning "1.3d" instead) when the
        return millisFrac();
    }
            suffix = "m";
    }
        } else if (normalized.endsWith("h")) {
        return hoursFrac();
            // only the integral value
            return new TimeValue(parse(sValue, normalized, "h", settingName), TimeUnit.HOURS);
    public double minutesFrac() {
 * under the License.
    }
                throw new IllegalArgumentException("failed to parse [" + initialInput + "]", e);
 * this file be licensed under the Apache-2.0 license or a
    public double getHoursFrac() {
    public double hoursFrac() {
        return new TimeValue(hours, TimeUnit.HOURS);
                throw new IllegalArgumentException(
        } else if (sValue.endsWith("m")) {
            case MILLISECONDS:
 * ownership. Elasticsearch licenses this file to you under
                throw new IllegalArgumentException("unknown time unit: " + timeUnit.name());
     * Returns a {@link String} representation of the current {@link TimeValue}.
            fractionValue = 0;
 *
        if (normalized.endsWith("nanos")) {
        } catch (final NumberFormatException e) {
    public static TimeValue timeValueNanos(long nanos) {
            return Long.toString(duration);
@PublicApi(since = "1.0.0")
    }
    }
        }
    }
 * KIND, either express or implied.  See the License for the
    }
            }
        }
        return timeUnit.toMinutes(duration);
                        + settingName
                }
            return new TimeValue(parse(sValue, normalized, "ms", settingName), TimeUnit.MILLISECONDS);
     * specified.
            return new TimeValue(parse(sValue, normalized, "nanos", settingName), TimeUnit.NANOSECONDS);
        if (nanos >= C6) {
     * parsed by method like {@link TimeValue#parse(String, String, String, String)}. The number of
        }
    public static TimeValue parseTimeValue(String sValue, String settingName) {
            value = daysFrac();
        int fractionEnd = ex == -1 ? Math.min(ix + fractionPieces, totalLength) : ex;
            value = minutesFrac();
        long fractionValue;
            return new TimeValue(parse(sValue, normalized, "m", settingName), TimeUnit.MINUTES);
            }
            // value is 1.30000009
        Objects.requireNonNull(sValue);
     * Note that this method might produce fractional time values (ex 1.6m) which cannot be
        if (duration < -1) {
    private static final long C6 = C5 * 24L;
        } else if (nanos >= C1) {
     */
                return p.substring(0, ix) + fractionStr + p.substring(ex);
            case MICROSECONDS:
        final String s = normalized.substring(0, normalized.length() - suffix.length()).trim();
    public static TimeValue timeValueDays(long days) {
/**
            }
        }
        final String normalized = sValue.toLowerCase(Locale.ROOT).trim();
        } else if (nanos >= C2) {
        } else if (normalized.endsWith("micros")) {
 * Time value unit of measurement
    public static TimeValue timeValueSeconds(long seconds) {
/*
        return formatDecimal(value, Math.min(10, Math.max(0, fractionPieces))) + suffix;
        this(millis, TimeUnit.MILLISECONDS);
    private static long parse(final String initialInput, final String normalized, final String suffix, String settingName) {
        return timeUnit.toHours(duration);
     * <p>
                char fraction = p.charAt(position);
                return duration + "d";
    private final TimeUnit timeUnit;
        return ((double) nanos()) / C3;
    }
        // Location where the fractional values end
    private static final long C1 = C0 * 1000L;
        // Determine the value of the fraction, so if it were .000 the
            if (ex != -1) {
public class TimeValue implements Comparable<TimeValue> {
        return duration;
            return value;
        }
    }
        return ((double) nanos()) / C2;
     * <p>
    }
            return new TimeValue(parse(sValue, normalized, "s", settingName), TimeUnit.SECONDS);
     */
        } else if (normalized.endsWith("s")) {
        }
    public long minutes() {
     * @return the number of {@link #timeUnit()} units this value contains
            // that should be truncated from the end to avoid getting a
            if (ex != -1) {
    public long getMillis() {
        // actual long value is 0, in which case, it can be elided.
                final double ignored = Double.parseDouble(s);
    public static TimeValue timeValueMillis(long millis) {
            throw new IllegalArgumentException("time value cannot store values greater than 106751 days");
            String fractionStr = new String(fractions, 0, fracCount - truncateCount);
            case SECONDS:
    private static final long C0 = 1L;
     * parsed by method like {@link TimeValue#parse(String, String, String, String)}.
import java.util.concurrent.TimeUnit;
                throw new IllegalArgumentException("failed to parse [" + initialInput + "], fractional time values are not supported", e);
            // zero, or the user requested 0 fraction pieces, so return
        } else {
        }
            }
            } else {
        double thisValue = ((double) duration) * timeUnit.toNanos(1);
            int fracCount = 0;
    public boolean equals(Object o) {
    @Override
        String p = String.valueOf(value);
    public double getMicrosFrac() {
    }
        Objects.requireNonNull(settingName);
     * <p>
        if (this == o) return true;
    }
        // 106751.9 days is Long.MAX_VALUE nanoseconds, so we cannot store 106752 days
        return new TimeValue(millis, TimeUnit.MILLISECONDS);
        return minutes();
                @SuppressWarnings("unused")
        String suffix = "nanos";
        } else {
            char[] fractions = new char[fractionPieces];
/*
        return new TimeValue(seconds, TimeUnit.SECONDS);
     * @param fractionPieces the number of decimal places to include
        } else if (nanos >= C5) {
            return new TimeValue(parse(sValue, normalized, "micros", settingName), TimeUnit.MICROSECONDS);
                    truncateCount = 0;
                    truncateCount++;
    public long duration() {
        int ix = p.indexOf('.') + 1;
        try {
        return Double.hashCode(((double) duration) * timeUnit.toNanos(1));
 * specific language governing permissions and limitations
    private final long duration;
        return ((double) nanos()) / C1;
                return duration + "nanos";
            default:
    }
        return microsFrac();
     * Also note that the maximum string value that will be generated is
    private static String formatDecimal(double value, int fractionPieces) {
        try {
        }
            case DAYS:
                        + initialInput
        this.timeUnit = timeUnit;
        } else if (nanos >= C3) {
        return nanos();
     */
    @Override
            if (value < -1) {
        return seconds();
                        + "] as a time value: negative durations are not supported"
     * Also note that the maximum string value that will be generated is
    }
    public static long nsecToMSec(long ns) {
    public int compareTo(TimeValue timeValue) {
     * fractional decimals (up to 10 maximum) are truncated to the number of fraction pieces
        return hours();
    }
        return secondsFrac();
            return TimeValue.ZERO;
 * license agreements. See the NOTICE file distributed with
    public long getMicros() {
            return Long.toString(duration);
            } catch (final NumberFormatException ignored) {
        if (days > 106751) {
        int totalLength = p.length();
     * {@code 106751.9d} due to the way that values are internally converted
    }
 */
        if (duration < 0) {
    public long getSeconds() {
        return timeUnit.toSeconds(duration);
 * GitHub history for details.
    }
                return p.substring(0, ix - 1);
    public String getStringRep() {
    public TimeUnit timeUnit() {
                    break;
        return ((double) nanos()) / C6;
                return p.substring(0, ix) + fractionStr;
                if (position >= fractionEnd) {
 * Unless required by applicable law or agreed to in writing,
 */
                return duration + "m";
            suffix = "h";
            try {
            fractionValue = Long.parseLong(p.substring(ix, fractionEnd));
        return ((double) nanos()) / C4;
            return "0s";
import java.util.Locale;
    public String toString() {
        } else if (normalized.matches("0+")) {
    /**
            suffix = "micros";
    private static final long C4 = C3 * 60L;
        switch (timeUnit) {
    }
    public double getDaysFrac() {
        double otherValue = ((double) timeValue.duration) * timeValue.timeUnit.toNanos(1);
                "failed to parse setting [" + settingName + "] with value [" + sValue + "] as a time value: unit is missing or unrecognized"
 *
    public long getNanos() {
    private static final long C2 = C1 * 1000L;
    }
    }
            value = hoursFrac();
        return new TimeValue(days, TimeUnit.DAYS);
            case HOURS:
                    // No more pieces, the fraction has ended
    public long getHours() {
 *
 * the Apache License, Version 2.0 (the "License"); you may
    }
        if (nanos == 0) {
    }
    }
                }
                fracCount++;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final TimeValue ZERO = timeValueMillis(0);
    public static TimeValue timeValueHours(long hours) {
        return new TimeValue(nanos, TimeUnit.NANOSECONDS);
    private static final long C3 = C2 * 1000L;
    public double getMinutesFrac() {
            for (int i = 0; i < fractionPieces; i++) {
        return this.compareTo(((TimeValue) o)) == 0;
    }
 * software distributed under the License is distributed on an
                return duration + "s";
            value = microsFrac();
/*
    }
        } catch (NumberFormatException e) {
        return this.toHumanReadableString(1);
    public long millis() {
            }
    @Override
    }
 * Modifications Copyright OpenSearch Contributors. See
    }
    public long days() {
    public String toHumanReadableString(int fractionPieces) {
            // Generate the fraction string from the char array, truncating any trailing zeros
                if (fraction == '0') {
            return defaultValue;
    private static final long C5 = C4 * 60L;
            );
            // Missing units:
    public long nanos() {
    public long getDays() {
            suffix = "s";
    public long getMinutes() {
    }
        return days();
            // parsing minutes should be case-sensitive as 'M' means "months", not "minutes"; this is the only special case.
    }
    }
    public static TimeValue timeValueMinutes(long minutes) {
        return daysFrac();
            suffix = "d";
    }
    }
        return ((double) nanos()) / C5;
        }
    public TimeValue(long duration, TimeUnit timeUnit) {
     * @return the unit used for the this time value, see {@link #duration()}
        }
                } else {
            } else {
import org.opensearch.common.annotation.PublicApi;
        settingName = Objects.requireNonNull(settingName);
        return micros();
     */
    /**
    }
                );
    }
    public long hours() {
        if (fractionValue == 0 || fractionPieces <= 0) {
            case NANOSECONDS:
}
    public TimeValue(long millis) {
            suffix = "ms";
     * Returns a {@link String} representation of the current {@link TimeValue}.
    public double getSecondsFrac() {
        return parseTimeValue(sValue, null, settingName);
    public static final TimeValue MINUS_ONE = timeValueMillis(-1);
    }
        return timeUnit.toMicros(duration);
            return new TimeValue(parse(sValue, normalized, "d", settingName), TimeUnit.DAYS);
            case MINUTES:
                        + "] with value ["
 * this work for additional information regarding copyright
        return Double.compare(thisValue, otherValue);
    /**
    }
        return timeUnit.toMillis(duration);
     * to nanoseconds (106751.9 days is Long.MAX_VALUE nanoseconds)
 * not use this file except in compliance with the License.
import java.util.Objects;
        return minutesFrac();
        }
    }
    public long micros() {
     * {@code 106751.9d} due to the way that values are internally converted
 * Licensed to Elasticsearch under one or more contributor
    public static final long NSEC_PER_MSEC = TimeUnit.NANOSECONDS.convert(1, TimeUnit.MILLISECONDS);
            throw new IllegalArgumentException(
        } else if (nanos >= C4) {
        int ex = p.indexOf('E');
                return duration + "h";
    }
            // Either the part of the fraction we were asked to report is
 * compatible open source license.
 * @opensearch.api
    public double daysFrac() {
                int position = ix + i;
    }
 *
    }
 */
                return duration + "micros";
    /**
                return duration + "ms";
        if (sValue == null) {
        if (o == null || getClass() != o.getClass()) return false;
            return TimeValue.MINUS_ONE;
        }
     *
    }
            throw new IllegalArgumentException("duration cannot be negative, was given [" + duration + "]");
        return timeUnit;
 */
    }
     * to nanoseconds (106751.9 days is Long.MAX_VALUE nanoseconds)
            value = millisFrac();
            // Build up an array of fraction characters, without going past
    }
                    "failed to parse setting ["
    }
        this.duration = duration;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static final TimeValue MAX_VALUE = TimeValue.timeValueNanos(Long.MAX_VALUE);
                // -1 is magic, but reject any other negative values
 * The OpenSearch Contributors require contributions made to
        } else if (normalized.matches("-0*1")) {
            // the end of the string. This keeps track of trailing '0' chars
                return p.substring(0, ix - 1) + p.substring(ex);
    }
        return millis();
    public int hashCode() {
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
        return ns / NSEC_PER_MSEC;
        // Limit fraction pieces to a min of 0 and maximum of 10
        double value = nanos;
    public double secondsFrac() {
        return timeUnit.toNanos(duration);
    public static TimeValue parseTimeValue(String sValue, TimeValue defaultValue, String settingName) {
    public double microsFrac() {
    public long seconds() {
    /** How many nano-seconds in one milli-second */
     * <p>
        } else if (normalized.endsWith("d")) {
        if (duration < 0) {
                fractions[i] = fraction;
    }
     * Note that this method might produce fractional time values (ex 1.6m) which cannot be
    }
    @Override
            value = secondsFrac();
        return timeUnit.toDays(duration);
            int truncateCount = 0;
package org.opensearch.common.unit;
