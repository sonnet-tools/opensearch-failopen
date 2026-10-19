        Settings indexSettings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, "DOCUMENT").put(Settings.EMPTY).build();  
            SegmentReplicationSource source = new TestReplicationSource() {
                getIndexSettings(),
            int numDocs = randomIntBetween(10, 20);
            Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> primaryTuple = primary.getLatestSegmentInfosAndCheckpoint();
        IndexShard shard = newStartedShard(p -> newShard(false, mock, settings), false);
            flushShard(primaryShard);
        IndexShardTestCase.updateRoutingEntry(shard, routing);
    /**
        }  
                    assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
            assertTrue(primary.scheduledRefresh());
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
import java.util.function.BiConsumer;  
     */
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir())) {
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);  
import org.opensearch.action.admin.indices.flush.FlushRequest;
import org.opensearch.common.concurrent.GatedCloseable;
        }  
            if (shard != null) {
            Exception.class,
                assertReplicationCheckpoint(replica, gatedCloseable.get(), replicaTuple.v2());  
    public void testPublishCheckpointAfterRelocationHandOff() throws IOException {
            final IndexShard primaryShard = shards.getPrimary();
            try (final GatedCloseable<SegmentInfos> gatedCloseable = primaryTuple.v1()) {
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");  
        } catch (IOException e) {  
            assertEquals(0, primary.getLatestReplicationCheckpoint().compareTo(replica.getLatestReplicationCheckpoint()));
            shards.indexDocs(10);
                NRTReplicationEngine engine = (NRTReplicationEngine) getEngine(replicaShard);
        final int recoveryIndex = randomIntBetween(0, numberOfAcquisitions - 1);  
                        addSnapshotIndex(clusterService.state(), snapshot, replicaShard, SnapshotsInProgress.State.STARTED, false),
                (primary, sourceNode) -> new RecoveryTarget(primary, sourceNode, new ReplicationListener() {
        IndexShard indexShard,  
            logger.info("--> primary store after force merge {}", Arrays.toString(primaryShard.store().directory().listAll()));
    }
        Snapshot snapshot,
import org.apache.lucene.index.SegmentInfos;
        assertEquals(expectedPersistedDocCount - 1, indexShard.seqNoStats().getLocalCheckpoint());
            } catch (InterruptedException e) {  
        refreshListener.afterRefresh(true);
            shards.startAll();  
            IndexShard primaryShard = shards.getPrimary();
        IndexMetadata indexMetadata,
        String id = shard.routingEntry().allocationId().getId();  
        final ShardRouting shardRouting = shard.routingEntry();  
                ActionListener<GetSegmentFilesResponse> listener;
            assertTrue(replica.isSearchIdle());
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(segmentMetadataMap, replicaShard.getSegmentMetadataMap());
     */
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);  
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, spy, createTempDir())) {  
            }  
            assertTrue(primaryShard.getReplicationEngine().isEmpty());  
        closeShards(shard);
        refreshListener.afterRefresh(true);  
            shards.refresh("test");  
        indexShard.addRefreshListener(mock(Translog.Location.class), Assert::assertFalse);
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
import org.opensearch.indices.replication.common.ReplicationListener;
            randomLong(),
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            // Step 3. Before replicating segments, block finalizeReplication and perform engine commit directly that  
            shards.refresh("test");
        // Verify that checkpoint is not processed as shard routing is primary.  
                startRecovery.await();  
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);  
            .build();
            doAnswer(n -> {  
            shards.assertAllEqual(numDocs);
import org.opensearch.index.IndexService;
            try (final GatedCloseable<SegmentInfos> closeable = latestSegmentInfosAndCheckpoint.v1()) {
    public void testCloseShardDuringFinalize() throws Exception {
            shards.indexDocs(numDocs);
            // generate pending merge segment _2.si  
            // We use compareTo here instead of equals because we ignore segments gen with replicas performing their own commits.
            shards.assertAllEqual(10);
            final int numDocs = shards.indexDocs(randomIntBetween(1, 10));
                    assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));  
                assertTrue(engineOrNull instanceof ReadOnlyEngine);  
     * here we are starting a new primary shard and testing that we don't process a checkpoint on a shard when it's shard routing is primary.  
import org.opensearch.action.index.IndexRequest;
        shards.promoteReplicaToPrimary(newPrimary);  
        // Test that the pre-copy merged segment exception will not cause primary shard to fail  
            }
        final ExecutionException e = expectThrows(ExecutionException.class, () -> acquirePrimaryOperationPermitBlockingly(shard));
                    public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {  
        IndexShard shard = newStartedShard(true);
                public void getSegmentFiles(
            assertTrue(primary.isSearchIdle());
                };
import org.opensearch.index.engine.Engine;  
            replicaShard.cleanupRedundantPendingMergeSegment(referencedSegmentsCheckpoint);  
     */
        });
    public void testLockingBeforeAndAfterRelocated() throws Exception {
                    public void onDone(ReplicationState state) {
import java.util.concurrent.TimeUnit;  
import org.opensearch.indices.replication.SegmentReplicationTarget;
                    }  
            () -> recoverReplica(
    }
            assertTrue(replica.hasRefreshPending());  
            @Override  
        // Test that the pre-copy merged segment logic does not block the merge process of the primary shard when there are 0 replica shard.  
            throw new RuntimeException("mock exception");
        Settings updatedSettings = Settings.builder()
        Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT).build();  
        }
        final NRTReplicationEngineFactory engineFactory = new NRTReplicationEngineFactory();
    }
            assertTrue(diff.missing.isEmpty());
            // replica would always return false here as there is no indexed doc to refresh on.
    private void assertReplicaCaughtUp(IndexShard primaryShard) {
                        initState  
        SnapshotsInProgress.State snapshotState,  
        IndexShard shard = newStartedShard(p -> newShard(false, mock, settings), false);  
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO)
                        assertEquals(ExceptionsHelper.unwrap(e, IOException.class).getMessage(), "Expected failure");
        final ShardRouting routing = ShardRoutingHelper.relocate(shard.routingEntry(), "other_node");  
    }
                shardsService.clusterChanged(
    protected IndexShard getRandomReplica(ReplicationGroup shards) {
                assertEquals(latestReplicationCheckpoint, primaryShard.computeReplicationCheckpoint(closeable.get()));  
import org.apache.lucene.codecs.Codec;
        );
                throw new RuntimeException(e);
import org.junit.Assert;
import java.util.Set;  
            replicaShard.close("test", false, false);
            final IndexShard primaryShard = shards.getPrimary();  
            // replica:  
        final NRTReplicationEngineFactory spy = spy(engineFactory);  
        Settings updatedSettings = Settings.builder()
            }
                assertReplicationCheckpoint(replica, gatedCloseable.get(), replicaTuple.v2());  
            int numDocs = randomIntBetween(10, 20);
            replicateSegments(primary, shards.getReplicas());  
                // delete on replica for xlog.
            }
            // cleans up recently copied over files
            } else {
            }
            shards.indexDocs(numDocs);
    public void testPrimaryRelocationWithSegRepFailure() throws Exception {  
            Engine.Searcher test = getEngine(replicaShard).acquireSearcher("testSegmentReplication_With_ReaderClosedConcurrently");
            for (DocIdSeqNoAndSource docIdAndSeqNo : docIdAndSeqNos.subList(0, 5)) {
import org.opensearch.cluster.ClusterState;
                // Using engine.close() prevents indexShard.finalizeReplication execution due to engine AlreadyClosedException,
            for (int i = 0; i < numDocs; i++) {  
        assertTrue(primary.hasRefreshPending());
            final IndexShard primary = shards.getPrimary();  
                onLockAcquired = new PlainActionFuture<>();
            new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),  
            shards.startAll();  
                assertNotNull(engineOrNull);
            throw new UncheckedIOException(e);  
                    ActionListener<GetSegmentFilesResponse> listener
        closeShards(primarySource, primaryTarget);  
            // assert before any indexing:
import java.util.List;
        return newPrimary;
            assertEqualTranslogOperations(shards, primaryShard);  
    // strategy.  
        closeShards(primaryShard);
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
        }
import java.io.IOException;
            shards.assertAllEqual(5);
            assertReplicaCaughtUp(primaryShard);
                final IndexShardSnapshotStatus.Copy copy = shardsService.currentSnapshotShards(snapshot).get(replicaShard.shardId).asCopy();  
import org.opensearch.test.VersionUtils;
            shards.refresh("test");
    // Todo: Remove this test when there is a better mechanism to test a functionality passing in different replication
                    assertFalse(sendShardFailure);  
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);  
import org.opensearch.core.action.ActionListener;
        final SegmentReplicationTarget target = targetService.startReplication(
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
     */
            latch.countDown();
            final AtomicReference<Throwable> failed = new AtomicReference<>();
    /**
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsCheckpoint;
        RepositoriesService repositoriesService  
                } catch (Throwable e) {
            .put(getIndexSettings())
        verify(mock, times(1)).publish(any(), any());
                latch.countDown();  
        final CountDownLatch relocationStarted = new CountDownLatch(1);  
            if (i < recoveryIndex) {
        try (
import org.opensearch.cluster.routing.ShardRoutingHelper;  
    }  
        assertEquals(true, primaryShard.routingEntry().primary());
        replicateSegments(primaryShard, shards.getReplicas());
    protected IndexShard failAndPromoteRandomReplica(ReplicationGroup shards) throws IOException {  
import org.apache.lucene.store.AlreadyClosedException;  
        }
            shards.indexDocs(10);
                    final ExecutionException e = expectThrows(ExecutionException.class, () -> onLockAcquired.get(30, TimeUnit.SECONDS));  
import static org.mockito.ArgumentMatchers.anyInt;
    }
                    List<StoreFileMetadata> filesToFetch,
    }  
        IndexShard primary,  
                ) {
            final IndexShard replicaShard = shards.getReplicas().get(0);  
            primaryShard.refresh("test");  
     * can result in Lucene CorruptIndexException.  
            primary.refresh("Test");
            Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> replicaTuple = replica.getLatestSegmentInfosAndCheckpoint();
                );
/*  
            replicateSegments(primaryShard, shards.getReplicas());  
            shards.refresh("test");
            List<Translog.Operation> operations = new ArrayList<>();
            logger.error("Unexpected error computing CopyState", e);
     */
        final int numberOfAcquisitions = randomIntBetween(1, 10);
            }).when(spy).newReadWriteEngine(any());  
            ReplicationGroup shards = createGroup(  
        try {
                    ReplicationCheckpoint checkpoint,  
            }
            try (final GatedCloseable<SegmentInfos> gatedCloseable = replicaTuple.v1()) {
                mergedSegmentPublisherWithException  
     * Validates happy path of segment replication where primary index docs which are replicated to replica shards. Assertions  
    public void testMergedSegmentReplicationWithException() throws Exception {
            null,
    /**  
            final IndexShard primaryShard = shards.getPrimary();
                    IndexShard indexShard,
    }  
            assertEquals(1, shardStats.getCheckpointsBehindCount());
                releasable.close();
import java.util.concurrent.atomic.AtomicBoolean;
                1,
            replicateSegments(primaryShard, List.of(replicaShard));
            final IndexShard replica = shards.getReplicas().get(0);  
            null,  
            // index and replicate segments to replica.
            try (final GatedCloseable<SegmentInfos> gatedCloseable = replicaTuple.v1()) {
            assertNull("Expected correct doc count during engine reset", failed.get());
            shardStats = statsAfterFlush.stream().findFirst().get();
        // verify checkpoint is not published  
import org.opensearch.cluster.metadata.IndexMetadata;  
        // verify checkpoint is published
        assertFalse(primary.scheduledRefresh());
            replicaTuple = replica.getLatestSegmentInfosAndCheckpoint();  
                final Engine engineOrNull = getEngine(replicaShard);
        closeShards(shard);
            snapshot,
        }
                recoverySettings,  
            // verify primary segment count and replica pending merge segment count
        SegmentReplicationTargetService sut;
            assertEquals(1, primaryShard.segments(false).size());
            // Perform close on searcher before IndexShard::finalizeReplication
import org.opensearch.index.engine.NRTReplicationEngineFactory;  
        final IndexShard primaryTarget = newShard(
                @Override  
    public void testNoDuplicateSeqNo() throws Exception {
            }  
            Translog.Operation op;
    public void testSnapshotWhileFailoverIncomplete() throws Exception {  
        recoveryThread.start();
            closeShards(replica);
        when(transportService.getThreadPool()).thenReturn(threadPool);  
                MergedSegmentPublisher.EMPTY  
        shards.recoverReplica(primary);
        // Test that the pre-copy merged segment logic does not block the merge process of the primary shard when there are 1 replica shard.  
    }  
            final IndexShard replicaShard = shards.getReplicas().get(0);
            shards.indexDocs(10);
import static org.mockito.Mockito.times;
        primary.store().close();
        CheckpointRefreshListener refreshListener = new CheckpointRefreshListener(shard, mock);
        assertEquals(initialStats.size(), 1);
                replicatePrimaryFunction  
        recoveryThread.join();
            new SegmentReplicationTargetService.SegmentReplicationListener() {
            final IndexShard replicaShard = shards.getReplicas().get(0);
        }  
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
                    // set the listener, we will only fail it once we cancel the source.  
            replicateSegments(primaryShard, List.of(spyShard));
import static org.mockito.Mockito.verify;
            assertEquals(2, replicaShard.getPendingMergedSegmentCheckpoints().size());
    public void testSegmentReplication_With_ReaderClosedConcurrently() throws Exception {
import static org.mockito.Mockito.doAnswer;  
            shards.indexDocs(numDocs);
            // invoke scheduledRefresh, returns true if refresh is immediately invoked.  
import static org.hamcrest.Matchers.hasToString;
        try (final Translog.Snapshot snapshot = getTranslog(primaryShard).newSnapshot()) {  
            final Map<String, StoreFileMetadata> segmentMetadataMap = primaryShard.getSegmentMetadataMap();  
            // Assertions
        Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction = (shardList) -> {
        );
     * Assert persisted and searchable doc counts.  This method should not be used while docs are concurrently indexed because
        SegmentReplicationTargetService spy = spy(sut);  
import org.opensearch.common.collect.Tuple;
                true,
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory());) {
        for (IndexShard replica : replicas) {  
            shards.startAll();  
            flushShard(primaryShard);  
        final IndexShard indexShard = newStartedShard(false, indexSettings);
            }
            assertEquals(0, primary.getLatestReplicationCheckpoint().compareTo(replica.getLatestReplicationCheckpoint()));
        });
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
import static org.opensearch.index.engine.EngineTestCase.assertAtMostOneLuceneDocumentPerSequenceNumber;  
                    assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
    }
            )
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO)  
        Thread recoveryThread = new Thread(() -> {
            }
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
                final IndexShardSnapshotStatus.Stage stage = copy.getStage();
        try {  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT)
            threadPool,
     * made on doc count on both primary and replica.
            primaryTuple = primary.getLatestSegmentInfosAndCheckpoint();
        final CountDownLatch latch = new CountDownLatch(1);  
                    @Override
                        .contains("snapshot triggered on a new primary following failover and cannot proceed until promotion is complete")  
        .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
            // primary:  
                throw new RuntimeException(e);  
            new IndexShardRoutingTable.Builder(shardRouting.shardId()).addShard(shardRouting).build()  
        final SnapshotsInProgress.Entry entry = new SnapshotsInProgress.Entry(  
            primaryShard.refresh("test");  
                engine.updateSegments(engine.getSegmentInfosSnapshot().get());
            replica,
import org.opensearch.indices.replication.GetSegmentFilesResponse;
        );
        );
            final IndexShard replicaShard = shards.getReplicas().get(0);
            final IndexShard primaryShard = shards.getPrimary();
            latch.countDown();  
            final ReplicationCheckpoint latestReplicationCheckpoint = primaryShard.getLatestReplicationCheckpoint();
            // assert there is no pending refresh
            sourceFactory,
                final Translog.Operation newOp = op;
            final long sizeAfterDeleteAndCommit = diff.missing.stream().mapToLong(StoreFileMetadata::length).sum();
    /**
    }
            shards.startAll();  
                    @Override  
                new NRTReplicationEngineFactory(),
                assertions.add(() -> {  
            replicaTuple = replica.getLatestSegmentInfosAndCheckpoint();
        ) {
            shards.startAll();  
import org.opensearch.cluster.routing.ShardRouting;
            // generate pending merge segment _4.si  
import org.opensearch.index.store.StoreFileMetadata;  
import org.opensearch.indices.replication.common.ReplicationState;
            final List<DocIdSeqNoAndSource> docIdAndSeqNos = getDocIdAndSeqNos(primaryShard);
                .stream()
import org.opensearch.common.unit.TimeValue;  
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
        assertEquals(expectedPersistedDocCount - 1, indexShard.seqNoStats().getMaxSeqNo());  
        shards.indexDocs(10);  
            primaryShard.forceMerge(new ForceMergeRequest().maxNumSegments(1).flush(true));
import org.opensearch.index.SegmentReplicationShardStats;
            shardRouting.shardId(),  
import org.opensearch.common.settings.Settings;
            shards.removeReplica(replica);
        primaryShard.getReplicationTracker().startRelocationHandoff(id);
                });  
                deleteDoc(replicaShard, docIdAndSeqNo.getId());
            new IndexShardRoutingTable.Builder(shardRouting.shardId()).addShard(shardRouting).build()
        String id = primaryShard.routingEntry().allocationId().getId();
import org.opensearch.index.engine.DocIdSeqNoAndSource;
    }
        primary.close("demoted", true, false);
import java.util.concurrent.CountDownLatch;
            shards.indexDocs(numDocs);  
            assertEquals(1, primaryShard.segments(false).size());  
import org.opensearch.transport.TransportService;
    public void testNRTReplicasDoNotAcceptRefreshListeners() throws IOException {
            primaryShard.refresh("test");  
        // recovery can be now finalized
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
            Collections.singleton(shardRouting.allocationId().getId()),  
            SegmentReplicationShardStats shardStats = postRefreshStats.stream().findFirst().get();  
        shards.startPrimary();
            shards.indexDocs(numDocs);
import org.opensearch.test.junit.annotations.TestLogging;
                return null;  
                replicaShard,
            replicateSegments(primaryShard, List.of(replicaShard));
     * searcher that triggers the reader close operation.
        assertEquals(checkpoint.getSegmentInfosVersion(), segmentInfos.getVersion());  
     * Test that latestReplicationCheckpoint returns ReplicationCheckpoint for segrep enabled indices
                indexMapping,
        closeShards(replica);  
                throw new RuntimeException(e);
            IndexShard primary = shards.getPrimary();
        int totalOps = randomInt(10);
        }  
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), mappings, new NRTReplicationEngineFactory())) {  
            shards.startAll();  
import java.util.function.Function;
        }  
        shards.promoteReplicaToPrimary(replicaShard, (shard, listener) -> {  
            final SnapshotShardsService shardsService = getSnapshotShardsService(  
            logger.info("--> primary store after final flush {}", Arrays.toString(primaryShard.store().directory().listAll()));
        throws IOException {  
            replicateSegments(primaryShard, shards.getReplicas());  
        CountDownLatch latch = new CountDownLatch(1);  
            int numDocs = randomIntBetween(10, 20);  
import org.opensearch.index.store.Store;
import java.util.concurrent.atomic.AtomicReference;
    public void testIsSegmentReplicationAllowed_WrongEngineType() throws IOException {
        });  
        );
            assertEqualTranslogOperations(shards, primaryShard);
            }
            }
                assertReplicationCheckpoint(primary, gatedCloseable.get(), primaryTuple.v2());
        primaryShard.getReplicationTracker().completeRelocationHandoff();
import org.opensearch.indices.replication.common.CopyState;
            // After the pre-copy merged segment is completed, the merged segment is not visible in the replica, and the number of segments
        final TransportService transportService = mock(TransportService.class);
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;  
                        invoked.set(true);
import org.opensearch.cluster.ClusterChangedEvent;  
            replicateSegments(primaryShard, shards.getReplicas());  
    }  
            latch.await();
import java.util.Collections;
            mock(TransportService.class),
            logger.info("--> Inserting documents {}", numDocs);
                    final Engine engineOrNull = getEngine(replicaShard);
            // Step 1. Ingest numDocs documents  
            final SegmentInfos replicaInfos = replica.store().readLastCommittedSegmentsInfo();
            // generate segment _0.si and _1.si
            final IndexShard replicaSpy = spy(replica);  
        // Completing relocation handoff
            recoveryThread.start();
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"foo\": { \"type\": \"keyword\"} }}}";  
            // index and replicate segments to replica.  
    public void testSegmentReplicationStats() throws Exception {  
            shards.indexDocs(numDocs);
    public void testBeforeIndexShardClosedWhileCopyingFiles() throws Exception {
            while ((op = snapshot.next()) != null) {  
import static org.mockito.Mockito.mock;
        closeShards(indexShard);  
        assertTrue(primary.isSearchIdle());  
import static org.mockito.Mockito.spy;  
        }
        closeShards(shard);
        ClusterState state,  
            Collections.singletonList(new IndexId(index.getName(), index.getUUID())),
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));  
import org.opensearch.snapshots.SnapshotShardsService;  
            replicateMergedSegments(primaryShard, List.of(replicaShard));
    }
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build(),  
                    // simulate listener resolving, but only after we have issued a cancel from beforeIndexShardClosed .
    }
            // Step 2. Ingest numDocs documents again to create a new commit  
            shards.startAll();
                getIndexSettings(),
                try (final Translog.Snapshot replicaSnapshot = getTranslog(replica).newSnapshot()) {
                primaryTarget,  
                        super.onResponse(releasable);  
        verify(mock, times(0)).publish(any(), any());
            IndexShard spyShard = spy(replicaShard);
        // assigned seqNos start at 0, so assert max & local seqNos are 1 less than our persisted doc count.
            }  
                        throw new AssertionError("recovery must fail");
            final IndexShard replicaShard = shards.getReplicas().get(0);
                @Override  
        final IndexService indexService = mock(IndexService.class);
        }  
                assertReplicationCheckpoint(replica, gatedCloseable.get(), replicaTuple.v2());
import org.opensearch.cluster.routing.IndexShardRoutingTable;
            );
        );
        final RecoverySettings recoverySettings = new RecoverySettings(
import java.util.concurrent.ExecutionException;
            primaryShard.refresh("Test");
        IndexShard shard,
        final RecoverySettings recoverySettings = new RecoverySettings(
                shards.assertAllEqual(10);
            assertEquals(ReplicationCheckpoint.empty(primaryShard.shardId), primaryShard.computeReplicationCheckpoint((SegmentInfos) null));
        boolean shallowCopySnapshot
        closeShards(shard);
        final ShardRouting shardRouting = shard.routingEntry();
        shardsBuilder.put(
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
    }  
            }).when(spyShard).finalizeReplication(any(CatalogSnapshot.class));
                    primaryContext -> relocationStarted.countDown(),  
            final int numDocs = randomIntBetween(10, 20);
        }
                    resolveCheckpointInfoResponseListener(listener, primary);  
                throw new RuntimeException(e);
            Collections.singleton(shardRouting.allocationId().getId()),
    protected ReplicationGroup getReplicationGroup(int numberOfReplicas, String indexMapping) throws IOException {  
        closeShards(indexShard);
                .getLatestSegmentInfosAndCheckpoint();
    }  
            false,  
            shards.startAll();
        assertEquals("Should have resolved listener with failure", 0, latch.getCount());
            doAnswer(ans -> {  
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(Collections.singletonList(entry)))
     * in PrimaryMode, and we test if the shard does not publish checkpoint after refresh.  
            assertReplicaCaughtUp(primaryShard);
        assertDocCount(indexShard, expectedSearchableDocCount);
    public void testSegmentReplication_With_EngineClosedConcurrently() throws Exception {
            // However infos version we expect to be equal.  
            shards.assertAllEqual(10);
                false,  
            doThrow(AlreadyClosedException.class).when(replicaSpy).finalizeReplication(any(CatalogSnapshot.class));
        .build();  
        // Completing relocation handoff.  
        // A primary shard uses InternalEngine → not a replication target.
        }  
            shards.indexDocs(numDocs);
import org.opensearch.index.engine.ReadOnlyEngine;
        return createGroup(numberOfReplicas, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory());
                }
        final IndexShard shard = newStartedShard(true, getIndexSettings());
        }, ThreadPool.Names.GENERIC, "");  
            replicateMergedSegments(primaryShard, List.of(replicaShard));
                getIndexSettings(),
            indexDoc(primarySource, "_doc", Integer.toString(i));
            shards.promoteReplicaToPrimary(replicaShard).get();
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build(),
            primaryShard.refresh("Test");  
        }
    public void testIsReplicationTargetFalseAfterShardClosed() throws IOException {
        }
import org.opensearch.action.support.PlainActionFuture;
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
import org.opensearch.index.translog.Translog;
            shards.startAll();  
        final NRTReplicationEngineFactory spy = spy(engineFactory);
            logger.info("--> Inserting documents {}", numDocs);
            primaryShard.refresh("test");
            replicateSegments(primaryShard, List.of(replicaShard));
        when(indexService.getMetadata()).thenReturn(
            )
        final IndexShard indexShard = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));  
                    routing.getTargetRelocatingShard().allocationId().getId(),
            shards.indexDocs(numDocs);
    }
            replicateSegments(primary, List.of(replica));
            assertEquals(1, primaryShard.segments(false).size());  
        final RecoverySettings recoverySettings = new RecoverySettings(
                assertReplicationCheckpoint(primary, gatedCloseable.get(), primaryTuple.v2());  
            }  
        final SegmentReplicationCheckpointPublisher mock = mock(SegmentReplicationCheckpointPublisher.class);
                        "test",
        }  
        when(indexService.getShardOrNull(anyInt())).thenReturn(indexShard);
    }
        return shards.getReplicas().get(randomInt(shards.getReplicas().size() - 1));  
                    assertNotNull(engineOrNull);
                @Override
                n.callRealMethod();
            latch.await();  
            IndexShard spyShard = spy(replicaShard);
            try {  
import org.opensearch.indices.replication.common.ReplicationFailedException;  
            assertEqualTranslogOperations(shards, primaryShard);
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        Set<SegmentReplicationShardStats> initialStats = primaryShard.getReplicationStatsForTrackedReplicas();  
                    @Override
            .build();  
    }  
            doAnswer(ans -> {
                recoverySettings,
                public void cancel() {
                public void getCheckpointMetadata(
        CheckpointRefreshListener refreshListener = new CheckpointRefreshListener(shard, mock);
                }
                createRepositoriesService()
                shards.getIndexMetadata(),
    }
        for (final Runnable assertion : assertions) {
                return null;  
                shard.relocated(routing.getTargetRelocatingShard().allocationId().getId(), primaryContext -> {}, () -> {});  
                relocationStarted.await();  
import org.opensearch.snapshots.SnapshotId;
     * reader close operation on replica shard deletes the segment files copied in current round of segment replication.  
                n.callRealMethod();
        ShardRouting shardRouting = shard.shardRouting;
            } else if (recoveryIndex == i) {
    public void testIsReplicationTargetFalseForInternalEnginePrimary() throws IOException {  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;  
        flushShard(primaryShard);  
 * SPDX-License-Identifier: Apache-2.0
    /**
            shards.startAll();
            public void onFailure(Exception e) {
            assertEqualTranslogOperations(shards, primaryShard);
            final SegmentInfos primaryInfos = primary.store().readLastCommittedSegmentsInfo();
            final Store.RecoveryDiff diff = Store.segmentReplicationDiff(latestPrimaryMetadata, latestReplicaMetadata);
            replicateSegments(primaryShard, shards.getReplicas());  
            shard,
                assertions.add(() -> assertTrue(invoked.get()));  
    public void testPublishCheckpointPostFailover() throws IOException {
            assertEquals(0, replicaShard.getPendingMergedSegmentCheckpoints().size());
    public void testReplicationCheckpointNullForDocRep() throws IOException {
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));  
        closeShards(shard);  
    public void testMergedSegmentReplicationWithZeroReplica() throws Exception {
        when(indicesService.indexServiceSafe(any())).thenReturn(indexService);  
        IndexShardTestCase.updateRoutingEntry(shard, routing);
import org.opensearch.threadpool.ThreadPool;  
            // start finalization of recovery
                ) {
import org.opensearch.index.replication.TestReplicationSource;  
                new NRTReplicationEngineFactory(),
        try (ReplicationGroup shards = createGroup(0, updatedSettings, new NRTReplicationEngineFactory())) {
import java.util.Arrays;
            shards.indexDocs(numDocs);
            Collections.emptyList(),  
            final Map<String, StoreFileMetadata> latestPrimaryMetadata = primary.store().getSegmentMetadataMap(primaryInfos);
                }
        }
            }
                new CheckpointInfoResponse(copyState.getCheckpoint(), copyState.getMetadataMap(), copyState.getInfosBytes())
            @Override  
    }
            }  
        }  
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build(),
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), mappings, new NRTReplicationEngineFactory())) {
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
            validateShardIdleWithNoReplicas(primary);  
    }  
        // Starting a new shard in PrimaryMode and shard routing primary.
import org.opensearch.common.util.CancellableThreads;
        primary = shards.addReplicaWithExistingPath(primary.shardPath(), primary.routingEntry().currentNodeId());  
            closeShards(primary);  
            }
     * It does this by blocking the finalizeReplication on replica shard and performing close operation on acquired
                }
    protected void validateShardIdleWithNoReplicas(IndexShard primary) {
            .build();
            final int numDocs = shards.indexDocs(randomIntBetween(1, 10));
            for (int i = 0; i < numDocs; i++) {
            for (IndexShard replica : shards.getReplicas()) {
        // verify checkpoint is published  
                    latch.countDown();
        assertNull(indexShard.getLatestReplicationCheckpoint());
    public void testReplicationCheckpointNotNullForSegRep() throws IOException {  
            replicateSegments(primaryShard, shards.getReplicas());
    protected void assertDocCounts(IndexShard indexShard, int expectedPersistedDocCount, int expectedSearchableDocCount)
import org.opensearch.indices.recovery.RecoverySettings;
        try (
            shards.startAll();
import org.opensearch.index.mapper.MapperService;
                    long replicationId,
        }
                shard.relocated(
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory())) {  
     * This test mimics the segment replication failure due to CorruptIndexException exception which happens when
import org.opensearch.core.index.shard.ShardId;  
                1,
        return new SnapshotShardsService(settings, clusterService, repositoriesService, transportService, indicesService);
            .put(getIndexSettings())  
            IndexShard primaryShard = shards.getPrimary();  
import java.io.UncheckedIOException;
                    Assert.fail("Replication should not complete");
                    () -> {}
            final Tuple<GatedCloseable<SegmentInfos>, ReplicationCheckpoint> latestSegmentInfosAndCheckpoint = primaryShard  
            @Override
     * it asserts point in time seqNos are relative to the doc counts.  
import org.opensearch.index.translog.SnapshotMatchers;
            randomBoolean(),
            shards.assertAllEqual(numDocs);  
        latch.await();
        }
            final IndexShard replica = shards.getReplicas().get(0);
            assertion.run();
     */
        final RecoverySettings recoverySettings = new RecoverySettings(
        shard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
    @TestLogging(reason = "Getting trace logs from MergedSegmentWarmer", value = "org.opensearch.index.engine.MergedSegmentWarmer:TRACE")
        ) {
            // in the replica shard is still 2.  
            listener.onResponse(  
            primary.getLatestReplicationCheckpoint(),  
import org.opensearch.common.lease.Releasable;  
            }  
        assertEquals(0, shardStats.getCheckpointsBehindCount());  
                    this.listener = listener;
        IndexShard primary = shards.getPrimary();
        IndexShard spyShard = spy(primaryShard);  
            )
        );
            assertFalse(replica.scheduledRefresh());  
import org.opensearch.indices.IndicesService;  
                    assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));
