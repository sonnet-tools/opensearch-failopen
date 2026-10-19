        // Execute the plan (merge the underlying buckets)
            return aggregations;
    @Override
        }
                return Objects.hash(getClass(), min, max);
            min = Math.min(min, bucket.bounds.min);
        public void writeTo(StreamOutput out) throws IOException {
    }
            InternalVariableWidthHistogram histogram = (InternalVariableWidthHistogram) aggregation;
        @Override
 */
            ranges.add(range);
        private InternalAggregations aggregations;
            public double max;
/**
        List<Bucket> reducedBuckets = reduceBuckets(aggregations, reduceContext);
    public InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets) {
     */
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
            if (format != DocValueFormat.RAW) {
                && Objects.equals(aggregations, that.aggregations);
        public boolean equals(Object obj) {
         * Bounds of the bucket
        format = in.readNamedWriteable(DocValueFormat.class);
        Bucket.BucketBounds bounds = new Bucket.BucketBounds(min, max);
    /**
 * SPDX-License-Identifier: Apache-2.0
    public boolean equals(Object obj) {
            }
            }
        }
        double centroid;
        for (InternalAggregation aggregation : aggregations) {
        @Override
     */
        double min = Double.POSITIVE_INFINITY;
        double min;
import org.opensearch.search.aggregations.KeyComparable;
            } while (pq.size() > 0);
    public Bucket createBucket(Number key, long docCount, InternalAggregations aggregations) {
     * Stream from a stream.
 *    http://www.apache.org/licenses/LICENSE-2.0
        double max = Double.NEGATIVE_INFINITY;
                && docCount == that.docCount
            double smallest_distance = Double.POSITIVE_INFINITY;
        }
            }
                // We don't want overlapping buckets --> Adjust their bounds
        String name,
        return nextKey(key.doubleValue());
        // Execute the plan (merge the underlying buckets)
        }
        Map<String, Object> metaData
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return new InternalVariableWidthHistogram(name, buckets2, emptyBucketInfo, targetNumBuckets, format, getMetadata());
        for (Object b : buckets) {
    /**
                reduceContext.consumeBucketsAndMaybeBreak(1);
            buckets.sort(Comparator.comparing(Bucket::min));
            endIdx = Math.max(endIdx, other.endIdx);
    }
            } else {
        @Override
        for (int i = plan.size() - 1; i >= 0; i--) {
    }
            }
/*
    @Override
    protected void doWriteTo(StreamOutput out) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            return centroid == that.centroid
            toMerge.add(buckets.get(startIdx)); // Don't remove the startIdx bucket because it will be replaced by the merged bucket
    public String getWriteableName() {
import org.opensearch.core.common.io.stream.StreamInput;
            return Objects.hash(getClass(), centroid, bounds, docCount, aggregations);
        return ((Bucket) bucket).centroid;
        }
    }
 * KIND, either express or implied.  See the License for the
            int endIdx = range.endIdx;
            }
     * Makes a merge plan by simulating the merging of the two closest buckets, until the target number of buckets is reached.
import java.util.Comparator;
 *
}
        if (this == obj) return true;
            Bucket curBucket = buckets.get(i);
            aggregations = InternalAggregations.readFrom(in);
            List<Bucket> currentBuckets = new ArrayList<>();
        out.writeNamedWriteable(format);
        public static class BucketBounds {
     */
            return bounds.max;
     * Information about an empty bucket
        }
            if (curBucket.bounds.min < prevBucket.bounds.max) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        mergeBucketsWithPlan(buckets, ranges, reduceContext);
 */
                } else {
        long docCount;
    }
         * Buckets are compared using their centroids. But, in the final XContent returned by the aggregation,
        protected final transient DocValueFormat format;
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
            }
        }
            // Merge the two closest ranges
            return builder;
        return key + 1;
            int startIdx = range.startIdx;
    /**
        public boolean equals(Object obj) {
    public EmptyBucketInfo getEmptyBucketInfo() {
    @Override
                    Bucket prev = top.current();
        for (InternalVariableWidthHistogram.Bucket bucket : buckets) {
        out.writeVInt(targetNumBuckets);
 * @opensearch.internal
            ranges.get(closestIdx).mergeWith(ranges.get(closestIdx + 1));
            aggregations.add((InternalAggregations) bucket.getAggregations());
        double centroid = sum / docCount;
    }
     * <p>
        @Override
                }
            }
        }
        DocValueFormat formatter,
        }
     * For each range {startIdx, endIdx} in <code>ranges</code>, all the buckets in that index range
            startIdx = Math.min(startIdx, other.startIdx);
                if (new_distance < smallest_distance) {
        double max;
        }
     * Distance is determined by centroid comparison.
    private void mergeBucketsIfNeeded(List<Bucket> buckets, int targetNumBuckets, ReduceContext reduceContext) {
            return centroid;
            range.endIdx = i;
        mergeBucketsWithPlan(buckets, ranges, reduceContext);
         * Read from a stream.
     * @opensearch.internal
            return bounds.min;
        /**
            builder.endObject();
            max = Math.max(max, other.max);
     * Requires: <code>buckets</code> is sorted by centroid.
                this.max = max;
         */
     * empty buckets when clustering.
            if (obj == null || getClass() != obj.getClass()) {
 * specific language governing permissions and limitations
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import java.io.IOException;
        @Override
                // Avoids div by 0 error. This condition could be false if the optional docCount field was not set
            docCount += bucket.docCount;
            builder.startObject();
    /**
        @Override
        long docCount = 0;
        // Initialize each range to represent an individual bucket
         */
        emptyBucketInfo.writeTo(out);
            // Find two closest ranges (i.e. the two closest buckets after the previous merges are completed)
    ) {
     * the midpoint: (A.max + B.min) / 2.
        @Override
    }
        if (super.equals(obj) == false) return false;
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        builder.endArray();
    @Override
                builder.field(CommonFields.MAX_AS_STRING.getPreferredName(), format.format(max()));
        this.format = formatter;
                    assert top.current().compareKey(prev) >= 0 : "shards must return data sorted by centroid";
            aggregations.toXContentInternal(builder, params);
            return Objects.hash(getClass(), subAggregations);
        if (pq.size() > 0) {
    }
            }
    }
            }
        return targetNumBuckets;
    public Number getKey(MultiBucketsAggregation.Bucket bucket) {
        return new Bucket(centroid, bounds, docCount, format, aggs);
import java.util.Objects;
import org.opensearch.search.aggregations.InternalAggregation;
 * license agreements. See the NOTICE file distributed with
            this(InternalAggregations.readFrom(in));
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
            bucket.toXContent(builder, params);
        this.targetNumBuckets = targetNumBuckets;
            this.centroid = centroid;
     * Then, this plan is actually executed and the underlying buckets are merged.
import org.opensearch.search.aggregations.Aggregations;
        EmptyBucketInfo(StreamInput in) throws IOException {
    }
            range.min = buckets.get(i).min();
 *
            BucketRange range = new BucketRange();
     */
                reducedBuckets.add(reduced);
        };
    }
    }
    private void adjustBoundsForOverlappingBuckets(List<Bucket> buckets, ReduceContext reduceContext) {
            builder.field(CommonFields.MAX.getPreferredName(), max());
        public double centroid() {
                toMerge.add(buckets.get(idx));
        public String getKeyAsString() {
        /**
        }
public class InternalVariableWidthHistogram extends InternalMultiBucketAggregation<
        return emptyBucketInfo;
            BucketRange range = plan.get(i);
 * this work for additional information regarding copyright
        return new Bucket(key.doubleValue(), new Bucket.BucketBounds(key.doubleValue(), key.doubleValue()), docCount, format, aggregations);
        /**
    /**
            String keyAsString = format.format((double) getKey()).toString();
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());
            centroid = in.readDouble();
        public int hashCode() {
 * Unless required by applicable law or agreed to in writing,
    @Override
            if (currentBuckets.isEmpty() == false) {
         * They're useful for determining whether buckets should be merged
        EmptyBucketInfo emptyBucketInfo,
                }
        // Each range represents a set of adjacent bucket indices of buckets that will be merged together
        }
        if (reduceContext.isFinalReduce()) {
     * This method should not be called for this specific subclass of InternalHistogram, since there should not be
                    reduceContext.consumeBucketsAndMaybeBreak(1);
            range.endIdx = i;
    }
                this(in.readDouble(), in.readDouble());
            BucketRange nextRange = ranges.get(i + 1);
            }
 * not use this file except in compliance with the License.
import java.util.Map;
            this.docCount = docCount;
     * Bucket for an internal variable width histogram
    @Override
 * The OpenSearch Contributors require contributions made to
            range.centroid = buckets.get(i).centroid;
    static class EmptyBucketInfo {
        public double min() {
        return Collections.unmodifiableList(buckets);
        @Override
 * GitHub history for details.
            Bucket merged_bucket = reduceBucket(toMerge, reduceContext);
        int targetNumBuckets,
        }
                docCount += other.docCount;
        // Create a merge plan
            EmptyBucketInfo that = (EmptyBucketInfo) obj;
         * are buckets, which is incorrect.
import java.util.List;
            mergeBucketsWithSameMin(reducedBuckets, reduceContext);
            max = Math.max(max, bucket.bounds.max);
                    pq.updateTop();
                return Double.compare(a.current().centroid, b.current().centroid) < 0;
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
                buckets.remove(idx);
 * Aggregator supplier interface for an internal variable width histogram agg
            for (int idx = endIdx; idx > startIdx; idx--) {
        int startIdx;
         */
        }
                    key = top.current().centroid();
    }
    @Override
 *
        }
        }
         */
    }
        // convert buckets to the right type
            reduceContext.consumeBucketsAndMaybeBreak(-toRemove + 1);
                    reducedBuckets.add(reduced);
        private double centroid;
                IteratorAndCurrent<Bucket> top = pq.top();
                return false;
                prevBucket.bounds.max = curBucket.bounds.min;
     * from <code>buckets</code> are merged, and this merged bucket replaces the entire range.
 * Licensed to Elasticsearch under one or more contributor
            }
        buckets2 = Collections.unmodifiableList(buckets2);
    @Override
    @Override
        while (ranges.size() > targetNumBuckets) {
    InternalVariableWidthHistogram.Bucket> implements Histogram, HistogramFactory {
        }
        this.emptyBucketInfo = emptyBucketInfo;
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), keyAsString);
        // Initialize each range to represent an individual bucket
            builder.field(CommonFields.KEY.getPreferredName(), getKey());
     * When two adjacent buckets A, B overlap (A.max &gt; B.min) then their boundary is set to
        }
            if (obj == null || obj.getClass() != InternalVariableWidthHistogram.Bucket.class) {
    public InternalVariableWidthHistogram(StreamInput in) throws IOException {
                    // The key changes, reduce what we already buffered and reset the buffer for current buckets.
 * Modifications Copyright OpenSearch Contributors. See
        public Object getKey() {
            InternalVariableWidthHistogram.Bucket that = (InternalVariableWidthHistogram.Bucket) obj;
        return format;
            List<Bucket> toMerge = new ArrayList<>();
            this.aggregations = aggregations;
                assert min <= max;
    }
            bounds = new BucketBounds(in);
    private double nextKey(double key) {
            int closestIdx = 0; // After this loop, (closestIdx, closestIdx + 1) will be the 2 closest buckets
                centroid = ((centroid * docCount) + (other.centroid * other.docCount)) / (docCount + other.docCount);
    public Number nextKey(Number key) {
    }
import org.apache.lucene.util.PriorityQueue;
            ranges.remove(closestIdx + 1);
        emptyBucketInfo = new EmptyBucketInfo(in);
 */
        buckets = in.readList(stream -> new Bucket(stream, format));
            aggregations.writeTo(out);
                    final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
        out.writeList(buckets);
        public double max() {
        List<Bucket> reducedBuckets = new ArrayList<>();
            sum += bucket.docCount * bucket.centroid;
        return Objects.hash(super.hashCode(), buckets, format, emptyBucketInfo);
                    smallest_distance = new_distance;
                    currentBuckets.clear();
            }
                i++;
        private final BucketBounds bounds;
     *
        public void mergeWith(BucketRange other) {
            }
        public void writeTo(StreamOutput out) throws IOException {
        }
                currentBuckets.add(top.current());
        }
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
    private final DocValueFormat format;
 */
    }
            return format;
        return new InternalVariableWidthHistogram(getName(), reducedBuckets, emptyBucketInfo, targetNumBuckets, format, metadata);
 *
    public int getTargetBuckets() {
            if (format != DocValueFormat.RAW) {
            builder.field(CommonFields.MIN.getPreferredName(), min());
        for (int i = 1; i < buckets.size(); i++) {
    public int hashCode() {
                if (obj == null || getClass() != obj.getClass()) return false;
    @Override
 * ownership. Elasticsearch licenses this file to you under
        public int hashCode() {
            return docCount;
                if (Double.compare(top.current().centroid(), key) != 0) {
        while (i < ranges.size() - 1) {
        }
    @Override
            if (range.min == nextRange.min) {
    }
    @Override
        public int compareKey(InternalVariableWidthHistogram.Bucket other) {
                return min == that.min && max == that.max;
                out.writeDouble(max);
        InternalVariableWidthHistogram that = (InternalVariableWidthHistogram) obj;
     * @opensearch.internal
            this.format = format;
        @Override
    private final int targetNumBuckets;
import java.util.Collections;
            Bucket prevBucket = buckets.get(i - 1);
        }
        final InternalAggregations subAggregations;
 * compatible open source license.
            public void writeTo(StreamOutput out) throws IOException {
            this.format = format;
            BucketRange range = new BucketRange();
                return false;
    }
         * we want the bucket's key to be its min. Otherwise, it would look like the distances between centroids
            return centroid;
        for (int i = 0; i < buckets.size(); i++) {
                ranges.remove(i + 1);
        List<Bucket> buckets2 = new ArrayList<>(buckets.size());
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        // Continually merge the two closest ranges until the target is reached
/*
            docCount = in.readVLong();
    }
/*
                    top.next();
    InternalVariableWidthHistogram(
            do {
            if (startIdx == endIdx) continue;
        }
        }
    /**
        List<Bucket> buckets,
        int i = 0;
            }
        mergeBucketsIfNeeded(reducedBuckets, targetNumBuckets, reduceContext);
        targetNumBuckets = in.readVInt();
            @Override
        super(in);
            buckets2.add((Bucket) b);
    public InternalVariableWidthHistogram create(List<Bucket> buckets) {
    final EmptyBucketInfo emptyBucketInfo;
     */
    }
                pq.add(new IteratorAndCurrent(histogram.buckets.iterator()));
                if (top.hasNext()) {
        return new InternalVariableWidthHistogram(name, buckets, emptyBucketInfo, targetNumBuckets, format, metadata);
        return VariableWidthHistogramAggregationBuilder.NAME;
        /**
import org.opensearch.core.xcontent.XContentBuilder;
            if (histogram.buckets.isEmpty() == false) {
    }
    /**
        // Make a plan for getting the target number of buckets
                curBucket.bounds.min = (prevBucket.bounds.max + curBucket.bounds.min) / 2;
        }
 * You may obtain a copy of the License at
            out.writeDouble(centroid);
                builder.field(CommonFields.MIN_AS_STRING.getPreferredName(), format.format(min()));
            // We only have to make one pass through the list because it is sorted by centroid
        for (Bucket bucket : buckets) {
        int endIdx;
    InternalVariableWidthHistogram,
    @Override
        List<BucketRange> ranges = new ArrayList<>();
            double key = pq.top().current().centroid();
        }
            return Objects.equals(subAggregations, that.subAggregations);
        public Bucket(double centroid, BucketBounds bounds, long docCount, DocValueFormat format, InternalAggregations aggregations) {
    =    */
import org.opensearch.search.aggregations.InternalAggregations;
            public int hashCode() {
            this.bounds = bounds;
            @Override
        }
            public BucketBounds(double min, double max) {
        return Objects.equals(buckets, that.buckets)
         * These are optional utility fields
    }
        }
    }
     * <p>
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Histogram.Bucket, KeyComparable<Bucket> {
        this.buckets = buckets;
            range.docCount = buckets.get(i).getDocCount();
                final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
            if (format != DocValueFormat.RAW) {
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
     *
            }
        for (int i = 0; i < buckets.size(); i++) {
                }
         *
                && bounds.equals(that.bounds)
        public Bucket(StreamInput in, DocValueFormat format) throws IOException {
                this.min = min;
        @Override
    public List<Bucket> reduceBuckets(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            for (int i = 0; i < ranges.size() - 1; i++) {
            bounds.writeTo(out);
        }
        EmptyBucketInfo(InternalAggregations subAggregations) {
            if (docCount + other.docCount > 0) {
            int toRemove = toMerge.stream().mapToInt(b -> countInnerBucket(b) + 1).sum();
    private List<Bucket> buckets;
import org.opensearch.search.DocValueFormat;
        public DocValueFormat getFormatter() {
            }
                if (this == obj) return true;
         * @opensearch.internal
        }
            ranges.add(range);
            buckets.set(startIdx, merged_bucket);
                range.mergeWith(nextRange);
            }
        // Merge ranges with same min value
package org.opensearch.search.aggregations.bucket.histogram;
                double new_distance = ranges.get(i + 1).centroid - ranges.get(i).centroid; // Positive because buckets is sorted
            out.writeVLong(docCount);
            min = Math.min(min, other.min);
            range.startIdx = i;
            return format.format((double) getKey()).toString();
        return reducedBuckets;
            // list of buckets coming from different shards that have the same key
    DocValueFormat getFormatter() {
        }
            }
            && Objects.equals(format, that.format)
                out.writeDouble(min);
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
            public double min;
                BucketBounds that = (BucketBounds) obj;
            BucketRange range = ranges.get(i);
            subAggregations.writeTo(out);
        PriorityQueue<IteratorAndCurrent<Bucket>> pq = new PriorityQueue<IteratorAndCurrent<Bucket>>(aggregations.size()) {
import java.util.ArrayList;
        if (obj == null || getClass() != obj.getClass()) return false;
            protected boolean lessThan(IteratorAndCurrent<Bucket> a, IteratorAndCurrent<Bucket> b) {
     * After this adjustment, A will contain more values than indicated and B will have less.
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);
            public boolean equals(Object obj) {
        double sum = 0;
    class BucketRange {
    @Override
 * software distributed under the License is distributed on an
 * under the License.
        return builder;
            && Objects.equals(emptyBucketInfo, that.emptyBucketInfo);
    private void mergeBucketsWithPlan(List<Bucket> buckets, List<BucketRange> plan, ReduceContext reduceContext) {
                    pq.pop();
        }
            this.subAggregations = subAggregations;
            adjustBoundsForOverlappingBuckets(reducedBuckets, reduceContext);
                // TODO: Think of a fairer way to do this. Should prev.max = cur.min?
            // Since buckets is sorted by centroid, ranges will be as well
        super(name, metaData);
        }
        List<BucketRange> ranges = new ArrayList<>();
     */
        public Aggregations getAggregations() {
        private long docCount;
    public List<Bucket> getBuckets() {
    }
            range.startIdx = i;
                    closestIdx = i;
            public BucketBounds(StreamInput in) throws IOException {
        public long getDocCount() {
    private void mergeBucketsWithSameMin(List<Bucket> buckets, ReduceContext reduceContext) {
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
            return Double.compare(centroid, other.centroid); // Use centroid for bucket ordering
        return new Bucket(prototype.centroid, prototype.bounds, prototype.docCount, prototype.format, aggregations);
    }
