            return;
    public interface IncreaseRoundingIfNeeded {
                    aggregator.incrementBucketDocCount(upToBucketIndex, count[0]);  
        if (hardBounds != null) return false;  
        if (doc > upToInclusive) {
import org.opensearch.common.Rounding;
            if (upToSameBucket) {
        this.increaseRoundingIfNeeded = increaseRoundingIfNeeded;
        if (sub != null) {  
                    stream.forEach(upToExclusive, doc -> {
    /**
    /**
/**
    private final NumericDocValues values;
        Rounding.Prepared currentRounding = preparedRoundingSupplier.apply(owningBucketOrd);
            if (stream.mayHaveRemaining()) {  
            }
    ) {
 * SPDX-License-Identifier: Apache-2.0
                upToInclusive = skipper.maxDocID(level);
 * @opensearch.internal  
/*  
     */  
import org.apache.lucene.search.DocIdStream;  
    private long upToBucketIndex;
            aggregator.incrementBucketDocCount(upToBucketIndex, 1L);
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
    /**
                increaseRoundingIfNeeded.accept(owningBucketOrd, rounded);  
        if (skipper.minDocID(0) > doc) {
        this.aggregator = aggregator;  
            // intervals of
     * Skiplist is based as top level agg (null parent) or parent that will execute in sorted order  
                aggregator.collectBucket(sub, doc, bucketIndex);
    public void collect(DocIdStream stream) throws IOException {  
            sub.collect(doc, upToBucketIndex);
 */  
     * Index in bucketOrds for docs up to {@link #upToInclusive}.  
    public static boolean canUseSkiplist(LongBounds hardBounds, Aggregator parent, DocValuesSkipper skipper, NumericDocValues singleton) {  
     */
            if (skipper.docCount(level) == totalDocsAtLevel && minBucket == maxBucket) {  
        }  
            }
    }  
    private final DocValuesSkipper skipper;
        NumericDocValues values,
            upToInclusive = skipper.minDocID(0) - 1;  
                upToSameBucket = true;  
 */
     * @opensearch.internal
    ) {
import org.apache.lucene.index.DocValuesSkipper;
                    final int[] count = { 0 };
    /**
            } else {
    /**
import org.opensearch.search.aggregations.AggregatorBase;
     * Tracks the last preparedRounding reference to detect rounding changes.
            upToInclusive = -1;  // Invalidate  
        if (parent instanceof AggregatorBase base) {
                upToExclusive = Integer.MAX_VALUE;
}  
        LeafBucketCollector sub,
                if (upToBucketIndex < 0) {
    }
                    aggregator.incrementBucketDocCount(upToBucketIndex, count);
        // AutoDateHistogramAggregator creates a new Rounding.Prepared instance when rounding changes
        // This will only be called if its the top agg
    @Override
        BucketsAggregator aggregator
    public void collect(int doc, long owningBucketOrd) throws IOException {  
                }
        // Now find the highest level where all docs map to the same bucket.  
    private final LongFunction<Rounding.Prepared> preparedRoundingSupplier;
                // All docs at this level have a value, and all values map to the same bucket.
            long bucketIndex = bucketOrdsSupplier.get().add(owningBucketOrd, rounded);  
    private final LeafBucketCollector sub;  
public class HistogramSkiplistLeafCollector extends LeafBucketCollector {
 *  
 * The OpenSearch Contributors require contributions made to  
    }  
        LongKeyedBucketOrds bucketOrds,
    public HistogramSkiplistLeafCollector(
        this.values = values;  
        if (upToSameBucket) {  
                    long count = stream.count(upToExclusive);
            } else {
        if (skipper == null || singleton == null) return false;
            // Corner case which happens if `doc` doesn't have a value and is between two  
     * This allows detection of rounding changes in AutoDateHistogramAggregator.  
        }
    }  
    /**  
        // Check if rounding changed (using reference equality)  
                }
            upToSameBucket = false;
        }
 *
        Rounding.Prepared currentRounding = preparedRoundingSupplier.apply(owningBucketOrd);
    private void advanceSkipper(int doc, long owningBucketOrd) throws IOException {
                    upToBucketIndex = -1 - upToBucketIndex;  
     * Whether all docs up to {@link #upToInclusive} values map to the same bucket.
                break;  
import java.io.IOException;  
                advanceSkipper(upToExclusive, owningBucketOrd);
        }  
        Supplier<LongKeyedBucketOrds> bucketOrdsSupplier,
            sub.setScorer(scorer);
        if (parent == null) return true;
                if (isSubNoOp) {
    }  
                bucketIndex = -1 - bucketIndex;
        this.bucketOrdsSupplier = bucketOrdsSupplier;  
            long minBucket = currentRounding.round(skipper.minValue(level));  
     */
            } else {
        NumericDocValues values,
    }  
            }
     * Supplier function to get the current preparedRounding from the parent aggregator.
     */  
        void accept(long owningBucket, long rounded);
 *
            }
    private final BucketsAggregator aggregator;
    @Override
        DocValuesSkipper skipper,  
            } else {
                        sub.collect(doc, upToBucketIndex);  
            lastPreparedRounding = currentRounding;
        this(values, skipper, (owningBucketOrd) -> preparedRounding, () -> bucketOrds, sub, aggregator, (owningBucketOrd, rounded) -> {});  
 * Histogram collection logic using skip list.
                    // stream.count maybe faster when we don't need to handle sub-aggs  
        IncreaseRoundingIfNeeded increaseRoundingIfNeeded
     */
        upToSameBucket = false;  
 * compatible open source license.
        return false;
    /**  
import org.opensearch.search.aggregations.LeafBucketCollector;
            final long value = values.longValue();
import java.util.function.Supplier;
        this.sub = sub;
    private boolean upToSameBucket;  
     */
            if (bucketIndex < 0) {
     *
            long maxBucket = currentRounding.round(skipper.maxValue(level));
        }
        // Get current rounding from supplier  
    @Override
        BucketsAggregator aggregator,  
        }
import org.apache.lucene.index.NumericDocValues;
                        count[0]++;
    /**  
        this.isSubNoOp = (sub == NO_OP_COLLECTOR);
    private final Supplier<LongKeyedBucketOrds> bucketOrdsSupplier;  
            // the doc-value skip index.
    }
    public HistogramSkiplistLeafCollector(  
                upToBucketIndex = bucketOrdsSupplier.get().add(owningBucketOrd, maxBucket);
        LeafBucketCollector sub,  
        collect(stream, 0);
     */
        this.skipper = skipper;
        LongFunction<Rounding.Prepared> preparedRoundingSupplier,  
    private final IncreaseRoundingIfNeeded increaseRoundingIfNeeded;
        // TODO: add hard bounds support
     * bucket.
package org.opensearch.search.aggregations.bucket;
            advanceSkipper(doc, owningBucketOrd);  
                break;  
import org.apache.lucene.search.Scorable;
    private final boolean isSubNoOp;
                aggregator.collectExistingBucket(sub, doc, bucketIndex);  
                    });
     */
        this.preparedRoundingSupplier = preparedRoundingSupplier;
    @Override
                stream.forEach(upToExclusive, doc -> collect(doc, owningBucketOrd));  
            long rounded = currentRounding.round(value);
        }
    private int upToInclusive = -1;
        upToInclusive = skipper.maxDocID(0);
            return base.getLeafCollectorMode() == AggregatorBase.LeafCollectionMode.FILTER_REWRITE;
        DocValuesSkipper skipper,
            }
    public void setScorer(Scorable scorer) throws IOException {
        for (int level = 0; level < skipper.numLevels(); ++level) {
 * this file be licensed under the Apache-2.0 license or a
        }
        if (doc > skipper.maxDocID(0)) {  
     *
            skipper.advance(doc);
                } else {  
        for (;;) {
import org.opensearch.search.aggregations.Aggregator;  
     * Used for cache invalidation when AutoDateHistogramAggregator changes rounding.  
    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
     * Call back for auto date histogram  
        if (currentRounding != lastPreparedRounding) {
     * Constructor that accepts a supplier for dynamic rounding (used by AutoDateHistogramAggregator).
            int totalDocsAtLevel = skipper.maxDocID(level) - skipper.minDocID(level) + 1;
        }
     * Max doc ID (inclusive) up to which all docs values may map to the same
            int upToExclusive = upToInclusive + 1;
 * Currently, it can only handle one owningBucketOrd at a time.
import org.opensearch.search.aggregations.bucket.histogram.LongBounds;  
        Rounding.Prepared preparedRounding,
    private Rounding.Prepared lastPreparedRounding;
            if (upToExclusive < 0) { // overflow  
    }  
        } else if (values.advanceExact(doc)) {  
    }
import java.util.function.LongFunction;
