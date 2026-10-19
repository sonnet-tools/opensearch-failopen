                assertConsistentHistoryBetweenTranslogAndLucene(shard);
        updateMappings(primaryTarget, primarySource.indexSettings().getIndexMetadata());
        for (IndexShard shard : shards.getReplicas()) {
import org.opensearch.action.admin.indices.flush.FlushRequest;
            final List<DocIdSeqNoAndSource> docs = getDocIdAndSeqNos(primaryShard);
                if (randomBoolean()) {
        nextPrimary.refresh("test");
            } catch (IOException | InterruptedException e) {
            assertDocCounts(shard, totalDocs, numDocs);
        }
            // refresh and copy the segments over.
                    long replicationId,
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
        // 1. Create ops that are in the index and xlog of both shards but not yet part of a commit point.
            for (int i = 0; i < i1; i++) {
import java.util.concurrent.TimeUnit;
            flushShard(primary, true);
    }
                (repId) -> targetService.getMergedSegmentReplicationRef(repId),
                @Override
                    Assert.fail("Unreachable");
import org.opensearch.indices.replication.SegmentReplicationTargetService;
            replicateSegments(primary, List.of(behindReplicaBeforeRestart));
            replicateSegments(primaryShard, shards.getReplicas());
import java.util.stream.Stream;
                    // set the listener, we will only fail it once we cancel the source.
import org.opensearch.index.engine.InternalEngine;
        }
            when(sourceFactory.get(any())).thenReturn(segmentReplicationSource);
    }
        assertEquals(totalDocs, nextPrimary.translogStats().estimatedNumberOfOperations());
                final IndexShard primary = shardList.get(0);
            shards.syncGlobalCheckpoint();
        final RecoverySettings recoverySettings = new RecoverySettings(
                }
import org.opensearch.cluster.routing.ShardRouting;
            shards.startAll();
            final List<DocIdSeqNoAndSource> docsAfterDelete = getDocIdAndSeqNos(primaryShard);
            shards.startAll();
            assertConsistentHistoryBetweenTranslogAndLucene(shard);
            }
