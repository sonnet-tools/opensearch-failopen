    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    // flat array, producing identical inner bucket lists for every parent bucket.
import org.apache.lucene.util.IntroSelector;
                    protected void swap(int i, int j) {
        InternalAggregation[] buildAggregationsBatch(long[] owningBucketOrds) throws IOException {
                metadata(),
            result.bucketOrd = bucketOrd;
         * information that this result type may need.
                    }
    @Override
                boolean ascending = InternalOrder.isKeyAsc(order);
            }
    protected int segmentsWithSingleValuedOrds = 0;
                return new SelectionResult<>(result, totalDocCount - selectedDocCount);
            long bucketsForOwner = bucketOrds.bucketsInOrd(owningBucketOrd);
                        candidateBucketOrds.set(cnt++, bucketOrd);
     * @opensearch.internal
 */
                        pivotBucketOrd = candidateBucketOrds.get(i);
        @Override
        SortedDocValues singleValues = DocValues.unwrapSingleton(sortedDocValuesPerBatch);
        super.doReset();
         */
                    }
                tempBucket2 = new StringTerms.Bucket(null, 0, null, false, 0, format) {
                0,
        abstract B[][] buildTopBucketsPerOrd(int size);
                // scoped), so bucketDocCount reads the right value.
                    long docCount = bucketDocCount(bucketOrd);
                    }
        }
