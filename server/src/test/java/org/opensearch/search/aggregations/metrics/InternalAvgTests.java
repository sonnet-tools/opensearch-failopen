        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> avg.reduce(aggregations, null));
    }
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
 * Licensed to Elasticsearch under one or more contributor
public class InternalAvgTests extends InternalAggregationTestCase<InternalAvg> {
        InternalAvg reduced = internalAvg.reduce(aggregations, null);
        }
    public void testReduceWithScriptedMetricInvalidArrayLength() {
import java.util.List;
    }
        // Expected values:
        aggregations.add(new InternalAvg(name, 50.0, 10L, formatter, null));
        List<InternalAggregation> aggregations = new ArrayList<>();
        // Total: sum=150.0, count=30
        double[] largeValues = new double[n];
        int n = randomIntBetween(5, 10);
        double sum = instance.getSum();
        InternalAvg reduced = avg.reduce(aggregations, null);
                    sum += between(1, 100);
        DocValueFormat formatter = randomNumericDocValueFormat();
        long count = frequently() ? randomNonNegativeLong() % 100000 : 0;
                    count += between(1, 100);
import org.opensearch.test.InternalAggregationTestCase;
            assertEquals(avg.getValueAsString(), parsed.getValueAsString());
        String name = "test_scripted_metric";
                }
 * this work for additional information regarding copyright
        assertEquals(
        String name = "test_scripted_metric";
        for (int i = 0; i < n; i++) {
        assertEquals(5.0, reduced.getValue(), 0.0000001);  // 300/60
import java.util.ArrayList;
                break;
 * GitHub history for details.
 *
                break;
            largeValues[i] = -Double.MAX_VALUE;
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to
        }
            case 3:
        // Add multiple InternalAvg aggregations
            values[i] = frequently()
                if (Double.isFinite(sum)) {
            "Invalid ScriptedMetric result for [test_scripted_metric] avg aggregation. Expected ScriptedAvg but received [[D]",
                } else {
        values = new double[n];
    }
import org.opensearch.search.aggregations.ParsedAggregation;
    }
        // Add regular InternalAvg
        return new InternalAvg(name, sum, count, formatter, metadata);
        DocValueFormat formatter = randomNumericDocValueFormat();
        assertEquals(counts, reduced.getCount());
                metadata.put(randomAlphaOfLength(15), randomInt());
    public void testSummationAccuracy() {
        List<InternalAggregation> aggregations = new ArrayList<>();
 */
            case 2:
        assertEquals(300.0, reduced.getSum(), 0.0000001);
            counts += in.getCount();
        for (int i = 0; i < n; i++) {
        switch (between(0, 2)) {
        List<Object> aggList = new ArrayList<>();
        verifyAvgOfDoubles(values, 0.9, 0d);
        assertEquals(sum / counts, reduced.value(), 0.0000001);
    }
    public void testReduceWithInternalAvgAggregation() {
        double sum = 0;
        DocValueFormat formatter = randomNumericDocValueFormat();
        // Expected values:
        // From InternalAvg: sum=50.0, count=10
        );
        aggregations.add(new InternalAvg(name, 50.0, 10L, formatter, null));
        aggList.add("invalid_type");
            largeValues[i] = Double.MAX_VALUE;
    }
        // count = 10 + 20 + 30 = 60
    protected InternalAvg createTestInstance(String name, Map<String, Object> metadata) {
        }
        List<Object> aggList = new ArrayList<>();
    protected InternalAvg mutateInstance(InternalAvg instance) {
                } else {
        aggList.add(new double[] { 100.0, 20.0, 30.0 });  // Add double array to list
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
}
        verifyAvgOfDoubles(values, sum / n, TOLERANCE);
        // Add ScriptedMetric with invalid return type (String instead of double[])
        if (avg.getCount() != 0) {
        aggregations.add(new InternalAvg(name, 150.0, 30L, formatter, null));
    @Override
        assertEquals(
    }
    @Override
        // From scriptedMetric1: sum=100.0, count=20
    }
    protected void assertReduced(InternalAvg reduced, List<InternalAvg> inputs) {
package org.opensearch.search.aggregations.metrics;
        assertEquals(60L, reduced.getCount());
        // Add regular InternalAvg
            default:
 * specific language governing permissions and limitations
        String name = instance.getName();
    }
        for (int i = 0; i < n; i++) {
            sum += values[i];
 */
        InternalAvg avg = new InternalAvg(name, 0.0, 0L, formatter, null);
        List<Object> aggList = new ArrayList<>();
        }
    protected void assertFromXContent(InternalAvg avg, ParsedAggregation parsedAggregation) {
        }
 * not use this file except in compliance with the License.
    public void testReduceWithScriptedMetric() {
        // Expect an IllegalArgumentException when reducing with invalid type
 */
        }
        DocValueFormat formatter = randomNumericDocValueFormat();
        when(scriptedMetric1.getName()).thenReturn(name);
        aggregations.add(new InternalAvg(name, 100.0, 20L, formatter, null));
        // Add ScriptedMetric with double array of wrong length (should be 2)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        when(scriptedMetric.aggregationsList()).thenReturn(aggList);
 *    http://www.apache.org/licenses/LICENSE-2.0
        n = randomIntBetween(5, 10);
        InternalAvg reduced = avg.reduce(aggregations, null);
 * SPDX-License-Identifier: Apache-2.0
        long count = instance.getCount();
        // we don't print out VALUE_AS_STRING for avg.getCount() == 0, so we cannot get the exact same value back
        aggregations.add(scriptedMetric1);
                    metadata = new HashMap<>(1);
        aggregations.add(scriptedMetric);
        for (InternalAvg in : inputs) {
                    count = between(1, 100);
        );
        String name = "test_avg";
 * the Apache License, Version 2.0 (the "License"); you may
            "Invalid ScriptedMetric result for [test_scripted_metric] avg aggregation. Expected ScriptedAvg but received [java.lang.String]",
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        assertEquals(avg.getValue(), parsed.getValue(), Double.MIN_VALUE);
                    sum = between(1, 100);
 *
                }
            e.getMessage()
            aggregations.add(new InternalAvg("dummy1", value, 1, null, null));
