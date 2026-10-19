    }
import static org.hamcrest.Matchers.equalTo;  
                checkpoint,
            transportService,  
            }  
        ReplicationTask task = maybeTask();  
                ClusterBlockException.class
                randomLong(),
                assertThat(cause.getMessage(), containsString("simulated"));  
        final TestAction action = new TestAction(
        final ClusterState clusterState = clusterService.state();
        assertTrue(listener.isDone());  
                    assertPhase(task, "replica");  
            Settings.EMPTY,  
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();  
        if (timeout) {
        Request request = new Request(shardId).timeout("1ms");
            ),
import org.opensearch.transport.TransportException;
    }  
        );
            assertThat(requests, notNullValue());  
import org.opensearch.index.shard.IndexShardClosedException;  
            this(settings, actionName, transportService, clusterService, shardStateAction, threadPool, mockIndicesService(clusterService));
    private ShardStateAction shardStateAction;  
        assertFalse(request.isRetrySet.get()); // TODO I'd have expected this to be true but we fail too early?  
        when(indexShard.state()).thenReturn(IndexShardState.STARTED);  
        state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(relocationTargetNode)).build();
            threadPool,  
        assertTrue(request.isRetrySet.get());
        assertThat(capturedRequests.size(), equalTo(1));  
            } else {  
import org.opensearch.cluster.metadata.IndexMetadata;
            PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
                "NOT THERE",
            transportService,  
        );
        when(indicesService.indexServiceSafe(any(Index.class))).then(invocation -> {
            new TransportReplicationAction.ConcreteReplicaRequest<>(  
            int shard = (Integer) invocation.getArguments()[0];
            clusterService,  
        final boolean retryable = randomBoolean();
                    assertPhase(task, "replica");
                    assertIndexShardCounter(1);
import org.junit.AfterClass;  
            shardStateAction,
        TestAction action = new TestAction(  
        @Override  
    private boolean forceExecute;
        }
            Request request = new Request(shardId);
            Settings.EMPTY,
        assertThat(
        assertListenerThrows("must throw index closed exception", listener, IndexClosedException.class);  
            threadPool  
            assertPhase(task, "failed");
    }  
import org.opensearch.index.remote.RemoteStoreTestsHelper;
        reroutePhase.run();
            )  
                count.incrementAndGet();
        setState(clusterService, state);
            assertTrue(listener.isDone());  
        assertThat(count.get(), equalTo(expected));
                clusterService,  
            ReplicationTask task = maybeTask();  
    @AfterClass
            public ClusterBlockLevel indexBlockLevel() {
        assertListenerThrows("must throw index not found exception", listener, IndexNotFoundException.class);
        }
            1,
                Settings.EMPTY,
            clusterService,  
        final ClusterState state = state(index, true, ShardRoutingState.STARTED);  
        IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().shardRoutingTable(shardId);  
        assertFalse("cluster state too old didn't cause a retry", listener.isDone());
                    if (throwException.get()) {  
                } else if (respondWithError) {  
            String actionName,
        AllocationService allocationService = OpenSearchAllocationTestCase.createAllocationService();
                "primary phase should fail operation when moving from a retryable " + "block to a non-retryable one",
        final Request request = new Request(shardId);
            super.writeTo(out);  
        assertPhase(task, "failed");  
        final TransportReplicationAction.AsyncPrimaryAction asyncPrimaryActionWithBlocks = actionWithBlocks.new AsyncPrimaryAction(
     * and returns the underlying request if it's wrapped or the original (cast to the expected type).
                replica.allocationId().getId(),  
            new ReplicationOperation.RetryOnPrimaryException(shardId, "hello")  
                if (throwExceptionOnRun) {
            assertThat(listener.isDone(), equalTo(false));  
        );  
            Settings.EMPTY,  
                return globalBlock ? ClusterBlockLevel.WRITE : null;
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
            task  
     * requests being sent back and forth.  
        reroutePhase = action.new ReroutePhase(null, request, listener);  
            equalTo(maxSeqNoOfUpdatesOrDeletes)  
                ActionListener<PrimaryResult<Request, TestResponse>> listener
        final String index = "test";
                });
            threadPool,  
        AtomicBoolean processedOnPrimary = new AtomicBoolean();
        ShardRouting relocationTarget = clusterService.state()
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);  
        final PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();  
        assertPhase(task, "failed");
            "internal:testSeqNoIsSetOnPrimary",
    * indexShards is reset to null before each test and will be initialized upon request in the tests.
    }
            threadPool  
            setStateWithBlock(clusterService, nonRetryableBlock, globalBlock);
import org.opensearch.transport.TransportChannel;
                            + primary.allocationId().getId()
        action.resolveRequest(state.metadata().index(indexName), request);  
                    replicaRouting.allocationId().getId(),  
                shardStateAction,  
        Request request = new Request(shardId).timeout("1ms");
        // finish relocation
            final ShardId shardId = new ShardId(indexMetadata.getIndex(), shard);  
        ) {  
    }  
            } else {
import org.opensearch.test.transport.MockTransportService;
            );  
            createTransportChannel(listener),
        final IndexShardRoutingTable shardRoutings = state.routingTable().shardRoutingTable(shardId);
                "internal:testActionWithNoBlocks",  
