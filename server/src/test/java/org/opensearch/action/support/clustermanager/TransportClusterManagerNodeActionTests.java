            protected boolean localExecute(Request request) {
            if (randomBoolean()) {
        final Version version2 = Version.V_2_13_1;
        assertNotNull(listener.get());
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
            remoteClusterStateService.getClusterMetadataManifestByTermVersion(
import java.util.HashMap;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
     */
        }
        remoteNode = new DiscoveryNode(
                final OpenSearchException es = (OpenSearchException) cause;
    public void testStepDownToNoMasterThenSameNodeReelected() throws ExecutionException, InterruptedException {
        }
            threadPool,
        new Action("internal:testAction", transportService, clusterService, threadPool) {
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
                assertThat(ex.getCause(), instanceOf(ClusterManagerNotDiscoveredException.class));
        } else {
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
        remoteNode = new DiscoveryNode(
                clusterService,
import org.opensearch.core.action.ActionResponse;
            new ActionFilters(Collections.emptySet()),
            super(in);
    }
    /**
                Request::new,
                listener.get();
            assertFalse(listener.isDone());
     * ConnectTransportException, the handleTransportException path correctly triggers a retry
import org.opensearch.cluster.routing.allocation.allocator.BalancedShardsAllocator;
            .localNodeId(remoteNode2.getId())
    }
                    : new NodeClosedException(clusterManagerNode)
        assertTrue(listener.isDone());
            .nodes(discoveryNodes)
     */
import java.io.IOException;
            .build();
        Request(StreamInput in) throws IOException {
        CapturingTransport.CapturedRequest capturedRequest = capturedRequests[0];
                    } catch (Exception e) {
        threadPool = new TestThreadPool("TransportMasterNodeActionTests");
            UUIDs.base64UUID(),
        localNode = new DiscoveryNode(
        // two different but compatible open search versions for the discovery nodes
    }
                // simulate cluster-manager node removal
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
        // Same node becomes master again with higher version
import org.opensearch.transport.ConnectTransportException;
 * compatible open source license.
                );
            setState(
            assertFalse(listener.isDone());
        @Override
            @Override
import org.opensearch.cluster.routing.allocation.decider.AllocationDeciders;
import static org.opensearch.node.remotestore.RemoteStoreNodeService.REMOTE_STORE_COMPATIBILITY_MODE_SETTING;
        final Response response = new Response();
        transport.handleResponse(capturedRequest.requestId, termResp);
        ClusterState sameVersionClusterState = ClusterState.builder(differentVersionClusterState)
        // Retry for above throttling exception
        setState(clusterService, stateWithBlock);
        public ActionRequestValidationException validate() {
        boolean failsWithConnectTransportException = randomBoolean();
        assertThat(listener.get(), equalTo(response));
                    throw new ClusterManagerThrottlingException("Throttling Exception : Limit exceeded for test");
        final Version version1 = Version.V_2_13_0;
import org.opensearch.cluster.service.ClusterManagerThrottlingException;
            DiscoveryNodeRole.BUILT_IN_ROLES,
        assertTrue(listener.isDone());
            .localNodeId(discoveryNode1.getId())
        final int[] callCount = { 0 };
            UUIDs.base64UUID(),
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        assertTrue(listener.isDone());
import org.opensearch.OpenSearchException;
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY;
                if (exception.getAndSet(false)) {
            Version.CURRENT
                    ? new FailedToCommitClusterStateException("Fake error")
            Version.CURRENT
        assertFalse(exception.get());
        ClusterState stateWithBlock = ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes))
            new BalancedShardsAllocator(Settings.EMPTY),
import static org.mockito.ArgumentMatchers.eq;
    }
            }
            super(in);
    class Response extends ActionResponse {
        assertThat(capturedRequests.length, equalTo(1));
                // simulating use being disconnected
    }
                    listener.onResponse(response);
        assertThat(capturedRequest.request, equalTo(request));
            protected ClusterBlockException checkBlock(Request request, ClusterState state) {
    }
    }
import org.junit.After;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            assertFalse(listener.isDone());
            attributes,
        @Override
     * Tests that when executeOnClusterManager's transport request fails with a NodeClosedException
        }.execute(request, listener);
        }.execute(request, listener);
        @Override
    private Map<String, String> getRemoteStoreNodeAttributes() {
                    retried.set(true);
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
import org.opensearch.node.NodeClosedException;
import org.opensearch.cluster.node.DiscoveryNode;
        clusterService.close();
    @Override
            this.localExecuteSupported = true;
        // Now a new master is elected (remoteNode)
import org.opensearch.cluster.node.DiscoveryNodes;
import java.util.Map;
                Exception failure = randomBoolean()
import org.opensearch.cluster.block.ClusterBlocks;
        );
import static org.opensearch.test.ClusterServiceUtils.setState;
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
        }
