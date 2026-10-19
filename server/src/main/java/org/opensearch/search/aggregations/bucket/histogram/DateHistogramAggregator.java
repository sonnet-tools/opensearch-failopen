            keyed,
        LeafReaderContext ctx,  
        };
import org.opensearch.common.Rounding;
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
            @Override
            ? fetchStarTreeCalendarUnit()
        return filterRewriteOptimizationContext.tryOptimize(
import org.apache.logging.log4j.LogManager;  
/**
            public void collect(int doc, long owningBucketOrd) throws IOException {  
 *  
     */  
            return new HistogramSkiplistLeafCollector(singleton, skipper, preparedRounding, bucketOrds, sub, this);
 *
        Map<String, Object> metadata
        DateDimension starTreeDateDimension = (DateDimension) compositeMappedFieldType.getDimensions()
    }  
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
                public void collect(int doc, long owningBucketOrd) throws IOException {
     * @return the size of the bucket in specified units, or 1.0 if unitSize is null
    private int noOpCollectorsUsed;
    private final ValuesSource.Numeric valuesSource;
        CompositeIndexFieldInfo starTree,
            @Override
        super.collectDebugInfo(add);
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
import org.opensearch.search.aggregations.CardinalityUpperBound;  
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
            order,
                rounding.offset(),  
    public StarTreeBucketCollector getStarTreeBucketCollector(
        );
 * An aggregator for date values. Every date is rounded down using a configured  
                ? new InternalDateHistogram.EmptyBucketInfo(rounding.withoutOffset(), buildEmptySubAggregations(), extendedBounds)
                return (key) -> bucketOrds.add(0, preparedRounding.round((long) key));
    // Collector usage tracking fields  
            @Override  
    private String fetchStarTreeCalendarUnit() {
                }  
                collectExistingBucket(sub, doc, bucketOrd);
 * software distributed under the License is distributed on an
        this.fieldName = (valuesSource instanceof ValuesSource.Numeric.FieldData)  
            }
import org.apache.lucene.index.DocValues;
import org.opensearch.search.aggregations.InternalAggregation;
import java.util.function.Function;  
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
        InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = minDocCount == 0
    @Override  
        if (singleton != null) {
        if (HistogramSkiplistLeafCollector.canUseSkiplist(hardBounds, parent, skipper, singleton)) {  
import org.opensearch.search.DocValueFormat;
            return true;
                        long rounded = preparedRounding.round(value);  
import org.opensearch.search.aggregations.Aggregator;  
        order.validate(this);
    private boolean starTreeDateRoundingRequired = true;  
        AggregatorFactories factories,
        this.formatter = valuesSourceConfig.format();  
        this.starTreeDateDimension = (context.getQueryShardContext().getStarTreeQueryContext() != null)
        }
import org.opensearch.search.aggregations.bucket.HistogramSkiplistLeafCollector;
 *
        }
 * {@link Rounding}.
    private final LongBounds hardBounds;  
        @Nullable LongBounds extendedBounds,
            .orElseThrow(() -> new AssertionError(String.format(Locale.ROOT, "Date dimension '%s' not found", fieldName)));  
            return new InternalDateHistogram.Bucket(bucketValue, docCount, keyed, formatter, subAggregationResults);  
/*
            : null;  
                return rounding;
/*  
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
            formatter,  
 */
 * specific language governing permissions and limitations
            noOpCollectorsUsed++;
            // Important: use `rounding` here, not `shardRounding`  
            return new InternalDateHistogram(
        }
    @Override
                return canOptimize(valuesSourceConfig, rounding);
            : null;
        this.minDocCount = minDocCount;
            .iterator()  
        this.rounding = rounding;
 * this work for additional information regarding copyright
import java.util.List;
            ? ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName()
    DateHistogramAggregator(  
                        assert rounded >= previousRounded;
import org.apache.lucene.index.LeafReaderContext;
 * this file be licensed under the Apache-2.0 license or a
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
            .next();
        SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
                }
    private final Rounding rounding;  
    private final long minDocCount;
                @Override  
import java.util.Locale;  
            ? new InternalDateHistogram.EmptyBucketInfo(rounding, buildEmptySubAggregations(), extendedBounds)  
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
                name,
        // TODO: Stop using null here
    }  
    }
            // Optimized path for single-valued fields  
                buckets,  
                    }  
import java.util.Map;
    @Override
                }
    private int singleValuedCollectorsUsed;
        if (unitSize != null) {  
        }  
        if (this.rounding.unit() == null) {  
                : null;  
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
            StarTreeQueryHelper.preComputeBucketsWithStarTree(starTreeBucketCollector);
            }
     * The rounding prepared for rewriting the data in the shard.
        return dimensionName;
            segmentMatchAll(context, ctx),
            .findFirst() // Get the first matching time dimension
        }  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
import org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge;
            }
        }
        SortedNumericStarTreeValuesIterator docCountsIterator = StarTreeQueryHelper.getDocCountsIterator(starTreeValues, starTree);
                        : valuesIterator.nextValue();  
            name,  
        add.accept("skip_list_collectors_used", skipListCollectorsUsed);
        DocValuesSkipper skipper = null;
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
import java.util.Collections;
                order,
