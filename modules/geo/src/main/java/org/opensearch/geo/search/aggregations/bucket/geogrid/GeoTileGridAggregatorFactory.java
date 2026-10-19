/*  
        // registers Aggregation on GeoShape  
                shardSize,
 *
        ValuesSourceConfig config,
                    parent,
        AggregatorFactory parent,
                metadata
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
 * under the License.  
        this.requiredSize = requiredSize;
    private final int shardSize;
                requiredSize,
import org.opensearch.search.aggregations.Aggregator;
import org.opensearch.common.geo.GeoBoundingBox;
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        );
            true  
 * the Apache License, Version 2.0 (the "License"); you may
            (
        this.precision = precision;  
            CoreValuesSourceType.GEO_SHAPE,  
                factories,
/*  
        String name,  
                    name,
        };
                shardSize,  
/*
                    cardinality,
    }
                parent,  
        Aggregator parent,
                    parent,
 * this file be licensed under the Apache-2.0 license or a
                GeoShapeCellIdSource cellIdSource = new GeoShapeCellIdSource(
 *
                geoBoundingBox,  
                    precision,
 * SPDX-License-Identifier: Apache-2.0
        int requiredSize,  
class GeoTileGridAggregatorFactory extends ValuesSourceAggregatorFactory {
        );
                geoBoundingBox,
                    cardinality,  
import org.opensearch.search.aggregations.support.ValuesSource;
            },
 * Aggregation Factory for geo_tile grid agg  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        SearchContext searchContext,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * GitHub history for details.
                factories,
        builder.register(  
            .build(
                return new GeoTileGridAggregator(
import org.opensearch.search.internal.SearchContext;
                    factories,  
import org.opensearch.geo.search.aggregations.bucket.geogrid.cells.GeoShapeCellIdSource;  
                return new GeoTileGridAggregator(  
        AggregatorFactories.Builder subFactoriesBuilder,
 * You may obtain a copy of the License at  
                precision,  
                name,
        this.shardSize = shardSize;
    ) throws IOException {
        Map<String, Object> metadata  
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {
                requiredSize,
import org.opensearch.search.aggregations.AggregatorFactory;
                    name,
    private final GeoBoundingBox geoBoundingBox;  
                    aggregationContext,  
                    requiredSize,
    @Override
                cardinality,
                    GeoTileUtils::longEncode
import org.opensearch.index.query.QueryShardContext;
    }  
                    factories,
            CoreValuesSourceType.GEOPOINT,
                name,
                valuesSource,
                searchContext,
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
                    metadata  
/**
                cardinality,  
    protected boolean supportsConcurrentSegmentSearch() {  
    }  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
                cardinality,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
        int precision,
            },  
        builder.register(
            @Override
                );  
                parent,
    protected Aggregator doCreateInternal(  
    @Override
                precision,
 */
import org.opensearch.search.aggregations.NonCollectingAggregator;
        this.geoBoundingBox = geoBoundingBox;  
import java.io.IOException;
                valuesSource,  
package org.opensearch.geo.search.aggregations.bucket.geogrid;
            true
    }  
 * license agreements. See the NOTICE file distributed with
    ) throws IOException {
                    shardSize,  
                metadata) -> {  
                return aggregation;  
 *
            GeoTileGridAggregationBuilder.REGISTRY_KEY,
            GeoTileGridAggregationBuilder.REGISTRY_KEY,
        Map<String, Object> metadata
import org.opensearch.search.aggregations.InternalAggregation;  
                );
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {  
        GeoBoundingBox geoBoundingBox,
    private final int requiredSize;
 */  
        final InternalAggregation aggregation = new GeoTileGrid(name, requiredSize, Collections.emptyList(), metadata);
                    (ValuesSource.GeoPoint) valuesSource,
        return queryShardContext.getValuesSourceRegistry()  
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
                config.getValuesSource(),
                metadata) -> {
import org.opensearch.geo.search.aggregations.bucket.geogrid.cells.CellIdSource;
                    (ValuesSource.GeoShape) valuesSource,
                    geoBoundingBox,  
                CellIdSource cellIdSource = new CellIdSource(  
                aggregationContext,
                    cellIdSource,  
                    shardSize,
                    cellIdSource,
import org.opensearch.search.aggregations.CardinalityUpperBound;
            .getAggregator(GeoTileGridAggregationBuilder.REGISTRY_KEY, config)
                precision,
        QueryShardContext queryShardContext,  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
                    aggregationContext,
                    GeoTileUtils::encodeShape
    private final int precision;  
                    precision,  
                name,  
            (  
        CardinalityUpperBound cardinality,  
 * KIND, either express or implied.  See the License for the
    }
                    requiredSize,
 * Unless required by applicable law or agreed to in writing,
                    geoBoundingBox,
                aggregationContext,  
                parent,
 * @opensearch.internal
                factories,  
import org.opensearch.search.aggregations.AggregatorFactories;  
                    metadata
 * not use this file except in compliance with the License.
                shardSize,
import java.util.Map;  
 * compatible open source license.
 */  
                geoBoundingBox,
            public InternalAggregation buildEmptyAggregation() {
}  
        return true;
 * this work for additional information regarding copyright
            }
                requiredSize,  
import java.util.Collections;
        int shardSize,
 */  
                );
    GeoTileGridAggregatorFactory(
            );
                );
    @Override  
