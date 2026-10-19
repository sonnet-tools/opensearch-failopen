            primaryEngineFactory.latchIndexers(pendingDocs);
import static org.hamcrest.Matchers.is;
                1,  
            final CountDownLatch previous = blockReference.getAndSet(null);  
                        } catch (final Exception e) {
                    assertThat("unexpected primaryTerm: " + next.primaryTerm(), next.primaryTerm(), is(oldPrimary.getPendingPrimaryTerm()));
                    indexRequest.onRetry();
            AtomicInteger docId = new AtomicInteger();
                            // the pending doc is latched in the engine
            {  
                // it maybe that not ops have been transferred, block now
    }  
                    public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {
                        super.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, listener);
                // Make sure the global checkpoint on the new primary is persisted properly,
    /*  
            }
import static org.hamcrest.Matchers.not;  
                    } catch (AlreadyClosedException ignored) {  
            for (IndexShard shard : shards) {
            // simulate a background global checkpoint sync at which point we expect the global checkpoint to advance on the replicas
                        .put(IndexSettings.INDEX_TRANSLOG_RETENTION_SIZE_SETTING.getKey(), "-1")
                    logger.info("--> recovery continues from stage [{}]", currentStage);
            final CountDownLatch block = new CountDownLatch(1);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.engine.InternalEngineTests;
            final IndexShard replica = shards.getReplicas().get(1);  
            replica.store().close();
            if (randomBoolean()) {
            assertTrue(safeCommitOnOldPrimary.isPresent());  
            boolean appendOnly = randomBoolean();  
import org.opensearch.index.engine.InternalEngineFactory;  
                final IndexRequest copyRequest;
                } else {  
                assertThat(shard.translogStats().getUncommittedOperations(), equalTo(0));  
                );
                promotedReplica.applyIndexOperationOnPrimary(
            assertBusy(() -> assertTrue(shards.getPrimary().pendingInSync()));
            int inFlightOpsOnNewPrimary = 0;
            if (expectSeqNoRecovery) {  
            shards.flush();  
                newPrimary.onSettingsChanged();  
            shards.promoteReplicaToPrimary(newPrimary).get();
                    SequenceNumbers.UNASSIGNED_SEQ_NO,  
            final IndexShard newPrimary = shards.getReplicas().get(0);
                latch.countDown();  
            int inFlightOps = scaledRandomIntBetween(10, 200);  
                listener
     * Simulate a scenario with two replicas where one of the replicas receives an extra document, the other replica is promoted on primary
    }  
            oldPrimary.store().close();
        }  
            primaryEngineFactory.awaitIndexersLatch();  
            shards.recoverReplica(newReplica);
            final IndexShard oldPrimary = shards.getPrimary();
/*  
            goodDocs += shards.indexDocs(scaledRandomIntBetween(staleDocs, staleDocs * 5));
                    @Override
            if (SUPPORTED_STAGES.contains(stageToBlock) == false) {
                    assertThat(shards.getPrimary().getLocalCheckpoint(), equalTo(expectedDocs - 1));
                            operations,
            if (hasBlocked() == false) {
            int moreDocs = shards.indexDocs(randomIntBetween(0, 5));
                    assertThat(shards.getPrimary().getLastKnownGlobalCheckpoint(), equalTo(expectedDocs - 1));
            CountDownLatch recoveryStart = new CountDownLatch(1);
import static org.hamcrest.Matchers.either;  
            final IndexShard justReplica = shards.getReplicas().get(1);
            latch.await();
                BulkShardRequest replicationRequest = indexOnPrimary(primaryRequest, shards.getPrimary());
                }  
            int goodDocs = shards.indexDocs(scaledRandomIntBetween(1, 20));
            shards.recoverReplica(anotherReplica);  
                // recovery is now in the process of being completed, therefore the global checkpoint can not have advanced on the primary
                for (Thread thread : threads) {  
                        final CountDownLatch latch = blockedIndexers.get();
import org.opensearch.index.IndexSettings;
            shards.recoverReplica(replica);
 * under the License.  
            oldPrimary.close("demoted", false, false);  
                        }  
        try (ReplicationGroup shards = createGroup(2)) {
            oldPrimary.close("demoted", randomBoolean(), false);  
        @Override
                    return primaryEngineFactory;
                assertThat(shards.getPrimary().getLastKnownGlobalCheckpoint(), equalTo(expectedDocs - 2));
        }
            ThreadPool threadPool
                }
                Thread thread = new Thread(() -> {
        }
            pendingDocActiveWithExtraDocIndexed.await();
import java.io.IOException;
            blocks.clear();
import static org.hamcrest.Matchers.empty;
            final RetentionLeases retentionLeases,  
                    } catch (Exception e) {  
                    .getTrackedLocalCheckpointForShard(newPrimary.routingEntry().allocationId().getId())
                        .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_OPERATIONS_SETTING.getKey(), 0)  
            int totalDocs = shards.indexDocs(randomInt(10));
                            throw new AssertionError(e);  
                }
                        recoveryDone.set(true);  
import org.apache.lucene.index.IndexWriter;
                });  
            final IndexShard newPrimary = shards.getReplicas().get(0);
            }
                            }
    public void testTransferMaxSeenAutoIdTimestampOnResync() throws Exception {
import java.util.concurrent.atomic.AtomicBoolean;  
            primaryEngineFactory.releaseLatchedIndexers();
    }
                if (randomBoolean()) {
import java.util.List;
            }
            releaseLatchedIndexers();
            int staleDocs = scaledRandomIntBetween(1, 10);
import org.opensearch.common.lease.Releasable;
            shards.assertAllEqual(docs);
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("initial_doc_" + i)
                shards.index(indexRequest);
import org.opensearch.index.engine.Engine;
            final AtomicBoolean done = new AtomicBoolean();
 * specific language governing permissions and limitations
public class RecoveryDuringReplicationTests extends OpenSearchIndexLevelReplicationTestCase {
                        assertThat(docsBelowGlobalCheckpoint, everyItem(is(in(exposedDocs))));
            phaseTwoStartLatch.countDown();
                logger.info("--> blocking recovery on stage [{}]", currentStage);
            final boolean extra = randomBoolean();  
            }
            }, null, null, config);
        try (ReplicationGroup shards = new ReplicationGroup(metadata) {
            for (int numDocs = between(1, 10), i = 0; i < numDocs; i++) {
            // wait for recovery to enter the translog phase
            if (extra) {
    public void testResyncAfterPrimaryPromotion() throws Exception {
                    equalTo(Math.toIntExact(globalCheckpointOnOldPrimary - safeCommitOnOldPrimary.get().localCheckpoint))
                    copyRequest = copyIndexRequest(indexRequest);
                        final RetentionLeases retentionLeases,
            for (IndexShard shard : shards) {  
        @Override
            shards.assertAllEqual(docs + (extra ? 1 : 0));  
                );
            List<IndexRequest> replicationRequests = new ArrayList<>();
                indexOnReplica(bulkShardRequest, shards, newPrimary);
            int initDocs = shards.indexDocs(randomInt(100));
                    shards.syncGlobalCheckpoint();
                    }
                        .put(newPrimary.indexSettings().getSettings())  
            shards.startAll();
        ) {
                                String id = randomBoolean() ? Integer.toString(nextId) : null;  
import java.util.EnumSet;  
                        } catch (Exception ex) {  
import org.opensearch.index.shard.IndexShard;  
            assertThat(recoveredReplica.recoveryState().getTranslog().recoveredOperations(), equalTo(extra ? 1 : 0));
    public void testIndexingDuringFileRecovery() throws Exception {
            final IndexShard remainingReplica = shards.getReplicas().get(1);  
            // index some more  
                        }
            int totalTranslogOps,
                    replica.getMaxSeqNoOfUpdatesOrDeletes(),
        private final RecoveryState.Stage stageToBlock;  
                assertThat(replica.getLastKnownGlobalCheckpoint(), lessThan(expectedDocs - 1));
                totalTranslogOps,  
 *
            ActionListener<Void> listener
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);  
 *     http://www.apache.org/licenses/LICENSE-2.0
                assertBusy(() -> {  
            Thread thread = new Thread(() -> {  
            RecoveryState.Stage stageToBlock,  
            final int extraDocsToBeTrimmed = randomIntBetween(0, 10);
    }
            }
                        .source("{}", MediaTypeRegistry.JSON);
        }
                                String id = Integer.toString(frequently() ? nextId : between(0, nextId));  
            recoveryFuture.get();  
            replicaEngineFactory.releaseLatchedIndexers();
                }
                            block.await();
            }
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("extra_doc_" + i)
import static org.hamcrest.Matchers.everyItem;  
                    // We need an extra flush to advance the min_retained_seqno on the new primary so ops-based won't happen.  
import org.opensearch.cluster.routing.ShardRouting;
            super.indexTranslogOperations(
                                .getAsLong(),  
            shards.startAll();
import org.opensearch.index.VersionType;  
                    // The min_retained_seqno only advances when a merge asks for the retention query.
            }
        public void cleanFiles(
        try (ReplicationGroup shards = createGroup(2)) {  
        AtomicBoolean stopped = new AtomicBoolean();
            shards.removeReplica(replica);
                    return super.addDocument(doc);  
            AutoCloseable ignored = replicaEngineFactory // make sure we release indexers before closing
            for (int i = 0; i < pendingDocs; i++) {
            assertThat(
                    assertThat(replica.getLastKnownGlobalCheckpoint(), anyOf(equalTo(expectedDocs - 1), equalTo(expectedDocs - 2)));
            replica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());  
                    }
            stopIndexing.run();
                            throw new AssertionError(ex);
        private final CountDownLatch recoveryBlocked;
                    assertThat(replica.getLocalCheckpoint(), equalTo(expectedDocs - 1));  
            IndexShard shard,  
    public void testRecoveryToReplicaThatReceivedExtraDocument() throws Exception {
                } catch (InterruptedException e) {  
            // Make sure that flushing on a recovering shard is ok.
            protected EngineFactory getEngineFactory(ShardRouting routing) {  
            // for the sequence based recovery are not fully retained and extra documents were added to the primary.
        }
        private final AtomicReference<CountDownLatch> blockedIndexers = new AtomicReference<>();
            shards.getPrimary().sync();  
            IndexShard primary = shards.getPrimary();
        }  
import org.opensearch.index.mapper.SourceToParse;
                            // unblock indexing for the next doc
                retentionLeases,  
                assertEquals(extraDocs, task.getResyncedOperations());  
                    }
            for (IndexRequest request : replicationRequests) {  
            @Override
            assertThat(replica2.getMaxSeenAutoIdTimestamp(), equalTo(maxTimestampOnReplica2));  
                public long addDocument(final Iterable<? extends IndexableField> doc) throws IOException {
            assertBusy(() -> assertTrue("recovery should not wait for on pending docs", recoveryDone.get()));  
            CountDownLatch recoveryBlocked,
            final int extraDocs = randomInt(5);
                        try {  
                        indexOnReplica(replicationRequest, shards, replica);
            }  
            remainingReplica.close("disconnected", false, false);  
import org.opensearch.index.store.Store;  
                    newReplica.recoveryState().getTranslog().totalLocal(),  
                new SourceToParse("index", "replica", new BytesArray("{}"), MediaTypeRegistry.JSON)  
                final IndexRequest indexRequest = new IndexRequest(index.getName()).source("{}", MediaTypeRegistry.JSON);  
            shards.flush();
    }  
            blockedIndexers.set(new CountDownLatch(count));  
                    }
                .filter(doc -> doc.getSeqNo() <= newPrimary.getLastKnownGlobalCheckpoint())
                                shards.index(new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON));
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
                    greaterThanOrEqualTo(shards.getPrimary().getMaxSeqNoOfUpdatesOrDeletes())
            } catch (Exception e) {  
            } else {
package org.opensearch.index.replication;
            return recoveryBlocked.getCount() == 0;
                final long expectedDocs = docs + 2L;
            recoveryFuture.get();  
                indexOnReplica(bulkShardRequest, shards, replica);
            });  
                    indexShard,
                    final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
        public synchronized void releaseLatchedIndexers() {
            super(shard, sourceNode, listener, threadPool);  
                            retentionLeases,  
                        } catch (InterruptedException e) {
import java.util.concurrent.TimeUnit;
        }
                (indexShard, node) -> new RecoveryTarget(indexShard, node, recoveryListener, threadPool) {  
        } finally {
                if (randomBoolean()) {  
                            if (randomInt(100) < 5) {  
import org.opensearch.action.bulk.BulkShardRequest;
                    if (randomBoolean()) {  
import org.opensearch.Version;
import org.opensearch.index.seqno.SequenceNumbers;
                while (done.get() == false) {
                        );
            if (hasBlocked() == false) {
            IndexShard anotherReplica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());
            IndexShard replica = shards.getReplicas().get(1);
    public void testCheckpointsAndMarkingInSync() throws Exception {  
            Optional<SequenceNumbers.CommitInfo> safeCommitOnOldPrimary = oldPrimary.store()
            this.recoveryBlocked = recoveryBlocked;
import org.opensearch.indices.replication.common.ReplicationListener;
    }
            assertThat(replica.getLastSyncedGlobalCheckpoint(), equalTo(replica.seqNoStats().getMaxSeqNo()));  
        );
                    assertThat(newPrimary.getLastSyncedGlobalCheckpoint(), equalTo(newPrimary.seqNoStats().getMaxSeqNo()));
                            maxSeqNoOfUpdates,
                return new RecoveryTarget(indexShard, node, recoveryListener, threadPool) {  
        public BlockingTarget(
            shards.removeReplica(replica);
 * GitHub history for details.
            IndexShard newPrimary = shards.getReplicas().get(0);  
                try {  
            assertBusy(() -> assertThat(docId.get(), greaterThanOrEqualTo(100)), 60, TimeUnit.SECONDS); // we flush quite often  
                assertThat(  
                assertThat(
                    return new InternalEngineFactory();
 * The OpenSearch Contributors require contributions made to  
                if (routing.primary()) {  
            final long maxAutoIdTimestamp,
                        threadPool.generic().submit(() -> {
                assertThat(  
                            greaterThan(newPrimary.seqNoStats().getMaxSeqNo())
                                .stream()  
                                shards.index(new IndexRequest(index.getName()).id("pending").source("{}", MediaTypeRegistry.JSON));  
        }
                logger.info("--> indexing {} rollback docs", rollbackDocs);
            {
            );
                    } catch (Exception e) {
                        }
            Logger logger,  
                    // expires since there are no unassigned shards in this replication group).
                }
    }
import org.apache.lucene.store.AlreadyClosedException;
            shards.flush();  
        }
                String id = "extra-" + i;
                if (replica.indexSettings().isSoftDeleteEnabled()) {
        String mappings = "{ \"_doc\": { \"properties\": { \"f\": { \"type\": \"keyword\"} }}}";
        ) {  
            allowIndexing();
            shards.recoverReplica(newReplica);
            }  
            }
            }
                operations,
                            } finally {  
        Runnable stopIndexing = () -> {  
            final int docs = randomIntBetween(0, 16);
        public synchronized void allowIndexing() {
                );  
            shards.assertAllEqual(totalDocs);
        ) {  
                );  
                    blockOnStage,
                        // index a doc which is not part of the snapshot, but also does not complete on replica
            for (int i = 0; i < initialDocs; i++) {
                            replicaEngineFactory.allowIndexing();
import java.util.Optional;
                assertThat(shard.getMaxSeenAutoIdTimestamp(), equalTo(Math.max(maxTimestampOnReplica1, maxTimestampOnReplica2)));
            for (IndexShard replica : shards.getReplicas()) {
                final long expectedDocs = docs + 3L;
                            throw new AssertionError(e);
            final CountDownLatch releaseRecovery = new CountDownLatch(1);
            shards.startAll();
                shards.index(new IndexRequest("index").id(Integer.toString(i)).source("{}", MediaTypeRegistry.JSON));
                });  
                for (IndexShard replica : shards.getReplicas()) {
                        throw new AssertionError(e);
        }
            shards.assertAllEqual(goodDocs);
            assertThat(translogOperations, either(equalTo(initialDocs + extraDocs)).or(equalTo(task.getResyncedOperations())));  
                        assertThat(randomFrom(replicas).getLocalCheckpoint(), greaterThanOrEqualTo(initDocs - 1L));
                    if (block != null) {
 * You may obtain a copy of the License at  
            CountDownLatch releaseRecovery,
                final long expectedDocs = docs + 3L;
                    shards.flush();
                }  
    }
            shards.assertAllEqual(docs);  
            }
                                .leases()
                                pendingDocDone.countDown();
                assertThat(newReplica.recoveryState().getTranslog().recoveredOperations(), equalTo(uncommittedOpsOnPrimary));  
            final int docs = shards.indexDocs(randomIntBetween(1, 10));
import org.opensearch.action.index.IndexRequest;
            IndexShard replica2 = shards.getReplicas().get(1);
            );
            // Index more docs - move the global checkpoint >= seqno of the stale operations.  
        public void close() throws Exception {  
            shards.assertAllEqual(initialDocs + extraDocs);
        final IndexMetadata metadata = buildIndexMetadata(0);
                // the pending document is not done, the checkpoints can not have advanced on the replica
                .collect(Collectors.toList());  
                replicationRequests.add(copyRequest);
                if (rarely()) {
                    indexOnReplica(bulkShardRequest, shards, replica1);
            docs += shards.indexDocs(randomInt(5));
                replica,
                        } catch (InterruptedException e) {
                assertThat(replica.getLocalCheckpoint(), lessThan(expectedDocs - 1));  
            shards.flush();  
            done.set(true);
import org.opensearch.index.engine.EngineConfig;  
                    shards.syncGlobalCheckpoint();
            long maxTimestampOnReplica1 = -1;
                IndexMetadata.Builder builder = IndexMetadata.builder(newPrimary.indexSettings().getIndexMetadata());  
import org.opensearch.index.engine.EngineTestCase;
                while ((next = snapshot.next()) != null) {
            shards.startAll();
                    new SourceToParse("index", "primary", new BytesArray("{}"), MediaTypeRegistry.JSON),
            final IndexShard recoveredReplica = shards.addReplicaWithExistingPath(  
                        }
                        final long maxAutoIdTimestamp,
                        List<DocIdSeqNoAndSource> exposedDocs = EngineTestCase.getDocIds(getEngine(randomFrom(replicas)), randomBoolean());  
                    }
                    node,
            final ActionListener<Long> listener
            recoveryFuture.get();  
            recoveryBlocked.await();  
                .stream()
                        replicaEngineFactory.latchIndexers(1);  
                    .source("{ \"f\": \"normal\"}", MediaTypeRegistry.JSON);  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    VersionType.INTERNAL,
            IndexShard newReplica = shards.addReplicaWithExistingPath(replica.shardPath(), replica.routingEntry().currentNodeId());  
            assert previous == null || blocks.contains(previous);
                    maxTimestampOnReplica1 = Math.max(maxTimestampOnReplica1, indexRequest.getAutoGeneratedTimestamp());
                } else {
                    0,
            } else {
                } else {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
                replica,
                        );  
                remainingReplica.shardPath(),
                    } finally {
                            shards.index(new IndexRequest(index.getName()).id("completed").source("{}", MediaTypeRegistry.JSON));  
            blockIfNeeded(RecoveryState.Stage.INDEX);
            }  
        }  
                }  
                } else {  
            final Future<Void> recoveryFuture = shards.asyncRecoverReplica(newReplica, (indexShard, node) -> {
            }
            shards.promoteReplicaToPrimary(newPrimary).get();  
            final List<Translog.Operation> operations,
                            } else if (frequently()) {
import org.opensearch.cluster.node.DiscoveryNode;  
            logger.info("--> indexing {} extra docs to be trimmed", extraDocsToBeTrimmed);  
                if (randomBoolean()) {  
                    thread.join();
                if (randomBoolean()) {
import static org.hamcrest.Matchers.in;  
                    return new InternalEngineFactory();
                }  
                remainingReplica.routingEntry().currentNodeId()
            shards.startPrimary();  
            shards.syncGlobalCheckpoint();
            blocks.add(block);
                        try {
                    final Translog.Source source = next.getSource();
                        final ActionListener<Long> listener  
            shards.recoverReplica(recoveredReplica);
        }  
                    return replicaEngineFactory;  
                mappingVersion,
            // index some more
                    indexOnReplica(bulkShardRequest, shards, replica);  
        final int pendingDocs = randomIntBetween(1, 5);
            final int totalTranslogOps,  
            {  
            if (syncedGlobalCheckPoint) {
            docs += indexedDuringRecovery;
                            }
            IndexShard replica1 = shards.getReplicas().get(0);  
                    translogOperations++;
                shards.syncGlobalCheckpoint();  
            final CountDownLatch pendingDocActiveWithExtraDocIndexed = new CountDownLatch(1);
            IndexShard newReplica = shards.addReplicaWithExistingPath(oldPrimary.shardPath(), oldPrimary.routingEntry().currentNodeId());  
            assertBusy(() -> assertThat(getDocIdAndSeqNos(newReplica), equalTo(getDocIdAndSeqNos(shards.getPrimary()))));
            CountDownLatch latch = new CountDownLatch(1);
                shards.flush();
    static class BlockingEngineFactory implements EngineFactory, AutoCloseable {
                    releaseRecovery.await();
                blockIfNeeded(RecoveryState.Stage.TRANSLOG);  
                                shards.getPrimary().forceMerge(new ForceMergeRequest().flush(randomBoolean()).maxNumSegments(1));
                        final int totalTranslogOps,
        try (ReplicationGroup shards = new ReplicationGroup(metadata) {  
            }  
                IndexShardTestCase.getReplicationTracker(newPrimary)  
            shards.removeReplica(remainingReplica);
            // Recover a replica should rollback the stale documents
import java.util.concurrent.CountDownLatch;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.admin.indices.flush.FlushRequest;  
                assertThat(replica.getLastKnownGlobalCheckpoint(), lessThan(expectedDocs - 2));
            replica.close("recover replica - second time", false, false);  
import org.opensearch.index.translog.Translog;
            super.finalizeRecovery(globalCheckpoint, trimAboveSeqNo, listener);  
            // check translog on replica is trimmed  
import java.util.ArrayList;
            this.releaseRecovery = releaseRecovery;
            final IndexShard promotedReplica = shards.getReplicas().get(0);
            }
import static org.hamcrest.Matchers.greaterThan;
            }
            PrimaryReplicaSyncer.ResyncTask task = shards.promoteReplicaToPrimary(newPrimary).get();
                final int rollbackDocs = randomIntBetween(1, 5);  
            final CountDownLatch phaseTwoStartLatch = new CountDownLatch(1);
                    public void indexTranslogOperations(
                    copyRequest = copyIndexRequest(indexRequest);
                // recovery has not completed, therefore the global checkpoint can have advanced on the primary  
            }
            int moreDocsAfterRollback = shards.indexDocs(scaledRandomIntBetween(1, 20));
                newPrimary.indexSettings().updateIndexMetadata(builder.build());
                assertThat(newReplica.recoveryState().getIndex().fileDetails(), empty());
            logger.info("--> indexing {} extra docs", extraDocs);  
                        });  
import org.opensearch.common.settings.Settings;
        public void finalizeRecovery(long globalCheckpoint, long trimAboveSeqNo, ActionListener<Void> listener) {  
        private final CountDownLatch releaseRecovery;
            if (randomBoolean()) {  
            shards.removeReplica(replica);  
                    indexOnReplica(bulkShardRequest, shards, replica2);
            shards.promoteReplicaToPrimary(newPrimary).get();
import org.opensearch.common.lucene.uid.Versions;  
            );  
            if (expectSeqNoRecovery == false) {
            }
                    copyRequest.onRetry();
import org.opensearch.core.action.ActionListener;
        }
                "id",  
                            try {
import org.opensearch.index.engine.DocIdSeqNoAndSource;
                        try {  
                    @Override
            RecoveryState.Stage.FINALIZE
            final RecoveryState.Stage blockOnStage = randomFrom(BlockingTarget.SUPPORTED_STAGES);  
            blockIfNeeded(RecoveryState.Stage.FINALIZE);
import org.opensearch.index.engine.EngineFactory;
                            pendingDocActiveWithExtraDocIndexed.countDown();
            replica.store().close();
 */  
            final long mappingVersion,
            );  
        @Override  
                stopped.set(true);
            }
            // index some more  
        private final List<CountDownLatch> blocks = new ArrayList<>();
}  
            assert blockReference.compareAndSet(null, block);
                maxSeqNoOfUpdates,
                // otherwise the deletion policy won't trim translog
                randomNonNegativeLong(),
                    ) {
            }
                    recoveryBlocked,
        }  
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, primary);
                // simulate docs that were inflight when primary failed, these will be rolled back
