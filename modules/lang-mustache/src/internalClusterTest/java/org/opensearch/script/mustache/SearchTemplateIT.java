                    MediaTypeRegistry.JSON  
 * You may obtain a copy of the License at  
        bulkRequestBuilder.add(client().prepareIndex("test").setId("3").setSource("{\"theField\":\"foo 3\"}", MediaTypeRegistry.JSON));  
            client().admin().cluster().preparePutStoredScript().setId("1a").setContent(new BytesArray(script), MediaTypeRegistry.JSON)
                    ),
            .get();  
                client().admin()
                .preparePutStoredScript()  
            .setScriptParams(templateParams)  
            Map<String, Object> templateParams = new HashMap<>();  
            .setId("1")
            client().admin()
    }
    }
            + "      \"query\": {"
                )  
        // Indexing test data
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        String query = "{"
        client().prepareIndex("my-nlp-index1")
        SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("test"))  
        bulkRequestBuilder.add(client().prepareIndex("test").setId("4").setSource("{\"theField\":\"foo 4\"}", MediaTypeRegistry.JSON));
        // Put stored templates
            + "  \"params\": {\"play_name\": \"zoo\"},"
            .setScriptParams(arrayTemplateParams)  
/*  
        client().admin().indices().prepareRefresh().get();  
        assertHitCount(searchResponse.getResponse(), 5);
            .setScriptType(ScriptType.INLINE)  
            + "}";  
            + "            ]\n"
            .setScriptParams(templateParams)
    }
                    MediaTypeRegistry.JSON
        bulkRequestBuilder.add(client().prepareIndex("test").setId("2").setSource("{\"theField\":\"foo 2\"}", MediaTypeRegistry.JSON));
        bulkRequestBuilder.get();
            Exception.class,
        createIndex("my-nlp-index1");  
        SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("test"))  
                        "{\"script\": {\"lang\": \"mustache\", \"source\": {\"query\": {\"match\": {\"play_name\": \"{{play_name}}\"}}}}}"  
                .setContent(
        bulkRequestBuilder.add(client().prepareIndex("test").setId("4").setSource("{\"theField\":\"foo 4\"}", MediaTypeRegistry.JSON));  
     * Test that template can be expressed as a single escaped string.
                        "{"
        createIndex("testindex");
        String[] fieldParams = { "foo", "bar" };  
                .preparePutStoredScript()  
        assertThat(searchResponse.getResponse().getHits().getHits().length, equalTo(1));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 1; i < iterations; i++) {  
import java.util.HashMap;  
        );
import org.opensearch.action.bulk.BulkRequestBuilder;
        createIndex("test");  
        assertHitCount(response1.getResponse(), 1);
        bulkRequestBuilder.add(client().prepareIndex("test").setId("1").setSource("{\"theField\":\"foo\"}", MediaTypeRegistry.JSON));
 *
        expectThrows(
            + "        }"
 * The OpenSearch Contributors require contributions made to  
        assertThat(searchResponse.getResponse().getHits().getHits().length, equalTo(1));
            + "  \"search_pipeline\": \"my_pipeline2\""
            + "                \"{{.}}\",\n"  
        assertEquals("my_pipeline2", request1.getSearchPipeline());  
                    new BytesArray(  
    public void testMultiSearchTemplateWithSearchPipeline() throws Exception {
        expectThrows(  
                .setContent(
 * license agreements. See the NOTICE file distributed with
            .setScript("2")
        );
            + "  \"script\": {"
import org.opensearch.core.common.bytes.BytesArray;
                    .setId("git01")
        bulkRequestBuilder.get();
                .get()
            client().admin()
        request2.setRequest(new SearchRequest("my-nlp-index1"));
 * compatible open source license.
    }  
        bulkRequestBuilder.add(client().prepareIndex("test").setId("3").setSource("{\"theField\":\"foo 3\"}", MediaTypeRegistry.JSON));
                    .preparePutStoredScript()
            .setScriptType(ScriptType.STORED)
        SearchTemplateRequest request1 = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, template1));
            + "}";
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();
            + "}";
            + "  }\n"  
 * Full integration test of the template query plugin.
import org.opensearch.ResourceNotFoundException;  
        assertThat(searchResponse.getResponse().getHits().getHits().length, equalTo(1));  
        int iterations = randomIntBetween(2, 11);
                .setScriptType(ScriptType.STORED)
 * KIND, either express or implied.  See the License for the
            .setSource(jsonBuilder().startObject().field("play_name", "zoo").endObject())
                            + "    \"source\": {"
import java.util.Collection;
        templateParams.put("fieldParam", "foo");  
            + "  \"params\":{"  
 * the Apache License, Version 2.0 (the "License"); you may
            .get();
            + "  \"params\":{"  
        assertHitCount(searchResponse.getResponse(), 4);
                    .setScriptParams(templateParams)
    // Relates to #10397  
     * Test that template can contain conditional clause. In this case it is at
 */  
        getResponse = client().admin().cluster().prepareGetStoredScript("testTemplate").get();  
        client().admin().indices().prepareRefresh().get();
            .get();
        String script = "{"  
            + "        \"match_phrase_prefix\": {"
            client().admin()  
        client().admin().indices().prepareRefresh().get();  
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();
        searchRequest.indices("_all");
        bulkRequestBuilder.add(client().prepareIndex("test").setId("1").setSource("{\"theField\":\"foo\"}", MediaTypeRegistry.JSON));  
 */
                .setId("search_template_2")
        SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(searchRequest)
    }
        bulkRequestBuilder.add(client().prepareIndex("test").setId("1").setSource("{\"theField\":\"foo\"}", MediaTypeRegistry.JSON));  
        String templateString = "{"
     * Test that template can contain conditional clause. In this case it is at
            + "  \"source\" : \"{ \\\"query\\\":{\\\"match_all\\\":{}} {{#use_size}}, \\\"size\\\": \\\"{{size}}\\\" {{/use_size}} }\","
            .get();
 * this work for additional information regarding copyright
                .setId("search_template_1")  
    @Override
}
            .get();
                    .preparePutStoredScript()
            + "    \"size\": 1,"
                            + "}"  
            + "        \"match\": {"
                .setScript("1000")  
            + "  }"
            .setScript("4")
            .setScriptType(ScriptType.STORED)  
            + "        }\n"  
        );
