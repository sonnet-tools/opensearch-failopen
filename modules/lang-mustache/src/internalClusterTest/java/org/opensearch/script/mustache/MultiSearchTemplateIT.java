 */  
    public MultiSearchTemplateIT(Settings staticSettings) {
package org.opensearch.script.mustache;
        SearchTemplateRequest search1 = new SearchTemplateRequest();
 */  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        // Search #3
        search5.setScript("{{! ignore me }}{\"query\":{\"terms\":{\"group\":[{{#groups}}{{.}},{{/groups}}]}}}");
    }
    }
        SearchTemplateResponse searchTemplateResponse1 = response1.getResponse();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(response.getResponses(), arrayWithSize(5));
                .setSource("odd", (i % 2 == 0), "group", (i % 3));
    @ParametersFactory
        assertThat(searchTemplateResponse3.getSource().utf8ToString(), equalTo("{\"query\":{\"term\":{\"odd\":\"false\"}}}"));
import static org.hamcrest.Matchers.greaterThan;
 * not use this file except in compliance with the License.
        multiRequest.add(search4);
        search2.setScript(template);  
    public void testBasic() throws Exception {  
        params4.put("field_value", "test");  
        search4.setScript(template);
        super(staticSettings);
        search3.setScript(template);
        assertThat(searchTemplateResponse5.hasResponse(), is(false));  
        assertThat(searchTemplateResponse1.getSource().utf8ToString(), equalTo("{\"query\":{\"match\":{\"odd\":\"true\"}}}"));
        assertThat(response.getTook().millis(), greaterThan(0L));  
        return Arrays.asList(
 * Modifications Copyright OpenSearch Contributors. See
        params4.put("field_name", "group");
        SearchTemplateRequest search3 = new SearchTemplateRequest();
        assertHitCount(searchTemplateResponse3.getResponse(), (numDocs / 2));
        search1.setScript(template);
        assertThat(response3.isFailure(), is(false));
}  
import org.opensearch.common.settings.Settings;
            .toString();  
import java.util.Arrays;
    @Override
 *  
 *
import java.util.Collections;
import static org.hamcrest.Matchers.arrayWithSize;
        search3.setRequest(new SearchRequest("msearch"));  
        search5.setSimulate(true);  
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[numDocs];  
    }
        Map<String, Object> params1 = new HashMap<>();
        assertThat(response4.getFailure().getMessage(), equalTo("no such index [unknown]"));
        search1.setScriptType(ScriptType.INLINE);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import java.util.Map;  
        search5.setScriptParams(params5);
