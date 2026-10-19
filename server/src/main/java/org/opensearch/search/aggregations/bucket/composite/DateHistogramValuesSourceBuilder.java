        PARSER.declareField(DateHistogramValuesSourceBuilder::timeZone, p -> {
            boolean hasScript, // probably redundant with the config, but currently we check this two different ways...
import java.time.ZoneId;
                return DateHistogramAggregationBuilder.parseStringOffset(p.text());
    }
 */  
    protected void innerWriteTo(StreamOutput out) throws IOException {
    }
     * the interval cannot be parsed as a fixed time.
 * You may obtain a copy of the License at  
    static final ValuesSourceRegistry.RegistryKey<DateHistogramCompositeSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
        DateHistogramValuesSourceBuilder other = (DateHistogramValuesSourceBuilder) obj;
        dateHistogramInterval.dateHistogramInterval(interval);
     * Sets the interval on this source.
/*  
    /**  
        );  
 * @opensearch.internal  
     * Get the offset to use when rounding, which is a number of milliseconds.  
 * KIND, either express or implied.  See the License for the
                    name,
    }
 * GitHub history for details.
    protected DateHistogramValuesSourceBuilder(StreamInput in) throws IOException {
     * <p>
                return ZoneId.of(p.text());
                            bigArrays,  
     * Get the interval as a {@link TimeValue}, regardless of how it was configured. Returns null if  
            false
public class DateHistogramValuesSourceBuilder extends CompositeValuesSourceBuilder<DateHistogramValuesSourceBuilder>
    public ZoneId timeZone() {
     * <p>  
    public int hashCode() {
 * a field name using the provided interval.
     * @since 7.2.0  
                        return new LongValuesSource(
    static final ObjectParser<DateHistogramValuesSourceBuilder, String> PARSER = ObjectParser.fromBuilder(  
    @Override
import org.opensearch.common.Rounding;
        PARSER.declareString(DateHistogramValuesSourceBuilder::format, new ParseField("format"));
        dateHistogramInterval.writeTo(out);
     */  
     **/
import java.util.function.LongConsumer;  
     * @param interval The fixed interval to use with the aggregation  
     * Returns the date interval that is set on this source  
                        IndexReader reader,  
        timeZone = in.readOptionalZoneId();
     *
    }  
            REGISTRY_KEY,
                            compositeValuesSourceConfig.missingBucket(),
            SortOrder order
                            roundingValuesSource::longValues,
     */  
    }
    public String type() {  
    /**
        );
                            roundingValuesSource::round,  
    }  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        dateHistogramInterval.fixedInterval(interval);  
     * This is mutually exclusive with {@link DateHistogramValuesSourceBuilder#calendarInterval(DateHistogramInterval)}
 *  
    /**  
     */
 *
        DateHistogramValuesSourceBuilder::new
import org.opensearch.core.ParseField;
                    order,  
                RoundingValuesSource vs = new RoundingValuesSource(numeric, preparedRounding, rounding);  
    }  
                        CompositeValuesSourceConfig compositeValuesSourceConfig) -> {  
     * are calendar-aware, meaning they respect leap additions, variable days per month, etc.
        return this;  
    @Override
                Rounding.Prepared preparedRounding = rounding.prepareForUnknown();
     * @opensearch.internal
        this.timeZone = timeZone;
    public DateHistogramValuesSourceBuilder fixedInterval(DateHistogramInterval interval) {
                // TODO once composite is plugged in to the values source registry or at least understands Date values source types use it  
    }
    /**
                );
            boolean missingBucket,  
    public DateHistogramValuesSourceBuilder dateHistogramInterval(DateHistogramInterval interval) {  
    @Deprecated
    }
            } else {
     *  {@code null} then it means that the interval is expressed as a fixed
    static {
     * Sets the time zone to use for this aggregation
 * ownership. Elasticsearch licenses this file to you under  
        }, new ParseField("time_zone"), ObjectParser.ValueType.LONG);
 * license agreements. See the NOTICE file distributed with
        offset = in.readLong();  
    /**
    }  
    protected CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config) throws IOException {
package org.opensearch.search.aggregations.bucket.composite;
 */
    public long interval() {
    public long offset() {
     */  
                        int size,
                    missingBucket,
            .getAggregator(REGISTRY_KEY, config)
    @Override
                final MappedFieldType fieldType = valuesSourceConfig.fieldType();  
            String format,
    }
        return this;
    @FunctionalInterface
     * @since 7.2.0  
        if (super.equals(obj) == false) return false;  
import org.opensearch.index.query.QueryShardContext;  
                            compositeValuesSourceConfig.fieldType(),
                ValuesSource.Numeric numeric = (ValuesSource.Numeric) valuesSourceConfig.getValuesSource();
 * specific language governing permissions and limitations
    }
 * Unless required by applicable law or agreed to in writing,
            builder.field("time_zone", timeZone.toString());
     * @deprecated Use {@link #calendarInterval(DateHistogramInterval)} or {@link #fixedInterval(DateHistogramInterval)} instead
 * the Apache License, Version 2.0 (the "License"); you may
    /**
                    hasScript,  
        }
     */  
        return TYPE;
        return dateHistogramInterval.getAsFixedInterval();
 * Licensed to Elasticsearch under one or more contributor  
    @Deprecated
     **/  
        if (this == obj) return true;
    protected ValuesSourceType getDefaultValuesSourceType() {  
import org.opensearch.search.aggregations.bucket.histogram.DateIntervalWrapper;  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     *  {@link TimeValue} and may be accessed via {@link #getIntervalAsFixed()} ()}. */  
        return dateHistogramInterval.dateHistogramInterval();
    @Override  
                    vs,
    }
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        TYPE,
        builder.register(
    public DateHistogramValuesSourceBuilder interval(long interval) {  
        out.writeLong(offset);
}
                    (
 * under the License.  
/*
    }
     **/
                return ZoneOffset.ofHours(p.intValue());  
                    missingOrder,
import org.opensearch.search.sort.SortOrder;
                            compositeValuesSourceConfig.reverseMul()
            }  
        if (obj == null || getClass() != obj.getClass()) return false;
    /**
            },  
    );
                final DocValueFormat docValueFormat = format == null ? DocValueFormat.RAW : valuesSourceConfig.format();
        DateIntervalWrapper.declareIntervalFields(PARSER);  
    /** Return the interval as a date time unit if applicable, regardless of how it was configured. If this returns
import org.opensearch.core.xcontent.ObjectParser;
    /**  
import org.apache.lucene.index.IndexReader;
        dateHistogramInterval = new DateIntervalWrapper(in);
        DateHistogramCompositeSupplier.class  
        return Objects.hash(super.hashCode(), dateHistogramInterval, timeZone);
import org.opensearch.core.xcontent.XContentParser;
                    docValueFormat,
    }
            throw new IllegalArgumentException("[timeZone] must not be null: [" + name + "]");  
    }  
            .apply(config, rounding, name, config.script() != null, format(), missingBucket(), missingOrder(), order());  
import org.opensearch.core.xcontent.XContentBuilder;  
    public DateHistogramInterval getIntervalAsFixed() {  
    implements  
import org.opensearch.search.aggregations.bucket.histogram.DateIntervalConsumer;
        return dateHistogramInterval.getAsCalendarInterval();
     * Supplier for a composite date histogram  
    @Deprecated
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
    protected void doXContentBody(XContentBuilder builder, Params params) throws IOException {
                        BigArrays bigArrays,
     * If both {@link #interval()} and {@link #dateHistogramInterval()} are set,
import org.opensearch.common.unit.TimeValue;  
     */
import org.opensearch.common.util.BigArrays;
        if (timeZone != null) {
            String name,  
     * @return this for chaining
    private long offset = 0;
     */
     *
            List.of(CoreValuesSourceType.DATE, CoreValuesSourceType.NUMERIC),  
    /**
     * Returns the interval in milliseconds that is set on this source
        super(name);
            if (p.currentToken() == XContentParser.Token.VALUE_NUMBER) {
    public DateHistogramValuesSourceBuilder timeZone(ZoneId timeZone) {
        CompositeValuesSourceConfig apply(  
    public DateHistogramValuesSourceBuilder(String name) {
                        final RoundingValuesSource roundingValuesSource = (RoundingValuesSource) compositeValuesSourceConfig.valuesSource();
 */
        return this;
 * this work for additional information regarding copyright
    }  
                return p.longValue();  
    }
        PARSER.declareField(DateHistogramValuesSourceBuilder::offset, p -> {
        TYPE,
     */
                        );  
    public DateHistogramInterval dateHistogramInterval() {  
import java.time.ZoneOffset;  
        if (timeZone == null) {
                return new CompositeValuesSourceConfig(
/*  
        return CoreValuesSourceType.DATE;
 * SPDX-License-Identifier: Apache-2.0
                // here
        this.offset = offset;
        out.writeOptionalZoneId(timeZone);  
    public boolean equals(Object obj) {  
        super(in);  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
    /**
        Rounding rounding = dateHistogramInterval.createRounding(timeZone(), offset);  
    @Override
                // is specified in the builder.
        }, Histogram.OFFSET_FIELD, ObjectParser.ValueType.LONG);
        DateIntervalConsumer {
     * @param interval The calendar interval to use with the aggregation
 *
    @Override  
        return this;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            MissingOrder missingOrder,
        dateHistogramInterval.interval(interval);
        dateHistogramInterval.calendarInterval(interval);
    public DateHistogramValuesSourceBuilder calendarInterval(DateHistogramInterval interval) {
     * This is mutually exclusive with {@link DateHistogramValuesSourceBuilder#fixedInterval(DateHistogramInterval)}  
 * software distributed under the License is distributed on an
    /**  
     * Gets the time zone to use for this aggregation
        return this;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    public static void register(ValuesSourceRegistry.Builder builder) {  
import org.opensearch.search.aggregations.support.ValuesSourceType;
    }
    private DateIntervalWrapper dateHistogramInterval = new DateIntervalWrapper();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
            } else {
    @Override  
                    }
     * @deprecated Use {@link #calendarInterval(DateHistogramInterval)} or {@link #fixedInterval(DateHistogramInterval)} instead
    }  
     * then the {@link #dateHistogramInterval()} wins.  
     * Set the offset on this builder, which is a number of milliseconds.
            if (p.currentToken() == XContentParser.Token.VALUE_STRING) {  
        return timeZone;
    public interface DateHistogramCompositeSupplier {
            Rounding rounding,
    @Deprecated
 */  
        dateHistogramInterval.toXContent(builder, params);  
        CompositeValuesSourceParserHelper.declareValuesSourceFields(PARSER);  
import org.opensearch.search.DocValueFormat;
import java.util.Objects;
import org.opensearch.search.aggregations.support.ValuesSource;
 * Modifications Copyright OpenSearch Contributors. See
import java.util.List;
                            compositeValuesSourceConfig.missingOrder(),  
    }
 * compatible open source license.
    }
    @Override
 *
import org.opensearch.index.mapper.MappedFieldType;
            (valuesSourceConfig, rounding, name, hasScript, format, missingBucket, missingOrder, order) -> {
            ValuesSourceConfig config,
     * Sets the interval of the DateHistogram using calendar units (`1d`, `1w`, `1M`, etc).  These units  
    );  
     *
    /**
                            compositeValuesSourceConfig.format(),
    private ZoneId timeZone = null;  
        return this;  
    static final String TYPE = "date_histogram";  
    public DateHistogramValuesSourceBuilder offset(long offset) {
     */
        }  
            }
import java.io.IOException;
     * Sets the interval of the DateHistogram using fixed units (`1ms`, `1s`, `10m`, `4h`, etc).  These are
/**
 * not use this file except in compliance with the License.
     *
                        LongConsumer addRequestCircuitBreakerBytes,
        return Objects.equals(dateHistogramInterval, other.dateHistogramInterval) && Objects.equals(timeZone, other.timeZone);
                            size,
        return dateHistogramInterval.interval();  
                    fieldType,  
        return offset;  
    public DateHistogramInterval getIntervalAsCalendar() {
import org.opensearch.core.common.io.stream.StreamOutput;
 * A {@link CompositeValuesSourceBuilder} that builds a {@link RoundingValuesSource} from a {@link Script} or  
        return queryShardContext.getValuesSourceRegistry()
import org.opensearch.script.Script;
     * not calendar aware and are simply multiples of fixed, SI units.
