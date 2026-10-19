    /**
                false,
            // noinspection unchecked
                super.shardOperationOnPrimary(shardRequest, primary, listener);
        ReplicationTask task = maybeTask();
                    randomIntBetween(1, 16),
        assertIndexShardCounter(0);  // no permit should be held
        logger.debug("--> using initial state:\n{}", clusterService.state());
    private Exception randomRetryPrimaryException(ShardId shardId) {
        final ShardId shardId = new ShardId(index, "_na_", 0);
            clusterService,
            assertThat("primary term not properly set on primary delegation", concreteShardRequest.getPrimaryTerm(), equalTo(primaryTerm));
            Request request = new Request(shardId);
                count.incrementAndGet();
        proxy.performOn(
                );
import org.junit.Assert;
        assertListenerThrows("must throw index not found exception", listener, IndexNotFoundException.class);
import org.opensearch.threadpool.ThreadPool;
                return globalBlock == false ? ClusterBlockLevel.WRITE : null;
            if (throwExceptionOnRun || respondWithError) {
import org.opensearch.transport.Transport;
                        throw new RetryOnReplicaException(shardId, "simulation");
            listener.get(); // fail with the exception if there
import java.util.List;
                    randomBoolean(),
import org.opensearch.transport.TransportService;
            return mockIndexShard(shardId, clusterService);
        if (timeout) {
    public void testStalePrimaryShardOnReroute() {
        when(shard.getReplicationGroup()).thenReturn(replicationGroup);
        // check that at unknown node fails
            Index index = (Index) invocation.getArguments()[0];
import org.opensearch.cluster.OpenSearchAllocationTestCase;
                .get(primaryShard.relocatingNodeId());
    }
import org.apache.lucene.store.AlreadyClosedException;
                super.shardOperationOnPrimary(shardRequest, primary, listener);
                ActionListener.completeWith(listener, () -> {
     */
        if (globalBlock) {
    }
            Collections.emptySet(),
            TransportService transportService,
        setState(clusterService, state(index, true, ShardRoutingState.STARTED));
            ),
            randomIntBetween(1, 16),
            );
        }
        PlainActionFuture<ReplicaResponse> listener = new PlainActionFuture<>();
            transport.handleResponse(captures[0].requestId, response);
        assertFalse(listener.isDone());
    @Override
        reroutePhase = action.new ReroutePhase(null, request, listener);
                    containsString(
                ),
        assertTrue(listener.isDone());
                    "test global block",
        final boolean respondWithError = i == 2;
            .put(indexMetadata.getSettings())
        reroutePhase.run();
    private IndexService mockIndexService(final IndexMetadata indexMetadata, ClusterService clusterService) {
                    return new ReplicaResult();
                new ActionFilters(new HashSet<>()),
        }
        } else {
        ShardRouting relocationTarget = clusterService.state()
            assertThat(capturedRequests[0].action, equalTo("internal:testAction[p]"));
        setState(
            fail("listener shouldn't be done");
        assertEquals(ActiveShardCount.from(requestWaitForActiveShards), request.waitForActiveShards());
            } else {
    private boolean forceExecute;
        assertIndexShardCounter(0);
        doThrow(new AssertionError("failed shard is not supported")).when(indexShard).failShard(anyString(), any(Exception.class));
 */
    @Override
import org.opensearch.common.Nullable;
            Request request = new Request(shardId);
                    randomBoolean(),
import static org.hamcrest.Matchers.hasToString;
        transportService.stop();
        clusterService = createClusterService(threadPool);
        final long checkpoint = randomNonNegativeLong();
        transportService.acceptIncomingRequests();
            @Override
import org.opensearch.transport.TransportChannel;
        assertThat(capturedRequests, nullValue());
            new NetworkService(Collections.emptyList()),
            .build();
    public void testPrimaryReference() {
            assertPhase(task, "failed");
            assertPhase(task, "primary_delegation");
        listener = new PlainActionFuture<>();
            PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
                replica.allocationId().getId(),
            new TransportReplicationAction.ConcreteReplicaRequest<>(
            task
                    assertPhase(task, "replica");
            equalTo(primaryTerm)
        final ShardRouting replica = state.routingTable().shardRoutingTable(shardId).replicaShards().get(0);
import org.opensearch.index.remote.RemoteStoreTestsHelper;
    /**
        final ShardId shardId = new ShardId(index, "_na_", 0);
    public void testClosedIndexOnReroute() {
            PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
 * The OpenSearch Contributors require contributions made to
        final ShardId shardId = new ShardId(index, "_na_", 0);
        );
            @Override
            Collections.emptySet(),
            blocks.addGlobalBlock(block);
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
import static java.util.Collections.singleton;
            protected void shardOperationOnPrimary(
            ),
        final long checkpoint = randomNonNegativeLong();
            reroutePhase.run();
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
        }.new AsyncPrimaryAction(primaryRequest, listener, task).run();
            IndicesService indicesService
            } else {
        // we use one replica to check the primary term was set on the operation and sent to the replica
import org.opensearch.action.support.replication.ReplicationOperation.ReplicaResponse;
        Request request = new Request(shardId).timeout("1ms");
        assertEquals(0, count.get());
    }
                throw new IllegalArgumentException(
                    if (throwException.get()) {
        return indexService;
            namedWriteableRegistry,
            clusterService,
                        throw new RetryOnReplicaException(shardId, "simulation");
        ClusterState state = stateWithActivePrimary(index, true, 1 + randomInt(3), randomInt(2));
            return null;
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
            transport.handleError(captures[0].requestId, new TransportException("simulated"));
            final long primaryTerm = indexShard.getPendingPrimaryTerm();
                ActionListener.completeWith(listener, () -> {
            ActionListener<PrimaryResult<Request, TestResponse>> listener
        Request(StreamInput in) throws IOException {
    public static void afterClass() {
        setState(clusterService, state(index, true, randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.UNASSIGNED));
import org.opensearch.transport.client.transport.NoNodeAvailableException;
        doAnswer(invocation -> {
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        final String index = "test";
        setState(clusterService, state);
        when(indexShard.getPendingPrimaryTerm()).thenAnswer(
                new TransportReplicationAction.ConcreteReplicaRequest<>(
    public void testPrimaryPhaseExecutesDelegatedRequestOnRelocationTarget() {
        doAnswer(invocation -> {
        final IndexShardRoutingTable shardRoutings = state.routingTable().shardRoutingTable(shardId);
            request.timeout("0s");
        ReplicationTask task = maybeTask();
        boolean throwException = randomBoolean();
        } catch (ExecutionException execException) {
        }
            indicesService
            capturedRequests = transport.getCapturedRequestsAndClear();
            new TransportReplicationAction.ConcreteShardRequest<>(request, primaryShard.allocationId().getRelocationId(), primaryTerm);
        }
            .nodes(clusterService.state().nodes())
        }
            public ClusterBlockLevel indexBlockLevel() {
    public void testBlocksInReroutePhase() {
            @Override
        threadPool = null;
        setState(clusterService, state);
     * When relocating a primary shard, there is a cluster state update at the end of relocation where the active primary is switched from
        // cluster state for the index to appear
        @Override
        );
                )
import java.util.stream.Collectors;
        final String index = "test";
            Settings.EMPTY,
        reroutePhase = action.new ReroutePhase(task, request, listener);
        );
     * relocation target and relocation target believes active primary to be on relocation source. This results in replication
            assertFalse(request.isRetrySet.get());
        } catch (OpenSearchException e) {
        Request request = new Request(new ShardId("unknown_index", "_na_", 0)).timeout("1ms");
        reroutePhase.run();
        int requestWaitForActiveShards = randomIntBetween(0, numReplicas + 1);
        logger.info("using state: {}", state);
            true,
        }
                fail("releasable is closed twice");
        ClusterState state = stateWithActivePrimary(indexName, randomBoolean(), numReplicas);
            ShardRoutingState.RELOCATING
            );
        TestAction action = new TestAction(
            i -> clusterService.state().metadata().getIndexSafe(shardId.getIndex()).primaryTerm(shardId.id())
    private <T> T assertListenerThrows(String msg, PlainActionFuture<?> listener, Class<T> klass) {
    }
            "internal:testActionWithBlocks",
                ActionListener<PrimaryResult<Request, TestResponse>> listener
        final ShardId shardId = new ShardId(index, "_na_", 0);
        assertThat(
        return randomFrom(
            Throwable throwable = execException.getCause();
        ClusterState state = state(index, true, ShardRoutingState.RELOCATING);
        public void onRetry() {
                } else if (respondWithError) {
        if (listener.isDone()) {
            false,
    }
            final TransportReplicationAction.ReplicaResponse response = new TransportReplicationAction.ReplicaResponse(
        assertListenerThrows("must throw shard not found exception", listener, ShardNotFoundException.class);
            Request requestWithTimeout = new Request(new ShardId("unknown", "_na_", 0)).index("unknown").timeout("5ms");
        final ShardId shardId = new ShardId(index, "_na_", 0);
        AtomicReference<Object> failure = new AtomicReference<>();
        assertThat(concreteShardRequest.getTargetAllocationID(), equalTo(expectedAllocationId.getId()));
            Settings settings,
                randomLong()
import org.opensearch.cluster.routing.AllocationId;
 *
        setState(clusterService, state);
                checkpoint,
            isRelocated.set(true);
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithActivePrimary;
    public void testReplicaActionRejectsWrongAid() throws Exception {
        ) {
                createTransportChannel(new PlainActionFuture<>()),
import org.junit.AfterClass;
        action.resolveRequest(state.metadata().index(indexName), request);
            .build();
        final ShardRouting primaryShard = state.routingTable().shardRoutingTable(shardId).primaryShard();
        ClusterState state = stateWithActivePrimary(index, true, randomInt(5));
            }
                    replicaRouting.allocationId().getId(),
import org.opensearch.indices.IndicesService;
        assertTrue(request.isRetrySet.compareAndSet(true, false));
            null,
            }
        } else {
        assertThat(executed.get(), equalTo(true));
        }
                    randomNonNegativeLong(),
        assertFalse(request.isRetrySet.get());
            fail("using a wrong aid didn't fail the operation");
            return routing;
        request = new Request(shardId).waitForActiveShards(ActiveShardCount.from(requestWaitForActiveShards));
                assertPhase(task, "primary");
            equalTo(maxSeqNoOfUpdatesOrDeletes)
import static org.mockito.Mockito.when;
        final ShardRouting replica = randomFrom(
            assertTrue(closed.get());
     */
            final ShardId shardId = new ShardId(indexMetadata.getIndex(), shard);
            new Request(NO_SHARD_ID),
            ClusterService clusterService,
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(block));
            transportService,
        ClusterState state = state(index, true, ShardRoutingState.RELOCATING);
            assertIndexShardCounter(0);  // it should have been freed.
     */
        proxy.failShardIfNeeded(
                    return new ReplicaResult();
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
                assertFalse(executed.getAndSet(true));
     * when the request is using the default value for waitForActiveShards.
            this.waitForActiveShards = ActiveShardCount.NONE;
        final ShardRouting primary = clusterService.state().routingTable().shardRoutingTable(shardId).primaryShard();
            TransportService transportService,
    }
            .shardsWithState(ShardRoutingState.INITIALIZING)
        } catch (ExecutionException e) {
                return globalBlock ? ClusterBlockLevel.WRITE : null;
        ShardId shardId = new ShardId(clusterService.state().metadata().index("index").getIndex(), 0);
        IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().index(index).shard(shardId.id());
            NoopTracer.INSTANCE
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
        final ClusterBlocks.Builder block = ClusterBlocks.builder();
    }
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
        request.routedBasedOnClusterVersion(clusterService.state().version() + 1);
            ReplicationTask task = maybeTask();
    public void testBlocksInPrimaryAction() {
        );
            if (wrongAllocationId) {
                "_not_a_valid_aid_",
                requests.get(0).action,
            threadPool,
        assertTrue(request.isRetrySet.get());
                task
        final PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        Metadata metadata = Metadata.builder().build();
    }
                Request shardRequest,
        IndexMetadata indexMetadata = state.metadata().index(indexName);
        proxy.performOn(replica, new Request(NO_SHARD_ID), primaryTerm, randomNonNegativeLong(), randomNonNegativeLong(), listener);
        int numReplicas = randomIntBetween(0, 5);
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
import org.opensearch.transport.TestTransportChannel;
            return null;
                ActionListener<PrimaryResult<Request, TestResponse>> listener
        // test wait_for_active_shards when default not set on the request (request value should be honored over index setting)
                assertPhase(task, "primary");
        if (timeout) {
        AtomicBoolean executed = new AtomicBoolean();
            assertPhase(task, "finished");
            primaryTerm,
        }
            transportService,
        listener = new PlainActionFuture<>();
        logger.debug("--> relocation ongoing state:\n{}", clusterService.state());
     * if the task as null just as well as if it is supplied this returns null
            listener.get();
        ) {
import org.opensearch.common.settings.Settings;
        final ClusterState initialState = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        assertListenerThrows("unassigned primary didn't cause a timeout", listener, UnavailableShardsException.class);
        state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(replica.currentNodeId())).build();
        final ShardId shardId = new ShardId("test", "_na_", 0);
        transportService.acceptIncomingRequests();
        PendingReplicationActions replicationActions = new PendingReplicationActions(shardId, threadPool);
            ThreadPool threadPool,
        final TestAction actionWithBlocks = new TestAction(
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
     */
        final boolean globalBlock = randomBoolean();
        ClusterBlock randomBlock = new ClusterBlock(
        final TestAction action = new TestAction(
            assertThat(throwable.getMessage(), containsString("_not_a_valid_aid_"));
        listener = new PlainActionFuture<>();
        assertThat(capturedRequests[0].action, equalTo("internal:testAction[p]"));
            assertTrue(listener.isDone());
            assertPhase(task, "waiting_on_primary");
 * software distributed under the License is distributed on an
        final String index = "test";
import org.opensearch.index.shard.IndexShardClosedException;
        } else {
import org.opensearch.transport.TransportException;
 * this file be licensed under the Apache-2.0 license or a
            }
        TestAction action = new TestAction(
        // publish a new state (same as the old state with the version incremented)
    private IndexShard mockIndexShard(ShardId shardId, ClusterService clusterService) {
            x -> clusterService.localNode(),
        assertThat(e.getCause().getCause(), instanceOf(ShardNotInPrimaryModeException.class));
        assertTrue(listener.isDone());
        action.handleReplicaRequest(
import org.opensearch.cluster.routing.allocation.AllocationService;
        throwException.set(false);
        listener = new PlainActionFuture<>();
                    return new ReplicaResult();
                ActionListener<PrimaryResult<Request, TestResponse>> listener
            "internal:testIsRetryableClusterBlockException",
        assertPhase(task, "failed");
        final ClusterState stateWithNodes = ClusterState.builder(initialState)
        Releasable releasable = () -> {
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
        try {
import org.junit.BeforeClass;
        shard.runUnderPrimaryPermit(() -> primary.perform(request, ActionTestUtils.assertNoFailureListener(r -> {
        when(indexShard.routingEntry()).thenAnswer(invocationOnMock -> {
        assertFalse(request.isRetrySet.get());
            new IndexNotFoundException(shardId.getIndex()),
        threadPool = new TestThreadPool("ShardReplicationTests");
                randomNonNegativeLong(),
            "retryable",
        forceExecute = randomBoolean();
        assertFalse(request.isRetrySet.get());
                    assertPhase(task, "replica");
    private TransportService transportService;
        request = new Request(new ShardId("unknown_index", "_na_", 0)).timeout("1ms");
import static org.hamcrest.CoreMatchers.containsString;
            final RoutingNode node = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        );
        }).when(indexShard).acquireReplicaOperationPermit(anyLong(), anyLong(), anyLong(), any(ActionListener.class), anyString(), any());
    private static final ShardId NO_SHARD_ID = null;
            assertTrue(listener.isDone());
            );
import org.opensearch.action.admin.indices.create.CreateIndexRequest;
            clusterService.getSettings(),
                return mockIndexService(clusterService.state().metadata().getIndexSafe(index), clusterService);
                threadPool,
        new TestAction(Settings.EMPTY, "internal:testAction2", transportService, clusterService, shardStateAction, threadPool) {
        when(shard.getActiveOperationsCount()).thenAnswer(i -> count.get());
            reroutePhase.run();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        final T cause = (T) exception.getCause();
    public void testReplicaProxy() throws InterruptedException, ExecutionException {
        when(indexShard.getReplicationGroup()).thenReturn(replicationGroup);
            false,
        Request request = new Request(new ShardId(clusterService.state().metadata().indices().get(index).getIndex(), 0)).timeout("1ms");
        final ShardId shardId = new ShardId(index, "_na_", 0);
            }
        logger.debug("--> using initial state:\n{}", clusterService.state());
    }
        setState(clusterService, state(index, true, ShardRoutingState.STARTED));
                "primary action should fail operation",
            assertThat(requests, notNullValue());
     * the relocation source to the relocation target. If relocation source receives and processes this cluster state
    }
 * ownership. Elasticsearch licenses this file to you under
            assertTrue(request.isRetrySet.get());
        assertConcreteShardRequest(capturedRequest.request, request, replica.allocationId());
import org.opensearch.index.shard.ShardNotFoundException;
        };
        );
     */
import org.opensearch.core.index.Index;
                transportService,
        reroutePhase.run();
        // no replicas in order to skip the replication part
    public static <R extends ReplicationRequest> R resolveRequest(TransportRequest requestOrWrappedRequest) {
            threadPool
                clusterService,
        final ShardId shardId = new ShardId(index, "_na_", 0);
import org.opensearch.test.transport.MockTransportService;
            TestAction.ReroutePhase reroutePhase = testActionWithNoBlocks.new ReroutePhase(task, requestWithTimeout, listener);
            assertThat(capturedRequests, arrayWithSize(1));
            listener.onResponse(new PrimaryResult<>(shardRequest, new TestResponse()));
        reroutePhase.run();
        );
        final IndexService indexService = mock(IndexService.class);
        AllocationService allocationService = OpenSearchAllocationTestCase.createAllocationService();
            }
            1,
        boolean executeOnPrimary = true;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.atomic.AtomicReference;
                Request::new,
import org.opensearch.cluster.routing.TestShardRouting;
import org.opensearch.cluster.block.ClusterBlocks;
        } else {
        assertTrue(request.isRetrySet.get());
        assertListenerThrows("must throw index not found exception", listener, IndexNotFoundException.class);
            Version.CURRENT,
                );
        transportService = new MockTransportService(
        final boolean wrongAllocationId = randomBoolean();
            return mockIndexService(indexSafe, clusterService);
        when(indicesService.indexServiceSafe(shard.shardId().getIndex())).thenReturn(indexService);
                randomLong(),
            @Override
            final ShardRouting routing = node.getByShardId(shardId);
        AtomicBoolean processedOnPrimary = new AtomicBoolean();
        final ReplicationTask task = maybeTask();
            shardStateAction,
            new TransportReplicationAction.ConcreteReplicaRequest<>(
        final ShardId shardId = new ShardId(index, "_na_", 0);
        assertThat(exception.getCause(), instanceOf(ClusterBlockException.class));
            ClusterBlockLevel.ALL
            .shardRoutingTable(shardId)
            final OpenSearchException exception = new OpenSearchException("testing");
        TestAction action = new TestAction(
        } else {
import org.opensearch.core.action.ActionListener;
        ReplicationGroup replicationGroup = new ReplicationGroup(shardRoutingTable, inSyncIds, trackedAllocationIds, 0);
            listener.get(); // fail with the exception if there
        // noinspection unchecked
        AtomicBoolean throwException = new AtomicBoolean(true);
        final IndexShard shard = mock(IndexShard.class);
import static org.hamcrest.Matchers.equalTo;
        Request request = new Request(shardId);
            primaryRequest, listener, task
    public void testRetryOnReplicaWithRealTransport() throws Exception {
        setState(clusterService, stateWithActivePrimary(index, true, randomInt(3)));
        ) {
                replica.allocationId().getId(),
        }
            }
                new ClusterBlock(
            threadPool,
import org.hamcrest.Matcher;
import org.opensearch.core.common.io.stream.StreamOutput;
            assertIndexShardUninitialized();
        assertPhase(task, "finished");
                equalTo("internal:testAction2[p]")
            // generate a CS change
        doAnswer(invocation -> {
        setState(clusterService, state);
        assertThat(exception.getCause(), instanceOf(klass));
        });
        protected TestResponse newResponseInstance(StreamInput in) throws IOException {
        state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(relocationTargetNode)).build();
        CapturingTransport.CapturedRequest[] captures = transport.getCapturedRequestsAndClear();
    }
                index,
        if (clusterService.state().nodes().getLocalNodeId().equals(primaryNodeId)) {
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
            if (state.metadata().hasIndex(index.getName())) {
            ClusterBlockException exception = assertListenerThrows(
            true,
        ) {
        final ClusterBlock retryableBlock = new ClusterBlock(
        );
        assertTrue(listener.isDone());
        Settings indexSettings = Settings.builder()
 * not use this file except in compliance with the License.
        final long primaryTerm = clusterState.metadata().index(index).primaryTerm(shardId.id());
        final Request request = new Request(shardId);
    public void testRetryOnReplica() throws Exception {
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
        assertThat(capturedRequests, notNullValue());
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
    }
                assertPhase(task, "primary");
public class TransportReplicationActionTests extends OpenSearchTestCase {
        }
            shardRoutings.replicaShards().stream().filter(ShardRouting::assignedToNode).collect(Collectors.toList())
    }
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        }
            transportService,
        Set<String> inSyncIds = randomBoolean()
import static org.mockito.Mockito.any;
    public void testIsRetryableClusterBlockException() {
            assertPhase(task, "waiting_for_retry");
            );
        final PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
    private void assertPhase(@Nullable ReplicationTask task, Matcher<String> phaseMatcher) {
            ?>) capturedRequest;
        final String index = "test";
        );
            ShardRoutingState.INITIALIZING,
        final long primaryTerm = initialState.metadata().index(shardId.getIndexName()).primaryTerm(shardId.id());
            }
import org.opensearch.indices.IndexClosedException;
            Throwable throwable = execException.getCause();
        };
        assertThat(capturedRequest.action, equalTo("internal:testActionWithExceptions[r]"));
import org.opensearch.OpenSearchException;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(primaryTargetNodeId)).build();
            protected void shardOperationOnPrimary(
    }
                    randomBoolean(),
            transport.handleRemoteError(capturedRequests[0].requestId, randomRetryPrimaryException(shardId));
        assertThat(capturedRequests.size(), equalTo(1));
        AtomicInteger processedOnReplicas = new AtomicInteger();
            "test",
    }
            String actionName,
            clusterService,
            assertPhase(task, "finished");
        // simulate execution of the node holding the replica
            protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
                return null;
 *
    @SuppressWarnings("unchecked")
import static org.mockito.Mockito.anyInt;
            new TransportReplicationAction.ConcreteShardRequest<>(request, primaryShard.allocationId().getId(), primaryTerm);
    }
        }
                ClusterBlockException.class
            super(in);
        ReplicationOperation.Replicas<Request> proxy = action.newReplicasProxy();
        } else {
     * half the time.
                    if (throwException) {
        final ShardId shardId = new ShardId(index, "_na_", 0);
     */
            ReplicationTask task = maybeTask();
            assertThat(capturedRequests.get(0).action, equalTo("internal:testAction[p]"));
     * before the relocation target, there is a time span where relocation source believes active primary to be on
            setShardInfo(new ShardInfo());
        } catch (ExecutionException execException) {
            ShardRoutingState.STARTED,
    }
            }
 * this work for additional information regarding copyright
        assertPhase(task, "failed");
            // we always try at least one more time on timeout
        super.setUp();
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
        }
        }
        ShardRoutingState routingState = randomFrom(
            long term = (Long) invocation.getArguments()[0];
        }
    /* *
        public String toString() {
            .get(primaryNodeId);
        final long maxSeqNoOfUpdates = randomNonNegativeLong();
     * TransportReplicationAction. Since TransportReplicationAction has to work
    public void tearDown() throws Exception {
            new NoneCircuitBreakerService(),
        final ReplicationTask task = maybeTask();
                Request::new,
            assertThat(requests.size(), equalTo(1));
        // no replicas in oder to skip the replication part
            shardStateAction,
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        } else if (randomBoolean()) {
        final AtomicBoolean executed = new AtomicBoolean();
        final TransportReplicationAction.AsyncPrimaryAction asyncPrimaryActionWithBlocks = actionWithBlocks.new AsyncPrimaryAction(
            ((TransportReplicationAction.ConcreteShardRequest<Request>) requestsToReplicas[0].request).getPrimaryTerm(),
        );
            createTransportChannel(listener),
                assertFalse(executed.getAndSet(true));
        assertPhase(task, "finished");
            assertThat(((ClusterBlockException) exception.unwrapCause()).blocks().iterator().next(), is(nonRetryableBlock));
                randomNonNegativeLong()
            fail("using a wrong aid didn't fail the operation");
import java.util.concurrent.atomic.AtomicBoolean;
        try {
import org.opensearch.cluster.block.ClusterBlockException;
                "NOT THERE",
    @BeforeClass
 * license agreements. See the NOTICE file distributed with
            transportService,
            this(settings, actionName, transportService, clusterService, shardStateAction, threadPool, mockIndicesService(clusterService));
                }
            primary.close();
        assertTrue(request.isRetrySet.get());
        listener = new PlainActionFuture<>();
        final String indexName = "test";
                threadPool
                    assertPhase(task, "replica");
    private final AtomicBoolean isRelocated = new AtomicBoolean(false);
                    ClusterBlockLevel.ALL
        TestAction.PrimaryShardReference primary = action.new PrimaryShardReference(shard, releasable);
        if (primaryShard.relocating() && randomBoolean()) {
        transportService.start();
        reroutePhase.run();
        }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS;
            if (shard > indexMetadata.getNumberOfShards()) {
        int i = randomInt(2);
/*
        reroutePhase.run();
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
        setState(
            @Override
            primaryTerm,
        AtomicBoolean success = new AtomicBoolean();
            assertThat(listener.isDone(), equalTo(false));
        TestAction(
        ReplicationTask task = maybeTask();
    }
     * This will throw a {@link ClassCastException} if the request is of the wrong type.
        final boolean retryable = randomBoolean();
        final ShardRouting routingEntry = clusterService.state().getRoutingTable().index("test").shard(0).primaryShard();
        setState(clusterService, state);
        final TestAction action = new TestAction(
                    assertIndexShardCounter(1);
        String primaryTargetNodeId = primaryShard.relocatingNodeId();
        }
        assertFalse(request.isRetrySet.get());
        final String index = "test";
                )
                    String.format(Locale.ROOT, "%s operation term [%d] is too old (current [%d])", shardId, term, primaryTerm)
import org.opensearch.index.IndexNotFoundException;
        );
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    private final AtomicInteger count = new AtomicInteger(0);
 * Modifications Copyright OpenSearch Contributors. See
        action.handleReplicaRequest(
        @Override
                    randomIntBetween(1, 16),
 * KIND, either express or implied.  See the License for the
                shardStateAction,
        assertThat(capturedRequests.get(0).action, equalTo("internal:testAction[p]"));
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
                primaryTerm,
import org.opensearch.cluster.routing.RoutingNode;
            // keep things simple
import static org.mockito.Mockito.verify;
            assertListenerThrows("should fail with an IndexNotFoundException when no blocks", listener, IndexNotFoundException.class);
        assertThat(capturedRequests.get(0).action, equalTo("internal:testAction[p]"));
        ClusterState state = state(index, false, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        final ReplicationTask task = maybeTask();
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
        // A replication action doesn't not fail the request
            "internal:testActionWithBlocks",
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
            );
        Request request = new Request(shardId).timeout("1ms");
        TestAction action = new TestAction(
    */
 * SPDX-License-Identifier: Apache-2.0
    }
        transport = new CapturingTransport();
            assertThat(capturedRequests, arrayWithSize(1));
                "primary phase should fail operation when moving from a retryable " + "block to a non-retryable one",
        final String targetAllocationID = clusterState.getRoutingTable().shardRoutingTable(shardId).primaryShard().allocationId().getId();
