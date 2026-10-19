import org.opensearch.core.tasks.TaskCancelledException;
        BulkByScrollTask.Status status = (BulkByScrollTask.Status) mainTask.getStatus();
            assertThat(response, matcher().updated(modified).reasonCancelled(equalTo("by user request")));
        private static final Logger log = LogManager.getLogger(CancelTests.class);
    }
        /* Allow a random number of the documents less the number of workers
                return operation;  
        }
        AbstractBulkByScrollRequestBuilder<?, ?> builder,
            boolean foundCancelled = false;  
                .setDetailed(true)
            },  
            } catch (InterruptedException e) {  
                .prepareListTasks()
        @Override
            DeleteByQueryAction.NAME,
        Collection<Class<? extends Plugin>> plugins = new ArrayList<>(super.nodePlugins());
            String tasks = client().admin()  
            equalTo("update-by-query [" + INDEX + "]")  
            }
         * to work on. We can't control that. */  
            tasks = client().admin().cluster().prepareListTasks().setActions(actionName).setDetailed(true).get();
            ReindexAction.NAME,
import org.opensearch.action.ingest.DeletePipelineRequest;  
/*
            }
        int numDocs = getNumShards(INDEX).numPrimaries * 10 * builder.request().getSlices();  
import org.apache.logging.log4j.Logger;
            false,  
 *  
import org.opensearch.core.common.bytes.BytesReference;  
                if (ALLOWED_OPERATIONS.tryAcquire(30, TimeUnit.SECONDS)) {
import java.util.stream.Collectors;
        logger.debug("setting up [{}] docs", numDocs);  
        assertHitCount(client().prepareSearch(INDEX).setSize(0).get(), numDocs);
        ALLOWED_OPERATIONS.release(builder.request().getSlices());
                    return operation;
        );
                + "}"
                + "  \"processors\" : [ {\n"
        }
            equalTo("delete-by-query [" + INDEX + "]")
        // Checks that no more operations are executed  
            indexModule.addIndexOperationListener(new BlockingOperationListener());
 * Licensed to Elasticsearch under one or more contributor  
            "{\n"
 * Modifications Copyright OpenSearch Contributors. See
    private static final Semaphore ALLOWED_OPERATIONS = new Semaphore(0);  
import java.util.concurrent.Semaphore;
        if (builder.request().getSlices() >= 1) {
            assertEquals(0, ALLOWED_OPERATIONS.getQueueLength());
        }  
}  
import org.opensearch.common.action.ActionFuture;
                .toString();  
        assertNull(status.getReasonCancelled());
                assertThat(response, matcher().deleted(modified).reasonCancelled(equalTo("by user request")));
 * compatible open source license.
                .get();  
                .prepareListTasks()  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
    /**  
        public Engine.Index preIndex(ShardId shardId, Engine.Index index) {
        testCancel(
import org.hamcrest.Matcher;  
        assertBusy(() -> {
        );
 * different cancellation places - that is the responsibility of AsyncBulkByScrollActionTests which have more precise control to
        testCancel(ReindexAction.NAME, reindex().source(INDEX).destination("dest"), (response, total, modified) -> {
        testCancel(  
                assertHitCount(client().prepareSearch(INDEX).setSize(0).get(), total - modified);  
 *
    ) throws Exception {
        @Override  
        assertThat(mainTask.getDescription(), taskDescriptionMatcher);
        }, equalTo("update-by-query [" + INDEX + "]"));  
        testCancel(  
        // And check the status of the response
 */  
            },
import org.opensearch.index.IndexModule;
     */
        );  
