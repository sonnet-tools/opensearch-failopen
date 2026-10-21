            ) {
            assertTrue(thirdCommit.getGeneration() > secondCommit.getGeneration());
    public void testNRTReplicaWithRemoteStorePromotedAsPrimaryRefreshRefresh() throws Exception {
                replica,
        final IndexShard primaryShard = shards.getPrimary();
import org.opensearch.cluster.ClusterChangedEvent;
            // ensure primary has uploaded something
                        boolean sendShardFailure
        try (ReplicationGroup shards = createGroup(0, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), remotePath)) {
                .map(metadata -> metadata.name())
public class RemoteIndexShardTests extends SegmentReplicationIndexShardTests {
            // restart the primary
                flushShard(primary);
            shards.indexDocs(1);
            );
import org.opensearch.indices.replication.CheckpointInfoResponse;
        // TODO: wait for remote store to support merged segment warmer
        assertFalse(primary.hasRefreshPending());
            shards.promoteReplicaToPrimary(nextPrimary).get();
        }
                ActionListener<CheckpointInfoResponse> listener
            assertTrue("Files should not be committed", activeFiles.isEmpty());
            logger.info(List.of(replica.store().directory().listAll()));
                    containsInAnyOrder("_0.cfe", "_0.si", "_0.cfs")
import org.opensearch.indices.replication.SegmentReplicationState;
import org.opensearch.test.CorruptionUtils;
                .values()
            // Start first round of segment replication. This should fail with simulated error but with replica having
            final SegmentInfos secondCommit = store.readLastCommittedSegmentsInfo();
                break;
                long replicationId,
                IndexShard indexShard,
import org.apache.lucene.util.Version;
            replicateSegments(primary, List.of(replica));
                    @Override
            String fileToCorrupt = null;
            } else {
 * compatible open source license.
            shardsService.clusterChanged(new ClusterChangedEvent("test", initState, clusterService.state()));
        // ensure search idle conditions are met.
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            for (String file : replica.store().directory().listAll()) {
            assertEquals(target.state().getStage(), SegmentReplicationState.Stage.GET_FILES);
import org.opensearch.core.action.ActionListener;
            for (IndexShard shard : shards.getReplicas()) {
            }
            public String getDescription() {
    /**
                    public void onReplicationDone(SegmentReplicationState state) {
                    segmentInfosSnapshot.get().files(false),
        ) {
            shards.refresh("test");
            // at this point both shards should have numDocs persisted and searchable.
    }
            if (randomBoolean()) {
                List<StoreFileMetadata> filesToFetch,
            MatcherAssert.assertThat(
     * This test validates that local non-readable (corrupt, partially) on disk are deleted vs failing the
                shards.getIndexMetadata(),
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/19436")
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(primary.getSegmentMetadataMap(), replica.getSegmentMetadataMap());
import static org.mockito.ArgumentMatchers.any;
                        waitOnReplicationCompletion.countDown();
            final SegmentInfos latestReplicaCommit = SegmentInfos.readLatestCommit(replica.store().directory());
                super.getCheckpointMetadata(replicationId, checkpoint, listener);
                new SegmentReplicationTargetService.SegmentReplicationListener() {
            final SegmentInfos segmentCommitInfos = replica.store().readLastCommittedSegmentsInfo();
            );
                listener.onResponse(snapshotStatus.generation());
            public void getSegmentFiles(
    }
            IndexShard primary = shards.getPrimary();
    }
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(metadataBeforeRestart, primary.getSegmentMetadataMap());
import static org.mockito.ArgumentMatchers.anyLong;
            try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = replicaEngine.getSegmentInfosSnapshot()) {
            );
                StepListener<GetSegmentFilesResponse> waitForCopyFilesListener = new StepListener();
            final int numDocs = shards.indexDocs(randomInt(10));
                replica.getSegmentMetadataMap()
    @Override
    }
                    "test",
import org.opensearch.indices.replication.RemoteStoreReplicationSource;
            } else {
            final SegmentInfos latestCommit = SegmentInfos.readLatestCommit(primary.store().directory());
            ) {
                long replicationId,
            final ClusterState initState = addSnapshotIndex(
                Set.of("segments_1"),
                assertDocCounts(shard, totalDocs, 0);
            );
            // get a metadata map - we'll use segrep diff to ensure segments on reader are identical after restart.
            final Snapshot snapshot1 = new Snapshot(
                new SegmentReplicationTargetService.SegmentReplicationListener() {
import org.opensearch.indices.replication.GetSegmentFilesResponse;
                        logger.error("Replication error", e);
            assertEquals("Files should be copied to disk", false, onDiskFiles.isEmpty());
            final IndexShard replica = shards.getReplicas().get(0);
            assertTrue(nextPrimary.translogStats().getUncommittedOperations() >= additonalDocs);
import static org.hamcrest.Matchers.containsInAnyOrder;
            waitOnReplicationCompletion.await();
    public void testRepicaCleansUpOldCommitsWhenReceivingNew() throws Exception {
import org.opensearch.common.settings.Settings;
            shards.indexDocs(10);
                        latch.countDown();
    public void testPrimaryRestart_PrimaryHasExtraCommits() throws Exception {
    /**
import org.opensearch.index.store.Store;
        testNRTReplicaWithRemoteStorePromotedAsPrimary(false, false);
                oldPrimary.refresh("Test");
            Path shardPath = replica.shardPath().getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
            final SegmentReplicationTarget target = targetService.startReplication(
        final Path remotePath = createTempDir();
        return settings;
            final IndexShard replica = shards.getReplicas().get(0);
        .build();
            shards.indexDocs(1);
            assertSingleSegmentFile(replica);
        replicateSegments(primaryShard, shards.getReplicas());
     */
                    replicationId,
                        waitForSecondRound.countDown();
                    indexShard,
            replica.store().createEmpty(Version.LATEST);
                clusterService.state(),
        }
package org.opensearch.index.shard;
            ReplicationGroup shards = createGroup(1, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), createTempDir())
                assertAtMostOneLuceneDocumentPerSequenceNumber(getEngine(replicaShard));
                        boolean sendShardFailure
        }
                    public void onReplicationDone(SegmentReplicationState state) {
            closeShards(replica);
            shards.removeReplica(replica);
                flushShard(oldPrimary, true);
            } else {
                    snapshotStatus.moveToStarted(startTime, 0, indexTotalNumberOfFiles, 0, indexTotalFileSize);
     * This test validates that unreferenced on disk file are ignored while requesting files from replication source to
                ActionListener<String> listener = invocation.getArgument(10);
                    "Segments are referenced in memory",
                replica.store().readLastCommittedSegmentsInfo().files(true)
                repositoriesService
                        waitForSecondRound.countDown();
                assertDocCounts(shard, numDocs, 0);
    private static final Settings settings = Settings.builder()
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
                    postGetFilesRunnable.run();
     */
            when(sourceFactory.get(any())).thenReturn(
            assertTrue("Replica should have consistent disk & reader", activeFiles.containsAll(onDiskFiles));
    @Override
            assertTrue(recoveryDiff.different.isEmpty());
import static org.hamcrest.Matchers.equalTo;
                flushShard(primary);
        testNRTReplicaWithRemoteStorePromotedAsPrimary(true, true);
            );
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
                ReplicationCheckpoint checkpoint,
            }
            assertDocCount(replica, 3);
                primary.getLatestReplicationCheckpoint(),
