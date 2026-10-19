import org.opensearch.search.aggregations.metrics.MetricsAggregator;  
            final String[] fieldNames = valuesSources.fieldNames();
                        stats.set(bucket, stat);
            return buildEmptyAggregation();  
 * KIND, either express or implied.  See the License for the
        Aggregator parent,
import org.opensearch.common.util.BigArrays;
             * return a map of field names and data
    public InternalAggregation buildEmptyAggregation() {  
                return true;
                            return false;  
 *
        Releasables.close(stats);  
            public void collectRange(int min, int max) throws IOException {  
import org.apache.lucene.index.LeafReaderContext;  
        String name,
 */
            final double[] fieldVals = new double[fieldNames.length];  
                        if (value == Double.NEGATIVE_INFINITY) {
 * The OpenSearch Contributors require contributions made to  
            @Override
 * You may obtain a copy of the License at  
            stats = context.bigArrays().newObjectArray(1);  
                    if (doubleValues.advanceExact(doc)) {
        if (valuesSources != null && !valuesSources.isEmpty()) {
/*  
                for (int i = 0; i < fieldVals.length; ++i) {  
        if (valuesSources == null || bucket >= stats.size()) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.support.ValuesSource;
 *    http://www.apache.org/licenses/LICENSE-2.0
}
    }
            private boolean includeDocument(int doc) throws IOException {
    public void doClose() {
                        fieldVals[i] = value;
 */  
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
    @Override  
                    }
 * Modifications Copyright OpenSearch Contributors. See  
                    final NumericDoubleValues doubleValues = values[i];
                super.collectRange(min, max);
    @Override
 * this work for additional information regarding copyright
 */
 * not use this file except in compliance with the License.
        final NumericDoubleValues[] values = new NumericDoubleValues[valuesSources.fieldNames().length];
            this.valuesSources = null;
                    }
                    RunningStats stat = stats.get(bucket);
            this.valuesSources = new ArrayValuesSource.NumericArrayValuesSource(valuesSources, multiValueMode);
            /**
 * compatible open source license.
        SearchContext context,
        if (valuesSources == null) {
 **/
            }
import org.opensearch.search.aggregations.Aggregator;
                    } else {  
import org.opensearch.index.fielddata.NumericDoubleValues;  
 * Licensed to Elasticsearch under one or more contributor  
    }  
        }
                if (includeDocument(doc)) {
            @Override  
import java.util.TreeMap;
        TreeMap<String, ValuesSource.Numeric> valuesSources,  
 * ownership. Elasticsearch licenses this file to you under  
    public ScoreMode scoreMode() {
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
        return (valuesSources != null && valuesSources.needsScores()) ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
                }  
/**  
    }
 *  
    }  
import org.apache.lucene.search.ScoreMode;
        return new LeafBucketCollectorBase(sub, values) {
 *
            values[i] = valuesSources.getField(i, ctx);
    }
        return new InternalMatrixStats(name, 0, null, null, metadata(), null);
    ObjectArray<RunningStats> stats;
import java.io.IOException;
import org.opensearch.search.aggregations.support.ArrayValuesSource;
                        final double value = doubleValues.doubleValue();  
import org.opensearch.search.aggregations.InternalAggregation;  
                super.collect(stream, owningBucketOrd);
import org.opensearch.common.util.ObjectArray;
                // get fields
             */  
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
        }
import org.opensearch.search.aggregations.LeafBucketCollector;
        return new InternalMatrixStats(name, stats.size(), stats.get(bucket), null, metadata(), valuesSources.fieldNames());
            public void collect(int doc, long bucket) throws IOException {  
package org.opensearch.search.aggregations.matrix.stats;
import org.apache.lucene.search.DocIdStream;
    @Override
 * GitHub history for details.
    private final ArrayValuesSource.NumericArrayValuesSource valuesSources;
        }  
        MultiValueMode multiValueMode,  
    /** Multiple ValuesSource with field names */
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(name, context, parent, metadata);  
            }
        }  
        final BigArrays bigArrays = context.bigArrays();
                    // add document fields to correlation stats
 * under the License.  
                        return false;
                        stat = new RunningStats(fieldNames, fieldVals);
                    if (stat == null) {  
    MatrixStatsAggregator(
    }
 * specific language governing permissions and limitations
    public InternalAggregation buildAggregation(long bucket) {
import org.opensearch.common.lease.Releasables;  
            }
                        }
        } else {
        };  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
final class MatrixStatsAggregator extends MetricsAggregator {  
            }  
                // loop over fields
    @Override  
                            // TODO: Fix matrix stats to treat neg inf as any other value
        Map<String, Object> metadata
                    stats = bigArrays.grow(stats, bucket + 1);  
    ) throws IOException {
        for (int i = 0; i < values.length; ++i) {  
            return LeafBucketCollector.NO_OP_COLLECTOR;
                    } else {  
 * Metric Aggregation for computing the pearson product correlation coefficient between multiple fields
    /** array of descriptive stats, per shard, needed to compute the correlation */
import java.util.Map;  
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.MultiValueMode;
                }  
                        stat.add(fieldNames, fieldVals);
import org.opensearch.search.internal.SearchContext;  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    @Override
