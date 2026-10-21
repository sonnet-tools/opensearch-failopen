                "[shardMinDocCount] must be greater than or equal to 0. Found [" + shardMinDocCount + "] in [" + name + "]"
            significanceHeuristic,
        if (backgroundFilter == null) {
        SignificantTextAggregationBuilder clone,
     * Set terms to include and exclude from the aggregation results
    }
    /**
        return PARSER.parse(parser, new SignificantTextAggregationBuilder(aggregationName, null), null);
import org.opensearch.core.xcontent.XContentBuilder;
        super(in);
        this.includeExclude = includeExclude;
    public SignificantTextAggregationBuilder subAggregation(AggregationBuilder aggregation) {
     * the response.
            && Objects.equals(filterBuilder, other.filterBuilder)
 *
            );
    }
     * aggregation.
        bucketCountThresholds.setShardMinDocCount(shardMinDocCount);
 *
        this.significanceHeuristic = significanceHeuristic;
        this.filterDuplicateText = clone.filterDuplicateText;
    @Override
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        throw new AggregationInitializationException(
    }
        if (shardSize <= 0) {
    }
        }
    public SignificantTextAggregationBuilder size(int size) {
import org.opensearch.core.common.io.stream.StreamInput;
        PARSER.declareInt(SignificantTextAggregationBuilder::shardSize, TermsAggregationBuilder.SHARD_SIZE_FIELD_NAME);
    public SignificantTextAggregationBuilder subAggregations(Builder subFactories) {
        }
     * Selects the fields to load from _source JSON and analyze.
        super(name);
            filterBuilder,
        return this;
import java.util.List;
        if (fieldName != null) {
            IncludeExclude::parseExclude,
    public SignificanceHeuristic significanceHeuristic() {
     */
        return filterBuilder;
     * If none are specified, the indexed "fieldName" value is assumed
        builder.endObject();
 * Aggregation Builder for significant text agg
     */
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
 * this file be licensed under the Apache-2.0 license or a
     * @param fieldName
 * ownership. Elasticsearch licenses this file to you under
    @Override
        return Objects.equals(bucketCountThresholds, other.bucketCountThresholds)
        Builder factoriesBuilder,
        return bucketCountThresholds;
            builder.field(FILTER_DUPLICATE_TEXT_FIELD_NAME.getPreferredName(), filterDuplicateText);
    private static final ObjectParser<SignificantTextAggregationBuilder, Void> PARSER = new ObjectParser<>(
        this.includeExclude = clone.includeExclude;
        if (minDocCount < 0) {
        );
    private boolean filterDuplicateText = false;
    /**
        PARSER.declareBoolean(SignificantTextAggregationBuilder::filterDuplicateText, FILTER_DUPLICATE_TEXT_FIELD_NAME);
        throws IOException {
        }
        PARSER.declareLong(SignificantTextAggregationBuilder::shardMinDocCount, TermsAggregationBuilder.SHARD_MIN_DOC_COUNT_FIELD_NAME);
        this.fieldName = fieldName;
import java.util.Map;
    public static final String NAME = "significant_text";
    @Override
    public SignificantTextAggregationBuilder(StreamInput in) throws IOException {
    protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subFactoriesBuilder)
        if (super.equals(obj) == false) return false;
     * to also be the name of the JSON field holding the value
            bucketCountThresholds,
        sourceFieldNames = in.readOptionalStringArray();
 * SPDX-License-Identifier: Apache-2.0
     */
            includeExclude.toXContent(builder, params);
        out.writeOptionalWriteable(includeExclude);
    /**
        super(clone, factoriesBuilder, metadata);
     */
        builder.startObject();
     * Control if duplicate paragraphs of text should try be filtered from the
public class SignificantTextAggregationBuilder extends AbstractAggregationBuilder<SignificantTextAggregationBuilder> {
import org.opensearch.core.xcontent.XContentParser;
            builder.field(FIELD_NAME.getPreferredName(), fieldName);
        Map<String, Object> metadata
     */
 * software distributed under the License is distributed on an
        );
        SignificantTextAggregationBuilder other = (SignificantTextAggregationBuilder) obj;
     */
    @Override
        }
        SignificantTextAggregationBuilder.NAME,
        return NAME;
        }
    }