import java.nio.channels.FileChannel;
                }, listener::onFailure);
            assertEquals(newTarget.state().getStage(), SegmentReplicationState.Stage.DONE);
        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
            assertDocCount(replica, 1);
            assertTrue(nextPrimary.translogStats().estimatedNumberOfOperations() >= additonalDocs);
            // clean up
            if (performFlushSecond) {
            }
            for (IndexShard shard : shards) {
            assertTrue(diff.different.isEmpty());
                    return null;
    }
            shards.startPrimary();
            assertNotNull(replicaEngine);
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
import org.junit.Assert;
        return createGroup(numberOfReplicas, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir());
        super.testMergedSegmentReplicationWithZeroReplica();
                        Assert.fail("Replication should fail with simulated error");
}
            assertDocCount(primary, 2 * docCount);
                        SegmentReplicationState state,
                primary.refresh("test");
import org.opensearch.indices.replication.common.ReplicationType;
        }
            shards.indexDocs(10);
                if (indexFilesToFileLengthMap != null) {
            final IndexShard primaryShard = shards.getPrimary();
import java.util.Arrays;
        // TODO: wait for remote store to support merged segment warmer
        super.testMergedSegmentReplication();
    }
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
                    public void onReplicationFailure(
            shards.refresh("test");
    }
                primary.remoteStore().readLastCommittedSegmentsInfo().files(true)
                    ) {
                return "TestRemoteStoreReplicationSource";
                    checkpoint,
                primary.getLatestReplicationCheckpoint(),
            assertTrue(diff.different.isEmpty());
            shards.startAll();
import org.opensearch.common.concurrent.GatedCloseable;
            latestPrimaryCommit.commit(primary.store().directory());
        ReplicationGroup shards = createGroup(1, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir());
                new ClusterChangedEvent(
    private RemoteStoreReplicationSource getRemoteStoreReplicationSource(IndexShard shard, Runnable postGetFilesRunnable) {
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/18255")
            }
                primary.refresh("test");
            final IndexShard replica = shards.addReplica(remotePath);
        testNRTReplicaWithRemoteStorePromotedAsPrimary(true, false);
            replicateSegments(primary, shards.getReplicas());
            replicateSegments(primary, shards.getReplicas());
import java.io.IOException;
                primaryShard,
                    continue;
                return null;
                }
            nextPrimary.refresh("test");
    public void testReplicaCommitsInfosBytesOnRecovery() throws Exception {
            assertDocCounts(oldPrimary, numDocs, numDocs);
            List<String> activeFiles = replica.getSegmentMetadataMap()
            }
        // TODO: wait for remote store to support merged segment warmer
            doAnswer(invocation -> {
     * round of segment replication by ensuring doc count.
                new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5))
import org.hamcrest.MatcherAssert;
                replica,
                    snapshotStatus.moveToFinalize(commitGeneration);
                getRemoteStoreReplicationSource(replica, () -> { throw new RuntimeException("Simulated"); })
                        logger.error("Replication error", e);
            try {
import java.util.Map;
                ReplicationCheckpoint checkpoint,
            primary.refresh("Test");
import java.util.function.BiConsumer;
            final int totalDocs = numDocs + additonalDocs;
            replicateSegments(primary, shards.getReplicas());
            shards.startAll();
import java.util.HashSet;
    }
                final IndexShardSnapshotStatus.Copy copy = shardsService.currentSnapshotShards(snapshot1)
                snapshot1,
                    CorruptionUtils.corruptAt(shardPath.resolve(file), raf, (int) (raf.size() - 8));
                        SegmentReplicationState state,
            @Override
                primary.getSegmentMetadataMap(),
            // persisted.
                    snapshotStatus.moveToDone(System.currentTimeMillis(), snapshotStatus.generation());
            final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());
                        Assert.fail("Replication should not fail");
                        boolean sendShardFailure
     * committing locally so that in next round of segment replication those files are not considered for download again
                    containsInAnyOrder("_0.cfe", "_0.si", "_0.cfs")
            IndexShard primary = shards.getPrimary();
            assertDocCounts(nextPrimary, totalDocs, totalDocs);
                );
            assertTrue(diff.different.isEmpty());
                    // Not performing actual snapshot, just modifying the state
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;
            shards.indexDocs(10);
        .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, REPOSITORY_NAME)
            shards.startAll();