import org.opensearch.action.admin.indices.create.CreateIndexRequest;  
            clusterService,
        setState(clusterService, state);  
        assertThat(capturedRequests, notNullValue());
            new TransportReplicationAction.ConcreteShardRequest<>(request, primaryShard.allocationId().getId(), primaryTerm);  
            count.incrementAndGet();
            );
        doAnswer(invocation -> {
     */
        action = new TestAction(Settings.EMPTY, "internal:testAction", transportService, clusterService, shardStateAction, threadPool);
import static org.hamcrest.Matchers.hasToString;
        setState(clusterService, state);
            ),  
        Request(@Nullable ShardId shardId) {
            setStateWithBlock(clusterService, nonRetryableBlock, globalBlock);
        assertEquals(ActiveShardCount.from(requestWaitForActiveShards), request.waitForActiveShards());
        assertTrue("action should have been successfully called on retry but was not", calledSuccessfully.get());
                "_not_a_valid_aid_",
    @BeforeClass
                request,
import org.opensearch.cluster.routing.TestShardRouting;  
            Settings.EMPTY,
    public void testDefaultWaitForActiveShardsUsesIndexSetting() {  
                }
                return globalBlock ? ClusterBlockLevel.WRITE : null;  
                ThreadPool.Names.SAME,
                assertIndexShardCounter(1);  
        shard.runUnderPrimaryPermit(() -> primary.perform(request, ActionTestUtils.assertNoFailureListener(r -> {
            if (shard > indexMetadata.getNumberOfShards()) {
            super(
                            + primaryTerm  
            final ShardRouting routing = node.getByShardId(shardId);
                    }
            assertThat("primary term not properly set on primary delegation", concreteShardRequest.getPrimaryTerm(), equalTo(primaryTerm));
     * When relocating a primary shard, there is a cluster state update at the end of relocation where the active primary is switched from
        // test wait_for_active_shards when default not set on the request (request value should be honored over index setting)  
    @SuppressWarnings("unchecked")  
        } else {
        }  
            assertThat(task.getPhase(), phaseMatcher);  
            threadPool,  
        boolean throwException = randomBoolean();  
        // no retry yet  
            }  
        return random().nextBoolean() ? new ReplicationTask(0, null, null, null, null, null) : null;  
            blocks.addIndexBlock("index", block);  
 * this file be licensed under the Apache-2.0 license or a
                    randomIntBetween(1, 16),
            return null;
 *
        return (R) requestOrWrappedRequest;
            ((TransportReplicationAction.ConcreteReplicaRequest) capturedRequest.request).getGlobalCheckpoint(),
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
            return routing;
        final String indexName = "test";
            ShardRoutingState.RELOCATING  
                );
        ) {
            protected ClusterBlockLevel globalBlockLevel() {  
        TestResponse(StreamInput in) throws IOException {
        } catch (ExecutionException execException) {
            assertIndexShardUninitialized();  
import static org.mockito.Mockito.anyLong;
import org.opensearch.cluster.routing.allocation.AllocationService;
        final ClusterBlocks.Builder block = ClusterBlocks.builder();
        @Override
                Request shardRequest,
import org.apache.lucene.store.AlreadyClosedException;
                request,
    private <T> T assertListenerThrows(String msg, PlainActionFuture<?> listener, Class<T> klass) {
            }
    public void testStalePrimaryShardOnReroute() {  
            setStateWithBlock(clusterService, retryableBlock, globalBlock);
        final ShardId shardId = new ShardId(index, "_na_", 0);  
                    randomNonNegativeLong(),
            assertPhase(task, "waiting_on_primary");  
            @Override
        final String index = "test";  
            );
            "test",
            protected void shardOperationOnPrimary(
            }  
        Settings indexSettings = Settings.builder()  
        transportService.start();
                maxSeqNoOfUpdatesOrDeletes
            "test",
    public void testRetryOnReplicaWithRealTransport() throws Exception {
        final IndicesService indicesService = mock(IndicesService.class);  
    private class TestAction extends TransportReplicationAction<Request, Request, TestResponse> {
                    randomBoolean(),
     * This test checks that replication request is not routed back from relocation target to relocation source in case of
                    }
        final ShardId shardId = new ShardId("test", "_na_", 0);
        assertTrue(request.isRetrySet.get());
            @Override
        final ShardId shardId = new ShardId(index, "_na_", 0);  
            ShardRoutingState.INITIALIZING,
            }
            assertListenerThrows("must throw index not found exception", listener, OpenSearchException.class);  
            assertPhase(task, "finished");  
        );
        assertThat(requestsToReplicas, arrayWithSize(1));  
                assertThat(
        assertFalse(request.isRetrySet.get());
            }
        final CapturingTransport.CapturedRequest capturedRequest = capturedRequests.get(0);  
import static org.hamcrest.Matchers.notNullValue;  
            1,
                fail("expected exception, but none was thrown");  
            listener.get();
    /** test that a replica request is rejected if it arrives at a shard with a wrong allocation id */
        AtomicReference<Object> failure = new AtomicReference<>();
        final IndexService indexService = mock(IndexService.class);  
            }
        threadPool = new TestThreadPool("ShardReplicationTests");  
        } else {
            Settings.EMPTY,
            namedWriteableRegistry,  
                new ClusterBlock(  
            request.timeout("0s");  
        ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        );  
                callback.onFailure(new ShardNotInPrimaryModeException(shardId, IndexShardState.STARTED));  
        }  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertIndexShardCounter(0);
            primary.failShard("test", exception);  
import java.util.concurrent.atomic.AtomicReference;
        });  
            ) {
import org.opensearch.transport.TransportRequest;  
    }
        int idxSettingWaitForActiveShards = randomIntBetween(0, numReplicas + 1);  
        try {  
        AtomicBoolean calledSuccessfully = new AtomicBoolean(false);
            assertPhase(task, "waiting_on_primary");
            transport.handleError(captures[0].requestId, new TransportException("simulated"));  
        assertPhase(task, "failed");  
        final Request request = new Request(shardId);
            protected ClusterBlockLevel globalBlockLevel() {
        assertThat(capturedRequests[0].action, equalTo("internal:testAction[p]"));
     * <p>
        final boolean globalBlock = randomBoolean();
import java.util.Set;
                            + "]"
            }
            assertThat(e.getMessage(), containsString("simulated"));  
                indicesService,
        transport.handleRemoteError(capturedRequests[0].requestId, randomRetryPrimaryException(shardId));
    public static <R extends ReplicationRequest> R resolveRequest(TransportRequest requestOrWrappedRequest) {  
            listener.onResponse(new ReplicaResult());
                    throwable.getMessage(),
        ) {
        final AtomicBoolean executed = new AtomicBoolean();
    /**  
        final ShardRouting replica = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_WAIT_FOR_ACTIVE_SHARDS;
                super.shardOperationOnPrimary(shardRequest, primary, listener);
     * the relocation source to the relocation target. If relocation source receives and processes this cluster state  
            new NetworkService(Collections.emptyList()),
            Index index = (Index) invocation.getArguments()[0];  
     */
            protected void shardOperationOnPrimary(
                IndexShard primary,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    throw new OpenSearchException("simulated exception, during shardOperationOnPrimary");
        }
        listener = new PlainActionFuture<>();
     */
        assertFalse(request.isRetrySet.get());  
        final String index = "test";  
        ) {
import org.opensearch.cluster.block.ClusterBlocks;  
            assert executedBefore == false : "request has already been executed on the primary";
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        if (primaryShard.relocating() && randomBoolean()) {
            PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        final Request request = new Request(shardId);  
    public void testSeqNoIsSetOnPrimary() {
        assertThat(  
            fail("listener shouldn't be done");  
        assertFalse("unassigned primary didn't cause a retry", listener.isDone());
        assertThat(capturedRequests, notNullValue());
    }
            transport,  
        TestAction action = new TestAction(
        setState(clusterService, state(index, true, randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.UNASSIGNED));
            TestShardRouting.newShardRouting(  
        }.new AsyncPrimaryAction(primaryRequest, listener, task).run();
        Request request = new Request(shardId).timeout("1ms");  
            setStateWithBlock(clusterService, retryableBlock, globalBlock);  
        capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear().get(replica.currentNodeId());  
        assertPhase(task, "waiting_for_retry");
        Request request = new Request(new ShardId(clusterService.state().metadata().indices().get(index).getIndex(), 0)).timeout("1ms");
            }
import java.util.concurrent.ExecutionException;  
        logger.debug("--> relocation complete state:\n{}", clusterService.state());
        logger.debug("--> using initial state:\n{}", clusterService.state());
import org.junit.After;
            if (isPrimaryMode.get()) {
import org.opensearch.core.index.shard.ShardId;
    }
            return "Request{}";
            return null;
import org.opensearch.common.network.NetworkService;
            assertThat(capturedRequests, arrayWithSize(1));
            : clusterService.state().metadata().index(index).inSyncAllocationIds(0);  
        logger.debug("--> using initial state:\n{}", clusterService.state());  
        );
            primary.close();
                throw new ShardNotFoundException(shardId);
                    throwable.getMessage(),  
        assertThat(capturedRequests, notNullValue());  
import org.opensearch.cluster.routing.RoutingNode;  
    private ClusterService clusterService;
        final boolean wrongAllocationId = randomBoolean();  
            PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        final long primaryTerm = clusterState.metadata().index(index).primaryTerm(shardId.id());  
            assertIndexShardCounter(0);  // it should have been freed.  
    @Override
            final RoutingNode node = state.getRoutingNodes().node(state.nodes().getLocalNodeId());  
        TestAction action = new TestAction(  
        final ShardId shardId = new ShardId(index, "_na_", 0);
                wrongAllocationId ? "_not_a_valid_aid_" : primary.allocationId().getId(),  
import org.opensearch.core.index.Index;  
        reroutePhase.run();
                throw new AssertionError("thrown exception is not retriable", throwable);
            listener.get(); // fail with the exception if there
                ActionListener<PrimaryResult<Request, TestResponse>> listener
        final PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
        final ShardId shardId = new ShardId(index, "_na_", 0);
        PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();  
        action.handlePrimaryRequest(  
        );
        });
        assertThat(capturedRequests, nullValue());  
        reroutePhase.run();
            "internal:actionWithBlocks",
        if (task != null) {
        final ShardRouting primaryShard = state.getRoutingTable().shardRoutingTable(shardId).primaryShard();  
        reroutePhase.run();  
        final String index = "test";  
        final String index = "test";
        }).when(shard).acquirePrimaryOperationPermit(any(), anyString(), any(), eq(forceExecute));  
    }  
            fail("using a wrong aid didn't fail the operation");
        assertPhase(task, "finished");
            } else {
            return mockIndexService(indexSafe, clusterService);  
            reroutePhase.run();  
                task  
 * Unless required by applicable law or agreed to in writing,
 */  
            ?>) capturedRequest;
            new TransportReplicationAction.ConcreteShardRequest<>(request, primaryShard.allocationId().getId(), primaryTerm);
        doAnswer(invocation -> {
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =  
    }  
            }  
                callback.onResponse(count::decrementAndGet);  
                clusterStateChanges.createIndex(clusterService.state(), new CreateIndexRequest(index)),
     * This will throw a {@link ClassCastException} if the request is of the wrong type.
        request = new Request(new ShardId("unknown_index", "_na_", 0)).timeout("1ms");
            if (throwExceptionOnRun || respondWithError) {
        TestAction(
                )
    @SuppressWarnings("unchecked")
        IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().index(index).shard(shardId.id());
    private void assertIndexShardCounter(int expected) {
        boolean executeOnPrimary = true;  
    }
                            + "] with term ["  
                new TransportReplicationAction.ConcreteReplicaRequest<>(
    }
                primaryTerm,  
            new TransportReplicationAction.ConcreteShardRequest<>(
            .shardRoutingTable(shardId)
                requests.get(0).action,
                routingState
        if (clusterService.state().nodes().getLocalNodeId().equals(primaryNodeId)) {
            assertTrue(request.isRetrySet.get());
 *
                    new Request(shardId),
            ) {
        }  
            primaryTerm,  
        setState(clusterService, state(index, true, randomBoolean() ? ShardRoutingState.INITIALIZING : ShardRoutingState.UNASSIGNED));
                    randomBoolean(),
    public void testPrimaryReference() {
    public void testReplicaActionRejectsWrongAid() throws Exception {  
        assertThat(concreteShardRequest.getRequest(), equalTo(expectedRequest));
            x -> clusterService.localNode(),
    }  
import static org.hamcrest.Matchers.arrayWithSize;
        action.handleReplicaRequest(
    public void testIsRetryableClusterBlockException() {
import java.util.List;  
                maxSeqNoOfUpdates  
    }  
        transportService.start();
        transportService.acceptIncomingRequests();
    }  
        }  
        );  
            false,
    }  
            assertThat(listener.get(), equalTo(response));  
        }.new AsyncPrimaryAction(primaryRequest, listener, task).run();  
        // A replication action doesn't not fail the request  
            return null;  
        boolean timeout = randomBoolean();
        logger.info("using state: {}", state);
                return globalBlock == false ? ClusterBlockLevel.WRITE : null;  
