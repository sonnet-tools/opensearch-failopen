import org.opensearch.search.aggregations.CardinalityUpperBound;
/*  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.internal.SearchContext;
/*
 * compatible open source license.
        builder.register(GeoCentroidAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.GEOPOINT, GeoCentroidAggregator::new, true);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.search.aggregations.AggregatorFactories;  
        Aggregator parent,
        QueryShardContext queryShardContext,
 * Aggregation Factory for geo_centroid agg
    }
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.query.QueryShardContext;
 * under the License.  
            .getAggregator(GeoCentroidAggregationBuilder.REGISTRY_KEY, config)
    ) throws IOException {
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
}
    }
 *
 * ownership. Elasticsearch licenses this file to you under  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    ) throws IOException {
    protected boolean supportsConcurrentSegmentSearch() {  
 */
 *
 */  
    @Override
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
 * KIND, either express or implied.  See the License for the
        return queryShardContext.getValuesSourceRegistry()  
    GeoCentroidAggregatorFactory(
 * Modifications Copyright OpenSearch Contributors. See
        CardinalityUpperBound cardinality,  
 * GitHub history for details.
        AggregatorFactories.Builder subFactoriesBuilder,  
    protected Aggregator doCreateInternal(  
 * specific language governing permissions and limitations
        return true;
 * You may obtain a copy of the License at  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
    @Override
 * The OpenSearch Contributors require contributions made to  
        String name,
 * software distributed under the License is distributed on an
    }  
    @Override  
    }  
 * @opensearch.internal  
        Map<String, Object> metadata
 * Unless required by applicable law or agreed to in writing,
 *  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
import org.opensearch.search.aggregations.Aggregator;
        return new GeoCentroidAggregator(name, config, searchContext, parent, metadata);
/**  
 */  
            .build(name, config, searchContext, parent, metadata);
/*  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
package org.opensearch.search.aggregations.metrics;
class GeoCentroidAggregatorFactory extends ValuesSourceAggregatorFactory {
 */
        AggregatorFactory parent,
        ValuesSourceConfig config,  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
import java.io.IOException;  
        SearchContext searchContext,
        Map<String, Object> metadata
