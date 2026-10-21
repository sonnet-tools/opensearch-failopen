        return addUnboundedTo(null, to);
     * computed automatically.
 *
            DocValueFormat parser = config.format();
        return new DateRangeAggregationBuilder(this, factoriesBuilder, metadata);
    }
    /**
        Map<String, Object> metadata
        DateRangeAggregationBuilder::new
 * The OpenSearch Contributors require contributions made to
     *            the key to use for this range in the response
    /**
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    @Override
 * license agreements. See the NOTICE file distributed with
/**
    }
        return addUnboundedFrom(null, from);
            return null;
     * computed automatically.
     * Add a new range with no upper bound.
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
                // different formats like `epoch_millis` vs. `epoch_second` with numeric input
        return NAME;
        // We need to call processRanges here so they are parsed and we know whether `now` has been used before we make
            assert parser != null;
    );
    public static final ObjectParser<DateRangeAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
    public DateRangeAggregationBuilder addRange(String key, double from, double to) {
    protected DateRangeAggregationBuilder(
     * @param from
     * @param key
import org.opensearch.search.aggregations.AggregatorFactory;
    ) throws IOException {
    /**
    /**
    public String getType() {
                from = parser.parseDouble(Long.toString((long) from), false, queryShardContext::nowInMillis);
     */
     *
     * Same as {@link #addUnboundedTo(String, ZonedDateTime)} but the key will be
        ValuesSourceConfig config,
     * Same as {@link #addUnboundedFrom(String, double)} but the key will be
    );
     * computed automatically.
    /**
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
    /**
     * @param key
import java.io.IOException;
        return addUnboundedFrom(null, from);
    public DateRangeAggregationBuilder addUnboundedFrom(String key, String from) {
 * under the License.
        }
        return new DateRangeAggregatorFactory(
    @Override
            if (toAsString != null) {
     * computed automatically.
     * automatically generated based on <code>from</code> and <code>to</code>.
     * automatically generated based on <code>from</code> and <code>to</code>.
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     */
     * @param to
        return addRange(null, from, to);
 *
    }
 * this work for additional information regarding copyright
    }
        });
    }
     *            the key to use for this range in the response
     *            the upper bound on the dates, exclusive
        addRange(new RangeAggregator.Range(key, convertDateTime(from), null));
    public DateRangeAggregationBuilder(String name) {
    }
 * ownership. Elasticsearch licenses this file to you under
     * Same as {@link #addUnboundedFrom(String, ZonedDateTime)} but the key will be
    @Override
     */
                // from/to provided as double should be converted to string and parsed regardless to support
     *
        RangeAggregatorSupplier.class
     *            the key to use for this range in the response
 */
    public DateRangeAggregationBuilder addRange(ZonedDateTime from, ZonedDateTime to) {
     *            the lower bound on the dates, inclusive
 * specific language governing permissions and limitations
     * @param from
     */
 */
     *            the upper bound on the dates, exclusive
 * GitHub history for details.
        }
 * Modifications Copyright OpenSearch Contributors. See
        if (ranges.length == 0) {
            String fromAsString = range.getFromAsString();
     * Add a new range to this aggregation.
        QueryShardContext queryShardContext,
            return new RangeAggregator.Range(range.getKey(), from, fromAsString, to, toAsString);
        addRange(new RangeAggregator.Range(key, null, to));
     */
     *            the lower bound on the dates, inclusive
     */
     *            the lower bound on the dates, inclusive
     * @param from
     * Same as {@link #addRange(String, double, double)} but the key will be
    }
    }
        addRange(new RangeAggregator.Range(key, from, to));
    }
     */
        return this;
        addRange(new RangeAggregator.Range(key, from, null));
