                }
        doAnswer(i -> {
            mock(TransportService.class),
     * it was asked to sync to. The done-handler must detect that the replica is still behind the primary's latest
        // ongoing replication is not cancelled and new one does not start.
            return null;
import org.opensearch.core.action.ActionListener;  
        ClusterService clusterService = mock(ClusterService.class);
                ReplicationCheckpoint checkpoint,
        spy.onNewCheckpoint(aheadCheckpoint, spyShard);
        SegmentReplicationTargetService spy = spy(sut);  
import org.opensearch.threadpool.ThreadPool;
                        replicationCompleteLatch.countDown();  
            ((SegmentReplicationTargetService.SegmentReplicationListener) i.getArgument(2)).onReplicationFailure(
            threadPool,  
                    latch.countDown();
                        );  
import org.opensearch.cluster.node.DiscoveryNode;  
        spy.afterIndexShardStarted(replicaShard);
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
            new MergedSegmentCheckpoint(
        verify(service, times(0)).startReplication(eq(replicaShard), eq(checkpoint), any());
            }
import java.io.IOException;
                latch.countDown();  
            threadPool,  
    public void testAlreadyOnNewCheckpoint() {  
        closeShards(indexShard);
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
        verifyNoInteractions(ongoingReplications);  
import org.opensearch.indices.replication.checkpoint.MergedSegmentCheckpoint;
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.transport.TransportRequestOptions;  
        when(mockRoutingTable.shardRoutingTable(any())).thenReturn(primaryShard.getReplicationGroup().getRoutingTable());
                public void onReplicationDone(SegmentReplicationState state) {  
                long replicationId,  
                @Override  
        final ClusterService clusterService = mock(ClusterService.class);  
        closeShards(shard);
        spy.afterIndexShardStarted(replicaShard);  
import org.opensearch.indices.replication.common.ReplicationCollection;
                long replicationId,
                new ReplicationFailedException(replicaShard, null),
            }  
        verify(serviceSpy, times(0)).startMergedSegmentReplication(eq(replicaShard), any(), any());  
import static org.mockito.Mockito.spy;  
    public void testsSuccessfulReplication_listenerCompletes() throws InterruptedException {  
                    @Override
import static org.mockito.Mockito.when;
import org.opensearch.telemetry.tracing.noop.NoopTracer;  
        doReturn(mock(SegmentReplicationTarget.class)).when(service).startReplication(any(), any(), anyBoolean(), any());
                achieved.set(i.getArgument(1));
        // in this case shard is already replicating and we receive an ahead checkpoint with same pterm.  
            1,
            ongoingReplications  
    }
        ).initialize(targetNodeId, initialRouting.allocationId().getId(), 0L).moveToStarted();  
                        boolean sendShardFailure
            0L,
import org.opensearch.cluster.routing.IndexRoutingTable;
            testThreadPool,  
            sourceFactory,  
                    .build()
        // skip post replication actions so we can assert execution counts. This will continue to process bc replica's pterm is not advanced
import org.opensearch.transport.EmptyTransportResponseHandler;
            public void getSegmentFiles(
    public void testMergedSegmentReplicating_HigherPrimaryTermReceived() throws IOException {
        IndexShard spyShard = spy(primaryShard);  
        IndexShard spyReplicaShard = spy(replicaShard);
            .put("node.name", SegmentReplicationTargetServiceTests.class.getSimpleName())
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
            primaryCodec  
        verify(spy, times(0)).startReplication(any(), any(), any());  
                    .add(IndexRoutingTable.builder(primaryShard.shardId().getIndex()).addShard(initialRouting).build())  
        SegmentReplicationTargetService spy = spy(sut);
            )
    }
        verify(spy, (never())).updateVisibleCheckpoint(eq(0L), eq(replicaShard));
                    @Override  
                List<StoreFileMetadata> filesToFetch,
                }  
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
     * Regression test for the scenario described in #20550 / #20551. After a failed round is retried, the retry may  
                new SegmentReplicationTargetService.SegmentReplicationListener() {  
                ActionListener<CheckpointInfoResponse> listener
            new SegmentReplicationTarget(
            latch.countDown();
            public void getSegmentFiles(
    public void testStartReplicationListenerSuccess() throws InterruptedException {
    }
        targetService.shardRoutingChanged(shard, shard.routingEntry(), primaryShard.routingEntry());
            @Override
        verify(spy, times(0)).startMergedSegmentReplication(any(), any(), any());  
                }  
        service.processLatestReceivedCheckpoint(replicaShard, null);
        doReturn(List.of(targetSpy)).when(serviceSpy).getMergedSegmentReplicationTarget(any());  
        latch.await(2, TimeUnit.SECONDS);  
            @Override  
    public void testForceSync_ShardDoesNotExist() {
        when(indexService.getIndexSettings()).thenReturn(replicaShard.indexSettings());
            mock(SegmentReplicationSource.class),
    }
            }
            0L,
        final MergedSegmentReplicationTarget targetSpy = spy(
        sut.startReplication(target);  
        closeShards(replicaShard);  
        latch.await(2, TimeUnit.SECONDS);
            )
        IOException exception = new IOException("dummy failure");
                BiConsumer<String, Long> fileProgressTracker,
            primaryShard.getDefaultCodecName()
import org.opensearch.OpenSearchException;  
        assertEquals(targetNodeId, targetRouting.currentNodeId());
                state,  
        CountDownLatch latch = new CountDownLatch(1);
        SegmentReplicationTargetService spy = spy(sut);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.service.ClusterService;
                    latch.countDown();  
    public void testAfterIndexShardStartedDoesNothingForDocrepIndex() throws IOException {  
import java.util.concurrent.atomic.AtomicInteger;
        spy.onNewCheckpoint(aheadCheckpoint, replicaShard);
                ActionListener<GetSegmentFilesResponse> listener
        ForceSyncRequest forceSyncRequest = new ForceSyncRequest(1L, 1L, replicaShard.shardId());
        // start replication. This adds the target to on-ongoing replication collection
            UUID.randomUUID().toString()
                initialCheckpoint,
        final ClusterService clusterService = mock(ClusterService.class);  
        verify(spy, times(0)).startReplication(any(), any(), any());
        IndexService indexService = mock(IndexService.class);
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
                ActionListener<GetSegmentFilesResponse> listener
        verify(spy, times(1)).updateVisibleCheckpoint(NO_OPS_PERFORMED, replicaShard);
        sut.startMergedSegmentReplication(
import org.opensearch.core.transport.TransportResponse;
import java.util.concurrent.CountDownLatch;  
                    assertEquals(SegmentReplicationState.Stage.DONE, state.getStage());
        latch.await(2, TimeUnit.SECONDS);
        // processLatestReceivedCheckpoint: once from afterIndexShardStarted and once from the done-handler after the
                            new CheckpointInfoResponse(copyState.getCheckpoint(), copyState.getMetadataMap(), copyState.getInfosBytes())
    }  
    public void testShardRoutingChanged_DoesNothingForDocRepIndex() throws IOException {  
import org.opensearch.indices.IndicesService;
            checkpoint.getPrimaryTerm(),  
        serviceSpy.onNewMergedSegmentCheckpoint(mockMergedSegmentCheckpoint(newPrimaryCheckpoint), replicaShard);  
import static org.mockito.Mockito.verifyNoInteractions;  
        ForceSyncRequest forceSyncRequest = new ForceSyncRequest(1L, 1L, new ShardId("no", "", 0));  
        when(clusterState.nodes()).thenReturn(DiscoveryNodes.builder().add(localNode).build());  
    }  
            ) {
            ) {
                ActionListener<GetSegmentFilesResponse> listener
        IndexShard spyReplicaShard = spy(replicaShard);
            }  
        // prevent shard failure to avoid test setup assertion
            checkpoint.getSegmentInfosVersion(),
        final IndexShard indexShard = newStartedShard();
            replicaShard.getLatestReplicationCheckpoint().getCodec()
            primaryShard.getLatestReplicationCheckpoint(),
    public void testMergedSegmentReplicating_MergedSegmentAlreadyExist() throws IOException {
            indicesService,
        final SegmentReplicationTargetService spy = spy(sut);  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;  
                long replicationId,
        final ReplicationCollection<SegmentReplicationTarget> ongoingReplications = mock(ReplicationCollection.class);
                    @Override  
                        Assert.fail("Replication should not fail");  
     */  
        doReturn(mock(SegmentReplicationTarget.class)).when(service).startReplication(any(), any(), any());
        // Only the initial entry from afterIndexShardStarted; the done-handler must not retrigger since the replica  
        sut.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);
            public void getSegmentFiles(
        doAnswer(i -> {  
            public void getCheckpointMetadata(
        doNothing().when(spy).updateVisibleCheckpoint(eq(0L), any());
import java.util.UUID;
    public void testStartReplicationRetriggersWhenReplicaSyncedToStaleCheckpoint() throws InterruptedException {
    public void testsSuccessfulMergeSegmentReplication_listenerCompletes() throws InterruptedException {
        service.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);  
        return new MergedSegmentCheckpoint(
            // (retriggered) round successfully advances the replica to the checkpoint it was asked to sync to.
        allowShardFailures();  
        verify(spy, times(0)).startReplication(
        // new merged segment
            )
            // First round finalizes against a stale checkpoint and does NOT advance the replica. The second
        doReturn(true).when(serviceSpy).processLatestReceivedCheckpoint(any(), any());
        assertEquals(ShardRoutingState.RELOCATING, initialRouting.state());
                ActionListener<GetSegmentFilesResponse> listener  
            ongoingReplications  
                replicaShard,  
                    // failures leave state object in last entered stage.
        // ensure the old target is cancelled. and new iteration kicks off.
 *
        verify(spy, times(0)).updateLatestReceivedCheckpoint(any(), any());  
        latch.await(2, TimeUnit.SECONDS);
    public void testNewMergedSegmentCheckpointBehindCurrentCheckpoint() throws IOException {
        ThreadPool.terminate(testThreadPool, 30, TimeUnit.SECONDS);
    }
    public void testForceSegmentSyncHandlerWithFailure_AlreadyClosedException_swallowed() throws Exception {
                replicationCheckpoint.getShardId(),
                IndexShard indexShard,
        );
        verify(service, times(1)).startReplication(eq(replicaShard), eq(aheadCheckpoint), anyBoolean(), any());
    private TransportService transportService;
                replicaShard,
        sut.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);  
        SegmentReplicationSource source = new TestReplicationSource() {
        ClusterState oldState = ClusterState.builder(ClusterName.DEFAULT)  
        SegmentReplicationSource source = new TestReplicationSource() {
            initialCheckpoint.getSegmentsGen(),  
    /**
    private SegmentReplicationTargetService sut;
                    ) {
        };
/*  
            )
        spy.clusterChanged(new ClusterChangedEvent("ignored", oldState, newState));
            ) {  
            SegmentReplicationTargetService.Actions.FORCE_SYNC,  
        );
    }  
        assertEquals(0, latch.getCount());  
            forceSyncRequest,  
    public void setUp() throws Exception {
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
                }
        replicaShard = newShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));  
        // first (stale) round. The second round catches up, so the done-handler does not retrigger again.
        doAnswer(i -> achieved.get()).when(spyReplicaShard).getLatestReplicationCheckpoint();
import org.opensearch.index.IndexService;  
import org.opensearch.index.store.StoreFileMetadata;
        initialCheckpoint = primaryShard.getLatestReplicationCheckpoint();  
import org.opensearch.transport.TransportService;
            replicaShard.getLatestReplicationCheckpoint().getCodec()
            replicaShard.routingEntry(),
            @Override
        verify(spy, times(0)).startMergedSegmentReplication(any(), any(), any());
                BiConsumer<String, Long> fileProgressTracker,  
            }
        assertEquals(0, latch.getCount());
import org.opensearch.indices.replication.common.CopyState;
            clusterService,
        verify(spy, times(2)).startReplication(eq(spyReplicaShard), any(), anyBoolean(), any());  
        // caught up to the targeted checkpoint.
                listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
            }
        testThreadPool = new TestThreadPool("test", Settings.EMPTY);
            return null;
                    @Override
    public void testAfterIndexShardStartedProcessesLatestReceivedCheckpoint() {
            null,  
                Assert.fail("Unreachable");
        SegmentReplicationSource source = new TestReplicationSource() {  
                    public void onReplicationDone(SegmentReplicationState state) {
        final SegmentReplicationTarget targetSpy = spy(
        // aheadCheckpoint is of same pterm but higher version
            TransportRequestOptions.builder().withTimeout(TRANSPORT_TIMEOUT).build(),
                    }
import org.opensearch.cluster.routing.RecoverySource;  
                public void onReplicationDone(SegmentReplicationState state) {
        // the done-handler observes the replica has caught up and does not retrigger another round.
        IndexShard shard = newStartedShard(false, settings);  
            if (rounds.incrementAndGet() >= 2) {  
    public void testProcessCheckpointOnClusterStateUpdate() {  
                forceSyncRequest,
                        SegmentReplicationState state,
        ForceSyncRequest forceSyncRequest = new ForceSyncRequest(1L, 1L, replicaShard.shardId());
        continueGetCheckpointMetadata.countDown();  
            }  
                List<StoreFileMetadata> filesToFetch,
        CountDownLatch blockGetCheckpointMetadata = new CountDownLatch(1);
        closeShards(primaryShard);  
import org.opensearch.cluster.ClusterState;
        verifyNoInteractions(ongoingReplications);
        final ReplicationCheckpoint updatedCheckpoint = new ReplicationCheckpoint(  
        assertEquals(ShardRoutingState.STARTED, targetRouting.state());
    private ReplicationCheckpoint initialCheckpoint;
        verify(spy, times(0)).startReplication(any(), any(), any());  
import java.util.Collections;
                        ReplicationFailedException e,  
                source,  
    private static final long TRANSPORT_TIMEOUT = 30000;// 30sec
        // new checkpoint arrives with higher pterm.
        );  
        CountDownLatch latch = new CountDownLatch(2);
                @Override
            ) {}
        };
            ) {  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
        verify(serviceSpy, times(1)).startMergedSegmentReplication(eq(replicaShard), any(), any());
import static org.mockito.Mockito.never;
                    latch.countDown();  
                BiConsumer<String, Long> fileProgressTracker,
            }
            achieved.set(i.getArgument(1));
    public void testNewCheckpointBehindCurrentCheckpoint() {
                replicationCheckpoint.getLength(),
        );  
        final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
                source,  
import org.opensearch.common.settings.Settings;
                source,
        IndexShard shard = newStartedShard(false, settings);  
        verify(serviceSpy, times(1)).startMergedSegmentReplication(eq(replicaShard), any(), any());
                updatedCheckpoint,
                    continueGetCheckpointMetadata.await();
        verify(spy, times(0)).startReplication(any(), any(), any());
    }
    @Override  
            .build();  
                Assert.fail("Unreachable");  
                final RuntimeException exception = new CancellableThreads.ExecutionCancelledException("retryable action was cancelled");
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {  
            );  
        super.tearDown();  
            RecoverySource.PeerRecoverySource.INSTANCE,
     * here we are starting a new shard in PrimaryMode and testing that we don't process a checkpoint on shard when it is in PrimaryMode.
            sourceFactory,  
        transportService.acceptIncomingRequests();
import org.opensearch.indices.recovery.ForceSyncRequest;  
            ActionListener<CheckpointInfoResponse> listener;
        latch.await(2, TimeUnit.SECONDS);
        final IndicesService indicesService = mock(IndicesService.class);
    public void tearDown() throws Exception {
        CountDownLatch replicationCompleteLatch = new CountDownLatch(1);
import static org.mockito.Mockito.times;
            boundAddress -> localNode,
import org.opensearch.Version;
            @Override
    @Override
        SegmentReplicationTargetService serviceSpy = spy(sut);
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
import static org.mockito.ArgumentMatchers.any;
        // create old & new cluster states
import org.opensearch.common.settings.ClusterSettings;  
                ReplicationCheckpoint checkpoint,
        ).txGet();  
            ((SegmentReplicationTargetService.SegmentReplicationListener) i.getArgument(3)).onReplicationDone(state);  
                long replicationId,
        IndexShard primaryShard = newStartedShard(true);
            EmptyTransportResponseHandler.INSTANCE_SAME
        CountDownLatch latch = new CountDownLatch(1);  
                replicationCheckpoint.getCodec(),  
                }
        );
                ActionListener<CheckpointInfoResponse> listener  
                    Assert.fail("Test should succeed");  
            replicaShard,  
public class SegmentReplicationTargetServiceTests extends IndexShardTestCase {  
                }  
    }
        AtomicReference<ReplicationCheckpoint> achieved = new AtomicReference<>(replicaShard.getLatestReplicationCheckpoint());
        closeShards(shard);
        sut.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);
        doAnswer(i -> achieved.get()).when(spyReplicaShard).getLatestReplicationCheckpoint();  
            eq(replicaShard),
        ShardRouting targetRouting = ShardRouting.newUnassigned(
    }
                RoutingTable.builder()
import org.opensearch.cluster.routing.RoutingTable;
                replicaShard,  
        // Verify that checkpoint is not processed as shard is in PrimaryMode.  
            primaryCodec
        ReplicationCheckpoint checkpoint = replicaShard.getLatestReplicationCheckpoint();
            @Override
        // set up mocks on indicies & index service to return our replica's index & shard.
import java.util.List;  
        assertEquals(TransportResponse.Empty.INSTANCE, response);
        SegmentReplicationSource source = new TestReplicationSource() {
import org.opensearch.ExceptionsHelper;
        SegmentReplicationTargetService spy = spy(sut);
                replicaShard,  
        );  
            ((SegmentReplicationTargetService.SegmentReplicationListener) i.getArgument(3)).onReplicationDone(state);  
import org.opensearch.index.replication.TestReplicationSource;
 */  
    private DiscoveryNode localNode;  
                ReplicationCheckpoint checkpoint,  
                false
import org.opensearch.test.transport.CapturingTransport;
            new SegmentReplicationTargetService.SegmentReplicationListener() {
import org.opensearch.cluster.node.DiscoveryNodes;
            ) {
import static org.mockito.Mockito.eq;  
        CountDownLatch continueGetCheckpointMetadata = new CountDownLatch(1);  
        );  
            public void getSegmentFiles(  
        verify(spy, times(1)).processLatestReceivedCheckpoint(eq(replicaShard), any());  
                @Override
            localNode,
                        assertEquals("Shard " + replicaShard.shardId() + " is already replicating", e.getMessage());
                    .build()
        ForceSyncRequest forceSyncRequest = new ForceSyncRequest(1L, 1L, replicaShard.shardId());
        final SegmentReplicationTarget target = new SegmentReplicationTarget(
                EmptyTransportResponseHandler.INSTANCE_SAME  
                    throw new RuntimeException(e);  
            "",
            initialCheckpoint.getShardId(),
            any(SegmentReplicationTargetService.SegmentReplicationListener.class)
        verify(spy, times(0)).processLatestReceivedCheckpoint(eq(replicaShard), any());
    public void testTargetCancelledBeforeStartInvoked() {  
        assertNotNull(ExceptionsHelper.unwrap(finalizeException, IOException.class));
        serviceSpy.onNewMergedSegmentCheckpoint(mockMergedSegmentCheckpoint(newPrimaryCheckpoint), replicaShard);
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        IndexShard spyReplicaShard = spy(replicaShard);  
                    assertEquals(SegmentReplicationState.Stage.DONE, state.getStage());
                replicaShard,
                mock(SegmentReplicationTargetService.SegmentReplicationListener.class)
    private TestThreadPool testThreadPool;
            latch.countDown();
                public void onReplicationDone(SegmentReplicationState state) {
import org.opensearch.common.util.CancellableThreads;
            checkpoint.getShardId(),
import org.opensearch.index.shard.IndexShardTestCase;  
     * the replica's checkpoint (stale sync); the second round advances it, after which no further round is triggered.
        transportService.submitRequest(  
            }
        primaryShard = newStartedShard(true, settings);
                new SegmentReplicationTargetService.SegmentReplicationListener() {  
            new MergedSegmentReplicationTarget(  
                localNode,
            )  
        verify(spy, times(1)).processLatestReceivedCheckpoint(eq(replicaShard), any());
                    public void onReplicationFailure(
                    assertEquals(cancelReason, e.getMessage());
                ReplicationCheckpoint checkpoint,
        assertEquals(0, latch.getCount());
        SegmentReplicationTargetService spy = spy(sut);
    }  
                    .add(IndexRoutingTable.builder(primaryShard.shardId().getIndex()).addShard(targetRouting).build())
                replicationCheckpoint.getPrimaryTerm(),  
        latch.await();  
        CountDownLatch latch = new CountDownLatch(1);  
    private IndexShard replicaShard;
        state = new SegmentReplicationState(
            @Override
                long replicationId,  
        }).when(spy).startReplication(any(), any(), any());  
        verify(spy, org.mockito.Mockito.atLeast(2)).processLatestReceivedCheckpoint(any(), any());  
            initialCheckpoint.getShardId(),
            SegmentReplicationTargetService.Actions.FORCE_SYNC,
            source,  
                Assert.fail("Should not be called");  
        String primaryCodec = primaryShard.getLatestReplicationCheckpoint().getCodec();
            )  
            new MergedSegmentReplicationTarget(
                this.listener = listener;
    public void testShardAlreadyReplicating_HigherPrimaryTermReceived() throws InterruptedException {
            EmptyTransportResponseHandler.INSTANCE_SAME
            forceSyncRequest,
                List<StoreFileMetadata> filesToFetch,
                }
                    ) {
        doReturn(mock(SegmentReplicationTarget.class)).when(service).startReplication(any(), any(), any());
        // Start first round of segment replication.
    public void testOnNewCheckpointInvokedOnClosedShardDoesNothing() throws IOException {
        assertTrue(nestedException.getMessage().contains("dummy failure"));
import static org.mockito.ArgumentMatchers.anyLong;  
        spy.afterIndexShardStarted(spyReplicaShard);
                try {  
        doReturn(true).when(serviceSpy).processLatestReceivedCheckpoint(any(), any(), anyBoolean());
        verify(targetSpy, times(1)).cancel("Cancelling stuck merged segment target after new primary");
        ReplicationCheckpoint replicationCheckpoint = primaryShard.getLatestReplicationCheckpoint();
import org.opensearch.core.index.shard.ShardId;
            initialCheckpoint.getSegmentInfosVersion() + 1,
                @Override  
    }
        SegmentReplicationTargetService spy = spy(sut);
                Assert.fail("Unreachable");
                    Assert.fail();
        SegmentReplicationTargetService service = spy(sut);  
        // Starting a new shard in PrimaryMode.
                }
        newPrimaryCheckpoint = new ReplicationCheckpoint(
        transportService.start();
        verify(spy, times(0)).updateLatestReceivedCheckpoint(any(), any());  
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
                IndexShard indexShard,
        localNode = new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT);
                        listener.onResponse(
        spy.onNewCheckpoint(checkpoint, shard);
        SegmentReplicationTargetService service = spy(sut);  
            replicaShard.shardId(),
            TransportRequestOptions.builder().withTimeout(TRANSPORT_TIMEOUT).build(),
    }
                    try (final CopyState copyState = new CopyState(primaryShard)) {  
        );
        verify(spy, times(0)).processLatestReceivedCheckpoint(eq(replicaShard), any());
                long replicationId,
        AlreadyClosedException exception = new AlreadyClosedException("shard closed");
                mock(SegmentReplicationTargetService.SegmentReplicationListener.class)
        CountDownLatch latch = new CountDownLatch(1);
            }
                listener.onFailure(exception);
                checkpoint,
            ).txGet();
            initialCheckpoint.getPrimaryTerm(),  
        SegmentReplicationTargetService spy = spy(sut);
                ActionListener<CheckpointInfoResponse> listener
        serviceSpy.startReplication(targetSpy);  
        serviceSpy.onNewCheckpoint(newPrimaryCheckpoint, replicaShard);  
                ActionListener<CheckpointInfoResponse> listener
            TransportRequestOptions.builder().withTimeout(TRANSPORT_TIMEOUT).build(),  
        blockGetCheckpointMetadata.await(5, TimeUnit.MINUTES);
    }
        spy.onNewCheckpoint(checkpoint, replicaShard);  
        );
                long replicationId,  
        SegmentReplicationTargetService serviceSpy = spy(sut);  
        sut.updateLatestReceivedCheckpoint(aheadCheckpoint, replicaShard);
        );  
        spy.onNewCheckpoint(replicaShard.getLatestReplicationCheckpoint(), replicaShard);
        SegmentReplicationTargetService spy = spy(sut);
        Throwable nestedException = finalizeException.getCause().getCause();  
            return null;
    }
        };  
        spy.startReplication(target);
import org.opensearch.test.junit.annotations.TestLogging;
        aheadCheckpoint = new ReplicationCheckpoint(
        final IndicesService indicesService = mock(IndicesService.class);
            0L,
                IndexShard indexShard,  
    private ReplicationCheckpoint checkpoint;
        SegmentReplicationTargetService spy = spy(sut);  
                // simulate listener resolving, but only after we have issued a cancel from beforeIndexShardClosed .  
                ReplicationCheckpoint checkpoint,
        testThreadPool = null;
        when(indicesService.getShardOrNull(forceSyncRequest.getShardId())).thenReturn(null);
                    Assert.fail("Test should succeed");
            new SegmentReplicationTargetService.SegmentReplicationListener() {  
    }  
        final SegmentReplicationTargetService targetService = new SegmentReplicationTargetService(
    private SegmentReplicationState state;
import static org.mockito.ArgumentMatchers.anyBoolean;
            )
            primaryShard.getLatestReplicationCheckpoint(),
                // set the listener, we will only fail it once we cancel the source.
    public void testReplicationFails() throws InterruptedException {
                @Override
        // try and insert a new target directly - it should fail immediately and alert listener  
        verify(spy, (atLeastOnce())).updateVisibleCheckpoint(eq(0L), eq(spyReplicaShard));
import org.opensearch.threadpool.TestThreadPool;  
            @Override
                @Override  
                List<StoreFileMetadata> filesToFetch,  
                    }
                    public void onReplicationDone(SegmentReplicationState state) {
                    }
import org.opensearch.indices.recovery.RecoverySettings;
                ReplicationCheckpoint checkpoint,  
        MergedSegmentCheckpoint mergedSegmentCheckpoint = mockMergedSegmentCheckpoint(checkpoint);  
            replicaShard.shardId(),  
        assertTrue("expected the replica to be retriggered until it caught up", latch.await(5, TimeUnit.SECONDS));
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        );  
            initialCheckpoint.getShardId(),  
    private ReplicationCheckpoint aheadCheckpoint;  
                SegmentReplicationTargetService.Actions.FORCE_SYNC,  
        when(indicesService.getShardOrNull(forceSyncRequest.getShardId())).thenReturn(spyReplicaShard);
    }
        // Start second round of segment replication through onNewCheckpoint, this should fail to start as first round is still in-progress
        // wait until we are at getCheckpointMetadata stage  
            true,  
        // Model the replica's achieved checkpoint. A successful round advances it to the checkpoint it targeted, so
        ShardRouting initialRouting = primaryShard.routingEntry().relocate(targetNodeId, 0L);
import static org.mockito.Mockito.doReturn;
        final String cancelReason = "test";
        );
        doAnswer(i -> {
                IndexShard indexShard,
                    assertEquals(expectedError, e.getCause());
                long replicationId,
import java.util.concurrent.TimeUnit;
                BiConsumer<String, Long> fileProgressTracker,
    }  
        when(clusterState.routingTable()).thenReturn(mockRoutingTable);  
import static org.mockito.Mockito.doNothing;  
        // ensure the old target is cancelled. and new iteration kicks off.  
                BiConsumer<String, Long> fileProgressTracker,  
        ClusterState newState = ClusterState.builder(ClusterName.DEFAULT)
        closeShards(primaryShard, replicaShard);  
            NoopTracer.INSTANCE
 * compatible open source license.
                replicationCheckpoint.getMetadataMap(),
        };
        service.processLatestReceivedCheckpoint(replicaShard, null);
        when(indicesService.iterator()).thenReturn(Set.of(indexService).iterator());  
            @Override  
        );
import org.junit.Assert;
            new SegmentReplicationTargetService.SegmentReplicationListener() {
import org.opensearch.indices.replication.common.ReplicationFailedException;  
            EmptyTransportResponseHandler.INSTANCE_SAME  
                        assertFalse(sendShardFailure);  
        spy.afterIndexShardStarted(spyReplicaShard);
        doNothing().when(serviceSpy).updateVisibleCheckpoint(anyLong(), any());
        spy.startReplication(
            new SegmentReplicationTarget(  
        Exception finalizeException = expectThrows(Exception.class, () -> {  
    public void testStartReplicationListenerFailure() throws InterruptedException {  
        // Create a spy of Target Service so that we can verify invocation of startReplication call with specific checkpoint on it.
            .routingTable(
                long replicationId,  
            mock(TransportService.class),
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
        final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
        );
        TransportResponse response = transportService.submitRequest(
        spy.onNewMergedSegmentCheckpoint(aheadCheckpoint, replicaShard);
        IndexShard shard = newShard(false);
        }).when(spy).startReplication(any(), any(), anyBoolean(), any());  
                    assertEquals(SegmentReplicationState.Stage.INIT, state.getStage());  
package org.opensearch.indices.replication;
            initialCheckpoint.getSegmentInfosVersion() + 1,
    public void testForceSegmentSyncHandler() throws Exception {
    public void testRejectCheckpointOnShardPrimaryMode() throws IOException {
            localNode,  
        });
        SegmentReplicationSource source = new TestReplicationSource() {  
        verify(targetSpy, times(1)).cancel("Cancelling stuck target after new primary");  
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
        );
        ).txGet();
                listener.onFailure(expectedError);  
        AtomicInteger rounds = new AtomicInteger(0);
                // do not resolve this listener yet, wait for cancel to hit.
        };
import org.opensearch.cluster.routing.ShardRouting;
                    }
            SegmentReplicationTargetService.Actions.FORCE_SYNC,
    public void testDoNotProcessLatestCheckpointIfCheckpointIsBehind() {
        doNothing().when(spy).updateVisibleCheckpoint(eq(0L), any());
        );
        final ReplicationCollection<SegmentReplicationTarget> ongoingReplications = mock(ReplicationCollection.class);
        CapturingTransport transport = new CapturingTransport();  
        sut.startReplication(
                }
        verify(serviceSpy, times(1)).startReplication(eq(replicaShard), any(), anyBoolean(), any());
            replicaShard.getOperationPrimaryTerm() - 1,
        replicationCompleteLatch.await(5, TimeUnit.MINUTES);
import java.util.Set;
     */  
            replicaShard,  
        final SegmentReplicationTarget target = new SegmentReplicationTarget(  
        SegmentReplicationTargetService spy = spy(sut);
    }  
        final MergedSegmentReplicationTarget targetSpy = spy(
            public void getCheckpointMetadata(
            }
                    logger.error("Unexpected error", e);
        doThrow(exception).when(spyReplicaShard).finalizeReplication(any(CatalogSnapshot.class));
        serviceSpy.onNewMergedSegmentCheckpoint(mergedSegmentCheckpoint, replicaShard);
        super.setUp();
        recoverReplica(replicaShard, primaryShard, true, getReplicationFunc(replicaShard));
        );
                }
        // Two rounds: the initial stale round plus the retriggered catch-up round.
        sut = prepareForReplication(primaryShard, replicaShard, transportService, indicesService, clusterService);
import org.opensearch.cluster.routing.ShardRoutingState;  
     * and trigger another round so the replica eventually catches up. Here the first round finalizes without advancing
        SegmentReplicationTargetService spy = spy(sut);  
                IndexShard indexShard,  
            new SegmentReplicationTargetService.SegmentReplicationListener() {
            .build();  
    private ReplicationCheckpoint newPrimaryCheckpoint;
        doThrow(exception).when(spyReplicaShard).finalizeReplication(any(CatalogSnapshot.class));
            0L,  
        sut.startReplication(target);
            @Override  
            initialCheckpoint.getPrimaryTerm() + 1,
    }
                ReplicationCheckpoint checkpoint,
                ActionListener<CheckpointInfoResponse> listener
            .build();
import org.opensearch.index.shard.IndexShard;
    }
                mock(SegmentReplicationTargetService.SegmentReplicationListener.class)  
            latch.countDown();
        // already exist
        doNothing().when(spyReplicaShard).failShard(eq("replication failure"), any());
        when(clusterService.state()).thenReturn(clusterState);
        // spy so we can verify process is invoked  
import org.opensearch.cluster.ClusterName;  
import org.opensearch.cluster.ClusterChangedEvent;
                ReplicationCheckpoint checkpoint,  
                source,
            new ReplicationLuceneIndex(),  
                aheadCheckpoint,
                mergedSegmentCheckpoint,
            new DiscoveryNode("local", buildNewFakeTransportAddress(), Version.CURRENT)  
        ClusterState clusterState = mock(ClusterState.class);  
        final Settings settings = Settings.builder()  
    private MergedSegmentCheckpoint mockMergedSegmentCheckpoint(ReplicationCheckpoint checkpoint) {  
            checkpoint.getMetadataMap(),
        spy.onNewMergedSegmentCheckpoint(checkpoint, shard);
        // Create a Mockito spy of target to stub response of few method calls.  
    /**
            public void getCheckpointMetadata(  
    public void testBeforeIndexShardClosed_DoesNothingForDocRepIndex() throws IOException {  
                    Assert.fail();  
import java.util.concurrent.atomic.AtomicReference;  
                @Override
    private IndexShard primaryShard;  
            ) {
        SegmentReplicationTargetService spy = spy(sut);
        doNothing().when(spyReplicaShard).failShard(eq("replication failure"), any());
        );  
    public void testShardNotStarted() throws IOException {
    }  
                    blockGetCheckpointMetadata.countDown();
            }
            replicaShard,  
        closeShards(shard);  
        doNothing().when(spy).onNewCheckpoint(any(), any());
import static org.mockito.Mockito.atLeastOnce;
            public void getCheckpointMetadata(
            new SegmentReplicationTarget(
import org.opensearch.index.engine.NRTReplicationEngineFactory;
                "mock"
                    }
        final String targetNodeId = "targetNodeId";  
                        Assert.fail("Should not succeed");  
                    assertEquals(SegmentReplicationState.Stage.GET_CHECKPOINT_INFO, state.getStage());
                @Override
        verify(spy, times(1)).processLatestReceivedCheckpoint(any(), any());
    }
     * known checkpoint - by comparing against the replica's achieved checkpoint, not the checkpoint the round targeted -  
            TransportService.NOOP_TRANSPORT_INTERCEPTOR,
}
        service.updateLatestReceivedCheckpoint(checkpoint, replicaShard);  
                } catch (InterruptedException | IOException e) {
                    public void onReplicationFailure(
                replicationCheckpoint.getSegmentInfosVersion(),
            .routingTable(
        target.cancel(cancelReason);
    }
import org.opensearch.indices.replication.common.ReplicationType;
        spy.onNewCheckpoint(aheadCheckpoint, replicaShard);
            initialCheckpoint.getSegmentsGen(),
                    // failures leave state object in last entered stage.  
            indicesService,
        CountDownLatch latch = new CountDownLatch(1);
        indicesService = mock(IndicesService.class);
import org.opensearch.cluster.routing.UnassignedInfo;
            }
            0L,  
        when(indicesService.getShardOrNull(forceSyncRequest.getShardId())).thenReturn(spyReplicaShard);  
        // wait until we get to getCheckpoint step.
            @Override  
                    logger.error("Unexpected error", e);
                long replicationId,
                        boolean sendShardFailure
        );
            checkpoint.getCodec(),  
    public void testForceSegmentSyncHandlerWithFailure() throws Exception {
            ) {}  
    }
 * SPDX-License-Identifier: Apache-2.0
        transportService.submitRequest(
            Collections.emptySet(),
                source,
 * The OpenSearch Contributors require contributions made to  
        when(indicesService.getShardOrNull(forceSyncRequest.getShardId())).thenReturn(replicaShard);  
        doReturn(List.of(targetSpy)).when(serviceSpy).getMergedSegmentReplicationTarget(any());
        verify(spy, times(0)).startReplication(any(), any(), any());
                ReplicationCheckpoint checkpoint,  
            forceSyncRequest,
    }  
        ReplicationCheckpoint oldCheckpoint = new ReplicationCheckpoint(  
        SegmentReplicationTargetService serviceSpy = spy(sut);  
        }).when(spy).startReplication(any(), any(), anyBoolean(), any());  
    }
        final SegmentReplicationTargetService targetService = new SegmentReplicationTargetService(
            eq(aheadCheckpoint),  
            replicaShard,
        assertTrue(replicaShard.shouldProcessCheckpoint(aheadCheckpoint));  
                TransportRequestOptions.builder().withTimeout(TRANSPORT_TIMEOUT).build(),
        when(indexService.index()).thenReturn(replicaShard.routingEntry().index());
    private IndicesService indicesService;
            }
                List<StoreFileMetadata> filesToFetch,
            Settings.EMPTY,
        AtomicReference<ReplicationCheckpoint> achieved = new AtomicReference<>(replicaShard.getLatestReplicationCheckpoint());
     * finalize against a stale metadata checkpoint returned by the primary, leaving the replica behind the checkpoint
                ActionListener<GetSegmentFilesResponse> listener
        checkpoint = new ReplicationCheckpoint(
    }  
        spy.onNewMergedSegmentCheckpoint(oldCheckpoint, replicaShard);
import java.util.function.BiConsumer;
        // prevent shard failure to avoid test setup assertion
        IndexShard spyReplicaShard = spy(replicaShard);  
        RoutingTable mockRoutingTable = mock(RoutingTable.class);
            new UnassignedInfo(UnassignedInfo.Reason.REINITIALIZED, "test")
                        ReplicationFailedException e,  
        spy.afterIndexShardStarted(indexShard);  
            ),  
                ReplicationCheckpoint checkpoint,
            0L,
import org.apache.lucene.store.AlreadyClosedException;
        transportService = transport.createTransportService(
import static org.mockito.Mockito.doThrow;
            ) {  
            initialCheckpoint.getSegmentsGen(),
                }
        // post replication.  
        // start replication is not invoked with aheadCheckpoint  
                RoutingTable.builder()  
        final SegmentReplicationTarget target = spy(
                public void onReplicationDone(SegmentReplicationState state) {  
            public void getCheckpointMetadata(
            primaryShard.shardId(),
    }
            initialCheckpoint.getPrimaryTerm(),
            primaryShard.getLatestReplicationCheckpoint(),
            public void cancel() {
        doNothing().when(spy).updateVisibleCheckpoint(eq(0L), any());
    public void testShardAlreadyReplicating() throws InterruptedException {
        );  
            @Override
    public void testProcessLatestCheckpointIfCheckpointAhead() {
        spy.onNewMergedSegmentCheckpoint(aheadCheckpoint, spyShard);  
            public void getSegmentFiles(
        ).txGet();
        targetService.beforeIndexShardClosed(shard.shardId(), shard, shard.indexSettings().getSettings());
            clusterService,
import static org.mockito.Mockito.verify;
        CountDownLatch latch = new CountDownLatch(1);  
        final OpenSearchException expectedError = new OpenSearchException("Fail");  
    }  
            ) {
            initialCheckpoint.getSegmentInfosVersion() + 1,  
        when(indexService.iterator()).thenReturn(Set.of(replicaShard).iterator());  
                        SegmentReplicationState state,
            transportService.submitRequest(
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doAnswer;
            localNode,
