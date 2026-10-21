        EngineBackedIndexer delegatingIndexer = mock(EngineBackedIndexer.class, delegatesTo(indexShard.getIndexer()));
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);
import org.opensearch.indices.DefaultRemoteStoreSettings;
        int finalMapSize = remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStoreSize();
    }
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
            listener.afterRefresh(true);
        RemoteSegmentTransferTracker segmentTracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
            true,
        verifyUploadedSegments(remoteSegmentStoreDirectory);
        }, ThreadPool.Names.GENERIC, "");
            refreshCountLatch,
        verify(supersededShard, never()).getRemoteStoreSettings();
        setup(true, 3);
            // the disable path does not merely stay silent, it actively discards the armed accounting
        CountDownLatch refreshCountLatch = new CountDownLatch(1);
        when(shard.getThreadPool()).thenReturn(mock(ThreadPool.class));
            if (counter.incrementAndGet() <= succeedOnAttempt) {
                Settings.builder()
        when(shardRouting.primary()).thenReturn(true);
        when(shard.routingEntry()).thenReturn(shardRouting);
        // Create index shard that we will be using to mock different methods in IndexShard for the unit test
            0
                throw new AssertionError(e);
        boolean closeShard,
        try {
        // RemoteStoreSettings value and the ClusterSettings view never disagree about the starting point
        } else {
            .getSegmentsUploadedToRemoteStore();
            remoteSegmentStoreDirectory.init();
        when(shard.catalogSnapshotToRemoteMetadataSerializer()).thenReturn(snapshot -> new byte[0]);
            clusterSettings.applySettings(
            threadPool
        }
                indexShard.shardId,
                if (!RemoteStoreRefreshListener.EXCLUDE_FILES.contains(file)) {
                .build(),
import org.apache.lucene.store.FilterDirectory;
        // Force the collection decision to be reached once anything has been uploaded.
            }
        remoteStoreRefreshListener.afterRefresh(true);
            Settings.builder()
        assertBusy(() -> assertEquals(0, successLatch.getCount()));
        boolean mockPrimaryTerm,
     * permitted delete is unrecoverable). A single shared fail-open check would relax both at once, which is the
    public void testTrackerData() throws Exception {
        assertEquals(0, tracker.getUploadBytesFailed());
        );
            reachedCheckpointPublishLatch
        verify(owningShard, atLeastOnce()).isRemoteStoreFenceSuperseded();
            (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory()).getDelegate())
    public void testAfterCommit() throws IOException {
        if (mockPrimaryTerm) {
        AtomicLong checkpointPublisherCounter = new AtomicLong();
    }
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            shard,
            Settings.builder()
            false,
                    .build()
            primary,
            indexDocs(40, 1);
        // Succeed on 2nd attempt
     */
        setup(true, 3);
                return true;
            mock(RemoteSegmentTransferTracker.class),
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
    public void testCleanupNotTriggeredWhenThresholdDisabled() throws IOException {
     * {@code index.remote_store.flush_on_uncommitted_segments.threshold_size} when the index sets it explicitly,
import static org.mockito.AdditionalAnswers.delegatesTo;
        verify(settingsSpy, never()).getMinRemoteSegmentMetadataFiles();
            )
import org.opensearch.cluster.routing.RecoverySource;
        CountDownLatch successLatch = new CountDownLatch(10);
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);
        verify(owningShard, atLeastOnce()).getRemoteStoreSettings();
         * Sole constructor, typically called from sub-classes.
            1,
        indexShard = newStartedShard(false, indexSettings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
    /**
        }
public class RemoteStoreRefreshListenerTests extends IndexShardTestCase {
            succeedOnAttempt,
    private RemoteStoreRefreshListener remoteStoreRefreshListener;
        EngineBackedIndexer delegatingIndexer = mock(EngineBackedIndexer.class, delegatesTo(indexShard.getIndexer()));
     * The segment-flow gate has to have teeth in code, not only in the model: a superseded copy must not publish
        }).when(shard).getCatalogSnapshot();
            new EngineBackedIndexerFactory(new InternalEngineFactory())
    }
    public void testRemoteSegmentStoreNotInSync() throws IOException {
        // ToDo: Add wait logic as part of promoteReplica()
        Engine mockEngine = mock(Engine.class);
        int succeedOnAttempt
        }
            refreshCountLatch,
            indexDocs(10 + (i * 5), 5);
    public void tearDown() throws Exception {
        int succeedOnAttempt = 10;
        when(shard.remoteStore()).thenReturn(remoteStore);
            publisher,
        CountDownLatch successLatch,
            indexShard.refresh("test");
            listener.drainRefreshes();
            closeShardAfterAttempt
            listener.drainRefreshes();
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
        Engine mockEngine = mock(Engine.class);
        // Mock indexShard.store().directory()
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        // start from the real default (disabled) and drive every flip through the cluster settings, so that the
            Settings.EMPTY,
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(
    public void testSegmentUploadTimeout() throws Exception {
    }
        when(mockSettings.getUploadedSegmentsCleanupThreshold()).thenReturn(threshold);
    }
    }
            doAnswer(answer).when(remoteDirectory).copyFrom(any(), any(), any(), any());
            return null;
            mockPrimaryTerm,
        IndexShard spyShard = spy(indexShard);
    }
     */
        try (Store remoteStore = indexShard.remoteStore()) {
        /**
            }
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "temp-fs")
        setup(true, 3);
        if (primary) {
            SegmentReplicationCheckpointPublisher.EMPTY,
        SegmentReplicationCheckpointPublisher emptyCheckpointPublisher = spy(SegmentReplicationCheckpointPublisher.EMPTY);
     * publishing the accounting on a successful segments sync, not just the engine from consulting it. The positive
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        CountDownLatch successLatch = new CountDownLatch(1);
        );
     */
        when(recoveryState.getRecoverySource()).thenReturn(RecoverySource.PeerRecoverySource.INSTANCE);
        remoteStoreRefreshListener = new RemoteStoreRefreshListener(
                listener.afterRefresh(true);
     * them. Covers the enabled -> disabled -> enabled cycle, which the steady-state tests on their own do not.
import static org.mockito.Mockito.doReturn;
                        break;
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
            refreshCountLatch,
        when(store.directory()).thenReturn(indexShard.store().directory());
            indexShard,
            assertEquals(0, segmentTracker.getTimeMsLag());
            public void onFailure(Exception e) {
            reachedCheckpointPublishLatch,
        public TestFilterDirectory(Directory in) {
            // a cluster update is picked up by the next publication
        RemoteDirectory remoteMetadataDirectory = mock(RemoteDirectory.class);
            remoteStoreSettings
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(
            indexShard.refresh("test");
        IndexMetadata fenced = IndexMetadata.builder(indexShard.indexSettings().getIndexMetadata())
                .copyFrom(any(), any(), any(), any(), any(), any(ActionListener.class), any(Boolean.class), any());
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(
import static org.mockito.Mockito.mock;
        }
                    } catch (InterruptedException e) {
                logger.info("Value fo latch {}", successLatch.getCount());
            DefaultRemoteStoreSettings.INSTANCE
                    try {
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(
        EngineBackedIndexer delegatingIndexer = mock(EngineBackedIndexer.class, delegatesTo(indexShard.getIndexer()));
            assertEquals("no publication once the switch is off", publishesAtDisable, publishes.get());
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        }
        Engine mockEngine = mock(Engine.class);
            remoteSegmentStoreDirectory.init();
        Map<String, RemoteSegmentStoreDirectory.UploadedSegmentMetadata> uploadedSegments = remoteSegmentStoreDirectory
        setup(true, 3);
        verify(shard, atLeastOnce()).isRemoteStoreFenceSuperseded();
        SegmentReplicationCheckpointPublisher publisher = spy(SegmentReplicationCheckpointPublisher.EMPTY);
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
            verify(mockEngine, atLeastOnce()).updateUncommittedSegmentBytes(any(), eq(new ByteSizeValue(64, ByteSizeUnit.MB).getBytes()));
            if (counter.incrementAndGet() <= succeedOnAttempt) {
                indexShard.refresh("test");
        latch.await();
            reachedCheckpointPublishLatch,
            // This is to check if reading data from remote segment store works as well.
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        }).when(remoteMetadataDirectory)
        RecoveryState recoveryState = mock(RecoveryState.class);
        assertTrue("remote store in sync", tuple.v1().isRemoteSegmentStoreInSync());
        when(shard.getThreadPool()).thenReturn(mock(ThreadPool.class));
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        // Since the thrown IOException is caught in the constructor, ctor should be invoked successfully.
        assertEquals(tracker.getTotalUploadsStarted(), tracker.getTotalUploadsSucceeded());
        int mapSize = remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStoreSize();
        listener.afterRefresh(true); // first sync populates the uploaded-segments map
                successLatch.countDown();
                logger.info("Closing shard...");
        assertTrue(tracker.getUploadBytesStarted() > 0);
        assertEquals(0, tracker.getRefreshSeqNoLag());
                METADATA_FILES_TO_FETCH
        Engine mockEngine = mock(Engine.class);
            Settings.EMPTY,
                    .put(indexShard.indexSettings().getIndexMetadata().getSettings())
            flushShard(indexShard);
        Store store = mock(Store.class);
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, Settings.EMPTY);
        try (Store remoteStore = indexShard.remoteStore()) {
            publisher,
    }
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();
     */
        // the stale-segment cleanup just past the gate, and never gets there.
                mock(RemoteStoreLockManager.class),
        boolean testUploadTimeout,
        );
            mock(ThreadPool.class),
        doReturn(delegatingIndexer).when(spyShard).getIndexer();
        // This covers 3 cases - 1) isRetry=false, shouldRetry=true 2) isRetry=true, shouldRetry=false 3) isRetry=True, shouldRetry=true
        when(shard.shardId()).thenReturn(indexShard.shardId());
    /**
        );
        when(shardRouting.primary()).thenReturn(true);
        setup(true, 3);
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        Store remoteStore = mock(Store.class);
        // We spy on IndexShard.getEngine() to validate that we have successfully hit the terminal code for ascertaining successful upload.
        // This is to check if reading data from remote segment store works as well.
        try {
        refreshListener.afterRefresh(true);
    ) throws IOException {
        when(remoteStore.directory()).thenReturn(remoteStoreFilterDirectory);
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        doReturn(mockEngine).when(delegatingIndexer).getEngine();
        AtomicLong counter = new AtomicLong();
            .build();
                return Collections.singletonList("dummy string");
            indexDocs(10, 1);
            indexShard.refresh("test");
        indexShard.refresh("test");
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
            flushOnUncommittedSegmentsRemoteStoreSettings(false)
            assertEquals(0, segmentTracker.getRefreshSeqNoLag());
            verify(mockEngine, never()).updateUncommittedSegmentBytes(any(), anyLong());
            indexShard.refresh("test");
        verify(remoteMetadataDirectory, times(1)).getBlobStream(any());
import java.util.HashMap;
        }
                        Thread.sleep(30000);
        assertFalse(indexShard.isRemoteStoreFenceSuperseded());
                Settings.builder()
            verify(publisher, atLeastOnce()).publish(any(), any());
        boolean testUploadTimeout
            successLatch
     * the base method is invoked and the replication checkpoint is still published.
            new RemoteStoreRefreshListenerTests.TestFilterDirectory(remoteSegmentStoreDirectory)
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "temp-fs")
                .getDelegate();
        for (int i = startDocId; i < startDocId + numberOfDocs; i++) {
        RemoteDirectory remoteMetadataDirectory = mock(RemoteDirectory.class);
        assertNoLagAndTotalUploadsFailed(segmentTracker, 2);
import org.opensearch.core.common.unit.ByteSizeValue;
            });
        assertNoLagAndTotalUploadsFailed(segmentTracker, 0);
        indexAndRefreshWithoutFlush(100);
            }
        final AtomicInteger docId = new AtomicInteger(10);
            succeedOnAttempt,
            SegmentReplicationCheckpointPublisher.EMPTY,
        Store store = mock(Store.class);
        final CountDownLatch latch = new CountDownLatch(1);
        // Mock indexShard.getOperationPrimaryTerm()
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
            assertFalse(remoteStoreRefreshListener.isRemoteSegmentStoreInSync());
        setup(true, 3);
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
                return IndexShardState.CLOSED;
        Thread.sleep(10);
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
            assertTrue(segmentTracker.getTotalUploadsSucceeded() < 2);
        // We spy on IndexShard.getEngine() to validate that we have successfully hit the terminal code for ascertaining successful upload.
                indexShard.getThreadPool().executor(ThreadPool.Names.GENERIC).execute(() -> {
    }
            if (Objects.nonNull(reachedCheckpointPublishLatch)) {
                    segmentsNFilename = file;
            successLatch,
            }
            tracker,
                indexShard.getThreadPool(),
        indexShard.refresh("test");
        try (Store remoteStore = indexShard.remoteStore()) {
     * {@link #testNonInternalEngineNoOpUncommittedSegmentBytesPublish()}, which runs the same path with the switch at
                }
        indexDocs(100, randomIntBetween(100, 200));
        verifyUploadedSegments(remoteSegmentStoreDirectory);
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);
            true,
            "Map size should have grown with threshold disabled, initial=" + initialMapSize + " final=" + finalMapSize,
        doReturn(delegatingIndexer).when(spyShard).getIndexer();
            shard,
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_REPLICATION_TYPE;
        IndexShard owningShard = spy(indexShard);
        return new RemoteStoreSettings(
    /**
        // The sync proceeded past the publish gate and reached the collection decision...
        assertDocs(indexShard, "1", "2", "3");
        try {
import static org.opensearch.test.RemoteStoreTestUtils.getDummyMetadata;
    }
    public void testReplica() throws IOException {
        assertDocs(indexShard, "1", "2", "3");
            reachedCheckpointPublishLatch,
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "temp-fs")
import static org.opensearch.index.store.RemoteSegmentStoreDirectory.METADATA_FILES_TO_FETCH;
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();
    }
            succeedOnAttempt,
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
        boolean mockPrimaryTerm,
            true,
            @Override
        );
    public void testSegmentSyncIsSkippedWhenSupersededByAHigherTerm() throws Exception {
            listener.afterRefresh(true);
        int closeShardOnAttempt = 1;
            indexDoc(indexShard, "_doc", Integer.toString(i));
        closeShards(indexShard);
        Directory directory = mock(Directory.class);
 * compatible open source license.
    private IndexShard indexShard;
import org.opensearch.cluster.service.ClusterService;
    /**
        }
        );
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        CountDownLatch noOpLatch = new CountDownLatch(0);
        RemoteStoreRefreshListener listener = tuple.v1();
        try {
                .build(),
        remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);
    public void testDisabledFlushOnUncommittedSegmentsSkipsPublish() throws Exception {
        assertDocs(indexShard, "1", "2", "3");
                SegmentInfos segmentInfos = segmentInfosGatedCloseable.get();
    }
    }
                );
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = setupDirectoryWithThreshold(threshold);
     */
    }
        doReturn(fencedIndexSettings()).when(shard).indexSettings();
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "temp-fs")
            emptyCheckpointPublisher,
                        remoteSegmentStoreDirectory.deleteFile(file);
            if (closeShard && counter.get() == closeShardAfterAttempt) {
        );
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(
            segmentInfos = indexShardStore.readLastCommittedSegmentsInfo();
                ((ReleasableRetryableRefreshListener) refreshListener).drainRefreshes();
            successLatch,
                });
        assertTrue(remoteStoreRefreshListener.isLowPriorityUpload());
    }
        doReturn(mockEngine).when(delegatingIndexer).getEngine();
        // Value has been set as 3 as during a successful upload IndexShard.getEngine() is hit thrice and with mockito we are counting down
     */
     * <p>
            remoteStoreRefreshListener.afterRefresh(true);
        }).when(shard).isStartedPrimary();