import org.opensearch.search.aggregations.InternalAggregation;
 *
    private void verifyAvgOfDoubles(double[] values, double expected, double delta) {
        aggregations.add(new InternalAvg(name, 50.0, 10L, formatter, null));
    @Override
        List<InternalAggregation> aggregations = new ArrayList<>();
        assertEquals(5.0, reduced.getValue(), 0.0000001);  // 150/30
            case 1:
        aggList.add(new ScriptedAvg(100.0, 20L));
            e.getMessage()
        // Add ScriptedMetric with ScriptedAvg object
 * license agreements. See the NOTICE file distributed with
        aggregations.add(new InternalAvg(name, 50.0, 10L, formatter, null));
 * this file be licensed under the Apache-2.0 license or a
        // Expect an IllegalArgumentException when reducing with invalid array length
        when(scriptedMetric1.aggregationsList()).thenReturn(aggList);
        verifyAvgOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);
        InternalAvg avg = new InternalAvg(name, 0.0, 0L, formatter, null);
        long counts = 0;
        // Add regular InternalAvg
        assertEquals(150.0, reduced.getSum(), 0.0000001);
        InternalAvg avg = new InternalAvg(name, 0.0, 0L, formatter, null);
        DocValueFormat formatter = instance.getFormatter();
        InternalScriptedMetric scriptedMetric = mock(InternalScriptedMetric.class);
 * KIND, either express or implied.  See the License for the
import java.util.HashMap;
        ParsedAvg parsed = ((ParsedAvg) parsedAggregation);
        verifyAvgOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
        InternalScriptedMetric scriptedMetric1 = mock(InternalScriptedMetric.class);
/*
        // Summing up some big double values and expect infinity result
 * Unless required by applicable law or agreed to in writing,
        Map<String, Object> metadata = instance.getMetadata();
        }
 * ownership. Elasticsearch licenses this file to you under
    @Override
                name += randomAlphaOfLength(5);
                throw new AssertionError("Illegal randomisation branch");
        aggregations.add(scriptedMetric1);
        List<InternalAggregation> aggregations = new ArrayList<>(values.length);
/*
                if (Double.isFinite(count)) {
/*
                break;
                } else {
        InternalAvg avg = new InternalAvg(name, 0.0, 0L, formatter, null);
    public void testReduceWithScriptedMetricInvalidType() {
        when(scriptedMetric1.getName()).thenReturn(name);
        assertEquals(sum, reduced.getSum(), 0.0000001);
                    metadata = new HashMap<>(instance.getMetadata());
        DocValueFormat formatter = randomNumericDocValueFormat();
        List<InternalAggregation> aggregations = new ArrayList<>();
                if (metadata == null) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> avg.reduce(aggregations, null));
    }
        for (double value : values) {
import static org.mockito.Mockito.mock;
        double sum = 0;
                break;
import java.util.Map;
        when(scriptedMetric1.aggregationsList()).thenReturn(aggList);
        InternalAvg internalAvg = new InternalAvg("dummy2", 0, 0, null, null);
 * You may obtain a copy of the License at
import org.opensearch.search.DocValueFormat;
            case 0:
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
        // sum = 50.0 + 100.0 + 150.0 = 300.0
        when(scriptedMetric.getName()).thenReturn(name);
        String name = "test_scripted_metric";
        InternalScriptedMetric scriptedMetric1 = mock(InternalScriptedMetric.class);
            sum += in.getSum();
                }
        assertEquals(30L, reduced.getCount());
 * compatible open source license.
        assertEquals(expected, reduced.getValue(), delta);
        return new InternalAvg(name, randomDoubleBetween(0, 100000, true), count, formatter, metadata);
 * under the License.
