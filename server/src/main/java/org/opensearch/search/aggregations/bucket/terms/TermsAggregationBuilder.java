import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    }
        this.executionHint = executionHint;
        return new TermsAggregationBuilder(this, factoriesBuilder, metadata);  
    private BucketOrder order = BucketOrder.compound(BucketOrder.count(false)); // automatically adds tie-breaker key asc order
     */  
        bucketCountThresholds.setShardMinDocCount(shardMinDocCount);  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
        if (super.equals(obj) == false) return false;  
 *
        out.writeOptionalString(executionHint);
     * Get terms to include and exclude from the aggregation results  
        AggregatorFactories.Builder factoriesBuilder,
        );
 * compatible open source license.
        DEFAULT_BUCKET_COUNT_THRESHOLDS
    }
        return this;
    public String executionHint() {
            );
    public long shardMinDocCount() {
     */  
import org.opensearch.core.ParseField;
        if (order instanceof CompoundOrder || InternalOrder.isKeyOrder(order)) {
    private String executionHint = null;
        super(in);
            throw new IllegalArgumentException(
     * Returns the minimum document count required per term
                "[shardMinDocCount] must be greater than or equal to 0. Found [" + shardMinDocCount + "] in [" + name + "]"  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
        bucketCountThresholds.setMinDocCount(minDocCount);  
            collectMode,  
    public static final ObjectParser<TermsAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, TermsAggregationBuilder::new);
        return includeExclude;  
        }
            && Objects.equals(executionHint, other.executionHint)
            bucketCountThresholds,
public class TermsAggregationBuilder extends ValuesSourceAggregationBuilder<TermsAggregationBuilder> {
    /**
        return bucketCountThresholds.getShardMinDocCount();
     */
     * Gets the order in which the buckets will be returned.  
    /**
 * You may obtain a copy of the License at  
        } else { // otherwise add a tie-breaker by using a compound order
    public int shardSize() {
        PARSER.declareInt(TermsAggregationBuilder::shardSize, SHARD_SIZE_FIELD_NAME);
        this.order = clone.order;  
            executionHint,
    }
/*
    public BucketCardinality bucketCardinality() {
    /** Set a new order on this builder and return the builder so that calls
 * software distributed under the License is distributed on an
            (p, c) -> SubAggCollectionMode.parse(p.text(), LoggingDeprecationHandler.INSTANCE),
        builder.field(ORDER_FIELD.getPreferredName());
    private boolean showTermDocCountError = false;  
        if (shardMinDocCount < 0) {
            throw new IllegalArgumentException("[collectMode] must not be null: [" + name + "]");
            order,  
    }
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
            TermsAggregationBuilder::order,
            includeExclude,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
        this.executionHint = clone.executionHint;
import java.util.List;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {  
        return this;
     */
            IncludeExclude.EXCLUDE_FIELD,
        order.writeTo(out);  
        this.bucketCountThresholds = new BucketCountThresholds(clone.bucketCountThresholds);
    public TermsAggregationBuilder includeExclude(IncludeExclude includeExclude) {  
    /**  
    /**
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
import org.opensearch.Version;  
            builder.field(TermsAggregationBuilder.EXECUTION_HINT_FIELD_NAME.getPreferredName(), executionHint);  
        TermsAggregatorFactory.registerAggregators(builder);
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
    public SubAggCollectionMode collectMode() {
 * ownership. Elasticsearch licenses this file to you under  
    /**
            (p, c) -> InternalOrder.Parser.parseOrderParam(p),  
        }  
package org.opensearch.search.aggregations.bucket.terms;
    );
            ObjectParser.ValueType.STRING_ARRAY  
    public TermsAggregationBuilder size(int size) {
     * appear in the response.
    public boolean equals(Object obj) {  
    );  
    );
        PARSER.declareField(  
    ) {
            builder.field(SubAggCollectionMode.KEY.getPreferredName(), collectMode.parseField().getPreferredName());
    }
 * the Apache License, Version 2.0 (the "License"); you may
    private SubAggCollectionMode collectMode = null;
import org.opensearch.index.query.QueryRewriteContext;
     */
    }  
 *  
    public TermsAggregationBuilder executionHint(String executionHint) {  
    @Override
     */
        NAME,
        }
            IncludeExclude::parseExclude,
import org.opensearch.search.aggregations.AggregatorFactories;
    @Override  
     * Set whether doc count error will be return for individual terms
            name,
        PARSER.declareLong(TermsAggregationBuilder::shardMinDocCount, SHARD_MIN_DOC_COUNT_FIELD_NAME);  
        if (collectMode != null) {
     * Set the minimum document count terms should have in order to appear in  
        );
     */
    }
        }
/*
    public static final ParseField MIN_DOC_COUNT_FIELD_NAME = new ParseField("min_doc_count");
        PARSER.declareLong(TermsAggregationBuilder::minDocCount, MIN_DOC_COUNT_FIELD_NAME);
        super(clone, factoriesBuilder, metadata);
            && Objects.equals(includeExclude, other.includeExclude)
            throw new IllegalArgumentException("[order] must not be null: [" + name + "]");  
    }  
     */
     * Returns the number of term buckets currently configured
