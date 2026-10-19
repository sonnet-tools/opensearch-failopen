                break;
                expectedMax = stats.getMax();
        assertEquals(count > 0 ? aggregation.getSumOfSquares() : 0, parsed.getSumOfSquares(), 0);
        DocValueFormat formatter,
                } else {  
        DocValueFormat format = randomNumericDocValueFormat();
            expectedCount += stats.getCount();
            0
 *
    }
        }
                break;
            case 4:  
 * ownership. Elasticsearch licenses this file to you under  
        InternalStatsTests.assertStats(aggregation, parsed);  
                    min = between(1, 100);  
        assertEquals(expectedSumOfSqrs, reduced.getSumOfSquares(), delta);  
        double expectedMax = Double.NEGATIVE_INFINITY;
                if (Double.isFinite(count)) {
        Map<String, Object> metadata = instance.getMetadata();
                    sum = between(1, 100);
                throw new AssertionError("Illegal randomisation branch");  
/*  
            if (Double.compare(stats.getMin(), expectedMin) < 0) {  
        verifySumOfSqrsOfDoubles(values, sum, TOLERANCE);  
                    count += between(1, 100);
            assertEquals(aggregation.getStdDeviationBoundAsString(Bounds.UPPER), parsed.getStdDeviationBoundAsString(Bounds.UPPER));
        for (int i = 0; i < n; i++) {
        String name = instance.getName();
 */  
        double min,  
 */
        return createInstance(name, count, sum, min, max, randomDoubleBetween(0, 1000000, true), sigma, format, metadata);
        n = randomIntBetween(5, 10);  
 * specific language governing permissions and limitations
            parsed.getStdDeviationBound(Bounds.UPPER_POPULATION),
package org.opensearch.search.aggregations.metrics;
 * license agreements. See the NOTICE file distributed with
            aggregations.add(new InternalExtendedStats("dummy1", 1, 0.0, 0.0, 0.0, sumOfSqrs, sigma, null, null));
    @Override  
        );
                } else {
 * The OpenSearch Contributors require contributions made to  
        assertEquals(
        assertEquals(  
                if (Double.isFinite(min)) {  
    }  
                    min += between(1, 100);
        double expectedSum = 0;
                if (Double.isFinite(sum)) {
 * You may obtain a copy of the License at  
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);  
        assertEquals(sigma, reduced.getSigma(), 0);  
    protected void assertReduced(InternalExtendedStats reduced, List<InternalExtendedStats> inputs) {  
        verifySumOfSqrsOfDoubles(values, 13.5, 0d);
            default:
        Map<String, Object> metadata
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
/*
            case 6:
        // The order in which you add double values in java can give different results. The difference can
        double sigma = instance.getSigma();
        if (count > 0) {
        values = new double[n];
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(expectedSum, reduced.getSum(), Math.abs(expectedSum) * 1e-10);
        verifySumOfSqrsOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
 * the Apache License, Version 2.0 (the "License"); you may
        double sumOfSqrs,
                }
            case 0:  
import java.util.ArrayList;
        switch (between(0, 7)) {
            case 3:
    protected InternalExtendedStats mutateInstance(InternalExtendedStats instance) {
            case 5:
        double min = randomDoubleBetween(-1000000, 1000000, true);
        );  
        }
    }
            count > 0 ? aggregation.getStdDeviationBound(Bounds.UPPER_POPULATION) : 0,
        }  
                }
            case 2:
        String name,  
import org.opensearch.search.DocValueFormat;
        double[] largeValues = new double[n];
                } else {  
        // be larger for large sum values, so we make the delta in the assertion depend on the values magnitude  
            0
                }
            );  
                    sigma = between(1, 10);  
                break;
 * not use this file except in compliance with the License.
        assertEquals(expectedMax, reduced.getMax(), 0d);  
        assertEquals(count > 0 ? aggregation.getStdDeviationSampling() : 0, parsed.getStdDeviationSampling(), 0);
                    metadata = new HashMap<>(instance.getMetadata());
    }  
    }
        for (InternalExtendedStats stats : inputs) {  
            largeValues[i] = -Double.MAX_VALUE;
                } else {
        // for count == 0, fields are rendered as `null`, so we test that we parse to default values used also in the reduce phase  
            case 1:  
            assertEquals(aggregation.getVarianceSamplingAsString(), parsed.getVarianceSamplingAsString());
            assertEquals(
        this.sigma = randomDoubleBetween(0, 10, true);
    private void verifySumOfSqrsOfDoubles(double[] values, double expectedSumOfSqrs, double delta) {
        // also as_string values are only rendered for count != 0  
    }  
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
            count > 0 ? aggregation.getStdDeviationBound(Bounds.LOWER_SAMPLING) : 0,  
        super.setUp();  
 * Unless required by applicable law or agreed to in writing,
                } else {
                break;  
    protected void assertFromXContent(InternalExtendedStats aggregation, ParsedAggregation parsedAggregation) {  
    @Override
        );
                }
}
            }
        double sum,
                    sumOfSqrs += between(1, 100);  
import org.opensearch.search.aggregations.ParsedAggregation;  
    @Override
                }
        }
                    sumOfSqrs = between(1, 100);
            assertEquals(aggregation.getStdDeviationBoundAsString(Bounds.LOWER), parsed.getStdDeviationBoundAsString(Bounds.LOWER));  
        double sigma,  
            largeValues[i] = Double.MAX_VALUE;  
                expectedMin = stats.getMin();
            assertEquals(aggregation.getStdDeviationPopulationAsString(), parsed.getStdDeviationPopulationAsString());
        double expectedSumOfSquare = 0;  
        InternalExtendedStats reduced = stats.reduce(aggregations, null);
            assertEquals(sigma, stats.getSigma(), 0);
                if (Double.isFinite(max)) {
        // Summing up some big double values and expect infinity result
        long count = instance.getCount();  
            assertEquals(
        assertEquals(count > 0 ? aggregation.getStdDeviation() : 0, parsed.getStdDeviation(), 0);
                if (Double.isFinite(sigma)) {  
                    sum += between(1, 100);  
                if (Double.isFinite(sumOfSqrs)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            count > 0 ? aggregation.getStdDeviationBound(Bounds.UPPER_SAMPLING) : 0,
                    count = between(1, 100);
                    metadata = new HashMap<>(1);
        assertEquals(count > 0 ? aggregation.getVariance() : 0, parsed.getVariance(), 0);
/*  
            }
                break;
            if (Double.compare(stats.getMax(), expectedMax) > 0) {  
import java.util.HashMap;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
            parsed.getStdDeviationBound(Bounds.UPPER_SAMPLING),  
        return new InternalExtendedStats(name, count, sum, min, max, sumOfSqrs, sigma, formatter, metadata);
            0  
                } else {  
                aggregation.getStdDeviationBoundAsString(Bounds.UPPER_SAMPLING),  
        assertEquals(count > 0 ? aggregation.getVariancePopulation() : 0, parsed.getVariancePopulation(), 0);  
        double max = randomDoubleBetween(-1000000, 1000000, true);
    @Override
        assertEquals(
                    max = between(1, 100);
        assertEquals(count > 0 ? aggregation.getVarianceSampling() : 0, parsed.getVarianceSampling(), 0);
                aggregation.getStdDeviationBoundAsString(Bounds.LOWER_POPULATION),  
    }
        for (int i = 0; i < n; i++) {  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
        double sumOfSqrs = instance.getSumOfSquares();
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(  
public class InternalExtendedStatsTests extends InternalAggregationTestCase<InternalExtendedStats> {  
 */  
        double sigma = randomDouble();  
            );
            parsed.getStdDeviationBound(Bounds.LOWER_SAMPLING),
        double sum = instance.getSum();
        assertEquals(expectedSumOfSquare, reduced.getSumOfSquares(), expectedSumOfSquare * 1e-14);
                break;
    public void setUp() throws Exception {
    private double sigma;
            values[i] = frequently()
        // summing squared values, see reason for delta above
 *
        DocValueFormat formatter = instance.format;  
        long count = frequently() ? randomIntBetween(1, Integer.MAX_VALUE) : 0;  
            assertEquals(
                break;  
        assertTrue(parsedAggregation instanceof ParsedExtendedStats);
import org.opensearch.test.InternalAggregationTestCase;
                    sigma += between(1, 10);
import org.opensearch.search.aggregations.metrics.ExtendedStats.Bounds;
            assertEquals(aggregation.getVarianceAsString(), parsed.getVarianceAsString());  
        List<InternalAggregation> aggregations = new ArrayList<>(values.length);
    protected InternalExtendedStats createInstance(
            assertEquals(aggregation.getStdDeviationAsString(), parsed.getStdDeviationAsString());  
        long count = aggregation.getCount();
                parsed.getStdDeviationBoundAsString(Bounds.UPPER_SAMPLING)
            assertEquals(aggregation.getVariancePopulationAsString(), parsed.getVariancePopulationAsString());
        long count,
        ParsedExtendedStats parsed = (ParsedExtendedStats) parsedAggregation;
        assertEquals(expectedMin, reduced.getMin(), 0d);
                }  
            expectedSumOfSquare += stats.getSumOfSquares();
            );
        for (double sumOfSqrs : values) {
        assertEquals(count > 0 ? aggregation.getStdDeviationBound(Bounds.UPPER) : 0, parsed.getStdDeviationBound(Bounds.UPPER), 0);  
 * compatible open source license.
            assertEquals(aggregation.getSumOfSquaresAsString(), parsed.getSumOfSquaresAsString());
                aggregation.getStdDeviationBoundAsString(Bounds.LOWER_SAMPLING),
            count > 0 ? aggregation.getStdDeviationBound(Bounds.LOWER_POPULATION) : 0,
            sum += values[i];
        double min = instance.getMin();
            parsed.getStdDeviationBound(Bounds.LOWER_POPULATION),  
                parsed.getStdDeviationBoundAsString(Bounds.UPPER_POPULATION)
    ) {  
        InternalExtendedStats stats = new InternalExtendedStats("dummy", 1, 0.0, 0.0, 0.0, 0.0, sigma, null, null);
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
                parsed.getStdDeviationBoundAsString(Bounds.LOWER_POPULATION)
        }
        assertEquals(expectedCount, reduced.getCount());
        verifySumOfSqrsOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);
        int n = randomIntBetween(5, 10);  
 *  
    public void testSummationAccuracy() {
            );
 * under the License.  
        return new InternalExtendedStats(name, count, sum, min, max, sumOfSqrs, sigma, formatter, metadata);
        assertEquals(
        double sum = randomDoubleBetween(-1000000, 1000000, true);  
                if (metadata == null) {
                aggregation.getStdDeviationBoundAsString(Bounds.UPPER_POPULATION),
                } else {
        double expectedMin = Double.POSITIVE_INFINITY;
        assertEquals(count > 0 ? aggregation.getStdDeviationBound(Bounds.LOWER) : 0, parsed.getStdDeviationBound(Bounds.LOWER), 0);
        double sum = 0;
                    max += between(1, 100);
                name += randomAlphaOfLength(5);
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(count > 0 ? aggregation.getStdDeviationPopulation() : 0, parsed.getStdDeviationPopulation(), 0);  
                metadata.put(randomAlphaOfLength(15), randomInt());  
            0
                }  
            expectedSum += stats.getSum();  
import java.util.List;  
            case 7:  
                parsed.getStdDeviationBoundAsString(Bounds.LOWER_SAMPLING)  
        double max,
                break;
    protected InternalExtendedStats createTestInstance(String name, Map<String, Object> metadata) {
        );
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };  
        double max = instance.getMax();  
        }  
        for (int i = 0; i < n; i++) {
        long expectedCount = 0;
import java.util.Map;
            assertEquals(aggregation.getStdDeviationSamplingAsString(), parsed.getStdDeviationSamplingAsString());
        }  
