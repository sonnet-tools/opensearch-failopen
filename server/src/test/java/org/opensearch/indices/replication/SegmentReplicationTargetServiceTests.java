            ((SegmentReplicationTargetService.SegmentReplicationListener) i.getArgument(3)).onReplicationDone(state);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                }
            initialCheckpoint.getSegmentInfosVersion() + 1,
     * and trigger another round so the replica eventually catches up. Here the first round finalizes without advancing
        // start replication is not invoked with aheadCheckpoint
import java.util.List;
import static org.mockito.Mockito.spy;
            indicesService,
                ReplicationCheckpoint checkpoint,
        doNothing().when(serviceSpy).updateVisibleCheckpoint(anyLong(), any());
                source,
        sut.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);
     * here we are starting a new shard in PrimaryMode and testing that we don't process a checkpoint on shard when it is in PrimaryMode.
        doReturn(true).when(serviceSpy).processLatestReceivedCheckpoint(any(), any(), anyBoolean());
        SegmentReplicationTargetService spy = spy(sut);
        IndexShard shard = newStartedShard(false, settings);
                ReplicationCheckpoint checkpoint,
                "mock"
    }
                @Override
        );
            new SegmentReplicationTarget(
        when(mockRoutingTable.shardRoutingTable(any())).thenReturn(primaryShard.getReplicationGroup().getRoutingTable());
    public void testShardAlreadyReplicating_HigherPrimaryTermReceived() throws InterruptedException {
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
                // simulate listener resolving, but only after we have issued a cancel from beforeIndexShardClosed .
                Assert.fail("Should not be called");
                }
    private ReplicationCheckpoint newPrimaryCheckpoint;
            initialCheckpoint.getSegmentsGen(),
import java.util.function.BiConsumer;
                BiConsumer<String, Long> fileProgressTracker,
import org.opensearch.cluster.ClusterName;
    public void testsSuccessfulMergeSegmentReplication_listenerCompletes() throws InterruptedException {
        spy.onNewCheckpoint(aheadCheckpoint, replicaShard);
            null,
    }
    }
import java.util.Set;
            0L,
            }
    public void testProcessLatestCheckpointIfCheckpointAhead() {
import org.opensearch.threadpool.TestThreadPool;
            )
            0L,
import org.opensearch.index.engine.NRTReplicationEngineFactory;
                        replicationCompleteLatch.countDown();
                SegmentReplicationTargetService.Actions.FORCE_SYNC,
    public void testTargetCancelledBeforeStartInvoked() {
                @Override
                        Assert.fail("Should not succeed");
import org.opensearch.indices.replication.common.ReplicationCollection;
        doThrow(exception).when(spyReplicaShard).finalizeReplication(any(CatalogSnapshot.class));
    private ReplicationCheckpoint aheadCheckpoint;
            }
        // prevent shard failure to avoid test setup assertion
        ClusterState newState = ClusterState.builder(ClusterName.DEFAULT)
            primaryShard.getLatestReplicationCheckpoint(),
        testThreadPool = new TestThreadPool("test", Settings.EMPTY);
        replicaShard = newShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
import org.opensearch.indices.recovery.RecoverySettings;
import java.util.Collections;
import static org.mockito.Mockito.never;
                new SegmentReplicationTargetService.SegmentReplicationListener() {
        );
        when(indicesService.getShardOrNull(forceSyncRequest.getShardId())).thenReturn(replicaShard);
