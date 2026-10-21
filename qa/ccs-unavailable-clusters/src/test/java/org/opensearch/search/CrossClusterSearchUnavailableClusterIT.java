            newService.start();
                newService.close();
            OpenSearchException exception = expectThrows(OpenSearchException.class,
 * compatible open source license.
                ResponseException responseException = expectThrows(ResponseException.class,
 *
            } else {
import org.opensearch.core.xcontent.XContentBuilder;
            assertThat(rootCause.getMessage(), containsString("connect_exception"));
    private static class HighLevelClient extends RestHighLevelClient {
                        }
    @AfterClass
                assertEquals(1, response.getClusters().getSuccessful());
            updateRemoteClusterSettings(Collections.singletonMap("skip_unavailable", false));
        }
            for (int i = 0; i < 5; i++) {
                    });
                assertSame(SearchResponse.Clusters.EMPTY, scrollResponse.getClusters());
    }
            newService.registerRequestHandler(ClusterStateAction.NAME, ThreadPool.Names.SAME, ClusterStateRequest::new,
                assertEquals(1, response.getClusters().getSuccessful());
 * SPDX-License-Identifier: Apache-2.0
                //check that skip_unavailable alone cannot be set
        }
            updateRemoteClusterSettings(settingsMap);
            }
            }
    public void initHighLevelClient() throws IOException {
                updateRemoteClusterSettings(Collections.singletonMap("seeds", null));
                RequestOptions.DEFAULT
 * license agreements. See the NOTICE file distributed with
                assertEquals(1, response.getClusters().getSkipped());
import org.apache.hc.core5.http.HttpEntity;
        }
import org.opensearch.cluster.node.DiscoveryNodes;
            SearchResponse response1 = restHighLevelClient.search(
        try {
        String requestBody;
            updateRemoteClusterSettings(map);
            {
import org.opensearch.client.RequestOptions;
import org.opensearch.search.internal.InternalSearchResponse;
            {
 * the Apache License, Version 2.0 (the "License"); you may
            }
                        new IndexRequest("index").id(String.valueOf(i)).source("field", "value"), RequestOptions.DEFAULT);
            remoteTransport2.close();
                    builder.startObject("cluster.remote.remote1");
import java.io.IOException;
            assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
            assertEquals(1, response2.getClusters().getSkipped());
                    builder.endObject();
import org.opensearch.cluster.ClusterState;
                        channel.sendResponse(new ClusterStateResponse(clusterName, build, false));
            newService.registerRequestHandler(ClusterSearchShardsAction.NAME, ThreadPool.Names.SAME, ClusterSearchShardsRequest::new,
import org.junit.Before;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        restHighLevelClient = null;
import org.opensearch.cluster.ClusterName;
 *
            newService.acceptIncomingRequests();
        }
            OpenSearchException rootCause = (OpenSearchException)exception.getRootCause();
            builder.startObject();
 * You may obtain a copy of the License at
            Map<String, Object> clusterSettings = new HashMap<>();
                assertEquals(0, scrollResponse.getHits().getHits().length);
                assertEquals(10, response.getHits().getHits().length);
            cleanupSettings.put("seeds", null);
            Map<String, Object> cleanupSettings = new HashMap<>();
                        }
            updateRemoteClusterSettings(initialSettings);
import org.apache.hc.core5.http.ContentType;
                (request, channel, task) -> {
            settingsMap.put("seeds", remoteNode.getAddress().toString());
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index", "remote1:index").scroll("1m"),
            assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
                        for (DiscoveryNode node : knownNodes) {
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsAction;
            return newService;
import org.opensearch.common.xcontent.json.JsonXContent;
 * under the License.
                        RequestOptions.DEFAULT);
            );
                new SearchRequest("index", "remote1:index"),
public class CrossClusterSearchUnavailableClusterIT extends OpenSearchRestTestCase {
                        containsString("Cannot configure setting [cluster.remote.remote1.skip_unavailable] if remote cluster is " +
        Response response = client().performRequest(request);
        Request request = new Request("PUT", "/_cluster/settings");
import org.opensearch.test.rest.OpenSearchRestTestCase;
        }
import java.util.HashMap;
                request.setEntity(buildUpdateSettingsRequestBody(Collections.singletonMap("seeds", null)));
                        new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN), InternalAggregations.EMPTY, null, null, false, null, 1);
            }
        MockTransportService newService = MockTransportService.createNewService(s, version, threadPool, NoopTracer.INSTANCE);
