    private AnalyticsShardTask createAndTrackTask(long id) {
        FilterTreeCallbacks.register(TEST_CONTEXT_ID, new MockHandle(new long[] { 0xCAFEL }), createTracker(task.getId()));
        super.tearDown();
    /**
import java.util.concurrent.TimeUnit;
        CountDownLatch done = new CountDownLatch(queryCount);
            @Override
        }
        );
        CountDownLatch done = new CountDownLatch(1);
        FilterTreeCallbacks.unregister(unregisteredCtx);
                "AssertionError should mention the offending contextId. Got: " + failure.getMessage(),
     * an intervening unregister trips the double-register assert. This catches leaked
            contextIds[q] = tasks[q].getId();
                    done.countDown();
    @Override
                } finally {
                            long words = FilterTreeCallbacks.collectDocs(ctxId, ck, 0, 64, buf, 1);
        private int nextKey = 1;
            assertTrue("Thread " + t.getName() + " (id=" + t.threadId() + ") should be tracked", stats.containsKey(t.threadId()));
    }
import org.opensearch.common.settings.ClusterSettings;
        AssertionError failure = expectThrows(AssertionError.class, () -> FilterTreeCallbacks.createProvider(unregisteredCtx, 1));
            "transport",
                failure.getMessage().contains("contextId=" + ctx)
                    done.countDown();
        // Check no assertion errors from any query thread
                stats.containsKey(threads[q].threadId())
        @Override
    private DelegationThreadTracker createTracker(long taskId) {
    private static final long TEST_CONTEXT_ID = 0L;
            FilterTreeCallbacks.unregister(contextIds[q]);
        foreignThread.start();
import java.util.concurrent.atomic.AtomicReference;
        FilterTreeCallbacks.unregister(TEST_CONTEXT_ID);
        @Override
            return nextKey++;
                        assertTrue("createCollector should succeed for query " + queryIdx, ck >= 0);
    }
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
 *
     *
                service.taskExecutionFinishedOnThread(taskId, threadId);
     * releaseCollector, releaseProvider) on a foreign thread.
            TaskId.EMPTY_TASK_ID,
        assertTrue(done.await(10, TimeUnit.SECONDS));
                return threadId;
        FilterTreeCallbacks.register(TEST_CONTEXT_ID, new MockHandle(new long[] { 0xFFL }), createTracker(task.getId()));
            done.countDown();
        }
        Map<Long, List<ThreadResourceInfo>> stats = task.getResourceStats();
        return new DelegationThreadTracker() {
            return nextKey++;
                FilterTreeCallbacks.collectDocs(TEST_CONTEXT_ID, ck, 0, 64, buf, 1);
        }
     * Lifecycle assertion: registering a second binding for the same contextId without
                    errors[queryIdx] = e;
        public int createProvider(int annotationId) {
                        FilterTreeCallbacks.releaseProvider(ctxId, pk);
     * Tests the full production wiring: register handle + tracker, then
                throw new AssertionError("Query " + q + " failed", errors[q]);
        int queryCount = 4;
                } catch (Exception e) {
    public void setUp() throws Exception {
     * releases), so it should fail loudly in tests; production (no -ea) silently
                } catch (Exception e) {
        for (int q = 0; q < queryCount; q++) {
        };
            trackingService.stopTracking(tasks[q]);
     * binding throws AssertionError when -ea is on. Under the refcounted lifecycle
        Thread foreignThread = new Thread(() -> {
     */
     * handles and trackers, then fire upcalls concurrently on shared threads.
 */
import java.util.concurrent.CountDownLatch;
        TaskResourceTrackingService service = trackingService;
        super.setUp();
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
 */
import org.opensearch.common.settings.Settings;
import java.lang.foreign.ValueLayout;
        FilterTreeCallbacks.unregister(TEST_CONTEXT_ID);
                MemorySegment buf = arena.allocate(Long.BYTES);
        public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {
     * all five callback methods (createProvider, createCollector, collectDocs,
 * compatible open source license.
import org.opensearch.analytics.spi.FilterDelegationHandle;
        assertTrue(done.await(5, TimeUnit.SECONDS));
                        int ck = FilterTreeCallbacks.createCollector(ctxId, pk, 0, 0, 64);
     */
                } finally {
            threads[q].start();
        }, "test-tokio-worker");
                    barrier.await(5, TimeUnit.SECONDS);
        long[] contextIds = new long[queryCount];
import java.util.Map;
    }
     * Without per-query contextId isolation, this test fails because:
                            long expected = 0xABCD_0000L | queryIdx;
                        }
            Map<Long, List<ThreadResourceInfo>> stats = tasks[q].getResourceStats();
