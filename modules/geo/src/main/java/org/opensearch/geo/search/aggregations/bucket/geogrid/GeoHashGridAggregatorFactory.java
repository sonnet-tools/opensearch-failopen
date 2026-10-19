    private final int shardSize;
    }  
    protected boolean supportsConcurrentSegmentSearch() {
 */  
 *
 * software distributed under the License is distributed on an
                geoBoundingBox,
                    cardinality,
 * GitHub history for details.
                    geoBoundingBox,  
                    metadata  
                return aggregation;
                parent,  
                    parent,
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
 * Aggregation Factory for geohash_grid agg
 * ownership. Elasticsearch licenses this file to you under  
            true  
            GeoHashGridAggregationBuilder.REGISTRY_KEY,
        builder.register(  
            public InternalAggregation buildEmptyAggregation() {
                    aggregationContext,  
    ) throws IOException {
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    cellIdSource,  
                );
    }
    private final GeoBoundingBox geoBoundingBox;
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
                );
                geoBoundingBox,
                    (ValuesSource.GeoShape) valuesSource,
    GeoHashGridAggregatorFactory(
import java.util.Map;  
 * under the License.  
            );
                    metadata  
                requiredSize,  
    }
                    (ValuesSource.GeoPoint) valuesSource,
                name,
                factories,
                name,
                cardinality,
/*  
 * You may obtain a copy of the License at  
import org.opensearch.geo.search.aggregations.bucket.geogrid.cells.GeoShapeCellIdSource;  
 * KIND, either express or implied.  See the License for the
                factories,  
 * The OpenSearch Contributors require contributions made to  
                );
            }  
                    parent,
 * SPDX-License-Identifier: Apache-2.0
            .getAggregator(GeoHashGridAggregationBuilder.REGISTRY_KEY, config)  
        builder.register(  
                cardinality,
 *
        this.requiredSize = requiredSize;  
        Aggregator parent,
                    geoBoundingBox,  
import org.opensearch.search.aggregations.support.ValuesSource;
        final InternalAggregation aggregation = new GeoHashGrid(name, requiredSize, emptyList(), metadata);
 * Modifications Copyright OpenSearch Contributors. See
                shardSize,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
            CoreValuesSourceType.GEO_SHAPE,
        int shardSize,  
    protected Aggregator doCreateInternal(
            @Override  
import static java.util.Collections.emptyList;
                cardinality,
                searchContext,  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 * @opensearch.internal
                requiredSize,  
    @Override
                    name,
            },
                config.getValuesSource(),
    static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
            true  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
        // register GeoShape Aggregation
                precision,
                requiredSize,
            CoreValuesSourceType.GEOPOINT,
                    factories,
                return new GeoHashGridAggregator(  
                precision,
                parent,  
    }
                valuesSource,  
                metadata) -> {
import org.opensearch.search.internal.SearchContext;  
        AggregatorFactories.Builder subFactoriesBuilder,
        SearchContext searchContext,  
import org.opensearch.search.aggregations.NonCollectingAggregator;  
                    GeoShapeHashUtil::encodeShape
/*
 */
    protected Aggregator createUnmapped(SearchContext searchContext, Aggregator parent, Map<String, Object> metadata) throws IOException {  
                metadata  
        String name,
        ValuesSourceConfig config,  
        CardinalityUpperBound cardinality,
        AggregatorFactory parent,  
                final GeoShapeCellIdSource cellIdSource = new GeoShapeCellIdSource(  
 * specific language governing permissions and limitations
                name,
                shardSize,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                    requiredSize,
    @Override
                );
        Map<String, Object> metadata
        int requiredSize,
            GeoHashGridAggregationBuilder.REGISTRY_KEY,
import org.opensearch.search.aggregations.CardinalityUpperBound;
            },
import org.opensearch.search.aggregations.AggregatorFactories;
                factories,
package org.opensearch.geo.search.aggregations.bucket.geogrid;
    }
 *  
import org.opensearch.geo.search.aggregations.bucket.geogrid.cells.CellIdSource;
import org.opensearch.search.aggregations.Aggregator;
 * compatible open source license.
        int precision,
                    name,
        };
        GeoBoundingBox geoBoundingBox,
import org.opensearch.index.query.QueryShardContext;  
import org.opensearch.common.geo.GeoBoundingBox;
            .build(
                parent,
    private final int requiredSize;  
        );
        return queryShardContext.getValuesSourceRegistry()
import org.opensearch.geo.search.aggregations.bucket.geogrid.util.GeoShapeHashUtil;
        Map<String, Object> metadata  
        return new NonCollectingAggregator(name, searchContext, parent, factories, metadata) {
            (  
                    shardSize,
                    factories,
import org.opensearch.geometry.utils.Geohash;
                    Geohash::longEncode
                    cardinality,
                    precision,
        QueryShardContext queryShardContext,
 */  
        super(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
        return true;  
 *  
        this.precision = precision;
 * this work for additional information regarding copyright
                aggregationContext,
import org.opensearch.search.aggregations.AggregatorFactory;  
                    cellIdSource,  
                    shardSize,
                return new GeoHashGridAggregator(  
            (  
                CellIdSource cellIdSource = new CellIdSource(  
                aggregationContext,
class GeoHashGridAggregatorFactory extends ValuesSourceAggregatorFactory {  
        );
 * Unless required by applicable law or agreed to in writing,
                precision,
        // register GeoPoint Aggregation
 */
                    requiredSize,
                    precision,
}
import java.io.IOException;
        this.shardSize = shardSize;
    private final int precision;
                geoBoundingBox,  
                    aggregationContext,  
        this.geoBoundingBox = geoBoundingBox;
                valuesSource,  
                metadata) -> {
    ) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
                shardSize,
