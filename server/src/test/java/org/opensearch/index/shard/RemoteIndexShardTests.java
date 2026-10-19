    }
    public void testNRTReplicaWithRemoteStorePromotedAsPrimary(boolean performFlushFirst, boolean performFlushSecond) throws Exception {
                        boolean sendShardFailure
     * replication event. This test mimics local files (not referenced by reader) by throwing exception post file copy and
            Set<String> onDiskFiles = new HashSet<>(Arrays.asList(replica.store().directory().listAll()));
                "Latest remote commit On-disk commit references no segments",
                flushShard(primary);
        return new RemoteStoreReplicationSource(shard) {
            assertTrue(diff.missing.isEmpty());  
            final SegmentInfos thirdCommit = store.readLastCommittedSegmentsInfo();
                return "TestRemoteStoreReplicationSource";
                waitForCopyFilesListener.whenComplete(response -> {
        assertTrue(primary.scheduledRefresh());
            shards.indexDocs(10);
            assertTrue(recoveryDiff.different.isEmpty());
            assertTrue(nextPrimary.translogStats().getUncommittedOperations() >= additonalDocs);  
            primary.refresh("Post corruption");
            shards.indexDocs(1);
            @Override
     * blocking update of reader. Once this is done, it corrupts one segment file and ensure that file is deleted in next
            }
            CountDownLatch waitOnReplicationCompletion = new CountDownLatch(1);
            // Corrupt one data file  
                assertAtMostOneLuceneDocumentPerSequenceNumber(getEngine(replicaShard));  
    }
            }
                    @Override
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/18255")  
            // get a metadata map - we'll use segrep diff to ensure segments on reader are identical after restart.
            assertBusy(() -> {
            final int additonalDocs = shards.indexDocs(randomInt(10));
    }
            shards.startAll();
            } else {  
                final IndexShardSnapshotStatus.Stage stage = copy.getStage();  
            }  
            );
            assertDocCount(primary, 2 * docCount);
            assertTrue(nextPrimary.translogStats().estimatedNumberOfOperations() >= additonalDocs);
            assertTrue(diff.different.isEmpty());