import org.opensearch.threadpool.TestThreadPool;
            .localNodeId(discoveryNode2.getId())
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.STRICT)
            .nodes(discoveryNodes)
        } catch (ExecutionException ex) {
     * Tests that when the clusterStateLatestChecker's GetTermVersion request fails with a
import java.util.Optional;
        transport.handleResponse(capturedRequest.requestId, response);
        Action(
            .localNodeId(discoveryNode1.getId())
            buildNewFakeTransportAddress(),
        Metadata metadata = Metadata.builder().persistentSettings(currentCompatibilityModeSettings).build();
            assertListenerThrows("checkBlock has thrown exception", listener, RuntimeException.class);
        assertFalse(exception.get());
            attributes,
            .add(nonRemoteNode2)
import org.opensearch.action.support.ActionFilters;
        if (rejoinSameClusterManager) {
            .localNodeId(remoteNode1.getId())
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
            version1 // same as discoveryNode1
    @AfterClass
 * SPDX-License-Identifier: Apache-2.0
                nodesBuilder.clusterManagerNodeId(clusterManagerNode.getId());
    }
                toStrictMode ? RemoteStoreNodeService.CompatibilityMode.STRICT : RemoteStoreNodeService.CompatibilityMode.MIXED
    private ClusterState buildClusterState(ClusterState state, long term, long version) {
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
            .build();
                setState(clusterService, ClusterStateCreationUtils.state(localNode, null, allNodes));
        assertThat(capturedRequests.length, equalTo(1));
        assertThat(listener.get(), equalTo(response));
    public void testRetryForDifferentException() throws InterruptedException, BrokenBarrierException {
        AllocationService allocationService = new AllocationService(
            TransportService transportService,
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
 * this file be licensed under the Apache-2.0 license or a
            Settings.EMPTY
            DiscoveryNodeRole.BUILT_IN_ROLES,
import org.junit.AfterClass;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            }
            try {
        transportService.close();
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY;
            .build();
            buildNewFakeTransportAddress(),
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        }.execute(request, listener);
import org.opensearch.action.ActionRequestValidationException;
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(60));
            threadPool,
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
import org.opensearch.cluster.block.ClusterBlockException;
        request.persistentSettings(intendedCompatibilityModeSettings);
            @Override
            assertTrue(listener.isDone());
import org.junit.Before;
        Response response = new Response();
    }
        // New master elected (localNode)
        transport.handleResponse(capturedRequest.requestId, response);
            true
            if (this == o) return true;
    }
        // Simulate a NodeClosedException (remote master shutting down)
            () -> transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, clusterState)
            );
                } else {
            protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener) {
        ).thenReturn(Optional.of(manifest));
        localNode = new DiscoveryNode(
        assertFalse(listener.isDone());
        Request request = new Request();
import org.opensearch.cluster.metadata.Metadata;
                clusterService,
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
        }.execute(request, listener);
                setState(clusterService, ClusterState.builder(clusterService.state()).nodes(nodesBuilder));
        boolean rejoinSameClusterManager = failsWithConnectTransportException && randomBoolean();
    to validate the backwards compatibility for the deprecated method masterOperation(with task parameter). */
            "local_node",
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueHours(1));
                    throw new Exception("Different exception");
            capturedRequests = transport.getCapturedRequestsAndClear();
            }
            return null; // default implementation, overridden in specific tests
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(0));
    public static void afterClass() {
        }
        assertEquals(
                // simulate cluster-manager restart followed by a state recovery - this will reset the cluster state version
            DiscoveryNodeRole.BUILT_IN_ROLES,
            assertThat(capturedRequest.action, equalTo("internal:testAction"));
import java.util.concurrent.atomic.AtomicBoolean;
            return ThreadPool.Names.SAME;
        }
import java.util.concurrent.ExecutionException;
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, new DiscoveryNode[] { localNode }));
                fail("Expected exception but returned proper result");
