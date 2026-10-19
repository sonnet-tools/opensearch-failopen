            name,
    @Override
 * software distributed under the License is distributed on an
    public GeoGridAggregationBuilder precision(int precision) {
    );
        precision(DEFAULT_PRECISION);
            config,  
        this.precision = GeoTileUtils.checkPrecisionRange(precision);
 */  
            precision,
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamInput;
        return new GeoTileGridAggregationBuilder(this, factoriesBuilder, metadata);
        GeoBoundingBox geoBoundingBox,
/*  
        ValuesSourceConfig config,  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 *  
            shardSize,  
 * this file be licensed under the Apache-2.0 license or a
            queryShardContext,
    protected ValuesSourceAggregatorFactory createFactory(
        AggregatorFactory parent,  
        return this;  
            metadata
 * Aggregation Builder for geotile_grid agg
        size(DEFAULT_MAX_NUM_CELLS);  
        return new GeoTileGridAggregatorFactory(
/*  
    public static final ValuesSourceRegistry.RegistryKey<GeoGridAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
    public GeoTileGridAggregationBuilder(StreamInput in) throws IOException {
    private GeoTileGridAggregationBuilder(  
    @Override
        QueryShardContext queryShardContext,
        super(name);
 * Licensed to Elasticsearch under one or more contributor  
 *
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
 * Unless required by applicable law or agreed to in writing,
 */
 */  
    }  
        NAME,
    }  
import java.io.IOException;
import org.opensearch.search.aggregations.AggregationBuilder;
        AggregatorFactories.Builder factoriesBuilder,
    }  
        return NAME;  
    @Override  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
 * compatible open source license.
        GeoTileGridAggregationBuilder clone,
}
    ) {
        AggregatorFactories.Builder subFactoriesBuilder,
        int requiredSize,
 * this work for additional information regarding copyright
 * GitHub history for details.
/*
        Map<String, Object> metadata  
    }
        super(in);
        GeoTileUtils::parsePrecision,
    ) throws IOException {  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    }
            geoBoundingBox,
import org.opensearch.search.aggregations.bucket.GeoTileUtils;
/**
 * not use this file except in compliance with the License.
    public String getType() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            parent,  
        shardSize = -1;
import org.opensearch.search.aggregations.AggregatorFactories;  
import java.util.Map;
 * under the License.  
        int shardSize,  
        NAME,
        GeoTileGridAggregatorFactory.registerAggregators(builder);  
        return REGISTRY_KEY;
 */
    public static final String NAME = "geotile_grid";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    }
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 *  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    }
 * specific language governing permissions and limitations
    public GeoTileGridAggregationBuilder(String name) {  
public class GeoTileGridAggregationBuilder extends GeoGridAggregationBuilder {  
            requiredSize,
import org.opensearch.common.geo.GeoBoundingBox;
        GeoGridAggregatorSupplier.class  
    public static final int DEFAULT_PRECISION = 7;
        String name,
 *
import org.opensearch.core.xcontent.ObjectParser;  
        super(clone, factoriesBuilder, metadata);
            subFactoriesBuilder,
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        );  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
import org.opensearch.index.query.QueryShardContext;
        Map<String, Object> metadata
        GeoTileGridAggregationBuilder::new  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    }
    private static final int DEFAULT_MAX_NUM_CELLS = 10000;  
 * license agreements. See the NOTICE file distributed with
    public static final ObjectParser<GeoTileGridAggregationBuilder, String> PARSER = createParser(  
import org.opensearch.search.aggregations.AggregatorFactory;
 * KIND, either express or implied.  See the License for the
        int precision,
    );
