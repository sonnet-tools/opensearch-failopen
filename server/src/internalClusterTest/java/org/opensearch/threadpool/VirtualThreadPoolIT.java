            assertEquals("no tasks should remain in flight", 0, stats.getActive());
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicBoolean;  
        return List.of(TestPlugin.class);  
            latch.countDown();  
        assertEquals(-1, stats.getQueue());  
        assertEquals(-1, stats.getThreads());
            threadContext.putHeader("test-header", "test-value");  
public class VirtualThreadPoolIT extends OpenSearchSingleNodeTestCase {
        assertTrue(  
        final AtomicBoolean isVirtual = new AtomicBoolean();
                stats = candidate;
        for (ThreadPoolStats.Stats candidate : threadPool.stats()) {  
        assertTrue("all tasks should have run", done.await(10, TimeUnit.SECONDS));
        // Tasks must run on virtual threads named with the standard opensearch[node][pool]#N convention
        assertTrue("active must not be negative", stats.getActive() >= 0);
        @Override  
    protected Collection<Class<? extends Plugin>> getPlugins() {
        final AtomicReference<String> threadName = new AtomicReference<>();
        final CountDownLatch done = new CountDownLatch(taskCount);
        final CountDownLatch latch = new CountDownLatch(1);  
 */  
            threadName.set(Thread.currentThread().getName());
                return candidate;  
    public static class TestPlugin extends Plugin {
import org.opensearch.plugins.Plugin;
    }
            }
        // task flow counters are tracked, so they are never negative  
        assertEquals("an unbounded pool reports no max", -1, info.getMax());
 * Single-node IT that defines an inline plugin to register a virtual thread-per-task executor ("vt_pool")
        assertNotNull("ThreadPool.Info for " + POOL_NAME + " should exist", info);
    private static ThreadPoolStats.Stats statsFor(ThreadPool threadPool) {  
        assertNull("an unbounded pool has no keep alive", info.getKeepAlive());  
            }
        assertNotNull("virtual pool should be listed in thread pool stats", stats);  
        final String expectedPrefix = OpenSearchExecutors.threadName(node().settings(), POOL_NAME) + "#";
package org.opensearch.threadpool;
        assertTrue("task should have run", latch.await(10, TimeUnit.SECONDS));
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
        assertNotNull(POOL_NAME + " executor should be registered by the test plugin", executor);  
                threadPool.executor(POOL_NAME).submit(() -> threadContext.getHeader("test-header")).get(10, TimeUnit.SECONDS)  
            threadName.get().startsWith(expectedPrefix)
import java.util.concurrent.TimeUnit;
    public void testVirtualThreadPoolPreservesThreadContext() throws Exception {
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    }
        public List<ExecutorBuilder<?>> getExecutorBuilders(final Settings settings) {
    }
        // stash the context so the header set below does not leak into other tests
        final int taskCount = randomIntBetween(1, 10);  
        assertEquals("type must be VIRTUAL", ThreadPool.ThreadPoolType.VIRTUAL, info.getThreadPoolType());  
        ExecutorService executor = threadPool.executor(POOL_NAME);
    public void testVirtualThreadPoolExists() throws Exception {  
        ThreadPoolStats.Stats stats = null;
        }
            "thread name [" + threadName.get() + "] should start with [" + expectedPrefix + "]",
        ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);  
        }
        // ThreadPool.Info should report VIRTUAL with no size, queue, or keep alive
        ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);  
                break;  
        // a virtual thread-per-task pool has neither workers nor a queue, so these have no referent
    private static final String POOL_NAME = "vt_pool";  
        assertTrue("task should run on a virtual thread", isVirtual.get());  
import java.util.concurrent.ExecutorService;
        }
        ThreadPool.Info info = null;
        assertEquals(POOL_NAME, info.getName());
        final long completedBefore = statsFor(threadPool).getCompleted();
 * this file be licensed under the Apache-2.0 license or a
 */  
        assertNull("an unbounded pool has no queue", info.getQueueSize());
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    }
import java.util.Collection;
        });  
    public void testVirtualThreadPoolReportsTaskFlowStats() throws Exception {
        final ThreadContext threadContext = threadPool.getThreadContext();  
            threadPool.executor(POOL_NAME).execute(done::countDown);  
        for (ThreadPool.Info candidate : threadPool.info()) {  
            assertEquals(
            );
import java.util.concurrent.CountDownLatch;  
        try (ThreadContext.StoredContext ignored = threadContext.stashContext()) {
}
        });
        ThreadPool.Info info = threadPool.info(POOL_NAME);  
        throw new AssertionError("no stats for thread pool [" + POOL_NAME + "]");  
        for (ThreadPoolStats.Stats candidate : threadPool.stats()) {
    }  
            if (POOL_NAME.equals(candidate.getName())) {
        executor.execute(() -> {  
     */
        // Load the inline plugin into the single-node cluster for this test
     * Inline test plugin that registers a virtual thread-per-task executor named "vt_pool".  
                break;  
        }
            if (POOL_NAME.equals(candidate.getName())) {
        ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);
        // the counters are updated in a finally block after the task body, so poll rather than asserting immediately
 * compatible open source license.
        assertBusy(() -> {
import org.opensearch.common.util.concurrent.ThreadContext;  
        );  
        assertNotNull("virtual pool should be listed in thread pool info", info);  
            if (POOL_NAME.equals(candidate.getName())) {
                info = candidate;
 *
import org.opensearch.common.settings.Settings;
        for (int i = 0; i < taskCount; i++) {
    @Override  
        assertEquals(-1, stats.getLargest());
    public void testVirtualThreadPoolAppearsInNodeStatsAndInfo() {
/*  
            return List.of(new VirtualExecutorBuilder(POOL_NAME));
            assertEquals("completed should advance by the task count", completedBefore + taskCount, stats.getCompleted());
                "test-value",
    }  
            ThreadPoolStats.Stats stats = statsFor(threadPool);  
        ThreadPool threadPool = getInstanceFromNode(ThreadPool.class);
        }
            isVirtual.set(Thread.currentThread().isVirtual());
        }  
 * and verifies it is available on the node and runs tasks on virtual threads.
 * The OpenSearch Contributors require contributions made to  
            }
        assertEquals(-1L, stats.getRejected());
        assertTrue("completed must not be negative", stats.getCompleted() >= 0);
        assertEquals("an unbounded pool reports no min", -1, info.getMin());
/**  
    }
    /**
