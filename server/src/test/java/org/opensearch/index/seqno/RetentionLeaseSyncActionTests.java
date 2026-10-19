        super.setUp();  
import org.opensearch.action.support.replication.TransportReplicationAction;
import org.opensearch.index.shard.IndexShard;  
    private RetentionLeaseSyncAction createAction() {
            NoopTracer.INSTANCE
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
        clusterService = createClusterService(threadPool);  
 * specific language governing permissions and limitations
            new IndexingPressureService(Settings.EMPTY, clusterService),
 * compatible open source license.
/*  
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
 * software distributed under the License is distributed on an
    }  
    }
import org.opensearch.test.OpenSearchTestCase;
            shardStateAction,
import org.opensearch.action.support.ActionTestUtils;
        final Index index = new Index("index", "uuid");
            new IndexingPressureService(Settings.EMPTY, clusterService),  
            threadPool,  
        when(indexService.getShard(id)).thenReturn(indexShard);
import static org.hamcrest.Matchers.sameInstance;
import org.opensearch.transport.TransportService;
        transportService = transport.createTransportService(
            new ActionFilters(Collections.emptySet()),
import org.opensearch.action.support.ActionFilters;
        }
    public void testGetReplicationModeWithLocalTranslog() {  
            new IndexingPressureService(Settings.EMPTY, clusterService),
 * license agreements. See the NOTICE file distributed with
    private TransportService transportService;
            transportService,
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();  
        } finally {  
        final IndexShard indexShard = mock(IndexShard.class);
            NoopTracer.INSTANCE  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.index.seqno;
            assertNull(result.finalResponseIfSuccessful.getShardInfo());
    }  
            shardStateAction,
/*  
import org.opensearch.action.support.replication.ReplicationMode;
            new ActionFilters(Collections.emptySet()),
            clusterService.getSettings(),
        final IndexService indexService = mock(IndexService.class);  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.action.ActionListener;
        final IndexShard indexShard = mock(IndexShard.class);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
import org.opensearch.index.IndexService;
 */
    public void tearDown() throws Exception {  
        // the result should indicate success
            mock(IndicesService.class),  
        final IndexShard indexShard = mock(IndexShard.class);
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
            transportService,  
            threadPool,
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
    private ShardStateAction shardStateAction;  
            NoopTracer.INSTANCE
            Settings.EMPTY,
        final int id = randomIntBetween(0, 4);  
        final RetentionLeaseSyncAction action = new RetentionLeaseSyncAction(
        final RetentionLeases retentionLeases = mock(RetentionLeases.class);
    public void testRetentionLeaseSyncActionOnPrimary() {  
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
            new ActionFilters(Collections.emptySet()),  
        when(indexShard.shardId()).thenReturn(shardId);
            shardStateAction,
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
        // the retention leases on the shard should be updated
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.settings.Settings;
 * The OpenSearch Contributors require contributions made to  
        final IndexShard indexShard = mock(IndexShard.class);
    private ClusterService clusterService;
import static org.mockito.Mockito.verify;  
        final ShardId shardId = new ShardId(index, id);
            threadPool,
            Collections.emptySet(),
        // the retention leases on the shard should be persisted  
    }
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
            shardStateAction,
            new SystemIndices(emptyMap()),
        transportService.acceptIncomingRequests();
            new SystemIndices(emptyMap()),
import static org.mockito.Mockito.mock;
            // we should forward the request containing the current retention leases to the replica
 * GitHub history for details.
import org.opensearch.cluster.action.shard.ShardStateAction;  
        action.dispatchedShardOperationOnReplica(request, indexShard, listener);
            new SystemIndices(emptyMap()),
        );  
        assertNull(action.indexBlockLevel());
        final Index index = new Index("index", "uuid");  
            clusterService,
        final IndexService indexService = mock(IndexService.class);
        when(indexShard.shardId()).thenReturn(shardId);
        action.dispatchedShardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.index.Index;
import org.opensearch.threadpool.TestThreadPool;  
        );
import org.opensearch.core.index.shard.ShardId;  
        final IndicesService indicesService = mock(IndicesService.class);  
        final RetentionLeaseSyncAction.Request request = new RetentionLeaseSyncAction.Request(indexShard.shardId(), retentionLeases);
import org.opensearch.indices.SystemIndices;
            threadPool,  
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        return new RetentionLeaseSyncAction(
 *
            // the retention leases on the shard should be persisted
        );
        final IndexShard indexShard = mock(IndexShard.class);
    }
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
            NoopTracer.INSTANCE  
        );  
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));  
/*
import static org.mockito.Mockito.when;
 * KIND, either express or implied.  See the License for the
}
    private CapturingTransport transport;  
            verify(indexShard).persistRetentionLeases();  
        verify(indexShard).persistRetentionLeases();
        threadPool = new TestThreadPool(getClass().getName());
        super.tearDown();  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
    }  
import org.opensearch.threadpool.ThreadPool;
            indicesService,
    private ThreadPool threadPool;
        final AtomicBoolean success = new AtomicBoolean();  
        assertTrue(success.get());
            Settings.EMPTY,  
import static java.util.Collections.emptyMap;
        }));
        final int id = randomIntBetween(0, 4);
    public void testBlocks() {
        );  
        final int id = randomIntBetween(0, 4);  
import org.opensearch.cluster.service.ClusterService;
            threadPool,  
            clusterService,
        final IndicesService indicesService = mock(IndicesService.class);
            new IndexingPressureService(Settings.EMPTY, clusterService),  
 */  
