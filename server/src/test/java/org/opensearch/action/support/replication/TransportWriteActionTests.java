            if (state.metadata().hasIndex(index.getName())) {
            );
                TestRequest::new,
            ActionListener.wrap(r -> success.set(true), failure::set)
        @SuppressWarnings({ "unchecked", "rawtypes" })
            refreshListener.getValue().accept(forcedRefresh);
        @Override
                shardFailedRequest.requestId,
        TestRequest request = new TestRequest();
        AtomicBoolean success = new AtomicBoolean();
        ShardStateAction shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        assertNull(listener.response); // Haven't responded yet
        if (randomBoolean()) {
            ShardRoutingState.RELOCATING
                return replicaResult;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.indices.SystemIndices;
        @Override
            x -> clusterService.localNode(),
import static org.mockito.Mockito.never;
                clusterService,
            result.runPostReplicationActions(ActionListener.map(listener, ignore -> result.finalResponseIfSuccessful));
        }).when(indexShard).acquirePrimaryOperationPermit(any(ActionListener.class), anyString(), any());
        }
 * this file be licensed under the Apache-2.0 license or a
        ) {
        return indexService;
            assertNull(listener.failure);
            return "TestRequest{}";
        // the shard the request was sent to and the shard to be failed should be the same
                routingState == ShardRoutingState.RELOCATING ? state.nodes().iterator().next().getId() : null,
                } else {
        final TransportReplicationAction.ReplicaResult result = future.actionGet();
        }
        testAction.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
        clusterService.close();
                    replicaResult = new WriteReplicaResult<>(request, null, new RuntimeException("simulated"), replica, logger);
        refreshListener.getValue().accept(forcedRefresh);
import org.opensearch.OpenSearchException;
 * not use this file except in compliance with the License.
                null,
import java.util.HashSet;
        // A write replication action proxy should fail the shard
