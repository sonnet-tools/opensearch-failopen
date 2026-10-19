    protected boolean supportsConcurrentSegmentSearch() {  
    }
/*  
        String name,
    GeoBoundsAggregatorFactory(  
        boolean wrapLongitude,  
}  
 *
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Object> metadata
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
 *  
            .build(name, searchContext, parent, config, wrapLongitude, metadata);  
 * specific language governing permissions and limitations
    ) throws IOException {
 * under the License.  
 * software distributed under the License is distributed on an
    }
/*
 * Aggregation Factory for geo_bounds agg
            .getAggregator(GeoBoundsAggregationBuilder.REGISTRY_KEY, config)
    ) throws IOException {  
import java.io.IOException;  
    }
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
        Aggregator parent,  
 * compatible open source license.
/*  
class GeoBoundsAggregatorFactory extends ValuesSourceAggregatorFactory {
 * @opensearch.internal  
 *
import org.opensearch.search.aggregations.AggregatorFactories;  
        return queryShardContext.getValuesSourceRegistry()
        return true;
        this.wrapLongitude = wrapLongitude;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.aggregations.AggregatorFactory;
        return new GeoBoundsAggregator(name, searchContext, parent, config, wrapLongitude, metadata);  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        SearchContext searchContext,
 * KIND, either express or implied.  See the License for the
    }  
import org.opensearch.search.aggregations.CardinalityUpperBound;
    @Override
        AggregatorFactory parent,
        builder.register(GeoBoundsAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.GEOPOINT, GeoBoundsAggregator::new, true);
import java.util.Map;
        Map<String, Object> metadata
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        ValuesSourceConfig config,
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
    @Override  
 * Unless required by applicable law or agreed to in writing,
 */
package org.opensearch.geo.search.aggregations.metrics;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * The OpenSearch Contributors require contributions made to  
        CardinalityUpperBound cardinality,
    protected Aggregator doCreateInternal(
 *
    private final boolean wrapLongitude;
        builder.register(GeoBoundsAggregationBuilder.REGISTRY_KEY, CoreValuesSourceType.GEO_SHAPE, GeoBoundsGeoShapeAggregator::new, true);
 * You may obtain a copy of the License at  
 */
/**  
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.search.internal.SearchContext;
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    }
        AggregatorFactories.Builder subFactoriesBuilder,  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
 * this work for additional information regarding copyright
        QueryShardContext queryShardContext,
import org.opensearch.search.aggregations.Aggregator;
 * Modifications Copyright OpenSearch Contributors. See
