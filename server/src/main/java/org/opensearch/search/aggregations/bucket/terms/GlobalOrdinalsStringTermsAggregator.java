import org.opensearch.search.aggregations.InternalAggregation;  
            );
                                spare = buildEmptyTemporaryBucket();  
        }
                });
         * {@link BytesRef#deepCopyOf(BytesRef)} in that it is a way to read  
    protected int segmentsWithMultiValuedOrds = 0;  
     *  
                // top-level query matches all docs in the segment
                    long segmentOrd;
         * collect the bucket.
 * KIND, either express or implied.  See the License for the
            if (acceptedGlobalOrdinals == ALWAYS_TRUE) {
        NumericDocValues docCountValues = DocValues.getNumeric(ctx.reader(), DocCountFieldMapper.NAME);
        }
        }  
                            long bucketOrd = collectionStrategy.getOrAddBucketOrd(owningBucketOrd, ord);
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
            }
import org.apache.lucene.index.DocValues;
        ) throws IOException {
        /**  
        for (long segmentOrd = 0; segmentOrd < termCount; segmentOrd++) {
                if (strategy.equals(BucketSelectionStrategy.PRIORITY_QUEUE)) {
        @Override
        SignificantStringTerms.Bucket,
                ordCountConsumer.accept(globalOrd, segmentTermsEnum.docFreq());
            grow(globalOrds.getValueCount());
            return "dense";
import org.opensearch.core.common.io.stream.StreamOutput;
                    super.collectRange(min, max);  
            );
                collectBucket(sub, doc, bucketOrd);  
        // Iterate over the ordinals in the segment, look for matches in the global ordinal,
        /**  
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {  
                } else {
     * This is only supported for the standard {@code terms} aggregation and  
            BytesRef term = BytesRef.deepCopyOf(values.lookupOrd(temp.globalOrd));  
            return new LeafBucketCollectorBase(primary, null) {
        @Override  
                        public void accept(long globalOrd, long bucketOrd, long docCount) throws IOException {  
                @Override
            @Override
         * <p>
            SearchContext context,
    public StarTreeBucketCollector getStarTreeBucketCollector(
                    size = (int) Math.min(maxBucketOrd(), localBucketCountThresholds.getRequiredSize());  
            final SortedDocValues singleValues = DocValues.unwrapSingleton(segmentOrds);
                    }  
                // weight.count(ctx) == ctx.reader().maxDoc() implies there are no deleted documents and  
                metadata(),  
        abstract void globalOrdsReady(SortedSetDocValues globalOrds);  
    /**  
    protected CardinalityUpperBound cardinalityUpperBound;
         * Build a {@link PriorityQueue} to sort the buckets. After we've
        @Override
        }
         * @param globalOrd the global ordinal to collect
                while (ordsEnum.next()) {
            System.arraycopy(from.bytes, from.offset, to.bytes, 0, from.length);
 * license agreements. See the NOTICE file distributed with
        @Override  
                        // Get the top buckets and update the otherDocCount  
import java.util.Arrays;
            super(0, null, showDocCountError, 0, format);  
        super.collectDebugInfo(add);
                while ((count-- > 0) && (globalOrd = globalOrds.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {  
        final IndexReader reader = context.searcher().getIndexReader();
                ctx,
        SignificantStringTerms buildNoValuesResult(long owningBucketOrdinal) {
import org.apache.lucene.util.ArrayUtil;  
        return resultStrategy.buildAggregations(owningBucketOrds);  
            }
        abstract B[][] buildTopBucketsPerOrd(int size);  
import org.apache.lucene.index.SortedSetDocValues;
                        }
        /**
        @Override
                                    spare = buildEmptyTemporaryBucket();
                null,
         */
        }
                    if (false == globalOrds.advanceExact(doc)) {
        final LongUnaryOperator globalOrdsMapping = valuesSource.globalOrdinalsMapping(ctx);  
        /**
        SortedSetDocValues getGlobalOrds(LeafReaderContext ctx) throws IOException {  
        public void close() {  
    protected int segmentsWithSingleValuedOrds = 0;
                        Iterator<TB> itr = ordered.iterator();
    protected void doClose() {
         * Convert a global ordinal into a bucket ordinal.
                if (localBucketCountThresholds.getMinDocCount() == 0) {
        }  
            }  
        this.resultSelectionStrategy = Strings.EMPTY;
         * collected all of the buckets we'll collect all entries in the queue.
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
         * If {@link BucketCountThresholds#getMinDocCount()} is not 0 then  
     * resolves global ordinals post segment collection instead of on the fly
                long globalOrd;
        @Override
        protected final LongKeyedBucketOrds bucketOrds;
                // segmentDocCounts get reused over the segments and otherwise counts would be too high.  
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);  
        collectionStrategy.collectDebugInfo(add);  
        Terms segmentTerms = ctx.reader().terms(this.fieldName);  
                @Override
            } else {  
         * Build an "empty" result. Only called if there isn't any data on this
                    (globalOrd, docCount) -> incrementBucketDocCount(collectionStrategy.globalOrdToBucketOrd(0, globalOrd), docCount)
            @Override  
        TB extends InternalMultiBucketAggregation.InternalBucket> implements Releasable {
                        ArrayUtil.select(
         * they'll make sure to iterate a bucket even if it was never
                    partiallyBuiltBucketComparator,  
            long docCount
            parent == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
                    ? valuesSource.globalOrdinalsValues(context.searcher().getIndexReader().leaves().get(0))  
        B extends InternalMultiBucketAggregation.InternalBucket,
            // This segment has at least one document with the _doc_count field.
        }
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
                } else {  
    static class OrdBucket extends InternalTerms.Bucket<OrdBucket> {
        SignificantStringTerms buildEmptyResult() {
                // priority queue is based on the significanceScore
    private final long valueCount;  
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
import java.util.Map;
         * <strong>something</strong> that won't mutate out from under you.
                public void collect(int doc, long owningBucketOrd) throws IOException {  
            if (singleValues != null) {  
import org.opensearch.search.aggregations.AggregatorFactories;  
                    subsetSizes = context.bigArrays().grow(subsetSizes, owningBucketOrd + 1);
            assert owningBucketOrd == 0;  
                    }
        public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
         */  
         * Build an empty temporary bucket.
        }  
            return buildEmptyResult();
        /**  
         * Wrap the "standard" numeric terms collector to collect any more
                        for (int i = ordered.size() - 1; i >= 0; --i) {
    }
         * Convert a temporary bucket into a real bucket.  
        return StarTreeQueryHelper.collectDimensionFilters(new MatchAllFilter(fieldName), subAggregators);
            segmentDocCounts = context.bigArrays().grow(segmentDocCounts, 1 + segmentOrds.getValueCount());
        }
        }  
         * {{@link #collectGlobalOrd collected}.
            }  
            return globalOrdToBucketOrd(owningBucketOrd, globalOrd);
        } else {  
                            size,  
        handle global ordinal remapping. This check ensures we don't reinitialize the
            return (spare, globalOrd, bucketOrd, docCount) -> {
                return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, globalOrds) {
        @Override  
 */
                SortedSetDocValues values = getDocValues();
    abstract class ResultStrategy<
        /**
                        }
import org.apache.lucene.index.TermsEnum;  
                order,
                    );
                return results;
                }
            return primary;
        @Override
                if (inc == 0) {
            if (isKeyOrder(order) == false) {
            collectionStrategy = new RemapGlobalOrdsStarTree(this.cardinalityUpperBound);
        @Override  
import org.apache.lucene.index.SortedDocValues;  
            boolean remapGlobalOrds,  
        protected final XContentBuilder keyToXContent(XContentBuilder builder) throws IOException {
     * Builds results for the standard {@code terms} aggregation.  
         * Copies the bytes from {@code from} into {@code to}, oversizing
import org.opensearch.search.aggregations.bucket.terms.SignificanceLookup.BackgroundFrequencyForBytes;
    protected final String fieldName;
    public void collectDebugInfo(BiConsumer<String, Object> add) {  
                    @Override
        StringTerms buildEmptyResult() {
     */
        CompositeIndexFieldInfo supportedStarTree = StarTreeQueryHelper.getSupportedStarTree(this.context.getQueryShardContext());
 * Licensed to Elasticsearch under one or more contributor  
                format,  
                    super.collectRange(min, max);  
                metadata(),
        @Override  
    @Override
        LowCardinality(
                InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];
                        }
        SortedSetDocValues globalOrds = this.getGlobalOrds(ctx);  
 * the Apache License, Version 2.0 (the "License"); you may
                    int[] tot = { 0 };  
            return new SignificantStringTerms(
    /**  
        @Override
     * to collect the global ordinals by calling  
         * bytes from a mutable {@link BytesRef} into
    protected final ValuesSource.Bytes.WithOrdinals valuesSource;  
        }
        /**
         * @param sub the sub-aggregators that will collect the bucket data  
    /**
            throw new UnsupportedOperationException();
        R extends InternalAggregation,  
            }  
        private final long supersetSize;  
        String name,
                        // order in priority queue ordered
 *
        public void close() {
            int starTreeEntry,
                    if (false == acceptedGlobalOrdinals.test(globalOrd)) {
        BucketUpdater<OrdBucket> bucketUpdater(long owningBucketOrd) throws IOException {
    /**  
                }
        public String getKeyAsString() {  
                    while ((count-- > 0) && (globalOrd = globalOrds.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {  
            for (long globalOrd = 0; globalOrd < valueCount; globalOrd++) {
                showTermDocCountError,
        @Override
    @Override
            public void collect(int doc, long owningBucketOrd) throws IOException {  
                    } else {
             * common and marginally faster.
                    collectionStrategy.forEach(owningBucketOrds[ordIdx], new BucketInfoConsumer() {  
        abstract PriorityQueue<TB> buildPriorityQueue(int size);
        add.accept("segments_with_multi_valued_ords", segmentsWithMultiValuedOrds);  
        }
    ) throws IOException {
                public void collectRange(int min, int max) throws IOException {  
                            topBucketsPerOwningOrd[ordIdx][i] = convertTempBucketToRealBucket(ordered.pop());
     * <p>
        assert segmentTermsEnum.next() == null : "Segment terms enum must be fully exhausted";
     * {@link StandardTermsResults}.
import org.opensearch.search.startree.StarTreeQueryHelper;  
                    }
        if (docCountValues.nextDoc() != NO_MORE_DOCS) {  
                 * common and marginally faster.
                to.bytes = new byte[ArrayUtil.oversize(from.length, 1)];
     * {@link CollectionStrategy#collectGlobalOrd} for each global ordinal
                    consumer.accept(ordsEnum.value(), ordsEnum.ord(), bucketDocCount(ordsEnum.ord()));  
        abstract void buildSubAggs(B[][] topBucketsPreOrd) throws IOException;
                        super.collect(stream, owningBucketOrd);
        /**
     *
            buildSubAggs(topBucketsPerOwningOrd);
        /**  
        void forEach(long owningBucketOrd, BucketInfoConsumer consumer) throws IOException {
                     * sub-aggregations without trouble even though we haven't
         * the destination array if the bytes won't fit into the array.  
            }
                Arrays.sort(topBuckets, reduceOrder.comparator());  
                    ctx,  
         * this bucket ordinal.
        }
            return bucketOrds.add(owningBucketOrd, globalOrd);
     * for each match.This is beneficial for low cardinality fields, because  
        @Override  
        @Override
            Map<String, Object> metadata  
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
                public void collect(int doc, long owningBucketOrd) throws IOException {
                    @Override
        SignificantStringTerms.Bucket convertTempBucketToRealBucket(SignificantStringTerms.Bucket temp) throws IOException {
        }  
    boolean tryCollectFromTermFrequencies(LeafReaderContext ctx, BiConsumer<Long, Integer> ordCountConsumer) throws IOException {  
            }  
                        segmentDocCounts.increment(ord + 1, docCount);
                    } else {
 * ownership. Elasticsearch licenses this file to you under  
            }
                        for (int i = 0; i < size; i++) {
        } else {
            }  
            return false;  
                            return;
                metadata
        SignificantTermsResults(
        collectionStrategy again if it's already correctly set. */
 *    http://www.apache.org/licenses/LICENSE-2.0
                    int count = segmentOrds.docValueCount();  
                long ord = i - 1; // remember we do +1 when counting
     * {@link DenseGlobalOrds} when collecting every ordinal, but significantly  
    }
            }
            collectionStrategy.globalOrdsReady(globalOrds);
                                if (spare == null) {
    }
                            }  
                BucketSelectionStrategy strategy = BucketSelectionStrategy.determine(
            backgroundFrequencies = significanceLookup.bytesLookup(context.bigArrays(), cardinality);
        if (supportedStarTree != null) {
                Arrays.asList(topBuckets),
                    }  
        StringTerms buildResult(long owningBucketOrd, long otherDocCount, StringTerms.Bucket[] topBuckets) {
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
            return (spare, globalOrd, bucketOrd, docCount) -> {  
    class DenseGlobalOrds extends CollectionStrategy {
            };
                    }  
        return resultStrategy.buildEmptyResult();
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
        }
                }
            return new StringTerms(
            && subAggregators.length == 0) {  
 */  
                 */  
            );  
        private RemapGlobalOrds(CardinalityUpperBound cardinality) {  
                    super.collectRange(min, max);
                        );
                int count = globalOrds.docValueCount();
         */  
        Aggregator parent,
                    consumer.accept(globalOrd, bucketOrd, docCount);
        @Override  
            segmentsWithSingleValuedOrds++;
    public String getResultSelectionStrategy() {
                // partiallyBuiltBucketComparator is null for significantTerm Aggregations use case and the way buckets sorted in the  
            });
        SortedDocValues singleValues = DocValues.unwrapSingleton(globalOrds);
                @Override  
                otherDocCount,  
        private long subsetSize(long owningBucketOrd) {  
            return new BucketSignificancePriorityQueue<>(size);
                long docCount = bucketDocCount(globalOrd);
        }  
                    topBucketsPerOwningOrd[ordIdx] = buildBuckets(ordered.size());
                    if (false == singleValues.advanceExact(doc)) {
        SignificantStringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
import org.opensearch.common.lease.Releasable;
                            otherDocCount[ordIdx] -= topBucketsPerOwningOrd[ordIdx][i].getDocCount();
        /**  
                     * even if the global ord wasn't found so we can build  
        void globalOrdsReady(SortedSetDocValues globalOrds) {  
            });
                public void collect(int doc, long owningBucketOrd) throws IOException {  
        @Override
        ) {  
                Arrays.asList(topBuckets),
         * if the {@link BucketCountThresholds#getMinDocCount()} is 0 then  
import org.apache.lucene.index.LeafReaderContext;
        abstract void collectGlobalOrd(long owningBucketOrd, int doc, long globalOrd, LeafBucketCollector sub) throws IOException;
        }  
            supersetSize = significanceLookup.supersetSize();
        }  
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                 * that are for this shard only. Back at the central reducer these
            @Override
     * The {@link GlobalOrdinalsStringTermsAggregator} uses one of these
     * Builds results for the {@code significant_terms} aggregation.
                @Override  
         */  
            throw new UnsupportedOperationException();
        long globalOrd;  
                        return;
                    // if minDocCount == 0 then we can end up with more buckets then maxBucketOrd() returns  
            // Weight not assigned - cannot use this optimization
                public void collectRange(int min, int max) throws IOException {
                            collectStarTreeBucket(this, metricValue, bucketOrd, starTreeEntry);
                reduceOrder = order;
            } else {
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {
        }
                    if (isKeyOrder(order)) {  
                    if (bucketOrd < 0) {
            starTreeValues,  
         * a bunch of little arrays over and over and over again.  
        }
    /**
        String describe() {
        private RemapGlobalOrdsStarTree(CardinalityUpperBound cardinality) {
 * SPDX-License-Identifier: Apache-2.0
                    collectionStrategy.collectGlobalOrd(owningBucketOrd, doc, globalOrd, sub);
            });  
                }
                @Override
            segmentTermsEnum.next();
                significanceHeuristic,
        void globalOrdsReady(SortedSetDocValues globalOrds) {}  
     * global ordinal into bucket ordinals. This uses more memory than
                return true;
                    public void collectRange(int min, int max) throws IOException {
                format,
            buildSubAggsForAllBuckets(topBucketsPreOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
         * delegate to {@link #buildSubAggsForAllBuckets}.  
         */  
 * Modifications Copyright OpenSearch Contributors. See
     * doesn't support {@code significant_terms} so this forces
            }
        @Override  
                        }  
                        if (collectionStrategy instanceof RemapGlobalOrdsStarTree rangeSTGlobalOrds) {
                (ord, docCount) -> incrementBucketDocCount(collectionStrategy.globalOrdToBucketOrd(0, ord), docCount)  
    private class RemapGlobalOrds extends CollectionStrategy {  
import org.opensearch.search.aggregations.support.ValuesSource;
public class GlobalOrdinalsStringTermsAggregator extends AbstractStringTermsAggregator implements StarTreePreComputeCollector {
    }
                        @Override
                    continue;  
                    context.bucketSelectionStrategyFactor()
        @Override
                }
        if (tryStarTreePrecompute(ctx) == true) {
        }
     Read doc frequencies directly from indexed terms in the segment to skip iterating through individual documents  
     * it can reduce the amount of look-ups significantly.
            Function<GlobalOrdinalsStringTermsAggregator, ResultStrategy<?, ?, ?>> resultStrategy,
         */
        boolean remapGlobalOrds,  
        abstract B convertTempBucketToRealBucket(TB temp) throws IOException;
                            if (docCount >= localBucketCountThresholds.getMinDocCount()) {
                }
    }
     */
                super.collectRange(min, max);  
                     * settings minDocCount == 0 is wasteful in general.....  
                    }
         * Iterate all the buckets. Implementations take into account
         */  
                bucketOrd = -1 - bucketOrd;  
        void accept(long globalOrd, long bucketOrd, long docCount) throws IOException;
                            topBucketsPerOwningOrd[ordIdx][i] = convertTempBucketToRealBucket((TB) bucketsForOrdArr[i]);  
