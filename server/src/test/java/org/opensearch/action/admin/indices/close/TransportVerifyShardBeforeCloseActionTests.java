 * license agreements. See the NOTICE file distributed with
        return new ReplicationOperation.Primary<
        assertThat(shardInfo.getFailed(), equalTo(0));
    private TransportVerifyShardBeforeCloseAction action;
        when(indexShard.getActiveOperationsCount()).thenReturn(randomIntBetween(0, 10));
import java.util.concurrent.ExecutionException;
            @Override
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            @Override
        final ReplicationResponse.ShardInfo shardInfo = listener.get().getShardInfo();
            }
        action = new TransportVerifyShardBeforeCloseAction(
        verify(indexShard, times(0)).flush(any(FlushRequest.class));
    private IndexShard indexShard;
/*
        doNothing().when(indexShard).flush(flushRequest.capture());
    private ClusterBlock clusterBlock;
    public void testUnavailableShardsMarkedAsStale() throws Exception {
import org.junit.After;
            if (actionName.startsWith(ShardStateAction.SHARD_FAILED_ACTION_NAME)) {
import org.opensearch.core.action.ActionListener;
        }
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.cluster.metadata.IndexMetadata;
    }
        IllegalStateException exception = expectThrows(IllegalStateException.class, this::executeOnPrimaryOrReplica);
        final ShardId shardId = new ShardId("index", "_na_", randomIntBetween(0, 3));
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import org.opensearch.common.settings.Settings;
            @Override
        );
                transport.handleResponse(capturedRequest.requestId, TransportResponse.Empty.INSTANCE);
        );
            mock(ThreadPool.class),
    @BeforeClass
import org.opensearch.cluster.block.ClusterBlock;
        ReplicationOperation.Replicas<TransportVerifyShardBeforeCloseAction.ShardRequest> proxy = action.newReplicasProxy();
import org.opensearch.threadpool.TestThreadPool;
        public TransportVerifyShardBeforeCloseAction.ShardRequest replicaRequest() {
import java.util.List;
        } catch (ExecutionException e) {
        }
import static org.hamcrest.Matchers.arrayWithSize;
    @After
 *
 */
        );
                ClusterBlocks.builder().blocks(clusterService.state().blocks()).addIndexBlock("index", clusterBlock).build()
                TimeValue.timeValueMillis(20),
            assertNotNull(r);
    }
import org.opensearch.cluster.ClusterState;
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
import static org.hamcrest.Matchers.is;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            Settings.EMPTY,
import org.junit.AfterClass;
        unavailableShards.forEach(shardRoutingTableBuilder::removeShard);
