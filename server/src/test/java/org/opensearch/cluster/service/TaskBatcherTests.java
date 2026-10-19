    }  
        final Semaphore allowProcessing = new Semaphore(0);  
        TaskExecutor executorA = new TaskExecutor();
            }
                    tasksBarrier.await();
 *
        TaskExecutor executorB = new TaskExecutor();  
        assert usedKeys.size() == numOfTasks;  
        submitTasks("test", tasks, ClusterStateTaskConfig.build(Priority.LANGUID), executor);  
import org.opensearch.cluster.ClusterStateTaskConfig;  
import org.opensearch.cluster.metadata.ProcessClusterEventTimeoutException;
            // submitting this task should be allowed, as it is new object.  
                            task.source,  
        @Override
                            }
            return id;
                    allowProcessing.acquire(tasks.size());
        public int getId() {
    public void testDuplicateSubmissionAfterTimeout() throws InterruptedException {  
        final CountDownLatch latch = new CountDownLatch(2);  
        private SimpleTask(int id) {
            public void onBeginProcessing(List<? extends TaskBatcher.BatchedTask> tasks) {  
        // wait for all executor threads to be ready
        barrier.await();
                                tasksBarrier.await();
                @Override
 * this work for additional information regarding copyright
        TestExecutor<SimpleTask> executor = tasks -> {};
                );
            }
            thread.start();
        }
import java.util.ArrayList;
        // wait for all executor threads to finish  
                () -> submitTask("second time", task1, ClusterStateTaskConfig.build(Priority.NORMAL), executor, listener)
            assertEquals(tasksSubmittedPerThread, executors[i].tasks.size());
                try {  
            @Override  
        startedProcessing.acquire(4);  
                failures.add(new Tuple<>(source, e));  
import java.util.List;
            });  
                }  
            return Integer.toString(id);
                        );  
import static org.hamcrest.Matchers.containsString;  
            // assert that total executed tasks is same for every executor as we initiated
        latch.await();  
import java.util.concurrent.BrokenBarrierException;
        class TaskExecutor implements TestExecutor<String> {  
            );  
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
            executors[i] = new TaskExecutor();
        try (BlockingTask blockingTask = new BlockingTask(Priority.IMMEDIATE)) {  
            }
            super(logger, threadExecutor, getMockListener());
 * ownership. Elasticsearch licenses this file to you under  
            submitTask("first time", task1, ClusterStateTaskConfig.build(Priority.NORMAL), executor, listener);  
        submitTask("0", "A0", config, executorA, noopListener);
        }
    @Before  
            UpdateTask(Priority priority, String source, Object task, TestListener listener, TestExecutor<?> executor) {
    @Override
        }
                    } else {  
                public void onFailure(String source, Exception e) {  
        }
 * Modifications Copyright OpenSearch Contributors. See
                                    "[" + index + "][" + taskNumber + "]",
        submitTask("4", "B4", config, executorB, noopListener);  
        private final int id;  
    private <T> void submitTasks(
            usedKeys.add(key);
        }
            }
            public void onSubmitFailure(List<? extends TaskBatcher.BatchedTask> tasks) {
            @Override
                @Override  
    }
        // wait for all threads to be ready
                taskBatcher.new UpdateTask(  
                } catch (InterruptedException | BrokenBarrierException e) {  
        SimpleTask task1 = new SimpleTask(1);
        CopyOnWriteArrayList<Tuple<String, Throwable>> failures = new CopyOnWriteArrayList<>();
                .execute(  
        CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);  
 * Unless required by applicable law or agreed to in writing,
                this.listener = listener;  
        final int numOfTasks = randomInt(10);  
        int tasksSubmittedPerThread = randomIntBetween(2, 128);  
            .stream()
        startedProcessing.acquire(1);
                public void processed(String source) {
            }  
            });  
import org.opensearch.common.collect.Tuple;  
        // it will create at most 8192 threads, which will cause native memory oom. so we limit the number of created threads.
            submitTask("blocking", blockingTask);
        final CountDownLatch timeOutLatch = new CountDownLatch(1);
