            scripts.put("doc[' + multiNumericField(false) + ']", vars -> {
            .get();
        assertThat(count.getName(), equalTo("cardinality"));
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
                .getRequestCache()
        }
                cardinality("cardinality").precisionThreshold(precisionThreshold)
                .getRequestCache()
                .setRequestCache(true)
        SearchResponse r = client().prepareSearch("cache_test_idx")
        SearchResponse response = client().prepareSearch("idx")
        assertThat(count.getName(), equalTo("cardinality"));
        assertThat(count, notNullValue());
        Cardinality count = response.getAggregations().get("cardinality");
 */
        for (int i = 0; i < numDocs; ++i) {
                Settings.builder()
import static org.opensearch.search.aggregations.AggregationBuilders.cardinality;
                cardinality("foo").field("d").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", emptyMap()))
        response = client().prepareSearch("idx")
    }
            .cluster()
    private void assertCount(Cardinality count, long value) {
            client().admin()
        assertSearchResponse(response);
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "segment").build() },
                cardinality("cardinality").precisionThreshold(precisionThreshold)
                .endObject()
/*
        return randomBoolean() ? "l_value" : "d_value";
        assertCount(count, numDocs * 2);
package org.opensearch.search.aggregations.metrics;
        assertThat(count, notNullValue());
import static java.util.Collections.emptyMap;
            .addAggregation(
            assertThat(count.getName(), equalTo("cardinality"));
        final ClusterUpdateSettingsResponse updateSettingResponse = client().admin()
                .field("type", "keyword")
                .setSource(
            .get();
                .getRequestCache()
                        .field("l_value", i)
                        .array("str_values", new String[] { "s" + (i * 2), "s" + (i * 2 + 1) })
        assertThat(count.getName(), equalTo("cardinality"));
                .endObject()
    @Override
        assertThat(count, notNullValue());
 * this work for additional information regarding copyright
    }
        Cardinality count2 = response.getAggregations().get("cardinality");
            prepareCreate("cache_test_idx").setMapping("d", "type=long")
 * specific language governing permissions and limitations
        assertCount(count, numDocs);
    @Override
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .addAggregation(
            equalTo(0L)
                .endObject()
                .getTotal()
    }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            dummyDocsBuilder[i] = client().prepareIndex("idx").setSource("a_field", "1");
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        SearchResponse response = client().prepareSearch("idx")
}
        assertThat(count, notNullValue());
                    .field(singleNumericField())
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", 2)
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))
        assertThat(count.getName(), equalTo("cardinality"));
                return strValue;
    }
        assertThat(count.getName(), equalTo("cardinality"));
            });
            new Object[] {
    }
    private static String multiNumericField(boolean hash) {
import java.util.ArrayList;
        SearchResponse response = client().prepareSearch("idx")
    }
                .getMissCount(),
        Cardinality count = response.getAggregations().get("cardinality");
            .get();
        assertEquals(count1, count2);
                .indices()
            .put("index.number_of_replicas", numberOfReplicas())
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).script(script))
                    .field("str_value")
        SearchResponse response = client().prepareSearch("idx")
import java.util.List;
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                .get()
                .endObject()
    public void setupSuiteScopeCluster() throws Exception {
            )
            equalTo(1L)
import static org.opensearch.search.SearchService.CARDINALITY_AGGREGATION_PRUNING_THRESHOLD;
                .field("type", "long")
 */
        assertCount(cardinality, expectedValue);
            equalTo(0L)
                .setRequestCache(true)
                .indices()
                .startObject("l_value")
import java.util.Collections;
                );
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))
            .addAggregation(
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx_unmapped")
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(((InternalAggregation) global).getProperty("cardinality"), equalTo(cardinality));
        assertCount(count, numDocs * 2);
                .getTotal()
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                .endObject()
            client().admin()
            .get();
                .indices()
                .startObject("d_value")
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
import org.opensearch.index.fielddata.ScriptDocValues;
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field(multiNumericField(false)))
            .addAggregation(
            )
            indexRandomForConcurrentSearch("test_cardinality_agg");
                .prepareStats("cache_test_idx")
        assertThat(count.getName(), equalTo("cardinality"));
            equalTo(0L)
