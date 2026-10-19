        );
                transportService,
        protected final ShardId shardId;
    @Override
import org.opensearch.test.transport.MockTransport;
 * this work for additional information regarding copyright
            super.shardOperationOnPrimary(shardRequest, shard, listener);
        clusterService = createClusterService(threadPool);
                                .onResponseReceived(requestId, TransportMessageListener.NOOP_LISTENER);
        }
            // The TransportReplicationAction.getIndexShard() method is overridden for testing purpose but we double check here
        }
        for (Thread t : threads) {
                @Override
                actionName,
        }
        }
                        assertBlockIsPresentForDelayedOp();
            assertNoBlocks("block must not exist when executing the operation on primary shard: it should have been blocked before");
            return new Response();
            );
     * execution of the replication action. Also records if the operation is executed on the primary and the replica.
            if (i < delayedOperations) {
            asyncPrimaryAction.run();
            "starting [{}] operations, among which the first [{}] started ops should be blocked by [{}]",
                clusterService,
        ) {
            assertFalse("Index level " + error, clusterState.blocks().hasIndexBlock(shardId.getIndexName(), block));
        ) {
            assertThat(replica.getActiveOperationsCount(), greaterThan(0));
            );
        for (int i = 0; i < numOperations; i++) {
                    } else {
                        public void handleException(TransportException exp) {
                    void runWithPrimaryShardReference(final TransportReplicationAction.PrimaryShardReference reference) {
    public void tearDown() throws Exception {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        @Override
    private class AllPermitsThenBlockAction extends TestAction {
 * this file be licensed under the Apache-2.0 license or a
            final ClusterState clusterState = clusterService.state();
                    assertSuccessfulOperation(action, futures[i].get());
            final PlainActionFuture<Response> listener = new PlainActionFuture<>();
        };
        state.nodes(DiscoveryNodes.builder().add(node1).add(node2).localNodeId(node1.getId()).clusterManagerNodeId(node1.getId()));
        }
            ActionListener<Releasable> onAcquired,
                        }
        when(indexService.getShard(shardId.id())).then(invocation -> (executedOnPrimary.get() == null) ? primary : replica);
import static org.mockito.Mockito.mock;
            ActionListener<PrimaryResult<Request, Response>> listener
    /**
                settings,
            final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
                threadPool,
    @Override
            super(
                    new TransportResponseHandler<TransportReplicationAction.ReplicaResponse>() {
                            if (globalBlock) {
import static org.hamcrest.Matchers.is;
                // non delayed operation might fail depending on the order they were executed
 * SPDX-License-Identifier: Apache-2.0
 */
            TransportService transportService,
        SinglePermitWithBlocksAction(
                                String indexName = primary.shardId().getIndexName();
    }
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
                transportService,
    public void testTransportReplicationActionWithAllPermits() throws Exception {
        final SetOnce<Boolean> executedOnReplica = new SetOnce<>();
     * on {@link ClusterBlockLevel#WRITE}. The block can be a global level or an index level block depending of the
                        @Override
                );
            final int threadId = i;
                final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
            listener.onResponse(new PrimaryResult<>(shardRequest, new Response()));
        final PlainActionFuture<Response> allPermitFuture = new PlainActionFuture<>();
 * the Apache License, Version 2.0 (the "License"); you may
            numOperations,
import org.opensearch.core.rest.RestStatus;
        @Override
        setState(clusterService, state.build());
                        }
    private ShardStateAction shardStateAction;
                ExecutionException exception = expectThrows(ExecutionException.class, "delayed operation should have failed", future::get);
                primaryRequest, allPermitFuture, null
import org.opensearch.cluster.node.DiscoveryNodeRole;
                assertThat(node, equalTo(node2));
            assertNoBlocks("block must not exist when executing the operation on replica shard: it should have been blocked before");
            @Override
            ) {
                asyncPrimaryAction.run();
        state.metadata(Metadata.builder().put(indexMetadata, false).generateClusterUuidIfNeeded());
        for (int i = 0; i < 10; i++) {
            actions[threadId] = singlePermitAction;
        final ClusterState.Builder state = ClusterState.builder(clusterService.state());
     * A type of {@link TransportReplicationAction} that acquires all permits during execution.
            ShardId shardId,
                        assertFalse("Global block must not exist yet", clusterState.blocks().hasGlobalBlock(block));
                shardStateAction,
import org.opensearch.Version;
 */
                    }
                clusterService,
    }
        final int numOperations = scaledRandomIntBetween(4, 32);
        ShardRouting shardRouting = newShardRouting(
        assertThat(clusterBlockException.blocks(), hasItem(equalTo(block)));
                try {
        ) {
            shard.acquireAllPrimaryOperationsPermits(onAcquired, timeout);
            final TestAction singlePermitAction = new SinglePermitWithBlocksAction(
            ActionListener<PrimaryResult<Request, Response>> listener
        @Override
        assertThat(name + " operation should have been successful on 2 shards", response.getShardInfo().getSuccessful(), equalTo(2));
import org.opensearch.cluster.service.ClusterService;
                clusterService,
        }
import org.opensearch.common.lease.Releasable;
                        String indexName = reference.indexShard.shardId().getIndexName();
                    @Override
 * Modifications Copyright OpenSearch Contributors. See
                    final ClusterState clusterState = clusterService.state();
    private String allocationId() {
            return getTestClass().getName() + ".Request";
                        }
            IndexShard shard,
        @Override
    }
import static org.hamcrest.Matchers.hasItem;
            super.shardOperationOnReplica(shardRequest, replica, listener);
    }
    }
            IndexShard shard,
