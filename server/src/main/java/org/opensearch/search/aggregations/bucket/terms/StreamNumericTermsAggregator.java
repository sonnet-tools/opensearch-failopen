            return new UnsignedLongTerms(
            result.bucketOrd = ord;
        @Override
                    reusableIndices.set(j, temp);
        }
    }
                Arrays.sort(topBuckets, reduceOrder.comparator());
                bucketCountThresholds
         * Turn the buckets into an aggregation result.
                }
            return valuesSource.longValues(ctx);
         * Build an array of buckets for a particular ordinal. These arrays
        @Override  
         * delegate to {@link #buildSubAggsForAllBuckets}.  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;  
    @Override
     *
            for (int i = 0; i < segmentSize; i++) {
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
                bucketCountThresholds.getShardSize(),
        }
         * Short description of the collection mechanism added to the profile
        });
     *  
                List.of(topBuckets),  
        }
                showTermDocCountError,
                    long otherValue = bucketOrds.get(other.bucketOrd);  
        @Override
        SubAggCollectionMode subAggCollectMode,
        }  
        String name,
                for (int i = 0; i < topBucketsPerOrd[ordIdx].length; i++) {
                null,
        /**
     * @opensearch.internal
         */  
                otherDocCount,  
                @Override
         */
                order,
import org.opensearch.search.aggregations.AggregatorFactories;
            return new DoubleTerms.Bucket[size][];
            }
            this.showTermDocCountError = showTermDocCountError;
                    long leftDocCount = StreamNumericTermsAggregator.this.bucketDocCount(leftOrd);
import org.opensearch.search.aggregations.BucketOrder;  
         * information that this result type may need.
            final long otherDocCount;  
        UnsignedLongTerms buildResult(long owningBucketOrd, long otherDocCount, UnsignedLongTerms.Bucket[] topBuckets) {
                }  
                for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            segmentSize = Math.min(segmentSize, candidateCount);  
 */  
                collectZeroDocEntriesIfNeeded(owningBucketOrds[ordIdx]);
            return new LongTerms.Bucket[size];
                    long docCount = StreamNumericTermsAggregator.this.bucketDocCount(ordsEnum.ord());
            return valuesSource.longValues(ctx);
    }
                LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
        /**  
        ValuesSource.Numeric valuesSource,
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);  
    public void doClose() {
        }  
            result.bucketOrd = ord;  
        public DoubleTermsResults(boolean showTermDocCountError) {
        }
                0,  
                    return Long.compare(leftDocCount, rightDocCount);
                    bucketCountThresholds,
         * shard.
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);  
            } else if (reusableIndices.size() < valueCount) {
            while (ordsEnum.next()) {
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
                    return Double.compare(NumericUtils.sortableLongToDouble(thisValue), NumericUtils.sortableLongToDouble(otherValue));  
        }
        public final void close() {
         */
                long docCount = StreamNumericTermsAggregator.this.bucketDocCount(selectedOrd);
                order,  
        }
            result.setDocCountError(0);
import org.opensearch.common.util.IntArray;
                format
 * The OpenSearch Contributors require contributions made to  
        @Override
            return new DoubleTerms(
            if (isKeyOrder(order) == false) {
        }
                    for (int i = 0; i < valuesCount; ++i) {
            return "stream_unsigned_long_terms";  
            }
                    long previous = Long.MAX_VALUE;
                0,  
            }  
import org.apache.lucene.index.LeafReaderContext;  
         */
                while (ordsEnum.next()) {  
            // Override in subclasses if needed
                0,
                format,  
            }  
        @Override
        abstract R buildResult(long owningBucketOrd, long otherDocCounts, B[] topBuckets);
