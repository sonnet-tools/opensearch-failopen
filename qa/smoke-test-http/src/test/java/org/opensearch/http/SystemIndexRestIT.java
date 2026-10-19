                indexRequest.id(request.param("id"));
        }
        }
import static org.opensearch.test.rest.OpenSearchRestTestCase.entityAsMap;
    }
import org.opensearch.indices.SystemIndexDescriptor;
                          "type": "nested",
        Request searchRequest = new Request("GET", "/" + queryPattern + randomFrom("/_count", "/_search"));
        @Override
import org.opensearch.rest.RestRequest;
                        "type": "text"
import static org.hamcrest.Matchers.equalTo;
        plugins.add(SystemIndexTestPlugin.class);
                            }
import java.io.IOException;
        {
 * You may obtain a copy of the License at
    }
                                                 Supplier<DiscoveryNodes> nodesInCluster) {
import org.opensearch.plugins.SystemIndexPlugin;
import org.opensearch.client.Response;
    }
                        }
        @Override
                  "mappings": {
            Request templateRequest = new Request("POST", "_component_template/error_mapping_test_template");
            String jsonBody = """
        public static final String SYSTEM_INDEX_NAME = ".test-system-idx";
            Request applyTemplateRequest = new Request("POST", "_index_template/match_all_test_template");
                            "status": {
                return true;
                  "index_patterns": [
                      "properties": {
            searchRequest.setOptions(expectWarnings("this request accesses system indices: [" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME +
 * ownership. Elasticsearch licenses this file to you under
                  },
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                  ],
            String jsonBody = """
            searchRequest.addParameter("allow_no_indices", "false");
            @Override
        searchRequest.setJsonEntity("{\"query\": {\"match\":  {\"some_field\":  \"some_value\"}}}");
            searchRequest.setJsonEntity("{\"query\": {\"match\":  {\"some_field\":  \"some_value\"}}}");
        // Try to index a doc directly
        {
                {
        }
                }""";
            }
import java.util.Set;
        // create index
                      }
/*
            assertedWarnings.add(expectedWarning);
    }
 */
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.IndexScopedSettings;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                              "type": "text"
    private Set<String> assertedWarnings = new HashSet<>();
    private void assertDeprecationWarningOnAccess(String queryPattern, String warningIndexName) throws IOException {
            @Override
            applyTemplateRequest.setJsonEntity(jsonBody);
        // make sure the system index now exists
        public List<RestHandler> getRestHandlers(Settings settings, RestController restController, ClusterSettings clusterSettings,
            }
import org.opensearch.client.RequestOptions;
                return List.of(new Route(RestRequest.Method.POST, "/_sys_index_test/add_doc/{id}"));
 * license agreements. See the NOTICE file distributed with
            final Response searchResponse = getRestClient().performRequest(searchRequest);
            putDocDirectlyRequest.setJsonEntity("{\"some_field\":  \"some_other_value\"}");
            }
            "future major version, direct access to system indices will be prevented by default";
                {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.WriteRequest;
        // Disallow no indices to cause an exception if this resolves to zero indices, so that we're sure it resolved the index
            public boolean allowSystemIndexAccessByDefault() {
import static org.hamcrest.Matchers.hasKey;
        }
 *
    public void testSystemIndexCreatedWithoutAnyTemplates() throws Exception {
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.rest.BaseRestHandler;
            @Override
            public List<Route> routes() {
import java.util.function.Supplier;
        public static class AddDocRestHandler extends BaseRestHandler {
    }
        // And with a total wildcard
        }
import java.util.Collection;
import java.util.HashSet;
 * the Apache License, Version 2.0 (the "License"); you may
                          }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
 * Unless required by applicable law or agreed to in writing,
                          "properties": {
import org.opensearch.plugins.Plugin;
            return Collections.singletonList(new SystemIndexDescriptor(SYSTEM_INDEX_NAME, "System indices for tests"));
            assertThat(resp.getStatusLine().getStatusCode(), equalTo(200));
                    "*system-idx*"
                  "priority": 10,
import java.util.List;
 * this work for additional information regarding copyright
        final RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
 *
            assertThat(resp.getStatusLine().getStatusCode(), equalTo(200));
    public void testSystemIndexAccessBlockedByDefault() throws Exception {
        {
            builder.setWarningsHandler(w -> w.contains(expectedWarning) == false || w.size() != 1);
    private RequestOptions expectWarnings(String expectedWarning) {
            Request putDocDirectlyRequest = new Request("PUT", "/" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME + "/_doc/43");
 * GitHub history for details.
        List<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
            // Disallow no indices to cause an exception if the flag above doesn't work
        if (!assertedWarnings.contains(expectedWarning)) {
            assertThat(response.getStatusLine().getStatusCode(), equalTo(201));
import org.opensearch.cluster.node.DiscoveryNodes;
            @Override
            templateRequest.setJsonEntity(jsonBody);
                            },
                indexRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
                  }
                  "template": {
 *
            searchRequest.setOptions(expectWarnings(expectedWarning));
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.rest.RestHandler;
    }
    @Override
        }
        if (!assertedWarnings.contains(expectedWarning)) {
            putDocDirectlyRequest.setOptions(expectWarnings(expectedWarning));
            assertThat(responseMap, hasKey("count"));
            Request searchRequest = new Request("GET", "/" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME + "/_count");
import org.opensearch.client.Request;
                      }
@AwaitsFix(bugUrl = "flaky test - enable after fix")
            }
                }""";
 * under the License.
            assertThat(resp.getStatusLine().getStatusCode(), equalTo(200));
        }
            Response resp = getRestClient().performRequest(indexRequest);
            Map<String, Object> responseMap = entityAsMap(searchResponse);
                IndexRequest indexRequest = new IndexRequest(SYSTEM_INDEX_NAME);
 */
