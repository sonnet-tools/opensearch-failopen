        );
    ExtendedStatsAggregator(
            InternalExtendedStats.Metrics.resolve(name);
    }
 * SPDX-License-Identifier: Apache-2.0
            case std_deviation_sampling:
                    sumOfSqrs.set(bucket, compensatedSumOfSqr.value());
/*
            case std_upper:
import org.opensearch.search.aggregations.support.ValuesSource;
            @Override
                    compensationOfSqrs = bigArrays.resize(compensationOfSqrs, overSize);
                if (bucket >= counts.size()) {
 * KIND, either express or implied.  See the License for the
            mins.get(bucket),
                return sums.get(owningBucketOrd) / counts.get(owningBucketOrd);
                    return Double.NaN;
        double sum = sums.get(owningBucketOrd);
    @Override
    }
                    sumOfSqrs = bigArrays.resize(sumOfSqrs, overSize);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            metadata()
                return maxes.get(owningBucketOrd);
    }
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
                default:
                    return Double.NaN;
                case sum:
            maxes.get(bucket),
                return sumOfSqrs.get(owningBucketOrd);
 * The OpenSearch Contributors require contributions made to
            format,
    @Override
 * Aggregate all docs into their extended statistics
/*
            case variance_population:
            case count:
            return buildEmptyAggregation();
    DoubleArray compensationOfSqrs;
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
                    double compensationOfSqr = compensationOfSqrs.get(bucket);
        String name,
        long count = counts.get(owningBucketOrd);
                    return Double.NEGATIVE_INFINITY;
            case sum:
 * Modifications Copyright OpenSearch Contributors. See
    static final ParseField SIGMA_FIELD = new ParseField("sigma");
                return variance(owningBucketOrd);
                    compensations.set(bucket, compensatedSum.delta());
 * the Apache License, Version 2.0 (the "License"); you may
                return counts.get(owningBucketOrd);
 * license agreements. See the NOTICE file distributed with
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
                super.collectRange(min, max);
    DoubleArray maxes;
import org.opensearch.common.util.LongArray;
                return variancePopulation(owningBucketOrd);
                case sum_of_squares:
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
            case std_lower:
            compensations = bigArrays.newDoubleArray(1, true);
                    maxes.fill(from, overSize, Double.NEGATIVE_INFINITY);
                case std_deviation_sampling:
        if (valuesSource != null) {
                    final long from = counts.size();
                    // Compute the sum and sum of squires for double values with Kahan summation algorithm
        final CompensatedSum compensatedSumOfSqr = new CompensatedSum(0, 0);
                    double max = maxes.get(bucket);
            sumOfSqrs = bigArrays.newDoubleArray(1, true);
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
    final double sigma;
        Map<String, Object> metadata
/**
import org.apache.lucene.search.ScoreMode;
                throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
 * ownership. Elasticsearch licenses this file to you under
    public InternalAggregation buildEmptyAggregation() {
                    return Double.NaN;
import org.opensearch.common.lease.Releasables;
            case std_deviation_population:
    DoubleArray sumOfSqrs;
                case std_lower:
            switch (InternalExtendedStats.Metrics.resolve(name)) {
        }
                    compensationOfSqrs.set(bucket, compensatedSumOfSqr.delta());
        if (valuesSource == null) {
            case min:
                return Math.sqrt(variance(owningBucketOrd));
 */
    @Override
        final BigArrays bigArrays = context.bigArrays();
    @Override
                    return Double.NaN;
                    double min = mins.get(bucket);
                    return Double.NaN;
 * this work for additional information regarding copyright
        } catch (IllegalArgumentException iae) {
            compensationOfSqrs = bigArrays.newDoubleArray(1, true);
        return new LeafBucketCollectorBase(sub, values) {
                    counts = bigArrays.resize(counts, overSize);
    }
 * not use this file except in compliance with the License.
                    return Double.NaN;
    }
    private double variancePopulation(long owningBucketOrd) {
                    return 0;
    LongArray counts;
        if (valuesSource == null || bucket >= counts.size()) {
                case variance_sampling:
                    return 0;
            default:
}
        ValuesSourceConfig valuesSourceConfig,
            public void collect(int doc, long bucket) throws IOException {
                }
                    return 0;
    @Override
    private double variance(long owningBucketOrd) {
                    maxes.set(bucket, max);
                return (sums.get(owningBucketOrd) / counts.get(owningBucketOrd)) + (Math.sqrt(variance(owningBucketOrd)) * this.sigma);
    public boolean hasMetric(String name) {
import org.opensearch.search.internal.SearchContext;
                    mins = bigArrays.resize(mins, overSize);
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
            }
    }
import org.opensearch.core.ParseField;
            }
 * specific language governing permissions and limitations
 *
                if (values.advanceExact(doc)) {
            sumOfSqrs.get(bucket),
 * You may obtain a copy of the License at
        double variance = (sumOfSqrs.get(owningBucketOrd) - ((sum * sum) / count)) / count;
            case variance:
/*
    DoubleArray compensations;
        Aggregator parent,
            return LeafBucketCollector.NO_OP_COLLECTOR;
            case std_deviation:
                    }
                case avg:
import java.io.IOException;
import org.opensearch.search.aggregations.Aggregator;
                    return Double.POSITIVE_INFINITY;
                    throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
        return variance < 0 ? 0 : variance;
    public InternalAggregation buildAggregation(long bucket) {
    @Override
            counts.get(bucket),
            case sum_of_squares:
                case variance:
 *
                case std_upper:
import org.opensearch.search.aggregations.InternalAggregation;
                return sums.get(owningBucketOrd);
                    double sumOfSqr = sumOfSqrs.get(bucket);
        SearchContext context,
            final BigArrays bigArrays = context.bigArrays();
            public void collectRange(int min, int max) throws IOException {
import org.apache.lucene.index.LeafReaderContext;
                    compensations = bigArrays.resize(compensations, overSize);
                        min = Math.min(min, value);
                    counts.increment(bucket, valuesCount);
    public void doClose() {
 */
import org.opensearch.search.aggregations.LeafBucketCollector;
                    return Double.NaN;
        Releasables.close(counts, maxes, mins, sumOfSqrs, compensationOfSqrs, sums, compensations);
import org.apache.lucene.search.DocIdStream;
        };
            }
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
                    return Double.NaN;
                    maxes = bigArrays.resize(maxes, overSize);
