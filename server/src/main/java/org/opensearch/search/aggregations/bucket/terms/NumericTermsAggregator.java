         */
                        long bucketOrd = bucketOrds.add(owningBucketOrd, dimensionValue);
                bucketCountThresholds
        LongTerms.Bucket buildEmptyBucket() {
    private final LongKeyedBucketOrds bucketOrds;
         * Update fields in {@code spare} to reflect information collected for
            }
        return resultStrategy.buildEmptyResult();
            spare.bucketOrd = ordsEnum.ord();
            if (isKeyOrder(order) == false) {
        void updateBucket(LongTerms.Bucket spare, BucketOrdsEnum ordsEnum, long docCount) {
                return;
import org.apache.lucene.util.PriorityQueue;
import org.opensearch.search.aggregations.AggregatorFactories;
        BucketOrder order,
 * the Apache License, Version 2.0 (the "License"); you may
            return new SignificantLongTerms.Bucket[size][];
                name,
                0,
        public final void close() {}
            B[][] topBucketsPerOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
import java.util.function.Function;
            return new SignificantLongTerms(
        @Override
                    }
            spare.term = ordsEnum.value();
        Releasables.close(super::doClose, bucketOrds, resultStrategy);
            // we need to fill-in the blanks
            }
        @Override
                    NumericTermsAggregator.this::bucketDocCount,
        }
            return valuesSource.longValues(ctx);
                format,
            }
         * shard.
                    for (int i = 0; i < valuesCount; ++i) {
        }
                bucketCountThresholds.getShardSize(),
import java.util.function.BiConsumer;
        private final long supersetSize;
                    if (docCountsIterator.advanceExact(starTreeEntry)) {
        }
                name,
    public List<DimensionFilter> getDimensionFilters() {
                    }
        return StarTreeQueryHelper.collectDimensionFilters(new MatchAllFilter(fieldName), subAggregators);
                }
     * Strategy for building results.
import java.util.Arrays;
    }
        LongTerms buildEmptyResult() {
        abstract B buildEmptyBucket();
import org.opensearch.common.Numbers;
        }
                    context.bucketSelectionStrategyFactor()
                long bucketsInOrd = bucketOrds.bucketsInOrd(owningBucketOrds[ordIdx]);
        }
        final void buildSubAggs(B[][] topBucketsPerOrd) throws IOException {
                bucketCountThresholds
                }
        @Override
                List.of(topBuckets),
                subsetSizes.get(owningBucketOrd),
import org.opensearch.search.startree.filter.DimensionFilter;
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
        /**
                            long value = values.nextValue();
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
                @Override
                int size = (int) Math.min(bucketsInOrd, localBucketCountThresholds.getRequiredSize());
                0,
            spare.bucketOrd = ordsEnum.ord();
            return new LeafBucketCollectorBase(primary, null) {
 * Modifications Copyright OpenSearch Contributors. See
        add.accept("total_buckets", bucketOrds.size());
    }
    }
                format,
        }
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                0,
                emptyList(),
 *
import org.opensearch.index.mapper.NumberFieldMapper;
        UnsignedLongTermsResults(boolean showTermDocCountError) {
    class LongTermsResults extends StandardTermsResultStrategy<LongTerms, LongTerms.Bucket> {
            );
            super(showTermDocCountError);
                    emptyBucketBuilder,
 * SPDX-License-Identifier: Apache-2.0
        abstract B[][] buildTopBucketsPerOrd(int size);
                );
        abstract SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException;
                    ordsEnum,
        SortedNumericDocValues values = resultStrategy.getValues(ctx);
            } else {
            supersetSize = significanceLookup.supersetSize();
                }
            parent == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
        }
         */
            StarTreeQueryHelper.preComputeBucketsWithStarTree(starTreeBucketCollector);
        LeafReaderContext ctx,
                showTermDocCountError,
            return valuesSource.longValues(ctx);
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
        }
        void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {}
                    super.collect(doc, owningBucketOrd);