public class SystemIndexRestIT extends HttpSmokeTestCase {
import static org.hamcrest.Matchers.is;
 * not use this file except in compliance with the License.
                "future major version, direct access to system indices will be prevented by default";
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.rest.action.RestStatusToXContentListener;
/*
 * The OpenSearch Contributors require contributions made to
            assertThat(resp.getStatusLine().getStatusCode(), equalTo(201));
        }
            Response response = getRestClient().performRequest(putDocDirectlyRequest);
                    "error_mapping_test_template"
                "], but in a future major version, direct access to system indices will be prevented by default"));
        }
            Request indexRequest = new Request("PUT", "/" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            protected RestChannelConsumer prepareRequest(RestRequest request, NodeClient client) throws IOException {
        return builder.build();
import java.util.Collections;
                    "properties": {
                  "version": 1
}
            Request putDocRequest = new Request("POST", "/_sys_index_test/add_doc/42");
            String expectedWarning = "this request accesses system indices: [" + SystemIndexTestPlugin.SYSTEM_INDEX_NAME + "], but in a " +
        {
    public static class SystemIndexTestPlugin extends Plugin implements SystemIndexPlugin {
import java.util.ArrayList;
        // apply template to indices
                }""";
            assertThat(searchResponse.getStatusLine().getStatusCode(), is(200));
        String expectedWarning = "this request accesses system indices: [" + warningIndexName + "], but in a " +
            return List.of(new AddDocRestHandler());
        {
                {
/*
                    }
                    "settings": {}
            public String getName() {
                    }
 * KIND, either express or implied.  See the License for the
            String jsonBody = """
            Response resp = getRestClient().performRequest(applyTemplateRequest);
            assertedWarnings.add(expectedWarning);
import org.opensearch.common.settings.SettingsFilter;
            Response resp = getRestClient().performRequest(putDocRequest);
                      "error": {
import java.util.Map;
                  }
 * specific language governing permissions and limitations
        searchRequest.addParameter("allow_no_indices", "false");
        public Collection<SystemIndexDescriptor> getSystemIndexDescriptors(Settings settings) {
                              "type": "integer"
package org.opensearch.http;
                  "template": {
        Response response = getRestClient().performRequest(searchRequest);
                    "mappings": {
        assertBusy(() -> {
            assertThat(responseMap.get("count"), equalTo(1));
                                                 IndexNameExpressionResolver indexNameExpressionResolver,
            indexRequest.setJsonEntity(jsonBody);
        // create template
        assertDeprecationWarningOnAccess(".test-*", SystemIndexTestPlugin.SYSTEM_INDEX_NAME);
            Response resp = getRestClient().performRequest(templateRequest);
        assertDeprecationWarningOnAccess(randomFrom("*", "_all"), SystemIndexTestPlugin.SYSTEM_INDEX_NAME);
        });
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                        "error" : {
        // create system index - success
import org.opensearch.common.settings.ClusterSettings;
                  ],
import org.opensearch.rest.RestController;
                return "system_index_test_doc_adder";
                            "message": {
        assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * compatible open source license.
                  "composed_of": [
                    new RestStatusToXContentListener<>(channel, r -> r.getLocation(indexRequest.routing())));
import org.opensearch.action.index.IndexRequest;
        return plugins;
                return channel -> client.index(indexRequest,
                indexRequest.source(Map.of("some_field", "some_value"));
        // And with a partial wildcard
                                                 IndexScopedSettings indexScopedSettings, SettingsFilter settingsFilter,
