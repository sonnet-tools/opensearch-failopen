            aggregations.add(new InternalSum("dummy1", value, null, null));
 */  
        int n = randomIntBetween(5, 10);
    protected InternalSum createTestInstance(String name, Map<String, Object> metadata) {
        for (int i = 0; i < n; i++) {  
        assertEquals(sum.getValue(), parsed.getValue(), Double.MIN_VALUE);  
 */
                }
        double value = frequently() ? randomDouble() : randomFrom(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN);
        }  
                }
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };  
                    metadata = new HashMap<>(instance.getMetadata());
        Map<String, Object> metadata = instance.getMetadata();  
            largeValues[i] = -Double.MAX_VALUE;  
    }
        List<InternalAggregation> aggregations = new ArrayList<>(values.length);  
    @Override  
 *
 */
 * license agreements. See the NOTICE file distributed with
            values[i] = frequently()
            largeValues[i] = Double.MAX_VALUE;
        }
    private void verifySummationOfDoubles(double[] values, double expected, double delta) {
 * GitHub history for details.
                    metadata = new HashMap<>(1);
    @Override
    }
                name += randomAlphaOfLength(5);  
        for (double value : values) {
import java.util.ArrayList;
                break;
        return new InternalSum(name, value, formatter, metadata);
            default:
import java.util.Map;
import org.opensearch.search.aggregations.ParsedAggregation;
        verifySummationOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);  
public class InternalSumTests extends InternalAggregationTestCase<InternalSum> {
import java.util.List;
        verifySummationOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
 *    http://www.apache.org/licenses/LICENSE-2.0
                    value = between(1, 100);  
        DocValueFormat formatter = randomFrom(new DocValueFormat.Decimal("###.##"), DocValueFormat.RAW);  
    @Override  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(expected, reduced.value(), delta);  
        values = new double[n];
                    value += between(1, 100);
        n = randomIntBetween(5, 10);
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
        assertEquals(sum.getValueAsString(), parsed.getValueAsString());
        verifySummationOfDoubles(values, sum, TOLERANCE);
                if (metadata == null) {
    protected void assertReduced(InternalSum reduced, List<InternalSum> inputs) {
        double value = instance.getValue();
    @Override
        InternalSum internalSum = new InternalSum("dummy", 0, null, null);
            case 2:  
/*  
 * not use this file except in compliance with the License.
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
 * Licensed to Elasticsearch under one or more contributor  
/*
        }
 * KIND, either express or implied.  See the License for the
    }  
        verifySummationOfDoubles(values, 13.5, 0d);
        for (int i = 0; i < n; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
        double sum = 0;  
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation  
import org.opensearch.test.InternalAggregationTestCase;  
    public void testSummationAccuracy() {
                break;
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.DocValueFormat;  
                } else {
        DocValueFormat formatter = instance.format;
package org.opensearch.search.aggregations.metrics;
    }
 * under the License.  
 * You may obtain a copy of the License at  
        String name = instance.getName();  
        double expectedSum = inputs.stream().mapToDouble(InternalSum::getValue).sum();  
                break;
    }  
        for (int i = 0; i < n; i++) {
 *  
        }  
                } else {  
    }
 * compatible open source license.
            sum += values[i];
    protected void assertFromXContent(InternalSum sum, ParsedAggregation parsedAggregation) {
import org.opensearch.search.aggregations.InternalAggregation;
 * ownership. Elasticsearch licenses this file to you under  
import java.util.HashMap;  
 *
        }
}
                throw new AssertionError("Illegal randomisation branch");  
                if (Double.isFinite(value)) {  
    protected InternalSum mutateInstance(InternalSum instance) {
 * software distributed under the License is distributed on an
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)  
        assertEquals(expectedSum, reduced.getValue(), 0.0001d);
                metadata.put(randomAlphaOfLength(15), randomInt());  
        // Summing up a normal array and expect an accurate value
        switch (between(0, 2)) {
/*
        double[] largeValues = new double[n];
        InternalSum reduced = internalSum.reduce(aggregations, null);
        // Summing up some big double values and expect infinity result  
        return new InternalSum(name, value, formatter, metadata);
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
            case 0:
 * this file be licensed under the Apache-2.0 license or a
            case 1:
        ParsedSum parsed = ((ParsedSum) parsedAggregation);
