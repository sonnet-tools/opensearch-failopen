        final Settings settings = Settings.builder()  
            public String getProfileName() {
        @Override  
        );
    private TransportService transportService;
            .build();
            ),  
    public void testIndexingPressureOperationStartedForReplicaNode() {
                );  
        when(indexShard.state()).thenReturn(IndexShardState.STARTED);
            ActionListener<PrimaryResult<TestRequest, TestResponse>> listener
import org.opensearch.index.translog.Translog;  
        }
                randomNonNegativeLong()  
        assertTrue(!Objects.isNull(shardStats));
                new SystemIndices(emptyMap()),
        final Settings settings = Settings.builder()  
            super(
            ActionListener.completeWith(listener, () -> new WriteReplicaResult<>(request, location, null, replica, logger));
            final RoutingNode node = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        threadPool = null;
import org.opensearch.threadpool.ThreadPool;
        final ShardId shardId = new ShardId("test", "_na_", 0);
                transportService,
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
                replicaRouting.allocationId().getId(),  
            .build();
    }
                settings,  
            Collections.emptySet(),  
            createTransportChannel(new PlainActionFuture<>()),
                randomNonNegativeLong(),
    private CapturingTransport transport;
import org.junit.After;
            return 100;  
        protected long replicaOperationSize(TestRequest request) {
            }
            @Override
        final ReplicationTask task = maybeTask();
        assertPhase(task, "finished");
        );  
                TestRequest::new,  
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
    /**  
import org.opensearch.cluster.routing.ShardRoutingState;
                true
    public void tearDown() throws Exception {  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)  
                throw new IllegalArgumentException(
import static org.hamcrest.Matchers.equalTo;
            if (state.metadata().hasIndex(index.getName())) {  
        releasable = mock(Releasable.class);  
        when(indicesService.indexServiceSafe(any(Index.class))).then(invocation -> {  
import org.opensearch.common.lease.Releasable;
        final ReplicationTask task = maybeTask();  
            new TransportReplicationAction.ConcreteShardRequest<>(
            }
        doAnswer(invocation -> {
 * SPDX-License-Identifier: Apache-2.0
        }).when(indexShard).acquireReplicaOperationPermit(anyLong(), anyLong(), anyLong(), any(ActionListener.class), anyString(), any());
import org.opensearch.action.support.ActionFilters;
            String actionName,
            clusterService.getSettings(),
    private IndexingPressureService indexingPressureService;  
            settings,  
        }
        protected void dispatchedShardOperationOnPrimary(
        TestAction action = new TestAction(
        clusterService.close();
        @Override
import org.opensearch.action.support.WriteResponse;
            }
        });
        when(indicesService.indexService(any(Index.class))).then(invocation -> {  
import org.opensearch.cluster.action.shard.ShardStateAction;  
    private IndicesService mockIndicesService(ClusterService clusterService) {
            } else {  
    @Override
 * Copyright OpenSearch Contributors.
            this.forcedRefresh = forcedRefresh;  
                threadPool,
        @Override
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
    }  
import org.opensearch.cluster.routing.RoutingNode;
            .getIndexingPressureShardStats(shardId);
    private static class TestRequest extends ReplicatedWriteRequest<TestRequest> {
    ReplicationTask maybeTask() {  
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        return indicesService;  
        clusterService = createClusterService(threadPool);
            task
     * Transport channel that is needed for testing.
        return random().nextBoolean() ? new ReplicationTask(0, null, null, null, null, null) : null;
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
            long term = (Long) invocation.getArguments()[0];  
                callback.onResponse(count::decrementAndGet);
            null,
            task
import org.opensearch.common.settings.Settings;  
                TestRequest::new,
        final IndexShard indexShard = mock(IndexShard.class);  
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
    public void testIndexingPressureOperationStartedForReplicaShard() {
    @Override  
    @AfterClass
        final IndicesService indicesService = mock(IndicesService.class);
        doThrow(new AssertionError("failed shard is not supported")).when(indexShard).failShard(anyString(), any(Exception.class));  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        final ShardId shardId = new ShardId("test", "_na_", 0);
            @Override  
        final ReplicationTask task = maybeTask();
            task
                randomNonNegativeLong(),
                TransportWriteActionForIndexingPressureTests.this.indexingPressureService,  
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(CommonStatsFlags.ALL)  
        setState(clusterService, state);
    public static void beforeClass() {
        final ReplicationTask task = maybeTask();
            final IndexMetadata indexSafe = state.metadata().getIndexSafe(index);  
     * if the task as null just as well as if it is supplied this returns null  
            final ShardId shardId = new ShardId(indexMetaData.getIndex(), shard);
                randomNonNegativeLong(),
    public void testIndexingPressureOperationStartedForLocalPrimaryNode() {  
     * If the task is non-null this asserts that the phrase matches.
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(statsFlag)
    private Translog.Location location;
     */  
