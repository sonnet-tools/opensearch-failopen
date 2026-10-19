            super(restClient, (client) -> {}, new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents());
    private static RestHighLevelClient restHighLevelClient;
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
/*
        SearchResponse search = highLevelClient().search(searchRequest, RequestOptions.DEFAULT);
        SyncMethodNoRequest<Resp> syncMethodNoRequest,
        Map<?, ?> nodesResponse = (Map<?, ?>) toMap(client().performRequest(request)).get("nodes");
    public static void cleanupClient() throws IOException {
        final String token = "Basic " + Base64.getEncoder().encodeToString((user + ":" + pass).getBytes(StandardCharsets.UTF_8));
        assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
    protected static <Resp> Resp execute(
        final PutPipelineRequest putPipelineRequest = new PutPipelineRequest(
            return syncMethod.execute(request, options);
import org.opensearch.action.search.SearchResponse;
 * under the License.
                + highLevelClient().tasks().list(request, RequestOptions.DEFAULT)
import static java.util.Collections.singletonMap;
    }
import org.apache.hc.core5.http.io.entity.EntityUtils;
        return () -> {
 * ownership. Elasticsearch licenses this file to you under
                .isAcknowledged()
        private HighLevelClient(RestClient restClient) {
            }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;
        pipelineBuilder.endObject();
        do {
import org.opensearch.common.Booleans;
        assertBusy(() -> {
        if (async == false) {
import static org.hamcrest.Matchers.notNullValue;
    }
    protected void createIndexWithMultipleShards(String index) throws IOException {
                pipelineBuilder.endObject().endObject();
        } while (System.nanoTime() - start < TimeUnit.SECONDS.toNanos(10));
            .startObject("set")
        AsyncMethod<Req, Resp> asyncMethod,
     * not have a request object (only headers and the request path).
            PlainActionFuture<Resp> future = PlainActionFuture.newFuture();
        });
    }
            .startArray("processors")
    protected interface AsyncMethodNoRequest<Response> {
            execute(putPipelineRequest, highLevelClient().ingest()::putPipeline, highLevelClient().ingest()::putPipelineAsync)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .endObject()
        );
        final XContentBuilder pipelineBuilder = jsonBuilder().startObject()
    }
    protected void putConflictPipeline() throws IOException {
        XContentBuilder builder = buildRandomXContentPipeline();
            pipelineBuilder.startArray(Pipeline.PROCESSORS_KEY);
    protected interface SyncMethod<Request, Response> {
        // TODO: replace with nodes info highlevel rest client code when it is available:
            RemoteInfoResponse response = highLevelClient().cluster().remoteInfo(new RemoteInfoRequest(), RequestOptions.DEFAULT);
import org.opensearch.core.xcontent.XContentBuilder;
     */
            .endObject();
        Req request,
        } else {
        // Select node info of first node (we don't know the node id):
    @FunctionalInterface
        return pipelineBuilder;
            asyncMethod.execute(request, options, future);
     * variant, both provided as functions. This variant is used when the call does
        }
    @FunctionalInterface
    protected static void createPipeline(PutPipelineRequest putPipelineRequest) throws IOException {
        assertTrue(highLevelClient().ingest().putPipeline(putPipelineRequest, RequestOptions.DEFAULT).isAcknowledged());
import org.opensearch.ingest.Pipeline;
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
 */
        IOUtils.close(restHighLevelClient);
    }
        XContentBuilder pipelineBuilder = XContentBuilder.builder(xContentType.xContent());
    @Override
 */
        {
        XContentType xContentType = randomFrom(XContentType.values());
            .startObject()
import org.opensearch.core.tasks.TaskId;
        return Settings.builder().put(super.restClientSettings()).put(ThreadContext.PREFIX + ".Authorization", token).build();
        XContentBuilder pipeline = jsonBuilder().startObject()
 * GitHub history for details.
            .field("field", fieldName)
    private static class HighLevelClient extends RestHighLevelClient {
    protected static <Req, Resp> Resp execute(
        if (async == false) {
            .endObject()
        AsyncMethodNoRequest<Resp> asyncMethodNoRequest,
        } else {
        }
        throw new AssertionError(
    }
            ListTasksResponse list = highLevelClient().tasks().list(request, RequestOptions.DEFAULT);
import java.util.Map;
    }
            .endArray()
    /**
    }
    protected Iterable<SearchHit> searchAll(String... indices) throws IOException {
import org.opensearch.action.support.PlainActionFuture;
    protected static final String CONFLICT_PIPELINE_ID = "conflict_pipeline";
import org.opensearch.core.common.bytes.BytesReference;
            assertThat(response.getInfos().size(), greaterThan(0));
            .endArray()
            PlainActionFuture<Resp> future = PlainActionFuture.newFuture();
 */
    /**
    }
            return taskGroup.getTaskInfo().getTaskId();
            TaskGroup taskGroup = taskGroups.get(0);
            .field("value", value)
            list.rethrowFailures("Finding tasks to rethrottle");
        return XContentHelper.convertToMap(JsonXContent.jsonXContent, EntityUtils.toString(response.getEntity()), false);
 * Modifications Copyright OpenSearch Contributors. See
    }
    }
            return future.actionGet();
            {
    @Before
            .field("field", "_id")
            asyncMethodNoRequest.execute(requestOptions, future);
                .stream()
    }
import org.opensearch.search.SearchHit;
 *
import org.opensearch.test.rest.OpenSearchRestTestCase;
            "Couldn't find tasks to rethrottle. Here are the running tasks "
        refreshIndexes(searchRequest.indices());
        Response refreshResponse = client().performRequest(new Request("POST", "/" + joinedIndices + "/_refresh"));
/*
    protected static void createFieldAddingPipleine(String id, String fieldName, String value) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        SearchRequest searchRequest = new SearchRequest(indices);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        indexRequest.settings(Settings.builder().put("index.number_of_shards", shards).put("index.number_of_replicas", 0));
            assertThat(taskGroup.getChildTasks(), empty());
    }
    protected static XContentBuilder buildRandomXContentPipeline(XContentBuilder pipelineBuilder) throws IOException {
        createPipeline(new PutPipelineRequest(id, BytesReference.bytes(pipeline), MediaTypeRegistry.JSON));
        highLevelClient().indices().create(indexRequest, RequestOptions.DEFAULT);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
            }
        pipelineBuilder.startObject();
                }
import org.opensearch.client.indices.CreateIndexRequest;
    protected static TaskId findTaskToRethrottle(String actionName, String description) throws IOException {
            .startObject()
 * KIND, either express or implied.  See the License for the
     * Executes the provided request using either the sync method or its async variant, both provided as functions
                .filter(taskGroup -> taskGroup.getTaskInfo().getDescription().equals(description))
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
import java.nio.charset.StandardCharsets;
    }
                pipelineBuilder.endObject().endObject();
                    pipelineBuilder.field("field", "foo").field("value", "bar");
    protected interface SyncMethodNoRequest<Response> {
    protected static XContentBuilder buildRandomXContentPipeline() throws IOException {
    }
    protected static void clusterUpdateSettings(Settings persistentSettings, Settings transientSettings) throws IOException {
    @AfterClass
        return execute(request, syncMethod, asyncMethod, RequestOptions.DEFAULT);
import java.util.stream.Collectors;
    protected static final double DOUBLE_DELTA = 0.000001;
    }
import static org.hamcrest.Matchers.empty;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import org.junit.Before;
        request.transientSettings(transientSettings);
    }
import java.util.Collections;
import org.opensearch.core.action.ActionListener;
            execute(request, highLevelClient().cluster()::putSettings, highLevelClient().cluster()::putSettingsAsync).isAcknowledged()
            List<TaskGroup> taskGroups = list.getTaskGroups()
                {
 * specific language governing permissions and limitations
        createPipeline(new PutPipelineRequest(pipelineId, BytesReference.bytes(builder), builder.contentType()));
        void execute(RequestOptions options, ActionListener<Response> listener);
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.common.CheckedRunnable;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
            return syncMethodNoRequest.execute(requestOptions);
    @FunctionalInterface
            .endObject();
        );
import org.opensearch.common.settings.Settings;
        RequestOptions requestOptions
                .collect(Collectors.toList());
            if (0 == taskGroups.size()) {
    protected void refreshIndexes(String... indices) throws IOException {
            .startObject("set")
        final Request request = new Request("GET", "/_nodes");
     */
        ListTasksRequest request = new ListTasksRequest();
import org.opensearch.common.xcontent.XContentType;
    }
                pipelineBuilder.startObject().startObject("set");
    protected static Map<String, Object> toMap(Response response) throws IOException, OpenSearchParseException, ParseException {
        };
    private static boolean async = Booleans.parseBoolean(System.getProperty("tests.rest.async", "false"));
    protected static void createPipeline(String pipelineId) throws IOException {
        assertThat(updateSettingsResponse.isAcknowledged(), is(true));
        ClusterUpdateSettingsResponse updateSettingsResponse = restHighLevelClient.cluster()
        throws IOException {
 *
                // The parent task hasn't started yet
import java.util.List;
            assertTrue((boolean) entityAsMap(response).get("completed"));
                pipelineBuilder.startObject().startObject("convert");
            .endObject()
        nodesResponse = (Map<?, ?>) nodesResponse.get(nodesResponse.keySet().iterator().next());
 *    http://www.apache.org/licenses/LICENSE-2.0
        String transportAddress = (String) nodesResponse.get("transport_address");
import java.util.Objects;
import org.opensearch.common.xcontent.json.JsonXContent;
                }
    }
        final String pass = Objects.requireNonNull(System.getProperty("tests.rest.cluster.password"));
import org.opensearch.common.xcontent.XContentHelper;
        request.setActions(actionName);
            .field("field", "_version")
    protected interface AsyncMethod<Request, Response> {
        final String user = Objects.requireNonNull(System.getProperty("tests.rest.cluster.username"));
    protected Iterable<SearchHit> searchAll(SearchRequest searchRequest) throws IOException {
import static org.hamcrest.Matchers.is;
        super.initClient();
 * this work for additional information regarding copyright
            Response response = client.performRequest(new Request("GET", "/_tasks/" + taskId));
import org.opensearch.OpenSearchParseException;
            .startArray("processors")
        request.setDetailed(true);
        void execute(Request request, RequestOptions options, ActionListener<Response> listener);
import org.junit.AfterClass;
package org.opensearch.client;
    public void initHighLevelClient() throws IOException {
        String joinedIndices = Arrays.stream(indices).collect(Collectors.joining(","));
        return restHighLevelClient;
        assertTrue(
 * the Apache License, Version 2.0 (the "License"); you may
            .field("value", "1")
            .endObject()
    protected Settings restClientSettings() {
    }
        }
import static org.hamcrest.Matchers.hasSize;
import org.opensearch.client.cluster.RemoteInfoRequest;
        request.persistentSettings(persistentSettings);
        // Configure local cluster as remote cluster:
    }
        Response execute(RequestOptions options) throws IOException;
 * You may obtain a copy of the License at
import org.apache.hc.core5.http.ParseException;
        assertTrue(
            restHighLevelClient = new HighLevelClient(client());
            .startObject()
        updateSettingsRequest.transientSettings(singletonMap("cluster.remote." + remoteClusterName + ".seeds", transportAddress));
            .putSettings(updateSettingsRequest, RequestOptions.DEFAULT);
 * software distributed under the License is distributed on an
    }
            pipelineBuilder.field(Pipeline.DESCRIPTION_KEY, "some random set of processors");
import java.util.Arrays;
public abstract class OpenSearchRestHighLevelClientTestCase extends OpenSearchRestTestCase {
        SyncMethod<Req, Resp> syncMethod,
import static org.hamcrest.Matchers.lessThan;
    }
            .endObject()
import org.opensearch.common.util.concurrent.ThreadContext;
            .endObject()
        return searchAll(searchRequest);
}
            return future.actionGet();
     * Executes the provided request using either the sync method or its async variant, both provided as functions
                    pipelineBuilder.field("field", "rank").field("type", "integer");
     * Executes the provided request using either the sync method or its async
        );
    }
    @FunctionalInterface
            pipelineBuilder.contentType()
            .startObject("set")
     */
            assertThat(response, notNullValue());
 * Unless required by applicable law or agreed to in writing,
    protected static void setupRemoteClusterConfig(String remoteClusterName) throws Exception {
/*
            CONFLICT_PIPELINE_ID,
 * this file be licensed under the Apache-2.0 license or a
            BytesReference.bytes(pipelineBuilder),
        restHighLevelClient = null;
    /**
import java.util.Base64;
import org.opensearch.action.ingest.PutPipelineRequest;
        }
        if (restHighLevelClient == null) {
        return buildRandomXContentPipeline(pipelineBuilder);
            .field("value", 1)
import static org.hamcrest.Matchers.greaterThan;
        );
    protected static <Req, Resp> Resp execute(Req request, SyncMethod<Req, Resp> syncMethod, AsyncMethod<Req, Resp> asyncMethod)
        return search.getHits();
                {
 * compatible open source license.
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
    protected static CheckedRunnable<Exception> checkTaskCompletionStatus(RestClient client, String taskId) {
import org.opensearch.client.cluster.RemoteInfoResponse;
 * not use this file except in compliance with the License.
        CreateIndexRequest indexRequest = new CreateIndexRequest(index);
 *
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
    ) throws IOException {
    ) throws IOException {
        long start = System.nanoTime();
import org.opensearch.action.search.SearchRequest;
        int shards = randomIntBetween(8, 10);
            pipelineBuilder.endArray();
import org.opensearch.search.SearchModule;
                continue;
import java.util.concurrent.TimeUnit;
        }
            assertThat("tasks are left over from the last execution of this test", taskGroups, hasSize(lessThan(2)));
    }
    }
        RequestOptions options
        Response execute(Request request, RequestOptions options) throws IOException;
    protected static RestHighLevelClient highLevelClient() {
