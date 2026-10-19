import java.util.Set;
                });
        }
                channel.close();
                @Override
        }
            }
                    }
import static org.hamcrest.Matchers.in;
            @Override
        assertThat(taskManager.numberOfChannelPendingTaskTrackers(), equalTo(0));
     * they don't succeed at first.
import org.opensearch.threadpool.ThreadPool;
            void cancelTaskAndDescendants(CancellableTask task, String reason, boolean waitForCompletion, ActionListener<Void> listener) {
import java.util.Map;
/*
import org.opensearch.common.lease.Releasables;
            if (isOpen()) {
        terminate(threadPool);
 */
                assertTrue("task [" + task + "] was cancelled already", cancelledTasks.add(task));
import org.opensearch.common.settings.Settings;
            final FakeTcpChannel channel = randomFrom(channels);
        FakeTcpChannel[] channels = new FakeTcpChannel[randomIntBetween(1, 10)];
                    expectedCancelledTasks.remove(task);
 *
    static class SingleThreadedTcpChannel extends FakeTcpChannel {
        public void addCloseListener(ActionListener<Void> listener) {
package org.opensearch.tasks;
            channels[i] = new FakeTcpChannel();
                registeredListener = true;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.action.admin.cluster.node.tasks.TransportTasksActionTests;
                }
import org.opensearch.transport.TransportService;
                for (int i = 0; i < iterations; i++) {
                assertThat(reason, equalTo("channel was closed"));
        Iterator<TimeValue> times = TaskResultsService.STORE_BACKOFF_POLICY.iterator();
 * specific language governing permissions and limitations
        runnableTaskListener = new AtomicReference<>();
        }
        }
    public void testTrackingTaskAndCloseChannelConcurrently() throws Exception {
            final Releasable stopTracking = taskManager.startTrackingCancellableChannelTask(channel, (CancellableTask) task);
 */
import org.opensearch.transport.FakeTcpChannel;
    }
import java.util.ArrayList;
                assertFalse(waitForCompletion);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        List<Releasable> stopTrackingTasks = new ArrayList<>();
     */
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under
import java.util.concurrent.atomic.AtomicReference;
            return new CancellableTask(id, type, action, "request-" + requestId, parentTaskId, headers) {
                public boolean shouldCancelChildrenOnCancellation() {
                    return false;
        threadPool = new TestThreadPool(TransportTasksActionTests.class.getSimpleName(), runnableTaskListener);
import java.util.List;
        }
        CancellableRequest(String requestId) {
/*
    public void terminateThreadPool() {
import java.util.concurrent.Phaser;
        final TaskManager taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
        });
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.threadpool.RunnableTaskExecutionListener;
                    return getDescription();
    public void testResultsServiceRetryTotalTime() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        taskManager.setTaskCancellationService(new TaskCancellationService(mock(TransportService.class)) {
                int iterations = randomIntBetween(50, 500);
            channel.close();
import org.opensearch.threadpool.TestThreadPool;
                    final FakeTcpChannel channel = randomFrom(channels);
    public void setupThreadPool() {
        for (int i = 0; i < channels.length; i++) {
    static class CancellableRequest extends TransportRequest {
        for (FakeTcpChannel channel : channels) {
import org.junit.Before;
                public String toString() {
                assertTrue("task [" + task + "] was cancelled already", cancelledTasks.add(task));
                expectedCancelledTasks.add(task);
 * Unless required by applicable law or agreed to in writing,
            }
        for (int t = 0; t < threads.length; t++) {
                    final Task task = taskManager.register("transport", "test", new CancellableRequest(threadName + ":" + i));
import java.util.HashMap;
import org.opensearch.core.action.ActionListener;
        for (int i = 0; i < channels.length; i++) {
import static org.mockito.Mockito.mock;
import org.opensearch.transport.TcpChannel;
            });
        while (times.hasNext()) {
        for (Thread thread : threads) {
        long total = 0;
            void cancelTaskAndDescendants(CancellableTask task, String reason, boolean waitForCompletion, ActionListener<Void> listener) {
        final TaskManager taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(taskManager.numberOfChannelPendingTaskTrackers(), equalTo(0));
            @Override
            super.addCloseListener(listener);
import org.opensearch.transport.TransportRequest;
        Set<Task> expectedCancelledTasks = ConcurrentCollections.newConcurrentSet();
        }
import static org.hamcrest.Matchers.everyItem;
 */
 *
 *
                        randomFrom(channels).close();
    }
                    taskManager.startTrackingCancellableChannelTask(channel, (CancellableTask) task);
 * GitHub history for details.
                phaser.arriveAndAwaitAdvance();
        }
import static org.hamcrest.Matchers.equalTo;
            if (channel.isOpen()) {
            threads[t].start();
        for (int i = 0; i < iterations; i++) {
        private boolean registeredListener = false;
        taskManager.setTaskCancellationService(new TaskCancellationService(mock(TransportService.class)) {
import java.util.concurrent.TimeUnit;
 * KIND, either express or implied.  See the License for the
                    expectedCancelledTasks.add(task);
            threads[t] = new Thread(() -> {
import java.util.HashSet;
        int iterations = randomIntBetween(1, 200);
            thread.join();
            if (channel.isOpen() && randomBoolean()) {
            }
    }
    @Before
    }
        }
            } else {
     * Makes sure that tasks that attempt to store themselves on completion retry if
    }
            stopTrackingTasks.removeAll(subset);
 * software distributed under the License is distributed on an
            }
import java.util.Collections;
    private ThreadPool threadPool;
import org.junit.After;
        @Override
import org.opensearch.common.lease.Releasable;
    public void testTrackingChannelTask() throws Exception {
/*
 * under the License.
        }
 * not use this file except in compliance with the License.
        Set<CancellableTask> cancelledTasks = ConcurrentCollections.newConcurrentSet();
            }
 * this file be licensed under the Apache-2.0 license or a
        }
                pendingTasks.computeIfAbsent(channel, k -> new HashSet<>()).add(task);
 * You may obtain a copy of the License at
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(600000L, total);
        assertBusy(() -> assertThat(cancelledTasks, equalTo(expectedCancelledTasks)), 1, TimeUnit.MINUTES);
        }
        FakeTcpChannel[] channels = new FakeTcpChannel[randomIntBetween(1, 10)];
        Phaser phaser = new Phaser(threads.length);
                @Override
            };
        Set<Task> expectedCancelledTasks = new HashSet<>();
        Set<Task> cancelledTasks = ConcurrentCollections.newConcurrentSet();
        Thread[] threads = new Thread[randomIntBetween(2, 8)];
public class TaskManagerTests extends OpenSearchTestCase {
            final List<Releasable> subset = randomSubsetOf(stopTrackingTasks);
                    if (randomInt(100) < 5) {
    @After
                }
            channel.close();
            channels[i] = new SingleThreadedTcpChannel();
    }
 * this work for additional information regarding copyright
        for (FakeTcpChannel channel : channels) {
                stopTrackingTasks.add(() -> {
        private final String requestId;
            Releasables.close(subset);
        Map<TcpChannel, Set<Task>> pendingTasks = new HashMap<>();
import java.util.Iterator;
    /**
                    assertTrue(pendingTasks.get(channel).remove(task));
            String threadName = "thread-" + t;
            this.requestId = requestId;
 * The OpenSearch Contributors require contributions made to
        });
                    stopTracking.close();
                assertFalse("listener was registered already", registeredListener);
    private AtomicReference<RunnableTaskExecutionListener> runnableTaskListener;
        public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
            total += times.next().millis();
            final Task task = taskManager.register("transport", "test", new CancellableRequest(Integer.toString(i)));
        assertBusy(() -> assertThat(expectedCancelledTasks, everyItem(in(cancelledTasks))), 30, TimeUnit.SECONDS);
                expectedCancelledTasks.addAll(pendingTasks.getOrDefault(channel, Collections.emptySet()));
import org.opensearch.core.tasks.TaskId;
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.common.unit.TimeValue;
                }
 * license agreements. See the NOTICE file distributed with
}
    }
        @Override
