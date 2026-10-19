        assertThat(response.getTook().millis(), greaterThan(0L));
    }
        params1.put("field_value", true);
        search1.setScript(template);
        search4.setRequest(new SearchRequest("unknown"));
 * The OpenSearch Contributors require contributions made to
        super(staticSettings);
        params3.put("field_name", "odd");
        Map<String, Object> params4 = new HashMap<>();
 */
        assertThat(response1.isFailure(), is(false));
        SearchTemplateRequest search5 = new SearchTemplateRequest();
            .endObject()
        search4.setScriptType(ScriptType.INLINE);
        for (int i = 0; i < numDocs; i++) {
        search3.setScriptParams(params3);
import org.opensearch.script.ScriptType;
        search5.setScriptType(ScriptType.INLINE);
        multiRequest.add(search2);
        assertThat(
 * license agreements. See the NOTICE file distributed with
        SearchTemplateRequest search2 = new SearchTemplateRequest();
        params2.put("field_value", "quick brown f");
        assertThat(response4.isFailure(), is(true));
        params5.put("groups", Arrays.asList(1, 2, 3));
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(searchTemplateResponse1.hasResponse(), is(true));
    }
        MultiSearchTemplateResponse.Item response3 = response.getResponses()[2];
    @Override
        final String template = jsonBuilder().startObject()
        multiRequest.add(search5);
/*
        assertThat(searchTemplateResponse1.getSource().utf8ToString(), equalTo("{\"query\":{\"match\":{\"odd\":\"true\"}}}"));
        search5.setScript("{{! ignore me }}{\"query\":{\"terms\":{\"group\":[{{#groups}}{{.}},{{/groups}}]}}}");
            indexRequestBuilders[i] = client().prepareIndex("msearch")
        params1.put("query_type", "match");
 * under the License.
        params4.put("field_name", "group");
        params4.put("query_type", "match");
            .field("{{field_name}}", "{{field_value}}")
        MultiSearchTemplateResponse.Item response1 = response.getResponses()[0];
        multiRequest.add(search3);
        assertThat(searchTemplateResponse3.getSource().utf8ToString(), equalTo("{\"query\":{\"term\":{\"odd\":\"false\"}}}"));
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 * You may obtain a copy of the License at
        createIndex("msearch");
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
}
 * Licensed to Elasticsearch under one or more contributor
        // Search #4 (Fail because of unknown index)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        search3.setSimulate(false);
import org.opensearch.index.IndexNotFoundException;
        params2.put("query_type", "match_phrase_prefix");
 * compatible open source license.
        SearchTemplateResponse searchTemplateResponse1 = response1.getResponse();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import static org.hamcrest.Matchers.arrayWithSize;
        MultiSearchTemplateResponse.Item response2 = response.getResponses()[1];
        assertThat(response2.isFailure(), is(false));
        search3.setScriptType(ScriptType.INLINE);
        search3.setRequest(new SearchRequest("msearch"));
 */
        assertThat(searchTemplateResponse5.getSource().utf8ToString(), equalTo("{\"query\":{\"terms\":{\"group\":[1,2,3,]}}}"));
 * SPDX-License-Identifier: Apache-2.0
        search4.setScriptParams(params4);
        // Search #1
import static org.hamcrest.Matchers.greaterThan;
        SearchTemplateRequest search3 = new SearchTemplateRequest();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        Map<String, Object> params3 = new HashMap<>();
import static org.hamcrest.core.Is.is;
            equalTo("{\"query\":{\"match_phrase_prefix\":{\"message\":\"quick brown f\"}}}")
            .endObject()
import java.util.Collections;
        assertThat(searchTemplateResponse2.hasResponse(), is(false));
        params4.put("field_value", "test");
        search1.setScriptParams(params1);
        MultiSearchTemplateResponse.Item response5 = response.getResponses()[4];
        search4.setScript(template);
    }
        assertThat(response3.isFailure(), is(false));
 * GitHub history for details.
import static org.hamcrest.Matchers.equalTo;
 * software distributed under the License is distributed on an
        Map<String, Object> params1 = new HashMap<>();
        assertThat(response4.getFailure().getMessage(), equalTo("no such index [unknown]"));
        );
        assertThat(response4.getFailure(), instanceOf(IndexNotFoundException.class));
        // Search #5 (Simulate is true)
/*
                .setSource("odd", (i % 2 == 0), "group", (i % 3));
        }
        SearchTemplateResponse searchTemplateResponse5 = response5.getResponse();
 *
    public void testBasic() throws Exception {
        params2.put("field_name", "message");
        search3.setScript(template);
        search2.setRequest(new SearchRequest("msearch"));
        assertThat(searchTemplateResponse5.hasResponse(), is(false));
        MultiSearchTemplateResponse response = client().execute(MultiSearchTemplateAction.INSTANCE, multiRequest).get();
        assertHitCount(searchTemplateResponse1.getResponse(), (numDocs / 2) + (numDocs % 2));
 * specific language governing permissions and limitations
        Map<String, Object> params2 = new HashMap<>();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        SearchTemplateResponse searchTemplateResponse3 = response3.getResponse();
import java.util.Arrays;
        params1.put("field_name", "odd");
        MultiSearchTemplateRequest multiRequest = new MultiSearchTemplateRequest();
        search5.setScriptParams(params5);
        search5.setRequest(new SearchRequest("msearch"));
public class MultiSearchTemplateIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertThat(searchTemplateResponse3.hasResponse(), is(true));
        search2.setScript(template);
        return Arrays.asList(
        return Collections.singleton(MustacheModulePlugin.class);
 * this file be licensed under the Apache-2.0 license or a
        multiRequest.add(search1);
        Map<String, Object> params5 = new HashMap<>();
import org.opensearch.action.search.SearchRequest;
        assertThat(response.getResponses(), arrayWithSize(5));
        final int numDocs = randomIntBetween(10, 100);
    @ParametersFactory
        assertThat(response5.isFailure(), is(false));
 *
import org.opensearch.action.index.IndexRequestBuilder;
 * ownership. Elasticsearch licenses this file to you under
        SearchTemplateRequest search4 = new SearchTemplateRequest();
        SearchTemplateRequest search1 = new SearchTemplateRequest();
                .setId(String.valueOf(i))
        // Search #3
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .startObject("{{query_type}}")
        search2.setSimulate(true);
        IndexRequestBuilder[] indexRequestBuilders = new IndexRequestBuilder[numDocs];
        MultiSearchTemplateResponse.Item response4 = response.getResponses()[3];
 * not use this file except in compliance with the License.
        multiRequest.add(search4);
            .startObject("query")
import java.util.Map;
        // Search #2 (Simulate is true)
 * KIND, either express or implied.  See the License for the
        params3.put("field_value", "false");
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
        params3.put("query_type", "term");
 * this work for additional information regarding copyright
import org.opensearch.plugins.Plugin;
 */
        search2.setScriptType(ScriptType.INLINE);
        search5.setSimulate(true);
        SearchTemplateResponse searchTemplateResponse2 = response2.getResponse();
import java.util.Collection;
        search1.setRequest(new SearchRequest("msearch"));
            searchTemplateResponse2.getSource().utf8ToString(),
 *
        search1.setScriptType(ScriptType.INLINE);
            .toString();
package org.opensearch.script.mustache;
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.common.settings.Settings;
        indexRandom(true, indexRequestBuilders);
        search2.setScriptParams(params2);
    public static Collection<Object[]> parameters() {
        assertHitCount(searchTemplateResponse3.getResponse(), (numDocs / 2));
            .endObject()
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.util.HashMap;
    public MultiSearchTemplateIT(Settings staticSettings) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
