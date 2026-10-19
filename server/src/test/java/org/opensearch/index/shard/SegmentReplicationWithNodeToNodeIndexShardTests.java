    /**
        final RecoverySettings recoverySettings = new RecoverySettings(
        try (ReplicationGroup shards = createGroup(3, getIndexSettings(), new NRTReplicationEngineFactory())) {
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
            closeShards(replica);
                    long replicationId,
            assertDocCount(newReplica, numDocs);
 * compatible open source license.
import java.util.function.BiConsumer;
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
                assertEquals(getDocIdAndSeqNos(shard), docsAfterDelete);  
import static org.mockito.Mockito.mock;
                }
                // randomly update docs.  
            replicateSegments(primaryShard, shards.getReplicas());  
            for (IndexShard shard : shards.getReplicas()) {  
import org.opensearch.common.concurrent.GatedCloseable;  
import java.util.concurrent.CountDownLatch;
            }, ThreadPool.Names.GENERIC, "");
        }
            primary.refresh("Test");
            when(sourceFactory.get(any())).thenReturn(source);
            indexDoc(primarySource, "_doc", Integer.toString(i));
            for (IndexShard shard : shards.getReplicas()) {
                clusterService
    }
            IndexShard newReplica = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());  
            final IndexShard primary = shards.getPrimary();  
                shards.indexDocs(randomInt(10));  
        }  
                    ReplicationCheckpoint checkpoint,
            // close behindReplicaBeforeRestart - we will re-open it after replica_2 is promoted as new primary.  
            };
        Function<List<IndexShard>, List<SegmentReplicationTarget>> replicatePrimaryFunction = (shardList) -> {  
        final IndexShard nextPrimary = shards.getReplicas().get(0);
import java.io.IOException;  
            replicateSegments(primary, shards.getReplicas());  
            }
        assertThat(
            final int numDocs = randomIntBetween(100, 200);  
        assertEquals(NRTReplicationEngine.class, getEngine(oldPrimary).getClass());  
            SegmentReplicationSource source = new TestReplicationSource() {
            final IndexShard primaryShard = shards.getPrimary();
                    ReplicationCheckpoint checkpoint,  
                    // trigger a cancellation by closing the replica.  
                @Override  
            replicateSegments(nextPrimary, shards.getReplicas());
            primary.refresh("Test");
            assertEquals(additionalDocs, primary.translogStats().estimatedNumberOfOperations());
                    throw new AssertionError(e);  
            }  
            for (int i = 0; i < i1; i++) {
            final Consumer<IndexShard> runnablePostGetFiles = (indexShard) -> {
    public void testReplicaPromotedWhileReplicating() throws Exception {
                new NRTReplicationEngineFactory(),
                    ActionListener<CheckpointInfoResponse> listener
            );
                    targetService.beforeIndexShardClosed(replica.shardId, replica, Settings.EMPTY);
                @Override
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
                }
            behindReplicaBeforeRestart.store().close();
import java.util.function.Function;  
                    ActionListener<GetSegmentFilesResponse> listener
            final int numDocs = shards.indexDocs(randomInt(10));
            primary.refresh("Test");
            }  
                final IndexShard primary = shardList.get(0);  
            }  
                    List<StoreFileMetadata> filesToFetch,
import org.junit.Assert;
            }  
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
            nextPrimary.refresh("test");  
                primaryShard,
    // Todo: Move this test to SegmentReplicationIndexShardTests so that it runs for both node-node & remote store  
import org.opensearch.index.engine.DocIdSeqNoAndSource;
        replicateSegments(oldPrimary, shards.getReplicas());  
        recoverReplica(primaryTarget, primarySource, true, replicatePrimaryFunction);  
        }
    }
            // Step 1. Ingest numDocs documents, commit to create commit point on primary & replicate  
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
    public void testReplicaClosesWhileReplicating_AfterGetCheckpoint() throws Exception {
                ) {
                    long replicationId,
                    IndexShard indexShard,  
            shards.startAll();
            numDocs = randomIntBetween(numDocs + 1, numDocs + 10);
                    IndexShard indexShard,  
                primaryMetadata = primaryShard.store().getSegmentMetadataMap(primarySegmentInfos);  
            assertDocCount(behindReplicaAfterRestart, totalDocs);
            startReplicationAndAssertCancellation(replica, primary, targetService);  
            when(sourceFactory.get(any())).thenReturn(source);
                final SegmentInfos primarySegmentInfos = segmentInfosSnapshot.get();
            Map<String, StoreFileMetadata> primaryMetadata;  
            shards.startAll();  
                // refresh and push segments to our other replicas.  
                sourceFactory,  
    // Todo: Move this test to SegmentReplicationIndexShardTests so that it runs for both node-node & remote store  
                }
        for (IndexShard shard : shards.getReplicas()) {
            replicateSegments(primaryShard, shards.getReplicas());
            assertEquals("Replication failed", 0, countDownLatch.getCount());
            flushShard(primary, true);
                public void getCheckpointMetadata(  
                    replicaToRestart.shardPath(),  
                    ReplicationCheckpoint checkpoint,
        oldPrimary.close("demoted", false, false);
                2,
            );
            shards.indexDocs(numDocs);  
                .build(),
            primarySource.routingEntry().getTargetRelocatingShard(),  
                        shards.promoteReplicaToPrimary(nextPrimary);
            shards.removeReplica(replica);
                .getTrackedLocalCheckpointForShard(primaryTarget.routingEntry().allocationId().getId())  
                    listener.onFailure(new CancellableThreads.ExecutionCancelledException("Cancelled"));
        );
            primary = shards.getPrimary();
            IndexShard oldPrimary = shards.addReplicaWithExistingPath(primary.shardPath(), primary.routingEntry().currentNodeId());  
            SegmentReplicationSource segmentReplicationSource = getSegmentReplicationSource(  
                indicesService,
                @Override
                assertConsistentHistoryBetweenTranslogAndLucene(shard);
            final CountDownLatch countDownLatch = new CountDownLatch(1);
                    BiConsumer<String, Long> fileProgressTracker,  
            assertEquals(numDocs, primary.translogStats().estimatedNumberOfOperations());
    }
                    ShardRouting oldRouting = nextPrimary.shardRouting;  
            assertEquals(0, primary.translogStats().estimatedNumberOfOperations());
            SegmentReplicationSource source = new TestReplicationSource() {  
                logger.info("--> Recover newReplica {}", newReplica.shardId);  
        // check that local checkpoint of new primary is properly tracked after primary relocation
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);  
            when(sourceFactory.get(any())).thenReturn(source);
                    targetService.shardRoutingChanged(nextPrimary, oldRouting, nextPrimary.shardRouting);  
        nextPrimary.refresh("test");  
            replicateSegments(primary, List.of(behindReplicaBeforeRestart));
            assertDocCount(nextPrimary, numDocs);  
        // index some more into both but don't replicate. replica will have only numDocs searchable, but should have totalDocs
                    );
package org.opensearch.index.shard;
    public void testPrimaryPromotionWithConcurrentTranslogRecovery() throws Exception {  
                    Assert.fail("Should not be reached");
            final IndexShard replica = shards.getReplicas().get(0);
        }  
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
            SegmentReplicationSource source = new TestReplicationSource() {  
                primaryShard.getLatestReplicationCheckpoint(),  
            primaryShard.refresh("Test");  
import org.opensearch.indices.replication.SegmentReplicationSource;
            shards.startAll();  
            IndexShard primary = shards.getPrimary();
import java.util.stream.Stream;
                    List<StoreFileMetadata> filesToFetch,
            assertDocCount(oldPrimary, totalDocs);
            final IndexShard behindReplicaBeforeRestart = shards.getReplicas().get(0);  
        assertEquals(totalDocs, nextPrimary.translogStats().getUncommittedOperations());
                    ActionListener<GetSegmentFilesResponse> listener
            shards.startAll();
            logger.info("--> Inserting documents {}", numDocs);
                }
        );  
            IndexShard primary = shards.getPrimary();
            SegmentReplicationSource source = new TestReplicationSource() {
    public void testReplicaClosesWhileReplicating_AfterGetSegmentFiles() throws Exception {  
 * SPDX-License-Identifier: Apache-2.0
                    Collection<String> replicaStoreFiles = List.of(indexShard.store().directory().listAll());  
        assertEquals(InternalEngine.class, getEngine(nextPrimary).getClass());
            assertDocCount(replica, totalDocs);
                    ReplicationCheckpoint checkpoint,  
            };
            primary.refresh("Test");
            startReplicationAndAssertCancellation(nextPrimary, oldPrimary, targetService);
import org.opensearch.index.mapper.MapperService;
                logger.info("--> Restarting replica {}", replicaToRestart.shardId);
                    BiConsumer<String, Long> fileProgressTracker,
            startReplicationAndAssertCancellation(replica, primary, targetService);  
            };
import org.opensearch.indices.IndicesService;
            final IndexShard replica_2 = shards.getReplicas().get(1);
     * Verifies that commits on replica engine resulting from engine or reader close does not cleanup the temporary
            totalDocs += numDocs;
            oldPrimary.close("demoted", false, false);
            };  
            IndexShard primary = shards.getPrimary();  
            }
                    assertTrue(replicaStoreFiles.containsAll(temporaryFiles));
                        new IndexRequest(index.getName()).id(String.valueOf(i)).source("{ \"foo\" : \"baz\" }", MediaTypeRegistry.JSON)  
        }  
            assertEqualCommittedSegments(replica_2, oldPrimary, behindReplicaAfterRestart);
                    ReplicationCheckpoint checkpoint,
            final int numDocs = randomIntBetween(10, 100);
                    BiConsumer<String, Long> fileProgressTracker,  
                    listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));
            };
        IndexShard oldPrimary = shards.getPrimary();  
        }
    public void testReplicaReceivesGenIncrease() throws Exception {  
    public void testNRTReplicaPromotedAsPrimary() throws Exception {  
                    long replicationId,  
            totalDocs += numDocs;
                public void getCheckpointMetadata(
                runnablePostGetFiles
            nextPrimary.refresh("test");
                replicaToRestart.store().close();  
    }
            assertDocCount(replica_2, totalDocs);  
        }
            assertDocCount(replica_2, 0);
                }  
            startReplicationAndAssertCancellation(replica, primary, targetService);  
            assertEquals(numDocs, replica.translogStats().estimatedNumberOfOperations());
                }
                    long replicationId,  
                        Assert.fail("Promotion should not fail");
            final IndexShard nextPrimary = shards.getReplicas().get(0);
    private void doPrimaryPromotion(ReplicationGroup shards, int numDocsInFirstBatch, int numDocsInSecondBatch) throws Exception {
            replicateSegments(primaryShard, shards.getReplicas());  
            final List<DocIdSeqNoAndSource> docsAfterDelete = getDocIdAndSeqNos(primaryShard);
            primaryShard.flush(new FlushRequest().waitIfOngoing(true).force(true));
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
        final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());  
            );  
            final int numDocs = randomIntBetween(100, 200);
                    ReplicationCheckpoint checkpoint,
    // Todo: Move this test to SegmentReplicationIndexShardTests so that it runs for both node-node & remote store
            primary.store().close();
                if (randomBoolean()) {
            shards.recoverReplica(behindReplicaAfterRestart);
            try {
    }
        }  
            closeShards(replica);  
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"foo\": { \"type\": \"keyword\"} }}}";
            shards.indexDocs(numDocs);  
                }
            assertEqualCommittedSegments(primary, replica);  
        assertEquals(totalDocs, replica.translogStats().getUncommittedOperations());  
                }
import org.opensearch.transport.TransportService;  
                public void getSegmentFiles(
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
        // at this point both shards should have numDocs persisted and searchable.
                public void getCheckpointMetadata(
                }
import org.opensearch.common.settings.ClusterSettings;
                    IndexShard indexShard,
                ) {  
import java.util.concurrent.TimeUnit;  
                    this.listener = listener;
import org.opensearch.index.store.StoreFileMetadata;  
                throw new RuntimeException(e);  
            primaryShard.refresh("Test");
                    NRTReplicationEngine engine = (NRTReplicationEngine) ((EngineBackedIndexer) (indexShard.getIndexer())).getEngine();
import org.opensearch.index.engine.EngineBackedIndexer;
                    // simulate listener resolving, but only after we have issued a cancel from beforeIndexShardClosed .  
            }  
/*  
            shards.promoteReplicaToPrimary(replica_2).get();  
            final int numDocs = shards.indexDocs(randomInt(10));  
                    ActionListener<GetSegmentFilesResponse> listener
        final int numDocs = shards.indexDocs(numDocsInFirstBatch);
            for (IndexShard shard : shards) {
                    targetService.beforeIndexShardClosed(replica.shardId, replica, Settings.EMPTY);
import org.opensearch.index.replication.TestReplicationSource;
}
            assertEquals(additionalDocs, replica.translogStats().getUncommittedOperations());
            assertDocCounts(primary, numDocs, numDocs);
                threadPool,  
                    List<StoreFileMetadata> filesToFetch,
            equalTo(totalOps - 1L)
        // persisted.
            shards.indexDocs(numDocs);
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterReplication));  
                    replicaToRestart.routingEntry().currentNodeId()
            getIndexSettings(),
import static java.util.Arrays.asList;
            shards.startAll();  
                .getLocalCheckpoint(),
        }
                } catch (IOException e) {
                behindReplicaBeforeRestart.shardPath(),
                );
import java.util.function.Consumer;
        final int additionalDocs = shards.indexDocs(numDocsInSecondBatch);  
                    ReplicationCheckpoint checkpoint,  
        // close and start the oldPrimary as a replica.  
            replicateSegments(primaryShard, shards.getReplicas());
 *
            shards.assertAllEqual(numDocs);  
                    List<StoreFileMetadata> filesToFetch,
                .put(RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE.getKey(), true)  
    public void testPrimaryCancelsExecution() throws Exception {
        }  
                    IndexShard indexShard,  
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
                public void onResponse(Releasable releasable) {  
import java.util.stream.Collectors;
            } catch (IOException | InterruptedException e) {
        assertThat(primaryTarget.getLocalCheckpoint(), equalTo(totalOps - 1L));  
        replicateSegments(nextPrimary, asList(replica));
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            for (int i = 0; i < numDocs; i++) {
            final IndexShard replica = shards.getReplicas().get(0);
                    ReplicationCheckpoint checkpoint,
                    try {
                new RecoverySettings(Settings.EMPTY, new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)),
                getTargetListener(primaryShard, replica, primaryMetadata, countDownLatch)
        try (ReplicationGroup shards = createGroup(2, getIndexSettings(), mappings, new NRTReplicationEngineFactory())) {
        for (IndexShard shard : shards.getReplicas()) {
                    shards.index(
                    long replicationId,
    }  
            // refresh and copy the segments over.  
                @Override  
import java.util.List;  
        }
            shards.recoverReplica(oldPrimary);
        final IndexShard primarySource = newStartedShard(true, getIndexSettings());
import org.opensearch.index.engine.InternalEngine;  
                shards.recoverReplica(newReplica);
    public void testCloseShardWhileGettingCheckpoint() throws Exception {
import org.opensearch.index.engine.NRTReplicationEngineFactory;
                ) {
                @Override  
            shards.startAll();
                    long replicationId,  
        // when a replica gets incoming segments that are lower than what it currently has on disk.
            logger.info("--> Ingest {} docs again", numDocs);  
            }  
                    listener.onResponse(new GetSegmentFilesResponse(Collections.emptyList()));  
            replicateSegments(primary, shards.getReplicas());  
                public void getSegmentFiles(
            doPrimaryPromotion(shards, randomInt(10), randomInt(10));
        // 2. Create ops that are in the replica's xlog, not in the index.  
        oldPrimary = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());  
            when(indicesService.getShardOrNull(replica.shardId)).thenReturn(replica);
            final SegmentReplicationTargetService targetService = new SegmentReplicationTargetService(
import org.opensearch.action.admin.indices.flush.FlushRequest;
                    targetService.beforeIndexShardClosed(replica.shardId, replica, Settings.EMPTY);
                    throw new RuntimeException(e);  
            int totalDocs = numDocs;  
                    // Step 5. Validate temporary files are not deleted from store.
                flushShard(shards.getPrimary());
    public void testTemporaryFilesNotCleanup() throws Exception {
                    ActionListener<GetSegmentFilesResponse> listener
        String mappings = "{ \"" + MapperService.SINGLE_MAPPING_NAME + "\": { \"properties\": { \"foo\": { \"type\": \"keyword\"} }}}";  
                ) {}  
    }
    public void testReplicaReceivesLowerGeneration() throws Exception {  
            try (final GatedCloseable<SegmentInfos> segmentInfosSnapshot = primaryShard.getSegmentInfosSnapshot()) {
                    final RuntimeException exception = new CancellableThreads.ExecutionCancelledException("retryable action was cancelled");
            final List<DocIdSeqNoAndSource> docs = getDocIdAndSeqNos(primaryShard);  
                }
            assertEquals(0, primary.translogStats().getUncommittedOperations());  
        );  
                public void getSegmentFiles(
        shards.recoverReplica(oldPrimary);
            final CountDownLatch latch = new CountDownLatch(1);  
                .put(RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE.getKey(), 1000)
                    long replicationId,  
            shards.assertAllEqual(numDocs);
            final int i1 = randomInt(5);  
                    // set the listener, we will only fail it once we cancel the source.
    }
                assert shardList.size() >= 2;
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.common.lease.Releasable;
                    // shard is closing while we are copying files.  
                public void getCheckpointMetadata(
                    resolveCheckpointInfoResponseListener(listener, oldPrimary);
                if (randomBoolean()) {
            for (IndexShard shard : shards.getReplicas()) {
            assertEquals(0, replica.translogStats().estimatedNumberOfOperations());
            shards.assertAllEqual(numDocs);  
            assertDocCount(primary, totalDocs);
            for (IndexShard shard : shards.getReplicas()) {
            // Step 3. Copy segment files to replica shard but prevent commit
                public void onFailure(Exception e) {
                    // randomly resolve the listener, indicating the source has resolved.  
            IndexShard primaryShard = shards.getPrimary();  
import org.opensearch.common.settings.Settings;  
    public void testPrimaryRelocation() throws Exception {
            }
import org.opensearch.indices.replication.SegmentReplicationTargetService;
                        .filter(name -> name.startsWith(SegmentReplicationTarget.REPLICATION_PREFIX))
                ) {
                getIndexSettings(),
                    Assert.fail("Unreachable");
            assertEqualTranslogOperations(shards, primaryShard);
            when(sourceFactory.get(any())).thenReturn(source);
        }
            when(sourceFactory.get(any())).thenReturn(source);  
            final int numDocs = shards.indexDocs(randomInt(10));
            assertEquals(0, replica.translogStats().getUncommittedOperations());
            flushShard(primary, true);
                ) {  
    }
            shards.startAll();
import org.opensearch.action.delete.DeleteRequest;  
            latch.await();  
            logger.info("--> Verify doc count");  
                    ActionListener<CheckpointInfoResponse> listener
import static org.hamcrest.Matchers.equalTo;
            assertEqualTranslogOperations(shards, primaryShard);
                // randomly delete.
            final IndexShard replica = shards.getReplicas().get(0);  
                    long replicationId,
        final int totalDocs = numDocs + additionalDocs;
            }
import org.opensearch.index.engine.exec.EngineBackedIndexerFactory;  
                    }
import org.opensearch.cluster.routing.ShardRouting;
            flushShard(primary, true);  
        try (ReplicationGroup shards = createGroup(2, getIndexSettings(), new NRTReplicationEngineFactory())) {
                final IndexShard replicaToRestart = getRandomReplica(shards);  
            assertEqualTranslogOperations(shards, primaryShard);
                if (randomBoolean()) {  
            final IndexShard behindReplicaAfterRestart = shards.addReplicaWithExistingPath(  
            assertEqualTranslogOperations(shards, primaryShard);
                return replicateSegments(primary, shardList.subList(1, shardList.size()));
import org.opensearch.core.xcontent.MediaTypeRegistry;  
                recoverySettings,
import org.opensearch.indices.replication.SegmentReplicationTarget;
import org.opensearch.core.action.ActionListener;
        }  
            shards.startAll();  
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
        assertEquals(totalDocs, oldPrimary.translogStats().estimatedNumberOfOperations());
            shards.removeReplica(replica);  
            new EngineBackedIndexerFactory(new NRTReplicationEngineFactory())
                (repId) -> targetService.get(repId),
            startReplicationAndAssertCancellation(replica, primary, targetService);
                behindReplicaBeforeRestart.routingEntry().currentNodeId()
import org.opensearch.index.engine.NRTReplicationEngine;
        }  
        }
            shards.removeReplica(replica);
            oldPrimary.store().close();
        assertEquals(totalDocs, replica.translogStats().estimatedNumberOfOperations());
            assertConsistentHistoryBetweenTranslogAndLucene(shard);
                ) {  
import org.opensearch.common.util.CancellableThreads;
import org.opensearch.indices.replication.SegmentReplicationSourceFactory;  
            final IndexShard replica = shards.getReplicas().get(0);
                    ActionListener<CheckpointInfoResponse> listener
    }  
                assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
                @Override
            // Step 2. Ingest numDocs documents again to create a new commit on primary
            IndexShard primary = shards.getPrimary();
import org.opensearch.action.index.IndexRequest;
            assertEquals(numDocs, replica.translogStats().getUncommittedOperations());
            for (int i = 0; i < numDocs; i++) {
                replicaToRestart.close("restart", false, false);
    }  
            shards.assertAllEqual(numDocs);
                    ActionListener<GetSegmentFilesResponse> listener
        oldPrimary.refresh("Test");
                }
            int numDocs = randomIntBetween(10, 100);
            assertEqualCommittedSegments(primary, behindReplicaBeforeRestart);
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
        for (IndexShard shard : shards.getReplicas()) {
            flushShard(primary);
        assertDocCount(primaryTarget, totalOps);
            final int numDocs = shards.indexDocs(randomInt(10));  
            };
            // refresh and push segments to our other replica.  
            )
            }  
                }  
                        .collect(Collectors.toList());
                shards.index(new IndexRequest(index.getName()).id(String.valueOf(i)).source("{\"foo\": \"bar\"}", MediaTypeRegistry.JSON));
            assertThat(shard.routingEntry().toString(), getDocIdAndSeqNos(shard), equalTo(docsAfterRecovery));
            final IndexShard replica = shards.getReplicas().get(0);
            shards.startAll();
            assertEquals(additionalDocs, primary.translogStats().getUncommittedOperations());
                    failAndPromoteRandomReplica(shards);
                @Override
            shards.recoverReplica(newReplica);
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
            assertEquals(numDocs, primary.translogStats().getUncommittedOperations());  
            logger.info("--> Replicate segments");
                ) {
            flushShard(primary, true);
            final int additionalDocs = shards.indexDocs(randomIntBetween(numDocs + 1, numDocs + 10));  
            assertDocCounts(shard, numDocs, numDocs);
            assertDocCount(behindReplicaBeforeRestart, totalDocs);  
            replicateSegments(replica_2, shards.getReplicas());
            final int totalDocs = numDocs + additionalDocs;
        try (
        updateMappings(primaryTarget, primarySource.indexSettings().getIndexMetadata());
            assertEquals(0, replica.translogStats().estimatedNumberOfOperations());
                    } catch (IOException e) {  
            countDownLatch.await(30, TimeUnit.SECONDS);  
        ) {
            logger.info("--> Index {} more docs", i1);
        // refresh and copy the segments over.
import java.util.Collections;
                    latch.countDown();
        final IndexShard primaryTarget = newShard(
        // 1. Create ops that are in the index and xlog of both shards but not yet part of a commit point.
                    ActionListener<CheckpointInfoResponse> listener
                ActionListener<CheckpointInfoResponse> listener;
    public void testSegmentReplication_Index_Update_Delete() throws Exception {  
            numDocs = randomIntBetween(numDocs + 1, numDocs + 10);  
            primaryShard.refresh("Test");
                public void cancel() {
            shards.removeReplica(behindReplicaBeforeRestart);
        assertEqualTranslogOperations(shards, oldPrimary);
import static org.mockito.Mockito.when;
                    // Step 4. Perform a commit on replica shard.
        assertEqualTranslogOperations(shards, oldPrimary);
            }
                @Override
        };
                }
        oldPrimary.store().close();
 */  
            );  
                    BiConsumer<String, Long> fileProgressTracker,
            assertEquals(0, primary.translogStats().estimatedNumberOfOperations());  
            flushShard(primary, true);  
                }
            primaryTarget.getReplicationTracker()
            flushShard(replica_2, false);  
        assertEquals(totalDocs, nextPrimary.translogStats().estimatedNumberOfOperations());  
