 * this file be licensed under the Apache-2.0 license or a
        // Execute a task multiple times that takes 1ms  
        executeTask(executor, 1);
            return testFailedOrRejected;  
 * based on the time taken for each event.  
            this.timeTaken = timeTaken;
        assertBusy(() -> assertThat(queue.capacity(), lessThanOrEqualTo(1000)));
import java.util.concurrent.TimeUnit;  
        createExecutor(100, exceptionalWrapper());  
package org.opensearch.common.util.concurrent;
public class QueueResizableOpenSearchThreadPoolExecutorTests extends OpenSearchTestCase {
        assertThat((long) executor.getTaskExecutionEWMA(), equalTo(0L));  
        return (runnable) -> new SettableTimedRunnable(TimeUnit.NANOSECONDS.toNanos(100), false);  
    private int measureWindow;
    }
            new OpenSearchAbortPolicy(),  
import org.opensearch.common.settings.Settings;
        public long getTotalExecutionNanos() {  
/*  
        createExecutor(100, fastWrapper());
            "test-threadpool",
        // Execute a task multiple times that takes 1ms  
        public long getTotalNanos() {
     */
/**
        executeTask(executor, 1);
        assertBusy(() -> assertThat((long) executor.getTaskExecutionEWMA(), equalTo(83L)));
import java.util.function.Function;
    }
        for (int i = 0; i < times; i++) {  
        assertThat(executor.resize(1500), equalTo(1500));
        executeTask(executor, (measureWindow * 5) + 2);
    }
        }
    public void testResizeQueueUp() throws Exception {
        assertBusy(() -> assertThat(queue.capacity(), lessThanOrEqualTo(1500)));
    }
        createExecutor(2000, fastWrapper());
    public void testExceptionThrowingTask() {
        createExecutor(2000, fastWrapper());
            this.testFailedOrRejected = failedOrRejected;  
    public void testResizeQueueSameSize() throws Exception {  
        assertThat(executor.resize(1000), equalTo(1000));
        executeTask(executor, 1);
    private void createExecutor(int queueSize, Function<Runnable, WrappedRunnable> runnableWrapper) {
    }  
        executeTask(executor, 1);
            OpenSearchExecutors.daemonThreadFactory("queuetest"),
        logger.info("--> executor: {}", executor);
    /** Execute a blank task {@code times} times for the executor */  
    }
     * The returned function outputs a WrappedRunnabled that simulates the case
    @After
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertBusy(() -> assertThat(queue.capacity(), greaterThanOrEqualTo(2000)));
    private Function<Runnable, WrappedRunnable> exceptionalWrapper() {
    }
        }
    private Function<Runnable, WrappedRunnable> fastWrapper() {
        executeTask(executor, 1);  
 *
     * the job failed or was rejected before it finished.  
        // Execute a task multiple times that takes 1ms  
    }
        assertThat((long) executor.getTaskExecutionEWMA(), equalTo(0L));
        measureWindow = randomIntBetween(100, 200);  
        this.queue = new ResizableBlockingQueue<>(ConcurrentCollections.newBlockingQueue(), queueSize);
        executor.prestartAllCoreThreads();  
    /**  
        executeTask(executor, (measureWindow * 5) + 2);
        executeTask(executor, (measureWindow * 5) + 2);
            super(() -> {});
        public SettableTimedRunnable(long timeTaken, boolean failedOrRejected) {  
    private static class SettableTimedRunnable extends TimedRunnable {
        );
    private void executeTask(QueueResizableOpenSearchThreadPoolExecutor executor, int times) {
        @Override
import static org.hamcrest.Matchers.equalTo;  
            runnableWrapper,
        private final boolean testFailedOrRejected;
    }
            threads,  
        ThreadPool.terminate(executor, 10, TimeUnit.SECONDS);  
import org.junit.After;
        assertBusy(() -> assertThat((long) executor.getTaskExecutionEWMA(), equalTo(51L)));
 */
        logger.info("--> executing a task [{}] times", times);
    public void stopExecutor() {
    }
    public void testResizeQueueDown() throws Exception {
        public boolean getFailedOrRejected() {
            return timeTaken;
            TimeUnit.MILLISECONDS,
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    private QueueResizableOpenSearchThreadPoolExecutor executor;  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.threadpool.ThreadPool;  
        }  
 * The OpenSearch Contributors require contributions made to  
        @Override
        assertBusy(() -> assertThat((long) executor.getTaskExecutionEWMA(), equalTo(75L)));
    private ResizableBlockingQueue<Runnable> queue;
    public void testExecutionEWMACalculation() throws Exception {
        ThreadContext context = new ThreadContext(Settings.EMPTY);
        }
 * Tests for the automatic queue resizing of the {@code QueueResizableOpenSearchThreadPoolExecutor}
 * compatible open source license.
        createExecutor(2000, fastWrapper());
        assertThat(executor.resize(3000), equalTo(3000));
            executor.execute(() -> {});
    /** Use a runnable wrapper that simulates a task with unknown failures. */
        assertBusy(() -> assertThat((long) executor.getTaskExecutionEWMA(), equalTo(65L)));  
            queue,  
        @Override  
        }
     * where {@link TimedRunnable#getTotalExecutionNanos()} returns -1 because
        return (runnable) -> new SettableTimedRunnable(TimeUnit.NANOSECONDS.toNanos(-1), true);  
        this.executor = new QueueResizableOpenSearchThreadPoolExecutor(  
            return timeTaken;
            1000,
            context
    }  
        int threads = randomIntBetween(1, 10);
 * SPDX-License-Identifier: Apache-2.0
}  
        assertBusy(() -> assertThat((long) executor.getTaskExecutionEWMA(), equalTo(30L)));
        private final long timeTaken;  
 */  
            threads,
        executeTask(executor, 1);  
