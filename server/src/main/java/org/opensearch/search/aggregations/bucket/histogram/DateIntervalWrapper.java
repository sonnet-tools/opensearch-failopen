 * - Provides parser helpers for the deprecated interval/dateHistogramInterval parameters.
     * Sets the interval of the DateHistogram using fixed units (`1ms`, `1s`, `10m`, `4h`, etc).  These are
        }
            return DateHistogramAggregationBuilder.DATE_FIELD_UNITS.get(dateHistogramInterval.toString());
            return true;
        if (tryIntervalAsCalendarUnit() != null && that.tryIntervalAsCalendarUnit() == null) {
        }
     */
    public DateHistogramInterval getAsCalendarInterval() {
        }
 * - Provides a variety of helper methods to interpret the intervals as different types, depending on caller's need
            if (interval instanceof Long) {
     *  {@link #dateHistogramInterval()} wins.
        }
        }
        }
    /** Set the interval on this builder, and return the builder so that calls can be chained.
        return null;
            // We're not sure what the interval was originally (legacy) so use old behavior of assuming
    public DateIntervalWrapper() {}
 * Modifications Copyright OpenSearch Contributors. See
    public static <T extends DateIntervalConsumer> void declareIntervalFields(ObjectParser<T, String> parser) {
            return dateHistogramInterval;
    private void setIntervalType(IntervalTypeEnum type) {
    }
            // calendar first, then fixed. Required because fixed/cal overlap in places ("1h")
        }
                }
     *  @deprecated use {@link DateHistogramAggregationBuilder#fixedInterval(DateHistogramInterval)}
        if (intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO) || intervalType.equals(IntervalTypeEnum.LEGACY_INTERVAL)) {
    @Override
     * into a fixed interval
                    throw new IllegalArgumentException("Cannot use [fixed_interval] with [calendar_interval] " + "configuration option.");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        parser.declareField(
        }
 * not use this file except in compliance with the License.
    TimeValue tryIntervalAsFixedUnit() {
            } else if (fixedInterval != null) {
        if (interval == null || Strings.isNullOrEmpty(interval.toString())) {
    public int hashCode() {
 * Licensed to Elasticsearch under one or more contributor
    public void dateHistogramInterval(DateHistogramInterval dateHistogramInterval) {
            throw new IllegalArgumentException("[interval] must be 1 or greater for aggregation [date_histogram]");
            ObjectParser.ValueType.STRING
                break;
            return null;
     *
 */
                throw new IllegalStateException("Unknown interval type.");
            case FIXED:
    private DateHistogramInterval dateHistogramInterval;
        + "[calendar_interval] in the future.";
        }
     */
        DEPRECATION_LOGGER.deprecate("date-histogram-interval", DEPRECATION_TEXT);
        // interval() method
                if (intervalType.equals(IntervalTypeEnum.CALENDAR) || intervalType.equals(IntervalTypeEnum.FIXED)) {
        public void writeTo(StreamOutput out) throws IOException {
    /**
     *              or {@link DateIntervalWrapper#calendarInterval(DateHistogramInterval)} instead
            return;
                    throw new IllegalArgumentException("Cannot use [fixed_interval] with [interval] " + "configuration option.");
import java.io.IOException;
        DEPRECATION_LOGGER.deprecate("date-histogram-interval", DEPRECATION_TEXT);
    public void interval(long interval) {
        );
        if (DateHistogramAggregationBuilder.DATE_FIELD_UNITS.get(interval.toString()) == null) {
        }, p -> {
 * The OpenSearch Contributors require contributions made to
    /**
import org.opensearch.core.common.io.stream.StreamInput;
    /**
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.ParseField;
 * @opensearch.internal
        // NOTE: this field is deprecated and will be removed
            case LEGACY_INTERVAL:
            throw new IllegalArgumentException("[interval] must not be null: [date_histogram]");
        @Override
        // Parse to make sure it is a valid fixed too
            }
 * - Provides parser helpers for the new calendar/fixed interval parameters
        }
        }
        switch (type) {
        TimeValue.parseTimeValue(interval.toString(), DateHistogramAggregationBuilder.NAME + ".fixedInterval");
 */
            throw new IllegalArgumentException("[dateHistogramInterval] must not be null: [date_histogram]");
        tzRoundingBuilder.offset(offset);
     *  @since 7.2.0
                intervalType = IntervalTypeEnum.LEGACY_DATE_HISTO;
    DateTimeUnit tryIntervalAsCalendarUnit() {
            throw new IllegalArgumentException("[interval] must not be null: [date_histogram]");
        this.dateHistogramInterval = interval;
                }
import org.opensearch.core.xcontent.ToXContentFragment;
    }
/*
        setIntervalType(IntervalTypeEnum.FIXED);
        if (tryIntervalAsCalendarUnit() == null && that.tryIntervalAsCalendarUnit() != null) {
     * Returns the interval as a Fixed interval. Throws an exception if the value cannot be converted
        }
    }
        return 0;
                throw new IllegalArgumentException("Unable to parse interval [" + dateHistogramInterval + "]");
        } else if (intervalType.equals(IntervalTypeEnum.CALENDAR)) {
                if (intervalType.equals(IntervalTypeEnum.CALENDAR)) {
     *  If both {@link #interval()} and {@link #dateHistogramInterval()} are set, then the
    }
            case LEGACY_DATE_HISTO:
    /** Get the current date interval that is set on this builder. */
                intervalType = IntervalTypeEnum.CALENDAR;
    @Override
 * SPDX-License-Identifier: Apache-2.0
            tzRoundingBuilder.timeZone(timeZone);
            return false;
            tzRoundingBuilder = Rounding.builder(tryIntervalAsFixedUnit());
 * After the deprecated parameters are removed, this class can be simplified greatly.  The legacy options
     * @param interval The fixed interval to use
    }
            DateIntervalConsumer::fixedInterval,
            out.writeEnum(this);
            return true;
}
        if (intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO)) {
        this.dateHistogramInterval = new DateHistogramInterval(interval + "ms");
                if (intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO) == false) {
        }
                tzRoundingBuilder = Rounding.builder(calInterval);
            }
            FIXED_INTERVAL_FIELD,
    }
