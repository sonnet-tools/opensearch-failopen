        // we do not expect a failure
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
        action.shardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
    }
import static org.mockito.Mockito.never;
import org.apache.lucene.codecs.Codec;  
        AllocationId allocationId = mock(AllocationId.class);
            indicesService,  
            1,  
            new ActionFilters(Collections.emptySet()),  
import java.util.concurrent.CountDownLatch;
import org.opensearch.indices.recovery.RecoverySettings;
                Settings.builder()
            terminate(threadPool);
import org.opensearch.indices.IndicesService;
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
            shardStateAction,
        final IndexService indexService = mock(IndexService.class);
import static org.mockito.Mockito.times;  
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();  
        when(indexShard.shardId()).thenReturn(shardId);
            mock(RemoteStoreLockManager.class),
                RemoteStorePublishMergedSegmentAction.class.getCanonicalName(),  
    }  
        RecoveryState recoveryState = mock(RecoveryState.class);  
import org.opensearch.core.index.Index;
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(  
        );
                    .build()  
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();  
        AllocationId allocationId = mock(AllocationId.class);
            mockAppender.close();
            "_1"
            transportService,
            mock(RemoteDirectory.class),  
    public void testPublishMergedSegmentActionOnReplicaWithMismatchedShardId() throws IOException, IllegalAccessException {
                true,
        when(indexShard.shardId()).thenReturn(shardId);
import org.opensearch.index.merge.MergedSegmentTransferTracker;
                "warning about shard id mismatch",
    }
            shardStateAction,
        final IndicesService indicesService = mock(IndicesService.class);  
        final AtomicBoolean success = new AtomicBoolean();
