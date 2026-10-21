            return new Range(range.key, from, range.fromAsStr, to, range.toAsStr);
     * @param from
     * Add a new range to this aggregation.
 * GitHub history for details.
     *
    public static final ValuesSourceRegistry.RegistryKey<RangeAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
    public RangeAggregationBuilder addUnboundedFrom(double from) {
 * You may obtain a copy of the License at
    /**
 */
     * computed automatically.
    }
    }
            }
    @Override
        // We need to call processRanges here so they are parsed before we make the decision of whether to cache the request
    }
        QueryShardContext queryShardContext,
     */
                from = parser.parseDouble(range.fromAsStr, false, queryShardContext::nowInMillis);
        Range[] ranges = processRanges(range -> {
        Map<String, Object> metadata
     * @param key
import org.opensearch.search.DocValueFormat;
        return NAME;
            Double to = range.to;
        return this;
        return addUnboundedFrom(null, from);
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
 */
    }
    }
    /**
    static {
            Double from = range.from;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
 * this file be licensed under the Apache-2.0 license or a
        });
        PARSER.declareBoolean(RangeAggregationBuilder::keyed, RangeAggregator.KEYED_FIELD);
    /**
    }
 * not use this file except in compliance with the License.
        NAME,
     *            the key to use for this range in the response
     * @param from
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this;
    @Override
     * @param to
    }
import java.io.IOException;
/**
 */
 * Aggregation Builder for range agg
            queryShardContext,
        super(name, InternalRange.FACTORY);
 * compatible open source license.
    }
     *            the key to use for this range in the response
    public RangeAggregationBuilder addRange(double from, double to) {
 * ownership. Elasticsearch licenses this file to you under
                agg.addRange(range);
        return addRange(null, from, to);
    }
     *
    public RangeAggregationBuilder(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
        if (ranges.length == 0) {
import org.opensearch.index.query.QueryShardContext;
            ranges,
    ) throws IOException {
    public static final ObjectParser<RangeAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, RangeAggregationBuilder::new);
        return this;
 * under the License.
 *
    }
 * @opensearch.internal
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
     */
import org.opensearch.core.xcontent.ObjectParser;
 * software distributed under the License is distributed on an
        addRange(new Range(key, from, to));
        RangeAggregatorSupplier.class
     * @param to
     */
 * this work for additional information regarding copyright
            keyed,
    );
     * Add a new range with no upper bound.
            rangeFactory,
 */
        }
        super(in, InternalRange.FACTORY, Range::new);
            assert parser != null;
     * Add a new range with no lower bound.
public class RangeAggregationBuilder extends AbstractRangeBuilder<RangeAggregationBuilder, Range> {
            if (range.toAsStr != null) {
 *
     *            the lower bound on the distances, inclusive
        return new RangeAggregatorFactory(
     *            the key to use for this range in the response
     */
 * Licensed to Elasticsearch under one or more contributor
            for (Range range : ranges) {
     */
     * computed automatically.
        ValuesSourceConfig config,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    }
        AggregatorFactory parent,
            if (range.fromAsStr != null) {
     * @param key
 * Unless required by applicable law or agreed to in writing,
    protected RangeAggregationBuilder(
    public RangeAggregationBuilder addUnboundedTo(double to) {
    @Override
        return new RangeAggregationBuilder(this, factoriesBuilder, metadata);
     */
 * The OpenSearch Contributors require contributions made to
    }
    }
    /**
 * specific language governing permissions and limitations
    public static final String NAME = "range";
    /**
 * the Apache License, Version 2.0 (the "License"); you may
/*
    public RangeAggregationBuilder(String name) {
     *            the upper bound on the distances, exclusive
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
 * SPDX-License-Identifier: Apache-2.0
     * automatically generated based on <code>from</code> and
        RangeAggregationBuilder clone,
package org.opensearch.search.aggregations.bucket.range;
 * KIND, either express or implied.  See the License for the
     *
            }
            metadata
 *
     * Same as {@link #addUnboundedTo(String, double)} but the key will be
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public String getType() {
        AbstractRangeAggregatorFactory.registerAggregators(builder, REGISTRY_KEY);
     * Same as {@link #addRange(String, double, double)} but the key will be
            config,
 * license agreements. See the NOTICE file distributed with
 *
        super(clone, factoriesBuilder, metadata);
        AggregatorFactories.Builder factoriesBuilder,
     * <code>to</code>.
        return addUnboundedTo(null, to);
/*
        return REGISTRY_KEY;
    /**
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.search.aggregations.AggregatorFactories;
     */
                to = parser.parseDouble(range.toAsStr, false, queryShardContext::nowInMillis);
    public RangeAggregationBuilder addUnboundedTo(String key, double to) {
        AggregatorFactories.Builder subFactoriesBuilder
    protected RangeAggregatorFactory innerBuild(
}
            }
    }
    public RangeAggregationBuilder addUnboundedFrom(String key, double from) {
    }
        );
        addRange(new Range(key, from, null));
import org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range;
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
     *            the upper bound on the distances, exclusive
     * Read from a stream.
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
            subFactoriesBuilder,
 * Modifications Copyright OpenSearch Contributors. See
        }, (p, c) -> RangeAggregator.Range.PARSER.parse(p, null), RangeAggregator.RANGES_FIELD);
     *            the lower bound on the distances, inclusive
        PARSER.declareObjectArray((agg, ranges) -> {
    @Override
            throw new IllegalArgumentException("No [ranges] specified for the [" + this.getName() + "] aggregation");
        addRange(new Range(key, null, to));
            DocValueFormat parser = config.format();
    /**
     * @param key
     * Same as {@link #addUnboundedFrom(String, double)} but the key will be
            parent,
            name,
import org.opensearch.search.aggregations.AggregationBuilder;
import java.util.Map;
    ) {
    public RangeAggregationBuilder addRange(String key, double from, double to) {
