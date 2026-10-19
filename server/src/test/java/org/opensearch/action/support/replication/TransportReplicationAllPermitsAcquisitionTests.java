import org.opensearch.action.support.PlainActionFuture;
                    protected void doRun() throws Exception {
                    }  
        ) {
                };
 *
            emptySet(),
            Settings settings,  
        }
                    new TransportReplicationAction.ConcreteShardRequest<>(request(), allocationId(), primaryTerm());
        public String getActionName() {
                    }  
            clusterService,  
                replica,
import static org.mockito.Mockito.when;  
                shardId,  
        final int numOperations = scaledRandomIntBetween(4, 32);
            final boolean delayed = (threadId < delayedOperations);
 * this file be licensed under the Apache-2.0 license or a
                        super.onFailure(e);
            node1.getId(),
import org.opensearch.cluster.block.ClusterBlockLevel;
        final List<Thread> threads = new ArrayList<>(delayedOperationsBarrier.getParties());  
import org.opensearch.cluster.routing.ShardRoutingState;
            String actionName,
                        "All permits must be acquired",  
                shardStateAction,  
        return new Request(primary.shardId());  
        IndexShard primary,
import org.opensearch.core.rest.RestStatus;
            executedOnPrimary.set(true);  
            );  
 */
                    if (globalBlock) {
                TransportReplicationAction.AsyncPrimaryAction asyncPrimaryAction = singlePermitAction.new AsyncPrimaryAction(  
            p -> newShard(shardRouting, indexSettings, new EngineBackedIndexerFactory(new InternalEngineFactory())),
        when(indexService.getShard(shardId.id())).then(invocation -> (executedOnPrimary.get() == null) ? primary : replica);
        assertThat(name + " operation should have been executed on replica", action.executedOnReplica.get(), is(true));
            final int threadId = i;
                        String indexName = reference.indexShard.shardId().getIndexName();  
        );  
        TestAction(  
        super.tearDown();
                                assertTrue("Global block must exist", clusterState.blocks().hasGlobalBlock(block));  
            IndexShard shard,  
import java.util.HashSet;  
        }
        }  
        Request(StreamInput in) throws IOException {
                    }  
        logger.trace("waiting for all operations to terminate");
            replica
        MockTransport transport = new MockTransport() {  
            final PlainActionFuture<Response> listener = new PlainActionFuture<>();
                primary,  
 * This test tests the concurrent execution of several transport replication actions. All of these actions (except one) acquire a single  
                    assertEquals(
            // that the permit has been acquired on the primary shard
        final Response allPermitsResponse = allPermitFuture.get();  
                globalBlock
        protected final IndexShard replica;
        transportService.stop();
            final ClusterState clusterState = clusterService.state();
            long primaryTerm,
            super(  
        }
    private abstract class TestAction extends TransportReplicationAction<Request, Request, Response> {
        assertThat(name + " operation must have a non null result", response, notNullValue());
import org.opensearch.cluster.node.DiscoveryNodeRole;  
                shardId,
            t.join();  
                primaryRequest, allPermitFuture, null
 */  
                try {
        return primary.routingEntry().allocationId().getId();
        final TestAction allPermitsAction = new AllPermitsThenBlockAction(
                    super.runWithPrimaryShardReference(reference);
import java.util.UUID;
    }
/*
                        public String executor() {
        private final TimeValue timeout = TimeValue.timeValueSeconds(30L);  
                    final ClusterState clusterState = clusterService.state();  
                        public TransportReplicationAction.ReplicaResponse read(StreamInput in) throws IOException {
import org.opensearch.indices.IndicesService;
import static org.hamcrest.Matchers.endsWith;
                        }
    static class Response extends ReplicationResponse {}
            ClusterService clusterService,
            Settings.EMPTY,  
import org.opensearch.cluster.node.DiscoveryNodes;
            super(in);  
            TransportService transportService,
                );
        protected void shardOperationOnPrimary(
    }
                        assertSame(primary, reference.indexShard);  
                    assertSuccessfulOperation(action, futures[i].get());
import org.opensearch.cluster.routing.RecoverySource;
                new ActionFilters(new HashSet<>()),
        @Override  
import static org.hamcrest.Matchers.startsWith;
            super.shardOperationOnPrimary(shardRequest, shard, listener);
            .put(SETTING_INDEX_UUID, shardId.getIndex().getUUID())  
                settings,
        ) {  
                    @Override  
     * A type of {@link TransportReplicationAction} that acquires a single permit during execution and that blocks
 * compatible open source license.
                    }
 * all permit action that sets the block and those executed afterwards that are doomed to fail because of the block.  
        );  
                assertThat(node, equalTo(node2));
import static org.hamcrest.Matchers.equalTo;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            listener.onResponse(new ReplicaResult());  
        final CyclicBarrier delayedOperationsBarrier = new CyclicBarrier(delayedOperations + 1);
        final ClusterState.Builder state = ClusterState.builder(clusterService.state());
            threadPool,
        @Override
        AllPermitsThenBlockAction(
            .putMapping("{ \"properties\": { \"value\":  { \"type\": \"short\"}}}")  
                shardStateAction,  
        assertSuccessfulOperation(allPermitsAction, allPermitsResponse);
                clusterService,  
            block
 * <p>  
        DiscoveryNode node2 = new DiscoveryNode("_name2", "_node2", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);
import org.opensearch.threadpool.ThreadPool;
            ActionListener<PrimaryResult<Request, Response>> listener
     */  
import static org.hamcrest.Matchers.hasItem;
                        blocks.addIndexBlock(indexName, block);
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
    private class SinglePermitWithBlocksAction extends TestAction {
            );  
            ClusterService clusterService,  
    }
        ) {
            .put(SETTING_CREATION_DATE, System.currentTimeMillis())  
            return getTestClass().getName() + ".Request";  
import java.util.concurrent.CyclicBarrier;  
     * value of the {@code globalBlock} parameter in the constructor. When the operation is executed on shards it
            IndexShard replica
                threadPool,
import org.opensearch.cluster.block.ClusterBlock;
            numOperations,  
        thread.start();
                replica,
    private ShardStateAction shardStateAction;  
        ) {
}
                                .onResponseReceived(requestId, TransportMessageListener.NOOP_LISTENER);
    }
                        @Override
            ShardStateAction shardStateAction,
 * under the License.  
                // the primary and the replica, so redirect the request back to node1.  
                    assertSame(primary, reference.indexShard);
        primary = newStartedShard(  
     * A type of {@link TransportReplicationAction} that acquires all permits during execution.
import org.opensearch.action.support.ActionFilters;
        ) {
    /**  
            return this.actionName;  
            NoopTracer.INSTANCE  
        }
                transportService.sendRequest(
        protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {  
import org.opensearch.index.engine.InternalEngineFactory;  
import java.util.Set;  
 */
                primary,  
        public ClusterBlockLevel indexBlockLevel() {
            Request request,
public class TransportReplicationAllPermitsAcquisitionTests extends IndexShardTestCase {
                            }
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
            ThreadPool threadPool,
     * verifies that at least 1 permit is acquired and that there is no blocks in the cluster state.
            assertThat(shard.getActiveOperationsCount(), greaterThan(0));
            thread.start();
                "cluster:admin/test/single_permit[" + threadId + "]",  
        private void assertNoBlocks(final String error) {  
import static org.opensearch.cluster.routing.TestShardRouting.newShardRouting;
        }
        }  
        // An action which acquires all operation permits during execution and set a block
                        public void handleResponse(TransportReplicationAction.ReplicaResponse response) {  
                            getResponseHandler().handleResponse(response);
            assertSame(replica, replica);
    static class Request extends ReplicationRequest<Request> {
            Settings settings,
        Thread thread = new Thread(() -> {  
package org.opensearch.action.support.replication;
    }
        protected Response newResponseInstance(StreamInput in) {
        super.setUp();
            };
            );
                threadPool,
        setState(clusterService, state.build());
            shardStateAction,
        ShardId shardId,
                ExecutionException exception = expectThrows(ExecutionException.class, "delayed operation should have failed", future::get);  
                transportService,
            assertEquals(  
     * execution of the replication action. Also records if the operation is executed on the primary and the replica.
        assertThat(name + " operation should have been executed on primary", action.executedOnPrimary.get(), is(true));  
import org.opensearch.test.transport.MockTransport;  
            IndexShard replica,
        ClusterBlockException clusterBlockException = (ClusterBlockException) exception.getCause();
                void runWithPrimaryShardReference(final TransportReplicationAction.PrimaryShardReference reference) {
        routing.addIndexShard(new IndexShardRoutingTable.Builder(shardId).addShard(primary.routingEntry()).build());
    private boolean globalBlock;
                actionName,  
        final Settings transportSettings = Settings.builder().put("node.name", node1.getId()).build();
            super(
                settings,
                threadPool,  
            .primaryTerm(shardId.id(), primary.getOperationPrimaryTerm())
            shardId,  
            final TestAction singlePermitAction = new SinglePermitWithBlocksAction(
import org.opensearch.common.lease.Releasable;
        IndexRoutingTable.Builder routing = IndexRoutingTable.builder(indexMetadata.getIndex());
                        assertBlockIsPresentForDelayedOp();
            .settings(indexSettings)
            assertFalse("Global level " + error, clusterState.blocks().hasGlobalBlock(block));
                    final ClusterBlocks.Builder blocks = ClusterBlocks.builder();
                        if (delayed) {  
                replica,
import org.opensearch.transport.TransportMessageListener;  
            // that the permit has been acquired on the replica shard
        protected final IndexShard primary;
        public String toString() {
        IndexShard replica
            return new Response();
        final IndicesService indicesService = mock(IndicesService.class);
                // node2 doesn't really exist, but we are performing some trickery in mockIndicesService() to pretend that node1 holds both
        @Override
                transportService,
            .put(SETTING_NUMBER_OF_REPLICAS, 1)
                        @SuppressWarnings("unchecked")
                    private void assertBlockIsPresentForDelayedOp() {
            assertNoBlocks("block must not exist when executing the operation on replica shard: it should have been blocked before");
                        assertFalse("Global block must not exist yet", clusterState.blocks().hasGlobalBlock(block));  
        IndexMetadata indexMetadata = IndexMetadata.builder(shardId.getIndexName())  
        ) {
import org.opensearch.cluster.metadata.IndexMetadata;  
        ShardRouting shardRouting = newShardRouting(
        }
            indexDoc(primary, "_doc", id, "{\"value\":" + id + "}");  
                            return ThreadPool.Names.SAME;
            executedOnReplica.set(true);
        state.metadata(Metadata.builder().put(indexMetadata, false).generateClusterUuidIfNeeded());
import org.opensearch.transport.TransportException;
            listener.onResponse(new PrimaryResult<>(shardRequest, new Response()));
        }
            return globalBlock == false ? ClusterBlockLevel.WRITE : super.indexBlockLevel();  
        Settings indexSettings = Settings.builder()
import org.opensearch.cluster.service.ClusterService;
import static java.util.Collections.emptyMap;  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
                    @Override
            ) {
        }
            assertThat(replica.getActiveOperationsCount(), greaterThan(0));
        }
        );
            final String id = Integer.toString(i);
                    try {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
            threadPool,
            primary,
        }
        }  
 * KIND, either express or implied.  See the License for the
            assertNoBlocks("block must not exist when executing the operation on primary shard: it should have been blocked before");  
            SetOnce<Boolean> executedOnPrimary
        @Override  
import java.util.ArrayList;
        final TestAction[] actions = new TestAction[numOperations];
        );
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
                    assertFailedOperation(action, e);
        }  
    private String allocationId() {
                    request,
            IndexShard primary,
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            "starting [{}] operations, among which the first [{}] started ops should be blocked by [{}]",
            protected void onSendRequest(long requestId, String action, TransportRequest request, DiscoveryNode node) {
        return primary.getOperationPrimaryTerm();
                        @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.index.shard.ShardId;  
    private ClusterBlock block;
import static org.mockito.Mockito.mock;
import org.opensearch.transport.TransportResponseHandler;
        Set<DiscoveryNodeRole> roles = new HashSet<>(DiscoveryNodeRole.BUILT_IN_ROLES);
import org.opensearch.common.unit.TimeValue;  
        protected final ShardId shardId;  
import org.opensearch.cluster.node.DiscoveryNode;
        @SuppressWarnings("unchecked")
            ActionListener<PrimaryResult<Request, Response>> listener  
        final IndexService indexService = mock(IndexService.class);
 * These actions are all started at the same time, but some are delayed until one last action.
                Request::new,
        @Override
        for (int i = 0; i < 10; i++) {
        transportService.start();
        DiscoveryNode node1 = new DiscoveryNode("_name1", "_node1", buildNewFakeTransportAddress(), emptyMap(), roles, Version.CURRENT);  
        @Override  
import org.opensearch.core.action.ActionListener;
                        assertBlockIsPresentForDelayedOp();
                    );  
                        onFailure(e);  
 * permit during their execution on shards and are expected to fail if a global level or index level block is present in the cluster state.
                shardStateAction,
        assertThat(exception.getCause(), instanceOf(ClusterBlockException.class));
        globalBlock = randomBoolean();
 *
        });  
/*
        clusterService.close();  
        closeShards(primary, replica);
            Thread thread = new Thread(() -> {  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                shardId,
                        delayedOperationsBarrier.await();
 * license agreements. See the NOTICE file distributed with
        transportService = transport.createTransportService(
 * GitHub history for details.
                    }  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            ShardId shardId,  
    public void testTransportReplicationActionWithAllPermits() throws Exception {
        );  
import static org.opensearch.test.ClusterServiceUtils.setState;  
            long maxSeqNo  
    private void assertSuccessfulOperation(final TestAction action, final Response response) {
        final int delayedOperations = randomIntBetween(1, numOperations);  
        protected ClusterBlockLevel globalBlockLevel() {  
    private void assertFailedOperation(final TestAction action, final ExecutionException exception) {  
        block = new ClusterBlock(randomIntBetween(1, 10), randomAlphaOfLength(5), false, true, false, restStatus, ClusterBlockLevel.ALL);
            bta -> node1,  
            this.replica = Objects.requireNonNull(replica);
            true,
                    primaryRequest, listener, null
        final SetOnce<Boolean> executedOnReplica = new SetOnce<>();
import org.opensearch.cluster.block.ClusterBlocks;
            assertFalse("Index level " + error, clusterState.blocks().hasIndexBlock(shardId.getIndexName(), block));  
    /**
            );  
import org.opensearch.cluster.routing.IndexRoutingTable;
                                String indexName = primary.shardId().getIndexName();
            assertEquals("All permits must be acquired", IndexShard.OPERATIONS_BLOCKED, shard.getActiveOperationsCount());
            assertEquals("All permits must be acquired", IndexShard.OPERATIONS_BLOCKED, replica.getActiveOperationsCount());
        Request(ShardId shardId) {  
import org.opensearch.transport.TransportRequest;
        @Override  
                    void runWithPrimaryShardReference(final TransportReplicationAction.PrimaryShardReference reference) {
    private TransportService transportService;
                // non delayed operation might fail depending on the order they were executed  
 * This last action is special because it acquires all the permits on shards, adds the block to the cluster state and then "releases" the
            final TestAction action = actions[i];  
                        logger.trace("releasing delayed operations");  
     */  
    private Request request() {
        logger.trace(
                    logger.trace("adding test block to cluster state {}", block);
    private long primaryTerm() {  
 * Licensed to Elasticsearch under one or more contributor  
 *  
                            } else {
                        IndexShard.OPERATIONS_BLOCKED,
 * You may obtain a copy of the License at  
        SetOnce<Boolean> executedOnPrimary,  
        }
        final PlainActionFuture<Response>[] futures = new PlainActionFuture[numOperations];  
                primary,
    private ClusterService clusterService;
    @After
        threads.add(thread);
    }
        final SetOnce<Boolean> executedOnPrimary;  
     * A type of {@link TransportReplicationAction} that allows to use the primary and replica shards passed to the constructor for the
                            getResponseHandler().handleException(exp);  
            super(shardId);
 * not use this file except in compliance with the License.
        assertThat(name + " operation should have been successful on 2 shards", response.getShardInfo().getSuccessful(), equalTo(2));  
            });  
            threads.add(thread);
        protected void acquirePrimaryOperationPermit(IndexShard shard, Request request, ActionListener<Releasable> onAcquired) {
                    public void onFailure(Exception e) {  
                replica.routingEntry().currentNodeId()  
            IndexShard shard,  
                } catch (final ExecutionException e) {  
                    @Override  
            RecoverySource.EmptyStoreRecoverySource.INSTANCE
        }
import org.opensearch.cluster.routing.ShardRouting;  
        }
import org.opensearch.index.shard.IndexShard;
                    transportService.getLocalNode(),
            ThreadPool threadPool,
            IndexShard primary,
            IndexShard shard,
                ) {
        recoverReplica(replica, primary, true);
import static org.hamcrest.Matchers.instanceOf;  
 * Modifications Copyright OpenSearch Contributors. See  
            @Override
    public void tearDown() throws Exception {  
            final PlainActionFuture<Response> future = futures[i];
            super.shardOperationOnReplica(shardRequest, replica, listener);  
 */
            ActionListener<Releasable> onAcquired,  
            .build();
                final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
        final String name = action.getActionName();
            String actionName,
        ) {
    }  
                    } catch (InterruptedException | BrokenBarrierException e) {
            IndexShard primary,
        }
import static java.util.Collections.emptySet;
import org.opensearch.Version;  
import static org.hamcrest.Matchers.is;
    }
                    } else {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        }
        protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
                transportService,  
 * SPDX-License-Identifier: Apache-2.0
                clusterService,