import java.util.concurrent.CountDownLatch;
    public void testNRTReplicaWithRemoteStorePromotedAsPrimaryCommitCommit() throws Exception {
            assertTrue(diff.different.isEmpty());
     * prevent FileAlreadyExistsException. It does so by only copying files in first round of segment replication without
            }
    protected void validateShardIdleWithNoReplicas(IndexShard primary) {
            flushShard(primary);
import java.util.stream.Collectors;
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
            final SegmentInfos thirdCommit = store.readLastCommittedSegmentsInfo();
                primary.getLatestReplicationCheckpoint(),
import org.opensearch.index.engine.Engine;
            assertTrue(recoveryDiff.missing.isEmpty());
            assertEquals(
        return new RemoteStoreReplicationSource(shard) {
    public void testNRTReplicaWithRemoteStorePromotedAsPrimary(boolean performFlushFirst, boolean performFlushSecond) throws Exception {
        final Set<String> segmentsFileNames = Arrays.stream(shard.store().directory().listAll())
                }
            if (shard != null) {
                "Latest remote commit On-disk commit references no segments",
                    public void onReplicationFailure(
import org.opensearch.indices.replication.SegmentReplicationTarget;
                    }
                BiConsumer<String, Long> fileProgressTracker,
            assertDocCount(primary, 10);
    public void testCleanupRedundantPendingMergeSegment() throws Exception {
            shardsService.clusterChanged(
import org.opensearch.index.engine.DocIdSeqNoAndSource;
            assertEquals(
            }
            );
            final Engine replicaEngine = getEngine(replica);
            // Ingest more data and start next round of segment replication
            // 2. Create ops that are in the replica's xlog, not in the index.
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.indices.replication.SegmentReplicationTargetService;
            primary = shards.getPrimary();
            assertTrue(diff.missing.isEmpty());
        for (IndexShard shard : shards) {
    public void testMergedSegmentReplicationWithZeroReplica() throws Exception {
import java.util.Set;
        final IndexShard replicaShard = shards.getReplicas().get(0);
            assertEquals(store.readLastCommittedSegmentsInfo().getGeneration(), secondCommit.getGeneration());
                final Map<String, Long> indexFilesToFileLengthMap = invocation.getArgument(9);
        }
            if (randomBoolean()) {
            assertTrue(secondCommit.getGeneration() > initialCommit.getGeneration());
                    @Override
 * The OpenSearch Contributors require contributions made to
        assertTrue(primary.scheduledRefresh());
            assertDocCount(primary, 10);
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
            } catch (IOException e) {
            flushShard(primary);
            assertEquals(InternalEngine.class, getEngine(nextPrimary).getClass());
                    }
            );
        shards.startPrimary();
            shards.indexDocs(docCount);
            @Override
            closeShards(replica);
            shards.reinitPrimaryShard(remotePath);
                        ReplicationFailedException e,
                closeShard(shard, false);
                        ReplicationFailedException e,
                oldPrimary.refresh("Test");
            final Map<String, StoreFileMetadata> metadataBeforeRestart = primary.getSegmentMetadataMap();
            .collect(Collectors.toSet());
                    .get(primaryShard.shardId)
                MatcherAssert.assertThat(
import org.apache.lucene.index.IndexFileNames;
                super.getSegmentFiles(
            // restart the primary
            final IndexShard nextPrimary = shards.getReplicas().get(0);
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            public void getCheckpointMetadata(
            );
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/18255")
            shards.indexDocs(10);
    protected Settings getIndexSettings() {
        try (ReplicationGroup shards = createGroup(0, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), remotePath)) {
                    .asCopy();
            assertDocCount(replica, 2 * docCount);
            assertDocCount(primary, 10);
            );
                    int indexTotalNumberOfFiles = fileNames.size();
            latch.await();
            // files in its local store but not in active reader.
    @Override
            shards.removeReplica(replica);
import org.opensearch.action.StepListener;
                    ) {
            IndexShard primary = shards.getPrimary();
            primary.refresh("test");
            } else {
            shards.startPrimary();
    public void testShallowCopySnapshotForClosedIndexSuccessful() throws Exception {
            shards.indexDocs(10);
            }
            int prevOperationCount = nextPrimary.translogStats().estimatedNumberOfOperations();
            final SegmentInfos initialCommit = store.readLastCommittedSegmentsInfo();
import static org.opensearch.index.shard.RemoteStoreRefreshListener.EXCLUDE_FILES;
        shards.indexDocs(10);
import static org.mockito.Mockito.doAnswer;
    }
            }
                    }
        assertFalse(primary.isSearchIdleSupported());
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/18720")
                IndexShardSnapshotStatus snapshotStatus = invocation.getArgument(5);
            // ensure primary has uploaded something
                    @Override
    public void testNoDuplicateSeqNo() throws Exception {
                    @Override
                randomAlphaOfLength(10),
        assertEquals("Expected a single segment file", 1, segmentsFileNames.size());
                new SegmentReplicationTargetService.SegmentReplicationListener() {
                    @Override
                    public void onReplicationDone(SegmentReplicationState state) {
            }
            onDiskFiles.removeIf(name -> EXCLUDE_FILES.contains(name) || name.startsWith(IndexFileNames.SEGMENTS));
                "Replica starts recovery at empty segment 3",
            IndexShard primary = shards.getPrimary();
            }).when(repository)
                    initState
            final IndexShard primary = shards.getPrimary();
            assertDocCount(primary, 10);
import org.opensearch.test.junit.annotations.TestLogging;
            shards.startAll();
import org.opensearch.index.engine.InternalEngine;
                MatcherAssert.assertThat(
                final IndexShardSnapshotStatus.Stage stage = copy.getStage();
                    addSnapshotIndex(clusterService.state(), snapshot1, primaryShard, SnapshotsInProgress.State.STARTED, true),
    }
                    long indexTotalFileSize = indexFilesToFileLengthMap.values().stream().mapToLong(Long::longValue).sum();
            // the store is open at this point but the shard has not yet run through recovery
            logger.info("--> Starting second round of replication");
            );
            when(sourceFactory.get(any())).thenReturn(getRemoteStoreReplicationSource(replica, () -> {}));
        try (ReplicationGroup shards = createGroup(0, settings)) {
        }
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(primary.getSegmentMetadataMap(), replica.getSegmentMetadataMap());
            shards.reinitPrimaryShard(remotePath);
    }
            final IndexShard primary = shards.getPrimary();
                true,
                        Assert.fail("Replication should fail with simulated error");
                    List<String> fileNames = new ArrayList<>(indexFilesToFileLengthMap.keySet());
                .snapshotRemoteStoreIndexShard(any(), any(), any(), any(), any(), any(), anyLong(), anyLong(), anyLong(), any(), any());
            final Store.RecoveryDiff recoveryDiff = Store.segmentReplicationDiff(
            });
import org.opensearch.snapshots.SnapshotShardsService;
                flushShard(oldPrimary, true);
            BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository("random");
            // refresh and push segments to our other replica.
            // get a metadata map - we'll use segrep diff to ensure segments on reader are identical after restart.
                    @Override
            );
            SegmentInfos latestPrimaryCommit = SegmentInfos.readLatestCommit(primary.store().directory());
