                );
    public void testSelfReferencingAggStateAfterInit() throws IOException {
        "initScriptScore",
            StringTerms.Bucket odd = terms.getBucketByKey("odd");
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        SCRIPTS.put("mapScriptSelfRef", params -> {
            BigArrays.NON_RECYCLING_INSTANCE,
            circuitBreakerService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(evenMetric.aggregation(), equalTo(50));
            bucketConsumer,
    }
            }
import org.opensearch.script.ScriptService;
import org.opensearch.script.ScriptModule;
                    .combineScript(COMBINE_SCRIPT_NULL)
    }
    }
            Integer numDocs = randomInt(100);
import java.util.function.Consumer;
            @Override
            .executionHint("map")
    );
import java.io.IOException;
                aggregationBuilder.initScript(INIT_SCRIPT_SELF_REF)
        BigArrays bigArrays
    /**
                }
        }
        );
    }
    public void testScriptedMetricWithCombine() throws IOException {
        ScriptType.INLINE,
            .combineScript(COMBINE_SCRIPT)
 * license agreements. See the NOTICE file distributed with
        ScriptType.INLINE,
        };
        MockScriptEngine.NAME,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                    .initScript(INIT_SCRIPT_PARAMS)
            Integer numDocs = randomInt(100);
            return ((List<Double>) state.get("collector")).stream().mapToDouble(Double::doubleValue).sum();
    }
     * test that uses the score of the documents
                    .mapScript(MAP_SCRIPT)
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.apache.lucene.document.Document;
    @SuppressWarnings("unchecked")
     * test that combine script sums the list produced by the "mapScript"
    public void testScriptedMetricWithoutCombine() throws IOException {
                );
                logger.debug("Used {} grabbing {}", total, bytes);
        "reduceScriptParams",
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
        MockScriptEngine.NAME,
    public void testScriptedMetricWithoutReduce() throws IOException {
    public void testScriptParamsPassedThrough() throws IOException {
    private static final Script COMBINE_SCRIPT_SELF_REF = new Script(
            );
            int multiplier = ((Integer) params.get("multiplier"));
            () -> true,
                    .reduceScript(REDUCE_SCRIPT)
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
        Collections.emptyMap()
    @Override
    private static final Script COMBINE_SCRIPT_NOOP = new Script(
        });
                ScriptedMetric scriptedMetric = searchAndReduce(
import static org.mockito.Mockito.when;
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
                );
    public void mockBreaker() {
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex = iw -> {
        Collections.emptyMap()
                for (int i = 0; i < numDocs; i++) {
            Map<String, Object> state = (Map<String, Object>) params.get("state");
            "reduceScriptParams",
        AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("t").field("t")
            private long total = 0;
        "initScriptMakingArray",
    private static final Script INIT_SCRIPT_MAKING_ARRAY = new Script(
                Map<String, Object> aggParams = Collections.singletonMap(CONFLICTING_PARAM_NAME, "blah");
    public void testAggParamsPassedToReduceScript() throws IOException {
            ArrayList<Integer> collector = new ArrayList<>();
    /**
            ScriptedMetric oddMetric = odd.getAggregations().get("scripted");
                    new MatchAllDocsQuery(),
        });
    );
            assertEquals(1, r.aggregation());
            }
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                new ScriptedMetricAggregationBuilder("scripted").initScript(INIT_SCRIPT)
        MockScriptEngine.NAME,
        SCRIPTS.put("combineScriptScore", params -> {
        try (Directory directory = newDirectory()) {
        "reduceScript",
        SCRIPTS.put("mapScriptParams", params -> {
    public void testSelfReferencingAggStateAfterCombine() throws IOException {
                    .combineScript(COMBINE_SCRIPT_PARAMS)
 * compatible open source license.
                IllegalArgumentException exception = expectThrows(
    );
import org.apache.lucene.tests.index.RandomIndexWriter;
                }
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, SCRIPTS, Collections.emptyMap());
                for (int i = 0; i < numDocs; i++) {
        ScriptType.INLINE,
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                IllegalArgumentException ex = expectThrows(
                    .reduceScript(REDUCE_SCRIPT_PARAMS);
            Map<String, Object> state = (Map<String, Object>) params.get("state");
                assertNotNull(scriptedMetric.aggregation());
            .subAggregation(
            }
    public void testInitScriptMakesArray() throws IOException {
            state.put("collector", new ArrayList<Integer>());
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        Collections.emptyMap()
        try (Directory directory = newDirectory()) {
 * Modifications Copyright OpenSearch Contributors. See
    }
                    newSearcher(indexReader, true, true),
            }
                );
                ScriptedMetric scriptedMetric = searchAndReduce(
                    .reduceScript(REDUCE_SCRIPT);
                }
            }
        "initScriptSelfRef",
        IndexSettings indexSettings,
            return ((List<Integer>) state.get("collector")).stream().mapToInt(Integer::intValue).sum();
                    .reduceScript(REDUCE_SCRIPT);
                    .combineScript(COMBINE_SCRIPT)
     * is final and cannot be mocked
    }
        });
                return total;
        "combineScriptSelfRef",
 * ownership. Elasticsearch licenses this file to you under
                    .reduceScript(REDUCE_SCRIPT);
    private static final Script REDUCE_SCRIPT = new Script(
            return state;
        Collections.emptyMap()
        }
    public void testScriptedMetricWithNullCombineResult() throws IOException {
        ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
                    .initScript(INIT_SCRIPT_PARAMS)
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        });
            Map<String, Object> state = (Map<String, Object>) params.get("state");
    );
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        "mapScriptParams",
        MockScriptEngine.NAME,
        try (Directory directory = newDirectory()) {
import java.util.ArrayList;
            .reduceScript(REDUCE_SCRIPT);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        });
                IllegalArgumentException ex = expectThrows(
            return state;
            int numDocs = randomInt(100);
            Map<String, Object> state = (Map<String, Object>) params.get("state");
                );
        "combineScriptNull",
            params -> ((List) params.get("states")).stream().mapToInt(i -> (int) i).sum() + (int) params.get("aggs_param") + (int) params
        }
                assertNotNull(scriptedMetric.aggregation());
                aggregationBuilder.initScript(INIT_SCRIPT_SCORE)
            }
        IndexSearcher indexSearcher,
                    aggregationBuilder
                // No need to add docs for this test
    public void testSelfReferencingAggStateAfterMap() throws IOException {
                for (int i = 0; i < 100; i++) {
     * We cannot use Mockito for mocking QueryShardContext in this case because
    @Before
    public void testConflictingAggAndScriptParams() throws IOException {
                for (int i = 0; i < numDocs; i++) {
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
            List<?> states = (List<?>) params.get("states");
        try (Directory directory = newDirectory()) {
import org.apache.lucene.document.SortedNumericDocValuesField;
public class ScriptedMetricAggregatorTests extends AggregatorTestCase {
            }
            state.put("collector", new ArrayList<Double>());
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
            }
    }
        SCRIPTS.put("combineScriptNoop", params -> {
                    aggregationBuilder
        });
            indexSettings,
            state.put("collector", new ArrayList<Integer>());
            return state;
        try (Directory directory = newDirectory()) {
            ((List<Double>) state.get("collector")).add(((Number) params.get("_score")).doubleValue());
        SCRIPTS.put("combineScriptParams", params -> {
        MockScriptEngine.NAME,
                for (int i = 0; i < 100; i++) {
import org.opensearch.core.common.breaker.CircuitBreakingException;
                assertEquals(0, scriptedMetric.aggregation());
                    .mapScript(MAP_SCRIPT)
            Map<String, Object> state = (Map<String, Object>) params.get("state");
                    ex.getMessage()
            state.put("selfRef", state);
        MockScriptEngine.NAME,
                    .mapScript(MAP_SCRIPT_SCORE)
                }
import org.opensearch.search.aggregations.MultiBucketConsumerService.MultiBucketConsumer;
            }
import org.junit.BeforeClass;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.apache.lucene.index.DirectoryReader;
        });
        try (Directory directory = newDirectory()) {
    @Override
        SCRIPTS.put("initScriptSelfRef", params -> {
                    newSearcher(indexReader, true, true),
                    aggregationBuilder
import java.util.HashMap;
            }
        Collections.singletonMap("multiplier", 4)
                assertEquals(4803, scriptedMetric.aggregation());
                    .reduceScript(REDUCE_SCRIPT);
    );
            }
import org.opensearch.core.indices.breaker.CircuitBreakerService;
        ScriptType.INLINE,
     */
            state.put("collector", collector);
            0,
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
            Map<String, Object> state = (Map<String, Object>) params.get("state");
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        ScriptType.INLINE,
    protected ScriptService getMockScriptService() {
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
                    new MatchAllDocsQuery(),
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.store.Directory;
            indexSearcher,
                    new MatchAllDocsQuery(),
        }
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        });
            null,
                    IllegalArgumentException.class,
    private static final Script MAP_SCRIPT_SCORE = new Script(
    }
            }
            fieldTypes
        SearchContext searchContext = createSearchContext(
        try (Directory directory = newDirectory()) {
                }
                total += bytes;
                // all documents have score of 1.0
    @Override
        return createAggregator(aggregationBuilder, searchContext);
    private static final Script COMBINE_SCRIPT = new Script(
/*
            }
        try (Directory directory = newDirectory()) {
                    .combineScript(COMBINE_SCRIPT_SCORE)
                aggregationBuilder.initScript(INIT_SCRIPT_PARAMS)
        });
                aggregationBuilder.mapScript(MAP_SCRIPT).combineScript(COMBINE_SCRIPT_NOOP).reduceScript(REDUCE_SCRIPT);
        ScriptType.INLINE,
                );
 *
            assertThat(even.getDocCount(), equalTo(50L));
import org.opensearch.script.Script;
            }
                IllegalArgumentException exception = expectThrows(
        MapperService mapperService,
     */
                IllegalArgumentException ex = expectThrows(
        }
    }
import org.opensearch.index.query.QueryShardContext;
    );
}
                ScriptedMetric scriptedMetric = searchAndReduce(
import org.apache.lucene.document.SortedSetDocValuesField;
                    .combineScript(COMBINE_SCRIPT_SELF_REF)
                assertEquals(numDocs, scriptedMetric.aggregation());
import java.util.Map;
            Integer itemValue = (Integer) params.get("itemValue");
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
        ScriptType.INLINE,
        ScriptType.INLINE,
                assertEquals("Iterable object is self-referencing itself (Scripted metric aggs map script)", ex.getMessage());
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
    private static final Script COMBINE_SCRIPT_PARAMS = new Script(
import org.opensearch.core.common.breaker.CircuitBreaker;
    private static final Script MAP_SCRIPT_PARAMS = new Script(
            }
    protected QueryShardContext queryShardContextMock(
        Query query,
                );
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
    private static final String CONFLICTING_PARAM_NAME = "initialValue";
            Map<String, Object> state = (Map<String, Object>) params.get("state");
        );
            return state;
                    IllegalArgumentException.class,
import java.util.function.Function;
        MockScriptEngine.NAME,
                assertEquals(4896, scriptedMetric.aggregation());
            ScriptedMetric evenMetric = even.getAggregations().get("scripted");
            valuesSourceRegistry
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, SCRIPTS, Collections.emptyMap());
    public void testAsSubAgg() throws IOException {
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
 * this work for additional information regarding copyright
            return states.stream().filter(a -> a instanceof Number).map(a -> (Number) a).mapToInt(Number::intValue).sum();
                    .mapScript(MAP_SCRIPT)
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
        });
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                // The result value depends on the script params.
    private static final Script MAP_SCRIPT_SELF_REF = new Script(
            public long getUsed() {
        SCRIPTS.put("initScriptParams", params -> {
            int numDocs = randomInt(100);
        testCase(aggregationBuilder, new MatchAllDocsQuery(), buildIndex, verify, keywordField("t"), longField("number"));
        "mapScriptScore",
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
        });
                    new MatchAllDocsQuery(),
    private static final Script INIT_SCRIPT_PARAMS = new Script(
            state.put("selfRef", state);
                aggregationBuilder.params(Collections.singletonMap("aggs_param", 1))
        });
                // The result value depends on the script params.
                .get("additional") - ((List) params.get("states")).size() * 24 * 4
            .mapScript(MAP_SCRIPT)
                assertEquals("Iterable object is self-referencing itself (Scripted metric aggs combine script)", ex.getMessage());
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;
                );
        ScriptType.INLINE,
                aggregationBuilder.initScript(INIT_SCRIPT).mapScript(MAP_SCRIPT).combineScript(COMBINE_SCRIPT);
    private static final Script MAP_SCRIPT = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "mapScript", Collections.emptyMap());
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                assertEquals(numDocs, scriptedMetric.aggregation());
                    .combineScript(COMBINE_SCRIPT_PARAMS)
    ) throws IOException {
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> { iw.addDocument(new Document()); }, (InternalScriptedMetric r) -> {
        try (Directory directory = newDirectory()) {
    private CircuitBreakerService circuitBreakerService;
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
                indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));
 * specific language governing permissions and limitations
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
import org.apache.lucene.search.IndexSearcher;
        Collections.singletonMap("additional", 2)
            collector.add(initialValue);
    );
                    aggregationBuilder
        SCRIPTS.put("initScriptScore", params -> {
                // No need to add docs for this test
import org.opensearch.search.internal.SearchContext;
        MockScriptEngine.NAME,
                    newSearcher(indexReader, true, true),
            Map<String, Object> state = (Map<String, Object>) params.get("state");
                assertEquals(0, scriptedMetric.aggregation());
        Collections.singletonMap("itemValue", 12)
        AggregationBuilder aggregationBuilder,
                aggregationBuilder.initScript(INIT_SCRIPT)
            System::currentTimeMillis,
            assertThat(odd.getDocCount(), equalTo(49L));
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
        Collections.emptyMap()
                    .mapScript(MAP_SCRIPT_SELF_REF)
                indexWriter.forceMerge(1);
    }
                }
                    .reduceScript(REDUCE_SCRIPT);
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                );
            null,
