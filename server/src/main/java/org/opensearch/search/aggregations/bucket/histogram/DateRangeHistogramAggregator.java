import org.opensearch.search.aggregations.bucket.terms.LongKeyedBucketOrds;
            keyed,  
            }  
 * ownership. Elasticsearch licenses this file to you under  
            ? new InternalDateHistogram.EmptyBucketInfo(rounding, buildEmptySubAggregations(), extendedBounds)
import java.util.function.BiConsumer;
import org.opensearch.index.fielddata.SortedBinaryDocValues;
 * You may obtain a copy of the License at  
    public void collectDebugInfo(BiConsumer<String, Object> add) {
                                : from;
            metadata()
        ValuesSourceConfig valuesSourceConfig,  
import org.opensearch.search.aggregations.AggregatorFactories;  
 *  
                    long previousKey = Long.MIN_VALUE;  
        // TODO: Stop using null here
 * @opensearch.internal  
                return new InternalDateHistogram(
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
            rounding.offset(),  
import org.opensearch.search.aggregations.Aggregator;
        if (valuesSource != null && valuesSource.needsScores()) {  
 * @see Rounding
        CardinalityUpperBound cardinality,  
/*
        this.order = order;
     */  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
                                : to;
        );
        }
    @Override
            emptyBucketInfo,
        long minDocCount,  
                            final long effectiveFrom = (hardBounds != null && hardBounds.getMin() != null)
                    metadata()
        return buildAggregationsForVariableBuckets(  
                    : null;
import org.opensearch.search.aggregations.BucketOrder;
                            final long endKey = preparedRounding.round(effectiveTo);  
        SearchContext aggregationContext,
 * this file be licensed under the Apache-2.0 license or a
                            final Long to = (Long) range.getTo();
    private final Rounding.Prepared preparedRounding;
    }
     * The rounding prepared for rewriting the data in the shard.
    private final ValuesSource.Range valuesSource;
                        List<RangeFieldMapper.Range> ranges = rangeType.decodeRanges(encodedRanges);
                formatter,
                            Long from = (Long) range.getFrom();
    private final DocValueFormat formatter;
 * license agreements. See the NOTICE file distributed with
            }
import static java.lang.Long.max;  
    }  
 *
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Aggregator parent,
 * Licensed to Elasticsearch under one or more contributor  
                                    collectBucket(sub, doc, bucketOrd);
        this.extendedBounds = extendedBounds;
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
        this.minDocCount = minDocCount;