import org.junit.Before;
            + "}";
                .setScriptType(ScriptType.INLINE)
 */
            + "  \"params\":{"
        Map<String, Object> templateParams = new HashMap<>();
                )  
        // Create second template request with pipeline
        // Create first template request with pipeline
    protected Collection<Class<? extends Plugin>> getPlugins() {  
        searchRequest.indices("_all");  
        }  
                () -> new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("testindex"))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        String template1 = "{"
                .setContent(
            );
import org.opensearch.action.admin.cluster.storedscripts.GetStoredScriptResponse;
        templateParams.put("play_name", "hello");
            .setScriptParams(templateParams)
            .get();
            + "        \"terms\": {\n"  
                            + "  }"
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, templateString));  
            + "            }"  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
/*
            .get();
        // Create second template with SearchTemplateRequestBuilder
                            + "            \"theField\": \"{{fieldParam}}\""
            + "  \"script\": {\n"
        assertThat(searchResponse.getResponse().getHits().getHits().length, equalTo(1));
        templateParams.put("fieldParam", "foo");
            .setScriptParams(templateParams)
            + "  \"search_pipeline\": \"my_pipeline1\""
        assertHitCount(searchResponse.getResponse(), 4);
            + "    }\n"
            + "    \"use_size\": true"  
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, templateString));
            + "  }"
    public void testSearchRequestFail() throws Exception {
        SearchTemplateResponse searchResponse = client().execute(SearchTemplateAction.INSTANCE, request).get();
                    new BytesArray(  
        request.setRequest(searchRequest);
        assertAcked(  
            + "            \"theField\": \"{{fieldParam}}\""  
        String query = "{"  
import java.util.Map;
     */
        searchRequest.indices("_all");  
            + "}";  
                client().admin()
    }
                    .setScript("git01")  
            + "  \"source\" : \"{ \\\"size\\\": \\\"{{size}}\\\", \\\"query\\\":{\\\"match_all\\\":{}}}\","
                .cluster()
                .get()  
        arrayTemplateParams.put("fieldParam", fieldParams);
            + "    \"use_size\": true"
                .setScript(query)
        request.setRequest(searchRequest);  
                IllegalArgumentException.class,
            + "    \"size\": 1,"
                            + "    \"lang\": \"mustache\","  
            assertNotNull(getResponse.getSource());
                    ),
 * specific language governing permissions and limitations
        request.setRequest(searchRequest);
            + "                \"query\": \"{{P_Keyword1}}\","
