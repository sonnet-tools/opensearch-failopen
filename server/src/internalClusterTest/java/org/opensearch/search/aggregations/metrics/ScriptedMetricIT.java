        );
            // newaggregation = [];  
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));  
import org.junit.Before;
        // Make sure we are starting with a clear cache
import org.opensearch.action.index.IndexRequestBuilder;  
            "state.list.add(vars.multiplier)",
        assertAcked(  
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(numDocs));
                .getTotal()
    public ScriptedMetricIT(Settings staticSettings) {
                List<?> list = (List<?>) state.get("list");  
                        XContentMapValues.extractValue("params.param2", vars)
                .setRequestCache(true)
import static org.hamcrest.Matchers.allOf;  
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();  
            client().admin()
        assertThat(
                scriptedMetric("scripted").params(params).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
        Script reduceScript = new Script(
            Collections.emptyMap()  
            //  
            "sum state values as a new aggregation",
            scripts.put("sum state values as a new aggregation", vars -> {  
        assertThat(((Number) object).longValue(), equalTo(numDocs * 3));
import java.nio.file.Path;
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));  
        params.put("vars", varsMap);
                        .initScript(initScript)
        );  
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));  
                        }  
            equalTo(0L)  
            // sum = 0;
                    .reduceScript(reduceScript)
        Map<String, Object> varsMap = new HashMap<>();
        );
            for (Object o : list) {
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
                    MediaTypeRegistry.JSON  
                }
        // sure that at least one shard ran the map script  
                    .combineScript(combineScript)
            .setQuery(matchAllQuery())
        assertSearchResponse(r);
    }
            CustomScriptPlugin.NAME,
                .prepareStats("cache_test_idx")
            .get();
        assertThat(histoAgg.getName(), equalTo("histo"));  
        );
                            + " \"source\": \"sum all states (lists) values as a new aggregation\"} }"
    }
                    )
                .setId("mapScript_stored")
                    new BytesArray(  
            .setQuery(matchAllQuery())  
                .indices()  
        assertSearchResponse(r);
import org.opensearch.script.ScriptType;
        assertThat(scriptedMetric.aggregation(), instanceOf(List.class));  
        }
                "state['count'] = Math.random() >= 0.5 ? 1 : 0",
        for (Object object : aggregationList) {
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
                .indices()
    @Override  
            .setSize(0)
                .getMissCount(),  
        );  
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
            )
        );
                    MediaTypeRegistry.JSON  
                .getTotal()  
    public static class CustomScriptPlugin extends MockScriptPlugin {
        assertThat(
            // When using the MockScriptPlugin we can map File scripts to inline scripts:  
            assertThat(object, instanceOf(List.class));  
        Script ndMapScript = new Script(
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
        varsMap.put("multiplier", 1);
                    )
            assertThat(object, notNullValue());
                .indices()  
            CustomScriptPlugin.NAME,
        assertThat((List) ((InternalAggregation) scriptedMetricAggregation).getProperty("value"), sameInstance((List) aggregationList));  
            ScriptType.INLINE,  
            .get();  
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());  
        );
    }
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
                scriptedMetric("scripted").params(params)  
    public void testInitMapCombineWithParams() {
                scriptedMetric("scripted").params(params)
                state.put("list", new ArrayList());
                )
            "state['count'] = Math.random() >= 0.5 ? 1 : 0",
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        assertThat(object, notNullValue());
            ScriptType.INLINE,
        );
            scripts.put("sum all states (lists) values as a new aggregation", vars -> {  
            client().admin()
                scriptedMetric("scripted").params(params)  
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));  
        Script reduceScript = new Script(
            "state.list.add(vars.multiplier)",
                    for (Object s : list) {
        // with script based aggregation, if it does not support reduce then aggregationList size  
        Aggregation aggregation = response.getAggregations().get("scripted");
            ScriptType.INLINE,  
        assertThat(aggregationList.size(), equalTo(1));  
                scriptedMetric("scripted").params(params).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
        assertThat(aggregation, instanceOf(Histogram.class));
        Map<String, Object> params = new HashMap<>();  
                client().prepareIndex("idx")  
            .addAggregation(scriptedMetric("foo").mapScript(mapScript).combineScript(combineScript).reduceScript(ndRandom))  
 * The OpenSearch Contributors require contributions made to  
                .getTotal()
        );
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());  
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
    public void testScriptCaching() throws Exception {
                String stringValue = (String) entry.getKey();
        params.put("vars", varsMap);
        assertAcked(  
        SearchResponse response = client().prepareSearch("idx")
            return scripts;
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));  
            .addAggregation(  
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
        numDocs = randomIntBetween(10, 100);  
        assertThat(aggregationResult.get(0), equalTo(0));
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
    }
        reduceParams.put("multiplier", 4);
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                .getRequestCache()
            // Equivalent to:  
        }
                Map<String, Object> state = (Map<String, Object>) vars.get("state");
        assertThat(scriptedMetricAggregation, notNullValue());  
            Map<String, Object> aggState = (Map<String, Object>) vars.get("state");  
            "sum state values as a new aggregation",
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
import static org.hamcrest.Matchers.hasKey;
            // Equivalent to:
            fn.accept(aggState);
            //
                    .combineScript(combineScript)  
                assertThat(map.get("count"), instanceOf(Number.class));  
            Collections.emptyMap()
    public static Collection<Object[]> parameters() {
            CustomScriptPlugin.NAME,
        assertThat(object, notNullValue());
        );
        Map<String, Object> params = new HashMap<>();
import org.opensearch.search.aggregations.bucket.histogram.Histogram.Bucket;
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        );
        );
