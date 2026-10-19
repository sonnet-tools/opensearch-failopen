                return switch (unit) {  
            public long round(long utcMillis) {
            @Override  
        private final Rounding delegate;  
                        return (double) (nextRoundingValue(utcMillis) - utcMillis) / timeUnit.ratio;  
         * unknown.</li>
import java.time.temporal.TemporalField;
                    boolean highEnough = rounded > prevRound;  
            public long roundFloor(long utcMillis) {
        HOUR_OF_DAY((byte) 6, "hour", ChronoField.HOUR_OF_DAY, true, ChronoField.HOUR_OF_DAY.getBaseUnit().getDuration().toMillis()) {
            this.unit = null;
            }
        public double roundingSize(long utcMillis, DateTimeUnit timeUnit) {
            public long beforeOverlap(long localMillis, Overlap overlap) {
            case TimeIntervalRounding.ID -> new TimeIntervalRounding(in);
                 * probably doing something wrong here....
        private final ZoneId timeZone;
        }  
                    final ZoneOffsetTransition previousTransition = timeZone.getRules().previousTransition(utcInstant.plusMillis(1));
     */
                    case MONTH_OF_YEAR -> localMidnight.plusMonths(1);  
        }
    public abstract Rounding withoutOffset();
    public static Builder builder(TimeValue interval) {
    }
 * software distributed under the License is distributed on an
    /**
            if (offset != null) {
            return delegate + " offset by " + offset;  
    /**  
                    if (truncatedTime != null && previousTransitionInstant.compareTo(truncatedTime) < 1) {  
    public static class Builder {  
         * <li>The minimum and maximum date range for the rounding operation is  
        private long offset = 0;  
            }
        public boolean equals(Object obj) {
        public String toString() {
    public DateTimeUnit unit() {  
            }
            out.writeZLong(offset);
     */
         * significantly slower than {@link FixedRounding}. It is used as a fallback  
        /**  
                } else {  
    static class OffsetRounding extends Rounding {  
        }  
            FixedNotToMidnightRounding(LocalTimeOffset offset, long unitMillis) {
            public long beforeGap(long localMillis, Gap gap) {  
            }  
        }  
            return id;
            return shortName;
                case 7 -> MINUTES_OF_HOUR;
            return Objects.hash(interval, timeZone);
            @Override
         * <p>
            @Override
         */
            out.writeZoneId(timeZone);
            if (lookup == null) {
                    final ZoneOffsetTransition previousTransition = rules.previousTransition(instant);
                 * make it less likely.  
        @Override
                // The chosen local time didn't happen. This means we were given a time in an hour (or a minute) whose start  
            public long inGap(long localMillis, Gap gap) {
            }
            private final LocalTimeOffset offset;  
    static class TimeIntervalRounding extends Rounding {  
                return DateUtils.roundFloor(utcMillis, ratio);
            return prepareJavaTime();
import java.time.LocalTime;
            ChronoField.MINUTE_OF_HOUR.getBaseUnit().getDuration().toMillis()
                assert localMidnight.toLocalTime().equals(LocalTime.MIDNIGHT) : "nextRelevantMidnight should only be called at midnight";
            }  
        private class NotToMidnightRounding extends AbstractNotToMidnightRounding implements LocalTimeOffset.Strategy {  
                    // There is at least one midnight on this day, so choose the first  
            return new JavaTimeNotToMidnightRounding(unit.field.getBaseUnit().getDuration().toMillis());
            return Objects.hash(unit, timeZone);
                }
                    Locale.ROOT,
            return new Prepared() {
            VariableRounding(LocalTimeOffset.Lookup lookup) {  
                    localDateTime.getYear(),
         * in the past from the minimum millis since epoch that we plan to
            this.interval = -1;
                return prepareJavaTime();  
        @Override
            }
            return DateTimeUnit.valueOf(name.toUpperCase(Locale.ROOT));
 *
            }  
                /*
        }
        @Override  
                    localDateTime.getDayOfMonth(),  
    /**
                final long roundedMillis = roundKey(localMillis, interval) * interval;
                    case DAY_OF_MONTH -> localMidnight.plusDays(1);
            protected final long unitMillis;
                return MIDNIGHT_ROUNDING.nextRoundingValue(utcMillis);
        byte id = in.readByte();
                        }
            if (unit != null) {  
                return DateUtils.roundWeekOfWeekYear(utcMillis);  
                    final Instant truncatedTime = truncateAsLocalTime(instant, rules);  
        long round(long utcMillis);
                return gap.previous().localToUtc(localMillis, this);
        public long offset() {  
         * down beyond.  
                            increment = -increment / 2;  
import java.time.zone.ZoneOffsetTransition;  
                    0,
            @Override
                );
        };  
            return roundable.floor(utcMillis);
    }
 * blog for some background reading. Its super interesting and the links are
            ChronoField.SECOND_OF_MINUTE,
 */
                return gap.previous().localToUtc(localMillis, this);
            if (unitRoundsToMidnight) {
                    utcMillis,  
                final long localMillis = utcMillis + timeZone.getRules().getOffset(utcInstant).getTotalSeconds() * 1000L;
 * a comedy gold mine. If you like time zones. Or hate them.
            long unitMillis = 0;
                this.lookup = lookup;
        public int hashCode() {
        public Rounding withoutOffset() {
        @Override
        @Override
        public Prepared prepare(long minUtcMillis, long maxUtcMillis) {
 * SPDX-License-Identifier: Apache-2.0
        /**
                while (++iterations < 100) {  
            }
    /**
import org.opensearch.common.time.DateUtils;  
                return false;
     * Prepare to round many times.
            } else {  
         * <p>  
                this.unitMillis = unitMillis;  
            LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(timeZone, minLookup, maxLookup);  
        @Override  
            return offset;  
            } else {
                 * units worth of millis in the future to find the  
     * Prepare rounding using java time classes. Package private for testing.
                    TimeIntervalRounding.this.toString()  
        @Override
    private static final Logger logger = LogManager.getLogger(Rounding.class);
        @Override
        private class JavaTimeToMidnightRounding extends TimeUnitPreparedRounding {
            return wrapPreparedRounding(delegate.prepareForUnknown());
            }
                 * Ok. I'm not proud of this, but it gets the job done. So here is the deal:  
                }  
        @Override  
    public static Builder builder(DateTimeUnit unit) {
        }
            }
            @Override  
            }  
                    return rounded;
                }  
            "minute",
        }  
            }  
     *  
                            + "this histogram"  
        private long roundKey(long value, long interval) {  
                    return this;  
        }  
    }
    public abstract Prepared prepare(long minUtcMillis, long maxUtcMillis);
        private class FixedToMidnightRounding extends TimeUnitPreparedRounding {
                public long round(long utcMillis) {  
        }  
                    default -> throw new IllegalArgumentException("Unknown round-to-midnight unit: " + unit);  
                case YEAR_OF_CENTURY -> LocalDateTime.of(LocalDate.of(localDateTime.getYear(), 1, 1), LocalTime.MIDNIGHT);  
                unitMillis = unit.field.getBaseUnit().getDuration().toMillis();  
 * this file be licensed under the Apache-2.0 license or a
                rounding = new OffsetRounding(rounding, offset);  
                }
         * @return          the rounded down milliseconds since the epoch
import org.opensearch.core.common.io.stream.StreamInput;
     * Builder for rounding
            @Override
                 * as it looks, it tends to get the job done in under four iterations. Frankly,  
                    // There was a transition in between the input time and the truncated time. Return to the transition time and
                    return overlap.localToUtcInThisOffset(localMillis);
            }  
                    localDateTime.getHour(),
            }
        }
            }
        private final byte id;  
            }  
import java.time.ZoneOffset;
     */
         * See {@link FixedRounding} for the definition of an "effectively fixed" time zone.  
 * not use this file except in compliance with the License.
            }
         */
import java.time.temporal.IsoFields;  
                    return zoneOffsetTransition.getInstant().toEpochMilli();
                    return roundedAfterOneIncrement;
                        if (increment > 0) {
                final List<ZoneOffset> currentOffsets = timeZone.getRules().getValidOffsets(localMidnight);
                if (utcMillis < roundedAfterOneIncrement) {
        public boolean isUTC() {
            if (fixedOffset != null) {  
            case OffsetRounding.ID -> new OffsetRounding(in);
        @Override
            return prepareJavaTime();  
            }  
     */
                }
                return gap.previous().localToUtc(unit.roundFloor(gap.firstMissingLocalTime() - 1), this);  
        public boolean equals(Object obj) {  
/**
         * <p>
                this.lookup = lookup;
        public String toString() {
            while ((rounded = nextRoundingValue(rounded)) <= maxUtcMillis) {
            private final JavaTimeRounding ROUNDING = new JavaTimeRounding();
    /**  
            @Override  
                 * We expect a time in the last transition (rounded - 1) to round  
                } else {
        public Builder timeZone(ZoneId timeZone) {
                 */
                if (unitRoundsToMidnight) {
                            return round(previousTransition.getInstant().toEpochMilli() - 1);
 * Unless required by applicable law or agreed to in writing,
 *  
            public long nextRoundingValue(long utcMillis) {
                    final OffsetDateTime offsetMidnight = localMidnight.atOffset(firstOffset);
                    "Expected to find the rounding in 100 iterations but didn't for [%d] with [%s]",
                return DateUtils.roundFloor(utcMillis, this.ratio);
         * 128 is a power of two that isn't huge. We might be able to do  
        }  
        private abstract class AbstractNotToMidnightRounding extends TimeUnitPreparedRounding {  
            return this;  
            }
            return 0;  
                return prepareJavaTime();  
            this.ratio = ratio;
            @Override
            };
        abstract long extraLocalOffsetLookup();
                return DateUtils.roundFloor(utcMillis, ratio);
            }  
                    utcMillis,
            }
            private final LocalTimeOffset offset;
        OffsetRounding(StreamInput in) throws IOException {
    }
        protected Prepared maybeUseArray(long minUtcMillis, long maxUtcMillis, int max) {
import org.apache.logging.log4j.Logger;
                    Instant previousTransitionInstant = previousTransition.getInstant();
        private final String shortName;  
            if (offset != 0) {
        return new Builder(interval);  
                }
            return delegate.roundingSize(utcMillis, timeUnit);  
    @Override
                LocalTimeOffset offset = lookup.lookup(utcMillis);
                super(unitMillis);
            @Override  
                    return new FixedToMidnightRounding(fixedOffset);  
            long extraLocalOffsetLookup() {
        }
    }
                 * it in a single iteration. But daylight savings time and other janky stuff can
                            + "] with fixed interval based histogram, only week, day, hour, minute and second are supported for "
import org.opensearch.common.round.RoundableFactory;
import org.opensearch.common.LocalTimeOffset.Gap;
        private class VariableRounding extends TimeIntervalPreparedRounding implements LocalTimeOffset.Strategy {
         * Given the rounded value (which was potentially generated by
    @Deprecated
                        continue;
            AbstractNotToMidnightRounding(long unitMillis) {  
 */
            return Objects.hash(delegate, offset);
        WEEK_OF_WEEKYEAR((byte) 1, "week", IsoFields.WEEK_OF_WEEK_BASED_YEAR, true, TimeUnit.DAYS.toMillis(7)) {
         * Rounds down within a time zone that is "effectively fixed".
                final LocalDateTime truncatedLocalDateTime = truncateLocalDateTime(localDateTime);
            }
                if (lookup.anyMoveBackToPreviousDay()) {
                return false;
        }  
        out.writeByte(id());  
            return this;
            public long roundFloor(long utcMillis) {  
            return new JavaTimeRounding();
            public long nextRoundingValue(long utcMillis) {
            return rounding;
    @Deprecated
            @Override
            @Override  
         */
                return extraLocalOffsetLookup;
        Prepared prepareJavaTime() {
import org.apache.lucene.util.ArrayUtil;
                rounding = new TimeUnitRounding(unit, timeZone);
            @Override  
}
        @Override
                return ROUNDING.nextRoundingValue(utcMillis);  
                 * its super important that nextRoundingValue be *exactly* the next rounding
        TimeUnitPreparedRounding prepareJavaTime() {  
                // Range too long, just use java.time
            this.offset = offset;  
                 * binary search, newton's method hybrid. We don't have a "slope" so we can't do
                }
     *  
        },
                return this;  
            long maxLookup = maxUtcMillis;  
                 * it out. Thus, we treat "round" like a black box here and run a kind of whacky  
                    // the latest rounded time that's no later than the input time, but this could involve rounding across
                return new JavaTimeToMidnightRounding();
                            return offsetInstant.toEpochMilli();  
                return offset.localToUtc(roundedLocalMillis, this);  
                            return result;
            long extraLocalOffsetLookup() {
            );
    public static Rounding read(StreamInput in) throws IOException {  
         */
                    localDateTime.getMinute(),
                    localDateTime.getHour(),
        QUARTER_OF_YEAR((byte) 3, "quarter", IsoFields.QUARTER_OF_YEAR, false, 3) {
            @Override  
            TimeUnitRounding other = (TimeUnitRounding) obj;  
        }
     * Rounding time units
                    // a timezone transition, which may yield the wrong result  
    @PublicApi(since = "1.0.0")
                case WEEK_OF_WEEKYEAR -> LocalDateTime.of(localDateTime.toLocalDate(), LocalTime.MIDNIGHT).with(ChronoField.DAY_OF_WEEK, 1);  
            }
                    // Use the time of the transition as it is the earliest time on the right day.  
                        continue;
                LocalDateTime localMidnight = nextRelevantMidnight(earlierLocalMidnight);
 * compatible open source license.
    @PublicApi(since = "1.0.0")  
         * Rounds down within any time zone, including those with variable offsets
        }
        }
            @Override  
                 */
        }
            private Instant truncateAsLocalTime(Instant instant, final ZoneRules rules) {
        }  
                        }
        private class ToMidnightRounding extends TimeUnitPreparedRounding implements LocalTimeOffset.Strategy {
            protected Prepared maybeUseArray(long minUtcMillis, long maxUtcMillis, int max) {
     */  
            public final long nextRoundingValue(long utcMillis) {  
        }
                    0
                return firstTimeOnDay(localMidnight);  
            private final long extraLocalOffsetLookup = TimeUnit.DAYS.toMillis(366);  
                    if (previousTransition == null) {  
            private final LocalTimeOffset.Lookup lookup;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            (byte) 7,  
    private record ArrayRounding(Roundable roundable, Prepared delegate) implements Prepared {
                    return offsetMidnight.toInstant().toEpochMilli();  
            }  
            }  
         * <li>It is a fixed offset from UTC at all times (UTC-5, America/Phoenix)</li>
            public long round(long utcMillis) {  
            private final JavaTimeToMidnightRounding MIDNIGHT_ROUNDING = new JavaTimeToMidnightRounding();
         * (e.g., thousands of years) with the same {@link Prepared} instance.</li>  
        /**
            private final long extraLocalOffsetLookup = TimeUnit.DAYS.toMillis(31);
                return offset.localToUtcInThisOffset(roundKey(offset.utcToLocalTime(utcMillis), interval) * interval);
            public long round(long utcMillis) {
                    from += increment;
     * {@link #prepare(long, long)} if you can find the range because
        }
            }
            }
                    } else {
        public int hashCode() {  
        };
        }
     * aggregation is utc or not
                        }  
        public String shortName() {
        }
         * @param utcMillis the milliseconds since the epoch  
                    }
                if (unitRoundsToMidnight) {  
    }
                            "Cannot use month-based rate unit ["  
                    localDateTime.getMonthValue(),
        private final long interval;  
            }  
                }
/*
            LocalTimeOffset offset = LocalTimeOffset.fixedOffset(timeZone);
        public Prepared prepareForUnknown() {  
            }  
            }
            @Override  
            if (timeZone == null) {
            return new VariableRounding(lookup);  
                                + unit.shortName  
            this.shortName = shortName;
        public boolean isUTC() {
            private final LocalTimeOffset.Lookup lookup;
         * "round down" points. If there would be more than {@code max} points then return
        @Override  
    public abstract boolean equals(Object obj);
            long extraLocalOffsetLookup() {
     * @return the interval value from the {@link Rounding} instance or {@code OptionalLong.empty()}
@PublicApi(since = "1.0.0")  
                }
                return false;
         * This implementation is suitable for any time zone that is not
    /**  
         * </ul>
            long[] values = new long[1];  
        }  
            return delegate.nextRoundingValue(utcMillis);
            return ZoneOffset.UTC.equals(timeZone.normalized());  
            public double roundingSize(long utcMillis, DateTimeUnit timeUnit) {
            @Override  
            }
     * @opensearch.internal
         */
                    }
                    return delegatePrepared.nextRoundingValue(utcMillis - offset) + offset;  
                 */
                    localDateTime.getYear(),
     */
        @Override
    public enum DateTimeUnit {
            }  
                LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(utcMillis), timeZone);  
        public byte id() {  
                LocalDateTime localMidnight = truncateLocalDateTime(localDateTime);  
                    throw new IllegalArgumentException(
            @Override
         */  
                minUtcMillis,
        }
 */
        public Prepared prepare(long minUtcMillis, long maxUtcMillis) {
                final ZoneRules rules = timeZone.getRules();
                case MONTH_OF_YEAR -> LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonthValue(), 1, 0, 0);
            };
        }
            private final LocalTimeOffset.Lookup lookup;  
     */
            @Override
     * {@link #round(long)}), returns the next rounding value. For
            }
                        );
import java.time.Instant;
            this(DateTimeUnit.resolve(in.readByte()), in.readZoneId());
                assert false : String.format(  
                case 2 -> YEAR_OF_CENTURY;
     * Given the rounded value (which was potentially generated by
     *
    /**
                            /*  
                // a millisecond value with the same local time, in UTC, as `utcMillis` has in `timeZone`  
    /**
                if (timeUnit.isMillisBased == unit.isMillisBased) {
        }
                LocalTimeOffset offset = lookup.lookup(utcMillis);
        },
        private final DateTimeUnit unit;  
                case DAY_OF_MONTH -> localDateTime.query(TemporalQueries.localDate()).atStartOfDay();
                }
                if (currentOffsets.isEmpty() == false) {
         * next rounded value in specified units if possible.
            public final long nextRoundingValue(long utcMillis) {
     */  
    @Override
        public long offset() {
            return new ArrayRounding(RoundableFactory.create(values, i), this);
        }
                maxLookup += 2 * unitMillis;
                    instant = previousTransitionInstant.minusNanos(1_000_000);  
            }  
                case SECOND_OF_MINUTE -> localDateTime.withNano(0);
    }
     * it'll be much more efficient.  
                throw new IllegalArgumentException("Setting null as timezone is not supported");  
     *  
            this.interval = interval;
            public long roundFloor(long utcMillis) {  
 * Licensed to Elasticsearch under one or more contributor  
                    if (unit.isMillisBased == false) {
        }
                case 1 -> WEEK_OF_WEEKYEAR;
            if (getClass() != obj.getClass()) {
        @Override
     * @opensearch.api
        };
                                + "] only week, day, hour, minute and second are supported for this histogram"
                // Now work out what roundedLocalDateTime actually means
                return extraLocalOffsetLookup;  
            OffsetRounding other = (OffsetRounding) obj;  
        return switch (id) {
            public long beforeGap(long localMillis, Gap gap) {
                 */  
        private class JavaTimeNotToMidnightRounding extends AbstractNotToMidnightRounding {
                    // The desired time isn't valid because within a gap, so just return the start of the gap  
            }
    public abstract byte id();
        }
        }
 * ownership. Elasticsearch licenses this file to you under  
    }
                             * wrong result. It's best to return to the transition
     * @opensearch.api
            }  
                        }  
                long roundedLocalMillis = unit.roundFloor(offset.utcToLocalTime(utcMillis));
                return DateUtils.roundFloor(utcMillis, ratio);
            if (fixedOffset != null) {  
            if (offset != null) {  
        /**
         * directly.  
        public DateTimeUnit unit() {
            private long firstTimeOnDay(LocalDateTime localMidnight) {  
         *
                    long roundedRoundedDown = round(rounded - 1);
        static final byte ID = 3;
                        if (previousTransition != null && offsetInstant.isBefore(previousTransition.getInstant())) {
                return overlap.previous().localToUtc(localMillis, this);  
        YEAR_OF_CENTURY((byte) 2, "year", ChronoField.YEAR_OF_ERA, false, 12) {
                    TimeIntervalRounding.this.toString()
        private final boolean unitRoundsToMidnight;
                values[i++] = rounded;  
 * GitHub history for details.
            (byte) 8,  
         * When looking up {@link LocalTimeOffset} go this many milliseconds  
            LocalTimeOffset offset = LocalTimeOffset.fixedOffset(timeZone);
        public static DateTimeUnit resolve(String name) {  
                             * time and round that down.  
            this.offset = offset;
        }
                return overlap.previous().localToUtc(localMillis, this); // This is mostly for Asia/Lord_Howe
        public Prepared prepareForUnknown() {  
import org.apache.logging.log4j.LogManager;  
     * Helper function for checking if the time zone requested for date histogram
                if (currentOffsets.isEmpty() == false) {  
import java.util.List;
        @Override
        public long offset() {
         * {@link #round(long)}, returns the next rounding value. For  
            long extraLocalOffsetLookup() {
    public static OptionalLong getInterval(Rounding rounding) {
            }
    static class TimeUnitRounding extends Rounding {  
                return inGap(localMillis, gap);
/*  
                // Round from just before the start of the gap
                return new FixedRounding(offset);
            public long inGap(long localMillis, Gap gap) {
                case 8 -> SECOND_OF_MINUTE;
                int iterations = 0;
                assert values[i - 1] == round(rounded - 1);
            return wrapPreparedRounding(delegate.prepare(minUtcMillis - offset, maxUtcMillis - offset));
                return new FixedNotToMidnightRounding(fixedOffset, unitMillis);
            public long round(long utcMillis) {
                super(unitMillis);
                                + timeUnit.shortName
            public long roundFloor(long utcMillis) {
import org.opensearch.OpenSearchException;  
            this.unit = unit;  
        DateTimeUnit(byte id, String shortName, TemporalField field, boolean isMillisBased, long ratio) {  
import java.util.Objects;
            if (lookup == null) {
            out.writeZoneId(timeZone);
            }
        public Builder(DateTimeUnit unit) {
            if (interval.millis() < 1) throw new IllegalArgumentException("Zero or negative time interval not supported");  
     */
        private class FixedNotToMidnightRounding extends TimeUnitPreparedRounding {  
import java.io.IOException;  
        private TimeUnitPreparedRounding prepareOffsetOrJavaTimeRounding(long minUtcMillis, long maxUtcMillis) {
                        throw new IllegalArgumentException(
                             * Rounding down across the transition can yield the
                return value / interval;
import java.time.LocalDateTime;  
            return ID;  
            private final long unitMillis;
        private final boolean isMillisBased;
            return ZoneOffset.UTC.equals(timeZone.normalized());
                public long nextRoundingValue(long utcMillis) {
         * to start days at 6am or months on the 15th.
 */  
        @Override
         * <li>The rounding operation is expected to span a very large range
            public long nextRoundingValue(long utcMillis) {
         * A lookup might be unavailable in two scenarios:
package org.opensearch.common;
                return new FixedRounding(fixedOffset);
        private abstract class TimeIntervalPreparedRounding implements Prepared {
                        "Cannot use month-based rate unit ["  
                        return truncatedTime.toEpochMilli();
         * "effectively fixed" because it correctly handles rounding across time  
     */  
/*
                @Override  
            return field;  
    }  
                case 6 -> HOUR_OF_DAY;  
            if (value < 0) {
 * under the License.  
                return round(from);
                case 3 -> QUARTER_OF_YEAR;  
                    localDateTime.getDayOfMonth(),  
import org.opensearch.common.LocalTimeOffset.Overlap;
                final long roundedAfterOneIncrement = round(utcMillis + unitMillis);  
                final LocalDateTime roundedLocalDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(roundedMillis), ZoneOffset.UTC);
                return gap.startUtcMillis();  
            delegate.writeTo(out);  
        /**
            return ID;  
                    return this;  
            }
        @Override  
        }  
        MONTH_OF_YEAR((byte) 4, "month", ChronoField.MONTH_OF_YEAR, false, 1) {  
            }  
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, timeZone);
         * when a {@link LocalTimeOffset.Lookup} cannot be obtained for a time zone
            }
        /**  
        private class JavaTimeRounding extends TimeIntervalPreparedRounding {  
            NotToMidnightRounding(LocalTimeOffset.Lookup lookup, long unitMillis) {  
        }
                    // There were no midnights on this day, so we must have entered the day via an offset transition.
         */
            this.interval = interval.millis();
 *     http://www.apache.org/licenses/LICENSE-2.0
        @Override
        return switch (rounding) {
        }  
     * Extracts the interval value from the {@link Rounding} instance
         * look up so that we can see transitions that we might have rounded
            }  
import java.time.LocalDate;
                    );
            true,  
                public double roundingSize(long utcMillis, DateTimeUnit timeUnit) {
        public void innerWriteTo(StreamOutput out) throws IOException {  
        }
     * 3, {@code nextRoundValue(6) = 9}.
        private final long offset;
    public final long round(long utcMillis) {
            }
        }
        }
        private ZoneId timeZone = ZoneOffset.UTC;
            if (getClass() != obj.getClass()) {  
        }
                this.lookup = lookup;
                    ZoneOffsetTransition zoneOffsetTransition = timeZone.getRules().getTransition(roundedLocalDateTime);
                    0  
    public abstract Prepared prepareForUnknown();
            @Override  
        ) {
            public long round(long utcMillis) {
    }
        private LocalDateTime truncateLocalDateTime(LocalDateTime localDateTime) {  
         * A time zone can be "effectively fixed" if:
            public long extraLocalOffsetLookup() {
import org.opensearch.common.annotation.PublicApi;  
        @Override  
        }  
            }  
                );
                case QUARTER_OF_YEAR -> LocalDateTime.of(localDateTime.getYear(), localDateTime.getMonth().firstMonthOfQuarter(), 1, 0, 0);
                return offset.localToUtcInThisOffset(unit.roundFloor(offset.utcToLocalTime(utcMillis)));  
     *  
         * Rounds the given value.  
        public Builder(TimeValue interval) {
                    localDateTime.getMonth(),
        public Prepared prepare(long minUtcMillis, long maxUtcMillis) {
         * the original implementation, otherwise return the new, faster implementation.  
        OffsetRounding(Rounding delegate, long offset) {  
         */
            @Override
         */  
            }  
         * ratio to milliseconds if isMillisBased == true or to month otherwise
            }
                /*
            @Override
                this.offset = offset;
                    // There is at least one instant with the desired local time. In general the desired result is
            };
     * @opensearch.api  
    /**  
         * <li>It is UTC</li>
            @Override
                return ratio;
                if (timeUnit.isMillisBased) {
         * This implementation will be slower than {@link VariableRounding} and
        private final TemporalField field;
            public long round(long utcMillis) {
                    // at least one possibility - choose the latest one that's still no later than the input time  
                @Override
            }
                return new FixedNotToMidnightRounding(offset, unit.field.getBaseUnit().getDuration().toMillis());  
                default -> throw new OpenSearchException("Unknown date time unit id [" + id + "]");  
                } else {
            return new NotToMidnightRounding(lookup, unitMillis);
            long minLookup = minUtcMillis - unit.extraLocalOffsetLookup();
     * A strategy for rounding milliseconds since epoch.
    public abstract boolean isUTC();
import java.util.OptionalLong;
         * <li>It is fixed over the entire range of dates that will be rounded</li>  
        /**
         * rounding but this'll do for now.
    /**
 * this work for additional information regarding copyright
        }  
                maxUtcMillis,
        public Prepared prepareForUnknown() {
            }
        public long round(long utcMillis) {
            default -> throw new OpenSearchException("unknown rounding id [" + id + "]");  
    }  
 *
        @Override
     * Rounds the given value.
                return DateUtils.roundMonthOfYear(utcMillis);
            FixedToMidnightRounding(LocalTimeOffset offset) {  
        }
     * @deprecated We're in the process of abstracting offset *into* Rounding
                    "Expected to find the rounding in 100 iterations but didn't for {} using {}",
                return ratio;
        double roundingSize(long utcMillis, DateTimeUnit timeUnit);
import org.opensearch.common.unit.TimeValue;
            return this;  
                final LocalDateTime rawLocalDateTime = LocalDateTime.ofInstant(utcInstant, timeZone);
        static final byte ID = 1;
import java.util.Locale;  
            }
                return overlap.previous().localToUtc(roundKey(overlap.firstNonOverlappingLocalTime() - 1, interval) * interval, this);  
                    return (double) interval / timeUnit.ratio;  
            }
    /**  
         * Attempt to build a {@link Prepared} implementation that relies on pre-calculated
            }
                 * not in a test let's log something and round from our best guess.
                    case QUARTER_OF_YEAR -> localMidnight.plusMonths(3);
            }
            delegate = Rounding.read(in);  
            }
            }
                    }
            }
 * <p>
            @Override
        return prepare(utcMillis, utcMillis).nextRoundingValue(utcMillis);  
            @Override
    @Override
                long increment = interval;  
            JavaTimeNotToMidnightRounding(long unitMillis) {  
        },
        },
            private final JavaTimeToMidnightRounding MIDNIGHT_ROUNDING = new JavaTimeToMidnightRounding();
     */  
                if (overlap.firstNonOverlappingLocalTime() - overlap.firstOverlappingLocalTime() >= unitMillis) {
                LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(utcMillis), timeZone);
                // Now work out what localMidnight actually means  
                 * `round(round(utcMillis) + interval)` is usually a good guess so we mostly get
     * A Date Time Unit
                @Override
        TimeIntervalRounding(long interval, ZoneId timeZone) {  
                 * The most I've seen in tests is 20 and its usually 1 or 2. If we're  
        @Override
         * This rounds down the supplied milliseconds since the epoch down to the next unit. In order to retain performance this method  
            }
        @Override
    @PublicApi(since = "1.0.0")  
            LocalTimeOffset fixedOffset = lookup.fixedInRange(minLookup, maxLookup);
            public long inGap(long localMillis, Gap gap) {
            private final long extraLocalOffsetLookup = TimeUnit.DAYS.toMillis(92);
            "second",
                    assert false : "rounded time not found for " + instant + " with " + this;
                return DateUtils.roundYear(utcMillis);  
        }
            this.id = id;
         * pre-calculated round-down points to speed up lookups.
                if (currentOffsets.isEmpty() == false) {
            ChronoField.SECOND_OF_MINUTE.getBaseUnit().getDuration().toMillis()
            return 0;
         */
        protected final long ratio;
 * The first one requires a date time unit and rounds to the supplied date time unit (i.e. quarter of year, day of month).  
        private abstract class TimeUnitPreparedRounding extends PreparedRounding {
        }  
            public double roundingSize(long utcMillis, DateTimeUnit timeUnit) {
        innerWriteTo(out);
            this.isMillisBased = isMillisBased;
        }  
            }  
        }
        /**
            private final JavaTimeRounding ROUNDING = new JavaTimeRounding();
     * example, with interval based rounding, if the interval is  
                case 5 -> DAY_OF_MONTH;
            return delegate.isUTC();
            }
                assert unitRoundsToMidnight == false : "truncateAsLocalTime should not be called if unitRoundsToMidnight";
     *  
                return (value - interval + 1) / interval;
        public int hashCode() {  
                    return round(utcMillis + 2 * unitMillis);
            @Override  
        static final byte ID = 2;
            out.writeVLong(interval);  
 * specific language governing permissions and limitations
                    assert roundedRoundedDown == prevRound;
        @Override
import java.time.temporal.ChronoField;
                // Convert the overlap at this offset because that'll produce the largest result.
            public long round(long utcMillis) {  
                                + "] with non-month based calendar interval histogram ["
            if (unitRoundsToMidnight) {
        public byte id() {
                    for (int offsetIndex = currentOffsets.size() - 1; offsetIndex >= 0; offsetIndex--) {
            offset = in.readZLong();
        public byte id() {
            }
                /*
     */
import org.opensearch.common.round.Roundable;
        @Override
                    return delegatePrepared.roundingSize(utcMillis, timeUnit);
            private LocalDateTime nextRelevantMidnight(LocalDateTime localMidnight) {  
            return prepareOffsetOrJavaTimeRounding(minUtcMillis, maxUtcMillis).maybeUseArray(  
                    final Instant offsetInstant = offsetTime.toInstant();
        @Override  
            }  
                return round(utcMillis + unitMillis);
         * (e.g., zones with Daylight Saving Time).  
                    boolean tooHigh = roundedRoundedDown > prevRound;
            long extraLocalOffsetLookup() {
        @Override  
        @Override
    public final long nextRoundingValue(long utcMillis) {
            }
                return ratio;
        Prepared prepareJavaTime() {
 *  
import org.opensearch.core.common.io.stream.StreamOutput;  
            return unit;  
        private Prepared wrapPreparedRounding(Prepared delegatePrepared) {  
     * Rounding time intervals
                    ZoneOffsetTransition zoneOffsetTransition = timeZone.getRules().getTransition(localMidnight);
    }
         * that is not "effectively fixed".
                    }
        public Rounding build() {
            }  
                values = ArrayUtil.grow(values, i + 1);
        TimeIntervalRounding(StreamInput in) throws IOException {  
     * @deprecated Prefer {@link #prepare} and then {@link Prepared#round(long)}
                return extraLocalOffsetLookup;
                );
                 * to the last value we calculated. If it doesn't then we're
            public long round(long utcMillis) {
            }
                        // truncateAsLocalTime cannot have failed if there were no previous transitions
                return overlap.localToUtcInThisOffset(localMillis);
            default -> OptionalLong.empty();
            public long inOverlap(long localMillis, Overlap overlap) {  
        }
        MINUTES_OF_HOUR(
            }
        @Override
    @Deprecated
            TimeIntervalRounding other = (TimeIntervalRounding) obj;
            @Override
                        logger.debug("Iterated {} time for {} using {}", iterations, utcMillis, TimeIntervalRounding.this.toString());  
                return offset.localToUtc(roundKey(offset.utcToLocalTime(utcMillis), interval) * interval, this);
            }
            if (obj == null || getClass() != obj.getClass()) {  
                return null;
            long extraLocalOffsetLookup() {
                    assert false : this + " failed to round " + utcMillis + " down: " + offsetInstant + " is the earliest possible";  
            }
         * better if the limit was based on the actual type of prepared
                    assert highEnough && (false == tooHigh);  
        @Override
                // Convert the overlap at this offset because that'll produce the largest result.  
            public long beforeOverlap(long localMillis, Overlap overlap) {
                    if (iterations > 3 && logger.isDebugEnabled()) {
        }
         */  
            return "Rounding[" + unit + " in " + timeZone + "]";  
            if (obj == null) {  
        DAY_OF_MONTH((byte) 5, "day", ChronoField.DAY_OF_MONTH, true, ChronoField.DAY_OF_MONTH.getBaseUnit().getDuration().toMillis()) {
     * @opensearch.internal
        }  
                }
            }  
            public long nextRoundingValue(long utcMillis) {
            @Override
            private final LocalTimeOffset offset;
            }  
            this.unitRoundsToMidnight = this.unit.field.getBaseUnit().getDuration().toMillis() > 3600000L;
                    final OffsetDateTime offsetTime = roundedLocalDateTime.atOffset(currentOffsets.get(0));
        private final ZoneId timeZone;
import java.util.concurrent.TimeUnit;  
                        if (increment < 0) {
    }
        public Builder offset(long offset) {
                // The time zone is effectively fixed
        }
                /*
                    case WEEK_OF_WEEKYEAR -> localMidnight.plusDays(7);
         * ArrayRounding is an implementation of {@link Prepared} which uses
    /**  
                            increment = -increment / 2;
        }
            return ID;
            }
                    }  
                return new ToMidnightRounding(lookup);  
        }  
        }  
 * The second one allows you to specify an interval to round to.
        /**
        public long nextRoundingValue(long utcMillis) {  
        @Override
            case TimeUnitRounding tur -> OptionalLong.of(tur.unit.extraLocalOffsetLookup());  
 * Modifications Copyright OpenSearch Contributors. See  
        }
                             */
                    return new FixedToMidnightRounding(offset);
        private final DateTimeUnit unit;
                    case YEAR_OF_CENTURY -> localMidnight.plusYears(1);
            case TimeUnitRounding.ID -> new TimeUnitRounding(in);  
     *             so keep any usage to migratory shims  
        },
        long nextRoundingValue(long utcMillis);
            public long nextRoundingValue(long utcMillis) {  
                long prevRound = round(utcMillis);
                 * a "real" newton's method, so we just sort of cut the diff in half. As janky
            public long beforeGap(long localMillis, Gap gap) {
                }  
                    return (double) unit.ratio / timeUnit.ratio;  
            @Override
        },  
            public long inOverlap(long localMillis, Overlap overlap) {  
 * @opensearch.api
        public String toString() {  
            Rounding rounding;
         * <p>
        public void innerWriteTo(StreamOutput out) throws IOException {
    private abstract static class PreparedRounding implements Prepared {  
                            + timeUnit.shortName
            return delegate.equals(other.delegate) && offset == other.offset;
        }  
                return DateUtils.roundQuarterOfYear(utcMillis);
     */  
        return prepare(utcMillis, utcMillis).round(utcMillis);  
import java.time.temporal.TemporalQueries;
        }
        TimeUnitRounding(StreamInput in) throws IOException {
     * if the interval is not available
                Instant instant = Instant.ofEpochMilli(utcMillis);  
                    if (tooHigh) {  
        public Rounding withoutOffset() {
            return Objects.equals(interval, other.interval) && Objects.equals(timeZone, other.timeZone);
                }  
     * Strip the {@code offset} from these bounds.  
                        return truncatedTime.toEpochMilli();
                    }  
            public long nextRoundingValue(long utcMillis) {
            public long beforeOverlap(long localMillis, Overlap overlap) {  
            LocalTimeOffset.Lookup lookup = LocalTimeOffset.lookup(timeZone, minLookup, maxUtcMillis);
            FixedRounding(LocalTimeOffset offset) {
        }
        private class FixedRounding extends TimeIntervalPreparedRounding {  
        }  
         * @param offset the offset, in milliseconds  
            private final long extraLocalOffsetLookup = TimeUnit.DAYS.toMillis(7);  
                return overlap.previous().localToUtc(localMillis, this);
         * changes like DST transitions.
            this.timeZone = timeZone;  
            }
         * Given the rounded value, returns the size between this value and the
                final List<ZoneOffset> currentOffsets = timeZone.getRules().getValidOffsets(roundedLocalDateTime);
            return this;
            long minLookup = minUtcMillis - interval;
     * @deprecated Prefer {@link #prepare} and then {@link Prepared#nextRoundingValue(long)}
     * @opensearch.internal
         * Sets the offset of this rounding from the normal beginning of the interval. Use this
            }
        public static DateTimeUnit resolve(byte id) {
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeByte(unit.getId());
    public abstract void innerWriteTo(StreamOutput out) throws IOException;
                } else {
        }  
            }
import java.time.OffsetDateTime;
                return firstTimeOnDay(localMidnight);
            @Override
            if (obj == null) {
                rounding = new TimeIntervalRounding(interval, timeZone);  
    public abstract int hashCode();
                case MINUTES_OF_HOUR -> LocalDateTime.of(  
    /**
 * <p>
                // is missing due to an offset transition, so the time cannot be truncated.
            }  
            LocalTimeOffset fixedOffset = lookup.fixedInRange(minLookup, maxUtcMillis);
                return overlap.localToUtcInThisOffset(localMillis);
        private static final int DEFAULT_ARRAY_ROUNDING_MAX_THRESHOLD = 128;
    abstract Prepared prepareJavaTime();
            case TimeIntervalRounding tir -> OptionalLong.of(tir.interval);
                return offset.localToUtcInThisOffset(unit.roundFloor(offset.utcToLocalTime(utcMillis)));
                return false;
                return ROUNDING.nextRoundingValue(utcMillis);  
            @Override  
        },
            }
 * A strategy for rounding milliseconds since epoch.  
        }
    /**
            long extraLocalOffsetLookup() {  
                    0,  
                assert localMidnight.toLocalTime().equals(LocalTime.of(0, 0, 0)) : "firstTimeOnDay should only be called at midnight";
            this.delegate = delegate;
    }
import java.time.zone.ZoneRules;
 * See <a href="https://davecturner.github.io/2019/04/14/timezone-rounding.html">this</a>  
            this(in.readVLong(), in.readZoneId());
        public boolean equals(Object obj) {
                        if (result.isAfter(instant) == false) {  
            public long inOverlap(long localMillis, Overlap overlap) {
        @Override
    /**
                    return offsetInstant.toEpochMilli(); // TODO or throw something?
         * should be as fast as possible and not try to convert dates to java-time objects if possible
     * Rounding offsets
                if (i >= max) {
        @Override
        @Override
        }
                // We don't have the right information needed to know if this is safe for this time zone so we always use java rounding
        @Override  
                long from = prevRound;
        }  
    }
                 * value. And I can't come up with a nice way to use the java time API to figure
        }
            return delegate;
                return offset.localToUtc(unit.roundFloor(offset.utcToLocalTime(utcMillis)), this);
                return super.maybeUseArray(minUtcMillis, maxUtcMillis, max);
                LocalTimeOffset offset = lookup.lookup(utcMillis);  
        SECOND_OF_MINUTE(
            public long round(long utcMillis) {  
            true,  
                return MIDNIGHT_ROUNDING.nextRoundingValue(utcMillis);
                while (true) {
            }
            @Override
        /**  
                 * Units that round to midnight can round down from two
                    for (int offsetIndex = currentOffsets.size() - 1; 0 <= offsetIndex; offsetIndex--) {
            public long roundFloor(long utcMillis) {  
    /**  
        }
        }
        public boolean isUTC() {
     */
            public long roundFloor(long utcMillis) {
        ) {
                };
            int i = 0;
        }
                );
        /**
        }  
 * license agreements. See the NOTICE file distributed with
            protected Prepared maybeUseArray(long minUtcMillis, long maxUtcMillis, int max) {
         * example, with interval based rounding, if the interval is
            if (false == unitRoundsToMidnight) {  
                 * nextRoundingValue.
                this.offset = offset;
                    return zoneOffsetTransition.getInstant().toEpochMilli();
                final List<ZoneOffset> currentOffsets = rules.getValidOffsets(truncatedLocalDateTime);  
        }
        public abstract long roundFloor(long utcMillis);  
        public TemporalField getField() {
        @Override
         * 3, {@code nextRoundValue(6) = 9}.
            }
            public long roundFloor(long utcMillis) {  
         */  
        public void innerWriteTo(StreamOutput out) throws IOException {
         * </ul>
                        final Instant offsetInstant = offsetTime.toInstant();
        }
                    final ZoneOffset firstOffset = currentOffsets.getFirst();
        }
    public interface Prepared {
            long rounded = round(minUtcMillis);
 * The OpenSearch Contributors require contributions made to  
            return Objects.equals(unit, other.unit) && Objects.equals(timeZone, other.timeZone);
        TimeUnitRounding(DateTimeUnit unit, ZoneId timeZone) {
                }
            return switch (id) {  
         * The maximum limit up to which array-based prepared rounding is used.
 * There are two implementations for rounding.
            @Override
            this.field = field;  
        public Rounding withoutOffset() {
     * @param rounding {@link Rounding} instance  
                    return delegatePrepared.round(utcMillis - offset) + offset;
            @Override
                }
            return wrapPreparedRounding(delegate.prepareJavaTime());  
                }  
            ToMidnightRounding(LocalTimeOffset.Lookup lookup) {
                PreparedRounding.DEFAULT_ARRAY_ROUNDING_MAX_THRESHOLD  
                        if (utcInstant.isBefore(offsetTime.toInstant()) == false) {
        /**  
                logger.debug(  
        @Override  
                LocalDateTime earlierLocalMidnight = truncateLocalDateTime(localDateTime);
import java.time.ZoneId;  
        private final long interval;  
         * <ul>  
     * How "offset" this rounding is from the traditional "start" of the period.
                        }
                    }  
        }
                    if (false == highEnough) {
                assert localMillis == rawLocalDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
        return null;
        return new Builder(unit);
                        final OffsetDateTime offsetTime = roundedLocalDateTime.atOffset(currentOffsets.get(offsetIndex));  
            values[i++] = rounded;  
                return gap.startUtcMillis();
         * <ul>
            }
                        final Instant result = truncatedLocalDateTime.atOffset(currentOffsets.get(offsetIndex)).toInstant();
            this.timeZone = timeZone;
                case HOUR_OF_DAY -> LocalDateTime.of(  
    public void writeTo(StreamOutput out) throws IOException {
                return extraLocalOffsetLookup;
                return false;
    public abstract long offset();  
 * KIND, either express or implied.  See the License for the
                final Instant utcInstant = Instant.ofEpochMilli(utcMillis);  
     */  
            this.unit = unit;
import org.opensearch.core.common.io.stream.Writeable;
 * You may obtain a copy of the License at  
            return switch (unit) {
     * Prepare to round many dates over an unknown range. Prefer
                case 4 -> MONTH_OF_YEAR;
public abstract class Rounding implements Writeable {
            }
            public long roundFloor(long utcMillis) {  
        }
            @Override
            this.timeZone = timeZone;  
                    // round that down instead.
                    long rounded = round(from);
         * Rounds down within any time zone using {@link java.time.LocalDateTime}
                 * After 100 iterations we still couldn't settle on something! Crazy!
                return ratio;
            return "Rounding[" + interval + " in " + timeZone + "]";
    }
                this.offset = offset;
         */  
            ChronoField.MINUTE_OF_HOUR,
        public byte getId() {
        @Override
            if (interval < 1) throw new IllegalArgumentException("Zero or negative time interval not supported");
                    }  
                this.unitMillis = unitMillis;
                } else {
