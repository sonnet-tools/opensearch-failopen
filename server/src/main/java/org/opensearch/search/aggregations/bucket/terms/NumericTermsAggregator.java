                order,
import java.io.IOException;
        CompositeIndexFieldInfo supportedStarTree = StarTreeQueryHelper.getSupportedStarTree(this.context.getQueryShardContext());  
            return valuesSource.longValues(ctx);
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
        @Override
    public StarTreeBucketCollector getStarTreeBucketCollector(
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    @Override
            spare.bucketOrd = ordsEnum.ord();
        }
        SignificantLongTerms buildResult(long owningBucketOrd, long otherDocCoun, SignificantLongTerms.Bucket[] topBuckets) {
                bucketCountThresholds  
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {  
                if (values.advanceExact(doc)) {
                    this::buildPriorityQueue,  
            ContextIndexSearcher searcher = context.searcher();
            return new DoubleTerms(  
        add.accept("result_selection_strategy", resultSelectionStrategy);
            if (isKeyOrder(order) == false) {
    /**
                List.of(topBuckets),
        BucketOrder order,  
         * Short description of the collection mechanism added to the profile
                super.collectRange(min, max);  
        @Override  
            if (bucketCountThresholds.getMinDocCount() != 0) {
            StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, supportedStarTree, null);
                BucketSelectionStrategy.SelectionResult<B> result = strategy.selectTopBuckets(selectionInput);
                bucketCountThresholds
        }
import java.util.Arrays;
                    }
    ) throws IOException {
                bucketCountThresholds.getShardSize(),
    public InternalAggregation buildEmptyAggregation() {
                format,
import org.opensearch.search.aggregations.StarTreeBucketCollector;  
 */  
            }  
            );
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
                order,
        super(name, factories, aggregationContext, parent, bucketCountThresholds, order, format, subAggCollectMode, metadata);  
    }  
                Supplier<B> emptyBucketBuilder = emptyBucketBuilder(owningBucketOrds[ordIdx]);  
            return result;  
        @Override  
    }
        /**
            CardinalityUpperBound cardinality
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
        @Override
import org.opensearch.common.lease.Releasable;  
                    int valuesCount = values.docValueCount();
                name,  
            final BucketOrder reduceOrder;
                    NumericTermsAggregator.this::bucketDocCount,  
            return true;
        @Override
    }  
        LongTerms.Bucket[] buildBuckets(int size) {
import org.opensearch.common.util.LongArray;
    }  
                format,  
                reduceOrder = order;  
                        long bucketOrd = bucketOrds.add(owningBucketOrd, dimensionValue);  
                name,
public class NumericTermsAggregator extends TermsAggregator implements StarTreePreComputeCollector {
            }  
import org.opensearch.search.aggregations.bucket.terms.SignificanceLookup.BackgroundFrequencyForLong;
                    size,  
                for (Aggregator aggregator : subAggregators) {
        abstract void updateBucket(B spare, BucketOrdsEnum ordsEnum, long docCount) throws IOException;  
        @Override
        }  
                significanceHeuristic,  
import org.opensearch.search.aggregations.LeafBucketCollector;
                        for (int v = 0; v < valueCount; ++v) {
 * Unless required by applicable law or agreed to in writing,
                resultSelectionStrategy = result.actualStrategyUsed;
 *  
        DoubleTerms buildEmptyResult() {
            return new DoubleTerms.Bucket(0, 0, null, showTermDocCountError, 0, format);  
                    ordsEnum,
            super(showTermDocCountError);  
    public ScoreMode scoreMode() {  
            };  
                otherDocCount,  
            starTreeValues,  
                    (spare, ordsEnumParam, docCount) -> {
        @Override
                bucketCountThresholds
import org.apache.lucene.util.PriorityQueue;
        final PriorityQueue<B> buildPriorityQueue(int size) {
                );
        }  
                    partiallyBuiltBucketComparator
            return FieldData.toSortableLongBits(valuesSource.doubleValues(ctx));  
                    );
 * You may obtain a copy of the License at  
    abstract class ResultStrategy<R extends InternalAggregation, B extends InternalMultiBucketAggregation.InternalBucket>
            return "unsigned_long_terms";
        CompositeIndexFieldInfo starTree,
import org.opensearch.search.aggregations.BucketOrder;
    }
            return ScoreMode.COMPLETE;
                    );
                format,  
            );
        }  
         * output to help with debugging.
        ResultStrategy<R, B> {  
        @Override
                showTermDocCountError,  
            return "double_terms";
        SignificantLongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
         * Build an "empty" result. Only called if there isn't any data on this
                    order,
            );
         */
                        } catch (IOException e) {
        @Override
        DoubleTermsResults(boolean showTermDocCountError) {
        SignificantLongTerms.Bucket[] buildBuckets(int size) {  
            buildSubAggsForAllBuckets(topBucketsPerOrd, b -> b.bucketOrd, (b, aggs) -> b.aggregations = aggs);
            return this::buildEmptyBucket;  
            @Override  
                    }
                                } else {  
    abstract class StandardTermsResultStrategy<R extends InternalMappedTerms<R, B>, B extends InternalTerms.Bucket<B>> extends
import org.apache.lucene.index.LeafReaderContext;
                metadata(),
 * under the License.  
         * buckets. Those buckets will then be {@link #updateBucket updated}  
        }
        LeafBucketCollector wrapCollector(LeafBucketCollector primary) {  
        private InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        @Override
        }
    public void collectDebugInfo(BiConsumer<String, Object> add) {  
        void updateBucket(DoubleTerms.Bucket spare, BucketOrdsEnum ordsEnum, long docCount) {
            return valuesSource.longValues(ctx);
        abstract SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException;  
        @Override
                0,  
        SubAggCollectionMode subAggCollectMode,
            return new UnsignedLongTerms(
            public void collectRange(int min, int max) throws IOException {
            super(showTermDocCountError);  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
                bucketCountThresholds.getShardSize(),
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
                    size,
package org.opensearch.search.aggregations.bucket.terms;
            return valuesSource.longValues(ctx);  
 * Aggregate all docs that contain numeric terms  
import org.opensearch.search.aggregations.bucket.LocalBucketCountThresholds;
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            return new SignificantLongTerms.Bucket[size];
                            long value = values.nextValue();
                BucketSelectionStrategy.SelectionInput<B> selectionInput = new BucketSelectionStrategy.SelectionInput<>(
                reduceOrder = InternalOrder.key(true);
                BucketSelectionStrategy strategy = BucketSelectionStrategy.determine(
        return resultSelectionStrategy;
                }
                    partiallyBuiltBucketComparator,  
        /**
 * ownership. Elasticsearch licenses this file to you under  
                }  
            // we need to fill-in the blanks
import java.util.List;
            spare.term = NumericUtils.sortableLongToDouble(ordsEnum.value());
        /**
        };
    class UnsignedLongTermsResults extends StandardTermsResultStrategy<UnsignedLongTerms, UnsignedLongTerms.Bucket> {
                    bucketsInOrd,  
        @Override
            @Override
        /**
                bucketCountThresholds  
        UnsignedLongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
            public void collect(int doc, long owningBucketOrd) throws IOException {  
    }  
         */  
            long[] otherDocCounts = new long[owningBucketOrds.length];
                name,
            return () -> new SignificantLongTerms.Bucket(0, subsetSize, 0, supersetSize, 0, null, format, 0);
import org.opensearch.search.internal.SearchContext;  
                public void collect(int doc, long owningBucketOrd) throws IOException {  
                bucketCountThresholds.getShardSize(),  
                topBucketsPerOrd[ordIdx] = result.topBuckets;
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
        String describe() {
        abstract PriorityQueue<B> buildPriorityQueue(int size);  
            }
            // We need to account for the significance of a miss in our global stats - provide corpus size as context  
        return super.scoreMode();
        }  
                emptyList(),
        @Override
                        long val = values.nextValue();
    class SignificantLongTermsResults extends ResultStrategy<SignificantLongTerms, SignificantLongTerms.Bucket> {
/*
            spare.subsetDf = docCount;
 * this work for additional information regarding copyright
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {
        @Override
                otherDocCount,
        @Override
        @Override
        }
        /**  
        SignificantLongTermsResults(
        DoubleTerms.Bucket buildEmptyBucket() {
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
        ValuesSource.Numeric valuesSource,
        LongTerms buildEmptyResult() {  
import org.opensearch.index.fielddata.FieldData;  
            spare.bucketOrd = ordsEnum.ord();  
         * Collect extra entries for "zero" hit documents if they were requested  
                        try {  
/**
                    localBucketCountThresholds,  
                reduceOrder = InternalOrder.key(true);  
                }
                    bucketsInOrd,
import java.util.function.BiConsumer;
        SortedNumericStarTreeValuesIterator docCountsIterator = StarTreeQueryHelper.getDocCountsIterator(starTreeValues, starTree);
        }
                        long metricValue = docCountsIterator.nextValue();
                metadata(),
        abstract B[] buildBuckets(int size);
            long subsetSize = subsetSizes.get(owningBucketOrd);  
        DoubleTerms.Bucket[] buildBuckets(int size) {  
        return resultStrategy.buildAggregations(owningBucketOrds);
        Supplier<B> emptyBucketBuilder(long owningBucketOrd) {
        LongTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
        DoubleTerms.Bucket[][] buildTopBucketsPerOrd(int size) {
import static java.util.Collections.emptyList;
                            if ((longFilter == null) || (longFilter.accept(val))) {
         * are asigned to the value returned by {@link #buildTopBucketsPerOrd}.  
            backgroundFrequencies = significanceLookup.longLookup(context.bigArrays(), cardinality);
            return new UnsignedLongTerms(
        StarTreeBucketCollector parent
            @Override
            ? ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName()  
         */
    }
        }
            return new LongTerms.Bucket(0, 0, null, showTermDocCountError, 0, format);
            if (InternalOrder.isCountDesc(order) && bucketOrds.bucketsInOrd(owningBucketOrd) >= bucketCountThresholds.getRequiredSize()) {
                result[ordIdx] = buildResult(owningBucketOrds[ordIdx], otherDocCounts[ordIdx], topBucketsPerOrd[ordIdx]);
                    dimensionValue = NumericUtils.doubleToSortableLong(doubleValue);  
                            updateBucket(spare, ordsEnumParam, docCount);
                );
        }
        ) {
        private final long supersetSize;
        @Override
                    subsetSizes = context.bigArrays().grow(subsetSizes, owningBucketOrd + 1);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
import org.apache.lucene.index.SortedNumericDocValues;  
        abstract void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException;  
        SortedNumericDocValues values = resultStrategy.getValues(ctx);  
                }
                0,
import org.opensearch.search.aggregations.InternalAggregation;
            @Override  
        AggregatorFactories factories,
    class LongTermsResults extends StandardTermsResultStrategy<LongTerms, LongTerms.Bucket> {
            public void setSubCollectors() throws IOException {
                metadata(),
        }  
                    return;  
                    long previous = Long.MAX_VALUE;  
        }
    }
        LongTerms.Bucket buildEmptyBucket() {  
        }  
                0,  
                reduceOrder = InternalOrder.key(true);  
         */
            final BucketOrder reduceOrder;  
            return new DoubleTerms(
        void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {}
        UnsignedLongTerms buildResult(long owningBucketOrd, long otherDocCount, UnsignedLongTerms.Bucket[] topBuckets) {  
         */
        /**
    private final ResultStrategy<?, ?> resultStrategy;
         * Build the sub-aggregations into the buckets. This will usually  
            spare.docCount = docCount;
                format,
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
                            }
            }  
            SignificanceHeuristic significanceHeuristic,
        @Override
            return new DoubleTerms.Bucket[size];
                metadata(),
                0,
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        /**
        }
import org.opensearch.search.aggregations.CardinalityUpperBound;  
        }
        @Override
        /**
        }
        @Override  
            spare.bucketOrd = ordsEnum.ord();
         * for each collected bucket.
                int size = (int) Math.min(bucketsInOrd, localBucketCountThresholds.getRequiredSize());
         */
                                    collectExistingBucket(sub, doc, bucketOrdinal);
 * SPDX-License-Identifier: Apache-2.0
        super.collectDebugInfo(add);
import java.util.function.Supplier;  
            } else {
         * collected all of the buckets we'll collect all entries in the queue.
        }
                metadata(),
        @Override
                public void collectRange(int min, int max) throws IOException {  
    }  
                            if (longFilter == null || longFilter.accept(value)) {  
                                long bucketOrdinal = bucketOrds.add(owningBucketOrd, val);
            }
                BucketOrdsEnum ordsEnum = bucketOrds.ordsEnum(owningBucketOrds[ordIdx]);
        /**
            return new LongTerms.Bucket[size];
            SignificantLongTerms significantLongTerms = new SignificantLongTerms(  
            }
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;  
        }
                        }  
            // Back at the central reducer these properties will be updated with global stats
    public List<DimensionFilter> getDimensionFilters() {
         * this bucket ordinal.
                0,
                reduceOrder,
            SignificanceLookup significanceLookup,  
        @Override  
        abstract R buildResult(long owningBucketOrd, long otherDocCounts, B[] topBuckets);
                showTermDocCountError,
        return resultStrategy.buildEmptyResult();  
        Map<String, Object> metadata
        void updateBucket(UnsignedLongTerms.Bucket spare, BucketOrdsEnum ordsEnum, long docCount) {
 * Modifications Copyright OpenSearch Contributors. See  
                0,  
        DoubleTerms buildResult(long owningBucketOrd, long otherDocCount, DoubleTerms.Bucket[] topBuckets) {
 * Licensed to Elasticsearch under one or more contributor  
                metadata(),  
         * Build a {@link PriorityQueue} to sort the buckets. After we've  
        add.accept("result_strategy", resultStrategy.describe());
            @Override
        void updateBucket(LongTerms.Bucket spare, BucketOrdsEnum ordsEnum, long docCount) {
                return;
                    super.collectRange(min, max);
         */
                SortedNumericDocValues values = getValues(ctx);  
                                }
                if (valuesSource.isFloatingPoint()) {
                emptyList(),
        }  
                supersetSize,  
import static org.opensearch.search.aggregations.InternalOrder.isKeyOrder;  
import org.opensearch.search.aggregations.bucket.terms.heuristic.SignificanceHeuristic;  
         * Build a {@linkplain Supplier} that can be used to build "empty"
        @Override
                        }  
            // During shard-local down-selection we use subset/superset stats that are for this shard only
            spare.term = Numbers.toUnsignedBigInteger(ordsEnum.value());  
        @Override
                0,
    @Override
                Arrays.sort(topBuckets, reduceOrder.comparator());
    @Override  
        }  
            return new BucketPriorityQueue<>(size, partiallyBuiltBucketComparator);
        LongTerms buildResult(long owningBucketOrd, long otherDocCount, LongTerms.Bucket[] topBuckets) {  
                name,
        protected final boolean showTermDocCountError;
         * delegate to {@link #buildSubAggsForAllBuckets}.
        abstract LeafBucketCollector wrapCollector(LeafBucketCollector primary);  
import java.util.Map;  
 *
            this.showTermDocCountError = showTermDocCountError;
                if (valuesIterator.advanceExact(starTreeEntry) == false) {
            spare.docCount = docCount;  
                        collectStarTreeBucket(this, metricValue, bucketOrd, starTreeEntry);
        @Override  
        @Override
        return StarTreeQueryHelper.collectDimensionFilters(new MatchAllFilter(fieldName), subAggregators);
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {  
        this.fieldName = (this.valuesSource instanceof ValuesSource.Numeric.FieldData)
        StandardTermsResultStrategy(boolean showTermDocCountError) {  
            spare.term = ordsEnum.value();  
        this.resultStrategy = resultStrategy.apply(this); // ResultStrategy needs a reference to the Aggregator to do its job.
            return new UnsignedLongTerms.Bucket[size];
                showTermDocCountError,
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
            .getDimensionValuesIterator(fieldName);  
            spare.bucketOrd = ordsEnum.ord();
 * specific language governing permissions and limitations
                supersetSize,
            subsetSizes = context.bigArrays().newLongArray(1, true);
            );
                }
        @Override
        private final SignificanceHeuristic significanceHeuristic;
import org.opensearch.search.startree.filter.DimensionFilter;
        }
    private String resultSelectionStrategy;
        @Override
            supersetSize = significanceLookup.supersetSize();
            return new SignificantLongTerms(
                name,  
    }
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds.BucketOrdsEnum;
                }
    @Override
        @Override
import org.opensearch.search.aggregations.Aggregator;  
import org.apache.lucene.search.ScoreMode;
import org.opensearch.index.mapper.NumberFieldMapper;
        }
                format,
            if (isKeyOrder(order) == false) {
                long dimensionValue = valuesIterator.nextValue();
                subsetSizes.get(owningBucketOrd),
                    }
         * Resolve the doc values to collect results of this type.
import org.opensearch.search.DocValueFormat;
         * Build an array to hold the "top" buckets for each ordinal.  
            return new DoubleTerms.Bucket[size][];
                reduceOrder = order;
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude.LongFilter;  
                }  
                format,
    private final String fieldName;  
                bucketCountThresholds.getShardSize(),
        @Override
        @Override  
        }
        if (valuesSource != null && valuesSource.needsScores()) {
        private LongArray subsetSizes;  
        SearchContext aggregationContext,
import org.opensearch.search.aggregations.support.ValuesSource;
        return new StarTreeBucketCollector(
                                bucketOrds.add(owningBucketOrd, value);
                    emptyBucketBuilder,
        final void buildSubAggs(B[][] topBucketsPerOrd) throws IOException {  
            }
                    order,
import org.apache.lucene.search.DocIdStream;
 * @opensearch.internal
import org.opensearch.search.startree.filter.MatchAllFilter;  
 * not use this file except in compliance with the License.
        }
 */
    private final ValuesSource.Numeric valuesSource;  
                }
         * shard.  
        SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
        CardinalityUpperBound cardinality,  
        }
            }  
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
import org.apache.lucene.index.IndexReader;
            }
        }
        }
            return new UnsignedLongTerms.Bucket[size][];  
                                    bucketOrdinal = -1 - bucketOrdinal;
        @Override
            }
                otherDocCount,
            buildSubAggs(topBucketsPerOrd);
                }  
        }
            );  
                name,
                showTermDocCountError,  
        abstract Supplier<B> emptyBucketBuilder(long owningBucketOrd);  
    private final LongFilter longFilter;
                                    collectBucket(sub, doc, bucketOrdinal);
        @Override  
    public String getResultSelectionStrategy() {
        SortedNumericDocValues getValues(LeafReaderContext ctx) throws IOException {  
 * license agreements. See the NOTICE file distributed with
    ) throws IOException {  
 */  
                showTermDocCountError,
        abstract void buildSubAggs(B[][] topBucketsPerOrd) throws IOException;  
        UnsignedLongTerms.Bucket buildEmptyBucket() {  
            );
        Aggregator parent,  
        return resultStrategy.wrapCollector(new LeafBucketCollectorBase(sub, values) {
    }
            super(showTermDocCountError);
    }  
    public void doClose() {
                name,
                metadata(),  
                0,
                        dimensionValue
        final void collectZeroDocEntriesIfNeeded(long owningBucketOrd) throws IOException {  
        PriorityQueue<SignificantLongTerms.Bucket> buildPriorityQueue(int size) {
         */
         */
            if (isKeyOrder(order) == false) {
                name,
            : null;
                bucketCountThresholds
                super.collect(stream, owningBucketOrd);
            InternalAggregation[] result = new InternalAggregation[owningBucketOrds.length];
                // Only numeric & floating points are supported as of now in star-tree  
 *    http://www.apache.org/licenses/LICENSE-2.0
            return new LongTerms(
         * and required.
        ) {  
}
import java.math.BigInteger;  
                    double doubleValue = ((NumberFieldMapper.NumberFieldType) context.mapperService().fieldType(fieldName)).toDoubleValue(  
        }
        BucketCountThresholds bucketCountThresholds,
import org.opensearch.common.Numbers;
        final LeafBucketCollector wrapCollector(LeafBucketCollector primary) {
        abstract String describe();
                reduceOrder,
        @Override
 * The OpenSearch Contributors require contributions made to  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {  
/*  
    }  
        void buildSubAggs(SignificantLongTerms.Bucket[][] topBucketsPerOrd) throws IOException {  
            return new BucketSignificancePriorityQueue<>(size);
                    ordIdx,
        UnsignedLongTerms.Bucket[] buildBuckets(int size) {
        /**
        }  
            spare.docCount = docCount;
import java.util.function.Function;
            spare.term = ordsEnum.value();  
                @Override
     */
                bucketCountThresholds.getShardSize(),
                order,  
         * Turn the buckets into an aggregation result.  
        @Override  
                                if (bucketOrdinal < 0) { // already seen  
                order,
                format,  
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
                    subsetSizes.increment(owningBucketOrd, 1);  
                collectZeroDocEntriesIfNeeded(owningBucketOrds[ordIdx]);
                significanceHeuristic,
                        if (previous != val || i == 0) {  
                List.of(topBuckets),
                emptyList(),
                0,
    }  
        public void close() {
        }  
            } else {
                bucketCountThresholds  
            return new LongTerms(
        }
            B[][] topBucketsPerOrd = buildTopBucketsPerOrd(owningBucketOrds.length);
import org.opensearch.search.aggregations.InternalOrder;  
        Releasables.close(super::doClose, bucketOrds, resultStrategy);
        @Override
                return;
                metadata(),  
        SignificantLongTerms buildEmptyResult() {
     * Strategy for building results.  
import org.opensearch.search.aggregations.AggregatorFactories;
                reduceOrder = order;  
                order,
        abstract R buildEmptyResult();
/*
                // TODO: Add support for isBigInteger() when it gets supported in star-tree
                    for (int i = 0; i < valuesCount; ++i) {
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
        private final BackgroundFrequencyForLong backgroundFrequencies;  
 *
                emptyList(),  
        @Override  
        LeafReaderContext ctx,  
            spare.supersetDf = backgroundFrequencies.freq(spare.term);
                List.of(topBuckets),
        /**  
            );  
 * GitHub history for details.
        if (supportedStarTree != null) {
    @Override
import joptsimple.internal.Strings;  
        implements  
        @Override
            );
 * the Apache License, Version 2.0 (the "License"); you may
                @Override  
        @Override  
                Arrays.sort(topBuckets, reduceOrder.comparator());  
                    if (docCountsIterator.advanceExact(starTreeEntry)) {
        }
        abstract B buildEmptyBucket();  
         */
                bucketCountThresholds
    public NumericTermsAggregator(  
        @Override
                Arrays.sort(topBuckets, reduceOrder.comparator());
                            }  
        String name,
        UnsignedLongTerms buildEmptyResult() {  
 * software distributed under the License is distributed on an
import org.apache.lucene.util.NumericUtils;  
            } else {
    }  
            return new SignificantLongTerms.Bucket[size][];
                order,  
        abstract B[][] buildTopBucketsPerOrd(int size);
                    if (values.advanceExact(docId)) {
        /**
                    context.bucketSelectionStrategyFactor()
         */
        }
                order,
import org.opensearch.search.internal.ContextIndexSearcher;
        }  
import org.opensearch.common.lease.Releasables;
                order,  
                order,
        public final void close() {}
        LongTermsResults(boolean showTermDocCountError) {
                otherDocCounts[ordIdx] = result.otherDocCount;  
        String describe() {  
            return primary;  
                            throw new RuntimeException("Error updating bucket", e);  
                format,  
            }
            return new LongTerms.Bucket[size][];  
            LocalBucketCountThresholds localBucketCountThresholds = context.asLocalBucketCountThresholds(bucketCountThresholds);  
                showTermDocCountError,
        }  
            Releasable {
        }
    @Override  
        this.resultSelectionStrategy = Strings.EMPTY;
        }
        return false;  
            for (int ordIdx = 0; ordIdx < owningBucketOrds.length; ordIdx++) {  
        });
        @Override
                checkCancelled();
            return new UnsignedLongTerms.Bucket(BigInteger.ZERO, 0, null, showTermDocCountError, 0, format);
 */
                    super.collect(stream, owningBucketOrd);
            Releasables.close(backgroundFrequencies, subsetSizes);  
        }
                    this::buildBuckets,
         * Update fields in {@code spare} to reflect information collected for  
                long bucketsInOrd = bucketOrds.bucketsInOrd(owningBucketOrds[ordIdx]);  
                bucketCountThresholds  
        Function<NumericTermsAggregator, ResultStrategy<?, ?>> resultStrategy,  
                    super.collect(doc, owningBucketOrd);
            }  
         * information that this result type may need.
        String describe() {
                reduceOrder,  
        }
                bucketCountThresholds.getShardSize(),
        }
            int supersetSize = topReader.numDocs();  
                        }
        }  
        }  
        this.valuesSource = valuesSource;
        }  
            final BucketOrder reduceOrder;
        }
                            previous = val;
    }
         */
            this.significanceHeuristic = significanceHeuristic;  
                    this.subCollectors.add(  
                @Override
        IncludeExclude.LongFilter longFilter,
         * Build an array of buckets for a particular ordinal. These arrays
                    },
 * this file be licensed under the Apache-2.0 license or a
                List.of(topBuckets),
    @Override
        }
            for (LeafReaderContext ctx : context.searcher().getTopReaderContext().leaves()) {
    }
            return new LeafBucketCollectorBase(primary, null) {
                0,  
        DocValueFormat format,
         * Wrap the "standard" numeric terms collector to collect any more  
            parent == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
        void updateBucket(SignificantLongTerms.Bucket spare, BucketOrdsEnum ordsEnum, long docCount) throws IOException {
    private final LongKeyedBucketOrds bucketOrds;
        add.accept("total_buckets", bucketOrds.size());  
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
        UnsignedLongTermsResults(boolean showTermDocCountError) {
            }
import org.opensearch.search.startree.StarTreeQueryHelper;
            IndexReader topReader = searcher.getIndexReader();
        this.longFilter = longFilter;  
                        int valueCount = values.docValueCount();  
    class DoubleTermsResults extends StandardTermsResultStrategy<DoubleTerms, DoubleTerms.Bucket> {
 *
        String describe() {
            return significantLongTerms;
        Supplier<SignificantLongTerms.Bucket> emptyBucketBuilder(long owningBucketOrd) {
        @Override
            spare.updateScore(significanceHeuristic);  
            return "significant_terms";
        @Override  
            return "long_terms";
                for (int docId = 0; docId < ctx.reader().maxDoc(); ++docId) {
            StarTreeQueryHelper.preComputeBucketsWithStarTree(starTreeBucketCollector);  
