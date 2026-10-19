    }
            terminate(threadPool);  
        );
import org.opensearch.common.settings.Settings;  
        return new RetentionLeaseBackgroundSyncAction(
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
        assertNull(action.indexBlockLevel());
        final IndexShard indexShard = mock(IndexShard.class);
 * Modifications Copyright OpenSearch Contributors. See
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
        final int id = randomIntBetween(0, 4);  
 *
        final IndexShard indexShard = mock(IndexShard.class);
    }  
    private TransportService transportService;
            indicesService,
        action.shardOperationOnReplica(request, indexShard, listener);
        // the result should indicate success
    public void testBlocks() {
    public void tearDown() throws Exception {
            Settings.EMPTY,  
            Settings.EMPTY,
            shardStateAction,
import org.opensearch.core.index.Index;  
            threadPool,  
        final ShardId shardId = new ShardId(index, id);
            indicesService,
import org.opensearch.transport.TransportService;
 * this work for additional information regarding copyright
        assertTrue(success.get());
import static org.hamcrest.Matchers.sameInstance;
            transportService,  
        final RetentionLeases retentionLeases = mock(RetentionLeases.class);
            indexShard.shardId(),  
        transportService.start();
            clusterService,
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
 */
            new ActionFilters(Collections.emptySet())  
import org.opensearch.threadpool.TestThreadPool;  
        );  
import org.opensearch.index.shard.IndexShard;
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
 * KIND, either express or implied.  See the License for the
/*  
            shardStateAction,
        super.tearDown();
        when(indexShard.shardId()).thenReturn(shardId);
    private CapturingTransport transport;  
        final RetentionLeaseBackgroundSyncAction action = createAction();
            threadPool,
            // we should forward the request containing the current retention leases to the replica
            mock(IndicesService.class),  
 * the Apache License, Version 2.0 (the "License"); you may
import static org.mockito.Mockito.mock;
        final int id = randomIntBetween(0, 4);  
            retentionLeases
        final RetentionLeaseBackgroundSyncAction.Request request = new RetentionLeaseBackgroundSyncAction.Request(
    }
        threadPool = new TestThreadPool(getClass().getName());
        action.shardOperationOnPrimary(request, indexShard, new LatchedActionListener<>(ActionTestUtils.assertNoFailureListener(result -> {
 * Unless required by applicable law or agreed to in writing,
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            retentionLeases
 *     http://www.apache.org/licenses/LICENSE-2.0
            Settings.EMPTY,
            transportService,  
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        verify(indexShard).persistRetentionLeases();
 * not use this file except in compliance with the License.
        );
    private ShardStateAction shardStateAction;  
        when(indexService.getShard(id)).thenReturn(indexShard);
    private RetentionLeaseBackgroundSyncAction createAction() {
    }  
import java.util.Collections;
            verify(indexShard).persistRetentionLeases();
        );  
        final ShardId shardId = new ShardId(index, id);
        final int id = randomIntBetween(0, 4);  
/*  
import org.opensearch.action.support.PlainActionFuture;
        final CountDownLatch latch = new CountDownLatch(1);
 *  
import java.util.concurrent.atomic.AtomicBoolean;  
        transport = new CapturingTransport();  
            new ActionFilters(Collections.emptySet())
 * under the License.  
            indicesService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testRetentionLeaseBackgroundSyncActionOnReplica() throws WriteStateException {
 * SPDX-License-Identifier: Apache-2.0
        final IndicesService indicesService = mock(IndicesService.class);  
        when(indexShard.shardId()).thenReturn(shardId);
        final RetentionLeaseBackgroundSyncAction action = new RetentionLeaseBackgroundSyncAction(
import java.util.concurrent.CountDownLatch;
package org.opensearch.index.seqno;
            Settings.EMPTY,
        try {  
        final RetentionLeaseBackgroundSyncAction action = new RetentionLeaseBackgroundSyncAction(
        final RetentionLeases retentionLeases = mock(RetentionLeases.class);
        clusterService = createClusterService(threadPool);
            shardStateAction,
        );
            threadPool,  
 */  
        when(indexService.getShard(id)).thenReturn(indexShard);
    public void testGetReplicationModeWithLocalTranslog() {  
            clusterService,
            indexShard.shardId(),  
        final IndexShard indexShard = mock(IndexShard.class);
    }
            new ActionFilters(Collections.emptySet())
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
import org.opensearch.action.support.replication.TransportReplicationAction;  
        final IndicesService indicesService = mock(IndicesService.class);  
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        final IndexService indexService = mock(IndexService.class);  
            Collections.emptySet(),
import org.opensearch.test.transport.CapturingTransport;
 */  
}
        transportService.acceptIncomingRequests();  
        final Index index = new Index("index", "uuid");
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        verify(indexShard).updateRetentionLeasesOnReplica(retentionLeases);
import org.opensearch.threadpool.ThreadPool;
            boundAddress -> clusterService.localNode(),  
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
        final ShardId shardId = new ShardId(index, id);
        final AtomicBoolean success = new AtomicBoolean();  
    }
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
            transportService,
        // the retention leases on the shard should be persisted  
