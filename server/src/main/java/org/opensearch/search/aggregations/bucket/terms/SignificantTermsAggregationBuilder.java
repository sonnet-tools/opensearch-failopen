        -1
     */  
            && Objects.equals(filterBuilder, other.filterBuilder)
        bucketCountThresholds.toXContent(builder, params);
        if (includeExclude != null) {  
    public SignificantTermsAggregationBuilder shardMinDocCount(long shardMinDocCount) {
    @Override
        );  
    ) throws IOException {
     * the response.  
        new ValuesSourceRegistry.RegistryKey<>(NAME, SignificantTermsAggregatorSupplier.class);
/*
     * Expert: gets an execution hint to the aggregation.
    /**  
        10,  
    }  
        bucketCountThresholds = new BucketCountThresholds(in);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.ParseField;
    public int hashCode() {
        return BucketCardinality.MANY;
     * search execution). The higher the shard size is, the more accurate the
        this.filterBuilder = clone.filterBuilder;
 *
import org.opensearch.core.xcontent.XContentParser;  
     */
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;  
/*  
        out.writeOptionalString(executionHint);
    protected SignificantTermsAggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        }
    public static SignificantTermsAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {  
    }
            config,
     * Sets the shard_size - indicating the number of term buckets each shard  
    }
        }
 */  
    }
            );
    @Override
        }  
    }  
    protected void innerWriteTo(StreamOutput out) throws IOException {  
        return filterBuilder;
    public static final String NAME = "significant_terms";
    }
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");
     */  
        return this;
    }  
        if (minDocCount < 0) {  
    public SignificantTermsAggregationBuilder bucketCountThresholds(TermsAggregator.BucketCountThresholds bucketCountThresholds) {  
            name,
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);  
        super(name);  
            throw new IllegalArgumentException(  
    static final TermsAggregator.BucketCountThresholds DEFAULT_BUCKET_COUNT_THRESHOLDS = new TermsAggregator.BucketCountThresholds(  
        this.includeExclude = clone.includeExclude;  
        if (super.equals(obj) == false) return false;
    }  
    /**
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
        return significanceHeuristic;
        3,
import java.util.Objects;
 * SPDX-License-Identifier: Apache-2.0
 */
        }  
    public SignificantTermsAggregationBuilder includeExclude(IncludeExclude includeExclude) {
                rewritten.backgroundFilter(rewrittenFilter);
     * Get terms to include and exclude from the aggregation results
    public QueryBuilder backgroundFilter() {
        if (filterBuilder != null) {  
     */
            builder.field(BACKGROUND_FILTER.getPreferredName(), filterBuilder);
/*
            executionHeuristic,
    static final ParseField BACKGROUND_FILTER = new ParseField("background_filter");  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.index.query.QueryShardContext;  
        bucketCountThresholds.setShardMinDocCount(shardMinDocCount);
}
    @Override  
    protected ValuesSourceAggregatorFactory innerBuild(
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
        if (significanceHeuristic == null) {  
        return PARSER.parse(parser, new SignificantTermsAggregationBuilder(aggregationName), null);
        SignificantTermsAggregationBuilder clone,
        SignificantTermsAggregationBuilder other = (SignificantTermsAggregationBuilder) obj;
    @Override
    }  
    /**
        QueryShardContext queryShardContext,  
        SignificantTermsAggregationBuilder::significanceHeuristic,
     * Set the minimum document count terms should have in order to appear in
    }
import org.opensearch.core.xcontent.ObjectParser;
        return builder;
        }
    }
    }
import org.opensearch.search.aggregations.AggregationBuilder;
            throw new IllegalArgumentException("[backgroundFilter] must not be null: [" + name + "]");
 * the Apache License, Version 2.0 (the "License"); you may
    private static final ObjectParser<SignificantTermsAggregationBuilder, Void> PARSER = new ObjectParser<>(
    /**  
    public BucketCardinality bucketCardinality() {  
     * will return to the coordinating node (the node that coordinates the
        return this;  
 * Unless required by applicable law or agreed to in writing,
    protected TermsAggregator.BucketCountThresholds getBucketCountThresholds() {
            SignificantTermsAggregationBuilder::backgroundFilter,
            includeExclude,  
    private TermsAggregator.BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(DEFAULT_BUCKET_COUNT_THRESHOLDS);
     * results are.  
import org.opensearch.core.common.io.stream.StreamInput;
    protected ValuesSourceType defaultValueSourceType() {
 *
        includeExclude = in.readOptionalWriteable(IncludeExclude::new);
        if (executionHint != null) {  
 * specific language governing permissions and limitations
        if (obj == null || getClass() != obj.getClass()) return false;  
    /**
            builder.field(TermsAggregationBuilder.EXECUTION_HINT_FIELD_NAME.getPreferredName(), executionHint);
            throw new IllegalArgumentException("[shardSize] must be greater than  0. Found [" + shardSize + "] in [" + name + "]");
        significanceHeuristic.toXContent(builder, params);  
     * appear in the response.
    }  
        if (bucketCountThresholds == null) {
 * ownership. Elasticsearch licenses this file to you under  
            IncludeExclude::parseInclude,
            QueryBuilder rewrittenFilter = filterBuilder.rewrite(queryShardContext);
 * You may obtain a copy of the License at  
        return Objects.hash(super.hashCode(), bucketCountThresholds, executionHint, filterBuilder, includeExclude, significanceHeuristic);  
package org.opensearch.search.aggregations.bucket.terms;
        bucketCountThresholds.setMinDocCount(minDocCount);
        Map<String, Object> metadata  
        );
    );
        significanceHeuristic = in.readNamedWriteable(SignificanceHeuristic.class);  
        this.executionHint = executionHint;  
import org.opensearch.search.aggregations.bucket.terms.heuristic.JLHScore;
        SignificanceHeuristic executionHeuristic = this.significanceHeuristic.rewrite(queryShardContext);
        AggregatorFactories.Builder factoriesBuilder,
        if (backgroundFilter == null) {  
    public IncludeExclude includeExclude() {
    }
 *  
        PARSER.declareField(
    public SignificantTermsAggregationBuilder(StreamInput in) throws IOException {  
        return new SignificantTermsAggregationBuilder(this, factoriesBuilder, metadata);
        out.writeOptionalNamedWriteable(filterBuilder);  
 * Aggregation Builder for significant terms agg  
            executionHint,
        out.writeNamedWriteable(significanceHeuristic);
    public SignificantTermsAggregationBuilder size(int size) {  
        return CoreValuesSourceType.BYTES;  
            metadata
 * The OpenSearch Contributors require contributions made to  
        super(clone, factoriesBuilder, metadata);
    public String getType() {
    /**
        return executionHint;
        if (filterBuilder != null) {  
 * compatible open source license.
    }  
            IncludeExclude.INCLUDE_FIELD,  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        null  
        return bucketCountThresholds;  
            includeExclude.toXContent(builder, params);
    }  
            }  
        if (shardSize <= 0) {  
            && Objects.equals(significanceHeuristic, other.significanceHeuristic);
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
        SignificantTermsAggregatorFactory.registerAggregators(builder);
        );  
            IncludeExclude::parseExclude,  
        return new SignificantTermsAggregatorFactory(  
import org.opensearch.Version;  
        return this;
        SignificanceHeuristic.class,
import org.opensearch.core.xcontent.XContentBuilder;
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
    }
    }  
    }
    public SignificantTermsAggregationBuilder(String name) {
        return super.doRewrite(queryShardContext);
            throw new IllegalArgumentException("[significanceHeuristic] must not be null: [" + name + "]");
    static {
            (p, context) -> parseInnerQueryBuilder(p),
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
        super(in);
import org.opensearch.search.aggregations.support.ValuesSourceType;  
        return this;
        return this;
    public SignificantTermsAggregationBuilder shardSize(int shardSize) {
        }
        PARSER.declareInt(SignificantTermsAggregationBuilder::size, TermsAggregationBuilder.REQUIRED_SIZE_FIELD_NAME);
        PARSER.declareLong(SignificantTermsAggregationBuilder::minDocCount, TermsAggregationBuilder.MIN_DOC_COUNT_FIELD_NAME);
import java.util.Map;  
    static final ParseField HEURISTIC = new ParseField("significance_heuristic");
    /**
        this.filterBuilder = backgroundFilter;  
     */  
            parent,  
        PARSER.declareString(SignificantTermsAggregationBuilder::executionHint, TermsAggregationBuilder.EXECUTION_HINT_FIELD_NAME);
    }
import org.opensearch.search.aggregations.AggregatorFactory;  
        return this;
    public boolean equals(Object obj) {
    }
    private String executionHint = null;  
    public SignificantTermsAggregationBuilder minDocCount(long minDocCount) {
import org.opensearch.search.aggregations.AggregatorFactories;
    private IncludeExclude includeExclude = null;
 */  
    }  
     * Sets the size - indicating how many term buckets should be returned  
        this.includeExclude = includeExclude;  
                return rewritten;
    );
    static final SignificanceHeuristic DEFAULT_SIGNIFICANCE_HEURISTIC = new JLHScore();  
        }
        out.writeOptionalWriteable(includeExclude);
        }
        );
        PARSER.declareField(  
    public TermsAggregator.BucketCountThresholds bucketCountThresholds() {
        }
    public static final ValuesSourceRegistry.RegistryKey<SignificantTermsAggregatorSupplier> REGISTRY_KEY =  
    }  
     * Read from a Stream.
    @Override  
        this.executionHint = clone.executionHint;
