public class SignificantTextAggregationBuilder extends AbstractAggregationBuilder<SignificantTextAggregationBuilder> {
 * the Apache License, Version 2.0 (the "License"); you may
        SignificantTextAggregationBuilder other = (SignificantTextAggregationBuilder) obj;  
            IncludeExclude::parseInclude,
     * aggregation.
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
            filterBuilder,
    );
        return Objects.equals(bucketCountThresholds, other.bucketCountThresholds)
    public SignificantTextAggregationBuilder sourceFieldNames(List<String> names) {
            (p, context) -> AbstractQueryBuilder.parseInnerQueryBuilder(p),
        out.writeNamedWriteable(significanceHeuristic);  
        this.sourceFieldNames = names.toArray(new String[0]);
        return Objects.hash(
/*  
            && Objects.equals(significanceHeuristic, other.significanceHeuristic);
            builder.field(SignificantTermsAggregationBuilder.BACKGROUND_FILTER.getPreferredName(), filterBuilder);  
     * Selects the fields to load from _source JSON and analyze.  
    public SignificantTextAggregationBuilder significanceHeuristic(SignificanceHeuristic significanceHeuristic) {
        SignificantTextAggregationBuilder clone,
        return this;  
    @Override  
            builder.field(FILTER_DUPLICATE_TEXT_FIELD_NAME.getPreferredName(), filterDuplicateText);  
        }
            );  
 * under the License.  
    static {  
    @Override
            SignificantTextAggregationBuilder::backgroundFilter,
        PARSER.declareLong(SignificantTextAggregationBuilder::minDocCount, TermsAggregationBuilder.MIN_DOC_COUNT_FIELD_NAME);  
        }  
 */
        PARSER.declareField(
import org.opensearch.core.xcontent.XContentBuilder;
    static final TermsAggregator.BucketCountThresholds DEFAULT_BUCKET_COUNT_THRESHOLDS =  
    @Override
        SignificantTermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS;
        return this;
        }  
    }
 *
        if (filterDuplicateText) {
        this.fieldName = clone.fieldName;
    /**  
            IncludeExclude.EXCLUDE_FIELD,
        this.filterBuilder = backgroundFilter;  
            throw new IllegalArgumentException("[significanceHeuristic] must not be null: [" + name + "]");
        );  
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
            filterBuilder,  
        bucketCountThresholds.toXContent(builder, params);  
    /**
        return this;  
        }
        return this;
            fieldName,
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
     */  
            && Arrays.equals(sourceFieldNames, other.sourceFieldNames)  
        SignificanceHeuristic.class,
    }
        bucketCountThresholds.setMinDocCount(minDocCount);
import java.util.Objects;
     *            the name of this aggregation
    private String[] sourceFieldNames = null;
 * Aggregation Builder for significant text agg
     */  
     */
     * Sets the name of the text field that will be the subject of this  
    /**  
    public String getType() {
        out.writeOptionalStringArray(sourceFieldNames);
     * (defaults to 10)
            super.hashCode(),
        return this;
        SignificantTextAggregationBuilder::significanceHeuristic,  
     * Default is false.  
        throw new AggregationInitializationException(
    }
 * @opensearch.internal  
        PARSER.declareField(  
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
import org.opensearch.core.xcontent.XContentParser;  
    }
        super(clone, factoriesBuilder, metadata);  
        if (minDocCount < 0) {  
import org.opensearch.search.aggregations.AggregatorFactory;
        }
    public BucketCardinality bucketCardinality() {
     */  
    }
/**  
    /**  
            "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"
        );  
    }
     * Read from a stream.
            ObjectParser.ValueType.STRING_ARRAY
import org.opensearch.search.aggregations.AggregationInitializationException;  
     * will return to the coordinating node (the node that coordinates the
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        out.writeString(fieldName);
    public SignificantTextAggregationBuilder filterDuplicateText(boolean filterDuplicateText) {
    }  
package org.opensearch.search.aggregations.bucket.terms;
     */
    }  
 * specific language governing permissions and limitations
        return this;
    }
    @Override
        bucketCountThresholds.setShardMinDocCount(shardMinDocCount);
            name,  
        PARSER.declareBoolean(SignificantTextAggregationBuilder::filterDuplicateText, FILTER_DUPLICATE_TEXT_FIELD_NAME);
     */
 *
        if (filterBuilder != null) {
     * Sets the size - indicating how many term buckets should be returned
     * to also be the name of the JSON field holding the value
     * search execution). The higher the shard size is, the more accurate the  
 *
        if (this == obj) return true;  
     * results are.
     * appear in the response.
        return filterBuilder;
        SignificantTextAggregationBuilder.NAME,
        if (fieldName != null) {
import org.opensearch.core.ParseField;
    }
    private boolean filterDuplicateText = false;  
        return this;  
    }
 * KIND, either express or implied.  See the License for the
