 * specific language governing permissions and limitations
                pipelineBuilder.endObject().endObject();  
            "Couldn't find tasks to rethrottle. Here are the running tasks "
        }  
     * Executes the provided request using either the sync method or its async
     */
        ClusterUpdateSettingsRequest updateSettingsRequest = new ClusterUpdateSettingsRequest();
        );
 */  
            .putSettings(updateSettingsRequest, RequestOptions.DEFAULT);
        XContentBuilder pipelineBuilder = XContentBuilder.builder(xContentType.xContent());
        String transportAddress = (String) nodesResponse.get("transport_address");  
            .endObject()  
            }
 * this file be licensed under the Apache-2.0 license or a
                .collect(Collectors.toList());  
    }  
    protected static Map<String, Object> toMap(Response response) throws IOException, OpenSearchParseException, ParseException {  
        String joinedIndices = Arrays.stream(indices).collect(Collectors.joining(","));
/*  
import org.opensearch.common.xcontent.json.JsonXContent;
            execute(putPipelineRequest, highLevelClient().ingest()::putPipeline, highLevelClient().ingest()::putPipelineAsync)  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
 * You may obtain a copy of the License at  
import org.opensearch.core.action.ActionListener;  
        nodesResponse = (Map<?, ?>) nodesResponse.get(nodesResponse.keySet().iterator().next());
            .endObject()
        int shards = randomIntBetween(8, 10);  
    }
    }  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        return search.getHits();
        } else {
import org.opensearch.client.cluster.RemoteInfoResponse;
import org.opensearch.common.Booleans;
     * Executes the provided request using either the sync method or its async variant, both provided as functions
            .field("field", fieldName)
        };
 * KIND, either express or implied.  See the License for the
     */
            .endObject()  
import org.opensearch.OpenSearchParseException;  
    /**  
    @FunctionalInterface
import org.opensearch.core.xcontent.MediaTypeRegistry;  
    }  
        super.initClient();  
    protected interface SyncMethodNoRequest<Response> {
 *
            RemoteInfoResponse response = highLevelClient().cluster().remoteInfo(new RemoteInfoRequest(), RequestOptions.DEFAULT);  
    }
 * ownership. Elasticsearch licenses this file to you under  
    protected Settings restClientSettings() {
            list.rethrowFailures("Finding tasks to rethrottle");
        Response execute(RequestOptions options) throws IOException;
    ) throws IOException {
import org.opensearch.common.util.concurrent.ThreadContext;
import java.util.Map;  
                    pipelineBuilder.field("field", "rank").field("type", "integer");
            pipelineBuilder.endArray();
            .endObject();  
            pipelineBuilder.field(Pipeline.DESCRIPTION_KEY, "some random set of processors");  
            return future.actionGet();
}
        highLevelClient().indices().create(indexRequest, RequestOptions.DEFAULT);
        }  
    protected static <Req, Resp> Resp execute(  
            super(restClient, (client) -> {}, new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents());
            .endObject()  
    protected static TaskId findTaskToRethrottle(String actionName, String description) throws IOException {
            PlainActionFuture<Resp> future = PlainActionFuture.newFuture();
import org.junit.AfterClass;  
        long start = System.nanoTime();
    protected void refreshIndexes(String... indices) throws IOException {
            return future.actionGet();  
    private static boolean async = Booleans.parseBoolean(System.getProperty("tests.rest.async", "false"));
            .startArray("processors")
            execute(request, highLevelClient().cluster()::putSettings, highLevelClient().cluster()::putSettingsAsync).isAcknowledged()
    protected void createIndexWithMultipleShards(String index) throws IOException {
            asyncMethod.execute(request, options, future);
                {  
import java.util.Base64;  
    protected static XContentBuilder buildRandomXContentPipeline() throws IOException {
    @AfterClass  
    }
import org.opensearch.client.cluster.RemoteInfoRequest;
                + highLevelClient().tasks().list(request, RequestOptions.DEFAULT)  
        Map<?, ?> nodesResponse = (Map<?, ?>) toMap(client().performRequest(request)).get("nodes");  
        return () -> {
                }
    }  
    protected Iterable<SearchHit> searchAll(String... indices) throws IOException {
        pipelineBuilder.endObject();
    }
import org.opensearch.common.settings.Settings;  
        refreshIndexes(searchRequest.indices());
            .endObject()
 *    http://www.apache.org/licenses/LICENSE-2.0
                pipelineBuilder.startObject().startObject("set");  
        request.setActions(actionName);
import java.util.Arrays;
            return taskGroup.getTaskInfo().getTaskId();
            return syncMethod.execute(request, options);
import org.opensearch.test.rest.OpenSearchRestTestCase;
    protected static void setupRemoteClusterConfig(String remoteClusterName) throws Exception {
        if (async == false) {  
 * not use this file except in compliance with the License.
    /**  
        return buildRandomXContentPipeline(pipelineBuilder);
/*
import static org.hamcrest.Matchers.notNullValue;  
    protected static void clusterUpdateSettings(Settings persistentSettings, Settings transientSettings) throws IOException {
    protected void putConflictPipeline() throws IOException {
            .startObject("set")  
 * this work for additional information regarding copyright
    protected static CheckedRunnable<Exception> checkTaskCompletionStatus(RestClient client, String taskId) {
            .startObject("set")  
import org.opensearch.search.SearchModule;
import org.apache.hc.core5.http.ParseException;
        Req request,
    public static void cleanupClient() throws IOException {
            List<TaskGroup> taskGroups = list.getTaskGroups()  
        // Configure local cluster as remote cluster:  
        RequestOptions requestOptions
            .field("value", value)
            assertThat(taskGroup.getChildTasks(), empty());
        SyncMethod<Req, Resp> syncMethod,
        SyncMethodNoRequest<Resp> syncMethodNoRequest,  
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.core.common.bytes.BytesReference;
    }
    protected static <Resp> Resp execute(
            assertThat(response, notNullValue());
        if (async == false) {
        ListTasksRequest request = new ListTasksRequest();  
        Response refreshResponse = client().performRequest(new Request("POST", "/" + joinedIndices + "/_refresh"));  
     * not have a request object (only headers and the request path).  
            pipelineBuilder.startArray(Pipeline.PROCESSORS_KEY);
            Response response = client.performRequest(new Request("GET", "/_tasks/" + taskId));  
        );
 */
 * GitHub history for details.
        });  
        updateSettingsRequest.transientSettings(singletonMap("cluster.remote." + remoteClusterName + ".seeds", transportAddress));  
                continue;
        indexRequest.settings(Settings.builder().put("index.number_of_shards", shards).put("index.number_of_replicas", 0));
    }  