import org.opensearch.transport.Transport;  
        }
            shardStateAction,
/*
            clusterService,
        };
            assertTrue(executed.get());
                assertPhase(task, "primary");
        };  
        super.tearDown();
            new TransportReplicationAction.ConcreteReplicaRequest<>(  
            randomNonNegativeLong(),  
        ReplicationOperation.Replicas<Request> proxy = action.newReplicasProxy();
     * relocation target and relocation target believes active primary to be on relocation source. This results in replication
        reroutePhase.run();
        });
            ShardStateAction shardStateAction,
        public String toString() {
                IndexShard primary,  
        };
            ActionListener.wrap(r -> success.set(true), failure::set)  
        assertFalse(request.isRetrySet.get());
            clusterService,
    public void tearDown() throws Exception {  
        final IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().index(index).shard(shardId.id());
        assertThat(executed.get(), equalTo(true));
            clusterService,
            assertThat(capturedRequests[0].action, equalTo("internal:testAction[p]"));  
        return indexService;  
            new TransportReplicationAction.ConcreteShardRequest<>(request, targetAllocationID, primaryTerm);  
        request = new Request(new ShardId(index, "_na_", 10)).timeout("1ms");
                        throw new OpenSearchException("simulated");
 * specific language governing permissions and limitations
        protected void shardOperationOnPrimary(
    }  
        threadPool = null;
        final long primaryTerm = clusterService.state().metadata().index(index).primaryTerm(shardId.id());
import org.opensearch.cluster.ClusterState;  
    }
        // noinspection unchecked
        setState(clusterService, state);  
     * Transport channel that is needed for replica operation testing.
import org.opensearch.Version;  
        assertThat(capturedRequest.request, instanceOf(TransportReplicationAction.ConcreteReplicaRequest.class));
    */
            ? singleton(routingEntry.allocationId().getId())
        Request request = new Request(shardId);  
        Request request = new Request(shardId).waitForActiveShards(ActiveShardCount.DEFAULT); // set to default so index settings are used
    private final AtomicInteger count = new AtomicInteger(0);
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
        final long maxSeqNoOfUpdatesOrDeletes = randomNonNegativeLong();
        } catch (OpenSearchException e) {
        final ShardId shardId = new ShardId(index, "_na_", 0);  
            if (action.retryPrimaryException(throwable) == false) {  
            }
        @SuppressWarnings("unchecked")
            randomIntBetween(1, 16),  
            final TransportReplicationAction.ConcreteShardRequest<Request> concreteShardRequest =
        isPrimaryMode.set(false);  
        setState(clusterService, state);
        ClusterState state = state(index, true, ShardRoutingState.RELOCATING);
    public void testClosedIndexOnReroute() {  
        state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(primaryTargetNodeId)).build();
        final String index = "test";
 * The OpenSearch Contributors require contributions made to  
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();  
    }
import org.opensearch.cluster.block.ClusterBlockLevel;
            "non retryable",
        assertFalse(request.isRetrySet.get());
        assertThat(capturedRequests.get(0).action, equalTo("internal:testAction[p]"));
                    super.shardOperationOnPrimary(request, primary, listener);  
     * before the relocation target, there is a time span where relocation source believes active primary to be on
            true,
    public static void afterClass() {  
            "internal:testActionWithExceptions",
                assertThat(
        TestAction.PrimaryShardReference primary = action.new PrimaryShardReference(shard, releasable);
import org.opensearch.cluster.routing.ShardRouting;
            .put(indexMetadata.getSettings())
        public void writeTo(StreamOutput out) throws IOException {
        when(indexShard.isRelocatedPrimary()).thenAnswer(invocationOnMock -> isRelocated.get());
        transportService = new MockTransportService(
            protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {  
            @Override
            maybeTask()
            shardStateAction,
    public void testReplicasCounter() {
        reroutePhase.run();
    }
            public ClusterBlockLevel indexBlockLevel() {
                replica.allocationId().getId(),
    private IndexService mockIndexService(final IndexMetadata indexMetadata, ClusterService clusterService) {
import org.opensearch.core.transport.TransportResponse;
        request = new Request(shardId).waitForActiveShards(ActiveShardCount.from(requestWaitForActiveShards));
            ClusterBlockException exception = assertListenerThrows(
        reroutePhase.run();
                forceExecute  
        // noinspection unchecked
        assertThat(exception.getCause(), instanceOf(klass));
        return indexShard;  
            ((TransportReplicationAction.ConcreteReplicaRequest) capturedRequest.request).getMaxSeqNoOfUpdatesOrDeletes(),
        final long checkpoint = randomNonNegativeLong();
        // operation should have finished and counter decreased because no outstanding replica requests
        logger.debug("--> using initial state:\n{}", clusterService.state());  
import org.opensearch.cluster.service.ClusterService;
        assertThat(e.getCause().getCause(), instanceOf(ShardNotInPrimaryModeException.class));  
            listener.onResponse(new PrimaryResult<>(shardRequest, new TestResponse()));
                throw new IllegalArgumentException(  
        request = new Request(shardId).routedBasedOnClusterVersion(clusterService.state().version() + 1);  
        // cluster state for the index to appear
            }
            assertListenerThrows("listener should reflect remote error", listener, TransportException.class);
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
                assertFalse(executed.getAndSet(true));
import org.opensearch.index.shard.IndexShardState;
        return mockIndexShard(shardId, clusterService, false);
    }  
     * TransportReplicationAction. Since TransportReplicationAction has to work
        replicationActions.accept(replicationGroup);
        final ClusterState stateWithNodes = ClusterState.builder(initialState)
            callback.onResponse(count::decrementAndGet);
                Request shardRequest,
        when(indicesService.indexService(any(Index.class))).then(invocation -> {
                Request::new,
    }
            ShardRoutingState.STARTED,
            listener.get(); // fail with the exception if there  
            .shardsWithState(ShardRoutingState.INITIALIZING)
import static org.hamcrest.Matchers.instanceOf;
        // simulate execution of the primary phase on the relocation target node  
            "internal:testActionWithBlocks",
                    return new ReplicaResult();
        }
        assertIndexShardUninitialized();  
    }  
        ReplicationGroup replicationGroup = new ReplicationGroup(shardRoutingTable, inSyncIds, trackedAllocationIds, 0);
            @Override
        final IndexService indexService = mock(IndexService.class);  
        final ReplicationTask task = maybeTask();
    }  
            Settings settings,  
        try {
            assertPhase(task, "primary_delegation");
        reroutePhase.run();
import org.opensearch.cluster.routing.AllocationId;
        logger.debug("--> using initial state:\n{}", clusterService.state());  
        final boolean globalBlock = randomBoolean();
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(null, request, listener);
                });
        // simulate execution of the node holding the replica
        }
        ShardRoutingState routingState = randomFrom(  
        Request request = new Request(shardId);
        }
                randomNonNegativeLong(),  
                super.shardOperationOnPrimary(shardRequest, primary, listener);  
                    RestStatus.FORBIDDEN,  
     */
     * Sometimes build a ReplicationTask for tracking the phase of the  
        // no replica, we only want to test on primary
        state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(replica.currentNodeId())).build();
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();  
            final OpenSearchException exception = new OpenSearchException("testing");
            // keep things simple
        AtomicBoolean success = new AtomicBoolean();  
            new IndexShardClosedException(shardId),
            isRetrySet.set(true);  
        setState(clusterService, state);
        setState(clusterService, ClusterStateCreationUtils.stateWithActivePrimary("index", true, 0));  
            .get(replica.currentNodeId());
        ReplicationTask task = maybeTask();
    }
        final IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().index(index).shard(shardId.id());  
        reroutePhase = action.new ReroutePhase(null, request, listener);
        final String primaryNodeId = shardRoutingTable.primaryShard().currentNodeId();
import org.opensearch.common.lease.Releasable;
        ) {  
        assertIndexShardCounter(0);
            @Override
        final long requestTerm = wrongAllocationId && randomBoolean() ? primaryTerm : primaryTerm + randomIntBetween(1, 10);
 * license agreements. See the NOTICE file distributed with
        final long maxSeqNoOfUpdates = randomNonNegativeLong();
            threadPool  
            .get(primaryNodeId);
        ShardId shardId = new ShardId(clusterService.state().metadata().index("index").getIndex(), 0);
            Request requestWithTimeout = new Request(new ShardId("unknown", "_na_", 0)).index("unknown").timeout("5ms");  
        }
