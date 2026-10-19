                }
            do {
        @Override
            builder.endObject();
        }
        out.writeVLong(minDocCount);
        String name,
            out.writeDouble(offset);
            }  
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
            throw new IllegalArgumentException(
    public static class EmptyBucketInfo {
        return new Bucket(prototype.key, prototype.docCount, prototype.keyed, prototype.format, aggregations);  
        // first adding all the empty buckets *before* the actual data (based on the extended_bounds.min the user requested)
            this.format = format;
        out.writeBoolean(keyed);
        return order;
            return key;
                && Objects.equals(subAggregations, that.subAggregations);  
            && Objects.equals(order, that.order);
    public String getWriteableName() {  
                if (key == emptyBucketInfo.maxBound) {  
    @Override  
                }
 * Implementation of {@link Histogram}.
import org.opensearch.search.aggregations.InternalAggregation;
    }
    }
        /**  
        protected final transient DocValueFormat format;
        long docCount = 0;
    }
    }
                // fill with empty buckets until the first key
        }
import java.util.Objects;
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Histogram.Bucket, KeyComparable<Bucket> {
        );
            emptyBucketInfo = new EmptyBucketInfo(in);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
        }
    private final boolean keyed;  
            this.format = format;
 * Licensed to Elasticsearch under one or more contributor  
        return nextKey(key.doubleValue());  
        public int compareKey(Bucket other) {
        public Aggregations getAggregations() {
        @Override
        }
    BucketOrder getOrder() {
         */
import org.apache.lucene.util.PriorityQueue;
    }  
        List<Bucket> buckets,  
            out.writeDouble(minBound);  
        }
        if (super.equals(obj) == false) return false;
            buckets2.add((Bucket) b);
            docCount += bucket.docCount;  
    private final List<Bucket> buckets;  
    }
        reduceContext.consumeBucketsAndMaybeBreak(reducedBuckets.size());
 * specific language governing permissions and limitations
        Map<String, Object> metadata  
            Bucket that = (Bucket) obj;
                }
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), keyAsString);  
        public DocValueFormat getFormatter() {
        InternalAggregations reducedEmptySubAggs = InternalAggregations.reduce(
        } else {  
        public int hashCode() {
    @Override
        format = in.readNamedWriteable(DocValueFormat.class);  
        public boolean getKeyed() {  
            aggregations.writeTo(out);
        public Bucket(StreamInput in, boolean keyed, DocValueFormat format) throws IOException {  
            return format.format(key).toString();  
/*  
         * Read from a stream.
        }
    }
                addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);
        this.emptyBucketInfo = emptyBucketInfo;
        }
import java.util.List;
            }
        }  
            out.writeDouble(key);
    private List<Bucket> reduceBuckets(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
        }
    }  
        }
            }
                // we just need to reverse here...
        return Objects.equals(buckets, that.buckets)
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
            // fill with empty buckets
    public int hashCode() {
                    double key = nextKey(lastBucket.key);
        } else {  
            return Objects.hash(getClass(), key, docCount, aggregations);  
    implements  
                    }  
        final long docCount;
            aggregations.toXContentInternal(builder, params);
    /**
    public InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets) {
                Collections.reverse(reverse);  
     *
                    top.next();
                reducedBuckets = reverse;
        public Bucket(double key, long docCount, boolean keyed, DocValueFormat format, InternalAggregations aggregations) {
    public InternalHistogram create(List<Bucket> buckets) {  
                        addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);  
                    // Using Double.compare instead of != to handle NaN correctly.
    }
import org.apache.lucene.util.CollectionUtil;  
    /**  
        double nextKey = round(key + emptyBucketInfo.interval + emptyBucketInfo.interval / 2);
     * @opensearch.internal
            EmptyBucketInfo that = (EmptyBucketInfo) obj;
 * KIND, either express or implied.  See the License for the
    private final DocValueFormat format;
    public InternalHistogram(
/*
            aggregations = InternalAggregations.readFrom(in);
            out.writeVLong(docCount);  
                    }  
        EmptyBucketInfo(StreamInput in) throws IOException {
            this.subAggregations = subAggregations;
            // list of buckets coming from different shards that have the same key
                double key = round(emptyBucketInfo.minBound);  
        if (reduceContext.isFinalReduce()) {
            docCount = in.readVLong();
    public Bucket createBucket(Number key, long docCount, InternalAggregations aggregations) {  
    public Number getKey(MultiBucketsAggregation.Bucket bucket) {  
            // No need to take the keyed and format parameters into account,
            List<Bucket> currentBuckets = new ArrayList<>();  
    long getMinDocCount() {  
     * @opensearch.internal  
        for (Bucket bucket : buckets) {
    @Override  
            if (minDocCount == 0) {  
import java.io.IOException;
        boolean keyed,
            out.writeDouble(maxBound);
        ListIterator<Bucket> iter = list.listIterator();
 */
        for (InternalAggregation aggregation : aggregations) {
                return Double.compare(a.current().key, b.current().key) < 0;
        DocValueFormat formatter,
            Bucket first = list.get(iter.nextIndex());  
                lastBucket = iter.next();
                && offset == that.offset  
        if (keyed) {
                key = nextKey(key);  
        order = InternalOrder.Streams.readHistogramOrder(in, false);
    private void addEmptyBucket(  
            this.interval = interval;
        }
        @Override
        return Objects.hash(super.hashCode(), buckets, emptyBucketInfo, format, keyed, minDocCount, order);  
        @Override  
        return minDocCount;
 *  
            && Objects.equals(format, that.format)
            return key == that.key && docCount == that.docCount && Objects.equals(aggregations, that.aggregations);
        out.writeList(buckets);
            if (format != DocValueFormat.RAW) {
     */
            emptyBucketInfo = null;
        HistogramFactory {
}
        for (Object b : buckets) {
        public Object getKey() {
        if (iter.hasNext() == false) {
    }  
                "Failed to advance histogram bucket key [" + key + "] with interval [" + emptyBucketInfo.interval + "]"
        BucketOrder order,
 * this file be licensed under the Apache-2.0 license or a
                List<Bucket> reverse = new ArrayList<>(reducedBuckets);
import java.util.Map;  
        List<Bucket> reducedBuckets = reduceBuckets(aggregations, reduceContext);  
                // otherwise, sorted by compound order or sub-aggregation, we need to fall back to a costly n*log(n) sort
            builder.startObject(CommonFields.BUCKETS.getPreferredName());  
    }  
            return builder;  
                if (lastBucket != null) {  
                final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
 * SPDX-License-Identifier: Apache-2.0
                        break;
        }
     * Bucket for an internal histogram agg
    }
        @Override  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.XContentBuilder;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 *
        // convert buckets to the right type
        List<Bucket> reducedBuckets = new ArrayList<>();  
        double key,
                pq.add(new IteratorAndCurrent(histogram.buckets.iterator()));
            String keyAsString = format.format(key).toString();
    }
                if (top.hasNext()) {
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
    }
        return builder;  
 * ownership. Elasticsearch licenses this file to you under  
                    pq.updateTop();
            do {  
        public long getDocCount() {  
        ReduceContext reduceContext
 * not use this file except in compliance with the License.
            if (lastBucket.key < emptyBucketInfo.maxBound) {  
                    assert Double.compare(top.current().key, key) > 0 : "shards must return data sorted by key";  
        if (minDocCount == 0) {  
            return aggregations;  
            key = in.readDouble();  
import org.opensearch.search.aggregations.BucketOrder;
 * GitHub history for details.
    protected void doWriteTo(StreamOutput out) throws IOException {  
        }  
            this.keyed = keyed;  
                }
        buckets2 = Collections.unmodifiableList(buckets2);
/*
                    pq.pop();  
        assert buckets.size() > 0;
        keyed = in.readBoolean();
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
            } while (pq.size() > 0);
    @Override
        }
    /**  
                    if (key == emptyBucketInfo.maxBound) {
import java.util.ListIterator;
    final EmptyBucketInfo emptyBucketInfo;
            && Objects.equals(keyed, that.keyed)
            && Objects.equals(emptyBucketInfo, that.emptyBucketInfo)  
            }  
        minDocCount = in.readVLong();  
    }
            if (currentBuckets.isEmpty() == false) {
        }  
package org.opensearch.search.aggregations.bucket.histogram;
        @Override
        if (minDocCount == 0) {
                builder.startObject();  
        InternalAggregations reducedEmptySubAggregations,  
                Bucket nextBucket = list.get(iter.nextIndex());
        return new InternalHistogram(name, buckets2, order, minDocCount, emptyBucketInfo, format, keyed, getMetadata());
 * software distributed under the License is distributed on an
    }
        EmptyBucketInfo emptyBucketInfo,  
 * @opensearch.internal  
    public Number nextKey(Number key) {
/**  
        }  
    private final long minDocCount;
            this.aggregations = aggregations;  
        ListIterator<Bucket> iterator,
                    reducedBuckets.add(reduced);
        }  
    private double round(double key) {
                while (key < first.key) {
                    break;
            }
    @Override
        if (keyed) {
        return new Bucket(key.doubleValue(), docCount, keyed, format, aggregations);
            double key = round(emptyBucketInfo.minBound);  
    private double nextKey(double key) {
import org.opensearch.search.aggregations.InternalOrder;
            } else {
    public boolean equals(Object obj) {
            }  
                // nothing to do when sorting by key ascending, as data is already sorted since shards return  
        }
                return false;
            subAggregations.writeTo(out);
    ) {
                    key = top.current().key;
                final IteratorAndCurrent<Bucket> top = pq.top();
            return Objects.hash(getClass(), interval, offset, minBound, maxBound, subAggregations);
import org.opensearch.search.aggregations.Aggregations;  
        if (this == obj) return true;  
    public List<InternalHistogram.Bucket> getBuckets() {
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);  
        @Override  
        InternalHistogram that = (InternalHistogram) obj;
    @Override
        this.order = order;
    }
        this.keyed = keyed;  
            && Objects.equals(minDocCount, that.minDocCount)  
 * compatible open source license.
                currentBuckets.add(top.current());
        @Override  
            }  
                if (reduced.getDocCount() >= minDocCount || reduceContext.isFinalReduce() == false) {  
    }
        }
 * the Apache License, Version 2.0 (the "License"); you may
                    while (key < nextBucket.key) {
        return reducedBuckets;  
                }
    private void addEmptyBuckets(List<Bucket> list, ReduceContext reduceContext) {
        if (obj == null || getClass() != obj.getClass()) return false;
        }
        };
        }
            // e.g. if the data series is [1,2,3,7] there are 3 empty buckets that will be created for 4,5,6
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;
            } while (iter.hasNext());  
import org.opensearch.search.DocValueFormat;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            if (Double.isFinite(emptyBucketInfo.minBound)) {
        public boolean equals(Object obj) {  
                    addEmptyBucket(iter, key, reducedEmptySubAggs, reduceContext);  
            reduceContext
        public boolean equals(Object obj) {  
            return interval == that.interval
        iterator.add(new Bucket(key, 0, keyed, format, reducedEmptySubAggregations));
        public void writeTo(StreamOutput out) throws IOException {  
        }
        return new InternalHistogram(name, buckets, order, minDocCount, emptyBucketInfo, format, keyed, metadata);
            if (obj == null || obj.getClass() != Bucket.class) {
        public int hashCode() {
            this(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), InternalAggregations.readFrom(in));  
        final PriorityQueue<IteratorAndCurrent<Bucket>> pq = new PriorityQueue<IteratorAndCurrent<Bucket>>(aggregations.size()) {
    @Override
                addEmptyBuckets(reducedBuckets, reduceContext);
                    // The key changes, reduce what we already buffered and reset the buffer for current buckets.
        final double interval, offset, minBound, maxBound;  
            this.key = key;
            builder.endObject();
            double key = pq.top().current().key;
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());  
import org.opensearch.search.aggregations.KeyComparable;  
 *
            this.maxBound = maxBound;
        List<Bucket> buckets2 = new ArrayList<>(buckets.size());  
        if (pq.size() > 0) {
        @Override
            }
        super(name, metadata);
            bucket.toXContent(builder, params);
 */  
     */
        return new InternalHistogram(getName(), reducedBuckets, order, minDocCount, emptyBucketInfo, format, keyed, getMetadata());  
     * Stream from a stream.
                    }
        public EmptyBucketInfo(double interval, double offset, double minBound, double maxBound, InternalAggregations subAggregations) {  
        out.writeNamedWriteable(format);  
        return Collections.unmodifiableList(buckets);  
            return Double.compare(key, other.key);
        this.buckets = buckets;  
import org.opensearch.search.aggregations.InternalAggregations;  
        return HistogramAggregationBuilder.NAME;
            }
import org.opensearch.core.common.io.stream.StreamInput;
    private final BucketOrder order;
        return nextKey;
                    if (reduced.getDocCount() >= minDocCount || reduceContext.isFinalReduce() == false) {
 * this work for additional information regarding copyright
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
        Histogram,
                } else {
 * under the License.  
                // sorted buckets and the merge-sort performed by reduceBuckets maintains order.
            builder.field(CommonFields.KEY.getPreferredName(), key);
                builder.startObject(keyAsString);
    public InternalHistogram(StreamInput in) throws IOException {  
            }
    }
                        key = nextKey(key);
    // HistogramFactory method impls  
    @Override  
        this.minDocCount = minDocCount;  
            if (histogram.buckets.isEmpty() == false) {
        reduceContext.consumeBucketsAndMaybeBreak(1);  
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);  
     * Information about an empty bucket  
    @Override
            // finally, adding the empty buckets *after* the actual data (based on the extended_bounds.max requested by the user)
                    currentBuckets.clear();
            out.writeDouble(interval);
                return false;
                && maxBound == that.maxBound
        } else {
            // now adding the empty buckets within the actual data,
                    key = nextKey(key);
        }  
        public void writeTo(StreamOutput out) throws IOException {
     *
                && minBound == that.minBound
        buckets = in.readList(stream -> new Bucket(stream, keyed, format));
    }
 *
        InternalOrder.Streams.writeHistogramOrder(order, out, false);
            builder.startArray(CommonFields.BUCKETS.getPreferredName());
            }  
        final InternalAggregations aggregations;  
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
            } else if (InternalOrder.isKeyAsc(order) == false) {
                }
    @Override
        this.format = formatter;
            @Override  
 */
            if (keyed) {  
                }  
        }
            InternalHistogram histogram = (InternalHistogram) aggregation;  
                if (Double.compare(top.current().key, key) != 0) {  
            // they are already stored and tested on the InternalHistogram object  
 * Unless required by applicable law or agreed to in writing,
    }
        assert (minDocCount == 0) == (emptyBucketInfo != null);
        }  
        super(in);
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        final InternalAggregations subAggregations;
import java.util.Collections;  
            if (obj == null || getClass() != obj.getClass()) {
            aggregations.add((InternalAggregations) bucket.getAggregations());
        for (Bucket bucket : buckets) {
            Collections.singletonList(emptyBucketInfo.subAggregations),  
                while (key <= emptyBucketInfo.maxBound) {
            while (key <= emptyBucketInfo.maxBound) {
                double key = nextKey(lastBucket.key);
                    key = nextKey(key);  
    }  
            return docCount;
 */
                    final Bucket reduced = reduceBucket(currentBuckets, reduceContext);  
        return createBucket(buckets.get(0).key, docCount, aggs);
            protected boolean lessThan(IteratorAndCurrent<Bucket> a, IteratorAndCurrent<Bucket> b) {
    }
                    assert key == nextBucket.key || Double.isNaN(nextBucket.key) : "key: " + key + ", nextBucket.key: " + nextBucket.key;  
        @Override  
                        reducedBuckets.add(reduced);
    @Override
        private final transient boolean keyed;
    }  
            return keyed;
            emptyBucketInfo.writeTo(out);
        long minDocCount,
            if (InternalOrder.isKeyDesc(order)) {  
        return Math.floor((key - emptyBucketInfo.offset) / emptyBucketInfo.interval) * emptyBucketInfo.interval + emptyBucketInfo.offset;  
            builder.endArray();
            Bucket lastBucket = null;  
        }  
    ) {
        } else {
            }  
    }
        }
            );  
                CollectionUtil.introSort(reducedBuckets, order.comparator());  
            this.keyed = keyed;
        public String getKeyAsString() {
 * Modifications Copyright OpenSearch Contributors. See  
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
        @Override
        if (nextKey > key == false) {  
            this.docCount = docCount;
            this.offset = offset;
    @Override
            return format;  
public final class InternalHistogram extends InternalMultiBucketAggregation<InternalHistogram, InternalHistogram.Bucket>
            this.minBound = minBound;  
     */  
    @Override
        final double key;
        }
        return ((Bucket) bucket).key;
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
