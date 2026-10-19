         */
    }
                    long pivotSegmentOrd;  
        SubAggCollectionMode collectionMode,
import org.apache.lucene.index.LeafReaderContext;
import java.util.ArrayList;
                        return;
         * Build the sub-aggregations into the buckets. This will usually
     *
        implements  
                    @Override  
        if (singleValues != null) {
                }
                long totalDocCount = 0;
                    }
                SelectionResult<B> selectionResult = selectTopBuckets(owningBucketOrds[ordIdx], segmentTopN, bucketCountThresholds);  
        }
                    long docCount = bucketDocCount(bucketOrd);  
                        long candidateBucketOrd = candidateBucketOrds.get(j);
    private StringTerms.Bucket tempBucket1;
 */  
import org.opensearch.search.internal.SearchContext;
            try (LongArray candidateBucketOrds = context.bigArrays().newLongArray(Math.toIntExact(bucketsForOwner), false)) {  
                order,  
        long bucketOrd = bucketOrds.add(owningBucketOrd, segmentOrdinal);
        }
                otherDocCount[ordIdx] = selectionResult.otherDocCount;  
        CardinalityUpperBound cardinality,
                for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
                long selectedDocCount = 0;
                    topBucketsPerOwningOrd[ordIdx][i] = selectionResult.buckets.get(i);
        @Override  
                bucketCountThresholds.getShardSize(),  
                        long right;
        return resultStrategy.buildEmptyResult();
        boolean showTermDocCountError,  
        abstract void buildSubAggs(B[][] topBucketsPreOrd) throws IOException;
            }
                };  
                // them directly.
                logger.debug("Cardinality post collection for ordIdx {}: {}", ordIdx, valueCount);
                return results;  
        /**
import org.opensearch.search.aggregations.BucketOrder;
    public void collectDebugInfo(BiConsumer<String, Object> add) {
    public void doReset() {
                // scoped), so bucketDocCount reads the right value.  
    /**
         * shard.
         * delegate to {@link #buildSubAggsForAllBuckets}.  
                    int ordinal = singleValues.ordValue();
                    return new SelectionResult<>(result, totalDocCount - selectedDocCount);  
                };
         * Build an "empty" result. Only called if there isn't any data on this
                // ordinals handed in here are composite bucket ords (already owning-bucket-
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);  
import org.opensearch.common.lease.Releasables;
            });
        String describe() {  
                    protected int comparePivot(int j) {
        abstract R buildNoValuesResult(long owningBucketOrdinal);
                    @Override
                LongKeyedBucketOrds.BucketOrdsEnum enumerator = bucketOrds.ordsEnum(owningBucketOrd);  
        String name,
    protected int segmentsWithMultiValuedOrds = 0;
                name,
                results[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCount[ordIdx], topBucketsPerOwningOrd[ordIdx]);
        }  
                            right = pivotSegmentOrd;
        sortedDocValuesPerBatch = null;
                ordinalComparator = (leftOrd, rightOrd) -> {  
package org.opensearch.search.aggregations.bucket.terms;
            }
            StringTerms.Bucket result = new StringTerms.Bucket(term, docCount, null, showTermDocCountError, 0, format);  
                            return -ordinalComparator.compare(left, right);
        this.valueCount = sortedDocValuesPerBatch.getValueCount();
import org.opensearch.search.aggregations.CardinalityUpperBound;
        }
                        candidateBucketOrds.set(cnt++, bucketOrd);  
        StringTerms.Bucket buildFinalBucket(long bucketOrd, long segmentOrd, long docCount) throws IOException {
         */
        /**
        private static class SelectionResult<B> {  
                reduceOrder,
                        long tmp = candidateBucketOrds.get(i);
        } else {  
    }
    // bucket ordinal for the same term. Without this, a streaming terms agg running as
        }
                        long tmp = candidateBucketOrds.get(i);
            final BucketOrder reduceOrder;
                new IntroSelector() {
                    protected int comparePivot(int j) {
                    public int compareKey(StringTerms.Bucket other) {  
        this.valuesSource = valuesSource;  
            return primary;  
    }
        add.accept("result_strategy", resultStrategy.describe());
        this.leafCollectorCreated = false;
public class StreamStringTermsAggregator extends AbstractStringTermsAggregator {
                while (enumerator.next()) {
        add.accept("segments_with_multi_valued_ords", segmentsWithMultiValuedOrds);  
                        }
                    protected void setPivot(int i) {
            return result;  
                        return Long.compare(bucketDocCount(candidateBucketOrd), bucketDocCount(pivotBucketOrd));  
        StringTerms buildResult(long owningBucketOrd, long otherDocCount, StringTerms.Bucket[] topBuckets) {
    public InternalAggregation buildEmptyAggregation() {  
    private Aggregator.BucketComparator ordinalComparator;  
         */  
