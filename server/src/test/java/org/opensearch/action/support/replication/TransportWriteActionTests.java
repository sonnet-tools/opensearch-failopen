        assertNull(listener.response);  
            return null;  
            }  
        }
        clusterService.close();
            threadPool  
import org.mockito.ArgumentCaptor;
import java.util.concurrent.atomic.AtomicReference;
            assertNull(listener.response); // Haven't really responded yet  
import org.opensearch.test.OpenSearchTestCase;
        final ShardRouting replica = randomFrom(
        }  
                    return new WritePrimaryResult<>(request, new TestResponse(), location, null, primary, logger);
            TransportService transportService,
                "internal:test",
        ReplicationOperation.Replicas<TestRequest> proxy = action.newReplicasProxy();
        verify(indexShard, never()).addRefreshListener(any(), any());
                );  
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> future = PlainActionFuture.newFuture();
        TestAction testAction = new TestAction(randomBoolean(), true);  
        );
/*  
        TestAction action = new TestAction(  
        assertThat(captures, arrayWithSize(1));
        CapturingActionListener<TransportResponse.Empty> listener = new CapturingActionListener<>();
        final TransportReplicationAction.ReplicaResult result = future.actionGet();
        AtomicReference<Object> failure = new AtomicReference<>();
 * under the License.  
import org.opensearch.node.NodeClosedException;
                shardStateAction,
                } else {  
    }  
            );
        assertEquals(shardEntry.getShardId(), replica.shardId());
                Settings.EMPTY,  
        verify(indexShard, never()).refresh(any());  
    }  
import org.opensearch.core.common.io.stream.StreamInput;
        }
 */  
        proxy.performOn(
        assertEquals(shardEntry.getAllocationId(), replica.allocationId().getId());  
            ShardStateAction shardStateAction,
            return mockIndexShard(shardId, clusterService);
            callback.onResponse(count::decrementAndGet);  
                new SystemIndices(emptyMap()),  
    }
                TestRequest::new,
            CapturingActionListener<TestResponse> listener = new CapturingActionListener<>();
        @Override  
            super(new ShardId("test", "test", 1));
    }  
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
            assertNull(listener.failure);  
        request.setRefreshPolicy(RefreshPolicy.IMMEDIATE);  
                    x -> null,
import org.junit.BeforeClass;  
    private final AtomicInteger count = new AtomicInteger(0);
        }
        }
            assertNotNull(failure.get());  
        threadPool = null;
    @After
            count.incrementAndGet();
        final IndexShard indexShard = mock(IndexShard.class);
    private final AtomicBoolean isRelocated = new AtomicBoolean(false);
        TestRequest request = new TestRequest();
        });
                ignore -> ThreadPool.Names.SAME,  
        final String index = "test";
        request.setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
                new ActionFilters(new HashSet<>()),
    final IndexService mockIndexService(final IndexMetadata indexMetadata, ClusterService clusterService) {
/*
import java.util.Locale;
            // simulate success
                TestRequest::new,
            verify(indexShard, never()).refresh(any());
            verify(indexShard, never()).refresh(any());
            ShardRoutingState.INITIALIZING,
 */
    private IndexShard indexShard;
        );
        CapturingTransport.CapturedRequest shardFailedRequest = shardFailedRequests[0];
            });  
    @BeforeClass
        }));
        assertNotNull(listener.failure);
            this.withDocumentFailureOnReplica = withDocumentFailureOnReplica;
        proxy.failShardIfNeeded(
            );  
        );  
        public String toString() {  
import org.opensearch.cluster.ClusterState;
            final ClusterState state = clusterService.state();
import java.util.concurrent.atomic.AtomicBoolean;
        private Exception failure;
            ShardRoutingState.RELOCATING  
        }
    public void tearDown() throws Exception {  
import org.opensearch.action.support.ActionFilters;
    private static class TestResponse extends ReplicationResponse implements WriteResponse {
    private static class TestRequest extends ReplicatedWriteRequest<TestRequest> {
 * GitHub history for details.
            TestShardRouting.newShardRouting(  
import org.opensearch.OpenSearchException;
            Index index = (Index) invocation.getArguments()[0];  
        TestAction testAction = new TestAction();
        protected TestAction(
        }));
    public void testDocumentFailureInShardOperationOnPrimary() throws Exception {
import static org.mockito.Mockito.doThrow;
            i -> clusterService.state().metadata().getIndexSafe(shardId.getIndex()).primaryTerm(shardId.id())  
        location = mock(Translog.Location.class);  
import static org.mockito.Mockito.anyString;  
        threadPool = new TestThreadPool("ShardReplicationTests");  
            // Now we can fire the listener manually and we'll get a response
        });
    @Override
            assertTrue(listener.isDone());  
        private final boolean withDocumentFailureOnPrimary;  
            assertTrue(listener.response.forcedRefresh);
            );
    public void testPrimaryImmediateRefresh() throws Exception {
            randomNonNegativeLong(),
    final IndicesService mockIndicesService(ClusterService clusterService) {  
            // simulate the primary has been demoted
import org.opensearch.core.index.shard.ShardId;
import static org.mockito.Mockito.when;  
        request.setRefreshPolicy(RefreshPolicy.IMMEDIATE);  
        }
        protected TestAction() {  
        TestRequest request = new TestRequest();  
                final WriteReplicaResult<TestRequest> replicaResult;  
            super(
 * KIND, either express or implied.  See the License for the
        TestAction testAction = new TestAction();
                null,
        }
    }  
    }