import org.opensearch.search.aggregations.bucket.terms.SignificanceLookup.BackgroundFrequencyForLong;
                bucketCountThresholds
         */
            // During shard-local down-selection we use subset/superset stats that are for this shard only
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds.BucketOrdsEnum;
        DoubleTerms.Bucket buildEmptyBucket() {
 */
        @Override
         * are asigned to the value returned by {@link #buildTopBucketsPerOrd}.
            return new LongTerms.Bucket(0, 0, null, showTermDocCountError, 0, format);
        }
            SignificantLongTerms significantLongTerms = new SignificantLongTerms(
 *
        void updateBucket(UnsignedLongTerms.Bucket spare, BucketOrdsEnum ordsEnum, long docCount) {
    class DoubleTermsResults extends StandardTermsResultStrategy<DoubleTerms, DoubleTerms.Bucket> {
         * and required.
                0,
                name,
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
         * Wrap the "standard" numeric terms collector to collect any more
                reduceOrder,
import org.opensearch.search.aggregations.CardinalityUpperBound;
                super.collectRange(min, max);
import org.apache.lucene.index.SortedNumericDocValues;
    public NumericTermsAggregator(
        @Override
            // Back at the central reducer these properties will be updated with global stats
                order,
            return new LongTerms.Bucket[size];
            return result;
                result[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCounts[ordIdx], topBucketsPerOrd[ordIdx]);
                if (valuesSource.isFloatingPoint()) {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
        }
                reduceOrder = InternalOrder.key(true);
                    partiallyBuiltBucketComparator,
                    );
                }
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
                showTermDocCountError,
        IncludeExclude.LongFilter longFilter,
        @Override
            subsetSizes = context.bigArrays().newLongArray(1, true);
         * Build the sub-aggregations into the buckets. This will usually
                format,
        }
import org.opensearch.common.util.LongArray;
         */
                format,
                                }
         * this bucket ordinal.
                    (spare, ordsEnumParam, docCount) -> {
                reduceOrder = order;
        }
    public ScoreMode scoreMode() {
    @Override
            spare.docCount = docCount;
        }
         * Collect extra entries for "zero" hit documents if they were requested
            return new UnsignedLongTerms.Bucket[size][];
                BucketSelectionStrategy.SelectionResult<B> result = strategy.selectTopBuckets(selectionInput);
 *
            }
                order,
    public String getResultSelectionStrategy() {
            IndexReader topReader = searcher.getIndexReader();
            } else {
                bucketCountThresholds
         */
    }
            return "double_terms";
                    super.collectRange(min, max);
 */
        });
        }
                            updateBucket(spare, ordsEnumParam, docCount);
         * delegate to {@link #buildSubAggsForAllBuckets}.
                bucketCountThresholds.getShardSize(),
    @Override
        private InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        add.accept("result_selection_strategy", resultSelectionStrategy);
        @Override
        return resultStrategy.buildAggregations(owningBucketOrds);
            );
        }
 * under the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        }
        SignificantLongTermsResults(
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
            return () -> new SignificantLongTerms.Bucket(0, subsetSize, 0, supersetSize, 0, null, format, 0);
        ) {
        }
        }
import org.opensearch.search.aggregations.InternalOrder;
        implements
        final LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
        @Override
