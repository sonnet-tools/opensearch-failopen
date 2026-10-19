            }
 * compatible open source license.
            assert owningBucketOrd == 0;
    }
        @Override
                Arrays.asList(topBuckets),
         * If {@link BucketCountThresholds#getMinDocCount()} is not 0 then
        long globalOrd;
        void forEach(long owningBucketOrd, BucketInfoConsumer consumer) throws IOException {
        super(name, factories, context, parent, order, format, bucketCountThresholds, collectionMode, showTermDocCountError, metadata);
        }
            collectionStrategy.globalOrdsReady(globalOrds);
        abstract R buildResult(long owningBucketOrd, long otherDocCount, B[] topBuckets);
            } else {
                for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            } else {
                    long globalOrd;
                            rangeSTGlobalOrds.collectGlobalOrdsForStarTree(owningBucketOrd, starTreeEntry, ord, this, metricValue);
                    int count = globalOrds.docValueCount();
         */
     */
            return new StringTerms.Bucket[size][];
    /**
                        for (int i = 0; i < size; i++) {
                        } else {
                    assert owningBucketOrd == 0;
            if (acceptedGlobalOrdinals.test(globalOrd)) {
    }
                                bucketsForOrdArr[tot[0]++] = spare;
                    if (bucketOrd < 0) {
        abstract long getOrAddBucketOrd(long owningBucketOrd, long globalOrd) throws IOException;
                            }
        StringTerms.Bucket convertTempBucketToRealBucket(OrdBucket temp) throws IOException {
            };
                        ArrayUtil.select(
        Terms segmentTerms = ctx.reader().terms(this.fieldName);
         * Unlike {@linkplain BytesRef#deepCopyOf(BytesRef)} its designed to
                reduceOrder = order;
                // Recreate DocValues as needed for concurrent segment search
                    } else {
                            topBucketsPerOwningOrd[ordIdx][i] = convertTempBucketToRealBucket((TB) bucketsForOrdArr[i]);
                @Override
    public InternalAggregation buildEmptyAggregation() {
        boolean remapGlobalOrds,
            boolean remapGlobalOrds,
                        }
                spare.subsetDf = docCount;
     * Predicate used for {@link #acceptedGlobalOrdinals} if there is no filter.
                            topBucketsPerOwningOrd[ordIdx][i] = convertTempBucketToRealBucket((TB) bucketsForOrdArr[i]);
            });
     * global ordinal into bucket ordinals. This uses more memory than
        }
        if (weight == null) {
        @Override
                        // All buckets fit within the required size, no selection needed
        /**
                mapSegmentCountsToGlobalCounts(mapping);
 * under the License.
        SignificantStringTerms.Bucket> {
        }
                if (localBucketCountThresholds.getMinDocCount() == 0) {
         */
                    }
            StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, supportedStarTree, null);
                /*
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.search.aggregations.CardinalityUpperBound;
        void globalOrdsReady(SortedSetDocValues globalOrds) {
            }
                // weight.count(ctx) == ctx.reader().maxDoc() implies there are no deleted documents and
        }
                            ((b1, b2) -> partiallyBuiltBucketComparator.compare((InternalTerms.Bucket<?>) b1, (InternalTerms.Bucket<?>) b2))
        private LongArray segmentDocCounts;
            this.significanceHeuristic = significanceHeuristic;
        abstract long globalOrdToBucketOrd(long owningBucketOrd, long globalOrd);
        private LongArray subsetSizes = context.bigArrays().newLongArray(1, true);
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
                while (ordsEnum.next()) {
         * output to help with debugging.
        return false;
            long[] otherDocCount = new long[owningBucketOrds.length];
        @Override
        } else {
    protected boolean tryStarTreePrecompute(LeafReaderContext ctx) throws IOException {
        }
 * @opensearch.internal
            result.docCountError = 0;
public class GlobalOrdinalsStringTermsAggregator extends AbstractStringTermsAggregator implements StarTreePreComputeCollector {
            assert owningBucketOrd == 0;
        @Override
            return new SignificantStringTerms(
import java.util.function.LongPredicate;
        if (dvs.get() == null) {
        final IndexReader reader = context.searcher().getIndexReader();
                    final int finalOrdIdx = ordIdx;
 * the Apache License, Version 2.0 (the "License"); you may
                        int ord = singleValues.ordValue();
import org.apache.lucene.index.IndexReader;
     * to collect the global ordinals by calling
        SignificantTermsResults(
                 * that are for this shard only. Back at the central reducer these
                    results[ordIdx] = buildNoValuesResult(owningBucketOrds[ordIdx]);
                spare.docCount = docCount;
    }
                // partiallyBuiltBucketComparator is null for significantTerm Aggregations use case and the way buckets sorted in the
                BucketSelectionStrategy strategy = BucketSelectionStrategy.determine(
                    /*
            this.collectionStrategy = cardinality.map(estimate -> {
import org.apache.lucene.search.Weight;
                    super.collect(stream, owningBucketOrd);
         * Build a {@link PriorityQueue} to sort the buckets. After we've
            return new BucketSignificancePriorityQueue<>(size);
        // and increment bucket count when segment ordinal is contained in global ordinals.
                        );
        }
                    subsetSizes = context.bigArrays().grow(subsetSizes, owningBucketOrd + 1);
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                !context.searcher().getIndexReader().leaves().isEmpty()
            @Override
                        // order in priority queue ordered
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
            bucketOrds.close();
        boolean showTermDocCountError,
        @Override
        this.cardinalityUpperBound = cardinality;
        abstract String describe();
     * @opensearch.internal
import org.opensearch.search.aggregations.InternalOrder;
        @Override
}
            return new StringTerms.Bucket[size];
        }
            @Override
                }
        }
        /**
        collectionStrategy.globalOrdsReady(globalOrds);
         * bytes from a mutable {@link BytesRef} into
                        // Get the top buckets and update the otherDocCount
         * Collect debug information to add to the profiling results. This will
                 * properties will be updated with global stats.
                @Override
    }
                        long docCount = docCountProvider.getDocCount(doc);
import java.io.IOException;
            }
            add.accept("total_buckets", bucketOrds.size());
                    );
                @Override
        }
         * This is fairly similar in spirit to
        }
                } else {
     * Builds results for the {@code significant_terms} aggregation.
        /**
         */
     * <p>
    }
        SignificantStringTerms buildNoValuesResult(long owningBucketOrdinal) {
import org.apache.lucene.index.LeafReaderContext;
                spare.supersetSize = supersetSize;
            );
        StringTerms buildResult(long owningBucketOrd, long otherDocCount, StringTerms.Bucket[] topBuckets) {
            Function<GlobalOrdinalsStringTermsAggregator, ResultStrategy<?, ?, ?>> resultStrategy,
                        continue;
                    super.collectRange(min, max);
                bucketOrd = -1 - bucketOrd;
                name,
        @Override
import org.apache.lucene.search.DocIdStream;
            @Override
        /**
        @Override
                    : DocValues.emptySortedSet()
        private InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
     */
        return StarTreeQueryHelper.collectDimensionFilters(new MatchAllFilter(fieldName), subAggregators);
        final SortedSetDocValues values = !reader.leaves().isEmpty()
     * {@linkplain CollectionStrategy} that just uses the global ordinal as the
                }
                0,
                    order,
        add.accept("segments_with_multi_valued_ords", segmentsWithMultiValuedOrds);
        SignificantStringTerms buildResult(long owningBucketOrd, long otherDocCount, SignificantStringTerms.Bucket[] topBuckets) {
        long globalOrdToBucketOrd(long owningBucketOrd, long globalOrd) {
        add.accept("has_filter", acceptedGlobalOrdinals != ALWAYS_TRUE);
            return globalOrdToBucketOrd(owningBucketOrd, globalOrd);
                        collectionStrategy.collectGlobalOrd(owningBucketOrd, doc, globalOrd, sub);
                    collectionStrategy.forEach(owningBucketOrds[ordIdx], new BucketInfoConsumer() {
        @Override
            // if the owningBucketOrd is not in the array that means the bucket is empty so the size has to be 0
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
            int starTreeEntry,
            }
                );
            return new SignificantStringTerms.Bucket(new BytesRef(), 0, 0, 0, 0, null, format, 0);
    class DenseGlobalOrds extends CollectionStrategy {
                    @Override
    protected CardinalityUpperBound cardinalityUpperBound;
            String name,
                    super.collectRange(min, max);
        }
import org.apache.lucene.util.BytesRef;
    }
                bucketCountThresholds
        }
 * The OpenSearch Contributors require contributions made to
        @Override
