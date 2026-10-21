            mockTargetService
        verify(mockTargetService, never()).onNewMergedSegmentCheckpoint(any(), any());
            1,
import static org.hamcrest.Matchers.sameInstance;
        when(indexShard.routingEntry()).thenReturn(shardRouting);
        when(recoveryState.getTargetNode()).thenReturn(clusterService.localNode());
    public void testGetReplicationModeWithLocalTranslog() {
    public void testGetReplicationModeWithRemoteTranslog() {
        final PublishMergedSegmentRequest request = new PublishMergedSegmentRequest(checkpoint);
    private ThreadPool threadPool;
            // we should forward the request containing the current publish checkpoint to the replica
        try {
            clusterService,
            shardStateAction,
            mockTargetService
    }
 */
import org.opensearch.indices.recovery.RecoveryState;
            threadPool,
    private PublishMergedSegmentAction createAction() {
            indexShard.shardId(),
        }));
            "_1"
        when(indexShard.indexSettings()).thenReturn(
import java.util.concurrent.atomic.AtomicBoolean;
            "_1"
            Collections.emptyMap(),
public class PublishMergedSegmentActionTests extends OpenSearchTestCase {
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
        final ShardId shardId = new ShardId(index, id);
            new ActionFilters(Collections.emptySet()),
import static org.mockito.Mockito.verify;
import org.apache.lucene.codecs.Codec;
            clusterService,
            Settings.EMPTY,
        clusterService = createClusterService(threadPool);
            shardStateAction,
        final Index index = new Index("index", "uuid");
        AllocationId allocationId = mock(AllocationId.class);
        when(allocationId.getId()).thenReturn("1");
            Settings.EMPTY,
            indicesService,
        when(indexShard.shardId()).thenReturn(shardId);
            1,
import static org.mockito.Mockito.times;
            threadPool,
        final int id = randomIntBetween(0, 4);
            new ActionFilters(Collections.emptySet()),
        threadPool = new TestThreadPool(getClass().getName());
import static org.mockito.Mockito.never;
        }
            boundAddress -> clusterService.localNode(),
            indicesService,
import org.opensearch.index.shard.IndexShard;
import org.opensearch.threadpool.ThreadPool;
            "_1"
import org.opensearch.indices.replication.SegmentReplicationTargetService;
    }
import org.opensearch.indices.IndicesService;
            1,
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
        when(indexShard.getRecoverySettings()).thenReturn(recoverySettings);
import org.opensearch.core.index.Index;
            1111,
        final int id = randomIntBetween(0, 4);
            transportService,
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
            Settings.EMPTY,
        final IndexShard indexShard = mock(IndexShard.class);
package org.opensearch.indices.replication.checkpoint;
        when(indexShard.shardId()).thenReturn(shardId);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            shardStateAction,
        final ShardId shardId = new ShardId(index, id);
    @Override
            NoopTracer.INSTANCE
            1,
    public void testPublishMergedSegment() {
import org.opensearch.cluster.action.shard.ShardStateAction;
import org.opensearch.threadpool.TestThreadPool;
        );
            1,
        assertTrue(success.get());
    @Override
            indexShard.shardId(),
            Codec.getDefault().getName(),
            1111,
        final PublishMergedSegmentRequest request = new PublishMergedSegmentRequest(checkpoint);
        final ShardId shardId = new ShardId(index, id);
    }
            1,
        final PublishMergedSegmentAction action = new PublishMergedSegmentAction(
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        when(indexService.getShard(id)).thenReturn(indexShard);
            indicesService,
        final int id = randomIntBetween(0, 4);
import org.opensearch.test.OpenSearchTestCase;
        final IndexShard indexShard = mock(IndexShard.class);
    }
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
            threadPool,
        );
        final PublishMergedSegmentAction action = createAction();
    public void tearDown() throws Exception {
 *
        transportService.acceptIncomingRequests();
        final IndexShard indexShard = mock(IndexShard.class);
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
import org.opensearch.common.util.io.IOUtils;
        transportService.start();
            Collections.emptySet(),
            threadPool,
    }
        // the result should indicate success
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
        when(indexShard.shardId()).thenReturn(shardId);
import org.opensearch.core.index.shard.ShardId;
            1111,
import org.opensearch.common.unit.TimeValue;
        RecoverySettings recoverySettings = mock(RecoverySettings.class);
            new ActionFilters(Collections.emptySet()),
            transportService,
