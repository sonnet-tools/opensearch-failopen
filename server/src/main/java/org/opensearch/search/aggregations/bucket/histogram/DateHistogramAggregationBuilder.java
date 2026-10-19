        return builder;
    /** Create a new builder with the given name. */
    /** Set the interval on this builder, and return the builder so that calls can be chained.
        return offset(parseStringOffset(offset));
        );
            throw new IllegalArgumentException("[hardBounds] must not be null: [" + name + "]");
        AggregatorFactories.Builder subFactoriesBuilder
 * KIND, either express or implied.  See the License for the
        this.offset = clone.offset;
            && Objects.equals(dateHistogramInterval, other.dateHistogramInterval)
            DateHistogramAggregationBuilder.class.getSimpleName() + ".parseOffset"
    /** Return extended bounds for this histogram, or {@code null} if none are set. */
            subFactoriesBuilder,
        return this;
     * are calendar-aware, meaning they respect leap additions, variable days per month, etc.
 * this work for additional information regarding copyright
 */
    public LongBounds extendedBounds() {
    }
            if (roundedBounds.getMin() != null
     * Returns null otherwise.
        if (offset.charAt(0) == '-') {
        return keyed;
        PARSER.declareField(DateHistogramAggregationBuilder::offset, p -> {
            ).millis();
/*
            parser -> LongBounds.PARSER.apply(parser, null),
        return this;
    }
                DateHistogramAggregationBuilder.class.getSimpleName() + ".parseOffset"
    }
 *
            DateHistogramAggregationBuilder::hardBounds,
 *
        Map<String, Object> metadata
        AggregatorFactory parent,
     *  @deprecated use {@link #fixedInterval(DateHistogramInterval)} or {@link #calendarInterval(DateHistogramInterval)} instead
            parser -> LongBounds.PARSER.apply(parser, null),
        return this;
        return this;
     *  If both {@link #interval()} and {@link #dateHistogramInterval()} are set, then the
    /** Get the current date interval that is set on this builder. */
                        + hardBounds
 */
        DateIntervalWrapper.declareIntervalFields(PARSER);
        dateFieldUnits.put("quarter", Rounding.DateTimeUnit.QUARTER_OF_YEAR);
        dateFieldUnits.put("month", Rounding.DateTimeUnit.MONTH_OF_YEAR);
    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
        return extendedBounds;
    }
                && roundedBounds.getMax() > roundedHardBounds.getMax()) {
    public static long parseStringOffset(String offset) {
        this.extendedBounds = clone.extendedBounds;
        if (extendedBounds != null) {
            roundedBounds,
                && roundedHardBounds.getMin() != null
    }
/**
    }
     * ordering.
    public DateHistogramAggregationBuilder keyed(boolean keyed) {
        this.extendedBounds = extendedBounds;
            throw new IllegalArgumentException("[extendedBounds] must not be null: [" + name + "]");
        return dateHistogramInterval.dateHistogramInterval();
        }
     *
/*
        if (minDocCount < 0) {
        dateHistogramInterval.calendarInterval(interval);
import java.util.Map;
        dateFieldUnits.put("1M", Rounding.DateTimeUnit.MONTH_OF_YEAR);
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    public DateHistogramAggregationBuilder hardBounds(LongBounds hardBounds) {
                .round(rounding);
     * Parse the string specification of an offset.
 * specific language governing permissions and limitations
                        + extendedBounds
            DateHistogramAggregationBuilder::extendedBounds,
    /** Set the interval on this builder, and return the builder so that calls can be chained.
    public BucketCardinality bucketCardinality() {
        dateHistogramInterval.toXContent(builder, params);
        return this;
    }
     * Sets the order in which the buckets will be returned. A tie-breaker may be added to avoid non-deterministic
     * @param interval The fixed interval to use with the aggregation
            metadata
    @Override
        this.minDocCount = clone.minDocCount;
        if (extendedBounds == null) {
    /**
    protected void innerWriteTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.search.aggregations.AggregatorFactories;
        // if the list only contains one order use that to avoid inconsistent xcontent
        dateFieldUnits.put("1m", Rounding.DateTimeUnit.MINUTES_OF_HOUR);
        return offset;
    /** Return hard bounds for this histogram, or {@code null} if none are set. */
 * Licensed to Elasticsearch under one or more contributor
        this.order = clone.order;
            builder.endObject();
    public LongBounds hardBounds() {
import org.opensearch.search.aggregations.AggregationBuilder;
            (p, c) -> InternalOrder.Parser.parseOrderParam(p),
            extendedBounds.toXContent(builder, params);
     */
            Histogram.HARD_BOUNDS_FIELD,
    /** Set the offset on this builder, as a time value, and
 * @opensearch.internal
    }
    }
        if (this == obj) return true;
        return NAME;
    private LongBounds hardBounds;
        if (roundedBounds != null && roundedHardBounds != null) {
    }
    /**
    public DateHistogramAggregationBuilder dateHistogramInterval(DateHistogramInterval interval) {
        out.writeLong(offset);
                return DateHistogramAggregationBuilder.parseStringOffset(p.text());
    public DateHistogramAggregationBuilder(StreamInput in) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
            && Objects.equals(hardBounds, other.hardBounds);
        }
    public DateHistogramAggregationBuilder(String name) {
        PARSER.declareBoolean(DateHistogramAggregationBuilder::keyed, Histogram.KEYED_FIELD);
        builder.field(Histogram.MIN_DOC_COUNT_FIELD.getPreferredName(), minDocCount);
        dateFieldUnits.put("1w", Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR);
        if (dateHistogramInterval.getIntervalType().equals(DateIntervalWrapper.IntervalTypeEnum.FIXED)) {
import java.time.ZoneId;
    public DateHistogramAggregationBuilder fixedInterval(DateHistogramInterval interval) {
                    "Extended bounds have to be inside hard bounds, hard bounds: ["
import java.util.Objects;
    static {
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException("[orders] must not be null: [" + name + "]");
     *  generated on intervals that did not match any documents. */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     *  {@link #dateHistogramInterval()} wins.
    /**
                );
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        return null;
            roundedHardBounds,
            && Objects.equals(minDocCount, other.minDocCount)
        dateFieldUnits.put("1h", Rounding.DateTimeUnit.HOUR_OF_DAY);
    protected ValuesSourceType defaultValueSourceType() {
    }
        ValuesSourceConfig config,
    protected ValuesSourceAggregatorFactory innerBuild(
        return CoreValuesSourceType.DATE;
    private boolean keyed = false;
        return this;
        final Rounding rounding = dateHistogramInterval.createRounding(tz, offset);
     *  @since 7.2.0
        dateHistogramInterval.writeTo(out);
        return Objects.hash(super.hashCode(), order, keyed, minDocCount, dateHistogramInterval, minDocCount, extendedBounds, hardBounds);
    }
        LongBounds roundedBounds = null;
import java.util.List;
            minDocCount,
    private DateIntervalWrapper dateHistogramInterval = new DateIntervalWrapper();
        AggregatorFactories.Builder factoriesBuilder,
        return BucketCardinality.MANY;
        return null;
    public long interval() {
        dateFieldUnits.put("1d", Rounding.DateTimeUnit.DAY_OF_MONTH);
        ).millis();
    }
        PARSER.declareField(
    @Override
import java.util.HashMap;
        );
    }
            builder.startObject(Histogram.EXTENDED_BOUNDS_FIELD.getPreferredName());
    /** Set extended bounds on this histogram, so that buckets would also be
                        + hardBounds
 * the Apache License, Version 2.0 (the "License"); you may
     * @param interval The calendar interval to use with the aggregation
        }
        }
    }
        DateIntervalConsumer {
 * ownership. Elasticsearch licenses this file to you under
    }
        Map<String, Rounding.DateTimeUnit> dateFieldUnits = new HashMap<>();
        }
                        + "], extended bounds: ["
     * Sets the interval of the DateHistogram using calendar units (`1d`, `1w`, `1M`, etc).  These units
import org.opensearch.search.aggregations.InternalOrder;
    @Deprecated
    /** Set a new order on this builder and return the builder so that calls
        }
     *  If both {@link #interval()} and {@link #dateHistogramInterval()} are set, then the
    );
    }
 * GitHub history for details.
    public boolean equals(Object obj) {
     * Sets the interval of the DateHistogram using fixed units (`1ms`, `1s`, `10m`, `4h`, etc).  These are
            order,
     *  and return this builder so that calls can be chained. */
    @Deprecated
     *  builder so that calls can be chained. */
        dateFieldUnits.put("1q", Rounding.DateTimeUnit.QUARTER_OF_YEAR);
                    "Extended bounds have to be inside hard bounds, hard bounds: ["
            roundedBounds = this.extendedBounds.parseAndValidate(name, "extended_bounds", queryShardContext, config.format())
        dateFieldUnits.put("year", Rounding.DateTimeUnit.YEAR_OF_CENTURY);
    @Override
    private LongBounds extendedBounds;
            this.order = order; // if order already contains a tie-breaker we are good to go
    }
    public DateHistogramAggregationBuilder offset(String offset) {
package org.opensearch.search.aggregations.bucket.histogram;
        return this;
            }
import org.opensearch.core.xcontent.ObjectParser;
    /**
    public DateHistogramAggregationBuilder offset(long offset) {
 * not use this file except in compliance with the License.
        dateFieldUnits.put("week", Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR);
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    @Override
    private long offset = 0;
    public boolean keyed() {
     *  return the builder so that calls can be chained. */
 *
        return order;
    public long minDocCount() {
     */
        dateHistogramInterval = new DateIntervalWrapper(in);
        this.hardBounds = hardBounds;
    /** Set hard bounds on this histogram, specifying boundaries outside which buckets cannot be created. */
 * under the License.
    }
        if (hardBounds != null) {
    @Override
            throw new IllegalArgumentException(
            // parse any string bounds to longs and round
        if (obj == null || getClass() != obj.getClass()) return false;
 */
     * This is mutually exclusive with {@link DateHistogramAggregationBuilder#calendarInterval(DateHistogramInterval)}
        this.offset = offset;
        out.writeBoolean(keyed);
    public static final ValuesSourceRegistry.RegistryKey<DateHistogramAggregationSupplier> REGISTRY_KEY =
        }, Histogram.OFFSET_FIELD, ObjectParser.ValueType.LONG);
 */
        }
import org.opensearch.search.aggregations.AggregatorFactory;
        return minDocCount;
        PARSER.declareLong(DateHistogramAggregationBuilder::minDocCount, Histogram.MIN_DOC_COUNT_FIELD);
    }
        this.dateHistogramInterval = clone.dateHistogramInterval;
    }
            config,
            this.order = BucketOrder.compound(order);
        }
    }