import org.opensearch.cluster.action.shard.ShardStateAction;
            }
    }
        ReplicationTask task = maybeTask();
            assertThat(
            setStateWithBlock(clusterService, nonRetryableBlock, globalBlock);
        );
        ReplicationTask task = maybeTask();
 */
        setState(clusterService, state);
        ClusterState updatedState = OpenSearchAllocationTestCase.startShardsAndReroute(allocationService, state, relocationTarget);
            clusterService,
        final long primaryTerm = state.metadata().index(shardId.getIndexName()).primaryTerm(shardId.id());
                assertThat(cause, instanceOf(OpenSearchException.class));
import org.opensearch.cluster.ClusterState;
            RestStatus.SERVICE_UNAVAILABLE,
            threadPool
    @AfterClass
        // no replica, we only want to test on primary
                    RestStatus.BAD_REQUEST,
        };
        Set<String> trackedAllocationIds = shardRoutingTable.getAllAllocationIds();
import org.opensearch.index.shard.IndexShardState;
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(count::decrementAndGet);
        request = new Request(shardId);
        final String index = "test";
import static org.opensearch.test.ClusterServiceUtils.setState;
                IndexShard primary,
        TestAction(
    }
    }
        logger.debug("--> relocation complete state:\n{}", clusterService.state());
        isPrimaryMode.set(false);
        setState(clusterService, stateWithNodes);
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
    }
     * This test checks that replication request is not routed back from relocation target to relocation source in case of
                            + requestTerm
