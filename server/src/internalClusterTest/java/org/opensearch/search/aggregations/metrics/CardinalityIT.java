        return randomBoolean() ? "l_values" : "d_values";
            equalTo(0L)  
                    .build() }
    public void testSingleValuedNumericValueScript() throws Exception {  
        assertThat(cardinality, notNullValue());
        assertThat(count, notNullValue());
            equalTo(1L)
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                .prepareStats("cache_test_idx")  
 * license agreements. See the NOTICE file distributed with
        assertThat(count.getName(), equalTo("cardinality"));  
        assertThat(count.getName(), equalTo("cardinality"));
            });
            Cardinality cardinalityAgg = response.getAggregations().get("cardinality");
                .setRequestCache(true)  
import java.util.Collection;  
    public void testSingleValuedStringScript() throws Exception {  
        Cardinality count = response.getAggregations().get("cardinality");
            "doc[' + multiNumericField(false) + ']",
            client().admin()
            .get();  
                .setRequestCache(true)  
                .endObject()
    }
        Cardinality count = response.getAggregations().get("cardinality");
                    .field("str_values")
                ScriptDocValues.Strings strValue = (ScriptDocValues.Strings) doc.get("str_values");
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
        assertSearchResponse(response);  
    @Override  
            scripts.put("doc[' + singleNumericField() + '].value", vars -> {
        assertThat((double) ((InternalAggregation) cardinality).getProperty("value"), equalTo((double) cardinality.getValue()));
        assertThat(global.getName(), equalTo("global"));
            .get();
                        .array("d_values", new double[] { i * 2, i * 2 + 1 })
 * SPDX-License-Identifier: Apache-2.0
                .indices()  
        IndexRequestBuilder[] builders = new IndexRequestBuilder[(int) numDocs];  
        assertCount(count, numDocs * 2);
            client().admin()
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field(singleNumericField()))
        }
                .getMissCount(),
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");  
        assertThat(count, notNullValue());  
        assertCount(cardinality, expectedValue);
            )
            client().admin()  
 * Unless required by applicable law or agreed to in writing,
            .get();
import java.util.ArrayList;
        assertThat(count, notNullValue());
            equalTo(0L)
            });
            scripts.put("doc['str_values']", vars -> {
        SearchResponse response = client().prepareSearch("idx")  
            )
        assertSearchResponse(response);
import static org.opensearch.search.aggregations.AggregationBuilders.global;  
            )  
                .endObject()  
        r = client().prepareSearch("cache_test_idx")
            internalCluster().wipeIndices("test_cardinality_agg");
        assertCount(count, numDocs);
        return Settings.builder()  
    }  
                .field("type", "long")
        Cardinality count = response.getAggregations().get("cardinality");
        );
    @Override
import java.util.Map;
    @Override
 */  
        IndexRequestBuilder[] dummyDocsBuilder = new IndexRequestBuilder[10];