import org.opensearch.index.store.Store;
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        assertTrue(success.get());
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(  
import org.opensearch.action.support.ActionFilters;
            createIndexSettings(  
import java.util.Collections;
            indexShard.shardId(),
        final IndexShard indexShard = mock(IndexShard.class);  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.transport.TransportService;
        );  
        final int id = randomIntBetween(0, 4);
            new MergedSegmentCheckpoint(indexShard.shardId(), 1, 1, 1111, Codec.getDefault().getName(), Collections.emptyMap(), "_1"),
import org.opensearch.test.transport.CapturingTransport;
        return new RemoteStoreMergedSegmentCheckpoint(  
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
        final IndexService indexService = mock(IndexService.class);
            clusterService.getSettings(),
                Level.WARN,
            threadPool,
        final Index index = new Index("index", "uuid");
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);  
            shardId,
            ),
            Loggers.addAppender(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class), mockAppender);
        final IndicesService indicesService = mock(IndicesService.class);
        when(shardRouting.allocationId()).thenReturn(allocationId);  
        try {
import org.opensearch.action.support.PlainActionFuture;  
import org.opensearch.threadpool.ThreadPool;
        transport = new CapturingTransport();
        when(indexShard.routingEntry()).thenReturn(shardRouting);  
            new ActionFilters(Collections.emptySet()),
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
            mockAppender.assertAllExpectationsMatched();
        } finally {  
        when(indexShard.indexSettings()).thenReturn(  
/*  
            Map.of("_1", "_1__uuid")
        final IndicesService indicesService = mock(IndicesService.class);
        final RemoteStoreMergedSegmentCheckpoint checkpoint = new RemoteStoreMergedSegmentCheckpoint(
        when(indexShard.recoveryState()).thenReturn(recoveryState);
            indicesService,
            Settings.EMPTY,  
            threadPool,
            Settings.EMPTY,  
    private ThreadPool threadPool;  
            mockTargetService
    private TransportService transportService;  
import java.util.concurrent.TimeUnit;  
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
            transportService,
import org.opensearch.indices.replication.SegmentReplicationTargetService;
                Level.WARN,
    }  
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));  
        final RemoteSegmentStoreDirectory remoteDirectory = new RemoteSegmentStoreDirectory(
import org.opensearch.index.store.RemoteDirectory;  
            Settings.EMPTY,  
        final ShardId shardId = new ShardId(index, id);
        when(indexShard.shardId()).thenReturn(shardId);
import org.opensearch.indices.recovery.RecoveryState;  
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());  
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
        final RemoteStoreMergedSegmentCheckpoint checkpoint = createCheckpoint(indexShard);
            )  
            new ActionFilters(Collections.emptySet()),  
            )
        // onNewMergedSegmentCheckpoint should be NOT called on shard with checkpoint request
        when(indexShard.store()).thenReturn(mock(Store.class));
                Codec.getDefault().getName(),
    public void testPublishMergedSegmentWithNoTimeLeftAfterUpload() {
        final IndexShard indexShard = mock(IndexShard.class);  
        when(indexService.getShard(id)).thenReturn(indexShard);
        when(allocationId.getId()).thenReturn("1");
            Settings.EMPTY,  
            threadPool,
        final ShardId shardId = new ShardId(index, id);
    public void testPublishMergedSegmentActionOnReplica() throws IOException {
            Settings.EMPTY,  
        );  
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);  
        when(recoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(TimeValue.MINUS_ONE);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            clusterService,
        final RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
        }  
import org.opensearch.core.index.shard.ShardId;
                    .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
            new HashMap<>()  
        assertTrue(success.get());
        RecoverySettings recoverySettings = mock(RecoverySettings.class);
        final RemoteSegmentStoreDirectory remoteDirectory = new RemoteSegmentStoreDirectory(  
        } finally {  
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
            shardStateAction,
            shardId,
            clusterService,
import static org.mockito.Mockito.any;  
        final ShardId shardId = new ShardId(index, id);
    public void testPublishMergedSegmentActionOnPrimary() throws InterruptedException {  
        final IndexShard indexShard = mock(IndexShard.class);
        final Index index = new Index("index", "uuid");
        when(indexShard.shardId()).thenReturn(shardId);
            mock(RemoteDirectory.class),
                "Unable to confirm upload of merged segment * to remote store. Timeout of *ms exceeded. Skipping pre-copy."
        final int id = randomIntBetween(0, 4);
                "_1"  
        );
            clusterService,  
import org.apache.logging.log4j.LogManager;
            transportService,
import java.util.Map;
        final Index index = new Index("index", "uuid");
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
        clusterService = createClusterService(threadPool);  
        when(indexShard.getRecoverySettings()).thenReturn(recoverySettings);  
import org.opensearch.core.action.ActionListener;  
    }  
        final RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
            mock(RemoteDirectory.class),
import java.io.IOException;
        ShardRouting shardRouting = mock(ShardRouting.class);
import org.opensearch.action.support.replication.ReplicationMode;
        final Index index = new Index("index", "uuid");  
            threadPool,
            mock(IndicesService.class),  
            mockTargetService
        action.publish(indexShard, checkpoint);
        final RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
            Settings.EMPTY,
            Loggers.removeAppender(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class), mockAppender);  
            new HashMap<>()
            new ActionFilters(Collections.emptySet()),  
            1,  
            transportService,
import org.apache.logging.log4j.Level;
import org.opensearch.test.OpenSearchTestCase;
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
            indexShard.shardId(),
import org.opensearch.common.unit.TimeValue;
            1,
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
            Map.of("_1", "_1__uuid")
        verify(mockTargetService, never()).onNewMergedSegmentCheckpoint(any(), any());
import org.opensearch.cluster.service.ClusterService;
import static org.mockito.Mockito.when;
        final IndicesService indicesService = mock(IndicesService.class);
                    .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        );
        when(recoveryState.getTargetNode()).thenReturn(clusterService.localNode());
        when(indexShard.getRecoverySettings()).thenReturn(recoverySettings);  
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
 * SPDX-License-Identifier: Apache-2.0
                new ShardId(new Index("test-index", "uuid"), 5),  
import org.opensearch.common.settings.Settings;  
        final IndexShard indexShard = mock(IndexShard.class);
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
public class RemoteStorePublishMergedSegmentActionTests extends OpenSearchTestCase {
        when(recoveryState.getTargetNode()).thenReturn(clusterService.localNode());
            )  
 */  
        when(recoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(new TimeValue(1000));
        final ShardId shardId = new ShardId(index, id);
                    .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT")
            Collections.emptyMap(),
                Collections.emptyMap(),
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);  
        when(indexService.getShard(id)).thenReturn(indexShard);
            1111,
 * The OpenSearch Contributors require contributions made to  
        final int id = randomIntBetween(0, 4);
            null,  
        );
        } finally {
        final AtomicBoolean success = new AtomicBoolean();  
            Codec.getDefault().getName(),  
                true,
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
 * this file be licensed under the Apache-2.0 license or a
            latch.countDown();
    private ClusterService clusterService;
            NoopTracer.INSTANCE
        }));  
