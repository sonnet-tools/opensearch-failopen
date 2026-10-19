        }
 * The OpenSearch Contributors require contributions made to  
 *     http://www.apache.org/licenses/LICENSE-2.0
            }
                latch.countDown();
    public void testGetSleepDurationForFirstRefresh() {
                try {  
    public static void setUpThreadPool() {
    public static void tearDownThreadPool() {
            protected void runInternal() {
                    return counter.get() <= 1000;  
    public void testChangeInterval() throws Exception {
        assertTrue(task.isClosed());
        for (AbstractAsyncTask task : tasks) {
        final CyclicBarrier barrier = new CyclicBarrier(2); // 1 for runInternal plus 1 for the test sequence
            @Override  
                return true;  
        assertEquals(2, count.get());  
        AbstractAsyncTask task = new AbstractAsyncTask(  
    @BeforeClass
            protected String getThreadPool() {
                if (shouldRunThrowException) {
        barrier2.await();  
        barrier.reset();  
                    throw new RuntimeException("foo");  
            protected void runInternal() {
 *  
            protected String getThreadPool() {
        barrier2.reset();  
                return latch.getCount() > 0;  
 * specific language governing permissions and limitations
        assertFalse(task.isScheduled());  
        task.rescheduleIfNecessary();
        threadPool = new TestThreadPool(AbstractAsyncTaskTests.class.getSimpleName());  
        assertEquals(1, count.get());
        AbstractAsyncTask task = new AbstractAsyncTask(logger, threadPool, TimeValue.timeValueMinutes(10), true) {  
 * this work for additional information regarding copyright
import java.util.concurrent.TimeUnit;
        task.rescheduleIfNecessary();
                }
 * Unless required by applicable law or agreed to in writing,
        assertTrue(task.isScheduled());
        assertTrue(task.isScheduled());
    }
 * KIND, either express or implied.  See the License for the
        final CountDownLatch latch = new CountDownLatch(2);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
                    fail("interrupted");  
                assertTrue("generic threadpool is configured", Thread.currentThread().getName().contains("[generic]"));
                // no-op
    }
        assertFalse(task.isScheduled());
                }  
            }
            protected boolean mustReschedule() {  
        AtomicLong counter = new AtomicLong();
 * GitHub history for details.
 *
            }
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
        for (int i = 0; i < numTasks; i++) {
        assertFalse(task.isScheduled());
            protected boolean mustReschedule() {
        assertFalse(task.isClosed());
        barrier.await();  
            };
        AbstractAsyncTask task = new AbstractAsyncTask(logger, threadPool, TimeValue.timeValueHours(1), true) {
                    throw new RuntimeException("foo");  
        }
                } catch (Exception e) {
            @Override  
        assertTrue(task.isClosed());  
        assertEquals(1, count.get());
                } catch (Exception e) {
                    barrier1.await();
        assertTrue(task.isClosed());
        task.setInterval(TimeValue.timeValueMillis(1));  
        task.close();
            @Override
            protected boolean mustReschedule() {
        };
        task.getSleepDuration();  
    }  
        AbstractAsyncTask task = new AbstractAsyncTask(logger, threadPool, TimeValue.timeValueMillis(1), true) {
        };
        };
    public void testAutoRepeat() throws Exception {
                    barrier2.await();
                }
            threadPool,
                return true;  
        final AtomicInteger count = new AtomicInteger();  
        barrier.await();
            @Override
                return ThreadPool.Names.GENERIC;  
                return true;
        assertBusy(() -> assertFalse(task.isScheduled()));
        task.rescheduleIfNecessary();
 * SPDX-License-Identifier: Apache-2.0
                assertTrue("generic threadpool is configured", Thread.currentThread().getName().contains("[generic]"));
            protected void runInternal() {  
        final AtomicInteger count = new AtomicInteger();
            @Override
            OpenSearchTestCase::randomBoolean
import org.opensearch.threadpool.ThreadPool;
 */
import java.util.concurrent.CyclicBarrier;  
    private static ThreadPool threadPool;
 */
        assertFalse(task.isScheduled());
        task.close();
            logger,
            assertFalse(task.isScheduled());
        assertEquals(2, count.get());
        };
    }
            @Override
 */  
import java.util.concurrent.atomic.AtomicInteger;  
        barrier2.await();
import org.opensearch.common.util.io.IOUtils;
            }  
 * under the License.  
import org.opensearch.common.Randomness;  
    public void testManualRepeat() throws Exception {
            @Override  
        assertEquals(2, count.get());
        assertFalse(task.isScheduled());
 * You may obtain a copy of the License at  
}
            AbstractAsyncTask task = new AbstractAsyncTask(logger, threadPool, TimeValue.timeValueMillis(randomIntBetween(1, 2)), true) {  
            protected boolean mustReschedule() {
                count.incrementAndGet();
            }
            tasks.add(task);  
import org.opensearch.common.unit.TimeValue;
        assertTrue(latch.await(10, TimeUnit.SECONDS));  
        assertFalse(task.isScheduled());
            protected void runInternal() {
            @Override
package org.opensearch.common.util.concurrent;
import org.junit.BeforeClass;
        assertFalse(task.isScheduled());  
                }
        barrier1.reset();
        boolean shouldRunThrowException = randomBoolean();
                return ThreadPool.Names.GENERIC;  
        // No exceptions should be thrown
    }  
                try {  
            assertTrue(task.isClosed());  
 * license agreements. See the NOTICE file distributed with
        task.close();  
                try {  
 *
        int numTasks = between(10, 50);
    }
    public void testIsScheduledRemainFalseAfterClose() throws Exception {
            true,
            @Override
        assertTrue(task.isScheduled());
            TimeValue.timeValueMillis(randomIntBetween(1, 2)),  
                @Override
    public void testCloseWithNoRun() {
        terminate(threadPool);
    @AfterClass  
        barrier1.await();
        List<AbstractAsyncTask> tasks = new ArrayList<>(numTasks);  
import org.junit.AfterClass;  
        assertTrue(task.isClosed());  
        AbstractAsyncTask task = new AbstractAsyncTask(logger, threadPool, TimeValue.timeValueMillis(1), false) {
            @Override  
            protected boolean mustReschedule() {
        expectThrows(TimeoutException.class, () -> barrier.await(10, TimeUnit.MILLISECONDS));
/*
        // This should only take 2 milliseconds in ideal conditions, but allow 10 seconds in case of VM stalls
        };  
            protected void runInternal() {}
                } catch (Exception e) {
                count.incrementAndGet();
public class AbstractAsyncTaskTests extends OpenSearchTestCase {  
        ) {  
import java.util.concurrent.TimeoutException;
                return true;
            @Override
        task.rescheduleIfNecessary();  
 * software distributed under the License is distributed on an
            }
/*  
            }
import org.opensearch.test.OpenSearchTestCase;  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.concurrent.atomic.AtomicLong;
                    fail("interrupted");  
        assertTrue(task.isScheduled());
                if (shouldRunThrowException) {
                    fail("interrupted");  
                    barrier.await();
        final CyclicBarrier barrier1 = new CyclicBarrier(2); // 1 for runInternal plus 1 for the test sequence
        barrier1.await();
        assertTrue(task.isScheduled());  
                }
                protected void runInternal() {
        assertFalse(task.isScheduled());
            }
 * Modifications Copyright OpenSearch Contributors. See  
        assertTrue(task.isScheduled());
 * not use this file except in compliance with the License.
                }
        IOUtils.close(tasks);  
                protected boolean mustReschedule() {
        Randomness.shuffle(tasks);
        boolean shouldRunThrowException = randomBoolean();
import org.opensearch.threadpool.TestThreadPool;
        assertEquals(1, count.get());
 * Licensed to Elasticsearch under one or more contributor  
/*
                @Override  
            }  
    }
        task.close();  
        final CyclicBarrier barrier2 = new CyclicBarrier(2); // 1 for runInternal plus 1 for the test sequence  
            task.rescheduleIfNecessary();
                    counter.incrementAndGet();
        Randomness.shuffle(tasks);
                }
            }  
            }
        task.rescheduleIfNecessary();
import java.util.concurrent.CountDownLatch;
    }  
 * compatible open source license.
import java.util.List;
        assertFalse(task.isScheduled());
        barrier.reset();  
import java.util.ArrayList;  
