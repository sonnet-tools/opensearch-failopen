            int totalDocsAtLevel = skipper.maxDocID(level) - skipper.minDocID(level) + 1;
            upToInclusive = skipper.minDocID(0) - 1;
        Rounding.Prepared preparedRounding,
        // This will only be called if its the top agg
     */
            advanceSkipper(doc, owningBucketOrd);
        LongKeyedBucketOrds bucketOrds,
        this.isSubNoOp = (sub == NO_OP_COLLECTOR);
                    aggregator.incrementBucketDocCount(upToBucketIndex, count[0]);
    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
            } else {
        if (sub != null) {
     * Tracks the last preparedRounding reference to detect rounding changes.
        for (int level = 0; level < skipper.numLevels(); ++level) {
    public void setScorer(Scorable scorer) throws IOException {
                upToExclusive = Integer.MAX_VALUE;
    /**
     * Skiplist is based as top level agg (null parent) or parent that will execute in sorted order
     * This allows detection of rounding changes in AutoDateHistogramAggregator.
     * bucket.
    }
        }
        // Check if rounding changed (using reference equality)
import java.util.function.LongFunction;
    }
        if (hardBounds != null) return false;
            long rounded = currentRounding.round(value);
     * @opensearch.internal
package org.opensearch.search.aggregations.bucket;
        this.bucketOrdsSupplier = bucketOrdsSupplier;
     */
     */
        return false;
        }
    ) {
        }
        DocValuesSkipper skipper,
            if (upToExclusive < 0) { // overflow
    @Override
    @Override
                    final int[] count = { 0 };
        if (parent == null) return true;
                upToSameBucket = true;
        DocValuesSkipper skipper,
            final long value = values.longValue();
    public void collect(int doc, long owningBucketOrd) throws IOException {
import java.util.function.Supplier;
                } else {
    private final boolean isSubNoOp;
     * Constructor that accepts a supplier for dynamic rounding (used by AutoDateHistogramAggregator).
        IncreaseRoundingIfNeeded increaseRoundingIfNeeded
     * Call back for auto date histogram
/**
 *
        }
        // TODO: add hard bounds support
                upToInclusive = skipper.maxDocID(level);
/*
            long minBucket = currentRounding.round(skipper.minValue(level));
    }
                aggregator.collectExistingBucket(sub, doc, bucketIndex);
     * Index in bucketOrds for docs up to {@link #upToInclusive}.
     * Used for cache invalidation when AutoDateHistogramAggregator changes rounding.
    }
import org.apache.lucene.search.Scorable;
                    long count = stream.count(upToExclusive);
        upToInclusive = skipper.maxDocID(0);
                bucketIndex = -1 - bucketIndex;
        void accept(long owningBucket, long rounded);
        NumericDocValues values,
            long maxBucket = currentRounding.round(skipper.maxValue(level));
    ) {
            sub.setScorer(scorer);
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
        this.increaseRoundingIfNeeded = increaseRoundingIfNeeded;
     * Supplier function to get the current preparedRounding from the parent aggregator.
        this.preparedRoundingSupplier = preparedRoundingSupplier;
            }
                }
            // Corner case which happens if `doc` doesn't have a value and is between two
                    });
            lastPreparedRounding = currentRounding;
            sub.collect(doc, upToBucketIndex);
import org.opensearch.search.aggregations.LeafBucketCollector;
 * @opensearch.internal
    public interface IncreaseRoundingIfNeeded {
                    upToBucketIndex = -1 - upToBucketIndex;
        collect(stream, 0);
    }
        this.sub = sub;
 * SPDX-License-Identifier: Apache-2.0
 */
    private void advanceSkipper(int doc, long owningBucketOrd) throws IOException {
    /**
    }
                if (isSubNoOp) {
 * this file be licensed under the Apache-2.0 license or a
     *
            if (bucketIndex < 0) {
import org.apache.lucene.index.DocValuesSkipper;
            // intervals of
    /**
        }
     */
            long bucketIndex = bucketOrdsSupplier.get().add(owningBucketOrd, rounded);
    private final NumericDocValues values;
    @Override
            upToSameBucket = false;
 *
        BucketsAggregator aggregator
        Rounding.Prepared currentRounding = preparedRoundingSupplier.apply(owningBucketOrd);
        LeafBucketCollector sub,
        if (skipper.minDocID(0) > doc) {
        // AutoDateHistogramAggregator creates a new Rounding.Prepared instance when rounding changes
    /**
    /**
        if (currentRounding != lastPreparedRounding) {
            } else {
                upToBucketIndex = bucketOrdsSupplier.get().add(owningBucketOrd, maxBucket);
        Supplier<LongKeyedBucketOrds> bucketOrdsSupplier,
    /**
    private boolean upToSameBucket;
            // the doc-value skip index.
            if (upToSameBucket) {
            } else {
                        sub.collect(doc, upToBucketIndex);
        if (skipper == null || singleton == null) return false;
    }
        // Get current rounding from supplier
    private final Supplier<LongKeyedBucketOrds> bucketOrdsSupplier;
    private final BucketsAggregator aggregator;
                stream.forEach(upToExclusive, doc -> collect(doc, owningBucketOrd));
    public static boolean canUseSkiplist(LongBounds hardBounds, Aggregator parent, DocValuesSkipper skipper, NumericDocValues singleton) {
     */
        upToSameBucket = false;
        if (doc > upToInclusive) {
 *
public class HistogramSkiplistLeafCollector extends LeafBucketCollector {
        LongFunction<Rounding.Prepared> preparedRoundingSupplier,
 * Currently, it can only handle one owningBucketOrd at a time.
        NumericDocValues values,
import org.opensearch.search.aggregations.bucket.histogram.LongBounds;
    public HistogramSkiplistLeafCollector(
        Rounding.Prepared currentRounding = preparedRoundingSupplier.apply(owningBucketOrd);
        this.aggregator = aggregator;
    private Rounding.Prepared lastPreparedRounding;
    /**
            skipper.advance(doc);
                    aggregator.incrementBucketDocCount(upToBucketIndex, count);
    }
        }
    }
     */
            aggregator.incrementBucketDocCount(upToBucketIndex, 1L);
        if (upToSameBucket) {
import org.opensearch.search.aggregations.AggregatorBase;
    public void collect(DocIdStream stream) throws IOException {
    private final IncreaseRoundingIfNeeded increaseRoundingIfNeeded;
 * The OpenSearch Contributors require contributions made to
            }
                        count[0]++;
        if (doc > skipper.maxDocID(0)) {
    private final LongFunction<Rounding.Prepared> preparedRoundingSupplier;
            upToInclusive = -1;  // Invalidate
 */
import org.opensearch.search.aggregations.Aggregator;
import org.apache.lucene.search.DocIdStream;
            int upToExclusive = upToInclusive + 1;
        }
            }
        if (parent instanceof AggregatorBase base) {
        for (;;) {
        } else if (values.advanceExact(doc)) {
                // All docs at this level have a value, and all values map to the same bucket.
            return;
            return base.getLeafCollectorMode() == AggregatorBase.LeafCollectionMode.FILTER_REWRITE;
    /**
            }
        LeafBucketCollector sub,
     * Whether all docs up to {@link #upToInclusive} values map to the same bucket.
                break;
    private final LeafBucketCollector sub;
            }
                increaseRoundingIfNeeded.accept(owningBucketOrd, rounded);
        this(values, skipper, (owningBucketOrd) -> preparedRounding, () -> bucketOrds, sub, aggregator, (owningBucketOrd, rounded) -> {});
                    stream.forEach(upToExclusive, doc -> {
            } else {
}
 * compatible open source license.
import org.opensearch.common.Rounding;
                if (upToBucketIndex < 0) {
    public HistogramSkiplistLeafCollector(
    @Override
                aggregator.collectBucket(sub, doc, bucketIndex);
            if (stream.mayHaveRemaining()) {
            if (skipper.docCount(level) == totalDocsAtLevel && minBucket == maxBucket) {
        this.skipper = skipper;
                break;
                    // stream.count maybe faster when we don't need to handle sub-aggs
        // Now find the highest level where all docs map to the same bucket.
     * Max doc ID (inclusive) up to which all docs values may map to the same
     */
                }
        }
     *
     */
import java.io.IOException;
import org.apache.lucene.index.NumericDocValues;
        }
        BucketsAggregator aggregator,
 * Histogram collection logic using skip list.
        this.values = values;
    private int upToInclusive = -1;
                advanceSkipper(upToExclusive, owningBucketOrd);
    private long upToBucketIndex;
    private final DocValuesSkipper skipper;
