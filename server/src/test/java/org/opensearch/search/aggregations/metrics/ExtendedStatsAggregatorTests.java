            assertEquals(expected.varianceSampling(), stats.getVarianceSampling(), TOLERANCE);
            min = Math.min(min, value);
import static java.util.Collections.singleton;
    public void testVarianceNonNegative() throws IOException {
        for (int i = 0; i < n; i++) {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                case LOWER:
        }
            assertEquals(0.0d, stats.getVariancePopulation(), TOLERANCE);
            assertEquals(0.0d, stats.getStdDeviationSampling(), TOLERANCE);
import org.apache.lucene.document.Document;
                expected.add(value);
        }, stats -> {
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        void add(double value) {
                IndexSearcher searcher = new IndexSearcher(reader);
            assertEquals(0d, stats.getCount(), 0);
                TOLERANCE
            double variance = (sumOfSqrs - ((sum * sum) / count)) / count;
            assertEquals(
                    expected.add(value);
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER),
import org.apache.lucene.store.Directory;
}
            assertEquals(expected.min, stats.getMin(), 0);
            assertEquals(expected.stdDevSampling(), stats.getStdDeviationSampling(), TOLERANCE);
                TOLERANCE
            );
            sumOfSqrs += (value * value);
            assertEquals(
                    doc.add(new SortedNumericDocValuesField("field", value));
                iw.addDocument(doc);
                iw.addDocument(singleton(new NumericDocValuesField(fieldName, NumericUtils.doubleToSortableLong(value))));
                TOLERANCE
    }
            double variance = (sumOfSqrs - ((sum * sum) / count)) / (count - 1);
            assertEquals(Double.NaN, stats.getStdDeviationSampling(), 0);
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
            assertEquals(expected.variancePopulation(), stats.getVariancePopulation(), TOLERANCE);
                case UPPER:
 *
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER),
            largeValues[i] = Double.MAX_VALUE;
        });
                TOLERANCE
        }
            assertEquals(expected.count, stats.getCount(), 0);
        }
            assertEquals(expected.stdDev(), stats.getStdDeviation(), TOLERANCE);
