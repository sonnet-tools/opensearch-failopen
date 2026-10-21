            RecoveryState.Stage stageToBlock,
    }
        }
                assertThat(shard.getMaxSeenAutoIdTimestamp(), equalTo(Math.max(maxTimestampOnReplica1, maxTimestampOnReplica2)));
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
            assertThat(translogOperations, either(equalTo(initialDocs + extraDocs)).or(equalTo(task.getResyncedOperations())));
            final IndexShard newPrimary = shards.getReplicas().get(0);
import org.opensearch.index.engine.InternalEngineTests;
        final int pendingDocs = randomIntBetween(1, 5);
                replica,
            RecoveryState.Stage.FINALIZE
                recoveryBlocked.countDown();
                    shards.flush();
            {
                    copyRequest.onRetry();
import org.opensearch.index.shard.IndexShard;
            if (syncedGlobalCheckPoint) {
        String mappings = "{ \"_doc\": { \"properties\": { \"f\": { \"type\": \"keyword\"} }}}";
            shards.syncGlobalCheckpoint();
                        }
                new SourceToParse("index", "replica", new BytesArray("{}"), MediaTypeRegistry.JSON)
                // Make sure the global checkpoint on the new primary is persisted properly,
            }
                shards.index(new IndexRequest(index.getName()).id("last").source("{}", MediaTypeRegistry.JSON));
    }
            shards.recoverReplica(newReplica);
        public void cleanFiles(
            }
        try (ReplicationGroup shards = new ReplicationGroup(metadata) {
                        indexOnReplica(replicationRequest, shards, replica);
            remainingReplica.close("disconnected", false, false);
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("stale_" + i).source("{}", MediaTypeRegistry.JSON);
                    assertThat(shards.getPrimary().getLocalCheckpoint(), equalTo(expectedDocs - 1));
            final int totalTranslogOps,
        public Engine newReadWriteEngine(final EngineConfig config) {
            recoveryBlocked.await();
                    } finally {
        };
                mappingVersion,
        }
                } else {
            recoveryStart.await();
                if (randomBoolean()) {
    public void testIndexingDuringFileRecovery() throws Exception {
                });
            // wait for the translog phase to complete and the recovery to block global checkpoint advancement
                        throw new AssertionError(e);
                Thread thread = new Thread(() -> {
            this.releaseRecovery = releaseRecovery;
}
            shards.assertAllEqual(totalDocs);
                latch.countDown();
                    node,
                        final List<Translog.Operation> operations,
                    oldPrimary.flush(new FlushRequest(index.getName()));
                assertThat(shards.getPrimary().getLocalCheckpoint(), equalTo(expectedDocs - 1));
            List<DocIdSeqNoAndSource> docsBelowGlobalCheckpoint = EngineTestCase.getDocIds(getEngine(newPrimary), randomBoolean())
        }
                assertThat(replica.getLocalCheckpoint(), lessThan(expectedDocs - 1));
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("initial_doc_" + i)
 * this work for additional information regarding copyright
            AtomicBoolean recoveryDone = new AtomicBoolean(false);
        private boolean hasBlocked() {
            logger.info("--> resyncing replicas seqno_stats primary {} replica {}", oldPrimary.seqNoStats(), newPrimary.seqNoStats());
            shards.syncGlobalCheckpoint();
                            } else if (frequently()) {
                1,
            }
            if (randomBoolean()) {
            oldPrimary.close("demoted", randomBoolean(), false);
            int moreDocsAfterRollback = shards.indexDocs(scaledRandomIntBetween(1, 20));
                };
                        final long mappingVersion,
/*
                    equalTo(Math.toIntExact(globalCheckpointOnOldPrimary - safeCommitOnOldPrimary.get().localCheckpoint))
                shards.index(request); // deliver via normal replication
            final RecoveryState.Stage blockOnStage = randomFrom(BlockingTarget.SUPPORTED_STAGES);
                    final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
            Store.MetadataSnapshot sourceMetadata,
            pendingDocsDone.await();
            assertTrue(safeCommitOnOldPrimary.isPresent());
                    }
            final int indexedDuringRecovery = shards.indexDocs(randomInt(5));
                // have to replicate to another replica != newPrimary one - the subject to trim
                assertThat(newReplica.recoveryState().getTranslog().recoveredOperations(), equalTo(uncommittedOpsOnPrimary));
                    } catch (Exception e) {
    public void testTransferMaxSeenAutoIdTimestampOnResync() throws Exception {
            shards.startAll();
            final List<Translog.Operation> operations,
        static final EnumSet<RecoveryState.Stage> SUPPORTED_STAGES = EnumSet.of(
                        // replica swaps engine during rollback
                return new RecoveryTarget(indexShard, node, recoveryListener, threadPool) {
                        );
                    }
                remainingReplica.getLocalCheckpoint() + 1,
            int translogOperations = 0;
            if (syncedGlobalCheckPoint) {
                }
                final long expectedDocs = docs + 3L;
                .collect(Collectors.toList());
                .filter(doc -> doc.getSeqNo() <= newPrimary.getLastKnownGlobalCheckpoint())
            latch.await();
        );
            }
    }
 * You may obtain a copy of the License at
                stopped.set(true);
import java.util.concurrent.atomic.AtomicReference;
                                shards.index(new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON));
            // check translog on replica is trimmed
                .stream()
                            replicaEngineFactory.awaitIndexersLatch();
 * license agreements. See the NOTICE file distributed with
                replicationRequests.add(copyRequest);
                // recovery has not completed, therefore the global checkpoint can have advanced on the primary
            shards.promoteReplicaToPrimary(replica1).get();
                        }
            IndexShard replica = shards.getReplicas().get(0);
            }
    public void testReplicaRollbackStaleDocumentsInPeerRecovery() throws Exception {
            }
        public void indexTranslogOperations(
                public long addDocument(final Iterable<? extends IndexableField> doc) throws IOException {
            shards.recoverReplica(recoveredReplica);
 *
                final long expectedDocs = docs + 2L;
                (indexShard, node) -> new BlockingTarget(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            // index some more
            });
            blocks.add(block);
                shard.flush(new FlushRequest().force(true).waitIfOngoing(true));
    }
                if (replica.indexSettings().isSoftDeleteEnabled()) {
                    copyRequest = copyIndexRequest(indexRequest);
                        assertThat(randomFrom(replicas).getLocalCheckpoint(), greaterThanOrEqualTo(initDocs - 1L));
                    replica.getMaxSeqNoOfUpdatesOrDeletes(),
                    recoveryBlocked,
import org.opensearch.index.store.Store;
                    VersionType.INTERNAL,
        }
                    assertBusy(() -> {
            int docs = shards.indexDocs(randomInt(50));
            final RetentionLeases retentionLeases,
            final long maxAutoIdTimestamp,
import java.util.Optional;
                        }
public class RecoveryDuringReplicationTests extends OpenSearchIndexLevelReplicationTestCase {
                shards.syncGlobalCheckpoint();
                    threadPool
            pendingDocDone.await();
                                .stream()
                    indexOnReplica(bulkShardRequest, shards, replica2);
                                .getAsLong(),
                            pendingDocActiveWithExtraDocIndexed.countDown();
                assertThat(
import org.opensearch.common.lucene.uid.Versions;
            final IndexShard newPrimary = shards.getReplicas().get(0);
                assertThat(newReplica.recoveryState().getIndex().fileDetails(), not(empty()));
            boolean expectSeqNoRecovery = (moreDocs == 0 || randomBoolean());
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            );
                        if (latch != null) {
            boolean appendOnly = randomBoolean();
                newPrimary.onSettingsChanged();
            for (IndexShard shard : shards) {
                        } catch (InterruptedException e) {
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, primary);
                assertThat(replica.getLastKnownGlobalCheckpoint(), lessThan(expectedDocs - 2));
                        final int totalTranslogOps,
            assert previous == null || blocks.contains(previous);
            shards.startAll();
                        // noinspection OptionalGetWithoutIsPresent since there must be at least one lease
            logger.info("--> indexing {} extra docs", extraDocs);
            shards.refresh("test");
import org.opensearch.common.lease.Releasable;
        private final CountDownLatch releaseRecovery;
                IndexShardTestCase.getReplicationTracker(newPrimary)
import org.apache.lucene.index.IndexableField;
            totalDocs += moreDocs;
                        pendingDocsDone.countDown();
                }
                    return super.addDocument(doc);
        private final RecoveryState.Stage stageToBlock;
            assertBusy(() -> assertThat(docId.get(), greaterThanOrEqualTo(100)), 60, TimeUnit.SECONDS); // we flush quite often
            for (int i = 0; i < extraDocsToBeTrimmed; i++) {
        public void awaitIndexersLatch() throws InterruptedException {
                retentionLeases,
        AtomicBoolean stopped = new AtomicBoolean();
import java.util.EnumSet;
    public void testResyncAfterPrimaryPromotion() throws Exception {
            PrimaryReplicaSyncer.ResyncTask task = shards.promoteReplicaToPrimary(newPrimary).get();
                        threadPool.generic().submit(() -> {
            super.cleanFiles(totalTranslogOps, globalCheckpoint, sourceMetadata, listener);
            }
            CountDownLatch recoveryBlocked,
                    assertThat(source.source.utf8ToString(), is("{ \"f\": \"normal\"}"));
    public void testAddNewReplicas() throws Exception {
                replica,
                                .min()
            final long maxSeqNoOfUpdates,
                    public void indexTranslogOperations(
        Runnable stopIndexing = () -> {
                    }
        try (ReplicationGroup shards = new ReplicationGroup(metadata) {
            }
                    ) {
    public void testRecoveryAfterPrimaryPromotion() throws Exception {
        @Override
                                pendingDocDone.countDown();
        try (ReplicationGroup shards = createGroup(2)) {
                for (Thread thread : threads) {
            shards.getPrimary().sync();
     * Simulate a scenario with two replicas where one of the replicas receives an extra document, the other replica is promoted on primary
                        if (replica == newPrimary) {
                // the pending document is not done, the checkpoints can not have advanced on the replica
            shards.startAll();
            super.indexTranslogOperations(
            protected EngineFactory getEngineFactory(final ShardRouting routing) {
            done.set(true);
                    assertThat(replica.getLocalCheckpoint(), equalTo(expectedDocs - 1));
                                .mapToLong(RetentionLease::retainingSequenceNumber)
                            } else {
                        } catch (Exception ex) {
            replica.close("recover replica - second time", false, false);
                        // index a doc which is not part of the snapshot, but also does not complete on replica
                            }
            final CountDownLatch releaseRecovery = new CountDownLatch(1);
                remainingReplica.routingEntry().currentNodeId()
                    assertThat(newPrimary.getLastSyncedGlobalCheckpoint(), equalTo(newPrimary.seqNoStats().getMaxSeqNo()));
            shards.recoverReplica(newReplica);
                )
        }
            this.stageToBlock = stageToBlock;
            primaryEngineFactory.latchIndexers(pendingDocs);
        }
                } else {
        @Override
                        final long maxAutoIdTimestamp,
            final CountDownLatch pendingDocActiveWithExtraDocIndexed = new CountDownLatch(1);
            shards.assertAllEqual(goodDocs);
            // Make sure that flushing on a recovering shard is ok.
        }
                    assertThat(replica.getLastKnownGlobalCheckpoint(), anyOf(equalTo(expectedDocs - 1), equalTo(expectedDocs - 2)));
        ) {
                totalDocs += uncommittedOpsOnPrimary;
            // simulate docs that were inflight when primary failed, these will be rolled back
            // wait for recovery to enter the translog phase
                operations,
                    while (stopped.get() == false) {
        private final List<CountDownLatch> blocks = new ArrayList<>();
                        .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)
                promotedReplica.applyIndexOperationOnPrimary(
        final BlockingEngineFactory primaryEngineFactory = new BlockingEngineFactory();
                            inFlightOpsOnNewPrimary++;
                    thread.join();
                        }
                        final RetentionLeases retentionLeases,
            final CountDownLatch phaseTwoStartLatch = new CountDownLatch(1);
                        throw new AssertionError(e);
                final IndexRequest indexRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);
/*
            shards.promoteReplicaToPrimary(newPrimary).get();
                indexOnReplica(bulkShardRequest, shards, replica);
                newPrimary.indexSettings().updateIndexMetadata(builder.build());
                }
                    indexOnReplica(bulkShardRequest, shards, replica1);
                                shards.index(new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON));
            }
            );
            allowIndexing();
                                throw new RuntimeException(e);
            shards.promoteReplicaToPrimary(newPrimary).get();
                    // The min_retained_seqno only advances when a merge asks for the retention query.
            }
            IndexShard newReplica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());
            closeShards(replica);
            blockIfNeeded(RecoveryState.Stage.INDEX);
                    try {
                .findSafeIndexCommit(globalCheckpointOnOldPrimary);
                recoveryStart.countDown();
                assertThat(newReplica.recoveryState().getIndex().fileDetails(), empty());
        ) {
                final int rollbackDocs = randomIntBetween(1, 5);
                thread.start();
 */
    public void testCheckpointsAndMarkingInSync() throws Exception {
            docs += indexedDuringRecovery;
            final int extraDocsToBeTrimmed = randomIntBetween(0, 10);
        List<Thread> threads = new ArrayList<>();
        public synchronized void releaseLatchedIndexers() {
            shards.promoteReplicaToPrimary(newPrimary).get();
            oldPrimary.store().close();
            }
import org.opensearch.index.engine.DocIdSeqNoAndSource;
                    }
            }
                            replicaEngineFactory.allowIndexing();
                logger.info("--> blocking recovery on stage [{}]", currentStage);
            // simulate docs that were inflight when primary failed
            stopIndexing.run();
                    return new InternalEngineFactory();
                    logger.info("--> recovery continues from stage [{}]", currentStage);
                assertThat(
                }
            }
                        );
                            maxSeqNoOfUpdates,