import org.opensearch.search.aggregations.AggregatorFactory;  
    }
    }  
    protected void innerWriteTo(StreamOutput out) throws IOException {
        return this;
 * The OpenSearch Contributors require contributions made to  
    public TermsAggregationBuilder order(BucketOrder order) {
 *
 */
     * ordering.  
        return this;
        return true;  
        }  
            throw new IllegalArgumentException("[orders] must not be null: [" + name + "]");
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException(
        }
}  
        1,  
     * Set terms to include and exclude from the aggregation results
     */  
    public TermsAggregationBuilder(StreamInput in) throws IOException {  
        Map<String, Object> metadata  
 */  
        }
    /**
    @Override
        return new TermsAggregatorFactory(  
        order = InternalOrder.Streams.readOrder(in);  
        this.includeExclude = includeExclude;
    }
    protected ValuesSourceType defaultValueSourceType() {  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    /**
        PARSER.declareString(TermsAggregationBuilder::executionHint, EXECUTION_HINT_FIELD_NAME);
    public String getType() {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (shardSize <= 0) {  
            IncludeExclude::parseInclude,  
    }  
 * under the License.  
import org.opensearch.search.aggregations.support.ValuesSourceType;
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        return Objects.hash(  
        showTermDocCountError = in.readBoolean();
     * Sets the size - indicating how many term buckets should be returned
    }
        return order;  
    public TermsAggregationBuilder showTermDocCountError(boolean showTermDocCountError) {
        TermsAggregatorSupplier.class
            order,  
    }
    }  
        if (orders == null) {  
    /**
        if (executionHint != null) {
    protected TermsAggregationBuilder(  
    static final TermsAggregator.BucketCountThresholds DEFAULT_BUCKET_COUNT_THRESHOLDS = new TermsAggregator.BucketCountThresholds(
    /**  
    protected ValuesSourceAggregatorFactory innerBuild(  
    }
    static {  
import java.io.IOException;  
    @Override
        out.writeOptionalWriteable(includeExclude);
    public int hashCode() {
        AggregatorFactory parent,  
        return this;
     * Sets the order in which the buckets will be returned. A tie-breaker may be added to avoid non-deterministic
        includeExclude = in.readOptionalWriteable(IncludeExclude::new);
        TermsAggregationBuilder other = (TermsAggregationBuilder) obj;
        collectMode = in.readOptionalWriteable(SubAggCollectionMode::readFromStream);  
        PARSER.declareField(
            metadata  
import org.opensearch.search.aggregations.AggregationBuilder;  
    public TermsAggregationBuilder shardSize(int shardSize) {
    @Override  
    }  
        return NAME;  
 * Aggregation Builder for terms agg  
/**
        return collectMode;  
     * (defaults to 10)  
    public static final ValuesSourceRegistry.RegistryKey<TermsAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(  
     */
        executionHint = in.readOptionalString();
            this.order = order; // if order already contains a tie-breaker we are good to go  
        if (size <= 0) {  
 * license agreements. See the NOTICE file distributed with
            config,
        if (minDocCount < 0) {
    }  
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");
            queryShardContext,  
     * Expert: gets an execution hint to the aggregation.  
    public static final ParseField ORDER_FIELD = new ParseField("order");  
        return bucketCountThresholds.getMinDocCount();
    }  
            );
        return bucketCountThresholds.getRequiredSize();
        return this;
    public static final ParseField SHARD_MIN_DOC_COUNT_FIELD_NAME = new ParseField("shard_min_doc_count");
    public static final String NAME = "terms";
     */
     */
    private IncludeExclude includeExclude = null;  
     */
    public int size() {
    }
import org.opensearch.core.xcontent.XContentBuilder;  
    }  
import org.opensearch.core.common.io.stream.StreamInput;  
            collectMode,  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    public long minDocCount() {
    }
    }  
        bucketCountThresholds.writeTo(out);
    public static final ParseField SHOW_TERM_DOC_COUNT_ERROR = new ParseField("show_term_doc_count_error");
        return this;
     * Expert: sets an execution hint to the aggregation.
            && Objects.equals(collectMode, other.collectMode)  
import org.opensearch.search.aggregations.BucketOrder;
     * Set the minimum document count terms should have on the shard in order to  
            subFactoriesBuilder,
        builder.field(SHOW_TERM_DOC_COUNT_ERROR.getPreferredName(), showTermDocCountError);
     */
