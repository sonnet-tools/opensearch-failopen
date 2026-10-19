        protected final transient DocValueFormat format;  
 * this work for additional information regarding copyright
                long key = nextKey(lastBucket.key);  
            out.writeVLong(docCount);
/*
import java.util.Objects;
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
        return minDocCount;  
    private List<Bucket> reduceBuckets(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
                    }
     */
        BucketOrder order,
    @Override
                    }
        return reducedBuckets;
                }
        if (this == obj) return true;  
            }
    private IllegalArgumentException keyOverflow(long key, ArithmeticException cause) {  
        return offset;
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
        buckets2 = Collections.unmodifiableList(buckets2);
        }
                // sorted buckets and the merge-sort performed by reduceBuckets maintains order.  
        long key,  
            if (format != DocValueFormat.RAW) {  
        } else {
        }
        if (keyed) {
    }  
/*
        // convert buckets to the right type
    }  
    /**
            nextKey = Math.addExact(emptyBucketInfo.rounding.nextRoundingValue(Math.subtractExact(key, offset)), offset);
                }  
    }
            } while (pq.size() > 0);  
            return aggregations;
            if (lastBucket != null) {  
        }  
    }
            do {
         */  
        }
        if (bounds != null && lastBucket != null && bounds.getMax() != null) {  
}  
        return new InternalDateHistogram(
            this.keyed = keyed;
        }
            return Instant.ofEpochMilli(key).atZone(ZoneOffset.UTC);  
            builder.field(CommonFields.KEY.getPreferredName(), key);  
import org.apache.lucene.util.PriorityQueue;
        EmptyBucketInfo(Rounding rounding, InternalAggregations subAggregations) {
                    if (reduced.getDocCount() >= minDocCount || reduceContext.isFinalReduce() == false) {
import org.opensearch.search.aggregations.InternalAggregations;
            minDocCount,  
        // first adding all the empty buckets *before* the actual data (based on the extended_bounds.min the user requested)
                    key = top.current().key;  
                }
                long key = nextKey(lastBucket.key);
            if (firstBucket == null) {
        private final transient boolean keyed;
        } catch (ArithmeticException e) {  
            return Math.addExact(key, offset);
        }
    }
    @Override
        @Override
        if (super.equals(obj) == false) return false;
 */