import org.opensearch.index.shard.PrimaryReplicaSyncer;
            // wait for the pending ops to "hang"
            IndexShard replica = shards.getReplicas().get(0);  
                if (routing.primary()) {
            // Recover a replica again should also rollback the stale documents.
                            newPrimary.getRetentionLeases()
            }
        public void indexTranslogOperations(
            super.cleanFiles(totalTranslogOps, globalCheckpoint, sourceMetadata, listener);
                    }  
            }
            shards.assertAllEqual(goodDocs);
                    equalTo(Math.toIntExact(totalDocs - 1 - safeCommitOnOldPrimary.get().localCheckpoint))
        }  
            releaseRecovery.countDown();
                                shards.index(new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON));
                });
            final IndexShard replica = shards.addReplica();  
                    });  
            if (randomBoolean()) {  
            // check that local checkpoint of new primary is properly tracked after primary promotion  
            @Override
 */
            RecoveryState.Stage.TRANSLOG,  
                shards.index(request); // deliver via normal replication
import static org.hamcrest.Matchers.lessThan;
                            } else {
            List<DocIdSeqNoAndSource> docsBelowGlobalCheckpoint = EngineTestCase.getDocIds(getEngine(newPrimary), randomBoolean())  
                thread.start();  
                    Versions.MATCH_ANY,  
 * ownership. Elasticsearch licenses this file to you under  
            final CountDownLatch recoveryBlocked = new CountDownLatch(1);
            for (int i = 0; i < numThreads; i++) {  
            shards.flush();
                @Override
                        throw new AssertionError(e);  
            int translogOperations = 0;
                assertThat(replica.getLocalCheckpoint(), lessThan(expectedDocs - 2));  
     * sequence-number based recovery is performed and the extra document does not remain after recovery.  
            Store.MetadataSnapshot sourceMetadata,
                false,
            boolean syncedGlobalCheckPoint = randomBoolean();
                blockIfNeeded(RecoveryState.Stage.TRANSLOG);
import org.opensearch.index.shard.IndexShardTestCase;
                }
                final BulkShardRequest bulkShardRequest = indexOnPrimary(indexRequest, oldPrimary);
            }
                        final long mappingVersion,
        }
            for (int i = 0; i < staleDocs; i++) {
            return InternalEngineTests.createInternalEngine((directory, writerConfig) -> new IndexWriter(directory, writerConfig) {  
                            replicaEngineFactory.awaitIndexersLatch();  
            final IndexShard oldPrimary = shards.getPrimary();  
                                throw new RuntimeException(e);
import org.opensearch.indices.recovery.RecoveryTarget;  
                newPrimary.flush(new FlushRequest());  
            int docs = shards.indexDocs(randomIntBetween(1, 10));  
                throw new AssertionError(e);
                        final long maxSeqNoOfUpdates,  
            // slip the extra document into the replica
import static org.hamcrest.Matchers.equalTo;
                        assertThat(  
            for (int i = 0; i < extraDocsToBeTrimmed; i++) {
            shards.startAll();
                equalTo(totalDocs - 1L)  
            ReplicationListener listener,
                threadPool.generic().submit(() -> {  
                        .put(IndexSettings.INDEX_TRANSLOG_RETENTION_AGE_SETTING.getKey(), "-1")
                assertThat(shards.getPrimary().getLocalCheckpoint(), equalTo(expectedDocs - 1));
import org.opensearch.cluster.metadata.IndexMetadata;
                        }
                }
                    .source("{ \"f\": \"normal\"}", MediaTypeRegistry.JSON);  
                        }
                                String id = Integer.toString(between(0, nextId));  
                )  
    public void testDoNotWaitForPendingSeqNo() throws Exception {
                            phaseTwoStartLatch.await();  
                            listener
        }  
            this.logger = logger;
            for (int i = 0; i < inFlightOps; i++) {
/*
            totalDocs += moreDocs;
            }  
 * software distributed under the License is distributed on an
                        shards.index(new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON));
            try (Translog.Snapshot snapshot = getTranslog(justReplica).newSnapshot()) {
            shards.promoteReplicaToPrimary(promotedReplica).get();
            shards.refresh("test");
 * this file be licensed under the Apache-2.0 license or a
            protected EngineFactory getEngineFactory(final ShardRouting routing) {
                }
            int initialDocs = randomInt(10);
                    assertBusy(() -> {  
            CountDownLatch pendingDocsDone = new CountDownLatch(pendingDocs);  
            }
                        if (replica == newPrimary) {
                            totalTranslogOps,  
                    threadPool
            blocks.forEach(CountDownLatch::countDown);  
            shards.flush();
import org.opensearch.action.admin.indices.forcemerge.ForceMergeRequest;
            shards.syncGlobalCheckpoint();
            shards.startAll();  
import java.util.concurrent.Future;
                        pendingDocsDone.countDown();  
                        // noinspection OptionalGetWithoutIsPresent since there must be at least one lease
                        super.indexTranslogOperations(
            thread.start();
            final Future<Void> recoveryFuture = shards.asyncRecoverReplica(
            logger.info("indexed [{}] docs", docs);
        }
        };  
                            }
import static org.hamcrest.Matchers.anyOf;
                        // replica swaps engine during rollback
                });
                threads.add(thread);
import org.opensearch.index.seqno.RetentionLeases;
                recoveryStart.countDown();
                assertThat(task.getResyncedOperations(), greaterThanOrEqualTo(extraDocs));
                    final CountDownLatch block = blockReference.get();  
                                shards.delete(new DeleteRequest(index.getName()).id(id));
                builder.settings(
                remainingReplica.getOperationPrimaryTerm(),
            remainingReplica.applyIndexOperationOnReplica(
 *  
                    Settings.builder()
            int docs = shards.indexDocs(randomInt(50));
    }
    }
                List<IndexShard> replicas = new ArrayList<>(shards.getReplicas());
            }  
        };  
            boolean expectSeqNoRecovery = (moreDocs == 0 || randomBoolean());  
                    IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        try (ReplicationGroup shards = createGroup(between(0, 1)); Releasable ignored = stopIndexing::run) {
            // simulate docs that were inflight when primary failed
                            int nextId = docId.incrementAndGet();
                        if (latch != null) {  
            }
                }
                indexOnReplica(bulkShardRequest, shards, justReplica);  
            assertThat(newReplica.recoveryState().getIndex().fileDetails(), empty());
            shards.startAll();
        IndexMetadata metadata = buildIndexMetadata(1);
                    // We also need to make sure that there is no retention lease holding on to any history. The lease for the old primary
            long globalCheckpoint,  
                );
 * Modifications Copyright OpenSearch Contributors. See
        }  
            for (int i = 0; i < extraDocs; i++) {
            IndexShard newPrimary = randomFrom(shards.getReplicas());  
                shards.syncGlobalCheckpoint();
        @Override  
                        newPrimary.syncRetentionLeases();
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.indices.recovery.RecoveryState;
    public void testRecoveryAfterPrimaryPromotion() throws Exception {
            remainingReplica.store().close();
            shards.syncGlobalCheckpoint();
import java.util.stream.Collectors;  
                    logger,
        @Override
            final int indexedDuringRecovery = shards.indexDocs(randomInt(5));  
        public void awaitIndexersLatch() throws InterruptedException {
            IndexShard oldPrimary = shards.getPrimary();
            replica.close("recover replica - first time", false, false);
            shards.assertAllEqual(initDocs + inFlightOpsOnNewPrimary);
                remainingReplica.getLocalCheckpoint() + 1,
            AtomicBoolean recoveryDone = new AtomicBoolean(false);  
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("extra_trimmed_" + i)
                            throw new AssertionError(e);  
                            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            logger.info("--> resyncing replicas seqno_stats primary {} replica {}", oldPrimary.seqNoStats(), newPrimary.seqNoStats());  
            primaryEngineFactory.close();
                shards.index(new IndexRequest(index.getName()).id("last").source("{}", MediaTypeRegistry.JSON));
import org.opensearch.index.seqno.RetentionLease;  
            pendingDocDone.await();
                    newReplica.recoveryState().getTranslog().recoveredOperations(),
                replicas.remove(newPrimary);
        private final Logger logger;  
                                shards.getPrimary().flush(new FlushRequest());
            pendingDocsDone.await();  
                }  
                assertBusy(() -> {  
            RecoveryState.Stage.INDEX,
            try {
                        try {
            final Future<Void> recoveryFuture = shards.asyncRecoverReplica(
            int numThreads = between(1, 3);
                maxAutoIdTimestamp,
            );  
                final String id = "pending_" + i;
     */
                    .source("{ \"f\": \"trimmed\"}", MediaTypeRegistry.JSON);  
            oldPrimary.store().close();
            // simulate docs that were inflight when primary failed, these will be rolled back
                assertThat(shards.getPrimary().getLastKnownGlobalCheckpoint(), equalTo(expectedDocs - 1));
        }
            final long maxSeqNoOfUpdates,
                }
                assertThat(newReplica.recoveryState().getIndex().fileDetails(), not(empty()));
        ) {
 * this work for additional information regarding copyright
 */  
            shards.syncGlobalCheckpoint();
    public void testRollbackOnPromotion() throws Exception {  
        static final EnumSet<RecoveryState.Stage> SUPPORTED_STAGES = EnumSet.of(
            assertThat(replica1.getMaxSeenAutoIdTimestamp(), equalTo(maxTimestampOnReplica1));
            final CountDownLatch pendingDocDone = new CountDownLatch(1);  
                throw new UnsupportedOperationException(stageToBlock + " is not supported");  
        public Engine newReadWriteEngine(final EngineConfig config) {
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
                    // the global checkpoint advances can only advance here if a background global checkpoint sync fires
            assertThat(newPrimary.getLocalCheckpoint(), equalTo(totalDocs - 1L));
                                .mapToLong(RetentionLease::retainingSequenceNumber)
                            } catch (final Exception e) {
import org.apache.logging.log4j.Logger;
            if (currentStage == stageToBlock) {  
                            if (appendOnly) {
        }) {
                final IndexRequest indexRequest = new IndexRequest(index.getName()).id("stale_" + i).source("{}", MediaTypeRegistry.JSON);
            this.stageToBlock = stageToBlock;  
/*  
        List<Thread> threads = new ArrayList<>();
            }
import org.opensearch.core.common.bytes.BytesArray;  
                indexRequest.process(Version.CURRENT, null, index.getName());
                shard.flush(new FlushRequest().force(true).waitIfOngoing(true));
        private final AtomicReference<CountDownLatch> blockReference = new AtomicReference<>();  
            docs += shards.indexDocs(randomInt(20));
        try (ReplicationGroup shards = createGroup(between(2, 3))) {
                recoveryBlocked.countDown();
                        final List<Translog.Operation> operations,  
        public synchronized void latchIndexers(int count) {  
                assertThat(shards.getPrimary().getLocalCheckpoint(), equalTo(expectedDocs - 1));  
                    false  
                    assertThat("unexpected op: " + next, (int) next.seqNo(), lessThan(initialDocs + extraDocs));  
            IndexShard replica = shards.addReplica();  
                                .min()
            assertThat(pendingDocDone.getCount(), equalTo(1L));
            long globalCheckpointOnOldPrimary = oldPrimary.getLastSyncedGlobalCheckpoint();  
                uncommittedOpsOnPrimary = shards.indexDocs(randomIntBetween(0, 10));
            IndexShard newReplica = shards.addReplica();
            }
                }
            docs += pendingDocs;
                totalDocs += uncommittedOpsOnPrimary;  
                    .getLocalCheckpoint(),
                            if (randomInt(100) < 10) {  
        private void blockIfNeeded(RecoveryState.Stage currentStage) {
            shards.assertAllEqual(initDocs + inFlightOpsOnNewPrimary + moreDocsAfterRollback);  
            blockedIndexers.get().await();
            shards.syncGlobalCheckpoint();  
            logger.info("--> indexing {} stale docs", staleDocs);  
                }
                    newPrimary.flush(new FlushRequest().force(true));
            shards.assertAllEqual(goodDocs);  
            );
            primaryEngineFactory.allowIndexing();
                            maxAutoIdTimestamp,
                    maxTimestampOnReplica2 = Math.max(maxTimestampOnReplica2, indexRequest.getAutoGeneratedTimestamp());
 * not use this file except in compliance with the License.
                IndexRequest primaryRequest = new IndexRequest(index.getName()).id(id).source("{}", MediaTypeRegistry.JSON);  
            });
 * KIND, either express or implied.  See the License for the
        try (ReplicationGroup shards = createGroup(randomInt(1))) {
                    try {
        try (ReplicationGroup shards = createGroup(2)) {  
            // now recovery can finish
            // As a replica keeps a safe commit, the file-based recovery only happens if the required translog
                    recoveryListener,  
            }
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.IndexableField;  
                    }
            thread.join();
            assertThat(replica2.getMaxSeenAutoIdTimestamp(), equalTo(maxTimestampOnReplica1));
                    oldPrimary.flush(new FlushRequest(index.getName()));  
 * compatible open source license.
            final IndexShard oldPrimary = shards.getPrimary();
        try (ReplicationGroup shards = createGroup(2)) {  
 * license agreements. See the NOTICE file distributed with
            assertThat(recoveredReplica.recoveryState().getIndex().fileDetails(), empty());  
                    final IndexRequest indexRequest = new IndexRequest(index.getName()).id("rollback_" + i)  
            // wait for the translog phase to complete and the recovery to block global checkpoint advancement
            if (syncedGlobalCheckPoint) {
                    while (stopped.get() == false) {
            }
            for (int i = 0; i < docs; i++) {  
                for (int i = 0; i < rollbackDocs; i++) {
                // have to replicate to another replica != newPrimary one - the subject to trim
                uncommittedOpsOnPrimary = 0;
import org.opensearch.action.delete.DeleteRequest;  
        }
 *
                newPrimary.flush(new FlushRequest().force(true));
                    try {
    }  
                            mappingVersion,
                (indexShard, node) -> new BlockingTarget(  
            shards.promoteReplicaToPrimary(replica1).get();
            shards.startAll();  
            shards.startAll();
            int uncommittedOpsOnPrimary = 0;
                };  
                Translog.Operation next;  
                    assertThat(source.source.utf8ToString(), is("{ \"f\": \"normal\"}"));  
        final BlockingEngineFactory primaryEngineFactory = new BlockingEngineFactory();
    public static class BlockingTarget extends RecoveryTarget {
                    throw new RuntimeException("blockage released");
                .findSafeIndexCommit(globalCheckpointOnOldPrimary);
            DiscoveryNode sourceNode,
        private boolean hasBlocked() {
import org.opensearch.threadpool.ThreadPool;
            // randomly introduce a conflicting document
    public void testAddNewReplicas() throws Exception {  
                            latch.countDown();
        final BlockingEngineFactory replicaEngineFactory = new BlockingEngineFactory();
            closeShards(replica);
        try (ReplicationGroup shards = new ReplicationGroup(buildIndexMetadata(2, mappings))) {  
     * failure, the receiving replica misses the primary/replica re-sync and then recovers from the primary. We expect that a
                            inFlightOpsOnNewPrimary++;  
            long maxTimestampOnReplica2 = -1;  
            recoveryStart.await();  
    public void testReplicaRollbackStaleDocumentsInPeerRecovery() throws Exception {
    }
            assertBusy(() -> assertThat(docId.get(), greaterThanOrEqualTo(50)), 60, TimeUnit.SECONDS); // we flush quite often
                    releaseRecovery,  
        }