import static org.mockito.Mockito.mock;
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
        }
                        latch.countDown();
        replicateSegments(primaryShard, shards.getReplicas());
                    (fileName, bytesRecovered) -> {},
                        SegmentReplicationState state,
            shards.indexDocs(docCount);
            @Override
                    ) {
                    }
                long commitGeneration = invocation.getArgument(7);
            // ensure primary has uploaded something
            logger.info("--> Starting first round of replication");
import org.opensearch.index.store.StoreFileMetadata;
import org.opensearch.indices.replication.common.ReplicationFailedException;
        final Path remotePath = createTempDir();
            shards.flush();
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
            // 1. Create ops that are in the index and xlog of both shards but not yet part of a commit point.
/*
    @Override
import java.util.ArrayList;
                    listener.onResponse(snapshotStatus.generation());
                    "Segments are referenced in memory only",
                assertEquals(IndexShardSnapshotStatus.Stage.DONE, stage);
        final Path remotePath = createTempDir();
 *
    public void testNRTReplicaWithRemoteStorePromotedAsPrimaryRefreshCommit() throws Exception {
            primary.refresh("Test");
            // start the snapshot
                getRemoteStoreReplicationSource(replica, () -> { throw new RuntimeException("Simulated"); })
        latch.await();
            }
        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, REPOSITORY_NAME)
            try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryEngine.getSegmentInfosSnapshot()) {
 * SPDX-License-Identifier: Apache-2.0
        testNRTReplicaWithRemoteStorePromotedAsPrimary(false, true);
            // Check the snapshot got completed successfully
            // Start first round of segment replication. This should fail with simulated error but with replica having
        try (ReplicationGroup shards = createGroup(0, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), remotePath)) {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.snapshots.SnapshotId;
                    }
            // refresh but do not copy the segments over.
import org.opensearch.index.engine.NRTReplicationEngineFactory;
            // files in its local store but not in active reader.
                );
            CountDownLatch waitOnReplicationCompletion = new CountDownLatch(1);
                        ReplicationFailedException e,
            }
import org.apache.lucene.index.SegmentInfos;
                latestReplicaCommit.files(true),
            }
import static org.opensearch.index.engine.EngineTestCase.assertAtMostOneLuceneDocumentPerSequenceNumber;
            for (IndexShard shard : shards.getReplicas()) {
            oldPrimary.store().close();
            .filter(file -> file.startsWith(IndexFileNames.SEGMENTS))
    @Override
            CountDownLatch waitForSecondRound = new CountDownLatch(1);
                    }
    public void testNRTReplicaWithRemoteStorePromotedAsPrimaryCommitRefresh() throws Exception {
        shards.promoteReplicaToPrimary(replicaShard, (shard, listener) -> {
            latch.countDown();
                containsInAnyOrder("_0.cfe", "_0.si", "_0.cfs", "segments_6")
                replica,
        final Path remotePath = createTempDir();
            }
    private void assertSingleSegmentFile(IndexShard shard) throws IOException {
    public void testMergedSegmentReplicationWithException() throws Exception {
            SegmentReplicationTarget segmentReplicationTarget = targetService.startReplication(
        }
        replicateSegments(primaryShard, shards.getReplicas());
            assertBusy(() -> { assertEquals("Target should be closed", 0, segmentReplicationTarget.refCount()); });
                Set.of("segments_3"),
            latestPrimaryCommit = SegmentInfos.readLatestCommit(primary.store().directory());
            Set<String> onDiskFiles = new HashSet<>(Arrays.asList(replica.store().directory().listAll()));
        shards.startAll();
            // promote the replica
            assertDocCount(primary, 1);
 */
        primaryShard.refresh("test");
        flushShard(primaryShard);
