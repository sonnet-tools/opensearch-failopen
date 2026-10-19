 * ownership. Elasticsearch licenses this file to you under  
            aggregations.add((InternalAggregations) bucket.getAggregations());
            if (false == agg.buckets.isEmpty()) {
            current.max
        );
 * Licensed to Elasticsearch under one or more contributor  
    public DateHistogramInterval getInterval() {
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
        bucketInfo.writeTo(out);
 * not use this file except in compliance with the License.
                reducedBuckets.add(reduced);  
 * GitHub history for details.
            Bucket nextBucket = list.get(iter.nextIndex());  
        return min <= max ? rounding.prepare(min, max) : rounding.prepareForUnknown();
        for (int i = 0; i < current.buckets.size(); i++) {
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
                } else {
            protected boolean lessThan(IteratorAndCurrent<Bucket> a, IteratorAndCurrent<Bucket> b) {
        InternalAutoDateHistogram that = (InternalAutoDateHistogram) obj;  
            docCount += bucket.docCount;
            if (Double.isNaN(key)) {  
        return new InternalAutoDateHistogram.Bucket(buckets.get(0).key, docCount, format, aggs);
import org.opensearch.search.aggregations.KeyComparable;
     * InternalDateHistogram#reduceBuckets(List, ReduceContext), the different
                assert key == nextBucket.key : "key: " + key + ", nextBucket.key: " + nextBucket.key;
        }  
        @Override
        do {
    @Override
        }
        out.writeNamedWriteable(format);  
    public int getTargetBuckets() {
    }  
            }
            this.format = format;
        super(in);
                    reducedBuckets.add(reduced);  
            current.roundingIdx,
        // accurate rounding value
        @Override
    @Override
import java.time.ZoneOffset;
        this.bucketInnerInterval = bucketInnerInterval;  
    public InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets) {  
            this.roundingInfos = roundings;
     * Bucket for the internal auto date histogram agg  
            for (int i = 0; i < size; i++) {
        if (pq.size() > 0) {
        @Override
 * KIND, either express or implied.  See the License for the
            long roundedBucketKey = reduceRounding.round(bucket.key);
        }
        }
        return new DateHistogramInterval(Long.toString(bucketInnerInterval) + unitAbbreviation);  
            bucketInfo.roundingInfos,
        List<Bucket> sameKeyedBuckets = new ArrayList<>();
        for (Bucket bucket : buckets) {  
        builder.endArray();  
            long max  
        final long key;  
        BucketInfo(RoundingInfo[] roundings, int roundingIdx, InternalAggregations subAggregations) {
        for (Bucket bucket : buckets) {  
        final long max;
        }  
                }
        if (sameKeyedBuckets.isEmpty() == false) {  
                    iter.add(new InternalAutoDateHistogram.Bucket(key, 0, format, reducedEmptySubAggs));
import org.opensearch.search.DocValueFormat;
        // e.g. if the data series is [1,2,3,7] there're 3 empty buckets that will be created for 4,5,6
            if (lastBucket != null) {
            // No need to take the keyed and format parameters into account,
            return Long.compare(key, other.key);  
        ListIterator<Bucket> iter = list.listIterator();  
     * Stream from a stream.
            } else if (roundedBucketKey == key) {  
            this.bucketInfo.emptySubAggregations
        Rounding.Prepared prepared = firstPassResult.preparedRounding;
        // merge buckets using the new rounding
            return format;
        for (InternalAggregation aggregation : aggregations) {
                    key = reduceRounding.round(top.current().key);
        }
        return new BucketReduceResult(buckets, idx, 1, prepared, firstPassResult.min, firstPassResult.max);  
    }  
        if (super.equals(obj) == false) return false;
            if (histogram.buckets.isEmpty() == false) {
        return current;  
                break;
                    currentBuckets.clear();
        }
            this.emptySubAggregations = subAggregations;
        // shards  
            this.bucketInfo.roundingInfos,  
        double key = Double.NaN;  
                key = current.preparedRounding.round(bucket.key);
            return docCount;  
        BucketInfo(StreamInput in) throws IOException {
            Bucket bucket = current.buckets.get(i);  
            emptySubAggregations.writeTo(out);
                pq.add(new IteratorAndCurrent(histogram.buckets.iterator()));
            if (obj == null || getClass() != obj.getClass()) {
        final InternalAggregations aggregations;
            list.get(0).key,
        RoundingInfo roundingInfo = this.bucketInfo.roundingInfos[this.bucketInfo.roundingIdx];
        if (this == obj) return true;
                sameKeyedBuckets.add(createBucket(key, bucket.docCount, bucket.aggregations));  
            reducedBucketsResult.roundingIdx,
        int requiredBuckets = 0;  
            reducedBucketsResult = mergeBucketsIfNeeded(reducedBucketsResult, reduceContext);
            lastBucket = iter.next();  
    @Override
        @Override  
    }
        Rounding.Prepared reduceRounding = prepare(reduceRoundingIdx, min, max);  
public final class InternalAutoDateHistogram extends InternalMultiBucketAggregation<
            format,
                if (reduceRounding.round(top.current().key) != key) {  
 * this work for additional information regarding copyright
            return Objects.hash(getClass(), key, docCount, aggregations);
        int targetBuckets,
            }
        Map<String, Object> metadata,
    /**  
            }
    public InternalAutoDateHistogram create(List<Bucket> buckets) {
            out.writeVInt(roundingIdx);
 */
            this.docCount = docCount;
     * @opensearch.internal
        BucketInfo emptyBucketInfo,
 * SPDX-License-Identifier: Apache-2.0
            }
        final List<Bucket> buckets;
 * Modifications Copyright OpenSearch Contributors. See  
     */  
            @Override  
     */  
            }  
            if (currentBuckets.isEmpty() == false) {
    public BucketInfo getBucketInfo() {  
                break;
        for (Object b : buckets) {  
    }  
                sameKeyedBuckets.add(createBucket(key, bucket.docCount, bucket.aggregations));
            List<Bucket> currentBuckets = new ArrayList<>();  
        return Objects.equals(buckets, that.buckets) && Objects.equals(format, that.format) && Objects.equals(bucketInfo, that.bucketInfo);
        }
        if (roundingIdx == roundings.length - 1) {  
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
/*  
        @Override
        Bucket lastBucket = null;
            builder.field(CommonFields.KEY.getPreferredName(), key);  
            String keyAsString = format.format(key).toString();
        // First we need to find the highest level rounding used across all the
        return targetBuckets;  
                return a.current().key < b.current().key;
            reducedBucketsResult.innerInterval  
    }
        @Override
                }  
            mergeInterval,
        // ranges at low roundings so get a rough estimate of the rounding first  
        int reduceRoundingIdx = 0;
            // list of buckets coming from different shards that have the same key
    public Number getKey(MultiBucketsAggregation.Bucket bucket) {
    }
                    assert top.current().key > key : "shards must return data sorted by key";  
    @Override
        String unitAbbreviation = roundingInfo.unitAbbreviation;
            BucketInfo that = (BucketInfo) obj;
    }
    }  
                final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
    public Bucket createBucket(Number key, long docCount, InternalAggregations aggregations) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.bucketInfo = emptyBucketInfo;  
        for (InternalAggregation aggregation : aggregations) {
    }  
            }  
 * Implementation of {@link Histogram}.  
        List<Bucket> buckets = firstPassResult.buckets;
            // adding empty buckets if needed
     * This method works almost exactly the same as  
    }  
            list.get(list.size() - 1).key,  
    @Override  
        /**  
    private final DocValueFormat format;
            return roundingIdx;
            targetBuckets,
            this.aggregations = aggregations;  
        List<Bucket> buckets2 = new ArrayList<>(buckets.size());
 */
import org.opensearch.core.xcontent.XContentBuilder;
        for (Bucket bucket : reducedBuckets) {
                if (top.hasNext()) {
     *
        return Objects.hash(super.hashCode(), buckets, format, bucketInfo);  
     * is the same and they can be reduced together.
                key = roundedBucketKey;
        protected final transient DocValueFormat format;  
 *
            idx++;
        };
    @Override  
    private List<Bucket> mergeBuckets(List<Bucket> reducedBuckets, Rounding.Prepared reduceRounding, ReduceContext reduceContext) {
            requiredBuckets = 0;
        return builder;
                key = roundedBucketKey;
            InternalAutoDateHistogram agg = ((InternalAutoDateHistogram) aggregation);
        }
        return new InternalAutoDateHistogram(name, buckets2, targetBuckets, bucketInfo, format, getMetadata(), bucketInnerInterval);
            return Objects.deepEquals(roundingInfos, that.roundingInfos)
        @Override  
import java.util.List;  
        return new BucketReduceResult(list, roundingIdx, 1, rounding, current.min, current.max);
        Rounding.Prepared rounding = current.roundingIdx == roundingIdx
            }
        this.targetBuckets = targetBuckets;
            this.key = key;
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
 * license agreements. See the NOTICE file distributed with
        this.format = formatter;
            reducedBucketsResult.buckets,
        public int hashCode() {
            sameKeyedBuckets.add(new Bucket(Math.round(key), bucket.docCount, format, bucket.aggregations));  
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
            } else if (i == roundingIdx - 1) {  
import java.util.ListIterator;
    }
    }
        }
        reducedBuckets = mergedBuckets;  
    public boolean equals(Object obj) {
                roundingInfos[i] = new RoundingInfo(in);
    static class BucketInfo {
            }
    private Rounding.Prepared prepare(int idx, long min, long max) {  
 *
        final Rounding.Prepared preparedRounding;
    }  
        long max = Long.MIN_VALUE;  
        reduceContext.consumeBucketsAndMaybeBreak(reducedBucketsResult.buckets.size());
        return bucketInfo;
        BucketInfo bucketInfo = new BucketInfo(
                sameKeyedBuckets.add(createBucket(key, bucket.docCount, bucket.aggregations));
import java.util.Collections;
        }  
            }  
    InternalAutoDateHistogram(
import org.opensearch.common.Rounding;
            mergedBuckets.add(reduceBucket(sameKeyedBuckets, reduceContext));
     * rounding returned across all the shards so the resolution of the buckets  
        while (buckets.size() > (targetBuckets * info.getMaximumInnerInterval()) && idx < bucketInfo.roundingInfos.length - 1) {  
        List<Bucket> reducedBuckets = new ArrayList<>();  
        }
            targetBuckets  
        return new InternalAutoDateHistogram(name, buckets, targetBuckets, bucketInfo, format, metadata, bucketInnerInterval);  
            // Adding empty buckets may have tipped us over the target so merge the buckets again if needed
     * The result from a bucket reduce  
            return Instant.ofEpochMilli(key).atZone(ZoneOffset.UTC);
        }
}
        // The loop will increase past the correct rounding index here so we  
        public DocValueFormat getFormatter() {  
        } while (requiredBuckets > (targetBuckets * roundings[currentRoundingIdx - 1].getMaximumInnerInterval())
        List<Bucket> list = current.buckets;  
                    top.next();
    }
            if (obj == null || obj.getClass() != InternalAutoDateHistogram.Bucket.class) {  
import java.util.Map;
         * Read from a stream.
 * You may obtain a copy of the License at  
        List<Bucket> mergedBuckets = new ArrayList<>();
                currentKey = currentRounding.nextRoundingValue(currentKey);
    private BucketReduceResult addEmptyBuckets(BucketReduceResult current, ReduceContext reduceContext) {
 */  
        int roundingIdx = getAppropriateRounding(
            current.roundingIdx,
        for (int i = currentRoundingIdx + 1; i < roundings.length; i++) {  
            }  
            bucket.toXContent(builder, params);
 * software distributed under the License is distributed on an
        InternalAggregations reducedEmptySubAggs = InternalAggregations.reduce(List.of(bucketInfo.emptySubAggregations), reduceContext);
     *
                    return mergeConsecutiveBuckets(current, interval, reduceContext);
    }
        );  
            ? current.preparedRounding  
        out.writeVInt(targetBuckets);
        buckets2 = Collections.unmodifiableList(buckets2);  
        final long min;  
        public Bucket(StreamInput in, DocValueFormat format) throws IOException {  
 * @opensearch.internal
                && Objects.equals(roundingIdx, that.roundingIdx)  
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder.RoundingInfo;
        super(name, metadata);
    public int hashCode() {
            return current;
        void writeTo(StreamOutput out) throws IOException {
        // need to subtract one to get the rounding index we need
            return aggregations;
    }
        format = in.readNamedWriteable(DocValueFormat.class);  
        this.targetBuckets = in.readVInt();
            this.preparedRounding = preparedRounding;
    }  
                }  
        return Collections.unmodifiableList(buckets);
    InternalAutoDateHistogram,
            reduceRoundingIdx = Math.max(agg.bucketInfo.roundingIdx, reduceRoundingIdx);  
     * here is that we need to round all the keys we see using the highest level
    }  
        }
            }
    }
            } else {
import java.time.Instant;
                if (buckets.size() % interval != 0) {
        @Override
                long key = rounding.nextRoundingValue(lastBucket.key);
    @Override
            roundingInfos = new RoundingInfo[size];  
        // convert buckets to the right type
            getMetadata(),
            return key == that.key && docCount == that.docCount && Objects.equals(aggregations, that.aggregations);  
            mergedBuckets.add(reduceBucket(sameKeyedBuckets, reduceContext));  
                currentBuckets.add(top.current());
    public List<InternalAutoDateHistogram.Bucket> getBuckets() {  
        return format;
        public int hashCode() {
    }
    /**
                final IteratorAndCurrent<Bucket> top = pq.top();
    private final List<Bucket> buckets;
            if (roughEstimateRequiredBuckets < targetBuckets * roundings[i].getMaximumInnerInterval()) {  
            this.format = format;  
        }
    private BucketReduceResult mergeConsecutiveBuckets(BucketReduceResult current, int mergeInterval, ReduceContext reduceContext) {  
        }
    public String getWriteableName() {
    InternalAutoDateHistogram.Bucket> implements Histogram, HistogramFactory {  
            } while (pq.size() > 0);
            // Now finally see if we need to merge consecutive buckets together to make a coarser interval at the same rounding
        }  
        // so we are at most 1 away from the correct rounding and then get the
        double key = current.preparedRounding.round(current.buckets.get(0).key);
    }
        }
package org.opensearch.search.aggregations.bucket.histogram;
    /**
            this.buckets = buckets;
        public boolean equals(Object obj) {
            for (RoundingInfo roundingInfo : roundingInfos) {
            }
        out.writeList(buckets);
                }  
            reducedBucketsResult = addEmptyBuckets(reducedBucketsResult, reduceContext);
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), keyAsString);
        bucketInfo = new BucketInfo(in);
        return bucketInfo.roundingInfos[bucketInfo.roundingIdx].rounding.nextRoundingValue(key.longValue());
            docCount = in.readVLong();  
            long min,
            aggregations.toXContentInternal(builder, params);
            aggregations.writeTo(out);  
        public String getKeyAsString() {
    }  
    }
        return mergeBucketsIfNeeded(new BucketReduceResult(reducedBuckets, reduceRoundingIdx, 1, reduceRounding, min, max), reduceContext);
            long roughEstimateRequiredBuckets = dataDuration / roundings[i].getRoughEstimateDurationMillis();
         */
    private final long bucketInnerInterval;
            return format.format(key).toString();
            && currentRoundingIdx < roundings.length);
                return false;
                int resultingBuckets = buckets.size() / interval;  
    }  
            out.writeVInt(roundingInfos.length);  
            this.max = max;
                && Objects.equals(emptySubAggregations, that.emptySubAggregations);
        int idx = firstPassResult.roundingIdx;
            this.roundingIdx = roundingIdx;  
    private final BucketInfo bucketInfo;  
    }
     * @opensearch.internal
        if (sameKeyedBuckets.isEmpty() == false) {
        public Object getKey() {  
        }
        // Add the empty buckets within the data,  
            }  
    @Override
        long min = Long.MAX_VALUE;
        RoundingInfo info = bucketInfo.roundingInfos[idx];  
        ) {
                    final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
            info = bucketInfo.roundingInfos[idx];
        final RoundingInfo[] roundingInfos;  
            if (i % mergeInterval == 0 && sameKeyedBuckets.isEmpty() == false) {
    }  
        return new BucketReduceResult(
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            long key = reduceRounding.round(pq.top().current().key);
            aggregations = InternalAggregations.readFrom(in);
        return reducedBuckets;
    }
 *
/**
        return currentRoundingIdx - 1;
            int size = in.readVInt();
            builder.endObject();  
                    pq.pop();  
        public Aggregations getAggregations() {
            long innerInterval,  
            this.min = min;  
    @Override  
                sameKeyedBuckets.clear();  
        List<Bucket> buckets,  
import java.util.ArrayList;  
        List<Bucket> buckets = current.buckets;
        final long docCount;
        }
        bucketInnerInterval = 1; // Calculated on merge.  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */  
    }
            buckets = mergeBuckets(buckets, prepared, reduceContext);
        final int roundingIdx;  
            this.innerInterval = innerInterval;
        builder.field("interval", getInterval().toString());
                    key = rounding.nextRoundingValue(key);
    DocValueFormat getFormatter() {
import org.opensearch.core.common.io.stream.StreamInput;
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
/*
        this.buckets = buckets;
import org.opensearch.search.aggregations.InternalAggregation;
            this.roundingIdx = roundingIdx;  
        if (list.isEmpty()) {
     * Information about the bucket  
        List<Bucket> sameKeyedBuckets = new ArrayList<>();
        if (obj == null || getClass() != obj.getClass()) return false;  
        }
    @Override
        BucketReduceResult(  
            getName(),  
 * the Apache License, Version 2.0 (the "License"); you may
                while (key < nextBucket.key) {  
                max = Math.max(max, agg.buckets.get(agg.buckets.size() - 1).key);  
        String name,
    }
            for (int interval : roundingInfo.innerIntervals) {
            while (currentKey < maxKey) {
        final long innerInterval;
import java.util.Objects;  
            Rounding.Prepared preparedRounding,
     * The interval within the rounding that the buckets are using.  
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);
        long bucketInnerInterval
            }
    private BucketReduceResult maybeMergeConsecutiveBuckets(BucketReduceResult current, ReduceContext reduceContext) {
    private BucketReduceResult reduceBuckets(List<InternalAggregation> aggregations, ReduceContext reduceContext) {  
        public Bucket(long key, long docCount, DocValueFormat format, InternalAggregations aggregations) {
                currentRoundingIdx = i;
    private static class BucketReduceResult {
            buckets2.add((Bucket) b);
        }  
        @Override  
        }  
                currentRoundingIdx = i - 1;
        if (reduceContext.isFinalReduce()) {  
        }
            Rounding currentRounding = roundings[currentRoundingIdx].rounding;
 * under the License.  
    /**
        assert buckets.size() > 0;  
        while (iter.hasNext()) {
    @Override  
    }
            // they are already stored and tested on the InternalDateHistogram object
            return builder;
        }
                mergedBuckets.add(reduceBucket(sameKeyedBuckets, reduceContext));  
            roundingIdx = in.readVInt();
import org.apache.lucene.util.PriorityQueue;  
            currentRoundingIdx++;  
        DocValueFormat formatter,  
        }  
    @Override  
        return new InternalAutoDateHistogram(
        buckets = in.readList(stream -> new Bucket(stream, format));
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
    /**
    ) {  
                }  
 * Unless required by applicable law or agreed to in writing,
        }
        RoundingInfo roundingInfo = bucketInfo.roundingInfos[current.roundingIdx];  
            reducedBucketsResult = maybeMergeConsecutiveBuckets(reducedBucketsResult, reduceContext);
        }
        }  
 * specific language governing permissions and limitations
    protected void doWriteTo(StreamOutput out) throws IOException {
            long currentKey = minKey;  
     */
            emptySubAggregations = InternalAggregations.readFrom(in);
        return AutoDateHistogramAggregationBuilder.NAME;
    /**
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
     * @opensearch.internal
            InternalAutoDateHistogram histogram = (InternalAutoDateHistogram) aggregation;  
            key = in.readLong();
        }
        }
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Histogram.Bucket, KeyComparable<Bucket> {
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
                    pq.updateTop();
            current.preparedRounding,  
        if (buckets.size() > targetBuckets) {
            bucketInfo,  
        }
            int roundingIdx,
import org.opensearch.search.aggregations.Aggregations;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        }
import org.opensearch.search.aggregations.InternalAggregations;
        @Override
        }
                mergedBuckets.add(reduceBucket(sameKeyedBuckets, reduceContext));
        List<Bucket> mergedBuckets = new ArrayList<>();  
 *  
            builder.startObject();
            long dataDuration = maxKey - minKey;
                min = Math.min(min, agg.buckets.get(0).key);
            out.writeLong(key);
        int currentRoundingIdx = roundingIdx;  
        public void writeTo(StreamOutput out) throws IOException {  
    public Number nextKey(Number key) {
            return Objects.hash(getClass(), Arrays.hashCode(roundingInfos), roundingIdx, emptySubAggregations);  
        public int compareKey(Bucket other) {
        Rounding rounding = bucketInfo.roundingInfos[idx].rounding;
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
                return false;
    }
 * compatible open source license.
    private BucketReduceResult mergeBucketsIfNeeded(BucketReduceResult firstPassResult, ReduceContext reduceContext) {
            prepared = prepare(idx, firstPassResult.min, firstPassResult.max);  
import java.util.Arrays;
        return new Bucket(key.longValue(), docCount, format, aggregations);  
                    // the key changes, reduce what we already buffered and reset the buffer for current buckets
        BucketReduceResult reducedBucketsResult = reduceBuckets(aggregations, reduceContext);
    public InternalAutoDateHistogram(StreamInput in) throws IOException {  
     */
            out.writeVLong(docCount);
        return new Bucket(prototype.key, prototype.docCount, prototype.format, aggregations);
            }  
        final int roundingIdx;
                if (resultingBuckets <= targetBuckets) {
                requiredBuckets++;  
    static int getAppropriateRounding(long minKey, long maxKey, int roundingIdx, RoundingInfo[] roundings, int targetBuckets) {
        long docCount = 0;
        list = mergeBuckets(list, rounding, reduceContext);  
        }
            mergedBuckets,  
        public long getDocCount() {
    // HistogramFactory method impls
                    resultingBuckets++;
/*
            current.min,
                sameKeyedBuckets.clear();
        );
            do {  
        final InternalAggregations emptySubAggregations;
        );  
    @Override  
     */
            InternalAutoDateHistogram.Bucket that = (InternalAutoDateHistogram.Bucket) obj;  
 */  
        // Getting the accurate number of required buckets can be slow for large
        public boolean equals(Object obj) {  
    private final int targetBuckets;
            List<Bucket> buckets,
        final PriorityQueue<IteratorAndCurrent<Bucket>> pq = new PriorityQueue<IteratorAndCurrent<Bucket>>(aggregations.size()) {
            : prepare(roundingIdx, current.min, current.max);
        return ((Bucket) bucket).key;  
            if (format != DocValueFormat.RAW) {  
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());
 * The OpenSearch Contributors require contributions made to  
                roundingInfo.writeTo(out);
     *
