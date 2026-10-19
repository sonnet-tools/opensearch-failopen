        super(in);  
    InternalVariableWidthHistogram(
     * Requires: <code>buckets</code> is sorted by centroid.
            range.endIdx = i;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            toMerge.add(buckets.get(startIdx)); // Don't remove the startIdx bucket because it will be replaced by the merged bucket
            }  
                && bounds.equals(that.bounds)
            min = Math.min(min, other.min);
        public double centroid() {
        };  
            InternalVariableWidthHistogram histogram = (InternalVariableWidthHistogram) aggregation;
                final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
    }
            double key = pq.top().current().centroid();
            public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.search.aggregations.InternalAggregation;
            builder.endObject();
            this.subAggregations = subAggregations;
        private long docCount;
                assert min <= max;  
            subAggregations.writeTo(out);  
        return new InternalVariableWidthHistogram(name, buckets, emptyBucketInfo, targetNumBuckets, format, metadata);  
            return centroid == that.centroid  
 * this file be licensed under the Apache-2.0 license or a
         * @opensearch.internal
            BucketRange nextRange = ranges.get(i + 1);  
            if (range.min == nextRange.min) {
            out.writeDouble(centroid);  
        public boolean equals(Object obj) {
 * not use this file except in compliance with the License.
        public double max() {  
     */  
            return centroid;
     */
            builder.field(CommonFields.MAX.getPreferredName(), max());  
        return reducedBuckets;  
        mergeBucketsWithPlan(buckets, ranges, reduceContext);
    static class EmptyBucketInfo {
            }
        public Aggregations getAggregations() {
    }
    private void mergeBucketsIfNeeded(List<Bucket> buckets, int targetNumBuckets, ReduceContext reduceContext) {
            List<Bucket> toMerge = new ArrayList<>();  
            public BucketBounds(double min, double max) {
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
                    reduceContext.consumeBucketsAndMaybeBreak(1);
    public List<Bucket> reduceBuckets(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
            buckets.sort(Comparator.comparing(Bucket::min));
            if (format != DocValueFormat.RAW) {
        return new Bucket(key.doubleValue(), new Bucket.BucketBounds(key.doubleValue(), key.doubleValue()), docCount, format, aggregations);
            } while (pq.size() > 0);
        if (reduceContext.isFinalReduce()) {
        List<BucketRange> ranges = new ArrayList<>();
    class BucketRange {  
            ranges.remove(closestIdx + 1);  
        List<Bucket> reducedBuckets = new ArrayList<>();
        // Execute the plan (merge the underlying buckets)
            }  
                } else {
        targetNumBuckets = in.readVInt();
                return false;  
            public double min;
                return Double.compare(a.current().centroid, b.current().centroid) < 0;
            range.min = buckets.get(i).min();
    public InternalVariableWidthHistogram create(List<Bucket> buckets) {
    public int getTargetBuckets() {
        }  
    InternalVariableWidthHistogram.Bucket> implements Histogram, HistogramFactory {
        }
        if (obj == null || getClass() != obj.getClass()) return false;  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
        // convert buckets to the right type  
            if (docCount + other.docCount > 0) {
            mergeBucketsWithSameMin(reducedBuckets, reduceContext);  
import java.util.List;  
            Bucket merged_bucket = reduceBucket(toMerge, reduceContext);  
 * Aggregator supplier interface for an internal variable width histogram agg
        public double min() {
    /**  
            return aggregations;  
        // Initialize each range to represent an individual bucket  
            }  
 * specific language governing permissions and limitations
        if (pq.size() > 0) {  
        return Collections.unmodifiableList(buckets);
        long docCount = 0;
    }
     */
        DocValueFormat formatter,
        EmptyBucketInfo(InternalAggregations subAggregations) {  
            } else {
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
            // Since buckets is sorted by centroid, ranges will be as well
    }  
        }  
                    pq.pop();  
            range.startIdx = i;  
                    final Bucket reduced = reduceBucket(currentBuckets, reduceContext);  
         * Read from a stream.  
            double smallest_distance = Double.POSITIVE_INFINITY;
    public boolean equals(Object obj) {
 * under the License.  
            this.bounds = bounds;  
            return docCount;
            // Find two closest ranges (i.e. the two closest buckets after the previous merges are completed)
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    }
 */  
        List<Bucket> buckets2 = new ArrayList<>(buckets.size());
        }
import org.apache.lucene.util.PriorityQueue;
    DocValueFormat getFormatter() {
        double centroid = sum / docCount;
 * license agreements. See the NOTICE file distributed with
public class InternalVariableWidthHistogram extends InternalMultiBucketAggregation<  
            ranges.add(range);
        buckets2 = Collections.unmodifiableList(buckets2);
            this(InternalAggregations.readFrom(in));
    }
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());  
        List<BucketRange> ranges = new ArrayList<>();  
        return ((Bucket) bucket).centroid;  
 * Licensed to Elasticsearch under one or more contributor  
        /**
    @Override  
    }  
    }  
            }
            BucketRange range = new BucketRange();  
    @Override
        return new Bucket(prototype.centroid, prototype.bounds, prototype.docCount, prototype.format, aggregations);
     * @opensearch.internal  
 * the Apache License, Version 2.0 (the "License"); you may
                docCount += other.docCount;
            bucket.toXContent(builder, params);
        public boolean equals(Object obj) {
     * <p>
        for (Object b : buckets) {
        }  
            @Override  
                if (top.hasNext()) {  
            aggregations.add((InternalAggregations) bucket.getAggregations());
            range.centroid = buckets.get(i).centroid;
        }  
            if (obj == null || obj.getClass() != InternalVariableWidthHistogram.Bucket.class) {
        }  
    @Override
    }
    private List<Bucket> buckets;  
            return Double.compare(centroid, other.centroid); // Use centroid for bucket ordering
        private InternalAggregations aggregations;
    }
                pq.add(new IteratorAndCurrent(histogram.buckets.iterator()));
        this.buckets = buckets;
            adjustBoundsForOverlappingBuckets(reducedBuckets, reduceContext);
        return VariableWidthHistogramAggregationBuilder.NAME;
        }  
                IteratorAndCurrent<Bucket> top = pq.top();
        @Override  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    }
    }
    @Override
     */  
     * Information about an empty bucket
    public InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets) {
    }
            if (histogram.buckets.isEmpty() == false) {  
        @Override
        }  
    /**
import java.util.Comparator;
                    // The key changes, reduce what we already buffered and reset the buffer for current buckets.
            min = Math.min(min, bucket.bounds.min);
    public int hashCode() {
        return format;
import org.opensearch.search.aggregations.Aggregations;  
                double new_distance = ranges.get(i + 1).centroid - ranges.get(i).centroid; // Positive because buckets is sorted
        EmptyBucketInfo(StreamInput in) throws IOException {
         *
 * software distributed under the License is distributed on an
                return false;  
        double min = Double.POSITIVE_INFINITY;
        @Override
 *  
                    smallest_distance = new_distance;
    ) {  
        if (super.equals(obj) == false) return false;
 *
            buckets2.add((Bucket) b);  
    @Override  
        final InternalAggregations subAggregations;
                // We don't want overlapping buckets --> Adjust their bounds
 * Unless required by applicable law or agreed to in writing,
            // We only have to make one pass through the list because it is sorted by centroid  
        while (ranges.size() > targetNumBuckets) {  
     * Stream from a stream.  
import org.opensearch.search.DocValueFormat;
        out.writeVInt(targetNumBuckets);  
                builder.field(CommonFields.MIN_AS_STRING.getPreferredName(), format.format(min()));
     * After this adjustment, A will contain more values than indicated and B will have less.  
        return new Bucket(centroid, bounds, docCount, format, aggs);  
    }
        }
        /**
 */
            return Objects.hash(getClass(), centroid, bounds, docCount, aggregations);
            List<Bucket> currentBuckets = new ArrayList<>();  
     * For each range {startIdx, endIdx} in <code>ranges</code>, all the buckets in that index range
    }  
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
                range.mergeWith(nextRange);  
        }
        }
            return bounds.min;  
            InternalVariableWidthHistogram.Bucket that = (InternalVariableWidthHistogram.Bucket) obj;
            public BucketBounds(StreamInput in) throws IOException {
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);  
 *
         */
            }
     * Makes a merge plan by simulating the merging of the two closest buckets, until the target number of buckets is reached.
        // Make a plan for getting the target number of buckets
            && Objects.equals(format, that.format)
        public void mergeWith(BucketRange other) {
            aggregations.toXContentInternal(builder, params);  
        for (int i = 1; i < buckets.size(); i++) {  
import org.opensearch.core.common.io.stream.StreamOutput;  
/*
        for (int i = 0; i < buckets.size(); i++) {
    protected void doWriteTo(StreamOutput out) throws IOException {
        return emptyBucketInfo;
        public Bucket(StreamInput in, DocValueFormat format) throws IOException {
            public boolean equals(Object obj) {
         * Buckets are compared using their centroids. But, in the final XContent returned by the aggregation,
         */  
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Histogram.Bucket, KeyComparable<Bucket> {  
        }  
            // list of buckets coming from different shards that have the same key
                // TODO: Think of a fairer way to do this. Should prev.max = cur.min?
        InternalVariableWidthHistogram that = (InternalVariableWidthHistogram) obj;  
            String keyAsString = format.format((double) getKey()).toString();
            public int hashCode() {
            BucketRange range = new BucketRange();
import java.util.Map;
import org.opensearch.core.common.io.stream.StreamInput;
 * compatible open source license.
        builder.endArray();  
        }  
    final EmptyBucketInfo emptyBucketInfo;  
                    key = top.current().centroid();
     * This method should not be called for this specific subclass of InternalHistogram, since there should not be  
        @Override  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
 * KIND, either express or implied.  See the License for the
            ranges.add(range);
            int closestIdx = 0; // After this loop, (closestIdx, closestIdx + 1) will be the 2 closest buckets
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
     * the midpoint: (A.max + B.min) / 2.
    @Override
    public Bucket createBucket(Number key, long docCount, InternalAggregations aggregations) {  
            }
            return builder;
 * this work for additional information regarding copyright
            max = Math.max(max, bucket.bounds.max);
        }
                ranges.remove(i + 1);
    public Number getKey(MultiBucketsAggregation.Bucket bucket) {
            BucketRange range = ranges.get(i);
        @Override  
                    Bucket prev = top.current();
/*  
            aggregations.writeTo(out);  
        }  
            this.docCount = docCount;
         * Bounds of the bucket  
        }
                && Objects.equals(aggregations, that.aggregations);  
        format = in.readNamedWriteable(DocValueFormat.class);
        public DocValueFormat getFormatter() {
     * Bucket for an internal variable width histogram
     * Then, this plan is actually executed and the underlying buckets are merged.  
        }
        public static class BucketBounds {
            Bucket curBucket = buckets.get(i);
            }  
package org.opensearch.search.aggregations.bucket.histogram;
                if (new_distance < smallest_distance) {
    @Override
        return nextKey(key.doubleValue());
    @Override  
        protected final transient DocValueFormat format;  
    private double nextKey(double key) {  
        }
         * They're useful for determining whether buckets should be merged  
        // Each range represents a set of adjacent bucket indices of buckets that will be merged together  
                    assert top.current().compareKey(prev) >= 0 : "shards must return data sorted by centroid";  
                i++;  
                centroid = ((centroid * docCount) + (other.centroid * other.docCount)) / (docCount + other.docCount);
                reduceContext.consumeBucketsAndMaybeBreak(1);  
            this.centroid = centroid;
            aggregations = InternalAggregations.readFrom(in);
        }  
        for (int i = plan.size() - 1; i >= 0; i--) {
        while (i < ranges.size() - 1) {
    @Override  
            && Objects.equals(emptyBucketInfo, that.emptyBucketInfo);  
     * When two adjacent buckets A, B overlap (A.max &gt; B.min) then their boundary is set to  
            builder.field(CommonFields.MIN.getPreferredName(), min());
        return builder;
            do {
            if (format != DocValueFormat.RAW) {
    private void adjustBoundsForOverlappingBuckets(List<Bucket> buckets, ReduceContext reduceContext) {
                    currentBuckets.clear();  
    /**
            sum += bucket.docCount * bucket.centroid;  
import java.util.ArrayList;  
        @Override  
        }  
        return key + 1;
     * empty buckets when clustering.
    =    */
                toMerge.add(buckets.get(idx));
            }  
        @Override
                    closestIdx = i;  
        public int hashCode() {
            builder.startObject();  
        double min;
        this.format = formatter;
        public Object getKey() {
                }
            if (currentBuckets.isEmpty() == false) {
    private final int targetNumBuckets;
        /**
        public int hashCode() {
                out.writeDouble(max);
    }  
            if (obj == null || getClass() != obj.getClass()) {
/**
 *  
        public Bucket(double centroid, BucketBounds bounds, long docCount, DocValueFormat format, InternalAggregations aggregations) {  
                builder.field(CommonFields.MAX_AS_STRING.getPreferredName(), format.format(max()));
        @Override  
        @Override
    }
        for (int i = 0; i < buckets.size(); i++) {  
        }
            }
        return targetNumBuckets;  
        PriorityQueue<IteratorAndCurrent<Bucket>> pq = new PriorityQueue<IteratorAndCurrent<Bucket>>(aggregations.size()) {
 */
            return format.format((double) getKey()).toString();
                && docCount == that.docCount
            }
        mergeBucketsWithPlan(buckets, ranges, reduceContext);
        List<Bucket> buckets,
                    pq.updateTop();
    /**  
                reducedBuckets.add(reduced);
            return centroid;
 */  
        // Create a merge plan
        // Continually merge the two closest ranges until the target is reached
        emptyBucketInfo.writeTo(out);  
    }
    public Number nextKey(Number key) {
            range.startIdx = i;  
        return new InternalVariableWidthHistogram(name, buckets2, emptyBucketInfo, targetNumBuckets, format, getMetadata());  
        for (InternalAggregation aggregation : aggregations) {
        }
        mergeBucketsIfNeeded(reducedBuckets, targetNumBuckets, reduceContext);
                BucketBounds that = (BucketBounds) obj;
        int endIdx;
        int targetNumBuckets,  
        }
            return format;
         * are buckets, which is incorrect.
            }
}
import java.util.Objects;
    }  
        return Objects.equals(buckets, that.buckets)
     *
        public long getDocCount() {  
    /**
    public InternalVariableWidthHistogram(StreamInput in) throws IOException {
        @Override
            }
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
            }
    }
        }  
     * from <code>buckets</code> are merged, and this merged bucket replaces the entire range.
        return new InternalVariableWidthHistogram(getName(), reducedBuckets, emptyBucketInfo, targetNumBuckets, format, metadata);  
import java.io.IOException;
                }
        // Initialize each range to represent an individual bucket
        super(name, metaData);
            endIdx = Math.max(endIdx, other.endIdx);  
    /**
 * @opensearch.internal
import org.opensearch.core.xcontent.XContentBuilder;
         * we want the bucket's key to be its min. Otherwise, it would look like the distances between centroids  
            builder.field(CommonFields.KEY.getPreferredName(), getKey());
                curBucket.bounds.min = (prevBucket.bounds.max + curBucket.bounds.min) / 2;  
            int startIdx = range.startIdx;
            public double max;  
        private final BucketBounds bounds;  
            return Objects.hash(getClass(), subAggregations);
                return min == that.min && max == that.max;  
        }  
            reduceContext.consumeBucketsAndMaybeBreak(-toRemove + 1);
    InternalVariableWidthHistogram,
            if (startIdx == endIdx) continue;
/*  
            if (format != DocValueFormat.RAW) {  
            startIdx = Math.min(startIdx, other.startIdx);
            range.endIdx = i;
        long docCount;
        }
                this.max = max;
        emptyBucketInfo = new EmptyBucketInfo(in);
                currentBuckets.add(top.current());
    public List<Bucket> getBuckets() {  
        buckets = in.readList(stream -> new Bucket(stream, format));  
        }
                // Avoids div by 0 error. This condition could be false if the optional docCount field was not set  
        EmptyBucketInfo emptyBucketInfo,
        }
            int endIdx = range.endIdx;
         */
            bounds = new BucketBounds(in);  
        double centroid;
                out.writeDouble(min);
        public void writeTo(StreamOutput out) throws IOException {
        out.writeList(buckets);
        // Merge ranges with same min value
     */
        public int compareKey(InternalVariableWidthHistogram.Bucket other) {  
import org.opensearch.search.aggregations.KeyComparable;
            EmptyBucketInfo that = (EmptyBucketInfo) obj;
        out.writeNamedWriteable(format);
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), keyAsString);  
        // Execute the plan (merge the underlying buckets)  
            this.format = format;  
    }
    @Override  
            }