import org.opensearch.cluster.ClusterState;
            oldPrimary.close("demoted", false, false);
            assertSingleSegmentFile(replica);
                true
            assertBusy(() -> {
                }
            shards.startAll();
            // Corrupt one data file
                )
     * blocking update of reader. Once this is done, it corrupts one segment file and ensure that file is deleted in next
            when(sourceFactory.get(any())).thenReturn(
            final int docCount = 10;
            segmentCommitInfos.commit(replica.store().directory());
                long startTime = invocation.getArgument(8);
        });
                    segmentInfosSnapshot.get().files(false),
    }
            IndexShard oldPrimary = shards.getPrimary();
            shards.startAll();
    }
            activeFiles = replica.getSegmentMetadataMap().values().stream().map(metadata -> metadata.name()).collect(Collectors.toList());
    }
        super.testMergedSegmentReplicationWithException();
                .collect(Collectors.toList());
        };
    public void testMergedSegmentReplication() throws Exception {
            primary = shards.getPrimary();
            final SegmentReplicationTarget newTarget = targetService.startReplication(
            segmentCommitInfos.commit(replica.store().directory());
                logger.info("--> Corrupting file {}", fileToCorrupt);
            );
                waitForCopyFilesListener.whenComplete(response -> {
        super.testCleanupRedundantPendingMergeSegment();
    public void testPrimaryRestart() throws Exception {
                );
    }
            assertTrue(diff.missing.isEmpty());
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(metadataBeforeRestart, primary.getSegmentMetadataMap());
        shards.indexDocs(10);
            final IndexShard replica = shards.getReplicas().get(0);
            primary.refresh("Post corruption");
            final Store store = replica.store();
import java.nio.file.Path;
            Assert.assertNotNull(fileToCorrupt);
        try (
import java.util.List;
    }
        assertTrue(primary.isSearchIdle());
            assertTrue(diff.missing.isEmpty());
    }
            // close oldPrimary.
                }
