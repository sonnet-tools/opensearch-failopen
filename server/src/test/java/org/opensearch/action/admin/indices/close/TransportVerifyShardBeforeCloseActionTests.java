 * compatible open source license.
package org.opensearch.action.admin.indices.close;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    private void executeOnPrimaryOrReplica() throws Throwable {  
        expectThrows(IllegalStateException.class, this::executeOnPrimaryOrReplica);  
import org.opensearch.action.support.replication.ReplicationOperation;  
    public void testOperationFailsWithNoBlock() {
        ReplicationOperation.Replicas<TransportVerifyShardBeforeCloseAction.ShardRequest> proxy = action.newReplicasProxy();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        List<ShardRouting> unavailableShards = randomSubsetOf(randomIntBetween(1, nbReplicas), shardRoutingTable.replicaShards());
import org.opensearch.action.support.PlainActionFuture;
            }
            }  
            transportService,
    private CapturingTransport transport;  
        final ReplicationGroup replicationGroup = new ReplicationGroup(shardRoutingTable, inSyncAllocationIds, trackedShards, 0);  
            null,
            @Override  
        };
                transport.handleResponse(capturedRequest.requestId, new TransportReplicationAction.ReplicaResponse(0L, 0L));
        );
        replicationActions.accept(replicationGroup);
    }
                return primary;
            public void updateGlobalCheckpointForShard(String allocationId, long globalCheckpoint) {}
        final IndexMetadata indexMetadata = clusterState.getMetadata().index(index);  
        ShardStateAction shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
            public long maxSeqNoOfUpdatesOrDeletes() {
}
    private ClusterBlock clusterBlock;
import org.opensearch.threadpool.TestThreadPool;
        executeOnPrimaryOrReplica();
            @Override
                threadPool,  
import org.opensearch.action.support.replication.FanoutReplicationProxy;  
                assertFalse(unavailableShards.stream().anyMatch(shardRouting -> shardRouting.allocationId().getId().equals(allocationId)));