import java.util.Map;
                            collectStarTreeBucket(this, metricValue, bucketOrd, starTreeEntry);
        @Override
                    public void collect(int doc, long owningBucketOrd) throws IOException {
import java.util.Arrays;
            }
     * for each match.This is beneficial for low cardinality fields, because
            CardinalityUpperBound cardinality
        @Override
        @Override
            long bucketOrd = bucketOrds.add(owningBucketOrd, globalOrd);
                }
        super.collectDebugInfo(add);
                        docCount = bucketDocCount(bucketOrd);
             * common and marginally faster.
                format,
        BucketOrder order,
        @Override
        String describe() {
    interface BucketUpdater<TB extends InternalMultiBucketAggregation.InternalBucket> {
     * If DocValues have not been initialized yet for reduce phase, create and set them.
 * Modifications Copyright OpenSearch Contributors. See
                if (estimate > 1) {
        }
                return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, globalOrds) {
        private void oversizedCopy(BytesRef from, BytesRef to) {
        @Override
        }
        public Object getKey() {
            });
         */
            if (to.bytes.length < from.length) {
                factories,
                collectionMode,
                oversizedCopy(values.lookupOrd(globalOrd), spare.termBytes);
                    @Override
            buildSubAggs(topBucketsPerOwningOrd);
            for (long globalOrd = 0; globalOrd < valueCount; globalOrd++) {
            long subsetSize = subsetSize(owningBucketOrd);
            return false;
                    super.collect(stream, owningBucketOrd);
        private RemapGlobalOrds(CardinalityUpperBound cardinality) {
    static class OrdBucket extends InternalTerms.Bucket<OrdBucket> {
                metadata(),
        abstract R buildEmptyResult();
                        TB spare = null;
        /**
                }
        LongUnaryOperator globalOperator = valuesSource.globalOrdinalsMapping(ctx);
                spare.updateScore(significanceHeuristic);
     */
        this.valuesSource = valuesSource;
     * <p>
                    }
                }
            return buildEmptyTermsAggregation();
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                }
        }
            }
        @Override
                public void collectRange(int min, int max) throws IOException {
        @Override
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
 * software distributed under the License is distributed on an
                // We use set(...) here, because we need to reset the slow to 0.
        /**
                    }
import org.opensearch.search.startree.filter.DimensionFilter;
                     * Use `add` instead of `find` here to assign an ordinal
            if (isKeyOrder(order) == false) {
            if (mapping != null) {
                    }
         */
            if (weight.count(ctx) == 0) {
        }
                    }
                    topBucketsPerOwningOrd[ordIdx] = buildBuckets(ordered.size());
                    });
        }
                public void collectRange(int min, int max) throws IOException {
                public void collect(int doc, long owningBucketOrd) throws IOException {
        protected void writeTermTo(StreamOutput out) throws IOException {
                    if (false == acceptedGlobalOrdinals.test(ordsEnum.value())) {
        if (tryStarTreePrecompute(ctx) == true) {
            return buildEmptyResult();
    }
        protected void doClose() {
                }
        public void close() {
                format,
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
        /**
        CardinalityUpperBound cardinality,
        }
        @Override
            // Recreate DocValues as needed for concurrent segment search
            SortedSetDocValues values = getDocValues();
                    partiallyBuiltBucketComparator,
                return new DenseGlobalOrds();
                 * common and marginally faster.
     @throws IOException If an I/O error occurs during reading
         */
        @Override
     * Builds results for the standard {@code terms} aggregation.
        void collectGlobalOrd(long owningBucketOrd, int doc, long globalOrd, LeafBucketCollector sub) throws IOException {
    private String resultSelectionStrategy;
        }
 * this work for additional information regarding copyright
            for (long i = 1; i < segmentDocCounts.size(); i++) {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        }
                        }
        this.acceptedGlobalOrdinals = includeExclude == null ? ALWAYS_TRUE : includeExclude.acceptedGlobalOrdinals(values)::get;
            assert sub == LeafBucketCollector.NO_OP_COLLECTOR;
        /**
                        bucketOrd = -1 - bucketOrd;
            return "remapStarTree";
                return true;
    }
            return "remap";
            long globalOrd = globalOrdsMapping.applyAsLong(segmentOrd);
        @Override
            super(
            segmentDocCounts = context.bigArrays().grow(segmentDocCounts, 1 + segmentOrds.getValueCount());
            long docCount
            final SortedSetDocValues segmentOrds = this.getGlobalOrds(ctx);
        }
        }
        @Override
                }
                        continue;
                    BucketUpdater<TB> updater = bucketUpdater(owningBucketOrds[ordIdx]);
            collectionStrategy = new RemapGlobalOrdsStarTree(this.cardinalityUpperBound);
     * This is only supported for the standard {@code terms} aggregation and
        assert segmentTermsEnum.next() == null : "Segment terms enum must be fully exhausted";
    static class LowCardinality extends GlobalOrdinalsStringTermsAggregator {
                for (long globalOrd = 0; globalOrd < valueCount; globalOrd++) {
        }
                parent,
        @Override
        @Override
    /**
    private Weight weight;
         */
        PriorityQueue<OrdBucket> buildPriorityQueue(int size) {
        BucketUpdater<OrdBucket> bucketUpdater(long owningBucketOrd) throws IOException {
        @Override
                    while ((count-- > 0) && (globalOrd = globalOrds.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {
        private void mapSegmentCountsToGlobalCounts(LongUnaryOperator mapping) throws IOException {
         * the {@link BucketCountThresholds}. In particular,
     */
     * it can reduce the amount of look-ups significantly.
                public void collectRange(int min, int max) throws IOException {
            && this.resultStrategy instanceof StandardTermsResults
         * Called once per unique document, global ordinal combination to
         */
            SortedSetDocValues globalOrds = valuesSource.globalOrdinalsValues(ctx);
                            otherDocCount[finalOrdIdx] += docCount;
        @Override
                    collectionStrategy.forEach(owningBucketOrds[ordIdx], new BucketInfoConsumer() {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
                // No documents matches top level query on this segment, we can skip the segment entirely
    protected CollectionStrategy collectionStrategy;
     */
            return valuesSource.ordinalsValues(ctx);
        }
        public void close() {}
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);
        }
                        // sorted buckets not needed as they will be sorted by key in buildResult() which is different from
                valuesSource,
        }
 */
                resultStrategy,
                    }
            };
            Aggregator parent,
/*
                    if (false == globalOrds.advanceExact(doc)) {
                    public void collectRange(int min, int max) throws IOException {
                    consumer.accept(globalOrd, globalOrd, docCount);
    abstract class ResultStrategy<
        }
        abstract R buildNoValuesResult(long owningBucketOrdinal);
 * KIND, either express or implied.  See the License for the
        @Override
    /**
        protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
        void collectDebugInfo(BiConsumer<String, Object> add) {}
     * less when collecting only a few.
                }
            System.arraycopy(from.bytes, from.offset, to.bytes, 0, from.length);
         * Turn the buckets into an aggregation result.
        }
            this.collectionStrategy = new RemapGlobalOrds(cardinality);
import joptsimple.internal.Strings;
        protected void doPostCollection() throws IOException {
            SearchContext context,
                segmentsWithSingleValuedOrds++;
        }
                            topBucketsPerOwningOrd[ordIdx][i] = convertTempBucketToRealBucket(ordered.pop());
                }
     * Strategy for building results.
                        return;
package org.opensearch.search.aggregations.bucket.terms;
                    }
     * Strategy for collecting global ordinals.
        @Override
                public void collect(int doc, long owningBucketOrd) throws IOException {
                long ord = i - 1; // remember we do +1 when counting
            return buildEmptySignificantTermsAggregation(subsetSizes.get(owningBucketOrdinal), significanceHeuristic);
         * Convert a global ordinal into a bucket ordinal.
                significanceHeuristic,
                for (Aggregator aggregator : subAggregators) {
    }
                subsetSize(owningBucketOrd),
                    super.collectRange(min, max);
                    long bucketOrd = bucketOrds.add(owningBucketOrd, globalOrd);
                     * sub-aggregations without trouble even though we haven't
            }
         * information that this result type may need.
         * @param doc the doc id in to collect
 * license agreements. See the NOTICE file distributed with
            }
    SortedSetDocValues getGlobalOrds(LeafReaderContext ctx) throws IOException {
            : null;
         * <strong>something</strong> that won't mutate out from under you.
        public void close() {
        Releasables.close(resultStrategy, collectionStrategy);
         * <p>
        }
                }
                bucketCountThresholds,
    String descriptCollectionStrategy() {
                name,
            parent == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
            super(0, null, showDocCountError, 0, format);
                }
        void globalOrdsReady(SortedSetDocValues globalOrds) {}
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                incrementBucketDocCount(collectionStrategy.globalOrdToBucketOrd(0, globalOrd), inc);
            throw new UnsupportedOperationException();
                super.collectRange(min, max);
        });
                bucketCountThresholds
        SortedSetDocValues getGlobalOrds(LeafReaderContext ctx) throws IOException {
    /**
import org.apache.lucene.util.ArrayUtil;
                // priority queue is based on the significanceScore
                metadata
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
        }
        public Number getKeyAsNumber() {
         * Add a global ordinal if it hasn't been seen before.
        void updateBucket(TB spare, long globalOrd, long bucketOrd, long docCount) throws IOException;
         * Called when the global ordinals are ready.
        SortedSetDocValues globalOrds = this.getGlobalOrds(ctx);
                bucketCountThresholds.getShardSize(),
                Arrays.asList(topBuckets),
                                    spare = buildEmptyTemporaryBucket();
                                if (spare == null) {
import java.util.function.LongUnaryOperator;
        abstract B convertTempBucketToRealBucket(TB temp) throws IOException;
                        resultSelectionStrategy = "select_all";
        }
     @return A LeafBucketCollector implementation with collection termination, since collection is complete
            long globalOrd,
                        Iterator<TB> itr = ordered.iterator();
        }
        protected final LongKeyedBucketOrds bucketOrds;
         * there aren't any values for the field on this shard.
                        continue;
                    ctx,
    interface BucketInfoConsumer {
         */
                    consumer.accept(globalOrd, bucketOrd, docCount);
             * Optimize when there isn't a filter because that is very
            dvs.set(
        this.resultSelectionStrategy = Strings.EMPTY;
        if (termCount == -1 || termCount > context.termsAggregationMaxPrecomputeCardinality()) {
            return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, globalOrds) {
        @Override
                    super.collect(stream, owningBucketOrd);
                results[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCount[ordIdx], topBucketsPerOwningOrd[ordIdx]);
                            long bucketOrd = collectionStrategy.getOrAddBucketOrd(owningBucketOrd, ord);
        void forEach(long owningBucketOrd, BucketInfoConsumer consumer) throws IOException {
         * Build an "empty" result. Only called if there isn't any data on this
    }
                @Override
                }
                }
        SignificantStringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
        long termCount = segmentTerms.size();
     */
         * Build an array of buckets for a particular ordinal to collect the
            );
         * Wrap the "standard" numeric terms collector to collect any more
        }
    }
         * if the {@link BucketCountThresholds#getMinDocCount()} is 0 then
                 * Optimize when there isn't a filter because that is very
        @Override
        private LongUnaryOperator mapping;
            this.segmentDocCounts = context.bigArrays().newLongArray(1, true);
        SignificantStringTerms,
        );
        }
            }
        public int compareKey(OrdBucket other) {
                    context.bucketSelectionStrategyFactor()
    }
    }
            BucketOrder order,
                    }
                        assert owningBucketOrd == 0;
         */
            if (bucketCountThresholds.getMinDocCount() == 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    long dimensionValue = valuesIterator.value();
        void collectDebugInfo(BiConsumer<String, Object> add) {
         */
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
    }
        CompositeIndexFieldInfo supportedStarTree = StarTreeQueryHelper.getSupportedStarTree(this.context.getQueryShardContext());
                public void collect(int doc, long owningBucketOrd) throws IOException {
                    @Override
                remapGlobalOrds,
    public List<DimensionFilter> getDimensionFilters() {
            return buildEmptySignificantTermsAggregation(0, significanceHeuristic);
         * oversizing the destination bytes helps to keep from allocating
            );
         * Copies the bytes from {@code from} into {@code to}, oversizing
            return new LeafBucketCollectorBase(primary, null) {
         * collected all of the buckets we'll collect all entries in the queue.
            BucketCountThresholds bucketCountThresholds,
                }
        String describe() {
import org.opensearch.common.lease.Releasables;
        ) {
        abstract void forEach(long owningBucketOrd, BucketInfoConsumer consumer) throws IOException;
     * bucket ordinal.
        SortedNumericStarTreeValuesIterator docCountsIterator = StarTreeQueryHelper.getDocCountsIterator(starTreeValues, starTree);
        add.accept("result_strategy", resultStrategy.describe());
import org.opensearch.search.aggregations.AggregatorFactories;
        /**
            return true;
        NumericDocValues docCountValues = DocValues.getNumeric(ctx.reader(), DocCountFieldMapper.NAME);
                long globalOrd;
                        topBucketsPerOwningOrd[ordIdx] = buildBuckets(size);
        /**
        handle global ordinal remapping. This check ensures we don't reinitialize the
            InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
 * this file be licensed under the Apache-2.0 license or a
/*
        for (long segmentOrd = 0; segmentOrd < termCount; segmentOrd++) {
                spare.subsetSize = subsetSize;
    /**
        }
    protected final ValuesSource.Bytes.WithOrdinals valuesSource;
        SearchContext context,
                format,
            return bucketOrds.find(owningBucketOrd, globalOrd);
            return (spare, globalOrd, bucketOrd, docCount) -> {
        abstract void globalOrdsReady(SortedSetDocValues globalOrds);
        if (remapGlobalOrds) {
                    super.collect(stream, owningBucketOrd);
                    if (false == acceptedGlobalOrdinals.test(globalOrd)) {
            StarTreeQueryHelper.preComputeBucketsWithStarTree(starTreeBucketCollector);
import org.opensearch.search.aggregations.BucketOrder;
                checkCancelled();
     Read doc frequencies directly from indexed terms in the segment to skip iterating through individual documents
                    public void collectRange(int min, int max) throws IOException {
            segmentTermsEnum.next();
    /**
                    BucketUpdater<TB> updater = bucketUpdater(owningBucketOrds[ordIdx]);
 */
            if (singleValues != null) {
                // segmentDocCounts get reused over the segments and otherwise counts would be too high.
                        for (int i = 0; i < tot[0]; i++) {
            return results;
                    Object[] bucketsForOrdArr = new Object[(int) valueCount];
                    subsetSizes.increment(owningBucketOrd, 1);
        }
         * Build the sub-aggregations into the buckets. This will usually
                    }
        if (docCountValues.nextDoc() != NO_MORE_DOCS) {
            return (spare, globalOrd, bucketOrd, docCount) -> {
 * SPDX-License-Identifier: Apache-2.0
        }
            public void collectRange(int min, int max) throws IOException {
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
                showTermDocCountError,
            assert factories == null || factories.countAggregators() == 0;
                    // if minDocCount == 0 then we can end up with more buckets then maxBucketOrd() returns
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
     @param ordCountConsumer A consumer to accept collected term frequencies
        BucketUpdater<SignificantStringTerms.Bucket> bucketUpdater(long owningBucketOrd) throws IOException {
                return false;
        private final BackgroundFrequencyForBytes backgroundFrequencies;
                 */
         */
        private RemapGlobalOrdsStarTree(CardinalityUpperBound cardinality) {
         * Convert the global ordinal into a bucket ordinal.
            DocValueFormat format,
    class StandardTermsResults extends ResultStrategy<StringTerms, StringTerms.Bucket, OrdBucket> {
                    }
        SortedSetStarTreeValuesIterator valuesIterator = (SortedSetStarTreeValuesIterator) starTreeValues.getDimensionValuesIterator(
                // processing each owning bucket
        /**
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
        DocValueFormat format,
         * shard.
                    if (false == segmentOrds.advanceExact(doc)) {
            fieldName
     * {@link CollectionStrategy#collectGlobalOrd} for each global ordinal
            });
        ValuesSource.Bytes.WithOrdinals valuesSource,
        this.resultStrategy = resultStrategy.apply(this); // ResultStrategy needs a reference to the Aggregator to do its job.
                 */
        }
         */
        return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, globalOrds) {
        }
    /**
            } else {
         * they'll skip all global ords that weren't collected.
        }
            return true;
            SignificanceHeuristic significanceHeuristic,
            return false;
         * only be called if the aggregation is being profiled.
            };
                     * settings minDocCount == 0 is wasteful in general.....
         * @param globalOrd the global ordinal to collect
            boolean showTermDocCountError,
                return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, segmentOrds) {
        ) {
import org.opensearch.search.aggregations.InternalAggregation;
                if (false == acceptedGlobalOrdinals.test(globalOrd)) {
        }
        }
        }
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
                @Override
            to.length = from.length;
import org.opensearch.search.DocValueFormat;
    @Override
                if (false == globalOrds.advanceExact(doc)) {
                ctx,
         * this bucket ordinal.
import org.opensearch.search.aggregations.support.ValuesSource;
                order,
            }
                    return;
        public void close() {}
                }
import org.opensearch.core.xcontent.XContentBuilder;
         * collect the bucket.
        String describe() {
            backgroundFrequencies = significanceLookup.bytesLookup(context.bigArrays(), cardinality);
                SortedSetDocValues values = getDocValues();
    @Override
     * Variant of {@link GlobalOrdinalsStringTermsAggregator} that
            return new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);
        }
        @Override
                    (globalOrd, docCount) -> incrementBucketDocCount(collectionStrategy.globalOrdToBucketOrd(0, globalOrd), docCount)
                if (strategy.equals(BucketSelectionStrategy.PRIORITY_QUEUE)) {
        }
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
import org.opensearch.common.util.LongHash;
        abstract B[][] buildTopBucketsPerOrd(int size);
                CardinalityUpperBound.ONE,
        void collectGlobalOrd(long owningBucketOrd, int doc, long globalOrd, LeafBucketCollector sub) throws IOException {
        @Override
    @Override
                    }
import org.opensearch.core.common.io.stream.StreamOutput;
                }
         */
    /**
    private final long valueCount;
         * Build an "empty" result for a particular bucket ordinal. Called when
        CompositeIndexFieldInfo starTree,
                metadata(),
        final TermsEnum segmentTermsEnum = segmentTerms.iterator();
                        TB spare = null;
                            topBucketsPerOwningOrd[ordIdx][i] = convertTempBucketToRealBucket(itr.next());
                            bucketsForOrdArr,
        }
                    // for each provides the bucket ord and key value for the owning bucket
            SubAggCollectionMode collectionMode,
            throw new UnsupportedOperationException();
         */
import org.apache.lucene.index.NumericDocValues;
                    }
            return new SignificantStringTerms.Bucket[size][];
        long getOrAddBucketOrd(long owningBucketOrd, long globalOrd) {
                    });
                int count = globalOrds.docValueCount();
            return temp;
                            return;
 * ownership. Elasticsearch licenses this file to you under
    }
        abstract BucketUpdater<TB> bucketUpdater(long owningBucketOrd) throws IOException;
                    continue;
                mapping = null;
import org.apache.lucene.util.PriorityQueue;
                final int size;
                Arrays.sort(topBuckets, reduceOrder.comparator());
            long bucketOrd = bucketOrds.add(owningBucketOrd, globalOrd);
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        SignificantStringTerms.Bucket[] buildBuckets(int size) {
         * Build an array to hold the "top" buckets for each ordinal.
                            otherDocCount[ordIdx] -= topBucketsPerOwningOrd[ordIdx][i].getDocCount();
    boolean tryCollectFromTermFrequencies(LeafReaderContext ctx, BiConsumer<Long, Integer> ordCountConsumer) throws IOException {
         * @param sub the sub-aggregators that will collect the bucket data
                context,
            }
        if (parent != null && !(collectionStrategy instanceof RemapGlobalOrdsStarTree)) {
        }
        long globalOrdToBucketOrd(long owningBucketOrd, long globalOrd) {
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
        if (acceptedGlobalOrdinals == ALWAYS_TRUE) {
        @Override
                    if (isKeyOrder(order)) {
    @Override
         */
         * delegate to {@link #buildSubAggsForAllBuckets}.
import org.apache.lucene.index.SortedSetDocValues;
        public String getKeyAsString() {
                        super.collect(stream, owningBucketOrd);
                    } else {
                    this.subCollectors.add(
        }
        /**
import java.util.Iterator;
        } else {
        B extends InternalMultiBucketAggregation.InternalBucket,
                        super.collectRange(min, max);
    protected final ResultStrategy<?, ?, ?> resultStrategy;
                }
         * Iterate all the buckets. Implementations take into account
                        for (int i = ordered.size() - 1; i >= 0; --i) {
        }
                    if (false == acceptedGlobalOrdinals.test(globalOrd)) {
        StringTerms.Bucket[] buildBuckets(int size) {
        @Override
                @Override
                    if (false == singleValues.advanceExact(doc)) {
        }
        @Override
     * once to iterate on the results.
         * Update fields in {@code spare} to reflect information collected for
            buildSubAggsForAllBuckets(topBucketsPreOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
    }
    public GlobalOrdinalsStringTermsAggregator(
     @param ctx The LeafReaderContext to collect terms from
    public void setWeight(Weight weight) {
         * Build an empty temporary bucket.
        }
                InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
        }
 *
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
        return true;
                    size,
            // This segment has at least one document with the _doc_count field.
        SignificantStringTerms.Bucket,
 */
import org.apache.lucene.index.DocValues;
     * This is used internally only, just for compare using global ordinal instead of term bytes in the PQ
            return false;
            starTreeValues,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }
        @Override
import org.opensearch.index.mapper.DocCountFieldMapper;
        SubAggCollectionMode collectionMode,
                                updater.updateBucket(spare, globalOrd, bucketOrd, docCount);
            B[][] topBucketsPerOwningOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
                        }
            Map<String, Object> metadata
                        resultSelectionStrategy = "quick_select";
                    ? valuesSource.globalOrdinalsValues(context.searcher().getIndexReader().leaves().get(0))
                    @Override
                            size,
                        @Override
                    throw new AggregationExecutionException("Dense ords don't know how to collect from many buckets");
    ) throws IOException {
    class SignificantTermsResults extends ResultStrategy<
            });
     *
                }
                                spare = ordered.insertWithOverflow(spare);
         */
    private class RemapGlobalOrds extends CollectionStrategy {
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
            return "significant_terms";
            } else if (weight.count(ctx) != ctx.reader().maxDoc()) {
        /**
            ValuesSource.Bytes.WithOrdinals valuesSource,
        StringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
 * Unless required by applicable law or agreed to in writing,
        return valuesSource.globalOrdinalsValues(ctx);
            if (acceptedGlobalOrdinals == ALWAYS_TRUE) {
                ordCountConsumer.accept(globalOrd, segmentTermsEnum.docFreq());
        abstract String describe();
            mapping = valuesSource.globalOrdinalsMapping(ctx);
    }
    }
                        super.collectRange(min, max);
        IncludeExclude.OrdinalsFilter includeExclude,
        String describe() {
            );
        StringTerms buildNoValuesResult(long owningBucketOrdinal) {
    @Override
            return tryStarTreePrecompute(ctx);
        if (collectionStrategy instanceof DenseGlobalOrds
    @Override
        abstract B[] buildBuckets(int size);
    }
                                }
                        segmentDocCounts.increment(segmentOrd + 1, docCount);
                return results;
                        collectionStrategy.collectGlobalOrd(owningBucketOrd, doc, globalOrd, sub);
    private static final LongPredicate ALWAYS_TRUE = l -> true;
                (ord, docCount) -> incrementBucketDocCount(collectionStrategy.globalOrdToBucketOrd(0, ord), docCount)
                reduceOrder,
        }
                        public void accept(long globalOrd, long bucketOrd, long docCount) throws IOException {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                        }
                if (bucketCountThresholds.getMinDocCount() == 0 || docCount > 0) {
            ? valuesSource.globalOrdinalsValues(context.searcher().getIndexReader().leaves().get(0))
        this.weight = weight;
                } else {
        SignificantStringTerms.Bucket buildEmptyTemporaryBucket() {
        abstract void buildSubAggs(B[][] topBucketsPreOrd) throws IOException;
                });
                showTermDocCountError,
        /**
                spare.bucketOrd = bucketOrd;
        return resultStrategy.buildAggregations(owningBucketOrds);
        StarTreeBucketCollector parent
            @Override
        @Override
        abstract TB buildEmptyTemporaryBucket();
        @Override
                public void collectRange(int min, int max) throws IOException {
                        topBucketsPerOwningOrd[ordIdx] = buildBuckets(tot[0]);
        this.fieldName = (valuesSource instanceof ValuesSource.Bytes.WithOrdinals.FieldData)
 * not use this file except in compliance with the License.
import org.opensearch.search.internal.SearchContext;
                    }
        Function<GlobalOrdinalsStringTermsAggregator, ResultStrategy<?, ?, ?>> resultStrategy,
    @Override
        }
                    }
         * Convert a temporary bucket into a real bucket.
                @Override
            Releasables.close(backgroundFrequencies, subsetSizes);
                     * even if the global ord wasn't found so we can build
        }
                                updater.updateBucket(spare, globalOrd, bucketOrd, docCount);
     */
                }
            assert owningBucketOrd == 0;
import org.apache.lucene.index.TermsEnum;
                null,
        @Override
            final SortedDocValues singleValues = DocValues.unwrapSingleton(segmentOrds);
         * be run over and over again into the same destination. In particular,
        if (supportedStarTree != null) {
    }
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
         * results. The populated list is passed to {@link #buildResult}.
                spare.bucketOrd = bucketOrd;
        /**
            ? ((ValuesSource.Bytes.WithOrdinals.FieldData) valuesSource).getIndexFieldName()
         */
    protected int segmentsWithMultiValuedOrds = 0;
        void collectGlobalOrdsForStarTree(
            result.bucketOrd = temp.bucketOrd;
        // Iterate over the ordinals in the segment, look for matches in the global ordinal,
                /*
        @Override
        }
                    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        return dvs.get();
         * the destination array if the bytes won't fit into the array.
                        return;
            public void setSubCollectors() throws IOException {
                }
                @Override
                        }
        LeafReaderContext ctx,
                    int count = segmentOrds.docValueCount();
                reduceOrder = InternalOrder.key(true);
        };
        private final long supersetSize;
                    } else {
        AggregatorFactories factories,
                    long ord = globalOperator.applyAsLong(dimensionValue);
            return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, globalOrds) {
                LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrd);
            return result;
     * @opensearch.internal
            if (valueCount == 0) { // no context in this reader
        return false;
        @Override
                                spare = buildEmptyTemporaryBucket();
                    public void collect(int doc, long owningBucketOrd) throws IOException {
        SortedDocValues singleValues = DocValues.unwrapSingleton(globalOrds);
                        long metricValue = docCountsIterator.nextValue();
                    int globalOrd = singleValues.ordValue();
                mapSegmentCountsToGlobalCounts(mapping);
            public void collect(int doc, long owningBucketOrd) throws IOException {
            collectionStrategy.close();
    public String getResultSelectionStrategy() {
 *
                    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
         * {{@link #collectGlobalOrd collected}.
         * Short description of the collection mechanism added to the profile
        void buildSubAggs(StringTerms.Bucket[][] topBucketsPerOrd) throws IOException {
                        if (false == singleValues.advanceExact(doc)) {
     *
                supersetSize,
            return globalOrd;
/*
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
import org.opensearch.search.startree.StarTreeQueryHelper;
                public void collect(int doc, long owningBucketOrd) throws IOException {
                    // Get the top buckets
    protected void doClose() {
import org.opensearch.search.aggregations.AggregationExecutionException;
            : DocValues.emptySortedSet();
     * {@link StandardTermsResults}.
        segmentsWithMultiValuedOrds++;
                    long docCount;
        @Override
                    collectionStrategy.collectGlobalOrd(owningBucketOrd, doc, globalOrd, sub);
                collectExistingBucket(sub, doc, bucketOrd);
        private final SignificanceHeuristic significanceHeuristic;
        Map<String, Object> metadata
         * {@link BytesRef#deepCopyOf(BytesRef)} in that it is a way to read
            throw new UnsupportedOperationException();
 *
                        }
        }
                    if (tot[0] > size) {
                        long docCount = docCountProvider.getDocCount(doc);
    protected final String fieldName;
     */
    }
                }
import java.util.List;
        SignificantStringTerms buildEmptyResult() {
            return owningBucketOrd < subsetSizes.size() ? subsetSizes.get(owningBucketOrd) : 0;
                    collectionStrategy.collectGlobalOrd(owningBucketOrd, doc, globalOrd, sub);
            long owningBucketOrd,
        if (singleValues != null) {
            SignificanceLookup significanceLookup,
            return primary;
                        }
        String name,
                    consumer.accept(ordsEnum.value(), ordsEnum.ord(), bucketDocCount(ordsEnum.ord()));
        OrdBucket buildEmptyTemporaryBucket() {
        BucketCountThresholds bucketCountThresholds,
 * An aggregator of string values that relies on global ordinals in order to build buckets.
        @Override
                     */
                @Override
                        }
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        // Segment terms enum should be fully exhausted after iterating over all the ordinals
            }
    protected int segmentsWithSingleValuedOrds = 0;
        StringTerms buildEmptyResult() {
                }
                    long segmentOrd;
         * a bunch of little arrays over and over and over again.
                    }
                    return;
        R extends InternalAggregation,
     * that it hits and then calling {@link CollectionStrategy#forEach}
     */
        @Override
                            }
        collectionStrategy.collectDebugInfo(add);
        @Override
        if (segmentTerms == null) {
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {
        }
                });
     */
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
        ) throws IOException {
             */
            }
                }
            }
        }
        private long subsetSize(long owningBucketOrd) {
        }
                    size = (int) Math.min(maxBucketOrd(), localBucketCountThresholds.getRequiredSize());
                            return;
        return new StarTreeBucketCollector(
            BytesRef term = BytesRef.deepCopyOf(values.lookupOrd(temp.globalOrd));
                    super.collectRange(min, max);
         *
    }
        return resultSelectionStrategy;
     * doesn't support {@code significant_terms} so this forces
        /**
            segmentsWithMultiValuedOrds++;
            return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, segmentOrds) {
 */
        return collectionStrategy.describe();
        TB extends InternalMultiBucketAggregation.InternalBucket> implements Releasable {
            return tryCollectFromTermFrequencies(
        OrdBucket(boolean showDocCountError, DocValueFormat format) {
     */
        this.valueCount = values.getValueCount();
            }
            return bucketOrds.add(owningBucketOrd, globalOrd);
                    if (false == acceptedGlobalOrdinals.test(globalOrd)) {
         */
        abstract void collectGlobalOrd(long owningBucketOrd, int doc, long globalOrd, LeafBucketCollector sub) throws IOException;
    /**
        }
        void buildSubAggs(SignificantStringTerms.Bucket[][] topBucketsPreOrd) throws IOException {
                spare.globalOrd = globalOrd;
        String describe() {
        }
                    valueCount,
/**
            StarTreeBucketCollector collector,
                        super.collect(stream, owningBucketOrd);
                long inc = segmentDocCounts.set(i, 0);
import java.util.function.Function;
                            if (docCount >= localBucketCountThresholds.getMinDocCount()) {
     * {@link DenseGlobalOrds} when collecting every ordinal, but significantly
    }
        add.accept("segments_with_single_valued_ords", segmentsWithSingleValuedOrds);
            AggregatorFactories factories,
                        for (int i = ordered.size() - 1; i >= 0; --i) {
        /**
            }
            );
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
            supersetSize = significanceLookup.supersetSize();
                    super.collect(doc, owningBucketOrd);
                            otherDocCount[finalOrdIdx] += docCount;
    }
    public StarTreeBucketCollector getStarTreeBucketCollector(
     * {@linkplain CollectionStrategy} that uses a {@link LongHash} to map the
                        }
                @Override
                            0,
                    size = (int) Math.min(valueCount, localBucketCountThresholds.getRequiredSize());
        }
            return "dense";
         * @param owningBucketOrd the ordinal of the bucket that owns this collection
                        return;
                long globalOrd = mapping.applyAsLong(ord);
    private SortedSetDocValues getDocValues() throws IOException {
                if (inc == 0) {
                name,
        @Override
            }
        @Override
            }
            collectStarTreeBucket(collector, docCount, bucketOrd, starTreeEntry);
        add.accept("result_selection_strategy", resultSelectionStrategy);
 * GitHub history for details.
            }
    private final LongPredicate acceptedGlobalOrdinals;
                    PriorityQueue<TB> ordered = buildPriorityQueue(size);
                return tryCollectFromTermFrequencies(
            throw new UnsupportedOperationException();
                        public void accept(long globalOrd, long bucketOrd, long docCount) throws IOException {
                        if (collectionStrategy instanceof RemapGlobalOrdsStarTree rangeSTGlobalOrds) {
import static org.apache.lucene.index.SortedSetDocValues.NO_MORE_DOCS;
            /*
                while ((count-- > 0) && (globalOrd = globalOrds.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {
        long getOrAddBucketOrd(long owningBucketOrd, long globalOrd) {
                collectBucket(sub, doc, bucketOrd);
        ) throws IOException {
 *
                spare.supersetDf = backgroundFrequencies.freq(spare.termBytes);
import org.opensearch.common.lease.Releasable;
                        segmentDocCounts.increment(ord + 1, docCount);
        @Override
                order,
import org.opensearch.common.SetOnce;
        }
        collectionStrategy again if it's already correctly set. */
                // top-level query matches all docs in the segment
import org.opensearch.search.aggregations.LeafBucketCollector;
                        return;
                    @Override
                to.bytes = new byte[ArrayUtil.oversize(from.length, 1)];
        PriorityQueue<SignificantStringTerms.Bucket> buildPriorityQueue(int size) {
                if (valuesIterator.advanceExact(starTreeEntry) == false) {
        }
         * output to help with debugging.
        /**
    }
                        otherDocCount[ordIdx] = 0;
        @Override
        @Override
        return resultStrategy.buildEmptyResult();
    abstract class CollectionStrategy implements Releasable {
import org.apache.lucene.index.Terms;
            return new SignificantStringTerms.Bucket[size];
    }
import java.util.function.BiConsumer;
            segmentsWithSingleValuedOrds++;
    public void collectDebugInfo(BiConsumer<String, Object> add) {
                        @Override
import org.opensearch.search.aggregations.Aggregator;
    }
    private class RemapGlobalOrdsStarTree extends RemapGlobalOrds {
            // Weight not assigned - cannot use this optimization
                super.collect(stream, owningBucketOrd);
                otherDocCount,
        }
        SignificantStringTerms.Bucket convertTempBucketToRealBucket(SignificantStringTerms.Bucket temp) throws IOException {
        }
            return new StringTerms(
                    resultSelectionStrategy = "priority_queue";
                            otherDocCount[ordIdx] -= topBucketsPerOwningOrd[ordIdx][i].getDocCount();
            throw new UnsupportedOperationException();
                }
            if (mapping != null) {
 * You may obtain a copy of the License at
            // Field is not indexed.
            && subAggregators.length == 0) {
                long docCount = bucketDocCount(globalOrd);
                    final int finalOrdIdx = ordIdx;
            }
                    if (docCountsIterator.advanceExact(starTreeEntry)) {
                        docCount = 0;
        /* For nested aggregations, we require the RemapGlobalOrdsStarTree strategy to properly
            if (bucketOrd < 0) {
    ) throws IOException {
    /**
        add.accept("collection_strategy", collectionStrategy.describe());
            StringTerms.Bucket result = new StringTerms.Bucket(term, temp.docCount, null, showTermDocCountError, 0, format);
            super(cardinality);
                    }
        }
                            otherDocCount[ordIdx] -= topBucketsPerOwningOrd[ordIdx][i].getDocCount();
                }
            return new OrdBucket(showTermDocCountError, format);
                    int[] tot = { 0 };
        abstract void collectDebugInfo(BiConsumer<String, Object> add);
            Releasables.close(resultStrategy, segmentDocCounts, collectionStrategy);
        }
                            if (docCount >= localBucketCountThresholds.getMinDocCount()) {
        }
                 * During shard-local down-selection we use subset/superset stats
                );
        LowCardinality(
        /**
            grow(globalOrds.getValueCount());
                     * hit any documents for them. This is wasteful, but
            @Override
import org.opensearch.search.startree.filter.MatchAllFilter;
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
        @Override
            return Long.compare(globalOrd, other.globalOrd);
        @Override
     * The {@link GlobalOrdinalsStringTermsAggregator} uses one of these
        @Override
        Aggregator parent,
         */
                        int globalOrd = singleValues.ordValue();
                @Override
                    // If total collected buckets greater than request size, use quickSelect to get topN buckets
        }
                    @Override
                    }
            return false;
         * Short description of the collection mechanism added to the profile
                @Override
        @Override
            }
        abstract PriorityQueue<TB> buildPriorityQueue(int size);
            collectExistingBucket(sub, doc, globalOrd);
                    continue;
import org.opensearch.common.util.LongArray;
 * specific language governing permissions and limitations
     * resolves global ordinals post segment collection instead of on the fly
            final BucketOrder reduceOrder;
            return "terms";
import org.opensearch.search.aggregations.StarTreeBucketCollector;
            to.offset = 0;
         * they'll make sure to iterate a bucket even if it was never
    private final SetOnce<SortedSetDocValues> dvs = new SetOnce<>();
                        if (false == singleValues.advanceExact(doc)) {
            if (subAggregators.length == 0) {
import org.opensearch.search.aggregations.bucket.terms.SignificanceLookup.BackgroundFrequencyForBytes;
    /**
        }
        /**
        final LongUnaryOperator globalOrdsMapping = valuesSource.globalOrdinalsMapping(ctx);
import org.apache.lucene.index.SortedDocValues;
                            tot[0],
                    while ((count-- > 0) && (segmentOrd = segmentOrds.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {
                    }
        void accept(long globalOrd, long bucketOrd, long docCount) throws IOException;