import org.opensearch.common.settings.Settings;  
    public void testReplicaProxy() throws InterruptedException, ExecutionException {
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();  
        assertTrue(request.isRetrySet.compareAndSet(true, false));
        // no replicas in order to skip the replication part  
            transport.handleRemoteError(capturedRequests[0].requestId, randomRetryPrimaryException(shardId));
        reroutePhase.run();  
import static org.hamcrest.Matchers.nullValue;
    }
        new TestAction(Settings.EMPTY, "internal:test-action", transportService, clusterService, shardStateAction, threadPool) {
    }
        final TransportReplicationAction.ConcreteShardRequest<?> concreteShardRequest = (TransportReplicationAction.ConcreteShardRequest<  
    * TransportReplicationAction needs an instance of IndexShard to count operations.  
        int i = randomInt(2);
            "internal:testActionWithExceptions",
public class TransportReplicationActionTests extends OpenSearchTestCase {
        setState(clusterService, state);
        );
            TestAction.ReroutePhase reroutePhase = testActionWithNoBlocks.new ReroutePhase(task, requestWithTimeout, listener);  
            ReplicationTask task = maybeTask();  
            assertTrue(throwable.getClass() + " is not a retry exception", action.retryPrimaryException(throwable));  
            setShardInfo(new ShardInfo());  
import java.util.stream.Collectors;
import static org.mockito.Mockito.eq;  
                )
        logger.info("--> primary is assigned to [{}], checking request forwarded", primaryNodeId);
        assertListenerThrows("unassigned primary didn't cause a timeout", listener, UnavailableShardsException.class);
            this.waitForActiveShards = ActiveShardCount.NONE;  
    public TransportChannel createTransportChannel(final PlainActionFuture<TransportResponse> listener) {  
        IndexMetadata indexMetadata = state.metadata().index(indexName);
        if (executeOnPrimary) {
            clusterStateChanges.closeIndices(  
            shardStateAction,
    }
                    if (throwException.get()) {  
        } else {
    private final AtomicBoolean isRelocated = new AtomicBoolean(false);
import java.util.concurrent.atomic.AtomicBoolean;
        ExecutionException exception = expectThrows(ExecutionException.class, msg, listener::get);  
                    randomBoolean(),
                threadPool,
            super(in);
import org.opensearch.test.OpenSearchTestCase;  
            transportService,  
        new TestAction(Settings.EMPTY, "internal:testAction2", transportService, clusterService, shardStateAction, threadPool) {
    }
        when(shard.isRelocatedPrimary()).thenReturn(false);
            block.addIndexBlock(
import org.opensearch.threadpool.ThreadPool;
        proxy.performOn(
            new ShardNotFoundException(shardId),
                randomNonNegativeLong(),
            "retryable",
        final ShardRouting primaryShard = state.routingTable().shardRoutingTable(shardId).primaryShard();  
        Metadata metadata = Metadata.builder().build();
            threadPool
            ((ActionListener<Releasable>) invocation.getArguments()[0]).onResponse(count::decrementAndGet);
        // no replicas in oder to skip the replication part
            );
        );
        when(shard.getActiveOperationsCount()).thenAnswer(i -> count.get());
        final ShardId shardId = new ShardId(index, "_na_", 0);
        setState(clusterService, state(index, true, ShardRoutingState.STARTED));
        try {
        int requestWaitForActiveShards = randomIntBetween(0, numReplicas + 1);
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
            }
        }
        doThrow(new AssertionError("failed shard is not supported")).when(indexShard).failShard(anyString(), any(Exception.class));
                ClusterBlockException.class  
            fail("listener shouldn't be done");
        @Override  
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
        );  
            threadPool  
        } else if (randomBoolean()) {
            transport.handleResponse(captures[0].requestId, response);
                throw new ShardNotFoundException(shardId, "shard is no longer assigned to current node");  
    private CapturingTransport transport;
        final ClusterBlock retryableBlock = new ClusterBlock(  
            reroutePhase.run();  
        assertThat(capturedRequests, arrayWithSize(1));
        assertPhase(task, "waiting_on_primary");  
            transportService,
            randomFrom(RestStatus.values()),
            long term = (Long) invocation.getArguments()[0];
            Request shardRequest,
        return cause;
import static org.mockito.Mockito.doAnswer;
        setState(clusterService, state);
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    public void testPrimaryActionRejectsWrongAidOrWrongTerm() throws Exception {
            Collections.emptySet(),
            protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {  
    /**
            TransportService transportService,  
        }  
        );
        );
            NoopTracer.INSTANCE  
        listener.actionGet(); // throws no exception
import static org.hamcrest.core.Is.is;
        ClusterState state = state(index, false, ShardRoutingState.STARTED, ShardRoutingState.STARTED);  
            ThreadPool threadPool  
        proxy.performOn(replica, new Request(NO_SHARD_ID), primaryTerm, randomNonNegativeLong(), randomNonNegativeLong(), listener);  
        reroutePhase = action.new ReroutePhase(task, request, listener);
            boolean executedBefore = shardRequest.processedOnPrimary.getAndSet(true);  
        );  
            assertThat(throwable.getMessage(), containsString("_not_a_valid_aid_"));  
                        throw new RetryOnReplicaException(shardId, "simulation");
        action.handleReplicaRequest(
        final List<CapturingTransport.CapturedRequest> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear()  
                (TransportReplicationAction.ConcreteShardRequest<Request>) requests.get(0).request;  
import java.util.Collections;  
        setState(clusterService, stateWithActivePrimary(index, true, randomInt(3)));
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);  
        assertThat(clusterService.state().metadata().indices().get(index).getState(), equalTo(IndexMetadata.State.CLOSE));
        };
            .put(SETTING_WAIT_FOR_ACTIVE_SHARDS.getKey(), Integer.toString(idxSettingWaitForActiveShards))
 * Licensed to Elasticsearch under one or more contributor  
        TestAction action = new TestAction(
            if (wrongAllocationId) {
            }
        } else {  
        when(shard.getPendingReplicationActions()).thenReturn(replicationActions);  
            // generate a CS change
                "primary request was not delegated to relocation target",  
import org.opensearch.action.UnavailableShardsException;
import org.opensearch.transport.TransportService;
            ReplicationTask task = maybeTask();
        }
        final boolean throwExceptionOnRun = i == 1;  
    public static class Request extends ReplicationRequest<Request> {
        final IndexShard shard = mock(IndexShard.class);  
    public void testPrimaryPhaseExecutesDelegatedRequestOnRelocationTarget() {
        );  
            .nodes(clusterService.state().nodes())
        return indicesService;
            PageCacheRecycler.NON_RECYCLING_INSTANCE,
import static org.opensearch.test.ClusterServiceUtils.setState;  
import org.opensearch.transport.nio.MockNioTransport;  
        final ExecutionException e = expectThrows(ExecutionException.class, listener::get);  
                IndexShard primary,
import java.util.HashSet;
        final List<CapturingTransport.CapturedRequest> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear()  
 *  
            ),  
import java.util.Locale;
import org.opensearch.core.common.io.stream.StreamInput;
            capturedRequests = transport.getCapturedRequestsAndClear();  
            new NoneCircuitBreakerService(),
            request.processedOnReplicas.incrementAndGet();
            listener
            assertThat(capturedRequests.get(0).action, equalTo("internal:testAction"));
        }
            assertThat(
            shardStateAction,
        }  
            TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
            assertFalse(executed.get());
                new ActionFilters(new HashSet<>()),
 * Modifications Copyright OpenSearch Contributors. See
            requestOrWrappedRequest = ((TransportReplicationAction.ConcreteShardRequest<?>) requestOrWrappedRequest).getRequest();
            new Request(NO_SHARD_ID),
import org.opensearch.common.Nullable;  
            Index index = (Index) invocation.getArguments()[0];  
        new TestAction(Settings.EMPTY, "internal:testAction2", transportService, clusterService, shardStateAction, threadPool) {
        final IndexShard shard = mockIndexShard(shardId, clusterService);
                threadPool
import org.opensearch.transport.client.transport.NoNodeAvailableException;
                transportService,
        final ClusterState state = state(index, true, ShardRoutingState.RELOCATING);  
    private IndexShard mockIndexShard(ShardId shardId, ClusterService clusterService, boolean remote) {  
            assertFalse(request.isRetrySet.get());
            request.timeout("1h");
        setState(clusterService, state);
            transportService,  
            if (routing == null) {
        if (globalBlock) {  
            ThreadPool threadPool,
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        final String index = "test";
            if (throwExceptionOnRun || respondWithError) {  
            TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, requestWithTimeout, listener);
    }
            task
        };
        }.new AsyncPrimaryAction(primaryRequest, listener, task).run();
            listener.get();
    private void assertPhase(@Nullable ReplicationTask task, Matcher<String> phaseMatcher) {
        when(indexService.getShard(shard.shardId().id())).thenReturn(shard);
            shardStateAction,
        final ShardId shardId = new ShardId(index, "_na_", 0);
    }
        Request(StreamInput in) throws IOException {  
            null,
            shardRoutings.replicaShards().stream().filter(ShardRouting::assignedToNode).collect(Collectors.toList())  
                    containsString(  
        } else {
import static org.mockito.Mockito.verify;
        logger.debug("--> using initial state:\n{}", clusterService.state());
            ClusterService clusterService,  
    public void testCounterOnPrimary() throws Exception {
            new TransportReplicationAction.ConcreteShardRequest<>(request, primaryShard.allocationId().getId(), primaryTerm);
 * the Apache License, Version 2.0 (the "License"); you may
            primaryTerm,
            primaryRequest, listener, task
        PendingReplicationActions replicationActions = new PendingReplicationActions(shardId, threadPool);
import org.opensearch.threadpool.TestThreadPool;  
            @Override
        task = maybeTask();
        final ShardId shardId = new ShardId(index, "_na_", 0);
        reroutePhase.run();  
        final String index = "test";  
    public void testBlocksInReroutePhase() {
import org.opensearch.index.IndexNotFoundException;
import org.opensearch.action.admin.indices.close.CloseIndexRequest;
                transportService,
            final ClusterState state = clusterService.state();
                request,
        assertTrue(listener.isDone());
        {
        new TestAction(Settings.EMPTY, "internal:testAction2", transportService, clusterService, shardStateAction, threadPool) {  
    public void testRetryOnReplica() throws Exception {
            threadPool,
        } else {
            logger.debug("got exception:", throwable);
        assertThat(exception.getCause(), instanceOf(ClusterBlockException.class));
        }.new AsyncPrimaryAction(primaryRequest, listener, task).run();  
    public static void beforeClass() {
    private void assertConcreteShardRequest(TransportRequest capturedRequest, Request expectedRequest, AllocationId expectedAllocationId) {
    }  
import java.util.EnumSet;
        assertEquals(0, count.get());
            ClusterBlockException exception = assertListenerThrows(
    private static final ShardId NO_SHARD_ID = null;
        }
                request,
            );  
        final T cause = (T) exception.getCause();  
        } catch (ExecutionException e) {
        final ReplicationTask task = maybeTask();
package org.opensearch.action.support.replication;
        final ShardId shardId = new ShardId(indexName, "_na_", 0);
                false,
import org.junit.BeforeClass;  
        }  
        ClusterState state = stateWithActivePrimary(indexName, randomBoolean(), numReplicas);
    /* *
                requestTerm
    private static ThreadPool threadPool;
        AtomicBoolean executed = new AtomicBoolean();  
                return globalBlock == false ? ClusterBlockLevel.WRITE : null;
     * If the task is non-null this asserts that the phrase matches.
        final long primaryTerm = state.metadata().index(index).primaryTerm(0);
        when(indexShard.routingEntry()).thenAnswer(invocationOnMock -> {
        assertTrue(request.isRetrySet.get());
        setState(clusterService, state(index, true, ShardRoutingState.STARTED));
        final ShardRouting replicaRouting = state.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
            PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();  
        assertFalse(listener.isDone());
                    if (throwException) {
        } catch (ExecutionException execException) {  
        Request request = new Request(new ShardId("unknown_index", "_na_", 0)).timeout("1ms");
            clusterService,  
            assertThat(listener.isDone(), equalTo(false));  
            .nodes(DiscoveryNodes.builder(initialState.nodes()).localNodeId(replica.currentNodeId()))  
        throwException.set(false);  
                    randomNonNegativeLong()  
                            + "] but found ["
                );  
            }  
                new ClusterBlock(
        super.setUp();  
            // we always try at least one more time on timeout
            NoopTracer.INSTANCE
            final ClusterState state = clusterService.state();
        listener = new PlainActionFuture<>();
                Request shardRequest,
            .build();
            ),
        @Override
import java.util.concurrent.TimeUnit;
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();  
                    randomBoolean(),
        final ShardId shardId = new ShardId(index, "_na_", 0);
        // check that at unknown node fails
    }
            assertPhase(task, "failed");
                new CloseIndexRequest(index)
        try {  
        final ReplicationTask task = maybeTask();
            protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {  
        assertThat(request.shardId(), equalTo(shardId));
        transportService = transport.createTransportService(
import java.io.IOException;
            assertTrue(listener.isDone());
    static class TestResponse extends ReplicationResponse {  
            createTransportChannel(listener),
        return new TestTransportChannel(listener);
                shardStateAction,  
        });
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            transport.handleRemoteError(captures[0].requestId, new OpenSearchException("simulated"));
                    return new ReplicaResult();
        }
    private TransportService transportService;  
        }
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
        {
import static org.mockito.Mockito.anyString;  
        final Request request = new Request(NO_SHARD_ID);  
        {
        Request request = new Request(shardId).timeout("1ms");
            TestAction testActionWithNoBlocks = new TestAction(
        final List<CapturingTransport.CapturedRequest> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear()
                    RestStatus.BAD_REQUEST,
        ) {
                listener,
        ClusterState state = stateWithActivePrimary(index, true, 1 + randomInt(3), randomInt(2));
            if (term < primaryTerm) {
        final String targetAllocationID = clusterState.getRoutingTable().shardRoutingTable(shardId).primaryShard().allocationId().getId();
        when(shard.getReplicationGroup()).thenReturn(replicationGroup);  
        final Request request = new Request(shardId);  
        assertPhase(task, "finished");
import org.opensearch.transport.TestTransportChannel;
        assertThat(exception.getCause(), hasToString(containsString("test " + (globalBlock ? "global" : "index") + " block")));
    public void testShardNotInPrimaryMode() {  
     * half the time.  
    /**  
        }
        forceExecute = randomBoolean();
                return null;
            retryable,
            listener.get();
        TestAction(  
        ClusterBlock randomBlock = new ClusterBlock(
        when(indexShard.shardId()).thenReturn(shardId);
            );  
        AtomicBoolean closed = new AtomicBoolean();
            TransportService transportService,
            .getRoutingTable()  
        if (requestOrWrappedRequest instanceof TransportReplicationAction.ConcreteShardRequest) {
import org.junit.Assert;
        );
                Throwable cause = e.getCause();
        // no replicas in oder to skip the replication part
            ShardStateAction shardStateAction,
        );
            true,  
            createTransportChannel(listener),
import org.opensearch.common.util.PageCacheRecycler;
    public void testNotStartedPrimary() {
            );  
        clusterService.close();
import org.opensearch.indices.cluster.ClusterStateChanges;
import org.opensearch.action.support.ActionTestUtils;
        }
        Request request = new Request(shardId);  
                routingState == ShardRoutingState.RELOCATING ? state.nodes().iterator().next().getId() : null,  
            indicesService
            randomBoolean(),  
        assertFalse(request.isRetrySet.get());  
        }
            action.handleReplicaRequest(  
import org.opensearch.index.shard.ReplicationGroup;
        );  
            assertTrue(throwException);
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
            .get(0);  
     * when the request is using the default value for waitForActiveShards.
 * You may obtain a copy of the License at  
            true,
        ReplicationTask task = maybeTask();
        assertThat(((Request) concreteShardRequest.getRequest()).isRetrySet.get(), equalTo(true));  
            @Override  
     * if the task as null just as well as if it is supplied this returns null
        assertTrue(listener.isDone());
        AtomicBoolean executed = new AtomicBoolean();
                        throw new RetryOnReplicaException(shardId, "simulation");
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
            super(in);
        ClusterState updatedState = OpenSearchAllocationTestCase.startShardsAndReroute(allocationService, state, relocationTarget);
        // publish a new state (same as the old state with the version incremented)  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        assertThat(captures, arrayWithSize(1));
            block.addGlobalBlock(
        setState(clusterService, updatedState);
        assertThat(
        request = new Request(shardId);  
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
                Request::new,  
        setState(
                );
        final long primaryTerm = state.metadata().index(shardId.getIndexName()).primaryTerm(shardId.id());  
        protected TestResponse newResponseInstance(StreamInput in) throws IOException {
        }  
        );  
        final ShardRouting replica = state.routingTable().shardRoutingTable(shardId).replicaShards().get(0);
            .put(IndexMetadata.builder(indexMetadata).settings(indexSettings).build(), true);
            .get(primaryNodeId);
import org.opensearch.core.action.ActionListener;
        // whether shard has been marked as relocated already (i.e. relocation completed)
                    assertPhase(task, "replica");
        ) {
import org.opensearch.OpenSearchException;
                });
        }  
            clusterService,
            assertTrue(listener.isDone());
            randomBoolean(),
            new IndexNotFoundException(shardId.getIndex()),  
 * compatible open source license.
            ClusterBlockException exception = assertListenerThrows(  
        final String index = "test";
    }
    private final AtomicBoolean isPrimaryMode = new AtomicBoolean(true);  
            Settings.EMPTY,
        protected void shardOperationOnReplica(Request request, IndexShard replica, ActionListener<ReplicaResult> listener) {  
        final Transport transport = new MockNioTransport(  
     */
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            assertThat(((ClusterBlockException) exception.unwrapCause()).blocks().iterator().next(), is(nonRetryableBlock));
        // test wait_for_active_shards index setting used when the default is set on the request
            if (closed.compareAndSet(false, true) == false) {
            "internal:testIsRetryableClusterBlockException",
        setState(clusterService, state);
                super.shardOperationOnPrimary(shardRequest, primary, listener);
        @Override
            x -> clusterService.localNode(),  
        );
        }
import org.hamcrest.Matcher;
                listener,
    private ReplicationTask maybeTask() {
            createTransportChannel(listener),  
        state = ClusterState.builder(state).nodes(DiscoveryNodes.builder(state.nodes()).localNodeId(replica.currentNodeId())).build();  
                listener,
        final ShardId shardId = new ShardId("test", "_na_", 0);  
        assertListenerThrows("must throw shard not found exception", listener, ShardNotFoundException.class);
    private IndicesService mockIndicesService(ClusterService clusterService) {  
            transportService,
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        final ClusterState initialState = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);
        final ClusterBlocks.Builder blocks = ClusterBlocks.builder();
        AtomicBoolean throwException = new AtomicBoolean(true);  
        CapturingTransport.CapturedRequest[] shardFailedRequests = transport.getCapturedRequestsAndClear();
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
                actionName,
            ClusterService clusterService,
 * this work for additional information regarding copyright
        ReplicationGroup replicationGroup = mock(ReplicationGroup.class);
            // noinspection unchecked  
            assertPhase(task, "rerouted");  
            final IndexMetadata indexSafe = state.metadata().getIndexSafe(index);
        CapturingTransport.CapturedRequest[] captures = transport.getCapturedRequestsAndClear();  
import org.opensearch.action.support.PlainActionFuture;
        clusterService = createClusterService(threadPool);  
}
        if (timeout) {
        final String primaryNodeId = shardRoutingTable.primaryShard().currentNodeId();  
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(blocks).build());
        Releasable releasable = () -> {  
    public void assertIndexShardUninitialized() {  
import static org.mockito.Mockito.mock;
        if (globalBlock) {  
            assertTrue(requestWithTimeout.isRetrySet.get());  
        if (randomBoolean()) {
        final IndicesService indicesService = mock(IndicesService.class);
        String relocationTargetNode = state.getRoutingTable().shardRoutingTable(shardId).primaryShard().relocatingNodeId();  
            RestStatus.SERVICE_UNAVAILABLE,  
     * This test ensures that replication operations adhere to the {@link IndexMetadata#SETTING_WAIT_FOR_ACTIVE_SHARDS} setting  
        CapturingTransport.CapturedRequest[] requestsToReplicas = transport.capturedRequests();
        })), Assert::assertNotNull, null, null);
        } else {
        doAnswer(invocation -> {
            capturedRequests = transport.getCapturedRequestsAndClear();
        ShardRouting primaryShard = state.getRoutingTable().shardRoutingTable(shardId).primaryShard();
        transport = new CapturingTransport();
        }  
    }
        final ClusterState state = state(shardId.getIndexName(), true, ShardRoutingState.STARTED, ShardRoutingState.STARTED);  
import static org.mockito.Mockito.anyInt;
        assertThat(e.getCause().getCause(), hasToString(containsString("shard is not in primary mode")));
        ClusterStateChanges clusterStateChanges = new ClusterStateChanges(xContentRegistry(), threadPool);  
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);  
        }).when(indexShard).acquireReplicaOperationPermit(anyLong(), anyLong(), anyLong(), any(ActionListener.class), anyString(), any());
        final String primaryNodeId = shardRoutingTable.primaryShard().currentNodeId();
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
        when(indexShard.getActiveOperationsCount()).thenAnswer(i -> count.get());
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[0];  
            protected void shardOperationOnPrimary(  
        ReplicationTask task = maybeTask();  
        Request request = new Request(shardId).timeout("1ms");
            setState(clusterService, clusterService.state());
                        "expected allocation id ["
            @Override  
        request.routedBasedOnClusterVersion(clusterService.state().version() + 1);  
                    containsString("expected allocation id [_not_a_valid_aid_] but found [" + primary.allocationId().getId() + "]")
                    calledSuccessfully.set(true);  
import org.opensearch.index.shard.ShardNotInPrimaryModeException;
            }
                ActionListener.completeWith(listener, () -> {
        final ShardId shardId = new ShardId(index, "_na_", 0);
        final ShardRouting replica = initialState.getRoutingTable().shardRoutingTable(shardId).replicaShards().get(0);
            @Override
                equalTo("internal:testAction2[p]")
            assertFalse(request.isRetrySet.get());  
 * KIND, either express or implied.  See the License for the
                    }  
        }
        Set<String> inSyncIds = randomBoolean()
            Version.CURRENT,
        final boolean respondWithError = i == 2;
            shardStateAction,
        );
            transport.handleResponse(requests.get(0).requestId, new TestResponse());  
        assertThat(capturedRequests.size(), equalTo(1));
        when(indicesService.indexServiceSafe(shard.shardId().getIndex())).thenReturn(indexService);
 * SPDX-License-Identifier: Apache-2.0
                createTransportChannel(new PlainActionFuture<>()),
                checkpoint,
     * <p>  
                    ClusterBlockLevel.READ_WRITE
    public void testRoutePhaseExecutesRequest() {
            super.onRetry();
            RestStatus.SERVICE_UNAVAILABLE,  
                "failed to timeout on retryable block",  
        ReplicationTask task = maybeTask();
            }  