import org.opensearch.action.support.WriteResponse;  
            if (state.metadata().hasIndex(index.getName())) {
        final TransportReplicationAction.ReplicaResult result = future.actionGet();
        when(indicesService.indexService(any(Index.class))).then(invocation -> {
 *
                new TransportService(
            assertEquals(forcedRefresh, listener.response.forcedRefresh);  
        CapturingActionListener<TransportResponse.Empty> listener = new CapturingActionListener<>();
        PlainActionFuture<ReplicaResponse> listener = new PlainActionFuture<>();
        proxy.performOn(replica, new TestRequest(), primaryTerm, randomNonNegativeLong(), randomNonNegativeLong(), listener);  
                routingState == ShardRoutingState.RELOCATING ? state.nodes().iterator().next().getId() : null,  
        assertNotNull(listener.response);
        }  
            x -> clusterService.localNode(),
        TestRequest request = new TestRequest();
            fail(msg);
                TransportWriteActionTests.this.clusterService,  
import org.opensearch.common.settings.Settings;  
        }));
        assertListenerThrows("non existent node should throw a NoNodeAvailableException", listener, NoNodeAvailableException.class);
        request.setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);  
        ) {  
        private R response;  
        private final boolean withDocumentFailureOnReplica;
 * You may obtain a copy of the License at  
    public void testReplicaImmediateRefresh() throws Exception {
            return null;
        TestRequest(StreamInput in) throws IOException {  
import java.util.function.Consumer;
        } else {
        // check that at unknown node fails
    public void testPrimaryWaitForRefresh() throws Exception {
        assertEquals(1, shardFailedRequests.length);
        final TransportReplicationAction.ReplicaResult result = future.actionGet();  
                routingState
            });
        );
            new OpenSearchException("simulated"),
            assertFalse(success.get());
    }
import java.util.stream.Collectors;  
        ShardStateAction shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        assertNull(listener.failure);
            transport.handleRemoteError(shardFailedRequest.requestId, new NodeClosedException(state.nodes().getLocalNode()));
import org.opensearch.test.ClusterServiceUtils;  
        assertTrue(listener.isDone());
        public void onFailure(Exception failure) {  
    private static class CapturingActionListener<R> implements ActionListener<R> {
            }
    private Translog.Location location;
        return indexService;  
        });
            ActionListener.wrap(r -> success.set(true), failure::set)  
                TestRequest::new,
        testAction.dispatchedShardOperationOnReplica(request, indexShard, future);
import org.opensearch.index.IndexService;  
        TransportService transportService = transport.createTransportService(  
    }  
            if (shard > indexMetadata.getNumberOfShards()) {
                    null,
 * Modifications Copyright OpenSearch Contributors. See
        );
            randomNonNegativeLong(),  
