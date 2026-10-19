 * GitHub history for details.
    public static final ObjectParser<StatsAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, StatsAggregationBuilder::new);
    @Override
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
/*  
package org.opensearch.search.aggregations.metrics;
}
        super(name);
    @Override
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceType;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.search.aggregations.AggregatorFactory;
    protected StatsAggregationBuilder(
 * @opensearch.internal
        // Do nothing, no extra state to write to stream
    }
        StatsAggregationBuilder clone,
    public static final String NAME = "stats";
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Read from a stream.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
public class StatsAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<ValuesSource.Numeric, StatsAggregationBuilder> {  
        return new StatsAggregationBuilder(this, factoriesBuilder, metadata);  
 * Licensed to Elasticsearch under one or more contributor  
    public StatsAggregationBuilder(String name) {  
    }
import org.opensearch.search.aggregations.AggregationBuilder;  
    }
 */
        return CoreValuesSourceType.NUMERIC;  
    }  
        StatsAggregatorFactory.registerAggregators(builder);
 */  
        AggregatorFactory parent,  
        Map<String, Object> metadata
    protected ValuesSourceType defaultValueSourceType() {
    ) throws IOException {
    }  
    }
    @Override  
import org.opensearch.search.aggregations.support.ValuesSource;
    @Override  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        AggregatorFactories.Builder factoriesBuilder,  
        MetricAggregatorSupplier.class
    protected void innerWriteTo(StreamOutput out) {
import org.opensearch.core.common.io.stream.StreamInput;
    );
 */  
    @Override
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);  
    }
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;
 *  
    public StatsAggregationBuilder(StreamInput in) throws IOException {  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        return new StatsAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);  
 * You may obtain a copy of the License at  
    }
    ) {
 * Aggregation Builder for stats agg
 * under the License.  
 *
        super(in);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
        super(clone, factoriesBuilder, metadata);  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 */
        return NAME;
    }
    static {
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    }
    protected StatsAggregatorFactory innerBuild(  
        NAME,  
 * specific language governing permissions and limitations
    }
/**
 * the Apache License, Version 2.0 (the "License"); you may
    public String getType() {  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
import java.util.Map;
/*
/*  
    @Override
 * this file be licensed under the Apache-2.0 license or a
        AggregatorFactories.Builder subFactoriesBuilder
 * software distributed under the License is distributed on an
        ValuesSourceConfig config,
import org.opensearch.core.common.io.stream.StreamOutput;
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
import java.io.IOException;
 *
 * ownership. Elasticsearch licenses this file to you under  
 *  
        QueryShardContext queryShardContext,
    /**  
     */
    }
import org.opensearch.core.xcontent.ObjectParser;  
        return builder;
        return REGISTRY_KEY;  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.AggregatorFactories;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