@OpenSearchIntegTestCase.SuiteScopeTestCase
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public void setupSuiteScopeCluster() throws Exception {
        assertSearchResponse(response);
import static org.hamcrest.Matchers.notNullValue;  
            client().admin()  
            true,
            .get();
    static long numDocs;  
                .endObject()
 * ownership. Elasticsearch licenses this file to you under  
                .field("type", "keyword")
        assertThat(count.getName(), equalTo("cardinality"));
        ensureSearchable();
        for (int i = 0; i < dummyDocsBuilder.length; i++) {  
        long expectedValue = numDocs;
        assertCount(count, numDocs * 2);  
    }
        SearchResponse response = client().prepareSearch("idx")  
            scripts.put("doc['str_value'].value", vars -> {  
        Cardinality count = response.getAggregations().get("cardinality");
        assertThat(  
        // Ensure that non-scripted requests are cached as normal
        numDocs = randomIntBetween(2, 100);
            .get();  
 */  
        Cardinality count = response.getAggregations().get("cardinality");
                .indices()
        assertThat(count, notNullValue());  
            .get();
                .indices()
                )  
                .getRequestCache()  
                    cardinality("cardinality").precisionThreshold(precisionThreshold).field(singleNumericField())
                        .field("l_value", i)
        assertAcked(
                    .subAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_values"))  
 * this file be licensed under the Apache-2.0 license or a
}
import static org.hamcrest.Matchers.greaterThan;
 * specific language governing permissions and limitations
                .get()
        assertThat(cardinality.getName(), equalTo("cardinality"));  
        Script script = new Script(
        SearchResponse response = client().prepareSearch("idx")
        return randomBoolean() ? "l_value" : "d_value";
    }
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
        );
                .setRequestCache(true)
        @Override  
                .addAggregation(cardinality("cardinality").field("category"))
import java.util.function.Function;
            .get();
        }
            assertThat(count.getValue(), greaterThan(0L));
        super(staticSettings);  
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
    }
        for (Terms.Bucket bucket : terms.getBuckets()) {
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
    }
     * Make sure that a request using a deterministic script or not using a script get cached.
    }  
                .getHitCount(),
            .setSize(0)
                .prepareStats("cache_test_idx")
        assertSearchResponse(response);
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;
import org.opensearch.test.OpenSearchIntegTestCase;
        Cardinality count = response.getAggregations().get("cardinality");  
                .get()
 * The OpenSearch Contributors require contributions made to  
        assertThat(count, notNullValue());
        );
            scripts.put("Math.random()", vars -> CardinalityIT.randomDouble());
        }
    public void testMultiValuedNumericHashed() throws Exception {
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))
                .setRequestCache(true)
        );  
        indexRandom(
        assertThat(count.getName(), equalTo("cardinality"));  
            .cluster()
import java.util.List;  
            .setQuery(matchAllQuery())
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))  
        SearchResponse response = client().prepareSearch("idx_unmapped")  
        assertThat(count, notNullValue());
        SearchResponse response = client().prepareSearch("idx")  
            prepareCreate("cache_test_idx").setMapping("d", "type=long")  
            client().admin()  
            .get();
            .get();  
                .indices()
            equalTo(2L)
        assertThat(((InternalAggregation) global).getProperty("cardinality"), equalTo(cardinality));  
            .get();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 * You may obtain a copy of the License at  
                .getRequestCache()
            assertThat(count, notNullValue());  
            assertEquals(value, count.getValue());
            .put("index.number_of_replicas", numberOfReplicas())
    public void testMultiValuedNumeric() throws Exception {
            .setTransientSettings(Settings.builder().put(CARDINALITY_AGGREGATION_PRUNING_THRESHOLD.getKey(), 0))
            .addAggregation(
        }
            )
        createIndex("idx_unmapped");  
                .prepareStats("cache_test_idx")  
                );  
                .getRequestCache()
            Collections.emptyMap()  
        );
                cardinality("foo").field("d").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
    }
                .prepareStats("cache_test_idx")
        // assertThat(global.getDocCount(), equalTo(numDocs));  
        assertThat(count.getName(), equalTo("cardinality"));  
    public void testDisableDynamicPruning() throws Exception {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field(multiNumericField(true)))
        indexRandom(true, builders);
    public static Collection<Object[]> parameters() {
                        .array("str_values", new String[] { "s" + (i * 2), "s" + (i * 2 + 1) })  
                .get()  
                .getMissCount(),
    public void testSingleValuedString() throws Exception {
        assertThat(count.getName(), equalTo("cardinality"));
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(count, notNullValue());  
            .addAggregation(  
        assertCount(count, numDocs);  
                .startObject("l_value")  
        assertSearchResponse(response);  
        SearchResponse response = client().prepareSearch("idx")  
            return scripts;  
    }
                .getRequestCache()
                .get()
        assertSearchResponse(response);
                .startObject("d_values")  
                        .endObject()
            .build();  
                cardinality("cardinality").precisionThreshold(precisionThreshold)
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        } finally {
 * KIND, either express or implied.  See the License for the
            .addAggregation(
                .getRequestCache()  
    @ParametersFactory  
        final ClusterUpdateSettingsResponse updateSettingResponse = client().admin()
    public void testMultiValuedNumericScript() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
            .get();
                    .field("str_value")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),  
                Settings.builder()
        assertThat(
    /**  
        assertThat(count.getName(), equalTo("cardinality"));
        Cardinality cardinality = global.getAggregations().get("cardinality");
        assertThat(
        SearchResponse response = client().prepareSearch("idx")  
        assertSearchResponse(response);
 * the Apache License, Version 2.0 (the "License"); you may
        ).get();
    public void testAsSubAgg() throws Exception {
                .getRequestCache()  
        @Override  
        assertCount(count, numDocs * 2);  
                .endObject()
                .setRequestCache(true)
                cardinality("cardinality").precisionThreshold(precisionThreshold)
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
 *  
            .get();
                .getTotal()  
            ScriptType.INLINE,  
        assertSearchResponse(response);  
        assertThat(count.getName(), equalTo("cardinality"));
                .startObject("properties")
    }
                    jsonBuilder().startObject()
        assertSearchResponse(response);
        assertThat(((InternalAggregation) global).getProperty("cardinality.value"), equalTo((double) cardinality.getValue()));
            indexRandomForConcurrentSearch("test_cardinality_agg");  
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_values"))
            )  
            .addAggregation(  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
            .get();
        return Arrays.asList(
                cardinality("cardinality").precisionThreshold(precisionThreshold)
                .indices()
            scripts.put("doc[' + multiNumericField(false) + ']", vars -> {
    static long precisionThreshold;
    }
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
public class CardinalityIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                .get();  
            .get();
            .get();
            .addAggregation(
/*
                .prepareStats("cache_test_idx")
                return (ScriptDocValues<?>) doc.get(multiNumericField(false));  
import org.opensearch.search.aggregations.InternalAggregation;
                .getTotal()
        Cardinality count = response.getAggregations().get("cardinality");
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
            )
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
        assertThat(count, notNullValue());
        Cardinality count = response.getAggregations().get("cardinality");
                .getHitCount(),
        try {  
        SearchResponse response = client().prepareSearch("idx")
        Cardinality count = response.getAggregations().get("cardinality");  
            indexBulkWithSegments(builders, 2);
        }  
    }  
        assertThat(count, notNullValue());
    public void testMultiValuedStringValueScript() throws Exception {
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))
        assertCount(count, numDocs * 2);
package org.opensearch.search.aggregations.metrics;
                .endObject()
            )
                global("global").subAggregation(
import org.opensearch.script.MockScriptPlugin;  
 */
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))  
    public void testSingleValuedNumericHashed() throws Exception {
        assertCount(count, numDocs * 2);
    }  
        assertThat(count.getName(), equalTo("cardinality"));
    }
                .prepareStats("cache_test_idx")  
        }  
        Cardinality count = response.getAggregations().get("cardinality");
                .getRequestCache()
                .endObject()
        assertCount(count, numDocs);
        assertThat(global.getAggregations(), notNullValue());
            assertThat(count.getName(), equalTo("cardinality"));
                        .field("d_value", i)  