import static java.lang.Long.min;
}
 * specific language governing permissions and limitations
                                ? min(to, hardBounds.getMax())  
    private final boolean keyed;  
 * {@link Rounding}.
        this.preparedRounding = preparedRounding;  
        };
                    ? new InternalDateHistogram.EmptyBucketInfo(rounding.withoutOffset(), buildEmptySubAggregations(), extendedBounds)  
    private final LongBounds hardBounds;
    DateRangeHistogramAggregator(
import org.opensearch.search.aggregations.LeafBucketCollector;
 *
 */
                "Expected date range type but found range type [" + this.valuesSource.rangeType().name + "]"  
        if (this.valuesSource.rangeType() != RangeType.DATE) {
        String name,  
        @Nullable LongBounds hardBounds,
import org.opensearch.index.mapper.RangeFieldMapper;
                                if (key == previousKey) {
                    rounding.offset(),
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Range) valuesSourceConfig.getValuesSource() : null;
 * SPDX-License-Identifier: Apache-2.0
            name,
 * compatible open source license.
        boolean keyed,
            (owningBucketOrd, buckets) -> {
    private final BucketOrder order;
                            for (long key = max(startKey, previousKey); key <= endKey; key = preparedRounding.nextRoundingValue(key)) {
            @Override
            throw new IllegalArgumentException(
            order,
        add.accept("total_buckets", bucketOrds.size());  
                    formatter,  
                        BytesRef encodedRanges = values.nextValue();  
 * not use this file except in compliance with the License.
                keyed,  
        this.hardBounds = hardBounds;  
    public InternalAggregation[] buildAggregations(long[] owningBucketOrds) throws IOException {
        Rounding rounding,
                InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = minDocCount == 0
            public void collect(int doc, long owningBucketOrd) throws IOException {  
                                previousKey = endKey;  
 * GitHub history for details.
            owningBucketOrds,
    }
                subAggregationResults
    @Override
        InternalDateHistogram.EmptyBucketInfo emptyBucketInfo = minDocCount == 0
import java.util.Map;  
                    // Is it possible for valuesCount to be > 1 here? Multiple ranges are encoded into the same BytesRef in the binary doc
                checkCancelled();
                if (values.advanceExact(doc)) {
            return ScoreMode.COMPLETE;
                                ? max(from, hardBounds.getMin())  
 *  
 */
/*
        Releasables.close(bucketOrds);
                                long bucketOrd = bucketOrds.add(owningBucketOrd, key);  
                }
                            }
        RangeType rangeType = valuesSource.rangeType();  
        BucketOrder order,
        order.validate(this);
        return super.scoreMode();  
                    assert valuesCount == 1 : "Value count for ranges should always be 1";
        if (valuesSource == null) {
        return new InternalDateHistogram(
                    }
    /**
        @Nullable LongBounds extendedBounds,
        Rounding.Prepared preparedRounding,  
                            }
 * An aggregator for date values. Every date is rounded down using a configured
 * under the License.  
            Collections.emptyList(),  
        super(name, factories, aggregationContext, parent, CardinalityUpperBound.MANY, metadata);
        this.keyed = keyed;  
    public void doClose() {  
                docCount,
    @Override
        AggregatorFactories factories,
import org.opensearch.common.lease.Releasables;  
                );  
 * Modifications Copyright OpenSearch Contributors. See  
    }  
            return LeafBucketCollector.NO_OP_COLLECTOR;  
                    name,  
package org.opensearch.search.aggregations.bucket.histogram;
        }
                        for (RangeFieldMapper.Range range : ranges) {  
                    int valuesCount = values.docValueCount();
            (bucketValue, docCount, subAggregationResults) -> new InternalDateHistogram.Bucket(  
import org.opensearch.common.Nullable;
        this.rounding = rounding;
import org.opensearch.common.Rounding;
                    order,
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
import org.apache.lucene.util.BytesRef;
import java.util.List;
 */
import org.apache.lucene.util.CollectionUtil;  
        bucketOrds = LongKeyedBucketOrds.build(context.bigArrays(), cardinality);
 * KIND, either express or implied.  See the License for the
                    minDocCount,  
                                }  
    private final Rounding rounding;  
        Map<String, Object> metadata
                            if (endKey > previousKey) {
                // Important: use `rounding` here, not `shardRounding`
import org.opensearch.search.internal.SearchContext;
                                } else {
    public ScoreMode scoreMode() {
            ),  
    @Override  
                            assert from >= previousFrom : "Start of range not >= previous start";  
    }
    @Override
import org.apache.lucene.index.LeafReaderContext;  
        }
                        }
        SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
 * this work for additional information regarding copyright
            bucketOrds,
                // value source will be null for unmapped fields  
                                    collectExistingBucket(sub, doc, bucketOrd);  
        this.formatter = valuesSourceConfig.format();  
            formatter,
class DateRangeHistogramAggregator extends BucketsAggregator {
                    emptyBucketInfo,
        return new LeafBucketCollectorBase(sub, values) {
import org.opensearch.search.aggregations.support.ValuesSource;
 * Unless required by applicable law or agreed to in writing,
                            // The encoding should ensure that this assert is always true.
                            final long startKey = preparedRounding.round(effectiveFrom);
 * software distributed under the License is distributed on an
import org.opensearch.search.DocValueFormat;
            );
    private final long minDocCount;
 * The OpenSearch Contributors require contributions made to  
            : null;  
import org.opensearch.index.mapper.RangeType;  
                        long previousFrom = Long.MIN_VALUE;
import org.opensearch.search.aggregations.bucket.BucketsAggregator;  
                CollectionUtil.introSort(buckets, BucketOrder.key(true).comparator());
                                    bucketOrd = -1 - bucketOrd;
 * the Apache License, Version 2.0 (the "License"); you may
                // the contract of the histogram aggregation is that shards must return buckets ordered by key in ascending order  
        );
/**  
    public InternalAggregation buildEmptyAggregation() {  
                                if (bucketOrd < 0) { // already seen
                            final long effectiveTo = (hardBounds != null && hardBounds.getMax() != null)
                                }
                                // Bucket collection identical to NumericHistogramAggregator, could be refactored
    }
import org.opensearch.search.aggregations.InternalAggregation;  
    private final LongBounds extendedBounds;  
                    keyed,
                    buckets,
            minDocCount,
                                    continue;  
import java.io.IOException;  
                bucketValue,
 */  
    ) throws IOException {
import org.apache.lucene.search.ScoreMode;
import org.opensearch.search.aggregations.CardinalityUpperBound;
                    // values, so it isn't clear what we'd be iterating over.  
    private final LongKeyedBucketOrds bucketOrds;  
                    for (int i = 0; i < valuesCount; i++) {
import java.util.Collections;
/*  