import org.opensearch.repositories.blobstore.BlobStoreRepository;  
    }
            }
                snapshot1,  
            } catch (IOException e) {
                "Replica commits infos bytes referencing latest refresh point",
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
            shards.refresh("test");
        shards.indexDocs(10);
                ActionListener<GetSegmentFilesResponse> listener  
                    initState  
            shards.flush();  
        shards.startAll();  
                        waitForSecondRound.countDown();
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(metadataBeforeRestart, primary.getSegmentMetadataMap());
                MatcherAssert.assertThat(
                Set.of("segments_3"),
                repositoriesService
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {  
import org.apache.lucene.index.SegmentInfos;
    private static final Settings settings = Settings.builder()  
     * prevent FileAlreadyExistsException. It does so by only copying files in first round of segment replication without
            waitForSecondRound.await();
            // restart the primary
                        assertFalse(sendShardFailure);
                containsInAnyOrder("_0.cfe", "_0.si", "_0.cfs", "segments_6")
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/18255")
    }
            );  
                primary.getLatestReplicationCheckpoint(),
import org.opensearch.cluster.ClusterChangedEvent;
            assertDocCount(replica, 1);  
import org.opensearch.repositories.RepositoriesService;
import org.opensearch.action.StepListener;
            shards.startAll();  
            // refresh and push segments to our other replica.
                    waitForCopyFilesListener  
            assertDocCount(replica, 2 * docCount);  
                    public void onReplicationFailure(
                new SegmentReplicationTargetService.SegmentReplicationListener() {  
            IndexShard primary = shards.getPrimary();
        try (
 * The OpenSearch Contributors require contributions made to  
     * This test validates that unreferenced on disk file are ignored while requesting files from replication source to
        ReplicationGroup shards = createGroup(1, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir());
            shards.indexDocs(10);
                "Replica starts recovery at empty segment 3",
            // files in its local store but not in active reader.
                    int indexTotalNumberOfFiles = fileNames.size();  
            final int docCount = 10;
                throw new RuntimeException(e);
                    (fileName, bytesRecovered) -> {},
            assertBusy(() -> { assertEquals("Target should be closed", 0, segmentReplicationTarget.refCount()); });
            if (performFlushFirst) {
                }, listener::onFailure);
                    }
 * SPDX-License-Identifier: Apache-2.0
            final SegmentInfos segmentCommitInfos = replica.store().readLastCommittedSegmentsInfo();
                    snapshotStatus.moveToStarted(startTime, 0, indexTotalNumberOfFiles, 0, indexTotalFileSize);
            shards.recoverReplica(replica);
                new SegmentReplicationTargetService.SegmentReplicationListener() {  
        final IndexShard primaryShard = shards.getPrimary();  
            shards.assertAllEqual(10);
        }  
import org.opensearch.indices.replication.SegmentReplicationTarget;  
    }
            for (IndexShard shard : shards.getReplicas()) {
    public void testReplicaCommitsInfosBytesOnRecovery() throws Exception {
                MatcherAssert.assertThat(
            try {
            .collect(Collectors.toSet());  
        }
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(primary.getSegmentMetadataMap(), replica.getSegmentMetadataMap());
                flushShard(oldPrimary, true);
            // the store is open at this point but the shard has not yet run through recovery
            } else {
            // the store is open at this point but the shard has not yet run through recovery
import org.opensearch.indices.replication.SegmentReplicationTargetService;
                        SegmentReplicationState state,
        .put(IndexMetadata.SETTING_REMOTE_SEGMENT_STORE_REPOSITORY, REPOSITORY_NAME)  
                }
                primaryShard,
            shards.indexDocs(10);
    @Override
                    @Override
            final SegmentReplicationTarget target = targetService.startReplication(  
            // Start first round of segment replication. This should fail with simulated error but with replica having
            // files in its local store but not in active reader.
            }
            // close oldPrimary.
            }  
            // Start next round of segment replication and not throwing exception resulting in commit on replica
            segmentCommitInfos.commit(replica.store().directory());  
import java.util.ArrayList;
            assertTrue(recoveryDiff.missing.isEmpty());
     */
            shards.indexDocs(1);
import java.util.stream.Collectors;  
                    }
    public void testNoDuplicateSeqNo() throws Exception {  
            Assert.assertNotNull(fileToCorrupt);
            final IndexShard primaryShard = shards.getPrimary();
                if (file.equals("write.lock") || file.startsWith("extra") || file.startsWith("segment")) {  
    public void testMergedSegmentReplicationWithException() throws Exception {  
                        Assert.fail("Replication should fail with simulated error");
                super.getSegmentFiles(  
                fileToCorrupt = file;  
            shards.startAll();
            assertEquals(target.state().getStage(), SegmentReplicationState.Stage.GET_FILES);
        assertFalse(primary.hasRefreshPending());  
            shards.indexDocs(10);
            // commit replica infos so it has a conflicting commit with remote.  
                SnapshotsInProgress.State.INIT,
            final IndexShard replica = shards.getReplicas().get(0);  
import java.util.Arrays;
import org.opensearch.cluster.metadata.IndexMetadata;
                new ClusterChangedEvent(  
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(primary.getSegmentMetadataMap(), replica.getSegmentMetadataMap());
            shards.startPrimary();  
            when(sourceFactory.get(any())).thenReturn(getRemoteStoreReplicationSource(replica, () -> {}));
            replicateSegments(primary, shards.getReplicas());
            shards.removeReplica(replica);  
                    segmentInfosSnapshot.get().files(false),  
                    @Override
import org.opensearch.indices.replication.common.ReplicationFailedException;  
                latestReplicaCommit.files(true),  
            );  
                primary.getLatestReplicationCheckpoint(),
            final int numDocs = shards.indexDocs(randomInt(10));
            // ensure primary has uploaded something  
 */  
            MatcherAssert.assertThat(
                getRemoteStoreReplicationSource(replica, () -> { throw new RuntimeException("Simulated"); })  
                return null;  
            shards.startAll();
            final IndexShard replica = shards.getReplicas().get(0);
    }
        return createGroup(numberOfReplicas, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir());  
                }
            );
            final IndexShard replica = shards.getReplicas().get(0);  
                replica.store().readLastCommittedSegmentsInfo().files(true)
            RepositoriesService repositoriesService = createRepositoriesService();  
        super.testCleanupRedundantPendingMergeSegment();  
        final Path remotePath = createTempDir();
import org.opensearch.snapshots.SnapshotId;
import static org.opensearch.index.engine.EngineTestCase.assertAtMostOneLuceneDocumentPerSequenceNumber;
import org.apache.lucene.index.IndexFileNames;
            shards.refresh("test");
                        waitOnReplicationCompletion.countDown();  
            logger.info(List.of(replica.store().directory().listAll()));  
            assertEquals(  
                    snapshotStatus.moveToFinalize(commitGeneration);  
        testNRTReplicaWithRemoteStorePromotedAsPrimary(false, true);
import static org.mockito.ArgumentMatchers.any;  
    public void testShallowCopySnapshotForClosedIndexSuccessful() throws Exception {  
                        SegmentReplicationState state,  
                List<StoreFileMetadata> filesToFetch,  
            shards.startAll();  
                }  
 * compatible open source license.
        try (ReplicationGroup shards = createGroup(0, settings)) {
import java.io.IOException;  
        shards.indexDocs(10);
    }  
import java.util.Map;
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
                }
            assertTrue(diff.missing.isEmpty());  
                long commitGeneration = invocation.getArgument(7);
            );
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {  
                IndexShardSnapshotStatus snapshotStatus = invocation.getArgument(5);
            }
            latestPrimaryCommit.commit(primary.store().directory());
                oldPrimary.refresh("Test");
                    .asCopy();
    public void testMergedSegmentReplicationWithZeroReplica() throws Exception {
import org.opensearch.index.engine.Engine;
    public void testNoFailuresOnFileReads() throws Exception {
                    containsInAnyOrder("_0.cfe", "_0.si", "_0.cfs")
                ReplicationCheckpoint checkpoint,
            assertEquals(InternalEngine.class, getEngine(nextPrimary).getClass());
            shards.reinitPrimaryShard(remotePath);
            IndexShard primary = shards.getPrimary();
            SegmentReplicationTarget segmentReplicationTarget = targetService.startReplication(  
                Set.of("segments_3"),  
            );
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
                    segmentInfosSnapshot.get().files(false),
                replica,
    public void testSegRepSucceedsOnPreviousCopiedFiles() throws Exception {
            ) {
import static org.hamcrest.Matchers.containsInAnyOrder;
            final SegmentInfos initialCommit = store.readLastCommittedSegmentsInfo();  
    public void testPrimaryRestart() throws Exception {
            // promote the replica
                )
                }
            }
        assertTrue(primary.isSearchIdle());
        }
            assertTrue(diff.missing.isEmpty());  
            // 1. Create ops that are in the index and xlog of both shards but not yet part of a commit point.  
                    public void onReplicationDone(SegmentReplicationState state) {
                flushShard(primary);
import org.opensearch.indices.replication.SegmentReplicationState;
                        waitForSecondRound.countDown();
     * committing locally so that in next round of segment replication those files are not considered for download again  
        .build();
                        ReplicationFailedException e,
                true  
                Set.of("segments_1"),  
            final SegmentInfos secondCommit = store.readLastCommittedSegmentsInfo();
        shards.promoteReplicaToPrimary(replicaShard, (shard, listener) -> {
import java.util.HashSet;  
                IndexShard indexShard,
import static org.mockito.Mockito.doAnswer;
            // Start first round of segment replication. This should fail with simulated error but with replica having
            primary = shards.getPrimary();
            }
                    }  
            );
            shards.indexDocs(docCount);  
    }
                break;
import org.opensearch.index.engine.InternalEngine;
import org.opensearch.cluster.ClusterState;  
            assertTrue("Files should not be committed", activeFiles.isEmpty());  
                assertDocCounts(shard, numDocs, 0);
        });
            );
            IndexShard primary = shards.getPrimary();  
