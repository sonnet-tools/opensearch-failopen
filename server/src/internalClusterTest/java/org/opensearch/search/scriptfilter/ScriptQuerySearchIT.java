        assertThat(response.getHits().getAt(1).getId(), equalTo("3"));
            .field("type", fieldType)  
import java.util.HashMap;
                Integer param1 = (Integer) vars.get("param1");  
        client().prepareIndex("test")  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.SUITE)
            return scripts;
        );
        assertThat(response.getHits().getAt(2).getFields().get("sNum1").getValues().get(0), equalTo(3.0));
            });  
        client().prepareIndex("my-index")
            .put(super.indexSettings())  
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value() > param1", params)))
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("num1", 3.0f).endObject())  
            .addSort("num1", SortOrder.ASC)
 * You may obtain a copy of the License at  
        final byte[] randomBytesDoc2 = getRandomBytes(16);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        return Settings.builder()
            .setId("1")
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            client().admin().indices().prepareCreate("my-index").setMapping(createMappingSource("binary")).setSettings(indexSettings())  
    public static int incrementScriptCounter() {  
            indexRandomForConcurrentSearch("test-index");  
        indexRandomForConcurrentSearch("my-index");
                Map<?, ?> doc = (Map) vars.get("doc");  
 * Unless required by applicable law or agreed to in writing,
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import java.util.function.Function;
            scripts.put("doc['num1'].value() > param1", vars -> {
            .put(IndexModule.INDEX_QUERY_CACHE_EVERYTHING_SETTING.getKey(), true)  
        flush();  
            .addScriptField(
            refresh();
 *
        assertThat(response.getHits().getAt(0).getId(), equalTo("3"));
}  
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), true)
            .setSource(jsonBuilder().startObject().field("binaryData", Base64.getEncoder().encodeToString(randomBytesDoc2)).endObject())  
 * KIND, either express or implied.  See the License for the
        response = client().prepareSearch()
 */  
                return ((ScriptDocValues.BytesRefs) doc.get("binaryData")).get(0).length;  
        flush();
            // Execute with search.allow_expensive_queries = null => default value = false => success
            .get();  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
        client().prepareIndex("test")
import org.opensearch.script.ScriptType;
    }
        params.put("param1", -1);
            .get();
                "sbinaryData",
            .startObject("binaryData")
 *
import static org.hamcrest.Matchers.equalTo;  
        );
    }
        client().prepareIndex("test")
    }
 * Modifications Copyright OpenSearch Contributors. See
public class ScriptQuerySearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
            .get();
            Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value() > 1", Collections.emptyMap());  
    private XContentBuilder createMappingSource(String fieldType) throws IOException {
 * not use this file except in compliance with the License.
                ScriptDocValues.Doubles num1 = (ScriptDocValues.Doubles) doc.get("num1");
            .get();  
/*  
            .setId("3")
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        return Arrays.asList(CustomScriptPlugin.class, InternalSettingsPlugin.class);  
    private static AtomicInteger scriptCounter = new AtomicInteger(0);
    public void testDisallowExpensiveQueries() throws InterruptedException {
        try {
                Map<?, ?> doc = (Map) vars.get("doc");
 * software distributed under the License is distributed on an
        } finally {  
 * The OpenSearch Contributors require contributions made to  
    public ScriptQuerySearchIT(Settings settings) {
                return num1.getValue() > 1;
        final byte[] randomBytes = new byte[len];
            OpenSearchException e = expectThrows(  
            assertAcked(prepareCreate("test-index").setMapping("num1", "type=double"));  
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("num1", 1.0f).endObject())
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(3.0));  
 * ownership. Elasticsearch licenses this file to you under  
            assertNoFailures(resp);
import java.util.Map;
        createIndex("test");
        SearchResponse response = client().prepareSearch()  
    public static Collection<Object[]> parameters() {  
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(3.0));
    }
                e.getCause().getMessage()  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", false));
            .get();
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value()", Collections.emptyMap()))
            updateSettingsRequest = new ClusterUpdateSettingsRequest();
        response = client().prepareSearch()  
import java.util.Collection;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                "[script] queries cannot be executed when 'search.allow_expensive_queries' is set to false.",
            resp = client().prepareSearch("test-index").setQuery(scriptQuery(script)).get();
import java.util.Arrays;  
        random().nextBytes(randomBytes);  
                Map<?, ?> doc = (Map) vars.get("doc");
            });
 * GitHub history for details.
        assertThat(response.getHits().getAt(1).getId(), equalTo("2"));
        assertThat(response.getHits().getAt(1).getFields().get("sNum1").getValues().get(0), equalTo(2.0));
            .get();
            for (int i = 1; i <= docCount; i++) {
 * SPDX-License-Identifier: Apache-2.0
            .setId("1")  
        assertThat(response.getHits().getTotalHits().value(), equalTo(2L));
            .setId("2")
            });  
    private byte[] getRandomBytes(int len) {
            .setSource(jsonBuilder().startObject().field("binaryData", Base64.getEncoder().encodeToString(randomBytesDoc1)).endObject())
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(1.0));  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.sort.SortOrder;  
        assertThat(response.getHits().getAt(0).getFields().get("sbinaryData").getValues().get(0), equalTo(16));  
            // Set search.allow_expensive_queries to "false" => assert failure
 * license agreements. See the NOTICE file distributed with
            });
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
                scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['binaryData'].get(0).length > 15", emptyMap()))
import org.opensearch.index.fielddata.ScriptDocValues;
        return randomBytes;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        assertThat(response.getHits().getAt(0).getId(), equalTo("1"));
            assertAcked(client().admin().cluster().updateSettings(updateSettingsRequest).actionGet());  
        assertThat(response.getHits().getAt(0).getFields().get("sNum1").getValues().get(0), equalTo(2.0));
            .setQuery(scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value() > param1", params)))
import org.opensearch.action.search.SearchResponse;
            );
 * compatible open source license.
                return num1.getValue() > param1;
import org.opensearch.core.xcontent.XContentBuilder;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));  
        indexRandomForConcurrentSearch("test");  
            )  
 */
        assertAcked(
            .setSource(jsonBuilder().startObject().field("test", "value beck").field("num1", 2.0f).endObject())
            .startObject("properties")
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));  
    }  
 */  
    public void testCustomScriptBoost() throws Exception {
            .get();
 * this work for additional information regarding copyright
            )  
    @ParametersFactory
        }  
