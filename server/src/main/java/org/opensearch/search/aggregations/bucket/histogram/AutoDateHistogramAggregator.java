import org.apache.lucene.index.DocValues;
 * performance.
        }
                return new HistogramSkiplistLeafCollector(
            preparedRoundings[0] = roundingPreparer.apply(roundingInfos[0].rounding);
        LongToIntFunction roundingIndexFor,
            int newRounding = oldRounding;
     * expensive to call {@link MergingBucketsDeferringCollector#mergeBuckets}.
        }
                subAggregationResults
                roundingInfos,
             *
            super.collectDebugInfo(add);
     * Rebucketing is roughly {@code O(number_of_hits_collected_so_far)} but we
         * Examine our current bucket count and the most recently added bucket to determine if an update to
 * not use this file except in compliance with the License.
     * the distance between the min and max bucket. When that distance is greater
 */
    private final ValuesSource.Numeric valuesSource;
            return buildAggregations(bucketOrds, this::roundingIndexFor, owningBucketOrds);
        }
            @Override
 * Modifications Copyright OpenSearch Contributors. See
     * when there are more buckets than can "fit" in the current rounding it shifts
                            continue;
                    }
 * specific language governing permissions and limitations
        protected LongKeyedBucketOrds getBucketOrds() {
         */
                    if (false == values.advanceExact(doc)) {
/*
    }
        @Override
            if (wastedBucketsOverestimate > nextRebucketAt) {
            // Re calculate the max and min values we expect to bucket according to most recently rounded val
            /**
                return new InternalAutoDateHistogram(name, buckets, targetBuckets, emptyBucketInfo, formatter, metadata(), 1);
         * <p>
     * rebucket roughly {@code O(log number_of_hits_collected_so_far)} because
        }
                mins.fill(oldSize, mins.size(), Long.MAX_VALUE);
        this.targetBuckets = targetBuckets;
                    }
            AggregatorFactories factories,
        long[] owningBucketOrds
                }
            ? new FromSingle(
     * aggregations! Instead, we keep a "budget" of buckets that we're ok
                int prevRoundingIdx = roundingIdx;
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder.RoundingInfo;
             *
         * aggressively than a "perfect" algorithm. That is fine because we
    protected final void merge(long[] mergeMap, long newNumBuckets) {
        private long max = Long.MIN_VALUE;
        /**
                roundingIdx = 0;
import org.opensearch.search.aggregations.CardinalityUpperBound;
        }
         * <p>
                name,
            if (HistogramSkiplistLeafCollector.canUseSkiplist(null, parent, skipper, singleton)) {
        public void doClose() {
                    super.collect(stream, owningBucketOrd);
        /**
                    final int temp = curRoundingInfo.innerIntervals[curRoundingInfo.innerIntervals.length - 1];
            SearchContext aggregationContext,
                valuesSourceConfig,
            protected Rounding getRounding(final long low, final long high) {
 *
    public void collectDebugInfo(BiConsumer<String, Object> add) {
                return oldRounding;
         * inner loop of {@link LeafBucketCollector#collect(int, long)}.
            );
     * rounding. This works fairly well at containing the number of buckets, but
    }
    static AutoDateHistogramAggregator build(
            int targetBuckets,
        private LongKeyedBucketOrds.FromMany bucketOrds;
import org.apache.lucene.index.NumericDocValues;
            max = Math.max(max, rounded);
            add.accept("skiplist_collectors_used", skiplistCollectorCount);
                    final RoundingInfo curRoundingInfo = roundingInfos[roundingIdx];
         * by bumping to the next rounding index. So we end up bumping less
        }
import org.opensearch.common.lease.Releasables;
                private int collectValue(long owningBucketOrd, int roundingIdx, int doc, long rounded) throws IOException {
         *
         */
            }
            @Override
    public final DeferringBucketCollector getDeferringCollector() {
     * than what the current rounding supports it promotes. This heuristic
                    preparedRounding = prepareRounding(++roundingIdx);
                        return;
                 * In the future we can enhance HistogramSkiplistLeafCollector to handle multiple owningBucketOrd,
         * The minimum key per {@code owningBucketOrd}.
                }
                // Increment skiplist collector count
                }
            }
            if (HistogramSkiplistLeafCollector.canUseSkiplist(null, parent, skipper, singleton)) {
        Function<Rounding, Rounding.Prepared> roundingPreparer,
             * @param high upper bound of rounding to prepare
            if (mins.size() < owningBucketOrd + 1) {
        private long nextRebucketAt = 1000; // TODO this could almost certainly start higher when asMultiBucketAggregator is gone
                buildRanges(context);
                // value source will be null for unmapped fields
    private final Function<Rounding, Rounding.Prepared> roundingPreparer;
    }
            if (preparedRoundings[newRounding] == null) {
                    LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = oldOrds.ordsEnum(0);
                        bucketOrd = -1 - bucketOrd;
                double ratio = (double) oldRoughDuration / (double) roundingInfos[newRounding].getRoughEstimateDurationMillis();
            collectableSubAggregators
        public void collectDebugInfo(BiConsumer<String, Object> add) {
            Function<Rounding, Prepared> roundingPreparer,
         */
             *
        }
import org.apache.lucene.search.DocIdStream;
            @Override
         * difference for the aggregation. Yikes.
                        if (rounded == previousRounded) {
 * this work for additional information regarding copyright
         */
                merge(mergeMap, bucketOrds.size());
        deferringCollector = new MergingBucketsDeferringCollector(context, descendsFromGlobalAggregator(parent()));
        }
                parent,
            wastedBucketsOverestimate += oldEstimatedBucketCount - newEstimatedBucketCount;
                metadata
    ) throws IOException {
     * In particular it is {@code O(number_of_hits_collected_so_far)}. So if we
            throws IOException {
 * GitHub history for details.
            }
        private IntArray liveBucketCountUnderestimate;
         * correct the error when we merge the buckets together all the way
                        long value = values.nextValue();
        private int skiplistCollectorCount = 0;
                        if (rounded == previousRounded) {
    }
        @Override
                aggregationContext,
            if (maxes.size() < owningBucketOrd + 1) {
                return (key) -> getBucketOrds().add(0, preparedRounding.round(key));
            int newEstimatedBucketCount;
        filterRewriteOptimizationContext.populateDebugInfo(add);
     * min and max.
                    // we can start with this outer interval for creating the buckets
                // max - min / targetBuckets = bestDuration
                }
                        collectExistingBucket(sub, doc, bucketOrd);
                );
        /**
        private int roundingIndexFor(long owningBucketOrd) {
 * when you can use it. This is an important aggregation and we need that
                factories,
                    if (bucketOrd < 0) { // already seen
import org.opensearch.common.util.IntArray;
         * up in {@link InternalAutoDateHistogram#reduceBucket}. In particular,
             */
        }
            super(
 * implementation when it doesn't. This ain't great from a test coverage
        FromMany(
                 * will one range (and thus owningBucketOrd) at time.
                    long bucketOrd = bucketOrds.add(0, rounded);
        @Override
import org.opensearch.search.aggregations.InternalAggregation;
                    }
        private long min = Long.MAX_VALUE;
            return newRounding;
        }
                    while (ordsEnum.next()) {
             * Rebucket before building the aggregation to build as small as result
             * 1. Is at least as large as our previously prepared rounding
            return bucketOrds;
                    while (ordsEnum.next()) {
                targetBuckets,
     * the "shape" of the roundings is <strong>roughly</strong>
        AggregatorFactories factories,
                // Ensure preparedRounding never shrinks
 *
                factories,
         * current rounding for each {@code owningBucketOrdinal}.
                aggregationContext,
            add.accept("rebucket_count", rebucketCount);
        );
                // Bump the threshold for the next rebucketing
 * under the License.
     * as more data arrives it uses two heuristics to shift to coarser and coarser
    @Override
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
                    FromMany.this,
import org.apache.lucene.index.DocValuesSkipper;
            }
