        );
            "sum all states (lists) values as a new aggregation",
            .addAggregation(
        assertSearchResponse(r);
        );
 * The OpenSearch Contributors require contributions made to
import java.util.HashMap;
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));
    }
 * specific language governing permissions and limitations
            .setSize(0)
            .get();
            "state.list.add(vars.multiplier)",
                .setId("mapScript_stored")
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
                            .initScript(initScript)
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
            .addAggregation(
        );
        );
        Script ndInitScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state.data = Math.random()", Collections.emptyMap());
                .get()
import java.util.List;
            // sum += s
            .get();
                .setContent(
                List newAggregation = new ArrayList();
            Collections.emptyMap()
        );
import org.opensearch.script.ScriptType;
        assertThat(
            Collections.emptyMap()
import static org.hamcrest.Matchers.instanceOf;
        Map<String, Object> params = new HashMap<>();
            assertThat(object, instanceOf(Map.class));
                Integer multiplier = (Integer) vars.get("multiplier");
            Collections.emptyMap()
                        .combineScript(combineScript)
                .setRequestCache(true)
                .getHitCount(),
            Map<?, ?> map = (Map<?, ?>) object;
                    .setId("" + i)
                    state -> state.put(
import java.nio.file.Path;
            client().admin()
        assertThat(totalCount, equalTo(numDocs));
        assertThat(histoAgg.getName(), equalTo("histo"));
        varsMap.put("multiplier", 1);
            scripts.put("state.data = Math.random()", vars -> aggScript(vars, state -> state.put("data", ScriptedMetricIT.randomDouble())));
        Object object = aggregationList.get(0);
        Aggregation aggregation = response.getAggregations().get("scripted");
        }
            "sum state values as a new aggregation",
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                    .interval(1L)
            // When using the MockScriptPlugin we can map File scripts to inline scripts:
            // sum = 0;
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
                .getHitCount(),
    public void testMap() {
                assertThat(o, notNullValue());
            .addAggregation(
        // with script based aggregation, if it does not support reduce then aggregationList size
            // return newaggregation"
            "state.list.add(vars.multiplier)",
            Files.write(scripts.resolve("map_script.mockscript"), "state.list.add(vars.multiplier)".getBytes("UTF-8"));
            for (Object o : list) {
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
            )
            }
        assertSearchResponse(response);
                    .initScript(initScript)
        }
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        Script combineScript = new Script(
            .setQuery(matchAllQuery())
    public void testInitMapReduceWithParams() {
    public void testMapWithParams() {
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
        assertThat(object, instanceOf(Number.class));
            client().admin()
        for (Object object : aggregationList) {
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
                .indices()
                        for (Object s : list) {
        assertThat((List) ((InternalAggregation) global).getProperty("scripted.value"), sameInstance((List) aggregationList));
                // we have to assume the lower bound may be 0. The check at the
                .getTotal()
            CustomScriptPlugin.NAME,
                Number numberValue = (Number) o;
        assertThat(ex.getCause().getMessage(), containsString("Parameter name \"param1\" used in both aggregation and script parameters"));
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
                .indices()
        assertThat(aggregationList.size(), equalTo(1));
        assertSearchResponse(searchResponse);
    }
import java.util.Collections;
            client().admin()
                    if (list != null) {
            Collections.emptyMap()
            .addAggregation(
            client().admin()
                assertThat(numberValue.longValue(), allOf(greaterThanOrEqualTo(0L), lessThanOrEqualTo(numDocs * 3)));
                scriptedMetric("scripted").params(params).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
                        (String) XContentMapValues.extractValue("params.param1", vars),
        Aggregation aggregation = response.getAggregations().get("histo");
            assertThat(map.size(), lessThanOrEqualTo(1));
        for (Object object : aggregationList) {
            .get();
        Object object = aggregationList.get(0);
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
 *
                        XContentMapValues.extractValue("params.param2", vars)
                    .combineScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap()))
        @SuppressWarnings("unchecked")
                for (Map<String, Object> state : states) {
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
                assertThat(entry, notNullValue());
        int numShardsRun = 0;
            .get();
            Aggregation subAgg = subAggs.get("scripted");
                List<?> list = (List<?>) state.get("list");
            .setQuery(matchAllQuery())
                    .initScript(initScript)
            assertThat(object, instanceOf(HashMap.class));
        );
        assertThat(totalCount, equalTo(numDocs * 3));
            .addAggregation(scriptedMetric("foo").mapScript(ndMapScript).combineScript(combineScript).reduceScript(reduceScript))
        // creating an index to test the empty buckets functionality. The way it
import java.nio.file.Files;
                }
                    List<?> list = (List<?>) state.get("list");
        assertThat(((Number) object).longValue(), equalTo(numDocs * 3));
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        SearchResponse response = client().prepareSearch("idx")
            //
        Map<String, Object> params = new HashMap<>();
        }
                )
                scriptedMetric("scripted").params(params)
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));
            scripts.put("vars.multiplier = 3", vars -> {
        varsMap.put("multiplier", 1);
            //
                .getRequestCache()
import java.util.Collection;
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
        params.put("vars", varsMap);
            "sum all states' state.list values as a new aggregation",
                Map<String, Object> state = (Map<String, Object>) vars.get("state");
            Files.write(
                        "{\"script\": {\"lang\": \""
        // aggregations.
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state['count'] = 1", Collections.emptyMap());
        // works is by indexing
        Script reduceScript = new Script(
            assertThat(b.getDocCount(), equalTo(1L));
                    MediaTypeRegistry.JSON
        );
                .get()
        assertThat(aggregation, notNullValue());
            assertThat(subAggs, notNullValue());
     */
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            Collections.emptyMap()
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
                }
                List newAggregation = new ArrayList();
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
                assertThat(o, notNullValue());
            }));
    public static class CustomScriptPlugin extends MockScriptPlugin {
        r = client().prepareSearch("cache_test_idx")
        varsMap.put("multiplier", 1);
            client().admin()
        SearchResponse r = client().prepareSearch("cache_test_idx")
                scriptedMetric("scripted").params(params)
    }
                            .reduceScript(reduceScript)
