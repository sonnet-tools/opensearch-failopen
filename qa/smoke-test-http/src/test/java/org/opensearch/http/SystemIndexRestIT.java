                indexRequest.source(Map.of("some_field", "some_value"));
            @Override
import org.opensearch.client.Request;
        // make sure the system index now exists
                return true;
        assertDeprecationWarningOnAccess(".test-*", SystemIndexTestPlugin.SYSTEM_INDEX_NAME);
                }""";  
        // And with a partial wildcard
        public static class AddDocRestHandler extends BaseRestHandler {
    public static class SystemIndexTestPlugin extends Plugin implements SystemIndexPlugin {  
            searchRequest.setOptions(expectWarnings("this request accesses system indices: [" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME +
                            }  
                  "index_patterns": [
import org.opensearch.common.settings.Settings;  
                    "*system-idx*"
                              "type": "text"
                return "system_index_test_doc_adder";
                "future major version, direct access to system indices will be prevented by default";
    public void testSystemIndexAccessBlockedByDefault() throws Exception {
                                                 Supplier<DiscoveryNodes> nodesInCluster) {
        {  
                    "settings": {}
        {  
    private void assertDeprecationWarningOnAccess(String queryPattern, String warningIndexName) throws IOException {
        // create template
        {
 * this work for additional information regarding copyright
        String expectedWarning = "this request accesses system indices: [" + warningIndexName + "], but in a " +  
public class SystemIndexRestIT extends HttpSmokeTestCase {  
import org.opensearch.rest.RestRequest;
import org.opensearch.plugins.Plugin;  
                          "properties": {  
        Request searchRequest = new Request("GET", "/" + queryPattern + randomFrom("/_count", "/_search"));
                        "error" : {
/*  
    @Override
 * this file be licensed under the Apache-2.0 license or a
            public String getName() {  
                                                 IndexScopedSettings indexScopedSettings, SettingsFilter settingsFilter,  
            }
            @Override
            Response resp = getRestClient().performRequest(templateRequest);  
import org.opensearch.rest.RestHandler;
                  }
                    "error_mapping_test_template"  
                  "version": 1
import java.util.ArrayList;  
    }
        searchRequest.addParameter("allow_no_indices", "false");
        {
            Response resp = getRestClient().performRequest(putDocRequest);  
                          }
 *
 *  
        Response response = getRestClient().performRequest(searchRequest);
            protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
/*  
import org.opensearch.common.settings.ClusterSettings;
        }
import java.util.Map;
import org.opensearch.common.settings.SettingsFilter;
        // create index  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            putDocDirectlyRequest.setOptions(expectWarnings(expectedWarning));
        @Override
        // Disallow no indices to cause an exception if this resolves to zero indices, so that we're sure it resolved the index
                }""";  
 */  
            assertedWarnings.add(expectedWarning);
            assertThat(response.getStatusLine().getStatusCode(), equalTo(201));  
            }
        }
import java.util.Set;  
            builder.setWarningsHandler(w -> w.contains(expectedWarning) == false || w.size() != 1);
        if (!assertedWarnings.contains(expectedWarning)) {  
        return builder.build();
                        }
@AwaitsFix(bugUrl = "flaky test - enable after fix")
            Response response = getRestClient().performRequest(putDocDirectlyRequest);
    }  
        }  
            indexRequest.setJsonEntity(jsonBody);
        }  
            Request indexRequest = new Request("PUT", "/" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME);  
        {
                      }  
import static org.opensearch.test.rest.OpenSearchRestTestCase.entityAsMap;  
            applyTemplateRequest.setJsonEntity(jsonBody);
            searchRequest.setOptions(expectWarnings(expectedWarning));
        // Try to index a doc directly
        // create system index - success
                return List.of(new Route(RestRequest.Method.POST, "/_sys_index_test/add_doc/{id}"));  
import org.opensearch.action.index.IndexRequest;
import org.opensearch.common.settings.IndexScopedSettings;
            String jsonBody = """
                  },  
        return plugins;
                  }  
                {
            return Collections.singletonList(new SystemIndexDescriptor(SYSTEM_INDEX_NAME, "System indices for tests"));
            public boolean allowSystemIndexAccessByDefault() {
                IndexRequest indexRequest = new IndexRequest(SYSTEM_INDEX_NAME);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        if (!assertedWarnings.contains(expectedWarning)) {
import org.opensearch.client.RequestOptions;
        }
            Request templateRequest = new Request("POST", "_component_template/error_mapping_test_template");
            String jsonBody = """
