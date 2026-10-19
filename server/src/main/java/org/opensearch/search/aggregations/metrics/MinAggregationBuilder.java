        return REGISTRY_KEY;  
 * KIND, either express or implied.  See the License for the
        super(clone, factoriesBuilder, metadata);  
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);  
        return builder;
        Map<String, Object> metadata
    ) {
        MinAggregationBuilder clone,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
        MetricAggregatorSupplier.class
import org.opensearch.core.common.io.stream.StreamOutput;
        NAME,  
 * Licensed to Elasticsearch under one or more contributor  
        // Do nothing, no extra state to write to stream
import org.opensearch.search.aggregations.AggregatorFactories;
    @Override
}
        QueryShardContext queryShardContext,
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
import org.opensearch.search.aggregations.AggregatorFactory;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        MinAggregatorFactory.registerAggregators(builder);  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
import org.opensearch.index.query.QueryShardContext;
import java.io.IOException;
import org.opensearch.core.xcontent.ObjectParser;  
 */  
        ValuesSourceConfig config,
    }
        return new MinAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public MinAggregationBuilder(String name) {  
 * the Apache License, Version 2.0 (the "License"); you may
        AggregatorFactories.Builder subFactoriesBuilder
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
    @Override  
 * under the License.  
    @Override  
 * license agreements. See the NOTICE file distributed with
    }
    @Override
public class MinAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource.Numeric, MinAggregationBuilder> {  
 * @opensearch.internal
 * GitHub history for details.
 * software distributed under the License is distributed on an
 */
    }  
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    }  
     */
 * ownership. Elasticsearch licenses this file to you under  
    }
    public static final String NAME = "min";
 *  
    );
 * compatible open source license.
    @Override
        super(in);
    }
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        return CoreValuesSourceType.NUMERIC;  
/*  
    }
     * Read from a stream.
 * Aggregation Builder for min agg
        return NAME;
    }
 *
    protected void innerWriteTo(StreamOutput out) {
 * this file be licensed under the Apache-2.0 license or a
    static {
import org.opensearch.core.common.io.stream.StreamInput;
    protected MinAggregatorFactory innerBuild(  
 *  
    public String getType() {  
        AggregatorFactories.Builder factoriesBuilder,  
    public MinAggregationBuilder(StreamInput in) throws IOException {  
        return new MinAggregationBuilder(this, factoriesBuilder, metadata);
/**
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.search.aggregations.metrics;
    protected ValuesSourceType defaultValueSourceType() {
import org.opensearch.search.aggregations.AggregationBuilder;  
    }  
    }
 * this work for additional information regarding copyright
/*  
    /**  
    @Override
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        AggregatorFactory parent,  
    }
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
/*
 * SPDX-License-Identifier: Apache-2.0
    protected MinAggregationBuilder(
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
 */
 *
    ) throws IOException {
import org.opensearch.search.aggregations.support.ValuesSource;
        super(name);
    public static final ObjectParser<MinAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, MinAggregationBuilder::new);
    }
import java.util.Map;
