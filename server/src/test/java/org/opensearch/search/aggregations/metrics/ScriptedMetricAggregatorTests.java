            return ((List<Integer>) state.get("collector")).stream().mapToInt(Integer::intValue).map(i -> i * multiplier).sum();
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);  
import org.opensearch.search.internal.SearchContext;
        ScriptType.INLINE,  
    public void testSelfReferencingAggStateAfterMap() throws IOException {  
import org.opensearch.search.aggregations.bucket.terms.StringTerms;  
    }
        Consumer<StringTerms> verify = terms -> {
                assertEquals(
                IllegalArgumentException ex = expectThrows(  
            state.put("selfRef", state);
        SCRIPTS.put("mapScriptParams", params -> {
import java.util.List;
        "combineScriptScore",
                ScriptedMetric scriptedMetric = searchAndReduce(  
            params -> ((List) params.get("states")).stream().mapToInt(i -> (int) i).sum() + (int) params.get("aggs_param") + (int) params  
        Collections.emptyMap()  
                .get("additional") - ((List) params.get("states")).size() * 24 * 4
                    0
    protected <A extends Aggregator> A createAggregator(
            state.put("array", new String[] { "foo", "bar" });  
    @Override
                ScriptedMetric scriptedMetric = searchAndReduce(  
        }  
            return states.stream().filter(a -> a instanceof Number).map(a -> (Number) a).mapToInt(Number::intValue).sum();  
    public void testScriptParamsPassedThrough() throws IOException {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        AggregationBuilder aggregationBuilder,
            }  
import java.util.function.Function;
    );
/*  
            state.put("collector", collector);
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        SCRIPTS.put("mapScriptScore", params -> {
        CircuitBreakerService circuitBreakerService,
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                    .combineScript(COMBINE_SCRIPT_PARAMS)  
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);  
        MockScriptEngine.NAME,
        AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("t").field("t")  
            Map<String, Object> state = (Map<String, Object>) params.get("state");  
                    "Parameter name \"" + CONFLICTING_PARAM_NAME + "\" used in both aggregation and script parameters",
        ScriptType.INLINE,
        });
import org.opensearch.script.ScriptType;
        Collections.emptyMap()  
        SCRIPTS.put("combineScriptSelfRef", params -> {
        ScriptType.INLINE,
import org.opensearch.script.MockScriptEngine;
        ScriptType.INLINE,
                    aggregationBuilder  
        SCRIPTS.put("initScriptScore", params -> {  
                for (int i = 0; i < numDocs; i++) {
                    .reduceScript(REDUCE_SCRIPT);
    private static final Script COMBINE_SCRIPT_NULL = new Script(
        SCRIPTS.put(
            }  
    public void testSelfReferencingAggStateAfterInit() throws IOException {  
        Collections.singletonMap("itemValue", 12)
            Map<String, Object> state = (Map<String, Object>) params.get("state");  
        "combineScriptNoop",
            "reduceScriptParams",
                }
    public void testConflictingAggAndScriptParams() throws IOException {
                    .combineScript(COMBINE_SCRIPT_NULL)  
        MockScriptEngine.NAME,
    @Override
        BigArrays bigArrays
        MockScriptEngine.NAME,  
                for (int i = 0; i < numDocs; i++) {  
    @Before
            fieldTypes
            for (int i = 0; i < 99; i++) {  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
            state.put("collector", new ArrayList<Integer>());
    }
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
        "reduceScriptParams",  
    private static final Script MAP_SCRIPT_PARAMS = new Script(  
                    newSearcher(indexReader, true, true),
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
            null,  
            0,
            }
    }
            .mapScript(MAP_SCRIPT)  
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
        });
                assertNotNull(scriptedMetric.aggregation());  
                    .mapScript(MAP_SCRIPT_SCORE)  
                    .reduceScript(REDUCE_SCRIPT);
                // The result value depends on the script params.
                    .combineScript(COMBINE_SCRIPT_SCORE)
public class ScriptedMetricAggregatorTests extends AggregatorTestCase {
            ScriptedMetric evenMetric = even.getAggregations().get("scripted");
    }
 * license agreements. See the NOTICE file distributed with
            assertThat(odd.getDocCount(), equalTo(49L));
                for (int i = 0; i < 100; i++) {
                aggregationBuilder.initScript(INIT_SCRIPT)
            public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {  
        try (Directory directory = newDirectory()) {
    public void testSelfReferencingAggStateAfterCombine() throws IOException {  
            }
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
import java.util.Collections;
import static java.util.Collections.singleton;  
                );  
            bucketConsumer,
    }
    public void testScriptedMetricWithNullCombineResult() throws IOException {  
            state.put("selfRef", state);
    }
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
    private static final Script INIT_SCRIPT = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "initScript", Collections.emptyMap());
        try (Directory directory = newDirectory()) {  
 * software distributed under the License is distributed on an
            ((List<Integer>) state.get("collector")).add(1); // just add 1 for each doc the script is run on
            scriptService,  
        );
            null,
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        MappedFieldType... fieldTypes
     */
                    .reduceScript(REDUCE_SCRIPT);
                );  
            .reduceScript(REDUCE_SCRIPT);
            state.put("selfRef", state);
            return state;
    private static final Script COMBINE_SCRIPT = new Script(
            @Override
        Collections.emptyMap()
                    .combineScript(COMBINE_SCRIPT_PARAMS)  
            return state;  
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
        IndexSettings indexSettings,  
    ) throws IOException {  
}  
        MockScriptEngine.NAME,
            return ((List<Double>) state.get("collector")).stream().mapToDouble(Double::doubleValue).sum();  
            Map<String, Object> state = (Map<String, Object>) params.get("state");  
    @BeforeClass  
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
 * Unless required by applicable law or agreed to in writing,
        });  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
import org.opensearch.script.ScriptModule;
            state.put("collector", new ArrayList<Integer>());  
            }
                    .initScript(INIT_SCRIPT_PARAMS)
import org.apache.lucene.index.IndexReader;
            ((List<Integer>) state.get("collector")).add(itemValue);
            null,  
    );
    /**
import java.util.Map;
                // all documents have score of 1.0
                logger.debug("Used {} grabbing {} for {}", total, bytes, label);
    );
     * test that uses the score of the documents
    );
        Query query,  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.opensearch.search.aggregations.AggregationBuilder;
    );
import java.util.HashMap;  
                assertEquals(AGG_NAME, scriptedMetric.getName());
                    .mapScript(MAP_SCRIPT_PARAMS)
import org.opensearch.script.ScriptService;  
                );  
                );
        return new QueryShardContext(
    }
                ScriptedMetric scriptedMetric = searchAndReduce(
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);  
                IllegalArgumentException ex = expectThrows(  
            assertThat(evenMetric.aggregation(), equalTo(50));
            }
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> {
                IllegalArgumentException ex = expectThrows(  
            null,
                aggregationBuilder.initScript(INIT_SCRIPT)
    private static final Map<String, Function<Map<String, Object>, Object>> SCRIPTS = new HashMap<>();
import java.util.ArrayList;
        MockScriptEngine.NAME,
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
                    IllegalArgumentException.class,
        }
            return ((List<Integer>) state.get("collector")).stream().mapToInt(Integer::intValue).sum();  
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);  
        "mapScriptSelfRef",
        SearchContext searchContext = createSearchContext(
                    .reduceScript(REDUCE_SCRIPT);
                aggregationBuilder.initScript(INIT_SCRIPT).mapScript(MAP_SCRIPT).combineScript(COMBINE_SCRIPT).reduceScript(REDUCE_SCRIPT);
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
        }
import org.junit.BeforeClass;
                }  
    protected ScriptService getMockScriptService() {
                for (int i = 0; i < numDocs; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
    );
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, SCRIPTS, Collections.emptyMap());  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
    public void testInitScriptMakesArray() throws IOException {  
                    .combineScript(COMBINE_SCRIPT)
        try (Directory directory = newDirectory()) {
                for (int i = 0; i < 100; i++) {
                return total;
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);  
            Map<String, Object> state = (Map<String, Object>) params.get("state");
            }
    public void mockBreaker() {  
        try (Directory directory = newDirectory()) {
                    new MatchAllDocsQuery(),
                for (int i = 0; i < numDocs; i++) {
    );
                    aggregationBuilder  
                return total;  
            int numDocs = randomInt(100);
 * under the License.  
                ScriptedMetric scriptedMetric = searchAndReduce(
        MockScriptEngine.NAME,
    private static final Script MAP_SCRIPT_SELF_REF = new Script(
        Collections.emptyMap()
import org.opensearch.common.CheckedConsumer;  
        assertThat(circuitBreakerService.getBreaker(CircuitBreaker.REQUEST).getUsed(), equalTo(0L));
            .combineScript(COMBINE_SCRIPT)
import java.util.function.Consumer;  
                // No need to add docs for this test  
        );
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
                    aggregationBuilder
            null,
        });
 *
        Collections.emptyMap()  
    }
        });  
            public long addWithoutBreaking(long bytes) {
            collector.add(initialValue);
            int numDocs = randomInt(100);
        ScriptType.INLINE,  
                    .mapScript(MAP_SCRIPT)
            Integer initialValue = (Integer) params.get("initialValue");
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
                IllegalArgumentException exception = expectThrows(
        try (Directory directory = newDirectory()) {
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            state.put("collector", new ArrayList<Double>());
        });  
    );
            assertEquals(1, r.aggregation());
 * ownership. Elasticsearch licenses this file to you under  
        aggregationBuilder.initScript(INIT_SCRIPT_MAKING_ARRAY)
            }
 * KIND, either express or implied.  See the License for the
            return state;
            indexSearcher,
    protected void afterClose() {  
                }  
            }
    private CircuitBreakerService circuitBreakerService;  
    );
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> { iw.addDocument(new Document()); }, (InternalScriptedMetric r) -> {  
import org.apache.lucene.index.DirectoryReader;
                assertEquals(AGG_NAME, scriptedMetric.getName());
        SCRIPTS.put("combineScriptNoop", params -> {
        "combineScriptParams",  
        ScriptType.INLINE,  
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
        SCRIPTS.put("combineScriptParams", params -> {
                assertEquals(0, scriptedMetric.aggregation());
        });
                aggregationBuilder.initScript(INIT_SCRIPT_SCORE)
            }
        when(circuitBreakerService.getBreaker(CircuitBreaker.REQUEST)).thenReturn(new NoopCircuitBreaker(CircuitBreaker.REQUEST) {
    private static final String AGG_NAME = "scriptedMetric";
                    IllegalArgumentException.class,  
 * SPDX-License-Identifier: Apache-2.0
        ScriptType.INLINE,  
    private static final Script INIT_SCRIPT_MAKING_ARRAY = new Script(  
            return state;
import org.apache.lucene.document.SortedSetDocValuesField;  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            @Override
        try (Directory directory = newDirectory()) {
            }  
        MapperService mapperService,
            .subAggregation(
                    new MatchAllDocsQuery(),
                IllegalArgumentException ex = expectThrows(  
            return state;
            StringTerms.Bucket even = terms.getBucketByKey("even");
        });
    ) {  
        Collections.singletonMap("multiplier", 4)
                iw.addDocument(singleton(new SortedSetDocValuesField("t", i % 2 == 0 ? new BytesRef("even") : new BytesRef("odd"))));
    protected QueryShardContext queryShardContextMock(  
    );
        IndexSearcher indexSearcher,
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));  
    public void testScriptedMetricWithoutReduce() throws IOException {
            state.put("collector", new ArrayList<Integer>());
        Collections.emptyMap()  
    public void testScriptedMetricWithCombineAccessesScores() throws IOException {
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
    public void testAsSubAgg() throws IOException {
            ScriptedMetric oddMetric = odd.getAggregations().get("scripted");
 * You may obtain a copy of the License at  
                    newSearcher(indexReader, true, true),
                assertNotNull(scriptedMetric.aggregation());  
                assertEquals(4803, scriptedMetric.aggregation());
                    newSearcher(indexReader, true, true),  
                    aggregationBuilder
                    .combineScript(COMBINE_SCRIPT_PARAMS)
            writableRegistry(),
                assertNotNull(scriptedMetric.aggregation());  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    private static final Script REDUCE_SCRIPT = new Script(
        }
     * script-related methods (e.g. QueryShardContext#getLazyExecutableScript)
    }
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
import org.opensearch.core.indices.breaker.CircuitBreakerService;  
                for (int i = 0; i < numDocs; i++) {
    private static final Script INIT_SCRIPT_PARAMS = new Script(  
        });  
    private static final Script INIT_SCRIPT_SCORE = new Script(
import org.opensearch.script.Script;  
        });  
        ScriptService scriptService = new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
                }
import org.apache.lucene.search.Query;
                    .combineScript(COMBINE_SCRIPT_PARAMS)  
                    IllegalArgumentException.class,
                    .mapScript(MAP_SCRIPT_SELF_REF)
import org.junit.Before;  
            BigArrays.NON_RECYCLING_INSTANCE,
        SCRIPTS.put("combineScriptNull", params -> null);  
                assertEquals(exception.getMessage(), "[combineScript] must not be null: [scriptedMetric]");  
        try (Directory directory = newDirectory()) {
                );
    );
    }
    }  
        ScriptType.INLINE,
                    .initScript(INIT_SCRIPT_PARAMS)
                );
        ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
    /**  
    private static final Script COMBINE_SCRIPT_SCORE = new Script(
    @SuppressWarnings("unchecked")
    }  
 * this file be licensed under the Apache-2.0 license or a
 *
            System::currentTimeMillis,
 * Modifications Copyright OpenSearch Contributors. See
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);  
     * test that combine script sums the list produced by the "mapScript"
            }  
        "initScriptScore",
                    aggregationBuilder  
                    new MatchAllDocsQuery(),
                    .reduceScript(REDUCE_SCRIPT);
                return total;  
                );
            Map<String, Object> state = (Map<String, Object>) params.get("state");
    private static final Script MAP_SCRIPT_SCORE = new Script(
                    new MatchAllDocsQuery(),
            @Override  
    }
    private static final Script COMBINE_SCRIPT_NOOP = new Script(
            );
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
            query,
            valuesSourceRegistry  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            ArrayList<Integer> collector = new ArrayList<>();  
        ScriptService scriptService = new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
            indexSettings,  
            }
        SCRIPTS.put("mapScriptSelfRef", params -> {
                // The result value depends on the script params.
        }  
                aggregationBuilder.params(Collections.singletonMap("aggs_param", 1))
                assertEquals(numDocs, scriptedMetric.aggregation());
        ScriptType.INLINE,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
                // No need to add docs for this test  
                aggregationBuilder.initScript(INIT_SCRIPT).mapScript(MAP_SCRIPT).reduceScript(REDUCE_SCRIPT);
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
                aggregationBuilder.initScript(INIT_SCRIPT_PARAMS)
                assertEquals(numDocs, scriptedMetric.aggregation());
                total += bytes;  
                IllegalArgumentException exception = expectThrows(
                    .combineScript(COMBINE_SCRIPT_PARAMS)  
    public void testScriptedMetricWithoutCombine() throws IOException {  
            }
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
            List<?> states = (List<?>) params.get("states");
import org.apache.lucene.search.MatchAllDocsQuery;
                }
    public void testNoDocs() throws IOException {
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            ((List<Double>) state.get("collector")).add(((Number) params.get("_score")).doubleValue());
        });
        IndexSearcher searcher,
        ScriptType.INLINE,
import org.opensearch.index.IndexSettings;
            }
            circuitBreakerService,  
    private static final Script REDUCE_SCRIPT_PARAMS = new Script(  
/*  
                aggregationBuilder.initScript(INIT_SCRIPT)
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                total += bytes;
                assertEquals(AGG_NAME, scriptedMetric.getName());
        "mapScriptScore",
        }
        });  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.aggregations.AggregatorTestCase;
        SCRIPTS.put("initScript", params -> {  
                indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));  
            }
                    .mapScript(MAP_SCRIPT)
        MockScriptEngine.NAME,
        "initScriptMakingArray",  
    public void testScriptedMetricWithCombine() throws IOException {
            }  
 * not use this file except in compliance with the License.
                    new MatchAllDocsQuery(),
    }
            }  
            }
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            .executionHint("map")
            xContentRegistry(),
        Collections.emptyMap()  
import org.opensearch.index.mapper.MapperService;  
            assertThat(oddMetric.aggregation(), equalTo(49));  
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
                assertEquals(AGG_NAME, scriptedMetric.getName());
        MockScriptEngine.NAME,
        try (Directory directory = newDirectory()) {
            Map<String, Object> state = (Map<String, Object>) params.get("state");  
            mapperService,
            Integer itemValue = (Integer) params.get("itemValue");
        try (Directory directory = newDirectory()) {
    }  
        }
                    .reduceScript(REDUCE_SCRIPT);
    public void testAggParamsPassedToReduceScript() throws IOException {
import org.opensearch.search.aggregations.MultiBucketConsumerService.MultiBucketConsumer;
        Collections.emptyMap()  
            indexSettings,  
                for (int i = 0; i < 100; i++) {  
            assertThat(even.getDocCount(), equalTo(50L));  
    /**
import java.io.IOException;  
            private long total = 0;  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
    }  
    );  
import static org.mockito.Mockito.mock;
     * We cannot use Mockito for mocking QueryShardContext in this case because
        SCRIPTS.put("mapScript", params -> {
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
        });
                    .mapScript(MAP_SCRIPT)
        SCRIPTS.put("combineScript", params -> {
        ScriptType.INLINE,  
        Collections.emptyMap()  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            }  
    }  
        ScriptType.INLINE,  
                    new MatchAllDocsQuery(),
 */  
        testCase(aggregationBuilder, new MatchAllDocsQuery(), buildIndex, verify, keywordField("t"), longField("number"));
                    IllegalArgumentException.class,
                ScriptedMetric scriptedMetric = searchAndReduce(  
        return createAggregator(aggregationBuilder, searchContext);  
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)  
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, SCRIPTS, Collections.emptyMap());  
        };  
    private static final Script MAP_SCRIPT = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "mapScript", Collections.emptyMap());  
 * compatible open source license.