import org.opensearch.cluster.ClusterName;
    }
    public void testShardIsFlushed() throws Throwable {
public class TransportVerifyShardBeforeCloseActionTests extends OpenSearchTestCase {
        threadPool = new TestThreadPool(getTestClass().getName());
}
        ReplicationOperation<
        verify(indexShard, times(1)).flush(any(FlushRequest.class));
import org.opensearch.cluster.block.ClusterBlocks;
import org.opensearch.cluster.routing.ShardRouting;
                assertTrue(inSyncAllocationIds.stream().anyMatch(inSyncAllocationId -> inSyncAllocationId.equals(allocationId)));
            mock(ThreadPool.class),
 * this file be licensed under the Apache-2.0 license or a
    private CapturingTransport transport;
                assertThat(capturedRequest.request, instanceOf(ConcreteShardRequest.class));
            public ShardRouting routingEntry() {
            replicaStates[i] = ShardRoutingState.STARTED;
 * software distributed under the License is distributed on an
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
        for (int i = 0; i < replicaStates.length; i++) {
import org.opensearch.core.index.shard.ShardId;
    private ClusterService clusterService;
        assertThat(shardInfo.getSuccessful(), equalTo(1 + nbReplicas - unavailableShards.size()));
            phase1,
    }
        @Override
    private void executeOnPrimaryOrReplica() throws Throwable {
 *
import org.opensearch.cluster.metadata.MetadataIndexStateService;
            mock(IndicesService.class),
        }
        public ReplicationResponse.ShardInfo getShardInfo() {
import static org.mockito.Mockito.any;
            }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.replication.FanoutReplicationProxy;
        verify(indexShard, times(1)).sync();
        final PlainActionFuture<Void> res = PlainActionFuture.newFuture();
        List<ShardRouting> unavailableShards = randomSubsetOf(randomIntBetween(1, nbReplicas), shardRoutingTable.replicaShards());
        doThrow(new IllegalStateException("test")).when(indexShard).verifyShardBeforeIndexClosing();
            throw new AssertionError(e);
                proxy,
        @Override
        setState(clusterService, clusterState);
        super.tearDown();
            clusterService,
            final String actionName = capturedRequest.action;
            Settings.EMPTY,
            transportService,
        } catch (InterruptedException e) {
package org.opensearch.action.admin.indices.close;
    public void testShardIsSynced() throws Throwable {
        TransportVerifyShardBeforeCloseAction action = createAction();
            public ReplicationGroup getReplicationGroup() {
import java.util.Set;
    }
        IllegalStateException exception = expectThrows(IllegalStateException.class, this::executeOnPrimaryOrReplica);
 * specific language governing permissions and limitations
    private static class PrimaryResult implements ReplicationOperation.PrimaryResult<TransportVerifyShardBeforeCloseAction.ShardRequest> {
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();
                fail("Test does not support action " + capturedRequest.action);
        createPrimary(final ShardRouting primary, final ReplicationGroup replicationGroup) {
    }
            @Override
 * Unless required by applicable law or agreed to in writing,
        executeOnPrimaryOrReplica(true);
    }
                return 0;
        clusterService = createClusterService(threadPool);
            this.replicaRequest = replicaRequest;
            NoopTracer.INSTANCE
        final String index = "test";
                assertFalse(unavailableShards.stream().anyMatch(shardRouting -> shardRouting.allocationId().getId().equals(allocationId)));
        final IndexMetadata indexMetadata = clusterState.getMetadata().index(index);
import static org.mockito.Mockito.verify;
    }
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
import java.util.Collections;
            Collections.emptySet(),
import org.opensearch.action.support.replication.TransportReplicationAction;
 * Licensed to Elasticsearch under one or more contributor
            }
import org.opensearch.cluster.action.shard.ShardStateAction;
        operation.execute();
                return replicationGroup;
 */
        }, res::onFailure));
        final PlainActionFuture<PrimaryResult> listener = new PlainActionFuture<>();
/*
        final ArgumentCaptor<FlushRequest> flushRequest = ArgumentCaptor.forClass(FlushRequest.class);
            indexShard.shardId(),
                String allocationId = ((ShardStateAction.FailedShardEntry) capturedRequest.request).getAllocationId();
            public long globalCheckpoint() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.action.support.replication.PendingReplicationActions;
    public void testGetReplicationModeWithLocalTranslog() {
    }
import org.opensearch.core.tasks.TaskId;
            @Override
        action.shardOperationOnPrimary(request, indexShard, ActionListener.wrap(r -> {
            Settings.EMPTY,
        verify(indexShard, times(0)).flush(any(FlushRequest.class));
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
        }
            ).build()
            public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {}
import org.opensearch.index.shard.IndexShard;
    @Override
import org.opensearch.action.support.replication.ReplicationResponse;
import static org.mockito.Mockito.times;
            @Override
                return primary;
import org.opensearch.transport.TransportService;
            clusterService,
                TimeValue.timeValueSeconds(60),
            res.get();
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.index.shard.ReplicationGroup;
    }
        assertThat(
        indexShard = mock(IndexShard.class);
        replicationActions.accept(replicationGroup);
        TaskId taskId = new TaskId(clusterService.localNode().getId(), 0L);
        executeOnPrimaryOrReplica();
            public void perform(TransportVerifyShardBeforeCloseAction.ShardRequest request, ActionListener<PrimaryResult> listener) {
            }
import org.opensearch.cluster.routing.ShardRoutingState;
                primaryTerm,
import org.opensearch.action.support.replication.TransportReplicationAction.ConcreteShardRequest;
            return shardInfo.get();
 * the Apache License, Version 2.0 (the "License"); you may
        TransportVerifyShardBeforeCloseAction.ShardRequest request = new TransportVerifyShardBeforeCloseAction.ShardRequest(
    }
                transport.handleResponse(capturedRequest.requestId, new TransportReplicationAction.ReplicaResponse(0L, 0L));
    public static void beforeClass() {
import org.opensearch.action.support.ActionFilters;
            shardId,
            @Override
            clusterBlock,
import static org.mockito.Mockito.when;
            threadPool,
    }
import org.opensearch.threadpool.ThreadPool;
        );
        public void setShardInfo(ReplicationResponse.ShardInfo shardInfo) {
            }
        TransportService transportService = transport.createTransportService(
import org.opensearch.indices.IndicesService;
        final Set<String> trackedShards = shardRoutingTable.getAllAllocationIds();
            }
        when(indexShard.getActiveOperationsCount()).thenReturn(IndexShard.OPERATIONS_BLOCKED);
                assertTrue(unavailableShards.stream().anyMatch(shardRouting -> shardRouting.allocationId().getId().equals(allocationId)));
 */
