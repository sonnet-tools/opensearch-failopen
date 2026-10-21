                    fail();
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterApplierService.class))) {
                    ClusterApplierService.class.getCanonicalName(),
import org.junit.AfterClass;
            ClusterManagerMetrics clusterManagerMetrics
            );
            // Additional update task to make sure all previous logging made it to the loggerName
                }
        timedClusterApplierService.setNodeConnectionsService(createNoOpNodeConnectionsService());
    }
                public void onSuccess(String source) {
                    fail("should not be called");
            final CountDownLatch latch = new CountDownLatch(4);
        final ClusterSettings clusterSettings;
        protected boolean applicationMayFail() {
    }
        assertEquals(0, clusterApplierService.getCurrentApplicationDurationMs());
    }
            assertBusy(mockAppender::assertAllExpectationsMatched);
import org.opensearch.test.OpenSearchTestCase;
            "test",
            }
        nodes = state.nodes();
import static org.mockito.Mockito.verify;
                threadPool.getThreadContext().addResponseHeader("testResponse", "testResponse");
 * software distributed under the License is distributed on an
                    }
                } else {
            }
 * The OpenSearch Contributors require contributions made to
import org.opensearch.telemetry.metrics.MetricsRegistry;
            ClusterState.builder(new ClusterName("ClusterApplierServiceTests"))
        clearInvocations(applierslatencyHistogram);
                isClusterManager.set(true);
        assertThat(isClusterManager.get(), is(true));
import org.apache.logging.log4j.Level;
                    @Override
                    Level.DEBUG,
        clusterApplierService = createTimedClusterService(true, Optional.of(metricsRegistry));
                    fail();
                @Override
            threadPool.getThreadContext().putHeader(expectedHeaders);
        timedClusterApplierService.start();
                        )
                assertEquals(Collections.emptyMap(), threadPool.getThreadContext().getHeaders());
            () -> ClusterState.builder(clusterApplierService.state()).build(),
        clusterApplierService.allowClusterStateApplicationFailure();
        CountDownLatch taskDone = new CountDownLatch(1);
            public void onSuccess(String source) {
                    "*cluster state applier task [test1] took [*] which is above the warn threshold of *"
        CountDownLatch latch = new CountDownLatch(1);
        Optional<MetricsRegistry> metricsRegistryOptional
    private static Histogram listenerslatencyHistogram;
    public void testClusterStateApplierBubblesUpExceptionsInApplier() throws InterruptedException {
            "test",
                    "test3",
                @Override
        state = ClusterState.builder(state).nodes(nodesBuilder).build();
 * license agreements. See the NOTICE file distributed with
                assertTrue(threadPool.getThreadContext().isSystemContext());
                )
                    ClusterApplierService.class.getCanonicalName(),
        assertNull(error.get());
    @BeforeClass
                    latch.countDown();
                public void onFailure(String source, Exception e) {
                        .localNodeId(localNode.getId())
import org.opensearch.cluster.node.DiscoveryNode;
        latch.await();
                        + "[running task [test3]] took [*"
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.mockito.Mockito.verifyNoInteractions;
    public void testThreadContext() throws InterruptedException {
                    DiscoveryNodes.builder()
        clusterApplierService.allowClusterStateApplicationFailure();
                }
                    taskDone.countDown();
                    assertFalse(threadPool.getThreadContext().isSystemContext());
                    }
                    latch.countDown();
        protected long currentTimeInMillis() {
        @Override
        verifyNoInteractions(listenerslatencyHistogram);
/*
            ClusterSettings clusterSettings,
    public void testGetCurrentApplicationDurationMsResetsAfterCompletion() throws Exception {
            threadPool.shutdownNow();
        AtomicReference<Throwable> error = new AtomicReference<>();
        assertNull(error.get());
        latch.await();
                    Metadata.builder(clusterApplierService.state().metadata())
        assertTrue(applierCalled.get());
                taskCanFinish.await();
    public void testClusterStateApplierCantSampleClusterState() throws InterruptedException {
                });
package org.opensearch.cluster.service;
import static org.mockito.Mockito.clearInvocations;
    private static ThreadPool threadPool;
                )
import java.util.Collections;
        );
        setState(timedClusterApplierService, state);
import org.opensearch.cluster.ClusterStateObserver;
            }
                    ClusterApplierService.class.getCanonicalName(),
            public void offClusterManager() {
        threadPool = new TestThreadPool(ClusterApplierServiceTests.class.getName());
        verifyNoInteractions(applierslatencyHistogram, listenerslatencyHistogram);
        verifyNoInteractions(listenerslatencyHistogram);
            return super.currentTimeInMillis();
            String histogramName = (String) invocationOnMock.getArguments()[0];
            clusterApplierService.runOnApplierThread(
                    clusterApplierService,
        assertTrue(applierCalled.get());
            super("test_node", settings, clusterSettings, threadPool, clusterManagerMetrics);
            );
                        latch.countDown();
    /* Validate the backwards compatibility of LocalNodeMasterListener remains
        assertNotNull(error.get());
            throw new RuntimeException("dummy exception");
            this.clusterSettings = clusterSettings;
        verifyNoInteractions(listenerslatencyHistogram);
                @Override
 * KIND, either express or implied.  See the License for the
                "test1",
     */
                }
        latch.await();
        if (threadPool != null) {
        }
            public void onClusterManager() {
            mockAppender.addExpectation(
 * GitHub history for details.
            );
                .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
                    latch.countDown();
                    ClusterApplierService.class.getCanonicalName(),
                }
                taskDone.countDown();
        if (metricsRegistryOptional != null && metricsRegistryOptional.isPresent()) {
        super.tearDown();
                    return ClusterState.builder(clusterApplierService.state()).build();
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterApplierService.class))) {
import java.util.Optional;
            assertTrue(applierCalled.compareAndSet(false, true));
                @Override
        });
    }
