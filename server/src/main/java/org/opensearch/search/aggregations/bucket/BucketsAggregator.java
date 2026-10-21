     * Build aggregation results for an aggregator that has a fixed number of buckets per owning ordinal.
     * This only tidies up doc counts. Call {@link MergingBucketsDeferringCollector#mergeBuckets(LongUnaryOperator)} to
                bucketOrdsToCollect[s++] = bucketToOrd.applyAsLong(bucket);
        }
                setAggs.accept(buckets[r][b], results[s++]);
    }
            checkCancelled();
        s = 0;
    }
                buckets.add(bucketBuilder.build(ordsEnum.value(), bucketDocCount(ordsEnum.ord()), subAggregationResults[b++]));
    /**
        Map<String, Object> metadata
import org.opensearch.search.aggregations.StarTreeBucketCollector;
        while (parent != null) {
    /**
     */
     * <p>
     * Build the results of the sub-aggregations of the buckets at each of
        throw new IllegalArgumentException(
                );
    /**
import org.opensearch.search.aggregations.AggregatorBase;
     * of buckets to build use this method to "finish" building the results.
        }
     * the buckets. This is usually used by aggregations that are selective
    }
    }
        InternalAggregations[] subAggregationResults = buildSubAggsForBuckets(bucketOrdsToCollect);
     *         array of ordinals
            return resolveSortPathOnValidAgg(next, path);
        return docCounts.size();
            List<B> buckets = new ArrayList<>(bucketsPerOwningBucketOrd);
import org.opensearch.search.aggregations.InternalAggregation;
     */
     */
        InternalAggregations[] result = new InternalAggregations[bucketOrdsToCollect.length];
                public int size() {
    public LongArray getDocCounts() {
        return super.resolveSortPath(next, path);
            results[ordIdx] = resultBuilder.build(owningBucketOrds[ordIdx], subAggregationResults[ordIdx]);
        }
        }
     * the provided ordinals.
 * The OpenSearch Contributors require contributions made to
     * Utility method to collect doc count in the given bucket (identified by the bucket ordinal)
     */
import java.io.IOException;
import java.util.function.Function;
     * <p>
    @FunctionalInterface
        docCountProvider = new DocCountProvider();
    /**
        }
     * A single bucket result builder
/*
 */
    /**
        throws IOException {
import java.util.Iterator;
/**
        for (int owningOrdIdx = 0; owningOrdIdx < owningBucketOrds.length; owningOrdIdx++) {
        beforeBuildingBuckets(bucketOrdsToCollect);
     * @opensearch.internal
    /**
        if (totalOrdsToCollect > Integer.MAX_VALUE) {
        try (Releasable releasable = docCounts) {
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
     */
            for (B bucket : bucketsForOneResult) {
        return docCounts;
        }
    }
     *
            multiBucketConsumer.accept(0);
        docCounts.fill(0, docCounts.size(), 0);
     *  @param mergeMap a unary operator which maps a bucket's ordinal to the ordinal it should be merged with.
    }
     * Utility method to collect the given doc in the given bucket (identified by the bucket ordinal)
 * SPDX-License-Identifier: Apache-2.0
        for (long owningBucketOrd : owningBucketOrds) {
    public final long bucketDocCount(long bucketOrd) {
    protected LongArray docCounts;
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
        for (int r = 0; r < buckets.length; r++) {
            }
 * this file be licensed under the Apache-2.0 license or a
    }
        }
     * @param resultBuilder how to build a result from buckets
     * {@link #buildSubAggsForAllBuckets(Object[][], ToLongFunction, BiConsumer)}
 * software distributed under the License is distributed on an
        subCollector.collect(doc, bucketOrd);
        InternalAggregations[] subAggregationResults = buildSubAggsForBuckets(bucketOrdsToCollect);
    /**
    public BucketComparator bucketComparator(String key, SortOrder order) {
     * This only tidies up doc counts. Call {@link MergingBucketsDeferringCollector#mergeBuckets(long[])}  to merge the actual
         * It'd be entirely reasonable to call
        }
        }
    public final void collectBucket(LeafBucketCollector subCollector, int doc, long bucketOrd) throws IOException {
                        offsetInOwningOrd,
     * @param bucketToOrd how to convert a bucket into an ordinal
                            + "] changed without mutating. ["
        bigArrays = context.bigArrays();
            results[ordIdx] = resultBuilder.build(owningBucketOrds[ordIdx], buckets);
    @Override
    /**
            multiBucketConsumer = (count) -> {};
    protected final <B> InternalAggregation[] buildAggregationsForFixedBucketCount(
        return results;
 * You may obtain a copy of the License at
     * in which bucket they build. They use some mechanism of selecting a list
     * Return an upper bound of the maximum bucket ordinal seen so far.
            subCollector.collectStarTreeEntry(entryBit, bucketOrd);
 *
    }
            // This may happen eg. if no document in the highest buckets is accepted by a sub aggregator.
                            + "] should have been ["
    }
        }
        checkCancelled();
     */
     */
     */
        long[] bucketOrdsToCollect = new long[(int) totalOrdsToCollect];
        InternalAggregation build(long owningBucketOrd, InternalAggregations subAggregationResults);
        }
        long totalOrdsToCollect = 0;
    private final IntConsumer multiBucketConsumer;