import org.opensearch.common.SetOnce;  
        @Override
        LongUnaryOperator globalOperator = valuesSource.globalOrdinalsMapping(ctx);
        @Override
            return tryCollectFromTermFrequencies(
        protected void doClose() {
    class StandardTermsResults extends ResultStrategy<StringTerms, StringTerms.Bucket, OrdBucket> {
            fieldName
    ) throws IOException {
import org.opensearch.common.util.LongArray;  
                bucketCountThresholds.getShardSize(),
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
            return buildEmptySignificantTermsAggregation(0, significanceHeuristic);  
                        segmentDocCounts.increment(segmentOrd + 1, docCount);
            StarTreeQueryHelper.preComputeBucketsWithStarTree(starTreeBucketCollector);
                    if (false == acceptedGlobalOrdinals.test(globalOrd)) {
    interface BucketUpdater<TB extends InternalMultiBucketAggregation.InternalBucket> {
                0,
import java.util.Iterator;  
                context,
         * Short description of the collection mechanism added to the profile
            return result;
                        resultSelectionStrategy = "quick_select";  
        add.accept("segments_with_single_valued_ords", segmentsWithSingleValuedOrds);
                if (valuesIterator.advanceExact(starTreeEntry) == false) {
    }  
                        }  
    }
                }
        @Override
                    // Get the top buckets
                oversizedCopy(values.lookupOrd(globalOrd), spare.termBytes);  
import org.opensearch.search.aggregations.StarTreeBucketCollector;
        if (singleValues != null) {  
        /**  
        String describe() {
        private LongArray subsetSizes = context.bigArrays().newLongArray(1, true);  
                supersetSize,  
                    return;  
        add.accept("collection_strategy", collectionStrategy.describe());
        return new StarTreeBucketCollector(
import java.util.List;
            super(
import static org.apache.lucene.index.SortedSetDocValues.NO_MORE_DOCS;  
            }  
                            return;
                    collectionStrategy.collectGlobalOrd(owningBucketOrd, doc, globalOrd, sub);
    public void setWeight(Weight weight) {  
        this.weight = weight;
        });
     */
            collectStarTreeBucket(collector, docCount, bucketOrd, starTreeEntry);
        SortedNumericStarTreeValuesIterator docCountsIterator = StarTreeQueryHelper.getDocCountsIterator(starTreeValues, starTree);
                    throw new AggregationExecutionException("Dense ords don't know how to collect from many buckets");  
         * information that this result type may need.  
                if (false == globalOrds.advanceExact(doc)) {
                }  
            StringTerms.Bucket result = new StringTerms.Bucket(term, temp.docCount, null, showTermDocCountError, 0, format);
                        @Override  
                        bucketOrd = -1 - bucketOrd;
            return false;
                    this.subCollectors.add(  
        CardinalityUpperBound cardinality,  
        void forEach(long owningBucketOrd, BucketInfoConsumer consumer) throws IOException {
                incrementBucketDocCount(collectionStrategy.globalOrdToBucketOrd(0, globalOrd), inc);
                        return;  
        /**  
            ? valuesSource.globalOrdinalsValues(context.searcher().getIndexReader().leaves().get(0))  
        }  
        void collectGlobalOrdsForStarTree(
        @Override
    protected CollectionStrategy collectionStrategy;  
            B[][] topBucketsPerOwningOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
                    final int finalOrdIdx = ordIdx;
            return owningBucketOrd < subsetSizes.size() ? subsetSizes.get(owningBucketOrd) : 0;
     * Predicate used for {@link #acceptedGlobalOrdinals} if there is no filter.
         * there aren't any values for the field on this shard.
     * Variant of {@link GlobalOrdinalsStringTermsAggregator} that
            InternalAggregation[] results = new InternalAggregation[owningBucketOrds.length];  
        abstract R buildEmptyResult();
        if (termCount == -1 || termCount > context.termsAggregationMaxPrecomputeCardinality()) {
                }
    /**
    static class LowCardinality extends GlobalOrdinalsStringTermsAggregator {  
    public GlobalOrdinalsStringTermsAggregator(
        @Override
    }  
                    });
        add.accept("result_selection_strategy", resultSelectionStrategy);
            add.accept("total_buckets", bucketOrds.size());
        /**
                    subsetSizes.increment(owningBucketOrd, 1);  
            boolean showTermDocCountError,
            @Override
                        collectionStrategy.collectGlobalOrd(owningBucketOrd, doc, globalOrd, sub);
import org.apache.lucene.search.Weight;
        }
    }
                        assert owningBucketOrd == 0;
        /**
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        @Override
                 * properties will be updated with global stats.
        private final SignificanceHeuristic significanceHeuristic;
         */
        }
            if (bucketCountThresholds.getMinDocCount() == 0) {
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {  
        abstract String describe();
            public void collectRange(int min, int max) throws IOException {
        SortedSetStarTreeValuesIterator valuesIterator = (SortedSetStarTreeValuesIterator) starTreeValues.getDimensionValuesIterator(
        public Number getKeyAsNumber() {
            );
                long inc = segmentDocCounts.set(i, 0);
        SignificantStringTerms.Bucket[] buildBuckets(int size) {  
        }
            segmentsWithMultiValuedOrds++;
                    long ord = globalOperator.applyAsLong(dimensionValue);
         * Add a global ordinal if it hasn't been seen before.  
                    if (false == segmentOrds.advanceExact(doc)) {  
                @Override
                }
                valuesSource,  
 * GitHub history for details.
 * software distributed under the License is distributed on an
        abstract void forEach(long owningBucketOrd, BucketInfoConsumer consumer) throws IOException;  
        if (weight == null) {
            assert owningBucketOrd == 0;  
                    if (false == acceptedGlobalOrdinals.test(ordsEnum.value())) {  
    @Override  
        abstract void collectDebugInfo(BiConsumer<String, Object> add);
                    assert owningBucketOrd == 0;
            // Field is not indexed.
        }
         */  
import java.util.function.LongUnaryOperator;  
            StarTreeBucketCollector collector,  
                            otherDocCount[finalOrdIdx] += docCount;
                        continue;
                        int globalOrd = singleValues.ordValue();
        if (collectionStrategy instanceof DenseGlobalOrds
    /**
         */  
    }  
        }
                showTermDocCountError,  
                name,
            result.docCountError = 0;
        OrdBucket buildEmptyTemporaryBucket() {  
                }  
            return "remap";  
         * Build an "empty" result for a particular bucket ordinal. Called when
        void collectGlobalOrd(long owningBucketOrd, int doc, long globalOrd, LeafBucketCollector sub) throws IOException {  
         */
        StringTerms.Bucket convertTempBucketToRealBucket(OrdBucket temp) throws IOException {  
            if (subAggregators.length == 0) {
            AggregatorFactories factories,
                    if (docCountsIterator.advanceExact(starTreeEntry)) {
                    // If total collected buckets greater than request size, use quickSelect to get topN buckets  
        AggregatorFactories factories,  
        }
                            otherDocCount[ordIdx] -= topBucketsPerOwningOrd[ordIdx][i].getDocCount();  
        }  
        @Override  
import java.util.function.LongPredicate;
            this.significanceHeuristic = significanceHeuristic;  
        super(name, factories, context, parent, order, format, bucketCountThresholds, collectionMode, showTermDocCountError, metadata);  
                    super.collect(doc, owningBucketOrd);
 *
        if (dvs.get() == null) {  
                }
 * @opensearch.internal
     */
        if (segmentTerms == null) {
        @Override
        ) throws IOException {
                        if (false == singleValues.advanceExact(doc)) {  
        @Override
        @Override
import org.opensearch.search.aggregations.Aggregator;
        abstract long getOrAddBucketOrd(long owningBucketOrd, long globalOrd) throws IOException;  
                            bucketsForOrdArr,  
                    super.collect(stream, owningBucketOrd);
                collectionMode,
        IncludeExclude.OrdinalsFilter includeExclude,  
                for (long globalOrd = 0; globalOrd < valueCount; globalOrd++) {  
        @Override  
                    }  
                });
            return tryStarTreePrecompute(ctx);
                            otherDocCount[ordIdx] -= topBucketsPerOwningOrd[ordIdx][i].getDocCount();
        long termCount = segmentTerms.size();  
                    BucketUpdater<TB> updater = bucketUpdater(owningBucketOrds[ordIdx]);
        }
     @return A LeafBucketCollector implementation with collection termination, since collection is complete  
    }  
    }
     * If DocValues have not been initialized yet for reduce phase, create and set them.  
        }
        }
         * Short description of the collection mechanism added to the profile
            for (long i = 1; i < segmentDocCounts.size(); i++) {
         * output to help with debugging.
                        continue;
                factories,
        }
            StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, supportedStarTree, null);  
    private String resultSelectionStrategy;
            result.bucketOrd = temp.bucketOrd;  
                    }
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
        if (acceptedGlobalOrdinals == ALWAYS_TRUE) {
                @Override
                    } else {
                mapSegmentCountsToGlobalCounts(mapping);
         * shard.
        protected void writeTermTo(StreamOutput out) throws IOException {  
        }  
 *
import org.opensearch.search.internal.SearchContext;
     * once to iterate on the results.  
            long globalOrd,
            /*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                public void collectRange(int min, int max) throws IOException {
                            ((b1, b2) -> partiallyBuiltBucketComparator.compare((InternalTerms.Bucket<?>) b1, (InternalTerms.Bucket<?>) b2))
        StringTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
            }  
    @Override
}  
            }  
 * compatible open source license.
 * this work for additional information regarding copyright
import org.apache.lucene.index.IndexReader;  
                }  
                        topBucketsPerOwningOrd[ordIdx] = buildBuckets(tot[0]);  
        this.resultStrategy = resultStrategy.apply(this); // ResultStrategy needs a reference to the Aggregator to do its job.
                collectExistingBucket(sub, doc, bucketOrd);
    }
        private LongArray segmentDocCounts;  
import org.opensearch.search.startree.filter.DimensionFilter;
     */
        SearchContext context,
    SortedSetDocValues getGlobalOrds(LeafReaderContext ctx) throws IOException {
                }
    }  
         * Called when the global ordinals are ready.
            String name,  
         */  
        BucketOrder order,  
    private class RemapGlobalOrdsStarTree extends RemapGlobalOrds {
        this.valuesSource = valuesSource;  
     * Strategy for collecting global ordinals.  
                name,
                        public void accept(long globalOrd, long bucketOrd, long docCount) throws IOException {
        DocValueFormat format,
                 * During shard-local down-selection we use subset/superset stats  
    }
            // if the owningBucketOrd is not in the array that means the bucket is empty so the size has to be 0
                    public void collect(int doc, long owningBucketOrd) throws IOException {
        SignificantStringTerms.Bucket buildEmptyTemporaryBucket() {
import org.opensearch.common.util.LongHash;
                    }
            : DocValues.emptySortedSet();
        @Override
                spare.docCount = docCount;  
        return dvs.get();
                        }
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
import org.apache.lucene.index.Terms;
        void collectDebugInfo(BiConsumer<String, Object> add) {}  
                format,
                // processing each owning bucket
    }
        }  
            long[] otherDocCount = new long[owningBucketOrds.length];  
    @Override
                        }  
                spare.supersetSize = supersetSize;
        public void close() {}  
            return false;  
        /**  
    }  
import org.opensearch.search.startree.filter.MatchAllFilter;
            @Override  
                    BucketUpdater<TB> updater = bucketUpdater(owningBucketOrds[ordIdx]);
import org.opensearch.search.aggregations.InternalOrder;
                spare.bucketOrd = bucketOrd;
                    PriorityQueue<TB> ordered = buildPriorityQueue(size);
     */
                        super.collectRange(min, max);  
import org.opensearch.search.aggregations.CardinalityUpperBound;
        collectionStrategy.globalOrdsReady(globalOrds);
        /**
import org.apache.lucene.util.BytesRef;
    }
    }
    class SignificantTermsResults extends ResultStrategy<  
        if (parent != null && !(collectionStrategy instanceof RemapGlobalOrdsStarTree)) {  
import org.opensearch.search.DocValueFormat;  
                    // for each provides the bucket ord and key value for the owning bucket
     * {@linkplain CollectionStrategy} that just uses the global ordinal as the
         */
        }  
                    }  
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
                            }  
        long globalOrdToBucketOrd(long owningBucketOrd, long globalOrd) {
        PriorityQueue<SignificantStringTerms.Bucket> buildPriorityQueue(int size) {  
                // We use set(...) here, because we need to reset the slow to 0.
     @param ctx The LeafReaderContext to collect terms from
                bucketCountThresholds  
                    if (tot[0] > size) {
import org.opensearch.search.aggregations.AggregationExecutionException;
        abstract BucketUpdater<TB> bucketUpdater(long owningBucketOrd) throws IOException;
                    int count = globalOrds.docValueCount();
                // Recreate DocValues as needed for concurrent segment search
        }  
                        resultSelectionStrategy = "select_all";
                    }
        PriorityQueue<OrdBucket> buildPriorityQueue(int size) {
        };
            if (mapping != null) {
    }  
            ? ((ValuesSource.Bytes.WithOrdinals.FieldData) valuesSource).getIndexFieldName()  
            // Recreate DocValues as needed for concurrent segment search
            long owningBucketOrd,  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.XContentBuilder;  
                            tot[0],
         * the {@link BucketCountThresholds}. In particular,
        abstract TB buildEmptyTemporaryBucket();
        }
                        int ord = singleValues.ordValue();  
        return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, globalOrds) {
        @Override
            return "significant_terms";
        }
        Releasables.close(resultStrategy, collectionStrategy);  
        return false;  
                    consumer.accept(globalOrd, globalOrd, docCount);
                spare.updateScore(significanceHeuristic);
         */
                                spare = ordered.insertWithOverflow(spare);
