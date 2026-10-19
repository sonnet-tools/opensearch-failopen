                        processedFirstTask.countDown();
import static org.mockito.Mockito.when;  
            clusterManagerService.submitStateUpdateTask(
                        throttledTask3.incrementAndGet();  
                    return clusterManagerTimeout;  
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
            {
import java.util.concurrent.BrokenBarrierException;  
            mockAppender.addExpectation(
            for (int i = 0; i < numberOfThreads; i++) {
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        latch.countDown();  
 * license agreements. See the NOTICE file distributed with
                @Override  
                latch2.countDown();
            // check that we timeout if commit took too long
            updateLatch.await();
        assertThat(ClusterManagerService.assertNotClusterManagerUpdateThread("test"), is(Boolean.TRUE));  
                    @Override  
                .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)  
                }
            @Override
                    @Override  
            assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
                    }  
        }  
            }
        return clusterManagerService.state();  
                    ClusterManagerService.class.getCanonicalName(),  
                    }
    public static void stopThreadPool() {  
                    "executing cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test4]"  
            }
                    }  
                new MockLogAppender.SeenEventExpectation(  
                    }
            TaskExecutor(List<Set<Task>> taskGroups) {
                        .build(),
    * test that a listener throwing an exception while handling a
            public void onFailure(String source, Exception e) {  
                    Level.DEBUG,
                new ClusterStateTaskExecutor<Object>() {  
                protected Void newResponse(boolean acknowledged) {
                        return currentState;  
                    succeededTask3.incrementAndGet();
                        fail();  
                            listener  
                        latch.countDown();
        }  
            threadPool = null;  
                this.id = id;
                    @Override
                        fail();
            private final int id;  
                        return ClusterState.builder(currentState).build();
                    ClusterManagerService.class.getCanonicalName(),  
        int totalTaskCount = 0;  
                        latch.countDown();
            );
                final DiscoveryNode localNode = new DiscoveryNode(
                        timeDiffInMillis += TimeValue.timeValueSeconds(1).millis();
                },  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            );
                );  
                    }
                    }
                )
                new Object(),
                )  
        Task3Executor executor3 = new Task3Executor();  
        try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {  
                    }
        clusterManagerService.clusterManagerTaskThrottler.updateLimit(task.getKey(), throttlingLimit);
                )
        assertNotNull(assertionRef.get());
            final AtomicInteger successCount = new AtomicInteger();
                public void run() {
import static org.hamcrest.Matchers.containsString;
        class Task {}
        try {
            }
                        fail();
                    public TimeValue ackTimeout() {  
                        fail();
                    ackListener.onNodeAck(node3, null);  
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterManagerService.class))) {
                        return currentState;  
                    executor,
                    @Override
                    task.getKey(),
            final CountDownLatch taskStartLatch = new CountDownLatch(1);  
        assertFalse("non-cluster-manager cluster state update task was not executed", taskFailed[0]);  
                    assertTrue(threadPool.getThreadContext().isSystemContext());
            } catch (Exception e) {
                    @Override
            clusterManagerService.submitStateUpdateTask(
    }  
                        ).millis() + randomLongBetween(1, 1000000);
                "testBlockingCallInClusterStateTaskListenerFails",
            mockAppender.addExpectation(
            )
            assertionRef.set(e);
    /**
                    }
                clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
        ClusterManagerService clusterManagerService = createClusterManagerService(true);
                clusterManagerService.submitStateUpdateTask("test3", new ClusterStateUpdateTask() {
                        throttledTask2.incrementAndGet();
        for (int i = 0; i < numberOfTask3; i++) {
                )
                new MockLogAppender.SeenEventExpectation(
                    "failed to execute cluster state update (on version: [*], uuid: [*]) for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]*"
            assertEquals(1, failureCount.get());  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                thread.start();
    private ClusterManagerService createClusterManagerService(boolean makeClusterManager) {  
                        latch.countDown();
import java.util.Optional;
            }
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
import static org.hamcrest.Matchers.equalTo;  
            final ClusterState initialClusterState = ClusterState.builder(new ClusterName(ClusterManagerServiceTests.class.getSimpleName()))
                @Override
                .successes(tasks)
                    @Override
    public void testClusterStateBatchedUpdates() throws BrokenBarrierException, InterruptedException {
                            task1.getKey(),
                                    threadName,  
                    Level.WARN,
                    }
            ) {
                }
                    }
                    @Override  
                    "*took [*], which is over [10s], to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test3]"  
                        throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");  
 */
            }
                    emptySet(),  
            threads.add(new Thread(new Runnable() {
                    }
                                future.get(1L, TimeUnit.SECONDS);
                latch.countDown();
                clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
import org.opensearch.telemetry.metrics.noop.NoopMetricsRegistry;  
                    } catch (BrokenBarrierException | InterruptedException e) {  
                        published.set(true);  
                                Map<Task, ClusterStateTaskListener> taskListeners = new HashMap<>();
                }
                    public ClusterState execute(ClusterState currentState) {  
import java.util.concurrent.ConcurrentMap;
                throw new AssertionError(e);
                            submittedTasksPerThread.computeIfAbsent(threadName, key -> new AtomicInteger()).addAndGet(tasks.size());
                latch.countDown();
                    }  
                    .build(),  
 *     http://www.apache.org/licenses/LICENSE-2.0
                @Override
                    ClusterState newClusterState = ClusterState.builder(currentState).build();  
                }
                    "*took [*], which is over [10s], to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test4]"
                    public void onFailure(String source, Exception e) {
        AtomicInteger throttledTask2 = new AtomicInteger();  
            .build();  
                    try {
            mockAppender.addExpectation(  
                    ClusterManagerService.class.getCanonicalName(),
                });
            clusterManagerService.submitStateUpdateTask(  
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                    "test2 failure",
            );
                new ClusterStateTaskListener() {
                    }
                )
        final ClusterStateTaskListener listener = new ClusterStateTaskListener() {
                    new ClusterName(ClusterManagerServiceTests.class.getSimpleName())
/*  
                ClusterStateTaskConfig.build(randomFrom(Priority.values())),  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            mockAppender.addExpectation(
                Settings.builder()
                    }
                        barrier.await();
                    }
                        timeDiffInMillis += TimeValue.timeValueSeconds(2).millis();
            barrier.await();
            ) {  
                });
                final ClusterState initialClusterState = ClusterState.builder(  
                    "*took*test5*"
                        fail();
     * Returns the cluster state that the cluster-manager service uses (and that is provided by the discovery layer)  
                )  
                    "failed to execute cluster state update (on version: [*], uuid: [*]) for [test2]*"
            }
            assertEquals(Collections.emptyMap(), threadPool.getThreadContext().getResponseHeaders());
        AtomicInteger timedOutTask3 = new AtomicInteger();
        }
                @Override
                    "took [3s] to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test3]"
                    @Override  
            @Override
                }  
                    public ClusterState execute(ClusterState currentState) {  
                    buildNewFakeTransportAddress(),
                new ClusterManagerMetrics(metricsRegistry)
                    }
        assertThat(ClusterManagerService.assertClusterManagerUpdateThread(), is(Boolean.TRUE));  
                )
                    }
                    public ClusterState execute(ClusterState currentState) {
                        return ClusterState.builder(currentState).incrementVersion().build();  
                        latch.countDown();  
            }
                latch.await();
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = clusterManagerService.registerClusterManagerTask(task, true);
                    @Override  
        final DiscoveryNode node2 = new DiscoveryNode("node2", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);  
                        fail();
                    buildNewFakeTransportAddress(),
                }
                            } else {  
            @Override
import java.util.ArrayList;
            totalTaskCount += taskCount;
import org.opensearch.telemetry.metrics.MetricsRegistry;
                        new FailedToCommitClusterStateException("mock exception")
                    try {  
                    public ClusterState execute(ClusterState currentState) {  
                        return null;
                        // Exception should be RejactedExecutionException.  
                    @Override  
                    Level.DEBUG,
                    @Override  
            @Override
                    "test1 computation",  
                    Level.DEBUG,
                            ClusterStateTaskConfig.build(randomFrom(Priority.values())),
import java.util.HashMap;  
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());  
        threadPool = new TestThreadPool(ClusterManagerServiceTests.class.getName()) {  
                    "test5 should not log despite publishing slowly",
                        fail("Interrupted");
                processedFirstTask.await();
                final CountDownLatch latch = new CountDownLatch(1);
            mockAppender.addExpectation(
 * specific language governing permissions and limitations
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                published.incrementAndGet();
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            }
                    } else {
                    }
                    @Override  
import java.util.concurrent.CyclicBarrier;
                ClusterStateTaskConfig.build(randomFrom(Priority.values()), TimeValue.timeValueMillis(1L)),
            // wait for all threads to be ready
                    "executing cluster state update for [test3]"
                    }
 * the Apache License, Version 2.0 (the "License"); you may
        latch.await();
            final AtomicReference<ClusterStatePublisher> publisherRef = new AtomicReference<>();
                return clusterStateComputeHistogram;  
            );  
                        latch.countDown();
        boolean makeClusterManager,
    public void testClusterStateTaskListenerThrowingExceptionIsOkay() throws InterruptedException {  
                        throw new IllegalStateException(source);
                this.id = id;  
                    }
                )
                new MockLogAppender.SeenEventExpectation(
                    threadPool.getThreadContext().addResponseHeader("testResponse", "testResponse");  
                        return null;  
        });  
            clusterManagerService.setClusterStatePublisher((e, pl, al) -> publisherRef.get().publish(e, pl, al));  
                ClusterManagerService clusterManagerService = new ClusterManagerService(  
                });
import org.opensearch.common.util.concurrent.BaseFuture;
                                future.get();  
            @Override  
        });  
        return clusterManagerService;
            clusterManagerService.setClusterStateSupplier(() -> initialClusterState);
                        return ClusterTasksResult.builder().successes(tasks).build(newClusterState);
                assertEquals(
                });
                    latch.countDown();
                    @Override
                    .build(),
                    public void onFailure(String source, Exception e) {
import static java.util.Collections.emptyMap;
        try (ThreadContext.StoredContext ignored = threadPool.getThreadContext().stashContext()) {
import org.opensearch.common.settings.ClusterSettings;
            }
import com.carrotsearch.randomizedtesting.annotations.Timeout;
                    } catch (InterruptedException e) {  
import java.util.HashSet;
            @Override
        // wait till task enter in execution.
            // check that we don't time out before even committing the cluster state
                    @Override
import org.opensearch.cluster.block.ClusterBlocks;
                clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
                    public void onFailure(String source, Exception e) {
                        fail();  
    public void testThrottlingForTaskSubmission() throws InterruptedException {
                Thread.sleep(randomInt(1000));
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX;
                    @Override
                    assertEquals("timeout", source);
                assertBusy(() -> assertEquals(1, clusterManagerService.getClusterStateStats().getUpdateSuccess()));
            mockAppender.addExpectation(
        class Task {  
            );
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {  
                    @Override
                });  
                new MockLogAppender.SeenEventExpectation(
                )
import static java.util.Collections.emptySet;  
                final int index = i;  
        final CountDownLatch latch2 = new CountDownLatch(1);
                        fail();
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        try (
                        anyOf(equalTo(0L), equalTo((long) expectedSet.size()))  
        class Task1 extends Task {}  
                    public void onFailure(String source, Exception e) {
                    Level.DEBUG,  
                    "test1 notification",
                    "test1 shouldn't log because it was fast enough",
            mockAppender.addExpectation(
                });
import org.opensearch.cluster.ClusterState;
                assignments.add(Tuple.tuple(executor, tasks));
        final CountDownLatch latch = new CountDownLatch(1);
        final DiscoveryNode node3 = new DiscoveryNode("node3", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    }  
                        } catch (Exception e) {
                    }  
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());  
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {  
                clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {  
                    "node1",  
                if (o == null || getClass() != o.getClass()) {
                    ClusterStateTaskConfig.build(randomFrom(Priority.values())),  
                    @Override  
            // wait until all the cluster state updates have been processed  
                    @Override  
            private AtomicInteger published = new AtomicInteger();  
                    "test4",
                    counter.incrementAndGet();
        Optional<MetricsRegistry> metricsRegistryOptional  
            }  
                    ackListener.onNodeAck(node1, null);
                }  
    * executor
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {
                    @Override  
                    @Override
import static org.hamcrest.Matchers.is;
                )  
                        ).millis() + randomLongBetween(1, 1000000);
                    @Override
                    Level.DEBUG,
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterManagerService.class))) {
        }  
import org.opensearch.common.util.concurrent.ThreadContext;
            try (
                    }
    }
                )
                        .put(Node.NODE_NAME_SETTING.getKey(), "test_node")
                    }  
                        timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(
                    ClusterManagerService.class.getCanonicalName(),
                new MockLogAppender.SeenEventExpectation(
            public void onFailure(String source, Exception e) {  
                new Object(),  
                public void onFailure(String source, Exception e) {
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
    }  
                public TimeValue timeout() {
                    @Override  
                    }  
            @Override
                    @Override
                            0L,
            @Override
                clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {
import static org.mockito.ArgumentMatchers.anyDouble;
                        .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())  
    public void testClusterStateUpdateLoggingWithTraceEnabled() throws Exception {  
            }
            );
                    @Override  
        final ClusterManagerTask task = CREATE_INDEX;
        assertThrows(AssertionError.class, () -> ClusterManagerService.assertNotClusterManagerUpdateThread("test"));
                return throttlingKey3;  
        latch2.await();
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
    }
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
                    @Override
import org.opensearch.threadpool.ThreadPool;
    }
                    Settings.builder()
                        ).millis() + randomLongBetween(1, 1000000);
            }  
                    long count = tasks.stream().filter(expectedSet::contains).count();
        timeDiffInMillis = randomLongBetween(0L, 1L << 50);  
                    }
        class Task2Executor implements ClusterStateTaskExecutor<Task> {
                    "took [3s] to compute cluster state update for [test3]"
                    ClusterManagerService.class.getCanonicalName(),
import java.util.List;
                @Override
import org.opensearch.cluster.ClusterName;
            // start a task and wait for it to start and block on the clusterStateProcessed callback
            final AtomicInteger failureCount = new AtomicInteger();
 * GitHub history for details.
                    Level.TRACE,  
        clusterManagerService.setClusterStateSupplier(clusterStateRef::get);  
        }  
            threadPool.getThreadContext().putHeader(expectedHeaders);
                    @Override  
                            Settings.EMPTY
            mockAppender.addExpectation(
        AtomicBoolean published = new AtomicBoolean();
                new MockLogAppender.SeenEventExpectation(
                clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
    }  
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                    public void onFailure(String source, Exception e) {  
                threadPool  
                    ClusterManagerService.class.getCanonicalName(),
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            executors.add(new TaskExecutor(taskGroups));
            clusterManagerService = new ClusterManagerService(  
                                    threadName,
                        fail();
                        }
                            executor1,
            @Override
                    }  
import org.opensearch.Version;  
                    public ClusterState execute(ClusterState currentState) {
                    @Override
                    "test1 notification",
            @Override
        assertEquals(numberOfTask1, throttledTask1.get() + succeededTask1.get());  
                clusterManagerService.submitStateUpdateTask("test6", new ClusterStateUpdateTask() {
                    return null;  
            if (histogramName.contains("cluster.state.new.compute.latency")) {
                        timeDiffInMillis += TimeValue.timeValueSeconds(4).millis();
                    "test1 computation",  
                            Settings.EMPTY
                        fail();
                    emptySet(),
                    @Override
                    Level.TRACE,
                    @Override
            }
                )  
            mockAppender.addExpectation(
        clusterManagerService.clusterManagerTaskThrottler.updateLimit(task3.getKey(), throttlingLimitForTask3);  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        count,
                    @Override
                    } catch (ClusterManagerThrottlingException e) {
                new MockLogAppender.SeenEventExpectation(
                    @Override
                    try {  
    @TestLogging(value = "org.opensearch.cluster.service:TRACE", reason = "to ensure that we log cluster state events on TRACE level")
                    Level.DEBUG,
            );  
            private final List<Set<Task>> taskGroups;
                return unchanged();
                    }
        }  
                    @Override
                        latch.countDown();
                )  
        clusterManagerService.start();
                    .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
                // We don't check logging for this on since there is no guarantee that it will occur before our check
                    }
                    }  
                    ClusterManagerService.class.getCanonicalName(),
                    }
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}
                    @Override
        };
        });
                @Override
                public void onFailure(String source, Exception e) {
                        };
        ClusterManagerService clusterManagerService = createClusterManagerService(true);  
                    }
            // wait for all threads to finish  
            .nodes(
                @Override  
            );
                    .build();  
                latch.countDown();
            }  
                            assertionRef.set(e);
    public void testTaskTimeout() throws InterruptedException {
                    }
                        return currentState;
            }
                    }
                )
                        throttledTask1.incrementAndGet();
                // verify stats values after state is published
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {  
        }  
                clusterManagerService.submitStateUpdateTask("test3", new ClusterStateUpdateTask() {  
                )  
            for (TaskExecutor executor : executors) {  
                    Level.DEBUG,
import org.apache.logging.log4j.LogManager;
                    }  
                } else if (source.equals(task2.getKey())) {
                    "took [2s] to compute cluster state update for [test2]"  
                    ClusterManagerService.class.getCanonicalName(),
            public void onFailure(String source, Exception e) {  
            {
            @Override
            Task(int id) {
            }
                            executor2,
    * notification does not prevent publication notification to the  
                )  
        AtomicInteger succeededTask2 = new AtomicInteger();  
                        timeDiffInMillis += TimeValue.timeValueSeconds(3).millis();
                    ClusterManagerService.class.getCanonicalName(),
import org.opensearch.cluster.LocalClusterUpdateTask;
                            task3.getKey(),
    public void testLongClusterStateUpdateLoggingForFailedPublication() throws Exception {
            public ClusterState execute(ClusterState currentState) {
                new MockLogAppender.SeenEventExpectation(  
            }  
                    ClusterManagerService.class.getCanonicalName(),
                            executor3,
                        latch.countDown();
                public TimeValue ackTimeout() {  
import static org.mockito.Mockito.mock;  
                            ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(Settings.EMPTY).millis()
                    "executing cluster state update for [test1]"
            );  
                final CountDownLatch processedFirstTask = new CountDownLatch(1);
            @Override  
                    public void onAckTimeout() {
        Thread.currentThread().setName(ClusterManagerService.CLUSTER_MANAGER_UPDATE_THREAD_NAME);
    }  
        final CyclicBarrier barrier = new CyclicBarrier(2);
                blockingListener
            }  
                        blockingTaskLatch.await();
                            new Task2(),
                listener
                },
                    ClusterManagerService.class.getCanonicalName(),  
            }));
import java.util.concurrent.CountDownLatch;  
            if (histogramName.contains("cluster.state.new.compute.latency")) {
                ClusterStateTaskConfig.build(randomFrom(Priority.values())),  
                    @Override
            mockAppender.addExpectation(  
        List<Set<Task>> taskGroups = new ArrayList<>();
                clusterManagerService.submitStateUpdateTask("test3", new ClusterStateUpdateTask() {
                        latch.countDown();
                    "not all tasks submitted by " + entry.getKey() + " received a processed event",
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    private static long timeDiffInMillis;
                    "test3",  
        // submit one task which will be execution, post that will submit throttlingLimit tasks.
                        return currentState;  
            private AtomicInteger counter = new AtomicInteger();  
                    Version.CURRENT
                    "test2 start",
                    @Override
                        timeDiffInMillis += TimeValue.timeValueSeconds(4).millis();
        verify(clusterStateComputeHistogram, times(1)).record(anyDouble(), any());
                new MockLogAppender.SeenEventExpectation(
    public void testAcking() throws InterruptedException {
            mockAppender.addExpectation(
                    }
                latch.await();
            clusterManagerService.submitStateUpdateTask(  
        ConcurrentMap<String, AtomicInteger> processedStates = new ConcurrentHashMap<>();  
        ClusterManagerTask task3 = DELETE_INDEX;  
        List<Thread> threads = new ArrayList<Thread>();
        final boolean[] taskFailed = { false };
                        return currentState;
                    try {  
        latch.await();
    public void testLongClusterStateUpdateLogging() throws Exception {
    public void testClusterStateUpdateLoggingWithDebugEnabled() throws Exception {  
        }
                    @Override
                });
                        latch.countDown();
        } catch (Exception e) {
}  
                    threadPool,
            // assert the correct number of clusterStateProcessed events were triggered
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
                ClusterStateTaskConfig.build(randomFrom(Priority.values())),  
                // verify stats values after state is published
                    ClusterManagerService.class.getCanonicalName(),  
                    return ackTimeout;
                    @Override  
                clusterManagerService.setClusterStateSupplier(clusterStateRef::get);
 * compatible open source license.
            @Override  
                        .build(),
                @Override  
                    public ClusterState execute(ClusterState currentState) {
        } else {
        };
                    @Override
                    "test2 computation",  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}  
        ClusterManagerTask task2 = PUT_MAPPING;
                // We don't check logging for this on since there is no guarantee that it will occur before our check
            )
            semaphore.acquire(numberOfExecutors);  
                taskGroups.add(tasks);  
                    ClusterManagerService.class.getCanonicalName(),  
                )
                @Override  
            }
    public static void createThreadPool() {
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());  
                            if (randomBoolean()) {  
            throw new AssertionError(e);
            assertThat(assertionRef.get().getMessage(), containsString("Reason: [Blocking operation]"));
                    "test3 start",
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey1 = clusterManagerService.registerClusterManagerTask(task1, true);
                return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);  
        }
                clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {
                updateLatch.countDown();
        int numberOfThreads = randomIntBetween(2, 8);
    }
                    assertFalse(threadPool.getThreadContext().isSystemContext());
            mockAppender.addExpectation(
                "testClusterStateTaskListenerThrowingExceptionIsOkay",  
        try {
                new MockLogAppender.SeenEventExpectation(  
        final CountDownLatch latch = new CountDownLatch(1);  
            final TimeValue clusterManagerTimeout = randomBoolean() ? TimeValue.ZERO : TimeValue.timeValueMillis(randomInt(10000));
                    }
                return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);
    }  
            );  
                } else if (source.equals(task3.getKey())) {
            }
                return id;
    private ClusterManagerService createClusterManagerService(
                    public void onFailure(String source, Exception e) {
                }  
        int taskId = 0;
                    public void onFailure(String source, Exception e) {
            }  
                if (randomBoolean()) {  
                taskFailed[0] = true;
                            ClusterStateTaskConfig.build(randomFrom(Priority.values()), new TimeValue(0)),
                    ClusterManagerService.class.getCanonicalName(),  
                    ClusterManagerService.class.getCanonicalName(),
                    try {
            @Override
                        return ClusterState.builder(currentState).incrementVersion().build();  
            public void onFailure(String source, Exception e) {
                    new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
                    "executing cluster state update for [test2]"
            clusterManagerService.submitStateUpdateTask(
                    }  
                    fail("Unexpected success");  
        AtomicInteger succeededTask1 = new AtomicInteger();
                    .localNodeId(localNode.getId())
                    }  
                )  
                        return currentState;
        final Semaphore semaphore = new Semaphore(numberOfExecutors);
            );
                                    ClusterStateTaskConfig.build(randomFrom(Priority.values())),
        }  
                                    executor,  
                clusterManagerService.start();
                    new ClusterManagerMetrics(NoopMetricsRegistry.INSTANCE)
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            }
                        timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(
                clusterManagerService.submitStateUpdateTask("test4", new ClusterStateUpdateTask() {
            }
                });  
        }  
                    Level.WARN,  
            // start a second task that is guaranteed to timeout as the first task is still running  
                        timeDiffInMillis += TimeValue.timeValueSeconds(2).millis();
            @Override
/*  
            threads.add(new Thread(new Runnable() {  
                        fail();
                    "executing cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test3]"
            private AtomicInteger batches = new AtomicInteger();
                }
                    "*took*test1*"
        final ClusterStateTaskListener listener = new ClusterStateTaskListener() {
 */  
                taskFailed[0] = true;  
            @Override
        assertThrows(AssertionError.class, () -> ClusterManagerService.assertClusterManagerUpdateThread());
            @Override
            private AtomicInteger published = new AtomicInteger();
                )
                new MockLogAppender.SeenEventExpectation(
                    Version.CURRENT
                latch2.countDown();
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
import org.opensearch.cluster.AckedClusterStateUpdateTask;
import org.opensearch.telemetry.metrics.Histogram;
        }
            clusterManagerService.submitStateUpdateTask("test", new AckedClusterStateUpdateTask<Void>(null, null) {
                return clusterStateComputeHistogram;  
            final int taskCount = assignment.v2().size();
            return clusterStatePublishHistogram;
                    @Override  
                clusterManagerService.submitStateUpdateTask("test4", new ClusterStateUpdateTask() {
            try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
                                );
            );  
                    }
                            final TaskExecutor executor = assignment.v1();  
        clusterManagerService.close();
import java.util.Set;
                        for (int j = 0; j < taskSubmissionsPerThread; j++) {
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                        barrier.await();
                )
import org.junit.BeforeClass;
        final MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);  
        final DiscoveryNode node1 = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
 * this file be licensed under the Apache-2.0 license or a
            );
            mockAppender.addExpectation(
        assertTrue("cluster state update task was executed on a non-cluster-manager", taskFailed[0]);  
                }
                if (!state.compareAndSet(false, true)) {
        }
                        timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(  
                public void onAllNodesAcked(@Nullable Exception e) {
                executor,
            barrier.await();
                    }
        try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
        }