import static org.mockito.Mockito.any;  
        logger.debug("using state: \n{}", clusterService.state());
        // simulate execution of the node holding the replica
import org.opensearch.index.IndexService;  
/*  
        when(indexService.getShard(anyInt())).then(invocation -> {
            );  
            false,
                assertPhase(task, "primary");
            shardStateAction,
                clusterService,
                primaryTerm,
                ActionListener<PrimaryResult<Request, TestResponse>> listener
                    randomBoolean(),  
        final String index = "test";
            assertTrue(listener.isDone());
    public void testBlocksInPrimaryAction() {  
        final ShardRouting primary = clusterService.state().routingTable().shardRoutingTable(shardId).primaryShard();  
            null,  
        when(shard.getPendingPrimaryTerm()).thenReturn(primaryTerm);  
        final PlainActionFuture<TransportResponse> listener = new PlainActionFuture<>();
     * causes a retry  
        assertPhase(task, equalTo(phase));
 * software distributed under the License is distributed on an
            transportService,  
        AtomicBoolean throwException = new AtomicBoolean(true);
            );
        Request request = new Request(shardId);
                    randomIntBetween(1, 16),  
        setState(clusterService, stateWithNodes);
            .metadata(metadata)
        assertEquals(retryable, action.isRetryableClusterBlockException(new ClusterBlockException(singleton(randomBlock))));
import org.opensearch.indices.IndicesService;  
    public void testPrimaryPhaseExecutesOrDelegatesRequestToRelocationTarget() throws Exception {  
        logger.debug("--> primary assigned state:\n{}", clusterService.state());  
        final ClusterBlock nonRetryableBlock = new ClusterBlock(  
        final ReplicationTask task = maybeTask();
                ActionListener.completeWith(listener, () -> {
        AtomicInteger processedOnReplicas = new AtomicInteger();  
                IndexShard primary,  
            NoopTracer.INSTANCE
import static org.mockito.Mockito.doThrow;
        final long primaryTerm = clusterService.state().metadata().index(shardId.getIndexName()).primaryTerm(shardId.id());
            equalTo(primaryTerm)
        return randomFrom(
        final ReplicationTask task = maybeTask();
                assertFalse(executed.getAndSet(true));
                } else {
import org.opensearch.cluster.action.shard.ShardStateAction;
            Settings.EMPTY,
        ReplicationTask task = maybeTask();
            "internal:testActionWithBlocks",
import org.opensearch.cluster.block.ClusterBlockException;
        );
        listener = new PlainActionFuture<>();
        asyncPrimaryActionWithBlocks.run();
            assertThat(((ClusterBlockException) exception.unwrapCause()).blocks().iterator().next(), is(nonRetryableBlock));
        int numReplicas = randomIntBetween(0, 5);
                ActionListener.completeWith(listener, () -> {
import org.opensearch.indices.IndexClosedException;
            clusterService,  
        // we use one replica to check the primary term was set on the operation and sent to the replica
            ),  
    }  
    private TestAction action;
            ((TransportReplicationAction.ConcreteShardRequest<Request>) requestsToReplicas[0].request).getPrimaryTerm(),  
            if (state.metadata().hasIndex(index.getName())) {
                    String.format(Locale.ROOT, "%s operation term [%d] is too old (current [%d])", shardId, term, primaryTerm)
            assertPhase(task, "waiting_for_retry");
        final String index = "test";
        TestResponse() {
                    ClusterBlockLevel.ALL  
        reroutePhase = action.new ReroutePhase(task, request, listener);
import org.opensearch.action.support.ActionFilters;
            Request request = new Request(shardId);
    }
 */
    /**
        // Assert that the request was retried, this time successful  
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[3];  
                    "test global block",
            assertTrue(listener.isDone());  
import org.opensearch.cluster.routing.ShardRoutingState;
        TransportReplicationAction.ConcreteShardRequest<Request> concreteShardRequest =
                            + requestTerm
        state = ClusterState.builder(state).metadata(metadataBuilder).build();  
import static java.util.Collections.singleton;
        when(shard.routingEntry()).thenReturn(routingEntry);
        assertThat(capturedRequests.size(), equalTo(1));
    /**
            @Override
    /**  
import org.opensearch.core.common.io.stream.StreamOutput;
            new OpenSearchException("simulated"),
        {
        List<CapturingTransport.CapturedRequest> capturedRequests = transport.getCapturedRequestsByTargetNodeAndClear()
import org.junit.Before;
        ReplicationTask task = maybeTask();
        Metadata.Builder metadataBuilder = Metadata.builder(state.metadata())
        logger.debug("--> using initial state:\n{}", clusterService.state());
import org.opensearch.index.shard.IndexShard;
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.action.support.replication.ReplicationOperation.ReplicaResponse;
    private void setStateWithBlock(final ClusterService clusterService, final ClusterBlock block, final boolean globalBlock) {
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
            }  
            "internal:testActionWithExceptions",
                randomLong()
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();
        final String index = "test";
            assertPhase(task, "failed");
        final ShardRouting replica = randomFrom(
            assertThat(capturedRequests, arrayWithSize(1));
            IndexShard primary,  
            ClusterBlockLevel.ALL
    }  
        Request request = new Request(shardId).timeout("1ms").routedBasedOnClusterVersion(clusterService.state().version() + 1);
            super(shardId);
            assertThat(capturedRequests.get(0).action, equalTo("internal:testAction[p]"));
        assertFalse(executed.get());  
        final ShardId shardId = new ShardId(index, "_na_", 0);
                throw e;
            IndicesService indicesService  
import static org.hamcrest.CoreMatchers.containsString;
            ReplicationTask task = maybeTask();
                ActionListener<PrimaryResult<Request, TestResponse>> listener  
        setState(clusterService, stateWithNodes);
     */
        @Override  
        assertPhase(task, "finished");  
            .build();  
                    )
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
        String primaryTargetNodeId = primaryShard.relocatingNodeId();
        throwException.set(false);
            blocks.addGlobalBlock(block);
