            }
                reschedulingRunnable.run();
        Throwable t = (Throwable) resultingObject;
        // wait for the runnable to finish
        };
            return set(value);
            try {  
            }
            assertBusy(() -> assertFalse("Runnable was run after being cancelled", runAfterDone.get()), 1L, TimeUnit.SECONDS);
    public void testThatRunnableIsRescheduled() throws Exception {  
            if (cancellable == null) {  
        };
        doneLatch.await();
        final int counterValue = counter.get();
                // wait for the cancellable to be present before we really start so we can accurately know we cancelled
            runnable,
            threadPool,
        // un-pause the runnable and allow it to complete execution
import org.opensearch.test.OpenSearchTestCase;
        assertTrue(cancellable.isCancelled());
 */
        if (rarely()) {  
        assertThat(t.getMessage(), containsString("Blocking"));
        final CountDownLatch doneLatch = new CountDownLatch(1);
import static org.hamcrest.Matchers.instanceOf;
                Thread.currentThread().interrupt();
        verify(threadPool, times(2)).schedule(reschedulingRunnable, delay, Names.GENERIC);  
 * software distributed under the License is distributed on an
        startLatch.await();
import java.util.concurrent.atomic.AtomicReference;  
        threadPool = new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "fixed delay tests").build());
        final AtomicReference<Cancellable> cancellableRef = new AtomicReference<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final boolean rethrow = randomBoolean();
    }  
            (e) -> {},
            }  
        final TimeValue interval = TimeValue.timeValueMillis(50L);
            try {  
import static org.hamcrest.Matchers.equalTo;  
        doneLatch.await();
        };
        }  
            doneLatch.countDown();
            final int count = counter.decrementAndGet();
        }  
        final Runnable runnable = () -> {  
                resultsFuture.futureDone(t);  
        Thread runThread = new Thread() {
        final Runnable runnable = () -> {
                if (command instanceof ReschedulingRunnable) {  
        Cancellable cancellable = threadPool.scheduleWithFixedDelay(countingRunnable, TimeValue.timeValueMillis(10L), Names.GENERIC);
                runAfterDone.set(true);
                    obj = future.get(1, TimeUnit.MINUTES);  
        };  
                }
    public void testBlockingCallOnSchedulerThreadFails() throws Exception {
 * GitHub history for details.
 * You may obtain a copy of the License at  
        };  
import java.util.concurrent.atomic.AtomicBoolean;
                    obj = future.get();
 */  
    public void testOnRejectionCausesCancellation() throws Exception {  
import org.opensearch.common.settings.Settings;
    public void shutdown() throws Exception {  
    public void setup() {
        // rarely wait and make sure the runnable didn't run at the next interval
 */  
        // validate schedule was called again
                // wait for other thread to un-pause
                throw new OpenSearchException("sometimes we throw before counting down");
        pauseLatch.countDown();
            }  
            @Override
        }
            assertBusy(() -> assertThat(counter.get(), equalTo(iterations)), 5 * interval.millis(), TimeUnit.MILLISECONDS);
        terminate(threadPool);
        cancellable.cancel();  
        final boolean getWithTimeout = randomBoolean();  
                resultsFuture.futureDone(t);  
            }
        final CountDownLatch pauseLatch = new CountDownLatch(1);
        cancellable.cancel();
            } catch (InterruptedException e) {  
                if (getWithTimeout) {
    @After
 * Modifications Copyright OpenSearch Contributors. See
            try {  
    }  
    }
        // wait for the number of successful count down operations
import static org.mockito.Mockito.times;
 * under the License.  
import java.util.concurrent.TimeUnit;  
                logger.warn("this runnable ran after it was cancelled");
import org.opensearch.OpenSearchException;
            @Override
            startLatch.countDown();
            threadPool,
        final TimeValue delay = TimeValue.timeValueMillis(10L);
    }  
                } else {
        final TimeValue delay = TimeValue.timeValueMillis(100L);
    public void testCancellingRunnable() throws Exception {
    }
        latch.await();  
import static org.mockito.Mockito.verifyNoMoreInteractions;  
 * ownership. Elasticsearch licenses this file to you under  
            public void run() {  
 *
                }  
        cancellableRef.set(cancellable);  
import org.junit.Before;  
        // create a thread and start the runnable  
 * Licensed to Elasticsearch under one or more contributor  
        final boolean shouldThrow = randomBoolean();
            counter.incrementAndGet();
        assertThat(t, instanceOf(AssertionError.class));  
 * Unit tests for the scheduling of tasks with a fixed delay  
        final Cancellable cancellable = threadPool.scheduleWithFixedDelay(countingRunnable, interval, Names.GENERIC);  
        verifyNoMoreInteractions(threadPool);
    static final class TestFuture extends BaseFuture<Object> {  
            if (shouldThrow && rarely()) {  
    }
                pauseLatch.await();
import org.junit.After;
        ReschedulingRunnable reschedulingRunnable = new ReschedulingRunnable(
/*  
 * compatible open source license.
        final Runnable runnable = () -> {
        // this call was made during construction of the runnable  
import org.opensearch.common.util.concurrent.BaseFuture;
 * The OpenSearch Contributors require contributions made to  
                    fail("this should only be called with a rescheduling runnable in this test");  
package org.opensearch.threadpool;
        // wait for the runnable to be started and ensure the runnable hasn't used the threadpool again  
            }
                resultsFuture.futureDone(obj);
    public void testBlockingCallOnNonSchedulerThreadAllowed() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
        threadPool = new ThreadPool(Settings.builder().put(Node.NODE_NAME_SETTING.getKey(), "fixed delay tests").build()) {  
        final BaseFuture<Object> future = new BaseFuture<Object>() {  
        final Runnable countingRunnable = () -> {  
}
/**
                throw new RuntimeException("throw before count down");
        assertFalse(cancellable.isCancelled());
import org.opensearch.node.Node;  
        runThread.join();  
        final AtomicInteger counter = new AtomicInteger(scaledRandomIntBetween(2, 16));  
 * KIND, either express or implied.  See the License for the
        assertThat(counterValue, equalTo(iterations));
        verify(threadPool, times(1)).schedule(reschedulingRunnable, delay, Names.GENERIC);
        final boolean getWithTimeout = randomBoolean();  
                throw new RuntimeException("throw at end");
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(resultsFuture.isDone());
            // see if we have counted down to zero or below yet. the exception throwing could make us count below zero  
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
        };
        assertThat(resultingObject, instanceOf(Throwable.class));
 * specific language governing permissions and limitations
            final Cancellable cancellable = cancellableRef.get();
        final CountDownLatch startLatch = new CountDownLatch(1);  
        ThreadPool threadPool = mock(ThreadPool.class);
 * this work for additional information regarding copyright
        final TestFuture future = new TestFuture();  
import java.util.concurrent.atomic.AtomicInteger;
                    throw new RuntimeException(t);
        Runnable runnable = () -> {};
        assertTrue(cancellable.isCancelled());
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Runnable countingRunnable = () -> {
                resultsFuture.futureDone(obj);
    public void testRunnableDoesNotRunAfterCancellation() throws Exception {
    public void testDoesNotRescheduleUntilExecutionFinished() throws Exception {
        final AtomicInteger counter = new AtomicInteger();
        );
                if (getWithTimeout) {
        Cancellable cancellable = threadPool.scheduleWithFixedDelay(countingRunnable, TimeValue.timeValueMillis(10L), Names.GENERIC);
public class ScheduleWithFixedDelayTests extends OpenSearchTestCase {
        };
    @Before  
        assertTrue(reschedulingRunnable.isCancelled());
        final Runnable countingRunnable = () -> {
 */
                }  
import static org.mockito.Mockito.mock;  
            runnable,
                } else {
import static org.hamcrest.Matchers.containsString;
                Object obj;
                doneLatch.countDown();  
        );
        };  
 * not use this file except in compliance with the License.
        Object resultingObject = resultsFuture.get();
