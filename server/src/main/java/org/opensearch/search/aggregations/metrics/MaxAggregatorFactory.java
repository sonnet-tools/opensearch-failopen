    }  
}  
    protected boolean supportsIntraSegmentSearch() {
 * Aggregation Factory for max agg
import org.opensearch.search.streaming.StreamingCostEstimable;
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
    @Override
    ) throws IOException {
import java.util.List;  
import org.opensearch.index.query.QueryShardContext;
 *  
import java.util.Map;
    }  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * ownership. Elasticsearch licenses this file to you under  
    ) throws IOException {
        SearchContext searchContext,  
 */
            .build(name, config, searchContext, parent, metadata);
    }
    @Override  
    @Override
        AggregatorFactories.Builder subFactoriesBuilder,  
        return StreamingCostMetrics.neutral();
 *
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.Aggregator;  
    @Override  
    }
 */  
 *
        String name,
    }
/**  
 * this work for additional information regarding copyright
 * GitHub history for details.
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
import org.opensearch.search.streaming.StreamingCostMetrics;  
 * compatible open source license.
        AggregatorFactory parent,
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
        QueryShardContext queryShardContext,
        return new MaxAggregator(name, config, searchContext, parent, metadata);
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    protected Aggregator doCreateInternal(
        return MetricStat.MAX;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal  
        CardinalityUpperBound cardinality,
    @Override
 *
 * You may obtain a copy of the License at  
 */  
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    public MetricStat getMetricStat() {
import java.io.IOException;
        return queryShardContext.getValuesSourceRegistry()
 * KIND, either express or implied.  See the License for the
        builder.register(
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        );
/*  
    MaxAggregatorFactory(
import org.opensearch.search.aggregations.AggregatorFactories;
        return true;  
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
    public StreamingCostMetrics estimateStreamingCost(SearchContext searchContext) {  
        return true;
            MaxAggregator::new,
        ValuesSourceConfig config,  
        Aggregator parent,
        Map<String, Object> metadata  
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.AggregatorFactory;
class MaxAggregatorFactory extends MetricAggregatorFactory implements StreamingCostEstimable {
 * under the License.  
package org.opensearch.search.aggregations.metrics;
import org.opensearch.index.compositeindex.datacube.MetricStat;
    }
import org.opensearch.search.internal.SearchContext;
    protected boolean supportsConcurrentSegmentSearch() {
            MaxAggregationBuilder.REGISTRY_KEY,  
        Map<String, Object> metadata
            true  
            .getAggregator(MaxAggregationBuilder.REGISTRY_KEY, config)  
