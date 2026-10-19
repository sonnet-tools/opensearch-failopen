     * Generates a mock histogram to use for testing.  Each MockBucket holds a doc count, key and document values
                // add to the existing gap  
 * SPDX-License-Identifier: Apache-2.0
        } else if (metric instanceof SumAggregationBuilder) {
                accumulator = Math.min(accumulator, value);
        public long key;  
 * license agreements. See the NOTICE file distributed with
        ArrayList<MockBucket> values = new ArrayList<>(size);  
     * @param size              Size of mock histogram to generate (in buckets)
 * Unless required by applicable law or agreed to in writing,
            for (int j = 0; j < bucket.count; j++) {  
    public static double calculateMetric(double[] values, ValuesSourceAggregationBuilder<?> metric) {  
import org.opensearch.search.aggregations.metrics.MinAggregationBuilder;
                bucket.count = randomIntBetween(1, 50);  
 * KIND, either express or implied.  See the License for the
    }  
                lastWasGap = true;
     * Computes a simple agg metric (min, sum, etc) from the provided values
                bucket.count = 0;
            for (double value : values) {
            }
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
            return accumulator;
        public double[] docValues;
/*  
     */
    /**  
 * You may obtain a copy of the License at  
    static AggregationBuilder getRandomSequentiallyOrderedParentAgg() throws IOException {
                bucket.docValues = new double[0];
     * @param values Array of values to compute metric for  
 * The OpenSearch Contributors require contributions made to  
    public static ArrayList<MockBucket> generateHistogram(int interval, int size, double gapProbability, double runProbability) {
import java.util.function.Function;
            values.set(idx, bucket);  
            for (double value : values) {
            } else if (lastWasGap && randomDouble() < runProbability) {
        Function<String, AggregationBuilder> builder = randomFrom(  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
            } else {
        boolean emptyHisto = true;  
    }
            values.add(bucket);
            }  
        }
            double accumulator = 0;  
                emptyHisto = false;  
     * which can later be used to compute metrics and compare against the real aggregation results.  Gappiness can be  
        for (int i = 0; i < size; i++) {
            bucket.docValues = new double[bucket.count];
 */
            for (double value : values) {
        boolean lastWasGap = false;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
            int idx = randomIntBetween(0, values.size() - 1);
    }
                accumulator = Math.max(accumulator, value);
        return builder.apply("name");
    /**  
            double accumulator = Double.NEGATIVE_INFINITY;  
        }
                bucket.docValues[j] = randomDouble() * randomIntBetween(-20, 20);
     * @param metric A metric builder which defines what kind of metric should be returned for the values
 * GitHub history for details.
 */  
     * @param gapProbability    Probability of generating an empty bucket. 0.0-1.0 inclusive
 *
 * the Apache License, Version 2.0 (the "License"); you may
            return accumulator;
import org.opensearch.search.aggregations.AggregationBuilder;
     *
            }  
     */
 *
     * @param runProbability    Probability of extending a gap once one has been created.  0.0-1.0 inclusive  
        @SuppressWarnings("unchecked")
                lastWasGap = false;
            HistogramAggregationBuilder::new,
            AutoDateHistogramAggregationBuilder::new  
                }
     * @param interval          Interval between bucket keys  
    public static class MockBucket {  
import org.opensearch.search.aggregations.metrics.SumAggregationBuilder;
                accumulator += value;
                bucket.docValues = new double[bucket.count];
/*  
            }  
            DateHistogramAggregationBuilder::new,
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
     */
            bucket.count = randomIntBetween(1, 50);
            if (randomDouble() < gapProbability) {
        } else if (metric instanceof MaxAggregationBuilder) {
import java.io.IOException;  
            for (double value : values) {
        if (emptyHisto) {
     * controlled via parameters
}
 */  
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
                    bucket.docValues[j] = randomDouble() * randomIntBetween(-20, 20);  
                lastWasGap = true;  
 */
 * under the License.  
import java.util.ArrayList;
        public int count;
            return accumulator;
 * such as creating mock histograms or computing simple metrics  
/**
 * this work for additional information regarding copyright
        } else if (metric instanceof AvgAggregationBuilder) {
 * specific language governing permissions and limitations
        }
            double accumulator = Double.POSITIVE_INFINITY;  
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
        return 0.0;
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
                bucket.docValues = new double[0];
     * Simple mock bucket container
 * this file be licensed under the Apache-2.0 license or a
            bucket.key = i * interval;  
 *  
                bucket.count = 0;  
                // start a gap
            }
import org.opensearch.search.aggregations.metrics.MaxAggregationBuilder;  
public class PipelineAggregationHelperTests extends OpenSearchTestCase {
    }
            return accumulator / values.length;
 * software distributed under the License is distributed on an
/*
import org.opensearch.test.OpenSearchTestCase;
            double accumulator = 0;  
            MockBucket bucket = values.get(idx);  
        );
    /**
package org.opensearch.search.aggregations.pipeline;
            }  
        return values;  
            MockBucket bucket = new MockBucket();  
 * Licensed to Elasticsearch under one or more contributor  
 * Provides helper methods and classes for use in PipelineAggregation tests,
     *
        if (metric instanceof MinAggregationBuilder) {
                accumulator += value;
                for (int j = 0; j < bucket.count; j++) {