import org.opensearch.ExceptionsHelper;
     * the replica's checkpoint (stale sync); the second round advances it, after which no further round is triggered.
        // Two rounds: the initial stale round plus the retriggered catch-up round.
        assertEquals(TransportResponse.Empty.INSTANCE, response);
            clusterService,
    private TransportService transportService;
    public void testNewMergedSegmentCheckpointBehindCurrentCheckpoint() throws IOException {
        sut.startMergedSegmentReplication(
            @Override
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
            ) {
        latch.await();
/*
                long replicationId,
        // start replication. This adds the target to on-ongoing replication collection
}
        SegmentReplicationTargetService spy = spy(sut);
        doAnswer(i -> achieved.get()).when(spyReplicaShard).getLatestReplicationCheckpoint();
        verify(spy, times(0)).updateLatestReceivedCheckpoint(any(), any());
        // set up mocks on indicies & index service to return our replica's index & shard.
            localNode,
        latch.await(2, TimeUnit.SECONDS);
     * finalize against a stale metadata checkpoint returned by the primary, leaving the replica behind the checkpoint
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(ShardRoutingState.STARTED, targetRouting.state());
            return null;
        // skip post replication actions so we can assert execution counts. This will continue to process bc replica's pterm is not advanced
                }
        doReturn(mock(SegmentReplicationTarget.class)).when(service).startReplication(any(), any(), any());
        sut.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);
        super.tearDown();
import org.opensearch.indices.replication.common.ReplicationFailedException;
import org.opensearch.cluster.node.DiscoveryNode;
        doReturn(List.of(targetSpy)).when(serviceSpy).getMergedSegmentReplicationTarget(any());
                @Override
                        ReplicationFailedException e,
            }
                mergedSegmentCheckpoint,
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
            @Override
        );
                    blockGetCheckpointMetadata.countDown();
                initialCheckpoint,
        final SegmentReplicationTarget target = spy(
import org.opensearch.cluster.metadata.IndexMetadata;
                public void onReplicationDone(SegmentReplicationState state) {
    public void testForceSegmentSyncHandlerWithFailure_AlreadyClosedException_swallowed() throws Exception {
    public void testStartReplicationRetriggersWhenReplicaSyncedToStaleCheckpoint() throws InterruptedException {
import org.opensearch.transport.TransportService;
        serviceSpy.onNewCheckpoint(newPrimaryCheckpoint, replicaShard);
        verify(service, times(0)).startReplication(eq(replicaShard), eq(checkpoint), any());
            new SegmentReplicationTargetService.SegmentReplicationListener() {
        when(indicesService.getShardOrNull(forceSyncRequest.getShardId())).thenReturn(spyReplicaShard);
    public void testShardAlreadyReplicating() throws InterruptedException {
        MergedSegmentCheckpoint mergedSegmentCheckpoint = mockMergedSegmentCheckpoint(checkpoint);
import java.util.concurrent.atomic.AtomicInteger;
        targetService.beforeIndexShardClosed(shard.shardId(), shard, shard.indexSettings().getSettings());
                mock(SegmentReplicationTargetService.SegmentReplicationListener.class)
        when(indexService.index()).thenReturn(replicaShard.routingEntry().index());
        // first (stale) round. The second round catches up, so the done-handler does not retrigger again.
                ReplicationCheckpoint checkpoint,
            UUID.randomUUID().toString()
import org.opensearch.core.transport.TransportResponse;
    public void testMergedSegmentReplicating_MergedSegmentAlreadyExist() throws IOException {
        transportService = transport.createTransportService(
        SegmentReplicationSource source = new TestReplicationSource() {
            threadPool,
import org.opensearch.cluster.routing.UnassignedInfo;
        spy.onNewMergedSegmentCheckpoint(aheadCheckpoint, spyShard);
            ActionListener<CheckpointInfoResponse> listener;
                IndexShard indexShard,
                        ReplicationFailedException e,
        doNothing().when(spy).updateVisibleCheckpoint(eq(0L), any());
        assertEquals(0, latch.getCount());
                long replicationId,
        latch.await(2, TimeUnit.SECONDS);
import java.util.UUID;
        assertEquals(targetNodeId, targetRouting.currentNodeId());
            public void getSegmentFiles(
                BiConsumer<String, Long> fileProgressTracker,
        // post replication.
            }
                Assert.fail("Unreachable");
import org.opensearch.cluster.ClusterChangedEvent;
            new MergedSegmentReplicationTarget(
        ReplicationCheckpoint oldCheckpoint = new ReplicationCheckpoint(
        SegmentReplicationTargetService spy = spy(sut);
                listener.onFailure(exception);
                    public void onReplicationDone(SegmentReplicationState state) {
        };
        );
        verify(spy, times(1)).processLatestReceivedCheckpoint(any(), any());
                }
            }
    }
import static org.mockito.Mockito.doNothing;
                        SegmentReplicationState state,
                replicaShard,
            new SegmentReplicationTarget(
                BiConsumer<String, Long> fileProgressTracker,
        );
        transportService.submitRequest(
        );
        latch.await(2, TimeUnit.SECONDS);
    public void testReplicationFails() throws InterruptedException {
import org.opensearch.core.action.ActionListener;
                checkpoint,
    public void testForceSync_ShardDoesNotExist() {
        verify(spy, times(0)).startReplication(any(), any(), any());
        when(indicesService.iterator()).thenReturn(Set.of(indexService).iterator());
    }
        spy.clusterChanged(new ClusterChangedEvent("ignored", oldState, newState));
                replicationCheckpoint.getSegmentInfosVersion(),
import static org.mockito.Mockito.doReturn;
            mock(TransportService.class),
    }
                    Assert.fail();
import static org.mockito.Mockito.atLeastOnce;
                    assertEquals(expectedError, e.getCause());
                }
        ForceSyncRequest forceSyncRequest = new ForceSyncRequest(1L, 1L, replicaShard.shardId());
import java.util.concurrent.TimeUnit;
import org.opensearch.common.settings.ClusterSettings;
            new SegmentReplicationTargetService.SegmentReplicationListener() {
import org.opensearch.cluster.service.ClusterService;
        // prevent shard failure to avoid test setup assertion
import java.util.concurrent.atomic.AtomicReference;
        latch.await(2, TimeUnit.SECONDS);
                replicaShard,
    }
                final RuntimeException exception = new CancellableThreads.ExecutionCancelledException("retryable action was cancelled");
        // Start first round of segment replication.
            mock(SegmentReplicationSource.class),
            sourceFactory,
import org.opensearch.test.transport.CapturingTransport;
import org.opensearch.cluster.node.DiscoveryNodes;
        doNothing().when(spy).updateVisibleCheckpoint(eq(0L), any());
                            new CheckpointInfoResponse(copyState.getCheckpoint(), copyState.getMetadataMap(), copyState.getInfosBytes())
                ReplicationCheckpoint checkpoint,
        IndexShard spyReplicaShard = spy(replicaShard);
        spy.startReplication(target);
            ) {
            if (rounds.incrementAndGet() >= 2) {
            public void getCheckpointMetadata(
        doThrow(exception).when(spyReplicaShard).finalizeReplication(any(CatalogSnapshot.class));
        SegmentReplicationSource source = new TestReplicationSource() {
            .build();
            ) {
import org.opensearch.cluster.routing.ShardRouting;
        verify(spy, times(0)).startReplication(
        ReplicationCheckpoint checkpoint = replicaShard.getLatestReplicationCheckpoint();
                        listener.onResponse(
        continueGetCheckpointMetadata.countDown();
                new ReplicationFailedException(replicaShard, null),
        when(indexService.getIndexSettings()).thenReturn(replicaShard.indexSettings());
        verify(serviceSpy, times(1)).startMergedSegmentReplication(eq(replicaShard), any(), any());
            latch.countDown();
    private SegmentReplicationState state;
    }
    }
                source,
        verify(spy, (never())).updateVisibleCheckpoint(eq(0L), eq(replicaShard));
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
    public void testStartReplicationListenerSuccess() throws InterruptedException {
        );
        spy.startReplication(
            localNode,
        spy.afterIndexShardStarted(spyReplicaShard);
            eq(aheadCheckpoint),
        };
import org.apache.lucene.store.AlreadyClosedException;
        verify(spy, times(0)).startReplication(any(), any(), any());
            1,
        doAnswer(i -> {
            public void getCheckpointMetadata(
                    }
        IndexShard primaryShard = newStartedShard(true);
            ) {
                    // failures leave state object in last entered stage.
        verifyNoInteractions(ongoingReplications);
                ActionListener<CheckpointInfoResponse> listener
                Assert.fail("Unreachable");
        verify(spy, times(0)).startReplication(any(), any(), any());
        blockGetCheckpointMetadata.await(5, TimeUnit.MINUTES);
import org.opensearch.cluster.routing.IndexRoutingTable;
        // new merged segment
        final SegmentReplicationTarget targetSpy = spy(
        // ongoing replication is not cancelled and new one does not start.
                ReplicationCheckpoint checkpoint,
import static org.mockito.Mockito.mock;
import org.opensearch.transport.EmptyTransportResponseHandler;
                ActionListener<GetSegmentFilesResponse> listener
        initialCheckpoint = primaryShard.getLatestReplicationCheckpoint();
        // the done-handler observes the replica has caught up and does not retrigger another round.
        final ReplicationCollection<SegmentReplicationTarget> ongoingReplications = mock(ReplicationCollection.class);
    private SegmentReplicationTargetService sut;
        when(indicesService.getShardOrNull(forceSyncRequest.getShardId())).thenReturn(null);
                listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
        sut = prepareForReplication(primaryShard, replicaShard, transportService, indicesService, clusterService);
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
            checkpoint.getSegmentInfosVersion(),
            eq(replicaShard),
                }
        spy.onNewMergedSegmentCheckpoint(oldCheckpoint, replicaShard);
import org.opensearch.indices.replication.common.ReplicationType;
        state = new SegmentReplicationState(
        doReturn(List.of(targetSpy)).when(serviceSpy).getMergedSegmentReplicationTarget(any());
    private IndicesService indicesService;
                    }
            forceSyncRequest,
        // Verify that checkpoint is not processed as shard is in PrimaryMode.
        spy.afterIndexShardStarted(replicaShard);
        final String targetNodeId = "targetNodeId";
import org.opensearch.transport.TransportRequestOptions;
                    assertEquals(SegmentReplicationState.Stage.INIT, state.getStage());
            forceSyncRequest,
                ReplicationCheckpoint checkpoint,
            SegmentReplicationTargetService.Actions.FORCE_SYNC,
        final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            .routingTable(
                @Override
            return null;
        // Create a spy of Target Service so that we can verify invocation of startReplication call with specific checkpoint on it.
        closeShards(primaryShard, replicaShard);
            0L,
                List<StoreFileMetadata> filesToFetch,
                    public void onReplicationFailure(
                ReplicationCheckpoint checkpoint,
     * known checkpoint - by comparing against the replica's achieved checkpoint, not the checkpoint the round targeted -
            .build();
            )
            ) {}
        sut.startReplication(
        final IndicesService indicesService = mock(IndicesService.class);
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
        );
                        );
        spy.onNewCheckpoint(replicaShard.getLatestReplicationCheckpoint(), replicaShard);
                long replicationId,
    }
        SegmentReplicationTargetService spy = spy(sut);
        doReturn(true).when(serviceSpy).processLatestReceivedCheckpoint(any(), any());
        CountDownLatch latch = new CountDownLatch(1);
                Assert.fail("Unreachable");
                ReplicationCheckpoint checkpoint,
        // spy so we can verify process is invoked
                @Override
import org.opensearch.index.shard.IndexShard;
        spy.afterIndexShardStarted(indexShard);
        return new MergedSegmentCheckpoint(
                @Override
    }
    }
            primaryShard.getDefaultCodecName()
    public void testBeforeIndexShardClosed_DoesNothingForDocRepIndex() throws IOException {
        CountDownLatch replicationCompleteLatch = new CountDownLatch(1);
            )
        final MergedSegmentReplicationTarget targetSpy = spy(
                @Override
                List<StoreFileMetadata> filesToFetch,
            TransportRequestOptions.builder().withTimeout(TRANSPORT_TIMEOUT).build(),
            0L,
        allowShardFailures();
                    throw new RuntimeException(e);
        );
                    public void onReplicationFailure(
            new ReplicationLuceneIndex(),
        SegmentReplicationTargetService serviceSpy = spy(sut);
        CountDownLatch latch = new CountDownLatch(2);
        verify(spy, times(0)).processLatestReceivedCheckpoint(eq(replicaShard), any());
                replicaShard,
            new SegmentReplicationTargetService.SegmentReplicationListener() {
import org.opensearch.cluster.routing.RecoverySource;
                    // failures leave state object in last entered stage.
    public void testStartReplicationListenerFailure() throws InterruptedException {
        AlreadyClosedException exception = new AlreadyClosedException("shard closed");
                long replicationId,
        TransportResponse response = transportService.submitRequest(
            public void getSegmentFiles(
                List<StoreFileMetadata> filesToFetch,
            ) {
        SegmentReplicationTargetService spy = spy(sut);
    private ReplicationCheckpoint initialCheckpoint;
import static org.mockito.Mockito.times;
        // Create a Mockito spy of target to stub response of few method calls.
                replicationCheckpoint.getShardId(),
        }).when(spy).startReplication(any(), any(), any());
import static org.mockito.ArgumentMatchers.any;
        closeShards(shard);
                    }
            transportService.submitRequest(
                IndexShard indexShard,
        doReturn(mock(SegmentReplicationTarget.class)).when(service).startReplication(any(), any(), anyBoolean(), any());
                long replicationId,
            initialCheckpoint.getShardId(),
            checkpoint.getMetadataMap(),
        when(clusterService.state()).thenReturn(clusterState);
        final OpenSearchException expectedError = new OpenSearchException("Fail");
import static org.mockito.Mockito.eq;
        doAnswer(i -> {
    }
            primaryShard.shardId(),
            new MergedSegmentReplicationTarget(
    public void testOnNewCheckpointInvokedOnClosedShardDoesNothing() throws IOException {
            "",
        super.setUp();
    private static final long TRANSPORT_TIMEOUT = 30000;// 30sec
                localNode,
                long replicationId,
            initialCheckpoint.getPrimaryTerm() + 1,
                updatedCheckpoint,
        sut.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);
            TransportRequestOptions.builder().withTimeout(TRANSPORT_TIMEOUT).build(),
                mock(SegmentReplicationTargetService.SegmentReplicationListener.class)
        SegmentReplicationTargetService spy = spy(sut);
            primaryShard.getLatestReplicationCheckpoint(),
    private MergedSegmentCheckpoint mockMergedSegmentCheckpoint(ReplicationCheckpoint checkpoint) {
    public void setUp() throws Exception {
        final SegmentReplicationTarget target = new SegmentReplicationTarget(
                        boolean sendShardFailure
            0L,
            TransportRequestOptions.builder().withTimeout(TRANSPORT_TIMEOUT).build(),
                    Assert.fail("Test should succeed");
            sourceFactory,
        };
        );
                    @Override
                ReplicationCheckpoint checkpoint,
                public void onReplicationDone(SegmentReplicationState state) {
                public void onReplicationDone(SegmentReplicationState state) {
     */
            EmptyTransportResponseHandler.INSTANCE_SAME
                    .add(IndexRoutingTable.builder(primaryShard.shardId().getIndex()).addShard(targetRouting).build())
            Collections.emptySet(),
        verifyNoInteractions(ongoingReplications);
import org.opensearch.test.junit.annotations.TestLogging;
        spy.onNewMergedSegmentCheckpoint(checkpoint, shard);
        SegmentReplicationTargetService spy = spy(sut);
                    assertEquals(cancelReason, e.getMessage());
        assertEquals(0, latch.getCount());
    }
                replicationCheckpoint.getPrimaryTerm(),
                    ) {
                replicaShard,
            SegmentReplicationTargetService.Actions.FORCE_SYNC,
        final ReplicationCheckpoint updatedCheckpoint = new ReplicationCheckpoint(
        verify(service, times(1)).startReplication(eq(replicaShard), eq(aheadCheckpoint), anyBoolean(), any());
        // new checkpoint arrives with higher pterm.
            checkpoint.getShardId(),
        ForceSyncRequest forceSyncRequest = new ForceSyncRequest(1L, 1L, replicaShard.shardId());
            initialCheckpoint.getPrimaryTerm(),
    public void tearDown() throws Exception {
            @Override
        // Model the replica's achieved checkpoint. A successful round advances it to the checkpoint it targeted, so
        SegmentReplicationTargetService spy = spy(sut);
    }
            new MergedSegmentCheckpoint(
        when(clusterState.routingTable()).thenReturn(mockRoutingTable);
            ongoingReplications
import org.opensearch.cluster.ClusterState;
    public void testForceSegmentSyncHandler() throws Exception {
import org.opensearch.index.IndexService;
                try {
                listener.onFailure(expectedError);
        SegmentReplicationTargetService service = spy(sut);
                ActionListener<CheckpointInfoResponse> listener
        spy.onNewCheckpoint(aheadCheckpoint, replicaShard);
                // set the listener, we will only fail it once we cancel the source.
import static org.mockito.ArgumentMatchers.anyLong;
                ActionListener<CheckpointInfoResponse> listener
    }
            boundAddress -> localNode,
        Exception finalizeException = expectThrows(Exception.class, () -> {
        spy.onNewCheckpoint(aheadCheckpoint, spyShard);
            @Override
import static org.mockito.Mockito.verify;
            replicaShard.getLatestReplicationCheckpoint().getCodec()
        doReturn(mock(SegmentReplicationTarget.class)).when(service).startReplication(any(), any(), any());
        AtomicReference<ReplicationCheckpoint> achieved = new AtomicReference<>(replicaShard.getLatestReplicationCheckpoint());
                IndexShard indexShard,
        String primaryCodec = primaryShard.getLatestReplicationCheckpoint().getCodec();
                    latch.countDown();
            ((SegmentReplicationTargetService.SegmentReplicationListener) i.getArgument(3)).onReplicationDone(state);
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
        AtomicInteger rounds = new AtomicInteger(0);
            public void getSegmentFiles(
                replicationCheckpoint.getCodec(),
                    public void onReplicationDone(SegmentReplicationState state) {
import org.opensearch.indices.recovery.ForceSyncRequest;
        verify(spy, times(1)).processLatestReceivedCheckpoint(eq(replicaShard), any());
        // Starting a new shard in PrimaryMode.
        assertTrue(replicaShard.shouldProcessCheckpoint(aheadCheckpoint));
    public void testDoNotProcessLatestCheckpointIfCheckpointIsBehind() {
        IndexShard shard = newStartedShard(false, settings);
    }
            EmptyTransportResponseHandler.INSTANCE_SAME
        ShardRouting initialRouting = primaryShard.routingEntry().relocate(targetNodeId, 0L);
        target.cancel(cancelReason);
        );
        ).txGet();
        SegmentReplicationTargetService spy = spy(sut);
                BiConsumer<String, Long> fileProgressTracker,
        ForceSyncRequest forceSyncRequest = new ForceSyncRequest(1L, 1L, new ShardId("no", "", 0));
                } catch (InterruptedException | IOException e) {
                ActionListener<CheckpointInfoResponse> listener
        CountDownLatch blockGetCheckpointMetadata = new CountDownLatch(1);
    }
        serviceSpy.startReplication(targetSpy);
import static org.mockito.Mockito.when;
 */
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
    private IndexShard replicaShard;
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
import org.opensearch.cluster.routing.ShardRoutingState;
                forceSyncRequest,
            new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT)
        );
            replicaShard,
            primaryCodec
                ReplicationCheckpoint checkpoint,
        latch.await(2, TimeUnit.SECONDS);
        closeShards(primaryShard);
        ).txGet();
    public void testMergedSegmentReplicating_HigherPrimaryTermReceived() throws IOException {
        );
        checkpoint = new ReplicationCheckpoint(
                }
                RoutingTable.builder()
                ActionListener<GetSegmentFilesResponse> listener
        SegmentReplicationTargetService serviceSpy = spy(sut);
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
 * compatible open source license.
        final MergedSegmentReplicationTarget targetSpy = spy(
        verify(spy, times(2)).startReplication(eq(spyReplicaShard), any(), anyBoolean(), any());
            ) {}
            )
        }).when(spy).startReplication(any(), any(), anyBoolean(), any());
        replicationCompleteLatch.await(5, TimeUnit.MINUTES);
        assertNotNull(ExceptionsHelper.unwrap(finalizeException, IOException.class));
