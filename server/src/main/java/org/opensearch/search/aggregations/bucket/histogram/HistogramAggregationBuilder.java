    }
    @Override  
    }
        HistogramAggregatorFactory.registerAggregators(builder);  
    @Override
            (p, c) -> InternalOrder.Parser.parseOrderParam(p),  
 *
    private long minDocCount = 0;  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        if (order != null) {
    public HistogramAggregationBuilder offset(double offset) {  
        this.hardBounds = clone.hardBounds;  
            metadata  
 */  
            throw new IllegalArgumentException("[extended_bounds] must not be null: [" + name + "]");
        EXTENDED_BOUNDS_PARSER.declareDouble((bounds, d) -> bounds[1] = d, new ParseField("max"));
    }
        InternalOrder.Streams.writeHistogramOrder(order, out, true);
 */
        if (hardBounds != null) {
        builder.field(Histogram.INTERVAL_FIELD.getPreferredName(), interval);
            interval,
    public double interval() {
        return Objects.hash(super.hashCode(), order, keyed, minDocCount, interval, offset, extendedBounds, hardBounds);  
package org.opensearch.search.aggregations.bucket.histogram;
 * this file be licensed under the Apache-2.0 license or a
        return this;  
    );
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
    }  
        QueryShardContext queryShardContext,
 * compatible open source license.
        PARSER.declareField(
            && Objects.equals(hardBounds, other.hardBounds);  
    }
    private static final ObjectParser<double[], Void> EXTENDED_BOUNDS_PARSER = new ObjectParser<>(
        }
    static {  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        Histogram.EXTENDED_BOUNDS_FIELD.getPreferredName(),  
        this.offset = offset;
        }  
        return this;  
        );
        return minDocCount;  
     * {@code maxBound} will be created even if no documents fell into these
        } else { // otherwise add a tie-breaker by using a compound order
    /** Get the current minimum bound that is set on this builder. */
    }  
                );  
    @Override  
        return this;  
     *  and return this builder so that calls can be chained. */
        }
