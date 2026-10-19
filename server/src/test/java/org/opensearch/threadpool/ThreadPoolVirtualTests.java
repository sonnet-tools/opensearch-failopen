import java.util.concurrent.TimeUnit;
                assertEquals("all tasks should be counted as completed", taskCount, stats.getCompleted());
            ThreadPoolStats.Stats stats = statsFor(threadPool);
        try {
            assertTrue("both tasks should have started", started.await(10, TimeUnit.SECONDS));
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
            }
import java.util.Map;
        try {
            final CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.ExecutionException;
        ThreadPool threadPool = buildThreadPool();
        assertFalse(map.containsKey("keep_alive"));
        ThreadPool threadPool = buildThreadPool();
import java.util.concurrent.atomic.AtomicReference;
            }
import org.opensearch.common.xcontent.json.JsonXContent;
 * this file be licensed under the Apache-2.0 license or a
public class ThreadPoolVirtualTests extends OpenSearchTestCase {
import org.opensearch.core.common.bytes.BytesReference;
    }
            ExecutorService executor = threadPool.executor(POOL_NAME);
        }
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
    private static ThreadPoolStats.Stats statsFor(ThreadPool threadPool) {
            threadPool.getThreadContext().putHeader("test-header", "test-value");
        }
        } finally {
            });
            );
                    info = candidate;
        // an unbounded pool renders no size, queue, or keep alive fields
        ThreadPool threadPool = buildThreadPool();
    public void testVirtualThreadPoolCountsTasksThatThrow() throws Exception {
        try {
        info.toXContent(builder, ToXContent.EMPTY_PARAMS);
        } finally {
    }
            assertEquals(-1L, stats.getRejected());
            // a task that throws still finishes, so it must not leak the active count
            // submit() captures the exception in the Future rather than letting it reach the uncaught exception
        Map<String, Object> map = XContentHelper.convertToMap(BytesReference.bytes(builder), false, builder.contentType()).v2();
import java.util.concurrent.CountDownLatch;
            assertEquals("opensearch[testnode][" + POOL_NAME + "]#0", threadName.get());
                    break;
        ThreadPool threadPool = buildThreadPool();
                isVirtual.set(Thread.currentThread().isVirtual());
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
        Settings settings = Settings.builder().put("node.name", "testnode").build();
            for (int i = 0; i < taskCount; i++) {
            ExecutionException e = expectThrows(ExecutionException.class, () -> future.get(10, TimeUnit.SECONDS));
import org.opensearch.test.OpenSearchTestCase;
        ThreadPool threadPool = buildThreadPool();
        for (ThreadPoolStats.Stats candidate : threadPool.stats()) {
            // handler, which keeps the failure out of the test framework's uncaught exception check
                ThreadPoolStats.Stats stats = statsFor(threadPool);
        try {
            // the last task decrements active and increments completed in a finally block after countDown, so poll
            assertEquals(-1, stats.getThreads());
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
    }
import java.util.concurrent.Future;
            });
            assertThat(info.getThreadPoolType(), is(ThreadPool.ThreadPoolType.VIRTUAL));
                });
            assertEquals("both blocked tasks should be active", 2, stats.getActive());
        assertEquals("virtual", map.get("type"));
                    .get(10, TimeUnit.SECONDS)
        map = (Map<String, Object>) map.get(POOL_NAME);
            for (ThreadPool.Info candidate : threadPool.info()) {
                        Thread.currentThread().interrupt();
            final CountDownLatch done = new CountDownLatch(taskCount);
            assertEquals("expected", e.getCause().getMessage());
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
import static org.hamcrest.Matchers.is;
                    .submit(() -> threadPool.getThreadContext().getHeader("test-header"))
        } finally {
                }
    public void testVirtualThreadPoolInfoXContent() throws Exception {
        } finally {
        }
        }
        }
    }
                ThreadPoolStats.Stats stats = statsFor(threadPool);
}
        } finally {
        builder.endObject();
            assertEquals(-1, info.getMin());
    @SuppressWarnings("unchecked")
            // a virtual pool has no size to update; setThreadPool should skip it rather than fail on a cast
    public void testVirtualThreadPoolInfo() {
import org.opensearch.core.xcontent.ToXContent;
        } finally {
            executor.execute(() -> {
import java.util.concurrent.atomic.AtomicBoolean;
            assertTrue("task should run on a virtual thread", isVirtual.get());
            ThreadPoolStats.Stats stats = statsFor(threadPool);
/*
    private ThreadPool buildThreadPool() {
    public void testVirtualThreadPoolTracksCompletedTasks() throws Exception {
        assertFalse(map.containsKey("queue_size"));
                "test-value",
            assertNull(info.getKeepAlive());
                assertEquals("a failed task should still count as completed", 1L, stats.getCompleted());
    public void testRegisterVirtualThreadPool() throws Exception {
            assertEquals(0, stats.getActive());
    }
        final CountDownLatch block = new CountDownLatch(1);
            assertEquals(-1, info.getMax());
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
            assertEquals(-1, stats.getQueue());
                threadPool.executor(POOL_NAME).execute(done::countDown);
            assertEquals("neither blocked task should be completed", 0L, stats.getCompleted());
    }
            assertTrue(latch.await(10, TimeUnit.SECONDS));
        }
            final int taskCount = randomIntBetween(1, 20);
    public void testVirtualThreadPoolPreservesThreadContext() throws Exception {
            // task flow counters are tracked, and nothing has run yet
            assertTrue("all tasks should have run", done.await(10, TimeUnit.SECONDS));
        }
    private static final String POOL_NAME = "test_virtual";
    public void testVirtualThreadPoolIsNotResizable() {
            assertEquals(
            for (int i = 0; i < 2; i++) {
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
                        block.await();
 */
        ThreadPool.Info info = new ThreadPool.Info(POOL_NAME, ThreadPool.ThreadPoolType.VIRTUAL);
                    } catch (InterruptedException e) {
                if (POOL_NAME.equals(candidate.getName())) {
            final AtomicReference<String> threadName = new AtomicReference<>();
package org.opensearch.threadpool;
            if (POOL_NAME.equals(candidate.getName())) {
                assertEquals("no tasks should remain in flight", 0, stats.getActive());
            assertBusy(() -> {
            assertTrue(ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS));
        assertTrue(new VirtualExecutorBuilder(POOL_NAME).getRegisteredSettings().isEmpty());
        try {
            block.countDown();
        ThreadPool threadPool = buildThreadPool();
import org.opensearch.core.xcontent.XContentBuilder;
        }
                return candidate;
            ThreadPool.Info info = null;
                threadPool.executor(POOL_NAME).execute(() -> {
                    }
                threadPool.executor(POOL_NAME)
            assertEquals(0L, stats.getCompleted());
        final CountDownLatch started = new CountDownLatch(2);
    }
                assertEquals("a failed task must not leak the active count", 0, stats.getActive());
            assertNull(info.getQueueSize());
            // a virtual thread-per-task pool has neither workers nor a queue, so these have no referent
        return new ThreadPool(settings, new VirtualExecutorBuilder(POOL_NAME));
            threadPool.setThreadPool(Settings.builder().put(POOL_NAME + ".size", 5).build());
    }
        ThreadPool threadPool = buildThreadPool();
 *
        ThreadPool threadPool = buildThreadPool();
        assertFalse(map.containsKey("size"));
import org.opensearch.common.xcontent.XContentHelper;
        try {
        } finally {
        throw new AssertionError("no stats for thread pool [" + POOL_NAME + "]");
    public void testVirtualThreadPoolRegistersNoSettings() {
            assertNotNull(executor);
            // an unbounded pool reports no size, queue, or keep alive
        try {
import org.opensearch.common.settings.Settings;
            });
                    try {
            assertEquals(-1, stats.getLargest());
                latch.countDown();
    public void testVirtualThreadPoolStats() {
        XContentBuilder builder = JsonXContent.contentBuilder().startObject();
        assertFalse(map.containsKey("max"));
    public void testVirtualThreadPoolTracksActiveTasks() throws Exception {
            Future<?> future = threadPool.executor(POOL_NAME).submit(() -> { throw new RuntimeException("expected"); });
            final AtomicBoolean isVirtual = new AtomicBoolean();
            }
import java.util.concurrent.ExecutorService;
 * SPDX-License-Identifier: Apache-2.0
    }
        try {
                threadName.set(Thread.currentThread().getName());
    }
            }
        } finally {
        }
    }
            assertNotNull("virtual thread pool should be reported in thread pool info", info);
        assertFalse(map.containsKey("core"));
            assertBusy(() -> {
                    started.countDown();
    }