import org.apache.lucene.index.LeafReaderContext;
     * the entire aggregation and double the budget.
                }
                    }
                && (bucketOrds.size() > targetBuckets * roundingInfos[roundingIdx].getMaximumInnerInterval()
                        mergeMap[(int) ordsEnum.ord()] = newBucketOrd >= 0 ? newBucketOrd : -1 - newBucketOrd;
                roundingPreparer,
    protected final boolean shouldDefer(Aggregator aggregator) {
         * Increase the rounding of {@code owningBucketOrd} using
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
            (owningBucketOrd, buckets) -> {
        private int increaseRoundingIfNeeded(long owningBucketOrd, int oldEstimatedBucketCount, long newKey, int oldRounding) {
            /**
            protected void prepare() throws IOException {
        RoundingInfo[] roundingInfos,
            @Override
        mergeBuckets(mergeMap, newNumBuckets);
        );
                bucketValue,
    protected abstract LeafBucketCollector getLeafCollector(
                parent,
    }
         * {@link LongKeyedBucketOrds} so that the JVM can make a monomorphic
        Aggregator parent,
                    int valuesCount = values.docValueCount();
                // so the right innerInterval should be an upper bound
                aggregationContext,
                    (owningBucketOrd) -> preparedRounding,  // for FromSingle there will be no parent/
                    Rounding.Prepared preparedRounding = preparedRoundings[roundingIndexFor(owningBucketOrd)];
            assert roundingInfos.length < 127 : "Rounding must fit in a signed byte";
                long oldSize = maxes.size();
        return super.scoreMode();
import org.opensearch.search.aggregations.support.ValuesSource;
 * KIND, either express or implied.  See the License for the
                parent,
             * even if we use the maximum inner interval of our current rounding. For example, consider the
import org.opensearch.common.Rounding.Prepared;
            owningBucketOrds,
                    if (bucketOrd < 0) { // already seen
                targetBuckets,
        Function<Rounding, Rounding.Prepared> roundingPreparer,
                roundingPreparer,
     * "wasting". When we promote the rounding and our estimate of the number of
            add.accept("surviving_buckets", bucketOrds.size());
     * increments in order to trigger another promotion to another coarser
             * want to collect.
                 * HistogramSkiplistLeafCollector in its current state can only handle one owningBucketOrd at a time.
             * our rounding.
                    merge(mergeMap, bucketOrds.size());
     * A reference to the collector so we can
        ValuesSourceConfig valuesSourceConfig,
         * call to {@link LongKeyedBucketOrds#add(long, long)} in the tight
import org.opensearch.search.DocValueFormat;
                newEstimatedBucketCount = (int) Math.ceil(oldEstimatedBucketCount * ratio);
 * software distributed under the License is distributed on an
             * 2. [targetBuckets * roundingInfos[roundingIdx].getMaximumRoughEstimateDurationMillis()]
    /**
                factories,
                 * similar to FromMany.
    ) throws IOException;
        private void rebucket() {
         * {@link #roundingInfos}. The 0th entry is prepared initially,
            SearchContext aggregationContext,
        return buildAggregationsForVariableBuckets(
        /**
                maxes = context.bigArrays().grow(maxes, owningBucketOrd + 1);
            do {
            protected boolean canOptimize() {
            this::incrementBucketDocCount,
                metadata
                return oldRounding;
         */
                private void collectValue(int doc, long rounded) throws IOException {
        @Override
                 *
        InternalAutoDateHistogram.BucketInfo emptyBucketInfo = new InternalAutoDateHistogram.BucketInfo(
    protected final int targetBuckets;
/**
import java.io.IOException;
            return ScoreMode.COMPLETE;
            mins.set(0, Long.MAX_VALUE);
        return deferringCollector;
            super(
                    () -> bucketOrds,
                for (long owningBucketOrd = 0; owningBucketOrd <= oldOrds.maxOwningBucketOrd(); owningBucketOrd++) {
 * Licensed to Elasticsearch under one or more contributor
        /**
                        return roundingIdx;
                    singleton,
            }
import org.apache.lucene.util.CollectionUtil;
     * {@link MergingBucketsDeferringCollector#mergeBuckets(long[])}.
             * The total duration of ms covered by our current rounding. In the case of MINUTES_OF_HOUR rounding
     * When promoting a rounding we keep the old buckets around because it is
            }
     * called it frequently we'd end up in {@code O(n^2)} territory. Bad news for
         * on final reduce we bump the rounding until it we appropriately
                        return;
        protected LeafBucketCollector getLeafCollector(SortedNumericDocValues values, DocValuesSkipper skipper, LeafBucketCollector sub)
                    (owningBucketOrd, rounded) -> {
     * bucket count and range of the aggregation, but unlike
 * This class is abstract because there is a simple implementation for when the
                        mergeMap[(int) ordsEnum.ord()] = newBucketOrd >= 0 ? newBucketOrd : -1 - newBucketOrd;
            buildEmptySubAggregations()
                        long newKey = preparedRounding.round(oldKey);
        protected LongKeyedBucketOrds getBucketOrds() {
                    skipper,
         * The index of the rounding that each {@code owningBucketOrd} is
        private void increaseRoundingIfNeeded(long rounded) {
                }
        int targetBuckets,
    }
                try (LongKeyedBucketOrds oldOrds = bucketOrds) {
            // If we are already using the rounding with the largest interval nothing can be done
     * <strong>that</strong> as the initial value for the bucket count that it
                        int estimatedBucketCount = liveBucketCountUnderestimate.increment(owningBucketOrd, 1);
            );
             */
        private int rebucketCount = 0;
            roundingIndices = context.bigArrays().grow(roundingIndices, owningBucketOrd + 1);
        /**
        public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        };
        private final Rounding.Prepared[] preparedRoundings;
            add.accept("wasted_buckets_overestimate", wastedBucketsOverestimate);
         * The number of times the aggregator had to {@link #rebucket()} the
         */
                    // If the interval duration is covered by the maximum inner interval,
            return new LeafBucketCollectorBase(sub, values) {
            }
        this.fieldName = (valuesSource instanceof ValuesSource.Numeric.FieldData)
        if (this.fieldName != null) {
         */
     * number of buckets that will "survive" at the new rounding and uses
        @Override
                valuesSourceConfig,
     *
import org.opensearch.common.util.LongArray;
         * and other entries are null until first needed.
        if (deferringCollector != null) {
        this.preparedRounding = prepareRounding(0);
    private final String fieldName;
            ? ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName()
 *
        ) throws IOException {
            bucketOrds = new LongKeyedBucketOrds.FromSingle(context.bigArrays());
        return roundingPreparer.apply(roundingInfos[index].rounding);
                );
 */
        return true;
     */
 * compatible open source license.
                // since we cannot exceed targetBuckets, bestDuration should go up,
        Map<String, Object> metadata
                    assert owningBucketOrd == 0;
        /**
    public final ScoreMode scoreMode() {
    }
                // the contract of the histogram aggregation is that shards must return
             */
import org.opensearch.search.aggregations.bucket.DeferableBucketAggregator;
        private long wastedBucketsOverestimate = 0;
                return preparedRounding;
                targetBuckets,
            };
    protected final RoundingInfo[] roundingInfos;
            long oldRoughDuration = roundingInfos[oldRounding].roughEstimateDurationMillis;
                        long rounded = preparedRoundings[roundingIdx].round(value);
            try (LongKeyedBucketOrds oldOrds = bucketOrds) {
import org.opensearch.common.Rounding;
                        bucketOrd = -1 - bucketOrd;
                @Override
            bucketOrds,
        Aggregator parent,
    public final InternalAggregation buildEmptyAggregation() {
         * An array of prepared roundings in the same order as
                    int estimatedBucketCount = liveBucketCountUnderestimate.increment(owningBucketOrd, 1);
                return roundingInfos[roundingIdx].rounding;
                checkCancelled();
                    buildEmptySubAggregations()
             * @return select a prepared rounding which satisfies the conditions:
            roundingIndices = context.bigArrays().newByteArray(1, true);
         * <p>
     * doesn't delay rebucketing.
            setRounding(owningBucketOrd, newRounding);
    public final LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    /**
                    FromSingle.this,
     * the estimate of the number of buckets will be wrong if the buckets are
        }
            rebucketCount++;
        RoundingInfo[] roundingInfos,
        return new InternalAutoDateHistogram(name, Collections.emptyList(), targetBuckets, emptyBucketInfo, formatter, metadata(), 1);
         * call to {@link LongKeyedBucketOrds#add(long, long)} in the tight
                        long newKey = preparedRounding.round(oldKey);
                        int roundingIdx = roundingIndexFor(owningBucketOrd);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
 * @opensearch.internal
import org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge;
                && max - min <= targetBuckets * roundingInfos[roundingIdx].getMaximumRoughEstimateDurationMillis()) {
            protected Prepared getRoundingPrepared() {
        }
            Aggregator parent,
            roundingInfos,
         * the {@link AutoDateHistogramAggregator}s.
            AggregatorFactories factories,
                    || max - min > targetBuckets * roundingInfos[roundingIdx].getMaximumRoughEstimateDurationMillis()));
            String name,
 * this file be licensed under the Apache-2.0 license or a
                        }
                skiplistCollectorCount++;
        FromSingle(
                    singleton,
                    roundingInfos,
        @Override
        super.collectDebugInfo(add);
         * cover the date range across all of the results returned by all of
            int targetBuckets,
            } while (newRounding < roundingInfos.length - 1
                        long rounded = preparedRounding.round(value);
                CollectionUtil.introSort(buckets, BucketOrder.key(true).comparator());
                    long[] mergeMap = new long[Math.toIntExact(oldOrds.size())];
import org.opensearch.search.aggregations.BucketOrder;
    private final FilterRewriteOptimizationContext filterRewriteOptimizationContext;
        LeafBucketCollector sub
                return;
import org.opensearch.search.aggregations.LeafBucketCollector;
     * @opensearch.internal
     * rounding all of the keys for {@code owningBucketOrd} that we're going to
                }
            maxes.set(0, Long.MIN_VALUE);
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
     * to the next rounding. Instead of redoing the rounding, it estimates the
                }
                metadata
            RoundingInfo[] roundingInfos,
                    liveBucketCountUnderestimate = context.bigArrays().grow(liveBucketCountUnderestimate, owningBucketOrd + 1);
         */
         * @param rounded the most recently collected value rounded
    @Override
                    preparedRounding = prepareRounding(roundingIdx);
        private void setRounding(long owningBucketOrd, int newRounding) {
                    collectBucket(sub, doc, bucketOrd);
            maxes.set(owningBucketOrd, preparedRoundings[newRounding].round(maxes.get(owningBucketOrd)));
                public void collectRange(int min, int max) throws IOException {
        int targetBuckets,
        }
                @Override
            )
            Releasables.close(bucketOrds);
            super.collectDebugInfo(add);
        return getLeafCollector(values, skipper, sub);
            if (roundingIdx >= roundingInfos.length - 1) {
        DocValuesSkipper skipper,
                metadata
     * <p>
                    (owningBucketOrd) -> preparedRoundings[roundingIndexFor(owningBucketOrd)],
                    return increaseRoundingIfNeeded(owningBucketOrd, estimatedBucketCount, rounded, roundingIdx);
                        liveBucketCountUnderestimate = context.bigArrays().grow(liveBucketCountUnderestimate, owningBucketOrd + 1);
            // Fall back to standard LeafBucketCollectorBase when skiplist unavailable
                roundingInfos,
    protected final Rounding.Prepared prepareRounding(int index) {
                /**
                name,
     * Once we're done collecting and we know exactly which buckets we'll be
                        collectExistingBucket(sub, doc, bucketOrd);
                        long oldKey = ordsEnum.value();
        this.roundingPreparer = roundingPreparer;
                    liveBucketCountUnderestimate.set(owningBucketOrd, Math.toIntExact(bucketOrds.bucketsInOrd(owningBucketOrd)));
                    LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = oldOrds.ordsEnum(owningBucketOrd);
         * results. We keep this just to report to the profiler.
                @Override
            min = Math.min(min, rounded);
            final NumericDocValues singleton = DocValues.unwrapSingleton(values);
 *
    protected abstract LongKeyedBucketOrds getBucketOrds();
        }
            }
        /**
                    bucketOrds = new LongKeyedBucketOrds.FromSingle(context.bigArrays());
                roundingInfos,
        /**
                formatter,
                public void collect(int doc, long owningBucketOrd) throws IOException {
                    int roundingIdx = roundingIndexFor(owningBucketOrd);
        // Debug tracking counters for collector types
         * It is important that this is the exact subtype of
                        }
            (bucketValue, docCount, subAggregationResults) -> new InternalAutoDateHistogram.Bucket(
 * ownership. Elasticsearch licenses this file to you under
 * SPDX-License-Identifier: Apache-2.0
        this.formatter = valuesSourceConfig.format();
        String name,
            Aggregator parent,
            if (bucketOrds.size() <= targetBuckets * roundingInfos[roundingIdx].getMaximumInnerInterval()
             * but it does have the advantage of only touching the buckets that we
     * rounding. The first heuristic is the number of buckets, specifically,
                    long bucketOrd = bucketOrds.add(owningBucketOrd, rounded);
            }
        private LongArray mins;
            }
                && (newEstimatedBucketCount > targetBuckets * roundingInfos[newRounding].getMaximumInnerInterval()
            }
                            continue;
        /**
                    collectBucket(sub, doc, bucketOrd);
 * aggregator only collects from a single bucket and a more complex
             * as possible.
package org.opensearch.search.aggregations.bucket.histogram;
            // Prepare the first rounding because we know we'll need it.
                }
     * @opensearch.internal
             * exceeds this range we must update our rounding.
        private int skiplistCollectorCount = 0;
                    int valuesCount = values.docValueCount();
        final SortedNumericDocValues values = valuesSource.longValues(ctx);
            final NumericDocValues singleton = DocValues.unwrapSingleton(values);
 * data arrives.
        ) throws IOException {
                long oldSize = mins.size();
                preparedRoundings[newRounding] = prepareRounding(newRounding);
    }
                roundingPreparer,
    }
        ValuesSourceConfig valuesSourceConfig,
             * Represents the total bucket count possible before we will exceed targetBuckets
            add.accept("next_rebucket_at", nextRebucketAt);
     * {@linkplain FromMany} it keeps an accurate count of the buckets and it
         * currently using.
         * The max key per {@code owningBucketOrd}.
    }
     * quite a spread out compared to the rounding.
                checkCancelled();
        SortedNumericDocValues values,
import java.util.function.BiConsumer;
import java.util.Map;
     */
            : new FromMany(
            Releasables.close(bucketOrds, roundingIndices, mins, maxes, liveBucketCountUnderestimate);
                public void collectRange(int min, int max) throws IOException {
         */
        }
            } else {
                    }
             * targetBuckets * roundingInfos[roundingIdx].getMaximumInnerInterval() would then be the number of
    private MergingBucketsDeferringCollector deferringCollector;
             * @param low lower bound of rounding to prepare
import java.util.function.Function;
                    skipper,
    }
    protected final InternalAggregation[] buildAggregations(
                    sub,
                    super.collect(stream, owningBucketOrd);
     * Initially it uses the most fine grained rounding configuration possible but
        }
                    increaseRoundingIfNeeded(rounded);
            do {
             * The filter rewrite optimization uses this method to pre-emptively update the preparedRounding
            return buildAggregations(bucketOrds, l -> roundingIdx, owningBucketOrds);
         */
     * are spread out compared to the rounding. So it should complement the first
                    roundingIndexFor.applyAsInt(owningBucketOrd),
    private static class FromSingle extends AutoDateHistogramAggregator {
        @Override
                // find the right innerInterval this bestDuration belongs to
        @Override
            ValuesSourceConfig valuesSourceConfig,
        protected LeafBucketCollector getLeafCollector(SortedNumericDocValues values, DocValuesSkipper skipper, LeafBucketCollector sub)
        @Override
                    }
                );
            throws IOException {
     * heuristic.
            return LeafBucketCollector.NO_OP_COLLECTOR;
            long max = Math.max(maxes.get(owningBucketOrd), newKey);
                        long oldKey = ordsEnum.value();
        return filterRewriteOptimizationContext.tryOptimize(
         * buckets if the estimated number of wasted buckets is too high.
            liveBucketCountUnderestimate = context.bigArrays().newIntArray(1, true);
     * returning we <strong>finally</strong> perform a "real", "perfect bucketing",
            ),
            return new LeafBucketCollectorBase(sub, values) {
                 * In the special case where in FilterRewrite (SubAggRangeCollector) logic, we can use Skiplist because we
     * <p>
 * Unless required by applicable law or agreed to in writing,
                }
                    for (int i = 0; i < valuesCount; ++i) {
             * TODO it'd be faster if we could apply the merging on the fly as we
 * buckets, reconfiguring how it rounds dates to buckets on the fly as new
    @Override
        private ByteArray roundingIndices;
                    roundingIdx++;
            }
         * An underestimate of the number of buckets that are "live" in the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
                    if (false == values.advanceExact(doc)) {
        super(name, factories, aggregationContext, parent, metadata);
        }
                name,
         */
                    for (int i = 0; i < valuesCount; ++i) {
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
         * {@link #rebucket() rebucketing}.
                long[] mergeMap = new long[Math.toIntExact(oldOrds.size())];
                @Override
     * aggregation rounding. Similar to {@link FromMany} this checks both the
                parent,
        }
            return bucketOrds;
                valuesSourceConfig,
                    }
            ValuesSourceConfig valuesSourceConfig,
    @Override
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                        long newBucketOrd = bucketOrds.add(0, newKey);
                        assert rounded >= previousRounded;
            bucketOrds = new LongKeyedBucketOrds.FromMany(context.bigArrays());
         * {@link LongKeyedBucketOrds} so that the JVM can make a monomorphic
        }
         * Map from value to bucket ordinals.
         */
import org.opensearch.core.common.util.ByteArray;
                 * When parent is null, i.e. then ForSingle class will get used. ForMany is used when auto date is sub agg.
    }
            Map<String, Object> metadata
                    || max - min > targetBuckets * roundingInfos[newRounding].getMaximumRoughEstimateDurationMillis()));
        private LongArray maxes;
import org.opensearch.search.aggregations.bucket.HistogramSkiplistLeafCollector;
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
        AggregatorFactories factories,
         * inner loop of {@link LeafBucketCollector#collect(int, long)}. You'd
     * <p>
 * the Apache License, Version 2.0 (the "License"); you may
                    super.collectRange(min, max);
            };
            }
            // Check if skiplist optimization is available
            : null;
                liveBucketCountUnderestimate.set(owningBucketOrd, newEstimatedBucketCount);
                        previousRounded = rounded;
                if (roundingIdx > prevRoundingIdx) {
             *
            ctx,
abstract class AutoDateHistogramAggregator extends DeferableBucketAggregator {
     * "dead" buckets that have data but have yet to be merged into the buckets
                bucketOrds = new LongKeyedBucketOrds.FromMany(context.bigArrays());
                    long previousRounded = Long.MIN_VALUE;
                && max - min <= targetBuckets * roundingInfos[oldRounding].getMaximumRoughEstimateDurationMillis()) {
                @Override
                 */
        return cardinality == CardinalityUpperBound.ONE
                        assert rounded >= previousRounded;
        LongKeyedBucketOrds bucketOrds,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
     * logarithmically increasing.
     *
                        previousRounded = rounded;
                        collectValue(doc, rounded);
                nextRebucketAt *= 2;
        }
        public void collectDebugInfo(BiConsumer<String, Object> add) {
     * collect and picking the rounding based on a real, accurate count and the
             * 1. [targetBuckets * roundingInfos[roundingIdx].getMaximumInnerInterval()]
         * Map from value to bucket ordinals.
                roundingPreparer,
         * The next {@link #wastedBucketsOverestimate} that will trigger a
        // TODO: Remove null usage here, by using a different aggregator for create
     * <p>
 */
        /**
                    long previousRounded = Long.MIN_VALUE;
         * It is important that this is the exact subtype of
 * An aggregator for date values that attempts to return a specific number of
            /*
            );
            long min = Math.min(mins.get(owningBucketOrd), newKey);
            preparedRoundings = new Rounding.Prepared[roundingInfos.length];
                @Override
import org.opensearch.search.internal.SearchContext;
        DateHistogramAggregatorBridge bridge = new DateHistogramAggregatorBridge() {
                    (owningBucket, rounded) -> increaseRoundingIfNeeded(rounded)  // Pass supplier to allow rounding change
import java.util.function.LongToIntFunction;
/*
                mins = context.bigArrays().grow(mins, owningBucketOrd + 1);
             * when considering the optimized path for a single segment. This is necessary since the optimized path
                skiplistCollectorCount++;
                aggregationContext,
            add.accept("skiplist_collectors_used", skiplistCollectorCount);
            deferringCollector.mergeBuckets(mergeMap);
import org.apache.lucene.search.ScoreMode;
                    super.collectRange(min, max);
         * too high we {@link #rebucket} which sets it to 0.
            }
        private LongKeyedBucketOrds.FromSingle bucketOrds;
             * Quick explanation of the two below conditions:
            if (oldEstimatedBucketCount <= targetBuckets * roundingInfos[oldRounding].getMaximumInnerInterval()
    /**
    @Override
            return owningBucketOrd < roundingIndices.size() ? roundingIndices.get(owningBucketOrd) : 0;
 * license agreements. See the NOTICE file distributed with
             * than our targetBuckets limit. If the current count of buckets exceeds this limit we must update
    ) throws IOException {
         * During collection we use overestimates for how much buckets are save
                        long value = values.nextValue();
    }
import org.opensearch.search.aggregations.bucket.MergingBucketsDeferringCollector;
                        roundingIdx = collectValue(owningBucketOrd, roundingIdx, doc, rounded);
                InternalAutoDateHistogram.BucketInfo emptyBucketInfo = new InternalAutoDateHistogram.BucketInfo(
    private static class FromMany extends AutoDateHistogramAggregator {
                return;
            if (oldRounding >= roundingInfos.length - 1) {
                    if (bestDuration <= temp * curRoundingInfo.roughEstimateDurationMillis) {
     * isn't good at limiting the number of buckets but is great when the buckets
        if (valuesSource == null) {
        CardinalityUpperBound cardinality,
         * preparedRounding is required to keep total bucket count in compliance with targetBuckets.
        if (valuesSource != null && valuesSource.needsScores()) {
            } while (roundingIdx < roundingInfos.length - 1
         * think that it wouldn't matter, but its seriously 7%-15% performance
            mins.set(owningBucketOrd, preparedRoundings[newRounding].round(mins.get(owningBucketOrd)));
             * 2. Must span a range of [low, high] with buckets <= targetBuckets
                while (roundingIdx < roundingInfos.length - 1) {
                    sub,
                factories,
            mins.set(owningBucketOrd, min);
     * The second heuristic it uses to trigger promotion to a coarser rounding is
        @Override
             * DAYS_OF_MONTH rounding where the maximum inner interval is 7 days (i.e. 1 week buckets).
            RoundingInfo[] roundingInfos,
            }
             * skips doc collection entirely which is where the preparedRounding is normally updated.
                        return;
                }
                    liveBucketCountUnderestimate = context.bigArrays().grow(liveBucketCountUnderestimate, owningBucketOrd + 1);
     * Initially it uses the most fine grained rounding configuration possible
            mins = context.bigArrays().newLongArray(1, false);
                docCount,
        Map<String, Object> metadata
import static org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge.segmentMatchAll;
    ) throws IOException {
    @Override
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
                long bestDuration = (high - low) / targetBuckets;
                        long newBucketOrd = bucketOrds.add(owningBucketOrd, newKey);
            add.accept("surviving_buckets", bucketOrds.size());
import org.apache.lucene.index.SortedNumericDocValues;
     * that are valid for the current rounding exceeds the budget then we rebucket
/*
 * The OpenSearch Contributors require contributions made to
                    () -> bucketOrds,
            String name,
                return new HistogramSkiplistLeafCollector(
                name,
import org.opensearch.search.aggregations.Aggregator;
             * getMaximumRoughEstimateDurationMillis is 60000. If our current total range in millis (max - min)
    protected Rounding.Prepared preparedRounding;
                }
        SearchContext aggregationContext,
                    }
        /**
                // buckets ordered by key in ascending order
            maxes = context.bigArrays().newLongArray(1, false);
         * estimated, bucket counts, {@link FromMany#rebucket()} rebucketing} the all
            }
                        break;
        }
            maxes.set(owningBucketOrd, max);
     */
 * standpoint but the simpler implementation is between 7% and 15% faster
                newRounding++;
        protected void doClose() {
    protected int roundingIdx;
import org.opensearch.search.aggregations.bucket.DeferringBucketCollector;
        filterRewriteOptimizationContext = new FilterRewriteOptimizationContext(bridge, parent, subAggregators.length, context);
                valuesSourceConfig,
                maxes.fill(oldSize, maxes.size(), Long.MIN_VALUE);
                rebucket();
    @Override
                    }
            rebucket();
             * replay the hits and build the buckets. How much faster is not clear,
}
            segmentMatchAll(context, ctx),
                    }
import java.util.Collections;
 * <p>
    private AutoDateHistogramAggregator(
     * but as more data arrives it rebuckets the data until it "fits" in the
        DocValuesSkipper skipper = null;
                roundingInfos,
         * An over estimate of the number of wasted buckets. When this gets
             * 1 day buckets possible such that if we re-bucket to 1 week buckets we will have more 1 week buckets
            roundingIndices.set(owningBucketOrd, (byte) newRounding);
                        increaseRoundingIfNeeded(owningBucketOrd, estimatedBucketCount, rounded, roundingIdx);
        );
            skipper = ctx.reader().getDocValuesSkipper(this.fieldName);
            Map<String, Object> metadata
 * You may obtain a copy of the License at
import org.opensearch.search.aggregations.AggregatorFactories;
        this.roundingInfos = roundingInfos;
                targetBuckets,
            Function<Rounding, Rounding.Prepared> roundingPreparer,
            protected Function<Long, Long> bucketOrdProducer() {
            @Override
    private final DocValueFormat formatter;
    }
        String name,
                public void collect(int doc, long owningBucketOrd) throws IOException {
                return canOptimize(valuesSourceConfig, roundingInfos[0].rounding);
 */
                wastedBucketsOverestimate = 0;
            0,
        SearchContext aggregationContext,
