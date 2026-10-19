                () -> client().prepareSearch("test-index").setQuery(scriptQuery(script)).get()
        flush();
        final byte[] randomBytesDoc2 = getRandomBytes(16);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
        final byte[] randomBytes = new byte[len];
            .setSource(jsonBuilder().startObject().field("binaryData", Base64.getEncoder().encodeToString(randomBytesDoc2)).endObject())
            .addSort("num1", SortOrder.ASC)
        return scriptCounter.incrementAndGet();
 * specific language governing permissions and limitations
import org.opensearch.action.search.SearchResponse;
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("num1", 2.0f).endObject())
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.equalTo;
    private XContentBuilder createMappingSource(String fieldType) throws IOException {
    public void testDisallowExpensiveQueries() throws InterruptedException {
            .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)
        return randomBytes;
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value()", Collections.emptyMap()))
            .addScriptField(
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
    }
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
            .build();
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
            .setId("2")
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        assertThat(response.getHits().getAt(0).getFields().get("sbinaryData").getValues().get(0), equalTo(16));
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), true)
    public static class CustomScriptPlugin extends MockScriptPlugin {
    }
                return doc.get("num1");
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));
            // Execute with search.allow_expensive_queries = null => default value = false => success
    public Settings indexSettings() {
import java.io.IOException;
 */
 * GitHub history for details.
        flush();
            .startObject("properties")
    public ScriptQuerySearchIT(Settings settings) {
                scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['binaryData'].get(0).length > 15", emptyMap()))
import java.util.HashMap;
            int docCount = 10;
import java.util.Arrays;
    @Override
            .get();
 * Licensed to Elasticsearch under one or more contributor
        indexRandomForConcurrentSearch("my-index");
            // Set search.allow_expensive_queries to "false" => assert failure
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    @Override
    public static int incrementScriptCounter() {
            .startObject()
                return ((ScriptDocValues.BytesRefs) doc.get("binaryData")).get(0).length > 15;
            assertEquals(
            });
import java.util.function.Function;
        return Arrays.asList(
                Map<?, ?> doc = (Map) vars.get("doc");
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value() > param1", params)))
        response = client().prepareSearch()
        client().prepareIndex("my-index")
        client().prepareIndex("test")
                client().prepareIndex("test-index").setId("" + i).setSource("num1", i).get();
            scripts.put("doc['binaryData'].get(0).length > 15", vars -> {
            .setId("3")
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value()", Collections.emptyMap()))
        super(settings);
        flush();
                Map<?, ?> doc = (Map) vars.get("doc");
import org.opensearch.test.InternalSettingsPlugin;
        flush();
                ScriptDocValues.Doubles num1 = (ScriptDocValues.Doubles) doc.get("num1");
            assertAcked(prepareCreate("test-index").setMapping("num1", "type=double"));
import org.opensearch.core.xcontent.XContentBuilder;
    }
            OpenSearchException e = expectThrows(
import java.util.concurrent.atomic.AtomicInteger;
        refresh();
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
            .setSource(jsonBuilder().startObject().field("binaryData", Base64.getEncoder().encodeToString(randomBytesDoc1)).endObject())
            .endObject();
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(2.0));
        }
 * ownership. Elasticsearch licenses this file to you under
        try {
        client().prepareIndex("my-index")
import org.opensearch.common.settings.Settings;
            .get();
/*
        assertThat(response.getHits().getAt(1).getId(), equalTo("3"));
        final byte[] randomBytesDoc1 = getRandomBytes(15);
            .put(super.indexSettings())
            scripts.put("doc['binaryData'].get(0).length", vars -> {
    }
            updateSettingsRequest = new ClusterUpdateSettingsRequest();
    }
                Map<?, ?> doc = (Map) vars.get("doc");
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.sort.SortOrder;
        createIndex("test");
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));
            }
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));
            });
            .get();
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("num1", 3.0f).endObject())
            scripts.put("doc['num1'].value() > param1", vars -> {
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));
        Map<String, Object> params = new HashMap<>();
import org.opensearch.OpenSearchException;
        return Settings.builder()
                return ((ScriptDocValues.BytesRefs) doc.get("binaryData")).get(0).length;
            refresh();
import org.opensearch.script.MockScriptPlugin;
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", false));
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
                Map<?, ?> doc = (Map) vars.get("doc");
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));
 * Unless required by applicable law or agreed to in writing,
            .setId("1")
            for (int i = 1; i <= docCount; i++) {
            indexRandomForConcurrentSearch("test-index");
 */
            scripts.put("doc['num1'].value() > 1", vars -> {
            .setQuery(
/*
        response = client().prepareSearch()
            .get();
            .field("doc_values", "true")
        params = new HashMap<>();
 * under the License.
            // aggressive filter caching so that we can assert on the number of iterations of the script filters
            // Set search.allow_expensive_queries to "true" => success
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
            SearchResponse resp = client().prepareSearch("test-index").setQuery(scriptQuery(script)).get();
    }
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        } finally {
                ScriptDocValues.Doubles num1 = (ScriptDocValues.Doubles) doc.get("num1");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            .endObject()
            );
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['binaryData'].get(0).length", emptyMap())
            .field("type", fieldType)
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collection;
                return num1.getValue() > 1;
            client().admin().indices().prepareCreate("my-index").setMapping(createMappingSource("binary")).setSettings(indexSettings())
                "[script] queries cannot be executed when 'search.allow_expensive_queries' is set to false.",
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
                return num1.getValue() > param1;
            assertNoFailures(resp);
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value() > param1", params)))
                e.getCause().getMessage()
import org.opensearch.plugins.Plugin;
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(3.0));
                "sbinaryData",
import org.opensearch.test.OpenSearchIntegTestCase;
        logger.info("running doc['num1'].value() > 1");
import static java.util.Collections.emptyMap;
            assertNoFailures(resp);
        logger.info("running doc['num1'].value() > param1");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * SPDX-License-Identifier: Apache-2.0
    }
                OpenSearchException.class,
        return Arrays.asList(CustomScriptPlugin.class, InternalSettingsPlugin.class);
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
                scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value() > 1", Collections.emptyMap()))
            .get();
import java.util.Map;
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());
        );
            resp = client().prepareSearch("test-index").setQuery(scriptQuery(script)).get();
    public static Collection<Object[]> parameters() {
    private static AtomicInteger scriptCounter = new AtomicInteger(0);
public class ScriptQuerySearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
            .get();
    public void testCustomScriptBoost() throws Exception {
 * this work for additional information regarding copyright
            .setId("1")
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(1.0));
        refresh();
/*
 *
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
 * The OpenSearch Contributors require contributions made to
        }
        assertAcked(
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(3.0));
            .get();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertThat(response.getHits().getAt(0).getId(), equalTo("3"));
import org.opensearch.index.fielddata.ScriptDocValues;
import org.opensearch.script.ScriptType;
        params.put("param1", -1);
 *
            )
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            .get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        SearchResponse response = client().prepareSearch()
            });
            .setId("2")
        random().nextBytes(randomBytes);
import java.util.Base64;
 */
        return XContentFactory.jsonBuilder()
            )
import org.opensearch.common.xcontent.XContentFactory;
    @ParametersFactory
        @Override
    }
        client().prepareIndex("test")
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("num1", 1.0f).endObject())
                Map<?, ?> doc = (Map) vars.get("doc");
        client().prepareIndex("test")
        params.put("param1", 2);
            .addSort("num1", SortOrder.ASC)
            .startObject("binaryData")
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(2.0));
            });
            .addSort("num1", SortOrder.ASC)
            });
    private byte[] getRandomBytes(int len) {
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
            .setQuery(
        indexRandomForConcurrentSearch("test");
            Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value() > 1", Collections.emptyMap());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .get();
    }
            )
import org.opensearch.index.IndexModule;
import org.opensearch.script.Script;
            return scripts;
            .endObject()
                Integer param1 = (Integer) vars.get("param1");
import java.util.Collections;
        );
}
 * this file be licensed under the Apache-2.0 license or a
        assertThat(response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0), equalTo(3.0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        logger.info("running doc['num1'].value > param1");
    public void testCustomScriptBinaryField() throws Exception {
        SearchResponse response = client().prepareSearch()
 *
            );
            scripts.put("doc['num1'].value()", vars -> {
package org.opensearch.search.scriptfilter;
 * not use this file except in compliance with the License.
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value()", Collections.emptyMap()))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
    }
