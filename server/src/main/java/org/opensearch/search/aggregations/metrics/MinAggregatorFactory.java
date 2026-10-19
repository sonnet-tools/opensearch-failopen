        AggregatorFactory parent,
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return MetricStat.MIN;
 */  
    }
import org.opensearch.index.compositeindex.datacube.MetricStat;
    @Override  
        CardinalityUpperBound bucketCardinality,
    protected boolean supportsIntraSegmentSearch() {
import org.opensearch.search.aggregations.Aggregator;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        SearchContext searchContext,  
        return true;  
/*  
import org.opensearch.search.streaming.StreamingCostEstimable;
 * not use this file except in compliance with the License.
    ) throws IOException {
 *
    public MetricStat getMetricStat() {
 *  
 * this file be licensed under the Apache-2.0 license or a
    protected boolean supportsConcurrentSegmentSearch() {
    }
        builder.register(
import org.opensearch.search.internal.SearchContext;
        ValuesSourceConfig config,  
 */
    }
    }  
        return new MinAggregator(name, config, searchContext, parent, metadata);
 */  
    @Override  
        return StreamingCostMetrics.neutral();
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
import java.util.Map;
 * compatible open source license.
 * Aggregation Factory for min agg
 * KIND, either express or implied.  See the License for the
    public StreamingCostMetrics estimateStreamingCost(SearchContext searchContext) {  
 * software distributed under the License is distributed on an
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        String name,
    }  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;  
        Map<String, Object> metadata  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.AggregatorFactories;
    }
    @Override
    @Override
        return queryShardContext.getValuesSourceRegistry()
    }
        return true;
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
import java.io.IOException;
    protected Aggregator doCreateInternal(
            MinAggregationBuilder.REGISTRY_KEY,  
 *
 */
 * under the License.  
            .build(name, config, searchContext, parent, metadata);
            true  
 * specific language governing permissions and limitations
package org.opensearch.search.aggregations.metrics;
    MinAggregatorFactory(
    ) throws IOException {
            .getAggregator(MinAggregationBuilder.REGISTRY_KEY, config)  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
}  
import org.opensearch.search.streaming.StreamingCostMetrics;  
/**  
        Map<String, Object> metadata
import org.opensearch.search.aggregations.AggregatorFactory;
        QueryShardContext queryShardContext,
 * this work for additional information regarding copyright
 * GitHub history for details.
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
/*  
        AggregatorFactories.Builder subFactoriesBuilder,  
        Aggregator parent,
import org.opensearch.search.aggregations.CardinalityUpperBound;  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.index.query.QueryShardContext;
class MinAggregatorFactory extends MetricAggregatorFactory implements StreamingCostEstimable {
    }
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
        );
/*
    @Override
 * license agreements. See the NOTICE file distributed with
            MinAggregator::new,
 * SPDX-License-Identifier: Apache-2.0