import org.opensearch.script.Script;
                .prepareStats("cache_test_idx")
                .prepareStats("cache_test_idx")
            )
        } else {
            .setTransientSettings(Settings.builder().put(CARDINALITY_AGGREGATION_PRUNING_THRESHOLD.getKey(), 0))
        );
        assertSearchResponse(response);
            .put("index.number_of_shards", numberOfShards())
        IndexRequestBuilder[] builders = new IndexRequestBuilder[(int) numDocs];
            scripts.put("_value", vars -> vars.get("_value"));
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field(singleNumericField()))
        SearchResponse response = client().prepareSearch("idx")
                .get()
            .addAggregation(
                .getRequestCache()
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE;
            for (int i = 0; i < 5000; i++) {
                .get()
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        Script script = new Script(
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx")
 * the Apache License, Version 2.0 (the "License"); you may
        precisionThreshold = randomIntBetween(0, 1 << randomInt(20));
        }
        assertSearchResponse(r);
        assertThat((double) ((InternalAggregation) cardinality).getProperty("value"), equalTo((double) cardinality.getValue()));
                .startObject("l_values")
            .get();
    }
        assertThat(count, notNullValue());
        Cardinality count = response.getAggregations().get("cardinality");
        indexRandom(
                    .subAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_values"))
                .startObject("str_values")
                cardinality("cardinality").precisionThreshold(precisionThreshold)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                .getHitCount(),
        assertCount(count, numDocs);
                .setRequestCache(true)
        assertSearchResponse(response);
        assertThat(count.getName(), equalTo("cardinality"));
                .prepareStats("cache_test_idx")
        assertSearchResponse(r);
                global("global").subAggregation(
                )
                .prepareStats("cache_test_idx")
        assertThat(count.getName(), equalTo("cardinality"));
            .get();
    public void testSingleValuedString() throws Exception {
        assertSearchResponse(response);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .get();
            Collections.emptyMap()
    public void testMultiValuedStringScript() throws Exception {
                    jsonBuilder().startObject()
import org.opensearch.search.aggregations.bucket.global.Global;
        assertThat(((InternalAggregation) global).getProperty("cardinality.value"), equalTo((double) cardinality.getValue()));
        // Ensure that non-scripted requests are cached as normal
        SearchResponse response = client().prepareSearch("idx")
        try {
    public static Collection<Object[]> parameters() {
            .get();
            )
 * Licensed to Elasticsearch under one or more contributor
 *
        assertThat(count.getName(), equalTo("cardinality"));
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))
        ).get();
            .get();
    static long precisionThreshold;
                        .field("d_value", i)
    }
        );
        // Make sure we are starting with a clear cache
                .get()
        Cardinality count = response.getAggregations().get("cardinality");
    }
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['str_value'].value", emptyMap()))
                .getRequestCache()
        assertThat(count, notNullValue());
                .getTotal()
        assertThat(
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field(singleNumericField()))
        // Test that a request using a nondeterministic script does not get cached
        assertThat(
                .get()
                .indices()
        }
public class CardinalityIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        );
            equalTo(0L)
                .getTotal()
                .getTotal()
        } finally {
        assertThat(count, notNullValue());
        r = client().prepareSearch("cache_test_idx")
        SearchResponse response = client().prepareSearch("idx")
                .getTotal()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
    public void testMultiValuedNumericHashed() throws Exception {
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
            .get();
            assertThat(count.getValue(), greaterThan(0L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            )
        assertSearchResponse(response);
import org.opensearch.action.search.SearchResponse;
                    cardinality("cardinality").precisionThreshold(precisionThreshold).field(singleNumericField())
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        // assertThat(global.getDocCount(), equalTo(numDocs));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
        assertThat(cardinality, notNullValue());
        assertSearchResponse(response);
    }
        assertThat(count.getName(), equalTo("cardinality"));
        assertSearchResponse(response);
        assertThat(count.getName(), equalTo("cardinality"));
 * You may obtain a copy of the License at
    }
    @ParametersFactory
 * under the License.
        assertThat(count, notNullValue());
        );
                builders.add(client().prepareIndex("test_cardinality_agg").setSource("category", i % 100));
 *
                .indices()