import org.opensearch.common.Nullable;
                    "took [0s] to notify listeners on unchanged cluster state for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]"
                    "test2 notification",
                    "test2 start",
    @BeforeClass
                        latch.countDown();
                    latch.countDown();
/*
                    }
        for (int i = 0; i < throttlingLimit; i++) {
        }
                    ClusterManagerService.class.getCanonicalName(),  
                new Task(taskId++),
                    Level.DEBUG,  
            @Override
    }
    public void testThrottlingForMultipleTaskTypes() throws InterruptedException {
                    );
                            Settings.EMPTY  
    }  
                ClusterStateTaskConfig.build(Priority.NORMAL),
        }
 */  
                    public void onFailure(String source, Exception e) {}  
            final ConcurrentMap<String, AtomicInteger> submittedTasksPerThread = new ConcurrentHashMap<>();  
                tasks.forEach(Task::execute);  
            assertEquals(1, successCount.get());
        clusterManagerService.close();
            try {
                    @Override
                    @Override  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
                new MockLogAppender.SeenEventExpectation(  
                }  
                    "took [4s] to notify listeners on successful publication of cluster state (version: *, uuid: *) for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test3]"  
                @Override
            private AtomicBoolean state = new AtomicBoolean();
                    }  
                            Tuple<TaskExecutor, Set<Task>> assignment = assignments.get(index * taskSubmissionsPerThread + j);  
            final ClusterStateTaskListener blockingListener = new ClusterStateTaskListener() {  
                        );
                    emptyMap(),
        }  
                    ClusterManagerService.class.getCanonicalName(),  
                    public ClusterState execute(ClusterState currentState) {
                    "test2 computation",  
            @Override  
                assertThat(submittedTasksPerThread, hasKey(entry.getKey()));  
        } catch (ClusterManagerThrottlingException e) {
                    public ClusterState execute(ClusterState currentState) {
                    Settings.builder()
                    .put(Node.NODE_NAME_SETTING.getKey(), "test_node")  
        int taskSubmissionsPerThread = randomIntBetween(1, 64);  
                });
                        fail();
            );  
                    batches.incrementAndGet();
            }
            }));  
                    Level.DEBUG,
                return throttlingKey;
                });  
                    .build(),
            mockAppender.assertAllExpectationsMatched();
                    }  
                        clusterManagerService.submitStateUpdateTask(  
                        throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");  
                @Override  
        }  
                )  
                TaskExecutor executor = randomFrom(executors);
                "timeout",
                    }
                        try {
                    .put(Node.NODE_NAME_SETTING.getKey(), "test_node")
            };
        latch1.await();
                    submittedTasksPerThread.get(entry.getKey()).get()
        }
                    "node1",
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}
                    return true;
        }
        final AtomicReference<AssertionError> assertionRef = new AtomicReference<>();
