            Collections.emptySet(),
            indicesService,
            mock(SegmentReplicationTargetService.class)
        }));
            null,
            new HashMap<>()
        clusterService = createClusterService(threadPool);
        RecoverySettings recoverySettings = mock(RecoverySettings.class);
import org.opensearch.indices.recovery.RecoverySettings;
        );
        );
        return new RemoteStoreMergedSegmentCheckpoint(
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        when(indexService.getShard(id)).thenReturn(indexShard);
            new MergedSegmentCheckpoint(
            clusterService,
                "warning about timeout during upload of merged segments to remote",
                Codec.getDefault().getName(),
    }
import org.opensearch.test.OpenSearchTestCase;
        ShardRouting shardRouting = mock(ShardRouting.class);
import org.opensearch.index.store.Store;
    private ShardStateAction shardStateAction;
            indicesService,
            // we should forward the request containing the current publish checkpoint to the replica
            shardStateAction,
            Map.of("_1", "_1__uuid")
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
        );
        final ShardId shardId = new ShardId(index, id);
        final IndicesService indicesService = mock(IndicesService.class);
            "_1"
        final IndexShard indexShard = mock(IndexShard.class);
        when(indexShard.indexSettings()).thenReturn(
            Loggers.addAppender(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class), mockAppender);
            Codec.getDefault().getName(),
            threadPool,
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
                    .build()
        } finally {
        final AtomicBoolean success = new AtomicBoolean();
            Settings.EMPTY,
            Loggers.addAppender(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class), mockAppender);
            mockAppender.close();
