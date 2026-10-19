        public final int size;
        int factor
            this.bucketArrayBuilder = bucketArrayBuilder;
                    continue;
            return PRIORITY_QUEUE;
                    otherDocCount -= topBuckets[b].getDocCount();  
            long otherDocCount = 0;  
                }
     * Interface for buildPriorityQueue method  
     * Represents the inputs for strategy execution to select buckets
                input.bucketUpdateFunction.updateBucket(spare, input.ordsEnum, docCount);
                actualStrategy = "select_all";
    /**
        Along with the above conditions, we also go with the original PRIORITY_QUEUE based approach
                spare = ordered.insertWithOverflow(spare);  
                otherDocCount += docCount;
                topBuckets = Arrays.copyOf(bucketsForOrd, validBucketCount);
            long otherDocCount = 0;  
    /**
            throws IOException {  
            this.topBuckets = topBuckets;
        @Override
        public final B[] topBuckets;  
    public interface BucketDocCountFunction {  
            case 3: size == bucketsInOrd : return all buckets
            BucketOrder order,
 *  
    public static class SelectionInput<B extends InternalMultiBucketAggregation.InternalBucket> {
            int size,
    public abstract <B extends InternalMultiBucketAggregation.InternalBucket> SelectionResult<B> selectTopBuckets(SelectionInput<B> input)
    public interface BucketArrayBuilder<B> {
                    input.size,
    public interface PriorityQueueBuilder<B> {  
            throws IOException {  
        int size,  
        BucketOrder order,
        throws IOException;
enum BucketSelectionStrategy {
        public final LocalBucketCountThresholds localBucketCountThresholds;  
import org.apache.lucene.util.PriorityQueue;
            this.order = order;
                }
    }  
        }
                    (b1, b2) -> input.partiallyBuiltBucketComparator.compare((InternalTerms.Bucket<?>) b1, (InternalTerms.Bucket<?>) b2)
            this.size = size;
 * compatible open source license.
     * Interface for updateBucket method
                for (int b = ordered.size() - 1; b >= 0; --b) {
import java.util.Arrays;  
    QUICK_SELECT_OR_SELECT_ALL {  
        public SelectionResult(B[] topBuckets, long otherDocCount, String actualStrategyUsed) {
                otherDocCount = 0L;  
    };  
    public static class SelectionResult<B extends InternalMultiBucketAggregation.InternalBucket> {
    /**
                for (int b = ordered.size() - 1; b >= 0; --b) {
            case 2: size is greater than 20% of bucketsInOrd: QUICK_SELECT  
        long bucketsInOrd,
                long docCount = input.bucketDocCountFunction.bucketDocCount(input.ordsEnum.ord());  
     */
            B[] topBuckets;  
    }
            LocalBucketCountThresholds localBucketCountThresholds,
                otherDocCount += docCount;
                if (spare == null) {
            BucketUpdateFunction<B> bucketUpdateFunction,
 * SPDX-License-Identifier: Apache-2.0
     */
    }
        public <B extends InternalMultiBucketAggregation.InternalBucket> SelectionResult<B> selectTopBuckets(SelectionInput<B> input)
            int ordIdx,  
    }  
            BucketArrayBuilder<B> bucketArrayBuilder,  
                for (int b = 0; b < input.size; b++) {
                topBuckets = Arrays.copyOf(bucketsForOrd, input.size);
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
    @FunctionalInterface  
     */  
                actualStrategy = "quick_select";
     */  
        } else {
                input.bucketUpdateFunction.updateBucket(spare, input.ordsEnum, docCount);
            B[] topBuckets = input.bucketArrayBuilder.buildBuckets(ordered.size());  
        */
        /*  
                    bucketsForOrd,
        public final BucketUpdateFunction<B> bucketUpdateFunction;
     */
                    topBuckets[b] = itr.next();  
        if factor is 0, always use PRIORITY_QUEUE strategy (since 0 < bucketsInOrd is always true).
            this.buildPriorityQueue = buildPriorityQueue;  
        public SelectionInput(  
            String actualStrategy;
import java.io.IOException;
        public <B extends InternalMultiBucketAggregation.InternalBucket> SelectionResult<B> selectTopBuckets(SelectionInput<B> input)
 */
            this.bucketUpdateFunction = bucketUpdateFunction;
    }
            PriorityQueue<B> ordered = input.buildPriorityQueue.buildPriorityQueue(input.size);
        }  
            if (validBucketCount > input.size) {
        We select the strategy based on the following condition with configurable threshold factor:
 *
            PriorityQueueBuilder<B> buildPriorityQueue,
            this.ordIdx = ordIdx;
                Iterator<B> itr = ordered.iterator();
            long bucketsInOrd,
            this.partiallyBuiltBucketComparator = partiallyBuiltBucketComparator;
        ) {
                }
        void updateBucket(B spare, BucketOrdsEnum ordsEnum, long docCount) throws IOException;  
 * this file be licensed under the Apache-2.0 license or a
            } else {  
import org.apache.lucene.util.ArrayUtil;
            }
            this.localBucketCountThresholds = localBucketCountThresholds;  
                    validBucketCount,  
        public final int ordIdx;
 * Strategy for selecting top buckets from aggregation results.
        public final long otherDocCount;
        public final PriorityQueueBuilder<B> buildPriorityQueue;  
                    topBuckets[b] = ordered.pop();  
            }