/*  
        startedProcessing.acquire(2);
    protected TestTaskBatcher taskBatcher;
            int key = randomValueOtherThanMany(k -> usedKeys.contains(k), () -> randomInt(1024));
                public void processed(String source) {
            TestExecutor<SimpleTask> executor = tasks -> {};
            taskBatcher.onTimeoutInternal(tasks, TimeValue.ZERO);  
 * this file be licensed under the Apache-2.0 license or a
        };  
                }  
            submitTask("blocking", blockingTask);
            // references of both tasks are different.
                    }  
        }
                IllegalStateException.class,
            public void onTimeout(List<? extends TaskBatcher.BatchedTask> tasks) {
            @Override
                    throw new AssertionError(e);
    static class TaskExecutor implements TestExecutor<Integer> {
        final ClusterStateTaskConfig config = ClusterStateTaskConfig.build(Priority.NORMAL);
        final TestListener listener = new TestListener() {
                                submitTask(
                    }
                        int taskNumber = j;  
        // this blocks the cluster state queue, so we can set it up right
        final ClusterStateTaskConfig config,
 * SPDX-License-Identifier: Apache-2.0
            public void onFailure(String source, Exception e) {
        for (int i = 0; i < numberOfThreads; i++) {
        submitTask("2", "A2", config, executorA, noopListener);  
        assertThat(failures, empty());
    // test that for a single thread, tasks are executed in the order
                updateLatch.countDown();  
                    latch.countDown();
        assertThat(executionOrder, equalTo(Arrays.asList("A0")));
            // submitting same task2 again, it should throw exception, since it was submitted last time  
            executors[i] = new TaskExecutor();
            this.id = id;  
                        task -> ((UpdateTask) task).listener.onFailure(
        final TestExecutor<T> executor
        super.testTimedOutTaskCleanedUp();
            @Override
            }  
        submitTask("first time", task1, ClusterStateTaskConfig.build(Priority.NORMAL), executor, listener);  
                    throw new AssertionError(e);
    }
                    CyclicBarrier tasksBarrier = new CyclicBarrier(1 + tasksSubmittedPerThread);
            assertEquals(tasksSubmittedPerThread, executors[i].tasks.size());  
                    latch.countDown();  
        latch.await(); // wait till all tasks are not completed.
                // No Op
import java.util.concurrent.CountDownLatch;  
        for (int i = 0; i < numberOfThreads; i++) {
                        )
                IllegalStateException.class,
        // now release the processing
                }
import java.util.HashMap;
        }  
import org.junit.Before;  
            ArrayList<TaskBatcher.BatchedTask> tasks = new ArrayList();
        @Override
                                throw new AssertionError(e);
                assertEquals("cluster state update task executed out of order", j, (int) executors[i].tasks.get(j));
 * Licensed to Elasticsearch under one or more contributor  
        submitTask("5", "A5", config, executorA, noopListener);
        for (int i = 0; i < numberOfThreads; i++) {  
                startedProcessing.release(tasks.size());
        allowProcessing.release(1);  
    public void testOneExecutorDoesntStarveAnother() throws InterruptedException {
            @Override
            @Override
            SimpleTask task1 = new SimpleTask(1);
                    throw new RuntimeException(e);  
        submitTask("3", "B3", config, executorB, noopListener);
        }
            };
        TaskExecutor[] executors = new TaskExecutor[numberOfThreads];  
        final TestListener noopListener = (source, e) -> { throw new AssertionError(e); };  
                    barrier.await();
            TestExecutor<SimpleTask> executor = tasks -> {};  
import java.util.function.Function;  
        }
            assertTrue("expected empty map but was " + taskBatcher.tasksPerBatchingKey, taskBatcher.tasksPerBatchingKey.isEmpty());  
            public void onBeginSubmit(List<? extends TaskBatcher.BatchedTask> tasks) {
        return new TaskBatcherListener() {  
 */
        @Override
                    tasksBarrier.await();
 *
        final CountDownLatch latch = new CountDownLatch(2);
                    // wait for all task threads to finish  
                try {  
        try (BlockingTask blockingTask = new BlockingTask(Priority.IMMEDIATE)) {
            @Override
        for (int i = 0; i < numberOfThreads; i++) {
                @Override
        submitTask("6", "A6", config, executorA, noopListener);  
                logger.error(() -> new ParameterizedMessage("unexpected failure: [{}]", source), e);
            assertThat(taskList.stream().collect(Collectors.toSet()), equalTo(tasks.keySet()));
 * license agreements. See the NOTICE file distributed with
                    () -> tasks.forEach(
 * under the License.  
            final int index = i;
        updateLatch.await();  
import java.util.stream.Collectors;
                        taskThread.start();
    public void testDuplicateSubmission() throws InterruptedException {
import java.util.concurrent.CyclicBarrier;
    public void testTasksAreExecutedInOrder() throws BrokenBarrierException, InterruptedException {
                );
            @Override
            timeOutLatch.await(); // wait for task to get timeout
        @Override
        }  
    }  
            }
            SimpleTask task1 = new SimpleTask(1);
    public void setUpBatchingTaskExecutor() throws Exception {
    protected void submitTask(String source, TestTask testTask) {
    protected static TaskBatcherListener getMockListener() {
            submitTask("third time a charm", task2, ClusterStateTaskConfig.build(Priority.NORMAL), executor, listener);
            return this.id;
    public void testSingleBatchSubmission() throws InterruptedException {
                        timeOutLatch.countDown();
                updateLatch.countDown();  
            tasks.add(
                        Thread taskThread = new Thread(() -> {
            assertTrue(task1.equals(task2));  
                executionOrder.addAll(tasks); // do this first, so startedProcessing can be used as a notification that this is done.
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.util.concurrent.PrioritizedOpenSearchThreadPoolExecutor;
    private static class SimpleTask {
        }
        };
            );
                }
 * software distributed under the License is distributed on an
        }  
            final int index = i;  
                            "[" + index + "][" + j + "]",
        // wait for last task to be processed
                    ClusterStateTaskConfig.build(Priority.NORMAL).priority(), "first time", task1, listener, executor
        firstTaskLatch.await(); // wait till task is not executed  
        assertThat(failures, empty());
}
            final TestListener listener;
        }  
                            j,
import static org.hamcrest.Matchers.hasToString;  
 */  
            // submitting same task1 again, it should throw exception.
            updateTasks.forEach(updateTask -> updateTask.listener.processed(updateTask.source));  
import java.util.Arrays;  
        public void execute(List<Integer> tasks) {  
        }  
 * The OpenSearch Contributors require contributions made to  
            Thread thread = new Thread(() -> {
                            ClusterStateTaskConfig.build(randomFrom(Priority.values())),  
    }  
                failures.add(new Tuple<>(source, e));
        // release the first 0 task, but not the second
        int tasksSubmittedPerThread = randomIntBetween(2, 128);
                } else {
public class TaskBatcherTests extends TaskExecutorTests {
                public void onFailure(String source, Exception e) {
            public void processed(String source) {
import java.util.concurrent.CopyOnWriteArrayList;
package org.opensearch.cluster.service;
        final CountDownLatch latch = new CountDownLatch(numOfTasks);
        List<TestTaskBatcher.UpdateTask> safeTasks = tasks.entrySet()
                super(priority, source, executor, task);
            public void execute(List<String> tasks) {  
                    // wait for all task threads to be ready
        for (int i = 0; i < numberOfThreads; i++) {
import java.util.Collections;
                latch.countDown();
    private <T> void submitTask(String source, T task, ClusterStateTaskConfig config, TestExecutor<T> executor, TestListener listener) {  
        }
                    throw new AssertionError(e);
                @Override  
                updateLatch.countDown();
        List<Integer> tasks = new ArrayList<>();  
                return ((TestExecutor<Object>) batchingKey).describeTasks(
        CopyOnWriteArrayList<Tuple<String, Throwable>> failures = new CopyOnWriteArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            };
                        });  
        final CountDownLatch latch = new CountDownLatch(2);
import java.util.concurrent.Semaphore;
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(latch.getCount(), equalTo(2L));
        // wait for all threads to finish  
        latch.await();
                    )  
 * You may obtain a copy of the License at  
import java.util.HashSet;  
            .collect(Collectors.toList());
        for (int i = 0; i < numberOfThreads; i++) {
            TestListener listener = new TestListener() {
        }  
            public void onFailure(String source, Exception e) {
            public void onFailure(String source, Exception e) {  
    @Override
        synchronized (taskBatcher.tasksPerBatchingKey) {
                if (e instanceof ProcessClusterEventTimeoutException) {  
import org.apache.logging.log4j.message.ParameterizedMessage;
        barrier.await();
                        throw new AssertionError(e);
            }
        final List<String> executionOrder = Collections.synchronizedList(new ArrayList<>());
        final String source,
    public void testTimedOutTaskCleanedUp() throws Exception {  
        CountDownLatch updateLatch = new CountDownLatch(numberOfThreads * tasksSubmittedPerThread);
    }  
                @Override  
            });  
                public void processed(String source) {
 */  
            submitTask("first time", task1, ClusterStateTaskConfig.build(Priority.NORMAL), executor, listener);  
        }  
            assertFalse(task1 == task2);
            public String describeTasks(List<? extends BatchedTask> tasks) {
        int numberOfThreads = randomIntBetween(2, 8);
                    barrier.await();
                            listener
            public void processed(String source) {
                    latch.countDown();
                // No Op  
            // task1 got timed out, it will be removed from map.
        }
                logger.error(() -> new ParameterizedMessage("unexpected failure: [{}]", source), e);
                        submitTask(  
                }
        for (int i = 0; i < numOfTasks; i++) {  
                }
                    if (e instanceof ProcessClusterEventTimeoutException) {
                    barrier.await();  
                public void onFailure(String source, Exception e) {  
                                );
            );  
                firstTaskLatch.countDown();  
        public int hashCode() {
        int numberOfThreads = randomIntBetween(2, 8);
 * not use this file except in compliance with the License.
                            try {
        barrier.await();
                    throw new AssertionError(e);  
            }
    }
                            } catch (InterruptedException | BrokenBarrierException e) {  
            @Override  
import org.opensearch.common.unit.TimeValue;
        assertThat(executionOrder, equalTo(Arrays.asList("A0", "A1", "A2")));
            // inserting new task with same data, this should pass as it is new object and reference is different.  
        };
 * compatible open source license.
                }
                @Override
                            executors[index],
            for (int j = 0; j < tasksSubmittedPerThread; j++) {  
        TaskExecutor[] executors = new TaskExecutor[numberOfThreads];  
            ((TestExecutor) batchingKey).execute(updateTasks.stream().map(t -> t.task).collect(Collectors.toList()));
        latch.await();  
        @Override  
/*
 * GitHub history for details.
            assertThat(latch.getCount(), equalTo(2L));
    }
                    tasks.stream().map(BatchedTask::getTask).collect(Collectors.toList())  
            SimpleTask task2 = new SimpleTask(1);
        barrier.await();
        Map<Integer, TestListener> tasks = new HashMap<>();
        public String toString() {  
        protected void run(Object batchingKey, List<? extends BatchedTask> tasks, Function<Boolean, String> taskSummaryGenerator) {  
            @Override  
        TestExecutor<Integer> executor = taskList -> {
                // No Op  
        }
        };
        TestTaskBatcher(Logger logger, PrioritizedOpenSearchThreadPoolExecutor threadExecutor) {
import java.util.Map;
            tasks.put(key, new TestListener() {
        assertThat(executionOrder, equalTo(Arrays.asList("A0", "A1", "A2", "B3", "B4", "A5", "A6")));
        // wait to be processed  
                // No Op
                } catch (InterruptedException | BrokenBarrierException e) {  
        final Map<T, TestListener> tasks,  
    }
            threadPool.generic()
                    throw new AssertionError(e);
                        // submit tasks per batchingKey in parallel
        };
import static org.hamcrest.Matchers.empty;
            final IllegalStateException e2 = expectThrows(
            submitTask("first time", task1, ClusterStateTaskConfig.build(Priority.NORMAL), executor, listener);  
        taskBatcher = new TestTaskBatcher(logger, threadExecutor);
            .map(e -> taskBatcher.new UpdateTask(config.priority(), source, e.getKey(), e.getValue(), executor))  
        submitTask("1", "A1", config, executorA, noopListener);
                }  
                }
                    for (int j = 0; j < tasksSubmittedPerThread; j++) {
        allowProcessing.release(6);  
        final TestListener listener = new TestListener() {
import org.opensearch.common.Priority;
            assertThat(e, hasToString(containsString("task [1] with source [second time] is already queued")));
                try {
import static org.hamcrest.Matchers.equalTo;
        // these will be the first batch
            }
                () -> submitTask("second time", task2, ClusterStateTaskConfig.build(Priority.NORMAL), executor, listener)  
 *  
            assertThat(taskList.size(), equalTo(tasks.size()));  
    }
/*  
        public boolean equals(Object obj) {  
            List<UpdateTask> updateTasks = (List) tasks;
        taskBatcher.submitTasks(safeTasks, config.timeout());
        class UpdateTask extends BatchedTask {
            final IllegalStateException e = expectThrows(  
        submitTask("first time", task1, ClusterStateTaskConfig.build(Priority.NORMAL), executor, listener);
        final Semaphore startedProcessing = new Semaphore(0);
                } catch (InterruptedException e) {
    static class TestTaskBatcher extends TaskBatcher {
            }  
            return ((SimpleTask) obj).getId() == this.id;
            // equals method returns true for both task
            Thread thread = new Thread(() -> {
                }  
                                tasksBarrier.await();  
    }  
    }
        // setup the queue with pending tasks for another executor same priority
                    barrier.await();
            public void processed(String source) {
        protected void onTimeout(List<? extends BatchedTask> tasks, TimeValue timeout) {
                                    executors[index],
            // submitting same task1 again, it should get submitted, since last task was timeout.
    }
    public void testNoTasksAreDroppedInParallelSubmission() throws BrokenBarrierException, InterruptedException {
        // submitting same task1 again, it should get submitted, since last task was executed.
 *     http://www.apache.org/licenses/LICENSE-2.0
                    latch.countDown();
            @Override  
    }  
    }  
                    }
            this.tasks.addAll(tasks);
            thread.start();
        submitTasks(source, Collections.singletonMap(task, listener), config, executor);
    ) {  
                                    listener  
            assertThat(e2, hasToString(containsString("task [1] with source [second time] is already queued")));
            TestListener listener = new TestListener() {  
                )
        @Override  
import java.util.Set;  
                assertNotNull(executors[i].tasks.get(j));
        final CountDownLatch firstTaskLatch = new CountDownLatch(1);
    public void testDuplicateSubmissionAfterExecution() throws InterruptedException {  
        updateLatch.await();  
        }
                            new ProcessClusterEventTimeoutException(timeout, task.source)
import org.apache.logging.log4j.Logger;
                updateLatch.countDown();
                                    taskNumber,  
            }
                    for (int j = 0; j < tasksSubmittedPerThread; j++) {
        Set<Integer> usedKeys = new HashSet<>(numOfTasks);
            }
    }  
        submitTask(source, testTask, testTask, testTask, testTask);  
        }
        TestListener listener = new TestListener() {  
            @Override
 * specific language governing permissions and limitations
            }
                                    ClusterStateTaskConfig.build(randomFrom(Priority.values())),
    // that they are submitted  
        CountDownLatch updateLatch = new CountDownLatch(numberOfThreads * tasksSubmittedPerThread);  