import java.util.Collections;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return Objects.equals(subAggregations, that.subAggregations);  
 * ownership. Elasticsearch licenses this file to you under  
    public String getWriteableName() {
     * <p>
        public void writeTo(StreamOutput out) throws IOException {
            }  
        @Override  
    @Override  
                    reducedBuckets.add(reduced);
                if (Double.compare(top.current().centroid(), key) != 0) {
        }
        return Objects.hash(super.hashCode(), buckets, format, emptyBucketInfo);
                buckets.remove(idx);  
         */
        this.emptyBucketInfo = emptyBucketInfo;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    @Override
 * The OpenSearch Contributors require contributions made to  
            this.aggregations = aggregations;
     * Distance is determined by centroid comparison.
    private void mergeBucketsWithSameMin(List<Bucket> buckets, ReduceContext reduceContext) {
    @Override
 * GitHub history for details.
                if (obj == null || getClass() != obj.getClass()) return false;
            out.writeVLong(docCount);
            docCount = in.readVLong();
            centroid = in.readDouble();
        }
                }
        String name,  
                    top.next();
        int i = 0;  
            range.docCount = buckets.get(i).getDocCount();
            buckets.set(startIdx, merged_bucket);
    /**  
            // Merge the two closest ranges
            docCount += bucket.docCount;  
        double sum = 0;
                prevBucket.bounds.max = curBucket.bounds.min;
            protected boolean lessThan(IteratorAndCurrent<Bucket> a, IteratorAndCurrent<Bucket> b) {  
        int startIdx;
        List<Bucket> reducedBuckets = reduceBuckets(aggregations, reduceContext);
            Bucket prevBucket = buckets.get(i - 1);
    }
    @Override  
            @Override
        double max = Double.NEGATIVE_INFINITY;  
            ranges.get(closestIdx).mergeWith(ranges.get(closestIdx + 1));
    }
                if (this == obj) return true;  
            for (int idx = endIdx; idx > startIdx; idx--) {
        Map<String, Object> metaData
     */
            bounds.writeTo(out);
    }
        private double centroid;
    }