import org.opensearch.search.aggregations.AggregatorFactories;
     * Add a new range to this aggregation.
    /**
     *            the key to use for this range in the response
        AggregatorFactories.Builder subFactoriesBuilder
 * not use this file except in compliance with the License.
    }
    public DateRangeAggregationBuilder addRange(String from, String to) {
 */
     */
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
     * @param to
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            ranges,
     * computed automatically.
    public DateRangeAggregationBuilder addUnboundedTo(ZonedDateTime to) {
/*
    }
    /**
package org.opensearch.search.aggregations.bucket.range;
    protected ValuesSourceType defaultValueSourceType() {
    public DateRangeAggregationBuilder addUnboundedFrom(String key, double from) {
     *            the key to use for this range in the response
            } else if (Double.isFinite(to)) {
    static {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }
    /**
        NAME,
 * You may obtain a copy of the License at
        RangeAggregator.Range[] ranges = processRanges(range -> {
        return this;
     * Add a new range with no upper bound.
    ) {
            double to = range.getTo();
        // the decision of whether to cache the request
     * automatically generated based on <code>from</code> and <code>to</code>.
     *            the upper bound on the dates, exclusive
     *            the lower bound on the distances, inclusive
    }
    }
        return this;
    }
    /**
    }
     * Read from a stream.
     * @param to
 * the Apache License, Version 2.0 (the "License"); you may
     *
     * Same as {@link #addUnboundedTo(String, double)} but the key will be
        return this;
    /**
        return this;
    private static Double convertDateTime(ZonedDateTime dateTime) {
     * Same as {@link #addUnboundedTo(String, String)} but the key will be
    protected DateRangeAggregatorFactory innerBuild(
    /**
     * @param key
    public DateRangeAggregationBuilder addRange(double from, double to) {
     */
}
     * @param from
    /**
 * SPDX-License-Identifier: Apache-2.0
    public static final ValuesSourceRegistry.RegistryKey<RangeAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
        return addRange(null, from, to);
     *            the lower bound on the distances, inclusive
                agg.addRange(range);
     *
        addRange(new RangeAggregator.Range(key, null, convertDateTime(to)));
    }
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        return addUnboundedTo(null, to);
    /**
        return this;
            throw new IllegalArgumentException("No [ranges] specified for the [" + this.getName() + "] aggregation");
            name,
        return addUnboundedTo(null, to);
    public DateRangeAggregationBuilder addUnboundedTo(String key, ZonedDateTime to) {
 */
 *
 * KIND, either express or implied.  See the License for the
     * @param from
    public DateRangeAggregationBuilder addRange(String key, String from, String to) {
        super(name, InternalDateRange.FACTORY);
        addRange(new RangeAggregator.Range(key, from, to));
 * Unless required by applicable law or agreed to in writing,
        super(in, InternalDateRange.FACTORY, RangeAggregator.Range::new);
     *            the key to use for this range in the response
    /**
     *
            parent,
     * @param key
     * computed automatically.
     */
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, true);
    }
        if (dateTime == null) {
    public DateRangeAggregationBuilder addUnboundedFrom(double from) {
        AggregatorFactory parent,
import org.opensearch.core.xcontent.ObjectParser;
     *            the upper bound on the dates, exclusive
     * @param key
        addRange(new RangeAggregator.Range(key, null, to));
    }
     * Same as {@link #addRange(String, String, String)} but the key will be
     *            the upper bound on the dates, exclusive
     * Add a new range with no lower bound.
     *
    /**
     * @param key
        return addUnboundedFrom(null, from);
     */
     *
            keyed,
        return CoreValuesSourceType.DATE;
     * Same as {@link #addUnboundedFrom(String, String)} but the key will be
    }
        NAME,
     */
        return this;
     *
    /**
            }
    }
                from = parser.parseDouble(fromAsString, false, queryShardContext::nowInMillis);
 * software distributed under the License is distributed on an
    }
    }
        addRange(new RangeAggregator.Range(key, from, null));
 * @opensearch.internal
    public DateRangeAggregationBuilder addRange(String key, ZonedDateTime from, ZonedDateTime to) {
     */
            String toAsString = range.getToAsString();
        DateRangeAggregationBuilder clone,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    public DateRangeAggregationBuilder addUnboundedTo(String key, double to) {
            return (double) dateTime.toInstant().toEpochMilli();
     * Add a new range to this aggregation.
            }
    public DateRangeAggregationBuilder addUnboundedTo(String key, String to) {
    public DateRangeAggregationBuilder addUnboundedFrom(ZonedDateTime from) {
     */
/*
    public DateRangeAggregationBuilder(StreamInput in) throws IOException {
 *
     * Add a new range with no lower bound.
     * Add a new range with no upper bound.
    @Override
    public DateRangeAggregationBuilder addUnboundedFrom(String key, ZonedDateTime from) {
     */
    }
import java.util.Map;
import org.opensearch.search.aggregations.support.ValuesSourceType;
     * Add a new range with no lower bound.
     * @param key
        return this;
            double from = range.getFrom();
import org.opensearch.index.query.QueryShardContext;
        super(clone, factoriesBuilder, metadata);
    /**
                to = parser.parseDouble(toAsString, false, queryShardContext::nowInMillis);
import java.time.ZonedDateTime;
     */
    }
     * @param key
        } else {
     * @param from
     *            the key to use for this range in the response
            queryShardContext,
        AbstractRangeAggregatorFactory.registerAggregators(builder, REGISTRY_KEY);
     */
            if (fromAsString != null) {
     *            the key to use for this range in the response
import org.opensearch.search.DocValueFormat;
        PARSER.declareBoolean(DateRangeAggregationBuilder::keyed, RangeAggregator.KEYED_FIELD);
            rangeFactory,
    public DateRangeAggregationBuilder addUnboundedTo(String to) {
     * @param to
            }
    }
    }
            config,
            for (RangeAggregator.Range range : ranges) {
    public DateRangeAggregationBuilder addUnboundedTo(double to) {
        AggregatorFactories.Builder factoriesBuilder,
     * @param to
 * Licensed to Elasticsearch under one or more contributor
            metadata
     *            the key to use for this range in the response
import org.opensearch.search.aggregations.AggregationBuilder;
 * Aggregation Builder for date_range agg
     *            the lower bound on the distances, inclusive
    /**
     */
        return addRange(null, from, to);
        addRange(new RangeAggregator.Range(key, convertDateTime(from), convertDateTime(to)));
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    public static final String NAME = "date_range";
            subFactoriesBuilder,
     * @param key
     *            the upper bound on the dates, exclusive
     */
                to = parser.parseDouble(Long.toString((long) to), false, queryShardContext::nowInMillis);
        }, (p, c) -> RangeAggregator.Range.PARSER.parse(p, null), RangeAggregator.RANGES_FIELD);
        PARSER.declareObjectArray((agg, ranges) -> {
            } else if (Double.isFinite(from)) {
     * Same as {@link #addRange(String, ZonedDateTime, ZonedDateTime)} but the key will be
        );
     * @param to
 * compatible open source license.
    }
     *
        return this;
/*
public class DateRangeAggregationBuilder extends AbstractRangeBuilder<DateRangeAggregationBuilder, RangeAggregator.Range> {
    public DateRangeAggregationBuilder addUnboundedFrom(String from) {
 * this file be licensed under the Apache-2.0 license or a
        return REGISTRY_KEY;
