            executionHint = in.readOptionalString();
 * Licensed to Elasticsearch under one or more contributor  
    }
        }  
    static {
            subFactoriesBuilder,  
        }
 */
        super(name);
    public boolean equals(Object obj) {
    private Long precisionThreshold = null;  
    @Override
import org.opensearch.core.xcontent.XContentBuilder;  
    }
import java.util.Objects;
    /**
        }
        super(in);  
/*  
        return true;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        if (this == obj) return true;  
        this.precisionThreshold = clone.precisionThreshold;
    }  
 *
        PARSER.declareLong((b, v) -> {/*ignore*/}, REHASH);
    public CardinalityAggregationBuilder(
    public int hashCode() {  
 * software distributed under the License is distributed on an
     * increase memory usage.  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    protected boolean serializeTargetValueType(Version version) {  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
     * Read from a stream.  
    protected void innerWriteTo(StreamOutput out) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (out.getVersion().onOrAfter(Version.V_2_19_1)) {  
        Map<String, Object> metadata
import org.opensearch.search.aggregations.AggregatorFactories;  
            queryShardContext,
    ) {  
    }  
/*  
import java.io.IOException;  
        PARSER.declareString(CardinalityAggregationBuilder::executionHint, CardinalityAggregationBuilder.EXECUTION_HINT_FIELD);
        NAME,
        return Objects.hash(super.hashCode(), precisionThreshold, executionHint);
        if (in.readBoolean()) {
    }
 * this file be licensed under the Apache-2.0 license or a
        return new CardinalityAggregatorFactory(  
 *  
/*
    CardinalityAggregationBuilder> {
    }
        ValuesSourceConfig config,
     * Set a precision threshold. Higher values improve accuracy but also
import org.opensearch.search.aggregations.AggregatorFactory;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.support.ValuesSourceType;
 */  
        if (precisionThreshold < 0) {  
    }  
 * not use this file except in compliance with the License.
            out.writeLong(precisionThreshold);
        return this;
    public static final ParseField EXECUTION_HINT_FIELD = new ParseField("execution_hint");
    @Override  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    protected ValuesSourceType defaultValueSourceType() {
    @Override
        AggregatorFactories.Builder factoriesBuilder,
            name,
        CardinalityAggregationBuilder other = (CardinalityAggregationBuilder) obj;  
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, false, false);
    public String getType() {
import java.util.Map;
 *
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryShardContext;
    }
    public static final ValuesSourceRegistry.RegistryKey<CardinalityAggregatorSupplier> REGISTRY_KEY =
    );  
 * Aggregation Builder for cardinality agg
        );  
        return REGISTRY_KEY;
    ) throws IOException {
 * compatible open source license.
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    @Override  
        if (obj == null || getClass() != obj.getClass()) return false;
    public static final ObjectParser<CardinalityAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(  
        }  
import org.opensearch.core.ParseField;
public final class CardinalityAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<  
/**
        if (precisionThreshold != null) {
    private static final ParseField REHASH = new ParseField("rehash").withAllDeprecated("no replacement - values will always be rehashed");
 *  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        }
    }
import org.opensearch.Version;
 * ownership. Elasticsearch licenses this file to you under  
        CardinalityAggregationBuilder::new
 * this work for additional information regarding copyright
        AggregatorFactories.Builder subFactoriesBuilder
        return this;  
 * You may obtain a copy of the License at  
            builder.field(EXECUTION_HINT_FIELD.getPreferredName(), executionHint);  
    }
        out.writeBoolean(hasPrecisionThreshold);
import org.opensearch.search.aggregations.AggregationBuilder;
     */
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
        if (hasPrecisionThreshold) {  
        QueryShardContext queryShardContext,
        return Objects.equals(precisionThreshold, other.precisionThreshold) && Objects.equals(executionHint, other.executionHint);
 * KIND, either express or implied.  See the License for the
    public CardinalityAggregationBuilder executionHint(String executionHint) {  
        this.precisionThreshold = precisionThreshold;
import org.opensearch.core.xcontent.ObjectParser;
    public CardinalityAggregationBuilder precisionThreshold(long precisionThreshold) {
    public static final ParseField PRECISION_THRESHOLD_FIELD = new ParseField("precision_threshold");  
        }
    public CardinalityAggregationBuilder(String name) {
    public CardinalityAggregationBuilder(StreamInput in) throws IOException {
            throw new IllegalArgumentException(
    private String executionHint = null;
        this.executionHint = clone.executionHint;  
    @Override
        new ValuesSourceRegistry.RegistryKey<>(NAME, CardinalityAggregatorSupplier.class);  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
}
import org.opensearch.search.aggregations.support.ValuesSource;  
            out.writeOptionalString(executionHint);
        if (super.equals(obj) == false) return false;
        return new CardinalityAggregationBuilder(this, factoriesBuilder, metadata);
        boolean hasPrecisionThreshold = precisionThreshold != null;
 * @opensearch.internal
    public static final String NAME = "cardinality";
package org.opensearch.search.aggregations.metrics;
import org.opensearch.core.common.io.stream.StreamOutput;
 * GitHub history for details.
        return builder;
        if (in.getVersion().onOrAfter(Version.V_2_19_1)) {
            builder.field(PRECISION_THRESHOLD_FIELD.getPreferredName(), precisionThreshold);  
 * SPDX-License-Identifier: Apache-2.0
            precisionThreshold = in.readLong();
 */
        }
        return CoreValuesSourceType.BYTES;
    /**
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 * Modifications Copyright OpenSearch Contributors. See
            precisionThreshold,  
            executionHint
            );  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
        this.executionHint = executionHint;
            parent,
        CardinalityAggregationBuilder clone,  
 * under the License.  
        PARSER.declareLong(CardinalityAggregationBuilder::precisionThreshold, CardinalityAggregationBuilder.PRECISION_THRESHOLD_FIELD);  
    }  
            metadata,
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        CardinalityAggregatorFactory.registerAggregators(builder);  
    @Override  
    }  
            config,
    ValuesSource,
        if (executionHint != null) {
        super(clone, factoriesBuilder, metadata);
                "[precisionThreshold] must be greater than or equal to 0. Found [" + precisionThreshold + "] in [" + name + "]"
    @Override
    @Override  
    }  
    @Override
        AggregatorFactory parent,  
    }  
    protected CardinalityAggregatorFactory innerBuild(  
    }  
     */
 */  
        return NAME;  