import org.opensearch.action.support.ActionTestUtils;  
import org.opensearch.common.util.io.IOUtils;
            clusterService,
            IOUtils.close(transportService, clusterService, transport);
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
    public void testRetentionLeaseBackgroundSyncActionOnPrimary() throws InterruptedException {
            shardStateAction,
        latch.await();
import org.opensearch.core.action.ActionListener;
        final IndexService indexService = mock(IndexService.class);  
import static org.mockito.Mockito.when;
        final IndexService indexService = mock(IndexService.class);  
import org.opensearch.core.index.shard.ShardId;
            new ActionFilters(Collections.emptySet())
import org.opensearch.test.OpenSearchTestCase;
        final Index index = new Index("index", "uuid");
 * license agreements. See the NOTICE file distributed with
    }  
        );  
import org.opensearch.gateway.WriteStateException;
 *
        // the retention leases on the shard should be updated
public class RetentionLeaseBackgroundSyncActionTests extends OpenSearchTestCase {  
        final RetentionLeaseBackgroundSyncAction.Request request = new RetentionLeaseBackgroundSyncAction.Request(
        final Index index = new Index("index", "uuid");
        final RetentionLeaseBackgroundSyncAction action = createAction();  
 * software distributed under the License is distributed on an
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.service.ClusterService;
        transportService = transport.createTransportService(
        final IndexShard indexShard = mock(IndexShard.class);
            threadPool,
 * GitHub history for details.
 * specific language governing permissions and limitations
            assertThat(result.replicaRequest(), sameInstance(request));  
    public void setUp() throws Exception {  
            transportService,  
        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.indices.IndicesService;
import org.opensearch.action.LatchedActionListener;
    public void testGetReplicationModeWithRemoteTranslog() {
            null,
            // the retention leases on the shard should be persisted  
        when(indexShard.shardId()).thenReturn(shardId);
        final RetentionLeaseBackgroundSyncAction action = new RetentionLeaseBackgroundSyncAction(
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        }), latch));
 * Licensed to Elasticsearch under one or more contributor  
        } finally {
    @Override
            NoopTracer.INSTANCE  
import static org.mockito.Mockito.verify;  
    private ThreadPool threadPool;
        when(indexService.getShard(id)).thenReturn(indexShard);
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        final IndicesService indicesService = mock(IndicesService.class);  
import org.opensearch.index.IndexService;  
            threadPool,  
    }  
        }
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));  
        super.setUp();
 * The OpenSearch Contributors require contributions made to  
            clusterService.getSettings(),  
        );
/*
 * compatible open source license.
            clusterService,
    @Override
import org.opensearch.cluster.action.shard.ShardStateAction;
    private ClusterService clusterService;
import org.opensearch.action.support.replication.ReplicationMode;
