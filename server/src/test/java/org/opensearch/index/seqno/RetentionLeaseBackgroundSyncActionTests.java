        // the result should indicate success
        final int id = randomIntBetween(0, 4);
        final CountDownLatch latch = new CountDownLatch(1);
        final IndexShard indexShard = mock(IndexShard.class);
        final Index index = new Index("index", "uuid");
        final RetentionLeases retentionLeases = mock(RetentionLeases.class);
            // the retention leases on the shard should be persisted
        final RetentionLeaseBackgroundSyncAction action = new RetentionLeaseBackgroundSyncAction(
 *
    }
        // the retention leases on the shard should be persisted
            new ActionFilters(Collections.emptySet())
            boundAddress -> clusterService.localNode(),
        when(indexService.getShard(id)).thenReturn(indexShard);
        super.tearDown();
        );
        final IndexShard indexShard = mock(IndexShard.class);
        );
    }
 * The OpenSearch Contributors require contributions made to
            clusterService,
        final IndexShard indexShard = mock(IndexShard.class);
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
        final IndexShard indexShard = mock(IndexShard.class);
 * not use this file except in compliance with the License.
        final int id = randomIntBetween(0, 4);
        final RetentionLeaseBackgroundSyncAction.Request request = new RetentionLeaseBackgroundSyncAction.Request(
            null,
    public void testGetReplicationModeWithLocalTranslog() {
        clusterService = createClusterService(threadPool);
import org.opensearch.core.index.Index;
 */
import org.opensearch.threadpool.ThreadPool;
            retentionLeases
import org.opensearch.action.support.replication.TransportReplicationAction;
import org.opensearch.threadpool.TestThreadPool;
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
 * GitHub history for details.
            threadPool,
 * Licensed to Elasticsearch under one or more contributor
        final RetentionLeases retentionLeases = mock(RetentionLeases.class);
import org.opensearch.action.support.ActionTestUtils;
        final IndexService indexService = mock(IndexService.class);
 * Unless required by applicable law or agreed to in writing,
        final ShardId shardId = new ShardId(index, id);
            clusterService,
    @Override
import org.opensearch.core.index.shard.ShardId;
        try {
            Settings.EMPTY,
        );
        final Index index = new Index("index", "uuid");
        final IndexService indexService = mock(IndexService.class);
            clusterService,
            indicesService,
import org.opensearch.action.support.replication.ReplicationMode;
        final RetentionLeaseBackgroundSyncAction action = createAction();
            threadPool,
        final AtomicBoolean success = new AtomicBoolean();
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
    private CapturingTransport transport;
        return new RetentionLeaseBackgroundSyncAction(
            IOUtils.close(transportService, clusterService, transport);
import org.opensearch.action.LatchedActionListener;
            verify(indexShard).persistRetentionLeases();
        final RetentionLeaseBackgroundSyncAction action = new RetentionLeaseBackgroundSyncAction(
        final IndexShard indexShard = mock(IndexShard.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }), latch));
        when(indexShard.shardId()).thenReturn(shardId);
 */
        final RetentionLeaseBackgroundSyncAction action = new RetentionLeaseBackgroundSyncAction(
            transportService,
        final IndicesService indicesService = mock(IndicesService.class);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
    public void testGetReplicationModeWithRemoteTranslog() {
            Settings.EMPTY,
import org.opensearch.cluster.action.shard.ShardStateAction;
 * license agreements. See the NOTICE file distributed with
        );
 * You may obtain a copy of the License at
            threadPool,
        final IndexService indexService = mock(IndexService.class);
    private ClusterService clusterService;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
import org.opensearch.core.action.ActionListener;
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            clusterService.getSettings(),
    private ThreadPool threadPool;
            // we should forward the request containing the current retention leases to the replica
    private ShardStateAction shardStateAction;
    public void testRetentionLeaseBackgroundSyncActionOnPrimary() throws InterruptedException {
    @Override
 */
        threadPool = new TestThreadPool(getClass().getName());
            transportService,
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testBlocks() {
 * the Apache License, Version 2.0 (the "License"); you may
        final int id = randomIntBetween(0, 4);
    }
    private TransportService transportService;
    public void testRetentionLeaseBackgroundSyncActionOnReplica() throws WriteStateException {
            shardStateAction,
        final ShardId shardId = new ShardId(index, id);
import java.util.concurrent.atomic.AtomicBoolean;
        when(indexService.getShard(id)).thenReturn(indexShard);
    private RetentionLeaseBackgroundSyncAction createAction() {
public class RetentionLeaseBackgroundSyncActionTests extends OpenSearchTestCase {
        final RetentionLeaseBackgroundSyncAction.Request request = new RetentionLeaseBackgroundSyncAction.Request(
            assertThat(result.replicaRequest(), sameInstance(request));
        final ShardId shardId = new ShardId(index, id);
import org.opensearch.indices.IndicesService;
    }
            retentionLeases
        );
            indexShard.shardId(),
        transportService = transport.createTransportService(
 *
            Settings.EMPTY,
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.index.shard.IndexShard;
        verify(indexShard).persistRetentionLeases();
            clusterService,
import java.util.Collections;
            Settings.EMPTY,
    }
        final IndicesService indicesService = mock(IndicesService.class);
        );
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
import static org.mockito.Mockito.verify;
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        when(indexService.getShard(id)).thenReturn(indexShard);
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
        final IndicesService indicesService = mock(IndicesService.class);
            transportService,
        transport = new CapturingTransport();
        latch.await();
 * SPDX-License-Identifier: Apache-2.0
            terminate(threadPool);
            mock(IndicesService.class),
            indexShard.shardId(),
            shardStateAction,
import org.opensearch.transport.TransportService;
        } finally {
        final Index index = new Index("index", "uuid");
        assertTrue(success.get());
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.index.seqno;
    }
        verify(indexShard).updateRetentionLeasesOnReplica(retentionLeases);
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
import org.opensearch.index.IndexService;
        final RetentionLeaseBackgroundSyncAction action = createAction();
            threadPool,
        when(indexShard.shardId()).thenReturn(shardId);
            indicesService,
            shardStateAction,
import org.opensearch.cluster.service.ClusterService;
            indicesService,
import static org.mockito.Mockito.when;
        action.shardOperationOnReplica(request, indexShard, listener);
import org.opensearch.test.transport.CapturingTransport;
}
            shardStateAction,
import org.opensearch.gateway.WriteStateException;
            threadPool,
        // the retention leases on the shard should be updated
import org.opensearch.action.support.PlainActionFuture;
        super.setUp();
 * software distributed under the License is distributed on an
import static org.mockito.Mockito.mock;
 * Modifications Copyright OpenSearch Contributors. See
    public void tearDown() throws Exception {
/*
    }
/*
        transportService.acceptIncomingRequests();
import org.opensearch.action.support.ActionFilters;
        action.shardOperationOnPrimary(request, indexShard, new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
/*
    }
 *
    public void setUp() throws Exception {
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
 * KIND, either express or implied.  See the License for the
        when(indexShard.shardId()).thenReturn(shardId);
import static org.hamcrest.Matchers.sameInstance;
            Collections.emptySet(),
        assertNull(action.indexBlockLevel());
        );
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
 * under the License.
            NoopTracer.INSTANCE
 * specific language governing permissions and limitations
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
        transportService.start();
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
            transportService,
import java.util.concurrent.CountDownLatch;
            new ActionFilters(Collections.emptySet())
            new ActionFilters(Collections.emptySet())
 * compatible open source license.
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            new ActionFilters(Collections.emptySet())
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        }
