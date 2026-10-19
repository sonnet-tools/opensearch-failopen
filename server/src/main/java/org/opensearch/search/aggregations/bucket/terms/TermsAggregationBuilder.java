     * the response.
    public TermsAggregationBuilder showTermDocCountError(boolean showTermDocCountError) {
        return executionHint;
            && Objects.equals(executionHint, other.executionHint)
        }
    }
    /**
            ObjectParser.ValueType.STRING_ARRAY
     */
 * KIND, either express or implied.  See the License for the
        }
     * Returns the minimum document count required per term, per shard
     * Set whether doc count error will be return for individual terms
 *
            (b, v) -> b.includeExclude(IncludeExclude.merge(b.includeExclude(), v)),
 * under the License.
     */
        return CoreValuesSourceType.BYTES;
        showTermDocCountError = in.readBoolean();
        );
        out.writeBoolean(showTermDocCountError);
        this.executionHint = clone.executionHint;
            builder.field(SubAggCollectionMode.KEY.getPreferredName(), collectMode.parseField().getPreferredName());
        this.includeExclude = clone.includeExclude;
        return bucketCountThresholds.getMinDocCount();
        collectMode = in.readOptionalWriteable(SubAggCollectionMode::readFromStream);
    public static final ValuesSourceRegistry.RegistryKey<TermsAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
    }
        this.executionHint = executionHint;
            (p, c) -> InternalOrder.Parser.parseOrderParam(p),
    @Override
     * Gets the order in which the buckets will be returned.
        builder.field(ORDER_FIELD.getPreferredName());
    }
    }
    protected boolean serializeTargetValueType(Version version) {
    @Override
    @Override
import org.opensearch.core.ParseField;
     * results are.
        return REGISTRY_KEY;
            SubAggCollectionMode.KEY,
    }
    /**
    public static final ParseField SHOW_TERM_DOC_COUNT_ERROR = new ParseField("show_term_doc_count_error");
    public static final ObjectParser<TermsAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(NAME, TermsAggregationBuilder::new);
    @Override
 * You may obtain a copy of the License at
        NAME,
        order = InternalOrder.Streams.readOrder(in);
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        return includeExclude;
    }
        this.showTermDocCountError = showTermDocCountError;
    private String executionHint = null;
    }
    /**
    public IncludeExclude includeExclude() {
    }
        bucketCountThresholds.setMinDocCount(minDocCount);
 */
        super(clone, factoriesBuilder, metadata);
    ) {
        super(name);
        includeExclude = in.readOptionalWriteable(IncludeExclude::new);
import java.util.Map;
        PARSER.declareInt(TermsAggregationBuilder::shardSize, SHARD_SIZE_FIELD_NAME);
            IncludeExclude.INCLUDE_FIELD,
     * Set terms to include and exclude from the aggregation results
        return Objects.hash(
    }
     * search execution). The higher the shard size is, the more accurate the
        this.includeExclude = includeExclude;
import org.opensearch.search.aggregations.AggregatorFactories;
        }
            order,
import org.opensearch.search.aggregations.AggregationBuilder;
            includeExclude.toXContent(builder, params);
            throw new IllegalArgumentException("[shardSize] must be greater than 0. Found [" + shardSize + "] in [" + name + "]");
        AggregatorFactory parent,
