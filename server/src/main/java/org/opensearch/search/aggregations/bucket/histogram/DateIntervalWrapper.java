 * - Provides parser helpers for the deprecated interval/dateHistogramInterval parameters.
        }  
 * Unless required by applicable law or agreed to in writing,
        try {  
                if (intervalType.equals(IntervalTypeEnum.LEGACY_INTERVAL) || intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO)) {  
                }  
        if (intervalType.equals(IntervalTypeEnum.CALENDAR) || intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO)) {
 *
 * for the enum and the complicated "state machine" logic
        intervalType.writeTo(out);
        }
            case FIXED:
        return null;
    @Deprecated  
     */
            return true;
    public void fixedInterval(DateHistogramInterval interval) {
        tzRoundingBuilder.offset(offset);
        if (timeZone != null) {
            DateIntervalConsumer::fixedInterval,
                        "Cannot use [interval] with [fixed_interval] or [calendar_interval] " + "configuration options."  
    }
 * specific language governing permissions and limitations
            return name().toLowerCase(Locale.ROOT);  
                }
            TimeValue fixedInterval = tryIntervalAsFixedUnit();  
    }
    private IntervalTypeEnum intervalType = IntervalTypeEnum.NONE;
        }
        switch (type) {
     *  {@link #dateHistogramInterval()} wins.
     *  @since 7.2.0  
                intervalType = IntervalTypeEnum.CALENDAR;
import org.opensearch.core.xcontent.ToXContentFragment;
            return dateHistogramInterval;
     * This is mutually exclusive with {@link DateIntervalWrapper#calendarInterval(DateHistogramInterval)}
                break;
    }
                        "Cannot use [interval] with [fixed_interval] or [calendar_interval] " + "configuration options."
    private static final ParseField CALENDAR_INTERVAL_FIELD = new ParseField("calendar_interval");
            p -> new DateHistogramInterval(p.text()),  
        }
        this.dateHistogramInterval = interval;  
                    throw new IllegalArgumentException("Cannot use [fixed_interval] with [interval] " + "configuration option.");
            DateTimeUnit calInterval = tryIntervalAsCalendarUnit();
        }
        if (intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO) || intervalType.equals(IntervalTypeEnum.LEGACY_INTERVAL)) {  
     *  {@link #dateHistogramInterval()} wins.  
        }  
     *  @since 7.2.0
    }  
                // dateHistogramInterval() takes precedence over interval()
    }  
            return dateHistogramInterval;
        }
    @Override
 * Licensed to Elasticsearch under one or more contributor  
        DEPRECATION_LOGGER.deprecate("date-histogram-interval", DEPRECATION_TEXT);  
    }
            intervalType = type;
        }
     *  @deprecated use {@link DateIntervalWrapper#fixedInterval(DateHistogramInterval)}
            builder.field(CALENDAR_INTERVAL_FIELD.getPreferredName(), dateHistogramInterval.toString());
 * After the deprecated parameters are removed, this class can be simplified greatly.  The legacy options
        return builder;
        // Parse to make sure it is a valid fixed too
            out.writeEnum(this);
        if (interval < 1) {
    public boolean isEmpty() {  
    private static final ParseField FIXED_INTERVAL_FIELD = new ParseField("fixed_interval");
    private void setIntervalType(IntervalTypeEnum type) {
 * SPDX-License-Identifier: Apache-2.0
    }
                wrapper.interval((long) interval);  
import org.opensearch.core.common.Strings;  
            case CALENDAR:  
    }
    /** Get the current date interval that is set on this builder. */  
    public DateHistogramInterval dateHistogramInterval() {
    }
import org.opensearch.core.xcontent.XContentParser;
 * this work for additional information regarding copyright
}
    }
            FIXED_INTERVAL_FIELD,
     */
     * Sets the interval of the DateHistogram using fixed units (`1ms`, `1s`, `10m`, `4h`, etc).  These are
            p -> new DateHistogramInterval(p.text()),
        DEPRECATION_LOGGER.deprecate("date-histogram-interval", DEPRECATION_TEXT);  
                    throw new IllegalArgumentException("Cannot use [calendar_interval] with [fixed_interval] " + "configuration option.");
 * compatible open source license.
        }  
    public int hashCode() {  
            return DateHistogramAggregationBuilder.DATE_FIELD_UNITS.get(dateHistogramInterval.toString());
            return TimeValue.parseTimeValue(dateHistogramInterval.toString(), null, getClass().getSimpleName() + ".interval");
/**
                intervalType = IntervalTypeEnum.FIXED;  
                    throw new IllegalArgumentException("Cannot use [fixed_interval] with [calendar_interval] " + "configuration option.");
        return intervalType;
        // NOTE: this field is deprecated and will be removed  
        this.dateHistogramInterval = new DateHistogramInterval(interval + "ms");  
     */
        parser.declareField(
    /** Return the interval as a date time unit if applicable, regardless of how it was configured. If this returns  
import org.opensearch.core.common.io.stream.StreamInput;
            }
            return dateHistogramInterval;
                break;
     *
    }
    @Deprecated
                if (intervalType.equals(IntervalTypeEnum.CALENDAR) || intervalType.equals(IntervalTypeEnum.FIXED)) {
     * @param interval The fixed interval to use  
    public DateHistogramInterval getAsFixedInterval() {
    public void writeTo(StreamOutput out) throws IOException {
    }
 * the Apache License, Version 2.0 (the "License"); you may
        if (isEmpty()) {  
        }
public class DateIntervalWrapper implements ToXContentFragment, Writeable {
        if (intervalType.equals(IntervalTypeEnum.FIXED) || tryIntervalAsFixedUnit() != null) {  
            builder.field(FIXED_INTERVAL_FIELD.getPreferredName(), dateHistogramInterval.toString());  
        CALENDAR,  
/*  
    }
        TimeValue.parseTimeValue(interval.toString(), DateHistogramAggregationBuilder.NAME + ".fixedInterval");
        throw new IllegalStateException("Cannot convert [" + intervalType.toString() + "] interval type into calendar interval");  
 *  
    }
 * not use this file except in compliance with the License.
        NONE,
     *  {@code null} then it means that the interval is expressed as a fixed
     */
    public Rounding createRounding(ZoneId timeZone, long offset) {
     * @param interval The fixed interval to use  
    @Override
     *  If both {@link #interval()} and {@link #dateHistogramInterval()} are set, then the
        return 0;  
        Rounding.Builder tzRoundingBuilder;
     */
        DateIntervalWrapper.IntervalTypeEnum intervalType = getIntervalType();  
 *
        }
    private DateHistogramInterval dateHistogramInterval;
    public IntervalTypeEnum getIntervalType() {
            } else {
        if (intervalType.equals(IntervalTypeEnum.CALENDAR) || tryIntervalAsCalendarUnit() != null) {  
        parser.declareField(  
        }  
        if (tryIntervalAsCalendarUnit() != null && that.tryIntervalAsCalendarUnit() == null) {
    /**
     */
    }  
            return null;
     * Returns the interval as a Fixed interval. Throws an exception if the value cannot be converted
    }
    }
            return valueOf(name.trim().toUpperCase(Locale.ROOT));
    /**  
     */
                }
    }
        public static IntervalTypeEnum fromString(String name) {
import org.opensearch.core.xcontent.XContentBuilder;  
            throw new IllegalArgumentException("[interval] must be 1 or greater for aggregation [date_histogram]");
     *  
            throw new IllegalArgumentException("[interval] must not be null: [date_histogram]");
        return Objects.equals(this.dateHistogramInterval, that.dateHistogramInterval);
        }  
 * - Can write new intervals to old format when streaming out
 * software distributed under the License is distributed on an
        setIntervalType(IntervalTypeEnum.LEGACY_DATE_HISTO);
        }  
    public void interval(long interval) {  
 * KIND, either express or implied.  See the License for the
    DateTimeUnit tryIntervalAsCalendarUnit() {  
        intervalType = IntervalTypeEnum.fromStream(in);
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
        throw new IllegalStateException("Cannot convert [" + intervalType.toString() + "] interval type into fixed interval");  
            // We're not sure what the interval was originally (legacy) so use old behavior of assuming  
                tzRoundingBuilder = Rounding.builder(fixedInterval);
        // interval() method  
    @Override
        setIntervalType(IntervalTypeEnum.LEGACY_INTERVAL);
                }  
            if (interval instanceof Long) {
    public static <T extends DateIntervalConsumer> void declareIntervalFields(ObjectParser<T, String> parser) {
import java.util.Objects;  
        // If we're the same or have no existing type, just use the provided type  
     *  If both {@link #interval()} and {@link #dateHistogramInterval()} are set, then the
        if (intervalType.equals(IntervalTypeEnum.LEGACY_INTERVAL)) {  
 */  
 */
/*
            builder.field(Histogram.INTERVAL_FIELD.getPreferredName(), dateHistogramInterval.toString());
    TimeValue tryIntervalAsFixedUnit() {
                    );  
    public DateIntervalWrapper(StreamInput in) throws IOException {
        }
    /**
                // dateHistogramInterval() takes precedence over interval()  
        if (interval == null || Strings.isNullOrEmpty(interval.toString())) {  
        FIXED,
        if (dateHistogramInterval == null || Strings.isNullOrEmpty(dateHistogramInterval.toString())) {
                break;  
            return true;
        @Override  
     *  @deprecated use {@link DateHistogramAggregationBuilder#fixedInterval(DateHistogramInterval)}
                if (intervalType.equals(IntervalTypeEnum.FIXED)) {
        } else if (intervalType.equals(DateIntervalWrapper.IntervalTypeEnum.CALENDAR)) {  
        }
                if (intervalType.equals(IntervalTypeEnum.CALENDAR)) {  
                intervalType = IntervalTypeEnum.LEGACY_DATE_HISTO;
    public enum IntervalTypeEnum implements Writeable {  
        );
            case LEGACY_DATE_HISTO:  
import org.opensearch.core.ParseField;
    }
import org.opensearch.core.common.io.stream.StreamOutput;
                return new DateHistogramInterval(p.text());
                tzRoundingBuilder = Rounding.builder(calInterval);
    /**
            } else {
            } else if (fixedInterval != null) {  
        }
            DateIntervalConsumer::calendarInterval,
            } else {
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(DateHistogramAggregationBuilder.class);  
        public String value() {
    /** Set the interval on this builder, and return the builder so that calls can be chained.  
    /**
     * the interval cannot be parsed as a fixed time.  
     *  
            return in.readEnum(IntervalTypeEnum.class);  
import java.util.Locale;
                return p.longValue();  
                if (intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO) == false) {
 * ownership. Elasticsearch licenses this file to you under  
            }  
            if (p.currentToken() == XContentParser.Token.VALUE_NUMBER) {
            throw new IllegalArgumentException("Invalid interval specified, must be non-null and non-empty");
    }  
            throw new IllegalArgumentException("[dateHistogramInterval] must not be null: [date_histogram]");  
 * - Provides a variety of helper methods to interpret the intervals as different types, depending on caller's need  
            return null;  
 * license agreements. See the NOTICE file distributed with
 */
 * <p>
        if (intervalType.equals(IntervalTypeEnum.NONE) || type.equals(intervalType)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * <p>  
     */
 * - Can read old intervals from a stream and convert to new intervals
        public void writeTo(StreamOutput out) throws IOException {
        DEPRECATION_LOGGER.deprecate("date-histogram-interval", DEPRECATION_TEXT);
        this.dateHistogramInterval = dateHistogramInterval;
        }
     * Returns the interval as a calendar interval.  Throws an exception if the value cannot be converted
 * will be removed, and the mutual-exclusion checks can be done in the setters directly removing the need  
            case LEGACY_INTERVAL:
            default:
                    intervalType = IntervalTypeEnum.LEGACY_INTERVAL;
        parser.declareField((wrapper, interval) -> {
import org.opensearch.core.common.io.stream.Writeable;  
                throw new IllegalArgumentException("Unable to parse interval [" + dateHistogramInterval + "]");
        return Objects.hash(dateHistogramInterval, isCalendar);
                // If we get here we have exhausted our options and are not able to parse this interval  
 * A class that handles all the parsing, bwc and deprecations surrounding date histogram intervals.  
import org.opensearch.common.Rounding;
            // calendar first, then fixed. Required because fixed/cal overlap in places ("1h")
    }
        }
            tzRoundingBuilder = Rounding.builder(tryIntervalAsFixedUnit());
    /** Set the interval on this builder, and return the builder so that calls can be chained.
            }  
                }
package org.opensearch.search.aggregations.bucket.histogram;
    public DateIntervalWrapper() {}  
    public DateHistogramInterval getAsCalendarInterval() {
        dateHistogramInterval = in.readOptionalWriteable(DateHistogramInterval::new);  
            tzRoundingBuilder = Rounding.builder(tryIntervalAsCalendarUnit());
     * This is mutually exclusive with {@link DateIntervalWrapper#fixedInterval(DateHistogramInterval)}
    @Deprecated  
     * are calendar-aware, meaning they respect leap additions, variable days per month, etc.
     * Sets the interval of the DateHistogram using calendar units (`1d`, `1w`, `1M`, etc).  These units
        if (DateHistogramAggregationBuilder.DATE_FIELD_UNITS.get(interval.toString()) == null) {  
            throw new IllegalArgumentException("[interval] must not be null: [date_histogram]");
        boolean isCalendar = tryIntervalAsCalendarUnit() != null;
            throw new IllegalArgumentException("The supplied interval [" + interval + "] could not be parsed " + "as a calendar interval.");
            return false;  
        } catch (IllegalArgumentException e) {
    @Override
     *
        }  
        setIntervalType(IntervalTypeEnum.CALENDAR);  
        if (intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO)) {
            ObjectParser.ValueType.STRING
    private static final String DEPRECATION_TEXT = "[interval] on [date_histogram] is deprecated, use [fixed_interval] or "
 * under the License.  
 */  
import java.io.IOException;  
        if (other == null || getClass() != other.getClass()) {  
        if (dateHistogramInterval == null || Strings.isNullOrEmpty(dateHistogramInterval.toString())) {  
 * Modifications Copyright OpenSearch Contributors. See
        }
        + "[calendar_interval] in the future.";
 * - Provides parser helpers for the new calendar/fixed interval parameters  
import org.opensearch.common.unit.TimeValue;
            ObjectParser.ValueType.STRING
 *
        this.dateHistogramInterval = interval;
     * into a calendar interval  
     * @opensearch.internal
                    throw new IllegalArgumentException(
        }  
import org.opensearch.common.Rounding.DateTimeUnit;
            if (calInterval != null) {
                    );
    public boolean equals(Object other) {
        }, Histogram.INTERVAL_FIELD, ObjectParser.ValueType.LONG);
        } else {
                break;
    /**  
    @Deprecated
                    throw new IllegalArgumentException("Cannot use [calendar_interval] with [interval] " + "configuration option.");
        return tzRoundingBuilder.build();
import org.opensearch.common.logging.DeprecationLogger;  
        }  
            return TimeValue.parseTimeValue(dateHistogramInterval.toString(), "interval").getMillis();
            return false;
    public long interval() {
     * not calendar aware and are simply multiples of fixed, SI units.
                if (intervalType.equals(IntervalTypeEnum.CALENDAR) || intervalType.equals(IntervalTypeEnum.FIXED)) {  
        final DateIntervalWrapper that = (DateIntervalWrapper) other;
 * <p>
import java.time.ZoneId;
                    throw new IllegalArgumentException(
 * @opensearch.internal  
        return null;
     * into a fixed interval  
/*  
     *              or {@link DateIntervalWrapper#calendarInterval(DateHistogramInterval)} instead  
        return dateHistogramInterval == null || Strings.isNullOrEmpty(dateHistogramInterval.toString());
     *  {@link TimeValue} and may be accessed via {@link #tryIntervalAsFixedUnit()}. */
        if (this == other) {  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        DEPRECATION_LOGGER.deprecate("date-histogram-interval", DEPRECATION_TEXT);
            CALENDAR_INTERVAL_FIELD,  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        LEGACY_DATE_HISTO;
import org.opensearch.core.xcontent.ObjectParser;
        if (interval == null || Strings.isNullOrEmpty(interval.toString())) {  
                }
        LEGACY_INTERVAL,
     * The type of interval
        out.writeOptionalWriteable(dateHistogramInterval);  
    public void dateHistogramInterval(DateHistogramInterval dateHistogramInterval) {
        }
     *
     *              or {@link DateHistogramAggregationBuilder#calendarInterval(DateHistogramInterval)} instead
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (intervalType.equals(IntervalTypeEnum.LEGACY_INTERVAL) || intervalType.equals(IntervalTypeEnum.LEGACY_DATE_HISTO)) {
        } else if (intervalType.equals(IntervalTypeEnum.FIXED)) {
     * Get the interval as a {@link TimeValue}, regardless of how it was configured. Returns null if
        }  
        }
    public void calendarInterval(DateHistogramInterval interval) {
        public static IntervalTypeEnum fromStream(StreamInput in) throws IOException {
            tzRoundingBuilder.timeZone(timeZone);
        if (intervalType.equals(DateIntervalWrapper.IntervalTypeEnum.FIXED)) {
        );  
            return;  
                throw new IllegalStateException("Unknown interval type.");
        }, p -> {
        setIntervalType(IntervalTypeEnum.FIXED);  
     * <p>  
        if (intervalType.equals(IntervalTypeEnum.NONE)) {
                }  
        if (tryIntervalAsCalendarUnit() == null && that.tryIntervalAsCalendarUnit() != null) {
            return false;  
    /** Get the current interval in milliseconds that is set on this builder. */
        } else if (intervalType.equals(IntervalTypeEnum.CALENDAR)) {
                wrapper.dateHistogramInterval((DateHistogramInterval) interval);
        }