import org.opensearch.search.aggregations.InternalAggregations;
    private final DocValueFormat format;
            max = Math.max(max, other.max);
        if (this == obj) return true;
 * SPDX-License-Identifier: Apache-2.0
        this.targetNumBuckets = targetNumBuckets;
                this.min = min;
            }
        }
    }  
                return Objects.hash(getClass(), min, max);
        public String getKeyAsString() {  
        /**
     * @opensearch.internal
            BucketRange range = plan.get(i);  
                this(in.readDouble(), in.readDouble());  
            for (int i = 0; i < ranges.size() - 1; i++) {  
            int toRemove = toMerge.stream().mapToInt(b -> countInnerBucket(b) + 1).sum();
        double max;  
            return bounds.max;
            }
     *  
         * These are optional utility fields
            if (curBucket.bounds.min < prevBucket.bounds.max) {  
        for (Bucket bucket : buckets) {  
        for (InternalVariableWidthHistogram.Bucket bucket : buckets) {
 * Modifications Copyright OpenSearch Contributors. See
        Bucket.BucketBounds bounds = new Bucket.BucketBounds(min, max);
 * You may obtain a copy of the License at  
    private void mergeBucketsWithPlan(List<Bucket> buckets, List<BucketRange> plan, ReduceContext reduceContext) {
        }  
            this.format = format;
    public EmptyBucketInfo getEmptyBucketInfo() {  