import org.opensearch.cluster.ClusterState;
import org.opensearch.index.shard.IndexShard;  
        when(indexShard.isRelocatedPrimary()).thenAnswer(invocationOnMock -> isRelocated.get());
        }
            .build();  
        }  
import static org.mockito.Mockito.mock;  
    private void assertPhase(@Nullable ReplicationTask task, Matcher<String> phaseMatcher) {
        return indexShard;
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
import org.junit.BeforeClass;
        TestAction action = new TestAction(settings, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);  
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);  
                true,  
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        final Settings settings = Settings.builder()
            final long primaryTerm = indexShard.getPendingPrimaryTerm();
            }
            if (routing == null) {  
import static org.mockito.Mockito.doAnswer;
            }
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[0];
        @Override
    private IndexShard mockIndexShard(ShardId shardId, ClusterService clusterService) {
            );  
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
            } else {
            TestRequest request,
    private Releasable releasable;
        }
    public void setUp() throws Exception {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
    private IndexService mockIndexService(final IndexMetadata indexMetaData, ClusterService clusterService) {  
        setState(clusterService, state);
            transportService,
            ),
 */  
                new TestRequest(),
                return mockIndexService(clusterService.state().metadata().getIndexSafe(index), clusterService);
            return 100;
            createTransportChannel(new PlainActionFuture<>()),
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
    }
import org.opensearch.action.support.PlainActionFuture;  
        CommonStatsFlags statsFlag = new CommonStatsFlags();  
        public String toString() {
        transportService = transport.createTransportService(  
    public void testIndexingPressureOperationStartedForPrimaryShard() {  
        super.tearDown();
                new TestRequest(),
            new TransportReplicationAction.ConcreteReplicaRequest<>(  
            public void sendResponse(Exception exception) {  
            final ClusterState state = clusterService.state();
                randomNonNegativeLong(),  
    public void testIndexingPressureOperationStartedForLocalPrimaryShard() {
            if (shard > indexMetaData.getNumberOfShards()) {
        final ShardId shardId = new ShardId("test", "_na_", 0);  
            ),  
            ActionListener.completeWith(  
                randomNonNegativeLong(),  
        });
        setState(clusterService, state);  
    public static final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.Collections;
     * half the time.
            Settings settings,
        assertPhase(task, "finished");
            .build();
        transportService.acceptIncomingRequests();
import java.util.concurrent.atomic.AtomicBoolean;
                count.incrementAndGet();  
        doAnswer(invocation -> {  
            @Override
                actionName,
import java.util.concurrent.atomic.AtomicInteger;
            Index index = (Index) invocation.getArguments()[0];
    }  
        }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
                throw new ShardNotFoundException(shardId, "shard is no longer assigned to current node");
import org.opensearch.core.index.Index;  
            shardStateAction,
import org.opensearch.transport.TransportService;  
import org.opensearch.indices.SystemIndices;
        action.handleReplicaRequest(
        statsFlag.includeAllShardIndexingPressureTrackers(true);  
import org.opensearch.test.OpenSearchTestCase;
        when(indexShard.shardId()).thenReturn(shardId);
        assertTrue(Objects.isNull(shardStats));  
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);  
            public String getChannelType() {
            createTransportChannel(new PlainActionFuture<>()),
import org.opensearch.index.shard.ShardNotFoundException;  
        public void setForcedRefresh(boolean forcedRefresh) {
        assertTrue(Objects.isNull(shardStats));
package org.opensearch.action.support.replication;
        assertPhase(task, "finished");
        );  
                true,
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
            if (isPrimaryMode.get()) {
    }
            assertThat(task.getPhase(), phaseMatcher);
                new TestRequest(),
        protected long primaryOperationSize(TestRequest request) {  
        setState(clusterService, state);
                listener,
        boolean forcedRefresh;
            new TransportReplicationAction.ConcreteReplicaRequest<>(  
        assertTrue(!Objects.isNull(shardStats));  
                randomNonNegativeLong(),
            "internal:testActionWithExceptions",
        threadPool = new TestThreadPool("ShardReplicationTests");  
import org.junit.Before;
import org.opensearch.transport.TransportChannel;
        final Settings settings = Settings.builder()  
                replicaRouting.allocationId().getId(),  
                randomNonNegativeLong()
        });
}
            ),
    }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)
                replicaRouting.allocationId().getId(),
        ) {
import org.opensearch.index.IndexService;  
        }  
        protected void dispatchedShardOperationOnReplica(TestRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {
                callback.onFailure(new ShardNotInPrimaryModeException(shardId, IndexShardState.STARTED));
import org.opensearch.core.action.ActionListener;
    @After
        TestRequest() {  
            transportService,
    private static class TestResponse extends ReplicationResponse implements WriteResponse {
            ),
        super.setUp();  
        }).when(indexShard).acquirePrimaryOperationPermit(any(ActionListener.class), anyString(), any());
        };
import org.opensearch.common.Nullable;  
        assertTrue(Objects.isNull(shardStats));
                randomNonNegativeLong()
            return routing;  
            task
import org.opensearch.index.ShardIndexingPressureSettings;
                    String.format(Locale.ROOT, "%s operation term [%d] is too old (current [%d])", shardId, term, primaryTerm)
    private static ThreadPool threadPool;
                listener.onFailure(exception);
import java.io.IOException;
                randomNonNegativeLong(),
            return new TestResponse();
        );
        final ReplicationTask task = maybeTask();
        TestRequest(StreamInput in) throws IOException {
    }  
            .build();
            clusterService,  
    private ClusterService clusterService;  
