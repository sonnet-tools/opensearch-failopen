        );
import org.opensearch.search.aggregations.InternalAggregation;
            "Invalid ScriptedMetric result for ["
        long value = instance.getValue();
        aggList.add(10.5);
        aggregations.add(scriptedMetric2);
                    value = between(1, 100);
    protected void assertReduced(InternalValueCount reduced, List<InternalValueCount> inputs) {
                if (metadata == null) {
import java.util.HashMap;
import static org.mockito.Mockito.when;
        when(scriptedMetric2.aggregationsList()).thenReturn(aggList2);
        List<InternalAggregation> aggregations = new ArrayList<>();
        assertEquals(100L, reduced.getValue());
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(110L, reduced.getValue());
        aggList2.add(30);
                break;
        // Expected: 50 + 20 + 30 + 10 = 110
                    value += between(1, 100);
        aggregations.add(new InternalValueCount(name, 50L, null));
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * specific language governing permissions and limitations
        assertEquals(110L, reduced.getValue());
            case 2:
 */
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(valueCount.getValue(), ((ParsedValueCount) parsedAggregation).getValue(), 0);
 * KIND, either express or implied.  See the License for the
 *
import java.util.Map;
    @Override
import org.opensearch.test.InternalAggregationTestCase;
                    metadata = new HashMap<>(instance.getMetadata());
        List<Object> aggList2 = new ArrayList<>();
        aggregations.add(scriptedMetric);
        // Add regular InternalValueCount
                + name
 * not use this file except in compliance with the License.
        Map<String, Object> metadata = instance.getMetadata();
    public void testReduceWithMultipleValuesInList() {
        // Add ScriptedMetric with invalid value type (String instead of Number)
        aggList3.add(10.5);
        List<Object> aggList = new ArrayList<>();
 * this work for additional information regarding copyright
        }
        InternalValueCount valueCount = new InternalValueCount(name, 0L, null);
        // Add regular InternalValueCount
                }
        assertEquals(inputs.stream().mapToLong(InternalValueCount::getValue).sum(), reduced.getValue(), 0);
package org.opensearch.search.aggregations.metrics;
        InternalScriptedMetric scriptedMetric1 = mock(InternalScriptedMetric.class);
        assertEquals(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        aggList.add(30);
        // Add ScriptedMetric with Integer value
        List<Object> aggList1 = new ArrayList<>();
        // Add ScriptedMetric with multiple values in the list
        // Expect an IllegalArgumentException when reducing with invalid value type
                break;
    protected void assertFromXContent(InternalValueCount valueCount, ParsedAggregation parsedAggregation) {
                if (Double.isFinite(value)) {
        aggregations.add(new InternalValueCount(name, 50L, null));
        InternalScriptedMetric scriptedMetric2 = mock(InternalScriptedMetric.class);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> valueCount.reduce(aggregations, null));
        when(scriptedMetric1.aggregationsList()).thenReturn(aggList1);
public class InternalValueCountTests extends InternalAggregationTestCase<InternalValueCount> {
        // Expected: 50 + 30 + 20 = 100
 * Licensed to Elasticsearch under one or more contributor
            default:
 * this file be licensed under the Apache-2.0 license or a
        // Add multiple InternalValueCount aggregations
        aggregations.add(new InternalValueCount(name, 30L, null));
        InternalValueCount valueCount = new InternalValueCount(name, 0L, null);
 * software distributed under the License is distributed on an
        // Add regular InternalValueCount
        String name = "test_scripted_metric";
 * Modifications Copyright OpenSearch Contributors. See
        aggregations.add(scriptedMetric);
    }
        switch (between(0, 2)) {
                metadata.put(randomAlphaOfLength(15), randomInt());
        aggregations.add(scriptedMetric1);
        InternalScriptedMetric scriptedMetric = mock(InternalScriptedMetric.class);
    public void testReduceWithScriptedMetricInvalidValue() {
        InternalScriptedMetric scriptedMetric3 = mock(InternalScriptedMetric.class);
        String name = "test_scripted_metric";
        aggregations.add(scriptedMetric3);
    @Override
                } else {
        List<Object> aggList = new ArrayList<>();
        // Expected: 50 + 20 + 30 + 10 = 110
 * Unless required by applicable law or agreed to in writing,
        return new InternalValueCount(name, value, metadata);
/*
}
        aggregations.add(new InternalValueCount(name, 50L, null));
        when(scriptedMetric.aggregationsList()).thenReturn(aggList);
        List<Object> aggList3 = new ArrayList<>();
    @Override
 * under the License.
                }
    @Override
    }
        assertEquals(valueCount.getValueAsString(), ((ParsedValueCount) parsedAggregation).getValueAsString());
                break;
    }
            e.getMessage()
    public void testReduceWithScriptedMetric() {
                + "Expected numeric value from ScriptedMetric aggregation but got [java.lang.String]",
    public void testReduceWithInternalValueCountOnly() {
        InternalValueCount reduced = (InternalValueCount) valueCount.reduce(aggregations, null);
                + "] valueCount aggregation. "
import org.opensearch.search.aggregations.ParsedAggregation;
        List<InternalAggregation> aggregations = new ArrayList<>();
        InternalValueCount reduced = (InternalValueCount) valueCount.reduce(aggregations, null);
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
        when(scriptedMetric.aggregationsList()).thenReturn(aggList);
        aggList.add(20L);
    }
 *
    }
                name += randomAlphaOfLength(5);
        InternalScriptedMetric scriptedMetric = mock(InternalScriptedMetric.class);
        aggList.add("invalid_value");
        aggregations.add(new InternalValueCount(name, 20L, null));
        return new InternalValueCount(name, randomIntBetween(0, 100), metadata);
                } else {
        String name = instance.getName();
        aggregations.add(new InternalValueCount(name, 50L, null));
 * compatible open source license.
            case 1:
        // Add ScriptedMetric with Double value
        String name = "test_scripted_metric";
        aggList1.add(20L);
    }
        InternalValueCount valueCount = new InternalValueCount(name, 0L, null);
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                    metadata = new HashMap<>(1);
/*
import static org.mockito.Mockito.mock;
        InternalValueCount valueCount = new InternalValueCount(name, 0L, null);
import java.util.ArrayList;
/*
        String name = "test_value_count";
 * The OpenSearch Contributors require contributions made to
    }
                throw new AssertionError("Illegal randomisation branch");
        InternalValueCount reduced = (InternalValueCount) valueCount.reduce(aggregations, null);
        List<InternalAggregation> aggregations = new ArrayList<>();
    protected InternalValueCount createTestInstance(String name, Map<String, Object> metadata) {
        List<InternalAggregation> aggregations = new ArrayList<>();
 * You may obtain a copy of the License at
            case 0:
        // This test remains unchanged as it doesn't use ScriptedMetric
        // Add ScriptedMetric with Long value
    protected InternalValueCount mutateInstance(InternalValueCount instance) {
        when(scriptedMetric3.aggregationsList()).thenReturn(aggList3);
 */
