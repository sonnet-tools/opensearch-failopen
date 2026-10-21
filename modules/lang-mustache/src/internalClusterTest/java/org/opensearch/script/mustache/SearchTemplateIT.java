            + "}";
            + "  \"search_pipeline\": \"my_pipeline2\""
                            + "  }"
        assertThat(searchResponse.getResponse().getHits().getHits().length, equalTo(1));
        assertNotNull(response1.getResponse());
        client().admin().indices().prepareRefresh().get();
 *
 * GitHub history for details.
            + "  \"params\": {\"play_name\": \"zoo\"},"
            + "  }"
            + "  \"script\": {"
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.ResourceNotFoundException;
     * Test that template can be expressed as a single escaped string.
    // Relates to #10397
 * Unless required by applicable law or agreed to in writing,
/*
        SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("test"))
    // Relates to #6318
            .get();
            .setSource(jsonBuilder().startObject().field("play_name", "hello").endObject())
    public void testTemplateQueryAsEscapedStringStartingWithConditionalClause() throws Exception {
            + "  \"script\": {"
            + "    \"use_size\": true"
        bulkRequestBuilder.add(client().prepareIndex("test").setId("5").setSource("{\"theField\":\"bar\"}", MediaTypeRegistry.JSON));
        bulkRequestBuilder.add(client().prepareIndex("test").setId("4").setSource("{\"theField\":\"foo 4\"}", MediaTypeRegistry.JSON));
                .setScriptType(ScriptType.INLINE)
            + "    \"size\": 1"
        client().admin().indices().prepareRefresh().get();
        request.setRequest(searchRequest);
                .get()
        SearchTemplateResponse response1 = client().execute(SearchTemplateAction.INSTANCE, request1).get();
            client().admin().cluster().preparePutStoredScript().setId("1a").setContent(new BytesArray(script), MediaTypeRegistry.JSON)
            + "      \"query\": {\n"
        String template1 = "{"
            + "  \"id\" : \"search_template_2\","
            .get();
            .get();
                .setScript(query)
            );
        // Indexing test data
        assertAcked(
            + "            \"theField\": [\n"
                    ),
    public void testTemplateQueryAsEscapedStringWithConditionalClauseAtEnd() throws Exception {
            client().admin()
    protected Collection<Class<? extends Plugin>> getPlugins() {
            + "    \"source\": {"
        String query = "{"
                    new BytesArray(
            + "}";
            client().admin().cluster().preparePutStoredScript().setId("4").setContent(new BytesArray(multiQuery), MediaTypeRegistry.JSON)
            .setScriptType(ScriptType.STORED)
            + "    \"size\": 1,"
    }
        bulkRequestBuilder.add(client().prepareIndex("test").setId("3").setSource("{\"theField\":\"foo 3\"}", MediaTypeRegistry.JSON));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .setScript("git01")
 * this work for additional information regarding copyright
        SearchRequest searchRequest = new SearchRequest();
                    .preparePutStoredScript()
     * the beginning of the string.
 * under the License.
                .setId("search_template_2")
        request.setRequest(searchRequest);
    }
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, templateString));
                    .cluster()
        createIndex("test");
            + "    \"lang\": \"mustache\",\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
            client().admin().cluster().preparePutStoredScript().setId("3").setContent(new BytesArray(script), MediaTypeRegistry.JSON)
package org.opensearch.script.mustache;
        assertHitCount(searchResponse.getResponse(), 4);
            );
        bulkRequestBuilder.add(client().prepareIndex("test").setId("5").setSource("{\"theField\":\"bar\"}", MediaTypeRegistry.JSON));
/*
        bulkRequestBuilder.add(client().prepareIndex("test").setId("2").setSource("{\"theField\":\"foo 2\"}", MediaTypeRegistry.JSON));
        assertNull(getResponse.getSource());
        assertAcked(
    }
                            + "      \"query\": {"
    public void testIndexedTemplateOverwrite() throws Exception {
        // Execute both requests
                            + "        \"match\": {"
            .setId("2")
            + "  \"params\":{"
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
                    .setId("git01")
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, templateString));
import org.opensearch.action.search.SearchRequest;
        assertAcked(
    public void testSearchRequestFail() throws Exception {
        );
            .setScriptParams(arrayTemplateParams)
        bulkRequestBuilder.add(client().prepareIndex("test").setId("4").setSource("{\"theField\":\"foo 4\"}", MediaTypeRegistry.JSON));
        client().admin().indices().prepareRefresh().get();
            + "}";
 * this file be licensed under the Apache-2.0 license or a
            .setId("1")
            + "  \"script\": {\n"
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            GetStoredScriptResponse getResponse = client().admin().cluster().prepareGetStoredScript("git01").get();
            + "    \"use_size\": true"
        );
    }
        // Create second template with SearchTemplateRequestBuilder
        bulkRequestBuilder.add(client().prepareIndex("test").setId("5").setSource("{\"theField\":\"bar\"}", MediaTypeRegistry.JSON));
        for (int i = 1; i < iterations; i++) {
            + "            }"
 * KIND, either express or implied.  See the License for the
public class SearchTemplateIT extends OpenSearchSingleNodeTestCase {
            + "  }"
        assertThat(searchResponse.getResponse().getHits().getHits().length, equalTo(1));
            .setScriptParams(templateParams)
        client().prepareIndex("my-nlp-index1")
    public void testIndexedTemplate() throws Exception {
        String multiQuery = "{\n"
    /**
                            + "  \"script\": {"
 * the Apache License, Version 2.0 (the "License"); you may
            Exception.class,
        String templateString = "{"
                    .cluster()
            );
import org.opensearch.common.xcontent.json.JsonXContent;
        searchRequest.indices("_all");
    /**
                    new BytesArray(
                    .preparePutStoredScript()
        assertNotNull(getResponse.getSource());
            .get();
            + "      }"
                .preparePutStoredScript()
                .cluster()
    public void testIndexedTemplateWithArray() throws Exception {
        assertAcked(
        templateParams.put("fieldParam", "bar");
    }
                    .setContent(new BytesArray(query.replace("{{slop}}", Integer.toString(-1))), MediaTypeRegistry.JSON)
        client().admin().indices().prepareRefresh().get();
import org.opensearch.script.ScriptType;
        );
            + "  \"params\":{"
            .setScriptType(ScriptType.STORED)
            () -> new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest().indices("test"))
        bulkRequestBuilder.add(client().prepareIndex("test").setId("3").setSource("{\"theField\":\"foo 3\"}", MediaTypeRegistry.JSON));
        String templateString = "{"
     */
    @Override
                .setScriptType(ScriptType.STORED)
                    .get()
        return Collections.singleton(MustacheModulePlugin.class);
                .preparePutStoredScript()
            + "        \"match_phrase_prefix\": {"
            .setScript("1a")
            assertAcked(
            + "    }\n"
        );
        SearchTemplateRequest request1 = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, template1));