import org.opensearch.cluster.block.ClusterBlocks;
    }
        assertThat(
        threadPool = null;  
        transportService.acceptIncomingRequests();  
        action = new TransportVerifyShardBeforeCloseAction(  
        verify(indexShard, times(1)).sync();  
        final TransportVerifyShardBeforeCloseAction.ShardRequest request = new TransportVerifyShardBeforeCloseAction.ShardRequest(  
            Settings.EMPTY,  
        final ArgumentCaptor<FlushRequest> flushRequest = ArgumentCaptor.forClass(FlushRequest.class);  
        @Override  
            mock(TransportService.class),
import org.opensearch.threadpool.ThreadPool;
        setState(clusterService, new ClusterState.Builder(new ClusterName("test")).build());  
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
    }
    }
            if (actionName.startsWith(ShardStateAction.SHARD_FAILED_ACTION_NAME)) {
    private static ThreadPool threadPool;  
 * this work for additional information regarding copyright
 * under the License.  
 * specific language governing permissions and limitations
                ClusterBlocks.builder().blocks(clusterService.state().blocks()).addIndexBlock("index", clusterBlock).build()  
        );
            mock(IndicesService.class),
    @BeforeClass
        super.setUp();
import org.opensearch.cluster.routing.ShardRouting;  
import static org.mockito.Mockito.verify;
/*
import static org.hamcrest.Matchers.equalTo;
            exception.getMessage(),
            throw new AssertionError(e);
        }
            @Override
                createPrimary(primaryRouting, replicationGroup),
            @Override  
            PrimaryResult> operation = new ReplicationOperation<>(  
        executeOnPrimaryOrReplica(true);
import org.opensearch.core.index.shard.ShardId;
        final TaskId taskId = new TaskId("_node_id", randomNonNegativeLong());
            @Override
            @Override  
            clusterService,
import org.opensearch.core.transport.TransportResponse;  
import org.junit.BeforeClass;
/*
import org.opensearch.index.shard.ReplicationGroup;
        IllegalStateException exception = expectThrows(IllegalStateException.class, this::executeOnPrimaryOrReplica);
            mock(ActionFilters.class)
            TransportVerifyShardBeforeCloseAction.ShardRequest,  
        final long primaryTerm = indexMetadata.primaryTerm(0);
        final PlainActionFuture<Void> res = PlainActionFuture.newFuture();  
 * SPDX-License-Identifier: Apache-2.0
    public void testVerifyShardBeforeIndexClosing() throws Throwable {
            }  
            public long localCheckpoint() {
            this.replicaRequest = replicaRequest;
            mock(ShardStateAction.class),
        TransportVerifyShardBeforeCloseAction action = createAction();  
            mock(IndicesService.class),  
        final String index = "test";  
            assertNotNull(r);
            shardStateAction,  
                return replicationActions;  
            phase1,  
        assertThat(replicationGroup.getUnavailableInSyncShards().size(), greaterThan(0));
import java.util.List;
        transport = new CapturingTransport();
 * not use this file except in compliance with the License.
        TransportService transportService = transport.createTransportService(
                request,
            public ReplicationGroup getReplicationGroup() {
/*  
    }  
 * You may obtain a copy of the License at  
                return replicationGroup;
        } catch (InterruptedException e) {
        action.shardOperationOnPrimary(request, indexShard, ActionListener.wrap(r -> {
            clusterService,  
            return shardInfo.get();  
                assertTrue(unavailableShards.stream().anyMatch(shardRouting -> shardRouting.allocationId().getId().equals(allocationId)));
        transportService.start();
import static org.mockito.Mockito.times;  
import org.opensearch.common.SetOnce;  
 *  
        verify(indexShard, times(0)).flush(any(FlushRequest.class));
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.indices.IndicesService;  
        verify(indexShard, times(1)).flush(any(FlushRequest.class));  
        final ShardRoutingState[] replicaStates = new ShardRoutingState[nbReplicas];
            final String actionName = capturedRequest.action;
 * software distributed under the License is distributed on an
            Collections.emptySet(),
import org.opensearch.cluster.ClusterName;
    public void testShardIsSynced() throws Throwable {
        verify(indexShard, times(1)).verifyShardBeforeIndexClosing();
            public long computedGlobalCheckpoint() {  
            res.get();  
        TransportVerifyShardBeforeCloseAction action = createAction();
    }  
    }
                String allocationId = ((ShardStateAction.FailedShardEntry) capturedRequest.request).getAllocationId();
            }
    @Override
            Settings.EMPTY,
                return 0;  
        );
            new ClusterState.Builder(clusterService.state()).blocks(
            public void failShard(String message, Exception exception) {
    }
                listener,  
            TransportVerifyShardBeforeCloseAction.ShardRequest,
    @Before
            throw e.getCause();
            mock(ThreadPool.class),
        }, res::onFailure));
            }
    public void setUp() throws Exception {  
            x -> clusterService.localNode(),  
        final IndexShard indexShard = mock(IndexShard.class);
    private IndexShard indexShard;
        final Set<String> inSyncAllocationIds = indexMetadata.inSyncAllocationIds(0);
    private TransportVerifyShardBeforeCloseAction createAction() {
import org.opensearch.core.tasks.TaskId;
        }  
            TransportVerifyShardBeforeCloseAction.ShardRequest,
    private static class PrimaryResult implements ReplicationOperation.PrimaryResult<TransportVerifyShardBeforeCloseAction.ShardRequest> {
        );
    public void testShardIsFlushed() throws Throwable {
                listener.onResponse(new PrimaryResult(request));
            } else {  
                TimeValue.timeValueSeconds(60),
                return 0;
            TransportVerifyShardBeforeCloseAction.ShardRequest,
            mock(ActionFilters.class)  
    }  
        assertThat(capturedRequests.length, equalTo(nbReplicas));
            false,
import static org.hamcrest.Matchers.instanceOf;  
import org.opensearch.action.support.ActionFilters;
            ).build()
import org.opensearch.action.support.replication.ReplicationMode;
            @Override  
            public void perform(TransportVerifyShardBeforeCloseAction.ShardRequest request, ActionListener<PrimaryResult> listener) {  
 * Modifications Copyright OpenSearch Contributors. See  
                transport.handleResponse(capturedRequest.requestId, TransportResponse.Empty.INSTANCE);  
import org.opensearch.common.settings.Settings;
        clusterService = createClusterService(threadPool);  
        final ShardId shardId = new ShardId(index, "_na_", 0);
    public void testUnavailableShardsMarkedAsStale() throws Exception {
import org.opensearch.action.admin.indices.flush.FlushRequest;  
        executeOnPrimaryOrReplica(false);
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
        );
    public void testGetReplicationModeWithLocalTranslog() {  
        final int nbReplicas = randomIntBetween(1, 10);  
                return 0;
                "test",
import static org.hamcrest.Matchers.is;
import org.opensearch.cluster.ClusterState;
        doThrow(new IllegalStateException("test")).when(indexShard).verifyShardBeforeIndexClosing();
        final CapturingTransport.CapturedRequest[] capturedRequests = transport.getCapturedRequestsAndClear();  
        verify(indexShard, times(1)).flush(any(FlushRequest.class));
            indexShard.shardId(),
 */
        assertThat(shardInfo.getSuccessful(), equalTo(1 + nbReplicas - unavailableShards.size()));
        unavailableShards.forEach(shardRoutingTableBuilder::removeShard);  
    public static void beforeClass() {  
            replicaStates[i] = ShardRoutingState.STARTED;  
import static org.opensearch.test.ClusterServiceUtils.setState;
    private TransportVerifyShardBeforeCloseAction action;  
    }
        final ShardId shardId = new ShardId("index", "_na_", randomIntBetween(0, 3));  
            taskId
        assertThat(  
        public void setShardInfo(ReplicationResponse.ShardInfo shardInfo) {
                assertThat(capturedRequest.request, instanceOf(ShardStateAction.FailedShardEntry.class));  
    }
        }
        }
        }
        IndexShardRoutingTable shardRoutingTable = clusterState.routingTable().index(index).shard(shardId.id());
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));  
import org.mockito.ArgumentCaptor;  
import org.opensearch.cluster.service.ClusterService;
            }  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
            public long globalCheckpoint() {
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
 * KIND, either express or implied.  See the License for the
        } catch (ExecutionException e) {  
            clusterService,
            @Override
            shardId,  
    @After  
        return new ReplicationOperation.Primary<  
            @Override  
import static org.mockito.Mockito.doNothing;  
        }  
        threadPool = new TestThreadPool(getTestClass().getName());
            threadPool,
