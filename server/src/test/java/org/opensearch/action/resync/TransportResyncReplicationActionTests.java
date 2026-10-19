import static org.mockito.Mockito.doAnswer;
                assertThat(action.indexBlockLevel(), nullValue());
                when(task.getId()).thenReturn(randomNonNegativeLong());
        final IndexShard indexShard = mock(IndexShard.class);
import static org.mockito.Mockito.mock;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    new Translog.Operation[] { new Translog.Index("id", 0, primaryTerm, 0L, bytes, null, -1) }
                    100,
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
                }).when(indexShard).acquirePrimaryOperationPermit(any(ActionListener.class), anyString(), any(), eq(true));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
                doAnswer(invocation -> {
import org.opensearch.indices.IndicesService;  
    private static ThreadPool threadPool;  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.atomic.AtomicInteger;  
import java.util.HashSet;  
import static org.mockito.Mockito.anyString;
                    NOOP_TRANSPORT_INTERCEPTOR,  
public class TransportResyncReplicationActionTests extends OpenSearchTestCase {
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.threadpool.TestThreadPool;  
                    shardId,
                    new ReplicationGroup(  
                        trackedAllocationIds,  
                    )
                transportService.acceptIncomingRequests();
        final TransportResyncReplicationAction action = createAction();
    }
import org.opensearch.cluster.service.ClusterService;
            }
import org.junit.BeforeClass;
                    PageCacheRecycler.NON_RECYCLING_INSTANCE,
 * specific language governing permissions and limitations
import org.opensearch.index.translog.Translog;
import org.opensearch.test.transport.MockTransportService;
                when(indexService.getShard(eq(shardId.id()))).thenReturn(indexShard);  
                when(indexShard.getPendingReplicationActions()).thenReturn(replicationActions);  
import static org.mockito.Mockito.any;  
                clusterService,
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);  
                    new IndexingPressureService(Settings.EMPTY, clusterService),
                    new NoneCircuitBreakerService(),  
                final Task task = mock(Task.class);  
                when(indexShard.getOperationPrimaryTerm()).thenReturn(primaryTerm);
    @AfterClass
                            .addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)  
import static org.mockito.Mockito.when;
 * You may obtain a copy of the License at  
                    new NetworkService(emptyList()),  
                );
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
                            .addGlobalBlock(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL)
 * Modifications Copyright OpenSearch Contributors. See  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
                assertThat(action.globalBlockLevel(), nullValue());  
import org.opensearch.Version;  
                    Settings.EMPTY,  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
                    transport,
            mock(IndicesService.class),  
                );
                    .blocks(  
/*
                    return null;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.lease.Releasable;
 *  
 * under the License.  
import org.opensearch.cluster.metadata.IndexMetadata;  
    public static void afterClass() {
 * this file be licensed under the Apache-2.0 license or a
                    Collections.emptySet(),  
            Settings.EMPTY,  
                transportService.start();  
                    new NamedWriteableRegistry(emptyList()),
            final String indexName = randomAlphaOfLength(5);  
                final PlainActionFuture<ResyncReplicationResponse> listener = new PlainActionFuture<>();
                Set<String> trackedAllocationIds = shardRoutingTable.getAllAllocationIds();
            new ActionFilters(new HashSet<>()),  
                    transportService,
            setState(clusterService, state(indexName, true, ShardRoutingState.STARTED));
                final IndexMetadata indexMetadata = clusterService.state().metadata().index(indexName);
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
                when(indexShard.routingEntry()).thenReturn(primaryShardRouting);
                final IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().shardRoutingTable(shardId);
import org.opensearch.test.OpenSearchTestCase;
                when(indexShard.shardId()).thenReturn(shardId);
                final ShardId shardId = new ShardId(index, 0);  
import org.opensearch.action.support.ActionFilters;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                assertThat(listener.isDone(), is(true));  
                when(indexShard.indexSettings()).thenReturn(new IndexSettings(indexMetadata, Settings.EMPTY));  
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.cluster.action.shard.ShardStateAction;  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
import static org.opensearch.test.ClusterServiceUtils.setState;
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
import org.opensearch.index.IndexingPressureService;
                        clusterService.state().metadata().index(index).inSyncAllocationIds(shardId.id()),
                final PendingReplicationActions replicationActions = new PendingReplicationActions(shardId, threadPool);
                    Settings.EMPTY,  
                    NoopTracer.INSTANCE
import org.opensearch.core.action.ActionListener;
import org.opensearch.transport.TransportService;
                    )
import org.opensearch.tasks.Task;
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.action.support.replication.PendingReplicationActions;  
            clusterService,
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));  
            );
    }
            mock(TransportService.class),
import org.opensearch.cluster.block.ClusterBlocks;
        }
                final ShardStateAction shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
                final TransportResyncReplicationAction action = new TransportResyncReplicationAction(
                    indexServices,  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
import org.opensearch.index.IndexService;  
                when(indexServices.indexServiceSafe(eq(index))).thenReturn(indexService);  
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            NoopTracer.INSTANCE  
import org.opensearch.core.index.Index;  
                    callback.onResponse(acquiredPermits::decrementAndGet);
        final TransportResyncReplicationAction action = createAction();  
    }
            mock(IndexingPressureService.class),
        ClusterService clusterService = mock(ClusterService.class);
        threadPool = null;
                    42L,  
                final MockTransportService transportService = new MockTransportService(
                action.sync(request, task, allocationId, primaryTerm, listener);  
                final ShardRouting primaryShardRouting = clusterService.state().routingTable().shardRoutingTable(shardId).primaryShard();
import java.util.Collections;
import org.opensearch.common.util.PageCacheRecycler;  
                MockNioTransport transport = new MockNioTransport(
                final AtomicInteger acquiredPermits = new AtomicInteger();  
                    NoopTracer.INSTANCE  
                final IndexShard indexShard = mock(IndexShard.class);
    }
 */  
                        shardRoutingTable,
                );  
        );
