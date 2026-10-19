        showTermDocCountError = in.readBoolean();
    public MultiTermsAggregationBuilder minDocCount(long minDocCount) {
    public static final String NAME = "multi_terms";
 */
        MultiTermsAggregationBuilder other = (MultiTermsAggregationBuilder) obj;
     * Returns the number of term buckets per shard that are currently configured
 *             "value": 70.0
        return order;
                    + " ["
     * Set the minimum document count terms should have in order to appear in
    public MultiTermsAggregationBuilder(String name) {
     * Returns the minimum document count required per term
        if (collectMode == null) {
    public static final ParseField REQUIRED_SIZE_FIELD_NAME = new ParseField("size");
    /**
        }
 *           "doc_count": 2,
 *
     * Sets the order in which the buckets will be returned. A tie-breaker may be added to avoid non-deterministic
        }
        bucketCountThresholds.setMinDocCount(minDocCount);
    public static final ParseField SHARD_MIN_DOC_COUNT_FIELD_NAME = new ParseField("shard_min_doc_count");
        out.writeOptionalWriteable(collectMode);
     * Set the minimum document count terms should have on the shard in order to
     */
 *   GET test_000001/_search
     */
            subfactoriesBuilder,
            terms,
import org.opensearch.core.ParseField;
 * <pre>
            Aggregator.SubAggCollectionMode.KEY,
        collectMode = in.readOptionalWriteable(Aggregator.SubAggCollectionMode::readFromStream);
                    + name
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");
        }
        return this;
            throw new IllegalArgumentException("[collectMode] must not be null: [" + name + "]");
            true,
        PARSER.declareBoolean(MultiTermsAggregationBuilder::showTermDocCountError, SHOW_TERM_DOC_COUNT_ERROR);
    static {
    @Override
 *           "key": [
     * ordering.
 *     }
    /**
    public long minDocCount() {
        return Objects.equals(terms, other.terms)
 *             "field": "region"
 *           },
            MultiTermsAggregationBuilder.NAME,
    }
 *           "max-memory": {
 *
                    + "]"
        final ObjectParser<MultiTermsValuesSourceConfig.Builder, Void> parser = MultiTermsValuesSourceConfig.PARSER.apply(
 *   The aggregation result contains
 *             "dub",
            metadata,
    public MultiTermsAggregationBuilder shardMinDocCount(long shardMinDocCount) {
        return this;
        out.writeList(terms);
     */
        AggregatorFactories.Builder factoriesBuilder,
        AggregatorFactory parent,
import org.opensearch.search.aggregations.Aggregator;
    public BucketCardinality bucketCardinality() {
     */
    @Override
    }
            );
import org.opensearch.core.xcontent.ObjectParser;
        return this;
            MultiTermsAggregationFactory.InternalValuesSourceSupplier.class
        }
 *       "sum_other_doc_count": 0,
 *         }
        QueryShardContext queryShardContext,
 *   For example, using the multi-terms aggregation to group by two fields region, host, calculate max cpu, and sort by max cpu.
 *           "key": [
        builder.field(ORDER_FIELD.getPreferredName());
        PARSER.declareObjectArray(MultiTermsAggregationBuilder::order, (p, c) -> InternalOrder.Parser.parseOrderParam(p), ORDER_FIELD);
            MultiTermsAggregationBuilder::collectMode,
    protected void doWriteTo(StreamOutput out) throws IOException {
 *     }
    );
            && Objects.equals(order, other.order)
     */
 *         "multi_terms": {
            collectMode,
 * </pre>
 *             "h1"
        }
    public MultiTermsAggregationBuilder size(int size) {
 *           ],
    );
 *             "max-memory": "desc"
     * Gets the order in which the buckets will be returned.
    public boolean showTermDocCountError() {
    public MultiTermsAggregationBuilder collectMode(Aggregator.SubAggCollectionMode collectMode) {
    }
    /**
 * compatible open source license.
        PARSER.declareField(
        return Objects.hash(super.hashCode(), bucketCountThresholds, collectMode, order, showTermDocCountError);
            throw new IllegalArgumentException("[orders] must not be null: [" + name + "]");
        return this;
        this.terms = terms;
    /**
        PARSER.declareInt(MultiTermsAggregationBuilder::size, REQUIRED_SIZE_FIELD_NAME);
 *           "doc_count": 2,
        order.toXContent(builder, params);
import java.io.IOException;
 *     "aggs": {
import org.opensearch.index.query.QueryShardContext;
            true,
        super(name);
import java.util.Map;
     * Get whether doc count error will be return for individual terms
 *           },{
/*
        }
 *           "terms": [{
 *           "max-cpu": {
        return this;
        super(clone, factoriesBuilder, metadata);
     */
        terms = in.readList(MultiTermsValuesSourceConfig::new);
    private List<MultiTermsValuesSourceConfig> terms;
 *
 *     - key: a list of value extract from multiple fields in the same doc.
    @Override
    public MultiTermsAggregationBuilder shardSize(int shardSize) {
 *       "buckets": [
    @Override
 *             "field": "host"
        if (orders == null) {
        if (order == null) {
    public int size() {
            && Objects.equals(collectMode, other.collectMode)
            throw new IllegalArgumentException("[terms] must not be null. Found null terms in [" + name + "]");
    public static final ParseField ORDER_FIELD = new ParseField("order");
 *       }
import org.opensearch.search.aggregations.AggregatorFactory;
            builder.field(Aggregator.SubAggCollectionMode.KEY.getPreferredName(), collectMode.parseField().getPreferredName());
 *           ],
 * @opensearch.internal
     * Returns the number of term buckets currently configured
    }
 *             "value": 90.0
 * The OpenSearch Contributors require contributions made to
        this.bucketCountThresholds = new TermsAggregator.BucketCountThresholds(clone.bucketCountThresholds);
     */
    }
        if (this == obj) return true;
        new ValuesSourceRegistry.RegistryKey<>(
     */
        this.showTermDocCountError = clone.showTermDocCountError;
import org.opensearch.search.aggregations.BucketOrder;
    @Override
 *   }
    /**
 *             "h2"
    public int shardSize() {
 *           "order": [{
     * search execution). The higher the shard size is, the more accurate the
    }
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
    private boolean showTermDocCountError = false;
import java.util.Objects;
            this.order = order; // if order already contains a tie-breaker we are good to go
        }
        PARSER.declareObjectArray(MultiTermsAggregationBuilder::terms, (p, c) -> parser.parse(p, null).build(), TERMS_FIELD);
    }
 *   simply encoding/decoding a list of values as bucket keys.
            name,
        return NAME;
    /**
 *     "hot": {
 *   <b>Notes:</b> The current implementation focuses on adding new type aggregates. Performance (latency) is not good，mainly because of
    public static final ParseField MIN_DOC_COUNT_FIELD_NAME = new ParseField("min_doc_count");
            parent,
 * <p>
    protected AggregatorFactory doBuild(
        );
     */
    @Override
        bucketCountThresholds = new TermsAggregator.BucketCountThresholds(in);
 *           "max-memory": { "max": { "field": "memory" } }
    public boolean equals(Object obj) {
    }
    }
        PARSER.declareInt(MultiTermsAggregationBuilder::shardSize, SHARD_SIZE_FIELD_NAME);
package org.opensearch.search.aggregations.bucket.terms;
 * </p>
        }
 *         "aggs": {
    }
 *
        this.order = clone.order;
     * Read from a stream.
        // if the list only contains one order use that to avoid inconsistent xcontent
    }
    public static final ParseField SHARD_SIZE_FIELD_NAME = new ParseField("shard_size");
 *           "key_as_string": "dub|h2",
     * Set the terms.
     * the response.
        this.collectMode = clone.collectMode;
            throw new IllegalArgumentException(
            && Objects.equals(showTermDocCountError, other.showTermDocCountError);
    }
        return new MultiTermsAggregationBuilder(this, factoriesBuilder, metadata);
        }
    }
 *             "value": 90.0
            && Objects.equals(bucketCountThresholds, other.bucketCountThresholds)
    }
            showTermDocCountError
    public MultiTermsAggregationBuilder showTermDocCountError(boolean showTermDocCountError) {
        if (shardMinDocCount < 0) {
    }
    private BucketOrder order = BucketOrder.compound(BucketOrder.count(false)); // automatically adds tie-breaker key asc order
    public MultiTermsAggregationBuilder terms(List<MultiTermsValuesSourceConfig> terms) {
        builder.startObject();
    protected MultiTermsAggregationBuilder(
 *         {
    private TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(
    }
     * Sets the size - indicating how many term buckets should be returned
    /**
        if (order instanceof InternalOrder.CompoundOrder || InternalOrder.isKeyOrder(order)) {
 */
        return new MultiTermsAggregationFactory(
 *         {
        }
        return showTermDocCountError;
    public BucketOrder order() {
        MultiTermsAggregationBuilder clone,
        if (minDocCount < 0) {
    private Aggregator.SubAggCollectionMode collectMode = null;
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
    public Aggregator.SubAggCollectionMode collectMode() {
 *       ]
 *       "hot": {
     * Set whether doc count error will be return for individual terms
        PARSER.declareLong(MultiTermsAggregationBuilder::shardMinDocCount, SHARD_MIN_DOC_COUNT_FIELD_NAME);
    /**
 *           "key_as_string": "dub|h1",
public class MultiTermsAggregationBuilder extends AbstractAggregationBuilder<MultiTermsAggregationBuilder> {
    public int hashCode() {
 *           }]
import org.opensearch.core.xcontent.XContentBuilder;
    }
    }
     */
        );
        return bucketCountThresholds.getRequiredSize();
    @Override
        );
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
 *             "max-cpu": "desc"
 * </pre>
 *   }
     */
     *  can be chained. A tie-breaker may be added to avoid non-deterministic ordering. */
 *             "value": 80.0
    public MultiTermsAggregationBuilder(StreamInput in) throws IOException {
 * </p>
                "multi term aggregation must has at least 2 terms. Found ["
            throw new IllegalArgumentException(
        } else { // otherwise add a tie-breaker by using a compound order
 *           }
            ObjectParser.ValueType.STRING
import org.opensearch.core.common.io.stream.StreamOutput;
        return bucketCountThresholds.getMinDocCount();
 *           "max-memory": {
            this.order = BucketOrder.compound(order);
    public MultiTermsAggregationBuilder order(List<BucketOrder> orders) {
    }
        if (shardSize <= 0) {
        bucketCountThresholds.writeTo(out);
        this.terms = new ArrayList<>(clone.terms);
        return builder;
    /**
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
        return collectMode;
            throw new IllegalArgumentException("[order] must not be null: [" + name + "]");
        return this;
import org.opensearch.search.aggregations.InternalOrder;
            throw new IllegalArgumentException("[shardSize] must be greater than 0. Found [" + shardSize + "] in [" + name + "]");
        return bucketCountThresholds.getShardMinDocCount();
        if (terms == null) {
     */
     */
    public static final ParseField SHOW_TERM_DOC_COUNT_ERROR = new ParseField("show_term_doc_count_error");
            );
            (p, c) -> Aggregator.SubAggCollectionMode.parse(p.text(), LoggingDeprecationHandler.INSTANCE),
            queryShardContext,
import static org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS;
 *   {
            order,
        builder.field(SHOW_TERM_DOC_COUNT_ERROR.getPreferredName(), showTermDocCountError);
 *   {
    public static final ObjectParser<MultiTermsAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
        bucketCountThresholds.setRequiredSize(size);
    }
            throw new IllegalArgumentException(
 *             "dub",
            true,
 * this file be licensed under the Apache-2.0 license or a
    /**
     * Expert: get the collection mode.
        if (obj == null || getClass() != obj.getClass()) return false;
        out.writeBoolean(showTermDocCountError);
    @Override
     */
     */
     * Expert: set the collection mode.
        order(orders.size() > 1 ? BucketOrder.compound(orders) : orders.get(0));
    public long shardMinDocCount() {
    }
    }
        if (terms.size() < 2) {
        bucketCountThresholds.setShardSize(shardSize);
    }
        this.collectMode = collectMode;
    ) {
 * Multi-terms aggregation supports collecting terms from multiple fields in the same document.
 *         }
    public static final ValuesSourceRegistry.RegistryKey<MultiTermsAggregationFactory.InternalValuesSourceSupplier> REGISTRY_KEY =
/**
    /**
 *       "doc_count_error_upper_bound": 0,
    }
        bucketCountThresholds.setShardMinDocCount(shardMinDocCount);
     * Sets the shard_size - indicating the number of term buckets each shard
        return this;
        this.showTermDocCountError = showTermDocCountError;
    }
 * <p>
 * </p>
 *         },
    public static final ParseField TERMS_FIELD = new ParseField("terms");
     * Returns the minimum document count required per term, per shard
        if (terms != null) {
        AggregatorFactories.Builder subfactoriesBuilder
    }
        MultiTermsAggregationBuilder::new
        builder.endObject();
 *           "max-cpu": { "max": { "field": "cpu" } },
        return this;
import java.util.ArrayList;
 * <p>
import org.opensearch.core.common.io.stream.StreamInput;
        if (super.equals(obj) == false) return false;
 *
     * results are.
 * SPDX-License-Identifier: Apache-2.0
        return BucketCardinality.MANY;
    public MultiTermsAggregationBuilder order(BucketOrder order) {
 *           },
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        bucketCountThresholds.toXContent(builder, params);
 *           }
    ) throws IOException {
 *           "max-cpu": {
import org.opensearch.search.aggregations.AggregationBuilder;
 *           },{
        PARSER.declareLong(MultiTermsAggregationBuilder::minDocCount, MIN_DOC_COUNT_FIELD_NAME);
        super(in);
    /**
        }
            );
 *           }],
    /**
 * <pre>
    /** Set a new order on this builder and return the builder so that calls
        return bucketCountThresholds.getShardSize();
     * (defaults to 10)
import org.opensearch.search.aggregations.AggregatorFactories;
     */
    /**
     * will return to the coordinating node (the node that coordinates the
        order = InternalOrder.Streams.readOrder(in);
            builder.field(TERMS_FIELD.getPreferredName(), terms);
                    + terms.size()
        );
                "[shardMinDocCount] must be greater than or equal to 0. Found [" + shardMinDocCount + "] in [" + name + "]"
}
    /**
        DEFAULT_BUCKET_COUNT_THRESHOLDS
            true
     * appear in the response.
            bucketCountThresholds,
                    + "] in"
                    + (terms.size() == 1 ? " Use terms aggregation for single term aggregation" : "")
 *         },
    }
 *     "size": 0,
        if (collectMode != null) {
    }
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        }
    /**
import java.util.List;
        Map<String, Object> metadata
        order.writeTo(out);
        if (size <= 0) {
    public String getType() {
        NAME,
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
        return this;