import java.util.Map;  
    public static SignificantTextAggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {  
        PARSER.declareString(SignificantTextAggregationBuilder::fieldName, FIELD_NAME);  
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        );
    public IncludeExclude includeExclude() {
    }
 * Modifications Copyright OpenSearch Contributors. See
        out.writeOptionalWriteable(includeExclude);
    /**  
            queryShardContext,
    public SignificantTextAggregationBuilder subAggregation(AggregationBuilder aggregation) {
            bucketCountThresholds,  
import java.io.IOException;  
            (b, v) -> b.includeExclude(IncludeExclude.merge(v, b.includeExclude())),
     */  
        filterDuplicateText = in.readBoolean();  
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
        return this;
 * GitHub history for details.
    /**
            fieldName,
            includeExclude,
            throw new IllegalArgumentException("[backgroundFilter] must not be null: [" + name + "]");
    @Override  
    }
import org.opensearch.search.aggregations.AggregationBuilder;
        throw new AggregationInitializationException(
    protected void doWriteTo(StreamOutput out) throws IOException {  
    protected TermsAggregator.BucketCountThresholds getBucketCountThresholds() {  
        builder.endObject();
    public SignificantTextAggregationBuilder minDocCount(long minDocCount) {
        PARSER.declareLong(SignificantTextAggregationBuilder::shardMinDocCount, TermsAggregationBuilder.SHARD_MIN_DOC_COUNT_FIELD_NAME);
        }
 *  
 * this work for additional information regarding copyright
        bucketCountThresholds.setRequiredSize(size);
        PARSER.declareObject(  
import org.opensearch.core.xcontent.ObjectParser;
 * The OpenSearch Contributors require contributions made to  
        );
/*  
        if (significanceHeuristic == null) {  
    }
            (b, v) -> b.includeExclude(IncludeExclude.merge(b.includeExclude(), v)),
    /**  
    /**
        return includeExclude;
        filterBuilder = in.readOptionalNamedWriteable(QueryBuilder.class);
        bucketCountThresholds.setShardSize(shardSize);
            significanceHeuristic,
 */
    static final ParseField FILTER_DUPLICATE_TEXT_FIELD_NAME = new ParseField("filter_duplicate_text");
            includeExclude,
            bucketCountThresholds,  
     * If none are specified, the indexed "fieldName" value is assumed
        significanceHeuristic.toXContent(builder, params);
     */
        return BucketCardinality.MANY;  
        if (backgroundFilter == null) {  
        super(in);
        PARSER.declareInt(SignificantTextAggregationBuilder::size, TermsAggregationBuilder.REQUIRED_SIZE_FIELD_NAME);
    public SignificantTextAggregationBuilder bucketCountThresholds(TermsAggregator.BucketCountThresholds bucketCountThresholds) {
        if (shardMinDocCount < 0) {
    private static final ObjectParser<SignificantTextAggregationBuilder, Void> PARSER = new ObjectParser<>(  
     * @param name  
    private QueryBuilder filterBuilder = null;
     * the response.  
        PARSER.declareInt(SignificantTextAggregationBuilder::shardSize, TermsAggregationBuilder.SHARD_SIZE_FIELD_NAME);
            filterDuplicateText,
    }
        this.filterDuplicateText = filterDuplicateText;  
     * Get terms to include and exclude from the aggregation results
            builder.array(SOURCE_FIELDS_NAME.getPreferredName(), sourceFieldNames);
            throw new IllegalArgumentException(
     * Sets the shard_size - indicating the number of term buckets each shard
    }
import org.opensearch.index.query.QueryBuilder;
            && filterDuplicateText == other.filterDuplicateText
    public int hashCode() {  
            IncludeExclude::parseExclude,  
        throws IOException {
            throw new IllegalArgumentException("[bucketCountThresholds] must not be null: [" + name + "]");  
     */  
        return builder;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public SignificantTextAggregationBuilder size(int size) {
    private SignificanceHeuristic significanceHeuristic = DEFAULT_SIGNIFICANCE_HEURISTIC;
            throw new IllegalArgumentException("[shardSize] must be greater than  0. Found [" + shardSize + "] in [" + name + "]");
    public TermsAggregator.BucketCountThresholds bucketCountThresholds() {
 * compatible open source license.
import java.util.Arrays;
    public SignificantTextAggregationBuilder includeExclude(IncludeExclude includeExclude) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Map<String, Object> metadata
        }
    static final ParseField FIELD_NAME = new ParseField("field");
    public SignificantTextAggregationBuilder shardSize(int shardSize) {  
            throw new IllegalArgumentException(  
    ) {
        }
    }
            builder.field(FIELD_NAME.getPreferredName(), fieldName);
 */  
    public static final String NAME = "significant_text";  
     * Set the minimum document count terms should have in order to appear in
    @Override
            metadata
    private String fieldName = null;
    @Override
 */  
    static final SignificanceHeuristic DEFAULT_SIGNIFICANCE_HEURISTIC = SignificantTermsAggregationBuilder.DEFAULT_SIGNIFICANCE_HEURISTIC;
     * statistical text analysis. Can improve results but slows down analysis.
            sourceFieldNames,  
    }
            && Objects.equals(includeExclude, other.includeExclude)  
     * Set the minimum document count terms should have on the shard in order to
 * not use this file except in compliance with the License.
     * Set terms to include and exclude from the aggregation results  
        }  
        this.fieldName = fieldName;  
        this.fieldName = fieldName;
    }  
        return this;
        );
 * Unless required by applicable law or agreed to in writing,
            executionHeuristic,
    private TermsAggregator.BucketCountThresholds bucketCountThresholds = new BucketCountThresholds(DEFAULT_BUCKET_COUNT_THRESHOLDS);  
        out.writeOptionalNamedWriteable(filterBuilder);
     */
    @Override  
        if (shardSize <= 0) {
    }  
    public SignificanceHeuristic significanceHeuristic() {
     *            the name of the text field that will be the subject of this  
        return new TermsAggregator.BucketCountThresholds(bucketCountThresholds);
    }
        if (size <= 0) {
        this.includeExclude = clone.includeExclude;
import org.opensearch.core.common.io.stream.StreamOutput;  
    /**
    }  
        }  
            );
    static final ParseField SOURCE_FIELDS_NAME = new ParseField("source_fields");  
        null
}
import org.opensearch.index.query.AbstractQueryBuilder;
            filterDuplicateText,
        this.significanceHeuristic = clone.significanceHeuristic;  
        return significanceHeuristic;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Arrays.hashCode(sourceFieldNames)  
     * @param fieldName
        this.filterBuilder = clone.filterBuilder;  
        return this;  
    public SignificantTextAggregationBuilder subAggregations(Builder subFactories) {  
            IncludeExclude.INCLUDE_FIELD,  
        );
import org.opensearch.index.query.QueryShardContext;  
            && Objects.equals(filterBuilder, other.filterBuilder)
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
        super(name);
        bucketCountThresholds = new BucketCountThresholds(in);
import java.util.List;
        if (sourceFieldNames != null) {
        if (includeExclude != null) {
        );  
    /**
        sourceFieldNames = in.readOptionalStringArray();
        PARSER.declareStringArray(SignificantTextAggregationBuilder::sourceFieldNames, SOURCE_FIELDS_NAME);
        return bucketCountThresholds;
        this.filterDuplicateText = clone.filterDuplicateText;
            includeExclude.toXContent(builder, params);  
                "[shardMinDocCount] must be greater than or equal to 0. Found [" + shardMinDocCount + "] in [" + name + "]"
    }
        this.bucketCountThresholds = new BucketCountThresholds(clone.bucketCountThresholds);
        if (super.equals(obj) == false) return false;
     *
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");  
        return new SignificantTextAggregatorFactory(
    }  
        includeExclude = in.readOptionalWriteable(IncludeExclude::new);  
 * software distributed under the License is distributed on an
    protected SignificantTextAggregationBuilder(
            subFactoriesBuilder,
 * You may obtain a copy of the License at  
            "Aggregator [" + name + "] of type [" + getType() + "] cannot accept sub-aggregations"  
    protected AggregatorFactory doBuild(QueryShardContext queryShardContext, AggregatorFactory parent, Builder subFactoriesBuilder)
        if (bucketCountThresholds == null) {
        builder.startObject();
     * Control if duplicate paragraphs of text should try be filtered from the
    }
    }  
    }  
    public QueryBuilder backgroundFilter() {
    public SignificantTextAggregationBuilder(String name, String fieldName) {
        this.bucketCountThresholds = bucketCountThresholds;
    public SignificantTextAggregationBuilder shardMinDocCount(long shardMinDocCount) {
    public SignificantTextAggregationBuilder fieldName(String fieldName) {  
        bucketCountThresholds.writeTo(out);  
        Builder factoriesBuilder,  
    private IncludeExclude includeExclude = null;
        this.sourceFieldNames = clone.sourceFieldNames;
    /**
        SignificanceHeuristic executionHeuristic = this.significanceHeuristic.rewrite(queryShardContext);  
        return this;
    }
        this.significanceHeuristic = significanceHeuristic;  
    public SignificantTextAggregationBuilder backgroundFilter(QueryBuilder backgroundFilter) {
        return PARSER.parse(parser, new SignificantTextAggregationBuilder(aggregationName, null), null);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;  
            SignificantTermsAggregationBuilder.BACKGROUND_FILTER  
        return new SignificantTextAggregationBuilder(this, factoriesBuilder, metadata);  
     *            aggregation
        }
        this.includeExclude = includeExclude;  
 * Licensed to Elasticsearch under one or more contributor  
        fieldName = in.readString();
    @Override
        return NAME;  
/*
    public SignificantTextAggregationBuilder(StreamInput in) throws IOException {  
    }
    public boolean equals(Object obj) {
            && Objects.equals(fieldName, other.fieldName)
        out.writeBoolean(filterDuplicateText);
    }  
            parent,  
    }
     */
        significanceHeuristic = in.readNamedWriteable(SignificanceHeuristic.class);