import org.opensearch.threadpool.TestThreadPool;
                    FilterTreeCallbacks.releaseCollector(TEST_CONTEXT_ID, ck);
                        assertTrue("createProvider should succeed for query " + queryIdx, pk >= 0);
     */
                () -> FilterTreeCallbacks.register(ctx, new MockHandle(new long[] { 2L }), null)
                AssertionError.class,
        for (int q = 0; q < queryCount; q++) {
    }
            "indices:data/read/analytics/fragment",
                    errors[queryIdx] = new AssertionError("Unexpected exception in query " + queryIdx, e);
                    int ck = FilterTreeCallbacks.createCollector(TEST_CONTEXT_ID, pk, 0, 0, 64);
     */
    public void tearDown() throws Exception {
        // Verify each task was tracked on its own thread (not cross-contaminated)
     * - TRACKER race: trackEnd routes to the wrong task -> IllegalStateException -> AssertionError
     * Lifecycle assertion: invoking an upcall on a contextId that has no registered
        trackingService = new TaskResourceTrackingService(
        }
     * Tests that multiple concurrent threads calling collectDocs are all tracked.
    /**
                    FilterTreeCallbacks.releaseProvider(TEST_CONTEXT_ID, pk);
        AnalyticsShardTask task = new AnalyticsShardTask(
                out.setAtIndex(ValueLayout.JAVA_LONG, i, words[i]);
    /**
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
            tasks[q] = createAndTrackTask(100 + q);
        MockHandle[] handles = new MockHandle[queryCount];
                    throw new RuntimeException(e);
            AssertionError failure = expectThrows(
                            long value = buf.getAtIndex(ValueLayout.JAVA_LONG, 0);
     * - HANDLE race: collectDocs routes to the wrong handle -> returns -1
                        FilterTreeCallbacks.collectDocs(TEST_CONTEXT_ID, ck, 0, 64, buf, 1);
    private TaskResourceTrackingService trackingService;
    }
                        try (Arena arena = Arena.ofConfined()) {
        @Override
        trackingService.stopTracking(task);
            final int queryIdx = q;
            }, "concurrent-worker-" + i);
        MockHandle(long[] words) {
import java.util.HashMap;
            return n;
                } catch (AssertionError e) {
        @Override
        }
            threads[q] = new Thread(() -> {
                    barrier.await(5, TimeUnit.SECONDS);
            "test-task-" + id,
            int n = Math.min(words.length, (int) (out.byteSize() / Long.BYTES));
     * bindings (missing unregister) and accidental sharing of contextIds across queries.
        }
            assertTrue(
    @Override
                        FilterTreeCallbacks.releaseCollector(ctxId, ck);
import java.util.concurrent.CyclicBarrier;
        FilterTreeCallbacks.register(ctx, new MockHandle(new long[] { 1L }), null);
 * Tests verifying that FilterTreeCallbacks correctly attributes delegation
        AnalyticsShardTask task = createAndTrackTask(3);
package org.opensearch.be.datafusion.indexfilter;
            );
        AnalyticsShardTask task = createAndTrackTask(1);
                    for (int i = 0; i < upcallsPerQuery; i++) {
            }
 * The OpenSearch Contributors require contributions made to
        Thread[] threads = new Thread[queryCount];
import org.opensearch.core.tasks.TaskId;
            new HashMap<>()
            @Override
        // Clear any leftover bindings from a previous test.
        );
import java.lang.foreign.MemorySegment;
        for (int q = 0; q < queryCount; q++) {
                try {
    public void testConcurrentThreadsAllTracked() throws Exception {
/**
                try {
            threads[i].start();
        );
            public void trackEnd(long threadId) {
            threadPool
                long threadId = Thread.currentThread().threadId();
    public void testDoubleRegisterAsserts() throws Exception {
            }
 * SPDX-License-Identifier: Apache-2.0
        AssertionError[] errors = new AssertionError[queryCount];
            FilterTreeCallbacks.register(contextIds[q], handles[q], createTracker(tasks[q].getId()));
        public void releaseCollector(int collectorKey) {}
        assertTrue("All queries should complete within timeout", done.await(15, TimeUnit.SECONDS));
        @Override
                        MemorySegment buf = arena.allocate(Long.BYTES);
    private static final class MockHandle implements FilterDelegationHandle {
        public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
                            assertTrue("collectDocs should succeed for query " + queryIdx + " (got " + words + ")", words >= 0);
 * callback work to the AnalyticsShardTask via TaskResourceTrackingService.
     */
            FilterTreeCallbacks.releaseProvider(TEST_CONTEXT_ID, pk);
     * this is a genuine bug signal (bindings survive until the last native handle
import java.lang.foreign.Arena;
    }
import org.opensearch.tasks.TaskResourceTrackingService;
            try (Arena arena = Arena.ofConfined()) {
 *
        }
            int ck = FilterTreeCallbacks.createCollector(TEST_CONTEXT_ID, pk, 0, 0, 64);
            }
     * Simulates the production concurrency bug: multiple queries register different