import org.opensearch.index.IndexingPressureService;
            transportService,
        final RetentionLeaseSyncAction action = new RetentionLeaseSyncAction(
            indicesService,  
            boundAddress -> clusterService.localNode(),
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
            assertThat(result.replicaRequest(), sameInstance(request));
            clusterService,
import org.opensearch.action.support.PlainActionFuture;  
 * under the License.  
        final ShardId shardId = new ShardId(index, id);
            IOUtils.close(transportService, clusterService, transport);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.io.IOUtils;  
    }
            Settings.EMPTY,
    public void setUp() throws Exception {
 *  
 * not use this file except in compliance with the License.
        final RetentionLeaseSyncAction action = createAction();  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        final RetentionLeaseSyncAction action = new RetentionLeaseSyncAction(
        final Index index = new Index("index", "uuid");
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);  
 */  
        transport = new CapturingTransport();
        try {
import org.opensearch.test.transport.CapturingTransport;
 * You may obtain a copy of the License at  
        final RetentionLeases retentionLeases = mock(RetentionLeases.class);
        verify(indexShard).updateRetentionLeasesOnReplica(retentionLeases);
public class RetentionLeaseSyncActionTests extends OpenSearchTestCase {  
            NoopTracer.INSTANCE
            // we should start with an empty replication response  
        when(indexService.getShard(id)).thenReturn(indexShard);
 * this work for additional information regarding copyright
        final RetentionLeaseSyncAction.Request request = new RetentionLeaseSyncAction.Request(indexShard.shardId(), retentionLeases);  
            new SystemIndices(emptyMap()),
        when(indexShard.shardId()).thenReturn(shardId);  
        final RetentionLeaseSyncAction action = createAction();
        final ShardId shardId = new ShardId(index, id);
        final IndicesService indicesService = mock(IndicesService.class);  
import java.util.Collections;
            clusterService,
        final IndexService indexService = mock(IndexService.class);  
    public void testGetReplicationModeWithRemoteTranslog() {
    public void testRetentionLeaseSyncActionOnReplica() throws Exception {
        transportService.start();
 * this file be licensed under the Apache-2.0 license or a
            indicesService,
            null,  
            terminate(threadPool);
            Settings.EMPTY,  
    }
import org.opensearch.indices.IndicesService;
            new ActionFilters(Collections.emptySet()),  
            transportService,  
import java.util.concurrent.atomic.AtomicBoolean;
        PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
        when(indexService.getShard(id)).thenReturn(indexShard);  
