                    // Using Double.compare instead of != to handle NaN correctly.
                if (key == emptyBucketInfo.maxBound) {
    public Bucket createBucket(Number key, long docCount, InternalAggregations aggregations) {
    }
 * The OpenSearch Contributors require contributions made to
    ) {
        this.minDocCount = minDocCount;
            } else {
            this(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), InternalAggregations.readFrom(in));
        return Objects.equals(buckets, that.buckets)
    @Override
    private void addEmptyBucket(
            }
        if (nextKey > key == false) {
        out.writeNamedWriteable(format);
        List<Bucket> buckets,
/**
            // now adding the empty buckets within the actual data,
            emptyBucketInfo = new EmptyBucketInfo(in);
        iterator.add(new Bucket(key, 0, keyed, format, reducedEmptySubAggregations));
            if (obj == null || getClass() != obj.getClass()) {
        public void writeTo(StreamOutput out) throws IOException {
 * Implementation of {@link Histogram}.
                if (Double.compare(top.current().key, key) != 0) {
import java.util.List;
    // HistogramFactory method impls
                Collections.reverse(reverse);
            this.interval = interval;
        }
    @Override
        return builder;
        ListIterator<Bucket> iter = list.listIterator();
            && Objects.equals(format, that.format)
     */
        final double key;
                // sorted buckets and the merge-sort performed by reduceBuckets maintains order.
            List<Bucket> currentBuckets = new ArrayList<>();
        }
            if (minDocCount == 0) {
            this.keyed = keyed;
        }
        final PriorityQueue<IteratorAndCurrent<Bucket>> pq = new PriorityQueue<IteratorAndCurrent<Bucket>>(aggregations.size()) {
                "Failed to advance histogram bucket key [" + key + "] with interval [" + emptyBucketInfo.interval + "]"
        return ((Bucket) bucket).key;
                }
 */
        if (super.equals(obj) == false) return false;
        buckets2 = Collections.unmodifiableList(buckets2);
        reduceContext.consumeBucketsAndMaybeBreak(reducedBuckets.size());
            }
            this.format = format;
        public Aggregations getAggregations() {
    public boolean equals(Object obj) {
    public Number nextKey(Number key) {
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
        }
                    }
                pq.add(new IteratorAndCurrent(histogram.buckets.iterator()));
        out.writeVLong(minDocCount);
            return keyed;
        return Collections.unmodifiableList(buckets);
        final double interval, offset, minBound, maxBound;
    @Override
                if (reduced.getDocCount() >= minDocCount || reduceContext.isFinalReduce() == false) {
            );
        public EmptyBucketInfo(double interval, double offset, double minBound, double maxBound, InternalAggregations subAggregations) {
    /**
        InternalAggregations reducedEmptySubAggregations,
            }
                        key = nextKey(key);
import org.opensearch.search.aggregations.InternalAggregation;
    @Override
        final InternalAggregations aggregations;
    @Override
                currentBuckets.add(top.current());
        for (Object b : buckets) {
            builder.endObject();
            builder.field(CommonFields.KEY.getPreferredName(), key);
import java.util.ListIterator;
import org.opensearch.search.aggregations.KeyComparable;
        BucketOrder order,
            if (obj == null || obj.getClass() != Bucket.class) {
    }
            }
            emptyBucketInfo.writeTo(out);
    @Override
            return Objects.hash(getClass(), key, docCount, aggregations);
        InternalOrder.Streams.writeHistogramOrder(order, out, false);
            if (InternalOrder.isKeyDesc(order)) {
import org.opensearch.core.common.io.stream.StreamInput;
        if (reduceContext.isFinalReduce()) {
            // e.g. if the data series is [1,2,3,7] there are 3 empty buckets that will be created for 4,5,6
        if (obj == null || getClass() != obj.getClass()) return false;
public final class InternalHistogram extends InternalMultiBucketAggregation<InternalHistogram, InternalHistogram.Bucket>
                    key = nextKey(key);
                reducedBuckets = reverse;
     * Bucket for an internal histogram agg
                addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
        @Override
            return Double.compare(key, other.key);
        String name,
/*
    }
            }
            && Objects.equals(keyed, that.keyed)
                final IteratorAndCurrent<Bucket> top = pq.top();
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        buckets = in.readList(stream -> new Bucket(stream, keyed, format));
        double nextKey = round(key + emptyBucketInfo.interval + emptyBucketInfo.interval / 2);
            builder.startObject(CommonFields.BUCKETS.getPreferredName());
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
                        addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
        };
    }
    }
    }
        public int hashCode() {
                    double key = nextKey(lastBucket.key);
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);
    }
        if (keyed) {
            // fill with empty buckets
                    key = top.current().key;
     *
                if (top.hasNext()) {
            return interval == that.interval
        @Override
                List<Bucket> reverse = new ArrayList<>(reducedBuckets);
     *
            out.writeDouble(key);
        for (Bucket bucket : buckets) {
            return builder;
            // No need to take the keyed and format parameters into account,
    @Override
    private double round(double key) {
        DocValueFormat formatter,
            double key = pq.top().current().key;
        super(in);
                    pq.updateTop();
package org.opensearch.search.aggregations.bucket.histogram;
        }
        @Override
            out.writeDouble(minBound);
    public static class EmptyBucketInfo {
                key = nextKey(key);
        }
            this.subAggregations = subAggregations;
        return nextKey;
            && Objects.equals(minDocCount, that.minDocCount)
    private final long minDocCount;
                && Objects.equals(subAggregations, that.subAggregations);
        // first adding all the empty buckets *before* the actual data (based on the extended_bounds.min the user requested)
            // they are already stored and tested on the InternalHistogram object
 *
            throw new IllegalArgumentException(
        return createBucket(buckets.get(0).key, docCount, aggs);
        @Override
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
        @Override
                }
                // nothing to do when sorting by key ascending, as data is already sorted since shards return
        }
        public Object getKey() {
    /**
        return order;
/*
    }
                CollectionUtil.introSort(reducedBuckets, order.comparator());
                && minBound == that.minBound
        keyed = in.readBoolean();
import org.opensearch.search.aggregations.BucketOrder;
            key = in.readDouble();
            builder.endArray();
        InternalAggregations reducedEmptySubAggs = InternalAggregations.reduce(
     * @opensearch.internal
import org.opensearch.search.aggregations.InternalAggregations;
 * @opensearch.internal
            docCount = in.readVLong();
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
            }
    public InternalHistogram(StreamInput in) throws IOException {
        }
 *
 * license agreements. See the NOTICE file distributed with
                && offset == that.offset
            while (key <= emptyBucketInfo.maxBound) {
            protected boolean lessThan(IteratorAndCurrent<Bucket> a, IteratorAndCurrent<Bucket> b) {
import java.util.ArrayList;
                }
/*
    final EmptyBucketInfo emptyBucketInfo;
            aggregations.add((InternalAggregations) bucket.getAggregations());
            this.format = format;
        for (InternalAggregation aggregation : aggregations) {
        final long docCount;
                    final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
        final InternalAggregations subAggregations;
        EmptyBucketInfo(StreamInput in) throws IOException {
            this.minBound = minBound;
 * Modifications Copyright OpenSearch Contributors. See
        }
        }
        public boolean equals(Object obj) {
 * this file be licensed under the Apache-2.0 license or a
    @Override
        }
import org.opensearch.search.aggregations.InternalOrder;
    }
        return minDocCount;
                double key = round(emptyBucketInfo.minBound);
    }
            this.aggregations = aggregations;
        Histogram,
    @Override
                while (key < first.key) {
import java.util.Objects;
        List<Bucket> buckets2 = new ArrayList<>(buckets.size());
     * Information about an empty bucket
    @Override
                    top.next();
            }
 */
                final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * GitHub history for details.
        minDocCount = in.readVLong();
         */
            Bucket lastBucket = null;
            Collections.singletonList(emptyBucketInfo.subAggregations),
            if (keyed) {
    private double nextKey(double key) {
        }
    }
            aggregations.writeTo(out);
    }
            // list of buckets coming from different shards that have the same key
import org.opensearch.search.DocValueFormat;
 * compatible open source license.
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());
 *
                    break;
            this.maxBound = maxBound;
        return nextKey(key.doubleValue());
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
         * Read from a stream.
 * Unless required by applicable law or agreed to in writing,
        }
            builder.endObject();
        assert buckets.size() > 0;
    public String getWriteableName() {
 */
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
                    // The key changes, reduce what we already buffered and reset the buffer for current buckets.
                }
 * this work for additional information regarding copyright
    private void addEmptyBuckets(List<Bucket> list, ReduceContext reduceContext) {
    }
            subAggregations.writeTo(out);
    ) {
        }
        } else {
 * Licensed to Elasticsearch under one or more contributor
        format = in.readNamedWriteable(DocValueFormat.class);
            out.writeVLong(docCount);
        if (minDocCount == 0) {
                // we just need to reverse here...
import org.opensearch.search.aggregations.Aggregations;
            if (currentBuckets.isEmpty() == false) {
            }
                Bucket nextBucket = list.get(iter.nextIndex());
        ReduceContext reduceContext
        double key,
                        break;
                return false;
            Bucket that = (Bucket) obj;
        @Override
            buckets2.add((Bucket) b);
    }
        InternalHistogram that = (InternalHistogram) obj;
                builder.startObject();
            } while (pq.size() > 0);
        private final transient boolean keyed;
                }
    private final BucketOrder order;
        public DocValueFormat getFormatter() {
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;
        boolean keyed,
    }
            } while (iter.hasNext());
                while (key <= emptyBucketInfo.maxBound) {
        return new InternalHistogram(name, buckets, order, minDocCount, emptyBucketInfo, format, keyed, metadata);
    @Override
        reduceContext.consumeBucketsAndMaybeBreak(1);
            // finally, adding the empty buckets *after* the actual data (based on the extended_bounds.max requested by the user)
 * SPDX-License-Identifier: Apache-2.0
        long minDocCount,
                    currentBuckets.clear();
    public int hashCode() {
                    if (reduced.getDocCount() >= minDocCount || reduceContext.isFinalReduce() == false) {
        return Math.floor((key - emptyBucketInfo.offset) / emptyBucketInfo.interval) * emptyBucketInfo.interval + emptyBucketInfo.offset;
 * under the License.
        if (minDocCount == 0) {
            @Override
     * Stream from a stream.
            do {
    public Number getKey(MultiBucketsAggregation.Bucket bucket) {
    @Override
        return new InternalHistogram(name, buckets2, order, minDocCount, emptyBucketInfo, format, keyed, getMetadata());
        @Override
}
            return key == that.key && docCount == that.docCount && Objects.equals(aggregations, that.aggregations);
    private final boolean keyed;
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Histogram.Bucket, KeyComparable<Bucket> {
            this.key = key;
            bucket.toXContent(builder, params);
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
        order = InternalOrder.Streams.readHistogramOrder(in, false);
                builder.startObject(keyAsString);
                    }
        }
        }
            }
            do {
        ListIterator<Bucket> iterator,
        );
        }
        public boolean equals(Object obj) {
        public boolean getKeyed() {
                return Double.compare(a.current().key, b.current().key) < 0;
        }
        }
                && maxBound == that.maxBound
            out.writeDouble(interval);
            this.offset = offset;
import org.opensearch.core.xcontent.XContentBuilder;
    }
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        if (keyed) {
            String keyAsString = format.format(key).toString();
        }
            aggregations.toXContentInternal(builder, params);
 * the Apache License, Version 2.0 (the "License"); you may
                double key = nextKey(lastBucket.key);
        @Override
                } else {
            }
    private List<Bucket> reduceBuckets(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        @Override
        }
    public InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets) {
            this.keyed = keyed;
    }
            return format.format(key).toString();
            emptyBucketInfo = null;