import org.opensearch.analytics.spi.DelegationThreadTracker;
                            MemorySegment buf = arena.allocate(Long.BYTES);
            "AssertionError should mention the offending contextId. Got: " + failure.getMessage(),
import org.opensearch.threadpool.ThreadPool;
                    }
     * returns -1 — the upcall's null check is the production safety net.
        Map<Long, List<ThreadResourceInfo>> stats = task.getResourceStats();
                        int pk = FilterTreeCallbacks.createProvider(ctxId, 1);
            FilterTreeCallbacks.releaseCollector(TEST_CONTEXT_ID, ck);
    }
    /**
}
import org.opensearch.test.OpenSearchTestCase;
        long ctx = 1234L;
        try {
        trackingService.setTaskResourceTrackingEnabled(true);
        }
 * {@link FilterTreeCallbacks#unregister} to exercise the per-query binding path.
        terminate(threadPool);
        trackingService.startTracking(task);
            assertTrue(
public class DelegationTaskTrackingTests extends OpenSearchTestCase {
                }
        assertTrue(
        assertTrue(task.supportsResourceTracking());
                    int pk = FilterTreeCallbacks.createProvider(TEST_CONTEXT_ID, 1);
        int upcallsPerQuery = 10;
            }
        trackingService.stopTracking(task);
                "Task " + tasks[q].getId() + " should have tracking entries on thread " + threads[q].threadId(),
        public void releaseProvider(int providerKey) {}
        FilterTreeCallbacks.unregister(TEST_CONTEXT_ID);
        // Sanity: nothing registered for this contextId.
        AnalyticsShardTask[] tasks = new AnalyticsShardTask[queryCount];
        for (int q = 0; q < queryCount; q++) {
                }
        for (int i = 0; i < threadCount; i++) {
        Thread[] threads = new Thread[threadCount];
            this.words = words;
            );
    private ThreadPool threadPool;
        for (int q = 0; q < queryCount; q++) {
            threads[i] = new Thread(() -> {
        int threadCount = 4;
        private final long[] words;
        }
        return task;
    public void testUnregisteredContextIdAssertsInTests() throws Exception {
    }
            for (int i = 0; i < n; i++)
            final long ctxId = contextIds[q];
import java.util.List;
    public void testAllCallbackMethodsTrackedOnForeignThread() throws Exception {
        CyclicBarrier barrier = new CyclicBarrier(queryCount);
    }
 * <p>Tests use contextId=0 directly via {@link FilterTreeCallbacks#register} /
        }
            );
            if (errors[q] != null) {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        threadPool = new TestThreadPool(getTestName(), new AtomicReference<>());
        }
        long unregisteredCtx = 9999L;
        assertTrue("Foreign thread should be tracked. Got threads: " + stats.keySet(), stats.containsKey(foreignThread.threadId()));
            id,
            }, "concurrent-query-" + q);
/*
                service.taskExecutionStartedOnThread(taskId, threadId);
            failure.getMessage().contains("contextId=" + unregisteredCtx)
        public void close() {}
            public long trackStart() {
    /**
                    }
        @Override
        CountDownLatch done = new CountDownLatch(threadCount);
                    try (Arena arena = Arena.ofConfined()) {
            handles[q] = new MockHandle(new long[] { 0xABCD_0000L | q });
     * Verifies the thread is tracked against the task.
        } finally {
        }
            Settings.EMPTY,
            FilterTreeCallbacks.unregister(ctx);
 * this file be licensed under the Apache-2.0 license or a
        FilterTreeCallbacks.unregister(TEST_CONTEXT_ID);
    }
    public void testConcurrentQueriesIsolated() throws Exception {
        for (Thread t : threads) {
                            assertEquals("collectDocs should return this query's data, not another query's", expected, value);
            int pk = FilterTreeCallbacks.createProvider(TEST_CONTEXT_ID, 1);
