            @Override  
        assertRefreshListenerClosed(testRefreshListener);  
        Thread thread1 = new Thread(() -> {
            }
    private void assertRefreshListenerOpen(ReleasableRetryableRefreshListener testRefreshListener) {  
    public void testRetry() throws Exception {
        assertEquals(initialCount - 3, countDownLatch.getCount());  
                return logger;  
        };  
        // This test checks the expected behaviour when the refresh listener is drained, but then refreshes are resumed again
            }
    }
    /**  
        assertBusy(() -> assertEquals(3, runCount.get()));
            @Override
            }  
                latch.countDown();  
        thread2.start();
        // This test checks the expected behaviour when the drainRefreshes times out.  
            try {
                return logger;
 * SPDX-License-Identifier: Apache-2.0
            }  
                }
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {  
            }
        Thread thread1 = new Thread(() -> {
     * This tests that the performAfterRefresh method is being invoked when the afterRefresh method is invoked. We check that the countDownLatch is decreasing as intended to validate that the performAfterRefresh is being invoked.
        assertBusy(() -> assertEquals(1, runCount.get()));  
import static org.mockito.ArgumentMatchers.any;
            @Override
        return new ReleasableRetryableRefreshListener(threadPool) {
            testRefreshListener.afterRefresh(true);  
                return TimeValue.timeValueMillis(100);
            @Override
            testRefreshListener.afterRefresh(true);
            protected Logger getLogger() {
    }
        thread2.join();  
            @Override
        testRefreshListener.drainRefreshes();
            }
import org.apache.logging.log4j.LogManager;
        }
            public void beforeRefresh() {}
        Thread thread1 = new Thread(() -> {  
     */
            protected Logger getLogger() {
        terminate(threadPool);
}
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {  
                countDownLatch.countDown();
            public void beforeRefresh() {}
            } catch (IOException e) {
        thread1.start();
            protected Logger getLogger() {
 *
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
                runCount.incrementAndGet();  
                return TimeValue.timeValueSeconds(1);
            public void beforeRefresh() {}
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        });
                } catch (InterruptedException e) {  
                try {  
            }
                return logger;
        });  
            }
    public void tearDown() throws Exception {
                return countDownLatch.getCount() == 0;  
        assertBusy(() -> assertFalse(testRefreshListener.getRetryScheduledStatus()));
                countDownLatch.countDown();
    public void testCloseAfterRefresh() throws IOException {  
    public void init() {  
package org.opensearch.index.shard;
        thread2.interrupt();
                testRefreshListener.afterRefresh(true);
    @After
                countDownLatch.countDown();
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
            protected Logger getLogger() {  
                countDownLatch.countDown();  
            @Override  
            @Override
            }  
            protected Logger getLogger() {  
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
                return logger;
            }
        final CountDownLatch countDownLatch = new CountDownLatch(initialCount);  
            }
        });  
        testRefreshListener.afterRefresh(randomBoolean());
            TimeValue getDrainTimeout() {
     * This tests that once close method is invoked, then even the retries would become no-op.
        final CountDownLatch countDownLatch = new CountDownLatch(initialCount);
        assertRefreshListenerClosed(testRefreshListener);
    /**
        Thread thread2 = new Thread(() -> {
            protected TimeValue getNextRetryInterval() {
    }
            @Override  
        testRefreshListener.afterRefresh(true);
                    throw new AssertionError(e);  
            protected Logger getLogger() {  
            public void beforeRefresh() {}
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
     * This tests that retry gets scheduled and executed when the configurations and method overrides are done properly.
            protected boolean isRetryEnabled() {
            public void beforeRefresh() {}  
            @Override
        };  
                return false;
import java.util.concurrent.atomic.AtomicInteger;
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mockThreadPool) {
                } catch (InterruptedException e) {
                }
                return true;
        assertBusy(() -> assertEquals(0, testRefreshListener.availablePermits()));  
    public void testConcurrentScheduleRetry() throws Exception {
            }  
        testRefreshListener.drainRefreshes();  
            }  
            }  
            }
            public void beforeRefresh() {}  
                return logger;
            }  
            @Override
        assertRefreshListenerClosed(testRefreshListener);
                return true;  
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
            protected String getRetryThreadPoolName() {
            }
            @Override
        assertFalse(testRefreshListener.getRetryScheduledStatus());
        // First invocation of afterRefresh method
            @Override
            } catch (InterruptedException e) {  
        testRefreshListener.drainRefreshes();  
            }
            TimeValue getDrainTimeout() {  
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;  
            protected Logger getLogger() {
        thread2.join();
            @Override  
                return logger;  
            @Override
        });
        // This tests that once the listener has been closed, even the retries would not be scheduled.
                }
            }
    public void testNoRetry() throws IOException {
        testRefreshListener.afterRefresh(true);  
            }
            @Override
        assertRefreshListenerClosed(testRefreshListener);
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        });
            }
            @Override
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {  
        });
     * This tests that the retry does not get triggered when there are missing configurations or method overrides that empowers the retry to happen.
        thread1.join();  
        for (int i = 0; i < initialCount - refreshCount; i++) {
            protected boolean isRetryEnabled() {  
        };
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {  
                testRefreshListener.afterRefresh(true);  
        testRefreshListener.afterRefresh(true);  
        assertEquals(initialCount - 2, countDownLatch.getCount());  
        thread2.join();
                runCount.incrementAndGet();
    public void testScheduleRetryAfterThreadpoolShutdown() throws Exception {
            @Override
        // This tests that once the thread-pool is shut down, the exception is handled.
    /**  
    }
        assertEquals("Failed to acquire all permits", ex.getMessage());
            @Override
                    throw new AssertionError(e);
            @Override  
                }
            protected Logger getLogger() {
        };  
            public void beforeRefresh() {}
            @Override  
            protected Logger getLogger() {
            try {  
                return logger;
import java.util.concurrent.atomic.AtomicLong;
        testRefreshListener.afterRefresh(true);
        testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {  
                } catch (InterruptedException e) {
            public void beforeRefresh() {}  
            protected TimeValue getNextRetryInterval() {  
            @Override  
        assertThrows(RuntimeException.class, () -> testRefreshListener.afterRefresh(true));
        final AtomicLong runCount = new AtomicLong();
                testRefreshListener.drainRefreshes();
     * This tests that close is acquiring all permits and even if the afterRefresh method is called, it is no-op.
            @Override
            @Override  
                testRefreshListener.afterRefresh(true);
            @Override
        int initialCount = randomIntBetween(10, 20);
            }  
    }
 * this file be licensed under the Apache-2.0 license or a
public class ReleasableRetryableRefreshListenerTests extends OpenSearchTestCase {
        ThreadPool mockThreadPool = mock(ThreadPool.class);
        testRefreshListener.afterRefresh(true);
        Thread thread = new Thread(() -> {
    private static final Logger logger = LogManager.getLogger(ReleasableRetryableRefreshListenerTests.class);
        ReleasableRetryableRefreshListener testRefreshListener = getRetryableRefreshListener(runCount);  
            try {
    public void testResumeRefreshesAfterDrainRefreshes() {
                return logger;
import java.util.concurrent.CountDownLatch;  
            try {
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
            @Override
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {  
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {  
        };  
import org.opensearch.common.lease.Releasable;  
            }
        assertTrue(testRefreshListener.isClosed());
        threadPool = new TestThreadPool(getTestName());
        final AtomicInteger retryCount = new AtomicInteger(0);
            @Override
                return logger;
            @Override
                } catch (InterruptedException e) {
        Thread thread2 = new Thread(() -> {
        assertFalse(testRefreshListener.isClosed());
            }
            }
            assertEquals("Failed to acquire all permits", ex.getMessage());
                countDownLatch.countDown();  
            }  
import org.junit.After;
        testRefreshListener.afterRefresh(true);
        // This test checks the expected behaviour when the thread performing the drainRefresh is interrupted.
            public void beforeRefresh() {}  
            }
            }
                return TimeValue.timeValueMillis(100);
            @Override
            } catch (InterruptedException e) {
        };
            @Override  
        };
    }  
                testRefreshListener.afterRefresh(true);  
            }
                return logger;
            protected String getRetryThreadPoolName() {
        testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {  
                return false;
                return TimeValue.timeValueSeconds(2);  
            protected boolean isRetryEnabled() {  
            @Override
        final CountDownLatch countDownLatch = new CountDownLatch(initialCount);  
            protected boolean isRetryEnabled() {  
            try {
            @Override
                return countDownLatch.getCount() == 0;
import static org.mockito.Mockito.when;  
            }
            }
            @Override
    private void assertRefreshListenerClosed(ReleasableRetryableRefreshListener testRefreshListener) {
            }  
                return true;
    public void testPerformAfterRefresh() throws IOException {
            @Override
        // Second invocation of afterRefresh method  
            @Override
 * The OpenSearch Contributors require contributions made to  
            }  
    private ThreadPool threadPool;  
        thread1.join();  
                throw new AssertionError(e);
                countDownLatch.countDown();
                return true;
            @Override
                return TimeValue.timeValueMillis(100);  
            @Override  
            @Override
                return logger;
            @Override
    }  
        testRefreshListener.drainRefreshes();
                return TimeValue.timeValueMillis(5000);
    public void testCloseWithRetryPending() throws IOException {  
    }
    }
        testRefreshListener.drainRefreshes();
            }  
            }
            @Override
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
        final AtomicLong runCount = new AtomicLong();  
            @Override
            @Override
            }  
            }
        Thread thread2 = new Thread(() -> {  
            protected TimeValue getNextRetryInterval() {
        assertEquals(1, countDownLatch.getCount());
    public void testTimeoutDuringClose() throws Exception {
        assertRefreshListenerOpen(testRefreshListener);
            @Override
            }  
            }  
        testRefreshListener.drainRefreshes();
        CountDownLatch countDownLatch = new CountDownLatch(2);  
    }
            @Override  
        Thread thread1 = new Thread(() -> {
            protected String getRetryThreadPoolName() {
        int refreshCount = randomIntBetween(1, initialCount);
        assertBusy(() -> assertEquals(0, countDownLatch.getCount()));
            }  
            @Override
    }
            latch.countDown();
        super.tearDown();  
                    Thread.sleep(5000);
            @Override
    /**
        testRefreshListener.drainRefreshes();
            public void beforeRefresh() {}
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
            }
            }  
        assertRefreshListenerClosed(testRefreshListener);  
            }
            protected Logger getLogger() {
                return countDownLatch.getCount() == 0;
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
    private ReleasableRetryableRefreshListener getRetryableRefreshListener(AtomicLong runCount) {  
        };
        final int initialCount = randomIntBetween(10, 100);
        assertBusy(() -> assertEquals(1, runCount.get()));
                retryCount.incrementAndGet();
        testRefreshListener.drainRefreshes();  
        assertEquals(initialCount - 4, countDownLatch.getCount());  
                throw new AssertionError(e);
        });
                    throw new AssertionError(e);
    }
                throw new AssertionError(e);  
            }  
            protected TimeValue getNextRetryInterval() {
        int initialCount = randomIntBetween(10, 100);
            @Override
        for (int i = 0; i < refreshCount; i++) {
                return true;
        thread1.join();
                try {
import org.opensearch.common.unit.TimeValue;
            @Override
            public void beforeRefresh() {}
                try {
        thread1.join();
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {  
    public void testCloseWaitsForAcquiringAllPermits() throws Exception {
            try {  
    public void testScheduleRetryAfterClose() throws Exception {  
        // This tests that if there are exceptions while scheduling the task in the threadpool, the retrySchedule boolean
import java.io.IOException;
        assertNotEquals(0, countDownLatch.getCount());  
     */
            }
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {  
        assertRefreshListenerOpen(testRefreshListener);  
        when(mockThreadPool.schedule(any(), any(), any())).thenThrow(new RuntimeException());  
    }
        assertBusy(() -> assertEquals(0, countDownLatch.getCount()));
        RuntimeException ex = assertThrows(RuntimeException.class, testRefreshListener::drainRefreshes);
            @Override
        testRefreshListener.drainRefreshes();  
            @Override
                return false;
        thread2.start();  
            @Override
            @Override  
            RuntimeException ex = assertThrows(RuntimeException.class, testRefreshListener::drainRefreshes);  
                testRefreshListener.afterRefresh(randomBoolean());
            @Override  
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
        // Closing the refresh listener so that no further afterRefreshes are executed going forward
            try {  
            @Override  
        assertEquals(initialCount - 1, countDownLatch.getCount());
                    Thread.sleep(1000);
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {  
                return logger;
                throw new AssertionError(e);  
/*  
            @Override
        final AtomicLong runCount = new AtomicLong();  
            @Override
        assertEquals(1, testRefreshListener.availablePermits());
    }
        };  
        };
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(initialCount - refreshCount, countDownLatch.getCount());
            public void beforeRefresh() {}
            @Override
                throw new AssertionError(e);
                return logger;
                return countDownLatch.getCount() == 0;
        });
        assertEquals(1, runCount.get());  
    public void testExceptionDuringThreadPoolSchedule() throws Exception {
        thread.start();  
        };
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;  
                throw new AssertionError(e);
        thread1.start();
import org.opensearch.threadpool.ThreadPool;
                return true;
    }
        final CountDownLatch countDownLatch = new CountDownLatch(initialCount);
            }
            }
 * compatible open source license.
                return logger;  
            }  
        // is reset properly to allow future scheduling to happen.  
                    Thread.sleep(TimeValue.timeValueSeconds(2).millis());
    public void testThreadInterruptDuringClose() throws Exception {  
            } catch (IOException e) {
        testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {
                return countDownLatch.getCount() == 0;
            }
            protected TimeValue getNextRetryInterval() {
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(threadPool) {  
        };
                    Thread.sleep(1000);
            } catch (IOException e) {
                return countDownLatch.getCount() == 0;
            } catch (IOException e) {
            }
            protected TimeValue getNextRetryInterval() {
                }
        Releasable releasable = testRefreshListener.drainRefreshes();
        testRefreshListener.drainRefreshes();
                countDownLatch.countDown();  
        testRefreshListener.afterRefresh(true);
                return true;  
        final CountDownLatch countDownLatch = new CountDownLatch(1);
import org.junit.Before;  
        // by closing the releasables acquired by calling the drainRefreshes method.  
        assertEquals(0, testRefreshListener.availablePermits());  
        thread1.start();
                    throw new AssertionError(e);  
     */  
            @Override
    }
        thread2.start();  
        };
                try {  
        testRefreshListener.afterRefresh(true);
                try {  
            }  
        releasable.close();  
        testRefreshListener.drainRefreshes();
        assertEquals(initialCount - refreshCount, countDownLatch.getCount());
                return retryCount.get() >= 2;
        };  
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
import org.opensearch.threadpool.TestThreadPool;  
                countDownLatch.countDown();
                return TimeValue.timeValueMillis(100);  
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;  
    }
            }
                return false;  
            public void beforeRefresh() {}  
            protected String getRetryThreadPoolName() {  
                throw new AssertionError(e);
            @Override  
        int initialCount = randomIntBetween(10, 20);
        thread1.start();
                countDownLatch.countDown();  
            protected String getRetryThreadPoolName() {
        assertRefreshListenerClosed(testRefreshListener);
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {  
            @Override
        assertEquals(0, latch.getCount());
import static org.mockito.Mockito.mock;
        testRefreshListener.afterRefresh(true);
     */  
            public void beforeRefresh() {}
                    Thread.sleep(TimeValue.timeValueSeconds(2).millis());
            }
            protected Logger getLogger() {  
     */  
    @Before
            }
            @Override
            } catch (IOException e) {
            protected Logger getLogger() {
                return false;
    }
                    throw new AssertionError(e);  
            @Override
                } catch (InterruptedException e) {  
        assertBusy(() -> assertEquals(0, testRefreshListener.availablePermits()));
        ReleasableRetryableRefreshListener testRefreshListener = new ReleasableRetryableRefreshListener(mock(ThreadPool.class)) {
            }
            public void beforeRefresh() {}
                threadPool.shutdown();  
        AtomicInteger runCount = new AtomicInteger();
        CountDownLatch latch = new CountDownLatch(2);
                return logger;  
            protected Logger getLogger() {
 */  
            protected Logger getLogger() {
        // This tests that there can be only 1 retry that can be scheduled at a time.
            @Override
        ReleasableRetryableRefreshListener testRefreshListener = getRetryableRefreshListener(runCount);
        }  
            protected Logger getLogger() {  
            protected boolean performAfterRefreshWithPermit(boolean didRefresh) {
                return ThreadPool.Names.REMOTE_REFRESH_RETRY;
        };
                return TimeValue.timeValueMillis(100);
        assertEquals(0, countDownLatch.getCount());
    /**
            protected String getRetryThreadPoolName() {
                runCount.incrementAndGet();  
            @Override
                Thread.sleep(500);
import org.apache.logging.log4j.Logger;
                Thread.sleep(500);
