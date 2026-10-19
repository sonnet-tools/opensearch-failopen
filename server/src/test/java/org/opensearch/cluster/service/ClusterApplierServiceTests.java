        }  
        CountDownLatch taskCanFinish = new CountDownLatch(1);
                    "test4",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.Version;  
        clusterApplierService.addListener(event -> {
            @Override  
                    ClusterApplierService.class.getCanonicalName(),
    public void tearDown() throws Exception {
            @Override
                    assertFalse(threadPool.getThreadContext().isSystemContext());  
                public void onFailure(String source, Exception e) {
    public void testThreadContext() throws InterruptedException {
                    latch.countDown();
                @Override  
            // Additional update task to make sure all previous logging made it to the loggerName
                taskDone.countDown();
import java.util.Optional;
    }  
                    Level.DEBUG,
                @Override
            clusterApplierService.currentTimeOverride = threadPool.relativeTimeInMillis();  
 * KIND, either express or implied.  See the License for the
import static org.mockito.ArgumentMatchers.anyString;  
import static org.mockito.Mockito.verifyNoInteractions;
                clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(32).millis();
                    latch.countDown();
                }
                public void onFailure(String source, Exception e) {  
import org.opensearch.common.util.concurrent.ThreadContext;
                threadPool
                }  
            ClusterState.builder(new ClusterName("ClusterApplierServiceTests"))
                new MockLogAppender.SeenEventExpectation(  
                public void onSuccess(String source) {  
            );
            @Override  
        listenerslatencyHistogram = mock(Histogram.class);  
        });
import static org.mockito.ArgumentMatchers.anyDouble;
                    @Override
                new ClusterApplyListener() {
                Settings.builder().put("cluster.name", "ClusterApplierServiceTests").build(),
                @Override
        clusterApplierService.onNewClusterState(
            }, new ClusterApplyListener() {  
            latch.await();  
            return ClusterState.builder(clusterApplierService.state()).build();  
                    public void onClusterServiceClose() {
                    @Override  
                }  
                        .clusterManagerNodeId(makeClusterManager ? localNode.getId() : null)  
     * after making it a subclass of LocalNodeClusterManagerListener.
        clusterApplierService.addStateApplier(event -> {
import org.opensearch.cluster.node.DiscoveryNode;  
        assertThat(isClusterManager.get(), is(true));
        latch.await();
                ClusterStateObserver observer = new ClusterStateObserver(
import org.opensearch.cluster.node.DiscoveryNodes;
        super.setUp();
    public static void stopThreadPool() {
        setState(timedClusterApplierService, state);
        verifyNoInteractions(applierslatencyHistogram);  
                if (e.getMessage().contains("should not be called by a cluster state applier") == false) {  
        setState(timedClusterApplierService, state);  
        return timedClusterApplierService;  
            assertTrue(applierCalled.compareAndSet(false, true));
        clearInvocations(applierslatencyHistogram);
    @TestLogging(value = "org.opensearch.cluster.service:WARN", reason = "to ensure that we log cluster state events on WARN level")
                public void onSuccess(String source) {  
        }  
        AtomicBoolean applierCalled = new AtomicBoolean();
        assertThat(isClusterManager.get(), is(true));
            clusterApplierService.runOnApplierThread("test2", currentState -> {  
            this.applicationMayFail = true;
        clusterApplierService.onNewClusterState(
        DiscoveryNode localNode = new DiscoveryNode("node1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
                @Override
                    fail();  
            "test",
        }
        );
                    Level.DEBUG,
    }
            );
        AtomicBoolean isClusterManager = new AtomicBoolean();
            }
        AtomicReference<Throwable> error = new AtomicReference<>();
        }
            }  
        TimedClusterApplierService timedClusterApplierService;
        });
        final CountDownLatch latch = new CountDownLatch(1);  
            super("test_node", settings, clusterSettings, threadPool);
        void allowClusterStateApplicationFailure() {
                        .persistentSettings(
                }
        });
 * this file be licensed under the Apache-2.0 license or a
                public void onFailure(String source, Exception e) {
                @Override  
    private static Histogram applierslatencyHistogram;
                    Level.WARN,
                public void onFailure(String source, Exception e) {  
    public void testGetCurrentApplicationDurationMsReturnsZeroWhenIdle() {  
                        + "[running task [test3]] took [*"  
            final CountDownLatch latch = new CountDownLatch(4);
        );
        nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(nodes.getLocalNodeId());
        } else {
                @Override
import org.opensearch.test.OpenSearchTestCase;
        state = ClusterState.builder(state).nodes(nodesBuilder).build();  
                .metadata(  
        assertNull(error.get());
                @Override  
                    threadPool.getThreadContext()
import org.opensearch.telemetry.metrics.MetricsRegistry;  
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
            () -> ClusterState.builder(clusterApplierService.state()).build(),  
            }
                    ClusterApplierService.class.getCanonicalName(),  
            v -> {}
import static org.mockito.Mockito.verify;
                    Level.WARN,
        protected boolean applicationMayFail() {  
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterApplierService.class))) {  
        protected long currentTimeInMillis() {
                }  
        nodes = state.nodes();  
            }, new ClusterApplyListener() {  
import static java.util.Collections.emptyMap;
        state = ClusterState.builder(state).nodes(nodesBuilder).build();  
                return currentTimeOverride;  
                    event.state(),  
                });  
import org.opensearch.cluster.block.ClusterBlocks;  
    }
        assertThat(isClusterManager.get(), is(false));
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                    error.set(e);
        AtomicReference<Throwable> error = new AtomicReference<>();
            ThreadPool threadPool,
}  
                assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
