                return logger;
        for (int i = 0; i < initialCount - refreshCount; i++) {
                return logger;
        testRefreshListener.afterRefresh(randomBoolean());
            protected Logger getLogger() {
        int initialCount = randomIntBetween(10, 20);
        thread2.join();
            @Override
                throw new AssertionError(e);
            @Override
    }
            }
     * This tests that retry gets scheduled and executed when the configurations and method overrides are done properly.
    @Before
     */
            }
            @Override
        // by closing the releasables acquired by calling the drainRefreshes method.
            @Override
            }
                    throw new AssertionError(e);
        Thread thread1 = new Thread(() -> {
            @Override
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
            try {
    /**
                countDownLatch.countDown();
        };
        AtomicInteger runCount = new AtomicInteger();
        thread1.join();
            protected Logger getLogger() {
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
        thread1.join();
            @Override
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
    public void testScheduleRetryAfterClose() throws Exception {
        thread.start();
                countDownLatch.countDown();
        assertEquals(initialCount - 4, countDownLatch.getCount());
            } catch (InterruptedException e) {
            @Override
        });
                } catch (InterruptedException e) {
 * compatible open source license.
            protected Logger getLogger() {
                return logger;
        testRefreshListener.drainRefreshes();
            }
        testRefreshListener.drainRefreshes();
            public void beforeRefresh() {}
                }
            }
            @Override
            @Override
                runCount.incrementAndGet();
            @Override
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
            @Override
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
            } catch (IOException e) {
            protected Logger getLogger() {
                return countDownLatch.getCount() == 0;
            }
            }
            @Override
        assertBusy(() -> assertEquals(0, countDownLatch.getCount()));
            }
                runCount.incrementAndGet();
            try {
        };
        testRefreshListener.drainRefreshes();
    }
                try {
 * The OpenSearch Contributors require contributions made to
    public void tearDown() throws Exception {
import org.opensearch.threadpool.TestThreadPool;
            public void beforeRefresh() {}
            @Override
                return TimeValue.timeValueMillis(100);
        testRefreshListener.afterRefresh(true);
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        assertEquals(0, countDownLatch.getCount());
            @Override
        testRefreshListener.afterRefresh(true);
            }
        });
        super.tearDown();
    private static final Logger logger = LogManager.getLogger(ReleasableRetryableRefreshListenerTests.class);
                return logger;
            @Override
            @Override
            @Override
                countDownLatch.countDown();
    }
        final int initialCount = randomIntBetween(10, 100);
                    throw new AssertionError(e);
            protected String getRetryThreadPoolName() {
            protected Logger getLogger() {
            } catch (IOException e) {
                return countDownLatch.getCount() == 0;
            }
            }
            } catch (IOException e) {
    public void testCloseAfterRefresh() throws IOException {
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
            }
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
                    throw new AssertionError(e);
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
    }
            public void beforeRefresh() {}
            }
        assertEquals("Failed to acquire all permits", ex.getMessage());
        final CountDownLatch countDownLatch = new CountDownLatch(initialCount);
                return true;
        terminate(threadPool);
                latch.countDown();
            protected Logger getLogger() {
            }
    public void testConcurrentScheduleRetry() throws Exception {
    public void testCloseWaitsForAcquiringAllPermits() throws Exception {
        };
            }
import org.junit.After;
        assertBusy(() -> assertEquals(1, runCount.get()));
public class ReleasableRetryableRefreshListenerTests extends OpenSearchTestCase {
            @Override
            protected Logger getLogger() {
                return countDownLatch.getCount() == 0;
            @Override
            testRefreshListener.afterRefresh(true);
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mockThreadPool) {
        testRefreshListener.afterRefresh(true);
            }
                return true;
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
            protected boolean isRetryEnabled() {
                return logger;
                return TimeValue.timeValueMillis(100);
        // This test checks the expected behaviour when the thread performing the drainRefresh is interrupted.
            protected TimeValue getNextRetryInterval() {
                throw new AssertionError(e);
        Thread thread2 = new Thread(() -> {
            @Override
            @Override
import java.util.concurrent.atomic.AtomicInteger;
            public void beforeRefresh() {}
        assertRefreshListenerOpen(testRefreshListener);
    public void testExceptionDuringThreadPoolSchedule() throws Exception {
            @Override
        testRefreshListener.drainRefreshes();
        // This test checks the expected behaviour when the drainRefreshes times out.
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        testRefreshListener.drainRefreshes();
            latch.countDown();
        // Second invocation of afterRefresh method
            protected Logger getLogger() {
            public void beforeRefresh() {}
            @Override
            @Override
            }
        // First invocation of afterRefresh method
            @Override
            TimeValue getDrainTimeout() {
    }
                return true;
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
                return TimeValue.timeValueSeconds(2);
    private void assertRefreshListenerClosed(ReleasableRetryableRefreshListener testRefreshListener) {
        };
    }
            @Override
        testRefreshListener.afterRefresh(true);
                testRefreshListener.afterRefresh(true);
            }
            }
            }
 */
    public void init() {
        assertNotEquals(0, countDownLatch.getCount());
    private ReleasableRetryableRefreshListener getRetryableRefreshListener(AtomicLong runCount) {
                try {
        when(mockThreadPool.schedule(any(), any(), any())).thenThrow(new RuntimeException());
     */
            try {
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
import java.io.IOException;
                return countDownLatch.getCount() == 0;
            }
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        // is reset properly to allow future scheduling to happen.
            protected TimeValue getNextRetryInterval() {
        ThreadPool mockThreadPool = mock(ThreadPool.class);
            }
                } catch (InterruptedException e) {
        Thread thread2 = new Thread(() -> {
import java.util.concurrent.atomic.AtomicLong;
        testRefreshListener.afterRefresh(true);
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
                testRefreshListener.afterRefresh(true);
            @Override
            }
        assertEquals(initialCount - 1, countDownLatch.getCount());
                    Thread.sleep(1000);
            protected String getRetryThreadPoolName() {
        final CountDownLatch countDownLatch = new CountDownLatch(initialCount);
        assertBusy(() -> assertEquals(0, testRefreshListener.availablePermits()));
     */
                throw new AssertionError(e);
     */
            protected Logger getLogger() {
        CountDownLatch countDownLatch = new CountDownLatch(2);
            @Override
            }
    }
        assertEquals(initialCount - refreshCount, countDownLatch.getCount());
                countDownLatch.countDown();
import java.util.concurrent.CountDownLatch;
            }
        };
            }
                return TimeValue.timeValueMillis(100);
            }
                }
            try {
import org.opensearch.threadpool.ThreadPool;
        };
import org.opensearch.common.unit.TimeValue;
            public void beforeRefresh() {}
            }
            @Override
                countDownLatch.countDown();
            protected String getRetryThreadPoolName() {
            public void beforeRefresh() {}
            protected TimeValue getNextRetryInterval() {
        thread2.interrupt();
            try {
            }
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
                throw new AssertionError(e);
            @Override
                testRefreshListener.afterRefresh(true);
            @Override
        Releasable releasable = testRefreshListener.drainRefreshes();
            @Override
        testRefreshListener.drainRefreshes();
import org.opensearch.test.OpenSearchTestCase;
        return new ReleasableRetryableRefreshListener(threadPool) {
                } catch (InterruptedException e) {
            protected Logger getLogger() {
        thread2.start();
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
                return false;
                countDownLatch.countDown();
                countDownLatch.countDown();
        assertRefreshListenerOpen(testRefreshListener);
            }
package org.opensearch.index.shard;
                return countDownLatch.getCount() == 0;
        };
            }
        assertEquals(0, testRefreshListener.availablePermits());
            public void beforeRefresh() {}
        CountDownLatch latch = new CountDownLatch(2);
            @Override
                return TimeValue.timeValueMillis(100);
                } catch (InterruptedException e) {
                Thread.sleep(500);
    /**
                return countDownLatch.getCount() == 0;
            @Override
        thread1.join();
                }
        testRefreshListener.drainRefreshes();
        testRefreshListener.drainRefreshes();
    }
import org.opensearch.common.lease.Releasable;
            try {
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
    private void assertRefreshListenerOpen(ReleasableRetryableRefreshListener testRefreshListener) {
    }
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
                countDownLatch.countDown();
                countDownLatch.countDown();
            @Override
            }
            assertEquals("Failed to acquire all permits", ex.getMessage());
        // This tests that once the listener has been closed, even the retries would not be scheduled.
            }
        thread1.start();
    }
        int refreshCount = randomIntBetween(1, initialCount);
            protected TimeValue getNextRetryInterval() {
        ReleasableRetryableRefreshListener testRefreshListener = getRetryableRefreshListener(runCount);
            protected String getRetryThreadPoolName() {
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        // Closing the refresh listener so that no further afterRefreshes are executed going forward
            @Override
            public void beforeRefresh() {}
            TimeValue getDrainTimeout() {
            @Override
        };
                return TimeValue.timeValueMillis(5000);
        assertEquals(1, testRefreshListener.availablePermits());
import static org.mockito.ArgumentMatchers.any;
                return logger;
                return logger;
}
        final AtomicLong runCount = new AtomicLong();
                return logger;
                    Thread.sleep(TimeValue.timeValueSeconds(2).millis());
            protected String getRetryThreadPoolName() {
        }
            protected TimeValue getNextRetryInterval() {
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
        };
        };
import org.apache.logging.log4j.Logger;
    public void testTimeoutDuringClose() throws Exception {
            @Override
                return logger;
    }
        thread1.start();
            @Override
 * this file be licensed under the Apache-2.0 license or a
            }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        assertRefreshListenerClosed(testRefreshListener);
        assertEquals(1, countDownLatch.getCount());
                return logger;
    private ThreadPool threadPool;
        });
        // This tests that there can be only 1 retry that can be scheduled at a time.
                return retryCount.get() >= 2;
            try {
        assertBusy(() -> assertEquals(0, testRefreshListener.availablePermits()));
        assertEquals(initialCount - 2, countDownLatch.getCount());
        // This tests that if there are exceptions while scheduling the task in the threadpool, the retrySchedule boolean
                    Thread.sleep(5000);
            @Override
     * This tests that the retry does not get triggered when there are missing configurations or method overrides that empowers the retry to happen.
                runCount.incrementAndGet();
     * This tests that once close method is invoked, then even the retries would become no-op.
                return false;
        // This tests that once the thread-pool is shut down, the exception is handled.
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
            @Override
    }
        });
            }
    /**
            }
            protected String getRetryThreadPoolName() {
            } catch (InterruptedException e) {
                return TimeValue.timeValueMillis(100);
            @Override
import org.junit.Before;
            }
    }
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
            @Override
                return logger;
        RuntimeException ex = assertThrows(RuntimeException.class, testRefreshListener::drainRefreshes);
        testRefreshListener.afterRefresh(true);
    public void testPerformAfterRefresh() throws IOException {
        assertRefreshListenerClosed(testRefreshListener);
                return true;
            } catch (IOException e) {
            }
            protected Logger getLogger() {
        threadPool = new TestThreadPool(getTestName());
    /**
    public void testNoRetry() throws IOException {
            @Override
            @Override
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        };
     * This tests that close is acquiring all permits and even if the afterRefresh method is called, it is no-op.
        testRefreshListener.afterRefresh(true);
            @Override
                return logger;
        testRefreshListener.drainRefreshes();
                return true;
        testRefreshListener.drainRefreshes();
        thread1.start();
        testRefreshListener.drainRefreshes();
    }
            }
        final AtomicLong runCount = new AtomicLong();
            protected Logger getLogger() {
import static org.mockito.Mockito.when;
            public void beforeRefresh() {}
                    throw new AssertionError(e);
    public void testResumeRefreshesAfterDrainRefreshes() {
import static org.mockito.Mockito.mock;
                    throw new AssertionError(e);
        assertBusy(() -> assertEquals(3, runCount.get()));
        };
            }
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
        });
        for (int i = 0; i < refreshCount; i++) {
            testRefreshListener.afterRefresh(true);
        testRefreshListener.afterRefresh(true);
        testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
        assertRefreshListenerClosed(testRefreshListener);
            @Override
            }
        assertThrows(RuntimeException.class, () -> testRefreshListener.afterRefresh(true));
     * This tests that the performAfterRefresh method is being invoked when the afterRefresh method is invoked. We check that the countDownLatch is decreasing as intended to validate that the performAfterRefresh is being invoked.
        // This test checks the expected behaviour when the refresh listener is drained, but then refreshes are resumed again
        thread1.join();
        testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
        testRefreshListener.afterRefresh(true);
    /**
                    Thread.sleep(TimeValue.timeValueSeconds(2).millis());
            RuntimeException ex = assertThrows(RuntimeException.class, testRefreshListener::drainRefreshes);
            }
            protected boolean isRetryEnabled() {
            @Override
                }
                throw new AssertionError(e);
            @Override
        releasable.close();
                retryCount.incrementAndGet();
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
        assertBusy(() -> assertFalse(testRefreshListener.getRetryScheduledStatus()));
            public void beforeRefresh() {}
            @Override
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
        thread2.start();
        assertRefreshListenerClosed(testRefreshListener);
        int initialCount = randomIntBetween(10, 20);
    public void testCloseWithRetryPending() throws IOException {
            @Override
            }
        };
        thread2.start();
/*
                return logger;
        Thread thread1 = new Thread(() -> {
                return false;
        assertTrue(testRefreshListener.isClosed());
        assertEquals(0, latch.getCount());
        thread2.join();
    public void testRetry() throws Exception {
        final AtomicLong runCount = new AtomicLong();
            }
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        final CountDownLatch countDownLatch = new CountDownLatch(initialCount);
                }
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
            @Override
                throw new AssertionError(e);
 *
        thread2.join();
            }
            @Override
            } catch (IOException e) {
                Thread.sleep(500);
        Thread thread2 = new Thread(() -> {
                return logger;
    }
            }
        });
            protected boolean isRetryEnabled() {
                threadPool.shutdown();
        assertRefreshListenerClosed(testRefreshListener);
        Thread thread1 = new Thread(() -> {
            protected Logger getLogger() {
    }
    @After
     */
        thread1.start();
            }
        final CountDownLatch countDownLatch = new CountDownLatch(initialCount);
    }
        assertEquals(initialCount - refreshCount, countDownLatch.getCount());
            public void beforeRefresh() {}
                    Thread.sleep(1000);
                throw new AssertionError(e);
                return logger;
        };
            protected Logger getLogger() {
            @Override
        assertRefreshListenerClosed(testRefreshListener);
            }
        Thread thread = new Thread(() -> {
    }
                try {
        final AtomicInteger retryCount = new AtomicInteger(0);
            }
            @Override
        assertBusy(() -> assertEquals(0, countDownLatch.getCount()));
            }
            }
            }
            }
                return TimeValue.timeValueSeconds(1);
                } catch (InterruptedException e) {
        }
            public void beforeRefresh() {}
        });
            @Override
                testRefreshListener.afterRefresh(true);
    public void testScheduleRetryAfterThreadpoolShutdown() throws Exception {
            @Override
            public void beforeRefresh() {}
        assertEquals(initialCount - 3, countDownLatch.getCount());
                return false;
        assertFalse(testRefreshListener.getRetryScheduledStatus());
                return true;
        assertEquals(1, runCount.get());
                try {
        Thread thread1 = new Thread(() -> {
                testRefreshListener.afterRefresh(randomBoolean());
                return true;
        int initialCount = randomIntBetween(10, 100);
                testRefreshListener.drainRefreshes();
            protected Logger getLogger() {
import org.apache.logging.log4j.LogManager;
            }
            public void beforeRefresh() {}
            @Override
    public void testThreadInterruptDuringClose() throws Exception {
                try {
 * SPDX-License-Identifier: Apache-2.0
        ReleasableRetryableRefreshListener testRefreshListener = getRetryableRefreshListener(runCount);
        testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
            @Override
        });
            }
        };
            @Override
            protected boolean isRetryEnabled() {
            @Override
        assertFalse(testRefreshListener.isClosed());
            protected TimeValue getNextRetryInterval() {
            @Override
        assertBusy(() -> assertEquals(1, runCount.get()));
                return false;
            @Override
