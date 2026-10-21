                            compositeValuesSourceConfig.missingOrder(),
    );
     * Get the interval as a {@link TimeValue}, regardless of how it was configured. Returns null if
     * Sets the time zone to use for this aggregation
     * This is mutually exclusive with {@link DateHistogramValuesSourceBuilder#calendarInterval(DateHistogramInterval)}
        out.writeLong(offset);
    }
    protected void innerWriteTo(StreamOutput out) throws IOException {
                final DocValueFormat docValueFormat = format == null ? DocValueFormat.RAW : valuesSourceConfig.format();
public class DateHistogramValuesSourceBuilder extends CompositeValuesSourceBuilder<DateHistogramValuesSourceBuilder>
     * Returns the date interval that is set on this source
        return dateHistogramInterval.getAsFixedInterval();
import org.opensearch.core.common.io.stream.StreamInput;
                            roundingValuesSource::round,
    }
    }
                        CompositeValuesSourceConfig compositeValuesSourceConfig) -> {
import org.opensearch.search.aggregations.bucket.histogram.DateIntervalConsumer;
    }
    public DateHistogramValuesSourceBuilder timeZone(ZoneId timeZone) {
    public int hashCode() {
            boolean hasScript, // probably redundant with the config, but currently we check this two different ways...
    public String type() {
                    hasScript,
    }
            },
                    name,
                RoundingValuesSource vs = new RoundingValuesSource(numeric, preparedRounding, rounding);
    @Override
        return dateHistogramInterval.interval();
    static final String TYPE = "date_histogram";
                            size,
    public long offset() {
            }
                            compositeValuesSourceConfig.fieldType(),
            } else {
     */
                // here
        return timeZone;
 *
    }
        if (obj == null || getClass() != obj.getClass()) return false;
        DateHistogramValuesSourceBuilder other = (DateHistogramValuesSourceBuilder) obj;
    protected ValuesSourceType getDefaultValuesSourceType() {
                            compositeValuesSourceConfig.format(),
    @FunctionalInterface
        dateHistogramInterval.interval(interval);
        PARSER.declareField(DateHistogramValuesSourceBuilder::offset, p -> {
import java.time.ZoneOffset;
 * SPDX-License-Identifier: Apache-2.0
     * Returns the interval in milliseconds that is set on this source
    public DateHistogramValuesSourceBuilder dateHistogramInterval(DateHistogramInterval interval) {
 * a field name using the provided interval.
    @Deprecated
 */
import java.io.IOException;
                    order,
 * this work for additional information regarding copyright
                return ZoneOffset.ofHours(p.intValue());
     * @return this for chaining
        dateHistogramInterval.dateHistogramInterval(interval);
            if (p.currentToken() == XContentParser.Token.VALUE_STRING) {
 * The OpenSearch Contributors require contributions made to
                Rounding.Prepared preparedRounding = rounding.prepareForUnknown();
            } else {
}
    public DateHistogramInterval getIntervalAsFixed() {
/*
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
 * not use this file except in compliance with the License.
 */
import java.util.function.LongConsumer;
    protected CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config) throws IOException {
import org.opensearch.index.mapper.MappedFieldType;
import org.opensearch.search.aggregations.support.ValuesSourceType;
    /**
     */
                // TODO once composite is plugged in to the values source registry or at least understands Date values source types use it
     */
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
    public ZoneId timeZone() {
        return Objects.hash(super.hashCode(), dateHistogramInterval, timeZone);
     */
     * @param interval The calendar interval to use with the aggregation
    /**
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
        offset = in.readLong();
        DateIntervalWrapper.declareIntervalFields(PARSER);
        if (timeZone != null) {
        this.offset = offset;
 * @opensearch.internal
        Rounding rounding = dateHistogramInterval.createRounding(timeZone(), offset);
    protected DateHistogramValuesSourceBuilder(StreamInput in) throws IOException {
        DateHistogramValuesSourceBuilder::new
        dateHistogramInterval.calendarInterval(interval);
            String format,
     * Sets the interval of the DateHistogram using calendar units (`1d`, `1w`, `1M`, etc).  These units
/*
        this.timeZone = timeZone;
import java.util.Objects;
import org.opensearch.core.xcontent.ObjectParser;
     *  {@link TimeValue} and may be accessed via {@link #getIntervalAsFixed()} ()}. */
    public DateHistogramInterval dateHistogramInterval() {
        TYPE,
     * If both {@link #interval()} and {@link #dateHistogramInterval()} are set,
     * Get the offset to use when rounding, which is a number of milliseconds.
import org.opensearch.common.unit.TimeValue;
    /**
    private long offset = 0;
    @Deprecated
            .apply(config, rounding, name, config.script() != null, format(), missingBucket(), missingOrder(), order());
            ValuesSourceConfig config,
    }
    }
        }, Histogram.OFFSET_FIELD, ObjectParser.ValueType.LONG);
        out.writeOptionalZoneId(timeZone);
        return Objects.equals(dateHistogramInterval, other.dateHistogramInterval) && Objects.equals(timeZone, other.timeZone);
        if (super.equals(obj) == false) return false;
 */
    private DateIntervalWrapper dateHistogramInterval = new DateIntervalWrapper();
            if (p.currentToken() == XContentParser.Token.VALUE_NUMBER) {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                        return new LongValuesSource(
     * are calendar-aware, meaning they respect leap additions, variable days per month, etc.
            builder.field("time_zone", timeZone.toString());
     * not calendar aware and are simply multiples of fixed, SI units.
    public DateHistogramInterval getIntervalAsCalendar() {
     * then the {@link #dateHistogramInterval()} wins.
                        );
        return dateHistogramInterval.dateHistogramInterval();
    /**
    static {
    );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (this == obj) return true;
        TYPE,
    }
    public boolean equals(Object obj) {
/**
    /** Return the interval as a date time unit if applicable, regardless of how it was configured. If this returns
     * <p>
        dateHistogramInterval = new DateIntervalWrapper(in);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public DateHistogramValuesSourceBuilder fixedInterval(DateHistogramInterval interval) {
        if (timeZone == null) {
    }
 *
    }
 * the Apache License, Version 2.0 (the "License"); you may
                            compositeValuesSourceConfig.missingBucket(),
                // is specified in the builder.
            String name,
                            bigArrays,
    public DateHistogramValuesSourceBuilder calendarInterval(DateHistogramInterval interval) {
import org.apache.lucene.index.IndexReader;
        DateHistogramCompositeSupplier.class
                    vs,
        builder.register(
     * Gets the time zone to use for this aggregation
    @Override
            }
                    (
    static final ObjectParser<DateHistogramValuesSourceBuilder, String> PARSER = ObjectParser.fromBuilder(
    public DateHistogramValuesSourceBuilder offset(long offset) {
 * A {@link CompositeValuesSourceBuilder} that builds a {@link RoundingValuesSource} from a {@link Script} or
     **/
import java.util.List;
 * You may obtain a copy of the License at
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
     *
                            roundingValuesSource::longValues,
        return offset;
        super(name);
        dateHistogramInterval.writeTo(out);
        DateIntervalConsumer {
     * the interval cannot be parsed as a fixed time.
                return ZoneId.of(p.text());
import org.opensearch.script.Script;
import org.opensearch.core.xcontent.XContentBuilder;
    }
        );
                return p.longValue();
 * specific language governing permissions and limitations
     */
     *
                final MappedFieldType fieldType = valuesSourceConfig.fieldType();
            throw new IllegalArgumentException("[timeZone] must not be null: [" + name + "]");
    @Override
        return this;
                            compositeValuesSourceConfig.reverseMul()
     * Sets the interval of the DateHistogram using fixed units (`1ms`, `1s`, `10m`, `4h`, etc).  These are
    /**
     */
    /**
                ValuesSource.Numeric numeric = (ValuesSource.Numeric) valuesSourceConfig.getValuesSource();
     *
import org.opensearch.index.query.QueryShardContext;
    }
    }
            (valuesSourceConfig, rounding, name, hasScript, format, missingBucket, missingOrder, order) -> {
     * @opensearch.internal
     * This is mutually exclusive with {@link DateHistogramValuesSourceBuilder#fixedInterval(DateHistogramInterval)}
        return CoreValuesSourceType.DATE;
        return TYPE;
                    fieldType,
                    docValueFormat,
import org.opensearch.search.sort.SortOrder;
     */
     *  {@code null} then it means that the interval is expressed as a fixed
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        }, new ParseField("time_zone"), ObjectParser.ValueType.LONG);
    @Override
     * @since 7.2.0
 * software distributed under the License is distributed on an
     **/
    /**
            Rounding rounding,
        PARSER.declareString(DateHistogramValuesSourceBuilder::format, new ParseField("format"));
    @Override
                return new CompositeValuesSourceConfig(
    static final ValuesSourceRegistry.RegistryKey<DateHistogramCompositeSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
            .getAggregator(REGISTRY_KEY, config)
        }
        return this;
    @Override
        }
    }
     *
            SortOrder order
            MissingOrder missingOrder,
        return this;
     */
    @Deprecated
                    }
     */
                    missingBucket,
        dateHistogramInterval.toXContent(builder, params);
                return DateHistogramAggregationBuilder.parseStringOffset(p.text());
     * Set the offset on this builder, which is a number of milliseconds.
        timeZone = in.readOptionalZoneId();
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
    @Deprecated
package org.opensearch.search.aggregations.bucket.composite;
import org.opensearch.core.xcontent.XContentParser;
 * Modifications Copyright OpenSearch Contributors. See
        return dateHistogramInterval.getAsCalendarInterval();
            boolean missingBucket,
     * @deprecated Use {@link #calendarInterval(DateHistogramInterval)} or {@link #fixedInterval(DateHistogramInterval)} instead
                );
        return this;
    public static void register(ValuesSourceRegistry.Builder builder) {
            List.of(CoreValuesSourceType.DATE, CoreValuesSourceType.NUMERIC),
        return queryShardContext.getValuesSourceRegistry()
import java.time.ZoneId;
    /**
 * license agreements. See the NOTICE file distributed with
                        BigArrays bigArrays,
        super(in);
 *
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
import org.opensearch.common.Rounding;
import org.opensearch.search.DocValueFormat;
     **/
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * under the License.
    public interface DateHistogramCompositeSupplier {
    public DateHistogramValuesSourceBuilder interval(long interval) {
 * GitHub history for details.
     * @since 7.2.0
    /**
            REGISTRY_KEY,
import org.opensearch.search.aggregations.support.ValuesSource;
    }
    /**
        return this;
        );
import org.opensearch.common.util.BigArrays;
        dateHistogramInterval.fixedInterval(interval);
import org.opensearch.search.aggregations.bucket.histogram.DateIntervalWrapper;
     * @param interval The fixed interval to use with the aggregation
                        final RoundingValuesSource roundingValuesSource = (RoundingValuesSource) compositeValuesSourceConfig.valuesSource();
 */
 * compatible open source license.
                        LongConsumer addRequestCircuitBreakerBytes,
 * KIND, either express or implied.  See the License for the
    }
    /**
    @Override
    }
    protected void doXContentBody(XContentBuilder builder, Params params) throws IOException {
    public long interval() {
     * @deprecated Use {@link #calendarInterval(DateHistogramInterval)} or {@link #fixedInterval(DateHistogramInterval)} instead
        return this;
        PARSER.declareField(DateHistogramValuesSourceBuilder::timeZone, p -> {
 *
    }
import org.opensearch.core.ParseField;
     * Supplier for a composite date histogram
     * <p>
    }
     * Sets the interval on this source.
    /**
    }
/*
                        int size,
    implements
    public DateHistogramValuesSourceBuilder(String name) {
            false
                    missingOrder,
    private ZoneId timeZone = null;
 * ownership. Elasticsearch licenses this file to you under
    }
    }
    }
                        IndexReader reader,
        CompositeValuesSourceConfig apply(
        CompositeValuesSourceParserHelper.declareValuesSourceFields(PARSER);