import java.util.concurrent.atomic.AtomicReference;  
                            Settings.EMPTY
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterManagerService.class))) {
            );
import org.opensearch.OpenSearchException;
                        latch.countDown();  
                }
            }
                    "test4",  
        int taskId = 1;
                    successCount.incrementAndGet();
                    Level.WARN,
                                );
                this.taskGroups = taskGroups;
                .nodes(  
                    Level.TRACE,  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
    /*
            );  
     */
                    public ClusterState execute(ClusterState currentState) {
        int numberOfTask1 = randomIntBetween(throttlingLimitForTask1, 10);
    public void testClusterManagerAwareExecution() throws Exception {
            mockAppender.addExpectation(
                    ClusterManagerService.class.getCanonicalName(),
            }  
                    "took [2s] to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]"  
                published.incrementAndGet();
                    publishListener.onResponse(null);
                    "executing cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]"
        // randomly assign tasks to executors
                clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {  
                });
        };  
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                assertBusy(mockAppender::assertAllExpectationsMatched);  
 * ownership. Elasticsearch licenses this file to you under  
                    }
                    "took [0s] to notify listeners on unchanged cluster state for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test1]"
    }
import org.junit.Before;
                    return ClusterStateTaskExecutor.ClusterTasksResult.builder().successes(tasks).build(newClusterState);
                    (clusterChangedEvent, publishListener, ackListener) -> publishListener.onFailure(  
                        );  
                    "executing cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test1]"
                    }
                                clusterManagerService.submitStateUpdateTasks(  
public class ClusterManagerServiceTests extends OpenSearchTestCase {
                            ClusterStateTaskConfig.build(randomFrom(Priority.values())),  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    protected Void newResponse(boolean acknowledged) {
                        return ClusterState.builder(currentState).incrementVersion().build();  
                    }
            final ClusterStateTaskListener timeoutListener = new ClusterStateTaskListener() {
    }
            final TimeValue ackTimeout = randomBoolean() ? TimeValue.ZERO : TimeValue.timeValueMillis(randomInt(10000));
                }
                    }
                });  
    public static ClusterState discoveryState(ClusterManagerService clusterManagerService) {
            final CountDownLatch blockingTaskLatch = new CountDownLatch(1);
                    public void onFailure(String source, Exception e) {
                            if (tasks.size() == 1) {
            );
                    if (event.source().contains("test5")) {
            assertNotNull(assertionRef.get());
                    entry.getValue().get(),  
                        clusterManagerService.submitStateUpdateTask(
                latch.await();
package org.opensearch.cluster.service;
        nonClusterManager.close();
import org.apache.logging.log4j.Level;  
                    }
                    assertEquals(Collections.emptyMap(), threadPool.getThreadContext().getHeaders());
            String histogramName = (String) invocationOnMock.getArguments()[0];
                    "test3 notification",  
                    failureCount.incrementAndGet();  
                        BaseFuture<Void> future = new BaseFuture<Void>() {  
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
                    ClusterManagerService.class.getCanonicalName(),
                    @Override
                    ClusterManagerService.class.getCanonicalName(),
            Task(int id) {  
                    Level.DEBUG,
                for (int t = randomInt(3); t >= 0; t--) {  
                        fail();
                                    taskListeners,
            }
 * this work for additional information regarding copyright
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    Level.WARN,
                new Task(taskId++),
                        return currentState;
                    @Override
        final CountDownLatch latch = new CountDownLatch(1);  
                    )
            mockAppender.addExpectation(  
            timeoutLatch.await();
            // wait for the timeout to happen, then unblock and assert one success and one failure  
                executor,
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                publisherRef.set((clusterChangedEvent, publishListener, ackListener) -> {
                    @Override
                    public ClusterState execute(ClusterState currentState) {
                );
                @Override
            );
                    latch.countDown();
                        fail();
                        return ClusterState.builder(currentState).incrementVersion().build();  
                .build();
                            throw new RuntimeException(e);  
            private final int id;
                        "batched set should be executed together or not at all. Expected " + expectedSet + "s. Executing " + tasks,
            @Override
                return throttlingKey1;
                    ackListener.onNodeAck(node2, null);
                threadPool,  
            latch.await();  
                    Level.DEBUG,  
                }
                    }
                    @Override  
        class Task3 extends Task {}
                )
            clusterManagerService.start();
                    emptyMap(),  
        });
            // and until all of the publication callbacks have completed
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                return id == task.id;
                    @Override
        final Histogram clusterStatePublishHistogram = mock(Histogram.class);
        nonClusterManager.submitStateUpdateTask("test", new ClusterStateUpdateTask() {  
            }
import org.opensearch.cluster.node.DiscoveryNodes;  
        }
                        .put(Node.NODE_NAME_SETTING.getKey(), "test_node")  
                    .put(Node.NODE_NAME_SETTING.getKey(), "test_node")  
        final Histogram clusterStateComputeHistogram = mock(Histogram.class);
                final CountDownLatch latch = new CountDownLatch(1);  
                    clusterStateRef.set(event.state());
                } else {  
                new MockLogAppender.SeenEventExpectation(
                    }
                            latch.countDown();  
        }  
    @AfterClass
                        );  
