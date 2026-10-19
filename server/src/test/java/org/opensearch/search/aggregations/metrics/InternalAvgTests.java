        }
import org.opensearch.search.DocValueFormat;
        }  
                if (Double.isFinite(sum)) {  
            case 3:
        ParsedAvg parsed = ((ParsedAvg) parsedAggregation);
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
            "Invalid ScriptedMetric result for [test_scripted_metric] avg aggregation. Expected ScriptedAvg but received [java.lang.String]",
        DocValueFormat formatter = randomNumericDocValueFormat();
                break;  
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)  
        List<Object> aggList = new ArrayList<>();
    }  
        for (double value : values) {
 * under the License.  
    public void testSummationAccuracy() {  
        switch (between(0, 2)) {
        assertEquals(counts, reduced.getCount());
        List<InternalAggregation> aggregations = new ArrayList<>();
            case 0:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        DocValueFormat formatter = randomNumericDocValueFormat();
            counts += in.getCount();
        List<InternalAggregation> aggregations = new ArrayList<>();
        List<Object> aggList = new ArrayList<>();  
import static org.mockito.Mockito.when;  
        when(scriptedMetric1.aggregationsList()).thenReturn(aggList);  
 * the Apache License, Version 2.0 (the "License"); you may
            case 2:  
import java.util.HashMap;
        List<InternalAggregation> aggregations = new ArrayList<>();
        String name = instance.getName();
                } else {
    private void verifyAvgOfDoubles(double[] values, double expected, double delta) {
        InternalScriptedMetric scriptedMetric1 = mock(InternalScriptedMetric.class);
        // Add ScriptedMetric with ScriptedAvg object  
        }
        // Summing up some big double values and expect infinity result  
        List<InternalAggregation> aggregations = new ArrayList<>(values.length);  
        // we don't print out VALUE_AS_STRING for avg.getCount() == 0, so we cannot get the exact same value back
    }
 * this file be licensed under the Apache-2.0 license or a
        // Expected values:  
        DocValueFormat formatter = instance.getFormatter();
                } else {
                    count += between(1, 100);
        aggregations.add(new InternalAvg(name, 50.0, 10L, formatter, null));
    public void testReduceWithScriptedMetricInvalidType() {
    protected void assertFromXContent(InternalAvg avg, ParsedAggregation parsedAggregation) {
    protected InternalAvg createTestInstance(String name, Map<String, Object> metadata) {
            largeValues[i] = Double.MAX_VALUE;
    @Override  
                break;
        long count = instance.getCount();
import java.util.List;
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
        for (int i = 0; i < n; i++) {
        for (InternalAvg in : inputs) {  
        aggList.add(new ScriptedAvg(100.0, 20L));
                    metadata = new HashMap<>(1);  
                    metadata = new HashMap<>(instance.getMetadata());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> avg.reduce(aggregations, null));
        assertEquals(150.0, reduced.getSum(), 0.0000001);
        InternalAvg avg = new InternalAvg(name, 0.0, 0L, formatter, null);  
        aggregations.add(new InternalAvg(name, 50.0, 10L, formatter, null));
        for (int i = 0; i < n; i++) {
            "Invalid ScriptedMetric result for [test_scripted_metric] avg aggregation. Expected ScriptedAvg but received [[D]",
 *  
        aggregations.add(scriptedMetric1);  
import static org.mockito.Mockito.mock;
        assertEquals(30L, reduced.getCount());  
 * You may obtain a copy of the License at  
        // From InternalAvg: sum=50.0, count=10  
    protected void assertReduced(InternalAvg reduced, List<InternalAvg> inputs) {  
        verifyAvgOfDoubles(values, sum / n, TOLERANCE);
            default:  
/*  
    public void testReduceWithScriptedMetricInvalidArrayLength() {
 * license agreements. See the NOTICE file distributed with
        assertEquals(sum, reduced.getSum(), 0.0000001);
        assertEquals(avg.getValue(), parsed.getValue(), Double.MIN_VALUE);  
        // Add regular InternalAvg  
 * this work for additional information regarding copyright
        InternalScriptedMetric scriptedMetric1 = mock(InternalScriptedMetric.class);
        when(scriptedMetric.aggregationsList()).thenReturn(aggList);
            e.getMessage()
}
                break;
        return new InternalAvg(name, randomDoubleBetween(0, 100000, true), count, formatter, metadata);
        // count = 10 + 20 + 30 = 60
        double sum = 0;
 *
        List<InternalAggregation> aggregations = new ArrayList<>();
    }  
        InternalAvg reduced = avg.reduce(aggregations, null);  
        );
        DocValueFormat formatter = randomNumericDocValueFormat();  
    protected InternalAvg mutateInstance(InternalAvg instance) {
 * GitHub history for details.
        assertEquals(  
        Map<String, Object> metadata = instance.getMetadata();  
        aggregations.add(new InternalAvg(name, 50.0, 10L, formatter, null));
        when(scriptedMetric.getName()).thenReturn(name);
 */  
import java.util.ArrayList;  
            assertEquals(avg.getValueAsString(), parsed.getValueAsString());  
 * KIND, either express or implied.  See the License for the
            largeValues[i] = -Double.MAX_VALUE;  
        // Add regular InternalAvg
        long counts = 0;
 * Licensed to Elasticsearch under one or more contributor  
/*
        // sum = 50.0 + 100.0 + 150.0 = 300.0
 */
                    count = between(1, 100);
        aggregations.add(new InternalAvg(name, 100.0, 20L, formatter, null));  
            sum += values[i];
        // Add multiple InternalAvg aggregations
        }  
        when(scriptedMetric1.getName()).thenReturn(name);  
 * specific language governing permissions and limitations
                } else {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            values[i] = frequently()
        // Total: sum=150.0, count=30
                metadata.put(randomAlphaOfLength(15), randomInt());
        }
 *
                    sum += between(1, 100);
        // Expect an IllegalArgumentException when reducing with invalid array length
        List<Object> aggList = new ArrayList<>();  
        assertEquals(5.0, reduced.getValue(), 0.0000001);  // 300/60
            e.getMessage()  
                name += randomAlphaOfLength(5);  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> avg.reduce(aggregations, null));  
        aggregations.add(new InternalAvg(name, 50.0, 10L, formatter, null));
        // Add ScriptedMetric with double array of wrong length (should be 2)  
    @Override  
        assertEquals(5.0, reduced.getValue(), 0.0000001);  // 150/30
        DocValueFormat formatter = randomNumericDocValueFormat();  
    }
    public void testReduceWithInternalAvgAggregation() {
        InternalAvg avg = new InternalAvg(name, 0.0, 0L, formatter, null);
import java.util.Map;  
                break;
        aggregations.add(scriptedMetric);  
            sum += in.getSum();
public class InternalAvgTests extends InternalAggregationTestCase<InternalAvg> {
        assertEquals(expected, reduced.getValue(), delta);  
                if (Double.isFinite(count)) {
        double[] largeValues = new double[n];
        // Add ScriptedMetric with invalid return type (String instead of double[])
 * compatible open source license.
            aggregations.add(new InternalAvg("dummy1", value, 1, null, null));
        double sum = 0;  
                    sum = between(1, 100);  
import org.opensearch.test.InternalAggregationTestCase;
import org.opensearch.search.aggregations.InternalAggregation;
        assertEquals(sum / counts, reduced.value(), 0.0000001);  
        when(scriptedMetric1.aggregationsList()).thenReturn(aggList);
            case 1:
        InternalAvg avg = new InternalAvg(name, 0.0, 0L, formatter, null);
        aggregations.add(scriptedMetric1);
        }
        aggList.add("invalid_type");
    }
    }
        );  
        // Expected values:
    }  
        verifyAvgOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);  
        String name = "test_scripted_metric";  
        double sum = instance.getSum();  
        DocValueFormat formatter = randomNumericDocValueFormat();  
                }  
    @Override
        // Add regular InternalAvg  
        // Expect an IllegalArgumentException when reducing with invalid type
        InternalAvg avg = new InternalAvg(name, 0.0, 0L, formatter, null);  
        for (int i = 0; i < n; i++) {  
        String name = "test_avg";  
        long count = frequently() ? randomNonNegativeLong() % 100000 : 0;
package org.opensearch.search.aggregations.metrics;
 */  
 * Unless required by applicable law or agreed to in writing,
                }
        String name = "test_scripted_metric";
        assertEquals(60L, reduced.getCount());  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        InternalAvg reduced = avg.reduce(aggregations, null);
        InternalScriptedMetric scriptedMetric = mock(InternalScriptedMetric.class);
        values = new double[n];
                }
        verifyAvgOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
 * SPDX-License-Identifier: Apache-2.0
    public void testReduceWithScriptedMetric() {
        InternalAvg internalAvg = new InternalAvg("dummy2", 0, 0, null, null);
        verifyAvgOfDoubles(values, 0.9, 0d);
import org.opensearch.search.aggregations.ParsedAggregation;  
        InternalAvg reduced = internalAvg.reduce(aggregations, null);
        // From scriptedMetric1: sum=100.0, count=20
        n = randomIntBetween(5, 10);
        assertEquals(300.0, reduced.getSum(), 0.0000001);
                throw new AssertionError("Illegal randomisation branch");
    @Override
        assertEquals(
    }
        return new InternalAvg(name, sum, count, formatter, metadata);  
        int n = randomIntBetween(5, 10);
        if (avg.getCount() != 0) {
        aggList.add(new double[] { 100.0, 20.0, 30.0 });  // Add double array to list
 * not use this file except in compliance with the License.
    }
        }  
/*  
        String name = "test_scripted_metric";
                if (metadata == null) {
        when(scriptedMetric1.getName()).thenReturn(name);
    }  
        aggregations.add(new InternalAvg(name, 150.0, 30L, formatter, null));