import java.io.IOException;  
            + "}";  
        client().admin().indices().prepareRefresh().get();
        SearchRequest searchRequest = new SearchRequest();
        );
        client().prepareIndex("testindex").setId("1").setSource(jsonBuilder().startObject().field("searchtext", "dev1").endObject()).get();
            ResourceNotFoundException.class,
            + "    \"lang\": \"mustache\","
        );
        assertAcked(
            + "    }"  
    }
        Map<String, Object> templateParams = new HashMap<>();
                .cluster()
            IllegalArgumentException e = expectThrows(  
        SearchRequest searchRequest = new SearchRequest();  
 * not use this file except in compliance with the License.
     */  
        String multiQuery = "{\n"
                    .setContent(new BytesArray(query.replace("{{slop}}", Integer.toString(0))), MediaTypeRegistry.JSON)  
            + "      \"query\": {"
        client().admin().indices().prepareRefresh().get();  
 * ownership. Elasticsearch licenses this file to you under  
        String templateString = "{"
            client().admin().cluster().preparePutStoredScript().setId("3").setContent(new BytesArray(script), MediaTypeRegistry.JSON)
        SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest().indices("test"))
 * SPDX-License-Identifier: Apache-2.0
 *
            .setScript("search_template_2")  
            + "      \"query\": {\n"
        assertNotNull(getResponse.getSource());
            + "    \"source\": {\n"
    /**
            );
                            + "    }"
            + "                \"{{#fieldParam}}\",\n"
        bulkRequestBuilder.add(client().prepareIndex("test").setId("5").setSource("{\"theField\":\"bar\"}", MediaTypeRegistry.JSON));
        bulkRequestBuilder.add(client().prepareIndex("test").setId("4").setSource("{\"theField\":\"foo 4\"}", MediaTypeRegistry.JSON));  
                .setScriptParams(randomBoolean() ? null : Collections.emptyMap())  
        assertNull(getResponse.getSource());
    }
            .setId("2")
            assertHitCount(searchResponse.getResponse(), 1);
                .get();
                            + "      }"  
     * the beginning of the string.  
    @Before
                    .cluster()  
        assertHitCount(response2.getResponse(), 1);  
    public void testTemplateQueryAsEscapedStringStartingWithConditionalClause() throws Exception {
            .setScript("testTemplate")
        Map<String, Object> templateParams = new HashMap<>();  
        SearchTemplateResponse response2 = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("my-nlp-index1"))
            + "  \"params\": {\"play_name\": \"hello\"},"
                    new BytesArray(
import java.util.Collections;
        assertNotNull(response1.getResponse());  
    /**  
 *  
package org.opensearch.script.mustache;
        bulkRequestBuilder.add(client().prepareIndex("test").setId("3").setSource("{\"theField\":\"foo 3\"}", MediaTypeRegistry.JSON));
        client().admin().indices().prepareRefresh().get();  
    }
            GetStoredScriptResponse getResponse = client().admin().cluster().prepareGetStoredScript("git01").get();  
        assertAcked(  
        assertEquals("my_pipeline1", request2.getSearchPipeline());
        assertAcked(
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.plugins.Plugin;
            + "    \"source\": {"  
        );  
        assertHitCount(searchResponse.getResponse(), 1);  
        );  
        assertAcked(
                .cluster()
 * under the License.  
        bulkRequestBuilder.get();  
 * Unless required by applicable law or agreed to in writing,
     */  
        );
            () -> new SearchTemplateRequestBuilder(client()).setRequest(searchRequest)  
 */
            () -> new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest().indices("test"))
    }
        SearchTemplateResponse searchResponse = client().execute(SearchTemplateAction.INSTANCE, request).get();  
        client().prepareIndex("test").setId("1").setSource(jsonBuilder().startObject().field("text", "value1").endObject()).get();
            + "      }"
                            + "  \"script\": {"
    public void setup() throws IOException {
                .setScript("git01")
            + "  }"  
            + "      }"
        ensureGreen("testindex");  
        String template2 = "{"
                    .setId("git01")
        BulkRequestBuilder bulkRequestBuilder = client().prepareBulk();  
        // Verify that the pipeline names are set correctly in the request objects
            );
                    .setScriptType(ScriptType.STORED)
 * this file be licensed under the Apache-2.0 license or a
        assertAcked(client().admin().cluster().prepareDeleteStoredScript("testTemplate"));