import org.opensearch.index.engine.NRTReplicationEngine;
    public void testPublishCheckpointOnPrimaryMode_segrep_off() throws IOException, InterruptedException {  
            // ensure search idle conditions are met.  
            shards.indexDocs(numDocs);  
        );
            startReplicationAndAssertCancellation(replica, primary, targetService);
            shards.assertAllEqual(10);
        SegmentReplicationShardStats shardStats = initialStats.stream().findFirst().get();
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
            // recovery can only be finalized after we release the current primaryOperationLock
            try {
            shard,
        closeShards(indexShard);
        final IndexShard primary = newStartedShard(true, settings);
                throw new RuntimeException(e);
        shards.indexDocs(10);
                try {  
            assertEquals(2, replicaShard.segments(false).size());
import java.util.Map;
            shards.indexDocs(numDocs);
            ReplicationGroup shards = createGroup(  
                    copy.getFailure()
    public void testComputeReplicationCheckpointNullInfosReturnsEmptyCheckpoint() throws Exception {
        promoteReplica(
        final Map<ShardId, SnapshotsInProgress.ShardSnapshotStatus> shardsBuilder = new HashMap<>();  
    public void testDelayedOperationsBeforeAndAfterRelocated() throws Exception {
import org.opensearch.indices.replication.SegmentReplicationState;
            };  
                assertAtMostOneLuceneDocumentPerSequenceNumber(getEngine(replicaShard));
                true,
                    shards.assertAllEqual(10);
            primaryShard.refresh("test");
    /**
    protected SegmentReplicationTargetService newTargetService(SegmentReplicationSourceFactory sourceFactory) {  
import org.opensearch.ExceptionsHelper;
        assertNotNull(replicationCheckpoint);
                0,
            // after segment replication, _4.si is removed from pending merge segments  
            assertTrue(replica.isSearchIdle());
    }
            final Set<SegmentReplicationShardStats> statsAfterFlush = primaryShard.getReplicationStatsForTrackedReplicas();
            ReplicationGroup shards = createGroup(  
        try (ReplicationGroup shards = createGroup(1, settings, new NRTReplicationEngineFactory())) {
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
        );
            }  
    }
            final IndexShard replicaShard = shards.getReplicas().get(0);  
            final IndexShard replicaShard = shards.getReplicas().get(0);  
            assertFalse("primary on InternalEngine must NOT be a replication target", primary.isReplicationTarget());
                    public void onFailure(Exception e) {
            int numDocs = randomIntBetween(10, 20);
        latch.await();  
        try (
            shards.assertAllEqual(2 * numDocs);
            ReplicationGroup shards = createGroup(
            );
            final IndexShard primary = shards.getPrimary();
    protected Settings getIndexSettings() {
    public void testIsReplicationTargetTrueForNRTReplicationEngineReplica() throws IOException {  
    }
import org.opensearch.index.engine.InternalEngineFactory;
            new IndexMetadata.Builder(indexMetadata).state(closedIdx ? IndexMetadata.State.CLOSE : IndexMetadata.State.OPEN).build()  
    public void testShardIdle_Docrep() throws Exception {
        final IndexShard indexShard = newStartedShard(
            shards.assertAllEqual(numDocs);
    }  
                    long replicationId,
        assertThat(e.getCause(), instanceOf(ShardNotInPrimaryModeException.class));
                latch.countDown();  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
        final NRTReplicationEngineFactory engineFactory = new NRTReplicationEngineFactory();
            assertEquals(1, replicaShard.getPendingMergedSegmentCheckpoints().size());
            assertEquals(initialCheckpointSize, shardStats.getBytesBehindCount());
        updateMappings(primaryTarget, primarySource.indexSettings().getIndexMetadata());  
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
                    public void onResponse(Releasable releasable) {  
            primaryShard.refresh("test");
        shard.acquirePrimaryOperationPermit(new ActionListener<Releasable>() {
        assertFalse(indexShard.isSegmentReplicationAllowed());  
            // index and copy segments to replica.  
                    BiConsumer<String, Long> fileProgressTracker,  
    ) throws InterruptedException {
                getIndexSettings(),  
        sut = prepareForReplication(primaryShard, null);
            shards.refresh("test");
            primaryShard.refresh("test");
                });
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;  
            flushShard(primaryShard);
            }
            // in the replica shard is still 2.  
public class SegmentReplicationIndexShardTests extends OpenSearchIndexLevelReplicationTestCase {
        final IndexShard shard = newStartedShard(true, getIndexSettings());
            } catch (InterruptedException e) {
                indexMapping,  
                    @Override  
            final IndexShard primaryShard = shards.getPrimary();
        for (IndexShard shard : shards) {  
            final IndexShard replicaShard = shards.getReplicas().get(0);
    /**
}
        primaryShard.refresh("test");
        return createGroup(numberOfReplicas, getIndexSettings(), indexMapping, new NRTReplicationEngineFactory());  
            // Step 2. Ingest numDocs documents again & replicate to replica shard
        // verify checkpoint is published
            new SnapshotsInProgress.ShardSnapshotStatus(state.getNodes().getLocalNode().getId(), "1")
                assertTrue(
    private static final Settings settings = Settings.builder()
    }  
            }
            doAnswer(n -> {  
     * Test that latestReplicationCheckpoint returns null only for docrep enabled indices  
            flushShard(primaryShard);
    protected SnapshotShardsService getSnapshotShardsService(
                    }
    protected void assertEqualTranslogOperations(ReplicationGroup shards, IndexShard primaryShard) throws IOException {
                    ReplicationCheckpoint checkpoint,  
            assertTrue(replicaShard.getReplicationEngine().isEmpty());  
                    final ExecutionException e = expectThrows(ExecutionException.class, () -> onLockAcquired.get(30, TimeUnit.SECONDS));
            shards.startAll();
    }  
        latch.await(2, TimeUnit.SECONDS);  
            final int numDocs = randomIntBetween(10, 20);  
        Thread recoveryThread = new Thread(() -> {  
            // Step 1. Ingest numDocs documents & replicate to replica shard
                        throw new AssertionError();
    public void testReuseReplicationCheckpointWhenLatestInfosIsUnChanged() throws Exception {  
                new NRTReplicationEngineFactory(),
                false
                @Override  
    public void testReplication() throws Exception {  
        }
    }
                startRecovery.countDown();
            flushShard(primaryShard);
    // Todo: Remove this test when there is a better mechanism to test a functionality passing in different replication
     * here we are starting a new primary shard in PrimaryMode and testing if the shard publishes checkpoint after refresh.  
            final IndexShard primaryShard = shards.getPrimary();
            shard.acquirePrimaryOperationPermit(onLockAcquired, ThreadPool.Names.WRITE, "i_" + i);
            assertTrue(primary.isSearchIdle());  
            replicateSegments(primaryShard, shards.getReplicas());
            public void onResponse(Releasable releasable) {  
            }).when(spy).newReadWriteEngine(any());
    public void testCleanupRedundantPendingMergeSegment() throws Exception {
        } finally {
                MergedSegmentPublisher.EMPTY
            final IndexShard primaryShard = shards.getPrimary();
        throws IOException {
    }  
            final IndexShard primaryShard = shards.getPrimary();
                    }
    }
                    failed.set(e);  
        promoteReplica(  
                .sum();  
        final CountDownLatch latch = new CountDownLatch(1);
                replicaShard,
            assertEquals(1, shardStats.getCheckpointsBehindCount());
            final long initialCheckpointSize = primaryCheckpoint.getMetadataMap()
import org.opensearch.common.settings.ClusterSettings;
            // After the pre-copy merged segment is completed, the merged segment is not visible in the replica, and the number of segments
import org.opensearch.index.IndexSettings;  
            shards.startAll();
            assertTrue(primary.hasRefreshPending());
                assertions.add(() -> {
                    new ClusterChangedEvent(  
        CountDownLatch latch = new CountDownLatch(1);
    }  
        assertEquals(0, shardStats.getBytesBehindCount());
        for (int i = 0; i < numberOfAcquisitions; i++) {
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;  
        try (  
            final IndexShard replica = shards.getReplicas().get(0);
            shards.assertAllEqual(2 * numDocs);
    }
            } catch (IOException e) {  
    }
        } finally {
            getIndexSettings(),  
            shardsBuilder,  
            final IndexShard primaryShard = shards.getPrimary();
     */  
            replicateSegments(primaryShard, shards.getReplicas());  
            int numDocs = 1;  
import org.opensearch.snapshots.Snapshot;  
            )
                @Override
                    // shard is closing while we are copying files.
            final IndexShard primary = shards.getPrimary();
 *
    }
        ) {  
                MergedSegmentPublisher.EMPTY  
                latch.countDown();
import org.opensearch.indices.replication.SegmentReplicationSource;
import java.util.ArrayList;  
                clusterService.state(),  
        verify(mock, times(0)).publish(any(), any());
            replicateSegments(primaryShard, List.of(replicaShard));
            assertReplicaCaughtUp(primaryShard);
                .values()  
            // Step 3. Perform force merge down to 1 segment on primary
                public void onReplicationDone(SegmentReplicationState state) {  
import org.opensearch.indices.replication.common.ReplicationType;  
            primaryShard.refresh("test");
                throw new IOException("Expected failure");
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, spy, createTempDir())) {
    protected void assertEqualCommittedSegments(IndexShard primary, IndexShard... replicas) throws IOException {
            final Map<String, StoreFileMetadata> latestReplicaMetadata = replica.store().getSegmentMetadataMap(replicaInfos);  
        latch.await();
            SnapshotInfoTests.randomUserMetadata(),
                    )
                return ans.callRealMethod();
            }
            flushShard(primaryShard);  
        try (Releasable ignored = acquirePrimaryOperationPermitBlockingly(shard)) {  
                }
    public void testSegmentInfosAndReplicationCheckpointTuple() throws Exception {
        }
        assertEquals(checkpoint.getSegmentsGen(), segmentInfos.getGeneration());
    public void testIgnoreShardIdle() throws Exception {
                    ActionListener<CheckpointInfoResponse> listener
        }  
                    final RuntimeException exception = new CancellableThreads.ExecutionCancelledException("retryable action was cancelled");  
                SnapshotsInProgress.State.INIT,  
            shards.startAll();  
                onLockAcquired = new PlainActionFuture<Releasable>() {  
                snapshot,
            assertFalse(primary.hasRefreshPending());  
            shards.assertAllEqual(10);
            primaryShard.forceMerge(new ForceMergeRequest("test").maxNumSegments(1));
            )
        // After close, getIndexer() throws AlreadyClosedException → method must return false, not throw.
        final IndexShard newPrimary = getRandomReplica(shards);
                .mapToLong(StoreFileMetadata::length)
        // Starting relocation handoff
                }
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, spy, createTempDir())) {  
            final ClusterState initState = addSnapshotIndex(
                        releasable.close();
            shards.assertAllEqual(2 * numDocs);
            }  
        recoveryThread.join();
    }  
    }  
            shards.startAll();
            assertFalse(replica.scheduledRefresh());
                    assertTrue(engineOrNull instanceof ReadOnlyEngine);  
            assertEquals(2, replicaShard.segments(false).size());
            replicateMergedSegments(primaryShard, List.of(replicaShard));  
        }
