        Releasables.close(states);
 * specific language governing permissions and limitations
        SearchContext context,  
        String name,
        if (bucketOrd >= states.size()) {
        if (valuesSource == null) {  
            return LeafBucketCollector.NO_OP_COLLECTOR;
    }
    AbstractTDigestPercentilesAggregator(  
 * not use this file except in compliance with the License.
abstract class AbstractTDigestPercentilesAggregator extends NumericMetricsAggregator.MultiValue {
        final SortedNumericDoubleValues values = ((ValuesSource.Numeric) valuesSource).doubleValues(ctx);
        this.keys = keys;
                if (values.advanceExact(doc)) {  
        return state;
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
import org.apache.lucene.index.LeafReaderContext;
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.ScoreMode;
 * this work for additional information regarding copyright
                }
    protected TDigestState getState(long bucketOrd) {
        super(name, context, parent, metadata);
    @Override
        }
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
/*  
    protected void doClose() {
                    final int valueCount = values.docValueCount();
import org.opensearch.common.util.ObjectArray;  
        if (state == null) {
import java.io.IOException;  
 *  
 *
 * You may obtain a copy of the License at  
                        state.add(values.nextValue());  
    ) throws IOException {
                    }
 * Base aggregator for the TDigest agg
import org.opensearch.common.util.BigArrays;
    protected ObjectArray<TDigestState> states;
                    for (int i = 0; i < valueCount; i++) {
    }  
        double compression,  
        return state;  
        this.formatter = formatter;
import org.opensearch.search.aggregations.support.ValuesSource;  
 * license agreements. See the NOTICE file distributed with
            @Override  
import org.opensearch.search.internal.SearchContext;
import org.opensearch.search.aggregations.Aggregator;  
    protected final boolean keyed;
            states.set(bucket, state);  
import org.opensearch.search.DocValueFormat;
        this.states = context.bigArrays().newObjectArray(1);  
        TDigestState state = states.get(bucket);  
    }  
    }
        return ArrayUtils.binarySearch(keys, key, 0.001);
 * @opensearch.internal  
    @Override
    public boolean hasMetric(String name) {  
/**  
 */  
        ValuesSource valuesSource,
    private static int indexOfKey(double[] keys, double key) {
        this.compression = compression;
 */
        final TDigestState state = states.get(bucketOrd);
        }
    protected final double[] keys;
    protected final ValuesSource valuesSource;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            return null;  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    }
 *
        this.keyed = keyed;
 * compatible open source license.
        return indexOfKey(keys, Double.parseDouble(name)) >= 0;
/*  
    protected final DocValueFormat formatter;
 */
 *
        DocValueFormat formatter,
import org.opensearch.common.util.ArrayUtils;
            public void collect(int doc, long bucket) throws IOException {
 * Unless required by applicable law or agreed to in writing,
import java.util.Map;
 * software distributed under the License is distributed on an
    }  
    @Override
            state = new TDigestState(compression);
 * The OpenSearch Contributors require contributions made to  
    }  
        Aggregator parent,
        }
package org.opensearch.search.aggregations.metrics;
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
    private TDigestState getExistingOrNewHistogram(final BigArrays bigArrays, long bucket) {
 * SPDX-License-Identifier: Apache-2.0
    public ScoreMode scoreMode() {  
        states = bigArrays.grow(states, bucket + 1);
                TDigestState state = getExistingOrNewHistogram(bigArrays, bucket);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.valuesSource = valuesSource;  
import org.opensearch.search.aggregations.LeafBucketCollector;
    }
import org.opensearch.common.lease.Releasables;  
        boolean keyed,
        };
        return new LeafBucketCollectorBase(sub, values) {
 * under the License.  
            }  
/*
        Map<String, Object> metadata  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 */  
}
        double[] keys,
        final BigArrays bigArrays = context.bigArrays();  
 * this file be licensed under the Apache-2.0 license or a
    protected final double compression;  