import org.opensearch.script.ScriptType;
        // Search #1
    public static Collection<Object[]> parameters() {  
        search2.setScriptParams(params2);
        assertHitCount(searchTemplateResponse1.getResponse(), (numDocs / 2) + (numDocs % 2));  
        search4.setScriptParams(params4);
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.index.IndexNotFoundException;  
        search2.setScriptType(ScriptType.INLINE);
            .field("{{field_name}}", "{{field_value}}")
            .startObject("{{query_type}}")
 * Licensed to Elasticsearch under one or more contributor  
        params3.put("field_name", "odd");
 * Unless required by applicable law or agreed to in writing,
        params5.put("groups", Arrays.asList(1, 2, 3));  
        MultiSearchTemplateResponse.Item response5 = response.getResponses()[4];  
        multiRequest.add(search2);
        multiRequest.add(search3);
        params1.put("field_name", "odd");  
        multiRequest.add(search1);  
        search4.setRequest(new SearchRequest("unknown"));
            searchTemplateResponse2.getSource().utf8ToString(),
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
            .startObject("query")  
        indexRandom(true, indexRequestBuilders);  
        SearchTemplateRequest search2 = new SearchTemplateRequest();  
        // Search #4 (Fail because of unknown index)  
 * compatible open source license.
        createIndex("msearch");
            .endObject()
        params1.put("field_value", true);
        );
 * under the License.  
        assertThat(response4.isFailure(), is(true));
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        SearchTemplateResponse searchTemplateResponse5 = response5.getResponse();
        params3.put("query_type", "term");  
        for (int i = 0; i < numDocs; i++) {
        assertThat(searchTemplateResponse5.getSource().utf8ToString(), equalTo("{\"query\":{\"terms\":{\"group\":[1,2,3,]}}}"));
        params2.put("field_value", "quick brown f");  
        final String template = jsonBuilder().startObject()
 * KIND, either express or implied.  See the License for the
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * The OpenSearch Contributors require contributions made to  
            equalTo("{\"query\":{\"match_phrase_prefix\":{\"message\":\"quick brown f\"}}}")  
        assertThat(response1.isFailure(), is(false));  
            .endObject()
 * SPDX-License-Identifier: Apache-2.0
        search4.setScriptType(ScriptType.INLINE);  
        SearchTemplateResponse searchTemplateResponse2 = response2.getResponse();
            .endObject()  
 * software distributed under the License is distributed on an
        assertThat(searchTemplateResponse3.hasResponse(), is(true));  
        SearchTemplateRequest search4 = new SearchTemplateRequest();
        MultiSearchTemplateResponse.Item response1 = response.getResponses()[0];
        params2.put("field_name", "message");
        assertThat(
import org.opensearch.plugins.Plugin;
        assertThat(response2.isFailure(), is(false));
        SearchTemplateResponse searchTemplateResponse3 = response3.getResponse();
        params1.put("query_type", "match");
        Map<String, Object> params2 = new HashMap<>();  
        );
        search5.setRequest(new SearchRequest("msearch"));  
        // Search #2 (Simulate is true)
        params3.put("field_value", "false");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashMap;
        search3.setScriptType(ScriptType.INLINE);
 * specific language governing permissions and limitations
        return Collections.singleton(MustacheModulePlugin.class);  
        multiRequest.add(search5);
        MultiSearchTemplateResponse response = client().execute(MultiSearchTemplateAction.INSTANCE, multiRequest).get();
import static org.hamcrest.Matchers.equalTo;  
        search2.setSimulate(true);
        params2.put("query_type", "match_phrase_prefix");
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        MultiSearchTemplateResponse.Item response3 = response.getResponses()[2];  
/*  
 */
    }  
        params4.put("query_type", "match");
import org.opensearch.action.search.SearchRequest;
 * ownership. Elasticsearch licenses this file to you under  
        search2.setRequest(new SearchRequest("msearch"));
        Map<String, Object> params4 = new HashMap<>();  
        SearchTemplateRequest search5 = new SearchTemplateRequest();
            indexRequestBuilders[i] = client().prepareIndex("msearch")
        final int numDocs = randomIntBetween(10, 100);
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        Map<String, Object> params3 = new HashMap<>();
        // Search #5 (Simulate is true)
import org.opensearch.action.index.IndexRequestBuilder;  
        MultiSearchTemplateResponse.Item response4 = response.getResponses()[3];
        MultiSearchTemplateResponse.Item response2 = response.getResponses()[1];  
        assertThat(searchTemplateResponse1.hasResponse(), is(true));
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        }
        search3.setSimulate(false);  
        search1.setScriptParams(params1);
/*
        assertThat(response5.isFailure(), is(false));
        search1.setRequest(new SearchRequest("msearch"));  
 * this work for additional information regarding copyright
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;  
 * You may obtain a copy of the License at  
import java.util.Collection;  
 *
/*  
        assertThat(response4.getFailure(), instanceOf(IndexNotFoundException.class));  
        search3.setScriptParams(params3);  
public class MultiSearchTemplateIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(searchTemplateResponse2.hasResponse(), is(false));  
                .setId(String.valueOf(i))  
import static org.hamcrest.core.Is.is;  
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest();
        search5.setScriptType(ScriptType.INLINE);
        Map<String, Object> params5 = new HashMap<>();
