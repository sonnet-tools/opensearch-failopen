            assertTrue(scheduled.cancel());
            );
/*
    private void scheduleAndCancel(ThreadPool threadPool, AtomicLong executed, String type) {
    }
                assertThat(job, Matchers.lessThan(previous));
 * under the License.
        return delays;
    public void testScheduledOnScheduler() throws InterruptedException {
 * not use this file except in compliance with the License.
            ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.stream.LongStream;
import org.opensearch.common.settings.Settings;
    public void testScheduleAtFixedRate() throws InterruptedException {
        );
        } finally {
        try {
import java.util.concurrent.ScheduledThreadPoolExecutor;
            assertEquals("Cancel must auto-remove", 0, executor.getQueue().size());
            List<Long> laterDelays = verifyJobDelays(jobs);
import java.util.concurrent.TimeUnit;
    }
    public void testCancelOnScheduler() {
            assertThat(laterDelays, Matchers.contains(initialDelays.stream().map(Matchers::lessThan).collect(Collectors.toList())));
        );
import java.util.concurrent.CountDownLatch;
        }
        try {
    public void testScheduledOnThreadPool() throws InterruptedException {
        assertTrue(scheduled.cancel());
                .forEach(type -> threadPool.schedule(missingExecutions::countDown, TimeValue.timeValueMillis(randomInt(5)), type));
import java.util.stream.Collectors;
                .mapToObj(delay -> threadPool.schedule(() -> {}, TimeValue.timeValueSeconds(delay), ThreadPool.Names.SAME))
import org.opensearch.common.unit.TimeValue;
 * license agreements. See the NOTICE file distributed with
        AtomicLong executed = new AtomicLong();
        List<Long> delays = new ArrayList<>(jobs.size());
        } finally {
            ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
 * Licensed to Elasticsearch under one or more contributor
                .collect(Collectors.toCollection(ArrayList::new));
                missingExecutions::countDown,
    private List<Long> verifyJobDelays(List<Scheduler.ScheduledCancellable> jobs) {
            executor.schedule(command, delay.millis(), TimeUnit.MILLISECONDS)
        CountDownLatch missingExecutions = new CountDownLatch(ThreadPool.THREAD_POOL_TYPES.keySet().size());
        }
                TimeValue.timeValueSeconds(20),
        ThreadPool threadPool = new TestThreadPool("test");
        CountDownLatch missingExecutions = new CountDownLatch(1);
        }
 */
        } finally {
 * specific language governing permissions and limitations
            Scheduler.terminate(executor, 10, TimeUnit.SECONDS);
/*
            ThreadPool.THREAD_POOL_TYPES.keySet().forEach(type -> scheduleAndCancel(threadPool, executed, type));
    }
import org.hamcrest.Matchers;
    public void testCancelOnThreadPool() {
                executed::incrementAndGet,
        try {
        } finally {
        Scheduler scheduler = (command, delay, name) -> Scheduler.wrapAsScheduledCancellable(
                assertThat(delay, Matchers.lessThan(previousDelay));
        Scheduler.ScheduledCancellable scheduled = threadPool.schedule(executed::incrementAndGet, TimeValue.timeValueSeconds(20), type);
 */
        return ((Scheduler.SafeScheduledThreadPoolExecutor) threadPool.scheduler()).getQueue().size();
        assertEquals(1, schedulerQueueSize(threadPool));
        }
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(1, executor.getQueue().size());
        ThreadPool threadPool = new TestThreadPool("test");
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(0, executed.get());
        } finally {
/*
            List<Long> initialDelays = verifyJobDelays(jobs);
                randomIntBetween(1, 10),
            assertTrue(scheduled.isCancelled());
        Scheduler scheduler = (command, delay, name) -> Scheduler.wrapAsScheduledCancellable(
            ThreadPool.THREAD_POOL_TYPES.keySet()
            Scheduler.terminate(executor, 10, TimeUnit.SECONDS);
        } finally {
        ThreadPool threadPool = new TestThreadPool("test");
import java.util.concurrent.atomic.AtomicLong;
            previous = job;
        assertTrue(scheduled.isCancelled());
            );
        ScheduledThreadPoolExecutor executor = Scheduler.initScheduler(Settings.EMPTY);
            assertEquals(0, executed.get());
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertTrue(missingExecutions.await(30, TimeUnit.SECONDS));
 * the Apache License, Version 2.0 (the "License"); you may
        }
                TimeUnit.MILLISECONDS
        }
            assertTrue(missingExecutions.await(30, TimeUnit.SECONDS));
        AtomicLong executed = new AtomicLong();
            Scheduler.ScheduledCancellable scheduled = scheduler.schedule(
        assertFalse(scheduled.isCancelled());
 * software distributed under the License is distributed on an
            CountDownLatch missingExecutions = new CountDownLatch(randomIntBetween(1, 10));
            executor.schedule(command, delay.millis(), TimeUnit.MILLISECONDS)
    }
    }
                ThreadPool.Names.SAME
                long previousDelay = previous.getDelay(TimeUnit.MILLISECONDS);
            scheduler.schedule(missingExecutions::countDown, TimeValue.timeValueMillis(randomInt(5)), ThreadPool.Names.SAME);
    }
        for (Scheduler.ScheduledCancellable job : jobs) {
        assertEquals("Cancel must auto-remove", 0, schedulerQueueSize(threadPool));
 * The OpenSearch Contributors require contributions made to
            Collections.reverse(jobs);
    public void testDelay() throws InterruptedException {
            if (previous != null) {
    private int schedulerQueueSize(ThreadPool threadPool) {
            assertFalse(scheduled.isCancelled());
 *
import java.util.ArrayList;
            ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        try {
 *
public class SchedulerTests extends OpenSearchTestCase {
            assertThat(job.getDelay(TimeUnit.SECONDS), Matchers.greaterThan(1L));
 * ownership. Elasticsearch licenses this file to you under
        try {
    // simple test for successful scheduling, exceptions tested more thoroughly in EvilThreadPoolTests
    }
package org.opensearch.threadpool;
            assertTrue(missingExecutions.await(30, TimeUnit.SECONDS));
            List<Scheduler.ScheduledCancellable> jobs = LongStream.range(20, 30)
            Thread.sleep(50);
 *
 */
            executor.scheduleAtFixedRate(
 * You may obtain a copy of the License at
                randomIntBetween(1, 10),
 * compatible open source license.
        ScheduledThreadPoolExecutor executor = Scheduler.initScheduler(Settings.EMPTY);
        ScheduledThreadPoolExecutor executor = Scheduler.initScheduler(Settings.EMPTY);
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
        }
import java.util.Collections;
}
            delays.add(job.getDelay(TimeUnit.NANOSECONDS));
    }
            assertThat(job.getDelay(TimeUnit.SECONDS), Matchers.lessThanOrEqualTo(30L));
    }
        Scheduler.ScheduledCancellable previous = null;
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
            }
import org.opensearch.test.OpenSearchTestCase;
                long delay = job.getDelay(TimeUnit.MILLISECONDS);
 * KIND, either express or implied.  See the License for the
    // simple test for successful scheduling, exceptions tested more thoroughly in EvilThreadPoolTests
        try {
            Scheduler.terminate(executor, 10, TimeUnit.SECONDS);