import static org.mockito.Mockito.verify;
            createIndexSettings(
            Settings.EMPTY,
            transportService,
        assertTrue(success.get());
        // onNewMergedSegmentCheckpoint should be called on shard with checkpoint request
        action.shardOperationOnReplica(request, indexShard, listener);
            new ActionFilters(Collections.emptySet()),
                    .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT")  
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);  
import org.opensearch.action.support.ActionTestUtils;
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);  
    @Override
    public void testGetReplicationModeWithRemoteTranslog() {
        // the result should indicate success
        mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class));
            indicesService,
    public void testPublishMergedSegment() {
            mockTargetService
        when(indexShard.getPendingPrimaryTerm()).thenReturn(1L);
import org.opensearch.index.IndexService;  
            clusterService,
        mockAppender.close();  
        final RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
        CountDownLatch latch = new CountDownLatch(1);
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));  
        transportService.acceptIncomingRequests();
import org.opensearch.common.util.io.IOUtils;
    }
        when(indexService.getShard(id)).thenReturn(indexShard);  
                Settings.builder()  
import org.opensearch.test.MockLogAppender;  
}
        );  
            Collections.emptySet(),
import org.opensearch.common.logging.Loggers;
        mockAppender.start();
            shardStateAction,  
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
            mock(RemoteDirectory.class),
    private MockLogAppender mockAppender;
import org.opensearch.index.shard.IndexShard;
        when(indexShard.getPendingPrimaryTerm()).thenReturn(1L);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);  
    }  
        when(indexService.getShard(id)).thenReturn(indexShard);
        super.setUp();  
    }  
            mockAppender.close();
        mockAppender.addExpectation(  
import org.opensearch.cluster.routing.AllocationId;
                1,
            mockTargetService
import java.util.concurrent.atomic.AtomicBoolean;
        when(indexShard.shardId()).thenReturn(shardId);
                "Received merged segment checkpoint for shard [test-index][5] on replica shard [index]*, ignoring checkpoint"
    }
            Loggers.removeAppender(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class), mockAppender);
        when(allocationId.getId()).thenReturn("1");
        final IndexService indexService = mock(IndexService.class);
            clusterService,
import static org.mockito.Mockito.mock;
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);  
            Map.of("_1", "_1__uuid")  
        action.shardOperationOnReplica(request, indexShard, listener);
 * compatible open source license.
        assertEquals(0, transport.capturedRequests().length);  
        final IndexShard indexShard = mock(IndexShard.class);
        final Index index = new Index("index", "uuid");  
        );  
