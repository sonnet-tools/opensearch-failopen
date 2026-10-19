    }  
            verifyUploadedSegments(remoteSegmentStoreDirectory);  
        );  
            publishes.incrementAndGet();  
        when(remoteStore.directory()).thenReturn(remoteStoreFilterDirectory);  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        setup(true, 3);
    }
            reachedCheckpointPublishLatch
        IndexShard spyShard = spy(indexShard);
        verify(remoteMetadataDirectory, times(2)).listFilesByPrefixInLexicographicOrder(
            succeedOnAttempt,  
    public void testSegmentUploadTimeout() throws Exception {
            .getSegmentsUploadedToRemoteStore();
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);
package org.opensearch.index.shard;
        // Succeed on 3rd attempt
        setup(true, 3);
    private void assertNoLagAndTotalUploadsFailed(RemoteSegmentTransferTracker segmentTracker, long totalUploadsFailed) throws Exception {  
        IndexShard spyShard = spy(indexShard);  
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =  
            if (refreshListener instanceof ReleasableRetryableRefreshListener) {
     * (simulated by a generic {@link Engine} mock), a successful segments sync dispatches the uncommitted-segment-bytes
            if (counter.incrementAndGet() <= succeedOnAttempt) {  
        doAnswer(invocation -> {  
        int succeedOnAttempt,
        int succeedCheckpointPublishOnAttempt,
        indexShard.getThreadPool().shutdownNow();
            threadPool
     * Remote store settings carrying only an explicit {@code cluster.remote_store.flush_on_uncommitted_segments.enabled}  
            remoteStoreRefreshListener.drainRefreshes();
    public void testReplica() throws IOException {
            new EngineBackedIndexerFactory(new InternalEngineFactory())  
            SegmentReplicationCheckpointPublisher.EMPTY,  
        EngineBackedIndexer delegatingIndexer = mock(EngineBackedIndexer.class, delegatesTo(indexShard.getIndexer()));  
        CountDownLatch successLatch,
                    .build()
        CountDownLatch successLatch = new CountDownLatch(3);  
            return null;
            mock(RemoteStoreLockManager.class),
import org.opensearch.core.common.unit.ByteSizeValue;
        );
        when(shard.getThreadPool()).thenReturn(mock(ThreadPool.class));
        assertTrue(tracker.getTotalUploadsStarted() > 0);
        }  
            .build();
     */
     * Verifies that on a shard whose {@link EngineBackedIndexer} wraps an engine other than {@code InternalEngine}  
        // Mock (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory())  
        // listFilesByPrefixInLexicographicOrder has been called twice.
    }  
        // the stale-segment cleanup just past the gate, and never gets there.  
        // Validate that the stream of metadata file of remoteMetadataDirectory has been opened only once and the
        assertTrue(tracker.getUploadBytesStarted() > 0);
            closedShard,
            successLatch,
import org.opensearch.index.engine.Engine;
            succeedOnAttempt,  
                                .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "64mb")
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(  
            successLatch
            refreshCountLatch,
        })).when(shard).computeReplicationCheckpoint(any(CatalogSnapshot.class));
     * combination {@code FenceSegmentFlow.tla} proves violates HydrationIntegrity.  
     * the replication checkpoint is still published.  
        RemoteSegmentTransferTracker segmentTracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
            remoteMetadataDirectory,
        promoteReplica(
     */
     * publication uniformly through the {@link Engine} base type -- where it is a no-op -- without breaking the sync:
        }
        doAnswer(invocation -> {
    }
                }
            successLatch,
     * value, needed because the switch is disabled by default and has no per-index counterpart to set it through.
import org.opensearch.index.engine.exec.Indexer;
        assertNoLagAndTotalUploadsFailed(segmentTracker, 2);  
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
        when(shard.remoteStore()).thenReturn(remoteStore);
        indexAndRefreshWithoutFlush(100);
        setup(true, 3);
        Thread.sleep(10);
            doAnswer(answer).when(remoteDirectory).copyFrom(any(), any(), any(), any());
        // start from the real default (disabled) and drive every flip through the cluster settings, so that the
    }  
        );
        verify(shard, atLeastOnce()).isRemoteStoreFenceSupersededFailingClosed();  
        when(shard.getLatestReplicationCheckpoint()).thenReturn(indexShard.getLatestReplicationCheckpoint());  
    }  
        try (Store indexShardStore = indexShard.store()) {  
    private void indexDocs(int startDocId, int numberOfDocs) throws IOException {
    }
        remoteStoreRefreshListener.afterRefresh(true);
            Settings.EMPTY,  
        } finally {  
            succeedOnAttempt,
    }
        newRefreshListenerFor(owningShard).afterRefresh(true);
    public void testCleanupTriggeredWhenMapExceedsThreshold() throws IOException {
        assertEquals(tracker.getUploadBytesStarted(), tracker.getUploadBytesSucceeded());  
    public void testRefreshFailedDueToPrimaryTermMisMatch() throws Exception {  
            refreshCountLatch,
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
        when(spyShard.getRemoteStoreSettings()).thenReturn(mockSettings);  
        super.tearDown();
            }  
                Settings.builder()
            assertTrue(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
        if (primary) {  
        boolean testUploadTimeout,
     * Verifies that {@code cluster.remote_store.flush_on_uncommitted_segments.enabled=false} stops the listener from
    private IndexSettings fencedIndexSettings() {  
        } else {  
        RemoteSegmentTransferTracker tracker = indexShard.getRemoteStoreStatsTrackerFactory()
                return true;
import org.opensearch.common.collect.Tuple;  
import org.opensearch.indices.DefaultRemoteStoreSettings;  
    /**
 * The OpenSearch Contributors require contributions made to  
    /**
        when(shard.remoteStore()).thenReturn(remoteStore);
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "temp-fs")
            }  
        indexDocs(100, randomIntBetween(100, 200));  
        );  
        // This covers 2 cases - 1) isRetry=false, shouldRetry=true 2) isRetry=true, shouldRetry=false  
            clusterSettings.applySettings(
        }
    }
        Store remoteStore = mock(Store.class);
            checkpointPublishSucceedOnAttempt,
        when(shard.store()).thenReturn(store);  
            indexShard.refresh("test");
        int succeedOnAttempt = 1;
            publisher,  
        RemoteSegmentTransferTracker tracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
     * permitted delete is unrecoverable). A single shared fail-open check would relax both at once, which is the
            spyShard,
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
            indexShard.refresh("test");  
        return (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory()).getDelegate())  
            };  
                RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),  
        AtomicLong checkpointPublisherCounter = new AtomicLong();
        );
        assertBusy(() -> assertEquals(0, successLatch.getCount()));  
        when(shard.routingEntry()).thenReturn(indexShard.routingEntry());  
    }
    }  
            assertTrue("expected the disabled syncs to disarm the condition", disarms.get() > disarmsAtDisable);
    public void testRemoteSegmentStoreNotInSync() throws IOException {
        // This covers 3 cases - 1) isRetry=false, shouldRetry=true 2) isRetry=true, shouldRetry=false 3) isRetry=True, shouldRetry=true
        Settings indexSettings = Settings.builder()
            spyShard,  
        int succeedOnAttempt = 10;
            indexDocs(1, numberOfDocs);
    }
                    }
        }
    }
                .build(),
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
        SegmentInfos segmentInfos;
        // Value has been set as 3 as during a successful upload IndexShard.getEngine() is hit thrice and with mockito we are counting down
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        // Mock indexShard.getOperationPrimaryTerm()
        assertBusy(() -> {  
        // We spy on IndexShard.getEngine() to validate that we have successfully hit the terminal code for ascertaining successful upload.
        );
    public void testSegmentSyncProceedsWhenNotSuperseded() throws Exception {
                releasable.close();
        assertBusy(() -> assertEquals(1, successLatch.getCount()));  
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;  
    /** With fencing disabled there is no fence to consult: both failure directions answer "not superseded". */
        when(shard.shardId()).thenReturn(indexShard.shardId());
import org.opensearch.cluster.service.ClusterService;
                            Settings.builder()
        // Create index shard that we will be using to mock different methods in IndexShard for the unit test
                Settings.builder()  
        verify(owningShard, atLeastOnce()).getRemoteStoreSettings();
        RemoteStoreSettings remoteStoreSettings = mock(RemoteStoreSettings.class);  
        int closeShardAfterAttempt  
        doReturn(delegatingIndexer).when(spyShard).getIndexer();  
        assertEquals(0, tracker.getTotalUploadsFailed());  
        verifyUploadedSegments(remoteSegmentStoreDirectory);
            indexDocs(10, 1);
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, Settings.EMPTY);
import org.opensearch.index.IndexSettings;
            true,
        listener.afterRefresh(true); // second sync reaches the collection decision
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "temp-fs")
        doReturn(settingsSpy).when(shard).getRemoteStoreSettings();
    }
            if (listFilesCounter.incrementAndGet() <= 1) {
        clusterService = ClusterServiceUtils.createClusterService(
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = setupDirectoryWithThreshold(threshold);
        }
        Engine mockEngine = mock(Engine.class);
    }
     * would not isolate the listener under test.
            return indexShard.getCatalogSnapshot();
        assertBusy(() -> assertEquals(1, tuple.v2().getRemoteSegmentTransferTracker(indexShard.shardId()).getTotalUploadsFailed()));
            listener.afterRefresh(true);  
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
        // ...but the collection itself did not run: its retention argument is read only at the deletion call site.
                .getDelegate();
            return null;  
            when(remoteStoreSettings.getClusterRemoteSegmentTransferTimeout()).thenReturn(TimeValue.timeValueMillis(10));  
        );
            verifyUploadedSegments(remoteSegmentStoreDirectory);  
            verifyUploadedSegments(remoteSegmentStoreDirectory);  
    /**  
        when(remoteStore.directory()).thenReturn(remoteStoreFilterDirectory);
        int succeedOnAttempt,
    }
        return Tuple.tuple(refreshListener, remoteStoreStatsTrackerFactory);
            assertFalse(remoteStoreRefreshListener.isRemoteSegmentStoreInSync());
        assertDocs(indexShard, "1", "2", "3");
                reachedCheckpointPublishLatch.countDown();
            }  
import static org.mockito.Mockito.doAnswer;  
        indexShard.acquirePrimaryOperationPermit(new ActionListener<>() {
     * <p>
        );  
     * the base method is invoked and the replication checkpoint is still published.  
            1,  
     * segment metadata or collect garbage, because an unfenced publish moves the reference set collection prunes to and
                    } catch (InterruptedException e) {  
     * Snapshot and metadata files created in failed attempt should not break retry.
            "Map size should have grown with threshold disabled, initial=" + initialMapSize + " final=" + finalMapSize,
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
        // Mocking the IndexShard methods and dependent classes.
            mockPrimaryTerm,  
        when(remoteStoreSettings.getClusterRemoteSegmentTransferTimeout()).thenReturn(TimeValue.timeValueMinutes(30));
            assertTrue(segmentTracker.getTotalUploadsFailed() > 1);
        doReturn(delegatingIndexer).when(spyShard).getIndexer();
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = setupDirectoryWithThreshold(-1);
        CountDownLatch refreshCountLatch,
            succeedOnAttempt,
    /**
    private void assertNoLag(RemoteSegmentTransferTracker tracker) {
                METADATA_FILES_TO_FETCH
        );  
        when(remoteMetadataDirectory.getBlobStream(any())).thenAnswer(
    ) throws IOException {
            }  
import org.mockito.stubbing.Answer;
            assertEquals(totalUploadsFailed, segmentTracker.getTotalUploadsFailed());
import java.util.HashMap;
import org.junit.After;
        remoteSegmentStoreDirectory.init();
        if (testUploadTimeout) {
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =  
        CountDownLatch successLatch = new CountDownLatch(3);
            indexDocs(10 + (i * 5), 5);  
        );  
import org.opensearch.indices.recovery.RecoveryState;
        verifyUploadedSegments(remoteSegmentStoreDirectory);
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
        int succeedOnAttempt,
            closeShardAfterAttempt  
    }
        }).when(shard).isStartedPrimary();
                successLatch.countDown();
                );
                .build(),
        // The following logic is referenced from IndexShardTests.testPrimaryFillsSeqNoGapsOnPromotion
        }).when(mockEngine).clearUncommittedSegmentBytes();
    }
        );
        when(mockSettings.getMinRemoteSegmentMetadataFiles()).thenReturn(10);
        }).when(remoteMetadataDirectory)
        }, ThreadPool.Names.GENERIC, "");  
                    try {
    private RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
        SegmentReplicationCheckpointPublisher publisher = spy(SegmentReplicationCheckpointPublisher.EMPTY);
            new CountDownLatch(0),
        // The gate was consulted, and nothing past it ran: syncSegments reads the shard's remote store settings for
        assertEquals(0, tracker.getBytesLag());  
    public void testRefreshPersistentFailureAndIndexShardClosed() throws Exception {
        for (int i = 0; i < indexShard.getRemoteStoreSettings().getMinRemoteSegmentMetadataFiles() + 3; i++) {
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
        doAnswer(invocation -> {
        // Mock indexShard.getCatalogSnapshot()
            mock(ThreadPool.class),
            // Delete any one file from remote store
import org.opensearch.common.settings.ClusterSettings;  
    private void verifyUploadedSegments(RemoteSegmentStoreDirectory remoteSegmentStoreDirectory) throws IOException {
    }  
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
            // This is to check if reading data from remote segment store works as well.
        String segmentsNFilename = null;
        assertTrue(remoteStoreRefreshListener.isLocalOrSnapshotRecoveryOrSeeding());  
            remoteSegmentStoreDirectory = (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore()
            final int disarmsAtDisable = disarms.get();  
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        Engine mockEngine = mock(Engine.class);
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(  
        indexDocs(1, 3);  
            closeShardOnAttempt  
            clusterSettings.applySettings(
        AtomicLong listFilesCounter = new AtomicLong();  
        when(shard.routingEntry()).thenReturn(shardRouting);
        int closeShardAfterAttempt  
            DefaultRemoteStoreSettings.INSTANCE
         * Sole constructor, typically called from sub-classes.
    ) throws IOException {
        int checkpointPublishSucceedOnAttempt = 2;
import org.opensearch.index.store.RemoteDirectory;
    }  
            tracker,
         */
        IndexShard shard = spy(indexShard);
                    segmentsNFilename = file;
        closeShards(indexShard);
    public void testRefreshSuccessOnSecondAttempt() throws Exception {
        assertTrue(remoteStoreRefreshListener.isLowPriorityUpload());
        });  
        assertNoLagAndTotalUploadsFailed(segmentTracker, 0);
        assertBusy(() -> assertEquals(0, successLatch.getCount()));
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
        CountDownLatch noOpLatch = new CountDownLatch(0);
        doReturn(fencedIndexSettings()).when(supersededShard).indexSettings();
     * The two gates must fail in OPPOSITE directions, independently: an unreadable fence lets the publication proceed  
            @Override
        );
                    }
        assertEquals(0, tracker.getTimeMsLag());
                ((ReleasableRetryableRefreshListener) refreshListener).drainRefreshes();  
     * internal {@link RemoteStoreRefreshListener} carrying the node's real settings, so a flush-decision assertion  
    }
        int totalAttempt = 1;
    }
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
        try {  
            true,
        CountDownLatch successLatch,  
        setup(true, 3);  
            );  
            assert false;
        indexShard.refresh("test");
        );  
        when(shardRouting.primary()).thenReturn(true);
            verify(mockEngine, atLeastOnce()).updateUncommittedSegmentBytes(any(), eq(new ByteSizeValue(128, ByteSizeUnit.MB).getBytes()));
            if (counter.incrementAndGet() <= succeedOnAttempt) {
            false,
        } finally {  
                assertTrue("expected a publication while enabled", publishes.get() > 0);
            indexDocs(4 * (i + 1), 4);
import org.apache.lucene.index.SegmentInfos;
        assertBusy(() -> assertEquals(0, successLatch.getCount()));
    }
                indexShard.shardId,  
        IndexShard shard = mock(IndexShard.class);  
            flushOnUncommittedSegmentsRemoteStoreSettings(false)
            SegmentReplicationCheckpointPublisher.EMPTY,
        remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);  
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.METADATA_FILES_TO_FETCH;
        // We spy on IndexShard.getEngine() to validate that we have successfully hit the terminal code for ascertaining successful upload.
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));  
        for (int i = startDocId; i < startDocId + numberOfDocs; i++) {  
    public void testNonInternalEngineNoOpUncommittedSegmentBytesPublish() throws Exception {
        indexShard.refresh("test");  
        assertTrue("remote store in sync", tuple.v1().isRemoteSegmentStoreInSync());
        }
 * compatible open source license.
        setup(false, 3);  
import static org.mockito.Mockito.doReturn;
     */
        doReturn(mockEngine).when(delegatingIndexer).getEngine();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        CountDownLatch successLatch  
import java.util.Objects;
        IndexShard supersededShard = spy(indexShard);
            succeedOnAttempt,
        assertEquals(0, remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStore().size());
        doAnswer((invocationOnMock -> {  
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =  
    public void testRefreshSuccessOnThirdAttempt() throws Exception {  
                logger.info("Value fo latch {}", successLatch.getCount());
        CountDownLatch successLatch = new CountDownLatch(10);  
            new HashMap<>()
            new EngineBackedIndexerFactory(new InternalEngineFactory())  
        boolean closeShard,
        if (mockPrimaryTerm) {  
            DefaultRemoteStoreSettings.INSTANCE
        when(store.directory()).thenReturn(directory);
    public void testRefreshPersistentFailure() throws Exception {  
        CountDownLatch successLatch = new CountDownLatch(2);
import org.opensearch.indices.replication.common.ReplicationType;
            }
        IndexShard spyShard = spy(indexShard);
        assertEquals(tracker.getTotalUploadsStarted(), tracker.getTotalUploadsSucceeded());
            Collections.singleton(replicaRouting.allocationId().getId()),  
        indexShard = newStartedShard(  
            (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory()).getDelegate())
        assertBusy(() -> assertEquals(0, reachedCheckpointPublishLatch.getCount()));
     * Verifies that turning {@code cluster.remote_store.flush_on_uncommitted_segments.enabled} off on a shard that was
        setup(true, 3);  
            shard,
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(Settings.EMPTY, clusterSettings);
            indexShard.refresh("test");  
        return new RemoteStoreRefreshListener(  
    public void testReplicaPromotion() throws IOException, InterruptedException {
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
        setup(true, 3);  
            listener.afterRefresh(true);  
            true,  
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =  
        when(remoteStoreSettings.getMinRemoteSegmentMetadataFiles()).thenReturn(10);
            shardId,  
        // We spy on IndexShard.getEngine() to validate that we have successfully hit the terminal code for ascertaining successful upload.
            if (checkpointPublisherCounter.incrementAndGet() <= succeedCheckpointPublishOnAttempt - 1) {
        when(shard.remoteStore()).thenReturn(remoteStore);  
            indexDocs(10, 1);
        RemoteStoreSettings settingsSpy = spy(indexShard.getRemoteStoreSettings());
            return IndexShardState.STARTED;
            SegmentReplicationCheckpointPublisher.EMPTY,
            for (int i = 0; i < 3; i++) {
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);  
    private RemoteStoreRefreshListener remoteStoreRefreshListener;  
            shard,
        when(remoteStore.directory()).thenReturn(remoteStoreFilterDirectory);  
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(1);
            threadPool  
    ) throws IOException {
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), enabled)  
     * Asserted on the publication call rather than on {@code shouldPeriodicallyFlush()}: the shard installs its own
            remoteSegmentStoreDirectory.init();
        Store remoteStore = mock(Store.class);
            verifyUploadedSegments(remoteSegmentStoreDirectory);
         *  
        }
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, Settings.EMPTY);
    ) throws IOException {
        CountDownLatch refreshCountLatch,
            successLatch,  
        for (int i = 0; i < iterations; i++) {
        assertEquals(0, tracker.getRefreshSeqNoLag());
        indexDocs(4, 4);
        FilterDirectory remoteStoreFilterDirectory = new RemoteStoreRefreshListenerTests.TestFilterDirectory(
        remoteStoreRefreshListener.afterRefresh(true);  
        // We spy on IndexShard.getEngine() to validate that we have successfully hit the terminal code for ascertaining successful upload.  
        verify(supersededShard, never()).getRemoteStoreSettings();
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());  
        assertDocs(indexShard, "1", "2", "3");  
            }  
     */
    }
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)  
            tracker,
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =  
        assertFalse(indexShard.isRemoteStoreFenceSupersededFailingClosed());  
        RemoteStoreSettings mockSettings = mock(RemoteStoreSettings.class);  
import java.util.concurrent.atomic.AtomicInteger;
        assertFalse(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
     * (fail open - the worst case is an orphan) but must skip the stale-segment collection (fail closed - a wrongly
    public void testFlushOnUncommittedSegmentsThresholdPrecedence() throws Exception {
        setup(true, 3);  
        assertBusy(() -> assertNoLag(tracker));
        when(shard.getThreadPool()).thenReturn(threadPool);  
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        when(shard.store()).thenReturn(store);
import static org.mockito.ArgumentMatchers.any;
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.index.engine.InternalEngineFactory;
        // Force the collection decision to be reached once anything has been uploaded.
     * shard's own internal refresh listeners do.
        return mockIndexShardWithRetryAndScheduleRefresh(succeedOnAttempt, refreshCountLatch, successLatch, 1, noOpLatch);  
        setup(true, 3);
            tracker,  
     * the legitimate owner's own collection then deletes files it is still hydrating. See FenceSegmentFlow.tla.  
            indexShard.refresh("test");
            SegmentReplicationCheckpointPublisher.EMPTY,
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(  
        CountDownLatch noOpLatch = new CountDownLatch(0);
            Settings.builder()
        doAnswer(invocation -> {  
        indexShard = newStartedShard(false, indexSettings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
            tracker,  
        int succeedOnAttempt = 1;
import org.opensearch.indices.RemoteStoreSettings;
        // shutdown threadpool for avoid leaking threads
        int succeedOnAttempt,
        final CountDownLatch latch = new CountDownLatch(1);  
        );
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();
        assertTrue(
            }  
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
import java.util.concurrent.CountDownLatch;
            totalAttempt,
    ) throws IOException {
        doAnswer(invocation -> {
    }
        doAnswer(invocation -> {  
import static org.mockito.Mockito.verify;  
            remoteStoreSettings
        // Succeed on 1st attempt  
                ActionListener<Void> actionListener = invocation.getArgument(5);
    public void testCleanupNotTriggeredWhenThresholdDisabled() throws IOException {  
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));  
    public void testStaleSegmentCleanupFailsClosedWhileThePublishGateFailsOpen() throws Exception {
    }
        // Mock the Store, Directory and RemoteSegmentStoreDirectory classes
     * Verifies that a successful segments sync on a shard whose indexer is not an {@link EngineBackedIndexer}
import static org.opensearch.test.RemoteStoreTestUtils.createMetadataFileBytes;
    }  
    public void testAfterCommit() throws IOException {  
        // Mock indexShard.store().directory()  
        doReturn(true).when(supersededShard).isRemoteStoreFenceSuperseded();  
            listener.afterRefresh(true);
            verify(publisher, atLeastOnce()).publish(any(), any());
        Store store = mock(Store.class);
    public void testRefreshSuccessOnFirstAttempt() throws Exception {
        assertTrue(remoteStoreRefreshListener.isRemoteSegmentStoreInSync());
        assertBusy(() -> assertEquals(0, reachedCheckpointPublishLatch.getCount()));  
            remoteStoreSettings
            disarms.incrementAndGet();
    }  
            indexShard.indexSettings()
        boolean closedShard,
     */
            // enabled: a sync publishes
            listener.afterRefresh(true);
        doReturn(mockEngine).when(delegatingIndexer).getEngine();
        );
    private RemoteStoreRefreshListener newRefreshListenerFor(IndexShard shard) {
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        setup(true, 3);  
        );
     */
        assertEquals(0, tracker.getInflightUploads());  
            remoteStoreRefreshListener.isRemoteSegmentStoreInSync();  
        doReturn(0).when(settingsSpy).getUploadedSegmentsCleanupThreshold();  
                SegmentInfos segmentInfos = segmentInfosGatedCloseable.get();
        shard.shardRouting = shardRouting;
import org.opensearch.index.store.Store;
        RemoteSegmentTransferTracker segmentTracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        // This is to check if reading data from remote segment store works as well.
            DefaultRemoteStoreSettings.INSTANCE
            assertEquals(0, remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStore().size());  
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(
        try {
            indexShard,
    /**
        try (GatedCloseable<SegmentInfos> segmentInfosGatedCloseable = indexShard.getSegmentInfosSnapshot()) {  
            clusterSettings  
        CountDownLatch reachedCheckpointPublishLatch = new CountDownLatch(0);
import org.opensearch.common.lease.Releasable;
            mock(RemoteDirectory.class),
            listener.drainRefreshes();
        // The sync proceeded past the publish gate and reached the collection decision...
            // the disable path does not merely stay silent, it actively discards the armed accounting
            new RemoteStoreRefreshListenerTests.TestFilterDirectory(remoteSegmentStoreDirectory)
                logger.info("Closing shard...");
        }
            verifyUploadedSegments(remoteSegmentStoreDirectory);  
        CountDownLatch successLatch = new CountDownLatch(1);
        try (Store remoteStore = indexShard.remoteStore()) {
        ShardId shardId = new ShardId("index1", "_na_", 1);
        int totalAttempt,
import java.io.IOException;  
        } finally {  
    public void setup(boolean primary, int numberOfDocs) throws IOException {  
        }).when(shard).getIndexer();
        remoteStoreRefreshListener = new RemoteStoreRefreshListener(
            mockSettings  
            );  
            Settings.EMPTY,
    public void testTrackerData() throws Exception {  
        }  
            spyShard,
        // Mock the Store, Directory and RemoteSegmentStoreDirectory classes
            Settings.EMPTY,
            return null;
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "temp-fs")  
        RemoteSegmentTransferTracker segmentTracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
            clusterSettings.applySettings(  
            refreshCountLatch,
    }  
        return mockIndexShardWithRetryAndScheduleRefresh(succeedOnAttempt, null, null);  
                        .settings(
        );
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
                indexShard.refresh("test");
        when(shard.shardId()).thenReturn(shardId);
                    .build()
        clusterService = ClusterServiceUtils.createClusterService(  
            }
    }
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =  
            noOpLatch,
    }
            // re-enabled: publications resume
            false,
        int succeedOnAttempt
        latch.await();
            indexDocs(10, 1);
        );
            for (String file : segmentInfos.files(true)) {
    private ClusterService clusterService;
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(  
        // Mocking the IndexShard methods and dependent classes.
     * already publishing stops further publications from the next sync onwards, and that turning it back on resumes
        IndexShard spyShard = spy(indexShard);
        CountDownLatch reachedCheckpointPublishLatch  
            successLatch,  
            doAnswer(answer).when(remoteDirectory)
            indexShard.refresh("test");
        try {  
                if (!RemoteStoreRefreshListener.EXCLUDE_FILES.contains(file)) {  
                indexShard.refresh("test");  
                    actionListener.onResponse(null);  
        CountDownLatch refreshCountLatch = new CountDownLatch(1);
        return mockIndexShardWithRetryAndScheduleRefresh(
import java.util.concurrent.atomic.AtomicLong;
            listener.afterRefresh(true);
    public void testDisabledFlushOnUncommittedSegmentsSkipsPublish() throws Exception {  
import static org.opensearch.test.RemoteStoreTestUtils.getDummyMetadata;  
        Store store = mock(Store.class);
        return mockIndexShardWithRetryAndScheduleRefresh(  
            spyShard,
        flushShard(indexShard);  
                .directory()).getDelegate()).getDelegate();
        assertFalse("remote store should not in sync", listener.isRemoteSegmentStoreInSync());
    public void testRemoteDirectoryInitThrowsException() throws IOException {
import org.opensearch.threadpool.ThreadPool;  
        when(shard.shouldSeedRemoteStore()).thenReturn(true);
            verifyUploadedSegments(remoteSegmentStoreDirectory);
                indexShard.refresh("test");  
        assertBusy(() -> {
            verifyUploadedSegments(remoteSegmentStoreDirectory);
            spyShard,
        refreshListener.afterRefresh(true);
        new RemoteStoreRefreshListener(  
            // the index sets no threshold, so the cluster value is stamped in
            .build();
                        Thread.sleep(30000);
            remoteStoreSettings
        IndexShard spyShard = spy(indexShard);
import static org.mockito.Mockito.spy;
        RemoteStoreRefreshListener listener = tuple.v1();
            if (Objects.nonNull(successLatch)) {  
            false,  
        );
            true  
    /** The positive control: with the fence still ours, the same path proceeds past the gate. */  
        Store store = mock(Store.class);
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
            // an explicit per-index threshold wins over the cluster value  
    public void testRefreshAfterCommit() throws IOException {  
        when(shard.getThreadPool()).thenReturn(mock(ThreadPool.class));  
        // Value has been set as 6 as during a successful upload IndexShard.getEngine() is hit thrice and here we are running the flow twice  
                refreshCountLatch.countDown();
            remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId()),  
        if (remoteStoreRefreshListener != null) {  
        newRefreshListenerFor(supersededShard).afterRefresh(true);  
                if (file.startsWith(IndexFileNames.SEGMENTS)) {  
        FilterDirectory remoteStoreFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(remoteSegmentStoreDirectory));
            refreshCountLatch,
        RemoteStoreRefreshListener refreshListener = new RemoteStoreRefreshListener(
import org.opensearch.index.remote.RemoteSegmentTransferTracker;  
            SegmentReplicationCheckpointPublisher.EMPTY,
            successLatch
        CountDownLatch refreshCountLatch = new CountDownLatch(1);
            assertEquals(0, segmentTracker.getRefreshSeqNoLag());  
        when(shard.state()).thenReturn(IndexShardState.RECOVERING);  
        setup(true, 3);
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "temp-fs")
            indexDocs(40, 1);
            succeedCheckpointPublishOnAttempt,  
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());  
    }  
        AtomicLong counter = new AtomicLong();
            refreshCountLatch,
     * The segment-flow gate has to have teeth in code, not only in the model: a superseded copy must not publish
        IndexShard shard = mock(IndexShard.class);
     */
 *
        assertDocs(indexShard, "1", "2", "3");
     * {@code index.remote_store.flush_on_uncommitted_segments.threshold_size} when the index sets it explicitly,
        try (Store remoteStore = indexShard.remoteStore()) {
            SegmentReplicationCheckpointPublisher.EMPTY,
            .getDelegate();
        }
            publisher,
import static org.mockito.Mockito.times;
    }
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(  
        remoteStoreRefreshListener = new RemoteStoreRefreshListener(
        });  
            succeedOnAttempt,  
        ShardRouting shardRouting = mock(ShardRouting.class);  
            assertTrue(segmentTracker.getTotalUploadsSucceeded() < 2);
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.  
        doReturn(false).when(owningShard).isRemoteStoreFenceSupersededFailingClosed();
        );
        verify(remoteMetadataDirectory, times(1)).getBlobStream(any());  
     * {@code syncSegments} does past the gate, so it is a precise and deterministic signal, independent of whatever the  
            clusterSettings.applySettings(
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();
            Settings.builder()
            }
            });
        }
        doReturn(delegatingIndexer).when(spyShard).getIndexer();  
        try (Store remoteStore = indexShard.remoteStore()) {
            tracker,
import org.opensearch.index.engine.EngineBackedIndexer;  
            reachedCheckpointPublishLatch,
                for (String file : segmentInfos.files(true)) {
        }
        indexDocs(4, 4);
            verify(mockEngine, atLeastOnce()).updateUncommittedSegmentBytes(any(), eq(new ByteSizeValue(64, ByteSizeUnit.MB).getBytes()));
            );
        // Mock indexShard.routingEntry().primary()
            );  
        );
            remoteSegmentStoreDirectory.init();  
            assertEquals(0, segmentTracker.getTimeMsLag());
            }
            false,  
        // Since the thrown IOException is caught in the constructor, ctor should be invoked successfully.
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
        assertBusy(() -> assertNoLag(tracker));  
            SegmentInfos segmentInfos = segmentInfosGatedCloseable.get();
            listener.afterRefresh(true);  
        assertFalse(indexShard.isRemoteStoreFenceSuperseded());
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(
        verify(shard, atLeastOnce()).isRemoteStoreFenceSuperseded();
                return IndexShardState.CLOSED;  
            indexShard.refresh("test");
            mock(RemoteSegmentTransferTracker.class),  
        when(store.directory()).thenReturn(indexShard.store().directory());
            emptyCheckpointPublisher,  
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory;  
import org.opensearch.core.index.shard.ShardId;  
            METADATA_FILES_TO_FETCH  
        listener.afterRefresh(true);
        doReturn(fencedIndexSettings()).when(owningShard).indexSettings();  
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "128mb")
     * them. Covers the enabled -> disabled -> enabled cycle, which the steady-state tests on their own do not.  
                listener.afterRefresh(true);
        );  
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);
        })).when(shard).state();  
                });
            .settings(
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9773")
                }
        Indexer delegatingIndexer = mock(Indexer.class, delegatesTo(indexShard.getIndexer()));
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());  
        RemoteStoreRefreshListener remoteStoreRefreshListener = new RemoteStoreRefreshListener(  
        EngineBackedIndexer delegatingIndexer = mock(EngineBackedIndexer.class, delegatesTo(indexShard.getIndexer()));
    private IndexShard indexShard;
        verify(owningShard, atLeastOnce()).isRemoteStoreFenceSuperseded();
            if (Objects.nonNull(reachedCheckpointPublishLatch)) {
            boolean oneFileDeleted = false;
        CountDownLatch successLatch,
     */
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
    @After
import java.util.Map;  
            listener.drainRefreshes();
     * Tests retry flow after snapshot and metadata files have been uploaded to remote store in the failed attempt.  
                        .build()  
import org.opensearch.cluster.routing.RecoverySource;  
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
        Store remoteStore = mock(Store.class);  
        IndexShard spyShard = spy(indexShard);
            .listFilesByPrefixInLexicographicOrder(  
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(
            checkpointPublishSucceedOnAttempt,
            return indexShard.getLatestReplicationCheckpoint();  
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "temp-fs")
    }  
    public void testSegmentSyncIsSkippedWhenSupersededByAHigherTerm() throws Exception {  
            listener.drainRefreshes();
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;  
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
                throw new AssertionError(e);
            refreshCountLatch,  
import static org.mockito.ArgumentMatchers.anyLong;  
        // Succeed on 2nd attempt
        RemoteDirectory remoteMetadataDirectory = mock(RemoteDirectory.class);
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "temp-fs")  
                .updateIndexMetadata(
        doAnswer(invocation -> {  
        boolean mockPrimaryTerm,  
     * otherwise the cluster default, picked up live from the cluster settings on each publication.
        // Below we are trying to get the IOException thrown in the constructor of the RemoteSegmentStoreDirectory.
        public TestFilterDirectory(Directory in) {  
        CountDownLatch reachedCheckpointPublishLatch = new CountDownLatch(0);
            refreshCountLatch,  
        int initialMapSize = remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStoreSize();
        }  
                    if (oneFileDeleted == false && RemoteStoreRefreshListener.EXCLUDE_FILES.contains(file) == false) {  
        // Mock indexShard.getReplicationTracker().isPrimaryMode()
import org.apache.lucene.store.Directory;
        // Value has been set as 3 as during a successful upload IndexShard.getEngine() is hit thrice and with mockito we are counting down
            .getRemoteSegmentTransferTracker(indexShard.shardId());  
                    .put(indexShard.indexSettings().getIndexMetadata().getSettings())
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        CountDownLatch refreshCountLatch = new CountDownLatch(totalAttempt);
            );
                Settings.builder()
                .build(),
        SegmentReplicationCheckpointPublisher publisher = spy(SegmentReplicationCheckpointPublisher.EMPTY);
        Engine mockEngine = mock(Engine.class);  
        IndexShard owningShard = spy(indexShard);  
import static org.mockito.Mockito.atLeastOnce;
        try {
        }
        );  
        Directory storeDirectory = ((FilterDirectory) ((FilterDirectory) indexShard.store().directory()).getDelegate()).getDelegate();
        EngineBackedIndexer delegatingIndexer = mock(EngineBackedIndexer.class, delegatesTo(indexShard.getIndexer()));
        indexShard = newStartedShard(
            );
    public void tearDown() throws Exception {  
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
    public void testFenceOwnershipQueriesWithoutFencingEnabled() throws Exception {  
            mock(RemoteSegmentTransferTracker.class),  
        // Giving 10ms for some iterations of remote refresh upload  
            // a cluster update is picked up by the next publication
    private RemoteSegmentStoreDirectory setupDirectoryWithThreshold(int threshold) throws IOException {  
            spyShard,
                listener.afterRefresh(true);
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)  
    }
            public void onResponse(Releasable releasable) {  
 */  
    }  
        // Giving 10ms for some iterations of remote refresh upload
            super(in);
        }).when(mockEngine).updateUncommittedSegmentBytes(any(), anyLong());
import static org.mockito.Mockito.when;
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.  
import org.opensearch.test.ClusterServiceUtils;
                indexDocs(docId.addAndGet(10), 1);
        }).when(shard).getCatalogSnapshot();  
            indexDocs(20, 1);
            true,
        RemoteStoreRefreshListener listener = tuple.v1();
                indexDocs(docId.addAndGet(10), 1);
        RemoteSegmentTransferTracker segmentTracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());  
        verify(settingsSpy, never()).getMinRemoteSegmentMetadataFiles();
                    .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
        assertTrue("Map size should be bounded by threshold cleanup, but was: " + mapSize, mapSize < 100);  
            successLatch  
            successLatch
        when(shardRouting.primary()).thenReturn(true);
                throw new RuntimeException("Inducing failure in upload");
                indexShard.getThreadPool(),
 * this file be licensed under the Apache-2.0 license or a
        when(recoveryState.getRecoverySource()).thenReturn(RecoverySource.PeerRecoverySource.INSTANCE);
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(
        // RemoteStoreSettings value and the ClusterSettings view never disagree about the starting point
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            )  
        RemoteDirectory remoteMetadataDirectory = mock(RemoteDirectory.class);
                logger.error("Failing in get catalog snapshot {}", counter.get());
            remoteStoreRefreshListener.afterRefresh(true);
            verify(mockEngine, atLeastOnce()).updateUncommittedSegmentBytes(any(), eq(new ByteSizeValue(256, ByteSizeUnit.MB).getBytes()));
        mockIndexShardWithRetryAndScheduleRefresh(  
        CountDownLatch refreshCountLatch,
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(  
     * (simulated by a delegating mock) skips the uncommitted-segment-bytes publication without breaking the sync:
        int succeedOnAttempt = 1;
            tracker,  
 * SPDX-License-Identifier: Apache-2.0
        final ShardRouting replicaRouting = indexShard.routingEntry();  
        }  
import static org.mockito.AdditionalAnswers.delegatesTo;
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
                return Collections.singletonList("dummy string");
    }
            SegmentReplicationCheckpointPublisher.EMPTY,
    /**
        assertFalse("remote store should not in sync", tuple.v1().isRemoteSegmentStoreInSync());
     * publishing the accounting on a successful segments sync, not just the engine from consulting it. The positive  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    /**
            assertBusy(() -> {  
        flushShard(indexShard);  
        assertDocs(indexShard, "1", "2", "3");
import org.apache.lucene.search.ReferenceManager;  
                    .build()
import org.opensearch.cluster.routing.ShardRouting;
        when(shard.indexSettings()).thenReturn(indexShard.indexSettings());
        CountDownLatch reachedCheckpointPublishLatch,
                indexShard.getThreadPool().executor(ThreadPool.Names.GENERIC).execute(() -> {  
import org.opensearch.index.store.RemoteSegmentStoreDirectory;  
            RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX,
        // Mock threadpool
        RecoveryState recoveryState = mock(RecoveryState.class);  
        return new IndexSettings(fenced, indexShard.indexSettings().getNodeSettings());
                new HashMap<>()
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(  
public class RemoteStoreRefreshListenerTests extends IndexShardTestCase {  
                    IndexMetadata.builder(indexShard.indexSettings().getIndexMetadata())  
import org.opensearch.common.unit.TimeValue;
            listener.drainRefreshes();
import org.apache.lucene.index.IndexFileNames;
        IndexShard shard = mock(IndexShard.class);  
    }  
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
        doReturn(true).when(shard).isRemoteStoreFenceSupersededFailingClosed();
            true,
                        logger.warn("copyFrom thread interrupted during sleep");
            shardId,
        }
        setup(true, 3);
            tracker,
            if (closeShard && counter.get() == closeShardAfterAttempt) {
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(  
         * @param in input directory
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();  
    }  
        doReturn(mockEngine).when(delegatingIndexer).getEngine();  
            DefaultRemoteStoreSettings.INSTANCE
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        return mockIndexShardWithRetryAndScheduleRefresh(  
            // disabled on a live shard: no further publication, however many syncs run
        }
import org.apache.lucene.store.FilterDirectory;
        for (ReferenceManager.RefreshListener refreshListener : indexShard.getIndexer().config().getInternalRefreshListener()) {
        doReturn(fencedIndexSettings()).when(shard).indexSettings();  
     * Tests segments upload fails with replication checkpoint and replication tracker primary term mismatch
        when(mockSettings.getClusterRemoteSegmentTransferTimeout()).thenReturn(TimeValue.timeValueMinutes(30));  
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);  
        );
        );
            });  
                }
            true,
            public void onFailure(Exception e) {  
                    .build()  
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), false)  
            threadPool
import static org.mockito.Mockito.never;  
        // Methods used in the constructor of RemoteSegmentTrackerListener have been mocked to reproduce specific exceptions
            indexShard.refresh("test");
        when(shard.recoveryState()).thenReturn(recoveryState);
            remoteMetadataDirectory,  
        try {  
            succeedOnAttempt,
        }
            }
        ShardRouting shardRouting = mock(ShardRouting.class);  
        } finally {
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(
            new EngineBackedIndexerFactory(new InternalEngineFactory())
                    assertTrue(uploadedSegments.containsKey(file));
        }).when(emptyCheckpointPublisher).publish(any(), any());
                assertTrue("expected publications to resume", publishes.get() > publishesAtDisable);
        int succeedCheckpointPublishOnAttempt,
        IndexMetadata fenced = IndexMetadata.builder(indexShard.indexSettings().getIndexMetadata())
        );
        assertBusy(() -> assertEquals(1, successLatch.getCount()));  
        doReturn(false).when(owningShard).isRemoteStoreFenceSuperseded();
        }  
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        // This is the case of isRetry=false, shouldRetry=false
                        break;  
            final int publishesAtDisable = publishes.get();
import org.opensearch.common.concurrent.GatedCloseable;
     */
            primary,
    }
