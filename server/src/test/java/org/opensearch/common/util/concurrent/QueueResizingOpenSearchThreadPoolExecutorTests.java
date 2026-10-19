            threads,  
            new OpenSearchAbortPolicy(),  
public class QueueResizingOpenSearchThreadPoolExecutorTests extends OpenSearchTestCase {
            TimeUnit.MILLISECONDS,
        int threads = randomIntBetween(1, 5);
        executor.shutdown();
            "test-threadpool",
            TimeValue.timeValueMillis(1),
import static org.hamcrest.Matchers.greaterThan;  
     * The returned function outputs a WrappedRunnabled that simulates the case  
        // The queue capacity should have increased by 50 since they were very fast tasks
        executor.prestartAllCoreThreads();  
    public void testExactWindowSizeAdjustment() throws Exception {  
        logger.info("--> executor: {}", executor);
            context  
        private final long timeTaken;
            queue,
            new OpenSearchAbortPolicy(),
 *     http://www.apache.org/licenses/LICENSE-2.0
            measureWindow,  
        );
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
    private Function<Runnable, WrappedRunnable> fastWrapper() {  
        logger.info("--> executor: {}", executor);
            10,
        executeTask(executor, 1);
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 100);  
            10,  
            10,  
        int measureWindow = 3;
    }
            100000,
    }  
            context  
        executeTask(executor, 1);  
        assertThat((long) executor.getTaskExecutionEWMA(), equalTo(0L));
            10,  
        }
            OpenSearchExecutors.daemonThreadFactory("queuetest"),  
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
        logger.info("--> executor: {}", executor);
        executeTask(executor, 1);
        executeTask(executor, (measureWindow * 5) + 2);
        assertBusy(() -> { assertThat(queue.capacity(), equalTo(max)); });
        executor.awaitTermination(10, TimeUnit.SECONDS);  
        executeTask(executor, (measureWindow * 5));
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(65L)); });
            new OpenSearchAbortPolicy(),
            threads,  
            TimeUnit.MILLISECONDS,
            super(() -> {});  
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 5000);
        executor.shutdown();
 * this work for additional information regarding copyright
        logger.info("--> executor: {}", executor);  
    /**
            TimeUnit.MILLISECONDS,
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 5000);
        int threads = randomIntBetween(1, 5);
            1,
        @Override  
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
        executor.awaitTermination(10, TimeUnit.SECONDS);  
     */  
            TimeUnit.MILLISECONDS,
        }  
        executor.prestartAllCoreThreads();
        executor.execute(() -> {});
        ThreadContext context = new ThreadContext(Settings.EMPTY);
            this.timeTaken = timeTaken;
        ThreadContext context = new ThreadContext(Settings.EMPTY);
    public void testAutoQueueSizingUp() throws Exception {
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
        ThreadContext context = new ThreadContext(Settings.EMPTY);
 * the Apache License, Version 2.0 (the "License"); you may
            TimeUnit.MILLISECONDS,  
            slowWrapper(),  
            queue,  
import org.opensearch.common.settings.Settings;
        int threads = randomIntBetween(1, 3);
 *
        executor.shutdown();
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
        int measureWindow = randomIntBetween(100, 200);
        return (runnable) -> new SettableTimedRunnable(TimeUnit.MINUTES.toNanos(2), false);
            new OpenSearchAbortPolicy(),
            "test-threadpool",  
    public void testExecutionEWMACalculation() throws Exception {  
        executor.prestartAllCoreThreads();  
        ThreadContext context = new ThreadContext(Settings.EMPTY);
            fastWrapper(),
            threads,
    }
        public long getTotalExecutionNanos() {
import java.util.function.Function;  
        executor.awaitTermination(10, TimeUnit.SECONDS);  
        executor.execute(() -> {});  
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
            TimeValue.timeValueMillis(1),
     * where {@link TimedRunnable#getTotalExecutionNanos()} returns -1 because
            threads,
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(51L)); });  
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
 * Unless required by applicable law or agreed to in writing,
            threads,
        assertBusy(() -> { assertThat(queue.capacity(), greaterThan(2000)); });  
 * Modifications Copyright OpenSearch Contributors. See