import org.apache.lucene.search.IndexSearcher;
    }
            assertEquals(expected.stdDevPopulation(), stats.getStdDeviationPopulation(), TOLERANCE);
 */
                expected.stdDevBound(ExtendedStats.Bounds.LOWER_POPULATION, stats.getSigma()),
            for (int i = 0; i < numDocs; i++) {
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            super.add(value);
            assertEquals(
        double variance() {
        int n = randomIntBetween(5, 10);
                InternalExtendedStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, ft);
 * under the License.
                iw.addDocument(doc);
            assertEquals(expected.stdDevPopulation(), stats.getStdDeviationPopulation(), TOLERANCE);
            );
    ) throws IOException {
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
                TOLERANCE
                case LOWER_SAMPLING:
import org.opensearch.index.mapper.NumberFieldMapper;
                case LOWER_POPULATION:
 */
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        final ExtendedSimpleStatsAggregator expected = new ExtendedSimpleStatsAggregator();
            assertEquals(expectedSum, stats.getSum(), delta);
            assertEquals(expected.sumOfSqrs, stats.getSumOfSquares(), TOLERANCE);
            int numDocs = randomIntBetween(10, 50);
        }
        verifyStatsOfDoubles(largeValues, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d);
                TOLERANCE
    private static final double TOLERANCE = 1e-5;
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER_SAMPLING),
                }
        }
            int numDocs = 3;
                    return (sum / count) - (Math.sqrt(variancePopulation()) * sigma);
        });
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER_POPULATION),
        testCase(ft, iw -> {
                double value = 49.95d;
/*
        verifyStatsOfDoubles(values, sum, sumOfSqrs, TOLERANCE);
import org.opensearch.index.mapper.MappedFieldType;
 * Unless required by applicable law or agreed to in writing,
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
    }
        double expectedMax = max;
                TOLERANCE
        testCase(ft, iw -> {
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER_SAMPLING),
            assertEquals(
            assertEquals(expected.max, stats.getMax(), 0);
    public void testCase(
        }
                }
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(0.0d, stats.getStdDeviationPopulation(), TOLERANCE);
            assertEquals(0.0d, stats.getStdDeviation(), TOLERANCE);
        }, stats -> {
     */
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER_POPULATION),
            assertEquals(0.0d, stats.getVariance(), TOLERANCE);
import org.apache.lucene.search.MatchAllDocsQuery;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType(fieldName, NumberFieldMapper.NumberType.DOUBLE);
 *     http://www.apache.org/licenses/LICENSE-2.0
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
                    doc.add(new SortedNumericDocValuesField("field", valueAsLong));
    public void testRandomLongs() throws IOException {
            for (int i = 0; i < numDocs; i++) {
            );
/*
            assertEquals(
                for (int j = 0; j < numValues; j++) {
                Document doc = new Document();
                expected.stdDevBound(ExtendedStats.Bounds.UPPER, stats.getSigma()),
        double stdDevSampling() {
            assertEquals(expectedSumOfSqrs, stats.getSumOfSquares(), delta);
                expected.stdDevBound(ExtendedStats.Bounds.LOWER_POPULATION, stats.getSigma()),
            assertEquals(expected.variance(), stats.getVariance(), TOLERANCE);
            assertEquals(0d, stats.getSum(), 0);
            assertEquals(expected.stdDevSampling(), stats.getStdDeviationSampling(), TOLERANCE);
            }
package org.opensearch.search.aggregations.metrics;
        double stdDevBound(ExtendedStats.Bounds bounds, double sigma) {
                Document doc = new Document();
            );
                    return (sum / count) - (Math.sqrt(variance()) * sigma);
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER_POPULATION),
        final ExtendedSimpleStatsAggregator expected = new ExtendedSimpleStatsAggregator();
            assertEquals(expected.variancePopulation(), stats.getVariancePopulation(), TOLERANCE);
        values = new double[n];
                case UPPER_SAMPLING:
import org.apache.lucene.util.NumericUtils;
    }
            return Math.sqrt(varianceSampling());
        double stdDevPopulation() {
import org.apache.lucene.index.IndexReader;
                    double value = randomDoubleBetween(-100d, 100d, true);
    }
 * ownership. Elasticsearch licenses this file to you under
            }
 * You may obtain a copy of the License at
            assertEquals(expectedMax, stats.getMax(), 0d);
import org.apache.lucene.document.NumericDocValuesField;
    }
            assertEquals(
        // Summing up some big double values and expect infinity result
        for (int i = 0; i < n; i++) {
            assertEquals(expected.max, stats.getMax(), 0);
        double min = Double.POSITIVE_INFINITY;
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER_SAMPLING),
            return Math.sqrt(variance());
import org.opensearch.common.CheckedConsumer;
import org.apache.lucene.document.SortedNumericDocValuesField;
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
            int numDocs = randomIntBetween(10, 50);
            // since the value(49.95) is a constant, variance should be 0
            assertEquals(Double.NaN, stats.getStdDeviation(), 0);
        final String fieldName = "field";
 * Licensed to Elasticsearch under one or more contributor
        });
        double varianceSampling() {
        double[] largeValues = new double[n];
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER),
        double max = Double.NEGATIVE_INFINITY;
        verifyStatsOfDoubles(largeValues, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d);
            assertEquals(expectedMin, stats.getMin(), 0d);
            return Math.sqrt(variancePopulation());
            assertEquals(0d, stats.getSumOfSquares(), 0);
            assertEquals(expected.min, stats.getMin(), 0);
                expected.stdDevBound(ExtendedStats.Bounds.UPPER_SAMPLING, stats.getSigma()),
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);
                ExtendedStatsAggregationBuilder aggBuilder = new ExtendedStatsAggregationBuilder("my_agg").field("field")
import java.util.function.Consumer;
            assertEquals(Double.NEGATIVE_INFINITY, stats.getMax(), 0);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
            assertEquals(expected.count, stats.getCount(), 0);
                Document doc = new Document();
            assertEquals(
            }
            assertTrue(AggregationInspectionHelper.hasValue(stats));
import org.opensearch.search.aggregations.AggregatorTestCase;
            switch (bounds) {
            buildIndex.accept(indexWriter);
            );
            );
            return variance < 0 ? 0 : variance;
    private void verifyStatsOfDoubles(double[] values, double expectedSum, double expectedSumOfSqrs, double delta) throws IOException {
                TOLERANCE
            assertFalse(AggregationInspectionHelper.hasValue(stats));
     * Testcase for https://github.com/elastic/elasticsearch/issues/37303
        testCase(ft, iw -> {}, stats -> {
                expected.stdDevBound(ExtendedStats.Bounds.UPPER_SAMPLING, stats.getSigma()),
                verify.accept(stats);
            assertEquals(Double.POSITIVE_INFINITY, stats.getMin(), 0);
            assertEquals(expected.stdDev(), stats.getStdDeviation(), TOLERANCE);
            sumOfSqrs += values[i] * values[i];
            );
                expected.stdDevBound(ExtendedStats.Bounds.LOWER, stats.getSigma()),
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation
            values[i] = frequently()
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);
                expected.stdDevBound(ExtendedStats.Bounds.LOWER_SAMPLING, stats.getSigma()),
            max = Math.max(max, value);
/*
                int numValues = randomIntBetween(1, 5);
 * software distributed under the License is distributed on an
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER_SAMPLING),
 * this work for additional information regarding copyright
            assertEquals(Double.NaN, stats.getStdDeviationPopulation(), 0);
 *
            assertEquals(
            for (double value : values) {
            assertEquals(0.0d, stats.getVarianceSampling(), TOLERANCE);
                TOLERANCE
                int numValues = randomIntBetween(1, 5);
            try (IndexReader reader = indexWriter.getReader()) {
        Consumer<InternalExtendedStats> verify
                expected.stdDevBound(ExtendedStats.Bounds.LOWER, stats.getSigma()),
        double sum = 0;
                for (int j = 0; j < numValues; j++) {
    static class ExtendedSimpleStatsAggregator extends StatsAggregatorTests.SimpleStatsAggregator {
 * compatible open source license.
            }
        }, stats -> {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER_POPULATION),
                TOLERANCE
        testCase(ft, iw -> {
                    return (sum / count) + (Math.sqrt(variancePopulation()) * sigma);
                doc.add(new SortedNumericDocValuesField("field", valueAsLong));
            );
        double variancePopulation() {
            sum += values[i];
                TOLERANCE
            assertEquals(
        testCase(ft, iw -> {
        }
        }, stats -> {
        verifyStatsOfDoubles(values, 13.5, 16.21, 0d);
            assertTrue(AggregationInspectionHelper.hasValue(stats));
        for (int i = 0; i < n; i++) {
import org.apache.lucene.tests.index.RandomIndexWriter;
            );
        }
            assertEquals(Double.NaN, stats.getVariance(), 0);
                    return (sum / count) + (Math.sqrt(varianceSampling()) * sigma);
            assertEquals(Double.NaN, stats.getVariancePopulation(), 0);
 *
            assertEquals(Double.NaN, stats.getVarianceSampling(), 0);
 * SPDX-License-Identifier: Apache-2.0
        for (double value : values) {
import java.io.IOException;
                    expected.add(value);
                long valueAsLong = NumericUtils.doubleToSortableLong(value);
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                iw.addDocument(doc);
 * not use this file except in compliance with the License.
                expected.stdDevBound(ExtendedStats.Bounds.UPPER, stats.getSigma()),
    // TODO: Add script test cases. Should fail with defaultValuesSourceType() commented out.
            );
            }
        final ExtendedSimpleStatsAggregator expected = new ExtendedSimpleStatsAggregator();
        MappedFieldType ft,
            return variancePopulation();
            assertEquals(values.length, stats.getCount());
        }
        }
                expected.stdDevBound(ExtendedStats.Bounds.UPPER_POPULATION, stats.getSigma()),
                    throw new IllegalArgumentException("Unknown bound " + bounds);
    public void testRandomDoubles() throws IOException {
            );
 * this file be licensed under the Apache-2.0 license or a
            largeValues[i] = -Double.MAX_VALUE;
            assertEquals(Float.NaN, stats.getAvg(), 0);
            }
        n = randomIntBetween(5, 10);
            assertEquals(expectedSum / values.length, stats.getAvg(), delta);
    /**
    }
                case UPPER_POPULATION:
    public void testEmpty() throws IOException {
 * specific language governing permissions and limitations
            assertEquals(expected.varianceSampling(), stats.getVarianceSampling(), TOLERANCE);
        });
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
            assertEquals(
            assertEquals(
        }
                    .sigma(randomDoubleBetween(0, 10, true));
 * GitHub history for details.
        }
                    long valueAsLong = NumericUtils.doubleToSortableLong(value);
 * The OpenSearch Contributors require contributions made to
        double sumOfSqrs = 0;
        }
    public void testSummationAccuracy() throws IOException {
        double sumOfSqrs = 0;
            assertEquals(expected.variance(), stats.getVariance(), TOLERANCE);
 */
        double expectedMin = min;
            assertEquals(expected.sumOfSqrs, stats.getSumOfSquares(), TOLERANCE);
            for (int i = 0; i < numDocs; i++) {
            return variance < 0 ? 0 : variance;
            assertEquals(
                expected.stdDevBound(ExtendedStats.Bounds.LOWER_SAMPLING, stats.getSigma()),
                    long value = randomIntBetween(-100, 100);
 * license agreements. See the NOTICE file distributed with
                default:
                expected.stdDevBound(ExtendedStats.Bounds.UPPER_POPULATION, stats.getSigma()),
                TOLERANCE
 * KIND, either express or implied.  See the License for the
public class ExtendedStatsAggregatorTests extends AggregatorTestCase {
                    return (sum / count) - (Math.sqrt(varianceSampling()) * sigma);
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER),
 * the Apache License, Version 2.0 (the "License"); you may
                    return (sum / count) + (Math.sqrt(variance()) * sigma);
            );
    }
        double stdDev() {