import java.io.IOException;
    ) throws IOException {
    public static final Map<String, Rounding.DateTimeUnit> DATE_FIELD_UNITS;
        order = InternalOrder.Streams.readHistogramOrder(in, true);
        super(in);
        final ZoneId tz = timeZone();
     */
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
            } else {
     * <p>
        }
            && Objects.equals(extendedBounds, other.extendedBounds)
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
    }
import org.opensearch.core.xcontent.XContentParser;
    }
        return new DateHistogramAggregatorFactory(
        return this;
    ) {
 * compatible open source license.
        out.writeVLong(minDocCount);
        offset = in.readLong();
        if (dateHistogramInterval.getIntervalType().equals(DateIntervalWrapper.IntervalTypeEnum.CALENDAR)) {
                throw new IllegalArgumentException(
        builder.field(Histogram.OFFSET_FIELD.getPreferredName(), offset);
 * The OpenSearch Contributors require contributions made to
            Histogram.EXTENDED_BOUNDS_FIELD,
            return -TimeValue.parseTimeValue(
            throw new IllegalArgumentException("[order] must not be null: [" + name + "]");
    }
            if (roundedBounds.getMax() != null
    public int hashCode() {
        DATE_FIELD_UNITS = unmodifiableMap(dateFieldUnits);
    /** Set the offset on this builder, which is a number of milliseconds, and
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        dateFieldUnits.put("day", Rounding.DateTimeUnit.DAY_OF_MONTH);
    @Override
                return p.longValue();
        if (order != null) {
        InternalOrder.Streams.writeHistogramOrder(order, out, true);
                        + extendedBounds
        PARSER.declareObjectArray(
 * You may obtain a copy of the License at
        } else { // otherwise add a tie-breaker by using a compound order
        keyed = in.readBoolean();
public class DateHistogramAggregationBuilder extends ValuesSourceAggregationBuilder<DateHistogramAggregationBuilder>
     *  {@link #dateHistogramInterval()} wins.
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    /** Read from a stream, for internal use only. */
            roundedHardBounds = this.hardBounds.parseAndValidate(name, "hard_bounds", queryShardContext, config.format()).round(rounding);
    private BucketOrder order = BucketOrder.key(true);
    @Deprecated
                );
        dateFieldUnits.put("minute", Rounding.DateTimeUnit.MINUTES_OF_HOUR);
    }
        return this;
    }
        int beginIndex = offset.charAt(0) == '+' ? 1 : 0;
    }
     *
    public static final String NAME = "date_histogram";
            return dateHistogramInterval.getAsFixedInterval();
     * <p>
     * Returns null otherwise.
            order.toXContent(builder, params);
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    @Override
            throw new IllegalArgumentException("[offset] must not be null: [" + name + "]");
        dateHistogramInterval.dateHistogramInterval(interval);
            builder.field(Histogram.ORDER_FIELD.getPreferredName());
                && roundedBounds.getMin() < roundedHardBounds.getMin()) {
        return TimeValue.parseTimeValue(
            hardBounds.toXContent(builder, params);
     */
     *  @since 7.2.0
        }
        if (super.equals(obj) == false) return false;
        dateFieldUnits.put("hour", Rounding.DateTimeUnit.HOUR_OF_DAY);
        this.keyed = clone.keyed;
        QueryShardContext queryShardContext,
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, true);
    static {
    public static final ObjectParser<DateHistogramAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
        this.keyed = keyed;
    /**
 * license agreements. See the NOTICE file distributed with
    }
        NAME,
            builder.endObject();
     * Returns the interval as a date time unit if and only if it was configured as a calendar interval originally.
                null,
    /** Get the offset to use when rounding, which is a number of milliseconds. */
        dateFieldUnits.put("1y", Rounding.DateTimeUnit.YEAR_OF_CENTURY);
    /** Return whether buckets should be returned as a hash. In case
        );
    public DateHistogramAggregationBuilder order(List<BucketOrder> orders) {
 * this file be licensed under the Apache-2.0 license or a
     *  return the builder so that calls can be chained. */
        minDocCount = in.readVLong();
    implements
        dateFieldUnits.put("second", Rounding.DateTimeUnit.SECOND_OF_MINUTE);
        if (hardBounds == null) {
            && Objects.equals(keyed, other.keyed)
    }
    @Override
        return this;
import org.opensearch.common.unit.TimeValue;
        DateHistogramAggregationBuilder clone,
import org.opensearch.search.aggregations.BucketOrder;
            if (p.currentToken() == XContentParser.Token.VALUE_NUMBER) {
        DateHistogramAggregatorFactory.registerAggregators(builder);
        if (order instanceof CompoundOrder || InternalOrder.isKeyOrder(order)) {
    /** Return the order to use to sort buckets of this histogram. */
        }
        }
        dateHistogramInterval.interval(interval);
            queryShardContext,
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;
    public DateHistogramAggregationBuilder minDocCount(long minDocCount) {
        extendedBounds = in.readOptionalWriteable(LongBounds::new);
            ObjectParser.ValueType.OBJECT
    /** Set the minimum count of matching documents that buckets need to have
import org.opensearch.core.common.io.stream.StreamOutput;
        if (order == null) {
    public DateHistogramInterval dateHistogramInterval() {
    public long offset() {
     *  {@code keyed} is false, buckets will be returned as an array. */
                        + "]"
     * not calendar aware and are simply multiples of fixed, SI units.
        LongBounds roundedHardBounds = null;
            null,
        builder.field(Histogram.KEYED_FIELD.getPreferredName(), keyed);
    /**
            return dateHistogramInterval.getAsCalendarInterval();
    /** Set whether to return buckets as a hash or as an array, and return the
    public DateHistogramInterval getFixedInterval() {
        }
            // parse any string bounds to longs and round
    public DateHistogramAggregationBuilder calendarInterval(DateHistogramInterval interval) {
}
        if (this.extendedBounds != null) {
    @Deprecated
        );
        }
import org.opensearch.core.xcontent.XContentBuilder;
     * Returns the interval as a fixed time unit if and only if it was configured as a fixed interval originally.
        if (offset == null) {
                        + "]"
        return this;
    /** Get the current interval in milliseconds that is set on this builder. */
    }
        return REGISTRY_KEY;
 * A builder for histograms on date fields.
            && Objects.equals(offset, other.offset)
            );
        super(name);
     *  to be included in the response. */
     *
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }
    }
    protected DateHistogramAggregationBuilder(
            }
        return hardBounds;
        this.hardBounds = clone.hardBounds;
        DateHistogramAggregationBuilder::new
            offset.substring(beginIndex),
        if (this.hardBounds != null) {
                throw new IllegalArgumentException(
        dateHistogramInterval.fixedInterval(interval);
        hardBounds = in.readOptionalWriteable(LongBounds::new);
        if (orders == null) {
     */
    private long minDocCount = 0;
    }
            keyed,
import org.opensearch.common.Rounding;
     *  @deprecated use {@link #fixedInterval(DateHistogramInterval)} or {@link #calendarInterval(DateHistogramInterval)} instead
            builder.startObject(Histogram.HARD_BOUNDS_FIELD.getPreferredName());
     */
        out.writeOptionalWriteable(extendedBounds);
                offset.substring(1),
    }
import org.opensearch.index.query.QueryShardContext;
     */
import static java.util.Collections.unmodifiableMap;
     *  can be chained. A tie-breaker may be added to avoid non-deterministic ordering. */
            name,
     */
        return new DateHistogramAggregationBuilder(this, factoriesBuilder, metadata);
    public BucketOrder order() {
    }
            ObjectParser.ValueType.OBJECT
    @Override
            Histogram.ORDER_FIELD
    public DateHistogramAggregationBuilder extendedBounds(LongBounds extendedBounds) {
            parent,
            }
        order(orders.size() > 1 ? BucketOrder.compound(orders) : orders.get(0));
        DateHistogramAggregationBuilder other = (DateHistogramAggregationBuilder) obj;
    }
        out.writeOptionalWriteable(hardBounds);
/*
        PARSER.declareField(
        dateFieldUnits.put("1s", Rounding.DateTimeUnit.SECOND_OF_MINUTE);
 *
    public DateHistogramAggregationBuilder order(BucketOrder order) {
    public String getType() {
                && roundedHardBounds.getMax() != null
        this.minDocCount = minDocCount;
                        + "], extended bounds: ["
    /** Return the minimum count of documents that buckets need to have in order
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        }
     * This is mutually exclusive with {@link DateHistogramAggregationBuilder#fixedInterval(DateHistogramInterval)}
 * software distributed under the License is distributed on an
        return Objects.equals(order, other.order)
        new ValuesSourceRegistry.RegistryKey<>(NAME, DateHistogramAggregationSupplier.class);
        super(clone, factoriesBuilder, metadata);
     *
    public DateHistogramAggregationBuilder interval(long interval) {
        return dateHistogramInterval.interval();
            DateHistogramAggregationBuilder::order,
            rounding,
    public DateHistogramInterval getCalendarInterval() {
