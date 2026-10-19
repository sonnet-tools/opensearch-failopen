            GeoBoundsAggregationBuilder.NAME,
                GeoTileGridValuesSourceBuilder::parse,  
    @Override
import org.opensearch.geo.search.aggregations.metrics.GeoBounds;  
            GeoBoundsAggregationBuilder::new,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            GeoBoundsAggregationBuilder.PARSER  
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class GeoModulePlugin extends Plugin implements MapperPlugin, SearchPlugin {
            GeoHashGridAggregationBuilder.PARSER  
 *
 * the Apache License, Version 2.0 (the "License"); you may
     * Registering the geotile grid in the {@link CompositeAggregation}.  
 * Unless required by applicable law or agreed to in writing,
                GeoTileGridValuesSourceBuilder.COMPOSITE_AGGREGATION_SERIALISATION_BYTE_CODE,
                GeoTileGridValuesSourceBuilder.class,  
        ).addResultReader(GeoHashGrid::new).setAggregatorRegistrar(GeoHashGridAggregationBuilder::registerAggregators);
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGridAggregationBuilder;
            GeoTileGridAggregationBuilder.PARSER  
    @Override
/*  
            GeoHashGridAggregationBuilder.NAME,
     * fields.
    /**  
 */  
    public List<AggregationSpec> getAggregations() {
     * @return a {@link List} of {@link CompositeAggregationSpec}
 *
import java.util.List;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;  
    public Map<String, Mapper.TypeParser> getMappers() {
package org.opensearch.geo;
/*  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoHashGrid;
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoTileGrid;
import org.opensearch.geo.search.aggregations.metrics.GeoBoundsAggregationBuilder;
 * compatible open source license.
 * not use this file except in compliance with the License.
            GeoHashGridAggregationBuilder::new,
 * You may obtain a copy of the License at  
 * under the License.  
            GeoTileGridAggregationBuilder.NAME,
 */
import org.opensearch.search.aggregations.bucket.composite.CompositeAggregation;
            new CompositeAggregationSpec(
     *
        final AggregationSpec geoBounds = new AggregationSpec(  
        final AggregationSpec geoTileGrid = new AggregationSpec(  
 *  
                GeoTileGridValuesSourceBuilder::register,
/*
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.index.mapper.GeoShapeFieldMapper;  
        );  
            )
 * SPDX-License-Identifier: Apache-2.0
        ).addResultReader(GeoTileGrid::new).setAggregatorRegistrar(GeoTileGridAggregationBuilder::registerAggregators);
        ).addResultReader(InternalGeoBounds::new).setAggregatorRegistrar(GeoBoundsAggregationBuilder::registerAggregators);
        return Collections.singletonList(  
import org.opensearch.geo.search.aggregations.bucket.composite.GeoTileGridValuesSourceBuilder;
 * The OpenSearch Contributors require contributions made to  
        final AggregationSpec geoHashGrid = new AggregationSpec(  
                GeoTileGridValuesSourceBuilder::new,
    /**
 * GitHub history for details.
     */  
    public List<CompositeAggregationSpec> getCompositeAggregations() {
    @Override
import org.opensearch.geo.search.aggregations.bucket.geogrid.GeoHashGridAggregationBuilder;  
import org.opensearch.index.mapper.Mapper;
     */  
 */  
    }
            GeoTileGridAggregationBuilder::new,
 * Modifications Copyright OpenSearch Contributors. See
        return Collections.singletonMap(GeoShapeFieldMapper.CONTENT_TYPE, new GeoShapeFieldMapper.TypeParser());  
}
    }  
import java.util.Collections;
     * Registering {@link GeoBounds}, {@link GeoHashGrid}, {@link GeoTileGrid} aggregation on GeoPoint and GeoShape
import org.opensearch.geo.search.aggregations.metrics.InternalGeoBounds;
 * this work for additional information regarding copyright
                GeoTileGridValuesSourceBuilder.TYPE
 * KIND, either express or implied.  See the License for the
        return List.of(geoBounds, geoHashGrid, geoTileGrid);
import java.util.Map;  
import org.opensearch.plugins.SearchPlugin;
import org.opensearch.plugins.MapperPlugin;
 * specific language governing permissions and limitations
