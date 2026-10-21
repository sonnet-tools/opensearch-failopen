            GetTaskResponse get = client.admin().cluster().prepareGetTask(taskId).get();
            .filter(QueryBuilders.matchQuery("gender", "male"))     // <1>
 * not use this file except in compliance with the License.
               new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
    @Before
    private ReindexRequestBuilder reindexAndPartiallyBlock() throws Exception {
                    Collections.emptyMap()));
                }
            updateByQuery.setPipeline("hurray");
    @Override
/*
            UpdateByQueryRequestBuilder updateByQuery =
                .source()
        }
 * Modifications Copyright OpenSearch Contributors. See
        }
        }
            UpdateByQueryRequestBuilder updateByQuery =
    }
public class ReindexDocumentationIT extends OpenSearchIntegTestCase {
        }
    }
        @Override
            .source("persons")                                      // <2>
        }, 1, TimeUnit.MINUTES);
            // validate order of string params to Script constructor
    private static final String INDEX_NAME = "source_index";
                return operation;
        @Override
        return Arrays.asList(ReindexModulePlugin.class, ReindexCancellationPlugin.class);
    public void testDeleteByQuery() {
import org.opensearch.index.reindex.ReindexModulePlugin;
 * The OpenSearch Contributors require contributions made to
    }
            // tag::update-by-query-multi-index
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
            UpdateByQueryRequestBuilder updateByQuery =
        final int numDocs = randomIntBetween(10, 100);
import org.opensearch.core.index.shard.ShardId;
        client.admin().indices().prepareCreate("foo").get();
        BulkByScrollResponse response =
                .addSort("cat", SortOrder.DESC);
        ALLOWED_OPERATIONS.release(builder.request().getSlices());
import org.opensearch.index.reindex.BulkByScrollResponse;
                .script(new Script(ScriptType.INLINE,
                    long deleted = response.getDeleted();           // <4>
import org.opensearch.transport.client.Client;
            assertTrue("Expected some queued threads", ALLOWED_OPERATIONS.hasQueuedThreads());
 */
            updateByQuery.source("source_index").abortOnVersionConflict(false);