import org.opensearch.index.IndexSettings;
import java.util.ArrayList;
                            totalTranslogOps,
                    assertThat("unexpected op: " + next, (int) next.seqNo(), lessThan(initialDocs + extraDocs));
                    maxTimestampOnReplica1 = Math.max(maxTimestampOnReplica1, indexRequest.getAutoGeneratedTimestamp());
            shards.promoteReplicaToPrimary(promotedReplica).get();
            long maxTimestampOnReplica2 = -1;
            for (int i = 0; i < docs; i++) {
     * sequence-number based recovery is performed and the extra document does not remain after recovery.
                randomNonNegativeLong(),
            IndexShard replica = shards.getReplicas().get(1);
                    releaseRecovery,
            }
 * ownership. Elasticsearch licenses this file to you under
            docs += shards.indexDocs(randomInt(5));
                BulkShardRequest replicationRequest = indexOnPrimary(primaryRequest, shards.getPrimary());
                );
            CountDownLatch recoveryStart = new CountDownLatch(1);
            // check that local checkpoint of new primary is properly tracked after primary promotion
        }
 * specific language governing permissions and limitations
            assertThat(replica.getLastSyncedGlobalCheckpoint(), equalTo(replica.seqNoStats().getMaxSeqNo()));
 */
            thread.start();
                    }
