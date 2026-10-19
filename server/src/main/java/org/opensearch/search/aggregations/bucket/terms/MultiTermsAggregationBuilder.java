 *           "order": [{
    /** Set a new order on this builder and return the builder so that calls  
        return showTermDocCountError;
        order(orders.size() > 1 ? BucketOrder.compound(orders) : orders.get(0));
 *             "value": 70.0
        super(name);  
        if (obj == null || getClass() != obj.getClass()) return false;
        QueryShardContext queryShardContext,
 * <p>  
    /**
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.core.xcontent.ObjectParser;
        }
 *             "h2"
    public static final ParseField MIN_DOC_COUNT_FIELD_NAME = new ParseField("min_doc_count");
    /**
     * Expert: get the collection mode.
        );  
            true,
 *             "h1"  
        this.order = clone.order;
    }  
        showTermDocCountError = in.readBoolean();  
        }
        return Objects.hash(super.hashCode(), bucketCountThresholds, collectMode, order, showTermDocCountError);
     */
        new ValuesSourceRegistry.RegistryKey<>(  
            throw new IllegalArgumentException("[collectMode] must not be null: [" + name + "]");  
 *   }
        final ObjectParser<MultiTermsValuesSourceConfig.Builder, Void> parser = MultiTermsValuesSourceConfig.PARSER.apply(
    @Override
     */  
        }
        if (order instanceof InternalOrder.CompoundOrder || InternalOrder.isKeyOrder(order)) {  
    }
    public MultiTermsAggregationBuilder shardSize(int shardSize) {  
 *     "size": 0,
 *   The aggregation result contains  
 *           "max-cpu": { "max": { "field": "cpu" } },  
        this.terms = new ArrayList<>(clone.terms);  
 *         "aggs": {
    public MultiTermsAggregationBuilder order(List<BucketOrder> orders) {  
 *       "doc_count_error_upper_bound": 0,  
     */  
 *           "terms": [{  
        return this;
        }  
        return collectMode;
        return this;
        if (terms.size() < 2) {
import org.opensearch.search.aggregations.AggregatorFactories;
import org.opensearch.search.aggregations.InternalOrder;
     */
import java.io.IOException;  
                    + terms.size()
    private TermsAggregator.BucketCountThresholds bucketCountThresholds = new TermsAggregator.BucketCountThresholds(  
        bucketCountThresholds.setMinDocCount(minDocCount);
        }  
import org.opensearch.core.ParseField;
            throw new IllegalArgumentException(  
    @Override
    public static final ParseField ORDER_FIELD = new ParseField("order");
     * Sets the size - indicating how many term buckets should be returned  
        this.showTermDocCountError = showTermDocCountError;  
        this.collectMode = clone.collectMode;
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
 *           ],
        AggregatorFactories.Builder subfactoriesBuilder
        return NAME;  
    }
    public static final ValuesSourceRegistry.RegistryKey<MultiTermsAggregationFactory.InternalValuesSourceSupplier> REGISTRY_KEY =
            MultiTermsAggregationBuilder::collectMode,
        bucketCountThresholds = new TermsAggregator.BucketCountThresholds(in);  
    }
 *
     * Returns the number of term buckets per shard that are currently configured  
    }
 *           "max-cpu": {  
        PARSER.declareField(  
                "[shardMinDocCount] must be greater than or equal to 0. Found [" + shardMinDocCount + "] in [" + name + "]"
    /**
        if (size <= 0) {
            this.order = BucketOrder.compound(order);  
    }  
                    + "]"  
            true
 *           ],  
 */  
    public boolean equals(Object obj) {  
            subfactoriesBuilder,
            true,
        DEFAULT_BUCKET_COUNT_THRESHOLDS
 * this file be licensed under the Apache-2.0 license or a
        return new MultiTermsAggregationBuilder(this, factoriesBuilder, metadata);  
 * <p>
    @Override
     */
     * Returns the number of term buckets currently configured  
public class MultiTermsAggregationBuilder extends AbstractAggregationBuilder<MultiTermsAggregationBuilder> {
     * Set the terms.
        PARSER.declareBoolean(MultiTermsAggregationBuilder::showTermDocCountError, SHOW_TERM_DOC_COUNT_ERROR);  
        return bucketCountThresholds.getShardMinDocCount();  
        } else { // otherwise add a tie-breaker by using a compound order
    }  
 *       "buckets": [
    }
                    + "] in"  
        }
    private List<MultiTermsValuesSourceConfig> terms;
 *   {
        if (minDocCount < 0) {
        builder.startObject();
    /**
            );
    }  
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
 *           "doc_count": 2,
    public long shardMinDocCount() {
     *  can be chained. A tie-breaker may be added to avoid non-deterministic ordering. */
        NAME,
            Aggregator.SubAggCollectionMode.KEY,  
    private Aggregator.SubAggCollectionMode collectMode = null;
            metadata,
        builder.field(ORDER_FIELD.getPreferredName());
    @Override  
 * <p>
        return this;
import java.util.List;
 *           "max-memory": { "max": { "field": "memory" } }
    );
        if (collectMode == null) {
            builder.field(Aggregator.SubAggCollectionMode.KEY.getPreferredName(), collectMode.parseField().getPreferredName());
        collectMode = in.readOptionalWriteable(Aggregator.SubAggCollectionMode::readFromStream);
 *             "value": 90.0
        if (this == obj) return true;
     * Set the minimum document count terms should have on the shard in order to
            && Objects.equals(order, other.order)
            throw new IllegalArgumentException("[terms] must not be null. Found null terms in [" + name + "]");  
 *             "max-memory": "desc"
    public BucketCardinality bucketCardinality() {
 *           }]  
 *         },
    protected void doWriteTo(StreamOutput out) throws IOException {
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        // if the list only contains one order use that to avoid inconsistent xcontent
     * Set the minimum document count terms should have in order to appear in
 *   simply encoding/decoding a list of values as bucket keys.
        super(clone, factoriesBuilder, metadata);
    /**
     */
 *             "max-cpu": "desc"  
 *           }],
        Map<String, Object> metadata  
 *             "dub",
    }  
        builder.field(SHOW_TERM_DOC_COUNT_ERROR.getPreferredName(), showTermDocCountError);  
 * </pre>
            throw new IllegalArgumentException(  
     * appear in the response.
    public MultiTermsAggregationBuilder minDocCount(long minDocCount) {
        );  
            && Objects.equals(bucketCountThresholds, other.bucketCountThresholds)  
    /**
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;  
 *           },{
    public static final String NAME = "multi_terms";
    public MultiTermsAggregationBuilder order(BucketOrder order) {
            showTermDocCountError
    }  
        if (collectMode != null) {  
 *           },
/**
     * Gets the order in which the buckets will be returned.
        MultiTermsAggregationBuilder clone,
    @Override
    }
 *         "multi_terms": {
            this.order = order; // if order already contains a tie-breaker we are good to go
 *       }  
        }
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
    public MultiTermsAggregationBuilder(String name) {
    );  
        if (terms != null) {
            throw new IllegalArgumentException("[orders] must not be null: [" + name + "]");
 *         {
    /**  
    /**
        PARSER.declareInt(MultiTermsAggregationBuilder::size, REQUIRED_SIZE_FIELD_NAME);
    }
    public String getType() {
        if (shardMinDocCount < 0) {
     * Returns the minimum document count required per term  
 * compatible open source license.
     * Read from a stream.
    public static final ParseField SHARD_SIZE_FIELD_NAME = new ParseField("shard_size");  
    }
    }  
 * The OpenSearch Contributors require contributions made to  
        return builder;
    public long minDocCount() {
        AggregatorFactories.Builder factoriesBuilder,
 * </p>
 * </pre>  
    public MultiTermsAggregationBuilder(StreamInput in) throws IOException {  
        );
     * ordering.
        this.showTermDocCountError = clone.showTermDocCountError;
 *   <b>Notes:</b> The current implementation focuses on adding new type aggregates. Performance (latency) is not good，mainly because of
 *       "sum_other_doc_count": 0,
/*  
        out.writeBoolean(showTermDocCountError);  
 *         }  
            true,  
 *   GET test_000001/_search  
 *           },{
    @Override  
    public static final ParseField SHOW_TERM_DOC_COUNT_ERROR = new ParseField("show_term_doc_count_error");
        MultiTermsAggregationBuilder other = (MultiTermsAggregationBuilder) obj;
        return bucketCountThresholds.getMinDocCount();  
        return new MultiTermsAggregationFactory(  
    public BucketOrder order() {  
        PARSER.declareInt(MultiTermsAggregationBuilder::shardSize, SHARD_SIZE_FIELD_NAME);
        return this;
        AggregatorFactory parent,  
import org.opensearch.core.common.io.stream.StreamInput;  
        this.collectMode = collectMode;
 *           "max-memory": {
 *
        PARSER.declareObjectArray(MultiTermsAggregationBuilder::order, (p, c) -> InternalOrder.Parser.parseOrderParam(p), ORDER_FIELD);
                    + " ["
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
            throw new IllegalArgumentException("[shardSize] must be greater than 0. Found [" + shardSize + "] in [" + name + "]");
            && Objects.equals(collectMode, other.collectMode)
     */
        return this;
 *             "field": "host"  
 *           },  
        bucketCountThresholds.toXContent(builder, params);
    private boolean showTermDocCountError = false;  
            && Objects.equals(showTermDocCountError, other.showTermDocCountError);  
     * Expert: set the collection mode.
        }  
 *           "doc_count": 2,  
 *           "max-cpu": {
package org.opensearch.search.aggregations.bucket.terms;
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            );
     * the response.
 * </p>
                    + name
            terms,  
    }
    }  
        }  
            builder.field(TERMS_FIELD.getPreferredName(), terms);  
 */  
    public Aggregator.SubAggCollectionMode collectMode() {  
 *             "value": 80.0
        if (terms == null) {
        out.writeOptionalWriteable(collectMode);
     */
            throw new IllegalArgumentException(  
            bucketCountThresholds,  
        if (super.equals(obj) == false) return false;  
    public MultiTermsAggregationBuilder size(int size) {  
            throw new IllegalArgumentException("[order] must not be null: [" + name + "]");
    public static final ParseField REQUIRED_SIZE_FIELD_NAME = new ParseField("size");  
 *   For example, using the multi-terms aggregation to group by two fields region, host, calculate max cpu, and sort by max cpu.  
 *
import org.opensearch.index.query.QueryShardContext;
            queryShardContext,
            MultiTermsAggregationFactory.InternalValuesSourceSupplier.class
     * Sets the shard_size - indicating the number of term buckets each shard
 * SPDX-License-Identifier: Apache-2.0
    /**
 *           }
    }
    public boolean showTermDocCountError() {
    }
        if (order == null) {  
import org.opensearch.search.aggregations.AggregationBuilder;  
    /**  
     */
    protected MultiTermsAggregationBuilder(  
    }
 *             "value": 90.0
    public static final ParseField TERMS_FIELD = new ParseField("terms");
    public MultiTermsAggregationBuilder shardMinDocCount(long shardMinDocCount) {
    }
        if (orders == null) {
    public MultiTermsAggregationBuilder collectMode(Aggregator.SubAggCollectionMode collectMode) {
        if (shardSize <= 0) {
        super(in);
    @Override
 * <pre>  
 *           "key_as_string": "dub|h1",
 * </p>  
    public MultiTermsAggregationBuilder showTermDocCountError(boolean showTermDocCountError) {
 * @opensearch.internal
        builder.endObject();  
    public static final ObjectParser<MultiTermsAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(  
}
 *     - key: a list of value extract from multiple fields in the same doc.
     * will return to the coordinating node (the node that coordinates the
 *           "key_as_string": "dub|h2",
        terms = in.readList(MultiTermsValuesSourceConfig::new);
        order = InternalOrder.Streams.readOrder(in);
            );
        }  
        PARSER.declareLong(MultiTermsAggregationBuilder::shardMinDocCount, SHARD_MIN_DOC_COUNT_FIELD_NAME);  
        this.terms = terms;
    public int hashCode() {
 *       "hot": {
            collectMode,
        order.writeTo(out);
     */
        return this;
import java.util.Map;  
 *             "dub",
 *
        return this;
                    + (terms.size() == 1 ? " Use terms aggregation for single term aggregation" : "")
        return bucketCountThresholds.getRequiredSize();  
    /**  
        return bucketCountThresholds.getShardSize();  
        return BucketCardinality.MANY;  
     * results are.
    public MultiTermsAggregationBuilder terms(List<MultiTermsValuesSourceConfig> terms) {
        PARSER.declareObjectArray(MultiTermsAggregationBuilder::terms, (p, c) -> parser.parse(p, null).build(), TERMS_FIELD);
import java.util.Objects;
        out.writeList(terms);
        this.bucketCountThresholds = new TermsAggregator.BucketCountThresholds(clone.bucketCountThresholds);  
     */
    }
    public int shardSize() {
    ) {
     */
    ) throws IOException {
     * Get whether doc count error will be return for individual terms
    }
        bucketCountThresholds.setShardSize(shardSize);
     */
        bucketCountThresholds.setRequiredSize(size);
 *     }
 *           "max-memory": {  
        }  
    /**  
     * search execution). The higher the shard size is, the more accurate the  
    protected AggregatorFactory doBuild(
        );
import java.util.ArrayList;
            name,
    }  
 *   {
 *         }
     */  
 *
        bucketCountThresholds.writeTo(out);  
            ObjectParser.ValueType.STRING
    /**  
        return this;  
 *     "aggs": {  
    /**  
    }
        return order;
        PARSER.declareLong(MultiTermsAggregationBuilder::minDocCount, MIN_DOC_COUNT_FIELD_NAME);
        bucketCountThresholds.setShardMinDocCount(shardMinDocCount);
        }
 *         {  
            order,
        order.toXContent(builder, params);
     */  
    private BucketOrder order = BucketOrder.compound(BucketOrder.count(false)); // automatically adds tie-breaker key asc order
 *     "hot": {
        return this;  
        MultiTermsAggregationBuilder::new
     * (defaults to 10)
    }
    public int size() {
        return Objects.equals(terms, other.terms)
    }
    /**
                "multi term aggregation must has at least 2 terms. Found ["
 * <pre>
            parent,  
            throw new IllegalArgumentException("[size] must be greater than 0. Found [" + size + "] in [" + name + "]");
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {  
 *           "key": [  
 *       ]
    public static final ParseField SHARD_MIN_DOC_COUNT_FIELD_NAME = new ParseField("shard_min_doc_count");
 *           }  
import org.opensearch.core.xcontent.XContentBuilder;  
 * Multi-terms aggregation supports collecting terms from multiple fields in the same document.  
    @Override  
    static {  
 *             "field": "region"
import static org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder.DEFAULT_BUCKET_COUNT_THRESHOLDS;  
     * Set whether doc count error will be return for individual terms  
 *   }  
     * Sets the order in which the buckets will be returned. A tie-breaker may be added to avoid non-deterministic  
 *     }
 *         },
import org.opensearch.search.aggregations.Aggregator;
     */  
 *           "key": [
            MultiTermsAggregationBuilder.NAME,
     * Returns the minimum document count required per term, per shard  
            (p, c) -> Aggregator.SubAggCollectionMode.parse(p.text(), LoggingDeprecationHandler.INSTANCE),
    /**
import org.opensearch.search.aggregations.AggregatorFactory;  
