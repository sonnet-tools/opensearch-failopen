            public void run() {
            if (randomBoolean()) {
    public void testOnRejectionCausesCancellation() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
        final TimeValue delay = TimeValue.timeValueMillis(100L);
 */
                reschedulingRunnable.run();
                if (getWithTimeout) {
 * the Apache License, Version 2.0 (the "License"); you may
        Object resultingObject = resultsFuture.get();
                throw new OpenSearchException("this shouldn't cause the test to fail!");
                if (command instanceof ReschedulingRunnable) {
        };
        );
    public void testDoesNotRescheduleUntilExecutionFinished() throws Exception {
 * license agreements. See the NOTICE file distributed with
        };
            }
import static org.mockito.Mockito.verifyNoMoreInteractions;
                logger.warn("this runnable ran after it was cancelled");
    }
            }
    public void testBlockingCallOnNonSchedulerThreadAllowed() throws Exception {
            if (doneLatch.getCount() == 0) {
import org.opensearch.threadpool.Scheduler.ReschedulingRunnable;
            // notify that the runnable is started
import static org.mockito.Mockito.verify;
import java.util.concurrent.atomic.AtomicInteger;
        final BaseFuture<Object> future = new BaseFuture<Object>() {
 * Unit tests for the scheduling of tasks with a fixed delay
    private ThreadPool threadPool;
            }
                }
        assertThat(counterValue, equalTo(iterations));
            }
        }
        latch.await();
        // rarely wait and make sure the runnable didn't run at the next interval
        final Runnable runnable = () -> {
        startLatch.await();
import org.opensearch.common.settings.Settings;
        final TimeValue delay = TimeValue.timeValueMillis(10L);
                    obj = future.get(1L, TimeUnit.SECONDS);
        final Runnable countingRunnable = () -> {
            }
 *
                throw new RuntimeException("throw before count down");
        final Runnable runnable = () -> {
        if (rarely()) {
        final TimeValue interval = TimeValue.timeValueMillis(50L);
            Names.GENERIC,
import org.opensearch.common.util.concurrent.BaseFuture;
        // this call was made during construction of the runnable
                Object obj;
import java.util.concurrent.CountDownLatch;
 * KIND, either express or implied.  See the License for the
        final Object o = new Object();
            assertBusy(() -> assertFalse("Runnable was run after being cancelled", runAfterDone.get()), 1L, TimeUnit.SECONDS);
                cancellable.cancel();
 */
            latch.countDown();
        Runnable runnable = () -> {};
            if (cancellable == null) {
    }
 * this file be licensed under the Apache-2.0 license or a
        boolean futureDone(Object value) {
                return null;
        final TestFuture resultsFuture = new TestFuture();
                resultsFuture.futureDone(obj);
 * this work for additional information regarding copyright
            assertBusy(() -> assertThat(counter.get(), equalTo(iterations)), 5 * interval.millis(), TimeUnit.MILLISECONDS);
                if (rethrow) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            final int count = counter.decrementAndGet();
 * software distributed under the License is distributed on an
import static org.mockito.Mockito.times;
        final int iterations = scaledRandomIntBetween(2, 12);
            try {
        final TestFuture future = new TestFuture();
                    obj = future.get();
            delay,
        final AtomicReference<Cancellable> cancellableRef = new AtomicReference<>();
            }
    @After
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.containsString;
            if (shouldThrow && rarely()) {
import org.opensearch.node.Node;
                // wait for the cancellable to be present before we really start so we can accurately know we cancelled
        assertFalse(cancellable.isCancelled());
                throw new OpenSearchException("sometimes we throw before counting down");
    public void testRunnableDoesNotRunAfterCancellation() throws Exception {
        // cancel
 * Licensed to Elasticsearch under one or more contributor
        Throwable t = (Throwable) resultingObject;
            runnable,
            @Override
        // create a thread and start the runnable
            } catch (InterruptedException e) {
    public void shutdown() throws Exception {
                // wait for other thread to un-pause
                } else {
        // wait for the number of successful count down operations
/*
        Cancellable cancellable = threadPool.scheduleWithFixedDelay(countingRunnable, TimeValue.timeValueMillis(10L), Names.GENERIC);
        // wait for the runnable to be started and ensure the runnable hasn't used the threadpool again
        cancellable.cancel();
        final int counterValue = counter.get();
    }
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        final AtomicInteger counter = new AtomicInteger();
import java.util.concurrent.TimeUnit;
/*
                Thread.currentThread().interrupt();
        }
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String executor) {
                runAfterDone.set(true);
 */
    static final class TestFuture extends BaseFuture<Object> {
            // see if we have counted down to zero or below yet. the exception throwing could make us count below zero
                Object obj;
    }
    }
            } catch (Throwable t) {
            startLatch.countDown();
        final CountDownLatch latch = new CountDownLatch(scaledRandomIntBetween(2, 16));
        final AtomicBoolean runAfterDone = new AtomicBoolean(false);
        ReschedulingRunnable reschedulingRunnable = new ReschedulingRunnable(
            @Override
        final Runnable countingRunnable = () -> {
                }
        // validate schedule was called again
        assertThat(t, instanceOf(AssertionError.class));
        runThread.join();
        final boolean shouldThrow = randomBoolean();
        assertThat(resultingObject, sameInstance(o));
        Cancellable cancellable = threadPool.scheduleWithFixedDelay(runnable, TimeValue.timeValueMillis(10L), Names.SAME);
                    throw new RuntimeException(t);
            (e) -> {},
        threadPool = new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "fixed delay tests").build()) {
        assertTrue(cancellable.isCancelled());
        final Runnable runnable = () -> {
import org.opensearch.threadpool.Scheduler.Cancellable;
    }
            try {
        final boolean getWithTimeout = randomBoolean();
        final CountDownLatch doneLatch = new CountDownLatch(1);
            }
        assertThat(resultingObject, instanceOf(Throwable.class));
            } catch (Throwable t) {
            (e) -> {}
        final TestFuture resultsFuture = new TestFuture();
        final CountDownLatch doneLatch = new CountDownLatch(iterations);
        final boolean getWithTimeout = randomBoolean();
                resultsFuture.futureDone(t);
                resultsFuture.futureDone(t);
            if (shouldThrow && rarely()) {
            delay,
        assertTrue(cancellable.isCancelled());
        };
            }
/**
        final boolean rethrow = randomBoolean();
 * not use this file except in compliance with the License.
        Thread runThread = new Thread() {
                    ((ReschedulingRunnable) command).onRejection(new OpenSearchRejectedExecutionException());
                    fail("this should only be called with a rescheduling runnable in this test");
            counter.incrementAndGet();
import org.opensearch.threadpool.ThreadPool.Names;
            doneLatch.countDown();
            }
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.sameInstance;
        assertNotNull(cancellable);
import static org.mockito.Mockito.mock;
                    obj = future.get();
        final Runnable countingRunnable = () -> {
        verify(threadPool, times(1)).schedule(reschedulingRunnable, delay, Names.GENERIC);
        assertFalse(runAfterDone.get());
        assertFalse(resultsFuture.isDone());
            (e) -> {}
import org.junit.Before;
            // rarely throw an exception after execution
        );
    public void testThatRunnableIsRescheduled() throws Exception {
        // wait for the runnable to finish
    public void setup() {
        terminate(threadPool);
 *
        final CountDownLatch pauseLatch = new CountDownLatch(1);
        cancellableRef.set(cancellable);
import org.opensearch.test.OpenSearchTestCase;
    public void testBlockingCallOnSchedulerThreadFails() throws Exception {
                if (getWithTimeout) {
    public void testCancellingRunnable() throws Exception {
import org.junit.After;
        if (rarely()) {
        cancellable.cancel();
        final Cancellable cancellable = threadPool.scheduleWithFixedDelay(runnable, TimeValue.timeValueMillis(10L), Names.GENERIC);
import org.opensearch.OpenSearchException;
            }
import org.opensearch.common.unit.TimeValue;
                resultsFuture.futureDone(obj);
        ReschedulingRunnable reschedulingRunnable = new ReschedulingRunnable(
                pauseLatch.await();
        assertNotNull(resultingObject);
            if (count <= 0) {
            final Cancellable cancellable = cancellableRef.get();
        ThreadPool threadPool = mock(ThreadPool.class);
    }
        // un-pause the runnable and allow it to complete execution
    }
        final Object resultingObject = resultsFuture.get();
        };
}
        };
package org.opensearch.threadpool;
                doneLatch.countDown();
 * You may obtain a copy of the License at
                } else {
            // rarely throw an exception before counting down
        final AtomicInteger counter = new AtomicInteger(scaledRandomIntBetween(2, 16));
        assertTrue(reschedulingRunnable.isCancelled());
        // the runnable should have cancelled itself
import java.util.concurrent.atomic.AtomicReference;
import static org.hamcrest.Matchers.instanceOf;
            }
        };
            if (rarely()) {
        assertThat(t.getMessage(), containsString("Blocking"));
        final Cancellable cancellable = threadPool.scheduleWithFixedDelay(countingRunnable, interval, Names.GENERIC);
            threadPool,
        Cancellable cancellable = threadPool.scheduleWithFixedDelay(countingRunnable, TimeValue.timeValueMillis(10L), Names.GENERIC);
import static org.hamcrest.Matchers.equalTo;
        };
        doneLatch.await();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        verify(threadPool, times(2)).schedule(reschedulingRunnable, delay, Names.GENERIC);
 * under the License.
        future.futureDone(o);
        terminate(threadPool);
        };
 *
            return set(value);
            threadPool,
            (e) -> {},
    @Before
                return;
 * The OpenSearch Contributors require contributions made to
                throw new RuntimeException("throw at end");
            }
                } else {
                    obj = future.get(1, TimeUnit.MINUTES);
        final CountDownLatch startLatch = new CountDownLatch(1);
 * Unless required by applicable law or agreed to in writing,
    }
            runnable,
        doneLatch.await();
        }
                }
public class ScheduleWithFixedDelayTests extends OpenSearchTestCase {
/*
 * GitHub history for details.
            try {
    }
 * SPDX-License-Identifier: Apache-2.0
                }
import java.util.concurrent.atomic.AtomicBoolean;
 */
        assertFalse(cancellable.isCancelled());
 * compatible open source license.
        };
        threadPool = new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "fixed delay tests").build());
            Names.GENERIC,
        pauseLatch.countDown();
        runThread.start();
        verifyNoMoreInteractions(threadPool);
