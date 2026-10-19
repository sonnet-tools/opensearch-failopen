            shardSize,  
            metadata
    }
 * not use this file except in compliance with the License.
    }  
 * Modifications Copyright OpenSearch Contributors. See
        }
            );  
        if (numBuckets <= 0) {
        return NAME;  
    private int initialBuffer = -1;  
 * compatible open source license.
    @Override  
                    numBuckets,
 * You may obtain a copy of the License at  
    ) {  
        new ValuesSourceRegistry.RegistryKey<>(NAME, VariableWidthHistogramAggregatorSupplier.class);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public BucketCardinality bucketCardinality() {  
                String.format(
        ValuesSourceConfig config,
        if (initialBuffer <= 0) {
        NAME,  
 * software distributed under the License is distributed on an
    }  
    }  
    }
        Map<String, Object> metaData
 * under the License.  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
import org.opensearch.common.settings.Settings;
    public boolean equals(Object obj) {  
    public int getInitialBuffer() {
 * Unless required by applicable law or agreed to in writing,
            && Objects.equals(initialBuffer, other.initialBuffer);
    @Override
        this.numBuckets = numBuckets;
        AggregatorFactories.Builder factoriesBuilder,
 */  
        super(clone, factoriesBuilder, metaData);
import org.opensearch.search.aggregations.AggregationBuilder;
                    Locale.ROOT,
            return numBuckets * 50;
    protected ValuesSourceAggregatorFactory innerBuild(  
    @Override
    protected void innerWriteTo(StreamOutput out) throws IOException {
        }  
 * license agreements. See the NOTICE file distributed with
    }  
            // If the initial buckets from the merge phase is super low we will consistently return too few buckets
        return this;  
    public int getShardSize() {  
    }  
        int initialBuffer = getInitialBuffer();
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metaData) {
import org.opensearch.core.common.io.stream.StreamInput;  
    public VariableWidthHistogramAggregationBuilder setShardSize(int shardSize) {  
            queryShardContext,
    @Override  
                    + "<"
    }  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
/*
        );  
 * specific language governing permissions and limitations
                    name
            name,  
                    "%s must be at least %s but was [%s<%s] for [%s]",  
    @Override
            throw new IllegalArgumentException(NUM_BUCKETS_FIELD.getPreferredName() + " must be greater than [0] for [" + name + "]");  
        return this;
import org.opensearch.core.xcontent.XContentBuilder;  
                    + numBuckets
    /** Read in object data from a stream, for internal use only. */
        if (shardSize <= 1) {
    static {  
        }
            throw new IllegalArgumentException(  
    public VariableWidthHistogramAggregationBuilder(String name) {
    protected VariableWidthHistogramAggregationBuilder(
            // If numBuckets buckets are being returned, then at least that many must be stored in memory
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public String getType() {
        if (mergePhaseInit < numBuckets) {
import org.opensearch.core.common.io.stream.StreamOutput;
        return shardSize;
    @Override
    }
        return new VariableWidthHistogramAggregatorFactory(
    }
        return CoreValuesSourceType.NUMERIC;
        return Objects.hash(super.hashCode(), numBuckets, shardSize, initialBuffer);
 * the Apache License, Version 2.0 (the "License"); you may
        }
    private static final ParseField NUM_BUCKETS_FIELD = new ParseField("buckets");
                "3/4 of "
 *  
/*  
        return numBuckets;  
    }
        if (initialBuffer == -1) {
    }  
 * SPDX-License-Identifier: Apache-2.0
    private static final ParseField SHARD_SIZE_FIELD = new ParseField("shard_size");  
            numBuckets,
    private int numBuckets = 10;
        int mergePhaseInit = VariableWidthHistogramAggregator.mergePhaseInitialBucketCount(shardSize);  
            config,
        if (shardSize == -1) {
    }  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
        if (initialBuffer < numBuckets) {
 */
        VariableWidthHistogramAggregationBuilder other = (VariableWidthHistogramAggregationBuilder) obj;
 * Aggregation Builder for variable_width_histogram agg
import org.opensearch.search.aggregations.AggregatorFactory;
        AggregatorFactories.Builder subFactoriesBuilder
        out.writeVInt(numBuckets);
    public static final ValuesSourceRegistry.RegistryKey<VariableWidthHistogramAggregatorSupplier> REGISTRY_KEY =
    private int shardSize = -1;
        Settings settings = queryShardContext.getIndexSettings().getNodeSettings();  
        this.numBuckets = clone.numBuckets;
    }
 */  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    public static final String NAME = "variable_width_histogram";
                    + NUM_BUCKETS_FIELD.getPreferredName()
    /** Create a new builder with the given name. */  
import java.util.Locale;
        super(in);
            // A shard size of 1 will cause divide by 0s and, even if it worked, would produce garbage results.
 */
    @Override
        }  
/*  
        if (numBuckets > maxBuckets) {
        VariableWidthHistogramAggregatorFactory.registerAggregators(builder);  
    }
                    + "] for ["  
            throw new IllegalArgumentException(  
 *
    public VariableWidthHistogramAggregationBuilder setInitialBuffer(int initialBuffer) {  
    }
import org.opensearch.core.ParseField;
 * @opensearch.internal  
    }
import java.util.Map;  
import org.opensearch.core.xcontent.ObjectParser;
                    + name
                    + "]"
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, true);
/**  
    @Override
                    + " must be at least "  
import org.opensearch.search.aggregations.AggregatorFactories;  
        this.shardSize = shardSize;
        super(name);
        QueryShardContext queryShardContext,
    }
    protected ValuesSourceType defaultValueSourceType() {  
        PARSER.declareInt(VariableWidthHistogramAggregationBuilder::setNumBuckets, NUM_BUCKETS_FIELD);
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        int shardSize = getShardSize();  
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        PARSER.declareInt(VariableWidthHistogramAggregationBuilder::setShardSize, SHARD_SIZE_FIELD);  
 * KIND, either express or implied.  See the License for the
        }
                    + SHARD_SIZE_FIELD.getPreferredName()
                    NUM_BUCKETS_FIELD.getPreferredName(),
import java.io.IOException;
 *
    @Override  
        }
                    + " but was ["
    }
    ) throws IOException {
                )  
        numBuckets = in.readVInt();
import org.opensearch.index.query.QueryShardContext;
        VariableWidthHistogramAggregationBuilder clone,  
            initialBuffer,
        VariableWidthHistogramAggregationBuilder::new
    public VariableWidthHistogramAggregationBuilder(StreamInput in) throws IOException {  
 * GitHub history for details.
        return new VariableWidthHistogramAggregationBuilder(this, factoriesBuilder, metaData);  
            subFactoriesBuilder,
        PARSER.declareInt(VariableWidthHistogramAggregationBuilder::setInitialBuffer, INITIAL_BUFFER_FIELD);
            throw new IllegalArgumentException(SHARD_SIZE_FIELD.getPreferredName() + " must be greater than [1] for [" + name + "]");  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
            throw new IllegalArgumentException(NUM_BUCKETS_FIELD.getPreferredName() + " must be less than " + maxBuckets);  
    );
package org.opensearch.search.aggregations.bucket.histogram;
    }
        AggregatorFactory parent,  
        return initialBuffer;
        return Objects.equals(numBuckets, other.numBuckets)
                    + mergePhaseInit  
 * this file be licensed under the Apache-2.0 license or a
                    INITIAL_BUFFER_FIELD.getPreferredName(),
 *
 * The OpenSearch Contributors require contributions made to  
            return Math.min(10 * getShardSize(), 50000);  
        if (this == obj) return true;
import java.util.Objects;
        }
        this.initialBuffer = initialBuffer;
        int maxBuckets = MultiBucketConsumerService.MAX_BUCKET_SETTING.get(settings);
            );
    private static final ParseField INITIAL_BUFFER_FIELD = new ParseField("initial_buffer");
    }
 * Licensed to Elasticsearch under one or more contributor  
}
        if (obj == null || getClass() != obj.getClass()) return false;
        return REGISTRY_KEY;
        return builder;  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            throw new IllegalArgumentException(INITIAL_BUFFER_FIELD.getPreferredName() + " must be greater than [0] for [" + name + "]");
        if (super.equals(obj) == false) return false;  
    public int hashCode() {
                    initialBuffer,  
    @Override  
        return BucketCardinality.MANY;
    public VariableWidthHistogramAggregationBuilder setNumBuckets(int numBuckets) {
    public int getNumBuckets() {
        return this;  
    public static final ObjectParser<VariableWidthHistogramAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
            && Objects.equals(shardSize, other.shardSize)  
public class VariableWidthHistogramAggregationBuilder extends ValuesSourceAggregationBuilder<VariableWidthHistogramAggregationBuilder> {
        builder.field(NUM_BUCKETS_FIELD.getPreferredName(), numBuckets);
            parent,  