import java.util.function.Supplier;  
            B spare = null;
        }
     * Interface for buildBuckets method
            case 1: size is less than 20% of bucketsInOrd: PRIORITY_QUEUE
     */
            int validBucketCount = 0;
        if isKeyOrder or its significant term aggregation.
            }
                long docCount = input.bucketDocCountFunction.bucketDocCount(input.ordsEnum.ord());
                // Return all buckets (no selection needed)
    ) {
            BucketOrdsEnum ordsEnum,  
                    0,
import java.util.Iterator;
    public interface BucketUpdateFunction<B> {
    @FunctionalInterface
        B[] buildBuckets(int size);
     * Interface for bucketDocCount method  
        public final Comparator<InternalTerms.Bucket<?>> partiallyBuiltBucketComparator;
    /**  
                ArrayUtil.select(  
                bucketsForOrd[validBucketCount++] = spare;  
    @FunctionalInterface
        public final long bucketsInOrd;  
    /**
            this.otherDocCount = otherDocCount;  
    @FunctionalInterface
     * Represents the results strategy execution to select buckets  
            this.bucketDocCountFunction = bucketDocCountFunction;  
            return QUICK_SELECT_OR_SELECT_ALL;  
/*  
            this.emptyBucketBuilder = emptyBucketBuilder;
        @Override
            this.bucketsInOrd = bucketsInOrd;  
        public final String actualStrategyUsed;
            BucketDocCountFunction bucketDocCountFunction,
            if (isKeyOrder(input.order)) {
        public final Supplier<B> emptyBucketBuilder;
        public final BucketOrder order;
            return new SelectionResult<>(topBuckets, otherDocCount, actualStrategy);
    /**
        public final BucketDocCountFunction bucketDocCountFunction;  
        public final BucketOrdsEnum ordsEnum;
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        long bucketDocCount(long ord) throws IOException;
            }  
        PriorityQueue<B> buildPriorityQueue(int size);
package org.opensearch.search.aggregations.bucket.terms;
import org.opensearch.search.aggregations.BucketOrder;  
            while (input.ordsEnum.next()) {  
        if (((long) size * factor < bucketsInOrd) || isKeyOrder(order) || partiallyBuiltBucketComparator == null) {  
    }
            this.ordsEnum = ordsEnum;
            B[] bucketsForOrd = input.bucketArrayBuilder.buildBuckets((int) input.bucketsInOrd);
            } else {  
 */  
        public final BucketArrayBuilder<B> bucketArrayBuilder;
        Comparator<InternalTerms.Bucket<?>> partiallyBuiltBucketComparator,  
                if (docCount < input.localBucketCountThresholds.getMinDocCount()) {  
}  
            this.actualStrategyUsed = actualStrategyUsed;
        case 2 and 3 are encapsulated in QUICK_SELECT_OR_SELECT_ALL method.
                );  
                    otherDocCount -= topBuckets[b].getDocCount();
    },
                    continue;  
                if (docCount < input.localBucketCountThresholds.getMinDocCount()) {
                    spare = input.emptyBucketBuilder.get();  
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds.BucketOrdsEnum;  
            Comparator<InternalTerms.Bucket<?>> partiallyBuiltBucketComparator  
 * The OpenSearch Contributors require contributions made to  
/**
    }  
                }
                }
                }
        }
    PRIORITY_QUEUE {  
            return new SelectionResult<>(topBuckets, otherDocCount, "priority_queue");
            Supplier<B> emptyBucketBuilder,
import java.util.Comparator;
            while (input.ordsEnum.next()) {
                    otherDocCount -= topBuckets[b].getDocCount();
        }
    public static BucketSelectionStrategy determine(
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
                B spare = input.emptyBucketBuilder.get();
            // Collect all valid buckets