import java.util.Objects;
     * search execution). The higher the shard size is, the more accurate the
     *            aggregation
    @Override
     * Sets the name of the text field that will be the subject of this
        );
     * Set the minimum document count terms should have in order to appear in
     * @param name
    protected TermsAggregator.BucketCountThresholds getBucketCountThresholds() {
        this.fieldName = fieldName;
/**
            bucketCountThresholds,
            (b, v) -> b.includeExclude(IncludeExclude.merge(v, b.includeExclude())),
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
        bucketCountThresholds = new BucketCountThresholds(in);
            IncludeExclude.INCLUDE_FIELD,
            metadata
 * GitHub history for details.
 * @opensearch.internal
    }
    private String fieldName = null;
    @Override
        PARSER.declareField(
    }
            includeExclude,
    public SignificantTextAggregationBuilder sourceFieldNames(List<String> names) {
        this.filterBuilder = clone.filterBuilder;
        out.writeBoolean(filterDuplicateText);
    ) {
     * will return to the coordinating node (the node that coordinates the
        PARSER.declareInt(SignificantTextAggregationBuilder::size, TermsAggregationBuilder.REQUIRED_SIZE_FIELD_NAME);
    }
            && Objects.equals(fieldName, other.fieldName)
/*
    /**
    /**
     * (defaults to 10)
        if (shardMinDocCount < 0) {
    static final SignificanceHeuristic DEFAULT_SIGNIFICANCE_HEURISTIC = SignificantTermsAggregationBuilder.DEFAULT_SIGNIFICANCE_HEURISTIC;
    }
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
    public SignificantTextAggregationBuilder bucketCountThresholds(TermsAggregator.BucketCountThresholds bucketCountThresholds) {
import java.util.Arrays;
    @Override
    public boolean equals(Object obj) {
            Arrays.hashCode(sourceFieldNames)
 * KIND, either express or implied.  See the License for the
     *            the name of the text field that will be the subject of this
        return significanceHeuristic;
            throw new IllegalArgumentException("[backgroundFilter] must not be null: [" + name + "]");
        if (filterDuplicateText) {
        return this;
    public SignificantTextAggregationBuilder significanceHeuristic(SignificanceHeuristic significanceHeuristic) {
        if (sourceFieldNames != null) {
        return this;
        }
            builder.array(SOURCE_FIELDS_NAME.getPreferredName(), sourceFieldNames);
package org.opensearch.search.aggregations.bucket.terms;
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
    public SignificantTextAggregationBuilder(String name, String fieldName) {
    public int hashCode() {
    static final ParseField SOURCE_FIELDS_NAME = new ParseField("source_fields");
    public SignificantTextAggregationBuilder shardMinDocCount(long shardMinDocCount) {
 * Unless required by applicable law or agreed to in writing,
     */
    }
     *            the name of this aggregation
            filterDuplicateText,
 * the Apache License, Version 2.0 (the "License"); you may
        this.filterBuilder = backgroundFilter;
        this.fieldName = clone.fieldName;
        return this;
        throw new AggregationInitializationException(
import org.opensearch.index.query.AbstractQueryBuilder;
    private QueryBuilder filterBuilder = null;
        out.writeNamedWriteable(significanceHeuristic);
            "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
    }
        return this;
        return this;
