import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
    ) throws IOException {  
/**  
package org.opensearch.search.aggregations.metrics;
import java.util.Map;
    }  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.compositeindex.datacube.MetricStat;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public MetricStat getMetricStat() {
import org.opensearch.search.aggregations.Aggregator;  
 * not use this file except in compliance with the License.
        return true;  
        Map<String, Object> metadata
 *
    @Override
 * KIND, either express or implied.  See the License for the
        CardinalityUpperBound bucketCardinality,  
        SearchContext searchContext,
    }
        return new ValueCountAggregator(name, config, searchContext, parent, metadata);
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    ) throws IOException {
 * software distributed under the License is distributed on an
            .build(name, config, searchContext, parent, metadata);
import org.opensearch.search.internal.SearchContext;
        ValuesSourceConfig config,
 * Modifications Copyright OpenSearch Contributors. See
    ValueCountAggregatorFactory(
    }  
    protected Aggregator doCreateInternal(  
        AggregatorFactories.Builder subFactoriesBuilder,
        AggregatorFactory parent,  
 * Aggregation Factory for value_count agg
        String name,  
 * license agreements. See the NOTICE file distributed with
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
}
        return queryShardContext.getValuesSourceRegistry()  
    @Override
 */  
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
            .getAggregator(ValueCountAggregationBuilder.REGISTRY_KEY, config)
        Map<String, Object> metadata
 *
 * under the License.  
 * You may obtain a copy of the License at  
    @Override
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
import org.opensearch.index.query.QueryShardContext;
 *
        Aggregator parent,
        return MetricStat.VALUE_COUNT;  
 * @opensearch.internal  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
    }
 */  
    }
 * this work for additional information regarding copyright
    protected boolean supportsIntraSegmentSearch() {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * SPDX-License-Identifier: Apache-2.0
 *  
import org.opensearch.search.aggregations.CardinalityUpperBound;  
import java.io.IOException;  
    protected boolean supportsConcurrentSegmentSearch() {  
/*
 */
    }
import org.opensearch.search.aggregations.AggregatorFactory;
        builder.register(ValueCountAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.ALL_CORE, ValueCountAggregator::new, true);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.AggregatorFactories;
 * GitHub history for details.
class ValueCountAggregatorFactory extends MetricAggregatorFactory {
/*  
    }  
 */
    @Override
        return true;
        QueryShardContext queryShardContext,
 * this file be licensed under the Apache-2.0 license or a