/*
    }  
            // Disallow no indices to cause an exception if the flag above doesn't work
            putDocDirectlyRequest.setJsonEntity("{\"some_field\":  \"some_other_value\"}");  
 * KIND, either express or implied.  See the License for the
                  ],
            Request putDocRequest = new Request("POST", "/_sys_index_test/add_doc/42");
import java.util.List;
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
            templateRequest.setJsonEntity(jsonBody);
 * specific language governing permissions and limitations
 * GitHub history for details.
            @Override  
        searchRequest.setJsonEntity("{\"query\": {\"match\":  {\"some_field\":  \"some_value\"}}}");  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                    new RestStatusToXContentListener<>(channel, r -> r.getLocation(indexRequest.routing())));
            }
            assertThat(resp.getStatusLine().getStatusCode(), equalTo(200));
            Response resp = getRestClient().performRequest(applyTemplateRequest);  
        // And with a total wildcard
    }  
 * software distributed under the License is distributed on an
        }
 * SPDX-License-Identifier: Apache-2.0
                    }
                      "properties": {  
            public List<Route> routes() {
                  "composed_of": [
    }
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
            Map<String, Object> responseMap = entityAsMap(searchResponse);
            }  
            searchRequest.setJsonEntity("{\"query\": {\"match\":  {\"some_field\":  \"some_value\"}}}");
import org.opensearch.transport.client.node.NodeClient;
                            "status": {
 * under the License.  
import java.util.Collection;
 *
        });
 * Licensed to Elasticsearch under one or more contributor  
                indexRequest.id(request.param("id"));  
import org.opensearch.rest.action.RestStatusToXContentListener;  
                        "type": "text"  
            assertThat(resp.getStatusLine().getStatusCode(), equalTo(200));
                  "mappings": {  
            Request applyTemplateRequest = new Request("POST", "_index_template/match_all_test_template");
import org.opensearch.rest.RestController;  
            assertThat(resp.getStatusLine().getStatusCode(), equalTo(200));
        // apply template to indices
            searchRequest.addParameter("allow_no_indices", "false");  
            Response resp = getRestClient().performRequest(indexRequest);  
            Request searchRequest = new Request("GET", "/" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME + "/_count");
                                                 IndexNameExpressionResolver indexNameExpressionResolver,
            assertedWarnings.add(expectedWarning);  
    public void testSystemIndexCreatedWithoutAnyTemplates() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
                  "priority": 10,
import static org.hamcrest.Matchers.hasKey;
}
    private Set<String> assertedWarnings = new HashSet<>();
    }  
 */  
        }  
                return channel -> client.index(indexRequest,  
        public List<RestHandler> getRestHandlers(Settings settings, RestController restController, ClusterSettings clusterSettings,
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(responseMap.get("count"), equalTo(1));
import java.util.Collections;
import java.util.function.Supplier;
                    "properties": {
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
        }
                    "mappings": {
    private RequestOptions expectWarnings(String expectedWarning) {
                {  
            return List.of(new AddDocRestHandler());  
            assertThat(searchResponse.getStatusLine().getStatusCode(), is(200));
import static org.hamcrest.Matchers.equalTo;
        assertBusy(() -> {  
            "future major version, direct access to system indices will be prevented by default";
                  ],  
                {  
            String expectedWarning = "this request accesses system indices: [" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME + "], but in a " +  
                              "type": "integer"
 * license agreements. See the NOTICE file distributed with
import org.opensearch.client.Response;  
        }
        final RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();  
            Request putDocDirectlyRequest = new Request("PUT", "/" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME + "/_doc/43");
 * compatible open source license.
            final Response searchResponse = getRestClient().performRequest(searchRequest);  
            assertThat(resp.getStatusLine().getStatusCode(), equalTo(201));
            assertThat(responseMap, hasKey("count"));  
 */
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashSet;  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.http;
                          "type": "nested",
                      }
import org.opensearch.cluster.node.DiscoveryNodes;  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                "], but in a future major version, direct access to system indices will be prevented by default"));  
            String jsonBody = """
                            },  
            @Override  
        assertDeprecationWarningOnAccess(randomFrom("*", "_all"), SystemIndexTestPlugin.SYSTEM_INDEX_NAME);
                  "template": {
import static org.hamcrest.Matchers.is;  
 * Unless required by applicable law or agreed to in writing,
                indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        plugins.add(SystemIndexTestPlugin.class);
import org.opensearch.action.support.WriteRequest;  
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());  
                  "template": {
        }
                            "message": {
import org.opensearch.rest.BaseRestHandler;
                    }
        public static final String SYSTEM_INDEX_NAME = ".test-system-idx";
import org.opensearch.indices.SystemIndexDescriptor;
 * You may obtain a copy of the License at  
                }""";
        @Override  
import org.opensearch.plugins.SystemIndexPlugin;
                      "error": {
 * not use this file except in compliance with the License.