import org.opensearch.threadpool.Scheduler.ReschedulingRunnable;  
    }
 *  
            delay,
            delay,  
    }
import org.opensearch.common.unit.TimeValue;  
        assertFalse(cancellable.isCancelled());  
            latch.countDown();
            // rarely throw an exception after execution  
        boolean futureDone(Object value) {
            (e) -> {}  
        runThread.start();
            }
            (e) -> {},  
            if (shouldThrow && rarely()) {
 * license agreements. See the NOTICE file distributed with
import static org.mockito.Mockito.verify;
import org.opensearch.threadpool.ThreadPool.Names;
                } else {
            } catch (Throwable t) {
 * the Apache License, Version 2.0 (the "License"); you may
        assertNotNull(resultingObject);  
        terminate(threadPool);
            } catch (Throwable t) {
            if (doneLatch.getCount() == 0) {  
            if (count <= 0) {
            if (randomBoolean()) {  
                throw new OpenSearchException("this shouldn't cause the test to fail!");
                return null;
        ReschedulingRunnable reschedulingRunnable = new ReschedulingRunnable(  
        final int iterations = scaledRandomIntBetween(2, 12);  
        final AtomicBoolean runAfterDone = new AtomicBoolean(false);  
        final Object o = new Object();
        // cancel
        // the runnable should have cancelled itself
    }
        final CountDownLatch latch = new CountDownLatch(scaledRandomIntBetween(2, 16));
        final TestFuture resultsFuture = new TestFuture();
 *
                cancellable.cancel();
import java.util.concurrent.CountDownLatch;
            }
            (e) -> {}
                    ((ReschedulingRunnable) command).onRejection(new OpenSearchRejectedExecutionException());
 * Unless required by applicable law or agreed to in writing,
            // notify that the runnable is started
/*
    private ThreadPool threadPool;
                Object obj;
                return;
            }  
    }  
                }  
        final TestFuture resultsFuture = new TestFuture();
                    obj = future.get(1L, TimeUnit.SECONDS);  
            Names.GENERIC,  
        final Cancellable cancellable = threadPool.scheduleWithFixedDelay(runnable, TimeValue.timeValueMillis(10L), Names.GENERIC);
        Cancellable cancellable = threadPool.scheduleWithFixedDelay(runnable, TimeValue.timeValueMillis(10L), Names.SAME);
import org.opensearch.threadpool.Scheduler.Cancellable;
        assertFalse(runAfterDone.get());  
        final CountDownLatch doneLatch = new CountDownLatch(iterations);
                if (rethrow) {
        assertNotNull(cancellable);  
import static org.hamcrest.Matchers.sameInstance;
                    obj = future.get();
        future.futureDone(o);
        assertThat(resultingObject, sameInstance(o));
            if (rarely()) {  
            Names.GENERIC,
        };  
        if (rarely()) {
            }  
            }
            }
            // rarely throw an exception before counting down
            public ScheduledCancellable schedule(Runnable command, TimeValue delay, String executor) {
/*  
        final Object resultingObject = resultsFuture.get();
