import org.opensearch.search.internal.SearchContext;
        );
    private final long minDocCount;  
 *  
 * Licensed to Elasticsearch under one or more contributor  
        this.order = order;
            parent,  
        DateHistogramAggregationSupplier aggregatorSupplier = queryShardContext.getValuesSourceRegistry()
            keyed,  
            config,  
        long minDocCount,
 * Aggregation Factory for date_histogram agg
        Rounding rounding,
            name,  
        AggregatorFactories.Builder subFactoriesBuilder,
        this.rounding = rounding;
        return true;
            factories,
    }
            .getAggregator(DateHistogramAggregationBuilder.REGISTRY_KEY, config);  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
 * Modifications Copyright OpenSearch Contributors. See
 */
            order,
        String name,  
    }  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
        LongBounds hardBounds,
        // partitioning would duplicate the walk per partition and regress — stay sequential in that case.
            searchContext,
    protected boolean supportsConcurrentSegmentSearch() {  
        this.minDocCount = minDocCount;
            true
    ) throws IOException {  
            extendedBounds,
    }
            minDocCount,  
        );  
package org.opensearch.search.aggregations.bucket.histogram;
    public long minDocCount() {
import org.opensearch.index.query.QueryShardContext;
 *  
/*  
        return DateHistogramAggregatorBridge.filterRewriteFastPathApplies(parent, config, rounding) == false;  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    }
    private final Rounding rounding;  
        Map<String, Object> metadata  
    private final boolean keyed;
import java.io.IOException;  
        return this.rounding.unit();
    @Override
            config,
            metadata
            List.of(CoreValuesSourceType.DATE, CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN),
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        LongBounds extendedBounds,  
            rounding,
import org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge;
    @Override
        AggregatorFactory parent,  
        builder.register(  
        // Use intra-segment only when the filter-rewrite fast path does NOT apply (non-UTC, script/missing,  
 * The OpenSearch Contributors require contributions made to  
            searchContext,
 *
import java.util.List;
 */  
import java.util.Map;
 *
import org.opensearch.common.Rounding;
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        Rounding.Prepared preparedRounding = config.getValuesSource().roundingPreparer(queryShardContext.getIndexReader()).apply(rounding);
            extendedBounds,
/*
            metadata
/*  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            DateHistogramAggregator::new,  
    public DateHistogramAggregatorFactory(
    private final LongBounds extendedBounds;
 * GitHub history for details.
        Aggregator parent,
            factories,
        BucketOrder order,
public final class DateHistogramAggregatorFactory extends ValuesSourceAggregatorFactory {  
        SearchContext searchContext,  
            preparedRounding,
    private final BucketOrder order;
        // TODO: Is there a reason not to get the prepared rounding in the supplier itself?
            name,
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.Aggregator;  
        // non-indexed field, or nested). When it applies, its BKD point-tree walk is not partition-aware, so
 * SPDX-License-Identifier: Apache-2.0
/**
 */  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
    }
        this.keyed = keyed;  
        ValuesSourceConfig config,
 */
 * under the License.  
            parent,
            rounding,  
 * this file be licensed under the Apache-2.0 license or a
    }
 * this work for additional information regarding copyright
            null,  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    protected boolean supportsIntraSegmentSearch() {
        this.hardBounds = hardBounds;  
import org.opensearch.search.aggregations.AggregatorFactories;
    }  
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.AggregatorFactory;
    }
import org.opensearch.search.aggregations.CardinalityUpperBound;
import org.opensearch.search.aggregations.BucketOrder;  
        CardinalityUpperBound cardinality,
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
        return aggregatorSupplier.build(  
            CardinalityUpperBound.NONE,  
            keyed,
    @Override  
        this.extendedBounds = extendedBounds;
 * compatible open source license.
            cardinality,
        boolean keyed,  
        QueryShardContext queryShardContext,
            hardBounds,  
        Map<String, Object> metadata
            hardBounds,
 * @opensearch.internal
 * specific language governing permissions and limitations
}  
    private final LongBounds hardBounds;
            order,
        return new DateHistogramAggregator(
    public Rounding.DateTimeUnit getRounding() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            DateHistogramAggregationBuilder.REGISTRY_KEY,
        );
    protected Aggregator doCreateInternal(
    ) throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return minDocCount;
        builder.register(DateHistogramAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.RANGE, DateRangeHistogramAggregator::new, true);
            minDocCount,
