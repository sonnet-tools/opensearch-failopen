 * Licensed to Elasticsearch under one or more contributor
    }
            includeExclude,
import org.opensearch.core.xcontent.ObjectParser;
 *
    private static final int MAX_MAX_DOC_COUNT = 100;
            (b, v) -> b.includeExclude(IncludeExclude.merge(v, b.includeExclude())),
    }
            includeExclude.toXContent(builder, params);
        return Objects.equals(includeExclude, other.includeExclude)
            throw new IllegalArgumentException("[precision] must be greater than 0.00001");
    /**
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }
    }
    }
            name,
/**
    }
    @Override
    public RareTermsAggregationBuilder maxDocCount(long maxDocCount) {
    @Override
 */
        return this;
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        ValuesSourceConfig config,
    private IncludeExclude includeExclude = null;
    }
}
import org.opensearch.core.xcontent.XContentBuilder;
        return builder;
            precision
 * license agreements. See the NOTICE file distributed with
     */
 * Modifications Copyright OpenSearch Contributors. See
    public int hashCode() {
package org.opensearch.search.aggregations.bucket.terms;
        return Objects.hash(super.hashCode(), includeExclude, maxDocCount, precision);
    }
        return BucketCardinality.MANY;
    private int maxDocCount = 1;
    }
    }
        RareTermsAggregationBuilder clone,
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        if (super.equals(obj) == false) return false;
    );
 * You may obtain a copy of the License at
    protected void innerWriteTo(StreamOutput out) throws IOException {
 * this work for additional information regarding copyright
    /**
            throw new IllegalArgumentException(
    public static final String NAME = "rare_terms";
 * this file be licensed under the Apache-2.0 license or a
    public IncludeExclude includeExclude() {
        builder.field(PRECISION.getPreferredName(), precision);
        RareTermsAggregatorSupplier.class
        }
        this.includeExclude = includeExclude;
                    + maxDocCount
 *
    @Override
            IncludeExclude.EXCLUDE_FIELD,
    }
     */
            IncludeExclude.INCLUDE_FIELD,
                "[" + MAX_DOC_COUNT_FIELD_NAME.getPreferredName() + "] must be smaller" + "than " + MAX_MAX_DOC_COUNT + "in [" + name + "]"
            subFactoriesBuilder,
    public void setPrecision(double precision) {
    static {
 *
/*
     * Set the maximum document count terms should have in order to appear in
        );
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    ) {
        return REGISTRY_KEY;
                "["
 * specific language governing permissions and limitations
        out.writeVInt(maxDocCount);
        super(in);
        PARSER.declareLong(RareTermsAggregationBuilder::maxDocCount, MAX_DOC_COUNT_FIELD_NAME);
 */
/*
    @Override
     * This value does, however, affect the overall space usage of the filter.  Coarser precisions provide
    }
import org.opensearch.search.aggregations.AggregatorFactory;
            queryShardContext,
/*
     * since we use a "scaling" cuckoo filter which adds more filters as required, and the overall
import org.opensearch.core.common.io.stream.StreamOutput;
                    + "] must be greater than 0. Found ["
                    + "] in ["
    /**
    private static final ParseField MAX_DOC_COUNT_FIELD_NAME = new ParseField("max_doc_count");
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
     * Set terms to include and exclude from the aggregation results
    private static final ParseField PRECISION = new ParseField("precision");
    private double precision = 0.001;
        // TODO review: what size cap should we put on this?
            (b, v) -> b.includeExclude(IncludeExclude.merge(b.includeExclude(), v)),
     * Set's the false-positive rate for individual cuckoo filters.  Does not dictate the overall fpp rate
    }
    @Override
        this.precision = precision;
                    + "]"
    }
 * the Apache License, Version 2.0 (the "License"); you may
        );
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    );
        PARSER.declareField(
    public BucketCardinality bucketCardinality() {
    protected boolean serializeTargetValueType(Version version) {
        return this;
        QueryShardContext queryShardContext,
    @Override
        return NAME;
        }
     * more compact filters.  The default is 0.01
        return precision;
    /**
import org.opensearch.search.aggregations.support.ValuesSourceType;
 * not use this file except in compliance with the License.
        super(name);
    @Override
    private RareTermsAggregationBuilder(
     */
    public RareTermsAggregationBuilder(String name) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.
     * error rate grows differently than individual filters
     */
    public boolean equals(Object obj) {
            metadata,
            throw new IllegalArgumentException(
     * Get terms to include and exclude from the aggregation results
    }
    public static final ValuesSourceRegistry.RegistryKey<RareTermsAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
        RareTermsAggregationBuilder::new
        this.maxDocCount = (int) maxDocCount;
        AggregatorFactories.Builder factoriesBuilder,
    public RareTermsAggregationBuilder(StreamInput in) throws IOException {
     */
    ) throws IOException {
    }
            IncludeExclude::parseExclude,
import org.opensearch.core.common.io.stream.StreamInput;
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 * The OpenSearch Contributors require contributions made to
        RareTermsAggregationBuilder other = (RareTermsAggregationBuilder) obj;
import java.util.Map;
        out.writeOptionalWriteable(includeExclude);
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
 * Aggregation Builder for rare_terms agg
        return new RareTermsAggregationBuilder(this, factoriesBuilder, metadata);
        if (maxDocCount > MAX_MAX_DOC_COUNT) {
 * GitHub history for details.
        );
        this.includeExclude = clone.includeExclude;
        NAME,
     * the response.
            parent,
            maxDocCount,
        return CoreValuesSourceType.BYTES;
 * @opensearch.internal
            );
        builder.field(MAX_DOC_COUNT_FIELD_NAME.getPreferredName(), maxDocCount);
    }
     * Read from a stream.
        }
        return new RareTermsAggregatorFactory(
    @Override
        if (precision < 0.00001) {
            IncludeExclude::parseInclude,
    }
 * Unless required by applicable law or agreed to in writing,
    @Override
        RareTermsAggregatorFactory.registerAggregators(builder);
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        PARSER.declareDouble(RareTermsAggregationBuilder::setPrecision, PRECISION);
        super(clone, factoriesBuilder, metadata);
     */
        AggregatorFactories.Builder subFactoriesBuilder
import org.opensearch.search.aggregations.AggregationBuilder;
    /**
    public double getPrecision() {
        return includeExclude;
        return true;
    /**
 * ownership. Elasticsearch licenses this file to you under
 */
        if (this == obj) return true;
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
 * compatible open source license.
    public static final ObjectParser<RareTermsAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
            ObjectParser.ValueType.STRING_ARRAY
 * SPDX-License-Identifier: Apache-2.0
                    + MAX_DOC_COUNT_FIELD_NAME.getPreferredName()
import org.opensearch.core.ParseField;
import org.opensearch.Version;
        AggregatorFactory parent,
        maxDocCount = in.readVInt();
import org.opensearch.search.aggregations.AggregatorFactories;
    }
                    + name
            && Objects.equals(precision, other.precision);
        PARSER.declareField(
    public String getType() {
    public RareTermsAggregationBuilder includeExclude(IncludeExclude includeExclude) {
 */
    protected ValuesSourceAggregatorFactory innerBuild(
import java.io.IOException;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
public class RareTermsAggregationBuilder extends ValuesSourceAggregationBuilder<RareTermsAggregationBuilder> {
 *
import org.opensearch.index.query.QueryShardContext;
import java.util.Objects;
        includeExclude = in.readOptionalWriteable(IncludeExclude::new);
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            config,
        NAME,
    @Override
    }
    protected ValuesSourceType defaultValueSourceType() {
        if (maxDocCount <= 0) {
        Map<String, Object> metadata
    @Override
     * Get the current false positive rate for individual cuckoo filters.
    }
        }
        if (includeExclude != null) {
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;
     * <p>
            && Objects.equals(maxDocCount, other.maxDocCount)