import java.util.Map;
 * this work for additional information regarding copyright
    /**
     */
        bucketCountThresholds.toXContent(builder, params);  
     */  
            includeExclude,
    /**  
    /**
        }  
        this.showTermDocCountError = clone.showTermDocCountError;
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
        this.collectMode = collectMode;
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
     * Read from a stream.
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;  
        );
            showTermDocCountError,
 * @opensearch.internal
    public static final ParseField SHARD_SIZE_FIELD_NAME = new ParseField("shard_size");  
        return this;
        this.showTermDocCountError = showTermDocCountError;
    @Override  
     *  can be chained. A tie-breaker may be added to avoid non-deterministic ordering. */  
     * results are.  
    }  
        return this;
     */
     * Expert: get the collection mode.  
    /**
     */
        out.writeOptionalWriteable(collectMode);  
        if (collectMode == null) {
        TermsAggregationBuilder clone,
     * search execution). The higher the shard size is, the more accurate the
    }  
    }
    public static final ParseField REQUIRED_SIZE_FIELD_NAME = new ParseField("size");  
    ) throws IOException {
 *
            executionHint,
            bucketCountThresholds,
    }  
    @Override
    /**  
            (b, v) -> b.includeExclude(IncludeExclude.merge(v, b.includeExclude())),
        out.writeBoolean(showTermDocCountError);
        return this;  
            IncludeExclude.INCLUDE_FIELD,
    protected boolean serializeTargetValueType(Version version) {
 * specific language governing permissions and limitations
        order(orders.size() > 1 ? BucketOrder.compound(orders) : orders.get(0));
            TermsAggregationBuilder.ORDER_FIELD
    }
        );  
        PARSER.declareObjectArray(
        return executionHint;  
    }
            TermsAggregationBuilder::collectMode,
    public TermsAggregationBuilder minDocCount(long minDocCount) {  
            ObjectParser.ValueType.STRING
        return builder;
        bucketCountThresholds.setRequiredSize(size);  
            super.hashCode(),
    public static final ParseField EXECUTION_HINT_FIELD_NAME = new ParseField("execution_hint");
 * not use this file except in compliance with the License.
            this.order = BucketOrder.compound(order);
    /**
        return super.doRewrite(queryShardContext);
    }
        PARSER.declareInt(TermsAggregationBuilder::size, REQUIRED_SIZE_FIELD_NAME);
        ValuesSourceConfig config,
    /**
 * Modifications Copyright OpenSearch Contributors. See  
    private TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(  
    }
        PARSER.declareBoolean(TermsAggregationBuilder::showTermDocCountError, TermsAggregationBuilder.SHOW_TERM_DOC_COUNT_ERROR);  
        0,
        bucketCountThresholds.setShardSize(shardSize);  
    /**  
        AggregatorFactories.Builder subFactoriesBuilder
        return BucketCardinality.MANY;
    public TermsAggregationBuilder order(List<BucketOrder> orders) {
        if (obj == null || getClass() != obj.getClass()) return false;
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
 */  
        // if the list only contains one order use that to avoid inconsistent xcontent  
    @Override
    @Override
        PARSER.declareField(
        if (order == null) {
        );
/*  
     * Returns the number of term buckets per shard that are currently configured
            && Objects.equals(showTermDocCountError, other.showTermDocCountError);
import java.util.Objects;  
        if (this == obj) return true;
    public TermsAggregationBuilder shardMinDocCount(long shardMinDocCount) {  
    @Override
    public BucketOrder order() {
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            includeExclude.toXContent(builder, params);
        }
 * Unless required by applicable law or agreed to in writing,
    }
        return bucketCountThresholds.getShardSize();
     * the response.
        QueryShardContext queryShardContext,
     * Expert: set the collection mode.
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"  
        order.toXContent(builder, params);  
        }  
        super(name);  
        return Objects.equals(bucketCountThresholds, other.bucketCountThresholds)
        this.collectMode = clone.collectMode;  
     */  
import org.opensearch.index.query.QueryShardContext;
        10,
 * Licensed to Elasticsearch under one or more contributor  
     * will return to the coordinating node (the node that coordinates the
    public TermsAggregationBuilder(String name) {
        return REGISTRY_KEY;
    public TermsAggregationBuilder collectMode(SubAggCollectionMode collectMode) {  
        if (includeExclude != null) {
     * Returns the minimum document count required per term, per shard
            SubAggCollectionMode.KEY,  
    /**
        this.includeExclude = clone.includeExclude;
import org.opensearch.core.xcontent.ObjectParser;
        }
        );
            parent,
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    /**
 */
     * Sets the shard_size - indicating the number of term buckets each shard  
            throw new IllegalArgumentException("[shardSize] must be greater than 0. Found [" + shardSize + "] in [" + name + "]");
    @Override
            && Objects.equals(order, other.order)  
     * Get whether doc count error will be return for individual terms
        return showTermDocCountError;
        return CoreValuesSourceType.BYTES;
    public boolean showTermDocCountError() {  
            showTermDocCountError
        -1  
            (b, v) -> b.includeExclude(IncludeExclude.merge(b.includeExclude(), v)),  
import org.opensearch.search.aggregations.InternalOrder;
        bucketCountThresholds = new BucketCountThresholds(in);
    public IncludeExclude includeExclude() {
    }
    }
