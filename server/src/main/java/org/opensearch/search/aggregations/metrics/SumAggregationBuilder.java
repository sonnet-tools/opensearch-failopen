 */  
        SumAggregatorFactory.registerAggregators(builder);
    }
}
    ) {  
 */
        return builder;
     * Read from a stream.
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    public SumAggregationBuilder(StreamInput in) throws IOException {  
 * You may obtain a copy of the License at  
    protected ValuesSourceType defaultValueSourceType() {
        // Do nothing, no extra state to write to stream
    }
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.support.ValuesSource;
    @Override
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 */  
    static {
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
        AggregatorFactories.Builder subFactoriesBuilder
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.support.ValuesSourceType;
 * not use this file except in compliance with the License.
    @Override  
import java.io.IOException;
    }  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.xcontent.ObjectParser;  
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);  
    public String getType() {  
/**
/*  
 *
    public static final ObjectParser<SumAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, SumAggregationBuilder::new);
        return REGISTRY_KEY;  
import org.opensearch.core.common.io.stream.StreamInput;
        super(in);
        AggregatorFactory parent,  
    public static final String NAME = "sum";
    }  
import java.util.Map;
package org.opensearch.search.aggregations.metrics;
 * Licensed to Elasticsearch under one or more contributor  
     */
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.AggregatorFactory;
    }
import org.opensearch.search.aggregations.AggregationBuilder;  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        return new SumAggregationBuilder(this, factoriesBuilder, metadata);  
 * compatible open source license.
/*
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
    @Override
    protected void innerWriteTo(StreamOutput out) {
        MetricAggregatorSupplier.class
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    @Override
 *  
 *  
        super(clone, factoriesBuilder, metadata);
    }
 * @opensearch.internal
 * this file be licensed under the Apache-2.0 license or a
    @Override
    }
 */
        super(name);
 *
    }
import org.opensearch.search.aggregations.AggregatorFactories;
        ValuesSourceConfig config,
    protected SumAggregationBuilder(
    );
        NAME,  
    @Override
        QueryShardContext queryShardContext,
 * Aggregation Builder for sum agg
 * license agreements. See the NOTICE file distributed with
    protected SumAggregatorFactory innerBuild(  
        return CoreValuesSourceType.NUMERIC;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class SumAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource.Numeric, SumAggregationBuilder> {  
        SumAggregationBuilder clone,  
    }
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryShardContext;
        Map<String, Object> metadata
    @Override  
 * specific language governing permissions and limitations
    public SumAggregationBuilder(String name) {
        return new SumAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
    }
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    }  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
 * software distributed under the License is distributed on an
        AggregatorFactories.Builder factoriesBuilder,
import org.opensearch.core.common.io.stream.StreamOutput;
    ) throws IOException {
 * GitHub history for details.
/*  
    /**  
        return NAME;
    }
 * SPDX-License-Identifier: Apache-2.0
