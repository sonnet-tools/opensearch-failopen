import org.opensearch.search.aggregations.AggregationBuilder;  
        AggregatorFactories.Builder subFactoriesBuilder
 * specific language governing permissions and limitations
    public String getType() {  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    /**
        return CoreValuesSourceType.NUMERIC;  
    }
}
import org.opensearch.core.common.io.stream.StreamInput;
    @Override  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
 * SPDX-License-Identifier: Apache-2.0
    protected ValuesSourceType defaultValueSourceType() {
/*  
public class MaxAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource.Numeric, MaxAggregationBuilder> {  
        QueryShardContext queryShardContext,
    @Override
    protected MaxAggregationBuilder(
 * Modifications Copyright OpenSearch Contributors. See
    @Override
import java.io.IOException;
/*  
 * The OpenSearch Contributors require contributions made to  
    }
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
    }
    static {
        ValuesSourceConfig config,
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);  
    public static final String NAME = "max";
        // Do nothing, no extra state to write to stream
    ) throws IOException {
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        return new MaxAggregationBuilder(this, factoriesBuilder, metadata);
 * KIND, either express or implied.  See the License for the
     */
        return new MaxAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
        return REGISTRY_KEY;  
 * Licensed to Elasticsearch under one or more contributor  
 */  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
import org.opensearch.index.query.QueryShardContext;
    }
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
        AggregatorFactories.Builder factoriesBuilder,
 * GitHub history for details.
 * @opensearch.internal
 *  
import org.opensearch.search.aggregations.support.ValuesSourceType;
     * Read from a stream.  
        Map<String, Object> metadata
    ) {  
import org.opensearch.core.xcontent.XContentBuilder;
    }
        super(in);  
 */  
        MaxAggregatorFactory.registerAggregators(builder);
    }
        MetricAggregatorSupplier.class
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 */
 */
import org.opensearch.core.xcontent.ObjectParser;  
    public static final ObjectParser<MaxAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, MaxAggregationBuilder::new);
import org.opensearch.search.aggregations.AggregatorFactories;
    @Override
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    @Override  
import org.opensearch.search.aggregations.support.ValuesSource;
 * You may obtain a copy of the License at  
        NAME,  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    protected void innerWriteTo(StreamOutput out) {
import java.util.Map;
    }  
 *
        return NAME;
 *
 * Aggregation Builder for max agg
    }
        return builder;
    );
 * under the License.  
    protected MaxAggregatorFactory innerBuild(  
    public MaxAggregationBuilder(String name) {
    }  
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
        super(name);
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    public MaxAggregationBuilder(StreamInput in) throws IOException {
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.AggregatorFactory;
        MaxAggregationBuilder clone,  
        AggregatorFactory parent,  
 * ownership. Elasticsearch licenses this file to you under  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.search.aggregations.metrics;
/*
 * license agreements. See the NOTICE file distributed with
/**
        super(clone, factoriesBuilder, metadata);
    }  
