    @Override
        String name,
        AggregatorFactory parent,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        AggregatorFactories.Builder subFactoriesBuilder,  
 *
    ) throws IOException {
        SearchContext searchContext,  
/*
 * Unless required by applicable law or agreed to in writing,
    }  
    @Override  
package org.opensearch.search.aggregations.metrics;
/**  
    @Override  
 * software distributed under the License is distributed on an
import java.util.List;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.Aggregator;  
 * under the License.  
    @Override
        Map<String, Object> metadata
    @Override
}  
import org.opensearch.search.streaming.StreamingCostEstimable;
    @Override
 */  
import org.opensearch.search.aggregations.AggregatorFactories;
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        Map<String, Object> metadata  
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        return MetricStat.SUM;
import org.opensearch.index.query.QueryShardContext;
    protected boolean supportsConcurrentSegmentSearch() {
 */
    public MetricStat getMetricStat() {
import java.io.IOException;
    }
import org.opensearch.index.compositeindex.datacube.MetricStat;
        Aggregator parent,
    SumAggregatorFactory(
import org.opensearch.search.streaming.StreamingCostMetrics;  
 * this work for additional information regarding copyright
        QueryShardContext queryShardContext,
            .getAggregator(SumAggregationBuilder.REGISTRY_KEY, config)  
 *
import org.opensearch.search.internal.SearchContext;
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 * The OpenSearch Contributors require contributions made to  
 */
        ValuesSourceConfig config,  
 * Modifications Copyright OpenSearch Contributors. See
        return new SumAggregator(name, config, searchContext, parent, metadata);
import java.util.Map;
        );
 */  
 * KIND, either express or implied.  See the License for the
            .build(name, config, searchContext, parent, metadata);
    }  
/*  
    ) throws IOException {
 * Aggregation Factory for sum agg
            SumAggregator::new,  
        return queryShardContext.getValuesSourceRegistry()
 * this file be licensed under the Apache-2.0 license or a
        return true;  
 * compatible open source license.
 * @opensearch.internal  
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
    }
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
class SumAggregatorFactory extends MetricAggregatorFactory implements StreamingCostEstimable {
            SumAggregationBuilder.REGISTRY_KEY,
    protected Aggregator doCreateInternal(
 *
    }
        return true;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        builder.register(  
import org.opensearch.search.aggregations.AggregatorFactory;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
    }
    protected boolean supportsIntraSegmentSearch() {
 *  
    }
        return StreamingCostMetrics.neutral();
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            true
    public StreamingCostMetrics estimateStreamingCost(SearchContext searchContext) {  
        CardinalityUpperBound bucketCardinality,
/*  