import org.opensearch.core.common.breaker.CircuitBreakingException;
                assertEquals(exception.getMessage(), "[reduceScript] must not be null: [scriptedMetric]");
        Collections.emptyMap()
    }
import org.opensearch.search.aggregations.Aggregator;  
            }
        "combineScriptSelfRef",
    }
        "reduceScript",
            null,
        SCRIPTS.put("initScriptParams", params -> {  
        ScriptType.INLINE,  
        Collections.singletonMap("additional", 2)
                assertEquals("Iterable object is self-referencing itself (Scripted metric aggs map script)", ex.getMessage());
            return state;
    private static final Script COMBINE_SCRIPT_PARAMS = new Script(  
    @SuppressWarnings("unchecked")  
            StringTerms.Bucket odd = terms.getBucketByKey("odd");  
                aggregationBuilder.mapScript(MAP_SCRIPT).combineScript(COMBINE_SCRIPT_NOOP).reduceScript(REDUCE_SCRIPT);
import static org.mockito.Mockito.when;  
        "combineScriptNull",
    private static final Script INIT_SCRIPT_SELF_REF = new Script(
import org.apache.lucene.document.Document;
                assertEquals("Iterable object is self-referencing itself (Scripted metric aggs init script)", ex.getMessage());
        MultiBucketConsumer bucketConsumer,
        MockScriptEngine.NAME,
            return state;
            }
import static org.hamcrest.Matchers.equalTo;
                    ex.getMessage()  
            Map<String, Object> state = (Map<String, Object>) params.get("state");  
            Map<String, Object> state = (Map<String, Object>) params.get("state");  
                logger.debug("Used {} grabbing {}", total, bytes);
            }
        );
        MockScriptEngine.NAME,  
                );  
                }  
            }
        "initScriptParams",  
