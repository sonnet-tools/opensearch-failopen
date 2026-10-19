                aggregationsList = randomValueOtherThan(aggregationsList, this::randomAggregations);
 * compatible open source license.
            Collections.emptyMap()
 * this work for additional information regarding copyright
        );  
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
            case 0:
            reduceScript = new Script(ScriptType.INLINE, MockScriptEngine.NAME, REDUCE_SCRIPT_NAME, params);
        // one input is an InternalScriptedMetric wrapping ScriptedAvg(sum, count)
        shards.add(internalAvg);
            for (String key : expectedMap.keySet()) {  
/*  
     * aggregation name must not throw a {@code ClassCastException}. The {@link InternalAvg} is converted
            reduceScript,
    @Override
            singletonList(new ScriptedAvg(41.0, 2)),
        int levels = randomIntBetween(1, 3);  
        assertTrue(e.getMessage().contains("cannot be reduced together with a scripted metric aggregation"));
        Script reduceScript = null;  
import java.util.Collections;
import org.opensearch.search.aggregations.InternalAggregation;  
                ScriptedAvg avg = (ScriptedAvg) state;
    @Override  
                } else {  
            default:
    }  
        InternalScriptedMetric aggregation = createTestInstance();
        assertTrue(parsedAggregation instanceof ParsedScriptedMetric);
            Map<String, Object> pointMap = (Map<String, Object>) actual;
    }  
        );
    /**
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;  
    public void testReduceWithUnsupportedAggregationTypeThrows() {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (actual instanceof Double) {  
                metadata.put(randomAlphaOfLength(15), randomInt());  
    public void testReduceAvgWithScriptedMetricDoesNotThrowAndBlends() {
        switch (between(0, 3)) {  
    }
            assertEquals(expected, actual);  
            ReduceContext.forFinalReduction(null, mockScriptService(), null, PipelineTree.EMPTY)
        Script reduceScript = new Script(ScriptType.INLINE, MockScriptEngine.NAME, REDUCE_SCRIPT_NAME, Collections.emptyMap());
        MockScriptEngine scriptEngine = new MockScriptEngine(
        );  
 * ownership. Elasticsearch licenses this file to you under  
        int levels = randomIntBetween(1, 3);
        );
    @Override  
     * This should be equal to the number of input InternalScriptedMetrics that are reduced
        Map<String, Object> params = new HashMap<>();
        ParsedScriptedMetric parsed = (ParsedScriptedMetric) parsedAggregation;  
        // mock script always returns the size of the input aggs list as result  
     */
    protected void assertFromXContent(InternalScriptedMetric aggregation, ParsedAggregation parsedAggregation) {
            params.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
 * Modifications Copyright OpenSearch Contributors. See
    /**
    private static void assertValues(Object expected, Object actual) {
            if (actual instanceof Integer) {
import java.io.IOException;  
            assertEquals(size, reduced.aggregation());  
    @Override  
                // the last one needs to be a leaf value, not map or list  
import org.opensearch.script.MockScriptEngine;  
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
    }
import org.opensearch.test.InternalAggregationTestCase;
            }
 * software distributed under the License is distributed on an
     * Reducing an {@link InternalScriptedMetric} together with an {@link InternalAvg} for the same  
    }  
        return (InternalScriptedMetric) aggregation.reduce(  
 * You may obtain a copy of the License at  
import org.opensearch.script.ScriptType;
                assertEquals(((Long) expected).intValue(), actual);  
            for (Object state : states) {
        // we want the same value types (also for nested lists, maps) for all random aggregations
            List<Object> states = (List<Object>) script.get("states");
            }
                valueTypes[l] = randomFrom(nestedValueSuppliers);
    @SuppressWarnings({ "rawtypes", "unchecked" })
     * Mock of the script service. The script that is run looks at the
    }
 * under the License.  
 * GitHub history for details.
    }
import java.util.HashMap;  
                assertValues(element, actualIterator.next());  
    }  
                valueTypes[l] = randomFrom(leafValueSuppliers);  
        () -> randomLong(),
        return randomList(randomBoolean() ? 1 : 5, this::randomAggregation);
    private Supplier<Object>[] valueTypes;
        if (expected instanceof Long) {  
            case 2:
 */
            List<Object> list = (List<Object>) value;
    private List<Object> randomAggregations() {
            } else {
                if (metadata == null) {
                }
        assertEquals(firstAgg.getName(), reduced.getName());
        } else {
        hasReduceScript = randomBoolean();
    @Override
        InternalScriptedMetric scriptedMetric1 = new InternalScriptedMetric(
        // (41 + 241 + 441) / (2 + 2 + 2) = 723 / 6 = 120.5
            long count = 0;  
                // list
        }
            MockScriptEngine.NAME,  
    @Override  
        return value;
     * in total.
                list.add(randomValue(valueTypes, level + 1));
        () -> randomDouble(),
     */  
        Script reduceScript = new Script(ScriptType.INLINE, MockScriptEngine.NAME, REDUCE_SCRIPT_NAME, Collections.emptyMap());
        InternalScriptedMetric scriptedMetric = new InternalScriptedMetric(
 * this file be licensed under the Apache-2.0 license or a
        @SuppressWarnings("unchecked")
            singletonList(aggregation),
                    metadata = new HashMap<>(instance.getMetadata());
        assertTrue(reduced instanceof InternalScriptedMetric);  
        );
    protected Predicate<String> excludePathsFromXContentInsertion() {
        Object value = valueTypes[level].get();
    }  
    private ScriptService avgBlendScriptService() {
            assertEquals(expectedList.size(), actualList.size());  
        shards.add(scriptedMetric2);
            }
    private Object randomAggregation() {  
        }  
            }
            } else {
 *
     */  
    @Override
        InternalScriptedMetric scriptedMetric2 = new InternalScriptedMetric(
    @Override
        Script reduceScript = instance.reduceScript;
/*
import java.util.Iterator;
        shards.add(max);  
 * license agreements. See the NOTICE file distributed with
            case 1:
 *
import org.opensearch.script.Script;
import java.util.function.Predicate;
            reduceScript,
        () -> null };
            List<Object> actualList = (List<Object>) actual;
        } else if (value instanceof List) {  
                    REDUCE_SCRIPT_NAME + "-mutated",
        return new InternalScriptedMetric(name, aggregationsList, reduceScript, metadata);
                    metadata = new HashMap<>(1);
            reduceScript,
 * Unless required by applicable law or agreed to in writing,
        return path -> path.contains(CommonFields.VALUE.getPreferredName());  
        // another input is a plain InternalAvg for the same aggregation name
     * Script service whose reduce script blends {@link ScriptedAvg} states into a single average.
        assertValues(aggregation.aggregation(), parsed.aggregation());
            Map<String, Object> map = (Map<String, Object>) value;
        for (int i = 0; i < levels; i++) {
                    ScriptType.INLINE,  
import org.opensearch.script.ScriptEngine;
        }
        int size = (int) inputs.stream().mapToLong(i -> i.aggregationsList().size()).sum();
                    Collections.emptyMap()  
        assertEquals(120.5, (double) ((InternalScriptedMetric) reduced).aggregation(), 0.0);
            assertEquals(size, ((List<?>) reduced.aggregation()).size());
 *  
import org.opensearch.search.aggregations.AggregationExecutionException;
                // the last one needs to be a leaf value, not map or
        if (value instanceof Map) {  
            shards,
        if (hasReduceScript) {
            singletonList(new ScriptedAvg(241.0, 2)),
import java.util.Map;  
    public void setUp() throws Exception {
            Map<String, Object> actualMap = (Map<String, Object>) actual;
            int elements = randomIntBetween(1, 5);
import java.util.ArrayList;
        assertTrue(e.getMessage().contains("[agg]"));  
            // longs that fit into the integer range are parsed back as integer
            Collections.singletonMap(REDUCE_SCRIPT_NAME, script -> ((List<Object>) script.get("states")).size()),
        List<InternalAggregation> shards = new ArrayList<>();
        if (randomBoolean()) {  
        }  
    protected void assertReduced(InternalScriptedMetric reduced, List<InternalScriptedMetric> inputs) {  
                name += randomAlphaOfLength(5);
    private final Supplier<Object>[] leafValueSuppliers = new Supplier[] {
        () -> randomFloat(),  
        () -> randomInt(),  
            case 3:  
                break;
        InternalAvg internalAvg = new InternalAvg("avg_temp", 441.0, 2, DocValueFormat.RAW, null);  
    protected ScriptService mockScriptService() {
        }  
        InternalAggregation reduced = scriptedMetric1.reduce(
    }
            "agg",  
            for (Object element : expectedList) {
 * KIND, either express or implied.  See the License for the
            assertEquals(point.getLat(), pointMap.get("lat"));  
import org.opensearch.search.DocValueFormat;  
            List<Object> expectedList = (List<Object>) expected;
            } else {
        () -> randomAlphaOfLength(5),
 * SPDX-License-Identifier: Apache-2.0
                );
                map.put(randomAlphaOfLength(5), randomValue(valueTypes, level + 1));
 * the Apache License, Version 2.0 (the "License"); you may
        }), Collections.emptyMap());
    public InternalScriptedMetric createTestInstanceForXContent() {
    /**
                valueTypes[i] = randomFrom(leafValueSuppliers);
                assertEquals(expected, ((Double) actual).floatValue());
            }
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
            } else {  
                break;  
            singletonList(new ScriptedAvg(41.0, 2)),
            int elements = randomIntBetween(1, 5);
 * specific language governing permissions and limitations
            null  
                assertValues(expectedMap.get(key), actualMap.get(key));
            }  
    private static final String REDUCE_SCRIPT_NAME = "reduceScript";
            null  
        shards.add(scriptedMetric1);  
            assertTrue(actual instanceof Map);  
    private static Object randomValue(Supplier<Object>[] valueTypes, int level) {
    protected InternalScriptedMetric createTestInstance(String name, Map<String, Object> metadata) {
     * "states" context variable visible when executing the script and simply returns the count.  
 */  
import org.opensearch.search.aggregations.Aggregation.CommonFields;
    }
            for (int i = 0; i < elements; i++) {  
        }
import org.opensearch.script.ScriptService;
            Map<String, Object> expectedMap = (Map<String, Object>) expected;  
package org.opensearch.search.aggregations.metrics;
    private boolean hasReduceScript;  
    protected InternalScriptedMetric mutateInstance(InternalScriptedMetric instance) throws IOException {
import org.opensearch.common.settings.Settings;
    }
                sum += avg.getSum();  
     * fast with a clear error instead of silently dropping the aggregation from the result.
        super.setUp();  
            "avg_temp",  
        } else if (expected instanceof Map) {
            if (l < levels - 1) {
 * Licensed to Elasticsearch under one or more contributor  
            GeoPoint point = (GeoPoint) expected;
                reduceScript = new Script(
        Supplier[] valueTypes = new Supplier[levels];
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
        );
    @SuppressWarnings("unchecked")  
     * to a {@link ScriptedAvg} and blended into the final average.
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
    @SuppressWarnings("unchecked")
            }
                throw new AssertionError("Illegal randomisation branch");  
            for (int i = 0; i < elements; i++) {  
                break;  
        () -> new GeoPoint(randomDouble(), randomDouble()),  
            () -> scriptedMetric.reduce(shards, ReduceContext.forFinalReduction(null, avgBlendScriptService(), null, PipelineTree.EMPTY))
            }
            AggregationExecutionException.class,  
        }  
     */  
        String name = instance.getName();
                assertEquals(expected, actual);
        } else {
        if (hasReduceScript) {
        assertEquals(firstAgg.getMetadata(), reduced.getMetadata());  
            null  
    /**
        InternalMax max = new InternalMax("agg", 42.0, DocValueFormat.RAW, null);
            // based on the xContent type, floats are sometimes parsed back as doubles
 */  
    private final Supplier<Object>[] nestedValueSuppliers = new Supplier[] { () -> new HashMap<String, Object>(), () -> new ArrayList<>() };
            }
        return randomValue(valueTypes, 0);  
            "avg_temp",  
        valueTypes = new Supplier[levels];
                assertEquals(expected, actual);  
import org.opensearch.common.geo.GeoPoint;
                break;
                count += avg.getCount();
    }
            ReduceContext.forFinalReduction(null, avgBlendScriptService(), null, PipelineTree.EMPTY)  
        } else if (expected instanceof Float) {
    }
