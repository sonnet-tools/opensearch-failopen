            protected long[] processHardBounds(long[] bounds) {
    private int skipListCollectorsUsed;
package org.opensearch.search.aggregations.bucket.histogram;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
    private final boolean keyed;
import org.opensearch.search.startree.StarTreeQueryHelper;
 * @see Rounding
    private final Rounding rounding;
            noOpCollectorsUsed++;
            skipListCollectorsUsed++;
        @Nullable LongBounds extendedBounds,
        }
        });
    private final LongKeyedBucketOrds bucketOrds;
    }
        multiValuedCollectorsUsed++;
 * The OpenSearch Contributors require contributions made to
                    }
            protected Function<Long, Long> bucketOrdProducer() {
    }
            // Important: use `rounding` here, not `shardRounding`
    public List<DimensionFilter> getDimensionFilters() {
    @Override
 * this work for additional information regarding copyright
        DateTimeUnitAdapter dateTimeUnitRounding = new DateTimeUnitAdapter(this.rounding.unit());
                metadata()
            .getDimensionValuesIterator(starTreeDateDimension);
                        collectStarTreeBucket(this, metricValue, bucketOrd, starTreeEntry);
    private static final Logger logger = LogManager.getLogger(DateHistogramAggregator.class);
                @Override
    private final LongBounds extendedBounds;
    /**
            name,
            ctx,
        add.accept("skip_list_collectors_used", skipListCollectorsUsed);
    public void doClose() {
 */
    private final ValuesSource.Numeric valuesSource;
 * this file be licensed under the Apache-2.0 license or a
     */
                buildRanges(context);
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(ctx, starTree);
        this.fieldIndexSort = this.fieldName == null ? false : context.getQueryShardContext().indexSortedOnField(fieldName);
            this.starTreeDateRoundingRequired = false;
        return new StarTreeBucketCollector(
        CompositeIndexFieldInfo supportedStarTree = getSupportedStarTree(this.context.getQueryShardContext());
        }
            : null;
import org.opensearch.search.startree.filter.DimensionFilter;
    }
                return super.processHardBounds(bounds, hardBounds);
import org.opensearch.search.aggregations.Aggregator;
            return new HistogramSkiplistLeafCollector(singleton, skipper, preparedRounding, bucketOrds, sub, this);
        String dimensionName = fieldName + "_" + rounding.shortName();
            // value source will be null for unmapped fields
        Rounding.Prepared preparedRounding,
            }
 * {@link Rounding}.
        boolean keyed,
        return buildAggregationsForVariableBuckets(owningBucketOrds, bucketOrds, (bucketValue, docCount, subAggregationResults) -> {
    @Override
import org.opensearch.common.Nullable;
                formatter,
        }
 */
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
                public void collect(int doc, long owningBucketOrd) throws IOException {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            return ScoreMode.COMPLETE;
        DocValuesSkipper skipper = null;
import org.apache.lucene.search.ScoreMode;
            }
            .filter(dim -> dim.getField().equals(fieldName))
                return canOptimize(valuesSourceConfig, rounding);
import java.util.function.Function;
import org.apache.lucene.index.DocValuesSkipper;
                @Override
                        collectValue(sub, doc, owningBucketOrd, preparedRounding.round(value));
        ) {
     */
            @Override
        } else {
            keyed,
                if (!valuesIterator.advanceExact(starTreeEntry)) {
    private boolean starTreeDateRoundingRequired = true;
        }
            protected Rounding getRounding(long low, long high) {
                if (values.advanceExact(doc)) {
import org.opensearch.search.aggregations.InternalAggregation;
        if (this.fieldName != null) {
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
            StarTreeBucketCollector starTreeBucketCollector = getStarTreeBucketCollector(ctx, supportedStarTree, null);
 * Licensed to Elasticsearch under one or more contributor
        );
        this.formatter = valuesSourceConfig.format();
                for (Aggregator aggregator : subAggregators) {
            this::incrementBucketDocCount,
            formatter,
        add.accept("no_op_collectors_used", noOpCollectorsUsed);
            ? fetchStarTreeCalendarUnit()
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
import java.util.Locale;
import org.apache.logging.log4j.Logger;
            @Override
    @Override
            .next();
                collectExistingBucket(sub, doc, bucketOrd);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private String fetchStarTreeCalendarUnit() {
            .iterator()
        if (valuesSource != null && valuesSource.needsScores()) {
            segmentMatchAll(context, ctx),
        SortedNumericStarTreeValuesIterator docCountsIterator = StarTreeQueryHelper.getDocCountsIterator(starTreeValues, starTree);
            .findFirst() // Get the first matching time dimension
                buckets,
            // the contract of the histogram aggregation is that shards must return buckets ordered by key in ascending order
        this.extendedBounds = extendedBounds;
        CardinalityUpperBound cardinality,
        }
            skipper = ctx.reader().getDocValuesSkipper(this.fieldName);
    @Override
        DateTimeUnitRounding rounding = starTreeDateDimension.findClosestValidInterval(dateTimeUnitRounding);
            }
 * not use this file except in compliance with the License.
import java.util.function.BiConsumer;
    private final BucketOrder order;
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
    }
 *
import org.apache.lucene.index.SortedNumericDocValues;
        AggregatorFactories factories,
    }
        ValuesSourceConfig valuesSourceConfig,
                        ? preparedRounding.round(valuesIterator.nextValue())
    }
            );
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.aggregations.AggregatorFactories;
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
            }