import static org.mockito.Mockito.when;
        private final SetOnce<ReplicationResponse.ShardInfo> shardInfo;
        assertThat(flushRequest.getValue().force(), is(true));
                return 0;
        assertThat(shardInfo.getFailures(), arrayWithSize(0));
import org.junit.After;
        final PendingReplicationActions replicationActions = new PendingReplicationActions(primary.shardId(), threadPool);
        ReplicationOperation<  
            equalTo("Index shard " + indexShard.shardId() + " is not blocking all operations during closing")  
        );
import org.opensearch.cluster.action.shard.ShardStateAction;  
                proxy,
import org.opensearch.cluster.metadata.MetadataIndexStateService;
        private PrimaryResult(final TransportVerifyShardBeforeCloseAction.ShardRequest replicaRequest) {  
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;  
            Settings.EMPTY,  
        operation.execute();
            } else if (actionName.startsWith(TransportVerifyShardBeforeCloseAction.NAME)) {
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final IndexShard indexShard = mock(IndexShard.class);
            );  
            this.shardInfo = new SetOnce<>();
    }
                assertTrue(inSyncAllocationIds.stream().anyMatch(inSyncAllocationId -> inSyncAllocationId.equals(allocationId)));  
public class TransportVerifyShardBeforeCloseActionTests extends OpenSearchTestCase {
    public void testOperationFailsWhenNotBlocked() {  
            mock(ThreadPool.class),
import org.opensearch.index.shard.IndexShard;
    public static void afterClass() {
        public void runPostReplicationActions(ActionListener<Void> listener) {
            res.onResponse(null);  
        assertThat(shardInfo.getFailed(), equalTo(0));  
                String allocationId = ((ConcreteShardRequest) capturedRequest.request).getTargetAllocationID();
        indexShard = mock(IndexShard.class);  
            NoopTracer.INSTANCE  
import java.util.Set;
        verify(indexShard, times(0)).flush(any(FlushRequest.class));
import java.util.Collections;  
import org.opensearch.cluster.routing.ShardRoutingState;
        setState(  
        setState(clusterService, clusterState);  
            @Override
        final ReplicationResponse.ShardInfo shardInfo = listener.get().getShardInfo();
    @AfterClass  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.unit.TimeValue;
            TransportVerifyShardBeforeCloseAction.ShardRequest,
    public void testVerifyShardBeforeIndexClosingFailed() {
 * the Apache License, Version 2.0 (the "License"); you may
        shardRoutingTable = shardRoutingTableBuilder.build();
        public ReplicationResponse.ShardInfo getShardInfo() {
    public void tearDown() throws Exception {
        clusterService.close();  
    }  
            exception.getMessage(),
    @Override
import org.opensearch.action.support.replication.PendingReplicationActions;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        final ClusterState clusterState = state(index, true, ShardRoutingState.STARTED, replicaStates);
            }
        verify(indexShard, times(0)).flush(any(FlushRequest.class));
 *
        verify(indexShard, times(1)).verifyShardBeforeIndexClosing();  
import org.opensearch.action.support.replication.TransportReplicationAction;
import static org.mockito.Mockito.mock;
        @Override
import static org.mockito.Mockito.doThrow;
                fail("Test does not support action " + capturedRequest.action);
    private void executeOnPrimaryOrReplica(boolean phase1) throws Throwable {
        clusterBlock = MetadataIndexStateService.createIndexClosingBlock();
        );  
            }
            equalTo("Index shard " + indexShard.shardId() + " must be blocked by " + clusterBlock + " before closing")
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
 * license agreements. See the NOTICE file distributed with
            public PendingReplicationActions getPendingReplicationActions() {
            }
import org.opensearch.test.transport.CapturingTransport;  
        private final TransportVerifyShardBeforeCloseAction.ShardRequest replicaRequest;  
        try {
        when(indexShard.getActiveOperationsCount()).thenReturn(IndexShard.OPERATIONS_BLOCKED);
    private ClusterService clusterService;
        TransportVerifyShardBeforeCloseAction.ShardRequest request = new TransportVerifyShardBeforeCloseAction.ShardRequest(
        for (int i = 0; i < replicaStates.length; i++) {
import static org.mockito.Mockito.any;
            PrimaryResult>() {  
                TimeValue.timeValueMillis(20),  
 * Unless required by applicable law or agreed to in writing,
        super.tearDown();
            listener.onResponse(null);
 */
        when(indexShard.shardId()).thenReturn(shardId);
import org.opensearch.action.support.replication.ReplicationResponse;
        ReplicationOperation.Primary<
    }
import java.util.concurrent.ExecutionException;  
        public TransportVerifyShardBeforeCloseAction.ShardRequest replicaRequest() {  
    }
                assertThat(capturedRequest.request, instanceOf(ConcreteShardRequest.class));  
        }
import org.opensearch.cluster.metadata.IndexMetadata;  
        for (CapturingTransport.CapturedRequest capturedRequest : capturedRequests) {  
        final ShardRouting primaryRouting = shardRoutingTable.primaryShard();
    }
            public void updateLocalCheckpointForShard(String allocationId, long checkpoint) {}
import org.junit.Before;  
            taskId  
 *
    private static
                primaryTerm,
    public void testGetReplicationModeWithRemoteTranslog() {
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
            @Override
import org.opensearch.action.support.replication.TransportReplicationAction.ConcreteShardRequest;  
                logger,
        @Override
        doNothing().when(indexShard).flush(flushRequest.capture());
        TaskId taskId = new TaskId(clusterService.localNode().getId(), 0L);
        IndexShardRoutingTable.Builder shardRoutingTableBuilder = new IndexShardRoutingTable.Builder(shardRoutingTable);
        IllegalStateException exception = expectThrows(IllegalStateException.class, this::executeOnPrimaryOrReplica);  
import org.opensearch.transport.TransportService;  
import java.util.concurrent.TimeUnit;
        final PlainActionFuture<PrimaryResult> listener = new PlainActionFuture<>();  
            clusterBlock,
        final Set<String> trackedShards = shardRoutingTable.getAllAllocationIds();
import org.opensearch.cluster.block.ClusterBlock;
import org.opensearch.core.action.ActionListener;  
            public ShardRouting routingEntry() {  
            }
import static org.hamcrest.Matchers.arrayWithSize;  
    }  
        createPrimary(final ShardRouting primary, final ReplicationGroup replicationGroup) {  
import org.junit.AfterClass;
import static org.hamcrest.Matchers.greaterThan;
            PrimaryResult>
    }
        }  
import org.opensearch.test.OpenSearchTestCase;
        return new TransportVerifyShardBeforeCloseAction(
 *    http://www.apache.org/licenses/LICENSE-2.0
            TransportVerifyShardBeforeCloseAction.ShardRequest,
        executeOnPrimaryOrReplica();
            clusterBlock,
            return replicaRequest;
                new FanoutReplicationProxy<>(proxy)
 */  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            this.shardInfo.set(shardInfo);  
        when(indexShard.getActiveOperationsCount()).thenReturn(randomIntBetween(0, 10));