import org.apache.lucene.index.DocValues;
/*
    private StringTerms.Bucket tempBucket1;
                }
                checkCancelled();
                showTermDocCountError,
        String describe() {
                for (int i = 0; i < effectiveSegmentSize; i++) {
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
    @Override
    public StreamStringTermsAggregator(
        String name,
                int effectiveSegmentSize = Math.min(segmentSize, cnt);
        /**
         * Build the sub-aggregations into the buckets. This will usually
                    List<B> result = new ArrayList<>(cnt);
            }
import org.opensearch.search.aggregations.AggregatorFactories;
                }.sort(0, effectiveSegmentSize);
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
         * Build a final bucket. {@code bucketOrd} is the composite bucket ordinal
        this.bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
        super.collectDebugInfo(add);
         * delegate to {@link #buildSubAggsForAllBuckets}.
            buildSubAggs(topBucketsPerOwningOrd);
     * StandardTermsResults for string terms
        StringTerms.Bucket[] buildBuckets(int size) {
                            left = candidateBucketOrd;
                        long right;
                    @Override
                Arrays.sort(topBuckets, reduceOrder.comparator());
                tempBucket1 = new StringTerms.Bucket(null, 0, null, false, 0, format) {
                if (false == sortedDocValuesPerBatch.advanceExact(doc)) {
    }
        if (this.leafCollectorCreated) {
        }
                while ((count-- > 0) && (ordinal = sortedDocValuesPerBatch.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {
                        } else {
    private StringTerms.Bucket tempBucket2;
                        long docCount = bucketDocCount(bucketOrd);
                        return Long.compare(this.bucketOrd, other.bucketOrd);
        Map<String, Object> metadata
        SubAggCollectionMode collectionMode,
 * compatible open source license.
                return results;
                    if (false == singleValues.advanceExact(doc)) {
                        long left;
    protected final ResultStrategy<?, ?> resultStrategy;
                    }
                LongKeyedBucketOrds.BucketOrdsEnum enumerator = bucketOrds.ordsEnum(owningBucketOrd);
                    long selectedDocCount = 0;
        super(name, factories, context, parent, order, format, bucketCountThresholds, collectionMode, showTermDocCountError, metadata);
                    return;
 *
        add.accept("result_strategy", resultStrategy.describe());
    private Aggregator.BucketComparator ordinalComparator;
                    @Override
                }
                        }
                logger.debug("Cardinality post collection for ordIdx {}: {}", ordIdx, valueCount);
            );
            @Override
                    for (int i = 0; i < cnt; i++) {
import org.apache.lucene.util.IntroSorter;
        protected ResultStrategy() {}
                        candidateBucketOrds.set(j, tmp);
                SelectionResult<B> selectionResult = selectTopBuckets(owningBucketOrds[ordIdx], segmentTopN, bucketCountThresholds);
            }
        long bucketOrd = bucketOrds.add(owningBucketOrd, segmentOrdinal);
         * Wrap the "standard" numeric terms collector to collect any more
                    }
import org.opensearch.search.DocValueFormat;
    /**
            // Recreate DocValues as needed for concurrent segment search.
        @Override
         * Build an "empty" result. Only called if there isn't any data on this
            SelectionResult(List<B> buckets, long otherDocCount) {
        @Override
        }
                // Match the historical emit order (ascending by segment ordinal, i.e.
                    totalDocCount += docCount;
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
        private SelectionResult<B> selectTopBuckets(long owningBucketOrd, int segmentSize, BucketCountThresholds thresholds)
        StringTerms buildResult(long owningBucketOrd, long otherDocCount, StringTerms.Bucket[] topBuckets) {
    public abstract class ResultStrategy<R extends InternalAggregation, B extends InternalMultiBucketAggregation.InternalBucket>
         */
                "Calling " + StreamStringTermsAggregator.class.getSimpleName() + " for the second segment: " + ctx
        }
            BytesRef term = BytesRef.deepCopyOf(sortedDocValuesPerBatch.lookupOrd(segmentOrd));
                };
                }
                otherDocCount[ordIdx] = selectionResult.otherDocCount;
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
import java.util.function.Function;
        this.valuesSource = valuesSource;
                    }
                    @Override
                };
    private final int segmentTopN;
        return resultStrategy.buildEmptyResult();
                    protected int comparePivot(int j) {
        if (singleValues != null) {
            } else {
            result.setDocCountError(0);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    // Keyed on (owningBucketOrd, segmentOrdinal) so each parent bucket owns a distinct
                    results[ordIdx] = buildNoValuesResult(owningBucketOrds[ordIdx]);
            final BucketOrder reduceOrder;
                        pivotSegmentOrd = bucketOrds.get(pivotBucketOrd);
        StringTerms.Bucket buildFinalBucket(long bucketOrd, long segmentOrd, long docCount) throws IOException {
        }
            return results;
        public void close() {}
        add.accept("segments_with_multi_valued_ords", segmentsWithMultiValuedOrds);
        abstract B[] buildBuckets(int size);
import java.util.function.BiConsumer;
        this.tempBucket2 = null;
}
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
         * Turn the buckets into an aggregation result.
        StringTerms buildEmptyResult() {
         */
import org.opensearch.search.aggregations.support.ValuesSource;
        /**
                ordinalComparator = (leftOrd, rightOrd) -> {
                    return partiallyBuiltBucketComparator.compare(tempBucket1, tempBucket2);
                    }
         * Collect candidate bucket ords for {@code owningBucketOrd}, pick the top
                        candidateBucketOrds.set(j, tmp);
         */
                            left = bucketOrds.get(candidateBucketOrd);
                    return new SelectionResult<>(result, totalDocCount - selectedDocCount);
import org.apache.logging.log4j.Logger;
            }
                    protected void setPivot(int i) {
    @Override
        this.sortedDocValuesPerBatch = valuesSource.ordinalsValues(ctx);
 */
        StringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
            final long otherDocCount;
                        return Long.compare(bucketDocCount(candidateBucketOrd), bucketDocCount(pivotBucketOrd));
import org.opensearch.common.lease.Releasable;
     */
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
    }
                    tempBucket1.docCount = bucketDocCount(leftOrd);
        }
            throw new IllegalStateException(
                @Override
            return buildEmptyTermsAggregation();
        add.accept("segments_with_single_valued_ords", segmentsWithSingleValuedOrds);
        this.leafCollectorCreated = false;
         */
            StringTerms.Bucket result = new StringTerms.Bucket(term, docCount, null, showTermDocCountError, 0, format);
                        candidateBucketOrds.set(i, candidateBucketOrds.get(j));
        StringTerms buildNoValuesResult(long owningBucketOrdinal) {
        private static class SelectionResult<B> {
         */
                bucketCountThresholds
                    long bucketOrd = candidateBucketOrds.get(i);
                        long candidateBucketOrd = candidateBucketOrds.get(j);
            return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, sortedDocValuesPerBatch) {
        abstract String describe();
                            right = pivotBucketOrd;
    @Override
    }
        @Override
            return new StringTerms.Bucket[size][];
                    @Override
        SearchContext context,
            Releasable {
        Releasables.close(resultStrategy, bucketOrds);
                    tempBucket2.bucketOrd = rightOrd;
                    @Override
            return new StringTerms(
        /**
                        return Long.compare(this.bucketOrd, other.bucketOrd);
    private boolean leafCollectorCreated = false;
import org.opensearch.search.aggregations.CardinalityUpperBound;
import org.opensearch.search.aggregations.BucketOrder;
                    collectInto(sub, doc, owningBucketOrd, ordinal);
import org.apache.lucene.index.SortedSetDocValues;
                        if (isKeyOrder(order)) {
        }
    }
        }
            }
package org.opensearch.search.aggregations.bucket.terms;
                }
         */
import org.apache.logging.log4j.LogManager;
    private static final Logger logger = LogManager.getLogger(StreamStringTermsAggregator.class);
    }
                    protected int comparePivot(int j) {
        valueCount = 0;
                    protected void swap(int i, int j) {
                };
        @Override
            );
    }
         * (used for sub-aggregation wiring and doc count lookups); {@code segmentOrd}
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
public class StreamStringTermsAggregator extends AbstractStringTermsAggregator {
        }
                            return -ordinalComparator.compare(left, right);
                }.select(0, cnt, effectiveSegmentSize);
                    int ordinal = singleValues.ordValue();
                long selectedDocCount = 0;
         * {@code segmentSize} according to the active ordering, and emit final buckets.
     * Strategy for building results.
         * Build an "empty" result for a particular bucket ordinal. Called when
                // For sub-aggregation ordering, compare via the per-bucket comparator. The
        }
        }
         */
        BucketCountThresholds bucketCountThresholds,