import org.opensearch.cluster.block.ClusterBlockException;  
import java.util.Objects;
                transportService,
                }  
/*  
        return indicesService;
    @Override
    }
                clusterService,
            ShardId shardId,  
            null,
            this.globalBlock = globalBlock;
                        private TransportResponseHandler<TransportReplicationAction.ReplicaResponse> getResponseHandler() {  
                            if (globalBlock) {
import org.opensearch.common.settings.Settings;
            );
                        super.doRun();  
    /**
import org.junit.Before;
                assertThat(action, allOf(startsWith("cluster:admin/test/"), endsWith("[r]")));  
                shardStateAction,
    }
import org.opensearch.cluster.routing.RoutingTable;
import static org.hamcrest.Matchers.allOf;
                new SetOnce<>()  
            ShardId shardId,
            ShardRoutingState.INITIALIZING,  
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        assertThat(name + " operation should not have been executed on primary", action.executedOnPrimary.get(), nullValue());
 * ownership. Elasticsearch licenses this file to you under  
                        @Override  
        protected void shardOperationOnPrimary(
 * specific language governing permissions and limitations
            true
        }
            Request shardRequest,
        protected void shardOperationOnPrimary(  
    }
        private final boolean globalBlock;  
    }
        @Override
            delayedOperations,
        }
/**
            "cluster:admin/test/all_permits",
import java.util.concurrent.BrokenBarrierException;
            } else {
    @Override
        protected void acquireReplicaOperationPermit(  
            // The TransportReplicationAction.getIndexShard() method is overridden for testing purpose but we double check here  
        final String name = action.getActionName();
 * previously delayed single permit actions. This way, there is a clear transition between the single permit actions executed before the
            IndexShard replica,  
                        }
import org.opensearch.cluster.metadata.Metadata;
                            final ClusterState clusterState = clusterService.state();
                "Replica is always assigned to node 2 in this test",
    @Before
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
        @Override
            super.shardOperationOnPrimary(shardRequest, shard, listener);  
            Request shardRequest,
        RestStatus restStatus = randomFrom(RestStatus.values());  
        shardId = new ShardId("index", UUID.randomUUID().toString(), 0);
import org.junit.After;
import static org.hamcrest.Matchers.greaterThan;
                @Override  
                        @Override  
        }  
                mockIndicesService(shardId, executedOnPrimary, primary, replica),
 * the Apache License, Version 2.0 (the "License"); you may
            ThreadPool threadPool,  
                            logger.trace("op [{}] has started and will resume execution once allPermitsAction is terminated", threadId);  
import java.io.IOException;
        replica = newShard(primary.shardId(), false, node2.getId(), indexMetadata, null);
            Settings settings,  
            ShardStateAction shardStateAction,
        @Override  
        assertThat(name + " operation should not have been executed on replica", action.executedOnReplica.get(), nullValue());  
            this.shardId = Objects.requireNonNull(shardId);
            return globalBlock ? ClusterBlockLevel.WRITE : super.globalBlockLevel();
        assertThat(clusterBlockException.blocks(), hasItem(equalTo(block)));  
            final TransportReplicationAction.ConcreteShardRequest<Request> primaryRequest =
                assertFailedOperation(action, exception);
            .build();
                    action,  
            transportService,
        @Override
                        assertFalse("Index block must not exist yet", clusterState.blocks().hasIndexBlock(indexName, block));
            assertEquals(shardId, primary.shardId());  
import org.opensearch.index.IndexService;
            this.executedOnPrimary = executedOnPrimary;  
            // The TransportReplicationAction.getIndexShard() method is overridden for testing purpose but we double check here
 * this work for additional information regarding copyright
import java.util.concurrent.ExecutionException;
        transportService.acceptIncomingRequests();  
        state.routingTable(RoutingTable.builder().add(routing.build()).build());  
            TransportService transportService,  
                        }  
import org.opensearch.common.SetOnce;  
    private ShardId shardId;
            IndexShard shard,
            String actionName,
            if (i < delayedOperations) {
            shard.acquireAllPrimaryOperationsPermits(onAcquired, timeout);
    ) {  
                    new TransportResponseHandler<TransportReplicationAction.ReplicaResponse>() {
     */  
            futures[threadId] = listener;
            }  
                }
                clusterService,
            transportSettings,  
        final PlainActionFuture<Response> allPermitFuture = new PlainActionFuture<>();
                asyncPrimaryAction.run();
                            delayedOperationsBarrier.await();
                            return (TransportResponseHandler<TransportReplicationAction.ReplicaResponse>) getResponseHandlers()
            Request shardRequest,
    private IndexShard primary;
                Request::new,  
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        for (int i = 0; i < numOperations; i++) {  
                        }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;  
                clusterService.state().nodes().get("_node2").getId(),