import org.opensearch.index.shard.IndexShard;
        Set<DiscoveryNodeRole> roles = new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES);
            .primaryTerm(shardId.id(), primary.getOperationPrimaryTerm())
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
    public void setUp() throws Exception {
                settings,
        assertThat(name + " operation must have a non null result", response, notNullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
                    request,
            this.shardId = Objects.requireNonNull(shardId);
            shard.acquireAllReplicaOperationsPermits(primaryTerm, globalCheckpoint, maxSeqNo, onAcquired, timeout);
            ClusterService clusterService,
            clusterService,
            Request request,
        @Override
        @Override
     * value of the {@code globalBlock} parameter in the constructor. When the operation is executed on shards it
                        if (delayed) {
                globalBlock
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.cluster.routing.RecoverySource;
 * specific language governing permissions and limitations
        }
            ClusterService clusterService,
        ShardId shardId,
        }
                        @Override
        final SetOnce<Boolean> executedOnPrimary;
                            delayedOperationsBarrier.await();
                    new TransportReplicationAction.ConcreteShardRequest<>(request(), allocationId(), primaryTerm());
    private long primaryTerm() {
                        onFailure(e);
            return this.actionName;
    ) {
import org.opensearch.transport.TransportRequest;
            String actionName,
            // The TransportReplicationAction.getIndexShard() method is overridden for testing purpose but we double check here
        }
            IndexShard replica
        final int delayedOperations = randomIntBetween(1, numOperations);
import static org.hamcrest.Matchers.instanceOf;
        @Override
import static org.hamcrest.Matchers.startsWith;
import org.opensearch.cluster.block.ClusterBlockLevel;
    private class SinglePermitWithBlocksAction extends TestAction {
        assertThat(name + " operation should not have been executed on primary", action.executedOnPrimary.get(), nullValue());
        Request(StreamInput in) throws IOException {
                threadPool,
        for (int i = 0; i < numOperations; i++) {
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
                replica,
            assertSame(primary, shard);
            final String id = Integer.toString(i);
            TransportService transportService,
import org.opensearch.index.engine.InternalEngineFactory;
import static java.util.Collections.emptySet;
            this.executedOnPrimary = executedOnPrimary;
        final String name = action.getActionName();
                        assertFalse("Index block must not exist yet", clusterState.blocks().hasIndexBlock(indexName, block));
import static java.util.Collections.emptyMap;
            primary,
                transportService,
                actionName,
        return new Request(primary.shardId());
            boolean globalBlock
        block = new ClusterBlock(randomIntBetween(1, 10), randomAlphaOfLength(5), false, true, false, restStatus, ClusterBlockLevel.ALL);
        }
                        logger.trace("releasing delayed operations");
        assertThat(name + " operation should have been executed on primary", action.executedOnPrimary.get(), is(true));
import org.opensearch.core.index.shard.ShardId;
                        private TransportResponseHandler<TransportReplicationAction.ReplicaResponse> getResponseHandler() {
        thread.start();
            );
            long primaryTerm,
import org.opensearch.core.action.ActionListener;
                            return ThreadPool.Names.SAME;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            assertThat(shard.getActiveOperationsCount(), greaterThan(0));
import java.util.UUID;
        IndexMetadata indexMetadata = IndexMetadata.builder(shardId.getIndexName())
            node1.getId(),
                actionName,
                assertFailedOperation(action, exception);
                TransportReplicationAction.AsyncPrimaryAction asyncPrimaryAction = singlePermitAction.new AsyncPrimaryAction(
                    private void assertBlockIsPresentForDelayedOp() {
        @Override
            Request shardRequest,
            .settings(indexSettings)
 * software distributed under the License is distributed on an
            });
 * This test tests the concurrent execution of several transport replication actions. All of these actions (except one) acquire a single
                            return (TransportResponseHandler<TransportReplicationAction.ReplicaResponse>) getResponseHandlers()
            t.join();
            IndexShard shard,
        transportService.acceptIncomingRequests();
        protected void shardOperationOnPrimary(
            IndexShard replica,
    private ClusterService clusterService;
    /**
                    }
import org.opensearch.threadpool.ThreadPool;
                replica,
            transportService,
        );
                    logger.trace("adding test block to cluster state {}", block);
                        }
/**
        AllPermitsThenBlockAction(
                new SetOnce<>()
     */
        }
                        super.runWithPrimaryShardReference(reference);
            this.primary = Objects.requireNonNull(primary);
        }
                        if (delayed) {
                            } else {
                            getResponseHandler().handleResponse(response);
        super.setUp();
        logger.trace("waiting for all operations to terminate");
            assertEquals(shardId, replica.shardId());
            replica
            transportSettings,
    static class Request extends ReplicationRequest<Request> {
            shardId,
        DiscoveryNode node2 = new DiscoveryNode("_name2", "_node2", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
    /**
import org.opensearch.cluster.block.ClusterBlock;
            NoopTracer.INSTANCE
            IndexShard primary,
                threadPool,
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.common.unit.TimeValue;
            Settings settings,
            String actionName,
import java.util.ArrayList;
                shardId,
import java.util.Objects;
        Thread thread = new Thread(() -> {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;
            Settings.EMPTY,
            assertEquals("All permits must be acquired", IndexShard.OPERATIONS_BLOCKED, replica.getActiveOperationsCount());
import org.opensearch.cluster.ClusterState;
                ) {
            executedOnReplica.set(true);
                        blocks.addIndexBlock(indexName, block);
            this.globalBlock = globalBlock;
                assertThat(action, allOf(startsWith("cluster:admin/test/"), endsWith("[r]")));
                        public void handleResponse(TransportReplicationAction.ReplicaResponse response) {
            } else {
            ThreadPool threadPool,
        protected void acquirePrimaryOperationPermit(IndexShard shard, Request request, ActionListener<Releasable> onAcquired) {
        protected Response newResponseInstance(StreamInput in) {
 *
    }
        protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
            IndexShard primary,
import org.opensearch.cluster.routing.ShardRoutingState;
            Settings settings,
                shardId,
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
            final PlainActionFuture<Response> future = futures[i];
        final CyclicBarrier delayedOperationsBarrier = new CyclicBarrier(delayedOperations + 1);
                clusterService.state().nodes().get("_node2").getId(),
            long maxSeqNo
                Request::new,
 * GitHub history for details.
                    if (globalBlock) {
        });
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        protected final IndexShard primary;
            threadPool,
        clusterService.close();
        ) {
        state.routingTable(RoutingTable.builder().add(routing.build()).build());
            super(
import org.opensearch.cluster.block.ClusterBlocks;
        @Override
        final TestAction[] actions = new TestAction[numOperations];
            .put(SETTING_INDEX_UUID, shardId.getIndex().getUUID())
                new ActionFilters(new HashSet<>()),
        public ClusterBlockLevel indexBlockLevel() {
                        }
        final PlainActionFuture<Response>[] futures = new PlainActionFuture[numOperations];
                    protected void doRun() throws Exception {
import java.util.HashSet;
import static org.hamcrest.Matchers.greaterThan;
            delayedOperations,
        MockTransport transport = new MockTransport() {
    }
                    );
 * These actions are all started at the same time, but some are delayed until one last action.
            assertSame(replica, replica);
            .putMapping("{ \"properties\": { \"value\":  { \"type\": \"short\"}}}")
            long globalCheckpoint,
        final IndexService indexService = mock(IndexService.class);
            bta -> node1,
            null,
        );
                primary,
                            getResponseHandler().handleException(exp);
                    @Override
                    assertSame(primary, reference.indexShard);
            return globalBlock == false ? ClusterBlockLevel.WRITE : super.indexBlockLevel();
        Request(ShardId shardId) {
    }
                } catch (final ExecutionException e) {
import java.util.Set;
import java.util.List;
                            }
            assertEquals(shardId, primary.shardId());
import org.opensearch.action.support.PlainActionFuture;
            };
                        "All permits must be acquired",
            }
                    public void onFailure(Exception e) {
        logger.trace("now starting the operation that acquires all permits and sets the block in the cluster state");
                    } catch (InterruptedException | BrokenBarrierException e) {
                    try {
                                assertTrue("Index block must exist", clusterState.blocks().hasIndexBlock(indexName, block));
        assertThat(exception.getCause(), instanceOf(ClusterBlockException.class));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
        protected final IndexShard replica;
        protected void shardOperationOnPrimary(
 * compatible open source license.
        IndexShard primary,
            ClusterService clusterService,
                settings,
        }
                mockIndicesService(shardId, executedOnPrimary, primary, replica),
        replica = newShard(primary.shardId(), false, node2.getId(), indexMetadata, null);
 */
            Settings settings,
            TransportService transportService,
            ActionListener<PrimaryResult<Request, Response>> listener
            }
            SetOnce<Boolean> executedOnPrimary
/*
 *
import org.opensearch.cluster.metadata.IndexMetadata;
    private void assertSuccessfulOperation(final TestAction action, final Response response) {
            ShardRoutingState.INITIALIZING,
            p -> newShard(shardRouting, indexSettings, new EngineBackedIndexerFactory(new InternalEngineFactory())),
        @Override
    private Request request() {
        protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
                    @Override
            assertEquals(
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            executedOnPrimary.set(true);
        }
                threadPool,
        final Response allPermitsResponse = allPermitFuture.get();
    }
                        assertBlockIsPresentForDelayedOp();
import org.opensearch.common.SetOnce;
import static org.hamcrest.Matchers.allOf;
                    }
        final String name = action.getActionName();
        transportService = transport.createTransportService(
                        @Override
            Thread thread = new Thread(() -> {
            super(shardId);
        DiscoveryNode node1 = new DiscoveryNode("_name1", "_node1", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        when(indicesService.indexServiceSafe(shardId.getIndex())).then(invocation -> indexService);
                        }
     * verifies that at least 1 permit is acquired and that there is no blocks in the cluster state.
            .build();
        );
        final IndicesService indicesService = mock(IndicesService.class);
    }
                }
                "cluster:admin/test/single_permit[" + threadId + "]",
    }
                        assertSame(primary, reference.indexShard);
        protected void acquireReplicaOperationPermit(
                        }
import static org.hamcrest.Matchers.notNullValue;
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
            assertEquals("All permits must be acquired", IndexShard.OPERATIONS_BLOCKED, shard.getActiveOperationsCount());
                primary,
 *
    private ClusterBlock block;
    private void assertFailedOperation(final TestAction action, final ExecutionException exception) {
        private final boolean globalBlock;
                        reference.indexShard.getActiveOperationsCount()
import org.opensearch.cluster.action.shard.ShardStateAction;
                ThreadPool.Names.SAME
public class TransportReplicationAllPermitsAcquisitionTests extends IndexShardTestCase {
                                assertTrue("Global block must exist", clusterState.blocks().hasGlobalBlock(block));
            ThreadPool threadPool,
                shardStateAction,
 * Licensed to Elasticsearch under one or more contributor
        final TestAction allPermitsAction = new AllPermitsThenBlockAction(
        }
        }
        super.tearDown();
import static org.hamcrest.Matchers.equalTo;
        assertThat(name + " operation should not have been executed on replica", action.executedOnReplica.get(), nullValue());
        routing.addIndexShard(new IndexShardRoutingTable.Builder(shardId).addShard(primary.routingEntry()).build());
                        delayedOperationsBarrier.await();
                new SetOnce<>()
        private final TimeValue timeout = TimeValue.timeValueSeconds(30L);
     * A type of {@link TransportReplicationAction} that allows to use the primary and replica shards passed to the constructor for the
                    final ClusterBlocks.Builder blocks = ClusterBlocks.builder();
            .put(SETTING_CREATION_DATE, System.currentTimeMillis())
                    }
import org.opensearch.transport.TransportException;
import org.opensearch.index.IndexService;
 */
            String actionName,
import static org.hamcrest.Matchers.nullValue;
            // that the permit has been acquired on the replica shard
        Settings indexSettings = Settings.builder()
                    }
                Settings.EMPTY,
import static org.opensearch.test.ClusterServiceUtils.setState;
 * under the License.
        assertThat(name + " operation should have been executed on replica", action.executedOnReplica.get(), is(true));
            shardStateAction,
/*
        return indicesService;
            listener.onResponse(new ReplicaResult());
        recoverReplica(replica, primary, true);
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
        globalBlock = randomBoolean();
                "Replica is always assigned to node 2 in this test",
    private TransportService transportService;
                clusterService,
 * license agreements. See the NOTICE file distributed with
        @SuppressWarnings("unchecked")
                        @SuppressWarnings("unchecked")
            threadPool,
 * <p>
/*
                Request::new,
        ) {
        return primary.getOperationPrimaryTerm();
                    }
import static org.hamcrest.Matchers.endsWith;
import org.opensearch.common.settings.Settings;
                transportService,
        }
                    assertEquals(
            ShardStateAction shardStateAction,
import org.opensearch.cluster.node.DiscoveryNode;
    private IndexShard replica;
        );
        protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
        }
 * You may obtain a copy of the License at
import java.io.IOException;
        return primary.routingEntry().allocationId().getId();
            return globalBlock ? ClusterBlockLevel.WRITE : super.globalBlockLevel();
            true,
                // the primary and the replica, so redirect the request back to node1.
 * This last action is special because it acquires all the permits on shards, adds the block to the cluster state and then "releases" the
            Request shardRequest,
        private void assertNoBlocks(final String error) {
    @After
                        public String executor() {
        protected ClusterBlockLevel globalBlockLevel() {
        public String getActionName() {
import java.util.concurrent.ExecutionException;
            ShardId shardId,
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        SetOnce<Boolean> executedOnPrimary,
import org.opensearch.cluster.node.DiscoveryNodes;
 * permit during their execution on shards and are expected to fail if a global level or index level block is present in the cluster state.
        }
    }
    static class Response extends ReplicationResponse {}
            futures[threadId] = listener;
        ) {
        primary = newStartedShard(
                    super.runWithPrimaryShardReference(reference);
            emptySet(),
                // node2 doesn't really exist, but we are performing some trickery in mockIndicesService() to pretend that node1 holds both
            super.shardOperationOnPrimary(shardRequest, shard, listener);
package org.opensearch.action.support.replication;
            threads.add(thread);
        final Settings transportSettings = Settings.builder().put("node.name", node1.getId()).build();
import org.opensearch.transport.TransportService;
                shardStateAction,
                        public TransportReplicationAction.ReplicaResponse read(StreamInput in) throws IOException {
        logger.trace(
                            return new TransportReplicationAction.ReplicaResponse(in);
import org.opensearch.indices.IndicesService;
            indexDoc(primary, "_doc", id, "{\"value\":" + id + "}");
            block
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            IndexShard shard,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
            IndexShard primary,
            .build();
import org.opensearch.cluster.block.ClusterBlockException;
    private IndexShard primary;
            TransportReplicationAction.AsyncPrimaryAction asyncPrimaryAction = allPermitsAction.new AsyncPrimaryAction(
import org.junit.After;
        ) {
                transportService.sendRequest(
                    }
                    assertFailedOperation(action, e);
 * Unless required by applicable law or agreed to in writing,
        shardId = new ShardId("index", UUID.randomUUID().toString(), 0);
        RestStatus restStatus = randomFrom(RestStatus.values());
            super(in);
        IndexShard replica
                        super.onFailure(e);
}
                shardStateAction,
            true
                    transportService.getLocalNode(),
 * ownership. Elasticsearch licenses this file to you under
        assertSuccessfulOperation(allPermitsAction, allPermitsResponse);
            final boolean delayed = (threadId < delayedOperations);
 * all permit action that sets the block and those executed afterwards that are doomed to fail because of the block.
        protected void shardOperationOnPrimary(
 * not use this file except in compliance with the License.
        @Override
            thread.start();
        transportService.stop();
        }
        IndexRoutingTable.Builder routing = IndexRoutingTable.builder(indexMetadata.getIndex());
            super(
import org.opensearch.core.common.io.stream.StreamInput;
                        blocks.addGlobalBlock(block);
    private boolean globalBlock;
                void runWithPrimaryShardReference(final TransportReplicationAction.PrimaryShardReference reference) {
        closeShards(primary, replica);
        }
            ShardStateAction shardStateAction,
        // An action which acquires all operation permits during execution and set a block
     */
        transportService.start();
import java.util.concurrent.BrokenBarrierException;
import static org.mockito.Mockito.when;
            );
                }
import org.opensearch.transport.TransportMessageListener;
            final TestAction action = actions[i];
        }
                        assertThat(reference.indexShard.getActiveOperationsCount(), greaterThan(0));
                };
                        super.doRun();
        @Override
     * A type of {@link TransportReplicationAction} that acquires a single permit during execution and that blocks
                shardId,
            shardId,
        TestAction(
            assertFalse("Global level " + error, clusterState.blocks().hasGlobalBlock(block));
            ShardStateAction shardStateAction,
                        @Override
            ThreadPool threadPool,
            this.replica = Objects.requireNonNull(replica);
                    primaryRequest, listener, null
 * The OpenSearch Contributors require contributions made to
                replica.routingEntry().currentNodeId()
 * KIND, either express or implied.  See the License for the
                new TransportReplicationAction.ConcreteShardRequest<>(request(), allocationId(), primaryTerm());
import org.opensearch.action.support.ActionFilters;
            );
                    setState(clusterService, ClusterState.builder(clusterState).blocks(blocks));
    private abstract class TestAction extends TransportReplicationAction<Request, Request, Response> {
            Request shardRequest,
     */
                            logger.trace("op [{}] has started and will resume execution once allPermitsAction is terminated", threadId);
                        IndexShard.OPERATIONS_BLOCKED,
            super.shardOperationOnReplica(shardRequest, replica, listener);
        public String toString() {
        }
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.transport.TransportResponseHandler;
    @Before
            IndexShard replica,
                primary,
                            final ClusterState clusterState = clusterService.state();
    }
 * previously delayed single permit actions. This way, there is a clear transition between the single permit actions executed before the
    private ShardId shardId;
    private static IndicesService mockIndicesService(
import org.junit.Before;
        ClusterBlockException clusterBlockException = (ClusterBlockException) exception.getCause();
            // that the permit has been acquired on the primary shard
            .put(SETTING_NUMBER_OF_SHARDS, 1)
            ShardId shardId,
import java.util.concurrent.CyclicBarrier;
            "cluster:admin/test/all_permits",
                replica,
        final List<Thread> threads = new ArrayList<>(delayedOperationsBarrier.getParties());
        threads.add(thread);
import org.opensearch.index.shard.IndexShardTestCase;
                    action,
import org.opensearch.cluster.routing.RoutingTable;
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