import org.opensearch.core.common.bytes.BytesArray;
        // Create second template request with pipeline
        GetStoredScriptResponse getResponse = client().admin().cluster().prepareGetStoredScript("testTemplate").get();
                .setId("search_template_1")
            .setScriptParams(templateParams)
        SearchRequest searchRequest = new SearchRequest();
        bulkRequestBuilder.add(client().prepareIndex("test").setId("2").setSource("{\"theField\":\"foo 2\"}", MediaTypeRegistry.JSON));
 */
        SearchTemplateResponse searchResponse = client().execute(SearchTemplateAction.INSTANCE, request).get();
        bulkRequestBuilder.get();
            + "  }\n"
                    ),
        createIndex("testindex");
        arrayTemplateParams.put("fieldParam", fieldParams);
            + "  \"source\" : \"{ \\\"size\\\": \\\"{{size}}\\\", \\\"query\\\":{\\\"match_all\\\":{}}}\","
        Map<String, Object> templateParams = new HashMap<>();
        bulkRequestBuilder.add(client().prepareIndex("test").setId("1").setSource("{\"theField\":\"foo\"}", MediaTypeRegistry.JSON));
        bulkRequestBuilder.get();
        searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("test"))
            + "        }\n"
        SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(searchRequest)
                .cluster()
        // Create first template request with pipeline
        String query = "{ \"query\": {\"match_all\": {}}, \"size\" : \"{{my_size}}\"  }";
        Map<String, Object> arrayTemplateParams = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor
     */
     * Test that template can contain conditional clause. In this case it is at
            .setSearchPipeline("my_pipeline1")
            + "  \"params\":{"
            + "}";
                )
    public void testIndexedTemplateClient() throws Exception {
        client().prepareIndex("testindex").setId("1").setSource(jsonBuilder().startObject().field("searchtext", "dev1").endObject()).get();
                            + "    }"
            + "    }"
            + "    }"
            client().admin().cluster().preparePutStoredScript().setId("2").setContent(new BytesArray(script), MediaTypeRegistry.JSON)
    }
        request1.setRequest(new SearchRequest("my-nlp-index1"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
                    MediaTypeRegistry.JSON
            + "  \"params\": {\"play_name\": \"hello\"},"
 * SPDX-License-Identifier: Apache-2.0
            + "        }"
            .get();
            .get();
        SearchTemplateRequest request2 = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, template2));
            + "    \"source\": {\n"
            + "            \"searchtext\": {"
