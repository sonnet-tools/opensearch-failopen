                                    collectExistingBucket(sub, doc, bucketOrd);
                                long bucketOrd = bucketOrds.add(owningBucketOrd, Double.doubleToLongBits(key));
 * SPDX-License-Identifier: Apache-2.0
                    // Is it possible for valuesCount to be > 1 here? Multiple ranges are encoded into the same BytesRef in the binary doc
import org.apache.lucene.index.LeafReaderContext;
            hardBounds,
        ValuesSourceConfig valuesSourceConfig,
        Map<String, Object> metadata
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    }
                                } else {
import org.opensearch.search.aggregations.BucketOrder;
import org.opensearch.index.mapper.RangeFieldMapper;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        List<RangeFieldMapper.Range> ranges = rangeType.decodeRanges(encodedRanges);
        DoubleBounds hardBounds,
            throw new IllegalArgumentException(
import org.opensearch.search.aggregations.AggregatorFactories;
 * this work for additional information regarding copyright
            @Override
                }
            extendedBounds,
        }
    @Override
 */
                                    bucketOrd = -1 - bucketOrd;
 *
                                    collectBucket(sub, doc, bucketOrd);
        SearchContext context,
            valuesSourceConfig.format(),
                if (values.advanceExact(doc)) {
                                : to;
                            assert from >= previousFrom : "Start of range not >= previous start";
                            final double startKey = Math.floor((effectiveFrom - offset) / interval);
            public void collect(int doc, long owningBucketOrd) throws IOException {
                    }
                                if (key == previousKey) {
 * You may obtain a copy of the License at
 *
        if (this.valuesSource.rangeType().isNumeric() == false) {
import org.opensearch.search.internal.SearchContext;
                            final double endKey = Math.floor((effectiveTo - offset) / interval);
        );
                                ? Double.max(from, hardBounds.getMin())
                            // The encoding should ensure that this assert is always true.
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
            }
 * @opensearch.internal
import org.opensearch.search.aggregations.CardinalityUpperBound;
import java.io.IOException;
            parent,
                                    continue;
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
                            }
            factories,
        super(
        AggregatorFactories factories,
}
 * Unless required by applicable law or agreed to in writing,
                    final int valuesCount = values.docValueCount();
                        BytesRef encodedRanges = values.nextValue();
 *
import org.apache.lucene.search.DocIdStream;
                    for (int i = 0; i < valuesCount; i++) {
                        for (RangeFieldMapper.Range range : ranges) {
        boolean keyed,
                                previousKey = endKey;
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Range) valuesSourceConfig.getValuesSource() : null;
 * under the License.
/*
import java.util.Map;
                                }
        String name,
            minDocCount,
            @Override
import org.apache.lucene.util.BytesRef;
                            final double effectiveTo = (hardBounds != null && hardBounds.getMax() != null)
 *
                                : from;
                            if (endKey > previousKey) {
            return LeafBucketCollector.NO_OP_COLLECTOR;
package org.opensearch.search.aggregations.bucket.histogram;
/**
            }
                            final Double to = rangeType.doubleValue(range.getTo());
public class RangeHistogramAggregator extends AbstractHistogramAggregator {
            cardinality,
        BucketOrder order,
 */
        };
        DoubleBounds extendedBounds,
                        double previousFrom = Double.NEGATIVE_INFINITY;
                                // Bucket collection identical to NumericHistogramAggregator, could be refactored
 * not use this file except in compliance with the License.
        double interval,
 * compatible open source license.
 * specific language governing permissions and limitations
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
 */
        double offset,
 * this file be licensed under the Apache-2.0 license or a
                super.collect(stream, owningBucketOrd);
/*
            metadata
import java.util.List;
import org.opensearch.search.aggregations.support.ValuesSource;
/*
import org.opensearch.search.aggregations.Aggregator;
                            final double effectiveFrom = (hardBounds != null && hardBounds.getMin() != null)
    public RangeHistogramAggregator(
                                ? Double.min(to, hardBounds.getMax())
    private final ValuesSource.Range valuesSource;
            context,
    }
 * Aggregate all docs that match a given range
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.LeafBucketCollector;
 * ownership. Elasticsearch licenses this file to you under
 */
                        }
            order,
            );
        final RangeType rangeType = valuesSource.rangeType();
            interval,
            keyed,
import org.opensearch.index.fielddata.SortedBinaryDocValues;
        return new LeafBucketCollectorBase(sub, values) {
                    assert valuesCount == 1 : "Value count for ranges should always be 1";
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.mapper.RangeType;
        // TODO: Stop using nulls here
            offset,
                    double previousKey = Double.NEGATIVE_INFINITY;
        CardinalityUpperBound cardinality,
 * Licensed to Elasticsearch under one or more contributor
        Aggregator parent,
    ) throws IOException {
            name,
                                }
        }
                            }
                    // values, so it isn't clear what we'd be iterating over.
                            final Double from = rangeType.doubleValue(range.getFrom());
        long minDocCount,
 *    http://www.apache.org/licenses/LICENSE-2.0
        final SortedBinaryDocValues values = valuesSource.bytesValues(ctx);
                            for (double key = Math.max(startKey, previousKey); key <= endKey; key++) {
                                if (bucketOrd < 0) { // already seen
                "Expected numeric range type but found non-numeric range [" + this.valuesSource.rangeType().name + "]"
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * The OpenSearch Contributors require contributions made to
 * license agreements. See the NOTICE file distributed with
        if (valuesSource == null) {
