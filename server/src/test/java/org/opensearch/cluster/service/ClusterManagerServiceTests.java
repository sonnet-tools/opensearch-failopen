                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
        int numberOfThreads = randomIntBetween(2, 8);
                    "test4",
    public void testUpdateTaskThreadName() {
 * Licensed to Elasticsearch under one or more contributor
        });
            @Override
                        latch.countDown();
                    "took [4s] to notify listeners on successful publication of cluster state (version: *, uuid: *) for [test3]"
                this.taskGroups = taskGroups;
                    "test1 should log due to slow and failing publication",
    @TestLogging(value = "org.opensearch.cluster.service:TRACE", reason = "to ensure that we log cluster state events on TRACE level")
            }
import org.opensearch.common.collect.Tuple;
                    "node1",
                    public ClusterState execute(ClusterState currentState) {
                    public TimeValue ackTimeout() {
                    publishListener.onResponse(null);
                    @Override
                    DiscoveryNodes.builder().add(node1).add(node2).add(node3).localNodeId(node1.getId()).clusterManagerNodeId(node1.getId())
                    @Override
            // check that we timeout if commit took too long
            }
            );
            );
                    }
                    }
        Task2Executor executor2 = new Task2Executor();
    public void testClusterStateTaskListenerThrowingExceptionIsOkay() throws InterruptedException {
                )
        final CountDownLatch latch = new CountDownLatch(1);
                    Level.DEBUG,
                    @Override
                } else if (source.equals(task2.getKey())) {
                assertBusy(() -> assertEquals(1, clusterManagerService.getClusterStateStats().getUpdateSuccess()));
                    @Override
     */
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        final CountDownLatch updateLatch = new CountDownLatch(totalTaskCount);
                @Override
 * under the License.
            );
                    }
            );
                    .clusterManagerNodeId(makeClusterManager ? localNode.getId() : null)
                    public void onFailure(String source, Exception e) {
        int throttlingLimitForTask3 = randomIntBetween(1, 5);
                    );
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    public void onFailure(String source, Exception e) {
import java.util.concurrent.atomic.AtomicReference;
                clusterManagerService.submitStateUpdateTask("test4", new ClusterStateUpdateTask() {
                    ClusterManagerService.class.getCanonicalName(),
            }
                    new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
                                );
                final DiscoveryNode localNode = new DiscoveryNode(
                new MockLogAppender.SeenEventExpectation(
        final Histogram clusterStatePublishHistogram = mock(Histogram.class);
    }
                    semaphore.acquire();
                    .localNodeId(localNode.getId())
                    ClusterManagerService.class.getCanonicalName(),
            clusterManagerService.setClusterStateSupplier(() -> initialClusterState);
    public void testClusterStateBatchedUpdates() throws BrokenBarrierException, InterruptedException {
                    threadPool,
                final ClusterState initialClusterState = ClusterState.builder(
    private ClusterManagerService createClusterManagerService(boolean makeClusterManager) {
                }
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}
                new MockLogAppender.SeenEventExpectation(
            );
 * KIND, either express or implied.  See the License for the
                ClusterManagerService clusterManagerService = new ClusterManagerService(
        latch.await();
                    public ClusterState execute(ClusterState currentState) {
            final ClusterStateTaskExecutor<Object> executor = (currentState, tasks) -> ClusterStateTaskExecutor.ClusterTasksResult.builder()
            try {
                return throttlingKey1;
                // We don't check logging for this on since there is no guarantee that it will occur before our check
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_INDEX;
 *
        if (threadPool != null) {
                });
                    "test1 notification",
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = clusterManagerService.registerClusterManagerTask(task, true);
        final DiscoveryNode node3 = new DiscoveryNode("node3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
     * Returns the cluster state that the cluster-manager service uses (and that is provided by the discovery layer)
            }));
                        fail();
                taskFailed[0] = true;
                        fail();
                    @Override
                public TimeValue timeout() {
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                new MockLogAppender.SeenEventExpectation(
            }
                        }
            barrier.await();
            clusterManagerService = new ClusterManagerService(
                            listener
            @Override
            try (
                            if (tasks.size() == 1) {
            );
                    failureCount.incrementAndGet();
        timeDiffInMillis = randomLongBetween(0L, 1L << 50);
                this.id = id;
                DiscoveryNodes.builder()
                    "took [1s] to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test1]"
                    public ClusterState execute(ClusterState currentState) {
                for (Set<Task> expectedSet : taskGroups) {
        };
            }
    }
            }
    }
import static org.hamcrest.Matchers.is;
                        timeDiffInMillis += TimeValue.timeValueSeconds(2).millis();
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
                    try {
                    try {
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
                }
                task.getKey(),
        final AtomicReference<AssertionError> assertionRef = new AtomicReference<>();
                        return ClusterTasksResult.builder().successes(tasks).build(newClusterState);
        final AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialClusterState);
                ClusterStateTaskConfig.build(randomFrom(Priority.values()), TimeValue.timeValueMillis(1L)),
        int taskId = 0;
                    public ClusterState execute(ClusterState currentState) {
                    (clusterChangedEvent, publishListener, ackListener) -> publishListener.onFailure(
                    "node1",
                    "test1 start",
                        for (int j = 0; j < taskSubmissionsPerThread; j++) {
                @Override
                .build();
                )
            );
        for (int i = 0; i < numberOfThreads; i++) {
            @Override
                new MockLogAppender.SeenEventExpectation(
                    Level.WARN,
        };
            @Override
                    }
                        published.set(true);
                    latch.countDown();
                if (randomBoolean()) {
                    }
                        timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(
            }
                    "test1 start",
                    tasks.add(new Task(taskId++));
                    public ClusterTasksResult<Object> execute(ClusterState currentState, List<Object> tasks) {
                    @Override
                    "test4",
                latch2.countDown();
        clusterManagerService.close();
                    public void onFailure(String source, Exception e) {
                ClusterStateTaskConfig.build(randomFrom(Priority.values())),
                    public void onFailure(String source, Exception e) {}
                    assertEquals((int) counts.get(executor), executor.counter.get());
                    @Override
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX;
import java.util.HashMap;
                            ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(Settings.EMPTY).millis()
        Thread.currentThread().setName("test not cluster manager update thread");
    ) {
                new MockLogAppender.SeenEventExpectation(
                Set<Task> tasks = new HashSet<>();
                latch2.countDown();
                    }
        clusterManagerService.start();
                if (this == o) {
                    Level.DEBUG,
                    }
            @Override
            mockAppender.addExpectation(
                threadPool,
                        blockingTaskLatch.await();
                new MockLogAppender.SeenEventExpectation(
        clusterManagerService.close();
                    Level.WARN,
    }
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}
            .build();
        assertThat(ClusterManagerService.assertClusterManagerUpdateThread(), is(Boolean.TRUE));
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                // Additional update task to make sure all previous logging made it to the loggerName
                updateLatch.countDown();
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        final MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        timeDiffInMillis += randomLongBetween(
                        .put(Node.NODE_NAME_SETTING.getKey(), "test_node")
                        throw new AssertionError(e);
    public void testClusterStateUpdateLoggingWithTraceEnabled() throws Exception {
                )
                    protected Void newResponse(boolean acknowledged) {
import org.junit.BeforeClass;
                        "batched set should be executed together or not at all. Expected " + expectedSet + "s. Executing " + tasks,
            public void execute() {
            @Override
            @Override
            try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
            // assert the correct number of clusterStateProcessed events were triggered
                        fail();
                    } catch (ClusterManagerThrottlingException e) {
            final TimeValue ackTimeout = randomBoolean() ? TimeValue.ZERO : TimeValue.timeValueMillis(randomInt(10000));
                    public ClusterState execute(ClusterState currentState) {
                @Override
                    assertTrue(threadPool.getThreadContext().isSystemContext());
                    @Override
                    @Override
                    fail("Unexpected success");
        }
                    new ClusterName(ClusterManagerServiceTests.class.getSimpleName())
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
import java.util.Optional;
                public void onFailure(String source, Exception e) {
        ClusterManagerTask task2 = PUT_MAPPING;
import org.opensearch.OpenSearchException;
                    public void onFailure(String source, Exception e) {
                )
            );
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    @Override
                    public void onFailure(String source, Exception e) {
            mockAppender.addExpectation(
                // verify stats values after state is published
                    ).millis() + randomLongBetween(1, 1000000);
                        timeDiffInMillis += TimeValue.timeValueSeconds(4).millis();
                    "test3",
import static org.mockito.Mockito.verify;
                    }
                )
                    latch.countDown();
            );
                    "test3 start",
            @Override
                clusterManagerService.setClusterStateSupplier(clusterStateRef::get);
                clusterManagerService.setClusterStateSupplier(clusterStateRef::get);
                    @Override
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
                )
                    }
                    }
            TaskExecutor(List<Set<Task>> taskGroups) {
    }
                    Level.TRACE,
                Thread.sleep(randomInt(1000));
import static org.mockito.Mockito.times;
            mockAppender.addExpectation(
 * not use this file except in compliance with the License.
        final ClusterState initialClusterState = ClusterState.builder(new ClusterName(ClusterManagerServiceTests.class.getSimpleName()))
        // we have one task in execution and tasks in queue so next task should throttled.
        List<Thread> threads = new ArrayList<Thread>();
                    assertFalse(threadPool.getThreadContext().isSystemContext());
                                    threadName,
                        .build(),
                assertBusy(() -> assertEquals(0, clusterManagerService.getClusterStateStats().getUpdateFailed()));
            {
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        int taskSubmissionsPerThread = randomIntBetween(1, 64);
                    }
                )
            String histogramName = (String) invocationOnMock.getArguments()[0];
            }
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        return TimeValue.ZERO;
                        fail();
                        count,
            }
        final boolean[] taskFailed = { false };
                        fail();
                new MockLogAppender.SeenEventExpectation(
                    }
                    listener
                );
                    Level.DEBUG,
                    return clusterManagerTimeout;
                    @Override
        try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
                    @Override
                    public void onFailure(String source, Exception e) {
                listener
                new MockLogAppender.SeenEventExpectation(
                @Override
                    }
                    succeededTask1.incrementAndGet();
                    @Override
                        };
                    "test1 computation",
                ClusterStateTaskConfig.build(randomFrom(Priority.values())),
                    "test3 notification",
        assertEquals(numberOfTask2, succeededTask2.get());
                public TimeValue ackTimeout() {
                            Settings.EMPTY
            );
            threads.add(new Thread(new Runnable() {
                    .build();
                });
        });
        AtomicInteger timedOutTask3 = new AtomicInteger();
            }
        int totalTaskCount = 0;
        for (int i = 0; i < numberOfExecutors; i++) {
                    Level.WARN,
            );
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;
        ClusterManagerService clusterManagerService = createClusterManagerService(true);
                assignments.add(Tuple.tuple(executor, tasks));
                }
                        } catch (AssertionError e) {
                });
        int throttlingLimitForTask2 = randomIntBetween(1, 5);
                        return null;
            try (
                    public ClusterState execute(ClusterState currentState) {
                    submittedTasksPerThread.get(entry.getKey()).get()
                    latch.countDown();
            );
                    public ClusterState execute(ClusterState currentState) {
                    }
    public void testClusterStateUpdateLoggingWithDebugEnabled() throws Exception {
            );
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
    }
                });
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_MAPPING;
                    @Override
                    succeededTask3.incrementAndGet();
        final Histogram clusterStateComputeHistogram = mock(Histogram.class);
                            Settings.EMPTY
        Task1Executor executor1 = new Task1Executor();
            }
        final CountDownLatch latch2 = new CountDownLatch(1);
                        throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");
                public void onFailure(String source, Exception e) {
                    @Override
                new MockLogAppender.UnseenEventExpectation(
                "testResponse",
        int throttlingLimit = randomIntBetween(1, 10);
                        return currentState;
                        ).millis() + randomLongBetween(1, 1000000);
                                    threadName,
                            executor3,
            );
                        return null;
            mockAppender.addExpectation(
                });
                assertEquals(task3.getKey(), source);
                        return currentState;
                latch.await();
                    public TimeValue timeout() {
                    executor,
                        return currentState;
        verify(clusterStateComputeHistogram, times(1)).record(anyDouble(), any());
                clusterManagerService.submitStateUpdateTask("test6", new ClusterStateUpdateTask() {
        try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
        ) {
                    ClusterManagerService.class.getCanonicalName(),
                    ackListener.onCommit(TimeValue.timeValueMillis(ackTimeout.millis() + randomInt(100)));
                    public void onFailure(String source, Exception e) {}
 */
                return throttlingKey2;
                        .build(),
            .nodes(
                    Level.DEBUG,
                    ClusterManagerService.class.getCanonicalName(),
                        latch.countDown();
                        fail();
                    public ClusterState execute(ClusterState currentState) {
                clusterManagerService.start();
                final CountDownLatch latch = new CountDownLatch(1);
                new ClusterStateTaskListener() {
    public void testClusterManagerAwareExecution() throws Exception {
            }
                public void onFailure(String source, Exception e) {
            }
                    public void onFailure(String source, Exception e) {
            }
            final CountDownLatch taskStartLatch = new CountDownLatch(1);
                    }
import java.util.List;
    * test that a listener throwing an exception while handling a
import java.util.Map;
            mockAppender.addExpectation(
import org.opensearch.cluster.ClusterStateUpdateTask;
                    Level.TRACE,
        class Task2Executor implements ClusterStateTaskExecutor<Task> {
                    .build(),
                    return true;
            mockAppender.addExpectation(
                Task task = (Task) o;
                )
            public void onFailure(String source, Exception e) {}
            @Override
                                    ClusterStateTaskConfig.build(randomFrom(Priority.values())),
                    Level.DEBUG,
            mockAppender.addExpectation(
        clusterManagerService.clusterManagerTaskThrottler.updateLimit(task1.getKey(), throttlingLimitForTask1);
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    @Override
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
                    public ClusterState execute(ClusterState currentState) {
                publisherRef.set(
                        .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
                });
                    new ClusterName(ClusterManagerServiceTests.class.getSimpleName())
                new MockLogAppender.SeenEventExpectation(
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
                    @Override
                }
        final ClusterStateTaskListener listener = new ClusterStateTaskListener() {
                    ClusterManagerService.class.getCanonicalName(),
                final CountDownLatch latch = new CountDownLatch(5);
                    "took [0s] to notify listeners on unchanged cluster state for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]"
        try (
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {
                clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {
                    ClusterManagerService.class.getCanonicalName(),
        List<TaskExecutor> executors = new ArrayList<>();
            final Map<String, List<String>> expectedResponseHeaders = Collections.singletonMap(
        return clusterManagerService.state();
                return id == task.id;
        final ClusterManagerService nonClusterManager = createClusterManagerService(false, Optional.of(metricsRegistry));
                    }
                )
        }
        final CyclicBarrier barrier = new CyclicBarrier(2);
import java.util.HashSet;
import java.util.concurrent.BrokenBarrierException;
        return clusterManagerService;
        AtomicInteger succeededTask3 = new AtomicInteger();
                        return ClusterState.builder(currentState).incrementVersion().build();
        verify(clusterStatePublishHistogram, times(1)).record(anyDouble());
                    } catch (ClusterManagerThrottlingException e) {
            if (histogramName.contains("cluster.state.new.compute.latency")) {
                );
                });
                )
        int numberOfExecutors = Math.max(1, numberOfThreads / 4);
            @Override
                    }
            final int taskCount = assignment.v2().size();
                return clusterStateComputeHistogram;
import org.opensearch.Version;
                    timeoutLatch.countDown();
                latch.countDown();
        try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
            latch.await();
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {
 *
                @Override
                        ).millis() + randomLongBetween(1, 1000000);
                    ClusterManagerService.class.getCanonicalName(),
                        clusterManagerService.submitStateUpdateTask(
                    }
                    "test2 start",
                @Override
import org.opensearch.cluster.AckedClusterStateUpdateTask;
                )
import static org.mockito.ArgumentMatchers.anyString;
        Thread.currentThread().setName(ClusterManagerService.CLUSTER_MANAGER_UPDATE_THREAD_NAME);
            @Override
                return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);
                }
                    public ClusterState execute(ClusterState currentState) {
    public static ClusterState discoveryState(ClusterManagerService clusterManagerService) {
                    ClusterManagerService.class.getCanonicalName(),
/*
            }));
import org.opensearch.test.junit.annotations.TestLogging;
    public void testThrottlingForTaskSubmission() throws InterruptedException {
                        return currentState;
                    public void onFailure(String source, Exception e) {
                    }
                new MockLogAppender.SeenEventExpectation(
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                            0L,
                        );
                    Version.CURRENT
                executor,
            @Override
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {
                tasks.forEach(Task::execute);
        } catch (Exception e) {
                new MockLogAppender.SeenEventExpectation(
                        .put(Node.NODE_NAME_SETTING.getKey(), "test_node")
                    publishListener.onResponse(null);
import org.opensearch.common.settings.Settings;
            // wait for all threads to be ready
                clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
                                tasks.forEach(t -> taskListeners.put(t, listener));
                    ClusterManagerService.class.getCanonicalName(),
                clusterManagerService.submitStateUpdateTask("test3", new ClusterStateUpdateTask() {
            @Override
                    Settings.builder()
import org.opensearch.common.util.concurrent.BaseFuture;
                        fail();
                latch.await();
                        latch.countDown();
                        throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");
                final AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialClusterState);
                    Level.WARN,
                        return ClusterState.builder(currentState).build();
                    .put(Node.NODE_NAME_SETTING.getKey(), "test_node")
        assertFalse("non-cluster-manager cluster state update task was not executed", taskFailed[0]);
            }
import static org.mockito.ArgumentMatchers.any;
                });
                )
                final AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialClusterState);
                @Override
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                            new Task2(),
        for (int i = 0; i < throttlingLimit; i++) {
            @Override
                taskGroups.add(tasks);
                }
    }
    }
            clusterManagerService.setClusterStatePublisher((e, pl, al) -> publisherRef.get().publish(e, pl, al));
                    "test2",
                    @Override
                    }
                    "executing cluster state update for [test3]"
        AtomicInteger throttledTask2 = new AtomicInteger();
        // await for latch to clear
                assertBusy(() -> assertEquals(0, clusterManagerService.getClusterStateStats().getUpdateFailed()));
        int numberOfTask3 = randomIntBetween(throttlingLimitForTask3, 10);
                    .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
import org.opensearch.common.Priority;
                        timeDiffInMillis += TimeValue.timeValueSeconds(1).millis();
            public String toString() {
                    }
                timeoutListener
                    "test2 computation",
                new MockLogAppender.SeenEventExpectation(
        }
                new Object(),
            );
                    latch.countDown();
                clusterManagerService.submitStateUpdateTask("test3", new ClusterStateUpdateTask() {
        }
                        timeDiffInMillis += TimeValue.timeValueSeconds(2).millis();
                    }
                    }
        final CountDownLatch latch = new CountDownLatch(numberOfTask1 + numberOfTask2 + numberOfTask3);
                    @Override
            mockAppender.addExpectation(
    private static long timeDiffInMillis;
        for (int i = 0; i < numberOfTask1; i++) {
            try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
    }
                    "*took [*], which is over [10s], to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test4]"
                    succeededTask2.incrementAndGet();
import java.util.Set;
            assertThat(assertionRef.get().getMessage(), containsString("Reason: [Blocking operation]"));
                new MockLogAppender.SeenEventExpectation(
                latch.countDown();
            }
                    @Override
                    }
                    }
                    }
                    @Override
                    .build(),
                        anyOf(equalTo(0L), equalTo((long) expectedSet.size()))
                            }
                barrier.await();
                new MockLogAppender.SeenEventExpectation(
        }
            };
import static java.util.Collections.emptyMap;
                    }
        class Task3Executor implements ClusterStateTaskExecutor<Task> {
import org.junit.AfterClass;
 * software distributed under the License is distributed on an
                    }
    @TestLogging(value = "org.opensearch.cluster.service:DEBUG", reason = "to ensure that we log cluster state events on DEBUG level")
                processedFirstTask.await();
                return throttlingKey;
                }
 * the Apache License, Version 2.0 (the "License"); you may
                    @Override
                final int index = i;
                )
                        new FailedToCommitClusterStateException("mock exception")
        };
                return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);
            throw new AssertionError(e);
import org.opensearch.cluster.ClusterManagerMetrics;
            clusterManagerService.submitStateUpdateTask(
                    }
        final CountDownLatch latch1 = new CountDownLatch(1);
                public void onAckTimeout() {
        }
                        clusterManagerService.submitStateUpdateTask(
        Task3Executor executor3 = new Task3Executor();
                    protected Void newResponse(boolean acknowledged) {
                new Task(taskId++),
                    threadPool,
            }
                @Override
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
import org.opensearch.cluster.block.ClusterBlocks;
                }
import java.util.ArrayList;
    }
                    "*took*test1*"
                    assertEquals(executor.batches.get(), executor.published.get());
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                threadPool
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    public ClusterState execute(ClusterState currentState) {
            blockingTaskLatch.countDown();
        if (metricsRegistryOptional != null && metricsRegistryOptional.isPresent()) {
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    public void onFailure(String source, Exception e) {}
                    @Override
                });
                clusterManagerService.submitStateUpdateTask("test2", new AckedClusterStateUpdateTask<Void>(null, null) {
                        return null;
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    ClusterState newClusterState = ClusterState.builder(currentState).build();
                    }
                    @Override
import java.util.concurrent.CyclicBarrier;
            final ClusterStateTaskListener timeoutListener = new ClusterStateTaskListener() {
import org.opensearch.test.MockLogAppender;
                    "test2 failure",
                @Override
            clusterManagerService.submitStateUpdateTask(
        Optional<MetricsRegistry> metricsRegistryOptional
                        processedFirstTask.countDown();
        try {
                new MockLogAppender.UnseenEventExpectation(
                    "test2 computation",
                    @Override
                            listener
                        latch.countDown();
                }
                        return null;
                latch.countDown();
                clusterManagerService.start();
                            task3.getKey(),
        clusterManagerService.clusterManagerTaskThrottler.updateLimit(task.getKey(), throttlingLimit);
                assertBusy(mockAppender::assertAllExpectationsMatched);
import java.util.Collections;
                        throw new IllegalArgumentException("mock failure");
                    "failed to execute cluster state update (on version: [*], uuid: [*]) for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]*"
                    successCount.incrementAndGet();
                    }
            assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
                if (o == null || getClass() != o.getClass()) {
                }
                final CountDownLatch latch = new CountDownLatch(2);
import com.carrotsearch.randomizedtesting.annotations.Timeout;
                    throw new IllegalStateException();
            );
            publishListener.onResponse(null);
                    @Override
import org.opensearch.telemetry.metrics.Histogram;
        // configuring limits for Task1 and Task3. All task submission of Task2 should pass.
            assertNotNull(assertionRef.get());
                Thread.sleep(randomInt(1000));
 * You may obtain a copy of the License at
                            latch.countDown();
        latch.await();
                clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
                    }
            @Override
                    ClusterManagerService.class.getCanonicalName(),
            mockAppender.addExpectation(
                timedOutTask3.incrementAndGet();
                    "took [0s] to notify listeners on unchanged cluster state for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test1]"
            for (Map.Entry<String, AtomicInteger> entry : processedStates.entrySet()) {
                "timeout",
                    public ClusterState execute(ClusterState currentState) {
                        latch.countDown();
            public ClusterTasksResult<LocalClusterUpdateTask> execute(ClusterState currentState) {
                        throw new IllegalStateException(source);
                    assertEquals("timeout", source);
                    @Override
                        return ClusterState.builder(currentState).incrementVersion().build();
                    ackListener.onNodeAck(node3, null);
                    ClusterManagerService.class.getCanonicalName(),
                        ).millis() + randomLongBetween(1, 1000000);
                },
                    }
                    ClusterManagerService.class.getCanonicalName(),
                            ClusterStateTaskConfig.build(randomFrom(Priority.values()), new TimeValue(0)),
                        fail("Interrupted");
                            new Task3(),
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
            assertEquals(1, failureCount.get());
        nonClusterManager.submitStateUpdateTask("test", new ClusterStateUpdateTask() {
        nonClusterManager.close();
import org.opensearch.cluster.ClusterChangedEvent;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                }
                new MockLogAppender.SeenEventExpectation(
                        fail();
            }
        clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
 */
        for (Thread thread : threads) {
        };
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    task.getKey(),
                    .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))
            mockAppender.addExpectation(
            executors.add(new TaskExecutor(taskGroups));
import static org.hamcrest.Matchers.hasKey;
                thread.start();
import org.opensearch.cluster.LocalClusterUpdateTask;
            if (histogramName.contains("cluster.state.new.compute.latency")) {
            ClusterManagerService clusterManagerService = new ClusterManagerService(
                    .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))
                    }
                    Level.TRACE,
                    public ClusterState execute(ClusterState currentState) {
            );
        final ClusterManagerService clusterManagerService;
                    .put(Node.NODE_NAME_SETTING.getKey(), "test_node")
    @BeforeClass
                    "executing cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test1]"
            )
                    new Task(taskId++),
                    }
 * Modifications Copyright OpenSearch Contributors. See
                    ackListener.onNodeAck(node2, null);
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            public long preciseRelativeTimeInNanos() {
                    "test5 should not log despite publishing slowly",
            }
            mockAppender.addExpectation(
            @Override
                processedStates.computeIfAbsent(source, key -> new AtomicInteger()).incrementAndGet();
        assertEquals(numberOfTask1, throttledTask1.get() + succeededTask1.get());
                    @Override
                    public ClusterState execute(ClusterState currentState) {
    /**
                clusterManagerService.submitStateUpdateTask(
                    ClusterManagerService.class.getCanonicalName(),
                }
                                    taskListeners,
                }
                clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {
                Thread.sleep(randomInt(1000));
                    public void onFailure(String source, Exception e) {
                    Level.WARN,
            @Override
            );
            for (TaskExecutor executor : executors) {
                    ClusterManagerService.class.getCanonicalName(),
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            updateLatch.await();
        }
                    .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
        });
                    }
        ClusterManagerTask task3 = DELETE_INDEX;
                publisherRef.set((clusterChangedEvent, publishListener, ackListener) -> {
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                new ClusterStateTaskExecutor<Object>() {
            }
                        );
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey3 = clusterManagerService.registerClusterManagerTask(task3, true);
                    @Override
                new MockLogAppender.SeenEventExpectation(
            }));
                            Settings.EMPTY
                    Level.DEBUG,
                        latch.countDown();
    @Before
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
        TaskExecutor executor = new TaskExecutor();
                    public void onFailure(String source, Exception e) {
            assertEquals(Collections.emptyMap(), threadPool.getThreadContext().getResponseHeaders());
                    }
                        latch.countDown();
                )
            private AtomicInteger batches = new AtomicInteger();
                // verify stats values after state is published
            // wait for all threads to finish
    @TestLogging(value = "org.opensearch.cluster.service:WARN", reason = "to ensure that we log cluster state events on WARN level")
        AtomicInteger throttledTask1 = new AtomicInteger();
            final CountDownLatch timeoutLatch = new CountDownLatch(1);
                );
                    @Override
        return createClusterManagerService(makeClusterManager, Optional.empty());
import org.apache.logging.log4j.LogManager;
                    @Override
                new MockLogAppender.SeenEventExpectation(
                    "test4",
                    new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
                new MockLogAppender.SeenEventExpectation(
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                }
            @Override
                    "took [0s] to notify listeners on unchanged cluster state for [test2]"
            );
                }
                    }
                    }
                ClusterStateTaskConfig.build(Priority.NORMAL),
                        return ackTimeout;
        });
            }
import java.util.concurrent.atomic.AtomicInteger;
                    Level.DEBUG,
            mockAppender.addExpectation(
    }
                clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
                    )
    public void testLongClusterStateUpdateLogging() throws Exception {
                    public void onFailure(String source, Exception e) {
 *
                    @Override
                    "test1 computation",
        }
        latch2.await();
                    }
                        fail();
                )
                                clusterManagerService.submitStateUpdateTask(
                executor,
                                    executor
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    }
            clusterManagerService.submitStateUpdateTask(
            // start a second task that is guaranteed to timeout as the first task is still running
        AtomicInteger succeededTask1 = new AtomicInteger();
                    }
            }
                    @Override
                new MockLogAppender.SeenEventExpectation(
                    }
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterManagerService.class))) {
                });
    }
                return ClusterTasksResult.<Task>builder().successes(tasks).build(maybeUpdatedClusterState);
                    maybeUpdatedClusterState = ClusterState.builder(currentState).build();
            }
        class Task {
            }
                        return currentState;
            }
            public void onFailure(String source, Exception e) {
            mockAppender.addExpectation(
                        return ClusterState.builder(currentState).build();
import org.opensearch.threadpool.ThreadPool;
                    "*took [*], which is over [10s], to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test3]"
                )
                        fail();
        AtomicInteger counter = new AtomicInteger();
 * compatible open source license.
                final TimeValue ackTimeout = TimeValue.timeValueMillis(randomInt(100));
    public void testTaskTimeout() throws InterruptedException {
            }
            mockAppender.addExpectation(
                    batches.incrementAndGet();
                        Settings.EMPTY
                    public void onFailure(String source, Exception e) {
                    @Override
            assertFalse(threadPool.getThreadContext().isSystemContext());
                } else if (source.equals(task3.getKey())) {
            // assert each executor executed the correct number of tasks
                        clusterManagerService.submitStateUpdateTask(
                )
    @AfterClass
        class Task {}
                    Level.DEBUG,
                        throttledTask2.incrementAndGet();
    }
                            Settings.EMPTY
                        barrier.await();
            clusterManagerService.submitStateUpdateTask(
                            final Set<Task> tasks = assignment.v2();
            return clusterStatePublishHistogram;
    public void testThrottlingForMultipleTaskTypes() throws InterruptedException {
                        latch.countDown();
            mockAppender.addExpectation(
                            Tuple<TaskExecutor, Set<Task>> assignment = assignments.get(index * taskSubmissionsPerThread + j);
                new MockLogAppender.SeenEventExpectation(
                                future.get(1L, TimeUnit.SECONDS);
        final CountDownLatch latch = new CountDownLatch(1);
            final ClusterState initialClusterState = ClusterState.builder(new ClusterName(ClusterManagerServiceTests.class.getSimpleName()))
            clusterStateRef.set(event.state());
                    "took [0s] to notify listeners on unchanged cluster state for [test1]"
            final ClusterStateTaskListener blockingListener = new ClusterStateTaskListener() {
                        fail();
                semaphore.release();
            mockAppender.addExpectation(
                    @Override
                throw new AssertionError(e);
import java.util.concurrent.Semaphore;
 */
                    @Override
            mockAppender.addExpectation(
                ClusterStateTaskConfig.build(Priority.NORMAL),
                    Settings.builder()
                )
                latch.await();
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
        }
                    @Override
                Collections.singletonList("testResponse")
                    "executing cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test4]"
                @Override
        }
                    if (event.source().contains("test5")) {
                    public void onFailure(String source, Exception e) {
                    @Override
            );
        try {
                (currentState, tasks) -> {
            latch.await();
import org.opensearch.cluster.ClusterStateTaskExecutor;
        latch.await();
            @Override
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {
            threads.add(new Thread(new Runnable() {
                    @Override
                if (!state.compareAndSet(false, true)) {
            final AtomicInteger successCount = new AtomicInteger();
                        throttledTask3.incrementAndGet();
                    }
import org.opensearch.telemetry.metrics.MetricsRegistry;
                    "test2 start",
                                    listener
            }
            assertEquals(totalTaskCount, counter.get());
            }
                    public void onAckTimeout() {
        class TaskExecutor implements ClusterStateTaskExecutor<Task> {
            clusterManagerService.start();
                            executor1,
                new Object(),
                        timeDiffInMillis += TimeValue.timeValueSeconds(1).millis();
                    Level.DEBUG,
                    @Override
    public void testLongClusterStateUpdateLoggingForFailedPublication() throws Exception {
                public ClusterState execute(ClusterState currentState) {
                        );
                    "*took [*], which is over [10s], to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]"
                    "executing cluster state update for [test2]"
        }
            }
    public static void createThreadPool() {
            );
        ClusterManagerTask task1 = CREATE_INDEX;
import static org.mockito.Mockito.mock;
                    "executing cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]"
}
            public int hashCode() {
import org.opensearch.common.util.concurrent.ThreadContext;
                for (int t = randomInt(3); t >= 0; t--) {
    @Timeout(millis = 5_000)
            private final int id;
                )
                        return ClusterState.builder(currentState).incrementVersion().build();
        final ClusterManagerTask task = CREATE_INDEX;
import org.opensearch.cluster.node.DiscoveryNodes;
                    ClusterManagerService.class.getCanonicalName(),
                    "took [4s] to notify listeners on successful publication of cluster state (version: *, uuid: *) for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test3]"
                            final TaskExecutor executor = assignment.v1();
                        return currentState;
                    }
        final DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    assertEquals(Collections.emptyMap(), threadPool.getThreadContext().getHeaders());
            clusterManagerService.submitStateUpdateTask(
            @Override
                )
                    "test1 shouldn't log because it was fast enough",
            CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
            Task(int id) {
            private AtomicInteger published = new AtomicInteger();
                                );
                    Level.DEBUG,
                    .build(),
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
                                future.get();
                    }
                        return currentState;
        for (int i = 0; i < numberOfTask3; i++) {
import static org.mockito.ArgumentMatchers.anyDouble;
                        fail();
        }
                    public ClusterState execute(ClusterState currentState) {
                        fail();
                final ClusterState initialClusterState = ClusterState.builder(
            // start a task and wait for it to start and block on the clusterStateProcessed callback
            );
                    .put(Node.NODE_NAME_SETTING.getKey(), "test_node")
            final CountDownLatch blockingTaskLatch = new CountDownLatch(1);
                    Level.DEBUG,
        }
        class Task1Executor implements ClusterStateTaskExecutor<Task> {
        verify(clusterStateComputeHistogram, times(2)).record(anyDouble(), any());
                        fail();
            );
                )
                        fail();
            clusterManagerService = new ClusterManagerService(
                if (source.equals(task1.getKey())) {
                    @Override
                    ClusterManagerService.class.getCanonicalName(),
            mockAppender.assertAllExpectationsMatched();
                }
            threads.add(new Thread(new Runnable() {
                    }
                new ClusterManagerMetrics(metricsRegistryOptional.get())
                new Object(),
                threadPool,
import static org.mockito.Mockito.when;
                    @Override
        } catch (ClusterManagerThrottlingException e) {
                if (counts.containsKey(executor)) {
                    @Override
    }
                )
    }
        AtomicBoolean published = new AtomicBoolean();
                            throw new RuntimeException(e);
 * SPDX-License-Identifier: Apache-2.0
                    @Override
                    assertFalse(threadPool.getThreadContext().isSystemContext());
                    @Override
                                    ClusterStateTaskConfig.build(randomFrom(Priority.values())),
        }
        } else {
                )
            semaphore.acquire(numberOfExecutors);
                    @Override
                        ).millis() + randomLongBetween(1, 1000000);
                    public void onFailure(String source, Exception e) {}
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey1 = clusterManagerService.registerClusterManagerTask(task1, true);
                    }
import org.junit.Before;
                        timeDiffInMillis += TimeValue.timeValueSeconds(4).millis();
            public ClusterState execute(ClusterState currentState) {
                    "failed to execute cluster state update (on version: [*], uuid: [*]) for [test2]*"
                        latch.countDown();
                "testClusterStateTaskListenerThrowingExceptionIsOkay",
                    ClusterManagerService.class.getCanonicalName(),
                task.getKey(),
                    assertFalse(threadPool.getThreadContext().isSystemContext());
        final CountDownLatch latch = new CountDownLatch(1);
                throw new AssertionError(e);
            threadPool.shutdownNow();
import org.opensearch.cluster.ClusterStateTaskConfig;
            clusterManagerService.submitStateUpdateTask("test", new AckedClusterStateUpdateTask<Void>(null, null) {
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterManagerService.class))) {
                }
                    }
                    }
    private ClusterManagerService createClusterManagerService(
            final TimeValue clusterManagerTimeout = randomBoolean() ? TimeValue.ZERO : TimeValue.timeValueMillis(randomInt(10000));
                published.incrementAndGet();
        });
                clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
                assertThat(submittedTasksPerThread, hasKey(entry.getKey()));
                .nodes(
                    "test3 computation",
            @Override
                latch1.countDown();
                    Level.TRACE,
                    .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            mockAppender.addExpectation(
 * this file be licensed under the Apache-2.0 license or a
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            totalTaskCount += taskCount;
        List<Tuple<TaskExecutor, Set<Task>>> assignments = new ArrayList<>();
                    public void onAckTimeout() {
                    .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
                    timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(
                .build(currentState);
            clusterManagerService.submitStateUpdateTask(
        }
                        return ClusterState.builder(currentState).build();
        int taskId = 1;
                );
                return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);
                new Task(taskId++),
                )
                });
                public void run() {
                )
            }
            final AtomicInteger failureCount = new AtomicInteger();
            barrier.await();
        assumeTrue("assertions must be enabled for this test to work", BaseFuture.class.desiredAssertionStatus());
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    }
                        latch.countDown();
                new Object(),
    */
                        fail();
                        .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
                taskFailed[0] = true;
                    @Override
                    return ClusterStateTaskExecutor.ClusterTasksResult.builder().successes(tasks).build(newClusterState);
                    @Override
                public void run() {
                                    tasks.stream().findFirst().get(),
            );
                public void onAllNodesAcked(@Nullable Exception e) {
            final ConcurrentMap<String, AtomicInteger> submittedTasksPerThread = new ConcurrentHashMap<>();
                    throw new OpenSearchException("simulated error during slow publication which should trigger logging");
    public static void stopThreadPool() {
                    @Override
                return throttlingKey3;
            }
                final CountDownLatch latch = new CountDownLatch(1);
        assertEquals(0, throttledTask2.get());
            mockAppender.addExpectation(
                    }
                    final String threadName = Thread.currentThread().getName();
                new MockLogAppender.UnseenEventExpectation(
                @Override
                    "took [2s] to compute cluster state update for [test2]"
import org.opensearch.common.Nullable;
                    "*took*test5*"
                    @Override
            @Override
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    Level.WARN,
    /*
                clusterManagerService.submitStateUpdateTask("test4", new ClusterStateUpdateTask() {
                )
                    } catch (BrokenBarrierException | InterruptedException e) {
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            )
            threadPool.getThreadContext().putHeader(expectedHeaders);
import java.util.concurrent.ConcurrentMap;
                )
            for (int i = 0; i < numberOfThreads; i++) {
                latch1.countDown();
            assertionRef.set(e);
                    "took [*] and then failed to publish updated cluster state (version: *, uuid: *) for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test1]:*"
                listener
import org.opensearch.cluster.ClusterState;
            thread.start();
            @Override
                new MockLogAppender.SeenEventExpectation(
                }
            for (int j = 0; j < taskSubmissionsPerThread; j++) {
            public void onFailure(String source, Exception e) {
                taskFailed[0] = false;
                    ClusterManagerService.class.getCanonicalName(),
        class Task3 extends Task {}
                }
                )
        assertTrue("cluster state update task was executed on a non-cluster-manager", taskFailed[0]);
import static org.hamcrest.Matchers.equalTo;
                return currentState;
                    "test2 failure",
                        throttledTask1.incrementAndGet();
                    buildNewFakeTransportAddress(),
                });
                        barrier.await();
            return clusterStatePublishHistogram;
 *     http://www.apache.org/licenses/LICENSE-2.0
                            }
            } catch (Exception e) {
    public void randomizeCurrentTime() {
            );
                    counter.incrementAndGet();
                    ClusterStateTaskConfig.build(randomFrom(Priority.values())),
import java.util.concurrent.atomic.AtomicBoolean;
            @Override
        int numberOfTask1 = randomIntBetween(throttlingLimitForTask1, 10);
                    "took [2s] to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]"
        final Histogram clusterStatePublishHistogram = mock(Histogram.class);
                )
                latch.await();
            taskStartLatch.await();
            mockAppender.addExpectation(
                clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {
 * GitHub history for details.
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {
                        latch.countDown();
                            new Task1(),
                    "test2 notification",
                    @Override
            );
        int numberOfTask2 = randomIntBetween(throttlingLimitForTask2, 10);
        List<Set<Task>> taskGroups = new ArrayList<>();
                )
                });
        }
    }
            );
                    try {
                    }
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
    @TestLogging(value = "org.opensearch.cluster.service:WARN", reason = "to ensure that we log failed cluster state events on WARN level")
                executor,
            public void onFailure(String source, Exception e) {
                    }
        final DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                new ClusterManagerMetrics(metricsRegistry)
        // submit one task which will be execution, post that will submit throttlingLimit tasks.
                });
                    @Override
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                                clusterManagerService.submitStateUpdateTasks(
                new ClusterStateTaskListener() {
            }
                    }
                }
                        fail();
                }
                    ClusterManagerService.class.getCanonicalName(),
        threadPool = new TestThreadPool(ClusterManagerServiceTests.class.getName()) {
                executor,
                        );
                    } else if (randomBoolean()) {
                blockingListener
                clusterManagerService.submitStateUpdateTask("test5", new ClusterStateUpdateTask() {
                    }
                });
                Settings.builder()
                            } else {
                    Level.TRACE,
public class ClusterManagerServiceTests extends OpenSearchTestCase {
    }
                    Level.DEBUG,
            private AtomicInteger published = new AtomicInteger();
                    Version.CURRENT
                    "executing cluster state update for [test1]"
            public boolean equals(Object o) {
        ClusterManagerService clusterManagerService = createClusterManagerService(true);
                counter.addAndGet(tasks.size());
                    } catch (ClusterManagerThrottlingException e) {
        final ClusterStateTaskListener listener = new ClusterStateTaskListener() {
 * license agreements. See the NOTICE file distributed with
                    .build();
            }
            private AtomicBoolean state = new AtomicBoolean();
import org.opensearch.cluster.node.DiscoveryNode;
                    "test1 notification",
                            if (randomBoolean()) {
            mockAppender.addExpectation(
        final Semaphore semaphore = new Semaphore(numberOfExecutors);
                        latch.countDown();
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                )
                    }
        Map<TaskExecutor, Integer> counts = new HashMap<>();
        }
                    @Override
        assertEquals(numberOfTask3, throttledTask3.get() + timedOutTask3.get() + succeededTask3.get());
            private final List<Set<Task>> taskGroups;
                clusterManagerService.submitStateUpdateTask("test4", new ClusterStateUpdateTask() {
    public void testBlockingCallInClusterStateTaskListenerFails() throws InterruptedException {
                    ClusterManagerService.class.getCanonicalName(),
                    }
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey2 = clusterManagerService.registerClusterManagerTask(task2, true);
                    public void onFailure(String source, Exception e) {
        }
    public void testAcking() throws InterruptedException {
        int throttlingLimitForTask1 = randomIntBetween(1, 5);
 * specific language governing permissions and limitations
                assertEquals(
                            executor2,
        }
                        latch.countDown();
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {
                    ClusterManagerService.class.getCanonicalName(),
                    public ClusterState execute(ClusterState currentState) {
                        throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");
        }
            private AtomicInteger counter = new AtomicInteger();
                }
                    assertThat(
        for (Tuple<TaskExecutor, Set<Task>> assignment : assignments) {
        clusterManagerService.clusterManagerTaskThrottler.updateLimit(task3.getKey(), throttlingLimitForTask3);
                    "executing cluster state update for [test4]"
                    "not all tasks submitted by " + entry.getKey() + " received a processed event",
                    @Override
                            ClusterStateTaskConfig.build(randomFrom(Priority.values())),
                    emptyMap(),
                );
                    "test2 notification",
            }
    }
                        latch.countDown();
import java.util.concurrent.CountDownLatch;
                        return currentState;
import java.util.concurrent.TimeUnit;
                        return ClusterState.builder(currentState).incrementVersion().build();
            // check that we don't time out before even committing the cluster state
        class TaskExecutor implements ClusterStateTaskExecutor<Task> {
                published.incrementAndGet();
                    "test3 notification",
                Settings.builder()
        }
                    return false;
            }
            );
                    } else {
            }
            // and until all of the publication callbacks have completed
                clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
                    "executing cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test3]"
import org.opensearch.cluster.ClusterStateTaskListener;
        class Task2 extends Task {}
import org.opensearch.cluster.coordination.ClusterStatePublisher;
        AtomicInteger succeededTask2 = new AtomicInteger();
                    @Override
            final Map<String, String> expectedHeaders = Collections.singletonMap("test", "test");
        assertThrows(AssertionError.class, () -> ClusterManagerService.assertNotClusterManagerUpdateThread("test"));
                            submittedTasksPerThread.computeIfAbsent(threadName, key -> new AtomicInteger()).addAndGet(tasks.size());
import org.apache.logging.log4j.Level;
                    ackListener.onNodeAck(node1, null);
                    buildNewFakeTransportAddress(),
                });
                        timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(
            );
            );
                clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
                    public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
                        return ClusterState.builder(currentState).incrementVersion().build();
 * Unless required by applicable law or agreed to in writing,
                    }
        }
        final ClusterManagerService clusterManagerService = createClusterManagerService(true);
                    threadPool.getThreadContext().addResponseHeader("testResponse", "testResponse");
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                            listener
                .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            );
                this.id = id;
            }
        assertThat(ClusterManagerService.assertNotClusterManagerUpdateThread("test"), is(Boolean.TRUE));
                final CountDownLatch processedFirstTask = new CountDownLatch(1);
        nonClusterManager.submitStateUpdateTask("test", new LocalClusterUpdateTask() {
            );
            public void onFailure(String source, Exception e) {
                    Level.DEBUG,
        assertNotNull(assertionRef.get());
                assertBusy(() -> assertEquals(1, clusterManagerService.getClusterStateStats().getUpdateSuccess()));
                                Map<Task, ClusterStateTaskListener> taskListeners = new HashMap<>();
                    @Override
import org.opensearch.common.unit.TimeValue;
            );
                    if (randomBoolean()) {
                            task1.getKey(),
                        BaseFuture<Void> future = new BaseFuture<Void>() {
        final DiscoveryNode localNode = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    emptyMap(),
                            task2.getKey(),
                    emptySet(),
                    Level.DEBUG,
            assertEquals(1, successCount.get());
        final AtomicReference<ClusterManagerThrottlingException> assertionRef = new AtomicReference<>();
    public void testThreadContext() throws InterruptedException {
                    emptySet(),
            // wait until all the cluster state updates have been processed
                "success",
                        return currentState;
            });
            );
                    public void onFailure(String source, Exception e) {
                    }
            }
        }
            // wait for the timeout to happen, then unblock and assert one success and one failure
        clusterManagerService.setClusterStateSupplier(clusterStateRef::get);
                new MockLogAppender.SeenEventExpectation(
                    "took [3s] to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test3]"
                    .add(localNode)
                // Task3's timeout should have called this.
        try (ThreadContext.StoredContext ignored = threadPool.getThreadContext().stashContext()) {
                            ClusterStateTaskConfig.build(randomFrom(Priority.values())),
                });
        }
            );
        latch1.await();
                } else {
        try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
                    fail("Unexpected failure");
                    public ClusterState execute(ClusterState currentState) {
                    taskStartLatch.countDown();
                                    executor,
                    }
            mockAppender.addExpectation(
                        } catch (Exception e) {
                ClusterStateTaskConfig.build(randomFrom(Priority.values())),
            }
                return id;
                    @Override
        final MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);
                    ClusterManagerService.class.getCanonicalName(),
import static org.hamcrest.Matchers.anyOf;
                    "took [3s] to compute cluster state update for [test3]"
                    ClusterManagerService.class.getCanonicalName(),
 * ownership. Elasticsearch licenses this file to you under
                }
                clusterManagerService.submitStateUpdateTask("test2", new AckedClusterStateUpdateTask<Void>(null, null) {
            mockAppender.assertAllExpectationsMatched();
                    @Override
                });
        }
        // wait till task enter in execution.
                        timeDiffInMillis += TimeValue.timeValueSeconds(3).millis();
                });
        final ClusterStateTaskListener listener = new ClusterStateTaskListener() {
            ) {
                final DiscoveryNode localNode = new DiscoveryNode(
                        timeDiffInMillis += TimeValue.timeValueSeconds(3).millis();
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.test.OpenSearchTestCase;
            @Override
                    } catch (InterruptedException e) {
    }
                        timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(
                new MockLogAppender.SeenEventExpectation(
                clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {
                    }
            );
        final Histogram clusterStateComputeHistogram = mock(Histogram.class);
            {
            mockAppender.addExpectation(
        boolean makeClusterManager,
                    }
                assertBusy(mockAppender::assertAllExpectationsMatched);
            };
                    public ClusterState execute(ClusterState currentState) {
        }
                "testBlockingCallInClusterStateTaskListenerFails",
                        fail();
            mockAppender.addExpectation(
                    @Override
        assertThrows(AssertionError.class, () -> ClusterManagerService.assertClusterManagerUpdateThread());
        for (int i = 0; i < numberOfTask2; i++) {
import static org.hamcrest.Matchers.containsString;
import org.opensearch.cluster.ClusterName;
                    @Override
                        fail();
            mockAppender.addExpectation(
                new MockLogAppender.SeenEventExpectation(
                // We don't check logging for this on since there is no guarantee that it will occur before our check
                Thread thread = new Thread(() -> {
                    Level.DEBUG,
                            } else {
                return timeDiffInMillis * TimeValue.NSEC_PER_MSEC;
                return clusterStateComputeHistogram;
        }
                    @Override
                return Integer.toString(id);
                },
                    assertFalse(threadPool.getThreadContext().isSystemContext());
            final AtomicReference<ClusterStatePublisher> publisherRef = new AtomicReference<>();
            @Override
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterManagerService.class))) {
        final CountDownLatch latch = new CountDownLatch(1);
                        timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(
                    "took [1s] to compute cluster state update for [test1]"
        AtomicInteger throttledTask3 = new AtomicInteger();
                TaskExecutor executor = randomFrom(executors);
        clusterManagerService.close();
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    @Override
 * The OpenSearch Contributors require contributions made to
        class Task1 extends Task {}
                    ClusterManagerService.class.getCanonicalName(),
                    @Override
/*
                        ClusterState newClusterState = ClusterState.builder(currentState).build();
                });
        }
                )
            counts.merge(assignment.v1(), taskCount, (previous, count) -> previous + count);
                    public TimeValue ackTimeout() {
        }
            private final int id;
                @Override
                // Additional update task to make sure all previous logging made it to the loggerName
                });
                    return null;
                .successes(tasks)
                @Override
                    @Override
                    return ackTimeout;
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                clusterManagerService.submitStateUpdateTask("test3", new ClusterStateUpdateTask() {
            @Override
                    public void onFailure(String source, Exception e) {
            String histogramName = (String) invocationOnMock.getArguments()[0];
                    ClusterManagerService.class.getCanonicalName(),
package org.opensearch.cluster.service;
                public void run() {
                Settings.builder()
        class Task {
    * notification does not prevent publication notification to the
    private static ThreadPool threadPool;
import org.opensearch.node.Node;
                ClusterManagerService clusterManagerService = new ClusterManagerService(
                }
                    ClusterManagerService.class.getCanonicalName(),
                        }
                    "test3 computation",
                    long count = tasks.stream().filter(expectedSet::contains).count();
import static java.util.Collections.emptySet;
        // randomly assign tasks to executors
                    @Override
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            timeoutLatch.await();
                            assertionRef.set(e);
                    public TimeValue timeout() {
                return unchanged();
 * this work for additional information regarding copyright
            @Override
            mockAppender.addExpectation(
                    Level.DEBUG,
            mockAppender.addExpectation(
                    @Override
            ) {
                    Level.DEBUG,
                    ClusterManagerService.class.getCanonicalName(),
                )
    * executor
            mockAppender.addExpectation(
                    @Override
            threadPool = null;
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {
                        try {
                    }
            // assert the number of executed tasks is correct
                    }
                ClusterState maybeUpdatedClusterState = currentState;
                    try {
                        fail();
                    ClusterManagerService.class.getCanonicalName(),
            }
        ConcurrentMap<String, AtomicInteger> processedStates = new ConcurrentHashMap<>();
                @Override
                protected Void newResponse(boolean acknowledged) {
            Task(int id) {
                }
                return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);
                    "test3 start",
import org.opensearch.threadpool.TestThreadPool;
/*
                        fail();
                    .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
                    try {
                    entry.getValue().get(),
                });
                    clusterStateRef.set(event.state());
            assertTrue(published.get());
                        fail();
                    }
                new MockLogAppender.SeenEventExpectation(
                        // Exception should be RejactedExecutionException.
                    }
                    }
import java.util.concurrent.ConcurrentHashMap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterManagerService.class))) {
