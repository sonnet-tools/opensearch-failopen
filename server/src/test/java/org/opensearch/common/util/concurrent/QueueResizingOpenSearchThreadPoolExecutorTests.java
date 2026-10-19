 * ownership. Elasticsearch licenses this file to you under
        logger.info("--> executor: {}", executor);
        executeTask(executor, (measureWindow * 5) + 2);
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
            1000,
/**
    /**
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(51L)); });
 * under the License.
        executor.shutdown();
            TimeValue.timeValueMillis(1),
        // The queue capacity should decrease, but no lower than the minimum
 * Licensed to Elasticsearch under one or more contributor
        executeTask(executor, 1);
            slowWrapper(),
import org.opensearch.common.unit.TimeValue;
     */
            200,
            1,
 * this work for additional information regarding copyright
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
import static org.hamcrest.Matchers.greaterThan;
    public void testExecutionEWMACalculation() throws Exception {
            TimeValue.timeValueMillis(1),
        executeTask(executor, (measureWindow * 5));
    }
 * KIND, either express or implied.  See the License for the
        executor.awaitTermination(10, TimeUnit.SECONDS);
        int measureWindow = randomIntBetween(10, 100);
 * software distributed under the License is distributed on an
}
        executeTask(executor, (measureWindow * 5) + 2);
    }
 * specific language governing permissions and limitations
        public SettableTimedRunnable(long timeTaken, boolean failedOrRejected) {
        executor.awaitTermination(10, TimeUnit.SECONDS);
            queue,
            threads,
        int max = randomIntBetween(5010, 5024);
        int measureWindow = randomIntBetween(100, 200);
 * The OpenSearch Contributors require contributions made to
            new OpenSearchAbortPolicy(),
        logger.info("--> executor: {}", executor);
            TimeValue.timeValueMillis(1),
        logger.info("--> executor: {}", executor);
        logger.info("--> executor: {}", executor);
 *
    }
            threads,
        }
        executor.execute(() -> {});
 *
            1000,
 * You may obtain a copy of the License at
            exceptionalWrapper(),
        // Execute a task multiple times that takes 1ms
 */
            max,
            measureWindow,
    }
            context
    public void testAutoQueueSizingWithMax() throws Exception {
            queue,
 * SPDX-License-Identifier: Apache-2.0
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
    private Function<Runnable, WrappedRunnable> exceptionalWrapper() {
        executor.awaitTermination(10, TimeUnit.SECONDS);
package org.opensearch.common.util.concurrent;
            measureWindow,
            1000,
            10,
        logger.info("--> executor: {}", executor);
        public long getTotalNanos() {
            queue,
        }
    }
            new OpenSearchAbortPolicy(),
        executor.prestartAllCoreThreads();
            TimeValue.timeValueMillis(1),
            return testFailedOrRejected;
    public void testAutoQueueSizingWithMin() throws Exception {
        ThreadContext context = new ThreadContext(Settings.EMPTY);
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
            1,
        executor.execute(() -> {});
import static org.hamcrest.Matchers.equalTo;
            threads,
            measureWindow,
        executor.execute(() -> {});
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
        ThreadContext context = new ThreadContext(Settings.EMPTY);
            TimeValue.timeValueMillis(1),
            super(() -> {});
            "test-threadpool",
        executeTask(executor, 1);
        executor.awaitTermination(10, TimeUnit.SECONDS);
        int threads = randomIntBetween(1, 3);
import org.opensearch.test.OpenSearchTestCase;
            context
import java.util.function.Function;
 * Modifications Copyright OpenSearch Contributors. See
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 100);
        // The queue capacity should increase, but no higher than the maximum
            min,
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
        int min = randomIntBetween(4981, 4999);
public class QueueResizingOpenSearchThreadPoolExecutorTests extends OpenSearchTestCase {
            3000,
     * The returned function outputs a WrappedRunnabled that simulates the case
        logger.info("--> executor: {}", executor);
        }
            1000,
            "test-threadpool",
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(75L)); });
        executor.shutdown();
            context
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(30L)); });
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 5000);
            new OpenSearchAbortPolicy(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.concurrent.TimeUnit;
            fastWrapper(),
        );
            this.testFailedOrRejected = failedOrRejected;
        executeTask(executor, 1);
        executeTask(executor, measureWindow * 3);
        executor.prestartAllCoreThreads();
            threads,
 */
            context
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
 * Tests for the automatic queue resizing of the {@code QueueResizingOpenSearchThreadPoolExecutor}
            queue,
 * Unless required by applicable law or agreed to in writing,
        @Override
            "test-threadpool",
        assertBusy(() -> { assertThat(queue.capacity(), equalTo(min)); });
            10,
            "test-threadpool",
            1000,
    }
 * the Apache License, Version 2.0 (the "License"); you may
            100000,
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
        // Execute a task multiple times that takes 1m
            TimeValue.timeValueMillis(1),
        // Execute a task multiple times that takes 1m
            slowWrapper(),
            10,
        executor.prestartAllCoreThreads();
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
            1000,
    }
            queue,
            "test-threadpool",
        int threads = randomIntBetween(1, 5);
        ThreadContext context = new ThreadContext(Settings.EMPTY);
            fastWrapper(),
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 100);
            TimeUnit.MILLISECONDS,
 * compatible open source license.
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 2000);
            TimeValue.timeValueMillis(1),
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
        logger.info("--> executing a task [{}] times", times);
    public void testAutoQueueSizingUp() throws Exception {
        ThreadContext context = new ThreadContext(Settings.EMPTY);
            10,
            3000,
        executeTask(executor, 1);
     * where {@link TimedRunnable#getTotalExecutionNanos()} returns -1 because
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 100);
import static org.hamcrest.Matchers.lessThan;
        );
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
            context
        executor.prestartAllCoreThreads();
            new OpenSearchAbortPolicy(),
    }
            measureWindow,
    public void testAutoQueueSizingDown() throws Exception {
        executor.prestartAllCoreThreads();
            measureWindow,
            TimeUnit.MILLISECONDS,
            10,
            "test-threadpool",
        @Override
            queue,
            threads,
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(65L)); });
    public void testExceptionThrowingTask() throws Exception {
 */
        executor.shutdown();
 * license agreements. See the NOTICE file distributed with
            context
    private Function<Runnable, WrappedRunnable> slowWrapper() {
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 2000);
            threads,
 * this file be licensed under the Apache-2.0 license or a
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
        assertThat((long) executor.getTaskExecutionEWMA(), equalTo(0L));
        return (runnable) -> new SettableTimedRunnable(TimeUnit.MINUTES.toNanos(2), false);
        // Execute a task multiple times that takes 1ms
            TimeUnit.MILLISECONDS,
    public class SettableTimedRunnable extends TimedRunnable {
        int measureWindow = 3;
            context
            queue,
            fastWrapper(),
            new OpenSearchAbortPolicy(),
        );
            threads,
            threads,
        logger.info("--> executor: {}", executor);
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
        );
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
        ThreadContext context = new ThreadContext(Settings.EMPTY);
        int threads = randomIntBetween(1, 5);
        executor.shutdown();
        ThreadContext context = new ThreadContext(Settings.EMPTY);
    }
 * GitHub history for details.
        assertBusy(() -> { assertThat(queue.capacity(), equalTo(150)); });
        executeTask(executor, 1);
        );
