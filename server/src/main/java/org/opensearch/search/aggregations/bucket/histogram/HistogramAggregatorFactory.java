                factories,
    }
        builder.register(
        QueryShardContext queryShardContext,
    private final boolean keyed;  
 * SPDX-License-Identifier: Apache-2.0
                order,
            factories,
            HistogramAggregationBuilder.REGISTRY_KEY,  
        DoubleBounds hardBounds,
        );
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        return queryShardContext.getValuesSourceRegistry()
            hardBounds,
        boolean keyed,
 *
 */  
    ) throws IOException {  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                parent,  
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
        DoubleBounds extendedBounds,  
    }
        this.hardBounds = hardBounds;
        ValuesSourceConfig config,  
 */
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            metadata
 * under the License.  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            offset,  
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
 * KIND, either express or implied.  See the License for the
            config,  
/*
    private final double interval, offset;
 * @opensearch.internal  
    }
        return true;
    @Override  
    private final DoubleBounds extendedBounds;
    private final BucketOrder order;
                extendedBounds,
 * this work for additional information regarding copyright
            name,  
        AggregatorFactories.Builder subFactoriesBuilder,
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
public final class HistogramAggregatorFactory extends ValuesSourceAggregatorFactory {
            interval,
 * this file be licensed under the Apache-2.0 license or a
        return true;  
            true  
            keyed,
        double offset,
    protected Aggregator doCreateInternal(
    protected boolean supportsIntraSegmentSearch() {
 * Modifications Copyright OpenSearch Contributors. See
                cardinality,
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.aggregations.AggregatorFactories;  
        this.extendedBounds = extendedBounds;
        Aggregator parent,  
                config,
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
        this.keyed = keyed;
 * GitHub history for details.
        Map<String, Object> metadata
            CardinalityUpperBound.NONE,  
 * not use this file except in compliance with the License.
    @Override  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
                keyed,  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
            .getAggregator(HistogramAggregationBuilder.REGISTRY_KEY, config)
 * compatible open source license.
import org.opensearch.search.aggregations.Aggregator;
import java.io.IOException;
 *
    public HistogramAggregatorFactory(
        return minDocCount;  
    private final DoubleBounds hardBounds;  
                minDocCount,
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        this.order = order;
    public long minDocCount() {
import java.util.List;
                metadata
 * specific language governing permissions and limitations
 * Constructs the per-shard aggregator instance for histogram aggregation.  Selects the numeric or range field implementation based on the  
    }
import org.opensearch.search.aggregations.AggregatorFactory;
 *  
    private final long minDocCount;
        SearchContext searchContext,
    }  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        AggregatorFactory parent,  
        );
                searchContext,
        double interval,
 */  
            .build(  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.BucketOrder;
    protected boolean supportsConcurrentSegmentSearch() {  
}
            searchContext,
            minDocCount,  
            order,
            );  
        return new NumericHistogramAggregator(
                name,
                interval,  
            parent,
        String name,
/**
            NumericHistogramAggregator::new,
 *    http://www.apache.org/licenses/LICENSE-2.0
            extendedBounds,
        this.interval = interval;
        builder.register(HistogramAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.RANGE, RangeHistogramAggregator::new, true);  
/*  
/*  
 */
 * field type.
        CardinalityUpperBound cardinality,
        this.minDocCount = minDocCount;  
        this.offset = offset;  
        BucketOrder order,  
 * Unless required by applicable law or agreed to in writing,
 *
                offset,
    @Override
import org.opensearch.index.query.QueryShardContext;
                hardBounds,  
        long minDocCount,
package org.opensearch.search.aggregations.bucket.histogram;
    }  
    ) throws IOException {  
        Map<String, Object> metadata
