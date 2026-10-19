        IndexShardTestCase.updateRoutingEntry(shard, routing);
                clusterService.state(),
import org.opensearch.cluster.metadata.IndexMetadata;
            final IndexShard primary = shards.getPrimary();
            logger.info("--> Inserting documents {}", numDocs);
            shardsService.clusterChanged(new ClusterChangedEvent("test", initState, clusterService.state()));
                latch.countDown();
        } finally {
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"foo\": { \"type\": \"keyword\"} }}}";
            final IndexShard primary = shards.getPrimary();
            int numDocs = randomIntBetween(10, 20);
        try (
import org.opensearch.common.concurrent.GatedCloseable;
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build(),
    protected SnapshotShardsService getSnapshotShardsService(
                onLockAcquired = new PlainActionFuture<>();
            final Map<String, StoreFileMetadata> segmentMetadataMap = primaryShard.getSegmentMetadataMap();
                        throw new AssertionError("recovery must fail");
import org.opensearch.index.store.StoreFileMetadata;
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
    public void testIsReplicationTargetTrueForNRTReplicationEngineReplica() throws IOException {
                ActionListener<GetSegmentFilesResponse> listener;
                ) {
        primary = shards.addReplicaWithExistingPath(primary.shardPath(), primary.routingEntry().currentNodeId());
        recoveryThread.join();
                    ReplicationCheckpoint checkpoint,
                releasable.close();
            final IndexShard replicaShard = shards.getReplicas().get(0);
    /**
            }).when(spyShard).finalizeReplication(any(CatalogSnapshot.class));
                    assertNotNull(engineOrNull);
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO)
        // assigned seqNos start at 0, so assert max & local seqNos are 1 less than our persisted doc count.
            }
import org.opensearch.indices.recovery.RecoveryTarget;
                @Override
        shard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
        int totalOps = randomInt(10);
     */
        final IndexShard shard = newStartedShard(true, getIndexSettings());
        SegmentReplicationTargetService targetService
/*
            randomBoolean(),
    }
     * searcher that triggers the reader close operation.
            primaryShard.refresh("test");
                }
                assertReplicationCheckpoint(replica, gatedCloseable.get(), replicaTuple.v2());
            assertTrue(diff.different.isEmpty());
            } catch (InterruptedException e) {
    }
        IndexShard replica,
            assertEquals(1, primaryShard.segments(false).size());
import org.opensearch.test.VersionUtils;
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
        flushShard(primaryShard);
                throw new RuntimeException(e);
    }
                return ans.callRealMethod();
            final IndexShard replicaShard = shards.getReplicas().get(0);
import org.opensearch.snapshots.Snapshot;
        final TransportService transportService = mock(TransportService.class);
            try (final GatedCloseable<SegmentInfos> gatedCloseable = replicaTuple.v1()) {
    public void testSegmentReplication_With_ReaderClosedConcurrently() throws Exception {
            } catch (IOException e) {
            });
        }
                assertions.add(() -> {
        promoteReplica(
        final IndexService indexService = mock(IndexService.class);
     */
        }
        }
        assertEquals(expectedPersistedDocCount - 1, indexShard.seqNoStats().getMaxSeqNo());
    public void testIsReplicationTargetFalseForInternalEnginePrimary() throws IOException {
            getIndexSettings(),
            final IndexShard replicaSpy = spy(replica);
                    final RuntimeException exception = new CancellableThreads.ExecutionCancelledException("retryable action was cancelled");
        assertNull(targetService.get(target.getId()));
                assertReplicationCheckpoint(primary, gatedCloseable.get(), primaryTuple.v2());
        ReplicationGroup shards = createGroup(1, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir());
     */
import org.opensearch.index.engine.NRTReplicationEngineFactory;
            snapshot,
     * Test that latestReplicationCheckpoint returns null only for docrep enabled indices
        );
            for (IndexShard replica : shards.getReplicas()) {
        when(transportService.getThreadPool()).thenReturn(threadPool);
            CountDownLatch latch = new CountDownLatch(1);
                false
        final IndexShard indexShard = newShard(false, getIndexSettings(), new EngineBackedIndexerFactory(new InternalEngineFactory()));
            // Assertions
        ) {
                }
            final IndexShard replica = shards.getReplicas().get(0);
            // index and copy segments to replica.
                    public void onDone(ReplicationState state) {
                1,
            }
            snapshotState,
            public void onResponse(Releasable releasable) {
        // verify checkpoint is published
import org.opensearch.index.engine.DocIdSeqNoAndSource;
            shards.startAll();
            getIndexSettings(),
            final int numDocs = shards.indexDocs(randomIntBetween(1, 10));
    ) {
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
            assertEquals(0, primary.getLatestReplicationCheckpoint().compareTo(replica.getLatestReplicationCheckpoint()));
            Assert.fail("Failed to compute copyState");
    /**
    }
            assertTrue("NRT-backed replica must be a replication target", replica.isReplicationTarget());
import org.opensearch.index.engine.NRTReplicationEngine;
            flushShard(primaryShard);
                    IndexShard indexShard,
            // Step 2. Ingest numDocs documents again & replicate to replica shard
            // cleans up recently copied over files
        primary.close("demoted", true, false);
    }
            @Override
            final List<DocIdSeqNoAndSource> docIdAndSeqNos = getDocIdAndSeqNos(primaryShard);
    public void testSegmentReplication_With_EngineClosedConcurrently() throws Exception {
            primarySource.routingEntry().getTargetRelocatingShard(),
            final Map<String, StoreFileMetadata> latestPrimaryMetadata = primary.store().getSegmentMetadataMap(primaryInfos);
        boolean closedIdx,
            randomBoolean(),
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, spy, createTempDir())) {
            ReplicationGroup shards = createGroup(
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
        final CountDownLatch latch = new CountDownLatch(1);
            latch.countDown();
            assertEquals(2, replicaShard.segments(false).size());
            // Step 3. Perform force merge down to 1 segment on primary
import org.apache.lucene.store.AlreadyClosedException;
    }
        updateMappings(primaryTarget, primarySource.indexSettings().getIndexMetadata());
        Settings updatedSettings = Settings.builder()
        promoteReplica(
        return shards.getReplicas().get(randomInt(shards.getReplicas().size() - 1));
        }
            }
        closeShards(primarySource, primaryTarget);
            shards.refresh("test");
import org.opensearch.indices.replication.common.CopyState;
            }
            } catch (IOException e) {
        try (ReplicationGroup shards = createGroup(1, updatedSettings, new NRTReplicationEngineFactory())) {
    }
        try {
                startRecovery.await();
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
            primaryShard.refresh("test");
            try {
            shards.startAll();
import java.util.concurrent.TimeUnit;
            final Set<SegmentReplicationShardStats> statsAfterFlush = primaryShard.getReplicationStatsForTrackedReplicas();
                    resolveCheckpointInfoResponseListener(listener, primary);
            shards.startAll();
            validateShardIdleWithNoReplicas(primary);
            final IndexShard replicaShard = shards.getReplicas().get(0);
    /**
        IndexShardTestCase.updateRoutingEntry(shard, routing);
    protected void assertEqualTranslogOperations(ReplicationGroup shards, IndexShard primaryShard) throws IOException {
        sut = prepareForReplication(primaryShard, null);
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
                    routing.getTargetRelocatingShard().allocationId().getId(),
        final RecoverySettings recoverySettings = new RecoverySettings(
            shards.assertAllEqual(numDocs);
            }
        } catch (IOException e) {
            assertTrue(primary.scheduledRefresh());
        );
                primaryTarget,
                    }
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            replicateSegments(primaryShard, List.of(spyShard));
            }
            final IndexShard replicaShard = shards.getReplicas().get(0);
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, spy, createTempDir())) {
        IndexMetadata indexMetadata,
            assertEquals(1, shardStats.getCheckpointsBehindCount());
        }
                final IndexShardSnapshotStatus.Copy copy = shardsService.currentSnapshotShards(snapshot).get(replicaShard.shardId).asCopy();
            primaryShard.refresh("test");
    public void testCleanupRedundantPendingMergeSegment() throws Exception {
import org.opensearch.index.engine.InternalEngineFactory;
import org.opensearch.core.index.shard.ShardId;
                throw new IOException("Expected failure");
        assertEquals(checkpoint.getSegmentsGen(), segmentInfos.getGeneration());
        spy.onNewCheckpoint(new ReplicationCheckpoint(primaryShard.shardId(), 0L, 0L, 0L, Codec.getDefault().getName()), spyShard);
            }
        }
                .getLatestSegmentInfosAndCheckpoint();
        );
import org.opensearch.indices.replication.SegmentReplicationTargetService;
            shards.refresh("test");
import static org.hamcrest.Matchers.hasToString;
     * Test that latestReplicationCheckpoint returns ReplicationCheckpoint for segrep enabled indices
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
                    new ClusterChangedEvent(
                recoverySettings,
        assertFalse("closed shard must return false without throwing", replica.isReplicationTarget());
                MergedSegmentPublisher.EMPTY
        primaryShard.getReplicationTracker().completeRelocationHandoff();
        closeShards(indexShard);
                    ActionListener<GetSegmentFilesResponse> listener
        shards.startAll();
                    public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
                ) {
            new SegmentReplicationTargetService.SegmentReplicationListener() {
            } else if (recoveryIndex == i) {
            for (int i = 0; i < numDocs; i++) {
    }
                false,
    protected void resolveCheckpointInfoResponseListener(ActionListener<CheckpointInfoResponse> listener, IndexShard primary) {
        try (
        final ShardRouting shardRouting = shard.routingEntry();
import org.opensearch.index.SegmentReplicationShardStats;
            assertTrue(diff.missing.isEmpty());
import static org.hamcrest.Matchers.instanceOf;
                indexMapping,
            final IndexShard primaryShard = shards.getPrimary();
            }
import org.opensearch.indices.replication.CheckpointInfoResponse;
            int numDocs = 1;
            // generate segment _3.si
                assertReplicationCheckpoint(primary, gatedCloseable.get(), primaryTuple.v2());
        assertEquals(expectedPersistedDocCount - 1, indexShard.seqNoStats().getLocalCheckpoint());
                        .contains("snapshot triggered on a new primary following failover and cannot proceed until promotion is complete")
            assertion.run();
            // recovery can only be finalized after we release the current primaryOperationLock
    public void testPublishCheckpointOnPrimaryMode_segrep_off() throws IOException, InterruptedException {
            // index and replicate segments to replica.
                // Using engine.close() prevents indexShard.finalizeReplication execution due to engine AlreadyClosedException,
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, spy, createTempDir())) {
                getIndexSettings(),
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);
        // verify checkpoint is published
            primaryShard.refresh("test");
                }
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;
                new NRTReplicationEngineFactory(),
        // Completing relocation handoff.
            IndexShard primaryShard = shards.getPrimary();
    @TestLogging(reason = "Getting trace logs from MergedSegmentWarmer", value = "org.opensearch.index.engine.MergedSegmentWarmer:TRACE")
 * this file be licensed under the Apache-2.0 license or a
        final ShardRouting shardRouting = shard.routingEntry();
        shardsBuilder.put(
            flushShard(primaryShard);
            shards.startAll();
            assertFalse("primary on InternalEngine must NOT be a replication target", primary.isReplicationTarget());
        }
            final IndexShard primaryShard = shards.getPrimary();
            logger.info("--> Ingest {} docs again", numDocs);
import org.opensearch.index.store.Store;
        assertNotNull(segmentInfos);
     * Validates happy path of segment replication where primary index docs which are replicated to replica shards. Assertions
            recoveryThread.start();
            }
        try {
    private void assertReplicaCaughtUp(IndexShard primaryShard) {
    }
                }
    }
        final CountDownLatch relocationStarted = new CountDownLatch(1);
        // Assert that primary shard is no longer in Primary Mode and shard routing is still Primary
                throw new RuntimeException(e);
import org.opensearch.action.index.IndexRequest;
                        assertEquals(ExceptionsHelper.unwrap(e, IOException.class).getMessage(), "Expected failure");
        replicateSegments(primaryShard, shards.getReplicas());
            flushShard(primaryShard);
            shards.promoteReplicaToPrimary(replicaShard).get();
        });
            @Override
            final IndexShard primaryShard = shards.getPrimary();
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), mappings, new NRTReplicationEngineFactory())) {
import org.opensearch.index.translog.SnapshotMatchers;
            shards.startAll();
            int numDocs = randomIntBetween(10, 20);
            assertTrue(replica.isSearchIdle());
        assertFalse(indexShard.isSegmentReplicationAllowed());
            Collections.emptyList(),
            assertEquals(1, primaryShard.segments(false).size());
            final ClusterState initState = addSnapshotIndex(
                } catch (Throwable e) {
                indexMapping,
                closeShard(shard, false);
            assertEquals(initialCheckpointSize, shardStats.getBytesBehindCount());
        );
    /**
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");
        final SnapshotsInProgress.Entry entry = new SnapshotsInProgress.Entry(
import org.opensearch.ExceptionsHelper;
import static org.mockito.Mockito.spy;
        }
    }
        final NRTReplicationEngineFactory engineFactory = new NRTReplicationEngineFactory();
                    assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
            shards.assertAllEqual(numDocs);
                assertTrue(
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
    protected ClusterState addSnapshotIndex(
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
        verify(mock, times(1)).publish(any(), any());
                    () -> {}
        closeShards(indexShard);
        indexShard.addRefreshListener(mock(Translog.Location.class), Assert::assertFalse);
            .build();
        }
        assertDocCount(indexShard, expectedSearchableDocCount);
        );
            final long sizeAfterDeleteAndCommit = diff.missing.stream().mapToLong(StoreFileMetadata::length).sum();
        throws IOException {
    }
    public void testNoDuplicateSeqNo() throws Exception {
        }, ThreadPool.Names.GENERIC, "");
                }
            final IndexShard primary = shards.getPrimary();
    }
            Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> replicaTuple = replica.getLatestSegmentInfosAndCheckpoint();
import java.util.HashMap;
            }
    }
            replicaTuple = replica.getLatestSegmentInfosAndCheckpoint();
            assertFalse(primary.hasRefreshPending());
            shards.assertAllEqual(2 * numDocs);
        try (final Translog.Snapshot snapshot = getTranslog(primaryShard).newSnapshot()) {
            SegmentReplicationSource source = new TestReplicationSource() {
                throw new RuntimeException(e);
            final IndexShard replicaShard = shards.getReplicas().get(0);
    public void testReplicationCheckpointNotNullForSegRep() throws IOException {
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsCheckpoint;
    /**
                    @Override
            shards.indexDocs(10);
import static org.hamcrest.Matchers.containsString;
            shard,
    protected SegmentReplicationTargetService newTargetService(SegmentReplicationSourceFactory sourceFactory) {
                    // shard is closing while we are copying files.
            assertFalse(replica.scheduledRefresh());
import org.opensearch.cluster.routing.ShardRouting;
        ) {
import static org.mockito.Mockito.verify;
        IndexShard shard = newStartedShard(true);
            // Step 1. Ingest numDocs documents & replicate to replica shard
            shards.indexDocs(numDocs);
            final IndexShard primaryShard = shards.getPrimary();
                test.close();
        Exception e = expectThrows(
                return null;
            }
    }
            shards.startAll();
            shards.startAll();
        }
        final NRTReplicationEngineFactory spy = spy(engineFactory);
        shards.promoteReplicaToPrimary(replicaShard, (shard, listener) -> {
        }
    }
            // invoke scheduledRefresh, returns true if refresh is immediately invoked.
        assertNotNull(replicationCheckpoint);
                throw new RuntimeException(e);
            primaryShard.refresh("test");
            .build();
                        throw new AssertionError();
            assertEquals(2, replicaShard.getPendingMergedSegmentCheckpoints().size());
import org.apache.lucene.index.SegmentInfos;
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(Collections.singletonList(entry)))
        verify(spy, times(0)).startReplication(any(), any(), any());
                latch.countDown();
        recoveryThread.start();
import org.opensearch.common.lease.Releasable;
                    final Engine engineOrNull = getEngine(replicaShard);
        final NRTReplicationEngineFactory spy = spy(engineFactory);
import org.opensearch.index.IndexService;
                    public void onFailure(Exception e) {
        );
                shards.assertAllEqual(10);
            // ensure search idle conditions are met.
        }
            // in the replica shard is still 2.
import org.opensearch.snapshots.SnapshotInfoTests;
        shards.indexDocs(10);
            shards.startAll();
        final IndexShard indexShard = newStartedShard(false, indexSettings);
    }
        closeShards(indexShard);
                deleteDoc(replicaShard, docIdAndSeqNo.getId());
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            shards.indexDocs(numDocs);
    }
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
                @Override
        CheckpointRefreshListener refreshListener = new CheckpointRefreshListener(shard, mock);
            assertEqualTranslogOperations(shards, primaryShard);
            // Step 2. Ingest numDocs documents again to create a new commit
                @Override
                0,
            shards.startAll();
        assertNull(indexShard.getLatestReplicationCheckpoint());
            shards.indexDocs(numDocs);
    public void testLockingBeforeAndAfterRelocated() throws Exception {
        closeShards(shard);
            () -> recoverReplica(
            final IndexShard replica = shards.getReplicas().get(0);
            shards.assertAllEqual(10);
 * SPDX-License-Identifier: Apache-2.0
                deleteDoc(primaryShard, docIdAndSeqNo.getId());
    public void testComputeReplicationCheckpointNullInfosReturnsEmptyCheckpoint() throws Exception {
            primaryShard.refresh("test");
                new CheckpointInfoResponse(copyState.getCheckpoint(), copyState.getMetadataMap(), copyState.getInfosBytes())
            // in the replica shard is still 2.
        shards.recoverReplica(primary);
            IndexShard primary = shards.getPrimary();
    }
        }
        final IndexShard primaryShard = shards.getPrimary();
            new IndexMetadata.Builder(indexMetadata).state(closedIdx ? IndexMetadata.State.CLOSE : IndexMetadata.State.OPEN).build()
            assertEqualTranslogOperations(shards, primaryShard);
            IndexShard spyShard = spy(replicaShard);
                assertNotNull(copy.getFailure());
                1,
                    )
            }
import org.opensearch.repositories.RepositoriesService;
            IndexShard spyShard = spy(replicaShard);
            shards.indexDocs(numDocs);
            shards.indexDocs(10);
        IndexShard shard,
        }
import org.opensearch.common.util.CancellableThreads;
            assertFalse(replicaShard.getReplicationEngine().isEmpty());
                assertions.add(() -> {
import org.opensearch.threadpool.ThreadPool;
            shards.startAll();
            null,
    public void testSnapshotWhileFailoverIncomplete() throws Exception {
        closeShards(shard);
        }
        final NRTReplicationEngineFactory engineFactory = new NRTReplicationEngineFactory();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            );
            shards.removeReplica(replica);
            false,
    protected IndexShard getRandomReplica(ReplicationGroup shards) {
            replicateMergedSegments(primaryShard, List.of(replicaShard));
        assertEquals(0, shardStats.getBytesBehindCount());
        final IndexShard primary = newStartedShard(true, settings);
                final AtomicBoolean invoked = new AtomicBoolean();
            // We use compareTo here instead of equals because we ignore segments gen with replicas performing their own commits.
        final int numberOfAcquisitions = randomIntBetween(1, 10);
        ) {
        });
        primaryShard.refresh("test");
            // generate pending merge segment _2.si
            )
            }
            shard,
        );
            VersionUtils.randomVersion(random()),
            assertEquals(1, replicaShard.getPendingMergedSegmentCheckpoints().size());
            final IndexShard primaryShard = shards.getPrimary();
        final NRTReplicationEngineFactory spy = spy(engineFactory);
    // strategy.
                assertEquals(latestReplicationCheckpoint, primaryShard.computeReplicationCheckpoint(closeable.get()));
        assertTrue(shard.isRelocatedPrimary());
            Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> primaryTuple = primary.getLatestSegmentInfosAndCheckpoint();
            shards.indexDocs(numDocs);
                indexMapping,
                        initState
import java.util.Arrays;
                // delete on replica for xlog.
        shard.getReplicationTracker().completeRelocationHandoff();
                    }
            primary.refresh("Test");
        final NRTReplicationEngineFactory engineFactory = new NRTReplicationEngineFactory();
import static org.mockito.ArgumentMatchers.anyInt;
            shards.refresh("test");
            flushShard(primaryShard);
                onLockAcquired = new PlainActionFuture<>();
     * here we are starting a new primary shard and testing that we don't process a checkpoint on a shard when it's shard routing is primary.
    }
            shards.assertAllEqual(numDocs);
    // strategy.
        );
            assertNull("Expected correct doc count during engine reset", failed.get());
        latch.await();
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
    }
            // generate pending merge segment _4.si
                public void getCheckpointMetadata(
                final Translog.Operation newOp = op;
import org.opensearch.index.IndexSettings;
        SegmentReplicationShardStats shardStats = initialStats.stream().findFirst().get();
            final IndexShard primary = shards.getPrimary();
        latch.await();
        when(indexService.getShardOrNull(anyInt())).thenReturn(indexShard);
        for (IndexShard replica : replicas) {
            ReplicationGroup shards = createGroup(
    public void testReuseReplicationCheckpointWhenLatestInfosIsUnChanged() throws Exception {
            // index and replicate segments to replica.
            replicateMergedSegments(primaryShard, List.of(replicaShard));
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(segmentMetadataMap, replicaShard.getSegmentMetadataMap());
            // Step 1. Ingest numDocs documents
            assertBusy(() -> {
            primaryShard.refresh("test");
import org.opensearch.test.junit.annotations.TestLogging;
    protected IndexShard failAndPromoteRandomReplica(ReplicationGroup shards) throws IOException {
                        "test",
            shards.assertAllEqual(2 * numDocs);
            primaryShard.forceMerge(new ForceMergeRequest().maxNumSegments(1).flush(true));
        }
                    assertFalse(sendShardFailure);
        }
 */
                public void cancel() {
    public void testShardIdle_Docrep() throws Exception {
import org.opensearch.indices.replication.SegmentReplicationSource;
        refreshListener.afterRefresh(true);
            assertTrue(primary.isSearchIdle());
        RepositoriesService repositoriesService
                assertReplicationCheckpoint(replica, gatedCloseable.get(), replicaTuple.v2());
            replicateSegments(primary, shards.getReplicas());
        assertEquals("Should have resolved listener with failure", 0, latch.getCount());
            @Override
public class SegmentReplicationIndexShardTests extends OpenSearchIndexLevelReplicationTestCase {
            for (DocIdSeqNoAndSource docIdAndSeqNo : docIdAndSeqNos.subList(0, 5)) {
            final ReplicationCheckpoint latestReplicationCheckpoint = primaryShard.getLatestReplicationCheckpoint();
            }
            assertEquals(1, shardStats.getCheckpointsBehindCount());
        ) {
        closeShards(shard);
        return createGroup(numberOfReplicas, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory());
            final IndexShard replicaShard = shards.getReplicas().get(0);
                    listener.onFailure(exception);
import org.opensearch.cluster.routing.ShardRoutingHelper;
import java.util.concurrent.CountDownLatch;
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            )
        try (final CopyState copyState = new CopyState(primary)) {
import java.util.concurrent.atomic.AtomicBoolean;
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
                assertTrue(engineOrNull instanceof ReadOnlyEngine);
            assertEqualTranslogOperations(shards, primaryShard);
            ReferencedSegmentsCheckpoint referencedSegmentsCheckpoint = primaryShard.computeReferencedSegmentsCheckpoint();
            final PlainActionFuture<Releasable> onLockAcquired;
    }
            final IndexShard replicaShard = shards.getReplicas().get(0);
    public void testNRTReplicasDoNotAcceptRefreshListeners() throws IOException {
            shards.indexDocs(numDocs);
            assertEquals(1, primaryShard.segments(false).size());
            shards.startAll();
        final List<Runnable> assertions = new ArrayList<>(numberOfAcquisitions);
            replicateMergedSegments(primaryShard, List.of(replicaShard));
            final SegmentInfos replicaInfos = replica.store().readLastCommittedSegmentsInfo();
            final ReplicationCheckpoint primaryCheckpoint = primaryShard.getLatestReplicationCheckpoint();
            }).when(spy).newReadWriteEngine(any());
    public void testMergedSegmentReplicationWithException() throws Exception {
            shards.refresh("test");
    public void testReplicationCheckpointNullForDocRep() throws IOException {
        // Starting relocation handoff
            final IndexShard replicaShard = shards.getReplicas().get(0);
            }
            final Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> latestSegmentInfosAndCheckpoint = primaryShard
                final IndexShardSnapshotStatus.Stage stage = copy.getStage();
                }, threadPool),
            assertTrue(replica.isSearchIdle());
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir())) {
        assertTrue(primary.hasRefreshPending());
                    public void onResponse(Releasable releasable) {
                onLockAcquired = new PlainActionFuture<Releasable>() {
        });
            replicateSegments(primaryShard, shards.getReplicas());
                    long replicationId,
                shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});
        );
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);
    }
        final SegmentReplicationTarget target = targetService.startReplication(
        final RecoverySettings recoverySettings = new RecoverySettings(
     * reader close operation on replica shard deletes the segment files copied in current round of segment replication.
            // assert before any indexing:
            Collections.singleton(shardRouting.allocationId().getId()),
        replicateSegments(primaryShard, shards.getReplicas());
        );
        replicateSegments(primaryShard, shards.getReplicas());
    }
                mergedSegmentPublisherWithException
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            shard.acquirePrimaryOperationPermit(onLockAcquired, ThreadPool.Names.WRITE, "i_" + i);
            closeShards(replica);
            replicateSegments(primaryShard, shards.getReplicas());
            int numDocs = randomIntBetween(10, 20);
            indexDoc(primarySource, "_doc", Integer.toString(i));
            };
        assertEquals(initialStats.size(), 1);
        refreshListener.afterRefresh(true);
    }
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
            replicateSegments(primaryShard, shards.getReplicas());
    protected void validateShardIdleWithNoReplicas(IndexShard primary) {
            final IndexShard primaryShard = shards.getPrimary();
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build(),
                    BiConsumer<String, Long> fileProgressTracker,
        }
        SegmentReplicationTargetService sut;
            .put(getIndexSettings())
        IndexShard indexShard,
                @Override
                assertNotNull(engineOrNull);
        }
                startRecovery.countDown();
            closeShards(replica);
        // After close, getIndexer() throws AlreadyClosedException → method must return false, not throw.
            for (int i = 0; i < numDocs; i++) {
                true,
    }
        final IndicesService indicesService = mock(IndicesService.class);
            throw new RuntimeException("mock exception");
            shards.assertAllEqual(5);
            try (GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryShard.getSegmentInfosSnapshot()) {
            shards.startAll();
        }
        IndexShard primary,
        CountDownLatch latch = new CountDownLatch(1);
                });
            for (int i = 0; i < numDocs; i++) {
                    long replicationId,
            public void onFailure(Exception e) {
            primaryShard.refresh("Test");
    }
    public void testIgnoreShardIdle() throws Exception {
        }, ThreadPool.Names.GENERIC, "");
    }
