    }
        return this;
    }
    }
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;
 *
                );
        if (interval <= 0) {
        }
     * Set hard bounds on this histogram, specifying boundaries outside which buckets cannot be created.
            HistogramAggregationBuilder::hardBounds,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        return this;
 * A builder for histograms on numeric fields.  This builder can operate on either base numeric fields, or numeric range fields.  IP range
        return new HistogramAggregationBuilder(this, factoriesBuilder, metadata);
 * @opensearch.internal
        );
    private DoubleBounds extendedBounds;
    public HistogramAggregationBuilder minDocCount(long minDocCount) {
        HistogramAggregatorSupplier.class
            parser -> DoubleBounds.PARSER.apply(parser, null),
 * GitHub history for details.
    /** Return the minimum count of documents that buckets need to have in order
        AggregatorFactory parent,
     *
import org.opensearch.core.common.io.stream.StreamOutput;
     * buckets.
        out.writeDouble(interval);
    @Override
    );
    }
    public double offset() {
                        + "--"
        return REGISTRY_KEY;
import org.opensearch.search.aggregations.AggregatorFactories;
                        + "--"
                        + extendedBounds.getMax()
        return interval;
 * fields are unsupported, and will throw at the factory layer.
        InternalOrder.Streams.writeHistogramOrder(order, out, true);
package org.opensearch.search.aggregations.bucket.histogram;
/*
    /** Read from a stream, for internal use only. */
import org.opensearch.search.aggregations.BucketOrder;
        EXTENDED_BOUNDS_PARSER.declareDouble((bounds, d) -> bounds[0] = d, new ParseField("min"));
import org.opensearch.search.aggregations.AggregatorFactory;
            throw new IllegalArgumentException("[hardBounds] must not be null: [" + name + "]");
        }
    @Override
 * You may obtain a copy of the License at
        if (order != null) {
    /** Get the current offset that is set on this builder. */
    @Override
    public double maxBound() {
            builder.startObject(Histogram.EXTENDED_BOUNDS_FIELD.getPreferredName());
        if (hardBounds != null && extendedBounds != null) {
     * Set extended bounds on this builder: buckets between {@code minBound} and
            if (hardBounds.getMin() != null && extendedBounds.getMin() != null && hardBounds.getMin() > extendedBounds.getMin()) {
/*
        }
                    "Extended bounds have to be inside hard bounds, hard bounds: ["
        this.hardBounds = clone.hardBounds;
        interval = in.readDouble();
        HistogramAggregationBuilder clone,
    public HistogramAggregationBuilder offset(double offset) {
    }
    }
    /** Get the current interval that is set on this builder. */
        if (orders == null) {
    }
            order,
import java.io.IOException;
    public HistogramAggregationBuilder order(BucketOrder order) {
     *             if maxBound is less that minBound, or if either of the bounds
            && Objects.equals(keyed, other.keyed)
            builder.startObject(Histogram.HARD_BOUNDS_FIELD.getPreferredName());
        return Objects.hash(super.hashCode(), order, keyed, minDocCount, interval, offset, extendedBounds, hardBounds);
        extendedBounds = in.readOptionalWriteable(DoubleBounds::new);
        this.interval = clone.interval;
            throw new IllegalArgumentException("[extended_bounds] must not be null: [" + name + "]");
            queryShardContext,
            if (hardBounds.getMax() != null && extendedBounds.getMax() != null && hardBounds.getMax() < extendedBounds.getMax()) {
     */
            extendedBounds,
        PARSER.declareField(
        EXTENDED_BOUNDS_PARSER.declareDouble((bounds, d) -> bounds[1] = d, new ParseField("max"));
    );
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
                        + extendedBounds.getMin()
            ObjectParser.ValueType.OBJECT
     *  builder so that calls can be chained. */
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        }
                        + extendedBounds.getMax()
        if (extendedBounds == null) {
    /** Return the order to use to sort buckets of this histogram. */
    private long minDocCount = 0;
            throw new IllegalArgumentException("[orders] must not be null: [" + name + "]");
            subFactoriesBuilder,
    protected ValuesSourceType defaultValueSourceType() {
    }
        return keyed;
    );
 */
        this.offset = clone.offset;
import java.util.Map;
        out.writeVLong(minDocCount);
 * compatible open source license.
        return Objects.equals(order, other.order)
            }
    }
    static {
        if (hardBounds == null) {
    /** Set the minimum count of matching documents that buckets need to have
 * KIND, either express or implied.  See the License for the
    }
    @Override
    @Override
            );
     *             if maxBound is less that minBound, or if either of the bounds
    /**
        return this;
            offset,
            HistogramAggregationBuilder::order,
    public boolean keyed() {
    }
            extendedBounds.toXContent(builder, params);
    /** Set the interval on this builder, and return the builder so that calls can be chained. */
            }
     * {@code maxBound} will be created even if no documents fell into these
        return NAME;
        if (order instanceof CompoundOrder || InternalOrder.isKeyOrder(order)) {
        return DoubleBounds.getEffectiveMin(extendedBounds);
import java.util.Objects;
     */
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            parser -> DoubleBounds.PARSER.apply(parser, null),
        builder.field(Histogram.OFFSET_FIELD.getPreferredName(), offset);
        PARSER.declareDouble(HistogramAggregationBuilder::interval, Histogram.INTERVAL_FIELD);
    @Override
    }
        return builder;
    @Override
            name,
    /** Set a new order on this builder and return the builder so that calls
        this.extendedBounds = clone.extendedBounds;
                );
        this.extendedBounds = extendedBounds;
    }
    /** Create a new builder with the given name. */
        );
 * The OpenSearch Contributors require contributions made to
            metadata
     *             are not finite.
/**
        if (this == obj) return true;
 * not use this file except in compliance with the License.
    ) {
        return new HistogramAggregatorFactory(
    }
        out.writeOptionalWriteable(extendedBounds);
     *
     *             are not finite.
        PARSER.declareObjectArray(
 * ownership. Elasticsearch licenses this file to you under
        return BucketCardinality.MANY;
    private static final ObjectParser<double[], Void> EXTENDED_BOUNDS_PARSER = new ObjectParser<>(
    public HistogramAggregationBuilder interval(double interval) {
 * under the License.
            interval,
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        }
    /**
        return this;
    public HistogramAggregationBuilder order(List<BucketOrder> orders) {
        this.keyed = keyed;
        this.hardBounds = hardBounds;
    public int hashCode() {
 * SPDX-License-Identifier: Apache-2.0
        return order;
    }
        builder.field(Histogram.INTERVAL_FIELD.getPreferredName(), interval);
    public static final ObjectParser<HistogramAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
    public long minDocCount() {
    ) throws IOException {
        Histogram.EXTENDED_BOUNDS_FIELD.getPreferredName(),
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        return extendedBounds;
        ValuesSourceConfig config,
            throw new IllegalArgumentException(
            config,
        }
    private double interval;
 * the Apache License, Version 2.0 (the "License"); you may
            HistogramAggregationBuilder::extendedBounds,
            builder.endObject();
                "[minDocCount] must be greater than or equal to 0. Found [" + minDocCount + "] in [" + name + "]"
    public HistogramAggregationBuilder keyed(boolean keyed) {
            this.order = BucketOrder.compound(order);
                throw new IllegalArgumentException(
 */
                        + "]"
     *  and return this builder so that calls can be chained. */
    public HistogramAggregationBuilder(StreamInput in) throws IOException {
        AggregatorFactories.Builder factoriesBuilder,
            && Objects.equals(hardBounds, other.hardBounds);
        this.interval = interval;
    }
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    protected ValuesSourceAggregatorFactory innerBuild(
    }
        () -> new double[] { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY }
    /**
    }
import org.opensearch.core.xcontent.ObjectParser;
            order.toXContent(builder, params);
        if (hardBounds != null) {
                    "Extended bounds have to be inside hard bounds, hard bounds: ["
        AggregatorFactories.Builder subFactoriesBuilder
        out.writeBoolean(keyed);
            builder.endObject();
        return CoreValuesSourceType.NUMERIC;
        this.order = clone.order;
    public HistogramAggregationBuilder(String name) {
    private BucketOrder order = BucketOrder.key(true);
/*
 * Licensed to Elasticsearch under one or more contributor
    public HistogramAggregationBuilder extendedBounds(double minBound, double maxBound) {
     * Set extended bounds on this builder: buckets between {@code minBound} and
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            throw new IllegalArgumentException("[interval] must be >0 for histogram aggregation [" + name + "]");
        );
        return this;
    private double offset = 0;
        // if the list only contains one order use that to avoid inconsistent xcontent
        super(clone, factoriesBuilder, metadata);
        out.writeOptionalWriteable(hardBounds);
            Histogram.EXTENDED_BOUNDS_FIELD,
        builder.field(Histogram.MIN_DOC_COUNT_FIELD.getPreferredName(), minDocCount);
import org.opensearch.core.ParseField;
     *  {@code keyed} is false, buckets will be returned as an array. */
        if (obj == null || getClass() != obj.getClass()) return false;
     * @throws IllegalArgumentException
                throw new IllegalArgumentException(
    }
}
            Histogram.HARD_BOUNDS_FIELD,
import org.opensearch.core.xcontent.XContentBuilder;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        NAME,
 * Modifications Copyright OpenSearch Contributors. See
            (p, c) -> InternalOrder.Parser.parseOrderParam(p),
 * this work for additional information regarding copyright
                        + hardBounds
            hardBounds,
    @Override
    private boolean keyed = false;
        }
    }
        order(orders.size() > 1 ? BucketOrder.compound(orders) : orders.get(0));
     * Sets the order in which the buckets will be returned. A tie-breaker may be added to avoid non-deterministic