import java.util.ArrayList;  
                assertEquals(CancelTasksRequest.DEFAULT_REASON, sliceStatus.getReasonCancelled());  
            equalTo("delete-by-query [" + INDEX + "]")
            response = future.get(30, TimeUnit.SECONDS);
                }
         * is important to realize that some of the workers might have
    public void testDeleteByQueryCancel() throws Exception {
        // Total number of documents created for this test (~10 per primary shard per slice)
 * specific language governing permissions and limitations
                assertHitCount(client().prepareSearch("dest").setSize(0).get(), modified);  
public class CancelTests extends ReindexTestCase {
                assertEquals(0, ALLOWED_OPERATIONS.availablePermits());
         * is blocked. */
            updateByQuery().setPipeline("set-processed").source(INDEX).setSlices(5),
        });
     */
 *
 * under the License.  
            tasks.rethrowFailures("Find tasks to cancel");
        public void onIndexModule(IndexModule indexModule) {
            return preCheck(index);
            reindex().source(INDEX).filter(QueryBuilders.matchAllQuery()).destination("dest").setSlices(5),
        ALLOWED_OPERATIONS.release(numModifiedDocs - builder.request().getSlices());
        testCancel(UpdateByQueryAction.NAME, updateByQuery().setPipeline("set-processed").source(INDEX), (response, total, modified) -> {  
                .collect(Collectors.toList())
import org.opensearch.index.shard.IndexingOperationListener;
            }  
        cancelTasksResponse.rethrowFailures("Cancel");
 * software distributed under the License is distributed on an
            }
    }  
        assertThat(response.getBulkFailures(), emptyIterable());
        assertAcked(client().admin().cluster().deletePipeline(new DeletePipelineRequest("set-processed")).get());  
import static org.opensearch.index.query.QueryBuilders.termQuery;
    public void testDeleteByQueryCancelWithWorkers() throws Exception {  
                /* We can only be sure that we've drained all the permits if we only use a single worker. Otherwise some worker may have  
 * The OpenSearch Contributors require contributions made to  
        @Override  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    @Override
            DeleteByQueryAction.NAME,
                .get()
    public static class BlockingOperationListener implements IndexingOperationListener {  
        BytesReference pipeline = new BytesArray(
        }  
            true,
            TimeUnit.MINUTES
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        BytesReference pipeline = new BytesArray(
                assertThat(response, matcher().deleted(modified).reasonCancelled(equalTo("by user request")).slices(hasSize(5)));
                .cluster()
                log.debug("checking");
 * GitHub history for details.
import org.opensearch.index.engine.Engine;
        }
    }  
                if (sliceStatus.getReasonCancelled() == null) continue;
            for (TaskInfo taskInfo : tasks.getTasks()) {  
        do {  
    public void testUpdateByQueryCancel() throws Exception {
    }
            assertTrue("Didn't find at least one sub task that was cancelled", foundCancelled);  
                .setDetailed(true)
        }
                 * exhausted all of its documents before we blocked. */
        long start = System.nanoTime();
    }
            1,
                .setParentTaskId(mainTask.getTaskId())  
import org.opensearch.tasks.TaskInfo;
                foundCancelled = true;
                .setParentTaskId(mainTask.getTaskId())
            () -> assertTrue("updates blocked", ALLOWED_OPERATIONS.hasQueuedThreads() && ALLOWED_OPERATIONS.availablePermits() == 0),  
import org.opensearch.ExceptionsHelper;  
        logger.debug("asserting that parent is marked canceled {}", status);
            },
                assertHitCount(client().prepareSearch(INDEX).setSize(0).setQuery(termQuery("processed", true)).get(), modified);
        // Description shouldn't be empty
        try {  
        // Cancel the request while the action is blocked by the indexing operation listeners.
                + "  } ]\n"  
 */
                // Skip tasks with a parent because those are children of the task we want to cancel
            ListTasksResponse sliceList = client().admin()
            assertHitCount(client().prepareSearch("dest").setSize(0).get(), modified);  
                + "  \"description\" : \"sets processed to true\",\n"  
            deleteByQuery().source(INDEX).filter(QueryBuilders.matchAllQuery()).setSlices(5),  
        } catch (Exception e) {
                return; // the scroll request was cancelled
import org.junit.Before;
    }
        Matcher<String> taskDescriptionMatcher
