        taskQueue.advanceTime();
        assertThat(strings, contains("foo"));
    }
        final AtomicBoolean called = new AtomicBoolean();
        threadPool.schedule(() -> strings.add("also runnable"), TimeValue.MINUS_ONE, GENERIC);
import static org.hamcrest.Matchers.empty;
    }
        taskQueue.scheduleAt(taskQueue.getCurrentTimeMillis() - randomInt(200), () -> strings.add("foo"));
        );
    static DeterministicTaskQueue newTaskQueue() {
        assertThat(strings, contains("periodic-0", "periodic-1", "periodic-2"));
        assertFalse(taskQueue.hasRunnableTasks());
        assertFalse(taskQueue.hasRunnableTasks());
        final AtomicBoolean executed = new AtomicBoolean(false);
    public void testRunInTimeOrder() {
        }
 * the Apache License, Version 2.0 (the "License"); you may
        taskQueue.advanceTime();
 *
        return newTaskQueue(random());
 * this work for additional information regarding copyright
        assertFalse(taskQueue.hasDeferredTasks());
        }
        final AtomicBoolean executedNested = new AtomicBoolean(false);
    }
        final AtomicInteger counter = new AtomicInteger(0);
 * software distributed under the License is distributed on an
        final List<String> strings2 = getResultsOfRunningRandomly(new Random(266504691902226821L));
        assertThat(strings, containsInAnyOrder("foo", "bar"));
        assertTrue(taskQueue.hasRunnableTasks());
            taskQueue.runRandomTask();
    }
        assertThat(expectedEndTime, lessThanOrEqualTo(Math.max(startTime, nominalExecutionTime + variabilityMillis)));
        cancellable.cancel();
    }
        deterministicTaskQueue.setExecutionDelayVariabilityMillis(variabilityMillis);
        taskQueue.scheduleAt(executionTimeMillis3, () -> strings.add("baz"));
        final List<String> strings = new ArrayList<>(2);
        assertTrue(taskQueue.hasDeferredTasks());
        assertTrue(taskQueue.hasRunnableTasks());
        assertTrue(taskQueue.hasDeferredTasks());
        for (int i = 0; i < 100; i++) {
import static org.hamcrest.core.Is.is;
        assertThat(elapsedTime, greaterThan(0L)); // fails with negligible probability 2^{-100}
        deterministicTaskQueue.runAllTasks();
        taskQueue.scheduleAt(executionTimeMillis1, () -> strings.add("foo"));
            taskQueue.runRandomTask();
        assertTrue(taskQueue.hasDeferredTasks());
        final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
import static org.opensearch.node.Node.NODE_NAME_SETTING;
    public void testDoesNotDeferTasksForImmediateExecution() {
 */
        assertThat(taskQueue.getCurrentTimeMillis(), is(0L));
        assertThat(taskQueue.getCurrentTimeMillis(), is(0L));
import org.opensearch.threadpool.Scheduler;
        taskQueue.scheduleNow(() -> strings.add("foo"));
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        cancelledBeforeExecution.cancel();
import static org.hamcrest.Matchers.containsInAnyOrder;
/*
        }
        assertFalse(taskQueue.hasRunnableTasks());
        final DeterministicTaskQueue taskQueue = newTaskQueue();
            assertThat(executedNested.get(), is(true));
import org.opensearch.common.settings.Settings;
import org.opensearch.threadpool.ThreadPool;
 * this file be licensed under the Apache-2.0 license or a
        taskQueue.runRandomTask();
        final long executionTimeMillis2 = randomLongBetween(executionTimeMillis1 + 100, 300);
 * You may obtain a copy of the License at
        });
        taskQueue.runAllTasks();
        taskQueue.runRandomTask();
        advanceToRandomTime(taskQueue);
    public void testSameExecutor() {
        assertThat(strings, contains("periodic-0", "periodic-1", "periodic-2"));
        assertThat(strings, containsInAnyOrder("foo", "bar"));
            ""
        deterministicTaskQueue.runAllTasks();
        assertFalse(taskQueue.hasDeferredTasks());
        assertThat(strings, contains("foo", "bar"));
        final List<String> strings = new ArrayList<>(1);
        final long delayMillis = randomLongBetween(1, 100);
        assertTrue(taskQueue.hasDeferredTasks());
 * SPDX-License-Identifier: Apache-2.0
        taskQueue.runAllTasks();
            runnable.run();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertThat(taskQueue.getCurrentTimeMillis(), is(startTime + delayMillis));
        threadPool.generic().execute(() -> strings.add("foo"));
        assertThat(strings, empty());
        assertTrue(taskQueue.hasDeferredTasks());
        assertTrue(taskQueue.hasRunnableTasks());
 * under the License.
 * Unless required by applicable law or agreed to in writing,
import java.util.concurrent.atomic.AtomicBoolean;
    public void testDelayVariabilityAppliesToFutureTasks() {
 * not use this file except in compliance with the License.
    public void testThreadPoolEnqueuesTasks() {
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis1));
        taskQueue.scheduleAt(executionTimeMillis1, () -> strings.add("foo"));
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertThat(taskQueue.getCurrentTimeMillis(), is(0L));
        assertThat(strings, contains("foo", "baz", "bar"));
    public void testDefersTasksWithPositiveDelays() {
    public void testThreadPoolWrapsRunnable() {
        taskQueue.runRandomTask();
    }
        assertThat(strings, contains("foo"));
        advanceToRandomTime(deterministicTaskQueue);
            threadPool.executor(ThreadPool.Names.SAME).execute(() -> executedNested.set(true));
        threadPool.schedule(() -> strings.add("deferred"), TimeValue.timeValueMillis(delayMillis), GENERIC);
        taskQueue.runRandomTask();
        taskQueue.scheduleAt(executionTimeMillis1, () -> strings.add("foo"));
        assertTrue(taskQueue.hasRunnableTasks());
        assertFalse(taskQueue.hasRunnableTasks());
        final List<String> strings1 = getResultsOfRunningRandomly(new Random(4520795446362137264L));
import org.opensearch.test.OpenSearchTestCase;
        assertFalse(taskQueue.hasRunnableTasks());
        while (taskQueue.hasRunnableTasks()) {
        final List<String> strings = new ArrayList<>(4);
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis2));
        taskQueue.runRandomTask();
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertFalse(taskQueue.hasDeferredTasks());
    }
        taskQueue.scheduleAt(executionTimeMillis, () -> strings.add("foo"));
        assertTrue(taskQueue.hasRunnableTasks());
        return new DeterministicTaskQueue(Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random);
        return strings;
        assertTrue(taskQueue.hasRunnableTasks());
import org.opensearch.common.unit.TimeValue;
    public void testThreadPoolSchedulesFutureTasks() {
        taskQueue.advanceTime();
        final long variabilityMillis = randomLongBetween(1, 500);
        for (int i = 0; i < 100; i++) {
        assertFalse(called.get());
        final long elapsedTime = deterministicTaskQueue.getCurrentTimeMillis() - startTime;
        final ThreadPool threadPool = taskQueue.getThreadPool(runnable -> () -> {
            assertFalse(called.get());
        assertThat(taskQueue.getCurrentTimeMillis(), is(startTime + delayMillis + delayMillis1));
import java.util.Random;
        final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
import static org.hamcrest.Matchers.oneOf;
        assertThat(expectedEndTime, greaterThan(nominalExecutionTime)); // fails if every task has zero variability -- vanishingly unlikely
            () -> strings.add("periodic-" + counter.getAndIncrement()),
 *     http://www.apache.org/licenses/LICENSE-2.0
        });
        final List<String> strings = new ArrayList<>(5);
        assertFalse(taskQueue.hasRunnableTasks());
        taskQueue.advanceTime();
        threadPool.executor("anything").execute(() -> strings.add("bar"));
 * The OpenSearch Contributors require contributions made to
            cancelledDelay,
        taskQueue.advanceTime();
            GENERIC
 *
 */
        taskQueue.scheduleNow(() -> strings.add("foo"));
            taskQueue.runAllRunnableTasks();
        threadPool.generic().execute(() -> logger.info("runnable executed"));
        advanceToRandomTime(taskQueue);
package org.opensearch.cluster.coordination;
        final List<String> strings = new ArrayList<>(5);
        taskQueue.scheduleNow(() -> strings.add("quux"));
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertTrue(taskQueue.hasDeferredTasks());
        taskQueue.runAllTasks();
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis2));
        final ThreadPool threadPool = taskQueue.getThreadPool();
    }
    }
        threadPool.generic().execute(() -> {
        final long executionTimeMillis1 = randomLongBetween(1, 100);
        taskQueue.runAllRunnableTasks();
        taskQueue.scheduleNow(() -> strings.add("bar"));
    public void testRunRandomTaskVariesOrder() {
        taskQueue.runAllRunnableTasks();
        taskQueue.runRandomTask();
        final ThreadPool threadPool = taskQueue.getThreadPool();
        final long executionTimeMillis1 = randomLongBetween(1, 100);
    }
        assertFalse(taskQueue.hasRunnableTasks());
    private static DeterministicTaskQueue newTaskQueue(Random random) {
        assertTrue(taskQueue.hasDeferredTasks());
/*
        assertTrue(taskQueue.hasRunnableTasks());
            TimeValue.timeValueMillis(intervalMillis),
        assertTrue(taskQueue.hasDeferredTasks());
        final ThreadPool threadPool = taskQueue.getThreadPool();
        final long startTime = taskQueue.getCurrentTimeMillis();
        taskQueue.scheduleAt(executionTimeMillis2, () -> strings.add("bar"));
        assertFalse(taskQueue.hasDeferredTasks());
    public void testDoesNotDeferTasksScheduledInThePast() {
        taskQueue.advanceTime();
        assertTrue(taskQueue.hasRunnableTasks());
        );
            called.set(true);
        for (int i = 0; i < 3; ++i) {
}
            taskQueue.advanceTime();
        assertFalse(taskQueue.hasDeferredTasks());
import java.util.List;
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        final List<String> strings = new ArrayList<>(1);
        taskQueue.runRandomTask();
        assertTrue(called.get());
    public void testDelayVariabilityAppliesToImmediateTasks() {
        final List<String> strings = new ArrayList<>(3);
import static org.hamcrest.Matchers.equalTo;
    }
        final List<String> strings = new ArrayList<>(1);
        deterministicTaskQueue.setExecutionDelayVariabilityMillis(variabilityMillis);
    }
        assertFalse(taskQueue.hasRunnableTasks());
 * GitHub history for details.
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertTrue(taskQueue.hasDeferredTasks());
        taskQueue.runRandomTask();
    }
 * Licensed to Elasticsearch under one or more contributor
        assertThat(strings, empty());
    }
        assertThat(taskQueue.getCurrentTimeMillis(), is(0L));
        assertThat(strings, contains(oneOf("foo", "bar")));
        assertFalse(taskQueue.hasDeferredTasks());
        assertTrue(taskQueue.hasRunnableTasks());
        final List<String> strings = new ArrayList<>(2);
        final long expectedEndTime = deterministicTaskQueue.getLatestDeferredExecutionTime();
        assertFalse(taskQueue.hasDeferredTasks());
        final DeterministicTaskQueue deterministicTaskQueue = newTaskQueue();
        advanceToRandomTime(taskQueue);
        taskQueue.runAllTasksInTimeOrder();
        threadPool.schedule(() -> strings.add("not quite so deferred"), TimeValue.timeValueMillis(delayMillis2), GENERIC);
        taskQueue.scheduleAt(taskQueue.getCurrentTimeMillis(), () -> strings.add("foo"));
        final Scheduler.Cancellable cancelledBeforeExecution = threadPool.schedule(
        assertThat(deterministicTaskQueue.getCurrentTimeMillis(), is(expectedEndTime));
        assertThat(strings, contains("foo"));
    public void testThreadPoolSchedulesPeriodicFutureTasks() {
        assertTrue(taskQueue.hasDeferredTasks());
        threadPool.schedule(() -> strings.add("runnable"), TimeValue.ZERO, GENERIC);
        taskQueue.scheduleAt(executionTimeMillis2, () -> strings.add("bar"));
        assertThat(strings, containsInAnyOrder("foo", "bar", "baz", "quux"));
        final long delayMillis2 = randomLongBetween(1, delayMillis1 - 1);
        assertThat(strings, empty());
        assertTrue(taskQueue.hasRunnableTasks());
        final ThreadPool threadPool = taskQueue.getThreadPool();
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertThat(strings1, not(equalTo(strings2)));
        final long executionTimeMillis2 = randomLongBetween(executionTimeMillis1 + 1, 200);
    public void testRunRandomTask() {
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis3));
        final long intervalMillis = randomLongBetween(1, 100);
            deterministicTaskQueue.scheduleAt(nominalExecutionTime, () -> {});
        advanceToRandomTime(deterministicTaskQueue);
 * KIND, either express or implied.  See the License for the
        taskQueue.scheduleAt(executionTimeMillis2, () -> strings.add("bar"));
        final DeterministicTaskQueue deterministicTaskQueue = newTaskQueue();
        assertThat(strings, containsInAnyOrder("runnable", "also runnable", "deferred", "not quite so deferred", "further deferred"));
 *
        assertThat(strings, containsInAnyOrder("runnable", "also runnable", "deferred"));
import java.util.ArrayList;
        taskQueue.scheduleNow(() -> strings.add("bar"));
        assertFalse(taskQueue.hasRunnableTasks());
        final long nominalExecutionTime = randomLongBetween(0, 60000);
        final TimeValue cancelledDelay = TimeValue.timeValueMillis(randomLongBetween(1, 100));
            deterministicTaskQueue.scheduleNow(() -> {});
    }
        taskQueue.scheduleAt(randomLongBetween(1, 100), () -> {});
import static org.hamcrest.Matchers.contains;
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
        final long executionTimeMillis1 = randomLongBetween(1, 100);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final long variabilityMillis = randomLongBetween(100, 500);
        Scheduler.Cancellable cancellable = threadPool.scheduleWithFixedDelay(
    }
            executed.set(true);
        taskQueue.advanceTime();
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertFalse(taskQueue.hasRunnableTasks());
        assertFalse(taskQueue.hasRunnableTasks());
    public void testExecutesTasksInTimeOrder() {
    }
        taskQueue.runAllRunnableTasks();
 * ownership. Elasticsearch licenses this file to you under
            () -> strings.add("cancelled before execution"),
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis));
        }
        }
        assertTrue(taskQueue.hasDeferredTasks());
        final List<String> strings = new ArrayList<>(2);
            assertTrue(taskQueue.hasRunnableTasks());
        taskQueue.runRandomTask();
/*
        final long executionTimeMillis = randomLongBetween(1, 100);
        final DeterministicTaskQueue taskQueue = newTaskQueue();
    }
 * specific language governing permissions and limitations
    }
        threadPool.schedule(() -> strings.add("further deferred"), TimeValue.timeValueMillis(delayMillis1), GENERIC);
        assertThat(executed.get(), is(true));
        assertThat(strings, contains("foo"));
import static org.hamcrest.Matchers.not;
    private List<String> getResultsOfRunningRandomly(Random random) {
        assertThat(strings, contains("foo"));
    public void testKeepsFutureTasksDeferred() {
        while (taskQueue.hasRunnableTasks()) {
public class DeterministicTaskQueueTests extends OpenSearchTestCase {
        assertFalse(taskQueue.hasRunnableTasks());
import static org.hamcrest.Matchers.greaterThan;
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertFalse(taskQueue.hasRunnableTasks());
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        final long delayMillis1 = randomLongBetween(2, 100);
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis1));
        assertFalse(taskQueue.hasRunnableTasks());
        taskQueue.scheduleNow(() -> strings.add("baz"));
    }
        assertTrue(taskQueue.hasRunnableTasks());
 * Modifications Copyright OpenSearch Contributors. See
import static org.opensearch.threadpool.ThreadPool.Names.GENERIC;
    private void advanceToRandomTime(DeterministicTaskQueue taskQueue) {
        final long executionTimeMillis3 = randomLongBetween(executionTimeMillis1 + 1, executionTimeMillis2 - 1);
        final List<String> strings = new ArrayList<>(2);
        advanceToRandomTime(taskQueue);
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertThat(strings, contains("foo", "bar"));
        taskQueue.advanceTime();
        assertFalse(taskQueue.hasRunnableTasks());
        taskQueue.runRandomTask();
import java.util.concurrent.atomic.AtomicInteger;
    public void testStartsAtTimeZero() {
 */
        assertThat(elapsedTime, lessThanOrEqualTo(variabilityMillis));
        final long executionTimeMillis2 = randomLongBetween(executionTimeMillis1 + 1, 200);
        final DeterministicTaskQueue taskQueue = newTaskQueue(random);
        taskQueue.runRandomTask();
