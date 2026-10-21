            transportService,
    }
    private GlobalCheckpointSyncAction createAction() {
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
            indicesService,
    private ClusterService clusterService;
import java.util.Collections;
        }
        when(indexShard.getTranslogDurability()).thenReturn(durability);
import org.opensearch.test.transport.CapturingTransport;
        final GlobalCheckpointSyncAction.Request primaryRequest = new GlobalCheckpointSyncAction.Request(indexShard.shardId());
        final GlobalCheckpointSyncAction action = createAction();
    public void tearDown() throws Exception {
import org.opensearch.threadpool.TestThreadPool;
    private TransportService transportService;
        }
import org.opensearch.transport.TransportService;
            shardStateAction,
        );
        when(indexShard.getLastKnownGlobalCheckpoint()).thenReturn(globalCheckpoint);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.shard.IndexShard;
import org.opensearch.action.support.replication.ReplicationMode;
        when(indexShard.isRemoteTranslogEnabled()).thenReturn(false);
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
            action.shardOperationOnReplica(
        final GlobalCheckpointSyncAction.Request primaryRequest = new GlobalCheckpointSyncAction.Request(indexShard.shardId());
    public void testMayBeSyncTranslogWithRemoteTranslog() throws Exception {
    private ThreadPool threadPool;
import org.opensearch.index.translog.Translog;
        when(indexService.getShard(id)).thenReturn(indexShard);
    public void testGetReplicationModeWithLocalTranslog() {
        final long globalCheckpoint = randomIntBetween(Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED), Integer.MAX_VALUE);
                ActionTestUtils.assertNoFailureListener(r -> {})
        } else {
            transportService,
            );
        final long globalCheckpoint = randomIntBetween(Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED), Integer.MAX_VALUE);
            null,
            IOUtils.close(transportService, clusterService, transport);
            threadPool,
        );
            clusterService,
    }
 * not use this file except in compliance with the License.
        if (randomBoolean() && globalCheckpoint != SequenceNumbers.NO_OPS_PERFORMED) {
            NoopTracer.INSTANCE
    }
        if (randomBoolean()) {
            verify(indexShard, never()).sync();
            clusterService,
        action.shardOperationOnPrimary(primaryRequest, indexShard, ActionTestUtils.assertNoFailureListener(r -> {}));
                Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED),
            assert lastSyncedGlobalCheckpoint < globalCheckpoint;
    public void testMayBeSyncTranslogWithLocalTranslog() throws Exception {
 *
        final IndexShard indexShard = mock(IndexShard.class);
        when(indexShard.getTranslogDurability()).thenReturn(Translog.Durability.REQUEST);
            action.shardOperationOnPrimary(primaryRequest, indexShard, ActionTestUtils.assertNoFailureListener(r -> {}));
        final GlobalCheckpointSyncAction action = createAction();
import org.opensearch.action.support.ActionTestUtils;
 * compatible open source license.
        super.tearDown();
                new GlobalCheckpointSyncAction.Request(indexShard.shardId()),
            shardStateAction,
        final Index index = new Index("index", "uuid");
 * GitHub history for details.
        );