import org.opensearch.cluster.coordination.ClusterStatePublisher;  
                );  
                return currentState;
                executor,
        latch.await();
import org.opensearch.cluster.ClusterStateTaskConfig;  
import org.opensearch.cluster.node.DiscoveryNode;
        }
        }
        int numberOfExecutors = Math.max(1, numberOfThreads / 4);
                });
import static org.hamcrest.Matchers.hasKey;
                    }
                    public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {
                @Override
                counter.addAndGet(tasks.size());
                    @Override
 *  
                    } catch (ClusterManagerThrottlingException e) {
                    new ClusterName(ClusterManagerServiceTests.class.getSimpleName())
 * under the License.  
import org.opensearch.test.junit.annotations.TestLogging;  
                    public void onFailure(String source, Exception e) {
import java.util.concurrent.ConcurrentHashMap;
        // we have one task in execution and tasks in queue so next task should throttled.  
                    final String threadName = Thread.currentThread().getName();
                public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
            }  
                            new Task3(),  
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey2 = clusterManagerService.registerClusterManagerTask(task2, true);  
                clusterManagerService.setClusterStateSupplier(clusterStateRef::get);
                    public ClusterState execute(ClusterState currentState) {
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterManagerService.class))) {
    private static ThreadPool threadPool;
                    assertEquals(executor.batches.get(), executor.published.get());  
                            listener  
                    @Override
                    "test1 should log due to slow and failing publication",
                    @Override  
            @Override
            });
                    @Override  
