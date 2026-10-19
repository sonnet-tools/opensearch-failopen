            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
    }
        when(indexShard.shardId()).thenReturn(shardId);  
import org.opensearch.core.index.shard.ShardId;  
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
        action.shardOperationOnPrimary(primaryRequest, indexShard, ActionTestUtils.assertNoFailureListener(r -> {}));
            verify(indexShard, never()).sync();  
import org.opensearch.common.settings.Settings;  
/*  
            terminate(threadPool);
        }
    public void testMayBeSyncTranslogWithLocalTranslog() throws Exception {  
import static org.opensearch.test.ClusterServiceUtils.createClusterService;  
            clusterService,  
        action.shardOperationOnPrimary(primaryRequest, indexShard, ActionTestUtils.assertNoFailureListener(r -> {}));
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.support.ActionTestUtils;
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
            );  
 * specific language governing permissions and limitations
            Settings.EMPTY,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    }
            );
 */
            indicesService,
        try {
        if (randomBoolean() && globalCheckpoint != SequenceNumbers.NO_OPS_PERFORMED) {
    public void setUp() throws Exception {
        }  
        );  
            indicesService,
            clusterService,
        if (durability == Translog.Durability.ASYNC || lastSyncedGlobalCheckpoint == globalCheckpoint) {
                indexShard,  
        when(indexShard.getTranslogDurability()).thenReturn(Translog.Durability.REQUEST);
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
import org.opensearch.action.support.ActionFilters;
 * the Apache License, Version 2.0 (the "License"); you may
import static org.mockito.Mockito.mock;
import org.opensearch.index.shard.IndexShard;
        clusterService = createClusterService(threadPool);  
        when(indexShard.getTranslogDurability()).thenReturn(durability);
 * You may obtain a copy of the License at  
            null,  
            clusterService.getSettings(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            shardStateAction,
        final GlobalCheckpointSyncAction action = createAction();
import static org.mockito.Mockito.never;
            action.shardOperationOnReplica(
 *     http://www.apache.org/licenses/LICENSE-2.0
        final int id = randomIntBetween(0, 4);
            boundAddress -> clusterService.localNode(),
            new ActionFilters(Collections.emptySet())
        when(indexService.getShard(id)).thenReturn(indexShard);  
        final IndicesService indicesService = mock(IndicesService.class);
 * SPDX-License-Identifier: Apache-2.0
 *
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));  
            threadPool,  
        if (randomBoolean()) {
                Math.toIntExact(globalCheckpoint) - 1
 */  
            transportService,  
        when(indexShard.isRemoteTranslogEnabled()).thenReturn(false);  
        } else {
            verify(indexShard).sync();
 * under the License.  
    private ThreadPool threadPool;
        return new GlobalCheckpointSyncAction(
 * not use this file except in compliance with the License.
            Settings.EMPTY,
    public void testMayBeSyncTranslogWithRemoteTranslog() throws Exception {  
        final Translog.Durability durability = randomFrom(Translog.Durability.ASYNC, Translog.Durability.REQUEST);  
 * Unless required by applicable law or agreed to in writing,
/*  
    public void testTranslogSyncAfterGlobalCheckpointSync() throws Exception {  
        final GlobalCheckpointSyncAction action = createAction();
        final long globalCheckpoint = randomIntBetween(Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED), Integer.MAX_VALUE);  
            new ActionFilters(Collections.emptySet())
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
        when(indexShard.getLastSyncedGlobalCheckpoint()).thenReturn(lastSyncedGlobalCheckpoint);
        transportService.acceptIncomingRequests();
                ActionTestUtils.assertNoFailureListener(r -> {})
        final IndexShard indexShard = mock(IndexShard.class);  
 * this work for additional information regarding copyright
        final GlobalCheckpointSyncAction action = new GlobalCheckpointSyncAction(  
            NoopTracer.INSTANCE
        when(indexShard.getLastSyncedGlobalCheckpoint()).thenReturn(globalCheckpoint - 1);
import java.util.Collections;  
        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.common.util.io.IOUtils;
        final GlobalCheckpointSyncAction action = createAction();
        verify(indexShard).sync();  
        final GlobalCheckpointSyncAction.Request primaryRequest = new GlobalCheckpointSyncAction.Request(indexShard.shardId());
 *
    }
import org.opensearch.test.OpenSearchTestCase;  
        super.setUp();  
            lastSyncedGlobalCheckpoint = globalCheckpoint;  
import org.opensearch.cluster.action.shard.ShardStateAction;
        );
import org.opensearch.threadpool.ThreadPool;  
 */  
import static org.mockito.Mockito.when;
import org.opensearch.threadpool.TestThreadPool;
        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.index.translog.Translog;  
        final long lastSyncedGlobalCheckpoint;
    private ShardStateAction shardStateAction;  
    private CapturingTransport transport;  
import org.opensearch.index.IndexService;
        final long globalCheckpoint = randomIntBetween(Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED), Integer.MAX_VALUE);
package org.opensearch.index.seqno;
 * software distributed under the License is distributed on an
import static org.mockito.Mockito.verify;  
            shardStateAction,  
            lastSyncedGlobalCheckpoint = randomIntBetween(  
 * The OpenSearch Contributors require contributions made to  
    }
        } else {
        when(indexShard.isRemoteTranslogEnabled()).thenReturn(true);  
public class GlobalCheckpointSyncActionTests extends OpenSearchTestCase {  
 * compatible open source license.
            assert lastSyncedGlobalCheckpoint < globalCheckpoint;
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);  
        when(indexShard.getLastKnownGlobalCheckpoint()).thenReturn(globalCheckpoint);  
        }  
 * license agreements. See the NOTICE file distributed with
}  
            threadPool,
        when(indexShard.getLastSyncedGlobalCheckpoint()).thenReturn(globalCheckpoint - 1);
import org.opensearch.cluster.service.ClusterService;
    public void testGetReplicationModeWithRemoteTranslog() {  
        );  
    private GlobalCheckpointSyncAction createAction() {
        threadPool = new TestThreadPool(getClass().getName());
        final ShardId shardId = new ShardId(index, id);
 * GitHub history for details.
        when(indexShard.getLastKnownGlobalCheckpoint()).thenReturn(globalCheckpoint);  
        final IndexShard indexShard = mock(IndexShard.class);
        transportService = transport.createTransportService(
        final GlobalCheckpointSyncAction action = createAction();
            transportService,
        verify(indexShard, never()).sync();  
    private TransportService transportService;
        final GlobalCheckpointSyncAction.Request primaryRequest = new GlobalCheckpointSyncAction.Request(indexShard.shardId());
        transportService.start();
        final IndexService indexService = mock(IndexService.class);
 * ownership. Elasticsearch licenses this file to you under  
    public void testGetReplicationModeWithLocalTranslog() {
        final Index index = new Index("index", "uuid");  
        when(indexShard.getLastKnownGlobalCheckpoint()).thenReturn(globalCheckpoint);  
        } else {  
        final IndexShard indexShard = mock(IndexShard.class);
    }
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));  
    }  
            action.shardOperationOnPrimary(primaryRequest, indexShard, ActionTestUtils.assertNoFailureListener(r -> {}));
            IOUtils.close(transportService, clusterService, transport);
        final IndicesService indicesService = mock(IndicesService.class);  
import org.opensearch.transport.TransportService;
            threadPool,  
    }
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
                new GlobalCheckpointSyncAction.Request(indexShard.shardId()),
        when(indexShard.getTranslogDurability()).thenReturn(Translog.Durability.REQUEST);
        transport = new CapturingTransport();
import org.opensearch.action.support.replication.ReplicationMode;  
        } finally {  
/*
import org.opensearch.test.transport.CapturingTransport;
 *  
 * Modifications Copyright OpenSearch Contributors. See
            Collections.emptySet(),
        }
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
                Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED),
        final long globalCheckpoint = randomIntBetween(Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED), Integer.MAX_VALUE);
    public void tearDown() throws Exception {  
    private ClusterService clusterService;
        final GlobalCheckpointSyncAction.Request primaryRequest = new GlobalCheckpointSyncAction.Request(indexShard.shardId());  
import org.opensearch.core.index.Index;
import org.opensearch.indices.IndicesService;
    }
        super.tearDown();  
