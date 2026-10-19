                        }  
                            long value = buf.getAtIndex(ValueLayout.JAVA_LONG, 0);  
        return task;  
        }  
     * Verifies the thread is tracked against the task.  
}
            final long ctxId = contextIds[q];
        FilterTreeCallbacks.unregister(TEST_CONTEXT_ID);
        for (Thread t : threads) {  
            done.countDown();
        long[] contextIds = new long[queryCount];  
        @Override
        @Override
        @Override
        Map<Long, List<ThreadResourceInfo>> stats = task.getResourceStats();
        };
    private DelegationThreadTracker createTracker(long taskId) {
        public int createCollector(int providerKey, long writerGeneration, int minDoc, int maxDoc) {
                try {  
        }
                            long words = FilterTreeCallbacks.collectDocs(ctxId, ck, 0, 64, buf, 1);  
        TaskResourceTrackingService service = trackingService;  
        assertTrue("All queries should complete within timeout", done.await(15, TimeUnit.SECONDS));
        for (int q = 0; q < queryCount; q++) {  
        terminate(threadPool);
                            MemorySegment buf = arena.allocate(Long.BYTES);
     */
                failure.getMessage().contains("contextId=" + ctx)
     * Tests the full production wiring: register handle + tracker, then  
                        int pk = FilterTreeCallbacks.createProvider(ctxId, 1);
        @Override
import org.opensearch.common.settings.ClusterSettings;
                service.taskExecutionStartedOnThread(taskId, threadId);
    }  
     * releaseCollector, releaseProvider) on a foreign thread.
            FilterTreeCallbacks.unregister(contextIds[q]);
        }
            }, "concurrent-worker-" + i);  
        FilterTreeCallbacks.unregister(TEST_CONTEXT_ID);
     * binding throws AssertionError when -ea is on. Under the refcounted lifecycle
            AssertionError failure = expectThrows(
                long threadId = Thread.currentThread().threadId();
        MockHandle[] handles = new MockHandle[queryCount];
            if (errors[q] != null) {
import java.util.concurrent.atomic.AtomicReference;
 * callback work to the AnalyticsShardTask via TaskResourceTrackingService.
        int queryCount = 4;
        @Override
import java.lang.foreign.Arena;
                FilterTreeCallbacks.collectDocs(TEST_CONTEXT_ID, ck, 0, 64, buf, 1);
        super.tearDown();
 *  
    }
            failure.getMessage().contains("contextId=" + unregisteredCtx)
        }
                return threadId;  
                "AssertionError should mention the offending contextId. Got: " + failure.getMessage(),  
                            assertEquals("collectDocs should return this query's data, not another query's", expected, value);
            "test-task-" + id,  
        FilterTreeCallbacks.register(TEST_CONTEXT_ID, new MockHandle(new long[] { 0xCAFEL }), createTracker(task.getId()));
    }
        public void releaseCollector(int collectorKey) {}  
