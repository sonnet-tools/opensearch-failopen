                reduceOrder,
        public LongTermsResults(boolean showTermDocCountError) {
                        tempBucket1.bucketOrd = leftOrd;
        @Override
        SortedNumericDocValues values = resultStrategy.getValues(ctx);
        protected IntArray reusableIndices;
        DocValueFormat format,
                order,
        DoubleTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
    @Override
            DoubleTerms.Bucket result = new DoubleTerms.Bucket(
                result.add(buildFinalBucket(selectedOrd, value, docCount, owningBucketOrd));
                List<B> result = new ArrayList<>(candidateCount);
            super(showTermDocCountError);
    }
        }
        /**
            } else if (reusableIndices.size() < valueCount) {
                InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
 * compatible open source license.
        LongTerms buildEmptyResult() {
            return result;
            } else {
import static java.util.Collections.emptyList;
                long value = bucketOrds.get(selectedOrd);
         * Turn the buckets into an aggregation result.
    public StreamNumericTermsAggregator(
                order,
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
        abstract B[][] buildTopBucketsPerOrd(int size);
        abstract B createTempBucket();
                bucketCountThresholds.getShardSize(),
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            };
                    long otherValue = bucketOrds.get(other.bucketOrd);
         * Build a final bucket directly with the provided data, skipping temporary bucket creation.
            public void collect(int doc, long owningBucketOrd) throws IOException {
        }
            return new DoubleTerms(
            // Override in subclasses if needed
            return new LongTerms.Bucket(0, 0, null, showTermDocCountError, 0, format) {
            }
                Numbers.toUnsignedBigInteger(value),
 * this file be licensed under the Apache-2.0 license or a
            return new UnsignedLongTerms(
        ) throws IOException {
        return resultStrategy.buildEmptyResult();
                    long leftDocCount = StreamNumericTermsAggregator.this.bucketDocCount(leftOrd);
                order,
            bucketOrds.close();
                docCount,
        @Override
import java.io.IOException;
import org.opensearch.common.Numbers;
        UnsignedLongTerms.Bucket buildFinalBucket(long ord, long value, long docCount, long owningBucketOrd) {
         */
        }
                public int compareKey(UnsignedLongTerms.Bucket other) {
                        tempBucket1.docCount = StreamNumericTermsAggregator.this.bucketDocCount(leftOrd);
    private final IncludeExclude.LongFilter longFilter;
    public class UnsignedLongTermsResults extends StandardTermsResultStrategy<UnsignedLongTerms, UnsignedLongTerms.Bucket> {
        }
        LongTerms.Bucket[] buildBuckets(int size) {
            );
            return new LongTerms.Bucket[size];
         */
            long totalDocCount = 0;
                name,
                    };
    }
                            }
                checkCancelled();
    }
        Releasables.close(super::doClose, bucketOrds, resultStrategy);
                showTermDocCountError,
        CardinalityUpperBound cardinality,
                List.of(topBuckets),
     * UnsignedLongTermsResults for numeric terms
                                    bucketOrdinal = -1 - bucketOrdinal;
            reusableIndices = null;
                    if (values.advanceExact(docId)) {
 */
            }
                @Override
         * information that this result type may need.
                if (values.advanceExact(doc)) {
        final void buildSubAggs(B[][] topBucketsPerOrd) throws IOException {
            result.bucketOrd = ord;
    }
                        selectedDocCount += docCount;
                    long rightDocCount = StreamNumericTermsAggregator.this.bucketDocCount(rightOrd);
import org.opensearch.search.DocValueFormat;
     * DoubleTermsResults for numeric terms
         */
                order,
                    bucketCountThresholds,
        /**
import org.opensearch.common.lease.Releasables;
            SelectionResult(List<B> buckets, long otherDocCount) {
                    reusableIndices.set(i, reusableIndices.get(j));
        }
                name,
                            if (longFilter == null || longFilter.accept(value)) {
            if (isKeyOrder(order) == false) {
        final LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
                SortedNumericDocValues values = getValues(ctx);
        @Override
                    int temp = reusableIndices.get(i);
                        "Streaming aggregation does not support key-based ordering for numeric fields. "
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
            buildSubAggs(topBucketsPerOrd);
        DoubleTerms.Bucket createTempBucket() {
import java.util.ArrayList;
            };
                SelectionResult<B> selectionResult = selectTopBuckets(
                null,
            }
        IncludeExclude.LongFilter longFilter,
                this.buckets = buckets;
            }
                    owningBucketOrds[ordIdx]
     *
        this.segmentTopN = segmentTopN;
        }
        public UnsignedLongTermsResults(boolean showTermDocCountError) {
                List.of(topBuckets),
         */
                        for (int v = 0; v < valueCount; ++v) {
import org.apache.lucene.index.SortedNumericDocValues;
import org.opensearch.common.util.IntArray;
            // Build result directly from selected ordinals (O(segmentSize) instead of O(totalBuckets * segmentSize))
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);
        @Override
            long selectedDocCount = 0;
        @Override
                long docCount = StreamNumericTermsAggregator.this.bucketDocCount(selectedOrd);
            return new DoubleTerms(
        protected void ensureOrdinalComparator() {
                topBucketsPerOrd[ordIdx] = buildBuckets(selectionResult.buckets.size());
            result.setDocCountError(0);
                for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
                0,
        add.accept("result_strategy", resultStrategy.describe());
                    long docCount = StreamNumericTermsAggregator.this.bucketDocCount(ordsEnum.ord());
        }
     */
         * shard.
            return new UnsignedLongTerms.Bucket[size];
    private final ResultStrategy<?, ?> resultStrategy;
            };
                }
            // we need to fill-in the blanks
        LongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
    }
            super(showTermDocCountError);
            );
            );
                @Override
                bucketCountThresholds.getShardSize(),