import org.opensearch.common.collect.Tuple;
                new NRTReplicationEngineFactory(),
            closeShards(primary);
            flushShard(primaryShard);
            replicateSegments(primary, List.of(replica));
        Settings settings = Settings.builder()
            latch.await();
        Settings updatedSettings = Settings.builder()
        return createGroup(numberOfReplicas, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory());
            assertTrue(replicaShard.getReplicationEngine().isEmpty());
                n.callRealMethod();
            mock(TransportService.class),
                operations.add(newOp);
        );
            }
                );
        try (ReplicationGroup shards = createGroup(0, updatedSettings, new NRTReplicationEngineFactory())) {
                true,
        CheckpointRefreshListener refreshListener = new CheckpointRefreshListener(shard, mock);
     * This test mimics the segment replication failure due to CorruptIndexException exception which happens when
        final CountDownLatch latch = new CountDownLatch(1);
                // thus as workaround, use updateSegments which eventually calls commitSegmentInfos on latest segment infos.
        verify(mock, times(0)).publish(any(), any());
            }
    public void testMergedSegmentReplicationWithZeroReplica() throws Exception {
    /**
            assertFalse(primary.scheduledRefresh());
        IndexShard primary = shards.getPrimary();
    protected void startReplicationAndAssertCancellation(
            replicateSegments(primaryShard, shards.getReplicas());
                    List<StoreFileMetadata> filesToFetch,
            while ((op = snapshot.next()) != null) {
            null,
        // verify checkpoint is published
            // after segment replication, _4.si is removed from pending merge segments
        } finally {
}
        .build();
import org.opensearch.cluster.ClusterChangedEvent;
            } catch (InterruptedException e) {
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.ClusterState;
    protected void assertDocCounts(IndexShard indexShard, int expectedPersistedDocCount, int expectedSearchableDocCount)
import org.opensearch.snapshots.SnapshotId;
            replicaShard.cleanupRedundantPendingMergeSegment(referencedSegmentsCheckpoint);
        assertEquals(false, primaryShard.getReplicationTracker().isPrimaryMode());
import java.util.function.BiConsumer;
                MergedSegmentPublisher.EMPTY
        CountDownLatch latch = new CountDownLatch(1);
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory());) {
            replicateSegments(primaryShard, List.of(replicaShard));
 * compatible open source license.
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
import org.opensearch.core.action.ActionListener;
            // Perform close on searcher before IndexShard::finalizeReplication
        // Test that the pre-copy merged segment exception will not cause primary shard to fail
            shards.startAll();
        shards.indexDocs(10);
            replicateSegments(primary, List.of(replicaSpy));
        CountDownLatch latch = new CountDownLatch(1);
            final long initialCheckpointSize = primaryCheckpoint.getMetadataMap()
import org.opensearch.common.settings.ClusterSettings;
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
    // Todo: Remove this test when there is a better mechanism to test a functionality passing in different replication
        IndexShardTestCase.updateRoutingEntry(primarySource, primarySource.routingEntry().relocate(randomAlphaOfLength(10), -1));
            doAnswer(ans -> {
        final IndexShard shard = newStartedShard(true, getIndexSettings());
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO)
    }
            final SnapshotShardsService shardsService = getSnapshotShardsService(
            ReplicationGroup shards = createGroup(
        }
    public void testIsReplicationTargetFalseAfterShardClosed() throws IOException {
            primaryShard.refresh("test");
                throw new RuntimeException(e);
            shards.assertAllEqual(10);
            shards.indexDocs(numDocs);
            IndexShard primary = shards.getPrimary();
            new IndexShardRoutingTable.Builder(shardRouting.shardId()).addShard(shardRouting).build()
    }
        closeShards(shard);
            sourceFactory,
import org.opensearch.index.replication.TestReplicationSource;
        );
            assertEquals(sizeAfterDeleteAndCommit, shardStats.getBytesBehindCount());
        IndexShard shard = newStartedShard(p -> newShard(false, mock, settings), false);
        ShardRouting shardRouting = shard.shardRouting;
     * made on doc count on both primary and replica.
    /**
                1,
            primaryShard.forceMerge(new ForceMergeRequest().maxNumSegments(1).flush(true));
    protected void assertEqualCommittedSegments(IndexShard primary, IndexShard... replicas) throws IOException {
            shards.indexDocs(10);
        for (int i = 0; i < numberOfAcquisitions; i++) {
            }
                );
 *
    // Todo: Remove this test when there is a better mechanism to test a functionality passing in different replication
            shards.indexDocs(10);
            shards.startAll();
    }
                engine.updateSegments(engine.getSegmentInfosSnapshot().get());
    ) {
        });
    }
        closeShards(indexShard);
import org.opensearch.indices.replication.common.ReplicationState;
        return new SegmentReplicationTargetService(
            }
     * can result in Lucene CorruptIndexException.
    protected ReplicationGroup getReplicationGroup(int numberOfReplicas) throws IOException {
        // Test that the pre-copy merged segment logic does not block the merge process of the primary shard when there are 0 replica shard.
            doAnswer(ans -> {
    protected ReplicationGroup getReplicationGroup(int numberOfReplicas, String indexMapping) throws IOException {
            startReplicationAndAssertCancellation(replica, primary, targetService);
            replicateSegments(primaryShard, List.of(spyShard));
                    @Override
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        Thread recoveryThread = new Thread(() -> {
                (primary, sourceNode) -> new RecoveryTarget(primary, sourceNode, new ReplicationListener() {
                relocationStarted.await();
     */
            }).when(spy).newReadWriteEngine(any());
        verify(mock, times(0)).publish(any(), any());
            replicateSegments(primaryShard, shards.getReplicas());
        for (int i = 0; i < totalOps; i++) {
                try {
        SnapshotsInProgress.State snapshotState,
            assertFalse(shard.isRelocatedPrimary());
            replicateSegments(primaryShard, List.of(replicaShard));
            );
            SnapshotInfoTests.randomUserMetadata(),
            shards.indexDocs(numDocs);
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            new IndexShardRoutingTable.Builder(shardRouting.shardId()).addShard(shardRouting).build()
            public void onFailure(Exception e) {
            final int numDocs = randomIntBetween(10, 20);
import org.opensearch.indices.replication.common.ReplicationListener;
                public void getSegmentFiles(
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            doAnswer(n -> {
            shards.indexDocs(numDocs);
            shards.assertAllEqual(10);
                SnapshotsInProgress.State.INIT,
            latch.countDown();
            new SnapshotsInProgress.ShardSnapshotStatus(state.getNodes().getLocalNode().getId(), "1")
                    failed.set(e);
import org.opensearch.cluster.SnapshotsInProgress;
                replicaShard,
            final IndexShard replica = shards.getReplicas().get(0);
        try (
import org.opensearch.indices.replication.common.ReplicationFailedException;
        boolean shallowCopySnapshot
            .build();
            doThrow(AlreadyClosedException.class).when(replicaSpy).finalizeReplication(any(CatalogSnapshot.class));
import org.opensearch.index.engine.Engine;
            primaryShard.refresh("test");
                    }
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();
        final IndexShard primaryTarget = newShard(
    public void testMergedSegmentReplication() throws Exception {
                    primaryContext -> relocationStarted.countDown(),
            logger.info("--> primary store after final flush {}", Arrays.toString(primaryShard.store().directory().listAll()));
            try {
                recoverySettings,
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"foo\": { \"type\": \"keyword\"} }}}";
    /**
        recoveryThread.join();
import java.util.List;
     * here we are starting a new primary shard in PrimaryMode initially and starting relocation handoff. Later we complete relocation handoff then shard is no longer
            randomLong(),
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
        // A primary shard uses InternalEngine → not a replication target.
    public void testReplication() throws Exception {
        }
            }
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);
import java.io.IOException;
        final RecoverySettings recoverySettings = new RecoverySettings(
import org.opensearch.action.admin.indices.flush.FlushRequest;
            )
            shardRouting.shardId(),
        }
        primary.store().close();
    }
    public void testDelayedOperationsBeforeAndAfterRelocated() throws Exception {
        Set<SegmentReplicationShardStats> initialStats = primaryShard.getReplicationStatsForTrackedReplicas();
            shards.assertAllEqual(2 * numDocs);
        when(indexService.getMetadata()).thenReturn(
                recoverySettings,
                    // set the listener, we will only fail it once we cancel the source.
        assertTrue(primary.isSearchIdle());
    }
        SegmentReplicationTargetService spy = spy(sut);
            latch.await();
            final SegmentInfos primaryInfos = primary.store().readLastCommittedSegmentsInfo();
                try (final Translog.Snapshot replicaSnapshot = getTranslog(replica).newSnapshot()) {
            Exception.class,
            // ensure search idle conditions are met.
                    Assert.fail("Replication should not complete");
            assertEquals(0, replicaShard.getPendingMergedSegmentCheckpoints().size());
    public void testBeforeIndexShardClosedWhileCopyingFiles() throws Exception {
                    this.listener = listener;
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir())) {
import org.opensearch.indices.replication.SegmentReplicationTarget;
            final AtomicReference<Throwable> failed = new AtomicReference<>();
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
import java.util.ArrayList;
        primaryShard.getReplicationTracker().startRelocationHandoff(id);
        final IndexShard replicaShard = shards.getReplicas().get(0);
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(latestPrimaryMetadata, latestReplicaMetadata);
import java.util.function.Function;
    }
            // After the pre-copy merged segment is completed, the merged segment is not visible in the replica, and the number of segments
                replicatePrimaryFunction
        // recovery can be now finalized
            final Map<String, StoreFileMetadata> latestReplicaMetadata = replica.store().getSegmentMetadataMap(replicaInfos);
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);
            final IndexShard replicaShard = shards.getReplicas().get(0);
import org.opensearch.common.unit.TimeValue;
        return settings;
                shardsService.clusterChanged(
            shards.assertAllEqual(numDocs);
                    final ExecutionException e = expectThrows(ExecutionException.class, () -> onLockAcquired.get(30, TimeUnit.SECONDS));
                        invoked.set(true);
                .mapToLong(StoreFileMetadata::length)
     */
import org.opensearch.indices.replication.SegmentReplicationState;
import static org.mockito.Mockito.doAnswer;
            shards.assertAllEqual(numDocs);
        return ClusterState.builder(state)
import static org.mockito.Mockito.when;
        shards.promoteReplicaToPrimary(newPrimary);
                    latch.countDown();
                n.callRealMethod();
        IndexShard primaryShard = newStartedShard(true);
            // However infos version we expect to be equal.
            try (final GatedCloseable<SegmentInfos> gatedCloseable = primaryTuple.v1()) {
            // assert there is no pending refresh
        }
            assertReplicaCaughtUp(primaryShard);
                });
            logger.info("--> Inserting documents {}", numDocs);
     * here we are starting a new primary shard in PrimaryMode and testing if the shard publishes checkpoint after refresh.
            try {
    }
                    final ExecutionException e = expectThrows(ExecutionException.class, () -> onLockAcquired.get(30, TimeUnit.SECONDS));
import org.opensearch.action.support.PlainActionFuture;
            replicateSegments(primaryShard, shards.getReplicas());
            public void onResponse(Releasable releasable) {
        final IndexShard newPrimary = getRandomReplica(shards);
     * Similar to test above, this test shows the issue where an engine close operation during active segment replication
            assertTrue(replica.hasRefreshPending());
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.common.settings.Settings;
                    shards.assertAllEqual(10);
            assertTrue(primaryShard.getReplicationEngine().isEmpty());
                };
            )
            final IndexShard primaryShard = shards.getPrimary();
        // ensure search idle conditions are met.
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build(),
            final IndexShard primaryShard = shards.getPrimary();
        assertFalse(primary.scheduledRefresh());
                .stream()
    public void testPrimaryRelocationWithSegRepFailure() throws Exception {
        Thread recoveryThread = new Thread(() -> {
            shards.indexDocs(numDocs);
        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, "DOCUMENT").put(Settings.EMPTY).build();
        // Starting relocation handoff
            Collections.singletonList(new IndexId(index.getName(), index.getUUID())),
            }
     */
            // primary:
                throw new RuntimeException(e);
            flushShard(primaryShard);
            assertEqualTranslogOperations(shards, primaryShard);
    public void testShardIdleWithNoReplicas() throws Exception {
            }
            )
    }
    public void testPublishCheckpointOnPrimaryMode() throws IOException, InterruptedException {
            primary.refresh("test");
                snapshot,
    public void testPublishCheckpointAfterRelocationHandOff() throws IOException {
                getIndexSettings(),
    }
    public void testSegmentInfosAndReplicationCheckpointTuple() throws Exception {
                createRepositoriesService()
    public void testSegmentReplicationStats() throws Exception {
            primaryShard.refresh("test");
            listener.onResponse(
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
        final CountDownLatch startRecovery = new CountDownLatch(1);
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
        IndexShard spyShard = spy(primaryShard);
        final RecoverySettings recoverySettings = new RecoverySettings(
                    }
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
            shallowCopySnapshot
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");
            List<Translog.Operation> operations = new ArrayList<>();
import org.opensearch.indices.IndicesService;
            throw new UncheckedIOException(e);
            try (final GatedCloseable<SegmentInfos> gatedCloseable = replicaTuple.v1()) {
        try (
    }
        ClusterState state,
            assertEquals(0, primary.getLatestReplicationCheckpoint().compareTo(replica.getLatestReplicationCheckpoint()));
        );
        final ExecutionException e = expectThrows(ExecutionException.class, () -> acquirePrimaryOperationPermitBlockingly(shard));
            assertTrue(primary.isSearchIdle());
            // Step 3. Before replicating segments, block finalizeReplication and perform engine commit directly that
            assertFalse(replica.hasRefreshPending());
            assertTrue(primary.hasRefreshPending());
            try {
                        super.onResponse(releasable);
            assertEquals(1, primaryShard.segments(false).size());
        assertEquals(checkpoint.getSegmentInfosVersion(), segmentInfos.getVersion());
        assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
        throws IOException {
                    ReplicationCheckpoint checkpoint,
        String id = primaryShard.routingEntry().allocationId().getId();
    }
                    @Override
        }
            SegmentReplicationShardStats shardStats = postRefreshStats.stream().findFirst().get();
            assertFalse(replica.scheduledRefresh());
        // Verify that checkpoint is not processed as shard routing is primary.
        }
     * it asserts point in time seqNos are relative to the doc counts.
import static org.mockito.Mockito.any;
        Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction = (shardList) -> {
 * The OpenSearch Contributors require contributions made to
            threadPool,
    /**
    protected Settings getIndexSettings() {
            Collections.singleton(shardRouting.allocationId().getId()),
            if (shard != null) {
            final Snapshot snapshot = new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5)));
            }
import java.util.concurrent.ExecutionException;
                public void onReplicationDone(SegmentReplicationState state) {
        return new SnapshotShardsService(settings, clusterService, repositoriesService, transportService, indicesService);
                .values()
        Snapshot snapshot,
            );
            primaryShard.refresh("Test");
        IndexShard shard = newStartedShard(true);
    public void testQueryDuringEngineResetShowsDocs() throws Exception {
        for (final Runnable assertion : assertions) {
            doAnswer(n -> {
            shards.startAll();
                return null;
        shard.getReplicationTracker().startRelocationHandoff(id);
        latch.await();
            int numDocs = randomIntBetween(10, 20);
        String id = shard.routingEntry().allocationId().getId();
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    public void testPublishCheckpointPostFailover() throws IOException {
                    targetService.beforeIndexShardClosed(replica.shardId, replica, Settings.EMPTY);
                recoverySettings,
            shards.startAll();
        shards.startPrimary();
            // After the pre-copy merged segment is completed, the merged segment is not visible in the replica, and the number of segments
    }
        for (IndexShard shard : shards) {
import static org.mockito.Mockito.doThrow;
                latch.countDown();
    public void testIsSegmentReplicationAllowed_WrongEngineType() throws IOException {
                    assertThat(replicaSnapshot, SnapshotMatchers.containsOperationsInAnyOrder(operations));
            assertReplicaCaughtUp(primaryShard);
            assertReplicaCaughtUp(primaryShard);
            try (final GatedCloseable<SegmentInfos> gatedCloseable = replicaTuple.v1()) {
            when(sourceFactory.get(any())).thenReturn(source);
package org.opensearch.index.shard;
import java.util.concurrent.atomic.AtomicReference;
        );
                getIndexSettings(),
        final ReplicationCheckpoint replicationCheckpoint = indexShard.getLatestReplicationCheckpoint();
                    // simulate listener resolving, but only after we have issued a cancel from beforeIndexShardClosed .
            Engine.Searcher test = getEngine(replicaShard).acquireSearcher("testSegmentReplication_With_ReaderClosedConcurrently");
import org.opensearch.indices.replication.GetSegmentFilesResponse;
            replicaShard.close("test", false, false);
import org.opensearch.indices.replication.common.ReplicationType;
        }
                primarySource,
            replicaTuple = replica.getLatestSegmentInfosAndCheckpoint();
        closeShards(shard);
            replicateSegments(primaryShard, List.of(replicaShard));
                indexMapping,
        // verify checkpoint is not published
            primaryShard.refresh("test");
            primaryShard.refresh("test");
            shardsBuilder,
            final int numDocs = randomIntBetween(10, 20);
        final IndexShard primarySource = newStartedShard(true, getIndexSettings());
        final int recoveryIndex = randomIntBetween(0, numberOfAcquisitions - 1);
                }
            // generate segment _0.si and _1.si
        final IndexShard indexShard = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
                assertReplicationCheckpoint(replica, gatedCloseable.get(), replicaTuple.v2());
                shard.relocated(
            Translog.Operation op;
        closeShards(replica);
            shards.indexDocs(numDocs);
                NRTReplicationEngine engine = (NRTReplicationEngine) getEngine(replicaShard);
                final Engine engineOrNull = getEngine(replicaShard);
                MergedSegmentPublisher.EMPTY
            shards.refresh("test");
                    assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
            Set<SegmentReplicationShardStats> postRefreshStats = primaryShard.getReplicationStatsForTrackedReplicas();
        final IndexShard indexShard = newStartedShard(
import org.opensearch.index.translog.Translog;
            if (i < recoveryIndex) {
            .put(getIndexSettings())
import java.util.Map;
                    ActionListener<CheckpointInfoResponse> listener
import org.opensearch.repositories.IndexId;
import org.junit.Assert;
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
        verify(mock, times(1)).publish(any(), any());
    public void testRejectCheckpointOnShardRoutingPrimary() throws IOException {
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        }
                new NRTReplicationEngineFactory(),
            // replica would always return false here as there is no indexed doc to refresh on.
            shards.refresh("test");
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
                    assertTrue(engineOrNull instanceof ReadOnlyEngine);
            primaryShard.refresh("test");
import java.util.Collections;
import static org.mockito.Mockito.times;
                getIndexSettings(),
    }
            }).when(spyShard).finalizeReplication(any(CatalogSnapshot.class));
            final IndexShard primaryShard = shards.getPrimary();
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
                        releasable.close();
            final int numDocs = shards.indexDocs(randomIntBetween(1, 10));
            final IndexShard replica = shards.getReplicas().get(0);
            // after cleanup redundant pending merge segment, _2.si is removed from pending merge segments
            primary.getLatestReplicationCheckpoint(),
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build(),
            randomNonNegativeLong(),
            // replica:
            replica,
                assertEquals(latestReplicationCheckpoint, primaryShard.computeReplicationCheckpoint(segmentInfosSnapshot.get()));
            replicateSegments(primaryShard, List.of(replicaShard));
        // Completing relocation handoff
import org.opensearch.index.mapper.MapperService;
    private void assertReplicationCheckpoint(IndexShard shard, SegmentInfos segmentInfos, ReplicationCheckpoint checkpoint)
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
                    @Override
            ReplicationGroup shards = createGroup(
        assertEquals(0, shardStats.getCheckpointsBehindCount());
            flushShard(primaryShard);
            @Override
        IndexShard shard = newStartedShard(p -> newShard(false, mock, settings), false);
    }
        return newPrimary;
            for (int i = 0; i < numDocs; i++) {
                @Override
    }
                assertEquals(IndexShardSnapshotStatus.Stage.FAILURE, stage);
                replicaShard,
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory())) {
            shards.startAll();
        shards.indexDocs(10);
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
        shard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
                    assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
            primaryTuple = primary.getLatestSegmentInfosAndCheckpoint();
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
        // Test that the pre-copy merged segment logic does not block the merge process of the primary shard when there are 1 replica shard.
            }
import org.opensearch.snapshots.SnapshotShardsService;
            shardStats = statsAfterFlush.stream().findFirst().get();
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
import java.io.UncheckedIOException;
        assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
                releasable.close();
        final Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardsBuilder = new HashMap<>();
    public void testCloseShardDuringFinalize() throws Exception {
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), mappings, new NRTReplicationEngineFactory())) {
        closeShards(primaryShard);
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            shards.assertAllEqual(10);
    private static final Settings settings = Settings.builder()
        // Starting a new shard in PrimaryMode and shard routing primary.
                new NRTReplicationEngineFactory(),
            flushShard(primaryShard);
            shards.promoteReplicaToPrimary(replicaShard).get();
                }
     * It does this by blocking the finalizeReplication on replica shard and performing close operation on acquired
    }
            assertEquals(2, replicaShard.segments(false).size());
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
import java.util.Set;
        latch.await(2, TimeUnit.SECONDS);
            // start finalization of recovery
     * Assert persisted and searchable doc counts.  This method should not be used while docs are concurrently indexed because
            }
        MergedSegmentPublisher mergedSegmentPublisherWithException = new MergedSegmentPublisher((indexShard, checkpoint) -> {
            assertEquals(ReplicationCheckpoint.empty(primaryShard.shardId), primaryShard.computeReplicationCheckpoint((SegmentInfos) null));
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO)
    }
            replicateSegments(primaryShard, shards.getReplicas());
    ) throws InterruptedException {
        assertEquals(true, primaryShard.routingEntry().primary());
import org.opensearch.index.engine.ReadOnlyEngine;
            // verify primary segment count and replica pending merge segment count
                assertAtMostOneLuceneDocumentPerSequenceNumber(getEngine(replicaShard));
     */
import org.opensearch.indices.recovery.RecoverySettings;
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);
     */
                .sum();
            } else {
            try (final GatedCloseable<SegmentInfos> gatedCloseable = primaryTuple.v1()) {
                return ans.callRealMethod();
     * in PrimaryMode, and we test if the shard does not publish checkpoint after refresh.
        try (Releasable ignored = acquirePrimaryOperationPermitBlockingly(shard)) {
            logger.error("Unexpected error computing CopyState", e);
import static org.opensearch.index.engine.EngineTestCase.assertAtMostOneLuceneDocumentPerSequenceNumber;
                assertions.add(() -> assertTrue(invoked.get()));
     */
            replicateMergedSegments(primaryShard, List.of(replicaShard));
            // index and replicate segments to replica.
            final IndexShard replica = shards.getReplicas().get(0);
            .build();
        closeShards(shard);
            final IndexShard primaryShard = shards.getPrimary();
            logger.info("--> Ingest {} docs again", numDocs);
            flushShard(primaryShard);
            replicateSegments(primaryShard, shards.getReplicas());
import static org.mockito.Mockito.mock;
    }
                shards.getIndexMetadata(),
            int numDocs = randomIntBetween(10, 20);
    }
            flushShard(primaryShard);
            shards.indexDocs(randomIntBetween(1, 10));
            null
import org.apache.lucene.codecs.Codec;
            shards.assertAllEqual(numDocs);
    }
                        addSnapshotIndex(clusterService.state(), snapshot, replicaShard, SnapshotsInProgress.State.STARTED, false),
            primary.refresh("Test");
                    copy.getFailure()
                    assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
            primaryShard.refresh("test");
        };
            try (final GatedCloseable<SegmentInfos> closeable = latestSegmentInfosAndCheckpoint.v1()) {
            IndexShard primaryShard = shards.getPrimary();
            logger.info("--> primary store after force merge {}", Arrays.toString(primaryShard.store().directory().listAll()));
                );
            shards.assertAllEqual(numDocs);
    }
