 */
import static org.mockito.Mockito.anyString;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                final IndexShard indexShard = mock(IndexShard.class);
                transportService.start();
import org.opensearch.index.IndexingPressureService;
                        shardRoutingTable,
import org.opensearch.core.index.shard.ShardId;
                    new NoneCircuitBreakerService(),
                    NoopTracer.INSTANCE
import static org.mockito.Mockito.doAnswer;
import org.opensearch.cluster.routing.ShardRouting;
            mock(IndexingPressureService.class),
                final IndicesService indexServices = mock(IndicesService.class);
 * not use this file except in compliance with the License.
    private static ThreadPool threadPool;
 *
import org.opensearch.cluster.block.ClusterBlocks;
        }
                    threadPool,
import static org.opensearch.transport.TransportService.NOOP_TRANSPORT_INTERCEPTOR;
                when(indexShard.getOperationPrimaryTerm()).thenReturn(primaryTerm);
                        trackedAllocationIds,
import org.opensearch.cluster.action.shard.ShardStateAction;
                when(indexShard.getActiveOperationsCount()).then(i -> acquiredPermits.get());
import java.util.concurrent.atomic.AtomicInteger;
                    shardStateAction,
        try (ClusterService clusterService = createClusterService(threadPool)) {
import org.opensearch.test.OpenSearchTestCase;
import static java.util.Collections.emptyList;
import java.util.HashSet;
                final MockTransportService transportService = new MockTransportService(
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
import org.opensearch.action.support.replication.ReplicationMode;
                final byte[] bytes = "{}".getBytes(Charset.forName("UTF-8"));
import org.opensearch.index.IndexService;
                    new Translog.Operation[] { new Translog.Index("id", 0, primaryTerm, 0L, bytes, null, -1) }
                transportService.acceptIncomingRequests();
import org.opensearch.threadpool.TestThreadPool;
import static java.util.Collections.emptyMap;
            setState(
    public void testResyncDoesNotBlockOnPrimaryAction() throws Exception {
                when(indexShard.routingEntry()).thenReturn(primaryShardRouting);
                    new NamedWriteableRegistry(emptyList()),
import org.opensearch.cluster.routing.ShardRoutingState;
import org.opensearch.index.translog.Translog;
            new ActionFilters(new HashSet<>()),
import org.opensearch.action.support.PlainActionFuture;
import static org.opensearch.test.ClusterServiceUtils.setState;
            new SystemIndices(emptyMap()),
                );
 * license agreements. See the NOTICE file distributed with
                final long primaryTerm = indexMetadata.primaryTerm(shardId.id());
    public static void beforeClass() {
 * ownership. Elasticsearch licenses this file to you under
                final PlainActionFuture<ResyncReplicationResponse> listener = new PlainActionFuture<>();
                    new IndexingPressureService(Settings.EMPTY, clusterService),
                    clusterService,
                final String allocationId = primaryShardRouting.allocationId().getId();
 * software distributed under the License is distributed on an
                final TransportResyncReplicationAction action = new TransportResyncReplicationAction(
import org.opensearch.common.network.NetworkService;
                    .blocks(
 * compatible open source license.
import static org.mockito.Mockito.when;
                            .addIndexBlock(indexName, IndexMetadata.INDEX_WRITE_BLOCK)
                final ShardRouting primaryShardRouting = clusterService.state().routingTable().shardRoutingTable(shardId).primaryShard();
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.settings.Settings;
import org.opensearch.core.index.Index;
            Settings.EMPTY,
import org.opensearch.common.util.PageCacheRecycler;
import static org.mockito.Mockito.any;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                final ShardId shardId = new ShardId(index, 0);
    }
                    Settings.EMPTY,
                final ShardStateAction shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
    }
                    Settings.EMPTY,
                    new ActionFilters(new HashSet<>()),
                );
                when(indexServices.indexServiceSafe(eq(index))).thenReturn(indexService);
import org.opensearch.transport.TransportService;
 *
import org.opensearch.index.shard.IndexShard;
        final IndexShard indexShard = mock(IndexShard.class);
 * GitHub history for details.
                assertThat(listener.get().getShardInfo().getFailed(), equalTo(0));
 * You may obtain a copy of the License at
package org.opensearch.action.resync;
import java.util.concurrent.TimeUnit;
                    100,
import java.nio.charset.Charset;
                    indexServices,
    public void testGetReplicationModeWithLocalTranslog() {
import org.opensearch.cluster.metadata.IndexMetadata;
                final PendingReplicationActions replicationActions = new PendingReplicationActions(shardId, threadPool);
import org.opensearch.cluster.service.ClusterService;
            }
                when(task.getId()).thenReturn(randomNonNegativeLong());
import org.opensearch.cluster.ClusterState;
        );
}
                    PageCacheRecycler.NON_RECYCLING_INSTANCE,
                    NoopTracer.INSTANCE
import org.opensearch.test.transport.MockTransportService;
        final IndexShard indexShard = mock(IndexShard.class);
                when(indexShard.getPendingPrimaryTerm()).thenReturn(primaryTerm);
                final IndexShardRoutingTable shardRoutingTable = clusterService.state().routingTable().shardRoutingTable(shardId);
import org.opensearch.indices.SystemIndices;
import static org.mockito.Mockito.mock;
                    )
                final ResyncReplicationRequest request = new ResyncReplicationRequest(
                Set<String> trackedAllocationIds = shardRoutingTable.getAllAllocationIds();
            NoopTracer.INSTANCE
import org.opensearch.index.IndexSettings;
                    return null;
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
                    new SystemIndices(emptyMap()),
        ClusterService clusterService = mock(ClusterService.class);
 * The OpenSearch Contributors require contributions made to
                    NoopTracer.INSTANCE
                assertThat(action.globalBlockLevel(), nullValue());
                    Collections.emptySet(),
                action.sync(request, task, allocationId, primaryTerm, listener);
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.action.support.ActionFilters;
                doAnswer(invocation -> {
                    callback.onResponse(acquiredPermits::decrementAndGet);
import static org.mockito.Mockito.eq;
                when(indexShard.indexSettings()).thenReturn(new IndexSettings(indexMetadata, Settings.EMPTY));
                        ClusterBlocks.builder()
                MockNioTransport transport = new MockNioTransport(
            mock(TransportService.class),
                assertThat(action.indexBlockLevel(), nullValue());
                );
 */
    }
                final IndexService indexService = mock(IndexService.class);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.transport.nio.MockNioTransport;
                        clusterService.state().metadata().index(index).inSyncAllocationIds(shardId.id()),
 */
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
    }
                        0
import org.junit.AfterClass;
 * the Apache License, Version 2.0 (the "License"); you may
                ClusterState.builder(clusterService.state())
                    null,
                    transport,
                when(indexShard.getReplicationGroup()).thenReturn(
import org.opensearch.indices.IndicesService;
import org.opensearch.cluster.coordination.NoClusterManagerBlockService;
                when(indexShard.shardId()).thenReturn(shardId);
import org.junit.BeforeClass;
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
                )
 * this file be licensed under the Apache-2.0 license or a
            final String indexName = randomAlphaOfLength(5);
/*
import static org.hamcrest.Matchers.nullValue;
 * SPDX-License-Identifier: Apache-2.0
            try (
 *    http://www.apache.org/licenses/LICENSE-2.0
        threadPool = null;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
                when(indexService.getShard(eq(shardId.id()))).thenReturn(indexShard);
                    threadPool,
                    threadPool,
                    x -> clusterService.localNode(),
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
 *
                assertThat(listener.isDone(), is(true));
import java.util.Set;
                when(indexShard.getPendingReplicationActions()).thenReturn(replicationActions);
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
                }).when(indexShard).acquirePrimaryOperationPermit(any(ActionListener.class), anyString(), any(), eq(true));
/*
import java.util.Collections;
                    42L,
                    NOOP_TRANSPORT_INTERCEPTOR,
                    Settings.EMPTY,
                    transportService,
    }
import org.opensearch.action.support.replication.PendingReplicationActions;
public class TransportResyncReplicationActionTests extends OpenSearchTestCase {
                            .addGlobalBlock(NoClusterManagerBlockService.NO_CLUSTER_MANAGER_BLOCK_ALL)
            mock(IndicesService.class),
 * KIND, either express or implied.  See the License for the
                    acquiredPermits.incrementAndGet();
    @AfterClass
                final AtomicInteger acquiredPermits = new AtomicInteger();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    ActionListener<Releasable> callback = (ActionListener<Releasable>) invocation.getArguments()[0];
                    new NetworkService(emptyList()),
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
                final IndexMetadata indexMetadata = clusterService.state().metadata().index(indexName);
                final Index index = indexMetadata.getIndex();
            ) {
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        final TransportResyncReplicationAction action = createAction();
                clusterService,
    private TransportResyncReplicationAction createAction() {
 * specific language governing permissions and limitations
        final TransportResyncReplicationAction action = createAction();
            mock(ShardStateAction.class),
                    Version.CURRENT,
        threadPool = new TestThreadPool("ShardReplicationTests");
 * this work for additional information regarding copyright
import org.opensearch.common.lease.Releasable;
/*
                    shardId,
    }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    @BeforeClass
                final Task task = mock(Task.class);
                    )
            threadPool,
 * under the License.
 * Unless required by applicable law or agreed to in writing,
                    new ReplicationGroup(
                );
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.is;
import static org.opensearch.action.support.replication.ClusterStateCreationUtils.state;
            clusterService,
import org.opensearch.Version;
            );
import org.opensearch.index.shard.ReplicationGroup;
    public static void afterClass() {
import org.opensearch.core.action.ActionListener;
            setState(clusterService, state(indexName, true, ShardRoutingState.STARTED));
        return new TransportResyncReplicationAction(
import org.opensearch.tasks.Task;
import static org.hamcrest.Matchers.equalTo;
 * Licensed to Elasticsearch under one or more contributor
    public void testGetReplicationModeWithRemoteTranslog() {