import org.opensearch.indices.IndicesService;
        AtomicReference<ReplicationCheckpoint> achieved = new AtomicReference<>(replicaShard.getLatestReplicationCheckpoint());
        verify(spy, (atLeastOnce())).updateVisibleCheckpoint(eq(0L), eq(spyReplicaShard));
            replicaShard.shardId(),
                    Assert.fail("Test should succeed");
import static org.mockito.ArgumentMatchers.anyBoolean;
                }
    }
            replicaShard.getOperationPrimaryTerm() - 1,
        SegmentReplicationSource source = new TestReplicationSource() {
            .routingTable(
            clusterService,
        );
    /**
        newPrimaryCheckpoint = new ReplicationCheckpoint(
                source,
        spy.onNewCheckpoint(checkpoint, replicaShard);
        transportService.acceptIncomingRequests();
            0L,
            RecoverySource.PeerRecoverySource.INSTANCE,
            @Override
        transportService.submitRequest(
                    logger.error("Unexpected error", e);
                    continueGetCheckpointMetadata.await();
        RoutingTable mockRoutingTable = mock(RoutingTable.class);
        ClusterState oldState = ClusterState.builder(ClusterName.DEFAULT)
        };
            }
    }
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
            primaryCodec
        );
    }
        // wait until we are at getCheckpointMetadata stage
        );
            ) {
                // do not resolve this listener yet, wait for cancel to hit.
            ).txGet();
            @Override
        IndexShard spyReplicaShard = spy(replicaShard);
        IndexShard spyShard = spy(primaryShard);
import java.util.concurrent.CountDownLatch;
        });
        // Only the initial entry from afterIndexShardStarted; the done-handler must not retrigger since the replica
            ) {
 * this file be licensed under the Apache-2.0 license or a
            initialCheckpoint.getSegmentInfosVersion() + 1,
    }
        IndexShard spyReplicaShard = spy(replicaShard);
            @Override
                state,
            forceSyncRequest,
import org.opensearch.common.settings.Settings;
                mock(SegmentReplicationTargetService.SegmentReplicationListener.class)
        assertTrue("expected the replica to be retriggered until it caught up", latch.await(5, TimeUnit.SECONDS));
            EmptyTransportResponseHandler.INSTANCE_SAME
                RoutingTable.builder()
        assertEquals(0, latch.getCount());
        CountDownLatch continueGetCheckpointMetadata = new CountDownLatch(1);
                ActionListener<GetSegmentFilesResponse> listener
            new SegmentReplicationTargetService.SegmentReplicationListener() {
            checkpoint.getPrimaryTerm(),
            }
                    assertEquals(SegmentReplicationState.Stage.GET_CHECKPOINT_INFO, state.getStage());
        serviceSpy.onNewMergedSegmentCheckpoint(mockMergedSegmentCheckpoint(newPrimaryCheckpoint), replicaShard);
        when(indicesService.getShardOrNull(forceSyncRequest.getShardId())).thenReturn(spyReplicaShard);
        verify(serviceSpy, times(1)).startMergedSegmentReplication(eq(replicaShard), any(), any());
        verify(spy, times(0)).startMergedSegmentReplication(any(), any(), any());
        verify(spy, times(0)).startMergedSegmentReplication(any(), any(), any());
    public void testAfterIndexShardStartedDoesNothingForDocrepIndex() throws IOException {
            SegmentReplicationTargetService.Actions.FORCE_SYNC,
        ReplicationCheckpoint replicationCheckpoint = primaryShard.getLatestReplicationCheckpoint();
        // try and insert a new target directly - it should fail immediately and alert listener
        CountDownLatch latch = new CountDownLatch(1);
            testThreadPool,
                }
        recoverReplica(replicaShard, primaryShard, true, getReplicationFunc(replicaShard));
                    }
        final String cancelReason = "test";
                    @Override
        // wait until we get to getCheckpoint step.
        // aheadCheckpoint is of same pterm but higher version
            source,
                        SegmentReplicationState state,
        // Start second round of segment replication through onNewCheckpoint, this should fail to start as first round is still in-progress
                    try (final CopyState copyState = new CopyState(primaryShard)) {
            initialCheckpoint.getSegmentsGen(),
                BiConsumer<String, Long> fileProgressTracker,
        SegmentReplicationTargetService spy = spy(sut);
                    Assert.fail();
    public void testForceSegmentSyncHandlerWithFailure() throws Exception {
        spy.afterIndexShardStarted(replicaShard);
        SegmentReplicationTargetService spy = spy(sut);
                    .build()
        service.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);
        service.processLatestReceivedCheckpoint(replicaShard, null);
            checkpoint.getCodec(),
    @Override
        CountDownLatch latch = new CountDownLatch(1);
            initialCheckpoint.getSegmentsGen(),
        verify(spy, org.mockito.Mockito.atLeast(2)).processLatestReceivedCheckpoint(any(), any());
            achieved.set(i.getArgument(1));
        }).when(spy).startReplication(any(), any(), anyBoolean(), any());
    public void testAfterIndexShardStartedProcessesLatestReceivedCheckpoint() {
            ),
        ForceSyncRequest forceSyncRequest = new ForceSyncRequest(1L, 1L, replicaShard.shardId());
                achieved.set(i.getArgument(1));
        // create old & new cluster states
        IndexShard spyReplicaShard = spy(replicaShard);
            public void cancel() {
            replicaShard.shardId(),
                    ) {
        when(indexService.iterator()).thenReturn(Set.of(replicaShard).iterator());
                replicationCheckpoint.getLength(),
        doAnswer(i -> achieved.get()).when(spyReplicaShard).getLatestReplicationCheckpoint();
        );
                new SegmentReplicationTargetService.SegmentReplicationListener() {
    private ReplicationCheckpoint checkpoint;
        verify(spy, times(1)).processLatestReceivedCheckpoint(eq(replicaShard), any());
                aheadCheckpoint,
            threadPool,
        SegmentReplicationTargetService spy = spy(sut);
                latch.countDown();
        // in this case shard is already replicating and we receive an ahead checkpoint with same pterm.
            public void getCheckpointMetadata(
        indicesService = mock(IndicesService.class);
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
            )
    public void testNewCheckpointBehindCurrentCheckpoint() {
import org.opensearch.common.util.CancellableThreads;
        localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
    }
        closeShards(replicaShard);
import org.opensearch.core.index.shard.ShardId;
     */
            ongoingReplications
            primaryShard.getLatestReplicationCheckpoint(),
    public void testShardRoutingChanged_DoesNothingForDocRepIndex() throws IOException {
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
    public void testShardNotStarted() throws IOException {
        ShardRouting targetRouting = ShardRouting.newUnassigned(
        serviceSpy.onNewMergedSegmentCheckpoint(mockMergedSegmentCheckpoint(newPrimaryCheckpoint), replicaShard);
        // caught up to the targeted checkpoint.
            ) {
                }
                source,
            public void getSegmentFiles(
                long replicationId,
        CapturingTransport transport = new CapturingTransport();
                    @Override
            }
            replicaShard,
            @Override
            initialCheckpoint.getPrimaryTerm(),
        );
        final SegmentReplicationTargetService targetService = new SegmentReplicationTargetService(
        SegmentReplicationSource source = new TestReplicationSource() {
        verify(serviceSpy, times(0)).startMergedSegmentReplication(eq(replicaShard), any(), any());
import org.opensearch.indices.replication.common.CopyState;
                }
                List<StoreFileMetadata> filesToFetch,
                    latch.countDown();
            @Override
        ThreadPool.terminate(testThreadPool, 30, TimeUnit.SECONDS);
            )
        ClusterState clusterState = mock(ClusterState.class);
        spy.onNewMergedSegmentCheckpoint(aheadCheckpoint, replicaShard);
        verify(spy, times(0)).processLatestReceivedCheckpoint(eq(replicaShard), any());
import org.opensearch.threadpool.ThreadPool;
        IOException exception = new IOException("dummy failure");
import org.opensearch.cluster.routing.RoutingTable;
            localNode,
            replicaShard,
import java.io.IOException;
 *
        final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            ((SegmentReplicationTargetService.SegmentReplicationListener) i.getArgument(2)).onReplicationFailure(
        SegmentReplicationTargetService serviceSpy = spy(sut);
        // processLatestReceivedCheckpoint: once from afterIndexShardStarted and once from the done-handler after the
                    assertEquals(SegmentReplicationState.Stage.DONE, state.getStage());
        CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        final ReplicationCollection<SegmentReplicationTarget> ongoingReplications = mock(ReplicationCollection.class);
    private IndexShard primaryShard;
                IndexShard indexShard,
            @Override
import org.opensearch.index.store.StoreFileMetadata;
     * Regression test for the scenario described in #20550 / #20551. After a failed round is retried, the retry may
            )
                ActionListener<GetSegmentFilesResponse> listener
    public void testRejectCheckpointOnShardPrimaryMode() throws IOException {
                TransportRequestOptions.builder().withTimeout(TRANSPORT_TIMEOUT).build(),
 * SPDX-License-Identifier: Apache-2.0
            replicaShard.routingEntry(),
        final SegmentReplicationTarget target = new SegmentReplicationTarget(
        spy.afterIndexShardStarted(spyReplicaShard);
        primaryShard = newStartedShard(true, settings);
import static org.mockito.Mockito.verifyNoInteractions;
            }
                @Override
    }
    public void testProcessCheckpointOnClusterStateUpdate() {
        service.updateLatestReceivedCheckpoint(checkpoint, replicaShard);
            latch.countDown();
            true,
        final ClusterService clusterService = mock(ClusterService.class);
            public void getCheckpointMetadata(
        verify(targetSpy, times(1)).cancel("Cancelling stuck merged segment target after new primary");
    }
        when(clusterState.nodes()).thenReturn(DiscoveryNodes.builder().add(localNode).build());
        verify(targetSpy, times(1)).cancel("Cancelling stuck target after new primary");
        verify(spy, times(1)).updateVisibleCheckpoint(NO_OPS_PERFORMED, replicaShard);
            }
            // First round finalizes against a stale checkpoint and does NOT advance the replica. The second
        verify(spy, times(0)).startReplication(any(), any(), any());
    }
            initialCheckpoint.getShardId(),
    /**
    public void testsSuccessfulReplication_listenerCompletes() throws InterruptedException {
        doNothing().when(spyReplicaShard).failShard(eq("replication failure"), any());
            new SegmentReplicationTarget(
        sut.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);
                ActionListener<GetSegmentFilesResponse> listener
            }
                ActionListener<CheckpointInfoResponse> listener
        CountDownLatch latch = new CountDownLatch(1);
package org.opensearch.indices.replication;
                        Assert.fail("Replication should not fail");
        final SegmentReplicationTargetService spy = spy(sut);
import org.opensearch.Version;
                        assertEquals("Shard " + replicaShard.shardId() + " is already replicating", e.getMessage());
                    latch.countDown();
        spy.onNewCheckpoint(checkpoint, shard);
                public void onReplicationDone(SegmentReplicationState state) {
            // (retriggered) round successfully advances the replica to the checkpoint it was asked to sync to.
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        testThreadPool = null;
        sut.startReplication(target);
            indicesService,
    public void testAlreadyOnNewCheckpoint() {
            NoopTracer.INSTANCE
                    }
                    assertEquals(SegmentReplicationState.Stage.DONE, state.getStage());
            return null;
            any(SegmentReplicationTargetService.SegmentReplicationListener.class)
                    @Override
                long replicationId,
                source,
        doAnswer(i -> {
        SegmentReplicationTargetService service = spy(sut);
    @Override
            latch.countDown();
        // ensure the old target is cancelled. and new iteration kicks off.
    private TestThreadPool testThreadPool;
import org.opensearch.index.shard.IndexShardTestCase;
        verify(spy, times(0)).startReplication(any(), any(), any());
                        assertFalse(sendShardFailure);
        doNothing().when(spyReplicaShard).failShard(eq("replication failure"), any());
        Throwable nestedException = finalizeException.getCause().getCause();
        final IndicesService indicesService = mock(IndicesService.class);
        verify(spy, times(0)).updateLatestReceivedCheckpoint(any(), any());
    }
            replicaShard,
                    .add(IndexRoutingTable.builder(primaryShard.shardId().getIndex()).addShard(initialRouting).build())
                List<StoreFileMetadata> filesToFetch,
        IndexService indexService = mock(IndexService.class);
    }
                    logger.error("Unexpected error", e);
                long replicationId,
        final SegmentReplicationTargetService targetService = new SegmentReplicationTargetService(
            Settings.EMPTY,
            }
import org.opensearch.index.replication.TestReplicationSource;
import org.opensearch.OpenSearchException;
        doNothing().when(spy).onNewCheckpoint(any(), any());
                EmptyTransportResponseHandler.INSTANCE_SAME
                false
        // already exist
            new UnassignedInfo(UnassignedInfo.Reason.REINITIALIZED, "test")
        ClusterService clusterService = mock(ClusterService.class);
        aheadCheckpoint = new ReplicationCheckpoint(
        final ClusterService clusterService = mock(ClusterService.class);
        targetService.shardRoutingChanged(shard, shard.routingEntry(), primaryShard.routingEntry());
            }
        assertTrue(nestedException.getMessage().contains("dummy failure"));
                this.listener = listener;
import static org.mockito.Mockito.doThrow;
        };
        doNothing().when(spy).updateVisibleCheckpoint(eq(0L), any());
            public void getSegmentFiles(
        transportService.start();
        sut.startReplication(target);
        ).initialize(targetNodeId, initialRouting.allocationId().getId(), 0L).moveToStarted();
 * The OpenSearch Contributors require contributions made to
        closeShards(indexShard);
        final Settings settings = Settings.builder()
        );
                IndexShard indexShard,
            public void getCheckpointMetadata(
import org.junit.Assert;
        closeShards(shard);
        final IndexShard indexShard = newStartedShard();
public class SegmentReplicationTargetServiceTests extends IndexShardTestCase {
        IndexShard shard = newShard(false);
                        boolean sendShardFailure
                replicationCheckpoint.getMetadataMap(),
        verify(serviceSpy, times(1)).startReplication(eq(replicaShard), any(), anyBoolean(), any());
            mock(TransportService.class),
            initialCheckpoint.getSegmentInfosVersion() + 1,
        service.processLatestReceivedCheckpoint(replicaShard, null);
            initialCheckpoint.getShardId(),
        closeShards(shard);
    }
        ).txGet();
                long replicationId,
        );
        serviceSpy.onNewMergedSegmentCheckpoint(mergedSegmentCheckpoint, replicaShard);
    }
            .build();
        SegmentReplicationSource source = new TestReplicationSource() {
        // ensure the old target is cancelled. and new iteration kicks off.
import static org.mockito.Mockito.doAnswer;
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            );
            replicaShard.getLatestReplicationCheckpoint().getCodec()
    }
            .put("node.name", SegmentReplicationTargetServiceTests.class.getSimpleName())
     * it was asked to sync to. The done-handler must detect that the replica is still behind the primary's latest
            }
                replicaShard,
        assertEquals(ShardRoutingState.RELOCATING, initialRouting.state());
    private DiscoveryNode localNode;
            @Override
                    .build()