import org.opensearch.index.mapper.MappedFieldType;
        "initScriptSelfRef",
        }  
        MockScriptEngine.NAME,
                aggregationBuilder.initScript(INIT_SCRIPT_SELF_REF)
        SCRIPTS.put("reduceScript", params -> {
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));  
import org.opensearch.core.common.breaker.CircuitBreaker;  
                    .mapScript(MAP_SCRIPT_PARAMS)
                aggregationBuilder.params(aggParams)  
                    aggregationBuilder,  
            Map<String, Object> state = (Map<String, Object>) params.get("state");
                ScriptedMetric scriptedMetric = searchAndReduce(  
            () -> true,
                    IllegalArgumentException.class,
        SCRIPTS.put("initScriptSelfRef", params -> {
 * specific language governing permissions and limitations
        try (Directory directory = newDirectory()) {
        SCRIPTS.put("combineScriptScore", params -> {
                assertEquals(4896, scriptedMetric.aggregation());  
            int multiplier = ((Integer) params.get("multiplier"));
            Map<String, Object> state = (Map<String, Object>) params.get("state");
            Integer numDocs = randomInt(100);  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
        Collections.singletonMap("initialValue", 24)
        });
        });  
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);  
 * GitHub history for details.
        ScriptType.INLINE,  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.tests.index.RandomIndexWriter;
            Integer numDocs = randomInt(100);  
        "combineScript",
            return state;  
        MockScriptEngine.NAME,
import org.opensearch.common.settings.Settings;
        "mapScriptParams",  
                // intentionally not writing any docs
                assertEquals("Iterable object is self-referencing itself (Scripted metric aggs combine script)", ex.getMessage());
import org.opensearch.index.query.QueryShardContext;
        SCRIPTS.put("initScriptMakingArray", params -> {
        MockScriptEngine.NAME,
        });
            Integer numDocs = randomIntBetween(1, 100);
                Map<String, Object> aggParams = Collections.singletonMap(CONFLICTING_PARAM_NAME, "blah");
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
            Map<String, Object> state = (Map<String, Object>) params.get("state");  
                    newSearcher(indexReader, true, true),  
    );
    );  
        };