import org.opensearch.core.rest.RestStatus;
    }
            @Override
    private IndexShard mockIndexShard(ShardId shardId, ClusterService clusterService, boolean remote) {
import java.util.HashSet;
            assertTrue(listener.isDone());
            capturedRequests = transport.getCapturedRequestsAndClear();
            assertListenerThrows("listener should reflect remote error", listener, TransportException.class);
        } else {
        }).when(indexShard).acquirePrimaryOperationPermit(any(ActionListener.class), anyString(), any(), eq(forceExecute));
        final List<CapturingTransport.CapturedRequest> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear()
            ? singleton(routingEntry.allocationId().getId())
    @SuppressWarnings("unchecked")
        if (listener.isDone()) {
import org.opensearch.cluster.node.DiscoveryNodes;
            Settings.EMPTY,
            listener.get();
            Settings.EMPTY,
        final long requestTerm = wrongAllocationId && randomBoolean() ? primaryTerm : primaryTerm + randomIntBetween(1, 10);
        assertListenerThrows("non existent node should throw a NoNodeAvailableException", listener, NoNodeAvailableException.class);
import org.opensearch.common.network.NetworkService;
        setState(clusterService, state);
        }
 * GitHub history for details.
            request.timeout("1h");
            executeOnPrimary = false;
            assertListenerThrows("must throw index not found exception", listener, OpenSearchException.class);