import org.opensearch.transport.TransportService;
            if (term < primaryTerm) {  
    }
            ),  
            this.response = response;
            refreshListener.getValue().accept(forcedRefresh);  
import static java.util.Collections.emptyMap;
            this.forcedRefresh = forcedRefresh;
    @Before  
            final TransportReplicationAction.ReplicaResponse response = new TransportReplicationAction.ReplicaResponse(  
                throw new IllegalArgumentException(
            @SuppressWarnings({ "unchecked", "rawtypes" })
import org.opensearch.core.transport.TransportResponse;
            ClusterService clusterService,  
            replica,
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            assertListenerThrows("listener should reflect remote error", listener, OpenSearchException.class);
import static org.mockito.Mockito.doAnswer;
import java.util.Collections;  
            Index index = (Index) invocation.getArguments()[0];  
        assertNotNull(listener.response);
                    Settings.EMPTY,  
import org.opensearch.core.action.ActionListener;
        assertNotNull(listener.response);
 * The OpenSearch Contributors require contributions made to  
        // the shard the request was sent to and the shard to be failed should be the same
            assertNull(listener.failure);
    }  
                "NOT THERE",
        @Override  
        );
        try {  
        clusterService = createClusterService(threadPool);
                    return new WritePrimaryResult<>(request, null, null, new RuntimeException("simulated"), primary, logger);
            String actionName,
        testAction.dispatchedShardOperationOnReplica(request, indexShard, future);  
            threadPool,
        testAction.dispatchedShardOperationOnReplica(request, indexShard, future);  
        transportService.acceptIncomingRequests();
        when(indexShard.routingEntry()).thenAnswer(invocationOnMock -> {  
        listener = new PlainActionFuture<>();
        @Override  
            // simulated a node closing exception  
public class TransportWriteActionTests extends OpenSearchTestCase {
            verify(indexShard, never()).addRefreshListener(any(), any());  
import org.opensearch.cluster.metadata.IndexMetadata;
        } else if (randomBoolean()) {  
        @Override
            assertTrue(listener.isDone());
import org.opensearch.transport.client.transport.NoNodeAvailableException;
        assertNull(listener.failure);
            ActionListener<PrimaryResult<TestRequest, TestResponse>> listener
            NoopTracer.INSTANCE
 *  
import org.opensearch.index.shard.ShardNotFoundException;  
        assertFalse(listener.isDone());
import java.io.IOException;
            this.failure = failure;
        TestAction testAction = new TestAction();
import static org.mockito.Mockito.anyInt;
            if (routing == null) {
            final ShardRouting routing = node.getByShardId(shardId);  
            TestRequest request,
            transport.handleResponse(shardFailedRequest.requestId, TransportResponse.Empty.INSTANCE);  
        CapturingTransport.CapturedRequest[] captures = transport.getCapturedRequestsAndClear();  
/*  
 * not use this file except in compliance with the License.
            transport.handleResponse(captures[0].requestId, response);
import org.opensearch.index.shard.IndexShard;
            super(in);
    }  
            final RoutingNode node = state.getRoutingNodes().node(state.nodes().getLocalNodeId());
            ShardRoutingState.STARTED,
        } else if (randomBoolean()) {
import org.junit.After;  
                    replicaResult = new WriteReplicaResult<>(request, null, new RuntimeException("simulated"), replica, logger);
    }
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        protected TestResponse newResponseInstance(StreamInput in) throws IOException {
                if (withDocumentFailureOnReplica) {
            final ClusterState state = clusterService.state();
            ArgumentCaptor<Consumer<Boolean>> refreshListener = ArgumentCaptor.forClass((Class) Consumer.class);  
        when(indexShard.getPendingPrimaryTerm()).thenAnswer(
        TestAction testAction = new TestAction();
                false,
import org.junit.AfterClass;
 *
        final ShardId shardId = new ShardId(index, "_na_", 0);  
    }
import java.util.concurrent.atomic.AtomicInteger;  
            this(false, false);
        final IndexShardRoutingTable shardRoutings = state.routingTable().shardRoutingTable(shardId);
        ArgumentCaptor<Consumer<Boolean>> refreshListener = ArgumentCaptor.forClass((Class) Consumer.class);  
            assertNotNull(listener.response);
            IndexShard primary,  
        testAction.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {  
        boolean forcedRefresh;  
        TestAction testAction = new TestAction();
    }  
 * Licensed to Elasticsearch under one or more contributor  
            assertTrue(success.get());
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.support.replication;
            assertNotNull(listener.response);
    public void testDocumentFailureInShardOperationOnReplica() throws Exception {
    public void testReplicaProxy() throws InterruptedException, ExecutionException {
        }));
    private static ThreadPool threadPool;
        }).when(indexShard).acquirePrimaryOperationPermit(any(ActionListener.class), anyString(), any());
import java.util.concurrent.TimeUnit;
                new ShardStateAction.NoLongerPrimaryShardException(replica.shardId(), "shard-failed-test")
import org.opensearch.action.support.PlainActionFuture;
        ) {
        final TransportReplicationAction.ReplicaResult result = future.actionGet();
import org.opensearch.cluster.service.ClusterService;
            assertThat(ex.getCause(), instanceOf(klass));
                transportService,
            Settings settings,  
 * compatible open source license.
import static org.hamcrest.Matchers.equalTo;
                return replicaResult;  
            transport.handleRemoteError(captures[0].requestId, new OpenSearchException("simulated"));
        doThrow(new AssertionError("failed shard is not supported")).when(indexShard).failShard(anyString(), any(Exception.class));
        ClusterServiceUtils.setState(clusterService, state);  
        CapturingActionListener<TransportResponse.Empty> listener = new CapturingActionListener<>();
        TestRequest request = new TestRequest();
            result.runPostReplicationActions(ActionListener.map(listener, ignore -> result.finalResponseIfSuccessful));
        TestRequest request = new TestRequest();
                new IndexingPressureService(settings, clusterService),
            final ShardId shardId = new ShardId(indexMetadata.getIndex(), shard);  
    public static void beforeClass() {
        );
            int shard = (Integer) invocation.getArguments()[0];
            clusterService.getSettings(),
        result.runPostReplicaActions(ActionListener.map(listener, ignore -> TransportResponse.Empty.INSTANCE));
        ClusterState state = ClusterStateCreationUtils.stateWithActivePrimary(index, true, 1 + randomInt(3), randomInt(2));
    }
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> future = PlainActionFuture.newFuture();
    public static void afterClass() {  
            result.runPostReplicationActions(ActionListener.map(listener, ignore -> result.finalResponseIfSuccessful));
                new SystemIndices(emptyMap()),
            transport.handleRemoteError(
        return indexShard;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        if (randomBoolean()) {
 */  
import org.opensearch.transport.TransportException;  
            listener.get();
            boolean forcedRefresh = randomBoolean();
                }
import org.opensearch.cluster.routing.RoutingNode;  
                null,  
            final long primaryTerm = indexShard.getPendingPrimaryTerm();
import static org.mockito.Mockito.verify;
        testAction.dispatchedShardOperationOnReplica(request, indexShard, future);  
import org.opensearch.action.support.ActionTestUtils;  
        }).when(indexShard).acquireReplicaOperationPermit(anyLong(), anyLong(), anyLong(), any(ActionListener.class), anyString(), any());
    private ClusterService clusterService;  
        } catch (ExecutionException ex) {  
                ignore -> ThreadPool.Names.SAME,
                throw new ShardNotFoundException(shardId, "shard is no longer assigned to current node");
        AtomicBoolean success = new AtomicBoolean();  
            final IndexMetadata indexSafe = state.metadata().getIndexSafe(index);
            super(
        CapturingActionListener<TransportResponse.Empty> listener = new CapturingActionListener<>();
            assertNull(failure.get());
        // Now we can fire the listener manually and we'll get a response
    private class TestAction extends TransportWriteAction<TestRequest, TestRequest, TestResponse> {
import org.junit.Before;
 * the Apache License, Version 2.0 (the "License"); you may
        verify(indexShard).addRefreshListener(any(), refreshListener.capture());
        logger.info("using state: {}", state);
            verify(indexShard).refresh("refresh_flag_index");
                false,
                    NoopTracer.INSTANCE
        verify(indexShard, never()).addRefreshListener(any(), any());
        ShardStateAction.FailedShardEntry shardEntry = (ShardStateAction.FailedShardEntry) shardFailedRequest.request;  
                if (withDocumentFailureOnPrimary) {
import org.opensearch.transport.Transport;
                return null;
        }
                settings,
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[0];  
 *    http://www.apache.org/licenses/LICENSE-2.0
                ),
            Settings.EMPTY,
        if (randomBoolean()) {
        } else {
    <T> void assertListenerThrows(String msg, PlainActionFuture<T> listener, Class<?> klass) throws InterruptedException {
import static org.hamcrest.Matchers.arrayWithSize;  
                } else {  
    }
        assertNull(listener.response); // Haven't responded yet
                    Collections.emptySet(),  
    }
        final IndexService indexService = mock(IndexService.class);  
            assertNull(listener.failure);
                new ActionFilters(new HashSet<>()),  
            clusterService,
                randomLong()
            count.incrementAndGet();
            return routing;
    }  
            assertTrue(listener.isDone());
import org.opensearch.test.transport.CapturingTransport;
        when(indexShard.isRelocatedPrimary()).thenAnswer(invocationOnMock -> isRelocated.get());  
            new TestRequest(),
        testAction.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {  
            shardRoutings.replicaShards().stream().filter(ShardRouting::assignedToNode).collect(Collectors.toList())  
            );  
            CapturingActionListener<TestResponse> listener = new CapturingActionListener<>();  
    }
 * this work for additional information regarding copyright
}
        }
