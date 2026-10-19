import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        super(  
    }
 * compatible open source license.
                            final double endKey = Math.floor((effectiveTo - offset) / interval);
            @Override  
                        for (RangeFieldMapper.Range range : ranges) {
import java.util.List;  
 */
                            final Double from = rangeType.doubleValue(range.getFrom());
 *  
        }
                                : to;
 * GitHub history for details.
                                    bucketOrd = -1 - bucketOrd;  
 */
                        double previousFrom = Double.NEGATIVE_INFINITY;  
import java.io.IOException;
                                previousKey = endKey;
                                if (key == previousKey) {  
        ValuesSourceConfig valuesSourceConfig,  
import org.opensearch.search.aggregations.AggregatorFactories;
                            if (endKey > previousKey) {  
        Map<String, Object> metadata
            metadata
import org.apache.lucene.util.BytesRef;  
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Range) valuesSourceConfig.getValuesSource() : null;
import org.apache.lucene.index.LeafReaderContext;
            public void collect(int doc, long owningBucketOrd) throws IOException {
 * this work for additional information regarding copyright
        final SortedBinaryDocValues values = valuesSource.bytesValues(ctx);  
            extendedBounds,
                    double previousKey = Double.NEGATIVE_INFINITY;
    private final ValuesSource.Range valuesSource;  
            context,
        long minDocCount,  
 * Aggregate all docs that match a given range
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    ) throws IOException {
                            // The encoding should ensure that this assert is always true.  
/*
        BucketOrder order,
            }  
public class RangeHistogramAggregator extends AbstractHistogramAggregator {
                                }
                                    collectBucket(sub, doc, bucketOrd);  
 * Modifications Copyright OpenSearch Contributors. See
        AggregatorFactories factories,
            parent,  
            minDocCount,
        boolean keyed,
                                long bucketOrd = bucketOrds.add(owningBucketOrd, Double.doubleToLongBits(key));
                    // Is it possible for valuesCount to be > 1 here? Multiple ranges are encoded into the same BytesRef in the binary doc  
            return LeafBucketCollector.NO_OP_COLLECTOR;
 * Licensed to Elasticsearch under one or more contributor  
                                } else {
        );  
                            final Double to = rangeType.doubleValue(range.getTo());
    protected LeafBucketCollector getLeafCollector(LeafReaderContext ctx, LeafBucketCollector sub) throws IOException {
                                if (bucketOrd < 0) { // already seen
                    assert valuesCount == 1 : "Value count for ranges should always be 1";  
        }
        final RangeType rangeType = valuesSource.rangeType();
import org.opensearch.search.aggregations.Aggregator;
package org.opensearch.search.aggregations.bucket.histogram;
import org.opensearch.search.aggregations.BucketOrder;  
/*  
        };
                        BytesRef encodedRanges = values.nextValue();
                                ? Double.min(to, hardBounds.getMax())
                            for (double key = Math.max(startKey, previousKey); key <= endKey; key++) {
                                : from;
                                    collectExistingBucket(sub, doc, bucketOrd);
import org.opensearch.index.mapper.RangeType;  
                "Expected numeric range type but found non-numeric range [" + this.valuesSource.rangeType().name + "]"
 * KIND, either express or implied.  See the License for the
            keyed,  
 * ownership. Elasticsearch licenses this file to you under  
            valuesSourceConfig.format(),
            name,
                super.collect(stream, owningBucketOrd);
                        List<RangeFieldMapper.Range> ranges = rangeType.decodeRanges(encodedRanges);
                    // values, so it isn't clear what we'd be iterating over.
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                    for (int i = 0; i < valuesCount; i++) {  
import org.opensearch.search.aggregations.LeafBucketCollector;
    public RangeHistogramAggregator(
/*  
                            }
                                    continue;
        if (this.valuesSource.rangeType().isNumeric() == false) {  
                            }
 * specific language governing permissions and limitations
            cardinality,
                }  
/**  
                if (values.advanceExact(doc)) {
        double interval,
                            final double effectiveFrom = (hardBounds != null && hardBounds.getMin() != null)  
        String name,  
 *
            factories,
            throw new IllegalArgumentException(
            hardBounds,  
 */  
                                // Bucket collection identical to NumericHistogramAggregator, could be refactored  
}  
import org.opensearch.search.aggregations.CardinalityUpperBound;
import org.apache.lucene.search.DocIdStream;
            }
 * license agreements. See the NOTICE file distributed with
        if (valuesSource == null) {  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
        CardinalityUpperBound cardinality,  
                        }  
                                }
 * @opensearch.internal  
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.search.aggregations.support.ValuesSource;
                                ? Double.max(from, hardBounds.getMin())
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
                    final int valuesCount = values.docValueCount();
import org.opensearch.index.mapper.RangeFieldMapper;
                            final double startKey = Math.floor((effectiveFrom - offset) / interval);  
            @Override  
        // TODO: Stop using nulls here
            order,
        SearchContext context,
 *
                    }
 */  
        double offset,  
 * The OpenSearch Contributors require contributions made to  
            interval,  
        DoubleBounds extendedBounds,
            );  
 * under the License.  
                            assert from >= previousFrom : "Start of range not >= previous start";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    }
                            final double effectiveTo = (hardBounds != null && hardBounds.getMax() != null)  
        Aggregator parent,
        return new LeafBucketCollectorBase(sub, values) {
            offset,
 * not use this file except in compliance with the License.
import org.opensearch.index.fielddata.SortedBinaryDocValues;
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 *
        DoubleBounds hardBounds,