import static org.mockito.ArgumentMatchers.eq;
        // "superseded" (fail closed).  
        try (Store remoteStore = indexShard.remoteStore()) {
            new HashMap<>()
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
            succeedOnAttempt,
            false,
                Settings.builder()  
        verify(supersededShard, atLeastOnce()).isRemoteStoreFenceSuperseded();
                throw new RuntimeException("Inducing failure in upload");  
                mock(RemoteDirectory.class),  
            assertBusy(() -> assertTrue(tracker.getTotalUploadsSucceeded() > 0));
                                .put(indexShard.indexSettings().getSettings())  
        when(shard.routingEntry()).thenReturn(shardRouting);
        );
        remoteStoreRefreshListener.afterRefresh(true);  
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
                listener.afterRefresh(true);  
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();  
        }  
import org.apache.lucene.tests.store.BaseDirectoryWrapper;  
    ) throws IOException {
            }
        );  
            new RemoteStoreRefreshListenerTests.TestFilterDirectory(remoteSegmentStoreDirectory)
            assertFalse(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());  
                remoteDirectory,
     * Asserted on the code path rather than on side effects: reaching the catalog snapshot is the first thing
import org.opensearch.core.action.ActionListener;  
        // Value has been set as 3 as during a successful upload IndexShard.getEngine() is hit thrice and with mockito we are counting down  
        CountDownLatch refreshCountLatch,  
        Directory directory = mock(Directory.class);
        when(shard.store()).thenReturn(store);  
        setup(true, 3);
            SegmentReplicationCheckpointPublisher.EMPTY,  
        try (Store remoteStore = indexShard.remoteStore()) {
        int succeedOnAttempt = 2;
        indexShard.refresh("test");  
            Settings.builder()
    public void testIsLowPriorityUpload() throws IOException {
                .copyFrom(any(), any(), any(), any(), any(), any(ActionListener.class), any(Boolean.class), any());
        );  
            // the sync itself still ran -- it publishes nothing and instead disarms the condition
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
            reachedCheckpointPublishLatch,
        indexShard.refresh("test");
            indexDocs(10, 1);
            assertBusy(() -> {
            totalAttempt,
        indexShard = newStartedShard(
            I -> createMetadataFileBytes(getDummyMetadata("_0", 1), indexShard.getLatestReplicationCheckpoint(), segmentInfos)
            indexDoc(indexShard, "_doc", Integer.toString(i));
        RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory = indexShard.getRemoteStoreStatsTrackerFactory();  
     * <p>
            refreshCountLatch,
        int threshold = 10;  
        doReturn(false).when(shard).isRemoteStoreFenceSuperseded();
            }  
        Engine mockEngine = mock(Engine.class);
    }
        indexDocs(1, randomIntBetween(1, 100));
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "256mb")
    private void indexAndRefreshWithoutFlush(int iterations) throws IOException {
        CountDownLatch successLatch = new CountDownLatch(3);
        boolean mockPrimaryTerm,  
        setup(true, 1);
            remoteSegmentStoreDirectory.init();  
import static org.mockito.Mockito.mock;
        // An unreadable fence: the publish gate reports "not superseded" (fail open), the collection gate reports
            segmentInfos = indexShardStore.readLastCommittedSegmentsInfo();
            // This is to check if reading data from remote segment store works as well.
            1,
        assertBusy(() -> assertEquals(0, successLatch.getCount()));
    public void testAfterMultipleCommits() throws IOException {  
        indexDocs(8, 4);
     * control -- that an enabled sync does publish -- is
            indexShard,
        }  
        );  
import org.opensearch.common.settings.Settings;
                throw new RuntimeException("Inducing failure after snapshot info snapshot to test if snapshot info file is deleted");
        doReturn(delegatingIndexer).when(spyShard).getIndexer();
        indexShard.refresh("test");
            shard,
            assertEquals("no publication once the switch is off", publishesAtDisable, publishes.get());  
        Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> uploadedSegments = remoteSegmentStoreDirectory  
            testUploadTimeout,
    public static class TestFilterDirectory extends FilterDirectory {
    private static RemoteStoreSettings flushOnUncommittedSegmentsRemoteStoreSettings(boolean enabled) {  
        when(shard.shardId()).thenReturn(shardId);  
        );
                .build(),
            mock(RemoteDirectory.class),  
            Settings.builder()  
            DefaultRemoteStoreSettings.INSTANCE
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
            verify(publisher, atLeastOnce()).publish(any(), any());
                indexDocs(docId.addAndGet(10), 1);
        indexAndRefreshWithoutFlush(100);  
    public void testRefreshSuccessAfterFailureInFirstAttemptAfterSnapshotAndMetadataUpload() throws Exception {  
        when(mockSettings.getUploadedSegmentsCleanupThreshold()).thenReturn(threshold);
                latch.countDown();
    }
            mock(RemoteStoreLockManager.class),
        // success latch should change as we would be failed primary term latest validation.  
            refreshCountLatch,
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            indexShard.refresh("test");  
    }
            successLatch,  
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);
        int finalMapSize = remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStoreSize();  
        remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);
            flushShard(indexShard);  
            successLatch,
        if (testUploadTimeout) {  
        }
            shard,
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
        );
    }
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
        assertEquals(0, tracker.getRejectionCount());
            flushOnUncommittedSegmentsRemoteStoreSettings(true)
        doAnswer((invocation -> {
import java.util.concurrent.TimeUnit;  
                .build(),
            Answer<Boolean> answer = invocation -> {
        );  
            if (Objects.nonNull(refreshCountLatch)) {
        // to test the failure modes possible during construction of RemoteSegmentTrackerListener object.  
    public void testAfterRefresh() throws IOException {
    public void testNonEngineBackedIndexerSkipsUncommittedSegmentBytesPublish() throws Exception {
        boolean testUploadTimeout
        remoteStoreRefreshListener.afterRefresh(true);
            verify(mockEngine, never()).updateUncommittedSegmentBytes(any(), anyLong());
        FilterDirectory remoteStoreFilterDirectory = new RemoteStoreRefreshListenerTests.TestFilterDirectory(  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            when(shard.getOperationPrimaryTerm()).thenReturn(indexShard.getOperationPrimaryTerm());
        );  
        CountDownLatch successLatch = new CountDownLatch(3);
            successLatch,  
            finalMapSize > initialMapSize  
            verify(mockEngine, atLeastOnce()).clearUncommittedSegmentBytes();  
        CountDownLatch reachedCheckpointPublishLatch,
        doReturn(delegatingIndexer).when(spyShard).getIndexer();
    /**  
            false
            remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        doReturn(mockEngine).when(delegatingIndexer).getEngine();  
     * {@link #testNonInternalEngineNoOpUncommittedSegmentBytesPublish()}, which runs the same path with the switch at
            @Override
        );
            }  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        CountDownLatch successLatch,  
     */  
            mock(ThreadPool.class),  
                        )
        setup(false, 3);
            // This is to check if reading data from remote segment store works as well.  
        int closeShardOnAttempt = 1;
     * Verifies the threshold precedence the listener resolves and stamps into the publication: the per-index  
        CountDownLatch refreshCountLatch,  
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        }  
            throw new IOException();
        RemoteStoreRefreshListener listener = newRefreshListenerFor(shard);  
        );
                Settings.builder()  
        SegmentReplicationCheckpointPublisher emptyCheckpointPublisher = spy(SegmentReplicationCheckpointPublisher.EMPTY);
            return true;
    /**  
    }  
        );
                mock(RemoteStoreLockManager.class),
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        final AtomicInteger publishes = new AtomicInteger();
        }
            0  
            reachedCheckpointPublishLatch,
        } catch (Exception e) {  
        ShardId shardId = new ShardId("index1", "_na_", 1);
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;  
        CountDownLatch successLatch = new CountDownLatch(10);  
        int succeedOnAttempt = 3;  
            remoteSegmentStoreDirectory.init();  
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.  
            tracker,
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        when(shard.getRemoteStoreSettings()).thenReturn(remoteStoreSettings);  
        assertNoLagAndTotalUploadsFailed(segmentTracker, 1);
            refreshCountLatch,  
        try (Store remoteStore = indexShard.remoteStore()) {  
        int succeedOnAttempt = 3;  
        assertEquals(0, tracker.getUploadBytesFailed());
        clusterService = ClusterServiceUtils.createClusterService(
        int checkpointPublishSucceedOnAttempt,
import org.opensearch.index.engine.NRTReplicationEngineFactory;
            // This is to check if reading data from remote segment store works as well.
                        oneFileDeleted = true;
            listener.drainRefreshes();
    }  
        setup(true, 3);
        EngineBackedIndexer delegatingIndexer = mock(EngineBackedIndexer.class, delegatesTo(indexShard.getIndexer()));
                        remoteSegmentStoreDirectory.deleteFile(file);
        int checkpointPublishSucceedOnAttempt = 0;
            return indexShard.getIndexer();
        int mapSize = remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStoreSize();
import java.util.Collections;
            0
import org.opensearch.core.common.unit.ByteSizeUnit;
            verify(mockEngine, atLeastOnce()).updateUncommittedSegmentBytes(any(), anyLong());
}  
/*  
            assertEquals(0, segmentTracker.getBytesLag());
        ((BaseDirectoryWrapper) storeDirectory).setCheckIndexOnClose(false);
        // ToDo: Add wait logic as part of promoteReplica()
        );
        setup(true, 3);  
        /**
            checkpointPublishSucceedOnAttempt,
        // This covers the case where segment upload fails due to timeout  
            Settings.builder()  
    public void testFlushOnUncommittedSegmentsPublishFollowsClusterSwitch() throws Exception {
        listener.afterRefresh(true); // first sync populates the uploaded-segments map
        try {
        when(shard.catalogSnapshotToRemoteMetadataSerializer()).thenReturn(snapshot -> new byte[0]);
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(  
            succeedOnAttempt,
     * its enabled default.  
        final AtomicInteger docId = new AtomicInteger(10);  
        assertFalse(listener.getRetryScheduledStatus());  
        final AtomicInteger disarms = new AtomicInteger();  
    /**  
    /** Index settings identical to the shard's, except that remote store fencing is on. */
            try (GatedCloseable<SegmentInfos> segmentInfosGatedCloseable = indexShard.getSegmentInfosSnapshot()) {  
            refreshCountLatch,
        return new RemoteStoreSettings(
        } finally {
