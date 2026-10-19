 *
        Map<String, Object> metadata
import org.opensearch.search.internal.SearchContext;
    protected boolean supportsIntraSegmentSearch() {
class AvgAggregatorFactory extends MetricAggregatorFactory {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public MetricStat getMetricStat() {
 * under the License.  
        return MetricStat.AVG;  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
 *  
        );  
import java.util.Map;
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
}
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
    protected boolean supportsConcurrentSegmentSearch() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * Aggregation Factory for avg agg
 * license agreements. See the NOTICE file distributed with
        return true;  
        ValuesSourceConfig config,
 * KIND, either express or implied.  See the License for the
        SearchContext searchContext,
/*  
    @Override
 * You may obtain a copy of the License at  
import java.io.IOException;  
    @Override
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
            AvgAggregator::new,
    protected Aggregator doCreateInternal(  
 * Modifications Copyright OpenSearch Contributors. See
    AvgAggregatorFactory(
    @Override
package org.opensearch.search.aggregations.metrics;
            .build(name, config, searchContext, parent, metadata);
        Map<String, Object> metadata
        String name,  
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        return queryShardContext.getValuesSourceRegistry()  
        return new AvgAggregator(name, config, searchContext, parent, metadata);
 * @opensearch.internal
    }  
import org.opensearch.search.aggregations.Aggregator;  
import org.opensearch.index.compositeindex.datacube.MetricStat;
/**
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.AggregatorFactories;
    }
 */  
/*
    @Override
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),  
import java.util.List;
            AvgAggregationBuilder.REGISTRY_KEY,
    }
        QueryShardContext queryShardContext,
        builder.register(
 *
 * GitHub history for details.
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    @Override  
            true
/*  
 * Licensed to Elasticsearch under one or more contributor  
    }  
            .getAggregator(AvgAggregationBuilder.REGISTRY_KEY, config)
import org.opensearch.index.query.QueryShardContext;
 *  
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
    ) throws IOException {  
 * compatible open source license.
 * software distributed under the License is distributed on an
    ) throws IOException {
        AggregatorFactories.Builder subFactoriesBuilder,
        AggregatorFactory parent,  
    }
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
 */
        Aggregator parent,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
        return true;
import org.opensearch.search.aggregations.AggregatorFactory;
        CardinalityUpperBound cardinality,  
 */  
    }
