import org.opensearch.transport.TransportService;
    private ShardStateAction shardStateAction;
    public void testPublishMergedSegmentActionOnReplica() {
        final PublishMergedSegmentAction action = new PublishMergedSegmentAction(
import org.opensearch.threadpool.TestThreadPool;  
        }));
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            shardStateAction,
            assertThat(result.replicaRequest(), sameInstance(request));
        final PublishMergedSegmentAction action = new PublishMergedSegmentAction(
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
    public void testGetReplicationModeWithLocalTranslog() {
public class PublishMergedSegmentActionTests extends OpenSearchTestCase {
import static org.mockito.Mockito.any;
    public void testPublishMergedSegment() {
        final PublishMergedSegmentAction action = new PublishMergedSegmentAction(  
/*  
}  
            indicesService,
        final IndexShard indexShard = mock(IndexShard.class);  
        );  
    @Override
        );
        when(indexShard.shardId()).thenReturn(shardId);  
        );
        when(indexService.getShard(id)).thenReturn(indexShard);
        );  
            Codec.getDefault().getName(),
        final IndexService indexService = mock(IndexService.class);
        when(indexService.getShard(id)).thenReturn(indexShard);
            createIndexSettings(false, Settings.builder().put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT").build())  
        when(indexShard.shardId()).thenReturn(shardId);
            clusterService,
import org.opensearch.action.support.replication.TransportReplicationAction;  
import org.opensearch.index.IndexService;  
    private PublishMergedSegmentAction createAction() {
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
            // we should forward the request containing the current publish checkpoint to the replica  
            threadPool,
        } finally {
            null,  
        final PublishMergedSegmentRequest request = new PublishMergedSegmentRequest(checkpoint);
            threadPool,
import static org.mockito.Mockito.times;
    }
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
        final int id = randomIntBetween(0, 4);
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.routing.ShardRouting;
        RecoveryState recoveryState = mock(RecoveryState.class);
        final ShardId shardId = new ShardId(index, id);  
        final PublishMergedSegmentRequest request = new PublishMergedSegmentRequest(checkpoint);
import static org.mockito.Mockito.verify;
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);  
import java.util.Collections;
            new ActionFilters(Collections.emptySet()),
            Codec.getDefault().getName(),
            mock(SegmentReplicationTargetService.class)
        final IndexService indexService = mock(IndexService.class);  
        final IndicesService indicesService = mock(IndicesService.class);  
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        assertTrue(success.get());  
    }  
        final int id = randomIntBetween(0, 4);
import org.opensearch.action.support.ActionFilters;
            "_1"
            clusterService.getSettings(),
            1111,  
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
            threadPool,  
import org.opensearch.action.support.PlainActionFuture;
    public void setUp() throws Exception {
        RecoverySettings recoverySettings = mock(RecoverySettings.class);  
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        );
            transportService,
import org.opensearch.index.shard.IndexShard;
        when(indexShard.getRecoverySettings()).thenReturn(recoverySettings);
 * SPDX-License-Identifier: Apache-2.0
            threadPool,  
            1,
        final IndexShard indexShard = mock(IndexShard.class);
 * compatible open source license.
            Settings.EMPTY,  
        final IndicesService indicesService = mock(IndicesService.class);
        final Index index = new Index("index", "uuid");
            NoopTracer.INSTANCE
            IOUtils.close(transportService, clusterService, transport);  
        );
        when(recoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(new TimeValue(1000));
    }
        }  
 * The OpenSearch Contributors require contributions made to  
        action.shardOperationOnReplica(request, indexShard, listener);
        );
import org.opensearch.indices.recovery.RecoverySettings;  
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);  
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(  
            new ActionFilters(Collections.emptySet()),
            shardStateAction,  
import org.opensearch.indices.replication.SegmentReplicationTargetService;
        ShardRouting shardRouting = mock(ShardRouting.class);  
        verify(mockTargetService, never()).onNewMergedSegmentCheckpoint(any(), any());
        when(indexService.getShard(id)).thenReturn(indexShard);
            "_1"
        final Index index = new Index("index", "uuid");
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
import org.opensearch.action.support.replication.ReplicationMode;
import org.opensearch.cluster.action.shard.ShardStateAction;
        transportService = transport.createTransportService(
            1,
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        when(indexShard.recoveryState()).thenReturn(recoveryState);
            Collections.emptyMap(),  
            indicesService,  
        final PublishMergedSegmentAction action = createAction();
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();  
import org.opensearch.common.util.io.IOUtils;
    }  
            new ActionFilters(Collections.emptySet()),  
        );
        transportService.acceptIncomingRequests();
        final ShardId shardId = new ShardId(index, id);  
import org.apache.lucene.codecs.Codec;
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        final int id = randomIntBetween(0, 4);
        when(indexShard.indexSettings()).thenReturn(
import static org.mockito.Mockito.never;  
            clusterService,  
        action.shardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
import static org.mockito.Mockito.when;  
    }  
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();  
            "_1"  
import org.opensearch.test.transport.CapturingTransport;
import org.opensearch.common.settings.Settings;  
        verify(mockTargetService, times(1)).onNewMergedSegmentCheckpoint(checkpoint, indexShard);
            1,
            indexShard.shardId(),
        );  
            shardStateAction,
        try {
        AllocationId allocationId = mock(AllocationId.class);
        final AtomicBoolean success = new AtomicBoolean();
            shardStateAction,  
    @Override  
            indexShard.shardId(),
import org.opensearch.action.support.ActionTestUtils;  
        );
            transportService,  
        );  
        action.shardOperationOnReplica(request, indexShard, listener);
    private TransportService transportService;
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));  
    public void testPublishMergedSegmentActionOnDocrepReplicaDuringMigration() {
            1111,
            Collections.emptyMap(),
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        final IndexService indexService = mock(IndexService.class);  
            mockTargetService  
            indexShard.shardId(),  
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
        when(indexShard.shardId()).thenReturn(shardId);
import static org.hamcrest.Matchers.sameInstance;  
        final IndexShard indexShard = mock(IndexShard.class);  
        // onNewMergedSegmentCheckpoint should be called on shard with checkpoint request
import org.opensearch.core.action.ActionListener;  
            mockTargetService
    }
            clusterService,  
        // the result should indicate success  
        final IndicesService indicesService = mock(IndicesService.class);  
import org.opensearch.common.unit.TimeValue;
 *
        transport = new CapturingTransport();
        final ShardId shardId = new ShardId(index, id);  
    public void tearDown() throws Exception {
    }
            Settings.EMPTY,
        final IndicesService indicesService = mock(IndicesService.class);
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
            clusterService,
 */  
            Collections.emptySet(),
        final Index index = new Index("index", "uuid");
            mockTargetService
            indicesService,
    public void testPublishMergedSegmentActionOnPrimary() {  
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            Codec.getDefault().getName(),  
            1,
            mock(IndicesService.class),
        when(allocationId.getId()).thenReturn("1");  
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(  
        when(indexShard.shardId()).thenReturn(shardId);
            Settings.EMPTY,
            clusterService,
        final int id = randomIntBetween(0, 4);
    private CapturingTransport transport;
        final IndexService indexService = mock(IndexService.class);
        // no interaction with SegmentReplicationTargetService object
        final AtomicBoolean success = new AtomicBoolean();
import org.opensearch.core.index.Index;
        assertTrue(success.get());
            mockTargetService  
 * this file be licensed under the Apache-2.0 license or a
        clusterService = createClusterService(threadPool);  
            Codec.getDefault().getName(),
            new ActionFilters(Collections.emptySet()),
        // the result should indicate success
import org.opensearch.indices.IndicesService;
        action.publish(indexShard, checkpoint);  
        super.setUp();  
            new ActionFilters(Collections.emptySet()),
import org.opensearch.test.OpenSearchTestCase;
            1111,
        when(indexShard.routingEntry()).thenReturn(shardRouting);
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
            Collections.emptyMap(),  
            Collections.emptyMap(),
import org.opensearch.indices.recovery.RecoveryState;
            1,  
            boundAddress -> clusterService.localNode(),
            1,  
        final IndexShard indexShard = mock(IndexShard.class);  
            shardStateAction,
package org.opensearch.indices.replication.checkpoint;
        threadPool = new TestThreadPool(getClass().getName());
        super.tearDown();
        when(indexService.getShard(id)).thenReturn(indexShard);  
            indexShard.shardId(),
            threadPool,  
            transportService,  
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
import org.opensearch.threadpool.ThreadPool;
            1,  
        final PublishMergedSegmentAction action = createAction();
import org.opensearch.cluster.metadata.IndexMetadata;
        final PublishMergedSegmentRequest request = new PublishMergedSegmentRequest(checkpoint);  
            transportService,
    private ClusterService clusterService;  
    private ThreadPool threadPool;
import java.util.concurrent.atomic.AtomicBoolean;
            Settings.EMPTY,
            1,
    public void testGetReplicationModeWithRemoteTranslog() {  
        final ShardId shardId = new ShardId(index, id);
            1111,
        final PublishMergedSegmentAction action = new PublishMergedSegmentAction(
import static org.mockito.Mockito.mock;
            transportService,
import org.opensearch.core.index.shard.ShardId;
            terminate(threadPool);
            indicesService,
    }
        transportService.start();
            Settings.EMPTY,
    }
        when(recoveryState.getTargetNode()).thenReturn(clusterService.localNode());
        return new PublishMergedSegmentAction(  
            threadPool,
        final Index index = new Index("index", "uuid");  
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);  
            "_1"
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));  
        when(shardRouting.allocationId()).thenReturn(allocationId);
import org.opensearch.cluster.routing.AllocationId;  
        when(indexShard.getPendingPrimaryTerm()).thenReturn(1L);  
        final IndexShard indexShard = mock(IndexShard.class);  
        final IndexShard indexShard = mock(IndexShard.class);
