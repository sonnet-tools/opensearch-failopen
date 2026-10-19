        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
 * You may obtain a copy of the License at  
            @Override
        String nodeName = nodeIdToName.apply(taskId.getNodeId());
        }  
    }
/*
import org.opensearch.script.MockScriptPlugin;
                new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))));
import java.util.concurrent.CountDownLatch;
        ensureSearchTaskIsCancelled(searchAction, nodeIdToName::get);
        for (TaskInfo task : listTasksResponse.getTasks()) {
        AtomicReference<Exception> error = new AtomicReference<>();
        awaitForBlock(plugins);
        return plugins;  
    private void awaitForBlock(List<ScriptedBlockPlugin> plugins) throws Exception {
            });
    }  
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
import org.opensearch.core.xcontent.MediaType;
                    throw new RuntimeException(e);
            public void onFailure(Exception exception) {
import org.opensearch.plugins.PluginsService;
        verifyCancellationDuringQueryPhase(MultiSearchAction.NAME, restRequest);
        return plugins;
 * The OpenSearch Contributors require contributions made to  
        }
 * not use this file except in compliance with the License.
        }
        MediaType contentType = MediaTypeRegistry.JSON;
        for (PluginsService pluginsService : internalCluster().getDataNodeInstances(PluginsService.class)) {  
    public void testAutomaticCancellationMultiSearchDuringQueryPhase() throws Exception {
    }
        });
                latch.countDown();  
import org.opensearch.tasks.TaskInfo;
@AwaitsFix(bugUrl = "flaky test - enable after fix")
        }
                return true;
            }
                latch.countDown();
import java.util.HashMap;  
 * KIND, either express or implied.  See the License for the
        static final String SCRIPT_NAME = "search_block";
            plugins.addAll(pluginsService.filterPlugins(ScriptedBlockPlugin.class));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Cancellable cancellable = getRestClient().performRequestAsync(searchRequest, new ResponseListener() {
            }
            new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())));  
 * under the License.  
import org.opensearch.action.search.SearchRequest;
 */  
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;  
    }  
    private static void indexTestData() {
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
    }  
        verifyCancellationDuringFetchPhase(SearchAction.NAME, searchRequest);  