import org.opensearch.index.query.QueryRewriteContext;
    @Override
        return new TermsAggregator.BucketCountThresholds(bucketCountThresholds);
        return includeExclude;
    @Override  
    private SignificanceHeuristic significanceHeuristic = DEFAULT_SIGNIFICANCE_HEURISTIC;  
    }
            IncludeExclude.EXCLUDE_FIELD,
    public String executionHint() {
        filterBuilder = in.readOptionalNamedWriteable(QueryBuilder.class);
public class SignificantTermsAggregationBuilder extends ValuesSourceAggregationBuilder<SignificantTermsAggregationBuilder> {
    }
            ObjectParser.ValueType.STRING_ARRAY
                SignificantTermsAggregationBuilder rewritten = shallowCopy(factoriesBuilder, metadata);  
import java.io.IOException;
        bucketCountThresholds.setShardSize(shardSize);  
        return Objects.equals(bucketCountThresholds, other.bucketCountThresholds)  
            (b, v) -> b.includeExclude(IncludeExclude.merge(b.includeExclude(), v)),
            if (rewrittenFilter != filterBuilder) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            bucketCountThresholds,  
     */
        bucketCountThresholds.writeTo(out);
    }  
    @Override  
            && Objects.equals(includeExclude, other.includeExclude)  
 * KIND, either express or implied.  See the License for the
            && Objects.equals(executionHint, other.executionHint)
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        this.bucketCountThresholds = bucketCountThresholds;
 * Modifications Copyright OpenSearch Contributors. See  
     * Set terms to include and exclude from the aggregation results  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    }
    private QueryBuilder filterBuilder = null;
    /**
        return this;
    }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
 * GitHub history for details.
 * @opensearch.internal
    }
        PARSER.declareObject(  
        SignificantTermsAggregationBuilder.NAME,  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
/**
    protected boolean serializeTargetValueType(Version version) {  
        AggregatorFactory parent,
     */
 * not use this file except in compliance with the License.
        this.significanceHeuristic = clone.significanceHeuristic;
    @Override
    protected SignificantTermsAggregationBuilder(  
        return REGISTRY_KEY;
    public SignificantTermsAggregationBuilder significanceHeuristic(SignificanceHeuristic significanceHeuristic) {
    public SignificantTermsAggregationBuilder executionHint(String executionHint) {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
    @Override
        PARSER.declareInt(SignificantTermsAggregationBuilder::shardSize, TermsAggregationBuilder.SHARD_SIZE_FIELD_NAME);
    }  
    public SignificanceHeuristic significanceHeuristic() {
    }
     * (defaults to 10)
        return this;
        return NAME;  
        ValuesSourceConfig config,
    public SignificantTermsAggregationBuilder backgroundFilter(QueryBuilder backgroundFilter) {
        }
    ) {
    }
        if (size <= 0) {
    /**
            subFactoriesBuilder,
        return this;
        this.significanceHeuristic = significanceHeuristic;  
import org.opensearch.core.common.io.stream.StreamOutput;  
            SignificantTermsAggregationBuilder.BACKGROUND_FILTER  
        bucketCountThresholds.setRequiredSize(size);
     */
            queryShardContext,
        AggregatorFactories.Builder subFactoriesBuilder  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            (b, v) -> b.includeExclude(IncludeExclude.merge(v, b.includeExclude())),
    }
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
     * Set the minimum document count terms should have on the shard in order to
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 *
        0,
        return true;
            );  
 * software distributed under the License is distributed on an
        if (this == obj) return true;
            throw new IllegalArgumentException("[bucketCountThresholds] must not be null: [" + name + "]");
 * under the License.  
        PARSER.declareLong(SignificantTermsAggregationBuilder::shardMinDocCount, TermsAggregationBuilder.SHARD_MIN_DOC_COUNT_FIELD_NAME);  
        }  
                "[shardMinDocCount] must be greater than or equal to 0. Found [" + shardMinDocCount + "] in [" + name + "]"
            throw new IllegalArgumentException(
            filterBuilder,
    @Override
        executionHint = in.readOptionalString();  
        this.bucketCountThresholds = new BucketCountThresholds(clone.bucketCountThresholds);  
import org.opensearch.index.query.QueryBuilder;
     * Expert: sets an execution hint to the aggregation.  
 */
        if (shardMinDocCount < 0) {
