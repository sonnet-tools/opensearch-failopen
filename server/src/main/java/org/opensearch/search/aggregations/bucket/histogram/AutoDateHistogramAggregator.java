 * The OpenSearch Contributors require contributions made to  
            // If we are already using the rounding with the largest interval nothing can be done
        this.targetBuckets = targetBuckets;
         */  
        return filterRewriteOptimizationContext.tryOptimize(
     * quite a spread out compared to the rounding.
                return canOptimize(valuesSourceConfig, roundingInfos[0].rounding);
     * When promoting a rounding we keep the old buckets around because it is
            @Override  
            long oldRoughDuration = roundingInfos[oldRounding].roughEstimateDurationMillis;  
                mins.fill(oldSize, mins.size(), Long.MAX_VALUE);
                        long oldKey = ordsEnum.value();
                    merge(mergeMap, bucketOrds.size());
                    (owningBucketOrd) -> preparedRoundings[roundingIndexFor(owningBucketOrd)],
 * An aggregator for date values that attempts to return a specific number of
         * {@link #rebucket() rebucketing}.
            preparedRoundings[0] = roundingPreparer.apply(roundingInfos[0].rounding);
            maxes.set(owningBucketOrd, preparedRoundings[newRounding].round(maxes.get(owningBucketOrd)));  
            ValuesSourceConfig valuesSourceConfig,
     * the "shape" of the roundings is <strong>roughly</strong>  
         * currently using.
        private int increaseRoundingIfNeeded(long owningBucketOrd, int oldEstimatedBucketCount, long newKey, int oldRounding) {
                    int valuesCount = values.docValueCount();
            } while (roundingIdx < roundingInfos.length - 1  
                return new HistogramSkiplistLeafCollector(
            }
                        liveBucketCountUnderestimate = context.bigArrays().grow(liveBucketCountUnderestimate, owningBucketOrd + 1);
     * called it frequently we'd end up in {@code O(n^2)} territory. Bad news for
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
             * 2. [targetBuckets * roundingInfos[roundingIdx].getMaximumRoughEstimateDurationMillis()]
        }
        RoundingInfo[] roundingInfos,  
             * The filter rewrite optimization uses this method to pre-emptively update the preparedRounding
    protected final InternalAggregation[] buildAggregations(  
    public final LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    }  
        private void setRounding(long owningBucketOrd, int newRounding) {  
        // TODO: Remove null usage here, by using a different aggregator for create  
         * The minimum key per {@code owningBucketOrd}.
            };  
            if (mins.size() < owningBucketOrd + 1) {
                    liveBucketCountUnderestimate.set(owningBucketOrd, Math.toIntExact(bucketOrds.bucketsInOrd(owningBucketOrd)));
    }
         */  
    private final String fieldName;
        InternalAutoDateHistogram.BucketInfo emptyBucketInfo = new InternalAutoDateHistogram.BucketInfo(
        private void rebucket() {
             */
        DocValuesSkipper skipper = null;
                // value source will be null for unmapped fields
import org.opensearch.common.Rounding;
            return new LeafBucketCollectorBase(sub, values) {
        deferringCollector = new MergingBucketsDeferringCollector(context, descendsFromGlobalAggregator(parent()));
        return buildAggregationsForVariableBuckets(
            int targetBuckets,
                    while (ordsEnum.next()) {
        this.formatter = valuesSourceConfig.format();
        this.roundingInfos = roundingInfos;  
import org.apache.lucene.util.CollectionUtil;
                newRounding++;
/*
     * that are valid for the current rounding exceeds the budget then we rebucket
                    Rounding.Prepared preparedRounding = preparedRoundings[roundingIndexFor(owningBucketOrd)];  
            }
     * as more data arrives it uses two heuristics to shift to coarser and coarser
            ? ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName()
                public void collectRange(int min, int max) throws IOException {  
 * data arrives.
         * correct the error when we merge the buckets together all the way  
                @Override  
                );
import java.io.IOException;
                    super.collect(stream, owningBucketOrd);
 * license agreements. See the NOTICE file distributed with
                // Bump the threshold for the next rebucketing
     * In particular it is {@code O(number_of_hits_collected_so_far)}. So if we  
        int targetBuckets,
                    super.collectRange(min, max);
        String name,  
         * Map from value to bucket ordinals.
        );
        /**
     * doesn't delay rebucketing.
     */  
    protected int roundingIdx;
         * preparedRounding is required to keep total bucket count in compliance with targetBuckets.
        return roundingPreparer.apply(roundingInfos[index].rounding);
            }
         * {@link LongKeyedBucketOrds} so that the JVM can make a monomorphic  
    protected final int targetBuckets;
 * not use this file except in compliance with the License.
                return oldRounding;
                @Override
            @Override
         * Map from value to bucket ordinals.  
                    skipper,
                }  
                parent,
            try (LongKeyedBucketOrds oldOrds = bucketOrds) {  
        Map<String, Object> metadata  
            if (HistogramSkiplistLeafCollector.canUseSkiplist(null, parent, skipper, singleton)) {
        @Override
        }  
 */
 * software distributed under the License is distributed on an
        Function<Rounding, Rounding.Prepared> roundingPreparer,
                    roundingIndexFor.applyAsInt(owningBucketOrd),
import org.opensearch.search.aggregations.InternalAggregation;
     * @opensearch.internal
            @Override
            );  
    /**
                factories,
         * During collection we use overestimates for how much buckets are save  
            long min = Math.min(mins.get(owningBucketOrd), newKey);
            throws IOException {
     * {@linkplain FromMany} it keeps an accurate count of the buckets and it
         * aggressively than a "perfect" algorithm. That is fine because we
                roundingInfos,
                name,
        AggregatorFactories factories,
            }
        private long min = Long.MAX_VALUE;
import org.opensearch.common.lease.Releasables;
                            continue;
                }
            }
         * The index of the rounding that each {@code owningBucketOrd} is  
            roundingIndices = context.bigArrays().grow(roundingIndices, owningBucketOrd + 1);
                valuesSourceConfig,
        Function<Rounding, Rounding.Prepared> roundingPreparer,
    private final ValuesSource.Numeric valuesSource;  
import org.opensearch.search.aggregations.LeafBucketCollector;
                maxes.fill(oldSize, maxes.size(), Long.MIN_VALUE);
        }
import org.opensearch.search.aggregations.CardinalityUpperBound;  
     * {@link MergingBucketsDeferringCollector#mergeBuckets(long[])}.
        }  
                private void collectValue(int doc, long rounded) throws IOException {
     * the distance between the min and max bucket. When that distance is greater
                private int collectValue(long owningBucketOrd, int roundingIdx, int doc, long rounded) throws IOException {
        );  
        return deferringCollector;
            return owningBucketOrd < roundingIndices.size() ? roundingIndices.get(owningBucketOrd) : 0;  
        }  
import org.opensearch.core.common.util.ByteArray;
            }  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override  
    protected final RoundingInfo[] roundingInfos;  
                        bucketOrd = -1 - bucketOrd;
         * The number of times the aggregator had to {@link #rebucket()} the
            buildEmptySubAggregations()
            skipper = ctx.reader().getDocValuesSkipper(this.fieldName);  
                    liveBucketCountUnderestimate = context.bigArrays().grow(liveBucketCountUnderestimate, owningBucketOrd + 1);  
            roundingInfos,
            AggregatorFactories factories,
        return super.scoreMode();  
             * our rounding.
                    final int temp = curRoundingInfo.innerIntervals[curRoundingInfo.innerIntervals.length - 1];
            // Check if skiplist optimization is available  
        FromSingle(
            return new LeafBucketCollectorBase(sub, values) {
                valuesSourceConfig,
            return buildAggregations(bucketOrds, this::roundingIndexFor, owningBucketOrds);
        }
     * min and max.  
 * this work for additional information regarding copyright
                    for (int i = 0; i < valuesCount; ++i) {  
            // Prepare the first rounding because we know we'll need it.  
 *  
         * It is important that this is the exact subtype of
                @Override  
                        mergeMap[(int) ordsEnum.ord()] = newBucketOrd >= 0 ? newBucketOrd : -1 - newBucketOrd;
 * Modifications Copyright OpenSearch Contributors. See  
                // Increment skiplist collector count  
                        long oldKey = ordsEnum.value();
    }
            protected boolean canOptimize() {  
import org.opensearch.search.aggregations.bucket.HistogramSkiplistLeafCollector;  
        public void collectDebugInfo(BiConsumer<String, Object> add) {  
                && (bucketOrds.size() > targetBuckets * roundingInfos[roundingIdx].getMaximumInnerInterval()
 */
        long[] owningBucketOrds  
            // Re calculate the max and min values we expect to bucket according to most recently rounded val  
         * An underestimate of the number of buckets that are "live" in the
     * rounding. The first heuristic is the number of buckets, specifically,
                    if (bestDuration <= temp * curRoundingInfo.roughEstimateDurationMillis) {
         */
            ValuesSourceConfig valuesSourceConfig,  
                }
         * Examine our current bucket count and the most recently added bucket to determine if an update to
                && max - min <= targetBuckets * roundingInfos[oldRounding].getMaximumRoughEstimateDurationMillis()) {  
                if (roundingIdx > prevRoundingIdx) {  
                    bucketOrds = new LongKeyedBucketOrds.FromSingle(context.bigArrays());
        @Override
 * implementation when it doesn't. This ain't great from a test coverage
import org.apache.lucene.index.NumericDocValues;  
        ) throws IOException {  
                return oldRounding;  
 */  
             * DAYS_OF_MONTH rounding where the maximum inner interval is 7 days (i.e. 1 week buckets).
            if (maxes.size() < owningBucketOrd + 1) {
                return new HistogramSkiplistLeafCollector(
                mins = context.bigArrays().grow(mins, owningBucketOrd + 1);
     * <p>
    private final FilterRewriteOptimizationContext filterRewriteOptimizationContext;  
 * SPDX-License-Identifier: Apache-2.0
             * skips doc collection entirely which is where the preparedRounding is normally updated.  
         * The next {@link #wastedBucketsOverestimate} that will trigger a  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
     * expensive to call {@link MergingBucketsDeferringCollector#mergeBuckets}.
        LeafBucketCollector sub
                return new InternalAutoDateHistogram(name, buckets, targetBuckets, emptyBucketInfo, formatter, metadata(), 1);  
 * Unless required by applicable law or agreed to in writing,
    protected final boolean shouldDefer(Aggregator aggregator) {
                docCount,
        return true;
package org.opensearch.search.aggregations.bucket.histogram;
         */
        /**
         * {@link #roundingInfos}. The 0th entry is prepared initially,
            if (oldRounding >= roundingInfos.length - 1) {
        }  
                bucketOrds = new LongKeyedBucketOrds.FromMany(context.bigArrays());  
            } else {
        private LongKeyedBucketOrds.FromMany bucketOrds;
     * <p>  
import org.apache.lucene.search.DocIdStream;
        @Override
            if (wastedBucketsOverestimate > nextRebucketAt) {
        public void collectDebugInfo(BiConsumer<String, Object> add) {
                public void collect(int doc, long owningBucketOrd) throws IOException {
                        if (rounded == previousRounded) {
                skiplistCollectorCount++;
                        }  
                targetBuckets,  
        this.preparedRounding = prepareRounding(0);
            super(
            }
            preparedRoundings = new Rounding.Prepared[roundingInfos.length];
        private long max = Long.MIN_VALUE;  
                        if (rounded == previousRounded) {
        @Override  
                        int estimatedBucketCount = liveBucketCountUnderestimate.increment(owningBucketOrd, 1);
                        collectExistingBucket(sub, doc, bucketOrd);
            setRounding(owningBucketOrd, newRounding);
                return;  
         * The max key per {@code owningBucketOrd}.  
                // max - min / targetBuckets = bestDuration
                        long newKey = preparedRounding.round(oldKey);  
                roundingInfos,
         */  
            final NumericDocValues singleton = DocValues.unwrapSingleton(values);
        private LongArray mins;
             *
            /*
     * bucket count and range of the aggregation, but unlike  
        String name,  
                roundingPreparer,
        private int skiplistCollectorCount = 0;  
                        return;
    }
        }
                    }  
        if (valuesSource != null && valuesSource.needsScores()) {  
             * @param low lower bound of rounding to prepare
         *  
        /**
            if (bucketOrds.size() <= targetBuckets * roundingInfos[roundingIdx].getMaximumInnerInterval()  
        Aggregator parent,
                parent,
import org.opensearch.common.Rounding.Prepared;  
                return;
            ctx,
    }
            max = Math.max(max, rounded);
         * and other entries are null until first needed.
import org.opensearch.search.aggregations.AggregatorFactories;
            0,  
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder.RoundingInfo;
    @Override
    static AutoDateHistogramAggregator build(
                    collectBucket(sub, doc, bucketOrd);
        return cardinality == CardinalityUpperBound.ONE
                targetBuckets,
     * Initially it uses the most fine grained rounding configuration possible  
                        int roundingIdx = roundingIndexFor(owningBucketOrd);  
            String name,
import java.util.Map;  
                }
                InternalAutoDateHistogram.BucketInfo emptyBucketInfo = new InternalAutoDateHistogram.BucketInfo(  
             * when considering the optimized path for a single segment. This is necessary since the optimized path
                // since we cannot exceed targetBuckets, bestDuration should go up,  
            if (roundingIdx >= roundingInfos.length - 1) {
import org.apache.lucene.index.SortedNumericDocValues;
                    while (ordsEnum.next()) {
        }
     * <strong>that</strong> as the initial value for the bucket count that it  
                    singleton,
        private LongArray maxes;
                        bucketOrd = -1 - bucketOrd;
    private final Function<Rounding, Rounding.Prepared> roundingPreparer;
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        FromMany(  
    /**  
                    if (false == values.advanceExact(doc)) {
                bucketValue,  
         */  
                roundingInfos,  
import org.opensearch.search.aggregations.Aggregator;  
            collectableSubAggregators
         * <p>
         * too high we {@link #rebucket} which sets it to 0.
     *
            return ScoreMode.COMPLETE;
     * returning we <strong>finally</strong> perform a "real", "perfect bucketing",  
                        previousRounded = rounded;
                        collectValue(doc, rounded);
/*
import org.opensearch.common.util.LongArray;  
                    LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = oldOrds.ordsEnum(owningBucketOrd);
                    long bucketOrd = bucketOrds.add(owningBucketOrd, rounded);
                @Override
            SearchContext aggregationContext,  
            (owningBucketOrd, buckets) -> {
abstract class AutoDateHistogramAggregator extends DeferableBucketAggregator {  
                maxes = context.bigArrays().grow(maxes, owningBucketOrd + 1);  
                        assert rounded >= previousRounded;  
        protected LeafBucketCollector getLeafCollector(SortedNumericDocValues values, DocValuesSkipper skipper, LeafBucketCollector sub)  
                return (key) -> getBucketOrds().add(0, preparedRounding.round(key));
                rebucket();  
            protected void prepare() throws IOException {
        filterRewriteOptimizationContext = new FilterRewriteOptimizationContext(bridge, parent, subAggregators.length, context);
            add.accept("surviving_buckets", bucketOrds.size());
    private final DocValueFormat formatter;
     */  
            protected Rounding getRounding(final long low, final long high) {  
    }  
                formatter,
        private long wastedBucketsOverestimate = 0;
                }
        LongToIntFunction roundingIndexFor,
                name,
             */  
            this::incrementBucketDocCount,  
                @Override  
        this.roundingPreparer = roundingPreparer;
     *
        int targetBuckets,
                while (roundingIdx < roundingInfos.length - 1) {  
import java.util.function.LongToIntFunction;  
            );
 * buckets, reconfiguring how it rounds dates to buckets on the fly as new  
                parent,  
             * even if we use the maximum inner interval of our current rounding. For example, consider the  
                factories,
                        mergeMap[(int) ordsEnum.ord()] = newBucketOrd >= 0 ? newBucketOrd : -1 - newBucketOrd;
             * but it does have the advantage of only touching the buckets that we
}  
                name,  
                roundingPreparer,
        super(name, factories, aggregationContext, parent, metadata);
         */
                    sub,  
 * <p>
                }
         * @param rounded the most recently collected value rounded
             * want to collect.
                factories,
             * replay the hits and build the buckets. How much faster is not clear,  
                    }
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;
 */
            }  
                    if (bucketOrd < 0) { // already seen  
             */
        LongKeyedBucketOrds bucketOrds,
        }
 * standpoint but the simpler implementation is between 7% and 15% faster  
    }
                        return;  
     * number of buckets that will "survive" at the new rounding and uses
        mergeBuckets(mergeMap, newNumBuckets);
            }
                    // If the interval duration is covered by the maximum inner interval,  
     * but as more data arrives it rebuckets the data until it "fits" in the
                        long value = values.nextValue();
     * aggregations! Instead, we keep a "budget" of buckets that we're ok
    @Override
             * exceeds this range we must update our rounding.
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
            add.accept("next_rebucket_at", nextRebucketAt);
            if (preparedRoundings[newRounding] == null) {  
import org.opensearch.search.aggregations.BucketOrder;
            Aggregator parent,
        /**
                    super.collect(stream, owningBucketOrd);
    protected final Rounding.Prepared prepareRounding(int index) {  
import org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge;
     * "dead" buckets that have data but have yet to be merged into the buckets
                }  
            roundingIndices = context.bigArrays().newByteArray(1, true);  
            @Override
                aggregationContext,  
     * collect and picking the rounding based on a real, accurate count and the
         * inner loop of {@link LeafBucketCollector#collect(int, long)}.
     * "wasting". When we promote the rounding and our estimate of the number of  
        private int skiplistCollectorCount = 0;
                targetBuckets,  
        private void increaseRoundingIfNeeded(long rounded) {  
        );
                 * In the special case where in FilterRewrite (SubAggRangeCollector) logic, we can use Skiplist because we
                long bestDuration = (high - low) / targetBuckets;
                    long bucketOrd = bucketOrds.add(0, rounded);
                );
                return preparedRounding;  
                metadata
                    roundingIdx++;
             * The total duration of ms covered by our current rounding. In the case of MINUTES_OF_HOUR rounding
            bucketOrds = new LongKeyedBucketOrds.FromMany(context.bigArrays());
            wastedBucketsOverestimate += oldEstimatedBucketCount - newEstimatedBucketCount;
                    }
            add.accept("wasted_buckets_overestimate", wastedBucketsOverestimate);  
            Releasables.close(bucketOrds);
    private AutoDateHistogramAggregator(
            }
            bucketOrds = new LongKeyedBucketOrds.FromSingle(context.bigArrays());
import java.util.function.Function;
             * 2. Must span a range of [low, high] with buckets <= targetBuckets  
                 * similar to FromMany.  
import static org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge.segmentMatchAll;
                    return increaseRoundingIfNeeded(owningBucketOrd, estimatedBucketCount, rounded, roundingIdx);
         */
                    final RoundingInfo curRoundingInfo = roundingInfos[roundingIdx];
     * the estimate of the number of buckets will be wrong if the buckets are  
            /**  
                        return roundingIdx;  
            mins.set(0, Long.MAX_VALUE);
     * Once we're done collecting and we know exactly which buckets we'll be
        @Override
                        previousRounded = rounded;
    ) throws IOException {  
import org.opensearch.search.aggregations.support.ValuesSource;  
            );
    private MergingBucketsDeferringCollector deferringCollector;
        if (deferringCollector != null) {  
        // Debug tracking counters for collector types
/*  
            }
                            continue;
        return new InternalAutoDateHistogram(name, Collections.emptyList(), targetBuckets, emptyBucketInfo, formatter, metadata(), 1);  
        CardinalityUpperBound cardinality,
                    || max - min > targetBuckets * roundingInfos[newRounding].getMaximumRoughEstimateDurationMillis()));  
        @Override
     * @opensearch.internal  
                long[] mergeMap = new long[Math.toIntExact(oldOrds.size())];
            }  
         * think that it wouldn't matter, but its seriously 7%-15% performance
            min = Math.min(min, rounded);
             * 1. [targetBuckets * roundingInfos[roundingIdx].getMaximumInnerInterval()]
    ) throws IOException {
                    collectBucket(sub, doc, bucketOrd);
         */
                public void collectRange(int min, int max) throws IOException {  
                    }
            SearchContext aggregationContext,
        private final Rounding.Prepared[] preparedRoundings;
import org.apache.lucene.search.ScoreMode;  
             *  
    protected final void merge(long[] mergeMap, long newNumBuckets) {
        }
     * heuristic.
            segmentMatchAll(context, ctx),
            // Fall back to standard LeafBucketCollectorBase when skiplist unavailable
                valuesSourceConfig,  
            maxes.set(owningBucketOrd, max);
                // the contract of the histogram aggregation is that shards must return
        }
    private static class FromMany extends AutoDateHistogramAggregator {
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
                    preparedRounding = prepareRounding(++roundingIdx);  
                checkCancelled();
                    for (int i = 0; i < valuesCount; ++i) {  
     * Rebucketing is roughly {@code O(number_of_hits_collected_so_far)} but we
                double ratio = (double) oldRoughDuration / (double) roundingInfos[newRounding].getRoughEstimateDurationMillis();
            ),
             *  
        final SortedNumericDocValues values = valuesSource.longValues(ctx);  
                    }  
    private static class FromSingle extends AutoDateHistogramAggregator {
                long oldSize = mins.size();  
            return bucketOrds;  
    protected abstract LeafBucketCollector getLeafCollector(
            maxes = context.bigArrays().newLongArray(1, false);  
                int prevRoundingIdx = roundingIdx;
import java.util.Collections;
 * this file be licensed under the Apache-2.0 license or a
            return buildAggregations(bucketOrds, l -> roundingIdx, owningBucketOrds);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    protected abstract LongKeyedBucketOrds getBucketOrds();
            Map<String, Object> metadata  
            protected Prepared getRoundingPrepared() {
                    (owningBucket, rounded) -> increaseRoundingIfNeeded(rounded)  // Pass supplier to allow rounding change  
        }
        private int roundingIndexFor(long owningBucketOrd) {
    }  
     * A reference to the collector so we can
     * <p>  
                name,
            super.collectDebugInfo(add);
                    }
         * call to {@link LongKeyedBucketOrds#add(long, long)} in the tight
                buildRanges(context);  
                nextRebucketAt *= 2;  
            rebucket();
            )
    }
                /**
                aggregationContext,
                    super.collectRange(min, max);
        /**  
import org.opensearch.common.util.IntArray;
             * @return select a prepared rounding which satisfies the conditions:
                    (owningBucketOrd) -> preparedRounding,  // for FromSingle there will be no parent/
            super.collectDebugInfo(add);  
                roundingPreparer,  
         * It is important that this is the exact subtype of  
        protected LongKeyedBucketOrds getBucketOrds() {
         * up in {@link InternalAutoDateHistogram#reduceBucket}. In particular,
                merge(mergeMap, bucketOrds.size());
        protected LongKeyedBucketOrds getBucketOrds() {
                        long newBucketOrd = bucketOrds.add(0, newKey);
                    }
            deferringCollector.mergeBuckets(mergeMap);
                 */
                }  
        }  
     * to the next rounding. Instead of redoing the rounding, it estimates the
     * rounding all of the keys for {@code owningBucketOrd} that we're going to
            liveBucketCountUnderestimate = context.bigArrays().newIntArray(1, true);  
                subAggregationResults  
        protected void doClose() {  
     * Initially it uses the most fine grained rounding configuration possible but  
 *
         * difference for the aggregation. Yikes.
        SortedNumericDocValues values,  
 *    http://www.apache.org/licenses/LICENSE-2.0
            owningBucketOrds,  
                    sub,
     * than what the current rounding supports it promotes. This heuristic
         */  
                // buckets ordered by key in ascending order
                factories,  
                aggregationContext,
                metadata
 * This class is abstract because there is a simple implementation for when the  
            RoundingInfo[] roundingInfos,  
             * Rebucket before building the aggregation to build as small as result
                 *
         * {@link LongKeyedBucketOrds} so that the JVM can make a monomorphic
                );
        /**  
 * KIND, either express or implied.  See the License for the
    }  
     * increments in order to trigger another promotion to another coarser
        };
    public final DeferringBucketCollector getDeferringCollector() {  
    }  
        private IntArray liveBucketCountUnderestimate;
            final NumericDocValues singleton = DocValues.unwrapSingleton(values);  
        protected LeafBucketCollector getLeafCollector(SortedNumericDocValues values, DocValuesSkipper skipper, LeafBucketCollector sub)
             * targetBuckets * roundingInfos[roundingIdx].getMaximumInnerInterval() would then be the number of
             *
            Function<Rounding, Prepared> roundingPreparer,
                parent,
            : new FromMany(
     * isn't good at limiting the number of buckets but is great when the buckets  
     * The second heuristic it uses to trigger promotion to a coarser rounding is  
 *
        SearchContext aggregationContext,  
        }
            mins.set(owningBucketOrd, min);
            return bucketOrds;
            add.accept("surviving_buckets", bucketOrds.size());
                        long value = values.nextValue();
    ) throws IOException {
    public final ScoreMode scoreMode() {
            if (HistogramSkiplistLeafCollector.canUseSkiplist(null, parent, skipper, singleton)) {
 * compatible open source license.
        if (valuesSource == null) {
        /**
                roundingIdx = 0;
            @Override
            Function<Rounding, Rounding.Prepared> roundingPreparer,
        if (this.fieldName != null) {
                    (owningBucketOrd, rounded) -> {
                targetBuckets,
            assert roundingInfos.length < 127 : "Rounding must fit in a signed byte";
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;  
            int targetBuckets,  
     * rebucket roughly {@code O(log number_of_hits_collected_so_far)} because
     * rounding. This works fairly well at containing the number of buckets, but
        }  
                    if (false == values.advanceExact(doc)) {  
                 * HistogramSkiplistLeafCollector in its current state can only handle one owningBucketOrd at a time.  
        this.fieldName = (valuesSource instanceof ValuesSource.Numeric.FieldData)  
        /**
                skiplistCollectorCount++;
        SearchContext aggregationContext,  
        @Override  
             * Represents the total bucket count possible before we will exceed targetBuckets
                aggregationContext,
                    }  
            return LeafBucketCollector.NO_OP_COLLECTOR;  
                // so the right innerInterval should be an upper bound
            mins = context.bigArrays().newLongArray(1, false);
                    FromSingle.this,
            /**
                && max - min <= targetBuckets * roundingInfos[roundingIdx].getMaximumRoughEstimateDurationMillis()) {
            Map<String, Object> metadata
                    || max - min > targetBuckets * roundingInfos[roundingIdx].getMaximumRoughEstimateDurationMillis()));
            ? new FromSingle(  
    public void collectDebugInfo(BiConsumer<String, Object> add) {  
             * Quick explanation of the two below conditions:
            }  
             * @param high upper bound of rounding to prepare  
        private ByteArray roundingIndices;  
             * than our targetBuckets limit. If the current count of buckets exceeds this limit we must update
                for (long owningBucketOrd = 0; owningBucketOrd <= oldOrds.maxOwningBucketOrd(); owningBucketOrd++) {
            Aggregator parent,
        }  
 * specific language governing permissions and limitations
                // Ensure preparedRounding never shrinks
    }  
                && (newEstimatedBucketCount > targetBuckets * roundingInfos[newRounding].getMaximumInnerInterval()
 *  
                    assert owningBucketOrd == 0;
        /**
            RoundingInfo[] roundingInfos,
                        long newKey = preparedRounding.round(oldKey);  
                 * When parent is null, i.e. then ForSingle class will get used. ForMany is used when auto date is sub agg.
                    preparedRounding = prepareRounding(roundingIdx);
            bucketOrds,
            String name,  
                        roundingIdx = collectValue(owningBucketOrd, roundingIdx, doc, rounded);
 * You may obtain a copy of the License at  
                return roundingInfos[roundingIdx].rounding;
                    }  
            : null;
                preparedRoundings[newRounding] = prepareRounding(newRounding);
            }
                        assert rounded >= previousRounded;  
            (bucketValue, docCount, subAggregationResults) -> new InternalAutoDateHistogram.Bucket(
            Releasables.close(bucketOrds, roundingIndices, mins, maxes, liveBucketCountUnderestimate);
            AggregatorFactories factories,
        /**
     * logarithmically increasing.
                        }  
                roundingPreparer,
                        long newBucketOrd = bucketOrds.add(owningBucketOrd, newKey);
                newEstimatedBucketCount = (int) Math.ceil(oldEstimatedBucketCount * ratio);  
        @Override
        ) throws IOException {
            roundingIndices.set(owningBucketOrd, (byte) newRounding);
    ) throws IOException;  
        RoundingInfo[] roundingInfos,  
 * GitHub history for details.
         * current rounding for each {@code owningBucketOrdinal}.  
        ValuesSourceConfig valuesSourceConfig,
             * 1 day buckets possible such that if we re-bucket to 1 week buckets we will have more 1 week buckets  
        return getLeafCollector(values, skipper, sub);  
         * results. We keep this just to report to the profiler.  
                    roundingInfos,
         */  
            };
                wastedBucketsOverestimate = 0;
         * <p>
        private LongKeyedBucketOrds.FromSingle bucketOrds;
        private long nextRebucketAt = 1000; // TODO this could almost certainly start higher when asMultiBucketAggregator is gone  
        ValuesSourceConfig valuesSourceConfig,
             * TODO it'd be faster if we could apply the merging on the fly as we
                 * will one range (and thus owningBucketOrd) at time.  
import org.apache.lucene.index.LeafReaderContext;
            add.accept("skiplist_collectors_used", skiplistCollectorCount);
 * performance.
                try (LongKeyedBucketOrds oldOrds = bucketOrds) {
            return newRounding;
            maxes.set(0, Long.MIN_VALUE);
        DateHistogramAggregatorBridge bridge = new DateHistogramAggregatorBridge() {
    @Override
                    int estimatedBucketCount = liveBucketCountUnderestimate.increment(owningBucketOrd, 1);
 * @opensearch.internal
 * aggregator only collects from a single bucket and a more complex
                    singleton,  
                metadata  
            mins.set(owningBucketOrd, preparedRoundings[newRounding].round(mins.get(owningBucketOrd)));
     */
            int newRounding = oldRounding;
         * cover the date range across all of the results returned by all of  
         * by bumping to the next rounding index. So we end up bumping less
                    LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = oldOrds.ordsEnum(0);  
                        long rounded = preparedRounding.round(value);
                    increaseRoundingIfNeeded(rounded);  
        public void doClose() {
                        collectExistingBucket(sub, doc, bucketOrd);
            long max = Math.max(maxes.get(owningBucketOrd), newKey);  
                    FromMany.this,
                liveBucketCountUnderestimate.set(owningBucketOrd, newEstimatedBucketCount);
                CollectionUtil.introSort(buckets, BucketOrder.key(true).comparator());  
     * <p>
                roundingInfos,
        }
 * under the License.  
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
        }
            }
            int newEstimatedBucketCount;
                    liveBucketCountUnderestimate = context.bigArrays().grow(liveBucketCountUnderestimate, owningBucketOrd + 1);
    protected Rounding.Prepared preparedRounding;  
                    skipper,  
import org.opensearch.search.internal.SearchContext;
            do {  
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.DocValues;  
                        increaseRoundingIfNeeded(owningBucketOrd, estimatedBucketCount, rounded, roundingIdx);  
    }  
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
            protected Function<Long, Long> bucketOrdProducer() {
         * inner loop of {@link LeafBucketCollector#collect(int, long)}. You'd  
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
        super.collectDebugInfo(add);
        Map<String, Object> metadata
                    long[] mergeMap = new long[Math.toIntExact(oldOrds.size())];
        private int rebucketCount = 0;
         * <p>
            } while (newRounding < roundingInfos.length - 1
        filterRewriteOptimizationContext.populateDebugInfo(add);
        }
            }
             * getMaximumRoughEstimateDurationMillis is 60000. If our current total range in millis (max - min)  
                    () -> bucketOrds,
            add.accept("rebucket_count", rebucketCount);
import org.apache.lucene.index.DocValuesSkipper;
    @Override
                 * In the future we can enhance HistogramSkiplistLeafCollector to handle multiple owningBucketOrd,
                        break;  
                // find the right innerInterval this bestDuration belongs to
         * Increase the rounding of {@code owningBucketOrd} using  
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
                        long rounded = preparedRoundings[roundingIdx].round(value);
                checkCancelled();  
                public void collect(int doc, long owningBucketOrd) throws IOException {
    @Override  
        Aggregator parent,
         * on final reduce we bump the rounding until it we appropriately
        }  
                    if (bucketOrd < 0) { // already seen  
                    }
    /**
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
 * when you can use it. This is an important aggregation and we need that
/**
                    () -> bucketOrds,  
                metadata  
                }
     * the entire aggregation and double the budget.  
                valuesSourceConfig,  
             * 1. Is at least as large as our previously prepared rounding
         * the {@link AutoDateHistogramAggregator}s.
             * as possible.  
                    buildEmptySubAggregations()  
        AggregatorFactories factories,
                    int valuesCount = values.docValueCount();  
         * call to {@link LongKeyedBucketOrds#add(long, long)} in the tight
            rebucketCount++;
         * An over estimate of the number of wasted buckets. When this gets
    public final InternalAggregation buildEmptyAggregation() {  
            super(  
         */
            }  
                @Override  
import org.opensearch.search.aggregations.bucket.MergingBucketsDeferringCollector;
                }  
                }
        @Override  
         * estimated, bucket counts, {@link FromMany#rebucket()} rebucketing} the all
import org.opensearch.search.DocValueFormat;
            throws IOException {
                        return;  
         * buckets if the estimated number of wasted buckets is too high.
        /**
            if (oldEstimatedBucketCount <= targetBuckets * roundingInfos[oldRounding].getMaximumInnerInterval()
        @Override
        DocValuesSkipper skipper,
         * An array of prepared roundings in the same order as  
     * aggregation rounding. Similar to {@link FromMany} this checks both the
    }
                    int roundingIdx = roundingIndexFor(owningBucketOrd);
                    // we can start with this outer interval for creating the buckets
                    long previousRounded = Long.MIN_VALUE;
                long oldSize = maxes.size();
     * are spread out compared to the rounding. So it should complement the first
    @Override
     * when there are more buckets than can "fit" in the current rounding it shifts  
            add.accept("skiplist_collectors_used", skiplistCollectorCount);  
        /**  
            do {
import java.util.function.BiConsumer;
                    long previousRounded = Long.MIN_VALUE;