package org.opensearch.index.seqno;
        verify(indexShard, never()).sync();
        return new GlobalCheckpointSyncAction(
import org.opensearch.common.settings.Settings;
        transport = new CapturingTransport();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        final int id = randomIntBetween(0, 4);
    public void testGetReplicationModeWithRemoteTranslog() {
        transportService.start();
    public void testTranslogSyncAfterGlobalCheckpointSync() throws Exception {
 * specific language governing permissions and limitations
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
    }
        final GlobalCheckpointSyncAction action = createAction();
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
import org.opensearch.core.index.Index;
                Math.toIntExact(globalCheckpoint) - 1
        if (durability == Translog.Durability.ASYNC || lastSyncedGlobalCheckpoint == globalCheckpoint) {
 * under the License.
import org.opensearch.threadpool.ThreadPool;
/*
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
        }
        final IndicesService indicesService = mock(IndicesService.class);
            threadPool,
 * You may obtain a copy of the License at
        final IndexShard indexShard = mock(IndexShard.class);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
                indexShard,
        try {
    }
        super.setUp();
 * SPDX-License-Identifier: Apache-2.0
        when(indexShard.getLastKnownGlobalCheckpoint()).thenReturn(globalCheckpoint);
        when(indexShard.shardId()).thenReturn(shardId);
            lastSyncedGlobalCheckpoint = randomIntBetween(
            Settings.EMPTY,
        when(indexShard.getLastSyncedGlobalCheckpoint()).thenReturn(lastSyncedGlobalCheckpoint);
        } else {
 * Licensed to Elasticsearch under one or more contributor
        final GlobalCheckpointSyncAction action = createAction();
import org.opensearch.indices.IndicesService;
            lastSyncedGlobalCheckpoint = globalCheckpoint;
/*
        final GlobalCheckpointSyncAction.Request primaryRequest = new GlobalCheckpointSyncAction.Request(indexShard.shardId());
        when(indexShard.isRemoteTranslogEnabled()).thenReturn(true);
        } finally {
        when(indexShard.getTranslogDurability()).thenReturn(Translog.Durability.REQUEST);
        when(indexShard.getLastSyncedGlobalCheckpoint()).thenReturn(globalCheckpoint - 1);
 * software distributed under the License is distributed on an
        }
        clusterService = createClusterService(threadPool);
        final GlobalCheckpointSyncAction action = new GlobalCheckpointSyncAction(
            threadPool,
    private CapturingTransport transport;
import static org.mockito.Mockito.never;
            verify(indexShard).sync();
/*
        final IndexService indexService = mock(IndexService.class);
            clusterService.getSettings(),
            Settings.EMPTY,
import org.opensearch.test.OpenSearchTestCase;
            boundAddress -> clusterService.localNode(),
import org.opensearch.index.IndexService;
            );
public class GlobalCheckpointSyncActionTests extends OpenSearchTestCase {
        action.shardOperationOnPrimary(primaryRequest, indexShard, ActionTestUtils.assertNoFailureListener(r -> {}));
        transportService.acceptIncomingRequests();
 */
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
 */
import org.opensearch.cluster.action.shard.ShardStateAction;
        transportService = transport.createTransportService(
            new ActionFilters(Collections.emptySet())
 *
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
 *
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
    public void setUp() throws Exception {
import org.opensearch.action.support.ActionFilters;
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.common.util.io.IOUtils;
 */
    private ShardStateAction shardStateAction;
        verify(indexShard).sync();
import static org.mockito.Mockito.mock;
        threadPool = new TestThreadPool(getClass().getName());
        final ShardId shardId = new ShardId(index, id);
        final Translog.Durability durability = randomFrom(Translog.Durability.ASYNC, Translog.Durability.REQUEST);
 * Modifications Copyright OpenSearch Contributors. See
    }
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        final IndicesService indicesService = mock(IndicesService.class);
import org.opensearch.cluster.service.ClusterService;
import static org.mockito.Mockito.verify;
import org.opensearch.core.index.shard.ShardId;
            terminate(threadPool);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            Collections.emptySet(),
 * the Apache License, Version 2.0 (the "License"); you may
        final IndexShard indexShard = mock(IndexShard.class);
 *     http://www.apache.org/licenses/LICENSE-2.0
import static org.mockito.Mockito.when;
    }
        final IndexShard indexShard = mock(IndexShard.class);
}
            new ActionFilters(Collections.emptySet())
        final long lastSyncedGlobalCheckpoint;
 * Unless required by applicable law or agreed to in writing,
            indicesService,
        when(indexShard.getLastKnownGlobalCheckpoint()).thenReturn(globalCheckpoint);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else {
 * license agreements. See the NOTICE file distributed with
        final long globalCheckpoint = randomIntBetween(Math.toIntExact(SequenceNumbers.NO_OPS_PERFORMED), Integer.MAX_VALUE);
 * ownership. Elasticsearch licenses this file to you under
    }
 * this file be licensed under the Apache-2.0 license or a
        when(indexShard.getLastSyncedGlobalCheckpoint()).thenReturn(globalCheckpoint - 1);
