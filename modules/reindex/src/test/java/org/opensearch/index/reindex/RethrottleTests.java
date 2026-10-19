 *    http://www.apache.org/licenses/LICENSE-2.0
                    .getStatus();
                assertThat(
    }
                 * is possible that we'll end up with some very small slices
        logger.info("Starting test for [{}] with [{}] slices", actionName, request.request().getSlices());
            }
                );
                );
 * serialization.
        request.source().setSize(1);             // Make sure we use multiple batches
                        "task ["
    }
                .filter(slice -> slice.getStatus().getTotal() > slice.getStatus().getSuccessfullyProcessed())
    public void testReindexWithWorkers() throws Exception {
        assertBusy(() -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.OpenSearchException;
}
                    .get();
            boolean oneSliceRethrottled = false;
            }
import org.opensearch.action.index.IndexRequestBuilder;
            docs.add(client().prepareIndex("test").setId(Integer.toString(i)).setSource("foo", "bar"));
            // There should be a sane number of child tasks running
import org.opensearch.ExceptionsHelper;
 *
                    status.getSliceStatuses()
import static org.hamcrest.Matchers.empty;
 * not use this file except in compliance with the License.
                 */
 */
    public void testUpdateByQueryWithWorkers() throws Exception {
 * GitHub history for details.
            if (0 == tasks.getTaskGroups().size()) {
import static org.hamcrest.Matchers.lessThan;
 * The OpenSearch Contributors require contributions made to
            } catch (OpenSearchException e) {
            greaterThanOrEqualTo(numSlices)
            float maxExpectedSliceRequestsPerSecond = newRequestsPerSecond == Float.POSITIVE_INFINITY
import java.util.List;
                // We want to retry in this case so we throw an assertion error
                    .get()
        }
                assertThat(rethrottleResponse.getTasks(), hasSize(1));
            // Wait for all of the sub tasks to start (or finish, some might finish early, all that matters is that not all do)
                totalRequestsPerSecond += slice.getRequestsPerSecond();
                if (slice.getTotal() > slice.getSuccessfullyProcessed()) {
 * Modifications Copyright OpenSearch Contributors. See
                continue;
        // Now rethrottle it so it'll finish
 * You may obtain a copy of the License at
            /* Check that at least one slice was rethrottled. We won't always rethrottle all of them because they might have completed.
        AtomicReference<ListTasksResponse> response = new AtomicReference<>();
/*
                }
        // the task isn't ready to be rethrottled until it has figured out how many slices it will use. if we rethrottle when the task is
            return taskGroup;
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
 * under the License.
            if (sliceCount != 1) {
        );
                BulkByScrollTask.Status slice = statusOrException.getStatus();
                assertThat(finishedSubTasks + list.getTasks().size(), greaterThanOrEqualTo((long) numSlices));
 * specific language governing permissions and limitations
        if (numSlices == 1) {
            float totalRequestsPerSecond = 0;
import static org.hamcrest.Matchers.greaterThan;
                     * rethrottle request came through. */
 * license agreements. See the NOTICE file distributed with
             * are rethrottled, the finished ones just keep whatever requests per second they had while they were running. But it might
                ? Float.POSITIVE_INFINITY
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            }
                    sliceCount,
                    .setRequestsPerSecond(newRequestsPerSecond)
                }
 * SPDX-License-Identifier: Apache-2.0
             * With multiple slices these numbers might not add up perfectly, thus the 1.01F. */
                if (statusOrException == null) {
        indexRandom(true, docs);
    public void testUpdateByQuery() throws Exception {
        testCase(updateByQuery().source("test"), UpdateByQueryAction.NAME);
                ListTasksResponse rethrottleResponse = rethrottle().setTaskId(taskToRethrottle)
                    .cluster()
            }
import static org.hamcrest.Matchers.allOf;
                long finishedSubTasks = parent.getSliceStatuses().stream().filter(Objects::nonNull).count();
import static org.hamcrest.Matchers.both;
                 * If there are child tasks wait for all of them to start. It
                        both(greaterThanOrEqualTo(minExpectedSliceRequestsPerSecond)).and(
 * software distributed under the License is distributed on an
        ListTasksResponse rethrottleResponse = rethrottleTask(taskToRethrottle, newRequestsPerSecond);
         */
             * won't be rethrottled, thus only contributing its lower total. */
             * actually has the newRequestsPerSecond. For the most part it will. Sometimes it'll be greater because only unfinished requests
                    continue;
    }
        TaskGroup taskGroupToRethrottle = findTaskToRethrottle(actionName, numSlices);
                }
        /* Add ten documents per slice so most slices will have many documents to process, having to go to multiple batches.
                    "Expected [{}] total children, [{}] are running and [{}] are finished\n{}",
                .count();
            float minExpectedSliceRequestsPerSecond = newRequestsPerSecond == Float.POSITIVE_INFINITY
                list.rethrowFailures("subtasks");
        do {
                        slice.getRequestsPerSecond(),
                .stream()
        testCase(updateByQuery().source("test").setSlices(randomSlices()), UpdateByQueryAction.NAME);
import java.util.concurrent.TimeUnit;
            "Couldn't find tasks to rethrottle. Here are the running tasks " + client().admin().cluster().prepareListTasks().get()
        // in this state, the request will fail. so we try a few times
 * Tests that you can set requests_per_second over the Java API and that you can rethrottle running requests. There are REST tests for this
    private TaskGroup findTaskToRethrottle(String actionName, int sliceCount) {
                            + taskToRethrottle.getId()
                assertThat(list.getTasks().size(), greaterThan(0));
 */
                }
                    fail("all slices finished:\n" + status);
        ActionFuture<? extends BulkByScrollResponse> responseListener = request.execute();
 *
                : (newRequestsPerSecond / numSlices) * 0.99F;
                    unwrapped.getMessage(),
    }
            });