import org.opensearch.common.unit.TimeValue;  
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(nodes.getLocalNodeId());
    }
                @Override
                threadPool.getThreadContext().addResponseHeader("testResponse", "testResponse");
            } catch (AssertionError e) {
                    "*processing [test1]: took [1s] no change in cluster state"
            "test",
import static org.mockito.Mockito.atLeastOnce;
            "test",
                }
    public void testClusterStateApplierBubblesUpExceptionsInApplier() throws InterruptedException {  
                    }
        AtomicBoolean applierCalled = new AtomicBoolean();  
                public void onSuccess(String source) {  
                    "*cluster state applier task [test2] took [32s] which is above the warn threshold of [*]: "
            clusterApplierService.runOnApplierThread("test2", currentState -> {  
            clusterApplierService.runOnApplierThread("test3", currentState -> {}, new ClusterApplyListener() {
        timedClusterApplierService.start();
                .build(),  
        );
     * Overriding the methods with non-inclusive words are intentional.
                    Metadata.builder(clusterApplierService.state().metadata())
import static org.mockito.Mockito.clearInvocations;
                new MockLogAppender.SeenEventExpectation(
                )
                new MockLogAppender.SeenEventExpectation(
                    latch.countDown();
            new ClusterApplyListener() {  
    }
        clusterApplierService = createTimedClusterService(true, Optional.of(metricsRegistry));  
import static java.util.Collections.emptySet;
            final Map<String, List<String>> expectedResponseHeaders = Collections.singletonMap(
            new ClusterApplyListener() {
                    }  
    }
            }
                        fail();
    }  
                }
        nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(null);
    private static MetricsRegistry metricsRegistry;  
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
import org.opensearch.test.junit.annotations.TestLogging;  
 * software distributed under the License is distributed on an
                new ClusterManagerMetrics(metricsRegistry)
                "test1",  
/*  
                @Override
import org.opensearch.cluster.ClusterManagerMetrics;
        verifyNoInteractions(listenerslatencyHistogram);
        latch.await();
            "test",
    public static void createThreadPool() {
        threadPool = new TestThreadPool(ClusterApplierServiceTests.class.getName());  
        TimedClusterApplierService(
            new ClusterApplier.ClusterApplyListener() {
            public void onClusterManager() {
        CountDownLatch taskDone = new CountDownLatch(1);  
 * specific language governing permissions and limitations
    }
        AtomicReference<Throwable> error = new AtomicReference<>();
                }  
        });
                    latch.countDown();
                .nodes(
                    }
            });
        latch.await();
    @After  
import static org.hamcrest.Matchers.containsString;
     */
import org.opensearch.threadpool.TestThreadPool;
    }
        clusterApplierService.allowClusterStateApplicationFailure();  
            assertBusy(mockAppender::assertAllExpectationsMatched);
                        processedFirstTask.countDown();
        assertEquals(0, clusterApplierService.getCurrentApplicationDurationMs());
            new ClusterApplyListener() {
                observer.waitForNextChange(new ClusterStateObserver.Listener() {  
            new ClusterApplyListener() {
 *
                Collections.singletonList("testResponse")  
            Settings settings,  
    // testing for application duration tracking
        }
    public void testGetCurrentApplicationDurationMsResetsAfterCompletion() throws Exception {
import static org.opensearch.test.ClusterServiceUtils.createNoOpNodeConnectionsService;  
        // No task running → should return 0
        assertThat(error.get().getMessage(), containsString("dummy exception"));  
                    latch.countDown();
                assertEquals(Collections.emptyMap(), threadPool.getThreadContext().getHeaders());  
                }
                    taskDone.countDown();
                }  
        taskStarted.await();  // Wait for task to start
                )  
            clusterApplierService.runOnApplierThread(
            );  
                taskCanFinish.await();
        assertNotNull(error.get());
                @Override  
            // We don't check logging for this on since there is no guarantee that it will occur before our check  
                    @Override  
        timedClusterApplierService.setInitialState(  
                applierCalled.set(true);
 * Unless required by applicable law or agreed to in writing,
                    public void onSuccess(String source) {  
            clusterApplierService.runOnApplierThread(
            );
            return super.currentTimeInMillis();
                }  
 *  
                    "test1 shouldn't see because setting is too low",  
        timedClusterApplierService.close();  
        }
        taskDone.await();  // Wait for task to fully complete to avoid interference with other tests
            mockAppender.addExpectation(
 */  
                    public void onFailure(String source, Exception e) {  
        taskDone.await();
import org.opensearch.common.settings.Settings;
    public void testGetCurrentApplicationDurationMsDuringApplication() throws Exception {
                    latch.countDown();  
            () -> ClusterState.builder(clusterApplierService.state()).build(),
                @Override
                        fail();
                new ClusterApplyListener() {
        verifyNoInteractions(listenerslatencyHistogram);  
        clearInvocations(applierslatencyHistogram);
import org.apache.logging.log4j.LogManager;
                currentState -> clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(34).millis(),
import org.junit.After;  
                )
        clusterApplierService.addStateApplier(event -> {  
        setState(timedClusterApplierService, state);
        verifyNoInteractions(listenerslatencyHistogram);
        }
            if (currentTimeOverride != null) {
        metricsRegistry = mock(MetricsRegistry.class);
            clusterApplierService.runOnApplierThread(
                    fail("should not be called");  
                public void onFailure(String source, Exception e) {  
            });
 * license agreements. See the NOTICE file distributed with
        );  
                public void onSuccess(String source) {
        setState(timedClusterApplierService, state);  
        verifyNoInteractions(listenerslatencyHistogram);
     * To support inclusive language, LocalNodeMasterListener is deprecated in 2.2.  
        verifyNoInteractions(listenerslatencyHistogram);
 *
        verifyNoInteractions(listenerslatencyHistogram);  
                @Override  
import org.opensearch.telemetry.metrics.Histogram;
            );  
    private static Histogram listenerslatencyHistogram;
            @Override
                @Override  
            );  
        AtomicReference<Throwable> error = new AtomicReference<>();  
import org.opensearch.cluster.ClusterState;  
import org.junit.BeforeClass;  
                    taskDone.countDown();
            final Map<String, String> expectedHeaders = Collections.singletonMap("test", "test");  
            @Override
                );
        });
    private TimedClusterApplierService createTimedClusterService(  
        assertTrue(applierCalled.get());
        timedClusterApplierService.close();  
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());  
            processedFirstTask.await();
                    fail();  
                    "*cluster state applier task [test3] took [34s] which is above the warn threshold of [*]: "
        });
                    latch.countDown();
 * this work for additional information regarding copyright
                public void onFailure(String source, Exception e) {
    static class TimedClusterApplierService extends ClusterApplierService {  
                    ClusterApplierService.class.getCanonicalName(),  
                    public void onNewClusterState(ClusterState state) {
                    throw new IllegalArgumentException("mock failure");  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.concurrent.atomic.AtomicBoolean;
        clusterApplierService.clusterSettings.addSettingsUpdateConsumer(
                    error.compareAndSet(null, e);
                public void onSuccess(String source) {
        assertEquals(0, clusterApplierService.getCurrentApplicationDurationMs());  
            @Override
        clusterApplierService.onNewClusterState(
            });  
                    "test3",  
    }
                    latch.countDown();
/*
import org.junit.Before;
            public void offClusterManager() {
public class ClusterApplierServiceTests extends OpenSearchTestCase {
                clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(2).millis();
        verifyNoInteractions(applierslatencyHistogram, listenerslatencyHistogram);
                }
    public void testClusterStateUpdateLogging() throws Exception {
        ClusterState state = timedClusterApplierService.state();  
                    Level.TRACE,  
                                .put(EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey(), false)
                            Settings.builder()  
                    @Override
    public void setUp() throws Exception {  
        }, new ClusterApplier.ClusterApplyListener() {
        DiscoveryNodes nodes = state.nodes();  
                }  
        setState(timedClusterApplierService, state);
        CountDownLatch latch = new CountDownLatch(1);
        nodes = state.nodes();
import org.opensearch.cluster.service.ClusterApplier.ClusterApplyListener;  
                    latch.countDown();
        CountDownLatch latch = new CountDownLatch(1);  
        assertNull(error.get());
                )
            clusterApplierService.currentTimeOverride = threadPool.relativeTimeInMillis();
                    @Override  
                isClusterManager.set(true);  
                public void onFailure(String source, Exception e) {  
            super("test_node", settings, clusterSettings, threadPool, clusterManagerMetrics);
                        .add(localNode)
                new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
                    DiscoveryNodes.builder()  
        if (metricsRegistryOptional != null && metricsRegistryOptional.isPresent()) {  
 * the Apache License, Version 2.0 (the "License"); you may
        clusterApplierService.onNewClusterState(
        if (threadPool != null) {
            }  
                }
                    "test2",
            threadPool = null;
                }
                throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");
            public void onFailure(String source, Exception e) {
                    public void onFailure(String source, Exception e) {  
        verify(applierslatencyHistogram, atLeastOnce()).record(anyDouble(), any());
        assertTrue(applierCalled.get());
                    ClusterApplierService.class.getCanonicalName(),  
                "testResponse",
        when(metricsRegistry.createHistogram(anyString(), anyString(), anyString())).thenAnswer(invocationOnMock -> {
                isClusterManager.set(true);
    public void testClusterStateApplierCanCreateAnObserver() throws InterruptedException {
            throw new RuntimeException("dummy exception");  
                    }  
    ) {  
    public void testClusterStateApplierBubblesUpExceptionsInSettingsApplier() throws InterruptedException {  
    }
import org.opensearch.cluster.metadata.Metadata;
                .build()  
    }  
                        + "[running task [test2]] took [*"  
            mockAppender.addExpectation(  
            .blocks(ClusterBlocks.builder().addGlobalBlock(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_WRITES))  
            }  
                throw new IllegalArgumentException("Testing handling of exceptions in the cluster state task");
                    public void onFailure(String source, Exception e) {
        @Override  
        AtomicReference<Throwable> error = new AtomicReference<>();
                }
        taskCanFinish.countDown();  // Let task finish
        CountDownLatch taskDone = new CountDownLatch(1);  
                public void onFailure(String source, Exception e) {
        clusterApplierService.allowClusterStateApplicationFailure();  
            ClusterSettings clusterSettings,
        clusterApplierService.onNewClusterState(  
        TimedClusterApplierService timedClusterApplierService = createTimedClusterService(false, Optional.empty());
        assertTrue(applierCalled.get());
            }  
                    null,
                    ClusterApplierService.class.getCanonicalName(),
                        latch.countDown();
                    @Override  
            try {
                taskDone.countDown();  
import org.opensearch.cluster.ClusterStateObserver;
        }  
        assertNull(error.get());  
            mockAppender.addExpectation(
                    fail();  
            clusterApplierService.runOnApplierThread("test4", currentState -> {}, new ClusterApplyListener() {
                public void onFailure(String source, Exception e) {  
                }
                error.set(new AssertionError("successfully sampled state"));
            );
                }
            return listenerslatencyHistogram;
                    "test2",
        verifyNoInteractions(applierslatencyHistogram);
import java.util.Map;
            }, new ClusterApplyListener() {
                }  
                        )  
                    assertEquals(expectedHeaders, threadPool.getThreadContext().getHeaders());
            "test",  
                    assertFalse(threadPool.getThreadContext().isSystemContext());
            final CountDownLatch processedFirstTask = new CountDownLatch(1);
        );
                )
 * GitHub history for details.
        state = ClusterState.builder(state)
                }  
        AtomicBoolean isClusterManager = new AtomicBoolean();
                @Override
                currentState -> clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(1).millis(),  
                currentState -> clusterApplierService.currentTimeOverride += TimeValue.timeValueSeconds(1).millis(),
        clusterApplierService.onNewClusterState(  
        boolean makeClusterManager,
 * not use this file except in compliance with the License.
        latch.await();
                error.set(e);
            public void offClusterManager() {  
            }  
 * ownership. Elasticsearch licenses this file to you under  
                Settings.builder().put("cluster.name", "ClusterApplierServiceTests").build(),  
        timedClusterApplierService.addLocalNodeClusterManagerListener(new LocalNodeClusterManagerListener() {
            );
                    logger,  
            }  
                    }  
    @TestLogging(value = "org.opensearch.cluster.service:TRACE", reason = "to ensure that we log cluster state events on TRACE level")  
                    error.compareAndSet(null, e);
                applierCalled.set(true);
            mockAppender.addExpectation(  
    }  
        AtomicBoolean applierCalled = new AtomicBoolean();
            }
                clusterApplierService.state();  
            ClusterManagerMetrics clusterManagerMetrics  
            .build();
        assertNotNull(error.get());  
                    @Override
                @Override
                @Override  
                public void onSuccess(String source) {
            }  
    }
            });
import static org.mockito.Mockito.mock;  
    }  
                    "test1",
    private static ThreadPool threadPool;
                threadPool,
                }
            .nodes(nodesBuilder)
        clusterApplierService.close();
                        latch.countDown();
                new MockLogAppender.SeenEventExpectation(
        );
import static org.hamcrest.Matchers.is;  
                }
            public void onClusterManager() {
        assertTrue("Duration should be >= 0 during application, got: " + duration, duration >= 0);  
import java.util.Collections;
        timedClusterApplierService.setNodeConnectionsService(createNoOpNodeConnectionsService());
            }
 */
                    Level.WARN,
 * compatible open source license.
                public void onSuccess(String source) {
                new MockLogAppender.UnseenEventExpectation(
        assertThat(error.get().getMessage(), containsString("illegal value can't update"));
import static org.opensearch.test.ClusterServiceUtils.setState;
    }
        CountDownLatch latch = new CountDownLatch(1);
 * under the License.  
                    "*failed to execute cluster state applier in [2s]*"
        latch.await();  
                public void onSuccess(String source) {
    /* Validate the backwards compatibility of LocalNodeMasterListener remains  
        verifyNoInteractions(applierslatencyHistogram);
        TimedClusterApplierService(Settings settings, ClusterSettings clusterSettings, ThreadPool threadPool) {  
                        .localNodeId(localNode.getId())
                    public void onTimeout(TimeValue timeout) {  
        nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(null);
            this.clusterSettings = clusterSettings;
import org.junit.AfterClass;
            try {  
        super.tearDown();  
                        .build()
            public void onSuccess(String source) {  
            new ClusterApplyListener() {
                Thread.currentThread().interrupt();
            }
import java.util.concurrent.CountDownLatch;  
import org.opensearch.test.MockLogAppender;
        assertThat(isClusterManager.get(), is(true));
 * You may obtain a copy of the License at  
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
            } catch (InterruptedException e) {  
                    error.compareAndSet(null, e);  
        CountDownLatch latch = new CountDownLatch(1);  
                    "*cluster state applier task [test1] took [*] which is above the warn threshold of *"  
        DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(nodes).clusterManagerNodeId(nodes.getLocalNodeId());
                isClusterManager.set(false);
            threadPool.getThreadContext().putHeader(expectedHeaders);
        });  
    }
import org.opensearch.common.settings.ClusterSettings;
                isClusterManager.set(false);
    public void testDeprecatedLocalNodeMasterListenerCallbacks() {
                    }
                )
        applierslatencyHistogram = mock(Histogram.class);
    private TimedClusterApplierService clusterApplierService;
        TimedClusterApplierService timedClusterApplierService = createTimedClusterService(false, Optional.empty());  
            }  
        ClusterState state = timedClusterApplierService.state();
                    return ClusterState.builder(clusterApplierService.state()).build();
                @Override
                assertTrue(threadPool.getThreadContext().isSystemContext());
            );
        @Override
        latch.await();  
            timedClusterApplierService = new TimedClusterApplierService(
                new ClusterApplyListener() {
        Optional<MetricsRegistry> metricsRegistryOptional
        state = ClusterState.builder(state).blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK).nodes(nodesBuilder).build();  
            mockAppender.assertAllExpectationsMatched();
            // Additional update task to make sure all previous logging made it to the loggerName  
            );
    @BeforeClass
                    }  
            try {
                    public void onSuccess(String source) {
        assertThat(isClusterManager.get(), is(false));
    public void testLongClusterStateUpdateLogging() throws Exception {
            () -> ClusterState.builder(clusterApplierService.state()).build(),  
        long duration = clusterApplierService.getCurrentApplicationDurationMs();
    public void testClusterStateApplierSwallowsExceptionInListener() throws InterruptedException {
        DiscoveryNodes nodes = state.nodes();
                new MockLogAppender.SeenEventExpectation(
        boolean applicationMayFail;
        try (MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(ClusterApplierService.class))) {
                    ClusterApplierService.class.getCanonicalName(),
import static org.mockito.Mockito.when;  
        }
                    assertTrue(error.compareAndSet(null, e));
                public void onFailure(String source, Exception e) {
                )
            taskStarted.countDown();  
        state = ClusterState.builder(state).blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK).nodes(nodesBuilder).build();
            } catch (AssertionError e) {
                    latch.countDown();  
                @Override
                    assertTrue(error.compareAndSet(null, e));
            mockAppender.addExpectation(  
                    fail();
        verifyNoInteractions(listenerslatencyHistogram);
        verifyNoInteractions(applierslatencyHistogram);  
import java.util.List;  
import static org.mockito.ArgumentMatchers.any;
                @Override  
                if (randomBoolean()) {  
                @Override
import org.opensearch.cluster.ClusterName;
        timedClusterApplierService.addLocalNodeClusterManagerListener(new LocalNodeClusterManagerListener() {  
        ) {
                @Override
                )
        verifyNoInteractions(applierslatencyHistogram, listenerslatencyHistogram);
                }
                                .build()
            );
        }
        final ClusterSettings clusterSettings;
        verifyNoInteractions(applierslatencyHistogram);  
    }
import org.apache.logging.log4j.Level;
            "test",
                } else {
        clusterApplierService.addStateApplier(event -> { throw new RuntimeException("dummy exception"); });
                public void onSuccess(String source) {
            return this.applicationMayFail;
            clusterApplierService.onNewClusterState("test", () -> {
                "test1",
                    assertEquals(expectedResponseHeaders, threadPool.getThreadContext().getResponseHeaders());
                public void onSuccess(String source) {
import org.opensearch.cluster.LocalNodeClusterManagerListener;
            }
                    "*processing [test3]: took [0s] no change in cluster state*"  
            }
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.cluster.service;
    @Before
                    @Override
        CountDownLatch taskStarted = new CountDownLatch(1);
            if (histogramName.contains("appliers.latency")) {
        clusterApplierService.onNewClusterState("test", () -> {
                return applierslatencyHistogram;
import org.opensearch.threadpool.ThreadPool;
                "test3",  
            () -> ClusterState.builder(clusterApplierService.state()).build(),  
        verifyNoInteractions(applierslatencyHistogram);  
    public void testLocalNodeClusterManagerListenerCallbacks() {
                }
            timedClusterApplierService = new TimedClusterApplierService(
            this.clusterSettings = clusterSettings;  
    }
                @Override
            String histogramName = (String) invocationOnMock.getArguments()[0];  
            });
            mockAppender.addExpectation(
 * The OpenSearch Contributors require contributions made to  
                    clusterApplierService,
            EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING,  
        try (ThreadContext.StoredContext ignored = threadPool.getThreadContext().stashContext()) {
                        fail();
                    @Override
                    fail("should not be called");
 * Modifications Copyright OpenSearch Contributors. See
                    }
        verify(applierslatencyHistogram, atLeastOnce()).record(anyDouble(), any());  
                }
        verifyNoInteractions(listenerslatencyHistogram);
    @AfterClass  
        );  
import java.util.concurrent.atomic.AtomicReference;
 */  
            () -> ClusterState.builder(clusterApplierService.state())
        CountDownLatch latch = new CountDownLatch(1);  
            );
            () -> ClusterState.builder(clusterApplierService.state()).build(),
                public void onSuccess(String source) {}  
    public void testClusterStateApplierCantSampleClusterState() throws InterruptedException {  
        );
                    public void onSuccess(String source) {}
                public void onFailure(String source, Exception e) {}
                    latch.countDown();
            threadPool.shutdownNow();  
                .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        volatile Long currentTimeOverride = null;  
