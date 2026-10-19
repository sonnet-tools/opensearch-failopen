 * SPDX-License-Identifier: Apache-2.0
            }
        case 2 and 3 are encapsulated in QUICK_SELECT_OR_SELECT_ALL method.
    }
        BucketOrder order,
                    otherDocCount -= topBuckets[b].getDocCount();
                Iterator<B> itr = ordered.iterator();
                }
        @Override
            BucketUpdateFunction<B> bucketUpdateFunction,
        B[] buildBuckets(int size);
     * Interface for buildPriorityQueue method
        public final LocalBucketCountThresholds localBucketCountThresholds;
                    spare = input.emptyBucketBuilder.get();
                input.bucketUpdateFunction.updateBucket(spare, input.ordsEnum, docCount);
                    0,
        public <B extends InternalMultiBucketAggregation.InternalBucket> SelectionResult<B> selectTopBuckets(SelectionInput<B> input)
        public final PriorityQueueBuilder<B> buildPriorityQueue;
            this.size = size;
            this.otherDocCount = otherDocCount;
                    bucketsForOrd,
            Supplier<B> emptyBucketBuilder,
                    continue;
 *
        We select the strategy based on the following condition with configurable threshold factor:
                if (docCount < input.localBucketCountThresholds.getMinDocCount()) {
            while (input.ordsEnum.next()) {
 * compatible open source license.
                }
                bucketsForOrd[validBucketCount++] = spare;
            int validBucketCount = 0;
            this.bucketUpdateFunction = bucketUpdateFunction;
        }
        void updateBucket(B spare, BucketOrdsEnum ordsEnum, long docCount) throws IOException;
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds.BucketOrdsEnum;
import java.util.Arrays;
    public interface BucketUpdateFunction<B> {
            return new SelectionResult<>(topBuckets, otherDocCount, "priority_queue");
                spare = ordered.insertWithOverflow(spare);
            this.actualStrategyUsed = actualStrategyUsed;
    }
            return new SelectionResult<>(topBuckets, otherDocCount, actualStrategy);
                    otherDocCount -= topBuckets[b].getDocCount();
     */
                }
            PriorityQueueBuilder<B> buildPriorityQueue,
            } else {
package org.opensearch.search.aggregations.bucket.terms;
                }
                    validBucketCount,
        long bucketDocCount(long ord) throws IOException;
                if (spare == null) {
                for (int b = ordered.size() - 1; b >= 0; --b) {
            this.bucketArrayBuilder = bucketArrayBuilder;
                long docCount = input.bucketDocCountFunction.bucketDocCount(input.ordsEnum.ord());
    /**
     */
    PRIORITY_QUEUE {
    /**
                if (docCount < input.localBucketCountThresholds.getMinDocCount()) {
        public final BucketOrdsEnum ordsEnum;
import org.opensearch.search.aggregations.BucketOrder;
    }
}
            case 2: size is greater than 20% of bucketsInOrd: QUICK_SELECT
        public final B[] topBuckets;
        if (((long) size * factor < bucketsInOrd) || isKeyOrder(order) || partiallyBuiltBucketComparator == null) {
                topBuckets = Arrays.copyOf(bucketsForOrd, input.size);
            case 3: size == bucketsInOrd : return all buckets
    };
    ) {
            } else {
        public final int ordIdx;
        }
            if (validBucketCount > input.size) {
            int size,
    public abstract <B extends InternalMultiBucketAggregation.InternalBucket> SelectionResult<B> selectTopBuckets(SelectionInput<B> input)
     * Represents the results strategy execution to select buckets
     */
        long bucketsInOrd,
        ) {
    @FunctionalInterface
        */
        if factor is 0, always use PRIORITY_QUEUE strategy (since 0 < bucketsInOrd is always true).
                }
                otherDocCount += docCount;
            this.emptyBucketBuilder = emptyBucketBuilder;
        public final int size;
    public static class SelectionResult<B extends InternalMultiBucketAggregation.InternalBucket> {
            return QUICK_SELECT_OR_SELECT_ALL;
            this.order = order;
        public final Comparator<InternalTerms.Bucket<?>> partiallyBuiltBucketComparator;
                    topBuckets[b] = itr.next();
import java.io.IOException;
    public interface BucketDocCountFunction {
import java.util.Iterator;
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
            this.ordIdx = ordIdx;
        Comparator<InternalTerms.Bucket<?>> partiallyBuiltBucketComparator,
                    (b1, b2) -> input.partiallyBuiltBucketComparator.compare((InternalTerms.Bucket<?>) b1, (InternalTerms.Bucket<?>) b2)
            LocalBucketCountThresholds localBucketCountThresholds,
            long otherDocCount = 0;
        }
        public final BucketOrder order;
 */
        public final BucketArrayBuilder<B> bucketArrayBuilder;
        public final long otherDocCount;
            throws IOException {
            }
                topBuckets = Arrays.copyOf(bucketsForOrd, validBucketCount);
/*
     * Interface for bucketDocCount method
import java.util.function.Supplier;
        public final BucketUpdateFunction<B> bucketUpdateFunction;
/**
                long docCount = input.bucketDocCountFunction.bucketDocCount(input.ordsEnum.ord());
                    input.size,
        throws IOException;
            BucketOrder order,
            return PRIORITY_QUEUE;
    public interface PriorityQueueBuilder<B> {
                actualStrategy = "select_all";
    }
            if (isKeyOrder(input.order)) {
                );
            this.partiallyBuiltBucketComparator = partiallyBuiltBucketComparator;
    }
    @FunctionalInterface
            while (input.ordsEnum.next()) {
                }
            case 1: size is less than 20% of bucketsInOrd: PRIORITY_QUEUE
        }
     */
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
            long otherDocCount = 0;
import org.apache.lucene.util.PriorityQueue;
            B[] bucketsForOrd = input.bucketArrayBuilder.buildBuckets((int) input.bucketsInOrd);
        public <B extends InternalMultiBucketAggregation.InternalBucket> SelectionResult<B> selectTopBuckets(SelectionInput<B> input)
        public final Supplier<B> emptyBucketBuilder;
            B[] topBuckets;
        public SelectionInput(
            BucketArrayBuilder<B> bucketArrayBuilder,
    @FunctionalInterface
            }
                    otherDocCount -= topBuckets[b].getDocCount();
 * this file be licensed under the Apache-2.0 license or a
            Comparator<InternalTerms.Bucket<?>> partiallyBuiltBucketComparator
    /**
        int factor
    @FunctionalInterface
        @Override
            this.topBuckets = topBuckets;
 *
            }
            this.bucketsInOrd = bucketsInOrd;
 */
                otherDocCount += docCount;
import org.apache.lucene.util.ArrayUtil;
    /**
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
    public interface BucketArrayBuilder<B> {
        int size,
     */
    }
                // Return all buckets (no selection needed)
            BucketOrdsEnum ordsEnum,
     * Interface for updateBucket method
                    continue;
            PriorityQueue<B> ordered = input.buildPriorityQueue.buildPriorityQueue(input.size);
                input.bucketUpdateFunction.updateBucket(spare, input.ordsEnum, docCount);
        }
            throws IOException {
            // Collect all valid buckets
     * Interface for buildBuckets method
            this.bucketDocCountFunction = bucketDocCountFunction;
            B spare = null;
     * Represents the inputs for strategy execution to select buckets
            int ordIdx,
     */
        if isKeyOrder or its significant term aggregation.
            long bucketsInOrd,
            B[] topBuckets = input.bucketArrayBuilder.buildBuckets(ordered.size());
enum BucketSelectionStrategy {
                ArrayUtil.select(
            BucketDocCountFunction bucketDocCountFunction,
    QUICK_SELECT_OR_SELECT_ALL {
                otherDocCount = 0L;
                    topBuckets[b] = ordered.pop();
    public static BucketSelectionStrategy determine(
                for (int b = ordered.size() - 1; b >= 0; --b) {
    /**
    public static class SelectionInput<B extends InternalMultiBucketAggregation.InternalBucket> {
        public final long bucketsInOrd;
                for (int b = 0; b < input.size; b++) {
        public SelectionResult(B[] topBuckets, long otherDocCount, String actualStrategyUsed) {
        } else {
    /**
        Along with the above conditions, we also go with the original PRIORITY_QUEUE based approach
            String actualStrategy;
            this.ordsEnum = ordsEnum;
        public final BucketDocCountFunction bucketDocCountFunction;
        PriorityQueue<B> buildPriorityQueue(int size);
            this.buildPriorityQueue = buildPriorityQueue;
 * Strategy for selecting top buckets from aggregation results.
    }
                B spare = input.emptyBucketBuilder.get();
                actualStrategy = "quick_select";
        /*
        public final String actualStrategyUsed;
import java.util.Comparator;
    },
 * The OpenSearch Contributors require contributions made to
            this.localBucketCountThresholds = localBucketCountThresholds;
