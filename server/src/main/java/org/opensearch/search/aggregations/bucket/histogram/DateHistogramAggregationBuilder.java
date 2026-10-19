        if (roundedBounds != null && roundedHardBounds != null) {
        }  
        return this;
     *  If both {@link #interval()} and {@link #dateHistogramInterval()} are set, then the  
    /** Set extended bounds on this histogram, so that buckets would also be
        DateIntervalConsumer {
        return this;
        DateHistogramAggregationBuilder other = (DateHistogramAggregationBuilder) obj;
    ) {  
 * specific language governing permissions and limitations
public class DateHistogramAggregationBuilder extends ValuesSourceAggregationBuilder<DateHistogramAggregationBuilder>  
        out.writeVLong(minDocCount);
     */
            // parse any string bounds to longs and round  
    public static final ObjectParser<DateHistogramAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
    public DateHistogramAggregationBuilder hardBounds(LongBounds hardBounds) {
     *  and return this builder so that calls can be chained. */
import java.util.Objects;  
    public DateHistogramAggregationBuilder dateHistogramInterval(DateHistogramInterval interval) {
            this.order = order; // if order already contains a tie-breaker we are good to go
    @Override
     * are calendar-aware, meaning they respect leap additions, variable days per month, etc.  
        return this;
        dateFieldUnits.put("1y", Rounding.DateTimeUnit.YEAR_OF_CENTURY);
    /** Set the offset on this builder, as a time value, and
        if (offset.charAt(0) == '-') {
                        + "], extended bounds: ["
        }
import org.opensearch.core.xcontent.ObjectParser;
        }  
            if (p.currentToken() == XContentParser.Token.VALUE_NUMBER) {
    public String getType() {  
    /** Return the minimum count of documents that buckets need to have in order
    @Override
     *  return the builder so that calls can be chained. */
    public DateHistogramAggregationBuilder(String name) {
        dateFieldUnits.put("minute", Rounding.DateTimeUnit.MINUTES_OF_HOUR);  
        }
            metadata  
    public int hashCode() {
        }
        if (this.hardBounds != null) {  
    }
    }
     * This is mutually exclusive with {@link DateHistogramAggregationBuilder#fixedInterval(DateHistogramInterval)}
    /** Set the offset on this builder, which is a number of milliseconds, and  
        out.writeOptionalWriteable(extendedBounds);
        return Objects.equals(order, other.order)  
            roundedHardBounds,
        dateFieldUnits.put("week", Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR);  
    public long offset() {
     * @param interval The calendar interval to use with the aggregation
        );
            offset.substring(beginIndex),
 *  
     * <p>
            }  
            && Objects.equals(dateHistogramInterval, other.dateHistogramInterval)  
    }
    @Override  
     * Returns null otherwise.
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            && Objects.equals(keyed, other.keyed)
        PARSER.declareField(DateHistogramAggregationBuilder::offset, p -> {  
    public DateHistogramAggregationBuilder interval(long interval) {
    private DateIntervalWrapper dateHistogramInterval = new DateIntervalWrapper();
     *  {@code keyed} is false, buckets will be returned as an array. */
            builder.endObject();  
    public DateHistogramAggregationBuilder offset(long offset) {
    @Override  
        hardBounds = in.readOptionalWriteable(LongBounds::new);
    /** Create a new builder with the given name. */  
    public long interval() {
                .round(rounding);
        if (minDocCount < 0) {
            Histogram.EXTENDED_BOUNDS_FIELD,  
    public LongBounds extendedBounds() {  
        dateFieldUnits.put("month", Rounding.DateTimeUnit.MONTH_OF_YEAR);
        DateHistogramAggregationBuilder clone,  
        }
    public DateHistogramAggregationBuilder order(BucketOrder order) {
    public static final ValuesSourceRegistry.RegistryKey<DateHistogramAggregationSupplier> REGISTRY_KEY =
        if (orders == null) {
        QueryShardContext queryShardContext,
        extendedBounds = in.readOptionalWriteable(LongBounds::new);  
    }  
        DATE_FIELD_UNITS = unmodifiableMap(dateFieldUnits);
        return Objects.hash(super.hashCode(), order, keyed, minDocCount, dateHistogramInterval, minDocCount, extendedBounds, hardBounds);  
        Map<String, Rounding.DateTimeUnit> dateFieldUnits = new HashMap<>();
    }
    static {
        dateHistogramInterval = new DateIntervalWrapper(in);
import org.opensearch.search.aggregations.AggregationBuilder;  
        final Rounding rounding = dateHistogramInterval.createRounding(tz, offset);
        this.keyed = clone.keyed;
 * compatible open source license.
    public DateHistogramAggregationBuilder minDocCount(long minDocCount) {  
            DateHistogramAggregationBuilder::extendedBounds,
            && Objects.equals(extendedBounds, other.extendedBounds)
     *  If both {@link #interval()} and {@link #dateHistogramInterval()} are set, then the
        dateFieldUnits.put("year", Rounding.DateTimeUnit.YEAR_OF_CENTURY);  
/*
    public LongBounds hardBounds() {  
        return this;
                );
        this.extendedBounds = extendedBounds;
        return CoreValuesSourceType.DATE;  
        dateHistogramInterval.calendarInterval(interval);
        return hardBounds;
     *  builder so that calls can be chained. */
        return REGISTRY_KEY;  
        );
        this.hardBounds = hardBounds;  
    public DateHistogramAggregationBuilder offset(String offset) {  
     *  @deprecated use {@link #fixedInterval(DateHistogramInterval)} or {@link #calendarInterval(DateHistogramInterval)} instead  
        AggregatorFactories.Builder subFactoriesBuilder
     *  
     *  {@link #dateHistogramInterval()} wins.
    public DateHistogramAggregationBuilder fixedInterval(DateHistogramInterval interval) {
        PARSER.declareObjectArray(
                    "Extended bounds have to be inside hard bounds, hard bounds: ["
    }
    @Override
                        + "]"
     * @param interval The fixed interval to use with the aggregation
            order,  
        if (order instanceof CompoundOrder || InternalOrder.isKeyOrder(order)) {  
            extendedBounds.toXContent(builder, params);
        this.minDocCount = minDocCount;  
import org.opensearch.core.xcontent.XContentParser;
 * A builder for histograms on date fields.
     * Returns null otherwise.
            throw new IllegalArgumentException("[orders] must not be null: [" + name + "]");
import org.opensearch.search.aggregations.InternalOrder;
    }
    }
        dateFieldUnits.put("1m", Rounding.DateTimeUnit.MINUTES_OF_HOUR);
        }  
    implements
        return null;
        order(orders.size() > 1 ? BucketOrder.compound(orders) : orders.get(0));
        }
    /**
            && Objects.equals(offset, other.offset)
                        + "], extended bounds: ["  
    }
    public DateHistogramInterval dateHistogramInterval() {
                        + "]"
            && Objects.equals(hardBounds, other.hardBounds);  
        dateFieldUnits.put("1s", Rounding.DateTimeUnit.SECOND_OF_MINUTE);  
            builder.startObject(Histogram.EXTENDED_BOUNDS_FIELD.getPreferredName());
        offset = in.readLong();
        new ValuesSourceRegistry.RegistryKey<>(NAME, DateHistogramAggregationSupplier.class);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                null,
            roundedBounds = this.extendedBounds.parseAndValidate(name, "extended_bounds", queryShardContext, config.format())
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
     *  return the builder so that calls can be chained. */
     *
                        + hardBounds
     *  @since 7.2.0
        return this;  
        Map<String, Object> metadata
    public DateHistogramAggregationBuilder extendedBounds(LongBounds extendedBounds) {  
 *
    private BucketOrder order = BucketOrder.key(true);
            Histogram.HARD_BOUNDS_FIELD,
    }  
 * GitHub history for details.
import org.opensearch.search.aggregations.AggregatorFactories;
                throw new IllegalArgumentException(
    @Deprecated  
        dateFieldUnits.put("day", Rounding.DateTimeUnit.DAY_OF_MONTH);
        PARSER.declareBoolean(DateHistogramAggregationBuilder::keyed, Histogram.KEYED_FIELD);
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"  
 *  
        dateFieldUnits.put("1d", Rounding.DateTimeUnit.DAY_OF_MONTH);  
        return TimeValue.parseTimeValue(
        return this;
    public boolean keyed() {
    }
        return offset;  
            config,
    }
            ).millis();
            DateHistogramAggregationBuilder::hardBounds,
        order = InternalOrder.Streams.readHistogramOrder(in, true);
                && roundedBounds.getMax() > roundedHardBounds.getMax()) {
    protected DateHistogramAggregationBuilder(
    /** Return hard bounds for this histogram, or {@code null} if none are set. */
    }  
        if (offset == null) {
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
            minDocCount,
        this.keyed = keyed;  
 * software distributed under the License is distributed on an
        DateIntervalWrapper.declareIntervalFields(PARSER);
            return dateHistogramInterval.getAsFixedInterval();
    @Override
            (p, c) -> InternalOrder.Parser.parseOrderParam(p),
     * Parse the string specification of an offset.
            builder.endObject();  
 * ownership. Elasticsearch licenses this file to you under  
        } else { // otherwise add a tie-breaker by using a compound order
        if (extendedBounds != null) {  
            builder.startObject(Histogram.HARD_BOUNDS_FIELD.getPreferredName());
    }
    }  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        InternalOrder.Streams.writeHistogramOrder(order, out, true);
            return dateHistogramInterval.getAsCalendarInterval();  
            return -TimeValue.parseTimeValue(  
        dateFieldUnits.put("hour", Rounding.DateTimeUnit.HOUR_OF_DAY);
        this.order = clone.order;  
    /**
    /**
            this.order = BucketOrder.compound(order);  
    public boolean equals(Object obj) {
            ObjectParser.ValueType.OBJECT
    }
    );
 * license agreements. See the NOTICE file distributed with
     */  
    /** Set the interval on this builder, and return the builder so that calls can be chained.  
        return builder;
    public DateHistogramAggregationBuilder order(List<BucketOrder> orders) {  
import org.opensearch.search.aggregations.AggregatorFactory;
        return keyed;  
    private LongBounds hardBounds;
        AggregatorFactories.Builder factoriesBuilder,
        }
        if (hardBounds == null) {  
    public DateHistogramAggregationBuilder keyed(boolean keyed) {
 * SPDX-License-Identifier: Apache-2.0
        DateHistogramAggregationBuilder::new  
        }, Histogram.OFFSET_FIELD, ObjectParser.ValueType.LONG);  
    public BucketOrder order() {
    }
        int beginIndex = offset.charAt(0) == '+' ? 1 : 0;  
    @Deprecated  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
import org.opensearch.index.query.QueryShardContext;
    private long minDocCount = 0;
        super(name);
    /** Set a new order on this builder and return the builder so that calls  
     */  
        PARSER.declareField(  
    /** Get the current date interval that is set on this builder. */  
        AggregatorFactory parent,
     *  can be chained. A tie-breaker may be added to avoid non-deterministic ordering. */
 * Unless required by applicable law or agreed to in writing,
    /** Set the interval on this builder, and return the builder so that calls can be chained.
    }
    @Deprecated
            keyed,
    /**
        final ZoneId tz = timeZone();
                        + extendedBounds  
        return NAME;
        ValuesSourceConfig config,  
    public DateHistogramAggregationBuilder(StreamInput in) throws IOException {
    public DateHistogramAggregationBuilder calendarInterval(DateHistogramInterval interval) {  
    /** Set whether to return buckets as a hash or as an array, and return the  
    public DateHistogramInterval getFixedInterval() {  
     *  @since 7.2.0
    private LongBounds extendedBounds;  
     * This is mutually exclusive with {@link DateHistogramAggregationBuilder#calendarInterval(DateHistogramInterval)}  
            null,  
import org.opensearch.common.unit.TimeValue;
        if (order == null) {  
     *  
/*  
        return this;
        builder.field(Histogram.KEYED_FIELD.getPreferredName(), keyed);
                );  
        }
            } else {  
     */
/*  
 */  
        LongBounds roundedHardBounds = null;
    ) throws IOException {  
    /** Get the offset to use when rounding, which is a number of milliseconds. */
    protected void innerWriteTo(StreamOutput out) throws IOException {
    private long offset = 0;
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, true);  
            // parse any string bounds to longs and round
        dateHistogramInterval.fixedInterval(interval);
 * this work for additional information regarding copyright
        }
        if (extendedBounds == null) {
            throw new IllegalArgumentException(
 */  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
     */  
     * Returns the interval as a fixed time unit if and only if it was configured as a fixed interval originally.  
 */
 */
        PARSER.declareField(
            if (roundedBounds.getMax() != null  
        if (dateHistogramInterval.getIntervalType().equals(DateIntervalWrapper.IntervalTypeEnum.CALENDAR)) {
    static {
        minDocCount = in.readVLong();  
     * Sets the order in which the buckets will be returned. A tie-breaker may be added to avoid non-deterministic  
 * You may obtain a copy of the License at  
            throw new IllegalArgumentException("[extendedBounds] must not be null: [" + name + "]");
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.BucketOrder;  
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;
        }  
                && roundedHardBounds.getMax() != null
 * the Apache License, Version 2.0 (the "License"); you may
        dateHistogramInterval.writeTo(out);
            ObjectParser.ValueType.OBJECT
        if (this.extendedBounds != null) {
     * <p>
import java.util.Map;
        );  
            queryShardContext,  
        return null;
     *  @deprecated use {@link #fixedInterval(DateHistogramInterval)} or {@link #calendarInterval(DateHistogramInterval)} instead
/**
        if (dateHistogramInterval.getIntervalType().equals(DateIntervalWrapper.IntervalTypeEnum.FIXED)) {
    }
        }  
            && Objects.equals(minDocCount, other.minDocCount)
        dateHistogramInterval.toXContent(builder, params);  
 * under the License.  
    public long minDocCount() {  
import org.opensearch.core.common.io.stream.StreamInput;  
        dateFieldUnits.put("second", Rounding.DateTimeUnit.SECOND_OF_MINUTE);
     * Sets the interval of the DateHistogram using calendar units (`1d`, `1w`, `1M`, etc).  These units
        this.dateHistogramInterval = clone.dateHistogramInterval;
     */  
        return this;
    }
            parser -> LongBounds.PARSER.apply(parser, null),
    }
        }  
        NAME,
import org.opensearch.common.Rounding;
        LongBounds roundedBounds = null;
    @Override
            builder.field(Histogram.ORDER_FIELD.getPreferredName());
import static java.util.Collections.unmodifiableMap;
    }  
    /** Return the order to use to sort buckets of this histogram. */
    }
    }
                && roundedBounds.getMin() < roundedHardBounds.getMin()) {
    }  
        return offset(parseStringOffset(offset));
            throw new IllegalArgumentException("[order] must not be null: [" + name + "]");
            subFactoriesBuilder,
                && roundedHardBounds.getMin() != null  
        super(in);  
    public static long parseStringOffset(String offset) {
import java.util.List;
            roundedBounds,
        this.offset = clone.offset;  
        }
        PARSER.declareLong(DateHistogramAggregationBuilder::minDocCount, Histogram.MIN_DOC_COUNT_FIELD);
     * ordering.
    }  
    private boolean keyed = false;  
        keyed = in.readBoolean();
            rounding,  
        this.minDocCount = clone.minDocCount;
    }
    }  
import org.opensearch.core.xcontent.XContentBuilder;  
        return BucketCardinality.MANY;  
        return dateHistogramInterval.interval();
            parent,
     *
import java.util.HashMap;  
import java.time.ZoneId;
 *
        dateFieldUnits.put("1h", Rounding.DateTimeUnit.HOUR_OF_DAY);
            }
     *  generated on intervals that did not match any documents. */
 * KIND, either express or implied.  See the License for the
                offset.substring(1),
    @Override  
import org.opensearch.core.common.io.stream.StreamOutput;
    /**  
        super(clone, factoriesBuilder, metadata);
                    "Extended bounds have to be inside hard bounds, hard bounds: ["  
            order.toXContent(builder, params);
    @Override  
        out.writeOptionalWriteable(hardBounds);
    /**
        if (super.equals(obj) == false) return false;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    public DateHistogramInterval getCalendarInterval() {
            throw new IllegalArgumentException("[offset] must not be null: [" + name + "]");
     * Sets the interval of the DateHistogram using fixed units (`1ms`, `1s`, `10m`, `4h`, etc).  These are  
        );  
            DateHistogramAggregationBuilder::order,  
        dateFieldUnits.put("1w", Rounding.DateTimeUnit.WEEK_OF_WEEKYEAR);
                DateHistogramAggregationBuilder.class.getSimpleName() + ".parseOffset"  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.support.ValuesSourceType;
import java.io.IOException;
        // if the list only contains one order use that to avoid inconsistent xcontent
        return new DateHistogramAggregationBuilder(this, factoriesBuilder, metadata);
    /** Set the minimum count of matching documents that buckets need to have
     * Returns the interval as a date time unit if and only if it was configured as a calendar interval originally.
        out.writeLong(offset);  
    }
 * Modifications Copyright OpenSearch Contributors. See
        dateHistogramInterval.interval(interval);
     * not calendar aware and are simply multiples of fixed, SI units.
    }  
        return this;  
            name,
    @Override
     *  to be included in the response. */
        dateFieldUnits.put("quarter", Rounding.DateTimeUnit.QUARTER_OF_YEAR);
    }
        if (this == obj) return true;
        this.hardBounds = clone.hardBounds;
 * The OpenSearch Contributors require contributions made to  
    /** Read from a stream, for internal use only. */
}
        ).millis();
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
        }  
 * Licensed to Elasticsearch under one or more contributor  
     */
    }  
    }
    protected ValuesSourceType defaultValueSourceType() {
    }
            hardBounds.toXContent(builder, params);
                        + hardBounds
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
    public static final Map<String, Rounding.DateTimeUnit> DATE_FIELD_UNITS;
    /** Set hard bounds on this histogram, specifying boundaries outside which buckets cannot be created. */
 * @opensearch.internal
        DateHistogramAggregatorFactory.registerAggregators(builder);
        dateFieldUnits.put("1q", Rounding.DateTimeUnit.QUARTER_OF_YEAR);  
                return DateHistogramAggregationBuilder.parseStringOffset(p.text());
                throw new IllegalArgumentException(  
package org.opensearch.search.aggregations.bucket.histogram;
        return this;
            );
    }
     *  {@link #dateHistogramInterval()} wins.
        return new DateHistogramAggregatorFactory(  
            parser -> LongBounds.PARSER.apply(parser, null),  
        dateHistogramInterval.dateHistogramInterval(interval);  
        builder.field(Histogram.MIN_DOC_COUNT_FIELD.getPreferredName(), minDocCount);
        out.writeBoolean(keyed);  
            DateHistogramAggregationBuilder.class.getSimpleName() + ".parseOffset"
    }
    }
            roundedHardBounds = this.hardBounds.parseAndValidate(name, "hard_bounds", queryShardContext, config.format()).round(rounding);
                        + extendedBounds
        dateFieldUnits.put("1M", Rounding.DateTimeUnit.MONTH_OF_YEAR);
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    /** Return whether buckets should be returned as a hash. In case  
        return minDocCount;
        return dateHistogramInterval.dateHistogramInterval();  
        if (obj == null || getClass() != obj.getClass()) return false;  
        this.offset = offset;  
        return extendedBounds;
    /** Return extended bounds for this histogram, or {@code null} if none are set. */
    /** Get the current interval in milliseconds that is set on this builder. */
        if (order != null) {  
            if (roundedBounds.getMin() != null
                return p.longValue();
    }
        return order;  
    protected ValuesSourceAggregatorFactory innerBuild(
        this.extendedBounds = clone.extendedBounds;
        if (hardBounds != null) {  
    }
            throw new IllegalArgumentException("[hardBounds] must not be null: [" + name + "]");
    public static final String NAME = "date_histogram";
            }
            Histogram.ORDER_FIELD
        return this;  
    @Deprecated
    public BucketCardinality bucketCardinality() {
        builder.field(Histogram.OFFSET_FIELD.getPreferredName(), offset);
