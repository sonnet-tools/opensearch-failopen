    static {
        return new SignificantTermsAggregatorFactory(
        if (executionHint != null) {
    @Override
    public static SignificantTermsAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
    }
            throw new IllegalArgumentException("[backgroundFilter] must not be null: [" + name + "]");
        }
    }
        this.filterBuilder = backgroundFilter;
        PARSER.declareLong(SignificantTermsAggregationBuilder::shardMinDocCount, TermsAggregationBuilder.SHARD_MIN_DOC_COUNT_FIELD_NAME);
            (p, context) -> parseInnerQueryBuilder(p),
     * Set the minimum document count terms should have in order to appear in
    static final ParseField BACKGROUND_FILTER = new ParseField("background_filter");
        return CoreValuesSourceType.BYTES;
        SignificantTermsAggregatorFactory.registerAggregators(builder);
     * the response.
    }
        filterBuilder = in.readOptionalNamedWriteable(QueryBuilder.class);
        -1
    }
        return executionHint;
    }
        this.includeExclude = includeExclude;
    /**
    @Override
 * license agreements. See the NOTICE file distributed with
     * Get terms to include and exclude from the aggregation results
     */
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    protected TermsAggregator.BucketCountThresholds getBucketCountThresholds() {
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
            throw new IllegalArgumentException("[significanceHeuristic] must not be null: [" + name + "]");
    @Override
            builder.field(BACKGROUND_FILTER.getPreferredName(), filterBuilder);
     * Expert: gets an execution hint to the aggregation.
    @Override
    }
    }
    public TermsAggregator.BucketCountThresholds bucketCountThresholds() {
public class SignificantTermsAggregationBuilder extends ValuesSourceAggregationBuilder<SignificantTermsAggregationBuilder> {
        return this;
        return filterBuilder;
import org.opensearch.index.query.QueryRewriteContext;
        return this;
        if (obj == null || getClass() != obj.getClass()) return false;
    protected ValuesSourceType defaultValueSourceType() {
        }
import org.opensearch.search.aggregations.AggregationBuilder;
     */
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");
        SignificantTermsAggregationBuilder clone,
    private String executionHint = null;
            executionHint,
     */
        return Objects.equals(bucketCountThresholds, other.bucketCountThresholds)
        if (backgroundFilter == null) {
    /**
            && Objects.equals(executionHint, other.executionHint)
    }
        out.writeOptionalString(executionHint);
     * Set terms to include and exclude from the aggregation results
 * The OpenSearch Contributors require contributions made to
            parent,
    public SignificantTermsAggregationBuilder backgroundFilter(QueryBuilder backgroundFilter) {
    public SignificantTermsAggregationBuilder bucketCountThresholds(TermsAggregator.BucketCountThresholds bucketCountThresholds) {
        if (shardSize <= 0) {
    );
    }
    }
        return includeExclude;
            QueryBuilder rewrittenFilter = filterBuilder.rewrite(queryShardContext);
        }
        );
 * software distributed under the License is distributed on an
    }
            throw new IllegalArgumentException("[shardSize] must be greater than  0. Found [" + shardSize + "] in [" + name + "]");
     * appear in the response.
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            );
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;
package org.opensearch.search.aggregations.bucket.terms;
        }
import org.opensearch.core.xcontent.XContentBuilder;
        }
    static final TermsAggregator.BucketCountThresholds DEFAULT_BUCKET_COUNT_THRESHOLDS = new TermsAggregator.BucketCountThresholds(
    public SignificantTermsAggregationBuilder shardSize(int shardSize) {
import org.opensearch.core.common.io.stream.StreamOutput;
 * under the License.
import org.opensearch.index.query.QueryBuilder;
        this.includeExclude = clone.includeExclude;
        PARSER.declareInt(SignificantTermsAggregationBuilder::size, TermsAggregationBuilder.REQUIRED_SIZE_FIELD_NAME);
    @Override
 * Aggregation Builder for significant terms agg
 * this work for additional information regarding copyright
    /**
        0,
    }
        AggregatorFactory parent,
        return bucketCountThresholds;
        return this;
            IncludeExclude::parseExclude,
            );
    protected ValuesSourceAggregatorFactory innerBuild(
import java.util.Map;
    }
    }
        includeExclude = in.readOptionalWriteable(IncludeExclude::new);
    @Override
        if (bucketCountThresholds == null) {
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
 * SPDX-License-Identifier: Apache-2.0
        return Objects.hash(super.hashCode(), bucketCountThresholds, executionHint, filterBuilder, includeExclude, significanceHeuristic);
            builder.field(TermsAggregationBuilder.EXECUTION_HINT_FIELD_NAME.getPreferredName(), executionHint);
        bucketCountThresholds.toXContent(builder, params);
    public SignificantTermsAggregationBuilder includeExclude(IncludeExclude includeExclude) {
        return true;
    public SignificanceHeuristic significanceHeuristic() {
/*
        this.significanceHeuristic = significanceHeuristic;
        this.filterBuilder = clone.filterBuilder;
    private static final ObjectParser<SignificantTermsAggregationBuilder, Void> PARSER = new ObjectParser<>(
        super(name);
    static final SignificanceHeuristic DEFAULT_SIGNIFICANCE_HEURISTIC = new JLHScore();
            (b, v) -> b.includeExclude(IncludeExclude.merge(b.includeExclude(), v)),
            IncludeExclude::parseInclude,
        super(in);
        out.writeOptionalWriteable(includeExclude);
        }
 * Modifications Copyright OpenSearch Contributors. See
        null
        SignificantTermsAggregationBuilder::significanceHeuristic,
        PARSER.declareString(SignificantTermsAggregationBuilder::executionHint, TermsAggregationBuilder.EXECUTION_HINT_FIELD_NAME);
 *
    public SignificantTermsAggregationBuilder size(int size) {
    private SignificanceHeuristic significanceHeuristic = DEFAULT_SIGNIFICANCE_HEURISTIC;
        if (minDocCount < 0) {
import org.opensearch.core.xcontent.XContentParser;
     * (defaults to 10)
     * Expert: sets an execution hint to the aggregation.
        PARSER.declareLong(SignificantTermsAggregationBuilder::minDocCount, TermsAggregationBuilder.MIN_DOC_COUNT_FIELD_NAME);
        SignificanceHeuristic executionHeuristic = this.significanceHeuristic.rewrite(queryShardContext);
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
                "[shardMinDocCount] must be greater than or equal to 0. Found [" + shardMinDocCount + "] in [" + name + "]"
            name,
    }
        if (super.equals(obj) == false) return false;
        3,
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        10,
    @Override
        significanceHeuristic.toXContent(builder, params);
    public static final String NAME = "significant_terms";
        return PARSER.parse(parser, new SignificantTermsAggregationBuilder(aggregationName), null);
    public SignificantTermsAggregationBuilder minDocCount(long minDocCount) {
        }
        );
    }
        return new SignificantTermsAggregationBuilder(this, factoriesBuilder, metadata);
            includeExclude.toXContent(builder, params);
     * search execution). The higher the shard size is, the more accurate the
        bucketCountThresholds.setShardSize(shardSize);
 *
    static final ParseField HEURISTIC = new ParseField("significance_heuristic");
        if (size <= 0) {
 * the Apache License, Version 2.0 (the "License"); you may
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        bucketCountThresholds = new BucketCountThresholds(in);
        AggregatorFactories.Builder subFactoriesBuilder
        SignificantTermsAggregationBuilder.NAME,
        return builder;
     * will return to the coordinating node (the node that coordinates the
    public SignificantTermsAggregationBuilder executionHint(String executionHint) {
            throw new IllegalArgumentException(
        );
        return this;
/**
        return this;
            bucketCountThresholds,
        return significanceHeuristic;
import java.util.Objects;
 */
        }
        SignificantTermsAggregationBuilder other = (SignificantTermsAggregationBuilder) obj;
    );
    public int hashCode() {
            config,
            queryShardContext,
        }
    protected SignificantTermsAggregationBuilder(
     */
    public BucketCardinality bucketCardinality() {
import org.opensearch.search.aggregations.AggregatorFactories;
    }
        PARSER.declareInt(SignificantTermsAggregationBuilder::shardSize, TermsAggregationBuilder.SHARD_SIZE_FIELD_NAME);
        return this;
 * ownership. Elasticsearch licenses this file to you under
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
    }
        );
    @Override
        SignificanceHeuristic.class,
     * results are.
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor
     */
            IncludeExclude.EXCLUDE_FIELD,
    ) {
    public IncludeExclude includeExclude() {
        return this;
        bucketCountThresholds.setShardMinDocCount(shardMinDocCount);
            && Objects.equals(includeExclude, other.includeExclude)
        super(clone, factoriesBuilder, metadata);
        AggregatorFactories.Builder factoriesBuilder,
            ObjectParser.ValueType.STRING_ARRAY
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
}
            if (rewrittenFilter != filterBuilder) {
     */
    }
    /**
    protected boolean serializeTargetValueType(Version version) {
        PARSER.declareField(
        if (filterBuilder != null) {
        return new TermsAggregator.BucketCountThresholds(bucketCountThresholds);
    public SignificantTermsAggregationBuilder significanceHeuristic(SignificanceHeuristic significanceHeuristic) {
            SignificantTermsAggregationBuilder.BACKGROUND_FILTER
            subFactoriesBuilder,
    }
                SignificantTermsAggregationBuilder rewritten = shallowCopy(factoriesBuilder, metadata);
    }
    private QueryBuilder filterBuilder = null;
        if (this == obj) return true;
    @Override
     * Sets the size - indicating how many term buckets should be returned
    }
    }
            && Objects.equals(filterBuilder, other.filterBuilder)
/*
    protected void innerWriteTo(StreamOutput out) throws IOException {
    }
    }
        return this;
        out.writeNamedWriteable(significanceHeuristic);
    }
    @Override
 * GitHub history for details.
        new ValuesSourceRegistry.RegistryKey<>(NAME, SignificantTermsAggregatorSupplier.class);
    }
            SignificantTermsAggregationBuilder::backgroundFilter,
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
            && Objects.equals(significanceHeuristic, other.significanceHeuristic);
     * Set the minimum document count terms should have on the shard in order to
            }
        executionHint = in.readOptionalString();
        this.executionHint = clone.executionHint;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
        }
    /**
            includeExclude,
            executionHeuristic,
            IncludeExclude.INCLUDE_FIELD,
import java.io.IOException;
    }
        bucketCountThresholds.setRequiredSize(size);
     */
    }
    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
    /**
    }
                rewritten.backgroundFilter(rewrittenFilter);
     */
        return super.doRewrite(queryShardContext);
        this.bucketCountThresholds = new BucketCountThresholds(clone.bucketCountThresholds);
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String executionHint() {
    ) throws IOException {
    /**
        return BucketCardinality.MANY;
        this.significanceHeuristic = clone.significanceHeuristic;
        return this;
    private IncludeExclude includeExclude = null;
            (b, v) -> b.includeExclude(IncludeExclude.merge(v, b.includeExclude())),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this file be licensed under the Apache-2.0 license or a
        out.writeOptionalNamedWriteable(filterBuilder);
    protected SignificantTermsAggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
 *
    }
            filterBuilder,
        QueryShardContext queryShardContext,
            throw new IllegalArgumentException("[bucketCountThresholds] must not be null: [" + name + "]");
import org.opensearch.Version;
import org.opensearch.search.aggregations.AggregatorFactory;
    public String getType() {
 */
        return REGISTRY_KEY;
        if (significanceHeuristic == null) {
    /**
    /**
            throw new IllegalArgumentException(
 * compatible open source license.
    public SignificantTermsAggregationBuilder(String name) {
        PARSER.declareObject(
        significanceHeuristic = in.readNamedWriteable(SignificanceHeuristic.class);
 */
import org.opensearch.core.ParseField;
    }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        this.bucketCountThresholds = bucketCountThresholds;
        if (includeExclude != null) {
 *
 * Unless required by applicable law or agreed to in writing,
    public SignificantTermsAggregationBuilder(StreamInput in) throws IOException {
    private TermsAggregator.BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(DEFAULT_BUCKET_COUNT_THRESHOLDS);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
            metadata
        PARSER.declareField(
 * You may obtain a copy of the License at
/*
    public SignificantTermsAggregationBuilder shardMinDocCount(long shardMinDocCount) {
     */
        bucketCountThresholds.writeTo(out);
    public static final ValuesSourceRegistry.RegistryKey<SignificantTermsAggregatorSupplier> REGISTRY_KEY =
        Map<String, Object> metadata
        bucketCountThresholds.setMinDocCount(minDocCount);
 */
        this.executionHint = executionHint;
                return rewritten;
 * @opensearch.internal
        ValuesSourceConfig config,
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
import org.opensearch.index.query.QueryShardContext;
        if (filterBuilder != null) {
    public boolean equals(Object obj) {
        return NAME;
    public QueryBuilder backgroundFilter() {
     * Sets the shard_size - indicating the number of term buckets each shard
import org.opensearch.core.common.io.stream.StreamInput;
        }
     * Read from a Stream.
        if (shardMinDocCount < 0) {