import java.util.concurrent.atomic.AtomicInteger;
                    .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
                    "test3 notification",  
                    new Task(taskId++),
                return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);  
                    public ClusterState execute(ClusterState currentState) {
                new MockLogAppender.UnseenEventExpectation(  
                    }  
import static org.mockito.Mockito.times;
                    "test3 computation",
                    @Override
                processedStates.computeIfAbsent(source, key -> new AtomicInteger()).incrementAndGet();  
                    }  
                threadPool,
                public void onFailure(String source, Exception e) {
                    ClusterManagerService.class.getCanonicalName(),  
                clusterManagerService.submitStateUpdateTask("test1", new ClusterStateUpdateTask() {
            }));
                new MockLogAppender.SeenEventExpectation(
        final CountDownLatch latch = new CountDownLatch(1);  
                    }
                        fail();
                clusterManagerService.submitStateUpdateTask(  
import java.util.Map;  
                new MockLogAppender.SeenEventExpectation(
                });
        }  
                    Level.DEBUG,
                    assertFalse(threadPool.getThreadContext().isSystemContext());
                    ClusterManagerService.class.getCanonicalName(),
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {  
        class TaskExecutor implements ClusterStateTaskExecutor<Task> {
                final CountDownLatch latch = new CountDownLatch(2);  
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        class Task3Executor implements ClusterStateTaskExecutor<Task> {  
                    taskStartLatch.countDown();  
                        clusterManagerService.submitStateUpdateTask(
                "testResponse",
                clusterManagerService.submitStateUpdateTask("test2", new AckedClusterStateUpdateTask<Void>(null, null) {
                    @Override
        clusterManagerService.clusterManagerTaskThrottler.updateLimit(task1.getKey(), throttlingLimitForTask1);
            public void onFailure(String source, Exception e) {}  
                Task task = (Task) o;
                    Level.DEBUG,
import java.util.concurrent.Semaphore;
                )
            @Override
        };  
                        } catch (AssertionError e) {
        final ClusterManagerService clusterManagerService = createClusterManagerService(true);
                }  
                        timeDiffInMillis += TimeValue.timeValueSeconds(3).millis();
    @TestLogging(value = "org.opensearch.cluster.service:DEBUG", reason = "to ensure that we log cluster state events on DEBUG level")
            }
                    ClusterManagerService.class.getCanonicalName(),
                    throw new OpenSearchException("simulated error during slow publication which should trigger logging");  
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        for (Thread thread : threads) {  
    public void testBlockingCallInClusterStateTaskListenerFails() throws InterruptedException {
        int throttlingLimitForTask1 = randomIntBetween(1, 5);
                            }  
                    public ClusterState execute(ClusterState currentState) {
                new MockLogAppender.SeenEventExpectation(
                            }
 * Modifications Copyright OpenSearch Contributors. See
        int numberOfTask2 = randomIntBetween(throttlingLimitForTask2, 10);
import org.opensearch.cluster.ClusterStateTaskListener;
                assertBusy(mockAppender::assertAllExpectationsMatched);  
                    Level.TRACE,
        Task2Executor executor2 = new Task2Executor();
                public void run() {
                    assertFalse(threadPool.getThreadContext().isSystemContext());
            public String toString() {  
                        fail();  
                new MockLogAppender.SeenEventExpectation(
                                    executor
        try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
                }
                )
                    "test3 computation",
                final AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialClusterState);  
        int numberOfTask3 = randomIntBetween(throttlingLimitForTask3, 10);  
                )
            );
            );
                    "executing cluster state update for [test4]"  
            );  
                            new Task1(),  
                assertBusy(() -> assertEquals(0, clusterManagerService.getClusterStateStats().getUpdateFailed()));  
                task.getKey(),
            latch.await();  
        List<Tuple<TaskExecutor, Set<Task>>> assignments = new ArrayList<>();  
                Thread.sleep(randomInt(1000));