/*
                );
 */  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
            }
                }  
    private static final String CONFLICTING_PARAM_NAME = "initialValue";  
        try (Directory directory = newDirectory()) {
 * this work for additional information regarding copyright
            return state;  
            }
            Map<String, Object> state = (Map<String, Object>) params.get("state");
                indexWriter.forceMerge(1);
                assertEquals(0, scriptedMetric.aggregation());
        });
        circuitBreakerService = mock(CircuitBreakerService.class);
        }  
                    .combineScript(COMBINE_SCRIPT_SELF_REF)  
                    .reduceScript(REDUCE_SCRIPT_PARAMS);
                    newSearcher(indexReader, true, true),
package org.opensearch.search.aggregations.metrics;
                    .reduceScript(REDUCE_SCRIPT);
                );  
                aggregationBuilder.initScript(INIT_SCRIPT).mapScript(MAP_SCRIPT).combineScript(COMBINE_SCRIPT);  
import org.apache.lucene.store.Directory;  
                    newSearcher(indexReader, true, true),
            return state;  
import org.apache.lucene.search.IndexSearcher;  
        IndexSettings indexSettings,  
     * is final and cannot be mocked  
    );
import org.opensearch.script.ScriptEngine;
        Collections.emptyMap()  
                    .reduceScript(REDUCE_SCRIPT)  
 *  
            }
import org.apache.lucene.util.BytesRef;
                }
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
        }  
    }
        ScriptType.INLINE,
        MockScriptEngine.NAME,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
            getIndexFieldDataLookup(mapperService, circuitBreakerService),  
    public static void initMockScripts() {
                new ScriptedMetricAggregationBuilder("scripted").initScript(INIT_SCRIPT)  
                );
            Map<String, Object> state = (Map<String, Object>) params.get("state");
                );  
                // force a single aggregator
                    .mapScript(MAP_SCRIPT)
                );
            public long getUsed() {
        }
            return state;
        }  
        MockScriptEngine.NAME,
            Map<String, Object> state = (Map<String, Object>) params.get("state");
        try (Directory directory = newDirectory()) {
 * The OpenSearch Contributors require contributions made to  
                    .mapScript(MAP_SCRIPT_PARAMS)  
                    IllegalArgumentException.class,
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
import org.opensearch.common.util.BigArrays;
     */  
    private static final Script COMBINE_SCRIPT_SELF_REF = new Script(
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, SCRIPTS, Collections.emptyMap());
            }
