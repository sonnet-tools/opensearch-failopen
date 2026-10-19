        }  
 */
                            double value = values.nextValue();
                    maxes.set(bucket, max);  
/**
 * specific language governing permissions and limitations
 * compatible open source license.
        }
                mins.set(0, minimum);
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
        Map<String, Object> metadata
            maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);  
                case avg:
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.support.ValuesSource;
                            kahanSummation.add(value);
                    compensations.set(bucket, kahanSummation.delta());
    @Override
                    mins.set(bucket, min);
                    if (values.advanceExact(doc)) {  
        final BigArrays bigArrays = context.bigArrays();  
                return maxes.get(owningBucketOrd);
                    sums.set(bucket, kahanSummation.value());  
            switch (InternalStats.Metrics.resolve(name)) {
        final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
 * Modifications Copyright OpenSearch Contributors. See  
                double minimum = mins.get(0);  
}
                double[] min = { mins.get(bucket) };
                    compensations = bigArrays.resize(compensations, overSize);  
                growStats(bucket);  
            mins.fill(0, mins.size(), Double.POSITIVE_INFINITY);
/*
            public void collect(int doc, long bucket) throws IOException {  
                        final int valuesCount = values.docValueCount();  
class StatsAggregator extends NumericMetricsAggregator.MultiValue {
        };
            return LeafBucketCollector.NO_OP_COLLECTOR;
        return new InternalStats(name, 0, 0, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, format, metadata());
        this.format = valuesSourceConfig.format();
import org.opensearch.search.aggregations.LeafBucketCollector;
    final DocValueFormat format;
    }  
import org.opensearch.common.util.LongArray;  
            }  
                double maximum = maxes.get(0);
                        counts.increment(0, valuesCount);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                double compensation = compensations.get(bucket);
import org.opensearch.common.lease.Releasables;  
    }
        }
    StatsAggregator(  
                for (int doc = min; doc < max; doc++) {
            @Override
    @Override
                case max:  
                return counts.get(owningBucketOrd);
            public void collect(DocIdStream stream, long bucket) throws IOException {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
        ValuesSourceConfig valuesSourceConfig,
import java.io.IOException;
import org.opensearch.search.aggregations.InternalAggregation;
                kahanSummation.reset(sum, compensation);
    public InternalAggregation buildAggregation(long bucket) {
                case sum:
                    throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
    @Override
 * You may obtain a copy of the License at  
            case max:  
        Aggregator parent,
            }
                    mins = bigArrays.resize(mins, overSize);
            case sum:
import java.util.Map;  
                            kahanSummation.add(value);  
        super(name, context, parent, metadata);
    DoubleArray maxes;
                    final long overSize = BigArrays.overSize(bucket + 1);  
            counts = bigArrays.newLongArray(1, true);  
            case count:  
    DoubleArray sums;
                    mins.fill(from, overSize, Double.POSITIVE_INFINITY);  
        SearchContext context,  
                        }  
                compensations.set(bucket, kahanSummation.delta());  
                maxes.set(0, maximum);  
    public void doClose() {
import org.apache.lucene.search.ScoreMode;
                    sums = bigArrays.resize(sums, overSize);
import org.opensearch.search.internal.SearchContext;  
        }
            mins = bigArrays.newDoubleArray(1, false);  
            case avg:
                    maxes = bigArrays.resize(maxes, overSize);
        return new LeafBucketCollectorBase(sub, values) {
/*
                growStats(bucket);
                        max = Math.max(max, value);
                        for (int i = 0; i < valuesCount; i++) {  
            return false;
                default:
        switch (InternalStats.Metrics.resolve(name)) {
                }
 * GitHub history for details.
                    }
 *
 *
                    final long from = counts.size();
                    double max = maxes.get(bucket);
    ) throws IOException {  
                sums.set(0, kahanSummation.value());  
                    return Double.NEGATIVE_INFINITY;
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;  
/*  
    @Override  
                return sums.get(owningBucketOrd) / counts.get(owningBucketOrd);  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * SPDX-License-Identifier: Apache-2.0
 *
            InternalStats.Metrics.resolve(name);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
 * Unless required by applicable law or agreed to in writing,
            @Override
                maxes.set(bucket, max[0]);
        if (valuesSource == null) {  
                mins.set(bucket, min[0]);
    LongArray counts;  
import org.opensearch.search.aggregations.Aggregator;  
                            maximum = Math.max(maximum, value);
                compensations.set(0, kahanSummation.delta());
 * ownership. Elasticsearch licenses this file to you under  
            }
 */  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;  
    }
 * @opensearch.internal
