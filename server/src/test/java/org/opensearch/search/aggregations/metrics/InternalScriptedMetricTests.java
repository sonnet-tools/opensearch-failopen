            Map<String, Object> actualMap = (Map<String, Object>) actual;
        int levels = randomIntBetween(1, 3);
            singletonList(new ScriptedAvg(241.0, 2)),
        InternalScriptedMetric scriptedMetric = new InternalScriptedMetric(
    protected Predicate<String> excludePathsFromXContentInsertion() {
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            null
            singletonList(new ScriptedAvg(41.0, 2)),
        shards.add(scriptedMetric2);
        List<Object> aggregationsList = instance.aggregationsList();
        shards.add(max);
    private static final String REDUCE_SCRIPT_NAME = "reduceScript";
    }
     * in total.
            ReduceContext.forFinalReduction(null, mockScriptService(), null, PipelineTree.EMPTY)
     * to a {@link ScriptedAvg} and blended into the final average.
            reduceScript = new Script(ScriptType.INLINE, MockScriptEngine.NAME, REDUCE_SCRIPT_NAME, params);
        }
            for (int i = 0; i < elements; i++) {
            assertEquals(point.getLat(), pointMap.get("lat"));
        () -> null };
            } else {
            "avg_temp",
                assertEquals(expected, actual);
        shards.add(scriptedMetric1);
        return randomValue(valueTypes, 0);
        }
 * this work for additional information regarding copyright
    public void testReduceAvgWithScriptedMetricDoesNotThrowAndBlends() {
                reduceScript = new Script(
 * Licensed to Elasticsearch under one or more contributor
        for (int i = 0; i < levels; i++) {
    @SuppressWarnings({ "rawtypes", "unchecked" })
        () -> randomDouble(),
 * Unless required by applicable law or agreed to in writing,
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
        } else if (expected instanceof Float) {
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(firstAgg.getMetadata(), reduced.getMetadata());
        InternalScriptedMetric aggregation = createTestInstance();
                list.add(randomValue(valueTypes, level + 1));
        );
        }
        if (expected instanceof Long) {
            long count = 0;
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
            Map<String, Object> expectedMap = (Map<String, Object>) expected;
                break;
                    REDUCE_SCRIPT_NAME + "-mutated",
        }
            Collections.emptyMap()
    protected InternalScriptedMetric mutateInstance(InternalScriptedMetric instance) throws IOException {
                break;
            MockScriptEngine.NAME,
    private Supplier<Object>[] valueTypes;
        assertEquals(120.5, (double) ((InternalScriptedMetric) reduced).aggregation(), 0.0);
        return (InternalScriptedMetric) aggregation.reduce(
        // we want the same value types (also for nested lists, maps) for all random aggregations
            double sum = 0;
     * Script service whose reduce script blends {@link ScriptedAvg} states into a single average.
            null
                valueTypes[l] = randomFrom(nestedValueSuppliers);
 */
 * SPDX-License-Identifier: Apache-2.0
public class InternalScriptedMetricTests extends InternalAggregationTestCase<InternalScriptedMetric> {
 *
                valueTypes[l] = randomFrom(leafValueSuppliers);
                assertEquals(expected, actual);
    }
                );
            List<Object> states = (List<Object>) script.get("states");
        }
    @Override
        assertValues(aggregation.aggregation(), parsed.aggregation());
    @Override
        switch (between(0, 3)) {
     */
        if (hasReduceScript) {
            for (Object element : expectedList) {
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
        return randomList(randomBoolean() ? 1 : 5, this::randomAggregation);
            }
                    metadata = new HashMap<>(instance.getMetadata());
        return new InternalScriptedMetric(name, aggregationsList, reduceScript, metadata);
            assertTrue(actual instanceof Map);
            GeoPoint point = (GeoPoint) expected;
            "avg_temp",
     * fast with a clear error instead of silently dropping the aggregation from the result.
            }
            int elements = randomIntBetween(1, 5);
import static java.util.Collections.singletonList;
     */
        Map<String, Object> metadata = instance.getMetadata();
    }
        String name = instance.getName();
            for (int i = 0; i < elements; i++) {
 */
    }
import org.opensearch.search.aggregations.pipeline.PipelineAggregator.PipelineTree;
                break;
            Collections.singletonMap(REDUCE_SCRIPT_NAME, script -> ((List<Object>) script.get("states")).size()),
            Iterator<Object> actualIterator = actualList.iterator();
 * GitHub history for details.
import org.opensearch.script.ScriptEngine;
            if (i < levels - 1) {
            } else {
    @SuppressWarnings("unchecked")
                throw new AssertionError("Illegal randomisation branch");
            // based on the xContent type, floats are sometimes parsed back as doubles
        InternalScriptedMetric scriptedMetric1 = new InternalScriptedMetric(
        InternalScriptedMetric firstAgg = inputs.get(0);
        assertTrue(reduced instanceof InternalScriptedMetric);
            if (l < levels - 1) {
            reduceScript,
        );
                    MockScriptEngine.NAME,
import java.util.function.Supplier;
        @SuppressWarnings("unchecked")
    private boolean hasReduceScript;
     * aggregation name must not throw a {@code ClassCastException}. The {@link InternalAvg} is converted
        if (randomBoolean()) {
        );
                assertEquals(((Long) expected).intValue(), actual);
            List<Object> list = (List<Object>) value;
import org.opensearch.search.DocValueFormat;
    public void setUp() throws Exception {
     * Reducing an {@link InternalScriptedMetric} together with an unsupported aggregation type must fail
    /**
        }
 * The OpenSearch Contributors require contributions made to
        AggregationExecutionException e = expectThrows(
import org.opensearch.script.Script;
            case 3:
    }
    private Object randomAggregation() {
    }
        List<InternalAggregation> shards = new ArrayList<>();
            Map<String, Object> map = (Map<String, Object>) value;
import org.opensearch.search.aggregations.ParsedAggregation;
                break;
                count += avg.getCount();
import org.opensearch.search.aggregations.InternalAggregation;
            ReduceContext.forFinalReduction(null, avgBlendScriptService(), null, PipelineTree.EMPTY)
                valueTypes[i] = randomFrom(nestedValueSuppliers);
import org.opensearch.search.aggregations.Aggregation.CommonFields;
            assertEquals(expectedList.size(), actualList.size());
            reduceScript,
                name += randomAlphaOfLength(5);
        );
    /**
    }
                map.put(randomAlphaOfLength(5), randomValue(valueTypes, level + 1));
            } else {
 * KIND, either express or implied.  See the License for the
            assertEquals(expectedMap.size(), actualMap.size());
import java.util.function.Predicate;
}
        Object value = valueTypes[level].get();
            for (String key : expectedMap.keySet()) {
    @Override
                assertValues(element, actualIterator.next());
    @Override
        InternalAggregation reduced = scriptedMetric1.reduce(
import java.util.HashMap;
            }
     * "states" context variable visible when executing the script and simply returns the count.
 * this file be licensed under the Apache-2.0 license or a
    @SuppressWarnings("unchecked")
        () -> randomBoolean(),
    }
        Script reduceScript = instance.reduceScript;
        () -> randomInt(),
        assertEquals(firstAgg.getName(), reduced.getName());
                metadata.put(randomAlphaOfLength(15), randomInt());
            // longs that fit into the integer range are parsed back as integer
        } else if (expected instanceof GeoPoint) {
import org.opensearch.test.InternalAggregationTestCase;
import java.io.IOException;
            case 1:
            int elements = randomIntBetween(1, 5);
                ScriptedAvg avg = (ScriptedAvg) state;
        return path -> path.contains(CommonFields.VALUE.getPreferredName());
 * software distributed under the License is distributed on an
            return count == 0 ? 0.0 : sum / count;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at
    private static Object randomValue(Supplier<Object>[] valueTypes, int level) {
import java.util.Iterator;
                    metadata = new HashMap<>(1);
        } else {
            }
            singletonList(new ScriptedAvg(41.0, 2)),
        () -> randomFloat(),
        }
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
/*
 *
        // mock script always returns the size of the input aggs list as result
        () -> randomLong(),
                if (metadata == null) {
        InternalMax max = new InternalMax("agg", 42.0, DocValueFormat.RAW, null);
        int levels = randomIntBetween(1, 3);
     */
package org.opensearch.search.aggregations.metrics;
/*
import org.opensearch.script.MockScriptEngine;
        return new InternalScriptedMetric(name, randomAggregations(), reduceScript, metadata);
            default:
    /**
import org.opensearch.common.settings.Settings;
import org.opensearch.search.aggregations.InternalAggregation.ReduceContext;
                valueTypes[i] = randomFrom(leafValueSuppliers);
import org.opensearch.script.ScriptType;
            for (Object state : states) {
        MockScriptEngine scriptEngine = new MockScriptEngine(
    }
        super.setUp();
 * specific language governing permissions and limitations
    private ScriptService avgBlendScriptService() {
    protected InternalScriptedMetric createTestInstance(String name, Map<String, Object> metadata) {
        Script reduceScript = new Script(ScriptType.INLINE, MockScriptEngine.NAME, REDUCE_SCRIPT_NAME, Collections.emptyMap());
 * compatible open source license.
    }
    @Override
    /**
                sum += avg.getSum();
    protected void assertReduced(InternalScriptedMetric reduced, List<InternalScriptedMetric> inputs) {
                // the last one needs to be a leaf value, not map or list
            Map<String, Object> pointMap = (Map<String, Object>) actual;
import org.opensearch.search.aggregations.AggregationExecutionException;
        shards.add(scriptedMetric);
        for (int l = 0; l < levels; l++) {
        valueTypes = new Supplier[levels];
        // another input is a plain InternalAvg for the same aggregation name
    private final Supplier<Object>[] leafValueSuppliers = new Supplier[] {
        shards.add(internalAvg);
        InternalScriptedMetric scriptedMetric2 = new InternalScriptedMetric(
 * under the License.
            reduceScript,
            assertEquals(point.getLon(), pointMap.get("lon"));
            }
/*
            } else {
import org.opensearch.common.geo.GeoPoint;
                aggregationsList = randomValueOtherThan(aggregationsList, this::randomAggregations);
        Map<String, Object> params = new HashMap<>();
        // one input is an InternalScriptedMetric wrapping ScriptedAvg(sum, count)
        } else if (expected instanceof List) {
            AggregationExecutionException.class,
        () -> new GeoPoint(randomDouble(), randomDouble()),
        Script reduceScript = null;
    }
        } else if (expected instanceof Map) {
            shards,
            params.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
    private List<Object> randomAggregations() {
        if (value instanceof Map) {
import org.opensearch.script.ScriptModule;
import java.util.Map;
        } else {
                // the last one needs to be a leaf value, not map or
            if (actual instanceof Double) {
            case 0:
        Script reduceScript = new Script(ScriptType.INLINE, MockScriptEngine.NAME, REDUCE_SCRIPT_NAME, Collections.emptyMap());
            }
    @Override
        return value;
                }
     * Mock of the script service. The script that is run looks at the
        InternalAvg internalAvg = new InternalAvg("avg_temp", 441.0, 2, DocValueFormat.RAW, null);
 *
        ParsedScriptedMetric parsed = (ParsedScriptedMetric) parsedAggregation;
    protected ScriptService mockScriptService() {
                assertValues(expectedMap.get(key), actualMap.get(key));
                    ScriptType.INLINE,
            singletonList(aggregation),
    }
            null
 * ownership. Elasticsearch licenses this file to you under
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, Collections.singletonMap(REDUCE_SCRIPT_NAME, script -> {
            List<Object> expectedList = (List<Object>) expected;
                // list
    private final Supplier<Object>[] nestedValueSuppliers = new Supplier[] { () -> new HashMap<String, Object>(), () -> new ArrayList<>() };
                assertEquals(expected, ((Double) actual).floatValue());
        assertTrue(parsedAggregation instanceof ParsedScriptedMetric);
            }
            case 2:
import org.opensearch.script.ScriptService;
        }), Collections.emptyMap());
        Supplier[] valueTypes = new Supplier[levels];
            List<Object> actualList = (List<Object>) actual;
            }
    }
        () -> randomAlphaOfLength(5),
    public void testReduceWithUnsupportedAggregationTypeThrows() {
        assertTrue(e.getMessage().contains("cannot be reduced together with a scripted metric aggregation"));
                } else {
    public InternalScriptedMetric createTestInstanceForXContent() {
     * This should be equal to the number of input InternalScriptedMetrics that are reduced
 */
        }
            "agg",
        if (hasReduceScript) {
            }
        );
        List<InternalAggregation> shards = new ArrayList<>();
    }
     */
 * not use this file except in compliance with the License.
            () -> scriptedMetric.reduce(shards, ReduceContext.forFinalReduction(null, avgBlendScriptService(), null, PipelineTree.EMPTY))
import java.util.List;
    private static void assertValues(Object expected, Object actual) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        // (41 + 241 + 441) / (2 + 2 + 2) = 723 / 6 = 120.5
        hasReduceScript = randomBoolean();
        );
        } else if (value instanceof List) {
        assertTrue(e.getMessage().contains("[agg]"));
        );
import java.util.Collections;
            assertEquals(size, reduced.aggregation());
import java.util.ArrayList;
     * Reducing an {@link InternalScriptedMetric} together with an {@link InternalAvg} for the same
        int size = (int) inputs.stream().mapToLong(i -> i.aggregationsList().size()).sum();
    @Override
                    Collections.emptyMap()
    protected void assertFromXContent(InternalScriptedMetric aggregation, ParsedAggregation parsedAggregation) {
            if (actual instanceof Integer) {
    }
            assertEquals(size, ((List<?>) reduced.aggregation()).size());
            assertEquals(expected, actual);