import org.opensearch.search.aggregations.BucketOrder;
            keyed,
    public HistogramAggregationBuilder interval(double interval) {
    protected HistogramAggregationBuilder(  
        if (extendedBounds == null) {  
        PARSER.declareField(  
            extendedBounds.toXContent(builder, params);
        }
import org.opensearch.core.common.io.stream.StreamOutput;  
        HistogramAggregationBuilder other = (HistogramAggregationBuilder) obj;
/*  
    /** Return whether buckets should be returned as a hash. In case
            builder.endObject();
        PARSER.declareDouble(HistogramAggregationBuilder::interval, Histogram.INTERVAL_FIELD);  
     */  
 * SPDX-License-Identifier: Apache-2.0
        if (minDocCount < 0) {  
/*
 *  
        if (this == obj) return true;
            config,
            && Objects.equals(offset, other.offset)
 *
    /**
            hardBounds,
import org.opensearch.search.aggregations.AggregatorFactories;
    }  
            if (hardBounds.getMin() != null && extendedBounds.getMin() != null && hardBounds.getMin() > extendedBounds.getMin()) {
     * @throws IllegalArgumentException  
     * Set extended bounds on this builder: buckets between {@code minBound} and  
import org.opensearch.core.ParseField;
            Histogram.HARD_BOUNDS_FIELD,  
 *
     * buckets.
    public static final ValuesSourceRegistry.RegistryKey<HistogramAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(  
    public double offset() {
            builder.startObject(Histogram.HARD_BOUNDS_FIELD.getPreferredName());  
    }
        if (hardBounds == null) {
            && Objects.equals(minDocCount, other.minDocCount)
            parser -> DoubleBounds.PARSER.apply(parser, null),
                        + "]"
import java.io.IOException;
        return this;
        builder.field(Histogram.OFFSET_FIELD.getPreferredName(), offset);  
        // if the list only contains one order use that to avoid inconsistent xcontent  
     * ordering.  
    }
            ObjectParser.ValueType.OBJECT  
     */
    @Override
 * KIND, either express or implied.  See the License for the
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
            order.toXContent(builder, params);
    public HistogramAggregationBuilder hardBounds(DoubleBounds hardBounds) {
    private boolean keyed = false;
                        + hardBounds  
    }
    public double maxBound() {
        return BucketCardinality.MANY;
 * ownership. Elasticsearch licenses this file to you under  
            && Objects.equals(interval, other.interval)  
        return extendedBounds;
    @Override
        return new HistogramAggregationBuilder(this, factoriesBuilder, metadata);
 * You may obtain a copy of the License at  
                        + "--"  
    /** Read from a stream, for internal use only. */
        return builder;
import java.util.Objects;
     *             are not finite.  
    /**
        AggregatorFactories.Builder factoriesBuilder,
        Map<String, Object> metadata  
            Histogram.EXTENDED_BOUNDS_FIELD,
            this.order = BucketOrder.compound(order);
    /** Set whether to return buckets as a hash or as an array, and return the
    @Override  
    }
     *  builder so that calls can be chained. */  
    private DoubleBounds hardBounds;  
                        + "], extended bounds: ["
    /**
    /** Get the current interval that is set on this builder. */
            parent,
    );
 * Unless required by applicable law or agreed to in writing,
        this.offset = clone.offset;
    /** Return the minimum count of documents that buckets need to have in order  
        minDocCount = in.readVLong();
    protected ValuesSourceType defaultValueSourceType() {  
            ObjectParser.ValueType.OBJECT
    }
            offset,  
    }  
    }  
    }
    ) throws IOException {  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
        return CoreValuesSourceType.NUMERIC;
            HistogramAggregationBuilder::extendedBounds,  
            builder.field(Histogram.ORDER_FIELD.getPreferredName());  
    @Override  
    }
        ValuesSourceConfig config,  
 * this work for additional information regarding copyright
    }  
                );
        NAME,  
    public long minDocCount() {
        if (order == null) {
        out.writeDouble(offset);
        );
        order = InternalOrder.Streams.readHistogramOrder(in, true);
        this.interval = clone.interval;  
        interval = in.readDouble();
            HistogramAggregationBuilder::hardBounds,
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;  
        this.order = clone.order;
     */
        return new HistogramAggregatorFactory(
     * {@code maxBound} will be created even if no documents fell into these  
        AggregatorFactories.Builder subFactoriesBuilder
        return interval;  
        return DoubleBounds.getEffectiveMin(extendedBounds);
                throw new IllegalArgumentException(  
                        + extendedBounds.getMax()
        this.keyed = keyed;
    @Override
     *  to be included in the response. */
        return offset;
        if (hardBounds != null && extendedBounds != null) {
        this.minDocCount = minDocCount;
        PARSER.declareDouble(HistogramAggregationBuilder::offset, Histogram.OFFSET_FIELD);
        HistogramAggregationBuilder::new
            builder.endObject();
        this.minDocCount = clone.minDocCount;  
    private double offset = 0;
        }
    public boolean equals(Object obj) {
        }
        }
        AggregatorFactory parent,
        out.writeVLong(minDocCount);  
    }  
    }  
        this.keyed = clone.keyed;
    public BucketCardinality bucketCardinality() {
    public HistogramAggregationBuilder(StreamInput in) throws IOException {  
     *
        return order;
        );
    public HistogramAggregationBuilder extendedBounds(DoubleBounds extendedBounds) {
    public HistogramAggregationBuilder keyed(boolean keyed) {
 * license agreements. See the NOTICE file distributed with
        }
        out.writeDouble(interval);
        PARSER.declareLong(HistogramAggregationBuilder::minDocCount, Histogram.MIN_DOC_COUNT_FIELD);  
    ) {
    protected ValuesSourceAggregatorFactory innerBuild(
    @Override
import org.opensearch.search.aggregations.AggregatorFactory;  
        return this;
/*  
    }
 * under the License.  
        PARSER.declareBoolean(HistogramAggregationBuilder::keyed, Histogram.KEYED_FIELD);
    public boolean keyed() {
    /**
import org.opensearch.core.xcontent.ObjectParser;
        if (interval <= 0) {
 * fields are unsupported, and will throw at the factory layer.  
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    public HistogramAggregationBuilder extendedBounds(double minBound, double maxBound) {
        if (order instanceof CompoundOrder || InternalOrder.isKeyOrder(order)) {
    }
    /** Get the current maximum bound that is set on this builder. */
    }  
    public HistogramAggregationBuilder order(List<BucketOrder> orders) {
            throw new IllegalArgumentException("[hardBounds] must not be null: [" + name + "]");  
        return this;  
            throw new IllegalArgumentException("[orders] must not be null: [" + name + "]");
        return NAME;
import org.opensearch.core.xcontent.XContentBuilder;
            }
    }
    static {  
     * Set extended bounds on this builder: buckets between {@code minBound} and
        out.writeBoolean(keyed);
            subFactoriesBuilder,
 * specific language governing permissions and limitations
    }
    public static final String NAME = "histogram";
/**
        HistogramAggregatorSupplier.class
    }  
        () -> new double[] { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }
            && Objects.equals(keyed, other.keyed)
            minDocCount,  
        extendedBounds = in.readOptionalWriteable(DoubleBounds::new);
            parser -> DoubleBounds.PARSER.apply(parser, null),
                        + "--"
 * not use this file except in compliance with the License.
import java.util.Map;
            this.order = order; // if order already contains a tie-breaker we are good to go  
    public BucketOrder order() {
    }
                        + "], extended bounds: ["  
        this.hardBounds = hardBounds;
}
        this.extendedBounds = clone.extendedBounds;
            }  
    /** Create a new builder with the given name. */
        );
    public HistogramAggregationBuilder minDocCount(long minDocCount) {
        }  
     * Sets the order in which the buckets will be returned. A tie-breaker may be added to avoid non-deterministic
     * @throws IllegalArgumentException
import org.opensearch.search.aggregations.AggregationBuilder;
 * @opensearch.internal
                        + extendedBounds.getMax()  
                        + extendedBounds.getMin()
        HistogramAggregationBuilder clone,
        out.writeOptionalWriteable(extendedBounds);  
            if (hardBounds.getMax() != null && extendedBounds.getMax() != null && hardBounds.getMax() < extendedBounds.getMax()) {  
            );  
        if (obj == null || getClass() != obj.getClass()) return false;  
        super(in);
            builder.startObject(Histogram.EXTENDED_BOUNDS_FIELD.getPreferredName());  
import java.util.List;  
     *  
        NAME,
        order(orders.size() > 1 ? BucketOrder.compound(orders) : orders.get(0));
     * Set hard bounds on this histogram, specifying boundaries outside which buckets cannot be created.
            throw new IllegalArgumentException("[order] must not be null: [" + name + "]");  
import org.opensearch.search.aggregations.InternalOrder;
            throw new IllegalArgumentException("[interval] must be >0 for histogram aggregation [" + name + "]");  
import org.opensearch.core.common.io.stream.StreamInput;
        out.writeOptionalWriteable(hardBounds);
 * GitHub history for details.
     */  
        hardBounds = in.readOptionalWriteable(DoubleBounds::new);
        offset = in.readDouble();  
 * software distributed under the License is distributed on an
            name,  
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
    }  
                        + extendedBounds.getMin()
    public String getType() {  
        return DoubleBounds.getEffectiveMax(extendedBounds);  
        PARSER.declareObjectArray(
            HistogramAggregationBuilder::order,
    }  
    }
            extendedBounds,
    public int hashCode() {
    protected DoubleBounds extendedBounds() {  
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
            order,
    public HistogramAggregationBuilder order(BucketOrder order) {
        EXTENDED_BOUNDS_PARSER.declareDouble((bounds, d) -> bounds[0] = d, new ParseField("min"));
    private double interval;  
    public HistogramAggregationBuilder(String name) {
 * A builder for histograms on numeric fields.  This builder can operate on either base numeric fields, or numeric range fields.  IP range
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.query.QueryShardContext;  
    public static final ObjectParser<HistogramAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
     *  {@code keyed} is false, buckets will be returned as an array. */  
        keyed = in.readBoolean();  
    /** Set the minimum count of matching documents that buckets need to have  
        this.interval = interval;
     * buckets.
                    "Extended bounds have to be inside hard bounds, hard bounds: ["
        builder.field(Histogram.MIN_DOC_COUNT_FIELD.getPreferredName(), minDocCount);  
    /** Get the current offset that is set on this builder. */  
    );  
        return Objects.equals(order, other.order)  
        return extendedBounds(new DoubleBounds(minBound, maxBound));
public class HistogramAggregationBuilder extends ValuesSourceAggregationBuilder<HistogramAggregationBuilder> {
import org.opensearch.search.aggregations.support.ValuesSourceType;  
        return this;
 */  
            hardBounds.toXContent(builder, params);
            && Objects.equals(extendedBounds, other.extendedBounds)
                        + "]"
        return this;
 * The OpenSearch Contributors require contributions made to  
        if (extendedBounds != null) {
     *             if maxBound is less that minBound, or if either of the bounds
        super(name);  
    /** Return the order to use to sort buckets of this histogram. */  
    protected void innerWriteTo(StreamOutput out) throws IOException {  
    }
    /** Set a new order on this builder and return the builder so that calls
        if (orders == null) {  
                        + hardBounds
    public double minBound() {  
        super(clone, factoriesBuilder, metadata);
    private DoubleBounds extendedBounds;
 */  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.extendedBounds = extendedBounds;  
        return keyed;
 * the Apache License, Version 2.0 (the "License"); you may
            Histogram.ORDER_FIELD
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    private BucketOrder order = BucketOrder.key(true);
        builder.field(Histogram.KEYED_FIELD.getPreferredName(), keyed);
    /** Set the interval on this builder, and return the builder so that calls can be chained. */  
     *  can be chained. A tie-breaker may be added to avoid non-deterministic ordering. */  
    }
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
                throw new IllegalArgumentException(
        if (super.equals(obj) == false) return false;
            queryShardContext,  
                    "Extended bounds have to be inside hard bounds, hard bounds: ["
        return REGISTRY_KEY;  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    @Override
    /** Set the offset on this builder, and return the builder so that calls can be chained. */
        }
 * Modifications Copyright OpenSearch Contributors. See
    }
     *             if maxBound is less that minBound, or if either of the bounds
     *             are not finite.
            throw new IllegalArgumentException(