/*
import org.opensearch.action.index.IndexRequestBuilder;
            });
                .setRequestCache(true)
        Cardinality count = response.getAggregations().get("cardinality");
/*
import org.opensearch.script.ScriptType;
        return randomBoolean() ? "l_values" : "d_values";
        assertThat(count, notNullValue());
            equalTo(0L)
        @Override
        Terms terms = response.getAggregations().get("terms");
                .setRequestCache(true)
        assertSearchResponse(response);
        SearchResponse searchResponse = client().prepareSearch("idx")
            .get();
    }
                .addAggregation(cardinality("cardinality").field("category"))
                cardinality("cardinality").precisionThreshold(precisionThreshold)
        assertThat(
            new Object[] { Settings.builder().put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "force").build() },
            .get();
        // Test that a request using a deterministic script gets cached
        client().admin()
        SearchResponse response = client().prepareSearch("idx")
    public void testPartiallyUnmapped() throws Exception {
        assertThat(count.getName(), equalTo("cardinality"));
import static org.hamcrest.Matchers.notNullValue;
                .getHitCount(),
        Cardinality count = response.getAggregations().get("cardinality");
        }
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY.getKey(), "balanced")
            client().admin()
    @Override
 * software distributed under the License is distributed on an
import static org.opensearch.search.aggregations.AggregationBuilders.global;
        Cardinality count = response.getAggregations().get("cardinality");
        long expectedValue = numDocs;
            assertEquals(value, count.getValue());
            assertThat(count, notNullValue());
        if (value <= precisionThreshold) {
                .get()
        Cardinality count = response.getAggregations().get("cardinality");
        Cardinality count = response.getAggregations().get("cardinality");
            .get();
        );
                .get();
import java.util.Map;
            .addAggregation(
    }
    }
            return scripts;
        assertSearchResponse(searchResponse);
 * The OpenSearch Contributors require contributions made to
        SearchResponse response = client().prepareSearch("idx")
            Cardinality count = bucket.getAggregations().get("cardinality");
        Cardinality count = response.getAggregations().get("cardinality");
        assertCount(count, numDocs);
                ScriptDocValues.Strings strValue = (ScriptDocValues.Strings) doc.get("str_values");
            .get();
    public void testScriptCaching() throws Exception {
                return doc.get(singleNumericField());
        SearchResponse response = client().prepareSearch("idx")
 * ownership. Elasticsearch licenses this file to you under
        assertCount(count, numDocs);
            assertThat(cardinalityAgg.getValue(), equalTo(100L));
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))
            .setQuery(matchAllQuery())
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_values"))
                .startObject("str_value")
            .get();
                .indices()
        }
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).script(script))
            .prepareUpdateSettings()
                .getRequestCache()
                terms("terms").field("str_value")
                .getRequestCache()
import java.util.function.Function;
    }
 * Unless required by applicable law or agreed to in writing,
                .getRequestCache()
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", 1),
        assertThat(count, notNullValue());
            builders[i] = client().prepareIndex("idx")
                .getMissCount(),
        assertCount(count, numDocs * 2);
        Cardinality count = response.getAggregations().get("cardinality");
                .setRequestCache(true)
        assertSearchResponse(response);
 * not use this file except in compliance with the License.
    }
    public void testSingleValuedNumericGetProperty() throws Exception {
    public void testMultiValuedNumericValueScript() throws Exception {
        }
            Cardinality cardinalityAgg = response.getAggregations().get("cardinality");
            )
        Cardinality count = response.getAggregations().get("cardinality");
        assertThat(global.getAggregations().asMap().size(), equalTo(1));
            client().admin()
        assertThat(count.getName(), equalTo("cardinality"));
                .getTotal()
        );
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        assertSearchResponse(response);
import org.opensearch.search.aggregations.InternalAggregation;
            scripts.put("doc[' + singleNumericField() + '].value", vars -> {
            internalCluster().wipeIndices("test_cardinality_agg");
                .setRequestCache(true)
            .addAggregation(
            client().admin()
import static org.hamcrest.Matchers.greaterThan;
            .addAggregation(
        assertCount(count, numDocs * 2);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(cardinality("foo").field("d")).get();
                .field("type", "double")
 * license agreements. See the NOTICE file distributed with
        for (Terms.Bucket bucket : terms.getBuckets()) {
    }
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_PARTITION_STRATEGY;
    }
        assertCount(count, numDocs);
        assertSearchResponse(response);
    public void testMultiValuedNumericScript() throws Exception {
            .build();
                .endObject()
            .get();
     */
        assertCount(count, numDocs);
        SearchResponse response = client().prepareSearch("idx")
                .endObject()
        indexRandom(true, dummyDocsBuilder);