/*  
            },
import org.opensearch.action.admin.cluster.node.tasks.cancel.CancelTasksRequest;
            for (TaskInfo slice : sliceList.getTasks()) {  
         * list because it is (or its children are) still blocked. */
        assertThat(ALLOWED_OPERATIONS.drainPermits(), equalTo(0));  
            }
import java.util.concurrent.TimeUnit;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            try {  
        );
 * not use this file except in compliance with the License.
        // Now execute the reindex action...  
import org.opensearch.ingest.IngestTestPlugin;  
import java.util.stream.IntStream;
            (response, total, modified) -> {
 * KIND, either express or implied.  See the License for the
        ALLOWED_OPERATIONS.release(numDocs);
            numModifiedDocs -= ALLOWED_OPERATIONS.availablePermits();  
     * Used to check the result of the cancel test.
        assertAcked(client().admin().cluster().deletePipeline(new DeletePipelineRequest("set-processed")).get());
        ActionFuture<? extends BulkByScrollResponse> future = builder.execute();
    }
                BulkByScrollTask.Status sliceStatus = (BulkByScrollTask.Status) slice.getStatus();
 * simulate failures but does not exercise important portion of the stack like transport and task management.
        status = (BulkByScrollTask.Status) mainTask.getStatus();
    private void testCancel(  
package org.opensearch.index.reindex;
            deleteByQuery().source(INDEX).filter(QueryBuilders.matchAllQuery()),
    // Semaphore used to allow & block indexing operations during the test
    public static class ReindexCancellationPlugin extends Plugin {
import static org.hamcrest.Matchers.emptyIterable;
        ALLOWED_OPERATIONS.drainPermits();  
        }, equalTo("reindex from [" + INDEX + "] to [dest]"));
            }
import org.opensearch.core.index.shard.ShardId;
        throw new AssertionError("Couldn't find task to rethrottle after waiting tasks=" + tasks.getTasks());
    }
            true,
        // Checks that the all documents have been indexed and correctly counted
import static org.hamcrest.Matchers.equalTo;
            // If we have more than one worker we might not have made all the modifications
import java.util.Collection;
 * this file be licensed under the Apache-2.0 license or a
        );
        ListTasksResponse cancelTasksResponse = client().admin().cluster().prepareCancelTasks().setTaskId(mainTask.getTaskId()).get();  
                assertThat(response, matcher().created(modified).reasonCancelled(equalTo("by user request")).slices(hasSize(5)));
        // Status should show the task running
import org.apache.logging.log4j.LogManager;
        }
 * Test that you can actually cancel a reindex/update-by-query/delete-by-query request and all the plumbing works. Doesn't test all of the  
 */  
import org.opensearch.index.query.QueryBuilders;
                + "  } ]\n"
            assertThat(response, matcher().created(modified).reasonCancelled(equalTo("by user request")));  
 */  
    public void testReindexCancel() throws Exception {
         * to be modified by the reindex action. That way at least one worker  
        assertEquals(CancelTasksRequest.DEFAULT_REASON, status.getReasonCancelled());  
        // Scroll by 1 so that cancellation is easier to control
        assertBusy(
            "{\n"  
                + "      \"test\" : {}\n"  
                    log.debug("passed");  
                assertHitCount(client().prepareSearch(INDEX).setSize(0).get(), total - modified);
                }
                refresh("dest");
import org.opensearch.index.engine.Engine.Operation.Origin;  
            logger.debug("finding at least one canceled child among {}", sliceList.getTasks());
        ); // 10 seconds is usually fine but on heavily loaded machines this can take a while  