import org.opensearch.search.DocValueFormat;
        if (valuesSource == null || owningBucketOrd >= counts.size()) {
                        kahanSummation.add(value);
                            max[0] = Math.max(max[0], value);
                    maxes.fill(from, overSize, Double.NEGATIVE_INFINITY);
 *  
                            minimum = Math.min(minimum, value);
 * this work for additional information regarding copyright
                    }  
            private void growStats(long bucket) {  
                if (bucket >= counts.size()) {
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
            case min:
 * KIND, either express or implied.  See the License for the
    @Override
    public boolean hasMetric(String name) {
    }  
                return sums.get(owningBucketOrd);  
 */
                // accurate than naive summation.
    public InternalAggregation buildEmptyAggregation() {  
            sums = bigArrays.newDoubleArray(1, true);
 * the Apache License, Version 2.0 (the "License"); you may
                    if (values.advanceExact(doc)) {
                });
                sums.set(bucket, kahanSummation.value());
            return buildEmptyAggregation();  
                        final int valuesCount = values.docValueCount();
    }  
                stream.forEach((doc) -> {
        // TODO: stop using nulls here
        }
            return true;
            }  
            @Override
                    return Double.NaN;  
            }  
    @Override
        return new InternalStats(name, counts.get(bucket), sums.get(bucket), mins.get(bucket), maxes.get(bucket), format, metadata());
                    counts = bigArrays.resize(counts, overSize);
import org.opensearch.common.util.DoubleArray;
                // Compute the sum of double values with Kahan summation algorithm which is more
        String name,
import org.opensearch.common.util.BigArrays;
package org.opensearch.search.aggregations.metrics;
                case min:
        if (valuesSource == null || bucket >= sums.size()) {
                double sum = sums.get(bucket);  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                case count:  
                    return Double.POSITIVE_INFINITY;
                            min[0] = Math.min(min[0], value);  
            final BigArrays bigArrays = context.bigArrays();
                    final int valuesCount = values.docValueCount();
        }
                    }
 * this file be licensed under the Apache-2.0 license or a
                            double value = values.nextValue();
                    counts.increment(bucket, valuesCount);
                if (values.advanceExact(doc)) {  
                        min = Math.min(min, value);  
        try {  
 * under the License.  
            default:
                        }
    @Override
                growStats(0);
                        for (int i = 0; i < valuesCount; i++) {
        Releasables.close(counts, maxes, mins, sums, compensations);  
 */  
            public void collectRange(int min, int max) throws IOException {  
                    for (int i = 0; i < valuesCount; i++) {  
 * software distributed under the License is distributed on an
            compensations = bigArrays.newDoubleArray(1, true);
                    double min = mins.get(bucket);  
                }
        if (valuesSource != null) {
                }
import org.apache.lucene.search.DocIdStream;
                return mins.get(owningBucketOrd);
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
            maxes = bigArrays.newDoubleArray(1, false);
    }
    DoubleArray compensations;
    public ScoreMode scoreMode() {  
                throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
    DoubleArray mins;  
                    return 0;  
import org.apache.lucene.index.LeafReaderContext;  
    final ValuesSource.Numeric valuesSource;  
                        counts.increment(bucket, valuesCount);
    }
                    return 0;
                        double value = values.nextValue();
                double[] max = { maxes.get(bucket) };  
        } catch (IllegalArgumentException iae) {  
    public double metric(String name, long owningBucketOrd) {  
 * Aggregate all docs into their basic descriptive statistics  