import java.util.function.BiConsumer;
                        }
            if (ordinalComparator == null) {
        UnsignedLongTerms.Bucket[] buildBuckets(int size) {
        implements
        add.accept("total_buckets", bucketOrds == null ? 0 : bucketOrds.size());  
            return result;
    }
            );
        abstract B buildFinalBucket(long ord, long value, long docCount, long owningBucketOrd) throws IOException;  
        return resultStrategy.buildAggregationsBatch(owningBucketOrds);  
                Arrays.sort(topBuckets, reduceOrder.comparator());  
    public InternalAggregation buildEmptyAggregation() {
                    long leftOrd = reusableIndices.get(j);
                otherDocCount,
                @Override  
        public UnsignedLongTermsResults(boolean showTermDocCountError) {
        LongTerms.Bucket buildFinalBucket(long ord, long value, long docCount, long owningBucketOrd) {
                otherDocCount,
                if (isKeyOrder(order)) {
                showTermDocCountError,
                bucketCountThresholds
                    long otherValue = bucketOrds.get(other.bucketOrd);
    private final ResultStrategy<?, ?> resultStrategy;
                format,  
        }
 *  
                0,
                                bucketOrds.add(owningBucketOrd, value);  
                metadata(),  
        DoubleTerms.Bucket createTempBucket() {
                    if (ordinalComparator != null) {
        }  
        }
        @Override
            List<B> result = new ArrayList<>(segmentSize);
            if (bucketOrds == null) { // no data collected  
     * Strategy for building results.
                        if (previous != val || i == 0) {
            }
        @Override  
        add.accept("result_strategy", resultStrategy.describe());
        abstract B createTempBucket();
                    // For tie-breaking when sub-aggregation values are equal, compare actual bucket values
                    reusableIndices.set(i, reusableIndices.get(j));  
                format,
                }  
        private static class SelectionResult<B> {
                        long val = values.nextValue();  
        LongTerms.Bucket createTempBucket() {
import org.apache.lucene.util.IntroSelector;
        if (bucketOrds != null) {  
                @Override  
                showTermDocCountError,
                bucketCountThresholds.getShardSize(),
        super.doReset();
        AggregatorFactories factories,
                    tempBucket1 = createTempBucket();
                        return partiallyBuiltBucketComparator.compare(tempBucket1, tempBucket2);  
            long[] otherDocCount = new long[owningBucketOrds.length];  
        Releasables.close(bucketOrds);  
        Aggregator parent,  
    ) throws IOException {  
import org.opensearch.search.aggregations.support.ValuesSource;
            }  
                if (docCount >= thresholds.getMinDocCount()) {
            Releasable {
                bucketCountThresholds.getShardSize(),
                    tempBucket2 = createTempBucket();  
        super(name, factories, aggregationContext, parent, bucketCountThresholds, order, format, subAggCollectMode, metadata);
                    // instead of ordinals. Ordinals are assigned dynamically and don't guarantee numeric order.  
            ensureOrdinalComparator();
        }  
                                    collectBucket(sub, doc, bucketOrdinal);
         * Build an "empty" result. Only called if there isn't any data on this
    }
                bucketCountThresholds.getShardSize(),  
                }  
public class StreamNumericTermsAggregator extends TermsAggregator {  
                );  
    private static final Logger logger = LogManager.getLogger(StreamNumericTermsAggregator.class);
                long bucketsInOrd = bucketOrds.bucketsInOrd(owningBucketOrds[ordIdx]);  
                order,  
import java.io.IOException;
    }
    /**
         */
            prepareIndicesArray(totalBuckets);  
        /**
                    long rightOrd = pivotOrdinal;  
                docCount,  
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
        }
        @Override
    public StreamNumericTermsAggregator(  
                name,
        }  
            return new UnsignedLongTerms(  
        final void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {
            LongTerms.Bucket result = new LongTerms.Bucket(value, docCount, null, showTermDocCountError, 0, format);  
        bucketOrds = null;
            } else {
            final BucketOrder reduceOrder;
        /**  
         * and required.  
                @Override
            if (isKeyOrder(order) == false) {
            IntroSelector selector = new IntroSelector() {  
            if (isKeyOrder(order) == false) {  
            );
    @Override  
        DoubleTerms.Bucket[] buildBuckets(int size) {  
                SelectionResult<B> selectionResult = selectTopBuckets(  
                metadata(),
                    }
                    return Long.compare(thisValue, otherValue);
        protected Aggregator.BucketComparator ordinalComparator;
                docCount,
            return result;  
                result[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCount[ordIdx], topBucketsPerOrd[ordIdx]);  
            long owningBucketOrd
import org.apache.lucene.index.SortedNumericDocValues;
        }
        super.collectDebugInfo(add);
        }
    public abstract class ResultStrategy<R extends InternalAggregation, B extends InternalMultiBucketAggregation.InternalBucket>  
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
                reusableIndices = context.bigArrays().grow(reusableIndices, valueCount);  
    public void collectDebugInfo(BiConsumer<String, Object> add) {  
         */  
        }
                int pivotOrdinal;
            );
        abstract B[][] buildTopBucketsPerOrd(int size);
                }
                List<B> result = new ArrayList<>(candidateCount);
    }
