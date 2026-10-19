        final SettingsException exception = expectThrows(
 * SPDX-License-Identifier: Apache-2.0
        action.execute(request, listener);
                assertThat(cause, instanceOf(OpenSearchException.class));
            super(in);  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        Request request = new Request();
                fail("Expected exception but returned proper result");
                );
        ClusterState stateWithBlock = ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes))
            @Override
        assertTrue(listener.isDone());
                fail("Expected exception but returned proper result");  
                    // If called second time due to retry, throw exception
            // very lightweight operation in memory, no need to fork to a thread
        final Version version1 = Version.V_2_13_0;
        };  
    }
            RemoteClusterStateService clusterStateService
        discoveryNodes = DiscoveryNodes.builder()  
            assertListenerThrows("checkBlock has thrown exception", listener, RuntimeException.class);
        barrier.await();  
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;  
        try {  
                assertThat(ex.getCause().getCause(), instanceOf(ClusterBlockException.class));  
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        Request request = new Request();  
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;  
        if (throwExceptionOnRetry == false) {  
        Metadata newMetadata = Metadata.builder().coordinationMetadata(coordMetadataBuilder.build()).build();  
            if (o == null || getClass() != o.getClass()) return false;
}  
                setState(clusterService, builder.version(0));  
            }  
        );
            attributes,
                    .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)  
                nodesBuilder.remove(clusterManagerNode);  
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));  
        final boolean clusterManagerOperationFailure = randomBoolean();
                throws Exception {
                fail("Expected exception but returned proper result");  
            .localNodeId(remoteNode1.getId())
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
            NoopTracer.INSTANCE
            .localNodeId(nonRemoteNode1.getId())
            capturedRequests = transport.getCapturedRequestsAndClear();  
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));  
import java.util.Map;
    class Response extends ActionResponse {  
            protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener)
        // No transport request yet, waiting for a master to appear  
 */
        assertFalse(listener.isDone());  
                } else {
import org.opensearch.core.common.io.stream.StreamInput;
            buildNewFakeTransportAddress(),
        assertThat(listener.get(), equalTo(response));  
        new Action("internal:testAction", transportService, clusterService, threadPool) {
            attributes,
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    @AfterClass
        assertTrue(capturedRequest.node.isClusterManagerNode());
                } else {  
 */  
        }.execute(request, listener);  
        assertThat(capturedRequest.action, equalTo("internal:testAction"));  
            )  
            protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener)
            exception.getMessage(),  
                assertThat(ex.getCause(), instanceOf(ClusterManagerNotDiscoveredException.class));
        GetTermVersionResponse termResp = new GetTermVersionResponse(  
                clusterManagerNode = new DiscoveryNode(
        ClusterState stateWithBlock = ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes))  
            EmptySnapshotsInfoService.INSTANCE
    public static void afterClass() {  
            Version.CURRENT
            listener.onResponse(new Response()); // default implementation, overridden in specific tests  
            buildNewFakeTransportAddress(),
                listener.get();  
                        barrier.await();  
        ClusterState state = clusterService.state();  
        if (clusterManagerOperationFailure) {
import org.opensearch.action.support.ActionFilters;
            .clusterTerm(state.term() + 1)  
                    : new NotClusterManagerException("Fake error");
            }
            new BalancedShardsAllocator(Settings.EMPTY),
    public void tearDown() throws Exception {
        DiscoveryNode masterNode = this.remoteNode;
        boolean throwExceptionOnRetry = randomBoolean();
            assertTrue(listener.isDone());
            capturedRequest.requestId,
            buildNewFakeTransportAddress(),
        assertTrue(retried.get());
            .build();  
        attributes.put(REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "repo2");
        listener.get();  
        assertTrue(listener.isDone());  
        request.persistentSettings(intendedCompatibilityModeSettings);
            .build();
        // that the predicate recognizes as newer than the original  
        CapturingTransport.CapturedRequest capturedRequest = capturedRequests[0];  
    private ClusterService clusterService;  
            protected ClusterBlockException checkBlock(Request request, ClusterState state) {
        new Action("internal:testAction", transportService, clusterService, threadPool) {
                    throw new RuntimeException("checkBlock has thrown exception");
        assertThat(transport.capturedRequests().length, equalTo(0));  
    public void testExecuteOnClusterManagerHandlesNodeClosedException() throws ExecutionException, InterruptedException {
                assertThat(es.getMessage(), equalTo(t.getMessage()));  
                nodesBuilder.add(clusterManagerNode);  
            .build();
import org.opensearch.action.support.ThreadedActionListener;
        assertTrue(listener.isDone());
        }
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    public void testThrottlingRetryLocalMaster() throws InterruptedException, BrokenBarrierException {
                    }  
        setState(clusterService, stateWithBlock);
        Response(StreamInput in) throws IOException {
        TransportClusterManagerNodeAction action = new Action("internal:testAction", transportService, clusterService, threadPool) {  
        assertFalse(listener.isDone());
        super.setUp();  
        assertTrue(listener.isDone());  
        localNode = new DiscoveryNode(
import org.opensearch.cluster.block.ClusterBlocks;
        assertThat(transport.capturedRequests().length, equalTo(1));
        clusterService = createClusterService(threadPool);
            .localNodeId(discoveryNode2.getId())  
            SettingsException.class,  
        assertThat(capturedRequest.action, equalTo("internal:testAction"));  
            transport.handleRemoteError(capturedRequest.requestId, t);  
                .version(randomIntBetween(0, 10))  
        action.execute(request, listener);
            attributes,  
            new TestGatewayAllocator(),
        assertTrue(listener.isDone());
     */  
            clusterService,  
                eq(state.version() + 1)
        boolean rejoinSameClusterManager = failsWithConnectTransportException && randomBoolean();  
            DiscoveryNodeRole.BUILT_IN_ROLES,
    public void testDelegateToClusterManager() throws ExecutionException, InterruptedException {  
        localNode = new DiscoveryNode(  
            @Override
        assertThat(transport.capturedRequests().length, equalTo(1));
        listener.get();
        }
        }
            buildNewFakeTransportAddress(),
        remoteStoreNodeAttributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-segment-repo-1");
        return ClusterState.builder(state).version(version).metadata(newMetadata).build();
            if (this == o) return true;  
public class TransportClusterManagerNodeActionTests extends OpenSearchTestCase {  
import org.opensearch.snapshots.EmptySnapshotsInfoService;  
        // Simulate a NodeClosedException (remote master shutting down)  
        CapturingTransport.CapturedRequest capturedRequest = capturedRequests[0];
            new TestGatewayAllocator(),
        transport.handleResponse(capturedRequest.requestId, termResp);
            transportService,
            setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));  
        remoteNode = new DiscoveryNode(
                eq(state.getClusterName().value()),
import org.opensearch.tasks.Task;
        Settings intendedCompatibilityModeSettings = Settings.builder()  
        protected Response read(StreamInput in) throws IOException {  
    }
            assertTrue(listener.isDone());
            .nodes(discoveryNodes)
        public ActionRequestValidationException validate() {
        assertThat(capturedRequest.request, equalTo(request));
    }
                ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes))
        // Same node becomes master again with higher version
            listener.get();
            protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener) {  
        Request request = new Request();
import org.opensearch.transport.TransportService;  
                        throw new AssertionError();
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
            ThreadPool threadPool,  
            x -> clusterService.localNode(),
                setState(clusterService, ClusterState.builder(clusterService.state()).nodes(nodesBuilder));
import static org.hamcrest.Matchers.instanceOf;
        RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
                assertThat(ex.getCause(), equalTo(exception));  
import org.opensearch.core.action.ActionResponse;  
                } else {  
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(0));
 *
                // reset the same state to increment a version simulating a join of an existing node
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);  
            .add(remoteNode2)  
            try {
            .build();
        );
            EmptySnapshotsInfoService.INSTANCE
            return new Response(in);
            "remote_node",
            "local_node",  
        Request(StreamInput in) throws IOException {
        if (retryableBlock) {  
        );  
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
        ).thenReturn(Optional.of(manifest));
            .localNodeId(nonRemoteNode1.getId())  
        action.execute(request, listener);
import org.opensearch.core.rest.RestStatus;  
            version1 // same as discoveryNode1
        );
            }
        transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, sameTypeClusterState);  
        localNode = new DiscoveryNode(
            version2 // not same as discoveryNode1
            threadPool,  
        final Version version2 = Version.V_2_13_1;  
            toStrictMode ? getRemoteStoreNodeAttributes() : Collections.emptyMap(),
    @BeforeClass
            }
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
        );  
        if (clusterManagerOperationFailure) {  
            .build();  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        );
    }  
        // waiting for retry to trigger
                    : new NodeClosedException(clusterManagerNode)  
        capturedRequest = capturedRequests[0];
            } catch (ExecutionException ex) {
        public boolean localExecuteSupportedByAction() {
    }
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            .add(nonRemoteNode1)
            "remote_node",
import org.junit.Before;  
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(60));
                // ZenDiscovery
        );
        }.execute(request, listener);
