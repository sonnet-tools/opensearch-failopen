import org.opensearch.search.aggregations.AggregationBuilder;  
     */
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
    public DiversifiedAggregationBuilder(String name) {  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {  
 *
            && Objects.equals(executionHint, other.executionHint);  
    @Override
     * Set the max num docs to be returned per value.
        builder.field(SamplerAggregator.MAX_DOCS_PER_VALUE_FIELD.getPreferredName(), maxDocsPerValue);
 * ownership. Elasticsearch licenses this file to you under  
     * Get the max num docs to be returned from each shard.
 * license agreements. See the NOTICE file distributed with
    }
            );
        if (maxDocsPerValue < 0) {
    }
     * Get the max num docs to be returned per value.  
    }  
    }  
    /**  
            subFactoriesBuilder,
}  
    /**
     */
        Builder subFactoriesBuilder
    public DiversifiedAggregationBuilder maxDocsPerValue(int maxDocsPerValue) {
 * KIND, either express or implied.  See the License for the
    /**
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
import java.util.Objects;  
    public int hashCode() {  
 */  
    protected DiversifiedAggregationBuilder(DiversifiedAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
        AggregatorFactory parent,  
     * Set the max num docs to be returned from each shard.  
    protected void innerWriteTo(StreamOutput out) throws IOException {
            && Objects.equals(maxDocsPerValue, other.maxDocsPerValue)
        return NAME;
        }
    private String executionHint = null;
 * The OpenSearch Contributors require contributions made to  
    public DiversifiedAggregationBuilder executionHint(String executionHint) {  
    public String executionHint() {
    }
        shardSize = in.readVInt();
    }  
        return BucketCardinality.ONE;
        new ValuesSourceRegistry.RegistryKey<>(NAME, DiversifiedAggregatorSupplier.class);
        return builder;
    @Override
 *
    }
        );
     */
        NAME,  
    }
    @Override
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public DiversifiedAggregationBuilder(StreamInput in) throws IOException {  
        return this;
            name,
 * Unless required by applicable law or agreed to in writing,
    public String getType() {
    public DiversifiedAggregationBuilder shardSize(int shardSize) {
    private int shardSize = SamplerAggregationBuilder.DEFAULT_SHARD_SAMPLE_SIZE;
        out.writeVInt(maxDocsPerValue);
     */
    public static final int MAX_DOCS_PER_VALUE_DEFAULT = 1;  
/*  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    }
    );
        return this;  
        return shardSize;
     */
    public BucketCardinality bucketCardinality() {
        this.shardSize = clone.shardSize;  
        return new DiversifiedAggregationBuilder(this, factoriesBuilder, metadata);  
import org.opensearch.search.aggregations.AggregatorFactory;
 * not use this file except in compliance with the License.
 * compatible open source license.
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
import org.opensearch.core.common.io.stream.StreamInput;
    protected ValuesSourceAggregatorFactory innerBuild(  
    }
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
            maxDocsPerValue,
 * software distributed under the License is distributed on an
    public int shardSize() {  
    @Override  
import java.io.IOException;
    public int maxDocsPerValue() {
    public static final String NAME = "diversified_sampler";
 * under the License.  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        QueryShardContext queryShardContext,
        return Objects.hash(super.hashCode(), shardSize, maxDocsPerValue, executionHint);
/*
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
            );  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        if (shardSize < 0) {  
        }  
    /**  
     */
        DiversifiedAggregationBuilder other = (DiversifiedAggregationBuilder) obj;  
        out.writeVInt(shardSize);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
            metadata  
        super(in);
    ) throws IOException {
 * @opensearch.internal
        super(clone, factoriesBuilder, metadata);
 * You may obtain a copy of the License at  
package org.opensearch.search.aggregations.bucket.sampler;
        return REGISTRY_KEY;
     * Get the execution hint.  
            throw new IllegalArgumentException(  
    /**
    protected ValuesSourceType defaultValueSourceType() {  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 * Modifications Copyright OpenSearch Contributors. See
    }  
import org.opensearch.core.xcontent.XContentBuilder;
    }
 *
        super(name);
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, false, false);
        this.shardSize = shardSize;
            parent,
    }  
public class DiversifiedAggregationBuilder extends ValuesSourceAggregationBuilder<DiversifiedAggregationBuilder> {
                "[shardSize] must be greater than or equal to 0. Found [" + shardSize + "] in [" + name + "]"
            queryShardContext,  
    @Override  
    private int maxDocsPerValue = MAX_DOCS_PER_VALUE_DEFAULT;  
    }
     * Read from a stream.
 * Licensed to Elasticsearch under one or more contributor  
        executionHint = in.readOptionalString();
        return this;
            executionHint,
        if (executionHint != null) {
 * specific language governing permissions and limitations
    @Override
    }  
 *  
        if (this == obj) return true;  
    }
 * this file be licensed under the Apache-2.0 license or a
        this.executionHint = executionHint;
     */  
 * GitHub history for details.
                "[maxDocsPerValue] must be greater than or equal to 0. Found [" + maxDocsPerValue + "] in [" + name + "]"
 * SPDX-License-Identifier: Apache-2.0
        return maxDocsPerValue;  
        ValuesSourceConfig config,
            builder.field(SamplerAggregator.EXECUTION_HINT_FIELD.getPreferredName(), executionHint);  
    }  
    public static final ObjectParser<DiversifiedAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
        this.maxDocsPerValue = clone.maxDocsPerValue;
/**
        DiversifiedAggregatorFactory.registerAggregators(builder);
    public static final ValuesSourceRegistry.RegistryKey<DiversifiedAggregatorSupplier> REGISTRY_KEY =  
    static {  
        return CoreValuesSourceType.BYTES;
        PARSER.declareInt(DiversifiedAggregationBuilder::maxDocsPerValue, SamplerAggregator.MAX_DOCS_PER_VALUE_FIELD);  
        return executionHint;  
    }
    /**
import org.opensearch.core.xcontent.ObjectParser;  
        return new DiversifiedAggregatorFactory(  
        this.executionHint = clone.executionHint;
            throw new IllegalArgumentException(
    }  
        PARSER.declareString(DiversifiedAggregationBuilder::executionHint, SamplerAggregator.EXECUTION_HINT_FIELD);
        if (obj == null || getClass() != obj.getClass()) return false;
        out.writeOptionalString(executionHint);
 * Aggregation Builder for diversified_sampler agg  
 * this work for additional information regarding copyright
        DiversifiedAggregationBuilder::new
    @Override
    }
            config,
        if (super.equals(obj) == false) return false;
/*  
        builder.field(SamplerAggregator.SHARD_SIZE_FIELD.getPreferredName(), shardSize);  
        return Objects.equals(shardSize, other.shardSize)
        maxDocsPerValue = in.readVInt();  
import java.util.Map;
    public boolean equals(Object obj) {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
    @Override
 */
        PARSER.declareInt(DiversifiedAggregationBuilder::shardSize, SamplerAggregator.SHARD_SIZE_FIELD);
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            shardSize,  
        this.maxDocsPerValue = maxDocsPerValue;
 */  
    /**  
     * Set the execution hint.
        }
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.query.QueryShardContext;