import org.opensearch.repositories.RepositoriesService;
            CountDownLatch latch = new CountDownLatch(1);
            assertNotNull(primaryEngine);
                        assertFalse(sendShardFailure);
            final Engine primaryEngine = getEngine(primary);
        CountDownLatch latch = new CountDownLatch(1);
            waitForSecondRound.await();
                ActionListener<GetSegmentFilesResponse> listener
                if (file.equals("write.lock") || file.startsWith("extra") || file.startsWith("segment")) {
    }
            assertDocCount(replica, 2);
            // index some more into both but don't replicate. replica will have only numDocs searchable, but should have totalDocs
import org.opensearch.repositories.blobstore.BlobStoreRepository;
                fileToCorrupt = file;
                }
    }
                        waitOnReplicationCompletion.countDown();
            if (performFlushFirst) {
            }
import static org.mockito.Mockito.when;
        }
            assertTrue(diff.missing.isEmpty());
            for (IndexShard shard : shards.getReplicas()) {
            }
            );
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
    }
import java.nio.file.StandardOpenOption;
            logger.info("DIFF FILE {}", diff.different);
    public void testSegRepSucceedsOnPreviousCopiedFiles() throws Exception {
    }
                replica.store().readLastCommittedSegmentsInfo().files(true)
            latestPrimaryCommit.commit(primary.store().directory());
                "Replica starts at empty segment 2",
            // Start next round of segment replication and not throwing exception resulting in commit on replica
            shards.assertAllEqual(10);
     * replication event. This test mimics local files (not referenced by reader) by throwing exception post file copy and
            // replicateSegments(primary, shards.getReplicas());
                .stream()
            shards.startAll();
    private static final String REPOSITORY_NAME = "temp-fs";
            );
    }