/*
                SearchResponse scrollResponse = restHighLevelClient.scroll(new SearchScrollRequest(scrollId), RequestOptions.DEFAULT);
                });
            if (randomBoolean()) {
                assertEquals(10, response.getHits().getTotalHits().value());
import org.opensearch.test.transport.MockTransportService;
                    RequestOptions.DEFAULT
                assertEquals(10, scrollResponse.getHits().getTotalHits().value());
    }
    public void tearDown() throws Exception {
 * KIND, either express or implied.  See the License for the
                restHighLevelClient.index(
            initialSettings.put("seeds", remoteNode1.getAddress().toString());
                assertEquals(10, response.getHits().getHits().length);
                new SearchRequest("index", "remote1:index"),
                    "[cluster.remote.remote1.skip_unavailable] if remote cluster is not enabled."));
                assertEquals(1, response.getClusters().getSkipped());
 * The OpenSearch Contributors require contributions made to
import java.util.List;
    public void testSkipUnavailableDependsOnSeeds() throws IOException {
            DiscoveryNode remoteNode = remoteTransport.getLocalDiscoNode();
import java.util.Collections;
    private static HttpEntity buildUpdateSettingsRequestBody(Map<String, Object> settings) throws IOException {
            map.put("skip_unavailable", null);
        ClusterName clusterName = ClusterName.CLUSTER_NAME_SETTING.get(s);
            {
    private static void assertSearchConnectFailure() {
            DiscoveryNode remoteNode = remoteTransport.getLocalDiscoNode();
                assertEquals(10, response.getHits().getTotalHits().value());
            for (int i = 0; i < 10; i++) {
            map.put("seeds", null);
                nullMap.put("seeds", null);
 * this file be licensed under the Apache-2.0 license or a
        try (MockTransportService remoteTransport = startTransport("node0", new CopyOnWriteArrayList<>(), Version.CURRENT, threadPool)) {
                updateRemoteClusterSettings(nullMap);
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
        restHighLevelClient.close();
                assertEquals(0, scrollResponse.getHits().getHits().length);
            assertSearchConnectFailure();
                    {
                assertEquals(10, response.getHits().getHits().length);
            cleanupSettings.put("skip_unavailable", null);
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index", "remote1:index"), RequestOptions.DEFAULT);
                assertThat(responseException.getMessage(), containsString("Cannot configure setting " +
                assertEquals(10, response.getHits().getHits().length);
 * not use this file except in compliance with the License.
            updateRemoteClusterSettings(Collections.singletonMap("seeds", remoteNode.getAddress().toString()));
            restHighLevelClient = new HighLevelClient(client());
            assertEquals(2, response1.getClusters().getTotal());
import org.opensearch.threadpool.ThreadPool;
            }
        }
            }
import org.opensearch.action.search.SearchAction;
                SearchResponse response = restHighLevelClient.search(new SearchRequest("remote1:index"), RequestOptions.DEFAULT);
                assertEquals(0, response.getHits().getTotalHits().value());
    }
                        ClusterState build = ClusterState.builder(clusterName).nodes(builder.build()).build();
            {
            {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Map<String, Object> map = new HashMap<>();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
    @Override
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
import org.opensearch.action.index.IndexRequest;
            }
                Request request = new Request("PUT", "/_cluster/settings");
        } finally {
 * GitHub history for details.
                //check that seeds cannot be reset alone if skip_unavailable is set
                (request, channel, task) -> {
                assertSame(SearchResponse.Clusters.EMPTY, scrollResponse.getClusters());
            builder.endObject();
            }
            }
                    });
 * this work for additional information regarding copyright
        try (MockTransportService remoteTransport = startTransport("node0", new CopyOnWriteArrayList<>(), Version.CURRENT, threadPool)) {
import org.opensearch.threadpool.TestThreadPool;
 *
        }
            }
                        channel.sendResponse(new ClusterSearchShardsResponse(new ClusterSearchShardsGroup[0],
             MockTransportService remoteTransport2 = startTransport("node2", new CopyOnWriteArrayList<>(), Version.CURRENT, threadPool)) {
                assertEquals(0, response.getClusters().getSuccessful());
                assertThat(responseException.getMessage(),
            updateRemoteClusterSettings(clusterSettings);
            newService.registerRequestHandler(SearchAction.NAME, ThreadPool.Names.SAME, SearchRequest::new,
        }
            Response refreshResponse = client().performRequest(new Request("POST", "/index/_refresh"));
            final ThreadPool threadPool) {
import org.opensearch.action.search.SearchResponse;
                );
    public void testSearchSkipUnavailable() throws IOException {
            assertEquals(2, response1.getClusters().getSuccessful());
import java.util.concurrent.CopyOnWriteArrayList;
 */