import static org.mockito.Mockito.when;
            logger.info("DIFF FILE {}", diff.different);
        }
import org.opensearch.index.store.StoreFileMetadata;  
            flushShard(primary);
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;
    }
import static org.opensearch.index.shard.RemoteStoreRefreshListener.EXCLUDE_FILES;  
import java.util.function.BiConsumer;
            @Override
            replicateSegments(primary, List.of(replica));  
                super.getCheckpointMetadata(replicationId, checkpoint, listener);
                getRemoteStoreReplicationSource(replica, () -> { throw new RuntimeException("Simulated"); })
            shards.removeReplica(replica);
            );  
    @Override
        .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
                    // Not performing actual snapshot, just modifying the state
        }
            // refresh but do not copy the segments over.  
                .map(metadata -> metadata.name())
            when(sourceFactory.get(any())).thenReturn(
        replicateSegments(primaryShard, shards.getReplicas());
import static org.mockito.Mockito.mock;  
            }
            assertTrue(thirdCommit.getGeneration() > secondCommit.getGeneration());  
import org.opensearch.index.engine.DocIdSeqNoAndSource;  
        // TODO: wait for remote store to support merged segment warmer
            assertSingleSegmentFile(replica);  
            BlobStoreRepository repository = (BlobStoreRepository) repositoriesService.repository("random");
                    @Override  
            oldPrimary.close("demoted", false, false);
        replicateSegments(primaryShard, shards.getReplicas());
            }).when(repository)
                    listener.onResponse(response);
     * round of segment replication by ensuring doc count.  
            );
            if (randomBoolean()) {
                    "test",
import org.opensearch.common.concurrent.GatedCloseable;  
import org.opensearch.test.CorruptionUtils;
            final IndexShard primary = shards.getPrimary();  
            final Engine replicaEngine = getEngine(replica);  
            shards.reinitPrimaryShard(remotePath);  
                .values()
    }
            assertDocCount(primary, 10);
 *
    /**
import org.hamcrest.MatcherAssert;  
                shards.getIndexMetadata(),  
    }
                ActionListener<CheckpointInfoResponse> listener  
import org.opensearch.indices.replication.CheckpointInfoResponse;
                    ) {
            final Map<String, StoreFileMetadata> metadataBeforeRestart = primary.getSegmentMetadataMap();
            assertNotNull(primaryEngine);  
        testNRTReplicaWithRemoteStorePromotedAsPrimary(true, false);  
            shards.startAll();
                replica.getSegmentMetadataMap()
                        latch.countDown();  
            shards.startAll();
public class RemoteIndexShardTests extends SegmentReplicationIndexShardTests {  
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), remotePath)) {
    @Override  
            ReplicationGroup shards = createGroup(1, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), createTempDir())  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/18720")
            final SnapshotShardsService shardsService = getSnapshotShardsService(
import org.apache.lucene.util.Version;  
                "Replica starts at empty segment 2",
            assertEquals(store.readLastCommittedSegmentsInfo().getGeneration(), secondCommit.getGeneration());
                .stream()  
        final IndexShard replicaShard = shards.getReplicas().get(0);
            // Check the snapshot got completed successfully
            CountDownLatch waitForSecondRound = new CountDownLatch(1);  
            final int totalDocs = numDocs + additonalDocs;  
            }  
                oldPrimary.refresh("Test");
        testNRTReplicaWithRemoteStorePromotedAsPrimary(true, true);
    public void testNRTReplicaWithRemoteStorePromotedAsPrimaryCommitRefresh() throws Exception {
                new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5))  
            logger.info("--> Starting first round of replication");  
        return settings;
            final SegmentInfos latestReplicaCommit = SegmentInfos.readLatestCommit(replica.store().directory());
            if (shard != null) {
                        logger.error("Replication error", e);  
            assertEquals("Files should be copied to disk", false, onDiskFiles.isEmpty());
            assertDocCount(primary, 1);
                    containsInAnyOrder("_0.cfe", "_0.si", "_0.cfs")
            );
            }  
                clusterService.state(),
            assertDocCount(primary, 10);  
                logger.info("--> Corrupting file {}", fileToCorrupt);
            shards.startAll();
import org.opensearch.index.store.Store;
            } else {
            latestPrimaryCommit.commit(primary.store().directory());
                primary.getLatestReplicationCheckpoint(),
            // at this point both shards should have numDocs persisted and searchable.
            shards.promoteReplicaToPrimary(nextPrimary).get();
import static org.mockito.ArgumentMatchers.anyLong;
            when(sourceFactory.get(any())).thenReturn(
                        latch.countDown();
import org.opensearch.indices.replication.GetSegmentFilesResponse;
                true,
            }
            );
            final Engine primaryEngine = getEngine(primary);
import org.opensearch.indices.replication.common.ReplicationType;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/pull/19436")
    @Override  
                    long indexTotalFileSize = indexFilesToFileLengthMap.values().stream().mapToLong(Long::longValue).sum();
import static org.hamcrest.Matchers.equalTo;
            assertSingleSegmentFile(replica);
                long startTime = invocation.getArgument(8);  
                );
                flushShard(oldPrimary, true);  
                primary.remoteStore().readLastCommittedSegmentsInfo().files(true)  
            // index some more into both but don't replicate. replica will have only numDocs searchable, but should have totalDocs  
            doAnswer(invocation -> {  
                    }
import org.opensearch.test.junit.annotations.TestLogging;
                randomAlphaOfLength(10),
            replicateSegments(primary, shards.getReplicas());
    }  
    private static final String REPOSITORY_NAME = "temp-fs";
            flushShard(primary);
                replica,
    public void testNRTReplicaWithRemoteStorePromotedAsPrimaryCommitCommit() throws Exception {  
                        Assert.fail("Replication should not fail");
package org.opensearch.index.shard;
            assertTrue(diff.different.isEmpty());
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            for (IndexShard shard : shards.getReplicas()) {
            assertEquals(newTarget.state().getStage(), SegmentReplicationState.Stage.DONE);  
                );
                replica.store().readLastCommittedSegmentsInfo().files(true)
import org.junit.Assert;
        final Path remotePath = createTempDir();  
                    replicationId,
                    "Segments are referenced in memory only",
        }  
import org.opensearch.cluster.SnapshotsInProgress;
import org.opensearch.indices.replication.RemoteStoreReplicationSource;  
    @TestLogging(reason = "Getting trace logs from replication package", value = "org.opensearch.indices.replication:TRACE")
                        SegmentReplicationState state,  
            assertEquals(
            assertEquals(
                new SegmentReplicationTargetService.SegmentReplicationListener() {
import org.opensearch.snapshots.SnapshotShardsService;  
            });
            replica.store().createEmpty(Version.LATEST);  
            try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryEngine.getSegmentInfosSnapshot()) {  
                assertConsistentHistoryBetweenTranslogAndLucene(shard);  
            primary.refresh("Test");
                ReplicationCheckpoint checkpoint,
            if (randomBoolean()) {  
    protected ReplicationGroup getReplicationGroup(int numberOfReplicas) throws IOException {
            // restart the primary  
                    indexShard,
            closeShards(replica);
            assertDocCounts(oldPrimary, totalDocs, totalDocs);
                    }
            oldPrimary.store().close();  
                primary.getSegmentMetadataMap(),
            assertDocCount(primary, 10);  
            assertDocCount(replica, 2);
                );  
    private void assertSingleSegmentFile(IndexShard shard) throws IOException {  
            logger.info("--> Starting second round of replication");
                    listener.onResponse(snapshotStatus.generation());
            for (IndexShard shard : shards) {
            }  
            public void getCheckpointMetadata(  
            final Snapshot snapshot1 = new Snapshot(
            // clean up  
            shardsService.clusterChanged(new ClusterChangedEvent("test", initState, clusterService.state()));
            assertTrue(diff.missing.isEmpty());
            final IndexShard replica = shards.addReplica(remotePath);
            final ClusterState initState = addSnapshotIndex(
                        boolean sendShardFailure
        primaryShard.refresh("test");  
import java.nio.channels.FileChannel;
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(metadataBeforeRestart, primary.getSegmentMetadataMap());
            final Store store = replica.store();
    }  
    }
                    snapshotStatus.moveToDone(System.currentTimeMillis(), snapshotStatus.generation());
            public void getSegmentFiles(  
            primary.refresh("test");  
                    .get(primaryShard.shardId)
    }
            );
    }  
    public void testCleanupRedundantPendingMergeSegment() throws Exception {
import java.util.Set;  
            assertEquals("On-disk commit references no segments", Set.of("segments_3"), latestCommit.files(true));
            // ensure primary has uploaded something
    protected void validateShardIdleWithNoReplicas(IndexShard primary) {
        CountDownLatch latch = new CountDownLatch(1);  
            CountDownLatch latch = new CountDownLatch(1);
            // persisted.
import java.nio.file.Path;
    public void testRepicaCleansUpOldCommitsWhenReceivingNew() throws Exception {
                    addSnapshotIndex(clusterService.state(), snapshot1, primaryShard, SnapshotsInProgress.State.STARTED, true),
     */
            try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = replicaEngine.getSegmentInfosSnapshot()) {
import java.util.List;
    /**  
                    @Override
        .put(IndexMetadata.SETTING_REMOTE_TRANSLOG_STORE_REPOSITORY, REPOSITORY_NAME)
                    checkpoint,
    public void testMergedSegmentReplication() throws Exception {
    @Override  
import org.opensearch.core.action.ActionListener;
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                        waitOnReplicationCompletion.countDown();
                    continue;
            final SegmentInfos latestCommit = SegmentInfos.readLatestCommit(primary.store().directory());
        for (IndexShard shard : shards) {
                    CorruptionUtils.corruptAt(shardPath.resolve(file), raf, (int) (raf.size() - 8));  
            }  
                    return null;  
            // get a metadata map - we'll use segrep diff to ensure segments on reader are identical after restart.  
        shards.indexDocs(10);
            final Store.RecoveryDiff recoveryDiff = Store.segmentReplicationDiff(  
            assertTrue(diff.different.isEmpty());
import org.opensearch.snapshots.Snapshot;
                        logger.error("Replication error", e);  
        replicateSegments(primaryShard, shards.getReplicas());  
    private RemoteStoreReplicationSource getRemoteStoreReplicationSource(IndexShard shard, Runnable postGetFilesRunnable) {  
            for (String file : replica.store().directory().listAll()) {
            assertDocCounts(oldPrimary, numDocs, numDocs);  
        try (ReplicationGroup shards = createGroup(0, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), remotePath)) {
        // ensure search idle conditions are met.
            IndexShard oldPrimary = shards.getPrimary();  
                    ) {  
            SegmentInfos latestPrimaryCommit = SegmentInfos.readLatestCommit(primary.store().directory());
                primary.refresh("test");  
            Path shardPath = replica.shardPath().getDataPath().resolve(ShardPath.INDEX_FOLDER_NAME);
    public void testNRTReplicaWithRemoteStorePromotedAsPrimaryRefreshCommit() throws Exception {
    }  
            assertSingleSegmentFile(replica);
            @Override
            latch.await();
            // Initialize the shallow copy snapshot  
        try (ReplicationGroup shards = createGroup(0, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), remotePath)) {
                    @Override
                .snapshotRemoteStoreIndexShard(any(), any(), any(), any(), any(), any(), anyLong(), anyLong(), anyLong(), any(), any());
            final Map<String, StoreFileMetadata> metadataBeforeRestart = primary.getSegmentMetadataMap();
                }
            for (IndexShard shard : shards.getReplicas()) {  
import org.opensearch.common.settings.Settings;
}  
            ) {
                assertEquals(IndexShardSnapshotStatus.Stage.DONE, stage);
            public String getDescription() {  
                primaryShard,
            assertDocCount(replica, 3);  
            String fileToCorrupt = null;
                final IndexShardSnapshotStatus.Copy copy = shardsService.currentSnapshotShards(snapshot1)  
        assertFalse(primary.isSearchIdleSupported());  
            shards.indexDocs(docCount);
            // 2. Create ops that are in the replica's xlog, not in the index.
            int prevOperationCount = nextPrimary.translogStats().estimatedNumberOfOperations();
            shards.startPrimary();
        super.testMergedSegmentReplicationWithZeroReplica();  
                    public void onReplicationFailure(
            nextPrimary.refresh("test");  
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
        super.testMergedSegmentReplication();
            assertNotNull(replicaEngine);
                    public void onReplicationDone(SegmentReplicationState state) {
                listener.onResponse(snapshotStatus.generation());
            final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());
                    postGetFilesRunnable.run();  
                        Assert.fail("Replication should fail with simulated error");
            List<String> activeFiles = replica.getSegmentMetadataMap()
        }  
    protected Settings getIndexSettings() {
                    ) {  
            primary = shards.getPrimary();  
            waitOnReplicationCompletion.await();  
                primary.refresh("test");
            IndexShard primary = shards.getPrimary();
                replica,  
            primary.refresh("Test");  
            latch.countDown();
                    List<String> fileNames = new ArrayList<>(indexFilesToFileLengthMap.keySet());
            }  
            activeFiles = replica.getSegmentMetadataMap().values().stream().map(metadata -> metadata.name()).collect(Collectors.toList());
    public void testPrimaryRestart_PrimaryHasExtraCommits() throws Exception {  
                        ReplicationFailedException e,
                        ReplicationFailedException e,
        };  
     * This test validates that local non-readable (corrupt, partially) on disk are deleted vs failing the  
                    public void onReplicationFailure(  
    public void testNRTReplicaWithRemoteStorePromotedAsPrimaryRefreshRefresh() throws Exception {  
                assertDocCounts(shard, totalDocs, 0);  
            assertDocCounts(nextPrimary, totalDocs, totalDocs);  
            shards.indexDocs(10);
    }
                StepListener<GetSegmentFilesResponse> waitForCopyFilesListener = new StepListener();
            // Ingest more data and start next round of segment replication  
        // TODO: wait for remote store to support merged segment warmer
            shards.indexDocs(1);  
            shardsService.clusterChanged(
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
            assertTrue(secondCommit.getGeneration() > initialCommit.getGeneration());  
import org.opensearch.index.engine.NRTReplicationEngineFactory;  
                    "Segments are referenced in memory",  
                long replicationId,
            final IndexShard primary = shards.getPrimary();
        super.testMergedSegmentReplicationWithException();
    }  
            // ensure primary has uploaded something  
            closeShards(replica);
            );  
                try (FileChannel raf = FileChannel.open(shardPath.resolve(file), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
        }  
            // start the snapshot
                    }  
            } else {  
        latch.await();  
            replicateSegments(primary, shards.getReplicas());  
            final SegmentReplicationTarget newTarget = targetService.startReplication(
        }  
                closeShard(shard, false);  
            assertTrue(diff.different.isEmpty());  
        shards.startPrimary();
                BiConsumer<String, Long> fileProgressTracker,
                        assertFalse(sendShardFailure);
    }
                if (indexFilesToFileLengthMap != null) {  
            onDiskFiles.removeIf(name -> EXCLUDE_FILES.contains(name) || name.startsWith(IndexFileNames.SEGMENTS));  
            assertTrue("Replica should have consistent disk & reader", activeFiles.containsAll(onDiskFiles));
            final IndexShard nextPrimary = shards.getReplicas().get(0);
            latestPrimaryCommit = SegmentInfos.readLatestCommit(primary.store().directory());  
            assertDocCount(primary, 10);
            if (performFlushSecond) {
                ActionListener<String> listener = invocation.getArgument(10);
        final Path remotePath = createTempDir();  
        final Set<String> segmentsFileNames = Arrays.stream(shard.store().directory().listAll())
        try (ReplicationGroup shards = createGroup(0, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory(), remotePath)) {
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);  
        assertEquals("Expected a single segment file", 1, segmentsFileNames.size());
        flushShard(primaryShard);
            .filter(file -> file.startsWith(IndexFileNames.SEGMENTS))
            // replicateSegments(primary, shards.getReplicas());  
        final Path remotePath = createTempDir();  
import java.nio.file.StandardOpenOption;  
            segmentCommitInfos.commit(replica.store().directory());
 * this file be licensed under the Apache-2.0 license or a
                final Map<String, Long> indexFilesToFileLengthMap = invocation.getArgument(9);
    }
                    public void onReplicationDone(SegmentReplicationState state) {
                    filesToFetch,  
                        boolean sendShardFailure  
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);  
        testNRTReplicaWithRemoteStorePromotedAsPrimary(false, false);
        ) {
        // TODO: wait for remote store to support merged segment warmer  
                .collect(Collectors.toList());
                long replicationId,
/*  
import java.util.concurrent.CountDownLatch;