import org.opensearch.action.support.ThreadedActionListener;
    private CapturingTransport transport;
    class Action extends TransportClusterManagerNodeAction<Request, Response> {
            }
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
        when(
            .thenReturn(buildClusterState(state, state.term() + 1, state.version() + 1));
    public void testFetchFromRemoteStore() throws InterruptedException, BrokenBarrierException, ExecutionException, IOException {
            "local_node",
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
            "remote_node",
import org.opensearch.core.common.io.stream.StreamInput;
            "remote_node",
            @Override
    }
        // Simulate a ConnectTransportException on the GetTermVersion request
import org.opensearch.node.remotestore.RemoteStoreNodeService;
            new AllocationDeciders(Collections.singleton(new MaxRetryAllocationDecider())),
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
            .put(
            version2 // not same as discoveryNode1
        if (clusterManagerOperationFailure) {
    public void testClusterManagerFailoverAfterStepDown() throws ExecutionException, InterruptedException {
            buildNewFakeTransportAddress(),
        assertThat(capturedRequests.length, equalTo(1));
        );
                setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
            }
            UUIDs.base64UUID(),
        // mixed cluster (containing both remote and non-remote nodes)
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
import org.opensearch.test.OpenSearchTestCase;
        listener.get();
        }.execute(request, listener);
            } catch (ExecutionException ex) {
                fail("Expected exception but returned proper result");
        }
                } else {
            assertTrue(listener.isDone());
                callCount[0]++;
        listener.get();
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(60));
        Map<String, String> remoteStoreNodeAttributes = new HashMap<>();
    }
    public void testStepDownToNoMasterThenNewMasterElected() throws ExecutionException, InterruptedException {
        assertFalse(retried.get());
        final boolean clusterManagerOperationFailure = randomBoolean();
            .blocks(ClusterBlocks.builder().addGlobalBlock(block))
            new BalancedShardsAllocator(Settings.EMPTY),
        }
    private TransportService transportService;
        }
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
        @Override
                    listener.onFailure(new FailedToCommitClusterStateException("Fake error"));
            capturedRequest = capturedRequests[0];
            EmptyClusterInfoService.INSTANCE,
            Version.CURRENT
                nodesBuilder.add(clusterManagerNode);
                fail("Expected exception but returned proper result");
            return identity == response.identity;
        DiscoveryNode discoveryNode1 = new DiscoveryNode(
                listener.get();
        assertThat(capturedRequest.request, equalTo(request));
            Collections.emptyMap(),
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
        Settings currentCompatibilityModeSettings = Settings.builder()
        protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener) throws Exception {
            }
        if (retryableBlock) {
        );
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        assertThat(capturedRequest.request, equalTo(request));
            NoopTracer.INSTANCE
                assertThat(es.getHeader("header"), equalTo(t.getHeader("header")));
            } catch (ExecutionException ex) {
                if (exception.getAndSet(false)) {
            // remove unneeded threading by wrapping listener with SAME to prevent super.doExecute from wrapping it with LISTENER
import org.opensearch.cluster.node.DiscoveryNodeRole;
        // The request should now be forwarded to the new master
        transportService = transport.createTransportService(
                listener.get();
            buildNewFakeTransportAddress(),
        } else {
            clusterService.getSettings(),
            new ActionFilters(Collections.emptySet()),
public class TransportClusterManagerNodeActionTests extends OpenSearchTestCase {
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
        assertListenerThrows("ClusterManagerNotDiscoveredException should be thrown", listener, ClusterManagerNotDiscoveredException.class);
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
    }
            "remote_node",
        );
        assertThat(capturedRequests.length, equalTo(1));
        assertTrue(listener.isDone());
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(60));
            "local_node",
import org.opensearch.test.gateway.TestGatewayAllocator;
        Request request = new Request();
        if (clusterManagerOperationFailure) {
        new Action("internal:testAction", transportService, clusterService, threadPool) {
        return ClusterState.builder(state).version(version).metadata(newMetadata).build();
            ThreadPool threadPool,
        assertTrue(listener.isDone());
        transport = new CapturingTransport();
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        final Response response = new Response();
        );
        DiscoveryNode localNode = new DiscoveryNode(
        transport.handleRemoteError(capturedRequest.requestId, new ConnectTransportException(remoteNode, "Fake connection error"));
                clusterManagerNode = new DiscoveryNode(
            } catch (ExecutionException ex) {
                    listener.onResponse(response);
                }
            clusterService,
            .add(nonRemoteNode1)
            .add(discoveryNode2)
import org.opensearch.gateway.remote.ClusterMetadataManifest;
            .build();
        }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
                        throw new AssertionError();
            Collections.singleton(DiscoveryNodeRole.MASTER_ROLE),
            } catch (ExecutionException ex) {
            @Override
            );
            buildNewFakeTransportAddress(),
        assertTrue(retried.get());
import org.opensearch.common.settings.Settings;
        setState(clusterService, ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes)).version(10));
        ClusterMetadataManifest manifest = ClusterMetadataManifest.builder()
                // ZenDiscovery
        Request request = new Request();
        request.persistentSettings(intendedCompatibilityModeSettings);
            if (o == null || getClass() != o.getClass()) return false;
        final Exception exception = new Exception();
        }
    public void testClusterManagerNotAvailable() throws ExecutionException, InterruptedException {
            .localNodeId(remoteNode1.getId())
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueHours(1));
                throws Exception {
        );
        transport.handleRemoteError(
            this(actionName, transportService, clusterService, threadPool);
        assertTrue(listener.isDone());
            }
        DiscoveryNode nonRemoteNode2 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
                } else {
    public void testExecuteOnClusterManagerHandlesNodeClosedException() throws ExecutionException, InterruptedException {
        assertTrue(capturedRequest.node.isClusterManagerNode());
        setState(clusterService, ClusterStateCreationUtils.state(localNode, null, allNodes));
        discoveryNodes = DiscoveryNodes.builder()
                    // If called second time due to retry, throw exception
        assertTrue(listener.isDone());
        new Action("internal:testAction", transportService, clusterService, threadPool) {
            // use a random base version so it can go down when simulating a restart.
            protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener)
        assertThat(listener.get(), equalTo(response));
                listener.onFailure(failure);
        Request request = new Request();
        } else if (failsWithConnectTransportException) {
import org.opensearch.action.support.clustermanager.term.GetTermVersionResponse;
        );
        }
    public void testDeprecatedMasterOperationWithTaskParameterCanBeCalled() throws ExecutionException, InterruptedException {
                    .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        Settings intendedCompatibilityModeSettings = Settings.builder()
            new TestGatewayAllocator(),
            .add(remoteNode1)
            clusterService,
            clusterService.getClusterSettings(),
                eq(state.version() + 1)
import org.opensearch.action.support.PlainActionFuture;
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
                setState(clusterService, builder.version(0));
                    listener.onFailure(exception);
        try {
        // that the predicate recognizes as newer than the original
        };
            UUIDs.base64UUID(),
            RemoteClusterStateService clusterStateService
            Version.CURRENT
    }
        AtomicBoolean retried = new AtomicBoolean(false);
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
            .metadata(createIndexMetadataWithRemoteStoreSettings("test"))
    public void testThrottlingRetryRemoteMaster() throws ExecutionException, InterruptedException {
    }
        Map<String, String> attributes = new HashMap<>();
        assertNotNull(listener.get());
        assertFalse(listener.isDone());
        );
            // very lightweight operation in memory, no need to fork to a thread