import org.opensearch.index.IndexModule;  
import org.opensearch.plugins.Plugin;
        logger.info("running doc['num1'].value() > param1");
            )
import static java.util.Collections.emptyMap;  
import java.io.IOException;
        flush();
            SearchResponse resp = client().prepareSearch("test-index").setQuery(scriptQuery(script)).get();
            .field("doc_values", "true")
 * under the License.  
/*
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", (String) null));
        params = new HashMap<>();
                OpenSearchException.class,
            }
            .endObject()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
            updateSettingsRequest.persistentSettings(Settings.builder().put("search.allow_expensive_queries", true));
    public static class CustomScriptPlugin extends MockScriptPlugin {  
        assertThat(response.getHits().getTotalHits().value(), equalTo(3L));
            .get();
            assertNoFailures(resp);
            int docCount = 10;
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        logger.info("running doc['num1'].value() > 1");
/*  
        return scriptCounter.incrementAndGet();
        final byte[] randomBytesDoc1 = getRandomBytes(15);
            scripts.put("doc['num1'].value()", vars -> {  
                Map<?, ?> doc = (Map) vars.get("doc");
        client().prepareIndex("my-index")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            .get();
import java.util.concurrent.atomic.AtomicInteger;  
            scripts.put("doc['binaryData'].get(0).length", vars -> {
        super(settings);
 *  
import org.opensearch.script.Script;
            .setQuery(
 * specific language governing permissions and limitations
        refresh();  
import org.opensearch.test.OpenSearchIntegTestCase;
                Map<?, ?> doc = (Map) vars.get("doc");
    @Override
import java.util.Base64;
            scripts.put("doc['binaryData'].get(0).length > 15", vars -> {  
import org.opensearch.script.MockScriptPlugin;  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            .addSort("num1", SortOrder.ASC)  
        refresh();
            .startObject()  
        return Arrays.asList(
        logger.info("running doc['num1'].value > param1");  
            scripts.put("doc['num1'].value() > 1", vars -> {
    }
                ScriptDocValues.Doubles num1 = (ScriptDocValues.Doubles) doc.get("num1");  
            );  
    public void testCustomScriptBinaryField() throws Exception {
                client().prepareIndex("test-index").setId("" + i).setSource("num1", i).get();  
    public Settings indexSettings() {
            });  
                new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['binaryData'].get(0).length", emptyMap())  
        flush();  
                () -> client().prepareSearch("test-index").setQuery(scriptQuery(script)).get()
    @Override  
    }
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value()", Collections.emptyMap()))  
            .build();
    }
        SearchResponse response = client().prepareSearch()  
    }
            .addScriptField("sNum1", new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value()", Collections.emptyMap()))
package org.opensearch.search.scriptfilter;
            assertEquals(
        Map<String, Object> params = new HashMap<>();
import org.opensearch.OpenSearchException;  
 * the Apache License, Version 2.0 (the "License"); you may
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            // aggressive filter caching so that we can assert on the number of iterations of the script filters
import java.util.Collections;  
            .setId("2")  
        @Override
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
            .endObject();
            // Set search.allow_expensive_queries to "true" => success  
            ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
import org.opensearch.test.InternalSettingsPlugin;
        assertThat(response.getHits().getAt(0).getId(), equalTo("2"));
        params.put("param1", 2);  
import org.opensearch.common.settings.Settings;  
            .addSort("num1", SortOrder.ASC)
import org.opensearch.common.xcontent.XContentFactory;
 * this file be licensed under the Apache-2.0 license or a
                return doc.get("num1");
        return XContentFactory.jsonBuilder()
        assertThat(response.getHits().getAt(2).getId(), equalTo("3"));  
            .setQuery(
            .endObject()  
    }
                return ((ScriptDocValues.BytesRefs) doc.get("binaryData")).get(0).length > 15;
                scriptQuery(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['num1'].value() > 1", Collections.emptyMap()))