import org.apache.lucene.index.SegmentInfos;
            new EngineBackedIndexerFactory(new InternalEngineFactory())
        RemoteDirectory remoteDirectory = mock(RemoteDirectory.class);
    ) throws IOException {
            );
                for (String file : segmentInfos.files(true)) {
        } finally {
        // This covers 2 cases - 1) isRetry=false, shouldRetry=true 2) isRetry=true, shouldRetry=false
            remoteStoreRefreshListener.drainRefreshes();
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), enabled)
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
            // This is to check if reading data from remote segment store works as well.
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        CountDownLatch successLatch,
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
    /** Index settings identical to the shard's, except that remote store fencing is on. */
        shard.shardRouting = shardRouting;
        return new RemoteStoreRefreshListener(
    public void testIsLowPriorityUpload() throws IOException {
        SegmentReplicationCheckpointPublisher publisher = spy(SegmentReplicationCheckpointPublisher.EMPTY);
            tracker,
    }
     * segment metadata or collect garbage, because an unfenced publish moves the reference set collection prunes to and
}
        // Value has been set as 3 as during a successful upload IndexShard.getEngine() is hit thrice and with mockito we are counting down
        indexShard.refresh("test");
            shard,
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(
            assertBusy(() -> {
        boolean closedShard,
        assertBusy(() -> assertEquals(1, tuple.v2().getRemoteSegmentTransferTracker(indexShard.shardId()).getTotalUploadsFailed()));
     * Verifies that on a shard whose {@link EngineBackedIndexer} wraps an engine other than {@code InternalEngine}
    }
        final ShardRouting replicaRouting = indexShard.routingEntry();
            .listFilesByPrefixInLexicographicOrder(
        // The following logic is referenced from IndexShardTests.testPrimaryFillsSeqNoGapsOnPromotion
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
        String segmentsNFilename = null;
        listener.afterRefresh(true); // second sync reaches the collection decision
     * already publishing stops further publications from the next sync onwards, and that turning it back on resumes
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(1);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            }
            threadPool
        }
        }
        doReturn(settingsSpy).when(shard).getRemoteStoreSettings();
        assertEquals(0, tracker.getRejectionCount());
        CountDownLatch reachedCheckpointPublishLatch,
            if (Objects.nonNull(refreshCountLatch)) {
        setup(true, 3);
        return mockIndexShardWithRetryAndScheduleRefresh(
     */
        return (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory()).getDelegate())
            );
            indexShard.refresh("test");