/*
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
        assertBusy(() -> { assertThat(queue.capacity(), greaterThan(2000)); });
 *
        int measureWindow = randomIntBetween(10, 100);
            10,
            this.timeTaken = timeTaken;
            200,
            1,
        assertBusy(() -> { assertThat(queue.capacity(), lessThan(2000)); });
            1,
        executor.awaitTermination(10, TimeUnit.SECONDS);
    private void executeTask(QueueResizingOpenSearchThreadPoolExecutor executor, int times) {
        return (runnable) -> new SettableTimedRunnable(TimeUnit.NANOSECONDS.toNanos(100), false);
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
 */
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(83L)); });
/*
            new OpenSearchAbortPolicy(),
        }
            new OpenSearchAbortPolicy(),
    }
        private final long timeTaken;
        executor.prestartAllCoreThreads();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
            "test-threadpool",
 * not use this file except in compliance with the License.
            10,
        ThreadContext context = new ThreadContext(Settings.EMPTY);
    private Function<Runnable, WrappedRunnable> fastWrapper() {
        assertBusy(() -> { assertThat(queue.capacity(), equalTo(max)); });
import org.opensearch.common.settings.Settings;
            10,
        @Override
        executor.shutdown();
        // Execute exactly 3 (measureWindow) times
            TimeUnit.MILLISECONDS,
            executor.execute(() -> {});
    public void testExactWindowSizeAdjustment() throws Exception {
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
            TimeUnit.MILLISECONDS,
/*
        int threads = randomIntBetween(1, 10);
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
        executor.shutdown();
     * the job failed or was rejected before it finished.
            threads,
    /** Use a runnable wrapper that simulates a task with unknown failures. */
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executeTask(executor, 1);
            1000,
        public long getTotalExecutionNanos() {
        executor.shutdown();
            threads,
            return timeTaken;
        // The queue capacity should have increased by 50 since they were very fast tasks
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
        executor.prestartAllCoreThreads();
        int measureWindow = randomIntBetween(100, 200);
        }
            fastWrapper(),
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 5000);
    /** Execute a blank task {@code times} times for the executor */
            1000,
    }
        assertThat((long) executor.getTaskExecutionEWMA(), equalTo(0L));
            TimeUnit.MILLISECONDS,
        int threads = randomIntBetween(1, 10);
        return (runnable) -> new SettableTimedRunnable(TimeUnit.NANOSECONDS.toNanos(-1), true);
 * based on the time taken for each event.
        );
            TimeUnit.MILLISECONDS,
            return timeTaken;
        public boolean getFailedOrRejected() {
        private final boolean testFailedOrRejected;
        for (int i = 0; i < times; i++) {