import org.apache.lucene.index.NumericDocValues;
            }
        CompositeIndexFieldInfo starTree,  
 * specific language governing permissions and limitations
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
                bucketCountThresholds,  
     */
        @Override
        public Object getKey() {
            }
         * only be called if the aggregation is being profiled.
        }  
                    @Override
        }
                            if (docCount >= localBucketCountThresholds.getMinDocCount()) {  
         * Update fields in {@code spare} to reflect information collected for
            Releasables.close(backgroundFrequencies, subsetSizes);
 */  
            to.offset = 0;  
            this.segmentDocCounts = context.bigArrays().newLongArray(1, true);
                if (false == acceptedGlobalOrdinals.test(globalOrd)) {
        );  
                order,
                }
                     * Use `add` instead of `find` here to assign an ordinal
            BucketOrder order,
                    }
                    });
        private final BackgroundFrequencyForBytes backgroundFrequencies;
 */  
     */
import org.opensearch.search.aggregations.StarTreePreComputeCollector;  
     * that it hits and then calling {@link CollectionStrategy#forEach}
         * Unlike {@linkplain BytesRef#deepCopyOf(BytesRef)} its designed to  
            long bucketOrd = bucketOrds.add(owningBucketOrd, globalOrd);  
/*  
                );
                CardinalityUpperBound.ONE,
                        long metricValue = docCountsIterator.nextValue();  
        }
                    }
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
        // Segment terms enum should be fully exhausted after iterating over all the ordinals  
            return new SignificantStringTerms.Bucket(new BytesRef(), 0, 0, 0, 0, null, format, 0);  
                }  
                    return;
            });
     */
        long globalOrdToBucketOrd(long owningBucketOrd, long globalOrd) {
                spare.subsetSize = subsetSize;
            if (bucketOrd < 0) {
            && this.resultStrategy instanceof StandardTermsResults
            final BucketOrder reduceOrder;  
            return true;
                }
    private SortedSetDocValues getDocValues() throws IOException {
        @Override
        private void mapSegmentCountsToGlobalCounts(LongUnaryOperator mapping) throws IOException {  
         * Collect debug information to add to the profiling results. This will
        return resultSelectionStrategy;  
            return new SignificantStringTerms.Bucket[size];
        @Override
         * Build the sub-aggregations into the buckets. This will usually
        }
        }  
        return collectionStrategy.describe();  
        }  
            return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, globalOrds) {
                }  
     * bucket ordinal.  
package org.opensearch.search.aggregations.bucket.terms;
                    Object[] bucketsForOrdArr = new Object[(int) valueCount];
                    }
        }
            if (acceptedGlobalOrdinals.test(globalOrd)) {
                }
        @Override
        }  
                 */  
            Aggregator parent,
                    size,  
     */
                    super.collect(stream, owningBucketOrd);
        @Override  
        @Override
                checkCancelled();  
            long bucketOrd = bucketOrds.add(owningBucketOrd, globalOrd);
        String describe() {
/**
    }
        SignificantStringTerms buildResult(long owningBucketOrd, long otherDocCount, SignificantStringTerms.Bucket[] topBuckets) {  
        }
         * Build an array of buckets for a particular ordinal to collect the  
     */
                        return;
        @Override
                            topBucketsPerOwningOrd[ordIdx][i] = convertTempBucketToRealBucket((TB) bucketsForOrdArr[i]);
     * This is used internally only, just for compare using global ordinal instead of term bytes in the PQ
import org.opensearch.search.aggregations.LeafBucketCollector;  
                    @Override
        /* For nested aggregations, we require the RemapGlobalOrdsStarTree strategy to properly  
                results[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCount[ordIdx], topBucketsPerOwningOrd[ordIdx]);
            bucketOrds.close();  
                        // All buckets fit within the required size, no selection needed
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
                    if (false == acceptedGlobalOrdinals.test(globalOrd)) {
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
        }
        if (remapGlobalOrds) {
            return temp;  
         * output to help with debugging.  
                spare.subsetDf = docCount;
                                }  
import org.opensearch.search.aggregations.BucketOrder;
     @param ordCountConsumer A consumer to accept collected term frequencies
 * under the License.  
        SignificantStringTerms.Bucket> {  
    /**  
                        topBucketsPerOwningOrd[ordIdx] = buildBuckets(size);
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
        add.accept("result_strategy", resultStrategy.describe());
        }  
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);
    }
    public List<DimensionFilter> getDimensionFilters() {  
            return new StringTerms.Bucket[size];
            final SortedSetDocValues segmentOrds = this.getGlobalOrds(ctx);  
            return new StringTerms.Bucket[size][];  
            if (to.bytes.length < from.length) {  
        }
                     * hit any documents for them. This is wasteful, but
            return true;
        }
            : null;
        }  
            return "terms";
                        docCount = 0;
            return buildEmptyTermsAggregation();  
             * Optimize when there isn't a filter because that is very
        @Override
                long globalOrd = mapping.applyAsLong(ord);  
         * Convert the global ordinal into a bucket ordinal.
                return tryCollectFromTermFrequencies(
                        docCount = bucketDocCount(bucketOrd);  
        BucketCountThresholds bucketCountThresholds,
        add.accept("has_filter", acceptedGlobalOrdinals != ALWAYS_TRUE);
        abstract String describe();
        @Override
            throw new UnsupportedOperationException();  
        // and increment bucket count when segment ordinal is contained in global ordinals.  
 * The OpenSearch Contributors require contributions made to  
         * Turn the buckets into an aggregation result.
    interface BucketInfoConsumer {  
            return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, segmentOrds) {
import java.util.function.Function;
    /**  
                if (bucketCountThresholds.getMinDocCount() == 0 || docCount > 0) {  
                                bucketsForOrdArr[tot[0]++] = spare;
            };  
                    /*
            collectExistingBucket(sub, doc, globalOrd);
            CardinalityUpperBound cardinality
        long getOrAddBucketOrd(long owningBucketOrd, long globalOrd) {
            throw new UnsupportedOperationException();
        }
            SubAggCollectionMode collectionMode,
import org.apache.lucene.util.PriorityQueue;
 * not use this file except in compliance with the License.
                mapping = null;  
        segmentsWithMultiValuedOrds++;
/*
                    int globalOrd = singleValues.ordValue();
                     */
                    final int finalOrdIdx = ordIdx;  
         */
    private final LongPredicate acceptedGlobalOrdinals;
        private LongUnaryOperator mapping;
        }  
         */
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
        LeafReaderContext ctx,
            long globalOrd = globalOrdsMapping.applyAsLong(segmentOrd);  
        /**
            }  
                    long dimensionValue = valuesIterator.value();  
                return new DenseGlobalOrds();
                @Override
        }  
                            topBucketsPerOwningOrd[ordIdx][i] = convertTempBucketToRealBucket(itr.next());
                }
            if (mapping != null) {  
                if (estimate > 1) {
        }  
        boolean showTermDocCountError,
    @Override
                            rangeSTGlobalOrds.collectGlobalOrdsForStarTree(owningBucketOrd, starTreeEntry, ord, this, metricValue);
    }
            dvs.set(
                    super.collectRange(min, max);  
            return results;
            ValuesSource.Bytes.WithOrdinals valuesSource,  
        this.acceptedGlobalOrdinals = includeExclude == null ? ALWAYS_TRUE : includeExclude.acceptedGlobalOrdinals(values)::get;  
                }  
                    continue;  
            return globalOrd;
        @Override
                        collectionStrategy.collectGlobalOrd(owningBucketOrd, doc, globalOrd, sub);
     * @opensearch.internal  
        /**
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            return bucketOrds.find(owningBucketOrd, globalOrd);  
        @Override
                /*  
                remapGlobalOrds,
                        }  
        OrdBucket(boolean showDocCountError, DocValueFormat format) {
                super.collect(stream, owningBucketOrd);
 * this file be licensed under the Apache-2.0 license or a
                    super.collect(stream, owningBucketOrd);
                subsetSize(owningBucketOrd),
        return false;
                /*
            }
        }
                        } else {  
                            0,
                    @Override
                        continue;
            assert owningBucketOrd == 0;  
    /**
        }  
                        super.collect(stream, owningBucketOrd);
        }
                name,  
                    valueCount,
    protected final ResultStrategy<?, ?, ?> resultStrategy;
            return Long.compare(globalOrd, other.globalOrd);
            );
            throw new UnsupportedOperationException();  
        final SortedSetDocValues values = !reader.leaves().isEmpty()
        public int compareKey(OrdBucket other) {
                        for (int i = ordered.size() - 1; i >= 0; --i) {  
            this.collectionStrategy = cardinality.map(estimate -> {
            return new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);  
                @Override
        @Override
         * Called once per unique document, global ordinal combination to  
                    long docCount;  
         */
                    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
                    collectionStrategy.forEach(owningBucketOrds[ordIdx], new BucketInfoConsumer() {
        }
                );
    protected boolean tryStarTreePrecompute(LeafReaderContext ctx) throws IOException {  
        void buildSubAggs(StringTerms.Bucket[][] topBucketsPerOrd) throws IOException {  
             */  
            return new SignificantStringTerms.Bucket[size][];
                 * Optimize when there isn't a filter because that is very
            collectionStrategy.close();
    public InternalAggregation buildEmptyAggregation() {
                    while ((count-- > 0) && (segmentOrd = segmentOrds.nextOrd()) != SortedSetDocValues.NO_MORE_DOCS) {
            BucketCountThresholds bucketCountThresholds,  
        String describe() {
            to.length = from.length;
            super(cardinality);  
                @Override
    String descriptCollectionStrategy() {
        long getOrAddBucketOrd(long owningBucketOrd, long globalOrd) {  
                    order,
    }  
                        long docCount = docCountProvider.getDocCount(doc);  
                    }
                    @Override  
     * Strategy for building results.  
    }  
/*  
        abstract R buildResult(long owningBucketOrd, long otherDocCount, B[] topBuckets);
                        TB spare = null;
                    public void collectRange(int min, int max) throws IOException {
        /**  
        }
            SignificanceLookup significanceLookup,  
        this.cardinalityUpperBound = cardinality;
                }
                    }
        @Override
     * @opensearch.internal
        }
         * results. The populated list is passed to {@link #buildResult}.
        abstract long globalOrdToBucketOrd(long owningBucketOrd, long globalOrd);
        return valuesSource.globalOrdinalsValues(ctx);
            }
 * An aggregator of string values that relies on global ordinals in order to build buckets.  
                        return;
         */
        @Override
            assert sub == LeafBucketCollector.NO_OP_COLLECTOR;
    /**
                for (Aggregator aggregator : subAggregators) {
                LongKeyedBucketOrds.BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrd);
            } else if (weight.count(ctx) != ctx.reader().maxDoc()) {
    private Weight weight;
                    public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
        @Override  
                    long globalOrd;
                    public void collect(int doc, long owningBucketOrd) throws IOException {  
                bucketCountThresholds  
                    }  
    }
        Function<GlobalOrdinalsStringTermsAggregator, ResultStrategy<?, ?, ?>> resultStrategy,
                segmentsWithSingleValuedOrds++;
        @Override
                return false;
                        super.collectRange(min, max);  
 *  
                }
        private InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        BucketUpdater<SignificantStringTerms.Bucket> bucketUpdater(long owningBucketOrd) throws IOException {  
import org.opensearch.common.lease.Releasables;
                    size = (int) Math.min(valueCount, localBucketCountThresholds.getRequiredSize());
        }  
        void updateBucket(TB spare, long globalOrd, long bucketOrd, long docCount) throws IOException;
                                updater.updateBucket(spare, globalOrd, bucketOrd, docCount);
        }  
                final int size;
import java.util.function.BiConsumer;  
                }
            mapping = valuesSource.globalOrdinalsMapping(ctx);  
            long subsetSize = subsetSize(owningBucketOrd);
        ValuesSource.Bytes.WithOrdinals valuesSource,
        StringTerms buildNoValuesResult(long owningBucketOrdinal) {
        }
        }
            SortedSetDocValues globalOrds = valuesSource.globalOrdinalsValues(ctx);  
        void collectDebugInfo(BiConsumer<String, Object> add) {
        protected void doPostCollection() throws IOException {  
                reduceOrder = InternalOrder.key(true);
                !context.searcher().getIndexReader().leaves().isEmpty()
                    super.collect(stream, owningBucketOrd);
    abstract class CollectionStrategy implements Releasable {
                        long docCount = docCountProvider.getDocCount(doc);
                public void collect(int doc, long owningBucketOrd) throws IOException {  
                @Override
                            otherDocCount[finalOrdIdx] += docCount;
                @Override
                    }  
import java.io.IOException;
         * oversizing the destination bytes helps to keep from allocating
                return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, segmentOrds) {
                    resultSelectionStrategy = "priority_queue";
            DocValueFormat format,
         * Build an array to hold the "top" buckets for each ordinal.
     * <p>
                mapSegmentCountsToGlobalCounts(mapping);
            };
import org.opensearch.index.mapper.DocCountFieldMapper;
                resultStrategy,
        this.valueCount = values.getValueCount();
    private final SetOnce<SortedSetDocValues> dvs = new SetOnce<>();
         */  
                        }
        }  
 * You may obtain a copy of the License at  
            SortedSetDocValues values = getDocValues();
            return false;
        abstract R buildNoValuesResult(long owningBucketOrdinal);
        }
                                updater.updateBucket(spare, globalOrd, bucketOrd, docCount);
                spare.bucketOrd = bucketOrd;  
        void buildSubAggs(SignificantStringTerms.Bucket[][] topBucketsPreOrd) throws IOException {
                        if (false == singleValues.advanceExact(doc)) {
            assert factories == null || factories.countAggregators() == 0;
                    : DocValues.emptySortedSet()
         * @param owningBucketOrd the ordinal of the bucket that owns this collection  
                        for (int i = 0; i < tot[0]; i++) {
        @Override
        protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
        this.fieldName = (valuesSource instanceof ValuesSource.Bytes.WithOrdinals.FieldData)
        }
        /**
            if (weight.count(ctx) == 0) {
        @Override  
        Map<String, Object> metadata
            SignificanceHeuristic significanceHeuristic,
                        TB spare = null;  
            Releasables.close(resultStrategy, segmentDocCounts, collectionStrategy);  
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
        SubAggCollectionMode collectionMode,
         *
        abstract B[] buildBuckets(int size);  
        return true;
                    long bucketOrd = bucketOrds.add(owningBucketOrd, globalOrd);
        @Override  
            } else {
         */
         * This is fairly similar in spirit to
        String describe() {
                    results[ordIdx] = buildNoValuesResult(owningBucketOrds[ordIdx]);  
            this.collectionStrategy = new RemapGlobalOrds(cardinality);
            bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
import org.apache.lucene.search.DocIdStream;
                spare.globalOrd = globalOrd;
            return new OrdBucket(showTermDocCountError, format);
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;  
            }  
                parent,  
            return buildEmptySignificantTermsAggregation(subsetSizes.get(owningBucketOrdinal), significanceHeuristic);
         * @param doc the doc id in to collect
                }
        SignificantStringTerms,
        void collectGlobalOrd(long owningBucketOrd, int doc, long globalOrd, LeafBucketCollector sub) throws IOException {
        }  
            return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, globalOrds) {
        @Override
    @Override
import joptsimple.internal.Strings;
                reduceOrder,  
                spare.supersetDf = backgroundFrequencies.freq(spare.termBytes);  
            return "remapStarTree";
                        // sorted buckets not needed as they will be sorted by key in buildResult() which is different from  
     * less when collecting only a few.
        public void close() {}  
         * be run over and over again into the same destination. In particular,
        ) {
     * {@linkplain CollectionStrategy} that uses a {@link LongHash} to map the
        }
        @Override
     @throws IOException If an I/O error occurs during reading
        StarTreeBucketCollector parent
        @Override
                    }  
         * they'll skip all global ords that weren't collected.
                }
    private static final LongPredicate ALWAYS_TRUE = l -> true;  
                        otherDocCount[ordIdx] = 0;
        StringTerms.Bucket[] buildBuckets(int size) {
        private void oversizedCopy(BytesRef from, BytesRef to) {
        }
            }  
        final TermsEnum segmentTermsEnum = segmentTerms.iterator();
            public void setSubCollectors() throws IOException {
    }
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
            if (valueCount == 0) { // no context in this reader  
                // No documents matches top level query on this segment, we can skip the segment entirely  
            return valuesSource.ordinalsValues(ctx);
                public void collectRange(int min, int max) throws IOException {