import org.apache.lucene.index.SegmentInfos;
            assertEquals(0, primary.translogStats().getUncommittedOperations());
                (repId) -> targetService.getMergedSegmentReplicationRef(repId),  
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {  
            closeShards(replica);  
        try (ReplicationGroup shards = createGroup(2, getIndexSettings(), new NRTReplicationEngineFactory())) {  
        assertDocCounts(oldPrimary, numDocs, numDocs);  
    }
            ReplicationGroup shards = createGroup(  
                    IndexShard indexShard,
            primary.refresh("Test");
            targetService.startReplication(
            Settings.builder()
                @Override  
import org.opensearch.threadpool.ThreadPool;
            doPrimaryPromotion(shards, randomInt(10), randomIntBetween(1100, 2000));  
 * this file be licensed under the Apache-2.0 license or a
            IndexShard primary = shards.getPrimary();
            assertEquals(getEngine(nextPrimary).getClass(), InternalEngine.class);
        shards.promoteReplicaToPrimary(nextPrimary);
     * replication files from ongoing round of segment replication  
                    BiConsumer<String, Long> fileProgressTracker,
        final IndexShard replica = shards.getReplicas().get(1);
            behindReplicaBeforeRestart.close("restart", false, false);  
 * The OpenSearch Contributors require contributions made to  
            replicateSegments(primary, List.of(behindReplicaBeforeRestart));  
    public void testReplicaRestarts() throws Exception {
                try {
                    shards.delete(new DeleteRequest(index.getName()).id(String.valueOf(i)));
            oldPrimary.refresh("Test");
                }
            logger.info("--> Index {} documents on primary", numDocs);
            replicateSegments(primary, shards.getReplicas());
                    ReplicationCheckpoint checkpoint,  
            final List<DocIdSeqNoAndSource> docsAfterRecovery = getDocIdAndSeqNos(shards.getPrimary());
                    ReplicationCheckpoint checkpoint,
                    List<StoreFileMetadata> filesToFetch,
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), new NRTReplicationEngineFactory())) {
                flushShard(primary);
                assertEquals(getDocIdAndSeqNos(shard), docs);
     */
                @Override
            }
                    listener.onFailure(exception);
public class SegmentReplicationWithNodeToNodeIndexShardTests extends SegmentReplicationIndexShardTests {
import org.opensearch.indices.replication.GetSegmentFilesResponse;
                @Override
            primary.refresh("test");  
import org.opensearch.indices.replication.checkpoint.ReplicationCheckpoint;
            for (int i = 0; i < numDocs; i++) {
            final IndexShard primary = shards.getPrimary();
            nextPrimary.acquirePrimaryOperationPermit(new ActionListener<>() {
import java.util.Map;
            flushShard(primary, true);
                    ActionListener<CheckpointInfoResponse> listener  
                mock(TransportService.class),
            if (randomBoolean()) {
            assertEquals(additionalDocs, replica.translogStats().estimatedNumberOfOperations());  
            when(sourceFactory.get(any())).thenReturn(segmentReplicationSource);  
            assertEqualTranslogOperations(shards, primaryShard);  
import org.opensearch.indices.replication.CheckpointInfoResponse;  
                public void getSegmentFiles(
        shards.startAll();
                }  
        // refresh and push segments to our other replica.
        for (IndexShard shard : shards) {  
            final IndexShard oldPrimary = shards.getPrimary();
        assertEquals(0, nextPrimary.translogStats().estimatedNumberOfOperations());  
            for (IndexShard shard : shards.getReplicas()) {
                    long replicationId,  
                    Collection<String> temporaryFiles = Stream.of(indexShard.store().directory().listAll())  
            assertDocCounts(shard, totalDocs, numDocs);  
        // this can happen when a replica is promoted that is further behind the other replicas.
            closeShards(replica);  
            }  
                    engine.updateSegments(engine.getSegmentInfosSnapshot().get());  
                @Override
                public void getCheckpointMetadata(
                assertDocCounts(shard, numDocs, numDocs);  
                @Override
        shards.syncGlobalCheckpoint();  
            replicateSegments(primary, shards.getReplicas());
        try (ReplicationGroup shards = createGroup(1, getIndexSettings(), mappings, new NRTReplicationEngineFactory())) {
                public void getSegmentFiles(
                    long replicationId,
            final IndexShard replica = shards.getReplicas().get(0);
            shards.syncGlobalCheckpoint();  
            shards.startAll();  
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);
                final IndexShard newReplica = shards.addReplicaWithExistingPath(
                replicateSegments(shards.getPrimary(), shards.getReplicas());
            // at this point both shards should have numDocs persisted and searchable.
            // wait for replica to finish being promoted, and assert doc counts.
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);  
            replicateSegments(primary, shards.getReplicas());
            final IndicesService indicesService = mock(IndicesService.class);  
            SegmentReplicationSource source = new TestReplicationSource() {
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;  
        assertDocCounts(nextPrimary, totalDocs, totalDocs);
        assertDocCounts(oldPrimary, totalDocs, totalDocs);  
                replica,
            assertEquals(0, replica.translogStats().getUncommittedOperations());  
        }
            shards.removeReplica(replica);
            final SegmentReplicationTargetService targetService = newTargetService(sourceFactory);
                MergedSegmentPublisher.EMPTY  
        IndexShardTestCase.updateRoutingEntry(primarySource, primarySource.routingEntry().relocate(randomAlphaOfLength(10), -1));
            // 1. Create ops that are in the index and xlog of both shards but not yet part of a commit point.
    }
        int totalOps = randomInt(10);  
    }  
                // randomly restart a replica
                ) {
import java.util.Collection;
import org.opensearch.indices.recovery.RecoverySettings;
            }
        }
                ) {  
            final List<DocIdSeqNoAndSource> docsAfterReplication = getDocIdAndSeqNos(shards.getPrimary());
            primary.close("demoted", randomBoolean(), false);
    // Todo: Move this test to SegmentReplicationIndexShardTests so that it runs for both node-node & remote store
        closeShards(primarySource, primaryTarget);
            for (int i = 0; i < numDocs; i++) {  
        // promote the replica
            shards.indexDocs(numDocs);
        for (int i = 0; i < totalOps; i++) {
                    resolveCheckpointInfoResponseListener(listener, primary);  
                indexMapping,  
                shards.removeReplica(replicaToRestart);
            for (int i = 0; i < numDocs; i++) {
            final SegmentReplicationSourceFactory sourceFactory = mock(SegmentReplicationSourceFactory.class);  