import org.apache.logging.log4j.Logger;
    }
            InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = minDocCount == 0
            long bucketOrd = bucketOrds.add(owningBucketOrd, rounded);
                    this.subCollectors.add(  
import org.opensearch.index.compositeindex.datacube.DateDimension;
 * You may obtain a copy of the License at  
                        collectValue(sub, doc, owningBucketOrd, preparedRounding.round(value));
                        long value = values.nextValue();
        filterRewriteOptimizationContext.populateDebugInfo(add);  
            }
        }
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;  
    private int skipListCollectorsUsed;
                super.collect(stream, owningBucketOrd);
            rounding.offset(),
        return new StarTreeBucketCollector(
                    long dimensionValue = starTreeDateRoundingRequired
 *
        this.order = order;
        SearchContext aggregationContext,
import org.opensearch.search.aggregations.StarTreeBucketCollector;
    public void doClose() {
import org.apache.lucene.index.DocValuesSkipper;  
        }
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                keyed,  
                if (values.advanceExact(doc)) {
                }  
    private final String starTreeDateDimension;
        }  
                    super.collect(stream, owningBucketOrd);
        final SortedNumericDocValues values = valuesSource.longValues(ctx);  
import org.apache.lucene.search.ScoreMode;
            protected Rounding getRounding(long low, long high) {
            }
        if (valuesSource != null && valuesSource.needsScores()) {
    }
        this.fieldIndexSort = this.fieldName == null ? false : context.getQueryShardContext().indexSortedOnField(fieldName);  
 * @see Rounding  
            protected Function<Long, Long> bucketOrdProducer() {
            protected Rounding.Prepared getRoundingPrepared() {  
    private final DocValueFormat formatter;
            }
            // value source will be null for unmapped fields
import org.opensearch.common.lease.Releasables;  
                    );
    public ScoreMode scoreMode() {
        boolean keyed,  
 * license agreements. See the NOTICE file distributed with
            .getCompositeFieldTypes()
            public void setSubCollectors() throws IOException {
            return preparedRounding.roundingSize(bucketOrds.get(bucket), unitSize);
        long minDocCount,
                if (!valuesIterator.advanceExact(starTreeEntry)) {
    /**
        return StarTreeQueryHelper.collectDimensionFilters(new MatchAllFilter(fieldName, starTreeDateDimension), subAggregators);
            metadata()
    public void collectDebugInfo(BiConsumer<String, Object> add) {  
        return new LeafBucketCollectorBase(sub, values) {
 * not use this file except in compliance with the License.
    @Override
import org.apache.lucene.search.DocIdStream;
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;  
import org.opensearch.search.startree.filter.MatchAllFilter;
package org.opensearch.search.aggregations.bucket.histogram;
import org.opensearch.search.startree.StarTreeQueryHelper;
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
                }
    public List<DimensionFilter> getDimensionFilters() {  
                }
 * SPDX-License-Identifier: Apache-2.0
                @Override
    @Override
                }
    private final boolean keyed;  
            emptyBucketInfo,
 */
            } else {
import org.opensearch.search.startree.filter.DimensionFilter;  
    ) throws IOException {  
        if (valuesSource == null) {  
        CompositeDataCubeFieldType compositeMappedFieldType = (CompositeDataCubeFieldType) context.mapperService()
                    for (int i = 0; i < valuesCount; ++i) {
            collectableSubAggregators  
        Releasables.close(bucketOrds);
    private final FilterRewriteOptimizationContext filterRewriteOptimizationContext;
            }
            starTreeValues,  
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);
import org.apache.lucene.util.CollectionUtil;  
                return super.processHardBounds(bounds, hardBounds);  
        this.extendedBounds = extendedBounds;
                        if (rounded == previousRounded) {
class DateHistogramAggregator extends BucketsAggregator implements SizedBucketAggregator, StarTreePreComputeCollector {
            minDocCount,  
    public double bucketSize(long bucket, Rounding.DateTimeUnit unitSize) {
    private final boolean fieldIndexSort;
import org.opensearch.common.Nullable;
                    }
                            continue;  
            @Override
            @Override
import org.apache.lucene.index.SortedNumericDocValues;  
                emptyBucketInfo,
    @Override  
        this.hardBounds = hardBounds;  
        multiValuedCollectorsUsed++;  
        @Nullable LongBounds hardBounds,  
                        ? preparedRounding.round(valuesIterator.nextValue())
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
import org.opensearch.search.aggregations.support.ValuesSource;
import java.io.IOException;  
        if (hardBounds == null || hardBounds.contain(rounded)) {  
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {  
                return preparedRounding;
            .stream()  
import org.opensearch.search.internal.SearchContext;
import static org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge.segmentMatchAll;
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
                formatter,
        if (supportedStarTree != null) {
        Rounding rounding,  
    ) throws IOException {  
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;  
        this.preparedRounding = preparedRounding;  
    }
    }  
        super(name, factories, aggregationContext, parent, CardinalityUpperBound.MANY, metadata);
        CardinalityUpperBound cardinality,
        }, (owningBucketOrd, buckets) -> {
                @Override
            protected void prepare() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See  
                        collectValue(sub, doc, owningBucketOrd, rounded);
            return 1.0;  
    private final LongKeyedBucketOrds bucketOrds;
            protected long[] processHardBounds(long[] bounds) {
            .filter(dim -> dim.getField().equals(fieldName))
        // Original path for multi-valued fields
                super.collectRange(min, max);  
            StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, supportedStarTree, null);  
    }  
        String dimensionName = fieldName + "_" + rounding.shortName();
import java.util.function.BiConsumer;
    private final Rounding.Prepared preparedRounding;
    private final LongBounds extendedBounds;
            }  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
    }
    private static final Logger logger = LogManager.getLogger(DateHistogramAggregator.class);
        Rounding.Prepared preparedRounding,
                collectBucket(sub, doc, bucketOrd);  
 * KIND, either express or implied.  See the License for the
    }
        add.accept("total_buckets", bucketOrds.size());
            parentCollector == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
        if (rounding.shortName().equals(this.rounding.unit().shortName())) {
        BucketOrder order,
import org.opensearch.search.aggregations.AggregatorFactories;
import org.opensearch.search.aggregations.bucket.BucketsAggregator;  
        add.accept("multi_valued_collectors_used", multiValuedCollectorsUsed);  
        }  
 * Licensed to Elasticsearch under one or more contributor  
            );
        ValuesSourceConfig valuesSourceConfig,
     */  
 * Unless required by applicable law or agreed to in writing,
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {  
            skipListCollectorsUsed++;
 */  
            @Override
            @Override
            singleValuedCollectorsUsed++;
            }
                        long bucketOrd = bucketOrds.add(owningBucketOrd, dimensionValue);
                    super.collectRange(min, max);  
    private void collectValue(LeafBucketCollector sub, int doc, long owningBucketOrd, long rounded) throws IOException {
            // the contract of the histogram aggregation is that shards must return buckets ordered by key in ascending order
                    int valuesCount = values.docValueCount();
            return LeafBucketCollector.NO_OP_COLLECTOR;
        filterRewriteOptimizationContext = new FilterRewriteOptimizationContext(bridge, parent, subAggregators.length, context);
 * GitHub history for details.
        };
 * under the License.  
            if (bucketOrd < 0) { // already seen
        return super.scoreMode();
            this.starTreeDateRoundingRequired = false;  
 * ownership. Elasticsearch licenses this file to you under  
                minDocCount,
import org.apache.lucene.index.NumericDocValues;
        StarTreeBucketCollector parentCollector
        };  
        });  
            return new LeafBucketCollectorBase(sub, values) {
import org.opensearch.search.aggregations.BucketOrder;
            return ScoreMode.COMPLETE;  
    private final BucketOrder order;
        } else {
            }
                bucketOrd = -1 - bucketOrd;  
    public InternalAggregation buildEmptyAggregation() {
 * @opensearch.internal
        String name,
import org.opensearch.search.aggregations.LeafBucketCollector;
    @Override
                        }
        return buildAggregationsForVariableBuckets(owningBucketOrds, bucketOrds, (bucketValue, docCount, subAggregationResults) -> {
            : null;
                    }
        return new InternalDateHistogram(
                        previousRounded = rounded;  
            @Override  
                        collectStarTreeBucket(this, metricValue, bucketOrd, starTreeEntry);
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {  
                for (Aggregator aggregator : subAggregators) {
                public void collectRange(int min, int max) throws IOException {
        Aggregator parent,  
                        long metricValue = docCountsIterator.nextValue();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
            };
    @Override  
 */  
                buildRanges(context);  
            }  
                        long value = singleton.longValue();  
            }  
                metadata()
            Collections.emptyList(),
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
 * compatible open source license.
                    long previousRounded = Long.MIN_VALUE;  
/*
            ctx,  
 *
            protected boolean canOptimize() {  
            CollectionUtil.introSort(buckets, BucketOrder.key(true).comparator());  
        );  
}  
        ) {
        add.accept("single_valued_collectors_used", singleValuedCollectorsUsed);
                    if (docCountsIterator.advanceExact(starTreeEntry)) {
            .getDimensionValuesIterator(starTreeDateDimension);  
    private final String fieldName;  
        if (this.fieldName != null) {  
    private int multiValuedCollectorsUsed;  
            @Override  
    }  
            skipper = ctx.reader().getDocValuesSkipper(this.fieldName);
                    return;  
            public void collectRange(int min, int max) throws IOException {
        add.accept("no_op_collectors_used", noOpCollectorsUsed);
    @Override
            return null;
        this.keyed = keyed;  
            @Override  
        DateHistogramAggregatorBridge bridge = new DateHistogramAggregatorBridge() {
        DateTimeUnitAdapter dateTimeUnitRounding = new DateTimeUnitAdapter(this.rounding.unit());
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
            @Override
        DateTimeUnitRounding rounding = starTreeDateDimension.findClosestValidInterval(dateTimeUnitRounding);  
 * The OpenSearch Contributors require contributions made to  
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
                    if (singleton.advanceExact(doc)) {
            this::incrementBucketDocCount,