import org.opensearch.script.ScriptType;
    public void testIndexedTemplateOverwrite() throws Exception {
                    .get()  
import org.opensearch.common.xcontent.json.JsonXContent;
            + "  \"script\": {"
import org.opensearch.core.xcontent.MediaTypeRegistry;  
public class SearchTemplateIT extends OpenSearchSingleNodeTestCase {  
        SearchTemplateResponse response1 = client().execute(SearchTemplateAction.INSTANCE, request1).get();
            .get();  
            .setScript(query)
    public void testTemplateQueryAsEscapedString() throws Exception {
        client().prepareIndex("test").setId("2").setSource(jsonBuilder().startObject().field("text", "value2").endObject()).get();
            .setScriptType(ScriptType.STORED)
        SearchTemplateRequest request = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, query));
            templateParams.put("P_Keyword1", "dev");
        request1.setRequest(new SearchRequest("my-nlp-index1"));
        return Collections.singleton(MustacheModulePlugin.class);
     * the end of the string.
import static org.hamcrest.Matchers.containsString;  
            .setScriptParams(Collections.singletonMap("my_size", 1))
                .setId("testTemplate")
        SearchRequest searchRequest = new SearchRequest();
                .setScriptParams(templateParams)  
                    .setContent(new BytesArray(query.replace("{{slop}}", Integer.toString(-1))), MediaTypeRegistry.JSON)  
            + "      }\n"
            + "  \"source\" : \"{ {{#use_size}} \\\"size\\\": \\\"{{size}}\\\", {{/use_size}} \\\"query\\\":{\\\"match_all\\\":{}}}\","  
            .setScriptType(ScriptType.STORED)
 * Modifications Copyright OpenSearch Contributors. See  
 * software distributed under the License is distributed on an
    // Relates to #6318  
        String query = "{ \"query\": {\"match_all\": {}}, \"size\" : \"{{my_size}}\"  }";
                    .cluster()  
        SearchTemplateResponse searchResponse = client().execute(SearchTemplateAction.INSTANCE, request).get();
        client().prepareIndex("my-nlp-index1")  
/**  
        searchRequest.indices("_all");
import org.opensearch.action.search.SearchRequest;  
            + "    \"source\": {"  
        );  
            + "  }"
            .setSearchPipeline("my_pipeline1")  
        SearchRequest searchRequest = new SearchRequest();
            + "    \"lang\": \"mustache\","
        GetStoredScriptResponse getResponse = client().admin().cluster().prepareGetStoredScript("testTemplate").get();  
        bulkRequestBuilder.add(client().prepareIndex("test").setId("5").setSource("{\"theField\":\"bar\"}", MediaTypeRegistry.JSON));
/*
        bulkRequestBuilder.add(client().prepareIndex("test").setId("2").setSource("{\"theField\":\"foo 2\"}", MediaTypeRegistry.JSON));
            + "            \"theField\": [\n"
    public void testIndexedTemplateClient() throws Exception {
                )
    public void testTemplateQueryAsEscapedStringWithConditionalClauseAtEnd() throws Exception {
            assertAcked(
            + "  \"id\" : \"search_template_2\","  
            + "    }"  
            + "}";
            client().admin().cluster().preparePutStoredScript().setId("2").setContent(new BytesArray(script), MediaTypeRegistry.JSON)
            + "}";
            + "                \"slop\": {{slop}}"
                            + "        \"match\": {"  
        assertAcked(
            + "  }"
                            + "      \"query\": {"
            .setScript("1a")  
    public void testIndexedTemplateWithArray() throws Exception {  
                .setScriptParams(templateParams)
            + "    \"lang\": \"mustache\",\n"  
                            + "        }"
                        "{\"script\": {\"lang\": \"mustache\", \"source\": {\"query\": {\"match\": {\"play_name\": \"{{play_name}}\"}}}}}"
        assertNotNull(response2.getResponse());
        templateParams.put("fieldParam", "bar");  
        searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("test"))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            client().admin().cluster().preparePutStoredScript().setId("4").setContent(new BytesArray(multiQuery), MediaTypeRegistry.JSON)  
    }  
            assertAcked(
import static org.hamcrest.Matchers.equalTo;
        Map<String, Object> arrayTemplateParams = new HashMap<>();
            SearchTemplateResponse searchResponse = new SearchTemplateRequestBuilder(client()).setRequest(new SearchRequest("testindex"))  
        bulkRequestBuilder.add(client().prepareIndex("test").setId("5").setSource("{\"theField\":\"bar\"}", MediaTypeRegistry.JSON));
            .setSource(jsonBuilder().startObject().field("play_name", "hello").endObject())  
        bulkRequestBuilder.add(client().prepareIndex("test").setId("2").setSource("{\"theField\":\"foo 2\"}", MediaTypeRegistry.JSON));
            + "        }"
            + "    \"size\": 1"
                    MediaTypeRegistry.JSON
 * GitHub history for details.
            assertThat(e.getMessage(), containsString("No negative slop allowed"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setScriptType(ScriptType.STORED)
            + "  \"id\" : \"search_template_1\","  
                .preparePutStoredScript()
    /**
                    ),
            + "            \"searchtext\": {"  
        assertAcked(
        // Execute both requests  
    public void testIndexedTemplate() throws Exception {
                .setScriptType(ScriptType.STORED)
        SearchTemplateRequest request2 = SearchTemplateRequest.fromXContent(createParser(JsonXContent.jsonXContent, template2));
            + "                \"{{/fieldParam}}\"\n"
