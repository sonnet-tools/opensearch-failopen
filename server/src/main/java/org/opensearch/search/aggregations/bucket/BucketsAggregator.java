import java.util.function.Function;
                setAggs.accept(buckets[r][b], results[s++]);
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
        super.preGetSubLeafCollectors(ctx);
     *  If a bucket's ordinal is mapped to -1 then the bucket is removed entirely.
            for (int offsetInOwningOrd = 0; offsetInOwningOrd < bucketsPerOwningBucketOrd; offsetInOwningOrd++) {  
    protected final InternalAggregation[] buildAggregationsForSingleBucket(long[] owningBucketOrds, SingleBucketResultBuilder resultBuilder)
                            + bucketOrdsToCollect[b]
    @Deprecated  
        long totalOrdsToCollect = 0;
    /**  
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
        int totalBucketOrdsToCollect = 0;
import org.opensearch.search.aggregations.CardinalityUpperBound;
 * the Apache License, Version 2.0 (the "License"); you may
        long[] bucketOrdsToCollect = new long[totalBucketOrdsToCollect];  
        bucketOrdIdx = 0;
/*
        while (parent != null) {
        }
import java.util.function.IntConsumer;  
        if (docCounts.increment(bucketOrd, docCount) == docCount) {
            List<B> buckets = new ArrayList<>((int) bucketOrds.size());  
     */
     * or {@link #buildAggregationsForVariableBuckets(long[], LongKeyedBucketOrds, BucketBuilderForVariable, ResultBuilderForVariable)}  
     * Return an upper bound of the maximum bucket ordinal seen so far.  
        beforeBuildingBuckets(bucketOrdsToCollect);  
            }  
    public final void close() {  
     * This only tidies up doc counts. Call {@link MergingBucketsDeferringCollector#mergeBuckets(long[])}  to merge the actual
    protected void beforeBuildingBuckets(long[] ordsToCollect) throws IOException {}
 * GitHub history for details.
        throw new IllegalArgumentException(
                long docCount = oldDocCounts.get(i);  
     */  
import java.util.ArrayList;  
 * Base class to collect all docs into buckets
    }
import org.opensearch.common.lease.Releasable;
    /**
     * @opensearch.internal
    /**
     * in which bucket they build. They use some mechanism of selecting a list  
        InternalAggregations[] results = buildSubAggsForBuckets(bucketOrdsToCollect);
 * not use this file except in compliance with the License.
        }
                long destinationOrdinal = mergeMap.applyAsLong(i);
/*
            return 0;
    /**  
    /**
                    bucketBuilder.build(
    /**  
    public final void mergeBuckets(long[] mergeMap, long newNumBuckets) {
    }  
 * ownership. Elasticsearch licenses this file to you under  
     * @param setAggs how to set the sub-aggregation results on a bucket
        if (this instanceof SingleBucketAggregator) {
     */  
        docCounts.fill(0, docCounts.size(), 0);
     *
    protected final <B> InternalAggregation[] buildAggregationsForFixedBucketCount(  
    protected interface SingleBucketResultBuilder {  
            multiBucketConsumer.accept(0);  
            for (int offsetInOwningOrd = 0; offsetInOwningOrd < bucketsPerOwningBucketOrd; offsetInOwningOrd++) {  
     */  
    }
    /**
                );
    protected final DocCountProvider docCountProvider;
     */
 * Unless required by applicable law or agreed to in writing,
                    return aggregations[index][thisOrd];  
        for (long owningBucketOrd : owningBucketOrds) {
     * A bucket builder for a variable
        if (docCounts.increment(bucketOrd, docCount) == docCount) {
package org.opensearch.search.aggregations.bucket;
     * @param owningBucketOrds owning bucket ordinals for which to build the results
            result[ord] = InternalAggregations.from(new AbstractList<InternalAggregation>() {  
            subCollector.collectStarTreeEntry(entryBit, bucketOrd);  
                bucketOrdsToCollect[b++] = ordsEnum.ord();
 */  
                        "Iteration order of ["
        s = 0;
                        offsetInOwningOrd,  
    }  
        long[] bucketOrdsToCollect = new long[(int) totalOrdsToCollect];
        B[][] buckets,
import org.opensearch.search.sort.SortOrder;
 *  
            parent = parent.parent();
                + ".doc_count\") or \"key\"."
        docCounts = bigArrays.grow(docCounts, bucketOrd + 1);  
 * specific language governing permissions and limitations
     * @param resultBuilder how to build a result from the sub aggregation results  
        }  
     * After collecting doc count, invoke collectStarTreeEntry() for sub-collectors to update their relevant buckets
     * <p>  
            return super.bucketComparator(key, order);
                            + "] should have been ["  
     * A bucket builder for a fixed count  
        InternalAggregations[] subAggregationResults = buildSubAggsForBuckets(bucketOrdsToCollect);
     * Hook to allow taking an action before building buckets.
            }
public abstract class BucketsAggregator extends AggregatorBase {  
     *  
                            + "] changed without mutating. ["
    }  
        throws IOException {  
                }
        }
    private final BigArrays bigArrays;
     * <p>
    }
import java.util.Iterator;
}
    public final long bucketDocCount(long bucketOrd) {
        InternalAggregations[] subAggregationResults = buildSubAggsForBuckets(owningBucketOrds);
                public int size() {
        if (context.aggregations() != null) {
        int s = 0;
     */
        return results;
     */  
    /**
     * @param bucketBuilder how to build a bucket  
     */
     * or {@link #buildAggregationsForSingleBucket(long[], SingleBucketResultBuilder)}
        return super.resolveSortPath(next, path);
        InternalAggregation[][] aggregations = new InternalAggregation[subAggregators.length][];
        InternalAggregation build(long owningBucketOrd, InternalAggregations subAggregationResults);
    public final void collectExistingBucket(LeafBucketCollector subCollector, int doc, long bucketOrd) throws IOException {  
 * SPDX-License-Identifier: Apache-2.0
     */
    @Override  
        BucketBuilderForVariable<B> bucketBuilder,
        B build(long bucketValue, long docCount, InternalAggregations subAggregationResults);
            return docCounts.get(bucketOrd);  
            results[owningOrdIdx] = resultBuilder.apply(buckets);  
     *  
        Aggregator parent,
        }
     * @param bucketOrds hash of values to the bucket ordinal
        }
                bucketOrdsToCollect[bucketOrdIdx++] = ord++;
        for (StarTreeBucketCollector subCollector : collector.getSubCollectors()) {
    protected void preGetSubLeafCollectors(LeafReaderContext ctx) throws IOException {  
import org.opensearch.common.util.BigArrays;
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (bucketOrd < 0) {
    }  
                + name()  
    /**
        docCountProvider = new DocCountProvider();
    private final IntConsumer multiBucketConsumer;  
     * of buckets to build use this method to "finish" building the results.
     * instead of calling this directly.  
                        bucketDocCount(bucketOrdsToCollect[bucketOrdIdx]),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    protected final <B> void buildSubAggsForAllBuckets(  
            totalOrdsToCollect += bucketOrds.bucketsInOrd(owningBucketOrds[ordIdx]);
            );  
        BucketBuilderForFixedCount<B> bucketBuilder,  
     * Refer to that method for documentation about the merge map.
        String name,
                    throw new AggregationExecutionException(
/*  
        AggregatorFactories factories,  
        }  
    protected interface BucketBuilderForFixedCount<B> {
     * Build aggregation results for an aggregator that has a fixed number of buckets per owning ordinal.
import org.opensearch.search.aggregations.Aggregator;
        }  
            totalBucketOrdsToCollect += bucketsForOneResult.length;
        CardinalityUpperBound bucketCardinality,  
                if (docCount == 0) continue;
                + name()
     */
            // We calculate the final number of buckets only during the reduce phase. But we still need to  
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
     * A single bucket result builder
import java.util.AbstractList;
        } else {
    public final void mergeBuckets(long newNumBuckets, LongUnaryOperator mergeMap) {
                }
        return results;  
        long[] owningBucketOrds,
            }
import java.util.function.BiConsumer;
    public BucketsAggregator(
                return true;  
        for (B[] bucketsForOneResult : buckets) {  
     * @deprecated use {@link mergeBuckets(long, LongUnaryOperator)}
            super.close();
    @FunctionalInterface
    public final long maxBucketOrd() {
        int b = 0;  
            docCounts = bigArrays.newLongArray(newNumBuckets, true);  
            "Ordering on a single-bucket aggregation can only be done on its doc_count. "
                }  
    ) throws IOException {  
        } else {
        return result;  
        }
import java.io.IOException;
            while (ordsEnum.next()) {
    public LongArray getDocCounts() {
            List<B> buckets = new ArrayList<>(bucketsPerOwningBucketOrd);
            bucketOrd = -1 - bucketOrd;  
    protected interface BucketBuilderForVariable<B> {  
                if (destinationOrdinal != -1) {  
            }
        throws IOException {
                            + "]"
 */
        InternalAggregation build(long owninigBucketOrd, List<B> buckets);
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
        InternalAggregations[] subAggregationResults = buildSubAggsForBuckets(bucketOrdsToCollect);
     */
     * or {@link #buildAggregationsForFixedBucketCount(long[], int, BucketBuilderForFixedCount, Function)}
                public InternalAggregation get(int index) {
        }
        collectExistingBucket(subCollector, doc, bucketOrd);  
         * It'd be entirely reasonable to call
            }
        }  
    }
    /**
import org.opensearch.search.aggregations.support.AggregationPath;  
        docCounts = bigArrays.grow(docCounts, maxBucketOrd);
import java.util.Map;  
import org.opensearch.common.util.LongArray;  
            });
    }
        bigArrays = context.bigArrays();
/**
            final int thisOrd = ord;
        if (totalOrdsToCollect > Integer.MAX_VALUE) {  
        }  
     */
    ) throws IOException {
    /**  
        }
            multiBucketConsumer = (count) -> {};
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
                @Override  
        docCounts = bigArrays.newLongArray(1, true);
    }
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
    protected interface ResultBuilderForVariable<B> {
    ) throws IOException {
    public final void collectStarTreeBucket(StarTreeBucketCollector collector, long docCount, long bucketOrd, int entryBit)  
     * @opensearch.internal
                }
     */
import org.opensearch.search.aggregations.InternalAggregation;  
        }
        Function<List<B>, InternalAggregation> resultBuilder
            // matches the filter, then the filter will never collect bucket ord 3. However, the long terms agg will call
     * A result builder for a bucket variable
    }  
    /**
     * Most aggregations should probably use something like
            multiBucketConsumer = context.aggregations().multiBucketConsumer();  
 */
                buckets.add(bucketBuilder.build(ordsEnum.value(), bucketDocCount(ordsEnum.ord()), subAggregationResults[b++]));
    public final void collectBucket(LeafBucketCollector subCollector, int doc, long bucketOrd) throws IOException {
        return results;  
        }  
     * the provided ordinals.
                            + ordsEnum.ord()
        int totalBuckets = owningBucketOrds.length * bucketsPerOwningBucketOrd;
     * Build aggregation results for an aggregator with a varying number of
        try (Releasable releasable = docCounts) {
        // Set LeafReaderContext to the doc_count provider
        }
        }  
    protected LongArray docCounts;
        }  
     * the buckets. This is usually used by aggregations that are selective
    }
 * Licensed to Elasticsearch under one or more contributor  
    public Aggregator resolveSortPath(AggregationPath.PathElement next, Iterator<AggregationPath.PathElement> path) {
                + "\") or change it to \"doc_count\" (a la \""
        }  
        if (false == this instanceof SingleBucketAggregator) {
            // the execution if we are running out. To achieve that we are passing 0 as a bucket count.
        super(name, factories, context, parent, bucketCardinality, metadata);  
     * Build the sub aggregation results for a list of buckets and set them on
                @Override
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
    }  
    @Override
        for (int owningOrdIdx = 0; owningOrdIdx < owningBucketOrds.length; owningOrdIdx++) {
         * `consumeBucketsAndMaybeBreak(owningBucketOrds.length)`  
            for (B bucket : bucketsForOneResult) {  
        }
import org.opensearch.search.aggregations.StarTreeBucketCollector;  
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];  
        return docCounts;
        long[] bucketOrdsToCollect = new long[totalBuckets];
            for (int b = 0; b < buckets[r].length; b++) {
    }
     */
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
        ResultBuilderForVariable<B> resultBuilder
        subCollector.collect(doc, bucketOrd);
import org.opensearch.search.aggregations.AggregatorBase;  
            while (ordsEnum.next()) {  
         * here but we don't because single bucket aggs never have.
        SearchContext context,
     *
        LongKeyedBucketOrds bucketOrds,  
        ToLongFunction<B> bucketToOrd,
     * This only tidies up doc counts. Call {@link MergingBucketsDeferringCollector#mergeBuckets(LongUnaryOperator)} to
    public void doReset() {
     * @return the sub-aggregation results in the same order as the provided
    }
import java.util.function.LongUnaryOperator;
        if (key == null || "doc_count".equals(key)) {
    /**  
     * Ensure there are at least <code>maxBucketOrd</code> buckets available.
 * license agreements. See the NOTICE file distributed with
     * @param owningBucketOrds owning bucket ordinals for which to build the results
                // Skip any in the map which have been "removed", signified with -1
     * Utility method to collect doc count in the given bucket (identified by the bucket ordinal)  
     */  
import java.util.List;
            // trigger bucket consumer from time to time in order to give it a chance to check available memory and break
     * Same as {@link #collectBucket(LeafBucketCollector, int, long)}, but doesn't check if the docCounts needs to be re-sized.
            }  
        for (int i = 0; i < subAggregators.length; i++) {
    public final void incrementBucketDocCount(long bucketOrd, long inc) {
                    return aggregations.length;
        int bucketsPerOwningBucketOrd,
        }
         */
    }  
    }
 * under the License.  
    public final void grow(long maxBucketOrd) {  
                    )  
            throw new AggregationExecutionException(
     * Utility method to return the number of documents that fell in the given bucket (identified by the bucket ordinal)
    }
    public static boolean descendsFromGlobalAggregator(Aggregator parent) {  
 *
        return docCounts.size();  
        long docCount = docCountProvider.getDocCount(doc);
import org.opensearch.search.aggregations.InternalAggregations;
                            + bucketOrds  
    /**  
 *  
     * @param bucketToOrd how to convert a bucket into an ordinal  
        }
        for (int r = 0; r < buckets.length; r++) {  
        checkCancelled();
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
    }
                    docCounts.increment(destinationOrdinal, docCount);
    }
                if (bucketOrdsToCollect[b] != ordsEnum.ord()) {  
            // For example, if there is a long terms agg on 3 terms 1,2,3 with a sub filter aggregator and if no document with 3 as a value
        docCounts.increment(bucketOrd, inc);
     * {@code long} keyed buckets.  
            if (parent.getClass() == GlobalAggregator.class) {
            results[ordIdx] = resultBuilder.build(owningBucketOrds[ordIdx], subAggregationResults[ordIdx]);
            long ord = owningBucketOrd * bucketsPerOwningBucketOrd;
        }
    }  
    @Override
            }  
        }
 * software distributed under the License is distributed on an
        int bucketOrdIdx = 0;  
        for (int ord = 0; ord < bucketOrdsToCollect.length; ord++) {
        checkCancelled();  
    @FunctionalInterface
     */
            // bucketAggregations(3) on the filter aggregator anyway to build sub-aggregations.  
    }
        Map<String, Object> metadata
        long[] owningBucketOrds,
            grow(bucketOrd + 1);
     * Utility method to collect the given doc in the given bucket (identified by the bucket ordinal)
     * Build the results of the sub-aggregations of the buckets at each of
        } else {
 */
            aggregations[i] = subAggregators[i].buildAggregations(bucketOrdsToCollect);
import org.opensearch.search.aggregations.AggregatorFactories;
 * You may obtain a copy of the License at  
     *  @param mergeMap a unary operator which maps a bucket's ordinal to the ordinal it should be merged with.
        mergeBuckets(newNumBuckets, bucket -> mergeMap[Math.toIntExact(bucket)]);
        checkCancelled();  
            }
            for (long i = 0; i < oldDocCounts.size(); i++) {
     *         array of ordinals
 * this work for additional information regarding copyright
        /*
     * @param <B> the type of the bucket  
        for (B[] bucketsForOneResult : buckets) {
 * Modifications Copyright OpenSearch Contributors. See  
     * @opensearch.internal  
    public BucketComparator bucketComparator(String key, SortOrder order) {  
    /**  
     */  
     *  
        BiConsumer<B, InternalAggregations> setAggs  
     * @param bucketsPerOwningBucketOrd how many buckets there are per ord
            docCounts.fill(0, newNumBuckets, 0);
import org.opensearch.search.aggregations.AggregationExecutionException;
    /**
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
     * @opensearch.internal  
     * ordinals and doc ID deltas.  
        if (bucketOrd >= docCounts.size()) {
     * merge the actual ordinals and doc ID deltas.
        );
            return resolveSortPathOnValidAgg(next, path);  
            checkCancelled();  
     */  
    @FunctionalInterface
                "Can't collect more than [" + Integer.MAX_VALUE + "] buckets but attempted [" + totalOrdsToCollect + "]"
     * Utility method to increment the doc counts of the given bucket (identified by the bucket ordinal)  
     *
import org.apache.lucene.index.LeafReaderContext;  
    }  
    protected final InternalAggregations[] buildSubAggsForBuckets(long[] bucketOrdsToCollect) throws IOException {
            multiBucketConsumer.accept(0);  
        return false;
                        subAggregationResults[bucketOrdIdx++]
        docCountProvider.setLeafReaderContext(ctx);  
 * @opensearch.internal
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];  
        try (LongArray oldDocCounts = docCounts) {
     * <p>  
        b = 0;
        B build(int offsetInOwningOrd, long docCount, InternalAggregations subAggregationResults);  
                buckets.add(
    /**
                bucketOrdsToCollect[s++] = bucketToOrd.applyAsLong(bucket);
    }
    /**
     * @param buckets the buckets to finish building
    @FunctionalInterface  
    /**
    protected final <B> InternalAggregation[] buildAggregationsForVariableBuckets(
     * @param owningBucketOrds owning bucket ordinals for which to build the results
     * {@link #buildSubAggsForAllBuckets(Object[][], ToLongFunction, BiConsumer)}
            return (lhs, rhs) -> order.reverseMul() * Long.compare(bucketDocCount(lhs), bucketDocCount(rhs));
     */
    }
    ) throws IOException {
        grow(bucketOrd + 1);
            // This may happen eg. if no document in the highest buckets is accepted by a sub aggregator.  
        checkCancelled();
                + "Either drop the key (a la \""  
import org.opensearch.search.aggregations.LeafBucketCollector;
        InternalAggregations[] result = new InternalAggregations[bucketOrdsToCollect.length];  
import java.util.function.ToLongFunction;
    }
            results[ordIdx] = resultBuilder.build(owningBucketOrds[ordIdx], buckets);
     * Build aggregation results for an aggregator that always contain a single bucket.
 * compatible open source license.
                    );  
    @Override
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.internal.SearchContext;
     * @param resultBuilder how to build a result from buckets