import org.opensearch.index.shard.IndexShardTestCase;  
                        assertThat(reference.indexShard.getActiveOperationsCount(), greaterThan(0));
            assertEquals(shardId, replica.shardId());
    private class AllPermitsThenBlockAction extends TestAction {
                Settings.EMPTY,
import org.opensearch.transport.TransportService;  
        for (int i = 0; i < numOperations; i++) {
            asyncPrimaryAction.run();
                        if (delayed) {
            assertSame(primary, shard);  
        };
                        public void handleException(TransportException exp) {
            ShardStateAction shardStateAction,
import java.util.List;
                actionName,
                        }  
     * on {@link ClusterBlockLevel#WRITE}. The block can be a global level or an index level block depending of the  
                new TransportReplicationAction.ConcreteShardRequest<>(request(), allocationId(), primaryTerm());
            ClusterService clusterService,  
                                assertTrue("Index block must exist", clusterState.blocks().hasIndexBlock(indexName, block));  
            long globalCheckpoint,
        protected void shardOperationOnReplica(Request shardRequest, IndexShard replica, ActionListener<ReplicaResult> listener) {
import static org.hamcrest.Matchers.notNullValue;
            shardId,  
import org.opensearch.cluster.ClusterState;  
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                            return new TransportReplicationAction.ReplicaResponse(in);
    public void setUp() throws Exception {  
            actions[threadId] = singlePermitAction;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_INDEX_UUID;  
                    }
            TransportReplicationAction.AsyncPrimaryAction asyncPrimaryAction = allPermitsAction.new AsyncPrimaryAction(  
            }  
        }  
                    setState(clusterService, ClusterState.builder(clusterState).blocks(blocks));  
            super(
        SinglePermitWithBlocksAction(
                        }  
                    }
                        super.runWithPrimaryShardReference(reference);
        when(indicesService.indexServiceSafe(shardId.getIndex())).then(invocation -> indexService);
            super.shardOperationOnReplica(shardRequest, replica, listener);  
                threadPool,
    }
                        blocks.addGlobalBlock(block);
        logger.trace("now starting the operation that acquires all permits and sets the block in the cluster state");
        state.nodes(DiscoveryNodes.builder().add(node1).add(node2).localNodeId(node1.getId()).clusterManagerNodeId(node1.getId()));
import static org.hamcrest.Matchers.nullValue;  
            shard.acquireAllReplicaOperationsPermits(primaryTerm, globalCheckpoint, maxSeqNo, onAcquired, timeout);
            this.primary = Objects.requireNonNull(primary);
                actionName,
                        reference.indexShard.getActiveOperationsCount()
    private static IndicesService mockIndicesService(
                ThreadPool.Names.SAME
    private IndexShard replica;  
            boolean globalBlock  
                        }
            TransportService transportService,
                settings,  
import org.opensearch.cluster.action.shard.ShardStateAction;
        clusterService = createClusterService(threadPool);
            ActionListener<PrimaryResult<Request, Response>> listener
        for (Thread t : threads) {
                new SetOnce<>()
