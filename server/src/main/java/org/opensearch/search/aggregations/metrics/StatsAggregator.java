import org.opensearch.search.aggregations.LeafBucketCollector;
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
    DoubleArray compensations;
                    return Double.NaN;
        if (valuesSource != null) {
 * SPDX-License-Identifier: Apache-2.0
                    double max = maxes.get(bucket);
                    return 0;
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
                        for (int i = 0; i < valuesCount; i++) {
}
            @Override
                    mins.set(bucket, min);
        }
                case sum:
 */
            public void collect(int doc, long bucket) throws IOException {
 * compatible open source license.
        }
                sums.set(bucket, kahanSummation.value());
                });
        Map<String, Object> metadata
    }
    StatsAggregator(
                        double value = values.nextValue();
                            kahanSummation.add(value);
                        }
                return sums.get(owningBucketOrd) / counts.get(owningBucketOrd);
            }
                    return Double.POSITIVE_INFINITY;
    DoubleArray maxes;
            }
                return sums.get(owningBucketOrd);
                }
    public InternalAggregation buildAggregation(long bucket) {
                    }
                        }
 */
            case avg:
            mins = bigArrays.newDoubleArray(1, false);
    @Override
                    sums = bigArrays.resize(sums, overSize);
                        for (int i = 0; i < valuesCount; i++) {
/*
            case sum:
            return true;
    @Override
        }
        switch (InternalStats.Metrics.resolve(name)) {
                    return Double.NEGATIVE_INFINITY;
                double compensation = compensations.get(bucket);
                        kahanSummation.add(value);
 *
 * Unless required by applicable law or agreed to in writing,
            mins.fill(0, mins.size(), Double.POSITIVE_INFINITY);
                double maximum = maxes.get(0);
                    mins.fill(from, overSize, Double.POSITIVE_INFINITY);
 *
            return buildEmptyAggregation();
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                    if (values.advanceExact(doc)) {
/*
                stream.forEach((doc) -> {
                }
import org.apache.lucene.search.ScoreMode;
                mins.set(bucket, min[0]);
                            max[0] = Math.max(max[0], value);
    public InternalAggregation buildEmptyAggregation() {
 * not use this file except in compliance with the License.
                    maxes = bigArrays.resize(maxes, overSize);
                    final long from = counts.size();
                return mins.get(owningBucketOrd);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
    LongArray counts;
        Releasables.close(counts, maxes, mins, sums, compensations);
                // Compute the sum of double values with Kahan summation algorithm which is more
                    final int valuesCount = values.docValueCount();
 * Aggregate all docs into their basic descriptive statistics
 * under the License.
import org.apache.lucene.search.DocIdStream;
        Aggregator parent,
import org.opensearch.search.aggregations.InternalAggregation;
                mins.set(0, minimum);
        }
import org.opensearch.search.aggregations.Aggregator;
                    }
 * specific language governing permissions and limitations
        super(name, context, parent, metadata);
    }
 * this work for additional information regarding copyright
                compensations.set(bucket, kahanSummation.delta());
            }
                    maxes.set(bucket, max);
    @Override
                }
    DoubleArray sums;
            return LeafBucketCollector.NO_OP_COLLECTOR;
            @Override
    public double metric(String name, long owningBucketOrd) {
        final CompensatedSum kahanSummation = new CompensatedSum(0, 0);
                for (int doc = min; doc < max; doc++) {
                    throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
                growStats(bucket);
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        };
                double[] max = { maxes.get(bucket) };
                return maxes.get(owningBucketOrd);
                maxes.set(bucket, max[0]);
            case count:
                    sums.set(bucket, kahanSummation.value());
                double sum = sums.get(bucket);
            default:
    public ScoreMode scoreMode() {
            @Override
                    counts.increment(bucket, valuesCount);
            sums = bigArrays.newDoubleArray(1, true);
                maxes.set(0, maximum);
                double minimum = mins.get(0);
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
    public void doClose() {
    @Override
/**
            private void growStats(long bucket) {
        try {
        }
                    final long overSize = BigArrays.overSize(bucket + 1);
import java.util.Map;
        final BigArrays bigArrays = context.bigArrays();
        // TODO: stop using nulls here
import org.opensearch.common.util.LongArray;
 * @opensearch.internal
            public void collectRange(int min, int max) throws IOException {
            case min:
                        max = Math.max(max, value);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    final ValuesSource.Numeric valuesSource;
                    counts = bigArrays.resize(counts, overSize);
        return new LeafBucketCollectorBase(sub, values) {
                growStats(0);
                case avg:
        return new InternalStats(name, counts.get(bucket), sums.get(bucket), mins.get(bucket), maxes.get(bucket), format, metadata());
/*
 *
                        final int valuesCount = values.docValueCount();
    }
    ) throws IOException {
        if (valuesSource == null || bucket >= sums.size()) {
                    return 0;
                        counts.increment(bucket, valuesCount);
    final DocValueFormat format;
        return new InternalStats(name, 0, 0, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, format, metadata());
        } catch (IllegalArgumentException iae) {
    }
 * software distributed under the License is distributed on an
    @Override
            counts = bigArrays.newLongArray(1, true);
                kahanSummation.reset(sum, compensation);
                compensations.set(0, kahanSummation.delta());
                if (values.advanceExact(doc)) {
            maxes = bigArrays.newDoubleArray(1, false);
 * GitHub history for details.
                case min:
    @Override
            case max:
 *
import org.opensearch.common.util.DoubleArray;
import org.opensearch.search.internal.SearchContext;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
                    maxes.fill(from, overSize, Double.NEGATIVE_INFINITY);
                        min = Math.min(min, value);
                double[] min = { mins.get(bucket) };
                case count:
        String name,
                            double value = values.nextValue();
class StatsAggregator extends NumericMetricsAggregator.MultiValue {
                if (bucket >= counts.size()) {
                    compensations.set(bucket, kahanSummation.delta());
                return counts.get(owningBucketOrd);
 * the Apache License, Version 2.0 (the "License"); you may
                            double value = values.nextValue();
                    compensations = bigArrays.resize(compensations, overSize);
        SearchContext context,
                            min[0] = Math.min(min[0], value);
                        final int valuesCount = values.docValueCount();
    }
 */
import org.apache.lucene.index.LeafReaderContext;
import org.opensearch.common.lease.Releasables;
 * ownership. Elasticsearch licenses this file to you under
            return false;
                        counts.increment(0, valuesCount);
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            kahanSummation.add(value);
                growStats(bucket);
                case max:
                            maximum = Math.max(maximum, value);
import org.opensearch.search.aggregations.support.ValuesSource;
            InternalStats.Metrics.resolve(name);
            }
            switch (InternalStats.Metrics.resolve(name)) {
                    for (int i = 0; i < valuesCount; i++) {
import org.opensearch.search.DocValueFormat;
                    }
 * this file be licensed under the Apache-2.0 license or a
    }
                // accurate than naive summation.
            maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);
        }
            final BigArrays bigArrays = context.bigArrays();
                    if (values.advanceExact(doc)) {
        if (valuesSource == null) {
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.util.BigArrays;
import java.io.IOException;
 */
            public void collect(DocIdStream stream, long bucket) throws IOException {
    public boolean hasMetric(String name) {
    @Override
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
        this.format = valuesSourceConfig.format();
                default:
        if (valuesSource == null || owningBucketOrd >= counts.size()) {
 * The OpenSearch Contributors require contributions made to
    DoubleArray mins;
                sums.set(0, kahanSummation.value());
                throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
    }
        ValuesSourceConfig valuesSourceConfig,
                    mins = bigArrays.resize(mins, overSize);
 * You may obtain a copy of the License at
                            minimum = Math.min(minimum, value);
            compensations = bigArrays.newDoubleArray(1, true);
    }
package org.opensearch.search.aggregations.metrics;
                    double min = mins.get(bucket);