import java.util.List;
        trackingService.startTracking(task);
        AnalyticsShardTask task = createAndTrackTask(1);  
            FilterTreeCallbacks.releaseCollector(TEST_CONTEXT_ID, ck);  
        trackingService = new TaskResourceTrackingService(  
    @Override
                    done.countDown();
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Foreign thread should be tracked. Got threads: " + stats.keySet(), stats.containsKey(foreignThread.threadId()));
 */  
                }
            assertTrue(
        CountDownLatch done = new CountDownLatch(threadCount);
    }  
            return nextKey++;
            FilterTreeCallbacks.releaseProvider(TEST_CONTEXT_ID, pk);
                } finally {  
        try {  
                out.setAtIndex(ValueLayout.JAVA_LONG, i, words[i]);
            int ck = FilterTreeCallbacks.createCollector(TEST_CONTEXT_ID, pk, 0, 0, 64);
                throw new AssertionError("Query " + q + " failed", errors[q]);
            threads[i] = new Thread(() -> {
 * {@link FilterTreeCallbacks#unregister} to exercise the per-query binding path.
        private final long[] words;
        Thread[] threads = new Thread[threadCount];
                        MemorySegment buf = arena.allocate(Long.BYTES);
            threads[q].start();
        for (int q = 0; q < queryCount; q++) {  
        foreignThread.start();
import org.opensearch.common.settings.Settings;
            threadPool  
        }  
        );
import org.opensearch.analytics.exec.task.AnalyticsShardTask;
            threads[i].start();
                        FilterTreeCallbacks.releaseProvider(ctxId, pk);  
            FilterTreeCallbacks.unregister(ctx);
        assertTrue(done.await(5, TimeUnit.SECONDS));
        CountDownLatch done = new CountDownLatch(1);
    private static final class MockHandle implements FilterDelegationHandle {  
        AssertionError[] errors = new AssertionError[queryCount];  
                        assertTrue("createCollector should succeed for query " + queryIdx, ck >= 0);
        FilterTreeCallbacks.unregister(TEST_CONTEXT_ID);
            FilterTreeCallbacks.register(contextIds[q], handles[q], createTracker(tasks[q].getId()));
    /**
                    }
        FilterTreeCallbacks.register(ctx, new MockHandle(new long[] { 1L }), null);
        long unregisteredCtx = 9999L;
            trackingService.stopTracking(tasks[q]);
        assertTrue(done.await(10, TimeUnit.SECONDS));  
import org.opensearch.test.OpenSearchTestCase;  
     * Tests that multiple concurrent threads calling collectDocs are all tracked.
        }
    @Override
import java.util.concurrent.CountDownLatch;
        // Check no assertion errors from any query thread
     * - HANDLE race: collectDocs routes to the wrong handle -> returns -1
            Map<Long, List<ThreadResourceInfo>> stats = tasks[q].getResourceStats();
    private static final long TEST_CONTEXT_ID = 0L;  
                    barrier.await(5, TimeUnit.SECONDS);
 * <p>Tests use contextId=0 directly via {@link FilterTreeCallbacks#register} /
        FilterTreeCallbacks.unregister(TEST_CONTEXT_ID);  
 */  
     * - TRACKER race: trackEnd routes to the wrong task -> IllegalStateException -> AssertionError
        }
        @Override  
                    for (int i = 0; i < upcallsPerQuery; i++) {  
            }, "concurrent-query-" + q);  
                    errors[queryIdx] = new AssertionError("Unexpected exception in query " + queryIdx, e);
 *
            threads[q] = new Thread(() -> {  
        assertTrue(  
import org.opensearch.analytics.spi.FilterDelegationHandle;  
        int upcallsPerQuery = 10;  
    }
        // Sanity: nothing registered for this contextId.
        CountDownLatch done = new CountDownLatch(queryCount);
                    done.countDown();
                } catch (Exception e) {
        long ctx = 1234L;
     * returns -1 — the upcall's null check is the production safety net.
                    FilterTreeCallbacks.releaseCollector(TEST_CONTEXT_ID, ck);
     */
        }
        AnalyticsShardTask task = new AnalyticsShardTask(
     *
                }
package org.opensearch.be.datafusion.indexfilter;
 * compatible open source license.
            public void trackEnd(long threadId) {
        trackingService.stopTracking(task);  
    public void testUnregisteredContextIdAssertsInTests() throws Exception {  
/*  
            id,  
            }  
            int pk = FilterTreeCallbacks.createProvider(TEST_CONTEXT_ID, 1);  
            );  
                            long expected = 0xABCD_0000L | queryIdx;
            );
            assertTrue(  
    public void testConcurrentThreadsAllTracked() throws Exception {  
import java.util.concurrent.TimeUnit;  
            return n;
        }  
     */
                    errors[queryIdx] = e;  
            }  
import org.opensearch.tasks.TaskResourceTrackingService;
    /**
    public void testDoubleRegisterAsserts() throws Exception {  
    private TaskResourceTrackingService trackingService;  
        }
                    try (Arena arena = Arena.ofConfined()) {
    private ThreadPool threadPool;
            "AssertionError should mention the offending contextId. Got: " + failure.getMessage(),
                    }
                MemorySegment buf = arena.allocate(Long.BYTES);  
import java.util.Map;  
            }
     * releases), so it should fail loudly in tests; production (no -ea) silently  
    /**
    }
     * Simulates the production concurrency bug: multiple queries register different  
                        FilterTreeCallbacks.releaseCollector(ctxId, ck);
            tasks[q] = createAndTrackTask(100 + q);
            int n = Math.min(words.length, (int) (out.byteSize() / Long.BYTES));
import java.util.concurrent.CyclicBarrier;
        assertTrue(task.supportsResourceTracking());
        } finally {  
        for (int q = 0; q < queryCount; q++) {  
                service.taskExecutionFinishedOnThread(taskId, threadId);
        public void close() {}  
            assertTrue("Thread " + t.getName() + " (id=" + t.threadId() + ") should be tracked", stats.containsKey(t.threadId()));
                    int pk = FilterTreeCallbacks.createProvider(TEST_CONTEXT_ID, 1);
        Thread[] threads = new Thread[queryCount];
    public void testAllCallbackMethodsTrackedOnForeignThread() throws Exception {
        );  
                        FilterTreeCallbacks.collectDocs(TEST_CONTEXT_ID, ck, 0, 64, buf, 1);  
                try {
    }  
        int threadCount = 4;
            Settings.EMPTY,
        }
        return new DelegationThreadTracker() {
public class DelegationTaskTrackingTests extends OpenSearchTestCase {
        AnalyticsShardTask task = createAndTrackTask(3);
                    FilterTreeCallbacks.releaseProvider(TEST_CONTEXT_ID, pk);  
/**  
import org.opensearch.core.tasks.TaskId;  
            handles[q] = new MockHandle(new long[] { 0xABCD_0000L | q });  
            new HashMap<>()
    private AnalyticsShardTask createAndTrackTask(long id) {
    /**
    public void tearDown() throws Exception {
                } catch (Exception e) {
            "indices:data/read/analytics/fragment",
        public int createProvider(int annotationId) {  
        for (int q = 0; q < queryCount; q++) {
                    int ck = FilterTreeCallbacks.createCollector(TEST_CONTEXT_ID, pk, 0, 0, 64);  
import org.opensearch.analytics.spi.DelegationThreadTracker;
import org.opensearch.threadpool.TestThreadPool;
    public void setUp() throws Exception {  
import java.util.HashMap;
                        assertTrue("createProvider should succeed for query " + queryIdx, pk >= 0);
        for (int q = 0; q < queryCount; q++) {  
            }
            try (Arena arena = Arena.ofConfined()) {
    /**  
        threadPool = new TestThreadPool(getTestName(), new AtomicReference<>());
        }
    }
 * Tests verifying that FilterTreeCallbacks correctly attributes delegation
            public long trackStart() {  
     * an intervening unregister trips the double-register assert. This catches leaked  
        // Verify each task was tracked on its own thread (not cross-contaminated)  
            contextIds[q] = tasks[q].getId();
                    throw new RuntimeException(e);
        trackingService.stopTracking(task);
     * Lifecycle assertion: registering a second binding for the same contextId without
                } finally {  
    }  
            @Override
     * handles and trackers, then fire upcalls concurrently on shared threads.
     * Lifecycle assertion: invoking an upcall on a contextId that has no registered  
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.core.tasks.resourcetracker.ThreadResourceInfo;
        trackingService.setTaskResourceTrackingEnabled(true);
     */  
     * bindings (missing unregister) and accidental sharing of contextIds across queries.
                        try (Arena arena = Arena.ofConfined()) {
    }
            );
        // Clear any leftover bindings from a previous test.  
import java.lang.foreign.ValueLayout;  
        for (int i = 0; i < threadCount; i++) {
        FilterTreeCallbacks.register(TEST_CONTEXT_ID, new MockHandle(new long[] { 0xFFL }), createTracker(task.getId()));  
     * this is a genuine bug signal (bindings survive until the last native handle
        }, "test-tokio-worker");  
            for (int i = 0; i < n; i++)  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        public long collectDocs(int collectorKey, int minDoc, int maxDoc, MemorySegment out) {
     * Without per-query contextId isolation, this test fails because:  
        public void releaseProvider(int providerKey) {}  
     */
                stats.containsKey(threads[q].threadId())
            final int queryIdx = q;
        AssertionError failure = expectThrows(AssertionError.class, () -> FilterTreeCallbacks.createProvider(unregisteredCtx, 1));
        Map<Long, List<ThreadResourceInfo>> stats = task.getResourceStats();
     * all five callback methods (createProvider, createCollector, collectDocs,
                        int ck = FilterTreeCallbacks.createCollector(ctxId, pk, 0, 0, 64);
        super.setUp();
            @Override  
        AnalyticsShardTask[] tasks = new AnalyticsShardTask[queryCount];
import java.lang.foreign.MemorySegment;
                "Task " + tasks[q].getId() + " should have tracking entries on thread " + threads[q].threadId(),
            "transport",
        CyclicBarrier barrier = new CyclicBarrier(queryCount);
    public void testConcurrentQueriesIsolated() throws Exception {
        MockHandle(long[] words) {
        private int nextKey = 1;
            TaskId.EMPTY_TASK_ID,
                } catch (AssertionError e) {
                AssertionError.class,
        CyclicBarrier barrier = new CyclicBarrier(threadCount);  
        Thread foreignThread = new Thread(() -> {
        FilterTreeCallbacks.unregister(unregisteredCtx);  
 * The OpenSearch Contributors require contributions made to  
                    barrier.await(5, TimeUnit.SECONDS);
            this.words = words;
                () -> FilterTreeCallbacks.register(ctx, new MockHandle(new long[] { 2L }), null)  
 * this file be licensed under the Apache-2.0 license or a
        );  
                            assertTrue("collectDocs should succeed for query " + queryIdx + " (got " + words + ")", words >= 0);
            return nextKey++;  