import org.opensearch.test.OpenSearchTestCase;
                }  
        int throttlingLimitForTask2 = randomIntBetween(1, 5);
                    ClusterManagerService.class.getCanonicalName(),
                });  
        final ClusterStateTaskListener listener = new ClusterStateTaskListener() {
    ) {
                        return ackTimeout;
        final ClusterState initialClusterState = ClusterState.builder(new ClusterName(ClusterManagerServiceTests.class.getSimpleName()))
                    "took [0s] to notify listeners on unchanged cluster state for [test1]"
                if (counts.containsKey(executor)) {
        final Histogram clusterStateComputeHistogram = mock(Histogram.class);
            }
                    .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))  
                });  
                    public ClusterState execute(ClusterState currentState) {
                timedOutTask3.incrementAndGet();  
                    } catch (ClusterManagerThrottlingException e) {
                timeoutListener  
            try (  
        for (int i = 0; i < numberOfExecutors; i++) {
                return throttlingKey2;
            for (Map.Entry<String, AtomicInteger> entry : processedStates.entrySet()) {
                        fail();  
            }  
    }
                Collections.singletonList("testResponse")  
            final CountDownLatch timeoutLatch = new CountDownLatch(1);
                ClusterStateTaskConfig.build(Priority.NORMAL),
            clusterManagerService.submitStateUpdateTask(  
            );  
                Settings.builder()
import org.opensearch.cluster.ClusterManagerMetrics;  
                clusterManagerService.submitStateUpdateTask("test2", new AckedClusterStateUpdateTask<Void>(null, null) {  
                    public void onFailure(String source, Exception e) {  
                clusterManagerService.submitStateUpdateTask("test2", new ClusterStateUpdateTask() {  
import static org.hamcrest.Matchers.anyOf;
                }  
                    timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(  
                        fail();  
            assertEquals(totalTaskCount, counter.get());  
    @Before
import java.util.concurrent.TimeUnit;  
                    succeededTask1.incrementAndGet();
            thread.start();
                    fail("Unexpected failure");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Task1Executor executor1 = new Task1Executor();
                new MockLogAppender.SeenEventExpectation(
                    timeoutLatch.countDown();
                final TimeValue ackTimeout = TimeValue.timeValueMillis(randomInt(100));
                new MockLogAppender.UnseenEventExpectation(  
                    public void onAckTimeout() {  
import org.opensearch.cluster.ClusterStateTaskExecutor;
                    @Override
                clusterManagerService.submitStateUpdateTask("test5", new ClusterStateUpdateTask() {
                if (source.equals(task1.getKey())) {  
                    .clusterManagerNodeId(makeClusterManager ? localNode.getId() : null)  
            public void execute() {  
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_INDEX;
        AtomicInteger throttledTask3 = new AtomicInteger();
            final Map<String, String> expectedHeaders = Collections.singletonMap("test", "test");  
        for (Tuple<TaskExecutor, Set<Task>> assignment : assignments) {
                    @Override  
            );
                        ).millis() + randomLongBetween(1, 1000000);  
                        timeDiffInMillis += randomLongBetween(  
                        );
                        Settings.EMPTY
                    public ClusterState execute(ClusterState currentState) {
                    }  
                new MockLogAppender.SeenEventExpectation(
                    throw new IllegalStateException();
            );  
                for (Set<Task> expectedSet : taskGroups) {
            mockAppender.addExpectation(  
                clusterManagerService.start();  
        final CountDownLatch updateLatch = new CountDownLatch(totalTaskCount);  
                                    ClusterStateTaskConfig.build(randomFrom(Priority.values())),  
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.cluster.ClusterChangedEvent;
import org.junit.AfterClass;  
                    "*took [*], which is over [10s], to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test2]"
        }
                    @Override  
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
                throw new AssertionError(e);
                        return currentState;  
                    @Override
            public boolean equals(Object o) {  
                            listener
 * Licensed to Elasticsearch under one or more contributor  
            counts.merge(assignment.v1(), taskCount, (previous, count) -> previous + count);  
                        fail();
            mockAppender.assertAllExpectationsMatched();  
 * You may obtain a copy of the License at  
                        return null;  
            threadPool.shutdownNow();
                return timeDiffInMillis * TimeValue.NSEC_PER_MSEC;  
        final DiscoveryNode localNode = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                    "test2 failure",
                    @Override
        }
 *
                    }
                }
        verify(clusterStatePublishHistogram, times(1)).record(anyDouble());
                public void run() {
                });
            );  
                    protected Void newResponse(boolean acknowledged) {  
                    @Override  
                    Level.TRACE,
                public void onAckTimeout() {  
                }
                });
        List<TaskExecutor> executors = new ArrayList<>();  
                    public void onFailure(String source, Exception e) {  
                        latch.countDown();  
            );
            publishListener.onResponse(null);
                latch.await();  
            mockAppender.addExpectation(  
                new Object(),  
                    "test1 start",
                listener
        assertEquals(numberOfTask3, throttledTask3.get() + timedOutTask3.get() + succeededTask3.get());  
            final Map<String, List<String>> expectedResponseHeaders = Collections.singletonMap(
                "success",
                final DiscoveryNode localNode = new DiscoveryNode(  
            mockAppender.addExpectation(  
            );
            );
            // assert the number of executed tasks is correct
                publisherRef.set(
                    ackListener.onCommit(TimeValue.timeValueMillis(ackTimeout.millis() + randomInt(100)));  
                                    listener
                    .add(localNode)
                });  
                .build(currentState);  
        return createClusterManagerService(makeClusterManager, Optional.empty());
            }  
            @Override
        Map<TaskExecutor, Integer> counts = new HashMap<>();
            );
import org.opensearch.common.collect.Tuple;  
                ClusterManagerService clusterManagerService = new ClusterManagerService(
            assertFalse(threadPool.getThreadContext().isSystemContext());  
        ) {  
                new MockLogAppender.SeenEventExpectation(
                            final Set<Task> tasks = assignment.v2();
                    public void onFailure(String source, Exception e) {
                final AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialClusterState);
        class Task2 extends Task {}
                }  
        final AtomicReference<ClusterState> clusterStateRef = new AtomicReference<>(initialClusterState);
                        fail();
            @Override  
                        return ClusterState.builder(currentState).build();
        clusterManagerService.setClusterStatePublisher((event, publishListener, ackListener) -> {
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey3 = clusterManagerService.registerClusterManagerTask(task3, true);
                    ).millis() + randomLongBetween(1, 1000000);
import org.opensearch.common.Priority;
                    }
                    if (randomBoolean()) {  
                    public ClusterState execute(ClusterState currentState) {
            mockAppender.addExpectation(
                clusterManagerService.submitStateUpdateTask("test4", new ClusterStateUpdateTask() {
                        return ClusterState.builder(currentState).incrementVersion().build();
                        .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
                    "took [4s] to notify listeners on successful publication of cluster state (version: *, uuid: *) for [test3]"  
                    Level.WARN,
    }  
                Settings.builder()  
import org.opensearch.common.unit.TimeValue;  
                // Additional update task to make sure all previous logging made it to the loggerName  
                    DiscoveryNodes.builder().add(node1).add(node2).add(node3).localNodeId(node1.getId()).clusterManagerNodeId(node1.getId())
            mockAppender.addExpectation(
                    "test2 notification",
        Thread.currentThread().setName("test not cluster manager update thread");
        for (int i = 0; i < numberOfTask2; i++) {
            }  
                new MockLogAppender.SeenEventExpectation(  
        if (metricsRegistryOptional != null && metricsRegistryOptional.isPresent()) {
        nonClusterManager.submitStateUpdateTask("test", new LocalClusterUpdateTask() {  
                new ClusterManagerMetrics(metricsRegistryOptional.get())  
            );
                executor,
            // assert each executor executed the correct number of tasks
                    }
        assertEquals(numberOfTask2, succeededTask2.get());
            }
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {  
            mockAppender.addExpectation(  
                )
                                    tasks.stream().findFirst().get(),
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {
                new MockLogAppender.SeenEventExpectation(
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}  
                    public ClusterState execute(ClusterState currentState) {
        int throttlingLimitForTask3 = randomIntBetween(1, 5);  
                    }  
            mockAppender.addExpectation(  
                    public void onFailure(String source, Exception e) {  
                // Task3's timeout should have called this.
                        latch.countDown();  
                );
            @Override
    }
                    .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
        AtomicInteger succeededTask3 = new AtomicInteger();
            threads.add(new Thread(new Runnable() {  
                        fail();  
            );
        AtomicInteger counter = new AtomicInteger();  
                    Level.DEBUG,
                semaphore.release();
                    Level.WARN,  
                        throw new IllegalArgumentException("mock failure");
        ClusterManagerTask task1 = CREATE_INDEX;
                    latch.countDown();
                ClusterState maybeUpdatedClusterState = currentState;
                    public TimeValue timeout() {  
            final ClusterStateTaskExecutor<Object> executor = (currentState, tasks) -> ClusterStateTaskExecutor.ClusterTasksResult.builder()
        if (threadPool != null) {
                    listener
            ClusterManagerService clusterManagerService = new ClusterManagerService(  
        try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {  
            }  
            mockAppender.addExpectation(
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
        final AtomicReference<ClusterManagerThrottlingException> assertionRef = new AtomicReference<>();
                    "test1 start",
                    public void onFailure(String source, Exception e) {
        TaskExecutor executor = new TaskExecutor();  
                    ClusterManagerService.class.getCanonicalName(),
                if (this == o) {
                    @Override  
                    public TimeValue timeout() {
                )
        // await for latch to clear
                )  
            }  
import static org.mockito.ArgumentMatchers.anyString;
                    assertThat(  
                    } else if (randomBoolean()) {
            for (int j = 0; j < taskSubmissionsPerThread; j++) {  
        final CountDownLatch latch = new CountDownLatch(numberOfTask1 + numberOfTask2 + numberOfTask3);
                    ClusterManagerService.class.getCanonicalName(),  
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {  
        final CountDownLatch latch1 = new CountDownLatch(1);
                    @Override
        final MetricsRegistry metricsRegistry = mock(MetricsRegistry.class);  
            mockAppender.addExpectation(
            public ClusterTasksResult<LocalClusterUpdateTask> execute(ClusterState currentState) {
                    public void onFailure(String source, Exception e) {}  
                    return false;
                    assertFalse(threadPool.getThreadContext().isSystemContext());
            @Override
                    .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
                        timeDiffInMillis += TimeValue.timeValueSeconds(1).millis();
                    @Override
    public void randomizeCurrentTime() {
                                clusterManagerService.submitStateUpdateTask(
            @Override
                    @Override  
            }
                    assertEquals((int) counts.get(executor), executor.counter.get());
                Set<Task> tasks = new HashSet<>();
                        return ClusterState.builder(currentState).build();  
        for (int i = 0; i < numberOfTask1; i++) {
        }
                    }
 * KIND, either express or implied.  See the License for the
                    @Override
                )
            );
                            } else {
        assumeTrue("assertions must be enabled for this test to work", BaseFuture.class.desiredAssertionStatus());
                    public void onFailure(String source, Exception e) {  
                assertBusy(() -> assertEquals(0, clusterManagerService.getClusterStateStats().getUpdateFailed()));  
            public int hashCode() {
                )  
                Thread.sleep(randomInt(1000));  
                    threadPool,  
                }
                    "took [1s] to compute cluster state update for [test1]"  
                    @Override
            taskStartLatch.await();
            );
                    @Override
        // configuring limits for Task1 and Task3. All task submission of Task2 should pass.
                            task2.getKey(),
                    publishListener.onResponse(null);
import org.opensearch.threadpool.TestThreadPool;
                });
    }
            mockAppender.addExpectation(  
        }
                }
                final ClusterState initialClusterState = ClusterState.builder(
import static org.mockito.Mockito.verify;
                        return TimeValue.ZERO;
            mockAppender.addExpectation(  
        clusterManagerService.close();
    public void testThreadContext() throws InterruptedException {
        class Task {
                    "test2",
            };
                task.getKey(),
                assertEquals(task3.getKey(), source);
            mockAppender.addExpectation(  
            .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        for (int i = 0; i < numberOfThreads; i++) {
                });
                    .put(ClusterName.CLUSTER_NAME_SETTING.getKey(), ClusterManagerServiceTests.class.getSimpleName())
 * Unless required by applicable law or agreed to in writing,
                return ClusterTasksResult.<Task>builder().successes(tasks).build(currentState);
                    tasks.add(new Task(taskId++));
import org.opensearch.test.MockLogAppender;
        class Task1Executor implements ClusterStateTaskExecutor<Task> {
        final ClusterManagerService nonClusterManager = createClusterManagerService(false, Optional.of(metricsRegistry));
 * not use this file except in compliance with the License.
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {  
import java.util.Collections;
                final CountDownLatch latch = new CountDownLatch(5);
                    .build();
            clusterManagerService = new ClusterManagerService(
                latch1.countDown();
                DiscoveryNodes.builder()  
            try (ClusterManagerService clusterManagerService = createClusterManagerService(true)) {
                        timeDiffInMillis += ClusterManagerService.CLUSTER_MANAGER_SERVICE_SLOW_TASK_LOGGING_THRESHOLD_SETTING.get(  
        });  
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                        throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");
            mockAppender.addExpectation(
                new ClusterStateTaskListener() {  
            );
                    public void onFailure(String source, Exception e) {  
                    Level.DEBUG,  
                new MockLogAppender.SeenEventExpectation(  
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());  
    }
                    Level.DEBUG,
                    maybeUpdatedClusterState = ClusterState.builder(currentState).build();
            blockingTaskLatch.countDown();
                    "took [*] and then failed to publish updated cluster state (version: *, uuid: *) for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test1]:*"
    public void testUpdateTaskThreadName() {
                    "took [1s] to compute cluster state update for [Tasks batched with key: org.opensearch.cluster.service.ClusterManagerServiceTests, count:1 and sample tasks: test1]"  
                (currentState, tasks) -> {
                        return currentState;
    */
                    }
                )  
import org.opensearch.common.settings.Settings;
    }
        assertEquals(0, throttledTask2.get());
                new MockLogAppender.UnseenEventExpectation(
            assertTrue(published.get());
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    }  
                                tasks.forEach(t -> taskListeners.put(t, listener));
                    }  
    @TestLogging(value = "org.opensearch.cluster.service:WARN", reason = "to ensure that we log failed cluster state events on WARN level")  
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.node.Node;  
                barrier.await();
                    "took [0s] to notify listeners on unchanged cluster state for [test2]"
            public ClusterTasksResult<Task> execute(ClusterState currentState, List<Task> tasks) throws Exception {  
                    public void onFailure(String source, Exception e) {}
                    ClusterManagerService.class.getCanonicalName(),  
        int throttlingLimit = randomIntBetween(1, 10);  
            );
            String histogramName = (String) invocationOnMock.getArguments()[0];
            );
                    public ClusterState execute(ClusterState currentState) {
            @Override
                    @Override  
        verify(clusterStateComputeHistogram, times(2)).record(anyDouble(), any());  
                    public TimeValue ackTimeout() {
                    public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {}
            );
                        }
                Thread thread = new Thread(() -> {
                    "test3 start",
                        throw new AssertionError(e);
                }  
                        return null;
            public long preciseRelativeTimeInNanos() {
            return clusterStatePublishHistogram;
 * The OpenSearch Contributors require contributions made to  
                @Override
    }
            CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
import org.opensearch.cluster.ClusterStateUpdateTask;  
                    Level.DEBUG,
                }
                    .nodes(DiscoveryNodes.builder().add(localNode).localNodeId(localNode.getId()).clusterManagerNodeId(localNode.getId()))
        final ClusterManagerService clusterManagerService;  
                        ClusterState newClusterState = ClusterState.builder(currentState).build();  
                    @Override
                    public void onFailure(String source, Exception e) {}
        AtomicInteger throttledTask1 = new AtomicInteger();
                taskFailed[0] = false;  
                public ClusterState execute(ClusterState currentState) {  
                )
                    semaphore.acquire();  
    @Timeout(millis = 5_000)
                    succeededTask2.incrementAndGet();  
            public void clusterStateProcessed(String source, ClusterState oldState, ClusterState newState) {
                    ClusterManagerService.class.getCanonicalName(),
                new MockLogAppender.SeenEventExpectation(
 *
                    }  
                );  
                        fail();
                )  
                return ClusterTasksResult.<Task>builder().successes(tasks).build(maybeUpdatedClusterState);
    @TestLogging(value = "org.opensearch.cluster.service:WARN", reason = "to ensure that we log cluster state events on WARN level")  
        class TaskExecutor implements ClusterStateTaskExecutor<Task> {
                latch1.countDown();  
            }
                return Integer.toString(id);
                    @Override
            clusterStateRef.set(event.state());  
            }
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_MAPPING;  
                // Additional update task to make sure all previous logging made it to the loggerName
                    public ClusterTasksResult<Object> execute(ClusterState currentState, List<Object> tasks) {
                new Object(),
                    }
                new MockLogAppender.SeenEventExpectation(
        final Histogram clusterStatePublishHistogram = mock(Histogram.class);
                assertBusy(() -> assertEquals(1, clusterManagerService.getClusterStateStats().getUpdateSuccess()));
                });  
                    "test4",  