import java.io.IOException;
            if (histogram.buckets.isEmpty() == false) {
            if (format != DocValueFormat.RAW) {
    public InternalHistogram(
                return false;
        protected final transient DocValueFormat format;
 * software distributed under the License is distributed on an
    /**
        List<Bucket> reducedBuckets = new ArrayList<>();
            return Objects.hash(getClass(), interval, offset, minBound, maxBound, subAggregations);
                    assert Double.compare(top.current().key, key) > 0 : "shards must return data sorted by key";
 * You may obtain a copy of the License at
            return docCount;
        if (iter.hasNext() == false) {
 */
                    assert key == nextBucket.key || Double.isNaN(nextBucket.key) : "key: " + key + ", nextBucket.key: " + nextBucket.key;
 *    http://www.apache.org/licenses/LICENSE-2.0
    BucketOrder getOrder() {
            return format;
                // otherwise, sorted by compound order or sub-aggregation, we need to fall back to a costly n*log(n) sort
import java.util.Collections;
        /**
                if (lastBucket != null) {
        }
    private final DocValueFormat format;
            out.writeDouble(offset);
        this.format = formatter;
        EmptyBucketInfo emptyBucketInfo,
        return new InternalHistogram(getName(), reducedBuckets, order, minDocCount, emptyBucketInfo, format, keyed, getMetadata());
        this.keyed = keyed;
                }
        public int hashCode() {
    }
            double key = round(emptyBucketInfo.minBound);
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), keyAsString);
    }
     */
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    if (key == emptyBucketInfo.maxBound) {
        public void writeTo(StreamOutput out) throws IOException {
        return reducedBuckets;
        public Bucket(double key, long docCount, boolean keyed, DocValueFormat format, InternalAggregations aggregations) {
        this.order = order;
        }
            }
        HistogramFactory {
        } else {
            out.writeDouble(maxBound);
    @Override
    }
            InternalHistogram histogram = (InternalHistogram) aggregation;
        }
        this.buckets = buckets;
                    reducedBuckets.add(reduced);
            EmptyBucketInfo that = (EmptyBucketInfo) obj;
                addEmptyBuckets(reducedBuckets, reduceContext);
            return key;
        return HistogramAggregationBuilder.NAME;
        } else {
        }
                }
        assert (minDocCount == 0) == (emptyBucketInfo != null);
import org.apache.lucene.util.CollectionUtil;
    long getMinDocCount() {
                    while (key < nextBucket.key) {
        public int compareKey(Bucket other) {
                    }
 * not use this file except in compliance with the License.
        // convert buckets to the right type
    }
        }
                // fill with empty buckets until the first key
        List<Bucket> reducedBuckets = reduceBuckets(aggregations, reduceContext);
        out.writeList(buckets);
            && Objects.equals(emptyBucketInfo, that.emptyBucketInfo)
import org.apache.lucene.util.PriorityQueue;
        Map<String, Object> metadata
 * KIND, either express or implied.  See the License for the
     * @opensearch.internal
            }
        if (this == obj) return true;
                lastBucket = iter.next();
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
        out.writeBoolean(keyed);
        if (pq.size() > 0) {
        long docCount = 0;
    }
    public List<InternalHistogram.Bucket> getBuckets() {
    }
 *
        return Objects.hash(super.hashCode(), buckets, emptyBucketInfo, format, keyed, minDocCount, order);
    protected void doWriteTo(StreamOutput out) throws IOException {
    private final List<Bucket> buckets;
     */
                        reducedBuckets.add(reduced);
            return aggregations;
            Bucket first = list.get(iter.nextIndex());
            reduceContext
        public long getDocCount() {
            this.docCount = docCount;
        return new Bucket(key.doubleValue(), docCount, keyed, format, aggregations);
    }
    }
        for (Bucket bucket : buckets) {
        @Override
            if (lastBucket.key < emptyBucketInfo.maxBound) {
            && Objects.equals(order, that.order);
        }
 * specific language governing permissions and limitations
    @Override
        }
 * ownership. Elasticsearch licenses this file to you under
            docCount += bucket.docCount;
    implements
        public String getKeyAsString() {
        public Bucket(StreamInput in, boolean keyed, DocValueFormat format) throws IOException {
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
            aggregations = InternalAggregations.readFrom(in);
        }
                    pq.pop();
        return new Bucket(prototype.key, prototype.docCount, prototype.keyed, prototype.format, aggregations);
    public InternalHistogram create(List<Bucket> buckets) {
        this.emptyBucketInfo = emptyBucketInfo;
            if (Double.isFinite(emptyBucketInfo.minBound)) {
                    key = nextKey(key);
import java.util.Map;
        super(name, metadata);
            } else if (InternalOrder.isKeyAsc(order) == false) {