import org.opensearch.action.index.IndexRequest;
                ) {
                    shards.delete(new DeleteRequest(index.getName()).id(String.valueOf(i)));
            final int numDocs = shards.indexDocs(randomInt(10));
                    ActionListener<GetSegmentFilesResponse> listener
            };
            primarySource.routingEntry().getTargetRelocatingShard(),
                public void getSegmentFiles(
                    try {
            // close behindReplicaBeforeRestart - we will re-open it after replica_2 is promoted as new primary.
                    // simulate listener resolving, but only after we have issued a cancel from beforeIndexShardClosed .
                }
import org.opensearch.indices.replication.GetSegmentFilesResponse;
                    targetService.beforeIndexShardClosed(replica.shardId, replica, Settings.EMPTY);
            replicateSegments(primary, shards.getReplicas());
            };
                        .filter(name -> name.startsWith(SegmentReplicationTarget.REPLICATION_PREFIX))
    public void testPrimaryCancelsExecution() throws Exception {
        recoverReplica(primaryTarget, primarySource, true, replicatePrimaryFunction);
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
        shards.recoverReplica(oldPrimary);
                2,
                }
    }
                    // randomly resolve the listener, indicating the source has resolved.
    public void testReplicaReceivesGenIncrease() throws Exception {
            when(indicesService.getShardOrNull(replica.shardId)).thenReturn(replica);
            final IndexShard oldPrimary = shards.getPrimary();
            assertDocCount(behindReplicaBeforeRestart, totalDocs);
                primaryMetadata = primaryShard.store().getSegmentMetadataMap(primarySegmentInfos);
                    targetService.beforeIndexShardClosed(replica.shardId, replica, Settings.EMPTY);
                shards.removeReplica(replicaToRestart);
                runnablePostGetFiles
        try (ReplicationGroup shards = createGroup(3, getIndexSettings(), new NRTReplicationEngineFactory())) {
                    long replicationId,
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
                    targetService.shardRoutingChanged(nextPrimary, oldRouting, nextPrimary.shardRouting);
            assertEquals(0, primary.translogStats().getUncommittedOperations());
                behindReplicaBeforeRestart.routingEntry().currentNodeId()
/*
                ) {
            assertDocCount(replica_2, totalDocs);
        assertEquals(totalDocs, replica.translogStats().getUncommittedOperations());
    }
            flushShard(primary, true);
                if (randomBoolean()) {
                    failAndPromoteRandomReplica(shards);
            }
                @Override
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"foo\": { \"type\": \"keyword\"} }}}";
                    } catch (IOException e) {
                public void getCheckpointMetadata(
        assertEqualTranslogOperations(shards, oldPrimary);
    public void testReplicaRestarts() throws Exception {
        assertEquals(0, nextPrimary.translogStats().estimatedNumberOfOperations());
                .build(),
            nextPrimary.refresh("test");
                    ReplicationCheckpoint checkpoint,
                @Override
                    Collection<String> replicaStoreFiles = List.of(indexShard.store().directory().listAll());
            primary.store().close();
            final int numDocs = shards.indexDocs(randomInt(10));
                    shards.index(
            replicateSegments(nextPrimary, shards.getReplicas());
            logger.info("--> Index {} documents on primary", numDocs);
        // close and start the oldPrimary as a replica.
            // at this point both shards should have numDocs persisted and searchable.
            assertEqualTranslogOperations(shards, primaryShard);
    }
            };
    }
                ) {
        // this can happen when a replica is promoted that is further behind the other replicas.
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
        assertEquals(NRTReplicationEngine.class, getEngine(oldPrimary).getClass());
        replicateSegments(nextPrimary, asList(replica));
            for (IndexShard shard : shards.getReplicas()) {
                public void getCheckpointMetadata(
                recoverySettings,
                    ReplicationCheckpoint checkpoint,
                    final RuntimeException exception = new CancellableThreads.ExecutionCancelledException("retryable action was cancelled");
            countDownLatch.await(30, TimeUnit.SECONDS);
            shards.recoverReplica(behindReplicaAfterRestart);
            );
                MergedSegmentPublisher.EMPTY
            IndexShard primary = shards.getPrimary();
import org.opensearch.index.store.StoreFileMetadata;
                    latch.countDown();
                }
                    ReplicationCheckpoint checkpoint,
import org.apache.lucene.index.SegmentInfos;
            }
            shards.indexDocs(numDocs);
    }
import org.opensearch.common.util.CancellableThreads;
                    targetService.beforeIndexShardClosed(replica.shardId, replica, Settings.EMPTY);
            // refresh and push segments to our other replica.
            closeShards(replica);
            startReplicationAndAssertCancellation(replica, primary, targetService);
            final IndexShard primaryShard = shards.getPrimary();
                }
                if (randomBoolean()) {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
                public void getCheckpointMetadata(
        }
        oldPrimary.refresh("Test");
            replicateSegments(primary, shards.getReplicas());
            shards.indexDocs(numDocs);
            shards.removeReplica(replica);
import java.util.stream.Collectors;
            assertDocCount(replica, totalDocs);
                logger.info("--> Restarting replica {}", replicaToRestart.shardId);
            flushShard(replica_2, false);
                }
            IndexShard newReplica = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());
            logger.info("--> Inserting documents {}", numDocs);
        }
        }
            shards.removeReplica(replica);
            for (int i = 0; i < numDocs; i++) {
                    listener.onFailure(new CancellableThreads.ExecutionCancelledException("Cancelled"));
            assertEquals(getEngine(nextPrimary).getClass(), InternalEngine.class);
            replicateSegments(primary, shards.getReplicas());
        final int numDocs = shards.indexDocs(numDocsInFirstBatch);
        assertDocCount(primaryTarget, totalOps);
        // when a replica gets incoming segments that are lower than what it currently has on disk.
            when(sourceFactory.get(any())).thenReturn(source);
import java.util.function.Function;
                    long replicationId,
            }
                replica,
        assertEquals(totalDocs, nextPrimary.translogStats().getUncommittedOperations());
            final IndexShard replica_2 = shards.getReplicas().get(1);
            assertEquals(0, primary.translogStats().getUncommittedOperations());
            try {
            assertEquals(additionalDocs, replica.translogStats().estimatedNumberOfOperations());
            replicateSegments(primaryShard, shards.getReplicas());
            final CountDownLatch countDownLatch = new CountDownLatch(1);
                    }
                    ReplicationCheckpoint checkpoint,
            final IndexShard replica = shards.getReplicas().get(0);
     * replication files from ongoing round of segment replication
    }
            replicateSegments(primary, shards.getReplicas());
            assertEquals(numDocs, replica.translogStats().getUncommittedOperations());
import java.io.IOException;
            IndexShard primary = shards.getPrimary();
package org.opensearch.index.shard;
                public void cancel() {
                sourceFactory,
                }
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
                new NRTReplicationEngineFactory(),
    public void testSegmentReplication_Index_Update_Delete() throws Exception {
import org.opensearch.index.engine.NRTReplicationEngineFactory;
                throw new RuntimeException(e);
            final IndexShard nextPrimary = shards.getReplicas().get(0);
                    ActionListener<GetSegmentFilesResponse> listener
                    Collection<String> temporaryFiles = Stream.of(indexShard.store().directory().listAll())
            numDocs = randomIntBetween(numDocs + 1, numDocs + 10);
                }
    // Todo: Move this test to SegmentReplicationIndexShardTests so that it runs for both node-node & remote store
            replicateSegments(primary, List.of(behindReplicaBeforeRestart));
                .put(RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE.getKey(), true)
            // Step 3. Copy segment files to replica shard but prevent commit
                    resolveCheckpointInfoResponseListener(listener, oldPrimary);
import org.opensearch.indices.replication.CheckpointInfoResponse;
            shards.startAll();
                    // Step 5. Validate temporary files are not deleted from store.
            for (int i = 0; i < numDocs; i++) {
            primary = shards.getPrimary();
        IndexShard oldPrimary = shards.getPrimary();
                @Override
import java.util.concurrent.CountDownLatch;
            primaryShard.refresh("Test");
            primary.close("demoted", randomBoolean(), false);
        }
        IndexShardTestCase.updateRoutingEntry(primarySource, primarySource.routingEntry().relocate(randomAlphaOfLength(10), -1));
        assertThat(
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), mappings, new NRTReplicationEngineFactory())) {
                    ActionListener<CheckpointInfoResponse> listener
        shards.startAll();
            );
        shards.syncGlobalCheckpoint();
        );
        oldPrimary.close("demoted", false, false);
            shards.promoteReplicaToPrimary(replica_2).get();
            shards.assertAllEqual(numDocs);
                replicaToRestart.close("restart", false, false);
            closeShards(replica);
            Map<String, StoreFileMetadata> primaryMetadata;
                new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
                    listener.onFailure(exception);
                ) {
            doPrimaryPromotion(shards, randomInt(10), randomIntBetween(1100, 2000));
                replicateSegments(shards.getPrimary(), shards.getReplicas());
            shards.indexDocs(numDocs);
            );
            final int additionalDocs = shards.indexDocs(randomIntBetween(numDocs + 1, numDocs + 10));
                behindReplicaBeforeRestart.shardPath(),
        assertEquals(totalDocs, replica.translogStats().estimatedNumberOfOperations());
    }
        assertThat(primaryTarget.getLocalCheckpoint(), equalTo(totalOps - 1L));
        // persisted.
import org.opensearch.index.engine.EngineBackedIndexer;
            }
                assert shardList.size() >= 2;
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
            shards.removeReplica(replica);
                @Override
        );
        }
            flushShard(primary);
                }
            final int numDocs = randomIntBetween(100, 200);
                    listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
                }
                    resolveCheckpointInfoResponseListener(listener, primary);
        }
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterReplication));
import org.opensearch.common.settings.Settings;
                }
    public void testPrimaryRelocation() throws Exception {
            assertEquals(additionalDocs, primary.translogStats().getUncommittedOperations());
                (repId) -> targetService.get(repId),
        Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction = (shardList) -> {
            final CountDownLatch latch = new CountDownLatch(1);
            assertEquals(0, replica.translogStats().estimatedNumberOfOperations());
            assertDocCount(newReplica, numDocs);
                    BiConsumer<String, Long> fileProgressTracker,
            IndexShard primary = shards.getPrimary();
        }
            oldPrimary.refresh("Test");
    // Todo: Move this test to SegmentReplicationIndexShardTests so that it runs for both node-node & remote store
                @Override
            assertEquals(0, primary.translogStats().estimatedNumberOfOperations());
            oldPrimary.close("demoted", false, false);
                    List<StoreFileMetadata> filesToFetch,
            ReplicationGroup shards = createGroup(
            shards.recoverReplica(oldPrimary);
            if (randomBoolean()) {
            assertEqualCommittedSegments(primary, behindReplicaBeforeRestart);
        int totalOps = randomInt(10);
                public void getCheckpointMetadata(
 * SPDX-License-Identifier: Apache-2.0
                        shards.promoteReplicaToPrimary(nextPrimary);
            // wait for replica to finish being promoted, and assert doc counts.
            primary.refresh("Test");
                public void getSegmentFiles(
            primary.refresh("Test");
                    BiConsumer<String, Long> fileProgressTracker,
            final int numDocs = randomIntBetween(10, 100);
                public void getSegmentFiles(
                }
                    IndexShard indexShard,
            }
    public void testCloseShardWhileGettingCheckpoint() throws Exception {
            for (int i = 0; i < numDocs; i++) {
            when(sourceFactory.get(any())).thenReturn(source);
                    List<StoreFileMetadata> filesToFetch,
            shards.startAll();
                    long replicationId,
            // 1. Create ops that are in the index and xlog of both shards but not yet part of a commit point.
            final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());
                );
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
            assertEquals(0, replica.translogStats().getUncommittedOperations());
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
            final IndexShard replica = shards.getReplicas().get(0);
            final int totalDocs = numDocs + additionalDocs;
            oldPrimary.store().close();
            )
                shards.indexDocs(randomInt(10));
import org.opensearch.indices.IndicesService;
                    ReplicationCheckpoint checkpoint,
import java.util.Collection;
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            primary.refresh("Test");
            final int numDocs = shards.indexDocs(randomInt(10));
                ) {
        final IndexShard replica = shards.getReplicas().get(1);
}
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
        shards.promoteReplicaToPrimary(nextPrimary);
                .getTrackedLocalCheckpointForShard(primaryTarget.routingEntry().allocationId().getId())
                return replicateSegments(primary, shardList.subList(1, shardList.size()));
            final List<DocIdSeqNoAndSource> docsAfterReplication = getDocIdAndSeqNos(shards.getPrimary());
            shards.startAll();
            );
        );
                    NRTReplicationEngine engine = (NRTReplicationEngine) ((EngineBackedIndexer) (indexShard.getIndexer())).getEngine();
            shards.assertAllEqual(numDocs);
            primary.refresh("Test");
            // Step 2. Ingest numDocs documents again to create a new commit on primary
                    ReplicationCheckpoint checkpoint,
                    ActionListener<GetSegmentFilesResponse> listener
                ) {
                @Override
        assertEquals(InternalEngine.class, getEngine(nextPrimary).getClass());
            assertEquals(numDocs, primary.translogStats().estimatedNumberOfOperations());
            when(sourceFactory.get(any())).thenReturn(source);
            int totalDocs = numDocs;
                    ReplicationCheckpoint checkpoint,
            shards.startAll();
                    Assert.fail("Should not be reached");
        }
        for (IndexShard shard : shards.getReplicas()) {
            SegmentReplicationSource source = new TestReplicationSource() {
        }
                ) {
        replicateSegments(oldPrimary, shards.getReplicas());
            shards.removeReplica(replica);
                assertDocCounts(shard, numDocs, numDocs);
                .put(RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE.getKey(), 1000)
            shards.startAll();
            final IndexShard replica = shards.getReplicas().get(0);
                    // shard is closing while we are copying files.
import java.util.List;
            SegmentReplicationSource source = new TestReplicationSource() {
                    // trigger a cancellation by closing the replica.
            }
                public void onFailure(Exception e) {
        // refresh and push segments to our other replica.
                getIndexSettings(),
            primaryShard.refresh("Test");
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
import org.opensearch.indices.replication.SegmentReplicationSource;
    public void testTemporaryFilesNotCleanup() throws Exception {
            }
                mock(TransportService.class),
import org.opensearch.core.xcontent.MediaTypeRegistry;
        assertEqualTranslogOperations(shards, oldPrimary);
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
            when(sourceFactory.get(any())).thenReturn(source);
                        Assert.fail("Promotion should not fail");
            flushShard(primary, true);
        try (ReplicationGroup shards = createGroup(2, getIndexSettings(), new NRTReplicationEngineFactory())) {
            SegmentReplicationSource source = new TestReplicationSource() {
        // at this point both shards should have numDocs persisted and searchable.
            IndexShard oldPrimary = shards.addReplicaWithExistingPath(primary.shardPath(), primary.routingEntry().currentNodeId());
            primary.refresh("test");
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            shards.recoverReplica(newReplica);
            for (int i = 0; i < numDocs; i++) {
        oldPrimary = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());
                // refresh and push segments to our other replicas.
                @Override
                    throw new RuntimeException(e);
        // promote the replica
            }
            shards.removeReplica(behindReplicaBeforeRestart);
                    // Step 4. Perform a commit on replica shard.
            shards.assertAllEqual(numDocs);
                replicaToRestart.store().close();
                    listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
            assertEqualCommittedSegments(primary, replica);
import org.opensearch.common.lease.Releasable;
                    BiConsumer<String, Long> fileProgressTracker,
            shards.indexDocs(numDocs);
            shards.startAll();
    }
                    long replicationId,
        try (
            replicateSegments(primaryShard, shards.getReplicas());
        }
                assertEquals(getDocIdAndSeqNos(shard), docs);
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
        }
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
    public void testPrimaryPromotionWithConcurrentTranslogRecovery() throws Exception {
            assertEquals(numDocs, replica.translogStats().estimatedNumberOfOperations());
        assertDocCounts(oldPrimary, totalDocs, totalDocs);
                    ReplicationCheckpoint checkpoint,
                    this.listener = listener;
                    long replicationId,
            final Consumer<IndexShard> runnablePostGetFiles = (indexShard) -> {
            numDocs = randomIntBetween(numDocs + 1, numDocs + 10);
                    long replicationId,
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
                        .collect(Collectors.toList());
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
            startReplicationAndAssertCancellation(replica, primary, targetService);
                    ShardRouting oldRouting = nextPrimary.shardRouting;
        assertDocCounts(nextPrimary, totalDocs, totalDocs);
            assertEquals(0, replica.translogStats().estimatedNumberOfOperations());
            for (IndexShard shard : shards.getReplicas()) {
                    BiConsumer<String, Long> fileProgressTracker,
import org.opensearch.indices.recovery.RecoverySettings;
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.concurrent.GatedCloseable;
     * Verifies that commits on replica engine resulting from engine or reader close does not cleanup the temporary
            totalDocs += numDocs;
            }
            try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryShard.getSegmentInfosSnapshot()) {
        final IndexShard nextPrimary = shards.getReplicas().get(0);
            assertEqualTranslogOperations(shards, primaryShard);
                    replicaToRestart.shardPath(),
                    ActionListener<CheckpointInfoResponse> listener
        closeShards(primarySource, primaryTarget);
    public void testNRTReplicaPromotedAsPrimary() throws Exception {
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
                ) {
    // Todo: Move this test to SegmentReplicationIndexShardTests so that it runs for both node-node & remote store
import static java.util.Arrays.asList;
            assertEquals(0, replica.translogStats().getUncommittedOperations());
                flushShard(primary);
            assertDocCount(primary, totalDocs);
        final int totalDocs = numDocs + additionalDocs;
            assertEquals("Replication failed", 0, countDownLatch.getCount());
    /**
import java.util.function.BiConsumer;
                    BiConsumer<String, Long> fileProgressTracker,
            assertDocCount(replica_2, 0);
                    replicaToRestart.routingEntry().currentNodeId()
            for (IndexShard shard : shards) {
            final int numDocs = shards.indexDocs(randomInt(10));
        }
            nextPrimary.acquirePrimaryOperationPermit(new ActionListener<>() {
                public void getSegmentFiles(
                ActionListener<CheckpointInfoResponse> listener;
            assertEqualTranslogOperations(shards, primaryShard);
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            primaryShard.refresh("Test");
                ) {
            // Step 1. Ingest numDocs documents, commit to create commit point on primary & replicate
            Settings.builder()
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            assertEquals(additionalDocs, replica.translogStats().getUncommittedOperations());
                } catch (IOException e) {
            };
            SegmentReplicationSource source = new TestReplicationSource() {
            assertDocCount(oldPrimary, totalDocs);
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
import static org.mockito.Mockito.mock;
    public void testReplicaPromotedWhileReplicating() throws Exception {
                }
import org.opensearch.indices.replication.SegmentReplicationTarget;
                }
    public void testReplicaReceivesLowerGeneration() throws Exception {
            replicateSegments(primaryShard, shards.getReplicas());
import java.util.Collections;
        final IndexShard primarySource = newStartedShard(true, getIndexSettings());
import static org.hamcrest.Matchers.equalTo;
                logger.info("--> Recover newReplica {}", newReplica.shardId);
                    long replicationId,
            }
            final IndexShard primary = shards.getPrimary();
                    ActionListener<GetSegmentFilesResponse> listener
        oldPrimary.store().close();
            final int i1 = randomInt(5);
            assertEqualTranslogOperations(shards, primaryShard);
            assertEqualTranslogOperations(shards, primaryShard);
            behindReplicaBeforeRestart.store().close();
            SegmentReplicationSource source = new TestReplicationSource() {
            primaryTarget.getReplicationTracker()
                @Override
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
            startReplicationAndAssertCancellation(nextPrimary, oldPrimary, targetService);
                indicesService,
                }
            assertEqualCommittedSegments(replica_2, oldPrimary, behindReplicaAfterRestart);
            shards.assertAllEqual(numDocs);
            }
    }
                final IndexShard newReplica = shards.addReplicaWithExistingPath(
public class SegmentReplicationWithNodeToNodeIndexShardTests extends SegmentReplicationIndexShardTests {
                    );
                    List<StoreFileMetadata> filesToFetch,
                    ActionListener<CheckpointInfoResponse> listener
 * The OpenSearch Contributors require contributions made to
                final IndexShard replicaToRestart = getRandomReplica(shards);
            assertDocCount(behindReplicaAfterRestart, totalDocs);
                // randomly delete.
        }
            final IndicesService indicesService = mock(IndicesService.class);
import static org.mockito.Mockito.when;
            indexDoc(primarySource, "_doc", Integer.toString(i));
import java.util.Map;
    }
        // check that local checkpoint of new primary is properly tracked after primary relocation
            logger.info("--> Ingest {} docs again", numDocs);
            latch.await();
                clusterService
            closeShards(replica);
            }
            }, ThreadPool.Names.GENERIC, "");
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
        // index some more into both but don't replicate. replica will have only numDocs searchable, but should have totalDocs
                primaryShard,
            nextPrimary.refresh("test");
            assertEquals(additionalDocs, primary.translogStats().estimatedNumberOfOperations());
            final int numDocs = randomIntBetween(100, 200);
                indexMapping,
                @Override
            final IndexShard replica = shards.getReplicas().get(0);
            logger.info("--> Verify doc count");
            assertDocCount(nextPrimary, numDocs);
            shards.startAll();
                    IndexShard indexShard,
                    long replicationId,
    }
        assertDocCounts(oldPrimary, numDocs, numDocs);
            when(sourceFactory.get(any())).thenReturn(source);
            final SegmentReplicationTargetService targetService = new SegmentReplicationTargetService(
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
        // 2. Create ops that are in the replica's xlog, not in the index.
                        new IndexRequest(index.getName()).id(String.valueOf(i)).source("{ \"foo\" : \"baz\" }", MediaTypeRegistry.JSON)
                public void getSegmentFiles(
                // randomly restart a replica
     */
        try (ReplicationGroup shards = createGroup(2, getIndexSettings(), mappings, new NRTReplicationEngineFactory())) {
            doPrimaryPromotion(shards, randomInt(10), randomInt(10));
 * this file be licensed under the Apache-2.0 license or a
                    IndexShard indexShard,
            IndexShard primary = shards.getPrimary();
            shards.startAll();
                public void getCheckpointMetadata(
import org.opensearch.index.engine.NRTReplicationEngine;
            flushShard(primary, true);
                    ReplicationCheckpoint checkpoint,
            logger.info("--> Replicate segments");
            flushShard(primary, true);
import static org.mockito.ArgumentMatchers.any;
            final IndexShard behindReplicaBeforeRestart = shards.getReplicas().get(0);
    // Todo: Move this test to SegmentReplicationIndexShardTests so that it runs for both node-node & remote store
            logger.info("--> Index {} more docs", i1);
                }
            assertDocCounts(primary, numDocs, numDocs);
    }
            primary.refresh("Test");
 * compatible open source license.
            };
                    assertTrue(replicaStoreFiles.containsAll(temporaryFiles));
            for (int i = 0; i < numDocs; i++) {
            SegmentReplicationSource segmentReplicationSource = getSegmentReplicationSource(
            targetService.startReplication(
            replicateSegments(primary, shards.getReplicas());
                ) {}
                    ActionListener<GetSegmentFilesResponse> listener
                getTargetListener(primaryShard, replica, primaryMetadata, countDownLatch)
                threadPool,
                    ActionListener<CheckpointInfoResponse> listener
            startReplicationAndAssertCancellation(replica, primary, targetService);
            for (IndexShard shard : shards.getReplicas()) {
                public void onResponse(Releasable releasable) {
        try (ReplicationGroup shards = createGroup(2, getIndexSettings(), new NRTReplicationEngineFactory())) {
                assertEquals(getDocIdAndSeqNos(shard), docsAfterDelete);
                @Override
                .getLocalCheckpoint(),
                    engine.updateSegments(engine.getSegmentInfosSnapshot().get());
import java.util.function.Consumer;
            }
        // refresh and copy the segments over.
        }
            IndexShard primary = shards.getPrimary();
            closeShards(replica);
                    List<StoreFileMetadata> filesToFetch,
import org.opensearch.transport.TransportService;
        assertEquals(totalDocs, oldPrimary.translogStats().estimatedNumberOfOperations());
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
                    long replicationId,
        final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());
            final IndexShard replica = shards.getReplicas().get(0);
            };
            replicateSegments(replica_2, shards.getReplicas());
        for (IndexShard shard : shards) {
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;
                try {
            }
 */
            equalTo(totalOps - 1L)
import org.opensearch.index.mapper.MapperService;
            final IndexShard replica = shards.getReplicas().get(0);
            assertEquals(numDocs, primary.translogStats().getUncommittedOperations());
                    IndexShard indexShard,
 *
            for (IndexShard shard : shards.getReplicas()) {
            totalDocs += numDocs;
            flushShard(primary, true);
        for (int i = 0; i < totalOps; i++) {
            int numDocs = randomIntBetween(10, 100);
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
                primaryShard.getLatestReplicationCheckpoint(),
                @Override
            assertEquals(0, primary.translogStats().estimatedNumberOfOperations());
                // randomly update docs.
                @Override
    public void testReplicaClosesWhileReplicating_AfterGetSegmentFiles() throws Exception {
                shards.recoverReplica(newReplica);
        ) {
            final IndexShard primary = shards.getPrimary();
                    ActionListener<CheckpointInfoResponse> listener
        for (IndexShard shard : shards.getReplicas()) {
        };
        final int additionalDocs = shards.indexDocs(numDocsInSecondBatch);
        final IndexShard primaryTarget = newShard(
    public void testReplicaClosesWhileReplicating_AfterGetCheckpoint() throws Exception {
                    List<StoreFileMetadata> filesToFetch,
import org.opensearch.core.action.ActionListener;
                    throw new AssertionError(e);
    private void doPrimaryPromotion(ReplicationGroup shards, int numDocsInFirstBatch, int numDocsInSecondBatch) throws Exception {
            for (IndexShard shard : shards.getReplicas()) {
                    ReplicationCheckpoint checkpoint,
                    IndexShard indexShard,
            assertDocCounts(shard, numDocs, numDocs);
                flushShard(shards.getPrimary());
import org.opensearch.action.delete.DeleteRequest;
                final SegmentInfos primarySegmentInfos = segmentInfosSnapshot.get();
            IndexShard primaryShard = shards.getPrimary();
import org.junit.Assert;
            final IndexShard behindReplicaAfterRestart = shards.addReplicaWithExistingPath(
            behindReplicaBeforeRestart.close("restart", false, false);
            getIndexSettings(),
import org.opensearch.index.replication.TestReplicationSource;
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;
import org.opensearch.threadpool.ThreadPool;
        }
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"foo\": { \"type\": \"keyword\"} }}}";
            startReplicationAndAssertCancellation(replica, primary, targetService);
import org.opensearch.index.engine.DocIdSeqNoAndSource;