import org.junit.After;
            logger.debug("got exception:", throwable);
                    super.shardOperationOnPrimary(request, primary, listener);
import org.opensearch.transport.nio.MockNioTransport;
        final ShardRouting replica = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
            boolean executedBefore = shardRequest.processedOnPrimary.getAndSet(true);
        Request request = new Request(shardId).waitForActiveShards(ActiveShardCount.DEFAULT); // set to default so index settings are used
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    randomNonNegativeLong()
        action.handlePrimaryRequest(concreteShardRequest, createTransportChannel(listener), null);
            listener.get();
            }
     * Transport channel that is needed for replica operation testing.
        when(shard.isRelocatedPrimary()).thenReturn(false);
                "primary request was not delegated to relocation target",
    private static ThreadPool threadPool;
        });
        assertPhase(task, "waiting_on_primary");
            .build();
        // no retry yet
     * requests being sent back and forth.
        reroutePhase = action.new ReroutePhase(null, request, listener);
        // release the waiting
        setState(clusterService, state);
            }
        final ShardId shardId = new ShardId(index, "_na_", 0);
        ReplicationTask task = maybeTask();
            assertTrue(listener.isDone());
                        "expected allocation id ["
import org.opensearch.transport.TransportRequest;
                assertThat(
        setState(clusterService, clusterState);
import static org.mockito.Mockito.doThrow;
            count.incrementAndGet();
        // simulate execution of the primary phase on the relocation target node
        assertPhase(task, "finished");
                listener,
        final String index = "index";
 *    http://www.apache.org/licenses/LICENSE-2.0
    private void assertPhase(@Nullable ReplicationTask task, String phase) {
            randomNonNegativeLong(),
            transport.handleRemoteError(captures[0].requestId, new OpenSearchException("simulated"));
        super.tearDown();
            true,
            ClusterBlockException exception = assertListenerThrows(
            .put(SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), Integer.toString(idxSettingWaitForActiveShards))
                    ClusterBlockLevel.READ_WRITE
            assertThat(capturedRequests[0].action, equalTo("internal:testAction[p]"));
        final ExecutionException exception = expectThrows(ExecutionException.class, listener::get);
            );
        assertIndexShardCounter(0);
        return mockIndexShard(shardId, clusterService, false);
import org.opensearch.cluster.routing.ShardRoutingState;
        assertTrue("action should have been successfully called on retry but was not", calledSuccessfully.get());
            ),
            assertThat(capturedRequests.get(0).action, equalTo("internal:testAction"));
        setState(clusterService, state);
            shardStateAction,
    @After
                Throwable cause = e.getCause();
        assertThat(capturedRequests, notNullValue());
        final ExecutionException e = expectThrows(ExecutionException.class, listener::get);
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        Request request = new Request(shardId);
            return "Request{}";