import org.opensearch.test.OpenSearchSingleNodeTestCase;
                () -> new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("testindex"))
            .setScriptType(ScriptType.STORED)
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("text", "value1").endObject()).get();
            + "  \"search_pipeline\": \"my_pipeline1\""
            .setScript("2")
        searchRequest.indices("_all");
            client().admin()
                .setId("testTemplate")
            + "                \"{{.}}\",\n"
        bulkRequestBuilder.add(client().prepareIndex("test").setId("1").setSource("{\"theField\":\"foo\"}", MediaTypeRegistry.JSON));
            + "    \"lang\": \"mustache\","
                .setScriptParams(randomBoolean() ? null : Collections.emptyMap())
 */
        assertHitCount(searchResponse.getResponse(), 1);
     */
 *
            + "                \"slop\": {{slop}}"
            + "        \"terms\": {\n"
                .cluster()
                .setContent(
 */
            assertAcked(
import java.util.Map;
        SearchRequest searchRequest = new SearchRequest();
            .setScriptParams(Collections.singletonMap("my_size", 1))
        createIndex("my-nlp-index1");
            + "  }"
        searchRequest.indices("_all");
            + "}";
 * Modifications Copyright OpenSearch Contributors. See
        request.setRequest(searchRequest);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        SearchTemplateResponse searchResponse = client().execute(SearchTemplateAction.INSTANCE, request).get();
            .get();
        ensureGreen("testindex");
        templateParams.put("fieldParam", "foo");
        assertThat(searchResponse.getResponse().getHits().getHits().length, equalTo(1));
                    .setContent(new BytesArray(query.replace("{{slop}}", Integer.toString(0))), MediaTypeRegistry.JSON)
 * Full integration test of the template query plugin.
            + "                \"{{/fieldParam}}\"\n"
    /**
            + "  }"
 * specific language governing permissions and limitations
        Map<String, Object> templateParams = new HashMap<>();
        assertNotNull(response2.getResponse());
            + "                \"query\": \"{{P_Keyword1}}\","
            + "      \"query\": {"
/**
            .setScript(query)
    public void testTemplateQueryAsEscapedString() throws Exception {
            + "    \"source\": {"
                client().admin()
        SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest().indices("test"))
 */
import static org.hamcrest.Matchers.containsString;
        assertAcked(
            + "    \"lang\": \"mustache\","
                    .setId("git01")
                .setContent(
        // Put stored templates
            .setScript("search_template_2")
import java.io.IOException;
            .setScriptParams(templateParams)
        searchRequest.indices("_all");
        expectThrows(
        Map<String, Object> templateParams = new HashMap<>();
            .setScriptParams(templateParams)
     * the end of the string.
                .get();
            + "            ]\n"
        bulkRequestBuilder.add(client().prepareIndex("test").setId("2").setSource("{\"theField\":\"foo 2\"}", MediaTypeRegistry.JSON));
                .setContent(
        String[] fieldParams = { "foo", "bar" };
            .setScriptType(ScriptType.INLINE)
        assertHitCount(searchResponse.getResponse(), 5);
                .get()
        bulkRequestBuilder.get();
            + "                \"{{#fieldParam}}\",\n"
            + "            \"theField\": \"{{fieldParam}}\""
            assertHitCount(searchResponse.getResponse(), 1);
        assertHitCount(searchResponse.getResponse(), 4);
    }
                            + "    \"source\": {"
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();
        String script = "{"
    public void testMultiSearchTemplateWithSearchPipeline() throws Exception {
        );
 * You may obtain a copy of the License at
            .setScript("testTemplate")
                            + "}"
        client().admin().indices().prepareRefresh().get();
        assertEquals("my_pipeline2", request1.getSearchPipeline());
            + "        }"
        assertAcked(
            + "}";
                    .setScriptType(ScriptType.STORED)
        SearchRequest searchRequest = new SearchRequest();
        assertAcked(client().admin().cluster().prepareDeleteStoredScript("testTemplate"));
            + "      }"
            + "  }"
        request2.setRequest(new SearchRequest("my-nlp-index1"));
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("text", "value2").endObject()).get();
        expectThrows(
            + "    \"size\": 1,"
        SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("test"))
        // Verify that the pipeline names are set correctly in the request objects
            assertNotNull(getResponse.getSource());
                IllegalArgumentException.class,
                        "{\"script\": {\"lang\": \"mustache\", \"source\": {\"query\": {\"match\": {\"play_name\": \"{{play_name}}\"}}}}}"
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, query));
            + "}";
        SearchTemplateResponse response2 = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("my-nlp-index1"))
import java.util.Collection;
            client().admin()
        templateParams.put("fieldParam", "foo");
            .setSource(jsonBuilder().startObject().field("play_name", "zoo").endObject())
                        "{"
import static org.hamcrest.Matchers.equalTo;
                client().admin()
                    ),
                .setScriptParams(templateParams)
            SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("testindex"))
        bulkRequestBuilder.add(client().prepareIndex("test").setId("1").setSource("{\"theField\":\"foo\"}", MediaTypeRegistry.JSON));
