        super(  
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
                }  
                        previousKey = key;
            metadata
        );  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            minDocCount,
 * {@code value}.
import org.opensearch.search.aggregations.support.ValuesSource;
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
package org.opensearch.search.aggregations.bucket.histogram;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.BucketOrder;
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.index.LeafReaderContext;
public class NumericHistogramAggregator extends AbstractHistogramAggregator {
 * KIND, either express or implied.  See the License for the
        }  
            }
        Aggregator parent,
import org.opensearch.search.aggregations.CardinalityUpperBound;
        double interval,
 * An aggregator for numeric values. For a given {@code interval},
 */
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
                            if (bucketOrd < 0) { // already seen  
            public void collectRange(int min, int max) throws IOException {  
            @Override  
        return new LeafBucketCollectorBase(sub, values) {
                super.collectRange(min, max);
/*  
            name,
        SearchContext context,
 * ownership. Elasticsearch licenses this file to you under  
    }
                        if (key == previousKey) {
/*
                                collectBucket(sub, doc, bucketOrd);
 * Licensed to Elasticsearch under one or more contributor  
    private final ValuesSource.Numeric valuesSource;  
 */  
import java.io.IOException;  
    @Override
                        }  
                        if (hardBounds == null || hardBounds.contain(key * interval)) {
        DoubleBounds hardBounds,
        AggregatorFactories factories,
        // TODO: Stop using null here
 */
        long minDocCount,  
            factories,
                            continue;
 *
        double offset,  
}
                    }
 * You may obtain a copy of the License at  
        BucketOrder order,
        Map<String, Object> metadata
            extendedBounds,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.internal.SearchContext;
            interval,  
                            long bucketOrd = bucketOrds.add(owningBucketOrd, Double.doubleToLongBits(key));
                            } else {  
                            }
            public void collect(int doc, long owningBucketOrd) throws IOException {
        boolean keyed,
        CardinalityUpperBound cardinalityUpperBound,  
 * not use this file except in compliance with the License.
 *  
            context,
            hardBounds,  
        if (valuesSource != null && valuesSource.needsScores()) {
 * software distributed under the License is distributed on an
    public ScoreMode scoreMode() {  
 * compatible open source license.
import org.opensearch.search.aggregations.Aggregator;
            parent,  
 * written as {@code interval * x + offset} and yet is less than or equal to  
    }  
                        double key = Math.floor((value - offset) / interval);
                    for (int i = 0; i < valuesCount; ++i) {  
            @Override
            return LeafBucketCollector.NO_OP_COLLECTOR;
            order,
        }
            return ScoreMode.COMPLETE;
                super.collect(stream, owningBucketOrd);
 * this work for additional information regarding copyright
        if (valuesSource == null) {  
            valuesSourceConfig.format(),
import org.opensearch.search.aggregations.LeafBucketCollector;  
 * this file be licensed under the Apache-2.0 license or a
    }
            }  
 *
                    double previousKey = Double.NEGATIVE_INFINITY;
 * under the License.  
    ) throws IOException {
 * {@code offset} and {@code value}, it returns the highest number that can be
        return super.scoreMode();
                if (values.advanceExact(doc)) {
        String name,  
            @Override  
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
/**  
            keyed,  
 * GitHub history for details.
                                collectExistingBucket(sub, doc, bucketOrd);
                    final int valuesCount = values.docValueCount();  
 * @opensearch.internal  
 * SPDX-License-Identifier: Apache-2.0
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        };  
        DoubleBounds extendedBounds,
                        assert key >= previousKey;  
                        double value = values.nextValue();
            offset,
 */  
import org.opensearch.search.aggregations.AggregatorFactories;  
        ValuesSourceConfig valuesSourceConfig,  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
import org.apache.lucene.search.ScoreMode;  
 * specific language governing permissions and limitations
                                bucketOrd = -1 - bucketOrd;
            }
    public NumericHistogramAggregator(
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.DocIdStream;
                        }  
    @Override
            cardinalityUpperBound,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