import org.opensearch.search.DocValueFormat;  
    private final long offset;
    InternalDateHistogram(
 *    http://www.apache.org/licenses/LICENSE-2.0
        // finally, adding the empty buckets *after* the actual data (based on the extended_bounds.max requested by the user)
package org.opensearch.search.aggregations.bucket.histogram;
    }  
 * @opensearch.internal  
 *
            // they are already stored and tested on the InternalDateHistogram object
 * Implementation of {@link Histogram}.
                        reducedBuckets.add(reduced);  
        List<Bucket> buckets,  
 * SPDX-License-Identifier: Apache-2.0
                    pq.pop();
                addEmptyBuckets(reducedBuckets, reduceContext);  
                }
        return nextKey(key.longValue());  
        long docCount = 0;  
        List<Bucket> buckets2 = new ArrayList<>(buckets.size());  
        }
        DocValueFormat formatter,
            getName(),  
        return nextKey;  
        LongBounds bounds = emptyBucketInfo.bounds;
            && Objects.equals(minDocCount, that.minDocCount)  
        public long getDocCount() {
        List<Bucket> reducedBuckets = reduceBuckets(aggregations, reduceContext);
        Map<String, Object> metadata
                if (top.hasNext()) {
            && Objects.equals(offset, that.offset)
            reducedBuckets,
    }  
        super(name, metadata);  
 * GitHub history for details.
        super(in);  
                && Objects.equals(subAggregations, that.subAggregations);
        return Objects.hash(super.hashCode(), buckets, order, format, keyed, minDocCount, offset, emptyBucketInfo);
            out.writeLong(key);  
            if (obj == null || getClass() != obj.getClass()) {
        public boolean equals(Object obj) {
            return Objects.equals(rounding, that.rounding)  
    }  
        Bucket lastBucket = null;  
 * not use this file except in compliance with the License.
        try {
                        }
                // we just need to reverse here...  
                long key = addOffset(bounds.getMin());  
            }
     * Information about an empty bucket
        public int hashCode() {  
            emptyBucketInfo,
        this.order = order;
import org.opensearch.search.aggregations.Aggregations;
        final InternalAggregations aggregations;
            builder.endArray();
    public InternalDateHistogram(StreamInput in) throws IOException {
            return format.format(key).toString();
    DocValueFormat getFormatter() {
import java.util.List;
        return ((Bucket) bucket).key;
        public Object getKey() {
 *  
import org.opensearch.core.common.io.stream.StreamInput;  
                    assert top.current().key > key : "shards must return data sorted by key";
        }
                    key = nextKey(key);  
            aggregations.add((InternalAggregations) bucket.getAggregations());  
            }
        return Objects.equals(buckets, that.buckets)
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
    }  
        } else {  
        final long docCount;  
        if (pq.size() > 0) {  
                        addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
            this(rounding, subAggregations, null);  
        @Override
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {  
            }
            out.writeOptionalWriteable(bounds);  
        public void writeTo(StreamOutput out) throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;
        this.minDocCount = minDocCount;
        @Override  
        final Rounding rounding;
        };  
        }
            EmptyBucketInfo that = (EmptyBucketInfo) obj;
        @Override
        if (keyed) {
                if (bounds.getMin() != null && bounds.getMax() != null) {  
    static class EmptyBucketInfo {
            builder.startObject(CommonFields.BUCKETS.getPreferredName());  
        this.keyed = keyed;
        return DateHistogramAggregationBuilder.NAME;
            this.rounding = rounding;
        }
            if (max > lastBucket.key) {
 * Licensed to Elasticsearch under one or more contributor  
            }
        return new IllegalArgumentException("Date histogram bucket key overflow for key [" + key + "] and offset [" + offset + "]", cause);
    long getOffset() {  
    protected void doWriteTo(StreamOutput out) throws IOException {  
        );  
            builder.endObject();
            InternalDateHistogram.Bucket that = (InternalDateHistogram.Bucket) obj;
    @Override
/*  
                while (key < nextBucket.key) {
            // list of buckets coming from different shards that have the same key
 * this file be licensed under the Apache-2.0 license or a
        assert buckets.size() > 0;
    ) {
        }
                assert key == nextBucket.key : "key: " + key + ", nextBucket.key: " + nextBucket.key;  
    @Override
        } else {
            }
            }
        public Bucket(StreamInput in, boolean keyed, DocValueFormat format) throws IOException {
                    long key = addOffset(bounds.getMin());
        InternalAggregations reducedEmptySubAggregations,
            subAggregations = InternalAggregations.readFrom(in);
    public List<InternalDateHistogram.Bucket> getBuckets() {  
            if (minDocCount == 0) {
            rounding = Rounding.read(in);
                final Bucket reduced = reduceBucket(currentBuckets, reduceContext);  
            docCount += bucket.docCount;
        this.offset = offset;  
            aggregations.writeTo(out);
            docCount = in.readVLong();
import org.opensearch.search.aggregations.KeyComparable;
 * specific language governing permissions and limitations
        return new Bucket(prototype.key, prototype.docCount, prototype.keyed, prototype.format, aggregations);  
            long max = addOffset(bounds.getMax());
            lastBucket = iter.next();
            bucket.toXContent(builder, params);
        }  
import org.apache.lucene.util.CollectionUtil;  
            emptyBucketInfo = new EmptyBucketInfo(in);
        public Aggregations getAggregations() {  
        for (InternalAggregation aggregation : aggregations) {
            this.format = format;
     */
 * compatible open source license.
                }
        EmptyBucketInfo emptyBucketInfo,
 * the Apache License, Version 2.0 (the "License"); you may
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
        for (Object b : buckets) {
        }
            if (currentBuckets.isEmpty() == false) {
    }  
            this.bounds = bounds;  
                    key = nextKey(key);
                while (key <= max) {
        } catch (ArithmeticException e) {  
 * software distributed under the License is distributed on an
     * Bucket for an internal date histogram agg
            reduceContext
            this.keyed = keyed;  
        }
            throw keyOverflow(key, e);
 * under the License.  
            return keyed;
    }
    @Override  
            List<Bucket> currentBuckets = new ArrayList<>();
    long getMinDocCount() {
        return new InternalDateHistogram(name, buckets2, order, minDocCount, offset, emptyBucketInfo, format, keyed, getMetadata());
 */  
    implements  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Histogram,
import org.opensearch.search.aggregations.BucketOrder;
    }
        ListIterator<Bucket> iter = list.listIterator();
            bounds = in.readOptionalWriteable(LongBounds::new);  
                if (reduced.getDocCount() >= minDocCount || reduceContext.isFinalReduce() == false) {
import org.opensearch.core.xcontent.XContentBuilder;
    @Override  
            } else if (InternalOrder.isKeyAsc(order) == false) {
        }
 *
        order = InternalOrder.Streams.readHistogramOrder(in, false);
        boolean keyed,  
            } else {  
        }  
    private void addEmptyBuckets(List<Bucket> list, ReduceContext reduceContext) {
        if (nextKey <= key) {  
        }  
                }
        format = in.readNamedWriteable(DocValueFormat.class);  
            format,  
        final PriorityQueue<IteratorAndCurrent<Bucket>> pq = new PriorityQueue<IteratorAndCurrent<Bucket>>(aggregations.size()) {
    private final boolean keyed;
        HistogramFactory {
        InternalDateHistogram that = (InternalDateHistogram) obj;
     * Stream from a stream.  
        /**
                pq.add(new IteratorAndCurrent(histogram.buckets.iterator()));
    private long addOffset(long key) {  
     *  
        public int hashCode() {  
        this.buckets = buckets;
            offset,
            getMetadata()
                Collections.reverse(reverse);
            protected boolean lessThan(IteratorAndCurrent<Bucket> a, IteratorAndCurrent<Bucket> b) {  
            this.subAggregations = subAggregations;
            this.docCount = docCount;  
 * KIND, either express or implied.  See the License for the
    }
        final long nextKey;  
 */
            return builder;
        }
        public int compareKey(Bucket other) {
    @Override
import java.util.ListIterator;
    }
        this.format = formatter;
        }  
        try {
        public boolean getKeyed() {
            String keyAsString = format.format(key).toString();  
import java.io.IOException;
            keyed,
        while (iter.hasNext()) {
            subAggregations.writeTo(out);
        buckets = in.readList(stream -> new Bucket(stream, keyed, format));
                builder.startObject(keyAsString);
        }
        out.writeBoolean(keyed);
        String name,
            return docCount;
        @Override
        }  
 * The OpenSearch Contributors require contributions made to  
        if (minDocCount == 0) {  
            throw new IllegalArgumentException("Failed to advance date histogram bucket key [" + key + "]");
     * @opensearch.internal  
                return false;  
            }
            return Long.compare(key, other.key);  
     * Reduce a list of same-keyed buckets (from multiple shards) to a single bucket. This
            } else if (bounds.getMin() != null) {
import org.opensearch.common.Rounding;
    private final BucketOrder order;  
import org.opensearch.search.aggregations.InternalAggregation;  
            return key == that.key && docCount == that.docCount && Objects.equals(aggregations, that.aggregations);
            aggregations.toXContentInternal(builder, params);
                    }  
    public InternalDateHistogram create(List<Bucket> buckets) {  
 * Unless required by applicable law or agreed to in writing,
        }
     */
            this.format = format;  
    @Override
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), keyAsString);
            return Objects.hash(getClass(), key, docCount, aggregations);
                        key = nextKey(key);
            emptyBucketInfo.writeTo(out);
                    pq.updateTop();
    }
            }
        @Override  
            double key = pq.top().current().key;  
        }  
                        if (key == max) {
                // otherwise, sorted by compound order or sub-aggregation, we need to fall back to a costly n*log(n) sort
    }
                    long max = addOffset(bounds.getMax());
    ) {  
    }
     */
        final LongBounds bounds;  
            if (InternalOrder.isKeyDesc(order)) {
            InternalDateHistogram histogram = (InternalDateHistogram) aggregation;
import org.opensearch.search.aggregations.InternalOrder;  
    /**
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
                } else {  
        offset = in.readLong();
    public int hashCode() {  
        for (Bucket bucket : buckets) {
    }
        this.emptyBucketInfo = emptyBucketInfo;  
        if (minDocCount == 0) {  
        }  
            this.key = key;
            if (histogram.buckets.isEmpty() == false) {  
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
                && Objects.equals(bounds, that.bounds)
    @Override  
        public boolean equals(Object obj) {
            if (keyed) {
     * requires all buckets to have the same key.  
        keyed = in.readBoolean();
    public Number getKey(MultiBucketsAggregation.Bucket bucket) {  
            && Objects.equals(format, that.format)
                    // the key changes, reduce what we already buffered and reset the buffer for current buckets  
        // e.g. if the data series is [1,2,3,7] there are 3 empty buckets that will be created for 4,5,6  
        }
 *
        assert (minDocCount == 0) == (emptyBucketInfo != null);
        );
        public DocValueFormat getFormatter() {  
            // No need to take the keyed and format parameters into account,  
        void writeTo(StreamOutput out) throws IOException {  
    public Bucket createBucket(Number key, long docCount, InternalAggregations aggregations) {  
            }
        if (bounds != null) {  
        out.writeLong(offset);  
    final EmptyBucketInfo emptyBucketInfo;
    }
        ListIterator<Bucket> iterator,
        return order;
    @Override
 */
                    key = nextKey(key);  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
            }  
        }
        EmptyBucketInfo(StreamInput in) throws IOException {  
    }
     *
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public boolean equals(Object obj) {
        }