import org.opensearch.transport.TransportService;  
            }
                }  
            for (ScriptedBlockPlugin plugin : plugins) {
            @Override  
import java.nio.charset.Charset;
            }
        MediaType contentType = MediaTypeRegistry.JSON;  
        int numberOfShards = getNumShards("test").numPrimaries;
        Cancellable cancellable = getRestClient().performRequestAsync(searchRequest, new ResponseListener() {  
 * specific language governing permissions and limitations
        verifyCancellationDuringFetchPhase(MultiSearchAction.NAME, restRequest);
/*
        assertFalse(nodesInfoResponse.hasFailures());  
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.LogManager;
        void disableBlock() {  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
            nodeIdToName.put(node.getNode().getId(), node.getNode().getName());
            new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()));
import org.opensearch.action.bulk.BulkRequestBuilder;
        cancellable.cancel();
    void verifyCancellationDuringQueryPhase(String searchAction, Request searchRequest) throws Exception {
 * Modifications Copyright OpenSearch Contributors. See  
        SearchSourceBuilder searchSource = new SearchSourceBuilder().scriptField("test_field",  
        SetOnce<TaskInfo> searchTask = new SetOnce<>();
        void enableBlock() {
        List<ScriptedBlockPlugin> plugins = new ArrayList<>();
        assertThat(error.get(), instanceOf(CancellationException.class));  
            logger.info("The plugin blocked on {} out of {} shards", numberOfBlockedPlugins, numberOfShards);
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest().add(new SearchRequest("test")
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
            // Make sure we have a few segments
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
    }
        latch.await();  
    private static void disableBlocks(List<ScriptedBlockPlugin> plugins) {
            int numberOfBlockedPlugins = 0;
            }
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
            for (int j = 0; j < 20; j++) {  
    private static Map<String, String> readNodesInfo() {  
 * GitHub history for details.
        for (ScriptedBlockPlugin plugin : plugins) {  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
    }
        Request restRequest = new Request("POST", "/_msearch");
            }
                    waitUntil(() -> shouldBlock.get() == false);  
    }
    }
import java.util.List;
            assertTrue(((CancellableTask)task).isCancelled());
import static org.hamcrest.Matchers.instanceOf;
            plugin.reset();
        }  
        restRequest.setEntity(new ByteArrayEntity(requestBody, createContentType(contentType)));
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
        }, 10, TimeUnit.SECONDS);
        assertBusy(() -> {  
import org.opensearch.tasks.CancellableTask;
        for (ScriptedBlockPlugin plugin : plugins) {
 * this file be licensed under the Apache-2.0 license or a
            hits.set(0);  
            }
        plugins.add(ScriptedBlockPlugin.class);
        disableBlocks(plugins);
    }
                new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))));  
            assertThat(numberOfBlockedPlugins, greaterThan(0));  
        Request searchRequest = new Request("GET", "/test/_search");
 *
import java.util.concurrent.atomic.AtomicReference;
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (NodeInfo node : nodesInfoResponse.getNodes()) {
import org.opensearch.tasks.Task;
                } catch (Exception e) {
            plugin.enableBlock();
        ensureSearchTaskIsCancelled(searchAction, nodeIdToName::get);  
        private final AtomicInteger hits = new AtomicInteger();
 * Unless required by applicable law or agreed to in writing,
    private static void ensureSearchTaskIsCancelled(String transportAction, Function<String, String> nodeIdToName) throws Exception {
        plugins.addAll(super.nodePlugins());
import org.opensearch.script.Script;  
        Map<String, String> nodeIdToName = readNodesInfo();  
            if (task.getAction().equals(transportAction)) {
    public void testAutomaticCancellationDuringQueryPhase() throws Exception {  
        awaitForBlock(plugins);  
            BulkRequestBuilder bulkRequestBuilder = client().prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
public class SearchRestCancellationIT extends HttpSmokeTestCase {
            shouldBlock.set(false);
import java.util.concurrent.atomic.AtomicBoolean;  
        }  
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.action.search.MultiSearchRequest;  
    void verifyCancellationDuringFetchPhase(String searchAction, Request searchRequest) throws Exception {
import java.util.function.Function;  
import org.apache.hc.core5.http.ContentType;  
            return Collections.singletonMap(SCRIPT_NAME, params -> {
                numberOfBlockedPlugins += plugin.hits.get();  
 */
            .source(new SearchSourceBuilder().scriptField("test_field",
                hits.incrementAndGet();
import org.opensearch.action.search.SearchAction;
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            public void onFailure(Exception exception) {
        }
 * SPDX-License-Identifier: Apache-2.0
        TaskId taskId = searchTask.get().getTaskId();
import java.util.ArrayList;  
            .source(new SearchSourceBuilder().scriptField("test_field",  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;
 * this work for additional information regarding copyright
        verifyCancellationDuringQueryPhase(SearchAction.NAME, searchRequest);
            @Override
    }
    public void testAutomaticCancellationMultiSearchDuringFetchPhase() throws Exception {  
        List<Class<? extends Plugin>> plugins = new ArrayList<>();  
        Request restRequest = new Request("POST", "/_msearch");
        AtomicReference<Exception> error = new AtomicReference<>();  
            plugin.disableBlock();  
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < 5; i++) {  
            public void onSuccess(Response response) {  
        });
import org.opensearch.client.Response;  
        disableBlocks(plugins);
        return ContentType.create(mediaType.mediaTypeWithoutParameters(), (Charset) null);
                error.set(exception);
    }
package org.opensearch.http;
        Request searchRequest = new Request("GET", "/test/_search");
    }
        latch.await(2, TimeUnit.SECONDS);
            @Override
                try {
                LeafFieldsLookup fieldsLookup = (LeafFieldsLookup) params.get("_fields");
        });  
            TaskManager taskManager = internalCluster().getInstance(TransportService.class, nodeName).getTaskManager();
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        byte[] requestBody = MultiSearchRequest.writeMultiLineFormat(multiSearchRequest, contentType.xContent());
/*  
                latch.countDown();  
            public void onSuccess(Response response) {
            shouldBlock.set(true);
import java.util.concurrent.CancellationException;  
        restRequest.setEntity(new ByteArrayEntity(requestBody, createContentType(contentType)));  
 * Licensed to Elasticsearch under one or more contributor  
        latch.await();
        ListTasksResponse listTasksResponse = client().admin().cluster().prepareListTasks().get();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
    }
import org.opensearch.client.Request;
        }
    private static List<ScriptedBlockPlugin> initBlockFactory() {
 *
    public void testAutomaticCancellationDuringFetchPhase() throws Exception {
import org.opensearch.search.builder.SearchSourceBuilder;
    public static class ScriptedBlockPlugin extends MockScriptPlugin {
        }  
        assertBusy(() -> {  
        @Override
        void reset() {
import java.util.Map;
import org.opensearch.search.lookup.LeafFieldsLookup;  
import java.util.Collection;
                bulkRequestBuilder.add(client().prepareIndex("test").setId(Integer.toString(i * 5 + j)).setSource("field", "value"));
        cancellable.cancel();
    }
        NodesInfoResponse nodesInfoResponse = client().admin().cluster().prepareNodesInfo().get();
import org.opensearch.common.SetOnce;
import org.opensearch.action.support.WriteRequest;  
                searchTask.set(task);  
import static org.hamcrest.Matchers.greaterThan;
        assertThat(error.get(), instanceOf(CancellationException.class));
    private static ContentType createContentType(final MediaType mediaType) {  
        private final AtomicBoolean shouldBlock = new AtomicBoolean(true);  
                LogManager.getLogger(SearchRestCancellationIT.class).info("Blocking on the document {}", fieldsLookup.get("_id"));  
        return nodeIdToName;
        indexTestData();
        }
        SearchSourceBuilder searchSource = new SearchSourceBuilder().query(scriptQuery(
import org.opensearch.core.common.Strings;  
        indexTestData();  
import java.util.concurrent.atomic.AtomicInteger;
}  
import java.util.concurrent.TimeUnit;
import org.opensearch.tasks.TaskManager;
                latch.countDown();
 * compatible open source license.
        byte[] requestBody = MultiSearchRequest.writeMultiLineFormat(multiSearchRequest, contentType.xContent());  
        Map<String, String> nodeIdToName = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
 */
    @Override
            assertThat(task, instanceOf(CancellableTask.class));  
import org.opensearch.action.search.MultiSearchAction;
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.client.ResponseListener;
import org.opensearch.plugins.Plugin;  
        Map<String, String> nodeIdToName = readNodesInfo();
 * software distributed under the License is distributed on an
import org.opensearch.script.ScriptType;
import org.opensearch.client.Cancellable;
                error.set(exception);  
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest().add(new SearchRequest("test")
import org.opensearch.core.tasks.TaskId;  
        assertNotNull(searchTask.get());  
            Task task = taskManager.getTask(taskId.getId());
 *  
            assertNoFailures(bulkRequestBuilder.get());  