import org.opensearch.indices.IndicesService;
            task  
        @Override  
        location = mock(Translog.Location.class);
    }
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), true)  
            IndexShard primary,  
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);  
                replicaRouting.allocationId().getId(),
        assertPhase(task, equalTo(phase));
        final IndexService indexService = mock(IndexService.class);
        );  
                replicaRouting.allocationId().getId(),
        when(indexShard.routingEntry()).thenAnswer(invocationOnMock -> {
                listener.onResponse(((TestResponse) response));
            shardStateAction,
    @BeforeClass
     * TransportReplicationAction. Since TransportReplicationAction has to work
    public static void afterClass() {  
    }
        statsFlag.includeAllShardIndexingPressureTrackers(true);  
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(statsFlag)
/*  
     */
            callback.onResponse(count::decrementAndGet);  
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(CommonStatsFlags.ALL)
        statsFlag.includeAllShardIndexingPressureTrackers(true);
                randomNonNegativeLong(),
    }
        assertPhase(task, "finished");
        @Override  
            Index index = (Index) invocation.getArguments()[0];
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
        assertPhase(task, "finished");
                NoopTracer.INSTANCE
            x -> clusterService.localNode(),
            }
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[3];
        final Settings settings = Settings.builder()
        }
            return null;
        }
            public void sendResponse(TransportResponse response) {
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);  
    /**
                true  
        action.handlePrimaryRequest(  
            }  
        final Settings settings = Settings.builder()
            return "TestRequest{}";  
        );  
        protected TestAction(  
                return "";  
        CommonStatsFlags statsFlag = new CommonStatsFlags();
            .getIndexingPressureShardStats(shardId);  
                false,
            return mockIndexShard(shardId, clusterService);
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);
        protected TestResponse newResponseInstance(StreamInput in) throws IOException {
            NoopTracer.INSTANCE
                () -> new WritePrimaryResult<>(request, new TestResponse(), location, null, primary, logger)
        when(indexShard.getActiveOperationsCount()).thenAnswer(i -> count.get());  
            ThreadPool threadPool  
        setState(clusterService, state);  
            new TransportReplicationAction.ConcreteShardRequest<>(
        });  
            createTransportChannel(new PlainActionFuture<>()),
            new TransportReplicationAction.ConcreteReplicaRequest<>(
            );  
        transportService.start();  
            new TransportReplicationAction.ConcreteReplicaRequest<>(  
import org.hamcrest.Matcher;
            "internal:testActionWithExceptions",
        assertTrue(!Objects.isNull(shardStats));
                return null;  
            .build();
        final ShardId shardId = new ShardId("test", "_na_", 0);
import org.opensearch.index.IndexingPressureService;
        action.handlePrimaryRequest(
        assertEquals(100, shardStats.getTotalPrimaryBytes());  
            settings,  
        );  
                throw new ShardNotFoundException(shardId);  
        this.indexingPressureService = new IndexingPressureService(settings, clusterService);  
        when(indexService.getShard(anyInt())).then(invocation -> {
import java.util.HashSet;  
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);  
        ReplicationGroup replicationGroup = mock(ReplicationGroup.class);
        action.handleReplicaRequest(  
import org.opensearch.core.index.shard.ShardId;
    private ShardStateAction shardStateAction;  
            threadPool
            return null;  
import static org.mockito.Mockito.any;  
        TestAction action = new TestAction(settings, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
import static org.mockito.Mockito.when;
        );
import static org.mockito.Mockito.anyString;  
            super(in);  
            final ClusterState state = clusterService.state();
public class TransportWriteActionForIndexingPressureTests extends OpenSearchTestCase {  
        TestAction action = new TestAction(settings, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
            @Override
        );
        final ReplicationTask task = maybeTask();
            ShardStateAction shardStateAction,
            threadPool
import static org.mockito.Mockito.anyInt;
        CommonStatsFlags statsFlag = new CommonStatsFlags();
    }  
            clusterService,  
    /**
        assertEquals(100, shardStats.getTotalReplicaBytes());  
import org.opensearch.core.common.io.stream.StreamInput;
        return indexService;
            return mockIndexService(indexSafe, clusterService);
    }  
    }
                replicaRouting.allocationId().getId(),
                new TestRequest(),
        transport = new CapturingTransport();
        if (task != null) {  
            .getIndexingPressureShardStats(shardId);
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(CommonStatsFlags.ALL)
import static org.mockito.Mockito.anyLong;
import org.opensearch.action.admin.indices.stats.CommonStatsFlags;
    private class TestAction extends TransportWriteAction<TestRequest, TestRequest, TestResponse> {
            createTransportChannel(new PlainActionFuture<>()),
            }
import org.opensearch.common.settings.ClusterSettings;
        final ShardId shardId = new ShardId("test", "_na_", 0);  
import org.opensearch.index.shard.IndexShardState;
            ),  
                mockIndicesService(clusterService),
                randomNonNegativeLong(),
                new TestRequest(),  
    }
        }
        }
        TestAction action = new TestAction(
    }
    private final AtomicBoolean isRelocated = new AtomicBoolean(false);
import org.opensearch.test.transport.CapturingTransport;
        assertPhase(task, "finished");  
        IndexingPressurePerShardStats shardStats = this.indexingPressureService.shardStats(statsFlag)
import org.opensearch.cluster.routing.ShardRouting;  
        @Override
import org.opensearch.cluster.service.ClusterService;
import static org.opensearch.test.ClusterServiceUtils.setState;
                randomNonNegativeLong()
import static org.mockito.Mockito.doThrow;
            count.incrementAndGet();
                randomNonNegativeLong(),  
            super(new ShardId("test", "_na_", 0));
                ignore -> ThreadPool.Names.SAME,
        return new TransportChannel() {
import static java.util.Collections.emptyMap;
import java.util.Objects;
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
import org.opensearch.threadpool.TestThreadPool;  
import java.util.Locale;
     */  