import org.apache.lucene.util.IntroSelector;
                    long thisValue = bucketOrds.get(this.bucketOrd);
        SearchContext aggregationContext,
            Releasable {
    }
                bucketCountThresholds
import org.opensearch.search.internal.SearchContext;
    /**
            if (isKeyOrder(order) == false) {
        DoubleTerms.Bucket buildFinalBucket(long ord, long value, long docCount, long owningBucketOrd) {
                @Override
                    topBucketsPerOrd[ordIdx][i] = selectionResult.buckets.get(i);
                @Override
            if (ordinalComparator == null) {
package org.opensearch.search.aggregations.bucket.terms;
                reduceOrder = InternalOrder.key(true);
                        if (previous != val || i == 0) {
            List<B> result = new ArrayList<>(segmentSize);
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            IntroSelector selector = new IntroSelector() {
        add.accept("total_buckets", bucketOrds == null ? 0 : bucketOrds.size());
                        result.add(buildFinalBucket(ordsEnum.ord(), ordsEnum.value(), docCount, owningBucketOrd));
        UnsignedLongTerms.Bucket createTempBucket() {
                LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
                metadata(),
                otherDocCount,
import org.opensearch.search.aggregations.LeafBucketCollector;
                if (isKeyOrder(order)) {
                name,
import org.apache.logging.log4j.Logger;
        @Override
            this.showTermDocCountError = showTermDocCountError;
            super(showTermDocCountError);
                format,
        @Override
        UnsignedLongTerms buildResult(long owningBucketOrd, long otherDocCount, UnsignedLongTerms.Bucket[] topBuckets) {
                }
            }
            }
            }
            return new LongTerms(
                    pivotOrdinal = reusableIndices.get(i);
                return;
        return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, values) {
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
        final void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {
            final BucketOrder reduceOrder;
        Function<StreamNumericTermsAggregator, ResultStrategy<?, ?>> resultStrategy,
        /**
            return "stream_double_terms";
        StandardTermsResultStrategy(boolean showTermDocCountError) {
                bucketCountThresholds
                Arrays.sort(topBuckets, reduceOrder.comparator());
            int candidateCount = 0;
        }
         */
                showTermDocCountError,
         */
            }
                0,
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
                format
     */
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
         * Wrap the "standard" numeric terms collector to collect any more
        @Override
        }
                    // instead of ordinals. Ordinals are assigned dynamically and don't guarantee numeric order.
            );
                order,
                        int valueCount = values.docValueCount();
        return resultStrategy.buildAggregationsBatch(owningBucketOrds);
                int pivotOrdinal;
            for (int i = 0; i < segmentSize; i++) {
}
            }
                reduceOrder = InternalOrder.key(true);
            return valuesSource.longValues(ctx);
                        }
                0,
                        tempBucket2.bucketOrd = rightOrd;
         * are asigned to the value returned by {@link #buildTopBucketsPerOrd}.
                                    collectExistingBucket(sub, doc, bucketOrdinal);
/**
            }
        /**
import org.apache.lucene.index.LeafReaderContext;
        protected Aggregator.BucketComparator ordinalComparator;
        @Override
    private LongKeyedBucketOrds bucketOrds;
                );
        LongTerms.Bucket buildFinalBucket(long ord, long value, long docCount, long owningBucketOrd) {
            return new LongTerms.Bucket[size][];
                        long val = values.nextValue();
        /**
        @Override
    public InternalAggregation buildEmptyAggregation() {
            long[] otherDocCount = new long[owningBucketOrds.length];
                        }
        if (bucketOrds != null) {
                    long otherValue = bucketOrds.get(other.bucketOrd);
        abstract B[] buildBuckets(int size);
 * SPDX-License-Identifier: Apache-2.0
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
        bucketOrds = null;
    public void collectDebugInfo(BiConsumer<String, Object> add) {
            return result;
        }
import org.opensearch.search.aggregations.support.ValuesSource;
        protected B tempBucket2;
        }
                @Override
                    if (ordinalComparator != null) {
        }
        }
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum,
        });
import java.util.function.Function;
                }
import org.apache.lucene.util.NumericUtils;
     */
        DoubleTerms.Bucket[] buildBuckets(int size) {
        this.cardinality = cardinality;
         * Resolve the doc values to collect results of this type.
                metadata(),
        abstract B buildFinalBucket(long ord, long value, long docCount, long owningBucketOrd) throws IOException;
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
        }
import org.opensearch.common.lease.Releasable;
                long docCount = StreamNumericTermsAggregator.this.bucketDocCount(ordsEnum.ord());
        DoubleTerms buildEmptyResult() {
                protected void swap(int i, int j) {
        }
import org.opensearch.search.aggregations.CardinalityUpperBound;
                for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {
        @Override
    }
        this.longFilter = longFilter;
            );
    public class LongTermsResults extends StandardTermsResultStrategy<LongTerms, LongTerms.Bucket> {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        String name,
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
                return new SelectionResult<>(result, totalDocCount - selectedDocCount);
                bucketCountThresholds.getShardSize(),
        /**
                reduceOrder = order;
                otherDocCount,
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {
                0,
    public class DoubleTermsResults extends StandardTermsResultStrategy<DoubleTerms, DoubleTerms.Bucket> {
            LongTerms.Bucket result = new LongTerms.Bucket(value, docCount, null, showTermDocCountError, 0, format);
         * Build the sub-aggregations into the buckets. This will usually
                }
                    }
        }
            return FieldData.toSortableLongBits(valuesSource.doubleValues(ctx));
            return "stream_long_terms";
        UnsignedLongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
        }
                emptyList(),
        protected B tempBucket1;
            return new LongTerms(
            long owningBucketOrd
        }
                bucketCountThresholds
     * Strategy for building results.
            ensureOrdinalComparator();
            result.bucketOrd = ord;
        @Override
            int segmentSize,
            UnsignedLongTerms.Bucket result = new UnsignedLongTerms.Bucket(
                    // instead of ordinals. Ordinals are assigned dynamically and don't guarantee numeric order.
                    long previous = Long.MAX_VALUE;
    }
        }
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
                    long thisValue = bucketOrds.get(this.bucketOrd);
        /**
                }
                if (docCount >= thresholds.getMinDocCount()) {
        abstract void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException;
        }
                    reusableIndices.set(j, temp);
                0,
                bucketCountThresholds
 *
     *
                order,
import org.opensearch.index.fielddata.FieldData;
                0,
                for (int i = 0; i < topBucketsPerOrd[ordIdx].length; i++) {
         * Build an "empty" result. Only called if there isn't any data on this
import java.util.function.BiConsumer;
    public void doClose() {
                                    collectBucket(sub, doc, bucketOrdinal);
            prepareIndicesArray(totalBuckets);
    private static final Logger logger = LogManager.getLogger(StreamNumericTermsAggregator.class);
            if (bucketOrds == null) { // no data collected
                            previous = val;
        @Override
                    ordinalComparator = (leftOrd, rightOrd) -> {
            }
                    long otherValue = bucketOrds.get(other.bucketOrd);
        this.resultStrategy = resultStrategy.apply(this); // ResultStrategy needs a reference to the Aggregator to do its job.
import java.util.List;
    }
                format,
                null,
        @Override
                protected void setPivot(int i) {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
     *
                Arrays.sort(topBuckets, reduceOrder.comparator());
    @Override
        @Override
                    tempBucket1 = createTempBucket();
                format,
        AggregatorFactories factories,
        @Override
                    tempBucket2 = createTempBucket();
                this.otherDocCount = otherDocCount;
     */
        private InternalAggregation[] buildAggregationsBatch(long[] owningBucketOrds) throws IOException {
    }
            return new UnsignedLongTerms.Bucket[size][];
                showTermDocCountError,
                                } else {
                0,
        @Override
    private final CardinalityUpperBound cardinality;
            while (ordsEnum.next()) {
                format,
            } else {
                    reusableIndices.set(candidateCount++, (int) ordsEnum.ord());
        }
 * Aggregate all docs that contain numeric terms through streaming
                int selectedOrd = reusableIndices.get(i);
        @Override
import org.opensearch.search.aggregations.BucketOrder;
                reduceOrder = order;
            }
        this.valuesSource = valuesSource;
                order,
            );
        /**
                }
import org.opensearch.search.aggregations.InternalOrder;
 * @opensearch.internal
                metadata(),
        UnsignedLongTerms.Bucket[] buildBuckets(int size) {
                reusableIndices = context.bigArrays().grow(reusableIndices, valueCount);
        @Override
        }
     * @opensearch.internal
                                if (bucketOrdinal < 0) { // already seen
        abstract SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException;
        LongTerms buildResult(long owningBucketOrd, long otherDocCount, LongTerms.Bucket[] topBuckets) {
        abstract R buildResult(long owningBucketOrd, long otherDocCounts, B[] topBuckets);
                bucketCountThresholds.getShardSize(),
        }
                }
         * and required.
                0,
 *
                }
         */
                format
        }
        }
                long bucketsInOrd = bucketOrds.bucketsInOrd(owningBucketOrds[ordIdx]);
        Map<String, Object> metadata
                order,
            return new DoubleTerms.Bucket[size][];
        DoubleTerms buildResult(long owningBucketOrd, long otherDocCount, DoubleTerms.Bucket[] topBuckets) {
                    }
        UnsignedLongTerms buildEmptyResult() {
                                long bucketOrdinal = bucketOrds.add(owningBucketOrd, val);
        public final void close() {
                        return -ordinalComparator.compare(leftOrd, rightOrd);
                    return Double.compare(NumericUtils.sortableLongToDouble(thisValue), NumericUtils.sortableLongToDouble(otherValue));
                    // For tie-breaking when sub-aggregation values are equal, compare actual bucket values
        }
            result.setDocCountError(0);
        @Override
        String describe() {
                    for (int i = 0; i < valuesCount; ++i) {
                order,
        private static class SelectionResult<B> {
                collectZeroDocEntriesIfNeeded(owningBucketOrds[ordIdx]);
        LongTerms.Bucket createTempBucket() {
        @Override
         * output to help with debugging.
                    // instead of ordinals. Ordinals are assigned dynamically and don't guarantee numeric order.
                    results[ordIdx] = buildEmptyResult();
            result.bucketOrd = ord;
            return new UnsignedLongTerms(
        /**
                return;
        abstract R buildEmptyResult();
                }
import org.apache.logging.log4j.LogManager;
        @Override
                            }
         * Collect extra entries for "zero" hit documents if they were requested
                    int valuesCount = values.docValueCount();
                selectedDocCount += docCount;
                showTermDocCountError,
                }
        }
                    long leftOrd = reusableIndices.get(j);
                emptyList(),
     * @opensearch.internal
                reduceOrder = order;
                reduceOrder,
        }
                    // For tie-breaking when sub-aggregation values are equal, compare actual bucket values
        }
            return result;
            BucketCountThresholds thresholds,
                ordsEnum = bucketOrds.ordsEnum(owningBucketOrd);
                    }
                docCount,
        ValuesSource.Numeric valuesSource,
                bucketCountThresholds.getShardSize(),
            }
                }
         */
        protected final boolean showTermDocCountError;
            }
            @Override
            };
        }
    private final int segmentTopN;
                            if ((longFilter == null) || (longFilter.accept(val))) {
                    );
        int segmentTopN,
                otherDocCount,
            }
                metadata(),
                            + "Use traditional aggregation approach instead."
                List.of(topBuckets),
         * Short description of the collection mechanism added to the profile
    public abstract class ResultStrategy<R extends InternalAggregation, B extends InternalMultiBucketAggregation.InternalBucket>
            return new DoubleTerms.Bucket(0.0, 0, null, showTermDocCountError, 0, format) {
            segmentSize = Math.min(segmentSize, candidateCount);
                    throw new IllegalArgumentException(
                reduceOrder = InternalOrder.key(true);
        }
                    }
            B[][] topBucketsPerOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
        SubAggCollectionMode subAggCollectMode,
            final List<B> buckets;
public class StreamNumericTermsAggregator extends TermsAggregator {
                emptyList(),
        implements
            return result;
         * delegate to {@link #buildSubAggsForAllBuckets}.
    /**
                showTermDocCountError,
                    ordsEnum,
        @Override
    @Override
import org.opensearch.search.aggregations.AggregatorFactories;
        @Override
    }
import java.util.Arrays;
            );
        }
            }
 * The OpenSearch Contributors require contributions made to
            return new SelectionResult<>(result, totalDocCount - selectedDocCount);
         */
        super.doReset();
                otherDocCount[ordIdx] = selectionResult.otherDocCount;
import org.opensearch.search.aggregations.InternalAggregation;
                0,
                metadata(),
        ResultStrategy<R, B> {
                0,
                showTermDocCountError,
                long selectedDocCount = 0;
                reusableIndices = context.bigArrays().newIntArray(valueCount, false);
        @Override
                result[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCount[ordIdx], topBucketsPerOrd[ordIdx]);
                name,
        super.collectDebugInfo(add);
                while (ordsEnum.next()) {
            return primary;
        private SelectionResult<B> selectTopBuckets(
                NumericUtils.sortableLongToDouble(value),
                name,
import org.opensearch.search.aggregations.Aggregator;
        Releasables.close(bucketOrds);
                    if (docCount >= thresholds.getMinDocCount()) {
            if (bucketCountThresholds.getMinDocCount() != 0) {
            if (candidateCount <= segmentSize) {
                }
         * Build an array to hold the "top" buckets for each ordinal.
        }
                                }
                    // Fallback to doc count for _count ordering
        super(name, factories, aggregationContext, parent, bucketCountThresholds, order, format, subAggCollectMode, metadata);
                } else if (partiallyBuiltBucketComparator != null) {
                reduceOrder,
         * Build an array of buckets for a particular ordinal. These arrays
            if (InternalOrder.isCountDesc(order) && bucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {
            final BucketOrder reduceOrder;
    @Override
        @Override
        public DoubleTermsResults(boolean showTermDocCountError) {
                0,
                    return Long.compare(leftDocCount, rightDocCount);
                format,
    public void doReset() {
                    segmentTopN,
    ) throws IOException {
                public int compareKey(DoubleTerms.Bucket other) {
        @Override
                        return partiallyBuiltBucketComparator.compare(tempBucket1, tempBucket2);
        }
            return new DoubleTerms.Bucket[size];
        private void prepareIndicesArray(long valueCount) {
        String describe() {
                public int compareKey(LongTerms.Bucket other) {
                }
    private final ValuesSource.Numeric valuesSource;
            final long otherDocCount;
        @Override
        /**
         */
        }
                protected int comparePivot(int j) {
    /**
    abstract class StandardTermsResultStrategy<R extends InternalMappedTerms<R, B>, B extends InternalTerms.Bucket<B>> extends
     * LongTermsResults for numeric terms
    /**
                    return Long.compare(thisValue, otherValue);
        abstract void buildSubAggs(B[][] topBucketsPerOrd) throws IOException;
            final BucketOrder reduceOrder;
            selector.select(0, candidateCount, segmentSize);
        }
     * @opensearch.internal
    }
        @Override
        Aggregator parent,
            InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
import java.util.Map;
            Releasables.close(reusableIndices);
                            long value = values.nextValue();
                logger.debug("Cardinality post collection for ordIdx {}: {}", ordIdx, bucketsInOrd);
                bucketCountThresholds
                showTermDocCountError,
            return new UnsignedLongTerms.Bucket(Numbers.toUnsignedBigInteger(0), 0, null, showTermDocCountError, 0, format) {
            long totalBuckets,
        protected void ensureOrdinalComparator() {
        BucketOrder order,
            if (reusableIndices == null) {
                    // For tie-breaking when sub-aggregation values are equal, compare actual bucket values
            } else {
                format,
            result.setDocCountError(0);
            return valuesSource.longValues(ctx);
                bucketCountThresholds
                    long rightOrd = pivotOrdinal;
        }
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
    @Override
        BucketCountThresholds bucketCountThresholds,
        abstract String describe();
                @Override
            return "stream_unsigned_long_terms";
                return results;
/*
    @Override
            );
                                bucketOrds.add(owningBucketOrd, value);
                name,
        String describe() {
 */
                    long thisValue = bucketOrds.get(this.bucketOrd);
        }
                        tempBucket2.docCount = StreamNumericTermsAggregator.this.bucketDocCount(rightOrd);
                metadata(),
                showTermDocCountError,
                bucketCountThresholds.getShardSize(),
                    return Long.compareUnsigned(thisValue, otherValue);
                Arrays.sort(topBuckets, reduceOrder.comparator());
            if (isKeyOrder(order) == false) {
                totalDocCount += docCount;
                    bucketsInOrd,
        }
