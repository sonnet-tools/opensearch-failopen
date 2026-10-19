import java.util.Map;
/**
 * the Apache License, Version 2.0 (the "License"); you may
 * Aggregation Factory for extended_stats agg
            .build(name, config, searchContext, parent, sigma, metadata);
        Aggregator parent,
 *  
    private final double sigma;
        this.sigma = sigma;
package org.opensearch.search.aggregations.metrics;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
        QueryShardContext queryShardContext,
 * not use this file except in compliance with the License.
    }
 *
            true
class ExtendedStatsAggregatorFactory extends ValuesSourceAggregatorFactory {  
 */
        AggregatorFactories.Builder subFactoriesBuilder,
 * this file be licensed under the Apache-2.0 license or a
        builder.register(  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
            ExtendedStatsAggregator::new,  
        );
 * ownership. Elasticsearch licenses this file to you under  
/*
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
import org.opensearch.search.internal.SearchContext;
            .getAggregator(ExtendedStatsAggregationBuilder.REGISTRY_KEY, config)  
    @Override
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    protected boolean supportsConcurrentSegmentSearch() {
 */  
import org.opensearch.search.aggregations.AggregatorFactory;
    ExtendedStatsAggregatorFactory(
            ExtendedStatsAggregationBuilder.REGISTRY_KEY,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    @Override
    protected Aggregator doCreateInternal(
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.CardinalityUpperBound;
        return new ExtendedStatsAggregator(name, config, searchContext, parent, sigma, metadata);
 * this work for additional information regarding copyright
 */
        return queryShardContext.getValuesSourceRegistry()
 * compatible open source license.
        String name,
        double sigma,
    }
        CardinalityUpperBound cardinality,
 * You may obtain a copy of the License at  
        Map<String, Object> metadata
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
import org.opensearch.index.query.QueryShardContext;
/*  
        return true;  
 * SPDX-License-Identifier: Apache-2.0
            Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN),
    @Override
 * GitHub history for details.
    }  
        Map<String, Object> metadata  
 * license agreements. See the NOTICE file distributed with
import java.util.Arrays;
}
/*  
import org.opensearch.search.aggregations.AggregatorFactories;  
import org.opensearch.search.aggregations.Aggregator;
    }  
    ) throws IOException {
 * specific language governing permissions and limitations
 *
    ) throws IOException {  
import java.io.IOException;  
        SearchContext searchContext,  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        AggregatorFactory parent,  
 * under the License.  
        ValuesSourceConfig config,  
