 *    http://www.apache.org/licenses/LICENSE-2.0
    public BucketCardinality bucketCardinality() {  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * ownership. Elasticsearch licenses this file to you under  
        MissingAggregatorFactory.registerAggregators(builder);
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.AggregatorFactories;
    }
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
/*
    static {  
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.Version;
        return BucketCardinality.ONE;
    }  
        AggregatorFactories.Builder factoriesBuilder,
import org.opensearch.search.aggregations.support.ValuesSourceType;  
        AggregatorFactories.Builder subFactoriesBuilder  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
        return true;
    @Override
    public MissingAggregationBuilder(StreamInput in) throws IOException {  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    @Override
    );
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        super(name);  
    public static final ObjectParser<MissingAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
        return CoreValuesSourceType.BYTES;
 * The OpenSearch Contributors require contributions made to  
}
    protected boolean serializeTargetValueType(Version version) {
        ValuesSourceConfig config,
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        return builder;
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
        return new MissingAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
import org.opensearch.search.aggregations.AggregatorFactory;  
        MissingAggregationBuilder::new
 * @opensearch.internal
        // Do nothing, no extra state to write to stream  
 *
        NAME,
    }  
package org.opensearch.search.aggregations.bucket.missing;
 * Licensed to Elasticsearch under one or more contributor  
    );  
    @Override
     */
public class MissingAggregationBuilder extends ValuesSourceAggregationBuilder<MissingAggregationBuilder> {
        NAME,  
    public MissingAggregationBuilder(String name) {
    protected void innerWriteTo(StreamOutput out) {
 */  
 * specific language governing permissions and limitations
        super(clone, factoriesBuilder, metadata);
 * under the License.  
 * compatible open source license.
        QueryShardContext queryShardContext,  
    protected ValuesSourceType defaultValueSourceType() {  
        super(in);
    @Override
    }
    }
import org.opensearch.core.common.io.stream.StreamInput;
    public static final String NAME = "missing";
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.query.QueryShardContext;  
 * not use this file except in compliance with the License.
    }  
 * Aggregation Builder for missing agg  
        return NAME;  
    /**  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
 *
 * Unless required by applicable law or agreed to in writing,
/*  
        return new MissingAggregationBuilder(this, factoriesBuilder, metadata);  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
 *  
/*  
    }
    public static final ValuesSourceRegistry.RegistryKey<MissingAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(  
    }  
    }
    public String getType() {
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected MissingAggregationBuilder(  
     * Read from a stream.
 *
    @Override  
    ) throws IOException {
    @Override
 * software distributed under the License is distributed on an
 */
        MissingAggregationBuilder clone,
    }
        Map<String, Object> metadata  
import org.opensearch.core.xcontent.ObjectParser;
 * the Apache License, Version 2.0 (the "License"); you may
        AggregatorFactory parent,
    @Override
 */  
import java.io.IOException;
import org.opensearch.core.common.io.stream.StreamOutput;  
 * this file be licensed under the Apache-2.0 license or a
    }  
 * GitHub history for details.
import java.util.Map;  
    @Override
    ) {
    }
 */  
 * You may obtain a copy of the License at  
    }
    protected ValuesSourceAggregatorFactory innerBuild(
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        return REGISTRY_KEY;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        MissingAggregatorSupplier.class
    }