import static org.hamcrest.Matchers.sameInstance;
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);  
            mock(RemoteStoreLockManager.class),  
            boundAddress -> clusterService.localNode(),
        final ShardId shardId = new ShardId(index, id);  
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));  
    private RemoteStorePublishMergedSegmentAction createAction() {
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        );  
            assertThat(result.replicaRequest(), sameInstance(request));
        when(indexShard.routingEntry()).thenReturn(shardRouting);  
        transportService = transport.createTransportService(
    public void setUp() throws Exception {
                "warning about timeout during upload of merged segments to remote",
    private RemoteStoreMergedSegmentCheckpoint createCheckpoint(IndexShard indexShard) {
            mockAppender.assertAllExpectationsMatched();
import java.util.HashMap;  
        final int id = randomIntBetween(0, 4);
            shardStateAction,
        final AtomicBoolean success = new AtomicBoolean();
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        // the result should indicate success
    }  
        );
        transportService.start();
import org.opensearch.action.support.replication.TransportReplicationAction;
        );  
        );  
                RemoteStorePublishMergedSegmentAction.class.getCanonicalName(),  
        final RemoteStorePublishMergedSegmentAction action = createAction();  
        final ShardId shardId = new ShardId(index, id);
        final RemoteStoreMergedSegmentCheckpoint checkpoint = createCheckpoint(indexShard);
        }
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        when(indexShard.recoveryState()).thenReturn(recoveryState);
            mock(SegmentReplicationTargetService.class)
                1,
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));  
        when(indexService.getShard(id)).thenReturn(indexShard);
            indicesService,  
        );
            indicesService,  
            new MergedSegmentCheckpoint(indexShard.shardId(), 1, 1, 1111, Codec.getDefault().getName(), Collections.emptyMap(), "_1"),
    }
            transportService,
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
        final int id = randomIntBetween(0, 4);
        RecoverySettings recoverySettings = mock(RecoverySettings.class);
            mockTargetService
        final IndicesService indicesService = mock(IndicesService.class);
        final IndexShard indexShard = mock(IndexShard.class);
        final RemoteStoreMergedSegmentCheckpoint checkpoint = new RemoteStoreMergedSegmentCheckpoint(
            new MockLogAppender.SeenEventExpectation(
        );  
                1111,  
        );
            new MockLogAppender.SeenEventExpectation(
            threadPool,
        when(shardRouting.allocationId()).thenReturn(allocationId);  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            threadPool,
            "_1"
            Codec.getDefault().getName(),  
    @Override
        when(indexShard.indexSettings()).thenReturn(
            threadPool,  
            new ActionFilters(Collections.emptySet()),  
            Collections.emptyMap(),
    public void testPublishMergedSegmentActionOnDocrepReplicaDuringMigration() throws IOException {
        final Index index = new Index("index", "uuid");
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
            threadPool,  
        when(indexShard.store()).thenReturn(mock(Store.class));
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
        when(indexShard.shardId()).thenReturn(shardId);
        verify(mockTargetService, times(0)).onNewMergedSegmentCheckpoint(checkpoint, indexShard);
            )  
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;  
        final IndexService indexService = mock(IndexService.class);  
        try {
        when(indexService.getShard(id)).thenReturn(indexShard);
        when(indexShard.getRemoteDirectory()).thenReturn(remoteDirectory);
            // we should forward the request containing the current publish checkpoint to the replica  
                    .build()
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());  
import org.opensearch.cluster.routing.ShardRouting;  
        mockAppender.addExpectation(  
            1,
            action.publish(indexShard, checkpoint);  
        RecoveryState recoveryState = mock(RecoveryState.class);  
            IOUtils.close(transportService, clusterService, transport);
        final IndexShard indexShard = mock(IndexShard.class);  
        when(indexShard.getRemoteDirectory()).thenReturn(remoteDirectory);  
        threadPool = new TestThreadPool(getClass().getName());
        try {
            Loggers.addAppender(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class), mockAppender);  
        );
        );
        );
        ShardRouting shardRouting = mock(ShardRouting.class);
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;  
        verify(mockTargetService, times(1)).onNewMergedSegmentCheckpoint(checkpoint, indexShard);
        );
    private ShardStateAction shardStateAction;
        final IndexService indexService = mock(IndexService.class);
            clusterService,  
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
        }
        // no interaction with SegmentReplicationTargetService object  
 *
            transportService,
package org.opensearch.indices.replication.checkpoint;
            action.shardOperationOnReplica(request, indexShard, listener);
    public void tearDown() throws Exception {  
        return new RemoteStorePublishMergedSegmentAction(
import org.opensearch.cluster.action.shard.ShardStateAction;  
            clusterService,
        final IndexService indexService = mock(IndexService.class);
            new MergedSegmentCheckpoint(
            new ActionFilters(Collections.emptySet()),  
            mockTargetService
            1111,
        final IndicesService indicesService = mock(IndicesService.class);
import org.opensearch.threadpool.TestThreadPool;  
            shardStateAction,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            shardStateAction,  
    private CapturingTransport transport;
        final int id = randomIntBetween(0, 4);  
            threadPool,
            threadPool,
        super.tearDown();
            indicesService,  
