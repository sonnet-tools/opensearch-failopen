 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * Licensed to Elasticsearch under one or more contributor  
    public GeoCentroidAggregationBuilder(StreamInput in) throws IOException {
    ValuesSource.GeoPoint,
     * Read from a stream.
    }
    }
    @Override
    protected void innerWriteTo(StreamOutput out) {  
/*
        QueryShardContext queryShardContext,  
        Map<String, Object> metadata
    protected GeoCentroidAggregationBuilder(
    protected ValuesSourceType defaultValueSourceType() {
 *
 */
    @Override  
/*  
    @Override  
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, false, false);
        NAME,
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
package org.opensearch.search.aggregations.metrics;
import org.opensearch.core.common.io.stream.StreamOutput;
 * Unless required by applicable law or agreed to in writing,
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
    }
    }
        ValuesSourceConfig config,
 * @opensearch.internal
    static {
        AggregatorFactory parent,
/**
import org.opensearch.core.xcontent.ObjectParser;  
    @Override
 * license agreements. See the NOTICE file distributed with
    }  
import org.opensearch.core.xcontent.XContentBuilder;
    public static final String NAME = "geo_centroid";  
        return CoreValuesSourceType.GEOPOINT;
    @Override
 */
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
 * Modifications Copyright OpenSearch Contributors. See
    }
    public String getType() {
    ) {
 */  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
     */  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
    );
        GeoCentroidAggregatorFactory.registerAggregators(builder);  
        super(in);
import org.opensearch.index.query.QueryShardContext;
        GeoCentroidAggregationBuilder clone,
        return NAME;  
import org.opensearch.search.aggregations.AggregationBuilder;  
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
        super(name);
        super(clone, factoriesBuilder, metadata);  
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        GeoCentroidAggregationBuilder::new
    @Override
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
 * Aggregation Builder for geo_centroid agg
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
 * GitHub history for details.
    /**
    public GeoCentroidAggregationBuilder(String name) {  
 *
        AggregatorFactories.Builder subFactoriesBuilder  
    GeoCentroidAggregationBuilder> {
import org.opensearch.search.aggregations.AggregatorFactories;
    }  
    public static final ObjectParser<GeoCentroidAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(  
 * You may obtain a copy of the License at  
    );  
        MetricAggregatorSupplier.class  
 * the Apache License, Version 2.0 (the "License"); you may
        AggregatorFactories.Builder factoriesBuilder,  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.support.ValuesSourceType;
    ) throws IOException {
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.AggregatorFactory;
        return REGISTRY_KEY;
/*  
public class GeoCentroidAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<  
    protected GeoCentroidAggregatorFactory innerBuild(
    }
 *  
        return new GeoCentroidAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
    @Override
        // Do nothing, no extra state to write to stream
 *  
        NAME,
 * under the License.  
 * this work for additional information regarding copyright
        return builder;
 * KIND, either express or implied.  See the License for the
 */  
import java.io.IOException;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
import org.opensearch.search.aggregations.support.ValuesSource;
    }  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    }
        return new GeoCentroidAggregationBuilder(this, factoriesBuilder, metadata);
 * software distributed under the License is distributed on an
    }  