import java.util.concurrent.atomic.AtomicReference;
                    Settings.EMPTY,
    private class TestAction extends TransportWriteAction<TestRequest, TestRequest, TestResponse> {
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[0];
import org.opensearch.action.support.PlainActionFuture;
    }
            Index index = (Index) invocation.getArguments()[0];
            randomNonNegativeLong(),
        protected void dispatchedShardOperationOnPrimary(
                new ActionFilters(new HashSet<>()),
    @After
        try {
            assertNull(listener.response); // Haven't really responded yet
                }
            if (term < primaryTerm) {
                ignore -> ThreadPool.Names.SAME,
                if (withDocumentFailureOnPrimary) {
    public void testReplicaNoRefreshCall() throws Exception {
            ClusterService clusterService,
            verify(indexShard).refresh("refresh_flag_index");
                false,
        verify(indexShard).refresh("refresh_flag_index");
    public void testDocumentFailureInShardOperationOnReplica() throws Exception {
/*
import org.opensearch.threadpool.ThreadPool;
        final ShardId shardId = new ShardId(index, "_na_", 0);
 * The OpenSearch Contributors require contributions made to
        proxy.performOn(
    }
        CapturingTransport.CapturedRequest[] captures = transport.getCapturedRequestsAndClear();
        protected TestAction(boolean withDocumentFailureOnPrimary, boolean withDocumentFailureOnReplica) {
        super.tearDown();
                mockIndicesService(clusterService),
        transportService.acceptIncomingRequests();
        ArgumentCaptor<Consumer<Boolean>> refreshListener = ArgumentCaptor.forClass((Class) Consumer.class);
 * KIND, either express or implied.  See the License for the
        });
    }
        }
    }
        CapturingActionListener<TransportResponse.Empty> listener = new CapturingActionListener<>();
        assertNotNull(listener.response);
            verify(indexShard, never()).refresh(any());
    private final AtomicBoolean isRelocated = new AtomicBoolean(false);
            ShardRoutingState.INITIALIZING,
 */
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            String actionName,
    public void initCommonMocks() {
        // Now we can fire the listener manually and we'll get a response
                "internal:test",
    private ClusterService clusterService;
        TestAction testAction = new TestAction();
import org.opensearch.indices.IndicesService;
import org.opensearch.cluster.routing.ShardRoutingState;
                null,
                TestRequest::new,
        indexShard = mock(IndexShard.class);
            // simulate the primary has been demoted
 * Unless required by applicable law or agreed to in writing,
            final ClusterState state = clusterService.state();
            primaryTerm,
                    null,
 * this work for additional information regarding copyright
        assertNull(listener.failure);
                new SystemIndices(emptyMap()),
    public void testPrimaryNoRefreshCall() throws Exception {
        public String toString() {
        } else {
            assertThat(listener.get(), equalTo(response));
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> future = PlainActionFuture.newFuture();
                "NOT THERE",
            this(false, false);
 * the Apache License, Version 2.0 (the "License"); you may
                new ShardStateAction.NoLongerPrimaryShardException(replica.shardId(), "shard-failed-test")
 * You may obtain a copy of the License at
        doThrow(new AssertionError("failed shard is not supported")).when(indexShard).failShard(anyString(), any(Exception.class));
        private R response;
            assertFalse(success.get());
                throw new ShardNotFoundException(shardId);
            return new TestResponse();
        @Override
            this.forcedRefresh = forcedRefresh;
import static org.mockito.Mockito.when;
            this.withDocumentFailureOnReplica = withDocumentFailureOnReplica;
import org.opensearch.action.support.WriteResponse;
        } else if (randomBoolean()) {
        }
        }
        assertNotNull(listener.response);
            CapturingActionListener<TestResponse> listener = new CapturingActionListener<>();
    public static void beforeClass() {
    public void testReplicaWaitForRefresh() throws Exception {
    private Translog.Location location;
        doAnswer(invocation -> {
                threadPool,
            final IndexMetadata indexSafe = state.metadata().getIndexSafe(index);
                TestRequest::new,
        testAction.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
 * GitHub history for details.
import org.junit.After;
                randomLong()
 * Licensed to Elasticsearch under one or more contributor
        }
            });
        boolean forcedRefresh = randomBoolean();
        TestRequest request = new TestRequest();
        result.runPostReplicaActions(ActionListener.map(listener, ignore -> TransportResponse.Empty.INSTANCE));
            assertNotNull(failure.get());
        }
            CapturingActionListener<TestResponse> listener = new CapturingActionListener<>();
import org.opensearch.action.support.ActionTestUtils;
            this.withDocumentFailureOnReplica = false;
            ActionListener.completeWith(listener, () -> {
            Settings.EMPTY,
            final ClusterState state = clusterService.state();
            verify(indexShard, never()).addRefreshListener(any(), any());
            result.runPostReplicationActions(ActionListener.map(listener, ignore -> result.finalResponseIfSuccessful));
            super(
        }
    public void testDocumentFailureInShardOperationOnPrimary() throws Exception {
                    mock(Transport.class),
            randomNonNegativeLong(),
import org.opensearch.core.common.io.stream.StreamInput;
        assertTrue(listener.isDone());
import org.opensearch.core.index.Index;
import java.util.concurrent.ExecutionException;
        assertNotNull(listener.failure);
        result.runPostReplicaActions(ActionListener.map(listener, ignore -> TransportResponse.Empty.INSTANCE));
import org.opensearch.threadpool.TestThreadPool;
        }
            super(in);
 */
        }
import org.opensearch.index.shard.IndexShard;
        assertEquals(shardEntry.getShardId(), replica.shardId());
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import org.junit.Before;
            count.incrementAndGet();
            assertNull(failure.get());
    final IndexService mockIndexService(final IndexMetadata indexMetadata, ClusterService clusterService) {
            );
        boolean forcedRefresh;
        protected TestAction() {
            assertEquals(forcedRefresh, listener.response.forcedRefresh);
                new IndexingPressureService(settings, clusterService),
        });
            i -> clusterService.state().metadata().getIndexSafe(shardId.getIndex()).primaryTerm(shardId.id())
    @Before
        ) {
import static org.mockito.Mockito.verify;
    }
        request.setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
public class TransportWriteActionTests extends OpenSearchTestCase {
        );
            "internal:testAction",
import org.opensearch.action.support.ActionFilters;
            return null;
        verify(indexShard, never()).addRefreshListener(any(), any());
        } else if (randomBoolean()) {
    public void testPrimaryImmediateRefresh() throws Exception {
        }
 */
            assertNotNull(listener.response);
    }
import org.opensearch.transport.Transport;
                new TransportService(
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.common.settings.Settings;
        );
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> future = PlainActionFuture.newFuture();
        TestRequest request = new TestRequest();
        );
            verify(indexShard).addRefreshListener(any(), refreshListener.capture());
                settings,
        assertListenerThrows("non existent node should throw a NoNodeAvailableException", listener, NoNodeAvailableException.class);
            final ClusterState state = clusterService.state();
                NoopTracer.INSTANCE
    private static class TestResponse extends ReplicationResponse implements WriteResponse {
            transport.handleRemoteError(captures[0].requestId, new OpenSearchException("simulated"));
            fail(msg);
            if (shard > indexMetadata.getNumberOfShards()) {
        final long primaryTerm = state.metadata().index(index).primaryTerm(0);
        ClusterServiceUtils.setState(clusterService, state);
                ),
        doAnswer(invocation -> {
    private IndexShard mockIndexShard(ShardId shardId, ClusterService clusterService) {
        CapturingActionListener<TransportResponse.Empty> listener = new CapturingActionListener<>();
        final IndexService indexService = mock(IndexService.class);
    }
            replica,
        clusterService = createClusterService(threadPool);
        request.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
            threadPool,
    public void testReplicaProxy() throws InterruptedException, ExecutionException {
            // Now we can fire the listener manually and we'll get a response
            callback.onResponse(count::decrementAndGet);
            assertFalse(success.get());
    final IndicesService mockIndicesService(ClusterService clusterService) {
        testAction.dispatchedShardOperationOnReplica(request, indexShard, future);
        result.runPostReplicaActions(ActionListener.map(listener, ignore -> TransportResponse.Empty.INSTANCE));
 * software distributed under the License is distributed on an
    private final AtomicInteger count = new AtomicInteger(0);
 *
import static org.hamcrest.Matchers.equalTo;
            );
            return mockIndexShard(shardId, clusterService);
        }));
        assertNotNull(listener.response);
        testAction.dispatchedShardOperationOnReplica(request, indexShard, future);
        TestAction testAction = new TestAction();
        TestRequest request = new TestRequest();
                ignore -> ThreadPool.Names.SAME,
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.TimeUnit;
        listener = new PlainActionFuture<>();
            this.withDocumentFailureOnPrimary = withDocumentFailureOnPrimary;
        }));
                new ActionFilters(new HashSet<>()),
import java.util.Collections;
        TestRequest request = new TestRequest();
            @SuppressWarnings({ "unchecked", "rawtypes" })
        final String index = "test";
            assertTrue(listener.isDone());
            ShardRoutingState.STARTED,
            new TestRequest(),
        final TransportReplicationAction.ReplicaResult result = future.actionGet();
        TestAction testAction = new TestAction();
    @BeforeClass
            Collections.emptySet(),
                randomLong(),
            // simulated a node closing exception
        final IndexShard indexShard = mock(IndexShard.class);
import java.util.concurrent.atomic.AtomicBoolean;
    public void testReplicaImmediateRefresh() throws Exception {
        TestAction testAction = new TestAction(true, true);
    }
        CapturingTransport.CapturedRequest shardFailedRequest = shardFailedRequests[0];
        assertNull(listener.failure);
            Settings settings,
import org.opensearch.core.transport.TransportResponse;
    }
