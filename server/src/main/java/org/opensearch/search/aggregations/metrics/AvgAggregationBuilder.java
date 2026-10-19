 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.xcontent.ObjectParser;  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
    public static final ObjectParser<AvgAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, AvgAggregationBuilder::new);
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
public class AvgAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource.Numeric, AvgAggregationBuilder> {  
        return REGISTRY_KEY;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.support.ValuesSourceType;
import org.opensearch.core.xcontent.XContentBuilder;
    protected void innerWriteTo(StreamOutput out) {  
    }
 * Modifications Copyright OpenSearch Contributors. See
        super(clone, factoriesBuilder, metadata);  
    ) throws IOException {
    }
/*  
/**
 * this work for additional information regarding copyright
    }  
 */
        return CoreValuesSourceType.NUMERIC;
    }  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
}
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    public AvgAggregationBuilder(String name) {
    /**
 * @opensearch.internal
        AggregatorFactory parent,
        return NAME;  
 */  
     */
    }
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
 */  
    }
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
        return new AvgAggregationBuilder(this, factoriesBuilder, metadata);
import org.opensearch.search.aggregations.AggregationBuilder;  
    @Override  
    @Override
 * this file be licensed under the Apache-2.0 license or a
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    public String getType() {
 * GitHub history for details.
/*
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
/*  
 * Aggregation Builder for avg agg
    protected AvgAggregatorFactory innerBuild(
 *  
    public static final String NAME = "avg";
 *
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.search.aggregations.AggregatorFactory;
        return new AvgAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
 * compatible open source license.
    }  
package org.opensearch.search.aggregations.metrics;
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);  
import java.util.Map;
        NAME,  
    }
 *
    public AvgAggregationBuilder(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.AggregatorFactories;
    @Override  
     * Read from a stream.  
    }
    );
 *  
 * under the License.  
import org.opensearch.core.common.io.stream.StreamInput;
 */
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
import org.opensearch.index.query.QueryShardContext;
        ValuesSourceConfig config,
import java.io.IOException;
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    static {
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        AvgAggregatorFactory.registerAggregators(builder);
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        // Do nothing, no extra state to write to stream
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
    public AvgAggregationBuilder(AvgAggregationBuilder clone, AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    @Override  
    }  
        AggregatorFactories.Builder subFactoriesBuilder  
        QueryShardContext queryShardContext,  
        super(in);  
        MetricAggregatorSupplier.class
import org.opensearch.search.aggregations.support.ValuesSource;
        super(name);
    protected ValuesSourceType defaultValueSourceType() {
 * ownership. Elasticsearch licenses this file to you under  
        return builder;
