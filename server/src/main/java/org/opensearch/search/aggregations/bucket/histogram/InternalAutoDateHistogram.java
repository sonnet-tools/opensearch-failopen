        final List<Bucket> buckets;
            }
import org.opensearch.search.aggregations.InternalAggregation;
 * Implementation of {@link Histogram}.
        final long docCount;
            aggregations.toXContentInternal(builder, params);
            out.writeVInt(roundingInfos.length);
                }
                }
 * You may obtain a copy of the License at
                    currentBuckets.clear();
            long roughEstimateRequiredBuckets = dataDuration / roundings[i].getRoughEstimateDurationMillis();
            mergedBuckets.add(reduceBucket(sameKeyedBuckets, reduceContext));
            this.docCount = docCount;
        }
        long docCount = 0;
            }
            emptySubAggregations.writeTo(out);
            if (roughEstimateRequiredBuckets < targetBuckets * roundings[i].getMaximumInnerInterval()) {
    private static class BucketReduceResult {
                    pq.pop();
        int reduceRoundingIdx = 0;
        return AutoDateHistogramAggregationBuilder.NAME;
        // Getting the accurate number of required buckets can be slow for large
            }
        while (iter.hasNext()) {
                if (reduceRounding.round(top.current().key) != key) {
                    pq.updateTop();
        for (int i = currentRoundingIdx + 1; i < roundings.length; i++) {
    }
    /**
            : prepare(roundingIdx, current.min, current.max);
        );
        @Override
    public Number getKey(MultiBucketsAggregation.Bucket bucket) {
        if (this == obj) return true;
            lastBucket = iter.next();
            this.preparedRounding = preparedRounding;
        }
        return mergeBucketsIfNeeded(new BucketReduceResult(reducedBuckets, reduceRoundingIdx, 1, reduceRounding, min, max), reduceContext);
            do {
            reduceRoundingIdx = Math.max(agg.bucketInfo.roundingIdx, reduceRoundingIdx);
                break;
        @Override
import org.apache.lucene.util.PriorityQueue;
    }
 * Modifications Copyright OpenSearch Contributors. See
        Rounding.Prepared rounding = current.roundingIdx == roundingIdx
        BucketReduceResult reducedBucketsResult = reduceBuckets(aggregations, reduceContext);
        ListIterator<Bucket> iter = list.listIterator();
    }
    }
            }
import org.opensearch.search.aggregations.InternalAggregations;
    private BucketReduceResult maybeMergeConsecutiveBuckets(BucketReduceResult current, ReduceContext reduceContext) {
        final PriorityQueue<IteratorAndCurrent<Bucket>> pq = new PriorityQueue<IteratorAndCurrent<Bucket>>(aggregations.size()) {
            }
    // HistogramFactory method impls
            targetBuckets
                sameKeyedBuckets.add(createBucket(key, bucket.docCount, bucket.aggregations));
 * Licensed to Elasticsearch under one or more contributor
                mergedBuckets.add(reduceBucket(sameKeyedBuckets, reduceContext));
            aggregations.add((InternalAggregations) bucket.getAggregations());
    protected Bucket reduceBucket(List<Bucket> buckets, ReduceContext context) {
            }
    private final List<Bucket> buckets;
            // they are already stored and tested on the InternalDateHistogram object
    }
            this.format = format;
        return new BucketReduceResult(
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
     *
                currentRoundingIdx = i - 1;
        final int roundingIdx;
                }
            prepared = prepare(idx, firstPassResult.min, firstPassResult.max);
     * @opensearch.internal
            return docCount;
import java.io.IOException;
        public boolean equals(Object obj) {
        InternalAggregations reducedEmptySubAggs = InternalAggregations.reduce(List.of(bucketInfo.emptySubAggregations), reduceContext);
                roundingInfo.writeTo(out);
        } while (requiredBuckets > (targetBuckets * roundings[currentRoundingIdx - 1].getMaximumInnerInterval())
                currentBuckets.add(top.current());
    @Override
            long max
     *
            targetBuckets,
        public Object getKey() {
            // Now finally see if we need to merge consecutive buckets together to make a coarser interval at the same rounding
        while (buckets.size() > (targetBuckets * info.getMaximumInnerInterval()) && idx < bucketInfo.roundingInfos.length - 1) {
        int roundingIdx = getAppropriateRounding(
            }
            List<Bucket> currentBuckets = new ArrayList<>();
            current.preparedRounding,
            buckets = mergeBuckets(buckets, prepared, reduceContext);
        return bucketInfo;
            if (obj == null || getClass() != obj.getClass()) {
            int size = in.readVInt();
        }
            current.min,
    public int hashCode() {
                long key = rounding.nextRoundingValue(lastBucket.key);
        }
        }
        }
        ) {
        return current;
 * this file be licensed under the Apache-2.0 license or a
        List<Bucket> buckets = current.buckets;
            info = bucketInfo.roundingInfos[idx];
        String unitAbbreviation = roundingInfo.unitAbbreviation;
     * Information about the bucket
            String keyAsString = format.format(key).toString();
                sameKeyedBuckets.clear();
     */
     *
            }
            builder.field(CommonFields.DOC_COUNT.getPreferredName(), docCount);
        protected final transient DocValueFormat format;
        public int hashCode() {
        this.bucketInnerInterval = bucketInnerInterval;
            reducedBucketsResult = maybeMergeConsecutiveBuckets(reducedBucketsResult, reduceContext);
            buckets2.add((Bucket) b);
    private BucketReduceResult mergeBucketsIfNeeded(BucketReduceResult firstPassResult, ReduceContext reduceContext) {
    }
                if (resultingBuckets <= targetBuckets) {
        public int compareKey(Bucket other) {
        return new InternalAutoDateHistogram(name, buckets, targetBuckets, bucketInfo, format, metadata, bucketInnerInterval);
    @Override
            // No need to take the keyed and format parameters into account,
    }
        final long innerInterval;
}
        Rounding.Prepared prepared = firstPassResult.preparedRounding;
        if (sameKeyedBuckets.isEmpty() == false) {
    private BucketReduceResult mergeConsecutiveBuckets(BucketReduceResult current, int mergeInterval, ReduceContext reduceContext) {
            // adding empty buckets if needed
        for (Bucket bucket : reducedBuckets) {
    }
                if (buckets.size() % interval != 0) {
    static int getAppropriateRounding(long minKey, long maxKey, int roundingIdx, RoundingInfo[] roundings, int targetBuckets) {
        return bucketInfo.roundingInfos[bucketInfo.roundingIdx].rounding.nextRoundingValue(key.longValue());
        DocValueFormat formatter,
     * @opensearch.internal
        public Aggregations getAggregations() {
        List<Bucket> sameKeyedBuckets = new ArrayList<>();
import java.util.ListIterator;
    @Override
        if (buckets.size() > targetBuckets) {
                    final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
 *
    /**
    }
import java.time.ZoneOffset;
            return Long.compare(key, other.key);
    private final int targetBuckets;
        return new BucketReduceResult(buckets, idx, 1, prepared, firstPassResult.min, firstPassResult.max);
        if (list.isEmpty()) {
    public Number nextKey(Number key) {
        for (InternalAggregation aggregation : aggregations) {
        return new Bucket(key.longValue(), docCount, format, aggregations);
    }
                min = Math.min(min, agg.buckets.get(0).key);
    @Override
                } else {
import java.util.Objects;
        // accurate rounding value
    @Override
        List<Bucket> list = current.buckets;
        List<Bucket> mergedBuckets = new ArrayList<>();
     * This method works almost exactly the same as
            mergedBuckets,
            roundingIdx = in.readVInt();
/**
        return targetBuckets;
        }
            }
    InternalAutoDateHistogram(
        return new InternalAutoDateHistogram.Bucket(buckets.get(0).key, docCount, format, aggs);
    public int getTargetBuckets() {
            }
import org.opensearch.core.common.io.stream.StreamInput;
        List<Bucket> buckets = firstPassResult.buckets;
        this.targetBuckets = in.readVInt();
            getName(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                sameKeyedBuckets.clear();
    private final DocValueFormat format;
        return min <= max ? rounding.prepare(min, max) : rounding.prepareForUnknown();
    }
        for (Object b : buckets) {
        super(name, metadata);
            return Objects.hash(getClass(), key, docCount, aggregations);
        int currentRoundingIdx = roundingIdx;
        this.buckets = buckets;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                mergedBuckets.add(reduceBucket(sameKeyedBuckets, reduceContext));
                builder.field(CommonFields.KEY_AS_STRING.getPreferredName(), keyAsString);
        final int roundingIdx;
            return Instant.ofEpochMilli(key).atZone(ZoneOffset.UTC);
        Bucket lastBucket = null;
            for (int i = 0; i < size; i++) {
     */
        }
        InternalAggregations aggs = InternalAggregations.reduce(aggregations, context);
        RoundingInfo roundingInfo = this.bucketInfo.roundingInfos[this.bucketInfo.roundingIdx];
     * @opensearch.internal
        BucketInfo(RoundingInfo[] roundings, int roundingIdx, InternalAggregations subAggregations) {
     * here is that we need to round all the keys we see using the highest level
            this.roundingInfos = roundings;
        }
        String name,
            }
        RoundingInfo roundingInfo = bucketInfo.roundingInfos[current.roundingIdx];
    public String getWriteableName() {
            long innerInterval,
        RoundingInfo info = bucketInfo.roundingInfos[idx];
            this.innerInterval = innerInterval;
        @Override
    }
        @Override
        /**
                return a.current().key < b.current().key;
        public String getKeyAsString() {
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder.RoundingInfo;
                return false;
        if (roundingIdx == roundings.length - 1) {
            if (false == agg.buckets.isEmpty()) {
    public BucketInfo getBucketInfo() {
        // so we are at most 1 away from the correct rounding and then get the
        Rounding.Prepared reduceRounding = prepare(reduceRoundingIdx, min, max);
            long key = reduceRounding.round(pq.top().current().key);
        }
                if (top.hasNext()) {
            List<Bucket> buckets,
    @Override
/*
                currentRoundingIdx = i;
            for (RoundingInfo roundingInfo : roundingInfos) {
        return Collections.unmodifiableList(buckets);
                key = roundedBucketKey;
                }
            long dataDuration = maxKey - minKey;
        if (sameKeyedBuckets.isEmpty() == false) {
            } else {
        assert buckets.size() > 0;
    }
         */
            } else if (i == roundingIdx - 1) {
        };
    private final BucketInfo bucketInfo;
        out.writeVInt(targetBuckets);
        }
        // ranges at low roundings so get a rough estimate of the rounding first
        }
        int idx = firstPassResult.roundingIdx;
    }
        }
        final long key;
        if (pq.size() > 0) {
    public InternalAggregation createAggregation(List<MultiBucketsAggregation.Bucket> buckets) {
        final long min;
                final Bucket reduced = reduceBucket(currentBuckets, reduceContext);
        List<Bucket> buckets2 = new ArrayList<>(buckets.size());
    private BucketReduceResult addEmptyBuckets(BucketReduceResult current, ReduceContext reduceContext) {
        @Override
        InternalAutoDateHistogram that = (InternalAutoDateHistogram) obj;
 */
            InternalAutoDateHistogram agg = ((InternalAutoDateHistogram) aggregation);
        double key = Double.NaN;
            return Objects.deepEquals(roundingInfos, that.roundingInfos)
        bucketInfo.writeTo(out);
    }
    }
import java.time.Instant;
                pq.add(new IteratorAndCurrent(histogram.buckets.iterator()));
            return aggregations;
        format = in.readNamedWriteable(DocValueFormat.class);
    @Override
            currentRoundingIdx++;
        public boolean equals(Object obj) {
        return new Bucket(prototype.key, prototype.docCount, prototype.format, aggregations);
        }
import java.util.List;
    InternalAutoDateHistogram,
            }
    private List<Bucket> mergeBuckets(List<Bucket> reducedBuckets, Rounding.Prepared reduceRounding, ReduceContext reduceContext) {
        }
            aggregations = InternalAggregations.readFrom(in);
        bucketInnerInterval = 1; // Calculated on merge.
            current.max
                sameKeyedBuckets.add(createBucket(key, bucket.docCount, bucket.aggregations));
    }
        builder.startArray(CommonFields.BUCKETS.getPreferredName());
        int requiredBuckets = 0;
            this.bucketInfo.roundingInfos,
    public DateHistogramInterval getInterval() {
            } else if (roundedBucketKey == key) {
        BucketReduceResult(
                    resultingBuckets++;
        for (Bucket bucket : buckets) {
            aggregations.writeTo(out);
        }
        }
        return new InternalAutoDateHistogram(name, buckets2, targetBuckets, bucketInfo, format, getMetadata(), bucketInnerInterval);
 * this work for additional information regarding copyright
     */
import org.opensearch.search.aggregations.KeyComparable;
    static class BucketInfo {
            Rounding.Prepared preparedRounding,
        final InternalAggregations emptySubAggregations;
            return builder;
                    key = rounding.nextRoundingValue(key);
                roundingInfos[i] = new RoundingInfo(in);
        buckets = in.readList(stream -> new Bucket(stream, format));
            reducedBucketsResult.roundingIdx,
    public InternalAutoDateHistogram(StreamInput in) throws IOException {
    public static class Bucket extends InternalMultiBucketAggregation.InternalBucket implements Histogram.Bucket, KeyComparable<Bucket> {
            this.buckets = buckets;
            }
/*
     * rounding returned across all the shards so the resolution of the buckets
     * is the same and they can be reduced together.
     * InternalDateHistogram#reduceBuckets(List, ReduceContext), the different
        this.targetBuckets = targetBuckets;
                }
 * ownership. Elasticsearch licenses this file to you under
            builder.field(CommonFields.KEY.getPreferredName(), key);
     */
        }
            return roundingIdx;
        List<Bucket> buckets,
            return current;
        }
        }
     * Stream from a stream.
        return new BucketReduceResult(list, roundingIdx, 1, rounding, current.min, current.max);
        reduceContext.consumeBucketsAndMaybeBreak(reducedBucketsResult.buckets.size());
        @Override
            this.emptySubAggregations = subAggregations;
        List<Bucket> reducedBuckets = new ArrayList<>();
        public int hashCode() {
    public Bucket createBucket(Number key, long docCount, InternalAggregations aggregations) {
     * The interval within the rounding that the buckets are using.
                int resultingBuckets = buckets.size() / interval;
        }
        }
    }
    }
 *
    }
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
                    assert top.current().key > key : "shards must return data sorted by key";
            idx++;
        final Rounding.Prepared preparedRounding;
        do {
        List<Bucket> sameKeyedBuckets = new ArrayList<>();
 */
 * specific language governing permissions and limitations
        void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
            this.format = format;
            if (lastBucket != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (obj == null || getClass() != obj.getClass()) return false;
            list.get(list.size() - 1).key,
                key = current.preparedRounding.round(bucket.key);
    private Rounding.Prepared prepare(int idx, long min, long max) {
        }
            return format;
            protected boolean lessThan(IteratorAndCurrent<Bucket> a, IteratorAndCurrent<Bucket> b) {
        );
        }
    @Override
            && currentRoundingIdx < roundings.length);
        final InternalAggregations aggregations;
        list = mergeBuckets(list, rounding, reduceContext);
    }
        final long max;
        // convert buckets to the right type
        public Bucket(long key, long docCount, DocValueFormat format, InternalAggregations aggregations) {
 *
        return new DateHistogramInterval(Long.toString(bucketInnerInterval) + unitAbbreviation);
 * KIND, either express or implied.  See the License for the
            mergeInterval,
            this.max = max;
            current.roundingIdx,
import org.opensearch.search.aggregations.bucket.IteratorAndCurrent;
        }
    }
            this.aggregations = aggregations;
            this.bucketInfo.emptySubAggregations
    /**
        public Bucket(StreamInput in, DocValueFormat format) throws IOException {
            out.writeVLong(docCount);
    public List<InternalAutoDateHistogram.Bucket> getBuckets() {
        // The loop will increase past the correct rounding index here so we
        return Objects.hash(super.hashCode(), buckets, format, bucketInfo);
 * license agreements. See the NOTICE file distributed with
    InternalAutoDateHistogram.Bucket> implements Histogram, HistogramFactory {
        }
            return key == that.key && docCount == that.docCount && Objects.equals(aggregations, that.aggregations);
                sameKeyedBuckets.add(createBucket(key, bucket.docCount, bucket.aggregations));
 * @opensearch.internal
            this.roundingIdx = roundingIdx;
        List<Bucket> mergedBuckets = new ArrayList<>();
                break;
            Bucket nextBucket = list.get(iter.nextIndex());
    }
                    // the key changes, reduce what we already buffered and reset the buffer for current buckets
        this.format = formatter;
        // e.g. if the data series is [1,2,3,7] there're 3 empty buckets that will be created for 4,5,6
        }
        }
            builder.endObject();
        public long getDocCount() {
        );
        @Override
        buckets2 = Collections.unmodifiableList(buckets2);
 * compatible open source license.
            builder.startObject();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.DocValueFormat;
        // Add the empty buckets within the data,
     */
        }
        }
    }
                    iter.add(new InternalAutoDateHistogram.Bucket(key, 0, format, reducedEmptySubAggs));
        @Override
    @Override
    /**
    }
        return new InternalAutoDateHistogram(
 * The OpenSearch Contributors require contributions made to
        BucketInfo emptyBucketInfo,
        List<InternalAggregations> aggregations = new ArrayList<>(buckets.size());
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
            docCount += bucket.docCount;
    @Override
        // shards
                reducedBuckets.add(reduced);
            InternalAutoDateHistogram histogram = (InternalAutoDateHistogram) aggregation;
        this.bucketInfo = emptyBucketInfo;
        for (Bucket bucket : buckets) {
 */
    @Override
        // merge buckets using the new rounding
            bucketInfo.roundingInfos,
            reducedBucketsResult = addEmptyBuckets(reducedBucketsResult, reduceContext);
            emptySubAggregations = InternalAggregations.readFrom(in);
     */
            }
        final RoundingInfo[] roundingInfos;
        double key = current.preparedRounding.round(current.buckets.get(0).key);
                    return mergeConsecutiveBuckets(current, interval, reduceContext);
        builder.field("interval", getInterval().toString());
    DocValueFormat getFormatter() {
        long max = Long.MIN_VALUE;
            this.roundingIdx = roundingIdx;
            bucket.toXContent(builder, params);
        for (InternalAggregation aggregation : aggregations) {
            // list of buckets coming from different shards that have the same key
            ? current.preparedRounding
            if (obj == null || obj.getClass() != InternalAutoDateHistogram.Bucket.class) {
    }
    }
     * Bucket for the internal auto date histogram agg
            }
        @Override
        );
                    reducedBuckets.add(reduced);
