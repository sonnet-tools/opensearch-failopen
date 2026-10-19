        }  
 * SPDX-License-Identifier: Apache-2.0
            ListTasksResponse tasksList = client.admin().cluster().prepareListTasks()  
        {
            }  
import java.util.Arrays;  
        // tag::delete-by-query-sync  
            // Cancel all update-by-query requests
            assertEquals(updateByQuery.request().getScript().getLang(), "painless");
import org.opensearch.index.reindex.ReindexRequestBuilder;
                    ScriptType.INLINE,
                        + "} else if (ctx._source.awesome == 'lame') {"
                .filter(QueryBuilders.termQuery("level", "awesome"))
            // validate order of string params to Script constructor
            BulkByScrollResponse response = updateByQuery.get();
        {
            // end::update-by-query-filter
        {
import org.junit.Before;
            // tag::update-by-query-multi-index
        {
import org.opensearch.search.sort.SortOrder;
            try {  
        ALLOWED_OPERATIONS.release(builder.request().getSlices());
 *    http://www.apache.org/licenses/LICENSE-2.0
                if (ALLOWED_OPERATIONS.tryAcquire(30, TimeUnit.SECONDS)) {
    @SuppressWarnings("unused")
        }
        BulkByScrollResponse response =  
        indexRandom(
        Client client = client();
 * Licensed to Elasticsearch under one or more contributor  
                .setTaskId(taskId)  
                .setRequestsPerSecond(2.0f)
        assertThat(ALLOWED_OPERATIONS.drainPermits(), equalTo(0));
        {
            .source("persons")                                      // <2>  
 * KIND, either express or implied.  See the License for the
        ALLOWED_OPERATIONS.release(numModifiedDocs - builder.request().getSlices());
            .filter(QueryBuilders.matchQuery("gender", "male"))     // <1>
        return Arrays.asList(ReindexModulePlugin.class, ReindexCancellationPlugin.class);  
        // Checks that the all documents have been indexed and correctly counted
                .setActions(UpdateByQueryAction.NAME).setDetailed(true).get();
        ReindexRequestBuilder builder = new ReindexRequestBuilder(client, ReindexAction.INSTANCE).source(INDEX_NAME)  
 *
        }, 1, TimeUnit.MINUTES);
          new DeleteByQueryRequestBuilder(client, DeleteByQueryAction.INSTANCE)
import java.util.stream.IntStream;  
            // end::update-by-query-multi-index
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                TaskId taskId = info.getTaskId();  
        }  
            // tag::update-by-query-pipeline  
            // tag::update-by-query-size
import org.opensearch.index.shard.IndexingOperationListener;
                BulkByScrollTask.Status status =
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            assertEquals("Expected that no permits are available", 0, ALLOWED_OPERATIONS.availablePermits());  
            // end::update-by-query-size  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.reindex.UpdateByQueryRequestBuilder;  
        }
 * the Apache License, Version 2.0 (the "License"); you may
            // tag::update-by-query-get-task
            throw new IllegalStateException("Something went wrong");
            // end::update-by-query-pipeline
        final Client client = client();
            // end::update-by-query-list-tasks
    public void setup() {
            .filter(QueryBuilders.matchQuery("gender", "male")) // <1>  
                    "painless",
 * You may obtain a copy of the License at  
                .script(new Script(  
     */
    public void testDeleteByQuery() {
        {
        return true;
                .setSize(500);
            return preCheck(delete);
        {  
import org.opensearch.core.index.shard.ShardId;
                .mapToObj(i -> client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("n", Integer.toString(i)))
     * Similar to what CancelTests does: blocks some operations to be able to catch some tasks in running state  
            // tag::update-by-query-filter  
            // tag::update-by-query-routing
        public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {  
 */  
                @Override
import org.opensearch.transport.client.Client;
            updateByQuery.source("source_index")  
/*
        }
    // Semaphore used to allow & block indexing operations during the test
import org.opensearch.tasks.TaskInfo;  
        assertNull(status.getReasonCancelled());
            return preCheck(index);
            BulkByScrollResponse response = updateByQuery.get();
import org.opensearch.index.reindex.ReindexAction;  
        }
            // tag::update-by-query-script
            updateByQuery.setPipeline("hurray");  
        builder.execute();
            new RethrottleRequestBuilder(client, RethrottleAction.INSTANCE)
                        + "} else {"
        }  
            .execute(new ActionListener<BulkByScrollResponse>() {   // <3>
                // do stuff  
 *  
            UpdateByQueryRequestBuilder updateByQuery =
                    return operation;
/*  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.core.tasks.TaskId;
                .source()
        }  
        @Override
        // Scroll by 1 so that cancellation is easier to control
import org.opensearch.plugins.Plugin;
import org.opensearch.core.action.ActionListener;  
            // end::update-by-query-script
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
    public static class ReindexCancellationPlugin extends Plugin {
            UpdateByQueryRequestBuilder updateByQuery =
            // end::update-by-query  
public class ReindexDocumentationIT extends OpenSearchIntegTestCase {
            UpdateByQueryRequestBuilder updateByQuery =
        }
            BulkByScrollResponse response = updateByQuery.get();
            // tag::update-by-query
        public void onIndexModule(IndexModule indexModule) {
    }
            // validate order of string params to Script constructor
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
 */  
    public static class BlockingOperationListener implements IndexingOperationListener {
               new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
                }
                .setTaskId(taskId).get().getTasks();  
 * this file be licensed under the Apache-2.0 license or a
            assertTrue("Expected some queued threads", ALLOWED_OPERATIONS.hasQueuedThreads());
        {
import org.opensearch.index.reindex.BulkByScrollResponse;
        // end::delete-by-query-async
            BulkByScrollResponse response = updateByQuery.get();
    public void testTasks() throws Exception {  
 * not use this file except in compliance with the License.
        }  
    }
        client.admin().indices().preparePutMapping(INDEX_NAME).setSource("cat", "type=keyword").get();
            }
                throw new RuntimeException(e);
        @Override  
}
import org.opensearch.index.IndexModule;  
            // end::update-by-query-get-task  
                        + "  ctx.op='delete'"  
            false,
            // tag::update-by-query-cancel-task  
    }  
 * Unless required by applicable law or agreed to in writing,
            updateByQuery.source("source_index").abortOnVersionConflict(false);
import org.opensearch.script.Script;  
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
            .filter(QueryBuilders.matchQuery("category", "xzy")) // <1>
                    // Handle the exception
                    "if (ctx._source.awesome == 'absolutely') {"  
    }  
import java.util.Collection;
                .addSort("cat", SortOrder.DESC);  
            // end::update-by-query-cancel-task
                        + "  ctx.op='noop'"
import org.opensearch.index.reindex.RethrottleAction;  
    private ReindexRequestBuilder reindexAndPartiallyBlock() throws Exception {  
 * software distributed under the License is distributed on an
        final Client client = client();
        final int numDocs = randomIntBetween(10, 100);
    @Before  
            client.admin().cluster().prepareCancelTasks()
                    (BulkByScrollTask.Status) info.getStatus();
            BulkByScrollResponse response = updateByQuery.get();  
import org.hamcrest.Matcher;  
                    "painless",
    private static final Semaphore ALLOWED_OPERATIONS = new Semaphore(0);
            assertEquals(updateByQuery.request().getScript().getLang(), "painless");
import org.opensearch.index.reindex.UpdateByQueryAction;
        );  
                        + "ctx._source.awesome = 'absolutely'}",
 * compatible open source license.
        assertBusy(() -> {
            // tag::update-by-query-rethrottle
import org.opensearch.index.reindex.CancelTests;  
        Client client = client();  
import org.opensearch.index.query.QueryBuilders;
          new ReindexRequestBuilder(client, ReindexAction.INSTANCE)
import org.opensearch.index.engine.Engine;
        // Now execute the reindex action...  
        }
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
import static org.hamcrest.Matchers.equalTo;  
                public void onFailure(Exception e) {
            });
        {
                .setActions(UpdateByQueryAction.NAME).get().getTasks();  
            updateByQuery.source("source_index")  
        new DeleteByQueryRequestBuilder(client, DeleteByQueryAction.INSTANCE)
package org.opensearch.client.documentation;
    @Override
                .collect(Collectors.toList())
    }
        long deleted = response.getDeleted();                   // <4>  
            indexModule.addIndexOperationListener(new BlockingOperationListener());  
            // end::update-by-query-sort
                .source()  
                .script(new Script(ScriptType.INLINE,  
            BulkByScrollResponse response = updateByQuery.get();
        {  
                @Override  
                    "ctx._source.awesome = 'absolutely'",
            }
                .maxDocs(1000)
    }  
        ALLOWED_OPERATIONS.release(numDocs);  
    }  
    @Override
/*  
        public Engine.Index preIndex(ShardId shardId, Engine.Index index) {
            client.admin().cluster().prepareCancelTasks()
        }  
import java.util.concurrent.TimeUnit;
        }
        // end::reindex1  
            updateByQuery.source().setRouting("cat");
            UpdateByQueryRequestBuilder updateByQuery =  
 * The OpenSearch Contributors require contributions made to  
            GetTaskResponse get = client.admin().cluster().prepareGetTask(taskId).get();
                .get();
            .get();                                             // <3>
        private <T extends Engine.Operation> T preCheck(T operation) {
            } catch (InterruptedException e) {
    }
            BulkByScrollResponse response = updateByQuery.get();
            true,
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 */
    }
        {  
            updateByQuery.source("foo", "bar");
        TaskId taskId = mainTask.getTaskId();
 * GitHub history for details.
import org.opensearch.index.reindex.DeleteByQueryRequestBuilder;
                public void onResponse(BulkByScrollResponse response) {  
        client.admin().indices().prepareCreate("bar").get();
            updateByQuery.source("source_index")
            UpdateByQueryRequestBuilder updateByQuery =  
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
    /**
    public void testUpdateByQuery() {
            UpdateByQueryRequestBuilder updateByQuery =
import java.util.Collections;
                return operation;  
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numDocs);  
        int numModifiedDocs = randomIntBetween(builder.request().getSlices() * 2, numDocs);
        }
            .source("persons")                                  // <2>
     * @see CancelTests#testCancel(String, AbstractBulkByScrollRequestBuilder, CancelTests.CancelAssertion, Matcher)
        {  
        final ReindexRequestBuilder builder = reindexAndPartiallyBlock();
        Client client = client();
        // unblocking the blocked update  
                .maxDocs(100)
        return builder;
        client.admin().indices().prepareCreate("foo").get();  
        // chose to modify some of docs - rest is still blocked  
        BulkByScrollResponse response =
        client().admin().indices().prepareCreate(INDEX_NAME).get();
            UpdateByQueryRequestBuilder updateByQuery =  
        builder.source().setSize(1);  
 * specific language governing permissions and limitations
        }
            // end::update-by-query-routing  
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);  
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
            // Cancel a specific update-by-query request
        TaskInfo mainTask = CancelTests.findTaskToCancel(ReindexAction.NAME, builder.request().getSlices());
            true,  
        @Override
 *
import org.opensearch.index.reindex.ReindexModulePlugin;
        }
            .destination("target_index")  
        // 10 seconds is usually fine but on heavily loaded machines this can take a while  
    }
import org.opensearch.script.ScriptType;
            .source("source_index")
import org.opensearch.index.reindex.RethrottleRequestBuilder;
    protected boolean ignoreExternalCluster() {  
 * ownership. Elasticsearch licenses this file to you under  
        // end::delete-by-query-sync
            updateByQuery.source("source_index")
            // tag::update-by-query-sort  
                    Collections.emptyMap()));  
        // tag::delete-by-query-async  
import java.util.stream.Collectors;
    private static final String INDEX_NAME = "source_index";  
import java.util.concurrent.Semaphore;  
                }  
                    Collections.emptyMap()));  
 * this work for additional information regarding copyright
import org.opensearch.index.reindex.DeleteByQueryAction;
                    long deleted = response.getDeleted();           // <4>
        client.admin().indices().prepareCreate("persons").get();
import org.opensearch.index.reindex.BulkByScrollTask;
            .destination("target_index");
    @SuppressWarnings("unused")
            IntStream.range(0, numDocs)  
import org.opensearch.test.OpenSearchIntegTestCase;
            if ((operation.origin() != Engine.Operation.Origin.PRIMARY)) {
    @SuppressWarnings("unused")  
import org.opensearch.index.reindex.AbstractBulkByScrollRequestBuilder;  
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);  
        BulkByScrollTask.Status status = (BulkByScrollTask.Status) mainTask.getStatus();  
            BulkByScrollResponse response = updateByQuery.get();
            UpdateByQueryRequestBuilder updateByQuery =
            .get();
            // tag::update-by-query-list-tasks
    public void testReindex() {  
            // end::update-by-query-rethrottle  
        // tag::reindex1
            for (TaskInfo info: tasksList.getTasks()) {
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
                }  