import org.opensearch.search.SearchHit;  
 */  
        restHighLevelClient = null;  
import java.util.List;
            CONFLICT_PIPELINE_ID,
import org.opensearch.action.search.SearchResponse;
            return syncMethodNoRequest.execute(requestOptions);
            .field("field", "_version")
import org.junit.Before;
            .startObject()
import java.util.Objects;
    }  
            {
                {
            BytesReference.bytes(pipelineBuilder),  
            if (0 == taskGroups.size()) {
 *  
    }
        );
            .endObject();  
        final XContentBuilder pipelineBuilder = jsonBuilder().startObject()  
                pipelineBuilder.startObject().startObject("convert");
        void execute(Request request, RequestOptions options, ActionListener<Response> listener);
import java.util.stream.Collectors;  
        final String token = "Basic " + Base64.getEncoder().encodeToString((user + ":" + pass).getBytes(StandardCharsets.UTF_8));
        assertEquals(200, refreshResponse.getStatusLine().getStatusCode());
        );
        }  
            assertThat("tasks are left over from the last execution of this test", taskGroups, hasSize(lessThan(2)));
        final PutPipelineRequest putPipelineRequest = new PutPipelineRequest(
import static org.hamcrest.Matchers.hasSize;  
public abstract class OpenSearchRestHighLevelClientTestCase extends OpenSearchRestTestCase {
import org.opensearch.common.xcontent.XContentHelper;  
 * Licensed to Elasticsearch under one or more contributor  
    }
import org.opensearch.common.CheckedRunnable;
        SearchResponse search = highLevelClient().search(searchRequest, RequestOptions.DEFAULT);  
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(
    }  
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static RestHighLevelClient restHighLevelClient;
        // TODO: replace with nodes info highlevel rest client code when it is available:
import org.opensearch.core.tasks.TaskId;
            PlainActionFuture<Resp> future = PlainActionFuture.newFuture();  
    private static class HighLevelClient extends RestHighLevelClient {  
    protected static RestHighLevelClient highLevelClient() {  
import java.io.IOException;  
            .field("value", 1)
import java.util.Collections;
            .field("field", "_id")
        return searchAll(searchRequest);
        XContentType xContentType = randomFrom(XContentType.values());  
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;  
                    pipelineBuilder.field("field", "foo").field("value", "bar");
        XContentBuilder builder = buildRandomXContentPipeline();  
import static org.hamcrest.Matchers.greaterThan;
import static java.util.Collections.singletonMap;
    }
import org.opensearch.action.ingest.PutPipelineRequest;  
    }
                // The parent task hasn't started yet  
import org.apache.hc.core5.http.io.entity.EntityUtils;
 * software distributed under the License is distributed on an
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksRequest;
            .endObject()
        return Settings.builder().put(super.restClientSettings()).put(ThreadContext.PREFIX + ".Authorization", token).build();
        assertTrue(highLevelClient().ingest().putPipeline(putPipelineRequest, RequestOptions.DEFAULT).isAcknowledged());  
        } while (System.nanoTime() - start < TimeUnit.SECONDS.toNanos(10));  
                .stream()
 * license agreements. See the NOTICE file distributed with