import org.opensearch.cluster.metadata.Metadata;
        clusterApplierService.onNewClusterState(
            clusterApplierService.runOnApplierThread("test4", currentState -> {}, new ClusterApplyListener() {
        clusterApplierService.onNewClusterState(
        nodes = state.nodes();
import static org.opensearch.test.ClusterServiceUtils.createNoOpNodeConnectionsService;
            threadPool = null;
        assertThat(error.get().getMessage(), containsString("dummy exception"));
                )
        assertThat(isClusterManager.get(), is(false));
        latch.await();
                        .persistentSettings(
import org.apache.logging.log4j.LogManager;
                    threadPool.getThreadContext()
 * Licensed to Elasticsearch under one or more contributor
            clusterApplierService.runOnApplierThread("test2", currentState -> {
                threadPool
                    null,
        taskDone.await();  // Wait for task to fully complete to avoid interference with other tests
                    }
import org.opensearch.common.unit.TimeValue;
import org.opensearch.cluster.ClusterManagerMetrics;
                    Level.WARN,
                currentState -> clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(1).millis(),
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(32).millis();
                    "test2",
        verifyNoInteractions(listenerslatencyHistogram);
                }
                    @Override
            @Override
                    "test1",
        applierslatencyHistogram = mock(Histogram.class);
                )
                isClusterManager.set(true);
        DiscoveryNodes nodes = state.nodes();
                        processedFirstTask.countDown();
            );
        });
            if (histogramName.contains("appliers.latency")) {
                }
                public void onSuccess(String source) {
            } catch (InterruptedException e) {
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
import java.util.concurrent.atomic.AtomicBoolean;
    public void testGetCurrentApplicationDurationMsDuringApplication() throws Exception {
        boolean makeClusterManager,
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
import java.util.Map;
                new ClusterApplyListener() {
                @Override
        assertThat(isClusterManager.get(), is(true));
        TimedClusterApplierService timedClusterApplierService;
 */
            @Override
        state = ClusterState.builder(state).blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK).nodes(nodesBuilder).build();
        assertTrue(applierCalled.get());
            // We don't check logging for this on since there is no guarantee that it will occur before our check
                throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");
                }
        timedClusterApplierService.setInitialState(
     * To support inclusive language, LocalNodeMasterListener is deprecated in 2.2.
 * not use this file except in compliance with the License.
        verifyNoInteractions(applierslatencyHistogram);
                @Override
                    logger,
        verify(applierslatencyHistogram, atLeastOnce()).record(anyDouble(), any());
        AtomicReference<Throwable> error = new AtomicReference<>();
                    public void onSuccess(String source) {
                }
                }
            mockAppender.addExpectation(
        DiscoveryNode localNode = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
            () -> ClusterState.builder(clusterApplierService.state()).build(),
                @Override
    public void setUp() throws Exception {
import org.junit.BeforeClass;
                public void onFailure(String source, Exception e) {
            v -> {}
 *
        clusterApplierService.addStateApplier(event -> {
                }
     * Overriding the methods with non-inclusive words are intentional.
                }
                }
import static java.util.Collections.emptySet;
        void allowClusterStateApplicationFailure() {
        } else {
    public void testLongClusterStateUpdateLogging() throws Exception {
        TimedClusterApplierService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {
                new ClusterApplyListener() {
            new ClusterApplier.ClusterApplyListener() {
                }
        final CountDownLatch latch = new CountDownLatch(1);
                Collections.singletonList("testResponse")
                            Settings.builder()
                @Override
            .build();
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
import static org.mockito.Mockito.mock;
            }
        setState(timedClusterApplierService, state);
        taskDone.await();
                public void onSuccess(String source) {}
            EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING,
            if (currentTimeOverride != null) {
                Settings.builder().put("cluster.name", "ClusterApplierServiceTests").build(),
                }
                    Level.WARN,
    }
            );
                }
            return listenerslatencyHistogram;
        setState(timedClusterApplierService, state);
    // testing for application duration tracking
        });
            .blocks(ClusterBlocks.builder().addGlobalBlock(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES))
                    latch.countDown();
        assertNull(error.get());
        state = ClusterState.builder(state)
            this.applicationMayFail = true;
    public static void createThreadPool() {
            clusterApplierService.currentTimeOverride = threadPool.relativeTimeInMillis();
            mockAppender.addExpectation(
        );
        try (ThreadContext.StoredContext ignored = threadPool.getThreadContext().stashContext()) {
                new MockLogAppender.SeenEventExpectation(
                    public void onSuccess(String source) {
    }
                new MockLogAppender.SeenEventExpectation(
import static org.mockito.Mockito.when;
    }
                )
                    public void onNewClusterState(ClusterState state) {
        AtomicReference<Throwable> error = new AtomicReference<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    latch.countDown();
            clusterApplierService.runOnApplierThread("test3", currentState -> {}, new ClusterApplyListener() {
                    }
        volatile Long currentTimeOverride = null;
    public void testClusterStateUpdateLogging() throws Exception {
    public void testClusterStateApplierBubblesUpExceptionsInSettingsApplier() throws InterruptedException {
            new ClusterApplyListener() {
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        listenerslatencyHistogram = mock(Histogram.class);
        verifyNoInteractions(listenerslatencyHistogram);
                    public void onFailure(String source, Exception e) {
            @Override
                assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                public void onFailure(String source, Exception e) {
                    latch.countDown();
                @Override
        }
                ClusterStateObserver observer = new ClusterStateObserver(
                }
                    }
        ClusterState state = timedClusterApplierService.state();
                }
        assertThat(isClusterManager.get(), is(true));
        verifyNoInteractions(applierslatencyHistogram);
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(nodes.getLocalNodeId());
                        latch.countDown();
            mockAppender.addExpectation(
        }
                    }
            });
                    "test4",
        verifyNoInteractions(applierslatencyHistogram);
                        + "[running task [test2]] took [*"
import org.opensearch.cluster.block.ClusterBlocks;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.ArgumentMatchers.anyDouble;
import org.opensearch.Version;
        clusterApplierService.onNewClusterState("test", () -> {
        timedClusterApplierService.close();
                }
import org.opensearch.threadpool.ThreadPool;
        );
        });
            });
        super.setUp();
        CountDownLatch latch = new CountDownLatch(1);
                @Override
    }
            new ClusterApplyListener() {
                public void onFailure(String source, Exception e) {
                    latch.countDown();
 * the Apache License, Version 2.0 (the "License"); you may
                    "*failed to execute cluster state applier in [2s]*"
 * this file be licensed under the Apache-2.0 license or a
                    error.compareAndSet(null, e);
 *
                        .clusterManagerNodeId(makeClusterManager ? localNode.getId() : null)
            }
            clusterApplierService.currentTimeOverride = threadPool.relativeTimeInMillis();
 * under the License.
import org.opensearch.cluster.ClusterName;
                }
            processedFirstTask.await();
        AtomicBoolean applierCalled = new AtomicBoolean();
                    assertTrue(error.compareAndSet(null, e));
            public void onClusterManager() {
                @Override
            @Override
    @TestLogging(value = "org.opensearch.cluster.service:WARN", reason = "to ensure that we log cluster state events on WARN level")
    static class TimedClusterApplierService extends ClusterApplierService {
import static org.mockito.ArgumentMatchers.anyString;
        verifyNoInteractions(applierslatencyHistogram);
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
            final CountDownLatch processedFirstTask = new CountDownLatch(1);
        nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(nodes.getLocalNodeId());
        clusterApplierService.addStateApplier(event -> { throw new RuntimeException("dummy exception"); });
                    error.set(e);
import static org.hamcrest.Matchers.is;
                Settings.builder().put("cluster.name", "ClusterApplierServiceTests").build(),
                .metadata(
}
        }
            }
            public void onFailure(String source, Exception e) {
                error.set(new AssertionError("successfully sampled state"));
/*
        verifyNoInteractions(listenerslatencyHistogram);
                    @Override
import java.util.concurrent.CountDownLatch;
public class ClusterApplierServiceTests extends OpenSearchTestCase {
        verifyNoInteractions(applierslatencyHistogram);
import org.junit.Before;
            super("test_node", settings, clusterSettings, threadPool);
            }
        verifyNoInteractions(listenerslatencyHistogram);
            @Override
                    latch.countDown();
                public void onFailure(String source, Exception e) {
                currentState -> clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(1).millis(),
        CountDownLatch latch = new CountDownLatch(1);
                @Override
        });
                new MockLogAppender.SeenEventExpectation(
                new ClusterApplyListener() {
            }
    }
            });
                clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(2).millis();
            } catch (AssertionError e) {
        clusterApplierService.onNewClusterState(
        setState(timedClusterApplierService, state);
        }
                threadPool,
                    latch.countDown();
            return ClusterState.builder(clusterApplierService.state()).build();
                applierCalled.set(true);
            () -> ClusterState.builder(clusterApplierService.state())
                .nodes(
            "test",
 *
                )
        @Override
                    public void onSuccess(String source) {}
    public void tearDown() throws Exception {
                    "test1 shouldn't see because setting is too low",
                @Override
        assertTrue("Duration should be >= 0 during application, got: " + duration, duration >= 0);
            Settings settings,
                    latch.countDown();
import static java.util.Collections.emptyMap;
                    ClusterApplierService.class.getCanonicalName(),
        latch.await();
                    "*processing [test3]: took [0s] no change in cluster state*"
                public void onFailure(String source, Exception e) {
    }
        taskCanFinish.countDown();  // Let task finish
            }
            mockAppender.assertAllExpectationsMatched();
        AtomicBoolean isClusterManager = new AtomicBoolean();
            "test",
            timedClusterApplierService = new TimedClusterApplierService(
                applierCalled.set(true);
                    "test2",
import org.opensearch.common.settings.Settings;
                public void onFailure(String source, Exception e) {}
            }
                );
            try {
            }, new ClusterApplyListener() {
        state = ClusterState.builder(state).blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK).nodes(nodesBuilder).build();
                public void onSuccess(String source) {
            // Additional update task to make sure all previous logging made it to the loggerName
        AtomicBoolean applierCalled = new AtomicBoolean();
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
import org.opensearch.cluster.node.DiscoveryNodes;
                public void onFailure(String source, Exception e) {
                @Override
                    error.compareAndSet(null, e);
    @TestLogging(value = "org.opensearch.cluster.service:TRACE", reason = "to ensure that we log cluster state events on TRACE level")
            () -> ClusterState.builder(clusterApplierService.state()).build(),
        ) {
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {
                new ClusterManagerMetrics(metricsRegistry)
            public void offClusterManager() {
        }
            "test",
        boolean applicationMayFail;
        clusterApplierService.onNewClusterState(
                    "*processing [test1]: took [1s] no change in cluster state"
                    fail("should not be called");
                error.set(e);
        metricsRegistry = mock(MetricsRegistry.class);
            }
                new MockLogAppender.SeenEventExpectation(
                public void onFailure(String source, Exception e) {
            "test",
                    fail();
                    @Override
        AtomicBoolean applierCalled = new AtomicBoolean();
                public void onSuccess(String source) {
                isClusterManager.set(false);
            }, new ClusterApplyListener() {
                return applierslatencyHistogram;
                }
                @Override
    }
import static org.opensearch.test.ClusterServiceUtils.setState;
    }
    }
                public void onSuccess(String source) {
            );
            try {
 * SPDX-License-Identifier: Apache-2.0
        }
            }
     * after making it a subclass of LocalNodeClusterManagerListener.
import org.opensearch.test.junit.annotations.TestLogging;
    }
                    public void onTimeout(TimeValue timeout) {
            final Map<String, String> expectedHeaders = Collections.singletonMap("test", "test");
            try {
import org.opensearch.cluster.LocalNodeClusterManagerListener;
            final Map<String, List<String>> expectedResponseHeaders = Collections.singletonMap(
    public void testClusterStateApplierSwallowsExceptionInListener() throws InterruptedException {
                currentState -> clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(34).millis(),
                taskDone.countDown();
        verifyNoInteractions(applierslatencyHistogram, listenerslatencyHistogram);
            }
                if (e.getMessage().contains("should not be called by a cluster state applier") == false) {
                public void onFailure(String source, Exception e) {
        CountDownLatch taskDone = new CountDownLatch(1);
    public void testGetCurrentApplicationDurationMsReturnsZeroWhenIdle() {
            .nodes(nodesBuilder)
                .build()
            );
    public void testLocalNodeClusterManagerListenerCallbacks() {
    public void testClusterStateApplierCanCreateAnObserver() throws InterruptedException {
            clusterApplierService.runOnApplierThread("test2", currentState -> {
        }
    }
            () -> ClusterState.builder(clusterApplierService.state()).build(),
                    public void onClusterServiceClose() {
        TimedClusterApplierService timedClusterApplierService = createTimedClusterService(false, Optional.empty());
                    "*cluster state applier task [test3] took [34s] which is above the warn threshold of [*]: "
                public void onFailure(String source, Exception e) {
        assertThat(error.get().getMessage(), containsString("illegal value can't update"));
    @AfterClass
                    ClusterApplierService.class.getCanonicalName(),
                    public void onFailure(String source, Exception e) {
        // No task running → should return 0
        }
        timedClusterApplierService.close();
            );
                    }
                .build(),
        TimedClusterApplierService(
                public void onSuccess(String source) {
import org.opensearch.common.util.concurrent.ThreadContext;
            timedClusterApplierService = new TimedClusterApplierService(
        ClusterState state = timedClusterApplierService.state();
            this.clusterSettings = clusterSettings;
                        fail();
import org.opensearch.cluster.ClusterState;
 * Modifications Copyright OpenSearch Contributors. See
        );
import org.opensearch.threadpool.TestThreadPool;
            new ClusterApplyListener() {
                    assertFalse(threadPool.getThreadContext().isSystemContext());
 */
            latch.await();
                clusterApplierService.state();
                }
            clusterApplierService.runOnApplierThread(
import org.junit.After;
        DiscoveryNodes nodes = state.nodes();
                )
                    public void onFailure(String source, Exception e) {
                    @Override
        CountDownLatch taskCanFinish = new CountDownLatch(1);
                        .build()
        nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(null);
            taskStarted.countDown();
        CountDownLatch latch = new CountDownLatch(1);
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(nodes.getLocalNodeId());
                    event.state(),
                    latch.countDown();
        );
            ThreadPool threadPool,
        return timedClusterApplierService;
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                }
    private static Histogram applierslatencyHistogram;
        });
                Thread.currentThread().interrupt();
        timedClusterApplierService.addLocalNodeClusterManagerListener(new LocalNodeClusterManagerListener() {
                isClusterManager.set(false);
            );
            });
                public void onSuccess(String source) {
                return currentTimeOverride;
 * this work for additional information regarding copyright
        assertEquals(0, clusterApplierService.getCurrentApplicationDurationMs());
                        fail();
    }