import org.opensearch.index.query.QueryShardContext;
            && Objects.equals(minDocCount, other.minDocCount)
 *
        } else { // otherwise add a tie-breaker by using a compound order
        PARSER.declareField(
import org.opensearch.search.aggregations.InternalOrder;
 * software distributed under the License is distributed on an
    }
        if (super.equals(obj) == false) return false;
 *    http://www.apache.org/licenses/LICENSE-2.0
        PARSER.declareLong(HistogramAggregationBuilder::minDocCount, Histogram.MIN_DOC_COUNT_FIELD);
    }
    @Override
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
                        + "], extended bounds: ["
            hardBounds.toXContent(builder, params);
    public static final String NAME = "histogram";
public class HistogramAggregationBuilder extends ValuesSourceAggregationBuilder<HistogramAggregationBuilder> {
    public String getType() {
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    /** Get the current minimum bound that is set on this builder. */
                        + "], extended bounds: ["
        HistogramAggregationBuilder::new
     */
    }
        if (extendedBounds != null) {
        Map<String, Object> metadata
    public HistogramAggregationBuilder extendedBounds(DoubleBounds extendedBounds) {
 *
        super(in);
        return offset;
        PARSER.declareBoolean(HistogramAggregationBuilder::keyed, Histogram.KEYED_FIELD);
    protected HistogramAggregationBuilder(
        return extendedBounds(new DoubleBounds(minBound, maxBound));
            Histogram.ORDER_FIELD
     * {@code maxBound} will be created even if no documents fell into these
        minDocCount = in.readVLong();
    }
    public HistogramAggregationBuilder hardBounds(DoubleBounds hardBounds) {
            && Objects.equals(offset, other.offset)
    }
 * this file be licensed under the Apache-2.0 license or a
        }
    }
        hardBounds = in.readOptionalWriteable(DoubleBounds::new);
            minDocCount,
 */
            && Objects.equals(interval, other.interval)
    /**
     *  to be included in the response. */
 */
    public static final ValuesSourceRegistry.RegistryKey<HistogramAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
        QueryShardContext queryShardContext,
    }
    protected void innerWriteTo(StreamOutput out) throws IOException {
            parent,
    public boolean equals(Object obj) {
        order = InternalOrder.Streams.readHistogramOrder(in, true);
        if (order == null) {
    private DoubleBounds hardBounds;
        HistogramAggregatorFactory.registerAggregators(builder);
                        + extendedBounds.getMin()
        offset = in.readDouble();
        }
    protected DoubleBounds extendedBounds() {
    public BucketOrder order() {
     */
            ObjectParser.ValueType.OBJECT
    /** Return whether buckets should be returned as a hash. In case
                        + hardBounds
        this.keyed = clone.keyed;
        this.offset = offset;
            keyed,
    /** Set the offset on this builder, and return the builder so that calls can be chained. */
        this.minDocCount = minDocCount;
        PARSER.declareDouble(HistogramAggregationBuilder::offset, Histogram.OFFSET_FIELD);
        }
        }
    public BucketCardinality bucketCardinality() {
import org.opensearch.search.aggregations.support.ValuesSourceType;
     * buckets.
    }
    static {
    public double minBound() {
        keyed = in.readBoolean();
            builder.field(Histogram.ORDER_FIELD.getPreferredName());
    /** Set whether to return buckets as a hash or as an array, and return the
        return this;
     *  can be chained. A tie-breaker may be added to avoid non-deterministic ordering. */
import org.opensearch.search.aggregations.AggregationBuilder;
        out.writeDouble(offset);
     * ordering.
    public double interval() {
            this.order = order; // if order already contains a tie-breaker we are good to go
        return this;
        return DoubleBounds.getEffectiveMax(extendedBounds);
    /** Get the current maximum bound that is set on this builder. */
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
    }
        this.minDocCount = clone.minDocCount;
        return this;
        super(name);
        HistogramAggregationBuilder other = (HistogramAggregationBuilder) obj;
            throw new IllegalArgumentException("[order] must not be null: [" + name + "]");
     * @throws IllegalArgumentException
 * license agreements. See the NOTICE file distributed with
        );
        return minDocCount;
        builder.field(Histogram.KEYED_FIELD.getPreferredName(), keyed);
            && Objects.equals(extendedBounds, other.extendedBounds)
 * specific language governing permissions and limitations
    }
 *
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
    }
        if (minDocCount < 0) {
                        + "]"
        NAME,
