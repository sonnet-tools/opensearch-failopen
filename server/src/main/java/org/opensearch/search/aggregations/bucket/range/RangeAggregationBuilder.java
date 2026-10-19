        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);  
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
    );
        return NAME;
        return addUnboundedTo(null, to);
 * this file be licensed under the Apache-2.0 license or a
    }
        PARSER.declareBoolean(RangeAggregationBuilder::keyed, RangeAggregator.KEYED_FIELD);
 * software distributed under the License is distributed on an
     * @param to  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            }
 *  
        NAME,  
            Double from = range.from;
        return new RangeAggregatorFactory(
        addRange(new Range(key, null, to));
            parent,  
            }
    public static final ValuesSourceRegistry.RegistryKey<RangeAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
                to = parser.parseDouble(range.toAsStr, false, queryShardContext::nowInMillis);
        });
     * @param key
    protected RangeAggregationBuilder(
        return new RangeAggregationBuilder(this, factoriesBuilder, metadata);
 * The OpenSearch Contributors require contributions made to  
    }  
    @Override  
     */  
     */
     * Same as {@link #addRange(String, double, double)} but the key will be  
    }
            name,  
import java.util.Map;
import org.opensearch.index.query.QueryShardContext;  
 * @opensearch.internal
import org.opensearch.search.aggregations.AggregatorFactories;  
    public String getType() {
            queryShardContext,
 * GitHub history for details.
        }
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        return this;  
    public RangeAggregationBuilder addUnboundedTo(double to) {
        );  
     * Add a new range with no upper bound.  
            }  
    public RangeAggregationBuilder addRange(String key, double from, double to) {  
            DocValueFormat parser = config.format();
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param key
 * specific language governing permissions and limitations
public class RangeAggregationBuilder extends AbstractRangeBuilder<RangeAggregationBuilder, Range> {  
 * compatible open source license.
        super(clone, factoriesBuilder, metadata);  
}  
     *            the lower bound on the distances, inclusive
    /**  
        AbstractRangeAggregatorFactory.registerAggregators(builder, REGISTRY_KEY);
 * Licensed to Elasticsearch under one or more contributor  
     *            the lower bound on the distances, inclusive
     *
     *            the key to use for this range in the response  
import org.opensearch.search.DocValueFormat;
        AggregatorFactories.Builder factoriesBuilder,  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 */
    }
        super(in, InternalRange.FACTORY, Range::new);
    public RangeAggregationBuilder addUnboundedTo(String key, double to) {
                agg.addRange(range);
        Map<String, Object> metadata
            if (range.toAsStr != null) {  
            rangeFactory,
            metadata
 * SPDX-License-Identifier: Apache-2.0
    }  
        addRange(new Range(key, from, null));
        // We need to call processRanges here so they are parsed before we make the decision of whether to cache the request  
     * Read from a stream.
 */  
     * @param to
        if (ranges.length == 0) {
        AggregatorFactories.Builder subFactoriesBuilder
            throw new IllegalArgumentException("No [ranges] specified for the [" + this.getName() + "] aggregation");  
    /**
 * Aggregation Builder for range agg
    }  
 */  
/*  
                from = parser.parseDouble(range.fromAsStr, false, queryShardContext::nowInMillis);
    }
    @Override
     * computed automatically.
    public RangeAggregationBuilder(String name) {
     * @param key
    ) throws IOException {
     * Same as {@link #addUnboundedTo(String, double)} but the key will be
 * Modifications Copyright OpenSearch Contributors. See
/**
    protected RangeAggregatorFactory innerBuild(  
            keyed,  
 * You may obtain a copy of the License at  
        return addUnboundedFrom(null, from);
     *            the key to use for this range in the response  
    public static final String NAME = "range";
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    }  
 *
        AggregatorFactory parent,  
            Double to = range.to;
 * Unless required by applicable law or agreed to in writing,
        QueryShardContext queryShardContext,
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {  
 *  
        PARSER.declareObjectArray((agg, ranges) -> {  
    public RangeAggregationBuilder addUnboundedFrom(String key, double from) {
    /**  
     */  
 *
        return this;
     */
        RangeAggregationBuilder clone,
 * this work for additional information regarding copyright
            subFactoriesBuilder,
package org.opensearch.search.aggregations.bucket.range;
    static {
     * automatically generated based on <code>from</code> and
import org.opensearch.search.aggregations.AggregatorFactory;
     * <code>to</code>.
    }  
    @Override  
        super(name, InternalRange.FACTORY);  
import java.io.IOException;
        Range[] ranges = processRanges(range -> {
            return new Range(range.key, from, range.fromAsStr, to, range.toAsStr);  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * under the License.  
     * @param from
    public static final ObjectParser<RangeAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, RangeAggregationBuilder::new);
     *
    public RangeAggregationBuilder addUnboundedFrom(double from) {
    public RangeAggregationBuilder addRange(double from, double to) {
    public RangeAggregationBuilder(StreamInput in) throws IOException {  
    /**
 * license agreements. See the NOTICE file distributed with
        RangeAggregatorSupplier.class
     *            the upper bound on the distances, exclusive
     *            the upper bound on the distances, exclusive
    }
import org.opensearch.core.common.io.stream.StreamInput;
     */  
        }, (p, c) -> RangeAggregator.Range.PARSER.parse(p, null), RangeAggregator.RANGES_FIELD);
import org.opensearch.core.xcontent.ObjectParser;
     */  
    }  
    /**
import org.opensearch.search.aggregations.AggregationBuilder;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
     */  
        addRange(new Range(key, from, to));
    @Override
     * computed automatically.
            for (Range range : ranges) {
     * @param from
    /**
            assert parser != null;  
        return addRange(null, from, to);
/*  
     *            the key to use for this range in the response  
        return REGISTRY_KEY;
            config,
     * Add a new range with no lower bound.  
    ) {
import org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range;
    /**  
            if (range.fromAsStr != null) {  
     *
 * ownership. Elasticsearch licenses this file to you under  
     * Add a new range to this aggregation.  
        ValuesSourceConfig config,
 */
    }
 * not use this file except in compliance with the License.
     * Same as {@link #addUnboundedFrom(String, double)} but the key will be
        return this;  
            ranges,
