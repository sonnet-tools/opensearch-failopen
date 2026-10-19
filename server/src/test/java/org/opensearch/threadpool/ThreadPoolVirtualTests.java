    public void testVirtualThreadPoolInfo() {  
            assertTrue(latch.await(10, TimeUnit.SECONDS));
    private static final String POOL_NAME = "test_virtual";
    }
        ThreadPool threadPool = buildThreadPool();
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
        ThreadPool threadPool = buildThreadPool();
                threadPool.executor(POOL_NAME)  
        } finally {
    private static ThreadPoolStats.Stats statsFor(ThreadPool threadPool) {
                    try {
            assertBusy(() -> {
import org.opensearch.test.OpenSearchTestCase;
        return new ThreadPool(settings, new VirtualExecutorBuilder(POOL_NAME));
        }
            block.countDown();  
            assertBusy(() -> {  
        info.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    }  
            assertEquals(
        try {
        final CountDownLatch block = new CountDownLatch(1);
        assertFalse(map.containsKey("size"));  
            // a virtual pool has no size to update; setThreadPool should skip it rather than fail on a cast
            final CountDownLatch done = new CountDownLatch(taskCount);
        // an unbounded pool renders no size, queue, or keep alive fields
        assertFalse(map.containsKey("queue_size"));
    public void testVirtualThreadPoolTracksActiveTasks() throws Exception {  
        ThreadPool threadPool = buildThreadPool();
        } finally {
        } finally {
public class ThreadPoolVirtualTests extends OpenSearchTestCase {
            assertTrue("both tasks should have started", started.await(10, TimeUnit.SECONDS));  
        assertTrue(new VirtualExecutorBuilder(POOL_NAME).getRegisteredSettings().isEmpty());
        throw new AssertionError("no stats for thread pool [" + POOL_NAME + "]");
            if (POOL_NAME.equals(candidate.getName())) {  
                latch.countDown();
            executor.execute(() -> {
            assertEquals(-1, stats.getLargest());
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));  
        }
                    } catch (InterruptedException e) {
                }
import org.opensearch.core.common.bytes.BytesReference;
            ExecutorService executor = threadPool.executor(POOL_NAME);
        try {  
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
                ThreadPoolStats.Stats stats = statsFor(threadPool);  
            }
            // submit() captures the exception in the Future rather than letting it reach the uncaught exception
            assertNotNull("virtual thread pool should be reported in thread pool info", info);
    }
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
    @SuppressWarnings("unchecked")
                        Thread.currentThread().interrupt();
import org.opensearch.core.xcontent.XContentBuilder;  
                assertEquals("a failed task must not leak the active count", 0, stats.getActive());  
        final CountDownLatch started = new CountDownLatch(2);  
                    break;
            assertEquals(0, stats.getActive());
                    info = candidate;  
                threadName.set(Thread.currentThread().getName());
    }  
        Settings settings = Settings.builder().put("node.name", "testnode").build();
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));  
    public void testVirtualThreadPoolRegistersNoSettings() {
            assertTrue("all tasks should have run", done.await(10, TimeUnit.SECONDS));
            assertEquals(-1, stats.getQueue());
        try {
    public void testRegisterVirtualThreadPool() throws Exception {
            });  
        } finally {
 * compatible open source license.
            // an unbounded pool reports no size, queue, or keep alive  
 */  
            assertEquals("neither blocked task should be completed", 0L, stats.getCompleted());
    }  
        map = (Map<String, Object>) map.get(POOL_NAME);  
            assertNull(info.getQueueSize());
import static org.hamcrest.Matchers.is;  
    }
        assertEquals("virtual", map.get("type"));
import org.opensearch.common.settings.Settings;
        } finally {
    }
}
            });  
            assertNotNull(executor);  
            });
        }  
                    started.countDown();
 * The OpenSearch Contributors require contributions made to  
        Map<String, Object> map = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
