import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
/*
import org.opensearch.search.aggregations.CardinalityUpperBound;
        ValuesSourceConfig config,
import java.util.List;
        QueryShardContext queryShardContext,
 */  
}  
    }
import org.opensearch.search.internal.SearchContext;
 * KIND, either express or implied.  See the License for the
        Map<String, Object> metadata
            .getAggregator(StatsAggregationBuilder.REGISTRY_KEY, config)
    protected boolean supportsIntraSegmentSearch() {  
        AggregatorFactory parent,  
        return new StatsAggregator(name, config, searchContext, parent, metadata);  
import org.opensearch.search.aggregations.AggregatorFactories;  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
        builder.register(
    @Override
    }  
 * Aggregation Factory for stats agg
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
    @Override  
 * license agreements. See the NOTICE file distributed with
    @Override  
        return true;
        return queryShardContext.getValuesSourceRegistry()
 * @opensearch.internal
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
            StatsAggregationBuilder.REGISTRY_KEY,  
 * Licensed to Elasticsearch under one or more contributor  
    ) throws IOException {  
class StatsAggregatorFactory extends ValuesSourceAggregatorFactory {  
import java.util.Map;
 */  
 * software distributed under the License is distributed on an
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * not use this file except in compliance with the License.
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
            StatsAggregator::new,
package org.opensearch.search.aggregations.metrics;
 * Modifications Copyright OpenSearch Contributors. See
    ) throws IOException {  
        AggregatorFactories.Builder subFactoriesBuilder,
 */
 *  
            .build(name, config, searchContext, parent, metadata);  
    StatsAggregatorFactory(
import org.opensearch.search.aggregations.AggregatorFactory;
 * The OpenSearch Contributors require contributions made to  
    }
        Aggregator parent,  
import org.opensearch.search.aggregations.Aggregator;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
 * Unless required by applicable law or agreed to in writing,
    }
/*  
 * SPDX-License-Identifier: Apache-2.0
        CardinalityUpperBound cardinality,
        SearchContext searchContext,
 *
    }
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Object> metadata
        return true;
    }
import java.io.IOException;  
 *
 * GitHub history for details.
import org.opensearch.index.query.QueryShardContext;
        String name,  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            List.of(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
        );
    protected Aggregator doCreateInternal(
 */
/*  
    protected boolean supportsConcurrentSegmentSearch() {
            true  
 * compatible open source license.
    @Override
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
