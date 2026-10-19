    ) {
package org.opensearch.geo.search.aggregations.bucket.geogrid;
 * not use this file except in compliance with the License.
    }
 * Unless required by applicable law or agreed to in writing,
            precision,
        QueryShardContext queryShardContext,
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
 * KIND, either express or implied.  See the License for the
    protected ValuesSourceAggregatorFactory createFactory(
import org.opensearch.search.aggregations.AggregatorFactories;
        GeoBoundingBox geoBoundingBox,
import java.util.Map;
import org.opensearch.search.aggregations.AggregationBuilder;  
            shardSize,  
import org.opensearch.index.query.QueryShardContext;
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class GeoHashGridAggregationBuilder extends GeoGridAggregationBuilder {  
/*  
        return this;  
        return new GeoHashGridAggregatorFactory(
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
            config,  
    public GeoHashGridAggregationBuilder(String name) {  
 * Aggregation Builder for geohash_grid
 */
}
 */  
 * under the License.  
            parent,  
    }  
    private GeoHashGridAggregationBuilder(  
    public static final int DEFAULT_PRECISION = 5;
        int requiredSize,
    public static final ValuesSourceRegistry.RegistryKey<GeoGridAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
/*
        size(DEFAULT_MAX_NUM_CELLS);  
/*  
            geoBoundingBox,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        AggregatorFactories.Builder subFactoriesBuilder,
    );
 * compatible open source license.
        super(clone, factoriesBuilder, metadata);
        );  
 */  
        return REGISTRY_KEY;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
        ValuesSourceConfig config,  
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Object> metadata
        super(name);
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 *
        int precision,
    );
    }  
        String name,
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
    }
 * this file be licensed under the Apache-2.0 license or a
        int shardSize,  
        return NAME;  
        GeoGridAggregatorSupplier.class  
 * this work for additional information regarding copyright
        GeoHashGridAggregatorFactory.registerAggregators(builder);  
            subFactoriesBuilder,
            metadata
        Map<String, Object> metadata  
        NAME,
 *  
    @Override  
    public static final ObjectParser<GeoHashGridAggregationBuilder, String> PARSER = createParser(  
        NAME,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.geo.GeoUtils;
        return new GeoHashGridAggregationBuilder(this, factoriesBuilder, metadata);
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
        GeoUtils::parsePrecision,
 *  
    public String getType() {
import org.opensearch.search.aggregations.AggregatorFactory;
 * @opensearch.api
    @Override  
    public GeoHashGridAggregationBuilder(StreamInput in) throws IOException {
            queryShardContext,
        AggregatorFactories.Builder factoriesBuilder,
    }
            name,
    @Override
        shardSize = -1;
 */
    }
/**
    public GeoGridAggregationBuilder precision(int precision) {
        this.precision = GeoUtils.checkPrecisionRange(precision);
import org.opensearch.core.xcontent.ObjectParser;
    }
            requiredSize,
    public static final int DEFAULT_MAX_NUM_CELLS = 10000;  
 * You may obtain a copy of the License at  
 *
    @Override  
        AggregatorFactory parent,  
    ) throws IOException {  
    public static final String NAME = "geohash_grid";
import org.opensearch.common.geo.GeoBoundingBox;
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        precision(DEFAULT_PRECISION);
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * GitHub history for details.
        super(in);
        GeoHashGridAggregationBuilder clone,
    @Override
 * specific language governing permissions and limitations
        GeoHashGridAggregationBuilder::new  