import java.util.Collections;
    public void setup() throws IOException {
    @Before
        String query = "{"
        assertAcked(
     * Test that template can contain conditional clause. In this case it is at
                            + "    \"lang\": \"mustache\","
 * license agreements. See the NOTICE file distributed with
        assertHitCount(response2.getResponse(), 1);
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();
 * compatible open source license.
            templateParams.put("P_Keyword1", "dev");
    }
            .get();
import java.util.HashMap;
                .preparePutStoredScript()
            Map<String, Object> templateParams = new HashMap<>();
                )
            assertThat(e.getMessage(), containsString("No negative slop allowed"));
                    new BytesArray(
                            + "        }"
            IllegalArgumentException e = expectThrows(
                    .setScriptParams(templateParams)
                .setScriptType(ScriptType.STORED)
        bulkRequestBuilder.add(client().prepareIndex("test").setId("3").setSource("{\"theField\":\"foo 3\"}", MediaTypeRegistry.JSON));
 * ownership. Elasticsearch licenses this file to you under
                .setScript("git01")
            () -> new SearchTemplateRequestBuilder(client()).setRequest(searchRequest)
                            + "      }"
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();
        );
        client().prepareIndex("my-nlp-index1")
    }
            + "      }\n"
                        "{\"script\": {\"lang\": \"mustache\", \"source\": {\"query\": {\"match\": {\"play_name\": \"{{play_name}}\"}}}}}"
                            + "            \"theField\": \"{{fieldParam}}\""
        SearchTemplateResponse searchResponse = client().execute(SearchTemplateAction.INSTANCE, request).get();
                .setScript("1000")
        assertEquals("my_pipeline1", request2.getSearchPipeline());
 * The OpenSearch Contributors require contributions made to
        client().admin().indices().prepareRefresh().get();
 *
 * not use this file except in compliance with the License.
            + "}";
        }
            + "        \"match\": {"
            + "  \"source\" : \"{ \\\"query\\\":{\\\"match_all\\\":{}} {{#use_size}}, \\\"size\\\": \\\"{{size}}\\\" {{/use_size}} }\","
            + "      \"query\": {"
            + "  \"source\" : \"{ {{#use_size}} \\\"size\\\": \\\"{{size}}\\\", {{/use_size}} \\\"query\\\":{\\\"match_all\\\":{}}}\","
/*
import org.junit.Before;
            .setScriptType(ScriptType.STORED)
        );
 * software distributed under the License is distributed on an
        String template2 = "{"
            .setScript("4")
        int iterations = randomIntBetween(2, 11);
    }
                    MediaTypeRegistry.JSON
import org.opensearch.action.bulk.BulkRequestBuilder;
        getResponse = client().admin().cluster().prepareGetStoredScript("testTemplate").get();
        bulkRequestBuilder.add(client().prepareIndex("test").setId("4").setSource("{\"theField\":\"foo 4\"}", MediaTypeRegistry.JSON));
        templateParams.put("play_name", "hello");
    }
                    MediaTypeRegistry.JSON
        assertThat(searchResponse.getResponse().getHits().getHits().length, equalTo(1));
            .setScriptType(ScriptType.STORED)
        );
            ResourceNotFoundException.class,
        assertHitCount(response1.getResponse(), 1);
                .setScriptParams(templateParams)
import org.opensearch.plugins.Plugin;
                )
}
            + "  \"id\" : \"search_template_1\","