import org.opensearch.test.OpenSearchIntegTestCase;
     * Ensure requests using nondeterministic scripts do not get cached.
        assertThat(
 * this file be licensed under the Apache-2.0 license or a
        assertSearchResponse(response);
            });
    public void testSingleValuedNumericHashed() throws Exception {
                    .put(CONCURRENT_SEGMENT_SEARCH_PARTITION_MIN_SEGMENT_SIZE.getKey(), 1000)
        assertSearchResponse(response);
 * GitHub history for details.
        assertThat(count, notNullValue());
                        .array("d_values", new double[] { i * 2, i * 2 + 1 })
     * Make sure that a request using a deterministic script or not using a script get cached.
    public void testUnmapped() throws Exception {
            )
            assertThat(cardinalityAgg, notNullValue());
        assertThat(count, notNullValue());
                .prepareStats("cache_test_idx")
            .get();
    public void testDisableDynamicPruning() throws Exception {
                .getMissCount(),
            .cluster()
 *
            client().admin()
        createIndex("idx_unmapped");
        assertSearchResponse(response);
        assertThat(
                .getHitCount(),
@OpenSearchIntegTestCase.SuiteScopeTestCase
    }
        numDocs = randomIntBetween(2, 100);
        assertThat(
        assertThat(count.getName(), equalTo("cardinality"));
        assertCount(count, numDocs * 2);
    public void testCardinalityWithIntraSegmentPartitioning() throws Exception {
                return (ScriptDocValues<?>) doc.get(multiNumericField(false));
            )
        assertSearchResponse(response);
                .endObject()
                        .endObject()
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
 * KIND, either express or implied.  See the License for the
                .get()
        Cardinality cardinality = global.getAggregations().get("cardinality");
import org.opensearch.script.MockScriptPlugin;
                .prepareStats("cache_test_idx")
        super(staticSettings);
        assertThat(
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['str_values']", emptyMap()))
 * compatible open source license.
            .setSize(0)
import static org.hamcrest.Matchers.equalTo;
            SearchResponse response = client().prepareSearch("test_cardinality_agg")
        assertThat(count.getName(), equalTo("cardinality"));
        SearchResponse response = client().prepareSearch("idx")
    public void testSingleValuedStringValueScript() throws Exception {
            .setSize(0)
        assertThat(count, notNullValue());
        prepareCreate("idx").setMapping(
                .prepareStats("cache_test_idx")
        internalCluster().wipeIndices("cache_test_idx");
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field(multiNumericField(true)))
        indexRandom(true, builders);
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            ScriptType.INLINE,
            // error is not bound, so let's just make sure it is > 0
        SearchResponse response = client().prepareSearch("idx")
    public void testMultiValuedNumeric() throws Exception {
    static long numDocs;
            true,
            .get();
            return scripts;
            equalTo(2L)
    }
        assertSearchResponse(r);
    public void testSingleValuedNumericValueScript() throws Exception {
            "doc[' + multiNumericField(false) + ']",
            });
                .startObject("properties")
        Cardinality count = response.getAggregations().get("cardinality");
        );
import java.util.Arrays;
            jsonBuilder().startObject()
            client().admin()
        for (int i = 0; i < dummyDocsBuilder.length; i++) {
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
            .get();
        assertCount(count, numDocs * 2);
                cardinality("foo").field("d").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
import org.opensearch.search.aggregations.bucket.terms.Terms;
                .get()
        Cardinality count1 = response.getAggregations().get("cardinality");
            scripts.put("Math.random()", vars -> CardinalityIT.randomDouble());
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value", emptyMap()))
        Cardinality count = response.getAggregations().get("cardinality");
    }
    public Settings indexSettings() {
                .getTotal()
                .startObject("d_values")
        assertCount(count, numDocs);
        Cardinality count = response.getAggregations().get("cardinality");
    }
import java.util.Collection;
    public void testSingleValuedNumericScript() throws Exception {
    }
        @Override
        );
            scripts.put("doc['str_values']", vars -> {
                cardinality("cardinality").precisionThreshold(precisionThreshold)
        }
 */
            scripts.put("doc['str_value'].value", vars -> {
        );
        assertThat(count, notNullValue());
        );
        Cardinality count = response.getAggregations().get("cardinality");
    }
        assertCount(count, numDocs);
            .setTransientSettings(Settings.builder().putNull(CARDINALITY_AGGREGATION_PRUNING_THRESHOLD.getKey()))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        .field("str_value", "s" + i)
                .indices()
        assertThat(cardinality.getName(), equalTo("cardinality"));
        assertThat(count, notNullValue());
        Global global = searchResponse.getAggregations().get("global");
        );
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
        return Settings.builder()
        assertThat(count, notNullValue());
            .get();
                .indices()
    public static class CustomScriptPlugin extends MockScriptPlugin {
                .getHitCount(),
                return doc.get("str_value");
            .addAggregation(
    public void testMultiValuedString() throws Exception {
import org.opensearch.plugins.Plugin;
import org.opensearch.common.settings.Settings;
                    .field(multiNumericField(false))
        assertCount(count, 0);
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")
            // linear counting should be picked, and should be accurate
    public void testAsSubAgg() throws Exception {
            CustomScriptPlugin.NAME,
            client().admin()
            List<IndexRequestBuilder> builders = new ArrayList<>(5000);
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
        return Collections.singleton(CustomScriptPlugin.class);
        ensureSearchable();
    }
                .field("type", "double")
        assertThat(count.getName(), equalTo("cardinality"));
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc[' + singleNumericField() + '].value", emptyMap());
                .field("type", "keyword")
            .prepareUpdateSettings()
        createIndex("test_cardinality_agg", Settings.builder().put("index.number_of_shards", 2).put("index.number_of_replicas", 1).build());
    }
            }
            .get();
 * SPDX-License-Identifier: Apache-2.0
    public CardinalityIT(Settings staticSettings) {
                    .field("str_values")
    public void testSingleValuedNumeric() throws Exception {
                cardinality("cardinality").precisionThreshold(precisionThreshold)
        assertEquals(updateSettingResponse.getTransientSettings().get(CARDINALITY_AGGREGATION_PRUNING_THRESHOLD.getKey()), "0");
                .get()
        assertThat(global, notNullValue());
        return Arrays.asList(
        assertThat(global.getName(), equalTo("global"));
                .getMissCount(),
        IndexRequestBuilder[] dummyDocsBuilder = new IndexRequestBuilder[10];
            assertCount(count, 2);
        assertThat(global.getAggregations(), notNullValue());
    /**
            indexBulkWithSegments(builders, 2);
    private static String singleNumericField() {
        assertAcked(
        assertCount(count, numDocs * 2);
    }
        assertSearchResponse(response);
                        .array("l_values", new int[] { i * 2, i * 2 + 1 })
                .setRequestCache(true)
        assertSearchResponse(response);
    }
        assertThat(
            .addAggregation(cardinality("cardinality").precisionThreshold(precisionThreshold).field("str_value"))
            )
    public void testSingleValuedStringScript() throws Exception {
            equalTo(0L)
            .get();
            .get();
    }
                    .build() }
                .field("type", "long")
    public void testMultiValuedStringValueScript() throws Exception {
            .get();
            )
import java.util.HashMap;