import java.util.concurrent.CountDownLatch;
        doAnswer((invocationOnMock -> {
            remoteStoreRefreshListener.isRemoteSegmentStoreInSync();
            checkpointPublishSucceedOnAttempt,
    public void testNonInternalEngineNoOpUncommittedSegmentBytesPublish() throws Exception {
            refreshCountLatch,
        FilterDirectory remoteStoreFilterDirectory = new RemoteStoreRefreshListenerTests.TestFilterDirectory(
    }
        RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory = indexShard.getRemoteStoreStatsTrackerFactory();
            new EngineBackedIndexerFactory(new InternalEngineFactory())
            0
        try (Store remoteStore = indexShard.remoteStore()) {
        }).when(emptyCheckpointPublisher).publish(any(), any());
            new HashMap<>()
            succeedOnAttempt,
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        }
            .getDelegate();
import java.util.Map;
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
        if (testUploadTimeout) {
import static org.mockito.Mockito.times;
    }
        assertFalse(indexShard.isRemoteStoreFenceSupersededFailingClosed());
        int succeedCheckpointPublishOnAttempt,
            Settings.builder()
            }
        return Tuple.tuple(refreshListener, remoteStoreStatsTrackerFactory);
        final AtomicInteger disarms = new AtomicInteger();
                    .build()
                .build(),
    public void testRefreshSuccessOnSecondAttempt() throws Exception {
        remoteStoreStatsTrackerFactory = new RemoteStoreStatsTrackerFactory(clusterService, Settings.EMPTY);
        for (int i = 0; i < iterations; i++) {
            final int disarmsAtDisable = disarms.get();
        when(shard.getLatestReplicationCheckpoint()).thenReturn(indexShard.getLatestReplicationCheckpoint());
        return mockIndexShardWithRetryAndScheduleRefresh(succeedOnAttempt, refreshCountLatch, successLatch, 1, noOpLatch);
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        }).when(shard).getIndexer();
        indexShard = newStartedShard(
        remoteStoreRefreshListener = new RemoteStoreRefreshListener(
        when(shard.remoteStore()).thenReturn(remoteStore);
        CountDownLatch refreshCountLatch,
        indexShard.acquirePrimaryOperationPermit(new ActionListener<>() {
        int closeShardAfterAttempt
            .settings(
        }
            indexShard,
        doReturn(mockEngine).when(delegatingIndexer).getEngine();
import org.opensearch.core.action.ActionListener;
            1,
            publishes.incrementAndGet();
    }
        }
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();
            // disabled on a live shard: no further publication, however many syncs run
        CountDownLatch successLatch = new CountDownLatch(3);
        assertBusy(() -> assertEquals(1, successLatch.getCount()));
        when(remoteStoreSettings.getClusterRemoteSegmentTransferTimeout()).thenReturn(TimeValue.timeValueMinutes(30));
            });
import org.mockito.stubbing.Answer;
        int threshold = 10;
        verify(supersededShard, atLeastOnce()).isRemoteStoreFenceSuperseded();
        if (testUploadTimeout) {
        indexDocs(1, randomIntBetween(1, 100));
        doReturn(true).when(shard).isRemoteStoreFenceSupersededFailingClosed();
            clusterSettings.applySettings(
            tracker,
            }
            SegmentReplicationCheckpointPublisher.EMPTY,
import org.opensearch.index.remote.RemoteStoreStatsTrackerFactory;
            when(remoteStoreSettings.getClusterRemoteSegmentTransferTimeout()).thenReturn(TimeValue.timeValueMillis(10));
                            Settings.builder()
        assertBusy(() -> {
import java.util.concurrent.atomic.AtomicLong;
        doAnswer(invocation -> {
        RemoteStoreSettings settingsSpy = spy(indexShard.getRemoteStoreSettings());
        IndexShard spyShard = spy(indexShard);
            new HashMap<>()
        } finally {
        // Mock indexShard.getReplicationTracker().isPrimaryMode()
import org.opensearch.common.concurrent.GatedCloseable;
        try (Store indexShardStore = indexShard.store()) {
                latch.countDown();
        // ...but the collection itself did not run: its retention argument is read only at the deletion call site.
        doReturn(delegatingIndexer).when(spyShard).getIndexer();
            true,
        );
        int initialMapSize = remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStoreSize();
            throw new IOException();
    public static class TestFilterDirectory extends FilterDirectory {
import org.opensearch.index.engine.EngineBackedIndexer;
    }
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
            mock(RemoteStoreLockManager.class),
         * @param in input directory
        // We spy on IndexShard.getEngine() to validate that we have successfully hit the terminal code for ascertaining successful upload.
        );
            return indexShard.getCatalogSnapshot();
            Settings.EMPTY,
     * Remote store settings carrying only an explicit {@code cluster.remote_store.flush_on_uncommitted_segments.enabled}
    }
        );
        CountDownLatch reachedCheckpointPublishLatch,
            I -> createMetadataFileBytes(getDummyMetadata("_0", 1), indexShard.getLatestReplicationCheckpoint(), segmentInfos)
        indexDocs(8, 4);
            return IndexShardState.STARTED;
        int checkpointPublishSucceedOnAttempt = 2;
    }
    }
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(
            };
                        oneFileDeleted = true;
        Store remoteStore = mock(Store.class);
        indexShard.getThreadPool().shutdownNow();
        setup(true, 3);
            clusterSettings.applySettings(
import java.util.concurrent.TimeUnit;
            indexShard.refresh("test");
            SegmentReplicationCheckpointPublisher.EMPTY,
        })).when(shard).state();
        // Mock the Store, Directory and RemoteSegmentStoreDirectory classes
            .put(IndexMetadata.SETTING_VERSION_CREATED, org.opensearch.Version.CURRENT)
        when(shard.remoteStore()).thenReturn(remoteStore);
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);
            super(in);
    /**
        // Mock indexShard.routingEntry().primary()
import static org.mockito.ArgumentMatchers.eq;
        CountDownLatch successLatch = new CountDownLatch(3);
            SegmentReplicationCheckpointPublisher.EMPTY,
            assert false;
            refreshCountLatch,
                indexDocs(docId.addAndGet(10), 1);
            mock(ThreadPool.class),
            verify(mockEngine, atLeastOnce()).updateUncommittedSegmentBytes(any(), eq(new ByteSizeValue(128, ByteSizeUnit.MB).getBytes()));
            spyShard,
            noOpLatch,
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(
        );
import org.opensearch.indices.RemoteStoreSettings;
        int totalAttempt,
            mock(RemoteStoreLockManager.class),
        CountDownLatch refreshCountLatch,
            // This is to check if reading data from remote segment store works as well.
        assertNoLagAndTotalUploadsFailed(segmentTracker, 1);
        RemoteStoreSettings mockSettings = mock(RemoteStoreSettings.class);
            return null;
    private void indexDocs(int startDocId, int numberOfDocs) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        );
            return null;
            listener.afterRefresh(true);
     * combination {@code FenceSegmentFlow.tla} proves violates HydrationIntegrity.
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        when(store.directory()).thenReturn(directory);
        FilterDirectory remoteStoreFilterDirectory = new RemoteStoreRefreshListenerTests.TestFilterDirectory(
     * the replication checkpoint is still published.
                    assertTrue(uploadedSegments.containsKey(file));
        // This covers the case where segment upload fails due to timeout
 * The OpenSearch Contributors require contributions made to
        );
            SegmentInfos segmentInfos = segmentInfosGatedCloseable.get();
            indexDocs(20, 1);
     * (simulated by a generic {@link Engine} mock), a successful segments sync dispatches the uncommitted-segment-bytes
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
            succeedOnAttempt,
        try (Store remoteStore = indexShard.remoteStore()) {
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "128mb")
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        mockIndexShardWithRetryAndScheduleRefresh(
                .build(),
            succeedCheckpointPublishOnAttempt,
import static org.opensearch.test.RemoteStoreTestUtils.createMetadataFileBytes;
            doAnswer(answer).when(remoteDirectory)
            indexDocs(1, numberOfDocs);
        new RemoteStoreRefreshListener(
            tracker,
        try {
        CountDownLatch refreshCountLatch,
        if (remoteStoreRefreshListener != null) {
            indexDocs(10, 1);
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
        }
        setup(true, 3);
    public void testRefreshSuccessOnThirdAttempt() throws Exception {
        setup(true, 3);
            );
        );
        RemoteStoreRefreshListener remoteStoreRefreshListener = new RemoteStoreRefreshListener(
        assertEquals(0, tracker.getTimeMsLag());
        Directory storeDirectory = ((FilterDirectory) ((FilterDirectory) indexShard.store().directory()).getDelegate()).getDelegate();
    ) throws IOException {
            mock(RemoteDirectory.class),
        CountDownLatch reachedCheckpointPublishLatch
import java.util.Objects;
 */
    public void testReplicaPromotion() throws IOException, InterruptedException {
    public void testStaleSegmentCleanupFailsClosedWhileThePublishGateFailsOpen() throws Exception {
            indexDocs(10, 1);
        remoteStoreRefreshListener.afterRefresh(true);
        }
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
        // to test the failure modes possible during construction of RemoteSegmentTrackerListener object.
        doReturn(false).when(owningShard).isRemoteStoreFenceSuperseded();
                Settings.builder()
        assertEquals(0, remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStore().size());
    }
        );
            }
    }
            new RemoteStoreRefreshListenerTests.TestFilterDirectory(remoteSegmentStoreDirectory)
            mockSettings
                listener.afterRefresh(true);
            assertTrue(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
        // Methods used in the constructor of RemoteSegmentTrackerListener have been mocked to reproduce specific exceptions
    }
    /** With fencing disabled there is no fence to consult: both failure directions answer "not superseded". */
        IndexShard shard = spy(indexShard);
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
            if (refreshListener instanceof ReleasableRetryableRefreshListener) {
            indexDocs(4 * (i + 1), 4);
        RemoteStoreRefreshListener listener = newRefreshListenerFor(shard);
            successLatch
/*
        assertBusy(() -> assertEquals(0, reachedCheckpointPublishLatch.getCount()));
import static org.mockito.Mockito.spy;
            new CountDownLatch(0),
    /** The positive control: with the fence still ours, the same path proceeds past the gate. */
                .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, "temp-fs")
    private void verifyUploadedSegments(RemoteSegmentStoreDirectory remoteSegmentStoreDirectory) throws IOException {
        setup(true, 3);
     * its enabled default.
        clusterService = ClusterServiceUtils.createClusterService(
        // Mock the Store, Directory and RemoteSegmentStoreDirectory classes
        assertTrue(tracker.getTotalUploadsStarted() > 0);
        doReturn(fencedIndexSettings()).when(owningShard).indexSettings();
            assertEquals(0, segmentTracker.getBytesLag());
    /**
            disarms.incrementAndGet();
        assertBusy(() -> assertEquals(1, successLatch.getCount()));
            .build();
    }
                    actionListener.onResponse(null);
        int succeedOnAttempt,
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), false)
            refreshCountLatch,
            assertEquals(0, remoteSegmentStoreDirectory.getSegmentsUploadedToRemoteStore().size());
        doReturn(false).when(shard).isRemoteStoreFenceSuperseded();
    private Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> mockIndexShardWithRetryAndScheduleRefresh(
            false,
            testUploadTimeout,
            succeedOnAttempt,
            SegmentReplicationCheckpointPublisher.EMPTY,
         *
        when(shard.recoveryState()).thenReturn(recoveryState);
            mock(RemoteSegmentTransferTracker.class),
        when(remoteMetadataDirectory.getBlobStream(any())).thenAnswer(
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
        ShardId shardId = new ShardId("index1", "_na_", 1);
     */
        );
        );
        // Value has been set as 6 as during a successful upload IndexShard.getEngine() is hit thrice and here we are running the flow twice
        RemoteStoreSettings remoteStoreSettings = mock(RemoteStoreSettings.class);
     * (simulated by a delegating mock) skips the uncommitted-segment-bytes publication without breaking the sync:
    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
        // Giving 10ms for some iterations of remote refresh upload
        }
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
import org.junit.After;
            verify(mockEngine, atLeastOnce()).updateUncommittedSegmentBytes(any(), eq(new ByteSizeValue(256, ByteSizeUnit.MB).getBytes()));
        final AtomicInteger publishes = new AtomicInteger();
        });
        RemoteSegmentTransferTracker segmentTracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
        }).when(mockEngine).updateUncommittedSegmentBytes(any(), anyLong());
        doReturn(0).when(settingsSpy).getUploadedSegmentsCleanupThreshold();
        CountDownLatch successLatch
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory;
            succeedOnAttempt,
        );
            remoteSegmentStoreDirectory.init();
        for (ReferenceManager.RefreshListener refreshListener : indexShard.getIndexer().config().getInternalRefreshListener()) {
        when(spyShard.getRemoteStoreSettings()).thenReturn(mockSettings);
import org.opensearch.index.engine.Engine;
        setup(true, 3);
            shardId,
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/9773")
            remoteSegmentStoreDirectory = new RemoteSegmentStoreDirectory(
        );
        assertEquals(tracker.getUploadBytesStarted(), tracker.getUploadBytesSucceeded());
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
        IndexShard supersededShard = spy(indexShard);
     * Tests retry flow after snapshot and metadata files have been uploaded to remote store in the failed attempt.
            false,
        int succeedOnAttempt,
        setup(false, 3);
        // Mock threadpool
     * the legitimate owner's own collection then deletes files it is still hydrating. See FenceSegmentFlow.tla.
        clusterService = ClusterServiceUtils.createClusterService(
import org.apache.lucene.search.ReferenceManager;
            verify(mockEngine, atLeastOnce()).updateUncommittedSegmentBytes(any(), anyLong());
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
import org.opensearch.indices.replication.common.ReplicationType;
        } catch (Exception e) {
            false
        doAnswer(invocation -> {
                throw new RuntimeException("Inducing failure after snapshot info snapshot to test if snapshot info file is deleted");
        assertTrue(
     * Tests segments upload fails with replication checkpoint and replication tracker primary term mismatch
    private static RemoteStoreSettings flushOnUncommittedSegmentsRemoteStoreSettings(boolean enabled) {
        ShardRouting shardRouting = mock(ShardRouting.class);
        assertTrue(remoteStoreRefreshListener.isRemoteSegmentStoreInSync());
        indexShard.refresh("test");
        remoteStoreRefreshListener.afterRefresh(true);
     * The two gates must fail in OPPOSITE directions, independently: an unreadable fence lets the publication proceed
        assertFalse(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
            verify(mockEngine, atLeastOnce()).clearUncommittedSegmentBytes();
        int succeedOnAttempt = 1;
import static org.mockito.Mockito.never;
        }
            Settings.builder()
import org.opensearch.common.unit.TimeValue;
import java.util.concurrent.atomic.AtomicInteger;
                        logger.warn("copyFrom thread interrupted during sleep");
        assertDocs(indexShard, "1", "2", "3");
    public void testRefreshPersistentFailure() throws Exception {
            checkpointPublishSucceedOnAttempt,
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();
                .build(),
        indexDocs(4, 4);
        doAnswer(invocation -> {
        // listFilesByPrefixInLexicographicOrder has been called twice.
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
            listener.afterRefresh(true);
        // "superseded" (fail closed).
import org.opensearch.core.common.unit.ByteSizeUnit;
         */
            remoteMetadataDirectory,
                .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            flushOnUncommittedSegmentsRemoteStoreSettings(true)
        when(shard.getRemoteStoreSettings()).thenReturn(remoteStoreSettings);
            @Override
    public void testSegmentSyncProceedsWhenNotSuperseded() throws Exception {
     * otherwise the cluster default, picked up live from the cluster settings on each publication.
        return mockIndexShardWithRetryAndScheduleRefresh(
        RemoteSegmentTransferTracker tracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
    }
        // Below we are trying to get the IOException thrown in the constructor of the RemoteSegmentStoreDirectory.
    public void testRemoteDirectoryInitThrowsException() throws IOException {
            return true;
            successLatch
            clusterSettings
        RemoteStoreRefreshListener listener = new RemoteStoreRefreshListener(
    }
        CountDownLatch successLatch = new CountDownLatch(2);
     * {@code syncSegments} does past the gate, so it is a precise and deterministic signal, independent of whatever the
     * Snapshot and metadata files created in failed attempt should not break retry.
    }
        int succeedOnAttempt = 1;
import org.opensearch.common.settings.ClusterSettings;
            indexShard.refresh("test");
        CountDownLatch successLatch = new CountDownLatch(3);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            totalAttempt,
                .directory()).getDelegate()).getDelegate();
 * SPDX-License-Identifier: Apache-2.0
            refreshCountLatch,
        setup(true, 1);
        assertEquals(0, tracker.getTotalUploadsFailed());
        newRefreshListenerFor(supersededShard).afterRefresh(true);
            listener.drainRefreshes();
    public void setup(boolean primary, int numberOfDocs) throws IOException {
    }
    private void assertNoLagAndTotalUploadsFailed(RemoteSegmentTransferTracker segmentTracker, long totalUploadsFailed) throws Exception {
    @After
        // success latch should change as we would be failed primary term latest validation.
            public void onResponse(Releasable releasable) {
            SegmentReplicationCheckpointPublisher.EMPTY,
import static org.mockito.ArgumentMatchers.any;
        assertEquals(0, tracker.getInflightUploads());
            spyShard,
import org.opensearch.common.lease.Releasable;
        when(shard.store()).thenReturn(store);
            // the sync itself still ran -- it publishes nothing and instead disarms the condition
            clusterSettings.applySettings(
        int checkpointPublishSucceedOnAttempt,
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
            tracker,
import org.opensearch.common.settings.Settings;
    public void testRefreshFailedDueToPrimaryTermMisMatch() throws Exception {
            assertFalse(remoteStoreSettings.isFlushOnUncommittedSegmentsEnabled());
            refreshCountLatch,
            totalAttempt,
            indexDocs(10, 1);
     * Verifies that a successful segments sync on a shard whose indexer is not an {@link EngineBackedIndexer}
    }
        assertBusy(() -> assertEquals(0, successLatch.getCount()));
        when(shard.shardId()).thenReturn(shardId);
            successLatch,
        }
            closedShard,
import static org.mockito.Mockito.verify;
                assertTrue("expected a publication while enabled", publishes.get() > 0);
        when(remoteStoreSettings.getMinRemoteSegmentMetadataFiles()).thenReturn(10);
                indexShard.refresh("test");
        ShardRouting shardRouting = mock(ShardRouting.class);
                    .build()
            listener.drainRefreshes();
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            threadPool
            remoteMetadataDirectory,
        int succeedOnAttempt = 3;
            // the index sets no threshold, so the cluster value is stamped in
import org.opensearch.common.collect.Tuple;
                        .settings(
            assertTrue(segmentTracker.getTotalUploadsFailed() > 1);
                }
                    IndexMetadata.builder(indexShard.indexSettings().getIndexMetadata())
        IndexShard spyShard = spy(indexShard);
    public void testCleanupTriggeredWhenMapExceedsThreshold() throws IOException {
        setup(true, 3);
        promoteReplica(
        );
            true
            remoteSegmentStoreDirectory.init();
            finalMapSize > initialMapSize
    private ClusterService clusterService;
            // Delete any one file from remote store
            false,
import org.opensearch.cluster.metadata.IndexMetadata;
                throw new RuntimeException("Inducing failure in upload");
    /**
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
            // an explicit per-index threshold wins over the cluster value
        CountDownLatch successLatch = new CountDownLatch(10);
        );
        IndexShard shard = mock(IndexShard.class);
            assertBusy(() -> assertTrue(tracker.getTotalUploadsSucceeded() > 0));
            return indexShard.getLatestReplicationCheckpoint();
            METADATA_FILES_TO_FETCH
            DefaultRemoteStoreSettings.INSTANCE
        doReturn(true).when(supersededShard).isRemoteStoreFenceSuperseded();
        int succeedOnAttempt = 3;
            succeedOnAttempt,
        RemoteStoreStatsTrackerFactory trackerFactory = tuple.v2();
        RemoteSegmentTransferTracker tracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        // Mock (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore().directory())
        doReturn(fencedIndexSettings()).when(supersededShard).indexSettings();
        when(remoteStore.directory()).thenReturn(remoteStoreFilterDirectory);
        SegmentInfos segmentInfos;
    public void testAfterMultipleCommits() throws IOException {
        assertBusy(() -> assertEquals(0, reachedCheckpointPublishLatch.getCount()));
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
import static org.mockito.Mockito.doAnswer;
        doAnswer((invocation -> {
                    if (oneFileDeleted == false && RemoteStoreRefreshListener.EXCLUDE_FILES.contains(file) == false) {
        try {
        flushShard(indexShard);
     * Verifies that turning {@code cluster.remote_store.flush_on_uncommitted_segments.enabled} off on a shard that was
        } finally {
    public void testRefreshAfterCommit() throws IOException {
        return new IndexSettings(fenced, indexShard.indexSettings().getNodeSettings());
        Store store = mock(Store.class);
                refreshCountLatch.countDown();
        int succeedCheckpointPublishOnAttempt,
        }
        CountDownLatch refreshCountLatch,
            spyShard,
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
            .put(SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
 *
        doAnswer(invocation -> {
        Settings indexSettings = Settings.builder()
            Answer<Boolean> answer = invocation -> {
        // Mocking the IndexShard methods and dependent classes.
                throw new RuntimeException("Inducing failure in upload");
        flushShard(indexShard);
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
        Indexer delegatingIndexer = mock(Indexer.class, delegatesTo(indexShard.getIndexer()));
            for (int i = 0; i < 3; i++) {
import java.io.IOException;
            return indexShard.getIndexer();
            }
        CountDownLatch successLatch,
                indexShard.refresh("test");
     * shard's own internal refresh listeners do.
     * value, needed because the switch is disabled by default and has no per-index counterpart to set it through.
        return mockIndexShardWithRetryAndScheduleRefresh(
            tracker,
            }
            }
                logger.error("Failing in get catalog snapshot {}", counter.get());
            spyShard,
            Settings.builder()
            final int publishesAtDisable = publishes.get();
        // Validate that the stream of metadata file of remoteMetadataDirectory has been opened only once and the
                    }
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            listener.drainRefreshes();
            shardId,
    public void testRefreshPersistentFailureAndIndexShardClosed() throws Exception {
        }
        int totalAttempt = 1;
    private RemoteStoreRefreshListener newRefreshListenerFor(IndexShard shard) {
            assertBusy(() -> {
        doAnswer(invocation -> {
    public void testFlushOnUncommittedSegmentsPublishFollowsClusterSwitch() throws Exception {
                .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
        when(shard.store()).thenReturn(store);
        setup(true, 3);
import org.opensearch.index.store.Store;
        );
    }
            if (Objects.nonNull(successLatch)) {
    /**
        );
    }
        assertBusy(() -> assertEquals(0, successLatch.getCount()));
    ) throws IOException {
            // re-enabled: publications resume
        ShardId shardId = new ShardId("index1", "_na_", 1);
        CountDownLatch noOpLatch = new CountDownLatch(0);
    }
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(Settings.EMPTY, clusterSettings);
                    .put(IndexMetadata.SETTING_REMOTE_STORE_FENCING_ENABLED, true)
            }
            RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX,
            listener.afterRefresh(true);
        CountDownLatch reachedCheckpointPublishLatch = new CountDownLatch(0);
        IndexShard shard = mock(IndexShard.class);
        );
        when(shard.state()).thenReturn(IndexShardState.RECOVERING);
    }
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE.getKey(), "256mb")
        // shutdown threadpool for avoid leaking threads
        }
                new HashMap<>()
            remoteSegmentStoreDirectory = (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) indexShard.remoteStore()
        // Mocking the IndexShard methods and dependent classes.
import static org.mockito.Mockito.atLeastOnce;
        clusterService = ClusterServiceUtils.createClusterService(
    public void testNonEngineBackedIndexerSkipsUncommittedSegmentBytesPublish() throws Exception {
            SegmentReplicationCheckpointPublisher.EMPTY,
        // This is the case of isRetry=false, shouldRetry=false
        assertTrue("Map size should be bounded by threshold cleanup, but was: " + mapSize, mapSize < 100);
                                .put(IndexSettings.INDEX_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_THRESHOLD_SIZE_SETTING.getKey(), "64mb")
            if (checkpointPublisherCounter.incrementAndGet() <= succeedCheckpointPublishOnAttempt - 1) {
        );
            successLatch,
            refreshCountLatch,
import org.opensearch.cluster.routing.ShardRouting;
            );
        newRefreshListenerFor(owningShard).afterRefresh(true);
        Store remoteStore = mock(Store.class);
    public void testFlushOnUncommittedSegmentsThresholdPrecedence() throws Exception {
                    }
        );
                    .build()
        int succeedOnAttempt,
                                .put(indexShard.indexSettings().getSettings())
    private IndexSettings fencedIndexSettings() {
        } finally {
            closeShardOnAttempt
     * publication uniformly through the {@link Engine} base type -- where it is a no-op -- without breaking the sync:
        );
import org.opensearch.index.store.RemoteSegmentStoreDirectory;
    }
import org.opensearch.test.ClusterServiceUtils;
        int succeedOnAttempt = 1;
import org.opensearch.index.store.lockmanager.RemoteStoreLockManager;
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        FilterDirectory remoteStoreFilterDirectory = new TestFilterDirectory(new TestFilterDirectory(remoteSegmentStoreDirectory));
    /**
        when(mockSettings.getMinRemoteSegmentMetadataFiles()).thenReturn(10);
        // An unreadable fence: the publish gate reports "not superseded" (fail open), the collection gate reports
    }
            mock(RemoteDirectory.class),
            try (GatedCloseable<SegmentInfos> segmentInfosGatedCloseable = indexShard.getSegmentInfosSnapshot()) {
            remoteStoreSettings
            tracker,
    public void testRefreshSuccessOnFirstAttempt() throws Exception {
            assertTrue("expected the disabled syncs to disarm the condition", disarms.get() > disarmsAtDisable);
                reachedCheckpointPublishLatch.countDown();
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        when(shard.indexSettings()).thenReturn(indexShard.indexSettings());
            successLatch,
    }
            for (String file : segmentInfos.files(true)) {
        } finally {
                .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
        CountDownLatch refreshCountLatch = new CountDownLatch(1);
        doReturn(mockEngine).when(delegatingIndexer).getEngine();
                indexDocs(docId.addAndGet(10), 1);
        try (GatedCloseable<SegmentInfos> segmentInfosGatedCloseable = indexShard.getSegmentInfosSnapshot()) {
            if (listFilesCounter.incrementAndGet() <= 1) {
            new IndexShardRoutingTable.Builder(replicaRouting.shardId()).addShard(replicaRouting).build()
        }
        indexAndRefreshWithoutFlush(100);
        when(shard.routingEntry()).thenReturn(indexShard.routingEntry());
            succeedOnAttempt,
    }
        CountDownLatch reachedCheckpointPublishLatch = new CountDownLatch(0);
    }
    ) throws IOException {
    private void assertNoLag(RemoteSegmentTransferTracker tracker) {
                Settings.builder()
            DefaultRemoteStoreSettings.INSTANCE
        int closeShardAfterAttempt
                .updateIndexMetadata(
        remoteStoreRefreshListener.afterRefresh(true);
        IndexShard shard = mock(IndexShard.class);
            spyShard,
            verify(publisher, atLeastOnce()).publish(any(), any());
        remoteSegmentStoreDirectory.init();
        when(shard.shouldSeedRemoteStore()).thenReturn(true);
     * <p>
            successLatch,
        }).when(mockEngine).clearUncommittedSegmentBytes();
        indexShard = newStartedShard(
import static org.mockito.ArgumentMatchers.anyLong;
        indexDocs(4, 4);
        assertBusy(() -> assertEquals(0, refreshCountLatch.getCount()));
            // This is to check if reading data from remote segment store works as well.
            checkpointPublishSucceedOnAttempt,
        verify(shard, atLeastOnce()).isRemoteStoreFenceSupersededFailingClosed();
        RemoteSegmentStoreDirectory remoteSegmentStoreDirectory = setupDirectoryWithThreshold(-1);
        }
     * Verifies that {@code cluster.remote_store.flush_on_uncommitted_segments.enabled=false} stops the listener from
package org.opensearch.index.shard;
     * Verifies the threshold precedence the listener resolves and stamps into the publication: the per-index
     * internal {@link RemoteStoreRefreshListener} carrying the node's real settings, so a flush-decision assertion
        })).when(shard).computeReplicationCheckpoint(any(CatalogSnapshot.class));
        );
            }
            verifyUploadedSegments(remoteSegmentStoreDirectory);
        int succeedOnAttempt = 2;
                Settings.builder()
        CountDownLatch refreshCountLatch = new CountDownLatch(totalAttempt);
    public void testFenceOwnershipQueriesWithoutFencingEnabled() throws Exception {
        doReturn(delegatingIndexer).when(spyShard).getIndexer();
     */
     * (fail open - the worst case is an orphan) but must skip the stale-segment collection (fail closed - a wrongly
                }
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
                RemoteSegmentStoreDirectory.MetadataFilenameUtils.METADATA_PREFIX,
            boolean oneFileDeleted = false;
import org.opensearch.core.index.shard.ShardId;
    public void testAfterRefresh() throws IOException {
        RemoteStoreRefreshListener listener = tuple.v1();
        );
            refreshCountLatch,
            remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId()),
        assertBusy(() -> assertNoLag(tracker));
        RemoteStoreRefreshListener refreshListener = new RemoteStoreRefreshListener(
            refreshCountLatch,
        );
                .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, "temp-fs")
        try (Store remoteStore = indexShard.remoteStore()) {
     */
                        )
        CountDownLatch refreshCountLatch,
        assertFalse(listener.getRetryScheduledStatus());
        assertBusy(() -> assertNoLag(tracker));
            indexShard.refresh("test");
     * would not isolate the listener under test.
    private RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
            true,
            );
        return mockIndexShardWithRetryAndScheduleRefresh(succeedOnAttempt, null, null);
        doAnswer(invocation -> {
import org.apache.lucene.tests.store.BaseDirectoryWrapper;
            .getRemoteSegmentTransferTracker(indexShard.shardId());
        });
import org.opensearch.index.engine.exec.Indexer;
        when(shard.store()).thenReturn(store);
            successLatch,
        assertFalse("remote store should not in sync", tuple.v1().isRemoteSegmentStoreInSync());
        ((BaseDirectoryWrapper) storeDirectory).setCheckIndexOnClose(false);
import org.apache.lucene.index.IndexFileNames;
import org.opensearch.index.IndexSettings;
        // Value has been set as 3 as during a successful upload IndexShard.getEngine() is hit thrice and with mockito we are counting down
    private RemoteSegmentStoreDirectory setupDirectoryWithThreshold(int threshold) throws IOException {
    }
                    .put(RemoteStoreSettings.CLUSTER_REMOTE_STORE_FLUSH_ON_UNCOMMITTED_SEGMENTS_ENABLED.getKey(), true)
        assertEquals(0, tracker.getBytesLag());
        );
import org.opensearch.index.remote.RemoteSegmentTransferTracker;
import org.opensearch.index.engine.NRTReplicationEngineFactory;
        verify(remoteMetadataDirectory, times(2)).listFilesByPrefixInLexicographicOrder(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            true,
            tracker,
                indexDocs(docId.addAndGet(10), 1);
        listener.afterRefresh(true);
        // Succeed on 1st attempt
import static org.mockito.Mockito.when;
    private void indexAndRefreshWithoutFlush(int iterations) throws IOException {
        RemoteSegmentTransferTracker segmentTracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        IndexShard spyShard = spy(indexShard);
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
        IndexShard spyShard = spy(indexShard);
        }
        when(shard.shardId()).thenReturn(shardId);
        indexDocs(1, 3);
        // Succeed on 3rd attempt
        assertFalse("remote store should not in sync", listener.isRemoteSegmentStoreInSync());
        // Giving 10ms for some iterations of remote refresh upload
                listener.afterRefresh(true);
    }
        remoteStoreStatsTrackerFactory.afterIndexShardCreated(indexShard);
                (RemoteSegmentStoreDirectory) ((FilterDirectory) ((FilterDirectory) remoteStore.directory()).getDelegate()).getDelegate();
        assertBusy(() -> {
            listener.afterRefresh(true);
        for (int i = 0; i < indexShard.getRemoteStoreSettings().getMinRemoteSegmentMetadataFiles() + 3; i++) {
        }
import org.apache.lucene.store.Directory;
import java.util.Collections;
        Tuple<RemoteStoreRefreshListener, RemoteStoreStatsTrackerFactory> tuple = mockIndexShardWithRetryAndScheduleRefresh(
        doAnswer(invocation -> {
import org.opensearch.indices.recovery.RecoveryState;
        RemoteStoreSettings remoteStoreSettings = new RemoteStoreSettings(
     * control -- that an enabled sync does publish -- is
        when(mockSettings.getClusterRemoteSegmentTransferTimeout()).thenReturn(TimeValue.timeValueMinutes(30));
            false,
    }
            spyShard,
        indexShard = newStartedShard(
        RemoteSegmentTransferTracker segmentTracker = trackerFactory.getRemoteSegmentTransferTracker(indexShard.shardId());
        CountDownLatch refreshCountLatch = new CountDownLatch(succeedOnAttempt);
        CountDownLatch successLatch,
            shard,
     * Asserted on the code path rather than on side effects: reaching the catalog snapshot is the first thing
            remoteStoreSettings
    public void testRefreshSuccessAfterFailureInFirstAttemptAfterSnapshotAndMetadataUpload() throws Exception {
        );
            assertEquals(totalUploadsFailed, segmentTracker.getTotalUploadsFailed());
        );
            );
            RemoteSegmentStoreDirectory remoteSegmentStoreDirectory =
        );
            DefaultRemoteStoreSettings.INSTANCE
        );
        int checkpointPublishSucceedOnAttempt = 0;
        doReturn(delegatingIndexer).when(spyShard).getIndexer();
            successLatch
                if (file.startsWith(IndexFileNames.SEGMENTS)) {
                ActionListener<Void> actionListener = invocation.getArgument(5);
            when(shard.getOperationPrimaryTerm()).thenReturn(indexShard.getOperationPrimaryTerm());
                releasable.close();
        when(shard.routingEntry()).thenReturn(shardRouting);
                        .build()
    ) throws IOException {
            }
        AtomicLong listFilesCounter = new AtomicLong();
        EngineBackedIndexer delegatingIndexer = mock(EngineBackedIndexer.class, delegatesTo(indexShard.getIndexer()));
                assertTrue("expected publications to resume", publishes.get() > publishesAtDisable);
            // enabled: a sync publishes
        );
        );
        assertBusy(() -> assertEquals(0, successLatch.getCount()));
    /**
        // We spy on IndexShard.isPrimaryStarted() to validate that we have tried running remote time as per the expectation.
            Collections.singleton(replicaRouting.allocationId().getId()),
        assertTrue(remoteStoreRefreshListener.isLocalOrSnapshotRecoveryOrSeeding());
        when(shard.getThreadPool()).thenReturn(threadPool);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
            indexShard.indexSettings()
        super.tearDown();
     * Asserted on the publication call rather than on {@code shouldPeriodicallyFlush()}: the shard installs its own
import org.opensearch.threadpool.ThreadPool;
        // We spy on IndexShard.getEngine() to validate that we have successfully hit the terminal code for ascertaining successful upload.
        int succeedOnAttempt,
        CountDownLatch successLatch = new CountDownLatch(3);
import org.opensearch.index.engine.InternalEngineFactory;
        IndexShard spyShard = spy(indexShard);
        setup(false, 3);
        // The gate was consulted, and nothing past it ran: syncSegments reads the shard's remote store settings for
        when(remoteStore.directory()).thenReturn(remoteStoreFilterDirectory);
        indexShard.refresh("test");
                mock(RemoteDirectory.class),
import org.opensearch.index.store.RemoteDirectory;
        // Mock indexShard.getCatalogSnapshot()
        RemoteSegmentTransferTracker tracker = indexShard.getRemoteStoreStatsTrackerFactory()
        );
        doReturn(false).when(owningShard).isRemoteStoreFenceSupersededFailingClosed();
            DefaultRemoteStoreSettings.INSTANCE
    }
                remoteDirectory,