import org.opensearch.index.shard.ReplicationGroup;
            .getIndexingPressureShardStats(shardId);
import org.junit.AfterClass;  
            .put(ShardIndexingPressureSettings.SHARD_INDEXING_PRESSURE_ENABLED.getKey(), false)
        TestAction action = new TestAction(settings, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
            .getIndexingPressureShardStats(shardId);
                new TestRequest(),
        ) {
            if (term < primaryTerm) {  
            final ClusterState state = clusterService.state();  
        setState(clusterService, state);  
    }  
    public void testIndexingPressureOperationStartedForPrimaryNode() {  
            createTransportChannel(new PlainActionFuture<>()),  
    private final AtomicBoolean isPrimaryMode = new AtomicBoolean(true);
    void assertPhase(@Nullable ReplicationTask task, String phase) {
    public TransportChannel createTransportChannel(final PlainActionFuture<TestResponse> listener) {
import org.opensearch.core.transport.TransportResponse;
            threadPool,
    @Before
            final ShardRouting routing = node.getByShardId(shardId);
    }
    }
        when(indexShard.getReplicationGroup()).thenReturn(replicationGroup);  
import org.opensearch.cluster.metadata.IndexMetadata;
            int shard = (Integer) invocation.getArguments()[0];  
            .getIndexingPressureShardStats(shardId);  
    private final AtomicInteger count = new AtomicInteger(0);  
        action.handlePrimaryRequest(
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            TransportService transportService,  
        );  
    @SuppressWarnings("unchecked")
        action.handlePrimaryRequest(
            }
        final ShardId shardId = new ShardId("test", "_na_", 0);
     * Sometimes build a ReplicationTask for tracking the phase of the
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
            task  
                new ActionFilters(new HashSet<>()),
    }
        when(indexShard.getPendingPrimaryTerm()).thenAnswer(
                shardStateAction,  
    }
            i -> clusterService.state().metadata().getIndexSafe(shardId.getIndex()).primaryTerm(shardId.id())
import java.util.concurrent.TimeUnit;  
            ClusterService clusterService,
import org.opensearch.index.stats.IndexingPressurePerShardStats;
                return "replica_test";  
                clusterService,  