import org.opensearch.test.transport.CapturingTransport;
            return new TestResponse(in);  
            ) {  
            return mockIndexShard(shardId, clusterService);
    }
                Request shardRequest,  
            final ClusterState state = clusterService.state();
            Throwable throwable = execException.getCause();
            listener.get();
        assertPhase(task, "failed");
        final ShardRouting routingEntry = clusterService.state().getRoutingTable().index("test").shard(0).primaryShard();
        }
            final TransportReplicationAction.ReplicaResponse response = new TransportReplicationAction.ReplicaResponse(  
        final long primaryTerm = state.metadata().index(index).primaryTerm(shardId.id());
     * takes a request that was sent by a {@link TransportReplicationAction} and captured
        listener = new PlainActionFuture<>();
            Settings.EMPTY,
        assertPhase(task, "finished");  
        listener = new PlainActionFuture<>();
            state(index, true, ShardRoutingState.STARTED, randomFrom(ShardRoutingState.INITIALIZING, ShardRoutingState.STARTED))
                false,
                .get(primaryShard.relocatingNodeId());
        AtomicBoolean isRetrySet = new AtomicBoolean(false);
            ActionListener<PrimaryResult<Request, TestResponse>> listener
        final IndexShard indexShard = mock(IndexShard.class);
    }
        );
        proxy.failShardIfNeeded(
import org.opensearch.core.rest.RestStatus;  
        // no replicas in oder to skip the replication part
        // release the waiting
    public void setUp() throws Exception {
 *    http://www.apache.org/licenses/LICENSE-2.0
                ),
    private IndexShard mockIndexShard(ShardId shardId, ClusterService clusterService) {
            new TransportReplicationAction.ConcreteReplicaRequest<>(
        final String index = "test";  
            );
            }
            new AlreadyClosedException(shardId + " primary is closed"),
                    return new ReplicaResult();  
    public void testUnknownIndexOrShardOnReroute() {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
        assertTrue(request.isRetrySet.get());  
        when(indexShard.getReplicationGroup()).thenReturn(replicationGroup);
 * under the License.  
        public void onRetry() {
    }
        final long primaryTerm = initialState.metadata().index(shardId.getIndexName()).primaryTerm(shardId.id());  
        ClusterState state = state(index, true, ShardRoutingState.RELOCATING);
        assertIndexShardCounter(0);  
import static org.mockito.Mockito.when;  
                settings,  
 */  
            protected void shardOperationOnPrimary(
            threadPool
                    "test index block",
        final TestAction action = new TestAction(  
        }  
        assertEquals(ActiveShardCount.from(idxSettingWaitForActiveShards), request.waitForActiveShards());
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
        setState(clusterService, state);
     * test throwing a {@link org.opensearch.action.support.replication.TransportReplicationAction.RetryOnReplicaException}
        // simulate execution of the node holding the replica
import org.opensearch.index.shard.ShardNotFoundException;  
                assertFalse(executed.getAndSet(true));  
                "primary action should fail operation",  
        assertThat(concreteShardRequest.getTargetAllocationID(), equalTo(expectedAllocationId.getId()));
        final ShardId shardId = new ShardId("test", "_na_", 0);  
        setState(clusterService, clusterState);
        setState(
            reroutePhase.run();
        when(indexShard.getPendingPrimaryTerm()).thenAnswer(  
            assertFalse("primary phase should wait on retryable block", listener.isDone());  
        TestAction action = new TestAction(  
    public void testNoRerouteOnStaleClusterState() {
            EnumSet.of(randomFrom(ClusterBlockLevel.values()))  
            transportService,
        final long checkpoint = randomNonNegativeLong();  
        assertFalse(action.isRetryableClusterBlockException(randomRetryPrimaryException(new ShardId("index", "_na_", 0))));
    private void assertPhase(@Nullable ReplicationTask task, String phase) {  
                ClusterBlockException.class
        action.handleReplicaRequest(  
    @Override  
            equalTo(checkpoint)
            @Override  
            Settings.EMPTY,
    /**
            Request requestWithTimeout = (globalBlock ? new Request(shardId) : new Request(shardId)).timeout("5ms");
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        assertThat(e.getCause(), instanceOf(ReplicationOperation.RetryOnPrimaryException.class));
            i -> clusterService.state().metadata().getIndexSafe(shardId.getIndex()).primaryTerm(shardId.id())
        assertListenerThrows("non existent node should throw a NoNodeAvailableException", listener, NoNodeAvailableException.class);
    /** test that a primary request is rejected if it arrives at a shard with a wrong allocation id or term */
        );
            executeOnPrimary = false;
        assertListenerThrows("cluster state too old didn't cause a timeout", listener, UnavailableShardsException.class);  
        when(indexShard.indexSettings()).thenReturn(RemoteStoreTestsHelper.createIndexSettings(remote));
                shardId,
            final long primaryTerm = indexShard.getPendingPrimaryTerm();
            }  
            Collections.emptySet(),
            .get(primaryNodeId);
            threadPool
        transportService.acceptIncomingRequests();  
    }
        TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);
                index,
        assertIndexShardCounter(0);
        if (listener.isDone()) {
            count.incrementAndGet();
        assertListenerThrows("must throw index not found exception", listener, IndexNotFoundException.class);  
            randomNonNegativeLong(),
            false,  
        setState(clusterService, stateWithActivePrimary(index, randomBoolean(), 3));  
            .build();  
            final List<CapturingTransport.CapturedRequest> requests = transport.capturedRequestsByTargetNode()
                assertThat(cause, instanceOf(OpenSearchException.class));
            clusterService.getSettings(),
            listener.get();
            replica,
            assertTrue(closed.get());  
        }
        transportService.stop();
        assertConcreteShardRequest(capturedRequest.request, request, replica.allocationId());
        // release the waiting
import java.util.concurrent.atomic.AtomicInteger;  
        assertThat(capturedRequests, notNullValue());
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.stateWithActivePrimary;  
                fail("releasable is closed twice");
            new TransportReplicationAction.ConcreteShardRequest<>(request, routingEntry.allocationId().getId(), primaryTerm);
        final ShardId shardId = new ShardId(index, "_na_", 0);
        final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =  
        );
        assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
            assertPhase(task, "finished");
 * not use this file except in compliance with the License.
            TestAction.ReroutePhase reroutePhase = action.new ReroutePhase(task, request, listener);  
            reroutePhase.run();
            assertListenerThrows("should fail with an IndexNotFoundException when no blocks", listener, IndexNotFoundException.class);
        assertEquals(0, shardFailedRequests.length);
            assertThat(requests.size(), equalTo(1));
        // try again with a request that is based on a newer cluster state, make sure we waited until that  
        final ExecutionException exception = expectThrows(ExecutionException.class, listener::get);  
    private Exception randomRetryPrimaryException(ShardId shardId) {  
        assertIndexShardCounter(0);  // no permit should be held
            // noinspection unchecked
            } else {
            new TransportReplicationAction.ConcreteShardRequest<>(request, primaryShard.allocationId().getRelocationId(), primaryTerm);
                    randomBoolean(),  
            Settings.EMPTY,  
                randomNonNegativeLong()
        }).when(indexShard).acquirePrimaryOperationPermit(any(ActionListener.class), anyString(), any(), eq(forceExecute));  
            fail("using a wrong aid didn't fail the operation");  
        final String index = "index";
        action.resolveRequest(state.metadata().index(indexName), request);  
import org.opensearch.action.support.ActiveShardCount;  
                assertPhase(task, "primary");  
        setState(clusterService, stateWithActivePrimary(index, true, randomInt(5)));  
        Set<String> trackedAllocationIds = shardRoutingTable.getAllAllocationIds();
    }
/*  
        assertThat(capturedRequests.get(0).action, equalTo("internal:testAction[p]"));
        if (listener.isDone()) {
            verify(shard).failShard("test", exception);
        logger.debug("--> relocation ongoing state:\n{}", clusterService.state());  
                return mockIndexService(clusterService.state().metadata().getIndexSafe(index), clusterService);  
        setState(clusterService, ClusterState.builder(clusterService.state()).blocks(block));
            isRelocated.set(true);  
        final ShardId shardId = new ShardId(index, "_na_", 0);  
        final TestAction actionWithBlocks = new TestAction(  
            clusterService,
                    listener.onFailure(new OpenSearchException("simulated exception, as a response"));
        PlainActionFuture<ReplicaResponse> listener = new PlainActionFuture<>();
            Settings settings,
        final ShardRouting primaryShard = state.getRoutingTable().shardRoutingTable(shardId).primaryShard();
        assertThat(capturedRequests.size(), equalTo(1));  
            ClusterBlockLevel.ALL
        action.handlePrimaryRequest(concreteShardRequest, createTransportChannel(listener), null);
        final String index = "test";
            assertThat(capturedRequests[0].action, equalTo("internal:testAction[p]"));
        assertThat(capturedRequest.action, equalTo("internal:testActionWithExceptions[r]"));
     * stale index routing table on relocation target.  
import org.opensearch.cluster.node.DiscoveryNodes;  
            String actionName,
            ) {
            assertListenerThrows("listener should reflect remote error", listener, OpenSearchException.class);
            assertThat(((ClusterBlockException) exception.unwrapCause()).blocks().iterator().next(), is(retryableBlock));
            maybeTask()
    @Before
            }  
        ClusterState state = stateWithActivePrimary(index, true, randomInt(5));  
        ) {
        };
        PlainActionFuture<TestResponse> listener = new PlainActionFuture<>();  
    @After
            Throwable throwable = execException.getCause();
import org.opensearch.cluster.block.ClusterBlock;  
                    randomNonNegativeLong(),
        ReplicationTask task = maybeTask();
     */