import org.opensearch.repositories.IndexId;
    protected void resolveCheckpointInfoResponseListener(ActionListener<CheckpointInfoResponse> listener, IndexShard primary) {
                recoverySettings,
import org.opensearch.indices.replication.CheckpointInfoResponse;  
                closeShard(shard, false);
            assertEquals(1, primaryShard.segments(false).size());
            });
            }
import static org.hamcrest.Matchers.containsString;
            ReferencedSegmentsCheckpoint referencedSegmentsCheckpoint = primaryShard.computeReferencedSegmentsCheckpoint();
        assertNotNull(segmentInfos);
        final List<Runnable> assertions = new ArrayList<>(numberOfAcquisitions);
            Assert.fail("Failed to compute copyState");
            // index and replicate segments to replica.
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.snapshots.SnapshotInfoTests;
                indexMapping,  
import static org.hamcrest.Matchers.instanceOf;  
     */
            assertFalse(primary.scheduledRefresh());  
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
            final Snapshot snapshot = new Snapshot(randomAlphaOfLength(10), new SnapshotId(randomAlphaOfLength(5), randomAlphaOfLength(5)));  
    public void testShardIdleWithNoReplicas() throws Exception {  
     */
        final IndicesService indicesService = mock(IndicesService.class);
        final NRTReplicationEngineFactory spy = spy(engineFactory);
        }
        Exception e = expectThrows(  
        for (int i = 0; i < totalOps; i++) {  
            final IndexShard primaryShard = shards.getPrimary();
    }
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));  
            primaryShard.refresh("test");  
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build(),
        spy.onNewCheckpoint(new ReplicationCheckpoint(primaryShard.shardId(), 0L, 0L, 0L, Codec.getDefault().getName()), spyShard);
            final IndexShard replica = shards.getReplicas().get(0);  
    }
    /**
        );
        assertThat(e.getCause(), hasToString(containsString("shard is not in primary mode")));  
        ) {
        try (ReplicationGroup shards = createGroup(1, updatedSettings, new NRTReplicationEngineFactory())) {  
        };
            } catch (IOException e) {
            shardsService.clusterChanged(new ClusterChangedEvent("test", initState, clusterService.state()));  
        );
import org.opensearch.indices.replication.SegmentReplicationTargetService;  
    }  
    public void testPublishCheckpointOnPrimaryMode() throws IOException, InterruptedException {
    }
                final AtomicBoolean invoked = new AtomicBoolean();
                    assertThat(replicaSnapshot, SnapshotMatchers.containsOperationsInAnyOrder(operations));  
            shards.assertAllEqual(numDocs);  
        return ClusterState.builder(state)  
        CountDownLatch latch = new CountDownLatch(1);
    }  
            try (final GatedCloseable<SegmentInfos> gatedCloseable = replicaTuple.v1()) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        shard.getReplicationTracker().completeRelocationHandoff();  
                assertEquals(IndexShardSnapshotStatus.Stage.FAILURE, stage);
        SegmentReplicationTargetService targetService
        IndexShardTestCase.updateRoutingEntry(primarySource, primarySource.routingEntry().relocate(randomAlphaOfLength(10), -1));  
    public void testRejectCheckpointOnShardRoutingPrimary() throws IOException {
            int numDocs = randomIntBetween(10, 20);
import org.opensearch.cluster.SnapshotsInProgress;
            logger.info("--> Ingest {} docs again", numDocs);  
                );
        MergedSegmentPublisher mergedSegmentPublisherWithException = new MergedSegmentPublisher((indexShard, checkpoint) -> {
                }, threadPool),  
            public void onResponse(Releasable releasable) {
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"foo\": { \"type\": \"keyword\"} }}}";
            VersionUtils.randomVersion(random()),  
    }
            public void onFailure(Exception e) {  
                new NRTReplicationEngineFactory(),
        );
            // ensure search idle conditions are met.
        boolean closedIdx,
 */  
            flushShard(primaryShard);  
    }  
            primaryShard.refresh("test");
            assertBusy(() -> {
            .put(IndexSettings.INDEX_SEARCH_IDLE_AFTER.getKey(), TimeValue.ZERO)
    }  
            shards.indexDocs(randomIntBetween(1, 10));
    protected ClusterState addSnapshotIndex(
        final IndexShard primarySource = newStartedShard(true, getIndexSettings());
        }, ThreadPool.Names.GENERIC, "");
                throw new RuntimeException(e);
        verify(mock, times(1)).publish(any(), any());  