/*  
            assertEquals("both blocked tasks should be active", 2, stats.getActive());  
    public void testVirtualThreadPoolCountsTasksThatThrow() throws Exception {
                ThreadPoolStats.Stats stats = statsFor(threadPool);
        }
            ThreadPoolStats.Stats stats = statsFor(threadPool);
    }
            // the last task decrements active and increments completed in a finally block after countDown, so poll
        } finally {
import java.util.Map;  
        } finally {
            assertTrue("task should run on a virtual thread", isVirtual.get());
        builder.endObject();  
                });
        ThreadPool threadPool = buildThreadPool();  
                isVirtual.set(Thread.currentThread().isVirtual());  
        assertFalse(map.containsKey("keep_alive"));
        }  
import java.util.concurrent.Future;
                    .submit(() -> threadPool.getThreadContext().getHeader("test-header"))
            ExecutionException e = expectThrows(ExecutionException.class, () -> future.get(10, TimeUnit.SECONDS));
        assertFalse(map.containsKey("max"));  
            threadPool.getThreadContext().putHeader("test-header", "test-value");  
        try {
                assertEquals("a failed task should still count as completed", 1L, stats.getCompleted());
        for (ThreadPoolStats.Stats candidate : threadPool.stats()) {
import java.util.concurrent.atomic.AtomicReference;
        ThreadPool threadPool = buildThreadPool();  
import org.opensearch.common.xcontent.XContentHelper;
                assertEquals("all tasks should be counted as completed", taskCount, stats.getCompleted());
            final AtomicReference<String> threadName = new AtomicReference<>();
            for (int i = 0; i < 2; i++) {
        ThreadPool threadPool = buildThreadPool();  
                return candidate;
            assertEquals(-1, info.getMax());
        }  
        }  
package org.opensearch.threadpool;
                threadPool.executor(POOL_NAME).execute(() -> {  
                    .get(10, TimeUnit.SECONDS)
    }
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.ExecutionException;
            ThreadPool.Info info = null;  
            threadPool.setThreadPool(Settings.builder().put(POOL_NAME + ".size", 5).build());  
import java.util.concurrent.CountDownLatch;
                if (POOL_NAME.equals(candidate.getName())) {
 * this file be licensed under the Apache-2.0 license or a
            }  
        ThreadPool.Info info = new ThreadPool.Info(POOL_NAME, ThreadPool.ThreadPoolType.VIRTUAL);  
            // handler, which keeps the failure out of the test framework's uncaught exception check  
import java.util.concurrent.atomic.AtomicBoolean;  
            for (int i = 0; i < taskCount; i++) {
        try {
                "test-value",
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
    public void testVirtualThreadPoolPreservesThreadContext() throws Exception {  
    public void testVirtualThreadPoolStats() {
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
        try {
        } finally {
            final int taskCount = randomIntBetween(1, 20);  
                        block.await();  
    public void testVirtualThreadPoolTracksCompletedTasks() throws Exception {  
            Future<?> future = threadPool.executor(POOL_NAME).submit(() -> { throw new RuntimeException("expected"); });
            assertEquals(-1, stats.getThreads());  
            }
            );  
            assertThat(info.getThreadPoolType(), is(ThreadPool.ThreadPoolType.VIRTUAL));
        }  
            assertEquals(-1, info.getMin());
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
        ThreadPool threadPool = buildThreadPool();
        try {
            assertEquals(0L, stats.getCompleted());  
    public void testVirtualThreadPoolIsNotResizable() {
    private ThreadPool buildThreadPool() {  
            // task flow counters are tracked, and nothing has run yet
    }  
            final CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;
    }
            assertEquals("expected", e.getCause().getMessage());  
    }
import org.opensearch.core.xcontent.ToXContent;
            // a virtual thread-per-task pool has neither workers nor a queue, so these have no referent
            final AtomicBoolean isVirtual = new AtomicBoolean();  
 *
            }
                assertEquals("no tasks should remain in flight", 0, stats.getActive());
            assertEquals("opensearch[testnode][" + POOL_NAME + "]#0", threadName.get());  
                threadPool.executor(POOL_NAME).execute(done::countDown);  
            assertNull(info.getKeepAlive());  
    }
    public void testVirtualThreadPoolInfoXContent() throws Exception {
        ThreadPool threadPool = buildThreadPool();
        try {
import org.opensearch.common.xcontent.json.JsonXContent;  
            assertEquals(-1L, stats.getRejected());  
        assertFalse(map.containsKey("core"));
        }  
            ThreadPoolStats.Stats stats = statsFor(threadPool);
            // a task that throws still finishes, so it must not leak the active count
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
            for (ThreadPool.Info candidate : threadPool.info()) {
