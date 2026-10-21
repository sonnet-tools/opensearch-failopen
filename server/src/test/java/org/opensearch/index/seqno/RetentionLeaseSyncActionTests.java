        action.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
 */
import org.opensearch.index.shard.IndexShard;
            // the retention leases on the shard should be persisted
 * license agreements. See the NOTICE file distributed with
        final int id = randomIntBetween(0, 4);
import org.opensearch.cluster.service.ClusterService;
            shardStateAction,
import org.opensearch.action.support.ActionTestUtils;
            new ActionFilters(Collections.emptySet()),
import org.opensearch.common.settings.Settings;
            // we should forward the request containing the current retention leases to the replica
 * not use this file except in compliance with the License.
            mock(IndicesService.class),
        );
            transportService,
        final IndicesService indicesService = mock(IndicesService.class);
            shardStateAction,
            threadPool,
    private ClusterService clusterService;
/*
            boundAddress -> clusterService.localNode(),
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
import org.opensearch.common.util.io.IOUtils;
        final IndexShard indexShard = mock(IndexShard.class);
            threadPool,
public class RetentionLeaseSyncActionTests extends OpenSearchTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
        final IndexService indexService = mock(IndexService.class);
            Collections.emptySet(),
import static org.hamcrest.Matchers.sameInstance;
            new SystemIndices(emptyMap()),
        clusterService = createClusterService(threadPool);
        verify(indexShard).updateRetentionLeasesOnReplica(retentionLeases);
        when(indexShard.shardId()).thenReturn(shardId);
            NoopTracer.INSTANCE
 * Unless required by applicable law or agreed to in writing,
        }
        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.threadpool.ThreadPool;
            threadPool,
 */
    private CapturingTransport transport;
 * software distributed under the License is distributed on an
        final RetentionLeases retentionLeases = mock(RetentionLeases.class);
import org.opensearch.test.transport.CapturingTransport;
    public void testRetentionLeaseSyncActionOnPrimary() {
        when(indexShard.shardId()).thenReturn(shardId);
        // the result should indicate success
    }
import org.opensearch.core.index.Index;
        final IndicesService indicesService = mock(IndicesService.class);
            new SystemIndices(emptyMap()),
 * You may obtain a copy of the License at
        final AtomicBoolean success = new AtomicBoolean();
            NoopTracer.INSTANCE
            assertThat(result.replicaRequest(), sameInstance(request));
        final Index index = new Index("index", "uuid");
        final IndexShard indexShard = mock(IndexShard.class);
        assertTrue(success.get());
        final Index index = new Index("index", "uuid");
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
        final RetentionLeaseSyncAction action = new RetentionLeaseSyncAction(
import org.opensearch.action.support.replication.TransportReplicationAction;
import org.opensearch.test.OpenSearchTestCase;
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
            Settings.EMPTY,
            indicesService,
        final IndicesService indicesService = mock(IndicesService.class);
    public void tearDown() throws Exception {
        transportService.start();
    public void testBlocks() {
            transportService,
        action.dispatchedShardOperationOnReplica(request, indexShard, listener);
 * specific language governing permissions and limitations
        final IndexShard indexShard = mock(IndexShard.class);
            IOUtils.close(transportService, clusterService, transport);
            NoopTracer.INSTANCE
import org.opensearch.threadpool.TestThreadPool;
        final RetentionLeaseSyncAction action = new RetentionLeaseSyncAction(
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
    public void testGetReplicationModeWithLocalTranslog() {
            Settings.EMPTY,
 * ownership. Elasticsearch licenses this file to you under
            verify(indexShard).persistRetentionLeases();
            new IndexingPressureService(Settings.EMPTY, clusterService),
            threadPool,
        );
            new SystemIndices(emptyMap()),
    }
            transportService,
            new ActionFilters(Collections.emptySet()),
        when(indexService.getShard(id)).thenReturn(indexShard);
package org.opensearch.index.seqno;
    }
            clusterService.getSettings(),
        );
    public void testGetReplicationModeWithRemoteTranslog() {
        super.tearDown();
            new ActionFilters(Collections.emptySet()),
import org.opensearch.index.IndexService;
        when(indexService.getShard(id)).thenReturn(indexShard);
        transport = new CapturingTransport();
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
/*
        );
 * SPDX-License-Identifier: Apache-2.0
 */
        final RetentionLeaseSyncAction action = createAction();
    public void setUp() throws Exception {
    public void testRetentionLeaseSyncActionOnReplica() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final IndexService indexService = mock(IndexService.class);
            clusterService,
import org.opensearch.index.IndexingPressureService;
            indicesService,
        final Index index = new Index("index", "uuid");
            threadPool,
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        final ShardId shardId = new ShardId(index, id);
    }
        final RetentionLeaseSyncAction action = new RetentionLeaseSyncAction(
        final ShardId shardId = new ShardId(index, id);
        threadPool = new TestThreadPool(getClass().getName());
import org.opensearch.transport.TransportService;
            terminate(threadPool);
 * under the License.
 *
        } finally {
        when(indexService.getShard(id)).thenReturn(indexShard);
            shardStateAction,
    }
 *
        verify(indexShard).persistRetentionLeases();
    private ShardStateAction shardStateAction;
    }
import org.opensearch.indices.SystemIndices;
    }