package org.opensearch.index.shard;
                }
import org.opensearch.indices.recovery.RecoveryTarget;
    }
                releasable.close();
        closeShards(indexShard);
        // Assert that primary shard is no longer in Primary Mode and shard routing is still Primary  
            assertEquals(sizeAfterDeleteAndCommit, shardStats.getBytesBehindCount());  
        shards.startAll();
                1,
    }
    protected void startReplicationAndAssertCancellation(
            try (GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryShard.getSegmentInfosSnapshot()) {  
        IndexShard shard = newStartedShard(true);
                indexMapping,  
            final IndexShard replica = shards.getReplicas().get(0);
    /**
            final PlainActionFuture<Releasable> onLockAcquired;  
            assertFalse(shard.isRelocatedPrimary());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.repositories.RepositoriesService;
                onLockAcquired = new PlainActionFuture<>();
            shards.assertAllEqual(numDocs);
                    targetService.beforeIndexShardClosed(replica.shardId, replica, Settings.EMPTY);  
            primaryShard.refresh("test");  
            replicateSegments(primaryShard, List.of(spyShard));
    private void assertReplicationCheckpoint(IndexShard shard, SegmentInfos segmentInfos, ReplicationCheckpoint checkpoint)  
                    listener.onFailure(exception);
            replicateSegments(primary, List.of(replicaSpy));  
            shards.assertAllEqual(numDocs);
                primarySource,
        final NRTReplicationEngineFactory engineFactory = new NRTReplicationEngineFactory();
            }).when(spyShard).finalizeReplication(any(CatalogSnapshot.class));
        }  
    }
    ) {
                assertEquals(latestReplicationCheckpoint, primaryShard.computeReplicationCheckpoint(segmentInfosSnapshot.get()));
            try (final GatedCloseable<SegmentInfos> gatedCloseable = primaryTuple.v1()) {  
        IndexShard primaryShard = newStartedShard(true);  
            replicateMergedSegments(primaryShard, List.of(replicaShard));
    }
            flushShard(primaryShard);
        verify(spy, times(0)).startReplication(any(), any(), any());
            closeShards(replica);
        Settings settings = Settings.builder()  
        final IndexShard replica = newStartedShard(false, settings, new EngineBackedIndexerFactory(new NRTReplicationEngineFactory()));
        try (final CopyState copyState = new CopyState(primary)) {
            assertTrue("NRT-backed replica must be a replication target", replica.isReplicationTarget());  
            .build();
        assertEquals(false, primaryShard.getReplicationTracker().isPrimaryMode());
            try {
        // ensure search idle conditions are met.
                // thus as workaround, use updateSegments which eventually calls commitSegmentInfos on latest segment infos.  
            shards.promoteReplicaToPrimary(replicaShard).get();  
            primaryShard.refresh("test");
            final ReplicationCheckpoint primaryCheckpoint = primaryShard.getLatestReplicationCheckpoint();
import static org.mockito.Mockito.doThrow;
            final IndexShard replicaShard = shards.getReplicas().get(0);
        assertTrue(shard.isRelocatedPrimary());  
        assertFalse("closed shard must return false without throwing", replica.isReplicationTarget());
                assertNotNull(copy.getFailure());  
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
            shards.indexDocs(10);
        });  
        ReplicationGroup shards = createGroup(1, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir());
                deleteDoc(primaryShard, docIdAndSeqNo.getId());  
                test.close();
            );
            replicateSegments(primaryShard, shards.getReplicas());  
        final IndexShard indexShard = newShard(false, getIndexSettings(), new EngineBackedIndexerFactory(new InternalEngineFactory()));
            Set<SegmentReplicationShardStats> postRefreshStats = primaryShard.getReplicationStatsForTrackedReplicas();
            shallowCopySnapshot
            assertFalse(replica.hasRefreshPending());
    ) {
    public void testMergedSegmentReplication() throws Exception {
        return new SegmentReplicationTargetService(
                return ans.callRealMethod();
            when(sourceFactory.get(any())).thenReturn(source);
        }
                operations.add(newOp);
            flushShard(primaryShard);  
        );
        }
            primary.refresh("test");  
            final IndexShard primary = shards.getPrimary();
            shards.startAll();  
            CountDownLatch latch = new CountDownLatch(1);
                    }  
        assertNull(targetService.get(target.getId()));
            try {
            flushShard(primaryShard);
 * compatible open source license.
import static org.mockito.Mockito.when;  
     * Similar to test above, this test shows the issue where an engine close operation during active segment replication
        final CountDownLatch startRecovery = new CountDownLatch(1);
            assertFalse(replicaShard.getReplicationEngine().isEmpty());
            // generate segment _3.si
                );
    public void testQueryDuringEngineResetShowsDocs() throws Exception {
            primaryShard.refresh("test");  
        // Starting relocation handoff  
import java.util.HashMap;  
        try (ReplicationGroup shards = createGroup(1, settings, indexMapping, new NRTReplicationEngineFactory(), createTempDir())) {  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
            randomBoolean(),
            // after cleanup redundant pending merge segment, _2.si is removed from pending merge segments
            }  
        replicateSegments(primaryShard, shards.getReplicas());
            primary.refresh("Test");
            shards.refresh("test");
    // strategy.  
            getIndexSettings(),  
     * here we are starting a new primary shard in PrimaryMode initially and starting relocation handoff. Later we complete relocation handoff then shard is no longer
import static org.mockito.Mockito.any;
            randomNonNegativeLong(),
        );
        final IndexShard primaryShard = shards.getPrimary();
        shards.indexDocs(10);
            shards.startAll();
        closeShards(shard);
        replicateSegments(primaryShard, shards.getReplicas());  
                recoverySettings,
        return settings;
            shards.assertAllEqual(numDocs);  
            IndexShard primary = shards.getPrimary();
            }
        final IndexShard replicaShard = shards.getReplicas().get(0);  
            @Override
    protected ReplicationGroup getReplicationGroup(int numberOfReplicas) throws IOException {
            null
            primarySource.routingEntry().getTargetRelocatingShard(),
        IndexShard replica,
                public void onReplicationFailure(SegmentReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
            assertTrue(diff.different.isEmpty());  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
            primaryShard.refresh("test");
            primaryShard.forceMerge(new ForceMergeRequest().maxNumSegments(1).flush(true));  
        final ReplicationCheckpoint replicationCheckpoint = indexShard.getLatestReplicationCheckpoint();  
        final Settings settings = Settings.builder().put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.DOCUMENT).build();
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
            logger.info("--> Ingest {} docs again", numDocs);
            for (int i = 0; i < numDocs; i++) {
        shard.getReplicationTracker().startRelocationHandoff(id);  
            snapshotState,