import static org.mockito.ArgumentMatchers.any;
                        .add(localNode)
import org.opensearch.telemetry.metrics.Histogram;
            return this.applicationMayFail;
    private TimedClusterApplierService clusterApplierService;
        clusterApplierService.clusterSettings.addSettingsUpdateConsumer(
            clusterApplierService.runOnApplierThread(
        CountDownLatch taskStarted = new CountDownLatch(1);
                    error.compareAndSet(null, e);
            );
                    @Override
 */
                @Override
    public static void stopThreadPool() {
                "test1",
    @Before
import java.util.List;
        verify(applierslatencyHistogram, atLeastOnce()).record(anyDouble(), any());
                public void onSuccess(String source) {
import static org.hamcrest.Matchers.containsString;
                @Override
                }
    }
            new ClusterApplyListener() {
            mockAppender.addExpectation(
        assertNotNull(error.get());
    ) {
    }
                observer.waitForNextChange(new ClusterStateObserver.Listener() {
    private TimedClusterApplierService createTimedClusterService(
                @Override
                    }
                @Override
/*
        clusterApplierService.addStateApplier(event -> {
                    @Override
                public void onSuccess(String source) {
        setState(timedClusterApplierService, state);
        state = ClusterState.builder(state).nodes(nodesBuilder).build();
            );
        });
        TimedClusterApplierService timedClusterApplierService = createTimedClusterService(false, Optional.empty());
                    Level.WARN,
                    @Override
        }, new ClusterApplier.ClusterApplyListener() {
        clearInvocations(applierslatencyHistogram);
            new ClusterApplyListener() {
                "testResponse",
 * Unless required by applicable law or agreed to in writing,
                                .build()
        );
        clusterApplierService.onNewClusterState(
        assertThat(isClusterManager.get(), is(false));
import org.opensearch.common.settings.ClusterSettings;
                new MockLogAppender.UnseenEventExpectation(
        nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(null);
            }
    public void testDeprecatedLocalNodeMasterListenerCallbacks() {
import org.opensearch.cluster.service.ClusterApplier.ClusterApplyListener;
        timedClusterApplierService.addLocalNodeClusterManagerListener(new LocalNodeClusterManagerListener() {
            mockAppender.addExpectation(
        clusterApplierService.onNewClusterState(
                    throw new IllegalArgumentException("mock failure");
 * You may obtain a copy of the License at
            }
                throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");
                )
        AtomicReference<Throwable> error = new AtomicReference<>();
    }
                if (randomBoolean()) {
                    Level.TRACE,
            }, new ClusterApplyListener() {
                @Override
                    taskDone.countDown();
        CountDownLatch latch = new CountDownLatch(1);
            });
        );
                    fail();
                @Override
            @Override
import java.util.concurrent.atomic.AtomicReference;
                "test3",
        AtomicReference<Throwable> error = new AtomicReference<>();
                @Override
    private static MetricsRegistry metricsRegistry;
                new MockLogAppender.SeenEventExpectation(
            }
                    @Override
    @After
            () -> ClusterState.builder(clusterApplierService.state()).build(),
        }
                    assertTrue(error.compareAndSet(null, e));
                }
                                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), false)
                    Level.DEBUG,
        verifyNoInteractions(listenerslatencyHistogram);
        verifyNoInteractions(applierslatencyHistogram);
        long duration = clusterApplierService.getCurrentApplicationDurationMs();
        AtomicBoolean isClusterManager = new AtomicBoolean();
        clusterApplierService.close();
        );
            } catch (AssertionError e) {
            }
        taskStarted.await();  // Wait for task to start
 * compatible open source license.
        latch.await();
                public void onSuccess(String source) {
            );
            clusterApplierService.onNewClusterState("test", () -> {
                        fail();
                }
        clusterApplierService.addListener(event -> {
                    "*cluster state applier task [test2] took [32s] which is above the warn threshold of [*]: "
import org.opensearch.test.MockLogAppender;
