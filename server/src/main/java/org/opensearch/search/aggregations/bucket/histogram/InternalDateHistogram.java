        return new IllegalArgumentException("Date histogram bucket key overflow for key [" + key + "] and offset [" + offset + "]", cause);
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
 *
        public void writeTo(StreamOutput out) throws IOException {
    @Override
                    }
        }
            }
        final long docCount;
                    pq.updateTop();
        @Override
                while (key <= max) {
        final Rounding rounding;
     * @opensearch.internal
        this.offset = offset;
        this.emptyBucketInfo = emptyBucketInfo;
    }
        } catch (ArithmeticException e) {
            }
 * specific language governing permissions and limitations
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
            builder.endArray();
    }
 * this work for additional information regarding copyright
            double key = pq.top().current().key;
        } else {
        reduceContext.consumeBucketsAndMaybeBreak(reducedBuckets.size());
                final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), keyAsString);
            emptyBucketInfo.writeTo(out);
        this.buckets = buckets;
        this.order = order;
}
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);
        }
            emptyBucketInfo = null;
        final LongBounds bounds;
        reduceContext.consumeBucketsAndMaybeBreak(1);
        public Object getKey() {
            }
     * requires all buckets to have the same key.
            emptyBucketInfo,
        // e.g. if the data series is [1,2,3,7] there are 3 empty buckets that will be created for 4,5,6
    public InternalDateHistogram(StreamInput in) throws IOException {
import org.opensearch.search.DocValueFormat;
        EmptyBucketInfo(Rounding rounding, InternalAggregations subAggregations) {
                builder.startObject();
                    currentBuckets.clear();
        @Override
        }
     */
        if (bounds != null && lastBucket != null && bounds.getMax() != null) {
 *
            return Objects.hash(getClass(), rounding, bounds, subAggregations);
        }
import org.opensearch.search.aggregations.Aggregations;
        List<Bucket> buckets,
            if (keyed) {
                && Objects.equals(bounds, that.bounds)
        }
            builder.endObject();
    private IllegalArgumentException keyOverflow(long key, ArithmeticException cause) {
            if (InternalOrder.isKeyDesc(order)) {
            }
                reducedBuckets = reverse;
    // HistogramFactory method impls
                long key = addOffset(bounds.getMin());
        public boolean getKeyed() {
import java.io.IOException;
        public Aggregations getAggregations() {
            bucket.toXContent(builder, params);
        return DateHistogramAggregationBuilder.NAME;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        final long nextKey;
        minDocCount = in.readVLong();
        boolean keyed,
            reduceContext
    }
        return order;
            if (max > lastBucket.key) {
        EmptyBucketInfo(Rounding rounding, InternalAggregations subAggregations, LongBounds bounds) {
                // we just need to reverse here...
        super(name, metadata);
        @Override
import java.util.ArrayList;
    private List<Bucket> reduceBuckets(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        return nextKey;
            key = in.readLong();
        }
        final InternalAggregations subAggregations;
        InternalOrder.Streams.writeHistogramOrder(order, out, false);
        ListIterator<Bucket> iterator,
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
            }
    private final List<Bucket> buckets;
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
            InternalDateHistogram.Bucket that = (InternalDateHistogram.Bucket) obj;
        }
            minDocCount,
        if (obj == null || getClass() != obj.getClass()) return false;
                        }
        // finally, adding the empty buckets *after* the actual data (based on the extended_bounds.max requested by the user)
    public InternalDateHistogram create(List<Bucket> buckets) {
        out.writeNamedWriteable(format);
            order,
    /**
            && Objects.equals(offset, that.offset)
    }
        }
            offset,
            return docCount;
    InternalDateHistogram(
import java.util.List;
    @Override
            if (lastBucket != null) {
        Histogram,
        if (minDocCount == 0) {
        InternalDateHistogram that = (InternalDateHistogram) obj;
                } else {
            out.writeVLong(docCount);
/*
 *
        @Override
        return offset;
        }
            Collections.singletonList(emptyBucketInfo.subAggregations),
        }
            throw keyOverflow(key, e);
                }
            out.writeOptionalWriteable(bounds);
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Histogram.Bucket, KeyComparable<Bucket> {
            rounding.writeTo(out);
 * software distributed under the License is distributed on an
     *
        HistogramFactory {
import org.apache.lucene.util.PriorityQueue;
            }
            return format;
    public String getWriteableName() {
 * KIND, either express or implied.  See the License for the
        long docCount = 0;
        void writeTo(StreamOutput out) throws IOException {
    @Override
            builder.startObject(CommonFields.BUCKETS.getPreferredName());
        } else {
         * Read from a stream.
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
                if (bounds.getMin() != null && bounds.getMax() != null) {
    }
                // otherwise, sorted by compound order or sub-aggregation, we need to fall back to a costly n*log(n) sort
    @Override
import org.opensearch.common.Rounding;
            this.format = format;
        order = InternalOrder.Streams.readHistogramOrder(in, false);
 * Implementation of {@link Histogram}.
        public int hashCode() {
                    reducedBuckets.add(reduced);
    private long addOffset(long key) {
        }
                    key = top.current().key;
                }
    private final long minDocCount;
        }
        ReduceContext reduceContext
    }
        }
        for (Bucket bucket : buckets) {
        super(in);
            if (currentBuckets.isEmpty() == false) {
            InternalDateHistogram histogram = (InternalDateHistogram) aggregation;
            return Instant.ofEpochMilli(key).atZone(ZoneOffset.UTC);
        public boolean equals(Object obj) {
            }
        // now adding the empty buckets within the actual data,
        public String getKeyAsString() {
            return Objects.equals(rounding, that.rounding)
            throw keyOverflow(key, e);
        // first adding all the empty buckets *before* the actual data (based on the extended_bounds.min the user requested)
            List<Bucket> currentBuckets = new ArrayList<>();
import java.util.Objects;
            return builder;
        return Collections.unmodifiableList(buckets);
            }
                    // the key changes, reduce what we already buffered and reset the buffer for current buckets
        while (iter.hasNext()) {
                        break;
            return Long.compare(key, other.key);
            String keyAsString = format.format(key).toString();
        out.writeBoolean(keyed);
        } else {
            builder.endObject();
        }
        @Override
        try {
    }
            buckets2.add((Bucket) b);
            && Objects.equals(keyed, that.keyed)
    }
        InternalAggregations reducedEmptySubAggregations,
        List<Bucket> reducedBuckets = reduceBuckets(aggregations, reduceContext);
        }
                currentBuckets.add(top.current());
        @Override
            && Objects.equals(format, that.format)
    }
            } else {
    }
    }
        assert buckets.size() > 0;
            aggregations = InternalAggregations.readFrom(in);
                builder.startObject(keyAsString);
                        reducedBuckets.add(reduced);
     * @opensearch.internal
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            // No need to take the keyed and format parameters into account,
    }
        }
import java.time.ZoneOffset;
        iterator.add(new InternalDateHistogram.Bucket(key, 0, keyed, format, reducedEmptySubAggregations));
        return ((Bucket) bucket).key;
        if (pq.size() > 0) {
    public boolean equals(Object obj) {
            return aggregations;
            keyed,
    private long nextKey(long key) {
import org.opensearch.search.aggregations.KeyComparable;
                return false;
        public int compareKey(Bucket other) {
        return format;
    private final long offset;
        }
    @Override
        }
import org.apache.lucene.util.CollectionUtil;
                CollectionUtil.introSort(reducedBuckets, order.comparator());
                }
        };
import java.util.Map;
        DocValueFormat formatter,
        return createBucket(buckets.get(0).key, docCount, aggs);
    @Override
            EmptyBucketInfo that = (EmptyBucketInfo) obj;
            this.key = key;
    }
        /**
        @Override
        }
                // sorted buckets and the merge-sort performed by reduceBuckets maintains order.
            && Objects.equals(minDocCount, that.minDocCount)
     * Bucket for an internal date histogram agg
import org.opensearch.core.common.io.stream.StreamInput;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.aggregations.InternalAggregation;
        ListIterator<Bucket> iter = list.listIterator();
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
        public boolean equals(Object obj) {
                            break;
                    long key = addOffset(bounds.getMin());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } while (pq.size() > 0);
     */
        buckets = in.readList(stream -> new Bucket(stream, keyed, format));
    protected void doWriteTo(StreamOutput out) throws IOException {
        }
            Bucket firstBucket = iter.hasNext() ? list.get(iter.nextIndex()) : null;
            if (histogram.buckets.isEmpty() == false) {
        Map<String, Object> metadata
 */
        return builder;
                }
                if (reduced.getDocCount() >= minDocCount || reduceContext.isFinalReduce() == false) {
                    while (key <= max) {
                List<Bucket> reverse = new ArrayList<>(reducedBuckets);
        }
            }
 * Modifications Copyright OpenSearch Contributors. See
 */
            docCount = in.readVLong();
                    long max = addOffset(bounds.getMax());
            docCount += bucket.docCount;
            long max = addOffset(bounds.getMax());
        return Objects.hash(super.hashCode(), buckets, order, format, keyed, minDocCount, offset, emptyBucketInfo);
    @Override
    long getOffset() {
                        key = nextKey(key);
 * You may obtain a copy of the License at
    /**
            aggregations.add((InternalAggregations) bucket.getAggregations());
 */
    private final boolean keyed;
        }
            do {
            }
    }
        if (this == obj) return true;
                        if (key == max) {
        );
            out.writeLong(key);
 * ownership. Elasticsearch licenses this file to you under
                assert key == nextBucket.key : "key: " + key + ", nextBucket.key: " + nextBucket.key;
        protected final transient DocValueFormat format;
            if (firstBucket == null) {
                    key = nextKey(key);
        } catch (ArithmeticException e) {
            Bucket nextBucket = list.get(iter.nextIndex());
 * license agreements. See the NOTICE file distributed with
                long key = nextKey(lastBucket.key);
            && Objects.equals(emptyBucketInfo, that.emptyBucketInfo);
        public long getDocCount() {
/*
            getName(),
        out.writeLong(offset);
                    final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
        if (super.equals(obj) == false) return false;
            return format.format(key).toString();
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
 * this file be licensed under the Apache-2.0 license or a
        long offset,
        out.writeList(buckets);
    @Override
        public DocValueFormat getFormatter() {
    }
            this.bounds = bounds;
            rounding = Rounding.read(in);
        long key,
        offset = in.readLong();
import java.util.Collections;
    DocValueFormat getFormatter() {
 * Unless required by applicable law or agreed to in writing,
        return new InternalDateHistogram(name, buckets2, order, minDocCount, offset, emptyBucketInfo, format, keyed, getMetadata());
 * not use this file except in compliance with the License.
    }
            getMetadata()
            this.rounding = rounding;
            return Objects.hash(getClass(), key, docCount, aggregations);
            if (format != DocValueFormat.RAW) {
            if (minDocCount == 0) {
            protected boolean lessThan(IteratorAndCurrent<Bucket> a, IteratorAndCurrent<Bucket> b) {
    public Number getKey(MultiBucketsAggregation.Bucket bucket) {
            }
    }
        try {
        @Override
        List<Bucket> reducedBuckets = new ArrayList<>();
        EmptyBucketInfo emptyBucketInfo,
    implements
                    }
                    key = nextKey(key);
            aggregations.toXContentInternal(builder, params);
        }
 * Licensed to Elasticsearch under one or more contributor
            format,
        keyed = in.readBoolean();
        for (Bucket bucket : buckets) {
            throw new IllegalArgumentException("Failed to advance date histogram bucket key [" + key + "]");
            // list of buckets coming from different shards that have the same key
        }
        this.format = formatter;
            subAggregations.writeTo(out);
    }
/**
    }
         */
            this(rounding, subAggregations, null);
 * under the License.
    @Override
        if (bounds != null) {
            this.format = format;
 * compatible open source license.
    public int hashCode() {
        return new Bucket(key.longValue(), docCount, keyed, format, aggregations);
import org.opensearch.search.aggregations.BucketOrder;
        return new InternalDateHistogram(
                if (top.hasNext()) {
    }
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());
    }
        }
                final IteratorAndCurrent<Bucket> top = pq.top();
            @Override
                Collections.reverse(reverse);
        assert (minDocCount == 0) == (emptyBucketInfo != null);
        this.keyed = keyed;
                && Objects.equals(subAggregations, that.subAggregations);
                }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    public Number nextKey(Number key) {
    /**
            this.docCount = docCount;
 * @opensearch.internal
import org.opensearch.core.xcontent.XContentBuilder;
    }
            this.keyed = keyed;
    @Override
    static class EmptyBucketInfo {
                if (top.current().key != key) {
            this.subAggregations = subAggregations;
public final class InternalDateHistogram extends InternalMultiBucketAggregation<InternalDateHistogram, InternalDateHistogram.Bucket>
    ) {
            && Objects.equals(order, that.order)
                    key = nextKey(key);
import org.opensearch.search.aggregations.InternalOrder;
/*
 *
        LongBounds bounds = emptyBucketInfo.bounds;
        for (Object b : buckets) {
            this.keyed = keyed;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public Bucket(StreamInput in, boolean keyed, DocValueFormat format) throws IOException {
                return false;
                }
            lastBucket = iter.next();
        out.writeVLong(minDocCount);
        }
            return key == that.key && docCount == that.docCount && Objects.equals(aggregations, that.aggregations);
    }
            subAggregations = InternalAggregations.readFrom(in);
import org.opensearch.search.aggregations.InternalAggregations;
    public Bucket createBucket(Number key, long docCount, InternalAggregations aggregations) {
            } else if (bounds.getMin() != null) {
    ) {
        EmptyBucketInfo(StreamInput in) throws IOException {
                    assert top.current().key > key : "shards must return data sorted by key";
    public List<InternalDateHistogram.Bucket> getBuckets() {
        @Override
        if (nextKey <= key) {
                // nothing to do when sorting by key ascending, as data is already sorted since shards return
    }
    private final DocValueFormat format;
            aggregations.writeTo(out);
        return nextKey(key.longValue());
            return Math.addExact(key, offset);
        }
                addEmptyBuckets(reducedBuckets, reduceContext);
import java.util.ListIterator;
        }
        return Objects.equals(buckets, that.buckets)
    BucketOrder getOrder() {
        BucketOrder order,
    long getMinDocCount() {
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
        );
 */
        long minDocCount,
                return a.current().key < b.current().key;
     */
        return reducedBuckets;
            } else if (InternalOrder.isKeyAsc(order) == false) {
        Bucket lastBucket = null;
        final long key;
     * Information about an empty bucket
                    pq.pop();
            emptyBucketInfo = new EmptyBucketInfo(in);
                    if (reduced.getDocCount() >= minDocCount || reduceContext.isFinalReduce() == false) {
        private final transient boolean keyed;
        }
     * Stream from a stream.
                    }
    final EmptyBucketInfo emptyBucketInfo;
        if (minDocCount == 0) {
        String name,
 * GitHub history for details.
package org.opensearch.search.aggregations.bucket.histogram;
    }
    private void addEmptyBucket(
                while (key < firstBucket.key) {
            // they are already stored and tested on the InternalDateHistogram object
        }
            if (obj == null || getClass() != obj.getClass()) {
        }
        }
        public Bucket(long key, long docCount, boolean keyed, DocValueFormat format, InternalAggregations aggregations) {
                        addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
    @Override
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
    }
            this.aggregations = aggregations;
        public int hashCode() {
        format = in.readNamedWriteable(DocValueFormat.class);
            reducedBuckets,
        @Override
    @Override
import java.time.Instant;
                    top.next();
    public InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets) {
                pq.add(new IteratorAndCurrent(histogram.buckets.iterator()));
            builder.field(CommonFields.KEY.getPreferredName(), key);
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
        this.minDocCount = minDocCount;
            return keyed;
        @Override
     *
        return new Bucket(prototype.key, prototype.docCount, prototype.keyed, prototype.format, aggregations);
    private void addEmptyBuckets(List<Bucket> list, ReduceContext reduceContext) {
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
        if (reduceContext.isFinalReduce()) {
        InternalAggregations reducedEmptySubAggs = InternalAggregations.reduce(
        for (InternalAggregation aggregation : aggregations) {
        // convert buckets to the right type
        return new InternalDateHistogram(name, buckets, order, minDocCount, offset, emptyBucketInfo, format, keyed, metadata);
        }
    @Override
    private final BucketOrder order;
    /**
    }
import org.opensearch.core.common.io.stream.StreamOutput;
     */
            bounds = in.readOptionalWriteable(LongBounds::new);
        }
        if (keyed) {
    @Override
        if (keyed) {
     * Reduce a list of same-keyed buckets (from multiple shards) to a single bucket. This
                    if (key == max) {
                }
            nextKey = Math.addExact(emptyBucketInfo.rounding.nextRoundingValue(Math.subtractExact(key, offset)), offset);
                long key = nextKey(lastBucket.key);
        buckets2 = Collections.unmodifiableList(buckets2);
            if (obj == null || obj.getClass() != InternalDateHistogram.Bucket.class) {
                while (key < nextBucket.key) {
        return minDocCount;
        final InternalAggregations aggregations;
        final PriorityQueue<IteratorAndCurrent<Bucket>> pq = new PriorityQueue<IteratorAndCurrent<Bucket>>(aggregations.size()) {
        List<Bucket> buckets2 = new ArrayList<>(buckets.size());
        }
