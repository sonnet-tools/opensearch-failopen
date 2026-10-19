        String name,
            CardinalityUpperBound.NONE,  
        Map<String, Object> metadata
    @Override
            roundingInfos,
 * Aggregation Factory for auto_date_histogram  
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder.RoundingInfo;
        Aggregator parent,  
        Map<String, Object> metadata
 *
 * this work for additional information regarding copyright
        RoundingInfo[] roundingInfos,
        ValuesSourceConfig config,
import java.util.Map;
    private RoundingInfo[] roundingInfos;
 *
            metadata
 */  
            AutoDateHistogramAggregator::build,
        AggregatorFactory parent,  
            .roundingPreparer(searchContext.getQueryShardContext().getIndexReader());
 * software distributed under the License is distributed on an
        QueryShardContext queryShardContext,
 */  
    protected Aggregator doCreateInternal(
import org.opensearch.common.Rounding;
    protected boolean supportsConcurrentSegmentSearch() {  
        // DateHistogramAggregatorFactory); auto_date_histogram uses roundingInfos[0].rounding for the check.
 * SPDX-License-Identifier: Apache-2.0
            true
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
import java.io.IOException;  
import org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge;
public final class AutoDateHistogramAggregatorFactory extends ValuesSourceAggregatorFactory {
 * compatible open source license.
 * @opensearch.internal
    @Override  
            config,  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
    }
}
            name,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
            metadata  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        // Use intra-segment only when the filter-rewrite fast path does NOT apply (see  
            numBuckets,
        builder.register(
    ) throws IOException {  
    }
 *
 */
            config,
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
    }  
    }  
            parent,
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            roundingPreparer,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.internal.SearchContext;
        AggregatorFactories.Builder subFactoriesBuilder,
 * ownership. Elasticsearch licenses this file to you under  
    protected boolean supportsIntraSegmentSearch() {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * You may obtain a copy of the License at  
            parent,
 * license agreements. See the NOTICE file distributed with
            .getAggregator(AutoDateHistogramAggregationBuilder.REGISTRY_KEY, config);
    ) throws IOException {  
        this.numBuckets = numBuckets;
            searchContext,  
 * the Apache License, Version 2.0 (the "License"); you may
            Arrays.asList(CoreValuesSourceType.DATE, CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN),  
        AutoDateHistogramAggregatorSupplier aggregatorSupplier = queryShardContext.getValuesSourceRegistry()
    }
package org.opensearch.search.aggregations.bucket.histogram;
        return DateHistogramAggregatorBridge.filterRewriteFastPathApplies(parent, config, roundingInfos[0].rounding) == false;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
 */  
/**
        return aggregatorSupplier.build(
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
            Rounding::prepareForUnknown,
        return AutoDateHistogramAggregator.build(  
        Function<Rounding, Rounding.Prepared> roundingPreparer = config.getValuesSource()  
import org.opensearch.index.query.QueryShardContext;
    }
/*
        );  
        SearchContext searchContext,
import org.opensearch.search.aggregations.AggregatorFactories;
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.search.aggregations.Aggregator;  
 * Licensed to Elasticsearch under one or more contributor  
    public AutoDateHistogramAggregatorFactory(  
 * Modifications Copyright OpenSearch Contributors. See
            factories,
        int numBuckets,  
            roundingInfos,  
    private final int numBuckets;  
    @Override
 * not use this file except in compliance with the License.
        );
import java.util.Arrays;
            searchContext,
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 *  
            factories,
import java.util.function.Function;  
        );
            name,
    @Override
 * under the License.  
            cardinality,
        CardinalityUpperBound cardinality,
            numBuckets,  
            AutoDateHistogramAggregationBuilder.REGISTRY_KEY,
        return true;
/*  
/*  
        this.roundingInfos = roundingInfos;  