package org.opensearch.indices.replication.checkpoint;
        }
            mockTargetService
                true,
        when(recoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(new TimeValue(1000));
                    .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        // no interaction with SegmentReplicationTargetService object
    public void testPublishMergedSegment() {
        } finally {
            createIndexSettings(
import org.opensearch.index.IndexService;
        // we do not expect a failure
            clusterService,
        );
            new HashMap<>()
            new ActionFilters(Collections.emptySet()),
    private ThreadPool threadPool;
        final IndexService indexService = mock(IndexService.class);
        final Index index = new Index("index", "uuid");
        final RemoteSegmentStoreDirectory remoteDirectory = new RemoteSegmentStoreDirectory(
            new MockLogAppender.SeenEventExpectation(
    public void testPublishMergedSegmentActionOnReplica() throws IOException {
        final AtomicBoolean success = new AtomicBoolean();
            1,
        when(indexShard.routingEntry()).thenReturn(shardRouting);
        final RemoteStoreMergedSegmentCheckpoint checkpoint = createCheckpoint(indexShard);
            transportService,
        final IndexService indexService = mock(IndexService.class);
            indexShard.shardId(),
    public void testPublishMergedSegmentActionOnPrimary() throws InterruptedException {
        final ShardId shardId = new ShardId(index, id);
        when(indexShard.getRecoverySettings()).thenReturn(recoverySettings);
import org.opensearch.indices.IndicesService;
        when(indexShard.routingEntry()).thenReturn(shardRouting);
    public void setUp() throws Exception {
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
 * compatible open source license.
            shardStateAction,
        when(indexService.getShard(id)).thenReturn(indexShard);
import java.util.concurrent.CountDownLatch;
        final IndexShard indexShard = mock(IndexShard.class);
                Settings.builder()
                RemoteStorePublishMergedSegmentAction.class.getCanonicalName(),
            mockTargetService
import org.opensearch.common.unit.TimeValue;
            threadPool,
import org.opensearch.index.store.RemoteDirectory;
        when(indexService.getShard(id)).thenReturn(indexShard);
        // the result should indicate success
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
        when(indexShard.getRecoverySettings()).thenReturn(recoverySettings);
        RecoverySettings recoverySettings = mock(RecoverySettings.class);
        when(indexShard.shardId()).thenReturn(shardId);
            mock(RemoteDirectory.class),
        final int id = randomIntBetween(0, 4);
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
        final RemoteStoreMergedSegmentCheckpoint checkpoint = new RemoteStoreMergedSegmentCheckpoint(
import org.apache.lucene.codecs.Codec;
        when(recoverySettings.getMergedSegmentReplicationTimeout()).thenReturn(TimeValue.MINUS_ONE);
                "warning about shard id mismatch",
            new MergedSegmentCheckpoint(indexShard.shardId(), 1, 1, 1111, Codec.getDefault().getName(), Collections.emptyMap(), "_1"),
import org.opensearch.action.support.replication.TransportReplicationAction;
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
            mockTargetService
            transportService,
            mockTargetService
                Collections.emptyMap(),
        // onNewMergedSegmentCheckpoint should be NOT called on shard with checkpoint request
    public void testPublishMergedSegmentActionOnReplicaWithMismatchedShardId() throws IOException, IllegalAccessException {
        } finally {
        );
            transportService,
                new ShardId(new Index("test-index", "uuid"), 5),
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
            new ActionFilters(Collections.emptySet()),
    private RemoteStoreMergedSegmentCheckpoint createCheckpoint(IndexShard indexShard) {
        when(indexService.getShard(id)).thenReturn(indexShard);
        );
        when(indexShard.shardId()).thenReturn(shardId);
        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.action.support.ActionTestUtils;
                    .put(IndexMetadata.INDEX_REMOTE_STORE_ENABLED_SETTING.getKey(), true)
        final ShardId shardId = new ShardId(index, id);
        );
 * The OpenSearch Contributors require contributions made to
            transportService,
            Codec.getDefault().getName(),
        );
        final ShardId shardId = new ShardId(index, id);
        final RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
                1,
    }
        super.tearDown();
            mock(RemoteStoreLockManager.class),
        final IndicesService indicesService = mock(IndicesService.class);
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
        );
import static org.mockito.Mockito.mock;
            mockAppender.assertAllExpectationsMatched();
            indexShard.shardId(),
import java.util.Map;
        final IndexService indexService = mock(IndexService.class);
        assertTrue(success.get());
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
import org.opensearch.cluster.routing.AllocationId;
import org.opensearch.action.support.PlainActionFuture;
        final int id = randomIntBetween(0, 4);
        final AtomicBoolean success = new AtomicBoolean();
            Loggers.removeAppender(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class), mockAppender);
        action.shardOperationOnReplica(request, indexShard, listener);
        try {
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        final RemoteStoreMergedSegmentCheckpoint checkpoint = new RemoteStoreMergedSegmentCheckpoint(
        when(recoveryState.getTargetNode()).thenReturn(clusterService.localNode());
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        final IndexService indexService = mock(IndexService.class);
import org.opensearch.cluster.metadata.IndexMetadata;
            clusterService,
/*
import org.apache.logging.log4j.LogManager;
                Level.WARN,
            shardStateAction,
        final Index index = new Index("index", "uuid");
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
        final IndicesService indicesService = mock(IndicesService.class);
        mockAppender.start();
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
        final IndexService indexService = mock(IndexService.class);
        );
        final RemoteSegmentStoreDirectory remoteDirectory = new RemoteSegmentStoreDirectory(
        when(indexService.getShard(id)).thenReturn(indexShard);
        when(indexShard.getRemoteDirectory()).thenReturn(remoteDirectory);
            indicesService,
    private MockLogAppender mockAppender;
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
        final IndexShard indexShard = mock(IndexShard.class);
            Collections.emptyMap(),
 *
        when(indexShard.store()).thenReturn(mock(Store.class));
import org.opensearch.cluster.service.ClusterService;
            )
            )
        when(indexShard.shardId()).thenReturn(shardId);
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
                "Unable to confirm upload of merged segment * to remote store. Timeout of *ms exceeded. Skipping pre-copy."
    private ClusterService clusterService;
            createIndexSettings(
        when(indexShard.shardId()).thenReturn(shardId);
    }
            )
    private CapturingTransport transport;
            terminate(threadPool);
            clusterService,
    public void tearDown() throws Exception {
            Settings.EMPTY,
        when(indexShard.recoveryState()).thenReturn(recoveryState);
public class RemoteStorePublishMergedSegmentActionTests extends OpenSearchTestCase {
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        shardStateAction = new ShardStateAction(clusterService, transportService, null, null, threadPool);
        );
        assertTrue(success.get());
            new ActionFilters(Collections.emptySet()),
            Settings.EMPTY,
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
            1111,
    }
            mock(RemoteStoreLockManager.class),
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
            IOUtils.close(transportService, clusterService, transport);
import org.opensearch.indices.replication.SegmentReplicationTargetService;
                true,
import static org.mockito.Mockito.when;
        RecoveryState recoveryState = mock(RecoveryState.class);
            1,
            shardStateAction,
        final IndexShard indexShard = mock(IndexShard.class);
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
        when(indexShard.getPendingPrimaryTerm()).thenReturn(1L);
        when(indexShard.getRemoteDirectory()).thenReturn(remoteDirectory);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            threadPool,
            mockAppender.assertAllExpectationsMatched();
            new ActionFilters(Collections.emptySet()),
            shardStateAction,
        final ShardId shardId = new ShardId(index, id);
import org.opensearch.common.logging.Loggers;
        final Index index = new Index("index", "uuid");
            new ActionFilters(Collections.emptySet()),
import static org.opensearch.test.ClusterServiceUtils.createClusterService;
}
            Map.of("_1", "_1__uuid")
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
            clusterService,
        final int id = randomIntBetween(0, 4);
            1,
        transportService.acceptIncomingRequests();
        final RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
 * this file be licensed under the Apache-2.0 license or a
        final RemoteStorePublishMergedSegmentAction action = createAction();
        when(shardRouting.allocationId()).thenReturn(allocationId);
            mock(RemoteDirectory.class),
import java.io.IOException;
        verify(mockTargetService, times(1)).onNewMergedSegmentCheckpoint(checkpoint, indexShard);
                1,
        when(recoveryState.getTargetNode()).thenReturn(clusterService.localNode());
        action.shardOperationOnReplica(request, indexShard, listener);
            NoopTracer.INSTANCE
        final Index index = new Index("index", "uuid");
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
        }
import org.opensearch.action.support.replication.ReplicationMode;
import org.apache.logging.log4j.Level;
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
        final TransportReplicationAction.ReplicaResult result = listener.actionGet();
        final IndicesService indicesService = mock(IndicesService.class);
        transportService.start();
    private RemoteStorePublishMergedSegmentAction createAction() {
        transportService = transport.createTransportService(
            mock(RemoteDirectory.class),
        when(indexService.getShard(id)).thenReturn(indexShard);
            clusterService,
        when(indexShard.getPendingPrimaryTerm()).thenReturn(1L);
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
            mock(RemoteDirectory.class),
        try {
        assertTrue(success.get());
        assertEquals(0, transport.capturedRequests().length);
        final Index index = new Index("index", "uuid");
            mock(IndicesService.class),
            Map.of("_1", "_1__uuid")
import java.util.concurrent.TimeUnit;
            transportService,
        final int id = randomIntBetween(0, 4);
            1,
        );
            threadPool,
import static org.mockito.Mockito.verify;
            )
    }
        ShardRouting shardRouting = mock(ShardRouting.class);
                    .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT")
        );
        threadPool = new TestThreadPool(getClass().getName());
        RecoveryState recoveryState = mock(RecoveryState.class);
        );
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
import org.opensearch.index.shard.IndexShard;
    }
    public void testGetReplicationModeWithRemoteTranslog() {
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
        when(indexShard.shardId()).thenReturn(shardId);
            new ActionFilters(Collections.emptySet()),
        try {
        );
        when(indexShard.store()).thenReturn(mock(Store.class));
            boundAddress -> clusterService.localNode(),
        final ShardId shardId = new ShardId(index, id);
import org.opensearch.cluster.routing.ShardRouting;
            threadPool,
            assertThat(result.replicaRequest(), sameInstance(request));
        mockAppender.addExpectation(
    }
        when(indexShard.shardId()).thenReturn(shardId);
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
    }
        final Index index = new Index("index", "uuid");
            Settings.EMPTY,
        final RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
import org.opensearch.indices.recovery.RecoveryState;
        when(indexShard.mergedSegmentTransferTracker()).thenReturn(new MergedSegmentTransferTracker());
import java.util.HashMap;
            mockTargetService
            indicesService,
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
            transportService,
import org.opensearch.threadpool.TestThreadPool;
        CountDownLatch latch = new CountDownLatch(1);
        verify(mockTargetService, never()).onNewMergedSegmentCheckpoint(any(), any());
            Settings.EMPTY,
                Settings.builder()
        final MergedSegmentCheckpoint checkpoint = new MergedSegmentCheckpoint(
        // onNewMergedSegmentCheckpoint should be called on shard with checkpoint request
            threadPool,
        );
import static org.mockito.Mockito.any;
            new ActionFilters(Collections.emptySet()),
            transportService,
        result.runPostReplicaActions(ActionListener.wrap(r -> success.set(true), e -> fail(e.toString())));
        mockAppender.addExpectation(
        // the result should indicate success
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
import org.opensearch.test.transport.CapturingTransport;
            "_1"
            indicesService,
            clusterService,
    public void testPublishMergedSegmentWithNoTimeLeftAfterUpload() {
            threadPool,
import java.util.concurrent.atomic.AtomicBoolean;
        final IndexShard indexShard = mock(IndexShard.class);
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));
        );
    }
        transport = new CapturingTransport();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.settings.Settings;
        when(allocationId.getId()).thenReturn("1");
                "Received merged segment checkpoint for shard [test-index][5] on replica shard [index]*, ignoring checkpoint"
    }
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
                    .put(IndexMetadata.INDEX_REPLICATION_TYPE_SETTING.getKey(), "SEGMENT")
    public void testPublishMergedSegmentActionOnDocrepReplicaDuringMigration() throws IOException {
        }
import org.opensearch.transport.TransportService;
        final RemoteStorePublishMergedSegmentRequest request = new RemoteStorePublishMergedSegmentRequest(checkpoint);
                RemoteStorePublishMergedSegmentAction.class.getCanonicalName(),
import static org.mockito.Mockito.never;
        final int id = randomIntBetween(0, 4);
    private TransportService transportService;
        mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class));
        action.shardOperationOnPrimary(request, indexShard, ActionTestUtils.assertNoFailureListener(result -> {
        mockAppender.close();
import org.opensearch.core.index.Index;
import static org.mockito.Mockito.times;
import org.opensearch.index.merge.MergedSegmentTransferTracker;
            indicesService,
            shardStateAction,
import static org.hamcrest.Matchers.sameInstance;
        return new RemoteStorePublishMergedSegmentAction(
            clusterService.getSettings(),
            shardId,
        AllocationId allocationId = mock(AllocationId.class);
            Settings.EMPTY,
                1111,
                Level.WARN,
            threadPool,
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
        final IndexShard indexShard = mock(IndexShard.class);
        final PlainActionFuture<TransportReplicationAction.ReplicaResult> listener = PlainActionFuture.newFuture();
                    .build()
        final IndicesService indicesService = mock(IndicesService.class);
            Collections.emptyMap(),
        );
            mockTargetService
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.cluster.action.shard.ShardStateAction;
 */
import org.opensearch.threadpool.ThreadPool;
            threadPool,
        );
        super.setUp();
import java.util.Collections;
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        final RemoteStorePublishMergedSegmentAction action = new RemoteStorePublishMergedSegmentAction(
        when(indexShard.recoveryState()).thenReturn(recoveryState);
            Settings.EMPTY,
        when(indexShard.indexSettings()).thenReturn(
            shardId,
import org.opensearch.core.action.ActionListener;
    @Override
            new MockLogAppender.SeenEventExpectation(
            shardStateAction,
            threadPool,
        final IndexService indexService = mock(IndexService.class);
            Loggers.removeAppender(LogManager.getLogger(RemoteStorePublishMergedSegmentAction.class), mockAppender);
import org.opensearch.action.support.ActionFilters;
        final int id = randomIntBetween(0, 4);
            latch.countDown();
            new MergedSegmentCheckpoint(indexShard.shardId(), 1, 1, 1111, Codec.getDefault().getName(), Collections.emptyMap(), "_1"),
    }
            action.shardOperationOnReplica(request, indexShard, listener);
import org.opensearch.core.index.shard.ShardId;
        when(allocationId.getId()).thenReturn("1");
            action.publish(indexShard, checkpoint);
import org.opensearch.test.MockLogAppender;
        verify(mockTargetService, times(0)).onNewMergedSegmentCheckpoint(checkpoint, indexShard);
            1111,
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
        final RemoteStoreMergedSegmentCheckpoint checkpoint = createCheckpoint(indexShard);
        AllocationId allocationId = mock(AllocationId.class);
            ),
        action.publish(indexShard, checkpoint);
        final SegmentReplicationTargetService mockTargetService = mock(SegmentReplicationTargetService.class);
        final IndicesService indicesService = mock(IndicesService.class);
        when(indicesService.indexServiceSafe(index)).thenReturn(indexService);
            mockAppender.close();
        when(shardRouting.allocationId()).thenReturn(allocationId);
                "_1"
    @Override