import org.opensearch.index.shard.IndexShard;
            listener
        assertThat(capturedRequest.request, instanceOf(TransportReplicationAction.ConcreteReplicaRequest.class));
 * You may obtain a copy of the License at
            assertPhase(task, "failed");
        final boolean globalBlock = randomBoolean();
                    RestStatus.FORBIDDEN,
        assertThat(captures, arrayWithSize(1));
        final TransportReplicationAction.ConcreteShardRequest<?> concreteShardRequest = (TransportReplicationAction.ConcreteShardRequest<
            super.writeTo(out);
        {
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
            .get(replica.currentNodeId());
        assertTrue(request.isRetrySet.get());
        when(shard.getPendingPrimaryTerm()).thenReturn(primaryTerm);
    private void assertIndexShardCounter(int expected) {
    }
import static org.mockito.Mockito.eq;
        );
        final List<CapturingTransport.CapturedRequest> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear()
     * and returns the underlying request if it's wrapped or the original (cast to the expected type).
    /**
                request,
                    "test index block",
            equalTo(checkpoint)
import java.util.Set;
            }
            assertFalse(request.isRetrySet.get());
            EnumSet.of(randomFrom(ClusterBlockLevel.values()))
            assertFalse("primary phase should wait on retryable block", listener.isDone());
            shardStateAction,
        assertThat(
        final long primaryTerm = state.metadata().index(index).primaryTerm(0);
import org.opensearch.Version;
import static org.mockito.Mockito.mock;
    }
        final String index = "test";
        @Override
        final PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
        assertListenerThrows("cluster state too old didn't cause a timeout", listener, UnavailableShardsException.class);
        final ClusterState state = state(index, true, ShardRoutingState.RELOCATING);
            new TransportReplicationAction.ConcreteShardRequest<>(request, targetAllocationID, primaryTerm);
import org.opensearch.indices.cluster.ClusterStateChanges;
            protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
        logger.debug("--> using initial state:\n{}", clusterService.state());
        }.new AsyncPrimaryAction(primaryRequest, listener, task).run();
        if (randomBoolean()) {
import java.util.concurrent.atomic.AtomicInteger;
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
            ClusterBlockException exception = assertListenerThrows(
import org.opensearch.common.util.PageCacheRecycler;
            listener.get();
            ActionListener.wrap(r -> success.set(true), failure::set)
        AtomicBoolean isRetrySet = new AtomicBoolean(false);
        @SuppressWarnings("unchecked")
                throw new ShardNotFoundException(shardId);
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder();
        final String primaryNodeId = shardRoutingTable.primaryShard().currentNodeId();
        new TestAction(Settings.EMPTY, "internal:testAction2", transportService, clusterService, shardStateAction, threadPool) {
                    if (throwException.get()) {
            Settings.EMPTY,
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[3];
     * stale index routing table on relocation target.
                request,
            assertTrue(throwable.getClass() + " is not a retry exception", action.retryPrimaryException(throwable));
import org.opensearch.core.index.shard.ShardId;
        final ShardRouting primaryShard = state.getRoutingTable().shardRoutingTable(shardId).primaryShard();
                IndexShard primary,
            fail("listener shouldn't be done");
        final String index = "test";
                    randomNonNegativeLong(),
        assertIndexShardUninitialized();
                    throwable.getMessage(),
            .nodes(DiscoveryNodes.builder(initialState.nodes()).localNodeId(replica.currentNodeId()))
import org.opensearch.test.OpenSearchTestCase;
            setState(clusterService, clusterService.state());
    /**
        capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear().get(replica.currentNodeId());
        );
        when(indexShard.getActiveOperationsCount()).thenAnswer(i -> count.get());
import java.util.EnumSet;
        final Request request = new Request(shardId);
        listener.actionGet(); // throws no exception
            transportService,
    static class TestResponse extends ReplicationResponse {
            isRetrySet.set(true);
            TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, requestWithTimeout, listener);
            reroutePhase.run();
            PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
/*
            } else {
            null,
            assertThat(task.getPhase(), phaseMatcher);
    public void testNotStartedPrimary() {
        when(indicesService.indexService(any(Index.class))).then(invocation -> {
        }.new AsyncPrimaryAction(primaryRequest, listener, task).run();
            .get(primaryNodeId);
            .get(0);
        }
            count.incrementAndGet();
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.anyLong;
                    throwable.getMessage(),
                wrongAllocationId ? "_not_a_valid_aid_" : primary.allocationId().getId(),
        when(indexService.getShard(anyInt())).then(invocation -> {
    private ShardStateAction shardStateAction;
        Request(@Nullable ShardId shardId) {
            Settings.EMPTY,
        reroutePhase.run();
            new TransportReplicationAction.ConcreteShardRequest<>(
            ShardStateAction shardStateAction,
import org.opensearch.index.IndexService;
import java.util.Collections;
                callback.onResponse(count::decrementAndGet);
        ) {
    /**
            if (throwExceptionOnRun || respondWithError) {
    private final AtomicBoolean isPrimaryMode = new AtomicBoolean(true);
        if (requestOrWrappedRequest instanceof TransportReplicationAction.ConcreteShardRequest) {
            "test",
import org.junit.Before;
     */
    }
            }
    }
            Settings.EMPTY,
                ThreadPool.Names.SAME,
        int idxSettingWaitForActiveShards = randomIntBetween(0, numReplicas + 1);
        @Override
        task = maybeTask();
        logger.debug("--> using initial state:\n{}", clusterService.state());