import org.opensearch.action.search.SearchResponse;
                .get()
        return Collections.singleton(CustomScriptPlugin.class);
        assertEquals(updateSettingResponse.getTransientSettings().get(CARDINALITY_AGGREGATION_PRUNING_THRESHOLD.getKey()), "0");  
                .indices()  
            .prepareUpdateSettings()  
        );  
                        .field("str_value", "s" + i)
                .setRequestCache(true)
            .get();  
            )  
        assertThat(  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(cardinality("foo").field("d")).get();  
import org.opensearch.script.Script;
 * software distributed under the License is distributed on an
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
    }
                .get()  
        );
 *
import org.opensearch.script.ScriptType;
        assertSearchResponse(response);  
                .prepareStats("cache_test_idx")
        assertThat(  
        precisionThreshold = randomIntBetween(0, 1 << randomInt(20));
        assertThat(count.getName(), equalTo("cardinality"));
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field(singleNumericField()))
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
        SearchResponse response = client().prepareSearch("idx")
    }  
    }
        assertThat(count, notNullValue());
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)  
import java.util.HashMap;
import org.opensearch.index.fielddata.ScriptDocValues;
            .prepareUpdateSettings()  
        assertSearchResponse(r);
            client().admin()
            .addAggregation(  
        assertCount(count, numDocs);  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))  
     * Ensure requests using nondeterministic scripts do not get cached.
                cardinality("cardinality").precisionThreshold(precisionThreshold)  
                .getTotal()  
    public void testCardinalityWithIntraSegmentPartitioning() throws Exception {
                return doc.get(singleNumericField());
        assertSearchResponse(searchResponse);
        assertThat(count.getName(), equalTo("cardinality"));  
            .get();
        assertSearchResponse(response);
            Cardinality count = bucket.getAggregations().get("cardinality");
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .get();  
        Cardinality count = response.getAggregations().get("cardinality");  
        assertThat(
    }  
                builders.add(client().prepareIndex("test_cardinality_agg").setSource("category", i % 100));  
            .get();
        assertThat(
            });  
        // Test that a request using a nondeterministic script does not get cached
    }
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).script(script))
        client().admin()
        Cardinality count1 = response.getAggregations().get("cardinality");
    public void testPartiallyUnmapped() throws Exception {  
                    .field(singleNumericField())
        assertSearchResponse(response);
    }  
        assertThat(count, notNullValue());
            client().admin()
        SearchResponse response = client().prepareSearch("idx")
        assertThat(count, notNullValue());
            .addAggregation(  
                .getTotal()
            CustomScriptPlugin.NAME,
            equalTo(0L)  
    public Settings indexSettings() {
        if (value <= precisionThreshold) {  
            .addAggregation(
 * compatible open source license.
import java.util.Arrays;
                        .array("l_values", new int[] { i * 2, i * 2 + 1 })
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
 * Licensed to Elasticsearch under one or more contributor  
    }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            .addAggregation(
            )
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            // linear counting should be picked, and should be accurate
        Terms terms = response.getAggregations().get("terms");  
    }
        // Make sure we are starting with a clear cache
import org.opensearch.common.settings.Settings;  
    }  
                .startObject("d_value")  
        );
                cardinality("cardinality").precisionThreshold(precisionThreshold)  
        } else {  
import org.opensearch.search.aggregations.bucket.terms.Terms;  
        assertThat(count.getName(), equalTo("cardinality"));
        assertCount(count, numDocs * 2);
                cardinality("foo").field("d").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", emptyMap()))
        Cardinality count2 = response.getAggregations().get("cardinality");  
        assertSearchResponse(response);  
        assertCount(count, 0);  
            }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        );  
    public void testSingleValuedNumericGetProperty() throws Exception {  
            assertCount(count, 2);
import java.util.Collections;
        createIndex("test_cardinality_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
    }  
    }
    public void testUnmapped() throws Exception {
        Cardinality count = response.getAggregations().get("cardinality");
    public void testSingleValuedStringValueScript() throws Exception {
        assertCount(count, numDocs);
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
                .indices()
                .getMissCount(),  
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
        prepareCreate("idx").setMapping(  
    public static class CustomScriptPlugin extends MockScriptPlugin {
        assertSearchResponse(r);
                .getTotal()
import static org.hamcrest.Matchers.equalTo;
                .setSource(  
        assertSearchResponse(response);
        assertThat(count, notNullValue());
    private static String singleNumericField() {  
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;  
            return scripts;  
                .get()
        assertThat(count.getName(), equalTo("cardinality"));
                .field("type", "double")
        assertThat(
    private void assertCount(Cardinality count, long value) {
                .get()
                return strValue;
        // Test that a request using a deterministic script gets cached  
/*  
        assertThat(global, notNullValue());
            jsonBuilder().startObject()
                .getTotal()  
            .setTransientSettings(Settings.builder().putNull(CARDINALITY_AGGREGATION_PRUNING_THRESHOLD.getKey()))
        assertSearchResponse(response);  
                .startObject("l_values")  
        assertCount(count, numDocs * 2);
    public void testSingleValuedNumericScript() throws Exception {
            .get();  
        assertThat(count, notNullValue());  
        SearchResponse r = client().prepareSearch("cache_test_idx")
        SearchResponse response = client().prepareSearch("idx")
                cardinality("cardinality").precisionThreshold(precisionThreshold)
        Cardinality count = response.getAggregations().get("cardinality");  
import static java.util.Collections.emptyMap;
            .put("index.number_of_shards", numberOfShards())
            assertThat(cardinalityAgg.getValue(), equalTo(100L));  
                .prepareStats("cache_test_idx")
        SearchResponse response = client().prepareSearch("idx")
        assertSearchResponse(response);
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['str_value'].value", emptyMap()))
            .addAggregation(  
                .getHitCount(),
                .startObject("str_value")  
        SearchResponse searchResponse = client().prepareSearch("idx")
        assertThat(count.getName(), equalTo("cardinality"));  
        assertThat(count.getName(), equalTo("cardinality"));
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
        assertThat(count, notNullValue());
    public void testMultiValuedStringScript() throws Exception {
        }  
import org.opensearch.action.index.IndexRequestBuilder;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
                .setRequestCache(true)
        assertThat(count, notNullValue());  
            .get();
                terms("terms").field("str_value")
        assertThat(count.getName(), equalTo("cardinality"));  
        for (int i = 0; i < numDocs; ++i) {
                return doc.get("str_value");
    private static String multiNumericField(boolean hash) {
import org.opensearch.search.aggregations.bucket.global.Global;
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field(multiNumericField(false)))  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;  
    public void testMultiValuedNumericValueScript() throws Exception {
                .getMissCount(),
            equalTo(0L)
                .getTotal()
            .get();
 *
 * this work for additional information regarding copyright
            client().admin()
                .endObject()
        Global global = searchResponse.getAggregations().get("global");  
        assertSearchResponse(response);
        );
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");  
                .field("type", "long")
            .cluster()
import org.opensearch.plugins.Plugin;
        Cardinality count = response.getAggregations().get("cardinality");  
                .field("type", "keyword")
            });  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['str_values']", emptyMap()))
    public CardinalityIT(Settings staticSettings) {
            scripts.put("_value", vars -> vars.get("_value"));
                .startObject("str_values")  
        Cardinality count = response.getAggregations().get("cardinality");
            builders[i] = client().prepareIndex("idx")
    public void testMultiValuedString() throws Exception {  
                .get()
        assertEquals(count1, count2);
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))
            equalTo(0L)
                .setRequestCache(true)  
        assertCount(count, numDocs);
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
    public void testSingleValuedNumeric() throws Exception {
        SearchResponse response = client().prepareSearch("idx")  
        response = client().prepareSearch("idx")
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;  
        assertCount(count, numDocs);
            equalTo(0L)  
            SearchResponse response = client().prepareSearch("test_cardinality_agg")
        indexRandom(true, dummyDocsBuilder);  
                .getHitCount(),  
/*  
        Cardinality count = response.getAggregations().get("cardinality");
                .endObject()
import static org.opensearch.search.SearchService.CARDINALITY_AGGREGATION_PRUNING_THRESHOLD;
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc[' + singleNumericField() + '].value", emptyMap());  
                .indices()
 * GitHub history for details.
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
            assertThat(cardinalityAgg, notNullValue());
        SearchResponse response = client().prepareSearch("idx")
                    .field(multiNumericField(false))  
     */  
            dummyDocsBuilder[i] = client().prepareIndex("idx").setSource("a_field", "1");
            .setSize(0)  
            // error is not bound, so let's just make sure it is > 0
                .getTotal()
            )
        assertSearchResponse(r);
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
    }
    }
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).script(script))  
            for (int i = 0; i < 5000; i++) {
        );
        internalCluster().wipeIndices("cache_test_idx");
            .get();
        assertSearchResponse(response);
    }
            new Object[] {  
        );  
                .field("type", "double")
        assertCount(count, numDocs);
    public void testScriptCaching() throws Exception {
                .getRequestCache()
 * not use this file except in compliance with the License.