import org.opensearch.client.indices.CreateIndexRequest;  
    protected static void createPipeline(PutPipelineRequest putPipelineRequest) throws IOException {
            .startObject("set")  
    protected Iterable<SearchHit> searchAll(SearchRequest searchRequest) throws IOException {
        return execute(request, syncMethod, asyncMethod, RequestOptions.DEFAULT);  
        request.transientSettings(transientSettings);
     * variant, both provided as functions. This variant is used when the call does
     * Executes the provided request using either the sync method or its async variant, both provided as functions
    @Override  
     */  
            .startArray("processors")
    /**
            .endArray()
            TaskGroup taskGroup = taskGroups.get(0);  
        request.setDetailed(true);
        do {  
                pipelineBuilder.endObject().endObject();
        throw new AssertionError(
    }
        return restHighLevelClient;
        return XContentHelper.convertToMap(JsonXContent.jsonXContent, EntityUtils.toString(response.getEntity()), false);
    }
            ListTasksResponse list = highLevelClient().tasks().list(request, RequestOptions.DEFAULT);
    protected static <Req, Resp> Resp execute(Req request, SyncMethod<Req, Resp> syncMethod, AsyncMethod<Req, Resp> asyncMethod)
import static org.hamcrest.Matchers.empty;
        } else {  
 * Unless required by applicable law or agreed to in writing,
            asyncMethodNoRequest.execute(requestOptions, future);
    protected static final double DOUBLE_DELTA = 0.000001;
        CreateIndexRequest indexRequest = new CreateIndexRequest(index);
    protected static final String CONFLICT_PIPELINE_ID = "conflict_pipeline";
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
import org.opensearch.ingest.Pipeline;
    }  
    protected static XContentBuilder buildRandomXContentPipeline(XContentBuilder pipelineBuilder) throws IOException {  
                }  
    @FunctionalInterface
        // Select node info of first node (we don't know the node id):
    protected static void createPipeline(String pipelineId) throws IOException {
import org.opensearch.common.xcontent.XContentType;
            }
        AsyncMethodNoRequest<Resp> asyncMethodNoRequest,
    protected static void createFieldAddingPipleine(String id, String fieldName, String value) throws IOException {
            assertThat(response.getInfos().size(), greaterThan(0));
        final String pass = Objects.requireNonNull(System.getProperty("tests.rest.cluster.password"));  
    }
import static org.hamcrest.Matchers.lessThan;
    protected interface AsyncMethod<Request, Response> {  
        RequestOptions options
    }
        assertThat(updateSettingsResponse.isAcknowledged(), is(true));  
    @FunctionalInterface  
    }
    public void initHighLevelClient() throws IOException {
        void execute(RequestOptions options, ActionListener<Response> listener);  
            restHighLevelClient = new HighLevelClient(client());
        SearchRequest searchRequest = new SearchRequest(indices);  
                .isAcknowledged()
    }
import java.util.concurrent.TimeUnit;
            .startObject()
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
        createPipeline(new PutPipelineRequest(pipelineId, BytesReference.bytes(builder), builder.contentType()));
            pipelineBuilder.contentType()
    @FunctionalInterface
import org.opensearch.action.search.SearchRequest;
    protected interface SyncMethod<Request, Response> {
        if (restHighLevelClient == null) {
    }
        throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        assertBusy(() -> {
        final Request request = new Request("GET", "/_nodes");
package org.opensearch.client;
 *
        AsyncMethod<Req, Resp> asyncMethod,  
        }  
import org.opensearch.core.xcontent.XContentBuilder;
            .startObject()
        assertTrue(  
            .field("value", "1")
        return pipelineBuilder;
        IOUtils.close(restHighLevelClient);
        Response execute(Request request, RequestOptions options) throws IOException;  
        createPipeline(new PutPipelineRequest(id, BytesReference.bytes(pipeline), MediaTypeRegistry.JSON));
    @Before
    }
        request.persistentSettings(persistentSettings);
        }
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
import java.nio.charset.StandardCharsets;
 * under the License.  
                .filter(taskGroup -> taskGroup.getTaskInfo().getDescription().equals(description))
import static org.hamcrest.Matchers.is;
    }
        pipelineBuilder.startObject();
    }  
        {
import org.opensearch.action.support.PlainActionFuture;  
        XContentBuilder pipeline = jsonBuilder().startObject()  
        ClusterUpdateSettingsResponse updateSettingsResponse = restHighLevelClient.cluster()
 * compatible open source license.
        private HighLevelClient(RestClient restClient) {
            assertTrue((boolean) entityAsMap(response).get("completed"));
        final String user = Objects.requireNonNull(System.getProperty("tests.rest.cluster.username"));
/*  
    ) throws IOException {  
    protected interface AsyncMethodNoRequest<Response> {
            .endArray()