import java.util.Map;
        }
            }
        double variance = (sumOfSqrs.get(owningBucketOrd) - ((sum * sum) / count)) / (count - 1);
        this.format = valuesSourceConfig.format();
                    compensatedSum.reset(sum, compensation);
            counts = bigArrays.newLongArray(1, true);
import org.opensearch.common.util.DoubleArray;
                    mins.fill(from, overSize, Double.POSITIVE_INFINITY);
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
            case max:
                    return Double.NaN;
        return variance < 0 ? 0 : variance;
                return Math.sqrt(variance(owningBucketOrd));
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
            return true;
    DoubleArray sums;
            maxes = bigArrays.newDoubleArray(1, false);
 *
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        try {
 * compatible open source license.
 *
            sigma,
            @Override
    final ValuesSource.Numeric valuesSource;
        switch (InternalExtendedStats.Metrics.resolve(name)) {
        long count = counts.get(owningBucketOrd);
                return varianceSampling(owningBucketOrd);
    @Override
        this.sigma = sigma;
                return mins.get(owningBucketOrd);
    }
                }
            sums.get(bucket),
                    final long overSize = BigArrays.overSize(bucket + 1);
            mins.fill(0, mins.size(), Double.POSITIVE_INFINITY);
                    final int valuesCount = values.docValueCount();
    final DocValueFormat format;
    DoubleArray mins;
                    double sum = sums.get(bucket);
        }
package org.opensearch.search.aggregations.metrics;
            name,
        return new InternalExtendedStats(
        final CompensatedSum compensatedSum = new CompensatedSum(0, 0);
                        max = Math.max(max, value);
 * under the License.
    }
    private double varianceSampling(long owningBucketOrd) {
                super.collect(stream, owningBucketOrd);
            mins = bigArrays.newDoubleArray(1, false);
            maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);
    public ScoreMode scoreMode() {
                    double compensation = compensations.get(bucket);
                        compensatedSumOfSqr.add(value * value);
                case std_deviation:
        return new InternalExtendedStats(name, 0, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, sigma, format, metadata());
 * software distributed under the License is distributed on an
                return (sums.get(owningBucketOrd) / counts.get(owningBucketOrd)) - (Math.sqrt(variance(owningBucketOrd)) * this.sigma);
                    sums.set(bucket, compensatedSum.value());
            return false;
            sums = bigArrays.newDoubleArray(1, true);
                    compensatedSumOfSqr.reset(sumOfSqr, compensationOfSqr);
import org.opensearch.common.util.BigArrays;
        double sum = sums.get(owningBucketOrd);
                case max:
                        compensatedSum.add(value);
            @Override
            case variance_sampling:
    }
            case avg:
class ExtendedStatsAggregator extends NumericMetricsAggregator.MultiValue {
 */
                case count:
        super(name, context, parent, metadata);
                    for (int i = 0; i < valuesCount; i++) {
 * @opensearch.internal
                    // which is more accurate than naive summation.
        }
        double sigma,
        if (valuesSource == null || owningBucketOrd >= counts.size()) {
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {
 */
import org.opensearch.search.DocValueFormat;
                case std_deviation_population:
                        double value = values.nextValue();
                return Math.sqrt(varianceSampling(owningBucketOrd));
    }
    public double metric(String name, long owningBucketOrd) {
        return variancePopulation(owningBucketOrd);
                    sums = bigArrays.resize(sums, overSize);
    ) throws IOException {
                case variance_population:
                case min:
        // TODO: stop depending on nulls here
        }
                    mins.set(bucket, min);