import org.opensearch.gateway.remote.RemoteClusterStateService;
import org.opensearch.cluster.service.ClusterService;
package org.opensearch.action.support.clustermanager;
            capturedRequest.requestId,
        assertTrue(listener.isDone());
            @Override
            .localNodeId(nonRemoteNode2.getId())
            assertTrue(listener.isDone());
                return blocks.isEmpty() ? null : new ClusterBlockException(blocks);
                    .blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK)
        }.execute(request, listener);
        // No transport request yet, waiting for a master to appear
 * GitHub history for details.
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
            "local_node",
        // Set initial state with a higher base version so re-election produces a version
            .add(discoveryNode1)
            .build();
        );
            x -> clusterService.localNode(),
        discoveryNodes = DiscoveryNodes.builder()
                if (throwExceptionOnRetry == false || blocks.isEmpty()) {
        );
        Metadata metadata = Metadata.builder().persistentSettings(currentCompatibilityModeSettings).build();
            setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
        GetTermVersionResponse termResp = new GetTermVersionResponse(
        );
                    // First call: master steps down, no new master yet
        transportService.acceptIncomingRequests();
            buildNewFakeTransportAddress(),
        if (retryableBlock && unblockBeforeTimeout) {
            )
        assertFalse(listener.isDone());
        // Should have re-executed locally and succeeded
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
        assertThat(capturedRequests.length, equalTo(1));
        final Response response = new Response();
        // cluster with only non-remote nodes
        );
        // The action should now be waiting for a new master via the observer
            listener.get();
    public void testDontAllowSwitchingCompatibilityModeForClusterWithMultipleVersions() {
import java.util.Collections;
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.routing.allocation.AllocationService;
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
            Collections.singleton(DiscoveryNodeRole.MASTER_ROLE),
            listener.onResponse(new Response()); // default implementation, overridden in specific tests
    }
        DiscoveryNode[] allNodes = new DiscoveryNode[] { localNode, remoteNode };
        remoteStoreNodeAttributes.put(REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-translog-repo-1");
            assertThat(listener.get(), equalTo(response));
            @Override
            exception.getMessage()
        final Exception exception = new Exception();
    }
                    listener.onResponse(response);
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
            String actionName,
        transportService.start();
        attributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "repo1");
                }
    private DiscoveryNode localNode;
