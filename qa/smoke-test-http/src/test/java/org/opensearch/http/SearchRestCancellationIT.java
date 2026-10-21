import java.util.concurrent.CancellationException;
    public static class ScriptedBlockPlugin extends MockScriptPlugin {
import org.opensearch.client.Request;
            for (int j = 0; j < 20; j++) {
                LeafFieldsLookup fieldsLookup = (LeafFieldsLookup) params.get("_fields");
package org.opensearch.http;
    public void testAutomaticCancellationDuringFetchPhase() throws Exception {
        });
            plugin.enableBlock();
        void disableBlock() {
                    throw new RuntimeException(e);
            plugin.reset();
 * Unless required by applicable law or agreed to in writing,
        return plugins;
        return ContentType.create(mediaType.mediaTypeWithoutParameters(), (Charset) null);
import static org.opensearch.index.query.QueryBuilders.scriptQuery;
import org.opensearch.client.Response;
import org.opensearch.action.bulk.BulkRequestBuilder;
 *    http://www.apache.org/licenses/LICENSE-2.0
                } catch (Exception e) {
 * Modifications Copyright OpenSearch Contributors. See
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest().add(new SearchRequest("test")
/*
            assertNoFailures(bulkRequestBuilder.get());
import static org.hamcrest.Matchers.greaterThan;
    }
 * license agreements. See the NOTICE file distributed with
        Map<String, String> nodeIdToName = readNodesInfo();
        return plugins;
            }
    void verifyCancellationDuringQueryPhase(String searchAction, Request searchRequest) throws Exception {
                    waitUntil(() -> shouldBlock.get() == false);
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            public void onFailure(Exception exception) {
            hits.set(0);
        for (PluginsService pluginsService : internalCluster().getDataNodeInstances(PluginsService.class)) {
import static org.hamcrest.Matchers.instanceOf;
 *
    }
                numberOfBlockedPlugins += plugin.hits.get();
            public void onFailure(Exception exception) {
import org.opensearch.tasks.TaskManager;
import org.opensearch.tasks.TaskInfo;
                error.set(exception);
        private final AtomicBoolean shouldBlock = new AtomicBoolean(true);
            nodeIdToName.put(node.getNode().getId(), node.getNode().getName());
        }
 * this work for additional information regarding copyright
import java.util.ArrayList;
                searchTask.set(task);
    private static void disableBlocks(List<ScriptedBlockPlugin> plugins) {
            @Override
    public void testAutomaticCancellationMultiSearchDuringFetchPhase() throws Exception {
 *
        byte[] requestBody = MultiSearchRequest.writeMultiLineFormat(multiSearchRequest, contentType.xContent());
import org.opensearch.core.xcontent.MediaType;
            new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap())));
import org.opensearch.action.search.SearchAction;
        for (NodeInfo node : nodesInfoResponse.getNodes()) {
            }
import org.opensearch.action.search.MultiSearchAction;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
    }
    }
        for (ScriptedBlockPlugin plugin : plugins) {
            .source(new SearchSourceBuilder().scriptField("test_field",
                try {
import org.opensearch.core.common.Strings;
    private void awaitForBlock(List<ScriptedBlockPlugin> plugins) throws Exception {
    private static List<ScriptedBlockPlugin> initBlockFactory() {
        assertNotNull(searchTask.get());
    }
import org.opensearch.search.lookup.LeafFieldsLookup;
    }
            }
        TaskId taskId = searchTask.get().getTaskId();
import java.util.concurrent.atomic.AtomicBoolean;
        CountDownLatch latch = new CountDownLatch(1);
        }
        cancellable.cancel();
import java.util.concurrent.TimeUnit;
import org.opensearch.action.search.SearchRequest;
    @Override
        void enableBlock() {
import java.util.Collection;
            });
        });
 * software distributed under the License is distributed on an
        }
        assertBusy(() -> {
 * under the License.
    public void testAutomaticCancellationMultiSearchDuringQueryPhase() throws Exception {
        verifyCancellationDuringQueryPhase(MultiSearchAction.NAME, restRequest);
            logger.info("The plugin blocked on {} out of {} shards", numberOfBlockedPlugins, numberOfShards);
            @Override
            @Override
        verifyCancellationDuringQueryPhase(SearchAction.NAME, searchRequest);
                error.set(exception);
        ListTasksResponse listTasksResponse = client().admin().cluster().prepareListTasks().get();
 * the Apache License, Version 2.0 (the "License"); you may
/*
    private static Map<String, String> readNodesInfo() {
import org.apache.hc.core5.http.io.entity.ByteArrayEntity;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.plugins.PluginsService;
import org.opensearch.plugins.Plugin;
            }
import org.opensearch.common.SetOnce;
        latch.await();
        MultiSearchRequest multiSearchRequest = new MultiSearchRequest().add(new SearchRequest("test")
    }
    public void testAutomaticCancellationDuringQueryPhase() throws Exception {
        String nodeName = nodeIdToName.apply(taskId.getNodeId());
import org.opensearch.script.ScriptType;
            BulkRequestBuilder bulkRequestBuilder = client().prepareBulk().setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE);
        SearchSourceBuilder searchSource = new SearchSourceBuilder().scriptField("test_field",
 * compatible open source license.
            plugins.addAll(pluginsService.filterPlugins(ScriptedBlockPlugin.class));
        disableBlocks(plugins);
            Task task = taskManager.getTask(taskId.getId());
        indexTestData();
public class SearchRestCancellationIT extends HttpSmokeTestCase {
        return nodeIdToName;
import org.opensearch.action.search.MultiSearchRequest;
        Cancellable cancellable = getRestClient().performRequestAsync(searchRequest, new ResponseListener() {
                LogManager.getLogger(SearchRestCancellationIT.class).info("Blocking on the document {}", fieldsLookup.get("_id"));
                latch.countDown();
        byte[] requestBody = MultiSearchRequest.writeMultiLineFormat(multiSearchRequest, contentType.xContent());
}
            TaskManager taskManager = internalCluster().getInstance(TransportService.class, nodeName).getTaskManager();
        latch.await(2, TimeUnit.SECONDS);
        ensureSearchTaskIsCancelled(searchAction, nodeIdToName::get);
            shouldBlock.set(false);
    }
        }
        restRequest.setEntity(new ByteArrayEntity(requestBody, createContentType(contentType)));
import java.nio.charset.Charset;
 * Licensed to Elasticsearch under one or more contributor
    }
        MediaType contentType = MediaTypeRegistry.JSON;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
            public void onSuccess(Response response) {
            plugin.disableBlock();
    private static void indexTestData() {
        List<Class<? extends Plugin>> plugins = new ArrayList<>();
        });
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
        Request searchRequest = new Request("GET", "/test/_search");
import org.opensearch.script.Script;
        assertBusy(() -> {
        restRequest.setEntity(new ByteArrayEntity(requestBody, createContentType(contentType)));
 * You may obtain a copy of the License at
import java.util.concurrent.CountDownLatch;
import org.opensearch.script.MockScriptPlugin;
                }
            @Override
        @Override
                new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))));
 */
        void reset() {
            shouldBlock.set(true);
        }
 * specific language governing permissions and limitations
    }
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        Request searchRequest = new Request("GET", "/test/_search");
        awaitForBlock(plugins);
            public void onSuccess(Response response) {
 * GitHub history for details.
        awaitForBlock(plugins);
    }
        }, 10, TimeUnit.SECONDS);