import java.util.Collections;
                        long rounded = preparedRounding.round(value);
 * SPDX-License-Identifier: Apache-2.0
            : null;
    ) throws IOException {
        if (rounding.shortName().equals(this.rounding.unit().shortName())) {
            protected boolean canOptimize() {
                        ((StarTreePreComputeCollector) aggregator.unwrapAggregator()).getStarTreeBucketCollector(ctx, starTree, this)
                    long dimensionValue = starTreeDateRoundingRequired
    private final boolean fieldIndexSort;
        String name,
    private int noOpCollectorsUsed;
                        long value = singleton.longValue();
        };
                    super.collect(stream, owningBucketOrd);
    public StarTreeBucketCollector getStarTreeBucketCollector(
import org.opensearch.search.DocValueFormat;
import java.util.Map;
            if (bucketOrd < 0) { // already seen
 * GitHub history for details.
                public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
    }
import org.opensearch.index.mapper.CompositeDataCubeFieldType;
    private void collectValue(LeafBucketCollector sub, int doc, long owningBucketOrd, long rounded) throws IOException {
 */
/**
                    }
            .getCompositeFieldTypes()
            };
import org.apache.lucene.index.NumericDocValues;
import org.opensearch.search.startree.filter.MatchAllFilter;
 * license agreements. See the NOTICE file distributed with
                bucketOrd = -1 - bucketOrd;
        this.fieldName = (valuesSource instanceof ValuesSource.Numeric.FieldData)
     * @return the size of the bucket in specified units, or 1.0 if unitSize is null
                minDocCount,
import org.opensearch.search.aggregations.bucket.HistogramSkiplistLeafCollector;
        this.order = order;
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
class DateHistogramAggregator extends BucketsAggregator implements SizedBucketAggregator, StarTreePreComputeCollector {
                    if (docCountsIterator.advanceExact(starTreeEntry)) {
            parentCollector == null ? StarTreeQueryHelper.getStarTreeResult(starTreeValues, context, getDimensionFilters()) : null
            return new InternalDateHistogram.Bucket(bucketValue, docCount, keyed, formatter, subAggregationResults);
                    int valuesCount = values.docValueCount();
 *    http://www.apache.org/licenses/LICENSE-2.0
            order,
import org.opensearch.index.compositeindex.datacube.DateDimension;
            protected void prepare() throws IOException {
        return new LeafBucketCollectorBase(sub, values) {
        super.collectDebugInfo(add);
 * specific language governing permissions and limitations
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {
            singleValuedCollectorsUsed++;
                }
            }
        // TODO: Stop using null here
            return LeafBucketCollector.NO_OP_COLLECTOR;
            InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = minDocCount == 0
    private final String fieldName;
            }
                    );
        this.hardBounds = hardBounds;
            @Override
 * under the License.
            minDocCount,
            }
        if (this.rounding.unit() == null) {
        }
 * @opensearch.internal
        // Original path for multi-valued fields
                public void collectRange(int min, int max) throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitRounding;
                }
        add.accept("total_buckets", bucketOrds.size());
            long bucketOrd = bucketOrds.add(owningBucketOrd, rounded);
            @Override
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
        }
            @Override
    public void collectDebugInfo(BiConsumer<String, Object> add) {
        super(name, factories, aggregationContext, parent, CardinalityUpperBound.MANY, metadata);
        Rounding rounding,
 * Unless required by applicable law or agreed to in writing,
        );
                        : valuesIterator.nextValue();
 * compatible open source license.
            collectableSubAggregators
            return 1.0;
        this.starTreeDateDimension = (context.getQueryShardContext().getStarTreeQueryContext() != null)
        }
                        long value = values.nextValue();
    /**
            public void setSubCollectors() throws IOException {
            }
            }
            public void collect(int doc, long owningBucketOrd) throws IOException {
    private int singleValuedCollectorsUsed;
    public ScoreMode scoreMode() {
    public InternalAggregation buildEmptyAggregation() {
                        long metricValue = docCountsIterator.nextValue();
                name,
        }, (owningBucketOrd, buckets) -> {
            Collections.emptyList(),
    }
                order,
            }
                        previousRounded = rounded;
    }
        filterRewriteOptimizationContext.populateDebugInfo(add);
            ? ((ValuesSource.Numeric.FieldData) valuesSource).getIndexFieldName()
        this.keyed = keyed;
            }
 *
        if (supportedStarTree != null) {
import org.opensearch.common.lease.Releasables;
            return true;
import static org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge.segmentMatchAll;
                }
import org.opensearch.search.aggregations.StarTreeBucketCollector;
            protected Rounding.Prepared getRoundingPrepared() {
                        assert rounded >= previousRounded;
    private final LongBounds hardBounds;
                super.collectRange(min, max);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                : null;
        long minDocCount,
                super.collect(stream, owningBucketOrd);
 */
            ? new InternalDateHistogram.EmptyBucketInfo(rounding, buildEmptySubAggregations(), extendedBounds)
            return null;
/*
            rounding.offset(),
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
            public void collectStarTreeEntry(int starTreeEntry, long owningBucketOrd) throws IOException {
            @Override
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
        Releasables.close(bucketOrds);
/*
        BucketOrder order,
            return new LeafBucketCollectorBase(sub, values) {
            return new InternalDateHistogram(
            metadata()
        if (hardBounds == null || hardBounds.contain(rounded)) {
            CollectionUtil.introSort(buckets, BucketOrder.key(true).comparator());
    }
}
import static org.opensearch.search.startree.StarTreeQueryHelper.getSupportedStarTree;
            starTreeValues,
 *
    @Override
    private int multiValuedCollectorsUsed;
 * Modifications Copyright OpenSearch Contributors. See
            @Override
                rounding.offset(),
        if (HistogramSkiplistLeafCollector.canUseSkiplist(hardBounds, parent, skipper, singleton)) {
import org.apache.lucene.index.LeafReaderContext;
                    return;
                }
        Aggregator parent,
        return dimensionName;
                    if (singleton.advanceExact(doc)) {
            .orElseThrow(() -> new AssertionError(String.format(Locale.ROOT, "Date dimension '%s' not found", fieldName)));
                    super.collectRange(min, max);
            .stream()
            StarTreeQueryHelper.preComputeBucketsWithStarTree(starTreeBucketCollector);
                    long previousRounded = Long.MIN_VALUE;
        };
            } else {
    @Override
import org.opensearch.search.aggregations.CardinalityUpperBound;
    // Collector usage tracking fields
                        collectValue(sub, doc, owningBucketOrd, rounded);
            emptyBucketInfo,
                @Override
        return StarTreeQueryHelper.collectDimensionFilters(new MatchAllFilter(fieldName, starTreeDateDimension), subAggregators);
import org.opensearch.search.aggregations.support.ValuesSource;
            public void collectRange(int min, int max) throws IOException {
        final SortedNumericDocValues values = valuesSource.longValues(ctx);
                        }
                return preparedRounding;
                return (key) -> bucketOrds.add(0, preparedRounding.round((long) key));
import org.opensearch.search.aggregations.bucket.filterrewrite.FilterRewriteOptimizationContext;
    DateHistogramAggregator(
                }
        Map<String, Object> metadata
        SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues
 * An aggregator for date values. Every date is rounded down using a configured
    private final FilterRewriteOptimizationContext filterRewriteOptimizationContext;
        if (singleton != null) {
import org.apache.lucene.util.CollectionUtil;
    private final DocValueFormat formatter;
            // Optimized path for single-valued fields
            @Override
    @Override
                        if (rounded == previousRounded) {
import java.io.IOException;
        if (unitSize != null) {
        }
        this.minDocCount = minDocCount;
 *
        };
                    for (int i = 0; i < valuesCount; ++i) {
    ) throws IOException {
    }
    private final Rounding.Prepared preparedRounding;
import org.opensearch.search.aggregations.bucket.filterrewrite.DateHistogramAggregatorBridge;
        DateDimension starTreeDateDimension = (DateDimension) compositeMappedFieldType.getDimensions()
        add.accept("single_valued_collectors_used", singleValuedCollectorsUsed);
        CompositeDataCubeFieldType compositeMappedFieldType = (CompositeDataCubeFieldType) context.mapperService()
import org.opensearch.search.aggregations.BucketOrder;
 *
        SearchContext aggregationContext,
            return preparedRounding.roundingSize(bucketOrds.get(bucket), unitSize);
 * ownership. Elasticsearch licenses this file to you under
        filterRewriteOptimizationContext = new FilterRewriteOptimizationContext(bridge, parent, subAggregators.length, context);
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.LogManager;
 * software distributed under the License is distributed on an
import java.util.List;
        return new InternalDateHistogram(
                            continue;
import org.opensearch.search.aggregations.LeafBucketCollector;
        this.preparedRounding = preparedRounding;
import org.apache.lucene.search.DocIdStream;
                }
        this.rounding = rounding;
        return filterRewriteOptimizationContext.tryOptimize(
import org.opensearch.common.Rounding;
        StarTreeBucketCollector parentCollector
    }
        add.accept("multi_valued_collectors_used", multiValuedCollectorsUsed);
        return super.scoreMode();
        @Nullable LongBounds hardBounds,
    protected boolean tryPrecomputeAggregationForLeaf(LeafReaderContext ctx) throws IOException {
        LeafReaderContext ctx,
        final NumericDocValues singleton = DocValues.unwrapSingleton(values);
        if (valuesSource == null) {
    private final String starTreeDateDimension;
    @Override
    @Override
                        long bucketOrd = bucketOrds.add(owningBucketOrd, dimensionValue);
    }
/*
                }
import org.opensearch.search.aggregations.StarTreePreComputeCollector;
        DateHistogramAggregatorBridge bridge = new DateHistogramAggregatorBridge() {
    public double bucketSize(long bucket, Rounding.DateTimeUnit unitSize) {
            : null;
                ? new InternalDateHistogram.EmptyBucketInfo(rounding.withoutOffset(), buildEmptySubAggregations(), extendedBounds)
                collectBucket(sub, doc, bucketOrd);
 * You may obtain a copy of the License at
        }
                keyed,
            @Override
                return rounding;
            }
                    this.subCollectors.add(
            @Override
    @Override
                    }
        CompositeIndexFieldInfo starTree,
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
     * The rounding prepared for rewriting the data in the shard.
        order.validate(this);
        InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = minDocCount == 0
import org.apache.lucene.index.DocValues;
                emptyBucketInfo,
    private final long minDocCount;