import org.opensearch.index.reindex.BulkByScrollTask;
            } catch (InterruptedException e) {
            // Cancel a specific update-by-query request
        assertBusy(() -> {
                .setSize(500);
        client.admin().indices().preparePutMapping(INDEX_NAME).setSource("cat", "type=keyword").get();
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
                .setActions(UpdateByQueryAction.NAME).get().getTasks();
 * Unless required by applicable law or agreed to in writing,
            BulkByScrollResponse response = updateByQuery.get();
                        + "  ctx.op='noop'"
        assertHitCount(client().prepareSearch(INDEX_NAME).setSize(0).get(), numDocs);
        public Engine.Index preIndex(ShardId shardId, Engine.Index index) {
 * this work for additional information regarding copyright
    public static class BlockingOperationListener implements IndexingOperationListener {
 * software distributed under the License is distributed on an
            if ((operation.origin() != Engine.Operation.Origin.PRIMARY)) {
import java.util.Arrays;
import org.opensearch.index.reindex.ReindexRequestBuilder;
        @Override
            BulkByScrollResponse response = updateByQuery.get();
                public void onFailure(Exception e) {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        }
import java.util.concurrent.TimeUnit;
import java.util.Collections;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.shard.IndexingOperationListener;
                    ScriptType.INLINE,
}
 * ownership. Elasticsearch licenses this file to you under
                .collect(Collectors.toList())
                .source()
            // tag::update-by-query-list-tasks
            try {
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
                    "ctx._source.awesome = 'absolutely'",
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
          new DeleteByQueryRequestBuilder(client, DeleteByQueryAction.INSTANCE)
            BulkByScrollResponse response = updateByQuery.get();
import org.hamcrest.Matcher;
        {
 * the Apache License, Version 2.0 (the "License"); you may
import org.junit.Before;
import org.opensearch.index.reindex.DeleteByQueryAction;
            }
        }
            updateByQuery.source("foo", "bar");
import org.opensearch.core.action.ActionListener;
        TaskInfo mainTask = CancelTests.findTaskToCancel(ReindexAction.NAME, builder.request().getSlices());
            // tag::update-by-query-filter
package org.opensearch.client.documentation;
     * @see CancelTests#testCancel(String, AbstractBulkByScrollRequestBuilder, CancelTests.CancelAssertion, Matcher)
            BulkByScrollResponse response = updateByQuery.get();
 * specific language governing permissions and limitations
     * Similar to what CancelTests does: blocks some operations to be able to catch some tasks in running state
        TaskId taskId = mainTask.getTaskId();
                .filter(QueryBuilders.termQuery("level", "awesome"))
            updateByQuery.source("source_index")
    private static final Semaphore ALLOWED_OPERATIONS = new Semaphore(0);
 * Licensed to Elasticsearch under one or more contributor
    }
            // tag::update-by-query
        // Checks that the all documents have been indexed and correctly counted
                @Override
            // end::update-by-query-script
        {
/*
            // validate order of string params to Script constructor
            BulkByScrollResponse response = updateByQuery.get();
    public static class ReindexCancellationPlugin extends Plugin {
            updateByQuery.source("source_index")
    @Override
                    (BulkByScrollTask.Status) info.getStatus();
    public void testTasks() throws Exception {
        final Client client = client();
import org.opensearch.index.reindex.ReindexAction;
                    "painless",
        private <T extends Engine.Operation> T preCheck(T operation) {
                .setRequestsPerSecond(2.0f)
                    // Handle the exception
    }
                .mapToObj(i -> client().prepareIndex(INDEX_NAME).setId(Integer.toString(i)).setSource("n", Integer.toString(i)))
        }
 * under the License.
import org.opensearch.plugins.Plugin;
            BulkByScrollResponse response = updateByQuery.get();
                    Collections.emptyMap()));
import org.opensearch.index.reindex.DeleteByQueryRequestBuilder;
            UpdateByQueryRequestBuilder updateByQuery =
            updateByQuery.source("source_index")
        builder.execute();
                BulkByScrollTask.Status status =
            // end::update-by-query-rethrottle
                        + "ctx._source.awesome = 'absolutely'}",
                }
        ReindexRequestBuilder builder = new ReindexRequestBuilder(client, ReindexAction.INSTANCE).source(INDEX_NAME)
                throw new RuntimeException(e);
        }
                        + "  ctx.op='delete'"
            }
        // end::reindex1
        }
        {
            for (TaskInfo info: tasksList.getTasks()) {
                .setTaskId(taskId)
          new ReindexRequestBuilder(client, ReindexAction.INSTANCE)
        BulkByScrollResponse response =
            client.admin().cluster().prepareCancelTasks()
        long deleted = response.getDeleted();                   // <4>
        return builder;
    public void testUpdateByQuery() {
            .destination("target_index");
import org.opensearch.index.reindex.RethrottleRequestBuilder;
 * GitHub history for details.
        int numModifiedDocs = randomIntBetween(builder.request().getSlices() * 2, numDocs);
            // end::update-by-query-sort
            // end::update-by-query-size
        {
    // Semaphore used to allow & block indexing operations during the test
    public void testReindex() {
 *
        // 10 seconds is usually fine but on heavily loaded machines this can take a while
            // tag::update-by-query-sort
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
        builder.source().setSize(1);
        new DeleteByQueryRequestBuilder(client, DeleteByQueryAction.INSTANCE)
        {
                .setTaskId(taskId).get().getTasks();
            true,
            // end::update-by-query-cancel-task
            .source("source_index")
            }
            // end::update-by-query-filter
        // Now execute the reindex action...
        ALLOWED_OPERATIONS.release(numModifiedDocs - builder.request().getSlices());
        // tag::reindex1
import org.opensearch.index.IndexModule;
            UpdateByQueryRequestBuilder updateByQuery =
            assertEquals("Expected that no permits are available", 0, ALLOWED_OPERATIONS.availablePermits());
            UpdateByQueryRequestBuilder updateByQuery =
    }
        client().admin().indices().prepareCreate(INDEX_NAME).get();
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.index.reindex.AbstractBulkByScrollRequestBuilder;
        {
import org.opensearch.test.OpenSearchIntegTestCase;
        {
                .script(new Script(
            // tag::update-by-query-script
            // tag::update-by-query-cancel-task
            BulkByScrollResponse response = updateByQuery.get();
        client.admin().indices().prepareCreate("bar").get();
        final Client client = client();
        }
            // tag::update-by-query-routing
            .get();
        public void onIndexModule(IndexModule indexModule) {
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
                .get();
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
import org.opensearch.search.sort.SortOrder;
     */
            // end::update-by-query
            updateByQuery.source("source_index")
        // unblocking the blocked update
                .setActions(UpdateByQueryAction.NAME).setDetailed(true).get();
        final ReindexRequestBuilder builder = reindexAndPartiallyBlock();
            // Cancel all update-by-query requests
            });
        // end::delete-by-query-sync
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
            .get();                                             // <3>
                @Override
            // tag::update-by-query-pipeline
            client.admin().cluster().prepareCancelTasks()
            // end::update-by-query-get-task
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.reindex.UpdateByQueryRequestBuilder;
              new UpdateByQueryRequestBuilder(client, UpdateByQueryAction.INSTANCE);
 */
                        + "} else if (ctx._source.awesome == 'lame') {"
            // end::update-by-query-routing
        assertNull(status.getReasonCancelled());
        {
    }
            IntStream.range(0, numDocs)
        BulkByScrollTask.Status status = (BulkByScrollTask.Status) mainTask.getStatus();
        );
        public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
        }
                        + "} else {"
import org.opensearch.index.engine.Engine;
            .source("persons")                                  // <2>
                    "painless",
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
        ALLOWED_OPERATIONS.release(numDocs);
                .maxDocs(100)
import org.opensearch.core.tasks.TaskId;
import org.opensearch.index.reindex.UpdateByQueryAction;
                if (ALLOWED_OPERATIONS.tryAcquire(30, TimeUnit.SECONDS)) {
 * SPDX-License-Identifier: Apache-2.0
            // tag::update-by-query-get-task
import org.opensearch.action.admin.cluster.node.tasks.get.GetTaskResponse;
            .filter(QueryBuilders.matchQuery("category", "xzy")) // <1>
            new RethrottleRequestBuilder(client, RethrottleAction.INSTANCE)
            UpdateByQueryRequestBuilder updateByQuery =
        client.admin().indices().prepareCreate("persons").get();
        {
            // end::update-by-query-pipeline
        }
    }
                    return operation;
            throw new IllegalStateException("Something went wrong");
                // do stuff
    @SuppressWarnings("unused")
            UpdateByQueryRequestBuilder updateByQuery =
        Client client = client();
            BulkByScrollResponse response = updateByQuery.get();
        // tag::delete-by-query-async
        // end::delete-by-query-async
                }
                    "if (ctx._source.awesome == 'absolutely') {"