import org.opensearch.index.IndexSettings;
                    threadPool,
 * compatible open source license.
            mock(ShardStateAction.class),
 * SPDX-License-Identifier: Apache-2.0
                        ClusterBlocks.builder()
                when(indexShard.getPendingPrimaryTerm()).thenReturn(primaryTerm);  
                    acquiredPermits.incrementAndGet();  
import org.opensearch.action.support.PlainActionFuture;
    public void testGetReplicationModeWithLocalTranslog() {  
                assertThat(listener.get().getShardInfo().getFailed(), equalTo(0));
            threadPool,
package org.opensearch.action.resync;
                    threadPool,
import org.opensearch.threadpool.ThreadPool;
import static org.mockito.Mockito.eq;  
}  
import org.junit.AfterClass;
                final IndicesService indexServices = mock(IndicesService.class);
                    Settings.EMPTY,  
                final ResyncReplicationRequest request = new ResyncReplicationRequest(
    public void testResyncDoesNotBlockOnPrimaryAction() throws Exception {
 * KIND, either express or implied.  See the License for the
            setState(  
import org.opensearch.transport.nio.MockNioTransport;  
                    new ActionFilters(new HashSet<>()),  
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
    public static void beforeClass() {  
import org.opensearch.cluster.ClusterState;
        return new TransportResyncReplicationAction(
                when(indexShard.getReplicationGroup()).thenReturn(
 * GitHub history for details.
                    clusterService,
                    threadPool,
import org.opensearch.index.shard.IndexShard;  
import static org.hamcrest.Matchers.is;
        try (ClusterService clusterService = createClusterService(threadPool)) {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.settings.Settings;
import org.opensearch.common.settings.ClusterSettings;
import java.nio.charset.Charset;
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
                    shardStateAction,
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
import org.opensearch.index.shard.ReplicationGroup;
                    NoopTracer.INSTANCE
import org.opensearch.cluster.routing.ShardRoutingState;  
 */
import static java.util.Collections.emptyList;
                );  
        threadPool = new TestThreadPool("ShardReplicationTests");
                final long primaryTerm = indexMetadata.primaryTerm(shardId.id());
                    new SystemIndices(emptyMap()),
/*
            try (
                final Index index = indexMetadata.getIndex();
import static java.util.Collections.emptyMap;  
import org.opensearch.indices.SystemIndices;
import java.util.Set;
                when(indexShard.getActiveOperationsCount()).then(i -> acquiredPermits.get());
                final IndexService indexService = mock(IndexService.class);
    @BeforeClass
            new SystemIndices(emptyMap()),
import org.opensearch.common.network.NetworkService;  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * Unless required by applicable law or agreed to in writing,
    }  
    public void testGetReplicationModeWithRemoteTranslog() {
 * not use this file except in compliance with the License.
                    null,
        final IndexShard indexShard = mock(IndexShard.class);
import java.util.concurrent.TimeUnit;
 *
 */
    private TransportResyncReplicationAction createAction() {
                ClusterState.builder(clusterService.state())
            ) {  
                        0
                )
                final String allocationId = primaryShardRouting.allocationId().getId();  
                    x -> clusterService.localNode(),
                    ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[0];
                    Version.CURRENT,
 * this work for additional information regarding copyright
                final byte[] bytes = "{}".getBytes(Charset.forName("UTF-8"));  
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.replication.ReplicationMode;