import java.util.function.BiConsumer;
                    long selectedDocCount = 0;
            }  
import org.opensearch.search.aggregations.support.ValuesSource;  
        super.doReset();
                @Override
        this.sortedDocValuesPerBatch = valuesSource.ordinalsValues(ctx);
            long[] otherDocCount = new long[owningBucketOrds.length];
    private void ensureOrdinalComparator() {
         * Build an "empty" result for a particular bucket ordinal. Called when
                int cnt = 0;
                tempBucket1 = new StringTerms.Bucket(null, 0, null, false, 0, format) {
        abstract R buildResult(long owningBucketOrd, long otherDocCount, B[] topBuckets);
         */
                    long bucketOrd = candidateBucketOrds.get(i);  
                        if (ordinalComparator != null) {  
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
                // alphabetical) so downstream reduce ordering assumptions hold.
                    long pivotBucketOrd;
        }
                0,
                    return ascending ? Long.compare(leftOrd, rightOrd) : Long.compare(rightOrd, leftOrd);
                        long bucketOrd = candidateBucketOrds.get(i);
                    protected void swap(int i, int j) {  
        abstract R buildEmptyResult();
            long bucketsForOwner = bucketOrds.bucketsInOrd(owningBucketOrd);
    }
        abstract String describe();  
import org.apache.lucene.util.BytesRef;
        ValuesSource.Bytes.WithOrdinals valuesSource,
 * SPDX-License-Identifier: Apache-2.0
    protected final ResultStrategy<?, ?> resultStrategy;
                    if (docCount >= thresholds.getMinDocCount()) {
        @Override  
                            right = pivotBucketOrd;
        /**
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);  
                }
        this.resultStrategy = resultStrategy.apply(this);
import java.util.Map;
         * Build an array to hold the "top" buckets for each ordinal.  
                List<B> result = new ArrayList<>(effectiveSegmentSize);  
                        } else {
        @Override
        Map<String, Object> metadata  
                    List<B> result = new ArrayList<>(cnt);
import org.apache.lucene.util.IntroSelector;
            if (bucketsForOwner == 0) {
                return new SelectionResult<>(new ArrayList<>(), 0L);  
        @Override
    }  
    private long valueCount;
                    collectInto(sub, doc, owningBucketOrd, ordinal);
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
    @Override  
        /**  
        /**  
    public abstract class ResultStrategy<R extends InternalAggregation, B extends InternalMultiBucketAggregation.InternalBucket>
                    }
         * is the underlying segment-local ordinal used to materialize the term bytes.  
                        result.add(buildFinalBucket(bucketOrd, bucketOrds.get(bucketOrd), docCount));  
                    @Override  
import org.opensearch.search.DocValueFormat;
import org.apache.logging.log4j.LogManager;
         * there aren't any values for the field on this shard.
                        candidateBucketOrds.set(i, candidateBucketOrds.get(j));  
    @Override
            );  
import org.apache.lucene.index.SortedDocValues;
    public void doClose() {
        @Override
                    public int compareKey(StringTerms.Bucket other) {  
                otherDocCount,
            buildSubAggs(topBucketsPerOwningOrd);  
         * results. The populated list is passed to {@link #buildResult}.  
                        selectedDocCount += docCount;
            bucketOrd = -1 - bucketOrd;
                this.otherDocCount = otherDocCount;  
                // For key-based ordering the callers hand us segment ordinals, and those
import java.util.List;  
        if (ordinalComparator == null) {  
                    @Override  
        InternalAggregation[] buildAggregationsBatch(long[] owningBucketOrds) throws IOException {
                    @Override
        @Override
                checkCancelled();
 * The OpenSearch Contributors require contributions made to  
        private SelectionResult<B> selectTopBuckets(long owningBucketOrd, int segmentSize, BucketCountThresholds thresholds)
                // For sub-aggregation ordering, compare via the per-bucket comparator. The
        @Override
                tempBucket2 = new StringTerms.Bucket(null, 0, null, false, 0, format) {
        this.tempBucket1 = null;
        }
            @Override
    }
    ) throws IOException {
                    }
        BucketOrder order,  
                }
        this.segmentTopN = segmentTopN;
import org.apache.lucene.util.IntroSorter;  
    public StreamStringTermsAggregator(
         */
            collectExistingBucket(sub, doc, bucketOrd);
                    long docCount = bucketDocCount(bucketOrd);
import org.opensearch.search.aggregations.LeafBucketCollector;  
/*  
    protected int segmentsWithSingleValuedOrds = 0;  
         * Turn the buckets into an aggregation result.
                    }
            B[][] topBucketsPerOwningOrd = buildTopBucketsPerOrd(owningBucketOrds.length);  
    }  
                        return Long.compare(this.bucketOrd, other.bucketOrd);
        Releasables.close(resultStrategy, bucketOrds);
                    }
            return "streaming_terms";
        }
            if (isKeyOrder(order)) {
        segmentsWithMultiValuedOrds++;  
                public void collect(int doc, long owningBucketOrd) throws IOException {  
            if (isKeyOrder(order) == false) {  
     * StandardTermsResults for string terms  
                    @Override
            return buildEmptyResult();
import org.opensearch.common.util.LongArray;  
                // Match the historical emit order (ascending by segment ordinal, i.e.
                ordinalComparator = (leftOrd, rightOrd) -> {
                    }
                Arrays.sort(topBuckets, reduceOrder.comparator());
        int segmentTopN,
                }.sort(0, effectiveSegmentSize);
                while ((count-- > 0) && (ordinal = sortedDocValuesPerBatch.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {  
    private final LongKeyedBucketOrds bucketOrds;
                        candidateBucketOrds.set(j, tmp);
    }  
                    protected void setPivot(int i) {
                if (cnt <= effectiveSegmentSize) {  
        protected ResultStrategy() {}  
                    if (false == singleValues.advanceExact(doc)) {
        if (this.leafCollectorCreated) {  
            }
        super(name, factories, context, parent, order, format, bucketCountThresholds, collectionMode, showTermDocCountError, metadata);
        AggregatorFactories factories,  
                    tempBucket1.bucketOrd = leftOrd;
                // ordinals already reflect alphabetical order in the docvalues, so compare  
                boolean ascending = InternalOrder.isKeyAsc(order);
            result.setDocCountError(0);
                    @Override
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        } else {
        return resultStrategy.buildAggregationsBatch(owningBucketOrds);
                        return Long.compare(this.bucketOrd, other.bucketOrd);
                int count = sortedDocValuesPerBatch.docValueCount();
import org.apache.logging.log4j.Logger;
    /**
        return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, sortedDocValuesPerBatch) {
 */  
        Function<StreamStringTermsAggregator, ResultStrategy<?, ?>> resultStrategy,
        DocValueFormat format,
        void buildSubAggs(StringTerms.Bucket[][] topBucketsPerOrd) throws IOException {
        }
import org.opensearch.search.aggregations.AggregatorFactories;  
    }  
                long ordinal;
            }
    @Override  
import java.util.Arrays;
                    }
 *
            }
                        pivotBucketOrd = candidateBucketOrds.get(i);
        StringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
            InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
    // a sub of another terms agg would collide every parent's doc counts into the same
    }  
        valueCount = 0;  
            } else if (partiallyBuiltBucketComparator != null) {  
         */
                }  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
         * Wrap the "standard" numeric terms collector to collect any more  
        /**
         * Build a final bucket. {@code bucketOrd} is the composite bucket ordinal
        @Override
                int effectiveSegmentSize = Math.min(segmentSize, cnt);
                }  
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);  
                metadata(),
                    for (int i = 0; i < cnt; i++) {  
         * (used for sub-aggregation wiring and doc count lookups); {@code segmentOrd}
                ensureOrdinalComparator();  
                        candidateBucketOrds.set(j, tmp);  
            SelectionResult(List<B> buckets, long otherDocCount) {
                    }  
    @Override
        });
            BytesRef term = BytesRef.deepCopyOf(sortedDocValuesPerBatch.lookupOrd(segmentOrd));
 * Stream search terms aggregation
        }  
                }
            segmentsWithSingleValuedOrds++;  
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
import org.opensearch.search.aggregations.InternalOrder;
        this.ordinalComparator = null;  
    private static final Logger logger = LogManager.getLogger(StreamStringTermsAggregator.class);
        add.accept("segments_with_single_valued_ords", segmentsWithSingleValuedOrds);
                if (false == sortedDocValuesPerBatch.advanceExact(doc)) {
            public void collect(int doc, long owningBucketOrd) throws IOException {  
            }
            return new StringTerms(  
                    selectedDocCount += docCount;  
        super.collectDebugInfo(add);  
            );  
                InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
        }
            Releasable {
                for (int i = 0; i < topBucketsPerOwningOrd[ordIdx].length; i++) {  
     * Strategy for building results.  
    private boolean leafCollectorCreated = false;  
            final List<B> buckets;
                    collectInto(sub, doc, owningBucketOrd, ordinal);
                    result.add(buildFinalBucket(bucketOrd, bucketOrds.get(bucketOrd), docCount));
import org.opensearch.search.aggregations.InternalAggregation;  
        /**
import org.apache.lucene.index.SortedSetDocValues;  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        }
        /**
                }
                    tempBucket2.bucketOrd = rightOrd;
                Arrays.asList(topBuckets),  
                bucketCountThresholds
                        long docCount = bucketDocCount(bucketOrd);
        /**  
    }
            final long otherDocCount;
                        long left;  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                    tempBucket1.docCount = bucketDocCount(leftOrd);  
                    }  
         */  
                    long bucketOrd = enumerator.ord();
            // Recreate DocValues as needed for concurrent segment search.  
                "Calling " + StreamStringTermsAggregator.class.getSimpleName() + " for the second segment: " + ctx
                return new SelectionResult<>(result, totalDocCount - selectedDocCount);
     */
         */
                            left = candidateBucketOrd;  
        public void close() {}
         * Build an array of buckets for a particular ordinal to collect the
        this.bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);  
        }  
        if (bucketOrd < 0) {  
            collectBucket(sub, doc, bucketOrd);
                        return Long.compare(bucketOrds.get(pivotBucketOrd), bucketOrds.get(candidateBucketOrds.get(j)));
    private SortedSetDocValues sortedDocValuesPerBatch;  
        @Override  
    private StringTerms.Bucket tempBucket2;
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
            this.leafCollectorCreated = true;
            }  
 * compatible open source license.
                }
            return results;  
    public class StandardTermsResults extends ResultStrategy<StringTerms, StringTerms.Bucket> {
                            left = bucketOrds.get(candidateBucketOrd);  
     * @opensearch.internal
        SearchContext context,  
                    results[ordIdx] = buildNoValuesResult(owningBucketOrds[ordIdx]);
         */  
                    }
    // Keyed on (owningBucketOrd, segmentOrdinal) so each parent bucket owns a distinct  
                    @Override  
