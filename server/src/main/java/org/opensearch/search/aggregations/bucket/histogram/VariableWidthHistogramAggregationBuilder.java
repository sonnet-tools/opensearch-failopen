        VariableWidthHistogramAggregationBuilder clone,
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this;
        }
                    name
            initialBuffer,
    protected ValuesSourceType defaultValueSourceType() {
        }
    private static final ParseField SHARD_SIZE_FIELD = new ParseField("shard_size");
            return numBuckets * 50;
 *
import org.opensearch.search.aggregations.MultiBucketConsumerService;
/**
    }
 */
    @Override
    }
    public int getShardSize() {
            subFactoriesBuilder,
    /** Read in object data from a stream, for internal use only. */
        super(in);
            name,
                    "%s must be at least %s but was [%s<%s] for [%s]",
    public VariableWidthHistogramAggregationBuilder(StreamInput in) throws IOException {
                    + "] for ["
            throw new IllegalArgumentException(
    }
 *
 * this work for additional information regarding copyright
        Map<String, Object> metaData
        ValuesSourceConfig config,
        if (super.equals(obj) == false) return false;
 * GitHub history for details.
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, true);
    }
 *
    }
                    + numBuckets
    @Override
    }
        if (initialBuffer <= 0) {
            throw new IllegalArgumentException(
        VariableWidthHistogramAggregationBuilder::new
            throw new IllegalArgumentException(NUM_BUCKETS_FIELD.getPreferredName() + " must be less than " + maxBuckets);
        return new VariableWidthHistogramAggregatorFactory(
    }
        this.numBuckets = clone.numBuckets;
                "3/4 of "
        return this;
        return BucketCardinality.MANY;
    @Override
    );
        this.shardSize = shardSize;
import org.opensearch.search.aggregations.support.ValuesSourceType;
            parent,
        return Objects.equals(numBuckets, other.numBuckets)
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    }
        return numBuckets;
        PARSER.declareInt(VariableWidthHistogramAggregationBuilder::setNumBuckets, NUM_BUCKETS_FIELD);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
 */
    private int numBuckets = 10;
    protected VariableWidthHistogramAggregationBuilder(
                    Locale.ROOT,
        numBuckets = in.readVInt();
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        int initialBuffer = getInitialBuffer();
    static {
    public static final ValuesSourceRegistry.RegistryKey<VariableWidthHistogramAggregatorSupplier> REGISTRY_KEY =
    @Override
    }
}
        super(name);
 * @opensearch.internal
    }
            );
                    + "]"
    @Override
import org.opensearch.search.aggregations.AggregatorFactories;
 * The OpenSearch Contributors require contributions made to
                    NUM_BUCKETS_FIELD.getPreferredName(),
        int maxBuckets = MultiBucketConsumerService.MAX_BUCKET_SETTING.get(settings);
            shardSize,
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentBuilder;
                    INITIAL_BUFFER_FIELD.getPreferredName(),
            );
    }
        }
        PARSER.declareInt(VariableWidthHistogramAggregationBuilder::setInitialBuffer, INITIAL_BUFFER_FIELD);
    }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.ObjectParser;
            throw new IllegalArgumentException(SHARD_SIZE_FIELD.getPreferredName() + " must be greater than [1] for [" + name + "]");
