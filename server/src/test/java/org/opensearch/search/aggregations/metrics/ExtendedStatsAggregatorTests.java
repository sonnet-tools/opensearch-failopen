import java.io.IOException;
import static java.util.Collections.singleton;
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType(fieldName, NumberFieldMapper.NumberType.DOUBLE);  
                case UPPER:
    static class ExtendedSimpleStatsAggregator extends StatsAggregatorTests.SimpleStatsAggregator {
                int numValues = randomIntBetween(1, 5);
            assertEquals(expected.min, stats.getMin(), 0);  
            double variance = (sumOfSqrs - ((sum * sum) / count)) / (count - 1);
 *
            assertEquals(0.0d, stats.getVarianceSampling(), TOLERANCE);
            assertFalse(AggregationInspectionHelper.hasValue(stats));
                expected.stdDevBound(ExtendedStats.Bounds.LOWER, stats.getSigma()),
import org.apache.lucene.util.NumericUtils;  
        double stdDevPopulation() {
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER),
            assertEquals(expectedMin, stats.getMin(), 0d);
                case LOWER:
                default:
            assertEquals(values.length, stats.getCount());
            assertEquals(0.0d, stats.getStdDeviationSampling(), TOLERANCE);
                double value = 49.95d;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.mapper.NumberFieldMapper;  
import org.opensearch.common.CheckedConsumer;
            sum += values[i];  
        double sum = 0;  
                expected.stdDevBound(ExtendedStats.Bounds.LOWER_SAMPLING, stats.getSigma()),
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER_SAMPLING),  
    private static final double TOLERANCE = 1e-5;
                case UPPER_POPULATION:
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };  
            assertEquals(Double.POSITIVE_INFINITY, stats.getMin(), 0);
                TOLERANCE
import org.apache.lucene.document.SortedNumericDocValuesField;  
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    public void testRandomLongs() throws IOException {  
            assertEquals(expected.variance(), stats.getVariance(), TOLERANCE);
        });  
                }
                expected.stdDevBound(ExtendedStats.Bounds.UPPER, stats.getSigma()),
            assertEquals(expected.stdDev(), stats.getStdDeviation(), TOLERANCE);
        verifyStatsOfDoubles(largeValues, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0d);
                verify.accept(stats);
        }  
                expected.stdDevBound(ExtendedStats.Bounds.LOWER_POPULATION, stats.getSigma()),
                expected.stdDevBound(ExtendedStats.Bounds.LOWER_SAMPLING, stats.getSigma()),
 */  
            assertEquals(expected.variancePopulation(), stats.getVariancePopulation(), TOLERANCE);  
            assertEquals(
        final ExtendedSimpleStatsAggregator expected = new ExtendedSimpleStatsAggregator();
import org.apache.lucene.search.IndexSearcher;
            );
            );  
    private void verifyStatsOfDoubles(double[] values, double expectedSum, double expectedSumOfSqrs, double delta) throws IOException {
            assertEquals(expected.count, stats.getCount(), 0);
                expected.stdDevBound(ExtendedStats.Bounds.LOWER, stats.getSigma()),  
        values = new double[n];
            return Math.sqrt(variance());
        double expectedMin = min;
        }