import java.util.List;
            final int thisOrd = ord;
import java.util.AbstractList;
import java.util.function.IntConsumer;
                + name()
        }
        String name,
        InternalAggregations[] subAggregationResults = buildSubAggsForBuckets(owningBucketOrds);
        LongKeyedBucketOrds bucketOrds,
                if (bucketOrdsToCollect[b] != ordsEnum.ord()) {
        B build(long bucketValue, long docCount, InternalAggregations subAggregationResults);
        InternalAggregation build(long owninigBucketOrd, List<B> buckets);
     * Build aggregation results for an aggregator that always contain a single bucket.
        }
import java.util.Map;
    protected final <B> InternalAggregation[] buildAggregationsForVariableBuckets(
    public Aggregator resolveSortPath(AggregationPath.PathElement next, Iterator<AggregationPath.PathElement> path) {
    }
                    )
import org.opensearch.search.aggregations.Aggregator;
        int totalBuckets = owningBucketOrds.length * bucketsPerOwningBucketOrd;
     * @param setAggs how to set the sub-aggregation results on a bucket
     */
    ) throws IOException {
import org.opensearch.search.aggregations.LeafBucketCollector;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
    protected final InternalAggregation[] buildAggregationsForSingleBucket(long[] owningBucketOrds, SingleBucketResultBuilder resultBuilder)
    protected interface SingleBucketResultBuilder {
    @Deprecated
    protected final <B> void buildSubAggsForAllBuckets(
     */
        InternalAggregation[][] aggregations = new InternalAggregation[subAggregators.length][];
    public final void close() {
        return false;
    @FunctionalInterface
 * Unless required by applicable law or agreed to in writing,
            // bucketAggregations(3) on the filter aggregator anyway to build sub-aggregations.
        long[] bucketOrdsToCollect = new long[totalBucketOrdsToCollect];
    /**
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
                }
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
        bucketOrdIdx = 0;
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            }
    }
        );
        docCounts = bigArrays.grow(docCounts, maxBucketOrd);
    }
     * @param bucketBuilder how to build a bucket
        if (bucketOrd >= docCounts.size()) {
    public final void mergeBuckets(long newNumBuckets, LongUnaryOperator mergeMap) {
    }
        collectExistingBucket(subCollector, doc, bucketOrd);
import org.opensearch.common.lease.Releasable;
            grow(bucketOrd + 1);
        } else {
     * @param owningBucketOrds owning bucket ordinals for which to build the results
            docCounts.fill(0, newNumBuckets, 0);
     */
        BiConsumer<B, InternalAggregations> setAggs
 */
     */
                            + bucketOrdsToCollect[b]
/*
                if (destinationOrdinal != -1) {
     * @param resultBuilder how to build a result from the sub aggregation results
        }
    public final void incrementBucketDocCount(long bucketOrd, long inc) {
import org.opensearch.search.sort.SortOrder;
 * not use this file except in compliance with the License.
        for (StarTreeBucketCollector subCollector : collector.getSubCollectors()) {
            if (parent.getClass() == GlobalAggregator.class) {
        checkCancelled();
        int s = 0;
        int totalBucketOrdsToCollect = 0;
            totalOrdsToCollect += bucketOrds.bucketsInOrd(owningBucketOrds[ordIdx]);
     * Refer to that method for documentation about the merge map.
         * here but we don't because single bucket aggs never have.
            for (int offsetInOwningOrd = 0; offsetInOwningOrd < bucketsPerOwningBucketOrd; offsetInOwningOrd++) {
 * GitHub history for details.
     * Ensure there are at least <code>maxBucketOrd</code> buckets available.
                if (docCount == 0) continue;
import org.opensearch.search.aggregations.CardinalityUpperBound;
    }
    protected interface BucketBuilderForFixedCount<B> {
     *
    }
        docCounts = bigArrays.newLongArray(1, true);
            // trigger bucket consumer from time to time in order to give it a chance to check available memory and break
        long[] owningBucketOrds,
        return results;
                            + bucketOrds
                bucketOrdsToCollect[b++] = ordsEnum.ord();
        ToLongFunction<B> bucketToOrd,
            results[owningOrdIdx] = resultBuilder.apply(buckets);
    public BucketsAggregator(
package org.opensearch.search.aggregations.bucket;
    /**
import org.opensearch.common.util.LongArray;
 * Licensed to Elasticsearch under one or more contributor
    }
     */
 *
     * @param buckets the buckets to finish building
        AggregatorFactories factories,
     * Hook to allow taking an action before building buckets.
     */
     * Most aggregations should probably use something like
        docCountProvider.setLeafReaderContext(ctx);
                            + "]"
     */
        try (LongArray oldDocCounts = docCounts) {
    /**
     * @deprecated use {@link mergeBuckets(long, LongUnaryOperator)}
import org.opensearch.search.internal.SearchContext;
                        bucketDocCount(bucketOrdsToCollect[bucketOrdIdx]),
                long destinationOrdinal = mergeMap.applyAsLong(i);
     * merge the actual ordinals and doc ID deltas.
            }
     * @opensearch.internal
        if (bucketOrd < 0) {
import java.util.function.ToLongFunction;
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
     *  If a bucket's ordinal is mapped to -1 then the bucket is removed entirely.
                // Skip any in the map which have been "removed", signified with -1
        grow(bucketOrd + 1);
            }
                    return aggregations.length;
 *
     * @return the sub-aggregation results in the same order as the provided
        }
    ) throws IOException {
    @Override
    }
                "Can't collect more than [" + Integer.MAX_VALUE + "] buckets but attempted [" + totalOrdsToCollect + "]"
 * KIND, either express or implied.  See the License for the
                + "\") or change it to \"doc_count\" (a la \""
            // the execution if we are running out. To achieve that we are passing 0 as a bucket count.
            aggregations[i] = subAggregators[i].buildAggregations(bucketOrdsToCollect);
            bucketOrd = -1 - bucketOrd;
            );
            long ord = owningBucketOrd * bucketsPerOwningBucketOrd;
            }
    public final void collectExistingBucket(LeafBucketCollector subCollector, int doc, long bucketOrd) throws IOException {
     * {@code long} keyed buckets.
     * <p>
/*
                bucketOrdsToCollect[bucketOrdIdx++] = ord++;
        super(name, factories, context, parent, bucketCardinality, metadata);
        // Set LeafReaderContext to the doc_count provider
    }
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
    ) throws IOException {
     */
public abstract class BucketsAggregator extends AggregatorBase {
        docCounts.increment(bucketOrd, inc);
import org.opensearch.search.aggregations.AggregationExecutionException;
                    return aggregations[index][thisOrd];
    }
        if (context.aggregations() != null) {
        B build(int offsetInOwningOrd, long docCount, InternalAggregations subAggregationResults);
                    throw new AggregationExecutionException(
 * @opensearch.internal
        }
    protected void beforeBuildingBuckets(long[] ordsToCollect) throws IOException {}
        InternalAggregations[] results = buildSubAggsForBuckets(bucketOrdsToCollect);
     */
    /**
            while (ordsEnum.next()) {
     * Utility method to return the number of documents that fell in the given bucket (identified by the bucket ordinal)
            // For example, if there is a long terms agg on 3 terms 1,2,3 with a sub filter aggregator and if no document with 3 as a value
 */
import org.opensearch.search.aggregations.InternalAggregations;
 * Modifications Copyright OpenSearch Contributors. See
     * Utility method to increment the doc counts of the given bucket (identified by the bucket ordinal)
    }
                }
     * A bucket builder for a fixed count
        long docCount = docCountProvider.getDocCount(doc);
     * Same as {@link #collectBucket(LeafBucketCollector, int, long)}, but doesn't check if the docCounts needs to be re-sized.
 * this work for additional information regarding copyright
        mergeBuckets(newNumBuckets, bucket -> mergeMap[Math.toIntExact(bucket)]);
            LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
            return 0;
import java.util.function.BiConsumer;
        if (this instanceof SingleBucketAggregator) {
                @Override
        throws IOException {
import java.util.function.LongUnaryOperator;
        Aggregator parent,
 *
            return (lhs, rhs) -> order.reverseMul() * Long.compare(bucketDocCount(lhs), bucketDocCount(rhs));
     *
    protected final DocCountProvider docCountProvider;
        checkCancelled();
 * Base class to collect all docs into buckets
            while (ordsEnum.next()) {
        docCounts = bigArrays.grow(docCounts, bucketOrd + 1);
    @Override
            throw new AggregationExecutionException(
        b = 0;
    protected final InternalAggregations[] buildSubAggsForBuckets(long[] bucketOrdsToCollect) throws IOException {
        SearchContext context,
        checkCancelled();
import java.util.ArrayList;
     * @param owningBucketOrds owning bucket ordinals for which to build the results
            return super.bucketComparator(key, order);
                + name()
                }
            }
        }
            multiBucketConsumer = context.aggregations().multiBucketConsumer();
     * ordinals and doc ID deltas.
     *
 */
        Function<List<B>, InternalAggregation> resultBuilder
        return result;
        super.preGetSubLeafCollectors(ctx);
     *
                + "Either drop the key (a la \""
        }
        for (B[] bucketsForOneResult : buckets) {
        for (int ord = 0; ord < bucketOrdsToCollect.length; ord++) {
    /**
        for (int i = 0; i < subAggregators.length; i++) {
                @Override
        int b = 0;
         */
     * @opensearch.internal
        if (docCounts.increment(bucketOrd, docCount) == docCount) {
                    docCounts.increment(destinationOrdinal, docCount);
        if (docCounts.increment(bucketOrd, docCount) == docCount) {
            totalBucketOrdsToCollect += bucketsForOneResult.length;
    }
                    bucketBuilder.build(
import org.opensearch.search.aggregations.support.AggregationPath;
    @FunctionalInterface
        }
        for (B[] bucketsForOneResult : buckets) {
    public final long maxBucketOrd() {
            }
        /*
        }
                        "Iteration order of ["
        return results;
        InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
import org.opensearch.search.aggregations.AggregatorFactories;
            // We calculate the final number of buckets only during the reduce phase. But we still need to
    }
        if (key == null || "doc_count".equals(key)) {
        long[] bucketOrdsToCollect = new long[totalBuckets];
         * `consumeBucketsAndMaybeBreak(owningBucketOrds.length)`
    protected interface BucketBuilderForVariable<B> {
                        subAggregationResults[bucketOrdIdx++]
            docCounts = bigArrays.newLongArray(newNumBuckets, true);
     */
            result[ord] = InternalAggregations.from(new AbstractList<InternalAggregation>() {
     * or {@link #buildAggregationsForVariableBuckets(long[], LongKeyedBucketOrds, BucketBuilderForVariable, ResultBuilderForVariable)}
     */
                            + ordsEnum.ord()
        long[] owningBucketOrds,
import org.apache.lucene.index.LeafReaderContext;
 * license agreements. See the NOTICE file distributed with
    public void doReset() {
    }
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.util.BigArrays;
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
            });
     * or {@link #buildAggregationsForFixedBucketCount(long[], int, BucketBuilderForFixedCount, Function)}
     * @opensearch.internal
 * specific language governing permissions and limitations
     * After collecting doc count, invoke collectStarTreeEntry() for sub-collectors to update their relevant buckets
 * compatible open source license.
        int bucketsPerOwningBucketOrd,
            for (int offsetInOwningOrd = 0; offsetInOwningOrd < bucketsPerOwningBucketOrd; offsetInOwningOrd++) {
            return docCounts.get(bucketOrd);
            for (int b = 0; b < buckets[r].length; b++) {
     * @param bucketOrds hash of values to the bucket ordinal
        }
                }
    public static boolean descendsFromGlobalAggregator(Aggregator parent) {
    @FunctionalInterface
     * Build aggregation results for an aggregator with a varying number of
            List<B> buckets = new ArrayList<>((int) bucketOrds.size());
        BucketBuilderForVariable<B> bucketBuilder,
}
 * under the License.
            parent = parent.parent();
    /**
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
     * @param <B> the type of the bucket
                return true;
    }
     *
            for (long i = 0; i < oldDocCounts.size(); i++) {
        } else {
        CardinalityUpperBound bucketCardinality,
        for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
    }
    protected void preGetSubLeafCollectors(LeafReaderContext ctx) throws IOException {
        ResultBuilderForVariable<B> resultBuilder
            super.close();
    /**
     * A bucket builder for a variable
                + ".doc_count\") or \"key\"."
     * instead of calling this directly.
                buckets.add(
    public final void collectStarTreeBucket(StarTreeBucketCollector collector, long docCount, long bucketOrd, int entryBit)
     * or {@link #buildAggregationsForSingleBucket(long[], SingleBucketResultBuilder)}
    /**
        }
    ) throws IOException {
    }
        B[][] buckets,
        BucketBuilderForFixedCount<B> bucketBuilder,
    protected interface ResultBuilderForVariable<B> {
            // matches the filter, then the filter will never collect bucket ord 3. However, the long terms agg will call
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
     * Build the sub aggregation results for a list of buckets and set them on
        int bucketOrdIdx = 0;
     * A result builder for a bucket variable
            }
    public final void mergeBuckets(long[] mergeMap, long newNumBuckets) {
        }
    /**
                long docCount = oldDocCounts.get(i);
        if (false == this instanceof SingleBucketAggregator) {
    @Override
            "Ordering on a single-bucket aggregation can only be done on its doc_count. "
                    );
                public InternalAggregation get(int index) {
    /**
    public final void grow(long maxBucketOrd) {
     * @param owningBucketOrds owning bucket ordinals for which to build the results
     * @param bucketsPerOwningBucketOrd how many buckets there are per ord
    private final BigArrays bigArrays;
            multiBucketConsumer.accept(0);