import org.opensearch.core.tasks.TaskId;
import org.apache.logging.log4j.LogManager;
import java.util.concurrent.atomic.AtomicInteger;
 * KIND, either express or implied.  See the License for the
        assertThat(error.get(), instanceOf(CancellationException.class));
import org.apache.hc.core5.http.ContentType;
        verifyCancellationDuringFetchPhase(MultiSearchAction.NAME, restRequest);
        }
        CountDownLatch latch = new CountDownLatch(1);
                bulkRequestBuilder.add(client().prepareIndex("test").setId(Integer.toString(i * 5 + j)).setSource("field", "value"));
import org.opensearch.search.builder.SearchSourceBuilder;
        }
            assertThat(task, instanceOf(CancellableTask.class));
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
 * not use this file except in compliance with the License.
import org.opensearch.client.ResponseListener;
    }
            new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()));
 */
import java.util.Map;
import org.opensearch.action.support.WriteRequest;
    }
            .source(new SearchSourceBuilder().scriptField("test_field",
        Request restRequest = new Request("POST", "/_msearch");
        NodesInfoResponse nodesInfoResponse = client().admin().cluster().prepareNodesInfo().get();
    void verifyCancellationDuringFetchPhase(String searchAction, Request searchRequest) throws Exception {
        static final String SCRIPT_NAME = "search_block";
        plugins.add(ScriptedBlockPlugin.class);
        ensureSearchTaskIsCancelled(searchAction, nodeIdToName::get);
                hits.incrementAndGet();
            }
            }
 */
import org.opensearch.tasks.CancellableTask;
                latch.countDown();
            return Collections.singletonMap(SCRIPT_NAME, params -> {
 * this file be licensed under the Apache-2.0 license or a
        Request restRequest = new Request("POST", "/_msearch");
import java.util.function.Function;
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
        verifyCancellationDuringFetchPhase(SearchAction.NAME, searchRequest);
import java.util.List;
        MediaType contentType = MediaTypeRegistry.JSON;
        Map<String, String> nodeIdToName = new HashMap<>();
            if (task.getAction().equals(transportAction)) {
        searchRequest.setJsonEntity(Strings.toString(MediaTypeRegistry.JSON, searchSource));
        cancellable.cancel();
        List<ScriptedBlockPlugin> plugins = new ArrayList<>();
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
        private final AtomicInteger hits = new AtomicInteger();
            for (ScriptedBlockPlugin plugin : plugins) {
        for (int i = 0; i < 5; i++) {
        assertThat(error.get(), instanceOf(CancellationException.class));
        AtomicReference<Exception> error = new AtomicReference<>();
import org.opensearch.tasks.Task;
        plugins.addAll(super.nodePlugins());
        List<ScriptedBlockPlugin> plugins = initBlockFactory();
    }
        indexTestData();
    private static void ensureSearchTaskIsCancelled(String transportAction, Function<String, String> nodeIdToName) throws Exception {
import org.opensearch.client.Cancellable;
        Cancellable cancellable = getRestClient().performRequestAsync(searchRequest, new ResponseListener() {
        int numberOfShards = getNumShards("test").numPrimaries;
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
@AwaitsFix(bugUrl = "flaky test - enable after fix")
        }
        for (ScriptedBlockPlugin plugin : plugins) {
                latch.countDown();
import java.util.HashMap;
/*
            assertTrue(((CancellableTask)task).isCancelled());
                latch.countDown();
        assertFalse(nodesInfoResponse.hasFailures());
        for (TaskInfo task : listTasksResponse.getTasks()) {
            }
 * The OpenSearch Contributors require contributions made to
            assertThat(numberOfBlockedPlugins, greaterThan(0));
        SearchSourceBuilder searchSource = new SearchSourceBuilder().query(scriptQuery(
                return true;
        disableBlocks(plugins);
    private static ContentType createContentType(final MediaType mediaType) {
                new Script(ScriptType.INLINE, "mockscript", ScriptedBlockPlugin.SCRIPT_NAME, Collections.emptyMap()))));
        Map<String, String> nodeIdToName = readNodesInfo();
            // Make sure we have a few segments
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        latch.await();
            int numberOfBlockedPlugins = 0;
 * SPDX-License-Identifier: Apache-2.0
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        SetOnce<TaskInfo> searchTask = new SetOnce<>();
        }
import org.opensearch.transport.TransportService;
        AtomicReference<Exception> error = new AtomicReference<>();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
