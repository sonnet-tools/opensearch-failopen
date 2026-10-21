 * Copyright OpenSearch Contributors.
        statsFlag.includeAllShardIndexingPressureTrackers(true);
            public String getChannelType() {
        clusterService.close();
            new TransportReplicationAction.ConcreteShardRequest<>(
        doAnswer(invocation -> {
        CommonStatsFlags statsFlag = new CommonStatsFlags();
    }
        assertPhase(task, "finished");
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[3];
            new TransportReplicationAction.ConcreteReplicaRequest<>(
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(CommonStatsFlags.ALL)
        }
import org.opensearch.core.index.Index;
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
    private Releasable releasable;
import java.util.concurrent.TimeUnit;
            settings,
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.cluster.metadata.IndexMetadata;
                replicaRouting.allocationId().getId(),
        statsFlag.includeAllShardIndexingPressureTrackers(true);
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(CommonStatsFlags.ALL)
            return "TestRequest{}";
                new SystemIndices(emptyMap()),
        TestAction action = new TestAction(
            new TransportReplicationAction.ConcreteShardRequest<>(
        TestAction action = new TestAction(
        when(indexShard.getActiveOperationsCount()).thenAnswer(i -> count.get());
    public static final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            int shard = (Integer) invocation.getArguments()[0];
        });
            if (routing == null) {
import org.opensearch.cluster.action.shard.ShardStateAction;
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(statsFlag)
        final ShardId shardId = new ShardId("test", "_na_", 0);
        transportService.acceptIncomingRequests();
        }
                randomNonNegativeLong(),
                ignore -> ThreadPool.Names.SAME,
     * TransportReplicationAction. Since TransportReplicationAction has to work
                randomNonNegativeLong(),
import org.opensearch.index.IndexingPressureService;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.anyInt;
import org.opensearch.transport.TransportService;
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        threadPool = null;
        setState(clusterService, state);
            ),
        TestRequest() {
        if (task != null) {
                replicaRouting.allocationId().getId(),
        );
        doThrow(new AssertionError("failed shard is not supported")).when(indexShard).failShard(anyString(), any(Exception.class));
    }
                randomNonNegativeLong(),
            .getIndexingPressureShardStats(shardId);
    }
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        return new TransportChannel() {
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
        final IndexShard indexShard = mock(IndexShard.class);
        }).when(indexShard).acquirePrimaryOperationPermit(any(ActionListener.class), anyString(), any());
            .getIndexingPressureShardStats(shardId);
        TestAction action = new TestAction(settings, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
                randomNonNegativeLong(),
            .build();
            ),
        when(indicesService.indexService(any(Index.class))).then(invocation -> {
        TestAction action = new TestAction(settings, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
        boolean forcedRefresh;
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(statsFlag)
        protected long primaryOperationSize(TestRequest request) {
            task
            .build();
public class TransportWriteActionForIndexingPressureTests extends OpenSearchTestCase {
        );
        threadPool = new TestThreadPool("ShardReplicationTests");
        assertTrue(Objects.isNull(shardStats));
            ActionListener<PrimaryResult<TestRequest, TestResponse>> listener
    public void testIndexingPressureOperationStartedForLocalPrimaryShard() {
            createTransportChannel(new PlainActionFuture<>()),
                randomNonNegativeLong(),
import org.opensearch.core.transport.TransportResponse;
        assertPhase(task, "finished");
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
            );
            threadPool,
            final ClusterState state = clusterService.state();
                actionName,
        doAnswer(invocation -> {
                randomNonNegativeLong(),
        action.handleReplicaRequest(
            NoopTracer.INSTANCE
                shardStateAction,
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
    @Before
            return null;
            "internal:testActionWithExceptions",
        final Settings settings = Settings.builder()
        assertTrue(Objects.isNull(shardStats));
import org.junit.BeforeClass;
        final ShardId shardId = new ShardId("test", "_na_", 0);
            transportService,
            settings,
                randomNonNegativeLong(),
        final ShardId shardId = new ShardId("test", "_na_", 0);
import java.util.concurrent.atomic.AtomicBoolean;
            clusterService.getSettings(),
            return mockIndexShard(shardId, clusterService);
        assertPhase(task, "finished");
            }
import static org.mockito.Mockito.mock;
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
                randomNonNegativeLong()
            Index index = (Index) invocation.getArguments()[0];
            if (state.metadata().hasIndex(index.getName())) {
        assertEquals(100, shardStats.getTotalReplicaBytes());
        setState(clusterService, state);
import org.opensearch.common.Nullable;
    private final AtomicBoolean isRelocated = new AtomicBoolean(false);
import org.opensearch.indices.IndicesService;
    private final AtomicInteger count = new AtomicInteger(0);
            x -> clusterService.localNode(),
            super(
            new TransportReplicationAction.ConcreteReplicaRequest<>(
            shardStateAction,
        @Override
            createTransportChannel(new PlainActionFuture<>()),
    public void testIndexingPressureOperationStartedForReplicaNode() {
        setState(clusterService, state);
        TestRequest(StreamInput in) throws IOException {
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
        assertEquals(100, shardStats.getTotalPrimaryBytes());
import org.opensearch.cluster.routing.ShardRoutingState;
            }
        }
                randomNonNegativeLong(),
            task
            count.incrementAndGet();
            callback.onResponse(count::decrementAndGet);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        );
import org.opensearch.cluster.routing.ShardRouting;
            threadPool
            if (isPrimaryMode.get()) {
        final ReplicationTask task = maybeTask();
import static org.mockito.Mockito.doAnswer;
            public void sendResponse(TransportResponse response) {
        final Settings settings = Settings.builder()
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
import static org.opensearch.test.ClusterServiceUtils.setState;
            Settings settings,
            null,
        when(indexShard.getReplicationGroup()).thenReturn(replicationGroup);
import org.opensearch.core.index.shard.ShardId;
        return random().nextBoolean() ? new ReplicationTask(0, null, null, null, null, null) : null;
        }
            .build();
import org.opensearch.index.translog.Translog;
        @Override
    void assertPhase(@Nullable ReplicationTask task, String phase) {
        );
    ReplicationTask maybeTask() {
        });
                randomNonNegativeLong(),
    public static void afterClass() {
import org.opensearch.index.ShardIndexingPressureSettings;
        }
            task
        }
            @Override
        @Override
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    private static class TestResponse extends ReplicationResponse implements WriteResponse {
        );
        transportService.start();
import static org.mockito.Mockito.any;
            return mockIndexService(indexSafe, clusterService);
import org.opensearch.cluster.routing.RoutingNode;
import java.util.Locale;
                new ActionFilters(new HashSet<>()),
                return "replica_test";
import org.opensearch.common.settings.Settings;
        transportService = transport.createTransportService(
import static org.mockito.Mockito.anyString;
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
import static org.mockito.Mockito.when;
    private IndexService mockIndexService(final IndexMetadata indexMetaData, ClusterService clusterService) {
                new TestRequest(),
            task
import static java.util.Collections.emptyMap;
import org.opensearch.threadpool.TestThreadPool;
            return 100;
        return indicesService;
import org.opensearch.core.action.ActionListener;
            .build();
            clusterService,
    @BeforeClass
        action.handlePrimaryRequest(
        clusterService = createClusterService(threadPool);
}
            long term = (Long) invocation.getArguments()[0];
            createTransportChannel(new PlainActionFuture<>()),
            .build();
            shardStateAction,
import org.opensearch.action.support.ActionFilters;
     */
                NoopTracer.INSTANCE
        ReplicationGroup replicationGroup = mock(ReplicationGroup.class);
            final long primaryTerm = indexShard.getPendingPrimaryTerm();
    }
            new TransportReplicationAction.ConcreteReplicaRequest<>(
            ),
                throw new ShardNotFoundException(shardId);
     */
            this.forcedRefresh = forcedRefresh;
    public void tearDown() throws Exception {
            .getIndexingPressureShardStats(shardId);
            TestRequest request,
        setState(clusterService, state);
    }
            }
            final ShardRouting routing = node.getByShardId(shardId);
            return new TestResponse();
        );
        action.handleReplicaRequest(
        action.handlePrimaryRequest(
 * SPDX-License-Identifier: Apache-2.0
import java.util.Objects;
import org.opensearch.action.support.WriteResponse;
                TestRequest::new,
            ),
            @Override
            assertThat(task.getPhase(), phaseMatcher);
            ActionListener.completeWith(listener, () -> new WriteReplicaResult<>(request, location, null, replica, logger));
    public static void beforeClass() {
import org.opensearch.common.lease.Releasable;
    private IndexShard mockIndexShard(ShardId shardId, ClusterService clusterService) {
import java.util.Collections;
                TestRequest::new,
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
            final ClusterState state = clusterService.state();
import org.opensearch.index.IndexService;
    @SuppressWarnings("unchecked")
        );
        @Override
        final IndicesService indicesService = mock(IndicesService.class);
            );
            clusterService,
            ThreadPool threadPool
                new TestRequest(),
                settings,
    private TransportService transportService;
                randomNonNegativeLong()
    }
                return null;
            } else {
        transport = new CapturingTransport();
                throw new IllegalArgumentException(
    }
            return 100;
                transportService,
                callback.onFailure(new ShardNotInPrimaryModeException(shardId, IndexShardState.STARTED));
                replicaRouting.allocationId().getId(),
    }
        final ReplicationTask task = maybeTask();
                false,
import org.opensearch.test.OpenSearchTestCase;
            }
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            createTransportChannel(new PlainActionFuture<>()),
    @Override
                true,
        ) {
            @Override
                randomNonNegativeLong()
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        final ReplicationTask task = maybeTask();
        super.setUp();
            ShardStateAction shardStateAction,
        final Settings settings = Settings.builder()
            threadPool
            ClusterService clusterService,
            public String getProfileName() {
    }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
        TestAction action = new TestAction(settings, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
     * Sometimes build a ReplicationTask for tracking the phase of the
    }
    }
import org.opensearch.index.shard.ShardNotFoundException;
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[0];
        ) {
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.indices.SystemIndices;
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
        assertTrue(!Objects.isNull(shardStats));
        final ReplicationTask task = maybeTask();
import static org.hamcrest.Matchers.equalTo;
                listener,
        final ReplicationTask task = maybeTask();
        protected void dispatchedShardOperationOnPrimary(
    /**
            TransportService transportService,
        when(indexService.getShard(anyInt())).then(invocation -> {
    /**
            task
import org.junit.Before;
        assertTrue(Objects.isNull(shardStats));
            } else {
        protected long replicaOperationSize(TestRequest request) {
        protected TestAction(
        public void setForcedRefresh(boolean forcedRefresh) {
import java.io.IOException;
            if (term < primaryTerm) {
    }
import java.util.HashSet;
    private ShardStateAction shardStateAction;
        final Settings settings = Settings.builder()
        @Override
        protected TestResponse newResponseInstance(StreamInput in) throws IOException {
        assertTrue(!Objects.isNull(shardStats));
            .getIndexingPressureShardStats(shardId);
                () -> new WritePrimaryResult<>(request, new TestResponse(), location, null, primary, logger)
        @Override
                randomNonNegativeLong(),
            Collections.emptySet(),
                clusterService,
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(CommonStatsFlags.ALL)
        releasable = mock(Releasable.class);
            }
            createTransportChannel(new PlainActionFuture<>()),
            "internal:testActionWithExceptions",
            }
                new TestRequest(),
            .build();
                TransportWriteActionForIndexingPressureTests.this.indexingPressureService,
            final ShardId shardId = new ShardId(indexMetaData.getIndex(), shard);
    private final AtomicBoolean isPrimaryMode = new AtomicBoolean(true);
    public void setUp() throws Exception {
                listener.onResponse(((TestResponse) response));
                    String.format(Locale.ROOT, "%s operation term [%d] is too old (current [%d])", shardId, term, primaryTerm)
import org.opensearch.threadpool.ThreadPool;
/*
import org.opensearch.cluster.service.ClusterService;
        final ReplicationTask task = maybeTask();
            if (shard > indexMetaData.getNumberOfShards()) {
    }
            String actionName,
        when(indexShard.getPendingPrimaryTerm()).thenAnswer(
    }
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
    private IndexingPressureService indexingPressureService;
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        assertTrue(!Objects.isNull(shardStats));
import org.opensearch.index.shard.IndexShardState;
        });
        final Settings settings = Settings.builder()
        setState(clusterService, state);
        location = mock(Translog.Location.class);
        when(indexShard.routingEntry()).thenAnswer(invocationOnMock -> {
        setState(clusterService, state);
    private static class TestRequest extends ReplicatedWriteRequest<TestRequest> {
            super(new ShardId("test", "_na_", 0));
     * Transport channel that is needed for testing.
    }
        }
        };
    private Translog.Location location;
        assertPhase(task, equalTo(phase));
    @After
                replicaRouting.allocationId().getId(),
                true
        assertPhase(task, "finished");
        when(indexShard.shardId()).thenReturn(shardId);
    @AfterClass
    }
            }
        CommonStatsFlags statsFlag = new CommonStatsFlags();
                new TestRequest(),
                randomNonNegativeLong()
            createTransportChannel(new PlainActionFuture<>()),
    }
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
import org.junit.After;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
        final ShardId shardId = new ShardId("test", "_na_", 0);
     * if the task as null just as well as if it is supplied this returns null
            .getIndexingPressureShardStats(shardId);
    public void testIndexingPressureOperationStartedForReplicaShard() {
                true,
    public TransportChannel createTransportChannel(final PlainActionFuture<TestResponse> listener) {
            final IndexMetadata indexSafe = state.metadata().getIndexSafe(index);
                new TestRequest(),
            public void sendResponse(Exception exception) {
        protected void dispatchedShardOperationOnReplica(TestRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {
            @Override
import org.opensearch.index.shard.ReplicationGroup;
            }
     * If the task is non-null this asserts that the phrase matches.
import org.opensearch.common.settings.ClusterSettings;
            ),
import org.opensearch.action.support.PlainActionFuture;
import org.junit.AfterClass;
    }
        when(indexShard.isRelocatedPrimary()).thenAnswer(invocationOnMock -> isRelocated.get());
import org.opensearch.transport.TransportChannel;
        when(indexShard.state()).thenReturn(IndexShardState.STARTED);
        });
        }
        super.tearDown();
            transportService,
    }
                replicaRouting.allocationId().getId(),
        statsFlag.includeAllShardIndexingPressureTrackers(true);
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
        return indexService;
        final ShardId shardId = new ShardId("test", "_na_", 0);
                return "";
                replicaRouting.allocationId().getId(),
    public void testIndexingPressureOperationStartedForLocalPrimaryNode() {
            i -> clusterService.state().metadata().getIndexSafe(shardId.getIndex()).primaryTerm(shardId.id())
                threadPool,
    private class TestAction extends TransportWriteAction<TestRequest, TestRequest, TestResponse> {
    @Override
                count.incrementAndGet();
    public void testIndexingPressureOperationStartedForPrimaryShard() {
            super(in);
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
                );
    public void testIndexingPressureOperationStartedForPrimaryNode() {
                return mockIndexService(clusterService.state().metadata().getIndexSafe(index), clusterService);
        action.handlePrimaryRequest(
        @Override
            .getIndexingPressureShardStats(shardId);
import org.opensearch.index.shard.IndexShard;
        }).when(indexShard).acquireReplicaOperationPermit(anyLong(), anyLong(), anyLong(), any(ActionListener.class), anyString(), any());
    private IndicesService mockIndicesService(ClusterService clusterService) {
     * half the time.
    /**
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
            ActionListener.completeWith(
                throw new ShardNotFoundException(shardId, "shard is no longer assigned to current node");
import static org.mockito.Mockito.doThrow;
    private ClusterService clusterService;
    private void assertPhase(@Nullable ReplicationTask task, Matcher<String> phaseMatcher) {
        public String toString() {
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                callback.onResponse(count::decrementAndGet);
            Index index = (Index) invocation.getArguments()[0];
        final ShardId shardId = new ShardId("test", "_na_", 0);
            new TransportReplicationAction.ConcreteReplicaRequest<>(
            IndexShard primary,
import org.hamcrest.Matcher;
            final ClusterState state = clusterService.state();
        }
            task
        assertPhase(task, "finished");
            return null;
import org.opensearch.cluster.ClusterState;
        }
        when(indicesService.indexServiceSafe(any(Index.class))).then(invocation -> {
    private static ThreadPool threadPool;
                new TestRequest(),
        assertPhase(task, "finished");
                mockIndicesService(clusterService),
            }
        );
        );
     */
            final RoutingNode node = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        }
        );
 */
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(statsFlag)
import org.opensearch.index.stats.IndexingPressurePerShardStats;
        CommonStatsFlags statsFlag = new CommonStatsFlags();
            ),
        action.handlePrimaryRequest(
    }
        final IndexService indexService = mock(IndexService.class);
                true
        final Settings settings = Settings.builder()
import org.opensearch.test.transport.CapturingTransport;
package org.opensearch.action.support.replication;
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
    private CapturingTransport transport;
        TestAction action = new TestAction(settings, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
                listener.onFailure(exception);
        return indexShard;
            return routing;