import org.opensearch.cluster.ClusterState;
            clusterService,
            protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener)
                }
    }
            ClusterService clusterService,
        DiscoveryNode remoteNode2 = new DiscoveryNode(
import java.util.HashSet;
        transport.handleResponse(capturedRequest.requestId, response);
        // cluster with only non-remote nodes
            assertThat(capturedRequest.request, equalTo(request));
                assertThat(ex.getCause(), equalTo(exception));
            buildNewFakeTransportAddress(),
        );
        discoveryNodes = DiscoveryNodes.builder()
            new ClusterStateTermVersion(state.getClusterName(), state.metadata().clusterUUID(), state.term() + 1, state.version() + 1),
        }.execute(request, listener);
                if (clusterManagerOperationFailure) {
        new Action("internal:testAction", transportService, clusterService, threadPool) {
        public void writeTo(StreamOutput out) throws IOException {
            .put(REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(), RemoteStoreNodeService.CompatibilityMode.MIXED)
            // use a random base version so it can go down when simulating a restart.
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        ClusterState sameTypeClusterState = ClusterState.builder(clusterState).nodes(discoveryNodes).metadata(metadata).build();
            SettingsException.class,
        TransportClusterManagerNodeAction action = new Action("internal:testAction", transportService, clusterService, threadPool) {
            "remote_node",
                assertThat(es.getMessage(), equalTo(t.getMessage()));
            assertThat(listener.get(), equalTo(response));
        }
                throws Exception {
        remoteStoreNodeAttributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-cluster-repo-1");
            }
            try {
        Response response = new Response();
            transportService,
import org.opensearch.common.settings.SettingsException;
        );
        @Override
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
     * and the request is eventually forwarded to a new master.
            .blocks(ClusterBlocks.builder().addGlobalBlock(block))
import org.opensearch.cluster.block.ClusterBlock;
            toStrictMode ? getRemoteStoreNodeAttributes() : Collections.emptyMap(),
        setState(clusterService, ClusterStateCreationUtils.state(localNode, null, allNodes));
        // changing compatibility mode when all nodes are not of the same version
        remoteNode = new DiscoveryNode(
        DiscoveryNode nonRemoteNode1 = new DiscoveryNode(UUIDs.base64UUID(), buildNewFakeTransportAddress(), Version.CURRENT);
                final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterService.state().nodes());
        // waiting for retry to trigger
        setState(clusterService, ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes)).version(11));
        assertThat(transport.capturedRequests().length, equalTo(1));
                final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterService.state().nodes());
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.action.admin.cluster.settings.TransportClusterUpdateSettingsAction;
        sameTypeClusterState = ClusterState.builder(sameTypeClusterState).nodes(discoveryNodes).metadata(metadata).build();
        public boolean equals(Object o) {
                throws Exception {
        transport.handleResponse(capturedRequest.requestId, response);
        // request to change cluster compatibility mode to STRICT
                    setState(clusterService, ClusterStateCreationUtils.state(localNode, null, allNodes));
            SettingsException.class,
            .add(discoveryNode2)
            EmptySnapshotsInfoService.INSTANCE
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        remoteStoreNodeAttributes.put(REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "my-segment-repo-1");
            buildNewFakeTransportAddress(),
            t.addHeader("header", "is here");
        @Override
                } else {
            buildNewFakeTransportAddress(),
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueHours(1));
        setState(clusterService, ClusterStateCreationUtils.state(localNode, randomFrom(localNode, remoteNode, null), allNodes));
        );
                nodesBuilder.clusterManagerNodeId(clusterManagerNode.getId());
        Settings currentCompatibilityModeSettings = Settings.builder()
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).nodes(discoveryNodes).build();
import org.opensearch.Version;
        CoordinationMetadata.Builder coordMetadataBuilder = CoordinationMetadata.builder().term(term);
            }
                }
                    try {
            exception.getMessage(),
import org.opensearch.cluster.block.ClusterBlockLevel;
    // Validate TransportMasterNodeAction.testDelegateToClusterManager() works correctly on node with the deprecated MASTER_ROLE.
                    throw new AssertionError("Should not retry for other exception");
        TransportClusterUpdateSettingsAction transportClusterUpdateSettingsAction = new TransportClusterUpdateSettingsAction(
            attributes,
        }
        assertFalse(listener.isDone());
    private DiscoveryNode[] allNodes;
        TransportClusterManagerNodeAction action = new Action("internal:testAction", transportService, clusterService, threadPool);
        assertThat(
        // The first captured request is the GetTermVersion request to the remote master
        transport.handleResponse(capturedRequest.requestId, response);
        new Action("internal:testAction", transportService, clusterService, threadPool) {
            Version.CURRENT
        Metadata newMetadata = Metadata.builder().coordinationMetadata(coordMetadataBuilder.build()).build();
import org.opensearch.core.rest.RestStatus;
        // Elect localNode as the new master — this triggers the observer and re-executes locally
            transport.handleRemoteError(capturedRequest.requestId, t);
 * The OpenSearch Contributors require contributions made to
                assertThat(ex.getCause(), equalTo(exception));
            return localExecuteSupported;
import java.util.Set;
        transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, sameTypeClusterState);
            null,
                    clusterManagerNode.getAddress(),
    }
        }.execute(request, listener);
 */
        return remoteStoreNodeAttributes;
        setState(
import static org.hamcrest.Matchers.instanceOf;
import org.opensearch.cluster.NotClusterManagerException;
    /**
                new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
            assertThat(capturedRequests.length, equalTo(1));
                    // Second call: we're master again, succeed
        AtomicBoolean exception = new AtomicBoolean(true);
            super(
            Collections.emptyMap(),
        assertThat(capturedRequest.request, equalTo(request));
            @Override
        RemoteClusterStateService remoteClusterStateService = Mockito.mock(RemoteClusterStateService.class);
        Request request = new Request();
        metadata = createIndexMetadataWithRemoteStoreSettings("test-index");
        // Should be waiting for a new master
        );
            return Objects.hash(identity);
            .build();
        Response response = new Response();
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
            try {
        assertThat(callCount[0], equalTo(2));
            transport.handleRemoteError(
        AtomicBoolean exception = new AtomicBoolean(true);
        );
        if (throwExceptionOnRetry == false) {
        }
import static org.mockito.Mockito.when;
import java.util.concurrent.BrokenBarrierException;
        Action(String actionName, TransportService transportService, ClusterService clusterService, ThreadPool threadPool) {
}
        ClusterBlock block = new ClusterBlock(1, "", true, true, false, randomFrom(RestStatus.values()), ClusterBlockLevel.ALL);
        }
import static org.hamcrest.Matchers.containsString;
            .build();
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
            getRemoteStoreNodeAttributes(),
        }
                assertThat(ex.getCause().getCause(), instanceOf(ClusterBlockException.class));
                throws Exception {
import org.opensearch.transport.TransportService;
        Request request = new Request();
    private DiscoveryNode remoteNode;
        );
        DiscoveryNode clusterManagerNode = this.remoteNode;
                Set<ClusterBlock> blocks = state.blocks().global();
                listener.get();
        ClusterBlock block = new ClusterBlock(1, "", retryableBlock, true, false, randomFrom(RestStatus.values()), ClusterBlockLevel.ALL);
            fail(msg);
            );
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, new DiscoveryNode[] { localNode }));
        );
import org.opensearch.cluster.ClusterName;
                }
        ClusterState stateWithBlock = ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes))
        setState(clusterService, ClusterStateCreationUtils.state(localNode, remoteNode, allNodes));
            return;
    }
        // request to change cluster compatibility mode
            Version.CURRENT
            protected ClusterBlockException checkBlock(Request request, ClusterState state) {
                eq(state.metadata().clusterUUID()),
        );
    public void testThrottlingRetryLocalMaster() throws InterruptedException, BrokenBarrierException {
            @Override
            .build();
            .build();
import org.opensearch.tasks.Task;
        discoveryNode2 = new DiscoveryNode(
        private boolean localExecuteSupported = false;
import org.mockito.Mockito;
        assertThat(listener.get(), equalTo(response));
                new ActionFilters(new HashSet<>()),
        Request request = new Request();
     * wrapped in a RemoteTransportException, the handleTransportException path correctly retries.
            .add(discoveryNode1)
        setState(clusterService, stateWithBlock);
import java.util.Objects;
    public void setUp() throws Exception {
                    clusterManagerNode.getVersion()
            out.writeLong(identity);
                setState(clusterService, ClusterState.builder(clusterService.state()).nodes(nodesBuilder));
        action.execute(request, listener);
        CapturingTransport.CapturedRequest capturedRequest = capturedRequests[0];
            }
        AtomicBoolean retried = new AtomicBoolean(false);
        DiscoveryNode discoveryNode2 = new DiscoveryNode(
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
        final Response response = new Response();
        CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
                nodesBuilder.remove(clusterManagerNode);
        DiscoveryNode remoteNode = new DiscoveryNode(
        protected void doExecute(Task task, final Request request, ActionListener<Response> listener) {
import static org.hamcrest.Matchers.equalTo;
        setState(
    public static class Request extends ClusterManagerNodeRequest<Request> {
        action.execute(request, listener);
        }
        final Response response = new Response();
        } else {
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
        // mismatch term and version
        capturedRequests = transport.getCapturedRequestsAndClear();
            Collections.emptyMap(),
        assertTrue(listener.isDone());
    @After
            }
            assertFalse(listener.isDone());
        assertThat(transport.capturedRequests().length, equalTo(1));
            assertThat(ex.getCause(), instanceOf(klass));
        final boolean unblockBeforeTimeout = randomBoolean();
            version1
        Thread.sleep(10000);
    }
        assertTrue(listener.isDone());
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY;
                actionName,
            }
            .metadata(metadata)
        assertThat(transport.capturedRequests().length, equalTo(0));
        transport.handleRemoteError(capturedRequest.requestId, new NodeClosedException(remoteNode));
            protected void clusterManagerOperation(Request request, ClusterState state, ActionListener<Response> listener)
        super.setUp();
                    throw new RuntimeException("checkBlock has thrown exception");
        assertThat(transport.capturedRequests().length, equalTo(0));
            return null;
            assertTrue(capturedRequest.node.isClusterManagerNode());
            ClusterState.builder(ClusterStateCreationUtils.state(localNode, masterNode, new DiscoveryNode[] { localNode, masterNode }))
                    ? new ConnectTransportException(clusterManagerNode, "Fake error")
import java.util.concurrent.TimeUnit;
        Action action = new Action("internal:testAction", transportService, clusterService, threadPool, remoteClusterStateService);
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        Request request = new Request();
                    listener.onFailure(exception);
            .build();
    public void testClusterManagerBecomesAvailable() throws ExecutionException, InterruptedException {
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
 */
 * Modifications Copyright OpenSearch Contributors. See
        final SettingsException exception = expectThrows(
        CapturingTransport.CapturedRequest capturedRequest = transport.capturedRequests()[0];
                return new ClusterBlockException(blocks);
                .version(randomIntBetween(0, 10))
            clusterService.getClusterSettings(),
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            UUIDs.base64UUID(),
        private long identity = randomLong();
        }
        capturedRequest = capturedRequests[0];
                final ClusterState.Builder builder = ClusterState.builder(clusterService.state()).nodes(nodesBuilder);
            Response response = (Response) o;
    public void testClusterStateLatestCheckerHandlesTransportException() throws ExecutionException, InterruptedException {
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(60));
        boolean toStrictMode = randomBoolean();
import org.opensearch.cluster.coordination.CoordinationMetadata;
            this.remoteClusterStateService = clusterStateService;
/*
            buildNewFakeTransportAddress(),
        assertThat(transport.capturedRequests().length, equalTo(1));
            EmptyClusterInfoService.INSTANCE,
            }
                clusterService,
        assertTrue(listener.isDone());
import static org.opensearch.index.remote.RemoteMigrationIndexMetadataUpdaterTests.createIndexMetadataWithRemoteStoreSettings;
        CyclicBarrier barrier = new CyclicBarrier(2);
        assertTrue(listener.isDone());
    private static ThreadPool threadPool;
        action.execute(request, listener);
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    public void testForceLocalOperation() throws ExecutionException, InterruptedException {
import static org.opensearch.node.remotestore.RemoteStoreNodeAttribute.REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY;
                        retried.set(true);
        attributes.put(REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "repo2");
        assertFalse(listener.isDone());
        Response() {}
            assertListenerThrows("checkBlock has thrown exception", listener, RuntimeException.class);
        );
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    public void testDelegateToClusterManagerOnNodeWithDeprecatedMasterRole() throws ExecutionException, InterruptedException {
            buildNewFakeTransportAddress(),
    public void testLocalOperationWithBlocks() throws ExecutionException, InterruptedException {
        } else {
    public void testCheckBlockThrowsException() throws InterruptedException {
        // Waiting for a master, no transport request, not done yet
                transportService,
                final DiscoveryNodes.Builder nodesBuilder = DiscoveryNodes.builder(clusterService.state().nodes());
            listener.get();
            listener.get();
        final boolean clusterManagerOperationFailure = randomBoolean();
            transportService,
        threadPool = null;
    }
            Version.CURRENT
import org.opensearch.snapshots.EmptySnapshotsInfoService;
                return true;
        } else {
        CyclicBarrier barrier = new CyclicBarrier(2);
        clusterService = createClusterService(threadPool);
import org.opensearch.cluster.routing.allocation.decider.MaxRetryAllocationDecider;
            .localNodeId(nonRemoteNode1.getId())
        @Override
            protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener) {
import org.opensearch.common.action.ActionFuture;
        transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, sameTypeClusterState);
        new Action("internal:testAction", transportService, clusterService, threadPool) {
    }
    private ClusterService clusterService;
            toStrictMode ? getRemoteStoreNodeAttributes() : Collections.emptyMap(),
    }
                } else {
        }
            buildNewFakeTransportAddress(),
                // Master steps down but no new master elected yet (master = null)
            assertFalse(listener.isDone());
    @BeforeClass
            .add(remoteNode1)
        ) {
                eq(state.term() + 1),
import org.opensearch.discovery.ClusterManagerNotDiscoveredException;
    @Before
            Collections.emptyMap(),
    }
        listener.get();
        Settings intendedCompatibilityModeSettings = Settings.builder()
        assertThat(transport.capturedRequests().length, equalTo(1));
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
            Version.CURRENT
            }
                nodesBuilder.clusterManagerNodeId(null);
            .localNodeId(discoveryNode2.getId())
        boolean throwExceptionOnRetry = randomBoolean();
        localNode = new DiscoveryNode(
                    : new NotClusterManagerException("Fake error");
        action.execute(request, listener);
        @Override
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
                    clusterManagerNode.getId(),
        super.tearDown();
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            Collections.emptySet(),
                if (clusterManagerOperationFailure) {
        };
            assertListenerThrows("ClusterBlockException should be thrown", listener, ClusterBlockException.class);
    public void testLocalOperationWithoutBlocks() throws ExecutionException, InterruptedException {
import org.opensearch.core.common.io.stream.StreamOutput;
    }
            )
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(unblockBeforeTimeout ? 60 : 0));
        public int hashCode() {
            EmptySnapshotsInfoService.INSTANCE
                Set<ClusterBlock> blocks = state.blocks().global();
        protected String executor() {
            @Override
/*
        Request request = new Request();
        CapturingTransport.CapturedRequest capturedRequest = capturedRequests[0];
        assertThat(transport.capturedRequests().length, equalTo(1));
        TransportClusterUpdateSettingsAction transportClusterUpdateSettingsAction = new TransportClusterUpdateSettingsAction(
 *
                assertThat(cause, instanceOf(OpenSearchException.class));
        assertTrue(capturedRequest.node.isClusterManagerNode());
            super.doExecute(task, request, new ThreadedActionListener<>(logger, threadPool, ThreadPool.Names.SAME, listener, false));
        Map<String, String> attributes = new HashMap<>();
                // reset the same state to increment a version simulating a join of an existing node
        }
    public void testDontAllowSwitchingToStrictCompatibilityModeForMixedCluster() {
                ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes))
        );
        transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, sameVersionClusterState);
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
        assertTrue(capturedRequest.node.isClusterManagerNode());
            .build();
import org.opensearch.cluster.EmptyClusterInfoService;
            .add(nonRemoteNode1)
        }
    /* The test is copied from testLocalOperationWithoutBlocks()
            DiscoveryNodeRole.BUILT_IN_ROLES,
        final SettingsException exception = expectThrows(
                fail("Expected exception but returned proper result");
            DiscoveryNodeRole.BUILT_IN_ROLES,
            threadPool,
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
        assertTrue(capturedRequest.node.isClusterManagerNode());
        Request request = new Request().clusterManagerNodeTimeout(TimeValue.timeValueSeconds(failsWithConnectTransportException ? 60 : 0));
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
            () -> transportClusterUpdateSettingsAction.validateCompatibilityModeSettingRequest(request, differentVersionClusterState)
    public void testDelegateToClusterManager() throws ExecutionException, InterruptedException {
        Response(StreamInput in) throws IOException {
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
            } else {
            allocationService,
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest;
import org.opensearch.core.action.ActionListener;
        action.execute(request, listener);
        barrier.await();
        allNodes = new DiscoveryNode[] { localNode, remoteNode };
        assertTrue(capturedRequest.node.isClusterManagerNode());
                if (callCount[0] == 1) {
import org.opensearch.cluster.coordination.ClusterStateTermVersion;
                randomBoolean()
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
import org.opensearch.threadpool.ThreadPool;
            new ClusterManagerThrottlingException("Throttling Exception : Limit exceeded for test")
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        DiscoveryNode remoteNode1 = new DiscoveryNode(
            protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener) {
        assertThat(listener.get(), equalTo(response));
        assertTrue(capturedRequest.node.isClusterManagerNode());
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
    public static void beforeClass() {
        assertTrue(listener.isDone());
                eq(state.getClusterName().value()),
        assertThat(capturedRequest.request, equalTo(request));
                    .build()
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        // no more transport calls
import org.opensearch.common.UUIDs;
            return new Response(in);
                capturedRequest.requestId,
    public void testDelegateToFailingClusterManager() throws ExecutionException, InterruptedException {
        assertFalse(listener.isDone());
                // The other node has become cluster-manager, simulate failures of this node while publishing cluster state through
        ClusterUpdateSettingsRequest request = new ClusterUpdateSettingsRequest();
        AllocationService allocationService = new AllocationService(
        attributes.put(REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "repo1");
            allocationService,
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
            ClusterState.builder(ClusterStateCreationUtils.state(localNode, clusterManagerNode, allNodes)).version(randomIntBetween(0, 10))
            .build();
            protected void clusterManagerOperation(Task task, Request request, ClusterState state, ActionListener<Response> listener)
    void assertListenerThrows(String msg, ActionFuture<?> listener, Class<?> klass) throws InterruptedException {
    }
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
import java.util.concurrent.CyclicBarrier;
        when(remoteClusterStateService.getClusterStateForManifest(state.getClusterName().value(), manifest, localNode.getId(), true))
        TransportClusterManagerNodeAction action = new Action("internal:testAction", transportService, clusterService, threadPool) {
    }
        ClusterState differentVersionClusterState = ClusterState.builder(ClusterName.DEFAULT)
        );
            try {
        Request() {}
            }
            "can not switch to STRICT compatibility mode when the cluster contains both remote and non-remote nodes",
            OpenSearchException t = new OpenSearchException("test");
        new Action("internal:testAction", transportService, clusterService, threadPool) {
        public boolean localExecuteSupportedByAction() {
            .localNodeId(nonRemoteNode1.getId())
        final boolean retryableBlock = randomBoolean();
    }
            attributes,
        DiscoveryNodes discoveryNodes = DiscoveryNodes.builder()
        setState(clusterService, ClusterStateCreationUtils.state(localNode, localNode, allNodes));
        Action action = new Action("internal:testAction", transportService, clusterService, threadPool, remoteClusterStateService);
            .clusterTerm(state.term() + 1)
            .add(remoteNode2)
            transport.handleRemoteError(capturedRequest.requestId, new ConnectTransportException(clusterManagerNode, "Fake error"));
        protected ClusterBlockException checkBlock(Request request, ClusterState state) {
            buildNewFakeTransportAddress(),
            .build();
    }
            Version.CURRENT
                ClusterState.builder(ClusterStateCreationUtils.state(localNode, localNode, allNodes))
                    }
            .stateVersion(state.version() + 1)
        attributes.put(REMOTE_STORE_ROUTING_TABLE_REPOSITORY_NAME_ATTRIBUTE_KEY, "repo2");
                threadPool,
import org.opensearch.test.transport.CapturingTransport;
            Version.CURRENT
        protected Response read(StreamInput in) throws IOException {
            clusterService,
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
                        barrier.await();
        );
                REMOTE_STORE_COMPATIBILITY_MODE_SETTING.getKey(),
        ClusterState state = clusterService.state();
            .build();
        CapturingTransport.CapturedRequest capturedRequest = capturedRequests[0];
            containsString("can not change the compatibility mode when all the nodes in cluster are not of the same version")
            setState(
            @Override
        assertTrue(listener.isDone());
import org.opensearch.common.unit.TimeValue;
            getRemoteStoreNodeAttributes(),
        assertTrue(listener.isDone());
            toStrictMode ? getRemoteStoreNodeAttributes() : Collections.emptyMap(),
            if (randomBoolean()) {
        new Action("internal:testAction", transportService, clusterService, threadPool) {
        // changing compatibility mode when all nodes are of the same version
import org.junit.BeforeClass;
        );
        PlainActionFuture<Response> listener = new PlainActionFuture<>();
    public void tearDown() throws Exception {
            identity = in.readLong();
                    .build()
                }
        );
        assertThat(capturedRequest.request, equalTo(request));
        DiscoveryNode masterNode = this.remoteNode;
        new Action("internal:testAction", transportService, clusterService, threadPool).execute(request, listener);
        @Override
            }
                listener.onFailure(new NotClusterManagerException("Fake error"));
        assertThat(capturedRequest.action, equalTo("internal:testAction"));
            );
            Settings.EMPTY
            new TestGatewayAllocator(),
                final Throwable cause = ex.getCause().getCause();
    }
