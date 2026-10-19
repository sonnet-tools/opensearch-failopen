    }
}
        if (valuesSource == null) {
                            for (long key = max(startKey, previousKey); key <= endKey; key = preparedRounding.nextRoundingValue(key)) {
import org.opensearch.search.aggregations.bucket.BucketsAggregator;
    private final long minDocCount;
                InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = minDocCount == 0
 * not use this file except in compliance with the License.
    }
                            final long effectiveFrom = (hardBounds != null && hardBounds.getMin() != null)
import org.opensearch.common.lease.Releasables;
    public InternalAggregation buildEmptyAggregation() {
        AggregatorFactories factories,
 *
 */
 * The OpenSearch Contributors require contributions made to
                    minDocCount,
 * An aggregator for date values. Every date is rounded down using a configured
 * specific language governing permissions and limitations
import org.opensearch.search.DocValueFormat;
import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
import org.opensearch.index.mapper.RangeType;
import org.apache.lucene.search.ScoreMode;
    @Override
                keyed,
import java.io.IOException;
import org.opensearch.index.mapper.RangeFieldMapper;
                // the contract of the histogram aggregation is that shards must return buckets ordered by key in ascending order
        this.keyed = keyed;
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
    /**
    public ScoreMode scoreMode() {
                "Expected date range type but found range type [" + this.valuesSource.rangeType().name + "]"
        super(name, factories, aggregationContext, parent, CardinalityUpperBound.MANY, metadata);
            formatter,
 * KIND, either express or implied.  See the License for the
        @Nullable LongBounds hardBounds,
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.search.aggregations.CardinalityUpperBound;
                                    continue;
        return super.scoreMode();
    private final LongKeyedBucketOrds bucketOrds;
        this.formatter = valuesSourceConfig.format();
import static java.lang.Long.max;
    DateRangeHistogramAggregator(
        boolean keyed,
    private final boolean keyed;
            rounding.offset(),
                        long previousFrom = Long.MIN_VALUE;
 * license agreements. See the NOTICE file distributed with
        this.minDocCount = minDocCount;
                    metadata()
                // Important: use `rounding` here, not `shardRounding`
    private final Rounding.Prepared preparedRounding;
    private final BucketOrder order;
        Map<String, Object> metadata
 */
                    // values, so it isn't clear what we'd be iterating over.
                    int valuesCount = values.docValueCount();
        SearchContext aggregationContext,
    private final Rounding rounding;
                docCount,
class DateRangeHistogramAggregator extends BucketsAggregator {
                        BytesRef encodedRanges = values.nextValue();
        this.preparedRounding = preparedRounding;
        if (valuesSource != null && valuesSource.needsScores()) {
 * Unless required by applicable law or agreed to in writing,
/*
                    rounding.offset(),
                        }
    private final LongBounds hardBounds;
    public void doClose() {
 * Modifications Copyright OpenSearch Contributors. See
        SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
                    order,
    private final DocValueFormat formatter;
            owningBucketOrds,
import org.opensearch.search.aggregations.InternalAggregation;
 * this work for additional information regarding copyright
 * GitHub history for details.
 * @opensearch.internal
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        Rounding.Prepared preparedRounding,
            ? new InternalDateHistogram.EmptyBucketInfo(rounding, buildEmptySubAggregations(), extendedBounds)
        }
 * ownership. Elasticsearch licenses this file to you under
                bucketValue,
                    emptyBucketInfo,
                                ? max(from, hardBounds.getMin())
/*
 *
import org.apache.lucene.index.LeafReaderContext;
                                    bucketOrd = -1 - bucketOrd;
        );
 *
 * {@link Rounding}.
                // value source will be null for unmapped fields
                CollectionUtil.introSort(buckets, BucketOrder.key(true).comparator());
        ValuesSourceConfig valuesSourceConfig,
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
    private final LongBounds extendedBounds;
        this.order = order;
        Rounding rounding,
        Releasables.close(bucketOrds);
                );
                            if (endKey > previousKey) {
                    : null;
        return new LeafBucketCollectorBase(sub, values) {
import org.opensearch.index.fielddata.SortedBinaryDocValues;
 * compatible open source license.
        return new InternalDateHistogram(
package org.opensearch.search.aggregations.bucket.histogram;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                : to;
                                previousKey = endKey;
import java.util.Map;
                                if (bucketOrd < 0) { // already seen
        order.validate(this);
        this.hardBounds = hardBounds;
            }
import org.apache.lucene.util.CollectionUtil;
                formatter,
            throw new IllegalArgumentException(
 * You may obtain a copy of the License at
            Collections.emptyList(),
    }
                }
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
import java.util.function.BiConsumer;
import org.opensearch.search.aggregations.LeafBucketCollector;
                            Long from = (Long) range.getFrom();
 */
            name,
    @Override
                    keyed,
 * SPDX-License-Identifier: Apache-2.0
                                if (key == previousKey) {
                            // The encoding should ensure that this assert is always true.
        if (this.valuesSource.rangeType() != RangeType.DATE) {
    private final ValuesSource.Range valuesSource;
                    ? new InternalDateHistogram.EmptyBucketInfo(rounding.withoutOffset(), buildEmptySubAggregations(), extendedBounds)
import org.opensearch.search.aggregations.AggregatorFactories;
                    formatter,
                                    collectExistingBucket(sub, doc, bucketOrd);
                checkCancelled();
    @Override
                                // Bucket collection identical to NumericHistogramAggregator, could be refactored
        this.extendedBounds = extendedBounds;
                                    collectBucket(sub, doc, bucketOrd);
        RangeType rangeType = valuesSource.rangeType();
     * The rounding prepared for rewriting the data in the shard.
import static java.lang.Long.min;
                            }
        };
import java.util.Collections;
import org.apache.lucene.util.BytesRef;
                    assert valuesCount == 1 : "Value count for ranges should always be 1";
                                }
    @Override
/*
            return LeafBucketCollector.NO_OP_COLLECTOR;
    @Override
            order,
                                }
    }
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Range) valuesSourceConfig.getValuesSource() : null;
    public void collectDebugInfo(BiConsumer<String, Object> add) {
    }
                            final long startKey = preparedRounding.round(effectiveFrom);
import org.opensearch.search.internal.SearchContext;
 *    http://www.apache.org/licenses/LICENSE-2.0
                            final long effectiveTo = (hardBounds != null && hardBounds.getMax() != null)
        return buildAggregationsForVariableBuckets(
                    // Is it possible for valuesCount to be > 1 here? Multiple ranges are encoded into the same BytesRef in the binary doc
                                } else {
 *
            ),
            minDocCount,
            );
            return ScoreMode.COMPLETE;
        BucketOrder order,
import org.opensearch.search.aggregations.Aggregator;
                    }
    @Override
        @Nullable LongBounds extendedBounds,
 * under the License.
    ) throws IOException {
            public void collect(int doc, long owningBucketOrd) throws IOException {
        add.accept("total_buckets", bucketOrds.size());
            : null;
    }
 * this file be licensed under the Apache-2.0 license or a
            (owningBucketOrd, buckets) -> {
        Aggregator parent,
        this.rounding = rounding;
import org.opensearch.search.aggregations.support.ValuesSource;
                                ? min(to, hardBounds.getMax())
                        for (RangeFieldMapper.Range range : ranges) {
                    for (int i = 0; i < valuesCount; i++) {
     */
                subAggregationResults
                                long bucketOrd = bucketOrds.add(owningBucketOrd, key);
 * the Apache License, Version 2.0 (the "License"); you may
        InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = minDocCount == 0
        }
        }
            metadata()
import java.util.List;
                        List<RangeFieldMapper.Range> ranges = rangeType.decodeRanges(encodedRanges);
        long minDocCount,
                return new InternalDateHistogram(
            keyed,
            bucketOrds,
            }
 * @see Rounding
                    long previousKey = Long.MIN_VALUE;
import org.opensearch.common.Nullable;
                            final long endKey = preparedRounding.round(effectiveTo);
        // TODO: Stop using null here
                    name,
 *
                            }
 */
            (bucketValue, docCount, subAggregationResults) -> new InternalDateHistogram.Bucket(
                    buckets,
            emptyBucketInfo,
        CardinalityUpperBound cardinality,
                            assert from >= previousFrom : "Start of range not >= previous start";
 * Licensed to Elasticsearch under one or more contributor
                            final Long to = (Long) range.getTo();
                if (values.advanceExact(doc)) {
import org.opensearch.common.Rounding;
                                : from;
            @Override
        );
    }
        String name,
/**