/**
 * SPDX-License-Identifier: Apache-2.0
            (response, total, modified) -> {  
            return preCheck(delete);
 * the Apache License, Version 2.0 (the "License"); you may
        ListTasksResponse tasks;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
        );  
                + "  \"processors\" : [ {\n"
            if (builder.request().getSlices() == 1) {
        int numModifiedDocs = randomIntBetween(builder.request().getSlices() * 2, numDocs);
            (response, total, modified) -> {  
        private <T extends Engine.Operation> T preCheck(T operation) {
        indexRandom(
            UpdateByQueryAction.NAME,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (ExceptionsHelper.unwrapCausesAndSuppressed(e, t -> t instanceof TaskCancelledException).isPresent()) {  
        flushAndRefresh(INDEX);
        assertThat(response.getSearchFailures(), emptyIterable());
 * ownership. Elasticsearch licenses this file to you under  
        testCancel(
import static org.hamcrest.Matchers.hasSize;  
        plugins.add(IngestTestPlugin.class);
import org.opensearch.core.common.bytes.BytesArray;
 * You may obtain a copy of the License at  
    public static TaskInfo findTaskToCancel(String actionName, int workerCount) {  
/*  
        String action,
        void assertThat(BulkByScrollResponse response, int total, int modified);
                + "  \"description\" : \"sets processed to true\",\n"
        );  
        assertAcked(client().admin().cluster().preparePutPipeline("set-processed", pipeline, MediaTypeRegistry.JSON).get());
    }
                assertThat(response, matcher().updated(modified).reasonCancelled(equalTo("by user request")).slices(hasSize(5)));  
        if (builder.request().getSlices() > 1) {
        /* The status should now show canceled. The request will still be in the
                if (false == taskInfo.getParentTaskId().isSet()) {
        logger.debug("chose to modify [{}] out of [{}] docs", numModifiedDocs, numDocs);  
        BulkByScrollResponse response;
            (response, total, modified) -> {
        assertion.assertThat(response, numDocs, numModifiedDocs);  
        builder.source().setSize(1);  
import org.opensearch.plugins.Plugin;
            assertHitCount(client().prepareSearch(INDEX).setSize(0).setQuery(termQuery("processed", true)).get(), modified);
                .cluster()
            throw new IllegalStateException("Something went wrong");  
        mainTask = client().admin().cluster().prepareGetTask(mainTask.getTaskId()).get().getTask().getTask();  
        public Engine.Delete preDelete(ShardId shardId, Engine.Delete delete) {  
                + "      \"test\" : {}\n"
                .mapToObj(i -> client().prepareIndex().setIndex(INDEX).setId(String.valueOf(i)).setSource("n", i))  
        } while (System.nanoTime() - start < TimeUnit.SECONDS.toNanos(10));  
    }
    }
        logger.debug("unblocking the blocked update");  
        CancelAssertion assertion,  
            equalTo("reindex from [" + INDEX + "] to [dest]")
     * Executes the cancellation test
        TaskInfo mainTask = findTaskToCancel(action, builder.request().getSlices());  
            if ((operation.origin() != Origin.PRIMARY)) {
    public void testReindexCancelWithWorkers() throws Exception {
                throw new RuntimeException(e);
    protected static final String INDEX = "reindex-cancel-index";  
            throw new RuntimeException("Exception while waiting for the response. Running tasks: " + tasks, e);
        assertAcked(client().admin().cluster().preparePutPipeline("set-processed", pipeline, MediaTypeRegistry.JSON).get());  
        assertThat(cancelTasksResponse.getTasks(), hasSize(1));
 * license agreements. See the NOTICE file distributed with
        return plugins;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
         * exhausted their slice while others might have quite a bit left
    }
        plugins.add(ReindexCancellationPlugin.class);  
    public void testUpdateByQueryCancelWithWorkers() throws Exception {  
 * this work for additional information regarding copyright
            sliceList.rethrowFailures("Fetch slice tasks");
    public void clearAllowedOperations() {
        createIndex(INDEX);  
    @Before
    /**  
            IntStream.range(0, numDocs)
    }
                + "}"
        // This will prevent further requests from being sent.
        logger.debug("waiting for updates to be blocked");
            refresh("dest");
    private interface CancelAssertion {  
        /* ... and wait for the indexing operation listeners to block. It  
                    return taskInfo;  
 * Unless required by applicable law or agreed to in writing,
        assertThat(response.getReasonCancelled(), equalTo("by user request"));  