/*
            return dateHistogramInterval;
                return new DateHistogramInterval(p.text());
import java.time.ZoneId;
    }
    /** Get the current interval in milliseconds that is set on this builder. */
        } catch (IllegalArgumentException e) {
    }
        }
     * are calendar-aware, meaning they respect leap additions, variable days per month, etc.
        if (this == other) {
    }
        DEPRECATION_LOGGER.deprecate("date-histogram-interval", DEPRECATION_TEXT);
                    throw new IllegalArgumentException("Cannot use [calendar_interval] with [interval] " + "configuration option.");
import org.opensearch.core.common.io.stream.Writeable;
     */
     *  @deprecated use {@link DateIntervalWrapper#fixedInterval(DateHistogramInterval)}
     * not calendar aware and are simply multiples of fixed, SI units.
     * <p>
     *
     */
        if (intervalType.equals(IntervalTypeEnum.LEGACY_INTERVAL)) {
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(DateHistogramAggregationBuilder.class);
        DateIntervalWrapper.IntervalTypeEnum intervalType = getIntervalType();
     *
 * A class that handles all the parsing, bwc and deprecations surrounding date histogram intervals.
                break;
            intervalType = type;
        }, Histogram.INTERVAL_FIELD, ObjectParser.ValueType.LONG);
        }
    @Deprecated
 * software distributed under the License is distributed on an
                        "Cannot use [interval] with [fixed_interval] or [calendar_interval] " + "configuration options."
 * <p>
     * This is mutually exclusive with {@link DateIntervalWrapper#fixedInterval(DateHistogramInterval)}
    @Override
                if (intervalType.equals(IntervalTypeEnum.LEGACY_INTERVAL) || intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO)) {
    /**
            return valueOf(name.trim().toUpperCase(Locale.ROOT));
    public DateHistogramInterval getAsFixedInterval() {
        } else if (intervalType.equals(DateIntervalWrapper.IntervalTypeEnum.CALENDAR)) {
     *  @since 7.2.0
        if (intervalType.equals(IntervalTypeEnum.FIXED) || tryIntervalAsFixedUnit() != null) {
        throw new IllegalStateException("Cannot convert [" + intervalType.toString() + "] interval type into calendar interval");
            CALENDAR_INTERVAL_FIELD,
     * <p>
 */
        this.dateHistogramInterval = dateHistogramInterval;
 * this file be licensed under the Apache-2.0 license or a
    public boolean isEmpty() {
    /**
    }
        try {
package org.opensearch.search.aggregations.bucket.histogram;
    public Rounding createRounding(ZoneId timeZone, long offset) {
     *  {@link #dateHistogramInterval()} wins.
 * will be removed, and the mutual-exclusion checks can be done in the setters directly removing the need
        NONE,
    public IntervalTypeEnum getIntervalType() {
        return null;
import org.opensearch.core.xcontent.XContentBuilder;
                // dateHistogramInterval() takes precedence over interval()
import org.opensearch.common.Rounding.DateTimeUnit;
/**
            return TimeValue.parseTimeValue(dateHistogramInterval.toString(), null, getClass().getSimpleName() + ".interval");
    }
     * Sets the interval of the DateHistogram using calendar units (`1d`, `1w`, `1M`, etc).  These units
     *  {@code null} then it means that the interval is expressed as a fixed
     */
     */
                if (intervalType.equals(IntervalTypeEnum.LEGACY_INTERVAL) || intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO)) {
 * under the License.
        return tzRoundingBuilder.build();
        return Objects.equals(this.dateHistogramInterval, that.dateHistogramInterval);
import java.util.Objects;
            TimeValue fixedInterval = tryIntervalAsFixedUnit();
            return TimeValue.parseTimeValue(dateHistogramInterval.toString(), "interval").getMillis();
            return in.readEnum(IntervalTypeEnum.class);
        DEPRECATION_LOGGER.deprecate("date-histogram-interval", DEPRECATION_TEXT);
        return dateHistogramInterval == null || Strings.isNullOrEmpty(dateHistogramInterval.toString());
/*
    @Deprecated
        return intervalType;
    }
        parser.declareField(
    }
        }
     */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                tzRoundingBuilder = Rounding.builder(fixedInterval);
     * This is mutually exclusive with {@link DateIntervalWrapper#calendarInterval(DateHistogramInterval)}
        final DateIntervalWrapper that = (DateIntervalWrapper) other;
     *
        out.writeOptionalWriteable(dateHistogramInterval);
        if (intervalType.equals(DateIntervalWrapper.IntervalTypeEnum.FIXED)) {
                break;
        }
        if (other == null || getClass() != other.getClass()) {
        if (timeZone != null) {
 *
        public static IntervalTypeEnum fromStream(StreamInput in) throws IOException {
                    intervalType = IntervalTypeEnum.LEGACY_INTERVAL;
    }
            p -> new DateHistogramInterval(p.text()),
            DateTimeUnit calInterval = tryIntervalAsCalendarUnit();
                if (intervalType.equals(IntervalTypeEnum.FIXED)) {
        parser.declareField((wrapper, interval) -> {
        }
            } else {
     *              or {@link DateHistogramAggregationBuilder#calendarInterval(DateHistogramInterval)} instead
    }
    public void fixedInterval(DateHistogramInterval interval) {
        public String value() {
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
            return false;
        if (dateHistogramInterval == null || Strings.isNullOrEmpty(dateHistogramInterval.toString())) {
        if (dateHistogramInterval == null || Strings.isNullOrEmpty(dateHistogramInterval.toString())) {
 * - Can read old intervals from a stream and convert to new intervals
        // If we're the same or have no existing type, just use the provided type
            ObjectParser.ValueType.STRING
        }
                }
     *  {@link TimeValue} and may be accessed via {@link #tryIntervalAsFixedUnit()}. */
            return null;
        LEGACY_INTERVAL,
    @Deprecated
                // If we get here we have exhausted our options and are not able to parse this interval
        this.dateHistogramInterval = interval;
import java.util.Locale;
        }
 * compatible open source license.
    public DateHistogramInterval dateHistogramInterval() {
            p -> new DateHistogramInterval(p.text()),
        if (intervalType.equals(IntervalTypeEnum.NONE) || type.equals(intervalType)) {
     *
    }
                    );
import org.opensearch.common.Rounding;
            return false;
 * the Apache License, Version 2.0 (the "License"); you may
        setIntervalType(IntervalTypeEnum.LEGACY_INTERVAL);
        Rounding.Builder tzRoundingBuilder;
 * for the enum and the complicated "state machine" logic
                }
        } else if (intervalType.equals(IntervalTypeEnum.FIXED)) {
            throw new IllegalArgumentException("The supplied interval [" + interval + "] could not be parsed " + "as a calendar interval.");
import org.opensearch.core.common.io.stream.StreamOutput;
                }
 * <p>
    /** Return the interval as a date time unit if applicable, regardless of how it was configured. If this returns
     * @param interval The fixed interval to use
    public long interval() {
        CALENDAR,
                }
            } else {
        }
        intervalType.writeTo(out);
            default:
        }
        if (intervalType.equals(IntervalTypeEnum.NONE)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.field(FIXED_INTERVAL_FIELD.getPreferredName(), dateHistogramInterval.toString());
        if (interval == null || Strings.isNullOrEmpty(interval.toString())) {
    }
        }
        } else {
    private static final ParseField FIXED_INTERVAL_FIELD = new ParseField("fixed_interval");
            builder.field(Histogram.INTERVAL_FIELD.getPreferredName(), dateHistogramInterval.toString());
    }
        boolean isCalendar = tryIntervalAsCalendarUnit() != null;
        setIntervalType(IntervalTypeEnum.LEGACY_DATE_HISTO);
    @Override
     *  If both {@link #interval()} and {@link #dateHistogramInterval()} are set, then the
        public static IntervalTypeEnum fromString(String name) {
                    throw new IllegalArgumentException("Cannot use [calendar_interval] with [fixed_interval] " + "configuration option.");
     * The type of interval
     * Returns the interval as a calendar interval.  Throws an exception if the value cannot be converted
            builder.field(CALENDAR_INTERVAL_FIELD.getPreferredName(), dateHistogramInterval.toString());
    /**
                return p.longValue();
 *
    public DateIntervalWrapper(StreamInput in) throws IOException {
        return builder;
 * specific language governing permissions and limitations
    public boolean equals(Object other) {
        }
 * - Can write new intervals to old format when streaming out
import org.opensearch.common.unit.TimeValue;
                        "Cannot use [interval] with [fixed_interval] or [calendar_interval] " + "configuration options."
                wrapper.interval((long) interval);
        setIntervalType(IntervalTypeEnum.CALENDAR);
                    throw new IllegalArgumentException(
     * the interval cannot be parsed as a fixed time.
                    );
            case CALENDAR:
public class DateIntervalWrapper implements ToXContentFragment, Writeable {
            tzRoundingBuilder = Rounding.builder(tryIntervalAsCalendarUnit());
 * You may obtain a copy of the License at
    private static final ParseField CALENDAR_INTERVAL_FIELD = new ParseField("calendar_interval");
            } else {
     * into a calendar interval
                wrapper.dateHistogramInterval((DateHistogramInterval) interval);
            return name().toLowerCase(Locale.ROOT);
        LEGACY_DATE_HISTO;
 * GitHub history for details.
        if (intervalType.equals(IntervalTypeEnum.CALENDAR) || tryIntervalAsCalendarUnit() != null) {
import org.opensearch.core.xcontent.ObjectParser;
        if (isEmpty()) {
            if (calInterval != null) {
                }
    public enum IntervalTypeEnum implements Writeable {
    }
                // dateHistogramInterval() takes precedence over interval()
    }
     */
    public void calendarInterval(DateHistogramInterval interval) {
        }
 * this work for additional information regarding copyright
        if (interval < 1) {
     * @opensearch.internal
 *
                    throw new IllegalArgumentException(
                if (intervalType.equals(IntervalTypeEnum.CALENDAR) || intervalType.equals(IntervalTypeEnum.FIXED)) {
                intervalType = IntervalTypeEnum.FIXED;
            if (p.currentToken() == XContentParser.Token.VALUE_NUMBER) {
import org.opensearch.core.common.Strings;
import org.opensearch.core.xcontent.XContentParser;
 */
        dateHistogramInterval = in.readOptionalWriteable(DateHistogramInterval::new);
 * license agreements. See the NOTICE file distributed with
            throw new IllegalArgumentException("Invalid interval specified, must be non-null and non-empty");
        intervalType = IntervalTypeEnum.fromStream(in);
        return Objects.hash(dateHistogramInterval, isCalendar);
    /** Set the interval on this builder, and return the builder so that calls can be chained.
    private static final String DEPRECATION_TEXT = "[interval] on [date_histogram] is deprecated, use [fixed_interval] or "
        }
                break;
        }
import org.opensearch.common.logging.DeprecationLogger;
            }
        );
        throw new IllegalStateException("Cannot convert [" + intervalType.toString() + "] interval type into fixed interval");
    }
    @Deprecated
            DateIntervalConsumer::calendarInterval,
        if (intervalType.equals(IntervalTypeEnum.CALENDAR) || intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO)) {
    private IntervalTypeEnum intervalType = IntervalTypeEnum.NONE;
            return dateHistogramInterval;
 * ownership. Elasticsearch licenses this file to you under
        FIXED,
 *
     * Get the interval as a {@link TimeValue}, regardless of how it was configured. Returns null if