/*
        logger.info("--> executing a task [{}] times", times);
            threads,
        );
            context
        }  
        int min = randomIntBetween(4981, 4999);  
     * the job failed or was rejected before it finished.
            executor.execute(() -> {});  
 */  
            TimeValue.timeValueMillis(1),  
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
            200,  
    /** Use a runnable wrapper that simulates a task with unknown failures. */  
 * software distributed under the License is distributed on an
            threads,
        executor.awaitTermination(10, TimeUnit.SECONDS);  
        executor.awaitTermination(10, TimeUnit.SECONDS);
        executeTask(executor, 1);
        return (runnable) -> new SettableTimedRunnable(TimeUnit.NANOSECONDS.toNanos(100), false);
            fastWrapper(),
            threads,
    private void executeTask(QueueResizingOpenSearchThreadPoolExecutor executor, int times) {  
        int measureWindow = randomIntBetween(10, 100);
        }
            1,  
            1000,
            10,  
 * this file be licensed under the Apache-2.0 license or a
        // Execute a task multiple times that takes 1m  
 * under the License.  
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
            context
        executor.shutdown();  
        executor.prestartAllCoreThreads();
            context
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 2000);
/*  
        );
        );
 * SPDX-License-Identifier: Apache-2.0
            1000,  
 * compatible open source license.
        executor.execute(() -> {});
        int max = randomIntBetween(5010, 5024);  
        // Execute a task multiple times that takes 1ms  
            TimeValue.timeValueMillis(1),
            queue,
        public SettableTimedRunnable(long timeTaken, boolean failedOrRejected) {
            1000,  
            new OpenSearchAbortPolicy(),  
    private Function<Runnable, WrappedRunnable> exceptionalWrapper() {
    public void testExceptionThrowingTask() throws Exception {
import static org.hamcrest.Matchers.lessThan;
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
            queue,
    }
        public boolean getFailedOrRejected() {
            TimeUnit.MILLISECONDS,  
            max,
            "test-threadpool",  
            10,
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
/*  
            measureWindow,  
 *  
        // The queue capacity should decrease, but no lower than the minimum  
            measureWindow,  
        @Override
 * ownership. Elasticsearch licenses this file to you under  
            TimeUnit.MILLISECONDS,
        );
}
        assertBusy(() -> { assertThat(queue.capacity(), equalTo(min)); });
        executeTask(executor, 1);
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 2000);  
            min,  
 * Tests for the automatic queue resizing of the {@code QueueResizingOpenSearchThreadPoolExecutor}
    private Function<Runnable, WrappedRunnable> slowWrapper() {
            "test-threadpool",
        int threads = randomIntBetween(1, 10);  
        return (runnable) -> new SettableTimedRunnable(TimeUnit.NANOSECONDS.toNanos(-1), true);
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
 * specific language governing permissions and limitations
            3000,
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(75L)); });
 * The OpenSearch Contributors require contributions made to  
            context
        executeTask(executor, 1);  
        executor.prestartAllCoreThreads();  
    }
    }
            3000,
            new OpenSearchAbortPolicy(),  
 *
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(  
 * based on the time taken for each event.
            "test-threadpool",  
        public long getTotalNanos() {  
            TimeValue.timeValueMillis(1),
 */  
            threads,
            1000,  
        executeTask(executor, measureWindow * 3);
            10,
import java.util.concurrent.TimeUnit;
            1,
        assertThat((long) executor.getTaskExecutionEWMA(), equalTo(0L));  
            fastWrapper(),
            10,
            queue,
            new OpenSearchAbortPolicy(),  
            queue,
            measureWindow,
        // The queue capacity should increase, but no higher than the maximum  
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(83L)); });  
        executeTask(executor, (measureWindow * 5) + 2);
            1000,  
        ThreadContext context = new ThreadContext(Settings.EMPTY);
        assertBusy(() -> { assertThat((long) executor.getTaskExecutionEWMA(), equalTo(30L)); });
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
            return timeTaken;
            TimeValue.timeValueMillis(1),  
        for (int i = 0; i < times; i++) {
package org.opensearch.common.util.concurrent;
 * KIND, either express or implied.  See the License for the
        logger.info("--> executor: {}", executor);  
    /** Execute a blank task {@code times} times for the executor */
            200,
        ThreadContext context = new ThreadContext(Settings.EMPTY);  
import org.opensearch.test.OpenSearchTestCase;  
/**  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testAutoQueueSizingWithMax() throws Exception {  
    }  
 */  
        // Execute a task multiple times that takes 1ms  
        executor.prestartAllCoreThreads();  
    public void testAutoQueueSizingWithMin() throws Exception {  
import org.opensearch.common.unit.TimeValue;
        @Override
        int measureWindow = randomIntBetween(100, 200);  
            TimeValue.timeValueMillis(1),
        assertBusy(() -> { assertThat(queue.capacity(), equalTo(150)); });
    }
        );  
 * You may obtain a copy of the License at  
            this.testFailedOrRejected = failedOrRejected;
 * license agreements. See the NOTICE file distributed with
            1000,  
            "test-threadpool",  
        assertBusy(() -> { assertThat(queue.capacity(), lessThan(2000)); });
        logger.info("--> executor: {}", executor);
        QueueResizingOpenSearchThreadPoolExecutor executor = new QueueResizingOpenSearchThreadPoolExecutor(
        private final boolean testFailedOrRejected;  
        executor.awaitTermination(10, TimeUnit.SECONDS);  
            return testFailedOrRejected;
            return timeTaken;  
            1000,
            1,
            1000,
        executor.prestartAllCoreThreads();
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
        }
        executor.shutdown();
            fastWrapper(),
 */
import static org.hamcrest.Matchers.equalTo;
    }
            "test-threadpool",
            exceptionalWrapper(),
            queue,
            measureWindow,
            context
        int measureWindow = randomIntBetween(10, 100);
        int threads = randomIntBetween(1, 10);
        executor.shutdown();
    }
        logger.info("--> executor: {}", executor);
        // Execute a task multiple times that takes 1m
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 100);
    }  
        logger.info("--> auto-queue with a measurement window of {} tasks", measureWindow);  
        ResizableBlockingQueue<Runnable> queue = new ResizableBlockingQueue<>(ConcurrentCollections.<Runnable>newBlockingQueue(), 100);
    public void testAutoQueueSizingDown() throws Exception {
        ThreadContext context = new ThreadContext(Settings.EMPTY);
    public class SettableTimedRunnable extends TimedRunnable {
 * not use this file except in compliance with the License.
            threads,
        // Execute exactly 3 (measureWindow) times
 * GitHub history for details.
            slowWrapper(),
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
        );