import org.opensearch.search.aggregations.Aggregations;
                .indices()
            equalTo(0L)
        assertSearchResponse(response);
                assertThat(numberValue.longValue(), allOf(greaterThanOrEqualTo(0L), lessThanOrEqualTo(numDocs)));
            Collections.emptyMap()
                    .initScript(new Script(ScriptType.STORED, null, "initScript_stored", Collections.emptyMap()))
import java.util.function.Consumer;
        );
        Map<String, Object> varsMap = new HashMap<>();
            // newaggregation = [];
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
                        "{\"script\": {\"lang\": \""
import static org.hamcrest.Matchers.greaterThan;
import java.util.function.Function;
            )
        assertThat(totalCount, equalTo(numDocs * 3));
                assertThat(entry.getValue(), notNullValue());
        Script mapScript = new Script(
            // sum += s
        ensureSearchable();
        SearchPhaseExecutionException ex = expectThrows(SearchPhaseExecutionException.class, builder::get);
            client().admin()
            )
                .indices()
                scriptedMetric("scripted").params(params)
        );
            ScriptType.INLINE,
                    .combineScript(new Script(ScriptType.STORED, null, "combineScript_stored", Collections.emptyMap()))
                .get()
import org.opensearch.action.search.SearchRequestBuilder;
        varsMap.put("multiplier", 1);
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
        Histogram.Bucket bucket = histo.getBuckets().get(1);
        Script mapScript = new Script(
    public void testInitMapCombineReduceWithParamsAndReduceParams() {
        Map<String, Object> params = new HashMap<>();
        Script reduceScript = new Script(
    @SuppressWarnings("rawtypes")
        Script combineScript = new Script(
        return config;
                    .reduceScript(reduceScript)
        // Test that a non-deterministic combine script causes the result to not be cached
                .setId("reduceScript_stored")
        );
        );
                .setRequestCache(true)
        SearchResponse response = client().prepareSearch("idx")
        assertThat(aggregation, notNullValue());
    }
        Script mapScript = new Script(
                ((Map<String, Object>) vars.get("vars")).put("multiplier", 3);
                }
        assertThat(object, notNullValue());
            Collections.emptyMap()
            Collections.emptyMap()
                    state.put("list", new ArrayList());
            }));
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
                .setId("combineScript_stored")
            return scripts;
        Map<String, Object> params = new HashMap<>();
    public static Collection<Object[]> parameters() {
            assertThat(object, instanceOf(Number.class));
    public void testMapReduceWithParams() {
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
            // };
                            .mapScript(mapScript)
        Script reduceScript = new Script(
        params.put("vars", varsMap);
                assertThat(o, instanceOf(Number.class));
                    .mapScript(mapScript)
                assertThat(o, instanceOf(Number.class));
                .setRequestCache(true)
        );
            .addAggregation(
        assertAcked(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
 * You may obtain a copy of the License at
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
        Aggregation aggregation = response.getAggregations().get("scripted");
                .setRequestCache(true)
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        Map<String, Object> params = new HashMap<>();
            }
            .setQuery(matchAllQuery())
                        }
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
            // sum = 0;
        assertSearchResponse(response);
                .setRequestCache(true)
            .setQuery(matchAllQuery())
            true,
            .setQuery(matchAllQuery())
 * ownership. Elasticsearch licenses this file to you under
            Collections.emptyMap()
        assertThat(object, notNullValue());
    public void testInitMutatesParams() {
        // will be numShards * slicesCount
                    }
            });
            .get();
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
            .get();
    public void testMapCombineWithParams() {
            List<?> list = (List<?>) map.get("list");
        assertAcked(
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
        assertThat(aggregation, notNullValue());
                .getTotal()
            .addAggregation(
            assertThat(object, notNullValue());
            ScriptType.INLINE,
        Map<String, Object> varsMap = new HashMap<>();
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
            });
                .prepareStats("cache_test_idx")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(map.get("list"), instanceOf(List.class));
            .setQuery(matchAllQuery())
            CustomScriptPlugin.NAME,
                        scriptedMetric("scripted").params(params)
        config = createTempDir().resolve("config");
                .getRequestCache()
                            + " \"source\": \"sum all states (lists) values as a new aggregation\"} }"
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                for (List<?> list : states) {
            CustomScriptPlugin.NAME,
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
            .addAggregation(scriptedMetric("foo").mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript))
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
                            .combineScript(combineScript)
    }
        assertThat(aggregation, notNullValue());
                }
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
                .getTotal()
        // must match a predefined script from CustomScriptPlugin.pluginScripts() method
        assertSearchResponse(response);
            client().admin()
            // return newaggregation"
        for (Object object : aggregationList) {
                .getRequestCache()
import static org.hamcrest.Matchers.containsString;
        assertThat(aggregation, notNullValue());
            ScriptType.INLINE,
                .prepareStats("cache_test_idx")
            .setSize(1000)
                .cluster()
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
                // we have to assume the lower bound may be 0. The check at the
        );
            client().admin()
    }
                client().prepareIndex("empty_bucket_idx")
                // bottom of the test method will make sure the count is correct
                .get()
            assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
            ScriptType.INLINE,
                    }
            }
                            + " \"source\": \"sum state values as a new aggregation\"} }"
            "state.list.add(vars.multiplier)",
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
        for (Object object : aggregationList) {
 * this file be licensed under the Apache-2.0 license or a
        assertThat(scriptedMetric.aggregation(), notNullValue());
            "state.list.add(vars.multiplier)",
        assertThat(object, instanceOf(Number.class));
        }
                .get()
        );
            // Equivalent to:
                .getTotal()
                "state['count'] = Math.random() >= 0.5 ? 1 : 0",
            Collections.emptyMap()
            //
        Histogram histoAgg = (Histogram) aggregation;
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));
            ScriptType.INLINE,
            .get();
                ((List) state.get("list")).add(1);
                    )
    protected Path nodeConfigPath(int nodeOrdinal) {
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
        assertThat(object, notNullValue());
        Object object = aggregationList.get(0);
            ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) subAgg;
        assertThat(((Number) object).longValue(), equalTo(numDocs));
            ScriptType.INLINE,
                .setRequestCache(true)
                    new BytesArray(
            )
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state['count'] = 1", Collections.emptyMap());
        assertThat(object, instanceOf(Number.class));
            Collections.emptyMap()
        SearchResponse response = client().prepareSearch("idx")
        }
    /**
                assertThat(entry.getValue(), instanceOf(Number.class));
        // Split the params up between the script and the aggregation.
        Map<String, Object> varsMap = new HashMap<>();
            .addAggregation(
        Object object = aggregationList.get(0);
            CustomScriptPlugin.NAME,
                        "{\"script\": {\"lang\": \"" + MockScriptPlugin.NAME + "\"," + " \"source\": \"state.list.add(vars.multiplier)\"} }"
        Map<String, Object> scriptParams = Collections.singletonMap("param1", "12");
@ClusterScope(scope = Scope.SUITE)
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
        );
            List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        assertThat(
        // sure that at least one shard ran the map script
        assertThat(scriptedMetric.aggregation(), instanceOf(List.class));
        assertSearchResponse(response);
            CustomScriptPlugin.NAME,
import org.opensearch.common.settings.Settings;
        );
            Files.createDirectories(scripts);
    public void testInitMapCombineReduceGetProperty() throws Exception {
        // with script based aggregation, if it does not support reduce then aggregationList size
import org.opensearch.action.search.SearchPhaseExecutionException;
                            + "\","
                .get()
            .addAggregation(
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        varsMap.put("multiplier", 1);
                return state;
            CustomScriptPlugin.NAME,
        SearchResponse response = client().prepareSearch("idx")
                histogram("histo").field("l_value")
            equalTo(0L)
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            "state.list.add(vars.multiplier)",
        );
                .getRequestCache()
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            Map<?, ?> map = (Map<?, ?>) object;
 *
                .prepareStats("cache_test_idx")
                .getMissCount(),
            // for (state in states) {
        assertThat(((Number) object).longValue(), equalTo(numDocs * 12));
        // NOTE: random reduce scripts don't hit the query shard context (they are done on the coordinator) and so can be cached.
        ScriptedMetric scriptedMetricAggregation = global.getAggregations().get("scripted");
            // for (s in state.list) {
            .addAggregation(
            Collections.emptyMap()
            )
                scriptedMetric("scripted").params(params).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
        r = client().prepareSearch("cache_test_idx")
            ScriptType.INLINE,
import static org.opensearch.search.aggregations.AggregationBuilders.scriptedMetric;
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));
                    scriptedMetric("scripted").params(params)
                .getHitCount(),
                    )
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        @Override
                }
        params.put("vars", varsMap);
                    Integer sum = 0;
        assertThat(
     * Make sure that a request using a deterministic script gets cached and nondeterministic scripts do not get cached.
            CustomScriptPlugin.NAME,
import static org.opensearch.search.aggregations.AggregationBuilders.global;
            "sum state values as a new aggregation",
        Script mapScript = new Script(
        assertThat(scriptedMetricAggregation, notNullValue());
        assertThat(
import org.opensearch.plugins.Plugin;
        assertThat(numShardsRun, greaterThan(0));
            throw new RuntimeException("failed to create scripts");
                .prepareStats("cache_test_idx")
                    .initScript(initScript)
                if (state.containsKey("list") == false) {
            .addAggregation(
import static org.hamcrest.Matchers.notNullValue;
        Map<String, Object> varsMap = new HashMap<>();
        // will be numShards * slicesCount
                .getMissCount(),
        // two docs {value: 0} and {value : 2}, then building a histogram agg
            "sum all states (lists) values as a new aggregation",
        params.put("vars", varsMap);
            //
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
                "sum all states (lists) values as a new aggregation".getBytes("UTF-8")
                scriptedMetric("scripted").params(aggregationParams)
        }
            scripts.put(
            //
            .get();
        Map<String, Object> aggregationParams = Collections.singletonMap("param2", 1);
    @ParametersFactory
                .indices()
        super(staticSettings);
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        // We don't know how many shards will have documents but we need to make
    public void testInitMapCombineReduceWithParams() {
                        .reduceScript(reduceScript)
        assertThat(aggregation, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                // Lazily populate state.list for tests without an init script
            equalTo(0L)
        long totalCount = 0;
        // will be numShards * slicesCount
                    .mapScript(new Script(ScriptType.STORED, null, "mapScript_stored", Collections.emptyMap()))
            //
 * compatible open source license.
        assertThat(histo, notNullValue());
            client().admin()
        Map<String, Object> reduceParams = new HashMap<>();
    }
            Collections.emptyMap()
        static Map<String, Object> aggScript(Map<String, Object> vars, Consumer<Map<String, Object>> fn) {
        params.put("vars", varsMap);
        }
            CustomScriptPlugin.NAME,
        assertThat(aggregationList.size(), equalTo(1));
                .setRequestCache(true)
            scripts.put("no-op aggregation", vars -> { return (Map<String, Object>) vars.get("state"); });
        SearchResponse response = client().prepareSearch("idx")
            scripts.put("state.list.add(1)", vars -> aggScript(vars, state -> {
            .addAggregation(
        } catch (IOException e) {
            fn.accept(aggState);
        assertThat(
        Aggregation aggregation = response.getAggregations().get("scripted");
                    MediaTypeRegistry.JSON
        assertSearchResponse(response);
            );
                    .interval(1)
                }
        );
            "sum all states' state.list values as a new aggregation",
                    .reduceScript(reduceScript)
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
                .getMissCount(),
        assertThat(aggregationList.size(), equalTo(1));
                    .initScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap()))
            // sum = 0;
            assertThat(b, notNullValue());
        final Path scripts = config.resolve("scripts");
        );
            Collections.emptyMap()
        params.put("vars", varsMap);
                .prepareStats("cache_test_idx")
 * not use this file except in compliance with the License.
                .get()
        varsMap.put("multiplier", 1);
                .indices()
            for (Object o : list) {
import org.opensearch.action.index.IndexRequestBuilder;
            });
        SearchResponse response = client().prepareSearch("idx")
                        .mapScript(mapScript)
            equalTo(0L)
                .getHitCount(),
                .indices()
            // newaggregation.add(sum);
            .addAggregation(
                    ),
                            .mapScript(mapScript)
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
                            + MockScriptPlugin.NAME
                state.put("list", new ArrayList());
            List<?> list = (List<?>) object;
                return newAggregation;
            equalTo(0L)
            assertThat(object, instanceOf(List.class));
            ScriptType.INLINE,
            ScriptType.INLINE,
                histogram("histo").field("value")
                .getMissCount(),
        }
        params.put("vars", varsMap);
            for (Map.Entry<?, ?> entry : map.entrySet()) {
        assertThat(object, notNullValue());
                // A particular shard may not have any documents stored on it so
            scripts.put("sum state values as a new aggregation", vars -> {
        Script mapScript = new Script(
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
            .setQuery(matchAllQuery())
        assertThat(object, notNullValue());
            ScriptType.INLINE,
            builders.add(
                ((List) state.get("list")).add(XContentMapValues.extractValue("vars.multiplier", vars));
        SearchRequestBuilder builder = client().prepareSearch("idx")
    public void setUp() throws Exception {
    }
            CustomScriptPlugin.NAME,
            ScriptType.INLINE,
                        for (Object s : list) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            CustomScriptPlugin.NAME,
            scripts.put("state.list.add(vars.multiplier)", vars -> aggScript(vars, state -> {
            .get();
 * license agreements. See the NOTICE file distributed with
                scriptedMetric("scripted").params(params).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
            // newaggregation.add(sum * multiplier);
        Global global = searchResponse.getAggregations().get("global");
                .cluster()
 *
    }
            .addAggregation(scriptedMetric("scripted").mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript))
        Object object = aggregationList.get(0);
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
import org.junit.Before;
                "state[param1] = param2",
    }
}
                assertThat(numberValue, equalTo((Number) 3));
import org.opensearch.script.Script;
        for (int i = 0; i < 2; i++) {
        super.setUp();
        assertThat(aggregationList.size(), equalTo(1));
                            .reduceScript(reduceScript)
        }
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
        assertThat(aggregation, notNullValue());
                .getTotal()
                    )
        List<? extends Bucket> buckets = histoAgg.getBuckets();
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
        Script reduceScript = new Script(
                assertThat(o, instanceOf(Number.class));
                            + "\","
            // for (state in states) {
                    ),
        assertThat(((Number) object).longValue(), equalTo(numDocs * 3));
                .getTotal()
            .get();
        for (int i = 0; i < numDocs; i++) {
        Aggregation aggregation = response.getAggregations().get("scripted");
        Aggregation aggregation = response.getAggregations().get("scripted");
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                .indices()
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
        );
            // };
            Files.write(scripts.resolve("init_script.mockscript"), "vars.multiplier = 3".getBytes("UTF-8"));
                        scriptedMetric("scripted").params(params)
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
        Map<String, Object> varsMap = new HashMap<>();
                }
            Collections.emptyMap()
                        }
        Script combineScript = new Script(
        // Make sure we are starting with a clear cache
        assertAcked(
    }
            )
 * SPDX-License-Identifier: Apache-2.0
            .get();
                .setRequestCache(true)
                )
            "sum state values as a new aggregation",
        Script ndRandom = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "return Math.random()", Collections.emptyMap());
            .setQuery(matchAllQuery())
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                scriptedMetric("scripted").params(params).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
                    ),
    public void testConflictingAggAndScriptParams() {
                scriptedMetric("scripted").params(params)
                newAggregation.add(sum);
        assertThat(aggregation, instanceOf(Histogram.class));
    }
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            client().admin()
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            assertThat(object, notNullValue());
                            sum += ((Number) s).intValue();
            return scripts;
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
                    if (list != null) {
import org.opensearch.core.common.bytes.BytesArray;
            scripts.put("return Math.random()", vars -> ScriptedMetricIT.randomDouble());
                    new BytesArray(
                .getTotal()
            scripts.put("state['count'] = 1", vars -> aggScript(vars, state -> state.put("count", 1)));
            equalTo(0L)
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
            CustomScriptPlugin.NAME,
    }
        List<Integer> aggregationResult = (List<Integer>) scriptedMetric.aggregation();
                    .mapScript(mapScript)
        Script mapScript = new Script(
        indexRandom(
                .getRequestCache()
        numDocs = randomIntBetween(10, 100);
        Map<String, Object> varsMap = new HashMap<>();
    private static long numDocs;
                .getTotal()
                .getRequestCache()
            client().admin()
            .setSize(0)
        varsMap.put("multiplier", 1);
            "state.list.add(vars.multiplier)",
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .setQuery(matchAllQuery())
                .indices()
        long totalCount = 0;
    public void testMapCombineReduceWithParams() {
    @Override
                            sum += ((Number) s).intValue();
            CustomScriptPlugin.NAME,
        int numShardsRun = 0;
            )
                assertThat(entry.getKey(), instanceOf(String.class));
            builders.add(
            scripts.put("sum all states' state.list values as a new aggregation", vars -> {
        assertThat(aggregation, notNullValue());
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                assertThat(o, notNullValue());
            equalTo(2L)
            assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
        );
                .prepareStats("cache_test_idx")
            // for (s in state) {
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
            .get();
    }
                client().prepareIndex("idx")
        assertThat(numShardsRun, greaterThan(0));
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
            ScriptType.INLINE,
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    .combineScript(combineScript)
            assertThat(map, hasKey("list"));
            .addAggregation(
import java.util.Arrays;
            CustomScriptPlugin.NAME,
                .prepareStats("cache_test_idx")
                    .initScript(initScript)
        internalCluster().wipeIndices("cache_test_idx");
                    .subAggregation(
        // the id of the stored script is used in test method while the source of the stored script
/*
    }
            // newaggregation = [];
        );
            //
        // with script based aggregation, if it does not support reduce then aggregationList size
                    .combineScript(combineScript)
        builders = new ArrayList<>();
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                .preparePutStoredScript()
            Collections.emptyMap()
            assertThat(object, notNullValue());
                    vars,
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                newAggregation.add(sum);
import static org.hamcrest.Matchers.allOf;
        assertThat(global.getDocCount(), equalTo(numDocs));
import org.opensearch.script.MockScriptPlugin;
            assertThat(object, notNullValue());
        assertThat(aggregationList.size(), equalTo(1));
                scriptedMetric("scripted").params(params)
            )
            CustomScriptPlugin.NAME,
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocs));
                .get()
            .get();
            Collections.emptyMap()
        assertThat(global, notNullValue());
        assertAcked(
                return newAggregation;
        Object object = aggregationList.get(0);
                )
            Collections.emptyMap()
                    new BytesArray(
            assertThat(object, instanceOf(List.class));
            );
        Script reduceScript = new Script(
                    .minDocCount(0)
            CustomScriptPlugin.NAME,
        );
            CustomScriptPlugin.NAME,
        Map<String, Object> varsMap = new HashMap<>();
            "sum state values as a new aggregation",
        );
    }
            Map<String, Object> aggState = (Map<String, Object>) vars.get("state");
            scripts.put(
/*
            CustomScriptPlugin.NAME,
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
            "sum state values as a new aggregation",
            Collections.emptyMap()
                return newAggregation;
                totalCount += numberValue.longValue();
 * Unless required by applicable law or agreed to in writing,
                scripts.resolve("reduce_script.mockscript"),
                if (list != null) {
                .preparePutStoredScript()
        );
        assertThat(aggregation, notNullValue());
        Map<String, Object> params = new HashMap<>();
        SearchResponse response = client().prepareSearch("idx")
                .setContent(
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
                    .combineScript(combineScript)
            });
        );
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                .getRequestCache()
                List<List<?>> states = (List<List<?>>) vars.get("states");
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        // buckets computed.. the empty bucket is the one associated with key
                .get()
            assertThat(subAggs.asList().size(), equalTo(1));
        varsMap.put("multiplier", 1);
        // to check that this bucket exists with the appropriate sub
    public void testScriptCaching() throws Exception {
            .get();
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
            .get();
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertSearchResponse(r);
            //
                .setContent(
        Map<String, Object> varsMap = new HashMap<>();
                    .reduceScript(reduceScript)
        assertSearchResponse(response);
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state.list.add(1)", params);
            CustomScriptPlugin.NAME,
                .get()
                .prepareStats("cache_test_idx")
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
 * this work for additional information regarding copyright
                String stringValue = (String) entry.getKey();
        );
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            client().admin()
    public void testInitMapCombineReduceWithParamsAsSubAgg() {
                numShardsRun++;
            ScriptType.INLINE,
        assertThat(aggregation, notNullValue());
                .getTotal()
                .setId("initScript_stored")
        assertThat(object, instanceOf(Number.class));
        @Override
            "state.list.add(vars.multiplier)",
            CustomScriptPlugin.NAME,
            ScriptType.INLINE,
            "multiplied sum all states (lists) values as a new aggregation",
                    .mapScript(
        );
                assertThat(map.get("count"), equalTo((Number) 1));
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
            // return newaggregation"
        for (Bucket b : buckets) {
            // };
            // newaggregation.add(sum);
            ScriptType.INLINE,
        Script reduceScript = new Script(
        varsMap.put("multiplier", 1);
            assertThat(subAgg, instanceOf(ScriptedMetric.class));
                    .setId("" + i)
        Map<String, Object> params = new HashMap<>();
            ScriptType.INLINE,
            .addAggregation(
            assertThat(object, notNullValue());
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
        Script mapScript = new Script(
            scripts.put("sum all states (lists) values as a new aggregation", vars -> {
                    .combineScript(combineScript)
        assertThat(((InternalAggregation) global).getProperty("scripted"), sameInstance(scriptedMetricAggregation));
            });
            assertThat(object, instanceOf(Map.class));
            CustomScriptPlugin.NAME,
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, Object> params = new HashMap<>();
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            CustomScriptPlugin.NAME,
        Object object = aggregationList.get(0);
                            .combineScript(combineScript)
        // with script based aggregation, if it does not support reduce then aggregationList size
        assertThat(((Number) object).longValue(), equalTo(numDocs * 3));
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
            //
    public void testInitMapCombineReduceWithParamsStored() {
                Number numberValue = (Number) o;
                Integer sum = 0;
                    }
            ScriptType.INLINE,
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        );
                vars -> aggScript(vars, state -> state.put("count", ScriptedMetricIT.randomDouble() >= 0.5 ? 1 : 0))
        }
            "state['count'] = Math.random() >= 0.5 ? 1 : 0",
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
                .preparePutStoredScript()
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                .getRequestCache()
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
    @Override
        // "1". then each test will have
                )
                    .combineScript(combineScript)
        Script mapScript = new Script(
                // Lazily populate state.list for tests without an init script
        Aggregation aggregation = response.getAggregations().get("scripted");
            )
        SearchResponse response = client().prepareSearch("idx")
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
            .addAggregation(scriptedMetric("foo").mapScript(mapScript).combineScript(combineScript).reduceScript(ndRandom))
        assertThat(object, notNullValue());
            Collections.emptyMap()
                .getMissCount(),
        // When using the MockScriptPlugin we can map Stored scripts to inline scripts:
            CustomScriptPlugin.NAME,
                .get()
                    .subAggregation(
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
/*
        return Arrays.asList(
        Script combineScript = new Script(
        params.put("vars", varsMap);
                List<Map<String, Object>> states = (List<Map<String, Object>>) vars.get("states");
                        sum += ((Number) s).intValue();
            Collections.emptyMap()
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
        );
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
                    state.put("list", new ArrayList());
            .get();
        );
            )
                List newAggregation = new ArrayList();
            Collections.emptyMap()
        params.put("vars", varsMap);
        assertSearchResponse(response);
        );
            "state.list.add(vars.multiplier)",
import org.opensearch.search.aggregations.Aggregation;
                .indices()
            reduceParams
            if (map.size() == 1) {
                .get()
                List<List<?>> states = (List<List<?>>) vars.get("states");
            // Equivalent to:
            // newaggregation = [];
                            + MockScriptPlugin.NAME
                .getMissCount(),
        assertSearchResponse(r);
            Collections.emptyMap()
            // must match a predefined script from CustomScriptPlugin.pluginScripts() method
        Script mapScript = new Script(
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    new BytesArray(
        Map<String, Object> varsMap = new HashMap<>();
import org.opensearch.common.xcontent.support.XContentMapValues;
        Map<String, Object> varsMap = new HashMap<>();
        );
        assertSearchResponse(response);
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
            .setQuery(matchAllQuery())
            CustomScriptPlugin.NAME,
                .setRequestCache(true)
        assertThat(aggregationList.size(), equalTo(1));
                .getRequestCache()
        // with script based aggregation, if it does not support reduce then aggregationList size
            .setQuery(matchAllQuery())
                        new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state.list.add(vars.multiplier)", Collections.emptyMap())
                        for (Object s : list) {
 * software distributed under the License is distributed on an
        assertThat(bucket, notNullValue());
                numShardsRun++;
                .cluster()
            //
            ScriptType.INLINE,
            )
            equalTo(0L)
            assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
        );
            equalTo(0L)
        ScriptedMetric scriptedMetric = bucket.getAggregations().get("scripted");
import static org.hamcrest.Matchers.hasKey;
                    }
                )
            .setQuery(matchAllQuery())
        assertSearchResponse(response);
                .getHitCount(),
        // with interval 1 and with empty
            .get();
        }
                assertThat(stringValue, equalTo("12"));
 */
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        createIndex("idx");
 */
                    )
