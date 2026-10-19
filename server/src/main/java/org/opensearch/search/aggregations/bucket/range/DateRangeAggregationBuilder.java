    /**  
    ) throws IOException {  
import org.opensearch.search.aggregations.AggregatorFactory;
     *            the key to use for this range in the response
        return this;
    @Override
     * @param from  
        return new DateRangeAggregatorFactory(  
     *            the lower bound on the dates, inclusive
                agg.addRange(range);
     */
            double from = range.getFrom();  
            throw new IllegalArgumentException("No [ranges] specified for the [" + this.getName() + "] aggregation");
            return null;
     *
     * Same as {@link #addUnboundedFrom(String, String)} but the key will be
    public static final ObjectParser<DateRangeAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(  
     * @param from
        return this;  
     *            the upper bound on the dates, exclusive
    /**
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, true);
    }
     *            the key to use for this range in the response
     * @param key  
        });
        super(clone, factoriesBuilder, metadata);
    ) {  
import org.opensearch.index.query.QueryShardContext;  
     * Add a new range with no upper bound.
    }  
    }
        PARSER.declareObjectArray((agg, ranges) -> {
     * Add a new range with no upper bound.
    }
            } else if (Double.isFinite(to)) {
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Add a new range to this aggregation.
        ValuesSourceConfig config,  
     * computed automatically.
    public DateRangeAggregationBuilder addUnboundedFrom(String from) {
 * this work for additional information regarding copyright
     *            the key to use for this range in the response  
    protected DateRangeAggregatorFactory innerBuild(
     */  
    }  
    public DateRangeAggregationBuilder addUnboundedTo(String key, ZonedDateTime to) {
    /**  
        DateRangeAggregationBuilder::new
    }
    }
    }  
    }
     * @param key
    }
     * @param key  
 * SPDX-License-Identifier: Apache-2.0
            rangeFactory,
    }
        return addRange(null, from, to);
        return new DateRangeAggregationBuilder(this, factoriesBuilder, metadata);  
    protected ValuesSourceType defaultValueSourceType() {  
     * automatically generated based on <code>from</code> and <code>to</code>.
            subFactoriesBuilder,
     */
}  
     * @param key  
        super(name, InternalDateRange.FACTORY);
            config,
        addRange(new RangeAggregator.Range(key, convertDateTime(from), convertDateTime(to)));
     */
     * Same as {@link #addUnboundedTo(String, String)} but the key will be
    private static Double convertDateTime(ZonedDateTime dateTime) {
     * Same as {@link #addUnboundedTo(String, double)} but the key will be
    }
     * computed automatically.  
        AggregatorFactories.Builder factoriesBuilder,
import java.util.Map;
        return addRange(null, from, to);  
/*  
        return this;
        RangeAggregatorSupplier.class  
    public DateRangeAggregationBuilder addUnboundedFrom(String key, double from) {
    static {
            if (fromAsString != null) {
    /**
    }
     * Add a new range with no lower bound.
    public DateRangeAggregationBuilder addUnboundedTo(String key, double to) {
        Map<String, Object> metadata
 *
    }
    public DateRangeAggregationBuilder addRange(String key, String from, String to) {
        super(in, InternalDateRange.FACTORY, RangeAggregator.Range::new);
     * @param from
     *            the key to use for this range in the response  
            } else if (Double.isFinite(from)) {  
            }
 * KIND, either express or implied.  See the License for the
     */  
        return this;
                from = parser.parseDouble(fromAsString, false, queryShardContext::nowInMillis);
            String toAsString = range.getToAsString();  
     * @param key
    public DateRangeAggregationBuilder addRange(String from, String to) {
            return (double) dateTime.toInstant().toEpochMilli();  
            return new RangeAggregator.Range(range.getKey(), from, fromAsString, to, toAsString);
     * computed automatically.
     */
     */
     * Add a new range with no lower bound.  
    /**  
     */  
     * @param to  
    }
    public DateRangeAggregationBuilder addUnboundedFrom(String key, String from) {
     */
     *            the upper bound on the dates, exclusive  
     * @param to
            parent,
/*
        return this;
     * Same as {@link #addUnboundedTo(String, ZonedDateTime)} but the key will be
        return addUnboundedFrom(null, from);  
 */
            assert parser != null;
        addRange(new RangeAggregator.Range(key, null, to));  
     *
        addRange(new RangeAggregator.Range(key, convertDateTime(from), null));  
     * Add a new range to this aggregation.  
public class DateRangeAggregationBuilder extends AbstractRangeBuilder<DateRangeAggregationBuilder, RangeAggregator.Range> {
 *  
     *            the key to use for this range in the response
    /**  
     * @param to
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
                // different formats like `epoch_millis` vs. `epoch_second` with numeric input
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    public DateRangeAggregationBuilder addRange(double from, double to) {
        } else {
        addRange(new RangeAggregator.Range(key, from, null));  
    /**
     * computed automatically.  
 * not use this file except in compliance with the License.
     * Same as {@link #addRange(String, String, String)} but the key will be
    @Override  
     */
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    }  
 * You may obtain a copy of the License at  
            keyed,
 * ownership. Elasticsearch licenses this file to you under  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
                // from/to provided as double should be converted to string and parsed regardless to support
 */
        RangeAggregator.Range[] ranges = processRanges(range -> {  
        return addUnboundedFrom(null, from);  
     *            the lower bound on the dates, inclusive  
    }
    /**
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
     *            the upper bound on the dates, exclusive
     */  
    @Override
    }
     * @param key  
        addRange(new RangeAggregator.Range(key, null, to));
 * specific language governing permissions and limitations
    public DateRangeAggregationBuilder addUnboundedTo(String key, String to) {
    /**
     * computed automatically.  
                to = parser.parseDouble(toAsString, false, queryShardContext::nowInMillis);  
        return REGISTRY_KEY;
    }
                to = parser.parseDouble(Long.toString((long) to), false, queryShardContext::nowInMillis);
    public DateRangeAggregationBuilder addRange(String key, double from, double to) {
        NAME,
     *            the key to use for this range in the response
import org.opensearch.search.aggregations.AggregationBuilder;
        return addUnboundedTo(null, to);  
     */
        if (ranges.length == 0) {  
    /**  
 * Aggregation Builder for date_range agg
import java.time.ZonedDateTime;  
    );  
            name,
    /**  
    /**  
import java.io.IOException;
     * @param key  
     * automatically generated based on <code>from</code> and <code>to</code>.  
    }
        QueryShardContext queryShardContext,
    public DateRangeAggregationBuilder addUnboundedFrom(double from) {
     * @param to
            ranges,  
     * Add a new range with no upper bound.  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
        if (dateTime == null) {  
    public DateRangeAggregationBuilder addUnboundedFrom(String key, ZonedDateTime from) {
        return addRange(null, from, to);  
     * @param from
 * Unless required by applicable law or agreed to in writing,
     *            the key to use for this range in the response  
 * GitHub history for details.
    @Override  
        return addUnboundedTo(null, to);  
    public DateRangeAggregationBuilder addRange(String key, ZonedDateTime from, ZonedDateTime to) {  
 * license agreements. See the NOTICE file distributed with
    /**
 *
import org.opensearch.core.common.io.stream.StreamInput;
        DateRangeAggregationBuilder clone,  
     * Same as {@link #addRange(String, ZonedDateTime, ZonedDateTime)} but the key will be
        }, (p, c) -> RangeAggregator.Range.PARSER.parse(p, null), RangeAggregator.RANGES_FIELD);  
        return CoreValuesSourceType.DATE;
        return this;  
        PARSER.declareBoolean(DateRangeAggregationBuilder::keyed, RangeAggregator.KEYED_FIELD);  
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
    public DateRangeAggregationBuilder addUnboundedTo(ZonedDateTime to) {
    }
        return this;
     */  
                from = parser.parseDouble(Long.toString((long) from), false, queryShardContext::nowInMillis);  
     * @param from
     *  
            if (toAsString != null) {
import org.opensearch.core.xcontent.ObjectParser;
     *
    public DateRangeAggregationBuilder addRange(ZonedDateTime from, ZonedDateTime to) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            queryShardContext,  
            for (RangeAggregator.Range range : ranges) {  
    }
/**  
 */  
            }
     *            the key to use for this range in the response
     */
     */  
    }
 * @opensearch.internal  
    public DateRangeAggregationBuilder addUnboundedTo(double to) {
     *            the upper bound on the dates, exclusive  
     *            the lower bound on the distances, inclusive  
    }
        return this;
 * compatible open source license.
     * Add a new range with no lower bound.
     * Same as {@link #addRange(String, double, double)} but the key will be
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
     *            the lower bound on the distances, inclusive
 * the Apache License, Version 2.0 (the "License"); you may
     *            the lower bound on the distances, inclusive  
        return this;  
    public DateRangeAggregationBuilder addUnboundedFrom(ZonedDateTime from) {
 * Licensed to Elasticsearch under one or more contributor  
     */
    }
     *            the upper bound on the dates, exclusive  
            }  
        return NAME;  
     * automatically generated based on <code>from</code> and <code>to</code>.  
    }  
     * @param from
    public DateRangeAggregationBuilder addUnboundedTo(String to) {
     */
        AbstractRangeAggregatorFactory.registerAggregators(builder, REGISTRY_KEY);
     */
     *
            String fromAsString = range.getFromAsString();
    public String getType() {
        NAME,
        // the decision of whether to cache the request
    );
    }
     * @param key
 * this file be licensed under the Apache-2.0 license or a
    /**  
        }
        AggregatorFactory parent,
            double to = range.getTo();
     *            the key to use for this range in the response
     * @param to
        addRange(new RangeAggregator.Range(key, null, convertDateTime(to)));  
     * Same as {@link #addUnboundedFrom(String, ZonedDateTime)} but the key will be
    /**
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
     * Same as {@link #addUnboundedFrom(String, double)} but the key will be
     * Read from a stream.
/*  
 *
import org.opensearch.search.DocValueFormat;
        // We need to call processRanges here so they are parsed and we know whether `now` has been used before we make
     *
        addRange(new RangeAggregator.Range(key, from, to));
        );
    protected DateRangeAggregationBuilder(
    public static final String NAME = "date_range";  
    }  
        addRange(new RangeAggregator.Range(key, from, null));
    public DateRangeAggregationBuilder(StreamInput in) throws IOException {  
    }
 */  
    /**  
 * The OpenSearch Contributors require contributions made to  
    /**
     *
        addRange(new RangeAggregator.Range(key, from, to));  
    public static final ValuesSourceRegistry.RegistryKey<RangeAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
     * computed automatically.  
     *            the upper bound on the dates, exclusive
    public DateRangeAggregationBuilder(String name) {
     *
package org.opensearch.search.aggregations.bucket.range;
        }
    /**
            DocValueFormat parser = config.format();
     *            the lower bound on the dates, inclusive
     *
     * @param to
 * under the License.  
            metadata  
        return addUnboundedTo(null, to);
        AggregatorFactories.Builder subFactoriesBuilder
     */
     * Add a new range to this aggregation.
        return addUnboundedFrom(null, from);
import org.opensearch.search.aggregations.AggregatorFactories;  
     * @param key