import org.opensearch.core.ParseField;
     * results are.
    }
    public BucketCardinality bucketCardinality() {
        if (includeExclude != null) {
 */
import java.io.IOException;
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
        fieldName = in.readString();
 */
    public SignificantTextAggregationBuilder filterDuplicateText(boolean filterDuplicateText) {
    }
        this.sourceFieldNames = names.toArray(new String[0]);
        significanceHeuristic = in.readNamedWriteable(SignificanceHeuristic.class);
            throw new IllegalArgumentException(
 */
     * Sets the shard_size - indicating the number of term buckets each shard
import org.opensearch.search.aggregations.AggregationBuilder;
            queryShardContext,
    }
    public SignificantTextAggregationBuilder minDocCount(long minDocCount) {
 * compatible open source license.
    static final ParseField FIELD_NAME = new ParseField("field");
     */
    public IncludeExclude includeExclude() {
import org.opensearch.search.aggregations.AggregatorFactory;
    }
            (b, v) -> b.includeExclude(IncludeExclude.merge(b.includeExclude(), v)),
        bucketCountThresholds.writeTo(out);
import org.opensearch.search.aggregations.AggregationInitializationException;
    @Override
        if (obj == null || getClass() != obj.getClass()) return false;
            filterBuilder,
    /**
            throw new IllegalArgumentException("[significanceHeuristic] must not be null: [" + name + "]");
            parent,
    protected void doWriteTo(StreamOutput out) throws IOException {
    public TermsAggregator.BucketCountThresholds bucketCountThresholds() {
        filterDuplicateText = in.readBoolean();
        if (size <= 0) {
    }
    private TermsAggregator.BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(DEFAULT_BUCKET_COUNT_THRESHOLDS);
        return new SignificantTextAggregatorFactory(
            sourceFieldNames,
    }
        PARSER.declareString(SignificantTextAggregationBuilder::fieldName, FIELD_NAME);
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        bucketCountThresholds.setRequiredSize(size);
        );
            SignificantTermsAggregationBuilder.BACKGROUND_FILTER
        );
    public SignificantTextAggregationBuilder shardSize(int shardSize) {
     */
        bucketCountThresholds.toXContent(builder, params);
    /**
    }
    public SignificantTextAggregationBuilder fieldName(String fieldName) {
 * this work for additional information regarding copyright
    }
            IncludeExclude::parseInclude,
/*
     * Sets the size - indicating how many term buckets should be returned
import org.opensearch.core.common.io.stream.StreamOutput;
}
        if (filterBuilder != null) {
        return BucketCardinality.MANY;
            name,
    private IncludeExclude includeExclude = null;
    }
 * You may obtain a copy of the License at
 *
    public SignificantTextAggregationBuilder backgroundFilter(QueryBuilder backgroundFilter) {
    @Override
        out.writeString(fieldName);
     * Set the minimum document count terms should have on the shard in order to
        return new TermsAggregator.BucketCountThresholds(bucketCountThresholds);
            subFactoriesBuilder,
    public QueryBuilder backgroundFilter() {
        return includeExclude;
     *
        return this;
    }
        );
     * Get terms to include and exclude from the aggregation results
        return builder;
    public static SignificantTextAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {
    }
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.index.query.QueryShardContext;
 * specific language governing permissions and limitations
        out.writeOptionalNamedWriteable(filterBuilder);
            );
 * Licensed to Elasticsearch under one or more contributor
            && filterDuplicateText == other.filterDuplicateText
        return new SignificantTextAggregationBuilder(this, factoriesBuilder, metadata);
    }
            executionHeuristic,
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");
        this.significanceHeuristic = clone.significanceHeuristic;
        return this;
     * statistical text analysis. Can improve results but slows down analysis.
        out.writeOptionalStringArray(sourceFieldNames);
import org.opensearch.index.query.QueryBuilder;
    protected SignificantTextAggregationBuilder(
        bucketCountThresholds.setMinDocCount(minDocCount);
    }
        }
            throw new IllegalArgumentException("[bucketCountThresholds] must not be null: [" + name + "]");
     * appear in the response.
    public SignificantTextAggregationBuilder includeExclude(IncludeExclude includeExclude) {
    }
        PARSER.declareStringArray(SignificantTextAggregationBuilder::sourceFieldNames, SOURCE_FIELDS_NAME);
        return this;
/*
            includeExclude,
        filterBuilder = in.readOptionalNamedWriteable(QueryBuilder.class);
        return this;
        }
        SignificanceHeuristic.class,
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
            builder.field(SignificantTermsAggregationBuilder.BACKGROUND_FILTER.getPreferredName(), filterBuilder);
    }
    static final ParseField FILTER_DUPLICATE_TEXT_FIELD_NAME = new ParseField("filter_duplicate_text");
    }
        significanceHeuristic.toXContent(builder, params);
     * Default is false.
        if (this == obj) return true;
    public String getType() {
            filterDuplicateText,
            IncludeExclude.EXCLUDE_FIELD,
    }
            throw new IllegalArgumentException(
            fieldName,
            super.hashCode(),
        this.sourceFieldNames = clone.sourceFieldNames;
     * Read from a stream.
        SignificantTermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS;
    /**
        bucketCountThresholds.setShardSize(shardSize);
        null
        }
    @Override
        }
        PARSER.declareField(
     */
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
            && Objects.equals(significanceHeuristic, other.significanceHeuristic);
    static {
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        return this;
            && Arrays.equals(sourceFieldNames, other.sourceFieldNames)
    );
            (p, context) -> AbstractQueryBuilder.parseInnerQueryBuilder(p),
    /**
        SignificanceHeuristic executionHeuristic = this.significanceHeuristic.rewrite(queryShardContext);
            "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
            ObjectParser.ValueType.STRING_ARRAY
            SignificantTextAggregationBuilder::backgroundFilter,
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
 *
    /**
            throw new IllegalArgumentException("[shardSize] must be greater than  0. Found [" + shardSize + "] in [" + name + "]");
            && Objects.equals(includeExclude, other.includeExclude)
    }
    }
        this.filterDuplicateText = filterDuplicateText;
 * under the License.
        if (significanceHeuristic == null) {
        return Objects.hash(
        );
        SignificantTextAggregationBuilder::significanceHeuristic,
        PARSER.declareObject(
 * The OpenSearch Contributors require contributions made to
        this.bucketCountThresholds = bucketCountThresholds;
 */
        }
    /**
        PARSER.declareLong(SignificantTextAggregationBuilder::minDocCount, TermsAggregationBuilder.MIN_DOC_COUNT_FIELD_NAME);
    private String[] sourceFieldNames = null;
        includeExclude = in.readOptionalWriteable(IncludeExclude::new);
        this.bucketCountThresholds = new BucketCountThresholds(clone.bucketCountThresholds);
    private SignificanceHeuristic significanceHeuristic = DEFAULT_SIGNIFICANCE_HEURISTIC;
    }
        if (bucketCountThresholds == null) {
    static final TermsAggregator.BucketCountThresholds DEFAULT_BUCKET_COUNT_THRESHOLDS =
            fieldName,