import java.util.concurrent.BrokenBarrierException;
                REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(),  
            } catch (ExecutionException ex) {
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
        Request() {}  
        } catch (ExecutionException ex) {  
import org.opensearch.transport.ConnectTransportException;
    public void testDelegateToClusterManagerOnNodeWithDeprecatedMasterRole() throws ExecutionException, InterruptedException {  
    to validate the backwards compatibility for the deprecated method masterOperation(with task parameter). */
                assertThat(ex.getCause(), equalTo(exception));
            assertTrue(listener.isDone());  
                Set<ClusterBlock> blocks = state.blocks().global();
        protected String executor() {  
            ClusterService clusterService,
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
            ClusterState.builder(ClusterStateCreationUtils.state(localNode, masterNode, new DiscoveryNode[] { localNode, masterNode }))
            super.doExecute(task, request, new ThreadedActionListener<>(logger, threadPool, ThreadPool.Names.SAME, listener, false));
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
        ClusterBlock block = new ClusterBlock(1, "", true, true, false, randomFrom(RestStatus.values()), ClusterBlockLevel.ALL);  
        // Now a new master is elected (remoteNode)
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
        setState(clusterService, ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes)).version(11));  
    public void testStepDownToNoMasterThenSameNodeReelected() throws ExecutionException, InterruptedException {
                    throw new AssertionError("Should not retry for other exception");  
    /**
import org.opensearch.cluster.coordination.CoordinationMetadata;
    public void testDontAllowSwitchingCompatibilityModeForClusterWithMultipleVersions() {
    public void testDontAllowSwitchingToStrictCompatibilityModeForMixedCluster() {
            // remove unneeded threading by wrapping listener with SAME to prevent super.doExecute from wrapping it with LISTENER
                Set<ClusterBlock> blocks = state.blocks().global();  
        final boolean clusterManagerOperationFailure = randomBoolean();  
        request.persistentSettings(intendedCompatibilityModeSettings);
        TransportClusterUpdateSettingsAction transportClusterUpdateSettingsAction = new TransportClusterUpdateSettingsAction(
import org.opensearch.node.NodeClosedException;
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();  
    class Action extends TransportClusterManagerNodeAction<Request, Response> {
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(60));  
        assertTrue(capturedRequest.node.isClusterManagerNode());  
                }
            assertFalse(listener.isDone());
            .metadata(metadata)  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, sameVersionClusterState);
    private ClusterState buildClusterState(ClusterState state, long term, long version) {
        discoveryNodes = DiscoveryNodes.builder()  
            SettingsException.class,
import static org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdaterTests.createIndexMetadataWithRemoteStoreSettings;
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
                throws Exception {  
        remoteNode = new DiscoveryNode(  
                eq(state.metadata().clusterUUID()),  
import org.opensearch.cluster.EmptyClusterInfoService;  
            t.addHeader("header", "is here");
        setState(clusterService, stateWithBlock);  
        boolean failsWithConnectTransportException = randomBoolean();
    public void testStepDownToNoMasterThenNewMasterElected() throws ExecutionException, InterruptedException {  
                listener.onFailure(failure);  
        final int[] callCount = { 0 };  
            protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener)
    void assertListenerThrows(String msg, ActionFuture<?> listener, Class<?> klass) throws InterruptedException {
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
        Action action = new Action("internal:testAction", transportService, clusterService, threadPool, remoteClusterStateService);  
        AtomicBoolean retried = new AtomicBoolean(false);  
        assertTrue(listener.isDone());
        );  
            clusterService,
    public void testClusterManagerBecomesAvailable() throws ExecutionException, InterruptedException {
                clusterService,
        );  
    @After
        // request to change cluster compatibility mode
        assertEquals(  
        }  
        new Action("internal:testAction", transportService, clusterService, threadPool) {  
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
            return localExecuteSupported;  
        DiscoveryNode discoveryNode1 = new DiscoveryNode(
                    throw new ClusterManagerThrottlingException("Throttling Exception : Limit exceeded for test");
                    listener.onFailure(new FailedToCommitClusterStateException("Fake error"));
            OpenSearchException t = new OpenSearchException("test");
    }
        final boolean unblockBeforeTimeout = randomBoolean();  
            );
        when(  
        }  
        DiscoveryNode remoteNode = new DiscoveryNode(
                // The other node has become cluster-manager, simulate failures of this node while publishing cluster state through  
        // two different but compatible open search versions for the discovery nodes
            Version.CURRENT
                eq(state.term() + 1),
            this(actionName, transportService, clusterService, threadPool);  
    public void testLocalOperationWithoutBlocks() throws ExecutionException, InterruptedException {
            DiscoveryNodeRole.BUILT_IN_ROLES,
            );
        DiscoveryNode nonRemoteNode1 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
        );
        Response response = new Response();
 * this file be licensed under the Apache-2.0 license or a
    public void testLocalOperationWithBlocks() throws ExecutionException, InterruptedException {
        }.execute(request, listener);
        new Action("internal:testAction", transportService, clusterService, threadPool) {  
            assertFalse(listener.isDone());
            true
        public int hashCode() {
import java.io.IOException;  
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueHours(1));
    private TransportService transportService;
                return blocks.isEmpty() ? null : new ClusterBlockException(blocks);  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
                nodesBuilder.clusterManagerNodeId(clusterManagerNode.getId());
                final OpenSearchException es = (OpenSearchException) cause;
            @Override
        remoteStoreNodeAttributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-cluster-repo-1");
    }
        ClusterState sameVersionClusterState = ClusterState.builder(differentVersionClusterState)
        }  
            attributes,  
            Collections.singleton(DiscoveryNodeRole.MASTER_ROLE),
        protected void doExecute(Task task, final Request request, ActionListener<Response> listener) {  
        @Override
     * Tests that when the clusterStateLatestChecker's GetTermVersion request fails with a
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
        assertThat(listener.get(), equalTo(response));
        }  
            assertThat(capturedRequest.action, equalTo("internal:testAction"));
import org.mockito.Mockito;
        );
            try {
        assertThat(capturedRequests.length, equalTo(1));
    }
        assertThat(capturedRequest.request, equalTo(request));
                }
            "remote_node",  
        assertThat(transport.capturedRequests().length, equalTo(0));
            .localNodeId(discoveryNode1.getId())
        threadPool = new TestThreadPool("TransportMasterNodeActionTests");  
        assertFalse(retried.get());  
            this.remoteClusterStateService = clusterStateService;
import java.util.HashMap;
        DiscoveryNode remoteNode1 = new DiscoveryNode(
            Collections.singleton(DiscoveryNodeRole.MASTER_ROLE),  
        Action(
        assertThat(capturedRequests.length, equalTo(1));
        DiscoveryNode[] allNodes = new DiscoveryNode[] { localNode, remoteNode };  
        return remoteStoreNodeAttributes;
            allocationService,
        // changing compatibility mode when all nodes are of the same version
            @Override  
            new ActionFilters(Collections.emptySet()),  
            Collections.emptyMap(),  
            }
        listener.get();
/*
        );
            .metadata(createIndexMetadataWithRemoteStoreSettings("test"))  
import org.opensearch.common.util.concurrent.ThreadContext;
            () -> transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, differentVersionClusterState)  
            .add(discoveryNode1)
import org.opensearch.threadpool.ThreadPool;
                new ActionFilters(new HashSet<>()),
            UUIDs.base64UUID(),
                return true;
    private DiscoveryNode remoteNode;
    }
            identity = in.readLong();
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
    /**  
    public void testClusterManagerFailoverAfterStepDown() throws ExecutionException, InterruptedException {  
        assertTrue(listener.isDone());  
                ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes))  
        );  
import org.opensearch.action.support.PlainActionFuture;  
                    // First call: master steps down, no new master yet  
        assertFalse(listener.isDone());
            buildNewFakeTransportAddress(),
        assertFalse(listener.isDone());  
            .thenReturn(buildClusterState(state, state.term() + 1, state.version() + 1));  
            clusterService,  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        public boolean equals(Object o) {
                }  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
                nodesBuilder.clusterManagerNodeId(clusterManagerNode.getId());
    }
                    listener.onFailure(exception);
    private DiscoveryNode localNode;  
            .blocks(ClusterBlocks.builder().addGlobalBlock(block))
import org.junit.AfterClass;
        transport.handleResponse(capturedRequest.requestId, response);
            }
        } else if (failsWithConnectTransportException) {  
                    listener.onResponse(response);
            try {
        // Elect localNode as the new master — this triggers the observer and re-executes locally
        Thread.sleep(10000);  
                final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterService.state().nodes());
            Response response = (Response) o;
                setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
     * wrapped in a RemoteTransportException, the handleTransportException path correctly retries.
        assertTrue(listener.isDone());  
            DiscoveryNodeRole.BUILT_IN_ROLES,  
                    .build()
            buildNewFakeTransportAddress(),
            }
            .add(remoteNode1)
            String actionName,  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
        );
        DiscoveryNode clusterManagerNode = this.remoteNode;
import org.opensearch.cluster.block.ClusterBlockException;  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener)
            out.writeLong(identity);
        Metadata metadata = Metadata.builder().persistentSettings(currentCompatibilityModeSettings).build();  
            clusterService.getSettings(),
    }  
        ClusterState sameTypeClusterState = ClusterState.builder(clusterState).nodes(discoveryNodes).metadata(metadata).build();
        Metadata metadata = Metadata.builder().persistentSettings(currentCompatibilityModeSettings).build();
        assertThat(capturedRequest.request, equalTo(request));
            .add(nonRemoteNode1)
            .build();
            () -> transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, clusterState)
            .build();
        assertThat(
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
            }  
                if (exception.getAndSet(false)) {
            @Override  
            assertFalse(listener.isDone());  
    public void testClusterStateLatestCheckerHandlesTransportException() throws ExecutionException, InterruptedException {  
    public void testRetryForDifferentException() throws InterruptedException, BrokenBarrierException {
            // use a random base version so it can go down when simulating a restart.
        setState(clusterService, ClusterStateCreationUtils.state(localNode, null, allNodes));  
import org.opensearch.common.settings.Settings;
        transport.handleResponse(capturedRequest.requestId, response);  
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
            .localNodeId(discoveryNode2.getId())
                    setState(clusterService, ClusterStateCreationUtils.state(localNode, null, allNodes));
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
        Response response = new Response();  
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
        );
        }
        setState(  
        Settings intendedCompatibilityModeSettings = Settings.builder()
        @Override
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
    public static void beforeClass() {
        @Override  
        transportService.acceptIncomingRequests();
        clusterService.close();
        action.execute(request, listener);
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    }
        }.execute(request, listener);
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;  
            Version.CURRENT
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        @Override  
        }
    }
        AtomicBoolean exception = new AtomicBoolean(true);
                capturedRequest.requestId,  
        // no more transport calls
    }
        // The request should now be forwarded to the new master
        assertThat(callCount[0], equalTo(2));
        final Response response = new Response();
            .build();  
        }
                    ? new FailedToCommitClusterStateException("Fake error")
        // Waiting for a master, no transport request, not done yet
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
        Map<String, String> attributes = new HashMap<>();
import org.opensearch.action.support.replication.ClusterStateCreationUtils;  
                    listener.onResponse(response);  
                } else {  
            )
            getRemoteStoreNodeAttributes(),  
            UUIDs.base64UUID(),  
        assertThat(capturedRequest.request, equalTo(request));
            }  
            setState(  
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);  
                final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterService.state().nodes());  
            @Override
import org.opensearch.cluster.NotClusterManagerException;
import java.util.Optional;  
        );
 * Modifications Copyright OpenSearch Contributors. See  
        DiscoveryNode remoteNode2 = new DiscoveryNode(  
import static org.hamcrest.Matchers.equalTo;
            assertFalse(listener.isDone());
            buildNewFakeTransportAddress(),
            @Override
            remoteClusterStateService.getClusterMetadataManifestByTermVersion(
                // simulate cluster-manager restart followed by a state recovery - this will reset the cluster state version
import org.opensearch.common.unit.TimeValue;  
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
                final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterService.state().nodes());
package org.opensearch.action.support.clustermanager;
        assertThat(capturedRequest.request, equalTo(request));
import org.opensearch.common.action.ActionFuture;  
                clusterService,
import org.opensearch.OpenSearchException;  
import java.util.concurrent.CyclicBarrier;  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            clusterService.getClusterSettings(),
            .build();  
        }  
            .add(remoteNode1)
            } else {  
        attributes.put(REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "repo2");  
            buildNewFakeTransportAddress(),  
        }  
 * The OpenSearch Contributors require contributions made to  
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));  
            }
            ClusterState.builder(ClusterStateCreationUtils.state(localNode, clusterManagerNode, allNodes)).version(randomIntBetween(0, 10))  
        } else {  
            new ClusterManagerThrottlingException("Throttling Exception : Limit exceeded for test")  
    }  
    public void setUp() throws Exception {
        transport = new CapturingTransport();
    public void testDeprecatedMasterOperationWithTaskParameterCanBeCalled() throws ExecutionException, InterruptedException {
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            return null;
            super(  
        AllocationService allocationService = new AllocationService(  
        }  
    public void testForceLocalOperation() throws ExecutionException, InterruptedException {
            assertFalse(listener.isDone());
import org.opensearch.cluster.routing.allocation.AllocationService;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.cluster.ClusterName;
        attributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "repo1");
        assertTrue(listener.isDone());  
            Version.CURRENT  
        }.execute(request, listener);
                    ? new ConnectTransportException(clusterManagerNode, "Fake error")
            protected boolean localExecute(Request request) {
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            "local_node",
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
    public void testCheckBlockThrowsException() throws InterruptedException {
import org.opensearch.cluster.block.ClusterBlock;
                return new ClusterBlockException(blocks);
            @Override  
                    .build()
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder().term(term);
        @Override  
        assertFalse(listener.isDone());  
        );
            .localNodeId(discoveryNode1.getId())
        DiscoveryNode localNode = new DiscoveryNode(
        assertTrue(capturedRequest.node.isClusterManagerNode());  
import org.opensearch.cluster.service.ClusterManagerThrottlingException;  
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
        boolean toStrictMode = randomBoolean();  
            }  
import org.opensearch.common.UUIDs;
        RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
                listener.get();
import org.opensearch.core.action.ActionListener;
            "local_node",
            threadPool,
        // Set initial state with a higher base version so re-election produces a version
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));  
        final Exception exception = new Exception();
            clusterService.getClusterSettings(),
        // Should have re-executed locally and succeeded
import org.opensearch.test.gateway.TestGatewayAllocator;
        transport.handleRemoteError(
    @Override  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        }  
        setState(clusterService, ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes)).version(10));
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        // cluster with only non-remote nodes
        assertThat(capturedRequests.length, equalTo(1));  
            );  
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));  
import org.opensearch.cluster.ClusterState;
/*  
        TransportClusterManagerNodeAction action = new Action("internal:testAction", transportService, clusterService, threadPool) {
            Version.CURRENT  
        Action(String actionName, TransportService transportService, ClusterService clusterService, ThreadPool threadPool) {
            .add(discoveryNode2)
        assertThat(listener.get(), equalTo(response));
                // simulate cluster-manager node removal
    public void testDelegateToFailingClusterManager() throws ExecutionException, InterruptedException {
        capturedRequests = transport.getCapturedRequestsAndClear();  
            toStrictMode ? getRemoteStoreNodeAttributes() : Collections.emptyMap(),  
        final boolean retryableBlock = randomBoolean();
        CapturingTransport.CapturedRequest capturedRequest = capturedRequests[0];
    }
        assertTrue(capturedRequest.node.isClusterManagerNode());
        Response() {}  
import java.util.concurrent.ExecutionException;
        setState(clusterService, ClusterStateCreationUtils.state(localNode, randomFrom(localNode, remoteNode, null), allNodes));  
                // Master steps down but no new master elected yet (master = null)  
import java.util.Objects;
        Request request = new Request();
            allocationService,
        attributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "repo1");  
        metadata = createIndexMetadataWithRemoteStoreSettings("test-index");
import org.opensearch.cluster.node.DiscoveryNodes;
        );
            }
            // use a random base version so it can go down when simulating a restart.
        final SettingsException exception = expectThrows(
            }
    }  
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
        }  
            .add(discoveryNode1)  
            if (randomBoolean()) {  
        // mixed cluster (containing both remote and non-remote nodes)  
        @Override
        }
            protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener) {
import org.opensearch.core.common.io.stream.StreamOutput;
                assertThat(es.getHeader("header"), equalTo(t.getHeader("header")));
import org.opensearch.test.transport.CapturingTransport;
            transport.handleRemoteError(capturedRequest.requestId, new ConnectTransportException(clusterManagerNode, "Fake error"));
            assertListenerThrows("checkBlock has thrown exception", listener, RuntimeException.class);
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();  
import org.opensearch.Version;
        ) {
        public void writeTo(StreamOutput out) throws IOException {  
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(failsWithConnectTransportException ? 60 : 0));
        remoteStoreNodeAttributes.put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-translog-repo-1");  
        // New master elected (localNode)  
                    .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
                    listener.onResponse(response);
                Exception failure = randomBoolean()  
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;  
import static org.hamcrest.Matchers.containsString;  
        Request request = new Request();
import java.util.Set;
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, new DiscoveryNode[] { localNode }));
            }  
        setState(
        assertThat(capturedRequest.request, equalTo(request));
import org.opensearch.cluster.service.ClusterService;
    }  
            }
                throws Exception {  
        if (retryableBlock && unblockBeforeTimeout) {
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).nodes(discoveryNodes).build();
        transport.handleResponse(capturedRequest.requestId, response);
        assertThat(transport.capturedRequests().length, equalTo(1));
            .add(nonRemoteNode2)  
                }  
        assertThat(listener.get(), equalTo(response));
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
        );
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
                threadPool,
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            return identity == response.identity;  
            this.localExecuteSupported = true;
    }  
            .blocks(ClusterBlocks.builder().addGlobalBlock(block))
        assertThat(listener.get(), equalTo(response));
        AtomicBoolean retried = new AtomicBoolean(false);
    }
            assertThat(capturedRequests.length, equalTo(1));
import org.junit.After;
import org.opensearch.cluster.node.DiscoveryNodeRole;  
            return;
import org.opensearch.action.ActionRequestValidationException;
            .stateVersion(state.version() + 1)
import org.opensearch.test.OpenSearchTestCase;  
        @Override
        );  
        // changing compatibility mode when all nodes are not of the same version  
        assertTrue(capturedRequest.node.isClusterManagerNode());  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
                    // Second call: we're master again, succeed
                Request::new,  
            new BalancedShardsAllocator(Settings.EMPTY),  
        final Exception exception = new Exception();
    }
        Settings currentCompatibilityModeSettings = Settings.builder()
        @Override
            transport.handleRemoteError(
        Action action = new Action("internal:testAction", transportService, clusterService, threadPool, remoteClusterStateService);
            super(in);  
        } else {
        private boolean localExecuteSupported = false;  
        final Response response = new Response();  
                }
            .build();
        assertTrue(listener.isDone());
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(60));
                        retried.set(true);
        DiscoveryNode discoveryNode2 = new DiscoveryNode(  
            protected ClusterBlockException checkBlock(Request request, ClusterState state) {
            version1
                nodesBuilder.clusterManagerNodeId(null);  
            assertTrue(capturedRequest.node.isClusterManagerNode());  
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];  
            .build();
import static org.mockito.ArgumentMatchers.eq;  
        super.tearDown();  
            .put(
    }
        if (rejoinSameClusterManager) {
            TransportService transportService,
            Version.CURRENT
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
        }
        assertThat(capturedRequests.length, equalTo(1));
        transportService = transport.createTransportService(  
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueHours(1));
        assertThat(transport.capturedRequests().length, equalTo(1));  
import java.util.Collections;
        Settings currentCompatibilityModeSettings = Settings.builder()  
        TransportClusterUpdateSettingsAction transportClusterUpdateSettingsAction = new TransportClusterUpdateSettingsAction(  
        }
import java.util.HashSet;  
import org.opensearch.action.admin.cluster.settings.TransportClusterUpdateSettingsAction;
                }
        assertFalse(listener.isDone());
    }
    public void testFetchFromRemoteStore() throws InterruptedException, BrokenBarrierException, ExecutionException, IOException {
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
                    retried.set(true);
import org.opensearch.cluster.node.DiscoveryNode;
        TransportClusterManagerNodeAction action = new Action("internal:testAction", transportService, clusterService, threadPool);
                    } catch (Exception e) {
            .localNodeId(remoteNode1.getId())
        action.execute(request, listener);
        assertThat(capturedRequests.length, equalTo(1));
        final Response response = new Response();
                if (exception.getAndSet(false)) {
        final Response response = new Response();
    private DiscoveryNode[] allNodes;
     * and the request is eventually forwarded to a new master.
        Request request = new Request();
            buildNewFakeTransportAddress(),  
            @Override  
            setState(
import org.opensearch.threadpool.TestThreadPool;  
                if (throwExceptionOnRetry == false || blocks.isEmpty()) {
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener) throws Exception {
import org.opensearch.common.settings.SettingsException;
    }  
    }
            clusterService,
            Collections.emptyMap(),
        assertThat(capturedRequest.action, equalTo("internal:testAction"));  
        }
        }.execute(request, listener);
        // Simulate a ConnectTransportException on the GetTermVersion request
            Settings.EMPTY  
        discoveryNode2 = new DiscoveryNode(
            if (randomBoolean()) {  
        transport.handleRemoteError(capturedRequest.requestId, new ConnectTransportException(remoteNode, "Fake connection error"));  
import org.opensearch.cluster.block.ClusterBlockLevel;
        assertNotNull(listener.get());
        transport.handleResponse(capturedRequest.requestId, response);
        // request to change cluster compatibility mode to STRICT
            Version.CURRENT
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
        transport.handleResponse(capturedRequest.requestId, response);
        new Action("internal:testAction", transportService, clusterService, threadPool) {  
 * compatible open source license.
        ClusterBlock block = new ClusterBlock(1, "", retryableBlock, true, false, randomFrom(RestStatus.values()), ClusterBlockLevel.ALL);
                transportService,
     */
        remoteNode = new DiscoveryNode(  
            listener.get();
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            fail(msg);
                throws Exception {
        private long identity = randomLong();
            protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener) {  
 * GitHub history for details.
            toStrictMode ? getRemoteStoreNodeAttributes() : Collections.emptyMap(),
            Version.CURRENT
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
        // The first captured request is the GetTermVersion request to the remote master  
    private static ThreadPool threadPool;
        assertThat(transport.capturedRequests().length, equalTo(1));
    }
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
            exception.getMessage()
import java.util.concurrent.atomic.AtomicBoolean;  
            .build();
    }
                fail("Expected exception but returned proper result");
        );  
                clusterService,  
            UUIDs.base64UUID(),  
                    clusterManagerNode.getVersion()
import static org.opensearch.test.ClusterServiceUtils.setState;
            threadPool,
import org.opensearch.cluster.coordination.ClusterStateTermVersion;  
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            Collections.emptyMap(),
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            buildNewFakeTransportAddress(),
        threadPool = null;
            "can not switch to STRICT compatibility mode when the cluster contains both remote and non-remote nodes",
                if (clusterManagerOperationFailure) {  
            assertListenerThrows("ClusterBlockException should be thrown", listener, ClusterBlockException.class);  
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
            containsString("can not change the compatibility mode when all the nodes in cluster are not of the same version")
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
        assertFalse(exception.get());
            return null; // default implementation, overridden in specific tests
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(unblockBeforeTimeout ? 60 : 0));
    }
            getRemoteStoreNodeAttributes(),
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
                toStrictMode ? RemoteStoreNodeService.CompatibilityMode.STRICT : RemoteStoreNodeService.CompatibilityMode.MIXED
    /* The test is copied from testLocalOperationWithoutBlocks()  
        Request request = new Request();
     * ConnectTransportException, the handleTransportException path correctly triggers a retry  
        } else {
            UUIDs.base64UUID(),  
            capturedRequest = capturedRequests[0];
        assertTrue(listener.isDone());
        transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, sameTypeClusterState);
            buildNewFakeTransportAddress(),
        DiscoveryNode nonRemoteNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
        } else {
            .localNodeId(nonRemoteNode2.getId())
        }  
    public static class Request extends ClusterManagerNodeRequest<Request> {
        ClusterState differentVersionClusterState = ClusterState.builder(ClusterName.DEFAULT)
        final Response response = new Response();
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
            } catch (ExecutionException ex) {
     * Tests that when executeOnClusterManager's transport request fails with a NodeClosedException
            EmptyClusterInfoService.INSTANCE,  
        // The action should now be waiting for a new master via the observer
        sameTypeClusterState = ClusterState.builder(sameTypeClusterState).nodes(discoveryNodes).metadata(metadata).build();  
        new Action("internal:testAction", transportService, clusterService, threadPool) {
        Request request = new Request();  
        Map<String, String> attributes = new HashMap<>();
        new Action("internal:testAction", transportService, clusterService, threadPool) {
import org.opensearch.gateway.remote.ClusterMetadataManifest;
            "remote_node",
    private Map<String, String> getRemoteStoreNodeAttributes() {
        Response response = new Response();
        discoveryNodes = DiscoveryNodes.builder()  
    }  
            return ThreadPool.Names.SAME;
                randomBoolean()
            Version.CURRENT
            .build();
        setState(clusterService, ClusterStateCreationUtils.state(localNode, null, allNodes));  
        @Override
        assertTrue(listener.isDone());
        assertListenerThrows("ClusterManagerNotDiscoveredException should be thrown", listener, ClusterManagerNotDiscoveredException.class);
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        );  
        assertNotNull(listener.get());  
            new ClusterStateTermVersion(state.getClusterName(), state.metadata().clusterUUID(), state.term() + 1, state.version() + 1),
                listener.onFailure(new NotClusterManagerException("Fake error"));
        assertTrue(listener.isDone());  
    public void testClusterManagerNotAvailable() throws ExecutionException, InterruptedException {
            null,
                if (callCount[0] == 1) {
                setState(clusterService, ClusterState.builder(clusterService.state()).nodes(nodesBuilder));
            new ActionFilters(Collections.emptySet()),
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueHours(1));
            listener.get();
                } else {  
        } else {
            DiscoveryNodeRole.BUILT_IN_ROLES,  
import static org.mockito.Mockito.when;
        assertTrue(listener.isDone());
        new Action("internal:testAction", transportService, clusterService, threadPool) {
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
    private CapturingTransport transport;
            .add(discoveryNode2)  
            } catch (ExecutionException ex) {
        CyclicBarrier barrier = new CyclicBarrier(2);  
            buildNewFakeTransportAddress(),
            .build();
            .localNodeId(remoteNode2.getId())
            assertThat(listener.get(), equalTo(response));  
        Map<String, String> remoteStoreNodeAttributes = new HashMap<>();  
        AllocationService allocationService = new AllocationService(
            assertThat(ex.getCause(), instanceOf(klass));
            "local_node",  
        // cluster with only non-remote nodes
            DiscoveryNodeRole.BUILT_IN_ROLES,  
        );
import org.junit.BeforeClass;
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
        }
import org.opensearch.cluster.metadata.Metadata;
            }
            .nodes(discoveryNodes)
        CyclicBarrier barrier = new CyclicBarrier(2);
        transportService.close();
        // mismatch term and version
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];  
                    try {
            EmptyClusterInfoService.INSTANCE,
        };  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));  
        PlainActionFuture<Response> listener = new PlainActionFuture<>();  
        AtomicBoolean exception = new AtomicBoolean(true);
            return Objects.hash(identity);
            UUIDs.base64UUID(),
            assertThat(listener.get(), equalTo(response));
    }
                callCount[0]++;
    // Validate TransportMasterNodeAction.testDelegateToClusterManager() works correctly on node with the deprecated MASTER_ROLE.
                    throw new Exception("Different exception");
                listener.get();  
        );  
                final Throwable cause = ex.getCause().getCause();  
            @Override
import java.util.concurrent.TimeUnit;
            Version.CURRENT
                    clusterManagerNode.getId(),
        );
        }.execute(request, listener);
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),  
        }.execute(request, listener);
        when(remoteClusterStateService.getClusterStateForManifest(state.getClusterName().value(), manifest, localNode.getId(), true))
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, new DiscoveryNode[] { localNode }));
    public void testThrottlingRetryRemoteMaster() throws ExecutionException, InterruptedException {
    @Before
        assertTrue(capturedRequest.node.isClusterManagerNode());
    }  
            Collections.emptyMap(),
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
                setState(clusterService, ClusterStateCreationUtils.state(localNode, null, allNodes));
            );
                // simulating use being disconnected
        Request request = new Request();  
            Collections.emptySet(),  
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(60));  
            try {
        transportService.start();  
import org.opensearch.gateway.remote.RemoteClusterStateService;  
        assertTrue(listener.isDone());  
        assertFalse(exception.get());
                if (clusterManagerOperationFailure) {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
                final ClusterState.Builder builder = ClusterState.builder(clusterService.state()).nodes(nodesBuilder);
            transportService,
                actionName,
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
                listener.get();
            buildNewFakeTransportAddress(),
        // Should be waiting for a new master  
        transport.handleRemoteError(capturedRequest.requestId, new NodeClosedException(remoteNode));
        );
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
                    listener.onFailure(exception);
                    clusterManagerNode.getAddress(),  
        // Retry for above throttling exception
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
            assertThat(capturedRequest.request, equalTo(request));
        CapturingTransport.CapturedRequest capturedRequest = capturedRequests[0];  
            Settings.EMPTY