import java.util.concurrent.TimeUnit;
    }
                        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
            {
                assertEquals(0, response.getClusters().getSkipped());
import static org.hamcrest.CoreMatchers.containsString;
                assertEquals(2, response.getClusters().getTotal());
            super(restClient, (client) -> {}, Collections.emptyList());
                        () -> client().performRequest(request));
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;
            {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                assertEquals(2, response.getClusters().getTotal());
            OpenSearchException exception = expectThrows(OpenSearchException.class,
                assertEquals(10, response.getHits().getTotalHits().value());
    }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
 */
                SearchResponse scrollResponse = restHighLevelClient.scroll(new SearchScrollRequest(scrollId), RequestOptions.DEFAULT);
        private HighLevelClient(RestClient restClient) {
                assertEquals(2, response.getClusters().getTotal());
        }
            final List<DiscoveryNode> knownNodes,
            clusterSettings.put("skip_unavailable", true);
            SearchResponse response2 = restHighLevelClient.search(
 * software distributed under the License is distributed on an
                assertEquals(10, response.getHits().getHits().length);
        }
                    channel.sendResponse(searchResponse);
    }
                assertEquals(0, response.getHits().getTotalHits().value());
        final Settings s = Settings.builder().put("node.name", id).build();
        {
                    }
            {
import org.apache.lucene.search.TotalHits;
                    Collections.singletonMap("skip_unavailable", randomBoolean())));
            final Version version,
                assertEquals(1, response.getClusters().getSuccessful());
                RequestOptions.DEFAULT
            remoteTransport1.close();
                restHighLevelClient.index(
            updateRemoteClusterSettings(cleanupSettings);
import org.opensearch.OpenSearchException;
                (request, channel, task) -> {
            requestBody = builder.toString();
            assertEquals(5, response2.getHits().getTotalHits().value());
import org.opensearch.cluster.node.DiscoveryNode;
            DiscoveryNode remoteNode2 = remoteTransport2.getLocalDiscoNode();
import org.opensearch.action.search.ShardSearchFailure;
                    new IndexRequest("index").id(String.valueOf(i)).source("field", "value"),
            }
                    () -> restHighLevelClient.search(new SearchRequest("remote1:index"), RequestOptions.DEFAULT));
            clusterSettings.put("seeds", remoteNode2.getAddress().toString());