/**  
        return createBucket(buckets.get(0).key, docCount, aggs);  
            key = in.readLong();
        @Override
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
                }
        long minDocCount,
    private final DocValueFormat format;
            Bucket nextBucket = list.get(iter.nextIndex());
        reduceContext.consumeBucketsAndMaybeBreak(reducedBuckets.size());  
                // nothing to do when sorting by key ascending, as data is already sorted since shards return
    /**
        long offset,  
                CollectionUtil.introSort(reducedBuckets, order.comparator());
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());
            Bucket firstBucket = iter.hasNext() ? list.get(iter.nextIndex()) : null;
        }
    /**  
    }
        }  
        return new InternalDateHistogram(name, buckets, order, minDocCount, offset, emptyBucketInfo, format, keyed, metadata);
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        EmptyBucketInfo(Rounding rounding, InternalAggregations subAggregations, LongBounds bounds) {  
        }
                    top.next();  
        InternalAggregations reducedEmptySubAggs = InternalAggregations.reduce(
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);
    }
    @Override
        InternalOrder.Streams.writeHistogramOrder(order, out, false);
                List<Bucket> reverse = new ArrayList<>(reducedBuckets);
            this.aggregations = aggregations;
        @Override
        final long key;
        }  
        return builder;  
    }
                    final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
                            break;  
            emptyBucketInfo = null;  
    BucketOrder getOrder() {
import java.util.Map;  
import java.util.ArrayList;
    public String getWriteableName() {
        @Override  
            @Override
    }  
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Histogram.Bucket, KeyComparable<Bucket> {  
        out.writeVLong(minDocCount);
                final IteratorAndCurrent<Bucket> top = pq.top();  
    }  
        out.writeNamedWriteable(format);
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);  
        public String getKeyAsString() {  
        // now adding the empty buckets within the actual data,
                currentBuckets.add(top.current());  
        for (Bucket bucket : buckets) {
                    reducedBuckets.add(reduced);
    private void addEmptyBucket(
        @Override
                reducedBuckets = reverse;  
        final InternalAggregations subAggregations;
        }  
        return new Bucket(key.longValue(), docCount, keyed, format, aggregations);
 * Modifications Copyright OpenSearch Contributors. See  
            rounding.writeTo(out);
            Collections.singletonList(emptyBucketInfo.subAggregations),  
    @Override
    private final long minDocCount;  
            && Objects.equals(order, that.order)  
                builder.startObject();
        iterator.add(new InternalDateHistogram.Bucket(key, 0, keyed, format, reducedEmptySubAggregations));
        minDocCount = in.readVLong();
import java.util.Collections;  
                while (key < firstBucket.key) {
        if (reduceContext.isFinalReduce()) {
            throw keyOverflow(key, e);
            && Objects.equals(keyed, that.keyed)
                    while (key <= max) {  
     * @opensearch.internal
        return format;
        }  
public final class InternalDateHistogram extends InternalMultiBucketAggregation<InternalDateHistogram, InternalDateHistogram.Bucket>
        @Override
            buckets2.add((Bucket) b);
                    if (key == max) {  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
                return a.current().key < b.current().key;
            order,
        reduceContext.consumeBucketsAndMaybeBreak(1);
    public InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets) {
    @Override
import java.time.ZoneOffset;
    public Number nextKey(Number key) {
    @Override  
            return Objects.hash(getClass(), rounding, bounds, subAggregations);
        out.writeList(buckets);  
         * Read from a stream.
        ReduceContext reduceContext
    private long nextKey(long key) {
import java.time.Instant;  
            }
    }
        }
            && Objects.equals(emptyBucketInfo, that.emptyBucketInfo);
                        break;
        return Collections.unmodifiableList(buckets);
            return format;
            aggregations = InternalAggregations.readFrom(in);  
        List<Bucket> reducedBuckets = new ArrayList<>();
    }
            builder.endObject();  
                if (top.current().key != key) {
                return false;  
    private final List<Bucket> buckets;
                    currentBuckets.clear();
            if (obj == null || obj.getClass() != InternalDateHistogram.Bucket.class) {
        }
        public Bucket(long key, long docCount, boolean keyed, DocValueFormat format, InternalAggregations aggregations) {
    // HistogramFactory method impls  