import static org.hamcrest.Matchers.equalTo;
                assertThat(numberValue.longValue(), allOf(greaterThanOrEqualTo(0L), lessThanOrEqualTo(numDocs)));
                .get()
        Script mapScript = new Script(  
        assertThat(aggregationList.size(), equalTo(1));
            assertThat(subAggs, notNullValue());
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
            // sum += s  
                .getMissCount(),
            CustomScriptPlugin.NAME,
        assertThat(aggregationList.size(), equalTo(1));  
        );
        );
        }
                scriptedMetric("foo").initScript(ndInitScript).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
                // we have to assume the lower bound may be 0. The check at the
                "sum all states (lists) values as a new aggregation".getBytes("UTF-8")
            .get();
            Collections.emptyMap()
            ScriptType.INLINE,  
                .indices()
        // NOTE: random reduce scripts don't hit the query shard context (they are done on the coordinator) and so can be cached.  
                .get()  
            scripts.put("state.data = Math.random()", vars -> aggScript(vars, state -> state.put("data", ScriptedMetricIT.randomDouble())));
            .setQuery(matchAllQuery())  
        Histogram.Bucket bucket = histo.getBuckets().get(1);
public class ScriptedMetricIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                    .initScript(initScript)
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;  
            Collections.emptyMap()
            .addAggregation(
import org.opensearch.action.search.SearchResponse;  
            assertThat(subAgg, notNullValue());
        assertThat(aggregation, instanceOf(ScriptedMetric.class));  
        // will be numShards * slicesCount
            .addAggregation(
        super(staticSettings);  
                }
            "state.list.add(vars.multiplier)",
                assertThat(entry, notNullValue());  
            // for (s in state.list) {
                .getTotal()
                return state;  
        Script reduceScript = new Script(  
                    .setId("" + i)
                .prepareStats("cache_test_idx")
            scripts.put("no-op aggregation", vars -> { return (Map<String, Object>) vars.get("state"); });  
        @SuppressWarnings("unchecked") // We'll just get a ClassCastException a couple lines down if we're wrong, its ok.
                .indices()
                assertThat(numberValue, equalTo((Number) 1));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .get();
                    .mapScript(mapScript)
                scriptedMetric("scripted").params(params).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)
            .setQuery(matchAllQuery())
    @Before
        assertThat(
            equalTo(0L)
                .getTotal()
            assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));  
            .setQuery(matchAllQuery())
        // works is by indexing
        SearchPhaseExecutionException ex = expectThrows(SearchPhaseExecutionException.class, builder::get);
        assertThat(totalCount, equalTo(numDocs));
                            + MockScriptPlugin.NAME
                scriptedMetric("scripted").params(params)
            .addAggregation(  
                            sum += ((Number) s).intValue();  
                .getTotal()  
        );
        assertAcked(
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .get();
            CustomScriptPlugin.NAME,  
            CustomScriptPlugin.NAME,  
                .getTotal()
            client().admin()
            ScriptType.INLINE,
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
 * not use this file except in compliance with the License.
            .addAggregation(
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
        params.put("vars", varsMap);  
                .indices()
                )  
        assertThat(aggregation, instanceOf(ScriptedMetric.class));  
            assertThat(map.get("list"), instanceOf(List.class));  
                .get()  
        Histogram histoAgg = (Histogram) aggregation;
        SearchResponse response = client().prepareSearch("idx")
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
            .get();
        assertThat(  
                return newAggregation;  
        params.put("vars", varsMap);
 * KIND, either express or implied.  See the License for the
                .preparePutStoredScript()  
        assertThat(buckets, notNullValue());
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));  
                // bottom of the test method will make sure the count is correct  
            .setQuery(matchAllQuery())
        params.put("vars", varsMap);  
            .setQuery(matchAllQuery())
                numShardsRun++;
        );  
                totalCount += numberValue.longValue();
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
        Map<String, Object> params = new HashMap<>();
                scriptedMetric("scripted").params(params).mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript)  
            });  
            List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
                    .interval(1L)
        Map<String, Object> varsMap = new HashMap<>();  
                    .reduceScript(reduceScript)
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
    /**
        assertThat(aggregationResult.size(), equalTo(1));  
        assertThat((List) ((InternalAggregation) global).getProperty("scripted.value"), sameInstance((List) aggregationList));
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
            )
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
        for (Bucket b : buckets) {  
    private Path config;
            scripts.put(
                Integer sum = 0;
            CustomScriptPlugin.NAME,
                .get()  
        // with interval 1 and with empty  
        Script mapScript = new Script(
                .preparePutStoredScript()
                "state[param1] = param2",
        assertThat(aggregation, notNullValue());
            client().admin()
                // Lazily populate state.list for tests without an init script
        internalCluster().wipeIndices("cache_test_idx");
        Aggregation aggregation = response.getAggregations().get("scripted");  
            CustomScriptPlugin.NAME,
import org.opensearch.script.Script;
    }
                .setRequestCache(true)  
        }  
            ScriptType.INLINE,
        assertThat(object, notNullValue());
    }  
        );
        Script combineScript = new Script(  
                    .reduceScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap()))
            .addAggregation(
import static org.hamcrest.Matchers.containsString;
                .getTotal()
            assertThat(object, notNullValue());
        Map<String, Object> varsMap = new HashMap<>();  
        assertThat(global, notNullValue());
        varsMap.put("multiplier", 1);  
            Collections.emptyMap()  
                assertThat(o, instanceOf(Number.class));
                .getHitCount(),  
            )
        Script mapScript = new Script(
        assertSearchResponse(response);
            //
            scripts.put("state['count'] = 1", vars -> aggScript(vars, state -> state.put("count", 1)));
            .addAggregation(scriptedMetric("foo").mapScript(ndMapScript).combineScript(combineScript).reduceScript(reduceScript))  
                        .reduceScript(reduceScript)
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            .get();
                .setRequestCache(true)
            ScriptType.INLINE,  
            for (Object o : list) {  
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
/*  
        assertThat(
            )  
            });
        Script ndRandom = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "return Math.random()", Collections.emptyMap());  
                scriptedMetric("scripted").params(aggregationParams)
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        );
                .prepareStats("cache_test_idx")
                }  
                .setRequestCache(true)
        assertThat(aggregation, instanceOf(ScriptedMetric.class));  
    public void testInitMapCombineReduceWithParamsStored() {
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            assertThat(aggregationList.size(), equalTo(1));
            // for (state in states) {
    }
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());  
                Number numberValue = (Number) o;
import org.opensearch.core.common.bytes.BytesArray;  
        assertAcked(
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
            scripts.put("state.list.add(vars.multiplier)", vars -> aggScript(vars, state -> {  
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
            }  
            // for (s in state) {
        Map<String, Object> varsMap = new HashMap<>();
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            ScriptType.INLINE,  
                assertThat(numberValue, equalTo((Number) 3));  
                    .initScript(initScript)
                    .initScript(initScript)
            List<?> list = (List<?>) map.get("list");
    private static long numDocs;  
                .setRequestCache(true)
        Map<String, Object> params = new HashMap<>();
            // for (state in states) {  
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
            return scripts;  
        // buckets computed.. the empty bucket is the one associated with key
            "sum state values as a new aggregation",
            ScriptType.INLINE,
        assertThat(aggregation, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
        int numShardsRun = 0;
        Script combineScript = new Script(  
        params.put("vars", varsMap);
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
            Files.write(scripts.resolve("init_script.mockscript"), "vars.multiplier = 3".getBytes("UTF-8"));  
                // bottom of the test method will make sure the count is correct
                .get()  
        Object object = aggregationList.get(0);
        assertThat(aggregation, notNullValue());  
 * specific language governing permissions and limitations
                .getHitCount(),  
            Collections.emptyMap()
            )
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));  
        assertSearchResponse(response);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat(aggregation, instanceOf(ScriptedMetric.class));  
                .setId("initScript_stored")
                .get()  
        SearchResponse r = client().prepareSearch("cache_test_idx")
            client().admin()
                .getRequestCache()
            scripts.put("sum all states' state.list values as a new aggregation", vars -> {
import java.util.Map;  
        ensureSearchable();
            .addAggregation(
                .indices()  
            }));
        SearchResponse response = client().prepareSearch("idx")  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
            .addAggregation(
                .getRequestCache()
        int numShardsRun = 0;  
        Aggregation aggregation = response.getAggregations().get("histo");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                        .mapScript(mapScript)  
 */  
            assertThat(object, instanceOf(Number.class));
                .setRequestCache(true)
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        // Test that a non-deterministic init script causes the result to not be cached
        Map<String, Object> varsMap = new HashMap<>();
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));  
 *
                    ),
                .prepareStats("cache_test_idx")  
 *
            CustomScriptPlugin.NAME,  
            .addAggregation(
        indexRandom(true, builders);
        varsMap.put("multiplier", 1);
    public void testMapWithParams() {
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            equalTo(0L)
        Map<String, Object> reduceParams = new HashMap<>();
                assertThat(entry.getKey(), notNullValue());
            ScriptType.INLINE,
            Collections.emptyMap()  
        // with script based aggregation, if it does not support reduce then aggregationList size
                            + "\","  
        assertThat(numShardsRun, greaterThan(0));  
                        "{\"script\": {\"lang\": \""
            ScriptType.INLINE,  
        );  
            //
        // two docs {value: 0} and {value : 2}, then building a histogram agg
            "multiplied sum all states (lists) values as a new aggregation",
            //
        // must match a predefined script from CustomScriptPlugin.pluginScripts() method
            assertThat(subAggs.asList().size(), equalTo(1));
                .getHitCount(),  
        assertThat(object, notNullValue());  
                    .mapScript(mapScript)
                            + " \"source\": \"sum state values as a new aggregation\"} }"  
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        );
            CustomScriptPlugin.NAME,
        );
            equalTo(0L)
                .setContent(
        assertSearchResponse(r);
        );
        static Map<String, Object> aggScript(Map<String, Object> vars, Consumer<Map<String, Object>> fn) {
        assertThat(numShardsRun, greaterThan(0));
/*
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
                    .initScript(initScript)
            assertThat(object, instanceOf(Map.class));  
            scripts.put("state.list.add(1)", vars -> aggScript(vars, state -> {
            )
            Aggregations subAggs = b.getAggregations();  
 * software distributed under the License is distributed on an
                scriptedMetric("scripted").params(params)
                    .mapScript(  
            assertThat(object, notNullValue());  
            for (Map.Entry<?, ?> entry : map.entrySet()) {
        assertThat(aggregation, notNullValue());
        Map<String, Object> varsMap = new HashMap<>();
                scriptedMetric("scripted").params(params)  
    }
        // with script based aggregation, if it does not support reduce then aggregationList size  
        Aggregation aggregation = response.getAggregations().get("scripted");
        for (Object object : aggregationList) {
            Files.write(scripts.resolve("map_script.mockscript"), "state.list.add(vars.multiplier)".getBytes("UTF-8"));
            "sum all states' state.list values as a new aggregation",
        for (Object object : aggregationList) {
        assertSearchResponse(response);  
                .setContent(
     */  
        assertSearchResponse(searchResponse);
            .get();
            "state.list.add(vars.multiplier)",
                    ),
            client().admin()
        // creating an index to test the empty buckets functionality. The way it  
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());  
                    .combineScript(combineScript)  
        assertThat(object, instanceOf(Number.class));  
        );
        r = client().prepareSearch("cache_test_idx")
                Number numberValue = (Number) o;  
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(((Number) object).longValue(), equalTo(numDocs * 12));
            assertThat(b.getDocCount(), equalTo(1L));
            assertThat(object, instanceOf(Map.class));
            builders.add(
        assertThat(scriptedMetric.aggregation(), notNullValue());
            equalTo(1L)  
        assertThat(((Number) object).longValue(), equalTo(numDocs * 3));  
        Script reduceScript = new Script(
            .get();  
        // the id of the stored script is used in test method while the source of the stored script
        Script combineScript = new Script(  
            CustomScriptPlugin.NAME,  
                    .reduceScript(new Script(ScriptType.STORED, null, "reduceScript_stored", Collections.emptyMap()))  
        SearchResponse response = client().prepareSearch("idx")
                ((List) state.get("list")).add(XContentMapValues.extractValue("vars.multiplier", vars));  
            Map<?, ?> map = (Map<?, ?>) object;
        assertThat(global.getAggregations().asMap().size(), equalTo(1));  
        SearchResponse response = client().prepareSearch("idx")
            CustomScriptPlugin.NAME,  
            // for (s in state) {
            }  
    public void testInitMapCombineReduceWithParams() {
        Script reduceScript = new Script(
                    .initScript(new Script(ScriptType.STORED, null, "initScript_stored", Collections.emptyMap()))  
        SearchResponse response = client().prepareSearch("idx")
                        new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state.list.add(vars.multiplier)", Collections.emptyMap())
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
        assertThat(aggregation, notNullValue());
        );
            )  
        Aggregation aggregation = response.getAggregations().get("scripted");
        assertThat(((Number) object).longValue(), equalTo(numDocs * 3));
        params.put("vars", varsMap);
                            .combineScript(combineScript)
            // sum += s
        Object object = aggregationList.get(0);  
            .setQuery(matchAllQuery())
        Map<String, Object> params = new HashMap<>();
                .getTotal()  
        SearchResponse searchResponse = client().prepareSearch("idx")  
                .getRequestCache()
import org.opensearch.search.aggregations.Aggregation;  
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
        assertSearchResponse(response);
        }
    protected Path nodeConfigPath(int nodeOrdinal) {
        for (int i = 0; i < numDocs; i++) {
                .indices()  
        }
            Collections.emptyMap()
        );
        r = client().prepareSearch("cache_test_idx")
        varsMap.put("multiplier", 1);
                .prepareStats("cache_test_idx")
        assertThat(searchResponse.getHits().getTotalHits().value(), equalTo(2L));
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state.list.add(1)", Collections.emptyMap());
    public void testInitMapCombineReduceWithParamsAsSubAgg() {  
        Script mapScript = new Script(
                    .reduceScript(reduceScript)
        assertThat(object, instanceOf(Number.class));
        );  
        Script reduceScript = new Script(
                .get()
            }
        Aggregation aggregation = response.getAggregations().get("scripted");  
        assertThat(aggregation, notNullValue());
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));  
            reduceParams  
    public void testMapReduceWithParams() {
        }  
                totalCount += numberValue.longValue();
            CustomScriptPlugin.NAME,
        assertSearchResponse(response);  
            Files.write(  
            .setQuery(matchAllQuery())
        Map<String, Object> varsMap = new HashMap<>();
                    state -> state.put(
        varsMap.put("multiplier", 1);
import static org.hamcrest.Matchers.greaterThan;  
        Map<String, Object> params = new HashMap<>();
        assertThat(  
import org.opensearch.search.aggregations.Aggregations;
            // sum += s  
                .getRequestCache()
                return newAggregation;  
                Integer multiplier = (Integer) vars.get("multiplier");
                vars -> aggScript(vars, state -> state.put("count", ScriptedMetricIT.randomDouble() >= 0.5 ? 1 : 0))
        assertThat(((Number) object).longValue(), equalTo(numDocs * 3));  
            .addAggregation(  
                        }
            // sum = 0;
            ScriptType.INLINE,
            .get();
                for (Map<String, Object> state : states) {
                    newAggregation.add(sum);
                .setContent(  
        // with script based aggregation, if it does not support reduce then aggregationList size
                    state.put("list", new ArrayList());
                            .mapScript(mapScript)  
    }
                        .combineScript(combineScript)
        assertThat(((Number) object).longValue(), equalTo(numDocs));
        assertSearchResponse(response);  
        assertThat(aggregation, notNullValue());  
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
        }  
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
                .getMissCount(),
            assertThat(object, instanceOf(HashMap.class));  
            assertThat(object, instanceOf(List.class));
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
            ScriptType.INLINE,
                }
                newAggregation.add(sum);
        assertThat(object, notNullValue());
        @Override  
            Collections.emptyMap()  
            "state.list.add(vars.multiplier)",
        assertThat(scriptedMetric.getName(), equalTo("scripted"));
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));  
                assertThat(o, notNullValue());
                List newAggregation = new ArrayList();  
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
        // will be numShards * slicesCount
                    return newAggregation;
            // newaggregation.add(sum);  
                Map<String, Object> state = (Map<String, Object>) vars.get("state");  
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
    }
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));
import java.util.List;
        );  
                .getHitCount(),  
                    new BytesArray(  
                assertThat(o, instanceOf(Number.class));
        Map<String, Object> varsMap = new HashMap<>();
        builders = new ArrayList<>();  
            "sum all states (lists) values as a new aggregation",
        Map<String, Object> params = new HashMap<>();
        assertSearchResponse(response);
        assertThat(aggregationList.size(), equalTo(1));
            scripts.put("return Math.random()", vars -> ScriptedMetricIT.randomDouble());
                .getMissCount(),
                    }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            equalTo(0L)  
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());  
    }  
                }  
        assertThat(global.getDocCount(), equalTo(numDocs));
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();  
            "state.list.add(vars.multiplier)",  
    public void testInitMapCombineReduceGetProperty() throws Exception {  
            client().admin()
            .setSize(0)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertThat(map.size(), lessThanOrEqualTo(1));  
import java.util.HashMap;
                if (states == null) {
                List newAggregation = new ArrayList();
        final Path scripts = config.resolve("scripts");
        r = client().prepareSearch("cache_test_idx")
                .indices()
            // };
            "sum state values as a new aggregation",
                .cluster()
import java.nio.file.Files;
                .prepareStats("cache_test_idx")
        for (Object object : aggregationList) {
        // will be numShards * slicesCount
        Script combineScript = new Script(
            .get();  
        config = createTempDir().resolve("config");
            prepareCreate("cache_test_idx").setMapping("d", "type=long")  
            // sum = 0;  
        );
            equalTo(0L)
                assertThat(map.get("count"), equalTo((Number) 1));
        indexRandom(
                assertThat(map.get("count"), notNullValue());
                .getRequestCache()
                }
 *  
                )
        long totalCount = 0;  
                .setRequestCache(true)
                .indices()  
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());  
                .setId("combineScript_stored")  
import org.opensearch.script.MockScriptPlugin;  
                .setRequestCache(true)
                .getTotal()  
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));  
                            .reduceScript(reduceScript)
                    .mapScript(mapScript)
        ScriptedMetric scriptedMetric = bucket.getAggregations().get("scripted");
                if (state.containsKey("list") == false) {  
                    state.put("list", new ArrayList());  
        Map<String, Object> varsMap = new HashMap<>();
            client().admin()
            );
        assertThat(  
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
                List<List<?>> states = (List<List<?>>) vars.get("states");  
                    .setId("" + i)
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
        // "1". then each test will have
 */
        params.put("vars", varsMap);
 * compatible open source license.
                .get()
        );
            "sum state values as a new aggregation",
        return config;
        // will be numShards * slicesCount
            client().admin()
        Object object = aggregationList.get(0);
    }
        );  
            client().admin()
    public void testInitMutatesParams() {  
        Map<String, Object> params = new HashMap<>();
                    if (list != null) {
                .getTotal()
            "sum all states' state.list values as a new aggregation",
                .prepareStats("cache_test_idx")
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
            );  
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();  
        assertThat(
            scripts.put("vars.multiplier = 3", vars -> {  
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
                numShardsRun++;  
            .get();  
            Object object = aggregationList.get(0);  
                .prepareStats("cache_test_idx")  
        Object object = aggregationList.get(0);  
            ScriptType.INLINE,  
        assertAcked(
            ScriptType.INLINE,  
        assertThat(aggregationList.size(), equalTo(1));
                return newAggregation;
        // with script based aggregation, if it does not support reduce then aggregationList size  
            Map<String, Object> map = (Map<String, Object>) object;
            ScriptType.INLINE,
import java.util.Collection;
            CustomScriptPlugin.NAME,  
        long totalCount = 0;  
        }
     * Make sure that a request using a deterministic script gets cached and nondeterministic scripts do not get cached.
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());  
        // Split the params up between the script and the aggregation.
            equalTo(2L)  
        );
            scripts.put("no-op list aggregation", vars -> { return (List<List<?>>) vars.get("states"); });
        );
import java.io.IOException;  
                .setId("reduceScript_stored")
            )  