import org.apache.lucene.util.BytesRef;
            return primary;
                    @Override
                        pivotBucketOrd = candidateBucketOrds.get(i);
        sortedDocValuesPerBatch = null;
        void buildSubAggs(StringTerms.Bucket[][] topBucketsPerOrd) throws IOException {
                    public int compareKey(StringTerms.Bucket other) {
        Function<StreamStringTermsAggregator, ResultStrategy<?, ?>> resultStrategy,
/**
         */
 * The OpenSearch Contributors require contributions made to
        abstract R buildEmptyResult();
         * Build an array to hold the "top" buckets for each ordinal.
 * this file be licensed under the Apache-2.0 license or a
                List<B> result = new ArrayList<>(effectiveSegmentSize);
                // them directly.
            segmentsWithSingleValuedOrds++;
                    long bucketOrd = enumerator.ord();
                otherDocCount,
            return "streaming_terms";
                        return Long.compare(bucketOrds.get(pivotBucketOrd), bucketOrds.get(candidateBucketOrds.get(j)));
            }
        @Override
                order,
                        long tmp = candidateBucketOrds.get(i);
        /**
                public void collect(int doc, long owningBucketOrd) throws IOException {
import java.util.Map;
                new IntroSorter() {
import org.opensearch.search.internal.SearchContext;
            });
                    tempBucket1.bucketOrd = leftOrd;
        }
                    long pivotSegmentOrd;
                }
                    protected void setPivot(int i) {
         * there aren't any values for the field on this shard.
            return new StringTerms.Bucket[size];
        @Override
        return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, sortedDocValuesPerBatch) {
        this.tempBucket1 = null;
        abstract void buildSubAggs(B[][] topBucketsPreOrd) throws IOException;
import java.util.Arrays;
         * shard.
import org.opensearch.search.aggregations.Aggregator;
                        long tmp = candidateBucketOrds.get(i);
                    tempBucket2.docCount = bucketDocCount(rightOrd);
    private final ValuesSource.Bytes.WithOrdinals valuesSource;
        return resultStrategy.buildAggregationsBatch(owningBucketOrds);
                ensureOrdinalComparator();
 * Stream search terms aggregation
            }
        @Override
                    }
                while (enumerator.next()) {
        segmentsWithMultiValuedOrds++;
    private void ensureOrdinalComparator() {
        CardinalityUpperBound cardinality,
    @Override
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
        Aggregator parent,
                new IntroSelector() {
            InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
    }
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
import java.io.IOException;
    }
        abstract R buildNoValuesResult(long owningBucketOrdinal);
            bucketOrd = -1 - bucketOrd;
        } else {
                topBucketsPerOwningOrd[ordIdx] = buildBuckets(selectionResult.buckets.size());
        this.ordinalComparator = null;
    public class StandardTermsResults extends ResultStrategy<StringTerms, StringTerms.Bucket> {
                return new SelectionResult<>(new ArrayList<>(), 0L);
    protected int segmentsWithMultiValuedOrds = 0;
                for (int i = 0; i < topBucketsPerOwningOrd[ordIdx].length; i++) {
                reduceOrder,
        });
        if (bucketOrd < 0) {
        DocValueFormat format,
        this.valueCount = sortedDocValuesPerBatch.getValueCount();
    /**
        /**
    // a sub of another terms agg would collide every parent's doc counts into the same
        }
            if (valueCount == 0) {
        } else {
            long[] otherDocCount = new long[owningBucketOrds.length];
                reduceOrder = order;
                // ordinals handed in here are composite bucket ords (already owning-bucket-
            public void collect(int doc, long owningBucketOrd) throws IOException {
         * results. The populated list is passed to {@link #buildResult}.
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
                    topBucketsPerOwningOrd[ordIdx][i] = selectionResult.buckets.get(i);
import java.util.List;
                if (cnt <= effectiveSegmentSize) {
        }
                    }
        ValuesSource.Bytes.WithOrdinals valuesSource,
import org.opensearch.common.lease.Releasables;
            if (bucketsForOwner == 0) {
import org.opensearch.search.aggregations.InternalOrder;
        implements
                Arrays.asList(topBuckets),
            if (isKeyOrder(order)) {
                long ordinal;
    }
        this.resultStrategy = resultStrategy.apply(this);
            }
         * Build an array of buckets for a particular ordinal to collect the
        abstract R buildResult(long owningBucketOrd, long otherDocCount, B[] topBuckets);
                // ordinals already reflect alphabetical order in the docvalues, so compare
                }
                    }
        /**
                        candidateBucketOrds.set(i, candidateBucketOrds.get(j));
                ordinalComparator = (leftOrd, rightOrd) -> {
                // For key-based ordering the callers hand us segment ordinals, and those
                        }
        BucketOrder order,
                    selectedDocCount += docCount;
                        long bucketOrd = candidateBucketOrds.get(i);
import org.apache.lucene.index.LeafReaderContext;
                    long docCount = bucketDocCount(bucketOrd);
                };
            if (isKeyOrder(order) == false) {
    private long valueCount;
                    long pivotBucketOrd;
                    long pivotBucketOrd;
                this.buckets = buckets;
                    if (docCount >= thresholds.getMinDocCount()) {
     *
                InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
     */
                name,
    private SortedSetDocValues sortedDocValuesPerBatch;
            final List<B> buckets;
                long totalDocCount = 0;
            } else if (partiallyBuiltBucketComparator != null) {
        boolean showTermDocCountError,
                }
            this.leafCollectorCreated = true;
                bucketCountThresholds.getShardSize(),
                int count = sortedDocValuesPerBatch.docValueCount();
                            right = pivotSegmentOrd;
    public void doClose() {
                        selectedDocCount += docCount;
                this.otherDocCount = otherDocCount;
        abstract B buildFinalBucket(long bucketOrd, long segmentOrd, long docCount) throws IOException;
                for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
        }
            throws IOException {
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);
                    @Override