import org.mockito.ArgumentCaptor;
import static org.opensearch.test.ClusterServiceUtils.setState;
                return 0;
            taskId
        }
import static org.hamcrest.Matchers.greaterThan;
            listener.onResponse(null);
import org.opensearch.action.support.replication.ReplicationMode;
        private PrimaryResult(final TransportVerifyShardBeforeCloseAction.ShardRequest replicaRequest) {
            mock(ActionFilters.class)
            this.shardInfo.set(shardInfo);
                threadPool,
    }
        IndexShardRoutingTable.Builder shardRoutingTableBuilder = new IndexShardRoutingTable.Builder(shardRoutingTable);
            taskId
    private TransportVerifyShardBeforeCloseAction createAction() {
    private static
        public void runPostReplicationActions(ActionListener<Void> listener) {
        return new TransportVerifyShardBeforeCloseAction(
        shardRoutingTable = shardRoutingTableBuilder.build();
 * under the License.
            }
                return replicationActions;
        final long primaryTerm = indexMetadata.primaryTerm(0);
        assertThat(
            exception.getMessage(),
            } else {
        final IndexShard indexShard = mock(IndexShard.class);
        super.setUp();
            public long localCheckpoint() {
                assertThat(capturedRequest.request, instanceOf(ShardStateAction.FailedShardEntry.class));
        assertThat(flushRequest.getValue().force(), is(true));
            PrimaryResult>() {
            mock(TransportService.class),
        }
        transportService.start();
        }
        verify(indexShard, times(1)).verifyShardBeforeIndexClosing();
        @Override
    private void executeOnPrimaryOrReplica(boolean phase1) throws Throwable {
import org.opensearch.common.unit.TimeValue;
            TransportVerifyShardBeforeCloseAction.ShardRequest,
    public static void afterClass() {
            @Override
 * You may obtain a copy of the License at
            TransportVerifyShardBeforeCloseAction.ShardRequest,
            @Override
            mock(ShardStateAction.class),
                request,
import static org.mockito.Mockito.mock;
            equalTo("Index shard " + indexShard.shardId() + " must be blocked by " + clusterBlock + " before closing")
import org.opensearch.action.support.replication.ReplicationOperation;
        transportService.acceptIncomingRequests();
            new ClusterState.Builder(clusterService.state()).blocks(
import static org.hamcrest.Matchers.instanceOf;
 * SPDX-License-Identifier: Apache-2.0
        final ClusterState clusterState = state(index, true, ShardRoutingState.STARTED, replicaStates);
    public void testGetReplicationModeWithRemoteTranslog() {
import static org.mockito.Mockito.doThrow;
            @Override
 * not use this file except in compliance with the License.
        final PendingReplicationActions replicationActions = new PendingReplicationActions(primary.shardId(), threadPool);
import org.opensearch.test.transport.CapturingTransport;
            x -> clusterService.localNode(),
            } else if (actionName.startsWith(TransportVerifyShardBeforeCloseAction.NAME)) {
        when(indexShard.shardId()).thenReturn(shardId);
                listener.onResponse(new PrimaryResult(request));
    @AfterClass
 * GitHub history for details.
                return 0;
            public PendingReplicationActions getPendingReplicationActions() {
        final ShardRouting primaryRouting = shardRoutingTable.primaryShard();
            TransportVerifyShardBeforeCloseAction.ShardRequest,
import org.junit.BeforeClass;
            this.shardInfo = new SetOnce<>();
                new FanoutReplicationProxy<>(proxy)
        );
import org.opensearch.test.OpenSearchTestCase;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            return replicaRequest;
    public void testVerifyShardBeforeIndexClosingFailed() {
        final ShardRoutingState[] replicaStates = new ShardRoutingState[nbReplicas];
            mock(IndicesService.class),
            @Override
        executeOnPrimaryOrReplica(false);
        );
/*
        for (CapturingTransport.CapturedRequest capturedRequest : capturedRequests) {
        assertThat(capturedRequests.length, equalTo(nbReplicas));
    public void testOperationFailsWhenNotBlocked() {
        assertThat(replicationGroup.getUnavailableInSyncShards().size(), greaterThan(0));
                listener,
        ShardStateAction shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        final TaskId taskId = new TaskId("_node_id", randomNonNegativeLong());
            exception.getMessage(),
    @Override
import static org.mockito.Mockito.doNothing;
            throw e.getCause();
        TransportVerifyShardBeforeCloseAction action = createAction();
 *
            }
        assertThat(shardInfo.getFailures(), arrayWithSize(0));
            null,
    public void tearDown() throws Exception {
            PrimaryResult>
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.transport.TransportResponse;
import org.opensearch.action.admin.indices.flush.FlushRequest;
import org.opensearch.cluster.service.ClusterService;
        final IndexShard indexShard = mock(IndexShard.class);
        final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(0);
        setState(
    }
            res.onResponse(null);
        setState(clusterService, new ClusterState.Builder(new ClusterName("test")).build());
import java.util.concurrent.TimeUnit;
            public long computedGlobalCheckpoint() {
            shardStateAction,
 * this work for additional information regarding copyright
    }
    public void setUp() throws Exception {
            clusterBlock,
import org.junit.Before;
        final ShardId shardId = new ShardId(index, "_na_", 0);
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        expectThrows(IllegalStateException.class, this::executeOnPrimaryOrReplica);
            clusterService,
            );
    }
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index(index).shard(shardId.id());
        };
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        clusterBlock = MetadataIndexStateService.createIndexClosingBlock();
            TransportVerifyShardBeforeCloseAction.ShardRequest,
                createPrimary(primaryRouting, replicationGroup),
    @Before
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
            equalTo("Index shard " + indexShard.shardId() + " is not blocking all operations during closing")
                String allocationId = ((ConcreteShardRequest) capturedRequest.request).getTargetAllocationID();
                logger,
        private final TransportVerifyShardBeforeCloseAction.ShardRequest replicaRequest;
        );
            public void updateGlobalCheckpointForShard(String allocationId, long globalCheckpoint) {}
 *    http://www.apache.org/licenses/LICENSE-2.0
            TransportVerifyShardBeforeCloseAction.ShardRequest,
        verify(indexShard, times(0)).flush(any(FlushRequest.class));
            public void failShard(String message, Exception exception) {
            }
import org.opensearch.action.support.PlainActionFuture;
            mock(ActionFilters.class)
import org.opensearch.common.SetOnce;
            PrimaryResult> operation = new ReplicationOperation<>(
            public long maxSeqNoOfUpdatesOrDeletes() {
    }
        ReplicationOperation.Primary<
    private static ThreadPool threadPool;
        clusterService.close();
        executeOnPrimaryOrReplica();
 * compatible open source license.
            TransportVerifyShardBeforeCloseAction.ShardRequest,
        transport = new CapturingTransport();
        final TransportVerifyShardBeforeCloseAction.ShardRequest request = new TransportVerifyShardBeforeCloseAction.ShardRequest(
    public void testVerifyShardBeforeIndexClosing() throws Throwable {
        final ReplicationGroup replicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);
        try {
    public void testOperationFailsWithNoBlock() {
                return 0;
        verify(indexShard, times(1)).verifyShardBeforeIndexClosing();
        verify(indexShard, times(1)).flush(any(FlushRequest.class));
        private final SetOnce<ReplicationResponse.ShardInfo> shardInfo;
            false,
 * KIND, either express or implied.  See the License for the
        final int nbReplicas = randomIntBetween(1, 10);
    }
                "test",
        }
        threadPool = null;
            }
        );