import org.opensearch.search.DocValueFormat;  
            long totalDocCount = 0;  
        abstract void buildSubAggs(B[][] topBucketsPerOrd) throws IOException;
                showTermDocCountError,  
                reduceOrder = InternalOrder.key(true);
                    };
        }
        }  
        @Override  
            return new DoubleTerms.Bucket[size];
        ResultStrategy<R, B> {
                format,
         */
                SortedNumericDocValues values = getValues(ctx);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
                            if (longFilter == null || longFilter.accept(value)) {
            );  
            };
                order,
            buildSubAggs(topBucketsPerOrd);  
                reduceOrder = InternalOrder.key(true);
import java.util.Arrays;
                bucketCountThresholds
    }  
                reduceOrder = InternalOrder.key(true);  
                emptyList(),
        ) throws IOException {
import org.apache.lucene.util.NumericUtils;  
                this.buckets = buckets;  
                List.of(topBuckets),
                } else if (partiallyBuiltBucketComparator != null) {
        StandardTermsResultStrategy(boolean showTermDocCountError) {
         * Build a final bucket directly with the provided data, skipping temporary bucket creation.
import org.apache.logging.log4j.LogManager;
        public LongTermsResults(boolean showTermDocCountError) {  
         * Collect extra entries for "zero" hit documents if they were requested
        DoubleTerms buildEmptyResult() {
        }  
        @Override
        return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, values) {
                public int compareKey(UnsignedLongTerms.Bucket other) {  
            }
                otherDocCount[ordIdx] = selectionResult.otherDocCount;
                @Override  
                metadata(),  
        @Override
                        tempBucket1.bucketOrd = leftOrd;
import org.opensearch.common.lease.Releasables;  
                                    bucketOrdinal = -1 - bucketOrdinal;
        Function<StreamNumericTermsAggregator, ResultStrategy<?, ?>> resultStrategy,  
        }
            }
                name,
        final void buildSubAggs(B[][] topBucketsPerOrd) throws IOException {  
                            + "Use traditional aggregation approach instead."
    public class LongTermsResults extends StandardTermsResultStrategy<LongTerms, LongTerms.Bucket> {
                ordsEnum = bucketOrds.ordsEnum(owningBucketOrd);  
                Numbers.toUnsignedBigInteger(value),
                order,
                            }
    private final IncludeExclude.LongFilter longFilter;
            return new DoubleTerms.Bucket(0.0, 0, null, showTermDocCountError, 0, format) {
                return new SelectionResult<>(result, totalDocCount - selectedDocCount);
        LongTerms buildEmptyResult() {  
        private SelectionResult<B> selectTopBuckets(
                0,
            // we need to fill-in the blanks  
        /**  
                }
 * this file be licensed under the Apache-2.0 license or a
            @Override  
            } else {  
                metadata(),
package org.opensearch.search.aggregations.bucket.terms;
        @Override  
import org.opensearch.search.aggregations.InternalOrder;
                if (values.advanceExact(doc)) {
     */
        }
                    segmentTopN,  
        UnsignedLongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {  
        @Override
                protected int comparePivot(int j) {
        }
        this.valuesSource = valuesSource;  
                bucketCountThresholds
import java.util.List;
import org.opensearch.index.fielddata.FieldData;
        /**
                return;
                emptyList(),
                checkCancelled();  
         */
        SearchContext aggregationContext,
                long selectedDocCount = 0;
                                } else {
                        selectedDocCount += docCount;
     */
            UnsignedLongTerms.Bucket result = new UnsignedLongTerms.Bucket(
            final BucketOrder reduceOrder;  
                        tempBucket2.bucketOrd = rightOrd;
        abstract SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException;  
            }
        this.segmentTopN = segmentTopN;  
        @Override  
                InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
            super(showTermDocCountError);
                0,  
                name,  
                bucketCountThresholds  
                        tempBucket1.docCount = StreamNumericTermsAggregator.this.bucketDocCount(leftOrd);  
                    results[ordIdx] = buildEmptyResult();  
            int segmentSize,
    public class UnsignedLongTermsResults extends StandardTermsResultStrategy<UnsignedLongTerms, UnsignedLongTerms.Bucket> {  
        UnsignedLongTerms.Bucket buildFinalBucket(long ord, long value, long docCount, long owningBucketOrd) {  
                    // instead of ordinals. Ordinals are assigned dynamically and don't guarantee numeric order.
import org.opensearch.search.internal.SearchContext;  
                metadata(),
                public int compareKey(DoubleTerms.Bucket other) {
/**
                        result.add(buildFinalBucket(ordsEnum.ord(), ordsEnum.value(), docCount, owningBucketOrd));  
                            previous = val;
            if (InternalOrder.isCountDesc(order) && bucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {  
        }
        private void prepareIndicesArray(long valueCount) {
            int candidateCount = 0;
                name,
                order,
     * DoubleTermsResults for numeric terms
    }
                            if ((longFilter == null) || (longFilter.accept(val))) {
            return new UnsignedLongTerms.Bucket[size][];
        Map<String, Object> metadata
    /**
                public int compareKey(LongTerms.Bucket other) {
        @Override
            }
            }
                reduceOrder = order;  
                null,
            SelectionResult(List<B> buckets, long otherDocCount) {
                protected void setPivot(int i) {
                    reusableIndices.set(candidateCount++, (int) ordsEnum.ord());
            result.bucketOrd = ord;
        }  
    /**  
        protected final boolean showTermDocCountError;
                reduceOrder = order;
                    // For tie-breaking when sub-aggregation values are equal, compare actual bucket values
    private LongKeyedBucketOrds bucketOrds;
                    }  
            return new LongTerms(
        }  
        @Override
                    }
                    long thisValue = bucketOrds.get(this.bucketOrd);  
        SortedNumericDocValues values = resultStrategy.getValues(ctx);
        CardinalityUpperBound cardinality,  
        DocValueFormat format,
                emptyList(),  
         * Wrap the "standard" numeric terms collector to collect any more  
            result.setDocCountError(0);
                                if (bucketOrdinal < 0) { // already seen
        abstract B[] buildBuckets(int size);
            }  
        protected B tempBucket2;  
    @Override
            }
import java.util.function.Function;
        protected void ensureOrdinalComparator() {  
        @Override
                            }
        /**
        @Override
                }
                }
                    }  
                showTermDocCountError,  
                    );  
        @Override
                @Override
            return new LongTerms.Bucket[size][];  
                    long thisValue = bucketOrds.get(this.bucketOrd);
        this.longFilter = longFilter;
            return new SelectionResult<>(result, totalDocCount - selectedDocCount);  
        LongTerms.Bucket[] buildBuckets(int size) {
            };  
            return primary;
                bucketCountThresholds.getShardSize(),
 */
     *  
            );  
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
            super(showTermDocCountError);
        }
        @Override
        abstract String describe();
                showTermDocCountError,
                0,
            return new DoubleTerms(  
        return resultStrategy.buildEmptyResult();
                this.otherDocCount = otherDocCount;
                0,  
    private final ValuesSource.Numeric valuesSource;  
                protected void swap(int i, int j) {
        @Override  
                format
                0,
            bucketOrds.close();
        @Override
        }
                                long bucketOrdinal = bucketOrds.add(owningBucketOrd, val);  
     * UnsignedLongTermsResults for numeric terms
import org.opensearch.search.aggregations.CardinalityUpperBound;
            long totalBuckets,
        /**
                format,
import static java.util.Collections.emptyList;
                    if (values.advanceExact(docId)) {
        }  
                metadata(),
        private InternalAggregation[] buildAggregationsBatch(long[] owningBucketOrds) throws IOException {
     */
         * output to help with debugging.
            return "stream_long_terms";
                reduceOrder,  
        @Override  
    /**  
                order,
            return FieldData.toSortableLongBits(valuesSource.doubleValues(ctx));  
/*  
        @Override  
            B[][] topBucketsPerOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
            DoubleTerms.Bucket result = new DoubleTerms.Bucket(
            InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
                }
                }
                    topBucketsPerOrd[ordIdx][i] = selectionResult.buckets.get(i);
        String describe() {  
            super(showTermDocCountError);  
                reduceOrder = order;
                        for (int v = 0; v < valueCount; ++v) {  
 * SPDX-License-Identifier: Apache-2.0
    }  
import org.apache.logging.log4j.Logger;
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum,  
         * Resolve the doc values to collect results of this type.
        @Override  
                0,
                                    collectExistingBucket(sub, doc, bucketOrdinal);  
            // Build result directly from selected ordinals (O(segmentSize) instead of O(totalBuckets * segmentSize))
import org.opensearch.search.aggregations.LeafBucketCollector;
        UnsignedLongTerms buildEmptyResult() {
}
        final LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
            long selectedDocCount = 0;  
                int selectedOrd = reusableIndices.get(i);
                reduceOrder,
                    long otherValue = bucketOrds.get(other.bucketOrd);
                        }  
                name,
        @Override
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
                        return -ordinalComparator.compare(leftOrd, rightOrd);
         */
            final List<B> buckets;
        @Override
    public void doReset() {
     * @opensearch.internal  
        BucketOrder order,  
                selectedDocCount += docCount;  
                showTermDocCountError,
                showTermDocCountError,  
    @Override  
    @Override
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            Releasables.close(reusableIndices);
                for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {  
                                }  
        abstract void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException;
            );  
                    long rightDocCount = StreamNumericTermsAggregator.this.bucketDocCount(rightOrd);  
        DoubleTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
import org.opensearch.common.Numbers;
            public void collect(int doc, long owningBucketOrd) throws IOException {
            return new LongTerms(
            } else {
    @Override  
 * Aggregate all docs that contain numeric terms through streaming
import org.opensearch.search.aggregations.InternalAggregation;
                long value = bucketOrds.get(selectedOrd);  
        IncludeExclude.LongFilter longFilter,
                }  
            return new UnsignedLongTerms.Bucket(Numbers.toUnsignedBigInteger(0), 0, null, showTermDocCountError, 0, format) {
         * Build an array to hold the "top" buckets for each ordinal.  
            result.setDocCountError(0);
                order,
import org.opensearch.search.aggregations.Aggregator;
         * are asigned to the value returned by {@link #buildTopBucketsPerOrd}.  
                return;
        /**  
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                        int valueCount = values.docValueCount();
        protected void ensureOrdinalComparator() {
                    // instead of ordinals. Ordinals are assigned dynamically and don't guarantee numeric order.
        abstract R buildEmptyResult();
            BucketCountThresholds thresholds,  
                reduceOrder,
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {
        this.cardinality = cardinality;
            if (reusableIndices == null) {  
import java.util.ArrayList;  
        }  
        }  
                        tempBucket2.docCount = StreamNumericTermsAggregator.this.bucketDocCount(rightOrd);
        }  
 *
                }
            final BucketOrder reduceOrder;
    private final CardinalityUpperBound cardinality;  
                    int temp = reusableIndices.get(i);
         */  
                    // Fallback to doc count for _count ordering
        DoubleTerms.Bucket buildFinalBucket(long ord, long value, long docCount, long owningBucketOrd) {
                result.add(buildFinalBucket(selectedOrd, value, docCount, owningBucketOrd));
        DoubleTerms buildResult(long owningBucketOrd, long otherDocCount, DoubleTerms.Bucket[] topBuckets) {
     * LongTermsResults for numeric terms
            );
                    // For tie-breaking when sub-aggregation values are equal, compare actual bucket values  
            selector.select(0, candidateCount, segmentSize);
    public class DoubleTermsResults extends StandardTermsResultStrategy<DoubleTerms, DoubleTerms.Bucket> {  
        }
import java.util.Map;  
                    int valuesCount = values.docValueCount();  
                }
            }
        String describe() {
                logger.debug("Cardinality post collection for ordIdx {}: {}", ordIdx, bucketsInOrd);
                0,
import org.opensearch.common.lease.Releasable;
        /**
                name,  
                bucketCountThresholds  
        LongTerms buildResult(long owningBucketOrd, long otherDocCount, LongTerms.Bucket[] topBuckets) {  
                topBucketsPerOrd[ordIdx] = buildBuckets(selectionResult.buckets.size());  
        UnsignedLongTerms.Bucket createTempBucket() {  
        @Override
    }
            );
                    if (docCount >= thresholds.getMinDocCount()) {
                bucketCountThresholds.getShardSize(),  
            reusableIndices = null;  
        protected IntArray reusableIndices;  
                List.of(topBuckets),
    }
        LongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
                reusableIndices = context.bigArrays().newIntArray(valueCount, false);
    private final int segmentTopN;
                    long thisValue = bucketOrds.get(this.bucketOrd);
        @Override  
 * @opensearch.internal
                    ordinalComparator = (leftOrd, rightOrd) -> {
                format,
            return result;
            return "stream_double_terms";
                totalDocCount += docCount;  
        }
            if (bucketCountThresholds.getMinDocCount() != 0) {  
        BucketCountThresholds bucketCountThresholds,
        }  
            return result;  
        Releasables.close(super::doClose, bucketOrds, resultStrategy);
                return results;
                long docCount = StreamNumericTermsAggregator.this.bucketDocCount(ordsEnum.ord());
     * @opensearch.internal
            };
                        "Streaming aggregation does not support key-based ordering for numeric fields. "
    }
                    pivotOrdinal = reusableIndices.get(i);  
     */
        }  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
            }
            return new LongTerms.Bucket(0, 0, null, showTermDocCountError, 0, format) {  
                NumericUtils.sortableLongToDouble(value),  
            }
                    throw new IllegalArgumentException(  
                Arrays.sort(topBuckets, reduceOrder.comparator());
        int segmentTopN,
                order,  
                    bucketsInOrd,
    abstract class StandardTermsResultStrategy<R extends InternalMappedTerms<R, B>, B extends InternalTerms.Bucket<B>> extends  
                            long value = values.nextValue();
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {  
                    owningBucketOrds[ordIdx]
            };  
        String describe() {
                    return Long.compareUnsigned(thisValue, otherValue);
        }
                    ordsEnum,
            return new UnsignedLongTerms.Bucket[size];  
 * compatible open source license.
        protected B tempBucket1;
        }
        this.resultStrategy = resultStrategy.apply(this); // ResultStrategy needs a reference to the Aggregator to do its job.
         * Build the sub-aggregations into the buckets. This will usually
            if (candidateCount <= segmentSize) {