import java.io.IOException;  
        abstract B buildFinalBucket(long bucketOrd, long segmentOrd, long docCount) throws IOException;
                topBucketsPerOwningOrd[ordIdx] = buildBuckets(selectionResult.buckets.size());
                this.buckets = buckets;
    private final int segmentTopN;
 * this file be licensed under the Apache-2.0 license or a
        }
            throw new IllegalStateException(
                    tempBucket2.docCount = bucketDocCount(rightOrd);
    // flat array, producing identical inner bucket lists for every parent bucket.  
                    totalDocCount += docCount;
                reduceOrder = InternalOrder.key(true);
    private void collectInto(LeafBucketCollector sub, int doc, long owningBucketOrd, long segmentOrdinal) throws IOException {
        Aggregator parent,
            return new StringTerms.Bucket[size][];
                        if (isKeyOrder(order)) {
    @Override
import org.opensearch.common.lease.Releasable;
        }  
                    }
            }
            if (valueCount == 0) {
import org.apache.lucene.index.DocValues;  
                format,
import java.util.function.Function;  
        abstract B[] buildBuckets(int size);
            throws IOException {  
     */  
                    protected void swap(int i, int j) {
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
        StringTerms buildEmptyResult() {
        StringTerms.Bucket[] buildBuckets(int size) {  
                        pivotBucketOrd = candidateBucketOrds.get(i);  
         * information that this result type may need.
                }.select(0, cnt, effectiveSegmentSize);
        }
            return buildEmptyTermsAggregation();
        @Override  
        BucketCountThresholds bucketCountThresholds,
        abstract B[][] buildTopBucketsPerOrd(int size);
/**
                    return partiallyBuiltBucketComparator.compare(tempBucket1, tempBucket2);  
                    return;
                showTermDocCountError,
         * {@code segmentSize} according to the active ordering, and emit final buckets.  
                    long pivotBucketOrd;
                for (int i = 0; i < effectiveSegmentSize; i++) {
    private final ValuesSource.Bytes.WithOrdinals valuesSource;
        this.tempBucket2 = null;
                reduceOrder = order;
    @Override  
                        pivotSegmentOrd = bucketOrds.get(pivotBucketOrd);  
                };
}
                        }
            result.bucketOrd = bucketOrd;
                };  
import org.opensearch.search.aggregations.Aggregator;
            return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, sortedDocValuesPerBatch) {
        SortedDocValues singleValues = DocValues.unwrapSingleton(sortedDocValuesPerBatch);
         * Collect candidate bucket ords for {@code owningBucketOrd}, pick the top
            } else {  
                new IntroSorter() {  
        StringTerms buildNoValuesResult(long owningBucketOrdinal) {  
                        candidateBucketOrds.set(i, candidateBucketOrds.get(j));
            return new StringTerms.Bucket[size];
