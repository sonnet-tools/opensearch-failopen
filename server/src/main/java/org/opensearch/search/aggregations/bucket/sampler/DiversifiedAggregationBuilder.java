    }
     */
     * Set the execution hint.
 */
    }
    /**
     */
     */
        return shardSize;
 * KIND, either express or implied.  See the License for the
    }
        this.shardSize = shardSize;
/*
     * Get the max num docs to be returned per value.
        ValuesSourceConfig config,
    @Override
    @Override
            builder.field(SamplerAggregator.EXECUTION_HINT_FIELD.getPreferredName(), executionHint);
        super(clone, factoriesBuilder, metadata);
        if (maxDocsPerValue < 0) {
        }
            throw new IllegalArgumentException(
    protected ValuesSourceType defaultValueSourceType() {
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    @Override
import java.util.Map;
    }
     * Read from a stream.
        maxDocsPerValue = in.readVInt();
    /**
            && Objects.equals(maxDocsPerValue, other.maxDocsPerValue)
 * The OpenSearch Contributors require contributions made to
        return executionHint;
    public int maxDocsPerValue() {
    public static final int MAX_DOCS_PER_VALUE_DEFAULT = 1;
    }
        shardSize = in.readVInt();
    public BucketCardinality bucketCardinality() {
    public String executionHint() {
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public DiversifiedAggregationBuilder shardSize(int shardSize) {
import java.util.Objects;
     * Get the max num docs to be returned from each shard.
        QueryShardContext queryShardContext,
     * Set the max num docs to be returned per value.
 * Licensed to Elasticsearch under one or more contributor
 * compatible open source license.
    /**
            throw new IllegalArgumentException(
    protected void innerWriteTo(StreamOutput out) throws IOException {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    }
 * the Apache License, Version 2.0 (the "License"); you may
     * Get the execution hint.
            parent,
        out.writeVInt(maxDocsPerValue);
    @Override
/**
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    /**
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    public int shardSize() {
    protected ValuesSourceAggregatorFactory innerBuild(
    }
        if (shardSize < 0) {
 * software distributed under the License is distributed on an
    /**
    public static final ValuesSourceRegistry.RegistryKey<DiversifiedAggregatorSupplier> REGISTRY_KEY =
        super(in);
}
 * ownership. Elasticsearch licenses this file to you under
 *
            );
        this.executionHint = executionHint;
        super(name);
            subFactoriesBuilder,
 */
            executionHint,
    public DiversifiedAggregationBuilder(String name) {
    }
        return Objects.hash(super.hashCode(), shardSize, maxDocsPerValue, executionHint);
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
            && Objects.equals(executionHint, other.executionHint);
import org.opensearch.core.xcontent.ObjectParser;
    );
    }
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, false, false);
    public DiversifiedAggregationBuilder maxDocsPerValue(int maxDocsPerValue) {
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.equals(shardSize, other.shardSize)
    }
        DiversifiedAggregationBuilder::new
    @Override
    @Override
        return maxDocsPerValue;
            );
    protected DiversifiedAggregationBuilder(DiversifiedAggregationBuilder clone, Builder factoriesBuilder, Map<String, Object> metadata) {
     */
    private String executionHint = null;
        NAME,
package org.opensearch.search.aggregations.bucket.sampler;
        builder.field(SamplerAggregator.MAX_DOCS_PER_VALUE_FIELD.getPreferredName(), maxDocsPerValue);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
/*
    private int shardSize = SamplerAggregationBuilder.DEFAULT_SHARD_SAMPLE_SIZE;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
import org.opensearch.search.aggregations.AggregatorFactory;
            shardSize,
        Builder subFactoriesBuilder
    static {
     */
    }
 * GitHub history for details.
    public DiversifiedAggregationBuilder executionHint(String executionHint) {
        return CoreValuesSourceType.BYTES;
        return this;
    }
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            config,
    @Override
 *
     */
 * license agreements. See the NOTICE file distributed with
        out.writeOptionalString(executionHint);
        PARSER.declareInt(DiversifiedAggregationBuilder::maxDocsPerValue, SamplerAggregator.MAX_DOCS_PER_VALUE_FIELD);
        executionHint = in.readOptionalString();
import org.opensearch.index.query.QueryShardContext;
 * @opensearch.internal
        DiversifiedAggregationBuilder other = (DiversifiedAggregationBuilder) obj;
import org.opensearch.search.aggregations.support.ValuesSourceType;
        this.maxDocsPerValue = clone.maxDocsPerValue;
        new ValuesSourceRegistry.RegistryKey<>(NAME, DiversifiedAggregatorSupplier.class);
        return new DiversifiedAggregatorFactory(
/*
 *
        this.executionHint = clone.executionHint;
        DiversifiedAggregatorFactory.registerAggregators(builder);
    @Override
        PARSER.declareString(DiversifiedAggregationBuilder::executionHint, SamplerAggregator.EXECUTION_HINT_FIELD);
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
    }
        return NAME;
 * Aggregation Builder for diversified_sampler agg
        return REGISTRY_KEY;
            metadata
    ) throws IOException {
 * under the License.
        );
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
    private int maxDocsPerValue = MAX_DOCS_PER_VALUE_DEFAULT;
    public DiversifiedAggregationBuilder(StreamInput in) throws IOException {
import org.opensearch.search.aggregations.AggregationBuilder;
        return this;
 * specific language governing permissions and limitations
    }
    }
            name,
        builder.field(SamplerAggregator.SHARD_SIZE_FIELD.getPreferredName(), shardSize);
        if (super.equals(obj) == false) return false;
                "[maxDocsPerValue] must be greater than or equal to 0. Found [" + maxDocsPerValue + "] in [" + name + "]"
import org.opensearch.core.common.io.stream.StreamOutput;
 *
 * Modifications Copyright OpenSearch Contributors. See
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
     * Set the max num docs to be returned from each shard.
    public String getType() {
        }
        out.writeVInt(shardSize);
    }
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
 * not use this file except in compliance with the License.
        AggregatorFactory parent,
            queryShardContext,
            maxDocsPerValue,
    public int hashCode() {
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * You may obtain a copy of the License at
import java.io.IOException;
        if (executionHint != null) {
        }
        this.maxDocsPerValue = maxDocsPerValue;
                "[shardSize] must be greater than or equal to 0. Found [" + shardSize + "] in [" + name + "]"
        return new DiversifiedAggregationBuilder(this, factoriesBuilder, metadata);
    /**
    public boolean equals(Object obj) {
        if (this == obj) return true;
        PARSER.declareInt(DiversifiedAggregationBuilder::shardSize, SamplerAggregator.SHARD_SIZE_FIELD);
        return builder;
        return this;
    }
    }
    public static final String NAME = "diversified_sampler";
        this.shardSize = clone.shardSize;
        return BucketCardinality.ONE;
    public static final ObjectParser<DiversifiedAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
 */
 */
    }
    @Override
public class DiversifiedAggregationBuilder extends ValuesSourceAggregationBuilder<DiversifiedAggregationBuilder> {
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
     */
