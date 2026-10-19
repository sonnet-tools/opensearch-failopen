        assertTrue(taskQueue.hasRunnableTasks());
        assertTrue(called.get());  
 */  
import static org.hamcrest.Matchers.equalTo;  
 */  
        final long executionTimeMillis = randomLongBetween(1, 100);
        threadPool.executor("anything").execute(() -> strings.add("bar"));
        assertThat(taskQueue.getCurrentTimeMillis(), is(0L));  
        taskQueue.runAllRunnableTasks();
        taskQueue.advanceTime();
 * The OpenSearch Contributors require contributions made to  
        assertTrue(taskQueue.hasDeferredTasks());
        final DeterministicTaskQueue taskQueue = newTaskQueue();
    public void testSameExecutor() {
        final AtomicBoolean called = new AtomicBoolean();  
        final Scheduler.Cancellable cancelledBeforeExecution = threadPool.schedule(
        assertThat(elapsedTime, greaterThan(0L)); // fails with negligible probability 2^{-100}
import static org.hamcrest.core.Is.is;
 *
        final TimeValue cancelledDelay = TimeValue.timeValueMillis(randomLongBetween(1, 100));  
import java.util.List;
        taskQueue.runRandomTask();
        taskQueue.runAllTasks();  
    public void testExecutesTasksInTimeOrder() {
/*  
        taskQueue.scheduleAt(executionTimeMillis2, () -> strings.add("bar"));  
        advanceToRandomTime(taskQueue);
        final List<String> strings = new ArrayList<>(1);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        taskQueue.runRandomTask();
        assertThat(expectedEndTime, lessThanOrEqualTo(Math.max(startTime, nominalExecutionTime + variabilityMillis)));
        taskQueue.runRandomTask();
import static org.opensearch.node.Node.NODE_NAME_SETTING;
        final AtomicBoolean executed = new AtomicBoolean(false);
 * ownership. Elasticsearch licenses this file to you under  
    private List<String> getResultsOfRunningRandomly(Random random) {
        }
        assertThat(strings, contains("foo", "bar"));
        assertThat(strings, containsInAnyOrder("foo", "bar"));
        assertTrue(taskQueue.hasDeferredTasks());
    }
        assertTrue(taskQueue.hasDeferredTasks());
        assertThat(taskQueue.getCurrentTimeMillis(), is(0L));
        for (int i = 0; i < 100; i++) {  
 * Unless required by applicable law or agreed to in writing,
        assertFalse(taskQueue.hasDeferredTasks());  
        for (int i = 0; i < 100; i++) {  
        taskQueue.scheduleNow(() -> strings.add("bar"));
        assertTrue(taskQueue.hasRunnableTasks());
        assertTrue(taskQueue.hasDeferredTasks());
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis3));  
        deterministicTaskQueue.runAllTasks();
        assertFalse(taskQueue.hasDeferredTasks());
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertThat(expectedEndTime, greaterThan(nominalExecutionTime)); // fails if every task has zero variability -- vanishingly unlikely
        assertTrue(taskQueue.hasDeferredTasks());  
            deterministicTaskQueue.scheduleAt(nominalExecutionTime, () -> {});
    }  
            runnable.run();
import static org.hamcrest.Matchers.greaterThan;
        final List<String> strings = new ArrayList<>(5);
    public void testRunRandomTaskVariesOrder() {
        assertTrue(taskQueue.hasDeferredTasks());  
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertFalse(taskQueue.hasRunnableTasks());
        assertThat(strings, contains("foo"));
        final DeterministicTaskQueue taskQueue = newTaskQueue();
            taskQueue.runRandomTask();
        taskQueue.scheduleAt(executionTimeMillis3, () -> strings.add("baz"));  
        }
 * this work for additional information regarding copyright
        final DeterministicTaskQueue taskQueue = newTaskQueue();  
        advanceToRandomTime(taskQueue);
        taskQueue.runAllRunnableTasks();  
 * this file be licensed under the Apache-2.0 license or a
        final DeterministicTaskQueue deterministicTaskQueue = newTaskQueue();  
        assertTrue(taskQueue.hasRunnableTasks());
    public void testThreadPoolEnqueuesTasks() {  
        assertThat(strings, contains("foo"));
        assertFalse(taskQueue.hasRunnableTasks());
import org.opensearch.threadpool.Scheduler;
        assertThat(strings, contains("foo"));
        assertThat(strings, contains("foo"));
        final long nominalExecutionTime = randomLongBetween(0, 60000);
import static org.opensearch.threadpool.ThreadPool.Names.GENERIC;
    public void testDoesNotDeferTasksForImmediateExecution() {
        threadPool.generic().execute(() -> logger.info("runnable executed"));  
        assertTrue(taskQueue.hasRunnableTasks());  
    }  
        taskQueue.advanceTime();
import org.opensearch.common.unit.TimeValue;
        assertTrue(taskQueue.hasRunnableTasks());
 * Licensed to Elasticsearch under one or more contributor  
        assertFalse(taskQueue.hasRunnableTasks());  
        assertFalse(taskQueue.hasRunnableTasks());
    }
            threadPool.executor(ThreadPool.Names.SAME).execute(() -> executedNested.set(true));
        taskQueue.runRandomTask();
        });
        threadPool.schedule(() -> strings.add("not quite so deferred"), TimeValue.timeValueMillis(delayMillis2), GENERIC);
        taskQueue.advanceTime();
        final long startTime = taskQueue.getCurrentTimeMillis();  
        taskQueue.scheduleAt(randomLongBetween(1, 100), () -> {});  
    }  
    public void testThreadPoolSchedulesFutureTasks() {  
        final long delayMillis2 = randomLongBetween(1, delayMillis1 - 1);
        );
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        deterministicTaskQueue.runAllTasks();
 * GitHub history for details.
}
        assertTrue(taskQueue.hasRunnableTasks());  
    }
        final ThreadPool threadPool = taskQueue.getThreadPool();
        final ThreadPool threadPool = taskQueue.getThreadPool();
        while (taskQueue.hasRunnableTasks()) {  
        });
        taskQueue.advanceTime();
        assertFalse(called.get());
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(taskQueue.hasRunnableTasks());
        final DeterministicTaskQueue deterministicTaskQueue = newTaskQueue();
        final List<String> strings = new ArrayList<>(2);  
 * software distributed under the License is distributed on an
        final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
        taskQueue.runRandomTask();
        taskQueue.advanceTime();
        taskQueue.scheduleAt(executionTimeMillis2, () -> strings.add("bar"));
        assertTrue(taskQueue.hasDeferredTasks());  
        final List<String> strings = new ArrayList<>(2);
        threadPool.schedule(() -> strings.add("further deferred"), TimeValue.timeValueMillis(delayMillis1), GENERIC);  
        assertThat(strings, contains("foo"));
        assertThat(strings1, not(equalTo(strings2)));
        taskQueue.scheduleAt(executionTimeMillis1, () -> strings.add("foo"));
        taskQueue.scheduleAt(executionTimeMillis, () -> strings.add("foo"));  
package org.opensearch.cluster.coordination;
        assertTrue(taskQueue.hasRunnableTasks());  
    private static DeterministicTaskQueue newTaskQueue(Random random) {
    static DeterministicTaskQueue newTaskQueue() {
        final List<String> strings2 = getResultsOfRunningRandomly(new Random(266504691902226821L));
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis1));
        taskQueue.advanceTime();
    }
        assertThat(strings, containsInAnyOrder("runnable", "also runnable", "deferred"));
        assertFalse(taskQueue.hasRunnableTasks());
        final List<String> strings = new ArrayList<>(2);
        final ThreadPool threadPool = taskQueue.getThreadPool(runnable -> () -> {
        final long executionTimeMillis1 = randomLongBetween(1, 100);  
    }  
        final DeterministicTaskQueue taskQueue = newTaskQueue();  
        cancellable.cancel();  
        final List<String> strings = new ArrayList<>(4);
    }
        return strings;  
import org.opensearch.common.settings.Settings;
        final AtomicInteger counter = new AtomicInteger(0);
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        advanceToRandomTime(taskQueue);  
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertFalse(taskQueue.hasRunnableTasks());
        final DeterministicTaskQueue taskQueue = newTaskQueue();  
        assertThat(strings, contains(oneOf("foo", "bar")));
 *  
        final ThreadPool threadPool = taskQueue.getThreadPool();
        assertFalse(taskQueue.hasDeferredTasks());
        final List<String> strings = new ArrayList<>(5);
        assertTrue(taskQueue.hasDeferredTasks());  
        taskQueue.scheduleNow(() -> strings.add("foo"));
        return newTaskQueue(random());
        cancelledBeforeExecution.cancel();
        deterministicTaskQueue.setExecutionDelayVariabilityMillis(variabilityMillis);
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis2));  
        }
        while (taskQueue.hasRunnableTasks()) {
import static org.hamcrest.Matchers.contains;  
import static org.hamcrest.Matchers.empty;
import org.opensearch.threadpool.ThreadPool;
    }
        taskQueue.scheduleNow(() -> strings.add("baz"));
        advanceToRandomTime(deterministicTaskQueue);
        final List<String> strings = new ArrayList<>(1);
        assertThat(strings, contains("periodic-0", "periodic-1", "periodic-2"));
        Scheduler.Cancellable cancellable = threadPool.scheduleWithFixedDelay(
        final long executionTimeMillis3 = randomLongBetween(executionTimeMillis1 + 1, executionTimeMillis2 - 1);
        final long executionTimeMillis2 = randomLongBetween(executionTimeMillis1 + 1, 200);  
    }
            cancelledDelay,  
 * not use this file except in compliance with the License.
        assertThat(strings, contains("foo", "baz", "bar"));
    }  
        assertTrue(taskQueue.hasRunnableTasks());  
        assertThat(strings, containsInAnyOrder("foo", "bar"));  
 */
public class DeterministicTaskQueueTests extends OpenSearchTestCase {
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        deterministicTaskQueue.setExecutionDelayVariabilityMillis(variabilityMillis);
        assertFalse(taskQueue.hasRunnableTasks());
        taskQueue.scheduleAt(executionTimeMillis1, () -> strings.add("foo"));  
    }  
        assertFalse(taskQueue.hasRunnableTasks());
 * under the License.  
        assertThat(taskQueue.getCurrentTimeMillis(), is(0L));
        assertThat(strings, containsInAnyOrder("foo", "bar", "baz", "quux"));
    private void advanceToRandomTime(DeterministicTaskQueue taskQueue) {
        assertThat(elapsedTime, lessThanOrEqualTo(variabilityMillis));
        final DeterministicTaskQueue taskQueue = newTaskQueue();  
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < 3; ++i) {
        assertThat(strings, empty());
        final long executionTimeMillis2 = randomLongBetween(executionTimeMillis1 + 100, 300);
    public void testStartsAtTimeZero() {  
    public void testRunInTimeOrder() {
 * You may obtain a copy of the License at  
        threadPool.generic().execute(() -> {
    public void testRunRandomTask() {  
        final ThreadPool threadPool = taskQueue.getThreadPool();
import static org.hamcrest.Matchers.not;  
 * SPDX-License-Identifier: Apache-2.0
    public void testDefersTasksWithPositiveDelays() {
        taskQueue.runRandomTask();
        taskQueue.scheduleAt(executionTimeMillis2, () -> strings.add("bar"));
        assertFalse(taskQueue.hasRunnableTasks());
        taskQueue.runAllTasks();
            called.set(true);  
        final long startTime = deterministicTaskQueue.getCurrentTimeMillis();
        final long elapsedTime = deterministicTaskQueue.getCurrentTimeMillis() - startTime;  
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(taskQueue.hasDeferredTasks());
        final long variabilityMillis = randomLongBetween(1, 500);  
            taskQueue.advanceTime();
        assertTrue(taskQueue.hasDeferredTasks());
        assertFalse(taskQueue.hasRunnableTasks());
        taskQueue.runRandomTask();  
        threadPool.schedule(() -> strings.add("also runnable"), TimeValue.MINUS_ONE, GENERIC);
        assertFalse(taskQueue.hasDeferredTasks());
        taskQueue.runAllTasksInTimeOrder();
        assertTrue(taskQueue.hasRunnableTasks());
        taskQueue.advanceTime();
        taskQueue.runRandomTask();  
        }  
            ""
        assertTrue(taskQueue.hasDeferredTasks());
        assertFalse(taskQueue.hasRunnableTasks());  
        assertThat(deterministicTaskQueue.getCurrentTimeMillis(), is(expectedEndTime));
import org.opensearch.test.OpenSearchTestCase;  
        taskQueue.runAllTasks();
    }  
        assertThat(strings, containsInAnyOrder("runnable", "also runnable", "deferred", "not quite so deferred", "further deferred"));
        final long executionTimeMillis2 = randomLongBetween(executionTimeMillis1 + 1, 200);
            deterministicTaskQueue.scheduleNow(() -> {});
        final long delayMillis1 = randomLongBetween(2, 100);  
/*  
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis));  
        assertThat(strings, empty());
    }  
            taskQueue.runRandomTask();
        taskQueue.advanceTime();
            TimeValue.timeValueMillis(intervalMillis),
        assertThat(strings, empty());
 *
        threadPool.generic().execute(() -> strings.add("foo"));  
    public void testKeepsFutureTasksDeferred() {
        final List<String> strings = new ArrayList<>(3);
        taskQueue.runRandomTask();
        assertThat(executed.get(), is(true));
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis1));
import static org.hamcrest.Matchers.containsInAnyOrder;
            taskQueue.runAllRunnableTasks();
        assertFalse(taskQueue.hasDeferredTasks());
        taskQueue.scheduleAt(executionTimeMillis1, () -> strings.add("foo"));  
            assertTrue(taskQueue.hasRunnableTasks());  
        assertFalse(taskQueue.hasRunnableTasks());
        taskQueue.scheduleAt(taskQueue.getCurrentTimeMillis() - randomInt(200), () -> strings.add("foo"));
        threadPool.schedule(() -> strings.add("deferred"), TimeValue.timeValueMillis(delayMillis), GENERIC);
        assertFalse(taskQueue.hasRunnableTasks());
        taskQueue.runRandomTask();
        final DeterministicTaskQueue taskQueue = newTaskQueue(random);  
        assertThat(taskQueue.getCurrentTimeMillis(), is(startTime + delayMillis + delayMillis1));
        assertThat(strings, contains("foo", "bar"));  
        }
        assertThat(taskQueue.getCurrentTimeMillis(), is(startTime + delayMillis));  
import static org.hamcrest.Matchers.oneOf;
            () -> strings.add("periodic-" + counter.getAndIncrement()),  
    }
            GENERIC
/*
 * compatible open source license.
    }
        taskQueue.scheduleNow(() -> strings.add("foo"));  
        final List<String> strings1 = getResultsOfRunningRandomly(new Random(4520795446362137264L));  
        final List<String> strings = new ArrayList<>(2);
            assertFalse(called.get());
        final AtomicBoolean executedNested = new AtomicBoolean(false);  
        taskQueue.scheduleAt(taskQueue.getCurrentTimeMillis(), () -> strings.add("foo"));
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        final long expectedEndTime = deterministicTaskQueue.getLatestDeferredExecutionTime();  
    public void testThreadPoolWrapsRunnable() {
        assertThat(strings, contains("periodic-0", "periodic-1", "periodic-2"));
        assertFalse(taskQueue.hasRunnableTasks());  
    }  
        assertFalse(taskQueue.hasDeferredTasks());  
        return new DeterministicTaskQueue(Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build(), random);  
        taskQueue.scheduleNow(() -> strings.add("bar"));
            () -> strings.add("cancelled before execution"),
    public void testDelayVariabilityAppliesToFutureTasks() {
        advanceToRandomTime(taskQueue);  
            assertThat(executedNested.get(), is(true));  
    }
import java.util.ArrayList;
            executed.set(true);
        assertTrue(taskQueue.hasRunnableTasks());
        final long variabilityMillis = randomLongBetween(100, 500);
        final long delayMillis = randomLongBetween(1, 100);
        taskQueue.runRandomTask();  
        threadPool.schedule(() -> strings.add("runnable"), TimeValue.ZERO, GENERIC);
        assertThat(taskQueue.getCurrentTimeMillis(), is(executionTimeMillis2));
        assertFalse(taskQueue.hasDeferredTasks());
    }
        taskQueue.runAllRunnableTasks();  
        final long intervalMillis = randomLongBetween(1, 100);
import java.util.Random;  
 * KIND, either express or implied.  See the License for the
        advanceToRandomTime(deterministicTaskQueue);  
        final List<String> strings = new ArrayList<>(1);
 *     http://www.apache.org/licenses/LICENSE-2.0
        final DeterministicTaskQueue taskQueue = newTaskQueue();
        assertTrue(taskQueue.hasRunnableTasks());
import java.util.concurrent.atomic.AtomicInteger;
    public void testThreadPoolSchedulesPeriodicFutureTasks() {
        );  
        final long executionTimeMillis1 = randomLongBetween(1, 100);
    public void testDoesNotDeferTasksScheduledInThePast() {
        taskQueue.scheduleNow(() -> strings.add("quux"));  
 * specific language governing permissions and limitations
import java.util.concurrent.atomic.AtomicBoolean;
        final long executionTimeMillis1 = randomLongBetween(1, 100);  
    public void testDelayVariabilityAppliesToImmediateTasks() {
        assertThat(taskQueue.getCurrentTimeMillis(), is(0L));  