import org.opensearch.cluster.routing.TestShardRouting;
            );
        request.setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
                final WriteReplicaResult<TestRequest> replicaResult;
        proxy.performOn(replica, new TestRequest(), primaryTerm, randomNonNegativeLong(), randomNonNegativeLong(), listener);
import static java.util.Collections.emptyMap;
        // check that at unknown node fails
            assertNotNull(listener.response);
                return null;
        } else {
        assertEquals(1, shardFailedRequests.length);
            super(
import static org.mockito.Mockito.mock;
            transport.handleRemoteError(shardFailedRequest.requestId, new NodeClosedException(state.nodes().getLocalNode()));
            final RoutingNode node = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
        ReplicationOperation.Replicas<TestRequest> proxy = action.newReplicasProxy();
            listener.get();
            long term = (Long) invocation.getArguments()[0];
        verify(indexShard).addRefreshListener(any(), refreshListener.capture());
        );
        verify(indexShard, never()).addRefreshListener(any(), any());
        public void setForcedRefresh(boolean forcedRefresh) {
            result.runPostReplicationActions(ActionListener.map(listener, ignore -> result.finalResponseIfSuccessful));
import static org.mockito.Mockito.any;
            // simulate success
            null,
            ActionListener.completeWith(listener, () -> {
import org.opensearch.cluster.metadata.IndexMetadata;
            assertTrue(success.get());
        private Exception failure;
import java.util.Locale;
        );
                false,
            transport.handleResponse(captures[0].requestId, response);
                new IndexingPressureService(Settings.EMPTY, TransportWriteActionTests.this.clusterService),
import static org.hamcrest.Matchers.arrayWithSize;
                TestRequest::new,
        TestRequest request = new TestRequest();
/*
            assertNull(listener.response);
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        testAction.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
    @Override
import org.opensearch.test.ClusterServiceUtils;
import org.opensearch.test.transport.CapturingTransport;
            return routing;
import java.io.IOException;
                    return new WritePrimaryResult<>(request, null, null, new RuntimeException("simulated"), primary, logger);
import org.opensearch.index.shard.ShardNotFoundException;
        verify(indexShard, never()).refresh(any());
        TestAction testAction = new TestAction(randomBoolean(), true);
        @Override
            shardStateAction,
        final TransportReplicationAction.ReplicaResult result = future.actionGet();
        assertEquals(shardEntry.getAllocationId(), replica.allocationId().getId());
        public void onResponse(R response) {
    }
            this.failure = failure;
            transport.handleError(captures[0].requestId, new TransportException("simulated"));
        TestRequest(StreamInput in) throws IOException {
            shardRoutings.replicaShards().stream().filter(ShardRouting::assignedToNode).collect(Collectors.toList())
            super(new ShardId("test", "test", 1));
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> future = PlainActionFuture.newFuture();
import org.opensearch.node.NodeClosedException;
            IndexShard primary,
                    return new WritePrimaryResult<>(request, new TestResponse(), location, null, primary, logger);
            int shard = (Integer) invocation.getArguments()[0];
                Settings.EMPTY,
    public void tearDown() throws Exception {
            assertThat(ex.getCause(), instanceOf(klass));
        TestAction testAction = new TestAction();
                    String.format(Locale.ROOT, "%s operation term [%d] is too old (current [%d])", shardId, term, primaryTerm)
            Index index = (Index) invocation.getArguments()[0];
        verify(indexShard, never()).refresh(any());
                transportService,
    @AfterClass
        threadPool = null;
            transportService,
        request.setRefreshPolicy(RefreshPolicy.IMMEDIATE);
        testAction.dispatchedShardOperationOnReplica(request, indexShard, future);
    }
        CapturingTransport transport = new CapturingTransport();
import org.opensearch.index.IndexService;
        logger.info("using state: {}", state);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            TransportService transportService,
        TestRequest request = new TestRequest();
import static org.mockito.Mockito.doThrow;
import org.opensearch.index.IndexingPressureService;
            CapturingActionListener<TestResponse> listener = new CapturingActionListener<>();
                shardId,
            verify(indexShard, never()).refresh(any());
            listener
import org.opensearch.action.support.replication.ReplicationOperation.ReplicaResponse;
            final ShardRouting routing = node.getByShardId(shardId);
                false,
        return indexShard;
            return mockIndexService(indexSafe, clusterService);
        @Override
import java.util.stream.Collectors;
        }
                if (withDocumentFailureOnReplica) {
import org.opensearch.cluster.routing.RoutingNode;
import org.opensearch.transport.TransportService;
                new SystemIndices(emptyMap()),
import static org.mockito.Mockito.anyLong;
}
import static org.mockito.Mockito.anyInt;
                return mockIndexService(clusterService.state().metadata().getIndexSafe(index), clusterService);
            });
        TestAction testAction = new TestAction();
import org.mockito.ArgumentCaptor;
        when(indexShard.routingEntry()).thenAnswer(invocationOnMock -> {
            assertTrue(listener.response.forcedRefresh);
            assertNull(listener.failure);
        testAction.dispatchedShardOperationOnReplica(request, indexShard, future);
            if (routing == null) {
        PlainActionFuture<ReplicaResponse> listener = new PlainActionFuture<>();
import org.junit.BeforeClass;
            "test",
            }
    private static ThreadPool threadPool;
            } else {
            transport.handleResponse(shardFailedRequest.requestId, TransportResponse.Empty.INSTANCE);
            }
import static org.mockito.Mockito.doAnswer;
import java.util.concurrent.atomic.AtomicInteger;
    }
            CapturingActionListener<TestResponse> listener = new CapturingActionListener<>();
            boolean forcedRefresh = randomBoolean();
        protected void dispatchedShardOperationOnReplica(TestRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {
            new OpenSearchException("simulated"),
            TestRequest request,
            return null;
            assertTrue(listener.isDone());
        @Override
    <T> void assertListenerThrows(String msg, PlainActionFuture<T> listener, Class<?> klass) throws InterruptedException {
            }
        } catch (ExecutionException ex) {
    private static class CapturingActionListener<R> implements ActionListener<R> {
            verify(indexShard, never()).addRefreshListener(any(), any());
import static org.hamcrest.Matchers.instanceOf;
 * Modifications Copyright OpenSearch Contributors. See
                null,
            }
            callback.onResponse(count::decrementAndGet);
    }
 *
        }
            transport.handleRemoteError(
        CapturingTransport.CapturedRequest[] shardFailedRequests = transport.getCapturedRequestsAndClear();
            primaryTerm,
        AtomicReference<Object> failure = new AtomicReference<>();
                routingState
        private final boolean withDocumentFailureOnPrimary;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final IndicesService indicesService = mock(IndicesService.class);
                    null,
            assertNotNull(listener.failure);
            TestShardRouting.newShardRouting(
        threadPool = new TestThreadPool("ShardReplicationTests");
    }
                    NoopTracer.INSTANCE
                    TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        }));
import org.opensearch.transport.client.transport.NoNodeAvailableException;
        private final boolean withDocumentFailureOnReplica;
        final ShardRouting replica = randomFrom(
import org.junit.AfterClass;
 * SPDX-License-Identifier: Apache-2.0
        CapturingActionListener<TransportResponse.Empty> listener = new CapturingActionListener<>();
                NoopTracer.INSTANCE
        when(indexService.getShard(anyInt())).then(invocation -> {
        ShardStateAction.FailedShardEntry shardEntry = (ShardStateAction.FailedShardEntry) shardFailedRequest.request;
                }
            final long primaryTerm = indexShard.getPendingPrimaryTerm();
        }).when(indexShard).acquireReplicaOperationPermit(anyLong(), anyLong(), anyLong(), any(ActionListener.class), anyString(), any());
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> future = PlainActionFuture.newFuture();
import org.opensearch.common.lease.Releasable;
                    x -> null,
        protected TestAction(
        ClusterState state = ClusterStateCreationUtils.stateWithActivePrimary(index, true, 1 + randomInt(3), randomInt(2));
import org.opensearch.core.index.shard.ShardId;
        TestRequest request = new TestRequest();
        when(indicesService.indexService(any(Index.class))).then(invocation -> {
        TransportService transportService = transport.createTransportService(
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        );
    }
 * compatible open source license.
        transportService.start();
            assertNotNull(failure.get());
    public void testPrimaryWaitForRefresh() throws Exception {
                );
import org.opensearch.cluster.routing.ShardRouting;
        @Override
    }
        }));
            clusterService.getSettings(),
        protected TestResponse newResponseInstance(StreamInput in) throws IOException {
        request.setRefreshPolicy(RefreshPolicy.NONE); // The default, but we'll set it anyway just to be explicit
    }
        }
            assertTrue(listener.isDone());
        when(indicesService.indexServiceSafe(any(Index.class))).then(invocation -> {
            this.withDocumentFailureOnPrimary = false;
/*
package org.opensearch.action.support.replication;
    private static class TestRequest extends ReplicatedWriteRequest<TestRequest> {
            assertNull(listener.failure);
import org.opensearch.transport.TransportException;
                } else {
        });
        TestAction action = new TestAction(
        CapturingActionListener<TransportResponse.Empty> listener = new CapturingActionListener<>();
    private IndexShard indexShard;
        });
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[1];
        public void onFailure(Exception failure) {
        final TransportReplicationAction.ReplicaResult result = future.actionGet();
                actionName,
import java.util.function.Consumer;
            count.incrementAndGet();
            ),
import static org.mockito.Mockito.anyString;
 * specific language governing permissions and limitations
        assertFalse(listener.isDone());
        if (randomBoolean()) {
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        assertThat(captures, arrayWithSize(1));
            threadPool
    }
    public static void afterClass() {
                    replicaResult = new WriteReplicaResult<>(request, location, null, replica, logger);
    }
import org.opensearch.cluster.ClusterState;
        }
            NoopTracer.INSTANCE
        );
        request.setRefreshPolicy(RefreshPolicy.NONE); // The default, but we'll set it anyway just to be explicit
        ShardRoutingState routingState = randomFrom(
        assertNull(listener.response);
            assertListenerThrows("listener should reflect remote error", listener, OpenSearchException.class);
 *
            assertListenerThrows("listener should reflect remote error", listener, TransportException.class);
        when(indexShard.getPendingPrimaryTerm()).thenAnswer(
        return indicesService;
            ThreadPool threadPool
    }
        assertNull(listener.failure);
        TestAction testAction = new TestAction();
        final IndexShardRoutingTable shardRoutings = state.routingTable().shardRoutingTable(shardId);
            assertNotNull(listener.response);
                TransportWriteActionTests.this.clusterService,
        location = mock(Translog.Location.class);
        proxy.failShardIfNeeded(
        result.runPostReplicaActions(ActionListener.map(listener, ignore -> TransportResponse.Empty.INSTANCE));
            final ShardId shardId = new ShardId(indexMetadata.getIndex(), shard);
            clusterService,
                    Collections.emptySet(),
import org.opensearch.index.translog.Translog;
                throw new IllegalArgumentException(
                throw new ShardNotFoundException(shardId, "shard is no longer assigned to current node");
            ShardStateAction shardStateAction,
            this.response = response;
        testAction.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
import org.opensearch.core.action.ActionListener;
import org.opensearch.test.OpenSearchTestCase;
            final TransportReplicationAction.ReplicaResponse response = new TransportReplicationAction.ReplicaResponse(
    }
            ActionListener<PrimaryResult<TestRequest, TestResponse>> listener
            result.runPostReplicationActions(ActionListener.map(listener, ignore -> result.finalResponseIfSuccessful));
import org.opensearch.cluster.action.shard.ShardStateAction;
            ArgumentCaptor<Consumer<Boolean>> refreshListener = ArgumentCaptor.forClass((Class) Consumer.class);
 * ownership. Elasticsearch licenses this file to you under
 * under the License.
        when(indexShard.isRelocatedPrimary()).thenAnswer(invocationOnMock -> isRelocated.get());
                shardStateAction,
        TestRequest() {