import org.apache.lucene.index.SortedDocValues;
                    }
import org.opensearch.search.aggregations.LeafBucketCollector;
                    result.add(buildFinalBucket(bucketOrd, bucketOrds.get(bucketOrd), docCount));
                        result.add(buildFinalBucket(bucketOrd, bucketOrds.get(bucketOrd), docCount));
    }
            return result;
            }
                }
                    @Override
                results[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCount[ordIdx], topBucketsPerOwningOrd[ordIdx]);
            collectBucket(sub, doc, bucketOrd);
        /**
                    return ascending ? Long.compare(leftOrd, rightOrd) : Long.compare(rightOrd, leftOrd);
    private void collectInto(LeafBucketCollector sub, int doc, long owningBucketOrd, long segmentOrdinal) throws IOException {
    public InternalAggregation buildEmptyAggregation() {
                    collectInto(sub, doc, owningBucketOrd, ordinal);
        @Override
    // bucket ordinal for the same term. Without this, a streaming terms agg running as
                    public int compareKey(StringTerms.Bucket other) {
 * SPDX-License-Identifier: Apache-2.0
        if (ordinalComparator == null) {
        /**
        }
    public void collectDebugInfo(BiConsumer<String, Object> add) {
            try (LongArray candidateBucketOrds = context.bigArrays().newLongArray(Math.toIntExact(bucketsForOwner), false)) {
import org.opensearch.common.util.LongArray;
        int segmentTopN,
                        if (ordinalComparator != null) {
                // alphabetical) so downstream reduce ordering assumptions hold.
         * is the underlying segment-local ordinal used to materialize the term bytes.
                format,
    }
        @Override
    public void doReset() {
        this.segmentTopN = segmentTopN;
    private final LongKeyedBucketOrds bucketOrds;
            return buildEmptyResult();
    ) throws IOException {
        /**
                int cnt = 0;
import java.util.ArrayList;
            collectExistingBucket(sub, doc, bucketOrd);
                reduceOrder = InternalOrder.key(true);
        AggregatorFactories factories,
                        return;
            B[][] topBucketsPerOwningOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