import org.opensearch.index.mapper.SourceToParse;
            // As a replica keeps a safe commit, the file-based recovery only happens if the required translog
            pendingDocActiveWithExtraDocIndexed.await();
            shards.assertAllEqual(docs);
            for (int i = 0; i < pendingDocs; i++) {
            for (int i = 0; i < numThreads; i++) {
        try (ReplicationGroup shards = createGroup(2)) {
                                shards.getPrimary().flush(new FlushRequest());
import org.opensearch.action.bulk.BulkShardRequest;
                                shards.delete(new DeleteRequest(index.getName()).id(id));
            for (IndexShard shard : shards) {
 * software distributed under the License is distributed on an
            }
                                String id = randomBoolean() ? Integer.toString(nextId) : null;
import static org.hamcrest.Matchers.greaterThan;
                        try {
            shards.assertAllEqual(docs);
import static org.hamcrest.Matchers.anyOf;
                } else {
        private final CountDownLatch recoveryBlocked;
    static class BlockingEngineFactory implements EngineFactory, AutoCloseable {
                        try {
            assertBusy(() -> assertTrue("recovery should not wait for on pending docs", recoveryDone.get()));
            RecoveryState.Stage.TRANSLOG,
                threadPool.generic().submit(() -> {
            IndexShard newReplica = shards.addReplica();
                        .source("{}", MediaTypeRegistry.JSON);
            IndexShard primary = shards.getPrimary();
                        super.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, listener);
                throw new AssertionError(e);
                        }
            protected EngineFactory getEngineFactory(ShardRouting routing) {
                    indexShard,
            // index some more
            final AtomicBoolean done = new AtomicBoolean();
                        }
    public void testRecoveryToReplicaThatReceivedExtraDocument() throws Exception {
                logger.info("--> indexing {} rollback docs", rollbackDocs);
            shards.assertAllEqual(initDocs + inFlightOpsOnNewPrimary);
                    equalTo(Math.toIntExact(totalDocs - 1 - safeCommitOnOldPrimary.get().localCheckpoint))
import org.opensearch.indices.recovery.RecoveryState;
            for (int i = 0; i < inFlightOps; i++) {
            final int docs = shards.indexDocs(randomIntBetween(1, 10));
import static org.hamcrest.Matchers.is;
                    blockOnStage,
                } else {
 * under the License.
import org.opensearch.core.action.ActionListener;
                                String id = Integer.toString(between(0, nextId));
 * SPDX-License-Identifier: Apache-2.0
        public void close() throws Exception {
                assertThat(shards.getPrimary().getLastKnownGlobalCheckpoint(), equalTo(expectedDocs - 2));
            try (Translog.Snapshot snapshot = getTranslog(justReplica).newSnapshot()) {
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(2, mappings))) {
            if (expectSeqNoRecovery) {
                    final Translog.Source source = next.getSource();
                    // the global checkpoint advances can only advance here if a background global checkpoint sync fires
                    Versions.MATCH_ANY,
            shards.flush();
                    indexRequest.onRetry();
            primaryEngineFactory.close();
            assertBusy(() -> assertThat(docId.get(), greaterThanOrEqualTo(50)), 60, TimeUnit.SECONDS); // we flush quite often
import java.io.IOException;
                                shards.index(new IndexRequest(index.getName()).id("pending").source("{}", MediaTypeRegistry.JSON));
                            int nextId = docId.incrementAndGet();
                    assertThat(shards.getPrimary().getLastKnownGlobalCheckpoint(), equalTo(expectedDocs - 1));
                assertThat(shard.translogStats().getUncommittedOperations(), equalTo(0));
            IndexShard shard,
import org.apache.lucene.store.AlreadyClosedException;
                }
                if (rarely()) {
            IndexShard replica2 = shards.getReplicas().get(1);
            }
                    shards.syncGlobalCheckpoint();
            final IndexShard recoveredReplica = shards.addReplicaWithExistingPath(
            assertThat(replica2.getMaxSeenAutoIdTimestamp(), equalTo(maxTimestampOnReplica1));
                        replicaEngineFactory.latchIndexers(1);
                    0,
                        super.indexTranslogOperations(
            for (IndexRequest request : replicationRequests) {
                    }
            if (randomBoolean()) {
                    return primaryEngineFactory;
                    logger,
                equalTo(totalDocs - 1L)
 * this file be licensed under the Apache-2.0 license or a
        }
            );
            shards.removeReplica(replica);
        try (ReplicationGroup shards = createGroup(between(0, 1)); Releasable ignored = stopIndexing::run) {
                            latch.countDown();
                uncommittedOpsOnPrimary = shards.indexDocs(randomIntBetween(0, 10));
            int docs = shards.indexDocs(randomIntBetween(1, 10));
            shards.assertAllEqual(docs + (extra ? 1 : 0));
                    greaterThanOrEqualTo(shards.getPrimary().getMaxSeqNoOfUpdatesOrDeletes())
                // otherwise the deletion policy won't trim translog
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
        }
        private final AtomicReference<CountDownLatch> blockedIndexers = new AtomicReference<>();
            recoveryFuture.get();
 * Licensed to Elasticsearch under one or more contributor
            shards.assertAllEqual(initDocs + inFlightOpsOnNewPrimary + moreDocsAfterRollback);
            // wait for the pending ops to "hang"
import org.opensearch.action.delete.DeleteRequest;
            assertThat(recoveredReplica.recoveryState().getTranslog().recoveredOperations(), equalTo(extra ? 1 : 0));
                            }
        public synchronized void allowIndexing() {
                if (routing.primary()) {
            recoveryFuture.get();
import org.opensearch.threadpool.ThreadPool;
                        List<DocIdSeqNoAndSource> exposedDocs = EngineTestCase.getDocIds(getEngine(randomFrom(replicas)), randomBoolean());
                        .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
        try (ReplicationGroup shards = createGroup(randomInt(1))) {
    }
                            // the pending doc is latched in the engine
            for (int numDocs = between(1, 10), i = 0; i < numDocs; i++) {
            // simulate a background global checkpoint sync at which point we expect the global checkpoint to advance on the replicas
            }
                remainingReplica.getOperationPrimaryTerm(),
            assertThat(newPrimary.getLocalCheckpoint(), equalTo(totalDocs - 1L));
                indexOnReplica(bulkShardRequest, shards, newPrimary);
import org.apache.logging.log4j.Logger;
import static org.hamcrest.Matchers.everyItem;
                );
import java.util.stream.Collectors;
                                .leases()
            shards.startAll();
    }
            int numThreads = between(1, 3);
                    final CountDownLatch block = blockReference.get();
import org.opensearch.index.engine.EngineConfig;
import java.util.concurrent.CountDownLatch;
            int staleDocs = scaledRandomIntBetween(1, 10);
            assertThat(recoveredReplica.recoveryState().getIndex().fileDetails(), empty());
        }
                shards.flush();
            }, null, null, config);
                    releaseRecovery.await();
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
                assertBusy(() -> {
            if (expectSeqNoRecovery == false) {
            for (int i = 0; i < extraDocs; i++) {
                            if (appendOnly) {
            List<IndexRequest> replicationRequests = new ArrayList<>();
                threads.add(thread);
            final IndexShard justReplica = shards.getReplicas().get(1);
            for (int i = 0; i < staleDocs; i++) {
            shards.assertAllEqual(goodDocs);
                            mappingVersion,
 * The OpenSearch Contributors require contributions made to
                    // expires since there are no unassigned shards in this replication group).
import java.util.concurrent.atomic.AtomicInteger;
                List<IndexShard> replicas = new ArrayList<>(shards.getReplicas());
import static org.hamcrest.Matchers.equalTo;
                "id",
                            }
            final ActionListener<Long> listener
                IndexMetadata.Builder builder = IndexMetadata.builder(newPrimary.indexSettings().getIndexMetadata());
            blocks.clear();
            int totalTranslogOps,
            int inFlightOps = scaledRandomIntBetween(10, 200);
            } catch (Exception e) {
            CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.index.translog.Translog;
                            block.await();
            }
                assertThat(shards.getPrimary().getLastKnownGlobalCheckpoint(), equalTo(expectedDocs - 1));
                false,
            shards.recoverReplica(replica);
        @Override
                );
            oldPrimary.store().close();
                    throw new RuntimeException("blockage released");
import org.opensearch.Version;
            shards.removeReplica(remainingReplica);
            final IndexShard remainingReplica = shards.getReplicas().get(1);
            blockedIndexers.get().await();
            shards.assertAllEqual(goodDocs);
                assertThat(shards.getPrimary().getLocalCheckpoint(), equalTo(expectedDocs - 1));
        final IndexMetadata metadata = buildIndexMetadata(0);
            assertBusy(() -> assertThat(getDocIdAndSeqNos(newReplica), equalTo(getDocIdAndSeqNos(shards.getPrimary()))));
            if (SUPPORTED_STAGES.contains(stageToBlock) == false) {
        }
                    if (randomBoolean()) {
            IndexShard oldPrimary = shards.getPrimary();
        }
            shards.flush();
            assertThat(newReplica.recoveryState().getIndex().fileDetails(), empty());
                newPrimary.flush(new FlushRequest().force(true));
    public static class BlockingTarget extends RecoveryTarget {
            shards.syncGlobalCheckpoint();
            if (hasBlocked() == false) {
    public void testRollbackOnPromotion() throws Exception {
                }
            assertThat(
 * Unless required by applicable law or agreed to in writing,
            {
                            if (randomInt(100) < 5) {
                assertThat(replica.getLastKnownGlobalCheckpoint(), lessThan(expectedDocs - 1));
            int goodDocs = shards.indexDocs(scaledRandomIntBetween(1, 20));
            final IndexShard replica = shards.addReplica();
                            newPrimary.getRetentionLeases()
            assertThat(pendingDocDone.getCount(), equalTo(1L));
            }
            shards.recoverReplica(anotherReplica);
                assertThat(replica.getLocalCheckpoint(), lessThan(expectedDocs - 2));
 * Modifications Copyright OpenSearch Contributors. See
                blockIfNeeded(RecoveryState.Stage.TRANSLOG);
                    final IndexRequest indexRequest = new IndexRequest(index.getName()).id("rollback_" + i)
            return recoveryBlocked.getCount() == 0;
            AutoCloseable ignored = replicaEngineFactory // make sure we release indexers before closing
            }
        try (ReplicationGroup shards = createGroup(2)) {
            // Recover a replica again should also rollback the stale documents.
import static org.hamcrest.Matchers.lessThan;
            }
    }
                indexOnReplica(bulkShardRequest, shards, justReplica);
                                shards.getPrimary().forceMerge(new ForceMergeRequest().flush(randomBoolean()).maxNumSegments(1));
            remainingReplica.applyIndexOperationOnReplica(
                        try {
                if (randomBoolean()) {
            for (IndexShard replica : shards.getReplicas()) {
                shards.syncGlobalCheckpoint();
            @Override
                        .put(newPrimary.indexSettings().getSettings())
                    // We also need to make sure that there is no retention lease holding on to any history. The lease for the old primary
            this.logger = logger;
                        } catch (final Exception e) {
import java.util.List;
                uncommittedOpsOnPrimary = 0;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.engine.EngineFactory;
    public void testDoNotWaitForPendingSeqNo() throws Exception {
                shards.index(new IndexRequest("index").id(Integer.toString(i)).source("{}", MediaTypeRegistry.JSON));
        }
            }
                maxSeqNoOfUpdates,
                    .source("{ \"f\": \"normal\"}", MediaTypeRegistry.JSON);
            });
            this.recoveryBlocked = recoveryBlocked;
                        newPrimary.syncRetentionLeases();
import org.opensearch.cluster.metadata.IndexMetadata;
            );
                    translogOperations++;
            }
        }
            shards.startPrimary();
                );
import java.util.concurrent.atomic.AtomicBoolean;
        ) {
                if (routing.primary()) {
        public synchronized void latchIndexers(int count) {
                });
                            }
                            if (randomInt(100) < 10) {
            replica.store().close();
            }
            IndexShard newPrimary = randomFrom(shards.getReplicas());
     * failure, the receiving replica misses the primary/replica re-sync and then recovers from the primary. We expect that a
    }
                try {
            // randomly introduce a conflicting document
            RecoveryState.Stage.INDEX,
        try (ReplicationGroup shards = createGroup(between(2, 3))) {
            IndexShard anotherReplica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());
import java.util.concurrent.TimeUnit;
                        } catch (InterruptedException e) {
                            phaseTwoStartLatch.await();
import org.opensearch.index.seqno.RetentionLeases;
            replica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());
                    newReplica.recoveryState().getTranslog().totalLocal(),
            }
                    @Override
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("extra_doc_" + i)
            shards.flush();
            final int docs = randomIntBetween(0, 16);
                            try {
            logger.info("--> indexing {} extra docs to be trimmed", extraDocsToBeTrimmed);
                throw new UnsupportedOperationException(stageToBlock + " is not supported");
            Logger logger,
                        final CountDownLatch latch = blockedIndexers.get();
            CountDownLatch releaseRecovery,
            assert blockReference.compareAndSet(null, block);
            shards.startAll();
            }
 *
                            retentionLeases,
            final IndexShard oldPrimary = shards.getPrimary();
                }
import org.opensearch.index.shard.PrimaryReplicaSyncer;
                    if (block != null) {
                        shards.index(new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON));
    }
        }
                            // unblock indexing for the next doc
 * KIND, either express or implied.  See the License for the
    /*
                    new SourceToParse("index", "primary", new BytesArray("{}"), MediaTypeRegistry.JSON),
    }
                    copyRequest = copyIndexRequest(indexRequest);
            replica.store().close();
            DiscoveryNode sourceNode,
            final Future<Void> recoveryFuture = shards.asyncRecoverReplica(
                }
                                String id = Integer.toString(frequently() ? nextId : between(0, nextId));
                    shards.syncGlobalCheckpoint();
 * GitHub history for details.
        try (ReplicationGroup shards = createGroup(2)) {
            Thread thread = new Thread(() -> {
        } finally {
                    // We need an extra flush to advance the min_retained_seqno on the new primary so ops-based won't happen.
            logger.info("indexed [{}] docs", docs);
                        final long maxSeqNoOfUpdates,
            IndexShard replica1 = shards.getReplicas().get(0);
                            } catch (final Exception e) {
                while (done.get() == false) {
                shards.index(indexRequest);
            shards.flush();
                    false
            if (randomBoolean()) {
                        assertThat(docsBelowGlobalCheckpoint, everyItem(is(in(exposedDocs))));
                // it maybe that not ops have been transferred, block now
            shards.assertAllEqual(initialDocs + extraDocs);
            blockIfNeeded(RecoveryState.Stage.FINALIZE);
                            maxAutoIdTimestamp,
            int inFlightOpsOnNewPrimary = 0;
import static org.hamcrest.Matchers.in;
            if (hasBlocked() == false) {
            final IndexShard replica = shards.getReplicas().get(1);
                totalTranslogOps,
            int uncommittedOpsOnPrimary = 0;
        }
                        final ActionListener<Long> listener
        public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {
                    newReplica.recoveryState().getTranslog().recoveredOperations(),
        }
                );
        private void blockIfNeeded(RecoveryState.Stage currentStage) {
            boolean syncedGlobalCheckPoint = randomBoolean();
                for (IndexShard replica : shards.getReplicas()) {
                }
            long globalCheckpoint,
                    return new InternalEngineFactory();
                }
                            throw new AssertionError(e);
                }
            blockedIndexers.set(new CountDownLatch(count));
import org.opensearch.indices.recovery.RecoveryTarget;
                    .source("{ \"f\": \"trimmed\"}", MediaTypeRegistry.JSON);
                }
                assertEquals(extraDocs, task.getResyncedOperations());
                    } catch (Exception e) {
            shards.flush();
                blockIfNeeded(RecoveryState.Stage.TRANSLOG);
            );
            remainingReplica.store().close();
            final long mappingVersion,
                    maxTimestampOnReplica2 = Math.max(maxTimestampOnReplica2, indexRequest.getAutoGeneratedTimestamp());
                    .source("{ \"f\": \"normal\"}", MediaTypeRegistry.JSON);
            AtomicInteger docId = new AtomicInteger();
        }
                    newPrimary.flush(new FlushRequest().force(true));
                maxAutoIdTimestamp,
                remainingReplica.shardPath(),
                    return replicaEngineFactory;
            int initialDocs = randomInt(10);
            final boolean extra = randomBoolean();
import org.opensearch.indices.replication.common.ReplicationListener;
            }
package org.opensearch.index.replication;
            final Future<Void> recoveryFuture = shards.asyncRecoverReplica(newReplica, (indexShard, node) -> {
                @Override
            final IndexShard oldPrimary = shards.getPrimary();
                }
            if (currentStage == stageToBlock) {
        }
                assertBusy(() -> {
import org.opensearch.index.engine.InternalEngineFactory;
            logger.info("--> indexing {} stale docs", staleDocs);
                } catch (InterruptedException e) {
            releaseRecovery.countDown();
import org.opensearch.index.VersionType;
import org.opensearch.index.seqno.RetentionLease;
            IndexShard replica = shards.addReplica();
            // for the sequence based recovery are not fully retained and extra documents were added to the primary.
            assertThat(replica2.getMaxSeenAutoIdTimestamp(), equalTo(maxTimestampOnReplica2));
            } else {
                    }
            primaryEngineFactory.allowIndexing();
                    .getLocalCheckpoint(),
                final String id = "pending_" + i;
import org.apache.lucene.index.IndexWriter;
            shards.startAll();
        }) {
import static org.hamcrest.Matchers.empty;
                }
                            shards.index(new IndexRequest(index.getName()).id("completed").source("{}", MediaTypeRegistry.JSON));
            primaryEngineFactory.releaseLatchedIndexers();
            super(shard, sourceNode, listener, threadPool);
                while ((next = snapshot.next()) != null) {
        @Override
            IndexShard newReplica = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());
            docs += shards.indexDocs(randomInt(20));
                indexRequest.process(Version.CURRENT, null, index.getName());
 */
            shards.syncGlobalCheckpoint();
            // slip the extra document into the replica
            for (int i = 0; i < initialDocs; i++) {
            final int extraDocs = randomInt(5);
            assertThat(replica1.getMaxSeenAutoIdTimestamp(), equalTo(maxTimestampOnReplica1));
            ThreadPool threadPool
            shards.startAll();
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
                    recoveryListener,
            phaseTwoStartLatch.countDown();
                // simulate docs that were inflight when primary failed, these will be rolled back
            int totalDocs = shards.indexDocs(randomInt(10));
            shards.startAll();
                String id = "extra-" + i;
        public BlockingTarget(
        private final Logger logger;
            int initDocs = shards.indexDocs(randomInt(100));
            @Override
        ) {
            // index some more
            try {
     */
import org.opensearch.common.settings.Settings;
import static org.hamcrest.Matchers.either;
            replicaEngineFactory.releaseLatchedIndexers();
        private final AtomicReference<CountDownLatch> blockReference = new AtomicReference<>();
            int moreDocs = shards.indexDocs(randomIntBetween(0, 5));
            shards.removeReplica(replica);
            assertBusy(() -> assertTrue(shards.getPrimary().pendingInSync()));
                        });
            shards.removeReplica(replica);
            }
                for (int i = 0; i < rollbackDocs; i++) {
            shards.syncGlobalCheckpoint();
import org.opensearch.index.engine.EngineTestCase;
                    .getTrackedLocalCheckpointForShard(newPrimary.routingEntry().allocationId().getId())
        final BlockingEngineFactory replicaEngineFactory = new BlockingEngineFactory();
                assertThat(
                IndexRequest primaryRequest = new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON);
                            throw new AssertionError(ex);
                replicas.remove(newPrimary);
            }
            Optional<SequenceNumbers.CommitInfo> safeCommitOnOldPrimary = oldPrimary.store()
            return InternalEngineTests.createInternalEngine((directory, writerConfig) -> new IndexWriter(directory, writerConfig) {
                            greaterThan(newPrimary.seqNoStats().getMaxSeqNo())
                if (randomBoolean()) {
            {
            final CountDownLatch block = new CountDownLatch(1);
                            listener
            shards.flush();
            final CountDownLatch previous = blockReference.getAndSet(null);
                        recoveryDone.set(true);
            super.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, listener);
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("extra_trimmed_" + i)
            // Index more docs - move the global checkpoint >= seqno of the stale operations.
                }
import org.opensearch.action.admin.indices.flush.FlushRequest;
            final IndexShard promotedReplica = shards.getReplicas().get(0);
                    public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {
            ReplicationListener listener,
                    SequenceNumbers.UNASSIGNED_SEQ_NO,
    }
                            operations,
                    Settings.builder()
                        .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
                        try {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            );
            // now recovery can finish
                Translog.Operation next;
                        assertThat(
        }
        @Override
            final IndexShard oldPrimary = shards.getPrimary();
            final CountDownLatch pendingDocDone = new CountDownLatch(1);
            final CountDownLatch recoveryBlocked = new CountDownLatch(1);
            shards.startAll();
import org.opensearch.index.engine.Engine;
            if (extra) {
            CountDownLatch pendingDocsDone = new CountDownLatch(pendingDocs);
                assertThat(task.getResyncedOperations(), greaterThanOrEqualTo(extraDocs));
 *
 * not use this file except in compliance with the License.
                if (randomBoolean()) {
            } else {
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
                    });
                }
import java.util.concurrent.Future;
import org.opensearch.action.index.IndexRequest;
            blocks.forEach(CountDownLatch::countDown);
                    assertThat("unexpected primaryTerm: " + next.primaryTerm(), next.primaryTerm(), is(oldPrimary.getPendingPrimaryTerm()));
            docs += pendingDocs;
            }
import static org.hamcrest.Matchers.not;
import org.opensearch.index.shard.IndexShardTestCase;
            }
                    } catch (AlreadyClosedException ignored) {
            oldPrimary.close("demoted", false, false);
import org.opensearch.cluster.node.DiscoveryNode;
            goodDocs += shards.indexDocs(scaledRandomIntBetween(staleDocs, staleDocs * 5));
                    @Override
        IndexMetadata metadata = buildIndexMetadata(1);
        }
                    indexOnReplica(bulkShardRequest, shards, replica);
                listener
                });
                final IndexRequest copyRequest;
            releaseLatchedIndexers();
import org.opensearch.core.common.bytes.BytesArray;
            long maxTimestampOnReplica1 = -1;
                (indexShard, node) -> new RecoveryTarget(indexShard, node, recoveryListener, threadPool) {
                newPrimary.flush(new FlushRequest());
                builder.settings(
            // Recover a replica should rollback the stale documents
 * compatible open source license.
            final Future<Void> recoveryFuture = shards.asyncRecoverReplica(
        };
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
            IndexShard newPrimary = shards.getReplicas().get(0);
            replica.close("recover replica - first time", false, false);
            }
            long globalCheckpointOnOldPrimary = oldPrimary.getLastSyncedGlobalCheckpoint();
import org.opensearch.cluster.routing.ShardRouting;
import org.opensearch.index.seqno.SequenceNumbers;
            recoveryFuture.get();
            ActionListener<Void> listener
                final long expectedDocs = docs + 3L;
                            } finally {
                            throw new AssertionError(e);
                    try {
            primaryEngineFactory.awaitIndexersLatch();
                            throw new AssertionError(e);
                });
            thread.join();
                // recovery is now in the process of being completed, therefore the global checkpoint can not have advanced on the primary