import static java.util.Collections.singleton;
        Collections.emptyMap()
            }
        MockScriptEngine.NAME,
            Map<String, Object> state = (Map<String, Object>) params.get("state");
        SCRIPTS.put("combineScript", params -> {
import org.apache.lucene.search.MatchAllDocsQuery;
    ) {
    }
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
 *
        MockScriptEngine.NAME,
            }
            state.put("array", new String[] { "foo", "bar" });
        Collections.singletonMap("initialValue", 24)
 * You may obtain a copy of the License at
    );
/*
 *
 * this file be licensed under the Apache-2.0 license or a
        "combineScriptParams",
                // force a single aggregator
                ScriptedMetric scriptedMetric = searchAndReduce(
        MockScriptEngine.NAME,
                for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.util.BytesRef;
 * Unless required by applicable law or agreed to in writing,
                assertEquals(AGG_NAME, scriptedMetric.getName());
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
            }
            @Override
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
import org.opensearch.search.aggregations.Aggregator;
            }
    }
    private static final String AGG_NAME = "scriptedMetric";
        SCRIPTS.put("combineScriptNull", params -> null);
                    new MatchAllDocsQuery(),
                    .combineScript(COMBINE_SCRIPT_PARAMS)
                aggregationBuilder.initScript(INIT_SCRIPT)
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        }
    }
            }
            return state;
     */
                for (int i = 0; i < 100; i++) {
 */
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
import org.opensearch.script.ScriptEngine;
                assertEquals(
    /**
                }
    public void testScriptedMetricWithCombineAccessesScores() throws IOException {
    private static final Script REDUCE_SCRIPT_PARAMS = new Script(
            Map<String, Object> state = (Map<String, Object>) params.get("state");
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                aggregationBuilder.initScript(INIT_SCRIPT).mapScript(MAP_SCRIPT).reduceScript(REDUCE_SCRIPT);
                assertEquals(AGG_NAME, scriptedMetric.getName());
import static org.mockito.Mockito.mock;
            xContentRegistry(),
            return state;
    }
        );
        MappedFieldType... fieldTypes
        SCRIPTS.put(
            }
    private static final Script COMBINE_SCRIPT_NULL = new Script(
                return total;
            return state;
import org.opensearch.script.MockScriptEngine;
    protected void afterClose() {
        SCRIPTS.put("mapScript", params -> {
            query,
            null,
        when(circuitBreakerService.getBreaker(CircuitBreaker.REQUEST)).thenReturn(new NoopCircuitBreaker(CircuitBreaker.REQUEST) {
    private static final Map<String, Function<Map<String, Object>, Object>> SCRIPTS = new HashMap<>();
    );
                    IllegalArgumentException.class,
            state.put("selfRef", state);
        }
                total += bytes;
    private static final Script INIT_SCRIPT_SCORE = new Script(
        "combineScriptNoop",
            indexSettings,
 *    http://www.apache.org/licenses/LICENSE-2.0
                    .reduceScript(REDUCE_SCRIPT);
import static org.hamcrest.Matchers.equalTo;
            StringTerms.Bucket even = terms.getBucketByKey("even");
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
                    newSearcher(indexReader, true, true),
import org.opensearch.search.aggregations.AggregationBuilder;
                    "Parameter name \"" + CONFLICTING_PARAM_NAME + "\" used in both aggregation and script parameters",
import org.opensearch.script.ScriptType;
        "initScriptParams",
            Map<String, Object> state = (Map<String, Object>) params.get("state");
            Integer numDocs = randomIntBetween(1, 100);
            return state;
                    .combineScript(COMBINE_SCRIPT_PARAMS)
 */
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    );
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
/*
import org.opensearch.index.mapper.MapperService;
        Collections.emptyMap()
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
        }
        });
                    aggregationBuilder,
        IndexSearcher searcher,
                    .mapScript(MAP_SCRIPT_PARAMS)
            Map<String, Object> state = (Map<String, Object>) params.get("state");
        });
        };
            getIndexFieldDataLookup(mapperService, circuitBreakerService),
    private static final Script INIT_SCRIPT = new Script(ScriptType.INLINE, MockScriptEngine.NAME, "initScript", Collections.emptyMap());
    }
        assertThat(circuitBreakerService.getBreaker(CircuitBreaker.REQUEST).getUsed(), equalTo(0L));
            null,
                ScriptedMetricAggregationBuilder aggregationBuilder = new ScriptedMetricAggregationBuilder(AGG_NAME);
                }
        }
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
                    0
 * The OpenSearch Contributors require contributions made to
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                for (int i = 0; i < numDocs; i++) {
            null,
 * under the License.
        IndexSettings indexSettings,
import java.util.Collections;
            }
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        SCRIPTS.put("initScriptMakingArray", params -> {
        }
        ScriptType.INLINE,
import org.apache.lucene.index.IndexReader;
        CircuitBreakerService circuitBreakerService,
        SCRIPTS.put("reduceScript", params -> {
    );
                    .mapScript(MAP_SCRIPT_PARAMS)
            Map<String, Object> state = (Map<String, Object>) params.get("state");
                aggregationBuilder.initScript(INIT_SCRIPT)
        ScriptService scriptService = new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
        ScriptType.INLINE,
        MockScriptEngine.NAME,
            Map<String, Object> state = (Map<String, Object>) params.get("state");
 */
        try (Directory directory = newDirectory()) {
    }
 * not use this file except in compliance with the License.
            for (int i = 0; i < 99; i++) {
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
        SCRIPTS.put("initScript", params -> {
    private static final Script COMBINE_SCRIPT_SCORE = new Script(
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.opensearch.index.IndexSettings;
    public static void initMockScripts() {
package org.opensearch.search.aggregations.metrics;
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            assertThat(oddMetric.aggregation(), equalTo(49));
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                assertEquals(exception.getMessage(), "[combineScript] must not be null: [scriptedMetric]");
                assertEquals(AGG_NAME, scriptedMetric.getName());
            scriptService,
        Collections.emptyMap()
    );
     * script-related methods (e.g. QueryShardContext#getLazyExecutableScript)
import org.opensearch.common.util.BigArrays;
            }
                    IllegalArgumentException.class,
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.search.Query;
        aggregationBuilder.initScript(INIT_SCRIPT_MAKING_ARRAY)
            null,
        circuitBreakerService = mock(CircuitBreakerService.class);
        });
        "mapScriptSelfRef",
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
                assertEquals("Iterable object is self-referencing itself (Scripted metric aggs init script)", ex.getMessage());
                );
                ScriptedMetric scriptedMetric = searchAndReduce(
        });
    private static final Script INIT_SCRIPT_SELF_REF = new Script(
    );
                );
        MockScriptEngine.NAME,
            ((List<Integer>) state.get("collector")).add(1); // just add 1 for each doc the script is run on
            }
            ((List<Integer>) state.get("collector")).add(itemValue);
                aggregationBuilder.params(aggParams)
        try (Directory directory = newDirectory()) {
        }
                    aggregationBuilder
        return new QueryShardContext(
        Consumer<StringTerms> verify = terms -> {
import org.junit.Before;
            return ((List<Integer>) state.get("collector")).stream().mapToInt(Integer::intValue).map(i -> i * multiplier).sum();
    public void testNoDocs() throws IOException {
    protected <A extends Aggregator> A createAggregator(
    @SuppressWarnings("unchecked")
            public long addWithoutBreaking(long bytes) {
            writableRegistry(),
        MockScriptEngine.NAME,
 * GitHub history for details.
                ScriptedMetric scriptedMetric = searchAndReduce(
            Integer initialValue = (Integer) params.get("initialValue");
            mapperService,
            }
                return total;
            return state;
            }
            return state;
            }
        "combineScript",
                    .mapScript(MAP_SCRIPT_PARAMS)
    @BeforeClass
            }
                IllegalArgumentException ex = expectThrows(
        ScriptService scriptService = new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
        }
                );
        ScriptType.INLINE,
import java.util.List;
                    .reduceScript(REDUCE_SCRIPT);
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
                    IllegalArgumentException.class,
    );
                logger.debug("Used {} grabbing {} for {}", total, bytes, label);
        SCRIPTS.put("mapScriptScore", params -> {
 * KIND, either express or implied.  See the License for the
                    indexWriter.addDocument(singleton(new SortedNumericDocValuesField("number", i)));
                    IllegalArgumentException.class,
                    new MatchAllDocsQuery(),
    );
            @Override
        try (Directory directory = newDirectory()) {
                // intentionally not writing any docs
        MockScriptEngine.NAME,
            state.put("collector", new ArrayList<Integer>());
        ScriptType.INLINE,
                assertNotNull(scriptedMetric.aggregation());
import org.opensearch.common.CheckedConsumer;
    }
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, SCRIPTS, Collections.emptyMap());
                aggregationBuilder.initScript(INIT_SCRIPT).mapScript(MAP_SCRIPT).combineScript(COMBINE_SCRIPT).reduceScript(REDUCE_SCRIPT);
            public double addEstimateBytesAndMaybeBreak(long bytes, String label) throws CircuitBreakingException {
        ScriptType.INLINE,
        Collections.emptyMap()
        Collections.emptyMap()
 * Licensed to Elasticsearch under one or more contributor
        Collections.emptyMap()
                    () -> searchAndReduce(newSearcher(indexReader, true, true), new MatchAllDocsQuery(), aggregationBuilder)
        "combineScriptScore",
        });
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                iw.addDocument(singleton(new SortedSetDocValuesField("t", i % 2 == 0 ? new BytesRef("even") : new BytesRef("odd"))));
                );
                    .mapScript(MAP_SCRIPT)
    }
                assertEquals(AGG_NAME, scriptedMetric.getName());
                assertEquals(exception.getMessage(), "[reduceScript] must not be null: [scriptedMetric]");
        MultiBucketConsumer bucketConsumer,
        ScriptType.INLINE,
        SCRIPTS.put("combineScriptSelfRef", params -> {
                    newSearcher(indexReader, true, true),
                    newSearcher(indexReader, true, true),
                    .combineScript(COMBINE_SCRIPT_PARAMS)
            return state;