import org.opensearch.test.OpenSearchIntegTestCase;
public class ScriptedMetricIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .setSource(
                    )
            CustomScriptPlugin.NAME,
                    .mapScript(mapScript)
        SearchResponse response = client().prepareSearch("idx")
                .getRequestCache()
        assertThat(
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
            Object object = aggregationList.get(0);
        }
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
        assertThat(
                scriptedMetric("scripted").params(params)
                .prepareStats("cache_test_idx")
        varsMap.put("multiplier", 1);
 */
        Map<String, Object> params = new HashMap<>();
        assertThat(global.getName(), equalTo("global"));
                .preparePutStoredScript()
            // }
            );
                    .reduceScript(reduceScript)
                .getTotal()
            ScriptType.INLINE,
        Script reduceScript = new Script(
import java.util.Map;
                assertThat(numberValue, equalTo((Number) 1));
            "sum state values as a new aggregation",
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
                    .reduceScript(reduceScript)
            .setSize(0)
            // for (s in state) {
            client().admin()
            equalTo(0L)
        assertThat(scriptedMetric, notNullValue());
            Files.write(scripts.resolve("combine_script.mockscript"), "sum state values as a new aggregation".getBytes("UTF-8"));
        assertThat(
                .indices()
            // sum += s
    }
            equalTo(0L)
            //
            .setQuery(matchAllQuery())
        indexRandom(true, builders);
        SearchResponse searchResponse = client().prepareSearch("idx")
                // A particular shard may not have any documents stored on it so
                .setRequestCache(true)
            Collections.emptyMap()
        params.put("vars", varsMap);
        assertSearchResponse(response);
        try {
        assertThat(object, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
            client().admin()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        // Test that all deterministic scripts cause the request to be cached
                totalCount += numberValue.longValue();
        // will be numShards * slicesCount
            .setQuery(matchAllQuery())
            // Equivalent to:
        );
            .addAggregation(scriptedMetric("foo").mapScript(mapScript).combineScript(ndRandom).reduceScript(reduceScript))
            .get();
            scripts.put("multiplied sum all states (lists) values as a new aggregation", vars -> {
    }
        // will be numShards * slicesCount
                List newAggregation = new ArrayList();
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                assertThat(map.get("count"), notNullValue());
        assertSearchResponse(r);
                return newAggregation;
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
            Aggregations subAggs = b.getAggregations();
        Script combineScript = new Script(
    }
                global("global").subAggregation(
        long totalCount = 0;
        params.put("vars", varsMap);
        assertThat(object, instanceOf(Number.class));
        Aggregation aggregation = response.getAggregations().get("scripted");
    }
                .prepareStats("cache_test_idx")
            );
        Map<String, Object> varsMap = new HashMap<>();
        );
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
        assertThat(object, instanceOf(Number.class));
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
 * KIND, either express or implied.  See the License for the
                scriptedMetric("foo").initScript(ndInitScript).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
 * Modifications Copyright OpenSearch Contributors. See
            "sum all states (lists) values as a new aggregation",
        Aggregation aggregation = response.getAggregations().get("scripted");
import org.opensearch.action.search.SearchResponse;
                totalCount += numberValue.longValue();
                    for (Object s : list) {
                if (state.containsKey("list") == false) {
        );
            equalTo(1L)
        Aggregation aggregation = response.getAggregations().get("scripted");
        assertThat(aggregationList.size(), equalTo(1));
        Script combineScript = new Script(
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
                .get()
            ScriptType.INLINE,
        assertThat(((Number) object).longValue(), equalTo(numDocs));
        assertThat(scriptedMetric.getName(), equalTo("scripted"));
                        }
                Integer sum = 0;
        assertThat(aggregation, notNullValue());
                    .reduceScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap()))
            client().admin()
        indexRandom(true, builders);