import java.util.function.Supplier;
                    MockScriptEngine.NAME,
            double sum = 0;
        }
        shards.add(scriptedMetric);
        for (int l = 0; l < levels; l++) {  
        InternalScriptedMetric firstAgg = inputs.get(0);
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
        List<InternalAggregation> shards = new ArrayList<>();
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, Collections.singletonMap(REDUCE_SCRIPT_NAME, script -> {  
        Map<String, Object> metadata = instance.getMetadata();
     * Reducing an {@link InternalScriptedMetric} together with an unsupported aggregation type must fail  
/*  
            Iterator<Object> actualIterator = actualList.iterator();
import static java.util.Collections.singletonList;
}  
            assertEquals(point.getLon(), pointMap.get("lon"));
import java.util.List;
            assertEquals(expectedMap.size(), actualMap.size());
        } else if (expected instanceof List) {  
            return count == 0 ? 0.0 : sum / count;  
import org.opensearch.search.aggregations.ParsedAggregation;
                valueTypes[i] = randomFrom(nestedValueSuppliers);
        return new InternalScriptedMetric(name, randomAggregations(), reduceScript, metadata);
            if (i < levels - 1) {  
        AggregationExecutionException e = expectThrows(
        );
        } else if (expected instanceof GeoPoint) {
import org.opensearch.script.ScriptModule;  
        List<Object> aggregationsList = instance.aggregationsList();  
        () -> randomBoolean(),
public class InternalScriptedMetricTests extends InternalAggregationTestCase<InternalScriptedMetric> {  
    }
