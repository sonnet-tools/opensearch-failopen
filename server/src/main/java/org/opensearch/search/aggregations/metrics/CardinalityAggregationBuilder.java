import org.opensearch.core.xcontent.ObjectParser;
        if (this == obj) return true;
        }
            builder.field(EXECUTION_HINT_FIELD.getPreferredName(), executionHint);
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.search.aggregations.metrics;
        PARSER.declareLong((b, v) -> {/*ignore*/}, REHASH);
     */
        return new CardinalityAggregatorFactory(
 * this work for additional information regarding copyright
 *
        this.precisionThreshold = precisionThreshold;
    }
        }
            out.writeLong(precisionThreshold);
        AggregatorFactory parent,
            queryShardContext,
        CardinalityAggregatorFactory.registerAggregators(builder);
    ValuesSource,
    }
            metadata,
        AggregatorFactories.Builder subFactoriesBuilder
 *
        AggregatorFactories.Builder factoriesBuilder,
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, false, false);
import org.opensearch.search.aggregations.AggregatorFactory;
    @Override
 *
 * compatible open source license.
            );
        CardinalityAggregationBuilder clone,
    protected void innerWriteTo(StreamOutput out) throws IOException {
    public CardinalityAggregationBuilder precisionThreshold(long precisionThreshold) {
        this.executionHint = clone.executionHint;
        }
    /**
            parent,
    static {
    public boolean equals(Object obj) {
    @Override
    }
    @Override
        }
    protected ValuesSourceType defaultValueSourceType() {
        if (in.readBoolean()) {
        PARSER.declareString(CardinalityAggregationBuilder::executionHint, CardinalityAggregationBuilder.EXECUTION_HINT_FIELD);
    ) throws IOException {
    }
}
        super(clone, factoriesBuilder, metadata);
     * increase memory usage.
    @Override
import org.opensearch.Version;
import org.opensearch.search.aggregations.AggregationBuilder;
     */
        return REGISTRY_KEY;
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            subFactoriesBuilder,
    @Override
 * Unless required by applicable law or agreed to in writing,
        boolean hasPrecisionThreshold = precisionThreshold != null;
    public CardinalityAggregationBuilder(
        super(name);
        if (out.getVersion().onOrAfter(Version.V_2_19_1)) {
    @Override
            executionHint
        if (in.getVersion().onOrAfter(Version.V_2_19_1)) {
    private String executionHint = null;
    public static final String NAME = "cardinality";
import java.util.Map;
    public CardinalityAggregationBuilder(StreamInput in) throws IOException {
    /**
        );
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
     * Set a precision threshold. Higher values improve accuracy but also
        return this;
 * GitHub history for details.
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public CardinalityAggregationBuilder executionHint(String executionHint) {
     * Read from a stream.
import org.opensearch.core.common.io.stream.StreamOutput;
        if (obj == null || getClass() != obj.getClass()) return false;
        CardinalityAggregationBuilder::new
 * the Apache License, Version 2.0 (the "License"); you may
    }
        this.executionHint = executionHint;
 */
            precisionThreshold = in.readLong();
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                "[precisionThreshold] must be greater than or equal to 0. Found [" + precisionThreshold + "] in [" + name + "]"
import org.opensearch.search.aggregations.support.ValuesSource;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.search.aggregations.AggregatorFactories;
            throw new IllegalArgumentException(
        super(in);
        PARSER.declareLong(CardinalityAggregationBuilder::precisionThreshold, CardinalityAggregationBuilder.PRECISION_THRESHOLD_FIELD);
        return Objects.equals(precisionThreshold, other.precisionThreshold) && Objects.equals(executionHint, other.executionHint);
    public static final ValuesSourceRegistry.RegistryKey<CardinalityAggregatorSupplier> REGISTRY_KEY =
    @Override
        NAME,
        if (executionHint != null) {
        this.precisionThreshold = clone.precisionThreshold;
    public static final ObjectParser<CardinalityAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
import org.opensearch.core.xcontent.XContentBuilder;
            builder.field(PRECISION_THRESHOLD_FIELD.getPreferredName(), precisionThreshold);
    }
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    @Override
        return builder;
    @Override
            config,
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
    public static final ParseField EXECUTION_HINT_FIELD = new ParseField("execution_hint");
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to
/*
 * Licensed to Elasticsearch under one or more contributor
        QueryShardContext queryShardContext,
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Aggregation Builder for cardinality agg
        if (precisionThreshold != null) {
 */
        if (precisionThreshold < 0) {
        }
    CardinalityAggregationBuilder> {
 */
    public String getType() {
    }
 * You may obtain a copy of the License at
        return Objects.hash(super.hashCode(), precisionThreshold, executionHint);
        return NAME;
/*
        return this;
/**
 * under the License.
    }
    public CardinalityAggregationBuilder(String name) {
        new ValuesSourceRegistry.RegistryKey<>(NAME, CardinalityAggregatorSupplier.class);
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
    }
        }
    private static final ParseField REHASH = new ParseField("rehash").withAllDeprecated("no replacement - values will always be rehashed");
            name,
import java.util.Objects;
    }
    }
 * @opensearch.internal
import org.opensearch.index.query.QueryShardContext;
    }
            executionHint = in.readOptionalString();
    protected boolean serializeTargetValueType(Version version) {
            precisionThreshold,
    public int hashCode() {
        }
    public static final ParseField PRECISION_THRESHOLD_FIELD = new ParseField("precision_threshold");
    }
        ValuesSourceConfig config,
        return true;
        return new CardinalityAggregationBuilder(this, factoriesBuilder, metadata);
    protected CardinalityAggregatorFactory innerBuild(
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    private Long precisionThreshold = null;
 * specific language governing permissions and limitations
        return CoreValuesSourceType.BYTES;
    }
    ) {
    );
    }
        if (hasPrecisionThreshold) {
    }
 *
 */
import org.opensearch.core.ParseField;
        Map<String, Object> metadata
public final class CardinalityAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<
        CardinalityAggregationBuilder other = (CardinalityAggregationBuilder) obj;
            out.writeOptionalString(executionHint);
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        if (super.equals(obj) == false) return false;
        out.writeBoolean(hasPrecisionThreshold);
 * Modifications Copyright OpenSearch Contributors. See
    @Override
import java.io.IOException;
