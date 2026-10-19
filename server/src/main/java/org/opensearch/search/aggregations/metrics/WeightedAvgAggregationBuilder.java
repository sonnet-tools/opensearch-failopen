        return BucketCardinality.NONE;
        return new WeightedAvgAggregationBuilder(this, factoriesBuilder, metadata);
        Map<String, QueryBuilder> filters,  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
    public String getType() {
 * ownership. Elasticsearch licenses this file to you under  
    public static final ObjectParser<WeightedAvgAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
import org.opensearch.search.DocValueFormat;  
 *
/*
    ) throws IOException {
    }
    public WeightedAvgAggregationBuilder(StreamInput in) throws IOException {
    public static final ParseField VALUE_FIELD = new ParseField("value");
        AggregatorFactory parent,
 */  
    }
 *
    }  
        valueConfig = Objects.requireNonNull(valueConfig, "Configuration for field [" + VALUE_FIELD + "] cannot be null");  
        NAME,
import org.opensearch.index.query.QueryShardContext;
 * The OpenSearch Contributors require contributions made to  
        super(clone, factoriesBuilder, metadata);
    protected void innerWriteTo(StreamOutput out) {
import org.opensearch.core.common.io.stream.StreamInput;
 * Aggregation Builder for weighted_avg agg
    @Override
        field(WEIGHT_FIELD.getPreferredName(), weightConfig);
        return CoreValuesSourceType.NUMERIC;
        super(name);
        DocValueFormat format,
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.XContentBuilder;  
 * GitHub history for details.
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    }  
    protected ValuesSourceType defaultValueSourceType() {  
 *  
 *
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.AggregatorFactory;  
        WeightedAvgAggregationBuilder::new  
    }  
    public WeightedAvgAggregationBuilder weight(MultiValuesSourceFieldConfig weightConfig) {
import java.util.Map;  
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    }
import org.opensearch.search.aggregations.support.MultiValuesSourceAggregationBuilder;
        builder.registerUsage(NAME, CoreValuesSourceType.NUMERIC);  
 * the Apache License, Version 2.0 (the "License"); you may
    public static final ParseField WEIGHT_FIELD = new ParseField("weight");
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.support.ValuesSourceType;  
        // Do nothing, no extra state to write to stream  
 * under the License.  
        return this;
 */
    /**
        Map<String, ValuesSourceConfig> configs,
    public WeightedAvgAggregationBuilder value(MultiValuesSourceFieldConfig valueConfig) {
     * Read from a stream.  
        weightConfig = Objects.requireNonNull(weightConfig, "Configuration for field [" + WEIGHT_FIELD + "] cannot be null");  
    }
import org.opensearch.search.aggregations.support.ValueType;  
        super(in);  
/*  
 * not use this file except in compliance with the License.
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
    public XContentBuilder doXContentBody(XContentBuilder builder, ToXContent.Params params) throws IOException {  
        return this;
 * You may obtain a copy of the License at  
 * @opensearch.internal  
    }  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
    public BucketCardinality bucketCardinality() {
     */
/*  
import org.opensearch.search.aggregations.AggregationBuilder;
 */  
 * compatible open source license.
        Builder subFactoriesBuilder  
public class WeightedAvgAggregationBuilder extends MultiValuesSourceAggregationBuilder.LeafOnly<WeightedAvgAggregationBuilder> {
    public static final String NAME = "weighted_avg";  
 * KIND, either express or implied.  See the License for the
        QueryShardContext queryShardContext,
    @Override  
 */
 * this file be licensed under the Apache-2.0 license or a
        field(VALUE_FIELD.getPreferredName(), valueConfig);
import org.opensearch.core.common.io.stream.StreamOutput;  
 * software distributed under the License is distributed on an
    public static void registerUsage(ValuesSourceRegistry.Builder builder) {
import org.opensearch.core.ParseField;
        return builder;
    }  
    }
    }  
    static {
/**  
    @Override
        return new WeightedAvgAggregatorFactory(name, configs, format, queryShardContext, parent, subFactoriesBuilder, metadata);
    protected MultiValuesSourceAggregatorFactory innerBuild(  
    );
    @Override
    }  
import org.opensearch.index.query.QueryBuilder;
        MultiValuesSourceParseHelper.declareField(WEIGHT_FIELD.getPreferredName(), PARSER, true, false, false);
import java.util.Objects;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.support.MultiValuesSourceFieldConfig;
    public WeightedAvgAggregationBuilder(WeightedAvgAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
import org.opensearch.search.aggregations.support.MultiValuesSourceParseHelper;
package org.opensearch.search.aggregations.metrics;
        return NAME;  
        MultiValuesSourceParseHelper.declareField(VALUE_FIELD.getPreferredName(), PARSER, true, false, false);
        MultiValuesSourceParseHelper.declareCommon(PARSER, true, ValueType.NUMERIC);  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
    @Override  
import org.opensearch.search.aggregations.support.MultiValuesSourceAggregatorFactory;  
 * Unless required by applicable law or agreed to in writing,
    public WeightedAvgAggregationBuilder(String name) {  
import java.io.IOException;