import org.opensearch.action.support.PlainActionFuture;
            shardStateAction,
        assertPhase(task, equalTo(phase));
        final IndexShard shard = mockIndexShard(shardId, clusterService);
                throw e;
        Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())
            ReplicationTask task = maybeTask();
                    }
        when(indexShard.indexSettings()).thenReturn(RemoteStoreTestsHelper.createIndexSettings(remote));
            @Override
        return cause;
import org.opensearch.cluster.block.ClusterBlock;
        final ReplicationTask task = maybeTask();
            );
        );
            // noinspection unchecked
        try {
            } else {
        assertIndexShardCounter(0);
            Settings settings,
            new OpenSearchException("simulated"),
            Request shardRequest,
            TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
            transportService,
        IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().shardRoutingTable(shardId);
            if (isPrimaryMode.get()) {
                throw new AssertionError("thrown exception is not retriable", throwable);
        ) {
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
        when(indexShard.state()).thenReturn(IndexShardState.STARTED);
        if (executeOnPrimary) {
            blocks.addIndexBlock("index", block);
                            + primaryTerm
                return globalBlock == false ? ClusterBlockLevel.WRITE : null;
            clusterService,
import org.opensearch.action.support.ActiveShardCount;
    private CapturingTransport transport;
            final ClusterState state = clusterService.state();
            assertTrue(executed.get());
import java.util.concurrent.TimeUnit;
        final Request request = new Request(shardId);
 * specific language governing permissions and limitations
        assertThat(capturedRequests.size(), equalTo(1));
            .getRoutingTable()
import org.opensearch.index.shard.ReplicationGroup;
            clusterStateChanges.closeIndices(
            final ClusterState state = clusterService.state();
        state = ClusterState.builder(state).metadata(metadataBuilder).build();
 *
        final IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().index(index).shard(shardId.id());
        ShardRouting primaryShard = state.getRoutingTable().shardRoutingTable(shardId).primaryShard();
            public ClusterBlockLevel indexBlockLevel() {
        assertThat(capturedRequests, notNullValue());
 * Licensed to Elasticsearch under one or more contributor
     * <p>
            final IndexMetadata indexSafe = state.metadata().getIndexSafe(index);
        when(indicesService.indexServiceSafe(any(Index.class))).then(invocation -> {
            ReplicationTask task = maybeTask();
                settings,
            ),
        final IndexService indexService = mock(IndexService.class);
            IndexShard primary,
        final ClusterBlock nonRetryableBlock = new ClusterBlock(
            randomBoolean(),
            NoopTracer.INSTANCE
            threadPool
            false,
                    randomBoolean(),
            threadPool
        final String index = "test";
        try {
        assertThat(e.getCause(), instanceOf(ReplicationOperation.RetryOnPrimaryException.class));
        List<CapturingTransport.CapturedRequest> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear()
import org.opensearch.threadpool.TestThreadPool;
        Request request = new Request(shardId).timeout("1ms");
        Request request = new Request(shardId).timeout("1ms");
            listener.get();
        setState(clusterService, state);
            NoopTracer.INSTANCE
        assertFalse(executed.get());
                    throw new OpenSearchException("simulated exception, during shardOperationOnPrimary");
        request = new Request(shardId).routedBasedOnClusterVersion(clusterService.state().version() + 1);
                listener,
    }
            "internal:testActionWithExceptions",
        assertThat(request.shardId(), equalTo(shardId));
            threadPool,
        ) {
    public void setUp() throws Exception {
            "internal:testActionWithExceptions",
            setStateWithBlock(clusterService, retryableBlock, globalBlock);
                    randomBoolean(),
            assertTrue(listener.isDone());
            setStateWithBlock(clusterService, nonRetryableBlock, globalBlock);
        final CapturingTransport.CapturedRequest capturedRequest = capturedRequests.get(0);
            threadPool,
        final ClusterState state = state(index, true, ShardRoutingState.STARTED);
            transportService,
    public void testSeqNoIsSetOnPrimary() {
                            + "] with term ["
            }
import static org.hamcrest.Matchers.instanceOf;
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
                assertIndexShardCounter(1);
            ) {
import org.opensearch.cluster.block.ClusterBlockLevel;
            verify(shard).failShard("test", exception);
                });
            assert executedBefore == false : "request has already been executed on the primary";
            assertListenerThrows("listener should reflect remote error", listener, OpenSearchException.class);
        final IndicesService indicesService = mock(IndicesService.class);
        TestResponse() {
            randomNonNegativeLong(),
        return indexShard;
    public void testRoutePhaseExecutesRequest() {
            );
            return null;
            new TransportReplicationAction.ConcreteShardRequest<>(request, routingEntry.allocationId().getId(), primaryTerm);
        }
        String relocationTargetNode = state.getRoutingTable().shardRoutingTable(shardId).primaryShard().relocatingNodeId();
        state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(replica.currentNodeId())).build();
        ClusterStateChanges clusterStateChanges = new ClusterStateChanges(xContentRegistry(), threadPool);
        Request request = new Request(shardId);
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
     * Sometimes build a ReplicationTask for tracking the phase of the
        final ShardId shardId = new ShardId("test", "_na_", 0);
        transportService = transport.createTransportService(
     * causes a retry
            new ShardNotFoundException(shardId),
        TransportReplicationAction.ConcreteShardRequest<Request> concreteShardRequest =
    * TransportReplicationAction needs an instance of IndexShard to count operations.
        assertThat(concreteShardRequest.getRequest(), equalTo(expectedRequest));
    public void testPrimaryPhaseExecutesOrDelegatesRequestToRelocationTarget() throws Exception {
        final ShardId shardId = new ShardId("test", "_na_", 0);
        final ClusterState clusterState = clusterService.state();
        logger.debug("--> using initial state:\n{}", clusterService.state());
            }
        asyncPrimaryActionWithBlocks.run();
        assertThat(
        }
                });
        final ShardId shardId = new ShardId(indexName, "_na_", 0);
        ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
                ActionListener<PrimaryResult<Request, TestResponse>> listener
        transport.handleRemoteError(capturedRequests[0].requestId, randomRetryPrimaryException(shardId));
                assertThat(cause.getMessage(), containsString("simulated"));
            createTransportChannel(listener),
            "internal:testActionWithExceptions",
    public void testCounterOnPrimary() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;
        transportService.start();
        protected void shardOperationOnReplica(Request request, IndexShard replica, ActionListener<ReplicaResult> listener) {
            assertThat(listener.isDone(), equalTo(false));
        when(shard.getPendingReplicationActions()).thenReturn(replicationActions);
                });
            super(shardId);
        AtomicBoolean executed = new AtomicBoolean();
            maybeTask()
    public void testUnknownIndexOrShardOnReroute() {
        assertFalse(request.isRetrySet.get()); // TODO I'd have expected this to be true but we fail too early?
        // Assert that the request was retried, this time successful
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary("index", true, 0));
                ClusterBlockException.class
                maxSeqNoOfUpdates
                new CloseIndexRequest(index)
                            + "] but found ["
            protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
            if (routing == null) {
            block.addIndexBlock(
            ClusterBlockLevel.ALL
        ReplicationGroup replicationGroup = mock(ReplicationGroup.class);
                    calledSuccessfully.set(true);
        {
        return random().nextBoolean() ? new ReplicationTask(0, null, null, null, null, null) : null;
    * indexShards is reset to null before each test and will be initialized upon request in the tests.
import java.util.concurrent.ExecutionException;
            assertThat(e.getMessage(), containsString("simulated"));
            retryable,
                checkpoint,
                    }
        assertThat(capturedRequests, notNullValue());
        reroutePhase.run();
    /**
        assertThat(count.get(), equalTo(expected));
        assertFalse(action.isRetryableClusterBlockException(randomRetryPrimaryException(new ShardId("index", "_na_", 0))));
    }
        logger.debug("using state: \n{}", clusterService.state());
    }
    public static void beforeClass() {
                Request shardRequest,
                    containsString("expected allocation id [_not_a_valid_aid_] but found [" + primary.allocationId().getId() + "]")
    /** test that a primary request is rejected if it arrives at a shard with a wrong allocation id or term */
        }
            randomBoolean(),
        }
        action.handlePrimaryRequest(
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
                ActionListener.completeWith(listener, () -> {
        new TestAction(Settings.EMPTY, "internal:testAction2", transportService, clusterService, shardStateAction, threadPool) {
            createTransportChannel(listener),
        // simulate execution of the node holding the replica
        throwException.set(false);
            ) {
import org.opensearch.core.transport.TransportResponse;
        Request request = new Request(shardId);
        final ShardId shardId = new ShardId(index, "_na_", 0);
        clusterService.close();
                routingState
            final TransportReplicationAction.ConcreteShardRequest<Request> concreteShardRequest =
import java.util.Locale;
            }
                super.shardOperationOnPrimary(shardRequest, primary, listener);
            reroutePhase.run();
    public void testReplicasCounter() {
    }
import org.opensearch.core.common.io.stream.StreamInput;
            randomFrom(RestStatus.values()),
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[0];
                throw new ShardNotFoundException(shardId, "shard is no longer assigned to current node");
        action.handleReplicaRequest(
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
        when(shard.routingEntry()).thenReturn(routingEntry);
            Settings.EMPTY,
        setState(clusterService, stateWithActivePrimary(index, randomBoolean(), 3));
            assertThat(listener.get(), equalTo(response));
            super(in);
        setState(clusterService, stateWithNodes);
                callback.onFailure(new ShardNotInPrimaryModeException(shardId, IndexShardState.STARTED));
            ((TransportReplicationAction.ConcreteReplicaRequest) capturedRequest.request).getMaxSeqNoOfUpdatesOrDeletes(),
            )
 * Unless required by applicable law or agreed to in writing,
        );
            }
 * under the License.
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        }.new AsyncPrimaryAction(primaryRequest, listener, task).run();
        @Override
                Settings.EMPTY,
                IndexShard primary,
    @Before
        assertThat(clusterService.state().metadata().indices().get(index).getState(), equalTo(IndexMetadata.State.CLOSE));
    }
        assertPhase(task, "failed");
    public void testShardNotInPrimaryMode() {
        ReplicationTask task = maybeTask();
            clusterService,
            int shard = (Integer) invocation.getArguments()[0];
        // whether shard has been marked as relocated already (i.e. relocation completed)
            if (closed.compareAndSet(false, true) == false) {
            "non retryable",
            TestShardRouting.newShardRouting(
                false,
            requestOrWrappedRequest = ((TransportReplicationAction.ConcreteShardRequest<?>) requestOrWrappedRequest).getRequest();
            protected ClusterBlockLevel globalBlockLevel() {
        reroutePhase.run();
        }
            ) {
    public void testPrimaryActionRejectsWrongAidOrWrongTerm() throws Exception {
import static org.mockito.Mockito.anyString;
                Request shardRequest,
        final List<CapturingTransport.CapturedRequest> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear()
                routingState == ShardRoutingState.RELOCATING ? state.nodes().iterator().next().getId() : null,
            @Override
        reroutePhase = action.new ReroutePhase(task, request, listener);
            request.processedOnReplicas.incrementAndGet();
            "internal:testSeqNoIsSetOnPrimary",
     * If the task is non-null this asserts that the phrase matches.
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
import org.opensearch.action.UnavailableShardsException;
            Settings.EMPTY,
     * takes a request that was sent by a {@link TransportReplicationAction} and captured
        when(indexShard.shardId()).thenReturn(shardId);
                ClusterBlockException.class
            return new TestResponse(in);
                shardStateAction,
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
        final ShardRouting replica = initialState.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
            PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        final String index = "test";
        assertThat(e.getCause().getCause(), hasToString(containsString("shard is not in primary mode")));
            protected void shardOperationOnPrimary(
    }
                requestTerm
            threadPool
        final Request request = new Request(shardId);
        assertThat(capturedRequests.size(), equalTo(1));
            transport,
        return (R) requestOrWrappedRequest;
    private IndicesService mockIndicesService(ClusterService clusterService) {
        final ShardId shardId = new ShardId(index, "_na_", 0);
        {
        assertEquals(0, shardFailedRequests.length);
            @Override
            "internal:actionWithBlocks",
        assertPhase(task, "waiting_for_retry");
        final boolean throwExceptionOnRun = i == 1;
            Index index = (Index) invocation.getArguments()[0];
        );
    public void assertIndexShardUninitialized() {
    private class TestAction extends TransportReplicationAction<Request, Request, TestResponse> {
        when(indexShard.isRelocatedPrimary()).thenAnswer(invocationOnMock -> isRelocated.get());
 * compatible open source license.
        final String index = "test";
                assertFalse(executed.getAndSet(true));
        logger.debug("--> primary assigned state:\n{}", clusterService.state());
        setState(clusterService, state(index, true, randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.UNASSIGNED));
            listener.onResponse(new ReplicaResult());
        final String index = "test";
    }
            }
        // try again with a request that is based on a newer cluster state, make sure we waited until that
            primary.failShard("test", exception);
        }
    public void testNoRerouteOnStaleClusterState() {
                clusterService,
        assertEquals(retryable, action.isRetryableClusterBlockException(new ClusterBlockException(singleton(randomBlock))));
                shardId,
        assertPhase(task, "failed");
        TestAction action = new TestAction(
                indicesService,
     * This test ensures that replication operations adhere to the {@link IndexMetadata#SETTING_WAIT_FOR_ACTIVE_SHARDS} setting
        {
            );
        );
        // simulate execution of the node holding the replica
            block.addGlobalBlock(
        final ShardRouting primaryShard = state.getRoutingTable().shardRoutingTable(shardId).primaryShard();
    }
                forceExecute
                } else {
                    listener.onFailure(new OpenSearchException("simulated exception, as a response"));
            threadPool
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        assertThat(requestsToReplicas, arrayWithSize(1));
        }
        replicationActions.accept(replicationGroup);
        new TestAction(Settings.EMPTY, "internal:test-action", transportService, clusterService, shardStateAction, threadPool) {
            final List<CapturingTransport.CapturedRequest> requests = transport.capturedRequestsByTargetNode()
import static org.hamcrest.Matchers.notNullValue;
            shardStateAction,
                Request shardRequest,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            new TransportReplicationAction.ConcreteReplicaRequest<>(
        // noinspection unchecked
            clusterService,
        @Override
            String actionName,
import org.opensearch.test.transport.CapturingTransport;
                (TransportReplicationAction.ConcreteShardRequest<Request>) requests.get(0).request;
        assertThat(((Request) concreteShardRequest.getRequest()).isRetrySet.get(), equalTo(true));
                "failed to timeout on retryable block",
        });
        return indicesService;
        // operation should have finished and counter decreased because no outstanding replica requests
                request,
    private TestAction action;
        Request request = new Request(shardId).timeout("1ms").routedBasedOnClusterVersion(clusterService.state().version() + 1);
        AtomicBoolean closed = new AtomicBoolean();
        request = new Request(new ShardId(index, "_na_", 10)).timeout("1ms");
            );
            ClusterService clusterService,
        final Request request = new Request(NO_SHARD_ID);
        // release the waiting
            if (action.retryPrimaryException(throwable) == false) {
        AtomicBoolean throwException = new AtomicBoolean(true);
        final long primaryTerm = clusterService.state().metadata().index(shardId.getIndexName()).primaryTerm(shardId.id());
import org.opensearch.common.lease.Releasable;
 */
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(null, request, listener);
                new ClusterBlock(
        assertFalse("unassigned primary didn't cause a retry", listener.isDone());
            .metadata(metadata)
        // no replicas in oder to skip the replication part
        return new TestTransportChannel(listener);
        AtomicBoolean calledSuccessfully = new AtomicBoolean(false);
                    )
            1,
            protected ClusterBlockLevel globalBlockLevel() {
                primaryTerm,
        assertThat(capturedRequests, arrayWithSize(1));
        );
        });
                            + "]"
                        throw new OpenSearchException("simulated");
            assertTrue(throwException);
            action.handleReplicaRequest(
        }
            .get(primaryNodeId);
        }
            super(
            clusterService,
        final IndexShard indexShard = mock(IndexShard.class);
        final IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().index(index).shard(shardId.id());
            assertTrue(requestWithTimeout.isRetrySet.get());
            final ClusterState state = clusterService.state();
            @Override
            ThreadPool threadPool
        setState(clusterService, updatedState);
        assertFalse(request.isRetrySet.get());
                "internal:testActionWithNoBlocks",
        CapturingTransport.CapturedRequest[] shardFailedRequests = transport.getCapturedRequestsAndClear();
            shardStateAction,
        setState(clusterService, state);
        })), Assert::assertNotNull, null, null);
        );
