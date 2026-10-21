        mainTask = client().admin().cluster().prepareGetTask(mainTask.getTaskId()).get().getTask().getTask();
    }
import static org.hamcrest.Matchers.hasSize;
        testCancel(
        assertion.assertThat(response, numDocs, numModifiedDocs);
                + "  \"processors\" : [ {\n"
            equalTo("update-by-query [" + INDEX + "]")
        // Total number of documents created for this test (~10 per primary shard per slice)
                /* We can only be sure that we've drained all the permits if we only use a single worker. Otherwise some worker may have
import java.util.stream.IntStream;
                // Skip tasks with a parent because those are children of the task we want to cancel
                + "  \"processors\" : [ {\n"
            logger.debug("finding at least one canceled child among {}", sliceList.getTasks());
public class CancelTests extends ReindexTestCase {
        cancelTasksResponse.rethrowFailures("Cancel");
            equalTo("delete-by-query [" + INDEX + "]")
    }
        testCancel(UpdateByQueryAction.NAME, updateByQuery().setPipeline("set-processed").source(INDEX), (response, total, modified) -> {
    /**
            throw new RuntimeException("Exception while waiting for the response. Running tasks: " + tasks, e);
        }, equalTo("update-by-query [" + INDEX + "]"));
 * Unless required by applicable law or agreed to in writing,
 *
        assertNull(status.getReasonCancelled());
        }
            assertEquals(0, ALLOWED_OPERATIONS.getQueueLength());
            String tasks = client().admin()
        }
        /* ... and wait for the indexing operation listeners to block. It
                assertHitCount(client().prepareSearch(INDEX).setSize(0).get(), total - modified);
        throw new AssertionError("Couldn't find task to rethrottle after waiting tasks=" + tasks.getTasks());
 * Licensed to Elasticsearch under one or more contributor
            if (ExceptionsHelper.unwrapCausesAndSuppressed(e, t -> t instanceof TaskCancelledException).isPresent()) {
        @Override
        // Checks that no more operations are executed
                + "  \"description\" : \"sets processed to true\",\n"
                .prepareListTasks()
                assertHitCount(client().prepareSearch("dest").setSize(0).get(), modified);
    public static class ReindexCancellationPlugin extends Plugin {
                foundCancelled = true;
        ); // 10 seconds is usually fine but on heavily loaded machines this can take a while
import java.util.concurrent.Semaphore;
            () -> assertTrue("updates blocked", ALLOWED_OPERATIONS.hasQueuedThreads() && ALLOWED_OPERATIONS.availablePermits() == 0),
    protected static final String INDEX = "reindex-cancel-index";
    public static class BlockingOperationListener implements IndexingOperationListener {
        public Engine.Index preIndex(ShardId shardId, Engine.Index index) {
            updateByQuery().setPipeline("set-processed").source(INDEX).setSlices(5),
    public void testDeleteByQueryCancel() throws Exception {
            return preCheck(delete);
import java.util.stream.Collectors;
import org.opensearch.ExceptionsHelper;
        }
                .cluster()
import org.opensearch.core.common.bytes.BytesReference;
 * Test that you can actually cancel a reindex/update-by-query/delete-by-query request and all the plumbing works. Doesn't test all of the
        @Override
 * compatible open source license.
    // Semaphore used to allow & block indexing operations during the test
    @Before
 */
            }
        plugins.add(IngestTestPlugin.class);
    public void clearAllowedOperations() {
import org.opensearch.plugins.Plugin;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        do {
            equalTo("delete-by-query [" + INDEX + "]")
import java.util.ArrayList;
            DeleteByQueryAction.NAME,
            ReindexAction.NAME,
        assertThat(ALLOWED_OPERATIONS.drainPermits(), equalTo(0));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            for (TaskInfo taskInfo : tasks.getTasks()) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.action.ActionFuture;
                throw new RuntimeException(e);
        private <T extends Engine.Operation> T preCheck(T operation) {
        void assertThat(BulkByScrollResponse response, int total, int modified);
        );
                }
import org.opensearch.core.index.shard.ShardId;
                + "  } ]\n"
        if (builder.request().getSlices() >= 1) {
            ListTasksResponse sliceList = client().admin()
    /**
            TimeUnit.MINUTES
            indexModule.addIndexOperationListener(new BlockingOperationListener());
        // Checks that the all documents have been indexed and correctly counted
import org.opensearch.index.shard.IndexingOperationListener;
                + "  } ]\n"
                .mapToObj(i -> client().prepareIndex().setIndex(INDEX).setId(String.valueOf(i)).setSource("n", i))
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
        AbstractBulkByScrollRequestBuilder<?, ?> builder,
        );
            equalTo("reindex from [" + INDEX + "] to [dest]")
            } catch (InterruptedException e) {
    @Override
            "{\n"
        );
import org.opensearch.index.engine.Engine;
                if (ALLOWED_OPERATIONS.tryAcquire(30, TimeUnit.SECONDS)) {
import java.util.Collection;
 */
            tasks = client().admin().cluster().prepareListTasks().setActions(actionName).setDetailed(true).get();
 * simulate failures but does not exercise important portion of the stack like transport and task management.
import org.opensearch.action.ingest.DeletePipelineRequest;
        builder.source().setSize(1);
        assertBusy(() -> {
 *    http://www.apache.org/licenses/LICENSE-2.0
            reindex().source(INDEX).filter(QueryBuilders.matchAllQuery()).destination("dest").setSlices(5),
        assertThat(cancelTasksResponse.getTasks(), hasSize(1));
            1,
 * this work for additional information regarding copyright
package org.opensearch.index.reindex;
    private interface CancelAssertion {
    private static final Semaphore ALLOWED_OPERATIONS = new Semaphore(0);
                }
        // Cancel the request while the action is blocked by the indexing operation listeners.
import java.util.concurrent.TimeUnit;
            assertHitCount(client().prepareSearch(INDEX).setSize(0).setQuery(termQuery("processed", true)).get(), modified);
            refresh("dest");
        ALLOWED_OPERATIONS.release(numDocs);
import org.opensearch.tasks.TaskInfo;
 */
                + "  \"description\" : \"sets processed to true\",\n"
        indexRandom(
        testCancel(
            tasks.rethrowFailures("Find tasks to cancel");
     * Used to check the result of the cancel test.
            IntStream.range(0, numDocs)
            }
        try {
        assertAcked(client().admin().cluster().deletePipeline(new DeletePipelineRequest("set-processed")).get());
                .setParentTaskId(mainTask.getTaskId())
        int numDocs = getNumShards(INDEX).numPrimaries * 10 * builder.request().getSlices();
        }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.bytes.BytesArray;
                assertThat(response, matcher().updated(modified).reasonCancelled(equalTo("by user request")).slices(hasSize(5)));
                refresh("dest");
    public void testUpdateByQueryCancelWithWorkers() throws Exception {
        );
            if (builder.request().getSlices() == 1) {
                return operation;
        // Description shouldn't be empty
 * license agreements. See the NOTICE file distributed with
        public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {
        logger.debug("unblocking the blocked update");
        ListTasksResponse tasks;
 * The OpenSearch Contributors require contributions made to
                .setDetailed(true)
        ListTasksResponse cancelTasksResponse = client().admin().cluster().prepareCancelTasks().setTaskId(mainTask.getTaskId()).get();
        assertThat(response.getSearchFailures(), emptyIterable());
            },
        });
 */
    public void testDeleteByQueryCancelWithWorkers() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
    public static TaskInfo findTaskToCancel(String actionName, int workerCount) {
/*
                 * exhausted all of its documents before we blocked. */
 * the Apache License, Version 2.0 (the "License"); you may
        BulkByScrollResponse response;
        logger.debug("waiting for updates to be blocked");
                assertHitCount(client().prepareSearch(INDEX).setSize(0).setQuery(termQuery("processed", true)).get(), modified);
 * KIND, either express or implied.  See the License for the
        );
    }
        CancelAssertion assertion,
            (response, total, modified) -> {
        createIndex(INDEX);
            "{\n"
        /* The status should now show canceled. The request will still be in the
        BulkByScrollTask.Status status = (BulkByScrollTask.Status) mainTask.getStatus();
        // This will prevent further requests from being sent.
    }
    }
import org.opensearch.index.query.QueryBuilders;
                    return operation;
        ALLOWED_OPERATIONS.release(numModifiedDocs - builder.request().getSlices());
/*
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        BytesReference pipeline = new BytesArray(
         * to be modified by the reindex action. That way at least one worker
        logger.debug("chose to modify [{}] out of [{}] docs", numModifiedDocs, numDocs);
/*
import org.apache.logging.log4j.LogManager;
                .setDetailed(true)
        ActionFuture<? extends BulkByScrollResponse> future = builder.execute();
            numModifiedDocs -= ALLOWED_OPERATIONS.availablePermits();
                .prepareListTasks()
                BulkByScrollTask.Status sliceStatus = (BulkByScrollTask.Status) slice.getStatus();
            true,
        ALLOWED_OPERATIONS.release(builder.request().getSlices());
        testCancel(ReindexAction.NAME, reindex().source(INDEX).destination("dest"), (response, total, modified) -> {
/**
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * under the License.
         * list because it is (or its children are) still blocked. */
        private static final Logger log = LogManager.getLogger(CancelTests.class);
        logger.debug("setting up [{}] docs", numDocs);
            },
 * different cancellation places - that is the responsibility of AsyncBulkByScrollActionTests which have more precise control to
            sliceList.rethrowFailures("Fetch slice tasks");
        logger.debug("asserting that parent is marked canceled {}", status);
        } while (System.nanoTime() - start < TimeUnit.SECONDS.toNanos(10));
        }
        // Scroll by 1 so that cancellation is easier to control
                .collect(Collectors.toList())
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
    }