import org.opensearch.telemetry.tracing.noop.NoopTracer;
import static org.mockito.Mockito.when;
/*
        super.setUp();
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        final RetentionLeases retentionLeases = mock(RetentionLeases.class);
            clusterService,
 * Modifications Copyright OpenSearch Contributors. See
import static java.util.Collections.emptyMap;
        final RetentionLeaseSyncAction action = createAction();
 * Licensed to Elasticsearch under one or more contributor
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            clusterService,
            new ActionFilters(Collections.emptySet()),
    private TransportService transportService;
        final IndexService indexService = mock(IndexService.class);
import static org.mockito.Mockito.mock;
    private ThreadPool threadPool;
 *
        // the retention leases on the shard should be updated
import org.opensearch.action.support.ActionFilters;
        final ShardId shardId = new ShardId(index, id);
        final int id = randomIntBetween(0, 4);
            // we should start with an empty replication response
        // the retention leases on the shard should be persisted
            new SystemIndices(emptyMap()),
        when(indexShard.shardId()).thenReturn(shardId);
        final RetentionLeaseSyncAction.Request request = new RetentionLeaseSyncAction.Request(indexShard.shardId(), retentionLeases);
import org.opensearch.core.index.shard.ShardId;
        PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
        try {
            null,
            new IndexingPressureService(Settings.EMPTY, clusterService),
        final IndexShard indexShard = mock(IndexShard.class);
    private RetentionLeaseSyncAction createAction() {
            transportService,
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        transportService.acceptIncomingRequests();
import org.opensearch.indices.IndicesService;
 * GitHub history for details.
        }));
            NoopTracer.INSTANCE
 * compatible open source license.
            NoopTracer.INSTANCE
    }
        );
            clusterService,
            assertNull(result.finalResponseIfSuccessful.getShardInfo());
 * this work for additional information regarding copyright
            new IndexingPressureService(Settings.EMPTY, clusterService),
            indicesService,
        final RetentionLeaseSyncAction.Request request = new RetentionLeaseSyncAction.Request(indexShard.shardId(), retentionLeases);
import java.util.concurrent.atomic.AtomicBoolean;
        assertNull(action.indexBlockLevel());
        final int id = randomIntBetween(0, 4);
import static org.mockito.Mockito.verify;
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
 * KIND, either express or implied.  See the License for the
}
import org.opensearch.core.action.ActionListener;
import org.opensearch.action.support.replication.ReplicationMode;
        transportService = transport.createTransportService(
            Settings.EMPTY,
 *     http://www.apache.org/licenses/LICENSE-2.0
        return new RetentionLeaseSyncAction(
            shardStateAction,
import org.opensearch.action.support.PlainActionFuture;
            new IndexingPressureService(Settings.EMPTY, clusterService),
            Settings.EMPTY,
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
import java.util.Collections;