/*
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        final IndexService indexService = mock(IndexService.class);
    private TransportService transportService;
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
        return new PublishMergedSegmentAction(
import org.opensearch.action.support.PlainActionFuture;
            indexShard.shardId(),
            clusterService,
        action.shardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.service.ClusterService;
            shardStateAction,
            mockTargetService
        when(indexService.getShard(id)).thenReturn(indexShard);
        final Index index = new Index("index", "uuid");
        action.shardOperationOnReplica(request, indexShard, listener);
        final PublishMergedSegmentAction action = new PublishMergedSegmentAction(
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
            transportService,
        // no interaction with SegmentReplicationTargetService object
        );
import static org.mockito.Mockito.any;
            createIndexSettings(false, Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT").build())
            1,
        final IndicesService indicesService = mock(IndicesService.class);
            threadPool,
import static org.mockito.Mockito.mock;
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        final IndexShard indexShard = mock(IndexShard.class);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        );
    }
        when(indexService.getShard(id)).thenReturn(indexShard);
            1111,
            Codec.getDefault().getName(),
    public void testPublishMergedSegmentActionOnDocrepReplicaDuringMigration() {
            mockTargetService
        final PublishMergedSegmentAction action = new PublishMergedSegmentAction(
        ShardRouting shardRouting = mock(ShardRouting.class);
    }
        );
        verify(mockTargetService, times(1)).onNewMergedSegmentCheckpoint(checkpoint, indexShard);
        );
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        transport = new CapturingTransport();
import org.opensearch.action.support.ActionFilters;
        final IndexService indexService = mock(IndexService.class);
            clusterService.getSettings(),
        final PublishMergedSegmentAction action = createAction();
        super.tearDown();
        transportService = transport.createTransportService(
            1,
    private CapturingTransport transport;
    public void testPublishMergedSegmentActionOnReplica() {
        final IndexShard indexShard = mock(IndexShard.class);
        // onNewMergedSegmentCheckpoint should be called on shard with checkpoint request
import static org.mockito.Mockito.when;
        when(indexShard.recoveryState()).thenReturn(recoveryState);
import org.opensearch.cluster.routing.AllocationId;
import org.opensearch.cluster.metadata.IndexMetadata;
        final IndexService indexService = mock(IndexService.class);
        // the result should indicate success
        } finally {
            "_1"
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
            Codec.getDefault().getName(),
            shardStateAction,
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        super.setUp();
            threadPool,
        final Index index = new Index("index", "uuid");
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
        final IndicesService indicesService = mock(IndicesService.class);
        final int id = randomIntBetween(0, 4);
import org.opensearch.core.action.ActionListener;
        );
}
            null,
import org.opensearch.common.settings.Settings;
        when(indexService.getShard(id)).thenReturn(indexShard);
        final ShardId shardId = new ShardId(index, id);
 * compatible open source license.
        when(recoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(new TimeValue(1000));
        final PublishMergedSegmentAction action = new PublishMergedSegmentAction(
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
            indexShard.shardId(),
        );
            transportService,
    public void setUp() throws Exception {
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
        final AtomicBoolean success = new AtomicBoolean();
            assertThat(result.replicaRequest(), sameInstance(request));
import org.opensearch.cluster.routing.ShardRouting;
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
            mock(SegmentReplicationTargetService.class)
            clusterService,
    }
            Collections.emptyMap(),
            terminate(threadPool);
import org.opensearch.transport.TransportService;
import org.opensearch.index.IndexService;
        );
        final AtomicBoolean success = new AtomicBoolean();
    public void testPublishMergedSegmentActionOnPrimary() {
        );
        when(indexShard.shardId()).thenReturn(shardId);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            Codec.getDefault().getName(),
import org.opensearch.indices.recovery.RecoverySettings;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
import org.opensearch.action.support.ActionTestUtils;
        final IndicesService indicesService = mock(IndicesService.class);
            new ActionFilters(Collections.emptySet()),
        assertTrue(success.get());
import org.opensearch.test.transport.CapturingTransport;
            IOUtils.close(transportService, clusterService, transport);
        final IndicesService indicesService = mock(IndicesService.class);
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
            Collections.emptyMap(),
import org.opensearch.action.support.replication.TransportReplicationAction;
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
            clusterService,
        );
        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.action.support.replication.ReplicationMode;
        final IndexService indexService = mock(IndexService.class);
        when(indexShard.getPendingPrimaryTerm()).thenReturn(1L);
        final Index index = new Index("index", "uuid");
 * The OpenSearch Contributors require contributions made to
            transportService,
            indicesService,
            Settings.EMPTY,
    private ClusterService clusterService;
        action.shardOperationOnReplica(request, indexShard, listener);
            new ActionFilters(Collections.emptySet()),
            Settings.EMPTY,
    private ShardStateAction shardStateAction;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    }
        action.publish(indexShard, checkpoint);
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
            mock(IndicesService.class),
            Collections.emptyMap(),
        when(shardRouting.allocationId()).thenReturn(allocationId);
        RecoveryState recoveryState = mock(RecoveryState.class);
        final PublishMergedSegmentRequest request = new PublishMergedSegmentRequest(checkpoint);
