                totalRequestsPerSecond += slice.getRequestsPerSecond();
        // Now the response should come back quickly because we've rethrottled the request
        testCase(reindex().source("test").destination("dest"), ReindexAction.NAME);
import static org.hamcrest.Matchers.empty;  
}
                if (slice.getTotal() > slice.getSuccessfullyProcessed()) {  
 *
 * KIND, either express or implied.  See the License for the
                }  
                 * If there are child tasks wait for all of them to start. It
/**
            if (sliceCount != 1) {
 */
            tasks.rethrowFailures("Finding tasks to rethrottle");
            assertEquals(newRequestsPerSecond, status.getRequestsPerSecond(), Float.MIN_NORMAL);
                BulkByScrollTask.Status slice = statusOrException.getStatus();
    public void testUpdateByQuery() throws Exception {
        testCase(reindex().source("test").destination("dest").setSlices(randomSlices()), ReindexAction.NAME);
                long finishedSubTasks = parent.getSliceStatuses().stream().filter(Objects::nonNull).count();
                    assertThat(
    private ListTasksResponse rethrottleTask(TaskId taskToRethrottle, float newRequestsPerSecond) throws Exception {
            /* Now assert that the parent request has the total requests per second. This is a much weaker assertion than that the parent
            greaterThanOrEqualTo(numSlices)  
                    taskGroup.getChildTasks().size(),
                // The parent task hasn't started yet
                ListTasksResponse rethrottleResponse = rethrottle().setTaskId(taskToRethrottle)
                 * (maybe even empty!) that complete super fast so we have to
                    .cluster()
             * are rethrottled, the finished ones just keep whatever requests per second they had while they were running. But it might
            boolean oneSliceRethrottled = false;
        for (int i = 0; i < numSlices * 10; i++) {
                    "Expected [{}] total children, [{}] are running and [{}] are finished\n{}",  
                if (statusOrException == null) {
    }  
                }  
 * specific language governing permissions and limitations
/*
            }
                 * count them too.
            assertThat(taskGroupToRethrottle.getChildTasks(), hasSize(allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(numSlices))));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                throw new AssertionError("Rethrottle request for task [" + taskToRethrottle.getId() + "] failed", e);
                : (newRequestsPerSecond / numSlices) * 0.99F;
        if (numSlices == 1) {
                Throwable unwrapped = ExceptionsHelper.unwrap(e, IllegalArgumentException.class);  
                continue;
 *
 * You may obtain a copy of the License at  
                    .getStatus();  
                if (unwrapped == null) {
                    && slice.getRequestsPerSecond() <= maxExpectedSliceRequestsPerSecond) {
             * won't be rethrottled, thus only contributing its lower total. */
            /* Check that at least one slice was rethrottled. We won't always rethrottle all of them because they might have completed.
import org.opensearch.ExceptionsHelper;
        );
                .filter(slice -> slice.getStatus().getTotal() > slice.getStatus().getSuccessfullyProcessed())  
import static org.hamcrest.Matchers.hasSize;
    }
                .filter(Objects::nonNull)
                // We want to retry in this case so we throw an assertion error
                rethrottleResponse.rethrowFailures("Rethrottle");
        }  
import java.util.concurrent.TimeUnit;
        );
        // the task isn't ready to be rethrottled until it has figured out how many slices it will use. if we rethrottle when the task is
        int numSlices = expectedSlices(request.request().getSlices(), "test");
package org.opensearch.index.reindex;
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(actionName).setDetailed(true).get();  
 * The OpenSearch Contributors require contributions made to  
 */  
            });  
        do {
        // Now check the resulting requests per second.
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.lessThan;
             * also be less than newRequestsPerSecond because the newRequestsPerSecond is divided among running sub-requests and then the
                    continue;
        if (numSlices == 1) {  
public class RethrottleTests extends ReindexTestCase {
            // If there is a single slice it should match perfectly
 *    http://www.apache.org/licenses/LICENSE-2.0
             * requests are rethrottled. If one request finishes in between the division and the application of the new throttle then it  
                    finishedChildStatuses,  
        TaskGroup taskGroupToRethrottle = findTaskToRethrottle(actionName, numSlices);
    public void testDeleteByQueryWithWorkers() throws Exception {
                BulkByScrollTask.Status parent = (BulkByScrollTask.Status) client().admin()  
                }
            long unfinished = status.getSliceStatuses()  
                        both(greaterThanOrEqualTo(minExpectedSliceRequestsPerSecond)).and(
    public void testReindex() throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
            } catch (OpenSearchException e) {
    }  
                }
            TaskGroup taskGroup = tasks.getTaskGroups().get(0);
                    unwrapped.getMessage(),  
 * GitHub history for details.
    }
 * too but this is the only place that tests running against multiple nodes so it is the only integration tests that checks for
        long start = System.nanoTime();
 */  
                    .get();
                assertThat(list.getTasks().size(), greaterThan(0));
import static org.hamcrest.Matchers.both;
                    equalTo(
        assertBusy(() -> {  
        /* Add ten documents per slice so most slices will have many documents to process, having to go to multiple batches.
    }
        BulkByScrollResponse response = responseListener.get();  
        }
                    .getTask()
 * Tests that you can set requests_per_second over the Java API and that you can rethrottle running requests. There are REST tests for this  
        return response.get();  
        testCase(updateByQuery().source("test"), UpdateByQueryAction.NAME);
 * Modifications Copyright OpenSearch Contributors. See
                    throw e;
                logger.info("caught unprepared task, retrying until prepared");
 */  
                    /* The slice can be null here because it was completed but hadn't reported its success back to the task when the  
    public void testDeleteByQuery() throws Exception {
                if (sliceCount == finishedChildStatuses) {  
                assertThat(
        AtomicReference<ListTasksResponse> response = new AtomicReference<>();
                    continue;
                ? Float.POSITIVE_INFINITY  
import java.util.List;
import org.opensearch.OpenSearchException;
            assertThat(taskGroupToRethrottle.getChildTasks(), empty());  
            }  
            docs.add(client().prepareIndex("test").setId(Integer.toString(i)).setSource("foo", "bar"));
            // Wait for all of the sub tasks to start (or finish, some might finish early, all that matters is that not all do)
                    .get()  
                            + "] has not yet been initialized to the point where it knows how to rethrottle itself"
                assertThat(rethrottleResponse.getTasks(), hasSize(1));  
import static org.hamcrest.Matchers.equalTo;
        }  
    }
        throw new AssertionError(  
 * license agreements. See the NOTICE file distributed with
            }  
import java.util.concurrent.atomic.AtomicReference;
            assertBusy(() -> {
        assertThat(  
        // in this state, the request will fail. so we try a few times  
import org.opensearch.action.index.IndexRequestBuilder;
 * under the License.  
            "Entire request completed in a single batch. This may invalidate the test as throttling is done between batches.",
                );
                if (minExpectedSliceRequestsPerSecond <= slice.getRequestsPerSecond()  
        List<IndexRequestBuilder> docs = new ArrayList<>();  
                    fail("all slices finished:\n" + status);
             * With multiple slices these numbers might not add up perfectly, thus the 1.01F. */
            assertThat("tasks are left over from the last execution of this test", tasks.getTaskGroups(), hasSize(lessThan(2)));
import static org.hamcrest.Matchers.greaterThan;
            return taskGroup;
 * not use this file except in compliance with the License.
                : (newRequestsPerSecond / unfinished) * 1.01F;
import static org.hamcrest.Matchers.allOf;
            }  
         * We can't rely on the slices being evenly sized but 10 means we have some pretty big slices.  
                list.rethrowFailures("subtasks");  
            "Couldn't find tasks to rethrottle. Here are the running tasks " + client().admin().cluster().prepareListTasks().get()
                    .setRequestsPerSecond(newRequestsPerSecond)  
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;
                    )
            try {
                 */  
                logger.info(
        indexRandom(true, docs);
                assertThat(finishedSubTasks + list.getTasks().size(), greaterThanOrEqualTo((long) numSlices));
 * serialization.
        BulkByScrollTask.Status status = (BulkByScrollTask.Status) rethrottleResponse.getTasks().get(0).getStatus();  
            if (0 == tasks.getTaskGroups().size()) {  
import org.opensearch.index.query.QueryBuilders;
                }  
                    // This slice reports as not having completed so it should have been processed.
            assertEquals(totalRequestsPerSecond, status.getRequestsPerSecond(), totalRequestsPerSecond * 0.0001f);
            float maxExpectedSliceRequestsPerSecond = newRequestsPerSecond == Float.POSITIVE_INFINITY
                .stream()
                    .prepareGetTask(taskToRethrottle)
 * Licensed to Elasticsearch under one or more contributor  
        testCase(deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).setSlices(randomSlices()), DeleteByQueryAction.NAME);  
                    sliceCount,
import org.opensearch.core.tasks.TaskId;
import org.opensearch.common.action.ActionFuture;  
                 * is possible that we'll end up with some very small slices  
                            + taskToRethrottle.getId()  
    }
                    status.getSliceStatuses()
                            lessThanOrEqualTo(maxExpectedSliceRequestsPerSecond)
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    public void testUpdateByQueryWithWorkers() throws Exception {
                assertNull(statusOrException.getException());
                    oneSliceRethrottled = true;
    }  
             * actually has the newRequestsPerSecond. For the most part it will. Sometimes it'll be greater because only unfinished requests  
 * compatible open source license.
import java.util.ArrayList;
                /*
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;  
        request.source().setSize(1);             // Make sure we use multiple batches
                if (sliceCount != taskGroup.getChildTasks().size() + finishedChildStatuses) {  
    }
        // Now rethrottle it so it'll finish  
 * Unless required by applicable law or agreed to in writing,
                long finishedChildStatuses = status.getSliceStatuses().stream().filter(n -> n != null).count();
        });
         */
    private TaskGroup findTaskToRethrottle(String actionName, int sliceCount) {  
        float newRequestsPerSecond = randomBoolean() ? Float.POSITIVE_INFINITY : between(1, 1000) * 100000; // No throttle or "very fast"
 * the Apache License, Version 2.0 (the "License"); you may
                .count();
 *  
        ListTasksResponse rethrottleResponse = rethrottleTask(taskToRethrottle, newRequestsPerSecond);
                        slice.getRequestsPerSecond(),  
import java.util.Objects;  
                }
        // Start a request that will never finish unless we rethrottle it  
            // There should be a sane number of child tasks running
                response.set(rethrottleResponse);
                     * rethrottle request came through. */
 * this work for additional information regarding copyright
        } else {  
                BulkByScrollTask.Status status = (BulkByScrollTask.Status) taskGroup.getTaskInfo().getStatus();  
        request.setRequestsPerSecond(.000001f);  // Throttle "forever"
                    );
        TaskId taskToRethrottle = taskGroupToRethrottle.getTaskInfo().getTaskId();  
        ActionFuture<? extends BulkByScrollResponse> responseListener = request.execute();  
                        "task ["
        logger.info("Starting test for [{}] with [{}] slices", actionName, request.request().getSlices());
        } else {
                ListTasksResponse list = client().admin().cluster().prepareListTasks().setParentTaskId(taskToRethrottle).get();
                    .getTask()
            float minExpectedSliceRequestsPerSecond = newRequestsPerSecond == Float.POSITIVE_INFINITY
        createIndex("test");  
        // It'd be bad if the entire require completed in a single batch. The test wouldn't be testing anything.
                        )  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
/*  
    private void testCase(AbstractBulkByScrollRequestBuilder<?, ?> request, String actionName) throws Exception {  
            float totalRequestsPerSecond = 0;  
                );  
            response.getBatches(),
    public void testReindexWithWorkers() throws Exception {  
            assertTrue("At least one slice must be rethrottled", oneSliceRethrottled);  
        testCase(deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()), DeleteByQueryAction.NAME);  
        testCase(updateByQuery().source("test").setSlices(randomSlices()), UpdateByQueryAction.NAME);
        } while (System.nanoTime() - start < TimeUnit.SECONDS.toNanos(10));
            for (BulkByScrollTask.StatusOrException statusOrException : status.getSliceStatuses()) {
/*  
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
                ? Float.POSITIVE_INFINITY  