import java.util.Collections;
        int targetBuckets,
                final IteratorAndCurrent<Bucket> top = pq.top();
            // Adding empty buckets may have tipped us over the target so merge the buckets again if needed
        Rounding rounding = bucketInfo.roundingInfos[idx].rounding;
import org.opensearch.search.aggregations.Aggregations;
            if (i % mergeInterval == 0 && sameKeyedBuckets.isEmpty() == false) {
    }
            reducedBucketsResult = mergeBucketsIfNeeded(reducedBucketsResult, reduceContext);
        reducedBuckets = mergedBuckets;
        if (reduceContext.isFinalReduce()) {
            int roundingIdx,
            requiredBuckets = 0;
                currentKey = currentRounding.nextRoundingValue(currentKey);
    protected void doWriteTo(StreamOutput out) throws IOException {
                return false;
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
 *
 * under the License.
    @Override
package org.opensearch.search.aggregations.bucket.histogram;
/*
                && Objects.equals(roundingIdx, that.roundingIdx)
                max = Math.max(max, agg.buckets.get(agg.buckets.size() - 1).key);
 * GitHub history for details.
            mergedBuckets.add(reduceBucket(sameKeyedBuckets, reduceContext));
        super(in);
            roundingInfos = new RoundingInfo[size];
            } while (pq.size() > 0);
        BucketInfo(StreamInput in) throws IOException {
            out.writeVInt(roundingIdx);
            long currentKey = minKey;
     * The result from a bucket reduce
            BucketInfo that = (BucketInfo) obj;
            InternalAutoDateHistogram.Bucket that = (InternalAutoDateHistogram.Bucket) obj;
            Bucket bucket = current.buckets.get(i);
        // need to subtract one to get the rounding index we need
                    key = reduceRounding.round(top.current().key);
        return currentRoundingIdx - 1;
        return ((Bucket) bucket).key;
    private BucketReduceResult reduceBuckets(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
    private final long bucketInnerInterval;
            reducedBucketsResult.innerInterval
    @Override
        long bucketInnerInterval
                key = roundedBucketKey;
            if (histogram.buckets.isEmpty() == false) {
    /**
        bucketInfo = new BucketInfo(in);
    public InternalAutoDateHistogram create(List<Bucket> buckets) {
public final class InternalAutoDateHistogram extends InternalMultiBucketAggregation<
        public DocValueFormat getFormatter() {
 * Unless required by applicable law or agreed to in writing,
        }
            current.roundingIdx,
        long min = Long.MAX_VALUE;
    /**
        out.writeList(buckets);
            long roundedBucketKey = reduceRounding.round(bucket.key);
            docCount = in.readVLong();
            while (currentKey < maxKey) {
    public boolean equals(Object obj) {
        // First we need to find the highest level rounding used across all the
            if (Double.isNaN(key)) {
            format,
            sameKeyedBuckets.add(new Bucket(Math.round(key), bucket.docCount, format, bucket.aggregations));
        out.writeNamedWriteable(format);
    }
            reducedBucketsResult.buckets,
            long min,
import org.opensearch.core.xcontent.XContentBuilder;
         * Read from a stream.
            if (format != DocValueFormat.RAW) {
        BucketInfo bucketInfo = new BucketInfo(
        return Objects.equals(buckets, that.buckets) && Objects.equals(format, that.format) && Objects.equals(bucketInfo, that.bucketInfo);
            list.get(0).key,
 */
            Rounding currentRounding = roundings[currentRoundingIdx].rounding;
        return reducedBuckets;
        }
 * software distributed under the License is distributed on an
import java.util.ArrayList;
                while (key < nextBucket.key) {
            out.writeLong(key);
                assert key == nextBucket.key : "key: " + key + ", nextBucket.key: " + nextBucket.key;
        if (super.equals(obj) == false) return false;
    ) {
            for (int interval : roundingInfo.innerIntervals) {
                && Objects.equals(emptySubAggregations, that.emptySubAggregations);
    public Bucket createBucket(InternalAggregations aggregations, Bucket prototype) {
                requiredBuckets++;
        }
        @Override
        }
            getMetadata(),
import java.util.Map;
            @Override
            bucketInfo,
        return format;
        builder.endArray();
            return Objects.hash(getClass(), Arrays.hashCode(roundingInfos), roundingIdx, emptySubAggregations);
        return builder;
            return format.format(key).toString();
        public void writeTo(StreamOutput out) throws IOException {
 * not use this file except in compliance with the License.
import java.util.Arrays;
    }
            key = in.readLong();
import org.opensearch.common.Rounding;
            this.key = key;
        @Override
                    top.next();
            this.min = min;
    public InternalAggregation reduce(List<InternalAggregation> aggregations, ReduceContext reduceContext) {
        for (int i = 0; i < current.buckets.size(); i++) {
        Map<String, Object> metadata,
    }
        }
            if (currentBuckets.isEmpty() == false) {
