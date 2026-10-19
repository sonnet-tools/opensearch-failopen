    }  
        }
    private static HttpEntity buildUpdateSettingsRequestBody(Map<String, Object> settings) throws IOException {
            settingsMap.put("skip_unavailable", randomBoolean());  
                    });
                        containsString("Cannot configure setting [cluster.remote.remote1.skip_unavailable] if remote cluster is " +  
        }
                Map<String, Object> nullMap = new HashMap<>();  
    }  
                updateRemoteClusterSettings(Collections.singletonMap("skip_unavailable", null));  
            map.put("skip_unavailable", null);  
        }  
import org.opensearch.core.xcontent.XContentBuilder;
            {
                assertSame(SearchResponse.Clusters.EMPTY, scrollResponse.getClusters());  
 * ownership. Elasticsearch licenses this file to you under  
            }  
                nullMap.put("skip_unavailable", null);
import java.util.List;
                updateRemoteClusterSettings(nullMap);  
            OpenSearchException exception = expectThrows(OpenSearchException.class,
            }
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
                assertThat(responseException.getMessage(),
            {  
            assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
        }
                    InternalSearchResponse response = new InternalSearchResponse(new SearchHits(new SearchHit[0],
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.search.SearchScrollRequest;  
                assertEquals(2, response.getClusters().getTotal());
        ClusterName clusterName = ClusterName.CLUSTER_NAME_SETTING.get(s);  
                Request request = new Request("PUT", "/_cluster/settings");
        Request request = new Request("PUT", "/_cluster/settings");
                    () -> restHighLevelClient.search(new SearchRequest("remote1:index").scroll("1m"), RequestOptions.DEFAULT));
import org.opensearch.client.RequestOptions;  
import org.opensearch.test.transport.MockTransportService;
                SearchResponse response = restHighLevelClient.search(new SearchRequest("remote1:index"), RequestOptions.DEFAULT);
            SearchResponse response1 = restHighLevelClient.search(  
                //check that seeds cannot be reset alone if skip_unavailable is set
                assertEquals(1, response.getClusters().getTotal());
                    {
                assertEquals(10, response.getHits().getHits().length);  
            assertEquals(2, response1.getClusters().getTotal());
            assertThat(rootCause.getMessage(), containsString("connect_exception"));
                (request, channel, task) -> {  
            assertThat(rootCause.getMessage(), containsString("connect_exception"));
        try {
            {  
            OpenSearchException rootCause = (OpenSearchException)exception.getRootCause();  
import org.opensearch.Version;  
    }
/*  
             MockTransportService remoteTransport2 = startTransport("node2", new CopyOnWriteArrayList<>(), Version.CURRENT, threadPool)) {
                            "not enabled."));
    @Override
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index", "remote1:index").scroll("1m"),
                    channel.sendResponse(searchResponse);
/*  
    public void testSearchSkipUnavailable() throws IOException {  
                assertEquals(10, response.getHits().getTotalHits().value());  
                assertEquals(10, response.getHits().getHits().length);  
 * this work for additional information regarding copyright
        ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        final Settings s = Settings.builder().put("node.name", id).build();
        }
import org.opensearch.OpenSearchException;
                        for (Map.Entry<String, Object> entry : settings.entrySet()) {
import org.opensearch.threadpool.ThreadPool;
            clusterSettings.put("seeds", remoteNode2.getAddress().toString());
import java.util.Map;  
import org.opensearch.search.aggregations.InternalAggregations;
            {
        private HighLevelClient(RestClient restClient) {
            Map<String, Object> initialSettings = new HashMap<>();  
    private static void assertSearchConnectFailure() {
import org.apache.hc.core5.http.HttpEntity;
                assertEquals(10, response.getHits().getHits().length);
                assertEquals(1, response.getClusters().getSkipped());
    }  
        if (restHighLevelClient == null) {  
                assertThat(responseException.getMessage(), containsString("Cannot configure setting " +
                builder.startObject("persistent");
                        SearchResponse.Clusters.EMPTY);
                }
            assertEquals(2, response2.getClusters().getTotal());
        }
    public static void cleanupClient() throws IOException {  
    private static MockTransportService startTransport(
            return newService;
            } else {
import org.opensearch.threadpool.TestThreadPool;  
            updateRemoteClusterSettings(cleanupSettings);
 *
import org.opensearch.cluster.node.DiscoveryNode;
            if (success == false) {  
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index", "remote1:index").scroll("1m"),  
            {  
                        channel.sendResponse(new ClusterStateResponse(clusterName, build, false));
public class CrossClusterSearchUnavailableClusterIT extends OpenSearchRestTestCase {  
    private static void updateRemoteClusterSettings(Map<String, Object> settings) throws IOException {
                    builder.endObject();  
                builder.endObject();
 * You may obtain a copy of the License at  
                        new IndexRequest("index").id(String.valueOf(i)).source("field", "value"), RequestOptions.DEFAULT);
import org.opensearch.action.search.SearchAction;  
 * SPDX-License-Identifier: Apache-2.0
                    () -> restHighLevelClient.search(new SearchRequest("index", "remote1:index"), RequestOptions.DEFAULT));
            }
            builder.startObject();
                SearchResponse scrollResponse = restHighLevelClient.scroll(new SearchScrollRequest(scrollId), RequestOptions.DEFAULT);
    }
import java.util.concurrent.TimeUnit;
            }  
            assertEquals(5, response2.getHits().getTotalHits().value());
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsAction;
                assertEquals(10, response.getHits().getTotalHits().value());
            }
                    () -> restHighLevelClient.search(new SearchRequest("remote1:index"), RequestOptions.DEFAULT));
                        RequestOptions.DEFAULT);  
                SearchResponse scrollResponse = restHighLevelClient.scroll(new SearchScrollRequest(scrollId), RequestOptions.DEFAULT);
            );  
                        new TotalHits(0, TotalHits.Relation.EQUAL_TO), Float.NaN), InternalAggregations.EMPTY, null, null, false, null, 1);
            final ThreadPool threadPool) {  
                            builder.field(entry.getKey(), entry.getValue());  
            clusterSettings.put("skip_unavailable", true);  
                assertEquals(2, response.getClusters().getSuccessful());
            assertThat(rootCause.getMessage(), containsString("connect_exception"));
            newService.registerRequestHandler(ClusterSearchShardsAction.NAME, ThreadPool.Names.SAME, ClusterSearchShardsRequest::new,  
                assertEquals(10, response.getHits().getHits().length);
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index", "remote1:index"), RequestOptions.DEFAULT);
    private final ThreadPool threadPool = new TestThreadPool(getClass().getName());
            Map<String, Object> map = new HashMap<>();
import java.util.Collections;  
        Response response = client().performRequest(request);
 * this file be licensed under the Apache-2.0 license or a
                assertEquals(10, response.getHits().getTotalHits().value());
            {  
 * The OpenSearch Contributors require contributions made to  
            updateRemoteClusterSettings(Collections.singletonMap("skip_unavailable", true));
import org.opensearch.test.rest.OpenSearchRestTestCase;
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(2, response.getClusters().getTotal());  
import org.junit.Before;  
            }
import org.apache.lucene.search.TotalHits;
            {  
            restHighLevelClient = new HighLevelClient(client());
            DiscoveryNode remoteNode2 = remoteTransport2.getLocalDiscoNode();
            for (int i = 0; i < 5; i++) {
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;  
            settingsMap.put("seeds", remoteNode.getAddress().toString());
                {
                assertEquals(400, responseException.getResponse().getStatusLine().getStatusCode());
                new SearchRequest("index", "remote1:index"),
                SearchResponse response = restHighLevelClient.search(new SearchRequest("remote1:index"), RequestOptions.DEFAULT);  
        } finally {
 * under the License.  
                assertEquals(400, responseException.getResponse().getStatusLine().getStatusCode());  
import org.opensearch.cluster.node.DiscoveryNodes;
        super.tearDown();
            {
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsGroup;
import org.opensearch.cluster.ClusterName;
            assertSearchConnectFailure();
            remoteTransport1.close();  
            final String id,  
                assertEquals(0, response.getHits().getTotalHits().value());
        boolean success = false;
                assertEquals(0, response.getClusters().getSkipped());
    @Before  
import java.util.concurrent.CopyOnWriteArrayList;
    }  
                assertEquals(1, response.getClusters().getTotal());
            remoteTransport2.close();
 */
        }  
            updateRemoteClusterSettings(initialSettings);  
            final List<DiscoveryNode> knownNodes,
                assertEquals(10, response.getHits().getTotalHits().value());
            OpenSearchException rootCause = (OpenSearchException)exception.getRootCause();  
                assertEquals(1, response.getClusters().getSuccessful());  
import java.io.IOException;
                assertEquals(10, response.getHits().getHits().length);
        String requestBody;  
            {
            Response refreshResponse = client().performRequest(new Request("POST", "/index/_refresh"));
                assertEquals(2, response.getClusters().getSuccessful());  
 * Licensed to Elasticsearch under one or more contributor  
            builder.endObject();
import org.opensearch.common.xcontent.json.JsonXContent;  
                assertEquals(0, response.getClusters().getSkipped());
            }  
        try (MockTransportService remoteTransport = startTransport("node0", new CopyOnWriteArrayList<>(), Version.CURRENT, threadPool)) {
        try (MockTransportService remoteTransport = startTransport("node0", new CopyOnWriteArrayList<>(), Version.CURRENT, threadPool)) {  
import org.opensearch.core.common.Strings;
                RequestOptions.DEFAULT
                request.setEntity(buildUpdateSettingsRequestBody(  
                updateRemoteClusterSettings(Collections.singletonMap("seeds", null));
    public void tearDown() throws Exception {  
                //check that skip_unavailable alone cannot be set
            }
                restHighLevelClient.index(
                assertEquals(0, scrollResponse.getHits().getHits().length);
                assertEquals(1, response.getClusters().getSuccessful());
            Response refreshResponse = client().performRequest(new Request("POST", "/index/_refresh"));  
 *  
            newService.registerRequestHandler(SearchAction.NAME, ThreadPool.Names.SAME, SearchRequest::new,
        assertEquals(200, response.getStatusLine().getStatusCode());
            success = true;  
            DiscoveryNode remoteNode = remoteTransport.getLocalDiscoNode();
            map.put("seeds", null);
    public void testCrossClusterConnectionWithSkipUnavailable() throws IOException {
        {  
 * KIND, either express or implied.  See the License for the
            updateRemoteClusterSettings(Collections.singletonMap("skip_unavailable", false));
            DiscoveryNode remoteNode1 = remoteTransport1.getLocalDiscoNode();  
            cleanupSettings.put("seeds", null);
        {  
        return new StringEntity(requestBody, ContentType.APPLICATION_JSON);
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index"), RequestOptions.DEFAULT);
                SearchResponse response = restHighLevelClient.search(new SearchRequest("index", "remote1:index"), RequestOptions.DEFAULT);
            Map<String, Object> settingsMap = new HashMap<>();
import org.opensearch.action.search.SearchResponse;
        try (MockTransportService remoteTransport1 = startTransport("node1", new CopyOnWriteArrayList<>(), Version.CURRENT, threadPool);  
 */  
        }
import org.junit.AfterClass;
    @AfterClass
            initialSettings.put("seeds", remoteNode1.getAddress().toString());
            updateRemoteClusterSettings(map);
                            builder.add(node);
                        }
 * not use this file except in compliance with the License.
/*
import org.opensearch.action.admin.cluster.state.ClusterStateAction;
                assertEquals(1, response.getClusters().getSuccessful());  
                        }  
            cleanupSettings.put("skip_unavailable", null);  
                ResponseException responseException = expectThrows(ResponseException.class,
import org.opensearch.client.RestClient;  
 * software distributed under the License is distributed on an
package org.opensearch.search;
            assertEquals(2, response1.getClusters().getSuccessful());  
                    });  
                newService.close();
                    Collections.singletonMap("skip_unavailable", randomBoolean())));
                assertEquals(0, response.getHits().getTotalHits().value());
                assertEquals(0, response.getClusters().getSkipped());
 * GitHub history for details.
                assertEquals(10, scrollResponse.getHits().getTotalHits().value());
            newService.start();
            }  
        }
import org.opensearch.common.settings.Settings;  
                assertEquals(0, scrollResponse.getHits().getHits().length);
    }  
 */  
            assertEquals(5, response1.getHits().getTotalHits().value());
                new SearchRequest("index", "remote1:index"),
        {  
                (request, channel, task) -> {
                        for (DiscoveryNode node : knownNodes) {
                    }
            newService.registerRequestHandler(ClusterStateAction.NAME, ThreadPool.Names.SAME, ClusterStateRequest::new,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.internal.InternalSearchResponse;
            Map<String, Object> clusterSettings = new HashMap<>();
    public void testSkipUnavailableDependsOnSeeds() throws IOException {
                                knownNodes.toArray(new DiscoveryNode[0]), Collections.emptyMap()));  
    private static RestHighLevelClient restHighLevelClient;
            updateRemoteClusterSettings(settingsMap);
import org.opensearch.client.RestHighLevelClient;
                    builder.startObject("cluster.remote.remote1");  
    private static class HighLevelClient extends RestHighLevelClient {
            OpenSearchException exception = expectThrows(OpenSearchException.class,
            }  
import org.opensearch.action.search.ShardSearchFailure;
                        channel.sendResponse(new ClusterSearchShardsResponse(new ClusterSearchShardsGroup[0],
                assertEquals(10, scrollResponse.getHits().getTotalHits().value());  
                Request request = new Request("PUT", "/_cluster/settings");
                assertSame(SearchResponse.Clusters.EMPTY, response.getClusters());  
            }
        restHighLevelClient = null;
            assertEquals(1, response2.getClusters().getSuccessful());  
                        () -> client().performRequest(request));  
import org.apache.hc.core5.http.ContentType;
                assertEquals(0, response.getClusters().getSuccessful());
    }  
                        ClusterState build = ClusterState.builder(clusterName).nodes(builder.build()).build();
import static org.hamcrest.CoreMatchers.containsString;
            requestBody = builder.toString();
import java.util.HashMap;
            for (int i = 0; i < 10; i++) {  
}  
            assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
            OpenSearchException exception = expectThrows(OpenSearchException.class,
                    new IndexRequest("index").id(String.valueOf(i)).source("field", "value"),
import org.opensearch.cluster.ClusterState;  
            updateRemoteClusterSettings(clusterSettings);
                assertSame(SearchResponse.Clusters.EMPTY, scrollResponse.getClusters());
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsResponse;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.client.Response;
                assertEquals(1, response.getClusters().getSkipped());  
                ResponseException responseException = expectThrows(ResponseException.class,
                assertEquals(1, response.getClusters().getSkipped());  
            initialSettings.put("skip_unavailable", true);
            SearchResponse response2 = restHighLevelClient.search(  
                });  
                assertEquals(10, response.getHits().getTotalHits().value());
            if (randomBoolean()) {
                restHighLevelClient.index(  
                    "[cluster.remote.remote1.skip_unavailable] if remote cluster is not enabled."));
                (request, channel, task) -> {
                nullMap.put("seeds", null);
 * compatible open source license.
    }  
                String scrollId = response.getScrollId();
        restHighLevelClient.close();
                assertEquals(2, response.getClusters().getTotal());
        super.initClient();
                assertEquals(2, response.getClusters().getTotal());
                RequestOptions.DEFAULT
        MockTransportService newService = MockTransportService.createNewService(s, version, threadPool, NoopTracer.INSTANCE);
import org.opensearch.client.Request;
import org.opensearch.action.index.IndexRequest;
                        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();  
import org.apache.hc.core5.http.io.entity.StringEntity;  
            remoteTransport.close();
            super(restClient, (client) -> {}, Collections.emptyList());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.setEntity(buildUpdateSettingsRequestBody(settings));  
    public void initHighLevelClient() throws IOException {
        }
import org.opensearch.action.search.SearchRequest;
                    SearchResponse searchResponse = new SearchResponse(response, null, 1, 1, 0, 100, ShardSearchFailure.EMPTY_ARRAY,  
            }  
            }
import org.opensearch.action.admin.cluster.shards.ClusterSearchShardsRequest;  
            OpenSearchException rootCause = (OpenSearchException)exception.getRootCause();  
                request.setEntity(buildUpdateSettingsRequestBody(Collections.singletonMap("seeds", null)));  
                    RequestOptions.DEFAULT
            {
 * specific language governing permissions and limitations
                        () -> client().performRequest(request));
            final Version version,
            DiscoveryNode remoteNode = remoteTransport.getLocalDiscoNode();
    }  
            newService.acceptIncomingRequests();
            assertEquals(0, response1.getClusters().getSkipped());
import org.opensearch.client.ResponseException;
                        RequestOptions.DEFAULT);
            assertEquals(1, response2.getClusters().getSkipped());
            Map<String, Object> cleanupSettings = new HashMap<>();
 *
                );  
                String scrollId = response.getScrollId();  
        try (XContentBuilder builder = JsonXContent.contentBuilder()) {
            );  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            updateRemoteClusterSettings(Collections.singletonMap("seeds", remoteNode.getAddress().toString()));
    }
            }