import org.opensearch.cluster.metadata.IndexMetadata;
                "Replica commits infos bytes referencing latest refresh point",
                primaryShard,
            assertEquals("On-disk commit references no segments", Set.of("segments_3"), latestCommit.files(true));
            shards.startAll();
                }
import org.opensearch.cluster.SnapshotsInProgress;
                try (FileChannel raf = FileChannel.open(shardPath.resolve(file), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            shards.indexDocs(1);
            final int additonalDocs = shards.indexDocs(randomInt(10));
                throw new RuntimeException(e);
            // Initialize the shallow copy snapshot
            assertDocCounts(oldPrimary, totalDocs, totalDocs);
            final SnapshotShardsService shardsService = getSnapshotShardsService(
                    waitForCopyFilesListener
                    filesToFetch,
import org.opensearch.snapshots.Snapshot;
    public void testNoFailuresOnFileReads() throws Exception {
            RepositoriesService repositoriesService = createRepositoriesService();
            assertEquals(
                    listener.onResponse(response);
            final Map<String, StoreFileMetadata> metadataBeforeRestart = primary.getSegmentMetadataMap();
                    public void onReplicationFailure(
                SnapshotsInProgress.State.INIT,
                        assertFalse(sendShardFailure);
            assertSingleSegmentFile(replica);
    protected ReplicationGroup getReplicationGroup(int numberOfReplicas) throws IOException {
            shards.recoverReplica(replica);
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), remotePath)) {
            // commit replica infos so it has a conflicting commit with remote.
                Set.of("segments_3"),
        shards.indexDocs(10);
            // the store is open at this point but the shard has not yet run through recovery