/**
            /* Now assert that the parent request has the total requests per second. This is a much weaker assertion than that the parent
                    equalTo(
 * the Apache License, Version 2.0 (the "License"); you may
                if (sliceCount == finishedChildStatuses) {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            TaskGroup taskGroup = tasks.getTaskGroups().get(0);
        } else {
                    taskGroup.getChildTasks().size(),
package org.opensearch.index.reindex;
        float newRequestsPerSecond = randomBoolean() ? Float.POSITIVE_INFINITY : between(1, 1000) * 100000; // No throttle or "very fast"
import org.opensearch.core.tasks.TaskId;
 * Licensed to Elasticsearch under one or more contributor
                response.set(rethrottleResponse);
                ? Float.POSITIVE_INFINITY
 * this work for additional information regarding copyright
import java.util.concurrent.atomic.AtomicReference;
    public void testDeleteByQuery() throws Exception {
        if (numSlices == 1) {
                    .getTask()
        testCase(reindex().source("test").destination("dest"), ReindexAction.NAME);
        for (int i = 0; i < numSlices * 10; i++) {
        // Now the response should come back quickly because we've rethrottled the request
             * requests are rethrottled. If one request finishes in between the division and the application of the new throttle then it
        // It'd be bad if the entire require completed in a single batch. The test wouldn't be testing anything.
import org.opensearch.action.admin.cluster.node.tasks.list.TaskGroup;
                ListTasksResponse list = client().admin().cluster().prepareListTasks().setParentTaskId(taskToRethrottle).get();
 * too but this is the only place that tests running against multiple nodes so it is the only integration tests that checks for
                if (sliceCount != taskGroup.getChildTasks().size() + finishedChildStatuses) {
                 * (maybe even empty!) that complete super fast so we have to
        testCase(deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()).setSlices(randomSlices()), DeleteByQueryAction.NAME);
    }
                    throw e;
                BulkByScrollTask.Status parent = (BulkByScrollTask.Status) client().admin()
 */
        List<IndexRequestBuilder> docs = new ArrayList<>();
 *
        });
    private void testCase(AbstractBulkByScrollRequestBuilder<?, ?> request, String actionName) throws Exception {
        assertThat(
        throw new AssertionError(
        BulkByScrollTask.Status status = (BulkByScrollTask.Status) rethrottleResponse.getTasks().get(0).getStatus();
        return response.get();
        int numSlices = expectedSlices(request.request().getSlices(), "test");
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.query.QueryBuilders;
    }
                if (unwrapped == null) {
import static org.hamcrest.Matchers.hasSize;
                logger.info(
                        )
        request.setRequestsPerSecond(.000001f);  // Throttle "forever"
                    /* The slice can be null here because it was completed but hadn't reported its success back to the task when the
/*
            tasks.rethrowFailures("Finding tasks to rethrottle");
                    .getTask()
    }
                assertNull(statusOrException.getException());
                    && slice.getRequestsPerSecond() <= maxExpectedSliceRequestsPerSecond) {
                    assertThat(
 */
import java.util.Objects;
            long unfinished = status.getSliceStatuses()
/*
                    // This slice reports as not having completed so it should have been processed.
import java.util.ArrayList;
            assertEquals(newRequestsPerSecond, status.getRequestsPerSecond(), Float.MIN_NORMAL);
    }
        // Now check the resulting requests per second.
        } else {
                if (minExpectedSliceRequestsPerSecond <= slice.getRequestsPerSecond()
    }
 * ownership. Elasticsearch licenses this file to you under
            assertTrue("At least one slice must be rethrottled", oneSliceRethrottled);
                .filter(Objects::nonNull)
                // The parent task hasn't started yet
                    .prepareGetTask(taskToRethrottle)
        );
            for (BulkByScrollTask.StatusOrException statusOrException : status.getSliceStatuses()) {
            try {
            assertThat("tasks are left over from the last execution of this test", tasks.getTaskGroups(), hasSize(lessThan(2)));
                : (newRequestsPerSecond / unfinished) * 1.01F;
            assertBusy(() -> {
         * We can't rely on the slices being evenly sized but 10 means we have some pretty big slices.
                /*
        }
        // Start a request that will never finish unless we rethrottle it
        testCase(reindex().source("test").destination("dest").setSlices(randomSlices()), ReindexAction.NAME);
            // If there is a single slice it should match perfectly
 * this file be licensed under the Apache-2.0 license or a
             * also be less than newRequestsPerSecond because the newRequestsPerSecond is divided among running sub-requests and then the
                            + "] has not yet been initialized to the point where it knows how to rethrottle itself"
    private ListTasksResponse rethrottleTask(TaskId taskToRethrottle, float newRequestsPerSecond) throws Exception {
            "Entire request completed in a single batch. This may invalidate the test as throttling is done between batches.",
            ListTasksResponse tasks = client().admin().cluster().prepareListTasks().setActions(actionName).setDetailed(true).get();
                logger.info("caught unprepared task, retrying until prepared");
                BulkByScrollTask.Status status = (BulkByScrollTask.Status) taskGroup.getTaskInfo().getStatus();
            assertThat(taskGroupToRethrottle.getChildTasks(), empty());
        BulkByScrollResponse response = responseListener.get();
import static org.hamcrest.Matchers.equalTo;
public class RethrottleTests extends ReindexTestCase {
 * compatible open source license.
                    finishedChildStatuses,
import org.opensearch.common.action.ActionFuture;
                rethrottleResponse.rethrowFailures("Rethrottle");
 * KIND, either express or implied.  See the License for the
                }
        testCase(deleteByQuery().source("test").filter(QueryBuilders.matchAllQuery()), DeleteByQueryAction.NAME);
        }
                    continue;
                    )
                    oneSliceRethrottled = true;
                }
        long start = System.nanoTime();
        TaskId taskToRethrottle = taskGroupToRethrottle.getTaskInfo().getTaskId();
            response.getBatches(),
        } while (System.nanoTime() - start < TimeUnit.SECONDS.toNanos(10));
                 * count them too.
                throw new AssertionError("Rethrottle request for task [" + taskToRethrottle.getId() + "] failed", e);
        createIndex("test");
            assertThat(taskGroupToRethrottle.getChildTasks(), hasSize(allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(numSlices))));
            assertEquals(totalRequestsPerSecond, status.getRequestsPerSecond(), totalRequestsPerSecond * 0.0001f);
                Throwable unwrapped = ExceptionsHelper.unwrap(e, IllegalArgumentException.class);
    public void testReindex() throws Exception {
    public void testDeleteByQueryWithWorkers() throws Exception {
                long finishedChildStatuses = status.getSliceStatuses().stream().filter(n -> n != null).count();
                            lessThanOrEqualTo(maxExpectedSliceRequestsPerSecond)
                    );
