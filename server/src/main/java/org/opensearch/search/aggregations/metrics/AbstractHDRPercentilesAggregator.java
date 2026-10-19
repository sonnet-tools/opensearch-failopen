        DocValueFormat formatter,
import org.opensearch.common.util.BigArrays;
            public void collect(int doc, long bucket) throws IOException {
            @Override  
    protected final ValuesSource valuesSource;
        final DoubleHistogram state = states.get(bucketOrd);
 */  
                }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 *
    protected void doClose() {
package org.opensearch.search.aggregations.metrics;
    protected final double[] keys;
        Releasables.close(states);
        final SortedNumericDoubleValues values = ((ValuesSource.Numeric) valuesSource).doubleValues(ctx);
        return state;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        DoubleHistogram state = states.get(bucket);
               level). In the future we could expose the range as an
 * compatible open source license.
            state = new DoubleHistogram(numberOfSignificantValueDigits);  
    @Override  
    public ScoreMode scoreMode() {
 * The OpenSearch Contributors require contributions made to  
        ValuesSource valuesSource,
 */
        return new LeafBucketCollectorBase(sub, values) {
        return indexOfKey(keys, Double.parseDouble(name)) >= 0;
        final BigArrays bigArrays = context.bigArrays();
}
import org.HdrHistogram.DoubleHistogram;  
 * Unless required by applicable law or agreed to in writing,
                    for (int i = 0; i < valueCount; i++) {
import org.opensearch.search.DocValueFormat;
            return null;  
    }
    private static int indexOfKey(double[] keys, double key) {  
    protected ObjectArray<DoubleHistogram> states;
        if (bucketOrd >= states.size()) {
            }  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.internal
import org.opensearch.search.aggregations.Aggregator;  
import java.io.IOException;  
 * not use this file except in compliance with the License.
            states.set(bucket, state);  
 * Licensed to Elasticsearch under one or more contributor  
               the data range increases. Resize operations should be
        this.numberOfSignificantValueDigits = numberOfSignificantValueDigits;
/*  
 *  
    protected final boolean keyed;  
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.support.ValuesSource;  
            return LeafBucketCollector.NO_OP_COLLECTOR;  
    }  
        Map<String, Object> metadata
import org.apache.lucene.index.LeafReaderContext;
 *
    protected final int numberOfSignificantValueDigits;
        boolean keyed,  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    @Override
import org.opensearch.common.lease.Releasables;  
        }
/*
        states = bigArrays.grow(states, bucket + 1);  
import org.opensearch.common.util.ObjectArray;  
/*  
 * Base aggregator for HDR percentiles agg  
import org.opensearch.common.util.ArrayUtils;
                        state.recordValue(values.nextValue());  
 */  
             */
        }
 * license agreements. See the NOTICE file distributed with
    }  
    }
        String name,  
        double[] keys,
                if (values.advanceExact(doc)) {  
 */  
    AbstractHDRPercentilesAggregator(
abstract class AbstractHDRPercentilesAggregator extends NumericMetricsAggregator.MultiValue {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        SearchContext context,
        return ArrayUtils.binarySearch(keys, key, 0.001);
    public boolean hasMetric(String name) {  
import java.util.Map;
    protected final DocValueFormat format;  
        this.states = context.bigArrays().newObjectArray(1);
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.LeafBucketCollector;
               initialisation and doesn't need resizing.  
        this.keys = keys;  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
    }
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;  
        return state;
               option on the request so the histogram can be fixed at
        super(name, context, parent, metadata);
    @Override
        this.valuesSource = valuesSource;
    @Override  
 * this file be licensed under the Apache-2.0 license or a
                    }
                DoubleHistogram state = getExistingOrNewHistogram(bigArrays, bucket);
        if (valuesSource == null) {
        Aggregator parent,  
 * under the License.  
                    final int valueCount = values.docValueCount();
import org.opensearch.search.internal.SearchContext;
        if (state == null) {
            /* Set the histogram to autosize so it can resize itself as
        this.keyed = keyed;  
        int numberOfSignificantValueDigits,
               rare as the histogram buckets are exponential (on the top  
/**
    }
        };
 * ownership. Elasticsearch licenses this file to you under  
    protected DoubleHistogram getState(long bucketOrd) {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
        this.format = formatter;
import org.apache.lucene.search.ScoreMode;
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    }
    }  
        }
            state.setAutoResize(true);
 *
    private DoubleHistogram getExistingOrNewHistogram(final BigArrays bigArrays, long bucket) {
 * SPDX-License-Identifier: Apache-2.0
    ) throws IOException {  
