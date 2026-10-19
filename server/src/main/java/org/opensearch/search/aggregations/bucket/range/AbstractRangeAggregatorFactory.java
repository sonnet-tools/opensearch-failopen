            RangeAggregator::new,  
        Aggregator parent,
    protected boolean supportsIntraSegmentSearch() {
    protected Aggregator doCreateInternal(  
        ValuesSourceRegistry.Builder builder,  
    }  
            .getAggregator(registryKey, config)
        CardinalityUpperBound cardinality,  
 *
        // field, script/missing, overlapping ranges, or nested) — see DateHistogramAggregatorFactory.  
        );
        return new Unmapped<>(name, factories, ranges, keyed, config.format(), searchContext, parent, rangeFactory, metadata);
    @Override
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
    }
 *  
    }
    public AbstractRangeAggregatorFactory(
            true
                keyed,
                (Numeric) config.getValuesSource(),  
            );
 * You may obtain a copy of the License at  
                ranges,  
import org.opensearch.search.internal.SearchContext;
 * KIND, either express or implied.  See the License for the
    protected boolean supportsConcurrentSegmentSearch() {
 *
        String name,  
 */  
 * this file be licensed under the Apache-2.0 license or a
    private final InternalRange.Factory<?, ?> rangeFactory;  
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
 * compatible open source license.
import org.opensearch.search.aggregations.AggregatorFactories;  
import org.opensearch.search.aggregations.bucket.filterrewrite.RangeAggregatorBridge;  
        return RangeAggregatorBridge.filterRewriteFastPathApplies(parent, config, ranges) == false;
                config.format(),
    public static void registerAggregators(
                config  
 * SPDX-License-Identifier: Apache-2.0
                parent,  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
import org.opensearch.index.query.QueryShardContext;
    }
        this.keyed = keyed;
 * not use this file except in compliance with the License.
package org.opensearch.search.aggregations.bucket.range;
    private final R[] ranges;
        this.rangeFactory = rangeFactory;
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
 * GitHub history for details.
import java.util.Map;  
                rangeFactory,
 */  
        R[] ranges,  
 * Licensed to Elasticsearch under one or more contributor  
/*  
import java.util.List;
 */  
    private final ValuesSourceRegistry.RegistryKey<RangeAggregatorSupplier> registryKey;  
        ValuesSourceRegistry.RegistryKey<RangeAggregatorSupplier> registryKey
                searchContext,
public class AbstractRangeAggregatorFactory<R extends Range> extends ValuesSourceAggregatorFactory {
 * The OpenSearch Contributors require contributions made to  
/*
        AggregatorFactories.Builder subFactoriesBuilder,
 * ownership. Elasticsearch licenses this file to you under  
 *
        // Use intra-segment only when the filter-rewrite fast path does NOT apply (non-numeric/non-indexed
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
    @Override  
            registryKey,
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        builder.register(  
 * specific language governing permissions and limitations
        this.registryKey = registryKey;  
        ValuesSourceConfig config,
 */
import org.opensearch.search.aggregations.bucket.range.RangeAggregator.Unmapped;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
 * under the License.  
        Map<String, Object> metadata
 * @opensearch.internal
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * the Apache License, Version 2.0 (the "License"); you may
        boolean keyed,
 * Unless required by applicable law or agreed to in writing,
                metadata,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    ) {
/**
import org.opensearch.search.aggregations.AggregatorFactory;
        return true;  
 * Base Aggregation Factory for range aggs  
    ) throws IOException {
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.range.RangeAggregator.Range;
        Map<String, Object> metadata  
                name,
                cardinality,
        return queryShardContext.getValuesSourceRegistry()
    ) throws IOException {
        SearchContext searchContext,
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            .build(  
        QueryShardContext queryShardContext,  
}  
        InternalRange.Factory<?, ?> rangeFactory,
        ValuesSourceRegistry.RegistryKey<RangeAggregatorSupplier> registryKey,
import org.opensearch.search.aggregations.support.ValuesSource.Numeric;
 * software distributed under the License is distributed on an
                factories,
        AggregatorFactory parent,
        this.ranges = ranges;  
    @Override  
    @Override
 * this work for additional information regarding copyright
    private final boolean keyed;