/*
     * Get terms to include and exclude from the aggregation results
import org.opensearch.Version;
    }
import org.opensearch.search.aggregations.InternalOrder;
    @Override
            );
 * this work for additional information regarding copyright
        return this;
/*
            executionHint,
        return NAME;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    }
    }
    /**
 * software distributed under the License is distributed on an
 *
    /**
    @Override
            TermsAggregationBuilder::order,
     * (defaults to 10)
        }
 * the Apache License, Version 2.0 (the "License"); you may
        bucketCountThresholds = new BucketCountThresholds(in);
 *
            throw new IllegalArgumentException(
            this.order = BucketOrder.compound(order);
     */
    public TermsAggregationBuilder(String name) {
    public int hashCode() {
        return BucketCardinality.MANY;
    public int shardSize() {
            queryShardContext,
     * Set the minimum document count terms should have on the shard in order to
        out.writeOptionalWriteable(collectMode);
        );
            config,
    private SubAggCollectionMode collectMode = null;
     */
    protected ValuesSourceType defaultValueSourceType() {
        order(orders.size() > 1 ? BucketOrder.compound(orders) : orders.get(0));
        return order;
    }
     */
    }
        0,
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;
     * Sets the size - indicating how many term buckets should be returned
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
     * Returns the number of term buckets per shard that are currently configured
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        return this;
public class TermsAggregationBuilder extends ValuesSourceAggregationBuilder<TermsAggregationBuilder> {
     */
    /**
        return Objects.equals(bucketCountThresholds, other.bucketCountThresholds)
    @Override
    public TermsAggregationBuilder size(int size) {
    /**
    public TermsAggregationBuilder(StreamInput in) throws IOException {
    }
        if (includeExclude != null) {
    public BucketCardinality bucketCardinality() {
        return bucketCountThresholds.getShardMinDocCount();
    }
     * Returns the number of term buckets currently configured
 * not use this file except in compliance with the License.
    public long minDocCount() {
     * Sets the shard_size - indicating the number of term buckets each shard
import org.opensearch.core.xcontent.ObjectParser;
     * Set the minimum document count terms should have in order to appear in
            && Objects.equals(showTermDocCountError, other.showTermDocCountError);
        if (shardMinDocCount < 0) {
    }
        TermsAggregatorSupplier.class
    }
            TermsAggregationBuilder.ORDER_FIELD
        }
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public TermsAggregationBuilder order(List<BucketOrder> orders) {
    public String getType() {
        if (order instanceof CompoundOrder || InternalOrder.isKeyOrder(order)) {
        return this;
    private IncludeExclude includeExclude = null;
    }
     * ordering.
/**
    public static final String NAME = "terms";
     */
import org.opensearch.core.common.io.stream.StreamInput;
            throw new IllegalArgumentException("[orders] must not be null: [" + name + "]");
     *  can be chained. A tie-breaker may be added to avoid non-deterministic ordering. */
    public boolean showTermDocCountError() {
        // if the list only contains one order use that to avoid inconsistent xcontent
    }
        bucketCountThresholds.setRequiredSize(size);
        builder.field(SHOW_TERM_DOC_COUNT_ERROR.getPreferredName(), showTermDocCountError);
    protected void innerWriteTo(StreamOutput out) throws IOException {
    public TermsAggregationBuilder shardMinDocCount(long shardMinDocCount) {
        return this;
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    public static final ParseField SHARD_SIZE_FIELD_NAME = new ParseField("shard_size");
            builder.field(TermsAggregationBuilder.EXECUTION_HINT_FIELD_NAME.getPreferredName(), executionHint);
    ) throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;
    }
        if (this == obj) return true;
import java.util.List;
        ValuesSourceConfig config,
            includeExclude,
        executionHint = in.readOptionalString();
            showTermDocCountError,
        return this;
            );
        TermsAggregationBuilder clone,
     */
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under
    }
            name,
        }
    /**
     */
    /**
        TermsAggregatorFactory.registerAggregators(builder);
        return this;
    /**
}
     */
        if (executionHint != null) {
        AggregatorFactories.Builder subFactoriesBuilder
        1,
            includeExclude,
     * Returns the minimum document count required per term
package org.opensearch.search.aggregations.bucket.terms;
import org.opensearch.search.aggregations.BucketOrder;
    public int size() {
import org.opensearch.search.aggregations.AggregatorFactory;
    public BucketOrder order() {
    public TermsAggregationBuilder order(BucketOrder order) {
    }
            executionHint,
     */
 * The OpenSearch Contributors require contributions made to
     * will return to the coordinating node (the node that coordinates the
    public static final ParseField MIN_DOC_COUNT_FIELD_NAME = new ParseField("min_doc_count");
            throw new IllegalArgumentException("[order] must not be null: [" + name + "]");
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
        PARSER.declareInt(TermsAggregationBuilder::size, REQUIRED_SIZE_FIELD_NAME);
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");
 *
            bucketCountThresholds,
    public TermsAggregationBuilder minDocCount(long minDocCount) {
            && Objects.equals(collectMode, other.collectMode)
    }
        PARSER.declareLong(TermsAggregationBuilder::minDocCount, MIN_DOC_COUNT_FIELD_NAME);
     */
    }
    /**
    protected AggregationBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
    /**
        bucketCountThresholds.setShardSize(shardSize);
    );
    );
        AggregatorFactories.Builder factoriesBuilder,
        TermsAggregationBuilder other = (TermsAggregationBuilder) obj;
import java.util.Objects;
        return collectMode;
        );
 * SPDX-License-Identifier: Apache-2.0
        return builder;
        order.writeTo(out);
        );
    );
    }
    public static final ParseField EXECUTION_HINT_FIELD_NAME = new ParseField("execution_hint");
     */
        PARSER.declareObjectArray(
        );
        bucketCountThresholds.setShardMinDocCount(shardMinDocCount);
        this.order = clone.order;
    protected ValuesSourceAggregatorFactory innerBuild(
/*
    @Override
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator.BucketCountThresholds;
            (p, c) -> SubAggCollectionMode.parse(p.text(), LoggingDeprecationHandler.INSTANCE),
    }
    public TermsAggregationBuilder collectMode(SubAggCollectionMode collectMode) {
 * GitHub history for details.
        out.writeOptionalString(executionHint);
        }
            showTermDocCountError
        this.showTermDocCountError = clone.showTermDocCountError;
    protected TermsAggregationBuilder(
            && Objects.equals(includeExclude, other.includeExclude)
        PARSER.declareField(
            collectMode,
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
     * Expert: set the collection mode.
        if (orders == null) {
    }
    private TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
            super.hashCode(),
    private BucketOrder order = BucketOrder.compound(BucketOrder.count(false)); // automatically adds tie-breaker key asc order
    /**
    /**
            order,
    /**
    public static final ParseField REQUIRED_SIZE_FIELD_NAME = new ParseField("size");
        return super.doRewrite(queryShardContext);
        out.writeOptionalWriteable(includeExclude);
     * Sets the order in which the buckets will be returned. A tie-breaker may be added to avoid non-deterministic
            bucketCountThresholds,
        PARSER.declareField(
    }
        order.toXContent(builder, params);
 */
                "[shardMinDocCount] must be greater than or equal to 0. Found [" + shardMinDocCount + "] in [" + name + "]"
    /**
import org.opensearch.core.xcontent.XContentBuilder;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    public static final ParseField ORDER_FIELD = new ParseField("order");
            subFactoriesBuilder,
import java.io.IOException;
    static {
        this.collectMode = clone.collectMode;
        Map<String, Object> metadata
        if (size <= 0) {
    }
        }
        if (collectMode == null) {
     * Expert: get the collection mode.
        return true;
        DEFAULT_BUCKET_COUNT_THRESHOLDS
    /** Set a new order on this builder and return the builder so that calls
        if (collectMode != null) {
    }
    public TermsAggregationBuilder executionHint(String executionHint) {
    /**
    }
        PARSER.declareLong(TermsAggregationBuilder::shardMinDocCount, SHARD_MIN_DOC_COUNT_FIELD_NAME);
        return showTermDocCountError;
        return bucketCountThresholds.getShardSize();
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
import org.opensearch.index.query.QueryShardContext;
            throw new IllegalArgumentException("[collectMode] must not be null: [" + name + "]");
    }
        } else { // otherwise add a tie-breaker by using a compound order
    public String executionHint() {
import org.opensearch.index.query.QueryRewriteContext;
        this.bucketCountThresholds = new BucketCountThresholds(clone.bucketCountThresholds);
    public boolean equals(Object obj) {
        this.collectMode = collectMode;
     * Expert: sets an execution hint to the aggregation.
     * appear in the response.
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
     * Expert: gets an execution hint to the aggregation.
        PARSER.declareString(TermsAggregationBuilder::executionHint, EXECUTION_HINT_FIELD_NAME);
 * license agreements. See the NOTICE file distributed with
     * Read from a stream.
 */
        -1
            (b, v) -> b.includeExclude(IncludeExclude.merge(v, b.includeExclude())),
            this.order = order; // if order already contains a tie-breaker we are good to go
        if (super.equals(obj) == false) return false;
            TermsAggregationBuilder::collectMode,
        super(in);
            IncludeExclude.EXCLUDE_FIELD,
            collectMode,
        if (order == null) {
    @Override
    private boolean showTermDocCountError = false;
 * this file be licensed under the Apache-2.0 license or a
    public static final ParseField SHARD_MIN_DOC_COUNT_FIELD_NAME = new ParseField("shard_min_doc_count");
        if (shardSize <= 0) {
    }
 * compatible open source license.
        PARSER.declareBoolean(TermsAggregationBuilder::showTermDocCountError, TermsAggregationBuilder.SHOW_TERM_DOC_COUNT_ERROR);
     */
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
        return this;
    /**
    @Override
            metadata
            IncludeExclude::parseInclude,
    public SubAggCollectionMode collectMode() {
            IncludeExclude::parseExclude,
     * Get whether doc count error will be return for individual terms
        return this;
 */
        }
 * Aggregation Builder for terms agg
            throw new IllegalArgumentException(
 * @opensearch.internal
        bucketCountThresholds.toXContent(builder, params);
        }
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.support.ValuesSourceType;
     */
 * Licensed to Elasticsearch under one or more contributor
        return this;
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
        );
     */
            ObjectParser.ValueType.STRING
    public TermsAggregationBuilder shardSize(int shardSize) {
    }
    @Override
        if (minDocCount < 0) {
        }
        return this;
     */
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        bucketCountThresholds.writeTo(out);
        return bucketCountThresholds.getRequiredSize();
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        return new TermsAggregationBuilder(this, factoriesBuilder, metadata);
    public long shardMinDocCount() {
            && Objects.equals(order, other.order)
        PARSER.declareField(
    }
    public TermsAggregationBuilder includeExclude(IncludeExclude includeExclude) {
            parent,
     */
        QueryShardContext queryShardContext,
        10,
    static final TermsAggregator.BucketCountThresholds DEFAULT_BUCKET_COUNT_THRESHOLDS = new TermsAggregator.BucketCountThresholds(
        return new TermsAggregatorFactory(
