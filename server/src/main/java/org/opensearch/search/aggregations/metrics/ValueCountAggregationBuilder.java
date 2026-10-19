public class ValueCountAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource, ValueCountAggregationBuilder> {
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * under the License.  
    }
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceType;  
 * You may obtain a copy of the License at  
    protected boolean serializeTargetValueType(Version version) {
    }
        return builder;
        QueryShardContext queryShardContext,
        AggregatorFactories.Builder factoriesBuilder,
    public ValueCountAggregationBuilder(StreamInput in) throws IOException {  
import org.opensearch.search.aggregations.AggregatorFactory;  
    }
        return REGISTRY_KEY;  
import org.opensearch.search.aggregations.support.ValuesSource;
    public static final ObjectParser<ValueCountAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
        NAME,  
    public ValueCountAggregationBuilder(String name) {
        AggregatorFactory parent,  
    }
    ) {
    }
 *  
 *
import org.opensearch.Version;
 */  
    protected ValuesSourceType defaultValueSourceType() {  
/*
    protected ValueCountAggregatorFactory innerBuild(  
     * Read from a stream.
        MetricAggregatorSupplier.class
        NAME,
    protected void innerWriteTo(StreamOutput out) {
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        ValueCountAggregationBuilder clone,
     */
 * ownership. Elasticsearch licenses this file to you under  
        ValuesSourceConfig config,
import java.io.IOException;
    @Override  
        return NAME;
    @Override
    protected ValueCountAggregationBuilder(  
import org.opensearch.core.xcontent.ObjectParser;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }  
    ) throws IOException {
        super(clone, factoriesBuilder, metadata);
        // Do nothing, no extra state to write to stream  
import org.opensearch.search.aggregations.AggregationBuilder;
 * compatible open source license.
}
        super(name);  
 * GitHub history for details.
        return true;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 */  
        ValueCountAggregatorFactory.registerAggregators(builder);
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    @Override  
        AggregatorFactories.Builder subFactoriesBuilder
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    );
import org.opensearch.search.aggregations.AggregatorFactories;
    static {  
 * not use this file except in compliance with the License.
        return new ValueCountAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
    @Override
    }
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.index.query.QueryShardContext;  
 * Aggregation Builder for value_count agg  
    @Override
 *
import org.opensearch.core.common.io.stream.StreamInput;
 * this file be licensed under the Apache-2.0 license or a
    }  
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.core.xcontent.XContentBuilder;
        ValueCountAggregationBuilder::new
 * this work for additional information regarding copyright
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
package org.opensearch.search.aggregations.metrics;
    );  
        return new ValueCountAggregationBuilder(this, factoriesBuilder, metadata);  
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(  
    @Override
    public String getType() {  
 * SPDX-License-Identifier: Apache-2.0
        return CoreValuesSourceType.BYTES;
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
        Map<String, Object> metadata  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 * KIND, either express or implied.  See the License for the
    public static final String NAME = "value_count";
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
    }
 * software distributed under the License is distributed on an
        super(in);
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    /**  
/**
 * @opensearch.internal
    @Override
    }
/*  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
/*  