import org.opensearch.indices.SystemIndices;  
                actionName,  
import org.opensearch.common.lease.Releasable;
        assertNull(listener.failure);
            assertNull(listener.response);
import org.opensearch.action.support.replication.ReplicationOperation.ReplicaResponse;
            "test",
        CapturingTransport transport = new CapturingTransport();
    public void initCommonMocks() {
            assertNotNull(failure.get());
        @Override
                    TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
import static org.mockito.Mockito.mock;  
        // A write replication action proxy should fail the shard  
import java.util.HashSet;
            this.withDocumentFailureOnPrimary = false;  
                false,
            transportService,  
        TestAction testAction = new TestAction(true, true);
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> future = PlainActionFuture.newFuture();
            result.runPostReplicationActions(ActionListener.map(listener, ignore -> result.finalResponseIfSuccessful));
import org.opensearch.core.index.Index;  
import static org.mockito.Mockito.anyLong;
            return new TestResponse();  
    public void testPrimaryNoRefreshCall() throws Exception {
        }  
import org.opensearch.threadpool.ThreadPool;
        when(indicesService.indexServiceSafe(any(Index.class))).then(invocation -> {
            assertListenerThrows("listener should reflect remote error", listener, TransportException.class);
    @AfterClass
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
            CapturingActionListener<TestResponse> listener = new CapturingActionListener<>();  
        TestRequest request = new TestRequest();  
import org.opensearch.cluster.routing.TestShardRouting;  
            } else {
        verify(indexShard, never()).refresh(any());
        }  
        request.setRefreshPolicy(RefreshPolicy.NONE); // The default, but we'll set it anyway just to be explicit
        when(indexService.getShard(anyInt())).then(invocation -> {
                clusterService,
        doAnswer(invocation -> {
        @Override
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,  
 * license agreements. See the NOTICE file distributed with
                shardId,
        }
                shardFailedRequest.requestId,  
                mockIndicesService(clusterService),  
                return mockIndexService(clusterService.state().metadata().getIndexSafe(index), clusterService);  
            transport.handleError(captures[0].requestId, new TransportException("simulated"));  
            null,
        request.setRefreshPolicy(RefreshPolicy.NONE); // The default, but we'll set it anyway just to be explicit  
        ShardRoutingState routingState = randomFrom(  
import static org.hamcrest.Matchers.instanceOf;
            verify(indexShard, never()).addRefreshListener(any(), any());  
        protected TestAction(boolean withDocumentFailureOnPrimary, boolean withDocumentFailureOnReplica) {
        final long primaryTerm = state.metadata().index(index).primaryTerm(0);
        CapturingTransport.CapturedRequest[] shardFailedRequests = transport.getCapturedRequestsAndClear();
import org.opensearch.index.IndexingPressureService;
            final ClusterState state = clusterService.state();
                    null,
    public void testReplicaNoRefreshCall() throws Exception {
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> future = PlainActionFuture.newFuture();
    private IndexShard mockIndexShard(ShardId shardId, ClusterService clusterService) {  
            verify(indexShard).addRefreshListener(any(), refreshListener.capture());
            }  
        public void setForcedRefresh(boolean forcedRefresh) {  
import org.opensearch.cluster.action.shard.ShardStateAction;  
        verify(indexShard).refresh("refresh_flag_index");  
        protected void dispatchedShardOperationOnPrimary(
        result.runPostReplicaActions(ActionListener.map(listener, ignore -> TransportResponse.Empty.INSTANCE));  
                    replicaResult = new WriteReplicaResult<>(request, location, null, replica, logger);
        final IndicesService indicesService = mock(IndicesService.class);
            shardStateAction,
        testAction.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
        super.tearDown();
            ActionListener.completeWith(listener, () -> {
                }
            return mockIndexService(indexSafe, clusterService);  
        testAction.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
                NoopTracer.INSTANCE
            assertNotNull(listener.response);  
import static org.mockito.Mockito.never;
        TestRequest() {
            ActionListener.completeWith(listener, () -> {  
            ThreadPool threadPool
            assertThat(listener.get(), equalTo(response));  
import org.opensearch.indices.IndicesService;
        protected void dispatchedShardOperationOnReplica(TestRequest request, IndexShard replica, ActionListener<ReplicaResult> listener) {
            Collections.emptySet(),  
                null,
import org.opensearch.threadpool.TestThreadPool;  
            CapturingActionListener<TestResponse> listener = new CapturingActionListener<>();
            callback.onResponse(count::decrementAndGet);
                threadPool,
                    String.format(Locale.ROOT, "%s operation term [%d] is too old (current [%d])", shardId, term, primaryTerm)
                    mock(Transport.class),
 * software distributed under the License is distributed on an
            long term = (Long) invocation.getArguments()[0];  
        TestRequest request = new TestRequest();
            assertNotNull(listener.failure);  
        result.runPostReplicaActions(ActionListener.map(listener, ignore -> TransportResponse.Empty.INSTANCE));  
        }
    }  
    public void testReplicaWaitForRefresh() throws Exception {
        TestAction testAction = new TestAction();
            "internal:testAction",
        @SuppressWarnings({ "unchecked", "rawtypes" })
            primaryTerm,
            assertFalse(success.get());  
    }
            listener
        public void onResponse(R response) {
import org.opensearch.cluster.routing.ShardRoutingState;
            return "TestRequest{}";
import java.util.concurrent.ExecutionException;  
        transportService.start();  
        refreshListener.getValue().accept(forcedRefresh);  
            result.runPostReplicationActions(ActionListener.map(listener, ignore -> result.finalResponseIfSuccessful));
            this.withDocumentFailureOnReplica = false;
                randomLong(),
        TestRequest request = new TestRequest();
                NoopTracer.INSTANCE
        doAnswer(invocation -> {
import static org.mockito.Mockito.any;  
                new IndexingPressureService(Settings.EMPTY, TransportWriteActionTests.this.clusterService),  
        result.runPostReplicaActions(ActionListener.map(listener, ignore -> TransportResponse.Empty.INSTANCE));  
        indexShard = mock(IndexShard.class);
        });
        @Override
        return indicesService;
import org.opensearch.index.translog.Translog;
            ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[1];
 * specific language governing permissions and limitations
        boolean forcedRefresh = randomBoolean();
 * ownership. Elasticsearch licenses this file to you under  
            this.withDocumentFailureOnPrimary = withDocumentFailureOnPrimary;
 * Unless required by applicable law or agreed to in writing,
                throw new ShardNotFoundException(shardId);
                TestRequest::new,  
            primaryTerm,  