public class VariableWidthHistogramAggregationBuilder extends ValuesSourceAggregationBuilder<VariableWidthHistogramAggregationBuilder> {
    public VariableWidthHistogramAggregationBuilder(String name) {
        int shardSize = getShardSize();
            // A shard size of 1 will cause divide by 0s and, even if it worked, would produce garbage results.
/*
        }
            && Objects.equals(initialBuffer, other.initialBuffer);
                    + " but was ["
        if (shardSize == -1) {
        VariableWidthHistogramAggregationBuilder other = (VariableWidthHistogramAggregationBuilder) obj;
        );
    /** Create a new builder with the given name. */
        this.initialBuffer = initialBuffer;
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metaData) {
    public int hashCode() {
        PARSER.declareInt(VariableWidthHistogramAggregationBuilder::setShardSize, SHARD_SIZE_FIELD);
    public int getInitialBuffer() {
 * Licensed to Elasticsearch under one or more contributor
        new ValuesSourceRegistry.RegistryKey<>(NAME, VariableWidthHistogramAggregatorSupplier.class);
                    + SHARD_SIZE_FIELD.getPreferredName()
    @Override
                    + "<"
        return this;
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            // If the initial buckets from the merge phase is super low we will consistently return too few buckets
    private int initialBuffer = -1;
 * under the License.
 * this file be licensed under the Apache-2.0 license or a
    protected void innerWriteTo(StreamOutput out) throws IOException {
import org.opensearch.search.aggregations.AggregationBuilder;
    public boolean equals(Object obj) {
                    numBuckets,
            && Objects.equals(shardSize, other.shardSize)
import java.io.IOException;
import org.opensearch.common.settings.Settings;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        if (obj == null || getClass() != obj.getClass()) return false;
            queryShardContext,
        return Objects.hash(super.hashCode(), numBuckets, shardSize, initialBuffer);
        Settings settings = queryShardContext.getIndexSettings().getNodeSettings();
        return shardSize;
    @Override
    }
        int mergePhaseInit = VariableWidthHistogramAggregator.mergePhaseInitialBucketCount(shardSize);
        return NAME;
        out.writeVInt(numBuckets);
/*
import java.util.Objects;
 * SPDX-License-Identifier: Apache-2.0
        }
            // If numBuckets buckets are being returned, then at least that many must be stored in memory
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
 * KIND, either express or implied.  See the License for the
    public static final ObjectParser<VariableWidthHistogramAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
    ) throws IOException {
 * specific language governing permissions and limitations
    }
                    + name
    public static final String NAME = "variable_width_histogram";
    @Override
    ) {
                )
                    + " must be at least "
 * Aggregation Builder for variable_width_histogram agg
    protected ValuesSourceAggregatorFactory innerBuild(
        this.numBuckets = numBuckets;
 * software distributed under the License is distributed on an
        return CoreValuesSourceType.NUMERIC;
            throw new IllegalArgumentException(NUM_BUCKETS_FIELD.getPreferredName() + " must be greater than [0] for [" + name + "]");
        AggregatorFactories.Builder factoriesBuilder,
                    + mergePhaseInit
            numBuckets,
                    + NUM_BUCKETS_FIELD.getPreferredName()
    @Override
        if (numBuckets > maxBuckets) {
    }
    private static final ParseField NUM_BUCKETS_FIELD = new ParseField("buckets");
                    initialBuffer,
        if (shardSize <= 1) {
 */
 * compatible open source license.
    public int getNumBuckets() {
 * ownership. Elasticsearch licenses this file to you under
        }
    public String getType() {
        if (initialBuffer == -1) {
        }
import org.opensearch.core.common.io.stream.StreamOutput;
import java.util.Map;
    }
    private static final ParseField INITIAL_BUFFER_FIELD = new ParseField("initial_buffer");
            metadata
        if (this == obj) return true;
        return new VariableWidthHistogramAggregationBuilder(this, factoriesBuilder, metaData);
 * license agreements. See the NOTICE file distributed with
        return initialBuffer;
        if (numBuckets <= 0) {
        super(clone, factoriesBuilder, metaData);
    @Override
 * not use this file except in compliance with the License.
/*
    }
        }
        AggregatorFactory parent,
        if (mergePhaseInit < numBuckets) {
        return REGISTRY_KEY;
    public BucketCardinality bucketCardinality() {
 */
        return builder;
import org.opensearch.core.ParseField;
import org.opensearch.search.aggregations.AggregatorFactory;
import java.util.Locale;
        QueryShardContext queryShardContext,
import org.opensearch.index.query.QueryShardContext;
        if (initialBuffer < numBuckets) {
            return Math.min(10 * getShardSize(), 50000);
            config,
                String.format(
package org.opensearch.search.aggregations.bucket.histogram;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        AggregatorFactories.Builder subFactoriesBuilder
    public VariableWidthHistogramAggregationBuilder setInitialBuffer(int initialBuffer) {
        NAME,
    private int shardSize = -1;
        VariableWidthHistogramAggregatorFactory.registerAggregators(builder);
import org.opensearch.core.common.io.stream.StreamInput;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    public VariableWidthHistogramAggregationBuilder setShardSize(int shardSize) {
    public VariableWidthHistogramAggregationBuilder setNumBuckets(int numBuckets) {
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
            throw new IllegalArgumentException(INITIAL_BUFFER_FIELD.getPreferredName() + " must be greater than [0] for [" + name + "]");
    }
 *
    }
        builder.field(NUM_BUCKETS_FIELD.getPreferredName(), numBuckets);