import java.io.IOException;
                Number numberValue = (Number) o;
            .setQuery(matchAllQuery())
                .setRequestCache(true)
                .getRequestCache()
            );
            "sum all states (lists) values as a new aggregation",
                    .reduceScript(new Script(ScriptType.STORED, null, "reduceScript_stored", Collections.emptyMap()))
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state[param1] = param2", scriptParams);
        assertThat(
        assertThat(
        @SuppressWarnings("unchecked")
            ScriptType.INLINE,
                Integer sum = 0;
            ScriptType.INLINE,
        assertThat(aggregationResult.size(), equalTo(1));
        );
                if (states == null) {
            }
        );
        List<IndexRequestBuilder> builders = new ArrayList<>();
                vars -> aggScript(
            ScriptType.INLINE,
        assertAcked(
            Map<String, Object> map = (Map<String, Object>) object;
                .getRequestCache()
import java.util.ArrayList;
                )
import org.opensearch.search.aggregations.bucket.global.Global;
        );
                            .initScript(initScript)
            assertThat(aggregationList.size(), equalTo(1));
        assertThat(((Number) object).longValue(), equalTo(numDocs * 3));
                .getHitCount(),
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
        params.put("vars", varsMap);
                // bottom of the test method will make sure the count is correct
                assertThat(map.get("count"), instanceOf(Number.class));
        assertSearchResponse(r);
            }
                for (List<?> list : states) {
        Map<String, Object> params = new HashMap<>();
                    .mapScript(mapScript)
            assertThat(((Number) object).longValue(), equalTo(3L));
        Map<String, Object> params = Collections.singletonMap("param1", "12");
            ScriptType.INLINE,
        return Collections.singleton(CustomScriptPlugin.class);
    }
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        reduceParams.put("multiplier", 4);
            ScriptType.INLINE,
            .setSize(0)
        Script combineScript = new Script(
            client().admin()
    }
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
        assertThat(
            )
        @SuppressWarnings("unchecked") // We'll just get a ClassCastException a couple lines down if we're wrong, its ok.
        Aggregation aggregation = response.getAggregations().get("scripted");
            CustomScriptPlugin.NAME,
                .cluster()