import org.opensearch.search.internal.ContextIndexSearcher;
import org.apache.lucene.index.LeafReaderContext;
            } else {
            ContextIndexSearcher searcher = context.searcher();
        private final BackgroundFrequencyForLong backgroundFrequencies;
                metadata(),
    private final ResultStrategy<?, ?> resultStrategy;
        }
            public void collect(int doc, long owningBucketOrd) throws IOException {
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
    }
        /**
            return new UnsignedLongTerms.Bucket[size];
            return true;
        /**
        }
                order,
                name,
        /**
                    localBucketCountThresholds,
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
        @Override
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.search.startree.filter.MatchAllFilter;
        DoubleTerms.Bucket[] buildBuckets(int size) {
                Arrays.sort(topBuckets, reduceOrder.comparator());
import org.apache.lucene.index.IndexReader;
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
        }
        DoubleTermsResults(boolean showTermDocCountError) {
                showTermDocCountError,
        @Override
                collectZeroDocEntriesIfNeeded(owningBucketOrds[ordIdx]);
        @Override
            spare.bucketOrd = ordsEnum.ord();
                    long previous = Long.MAX_VALUE;
                significanceHeuristic,
                otherDocCount,
                reduceOrder = InternalOrder.key(true);
        DoubleTerms buildResult(long owningBucketOrd, long otherDocCount, DoubleTerms.Bucket[] topBuckets) {
         */
                    if (values.advanceExact(docId)) {
public class NumericTermsAggregator extends TermsAggregator implements StarTreePreComputeCollector {
        @Override
        void updateBucket(SignificantLongTerms.Bucket spare, BucketOrdsEnum ordsEnum, long docCount) throws IOException {
                order,
                    order,
    }
                name,
            this.showTermDocCountError = showTermDocCountError;
 * software distributed under the License is distributed on an
            }
        }
                    super.collect(stream, owningBucketOrd);
    }
                format,
            @Override
                SortedNumericDocValues values = getValues(ctx);
                format,
    }
                Arrays.sort(topBuckets, reduceOrder.comparator());
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
        }
            };
                );
        }
        return new StarTreeBucketCollector(
        abstract Supplier<B> emptyBucketBuilder(long owningBucketOrd);
                bucketCountThresholds.getShardSize(),
         */
                bucketCountThresholds.getShardSize(),
 * Aggregate all docs that contain numeric terms
            .getDimensionValuesIterator(fieldName);
            public void setSubCollectors() throws IOException {
            );
            return new DoubleTerms(
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
            buildSubAggs(topBucketsPerOrd);
        @Override
        Map<String, Object> metadata
                                    bucketOrdinal = -1 - bucketOrdinal;
                    int valuesCount = values.docValueCount();
        abstract String describe();
 */
    public void doClose() {
        ResultStrategy<R, B> {
            if (isKeyOrder(order) == false) {
            this.significanceHeuristic = significanceHeuristic;
                name,
 * You may obtain a copy of the License at
            return primary;
        UnsignedLongTerms.Bucket buildEmptyBucket() {
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude.LongFilter;
                order,
                bucketCountThresholds
            }
                            if (longFilter == null || longFilter.accept(value)) {
        }
            starTreeValues,
        }
import org.apache.lucene.util.NumericUtils;
 * compatible open source license.
                showTermDocCountError,
    private String resultSelectionStrategy;
                resultSelectionStrategy = result.actualStrategyUsed;
        }
            return new LongTerms.Bucket[size][];
                        } catch (IOException e) {
        /**
        ) {
        SignificantLongTerms buildEmptyResult() {
 * @opensearch.internal
                        }
        void buildSubAggs(SignificantLongTerms.Bucket[][] topBucketsPerOrd) throws IOException {
            long subsetSize = subsetSizes.get(owningBucketOrd);
        @Override
import org.apache.lucene.search.DocIdStream;
                    return;
         * collected all of the buckets we'll collect all entries in the queue.
                List.of(topBuckets),
    abstract class ResultStrategy<R extends InternalAggregation, B extends InternalMultiBucketAggregation.InternalBucket>
                    subsetSizes = context.bigArrays().grow(subsetSizes, owningBucketOrd + 1);
                for (Aggregator aggregator : subAggregators) {
        AggregatorFactories factories,
            return ScoreMode.COMPLETE;
        protected final boolean showTermDocCountError;
    }
                0,
                0,
                public void collect(int doc, long owningBucketOrd) throws IOException {
                }
                bucketCountThresholds
            return new UnsignedLongTerms(
        @Override
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
        abstract void updateBucket(B spare, BucketOrdsEnum ordsEnum, long docCount) throws IOException;
                significanceHeuristic,
            }
        }
import java.io.IOException;
        @Override
        SignificantLongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
 * license agreements. See the NOTICE file distributed with
                metadata(),
        abstract R buildResult(long owningBucketOrd, long otherDocCounts, B[] topBuckets);
                    this.subCollectors.add(
        this.longFilter = longFilter;
        abstract B[] buildBuckets(int size);
        @Override
            );
    private final LongFilter longFilter;
                super.collect(stream, owningBucketOrd);
                metadata(),
        super.collectDebugInfo(add);
        @Override
        /**
        abstract void buildSubAggs(B[][] topBucketsPerOrd) throws IOException;
            }
        SignificantLongTerms buildResult(long owningBucketOrd, long otherDocCoun, SignificantLongTerms.Bucket[] topBuckets) {
            return "unsigned_long_terms";
                    double doubleValue = ((NumberFieldMapper.NumberFieldType) context.mapperService().fieldType(fieldName)).toDoubleValue(
import joptsimple.internal.Strings;
            InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
        String describe() {
import java.util.Map;
package org.opensearch.search.aggregations.bucket.terms;
import org.opensearch.search.aggregations.LeafBucketCollector;
                            if ((longFilter == null) || (longFilter.accept(val))) {
        @Override
                bucketCountThresholds
                    size,
/*
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
        SortedNumericStarTreeValuesIterator docCountsIterator = StarTreeQueryHelper.getDocCountsIterator(starTreeValues, starTree);
            return new SignificantLongTerms.Bucket[size];
            @Override
import java.util.List;
        /**
 */
        @Override
import java.math.BigInteger;
        abstract R buildEmptyResult();
    class SignificantLongTermsResults extends ResultStrategy<SignificantLongTerms, SignificantLongTerms.Bucket> {
 *
                }
                Supplier<B> emptyBucketBuilder = emptyBucketBuilder(owningBucketOrds[ordIdx]);
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
         * for each collected bucket.
        UnsignedLongTerms.Bucket[] buildBuckets(int size) {
        /**
                    this::buildBuckets,
                BucketSelectionStrategy strategy = BucketSelectionStrategy.determine(
                0,
            return "significant_terms";
        PriorityQueue<SignificantLongTerms.Bucket> buildPriorityQueue(int size) {
        }
        this.resultSelectionStrategy = Strings.EMPTY;
        DocValueFormat format,
    public void collectDebugInfo(BiConsumer<String, Object> add) {
        /**
    /**
                List.of(topBuckets),
                reduceOrder,
        LongTerms.Bucket[] buildBuckets(int size) {
        void updateBucket(DoubleTerms.Bucket spare, BucketOrdsEnum ordsEnum, long docCount) {
        String name,
            return new DoubleTerms.Bucket(0, 0, null, showTermDocCountError, 0, format);
        return resultSelectionStrategy;
                }
        UnsignedLongTerms buildEmptyResult() {
                long dimensionValue = valuesIterator.nextValue();
            spare.bucketOrd = ordsEnum.ord();
        abstract PriorityQueue<B> buildPriorityQueue(int size);
                return;
                @Override
                        long val = values.nextValue();
}
/*
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
        public void close() {
         * buckets. Those buckets will then be {@link #updateBucket updated}
            return new UnsignedLongTerms.Bucket(BigInteger.ZERO, 0, null, showTermDocCountError, 0, format);
            super(showTermDocCountError);
            super(showTermDocCountError);
import org.opensearch.search.startree.StarTreeQueryHelper;
            spare.term = ordsEnum.value();
                BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
        SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
        @Override
            return new DoubleTerms(
        DoubleTerms buildEmptyResult() {
                if (valuesIterator.advanceExact(starTreeEntry) == false) {
        /**
        CardinalityUpperBound cardinality,
         */
    @Override
        }
        /**
            final BucketOrder reduceOrder;
         * Build a {@link PriorityQueue} to sort the buckets. After we've
            SignificanceLookup significanceLookup,
                                    collectBucket(sub, doc, bucketOrdinal);
        }
                    }
        @Override
                        dimensionValue
            spare.term = NumericUtils.sortableLongToDouble(ordsEnum.value());
        }
                name,
                name,
                List.of(topBuckets),
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
 * this file be licensed under the Apache-2.0 license or a
        Supplier<B> emptyBucketBuilder(long owningBucketOrd) {
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, supportedStarTree, null);
            );
         */
        @Override
                        collectStarTreeBucket(this, metricValue, bucketOrd, starTreeEntry);
                bucketCountThresholds.getShardSize(),
        final PriorityQueue<B> buildPriorityQueue(int size) {
            return this::buildEmptyBucket;
        @Override
            if (bucketCountThresholds.getMinDocCount() != 0) {
 * The OpenSearch Contributors require contributions made to
         * information that this result type may need.
        }
        @Override
                emptyList(),
            if (InternalOrder.isCountDesc(order) && bucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {
        private final SignificanceHeuristic significanceHeuristic;
            long[] otherDocCounts = new long[owningBucketOrds.length];
        @Override
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);
                        int valueCount = values.docValueCount();
        }
        StarTreeBucketCollector parent
                0,
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {
            return new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);
        Function<NumericTermsAggregator, ResultStrategy<?, ?>> resultStrategy,
                @Override
         * Build an "empty" result. Only called if there isn't any data on this
            @Override
            return FieldData.toSortableLongBits(valuesSource.doubleValues(ctx));
        @Override
                public void collectRange(int min, int max) throws IOException {
                reduceOrder,
                            }
        SearchContext aggregationContext,
                0,
                // Only numeric & floating points are supported as of now in star-tree
            @Override
        }
    }
/*
                        }
 * Licensed to Elasticsearch under one or more contributor
        }
                order,
            return "long_terms";
                    partiallyBuiltBucketComparator
                                long bucketOrdinal = bucketOrds.add(owningBucketOrd, val);
            return valuesSource.longValues(ctx);
                0,
                    );
            spare.subsetDf = docCount;
            final BucketOrder reduceOrder;
            ? ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName()
                metadata(),
        UnsignedLongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
            );
            backgroundFrequencies = significanceLookup.longLookup(context.bigArrays(), cardinality);
        SignificantLongTerms.Bucket[] buildBuckets(int size) {
            return significantLongTerms;
            final BucketOrder reduceOrder;
    }
                            }
 * not use this file except in compliance with the License.
        if (valuesSource != null && valuesSource.needsScores()) {
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {
                    dimensionValue = NumericUtils.doubleToSortableLong(doubleValue);
import org.opensearch.search.aggregations.Aggregator;
        }
            }
                            previous = val;
        @Override
            // We need to account for the significance of a miss in our global stats - provide corpus size as context
    abstract class StandardTermsResultStrategy<R extends InternalMappedTerms<R, B>, B extends InternalTerms.Bucket<B>> extends
        if (supportedStarTree != null) {
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {
import org.opensearch.index.fielddata.FieldData;
                                } else {
         * Build an array to hold the "top" buckets for each ordinal.
                format,
        CompositeIndexFieldInfo starTree,
        }
    class UnsignedLongTermsResults extends StandardTermsResultStrategy<UnsignedLongTerms, UnsignedLongTerms.Bucket> {
                showTermDocCountError,
/**
        @Override
    }
            return new DoubleTerms.Bucket[size][];
                        }
         * Build a {@linkplain Supplier} that can be used to build "empty"
                reduceOrder = order;
import org.apache.lucene.search.ScoreMode;
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;
        @Override
            }
        @Override
        };
        @Override
                        try {
                }
 * GitHub history for details.
        }
        UnsignedLongTerms buildResult(long owningBucketOrd, long otherDocCount, UnsignedLongTerms.Bucket[] topBuckets) {
import static java.util.Collections.emptyList;
import org.opensearch.search.aggregations.StarTreeBucketCollector;
        }
    ) throws IOException {
                supersetSize,
            SignificanceHeuristic significanceHeuristic,
                showTermDocCountError,
    }
            return new UnsignedLongTerms(
                }
         * output to help with debugging.
        }
        super(name, factories, aggregationContext, parent, bucketCountThresholds, order, format, subAggCollectMode, metadata);
    }
                        for (int v = 0; v < valueCount; ++v) {
 * ownership. Elasticsearch licenses this file to you under
                    },
        }
        @Override
            CardinalityUpperBound cardinality
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                        if (previous != val || i == 0) {
                // TODO: Add support for isBigInteger() when it gets supported in star-tree
            return new DoubleTerms.Bucket[size];
                                    collectExistingBucket(sub, doc, bucketOrdinal);
        /**
                otherDocCount,
        @Override
import org.opensearch.search.DocValueFormat;
        @Override
                    size,
                    this::buildPriorityQueue,
        return false;
        return super.scoreMode();
                metadata(),
                                bucketOrds.add(owningBucketOrd, value);
                    ordIdx,
                supersetSize,
         */
        LongTerms buildResult(long owningBucketOrd, long otherDocCount, LongTerms.Bucket[] topBuckets) {
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;
            Releasables.close(backgroundFrequencies, subsetSizes);
         */
        }
                order,
                emptyList(),
        @Override
        CompositeIndexFieldInfo supportedStarTree = StarTreeQueryHelper.getSupportedStarTree(this.context.getQueryShardContext());
            Releasable {
            }
            spare.docCount = docCount;
     */
        return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, values) {
            @Override
                bucketCountThresholds.getShardSize(),
    ) throws IOException {
                            throw new RuntimeException("Error updating bucket", e);
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {
        Aggregator parent,
        SubAggCollectionMode subAggCollectMode,
        this.resultStrategy = resultStrategy.apply(this); // ResultStrategy needs a reference to the Aggregator to do its job.
         */
        BucketCountThresholds bucketCountThresholds,
    private final String fieldName;
                    subsetSizes.increment(owningBucketOrd, 1);
        @Override
        this.fieldName = (this.valuesSource instanceof ValuesSource.Numeric.FieldData)
            return new LongTerms(
                emptyList(),
import java.util.function.Supplier;
        this.valuesSource = valuesSource;
                topBucketsPerOrd[ordIdx] = result.topBuckets;
        private LongArray subsetSizes;
        String describe() {
        }
                    order,
            spare.term = Numbers.toUnsignedBigInteger(ordsEnum.value());
                metadata(),
        @Override
        }
                checkCancelled();
            return new BucketSignificancePriorityQueue<>(size);
    public StarTreeBucketCollector getStarTreeBucketCollector(
        }
            if (isKeyOrder(order) == false) {
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
                        long metricValue = docCountsIterator.nextValue();
                reduceOrder = InternalOrder.key(true);
        }
        final void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {
                order,
            int supersetSize = topReader.numDocs();
    @Override
                                if (bucketOrdinal < 0) { // already seen
        String describe() {
            }
        }
 * specific language governing permissions and limitations
                order,
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);
        @Override
            spare.updateScore(significanceHeuristic);
    }
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
                if (values.advanceExact(doc)) {
            }
                    bucketsInOrd,
import org.opensearch.common.lease.Releasables;
            return new LongTerms(
        ValuesSource.Numeric valuesSource,
         * Build an array of buckets for a particular ordinal. These arrays
            spare.supersetDf = backgroundFrequencies.freq(spare.term);
                Arrays.sort(topBuckets, reduceOrder.comparator());
        LongTermsResults(boolean showTermDocCountError) {
    @Override
import org.opensearch.search.internal.SearchContext;
                reduceOrder = order;
         * Resolve the doc values to collect results of this type.
    }
        @Override
         * Short description of the collection mechanism added to the profile
                    bucketsInOrd,
                BucketSelectionStrategy.SelectionInput<B> selectionInput = new BucketSelectionStrategy.SelectionInput<>(
            spare.docCount = docCount;
                otherDocCounts[ordIdx] = result.otherDocCount;
                metadata(),
        String describe() {
        DoubleTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
        @Override
        @Override
 * this work for additional information regarding copyright
        StandardTermsResultStrategy(boolean showTermDocCountError) {
        abstract void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException;
                otherDocCount,
import org.opensearch.search.aggregations.support.ValuesSource;
    private final ValuesSource.Numeric valuesSource;
        LongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
import org.opensearch.common.lease.Releasable;
        Supplier<SignificantLongTerms.Bucket> emptyBucketBuilder(long owningBucketOrd) {
        @Override
            : null;
                metadata(),
                format,
                bucketCountThresholds
    public InternalAggregation buildEmptyAggregation() {
        }
         * Turn the buckets into an aggregation result.
    @Override
            public void collectRange(int min, int max) throws IOException {
        add.accept("result_strategy", resultStrategy.describe());
