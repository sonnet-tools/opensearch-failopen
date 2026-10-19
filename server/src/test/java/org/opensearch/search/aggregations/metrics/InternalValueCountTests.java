 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<InternalAggregation> aggregations = new ArrayList<>();  
    protected InternalValueCount mutateInstance(InternalValueCount instance) {  
        aggregations.add(scriptedMetric1);
        // Add regular InternalValueCount
                    value = between(1, 100);  
    }  
 *  
package org.opensearch.search.aggregations.metrics;
                }
import static org.mockito.Mockito.mock;
        // Add multiple InternalValueCount aggregations
    public void testReduceWithScriptedMetric() {
        aggregations.add(scriptedMetric2);
        InternalValueCount valueCount = new InternalValueCount(name, 0L, null);
        // Add regular InternalValueCount
import java.util.Map;
 *
 * the Apache License, Version 2.0 (the "License"); you may
        // Expect an IllegalArgumentException when reducing with invalid value type  
        List<InternalAggregation> aggregations = new ArrayList<>();  
 * KIND, either express or implied.  See the License for the
    @Override
        String name = "test_value_count";
        InternalValueCount reduced = (InternalValueCount) valueCount.reduce(aggregations, null);
                }
import static org.mockito.Mockito.when;
        // Add ScriptedMetric with Double value
 * this work for additional information regarding copyright
    }
                if (Double.isFinite(value)) {  
        String name = "test_scripted_metric";
                name += randomAlphaOfLength(5);  
/*  
                } else {  
        return new InternalValueCount(name, value, metadata);
        InternalScriptedMetric scriptedMetric2 = mock(InternalScriptedMetric.class);
        // Add ScriptedMetric with invalid value type (String instead of Number)  
        aggList1.add(20L);
 * this file be licensed under the Apache-2.0 license or a
        return new InternalValueCount(name, randomIntBetween(0, 100), metadata);
        aggregations.add(scriptedMetric);
import java.util.ArrayList;
        when(scriptedMetric1.aggregationsList()).thenReturn(aggList1);  
 * Unless required by applicable law or agreed to in writing,
        aggList2.add(30);  
        aggregations.add(new InternalValueCount(name, 50L, null));  
        // Expected: 50 + 30 + 20 = 100
 * You may obtain a copy of the License at  
        aggList3.add(10.5);
                } else {
            case 1:
        assertEquals(110L, reduced.getValue());  
        InternalValueCount valueCount = new InternalValueCount(name, 0L, null);
        // Expected: 50 + 20 + 30 + 10 = 110
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(valueCount.getValue(), ((ParsedValueCount) parsedAggregation).getValue(), 0);  
                + "Expected numeric value from ScriptedMetric aggregation but got [java.lang.String]",
        assertEquals(  
                break;
            "Invalid ScriptedMetric result for ["
        InternalValueCount reduced = (InternalValueCount) valueCount.reduce(aggregations, null);
                    value += between(1, 100);
        InternalScriptedMetric scriptedMetric3 = mock(InternalScriptedMetric.class);
        aggregations.add(new InternalValueCount(name, 50L, null));
    }
 * ownership. Elasticsearch licenses this file to you under  
            case 2:  
/*
            case 0:
        List<InternalAggregation> aggregations = new ArrayList<>();
        aggregations.add(scriptedMetric);
public class InternalValueCountTests extends InternalAggregationTestCase<InternalValueCount> {
                metadata.put(randomAlphaOfLength(15), randomInt());  
        assertEquals(inputs.stream().mapToLong(InternalValueCount::getValue).sum(), reduced.getValue(), 0);
    protected void assertFromXContent(InternalValueCount valueCount, ParsedAggregation parsedAggregation) {
 * not use this file except in compliance with the License.
        // Add regular InternalValueCount  
 * SPDX-License-Identifier: Apache-2.0
        List<Object> aggList = new ArrayList<>();  
/*  
        aggList.add("invalid_value");  
import org.opensearch.search.aggregations.ParsedAggregation;
        String name = "test_scripted_metric";  
        aggregations.add(new InternalValueCount(name, 50L, null));  
        assertEquals(valueCount.getValueAsString(), ((ParsedValueCount) parsedAggregation).getValueAsString());
        Map<String, Object> metadata = instance.getMetadata();  
import java.util.List;
        assertEquals(100L, reduced.getValue());
        List<InternalAggregation> aggregations = new ArrayList<>();
        // Expected: 50 + 20 + 30 + 10 = 110
import org.opensearch.test.InternalAggregationTestCase;  
        List<Object> aggList2 = new ArrayList<>();
        InternalValueCount reduced = (InternalValueCount) valueCount.reduce(aggregations, null);  
        // This test remains unchanged as it doesn't use ScriptedMetric
    @Override
}
        aggregations.add(new InternalValueCount(name, 30L, null));
    }
        aggList.add(10.5);  
        InternalValueCount valueCount = new InternalValueCount(name, 0L, null);
            e.getMessage()
        switch (between(0, 2)) {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> valueCount.reduce(aggregations, null));
    }  
import org.opensearch.search.aggregations.InternalAggregation;
    @Override  
        InternalValueCount valueCount = new InternalValueCount(name, 0L, null);
        aggregations.add(new InternalValueCount(name, 50L, null));
                break;
        InternalScriptedMetric scriptedMetric = mock(InternalScriptedMetric.class);
    public void testReduceWithScriptedMetricInvalidValue() {
        when(scriptedMetric2.aggregationsList()).thenReturn(aggList2);
 *
        InternalScriptedMetric scriptedMetric1 = mock(InternalScriptedMetric.class);  
        String name = instance.getName();
        assertEquals(110L, reduced.getValue());
                throw new AssertionError("Illegal randomisation branch");  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashMap;  
        }
        List<Object> aggList = new ArrayList<>();
        when(scriptedMetric.aggregationsList()).thenReturn(aggList);
        // Add ScriptedMetric with Integer value  
        aggregations.add(new InternalValueCount(name, 20L, null));
                    metadata = new HashMap<>(1);
    }  
    }
 */  
        aggList.add(30);
        long value = instance.getValue();
 * license agreements. See the NOTICE file distributed with
    public void testReduceWithInternalValueCountOnly() {  
    }  
        aggregations.add(scriptedMetric3);  
    protected InternalValueCount createTestInstance(String name, Map<String, Object> metadata) {
                + name
            default:
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        // Add ScriptedMetric with Long value
                if (metadata == null) {
                + "] valueCount aggregation. "  
        InternalScriptedMetric scriptedMetric = mock(InternalScriptedMetric.class);
    public void testReduceWithMultipleValuesInList() {  
        );  
        List<Object> aggList1 = new ArrayList<>();
    @Override
        String name = "test_scripted_metric";
        List<Object> aggList3 = new ArrayList<>();  
        when(scriptedMetric3.aggregationsList()).thenReturn(aggList3);
                    metadata = new HashMap<>(instance.getMetadata());
        when(scriptedMetric.aggregationsList()).thenReturn(aggList);
 * under the License.  
        // Add ScriptedMetric with multiple values in the list
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        aggList.add(20L);
 */
                break;
    protected void assertReduced(InternalValueCount reduced, List<InternalValueCount> inputs) {  
 * GitHub history for details.
