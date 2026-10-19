    }  
        super(name, context, parent, metadata);
                return Math.sqrt(varianceSampling(owningBucketOrd));
    public InternalAggregation buildAggregation(long bucket) {
            case variance_population:
 * KIND, either express or implied.  See the License for the
            return false;
                    return Double.NEGATIVE_INFINITY;
                return variancePopulation(owningBucketOrd);  
                }
        ValuesSourceConfig valuesSourceConfig,
        String name,
    DoubleArray sums;
 *
    }
        final BigArrays bigArrays = context.bigArrays();
        switch (InternalExtendedStats.Metrics.resolve(name)) {
    }
                    sumOfSqrs = bigArrays.resize(sumOfSqrs, overSize);
                    for (int i = 0; i < valuesCount; i++) {
    private double variancePopulation(long owningBucketOrd) {
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
                    compensatedSum.reset(sum, compensation);
        Map<String, Object> metadata  
 * not use this file except in compliance with the License.
                case std_deviation_population:
                    throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
            name,  
 * Unless required by applicable law or agreed to in writing,
            case sum:
                if (values.advanceExact(doc)) {
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.internal.SearchContext;
        Releasables.close(counts, maxes, mins, sumOfSqrs, compensationOfSqrs, sums, compensations);
                return Math.sqrt(variance(owningBucketOrd));
                    mins.fill(from, overSize, Double.POSITIVE_INFINITY);
            sums.get(bucket),
    DoubleArray sumOfSqrs;  
class ExtendedStatsAggregator extends NumericMetricsAggregator.MultiValue {
 * Aggregate all docs into their extended statistics
                    return Double.NaN;
                    // which is more accurate than naive summation.
                    return 0;
 */  
                case std_deviation:  
    private double variance(long owningBucketOrd) {  
            InternalExtendedStats.Metrics.resolve(name);
                return variance(owningBucketOrd);
    }  
                return (sums.get(owningBucketOrd) / counts.get(owningBucketOrd)) + (Math.sqrt(variance(owningBucketOrd)) * this.sigma);
            metadata()
                throw new IllegalArgumentException("Unknown value [" + name + "] in common stats aggregation");
            case std_deviation_sampling:
    public ScoreMode scoreMode() {
            sumOfSqrs.get(bucket),
            public void collectRange(int min, int max) throws IOException {
package org.opensearch.search.aggregations.metrics;
    DoubleArray compensationOfSqrs;
            case avg:
            @Override
                    final long from = counts.size();
            maxes.get(bucket),
            case variance_sampling:
                    return Double.NaN;  
                    sums = bigArrays.resize(sums, overSize);
                    double compensation = compensations.get(bucket);
                    compensatedSumOfSqr.reset(sumOfSqr, compensationOfSqr);  
                super.collectRange(min, max);
import org.opensearch.search.aggregations.LeafBucketCollector;  
    DoubleArray compensations;  
            case min:
        Aggregator parent,
import org.opensearch.core.ParseField;
            sums = bigArrays.newDoubleArray(1, true);
            }  
            case std_lower:
/*
 *  
                    compensations.set(bucket, compensatedSum.delta());
            case std_upper:  
                case sum:
                    sumOfSqrs.set(bucket, compensatedSumOfSqr.value());  
    @Override  
            maxes.fill(0, maxes.size(), Double.NEGATIVE_INFINITY);  
        final CompensatedSum compensatedSumOfSqr = new CompensatedSum(0, 0);
        SearchContext context,  
        }
            case sum_of_squares:
 * You may obtain a copy of the License at  
        return variance < 0 ? 0 : variance;  
    }
 * @opensearch.internal  
import org.apache.lucene.index.LeafReaderContext;  
            format,
                case std_upper:  
/**  
 *
                    compensations = bigArrays.resize(compensations, overSize);
            @Override  
            default:
        double variance = (sumOfSqrs.get(owningBucketOrd) - ((sum * sum) / count)) / count;
                        compensatedSumOfSqr.add(value * value);
                super.collect(stream, owningBucketOrd);  
        if (valuesSource == null) {
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
    @Override  
                    return Double.NaN;
        return variance < 0 ? 0 : variance;
                    // Compute the sum and sum of squires for double values with Kahan summation algorithm
    final ValuesSource.Numeric valuesSource;  
            public void collect(DocIdStream stream, long owningBucketOrd) throws IOException {
    }
            public void collect(int doc, long bucket) throws IOException {
                return varianceSampling(owningBucketOrd);
                default:
import org.opensearch.common.util.BigArrays;
        if (valuesSource == null || bucket >= counts.size()) {
 * this file be licensed under the Apache-2.0 license or a
                return sums.get(owningBucketOrd);  
import org.opensearch.search.DocValueFormat;  
    @Override
                }  
        double sum = sums.get(owningBucketOrd);
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
                    double sum = sums.get(bucket);  
            final BigArrays bigArrays = context.bigArrays();
        if (valuesSource != null) {
        // TODO: stop depending on nulls here  
    public InternalAggregation buildEmptyAggregation() {
    ) throws IOException {
        return new InternalExtendedStats(name, 0, 0d, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, sigma, format, metadata());
        }
        final CompensatedSum compensatedSum = new CompensatedSum(0, 0);  
 * Modifications Copyright OpenSearch Contributors. See  
        }  
            @Override
 * under the License.  
        double variance = (sumOfSqrs.get(owningBucketOrd) - ((sum * sum) / count)) / (count - 1);
                return counts.get(owningBucketOrd);
                case variance:  
                    final long overSize = BigArrays.overSize(bucket + 1);
    public boolean hasMetric(String name) {
    private double varianceSampling(long owningBucketOrd) {
import java.io.IOException;  
            sigma,  
            case count:  
        double sigma,
    public void doClose() {  
    final double sigma;
 */
            return buildEmptyAggregation();  
                if (bucket >= counts.size()) {  
 * the Apache License, Version 2.0 (the "License"); you may
            counts = bigArrays.newLongArray(1, true);  
    DoubleArray mins;
        double sum = sums.get(owningBucketOrd);  
                    double sumOfSqr = sumOfSqrs.get(bucket);
 * SPDX-License-Identifier: Apache-2.0
                    return Double.POSITIVE_INFINITY;
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
    }
                    return 0;
    public double metric(String name, long owningBucketOrd) {  
                    final int valuesCount = values.docValueCount();  
                return maxes.get(owningBucketOrd);
import org.opensearch.search.aggregations.Aggregator;
            return true;
import org.opensearch.common.util.LongArray;  
                case count:  
    @Override
                        min = Math.min(min, value);  
    }  
import org.opensearch.common.lease.Releasables;  
                return Math.sqrt(variance(owningBucketOrd));  
                    return Double.NaN;  
        );  
import org.opensearch.search.aggregations.LeafBucketCollectorBase;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
                    maxes = bigArrays.resize(maxes, overSize);
            compensations = bigArrays.newDoubleArray(1, true);
        }  
 * specific language governing permissions and limitations
import org.apache.lucene.search.DocIdStream;
import org.apache.lucene.search.ScoreMode;
                    compensationOfSqrs = bigArrays.resize(compensationOfSqrs, overSize);  
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
    static final ParseField SIGMA_FIELD = new ParseField("sigma");
                        double value = values.nextValue();  
            compensationOfSqrs = bigArrays.newDoubleArray(1, true);
        return valuesSource != null && valuesSource.needsScores() ? ScoreMode.COMPLETE : ScoreMode.COMPLETE_NO_SCORES;
                        compensatedSum.add(value);
            case max:  
    DoubleArray maxes;
                case variance_population:
    @Override  
        try {  
    ExtendedStatsAggregator(  
        this.valuesSource = valuesSourceConfig.hasValues() ? (ValuesSource.Numeric) valuesSourceConfig.getValuesSource() : null;
                    double max = maxes.get(bucket);  
                return mins.get(owningBucketOrd);
                case variance_sampling:
                case std_deviation_sampling:
                    counts = bigArrays.resize(counts, overSize);  
    LongArray counts;
 *
/*
                    compensationOfSqrs.set(bucket, compensatedSumOfSqr.delta());
import org.opensearch.search.aggregations.support.ValuesSource;
        };
    @Override
                case max:  
            return LeafBucketCollector.NO_OP_COLLECTOR;
                    return Double.NaN;
                    return Double.NaN;
            mins = bigArrays.newDoubleArray(1, false);  
            }  
                    sums.set(bucket, compensatedSum.value());
                case sum_of_squares:
        long count = counts.get(owningBucketOrd);
                    return Double.NaN;  
 */
import org.opensearch.common.util.DoubleArray;
        this.sigma = sigma;  
            case variance:  
    @Override
                return sumOfSqrs.get(owningBucketOrd);
            counts.get(bucket),
        this.format = valuesSourceConfig.format();
}  
 * Licensed to Elasticsearch under one or more contributor  
    public LeafBucketCollector getLeafCollector(LeafReaderContext ctx, final LeafBucketCollector sub) throws IOException {  
        } catch (IllegalArgumentException iae) {  
    }
            mins.get(bucket),  
/*  
        return new InternalExtendedStats(
                    double compensationOfSqr = compensationOfSqrs.get(bucket);
                    counts.increment(bucket, valuesCount);
                return (sums.get(owningBucketOrd) / counts.get(owningBucketOrd)) - (Math.sqrt(variance(owningBucketOrd)) * this.sigma);  
        return new LeafBucketCollectorBase(sub, values) {
 * GitHub history for details.
            switch (InternalExtendedStats.Metrics.resolve(name)) {
                    mins.set(bucket, min);
    final DocValueFormat format;
                    return Double.NaN;  
                    }
                    maxes.set(bucket, max);  
                    double min = mins.get(bucket);
            maxes = bigArrays.newDoubleArray(1, false);
                return sums.get(owningBucketOrd) / counts.get(owningBucketOrd);  
                        max = Math.max(max, value);
                    maxes.fill(from, overSize, Double.NEGATIVE_INFINITY);
            }
        }
        return variancePopulation(owningBucketOrd);
        long count = counts.get(owningBucketOrd);  
        final SortedNumericDoubleValues values = valuesSource.doubleValues(ctx);
                case min:
                    mins = bigArrays.resize(mins, overSize);  
                    return 0;  
import org.opensearch.search.aggregations.InternalAggregation;
            }
            sumOfSqrs = bigArrays.newDoubleArray(1, true);
            mins.fill(0, mins.size(), Double.POSITIVE_INFINITY);
                case avg:
        if (valuesSource == null || owningBucketOrd >= counts.size()) {
                    return Double.NaN;
import java.util.Map;
            case std_deviation_population:
                case std_lower:
            case std_deviation:  
        }  