package org.opensearch.action.support.replication;
                assertThat(
                clusterStateChanges.createIndex(clusterService.state(), new CreateIndexRequest(index)),
import org.opensearch.cluster.routing.ShardRouting;
        final Transport transport = new MockNioTransport(
            Settings.EMPTY,
import java.io.IOException;
    private ReplicationTask maybeTask() {
    public static class Request extends ReplicationRequest<Request> {
        logger.debug("--> using initial state:\n{}", clusterService.state());
            state(index, true, ShardRoutingState.STARTED, randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED))
import static org.hamcrest.Matchers.nullValue;
    /** test that a replica request is rejected if it arrives at a shard with a wrong allocation id */
        assertThat(exception.getCause(), hasToString(containsString("test " + (globalBlock ? "global" : "index") + " block")));
            : clusterService.state().metadata().index(index).inSyncAllocationIds(0);
        final String primaryNodeId = shardRoutingTable.primaryShard().currentNodeId();
        when(indexService.getShard(shard.shardId().id())).thenReturn(shard);
            shardStateAction,
            new IndexShardClosedException(shardId),
            }
        assertFalse("cluster state too old didn't cause a retry", listener.isDone());
            if (term < primaryTerm) {
            protected void shardOperationOnPrimary(
            new AlreadyClosedException(shardId + " primary is closed"),
        public void writeTo(StreamOutput out) throws IOException {
        }
        if (task != null) {
        CapturingTransport.CapturedRequest[] requestsToReplicas = transport.capturedRequests();
    }
            TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
                if (throwExceptionOnRun) {
            assertFalse(executed.get());
        assertPhase(task, "finished");
import org.opensearch.cluster.service.ClusterService;
            assertThat(((ClusterBlockException) exception.unwrapCause()).blocks().iterator().next(), is(retryableBlock));
        }
                actionName,
        // no replicas in oder to skip the replication part
            assertPhase(task, "rerouted");
            transportService,
        };
            maybeTask()
                maxSeqNoOfUpdatesOrDeletes
    }
        if (globalBlock) {
            Settings.EMPTY,
    }
    private ClusterService clusterService;
import static org.hamcrest.Matchers.arrayWithSize;
    }
        ReplicationTask task = maybeTask();
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
        assertThat(capturedRequests.size(), equalTo(1));
            new TransportReplicationAction.ConcreteShardRequest<>(request, primaryShard.allocationId().getId(), primaryTerm);
        // test wait_for_active_shards index setting used when the default is set on the request
import org.opensearch.action.support.ActionTestUtils;
            super.onRetry();
/*
                randomNonNegativeLong(),
                fail("expected exception, but none was thrown");
    private void setStateWithBlock(final ClusterService clusterService, final ClusterBlock block, final boolean globalBlock) {
        assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(blocks).build());
    private void assertConcreteShardRequest(TransportRequest capturedRequest, Request expectedRequest, AllocationId expectedAllocationId) {
            Request requestWithTimeout = (globalBlock ? new Request(shardId) : new Request(shardId)).timeout("5ms");
import org.opensearch.cluster.metadata.Metadata;
        assertListenerThrows("must throw index closed exception", listener, IndexClosedException.class);
            }
            clusterService,
        final long primaryTerm = clusterService.state().metadata().index(index).primaryTerm(shardId.id());
        );
            setStateWithBlock(clusterService, retryableBlock, globalBlock);
    }
        // finish relocation
        }
            clusterService,
        TestResponse(StreamInput in) throws IOException {
        setState(clusterService, stateWithActivePrimary(index, true, randomInt(5)));
        );
        );
        assertIndexShardCounter(0);
            }
                );
     * test throwing a {@link org.opensearch.action.support.replication.TransportReplicationAction.RetryOnReplicaException}
            task
            ),
                    new Request(shardId),
        logger.info("--> primary is assigned to [{}], checking request forwarded", primaryNodeId);
            assertPhase(task, "waiting_on_primary");
        reroutePhase.run();
        action = new TestAction(Settings.EMPTY, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
import org.opensearch.action.support.ActionFilters;
        );
        final ReplicationTask task = maybeTask();
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
    }
            ((TransportReplicationAction.ConcreteReplicaRequest) capturedRequest.request).getGlobalCheckpoint(),
            @Override
            ) {
            assertPhase(task, "failed");
            x -> clusterService.localNode(),
            replica,
        ExecutionException exception = expectThrows(ExecutionException.class, msg, listener::get);
                            + primary.allocationId().getId()
            .put(IndexMetadata.builder(indexMetadata).settings(indexSettings).build(), true);
        final String primaryNodeId = shardRoutingTable.primaryShard().currentNodeId();
    }
        };
    public void testDefaultWaitForActiveShardsUsesIndexSetting() {
        final String index = "test";
                IndexShard primary,
            createTransportChannel(listener),
                    }
        final long maxSeqNoOfUpdatesOrDeletes = randomNonNegativeLong();
            callback.onResponse(count::decrementAndGet);
        );
     * <p>
        final ShardId shardId = new ShardId(index, "_na_", 0);
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any(), eq(forceExecute));
        action.resolveRequest(state.metadata().index(indexName), request);
                request,
        Request request = new Request(shardId).timeout("1ms");
    }
            threadPool
            ShardStateAction shardStateAction,
        final String index = "test";
        final IndicesService indicesService = mock(IndicesService.class);
                    randomBoolean(),
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        }
            RestStatus.SERVICE_UNAVAILABLE,
}
    /**
            transport.handleResponse(requests.get(0).requestId, new TestResponse());
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
import static org.hamcrest.core.Is.is;
        };
                listener,
        assertEquals(ActiveShardCount.from(idxSettingWaitForActiveShards), request.waitForActiveShards());
                return globalBlock ? ClusterBlockLevel.WRITE : null;
    public TransportChannel createTransportChannel(final PlainActionFuture<TransportResponse> listener) {
        boolean timeout = randomBoolean();
        ) {
                transportService,
            new TransportReplicationAction.ConcreteShardRequest<>(request, primaryShard.allocationId().getId(), primaryTerm);
            TestAction testActionWithNoBlocks = new TestAction(
            new ReplicationOperation.RetryOnPrimaryException(shardId, "hello")
        protected void shardOperationOnPrimary(
            assertThat(((ClusterBlockException) exception.unwrapCause()).blocks().iterator().next(), is(nonRetryableBlock));