import java.util.ArrayList;  
import static org.hamcrest.Matchers.sameInstance;  
                .cluster()
            ScriptType.INLINE,  
            ScriptType.INLINE,  
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),  
            );  
        // aggregations.
                .setContent(
        assertSearchResponse(response);
        params.put("vars", varsMap);
        assertThat(aggregation, notNullValue());
            "state.list.add(vars.multiplier)",
    public void testMapCombineReduceWithParams() {  
import java.util.function.Consumer;
            client().admin()  
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
                        "{\"script\": {\"lang\": \"" + MockScriptPlugin.NAME + "\"," + " \"source\": \"vars.multiplier = 3\"} }"
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
        assertThat(aggregation, notNullValue());  
                    if (list != null) {
                .getRequestCache()
        Aggregation aggregation = response.getAggregations().get("scripted");
package org.opensearch.search.aggregations.metrics;
        assertThat(((Number) object).longValue(), equalTo(numDocs));  
        Global global = searchResponse.getAggregations().get("global");
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        varsMap.put("multiplier", 1);
                .indices()  
    @ParametersFactory  
            ScriptType.INLINE,  
                )  
                newAggregation.add(sum);  
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
            scripts.put(  
                Integer sum = 0;  
            CustomScriptPlugin.NAME,
                    .combineScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap()))  
import static org.opensearch.search.aggregations.AggregationBuilders.scriptedMetric;  
            )
        assertThat(aggregation, instanceOf(ScriptedMetric.class));
            CustomScriptPlugin.NAME,
        return Collections.singleton(CustomScriptPlugin.class);
                .get()  
        );
    }  
        SearchResponse searchResponse = client().prepareSearch("empty_bucket_idx")
                            .mapScript(mapScript)
        @SuppressWarnings("unchecked")
        assertSearchResponse(response);
        varsMap.put("multiplier", 1);  
        Object object = aggregationList.get(0);
        // will be numShards * slicesCount
            });
        params.put("vars", varsMap);  
                        scriptedMetric("scripted").params(params)
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
                    }  
            Collections.emptyMap()
            Aggregation subAgg = subAggs.get("scripted");  
            return aggState;
                .getRequestCache()
    }
    public void testInitMapReduceWithParams() {
                Number numberValue = (Number) o;
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;  
        Map<String, Object> params = new HashMap<>();
            //
                .getRequestCache()
            assertThat(((Number) object).longValue(), equalTo(3L));  
 * You may obtain a copy of the License at  
            .setQuery(matchAllQuery())
                    .mapScript(mapScript)
        assertThat(object, notNullValue());
            client().admin()  
            // newaggregation.add(sum * multiplier);
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
            assertThat(b, notNullValue());
            //  
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state['count'] = 1", Collections.emptyMap());  
        assertThat(histo, notNullValue());
            .setQuery(matchAllQuery())
    }  
            .setSize(0)
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));
        assertThat(  
    }
        SearchResponse response = client().prepareSearch("idx")
        for (int i = 0; i < 2; i++) {
            assertThat(object, notNullValue());  
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
        // When using the MockScriptPlugin we can map Stored scripts to inline scripts:  
        } catch (IOException e) {
            // newaggregation = [];
        // We don't know how many shards will have documents but we need to make
        Script reduceScript = new Script(
        ScriptedMetric scriptedMetricAggregation = global.getAggregations().get("scripted");
            assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
            )
    public void setupSuiteScopeCluster() throws Exception {
        assertThat(aggregation, notNullValue());  
}
        assertThat(object, instanceOf(Number.class));
    }
            }));
                    MediaTypeRegistry.JSON
            Collections.emptyMap()
                )  
            ScriptType.INLINE,
        assertThat(
                    }
                    vars,
        SearchResponse response = client().prepareSearch("idx")
                )
            });
        assertThat(  
        varsMap.put("multiplier", 1);
            )
                vars -> aggScript(  
        assertThat(object, instanceOf(Number.class));  
            .setSize(0)  
        Object object = aggregationList.get(0);
            .setQuery(matchAllQuery())
                            sum += ((Number) s).intValue();
            .addAggregation(scriptedMetric("foo").mapScript(mapScript).combineScript(ndRandom).reduceScript(reduceScript))  
                .getRequestCache()
        super.setUp();  
        Aggregation aggregation = response.getAggregations().get("scripted");
            //  
import org.opensearch.common.xcontent.support.XContentMapValues;
            // return newaggregation"
                            .combineScript(combineScript)
            .setSize(0)
            CustomScriptPlugin.NAME,
 * Licensed to Elasticsearch under one or more contributor  
                histogram("histo").field("value")
                            .initScript(initScript)  
            CustomScriptPlugin.NAME,
                            + "\","
                    .reduceScript(reduceScript)
        List<? extends Bucket> buckets = histoAgg.getBuckets();
        assertThat(object, instanceOf(Number.class));
 * this work for additional information regarding copyright
        Aggregation aggregation = response.getAggregations().get("scripted");
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
    @Override  
        assertThat(totalCount, equalTo(numDocs * 3));
            Files.createDirectories(scripts);
                .getHitCount(),
            "sum state values as a new aggregation",  
            equalTo(0L)
            equalTo(0L)  
            Collections.emptyMap()
        assertSearchResponse(response);
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        Histogram histo = searchResponse.getAggregations().get("histo");  
            client().admin()
            .addAggregation(  
        );
        assertThat(
            .addAggregation(  
                .setRequestCache(true)
        assertThat(aggregationList.size(), equalTo(1));
            // };
        );
                scripts.resolve("reduce_script.mockscript"),
                    )  
    }
            "sum state values as a new aggregation",  
        assertThat(object, instanceOf(Number.class));
            Collections.emptyMap()
        assertSearchResponse(response);
 */  
                if (list != null) {
        varsMap.put("multiplier", 1);
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
            // newaggregation.add(sum);  
                .getMissCount(),
                    }  
        assertThat(object, instanceOf(Number.class));
                    .interval(1)
            for (Object o : list) {
        Script combineScript = new Script(
    public void testEmptyAggregation() throws Exception {
        assertThat(ex.getCause().getMessage(), containsString("Parameter name \"param1\" used in both aggregation and script parameters"));  
            Collections.emptyMap()
                .get()
            )
@ClusterScope(scope = Scope.SUITE)
            Collections.emptyMap()
                    new BytesArray(
            .addAggregation(
                totalCount += numberValue.longValue();
                    .mapScript(new Script(ScriptType.STORED, null, "mapScript_stored", Collections.emptyMap()))
                .get()
            ScriptType.INLINE,
            assertThat(subAgg, instanceOf(ScriptedMetric.class));
                .getRequestCache()  
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
                    )
 * Unless required by applicable law or agreed to in writing,
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
                        scriptedMetric("scripted").params(params)
                // Lazily populate state.list for tests without an init script
                    Integer sum = 0;  
import org.opensearch.search.aggregations.InternalAggregation;
                // A particular shard may not have any documents stored on it so
            // }
        );
    }  
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();  
                assertThat(stringValue, equalTo("12"));  
            .get();
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
        assertSearchResponse(r);
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());  
                .cluster()
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());  
        createIndex("idx");
        Script reduceScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op list aggregation", Collections.emptyMap());
            CustomScriptPlugin.NAME,
                global("global").subAggregation(  
        Script combineScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "no-op aggregation", Collections.emptyMap());
                    .mapScript(mapScript)  
 * this file be licensed under the Apache-2.0 license or a
        Script combineScript = new Script(
                .setRequestCache(true)
            //
        Script reduceScript = new Script(  
        Script mapScript = new Script(
        Map<String, Object> varsMap = new HashMap<>();
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state[param1] = param2", scriptParams);  
        Map<String, Object> scriptParams = Collections.singletonMap("param1", "12");  
import static org.hamcrest.Matchers.instanceOf;  
        SearchResponse response = client().prepareSearch("idx")  
            //
        // Test that all deterministic scripts cause the request to be cached  
        Map<String, Object> varsMap = new HashMap<>();
        varsMap.put("multiplier", 1);  
                .prepareStats("cache_test_idx")
 * SPDX-License-Identifier: Apache-2.0
        SearchResponse response = client().prepareSearch("idx")  
                for (List<?> list : states) {
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
        assertThat(bucket, notNullValue());  
            }
    public void testInitMapCombineReduceWithParamsAndReduceParams() {  
        assertThat(object, notNullValue());  
                .prepareStats("cache_test_idx")  
                    ),
        Script combineScript = new Script(
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
            CustomScriptPlugin.NAME,
        // Test that a non-deterministic combine script causes the result to not be cached  
                    )
                .setRequestCache(true)
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        assertSearchResponse(r);
        for (Object object : aggregationList) {
        assertThat(totalCount, equalTo(numDocs * 3));
                // we have to assume the lower bound may be 0. The check at the
                    .initScript(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap()))
            client().admin()
            ScriptType.INLINE,
            assertThat(object, notNullValue());
                List newAggregation = new ArrayList();
        }
                assertThat(entry.getValue(), notNullValue());  
                        jsonBuilder().startObject().field("value", randomAlphaOfLengthBetween(5, 15)).field("l_value", i).endObject()  
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
                assertThat(o, notNullValue());  
            .addAggregation(
                newAggregation.add(sum * multiplier);
                .getRequestCache()
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state.list.add(1)", params);
            .get();
            assertThat(object, notNullValue());
        Script mapScript = new Script(
                    if (list != null) {  
import org.opensearch.action.search.SearchRequestBuilder;
        );
        Script mapScript = new Script(
                assertThat(o, notNullValue());  
            Collections.emptyMap()  
        assertThat(scriptedMetric, notNullValue());  
            Collections.emptyMap()
import org.opensearch.core.xcontent.MediaTypeRegistry;
                        sum += ((Number) s).intValue();
                .cluster()  
            "sum state values as a new aggregation",  
            equalTo(0L)
        assertThat(aggregationList.size(), greaterThanOrEqualTo(getNumShards("idx").numPrimaries));
    public void testMapCombineWithParams() {
                            sum += ((Number) s).intValue();
                            + MockScriptPlugin.NAME
            if (map.size() == 1) {
                assertThat(numberValue.longValue(), allOf(greaterThanOrEqualTo(0L), lessThanOrEqualTo(numDocs * 3)));  
            )
    @Override
                if (state.containsKey("list") == false) {
            Files.write(scripts.resolve("combine_script.mockscript"), "sum state values as a new aggregation".getBytes("UTF-8"));
import org.opensearch.search.aggregations.bucket.global.Global;  
        assertThat(((InternalAggregation) global).getProperty("scripted"), sameInstance(scriptedMetricAggregation));
 * under the License.  
            equalTo(0L)
            assertThat(map, hasKey("list"));
                        for (Object s : list) {
    public void testMap() {
            List<?> list = (List<?>) object;
        assertThat(global.getName(), equalTo("global"));  
                client().prepareIndex("empty_bucket_idx")  
        SearchRequestBuilder builder = client().prepareSearch("idx")
        @Override  
            Collections.emptyMap()
                            .initScript(initScript)
import org.opensearch.action.search.SearchPhaseExecutionException;
            .get();
                .prepareStats("cache_test_idx")  
                    scriptedMetric("scripted").params(params)
            Map<?, ?> map = (Map<?, ?>) object;
        );  
                .getHitCount(),  
                        "{\"script\": {\"lang\": \"" + MockScriptPlugin.NAME + "\"," + " \"source\": \"state.list.add(vars.multiplier)\"} }"
        List<IndexRequestBuilder> builders = new ArrayList<>();
                        for (Object s : list) {
                histogram("histo").field("l_value")
            Collections.emptyMap()  
            true,
            Collections.emptyMap()  
                    .combineScript(combineScript)  
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
        long totalCount = 0;
        Script mapScript = new Script(
                .setRequestCache(true)
            client().admin()
            // }  
    @SuppressWarnings("rawtypes")
                Integer sum = 0;
        params.put("vars", varsMap);  
        assertThat(aggregationList.size(), equalTo(1));
        Aggregation aggregation = response.getAggregations().get("scripted");
                List newAggregation = new ArrayList();
            .get();
        );  
 * GitHub history for details.
            ScriptType.INLINE,  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        );
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
                        }
        try {
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
            Collections.emptyMap()
                        for (Object s : list) {  
                .preparePutStoredScript()  
            "sum all states (lists) values as a new aggregation",  
        // Test that a non-deterministic map script causes the result to not be cached  
        @SuppressWarnings("unchecked")
 * license agreements. See the NOTICE file distributed with
        Script mapScript = new Script(  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            scripts.put("multiplied sum all states (lists) values as a new aggregation", vars -> {
        Map<String, Object> params = new HashMap<>();
import static org.hamcrest.Matchers.notNullValue;
            CustomScriptPlugin.NAME,
            // must match a predefined script from CustomScriptPlugin.pluginScripts() method
                }
                    .reduceScript(reduceScript)
        List<Integer> aggregationResult = (List<Integer>) scriptedMetric.aggregation();
        assertSearchResponse(response);
        varsMap.put("multiplier", 1);  
            "sum all states (lists) values as a new aggregation",
                .getMissCount(),
    }  
                .prepareStats("cache_test_idx")  
import org.opensearch.plugins.Plugin;
        Aggregation aggregation = response.getAggregations().get("scripted");
            });
            // };
                List<List<?>> states = (List<List<?>>) vars.get("states");
            // Equivalent to:
        );
    }
            Collections.emptyMap()  
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));  
            .setQuery(matchAllQuery())  
            ScriptType.INLINE,
    public void setUp() throws Exception {
        assertThat(response.getHits().getTotalHits().value(), equalTo(numDocs));
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
            ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) subAgg;  
            );  
            .addAggregation(scriptedMetric("scripted").mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript))  
            }
    public void testConflictingAggAndScriptParams() {
/*  
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
                        "{\"script\": {\"lang\": \""  
            "sum all states (lists) values as a new aggregation",  
                        (String) XContentMapValues.extractValue("params.param1", vars),  
        );  
        varsMap.put("multiplier", 1);  
        indexRandom(true, builders);
        SearchResponse response = client().prepareSearch("idx")  
                Number numberValue = (Number) entry.getValue();
        assertThat(aggregation, instanceOf(ScriptedMetric.class));  
            .setSize(1000)
        List<?> aggregationList = (List<?>) scriptedMetricAggregation.aggregation();
        );
        );
                    MediaTypeRegistry.JSON
        Script combineScript = new Script(
        Map<String, Object> params = new HashMap<>();  
            //  
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));  
                .indices()
        r = client().prepareSearch("cache_test_idx")
    }  
                .getTotal()  
            .addAggregation(scriptedMetric("foo").mapScript(mapScript).combineScript(combineScript).reduceScript(reduceScript))  
            CustomScriptPlugin.NAME,  
            builders.add(
            // newaggregation = [];
            Collections.emptyMap()  
            .get();  
            // return newaggregation"
            ScriptType.INLINE,
        // to check that this bucket exists with the appropriate sub  
import java.util.Arrays;
        assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
        Map<String, Object> params = new HashMap<>();
            "state.list.add(vars.multiplier)",  
                    .minDocCount(0)  
        assertThat(scriptedMetricAggregation.aggregation(), instanceOf(ArrayList.class));
        Map<String, Object> aggregationParams = Collections.singletonMap("param2", 1);
            )  
import java.util.Collections;  
        Map<String, Object> params = Collections.singletonMap("param1", "12");  
                .get()
            .setQuery(matchAllQuery())  
        return Arrays.asList(
        Script mapScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state['count'] = 1", Collections.emptyMap());
        );
        assertThat(aggregation, notNullValue());
                return newAggregation;
        }  
        Aggregation aggregation = response.getAggregations().get("scripted");
        Object object = aggregationList.get(0);  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        SearchResponse response = client().prepareSearch("idx")  
            .addAggregation(
        Script initScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "vars.multiplier = 3", Collections.emptyMap());  
            assertThat(scriptedMetricAggregation.getName(), equalTo("scripted"));
                .get()
            List<?> list = (List<?>) object;
                    .subAggregation(  
            CustomScriptPlugin.NAME,
                assertThat(entry.getKey(), instanceOf(String.class));
                for (List<?> list : states) {
                // A particular shard may not have any documents stored on it so  
                            .reduceScript(reduceScript)  
                List<Map<String, Object>> states = (List<Map<String, Object>>) vars.get("states");
                    .subAggregation(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(global.getAggregations(), notNullValue());
                    .combineScript(new Script(ScriptType.STORED, null, "combineScript_stored", Collections.emptyMap()))
        }  
            .get();
import org.opensearch.common.settings.Settings;
            );  
                    .setSource(
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").get();
            Collections.emptyMap()  
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            CustomScriptPlugin.NAME,
            // return newaggregation"
 * Modifications Copyright OpenSearch Contributors. See
                assertThat(entry.getValue(), instanceOf(Number.class));
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
import org.opensearch.test.OpenSearchIntegTestCase;  
                assertThat(o, instanceOf(Number.class));
        Map<String, Object> varsMap = new HashMap<>();
            Collections.emptyMap()  
            .get();  
        ScriptedMetric scriptedMetricAggregation = (ScriptedMetric) aggregation;
                    ),  
        assertThat(scriptedMetricAggregation.aggregation(), notNullValue());
        Script ndInitScript = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "state.data = Math.random()", Collections.emptyMap());  
            "sum all states (lists) values as a new aggregation",
            throw new RuntimeException("failed to create scripts");
            "state.list.add(vars.multiplier)",
            //
            client().admin()
                    List<?> list = (List<?>) state.get("list");  
                ((List) state.get("list")).add(1);
            CustomScriptPlugin.NAME,
        params.put("vars", varsMap);
        assertThat(aggregation, notNullValue());  
import java.util.function.Function;
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
            CustomScriptPlugin.NAME,
            );
                .preparePutStoredScript()
            ScriptType.INLINE,
                ((Map<String, Object>) vars.get("vars")).put("multiplier", 3);
            // the name of the file script is used in test method while the source of the file script
            .setQuery(matchAllQuery())
                    new BytesArray(
                    .combineScript(combineScript)  