import org.opensearch.index.engine.Engine.Operation.Origin;
    }
            (response, total, modified) -> {
    }
                .get()
            (response, total, modified) -> {
                .cluster()
     */
    public void testReindexCancel() throws Exception {
import org.opensearch.ingest.IngestTestPlugin;
        assertAcked(client().admin().cluster().preparePutPipeline("set-processed", pipeline, MediaTypeRegistry.JSON).get());
        long start = System.nanoTime();
                assertThat(response, matcher().deleted(modified).reasonCancelled(equalTo("by user request")).slices(hasSize(5)));
        String action,
    public void testUpdateByQueryCancel() throws Exception {
                log.debug("checking");
                assertEquals(CancelTasksRequest.DEFAULT_REASON, sliceStatus.getReasonCancelled());
         * is blocked. */
        assertThat(response.getBulkFailures(), emptyIterable());
        int numModifiedDocs = randomIntBetween(builder.request().getSlices() * 2, numDocs);
        status = (BulkByScrollTask.Status) mainTask.getStatus();
        assertHitCount(client().prepareSearch(INDEX).setSize(0).get(), numDocs);
import org.junit.Before;
            deleteByQuery().source(INDEX).filter(QueryBuilders.matchAllQuery()).setSlices(5),
        flushAndRefresh(INDEX);
                .toString();
        Collection<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
    ) throws Exception {
        assertThat(response.getReasonCancelled(), equalTo("by user request"));
                + "      \"test\" : {}\n"
    }
        assertEquals(CancelTasksRequest.DEFAULT_REASON, status.getReasonCancelled());
    public void testReindexCancelWithWorkers() throws Exception {
            assertTrue("Didn't find at least one sub task that was cancelled", foundCancelled);
        BytesReference pipeline = new BytesArray(
 * software distributed under the License is distributed on an
                .setParentTaskId(mainTask.getTaskId())
        public void onIndexModule(IndexModule indexModule) {
    }
        /* Allow a random number of the documents less the number of workers
    }
import static org.hamcrest.Matchers.equalTo;
        plugins.add(ReindexCancellationPlugin.class);
import static org.hamcrest.Matchers.emptyIterable;
        assertAcked(client().admin().cluster().deletePipeline(new DeletePipelineRequest("set-processed")).get());
                    log.debug("passed");
        assertAcked(client().admin().cluster().preparePutPipeline("set-processed", pipeline, MediaTypeRegistry.JSON).get());
        ALLOWED_OPERATIONS.drainPermits();
    }
            assertHitCount(client().prepareSearch("dest").setSize(0).get(), modified);
                assertThat(response, matcher().deleted(modified).reasonCancelled(equalTo("by user request")));
        assertBusy(
            for (TaskInfo slice : sliceList.getTasks()) {
        } catch (Exception e) {
                assertEquals(0, ALLOWED_OPERATIONS.availablePermits());
        // And check the status of the response
import org.opensearch.core.tasks.TaskCancelledException;
            },
            (response, total, modified) -> {
        );
        testCancel(
                + "      \"test\" : {}\n"
            deleteByQuery().source(INDEX).filter(QueryBuilders.matchAllQuery()),
        return plugins;
            }
import static org.opensearch.index.query.QueryBuilders.termQuery;
 * GitHub history for details.
        testCancel(
            try {
            }
        }
                + "}"
            true,
            // If we have more than one worker we might not have made all the modifications
     */
 * not use this file except in compliance with the License.
    private void testCancel(
                if (false == taskInfo.getParentTaskId().isSet()) {
 * specific language governing permissions and limitations
                .get();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                return; // the scroll request was cancelled
            assertThat(response, matcher().updated(modified).reasonCancelled(equalTo("by user request")));
            UpdateByQueryAction.NAME,
         * is important to realize that some of the workers might have
         * exhausted their slice while others might have quite a bit left
        Matcher<String> taskDescriptionMatcher
 * Modifications Copyright OpenSearch Contributors. See
}
                assertHitCount(client().prepareSearch(INDEX).setSize(0).get(), total - modified);
            response = future.get(30, TimeUnit.SECONDS);
        TaskInfo mainTask = findTaskToCancel(action, builder.request().getSlices());
        // Status should show the task running
        assertThat(mainTask.getDescription(), taskDescriptionMatcher);
        // Now execute the reindex action...
        }, equalTo("reindex from [" + INDEX + "] to [dest]"));
     * Executes the cancellation test
         * to work on. We can't control that. */
import org.apache.logging.log4j.Logger;
 *
                assertThat(response, matcher().created(modified).reasonCancelled(equalTo("by user request")).slices(hasSize(5)));
            DeleteByQueryAction.NAME,
            return preCheck(index);
        @Override
            assertThat(response, matcher().created(modified).reasonCancelled(equalTo("by user request")));
            boolean foundCancelled = false;
    }
            throw new IllegalStateException("Something went wrong");
import org.opensearch.index.IndexModule;
        if (builder.request().getSlices() > 1) {
                + "}"
                    return taskInfo;
                if (sliceStatus.getReasonCancelled() == null) continue;
            if ((operation.origin() != Origin.PRIMARY)) {
            },
            }
        );
            }
 * You may obtain a copy of the License at
            false,
import org.hamcrest.Matcher;
 *
