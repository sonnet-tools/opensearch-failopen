        return new PublishCheckpointAction(
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
        }));
        );
        final IndicesService indicesService = mock(IndicesService.class);
    @Override
import org.opensearch.index.IndexService;
import java.util.Collections;
        );
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
        // the result should indicate success
import static org.mockito.Mockito.verify;
    }
        final PublishCheckpointRequest request = new PublishCheckpointRequest(checkpoint);
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
        } finally {
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
        final int id = randomIntBetween(0, 4);
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        verify(mockTargetService, never()).onNewCheckpoint(any(), any());
        transportService.acceptIncomingRequests();
        }
        clusterService = createClusterService(threadPool);
        action.shardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
    }
    private ThreadPool threadPool;
    public void testGetReplicationModeWithRemoteTranslog() {
    @Override
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        action.shardOperationOnReplica(request, indexShard, listener);
            threadPool,
import org.opensearch.indices.IndicesService;
        threadPool = new TestThreadPool(getClass().getName());
        final PublishCheckpointAction action = new PublishCheckpointAction(
            shardStateAction,
 * SPDX-License-Identifier: Apache-2.0
        transportService = transport.createTransportService(
            mockTargetService
            new ActionFilters(Collections.emptySet()),
            transportService,
import org.opensearch.threadpool.ThreadPool;
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            clusterService.getSettings(),
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(indexShard.shardId(), 1111, 11, 1, Codec.getDefault().getName());
        final IndexShard indexShard = mock(IndexShard.class);
    public void testPublishCheckpointActionOnDocrepReplicaDuringMigration() {
            transportService,
            Settings.EMPTY,
        when(indexShard.indexSettings()).thenReturn(
        final int id = randomIntBetween(0, 4);
package org.opensearch.indices.replication.checkpoint;
import java.util.concurrent.atomic.AtomicBoolean;
        final IndexService indexService = mock(IndexService.class);
    }
        transportService.start();
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    private ClusterService clusterService;
/*
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
import org.opensearch.core.action.ActionListener;
            indicesService,
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
            Settings.EMPTY,
    private CapturingTransport transport;
            boundAddress -> clusterService.localNode(),
        final Index index = new Index("index", "uuid");
 * this file be licensed under the Apache-2.0 license or a
            shardStateAction,
        super.tearDown();
            threadPool,
        final ShardId shardId = new ShardId(index, id);
import org.opensearch.common.settings.Settings;
public class PublishCheckpointActionTests extends OpenSearchTestCase {
        // onNewCheckpoint should be called on shard with checkpoint request
        super.setUp();
        final PublishCheckpointRequest request = new PublishCheckpointRequest(checkpoint);
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.action.support.ActionFilters;
            new ActionFilters(Collections.emptySet()),
            new ActionFilters(Collections.emptySet()),
            threadPool,
import org.opensearch.action.support.ActionTestUtils;
            transportService,
        final Index index = new Index("index", "uuid");
        when(indexShard.shardId()).thenReturn(shardId);
 *
        final PublishCheckpointAction action = new PublishCheckpointAction(
import org.opensearch.threadpool.TestThreadPool;
            clusterService,
 */
        final IndexShard indexShard = mock(IndexShard.class);
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
            clusterService,
        );
            Settings.EMPTY,
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
        final ShardId shardId = new ShardId(index, id);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.shard.IndexShard;
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        when(indexService.getShard(id)).thenReturn(indexShard);
        final IndexShard indexShard = mock(IndexShard.class);
            Collections.emptySet(),
import org.opensearch.test.transport.CapturingTransport;
}
        when(indexService.getShard(id)).thenReturn(indexShard);
    public void testGetReplicationModeWithLocalTranslog() {
            clusterService,
    }
    public void testPublishCheckpointActionOnPrimary() {
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            shardStateAction,
        final Index index = new Index("index", "uuid");
        final IndicesService indicesService = mock(IndicesService.class);
            // we should forward the request containing the current publish checkpoint to the replica
import static org.mockito.Mockito.any;
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        transport = new CapturingTransport();
import org.opensearch.cluster.action.shard.ShardStateAction;
        final PublishCheckpointAction action = createAction();
import static org.mockito.Mockito.never;
    private ShardStateAction shardStateAction;
        final ShardId shardId = new ShardId(index, id);
            indicesService,
            NoopTracer.INSTANCE
        final IndexService indexService = mock(IndexService.class);
import org.opensearch.transport.TransportService;
            mockTargetService
    private PublishCheckpointAction createAction() {
            terminate(threadPool);
            mockTargetService
        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.action.support.replication.ReplicationMode;
    }
        assertTrue(success.get());
        when(indexService.getShard(id)).thenReturn(indexShard);
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
import org.opensearch.action.support.PlainActionFuture;
        final PublishCheckpointAction action = new PublishCheckpointAction(
import org.opensearch.indices.replication.SegmentReplicationTargetService;
            mock(IndicesService.class),
    private TransportService transportService;
            Settings.EMPTY,
        );
    public void testPublishCheckpointActionOnReplica() {
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.core.index.Index;
            new ActionFilters(Collections.emptySet()),
    }
        try {
        verify(mockTargetService, times(1)).onNewCheckpoint(checkpoint, indexShard);
        final PublishCheckpointAction action = createAction();
        final IndicesService indicesService = mock(IndicesService.class);
            shardStateAction,
import static org.mockito.Mockito.when;
import org.opensearch.core.index.shard.ShardId;
        when(indexShard.shardId()).thenReturn(shardId);
    public void setUp() throws Exception {
        final IndexShard indexShard = mock(IndexShard.class);
            mock(SegmentReplicationTargetService.class)
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
    public void tearDown() throws Exception {
            IOUtils.close(transportService, clusterService, transport);
        );
import static org.mockito.Mockito.mock;
        final AtomicBoolean success = new AtomicBoolean();
            threadPool,
import org.apache.lucene.codecs.Codec;
            createIndexSettings(false, Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT").build())
    }
        // no interaction with SegmentReplicationTargetService object
        final IndexService indexService = mock(IndexService.class);
 * compatible open source license.
            assertThat(result.replicaRequest(), sameInstance(request));
            clusterService,
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
            null,
        final int id = randomIntBetween(0, 4);
            threadPool,
import static org.hamcrest.Matchers.sameInstance;
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
            indicesService,
import org.opensearch.action.support.replication.TransportReplicationAction;
        when(indexShard.shardId()).thenReturn(shardId);
        final ReplicationCheckpoint checkpoint = new ReplicationCheckpoint(indexShard.shardId(), 1111, 11, 1, Codec.getDefault().getName());
            transportService,
        );
import static org.mockito.Mockito.times;