import static org.hamcrest.Matchers.equalTo;
        assertThat(object, instanceOf(Number.class));
            Collections.emptyMap()
        assertThat(
        Script combineScript = new Script(
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        assertThat(aggregation, notNullValue());
    private Path config;
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
        Histogram histo = searchResponse.getAggregations().get("histo");
            for (Object o : list) {
        );
            assertThat(object, notNullValue());
                .setContent(
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // Test that a non-deterministic init script causes the result to not be cached
    public ScriptedMetricIT(Settings staticSettings) {
            )
        Aggregation aggregation = response.getAggregations().get("scripted");
                assertThat(entry.getKey(), notNullValue());
                    ),
            "sum state values as a new aggregation",
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public void testInitMapCombineWithParams() {
            "sum all states (lists) values as a new aggregation",
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            ScriptType.INLINE,
 * under the License.
            List<?> list = (List<?>) object;
 * GitHub history for details.
    }
                    if (list != null) {
                .getTotal()
 * Licensed to Elasticsearch under one or more contributor
package org.opensearch.search.aggregations.metrics;
            scripts.put("no-op list aggregation", vars -> { return (List<List<?>>) vars.get("states"); });
                .indices()
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
    @Override
                .setRequestCache(true)
@OpenSearchIntegTestCase.SuiteScopeTestCase
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
                    newAggregation.add(sum);
        assertThat(aggregationResult.get(0), equalTo(0));
    public void setupSuiteScopeCluster() throws Exception {
            )
        Map<String, Object> params = new HashMap<>();
                    MediaTypeRegistry.JSON
        Map<String, Object> params = new HashMap<>();
        assertThat(global.getAggregations(), notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
                    return newAggregation;
                .prepareStats("cache_test_idx")
            );
            CustomScriptPlugin.NAME,
                Number numberValue = (Number) entry.getValue();
            "state.list.add(vars.multiplier)",
                .getTotal()
        r = client().prepareSearch("cache_test_idx")
            .get();
        SearchResponse response = client().prepareSearch("idx")
            // }
                Map<String, Object> state = (Map<String, Object>) vars.get("state");
import org.opensearch.search.aggregations.InternalAggregation;
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        Script reduceScript = new Script(
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state.list.add(1)", Collections.emptyMap());
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
                            sum += ((Number) s).intValue();
        Script ndMapScript = new Script(
                        jsonBuilder().startObject().field("value", randomAlphaOfLengthBetween(5, 15)).field("l_value", i).endObject()
                .prepareStats("cache_test_idx")
        for (Object object : aggregationList) {
import static org.hamcrest.Matchers.sameInstance;
        );
        );
            .addAggregation(
        // Test that a non-deterministic map script causes the result to not be cached
                        "{\"script\": {\"lang\": \"" + MockScriptPlugin.NAME + "\"," + " \"source\": \"vars.multiplier = 3\"} }"
        assertSearchResponse(response);
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        assertThat((List) ((InternalAggregation) scriptedMetricAggregation).getProperty("value"), sameInstance((List) aggregationList));
        Map<String, Object> varsMap = new HashMap<>();
    @Before
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));
        varsMap.put("multiplier", 1);
        varsMap.put("multiplier", 1);
            //
            "sum state values as a new aggregation",
    public void testEmptyAggregation() throws Exception {
                newAggregation.add(sum * multiplier);
        );
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                        .initScript(initScript)
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
            return aggState;
            assertThat(subAgg, notNullValue());
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
            .setSize(0)
                    .mapScript(mapScript)
        assertThat(buckets, notNullValue());
            // the name of the file script is used in test method while the source of the file script
                    MediaTypeRegistry.JSON
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
        r = client().prepareSearch("cache_test_idx")