/*
                nullMap.put("skip_unavailable", null);
    }
import java.util.Map;
                assertSame(SearchResponse.Clusters.EMPTY, response.getClusters());
                    () -> restHighLevelClient.search(new SearchRequest("remote1:index").scroll("1m"), RequestOptions.DEFAULT));
 * Unless required by applicable law or agreed to in writing,
                assertEquals(2, response.getClusters().getSuccessful());
            assertEquals(1, response2.getClusters().getSuccessful());
                        for (Map.Entry<String, Object> entry : settings.entrySet()) {
            remoteTransport.close();
 * specific language governing permissions and limitations
                assertEquals(0, response.getClusters().getSkipped());
            {
 */
    public static void cleanupClient() throws IOException {
                assertEquals(0, response.getClusters().getSkipped());
            updateRemoteClusterSettings(Collections.singletonMap("skip_unavailable", true));
import org.opensearch.action.search.SearchRequest;
import org.opensearch.client.ResponseException;
import org.opensearch.common.settings.Settings;
                            builder.field(entry.getKey(), entry.getValue());
                            builder.add(node);
                assertEquals(2, response.getClusters().getSuccessful());
import org.opensearch.client.RestClient;
            settingsMap.put("skip_unavailable", randomBoolean());
import org.opensearch.Version;
            Map<String, Object> initialSettings = new HashMap<>();
            assertEquals(2, response2.getClusters().getTotal());
                }
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index"), RequestOptions.DEFAULT);
import org.opensearch.client.Response;
    private static MockTransportService startTransport(
                assertEquals(400, responseException.getResponse().getStatusLine().getStatusCode());
            success = true;
        {
import org.junit.AfterClass;
import org.opensearch.client.RestHighLevelClient;
    public void testCrossClusterConnectionWithSkipUnavailable() throws IOException {
    @Before
                            "not enabled."));
            if (success == false) {
    }
                Map<String, Object> nullMap = new HashMap<>();
                    SearchResponse searchResponse = new SearchResponse(response, null, 1, 1, 0, 100, ShardSearchFailure.EMPTY_ARRAY,
        assertEquals(200, response.getStatusLine().getStatusCode());
            initialSettings.put("skip_unavailable", true);
            }
            }
        super.initClient();
                assertEquals(1, response.getClusters().getTotal());
                        RequestOptions.DEFAULT);
            final String id,
                assertEquals(1, response.getClusters().getSkipped());
                SearchResponse response = restHighLevelClient.search(new SearchRequest("remote1:index"), RequestOptions.DEFAULT);
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
import org.opensearch.search.aggregations.InternalAggregations;
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index", "remote1:index"), RequestOptions.DEFAULT);
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index", "remote1:index").scroll("1m"),
}
            }
            );
                {
                    InternalSearchResponse response = new InternalSearchResponse(new SearchHits(new SearchHit[0],
        try (MockTransportService remoteTransport1 = startTransport("node1", new CopyOnWriteArrayList<>(), Version.CURRENT, threadPool);
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
                request.setEntity(buildUpdateSettingsRequestBody(
package org.opensearch.search;
        super.tearDown();
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
        request.setEntity(buildUpdateSettingsRequestBody(settings));
        {
            Map<String, Object> settingsMap = new HashMap<>();
            {
    }
        if (restHighLevelClient == null) {
                    () -> restHighLevelClient.search(new SearchRequest("index", "remote1:index"), RequestOptions.DEFAULT));
        boolean success = false;
                String scrollId = response.getScrollId();
            assertEquals(0, response1.getClusters().getSkipped());
        return new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                Request request = new Request("PUT", "/_cluster/settings");
            Response refreshResponse = client().performRequest(new Request("POST", "/index/_refresh"));
            assertThat(rootCause.getMessage(), containsString("connect_exception"));
                ResponseException responseException = expectThrows(ResponseException.class,
            OpenSearchException exception = expectThrows(OpenSearchException.class,
            DiscoveryNode remoteNode1 = remoteTransport1.getLocalDiscoNode();
                                knownNodes.toArray(new DiscoveryNode[0]), Collections.emptyMap()));
    }
                assertEquals(400, responseException.getResponse().getStatusLine().getStatusCode());
/*
import org.opensearch.action.search.SearchScrollRequest;
    private static RestHighLevelClient restHighLevelClient;
                assertEquals(10, response.getHits().getTotalHits().value());
    private static void updateRemoteClusterSettings(Map<String, Object> settings) throws IOException {
            assertThat(rootCause.getMessage(), containsString("connect_exception"));
                assertEquals(1, response.getClusters().getTotal());
            OpenSearchException rootCause = (OpenSearchException)exception.getRootCause();
                assertEquals(2, response.getClusters().getTotal());
                builder.endObject();
 * Licensed to Elasticsearch under one or more contributor
                assertEquals(10, scrollResponse.getHits().getTotalHits().value());
                updateRemoteClusterSettings(Collections.singletonMap("skip_unavailable", null));
import org.apache.hc.core5.http.io.entity.StringEntity;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        SearchResponse.Clusters.EMPTY);
import org.opensearch.core.common.Strings;
                builder.startObject("persistent");
            assertEquals(5, response1.getHits().getTotalHits().value());
import org.opensearch.client.Request;
 * ownership. Elasticsearch licenses this file to you under
            OpenSearchException rootCause = (OpenSearchException)exception.getRootCause();
                        () -> client().performRequest(request));
                String scrollId = response.getScrollId();
                assertEquals(10, response.getHits().getTotalHits().value());
    }