import java.util.function.Consumer;
        final String fieldName = "field";
            );
            assertEquals(expectedMax, stats.getMax(), 0d);  
                    return (sum / count) + (Math.sqrt(variancePopulation()) * sigma);
                TOLERANCE  
            try (IndexReader reader = indexWriter.getReader()) {  
                iw.addDocument(singleton(new NumericDocValuesField(fieldName, NumericUtils.doubleToSortableLong(value))));
    public void testCase(
 * The OpenSearch Contributors require contributions made to  
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);  
            assertEquals(expected.stdDevSampling(), stats.getStdDeviationSampling(), TOLERANCE);  
        double variance() {
                    return (sum / count) + (Math.sqrt(variance()) * sigma);  
 *
import org.apache.lucene.store.Directory;
        double stdDev() {  
            return Math.sqrt(varianceSampling());  
            assertEquals(expectedSum / values.length, stats.getAvg(), delta);  
            }  
import org.apache.lucene.search.MatchAllDocsQuery;  
    }
                long valueAsLong = NumericUtils.doubleToSortableLong(value);
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER_POPULATION),  
            assertEquals(Double.NaN, stats.getStdDeviation(), 0);
                Document doc = new Document();  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            largeValues[i] = Double.MAX_VALUE;  
                TOLERANCE
            assertEquals(expected.count, stats.getCount(), 0);
            assertEquals(expected.stdDev(), stats.getStdDeviation(), TOLERANCE);
        }
    }  
                InternalExtendedStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), aggBuilder, ft);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
            assertEquals(
            );  
                    double value = randomDoubleBetween(-100d, 100d, true);  
            assertEquals(0.0d, stats.getVariancePopulation(), TOLERANCE);
        void add(double value) {
        testCase(ft, iw -> {  
            assertEquals(expected.varianceSampling(), stats.getVarianceSampling(), TOLERANCE);
 * ownership. Elasticsearch licenses this file to you under  
        for (double value : values) {  
        testCase(ft, iw -> {}, stats -> {
            assertEquals(expected.max, stats.getMax(), 0);
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
                    expected.add(value);  
                TOLERANCE
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);
        }
                    doc.add(new SortedNumericDocValuesField("field", valueAsLong));
package org.opensearch.search.aggregations.metrics;
            assertEquals(0.0d, stats.getStdDeviationPopulation(), TOLERANCE);
    public void testSummationAccuracy() throws IOException {
                    return (sum / count) - (Math.sqrt(variancePopulation()) * sigma);
            double variance = (sumOfSqrs - ((sum * sum) / count)) / count;  
                TOLERANCE
            sumOfSqrs += (value * value);  
                TOLERANCE
 * Unless required by applicable law or agreed to in writing,
            assertEquals(  
 */  
 * You may obtain a copy of the License at  
        MappedFieldType ft,  
        double expectedMax = max;
        }
                TOLERANCE
        verifyStatsOfDoubles(values, sum, sumOfSqrs, TOLERANCE);  
        testCase(ft, iw -> {  
            );
 *  
            }  
            assertEquals(0d, stats.getSum(), 0);  
            assertEquals(  
            assertEquals(
        verifyStatsOfDoubles(values, 13.5, 16.21, 0d);
/*  
            return Math.sqrt(variancePopulation());
            sumOfSqrs += values[i] * values[i];
            return variance < 0 ? 0 : variance;  
                }  
        testCase(ft, iw -> {  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(0.0d, stats.getStdDeviation(), TOLERANCE);  
            assertEquals(0d, stats.getSumOfSquares(), 0);
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER_SAMPLING),
import org.apache.lucene.tests.index.RandomIndexWriter;
        }  
        for (int i = 0; i < n; i++) {
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);  
            assertEquals(expected.sumOfSqrs, stats.getSumOfSquares(), TOLERANCE);
    }
    }
                TOLERANCE
            assertEquals(Double.NEGATIVE_INFINITY, stats.getMax(), 0);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        });
            int numDocs = randomIntBetween(10, 50);
            assertEquals(
                case UPPER_SAMPLING:  
        }, stats -> {
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER_POPULATION),
        }
        double max = Double.NEGATIVE_INFINITY;
            for (double value : values) {
                    return (sum / count) + (Math.sqrt(varianceSampling()) * sigma);
                    long value = randomIntBetween(-100, 100);  
        });
                Document doc = new Document();  
        }
        double varianceSampling() {
            super.add(value);
            assertEquals(expected.variancePopulation(), stats.getVariancePopulation(), TOLERANCE);
        }  
            }  
            for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.index.IndexReader;
import org.opensearch.search.aggregations.AggregatorTestCase;
            assertEquals(expectedSumOfSqrs, stats.getSumOfSquares(), delta);
        n = randomIntBetween(5, 10);  
    }
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
                    .sigma(randomDoubleBetween(0, 10, true));  
                expected.stdDevBound(ExtendedStats.Bounds.UPPER_SAMPLING, stats.getSigma()),  
            assertEquals(
                    throw new IllegalArgumentException("Unknown bound " + bounds);  
     */
            assertEquals(expectedSum, stats.getSum(), delta);
    public void testVarianceNonNegative() throws IOException {  
            return variancePopulation();
                TOLERANCE  
            assertEquals(0d, stats.getCount(), 0);
            );
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
            assertEquals(Double.NaN, stats.getVariance(), 0);
        final ExtendedSimpleStatsAggregator expected = new ExtendedSimpleStatsAggregator();
            assertTrue(AggregationInspectionHelper.hasValue(stats));
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER),  
        }  
            assertEquals(expected.stdDevSampling(), stats.getStdDeviationSampling(), TOLERANCE);
            );  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.mapper.MappedFieldType;
            assertEquals(Float.NaN, stats.getAvg(), 0);
        testCase(ft, iw -> {  
                expected.add(value);
            assertEquals(0.0d, stats.getVariance(), TOLERANCE);  
            );
            assertEquals(expected.max, stats.getMax(), 0);
            assertEquals(Double.NaN, stats.getVarianceSampling(), 0);  
            min = Math.min(min, value);
        double sumOfSqrs = 0;
 * compatible open source license.
            largeValues[i] = -Double.MAX_VALUE;
            assertEquals(
            // since the value(49.95) is a constant, variance should be 0
            assertEquals(expected.min, stats.getMin(), 0);
                expected.stdDevBound(ExtendedStats.Bounds.UPPER, stats.getSigma()),
/*
                TOLERANCE  
                TOLERANCE  
                for (int j = 0; j < numValues; j++) {
            );
                expected.stdDevBound(ExtendedStats.Bounds.LOWER_POPULATION, stats.getSigma()),  
            );
            }
                case LOWER_SAMPLING:  
        for (int i = 0; i < n; i++) {
            assertEquals(expected.stdDevPopulation(), stats.getStdDeviationPopulation(), TOLERANCE);
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER),
                int numValues = randomIntBetween(1, 5);
            assertEquals(  
            assertEquals(Double.NaN, stats.getVariancePopulation(), 0);
        });  
        verifyStatsOfDoubles(largeValues, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d);
public class ExtendedStatsAggregatorTests extends AggregatorTestCase {  
import org.apache.lucene.document.Document;
                TOLERANCE
            assertEquals(Double.NaN, stats.getStdDeviationPopulation(), 0);
            max = Math.max(max, value);
    /**  
                    long valueAsLong = NumericUtils.doubleToSortableLong(value);
    }
                iw.addDocument(doc);
                expected.stdDevBound(ExtendedStats.Bounds.UPPER_SAMPLING, stats.getSigma()),
            );
        double variancePopulation() {
                    return (sum / count) - (Math.sqrt(varianceSampling()) * sigma);
            assertEquals(expected.variance(), stats.getVariance(), TOLERANCE);
            assertEquals(expected.varianceSampling(), stats.getVarianceSampling(), TOLERANCE);  
                iw.addDocument(doc);
            assertEquals(
            assertEquals(expected.stdDevPopulation(), stats.getStdDeviationPopulation(), TOLERANCE);  
                case LOWER_POPULATION:
}  
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.document.NumericDocValuesField;
    public void testRandomDoubles() throws IOException {  
            return variance < 0 ? 0 : variance;
        }
            values[i] = frequently()  
                doc.add(new SortedNumericDocValuesField("field", valueAsLong));  
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER_POPULATION),
                expected.stdDevBound(ExtendedStats.Bounds.UPPER_POPULATION, stats.getSigma()),  
            }  
                IndexSearcher searcher = new IndexSearcher(reader);
            assertEquals(expected.sumOfSqrs, stats.getSumOfSquares(), TOLERANCE);  
        double stdDevSampling() {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.DOUBLE);
        }
    public void testEmpty() throws IOException {
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberFieldMapper.NumberType.LONG);  
    }  
            assertEquals(Double.NaN, stats.getStdDeviationSampling(), 0);  
 * license agreements. See the NOTICE file distributed with
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER_POPULATION),
        final ExtendedSimpleStatsAggregator expected = new ExtendedSimpleStatsAggregator();
                stats.getStdDeviationBound(ExtendedStats.Bounds.UPPER_SAMPLING),
            for (int i = 0; i < numDocs; i++) {
                for (int j = 0; j < numValues; j++) {
            assertEquals(  
                    expected.add(value);
                expected.stdDevBound(ExtendedStats.Bounds.UPPER_POPULATION, stats.getSigma()),
            );  
    // TODO: Add script test cases. Should fail with defaultValuesSourceType() commented out.  
 * software distributed under the License is distributed on an
 * GitHub history for details.
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER),  
        int n = randomIntBetween(5, 10);
        }, stats -> {  
            int numDocs = 3;
 * specific language governing permissions and limitations
                    doc.add(new SortedNumericDocValuesField("field", value));
            buildIndex.accept(indexWriter);
        }, stats -> {
            assertEquals(
            int numDocs = randomIntBetween(10, 50);
 */
                    return (sum / count) - (Math.sqrt(variance()) * sigma);  
            assertTrue(AggregationInspectionHelper.hasValue(stats));
        Consumer<InternalExtendedStats> verify
        // Summing up some big double values and expect infinity result
 * this work for additional information regarding copyright
        }, stats -> {
     * Testcase for https://github.com/elastic/elasticsearch/issues/37303
        double stdDevBound(ExtendedStats.Bounds bounds, double sigma) {  
        }
 * not use this file except in compliance with the License.
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) throws IOException {  
        });  
                Document doc = new Document();  
            switch (bounds) {
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
        double[] largeValues = new double[n];
                stats.getStdDeviationBound(ExtendedStats.Bounds.LOWER_SAMPLING),
        double sumOfSqrs = 0;
    }
 * KIND, either express or implied.  See the License for the
/*  
        double min = Double.POSITIVE_INFINITY;
                iw.addDocument(doc);
                ExtendedStatsAggregationBuilder aggBuilder = new ExtendedStatsAggregationBuilder("my_agg").field("field")
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        for (int i = 0; i < n; i++) {
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation  