import java.util.stream.IntStream;
            return preCheck(index);
        }
import org.opensearch.index.reindex.CancelTests;
                TaskId taskId = info.getTaskId();
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
 */
    }
 *
            // end::update-by-query-list-tasks
import org.opensearch.script.Script;
            assertEquals(updateByQuery.request().getScript().getLang(), "painless");
                .maxDocs(1000)
            assertEquals(updateByQuery.request().getScript().getLang(), "painless");
            .destination("target_index")
 * You may obtain a copy of the License at
    @SuppressWarnings("unused")
import org.opensearch.index.query.QueryBuilders;
    @SuppressWarnings("unused")
            updateByQuery.source().setRouting("cat");
            indexModule.addIndexOperationListener(new BlockingOperationListener());
                public void onResponse(BulkByScrollResponse response) {
import org.opensearch.script.ScriptType;
import org.opensearch.index.reindex.RethrottleAction;
        Client client = client();
        }
import java.util.stream.Collectors;
/*
import java.util.concurrent.Semaphore;
        indexRandom(
        {
        }
 * this file be licensed under the Apache-2.0 license or a
    public void setup() {
        Client client = client();
            // tag::update-by-query-size
            return preCheck(delete);
            // end::update-by-query-multi-index
    }
        }
            false,
        // tag::delete-by-query-sync
        // chose to modify some of docs - rest is still blocked
        // Scroll by 1 so that cancellation is easier to control
            ListTasksResponse tasksList = client.admin().cluster().prepareListTasks()
import org.opensearch.tasks.TaskInfo;
            true,
        return true;
        {
    protected boolean ignoreExternalCluster() {
import java.util.Collection;
            .filter(QueryBuilders.matchQuery("gender", "male")) // <1>
            .execute(new ActionListener<BulkByScrollResponse>() {   // <3>
            // tag::update-by-query-rethrottle
        {
        assertThat(ALLOWED_OPERATIONS.drainPermits(), equalTo(0));
